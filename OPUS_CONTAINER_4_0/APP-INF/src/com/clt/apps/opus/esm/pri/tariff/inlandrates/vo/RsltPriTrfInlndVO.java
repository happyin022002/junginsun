/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RsltPriTrfInlndVO.java
*@FileTitle : RsltPriTrfInlndVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.30
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.12.30 최성민 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.tariff.inlandrates.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최성민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltPriTrfInlndVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPriTrfInlndVO> models = new ArrayList<RsltPriTrfInlndVO>();
	
	/* Column Info */
	private String befPubDt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String trfInlndSeq = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String trfInlndStsCd = null;
	/* Column Info */
	private String atchFileNm = null;
	/* Column Info */
	private String pubDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String aproOfcCd = null;
	/* Column Info */
	private String atchFileId = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String trfInlndStsNm = null;
	/* Column Info */
	private String trfInlndAmdtTpCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String trfNo = null;
	/* Column Info */
	private String rqstOfcCd = null;
	/* Column Info */
	private String trfInlndNm = null;
	/* Column Info */
	private String aproFlg = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String trfPfxCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPriTrfInlndVO() {}

	public RsltPriTrfInlndVO(String ibflag, String pagerows, String trfPfxCd, String trfNo, String trfInlndSeq, String trfInlndAmdtTpCd, String amdtSeq, String trfInlndNm, String effDt, String expDt, String rqstOfcCd, String aproOfcCd, String trfInlndStsCd, String trfInlndStsNm, String creUsrId, String creDt, String updUsrId, String updDt, String pubDt, String befPubDt, String atchFileId, String atchFileNm, String aproFlg) {
		this.befPubDt = befPubDt;
		this.updDt = updDt;
		this.trfInlndSeq = trfInlndSeq;
		this.amdtSeq = amdtSeq;
		this.trfInlndStsCd = trfInlndStsCd;
		this.atchFileNm = atchFileNm;
		this.pubDt = pubDt;
		this.creDt = creDt;
		this.aproOfcCd = aproOfcCd;
		this.atchFileId = atchFileId;
		this.pagerows = pagerows;
		this.trfInlndStsNm = trfInlndStsNm;
		this.trfInlndAmdtTpCd = trfInlndAmdtTpCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.trfNo = trfNo;
		this.rqstOfcCd = rqstOfcCd;
		this.trfInlndNm = trfInlndNm;
		this.aproFlg = aproFlg;
		this.expDt = expDt;
		this.trfPfxCd = trfPfxCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bef_pub_dt", getBefPubDt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("trf_inlnd_seq", getTrfInlndSeq());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("trf_inlnd_sts_cd", getTrfInlndStsCd());
		this.hashColumns.put("atch_file_nm", getAtchFileNm());
		this.hashColumns.put("pub_dt", getPubDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("apro_ofc_cd", getAproOfcCd());
		this.hashColumns.put("atch_file_id", getAtchFileId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("trf_inlnd_sts_nm", getTrfInlndStsNm());
		this.hashColumns.put("trf_inlnd_amdt_tp_cd", getTrfInlndAmdtTpCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("trf_no", getTrfNo());
		this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
		this.hashColumns.put("trf_inlnd_nm", getTrfInlndNm());
		this.hashColumns.put("apro_flg", getAproFlg());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("trf_pfx_cd", getTrfPfxCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bef_pub_dt", "befPubDt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("trf_inlnd_seq", "trfInlndSeq");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("trf_inlnd_sts_cd", "trfInlndStsCd");
		this.hashFields.put("atch_file_nm", "atchFileNm");
		this.hashFields.put("pub_dt", "pubDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("apro_ofc_cd", "aproOfcCd");
		this.hashFields.put("atch_file_id", "atchFileId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("trf_inlnd_sts_nm", "trfInlndStsNm");
		this.hashFields.put("trf_inlnd_amdt_tp_cd", "trfInlndAmdtTpCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("trf_no", "trfNo");
		this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
		this.hashFields.put("trf_inlnd_nm", "trfInlndNm");
		this.hashFields.put("apro_flg", "aproFlg");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("trf_pfx_cd", "trfPfxCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return trfInlndSeq
	 */
	public String getTrfInlndSeq() {
		return this.trfInlndSeq;
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
	 * @return trfInlndStsCd
	 */
	public String getTrfInlndStsCd() {
		return this.trfInlndStsCd;
	}
	
	/**
	 * Column Info
	 * @return atchFileNm
	 */
	public String getAtchFileNm() {
		return this.atchFileNm;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return atchFileId
	 */
	public String getAtchFileId() {
		return this.atchFileId;
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
	 * @return trfInlndStsNm
	 */
	public String getTrfInlndStsNm() {
		return this.trfInlndStsNm;
	}
	
	/**
	 * Column Info
	 * @return trfInlndAmdtTpCd
	 */
	public String getTrfInlndAmdtTpCd() {
		return this.trfInlndAmdtTpCd;
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
	 * @return trfInlndNm
	 */
	public String getTrfInlndNm() {
		return this.trfInlndNm;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param trfInlndSeq
	 */
	public void setTrfInlndSeq(String trfInlndSeq) {
		this.trfInlndSeq = trfInlndSeq;
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
	 * @param trfInlndStsCd
	 */
	public void setTrfInlndStsCd(String trfInlndStsCd) {
		this.trfInlndStsCd = trfInlndStsCd;
	}
	
	/**
	 * Column Info
	 * @param atchFileNm
	 */
	public void setAtchFileNm(String atchFileNm) {
		this.atchFileNm = atchFileNm;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param atchFileId
	 */
	public void setAtchFileId(String atchFileId) {
		this.atchFileId = atchFileId;
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
	 * @param trfInlndStsNm
	 */
	public void setTrfInlndStsNm(String trfInlndStsNm) {
		this.trfInlndStsNm = trfInlndStsNm;
	}
	
	/**
	 * Column Info
	 * @param trfInlndAmdtTpCd
	 */
	public void setTrfInlndAmdtTpCd(String trfInlndAmdtTpCd) {
		this.trfInlndAmdtTpCd = trfInlndAmdtTpCd;
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
	 * @param trfInlndNm
	 */
	public void setTrfInlndNm(String trfInlndNm) {
		this.trfInlndNm = trfInlndNm;
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
		setBefPubDt(JSPUtil.getParameter(request, prefix + "bef_pub_dt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setTrfInlndSeq(JSPUtil.getParameter(request, prefix + "trf_inlnd_seq", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setTrfInlndStsCd(JSPUtil.getParameter(request, prefix + "trf_inlnd_sts_cd", ""));
		setAtchFileNm(JSPUtil.getParameter(request, prefix + "atch_file_nm", ""));
		setPubDt(JSPUtil.getParameter(request, prefix + "pub_dt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setAproOfcCd(JSPUtil.getParameter(request, prefix + "apro_ofc_cd", ""));
		setAtchFileId(JSPUtil.getParameter(request, prefix + "atch_file_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTrfInlndStsNm(JSPUtil.getParameter(request, prefix + "trf_inlnd_sts_nm", ""));
		setTrfInlndAmdtTpCd(JSPUtil.getParameter(request, prefix + "trf_inlnd_amdt_tp_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setTrfNo(JSPUtil.getParameter(request, prefix + "trf_no", ""));
		setRqstOfcCd(JSPUtil.getParameter(request, prefix + "rqst_ofc_cd", ""));
		setTrfInlndNm(JSPUtil.getParameter(request, prefix + "trf_inlnd_nm", ""));
		setAproFlg(JSPUtil.getParameter(request, prefix + "apro_flg", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setTrfPfxCd(JSPUtil.getParameter(request, prefix + "trf_pfx_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPriTrfInlndVO[]
	 */
	public RsltPriTrfInlndVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPriTrfInlndVO[]
	 */
	public RsltPriTrfInlndVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPriTrfInlndVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] befPubDt = (JSPUtil.getParameter(request, prefix	+ "bef_pub_dt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] trfInlndSeq = (JSPUtil.getParameter(request, prefix	+ "trf_inlnd_seq", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] trfInlndStsCd = (JSPUtil.getParameter(request, prefix	+ "trf_inlnd_sts_cd", length));
			String[] atchFileNm = (JSPUtil.getParameter(request, prefix	+ "atch_file_nm", length));
			String[] pubDt = (JSPUtil.getParameter(request, prefix	+ "pub_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] aproOfcCd = (JSPUtil.getParameter(request, prefix	+ "apro_ofc_cd", length));
			String[] atchFileId = (JSPUtil.getParameter(request, prefix	+ "atch_file_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] trfInlndStsNm = (JSPUtil.getParameter(request, prefix	+ "trf_inlnd_sts_nm", length));
			String[] trfInlndAmdtTpCd = (JSPUtil.getParameter(request, prefix	+ "trf_inlnd_amdt_tp_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] trfNo = (JSPUtil.getParameter(request, prefix	+ "trf_no", length));
			String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_cd", length));
			String[] trfInlndNm = (JSPUtil.getParameter(request, prefix	+ "trf_inlnd_nm", length));
			String[] aproFlg = (JSPUtil.getParameter(request, prefix	+ "apro_flg", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] trfPfxCd = (JSPUtil.getParameter(request, prefix	+ "trf_pfx_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPriTrfInlndVO();
				if (befPubDt[i] != null)
					model.setBefPubDt(befPubDt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (trfInlndSeq[i] != null)
					model.setTrfInlndSeq(trfInlndSeq[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (trfInlndStsCd[i] != null)
					model.setTrfInlndStsCd(trfInlndStsCd[i]);
				if (atchFileNm[i] != null)
					model.setAtchFileNm(atchFileNm[i]);
				if (pubDt[i] != null)
					model.setPubDt(pubDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (aproOfcCd[i] != null)
					model.setAproOfcCd(aproOfcCd[i]);
				if (atchFileId[i] != null)
					model.setAtchFileId(atchFileId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (trfInlndStsNm[i] != null)
					model.setTrfInlndStsNm(trfInlndStsNm[i]);
				if (trfInlndAmdtTpCd[i] != null)
					model.setTrfInlndAmdtTpCd(trfInlndAmdtTpCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (trfNo[i] != null)
					model.setTrfNo(trfNo[i]);
				if (rqstOfcCd[i] != null)
					model.setRqstOfcCd(rqstOfcCd[i]);
				if (trfInlndNm[i] != null)
					model.setTrfInlndNm(trfInlndNm[i]);
				if (aproFlg[i] != null)
					model.setAproFlg(aproFlg[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (trfPfxCd[i] != null)
					model.setTrfPfxCd(trfPfxCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPriTrfInlndVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPriTrfInlndVO[]
	 */
	public RsltPriTrfInlndVO[] getRsltPriTrfInlndVOs(){
		RsltPriTrfInlndVO[] vos = (RsltPriTrfInlndVO[])models.toArray(new RsltPriTrfInlndVO[models.size()]);
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
		this.befPubDt = this.befPubDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfInlndSeq = this.trfInlndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfInlndStsCd = this.trfInlndStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFileNm = this.atchFileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pubDt = this.pubDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproOfcCd = this.aproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFileId = this.atchFileId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfInlndStsNm = this.trfInlndStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfInlndAmdtTpCd = this.trfInlndAmdtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfNo = this.trfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcCd = this.rqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfInlndNm = this.trfInlndNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproFlg = this.aproFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfPfxCd = this.trfPfxCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
