package cn.sinosoft.testXml;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXException;

public class TestXmlClass  {

    public static void main(String[] args) {
        TestXmlClass testXmlClass= new TestXmlClass();
        testXmlClass.analysisXml();
    }
    public void analysisXml(){
        //创建待解析的XML文件，并指定目标
        File file=new File("D:\\user.xml");
        //用单例模式创建DocumentBuilderFactory对象
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        //声明一个DocumentBuilder对象
        DocumentBuilder documentBuilder =null;
        try {
            //通过DocumentBuilderFactory构建DocumentBuilder对象
            documentBuilder=factory.newDocumentBuilder();
            //DocumentBuilder解析xml文件
            Document document=documentBuilder.parse(file);
            //获得xml文档中的元素根元素
            Element root=document.getDocumentElement();
            //输出根元素的名称
            System.out.println("根元素："+root.getNodeName());
            //获得根元素下的子节点
            NodeList childNodes = root.getChildNodes();
            //遍历根元素下的子节点
            for(int i=0;i<childNodes.getLength();i++) {
                //获得根元素下的子节点
                Node node=childNodes.item(i);
                System.out.println("节点的名称为"+node.getNodeName());
                //获得子节点的country属性值
                String attributeV=node.getAttributes().getNamedItem("country").getNodeValue();
                System.out.println(node.getNodeName()+"节点的country属性值为"+attributeV);
                //获得node子节点下集合
                NodeList nodeChilds=node.getChildNodes();
                //遍历node子节点下集合
                for(int j=0;j<nodeChilds.getLength();j++) {
                    Node details=nodeChilds.item(j);
                    String name=details.getNodeName();
                    //判断如果是address元素，获取子节点
                    if("address".equals(name))
                    {
                        NodeList addressNodes=details.getChildNodes();
                        //遍历address元素子节点
                        for(int k=0;k<addressNodes.getLength();k++) {
                            Node addressDetail=addressNodes.item(k);
                            System.out.println(node.getNodeName()+"节点的子节点"+name+"点的子节点"+
                                    addressDetail.getNodeName()+" 节点内容为："+addressDetail.getTextContent());
                        }
                        String addressAtt=details.getAttributes().getNamedItem("state").getNodeValue();
                        System.out.println(name+"节点的state属性值为"+addressAtt);
                    }
                    System.out.println(node.getNodeName()+"节点的子节点"+details.getNodeName()+
                            "节点的内容为:"+details.getTextContent());
                }
            }
        }
        catch(ParserConfigurationException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (SAXException e)
        {
            e.printStackTrace();
        }
    }
}
