/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PriTrfInlndParamVO.java
*@FileTitle : PriTrfInlndParamVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.17
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.12.17 최성민 
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

public class PriTrfInlndParamVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PriTrfInlndParamVO> models = new ArrayList<PriTrfInlndParamVO>();
	
	/* Column Info */
	private String trfInlndSeq = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String pubDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String aproOfcCd = null;
	/* Column Info */
	private String etc1 = null;
	/* Column Info */
	private String etc3 = null;
	/* Column Info */
	private String etc2 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String searchViewYn = null;
	/* Column Info */
	private String trfInlndNm = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String trfPfxCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String trfInlndRtSeq = null;
	/* Column Info */
	private String trfInlndStsCd = null;
	/* Column Info */
	private String srcInfoCd = null;
	/* Column Info */
	private String atchFileId = null;
	/* Column Info */
	private String trfInlndAmdtTpCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String n1stCmncAmdtSeq = null;
	/* Column Info */
	private String excelFlg = null;
	/* Column Info */
	private String trfNo = null;
	/* Column Info */
	private String rqstOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PriTrfInlndParamVO() {}

	public PriTrfInlndParamVO(String ibflag, String pagerows, String trfInlndSeq, String amdtSeq, String creDt, String pubDt, String aproOfcCd, String etc1, String etc3, String etc2, String effDt, String trfInlndNm, String expDt, String trfPfxCd, String updUsrId, String updDt, String trfInlndRtSeq, String trfInlndStsCd, String srcInfoCd, String atchFileId, String trfInlndAmdtTpCd, String creUsrId, String n1stCmncAmdtSeq, String excelFlg, String trfNo, String rqstOfcCd, String searchViewYn) {
		this.trfInlndSeq = trfInlndSeq;
		this.amdtSeq = amdtSeq;
		this.pubDt = pubDt;
		this.creDt = creDt;
		this.aproOfcCd = aproOfcCd;
		this.etc1 = etc1;
		this.etc3 = etc3;
		this.etc2 = etc2;
		this.pagerows = pagerows;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.searchViewYn = searchViewYn;
		this.trfInlndNm = trfInlndNm;
		this.expDt = expDt;
		this.trfPfxCd = trfPfxCd;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.trfInlndRtSeq = trfInlndRtSeq;
		this.trfInlndStsCd = trfInlndStsCd;
		this.srcInfoCd = srcInfoCd;
		this.atchFileId = atchFileId;
		this.trfInlndAmdtTpCd = trfInlndAmdtTpCd;
		this.creUsrId = creUsrId;
		this.n1stCmncAmdtSeq = n1stCmncAmdtSeq;
		this.excelFlg = excelFlg;
		this.trfNo = trfNo;
		this.rqstOfcCd = rqstOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("trf_inlnd_seq", getTrfInlndSeq());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("pub_dt", getPubDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("apro_ofc_cd", getAproOfcCd());
		this.hashColumns.put("etc1", getEtc1());
		this.hashColumns.put("etc3", getEtc3());
		this.hashColumns.put("etc2", getEtc2());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("search_view_yn", getSearchViewYn());
		this.hashColumns.put("trf_inlnd_nm", getTrfInlndNm());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("trf_pfx_cd", getTrfPfxCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("trf_inlnd_rt_seq", getTrfInlndRtSeq());
		this.hashColumns.put("trf_inlnd_sts_cd", getTrfInlndStsCd());
		this.hashColumns.put("src_info_cd", getSrcInfoCd());
		this.hashColumns.put("atch_file_id", getAtchFileId());
		this.hashColumns.put("trf_inlnd_amdt_tp_cd", getTrfInlndAmdtTpCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("n1st_cmnc_amdt_seq", getN1stCmncAmdtSeq());
		this.hashColumns.put("excel_flg", getExcelFlg());
		this.hashColumns.put("trf_no", getTrfNo());
		this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("trf_inlnd_seq", "trfInlndSeq");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("pub_dt", "pubDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("apro_ofc_cd", "aproOfcCd");
		this.hashFields.put("etc1", "etc1");
		this.hashFields.put("etc3", "etc3");
		this.hashFields.put("etc2", "etc2");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("search_view_yn", "searchViewYn");
		this.hashFields.put("trf_inlnd_nm", "trfInlndNm");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("trf_pfx_cd", "trfPfxCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("trf_inlnd_rt_seq", "trfInlndRtSeq");
		this.hashFields.put("trf_inlnd_sts_cd", "trfInlndStsCd");
		this.hashFields.put("src_info_cd", "srcInfoCd");
		this.hashFields.put("atch_file_id", "atchFileId");
		this.hashFields.put("trf_inlnd_amdt_tp_cd", "trfInlndAmdtTpCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("n1st_cmnc_amdt_seq", "n1stCmncAmdtSeq");
		this.hashFields.put("excel_flg", "excelFlg");
		this.hashFields.put("trf_no", "trfNo");
		this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
		return this.hashFields;
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
	 * @return etc1
	 */
	public String getEtc1() {
		return this.etc1;
	}
	
	/**
	 * Column Info
	 * @return etc3
	 */
	public String getEtc3() {
		return this.etc3;
	}
	
	/**
	 * Column Info
	 * @return etc2
	 */
	public String getEtc2() {
		return this.etc2;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return searchViewYn
	 */
	public String getSearchViewYn() {
		return this.searchViewYn;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return trfInlndRtSeq
	 */
	public String getTrfInlndRtSeq() {
		return this.trfInlndRtSeq;
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
	 * @return srcInfoCd
	 */
	public String getSrcInfoCd() {
		return this.srcInfoCd;
	}
	
	/**
	 * Column Info
	 * @return atchFileId
	 */
	public String getAtchFileId() {
		return this.atchFileId;
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
	 * Column Info
	 * @return n1stCmncAmdtSeq
	 */
	public String getN1stCmncAmdtSeq() {
		return this.n1stCmncAmdtSeq;
	}
	
	/**
	 * Column Info
	 * @return excelFlg
	 */
	public String getExcelFlg() {
		return this.excelFlg;
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
	 * @param etc1
	 */
	public void setEtc1(String etc1) {
		this.etc1 = etc1;
	}
	
	/**
	 * Column Info
	 * @param etc3
	 */
	public void setEtc3(String etc3) {
		this.etc3 = etc3;
	}
	
	/**
	 * Column Info
	 * @param etc2
	 */
	public void setEtc2(String etc2) {
		this.etc2 = etc2;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param searchViewYn
	 */
	public void setSearchViewYn(String searchViewYn) {
		this.searchViewYn = searchViewYn;
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
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param trfInlndRtSeq
	 */
	public void setTrfInlndRtSeq(String trfInlndRtSeq) {
		this.trfInlndRtSeq = trfInlndRtSeq;
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
	 * @param srcInfoCd
	 */
	public void setSrcInfoCd(String srcInfoCd) {
		this.srcInfoCd = srcInfoCd;
	}
	
	/**
	 * Column Info
	 * @param atchFileId
	 */
	public void setAtchFileId(String atchFileId) {
		this.atchFileId = atchFileId;
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
	 * Column Info
	 * @param n1stCmncAmdtSeq
	 */
	public void setN1stCmncAmdtSeq(String n1stCmncAmdtSeq) {
		this.n1stCmncAmdtSeq = n1stCmncAmdtSeq;
	}
	
	/**
	 * Column Info
	 * @param excelFlg
	 */
	public void setExcelFlg(String excelFlg) {
		this.excelFlg = excelFlg;
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
		setTrfInlndSeq(JSPUtil.getParameter(request, prefix + "trf_inlnd_seq", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setPubDt(JSPUtil.getParameter(request, prefix + "pub_dt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setAproOfcCd(JSPUtil.getParameter(request, prefix + "apro_ofc_cd", ""));
		setEtc1(JSPUtil.getParameter(request, prefix + "etc1", ""));
		setEtc3(JSPUtil.getParameter(request, prefix + "etc3", ""));
		setEtc2(JSPUtil.getParameter(request, prefix + "etc2", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSearchViewYn(JSPUtil.getParameter(request, prefix + "search_view_yn", ""));
		setTrfInlndNm(JSPUtil.getParameter(request, prefix + "trf_inlnd_nm", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setTrfPfxCd(JSPUtil.getParameter(request, prefix + "trf_pfx_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setTrfInlndRtSeq(JSPUtil.getParameter(request, prefix + "trf_inlnd_rt_seq", ""));
		setTrfInlndStsCd(JSPUtil.getParameter(request, prefix + "trf_inlnd_sts_cd", ""));
		setSrcInfoCd(JSPUtil.getParameter(request, prefix + "src_info_cd", ""));
		setAtchFileId(JSPUtil.getParameter(request, prefix + "atch_file_id", ""));
		setTrfInlndAmdtTpCd(JSPUtil.getParameter(request, prefix + "trf_inlnd_amdt_tp_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setN1stCmncAmdtSeq(JSPUtil.getParameter(request, prefix + "n1st_cmnc_amdt_seq", ""));
		setExcelFlg(JSPUtil.getParameter(request, prefix + "excel_flg", ""));
		setTrfNo(JSPUtil.getParameter(request, prefix + "trf_no", ""));
		setRqstOfcCd(JSPUtil.getParameter(request, prefix + "rqst_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PriTrfInlndParamVO[]
	 */
	public PriTrfInlndParamVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PriTrfInlndParamVO[]
	 */
	public PriTrfInlndParamVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PriTrfInlndParamVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] trfInlndSeq = (JSPUtil.getParameter(request, prefix	+ "trf_inlnd_seq", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] pubDt = (JSPUtil.getParameter(request, prefix	+ "pub_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] aproOfcCd = (JSPUtil.getParameter(request, prefix	+ "apro_ofc_cd", length));
			String[] etc1 = (JSPUtil.getParameter(request, prefix	+ "etc1", length));
			String[] etc3 = (JSPUtil.getParameter(request, prefix	+ "etc3", length));
			String[] etc2 = (JSPUtil.getParameter(request, prefix	+ "etc2", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] searchViewYn = (JSPUtil.getParameter(request, prefix	+ "search_view_yn", length));
			String[] trfInlndNm = (JSPUtil.getParameter(request, prefix	+ "trf_inlnd_nm", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] trfPfxCd = (JSPUtil.getParameter(request, prefix	+ "trf_pfx_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] trfInlndRtSeq = (JSPUtil.getParameter(request, prefix	+ "trf_inlnd_rt_seq", length));
			String[] trfInlndStsCd = (JSPUtil.getParameter(request, prefix	+ "trf_inlnd_sts_cd", length));
			String[] srcInfoCd = (JSPUtil.getParameter(request, prefix	+ "src_info_cd", length));
			String[] atchFileId = (JSPUtil.getParameter(request, prefix	+ "atch_file_id", length));
			String[] trfInlndAmdtTpCd = (JSPUtil.getParameter(request, prefix	+ "trf_inlnd_amdt_tp_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] n1stCmncAmdtSeq = (JSPUtil.getParameter(request, prefix	+ "n1st_cmnc_amdt_seq", length));
			String[] excelFlg = (JSPUtil.getParameter(request, prefix	+ "excel_flg", length));
			String[] trfNo = (JSPUtil.getParameter(request, prefix	+ "trf_no", length));
			String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new PriTrfInlndParamVO();
				if (trfInlndSeq[i] != null)
					model.setTrfInlndSeq(trfInlndSeq[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (pubDt[i] != null)
					model.setPubDt(pubDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (aproOfcCd[i] != null)
					model.setAproOfcCd(aproOfcCd[i]);
				if (etc1[i] != null)
					model.setEtc1(etc1[i]);
				if (etc3[i] != null)
					model.setEtc3(etc3[i]);
				if (etc2[i] != null)
					model.setEtc2(etc2[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (searchViewYn[i] != null)
					model.setSearchViewYn(searchViewYn[i]);
				if (trfInlndNm[i] != null)
					model.setTrfInlndNm(trfInlndNm[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (trfPfxCd[i] != null)
					model.setTrfPfxCd(trfPfxCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (trfInlndRtSeq[i] != null)
					model.setTrfInlndRtSeq(trfInlndRtSeq[i]);
				if (trfInlndStsCd[i] != null)
					model.setTrfInlndStsCd(trfInlndStsCd[i]);
				if (srcInfoCd[i] != null)
					model.setSrcInfoCd(srcInfoCd[i]);
				if (atchFileId[i] != null)
					model.setAtchFileId(atchFileId[i]);
				if (trfInlndAmdtTpCd[i] != null)
					model.setTrfInlndAmdtTpCd(trfInlndAmdtTpCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (n1stCmncAmdtSeq[i] != null)
					model.setN1stCmncAmdtSeq(n1stCmncAmdtSeq[i]);
				if (excelFlg[i] != null)
					model.setExcelFlg(excelFlg[i]);
				if (trfNo[i] != null)
					model.setTrfNo(trfNo[i]);
				if (rqstOfcCd[i] != null)
					model.setRqstOfcCd(rqstOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPriTrfInlndParamVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PriTrfInlndParamVO[]
	 */
	public PriTrfInlndParamVO[] getPriTrfInlndParamVOs(){
		PriTrfInlndParamVO[] vos = (PriTrfInlndParamVO[])models.toArray(new PriTrfInlndParamVO[models.size()]);
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
		this.trfInlndSeq = this.trfInlndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pubDt = this.pubDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproOfcCd = this.aproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etc1 = this.etc1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etc3 = this.etc3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etc2 = this.etc2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchViewYn = this.searchViewYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfInlndNm = this.trfInlndNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfPfxCd = this.trfPfxCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfInlndRtSeq = this.trfInlndRtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfInlndStsCd = this.trfInlndStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcInfoCd = this.srcInfoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFileId = this.atchFileId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfInlndAmdtTpCd = this.trfInlndAmdtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stCmncAmdtSeq = this.n1stCmncAmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.excelFlg = this.excelFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfNo = this.trfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcCd = this.rqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
