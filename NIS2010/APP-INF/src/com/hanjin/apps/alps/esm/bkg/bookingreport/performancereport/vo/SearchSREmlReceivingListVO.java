/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SearchSREmlReceivingListVO.java
*@FileTitle : SearchSREmlReceivingListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.27
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2011.04.27 김기종 
* 1.0 Creation
* 2011.10.04 정선용 [CHM-201112445] SI Automation System 구축
* 2011.11.25 금병주 [CHM-201114704-01] SI 자동화 컬럼 추가분 ALPS에 표시요청
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

public class SearchSREmlReceivingListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSREmlReceivingListVO> models = new ArrayList<SearchSREmlReceivingListVO>();
	
	/* Column Info */
	private String isEmlRcvFailFlg = null;
	/* Column Info */
	private String sndrFaxNoCtnt = null;
	/* Column Info */
	private String rtnGdt = null;
	/* Column Info */
	private String srFaxRsltCd = null;
	/* Column Info */
	private String emlOrgSubjCtnt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String srRtnToStsCd = null;
	/* Column Info */
	private String rtnToUsrId = null;
	/* Column Info */
	private String srCrntStsNm = null;
	/* Column Info */
	private String rcvDt = null;
	/* Column Info */
	private String srTrnsUsrNm = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String rtnFmUsrId = null;
	/* Column Info */
	private String rcvNm = null;
	/* Column Info */
	private String rtnFmStsCd = null;
	/* Column Info */
	private String imgFileIp = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String emlOriginSubjCtnt = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String rtnDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String ttlPgKnt = null;
	/* Column Info */
	private String atchFileKnt = null;
	/* Column Info */
	private String imgFileNm = null;
	/* Column Info */
	private String mtchUsrNm = null;
	/* Column Info */
	private String srCrntStsCd = null;
	/* Column Info */
	private String fromDt = null;
	/* Column Info */
	private String srFaxRsltNm = null;
	/* Column Info */
	private String ofcIncSub = null;
	/* Column Info */
	private String orgBkgNo = null;
	/* Column Info */
	private String rcvGdt = null;
	/* Column Info */
	private String rtnToRtnUsrId = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String atchFilePathCtnt = null;
	/* Column Info */
	private String wrkTmNo = null;
	/* Column Info */
	private String rcvOfcCd = null;
	/* Column Info */
	private String mtchUsrId = null;
	/* Column Info */
	private String imgFilePathCtnt = null;
	/* Column Info */
	private String srKndCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String faxLogRefNo = null;
	/* Column Info */
	private String rtnToRtnGdt = null;
	/* Column Info */
	private String srAmdTpCd = null;
	/* Column Info */
	private String bkgNoMtchStsNm = null;
	/* Column Info */
	private String srAmdKndCd = null;
	/* Column Info */
	private String srNo = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String rcvRmk = null;
	/* Column Info */
	private String rtnToRtnStsCd = null;
	/* Column Info */
	private String srTrnsUsrId = null;
	/* Column Info */
	private String chkEmlRcvFailFlg = null;
	/* Column Info */
	private String bkgNoMtchStsCd = null;
	/* Column Info */
	private String fntOfcEml = null;
	/* Column Info */
	private String srUrgCd = null;
	/* Column Info */
	private String rtnToRtnDt = null;
	/* Column Info */
	private String emlSubjCtnt = null;
	/* Column Info */
	private String srMtchStsCd = null;
	/* Column Info */
	private String srTrnsDt = null;
	/* Column Info */
	private String srMtchStsNm = null;

	/* Column Info 조회 조건 추가 */
	private String srBkgStsCd = null;
	/* Column Info 조회 조건 추가 */
	private String srIfStatusCd = null;
	/* Column Info 조회 조건 추가 */
	private String srUrgencyCd = null;
	
	/* Column Info 조회 조건 추가 */
	private String srKndComboCd  = null;
	/* Column Info 조회 조건 추가 */
	private String splitBkgYn  = null;
	/* Column Info grid 추가 */
	private String blSplitNo   = null;
	/* Column Info grid 추가 */
	private String blSplitTtlKnt    = null;	
	/* Column Info grid 추가 */
	private String splitStsCd    = null;
	/* Column Info grid 추가 */
	private String maxSeq    = null;
	/* Column Info grid 추가 */
	private String srAmdSeq    = null;
	/* Column Info grid 추가 */
	private String xterSndrId    = null;
	/* Column Info grid 추가 */
	private String oldBkgNo    = null;
	/* Column Info grid 추가 */
	private String oldSrAmdTpCd    = null;
	/* Column Info grid 추가 */
	private String oldSrUrgCd    = null;
	/* Column Info grid 추가 */
	private String oldSplitStsCd    = null;
	/* Column Info grid 추가 */
	private String oldBlSplitNo    = null;
	/* Column Info grid 추가 */
	private String oldBlSplitTtlKnt    = null;
	/* Column Info grid 추가 */
	private String gmtRcvDt    = null;
	/* Column Info grid 추가 */
	
	private String solAplyPhsNo    = null;
	/* Column Info grid 추가 */
	private String siRqstCngBseCd    = null;
	/* Column Info grid 추가 */
	private String siDocReadScsFlg    = null;
	
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSREmlReceivingListVO() {}

	public SearchSREmlReceivingListVO(String ibflag, String pagerows, String bkgNo, String orgBkgNo, String bkgNoMtchStsCd, String bkgNoMtchStsNm, String srAmdTpCd, String srAmdKndCd, String fntOfcEml, String srUrgCd, String emlSubjCtnt, String srNo, String faxLogRefNo, String srKndCd, String sndrFaxNoCtnt, String rcvDt, String rcvGdt, String rcvOfcCd, String rcvNm, String rcvRmk, String srTrnsUsrId, String srTrnsUsrNm, String srTrnsDt, String imgFileIp, String imgFilePathCtnt, String imgFileNm, String ttlPgKnt, String srFaxRsltCd, String srFaxRsltNm, String srMtchStsCd, String srMtchStsNm, String mtchUsrId, String mtchUsrNm, String wrkTmNo, String rtnFmStsCd, String rtnFmUsrId, String rtnDt, String rtnGdt, String srRtnToStsCd, String rtnToUsrId, String rtnToRtnDt, String rtnToRtnGdt, String rtnToRtnStsCd, String rtnToRtnUsrId, String creUsrId, String creDt, String updUsrId, String updDt, String emlOrgSubjCtnt, String fromDt, String toDt, String isEmlRcvFailFlg, String chkEmlRcvFailFlg, String emlOriginSubjCtnt, String ofcIncSub, String atchFileKnt, String atchFilePathCtnt, String srCrntStsCd, String srCrntStsNm, String srBkgStsCd, String srIfStatusCd , String srUrgencyCd, String srKndComboCd, String splitBkgYn, String blSplitNo, String blSplitTtlKnt,String splitStsCd, String maxSeq, String srAmdSeq,String xterSndrId,String oldBkgNo,String oldSrAmdTpCd,String oldSrUrgCd, String oldSplitStsCd,String oldBlSplitNo, String oldBlSplitTtlKnt, String gmtRcvDt,String solAplyPhsNo ,String siRqstCngBseCd , String siDocReadScsFlg) {
		this.isEmlRcvFailFlg = isEmlRcvFailFlg;
		this.sndrFaxNoCtnt = sndrFaxNoCtnt;
		this.rtnGdt = rtnGdt;
		this.srFaxRsltCd = srFaxRsltCd;
		this.emlOrgSubjCtnt = emlOrgSubjCtnt;
		this.pagerows = pagerows;
		this.srRtnToStsCd = srRtnToStsCd;
		this.rtnToUsrId = rtnToUsrId;
		this.srCrntStsNm = srCrntStsNm;
		this.rcvDt = rcvDt;
		this.srTrnsUsrNm = srTrnsUsrNm;
		this.updUsrId = updUsrId;
		this.rtnFmUsrId = rtnFmUsrId;
		this.rcvNm = rcvNm;
		this.rtnFmStsCd = rtnFmStsCd;
		this.imgFileIp = imgFileIp;
		this.toDt = toDt;
		this.emlOriginSubjCtnt = emlOriginSubjCtnt;
		this.bkgNo = bkgNo;
		this.rtnDt = rtnDt;
		this.creUsrId = creUsrId;
		this.ttlPgKnt = ttlPgKnt;
		this.atchFileKnt = atchFileKnt;
		this.imgFileNm = imgFileNm;
		this.mtchUsrNm = mtchUsrNm;
		this.srCrntStsCd = srCrntStsCd;
		this.fromDt = fromDt;
		this.srFaxRsltNm = srFaxRsltNm;
		this.ofcIncSub = ofcIncSub;
		this.orgBkgNo = orgBkgNo;
		this.rcvGdt = rcvGdt;
		this.rtnToRtnUsrId = rtnToRtnUsrId;
		this.creDt = creDt;
		this.atchFilePathCtnt = atchFilePathCtnt;
		this.wrkTmNo = wrkTmNo;
		this.rcvOfcCd = rcvOfcCd;
		this.mtchUsrId = mtchUsrId;
		this.imgFilePathCtnt = imgFilePathCtnt;
		this.srKndCd = srKndCd;
		this.ibflag = ibflag;
		this.faxLogRefNo = faxLogRefNo;
		this.rtnToRtnGdt = rtnToRtnGdt;
		this.srAmdTpCd = srAmdTpCd;
		this.bkgNoMtchStsNm = bkgNoMtchStsNm;
		this.srAmdKndCd = srAmdKndCd;
		this.srNo = srNo;
		this.updDt = updDt;
		this.rcvRmk = rcvRmk;
		this.rtnToRtnStsCd = rtnToRtnStsCd;
		this.srTrnsUsrId = srTrnsUsrId;
		this.chkEmlRcvFailFlg = chkEmlRcvFailFlg;
		this.bkgNoMtchStsCd = bkgNoMtchStsCd;
		this.fntOfcEml = fntOfcEml;
		this.srUrgCd = srUrgCd;
		this.rtnToRtnDt = rtnToRtnDt;
		this.emlSubjCtnt = emlSubjCtnt;
		this.srMtchStsCd = srMtchStsCd;
		this.srTrnsDt = srTrnsDt;
		this.srMtchStsNm = srMtchStsNm;
		
		this.srBkgStsCd  = srBkgStsCd ;
		this.srIfStatusCd  = srIfStatusCd ;
		this.srUrgencyCd  = srUrgencyCd ;
		
		this.srKndComboCd   = srKndComboCd ;
		this.splitBkgYn   = splitBkgYn ;
		this.blSplitNo   = blSplitNo ;
		this.blSplitTtlKnt   = blSplitTtlKnt ;
		this.splitStsCd   = splitStsCd ;
		this.maxSeq   = maxSeq ;
		this.srAmdSeq   = srAmdSeq ;
		this.xterSndrId   = xterSndrId ;
		
		this.oldBkgNo    = oldBkgNo  ;
		this.oldSrAmdTpCd    = oldSrAmdTpCd  ;
		this.oldSrUrgCd    = oldSrUrgCd  ;
		this.oldSplitStsCd    = oldSplitStsCd  ;
		this.oldBlSplitNo    = oldBlSplitNo  ;
		this.oldBlSplitTtlKnt    = oldBlSplitTtlKnt  ;
		this.gmtRcvDt    = gmtRcvDt  ;
		
		this.solAplyPhsNo = solAplyPhsNo;
		this.siRqstCngBseCd = siRqstCngBseCd;
		this.siDocReadScsFlg = siDocReadScsFlg;
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("is_eml_rcv_fail_flg", getIsEmlRcvFailFlg());
		this.hashColumns.put("sndr_fax_no_ctnt", getSndrFaxNoCtnt());
		this.hashColumns.put("rtn_gdt", getRtnGdt());
		this.hashColumns.put("sr_fax_rslt_cd", getSrFaxRsltCd());
		this.hashColumns.put("eml_org_subj_ctnt", getEmlOrgSubjCtnt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sr_rtn_to_sts_cd", getSrRtnToStsCd());
		this.hashColumns.put("rtn_to_usr_id", getRtnToUsrId());
		this.hashColumns.put("sr_crnt_sts_nm", getSrCrntStsNm());
		this.hashColumns.put("rcv_dt", getRcvDt());
		this.hashColumns.put("sr_trns_usr_nm", getSrTrnsUsrNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("rtn_fm_usr_id", getRtnFmUsrId());
		this.hashColumns.put("rcv_nm", getRcvNm());
		this.hashColumns.put("rtn_fm_sts_cd", getRtnFmStsCd());
		this.hashColumns.put("img_file_ip", getImgFileIp());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("eml_origin_subj_ctnt", getEmlOriginSubjCtnt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("rtn_dt", getRtnDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ttl_pg_knt", getTtlPgKnt());
		this.hashColumns.put("atch_file_knt", getAtchFileKnt());
		this.hashColumns.put("img_file_nm", getImgFileNm());
		this.hashColumns.put("mtch_usr_nm", getMtchUsrNm());
		this.hashColumns.put("sr_crnt_sts_cd", getSrCrntStsCd());
		this.hashColumns.put("from_dt", getFromDt());
		this.hashColumns.put("sr_fax_rslt_nm", getSrFaxRsltNm());
		this.hashColumns.put("ofc_inc_sub", getOfcIncSub());
		this.hashColumns.put("org_bkg_no", getOrgBkgNo());
		this.hashColumns.put("rcv_gdt", getRcvGdt());
		this.hashColumns.put("rtn_to_rtn_usr_id", getRtnToRtnUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("atch_file_path_ctnt", getAtchFilePathCtnt());
		this.hashColumns.put("wrk_tm_no", getWrkTmNo());
		this.hashColumns.put("rcv_ofc_cd", getRcvOfcCd());
		this.hashColumns.put("mtch_usr_id", getMtchUsrId());
		this.hashColumns.put("img_file_path_ctnt", getImgFilePathCtnt());
		this.hashColumns.put("sr_knd_cd", getSrKndCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fax_log_ref_no", getFaxLogRefNo());
		this.hashColumns.put("rtn_to_rtn_gdt", getRtnToRtnGdt());
		this.hashColumns.put("sr_amd_tp_cd", getSrAmdTpCd());
		this.hashColumns.put("bkg_no_mtch_sts_nm", getBkgNoMtchStsNm());
		this.hashColumns.put("sr_amd_knd_cd", getSrAmdKndCd());
		this.hashColumns.put("sr_no", getSrNo());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rcv_rmk", getRcvRmk());
		this.hashColumns.put("rtn_to_rtn_sts_cd", getRtnToRtnStsCd());
		this.hashColumns.put("sr_trns_usr_id", getSrTrnsUsrId());
		this.hashColumns.put("chk_eml_rcv_fail_flg", getChkEmlRcvFailFlg());
		this.hashColumns.put("bkg_no_mtch_sts_cd", getBkgNoMtchStsCd());
		this.hashColumns.put("fnt_ofc_eml", getFntOfcEml());
		this.hashColumns.put("sr_urg_cd", getSrUrgCd());
		this.hashColumns.put("rtn_to_rtn_dt", getRtnToRtnDt());
		this.hashColumns.put("eml_subj_ctnt", getEmlSubjCtnt());
		this.hashColumns.put("sr_mtch_sts_cd", getSrMtchStsCd());
		this.hashColumns.put("sr_trns_dt", getSrTrnsDt());
		this.hashColumns.put("sr_mtch_sts_nm", getSrMtchStsNm());
		
		this.hashColumns.put("sr_bkg_sts_cd", getSrBkgStsCd ());
		this.hashColumns.put("sr_if_status_cd", getSrIfStatusCd ());
		this.hashColumns.put("sr_urgency_cd", getSrUrgencyCd ());
		
		this.hashColumns.put("sr_knd_combo_cd", getSrKndComboCd  ());
		this.hashColumns.put("split_bkg_yn", getSplitBkgYn  ());
		this.hashColumns.put("bl_split_no", getBlSplitNo  ());
		this.hashColumns.put("bl_split_ttl_knt", getBlSplitTtlKnt  ());
		this.hashColumns.put("split_sts_cd", getSplitStsCd  ());
		this.hashColumns.put("max_seq", getMaxSeq  ());
		this.hashColumns.put("sr_amd_seq", getSrAmdSeq  ());
		this.hashColumns.put("xter_sndr_id", getXterSndrId  ());
		
		this.hashColumns.put("old_bkg_no", getOldBkgNo ());
		this.hashColumns.put("old_sr_amd_tp_cd", getOldSrAmdTpCd ());
		this.hashColumns.put("old_sr_urg_cd", getOldSrUrgCd ());
		this.hashColumns.put("old_split_sts_cd", getOldSplitStsCd ());
		this.hashColumns.put("old_bl_split_no", getOldBlSplitNo ());
		this.hashColumns.put("old_bl_split_ttl_knt", getOldBlSplitTtlKnt ());
		this.hashColumns.put("gmt_rcv_dt", getGmtRcvDt ());
		
		this.hashColumns.put("sol_aply_phs_no", getSolAplyPhsNo ());
		this.hashColumns.put("si_rqst_cng_bse_cd", getSiRqstCngBseCd ());
		this.hashColumns.put("si_doc_read_scs_flg", getSiDocReadScsFlg ());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("is_eml_rcv_fail_flg", "isEmlRcvFailFlg");
		this.hashFields.put("sndr_fax_no_ctnt", "sndrFaxNoCtnt");
		this.hashFields.put("rtn_gdt", "rtnGdt");
		this.hashFields.put("sr_fax_rslt_cd", "srFaxRsltCd");
		this.hashFields.put("eml_org_subj_ctnt", "emlOrgSubjCtnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sr_rtn_to_sts_cd", "srRtnToStsCd");
		this.hashFields.put("rtn_to_usr_id", "rtnToUsrId");
		this.hashFields.put("sr_crnt_sts_nm", "srCrntStsNm");
		this.hashFields.put("rcv_dt", "rcvDt");
		this.hashFields.put("sr_trns_usr_nm", "srTrnsUsrNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("rtn_fm_usr_id", "rtnFmUsrId");
		this.hashFields.put("rcv_nm", "rcvNm");
		this.hashFields.put("rtn_fm_sts_cd", "rtnFmStsCd");
		this.hashFields.put("img_file_ip", "imgFileIp");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("eml_origin_subj_ctnt", "emlOriginSubjCtnt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("rtn_dt", "rtnDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ttl_pg_knt", "ttlPgKnt");
		this.hashFields.put("atch_file_knt", "atchFileKnt");
		this.hashFields.put("img_file_nm", "imgFileNm");
		this.hashFields.put("mtch_usr_nm", "mtchUsrNm");
		this.hashFields.put("sr_crnt_sts_cd", "srCrntStsCd");
		this.hashFields.put("from_dt", "fromDt");
		this.hashFields.put("sr_fax_rslt_nm", "srFaxRsltNm");
		this.hashFields.put("ofc_inc_sub", "ofcIncSub");
		this.hashFields.put("org_bkg_no", "orgBkgNo");
		this.hashFields.put("rcv_gdt", "rcvGdt");
		this.hashFields.put("rtn_to_rtn_usr_id", "rtnToRtnUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("atch_file_path_ctnt", "atchFilePathCtnt");
		this.hashFields.put("wrk_tm_no", "wrkTmNo");
		this.hashFields.put("rcv_ofc_cd", "rcvOfcCd");
		this.hashFields.put("mtch_usr_id", "mtchUsrId");
		this.hashFields.put("img_file_path_ctnt", "imgFilePathCtnt");
		this.hashFields.put("sr_knd_cd", "srKndCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fax_log_ref_no", "faxLogRefNo");
		this.hashFields.put("rtn_to_rtn_gdt", "rtnToRtnGdt");
		this.hashFields.put("sr_amd_tp_cd", "srAmdTpCd");
		this.hashFields.put("bkg_no_mtch_sts_nm", "bkgNoMtchStsNm");
		this.hashFields.put("sr_amd_knd_cd", "srAmdKndCd");
		this.hashFields.put("sr_no", "srNo");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rcv_rmk", "rcvRmk");
		this.hashFields.put("rtn_to_rtn_sts_cd", "rtnToRtnStsCd");
		this.hashFields.put("sr_trns_usr_id", "srTrnsUsrId");
		this.hashFields.put("chk_eml_rcv_fail_flg", "chkEmlRcvFailFlg");
		this.hashFields.put("bkg_no_mtch_sts_cd", "bkgNoMtchStsCd");
		this.hashFields.put("fnt_ofc_eml", "fntOfcEml");
		this.hashFields.put("sr_urg_cd", "srUrgCd");
		this.hashFields.put("rtn_to_rtn_dt", "rtnToRtnDt");
		this.hashFields.put("eml_subj_ctnt", "emlSubjCtnt");
		this.hashFields.put("sr_mtch_sts_cd", "srMtchStsCd");
		this.hashFields.put("sr_trns_dt", "srTrnsDt");
		this.hashFields.put("sr_mtch_sts_nm", "srMtchStsNm");
		
		this.hashFields.put("sr_bkg_sts_cd", "srBkgStsCd");
		this.hashFields.put("sr_if_status_cd", "srIfStatusCd");
		this.hashFields.put("sr_urgency_cd", "srUrgencyCd");
		
		this.hashFields.put("sr_knd_combo_cd", "srSrKndComboCd");
		this.hashFields.put("split_bkg_yn", "splitBkgYn");
		this.hashFields.put("bl_split_no", "blSplitNo");
		this.hashFields.put("bl_split_ttl_knt", "blSplitTtlKnt");
		this.hashFields.put("split_sts_cd", "splitStsCd");
		this.hashFields.put("max_seq", "maxSeq");
		this.hashFields.put("sr_amd_seq", "srAmdSeq");
		this.hashFields.put("xter_sndr_id", "xterSndrId");
		
		this.hashFields.put("old_bkg_no", "oldBkgNo");
		this.hashFields.put("old_sr_amd_tp_cd", "oldSrAmdTpCd");
		this.hashFields.put("old_sr_urg_cd", "oldSrUrgCd");
		this.hashFields.put("old_split_sts_cd", "oldSplitStsCd");
		this.hashFields.put("old_bl_split_no", "oldBlSplitNo");
		this.hashFields.put("old_bl_split_ttl_knt", "oldBlSplitTtlKnt");
		this.hashFields.put("gmt_rcv_dt", "gmtRcvDt");
		
		this.hashFields.put("sol_aply_phs_no", "solAplyPhsNo");
		this.hashFields.put("si_rqst_cng_bse_cd", "siRqstCngBseCd");
		this.hashFields.put("si_doc_read_scs_flg", "siDocReadScsFlg");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return isEmlRcvFailFlg
	 */
	public String getIsEmlRcvFailFlg() {
		return this.isEmlRcvFailFlg;
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
	 * @return rtnGdt
	 */
	public String getRtnGdt() {
		return this.rtnGdt;
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
	 * @return emlOrgSubjCtnt
	 */
	public String getEmlOrgSubjCtnt() {
		return this.emlOrgSubjCtnt;
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
	 * @return srRtnToStsCd
	 */
	public String getSrRtnToStsCd() {
		return this.srRtnToStsCd;
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
	 * @return srCrntStsNm
	 */
	public String getSrCrntStsNm() {
		return this.srCrntStsNm;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @return rcvNm
	 */
	public String getRcvNm() {
		return this.rcvNm;
	}
	
	/**
	 * Column Info
	 * @return rtnFmStsCd
	 */
	public String getRtnFmStsCd() {
		return this.rtnFmStsCd;
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
	 * @return emlOriginSubjCtnt
	 */
	public String getEmlOriginSubjCtnt() {
		return this.emlOriginSubjCtnt;
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
	 * @return rtnDt
	 */
	public String getRtnDt() {
		return this.rtnDt;
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
	 * @return atchFileKnt
	 */
	public String getAtchFileKnt() {
		return this.atchFileKnt;
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
	 * @return mtchUsrNm
	 */
	public String getMtchUsrNm() {
		return this.mtchUsrNm;
	}
	
	/**
	 * Column Info
	 * @return srCrntStsCd
	 */
	public String getSrCrntStsCd() {
		return this.srCrntStsCd;
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
	 * @return srFaxRsltNm
	 */
	public String getSrFaxRsltNm() {
		return this.srFaxRsltNm;
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
	 * @return orgBkgNo
	 */
	public String getOrgBkgNo() {
		return this.orgBkgNo;
	}
	
	/**
	 * Column Info
	 * @return rcvGdt
	 */
	public String getRcvGdt() {
		return this.rcvGdt;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return atchFilePathCtnt
	 */
	public String getAtchFilePathCtnt() {
		return this.atchFilePathCtnt;
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
	 * @return faxLogRefNo
	 */
	public String getFaxLogRefNo() {
		return this.faxLogRefNo;
	}
	
	/**
	 * Column Info
	 * @return rtnToRtnGdt
	 */
	public String getRtnToRtnGdt() {
		return this.rtnToRtnGdt;
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
	 * @return bkgNoMtchStsNm
	 */
	public String getBkgNoMtchStsNm() {
		return this.bkgNoMtchStsNm;
	}
	
	/**
	 * Column Info
	 * @return srAmdKndCd
	 */
	public String getSrAmdKndCd() {
		return this.srAmdKndCd;
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
	 * @return rtnToRtnStsCd
	 */
	public String getRtnToRtnStsCd() {
		return this.rtnToRtnStsCd;
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
	 * @return chkEmlRcvFailFlg
	 */
	public String getChkEmlRcvFailFlg() {
		return this.chkEmlRcvFailFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgNoMtchStsCd
	 */
	public String getBkgNoMtchStsCd() {
		return this.bkgNoMtchStsCd;
	}
	
	/**
	 * Column Info
	 * @return fntOfcEml
	 */
	public String getFntOfcEml() {
		return this.fntOfcEml;
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
	 * @return rtnToRtnDt
	 */
	public String getRtnToRtnDt() {
		return this.rtnToRtnDt;
	}
	
	/**
	 * Column Info
	 * @return emlSubjCtnt
	 */
	public String getEmlSubjCtnt() {
		return this.emlSubjCtnt;
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
	

	public String getSrBkgStsCd() {
		return srBkgStsCd;
	}

	public void setSrBkgStsCd(String srBkgStsCd) {
		this.srBkgStsCd = srBkgStsCd;
	}

	public String getSrIfStatusCd() {
		return srIfStatusCd;
	}

	public void setSrIfStatusCd(String srIfStatusCd) {
		this.srIfStatusCd = srIfStatusCd;
	}

	public String getSrUrgencyCd() {
		return srUrgencyCd;
	}

	public String getSrKndComboCd() {
		return srKndComboCd;
	}

	public void setSrKndComboCd(String srKndComboCd) {
		this.srKndComboCd = srKndComboCd;
	}

	public String getSplitBkgYn() {
		return splitBkgYn;
	}

	public void setSplitBkgYn(String splitBkgYn) {
		this.splitBkgYn = splitBkgYn;
	}

	public String getBlSplitNo() {
		return blSplitNo;
	}

	public void setBlSplitNo(String blSplitNo) {
		this.blSplitNo = blSplitNo;
	}

	public String getBlSplitTtlKnt() {
		return blSplitTtlKnt;
	}

	public void setBlSplitTtlKnt(String blSplitTtlKnt) {
		this.blSplitTtlKnt = blSplitTtlKnt;
	}

	public String getSplitStsCd() {
		return splitStsCd;
	}

	public String getMaxSeq() {
		return maxSeq;
	}

	public String getSrAmdSeq() {
		return srAmdSeq;
	}

	public String getXterSndrId() {
		return xterSndrId;
	}

	public String getOldBkgNo() {
		return oldBkgNo;
	}

	public void setOldBkgNo(String oldBkgNo) {
		this.oldBkgNo = oldBkgNo;
	}

	public String getOldSrAmdTpCd() {
		return oldSrAmdTpCd;
	}

	public void setOldSrAmdTpCd(String oldSrAmdTpCd) {
		this.oldSrAmdTpCd = oldSrAmdTpCd;
	}

	public String getOldSrUrgCd() {
		return oldSrUrgCd;
	}

	public void setOldSrUrgCd(String oldSrUrgCd) {
		this.oldSrUrgCd = oldSrUrgCd;
	}

	public String getOldSplitStsCd() {
		return oldSplitStsCd;
	}

	public void setOldSplitStsCd(String oldSplitStsCd) {
		this.oldSplitStsCd = oldSplitStsCd;
	}

	public String getOldBlSplitNo() {
		return oldBlSplitNo;
	}

	public void setOldBlSplitNo(String oldBlSplitNo) {
		this.oldBlSplitNo = oldBlSplitNo;
	}

	public String getOldBlSplitTtlKnt() {
		return oldBlSplitTtlKnt;
	}

	public String getGmtRcvDt() {
		return gmtRcvDt;
	}

	public void setGmtRcvDt(String gmtRcvDt) {
		this.gmtRcvDt = gmtRcvDt;
	}

	public void setOldBlSplitTtlKnt(String oldBlSplitTtlKnt) {
		this.oldBlSplitTtlKnt = oldBlSplitTtlKnt;
	}

	public void setXterSndrId(String xterSndrId) {
		this.xterSndrId = xterSndrId;
	}

	public void setSrAmdSeq(String srAmdSeq) {
		this.srAmdSeq = srAmdSeq;
	}

	public void setMaxSeq(String maxSeq) {
		this.maxSeq = maxSeq;
	}

	public void setSplitStsCd(String splitStsCd) {
		this.splitStsCd = splitStsCd;
	}

	public void setSrUrgencyCd(String srUrgencyCd) {
		this.srUrgencyCd = srUrgencyCd;
	}

	/**
	 * Column Info
	 * @param isEmlRcvFailFlg
	 */
	public void setIsEmlRcvFailFlg(String isEmlRcvFailFlg) {
		this.isEmlRcvFailFlg = isEmlRcvFailFlg;
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
	 * @param rtnGdt
	 */
	public void setRtnGdt(String rtnGdt) {
		this.rtnGdt = rtnGdt;
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
	 * @param emlOrgSubjCtnt
	 */
	public void setEmlOrgSubjCtnt(String emlOrgSubjCtnt) {
		this.emlOrgSubjCtnt = emlOrgSubjCtnt;
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
	 * @param srRtnToStsCd
	 */
	public void setSrRtnToStsCd(String srRtnToStsCd) {
		this.srRtnToStsCd = srRtnToStsCd;
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
	 * @param srCrntStsNm
	 */
	public void setSrCrntStsNm(String srCrntStsNm) {
		this.srCrntStsNm = srCrntStsNm;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
	 * @param rcvNm
	 */
	public void setRcvNm(String rcvNm) {
		this.rcvNm = rcvNm;
	}
	
	/**
	 * Column Info
	 * @param rtnFmStsCd
	 */
	public void setRtnFmStsCd(String rtnFmStsCd) {
		this.rtnFmStsCd = rtnFmStsCd;
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
	 * @param emlOriginSubjCtnt
	 */
	public void setEmlOriginSubjCtnt(String emlOriginSubjCtnt) {
		this.emlOriginSubjCtnt = emlOriginSubjCtnt;
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
	 * @param rtnDt
	 */
	public void setRtnDt(String rtnDt) {
		this.rtnDt = rtnDt;
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
	 * @param atchFileKnt
	 */
	public void setAtchFileKnt(String atchFileKnt) {
		this.atchFileKnt = atchFileKnt;
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
	 * @param mtchUsrNm
	 */
	public void setMtchUsrNm(String mtchUsrNm) {
		this.mtchUsrNm = mtchUsrNm;
	}
	
	/**
	 * Column Info
	 * @param srCrntStsCd
	 */
	public void setSrCrntStsCd(String srCrntStsCd) {
		this.srCrntStsCd = srCrntStsCd;
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
	 * @param srFaxRsltNm
	 */
	public void setSrFaxRsltNm(String srFaxRsltNm) {
		this.srFaxRsltNm = srFaxRsltNm;
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
	 * @param orgBkgNo
	 */
	public void setOrgBkgNo(String orgBkgNo) {
		this.orgBkgNo = orgBkgNo;
	}
	
	/**
	 * Column Info
	 * @param rcvGdt
	 */
	public void setRcvGdt(String rcvGdt) {
		this.rcvGdt = rcvGdt;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param atchFilePathCtnt
	 */
	public void setAtchFilePathCtnt(String atchFilePathCtnt) {
		this.atchFilePathCtnt = atchFilePathCtnt;
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
	 * @param faxLogRefNo
	 */
	public void setFaxLogRefNo(String faxLogRefNo) {
		this.faxLogRefNo = faxLogRefNo;
	}
	
	/**
	 * Column Info
	 * @param rtnToRtnGdt
	 */
	public void setRtnToRtnGdt(String rtnToRtnGdt) {
		this.rtnToRtnGdt = rtnToRtnGdt;
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
	 * @param bkgNoMtchStsNm
	 */
	public void setBkgNoMtchStsNm(String bkgNoMtchStsNm) {
		this.bkgNoMtchStsNm = bkgNoMtchStsNm;
	}
	
	/**
	 * Column Info
	 * @param srAmdKndCd
	 */
	public void setSrAmdKndCd(String srAmdKndCd) {
		this.srAmdKndCd = srAmdKndCd;
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
	 * @param rtnToRtnStsCd
	 */
	public void setRtnToRtnStsCd(String rtnToRtnStsCd) {
		this.rtnToRtnStsCd = rtnToRtnStsCd;
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
	 * @param chkEmlRcvFailFlg
	 */
	public void setChkEmlRcvFailFlg(String chkEmlRcvFailFlg) {
		this.chkEmlRcvFailFlg = chkEmlRcvFailFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgNoMtchStsCd
	 */
	public void setBkgNoMtchStsCd(String bkgNoMtchStsCd) {
		this.bkgNoMtchStsCd = bkgNoMtchStsCd;
	}
	
	/**
	 * Column Info
	 * @param fntOfcEml
	 */
	public void setFntOfcEml(String fntOfcEml) {
		this.fntOfcEml = fntOfcEml;
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
	 * @param rtnToRtnDt
	 */
	public void setRtnToRtnDt(String rtnToRtnDt) {
		this.rtnToRtnDt = rtnToRtnDt;
	}
	
	/**
	 * Column Info
	 * @param emlSubjCtnt
	 */
	public void setEmlSubjCtnt(String emlSubjCtnt) {
		this.emlSubjCtnt = emlSubjCtnt;
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
	
	public String getSolAplyPhsNo() {
		return solAplyPhsNo;
	}

	public void setSolAplyPhsNo(String solAplyPhsNo) {
		this.solAplyPhsNo = solAplyPhsNo;
	}

	public String getSiRqstCngBseCd() {
		return siRqstCngBseCd;
	}

	public void setSiRqstCngBseCd(String siRqstCngBseCd) {
		this.siRqstCngBseCd = siRqstCngBseCd;
	}

	public String getSiDocReadScsFlg() {
		return siDocReadScsFlg;
	}

	public void setSiDocReadScsFlg(String siDocReadScsFlg) {
		this.siDocReadScsFlg = siDocReadScsFlg;
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
		setIsEmlRcvFailFlg(JSPUtil.getParameter(request, prefix + "is_eml_rcv_fail_flg", ""));
		setSndrFaxNoCtnt(JSPUtil.getParameter(request, prefix + "sndr_fax_no_ctnt", ""));
		setRtnGdt(JSPUtil.getParameter(request, prefix + "rtn_gdt", ""));
		setSrFaxRsltCd(JSPUtil.getParameter(request, prefix + "sr_fax_rslt_cd", ""));
		setEmlOrgSubjCtnt(JSPUtil.getParameter(request, prefix + "eml_org_subj_ctnt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSrRtnToStsCd(JSPUtil.getParameter(request, prefix + "sr_rtn_to_sts_cd", ""));
		setRtnToUsrId(JSPUtil.getParameter(request, prefix + "rtn_to_usr_id", ""));
		setSrCrntStsNm(JSPUtil.getParameter(request, prefix + "sr_crnt_sts_nm", ""));
		setRcvDt(JSPUtil.getParameter(request, prefix + "rcv_dt", ""));
		setSrTrnsUsrNm(JSPUtil.getParameter(request, prefix + "sr_trns_usr_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setRtnFmUsrId(JSPUtil.getParameter(request, prefix + "rtn_fm_usr_id", ""));
		setRcvNm(JSPUtil.getParameter(request, prefix + "rcv_nm", ""));
		setRtnFmStsCd(JSPUtil.getParameter(request, prefix + "rtn_fm_sts_cd", ""));
		setImgFileIp(JSPUtil.getParameter(request, prefix + "img_file_ip", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setEmlOriginSubjCtnt(JSPUtil.getParameter(request, prefix + "eml_origin_subj_ctnt", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setRtnDt(JSPUtil.getParameter(request, prefix + "rtn_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setTtlPgKnt(JSPUtil.getParameter(request, prefix + "ttl_pg_knt", ""));
		setAtchFileKnt(JSPUtil.getParameter(request, prefix + "atch_file_knt", ""));
		setImgFileNm(JSPUtil.getParameter(request, prefix + "img_file_nm", ""));
		setMtchUsrNm(JSPUtil.getParameter(request, prefix + "mtch_usr_nm", ""));
		setSrCrntStsCd(JSPUtil.getParameter(request, prefix + "sr_crnt_sts_cd", ""));
		setFromDt(JSPUtil.getParameter(request, prefix + "from_dt", ""));
		setSrFaxRsltNm(JSPUtil.getParameter(request, prefix + "sr_fax_rslt_nm", ""));
		setOfcIncSub(JSPUtil.getParameter(request, prefix + "ofc_inc_sub", ""));
		setOrgBkgNo(JSPUtil.getParameter(request, prefix + "org_bkg_no", ""));
		setRcvGdt(JSPUtil.getParameter(request, prefix + "rcv_gdt", ""));
		setRtnToRtnUsrId(JSPUtil.getParameter(request, prefix + "rtn_to_rtn_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setAtchFilePathCtnt(JSPUtil.getParameter(request, prefix + "atch_file_path_ctnt", ""));
		setWrkTmNo(JSPUtil.getParameter(request, prefix + "wrk_tm_no", ""));
		setRcvOfcCd(JSPUtil.getParameter(request, prefix + "rcv_ofc_cd", ""));
		setMtchUsrId(JSPUtil.getParameter(request, prefix + "mtch_usr_id", ""));
		setImgFilePathCtnt(JSPUtil.getParameter(request, prefix + "img_file_path_ctnt", ""));
		setSrKndCd(JSPUtil.getParameter(request, prefix + "sr_knd_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFaxLogRefNo(JSPUtil.getParameter(request, prefix + "fax_log_ref_no", ""));
		setRtnToRtnGdt(JSPUtil.getParameter(request, prefix + "rtn_to_rtn_gdt", ""));
		setSrAmdTpCd(JSPUtil.getParameter(request, prefix + "sr_amd_tp_cd", ""));
		setBkgNoMtchStsNm(JSPUtil.getParameter(request, prefix + "bkg_no_mtch_sts_nm", ""));
		setSrAmdKndCd(JSPUtil.getParameter(request, prefix + "sr_amd_knd_cd", ""));
		setSrNo(JSPUtil.getParameter(request, prefix + "sr_no", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setRcvRmk(JSPUtil.getParameter(request, prefix + "rcv_rmk", ""));
		setRtnToRtnStsCd(JSPUtil.getParameter(request, prefix + "rtn_to_rtn_sts_cd", ""));
		setSrTrnsUsrId(JSPUtil.getParameter(request, prefix + "sr_trns_usr_id", ""));
		setChkEmlRcvFailFlg(JSPUtil.getParameter(request, prefix + "chk_eml_rcv_fail_flg", ""));
		setBkgNoMtchStsCd(JSPUtil.getParameter(request, prefix + "bkg_no_mtch_sts_cd", ""));
		setFntOfcEml(JSPUtil.getParameter(request, prefix + "fnt_ofc_eml", ""));
		setSrUrgCd(JSPUtil.getParameter(request, prefix + "sr_urg_cd", ""));
		setRtnToRtnDt(JSPUtil.getParameter(request, prefix + "rtn_to_rtn_dt", ""));
		setEmlSubjCtnt(JSPUtil.getParameter(request, prefix + "eml_subj_ctnt", ""));
		setSrMtchStsCd(JSPUtil.getParameter(request, prefix + "sr_mtch_sts_cd", ""));
		setSrTrnsDt(JSPUtil.getParameter(request, prefix + "sr_trns_dt", ""));
		setSrMtchStsNm(JSPUtil.getParameter(request, prefix + "sr_mtch_sts_nm", ""));
		
		setSrBkgStsCd (JSPUtil.getParameter(request, prefix + "sr_bkg_sts_cd", ""));
		setSrIfStatusCd (JSPUtil.getParameter(request, prefix + "sr_if_status_cd", ""));
		setSrUrgencyCd (JSPUtil.getParameter(request, prefix + "sr_urgency_cd", ""));
		
		setSrKndComboCd  (JSPUtil.getParameter(request, prefix + "sr_knd_combo_cd", ""));
		setSplitBkgYn  (JSPUtil.getParameter(request, prefix + "split_bkg_yn", ""));
		setBlSplitNo  (JSPUtil.getParameter(request, prefix + "bl_split_no", ""));
		setBlSplitTtlKnt  (JSPUtil.getParameter(request, prefix + "bl_split_ttl_knt", ""));
		setSplitStsCd  (JSPUtil.getParameter(request, prefix + "split_sts_cd", ""));
		setMaxSeq  (JSPUtil.getParameter(request, prefix + "max_seq", ""));
		setSrAmdSeq  (JSPUtil.getParameter(request, prefix + "sr_amd_seq", ""));
		setXterSndrId  (JSPUtil.getParameter(request, prefix + "xter_sndr_id", ""));

		setOldBkgNo  (JSPUtil.getParameter(request, prefix + "old_bkg_no", ""));
		setOldSrAmdTpCd   (JSPUtil.getParameter(request, prefix + "old_sr_amd_tp_cd", ""));
		setOldSrUrgCd   (JSPUtil.getParameter(request, prefix + "old_sr_urg_cd", ""));
		setOldSplitStsCd  (JSPUtil.getParameter(request, prefix + "old_split_sts_cd", ""));
		setOldBlSplitNo   (JSPUtil.getParameter(request, prefix + "old_bl_split_no", ""));
		setOldBlSplitTtlKnt  (JSPUtil.getParameter(request, prefix + "old_bl_split_ttl_knt", ""));
		setGmtRcvDt  (JSPUtil.getParameter(request, prefix + "gmt_rcv_dt", ""));
		
		setSiDocReadScsFlg(JSPUtil.getParameter(request, prefix + "sol_aply_phs_no", ""));
		setSiRqstCngBseCd(JSPUtil.getParameter(request, prefix + "si_rqst_cng_bse_cd", ""));
		setSiDocReadScsFlg(JSPUtil.getParameter(request, prefix + "si_doc_read_scs_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSREmlReceivingListVO[]
	 */
	public SearchSREmlReceivingListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSREmlReceivingListVO[]
	 */
	public SearchSREmlReceivingListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSREmlReceivingListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] isEmlRcvFailFlg = (JSPUtil.getParameter(request, prefix	+ "is_eml_rcv_fail_flg", length));
			String[] sndrFaxNoCtnt = (JSPUtil.getParameter(request, prefix	+ "sndr_fax_no_ctnt", length));
			String[] rtnGdt = (JSPUtil.getParameter(request, prefix	+ "rtn_gdt", length));
			String[] srFaxRsltCd = (JSPUtil.getParameter(request, prefix	+ "sr_fax_rslt_cd", length));
			String[] emlOrgSubjCtnt = (JSPUtil.getParameter(request, prefix	+ "eml_org_subj_ctnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] srRtnToStsCd = (JSPUtil.getParameter(request, prefix	+ "sr_rtn_to_sts_cd", length));
			String[] rtnToUsrId = (JSPUtil.getParameter(request, prefix	+ "rtn_to_usr_id", length));
			String[] srCrntStsNm = (JSPUtil.getParameter(request, prefix	+ "sr_crnt_sts_nm", length));
			String[] rcvDt = (JSPUtil.getParameter(request, prefix	+ "rcv_dt", length));
			String[] srTrnsUsrNm = (JSPUtil.getParameter(request, prefix	+ "sr_trns_usr_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] rtnFmUsrId = (JSPUtil.getParameter(request, prefix	+ "rtn_fm_usr_id", length));
			String[] rcvNm = (JSPUtil.getParameter(request, prefix	+ "rcv_nm", length));
			String[] rtnFmStsCd = (JSPUtil.getParameter(request, prefix	+ "rtn_fm_sts_cd", length));
			String[] imgFileIp = (JSPUtil.getParameter(request, prefix	+ "img_file_ip", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] emlOriginSubjCtnt = (JSPUtil.getParameter(request, prefix	+ "eml_origin_subj_ctnt", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] rtnDt = (JSPUtil.getParameter(request, prefix	+ "rtn_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ttlPgKnt = (JSPUtil.getParameter(request, prefix	+ "ttl_pg_knt", length));
			String[] atchFileKnt = (JSPUtil.getParameter(request, prefix	+ "atch_file_knt", length));
			String[] imgFileNm = (JSPUtil.getParameter(request, prefix	+ "img_file_nm", length));
			String[] mtchUsrNm = (JSPUtil.getParameter(request, prefix	+ "mtch_usr_nm", length));
			String[] srCrntStsCd = (JSPUtil.getParameter(request, prefix	+ "sr_crnt_sts_cd", length));
			String[] fromDt = (JSPUtil.getParameter(request, prefix	+ "from_dt", length));
			String[] srFaxRsltNm = (JSPUtil.getParameter(request, prefix	+ "sr_fax_rslt_nm", length));
			String[] ofcIncSub = (JSPUtil.getParameter(request, prefix	+ "ofc_inc_sub", length));
			String[] orgBkgNo = (JSPUtil.getParameter(request, prefix	+ "org_bkg_no", length));
			String[] rcvGdt = (JSPUtil.getParameter(request, prefix	+ "rcv_gdt", length));
			String[] rtnToRtnUsrId = (JSPUtil.getParameter(request, prefix	+ "rtn_to_rtn_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] atchFilePathCtnt = (JSPUtil.getParameter(request, prefix	+ "atch_file_path_ctnt", length));
			String[] wrkTmNo = (JSPUtil.getParameter(request, prefix	+ "wrk_tm_no", length));
			String[] rcvOfcCd = (JSPUtil.getParameter(request, prefix	+ "rcv_ofc_cd", length));
			String[] mtchUsrId = (JSPUtil.getParameter(request, prefix	+ "mtch_usr_id", length));
			String[] imgFilePathCtnt = (JSPUtil.getParameter(request, prefix	+ "img_file_path_ctnt", length));
			String[] srKndCd = (JSPUtil.getParameter(request, prefix	+ "sr_knd_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] faxLogRefNo = (JSPUtil.getParameter(request, prefix	+ "fax_log_ref_no", length));
			String[] rtnToRtnGdt = (JSPUtil.getParameter(request, prefix	+ "rtn_to_rtn_gdt", length));
			String[] srAmdTpCd = (JSPUtil.getParameter(request, prefix	+ "sr_amd_tp_cd", length));
			String[] bkgNoMtchStsNm = (JSPUtil.getParameter(request, prefix	+ "bkg_no_mtch_sts_nm", length));
			String[] srAmdKndCd = (JSPUtil.getParameter(request, prefix	+ "sr_amd_knd_cd", length));
			String[] srNo = (JSPUtil.getParameter(request, prefix	+ "sr_no", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] rcvRmk = (JSPUtil.getParameter(request, prefix	+ "rcv_rmk", length));
			String[] rtnToRtnStsCd = (JSPUtil.getParameter(request, prefix	+ "rtn_to_rtn_sts_cd", length));
			String[] srTrnsUsrId = (JSPUtil.getParameter(request, prefix	+ "sr_trns_usr_id", length));
			String[] chkEmlRcvFailFlg = (JSPUtil.getParameter(request, prefix	+ "chk_eml_rcv_fail_flg", length));
			String[] bkgNoMtchStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_no_mtch_sts_cd", length));
			String[] fntOfcEml = (JSPUtil.getParameter(request, prefix	+ "fnt_ofc_eml", length));
			String[] srUrgCd = (JSPUtil.getParameter(request, prefix	+ "sr_urg_cd", length));
			String[] rtnToRtnDt = (JSPUtil.getParameter(request, prefix	+ "rtn_to_rtn_dt", length));
			String[] emlSubjCtnt = (JSPUtil.getParameter(request, prefix	+ "eml_subj_ctnt", length));
			String[] srMtchStsCd = (JSPUtil.getParameter(request, prefix	+ "sr_mtch_sts_cd", length));
			String[] srTrnsDt = (JSPUtil.getParameter(request, prefix	+ "sr_trns_dt", length));
			String[] srMtchStsNm = (JSPUtil.getParameter(request, prefix	+ "sr_mtch_sts_nm", length));
			
			String[] srBkgStsCd = (JSPUtil.getParameter(request, prefix	+ "sr_bkg_sts_cd", length));
			String[] srIfStatusCd  = (JSPUtil.getParameter(request, prefix	+ "sr_if_status_cd", length));
			String[] srUrgencyCd  = (JSPUtil.getParameter(request, prefix	+ "sr_urgency_cd", length));
			
			String[] srKndComboCd   = (JSPUtil.getParameter(request, prefix	+ "sr_knd_combo_cd", length));
			String[] splitBkgYn   = (JSPUtil.getParameter(request, prefix	+ "split_bkg_yn", length));
			String[] blSplitNo   = (JSPUtil.getParameter(request, prefix	+ "bl_split_no", length));
			String[] blSplitTtlKnt   = (JSPUtil.getParameter(request, prefix	+ "bl_split_ttl_knt", length));
			String[] splitStsCd   = (JSPUtil.getParameter(request, prefix	+ "split_sts_cd", length));
			String[] maxSeq   = (JSPUtil.getParameter(request, prefix	+ "max_seq", length));
			String[] srAmdSeq   = (JSPUtil.getParameter(request, prefix	+ "sr_amd_seq", length));
			String[] xterSndrId   = (JSPUtil.getParameter(request, prefix	+ "xter_sndr_id", length));
			
			String[] oldBkgNo           = (JSPUtil.getParameter(request, prefix	+ "old_bkg_no", length));
			String[] oldSrAmdTpCd       = (JSPUtil.getParameter(request, prefix	+ "old_sr_amd_tp_cd", length));
			String[] oldSrUrgCd         = (JSPUtil.getParameter(request, prefix	+ "old_sr_urg_cd", length));
			String[] oldSplitStsCd      = (JSPUtil.getParameter(request, prefix	+ "old_split_sts_cd", length));
			String[] oldBlSplitNo       = (JSPUtil.getParameter(request, prefix	+ "old_bl_split_no", length));
			String[] oldBlSplitTtlKnt   = (JSPUtil.getParameter(request, prefix	+ "old_bl_split_ttl_knt", length));
			
			String[] gmtRcvDt   = (JSPUtil.getParameter(request, prefix	+ "gmt_rcv_dt", length));
			
			String[] solAplyPhsNo	= (JSPUtil.getParameter(request, prefix + "sol_aply_phs_no", length));
			String[] siRqstCngBseCd	= (JSPUtil.getParameter(request, prefix + "si_rqst_cng_bse_cd", length));
			String[] siDocReadScsFlg	= (JSPUtil.getParameter(request, prefix + "si_doc_read_scs_flg", length));
			
			
			for (int i = 0; i < length; i++) {
				model = new SearchSREmlReceivingListVO();
				if (isEmlRcvFailFlg[i] != null)
					model.setIsEmlRcvFailFlg(isEmlRcvFailFlg[i]);
				if (sndrFaxNoCtnt[i] != null)
					model.setSndrFaxNoCtnt(sndrFaxNoCtnt[i]);
				if (rtnGdt[i] != null)
					model.setRtnGdt(rtnGdt[i]);
				if (srFaxRsltCd[i] != null)
					model.setSrFaxRsltCd(srFaxRsltCd[i]);
				if (emlOrgSubjCtnt[i] != null)
					model.setEmlOrgSubjCtnt(emlOrgSubjCtnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (srRtnToStsCd[i] != null)
					model.setSrRtnToStsCd(srRtnToStsCd[i]);
				if (rtnToUsrId[i] != null)
					model.setRtnToUsrId(rtnToUsrId[i]);
				if (srCrntStsNm[i] != null)
					model.setSrCrntStsNm(srCrntStsNm[i]);
				if (rcvDt[i] != null)
					model.setRcvDt(rcvDt[i]);
				if (srTrnsUsrNm[i] != null)
					model.setSrTrnsUsrNm(srTrnsUsrNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (rtnFmUsrId[i] != null)
					model.setRtnFmUsrId(rtnFmUsrId[i]);
				if (rcvNm[i] != null)
					model.setRcvNm(rcvNm[i]);
				if (rtnFmStsCd[i] != null)
					model.setRtnFmStsCd(rtnFmStsCd[i]);
				if (imgFileIp[i] != null)
					model.setImgFileIp(imgFileIp[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (emlOriginSubjCtnt[i] != null)
					model.setEmlOriginSubjCtnt(emlOriginSubjCtnt[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (rtnDt[i] != null)
					model.setRtnDt(rtnDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ttlPgKnt[i] != null)
					model.setTtlPgKnt(ttlPgKnt[i]);
				if (atchFileKnt[i] != null)
					model.setAtchFileKnt(atchFileKnt[i]);
				if (imgFileNm[i] != null)
					model.setImgFileNm(imgFileNm[i]);
				if (mtchUsrNm[i] != null)
					model.setMtchUsrNm(mtchUsrNm[i]);
				if (srCrntStsCd[i] != null)
					model.setSrCrntStsCd(srCrntStsCd[i]);
				if (fromDt[i] != null)
					model.setFromDt(fromDt[i]);
				if (srFaxRsltNm[i] != null)
					model.setSrFaxRsltNm(srFaxRsltNm[i]);
				if (ofcIncSub[i] != null)
					model.setOfcIncSub(ofcIncSub[i]);
				if (orgBkgNo[i] != null)
					model.setOrgBkgNo(orgBkgNo[i]);
				if (rcvGdt[i] != null)
					model.setRcvGdt(rcvGdt[i]);
				if (rtnToRtnUsrId[i] != null)
					model.setRtnToRtnUsrId(rtnToRtnUsrId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (atchFilePathCtnt[i] != null)
					model.setAtchFilePathCtnt(atchFilePathCtnt[i]);
				if (wrkTmNo[i] != null)
					model.setWrkTmNo(wrkTmNo[i]);
				if (rcvOfcCd[i] != null)
					model.setRcvOfcCd(rcvOfcCd[i]);
				if (mtchUsrId[i] != null)
					model.setMtchUsrId(mtchUsrId[i]);
				if (imgFilePathCtnt[i] != null)
					model.setImgFilePathCtnt(imgFilePathCtnt[i]);
				if (srKndCd[i] != null)
					model.setSrKndCd(srKndCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (faxLogRefNo[i] != null)
					model.setFaxLogRefNo(faxLogRefNo[i]);
				if (rtnToRtnGdt[i] != null)
					model.setRtnToRtnGdt(rtnToRtnGdt[i]);
				if (srAmdTpCd[i] != null)
					model.setSrAmdTpCd(srAmdTpCd[i]);
				if (bkgNoMtchStsNm[i] != null)
					model.setBkgNoMtchStsNm(bkgNoMtchStsNm[i]);
				if (srAmdKndCd[i] != null)
					model.setSrAmdKndCd(srAmdKndCd[i]);
				if (srNo[i] != null)
					model.setSrNo(srNo[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (rcvRmk[i] != null)
					model.setRcvRmk(rcvRmk[i]);
				if (rtnToRtnStsCd[i] != null)
					model.setRtnToRtnStsCd(rtnToRtnStsCd[i]);
				if (srTrnsUsrId[i] != null)
					model.setSrTrnsUsrId(srTrnsUsrId[i]);
				if (chkEmlRcvFailFlg[i] != null)
					model.setChkEmlRcvFailFlg(chkEmlRcvFailFlg[i]);
				if (bkgNoMtchStsCd[i] != null)
					model.setBkgNoMtchStsCd(bkgNoMtchStsCd[i]);
				if (fntOfcEml[i] != null)
					model.setFntOfcEml(fntOfcEml[i]);
				if (srUrgCd[i] != null)
					model.setSrUrgCd(srUrgCd[i]);
				if (rtnToRtnDt[i] != null)
					model.setRtnToRtnDt(rtnToRtnDt[i]);
				if (emlSubjCtnt[i] != null)
					model.setEmlSubjCtnt(emlSubjCtnt[i]);
				if (srMtchStsCd[i] != null)
					model.setSrMtchStsCd(srMtchStsCd[i]);
				if (srTrnsDt[i] != null)
					model.setSrTrnsDt(srTrnsDt[i]);
				if (srMtchStsNm[i] != null)
					model.setSrMtchStsNm(srMtchStsNm[i]);
				
				if (srBkgStsCd[i] != null)
					model.setSrBkgStsCd (srBkgStsCd[i]);
				if (srIfStatusCd [i] != null)
					model.setSrIfStatusCd  (srIfStatusCd [i]);
				if (srUrgencyCd [i] != null)
					model.setSrUrgencyCd  (srUrgencyCd [i]);			

				if (srKndComboCd  [i] != null)
					model.setSrKndComboCd   (srKndComboCd  [i]);
				if (splitBkgYn  [i] != null)
					model.setSplitBkgYn   (splitBkgYn  [i]);
				if (blSplitNo  [i] != null)
					model.setBlSplitNo   (blSplitNo  [i]);
				if (blSplitTtlKnt  [i] != null)
					model.setBlSplitTtlKnt   (blSplitTtlKnt  [i]);
				if (splitStsCd  [i] != null)
					model.setSplitStsCd   (splitStsCd  [i]);
				if (maxSeq  [i] != null)
					model.setMaxSeq   (maxSeq  [i]);		
				if (srAmdSeq  [i] != null)
					model.setSrAmdSeq   (srAmdSeq  [i]);	
				if (xterSndrId  [i] != null)
					model.setXterSndrId   (xterSndrId  [i]);	

				if (oldBkgNo          [i] != null) model.setOldBkgNo           (oldBkgNo          [i]);	
				if (oldSrAmdTpCd      [i] != null) model.setOldSrAmdTpCd       (oldSrAmdTpCd      [i]);	
				if (oldSrUrgCd        [i] != null) model.setOldSrUrgCd         (oldSrUrgCd        [i]);	
				if (oldSplitStsCd     [i] != null) model.setOldSplitStsCd      (oldSplitStsCd     [i]);	
				if (oldBlSplitNo      [i] != null) model.setOldBlSplitNo       (oldBlSplitNo      [i]);	
				if (oldBlSplitTtlKnt  [i] != null) model.setOldBlSplitTtlKnt   (oldBlSplitTtlKnt  [i]);
				
				if (gmtRcvDt[i] != null) model.setGmtRcvDt (gmtRcvDt  [i]);
				
				if (solAplyPhsNo  [i] != null) model.setSolAplyPhsNo   (solAplyPhsNo  [i]);
				if (siRqstCngBseCd  [i] != null) model.setSiRqstCngBseCd   (siRqstCngBseCd  [i]);
				if (siDocReadScsFlg  [i] != null) model.setSiDocReadScsFlg   (siDocReadScsFlg  [i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSREmlReceivingListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSREmlReceivingListVO[]
	 */
	public SearchSREmlReceivingListVO[] getSearchSREmlReceivingListVOs(){
		SearchSREmlReceivingListVO[] vos = (SearchSREmlReceivingListVO[])models.toArray(new SearchSREmlReceivingListVO[models.size()]);
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
		this.isEmlRcvFailFlg = this.isEmlRcvFailFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndrFaxNoCtnt = this.sndrFaxNoCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnGdt = this.rtnGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srFaxRsltCd = this.srFaxRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlOrgSubjCtnt = this.emlOrgSubjCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srRtnToStsCd = this.srRtnToStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnToUsrId = this.rtnToUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srCrntStsNm = this.srCrntStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDt = this.rcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srTrnsUsrNm = this.srTrnsUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnFmUsrId = this.rtnFmUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvNm = this.rcvNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnFmStsCd = this.rtnFmStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imgFileIp = this.imgFileIp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlOriginSubjCtnt = this.emlOriginSubjCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnDt = this.rtnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlPgKnt = this.ttlPgKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFileKnt = this.atchFileKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imgFileNm = this.imgFileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtchUsrNm = this.mtchUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srCrntStsCd = this.srCrntStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDt = this.fromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srFaxRsltNm = this.srFaxRsltNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcIncSub = this.ofcIncSub .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgBkgNo = this.orgBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvGdt = this.rcvGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnToRtnUsrId = this.rtnToRtnUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFilePathCtnt = this.atchFilePathCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrkTmNo = this.wrkTmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvOfcCd = this.rcvOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtchUsrId = this.mtchUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imgFilePathCtnt = this.imgFilePathCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srKndCd = this.srKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxLogRefNo = this.faxLogRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnToRtnGdt = this.rtnToRtnGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srAmdTpCd = this.srAmdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNoMtchStsNm = this.bkgNoMtchStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srAmdKndCd = this.srAmdKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srNo = this.srNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvRmk = this.rcvRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnToRtnStsCd = this.rtnToRtnStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srTrnsUsrId = this.srTrnsUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkEmlRcvFailFlg = this.chkEmlRcvFailFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNoMtchStsCd = this.bkgNoMtchStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fntOfcEml = this.fntOfcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srUrgCd = this.srUrgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnToRtnDt = this.rtnToRtnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSubjCtnt = this.emlSubjCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srMtchStsCd = this.srMtchStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srTrnsDt = this.srTrnsDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srMtchStsNm = this.srMtchStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.srBkgStsCd  = this.srBkgStsCd  .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srIfStatusCd  = this.srIfStatusCd  .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srUrgencyCd  = this.srUrgencyCd  .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.srKndComboCd  = this.srKndComboCd   .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splitBkgYn  = this.splitBkgYn   .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSplitNo  = this.blSplitNo   .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSplitTtlKnt  = this.blSplitTtlKnt   .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splitStsCd  = this.splitStsCd   .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxSeq  = this.maxSeq   .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srAmdSeq  = this.srAmdSeq   .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterSndrId  = this.xterSndrId   .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldBkgNo          = this.oldBkgNo           .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldSrAmdTpCd      = this.oldSrAmdTpCd       .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldSrUrgCd        = this.oldSrUrgCd         .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldSplitStsCd     = this.oldSplitStsCd      .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldBlSplitNo      = this.oldBlSplitNo       .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldBlSplitTtlKnt  = this.oldBlSplitTtlKnt   .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.gmtRcvDt  = this.gmtRcvDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.solAplyPhsNo  = this.solAplyPhsNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.solAplyPhsNo  = this.solAplyPhsNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siDocReadScsFlg  = this.siDocReadScsFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
