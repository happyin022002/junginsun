/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsdTrs0999Event.java
*@FileTitle : Common
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.19
*@LastModifier : 유선오
*@LastVersion : 1.3
* 2011.02.10 민정호
* 1.0 Creation 최초생성
* ---------------------------------------------------------
* * History
* 1.0 2011.02.10 민정호 [CHM-201108602] [TRS]미주지역 Appt./Deli. time update 기능 추가
* 1.1 2011.02.18 손은주 [CHM-201108834-01]	[TRS] Rail performance Report 부분의 주 단위 data 조회기능 추가 요청- 월별 주차별 검색기간 추가
* 1.2 2011.08.31 유선오 [CHM-201112874]	[TRS] OTHER/SO  Creation 화면 상 오류 수정요청 
* 1.3 2011.10.19  유선오 [CHM-201112874]	[TRS] OTHER S/O Creation 화면 상 오류 수정요청
* 2012.01.06 김종호 [CHM-201109410] [TRS] CNTR No. 유효성에 대한 Validation 절차 추가요청
=========================================================*/
package com.hanjin.apps.alps.esd.trs.common.trscommon.event;

import java.util.HashMap;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TrsTrspSvcOrdVO;


/**
 * ESD_TRS_0999 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TRS_0999HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Min Jung Ho
 * @see ESD_TRS_0999HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTrs0999Event extends EventSupport {

	//TrsComboVO[] TrsComVOs=null;
	
	/**
	 * EsdTrs0999Event.java
	 */
	private static final long serialVersionUID = 1L;

	private String ofcCd = "";
	
	private String fChkPrd = "";
	
	private String fYear = "";
	
	private String fFmMon = "";
	
	private String fToMon = "";
	
	private String fFmWk = "";
	
	private String fToWk = ""; 
	
	private String cmdtCd = "";
	
	private String custCd = "";
	
	private String row = "";
	
	private String iFmWm = "";
	
	private String iToWm = "";
	
	/** TrsTrspSvcOrdVO Table  Value Object */
	private TrsTrspSvcOrdVO trsTrspSvcOrdVO = null;
	
	/** TrsTrspSvcOrdVOs Multi Action을 위한 Array */
	private TrsTrspSvcOrdVO[] trsTrspSvcOrdVOs = null;
	
	
	public void setOfcCd(String ofcCd){
		this.ofcCd = ofcCd;
	}	
	
	public String getOfcCd() {
		return ofcCd;
	}	

	/** HASHPARAM을 대치할 파라미터 set/get START*/
	@SuppressWarnings("unchecked")
	private HashMap hashParam = new HashMap();
	
	public EsdTrs0999Event(){}

	public String getEventName() {
		return "EsdTrs0999Event";
	}

	public String toString() {
		return "EsdTrs0999Event";
	}

	public void setFChkPrd(String fChkPrd) {
		this.fChkPrd = fChkPrd;
	}

	public String getFChkPrd() {
		return fChkPrd;
	}

	public void setFYear(String fYear) {
		this.fYear = fYear;
	}

	public String getFYear() {
		return fYear;
	}

	public void setFFmMon(String fFmMon) {
		this.fFmMon = fFmMon;
	}

	public String getFFmMon() {
		return fFmMon;
	}

	public void setFToMon(String fToMon) {
		this.fToMon = fToMon;
	}

	public String getFToMon() {
		return fToMon;
	}

	public void setFFmWk(String fFmWk) {
		this.fFmWk = fFmWk;
	}

	public String getFFmWk() {
		return fFmWk;
	}

	public void setFToWk(String fToWk) {
		this.fToWk = fToWk;
	}

	public String getFToWk() {
		return fToWk;
	}

	public String getCmdtCd() {
		return cmdtCd;
	}

	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}
	
	public String getCustCd() {
		return custCd;
	}

	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}

	public String getIFmWm() {
		return iFmWm;
	}

	public void setIFmWm(String fmWm) {
		iFmWm = fmWm;
	}

	public String getIToWm() {
		return iToWm;
	}

	public void setIToWm(String toWm) {
		iToWm = toWm;
	}

	@SuppressWarnings("unchecked")
	public HashMap getHashParam() {
		return hashParam;
	}

	@SuppressWarnings("unchecked")
	public void setHashParam(HashMap hashParam) {
		this.hashParam = hashParam;
	}

	/**
	 * @return the row
	 */
	public String getRow() {
		return row;
	}

	/**
	 * @param row the row to set
	 */
	public void setRow(String row) {
		this.row = row;
	}

	/**
	 * @return the trsTrspSvcOrdVO
	 */
	public TrsTrspSvcOrdVO getTrsTrspSvcOrdVO() {
		return trsTrspSvcOrdVO;
	}

	/**
	 * @param trsTrspSvcOrdVO the trsTrspSvcOrdVO to set
	 */
	public void setTrsTrspSvcOrdVO(TrsTrspSvcOrdVO trsTrspSvcOrdVO) {
		this.trsTrspSvcOrdVO = trsTrspSvcOrdVO;
	}

	/**
	 * @return the trsTrspSvcOrdVOs
	 */
	public TrsTrspSvcOrdVO[] getTrsTrspSvcOrdVOS() {
		return trsTrspSvcOrdVOs;
	}

	/**
	 * @param trsTrspSvcOrdVOs the trsTrspSvcOrdVOs to set
	 */
	public void setTrsTrspSvcOrdVOS(TrsTrspSvcOrdVO[] trsTrspSvcOrdVOs) {
		this.trsTrspSvcOrdVOs = trsTrspSvcOrdVOs;
	}	
	
	
	
}