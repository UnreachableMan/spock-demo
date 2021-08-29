import com.spock.demo.dto.OrderDto
import com.spock.demo.enums.OrderTypeEnum
import com.spock.demo.exception.OrderException
import com.spock.demo.handler.Handler
import com.spock.demo.param.OrderCreateParam
import com.spock.demo.service.impl.OrderServiceImpl
import spock.lang.Specification
import spock.lang.Unroll

class OrderServiceSpec extends Specification {

    OrderServiceImpl orderService = new OrderServiceImpl()
    Handler handlerMock = Mock()


    @Unroll
    def "创建订单成功"() {

        given: "初始化变量"
        orderService.handler = handlerMock
        when: "创建订单"
        def orderId = orderService.createOrder(createParam)

        then: "对方法调用情况进行判断"

        orderId > 0
        //方法的调用次数只能统计orderService内层变量对应的方法调用，而不能是orderService自己的方法被调用了多少次，因为它不是Mock的，没有走spock托管的
        count1 * handlerMock.handler1({ Long userId -> userId == createParam.userId })
        count2 * handlerMock.handler2({
            verifyAll(it, OrderDto) {
                type == createParam.type
                price == createParam.price
                items == createParam.items
            }
        } as OrderDto)
        count3 * handlerMock.handler3()
        count4 * handlerMock.handler4()

        where:
        count1 | count2 | count3 | count4 || createParam

        //主要校验调用次数是否一致
        1      | 0      | 0      | 0      || new OrderCreateParam(type: OrderTypeEnum.TYPE1, userId: 000002L, items: ["aaa"], price: new BigDecimal(1))
        0      | 1      | 0      | 0      || new OrderCreateParam(type: OrderTypeEnum.TYPE2, userId: 000002L, items: ["aaa"], price: new BigDecimal(1))
        0      | 0      | 1      | 0      || new OrderCreateParam(type: OrderTypeEnum.TYPE3, userId: 000002L, items: ["aaa"], price: new BigDecimal(1))
        0      | 0      | 0      | 1      || new OrderCreateParam(type: OrderTypeEnum.TYPE4, userId: 000002L, items: ["aaa"], price: new BigDecimal(1))
    }

    @Unroll
    def "创建订单失败的场景"() {

        given: "初始化变量"
        orderService.handler = handlerMock

        when: "创建订单"
        orderService.createOrder(createParam)

        then: "对执行中的预期异常进行判断"
        def e = thrown(exName)
        e.message == exValue

        where: "||左侧为then语句断言参数，||右侧的为执行当前调用所需要的参数"
        exName           | exValue  || createParam

        //参数缺少时，报异常场景
        RuntimeException | "参数不合法"  || new OrderCreateParam(type: OrderTypeEnum.TYPE1, userId: 000002L, items: [], price: new BigDecimal(1))
        RuntimeException | "参数不合法"  || new OrderCreateParam(type: null, userId: 000002L, items: ["aaa"], price: new BigDecimal(1))
        OrderException   | "订单类型异常" || new OrderCreateParam(type: OrderTypeEnum.TYPE5, userId: 000002L, items: ["aaa"], price: new BigDecimal(1))

    }


}
