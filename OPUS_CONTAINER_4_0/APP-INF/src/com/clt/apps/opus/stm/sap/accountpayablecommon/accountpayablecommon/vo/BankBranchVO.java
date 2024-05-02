/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BankBranchVO.java
*@FileTitle : BankBranchVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.31
*@LastModifier : 차상영
*@LastVersion : 1.0
* 2014.03.31 차상영 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 차상영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BankBranchVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BankBranchVO> models = new ArrayList<BankBranchVO>();
	
	/* Column Info */
	private String bankBrncTpNm = null;
	/* Column Info */
	private String bankAddr2 = null;
	/* Column Info */
	private String bankAddr1 = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String cntcEml = null;
	/* Column Info */
	private String cntcPhnNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bankEndDt = null;
	/* Column Info */
	private String bankNo = null;
	/* Column Info */
	private String bankBrncDesc = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String brncCntNm = null;
	/* Column Info */
	private String bankNm = null;
	/* Column Info */
	private String brncCntCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String cntcPfxCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String brncNo = null;
	/* Column Info */
	private String bankBrncSeq = null;
	/* Column Info */
	private String cntcTitNm = null;
	/* Column Info */
	private String bankBrncNm = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cntcNm = null;
	/* Column Info */
	private String bankBrncAltnNm = null;
	/* Column Info */
	private String bankAltnNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BankBranchVO() {}

	public BankBranchVO(String ibflag, String pagerows, String bankBrncSeq, String bankNm, String bankAltnNm, String bankNo, String bankBrncNm, String bankBrncAltnNm, String brncNo, String bankBrncTpNm, String bankEndDt, String bankBrncDesc, String brncCntCd, String brncCntNm, String bankAddr1, String bankAddr2, String cntcNm, String cntcTitNm, String cntcPfxCd, String cntcPhnNo, String cntcEml, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.bankBrncTpNm = bankBrncTpNm;
		this.bankAddr2 = bankAddr2;
		this.bankAddr1 = bankAddr1;
		this.creDt = creDt;
		this.cntcEml = cntcEml;
		this.cntcPhnNo = cntcPhnNo;
		this.pagerows = pagerows;
		this.bankEndDt = bankEndDt;
		this.bankNo = bankNo;
		this.bankBrncDesc = bankBrncDesc;
		this.ibflag = ibflag;
		this.brncCntNm = brncCntNm;
		this.bankNm = bankNm;
		this.brncCntCd = brncCntCd;
		this.updUsrId = updUsrId;
		this.cntcPfxCd = cntcPfxCd;
		this.updDt = updDt;
		this.brncNo = brncNo;
		this.bankBrncSeq = bankBrncSeq;
		this.cntcTitNm = cntcTitNm;
		this.bankBrncNm = bankBrncNm;
		this.creUsrId = creUsrId;
		this.cntcNm = cntcNm;
		this.bankBrncAltnNm = bankBrncAltnNm;
		this.bankAltnNm = bankAltnNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bank_brnc_tp_nm", getBankBrncTpNm());
		this.hashColumns.put("bank_addr2", getBankAddr2());
		this.hashColumns.put("bank_addr1", getBankAddr1());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cntc_eml", getCntcEml());
		this.hashColumns.put("cntc_phn_no", getCntcPhnNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bank_end_dt", getBankEndDt());
		this.hashColumns.put("bank_no", getBankNo());
		this.hashColumns.put("bank_brnc_desc", getBankBrncDesc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("brnc_cnt_nm", getBrncCntNm());
		this.hashColumns.put("bank_nm", getBankNm());
		this.hashColumns.put("brnc_cnt_cd", getBrncCntCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cntc_pfx_cd", getCntcPfxCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("brnc_no", getBrncNo());
		this.hashColumns.put("bank_brnc_seq", getBankBrncSeq());
		this.hashColumns.put("cntc_tit_nm", getCntcTitNm());
		this.hashColumns.put("bank_brnc_nm", getBankBrncNm());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cntc_nm", getCntcNm());
		this.hashColumns.put("bank_brnc_altn_nm", getBankBrncAltnNm());
		this.hashColumns.put("bank_altn_nm", getBankAltnNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bank_brnc_tp_nm", "bankBrncTpNm");
		this.hashFields.put("bank_addr2", "bankAddr2");
		this.hashFields.put("bank_addr1", "bankAddr1");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cntc_eml", "cntcEml");
		this.hashFields.put("cntc_phn_no", "cntcPhnNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bank_end_dt", "bankEndDt");
		this.hashFields.put("bank_no", "bankNo");
		this.hashFields.put("bank_brnc_desc", "bankBrncDesc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("brnc_cnt_nm", "brncCntNm");
		this.hashFields.put("bank_nm", "bankNm");
		this.hashFields.put("brnc_cnt_cd", "brncCntCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cntc_pfx_cd", "cntcPfxCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("brnc_no", "brncNo");
		this.hashFields.put("bank_brnc_seq", "bankBrncSeq");
		this.hashFields.put("cntc_tit_nm", "cntcTitNm");
		this.hashFields.put("bank_brnc_nm", "bankBrncNm");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cntc_nm", "cntcNm");
		this.hashFields.put("bank_brnc_altn_nm", "bankBrncAltnNm");
		this.hashFields.put("bank_altn_nm", "bankAltnNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bankBrncTpNm
	 */
	public String getBankBrncTpNm() {
		return this.bankBrncTpNm;
	}
	
	/**
	 * Column Info
	 * @return bankAddr2
	 */
	public String getBankAddr2() {
		return this.bankAddr2;
	}
	
	/**
	 * Column Info
	 * @return bankAddr1
	 */
	public String getBankAddr1() {
		return this.bankAddr1;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return cntcEml
	 */
	public String getCntcEml() {
		return this.cntcEml;
	}
	
	/**
	 * Column Info
	 * @return cntcPhnNo
	 */
	public String getCntcPhnNo() {
		return this.cntcPhnNo;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return bankEndDt
	 */
	public String getBankEndDt() {
		return this.bankEndDt;
	}
	
	/**
	 * Column Info
	 * @return bankNo
	 */
	public String getBankNo() {
		return this.bankNo;
	}
	
	/**
	 * Column Info
	 * @return bankBrncDesc
	 */
	public String getBankBrncDesc() {
		return this.bankBrncDesc;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return brncCntNm
	 */
	public String getBrncCntNm() {
		return this.brncCntNm;
	}
	
	/**
	 * Column Info
	 * @return bankNm
	 */
	public String getBankNm() {
		return this.bankNm;
	}
	
	/**
	 * Column Info
	 * @return brncCntCd
	 */
	public String getBrncCntCd() {
		return this.brncCntCd;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return cntcPfxCd
	 */
	public String getCntcPfxCd() {
		return this.cntcPfxCd;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return brncNo
	 */
	public String getBrncNo() {
		return this.brncNo;
	}
	
	/**
	 * Column Info
	 * @return bankBrncSeq
	 */
	public String getBankBrncSeq() {
		return this.bankBrncSeq;
	}
	
	/**
	 * Column Info
	 * @return cntcTitNm
	 */
	public String getCntcTitNm() {
		return this.cntcTitNm;
	}
	
	/**
	 * Column Info
	 * @return bankBrncNm
	 */
	public String getBankBrncNm() {
		return this.bankBrncNm;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return cntcNm
	 */
	public String getCntcNm() {
		return this.cntcNm;
	}
	
	/**
	 * Column Info
	 * @return bankBrncAltnNm
	 */
	public String getBankBrncAltnNm() {
		return this.bankBrncAltnNm;
	}
	
	/**
	 * Column Info
	 * @return bankAltnNm
	 */
	public String getBankAltnNm() {
		return this.bankAltnNm;
	}
	

	/**
	 * Column Info
	 * @param bankBrncTpNm
	 */
	public void setBankBrncTpNm(String bankBrncTpNm) {
		this.bankBrncTpNm = bankBrncTpNm;
	}
	
	/**
	 * Column Info
	 * @param bankAddr2
	 */
	public void setBankAddr2(String bankAddr2) {
		this.bankAddr2 = bankAddr2;
	}
	
	/**
	 * Column Info
	 * @param bankAddr1
	 */
	public void setBankAddr1(String bankAddr1) {
		this.bankAddr1 = bankAddr1;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param cntcEml
	 */
	public void setCntcEml(String cntcEml) {
		this.cntcEml = cntcEml;
	}
	
	/**
	 * Column Info
	 * @param cntcPhnNo
	 */
	public void setCntcPhnNo(String cntcPhnNo) {
		this.cntcPhnNo = cntcPhnNo;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param bankEndDt
	 */
	public void setBankEndDt(String bankEndDt) {
		this.bankEndDt = bankEndDt;
	}
	
	/**
	 * Column Info
	 * @param bankNo
	 */
	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}
	
	/**
	 * Column Info
	 * @param bankBrncDesc
	 */
	public void setBankBrncDesc(String bankBrncDesc) {
		this.bankBrncDesc = bankBrncDesc;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param brncCntNm
	 */
	public void setBrncCntNm(String brncCntNm) {
		this.brncCntNm = brncCntNm;
	}
	
	/**
	 * Column Info
	 * @param bankNm
	 */
	public void setBankNm(String bankNm) {
		this.bankNm = bankNm;
	}
	
	/**
	 * Column Info
	 * @param brncCntCd
	 */
	public void setBrncCntCd(String brncCntCd) {
		this.brncCntCd = brncCntCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param cntcPfxCd
	 */
	public void setCntcPfxCd(String cntcPfxCd) {
		this.cntcPfxCd = cntcPfxCd;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param brncNo
	 */
	public void setBrncNo(String brncNo) {
		this.brncNo = brncNo;
	}
	
	/**
	 * Column Info
	 * @param bankBrncSeq
	 */
	public void setBankBrncSeq(String bankBrncSeq) {
		this.bankBrncSeq = bankBrncSeq;
	}
	
	/**
	 * Column Info
	 * @param cntcTitNm
	 */
	public void setCntcTitNm(String cntcTitNm) {
		this.cntcTitNm = cntcTitNm;
	}
	
	/**
	 * Column Info
	 * @param bankBrncNm
	 */
	public void setBankBrncNm(String bankBrncNm) {
		this.bankBrncNm = bankBrncNm;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param cntcNm
	 */
	public void setCntcNm(String cntcNm) {
		this.cntcNm = cntcNm;
	}
	
	/**
	 * Column Info
	 * @param bankBrncAltnNm
	 */
	public void setBankBrncAltnNm(String bankBrncAltnNm) {
		this.bankBrncAltnNm = bankBrncAltnNm;
	}
	
	/**
	 * Column Info
	 * @param bankAltnNm
	 */
	public void setBankAltnNm(String bankAltnNm) {
		this.bankAltnNm = bankAltnNm;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setBankBrncTpNm(JSPUtil.getParameter(request, prefix + "bank_brnc_tp_nm", ""));
		setBankAddr2(JSPUtil.getParameter(request, prefix + "bank_addr2", ""));
		setBankAddr1(JSPUtil.getParameter(request, prefix + "bank_addr1", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCntcEml(JSPUtil.getParameter(request, prefix + "cntc_eml", ""));
		setCntcPhnNo(JSPUtil.getParameter(request, prefix + "cntc_phn_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBankEndDt(JSPUtil.getParameter(request, prefix + "bank_end_dt", ""));
		setBankNo(JSPUtil.getParameter(request, prefix + "bank_no", ""));
		setBankBrncDesc(JSPUtil.getParameter(request, prefix + "bank_brnc_desc", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBrncCntNm(JSPUtil.getParameter(request, prefix + "brnc_cnt_nm", ""));
		setBankNm(JSPUtil.getParameter(request, prefix + "bank_nm", ""));
		setBrncCntCd(JSPUtil.getParameter(request, prefix + "brnc_cnt_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCntcPfxCd(JSPUtil.getParameter(request, prefix + "cntc_pfx_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setBrncNo(JSPUtil.getParameter(request, prefix + "brnc_no", ""));
		setBankBrncSeq(JSPUtil.getParameter(request, prefix + "bank_brnc_seq", ""));
		setCntcTitNm(JSPUtil.getParameter(request, prefix + "cntc_tit_nm", ""));
		setBankBrncNm(JSPUtil.getParameter(request, prefix + "bank_brnc_nm", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCntcNm(JSPUtil.getParameter(request, prefix + "cntc_nm", ""));
		setBankBrncAltnNm(JSPUtil.getParameter(request, prefix + "bank_brnc_altn_nm", ""));
		setBankAltnNm(JSPUtil.getParameter(request, prefix + "bank_altn_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BankBranchVO[]
	 */
	public BankBranchVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BankBranchVO[]
	 */
	public BankBranchVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BankBranchVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bankBrncTpNm = (JSPUtil.getParameter(request, prefix	+ "bank_brnc_tp_nm", length));
			String[] bankAddr2 = (JSPUtil.getParameter(request, prefix	+ "bank_addr2", length));
			String[] bankAddr1 = (JSPUtil.getParameter(request, prefix	+ "bank_addr1", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] cntcEml = (JSPUtil.getParameter(request, prefix	+ "cntc_eml", length));
			String[] cntcPhnNo = (JSPUtil.getParameter(request, prefix	+ "cntc_phn_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bankEndDt = (JSPUtil.getParameter(request, prefix	+ "bank_end_dt", length));
			String[] bankNo = (JSPUtil.getParameter(request, prefix	+ "bank_no", length));
			String[] bankBrncDesc = (JSPUtil.getParameter(request, prefix	+ "bank_brnc_desc", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] brncCntNm = (JSPUtil.getParameter(request, prefix	+ "brnc_cnt_nm", length));
			String[] bankNm = (JSPUtil.getParameter(request, prefix	+ "bank_nm", length));
			String[] brncCntCd = (JSPUtil.getParameter(request, prefix	+ "brnc_cnt_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] cntcPfxCd = (JSPUtil.getParameter(request, prefix	+ "cntc_pfx_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] brncNo = (JSPUtil.getParameter(request, prefix	+ "brnc_no", length));
			String[] bankBrncSeq = (JSPUtil.getParameter(request, prefix	+ "bank_brnc_seq", length));
			String[] cntcTitNm = (JSPUtil.getParameter(request, prefix	+ "cntc_tit_nm", length));
			String[] bankBrncNm = (JSPUtil.getParameter(request, prefix	+ "bank_brnc_nm", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cntcNm = (JSPUtil.getParameter(request, prefix	+ "cntc_nm", length));
			String[] bankBrncAltnNm = (JSPUtil.getParameter(request, prefix	+ "bank_brnc_altn_nm", length));
			String[] bankAltnNm = (JSPUtil.getParameter(request, prefix	+ "bank_altn_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new BankBranchVO();
				if (bankBrncTpNm[i] != null)
					model.setBankBrncTpNm(bankBrncTpNm[i]);
				if (bankAddr2[i] != null)
					model.setBankAddr2(bankAddr2[i]);
				if (bankAddr1[i] != null)
					model.setBankAddr1(bankAddr1[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (cntcEml[i] != null)
					model.setCntcEml(cntcEml[i]);
				if (cntcPhnNo[i] != null)
					model.setCntcPhnNo(cntcPhnNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bankEndDt[i] != null)
					model.setBankEndDt(bankEndDt[i]);
				if (bankNo[i] != null)
					model.setBankNo(bankNo[i]);
				if (bankBrncDesc[i] != null)
					model.setBankBrncDesc(bankBrncDesc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (brncCntNm[i] != null)
					model.setBrncCntNm(brncCntNm[i]);
				if (bankNm[i] != null)
					model.setBankNm(bankNm[i]);
				if (brncCntCd[i] != null)
					model.setBrncCntCd(brncCntCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (cntcPfxCd[i] != null)
					model.setCntcPfxCd(cntcPfxCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (brncNo[i] != null)
					model.setBrncNo(brncNo[i]);
				if (bankBrncSeq[i] != null)
					model.setBankBrncSeq(bankBrncSeq[i]);
				if (cntcTitNm[i] != null)
					model.setCntcTitNm(cntcTitNm[i]);
				if (bankBrncNm[i] != null)
					model.setBankBrncNm(bankBrncNm[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cntcNm[i] != null)
					model.setCntcNm(cntcNm[i]);
				if (bankBrncAltnNm[i] != null)
					model.setBankBrncAltnNm(bankBrncAltnNm[i]);
				if (bankAltnNm[i] != null)
					model.setBankAltnNm(bankAltnNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBankBranchVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BankBranchVO[]
	 */
	public BankBranchVO[] getBankBranchVOs(){
		BankBranchVO[] vos = (BankBranchVO[])models.toArray(new BankBranchVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.bankBrncTpNm = this.bankBrncTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAddr2 = this.bankAddr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAddr1 = this.bankAddr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcEml = this.cntcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPhnNo = this.cntcPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankEndDt = this.bankEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankNo = this.bankNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankBrncDesc = this.bankBrncDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brncCntNm = this.brncCntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankNm = this.bankNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brncCntCd = this.brncCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPfxCd = this.cntcPfxCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brncNo = this.brncNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankBrncSeq = this.bankBrncSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcTitNm = this.cntcTitNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankBrncNm = this.bankBrncNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcNm = this.cntcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankBrncAltnNm = this.bankBrncAltnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAltnNm = this.bankAltnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
