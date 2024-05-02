/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdEas0009Event.java
*@FileTitle : Drop-off Charge Collection Performance
*Open Issues :
*Change history :
*@LastModifyDate : 2008-01-30
*@LastModifier : ho-sam lee
*@LastVersion : 1.0
* 2008-01-30 ho-sam lee
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.transportmanage.event;

import java.util.HashMap;

import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EsdEas0009Event ���� PDTO(Data Transfer Object including Parameters)<br>
 * @author ho-sam lee
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class EsdEas0009Event extends EventSupport {

	/** JSP에서 넘어온 파라마메터를 저장하는 */
	private String ctrlOfcCd   = null;
	private String searchChoice = null;
	private String fromtrodate   = null;
	private String totrodate     = null;
	private String location      = null;
	private String haulCd      = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	
	/**
     * 생성자<br>
     */
    public EsdEas0009Event() {

    }



	public String getCtrlOfcCd() {
		return ctrlOfcCd;
	}



	public void setCtrlOfcCd(String ctrlOfcCd) {
		this.ctrlOfcCd = ctrlOfcCd;
	}



	public String getSearchChoice() {
		return searchChoice;
	}



	public void setSearchChoice(String searchChoice) {
		this.searchChoice = searchChoice;
	}



	public String getFromtrodate() {
		return fromtrodate;
	}


	public void setFromtrodate(String fromtrodate) {
		this.fromtrodate = fromtrodate;
	}


	public String getTotrodate() {
		return totrodate;
	}


	public void setTotrodate(String totrodate) {
		this.totrodate = totrodate;
	}


	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getHaulCd() {
		return haulCd;
	}

	public void setHaulCd(String haulCd) {
		this.haulCd = haulCd;
	}
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ctrl_ofc_cd"   , getCtrlOfcCd());
		this.hashColumns.put("search_choice" , getSearchChoice());
		this.hashColumns.put("fromtrodate"   , getFromtrodate());
		this.hashColumns.put("totrodate"     , getTotrodate());
		this.hashColumns.put("location"      , getLocation());
		this.hashColumns.put("haul_cd"       , getHaulCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ctrl_ofc_cd"   , "ctrl_ofc_cd"  );
		this.hashFields.put("search_choice" , "search_choice");
		this.hashFields.put("fromtrodate"   , "fromtrodate"  );
		this.hashFields.put("totrodate"     , "totrodate"    );
		this.hashFields.put("location"      , "location"     );
		this.hashFields.put("haul_cd"       , "haul_cd"      );
		return this.hashFields;
	}
	

	/**
     * 이벤트 명(EsdEas0009Event)을 반환
     *
     * @return response String
     */
    public String getEventName() {
        return "EsdEas0009Event";
    }

    /**
     * 객체 표현 문자열(EsdEas0009Event)을 반환
     *
     * @return response String
     */
    public String toString() {
        return "EsdEas0009Event";
    }


}
