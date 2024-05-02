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
package com.clt.apps.opus.esd.trs.servicesio.sppcomplement.railbillingcancelmanage.event;

import com.clt.framework.support.layer.event.EventSupport;
import java.util.Arrays;
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
//	public String[] getTrsp_so_ofc_cty_cd() {
//		return trspSoOfcCtyCd;
//	}
	public String[] getTrsp_so_ofc_cty_cd() {
		String[] rtnArr = null;
		if(this.trspSoOfcCtyCd != null){
			rtnArr = Arrays.copyOf(trspSoOfcCtyCd,trspSoOfcCtyCd.length);
		}
		return rtnArr;
	}

	/**
	 * @param trspSoOfcCtyCd The trspSoOfcCtyCd to set.
	 */
//	public void setTrsp_so_ofc_cty_cd(String[] trspSoOfcCtyCd) {
//		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
//	}
	public void setTrsp_so_ofc_cty_cd(String[] trspSoOfcCtyCd) {
		if(trspSoOfcCtyCd != null){
			String[] tmpArr = Arrays.copyOf(trspSoOfcCtyCd,trspSoOfcCtyCd.length);
			this.trspSoOfcCtyCd = tmpArr;			
		}
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
//	public String[] getTrsp_so_seq() {
//		return trspSoSeq;
//	}
	public String[] getTrsp_so_seq() {
		String[] rtnArr = null;
		if(this.trspSoSeq != null){
			rtnArr = Arrays.copyOf(trspSoSeq,trspSoSeq.length);
		}
		return rtnArr;
	}

	/**
	 * @param trspSoSeq The trspSoSeq to set.
	 */
//	public void setTrsp_so_seq(String[] trspSoSeq) {
//		this.trspSoSeq = trspSoSeq;
//	}
	public void setTrsp_so_seq(String[] trspSoSeq) {
		if(trspSoSeq != null){
			String[] tmpArr = Arrays.copyOf(trspSoSeq,trspSoSeq.length);
			this.trspSoSeq = tmpArr;
		}
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
//	public String[] getCxl_rqst_rsn() {
//		return cxlRqstRsn;
//	}
	
	public String[] getCxl_rqst_rsn() {
		String[] rtnArr = null;
		if(this.cxlRqstRsn != null){
			rtnArr = Arrays.copyOf(cxlRqstRsn,cxlRqstRsn.length);
		}
		return rtnArr;
	}

	/**
	 * @param cxlRqstRsn The cxlRqstRsn to set.
	 */
//	public void setCxl_rqst_rsn(String[] cxlRqstRsn) {
//		this.cxlRqstRsn = cxlRqstRsn;
//	}
	public void setCxl_rqst_rsn(String[] cxlRqstRsn) {
		if(cxlRqstRsn != null){
			String[] tmpArr = Arrays.copyOf(cxlRqstRsn,cxlRqstRsn.length);
			this.cxlRqstRsn = tmpArr;
		}
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
		String[] rtnArr = null;
		if(this.bilIssKnt != null){
			rtnArr = Arrays.copyOf(bilIssKnt,bilIssKnt.length);
		}
		return rtnArr;
	}

	/**
	 * @param bilIssKnt The bilIssKnt to set.
	 */
//	public void setBil_iss_knt(String[] bilIssKnt) {
//		this.bilIssKnt = bilIssKnt;
//	}
	public void setBil_iss_knt(String[] bilIssKnt) {
		if(bilIssKnt != null){
			String[] tmpArr = Arrays.copyOf(bilIssKnt,bilIssKnt.length);
			this.bilIssKnt = tmpArr;
		}
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
//	public String[] getSpcl_instr_rmk() {
//		return spclInstrRmk;
//	}
	public String[] getSpcl_instr_rmk() {
		String[] rtnArr = null;
		if(this.spclInstrRmk != null){
			rtnArr = Arrays.copyOf(spclInstrRmk,spclInstrRmk.length);
		}
		return rtnArr;
	}

	/**
	 * @param spclInstrRmk The spclInstrRmk to set.
	 */
//	public void setSpcl_instr_rmk(String[] spclInstrRmk) {
//		this.spclInstrRmk = spclInstrRmk;
//	}
	
	public void setSpcl_instr_rmk(String[] spclInstrRmk) {
		if(spclInstrRmk != null){
			String[] tmpArr = Arrays.copyOf(spclInstrRmk, spclInstrRmk.length);
			this.spclInstrRmk = tmpArr;
		}
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
//	public String[] getRail_ord_rjct_flg() {
//		return railOrdRjctFlg;
//	}
	public String[] getRail_ord_rjct_flg() {
		String[] rtnArr = null;
		if(this.railOrdRjctFlg != null){
			rtnArr = Arrays.copyOf(railOrdRjctFlg, railOrdRjctFlg.length);
		}
		return rtnArr;
	}


	/**
	 * @param railOrdRjctFlg The railOrdRjctFlg to set.
	 */
//	public void setRail_ord_rjct_flg(String[] railOrdRjctFlg) {
//		this.railOrdRjctFlg = railOrdRjctFlg;
//	}
	public void setRail_ord_rjct_flg(String[] railOrdRjctFlg) {
		if(railOrdRjctFlg != null){
			String[] tmpArr = Arrays.copyOf(railOrdRjctFlg, railOrdRjctFlg.length);
			this.railOrdRjctFlg = tmpArr;
		}
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
//	public String[] getWo_rjct_rsn() {
//		return woRjctRsn;
//	}
	public String[] getWo_rjct_rsn() {
		String[] rtnArr = null;
		if(this.woRjctRsn != null){
			rtnArr = Arrays.copyOf(woRjctRsn, woRjctRsn.length);
		}
		return rtnArr;
	}

	/**
	 * @param woRjctRsn The woRjctRsn to set.
	 */
//	public void setWo_rjct_rsn(String[] woRjctRsn) {
//		this.woRjctRsn = woRjctRsn;
//	}
	public void setWo_rjct_rsn(String[] woRjctRsn) {
		if(woRjctRsn != null){
			String[] tmpArr = Arrays.copyOf(woRjctRsn, woRjctRsn.length);
			this.woRjctRsn = tmpArr;
		}
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
//	public String[] getInter_rmk() {
//		return interRmk;
//	}
	public String[] getInter_rmk() {
		String[] rtnArr = null;
		if(this.interRmk != null){
			rtnArr = Arrays.copyOf(interRmk, interRmk.length);
		}
		return rtnArr;
	}
	/**
	 * @param interRmk The interRmk to set.
	 */
//	public void setInter_rmk(String[] interRmk) {
//		this.interRmk = interRmk;
//	}
	public void setInter_rmk(String[] interRmk) {
		if(interRmk != null){
			String[] tmpArr =  Arrays.copyOf(interRmk, interRmk.length);
			this.interRmk = tmpArr;
		}
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
//	public String[] getFm_nod_cd() {
//		return fmNodCd;
//	}
	public String[] getFm_nod_cd() {
		String[] rtnArr = null;
		if(this.fmNodCd != null){
			rtnArr = Arrays.copyOf(fmNodCd, fmNodCd.length);
		}
		return rtnArr;
	}

	/**
	 * @param fmNodCd The fmNodCd to set.
	 */
//	public void setFm_nod_cd(String[] fmNodCd) {
//		this.fmNodCd = fmNodCd;
//	}
	public void setFm_nod_cd(String[] fmNodCd) {
		if(fmNodCd != null){
			String[] tmpArr = Arrays.copyOf(fmNodCd, fmNodCd.length);
			this.fmNodCd = tmpArr;
		}
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
//	public String[] getTo_nod_cd() {
//		return toNodCd;
//	}
	public String[] getTo_nod_cd() {
		String[] rtnArr = null;
		if(this.toNodCd != null){
			rtnArr = Arrays.copyOf(toNodCd, toNodCd.length);
		}
		return rtnArr;
	}
	/**
	 * @param toNodCd The toNodCd to set.
	 */
//	public void setTo_nod_cd(String[] toNodCd) {
//		this.toNodCd = toNodCd;
//	}
	public void setTo_nod_cd(String[] toNodCd) {
		if(toNodCd != null){
			String[] tmpArr = Arrays.copyOf(toNodCd, toNodCd.length);
			this.toNodCd = tmpArr;
		}
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
//	public String[] getBl_no() {
//		return blNo;
//	}
	public String[] getBl_no() {
		String[] rtnArr = null;
		if(this.blNo != null){
			rtnArr = Arrays.copyOf(blNo, blNo.length);
		}
		return rtnArr;
	}

	/**
	 * @param blNo The blNo to set.
	 */
//	public void setBl_no(String[] blNo) {
//		this.blNo = blNo;
//	}
	
	public void setBl_no(String[] blNo) {
		if(blNo != null){
			String[] tmpArr = Arrays.copyOf(blNo, blNo.length);
			this.blNo = tmpArr;		
		}
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
//	public String[] getBl_no_tp() {
//		return blNoTp;
//	}
	public String[] getBl_no_tp() {
		String[] rtnArr = null;
		if(this.blNoTp != null){
			rtnArr = Arrays.copyOf(blNoTp, blNoTp.length);
		}
		return rtnArr;
	}

	/**
	 * @param blNoTp The blNoTp to set.
	 */
//	public void setBl_no_tp(String[] blNoTp) {
//		this.blNoTp = blNoTp;
//	}
	
	public void setBl_no_tp(String[] blNoTp) {
		if(blNoTp != null){
			String[] tmpArr = Arrays.copyOf(blNoTp, blNoTp.length);
			this.blNoTp = tmpArr;
		}
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
//	public String[] getBl_no_chk() {
//		return blNoChk;
//	}
	public String[] getBl_no_chk() {
		String[] rtnArr = null;
		if(this.blNoChk != null){
			rtnArr = Arrays.copyOf(blNoChk, blNoChk.length);
		}
		return rtnArr;
	}

	/**
	 * @param blNoChk The blNoChk to set.
	 */
//	public void setBl_no_chk(String[] blNoChk) {
//		this.blNoChk = blNoChk;
//	}
	public void setBl_no_chk(String[] blNoChk) {
		if(blNoChk != null){
			String[] tmpArr =  Arrays.copyOf(blNoChk, blNoChk.length);
			this.blNoChk = tmpArr;
		}
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
//	public String[] getBkg_cgo_tp_cd() {
//		return bkgCgoTpCd;
//	}
	public String[] getBkg_cgo_tp_cd() {
	String[] rtnArr = null;
	if(this.bkgCgoTpCd != null){
		rtnArr = Arrays.copyOf(bkgCgoTpCd, bkgCgoTpCd.length);
	}
	return rtnArr;
}

	/**
	 * @param bkgCgoTpCd The bkgCgoTpCd to set.
	 */
//	public void setBkg_cgo_tp_cd(String[] bkgCgoTpCd) {
//		this.bkgCgoTpCd = bkgCgoTpCd;
//	}
	public void setBkg_cgo_tp_cd(String[] bkgCgoTpCd) {
		if(bkgCgoTpCd != null){
			String[] tmpArr = Arrays.copyOf(bkgCgoTpCd, bkgCgoTpCd.length);
			this.bkgCgoTpCd = tmpArr;			
		}

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
//	public String[] getCop_no() {
//		return copNo;
//	}
	public String[] getCop_no() {
		String[] rtnArr = null;
		if(this.copNo != null){
			rtnArr = Arrays.copyOf(copNo, copNo.length);
		}
		return rtnArr;
	}

	/**
	 * @param copNo The copNo to set.
	 */
//	public void setCop_no(String[] copNo) {
//		this.copNo = copNo;
//	}
	public void setCop_no(String[] copNo) {
		if(copNo != null){
			String[] tmpArr = Arrays.copyOf(copNo, copNo.length);
			this.copNo = tmpArr;
		}
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
//	public String[] getCost_act_grp_seq() {
//		return costActGrpSeq;
//	}
	public String[] getCost_act_grp_seq() {
		String[] rtnArr = null;
		if(this.costActGrpSeq != null){
			rtnArr = Arrays.copyOf(costActGrpSeq, costActGrpSeq.length);
		}
		return rtnArr;
	}

	/**
	 * @param costActGrpSeq The costActGrpSeq to set.
	 */
//	public void setCost_act_grp_seq(String[] costActGrpSeq) {
//		this.costActGrpSeq = costActGrpSeq;
//	}
	public void setCost_act_grp_seq(String[] costActGrpSeq) {
		if(costActGrpSeq != null){
			String[] tmpArr = Arrays.copyOf(costActGrpSeq, costActGrpSeq.length);
			this.costActGrpSeq = tmpArr;
		}
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
//	public String[] getRepo_pln_id() {
//		return repoPlnId;
//	}
	public String[] getRepo_pln_id() {
		String[] rtnArr = null;
		if(this.repoPlnId != null){
			rtnArr = Arrays.copyOf(repoPlnId, repoPlnId.length);
		}
		return rtnArr;
	}

	/**
	 * @param repoPlnId The repoPlnId to set.
	 */
//	public void setRepo_pln_id(String[] repoPlnId) {
//		this.repoPlnId = repoPlnId;
//	}
	
	public void setRepo_pln_id(String[] repoPlnId) {
		if(repoPlnId != null){
			String[] tmpArr = Arrays.copyOf(repoPlnId, repoPlnId.length);
			this.repoPlnId = tmpArr;
		}
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
//	public String[] getPln_yrwk() {
//		return plnYrwk;
//	}
	public String[] getPln_yrwk() {
		String[] rtnArr = null;
		if(this.plnYrwk != null){
			rtnArr = Arrays.copyOf(plnYrwk, plnYrwk.length);
		}
		return rtnArr;
	}

	/**
	 * @param plnYrwk The plnYrwk to set.
	 */
//	public void setPln_yrwk(String[] plnYrwk) {
//		this.plnYrwk = plnYrwk;
//	}
	public void setPln_yrwk(String[] plnYrwk) {
		if(plnYrwk != null){
			String[] tmpArr = Arrays.copyOf(plnYrwk, plnYrwk.length);
			this.plnYrwk = tmpArr;
		}
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
//	public String[] getRef_id() {
//		return refId;
//	}
	public String[] getRef_id() {
		String[] rtnArr = null;
		if(this.refId != null){
			rtnArr = Arrays.copyOf(refId, refId.length);
		}
		return rtnArr;
	}

	/**
	 * @param refId The refId to set.
	 */
//	public void setRef_id(String[] refId) {
//		this.refId = refId;
//	}
	public void setRef_id(String[] refId) {
		if(refId != null){
			String[] tmpArr = Arrays.copyOf(refId, refId.length);
			this.refId = tmpArr;
		}
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
//	public String[] getRef_seq() {
//		return refSeq;
//	}
	
	public String[] getRef_seq() {
		String[] rtnArr = null;
		if(this.refSeq != null){
			rtnArr = Arrays.copyOf(refSeq, refSeq.length);
		}
		return rtnArr;
	}

	/**
	 * @param refSeq The refSeq to set.
	 */
//	public void setRef_seq(String[] refSeq) {
//		this.refSeq = refSeq;
//	}
	
	public void setRef_seq(String[] refSeq) {
		if( refSeq != null){
			String[] tmpArr = Arrays.copyOf(refSeq, refSeq.length);
			this.refSeq = tmpArr;
		}
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
//	public String[] getIbflag() {
//		return ibflag;
//	}
	public String[] getIbflag() {
		String[] rtnArr = null;
		if(this.ibflag != null){
			rtnArr = Arrays.copyOf(ibflag, ibflag.length);
		}
		return rtnArr;
	}

	/**
	 * @param refSeq The refSeq to set.
	 */
	public void setIbflag(String[] ibflag) {
		if(ibflag != null){
			String[] tmpArr = Arrays.copyOf(ibflag, ibflag.length);
			this.ibflag = tmpArr;
		}
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
		String[] rtnArr = null;
		if(this.trspRqstBkgFlg != null){
			rtnArr = Arrays.copyOf(trspRqstBkgFlg, trspRqstBkgFlg.length);
		}
		return rtnArr;
	}

	/**
	 * @param trspRqstBkgFlg The trspRqstBkgFlg to set.
	 */
//	public void setTrsp_rqst_bkg_flg(String[] trspRqstBkgFlg) {
//		this.trspRqstBkgFlg = trspRqstBkgFlg;
//	}
	public void setTrsp_rqst_bkg_flg(String[] trspRqstBkgFlg) {
		if(trspRqstBkgFlg != null){
			String[] tmpArr = Arrays.copyOf(trspRqstBkgFlg, trspRqstBkgFlg.length);
			this.trspRqstBkgFlg = tmpArr;
		}
	}
	
	/**
	 * @return Returns the cgoTpCd.
	 */
	public String[] getCgo_tp_cd() {
		String[] rtnArr = null;
		if(this.cgoTpCd != null){
			rtnArr = Arrays.copyOf(cgoTpCd, cgoTpCd.length);
		}
		return rtnArr;
	}

	/**
	 * @param cgoTpCd The cgoTpCd to set.
	 */
	public void setCgo_tp_cd(String[] cgoTpCd) {
		if(cgoTpCd != null){
			String[] tmpArr = Arrays.copyOf(cgoTpCd, cgoTpCd.length);
			this.cgoTpCd = tmpArr;
		}
	}
	
	/**
	 * @return Returns the bkgNo.
	 */
//	public String[] getBkg_no() {
//		return bkgNo;
//	}
	public String[] getBkg_no() {
		String[] rtnArr = null;
		if(this.bkgNo != null){
			rtnArr = Arrays.copyOf(bkgNo, bkgNo.length);
		}
		return rtnArr;
	}

	/**
	 * @param bkgNo The bkgNo to set.
	 */
//	public void setBkg_no(String[] bkgNo) {
//		this.bkgNo = bkgNo;
//	}
	public void setBkg_no(String[] bkgNo) {
		if(bkgNo != null){
			String[] tmpArr = Arrays.copyOf(bkgNo, bkgNo.length);
			this.bkgNo = tmpArr;
		}
	}	
	/**
	 * @return Returns the bkgNoSplit.
	 */
//	public String[] getBkg_no_split() {
//		return bkgNoSplit;
//	}
	public String[] getBkg_no_split() {
		String[] rtnArr = null;
		if(this.bkgNoSplit != null){
			rtnArr = Arrays.copyOf(bkgNoSplit,bkgNoSplit.length);
		}
		return rtnArr;
	}

	/**
	 * @param bkgNoSplit The bkgNoSplit to set.
	 */
//	public void setBkg_no_split(String[] bkgNoSplit) {
//		this.bkgNoSplit = bkgNoSplit;
//	}
	public void setBkg_no_split(String[] bkgNoSplit) {
		if(bkgNoSplit != null){
			String[] tmpArr = Arrays.copyOf(bkgNoSplit,bkgNoSplit.length);
			this.bkgNoSplit = tmpArr;
		}
	}
	
	/**
	 * @return Returns the vndrSeq.
	 */
//	public String[] getVndr_seq() {
//		return vndrSeq;
//	}
	public String[] getVndr_seq() {
		String[] rtnArr = null;
		if(this.vndrSeq != null){
			rtnArr = Arrays.copyOf(vndrSeq,vndrSeq.length);
		}
		return rtnArr;
	}

	/**
	 * @param vndrSeq The vndrSeq to set.
	 */
//	public void setVndr_seq(String[] vndrSeq) {
//		this.vndrSeq = vndrSeq;
//	}
	public void setVndr_seq(String[] vndrSeq) {
		if(vndrSeq != null){
			String[] tmpArr = Arrays.copyOf(vndrSeq,vndrSeq.length);
			this.vndrSeq = tmpArr;
		}
	}
	
	/**
	 * @return Returns the eqNo.
	 */
//	public String[] getEq_no() {
//		return eqNo;
//	}
	public String[] getEq_no() {
		String[] rtnArr = null;
		if(this.eqNo != null){
			rtnArr = Arrays.copyOf(eqNo,eqNo.length);
		}
		return rtnArr;
	}

	/**
	 * @param eqNo The eqNo to set.
	 */
//	public void setEq_no(String[] eqNo) {
//		this.eqNo = eqNo;
//	}
	public void setEq_no(String[] eqNo) {
		if(eqNo != null){
			String[] tmpArr =  Arrays.copyOf(eqNo,eqNo.length);
			this.eqNo = tmpArr;
		}
	}
	
	/**
	 * @return Returns the eqTpszCd.
	 */
//	public String[] getEq_tpsz_cd() {
//		return eqTpszCd;
//	}
	public String[] getEq_tpsz_cd() {
		String[] rtnArr = null;
		if(this.eqTpszCd != null){
			rtnArr = Arrays.copyOf(eqTpszCd,eqTpszCd.length);
		}
		return rtnArr;
	}
	/**
	 * @param eqTpszCd The eqTpszCd to set.
	 */
//	public void setEq_tpsz_cd(String[] eqTpszCd) {
//		this.eqTpszCd = eqTpszCd;
//	}
	public void setEq_tpsz_cd(String[] eqTpszCd) {
		if(eqTpszCd != null){
			String[] tmpArr =  Arrays.copyOf(eqTpszCd,eqTpszCd.length);
			this.eqTpszCd = tmpArr;			
		}

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
