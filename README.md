# 디자인 패턴

> **디자인 패턴이란?**

* 자주 사용하는 설계 패턴을 정형화 해서 이를 유형별로 가장 최적의 방법으로 개발 할 수 있도록 정해둔 설계.
기본적으로 알고리즘과 유사하지만 명확하게 정답이 존재하는 형태는 아니다.

* Gof(Gang of Four) 디자인 패턴
객체지향 개념에 따른 설계 중 재사용할 경우 유용한 설계를 디자인 패턴으로 정리해둔 것.(총 23개로 구성)

> **디자인 패턴의 장점**

- 개발자, 설계자 간의 원활한 소통
- S/W 구조 파악 용이
- 재사용성을 통한 개발 시간 단축
- 설계 변경 요청에 대한 유연한 대처

> **디자인 패턴의 단점**

- 객체 지향 설계/구현 
-> 모든 개발자가 객체 지향을 이해하고 있지는 않다.😂 🤣
- 초기 투자 비용 부담


> **디자인패턴의 분류**

[1]. 생성 패턴
: 객체를 생성하는 것과 관련된 패턴
- Factory Method
- <font color="red">**Signleton**</font>
- Prototype
- <font color="red">**Builder**</font>
- Abstract Factory
- <font color="red">**Chaining**</font>


[2]. 구조 패턴
: 프로그램 내의 자료구조나 인터페이스 구조 등 프로그램 구조를 설계하는데 활용 될 수 있는 패턴
- <font color="red">**Adaptor**</font>
- Composite
- Bridge
- <font color="red">**Decorator**</font>
- <font color="red">**Facade**</font>
- Flyweight
- <font color="red">**Proxy**</font>

[3]. 행위 패턴
: 반복적으로 사용되는 객체들의 상호작용을 패턴화 한 것

- Template Method
- Interpreter
- Iterator
- <font color="red">**Observer**</font>
- <font color="red">**Strategy**</font>
- Visitor
- Chain of reponsibility
- Command
- Mediator
- State
- Memento
<hr>

## 1. 싱글톤 패턴(Singleton Pattern)
: 어떠한 클래스(객체)가 유일하게 1개만 존재할 때 사용한다.
: 주로 자원을 공유할 때 사용된다.
(주로 서버와 Socket Connect.., 스프링의 Bean)

```
public class SocketClient {

    private static SocketClient socketClient = null;

    private SocketClient() {}

    public static SocketClient getInstance() {
        if (socketClient == null) {
            socketClient = new SocketClient();
        }
        return socketClient;
    }

    public void connect() {
        System.out.println("connect");
    }
```

## 2. 어댑터 패턴(Adaptor Pattern)
: 호환성이 없는 기존 클래스의 인터페이스를 변환하여 재사용 할 수 있도록 한다.
: SOLID 중에서 개방폐쇄 원칙(OCP)를 따른다.

```
public class AdaptorSocket implements Electornic110V {

    private Electornic220V electornic220V;

    public AdaptorSocket(Electornic220V electornic220V) {
        this.electornic220V = electornic220V;
    }

    @Override
    public void powerOn() {
        electornic220V.connect();
    }
```

## 3.프록시 패턴(Proxy Pattern)
: Proxy는 대리인이라는 뜻으로, 뭔가를 대신해서 처리하는 패턴을 말한다.
: SOLID중 개방폐쇄 원칙과 의존 역전 원칙을 따른다.

- 스프링은 AOP에서 프록시 패턴을 사용한다.

```
@Override
    public Html show() {

        if(html == null) {
            html = new Html(url);
            System.out.println("ProxyBrowser loading html : " + url);
        }
        System.out.println("ProxyBrowser use cache html : " + url);
        return html;
    }
```

## 4.데코레이터 패턴(Decorator Pattern)
: 기존 뼈대(클래스)는 유지하되, 이후 필요한 형태를 꾸밀 때 사용.
: 확장이 필요한 경우 상속의 대안으로 활용한다.
: SOLID 중 개방폐쇄 원칙(OCP) 와 의존 역전 원칙(DIO)를 따른다.

```
public class AudiDecorator implements ICar {

    protected ICar audi;
    protected String modelName;
    protected int modelPrice;

    public AudiDecorator(ICar audi, String modelName, int modelPrice){
        this.audi = audi;
        this.modelName = modelName;
        this.modelPrice = modelPrice;
    }

    @Override
    public int getPrice() {
        return audi.getPrice() + this.modelPrice;
    }

    @Override
    public void showPrice() {
        System.out.println("Audi " + this.modelPrice + " Price is " + getPrice());
    }
}

```


## 5.옵저버 패턴(Observer Pattern)
: 변화가 일어났을 때, 미리 등록된 다른 클래스에 통보해주는 패턴을 구현한 것.
: event listner가 대표적인 사용 예이다.

```
public class Button {

    private String name;
    private IButtonlistner buttonlistner;

    public Button(String name) {
        this.name = name;
    }

    public void click(String message) {
        buttonlistner.clickEvent(message);
    }

    public void addListner(IButtonlistner buttonlistner) {
        this.buttonlistner = buttonlistner;
    }
}

// Interface
public interface IButtonlistner {

    void clickEvent(String event);

}

// Main
public class ButtonMain {

    public static void main(String[] args) {

        Button button = new Button("Button");
        button.addListner(new IButtonlistner() {
            @Override
            public void clickEvent(String event) {
                System.out.println(event);
            }
        });
        button.click("click 1 send a message.");
        button.click("click 2 send a message.");
        button.click("click 3 send a message.");
    }
}
```

## 7.파사드 패턴(Facade Pattern)
: 건물의 앞쪽 정면이라는 뜻
: 여러개의 객체와 실제 사용하는 서브 객체 사이에 복잡한 의존관계가 있을 때, 중간에 facade라는 객체를 두고, 여기서 제공하는 interface만을 활용하여 기능을 사용하는 방식.


```

public class SFtpClient {

    private FTP ftp;
    private Reader reader;
    private Writer writer;

    public SFtpClient(FTP ftp, Reader reader, Writer writer) {
        this.ftp = ftp;
        this.reader = reader;
        this.writer = writer;
    }

    public SFtpClient(String host, int port, String path, String fileName) {
        this.ftp = new FTP(host, port, path);
        this.reader = new Reader(fileName);
        this.writer = new Writer(fileName);
    }

    public void connect() {
        ftp.connect();;
        ftp.moveDirectory();
        writer.fileConnect();
        reader.fileConnect();
    }

    public void disconnect() {
        reader.fileConnect();
        writer.fileDisconnect();
        ftp.disConnect();
    }

    public void read() {
        reader.fileRead();
    }

    public void write() {
        writer.fileWrite();
    }
```

## 8.전략 패턴(Strategy Pattern)
: 객체지향의 꽃이
: 유사한 행위들을 캡슐화하여, 객체의 행위를 바꾸고 싶은 경우 직접 변경하는 것이 아닌 전략만 변경하여 유연하게 확장하는 패턴
: SOLID 중에서 개방폐쇄 원칙(OCP)과 의존 역전 원칙(DIP)을 따른다.
```

public class Encoder {

    private EncodingStrategy encodingStrategy;

    public String getMessage(String message) {
        return this.encodingStrategy.encode(message);
    }

    public void setEncodingStrategy(EncodingStrategy encodingStrategy) {
        this.encodingStrategy = encodingStrategy;
    }
}

```
