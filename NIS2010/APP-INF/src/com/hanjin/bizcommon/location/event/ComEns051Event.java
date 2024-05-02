/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : COM_ENS_051Event.java
*@FileTitle : Location조회(공통 Popup)
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-03
*@LastModifier : HyungChoonRoh
*@LastVersion : 1.0
* 2006-08-03 HyungChoonRoh
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.location.event;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * COM_ENS_051 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - COM_ENS_051HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HyungChoonRoh
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */public class ComEns051Event extends EventSupport {

	private String locCd = null;
    private String locNm = null;
    private String unLocIndCd = null;
    private String cntCd = null;
    private String locEqOfc = null;    
    private String select = null;
    private String rccCd = null;
    private String lccCd = null;
    private String locState = null;
    public String getLocState() {
		return locState;
	}

	public void setLocState(String locState) {
		this.locState = locState;
	}

	private int iPage = 0;
    
    /**
     * Constructor<br>
     */
    public ComEns051Event(){}
 
	/**
     * Event 명을 반환<br>
     * @return String
     */
	public String getEventName() {
        return "ComEns051Event";
    }

	/**
     * Class 명을 반환<br>
     * @return String
     */
    public String toString() {
        return "ComEns051Event";
    }

	public String getLocCd() {
		return locCd;
	}

	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}

	public String getLocNm() {
		return locNm;
	}

	public void setLocNm(String locNm) {
		this.locNm = locNm;
	}

	public String getUnLocIndCd() {
		return unLocIndCd;
	}

	public void setUnLocIndCd(String unLocIndCd) {
		this.unLocIndCd = unLocIndCd;
	}

	public String getCntCd() {
		return cntCd;
	}

	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}

	public String getLocEqOfc() {
		return locEqOfc;
	}

	public void setLocEqOfc(String locEqOfc) {
		this.locEqOfc = locEqOfc;
	}

	public int getIPage() {
		return iPage;
	}

	public void setIPage(int page) {
		iPage = page;
	}

	public String getSelect() {
		return select;
	}

	public void setSelect(String select) {
		this.select = select;
	}

	public String getRccCd() {
		return rccCd;
	}

	public void setRccCd(String rccCd) {
		this.rccCd = rccCd;
	}

	public String getLccCd() {
		return lccCd;
	}

	public void setLccCd(String lccCd) {
		this.lccCd = lccCd;
	}

}
