/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_EAS_003Event.java
*@FileTitle : Special S/O Check - Supplement & Other
*Open Issues :
*Change history :
*@LastModifyDate : 2007-12-14
*@LastModifier : Jun Ho Kim
*@LastVersion : 1.0
* 2007-12-14 Jun Ho Kim
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.eas.transportmanage.event;

import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESD_EAS_0003EventPDTO(Data Transfer Object including Parameters)<br>
 * @author jhkim
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class EsdEas0003Event extends EventSupport {

	private String soOfcCd = null;
	private String bound = null;
	private String soMonth = null;
	private String fmSoDate = null;
	private String toSoDate = null;


    public String getSoOfcCd() {
		return soOfcCd;
	}

	public void setSoOfcCd(String soOfcCd) {
		this.soOfcCd = soOfcCd;
	}

	public String getBound() {
		return bound;
	}

	public void setBound(String bound) {
		this.bound = bound;
	}

	public String getSoMonth() {
		return soMonth;
	}

	public void setSoMonth(String soMonth) {
		this.soMonth = soMonth;
	}

	public String getFmSoDate() {
		return fmSoDate;
	}

	public void setFmSoDate(String fmSoDate) {
		this.fmSoDate = fmSoDate;
	}

	public String getToSoDate() {
		return toSoDate;
	}

	public void setToSoDate(String toSoDate) {
		this.toSoDate = toSoDate;
	}

	/**
     * 이벤트 명(ESD_EAS_003Event)을 반환
     *
     * @return response String
     */
    public String getEventName() {
        return "EsdEas0003Event";
    }

    /**
     * 객체 표현 문자열(ESD_EAS_003Event)을 반환
     *
     * @return response String
     */
    public String toString() {
        return "EsdEas0003Event";
    }


}
