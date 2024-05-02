/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_EAS_001Event.java
*@FileTitle : Rehandling Expense & TPB Check
*Open Issues :
*Change history :
*@LastModifyDate : 2008-01-04
*@LastModifier : Jun Ho Kim
*@LastVersion : 1.0
* 2008-01-04 Jun Ho Kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.terminalmanage.event;

import java.util.Collection;

import com.hanjin.apps.alps.esd.eas.common.util.RequestDataSet;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_EAS_001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_EAS_001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jun Ho Kim
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdEas0001Event extends EventSupport {
	private String port = "";
	private String fmMonth = "";
	private String toMonth = "";
	private String office = "";
	private String vvd = "";
	private String cntr_no = "";

    /**
     * 이벤트 명(EsdEas0001Event)을 반환
     *
     * @return response String
     */
    public String getEventName() {
        return "EsdEas0001Event";
    }

    public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getFmMonth() {
		return fmMonth;
	}

	public void setFmMonth(String fmMonth) {
		this.fmMonth = fmMonth;
	}

	public String getToMonth() {
		return toMonth;
	}

	public void setToMonth(String toMonth) {
		this.toMonth = toMonth;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getVvd() {
		return vvd;
	}

	public void setVvd(String vvd) {
		this.vvd = vvd;
	}

	public String getCntr_no() {
		return cntr_no;
	}

	public void setCntr_no(String cntr_no) {
		this.cntr_no = cntr_no;
	}

	/**
     * 객체 표현 문자열(EsdEas0001Event)을 반환
     *
     * @return response String
     */
    public String toString() {
        return "EsdEas0001Event";
    }

}
