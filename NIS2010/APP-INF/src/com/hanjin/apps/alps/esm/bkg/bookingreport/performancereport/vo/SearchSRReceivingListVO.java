/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SearchSRReceivingListVO.java
*@FileTitle : SearchSRReceivingListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.06
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2011.04.06 김기종 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo;

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
 * @author 김기종
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSRReceivingListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSRReceivingListVO> models = new ArrayList<SearchSRReceivingListVO>();
	
	/* Column Info */
	private String fromDt = null;
	/* Column Info */
	private String ofcIncSub = null;
	/* Column Info */
	private String imgFileRealPath = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String sndrFaxNoCtnt = null;
	/* Column Info */
	private String wrkTmNo = null;
	/* Column Info */
	private String rcvOfcCd = null;
	/* Column Info */
	private String srFaxRsltCd = null;
	/* Column Info */
	private String mtchUsrId = null;
	/* Column Info */
	private String imgFilePathCtnt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String srKndCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rcvDt = null;
	/* Column Info */
	private String srTrnsUsrNm = null;
	/* Column Info */
	private String faxLogRefNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String srNo = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String rcvRmk = null;
	/* Column Info */
	private String srTrnsUsrId = null;
	/* Column Info */
	private String rcvNm = null;
	/* Column Info */
	private String faxSvrOfcCd = null;
	/* Column Info */
	private String imgFileIp = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String ttlPgKnt = null;
	/* Column Info */
	private String imgFileNm = null;
	/* Column Info */
	private String srMtchStsCd = null;
	/* Column Info */
	private String mtchUsrNm = null;
	/* Column Info */
	private String srTrnsDt = null;
	/* Column Info */
	private String srMtchStsNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSRReceivingListVO() {}

	public SearchSRReceivingListVO(String ibflag, String pagerows, String srNo, String faxLogRefNo, String srKndCd, String sndrFaxNoCtnt, String rcvDt, String rcvOfcCd, String faxSvrOfcCd, String rcvNm, String rcvRmk, String imgFileIp, String imgFilePathCtnt, String imgFileNm, String imgFileRealPath, String ttlPgKnt, String srFaxRsltCd, String srMtchStsCd, String srMtchStsNm, String bkgNo, String mtchUsrId, String mtchUsrNm, String wrkTmNo, String creUsrId, String creDt, String updUsrId, String updDt, String srTrnsDt, String srTrnsUsrId, String srTrnsUsrNm, String fromDt, String toDt, String ofcIncSub) {
		this.fromDt = fromDt;
		this.ofcIncSub = ofcIncSub;
		this.imgFileRealPath = imgFileRealPath;
		this.creDt = creDt;
		this.sndrFaxNoCtnt = sndrFaxNoCtnt;
		this.wrkTmNo = wrkTmNo;
		this.rcvOfcCd = rcvOfcCd;
		this.srFaxRsltCd = srFaxRsltCd;
		this.mtchUsrId = mtchUsrId;
		this.imgFilePathCtnt = imgFilePathCtnt;
		this.pagerows = pagerows;
		this.srKndCd = srKndCd;
		this.ibflag = ibflag;
		this.rcvDt = rcvDt;
		this.srTrnsUsrNm = srTrnsUsrNm;
		this.faxLogRefNo = faxLogRefNo;
		this.updUsrId = updUsrId;
		this.srNo = srNo;
		this.updDt = updDt;
		this.rcvRmk = rcvRmk;
		this.srTrnsUsrId = srTrnsUsrId;
		this.rcvNm = rcvNm;
		this.faxSvrOfcCd = faxSvrOfcCd;
		this.imgFileIp = imgFileIp;
		this.toDt = toDt;
		this.bkgNo = bkgNo;
		this.creUsrId = creUsrId;
		this.ttlPgKnt = ttlPgKnt;
		this.imgFileNm = imgFileNm;
		this.srMtchStsCd = srMtchStsCd;
		this.mtchUsrNm = mtchUsrNm;
		this.srTrnsDt = srTrnsDt;
		this.srMtchStsNm = srMtchStsNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("from_dt", getFromDt());
		this.hashColumns.put("ofc_inc_sub", getOfcIncSub());
		this.hashColumns.put("img_file_real_path", getImgFileRealPath());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("sndr_fax_no_ctnt", getSndrFaxNoCtnt());
		this.hashColumns.put("wrk_tm_no", getWrkTmNo());
		this.hashColumns.put("rcv_ofc_cd", getRcvOfcCd());
		this.hashColumns.put("sr_fax_rslt_cd", getSrFaxRsltCd());
		this.hashColumns.put("mtch_usr_id", getMtchUsrId());
		this.hashColumns.put("img_file_path_ctnt", getImgFilePathCtnt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sr_knd_cd", getSrKndCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rcv_dt", getRcvDt());
		this.hashColumns.put("sr_trns_usr_nm", getSrTrnsUsrNm());
		this.hashColumns.put("fax_log_ref_no", getFaxLogRefNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("sr_no", getSrNo());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rcv_rmk", getRcvRmk());
		this.hashColumns.put("sr_trns_usr_id", getSrTrnsUsrId());
		this.hashColumns.put("rcv_nm", getRcvNm());
		this.hashColumns.put("fax_svr_ofc_cd", getFaxSvrOfcCd());
		this.hashColumns.put("img_file_ip", getImgFileIp());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ttl_pg_knt", getTtlPgKnt());
		this.hashColumns.put("img_file_nm", getImgFileNm());
		this.hashColumns.put("sr_mtch_sts_cd", getSrMtchStsCd());
		this.hashColumns.put("mtch_usr_nm", getMtchUsrNm());
		this.hashColumns.put("sr_trns_dt", getSrTrnsDt());
		this.hashColumns.put("sr_mtch_sts_nm", getSrMtchStsNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("from_dt", "fromDt");
		this.hashFields.put("ofc_inc_sub", "ofcIncSub");
		this.hashFields.put("img_file_real_path", "imgFileRealPath");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("sndr_fax_no_ctnt", "sndrFaxNoCtnt");
		this.hashFields.put("wrk_tm_no", "wrkTmNo");
		this.hashFields.put("rcv_ofc_cd", "rcvOfcCd");
		this.hashFields.put("sr_fax_rslt_cd", "srFaxRsltCd");
		this.hashFields.put("mtch_usr_id", "mtchUsrId");
		this.hashFields.put("img_file_path_ctnt", "imgFilePathCtnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sr_knd_cd", "srKndCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rcv_dt", "rcvDt");
		this.hashFields.put("sr_trns_usr_nm", "srTrnsUsrNm");
		this.hashFields.put("fax_log_ref_no", "faxLogRefNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("sr_no", "srNo");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rcv_rmk", "rcvRmk");
		this.hashFields.put("sr_trns_usr_id", "srTrnsUsrId");
		this.hashFields.put("rcv_nm", "rcvNm");
		this.hashFields.put("fax_svr_ofc_cd", "faxSvrOfcCd");
		this.hashFields.put("img_file_ip", "imgFileIp");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ttl_pg_knt", "ttlPgKnt");
		this.hashFields.put("img_file_nm", "imgFileNm");
		this.hashFields.put("sr_mtch_sts_cd", "srMtchStsCd");
		this.hashFields.put("mtch_usr_nm", "mtchUsrNm");
		this.hashFields.put("sr_trns_dt", "srTrnsDt");
		this.hashFields.put("sr_mtch_sts_nm", "srMtchStsNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fromDt
	 */
	public String getFromDt() {
		return this.fromDt;
	}
	
	/**
	 * Column Info
	 * @return ofcIncSub
	 */
	public String getOfcIncSub() {
		return this.ofcIncSub;
	}
	
	/**
	 * Column Info
	 * @return imgFileRealPath
	 */
	public String getImgFileRealPath() {
		return this.imgFileRealPath;
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
	 * @return sndrFaxNoCtnt
	 */
	public String getSndrFaxNoCtnt() {
		return this.sndrFaxNoCtnt;
	}
	
	/**
	 * Column Info
	 * @return wrkTmNo
	 */
	public String getWrkTmNo() {
		return this.wrkTmNo;
	}
	
	/**
	 * Column Info
	 * @return rcvOfcCd
	 */
	public String getRcvOfcCd() {
		return this.rcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @return srFaxRsltCd
	 */
	public String getSrFaxRsltCd() {
		return this.srFaxRsltCd;
	}
	
	/**
	 * Column Info
	 * @return mtchUsrId
	 */
	public String getMtchUsrId() {
		return this.mtchUsrId;
	}
	
	/**
	 * Column Info
	 * @return imgFilePathCtnt
	 */
	public String getImgFilePathCtnt() {
		return this.imgFilePathCtnt;
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
	 * @return srKndCd
	 */
	public String getSrKndCd() {
		return this.srKndCd;
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
	 * @return rcvDt
	 */
	public String getRcvDt() {
		return this.rcvDt;
	}
	
	/**
	 * Column Info
	 * @return srTrnsUsrNm
	 */
	public String getSrTrnsUsrNm() {
		return this.srTrnsUsrNm;
	}
	
	/**
	 * Column Info
	 * @return faxLogRefNo
	 */
	public String getFaxLogRefNo() {
		return this.faxLogRefNo;
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
	 * @return srNo
	 */
	public String getSrNo() {
		return this.srNo;
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
	 * @return rcvRmk
	 */
	public String getRcvRmk() {
		return this.rcvRmk;
	}
	
	/**
	 * Column Info
	 * @return srTrnsUsrId
	 */
	public String getSrTrnsUsrId() {
		return this.srTrnsUsrId;
	}
	
	/**
	 * Column Info
	 * @return rcvNm
	 */
	public String getRcvNm() {
		return this.rcvNm;
	}
	
	/**
	 * Column Info
	 * @return faxSvrOfcCd
	 */
	public String getFaxSvrOfcCd() {
		return this.faxSvrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return imgFileIp
	 */
	public String getImgFileIp() {
		return this.imgFileIp;
	}
	
	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return ttlPgKnt
	 */
	public String getTtlPgKnt() {
		return this.ttlPgKnt;
	}
	
	/**
	 * Column Info
	 * @return imgFileNm
	 */
	public String getImgFileNm() {
		return this.imgFileNm;
	}
	
	/**
	 * Column Info
	 * @return srMtchStsCd
	 */
	public String getSrMtchStsCd() {
		return this.srMtchStsCd;
	}
	
	/**
	 * Column Info
	 * @return mtchUsrNm
	 */
	public String getMtchUsrNm() {
		return this.mtchUsrNm;
	}
	
	/**
	 * Column Info
	 * @return srTrnsDt
	 */
	public String getSrTrnsDt() {
		return this.srTrnsDt;
	}
	
	/**
	 * Column Info
	 * @return srMtchStsNm
	 */
	public String getSrMtchStsNm() {
		return this.srMtchStsNm;
	}
	

	/**
	 * Column Info
	 * @param fromDt
	 */
	public void setFromDt(String fromDt) {
		this.fromDt = fromDt;
	}
	
	/**
	 * Column Info
	 * @param ofcIncSub
	 */
	public void setOfcIncSub(String ofcIncSub) {
		this.ofcIncSub = ofcIncSub;
	}
	
	/**
	 * Column Info
	 * @param imgFileRealPath
	 */
	public void setImgFileRealPath(String imgFileRealPath) {
		this.imgFileRealPath = imgFileRealPath;
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
	 * @param sndrFaxNoCtnt
	 */
	public void setSndrFaxNoCtnt(String sndrFaxNoCtnt) {
		this.sndrFaxNoCtnt = sndrFaxNoCtnt;
	}
	
	/**
	 * Column Info
	 * @param wrkTmNo
	 */
	public void setWrkTmNo(String wrkTmNo) {
		this.wrkTmNo = wrkTmNo;
	}
	
	/**
	 * Column Info
	 * @param rcvOfcCd
	 */
	public void setRcvOfcCd(String rcvOfcCd) {
		this.rcvOfcCd = rcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @param srFaxRsltCd
	 */
	public void setSrFaxRsltCd(String srFaxRsltCd) {
		this.srFaxRsltCd = srFaxRsltCd;
	}
	
	/**
	 * Column Info
	 * @param mtchUsrId
	 */
	public void setMtchUsrId(String mtchUsrId) {
		this.mtchUsrId = mtchUsrId;
	}
	
	/**
	 * Column Info
	 * @param imgFilePathCtnt
	 */
	public void setImgFilePathCtnt(String imgFilePathCtnt) {
		this.imgFilePathCtnt = imgFilePathCtnt;
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
	 * @param srKndCd
	 */
	public void setSrKndCd(String srKndCd) {
		this.srKndCd = srKndCd;
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
	 * @param rcvDt
	 */
	public void setRcvDt(String rcvDt) {
		this.rcvDt = rcvDt;
	}
	
	/**
	 * Column Info
	 * @param srTrnsUsrNm
	 */
	public void setSrTrnsUsrNm(String srTrnsUsrNm) {
		this.srTrnsUsrNm = srTrnsUsrNm;
	}
	
	/**
	 * Column Info
	 * @param faxLogRefNo
	 */
	public void setFaxLogRefNo(String faxLogRefNo) {
		this.faxLogRefNo = faxLogRefNo;
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
	 * @param srNo
	 */
	public void setSrNo(String srNo) {
		this.srNo = srNo;
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
	 * @param rcvRmk
	 */
	public void setRcvRmk(String rcvRmk) {
		this.rcvRmk = rcvRmk;
	}
	
	/**
	 * Column Info
	 * @param srTrnsUsrId
	 */
	public void setSrTrnsUsrId(String srTrnsUsrId) {
		this.srTrnsUsrId = srTrnsUsrId;
	}
	
	/**
	 * Column Info
	 * @param rcvNm
	 */
	public void setRcvNm(String rcvNm) {
		this.rcvNm = rcvNm;
	}
	
	/**
	 * Column Info
	 * @param faxSvrOfcCd
	 */
	public void setFaxSvrOfcCd(String faxSvrOfcCd) {
		this.faxSvrOfcCd = faxSvrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param imgFileIp
	 */
	public void setImgFileIp(String imgFileIp) {
		this.imgFileIp = imgFileIp;
	}
	
	/**
	 * Column Info
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param ttlPgKnt
	 */
	public void setTtlPgKnt(String ttlPgKnt) {
		this.ttlPgKnt = ttlPgKnt;
	}
	
	/**
	 * Column Info
	 * @param imgFileNm
	 */
	public void setImgFileNm(String imgFileNm) {
		this.imgFileNm = imgFileNm;
	}
	
	/**
	 * Column Info
	 * @param srMtchStsCd
	 */
	public void setSrMtchStsCd(String srMtchStsCd) {
		this.srMtchStsCd = srMtchStsCd;
	}
	
	/**
	 * Column Info
	 * @param mtchUsrNm
	 */
	public void setMtchUsrNm(String mtchUsrNm) {
		this.mtchUsrNm = mtchUsrNm;
	}
	
	/**
	 * Column Info
	 * @param srTrnsDt
	 */
	public void setSrTrnsDt(String srTrnsDt) {
		this.srTrnsDt = srTrnsDt;
	}
	
	/**
	 * Column Info
	 * @param srMtchStsNm
	 */
	public void setSrMtchStsNm(String srMtchStsNm) {
		this.srMtchStsNm = srMtchStsNm;
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
		setFromDt(JSPUtil.getParameter(request, prefix + "from_dt", ""));
		setOfcIncSub(JSPUtil.getParameter(request, prefix + "ofc_inc_sub", ""));
		setImgFileRealPath(JSPUtil.getParameter(request, prefix + "img_file_real_path", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSndrFaxNoCtnt(JSPUtil.getParameter(request, prefix + "sndr_fax_no_ctnt", ""));
		setWrkTmNo(JSPUtil.getParameter(request, prefix + "wrk_tm_no", ""));
		setRcvOfcCd(JSPUtil.getParameter(request, prefix + "rcv_ofc_cd", ""));
		setSrFaxRsltCd(JSPUtil.getParameter(request, prefix + "sr_fax_rslt_cd", ""));
		setMtchUsrId(JSPUtil.getParameter(request, prefix + "mtch_usr_id", ""));
		setImgFilePathCtnt(JSPUtil.getParameter(request, prefix + "img_file_path_ctnt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSrKndCd(JSPUtil.getParameter(request, prefix + "sr_knd_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRcvDt(JSPUtil.getParameter(request, prefix + "rcv_dt", ""));
		setSrTrnsUsrNm(JSPUtil.getParameter(request, prefix + "sr_trns_usr_nm", ""));
		setFaxLogRefNo(JSPUtil.getParameter(request, prefix + "fax_log_ref_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setSrNo(JSPUtil.getParameter(request, prefix + "sr_no", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setRcvRmk(JSPUtil.getParameter(request, prefix + "rcv_rmk", ""));
		setSrTrnsUsrId(JSPUtil.getParameter(request, prefix + "sr_trns_usr_id", ""));
		setRcvNm(JSPUtil.getParameter(request, prefix + "rcv_nm", ""));
		setFaxSvrOfcCd(JSPUtil.getParameter(request, prefix + "fax_svr_ofc_cd", ""));
		setImgFileIp(JSPUtil.getParameter(request, prefix + "img_file_ip", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setTtlPgKnt(JSPUtil.getParameter(request, prefix + "ttl_pg_knt", ""));
		setImgFileNm(JSPUtil.getParameter(request, prefix + "img_file_nm", ""));
		setSrMtchStsCd(JSPUtil.getParameter(request, prefix + "sr_mtch_sts_cd", ""));
		setMtchUsrNm(JSPUtil.getParameter(request, prefix + "mtch_usr_nm", ""));
		setSrTrnsDt(JSPUtil.getParameter(request, prefix + "sr_trns_dt", ""));
		setSrMtchStsNm(JSPUtil.getParameter(request, prefix + "sr_mtch_sts_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSRReceivingListVO[]
	 */
	public SearchSRReceivingListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSRReceivingListVO[]
	 */
	public SearchSRReceivingListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSRReceivingListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fromDt = (JSPUtil.getParameter(request, prefix	+ "from_dt", length));
			String[] ofcIncSub = (JSPUtil.getParameter(request, prefix	+ "ofc_inc_sub", length));
			String[] imgFileRealPath = (JSPUtil.getParameter(request, prefix	+ "img_file_real_path", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] sndrFaxNoCtnt = (JSPUtil.getParameter(request, prefix	+ "sndr_fax_no_ctnt", length));
			String[] wrkTmNo = (JSPUtil.getParameter(request, prefix	+ "wrk_tm_no", length));
			String[] rcvOfcCd = (JSPUtil.getParameter(request, prefix	+ "rcv_ofc_cd", length));
			String[] srFaxRsltCd = (JSPUtil.getParameter(request, prefix	+ "sr_fax_rslt_cd", length));
			String[] mtchUsrId = (JSPUtil.getParameter(request, prefix	+ "mtch_usr_id", length));
			String[] imgFilePathCtnt = (JSPUtil.getParameter(request, prefix	+ "img_file_path_ctnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] srKndCd = (JSPUtil.getParameter(request, prefix	+ "sr_knd_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rcvDt = (JSPUtil.getParameter(request, prefix	+ "rcv_dt", length));
			String[] srTrnsUsrNm = (JSPUtil.getParameter(request, prefix	+ "sr_trns_usr_nm", length));
			String[] faxLogRefNo = (JSPUtil.getParameter(request, prefix	+ "fax_log_ref_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] srNo = (JSPUtil.getParameter(request, prefix	+ "sr_no", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] rcvRmk = (JSPUtil.getParameter(request, prefix	+ "rcv_rmk", length));
			String[] srTrnsUsrId = (JSPUtil.getParameter(request, prefix	+ "sr_trns_usr_id", length));
			String[] rcvNm = (JSPUtil.getParameter(request, prefix	+ "rcv_nm", length));
			String[] faxSvrOfcCd = (JSPUtil.getParameter(request, prefix	+ "fax_svr_ofc_cd", length));
			String[] imgFileIp = (JSPUtil.getParameter(request, prefix	+ "img_file_ip", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ttlPgKnt = (JSPUtil.getParameter(request, prefix	+ "ttl_pg_knt", length));
			String[] imgFileNm = (JSPUtil.getParameter(request, prefix	+ "img_file_nm", length));
			String[] srMtchStsCd = (JSPUtil.getParameter(request, prefix	+ "sr_mtch_sts_cd", length));
			String[] mtchUsrNm = (JSPUtil.getParameter(request, prefix	+ "mtch_usr_nm", length));
			String[] srTrnsDt = (JSPUtil.getParameter(request, prefix	+ "sr_trns_dt", length));
			String[] srMtchStsNm = (JSPUtil.getParameter(request, prefix	+ "sr_mtch_sts_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSRReceivingListVO();
				if (fromDt[i] != null)
					model.setFromDt(fromDt[i]);
				if (ofcIncSub[i] != null)
					model.setOfcIncSub(ofcIncSub[i]);
				if (imgFileRealPath[i] != null)
					model.setImgFileRealPath(imgFileRealPath[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (sndrFaxNoCtnt[i] != null)
					model.setSndrFaxNoCtnt(sndrFaxNoCtnt[i]);
				if (wrkTmNo[i] != null)
					model.setWrkTmNo(wrkTmNo[i]);
				if (rcvOfcCd[i] != null)
					model.setRcvOfcCd(rcvOfcCd[i]);
				if (srFaxRsltCd[i] != null)
					model.setSrFaxRsltCd(srFaxRsltCd[i]);
				if (mtchUsrId[i] != null)
					model.setMtchUsrId(mtchUsrId[i]);
				if (imgFilePathCtnt[i] != null)
					model.setImgFilePathCtnt(imgFilePathCtnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (srKndCd[i] != null)
					model.setSrKndCd(srKndCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rcvDt[i] != null)
					model.setRcvDt(rcvDt[i]);
				if (srTrnsUsrNm[i] != null)
					model.setSrTrnsUsrNm(srTrnsUsrNm[i]);
				if (faxLogRefNo[i] != null)
					model.setFaxLogRefNo(faxLogRefNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (srNo[i] != null)
					model.setSrNo(srNo[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (rcvRmk[i] != null)
					model.setRcvRmk(rcvRmk[i]);
				if (srTrnsUsrId[i] != null)
					model.setSrTrnsUsrId(srTrnsUsrId[i]);
				if (rcvNm[i] != null)
					model.setRcvNm(rcvNm[i]);
				if (faxSvrOfcCd[i] != null)
					model.setFaxSvrOfcCd(faxSvrOfcCd[i]);
				if (imgFileIp[i] != null)
					model.setImgFileIp(imgFileIp[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ttlPgKnt[i] != null)
					model.setTtlPgKnt(ttlPgKnt[i]);
				if (imgFileNm[i] != null)
					model.setImgFileNm(imgFileNm[i]);
				if (srMtchStsCd[i] != null)
					model.setSrMtchStsCd(srMtchStsCd[i]);
				if (mtchUsrNm[i] != null)
					model.setMtchUsrNm(mtchUsrNm[i]);
				if (srTrnsDt[i] != null)
					model.setSrTrnsDt(srTrnsDt[i]);
				if (srMtchStsNm[i] != null)
					model.setSrMtchStsNm(srMtchStsNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSRReceivingListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSRReceivingListVO[]
	 */
	public SearchSRReceivingListVO[] getSearchSRReceivingListVOs(){
		SearchSRReceivingListVO[] vos = (SearchSRReceivingListVO[])models.toArray(new SearchSRReceivingListVO[models.size()]);
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
		this.fromDt = this.fromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcIncSub = this.ofcIncSub .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imgFileRealPath = this.imgFileRealPath .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndrFaxNoCtnt = this.sndrFaxNoCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrkTmNo = this.wrkTmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvOfcCd = this.rcvOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srFaxRsltCd = this.srFaxRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtchUsrId = this.mtchUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imgFilePathCtnt = this.imgFilePathCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srKndCd = this.srKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDt = this.rcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srTrnsUsrNm = this.srTrnsUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxLogRefNo = this.faxLogRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srNo = this.srNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvRmk = this.rcvRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srTrnsUsrId = this.srTrnsUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvNm = this.rcvNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSvrOfcCd = this.faxSvrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imgFileIp = this.imgFileIp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlPgKnt = this.ttlPgKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imgFileNm = this.imgFileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srMtchStsCd = this.srMtchStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtchUsrNm = this.mtchUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srTrnsDt = this.srTrnsDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srMtchStsNm = this.srMtchStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
