/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : HMEnumeration.java
*@FileTitle : Enumeration 정보
*Open Issues :
*Change history :
*@LastModifyDate : 2007-04-12
*@LastModifier : common team
*@LastVersion : 1.0
* 2007-04-12 common team
* 1.0 최초 생성
=========================================================*/

package com.hanjin.apps.alps.esd.trs.servicesio.common.util;
import java.util.Enumeration;
import java.util.Iterator;

/**
 * To change the template for this generated type comment go to<br>
 * Window - Preferences - Java - Code Style - Code Templates<br>
 * hashMap에서는 Enumeration유형을 반환하지 않으므로 iterator을 이용하게 외부 인터페이스만 동일하게 조정함<br>
 * 
 * @author user
 * @see  참조
 * @since J2EE 1.4
 */
public class HMEnumeration implements Enumeration {

//	map의 자료유형을 iterator을 구현한 객체로 변환하여 반환
	Iterator  valueList;
	//다음값이 있는지 여부를 리턴
	boolean isNext;
	//map의 객체를 리턴해주는 타입
	Object returnObject;

    /**
     * /map 형태를 iterator 형태를 구현한 클래스로 변환하여 반환
     * @param he HashMapEnumeration
     * @return
     */
	public HMEnumeration( HashMapEnumeration he )
	{
		valueList=(he.values()).iterator(); 		
	}
    /**
     * 기존 함수와 최대한 동일하게(Enumeration)
     * @return
     */
	public boolean hasMoreElements()
	{		
		isNext=valueList.hasNext();
		return isNext;
	}
	
	
    /**
     * 기존 함수와 최대한 동일하게(Enumeration)
     * @return
     */
	public Object nextElement() 	
	{
		returnObject=valueList.next();
		return returnObject;
	}
	
	
}
