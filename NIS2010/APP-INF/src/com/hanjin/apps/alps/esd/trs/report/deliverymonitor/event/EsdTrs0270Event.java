/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsdTrs0270Event.java
*@FileTitle : Delivery Monitoring Detail
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.deliverymonitor.event;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_TRS_3023 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_3023HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0270Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsdTrs0270Event(){}
	private String sFromDt = null;
	private String sToDt = null;
	private String sOfcCd = null;
	private String sBndCd = null;
	private String sDoYn = null;
	private String sStsCd = null;
	private String sBkgNo = null;
	private String sCntrNo = null;
	private String sSoNo = null;
	private String sWoNo = null;	
	private String sFmLoc = null;
	private String sViaLoc = null;
	private String sToLoc = null;
	private String sDrLoc = null;
	private String sSoTpCd = null;
	private String sYrWeek = null;

	public String getsFromDt() {
		return sFromDt;
	}
	public void setsFromDt(String sFromDt) {
		this.sFromDt = sFromDt;
	}
	public String getsToDt() {
		return sToDt;
	}
	public void setsToDt(String sToDt) {
		this.sToDt = sToDt;
	}
	public String getsOfcCd() {
		return sOfcCd;
	}
	public void setsOfcCd(String sOfcCd) {
		this.sOfcCd = sOfcCd;
	}
	public String getsBndCd() {
		return sBndCd;
	}
	public void setsBndCd(String sBndCd) {
		this.sBndCd = sBndCd;
	}
	public String getsDoYn() {
		return sDoYn;
	}
	public void setsDoYn(String sDoYn) {
		this.sDoYn = sDoYn;
	}
	public String getsStsCd() {
		return sStsCd;
	}
	public void setsStsCd(String sStsCd) {
		this.sStsCd = sStsCd;
	}
	public String getsBkgNo() {
		return sBkgNo;
	}
	public void setsBkgNo(String sBkgNo) {
		this.sBkgNo = sBkgNo;
	}
	public String getsCntrNo() {
		return sCntrNo;
	}
	public void setsCntrNo(String sCntrNo) {
		this.sCntrNo = sCntrNo;
	}
	public String getsSoNo() {
		return sSoNo;
	}
	public void setsSoNo(String sSoNo) {
		this.sSoNo = sSoNo;
	}
	public String getsWoNo() {
		return sWoNo;
	}
	public void setsWoNo(String sWoNo) {
		this.sWoNo = sWoNo;
	}
	public String getsFmLoc() {
		return sFmLoc;
	}
	public void setsFmLoc(String sFmLoc) {
		this.sFmLoc = sFmLoc;
	}
	public String getsViaLoc() {
		return sViaLoc;
	}
	public void setsViaLoc(String sViaLoc) {
		this.sViaLoc = sViaLoc;
	}
	public String getsToLoc() {
		return sToLoc;
	}
	public void setsToLoc(String sToLoc) {
		this.sToLoc = sToLoc;
	}

	public String getsDrLoc() {
		return sDrLoc;
	}
	public void setsDrLoc(String sDrLoc) {
		this.sDrLoc = sDrLoc;
	}
	public String getsSoTpCd() {
		return sSoTpCd;
	}
	public void setsSoTpCd(String sSoTpCd) {
		this.sSoTpCd = sSoTpCd;
	}
	public String getsYrWeek() {
		return sYrWeek;
	}
	public void setsYrWeek(String sYrWeek) {
		this.sYrWeek = sYrWeek;
	}

}
