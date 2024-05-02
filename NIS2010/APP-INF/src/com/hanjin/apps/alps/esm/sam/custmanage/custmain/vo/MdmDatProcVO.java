/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : MdmDatProcVO.java
*@FileTitle : MdmDatProcVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.25
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.25  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MdmDatProcVO extends AbstractValueObject { 

	private static final long serialVersionUID = 1L;
	
	private Collection<MdmDatProcVO> models = new ArrayList<MdmDatProcVO>();
	
	/* Column Info */
	private String procTpCd = null;
	/* Column Info */
	private String rqstUsrId = null;
	/* Column Info */
	private String rqstNo = null;
	/* Column Info */
	private String rjctRmk = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String authTpCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String rqstCreDt = null;
	/* Column Info */
	private String toRqstDt = null;
	/* Column Info */
	private String procCreDt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mstDatSubjDesc = null;
	/* Column Info */
	private String rqstUpdDt = null;
	/* Column Info */
	private String mstDatSubjCd = null;
	/* Column Info */
	private String procUpdDt = null;
	/* Column Info */
	private String rqstCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String rmk = null;
	/* Column Info */
	private String aproRmk = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String ofcKndCd = null;
	/* Column Info */
	private String fmRqstDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String aproUsrId = null;
	/* Column Info */
	private String rqstOfcCd = null;
	/* Column Info */
	private String mdaaChk = null;
	/* Column Info */
	private String procTpNm = null;
	/* Column Info */
	private String rqstNm = null;
	/* Column Info */
	private String rqstDtlPgmNo = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String rqstUsrNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MdmDatProcVO() {}

	public MdmDatProcVO(String ibflag, String pagerows, String rqstNo, String mstDatSubjCd, String rqstUsrId, String rqstOfcCd, String aproUsrId, String procTpCd, String rjctRmk, String aproRmk, String rqstCreDt, String rqstUpdDt, String procCreDt, String procUpdDt, String creUsrId, String creDt, String updUsrId, String updDt, String deltFlg, String rqstDtlPgmNo, String procTpNm, String rqstNm, String fmRqstDt, String toRqstDt, String ofcKndCd, String rmk, String rqstCd, String mstDatSubjDesc, String authTpCd, String mdaaChk, String cntCd, String ofcCd, String rqstUsrNm) {
		this.procTpCd = procTpCd;
		this.rqstUsrId = rqstUsrId;
		this.rqstNo = rqstNo;
		this.rjctRmk = rjctRmk;
		this.deltFlg = deltFlg;
		this.authTpCd = authTpCd;
		this.creDt = creDt;
		this.rqstCreDt = rqstCreDt;
		this.toRqstDt = toRqstDt;
		this.procCreDt = procCreDt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.mstDatSubjDesc = mstDatSubjDesc;
		this.rqstUpdDt = rqstUpdDt;
		this.mstDatSubjCd = mstDatSubjCd;
		this.procUpdDt = procUpdDt;
		this.rqstCd = rqstCd;
		this.updUsrId = updUsrId;
		this.rmk = rmk;
		this.aproRmk = aproRmk;
		this.updDt = updDt;
		this.ofcKndCd = ofcKndCd;
		this.fmRqstDt = fmRqstDt;
		this.creUsrId = creUsrId;
		this.aproUsrId = aproUsrId;
		this.rqstOfcCd = rqstOfcCd;
		this.mdaaChk = mdaaChk;
		this.procTpNm = procTpNm;
		this.rqstNm = rqstNm;
		this.rqstDtlPgmNo = rqstDtlPgmNo;
		this.cntCd = cntCd;
		this.ofcCd = ofcCd;
		this.rqstUsrNm = rqstUsrNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("proc_tp_cd", getProcTpCd());
		this.hashColumns.put("rqst_usr_id", getRqstUsrId());
		this.hashColumns.put("rqst_no", getRqstNo());
		this.hashColumns.put("rjct_rmk", getRjctRmk());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("auth_tp_cd", getAuthTpCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("rqst_cre_dt", getRqstCreDt());
		this.hashColumns.put("to_rqst_dt", getToRqstDt());
		this.hashColumns.put("proc_cre_dt", getProcCreDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mst_dat_subj_desc", getMstDatSubjDesc());
		this.hashColumns.put("rqst_upd_dt", getRqstUpdDt());
		this.hashColumns.put("mst_dat_subj_cd", getMstDatSubjCd());
		this.hashColumns.put("proc_upd_dt", getProcUpdDt());
		this.hashColumns.put("rqst_cd", getRqstCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("rmk", getRmk());
		this.hashColumns.put("apro_rmk", getAproRmk());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ofc_knd_cd", getOfcKndCd());
		this.hashColumns.put("fm_rqst_dt", getFmRqstDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("apro_usr_id", getAproUsrId());
		this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
		this.hashColumns.put("mdaa_chk", getMdaaChk());
		this.hashColumns.put("proc_tp_nm", getProcTpNm());
		this.hashColumns.put("rqst_nm", getRqstNm());
		this.hashColumns.put("rqst_dtl_pgm_no", getRqstDtlPgmNo());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("rqst_usr_nm", getRqstUsrNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("proc_tp_cd", "procTpCd");
		this.hashFields.put("rqst_usr_id", "rqstUsrId");
		this.hashFields.put("rqst_no", "rqstNo");
		this.hashFields.put("rjct_rmk", "rjctRmk");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("auth_tp_cd", "authTpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("rqst_cre_dt", "rqstCreDt");
		this.hashFields.put("to_rqst_dt", "toRqstDt");
		this.hashFields.put("proc_cre_dt", "procCreDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mst_dat_subj_desc", "mstDatSubjDesc");
		this.hashFields.put("rqst_upd_dt", "rqstUpdDt");
		this.hashFields.put("mst_dat_subj_cd", "mstDatSubjCd");
		this.hashFields.put("proc_upd_dt", "procUpdDt");
		this.hashFields.put("rqst_cd", "rqstCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("rmk", "rmk");
		this.hashFields.put("apro_rmk", "aproRmk");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ofc_knd_cd", "ofcKndCd");
		this.hashFields.put("fm_rqst_dt", "fmRqstDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("apro_usr_id", "aproUsrId");
		this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
		this.hashFields.put("mdaa_chk", "mdaaChk");
		this.hashFields.put("proc_tp_nm", "procTpNm");
		this.hashFields.put("rqst_nm", "rqstNm");
		this.hashFields.put("rqst_dtl_pgm_no", "rqstDtlPgmNo");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("rqst_usr_nm", "rqstUsrNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return procTpCd
	 */
	public String getProcTpCd() {
		return this.procTpCd;
	}
	
	/**
	 * Column Info
	 * @return rqstUsrId
	 */
	public String getRqstUsrId() {
		return this.rqstUsrId;
	}
	
	/**
	 * Column Info
	 * @return rqstNo
	 */
	public String getRqstNo() {
		return this.rqstNo;
	}
	
	/**
	 * Column Info
	 * @return rjctRmk
	 */
	public String getRjctRmk() {
		return this.rjctRmk;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return authTpCd
	 */
	public String getAuthTpCd() {
		return this.authTpCd;
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
	 * @return rqstCreDt
	 */
	public String getRqstCreDt() {
		return this.rqstCreDt;
	}
	
	/**
	 * Column Info
	 * @return toRqstDt
	 */
	public String getToRqstDt() {
		return this.toRqstDt;
	}
	
	/**
	 * Column Info
	 * @return procCreDt
	 */
	public String getProcCreDt() {
		return this.procCreDt;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return mstDatSubjDesc
	 */
	public String getMstDatSubjDesc() {
		return this.mstDatSubjDesc;
	}
	
	/**
	 * Column Info
	 * @return rqstUpdDt
	 */
	public String getRqstUpdDt() {
		return this.rqstUpdDt;
	}
	
	/**
	 * Column Info
	 * @return mstDatSubjCd
	 */
	public String getMstDatSubjCd() {
		return this.mstDatSubjCd;
	}
	
	/**
	 * Column Info
	 * @return procUpdDt
	 */
	public String getProcUpdDt() {
		return this.procUpdDt;
	}
	
	/**
	 * Column Info
	 * @return rqstCd
	 */
	public String getRqstCd() {
		return this.rqstCd;
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
	 * @return rmk
	 */
	public String getRmk() {
		return this.rmk;
	}
	
	/**
	 * Column Info
	 * @return aproRmk
	 */
	public String getAproRmk() {
		return this.aproRmk;
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
	 * @return ofcKndCd
	 */
	public String getOfcKndCd() {
		return this.ofcKndCd;
	}
	
	/**
	 * Column Info
	 * @return fmRqstDt
	 */
	public String getFmRqstDt() {
		return this.fmRqstDt;
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
	 * @return aproUsrId
	 */
	public String getAproUsrId() {
		return this.aproUsrId;
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
	 * @return mdaaChk
	 */
	public String getMdaaChk() {
		return this.mdaaChk;
	}
	
	/**
	 * Column Info
	 * @return procTpNm
	 */
	public String getProcTpNm() {
		return this.procTpNm;
	}
	
	/**
	 * Column Info
	 * @return rqstNm
	 */
	public String getRqstNm() {
		return this.rqstNm;
	}
	
	/**
	 * Column Info
	 * @return rqstDtlPgmNo
	 */
	public String getRqstDtlPgmNo() {
		return this.rqstDtlPgmNo;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
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
	 * @param procTpCd
	 */
	public void setProcTpCd(String procTpCd) {
		this.procTpCd = procTpCd;
	}
	
	/**
	 * Column Info
	 * @param rqstUsrId
	 */
	public void setRqstUsrId(String rqstUsrId) {
		this.rqstUsrId = rqstUsrId;
	}
	
	/**
	 * Column Info
	 * @param rqstNo
	 */
	public void setRqstNo(String rqstNo) {
		this.rqstNo = rqstNo;
	}
	
	/**
	 * Column Info
	 * @param rjctRmk
	 */
	public void setRjctRmk(String rjctRmk) {
		this.rjctRmk = rjctRmk;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param authTpCd
	 */
	public void setAuthTpCd(String authTpCd) {
		this.authTpCd = authTpCd;
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
	 * @param rqstCreDt
	 */
	public void setRqstCreDt(String rqstCreDt) {
		this.rqstCreDt = rqstCreDt;
	}
	
	/**
	 * Column Info
	 * @param toRqstDt
	 */
	public void setToRqstDt(String toRqstDt) {
		this.toRqstDt = toRqstDt;
	}
	
	/**
	 * Column Info
	 * @param procCreDt
	 */
	public void setProcCreDt(String procCreDt) {
		this.procCreDt = procCreDt;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param mstDatSubjDesc
	 */
	public void setMstDatSubjDesc(String mstDatSubjDesc) {
		this.mstDatSubjDesc = mstDatSubjDesc;
	}
	
	/**
	 * Column Info
	 * @param rqstUpdDt
	 */
	public void setRqstUpdDt(String rqstUpdDt) {
		this.rqstUpdDt = rqstUpdDt;
	}
	
	/**
	 * Column Info
	 * @param mstDatSubjCd
	 */
	public void setMstDatSubjCd(String mstDatSubjCd) {
		this.mstDatSubjCd = mstDatSubjCd;
	}
	
	/**
	 * Column Info
	 * @param procUpdDt
	 */
	public void setProcUpdDt(String procUpdDt) {
		this.procUpdDt = procUpdDt;
	}
	
	/**
	 * Column Info
	 * @param rqstCd
	 */
	public void setRqstCd(String rqstCd) {
		this.rqstCd = rqstCd;
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
	 * @param rmk
	 */
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
	
	/**
	 * Column Info
	 * @param aproRmk
	 */
	public void setAproRmk(String aproRmk) {
		this.aproRmk = aproRmk;
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
	 * @param ofcKndCd
	 */
	public void setOfcKndCd(String ofcKndCd) {
		this.ofcKndCd = ofcKndCd;
	}
	
	/**
	 * Column Info
	 * @param fmRqstDt
	 */
	public void setFmRqstDt(String fmRqstDt) {
		this.fmRqstDt = fmRqstDt;
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
	 * @param aproUsrId
	 */
	public void setAproUsrId(String aproUsrId) {
		this.aproUsrId = aproUsrId;
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
	 * @param mdaaChk
	 */
	public void setMdaaChk(String mdaaChk) {
		this.mdaaChk = mdaaChk;
	}
	
	/**
	 * Column Info
	 * @param procTpNm
	 */
	public void setProcTpNm(String procTpNm) {
		this.procTpNm = procTpNm;
	}
	
	/**
	 * Column Info
	 * @param rqstNm
	 */
	public void setRqstNm(String rqstNm) {
		this.rqstNm = rqstNm;
	}
	
	/**
	 * Column Info
	 * @param rqstDtlPgmNo
	 */
	public void setRqstDtlPgmNo(String rqstDtlPgmNo) {
		this.rqstDtlPgmNo = rqstDtlPgmNo;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	public String getRqstUsrNm() {
		return rqstUsrNm;
	}

	public void setRqstUsrNm(String rqstUsrNm) {
		this.rqstUsrNm = rqstUsrNm;
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
		setProcTpCd(JSPUtil.getParameter(request, prefix + "proc_tp_cd", ""));
		setRqstUsrId(JSPUtil.getParameter(request, prefix + "rqst_usr_id", ""));
		setRqstNo(JSPUtil.getParameter(request, prefix + "rqst_no", ""));
		setRjctRmk(JSPUtil.getParameter(request, prefix + "rjct_rmk", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setAuthTpCd(JSPUtil.getParameter(request, prefix + "auth_tp_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setRqstCreDt(JSPUtil.getParameter(request, prefix + "rqst_cre_dt", ""));
		setToRqstDt(JSPUtil.getParameter(request, prefix + "to_rqst_dt", ""));
		setProcCreDt(JSPUtil.getParameter(request, prefix + "proc_cre_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMstDatSubjDesc(JSPUtil.getParameter(request, prefix + "mst_dat_subj_desc", ""));
		setRqstUpdDt(JSPUtil.getParameter(request, prefix + "rqst_upd_dt", ""));
		setMstDatSubjCd(JSPUtil.getParameter(request, prefix + "mst_dat_subj_cd", ""));
		setProcUpdDt(JSPUtil.getParameter(request, prefix + "proc_upd_dt", ""));
		setRqstCd(JSPUtil.getParameter(request, prefix + "rqst_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setRmk(JSPUtil.getParameter(request, prefix + "rmk", ""));
		setAproRmk(JSPUtil.getParameter(request, prefix + "apro_rmk", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setOfcKndCd(JSPUtil.getParameter(request, prefix + "ofc_knd_cd", ""));
		setFmRqstDt(JSPUtil.getParameter(request, prefix + "fm_rqst_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setAproUsrId(JSPUtil.getParameter(request, prefix + "apro_usr_id", ""));
		setRqstOfcCd(JSPUtil.getParameter(request, prefix + "rqst_ofc_cd", ""));
		setMdaaChk(JSPUtil.getParameter(request, prefix + "mdaa_chk", ""));
		setProcTpNm(JSPUtil.getParameter(request, prefix + "proc_tp_nm", ""));
		setRqstNm(JSPUtil.getParameter(request, prefix + "rqst_nm", ""));
		setRqstDtlPgmNo(JSPUtil.getParameter(request, prefix + "rqst_dtl_pgm_no", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setRqstUsrNm(JSPUtil.getParameter(request, prefix + "rqst_usr_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MdmDatProcVO[]
	 */
	public MdmDatProcVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MdmDatProcVO[]
	 */
	public MdmDatProcVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MdmDatProcVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] procTpCd = (JSPUtil.getParameter(request, prefix	+ "proc_tp_cd", length));
			String[] rqstUsrId = (JSPUtil.getParameter(request, prefix	+ "rqst_usr_id", length));
			String[] rqstNo = (JSPUtil.getParameter(request, prefix	+ "rqst_no", length));
			String[] rjctRmk = (JSPUtil.getParameter(request, prefix	+ "rjct_rmk", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] authTpCd = (JSPUtil.getParameter(request, prefix	+ "auth_tp_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] rqstCreDt = (JSPUtil.getParameter(request, prefix	+ "rqst_cre_dt", length));
			String[] toRqstDt = (JSPUtil.getParameter(request, prefix	+ "to_rqst_dt", length));
			String[] procCreDt = (JSPUtil.getParameter(request, prefix	+ "proc_cre_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mstDatSubjDesc = (JSPUtil.getParameter(request, prefix	+ "mst_dat_subj_desc", length));
			String[] rqstUpdDt = (JSPUtil.getParameter(request, prefix	+ "rqst_upd_dt", length));
			String[] mstDatSubjCd = (JSPUtil.getParameter(request, prefix	+ "mst_dat_subj_cd", length));
			String[] procUpdDt = (JSPUtil.getParameter(request, prefix	+ "proc_upd_dt", length));
			String[] rqstCd = (JSPUtil.getParameter(request, prefix	+ "rqst_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] rmk = (JSPUtil.getParameter(request, prefix	+ "rmk", length));
			String[] aproRmk = (JSPUtil.getParameter(request, prefix	+ "apro_rmk", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] ofcKndCd = (JSPUtil.getParameter(request, prefix	+ "ofc_knd_cd", length));
			String[] fmRqstDt = (JSPUtil.getParameter(request, prefix	+ "fm_rqst_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] aproUsrId = (JSPUtil.getParameter(request, prefix	+ "apro_usr_id", length));
			String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_cd", length));
			String[] mdaaChk = (JSPUtil.getParameter(request, prefix	+ "mdaa_chk", length));
			String[] procTpNm = (JSPUtil.getParameter(request, prefix	+ "proc_tp_nm", length));
			String[] rqstNm = (JSPUtil.getParameter(request, prefix	+ "rqst_nm", length));
			String[] rqstDtlPgmNo = (JSPUtil.getParameter(request, prefix	+ "rqst_dtl_pgm_no", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] rqstUsrNm = (JSPUtil.getParameter(request, prefix	+ "rqst_usr_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new MdmDatProcVO();
				if (procTpCd[i] != null)
					model.setProcTpCd(procTpCd[i]);
				if (rqstUsrId[i] != null)
					model.setRqstUsrId(rqstUsrId[i]);
				if (rqstNo[i] != null)
					model.setRqstNo(rqstNo[i]);
				if (rjctRmk[i] != null)
					model.setRjctRmk(rjctRmk[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (authTpCd[i] != null)
					model.setAuthTpCd(authTpCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (rqstCreDt[i] != null)
					model.setRqstCreDt(rqstCreDt[i]);
				if (toRqstDt[i] != null)
					model.setToRqstDt(toRqstDt[i]);
				if (procCreDt[i] != null)
					model.setProcCreDt(procCreDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mstDatSubjDesc[i] != null)
					model.setMstDatSubjDesc(mstDatSubjDesc[i]);
				if (rqstUpdDt[i] != null)
					model.setRqstUpdDt(rqstUpdDt[i]);
				if (mstDatSubjCd[i] != null)
					model.setMstDatSubjCd(mstDatSubjCd[i]);
				if (procUpdDt[i] != null)
					model.setProcUpdDt(procUpdDt[i]);
				if (rqstCd[i] != null)
					model.setRqstCd(rqstCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (rmk[i] != null)
					model.setRmk(rmk[i]);
				if (aproRmk[i] != null)
					model.setAproRmk(aproRmk[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ofcKndCd[i] != null)
					model.setOfcKndCd(ofcKndCd[i]);
				if (fmRqstDt[i] != null)
					model.setFmRqstDt(fmRqstDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (aproUsrId[i] != null)
					model.setAproUsrId(aproUsrId[i]);
				if (rqstOfcCd[i] != null)
					model.setRqstOfcCd(rqstOfcCd[i]);
				if (mdaaChk[i] != null)
					model.setMdaaChk(mdaaChk[i]);
				if (procTpNm[i] != null)
					model.setProcTpNm(procTpNm[i]);
				if (rqstNm[i] != null)
					model.setRqstNm(rqstNm[i]);
				if (rqstDtlPgmNo[i] != null)
					model.setRqstDtlPgmNo(rqstDtlPgmNo[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (rqstUsrNm[i] != null)
					model.setRqstUsrNm(rqstUsrNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMdmDatProcVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MdmDatProcVO[]
	 */
	public MdmDatProcVO[] getMdmDatProcVOs(){
		MdmDatProcVO[] vos = (MdmDatProcVO[])models.toArray(new MdmDatProcVO[models.size()]);
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
		this.procTpCd = this.procTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUsrId = this.rqstUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstNo = this.rqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rjctRmk = this.rjctRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authTpCd = this.authTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstCreDt = this.rqstCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toRqstDt = this.toRqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.procCreDt = this.procCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstDatSubjDesc = this.mstDatSubjDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUpdDt = this.rqstUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstDatSubjCd = this.mstDatSubjCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.procUpdDt = this.procUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstCd = this.rqstCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rmk = this.rmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproRmk = this.aproRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcKndCd = this.ofcKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmRqstDt = this.fmRqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproUsrId = this.aproUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcCd = this.rqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdaaChk = this.mdaaChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.procTpNm = this.procTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstNm = this.rqstNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDtlPgmNo = this.rqstDtlPgmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUsrNm = this.rqstUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
