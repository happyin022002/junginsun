/*=========================================================
 *@FileName : ESD_TRS_0234Event.java
 *@FileTitle : Agreement Rail Surcharge History
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011-05-11
 *@LastModifier : 민정호
 *@LastVersion : 1.1
 * 2010-05-25 pjy
 * 1.0 최초 생성
 * 
 * 1.1 2011.05.11 민정호 [CHM-201110223] USER 에 의한 AGMT HISTORY 관리를 위한 기능 추가요청
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event;

import java.util.HashMap;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TrsAgmtRailScgRtHisVO;

/**
 * ESD_TRS_0234 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_0234HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jong hyek choi
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0234Event extends EventSupport {
	/** trs_agmt_eq_rt_his Table  Value Object */
	private TrsAgmtRailScgRtHisVO trsAgmtRailScgRtHisVO = null;
	/** trs_agmt_eq_rt_hiss Multi Action을 위한 Collection */
	private TrsAgmtRailScgRtHisVO[] trsAgmtRailScgRtHisVOs = null;	
		
	/** getTrsAgmtRailScgRtHisVO*/
	public TrsAgmtRailScgRtHisVO getTrsAgmtRailScgRtHisVO(){
		return trsAgmtRailScgRtHisVO;
	}
	
	/** getTrsAgmtRailScgRtHisVOs*/
	public TrsAgmtRailScgRtHisVO[] getTrsAgmtRailScgRtHisVOS(){
		return trsAgmtRailScgRtHisVOs;
	}	
	
	
	private String fmYard		= null;	
	private String toYard		= null;
	private String fmEffDate	= null;
	private String toEffDate	= null;
	private String routeAll		= null;
	private String selScg		= null;
	
	private String agmtNoPop	= null;
	private String vndrSeqPop	= null;
	private String trspRailScgCdPop	= null;
	private String agmtRoutAllFlgPop = null;
	private String fmNodCdPop	= null;
	private String toNodCdPop	= null;
	private String cgoTpCdPop	= null;
	private String effectiveDate = null;
	private String deleteYn		 = null;
	private String fmAccountOfcCd		= null;	
	private String fmAccountUsrId		= null;		
	
	public EsdTrs0234Event(){}
	
	
	public String getFmYard() {
		return fmYard;
	}

	public void setFmYard(String fmYard) {
		this.fmYard = fmYard;
	}

	public String getToYard() {
		return toYard;
	}

	public void setToYard(String toYard) {
		this.toYard = toYard;
	}

	public String getFmEffDate() {
		return fmEffDate;
	}

	public void setFmEffDate(String fmEffDate) {
		this.fmEffDate = fmEffDate;
	}

	public String getToEffDate() {
		return toEffDate;
	}

	public void setToEffDate(String toEffDate) {
		this.toEffDate = toEffDate;
	}

	public String getAgmtNoPop() {
		return agmtNoPop;
	}


	public void setAgmtNoPop(String agmtNoPop) {
		this.agmtNoPop = agmtNoPop;
	}


	public String getVndrSeqPop() {
		return vndrSeqPop;
	}


	public void setVndrSeqPop(String vndrSeqPop) {
		this.vndrSeqPop = vndrSeqPop;
	}


	public String getTrspRailScgCdPop() {
		return trspRailScgCdPop;
	}


	public void setTrspRailScgCdPop(String trspRailScgCdPop) {
		this.trspRailScgCdPop = trspRailScgCdPop;
	}


	public String getAgmtRoutAllFlgPop() {
		return agmtRoutAllFlgPop;
	}


	public void setAgmtRoutAllFlgPop(String agmtRoutAllFlgPop) {
		this.agmtRoutAllFlgPop = agmtRoutAllFlgPop;
	}


	public String getFmNodCdPop() {
		return fmNodCdPop;
	}


	public void setFmNodCdPop(String fmNodCdPop) {
		this.fmNodCdPop = fmNodCdPop;
	}


	public String getToNodCdPop() {
		return toNodCdPop;
	}


	public void setToNodCdPop(String toNodCdPop) {
		this.toNodCdPop = toNodCdPop;
	}


	public String getCgoTpCdPop() {
		return cgoTpCdPop;
	}


	public void setCgoTpCdPop(String cgoTpCdPop) {
		this.cgoTpCdPop = cgoTpCdPop;
	}

	public String getRouteAll() {
		return routeAll;
	}


	public void setRouteAll(String routeAll) {
		this.routeAll = routeAll;
	}


	public String getSelScg() {
		return selScg;
	}


	public void setSelScg(String selScg) {
		this.selScg = selScg;
	}
	
	public String getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	
	public String getDeleteYn() {
		return deleteYn;
	}

	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}		
	
	public String getFm_Account_Usr_Id() {
		return fmAccountUsrId;
	}

	public void setFm_Account_Usr_Id(String fmAccountUsrId) {
		this.fmAccountUsrId = fmAccountUsrId;
	}	

	public String getFm_Account_Ofc_Cd() {
		return fmAccountOfcCd;
	}

	public void setFm_Account_Ofc_Cd(String fmAccountOfcCd) {
		this.fmAccountOfcCd = fmAccountOfcCd;
	}	
	
	
	/**	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		
		this.hashColumns.put("fmYard", 	this.getFmYard());
		this.hashColumns.put("toYard", 	this.getToYard());
		this.hashColumns.put("fmEffDate",	this.getFmEffDate());
		this.hashColumns.put("toEffDate", 	this.getToEffDate());
		this.hashColumns.put("agmtNoPop", 	this.getAgmtNoPop());
		this.hashColumns.put("vndrSeqPop", 	this.getVndrSeqPop());
		this.hashColumns.put("trspRailScgCdPop",	this.getTrspRailScgCdPop());
		this.hashColumns.put("agmtRoutAllFlgPop", 	this.getAgmtRoutAllFlgPop());
		this.hashColumns.put("fmNodCdPop", 	this.getFmNodCdPop());
		this.hashColumns.put("toNodCdPop", 	this.getToNodCdPop());
		this.hashColumns.put("cgoTpCdPop",	this.getCgoTpCdPop());
		this.hashColumns.put("routeAll", 	this.getRouteAll());
		this.hashColumns.put("selScg",	this.getSelScg());
		this.hashColumns.put("effectiveDate",	this.getEffectiveDate());
		this.hashColumns.put("deleteYn",	this.getDeleteYn());		
				
		return this.hashColumns;
	}
	


	public void setTrsAgmtRailScgRtHisVOS(TrsAgmtRailScgRtHisVO[] trsAgmtRailScgRtHisVOs){
		this.trsAgmtRailScgRtHisVOs = trsAgmtRailScgRtHisVOs;
	}	

	public String getEventName() {
		return "EsdTrs0234Event";
	}

	public String toString() {
		return "EsdTrs0234Event";
	}
}
