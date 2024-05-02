/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomAcctCateVO.java
*@FileTitle : CustomAcctCateVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.22
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.04.22 윤세영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 윤세영
 * @since J2EE 1.5
 * @see ESM_FMS_0003HTMLAction
 */

public class CustomAcctCateVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomAcctCateVO> models = new ArrayList<CustomAcctCateVO>();
	
	/* 而щ읆 �ㅻ챸 */
	private String chkOffHire = null;
	/* 而щ읆 �ㅻ챸 */
	private String acctCd = null;
	/* 而щ읆 �ㅻ챸 */
	private String chkCharterer = null;
	/* 而щ읆 �ㅻ챸 */
	private String chkPrepayments = null;
	/* 而щ읆 �ㅻ챸 */
	private String acctItmSeq = null;
	/* 而щ읆 �ㅻ챸 */
	private String updUsrId = null;
	/* 而щ읆 �ㅻ챸 */
	private String chkPrepaymentp = null;
	/* 而щ읆 �ㅻ챸 */
	private String prevOtherExp = null;
	/* 而щ읆 �ㅻ챸 */
	private String prevVvdRequired = null;
	/* 而щ읆 �ㅻ챸 */
	private String chkVvdRequired = null;
	/* 而щ읆 �ㅻ챸 */
	private String chkBodborIf = null;
	/* 而щ읆 �ㅻ챸 */
	private String prevPrepayments = null;
	/* 而щ읆 �ㅻ챸 */
	private String chkOtherExp = null;
	/* 而щ읆 �ㅻ챸 */
	private String fletAcctCateCd = null;
	/* 而щ읆 �ㅻ챸 */
	private String prevOwner = null;
	/* 而щ읆 �ㅻ챸 */
	private String chkOwner = null;
	/* 而щ읆 �ㅻ챸 */
	private String prevPrepaymentp = null;
	/* �곹깭 */
	private String ibflag = null;
	/* 而щ읆 �ㅻ챸 */
	private String prevManualSlip = null;
	/* 而щ읆 �ㅻ챸 */
	private String prevOffHire = null;
	/* 而щ읆 �ㅻ챸 */
	private String prevCharterer = null;
	/* 而щ읆 �ㅻ챸 */
	private String prevBodborIf = null;
	/* 而щ읆 �ㅻ챸 */
	private String creUsrId = null;
	/* 而щ읆 �ㅻ챸 */
	private String chkManualSlip = null;
	/* 而щ읆 �ㅻ챸 */
	private String acctEngNm = null;
	/* 而щ읆 �ㅻ챸 */
	private String acctItmNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	/**
	  * 생성자
	  * @param
	  * @return 
	  */
	
	public CustomAcctCateVO() {}

	/**
	 * 생성자
	 * @param String ibflag, String pagerows, String acctCd, String acctEngNm, String acctItmSeq, String acctItmNm, String chkOtherExp, String chkCharterer, String chkOwner, String chkPrepaymentp, String chkPrepayments, String chkManualSlip, String chkOffHire, String chkVvdRequired, String chkBodborIf, String prevOtherExp, String prevCharterer, String prevOwner, String prevPrepaymentp, String prevPrepayments, String prevManualSlip, String prevOffHire, String prevVvdRequired, String prevBodborIf, String fletAcctCateCd, String creUsrId, String updUsrId
	 * @return 
	 */
	public CustomAcctCateVO(String ibflag, String pagerows, String acctCd, String acctEngNm, String acctItmSeq, String acctItmNm, String chkOtherExp, String chkCharterer, String chkOwner, String chkPrepaymentp, String chkPrepayments, String chkManualSlip, String chkOffHire, String chkVvdRequired, String chkBodborIf, String prevOtherExp, String prevCharterer, String prevOwner, String prevPrepaymentp, String prevPrepayments, String prevManualSlip, String prevOffHire, String prevVvdRequired, String prevBodborIf, String fletAcctCateCd, String creUsrId, String updUsrId) {
		this.chkOffHire = chkOffHire;
		this.acctCd = acctCd;
		this.chkCharterer = chkCharterer;
		this.chkPrepayments = chkPrepayments;
		this.acctItmSeq = acctItmSeq;
		this.updUsrId = updUsrId;
		this.chkPrepaymentp = chkPrepaymentp;
		this.prevOtherExp = prevOtherExp;
		this.prevVvdRequired = prevVvdRequired;
		this.chkVvdRequired = chkVvdRequired;
		this.chkBodborIf = chkBodborIf;
		this.prevPrepayments = prevPrepayments;
		this.chkOtherExp = chkOtherExp;
		this.fletAcctCateCd = fletAcctCateCd;
		this.prevOwner = prevOwner;
		this.chkOwner = chkOwner;
		this.prevPrepaymentp = prevPrepaymentp;
		this.ibflag = ibflag;
		this.prevManualSlip = prevManualSlip;
		this.prevOffHire = prevOffHire;
		this.prevCharterer = prevCharterer;
		this.prevBodborIf = prevBodborIf;
		this.creUsrId = creUsrId;
		this.chkManualSlip = chkManualSlip;
		this.acctEngNm = acctEngNm;
		this.acctItmNm = acctItmNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("chk_off_hire", getChkOffHire());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("chk_charterer", getChkCharterer());
		this.hashColumns.put("chk_prepayments", getChkPrepayments());
		this.hashColumns.put("acct_itm_seq", getAcctItmSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("chk_prepaymentp", getChkPrepaymentp());
		this.hashColumns.put("prev_other_exp", getPrevOtherExp());
		this.hashColumns.put("prev_vvd_required", getPrevVvdRequired());
		this.hashColumns.put("chk_vvd_required", getChkVvdRequired());
		this.hashColumns.put("chk_bodbor_if", getChkBodborIf());
		this.hashColumns.put("prev_prepayments", getPrevPrepayments());
		this.hashColumns.put("chk_other_exp", getChkOtherExp());
		this.hashColumns.put("flet_acct_cate_cd", getFletAcctCateCd());
		this.hashColumns.put("prev_owner", getPrevOwner());
		this.hashColumns.put("chk_owner", getChkOwner());
		this.hashColumns.put("prev_prepaymentp", getPrevPrepaymentp());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("prev_manual_slip", getPrevManualSlip());
		this.hashColumns.put("prev_off_hire", getPrevOffHire());
		this.hashColumns.put("prev_charterer", getPrevCharterer());
		this.hashColumns.put("prev_bodbor_if", getPrevBodborIf());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("chk_manual_slip", getChkManualSlip());
		this.hashColumns.put("acct_eng_nm", getAcctEngNm());
		this.hashColumns.put("acct_itm_nm", getAcctItmNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("chk_off_hire", "chkOffHire");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("chk_charterer", "chkCharterer");
		this.hashFields.put("chk_prepayments", "chkPrepayments");
		this.hashFields.put("acct_itm_seq", "acctItmSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("chk_prepaymentp", "chkPrepaymentp");
		this.hashFields.put("prev_other_exp", "prevOtherExp");
		this.hashFields.put("prev_vvd_required", "prevVvdRequired");
		this.hashFields.put("chk_vvd_required", "chkVvdRequired");
		this.hashFields.put("chk_bodbor_if", "chkBodborIf");
		this.hashFields.put("prev_prepayments", "prevPrepayments");
		this.hashFields.put("chk_other_exp", "chkOtherExp");
		this.hashFields.put("flet_acct_cate_cd", "fletAcctCateCd");
		this.hashFields.put("prev_owner", "prevOwner");
		this.hashFields.put("chk_owner", "chkOwner");
		this.hashFields.put("prev_prepaymentp", "prevPrepaymentp");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("prev_manual_slip", "prevManualSlip");
		this.hashFields.put("prev_off_hire", "prevOffHire");
		this.hashFields.put("prev_charterer", "prevCharterer");
		this.hashFields.put("prev_bodbor_if", "prevBodborIf");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("chk_manual_slip", "chkManualSlip");
		this.hashFields.put("acct_eng_nm", "acctEngNm");
		this.hashFields.put("acct_itm_nm", "acctItmNm");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getChkOffHire() {
		return this.chkOffHire;
	}
	public String getAcctCd() {
		return this.acctCd;
	}
	public String getChkCharterer() {
		return this.chkCharterer;
	}
	public String getChkPrepayments() {
		return this.chkPrepayments;
	}
	public String getAcctItmSeq() {
		return this.acctItmSeq;
	}
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	public String getChkPrepaymentp() {
		return this.chkPrepaymentp;
	}
	public String getPrevOtherExp() {
		return this.prevOtherExp;
	}
	public String getPrevVvdRequired() {
		return this.prevVvdRequired;
	}
	public String getChkVvdRequired() {
		return this.chkVvdRequired;
	}
	public String getChkBodborIf() {
		return this.chkBodborIf;
	}
	public String getPrevPrepayments() {
		return this.prevPrepayments;
	}
	public String getChkOtherExp() {
		return this.chkOtherExp;
	}
	public String getFletAcctCateCd() {
		return this.fletAcctCateCd;
	}
	public String getPrevOwner() {
		return this.prevOwner;
	}
	public String getChkOwner() {
		return this.chkOwner;
	}
	public String getPrevPrepaymentp() {
		return this.prevPrepaymentp;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getPrevManualSlip() {
		return this.prevManualSlip;
	}
	public String getPrevOffHire() {
		return this.prevOffHire;
	}
	public String getPrevCharterer() {
		return this.prevCharterer;
	}
	public String getPrevBodborIf() {
		return this.prevBodborIf;
	}
	public String getCreUsrId() {
		return this.creUsrId;
	}
	public String getChkManualSlip() {
		return this.chkManualSlip;
	}
	public String getAcctEngNm() {
		return this.acctEngNm;
	}
	public String getAcctItmNm() {
		return this.acctItmNm;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setChkOffHire(String chkOffHire) {
		this.chkOffHire = chkOffHire;
		//this.chkOffHire=true;
	}
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
		//this.acctCd=true;
	}
	public void setChkCharterer(String chkCharterer) {
		this.chkCharterer = chkCharterer;
		//this.chkCharterer=true;
	}
	public void setChkPrepayments(String chkPrepayments) {
		this.chkPrepayments = chkPrepayments;
		//this.chkPrepayments=true;
	}
	public void setAcctItmSeq(String acctItmSeq) {
		this.acctItmSeq = acctItmSeq;
		//this.acctItmSeq=true;
	}
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
		//this.updUsrId=true;
	}
	public void setChkPrepaymentp(String chkPrepaymentp) {
		this.chkPrepaymentp = chkPrepaymentp;
		//this.chkPrepaymentp=true;
	}
	public void setPrevOtherExp(String prevOtherExp) {
		this.prevOtherExp = prevOtherExp;
		//this.prevOtherExp=true;
	}
	public void setPrevVvdRequired(String prevVvdRequired) {
		this.prevVvdRequired = prevVvdRequired;
		//this.prevVvdRequired=true;
	}
	public void setChkVvdRequired(String chkVvdRequired) {
		this.chkVvdRequired = chkVvdRequired;
		//this.chkVvdRequired=true;
	}
	public void setChkBodborIf(String chkBodborIf) {
		this.chkBodborIf = chkBodborIf;
		//this.chkBodborIf=true;
	}
	public void setPrevPrepayments(String prevPrepayments) {
		this.prevPrepayments = prevPrepayments;
		//this.prevPrepayments=true;
	}
	public void setChkOtherExp(String chkOtherExp) {
		this.chkOtherExp = chkOtherExp;
		//this.chkOtherExp=true;
	}
	public void setFletAcctCateCd(String fletAcctCateCd) {
		this.fletAcctCateCd = fletAcctCateCd;
		//this.fletAcctCateCd=true;
	}
	public void setPrevOwner(String prevOwner) {
		this.prevOwner = prevOwner;
		//this.prevOwner=true;
	}
	public void setChkOwner(String chkOwner) {
		this.chkOwner = chkOwner;
		//this.chkOwner=true;
	}
	public void setPrevPrepaymentp(String prevPrepaymentp) {
		this.prevPrepaymentp = prevPrepaymentp;
		//this.prevPrepaymentp=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setPrevManualSlip(String prevManualSlip) {
		this.prevManualSlip = prevManualSlip;
		//this.prevManualSlip=true;
	}
	public void setPrevOffHire(String prevOffHire) {
		this.prevOffHire = prevOffHire;
		//this.prevOffHire=true;
	}
	public void setPrevCharterer(String prevCharterer) {
		this.prevCharterer = prevCharterer;
		//this.prevCharterer=true;
	}
	public void setPrevBodborIf(String prevBodborIf) {
		this.prevBodborIf = prevBodborIf;
		//this.prevBodborIf=true;
	}
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
		//this.creUsrId=true;
	}
	public void setChkManualSlip(String chkManualSlip) {
		this.chkManualSlip = chkManualSlip;
		//this.chkManualSlip=true;
	}
	public void setAcctEngNm(String acctEngNm) {
		this.acctEngNm = acctEngNm;
		//this.acctEngNm=true;
	}
	public void setAcctItmNm(String acctItmNm) {
		this.acctItmNm = acctItmNm;
		//this.acctItmNm=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setChkOffHire(JSPUtil.getParameter(request, "chk_off_hire", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setChkCharterer(JSPUtil.getParameter(request, "chk_charterer", ""));
		setChkPrepayments(JSPUtil.getParameter(request, "chk_prepayments", ""));
		setAcctItmSeq(JSPUtil.getParameter(request, "acct_itm_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setChkPrepaymentp(JSPUtil.getParameter(request, "chk_prepaymentp", ""));
		setPrevOtherExp(JSPUtil.getParameter(request, "prev_other_exp", ""));
		setPrevVvdRequired(JSPUtil.getParameter(request, "prev_vvd_required", ""));
		setChkVvdRequired(JSPUtil.getParameter(request, "chk_vvd_required", ""));
		setChkBodborIf(JSPUtil.getParameter(request, "chk_bodbor_if", ""));
		setPrevPrepayments(JSPUtil.getParameter(request, "prev_prepayments", ""));
		setChkOtherExp(JSPUtil.getParameter(request, "chk_other_exp", ""));
		setFletAcctCateCd(JSPUtil.getParameter(request, "flet_acct_cate_cd", ""));
		setPrevOwner(JSPUtil.getParameter(request, "prev_owner", ""));
		setChkOwner(JSPUtil.getParameter(request, "chk_owner", ""));
		setPrevPrepaymentp(JSPUtil.getParameter(request, "prev_prepaymentp", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPrevManualSlip(JSPUtil.getParameter(request, "prev_manual_slip", ""));
		setPrevOffHire(JSPUtil.getParameter(request, "prev_off_hire", ""));
		setPrevCharterer(JSPUtil.getParameter(request, "prev_charterer", ""));
		setPrevBodborIf(JSPUtil.getParameter(request, "prev_bodbor_if", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setChkManualSlip(JSPUtil.getParameter(request, "chk_manual_slip", ""));
		setAcctEngNm(JSPUtil.getParameter(request, "acct_eng_nm", ""));
		setAcctItmNm(JSPUtil.getParameter(request, "acct_itm_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public CustomAcctCateVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public CustomAcctCateVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomAcctCateVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] chkOffHire = (JSPUtil.getParameter(request, prefix	+ "chk_off_hire".trim(), length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd".trim(), length));
			String[] chkCharterer = (JSPUtil.getParameter(request, prefix	+ "chk_charterer".trim(), length));
			String[] chkPrepayments = (JSPUtil.getParameter(request, prefix	+ "chk_prepayments".trim(), length));
			String[] acctItmSeq = (JSPUtil.getParameter(request, prefix	+ "acct_itm_seq".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] chkPrepaymentp = (JSPUtil.getParameter(request, prefix	+ "chk_prepaymentp".trim(), length));
			String[] prevOtherExp = (JSPUtil.getParameter(request, prefix	+ "prev_other_exp".trim(), length));
			String[] prevVvdRequired = (JSPUtil.getParameter(request, prefix	+ "prev_vvd_required".trim(), length));
			String[] chkVvdRequired = (JSPUtil.getParameter(request, prefix	+ "chk_vvd_required".trim(), length));
			String[] chkBodborIf = (JSPUtil.getParameter(request, prefix	+ "chk_bodbor_if".trim(), length));
			String[] prevPrepayments = (JSPUtil.getParameter(request, prefix	+ "prev_prepayments".trim(), length));
			String[] chkOtherExp = (JSPUtil.getParameter(request, prefix	+ "chk_other_exp".trim(), length));
			String[] fletAcctCateCd = (JSPUtil.getParameter(request, prefix	+ "flet_acct_cate_cd".trim(), length));
			String[] prevOwner = (JSPUtil.getParameter(request, prefix	+ "prev_owner".trim(), length));
			String[] chkOwner = (JSPUtil.getParameter(request, prefix	+ "chk_owner".trim(), length));
			String[] prevPrepaymentp = (JSPUtil.getParameter(request, prefix	+ "prev_prepaymentp".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] prevManualSlip = (JSPUtil.getParameter(request, prefix	+ "prev_manual_slip".trim(), length));
			String[] prevOffHire = (JSPUtil.getParameter(request, prefix	+ "prev_off_hire".trim(), length));
			String[] prevCharterer = (JSPUtil.getParameter(request, prefix	+ "prev_charterer".trim(), length));
			String[] prevBodborIf = (JSPUtil.getParameter(request, prefix	+ "prev_bodbor_if".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] chkManualSlip = (JSPUtil.getParameter(request, prefix	+ "chk_manual_slip".trim(), length));
			String[] acctEngNm = (JSPUtil.getParameter(request, prefix	+ "acct_eng_nm".trim(), length));
			String[] acctItmNm = (JSPUtil.getParameter(request, prefix	+ "acct_itm_nm".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomAcctCateVO();
				if (chkOffHire[i] != null)
					model.setChkOffHire(chkOffHire[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (chkCharterer[i] != null)
					model.setChkCharterer(chkCharterer[i]);
				if (chkPrepayments[i] != null)
					model.setChkPrepayments(chkPrepayments[i]);
				if (acctItmSeq[i] != null)
					model.setAcctItmSeq(acctItmSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (chkPrepaymentp[i] != null)
					model.setChkPrepaymentp(chkPrepaymentp[i]);
				if (prevOtherExp[i] != null)
					model.setPrevOtherExp(prevOtherExp[i]);
				if (prevVvdRequired[i] != null)
					model.setPrevVvdRequired(prevVvdRequired[i]);
				if (chkVvdRequired[i] != null)
					model.setChkVvdRequired(chkVvdRequired[i]);
				if (chkBodborIf[i] != null)
					model.setChkBodborIf(chkBodborIf[i]);
				if (prevPrepayments[i] != null)
					model.setPrevPrepayments(prevPrepayments[i]);
				if (chkOtherExp[i] != null)
					model.setChkOtherExp(chkOtherExp[i]);
				if (fletAcctCateCd[i] != null)
					model.setFletAcctCateCd(fletAcctCateCd[i]);
				if (prevOwner[i] != null)
					model.setPrevOwner(prevOwner[i]);
				if (chkOwner[i] != null)
					model.setChkOwner(chkOwner[i]);
				if (prevPrepaymentp[i] != null)
					model.setPrevPrepaymentp(prevPrepaymentp[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (prevManualSlip[i] != null)
					model.setPrevManualSlip(prevManualSlip[i]);
				if (prevOffHire[i] != null)
					model.setPrevOffHire(prevOffHire[i]);
				if (prevCharterer[i] != null)
					model.setPrevCharterer(prevCharterer[i]);
				if (prevBodborIf[i] != null)
					model.setPrevBodborIf(prevBodborIf[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (chkManualSlip[i] != null)
					model.setChkManualSlip(chkManualSlip[i]);
				if (acctEngNm[i] != null)
					model.setAcctEngNm(acctEngNm[i]);
				if (acctItmNm[i] != null)
					model.setAcctItmNm(acctItmNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getCustomAcctCateVOs();
	}

	public CustomAcctCateVO[] getCustomAcctCateVOs(){
		CustomAcctCateVO[] vos = (CustomAcctCateVO[])models.toArray(new CustomAcctCateVO[models.size()]);
		return vos;
	}
	
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {}
		return ret.toString();
	}
	
	/**
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 * @throws IllegalAccessException
	 */
	private String[] getField(Field[] field, int i) throws IllegalAccessException {
		String[] arr;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void onDataFormat(){
		this.chkOffHire = this.chkOffHire .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkCharterer = this.chkCharterer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkPrepayments = this.chkPrepayments .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctItmSeq = this.acctItmSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkPrepaymentp = this.chkPrepaymentp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prevOtherExp = this.prevOtherExp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prevVvdRequired = this.prevVvdRequired .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkVvdRequired = this.chkVvdRequired .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkBodborIf = this.chkBodborIf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prevPrepayments = this.prevPrepayments .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkOtherExp = this.chkOtherExp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletAcctCateCd = this.fletAcctCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prevOwner = this.prevOwner .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkOwner = this.chkOwner .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prevPrepaymentp = this.prevPrepaymentp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prevManualSlip = this.prevManualSlip .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prevOffHire = this.prevOffHire .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prevCharterer = this.prevCharterer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prevBodborIf = this.prevBodborIf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkManualSlip = this.chkManualSlip .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctEngNm = this.acctEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctItmNm = this.acctItmNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
