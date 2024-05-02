/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_EAS_002Event.java
*@FileTitle : Route UnMatch List
*Open Issues :
*Change history :
*@LastModifyDate : 2008-01-30
*@LastModifier : ho-sam lee
*@LastVersion : 1.0
* 2008-01-30 ho-sam lee
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.eas.transportmanage.event;

import com.clt.framework.support.layer.event.EventSupport;

/**
 * EsdEas0002Event PDTO(Data Transfer Object including Parameters)<br>
 * @author ho-sam lee
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class EsdEas0002Event extends EventSupport {

  
	private String ctrlOfcCd="";
	private String sBnd="";
	private String org="";
	private String dest="";
	private String searchChoice="";
	private String somonth="";
	private String fromsodate="";
	private String port="";
	
	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}	
	public String getCtrlOfcCd() {
		return ctrlOfcCd;
	}

	public void setCtrlOfcCd(String ctrlOfcCd) {
		this.ctrlOfcCd = ctrlOfcCd;
	}

	public String getSBnd() {
		return sBnd;
	}

	public void setSBnd(String bnd) {
		sBnd = bnd;
	}

	public String getOrg() {
		return org;
	}

	public void setOrg(String org) {
		this.org = org;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

	public String getSearchChoice() {
		return searchChoice;
	}

	public void setSearchChoice(String searchChoice) {
		this.searchChoice = searchChoice;
	}

	public String getSomonth() {
		return somonth;
	}

	public void setSomonth(String somonth) {
		this.somonth = somonth;
	}

	public String getFromsodate() {
		return fromsodate;
	}

	public void setFromsodate(String fromsodate) {
		this.fromsodate = fromsodate;
	}

	public String getTosodate() {
		return tosodate;
	}

	public void setTosodate(String tosodate) {
		this.tosodate = tosodate;
	}

	private String tosodate="";

    /**
     * 이벤트 명(ESD_EAS_002Event)을 반환
     *
     * @return response String
     */
    public String getEventName() {
        return "EsdEas0002Event";
    }

    /**
     * 객체 표현 문자열(ESD_EAS_002Event)을 반환
     *
     * @return response String
     */
    public String toString() {
        return "EsdEas0002Event";
    }


}
