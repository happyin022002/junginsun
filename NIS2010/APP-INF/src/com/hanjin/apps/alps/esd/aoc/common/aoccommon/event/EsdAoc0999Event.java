/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsdAoc0999Event.java
*@FileTitle : Common
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
* 1.0 Creation 최초생성
* ---------------------------------------------------------
* History
* 2012.10.04 변종건 [CHM-201220395] Add-on Tariff Management 개선 프로젝트
* 2015.03.06 최성환 [CHM-201534710] AOC 2차 소스 보안 품질 진행 요청
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.common.aoccommon.event;

import java.util.HashMap;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TrsTrspSvcOrdVO;


/**
 * ESD_AOC_0999 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_AOC_0999HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Min Jung Ho
 * @see ESD_AOC_0999HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdAoc0999Event extends EventSupport {

	//AocComboVO[] AocComVOs=null;
	
	/**
	 * EsdAoc0999Event.java
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
	
	private String ctrl_so_office = "";
	
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
	
	public EsdAoc0999Event(){}

	public String getEventName() {
		return "EsdAoc0999Event";
	}

	public String toString() {
		return "EsdAoc0999Event";
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
	
	public String getCtrl_so_office() {
		return ctrl_so_office;
	}

	public void setCtrl_so_office(String ctrl_so_office) {
		this.ctrl_so_office = ctrl_so_office;
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
		TrsTrspSvcOrdVO[] rtnVOs = null;
		if (this.trsTrspSvcOrdVOs != null) {
			rtnVOs = new TrsTrspSvcOrdVO[trsTrspSvcOrdVOs.length];
			System.arraycopy(trsTrspSvcOrdVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param trsTrspSvcOrdVOs the trsTrspSvcOrdVOs to set
	 */
	public void setTrsTrspSvcOrdVOS(TrsTrspSvcOrdVO[] trsTrspSvcOrdVOs){
		if(trsTrspSvcOrdVOs != null){
			TrsTrspSvcOrdVO[] tmpVOs = new TrsTrspSvcOrdVO[trsTrspSvcOrdVOs.length];
			System.arraycopy(trsTrspSvcOrdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.trsTrspSvcOrdVOs = tmpVOs;
		}
	}	
	
}