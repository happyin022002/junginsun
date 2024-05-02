/*=========================================================
 *@FileName : EsdTrs0087Event.java
 *@FileTitle :  CNT(Customer Nominated Trucker) Approval
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014-06-17
 *@LastModifier : 김도현
 *@LastVersion : 1.0
 * 1.0 최초 생성
=========================================================*/

package com.hanjin.apps.alps.esd.trs.codemanage.cnt.event;

//import com.hanjin.apps.alps.esd.trs.codemanage.cnt.vo.SearchApprovalMgmtVO;
import java.util.Arrays;

import com.hanjin.apps.alps.esd.trs.codemanage.cnt.vo.SearchCntApprovalVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_TRS_087 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_087HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김도현
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0087Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	private SearchCntApprovalVO searchCntApprovalVO = null;
	private SearchCntApprovalVO[] searchCntApprovalVOs = null;

	String sDtDivCd  		=  "";
	String sFmDt  			=  "";
	String sToDt  			=  "";
	String sEffDt  			=  "";
	String sCtrtNo  		=  "";
	String sDispDtsCd  		=  "";
	String s_vndr_seq  		=  "";
	String sCustSeq  		=  "";
	String sCntTpCd  		=  "";
	String sDorNodCd		=  "";
	
	String io_bnd_cd		=  "";
	String vndr_seq			=  "";
	String fm_nod_cd		=  "";
	String fm_nod_yard		=  "";
	String dor_nod_cd		=  "";
	String dor_nod_yard		=  "";
	String to_nod_cd		=  "";
	String to_nod_yard		=  "";

	public SearchCntApprovalVO getSearchCntApprovalVO() {
		return searchCntApprovalVO;
	}
	public void setSearchCntApprovalVO(SearchCntApprovalVO searchCntApprovalVO) {
		this.searchCntApprovalVO = searchCntApprovalVO;
	}
	public SearchCntApprovalVO[] getSearchCntApprovalVOs() {
		SearchCntApprovalVO[] rtnVOs = null;
		if (this.searchCntApprovalVOs != null) {
			rtnVOs = Arrays.copyOf(searchCntApprovalVOs, searchCntApprovalVOs.length);
		}
		return rtnVOs;  //return searchCntApprovalVOs;
	}
	public void setSearchCntApprovalVOs(
			SearchCntApprovalVO[] searchCntApprovalVOs) {
		if(searchCntApprovalVOs != null){
			SearchCntApprovalVO[] tmpVOs = Arrays.copyOf(searchCntApprovalVOs, searchCntApprovalVOs.length);
			this.searchCntApprovalVOs = tmpVOs;  //this.searchCntApprovalVOs = searchCntApprovalVOs;
		}
	}
	public String getsDtDivCd() {
		return sDtDivCd;
	}
	public void setsDtDivCd(String sDtDivCd) {
		this.sDtDivCd = sDtDivCd;
	}
	public String getsFmDt() {
		return sFmDt;
	}
	public void setsFmDt(String sFmDt) {
		this.sFmDt = sFmDt;
	}
	public String getsToDt() {
		return sToDt;
	}
	public void setsToDt(String sToDt) {
		this.sToDt = sToDt;
	}
	public String getsEffDt() {
		return sEffDt;
	}
	public void setsEffDt(String sEffDt) {
		this.sEffDt = sEffDt;
	}
	public String getsCtrtNo() {
		return sCtrtNo;
	}
	public void setsCtrtNo(String sCtrtNo) {
		this.sCtrtNo = sCtrtNo;
	}
	public String getsDispDtsCd() {
		return sDispDtsCd;
	}
	public void setsDispDtsCd(String sDispDtsCd) {
		this.sDispDtsCd = sDispDtsCd;
	}
	public String getS_vndr_seq() {
		return s_vndr_seq;
	}
	public void setS_vndr_seq(String s_vndr_seq) {
		this.s_vndr_seq = s_vndr_seq;
	}
	public String getsCustSeq() {
		return sCustSeq;
	}
	public void setsCustSeq(String sCustSeq) {
		this.sCustSeq = sCustSeq;
	}
	public String getFm_nod_cd() {
		return fm_nod_cd;
	}
	public void setFm_nod_cd(String fm_nod_cd) {
		this.fm_nod_cd = fm_nod_cd;
	}
	public String getFm_nod_yard() {
		return fm_nod_yard;
	}
	public void setFm_nod_yard(String fm_nod_yard) {
		this.fm_nod_yard = fm_nod_yard;
	}
	public String getDor_nod_cd() {
		return dor_nod_cd;
	}
	public void setDor_nod_cd(String dor_nod_cd) {
		this.dor_nod_cd = dor_nod_cd;
	}
	public String getDor_nod_yard() {
		return dor_nod_yard;
	}
	public void setDor_nod_yard(String dor_nod_yard) {
		this.dor_nod_yard = dor_nod_yard;
	}
	public String getTo_nod_cd() {
		return to_nod_cd;
	}
	public void setTo_nod_cd(String to_nod_cd) {
		this.to_nod_cd = to_nod_cd;
	}
	public String getTo_nod_yard() {
		return to_nod_yard;
	}
	public void setTo_nod_yard(String to_nod_yard) {
		this.to_nod_yard = to_nod_yard;
	}
	public String getIo_bnd_cd() {
		return io_bnd_cd;
	}
	public void setIo_bnd_cd(String io_bnd_cd) {
		this.io_bnd_cd = io_bnd_cd;
	}
	public String getVndr_seq() {
		return vndr_seq;
	}
	public void setVndr_seq(String vndr_seq) {
		this.vndr_seq = vndr_seq;
	}
	public String getsCntTpCd() {
		return sCntTpCd;
	}
	public void setsCntTpCd(String sCntTpCd) {
		this.sCntTpCd = sCntTpCd;
	}
	/**
	 * @return the sDorNodCd
	 */
	public String getsDorNodCd() {
		return sDorNodCd;
	}
	/**
	 * @param sDorNodCd the sDorNodCd to set
	 */
	public void setsDorNodCd(String sDorNodCd) {
		this.sDorNodCd = sDorNodCd;
	}
	
}

