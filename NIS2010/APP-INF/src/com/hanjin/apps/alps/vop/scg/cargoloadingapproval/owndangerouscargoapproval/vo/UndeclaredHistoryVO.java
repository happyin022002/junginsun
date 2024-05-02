/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UndeclaredHistoryVO.java
*@FileTitle : UndeclaredHistoryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.15
*@LastModifier : 김도현 
*@LastVersion : 1.0
* 2015.12.15  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo;

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

public class UndeclaredHistoryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UndeclaredHistoryVO> models = new ArrayList<UndeclaredHistoryVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String rqstDt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String nonDcgoRqstSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String onBrdFlg = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String rsltRmk1 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String rsltRmk2 = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String interRmk = null;
	/* Column Info */
	private String cmdtDesc = null;
	/* Column Info */
	private String udeclDt = null;
	/* Column Info */
	private String cstmsDesc = null;
	/* Column Info */
	private String cmdtCtnt = null;
	/* Column Info */
	private String xterRmk = null;
	/* Column Info */
	private String rqstOfcCd = null;
	/* Column Info */
	private String cntrMfGdsDesc = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String rhq = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String polEtaDt = null;
	/* Column Info */
	private String keywordType = null;
	/* Column Info */
	private String keyword = null;
	/* Column Info */
	private String shipper = null;
	/* Column Info */
	private String rqstDtFr = null;
	/* Column Info */
	private String rqstDtTo = null;
	/* Column Info */
	private String chkBkgNo = null;
	/* Column Info */
	private String cstCmdtDesc = null;
	/* Column Info */
	private String rgnShpOprCd = null;
	/* Column Info */
	private String fileSavId = null;
	/* Column Info */
	private String fileNm = null;
	/* Column Info */
	private String fileSetYn = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public UndeclaredHistoryVO() {}

	public UndeclaredHistoryVO(String ibflag, String pagerows, String bkgNo, String rqstDt, String nonDcgoRqstSeq, String udeclDt, String rqstOfcCd, String vslCd, String skdVoyNo, String skdDirCd, String slanCd, String onBrdFlg, String cstmsDesc, String cntrMfGdsDesc, String cmdtDesc, String xterRmk, String interRmk, String cmdtCtnt, String rsltRmk1, String rsltRmk2, String creUsrId, String creDt, String updUsrId, String updDt, String rhq, String vvd, String polCd, String polEtaDt, String keywordType, String keyword, String shipper, String rqstDtFr, String rqstDtTo, String chkBkgNo, String cstCmdtDesc, String rgnShpOprCd, String fileSavId, String fileNm, String fileSetYn) {
		this.updDt = updDt;
		this.rqstDt = rqstDt;
		this.vslCd = vslCd;
		this.nonDcgoRqstSeq = nonDcgoRqstSeq;
		this.creDt = creDt;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.onBrdFlg = onBrdFlg;
		this.creUsrId = creUsrId;
		this.rsltRmk1 = rsltRmk1;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.rsltRmk2 = rsltRmk2;
		this.slanCd = slanCd;
		this.interRmk = interRmk;
		this.cmdtDesc = cmdtDesc;
		this.udeclDt = udeclDt;
		this.cstmsDesc = cstmsDesc;
		this.cmdtCtnt = cmdtCtnt;
		this.xterRmk = xterRmk;
		this.rqstOfcCd = rqstOfcCd;
		this.cntrMfGdsDesc = cntrMfGdsDesc;
		this.updUsrId = updUsrId;
		this.rhq = rhq;
		this.vvd = vvd;
		this.polCd = polCd;
		this.polEtaDt = polEtaDt;
		this.keywordType = keywordType;
		this.keyword = keyword;
		this.shipper = shipper;
		this.rqstDtFr = rqstDtFr;
		this.rqstDtTo = rqstDtTo;
		this.chkBkgNo = chkBkgNo;
		this.cstCmdtDesc = cstCmdtDesc;
		this.rgnShpOprCd = rgnShpOprCd;
		this.fileSavId = fileSavId;
		this.fileNm = fileNm;
		this.fileSetYn = fileSetYn;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rqst_dt", getRqstDt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("non_dcgo_rqst_seq", getNonDcgoRqstSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("on_brd_flg", getOnBrdFlg());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("rslt_rmk1", getRsltRmk1());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("rslt_rmk2", getRsltRmk2());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("inter_rmk", getInterRmk());
		this.hashColumns.put("cmdt_desc", getCmdtDesc());
		this.hashColumns.put("udecl_dt", getUdeclDt());
		this.hashColumns.put("cstms_desc", getCstmsDesc());
		this.hashColumns.put("cmdt_ctnt", getCmdtCtnt());
		this.hashColumns.put("xter_rmk", getXterRmk());
		this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
		this.hashColumns.put("cntr_mf_gds_desc", getCntrMfGdsDesc());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("rhq", getRhq());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("pol_eta_dt", getPolEtaDt());
		this.hashColumns.put("keyword_type", getKeywordType());
		this.hashColumns.put("keyword", getKeyword());
		this.hashColumns.put("shipper", getShipper());
		this.hashColumns.put("rqst_dt_fr", getRqstDtFr());
		this.hashColumns.put("rqst_dt_to", getRqstDtTo());
		this.hashColumns.put("chk_bkg_no", getChkBkgNo());
		this.hashColumns.put("cst_cmdt_desc", getCstCmdtDesc());
		this.hashColumns.put("rgn_shp_opr_cd", getRgnShpOprCd());
		this.hashColumns.put("file_sav_id", getFileSavId());
		this.hashColumns.put("file_nm", getFileNm());
		this.hashColumns.put("file_set_yn", getFileSetYn());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("non_dcgo_rqst_seq", "nonDcgoRqstSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("on_brd_flg", "onBrdFlg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("rslt_rmk1", "rsltRmk1");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("rslt_rmk2", "rsltRmk2");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("inter_rmk", "interRmk");
		this.hashFields.put("cmdt_desc", "cmdtDesc");
		this.hashFields.put("udecl_dt", "udeclDt");
		this.hashFields.put("cstms_desc", "cstmsDesc");
		this.hashFields.put("cmdt_ctnt", "cmdtCtnt");
		this.hashFields.put("xter_rmk", "xterRmk");
		this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
		this.hashFields.put("cntr_mf_gds_desc", "cntrMfGdsDesc");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("rhq", "rhq");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("pol_eta_dt", "polEtaDt");
		this.hashFields.put("keyword_type", "keywordType");
		this.hashFields.put("keyword", "keyword");
		this.hashFields.put("shipper", "shipper");
		this.hashFields.put("rqst_dt_fr", "rqstDtFr");
		this.hashFields.put("rqst_dt_to", "rqstDtTo");
		this.hashFields.put("chk_bkg_no", "chkBkgNo");
		this.hashFields.put("cst_cmdt_desc", "cstCmdtDesc");
		this.hashFields.put("rgn_shp_opr_cd", "rgnShpOprCd");
		this.hashFields.put("file_sav_id", "fileSavId");
		this.hashFields.put("file_nm", "fileNm");
		this.hashFields.put("file_set_yn", "fileSetYn");
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
	 * @return rqstDt
	 */
	public String getRqstDt() {
		return this.rqstDt;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return nonDcgoRqstSeq
	 */
	public String getNonDcgoRqstSeq() {
		return this.nonDcgoRqstSeq;
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return onBrdFlg
	 */
	public String getOnBrdFlg() {
		return this.onBrdFlg;
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
	 * @return rsltRmk1
	 */
	public String getRsltRmk1() {
		return this.rsltRmk1;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return rsltRmk2
	 */
	public String getRsltRmk2() {
		return this.rsltRmk2;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return interRmk
	 */
	public String getInterRmk() {
		return this.interRmk;
	}
	
	/**
	 * Column Info
	 * @return cmdtDesc
	 */
	public String getCmdtDesc() {
		return this.cmdtDesc;
	}
	
	/**
	 * Column Info
	 * @return udeclDt
	 */
	public String getUdeclDt() {
		return this.udeclDt;
	}
	
	/**
	 * Column Info
	 * @return cstmsDesc
	 */
	public String getCstmsDesc() {
		return this.cstmsDesc;
	}
	
	/**
	 * Column Info
	 * @return cmdtCtnt
	 */
	public String getCmdtCtnt() {
		return this.cmdtCtnt;
	}
	
	/**
	 * Column Info
	 * @return xterRmk
	 */
	public String getXterRmk() {
		return this.xterRmk;
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
	 * @return cntrMfGdsDesc
	 */
	public String getCntrMfGdsDesc() {
		return this.cntrMfGdsDesc;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param nonDcgoRqstSeq
	 */
	public void setNonDcgoRqstSeq(String nonDcgoRqstSeq) {
		this.nonDcgoRqstSeq = nonDcgoRqstSeq;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param onBrdFlg
	 */
	public void setOnBrdFlg(String onBrdFlg) {
		this.onBrdFlg = onBrdFlg;
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
	 * @param rsltRmk1
	 */
	public void setRsltRmk1(String rsltRmk1) {
		this.rsltRmk1 = rsltRmk1;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param rsltRmk2
	 */
	public void setRsltRmk2(String rsltRmk2) {
		this.rsltRmk2 = rsltRmk2;
	}
	
	/**
	 * Column Info
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param interRmk
	 */
	public void setInterRmk(String interRmk) {
		this.interRmk = interRmk;
	}
	
	/**
	 * Column Info
	 * @param cmdtDesc
	 */
	public void setCmdtDesc(String cmdtDesc) {
		this.cmdtDesc = cmdtDesc;
	}
	
	/**
	 * Column Info
	 * @param udeclDt
	 */
	public void setUdeclDt(String udeclDt) {
		this.udeclDt = udeclDt;
	}
	
	/**
	 * Column Info
	 * @param cstmsDesc
	 */
	public void setCstmsDesc(String cstmsDesc) {
		this.cstmsDesc = cstmsDesc;
	}
	
	/**
	 * Column Info
	 * @param cmdtCtnt
	 */
	public void setCmdtCtnt(String cmdtCtnt) {
		this.cmdtCtnt = cmdtCtnt;
	}
	
	/**
	 * Column Info
	 * @param xterRmk
	 */
	public void setXterRmk(String xterRmk) {
		this.xterRmk = xterRmk;
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
	 * @param cntrMfGdsDesc
	 */
	public void setCntrMfGdsDesc(String cntrMfGdsDesc) {
		this.cntrMfGdsDesc = cntrMfGdsDesc;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	public String getRhq() {
		return rhq;
	}

	public void setRhq(String rhq) {
		this.rhq = rhq;
	}

	public String getVvd() {
		return vvd;
	}

	public void setVvd(String vvd) {
		this.vvd = vvd;
	}

	public String getPolCd() {
		return polCd;
	}

	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}

	public String getPolEtaDt() {
		return polEtaDt;
	}

	public void setPolEtaDt(String polEtaDt) {
		this.polEtaDt = polEtaDt;
	}

	public String getKeywordType() {
		return keywordType;
	}

	public void setKeywordType(String keywordType) {
		this.keywordType = keywordType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getShipper() {
		return shipper;
	}

	public void setShipper(String shipper) {
		this.shipper = shipper;
	}

	public String getRqstDtFr() {
		return rqstDtFr;
	}

	public void setRqstDtFr(String rqstDtFr) {
		this.rqstDtFr = rqstDtFr;
	}

	public String getRqstDtTo() {
		return rqstDtTo;
	}

	public void setRqstDtTo(String rqstDtTo) {
		this.rqstDtTo = rqstDtTo;
	}

	
	public String getChkBkgNo() {
		return chkBkgNo;
	}

	public void setChkBkgNo(String chkBkgNo) {
		this.chkBkgNo = chkBkgNo;
	}

	public String getCstCmdtDesc() {
		return cstCmdtDesc;
	}

	public void setCstCmdtDesc(String cstCmdtDesc) {
		this.cstCmdtDesc = cstCmdtDesc;
	}

	public String getRgnShpOprCd() {
		return rgnShpOprCd;
	}

	public void setRgnShpOprCd(String rgnShpOprCd) {
		this.rgnShpOprCd = rgnShpOprCd;
	}
	
	public String getFileSavId() {
		return fileSavId;
	}

	public void setFileSavId(String fileSavId) {
		this.fileSavId = fileSavId;
	}

	public String getFileNm() {
		return fileNm;
	}

	public void setFileNm(String fileNm) {
		this.fileNm = fileNm;
	}
	
	public String getFileSetYn() {
		return fileSetYn;
	}

	public void setFileSetYn(String fileSetYn) {
		this.fileSetYn = fileSetYn;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setNonDcgoRqstSeq(JSPUtil.getParameter(request, prefix + "non_dcgo_rqst_seq", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOnBrdFlg(JSPUtil.getParameter(request, prefix + "on_brd_flg", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setRsltRmk1(JSPUtil.getParameter(request, prefix + "rslt_rmk1", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setRsltRmk2(JSPUtil.getParameter(request, prefix + "rslt_rmk2", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setInterRmk(JSPUtil.getParameter(request, prefix + "inter_rmk", ""));
		setCmdtDesc(JSPUtil.getParameter(request, prefix + "cmdt_desc", ""));
		setUdeclDt(JSPUtil.getParameter(request, prefix + "udecl_dt", ""));
		setCstmsDesc(JSPUtil.getParameter(request, prefix + "cstms_desc", ""));
		setCmdtCtnt(JSPUtil.getParameter(request, prefix + "cmdt_ctnt", ""));
		setXterRmk(JSPUtil.getParameter(request, prefix + "xter_rmk", ""));
		setRqstOfcCd(JSPUtil.getParameter(request, prefix + "rqst_ofc_cd", ""));
		setCntrMfGdsDesc(JSPUtil.getParameter(request, prefix + "cntr_mf_gds_desc", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setRhq(JSPUtil.getParameter(request, prefix + "rhq", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setPolEtaDt(JSPUtil.getParameter(request, prefix + "pol_eta_dt", ""));
		setKeywordType(JSPUtil.getParameter(request, prefix + "keyword_type", ""));
		setKeyword(JSPUtil.getParameter(request, prefix + "keyword", ""));
		setShipper(JSPUtil.getParameter(request, prefix + "shipper", ""));
		setRqstDtFr(JSPUtil.getParameter(request, prefix + "rqst_dt_fr", ""));
		setRqstDtTo(JSPUtil.getParameter(request, prefix + "rqst_dt_to", ""));
		setChkBkgNo(JSPUtil.getParameter(request, prefix + "chk_bkg_no", ""));
		setCstCmdtDesc(JSPUtil.getParameter(request, prefix + "cst_cmdt_desc", ""));
		setRgnShpOprCd(JSPUtil.getParameter(request, prefix + "rgn_shp_opr_cd", ""));
		setFileSavId(JSPUtil.getParameter(request, prefix + "file_sav_id", ""));
		setFileNm(JSPUtil.getParameter(request, prefix + "file_nm", ""));
		setFileSetYn(JSPUtil.getParameter(request, prefix + "file_set_yn", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UndeclaredHistoryVO[]
	 */
	public UndeclaredHistoryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UndeclaredHistoryVO[]
	 */
	public UndeclaredHistoryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UndeclaredHistoryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] rqstDt = (JSPUtil.getParameter(request, prefix	+ "rqst_dt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] nonDcgoRqstSeq = (JSPUtil.getParameter(request, prefix	+ "non_dcgo_rqst_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] onBrdFlg = (JSPUtil.getParameter(request, prefix	+ "on_brd_flg", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] rsltRmk1 = (JSPUtil.getParameter(request, prefix	+ "rslt_rmk1", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] rsltRmk2 = (JSPUtil.getParameter(request, prefix	+ "rslt_rmk2", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] interRmk = (JSPUtil.getParameter(request, prefix	+ "inter_rmk", length));
			String[] cmdtDesc = (JSPUtil.getParameter(request, prefix	+ "cmdt_desc", length));
			String[] udeclDt = (JSPUtil.getParameter(request, prefix	+ "udecl_dt", length));
			String[] cstmsDesc = (JSPUtil.getParameter(request, prefix	+ "cstms_desc", length));
			String[] cmdtCtnt = (JSPUtil.getParameter(request, prefix	+ "cmdt_ctnt", length));
			String[] xterRmk = (JSPUtil.getParameter(request, prefix	+ "xter_rmk", length));
			String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_cd", length));
			String[] cntrMfGdsDesc = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_gds_desc", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix	+ "rhq", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] polEtaDt = (JSPUtil.getParameter(request, prefix	+ "pol_eta_dt", length));
			String[] keywordType = (JSPUtil.getParameter(request, prefix	+ "keyword_type", length));
			String[] keyword = (JSPUtil.getParameter(request, prefix	+ "keyword", length));
			String[] shipper = (JSPUtil.getParameter(request, prefix	+ "shipper", length));
			String[] rqstDtFr = (JSPUtil.getParameter(request, prefix	+ "rqst_dt_fr", length));
			String[] rqstDtTo = (JSPUtil.getParameter(request, prefix	+ "rqst_dt_to", length));
			String[] chkBkgNo = (JSPUtil.getParameter(request, prefix	+ "chk_bkg_no", length));
			String[] cstCmdtDesc = (JSPUtil.getParameter(request, prefix	+ "cst_cmdt_desc", length));
			String[] rgnShpOprCd = (JSPUtil.getParameter(request, prefix	+ "rgn_shp_opr_cd", length));
			String[] fileSavId = (JSPUtil.getParameter(request, prefix	+ "file_sav_id", length));
			String[] fileNm = (JSPUtil.getParameter(request, prefix	+ "file_nm", length));
			String[] fileSetYn = (JSPUtil.getParameter(request, prefix	+ "file_set_yn", length));
			
			for (int i = 0; i < length; i++) {
				model = new UndeclaredHistoryVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (rqstDt[i] != null)
					model.setRqstDt(rqstDt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (nonDcgoRqstSeq[i] != null)
					model.setNonDcgoRqstSeq(nonDcgoRqstSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (onBrdFlg[i] != null)
					model.setOnBrdFlg(onBrdFlg[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (rsltRmk1[i] != null)
					model.setRsltRmk1(rsltRmk1[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (rsltRmk2[i] != null)
					model.setRsltRmk2(rsltRmk2[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (interRmk[i] != null)
					model.setInterRmk(interRmk[i]);
				if (cmdtDesc[i] != null)
					model.setCmdtDesc(cmdtDesc[i]);
				if (udeclDt[i] != null)
					model.setUdeclDt(udeclDt[i]);
				if (cstmsDesc[i] != null)
					model.setCstmsDesc(cstmsDesc[i]);
				if (cmdtCtnt[i] != null)
					model.setCmdtCtnt(cmdtCtnt[i]);
				if (xterRmk[i] != null)
					model.setXterRmk(xterRmk[i]);
				if (rqstOfcCd[i] != null)
					model.setRqstOfcCd(rqstOfcCd[i]);
				if (cntrMfGdsDesc[i] != null)
					model.setCntrMfGdsDesc(cntrMfGdsDesc[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (polEtaDt[i] != null)
					model.setPolEtaDt(polEtaDt[i]);
				if (keywordType[i] != null)
					model.setKeywordType(keywordType[i]);
				if (keyword[i] != null)
					model.setKeyword(keyword[i]);
				if (shipper[i] != null)
					model.setShipper(shipper[i]);
				if (rqstDtFr[i] != null)
					model.setRqstDtFr(rqstDtFr[i]);
				if (rqstDtTo[i] != null)
					model.setRqstDtTo(rqstDtTo[i]);
				if (chkBkgNo[i] != null)
					model.setChkBkgNo(chkBkgNo[i]);
				if (cstCmdtDesc[i] != null)
					model.setCstCmdtDesc(cstCmdtDesc[i]);
				if (rgnShpOprCd[i] != null)
					model.setRgnShpOprCd(rgnShpOprCd[i]);
				if (fileSavId[i] != null)
					model.setFileSavId(fileSavId[i]);
				if (fileNm[i] != null)
					model.setFileNm(fileNm[i]);
				if (fileSetYn[i] != null)
					model.setFileSetYn(fileSetYn[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUndeclaredHistoryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UndeclaredHistoryVO[]
	 */
	public UndeclaredHistoryVO[] getUndeclaredHistoryVOs(){
		UndeclaredHistoryVO[] vos = (UndeclaredHistoryVO[])models.toArray(new UndeclaredHistoryVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nonDcgoRqstSeq = this.nonDcgoRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onBrdFlg = this.onBrdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsltRmk1 = this.rsltRmk1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsltRmk2 = this.rsltRmk2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interRmk = this.interRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDesc = this.cmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.udeclDt = this.udeclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDesc = this.cstmsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCtnt = this.cmdtCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRmk = this.xterRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcCd = this.rqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfGdsDesc = this.cntrMfGdsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polEtaDt = this.polEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keywordType = this.keywordType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keyword = this.keyword .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipper = this.shipper .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDtFr = this.rqstDtFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDtTo = this.rqstDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkBkgNo = this.chkBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstCmdtDesc = this.cstCmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnShpOprCd = this.rgnShpOprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSavId = this.fileSavId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileNm = this.fileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSetYn = this.fileSetYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
