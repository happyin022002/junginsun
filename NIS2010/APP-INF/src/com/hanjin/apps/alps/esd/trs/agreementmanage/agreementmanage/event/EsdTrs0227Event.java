/*=========================================================
 *@FileName : ESD_TRS_0227Event.java
 *@FileTitle : Agreement Rate History Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011-05-11
 *@LastModifier : 민정호
 *@LastVersion : 1.0
 * 2010-03-26 jong hyek choi
 * 1.0 최초 생성
 * 
 * 1.1 2011.05.11 민정호 [CHM-201110223] USER 에 의한 AGMT HISTORY 관리를 위한 기능 추가요청
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event;

import java.util.HashMap;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TrsAgmtEqRtHisVO;


/**
 * ESD_TRS_0227 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_0227HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jong hyek choi
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0227Event extends EventSupport {		
	/** trs_agmt_eq_rt_his Table  Value Object */
	private TrsAgmtEqRtHisVO trsAgmtEqRtHisVO = null;
	/** trs_agmt_eq_rt_hiss Multi Action을 위한 Collection */
	private TrsAgmtEqRtHisVO[] trsAgmtEqRtHisVOs = null;	
		
	/** getTrsAgmtEqRtHisVO*/
	public TrsAgmtEqRtHisVO getTrsAgmtEqRtHisVO(){
		return trsAgmtEqRtHisVO;
	}
	
	/** getTrsAgmtEqRtHisVOs*/
	public TrsAgmtEqRtHisVO[] getTrsAgmtEqRtHisVOS(){
		return trsAgmtEqRtHisVOs;
	}	
		
	String fmAgmtno             = null;
	String fmTrspAgmtRtTpCd 	= null;
	String fmEqKndCd          	= null;
	String fmTrspCostModCd   	= null;
	String fmAgmtTrspTpCd    	= null;
	String fmCgoTpCd          	= null;
	String fmCustCd            	= null;
	String fmCmdtGrpCd        	= null;
	String fmRailSvcTpCd     	= null;
	String fmFmNodCd          	= null;
	String fmViaNodCd         	= null;
	String fmDorNodCd         	= null;
	String fmToNodCd          	= null;
	String fmFmNodYd          	= null;
	String fmViaNodYd         	= null;
	String fmDorNodYd         	= null;
	String fmToNodYd          	= null;
	String fmTrspDistTpCd    	= null;
	String fmTrspAgmtDist     	= null;
	String fmDistMeasUtCd    	= null;
	String fmEqtpsz 			= null;
	String effectiveDate 		= null;
	String trspAgmtOfcCtyCd     = null;
	String trspAgmtSeq     		= null;
	String trspAgmtRtTpSerNo    = null;
	String trspAgmtNodSeq     	= null;
	String trspAgmtRtSeq     	= null;
	String trspAgmtRtHisSeq     = null;
	String deltFlg     			= null;	
	String updUsrId				= null; 
	String fmAccountUsrId		= null;	
	String deleteYn				= null;	

	public String getFm_agmtno() {
		return fmAgmtno;
	}

	public void setFm_agmtno(String fmAgmtno) {
		this.fmAgmtno = fmAgmtno;
	}

	public String getFm_trsp_agmt_rt_tp_cd() {
		return fmTrspAgmtRtTpCd;
	}

	public void setFm_trsp_agmt_rt_tp_cd(String fmTrspAgmtRtTpCd) {
		this.fmTrspAgmtRtTpCd = fmTrspAgmtRtTpCd;
	}

	public String getFm_eq_knd_cd() {
		return fmEqKndCd;
	}

	public void setFm_eq_knd_cd(String fmEqKndCd) {
		this.fmEqKndCd = fmEqKndCd;
	}

	public String getFm_trsp_cost_mod_cd() {
		return fmTrspCostModCd;
	}
	
	public void setFm_trsp_cost_mod_cd(String fmTrspCostModCd) {
		this.fmTrspCostModCd = fmTrspCostModCd;
	}

	public String getFm_agmt_trsp_tp_cd() {
		return fmAgmtTrspTpCd;
	}

	public void setFm_agmt_trsp_tp_cd(String fmAgmtTrspTpCd) {
		this.fmAgmtTrspTpCd = fmAgmtTrspTpCd;
	}

	public String getFm_cgo_tp_cd() {
		return fmCgoTpCd;
	}

	public void setFm_cgo_tp_cd(String fmCgoTpCd) {
		this.fmCgoTpCd = fmCgoTpCd;
	}

	public String getFm_cust_cd() {
		return fmCustCd;
	}

	public void setFm_cust_cd(String fmCustCd) {
		this.fmCustCd = fmCustCd;
	}

	public String getFm_cmdt_grp_cd() {
		return fmCmdtGrpCd;
	}

	public void setFm_cmdt_grp_cd(String fmCmdtGrpCd) {
		this.fmCmdtGrpCd = fmCmdtGrpCd;
	}

	public String getFm_rail_svc_tp_cd() {
		return fmRailSvcTpCd;
	}

	public void setFm_rail_svc_tp_cd(String fmRailSvcTpCd) {
		this.fmRailSvcTpCd = fmRailSvcTpCd;
	}

	public String getFm_fm_nod_cd() {
		return fmFmNodCd;
	}

	public void setFm_fm_nod_cd(String fmFmNodCd) {
		this.fmFmNodCd = fmFmNodCd;
	}

	public String getFm_via_nod_cd() {
		return fmViaNodCd;
	}

	public void setFm_via_nod_cd(String fmViaNodCd) {
		this.fmViaNodCd = fmViaNodCd;
	}

	public String getFm_dor_nod_cd() {
		return fmDorNodCd;
	}

	public void setFm_dor_nod_cd(String fmDorNodCd) {
		this.fmDorNodCd = fmDorNodCd;
	}

	public String getFm_to_nod_cd() {
		return fmToNodCd;
	}

	public void setFm_to_nod_cd(String fmToNodCd) {
		this.fmToNodCd = fmToNodCd;
	}

	public String getFm_fm_nod_yd() {
		return fmFmNodYd;
	}

	public void setFm_fm_nod_yd(String fmFmNodYd) {
		this.fmFmNodYd = fmFmNodYd;
	}

	public String getFm_via_nod_yd() {
		return fmViaNodYd;
	}

	public void setFm_via_nod_yd(String fmViaNodYd) {
		this.fmViaNodYd = fmViaNodYd;
	}

	public String getFm_dor_nod_yd() {
		return fmDorNodYd;
	}

	public void setFm_dor_nod_yd(String fmDorNodYd) {
		this.fmDorNodYd = fmDorNodYd;
	}

	public String getFm_to_nod_yd() {
		return fmToNodYd;
	}

	public void setFm_to_nod_yd(String fmToNodYd) {
		this.fmToNodYd = fmToNodYd;
	}

	public String getFm_trsp_dist_tp_cd() {
		return fmTrspDistTpCd;
	}

	public void setFm_trsp_dist_tp_cd(String fmTrspDistTpCd) {
		this.fmTrspDistTpCd = fmTrspDistTpCd;
	}

	public String getFm_trsp_agmt_dist() {
		return fmTrspAgmtDist;
	}

	public void setFm_trsp_agmt_dist(String fmTrspAgmtDist) {
		this.fmTrspAgmtDist = fmTrspAgmtDist;
	}

	public String getFm_dist_meas_ut_cd() {
		return fmDistMeasUtCd;
	}

	public void setFm_dist_meas_ut_cd(String fmDistMeasUtCd) {
		this.fmDistMeasUtCd = fmDistMeasUtCd;
	}
		
	public String getFm_eqtpsz() {
		return fmEqtpsz;
	}
	
	public void setFm_eqtpsz(String fmEqtpsz) {
		this.fmEqtpsz = fmEqtpsz;
	}	
	
	
	public String getEffective_date() {
		return effectiveDate;
	}
	
	public void setEffective_date(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}	
		
	public String getTrspAgmtOfcCtyCd() {
		return trspAgmtOfcCtyCd;
	}
	
	public String getTrspAgmtSeq() {
		return trspAgmtSeq;
	}
	
	public String getTrspAgmtRtTpSerNo() {
		return trspAgmtRtTpSerNo;
	}
	
	public String getTrspAgmtNodSeq() {
		return trspAgmtNodSeq;
	}
	
	public String getTrspAgmtRtSeq() {
		return trspAgmtRtSeq;
	}
	
	public String getTrspAgmtRtHisSeq() {
		return trspAgmtRtHisSeq;
	}
	
	public String getDeltFlg() {
		return deltFlg;
	}
	
	public void setTrspAgmtOfcCtyCd(String trspAgmtOfcCtyCd) {
		this.trspAgmtOfcCtyCd = trspAgmtOfcCtyCd;
	}
	
	public void setTrspAgmtSeq(String trspAgmtSeq) {
		this.trspAgmtSeq = trspAgmtSeq;
	}
	
	public void setTrspAgmtRtTpSerNo(String trspAgmtRtTpSerNo) {
		this.trspAgmtRtTpSerNo = trspAgmtRtTpSerNo;
	}
	
	public void setTrspAgmtNodSeq(String trspAgmtNodSeq) {
		this.trspAgmtNodSeq = trspAgmtNodSeq;
	}
	
	public void setTrspAgmtRtSeq(String trspAgmtRtSeq) {
		this.trspAgmtRtSeq = trspAgmtRtSeq;
	}
	
	public void setTrspAgmtRtHisSeq(String trspAgmtRtHisSeq) {
		this.trspAgmtRtHisSeq = trspAgmtRtHisSeq;
	}
	
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	
	public String getUPD_USR_ID() {
		return updUsrId;
	}

	public void setUPD_USR_ID(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	
	public String getFm_Account_Usr_Id() {
		return fmAccountUsrId;
	}

	public void setFm_Account_Usr_Id(String fmAccountUsrId) {
		this.fmAccountUsrId = fmAccountUsrId;
	}
	
	public String getDelete_yn() {
		return deleteYn;
	}
	
	public void setDelete_yn(String deleteYn) {
		this.deleteYn = deleteYn;
	}		
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("trsp_agmt_ofc_cty_cd", getTrspAgmtOfcCtyCd());
		this.hashColumns.put("trsp_agmt_seq", getTrspAgmtSeq());
		this.hashColumns.put("trsp_agmt_rt_tp_ser_no", getTrspAgmtRtTpSerNo());
		this.hashColumns.put("trsp_agmt_nod_seq", getTrspAgmtNodSeq());
		this.hashColumns.put("trsp_agmt_rt_seq", getTrspAgmtRtSeq());
		this.hashColumns.put("trsp_agmt_rt_his_seq", getTrspAgmtRtHisSeq());
		this.hashColumns.put("delt_flg", getDeltFlg());
				
		return this.hashColumns;
	}	
	
	public EsdTrs0227Event(){}

	public void setTrsAgmtEqRtHisVOS(TrsAgmtEqRtHisVO[] trsAgmtEqRtHisVOs){
		this.trsAgmtEqRtHisVOs = trsAgmtEqRtHisVOs;
	}
	
	public String getEventName() {
		return "EsdTrs0227Event";
	}

	public String toString() {
		return "EsdTrs0227Event";
	}	
}
