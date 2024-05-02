/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : EsdTrs0002Event.java
 *@FileTitle : CY & Door S/O Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.10.08
 *@LastModifier : 최 선
 *@LastVersion : 1.2
 * 2006.09.29 김상근
 * 1.0 최초 생성
 *----------------------------------------------------------
 * History
 * 2009.02.18 조풍연 1.1 [N200902170001]  TRS SO 대상 삭제시 COA 비용 제거 기능 추가 
 * 2010.10.08 최 선     1.2 [CHM-201006411] S/O DOOR NODE 팝업창의 RETURN VALUE 오류 수정
 * 2012.01.09 김보배 [CHM-201215479] [TRS] Dup. S/O 사전 보완기능 요청
=========================================================*/
package com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.event;

import java.util.ArrayList;
import java.util.HashMap;

//import com.hanjin.apps.alps.esd.trs.costbatch.costbatch.vo.SearchFdrCostBatchErrorVO;
import com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_TRS_0002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_0002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김상근
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0002Event extends EventSupport {
	String frmPlandate          = null;
	String toPlandate           = null;
	String transmode             = null;
	String costmode              = null;
	String bound                 = null;
	String searchFmLoc       = null;
	String searchFmYard       = null;
	String searchViaLoc      = null;
	String searchViaYard      = null;
	String searchToLoc       = null;
	String searchToYard       = null;
	String searchDoorLoc      = null;
	String searchDoorYard      = null;
	String trunkvvd              = null;
	String bkgno                 = null;
	String billno                = null;
	String cntrno                = null;
	String contractTpCd        = null;
	String contractNo           = null;
	String sUnplannedShuttleFlag = null;
	String sTroUnConfirmDoor     = null;
	String susaRail             = null;
	String radDateSep           = null;
	String ctrlSoOffice        = null;
	String feederVvd            = null;
	String txtFeederVvd        = null;
	String zipCode              = null;
	String cydoorDiv            = null;
	String uiContiCd           = null;
	String formUsrOfcCd       = null;
	String formCreUsrId       = null;
	String cbstatus           = null;
	String prntOfcCd          = null;
	String cntFlg             = null;
	String spotBidFlg		  = null;
	String spotBidNo		  = null;
	ArrayList  arrSeq;

	String  sFmLocContiCd   = null; //FM_LOC_CONTI_CD
	String  sBoundCd        = null; //BOUND_CD
	String  sCneeCustCntCd  = null; //CNEE_CUST_CNT_CD
    String  sCneeCustSeq    = null; //CNEE_CUST_SEQ
	String  sShprCustCntCd  = null; //SHPR_CUST_CNT_CD
	String  sShprCustSeq    = null; //SHPR_CUST_SEQ
	String  sDoorNodCd      = null; //DOOR_NOD_CD

	//S/O Correction에서만 사용
	String  radWoIssued      = null;
	String  comboSvcProvider = null;
	String  soNo   = null;
	String  woNo   = null;
	
	private SingleTransportationVO singleTransportationVO = null;
	private SingleTransportationVO[] singleTransportationVOs = null;
	
    //N200902170001 2009-02-18 TRS SO 대상 삭제시 COA 비용 제거 기능 추가 
	//Array 변수는 COP, COA I/F 시에만 사용된다.
	private ArrayList ibflagList = null;
	private ArrayList bkgNoList = null;
	private ArrayList cntrNoList = null;
	private ArrayList selCntrNoList = null;

	private String vvdBkgNo = null;
	private String fmNodCd = null;
	private String toNodCd = null;
	private String trspBndCd = null;	
	
	private String copNo = null;
	private String trspCostDtlModCd= null;
	private String trspCrrModCd = null;
	private String fmNodYard = null;
	private String toNodYard = null;
	private String viaNodCd = null;
	private String viaNodYard = null;
	private String sCopNo = null;
	private String sCostActGrpSeq = null;
	private String nonRtStsCd  = null;
	
	
	public String getSpotBidFlg() {
		return spotBidFlg;
	}

	public void setSpotBidFlg(String spotBidFlg) {
		this.spotBidFlg = spotBidFlg;
	}

	public String getSpotBidNo() {
		return spotBidNo;
	}

	public void setSpotBidNo(String spotBidNo) {
		this.spotBidNo = spotBidNo;
	}

	public String getCntFlg() {
		return cntFlg;
	}

	public void setCntFlg(String cntFlg) {
		this.cntFlg = cntFlg;
	}

	public String getNonRtStsCd() {
		return nonRtStsCd;
	}
	
	public void setNonRtStsCd(String nonRtStsCd) {
		this.nonRtStsCd = nonRtStsCd;
	}

	public String getRad_wo_issued() {
		return radWoIssued;
	}
	public void setRad_wo_issued(String radWoIssued) {
		this.radWoIssued = radWoIssued;
	}
	public String getCombo_svc_provider() {
		return comboSvcProvider;
	}
	public void setCombo_svc_provider(String comboSvcProvider) {
		this.comboSvcProvider = comboSvcProvider;
	}
	public String getSo_no() {
		return soNo;
	}
	public void setSo_no(String soNo) {
		this.soNo = soNo;
	}
	public String getWo_no() {
		return woNo;
	}
	public void setWo_no(String woNo) {
		this.woNo = woNo;
	}
	public ArrayList getIbflagList() {
		return ibflagList;
	}
	public void setIbflagList(String[] ibflag){
		this.ibflagList = setArrayList(ibflag, this.ibflagList);
	}

	public ArrayList getBkg_noList() {
		return bkgNoList;
	}
	public void setBkg_noList(String[] bkgNo){
		this.bkgNoList = setArrayList(bkgNo, this.bkgNoList);
	}
	
	public ArrayList getCntr_noList() {
		return cntrNoList;
	}
	public void setCntr_noList(String[] cntrNo){
		this.cntrNoList = setArrayList(cntrNo, this.cntrNoList);
	}
	
	public ArrayList getSel_cntr_noList() {
		return selCntrNoList;
	}
	public void setSel_cntr_noList(String[] cntr_no){
		this.selCntrNoList = setArrayList(cntr_no, this.selCntrNoList);
	}
	
	public String getSFmLocContiCd() {
		return sFmLocContiCd;
	}
	public void setSFmLocContiCd(String fmLocContiCd) {
		this.sFmLocContiCd = fmLocContiCd;
	}
	public String getSBoundCd() {
		return sBoundCd;
	}
	public void setSBoundCd(String boundCd) {
		this.sBoundCd = boundCd;
	}
	public String getSCneeCustCntCd() {
		return sCneeCustCntCd;
	}
	public void setSCneeCustCntCd(String cneeCustCntCd) {
		this.sCneeCustCntCd = cneeCustCntCd;
	}
	public String getSCneeCustSeq() {
		return sCneeCustSeq;
	}
	public void setSCneeCustSeq(String cneeCustSeq) {
		this.sCneeCustSeq = cneeCustSeq;
	}
	public String getSShprCustCntCd() {
		return sShprCustCntCd;
	}
	public void setSShprCustCntCd(String shprCustCntCd) {
		this.sShprCustCntCd = shprCustCntCd;
	}
	public String getSShprCustSeq() {
		return sShprCustSeq;
	}
	public void setSShprCustSeq(String shprCustSeq) {
		this.sShprCustSeq = shprCustSeq;
	}
	public String getSDoorNodCd() {
		return sDoorNodCd;
	}
	public void setSDoorNodCd(String doorNodCd) {
		this.sDoorNodCd = doorNodCd;
	}
	public ArrayList getArrSeq() {
		return arrSeq;
	}
	public void setArrSeq(ArrayList arrSeq) {
		this.arrSeq = arrSeq;
	}

	public SingleTransportationVO getSingleTransportationVO() {
		return singleTransportationVO;
	}
	public void setSingleTransportationVO(
			SingleTransportationVO singleTransportationVO) {
		this.singleTransportationVO = singleTransportationVO;
	}
	public SingleTransportationVO[] getSingleTransportationVOs() {
		SingleTransportationVO [] rtnVOs = null;
        if (this.singleTransportationVOs != null) {
              rtnVOs = new SingleTransportationVO[singleTransportationVOs.length ];
              System.arraycopy( singleTransportationVOs, 0, rtnVOs, 0, rtnVOs.length);
        }
        return rtnVOs;
	}
	public void setSingleTransportationVOs(SingleTransportationVO[] singleTransportationVOs) {
        if (singleTransportationVOs != null ) {
        	SingleTransportationVO[] tmpVOs = new SingleTransportationVO[singleTransportationVOs.length];
            System.arraycopy(singleTransportationVOs , 0, tmpVOs, 0, tmpVOs.length );
            this.singleTransportationVOs = tmpVOs;
        }
	}
	public String getFrm_plandate() {
		return frmPlandate;
	}
	public void setFrm_plandate(String frmPlandate) {
		this.frmPlandate = frmPlandate;
	}
	public String getTo_plandate() {
		return toPlandate;
	}
	public void setTo_plandate(String toPlandate) {
		this.toPlandate = toPlandate;
	}
	public String getTransmode() {
		return transmode;
	}
	public void setTransmode(String transmode) {
		this.transmode = transmode;
	}
	public String getCostmode() {
		return costmode;
	}
	public void setCostmode(String costmode) {
		this.costmode = costmode;
	}
	public String getBound() {
		return bound;
	}
	public void setBound(String bound) {
		this.bound = bound;
	}
	public String getSearchFmLoc() {
		return searchFmLoc;
	}
	public void setSearchFmLoc(String searchFmLoc) {
		this.searchFmLoc = searchFmLoc;
	}
	public String getSearchFmYard() {
		return searchFmYard;
	}
	public void setSearchFmYard(String searchFmYard) {
		this.searchFmYard = searchFmYard;
	}
	public String getSearchViaLoc() {
		return searchViaLoc;
	}
	public void setSearchViaLoc(String searchViaLoc) {
		this.searchViaLoc = searchViaLoc;
	}
	public String getSearchViaYard() {
		return searchViaYard;
	}
	public void setSearchViaYard(String searchViaYard) {
		this.searchViaYard = searchViaYard;
	}
	public String getSearchToLoc() {
		return searchToLoc;
	}
	public void setSearchToLoc(String searchToLoc) {
		this.searchToLoc = searchToLoc;
	}
	public String getSearchToYard() {
		return searchToYard;
	}
	public void setSearchToYard(String searchToYard) {
		this.searchToYard = searchToYard;
	}
	public String getSearchDoorLoc() {
		return searchDoorLoc;
	}
	public void setSearchDoorLoc(String searchDoorLoc) {
		this.searchDoorLoc = searchDoorLoc;
	}
	public String getSearchDoorYard() {
		return searchDoorYard;
	}
	public void setSearchDoorYard(String searchDoorYard) {
		this.searchDoorYard = searchDoorYard;
	}
	public String getTrunkvvd() {
		return trunkvvd;
	}
	public void setTrunkvvd(String trunkvvd) {
		this.trunkvvd = trunkvvd;
	}
	public String getBkgno() {
		return bkgno;
	}
	public void setBkgno(String bkgno) {
		this.bkgno = bkgno;
	}
	public String getBillno() {
		return billno;
	}
	public void setBillno(String billno) {
		this.billno = billno;
	}
	public String getCntrno() {
		return cntrno;
	}
	public void setCntrno(String cntrno) {
		this.cntrno = cntrno;
	}

	public String getContract_tp_cd() {
		return contractTpCd;
	}
	public void setContract_tp_cd(String contractTpCd) {
		this.contractTpCd = contractTpCd;
	}
	public String getContract_no() {
		return contractNo;
	}
	public void setContract_no(String contract_no) {
		this.contractNo = contract_no;
	}
	public String getSUnplannedShuttleFlag() {
		return sUnplannedShuttleFlag;
	}
	public void setSUnplannedShuttleFlag(String unplannedShuttleFlag) {
		this.sUnplannedShuttleFlag = unplannedShuttleFlag;
	}
	public String getSTroUnConfirmDoor() {
		return sTroUnConfirmDoor;
	}
	public void setSTroUnConfirmDoor(String troUnConfirmDoor) {
		this.sTroUnConfirmDoor = troUnConfirmDoor;
	}
	public String getSusa_rail() {
		return susaRail;
	}
	public void setSusa_rail(String susaRail) {
		this.susaRail = susaRail;
	}
	public String getRad_dateSep() {
		return radDateSep;
	}
	public void setRad_dateSep(String radDateSep) {
		this.radDateSep = radDateSep;
	}
	public String getCtrl_so_office() {
		return ctrlSoOffice;
	}
	public void setCtrl_so_office(String ctrlSoOffice) {
		this.ctrlSoOffice = ctrlSoOffice;
	}
	public String getFeeder_vvd() {
		return feederVvd;
	}
	public void setFeeder_vvd(String feederVvd) {
		this.feederVvd = feederVvd;
	}
	public String getTxt_feeder_vvd() {
		return txtFeederVvd;
	}
	public void setTxt_feeder_vvd(String txtFeederVvd) {
		this.txtFeederVvd = txtFeederVvd;
	}
	public String getZip_code() {
		return zipCode;
	}
	public void setZip_code(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getCydoor_div() {
		return cydoorDiv;
	}
	public void setCydoor_div(String cydoorDiv) {
		this.cydoorDiv = cydoorDiv;
	}
	public String getUi_conti_cd() {
		return uiContiCd;
	}
	public void setUi_conti_cd(String uiContiCd) {
		this.uiContiCd = uiContiCd;
	}

	public String getForm_usr_ofc_cd() {
		return formUsrOfcCd;
	}
	public void setForm_usr_ofc_cd(String formUsrOfcCd) {
		this.formUsrOfcCd = formUsrOfcCd;
	}
	public String getForm_cre_usr_id() {
		return formCreUsrId;
	}
	public void setForm_cre_usr_id(String formCreUsrId) {
		this.formCreUsrId = formCreUsrId;
	}
	
	public String getPrnt_ofc_cd() {
		return prntOfcCd;
	}
	public void setPrnt_ofc_cd(String prntOfcCd) {
		this.prntOfcCd = prntOfcCd;
	}

	public String getCbstatus() {
		return cbstatus;
	}
	public void setCbstatus(String cbstatus) {
		this.cbstatus = cbstatus;
	}
	
	public String getVvdBkgNo() {
		return vvdBkgNo;
	}
	public void setVvdBkgNo(String vvdBkgNo) {
		this.vvdBkgNo = vvdBkgNo;
	}
	
	public String getFmNodCd() {
		return fmNodCd;
	}
	public void setFmNodCd(String fmNodCd) {
		this.fmNodCd = fmNodCd;
	}
	
	public String getToNodCd() {
		return toNodCd;
	}
	public void setToNodCd(String toNodCd) {
		this.toNodCd = toNodCd;
	}
	
	public String getTrspBndCd() {
		return trspBndCd;
	}	
	public void setTrspBndCd(String trspBndCd) {
		this.trspBndCd = trspBndCd;
	}
	
	
	public String getCopNo() {
		return copNo;
	}
	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}

	public String getTrspCostDtlModCd() {
		return trspCostDtlModCd;
	}
	public void setTrspCostDtlModCd(String trspCostDtlModCd) {
		this.trspCostDtlModCd = trspCostDtlModCd;
	}

	public String getTrspCrrModCd() {
		return trspCrrModCd;
	}
	public void setTrspCrrModCd(String trspCrrModCd) {
		this.trspCrrModCd = trspCrrModCd;
	}
	
	public String getFmNodYard() {
		return fmNodYard;
	}
	public void setFmNodYard(String fmNodYard) {
		this.fmNodYard = fmNodYard;
	}

	public String getToNodYard() {
		return toNodYard;
	}
	public void setToNodYard(String toNodYard) {
		this.toNodYard = toNodYard;
	}

	public String getViaNodCd() {
		return viaNodCd;
	}
	public void setViaNodCd(String viaNodCd) {
		this.viaNodCd = viaNodCd;
	}

	public String getViaNodYard() {
		return viaNodYard;
	}
	public void setViaNodYard(String viaNodYard) {
		this.viaNodYard = viaNodYard;
	}

	public String getsCopNo() {
		return sCopNo;
	}
	public void setsCopNo(String sCopNo) {
		this.sCopNo = sCopNo;
	}
	public String getsCostActGrpSeq() {
		return sCostActGrpSeq;
	}
	public void setsCostActGrpSeq(String sCostActGrpSeq) {
		this.sCostActGrpSeq = sCostActGrpSeq;
	}
	public ArrayList setArrayList(String[] src, ArrayList tgt){
		tgt = new ArrayList();

		for(int i=0;src != null && i<src.length; i++  ){
			tgt.add(src[i]);
		}
		return tgt;
	}

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_no", getVvdBkgNo());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("trsp_bnd_cd", getTrspBndCd());
		
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("trsp_cost_dtl_mod_cd", getTrspCostDtlModCd());
		this.hashColumns.put("trsp_crr_mod_cd", getTrspCrrModCd());
		this.hashColumns.put("fm_nod_yard", getFmNodYard());
		this.hashColumns.put("to_nod_yard", getToNodYard());
		this.hashColumns.put("via_nod_cd", getViaNodCd());
		this.hashColumns.put("via_nod_yard", getViaNodYard());

		return this.hashColumns;
	}	
	
}
