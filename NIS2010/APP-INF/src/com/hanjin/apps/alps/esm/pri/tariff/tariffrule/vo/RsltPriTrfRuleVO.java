/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RsltPriTrfRuleVO.java
*@FileTitle : RsltPriTrfRuleVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.30
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.12.30 최성민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.tariff.tariffrule.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최성민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltPriTrfRuleVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPriTrfRuleVO> models = new ArrayList<RsltPriTrfRuleVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String befPubDt = null;
	/* Column Info */
	private String trfRuleStsCd = null;
	/* Column Info */
	private String befTrfRuleCtnt = null;
	/* Column Info */
	private String amdtFlg = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String pubDt = null;
	/* Column Info */
	private String aproOfcCd = null;
	/* Column Info */
	private String trfRuleChgCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String trfRuleAmdtTpCd = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String trfNo = null;
	/* Column Info */
	private String rqstOfcCd = null;
	/* Column Info */
	private String trfRuleNm = null;
	/* Column Info */
	private String aproFlg = null;
	/* Column Info */
	private String trfRuleCtnt = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String trfPfxCd = null;
	/* Column Info */
	private String trfRuleNo = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPriTrfRuleVO() {}

	public RsltPriTrfRuleVO(String ibflag, String pagerows, String trfPfxCd, String trfNo, String trfRuleNo, String amdtSeq, String trfRuleNm, String trfRuleCtnt, String befTrfRuleCtnt, String trfRuleChgCd, String trfRuleAmdtTpCd, String effDt, String expDt, String pubDt, String befPubDt, String rqstOfcCd, String aproOfcCd, String trfRuleStsCd, String creUsrId, String creDt, String updUsrId, String updDt, String amdtFlg, String aproFlg) {
		this.updDt = updDt;
		this.befPubDt = befPubDt;
		this.trfRuleStsCd = trfRuleStsCd;
		this.befTrfRuleCtnt = befTrfRuleCtnt;
		this.amdtFlg = amdtFlg;
		this.amdtSeq = amdtSeq;
		this.creDt = creDt;
		this.pubDt = pubDt;
		this.aproOfcCd = aproOfcCd;
		this.trfRuleChgCd = trfRuleChgCd;
		this.pagerows = pagerows;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.trfRuleAmdtTpCd = trfRuleAmdtTpCd;
		this.effDt = effDt;
		this.trfNo = trfNo;
		this.rqstOfcCd = rqstOfcCd;
		this.trfRuleNm = trfRuleNm;
		this.aproFlg = aproFlg;
		this.trfRuleCtnt = trfRuleCtnt;
		this.expDt = expDt;
		this.trfPfxCd = trfPfxCd;
		this.trfRuleNo = trfRuleNo;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("bef_pub_dt", getBefPubDt());
		this.hashColumns.put("trf_rule_sts_cd", getTrfRuleStsCd());
		this.hashColumns.put("bef_trf_rule_ctnt", getBefTrfRuleCtnt());
		this.hashColumns.put("amdt_flg", getAmdtFlg());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pub_dt", getPubDt());
		this.hashColumns.put("apro_ofc_cd", getAproOfcCd());
		this.hashColumns.put("trf_rule_chg_cd", getTrfRuleChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("trf_rule_amdt_tp_cd", getTrfRuleAmdtTpCd());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("trf_no", getTrfNo());
		this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
		this.hashColumns.put("trf_rule_nm", getTrfRuleNm());
		this.hashColumns.put("apro_flg", getAproFlg());
		this.hashColumns.put("trf_rule_ctnt", getTrfRuleCtnt());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("trf_pfx_cd", getTrfPfxCd());
		this.hashColumns.put("trf_rule_no", getTrfRuleNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("bef_pub_dt", "befPubDt");
		this.hashFields.put("trf_rule_sts_cd", "trfRuleStsCd");
		this.hashFields.put("bef_trf_rule_ctnt", "befTrfRuleCtnt");
		this.hashFields.put("amdt_flg", "amdtFlg");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pub_dt", "pubDt");
		this.hashFields.put("apro_ofc_cd", "aproOfcCd");
		this.hashFields.put("trf_rule_chg_cd", "trfRuleChgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("trf_rule_amdt_tp_cd", "trfRuleAmdtTpCd");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("trf_no", "trfNo");
		this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
		this.hashFields.put("trf_rule_nm", "trfRuleNm");
		this.hashFields.put("apro_flg", "aproFlg");
		this.hashFields.put("trf_rule_ctnt", "trfRuleCtnt");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("trf_pfx_cd", "trfPfxCd");
		this.hashFields.put("trf_rule_no", "trfRuleNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
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
	 * @return befPubDt
	 */
	public String getBefPubDt() {
		return this.befPubDt;
	}
	
	/**
	 * Column Info
	 * @return trfRuleStsCd
	 */
	public String getTrfRuleStsCd() {
		return this.trfRuleStsCd;
	}
	
	/**
	 * Column Info
	 * @return befTrfRuleCtnt
	 */
	public String getBefTrfRuleCtnt() {
		return this.befTrfRuleCtnt;
	}
	
	/**
	 * Column Info
	 * @return amdtFlg
	 */
	public String getAmdtFlg() {
		return this.amdtFlg;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return pubDt
	 */
	public String getPubDt() {
		return this.pubDt;
	}
	
	/**
	 * Column Info
	 * @return aproOfcCd
	 */
	public String getAproOfcCd() {
		return this.aproOfcCd;
	}
	
	/**
	 * Column Info
	 * @return trfRuleChgCd
	 */
	public String getTrfRuleChgCd() {
		return this.trfRuleChgCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return trfRuleAmdtTpCd
	 */
	public String getTrfRuleAmdtTpCd() {
		return this.trfRuleAmdtTpCd;
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
	 * @return trfNo
	 */
	public String getTrfNo() {
		return this.trfNo;
	}
	
	/**
	 * Column Info
	 * @return rqstOfcCd
	 */
	public String getRqstOfcCd() {
		return this.rqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @return trfRuleNm
	 */
	public String getTrfRuleNm() {
		return this.trfRuleNm;
	}
	
	/**
	 * Column Info
	 * @return aproFlg
	 */
	public String getAproFlg() {
		return this.aproFlg;
	}
	
	/**
	 * Column Info
	 * @return trfRuleCtnt
	 */
	public String getTrfRuleCtnt() {
		return this.trfRuleCtnt;
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
	 * @return trfPfxCd
	 */
	public String getTrfPfxCd() {
		return this.trfPfxCd;
	}
	
	/**
	 * Column Info
	 * @return trfRuleNo
	 */
	public String getTrfRuleNo() {
		return this.trfRuleNo;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param befPubDt
	 */
	public void setBefPubDt(String befPubDt) {
		this.befPubDt = befPubDt;
	}
	
	/**
	 * Column Info
	 * @param trfRuleStsCd
	 */
	public void setTrfRuleStsCd(String trfRuleStsCd) {
		this.trfRuleStsCd = trfRuleStsCd;
	}
	
	/**
	 * Column Info
	 * @param befTrfRuleCtnt
	 */
	public void setBefTrfRuleCtnt(String befTrfRuleCtnt) {
		this.befTrfRuleCtnt = befTrfRuleCtnt;
	}
	
	/**
	 * Column Info
	 * @param amdtFlg
	 */
	public void setAmdtFlg(String amdtFlg) {
		this.amdtFlg = amdtFlg;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param pubDt
	 */
	public void setPubDt(String pubDt) {
		this.pubDt = pubDt;
	}
	
	/**
	 * Column Info
	 * @param aproOfcCd
	 */
	public void setAproOfcCd(String aproOfcCd) {
		this.aproOfcCd = aproOfcCd;
	}
	
	/**
	 * Column Info
	 * @param trfRuleChgCd
	 */
	public void setTrfRuleChgCd(String trfRuleChgCd) {
		this.trfRuleChgCd = trfRuleChgCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param trfRuleAmdtTpCd
	 */
	public void setTrfRuleAmdtTpCd(String trfRuleAmdtTpCd) {
		this.trfRuleAmdtTpCd = trfRuleAmdtTpCd;
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
	 * @param trfNo
	 */
	public void setTrfNo(String trfNo) {
		this.trfNo = trfNo;
	}
	
	/**
	 * Column Info
	 * @param rqstOfcCd
	 */
	public void setRqstOfcCd(String rqstOfcCd) {
		this.rqstOfcCd = rqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @param trfRuleNm
	 */
	public void setTrfRuleNm(String trfRuleNm) {
		this.trfRuleNm = trfRuleNm;
	}
	
	/**
	 * Column Info
	 * @param aproFlg
	 */
	public void setAproFlg(String aproFlg) {
		this.aproFlg = aproFlg;
	}
	
	/**
	 * Column Info
	 * @param trfRuleCtnt
	 */
	public void setTrfRuleCtnt(String trfRuleCtnt) {
		this.trfRuleCtnt = trfRuleCtnt;
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
	 * @param trfPfxCd
	 */
	public void setTrfPfxCd(String trfPfxCd) {
		this.trfPfxCd = trfPfxCd;
	}
	
	/**
	 * Column Info
	 * @param trfRuleNo
	 */
	public void setTrfRuleNo(String trfRuleNo) {
		this.trfRuleNo = trfRuleNo;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setBefPubDt(JSPUtil.getParameter(request, prefix + "bef_pub_dt", ""));
		setTrfRuleStsCd(JSPUtil.getParameter(request, prefix + "trf_rule_sts_cd", ""));
		setBefTrfRuleCtnt(JSPUtil.getParameter(request, prefix + "bef_trf_rule_ctnt", ""));
		setAmdtFlg(JSPUtil.getParameter(request, prefix + "amdt_flg", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPubDt(JSPUtil.getParameter(request, prefix + "pub_dt", ""));
		setAproOfcCd(JSPUtil.getParameter(request, prefix + "apro_ofc_cd", ""));
		setTrfRuleChgCd(JSPUtil.getParameter(request, prefix + "trf_rule_chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTrfRuleAmdtTpCd(JSPUtil.getParameter(request, prefix + "trf_rule_amdt_tp_cd", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setTrfNo(JSPUtil.getParameter(request, prefix + "trf_no", ""));
		setRqstOfcCd(JSPUtil.getParameter(request, prefix + "rqst_ofc_cd", ""));
		setTrfRuleNm(JSPUtil.getParameter(request, prefix + "trf_rule_nm", ""));
		setAproFlg(JSPUtil.getParameter(request, prefix + "apro_flg", ""));
		setTrfRuleCtnt(JSPUtil.getParameter(request, prefix + "trf_rule_ctnt", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setTrfPfxCd(JSPUtil.getParameter(request, prefix + "trf_pfx_cd", ""));
		setTrfRuleNo(JSPUtil.getParameter(request, prefix + "trf_rule_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPriTrfRuleVO[]
	 */
	public RsltPriTrfRuleVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPriTrfRuleVO[]
	 */
	public RsltPriTrfRuleVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPriTrfRuleVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] befPubDt = (JSPUtil.getParameter(request, prefix	+ "bef_pub_dt", length));
			String[] trfRuleStsCd = (JSPUtil.getParameter(request, prefix	+ "trf_rule_sts_cd", length));
			String[] befTrfRuleCtnt = (JSPUtil.getParameter(request, prefix	+ "bef_trf_rule_ctnt", length));
			String[] amdtFlg = (JSPUtil.getParameter(request, prefix	+ "amdt_flg", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pubDt = (JSPUtil.getParameter(request, prefix	+ "pub_dt", length));
			String[] aproOfcCd = (JSPUtil.getParameter(request, prefix	+ "apro_ofc_cd", length));
			String[] trfRuleChgCd = (JSPUtil.getParameter(request, prefix	+ "trf_rule_chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] trfRuleAmdtTpCd = (JSPUtil.getParameter(request, prefix	+ "trf_rule_amdt_tp_cd", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] trfNo = (JSPUtil.getParameter(request, prefix	+ "trf_no", length));
			String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_cd", length));
			String[] trfRuleNm = (JSPUtil.getParameter(request, prefix	+ "trf_rule_nm", length));
			String[] aproFlg = (JSPUtil.getParameter(request, prefix	+ "apro_flg", length));
			String[] trfRuleCtnt = (JSPUtil.getParameter(request, prefix	+ "trf_rule_ctnt", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] trfPfxCd = (JSPUtil.getParameter(request, prefix	+ "trf_pfx_cd", length));
			String[] trfRuleNo = (JSPUtil.getParameter(request, prefix	+ "trf_rule_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPriTrfRuleVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (befPubDt[i] != null)
					model.setBefPubDt(befPubDt[i]);
				if (trfRuleStsCd[i] != null)
					model.setTrfRuleStsCd(trfRuleStsCd[i]);
				if (befTrfRuleCtnt[i] != null)
					model.setBefTrfRuleCtnt(befTrfRuleCtnt[i]);
				if (amdtFlg[i] != null)
					model.setAmdtFlg(amdtFlg[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pubDt[i] != null)
					model.setPubDt(pubDt[i]);
				if (aproOfcCd[i] != null)
					model.setAproOfcCd(aproOfcCd[i]);
				if (trfRuleChgCd[i] != null)
					model.setTrfRuleChgCd(trfRuleChgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (trfRuleAmdtTpCd[i] != null)
					model.setTrfRuleAmdtTpCd(trfRuleAmdtTpCd[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (trfNo[i] != null)
					model.setTrfNo(trfNo[i]);
				if (rqstOfcCd[i] != null)
					model.setRqstOfcCd(rqstOfcCd[i]);
				if (trfRuleNm[i] != null)
					model.setTrfRuleNm(trfRuleNm[i]);
				if (aproFlg[i] != null)
					model.setAproFlg(aproFlg[i]);
				if (trfRuleCtnt[i] != null)
					model.setTrfRuleCtnt(trfRuleCtnt[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (trfPfxCd[i] != null)
					model.setTrfPfxCd(trfPfxCd[i]);
				if (trfRuleNo[i] != null)
					model.setTrfRuleNo(trfRuleNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPriTrfRuleVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPriTrfRuleVO[]
	 */
	public RsltPriTrfRuleVO[] getRsltPriTrfRuleVOs(){
		RsltPriTrfRuleVO[] vos = (RsltPriTrfRuleVO[])models.toArray(new RsltPriTrfRuleVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.befPubDt = this.befPubDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfRuleStsCd = this.trfRuleStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.befTrfRuleCtnt = this.befTrfRuleCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtFlg = this.amdtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pubDt = this.pubDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproOfcCd = this.aproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfRuleChgCd = this.trfRuleChgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfRuleAmdtTpCd = this.trfRuleAmdtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfNo = this.trfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcCd = this.rqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfRuleNm = this.trfRuleNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproFlg = this.aproFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfRuleCtnt = this.trfRuleCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfPfxCd = this.trfPfxCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfRuleNo = this.trfRuleNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
