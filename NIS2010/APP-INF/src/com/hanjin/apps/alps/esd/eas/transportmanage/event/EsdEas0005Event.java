/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdEas0005Event.java
*@FileTitle : C/H Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2007-11-29
*@LastModifier : yujin
*@LastVersion : 1.0
* 2007-11-29 yujin
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.transportmanage.event;

import java.util.HashMap;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EsdEas0005Event PDTO(Data Transfer Object including Parameters)<br>
 * @author yujin
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class EsdEas0005Event extends EventSupport {

	/** JSP에서 넘어온 파라마메터를 저장하는  */
	
	private String bkgno = null;
	private String blno  = null;

	/**
     * 생성자<br>
     */
    public EsdEas0005Event() {
    }

    public String getBkgno() {
		return bkgno;
	}

	public void setBkgno(String bkgno) {
		this.bkgno = bkgno;
	}

	public String getBlno() {
		return blno;
	}

	public void setBlno(String blno) {
		this.blno = blno;
	}

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkgno", getBkgno());
		this.hashColumns.put("blno" , getBlno());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkgno", "bkgno");
		this.hashFields.put("blno" , "blno");
		return this.hashFields;
	}
	
	/**
     * 이벤트 명(EsdEas0005Event)을 반환
     *
     * @return response String
     */
    public String getEventName() {
        return "EsdEas0005Event";
    }

    /**
     * 객체 표현 문자열(ESD_EAS_005Event)을 반환
     *
     * @return response String
     */
    public String toString() {
        return "EsdEas0005Event";
    }
}
