/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltPriSpScpMqcVO.java
*@FileTitle : RsltPriSpScpMqcVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.09.10 공백진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.scproposal.scmqcproposal.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 공백진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltPriSpScpMqcVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPriSpScpMqcVO> models = new ArrayList<RsltPriSpScpMqcVO>();
	
	/* Column Info */
	private String duExpDt = null;
	/* Column Info */
	private String acptDt = null;
	/* Column Info */
	private String acptOfcCd = null;
	/* Column Info */
	private String fnlMqcQty = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String prcProgStsNm = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String acptUsrId = null;
	/* Column Info */
	private String srcInfoCd = null;
	/* Column Info */
	private String srcInfoNm = null;
	/* Column Info */
	private String cntrLodUtCd = null;
	/* Column Info */
	private String propScpMqcQty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String prcProgStsCd = null;
	/* Column Info */
	private String mnExpDt = null;
	/* Column Info */
	private String mnEffDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String n1stCmncAmdtSeq = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String duEffDt = null;
	/* Column Info */
	private String coffrMqcQty = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String durDupFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPriSpScpMqcVO() {}

	public RsltPriSpScpMqcVO(String ibflag, String pagerows, String propNo, String amdtSeq, String svcScpCd, String cntrLodUtCd, String propScpMqcQty, String coffrMqcQty, String fnlMqcQty, String n1stCmncAmdtSeq, String effDt, String expDt, String srcInfoCd, String srcInfoNm, String prcProgStsCd, String prcProgStsNm, String acptUsrId, String acptOfcCd, String acptDt, String mnEffDt, String mnExpDt, String duEffDt, String duExpDt, String durDupFlg) {
		this.duExpDt = duExpDt;
		this.acptDt = acptDt;
		this.acptOfcCd = acptOfcCd;
		this.fnlMqcQty = fnlMqcQty;
		this.amdtSeq = amdtSeq;
		this.prcProgStsNm = prcProgStsNm;
		this.svcScpCd = svcScpCd;
		this.acptUsrId = acptUsrId;
		this.srcInfoCd = srcInfoCd;
		this.srcInfoNm = srcInfoNm;
		this.cntrLodUtCd = cntrLodUtCd;
		this.propScpMqcQty = propScpMqcQty;
		this.pagerows = pagerows;
		this.prcProgStsCd = prcProgStsCd;
		this.mnExpDt = mnExpDt;
		this.mnEffDt = mnEffDt;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.n1stCmncAmdtSeq = n1stCmncAmdtSeq;
		this.propNo = propNo;
		this.duEffDt = duEffDt;
		this.coffrMqcQty = coffrMqcQty;
		this.expDt = expDt;
		this.durDupFlg = durDupFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("du_exp_dt", getDuExpDt());
		this.hashColumns.put("acpt_dt", getAcptDt());
		this.hashColumns.put("acpt_ofc_cd", getAcptOfcCd());
		this.hashColumns.put("fnl_mqc_qty", getFnlMqcQty());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("prc_prog_sts_nm", getPrcProgStsNm());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("acpt_usr_id", getAcptUsrId());
		this.hashColumns.put("src_info_cd", getSrcInfoCd());
		this.hashColumns.put("src_info_nm", getSrcInfoNm());
		this.hashColumns.put("cntr_lod_ut_cd", getCntrLodUtCd());
		this.hashColumns.put("prop_scp_mqc_qty", getPropScpMqcQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("prc_prog_sts_cd", getPrcProgStsCd());
		this.hashColumns.put("mn_exp_dt", getMnExpDt());
		this.hashColumns.put("mn_eff_dt", getMnEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("n1st_cmnc_amdt_seq", getN1stCmncAmdtSeq());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("du_eff_dt", getDuEffDt());
		this.hashColumns.put("coffr_mqc_qty", getCoffrMqcQty());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("dur_dup_flg", getDurDupFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("du_exp_dt", "duExpDt");
		this.hashFields.put("acpt_dt", "acptDt");
		this.hashFields.put("acpt_ofc_cd", "acptOfcCd");
		this.hashFields.put("fnl_mqc_qty", "fnlMqcQty");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("prc_prog_sts_nm", "prcProgStsNm");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("acpt_usr_id", "acptUsrId");
		this.hashFields.put("src_info_cd", "srcInfoCd");
		this.hashFields.put("src_info_nm", "srcInfoNm");
		this.hashFields.put("cntr_lod_ut_cd", "cntrLodUtCd");
		this.hashFields.put("prop_scp_mqc_qty", "propScpMqcQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("prc_prog_sts_cd", "prcProgStsCd");
		this.hashFields.put("mn_exp_dt", "mnExpDt");
		this.hashFields.put("mn_eff_dt", "mnEffDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("n1st_cmnc_amdt_seq", "n1stCmncAmdtSeq");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("du_eff_dt", "duEffDt");
		this.hashFields.put("coffr_mqc_qty", "coffrMqcQty");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("dur_dup_flg", "durDupFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return duExpDt
	 */
	public String getDuExpDt() {
		return this.duExpDt;
	}
	
	/**
	 * Column Info
	 * @return acptDt
	 */
	public String getAcptDt() {
		return this.acptDt;
	}
	
	/**
	 * Column Info
	 * @return acptOfcCd
	 */
	public String getAcptOfcCd() {
		return this.acptOfcCd;
	}
	
	/**
	 * Column Info
	 * @return fnlMqcQty
	 */
	public String getFnlMqcQty() {
		return this.fnlMqcQty;
	}
	
	/**
	 * Column Info
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	
	/**
	 * Column Info
	 * @return prcProgStsNm
	 */
	public String getPrcProgStsNm() {
		return this.prcProgStsNm;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return acptUsrId
	 */
	public String getAcptUsrId() {
		return this.acptUsrId;
	}
	
	/**
	 * Column Info
	 * @return srcInfoCd
	 */
	public String getSrcInfoCd() {
		return this.srcInfoCd;
	}
	
	/**
	 * Column Info
	 * @return srcInfoNm
	 */
	public String getSrcInfoNm() {
		return this.srcInfoNm;
	}
	
	/**
	 * Column Info
	 * @return cntrLodUtCd
	 */
	public String getCntrLodUtCd() {
		return this.cntrLodUtCd;
	}
	
	/**
	 * Column Info
	 * @return propScpMqcQty
	 */
	public String getPropScpMqcQty() {
		return this.propScpMqcQty;
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
	 * @return prcProgStsCd
	 */
	public String getPrcProgStsCd() {
		return this.prcProgStsCd;
	}
	
	/**
	 * Column Info
	 * @return mnExpDt
	 */
	public String getMnExpDt() {
		return this.mnExpDt;
	}
	
	/**
	 * Column Info
	 * @return mnEffDt
	 */
	public String getMnEffDt() {
		return this.mnEffDt;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return n1stCmncAmdtSeq
	 */
	public String getN1stCmncAmdtSeq() {
		return this.n1stCmncAmdtSeq;
	}
	
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return duEffDt
	 */
	public String getDuEffDt() {
		return this.duEffDt;
	}
	
	/**
	 * Column Info
	 * @return coffrMqcQty
	 */
	public String getCoffrMqcQty() {
		return this.coffrMqcQty;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return durDupFlg
	 */
	public String getDurDupFlg() {
		return this.durDupFlg;
	}
	

	/**
	 * Column Info
	 * @param duExpDt
	 */
	public void setDuExpDt(String duExpDt) {
		this.duExpDt = duExpDt;
	}
	
	/**
	 * Column Info
	 * @param acptDt
	 */
	public void setAcptDt(String acptDt) {
		this.acptDt = acptDt;
	}
	
	/**
	 * Column Info
	 * @param acptOfcCd
	 */
	public void setAcptOfcCd(String acptOfcCd) {
		this.acptOfcCd = acptOfcCd;
	}
	
	/**
	 * Column Info
	 * @param fnlMqcQty
	 */
	public void setFnlMqcQty(String fnlMqcQty) {
		this.fnlMqcQty = fnlMqcQty;
	}
	
	/**
	 * Column Info
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	/**
	 * Column Info
	 * @param prcProgStsNm
	 */
	public void setPrcProgStsNm(String prcProgStsNm) {
		this.prcProgStsNm = prcProgStsNm;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param acptUsrId
	 */
	public void setAcptUsrId(String acptUsrId) {
		this.acptUsrId = acptUsrId;
	}
	
	/**
	 * Column Info
	 * @param srcInfoCd
	 */
	public void setSrcInfoCd(String srcInfoCd) {
		this.srcInfoCd = srcInfoCd;
	}
	
	/**
	 * Column Info
	 * @param srcInfoNm
	 */
	public void setSrcInfoNm(String srcInfoNm) {
		this.srcInfoNm = srcInfoNm;
	}
	
	/**
	 * Column Info
	 * @param cntrLodUtCd
	 */
	public void setCntrLodUtCd(String cntrLodUtCd) {
		this.cntrLodUtCd = cntrLodUtCd;
	}
	
	/**
	 * Column Info
	 * @param propScpMqcQty
	 */
	public void setPropScpMqcQty(String propScpMqcQty) {
		this.propScpMqcQty = propScpMqcQty;
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
	 * @param prcProgStsCd
	 */
	public void setPrcProgStsCd(String prcProgStsCd) {
		this.prcProgStsCd = prcProgStsCd;
	}
	
	/**
	 * Column Info
	 * @param mnExpDt
	 */
	public void setMnExpDt(String mnExpDt) {
		this.mnExpDt = mnExpDt;
	}
	
	/**
	 * Column Info
	 * @param mnEffDt
	 */
	public void setMnEffDt(String mnEffDt) {
		this.mnEffDt = mnEffDt;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param n1stCmncAmdtSeq
	 */
	public void setN1stCmncAmdtSeq(String n1stCmncAmdtSeq) {
		this.n1stCmncAmdtSeq = n1stCmncAmdtSeq;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param duEffDt
	 */
	public void setDuEffDt(String duEffDt) {
		this.duEffDt = duEffDt;
	}
	
	/**
	 * Column Info
	 * @param coffrMqcQty
	 */
	public void setCoffrMqcQty(String coffrMqcQty) {
		this.coffrMqcQty = coffrMqcQty;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param durDupFlg
	 */
	public void setDurDupFlg(String durDupFlg) {
		this.durDupFlg = durDupFlg;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setDuExpDt(JSPUtil.getParameter(request, "du_exp_dt", ""));
		setAcptDt(JSPUtil.getParameter(request, "acpt_dt", ""));
		setAcptOfcCd(JSPUtil.getParameter(request, "acpt_ofc_cd", ""));
		setFnlMqcQty(JSPUtil.getParameter(request, "fnl_mqc_qty", ""));
		setAmdtSeq(JSPUtil.getParameter(request, "amdt_seq", ""));
		setPrcProgStsNm(JSPUtil.getParameter(request, "prc_prog_sts_nm", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setAcptUsrId(JSPUtil.getParameter(request, "acpt_usr_id", ""));
		setSrcInfoCd(JSPUtil.getParameter(request, "src_info_cd", ""));
		setSrcInfoNm(JSPUtil.getParameter(request, "src_info_nm", ""));
		setCntrLodUtCd(JSPUtil.getParameter(request, "cntr_lod_ut_cd", ""));
		setPropScpMqcQty(JSPUtil.getParameter(request, "prop_scp_mqc_qty", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPrcProgStsCd(JSPUtil.getParameter(request, "prc_prog_sts_cd", ""));
		setMnExpDt(JSPUtil.getParameter(request, "mn_exp_dt", ""));
		setMnEffDt(JSPUtil.getParameter(request, "mn_eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setN1stCmncAmdtSeq(JSPUtil.getParameter(request, "n1st_cmnc_amdt_seq", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setDuEffDt(JSPUtil.getParameter(request, "du_eff_dt", ""));
		setCoffrMqcQty(JSPUtil.getParameter(request, "coffr_mqc_qty", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setDurDupFlg(JSPUtil.getParameter(request, "dur_dup_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPriSpScpMqcVO[]
	 */
	public RsltPriSpScpMqcVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPriSpScpMqcVO[]
	 */
	public RsltPriSpScpMqcVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPriSpScpMqcVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] duExpDt = (JSPUtil.getParameter(request, prefix	+ "du_exp_dt", length));
			String[] acptDt = (JSPUtil.getParameter(request, prefix	+ "acpt_dt", length));
			String[] acptOfcCd = (JSPUtil.getParameter(request, prefix	+ "acpt_ofc_cd", length));
			String[] fnlMqcQty = (JSPUtil.getParameter(request, prefix	+ "fnl_mqc_qty", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] prcProgStsNm = (JSPUtil.getParameter(request, prefix	+ "prc_prog_sts_nm", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] acptUsrId = (JSPUtil.getParameter(request, prefix	+ "acpt_usr_id", length));
			String[] srcInfoCd = (JSPUtil.getParameter(request, prefix	+ "src_info_cd", length));
			String[] srcInfoNm = (JSPUtil.getParameter(request, prefix	+ "src_info_nm", length));
			String[] cntrLodUtCd = (JSPUtil.getParameter(request, prefix	+ "cntr_lod_ut_cd", length));
			String[] propScpMqcQty = (JSPUtil.getParameter(request, prefix	+ "prop_scp_mqc_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] prcProgStsCd = (JSPUtil.getParameter(request, prefix	+ "prc_prog_sts_cd", length));
			String[] mnExpDt = (JSPUtil.getParameter(request, prefix	+ "mn_exp_dt", length));
			String[] mnEffDt = (JSPUtil.getParameter(request, prefix	+ "mn_eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] n1stCmncAmdtSeq = (JSPUtil.getParameter(request, prefix	+ "n1st_cmnc_amdt_seq", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] duEffDt = (JSPUtil.getParameter(request, prefix	+ "du_eff_dt", length));
			String[] coffrMqcQty = (JSPUtil.getParameter(request, prefix	+ "coffr_mqc_qty", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] durDupFlg = (JSPUtil.getParameter(request, prefix	+ "dur_dup_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPriSpScpMqcVO();
				if (duExpDt[i] != null)
					model.setDuExpDt(duExpDt[i]);
				if (acptDt[i] != null)
					model.setAcptDt(acptDt[i]);
				if (acptOfcCd[i] != null)
					model.setAcptOfcCd(acptOfcCd[i]);
				if (fnlMqcQty[i] != null)
					model.setFnlMqcQty(fnlMqcQty[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (prcProgStsNm[i] != null)
					model.setPrcProgStsNm(prcProgStsNm[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (acptUsrId[i] != null)
					model.setAcptUsrId(acptUsrId[i]);
				if (srcInfoCd[i] != null)
					model.setSrcInfoCd(srcInfoCd[i]);
				if (srcInfoNm[i] != null)
					model.setSrcInfoNm(srcInfoNm[i]);
				if (cntrLodUtCd[i] != null)
					model.setCntrLodUtCd(cntrLodUtCd[i]);
				if (propScpMqcQty[i] != null)
					model.setPropScpMqcQty(propScpMqcQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (prcProgStsCd[i] != null)
					model.setPrcProgStsCd(prcProgStsCd[i]);
				if (mnExpDt[i] != null)
					model.setMnExpDt(mnExpDt[i]);
				if (mnEffDt[i] != null)
					model.setMnEffDt(mnEffDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (n1stCmncAmdtSeq[i] != null)
					model.setN1stCmncAmdtSeq(n1stCmncAmdtSeq[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (duEffDt[i] != null)
					model.setDuEffDt(duEffDt[i]);
				if (coffrMqcQty[i] != null)
					model.setCoffrMqcQty(coffrMqcQty[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (durDupFlg[i] != null)
					model.setDurDupFlg(durDupFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPriSpScpMqcVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPriSpScpMqcVO[]
	 */
	public RsltPriSpScpMqcVO[] getRsltPriSpScpMqcVOs(){
		RsltPriSpScpMqcVO[] vos = (RsltPriSpScpMqcVO[])models.toArray(new RsltPriSpScpMqcVO[models.size()]);
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
		this.duExpDt = this.duExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acptDt = this.acptDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acptOfcCd = this.acptOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlMqcQty = this.fnlMqcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcProgStsNm = this.prcProgStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acptUsrId = this.acptUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcInfoCd = this.srcInfoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcInfoNm = this.srcInfoNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrLodUtCd = this.cntrLodUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propScpMqcQty = this.propScpMqcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcProgStsCd = this.prcProgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnExpDt = this.mnExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnEffDt = this.mnEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stCmncAmdtSeq = this.n1stCmncAmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duEffDt = this.duEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coffrMqcQty = this.coffrMqcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.durDupFlg = this.durDupFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
