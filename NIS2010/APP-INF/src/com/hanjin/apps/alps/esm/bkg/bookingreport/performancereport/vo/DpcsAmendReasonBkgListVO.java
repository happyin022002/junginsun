/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DpcsAmendReasonBkgListVO.java
*@FileTitle : DpcsAmendReasonBkgListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.26
*@LastModifier : 
*@LastVersion : 1.0
* 2011.07.26  
* 1.0 Creation
* 2011.10.04 정선용 [CHM-201112445] SI Automation System 구축
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DpcsAmendReasonBkgListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DpcsAmendReasonBkgListVO> models = new ArrayList<DpcsAmendReasonBkgListVO>();
	
	/* Column Info */
	private String splitFlg = null;
	/* Column Info */
	private String srUrgNm = null;
	/* Column Info */
	private String imgFileRealPath = null;
	/* Column Info */
	private String srAmdSeq = null;
	/* Column Info */
	private String rtnToRtnUsrId = null;
	/* Column Info */
	private String returnCd = null;
	/* Column Info */
	private String rcvOfcCd = null;
	/* Column Info */
	private String imgFilePathCtnt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rtnToUsrId = null;
	/* Column Info */
	private String srDueDt = null;
	/* Column Info */
	private String srWrkStsUsrNm = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String srKndCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String srWrkStsCd = null;
	/* Column Info */
	private String srWrkStsUsrId = null;
	/* Column Info */
	private String returnTo = null;
	/* Column Info */
	private String fntOfcTrnsDt = null;
	/* Column Info */
	private String srAmdTpCd = null;
	/* Column Info */
	private String blSplitNo = null;
	/* Column Info */
	private String srNo = null;
	/* Column Info */
	private String rtnFmUsrId = null;
	/* Column Info */
	private String srAmdTpNm = null;
	/* Column Info */
	private String srWrkStsDt = null;
	/* Column Info */
	private String blSplitTtlKnt = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String srAmdRsnCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String imgPgNo = null;
	/* Column Info */
	private String returnSrc = null;
	/* Column Info */
	private String srAmdRsnTpCd = null;
	/* Column Info */
	private String srUrgCd = null;
	/* Column Info */
	private String split = null;
	/* Column Info */
	private String imgFileNm = null;
	/* Column Info */
	private String srMtchStsCd = null;
	/* Column Info */
	private String faxLogRefNo = null;	
	/* Column Info */
	private String fntOfcEml = null;		
	
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DpcsAmendReasonBkgListVO() {}

	public DpcsAmendReasonBkgListVO(String ibflag, String pagerows, String srUrgNm, String imgFileRealPath, String rtnToRtnUsrId, String srAmdSeq, String returnCd, String rcvOfcCd, String imgFilePathCtnt, String rtnToUsrId, String srWrkStsUsrNm, String srKndCd, String polCd, String srWrkStsCd, String srWrkStsUsrId, String returnTo, String fntOfcTrnsDt, String srAmdTpCd, String srNo, String rtnFmUsrId, String srAmdTpNm, String srWrkStsDt, String podCd, String vvd, String bkgNo, String srAmdRsnCd, String diffRmk, String returnSrc, String imgPgNo, String srAmdRsnTpCd, String srUrgCd, String srMtchStsCd, String imgFileNm, String blSplitNo, String blSplitTtlKnt, String srDueDt, String split, String splitFlg, String faxLogRefNo,String fntOfcEml) {
		this.splitFlg = splitFlg;
		this.srUrgNm = srUrgNm;
		this.imgFileRealPath = imgFileRealPath;
		this.srAmdSeq = srAmdSeq;
		this.rtnToRtnUsrId = rtnToRtnUsrId;
		this.returnCd = returnCd;
		this.rcvOfcCd = rcvOfcCd;
		this.imgFilePathCtnt = imgFilePathCtnt;
		this.pagerows = pagerows;
		this.rtnToUsrId = rtnToUsrId;
		this.srDueDt = srDueDt;
		this.srWrkStsUsrNm = srWrkStsUsrNm;
		this.polCd = polCd;
		this.srKndCd = srKndCd;
		this.ibflag = ibflag;
		this.srWrkStsCd = srWrkStsCd;
		this.srWrkStsUsrId = srWrkStsUsrId;
		this.returnTo = returnTo;
		this.fntOfcTrnsDt = fntOfcTrnsDt;
		this.srAmdTpCd = srAmdTpCd;
		this.blSplitNo = blSplitNo;
		this.srNo = srNo;
		this.rtnFmUsrId = rtnFmUsrId;
		this.srAmdTpNm = srAmdTpNm;
		this.srWrkStsDt = srWrkStsDt;
		this.blSplitTtlKnt = blSplitTtlKnt;
		this.podCd = podCd;
		this.vvd = vvd;
		this.srAmdRsnCd = srAmdRsnCd;
		this.bkgNo = bkgNo;
		this.diffRmk = diffRmk;
		this.imgPgNo = imgPgNo;
		this.returnSrc = returnSrc;
		this.srAmdRsnTpCd = srAmdRsnTpCd;
		this.srUrgCd = srUrgCd;
		this.split = split;
		this.imgFileNm = imgFileNm;
		this.srMtchStsCd = srMtchStsCd;
		this.faxLogRefNo = faxLogRefNo;
		this.fntOfcEml = fntOfcEml;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("split_flg", getSplitFlg());
		this.hashColumns.put("sr_urg_nm", getSrUrgNm());
		this.hashColumns.put("img_file_real_path", getImgFileRealPath());
		this.hashColumns.put("sr_amd_seq", getSrAmdSeq());
		this.hashColumns.put("rtn_to_rtn_usr_id", getRtnToRtnUsrId());
		this.hashColumns.put("return_cd", getReturnCd());
		this.hashColumns.put("rcv_ofc_cd", getRcvOfcCd());
		this.hashColumns.put("img_file_path_ctnt", getImgFilePathCtnt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rtn_to_usr_id", getRtnToUsrId());
		this.hashColumns.put("sr_due_dt", getSrDueDt());
		this.hashColumns.put("sr_wrk_sts_usr_nm", getSrWrkStsUsrNm());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("sr_knd_cd", getSrKndCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sr_wrk_sts_cd", getSrWrkStsCd());
		this.hashColumns.put("sr_wrk_sts_usr_id", getSrWrkStsUsrId());
		this.hashColumns.put("return_to", getReturnTo());
		this.hashColumns.put("fnt_ofc_trns_dt", getFntOfcTrnsDt());
		this.hashColumns.put("sr_amd_tp_cd", getSrAmdTpCd());
		this.hashColumns.put("bl_split_no", getBlSplitNo());
		this.hashColumns.put("sr_no", getSrNo());
		this.hashColumns.put("rtn_fm_usr_id", getRtnFmUsrId());
		this.hashColumns.put("sr_amd_tp_nm", getSrAmdTpNm());
		this.hashColumns.put("sr_wrk_sts_dt", getSrWrkStsDt());
		this.hashColumns.put("bl_split_ttl_knt", getBlSplitTtlKnt());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("sr_amd_rsn_cd", getSrAmdRsnCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("img_pg_no", getImgPgNo());
		this.hashColumns.put("return_src", getReturnSrc());
		this.hashColumns.put("sr_amd_rsn_tp_cd", getSrAmdRsnTpCd());
		this.hashColumns.put("sr_urg_cd", getSrUrgCd());
		this.hashColumns.put("split", getSplit());
		this.hashColumns.put("img_file_nm", getImgFileNm());
		this.hashColumns.put("sr_mtch_sts_cd", getSrMtchStsCd());
		this.hashColumns.put("fax_log_ref_no", getFaxLogRefNo());
		this.hashColumns.put("fnt_ofc_eml", getFntOfcEml());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("split_flg", "splitFlg");
		this.hashFields.put("sr_urg_nm", "srUrgNm");
		this.hashFields.put("img_file_real_path", "imgFileRealPath");
		this.hashFields.put("sr_amd_seq", "srAmdSeq");
		this.hashFields.put("rtn_to_rtn_usr_id", "rtnToRtnUsrId");
		this.hashFields.put("return_cd", "returnCd");
		this.hashFields.put("rcv_ofc_cd", "rcvOfcCd");
		this.hashFields.put("img_file_path_ctnt", "imgFilePathCtnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rtn_to_usr_id", "rtnToUsrId");
		this.hashFields.put("sr_due_dt", "srDueDt");
		this.hashFields.put("sr_wrk_sts_usr_nm", "srWrkStsUsrNm");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("sr_knd_cd", "srKndCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sr_wrk_sts_cd", "srWrkStsCd");
		this.hashFields.put("sr_wrk_sts_usr_id", "srWrkStsUsrId");
		this.hashFields.put("return_to", "returnTo");
		this.hashFields.put("fnt_ofc_trns_dt", "fntOfcTrnsDt");
		this.hashFields.put("sr_amd_tp_cd", "srAmdTpCd");
		this.hashFields.put("bl_split_no", "blSplitNo");
		this.hashFields.put("sr_no", "srNo");
		this.hashFields.put("rtn_fm_usr_id", "rtnFmUsrId");
		this.hashFields.put("sr_amd_tp_nm", "srAmdTpNm");
		this.hashFields.put("sr_wrk_sts_dt", "srWrkStsDt");
		this.hashFields.put("bl_split_ttl_knt", "blSplitTtlKnt");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("sr_amd_rsn_cd", "srAmdRsnCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("img_pg_no", "imgPgNo");
		this.hashFields.put("return_src", "returnSrc");
		this.hashFields.put("sr_amd_rsn_tp_cd", "srAmdRsnTpCd");
		this.hashFields.put("sr_urg_cd", "srUrgCd");
		this.hashFields.put("split", "split");
		this.hashFields.put("img_file_nm", "imgFileNm");
		this.hashFields.put("sr_mtch_sts_cd", "srMtchStsCd");
		this.hashFields.put("fax_log_ref_no", "faxLogRefNo");
		this.hashFields.put("fnt_ofc_eml", "fntOfcEml");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return splitFlg
	 */
	public String getSplitFlg() {
		return this.splitFlg;
	}
	
	/**
	 * Column Info
	 * @return srUrgNm
	 */
	public String getSrUrgNm() {
		return this.srUrgNm;
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
	 * @return srAmdSeq
	 */
	public String getSrAmdSeq() {
		return this.srAmdSeq;
	}
	
	/**
	 * Column Info
	 * @return rtnToRtnUsrId
	 */
	public String getRtnToRtnUsrId() {
		return this.rtnToRtnUsrId;
	}
	
	/**
	 * Column Info
	 * @return returnCd
	 */
	public String getReturnCd() {
		return this.returnCd;
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
	 * @return rtnToUsrId
	 */
	public String getRtnToUsrId() {
		return this.rtnToUsrId;
	}
	
	/**
	 * Column Info
	 * @return srDueDt
	 */
	public String getSrDueDt() {
		return this.srDueDt;
	}
	
	/**
	 * Column Info
	 * @return srWrkStsUsrNm
	 */
	public String getSrWrkStsUsrNm() {
		return this.srWrkStsUsrNm;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return srWrkStsCd
	 */
	public String getSrWrkStsCd() {
		return this.srWrkStsCd;
	}
	
	/**
	 * Column Info
	 * @return srWrkStsUsrId
	 */
	public String getSrWrkStsUsrId() {
		return this.srWrkStsUsrId;
	}
	
	/**
	 * Column Info
	 * @return returnTo
	 */
	public String getReturnTo() {
		return this.returnTo;
	}
	
	/**
	 * Column Info
	 * @return fntOfcTrnsDt
	 */
	public String getFntOfcTrnsDt() {
		return this.fntOfcTrnsDt;
	}
	
	/**
	 * Column Info
	 * @return srAmdTpCd
	 */
	public String getSrAmdTpCd() {
		return this.srAmdTpCd;
	}
	
	/**
	 * Column Info
	 * @return blSplitNo
	 */
	public String getBlSplitNo() {
		return this.blSplitNo;
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
	 * @return rtnFmUsrId
	 */
	public String getRtnFmUsrId() {
		return this.rtnFmUsrId;
	}
	
	/**
	 * Column Info
	 * @return srAmdTpNm
	 */
	public String getSrAmdTpNm() {
		return this.srAmdTpNm;
	}
	
	/**
	 * Column Info
	 * @return srWrkStsDt
	 */
	public String getSrWrkStsDt() {
		return this.srWrkStsDt;
	}
	
	/**
	 * Column Info
	 * @return blSplitTtlKnt
	 */
	public String getBlSplitTtlKnt() {
		return this.blSplitTtlKnt;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return srAmdRsnCd
	 */
	public String getSrAmdRsnCd() {
		return this.srAmdRsnCd;
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
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
	}
	
	/**
	 * Column Info
	 * @return imgPgNo
	 */
	public String getImgPgNo() {
		return this.imgPgNo;
	}
	
	/**
	 * Column Info
	 * @return returnSrc
	 */
	public String getReturnSrc() {
		return this.returnSrc;
	}
	
	/**
	 * Column Info
	 * @return srAmdRsnTpCd
	 */
	public String getSrAmdRsnTpCd() {
		return this.srAmdRsnTpCd;
	}
	
	/**
	 * Column Info
	 * @return srUrgCd
	 */
	public String getSrUrgCd() {
		return this.srUrgCd;
	}
	
	/**
	 * Column Info
	 * @return split
	 */
	public String getSplit() {
		return this.split;
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
	

	public String getFaxLogRefNo() {
		return faxLogRefNo;
	}

	public String getFntOfcEml() {
		return fntOfcEml;
	}

	public void setFntOfcEml(String fntOfcEml) {
		this.fntOfcEml = fntOfcEml;
	}

	public void setFaxLogRefNo(String faxLogRefNo) {
		this.faxLogRefNo = faxLogRefNo;
	}

	/**
	 * Column Info
	 * @param splitFlg
	 */
	public void setSplitFlg(String splitFlg) {
		this.splitFlg = splitFlg;
	}
	
	/**
	 * Column Info
	 * @param srUrgNm
	 */
	public void setSrUrgNm(String srUrgNm) {
		this.srUrgNm = srUrgNm;
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
	 * @param srAmdSeq
	 */
	public void setSrAmdSeq(String srAmdSeq) {
		this.srAmdSeq = srAmdSeq;
	}
	
	/**
	 * Column Info
	 * @param rtnToRtnUsrId
	 */
	public void setRtnToRtnUsrId(String rtnToRtnUsrId) {
		this.rtnToRtnUsrId = rtnToRtnUsrId;
	}
	
	/**
	 * Column Info
	 * @param returnCd
	 */
	public void setReturnCd(String returnCd) {
		this.returnCd = returnCd;
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
	 * @param rtnToUsrId
	 */
	public void setRtnToUsrId(String rtnToUsrId) {
		this.rtnToUsrId = rtnToUsrId;
	}
	
	/**
	 * Column Info
	 * @param srDueDt
	 */
	public void setSrDueDt(String srDueDt) {
		this.srDueDt = srDueDt;
	}
	
	/**
	 * Column Info
	 * @param srWrkStsUsrNm
	 */
	public void setSrWrkStsUsrNm(String srWrkStsUsrNm) {
		this.srWrkStsUsrNm = srWrkStsUsrNm;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param srWrkStsCd
	 */
	public void setSrWrkStsCd(String srWrkStsCd) {
		this.srWrkStsCd = srWrkStsCd;
	}
	
	/**
	 * Column Info
	 * @param srWrkStsUsrId
	 */
	public void setSrWrkStsUsrId(String srWrkStsUsrId) {
		this.srWrkStsUsrId = srWrkStsUsrId;
	}
	
	/**
	 * Column Info
	 * @param returnTo
	 */
	public void setReturnTo(String returnTo) {
		this.returnTo = returnTo;
	}
	
	/**
	 * Column Info
	 * @param fntOfcTrnsDt
	 */
	public void setFntOfcTrnsDt(String fntOfcTrnsDt) {
		this.fntOfcTrnsDt = fntOfcTrnsDt;
	}
	
	/**
	 * Column Info
	 * @param srAmdTpCd
	 */
	public void setSrAmdTpCd(String srAmdTpCd) {
		this.srAmdTpCd = srAmdTpCd;
	}
	
	/**
	 * Column Info
	 * @param blSplitNo
	 */
	public void setBlSplitNo(String blSplitNo) {
		this.blSplitNo = blSplitNo;
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
	 * @param rtnFmUsrId
	 */
	public void setRtnFmUsrId(String rtnFmUsrId) {
		this.rtnFmUsrId = rtnFmUsrId;
	}
	
	/**
	 * Column Info
	 * @param srAmdTpNm
	 */
	public void setSrAmdTpNm(String srAmdTpNm) {
		this.srAmdTpNm = srAmdTpNm;
	}
	
	/**
	 * Column Info
	 * @param srWrkStsDt
	 */
	public void setSrWrkStsDt(String srWrkStsDt) {
		this.srWrkStsDt = srWrkStsDt;
	}
	
	/**
	 * Column Info
	 * @param blSplitTtlKnt
	 */
	public void setBlSplitTtlKnt(String blSplitTtlKnt) {
		this.blSplitTtlKnt = blSplitTtlKnt;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param srAmdRsnCd
	 */
	public void setSrAmdRsnCd(String srAmdRsnCd) {
		this.srAmdRsnCd = srAmdRsnCd;
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
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
	}
	
	/**
	 * Column Info
	 * @param imgPgNo
	 */
	public void setImgPgNo(String imgPgNo) {
		this.imgPgNo = imgPgNo;
	}
	
	/**
	 * Column Info
	 * @param returnSrc
	 */
	public void setReturnSrc(String returnSrc) {
		this.returnSrc = returnSrc;
	}
	
	/**
	 * Column Info
	 * @param srAmdRsnTpCd
	 */
	public void setSrAmdRsnTpCd(String srAmdRsnTpCd) {
		this.srAmdRsnTpCd = srAmdRsnTpCd;
	}
	
	/**
	 * Column Info
	 * @param srUrgCd
	 */
	public void setSrUrgCd(String srUrgCd) {
		this.srUrgCd = srUrgCd;
	}
	
	/**
	 * Column Info
	 * @param split
	 */
	public void setSplit(String split) {
		this.split = split;
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
		setSplitFlg(JSPUtil.getParameter(request, prefix + "split_flg", ""));
		setSrUrgNm(JSPUtil.getParameter(request, prefix + "sr_urg_nm", ""));
		setImgFileRealPath(JSPUtil.getParameter(request, prefix + "img_file_real_path", ""));
		setSrAmdSeq(JSPUtil.getParameter(request, prefix + "sr_amd_seq", ""));
		setRtnToRtnUsrId(JSPUtil.getParameter(request, prefix + "rtn_to_rtn_usr_id", ""));
		setReturnCd(JSPUtil.getParameter(request, prefix + "return_cd", ""));
		setRcvOfcCd(JSPUtil.getParameter(request, prefix + "rcv_ofc_cd", ""));
		setImgFilePathCtnt(JSPUtil.getParameter(request, prefix + "img_file_path_ctnt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRtnToUsrId(JSPUtil.getParameter(request, prefix + "rtn_to_usr_id", ""));
		setSrDueDt(JSPUtil.getParameter(request, prefix + "sr_due_dt", ""));
		setSrWrkStsUsrNm(JSPUtil.getParameter(request, prefix + "sr_wrk_sts_usr_nm", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setSrKndCd(JSPUtil.getParameter(request, prefix + "sr_knd_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSrWrkStsCd(JSPUtil.getParameter(request, prefix + "sr_wrk_sts_cd", ""));
		setSrWrkStsUsrId(JSPUtil.getParameter(request, prefix + "sr_wrk_sts_usr_id", ""));
		setReturnTo(JSPUtil.getParameter(request, prefix + "return_to", ""));
		setFntOfcTrnsDt(JSPUtil.getParameter(request, prefix + "fnt_ofc_trns_dt", ""));
		setSrAmdTpCd(JSPUtil.getParameter(request, prefix + "sr_amd_tp_cd", ""));
		setBlSplitNo(JSPUtil.getParameter(request, prefix + "bl_split_no", ""));
		setSrNo(JSPUtil.getParameter(request, prefix + "sr_no", ""));
		setRtnFmUsrId(JSPUtil.getParameter(request, prefix + "rtn_fm_usr_id", ""));
		setSrAmdTpNm(JSPUtil.getParameter(request, prefix + "sr_amd_tp_nm", ""));
		setSrWrkStsDt(JSPUtil.getParameter(request, prefix + "sr_wrk_sts_dt", ""));
		setBlSplitTtlKnt(JSPUtil.getParameter(request, prefix + "bl_split_ttl_knt", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setSrAmdRsnCd(JSPUtil.getParameter(request, prefix + "sr_amd_rsn_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setDiffRmk(JSPUtil.getParameter(request, prefix + "diff_rmk", ""));
		setImgPgNo(JSPUtil.getParameter(request, prefix + "img_pg_no", ""));
		setReturnSrc(JSPUtil.getParameter(request, prefix + "return_src", ""));
		setSrAmdRsnTpCd(JSPUtil.getParameter(request, prefix + "sr_amd_rsn_tp_cd", ""));
		setSrUrgCd(JSPUtil.getParameter(request, prefix + "sr_urg_cd", ""));
		setSplit(JSPUtil.getParameter(request, prefix + "split", ""));
		setImgFileNm(JSPUtil.getParameter(request, prefix + "img_file_nm", ""));
		setSrMtchStsCd(JSPUtil.getParameter(request, prefix + "sr_mtch_sts_cd", ""));
		setFaxLogRefNo(JSPUtil.getParameter(request, prefix + "fax_log_ref_no", ""));
		setFntOfcEml(JSPUtil.getParameter(request, prefix + "fnt_ofc_eml", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DpcsAmendReasonBkgListVO[]
	 */
	public DpcsAmendReasonBkgListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DpcsAmendReasonBkgListVO[]
	 */
	public DpcsAmendReasonBkgListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DpcsAmendReasonBkgListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] splitFlg = (JSPUtil.getParameter(request, prefix	+ "split_flg", length));
			String[] srUrgNm = (JSPUtil.getParameter(request, prefix	+ "sr_urg_nm", length));
			String[] imgFileRealPath = (JSPUtil.getParameter(request, prefix	+ "img_file_real_path", length));
			String[] srAmdSeq = (JSPUtil.getParameter(request, prefix	+ "sr_amd_seq", length));
			String[] rtnToRtnUsrId = (JSPUtil.getParameter(request, prefix	+ "rtn_to_rtn_usr_id", length));
			String[] returnCd = (JSPUtil.getParameter(request, prefix	+ "return_cd", length));
			String[] rcvOfcCd = (JSPUtil.getParameter(request, prefix	+ "rcv_ofc_cd", length));
			String[] imgFilePathCtnt = (JSPUtil.getParameter(request, prefix	+ "img_file_path_ctnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rtnToUsrId = (JSPUtil.getParameter(request, prefix	+ "rtn_to_usr_id", length));
			String[] srDueDt = (JSPUtil.getParameter(request, prefix	+ "sr_due_dt", length));
			String[] srWrkStsUsrNm = (JSPUtil.getParameter(request, prefix	+ "sr_wrk_sts_usr_nm", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] srKndCd = (JSPUtil.getParameter(request, prefix	+ "sr_knd_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] srWrkStsCd = (JSPUtil.getParameter(request, prefix	+ "sr_wrk_sts_cd", length));
			String[] srWrkStsUsrId = (JSPUtil.getParameter(request, prefix	+ "sr_wrk_sts_usr_id", length));
			String[] returnTo = (JSPUtil.getParameter(request, prefix	+ "return_to", length));
			String[] fntOfcTrnsDt = (JSPUtil.getParameter(request, prefix	+ "fnt_ofc_trns_dt", length));
			String[] srAmdTpCd = (JSPUtil.getParameter(request, prefix	+ "sr_amd_tp_cd", length));
			String[] blSplitNo = (JSPUtil.getParameter(request, prefix	+ "bl_split_no", length));
			String[] srNo = (JSPUtil.getParameter(request, prefix	+ "sr_no", length));
			String[] rtnFmUsrId = (JSPUtil.getParameter(request, prefix	+ "rtn_fm_usr_id", length));
			String[] srAmdTpNm = (JSPUtil.getParameter(request, prefix	+ "sr_amd_tp_nm", length));
			String[] srWrkStsDt = (JSPUtil.getParameter(request, prefix	+ "sr_wrk_sts_dt", length));
			String[] blSplitTtlKnt = (JSPUtil.getParameter(request, prefix	+ "bl_split_ttl_knt", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] srAmdRsnCd = (JSPUtil.getParameter(request, prefix	+ "sr_amd_rsn_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] imgPgNo = (JSPUtil.getParameter(request, prefix	+ "img_pg_no", length));
			String[] returnSrc = (JSPUtil.getParameter(request, prefix	+ "return_src", length));
			String[] srAmdRsnTpCd = (JSPUtil.getParameter(request, prefix	+ "sr_amd_rsn_tp_cd", length));
			String[] srUrgCd = (JSPUtil.getParameter(request, prefix	+ "sr_urg_cd", length));
			String[] split = (JSPUtil.getParameter(request, prefix	+ "split", length));
			String[] imgFileNm = (JSPUtil.getParameter(request, prefix	+ "img_file_nm", length));
			String[] srMtchStsCd = (JSPUtil.getParameter(request, prefix	+ "sr_mtch_sts_cd", length));
			String[] faxLogRefNo = (JSPUtil.getParameter(request, prefix	+ "fax_log_ref_no", length));
			String[] fntOfcEml = (JSPUtil.getParameter(request, prefix	+ "fnt_ofc_eml", length));
			
			for (int i = 0; i < length; i++) {
				model = new DpcsAmendReasonBkgListVO();
				if (splitFlg[i] != null)
					model.setSplitFlg(splitFlg[i]);
				if (srUrgNm[i] != null)
					model.setSrUrgNm(srUrgNm[i]);
				if (imgFileRealPath[i] != null)
					model.setImgFileRealPath(imgFileRealPath[i]);
				if (srAmdSeq[i] != null)
					model.setSrAmdSeq(srAmdSeq[i]);
				if (rtnToRtnUsrId[i] != null)
					model.setRtnToRtnUsrId(rtnToRtnUsrId[i]);
				if (returnCd[i] != null)
					model.setReturnCd(returnCd[i]);
				if (rcvOfcCd[i] != null)
					model.setRcvOfcCd(rcvOfcCd[i]);
				if (imgFilePathCtnt[i] != null)
					model.setImgFilePathCtnt(imgFilePathCtnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rtnToUsrId[i] != null)
					model.setRtnToUsrId(rtnToUsrId[i]);
				if (srDueDt[i] != null)
					model.setSrDueDt(srDueDt[i]);
				if (srWrkStsUsrNm[i] != null)
					model.setSrWrkStsUsrNm(srWrkStsUsrNm[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (srKndCd[i] != null)
					model.setSrKndCd(srKndCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (srWrkStsCd[i] != null)
					model.setSrWrkStsCd(srWrkStsCd[i]);
				if (srWrkStsUsrId[i] != null)
					model.setSrWrkStsUsrId(srWrkStsUsrId[i]);
				if (returnTo[i] != null)
					model.setReturnTo(returnTo[i]);
				if (fntOfcTrnsDt[i] != null)
					model.setFntOfcTrnsDt(fntOfcTrnsDt[i]);
				if (srAmdTpCd[i] != null)
					model.setSrAmdTpCd(srAmdTpCd[i]);
				if (blSplitNo[i] != null)
					model.setBlSplitNo(blSplitNo[i]);
				if (srNo[i] != null)
					model.setSrNo(srNo[i]);
				if (rtnFmUsrId[i] != null)
					model.setRtnFmUsrId(rtnFmUsrId[i]);
				if (srAmdTpNm[i] != null)
					model.setSrAmdTpNm(srAmdTpNm[i]);
				if (srWrkStsDt[i] != null)
					model.setSrWrkStsDt(srWrkStsDt[i]);
				if (blSplitTtlKnt[i] != null)
					model.setBlSplitTtlKnt(blSplitTtlKnt[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (srAmdRsnCd[i] != null)
					model.setSrAmdRsnCd(srAmdRsnCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (imgPgNo[i] != null)
					model.setImgPgNo(imgPgNo[i]);
				if (returnSrc[i] != null)
					model.setReturnSrc(returnSrc[i]);
				if (srAmdRsnTpCd[i] != null)
					model.setSrAmdRsnTpCd(srAmdRsnTpCd[i]);
				if (srUrgCd[i] != null)
					model.setSrUrgCd(srUrgCd[i]);
				if (split[i] != null)
					model.setSplit(split[i]);
				if (imgFileNm[i] != null)
					model.setImgFileNm(imgFileNm[i]);
				if (srMtchStsCd[i] != null)
					model.setSrMtchStsCd(srMtchStsCd[i]);
				if (faxLogRefNo[i] != null)
					model.setFaxLogRefNo(faxLogRefNo[i]);		
				if (fntOfcEml[i] != null)
					model.setFntOfcEml(fntOfcEml[i]);					
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDpcsAmendReasonBkgListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DpcsAmendReasonBkgListVO[]
	 */
	public DpcsAmendReasonBkgListVO[] getDpcsAmendReasonBkgListVOs(){
		DpcsAmendReasonBkgListVO[] vos = (DpcsAmendReasonBkgListVO[])models.toArray(new DpcsAmendReasonBkgListVO[models.size()]);
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
		this.splitFlg = this.splitFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srUrgNm = this.srUrgNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imgFileRealPath = this.imgFileRealPath .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srAmdSeq = this.srAmdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnToRtnUsrId = this.rtnToRtnUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.returnCd = this.returnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvOfcCd = this.rcvOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imgFilePathCtnt = this.imgFilePathCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnToUsrId = this.rtnToUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srDueDt = this.srDueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srWrkStsUsrNm = this.srWrkStsUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srKndCd = this.srKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srWrkStsCd = this.srWrkStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srWrkStsUsrId = this.srWrkStsUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.returnTo = this.returnTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fntOfcTrnsDt = this.fntOfcTrnsDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srAmdTpCd = this.srAmdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSplitNo = this.blSplitNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srNo = this.srNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnFmUsrId = this.rtnFmUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srAmdTpNm = this.srAmdTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srWrkStsDt = this.srWrkStsDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSplitTtlKnt = this.blSplitTtlKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srAmdRsnCd = this.srAmdRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imgPgNo = this.imgPgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.returnSrc = this.returnSrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srAmdRsnTpCd = this.srAmdRsnTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srUrgCd = this.srUrgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.split = this.split .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imgFileNm = this.imgFileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srMtchStsCd = this.srMtchStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxLogRefNo = this.faxLogRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fntOfcEml = this.fntOfcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
