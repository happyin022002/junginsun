/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ScgChemicalHistoryVO.java
*@FileTitle : ScgChemicalHistoryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.14  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ScgChemicalHistoryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ScgChemicalHistoryVO> models = new ArrayList<ScgChemicalHistoryVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String rqstDt = null;
	/* Column Info */
	private String file2 = null;
	/* Column Info */
	private String file3 = null;
	/* Column Info */
	private String chemAbstSvcNo1 = null;
	/* Column Info */
	private String file1 = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String spclCgoFlg = null;
	/* Column Info */
	private String coNm = null;
	/* Column Info */
	private String reMsgId = null;
	/* Column Info */
	private String imdgSpclProviNo = null;
	/* Column Info */
	private String reMsgDt = null;
	/* Column Info */
	private String chemNm = null;
	/* Column Info */
	private String chemOpinKndCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String chemSeq = null;
	/* Column Info */
	private String rqstId = null;
	/* Column Info */
	private String cmtCtnt = null;
	/* Column Info */
	private String chemAbstSvcNo3 = null;
	/* Column Info */
	private String rqstOfcCd = null;
	/* Column Info */
	private String chemAbstSvcNo2 = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String rqstFrDt = null;
	/* Column Info */
	private String rqstToDt = null;
	/* Column Info */
	private String answerYn = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ScgChemicalHistoryVO() {}

	public ScgChemicalHistoryVO(String ibflag, String pagerows, String chemSeq, String chemNm, String chemAbstSvcNo1, String chemAbstSvcNo2, String chemAbstSvcNo3, String spclCgoFlg, String coNm, String chemOpinKndCd, String cmtCtnt, String imdgSpclProviNo, String rqstOfcCd, String rqstId, String rqstDt, String reMsgId, String reMsgDt, String creUsrId, String creDt, String updUsrId, String updDt, String file1, String file2, String file3,String rqstFrDt, String rqstToDt, String answerYn) {
		this.updDt = updDt;
		this.rqstDt = rqstDt;
		this.file2 = file2;
		this.file3 = file3;
		this.chemAbstSvcNo1 = chemAbstSvcNo1;
		this.file1 = file1;
		this.creDt = creDt;
		this.spclCgoFlg = spclCgoFlg;
		this.coNm = coNm;
		this.reMsgId = reMsgId;
		this.imdgSpclProviNo = imdgSpclProviNo;
		this.reMsgDt = reMsgDt;
		this.chemNm = chemNm;
		this.chemOpinKndCd = chemOpinKndCd;
		this.pagerows = pagerows;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.chemSeq = chemSeq;
		this.rqstId = rqstId;
		this.cmtCtnt = cmtCtnt;
		this.chemAbstSvcNo3 = chemAbstSvcNo3;
		this.rqstOfcCd = rqstOfcCd;
		this.chemAbstSvcNo2 = chemAbstSvcNo2;
		this.updUsrId = updUsrId;
		this.answerYn = answerYn;
		this.rqstFrDt = rqstFrDt;
		this.rqstToDt = rqstToDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rqst_dt", getRqstDt());
		this.hashColumns.put("file2", getFile2());
		this.hashColumns.put("file3", getFile3());
		this.hashColumns.put("chem_abst_svc_no1", getChemAbstSvcNo1());
		this.hashColumns.put("file1", getFile1());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("spcl_cgo_flg", getSpclCgoFlg());
		this.hashColumns.put("co_nm", getCoNm());
		this.hashColumns.put("re_msg_id", getReMsgId());
		this.hashColumns.put("imdg_spcl_provi_no", getImdgSpclProviNo());
		this.hashColumns.put("re_msg_dt", getReMsgDt());
		this.hashColumns.put("chem_nm", getChemNm());
		this.hashColumns.put("chem_opin_knd_cd", getChemOpinKndCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("chem_seq", getChemSeq());
		this.hashColumns.put("rqst_id", getRqstId());
		this.hashColumns.put("cmt_ctnt", getCmtCtnt());
		this.hashColumns.put("chem_abst_svc_no3", getChemAbstSvcNo3());
		this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
		this.hashColumns.put("chem_abst_svc_no2", getChemAbstSvcNo2());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("rqst_fr_dt", getRqstFrDt());
		this.hashColumns.put("rqst_to_dt", getRqstToDt());
		this.hashColumns.put("answer_yn",  getAnswerYn());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("file2", "file2");
		this.hashFields.put("file3", "file3");
		this.hashFields.put("chem_abst_svc_no1", "chemAbstSvcNo1");
		this.hashFields.put("file1", "file1");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("spcl_cgo_flg", "spclCgoFlg");
		this.hashFields.put("co_nm", "coNm");
		this.hashFields.put("re_msg_id", "reMsgId");
		this.hashFields.put("imdg_spcl_provi_no", "imdgSpclProviNo");
		this.hashFields.put("re_msg_dt", "reMsgDt");
		this.hashFields.put("chem_nm", "chemNm");
		this.hashFields.put("chem_opin_knd_cd", "chemOpinKndCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("chem_seq", "chemSeq");
		this.hashFields.put("rqst_id", "rqstId");
		this.hashFields.put("cmt_ctnt", "cmtCtnt");
		this.hashFields.put("chem_abst_svc_no3", "chemAbstSvcNo3");
		this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
		this.hashFields.put("chem_abst_svc_no2", "chemAbstSvcNo2");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("rqst_fr_dt", "rqstFrDt");
		this.hashFields.put("rqst_to_dt", "rqstToDt");
		this.hashFields.put("answer_yn",  "answerYn");
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
	 * @return rqstFrDt
	 */
	public String getRqstFrDt() {
		return this.rqstFrDt;
	}
	
	/**
	 * Column Info
	 * @return rqstToDt
	 */
	public String getRqstToDt() {
		return this.rqstToDt;
	}
	
	/**
	 * Column Info
	 * @return answerYn
	 */
	public String getAnswerYn() {
		return this.answerYn;
	}
	
	/**
	 * Column Info
	 * @return rqstDt
	 */
	public String getRqstDt() {
		return this.rqstDt;
	}
	
	/**
	 * Column Info
	 * @return file2
	 */
	public String getFile2() {
		return this.file2;
	}
	
	/**
	 * Column Info
	 * @return file3
	 */
	public String getFile3() {
		return this.file3;
	}
	
	/**
	 * Column Info
	 * @return chemAbstSvcNo1
	 */
	public String getChemAbstSvcNo1() {
		return this.chemAbstSvcNo1;
	}
	
	/**
	 * Column Info
	 * @return file1
	 */
	public String getFile1() {
		return this.file1;
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
	 * @return spclCgoFlg
	 */
	public String getSpclCgoFlg() {
		return this.spclCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return coNm
	 */
	public String getCoNm() {
		return this.coNm;
	}
	
	/**
	 * Column Info
	 * @return reMsgId
	 */
	public String getReMsgId() {
		return this.reMsgId;
	}
	
	/**
	 * Column Info
	 * @return imdgSpclProviNo
	 */
	public String getImdgSpclProviNo() {
		return this.imdgSpclProviNo;
	}
	
	/**
	 * Column Info
	 * @return reMsgDt
	 */
	public String getReMsgDt() {
		return this.reMsgDt;
	}
	
	/**
	 * Column Info
	 * @return chemNm
	 */
	public String getChemNm() {
		return this.chemNm;
	}
	
	/**
	 * Column Info
	 * @return chemOpinKndCd
	 */
	public String getChemOpinKndCd() {
		return this.chemOpinKndCd;
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
	 * @return chemSeq
	 */
	public String getChemSeq() {
		return this.chemSeq;
	}
	
	/**
	 * Column Info
	 * @return rqstId
	 */
	public String getRqstId() {
		return this.rqstId;
	}
	
	/**
	 * Column Info
	 * @return cmtCtnt
	 */
	public String getCmtCtnt() {
		return this.cmtCtnt;
	}
	
	/**
	 * Column Info
	 * @return chemAbstSvcNo3
	 */
	public String getChemAbstSvcNo3() {
		return this.chemAbstSvcNo3;
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
	 * @return chemAbstSvcNo2
	 */
	public String getChemAbstSvcNo2() {
		return this.chemAbstSvcNo2;
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
	 * @param rqstDt
	 */
	public void setRqstDt(String rqstDt) {
		this.rqstDt = rqstDt;
	}
	
	/**
	 * Column Info
	 * @param file2
	 */
	public void setFile2(String file2) {
		this.file2 = file2;
	}
	
	/**
	 * Column Info
	 * @param file3
	 */
	public void setFile3(String file3) {
		this.file3 = file3;
	}
	
	/**
	 * Column Info
	 * @param chemAbstSvcNo1
	 */
	public void setChemAbstSvcNo1(String chemAbstSvcNo1) {
		this.chemAbstSvcNo1 = chemAbstSvcNo1;
	}
	
	/**
	 * Column Info
	 * @param file1
	 */
	public void setFile1(String file1) {
		this.file1 = file1;
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
	 * @param spclCgoFlg
	 */
	public void setSpclCgoFlg(String spclCgoFlg) {
		this.spclCgoFlg = spclCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param coNm
	 */
	public void setCoNm(String coNm) {
		this.coNm = coNm;
	}
	
	/**
	 * Column Info
	 * @param reMsgId
	 */
	public void setReMsgId(String reMsgId) {
		this.reMsgId = reMsgId;
	}
	
	/**
	 * Column Info
	 * @param imdgSpclProviNo
	 */
	public void setImdgSpclProviNo(String imdgSpclProviNo) {
		this.imdgSpclProviNo = imdgSpclProviNo;
	}
	
	/**
	 * Column Info
	 * @param reMsgDt
	 */
	public void setReMsgDt(String reMsgDt) {
		this.reMsgDt = reMsgDt;
	}
	
	/**
	 * Column Info
	 * @param chemNm
	 */
	public void setChemNm(String chemNm) {
		this.chemNm = chemNm;
	}
	
	/**
	 * Column Info
	 * @param chemOpinKndCd
	 */
	public void setChemOpinKndCd(String chemOpinKndCd) {
		this.chemOpinKndCd = chemOpinKndCd;
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
	 * @param chemSeq
	 */
	public void setChemSeq(String chemSeq) {
		this.chemSeq = chemSeq;
	}
	
	/**
	 * Column Info
	 * @param rqstId
	 */
	public void setRqstId(String rqstId) {
		this.rqstId = rqstId;
	}
	
	/**
	 * Column Info
	 * @param cmtCtnt
	 */
	public void setCmtCtnt(String cmtCtnt) {
		this.cmtCtnt = cmtCtnt;
	}
	
	/**
	 * Column Info
	 * @param chemAbstSvcNo3
	 */
	public void setChemAbstSvcNo3(String chemAbstSvcNo3) {
		this.chemAbstSvcNo3 = chemAbstSvcNo3;
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
	 * @param chemAbstSvcNo2
	 */
	public void setChemAbstSvcNo2(String chemAbstSvcNo2) {
		this.chemAbstSvcNo2 = chemAbstSvcNo2;
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
	 * @param rqstFrDt
	 */
	public void setRqstFrDt(String rqstFrDt) {
		this.rqstFrDt = rqstFrDt;
	}
	
	/**
	 * Column Info
	 * @param rqstToDt
	 */
	public void setRqstToDt(String rqstToDt) {
		this.rqstToDt = rqstToDt;
	}
	
	/**
	 * Column Info
	 * @param answerYn
	 */
	public void setAnswerYn(String answerYn) {
		this.answerYn = answerYn;
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
		setRqstDt(JSPUtil.getParameter(request, prefix + "rqst_dt", ""));
		setFile2(JSPUtil.getParameter(request, prefix + "file2", ""));
		setFile3(JSPUtil.getParameter(request, prefix + "file3", ""));
		setChemAbstSvcNo1(JSPUtil.getParameter(request, prefix + "chem_abst_svc_no1", ""));
		setFile1(JSPUtil.getParameter(request, prefix + "file1", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSpclCgoFlg(JSPUtil.getParameter(request, prefix + "spcl_cgo_flg", ""));
		setCoNm(JSPUtil.getParameter(request, prefix + "co_nm", ""));
		setReMsgId(JSPUtil.getParameter(request, prefix + "re_msg_id", ""));
		setImdgSpclProviNo(JSPUtil.getParameter(request, prefix + "imdg_spcl_provi_no", ""));
		setReMsgDt(JSPUtil.getParameter(request, prefix + "re_msg_dt", ""));
		setChemNm(JSPUtil.getParameter(request, prefix + "chem_nm", ""));
		setChemOpinKndCd(JSPUtil.getParameter(request, prefix + "chem_opin_knd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setChemSeq(JSPUtil.getParameter(request, prefix + "chem_seq", ""));
		setRqstId(JSPUtil.getParameter(request, prefix + "rqst_id", ""));
		setCmtCtnt(JSPUtil.getParameter(request, prefix + "cmt_ctnt", ""));
		setChemAbstSvcNo3(JSPUtil.getParameter(request, prefix + "chem_abst_svc_no3", ""));
		setRqstOfcCd(JSPUtil.getParameter(request, prefix + "rqst_ofc_cd", ""));
		setChemAbstSvcNo2(JSPUtil.getParameter(request, prefix + "chem_abst_svc_no2", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setRqstFrDt(JSPUtil.getParameter(request, prefix + "rqst_fr_dt", ""));
		setRqstToDt(JSPUtil.getParameter(request, prefix + "rqst_to_dt", ""));
		setAnswerYn(JSPUtil.getParameter(request, prefix + "answer_yn", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScgChemicalHistoryVO[]
	 */
	public ScgChemicalHistoryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ScgChemicalHistoryVO[]
	 */
	public ScgChemicalHistoryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ScgChemicalHistoryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] rqstDt = (JSPUtil.getParameter(request, prefix	+ "rqst_dt", length));
			String[] file2 = (JSPUtil.getParameter(request, prefix	+ "file2", length));
			String[] file3 = (JSPUtil.getParameter(request, prefix	+ "file3", length));
			String[] chemAbstSvcNo1 = (JSPUtil.getParameter(request, prefix	+ "chem_abst_svc_no1", length));
			String[] file1 = (JSPUtil.getParameter(request, prefix	+ "file1", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] spclCgoFlg = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_flg", length));
			String[] coNm = (JSPUtil.getParameter(request, prefix	+ "co_nm", length));
			String[] reMsgId = (JSPUtil.getParameter(request, prefix	+ "re_msg_id", length));
			String[] imdgSpclProviNo = (JSPUtil.getParameter(request, prefix	+ "imdg_spcl_provi_no", length));
			String[] reMsgDt = (JSPUtil.getParameter(request, prefix	+ "re_msg_dt", length));
			String[] chemNm = (JSPUtil.getParameter(request, prefix	+ "chem_nm", length));
			String[] chemOpinKndCd = (JSPUtil.getParameter(request, prefix	+ "chem_opin_knd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] chemSeq = (JSPUtil.getParameter(request, prefix	+ "chem_seq", length));
			String[] rqstId = (JSPUtil.getParameter(request, prefix	+ "rqst_id", length));
			String[] cmtCtnt = (JSPUtil.getParameter(request, prefix	+ "cmt_ctnt", length));
			String[] chemAbstSvcNo3 = (JSPUtil.getParameter(request, prefix	+ "chem_abst_svc_no3", length));
			String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_cd", length));
			String[] chemAbstSvcNo2 = (JSPUtil.getParameter(request, prefix	+ "chem_abst_svc_no2", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] rqstFrDt = (JSPUtil.getParameter(request, prefix	+ "rqst_fr_dt", length));
			String[] rqstToDt = (JSPUtil.getParameter(request, prefix	+ "rqst_to_dt", length));
			String[] answerYn = (JSPUtil.getParameter(request, prefix	+ "answer_yn", length));
			
			for (int i = 0; i < length; i++) {
				model = new ScgChemicalHistoryVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (rqstDt[i] != null)
					model.setRqstDt(rqstDt[i]);
				if (file2[i] != null)
					model.setFile2(file2[i]);
				if (file3[i] != null)
					model.setFile3(file3[i]);
				if (chemAbstSvcNo1[i] != null)
					model.setChemAbstSvcNo1(chemAbstSvcNo1[i]);
				if (file1[i] != null)
					model.setFile1(file1[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (spclCgoFlg[i] != null)
					model.setSpclCgoFlg(spclCgoFlg[i]);
				if (coNm[i] != null)
					model.setCoNm(coNm[i]);
				if (reMsgId[i] != null)
					model.setReMsgId(reMsgId[i]);
				if (imdgSpclProviNo[i] != null)
					model.setImdgSpclProviNo(imdgSpclProviNo[i]);
				if (reMsgDt[i] != null)
					model.setReMsgDt(reMsgDt[i]);
				if (chemNm[i] != null)
					model.setChemNm(chemNm[i]);
				if (chemOpinKndCd[i] != null)
					model.setChemOpinKndCd(chemOpinKndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (chemSeq[i] != null)
					model.setChemSeq(chemSeq[i]);
				if (rqstId[i] != null)
					model.setRqstId(rqstId[i]);
				if (cmtCtnt[i] != null)
					model.setCmtCtnt(cmtCtnt[i]);
				if (chemAbstSvcNo3[i] != null)
					model.setChemAbstSvcNo3(chemAbstSvcNo3[i]);
				if (rqstOfcCd[i] != null)
					model.setRqstOfcCd(rqstOfcCd[i]);
				if (chemAbstSvcNo2[i] != null)
					model.setChemAbstSvcNo2(chemAbstSvcNo2[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (rqstFrDt[i] != null)
					model.setRqstFrDt(rqstFrDt[i]);
				if (rqstToDt[i] != null)
					model.setRqstToDt(rqstToDt[i]);
				if (answerYn[i] != null)
					model.setAnswerYn(answerYn[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getScgChemicalHistoryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ScgChemicalHistoryVO[]
	 */
	public ScgChemicalHistoryVO[] getScgChemicalHistoryVOs(){
		ScgChemicalHistoryVO[] vos = (ScgChemicalHistoryVO[])models.toArray(new ScgChemicalHistoryVO[models.size()]);
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
		this.rqstDt = this.rqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.file2 = this.file2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.file3 = this.file3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chemAbstSvcNo1 = this.chemAbstSvcNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.file1 = this.file1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoFlg = this.spclCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coNm = this.coNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reMsgId = this.reMsgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSpclProviNo = this.imdgSpclProviNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reMsgDt = this.reMsgDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chemNm = this.chemNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chemOpinKndCd = this.chemOpinKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chemSeq = this.chemSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstId = this.rqstId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmtCtnt = this.cmtCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chemAbstSvcNo3 = this.chemAbstSvcNo3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcCd = this.rqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chemAbstSvcNo2 = this.chemAbstSvcNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstFrDt = this.rqstFrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstToDt = this.rqstToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.answerYn = this.answerYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
