/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IbCustCntcHisVO.java
*@FileTitle : IbCustCntcHisVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.13
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2009.07.13 박만건 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박만건
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class IbCustCntcHisVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<IbCustCntcHisVO> models = new ArrayList<IbCustCntcHisVO>();
	
	/* Column Info */
	private String custCntcTpCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String sndSelFlg = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String cngDtS = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String blNoChk = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sndSelFlgDesc = null;
	/* Column Info */
	private String cntcViaCd = null;
	/* Column Info */
	private String blNoTp = null;
	/* Column Info */
	private String hisSeq = null;
	/* Column Info */
	private String cngDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String custCntcTpCdDesc = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String autoMnlFlgDesc = null;
	/* Column Info */
	private String cngUsrId = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cngDtE = null;
	/* Column Info */
	private String newCntcCtnt = null;
	/* Column Info */
	private String cngUsrNm = null;
	/* Column Info */
	private String oldCntcCtnt = null;
	/* Column Info */
	private String autoMnlFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public IbCustCntcHisVO() {}

	public IbCustCntcHisVO(String ibflag, String pagerows, String updDt, String custCntcTpCd, String creDt, String sndSelFlg, String custSeq, String blNo, String cngUsrId, String ofcCd, String creUsrId, String blNoChk, String newCntcCtnt, String cntcViaCd, String blNoTp, String hisSeq, String cngDt, String oldCntcCtnt, String updUsrId, String autoMnlFlg, String custCntCd, String cngUsrNm, String cngDtS, String cngDtE, String custCntcTpCdDesc, String sndSelFlgDesc, String autoMnlFlgDesc) {
		this.custCntcTpCd = custCntcTpCd;
		this.creDt = creDt;
		this.sndSelFlg = sndSelFlg;
		this.blNo = blNo;
		this.cngDtS = cngDtS;
		this.pagerows = pagerows;
		this.blNoChk = blNoChk;
		this.ibflag = ibflag;
		this.sndSelFlgDesc = sndSelFlgDesc;
		this.cntcViaCd = cntcViaCd;
		this.blNoTp = blNoTp;
		this.hisSeq = hisSeq;
		this.cngDt = cngDt;
		this.updUsrId = updUsrId;
		this.custCntCd = custCntCd;
		this.updDt = updDt;
		this.custCntcTpCdDesc = custCntcTpCdDesc;
		this.custSeq = custSeq;
		this.autoMnlFlgDesc = autoMnlFlgDesc;
		this.cngUsrId = cngUsrId;
		this.ofcCd = ofcCd;
		this.creUsrId = creUsrId;
		this.cngDtE = cngDtE;
		this.newCntcCtnt = newCntcCtnt;
		this.cngUsrNm = cngUsrNm;
		this.oldCntcCtnt = oldCntcCtnt;
		this.autoMnlFlg = autoMnlFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cust_cntc_tp_cd", getCustCntcTpCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("snd_sel_flg", getSndSelFlg());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("cng_dt_s", getCngDtS());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bl_no_chk", getBlNoChk());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("snd_sel_flg_desc", getSndSelFlgDesc());
		this.hashColumns.put("cntc_via_cd", getCntcViaCd());
		this.hashColumns.put("bl_no_tp", getBlNoTp());
		this.hashColumns.put("his_seq", getHisSeq());
		this.hashColumns.put("cng_dt", getCngDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cust_cntc_tp_cd_desc", getCustCntcTpCdDesc());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("auto_mnl_flg_desc", getAutoMnlFlgDesc());
		this.hashColumns.put("cng_usr_id", getCngUsrId());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cng_dt_e", getCngDtE());
		this.hashColumns.put("new_cntc_ctnt", getNewCntcCtnt());
		this.hashColumns.put("cng_usr_nm", getCngUsrNm());
		this.hashColumns.put("old_cntc_ctnt", getOldCntcCtnt());
		this.hashColumns.put("auto_mnl_flg", getAutoMnlFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cust_cntc_tp_cd", "custCntcTpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("snd_sel_flg", "sndSelFlg");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("cng_dt_s", "cngDtS");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bl_no_chk", "blNoChk");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("snd_sel_flg_desc", "sndSelFlgDesc");
		this.hashFields.put("cntc_via_cd", "cntcViaCd");
		this.hashFields.put("bl_no_tp", "blNoTp");
		this.hashFields.put("his_seq", "hisSeq");
		this.hashFields.put("cng_dt", "cngDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cust_cntc_tp_cd_desc", "custCntcTpCdDesc");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("auto_mnl_flg_desc", "autoMnlFlgDesc");
		this.hashFields.put("cng_usr_id", "cngUsrId");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cng_dt_e", "cngDtE");
		this.hashFields.put("new_cntc_ctnt", "newCntcCtnt");
		this.hashFields.put("cng_usr_nm", "cngUsrNm");
		this.hashFields.put("old_cntc_ctnt", "oldCntcCtnt");
		this.hashFields.put("auto_mnl_flg", "autoMnlFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return custCntcTpCd
	 */
	public String getCustCntcTpCd() {
		return this.custCntcTpCd;
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
	 * @return sndSelFlg
	 */
	public String getSndSelFlg() {
		return this.sndSelFlg;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return cngDtS
	 */
	public String getCngDtS() {
		return this.cngDtS;
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
	 * @return blNoChk
	 */
	public String getBlNoChk() {
		return this.blNoChk;
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
	 * @return sndSelFlgDesc
	 */
	public String getSndSelFlgDesc() {
		return this.sndSelFlgDesc;
	}
	
	/**
	 * Column Info
	 * @return cntcViaCd
	 */
	public String getCntcViaCd() {
		return this.cntcViaCd;
	}
	
	/**
	 * Column Info
	 * @return blNoTp
	 */
	public String getBlNoTp() {
		return this.blNoTp;
	}
	
	/**
	 * Column Info
	 * @return hisSeq
	 */
	public String getHisSeq() {
		return this.hisSeq;
	}
	
	/**
	 * Column Info
	 * @return cngDt
	 */
	public String getCngDt() {
		return this.cngDt;
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
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
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
	 * @return custCntcTpCdDesc
	 */
	public String getCustCntcTpCdDesc() {
		return this.custCntcTpCdDesc;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return autoMnlFlgDesc
	 */
	public String getAutoMnlFlgDesc() {
		return this.autoMnlFlgDesc;
	}
	
	/**
	 * Column Info
	 * @return cngUsrId
	 */
	public String getCngUsrId() {
		return this.cngUsrId;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return cngDtE
	 */
	public String getCngDtE() {
		return this.cngDtE;
	}
	
	/**
	 * Column Info
	 * @return newCntcCtnt
	 */
	public String getNewCntcCtnt() {
		return this.newCntcCtnt;
	}
	
	/**
	 * Column Info
	 * @return cngUsrNm
	 */
	public String getCngUsrNm() {
		return this.cngUsrNm;
	}
	
	/**
	 * Column Info
	 * @return oldCntcCtnt
	 */
	public String getOldCntcCtnt() {
		return this.oldCntcCtnt;
	}
	
	/**
	 * Column Info
	 * @return autoMnlFlg
	 */
	public String getAutoMnlFlg() {
		return this.autoMnlFlg;
	}
	

	/**
	 * Column Info
	 * @param custCntcTpCd
	 */
	public void setCustCntcTpCd(String custCntcTpCd) {
		this.custCntcTpCd = custCntcTpCd;
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
	 * @param sndSelFlg
	 */
	public void setSndSelFlg(String sndSelFlg) {
		this.sndSelFlg = sndSelFlg;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param cngDtS
	 */
	public void setCngDtS(String cngDtS) {
		this.cngDtS = cngDtS;
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
	 * @param blNoChk
	 */
	public void setBlNoChk(String blNoChk) {
		this.blNoChk = blNoChk;
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
	 * @param sndSelFlgDesc
	 */
	public void setSndSelFlgDesc(String sndSelFlgDesc) {
		this.sndSelFlgDesc = sndSelFlgDesc;
	}
	
	/**
	 * Column Info
	 * @param cntcViaCd
	 */
	public void setCntcViaCd(String cntcViaCd) {
		this.cntcViaCd = cntcViaCd;
	}
	
	/**
	 * Column Info
	 * @param blNoTp
	 */
	public void setBlNoTp(String blNoTp) {
		this.blNoTp = blNoTp;
	}
	
	/**
	 * Column Info
	 * @param hisSeq
	 */
	public void setHisSeq(String hisSeq) {
		this.hisSeq = hisSeq;
	}
	
	/**
	 * Column Info
	 * @param cngDt
	 */
	public void setCngDt(String cngDt) {
		this.cngDt = cngDt;
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
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
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
	 * @param custCntcTpCdDesc
	 */
	public void setCustCntcTpCdDesc(String custCntcTpCdDesc) {
		this.custCntcTpCdDesc = custCntcTpCdDesc;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param autoMnlFlgDesc
	 */
	public void setAutoMnlFlgDesc(String autoMnlFlgDesc) {
		this.autoMnlFlgDesc = autoMnlFlgDesc;
	}
	
	/**
	 * Column Info
	 * @param cngUsrId
	 */
	public void setCngUsrId(String cngUsrId) {
		this.cngUsrId = cngUsrId;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param cngDtE
	 */
	public void setCngDtE(String cngDtE) {
		this.cngDtE = cngDtE;
	}
	
	/**
	 * Column Info
	 * @param newCntcCtnt
	 */
	public void setNewCntcCtnt(String newCntcCtnt) {
		this.newCntcCtnt = newCntcCtnt;
	}
	
	/**
	 * Column Info
	 * @param cngUsrNm
	 */
	public void setCngUsrNm(String cngUsrNm) {
		this.cngUsrNm = cngUsrNm;
	}
	
	/**
	 * Column Info
	 * @param oldCntcCtnt
	 */
	public void setOldCntcCtnt(String oldCntcCtnt) {
		this.oldCntcCtnt = oldCntcCtnt;
	}
	
	/**
	 * Column Info
	 * @param autoMnlFlg
	 */
	public void setAutoMnlFlg(String autoMnlFlg) {
		this.autoMnlFlg = autoMnlFlg;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCustCntcTpCd(JSPUtil.getParameter(request, "cust_cntc_tp_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setSndSelFlg(JSPUtil.getParameter(request, "snd_sel_flg", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setCngDtS(JSPUtil.getParameter(request, "cng_dt_s", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setBlNoChk(JSPUtil.getParameter(request, "bl_no_chk", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSndSelFlgDesc(JSPUtil.getParameter(request, "snd_sel_flg_desc", ""));
		setCntcViaCd(JSPUtil.getParameter(request, "cntc_via_cd", ""));
		setBlNoTp(JSPUtil.getParameter(request, "bl_no_tp", ""));
		setHisSeq(JSPUtil.getParameter(request, "his_seq", ""));
		setCngDt(JSPUtil.getParameter(request, "cng_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCustCntcTpCdDesc(JSPUtil.getParameter(request, "cust_cntc_tp_cd_desc", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setAutoMnlFlgDesc(JSPUtil.getParameter(request, "auto_mnl_flg_desc", ""));
		setCngUsrId(JSPUtil.getParameter(request, "cng_usr_id", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setCngDtE(JSPUtil.getParameter(request, "cng_dt_e", ""));
		setNewCntcCtnt(JSPUtil.getParameter(request, "new_cntc_ctnt", ""));
		setCngUsrNm(JSPUtil.getParameter(request, "cng_usr_nm", ""));
		setOldCntcCtnt(JSPUtil.getParameter(request, "old_cntc_ctnt", ""));
		setAutoMnlFlg(JSPUtil.getParameter(request, "auto_mnl_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IbCustCntcHisVO[]
	 */
	public IbCustCntcHisVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IbCustCntcHisVO[]
	 */
	public IbCustCntcHisVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		IbCustCntcHisVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] custCntcTpCd = (JSPUtil.getParameter(request, prefix	+ "cust_cntc_tp_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] sndSelFlg = (JSPUtil.getParameter(request, prefix	+ "snd_sel_flg", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] cngDtS = (JSPUtil.getParameter(request, prefix	+ "cng_dt_s", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] blNoChk = (JSPUtil.getParameter(request, prefix	+ "bl_no_chk", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sndSelFlgDesc = (JSPUtil.getParameter(request, prefix	+ "snd_sel_flg_desc", length));
			String[] cntcViaCd = (JSPUtil.getParameter(request, prefix	+ "cntc_via_cd", length));
			String[] blNoTp = (JSPUtil.getParameter(request, prefix	+ "bl_no_tp", length));
			String[] hisSeq = (JSPUtil.getParameter(request, prefix	+ "his_seq", length));
			String[] cngDt = (JSPUtil.getParameter(request, prefix	+ "cng_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] custCntcTpCdDesc = (JSPUtil.getParameter(request, prefix	+ "cust_cntc_tp_cd_desc", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] autoMnlFlgDesc = (JSPUtil.getParameter(request, prefix	+ "auto_mnl_flg_desc", length));
			String[] cngUsrId = (JSPUtil.getParameter(request, prefix	+ "cng_usr_id", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cngDtE = (JSPUtil.getParameter(request, prefix	+ "cng_dt_e", length));
			String[] newCntcCtnt = (JSPUtil.getParameter(request, prefix	+ "new_cntc_ctnt", length));
			String[] cngUsrNm = (JSPUtil.getParameter(request, prefix	+ "cng_usr_nm", length));
			String[] oldCntcCtnt = (JSPUtil.getParameter(request, prefix	+ "old_cntc_ctnt", length));
			String[] autoMnlFlg = (JSPUtil.getParameter(request, prefix	+ "auto_mnl_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new IbCustCntcHisVO();
				if (custCntcTpCd[i] != null)
					model.setCustCntcTpCd(custCntcTpCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (sndSelFlg[i] != null)
					model.setSndSelFlg(sndSelFlg[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (cngDtS[i] != null)
					model.setCngDtS(cngDtS[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (blNoChk[i] != null)
					model.setBlNoChk(blNoChk[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sndSelFlgDesc[i] != null)
					model.setSndSelFlgDesc(sndSelFlgDesc[i]);
				if (cntcViaCd[i] != null)
					model.setCntcViaCd(cntcViaCd[i]);
				if (blNoTp[i] != null)
					model.setBlNoTp(blNoTp[i]);
				if (hisSeq[i] != null)
					model.setHisSeq(hisSeq[i]);
				if (cngDt[i] != null)
					model.setCngDt(cngDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (custCntcTpCdDesc[i] != null)
					model.setCustCntcTpCdDesc(custCntcTpCdDesc[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (autoMnlFlgDesc[i] != null)
					model.setAutoMnlFlgDesc(autoMnlFlgDesc[i]);
				if (cngUsrId[i] != null)
					model.setCngUsrId(cngUsrId[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cngDtE[i] != null)
					model.setCngDtE(cngDtE[i]);
				if (newCntcCtnt[i] != null)
					model.setNewCntcCtnt(newCntcCtnt[i]);
				if (cngUsrNm[i] != null)
					model.setCngUsrNm(cngUsrNm[i]);
				if (oldCntcCtnt[i] != null)
					model.setOldCntcCtnt(oldCntcCtnt[i]);
				if (autoMnlFlg[i] != null)
					model.setAutoMnlFlg(autoMnlFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getIbCustCntcHisVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return IbCustCntcHisVO[]
	 */
	public IbCustCntcHisVO[] getIbCustCntcHisVOs(){
		IbCustCntcHisVO[] vos = (IbCustCntcHisVO[])models.toArray(new IbCustCntcHisVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
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
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.custCntcTpCd = this.custCntcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndSelFlg = this.sndSelFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cngDtS = this.cngDtS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNoChk = this.blNoChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndSelFlgDesc = this.sndSelFlgDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcViaCd = this.cntcViaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNoTp = this.blNoTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisSeq = this.hisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cngDt = this.cngDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntcTpCdDesc = this.custCntcTpCdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoMnlFlgDesc = this.autoMnlFlgDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cngUsrId = this.cngUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cngDtE = this.cngDtE .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newCntcCtnt = this.newCntcCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cngUsrNm = this.cngUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldCntcCtnt = this.oldCntcCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoMnlFlg = this.autoMnlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
