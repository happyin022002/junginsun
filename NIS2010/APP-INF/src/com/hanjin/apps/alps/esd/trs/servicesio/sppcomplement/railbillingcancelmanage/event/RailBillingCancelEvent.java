/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailBillingCancelEvent.java
*@FileTitle : Rail Billing Cancel
*Open Issues :
*Change history :
*@LastModifyDate : 2007-02-06
*@LastModifier : Lee Sang-Woo
*@LastVersion : 1.0 
* 2007-02-06 Lee Sang-Woo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.sppcomplement.railbillingcancelmanage.event;

import com.hanjin.framework.support.layer.event.EventSupport;

/**
 *  PDTO(Data Transfer Object including Parameters)<br>
 * - HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Sang-Woo
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class RailBillingCancelEvent extends EventSupport {
	
	private String userID = "";
	private String ibflagFst;
	private String venderCd;
	private String ofcCd;
	private String trspSoOfcCtyCdFst; 
	private String trspSoSeqFst;
	private String cxlRqstRsnFst;
	private String bilIssKntFst;
	private String spclInstrRmkFst;
	private String railOrdRjctFlgFst;
	private String woRjctRsnFst;
	private String interRmkFst;
	private String fmNodCdFst;
	private String toNodCdFst;
	private String blNoFst;
	private String blNoTpFst;
	private String blNoChkFst;
	private String bkgCgoTpCdFst;
	private String copNoFst;
	private String costActGrpSeqFst;
	private String repoPlnIdFst;
	private String plnYrwkFst;
	private String refIdFst;
	private String refSeqFst;
	private String[] trspSoOfcCtyCd; 
	private String[] trspSoSeq;
	private String[] cxlRqstRsn;	
	private String[] bilIssKnt;
	private String[] spclInstrRmk;
	private String[] railOrdRjctFlg;
	private String[] woRjctRsn;
	private String[] interRmk;
	private String[] fmNodCd;
	private String[] toNodCd;
	private String[] blNo;
	private String[] blNoTp;
	private String[] blNoChk;
	private String[] bkgCgoTpCd;
	private String[] copNo;
	private String[] costActGrpSeq;
	private String[] repoPlnId;
	private String[] plnYrwk;
	private String[] refId;
	private String[] refSeq;
	private String[] trspRqstBkgFlg;
	private String[] cgoTpCd;
	private String[] bkgNo;
	private String[] bkgNoSplit;
	private String[] vndrSeq;
	private String[] eqNo;
	private String[] eqTpszCd;
	private String[] ibflag;
	

	/**
	 * @return Returns the trspSoOfcCtyCd.
	 */
	public String[] getTrsp_so_ofc_cty_cd() {
		return trspSoOfcCtyCd;
	}

	/**
	 * @param trspSoOfcCtyCd The trspSoOfcCtyCd to set.
	 */
	public void setTrsp_so_ofc_cty_cd(String[] trspSoOfcCtyCd) {
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
	}
	
	/**
	 * @return Returns the trspSoOfcCtyCdFst.
	 */
	public String getTrsp_so_ofc_cty_cd_fst() {
		return trspSoOfcCtyCdFst;
	}

	/**
	 * @param trspSoOfcCtyCdFst The trspSoOfcCtyCdFst to set.
	 */
	public void setTrsp_so_ofc_cty_cd_fst(String trspSoOfcCtyCdFst) {
		this.trspSoOfcCtyCdFst = trspSoOfcCtyCdFst;
	}

	/**
	 * @return Returns the trspSoSeq.
	 */
	public String[] getTrsp_so_seq() {
		return trspSoSeq;
	}

	/**
	 * @param trspSoSeq The trspSoSeq to set.
	 */
	public void setTrsp_so_seq(String[] trspSoSeq) {
		this.trspSoSeq = trspSoSeq;
	}
	
	/**
	 * @return Returns the trspSoSeqFst.
	 */
	public String getTrsp_so_seq_fst() {
		return trspSoSeqFst;
	}

	/**
	 * @param trspSoSeqFst The trspSoSeqFst to set.
	 */
	public void setTrsp_so_seq_fst(String trspSoSeqFst) {
		this.trspSoSeqFst = trspSoSeqFst;
	}

	/**
	 * @return Returns the userID.
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * @param userID The userID to set.
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}

	/**
	 * @return Returns the cxlRqstRsn.
	 */
	public String[] getCxl_rqst_rsn() {
		return cxlRqstRsn;
	}

	/**
	 * @param cxlRqstRsn The cxlRqstRsn to set.
	 */
	public void setCxl_rqst_rsn(String[] cxlRqstRsn) {
		this.cxlRqstRsn = cxlRqstRsn;
	}
	
	/**
	 * @return Returns the cxlRqstRsnFst.
	 */
	public String getCxl_rqst_rsn_fst() {
		return cxlRqstRsnFst;
	}

	/**
	 * @param cxlRqstRsnFst The cxlRqstRsnFst to set.
	 */
	public void setCxl_rqst_rsn_fst(String cxlRqstRsnFst) {
		this.cxlRqstRsnFst = cxlRqstRsnFst;
	}
	
	/**
	 * @return Returns the vendor_seq.
	 */
	public String getVendor_seq() {
		return venderCd;
	}

	/**
	 * @param vendor_seq The vendor_seq to set.
	 */
	public void setVendor_seq(String venderCd) {
		this.venderCd = venderCd;
	}
	
	public String getEventName() {
        return "RailBillingCancelEvent";
    }

    public String toString() {
        return "RailBillingCancelEvent";
    }
    
    /**
	 * @return Returns the bilIssKnt.
	 */
	public String[] getBil_iss_knt() {
		return bilIssKnt;
	}

	/**
	 * @param bilIssKnt The bilIssKnt to set.
	 */
	public void setBil_iss_knt(String[] bilIssKnt) {
		this.bilIssKnt = bilIssKnt;
	}
	
	/**
	 * @return Returns the bilIssKntFst.
	 */
	public String getBil_iss_knt_fst() {
		return bilIssKntFst;
	}

	/**
	 * @param bilIssKntFst The bilIssKntFst to set.
	 */
	public void setBil_iss_knt_fst(String bilIssKntFst) {
		this.bilIssKntFst = bilIssKntFst;
	}
	
	/**
	 * @return Returns the spclInstrRmk.
	 */
	public String[] getSpcl_instr_rmk() {
		return spclInstrRmk;
	}

	/**
	 * @param spclInstrRmk The spclInstrRmk to set.
	 */
	public void setSpcl_instr_rmk(String[] spclInstrRmk) {
		this.spclInstrRmk = spclInstrRmk;
	}
	
	/**
	 * @return Returns the spclInstrRmkFst.
	 */
	public String getSpcl_instr_rmk_fst() {
		return spclInstrRmkFst;
	}

	/**
	 * @param spclInstrRmkFst The spclInstrRmkFst to set.
	 */
	public void setSpcl_instr_rmk_fst(String spclInstrRmkFst) {
		this.spclInstrRmkFst = spclInstrRmkFst;
	}
	
	/**
	 * @return Returns the railOrdRjctFlg.
	 */
	public String[] getRail_ord_rjct_flg() {
		return railOrdRjctFlg;
	}

	/**
	 * @param railOrdRjctFlg The railOrdRjctFlg to set.
	 */
	public void setRail_ord_rjct_flg(String[] railOrdRjctFlg) {
		this.railOrdRjctFlg = railOrdRjctFlg;
	}
	
	/**
	 * @return Returns the railOrdRjctFlg_fst.
	 */
	public String getRail_ord_rjct_flg_fst() {
		return railOrdRjctFlgFst;
	}

	/**
	 * @param railOrdRjctFlg_fst The railOrdRjctFlg_fst to set.
	 */
	public void setRail_ord_rjct_flg_fst(String railOrdRjctFlg_fst) {
		this.railOrdRjctFlgFst = railOrdRjctFlg_fst;
	}
	
	/**
	 * @return Returns the woRjctRsn.
	 */
	public String[] getWo_rjct_rsn() {
		return woRjctRsn;
	}

	/**
	 * @param woRjctRsn The woRjctRsn to set.
	 */
	public void setWo_rjct_rsn(String[] woRjctRsn) {
		this.woRjctRsn = woRjctRsn;
	}
	
	/**
	 * @return Returns the woRjctRsnFst.
	 */
	public String getWo_rjct_rsn_fst() {
		return woRjctRsnFst;
	}

	/**
	 * @param woRjctRsnFst The woRjctRsnFst to set.
	 */
	public void setWo_rjct_rsn_fst(String woRjctRsnFst) {
		this.woRjctRsnFst = woRjctRsnFst;
	}
	
	/**
	 * @return Returns the interRmk.
	 */
	public String[] getInter_rmk() {
		return interRmk;
	}

	/**
	 * @param interRmk The interRmk to set.
	 */
	public void setInter_rmk(String[] interRmk) {
		this.interRmk = interRmk;
	}
	
	/**
	 * @return Returns the interRmkFst.
	 */
	public String getInter_rmk_fst() {
		return interRmkFst;
	}

	/**
	 * @param interRmkFst The interRmkFst to set.
	 */
	public void setInter_rmk_fst(String interRmkFst) {
		this.interRmkFst = interRmkFst;
	}
	
	/**
	 * @return Returns the fmNodCd.
	 */
	public String[] getFm_nod_cd() {
		return fmNodCd;
	}

	/**
	 * @param fmNodCd The fmNodCd to set.
	 */
	public void setFm_nod_cd(String[] fmNodCd) {
		this.fmNodCd = fmNodCd;
	}
	
	/**
	 * @return Returns the fmNodCdFst.
	 */
	public String getFm_nod_cd_fst() {
		return fmNodCdFst;
	}

	/**
	 * @param fmNodCdFst The fmNodCdFst to set.
	 */
	public void setFm_nod_cd_fst(String fmNodCdFst) {
		this.fmNodCdFst = fmNodCdFst;
	}
	
	/**
	 * @return Returns the toNodCd.
	 */
	public String[] getTo_nod_cd() {
		return toNodCd;
	}

	/**
	 * @param toNodCd The toNodCd to set.
	 */
	public void setTo_nod_cd(String[] toNodCd) {
		this.toNodCd = toNodCd;
	}
	
	/**
	 * @return Returns the toNodCdFst.
	 */
	public String getTo_nod_cd_fst() {
		return toNodCdFst;
	}

	/**
	 * @param toNodCdFst The toNodCdFst to set.
	 */
	public void setTo_nod_cd_fst(String toNodCdFst) {
		this.toNodCdFst = toNodCdFst;
	}
	
	/**
	 * @return Returns the blNo.
	 */
	public String[] getBl_no() {
		return blNo;
	}

	/**
	 * @param blNo The blNo to set.
	 */
	public void setBl_no(String[] blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * @return Returns the blNoFst.
	 */
	public String getBl_no_fst() {
		return blNoFst;
	}

	/**
	 * @param blNoFst The blNoFst to set.
	 */
	public void setBl_no_fst(String blNoFst) {
		this.blNoFst = blNoFst;
	}
	
	/**
	 * @return Returns the blNoTp.
	 */
	public String[] getBl_no_tp() {
		return blNoTp;
	}

	/**
	 * @param blNoTp The blNoTp to set.
	 */
	public void setBl_no_tp(String[] blNoTp) {
		this.blNoTp = blNoTp;
	}
	
	/**
	 * @return Returns the blNoTpFst.
	 */
	public String getBl_no_tp_fst() {
		return blNoTpFst;
	}

	/**
	 * @param blNoTpFst The blNoTpFst to set.
	 */
	public void setBl_no_tp_fst(String blNoTpFst) {
		this.blNoTpFst = blNoTpFst;
	}
	
	/**
	 * @return Returns the blNoChk.
	 */
	public String[] getBl_no_chk() {
		return blNoChk;
	}

	/**
	 * @param blNoChk The blNoChk to set.
	 */
	public void setBl_no_chk(String[] blNoChk) {
		this.blNoChk = blNoChk;
	}
	
	/**
	 * @return Returns the blNoChkFst.
	 */
	public String getBl_no_chk_fst() {
		return blNoChkFst;
	}

	/**
	 * @param blNoChkFst The blNoChkFst to set.
	 */
	public void setBl_no_chk_fst(String blNoChkFst) {
		this.blNoChkFst = blNoChkFst;
	}
	
	/**
	 * @return Returns the bkgCgoTpCd.
	 */
	public String[] getBkg_cgo_tp_cd() {
		return bkgCgoTpCd;
	}

	/**
	 * @param bkgCgoTpCd The bkgCgoTpCd to set.
	 */
	public void setBkg_cgo_tp_cd(String[] bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
	}
	
	/**
	 * @return Returns the bkgCgoTpCdFst.
	 */
	public String getBkg_cgo_tp_cd_fst() {
		return bkgCgoTpCdFst;
	}

	/**
	 * @param bkgCgoTpCdFst The bkgCgoTpCdFst to set.
	 */
	public void setBkg_cgo_tp_cd_fst(String bkgCgoTpCdFst) {
		this.bkgCgoTpCdFst = bkgCgoTpCdFst;
	}
	
	/**
	 * @return Returns the copNo.
	 */
	public String[] getCop_no() {
		return copNo;
	}

	/**
	 * @param copNo The copNo to set.
	 */
	public void setCop_no(String[] copNo) {
		this.copNo = copNo;
	}
	
	/**
	 * @return Returns the copNoFst.
	 */
	public String getCop_no_fst() {
		return copNoFst;
	}

	/**
	 * @param copNoFst The copNoFst to set.
	 */
	public void setCop_no_fst(String copNoFst) {
		this.copNoFst = copNoFst;
	}
	
	/**
	 * @return Returns the costActGrpSeq.
	 */
	public String[] getCost_act_grp_seq() {
		return costActGrpSeq;
	}

	/**
	 * @param costActGrpSeq The costActGrpSeq to set.
	 */
	public void setCost_act_grp_seq(String[] costActGrpSeq) {
		this.costActGrpSeq = costActGrpSeq;
	}
	
	/**
	 * @return Returns the costActGrpSeqFst.
	 */
	public String getCost_act_grp_seq_fst() {
		return costActGrpSeqFst;
	}

	/**
	 * @param costActGrpSeqFst The costActGrpSeqFst to set.
	 */
	public void setCost_act_grp_seq_fst(String costActGrpSeqFst) {
		this.costActGrpSeqFst = costActGrpSeqFst;
	}
	
	/**
	 * @return Returns the repoPlnId.
	 */
	public String[] getRepo_pln_id() {
		return repoPlnId;
	}

	/**
	 * @param repoPlnId The repoPlnId to set.
	 */
	public void setRepo_pln_id(String[] repoPlnId) {
		this.repoPlnId = repoPlnId;
	}
	
	/**
	 * @return Returns the repoPlnIdFst.
	 */
	public String getRepo_pln_id_fst() {
		return repoPlnIdFst;
	}

	/**
	 * @param repoPlnIdFst The repoPlnIdFst to set.
	 */
	public void setRepo_pln_id_fst(String repoPlnIdFst) {
		this.repoPlnIdFst = repoPlnIdFst;
	}
	
	/**
	 * @return Returns the plnYrwk.
	 */
	public String[] getPln_yrwk() {
		return plnYrwk;
	}

	/**
	 * @param plnYrwk The plnYrwk to set.
	 */
	public void setPln_yrwk(String[] plnYrwk) {
		this.plnYrwk = plnYrwk;
	}
	
	/**
	 * @return Returns the plnYrwkFst.
	 */
	public String getPln_yrwk_fst() {
		return plnYrwkFst;
	}

	/**
	 * @param plnYrwkFst The plnYrwkFst to set.
	 */
	public void setPln_yrwk_fst(String plnYrwkFst) {
		this.plnYrwkFst = plnYrwkFst;
	}
	
	/**
	 * @return Returns the refId.
	 */
	public String[] getRef_id() {
		return refId;
	}

	/**
	 * @param refId The refId to set.
	 */
	public void setRef_id(String[] refId) {
		this.refId = refId;
	}
	
	/**
	 * @return Returns the refIdFst.
	 */
	public String getRef_id_fst() {
		return refIdFst;
	}

	/**
	 * @param refIdFst The refIdFst to set.
	 */
	public void setRef_id_fst(String refIdFst) {
		this.refIdFst = refIdFst;
	}
	
	/**
	 * @return Returns the refSeq.
	 */
	public String[] getRef_seq() {
		return refSeq;
	}

	/**
	 * @param refSeq The refSeq to set.
	 */
	public void setRef_seq(String[] refSeq) {
		this.refSeq = refSeq;
	}
	
	/**
	 * @return Returns the refSeqFst.
	 */
	public String getRef_seq_fst() {
		return refSeqFst;
	}

	/**
	 * @param refSeqFst The refSeqFst to set.
	 */
	public void setRef_seq_fst(String refSeqFst) {
		this.refSeqFst = refSeqFst;
	}
	
	/**
	 * @return Returns the refSeq.
	 */
	public String[] getIbflag() {
		return ibflag;
	}

	/**
	 * @param refSeq The refSeq to set.
	 */
	public void setIbflag(String[] ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * @return Returns the ibflagFst.
	 */
	public String getIbflag_fst() {
		return ibflagFst;
	}

	/**
	 * @param ibflagFst The ibflagFst to set.
	 */
	public void setIbflag_fst(String ibflagFst) {
		this.ibflagFst = ibflagFst;
	}
	
	/**
	 * @return Returns the trspRqstBkgFlg.
	 */
	public String[] getTrsp_rqst_bkg_flg() {
		return trspRqstBkgFlg;
	}

	/**
	 * @param trspRqstBkgFlg The trspRqstBkgFlg to set.
	 */
	public void setTrsp_rqst_bkg_flg(String[] trspRqstBkgFlg) {
		this.trspRqstBkgFlg = trspRqstBkgFlg;
	}
	
	/**
	 * @return Returns the cgoTpCd.
	 */
	public String[] getCgo_tp_cd() {
		return cgoTpCd;
	}

	/**
	 * @param cgoTpCd The cgoTpCd to set.
	 */
	public void setCgo_tp_cd(String[] cgoTpCd) {
		this.cgoTpCd = cgoTpCd;
	}
	
	/**
	 * @return Returns the bkgNo.
	 */
	public String[] getBkg_no() {
		return bkgNo;
	}

	/**
	 * @param bkgNo The bkgNo to set.
	 */
	public void setBkg_no(String[] bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * @return Returns the bkgNoSplit.
	 */
	public String[] getBkg_no_split() {
		return bkgNoSplit;
	}

	/**
	 * @param bkgNoSplit The bkgNoSplit to set.
	 */
	public void setBkg_no_split(String[] bkgNoSplit) {
		this.bkgNoSplit = bkgNoSplit;
	}
	
	/**
	 * @return Returns the vndrSeq.
	 */
	public String[] getVndr_seq() {
		return vndrSeq;
	}

	/**
	 * @param vndrSeq The vndrSeq to set.
	 */
	public void setVndr_seq(String[] vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * @return Returns the eqNo.
	 */
	public String[] getEq_no() {
		return eqNo;
	}

	/**
	 * @param eqNo The eqNo to set.
	 */
	public void setEq_no(String[] eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * @return Returns the eqTpszCd.
	 */
	public String[] getEq_tpsz_cd() {
		return eqTpszCd;
	}

	/**
	 * @param eqTpszCd The eqTpszCd to set.
	 */
	public void setEq_tpsz_cd(String[] eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}
	
	/**
	 * @return Returns the ofcCd.
	 */
	public String getOfc_cd() {
		return ofcCd;
	}

	/**
	 * @param ofcCd The ofcCd to set.
	 */
	public void setOfc_cd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
}
