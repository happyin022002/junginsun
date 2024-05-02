/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DocQueueBkgHistListVO.java
*@FileTitle : DocQueueBkgHistListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.25
*@LastModifier : 
*@LastVersion : 1.0
* 2011.07.25  
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

public class DocQueueBkgHistListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DocQueueBkgHistListVO> models = new ArrayList<DocQueueBkgHistListVO>();
	
	/* Column Info */
	private String totPgKnt = null;
	/* Column Info */
	private String hblInfoInpFlg = null;
	/* Column Info */
	private String imgFileRealPath = null;
	/* Column Info */
	private String amdRespbUsrId = null;
	/* Column Info */
	private String snaccsSrNo = null;
	/* Column Info */
	private String pagerows = null;
	/* Column Info */
	private String srAmdRsnSeq = null;
	/* Column Info */
	private String srRtnToStsCd = null;
	/* Column Info */
	private String rtnToUsrId = null;
	/* Column Info */
	private String srDueDt = null;
	/* Column Info */
	private String srCrntInfoCd = null;
	/* Column Info */
	private String preSrNoAmdTpCd = null;
	/* Column Info */
	private String chgInpFlg = null;
	/* Column Info */
	private String awkCgoInpFlg = null;
	/* Column Info */
	private String usrGrpCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String custInpFlg = null;
	/* Column Info */
	private String rtnFmUsrId = null;
	/* Column Info */
	private String dcgoInpFlg = null;
	/* Column Info */
	private String inpWrkCtnt = null;
	/* Column Info */
	private String preSrNo = null;
	/* Column Info */
	private String maxSrNo = null;
	/* Column Info */
	private String srWrkStsDt = null;
	/* Column Info */
	private String blInfoInpFlg = null;
	/* Column Info */
	private String rtnFmStsCd = null;
	/* Column Info */
	private String xterRqstNo2 = null;
	/* Column Info */
	private String imgFileIp = null;
	/* Column Info */
	private String srAmdRsnCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String rtnDt = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String split = null;
	/* Column Info */
	private String preBkgNo = null;
	/* Column Info */
	private String imgFileNm = null;
	/* Column Info */
	private String splitFlg = null;
	/* Column Info */
	private String srCrntStsCd = null;
	/* Column Info */
	private String pndFlg = null;
	/* Column Info */
	private String cntrMfInpFlg = null;
	/* Column Info */
	private String preSrNoAmdSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String srAmdSeq = null;
	/* Column Info */
	private String rtnToRtnUsrId = null;
	/* Column Info */
	private String fntOfcSndrId = null;
	/* Column Info */
	private String rcvOfcCd = null;
	/* Column Info */
	private String imgFilePathCtnt = null;
	/* Column Info */
	private String newBkgCreFlg = null;
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String srKndCd = null;
	/* Column Info */
	private String srWrkStsCd = null;
	/* Column Info */
	private String srWrkStsUsrId = null;
	/* Column Info */
	private String fntOfcTrnsDt = null;
	/* Column Info */
	private String rlyPortInpFlg = null;
	/* Column Info */
	private String faxLogRefNo = null;
	/* Column Info */
	private String rtWrkCtnt = null;
	/* Column Info */
	private String srAmdTpCd = null;
	/* Column Info */
	private String maxHisSeq = null;
	/* Column Info */
	private String srAmdKndCd = null;
	/* Column Info */
	private String blSplitNo = null;
	/* Column Info */
	private String srNo = null;
	/* Column Info */
	private String crntDt = null;
	/* Column Info */
	private String crntUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String rtnToRtnStsCd = null;
	/* Column Info */
	private String creFlg = null;
	/* Column Info */
	private String dpcsOfcCd = null;
	/* Column Info */
	private String fntOfcCd = null;
	/* Column Info */
	private String cntrInpFlg = null;
	/* Column Info */
	private String mkDescInpFlg = null;
	/* Column Info */
	private String blSplitTtlKnt = null;
	/* Column Info */
	private String faxSvrOfcCd = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String imgPgNo = null;
	/* Column Info */
	private String rcInpFlg = null;
	/* Column Info */
	private String srAmdRsnTpCd = null;
	/* Column Info */
	private String preNisSrNo = null;
	/* Column Info */
	private String xterRqstSeq = null;
	/* Column Info */
	private String rtnToRtnDt = null;
	/* Column Info */
	private String srUrgCd = null;
	/* Column Info */
	private String audWrkCtnt = null;
	/* Column Info */
	private String xterRqstNo = null;
	/* Column Info */
	private String bbCgoInpFlg = null;
	/* Column Info */
	private String fntOfcEml = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DocQueueBkgHistListVO() {}

	public DocQueueBkgHistListVO(String ibflag, String pagerows, String hblInfoInpFlg, String amdRespbUsrId, String snaccsSrNo, String srAmdRsnSeq, String srRtnToStsCd, String rtnToUsrId, String srCrntInfoCd, String preSrNoAmdTpCd, String chgInpFlg, String usrGrpCd, String updUsrId, String awkCgoInpFlg, String custInpFlg, String rtnFmUsrId, String inpWrkCtnt, String dcgoInpFlg, String preSrNo, String maxSrNo, String blInfoInpFlg, String rtnFmStsCd, String imgFileIp, String xterRqstNo2, String srAmdRsnCd, String creUsrId, String rtnDt, String bkgNo, String preBkgNo, String imgFileNm, String splitFlg, String srCrntStsCd, String pndFlg, String cntrMfInpFlg, String preSrNoAmdSeq, String creDt, String srAmdSeq, String rtnToRtnUsrId, String fntOfcSndrId, String imgFilePathCtnt, String newBkgCreFlg, String srKndCd, String fntOfcTrnsDt, String rlyPortInpFlg, String faxLogRefNo, String rtWrkCtnt, String srAmdTpCd, String maxHisSeq, String srAmdKndCd, String srNo, String crntUsrId, String crntDt, String updDt, String rtnToRtnStsCd, String dpcsOfcCd, String creFlg, String fntOfcCd, String cntrInpFlg, String mkDescInpFlg, String diffRmk, String imgPgNo, String rcInpFlg, String preNisSrNo, String srAmdRsnTpCd, String srUrgCd, String rtnToRtnDt, String xterRqstSeq, String bbCgoInpFlg, String xterRqstNo, String audWrkCtnt, String rcvOfcCd, String srWrkStsCd, String srWrkStsUsrId, String srWrkStsDt, String totPgKnt, String faxSvrOfcCd, String split, String blSplitNo, String blSplitTtlKnt, String srDueDt, String imgFileRealPath,String fntOfcEml) {
		this.totPgKnt = totPgKnt;
		this.hblInfoInpFlg = hblInfoInpFlg;
		this.imgFileRealPath = imgFileRealPath;
		this.amdRespbUsrId = amdRespbUsrId;
		this.snaccsSrNo = snaccsSrNo;
		this.pagerows = pagerows;
		this.srAmdRsnSeq = srAmdRsnSeq;
		this.srRtnToStsCd = srRtnToStsCd;
		this.rtnToUsrId = rtnToUsrId;
		this.srDueDt = srDueDt;
		this.srCrntInfoCd = srCrntInfoCd;
		this.preSrNoAmdTpCd = preSrNoAmdTpCd;
		this.chgInpFlg = chgInpFlg;
		this.awkCgoInpFlg = awkCgoInpFlg;
		this.usrGrpCd = usrGrpCd;
		this.updUsrId = updUsrId;
		this.custInpFlg = custInpFlg;
		this.rtnFmUsrId = rtnFmUsrId;
		this.dcgoInpFlg = dcgoInpFlg;
		this.inpWrkCtnt = inpWrkCtnt;
		this.preSrNo = preSrNo;
		this.maxSrNo = maxSrNo;
		this.srWrkStsDt = srWrkStsDt;
		this.blInfoInpFlg = blInfoInpFlg;
		this.rtnFmStsCd = rtnFmStsCd;
		this.xterRqstNo2 = xterRqstNo2;
		this.imgFileIp = imgFileIp;
		this.srAmdRsnCd = srAmdRsnCd;
		this.creUsrId = creUsrId;
		this.rtnDt = rtnDt;
		this.bkgNo = bkgNo;
		this.split = split;
		this.preBkgNo = preBkgNo;
		this.imgFileNm = imgFileNm;
		this.splitFlg = splitFlg;
		this.srCrntStsCd = srCrntStsCd;
		this.pndFlg = pndFlg;
		this.cntrMfInpFlg = cntrMfInpFlg;
		this.preSrNoAmdSeq = preSrNoAmdSeq;
		this.creDt = creDt;
		this.srAmdSeq = srAmdSeq;
		this.rtnToRtnUsrId = rtnToRtnUsrId;
		this.fntOfcSndrId = fntOfcSndrId;
		this.rcvOfcCd = rcvOfcCd;
		this.imgFilePathCtnt = imgFilePathCtnt;
		this.newBkgCreFlg = newBkgCreFlg;
		this.ibflag = ibflag;
		this.srKndCd = srKndCd;
		this.srWrkStsCd = srWrkStsCd;
		this.srWrkStsUsrId = srWrkStsUsrId;
		this.fntOfcTrnsDt = fntOfcTrnsDt;
		this.rlyPortInpFlg = rlyPortInpFlg;
		this.faxLogRefNo = faxLogRefNo;
		this.rtWrkCtnt = rtWrkCtnt;
		this.srAmdTpCd = srAmdTpCd;
		this.maxHisSeq = maxHisSeq;
		this.srAmdKndCd = srAmdKndCd;
		this.blSplitNo = blSplitNo;
		this.srNo = srNo;
		this.crntDt = crntDt;
		this.crntUsrId = crntUsrId;
		this.updDt = updDt;
		this.rtnToRtnStsCd = rtnToRtnStsCd;
		this.creFlg = creFlg;
		this.dpcsOfcCd = dpcsOfcCd;
		this.fntOfcCd = fntOfcCd;
		this.cntrInpFlg = cntrInpFlg;
		this.mkDescInpFlg = mkDescInpFlg;
		this.blSplitTtlKnt = blSplitTtlKnt;
		this.faxSvrOfcCd = faxSvrOfcCd;
		this.diffRmk = diffRmk;
		this.imgPgNo = imgPgNo;
		this.rcInpFlg = rcInpFlg;
		this.srAmdRsnTpCd = srAmdRsnTpCd;
		this.preNisSrNo = preNisSrNo;
		this.xterRqstSeq = xterRqstSeq;
		this.rtnToRtnDt = rtnToRtnDt;
		this.srUrgCd = srUrgCd;
		this.audWrkCtnt = audWrkCtnt;
		this.xterRqstNo = xterRqstNo;
		this.bbCgoInpFlg = bbCgoInpFlg;
		this.fntOfcEml = fntOfcEml;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tot_pg_knt", getTotPgKnt());
		this.hashColumns.put("hbl_info_inp_flg", getHblInfoInpFlg());
		this.hashColumns.put("img_file_real_path", getImgFileRealPath());
		this.hashColumns.put("amd_respb_usr_id", getAmdRespbUsrId());
		this.hashColumns.put("snaccs_sr_no", getSnaccsSrNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sr_amd_rsn_seq", getSrAmdRsnSeq());
		this.hashColumns.put("sr_rtn_to_sts_cd", getSrRtnToStsCd());
		this.hashColumns.put("rtn_to_usr_id", getRtnToUsrId());
		this.hashColumns.put("sr_due_dt", getSrDueDt());
		this.hashColumns.put("sr_crnt_info_cd", getSrCrntInfoCd());
		this.hashColumns.put("pre_sr_no_amd_tp_cd", getPreSrNoAmdTpCd());
		this.hashColumns.put("chg_inp_flg", getChgInpFlg());
		this.hashColumns.put("awk_cgo_inp_flg", getAwkCgoInpFlg());
		this.hashColumns.put("usr_grp_cd", getUsrGrpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cust_inp_flg", getCustInpFlg());
		this.hashColumns.put("rtn_fm_usr_id", getRtnFmUsrId());
		this.hashColumns.put("dcgo_inp_flg", getDcgoInpFlg());
		this.hashColumns.put("inp_wrk_ctnt", getInpWrkCtnt());
		this.hashColumns.put("pre_sr_no", getPreSrNo());
		this.hashColumns.put("max_sr_no", getMaxSrNo());
		this.hashColumns.put("sr_wrk_sts_dt", getSrWrkStsDt());
		this.hashColumns.put("bl_info_inp_flg", getBlInfoInpFlg());
		this.hashColumns.put("rtn_fm_sts_cd", getRtnFmStsCd());
		this.hashColumns.put("xter_rqst_no2", getXterRqstNo2());
		this.hashColumns.put("img_file_ip", getImgFileIp());
		this.hashColumns.put("sr_amd_rsn_cd", getSrAmdRsnCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("rtn_dt", getRtnDt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("split", getSplit());
		this.hashColumns.put("pre_bkg_no", getPreBkgNo());
		this.hashColumns.put("img_file_nm", getImgFileNm());
		this.hashColumns.put("split_flg", getSplitFlg());
		this.hashColumns.put("sr_crnt_sts_cd", getSrCrntStsCd());
		this.hashColumns.put("pnd_flg", getPndFlg());
		this.hashColumns.put("cntr_mf_inp_flg", getCntrMfInpFlg());
		this.hashColumns.put("pre_sr_no_amd_seq", getPreSrNoAmdSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("sr_amd_seq", getSrAmdSeq());
		this.hashColumns.put("rtn_to_rtn_usr_id", getRtnToRtnUsrId());
		this.hashColumns.put("fnt_ofc_sndr_id", getFntOfcSndrId());
		this.hashColumns.put("rcv_ofc_cd", getRcvOfcCd());
		this.hashColumns.put("img_file_path_ctnt", getImgFilePathCtnt());
		this.hashColumns.put("new_bkg_cre_flg", getNewBkgCreFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sr_knd_cd", getSrKndCd());
		this.hashColumns.put("sr_wrk_sts_cd", getSrWrkStsCd());
		this.hashColumns.put("sr_wrk_sts_usr_id", getSrWrkStsUsrId());
		this.hashColumns.put("fnt_ofc_trns_dt", getFntOfcTrnsDt());
		this.hashColumns.put("rly_port_inp_flg", getRlyPortInpFlg());
		this.hashColumns.put("fax_log_ref_no", getFaxLogRefNo());
		this.hashColumns.put("rt_wrk_ctnt", getRtWrkCtnt());
		this.hashColumns.put("sr_amd_tp_cd", getSrAmdTpCd());
		this.hashColumns.put("max_his_seq", getMaxHisSeq());
		this.hashColumns.put("sr_amd_knd_cd", getSrAmdKndCd());
		this.hashColumns.put("bl_split_no", getBlSplitNo());
		this.hashColumns.put("sr_no", getSrNo());
		this.hashColumns.put("crnt_dt", getCrntDt());
		this.hashColumns.put("crnt_usr_id", getCrntUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rtn_to_rtn_sts_cd", getRtnToRtnStsCd());
		this.hashColumns.put("cre_flg", getCreFlg());
		this.hashColumns.put("dpcs_ofc_cd", getDpcsOfcCd());
		this.hashColumns.put("fnt_ofc_cd", getFntOfcCd());
		this.hashColumns.put("cntr_inp_flg", getCntrInpFlg());
		this.hashColumns.put("mk_desc_inp_flg", getMkDescInpFlg());
		this.hashColumns.put("bl_split_ttl_knt", getBlSplitTtlKnt());
		this.hashColumns.put("faxSvrOfcCd", getFaxSvrOfcCd());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("img_pg_no", getImgPgNo());
		this.hashColumns.put("rc_inp_flg", getRcInpFlg());
		this.hashColumns.put("sr_amd_rsn_tp_cd", getSrAmdRsnTpCd());
		this.hashColumns.put("pre_nis_sr_no", getPreNisSrNo());
		this.hashColumns.put("xter_rqst_seq", getXterRqstSeq());
		this.hashColumns.put("rtn_to_rtn_dt", getRtnToRtnDt());
		this.hashColumns.put("sr_urg_cd", getSrUrgCd());
		this.hashColumns.put("aud_wrk_ctnt", getAudWrkCtnt());
		this.hashColumns.put("xter_rqst_no", getXterRqstNo());
		this.hashColumns.put("bb_cgo_inp_flg", getBbCgoInpFlg());
		this.hashColumns.put("fnt_ofc_eml", getFntOfcEml());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tot_pg_knt", "totPgKnt");
		this.hashFields.put("hbl_info_inp_flg", "hblInfoInpFlg");
		this.hashFields.put("img_file_real_path", "imgFileRealPath");
		this.hashFields.put("amd_respb_usr_id", "amdRespbUsrId");
		this.hashFields.put("snaccs_sr_no", "snaccsSrNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sr_amd_rsn_seq", "srAmdRsnSeq");
		this.hashFields.put("sr_rtn_to_sts_cd", "srRtnToStsCd");
		this.hashFields.put("rtn_to_usr_id", "rtnToUsrId");
		this.hashFields.put("sr_due_dt", "srDueDt");
		this.hashFields.put("sr_crnt_info_cd", "srCrntInfoCd");
		this.hashFields.put("pre_sr_no_amd_tp_cd", "preSrNoAmdTpCd");
		this.hashFields.put("chg_inp_flg", "chgInpFlg");
		this.hashFields.put("awk_cgo_inp_flg", "awkCgoInpFlg");
		this.hashFields.put("usr_grp_cd", "usrGrpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cust_inp_flg", "custInpFlg");
		this.hashFields.put("rtn_fm_usr_id", "rtnFmUsrId");
		this.hashFields.put("dcgo_inp_flg", "dcgoInpFlg");
		this.hashFields.put("inp_wrk_ctnt", "inpWrkCtnt");
		this.hashFields.put("pre_sr_no", "preSrNo");
		this.hashFields.put("max_sr_no", "maxSrNo");
		this.hashFields.put("sr_wrk_sts_dt", "srWrkStsDt");
		this.hashFields.put("bl_info_inp_flg", "blInfoInpFlg");
		this.hashFields.put("rtn_fm_sts_cd", "rtnFmStsCd");
		this.hashFields.put("xter_rqst_no2", "xterRqstNo2");
		this.hashFields.put("img_file_ip", "imgFileIp");
		this.hashFields.put("sr_amd_rsn_cd", "srAmdRsnCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("rtn_dt", "rtnDt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("split", "split");
		this.hashFields.put("pre_bkg_no", "preBkgNo");
		this.hashFields.put("img_file_nm", "imgFileNm");
		this.hashFields.put("split_flg", "splitFlg");
		this.hashFields.put("sr_crnt_sts_cd", "srCrntStsCd");
		this.hashFields.put("pnd_flg", "pndFlg");
		this.hashFields.put("cntr_mf_inp_flg", "cntrMfInpFlg");
		this.hashFields.put("pre_sr_no_amd_seq", "preSrNoAmdSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("sr_amd_seq", "srAmdSeq");
		this.hashFields.put("rtn_to_rtn_usr_id", "rtnToRtnUsrId");
		this.hashFields.put("fnt_ofc_sndr_id", "fntOfcSndrId");
		this.hashFields.put("rcv_ofc_cd", "rcvOfcCd");
		this.hashFields.put("img_file_path_ctnt", "imgFilePathCtnt");
		this.hashFields.put("new_bkg_cre_flg", "newBkgCreFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sr_knd_cd", "srKndCd");
		this.hashFields.put("sr_wrk_sts_cd", "srWrkStsCd");
		this.hashFields.put("sr_wrk_sts_usr_id", "srWrkStsUsrId");
		this.hashFields.put("fnt_ofc_trns_dt", "fntOfcTrnsDt");
		this.hashFields.put("rly_port_inp_flg", "rlyPortInpFlg");
		this.hashFields.put("fax_log_ref_no", "faxLogRefNo");
		this.hashFields.put("rt_wrk_ctnt", "rtWrkCtnt");
		this.hashFields.put("sr_amd_tp_cd", "srAmdTpCd");
		this.hashFields.put("max_his_seq", "maxHisSeq");
		this.hashFields.put("sr_amd_knd_cd", "srAmdKndCd");
		this.hashFields.put("bl_split_no", "blSplitNo");
		this.hashFields.put("sr_no", "srNo");
		this.hashFields.put("crnt_dt", "crntDt");
		this.hashFields.put("crnt_usr_id", "crntUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rtn_to_rtn_sts_cd", "rtnToRtnStsCd");
		this.hashFields.put("cre_flg", "creFlg");
		this.hashFields.put("dpcs_ofc_cd", "dpcsOfcCd");
		this.hashFields.put("fnt_ofc_cd", "fntOfcCd");
		this.hashFields.put("cntr_inp_flg", "cntrInpFlg");
		this.hashFields.put("mk_desc_inp_flg", "mkDescInpFlg");
		this.hashFields.put("bl_split_ttl_knt", "blSplitTtlKnt");
		this.hashFields.put("fax_svr_ofc_cd", "faxSvrOfcCd");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("img_pg_no", "imgPgNo");
		this.hashFields.put("rc_inp_flg", "rcInpFlg");
		this.hashFields.put("sr_amd_rsn_tp_cd", "srAmdRsnTpCd");
		this.hashFields.put("pre_nis_sr_no", "preNisSrNo");
		this.hashFields.put("xter_rqst_seq", "xterRqstSeq");
		this.hashFields.put("rtn_to_rtn_dt", "rtnToRtnDt");
		this.hashFields.put("sr_urg_cd", "srUrgCd");
		this.hashFields.put("aud_wrk_ctnt", "audWrkCtnt");
		this.hashFields.put("xter_rqst_no", "xterRqstNo");
		this.hashFields.put("bb_cgo_inp_flg", "bbCgoInpFlg");
		this.hashFields.put("fnt_ofc_eml", "fntOfcEml");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return totPgKnt
	 */
	public String getTotPgKnt() {
		return this.totPgKnt;
	}
	
	/**
	 * Column Info
	 * @return hblInfoInpFlg
	 */
	public String getHblInfoInpFlg() {
		return this.hblInfoInpFlg;
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
	 * @return amdRespbUsrId
	 */
	public String getAmdRespbUsrId() {
		return this.amdRespbUsrId;
	}
	
	/**
	 * Column Info
	 * @return snaccsSrNo
	 */
	public String getSnaccsSrNo() {
		return this.snaccsSrNo;
	}
	
	/**
	 * Column Info
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return srAmdRsnSeq
	 */
	public String getSrAmdRsnSeq() {
		return this.srAmdRsnSeq;
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
	 * @return srDueDt
	 */
	public String getSrDueDt() {
		return this.srDueDt;
	}
	
	/**
	 * Column Info
	 * @return srCrntInfoCd
	 */
	public String getSrCrntInfoCd() {
		return this.srCrntInfoCd;
	}
	
	/**
	 * Column Info
	 * @return preSrNoAmdTpCd
	 */
	public String getPreSrNoAmdTpCd() {
		return this.preSrNoAmdTpCd;
	}
	
	/**
	 * Column Info
	 * @return chgInpFlg
	 */
	public String getChgInpFlg() {
		return this.chgInpFlg;
	}
	
	/**
	 * Column Info
	 * @return awkCgoInpFlg
	 */
	public String getAwkCgoInpFlg() {
		return this.awkCgoInpFlg;
	}
	
	/**
	 * Column Info
	 * @return usrGrpCd
	 */
	public String getUsrGrpCd() {
		return this.usrGrpCd;
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
	 * @return custInpFlg
	 */
	public String getCustInpFlg() {
		return this.custInpFlg;
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
	 * @return dcgoInpFlg
	 */
	public String getDcgoInpFlg() {
		return this.dcgoInpFlg;
	}
	
	/**
	 * Column Info
	 * @return inpWrkCtnt
	 */
	public String getInpWrkCtnt() {
		return this.inpWrkCtnt;
	}
	
	/**
	 * Column Info
	 * @return preSrNo
	 */
	public String getPreSrNo() {
		return this.preSrNo;
	}
	
	/**
	 * Column Info
	 * @return maxSrNo
	 */
	public String getMaxSrNo() {
		return this.maxSrNo;
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
	 * @return blInfoInpFlg
	 */
	public String getBlInfoInpFlg() {
		return this.blInfoInpFlg;
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
	 * @return xterRqstNo2
	 */
	public String getXterRqstNo2() {
		return this.xterRqstNo2;
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
	 * @return srAmdRsnCd
	 */
	public String getSrAmdRsnCd() {
		return this.srAmdRsnCd;
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
	 * @return rtnDt
	 */
	public String getRtnDt() {
		return this.rtnDt;
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
	 * @return split
	 */
	public String getSplit() {
		return this.split;
	}
	
	/**
	 * Column Info
	 * @return preBkgNo
	 */
	public String getPreBkgNo() {
		return this.preBkgNo;
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
	 * @return splitFlg
	 */
	public String getSplitFlg() {
		return this.splitFlg;
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
	 * @return pndFlg
	 */
	public String getPndFlg() {
		return this.pndFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrMfInpFlg
	 */
	public String getCntrMfInpFlg() {
		return this.cntrMfInpFlg;
	}
	
	/**
	 * Column Info
	 * @return preSrNoAmdSeq
	 */
	public String getPreSrNoAmdSeq() {
		return this.preSrNoAmdSeq;
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
	 * @return fntOfcSndrId
	 */
	public String getFntOfcSndrId() {
		return this.fntOfcSndrId;
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
	 * Column Info
	 * @return newBkgCreFlg
	 */
	public String getNewBkgCreFlg() {
		return this.newBkgCreFlg;
	}
	
	/**
	 * Column Info
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return srKndCd
	 */
	public String getSrKndCd() {
		return this.srKndCd;
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
	 * @return fntOfcTrnsDt
	 */
	public String getFntOfcTrnsDt() {
		return this.fntOfcTrnsDt;
	}
	
	/**
	 * Column Info
	 * @return rlyPortInpFlg
	 */
	public String getRlyPortInpFlg() {
		return this.rlyPortInpFlg;
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
	 * @return rtWrkCtnt
	 */
	public String getRtWrkCtnt() {
		return this.rtWrkCtnt;
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
	 * @return maxHisSeq
	 */
	public String getMaxHisSeq() {
		return this.maxHisSeq;
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
	 * @return crntDt
	 */
	public String getCrntDt() {
		return this.crntDt;
	}
	
	/**
	 * Column Info
	 * @return crntUsrId
	 */
	public String getCrntUsrId() {
		return this.crntUsrId;
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
	 * @return rtnToRtnStsCd
	 */
	public String getRtnToRtnStsCd() {
		return this.rtnToRtnStsCd;
	}
	
	/**
	 * Column Info
	 * @return creFlg
	 */
	public String getCreFlg() {
		return this.creFlg;
	}
	
	/**
	 * Column Info
	 * @return dpcsOfcCd
	 */
	public String getDpcsOfcCd() {
		return this.dpcsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return fntOfcCd
	 */
	public String getFntOfcCd() {
		return this.fntOfcCd;
	}
	
	/**
	 * Column Info
	 * @return cntrInpFlg
	 */
	public String getCntrInpFlg() {
		return this.cntrInpFlg;
	}
	
	/**
	 * Column Info
	 * @return mkDescInpFlg
	 */
	public String getMkDescInpFlg() {
		return this.mkDescInpFlg;
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
	 * @return faxsvrofccd
	 */
	public String getFaxSvrOfcCd() {
		return this.faxSvrOfcCd;
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
	 * @return rcInpFlg
	 */
	public String getRcInpFlg() {
		return this.rcInpFlg;
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
	 * @return preNisSrNo
	 */
	public String getPreNisSrNo() {
		return this.preNisSrNo;
	}
	
	/**
	 * Column Info
	 * @return xterRqstSeq
	 */
	public String getXterRqstSeq() {
		return this.xterRqstSeq;
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
	 * @return srUrgCd
	 */
	public String getSrUrgCd() {
		return this.srUrgCd;
	}
	
	/**
	 * Column Info
	 * @return audWrkCtnt
	 */
	public String getAudWrkCtnt() {
		return this.audWrkCtnt;
	}
	
	/**
	 * Column Info
	 * @return xterRqstNo
	 */
	public String getXterRqstNo() {
		return this.xterRqstNo;
	}
	
	/**
	 * Column Info
	 * @return bbCgoInpFlg
	 */
	public String getBbCgoInpFlg() {
		return this.bbCgoInpFlg;
	}
	

	public String getFntOfcEml() {
		return fntOfcEml;
	}

	public void setFntOfcEml(String fntOfcEml) {
		this.fntOfcEml = fntOfcEml;
	}

	/**
	 * Column Info
	 * @param totPgKnt
	 */
	public void setTotPgKnt(String totPgKnt) {
		this.totPgKnt = totPgKnt;
	}
	
	/**
	 * Column Info
	 * @param hblInfoInpFlg
	 */
	public void setHblInfoInpFlg(String hblInfoInpFlg) {
		this.hblInfoInpFlg = hblInfoInpFlg;
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
	 * @param amdRespbUsrId
	 */
	public void setAmdRespbUsrId(String amdRespbUsrId) {
		this.amdRespbUsrId = amdRespbUsrId;
	}
	
	/**
	 * Column Info
	 * @param snaccsSrNo
	 */
	public void setSnaccsSrNo(String snaccsSrNo) {
		this.snaccsSrNo = snaccsSrNo;
	}
	
	/**
	 * Column Info
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param srAmdRsnSeq
	 */
	public void setSrAmdRsnSeq(String srAmdRsnSeq) {
		this.srAmdRsnSeq = srAmdRsnSeq;
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
	 * @param srDueDt
	 */
	public void setSrDueDt(String srDueDt) {
		this.srDueDt = srDueDt;
	}
	
	/**
	 * Column Info
	 * @param srCrntInfoCd
	 */
	public void setSrCrntInfoCd(String srCrntInfoCd) {
		this.srCrntInfoCd = srCrntInfoCd;
	}
	
	/**
	 * Column Info
	 * @param preSrNoAmdTpCd
	 */
	public void setPreSrNoAmdTpCd(String preSrNoAmdTpCd) {
		this.preSrNoAmdTpCd = preSrNoAmdTpCd;
	}
	
	/**
	 * Column Info
	 * @param chgInpFlg
	 */
	public void setChgInpFlg(String chgInpFlg) {
		this.chgInpFlg = chgInpFlg;
	}
	
	/**
	 * Column Info
	 * @param awkCgoInpFlg
	 */
	public void setAwkCgoInpFlg(String awkCgoInpFlg) {
		this.awkCgoInpFlg = awkCgoInpFlg;
	}
	
	/**
	 * Column Info
	 * @param usrGrpCd
	 */
	public void setUsrGrpCd(String usrGrpCd) {
		this.usrGrpCd = usrGrpCd;
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
	 * @param custInpFlg
	 */
	public void setCustInpFlg(String custInpFlg) {
		this.custInpFlg = custInpFlg;
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
	 * @param dcgoInpFlg
	 */
	public void setDcgoInpFlg(String dcgoInpFlg) {
		this.dcgoInpFlg = dcgoInpFlg;
	}
	
	/**
	 * Column Info
	 * @param inpWrkCtnt
	 */
	public void setInpWrkCtnt(String inpWrkCtnt) {
		this.inpWrkCtnt = inpWrkCtnt;
	}
	
	/**
	 * Column Info
	 * @param preSrNo
	 */
	public void setPreSrNo(String preSrNo) {
		this.preSrNo = preSrNo;
	}
	
	/**
	 * Column Info
	 * @param maxSrNo
	 */
	public void setMaxSrNo(String maxSrNo) {
		this.maxSrNo = maxSrNo;
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
	 * @param blInfoInpFlg
	 */
	public void setBlInfoInpFlg(String blInfoInpFlg) {
		this.blInfoInpFlg = blInfoInpFlg;
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
	 * @param xterRqstNo2
	 */
	public void setXterRqstNo2(String xterRqstNo2) {
		this.xterRqstNo2 = xterRqstNo2;
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
	 * @param srAmdRsnCd
	 */
	public void setSrAmdRsnCd(String srAmdRsnCd) {
		this.srAmdRsnCd = srAmdRsnCd;
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
	 * @param rtnDt
	 */
	public void setRtnDt(String rtnDt) {
		this.rtnDt = rtnDt;
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
	 * @param split
	 */
	public void setSplit(String split) {
		this.split = split;
	}
	
	/**
	 * Column Info
	 * @param preBkgNo
	 */
	public void setPreBkgNo(String preBkgNo) {
		this.preBkgNo = preBkgNo;
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
	 * @param splitFlg
	 */
	public void setSplitFlg(String splitFlg) {
		this.splitFlg = splitFlg;
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
	 * @param pndFlg
	 */
	public void setPndFlg(String pndFlg) {
		this.pndFlg = pndFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrMfInpFlg
	 */
	public void setCntrMfInpFlg(String cntrMfInpFlg) {
		this.cntrMfInpFlg = cntrMfInpFlg;
	}
	
	/**
	 * Column Info
	 * @param preSrNoAmdSeq
	 */
	public void setPreSrNoAmdSeq(String preSrNoAmdSeq) {
		this.preSrNoAmdSeq = preSrNoAmdSeq;
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
	 * @param fntOfcSndrId
	 */
	public void setFntOfcSndrId(String fntOfcSndrId) {
		this.fntOfcSndrId = fntOfcSndrId;
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
	 * Column Info
	 * @param newBkgCreFlg
	 */
	public void setNewBkgCreFlg(String newBkgCreFlg) {
		this.newBkgCreFlg = newBkgCreFlg;
	}
	
	/**
	 * Column Info
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param srKndCd
	 */
	public void setSrKndCd(String srKndCd) {
		this.srKndCd = srKndCd;
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
	 * @param fntOfcTrnsDt
	 */
	public void setFntOfcTrnsDt(String fntOfcTrnsDt) {
		this.fntOfcTrnsDt = fntOfcTrnsDt;
	}
	
	/**
	 * Column Info
	 * @param rlyPortInpFlg
	 */
	public void setRlyPortInpFlg(String rlyPortInpFlg) {
		this.rlyPortInpFlg = rlyPortInpFlg;
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
	 * @param rtWrkCtnt
	 */
	public void setRtWrkCtnt(String rtWrkCtnt) {
		this.rtWrkCtnt = rtWrkCtnt;
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
	 * @param maxHisSeq
	 */
	public void setMaxHisSeq(String maxHisSeq) {
		this.maxHisSeq = maxHisSeq;
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
	 * @param crntDt
	 */
	public void setCrntDt(String crntDt) {
		this.crntDt = crntDt;
	}
	
	/**
	 * Column Info
	 * @param crntUsrId
	 */
	public void setCrntUsrId(String crntUsrId) {
		this.crntUsrId = crntUsrId;
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
	 * @param rtnToRtnStsCd
	 */
	public void setRtnToRtnStsCd(String rtnToRtnStsCd) {
		this.rtnToRtnStsCd = rtnToRtnStsCd;
	}
	
	/**
	 * Column Info
	 * @param creFlg
	 */
	public void setCreFlg(String creFlg) {
		this.creFlg = creFlg;
	}
	
	/**
	 * Column Info
	 * @param dpcsOfcCd
	 */
	public void setDpcsOfcCd(String dpcsOfcCd) {
		this.dpcsOfcCd = dpcsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param fntOfcCd
	 */
	public void setFntOfcCd(String fntOfcCd) {
		this.fntOfcCd = fntOfcCd;
	}
	
	/**
	 * Column Info
	 * @param cntrInpFlg
	 */
	public void setCntrInpFlg(String cntrInpFlg) {
		this.cntrInpFlg = cntrInpFlg;
	}
	
	/**
	 * Column Info
	 * @param mkDescInpFlg
	 */
	public void setMkDescInpFlg(String mkDescInpFlg) {
		this.mkDescInpFlg = mkDescInpFlg;
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
	 * @param faxsvrofccd
	 */
	public void setFaxSvrOfcCd(String faxSvrOfcCd) {
		this.faxSvrOfcCd = faxSvrOfcCd;
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
	 * @param rcInpFlg
	 */
	public void setRcInpFlg(String rcInpFlg) {
		this.rcInpFlg = rcInpFlg;
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
	 * @param preNisSrNo
	 */
	public void setPreNisSrNo(String preNisSrNo) {
		this.preNisSrNo = preNisSrNo;
	}
	
	/**
	 * Column Info
	 * @param xterRqstSeq
	 */
	public void setXterRqstSeq(String xterRqstSeq) {
		this.xterRqstSeq = xterRqstSeq;
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
	 * @param srUrgCd
	 */
	public void setSrUrgCd(String srUrgCd) {
		this.srUrgCd = srUrgCd;
	}
	
	/**
	 * Column Info
	 * @param audWrkCtnt
	 */
	public void setAudWrkCtnt(String audWrkCtnt) {
		this.audWrkCtnt = audWrkCtnt;
	}
	
	/**
	 * Column Info
	 * @param xterRqstNo
	 */
	public void setXterRqstNo(String xterRqstNo) {
		this.xterRqstNo = xterRqstNo;
	}
	
	/**
	 * Column Info
	 * @param bbCgoInpFlg
	 */
	public void setBbCgoInpFlg(String bbCgoInpFlg) {
		this.bbCgoInpFlg = bbCgoInpFlg;
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
		setTotPgKnt(JSPUtil.getParameter(request, prefix + "tot_pg_knt", ""));
		setHblInfoInpFlg(JSPUtil.getParameter(request, prefix + "hbl_info_inp_flg", ""));
		setImgFileRealPath(JSPUtil.getParameter(request, prefix + "img_file_real_path", ""));
		setAmdRespbUsrId(JSPUtil.getParameter(request, prefix + "amd_respb_usr_id", ""));
		setSnaccsSrNo(JSPUtil.getParameter(request, prefix + "snaccs_sr_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSrAmdRsnSeq(JSPUtil.getParameter(request, prefix + "sr_amd_rsn_seq", ""));
		setSrRtnToStsCd(JSPUtil.getParameter(request, prefix + "sr_rtn_to_sts_cd", ""));
		setRtnToUsrId(JSPUtil.getParameter(request, prefix + "rtn_to_usr_id", ""));
		setSrDueDt(JSPUtil.getParameter(request, prefix + "sr_due_dt", ""));
		setSrCrntInfoCd(JSPUtil.getParameter(request, prefix + "sr_crnt_info_cd", ""));
		setPreSrNoAmdTpCd(JSPUtil.getParameter(request, prefix + "pre_sr_no_amd_tp_cd", ""));
		setChgInpFlg(JSPUtil.getParameter(request, prefix + "chg_inp_flg", ""));
		setAwkCgoInpFlg(JSPUtil.getParameter(request, prefix + "awk_cgo_inp_flg", ""));
		setUsrGrpCd(JSPUtil.getParameter(request, prefix + "usr_grp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCustInpFlg(JSPUtil.getParameter(request, prefix + "cust_inp_flg", ""));
		setRtnFmUsrId(JSPUtil.getParameter(request, prefix + "rtn_fm_usr_id", ""));
		setDcgoInpFlg(JSPUtil.getParameter(request, prefix + "dcgo_inp_flg", ""));
		setInpWrkCtnt(JSPUtil.getParameter(request, prefix + "inp_wrk_ctnt", ""));
		setPreSrNo(JSPUtil.getParameter(request, prefix + "pre_sr_no", ""));
		setMaxSrNo(JSPUtil.getParameter(request, prefix + "max_sr_no", ""));
		setSrWrkStsDt(JSPUtil.getParameter(request, prefix + "sr_wrk_sts_dt", ""));
		setBlInfoInpFlg(JSPUtil.getParameter(request, prefix + "bl_info_inp_flg", ""));
		setRtnFmStsCd(JSPUtil.getParameter(request, prefix + "rtn_fm_sts_cd", ""));
		setXterRqstNo2(JSPUtil.getParameter(request, prefix + "xter_rqst_no2", ""));
		setImgFileIp(JSPUtil.getParameter(request, prefix + "img_file_ip", ""));
		setSrAmdRsnCd(JSPUtil.getParameter(request, prefix + "sr_amd_rsn_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setRtnDt(JSPUtil.getParameter(request, prefix + "rtn_dt", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setSplit(JSPUtil.getParameter(request, prefix + "split", ""));
		setPreBkgNo(JSPUtil.getParameter(request, prefix + "pre_bkg_no", ""));
		setImgFileNm(JSPUtil.getParameter(request, prefix + "img_file_nm", ""));
		setSplitFlg(JSPUtil.getParameter(request, prefix + "split_flg", ""));
		setSrCrntStsCd(JSPUtil.getParameter(request, prefix + "sr_crnt_sts_cd", ""));
		setPndFlg(JSPUtil.getParameter(request, prefix + "pnd_flg", ""));
		setCntrMfInpFlg(JSPUtil.getParameter(request, prefix + "cntr_mf_inp_flg", ""));
		setPreSrNoAmdSeq(JSPUtil.getParameter(request, prefix + "pre_sr_no_amd_seq", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSrAmdSeq(JSPUtil.getParameter(request, prefix + "sr_amd_seq", ""));
		setRtnToRtnUsrId(JSPUtil.getParameter(request, prefix + "rtn_to_rtn_usr_id", ""));
		setFntOfcSndrId(JSPUtil.getParameter(request, prefix + "fnt_ofc_sndr_id", ""));
		setRcvOfcCd(JSPUtil.getParameter(request, prefix + "rcv_ofc_cd", ""));
		setImgFilePathCtnt(JSPUtil.getParameter(request, prefix + "img_file_path_ctnt", ""));
		setNewBkgCreFlg(JSPUtil.getParameter(request, prefix + "new_bkg_cre_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSrKndCd(JSPUtil.getParameter(request, prefix + "sr_knd_cd", ""));
		setSrWrkStsCd(JSPUtil.getParameter(request, prefix + "sr_wrk_sts_cd", ""));
		setSrWrkStsUsrId(JSPUtil.getParameter(request, prefix + "sr_wrk_sts_usr_id", ""));
		setFntOfcTrnsDt(JSPUtil.getParameter(request, prefix + "fnt_ofc_trns_dt", ""));
		setRlyPortInpFlg(JSPUtil.getParameter(request, prefix + "rly_port_inp_flg", ""));
		setFaxLogRefNo(JSPUtil.getParameter(request, prefix + "fax_log_ref_no", ""));
		setRtWrkCtnt(JSPUtil.getParameter(request, prefix + "rt_wrk_ctnt", ""));
		setSrAmdTpCd(JSPUtil.getParameter(request, prefix + "sr_amd_tp_cd", ""));
		setMaxHisSeq(JSPUtil.getParameter(request, prefix + "max_his_seq", ""));
		setSrAmdKndCd(JSPUtil.getParameter(request, prefix + "sr_amd_knd_cd", ""));
		setBlSplitNo(JSPUtil.getParameter(request, prefix + "bl_split_no", ""));
		setSrNo(JSPUtil.getParameter(request, prefix + "sr_no", ""));
		setCrntDt(JSPUtil.getParameter(request, prefix + "crnt_dt", ""));
		setCrntUsrId(JSPUtil.getParameter(request, prefix + "crnt_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setRtnToRtnStsCd(JSPUtil.getParameter(request, prefix + "rtn_to_rtn_sts_cd", ""));
		setCreFlg(JSPUtil.getParameter(request, prefix + "cre_flg", ""));
		setDpcsOfcCd(JSPUtil.getParameter(request, prefix + "dpcs_ofc_cd", ""));
		setFntOfcCd(JSPUtil.getParameter(request, prefix + "fnt_ofc_cd", ""));
		setCntrInpFlg(JSPUtil.getParameter(request, prefix + "cntr_inp_flg", ""));
		setMkDescInpFlg(JSPUtil.getParameter(request, prefix + "mk_desc_inp_flg", ""));
		setBlSplitTtlKnt(JSPUtil.getParameter(request, prefix + "bl_split_ttl_knt", ""));
		setFaxSvrOfcCd(JSPUtil.getParameter(request, prefix + "fax_svr_ofc_cd", ""));
		setDiffRmk(JSPUtil.getParameter(request, prefix + "diff_rmk", ""));
		setImgPgNo(JSPUtil.getParameter(request, prefix + "img_pg_no", ""));
		setRcInpFlg(JSPUtil.getParameter(request, prefix + "rc_inp_flg", ""));
		setSrAmdRsnTpCd(JSPUtil.getParameter(request, prefix + "sr_amd_rsn_tp_cd", ""));
		setPreNisSrNo(JSPUtil.getParameter(request, prefix + "pre_nis_sr_no", ""));
		setXterRqstSeq(JSPUtil.getParameter(request, prefix + "xter_rqst_seq", ""));
		setRtnToRtnDt(JSPUtil.getParameter(request, prefix + "rtn_to_rtn_dt", ""));
		setSrUrgCd(JSPUtil.getParameter(request, prefix + "sr_urg_cd", ""));
		setAudWrkCtnt(JSPUtil.getParameter(request, prefix + "aud_wrk_ctnt", ""));
		setXterRqstNo(JSPUtil.getParameter(request, prefix + "xter_rqst_no", ""));
		setBbCgoInpFlg(JSPUtil.getParameter(request, prefix + "bb_cgo_inp_flg", ""));
		setFntOfcEml(JSPUtil.getParameter(request, prefix + "fnt_ofc_eml", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DocQueueBkgHistListVO[]
	 */
	public DocQueueBkgHistListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DocQueueBkgHistListVO[]
	 */
	public DocQueueBkgHistListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DocQueueBkgHistListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] totPgKnt = (JSPUtil.getParameter(request, prefix	+ "tot_pg_knt", length));
			String[] hblInfoInpFlg = (JSPUtil.getParameter(request, prefix	+ "hbl_info_inp_flg", length));
			String[] imgFileRealPath = (JSPUtil.getParameter(request, prefix	+ "img_file_real_path", length));
			String[] amdRespbUsrId = (JSPUtil.getParameter(request, prefix	+ "amd_respb_usr_id", length));
			String[] snaccsSrNo = (JSPUtil.getParameter(request, prefix	+ "snaccs_sr_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] srAmdRsnSeq = (JSPUtil.getParameter(request, prefix	+ "sr_amd_rsn_seq", length));
			String[] srRtnToStsCd = (JSPUtil.getParameter(request, prefix	+ "sr_rtn_to_sts_cd", length));
			String[] rtnToUsrId = (JSPUtil.getParameter(request, prefix	+ "rtn_to_usr_id", length));
			String[] srDueDt = (JSPUtil.getParameter(request, prefix	+ "sr_due_dt", length));
			String[] srCrntInfoCd = (JSPUtil.getParameter(request, prefix	+ "sr_crnt_info_cd", length));
			String[] preSrNoAmdTpCd = (JSPUtil.getParameter(request, prefix	+ "pre_sr_no_amd_tp_cd", length));
			String[] chgInpFlg = (JSPUtil.getParameter(request, prefix	+ "chg_inp_flg", length));
			String[] awkCgoInpFlg = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_inp_flg", length));
			String[] usrGrpCd = (JSPUtil.getParameter(request, prefix	+ "usr_grp_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] custInpFlg = (JSPUtil.getParameter(request, prefix	+ "cust_inp_flg", length));
			String[] rtnFmUsrId = (JSPUtil.getParameter(request, prefix	+ "rtn_fm_usr_id", length));
			String[] dcgoInpFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_inp_flg", length));
			String[] inpWrkCtnt = (JSPUtil.getParameter(request, prefix	+ "inp_wrk_ctnt", length));
			String[] preSrNo = (JSPUtil.getParameter(request, prefix	+ "pre_sr_no", length));
			String[] maxSrNo = (JSPUtil.getParameter(request, prefix	+ "max_sr_no", length));
			String[] srWrkStsDt = (JSPUtil.getParameter(request, prefix	+ "sr_wrk_sts_dt", length));
			String[] blInfoInpFlg = (JSPUtil.getParameter(request, prefix	+ "bl_info_inp_flg", length));
			String[] rtnFmStsCd = (JSPUtil.getParameter(request, prefix	+ "rtn_fm_sts_cd", length));
			String[] xterRqstNo2 = (JSPUtil.getParameter(request, prefix	+ "xter_rqst_no2", length));
			String[] imgFileIp = (JSPUtil.getParameter(request, prefix	+ "img_file_ip", length));
			String[] srAmdRsnCd = (JSPUtil.getParameter(request, prefix	+ "sr_amd_rsn_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] rtnDt = (JSPUtil.getParameter(request, prefix	+ "rtn_dt", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] split = (JSPUtil.getParameter(request, prefix	+ "split", length));
			String[] preBkgNo = (JSPUtil.getParameter(request, prefix	+ "pre_bkg_no", length));
			String[] imgFileNm = (JSPUtil.getParameter(request, prefix	+ "img_file_nm", length));
			String[] splitFlg = (JSPUtil.getParameter(request, prefix	+ "split_flg", length));
			String[] srCrntStsCd = (JSPUtil.getParameter(request, prefix	+ "sr_crnt_sts_cd", length));
			String[] pndFlg = (JSPUtil.getParameter(request, prefix	+ "pnd_flg", length));
			String[] cntrMfInpFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_inp_flg", length));
			String[] preSrNoAmdSeq = (JSPUtil.getParameter(request, prefix	+ "pre_sr_no_amd_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] srAmdSeq = (JSPUtil.getParameter(request, prefix	+ "sr_amd_seq", length));
			String[] rtnToRtnUsrId = (JSPUtil.getParameter(request, prefix	+ "rtn_to_rtn_usr_id", length));
			String[] fntOfcSndrId = (JSPUtil.getParameter(request, prefix	+ "fnt_ofc_sndr_id", length));
			String[] rcvOfcCd = (JSPUtil.getParameter(request, prefix	+ "rcv_ofc_cd", length));
			String[] imgFilePathCtnt = (JSPUtil.getParameter(request, prefix	+ "img_file_path_ctnt", length));
			String[] newBkgCreFlg = (JSPUtil.getParameter(request, prefix	+ "new_bkg_cre_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] srKndCd = (JSPUtil.getParameter(request, prefix	+ "sr_knd_cd", length));
			String[] srWrkStsCd = (JSPUtil.getParameter(request, prefix	+ "sr_wrk_sts_cd", length));
			String[] srWrkStsUsrId = (JSPUtil.getParameter(request, prefix	+ "sr_wrk_sts_usr_id", length));
			String[] fntOfcTrnsDt = (JSPUtil.getParameter(request, prefix	+ "fnt_ofc_trns_dt", length));
			String[] rlyPortInpFlg = (JSPUtil.getParameter(request, prefix	+ "rly_port_inp_flg", length));
			String[] faxLogRefNo = (JSPUtil.getParameter(request, prefix	+ "fax_log_ref_no", length));
			String[] rtWrkCtnt = (JSPUtil.getParameter(request, prefix	+ "rt_wrk_ctnt", length));
			String[] srAmdTpCd = (JSPUtil.getParameter(request, prefix	+ "sr_amd_tp_cd", length));
			String[] maxHisSeq = (JSPUtil.getParameter(request, prefix	+ "max_his_seq", length));
			String[] srAmdKndCd = (JSPUtil.getParameter(request, prefix	+ "sr_amd_knd_cd", length));
			String[] blSplitNo = (JSPUtil.getParameter(request, prefix	+ "bl_split_no", length));
			String[] srNo = (JSPUtil.getParameter(request, prefix	+ "sr_no", length));
			String[] crntDt = (JSPUtil.getParameter(request, prefix	+ "crnt_dt", length));
			String[] crntUsrId = (JSPUtil.getParameter(request, prefix	+ "crnt_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] rtnToRtnStsCd = (JSPUtil.getParameter(request, prefix	+ "rtn_to_rtn_sts_cd", length));
			String[] creFlg = (JSPUtil.getParameter(request, prefix	+ "cre_flg", length));
			String[] dpcsOfcCd = (JSPUtil.getParameter(request, prefix	+ "dpcs_ofc_cd", length));
			String[] fntOfcCd = (JSPUtil.getParameter(request, prefix	+ "fnt_ofc_cd", length));
			String[] cntrInpFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_inp_flg", length));
			String[] mkDescInpFlg = (JSPUtil.getParameter(request, prefix	+ "mk_desc_inp_flg", length));
			String[] blSplitTtlKnt = (JSPUtil.getParameter(request, prefix	+ "bl_split_ttl_knt", length));
			String[] faxSvrOfcCd = (JSPUtil.getParameter(request, prefix	+ "faxSvrOfcCd", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] imgPgNo = (JSPUtil.getParameter(request, prefix	+ "img_pg_no", length));
			String[] rcInpFlg = (JSPUtil.getParameter(request, prefix	+ "rc_inp_flg", length));
			String[] srAmdRsnTpCd = (JSPUtil.getParameter(request, prefix	+ "sr_amd_rsn_tp_cd", length));
			String[] preNisSrNo = (JSPUtil.getParameter(request, prefix	+ "pre_nis_sr_no", length));
			String[] xterRqstSeq = (JSPUtil.getParameter(request, prefix	+ "xter_rqst_seq", length));
			String[] rtnToRtnDt = (JSPUtil.getParameter(request, prefix	+ "rtn_to_rtn_dt", length));
			String[] srUrgCd = (JSPUtil.getParameter(request, prefix	+ "sr_urg_cd", length));
			String[] audWrkCtnt = (JSPUtil.getParameter(request, prefix	+ "aud_wrk_ctnt", length));
			String[] xterRqstNo = (JSPUtil.getParameter(request, prefix	+ "xter_rqst_no", length));
			String[] bbCgoInpFlg = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_inp_flg", length));
			String[] fntOfcEml = (JSPUtil.getParameter(request, prefix	+ "fnt_ofc_eml", length));
			
			for (int i = 0; i < length; i++) {
				model = new DocQueueBkgHistListVO();
				if (totPgKnt[i] != null)
					model.setTotPgKnt(totPgKnt[i]);
				if (hblInfoInpFlg[i] != null)
					model.setHblInfoInpFlg(hblInfoInpFlg[i]);
				if (imgFileRealPath[i] != null)
					model.setImgFileRealPath(imgFileRealPath[i]);
				if (amdRespbUsrId[i] != null)
					model.setAmdRespbUsrId(amdRespbUsrId[i]);
				if (snaccsSrNo[i] != null)
					model.setSnaccsSrNo(snaccsSrNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (srAmdRsnSeq[i] != null)
					model.setSrAmdRsnSeq(srAmdRsnSeq[i]);
				if (srRtnToStsCd[i] != null)
					model.setSrRtnToStsCd(srRtnToStsCd[i]);
				if (rtnToUsrId[i] != null)
					model.setRtnToUsrId(rtnToUsrId[i]);
				if (srDueDt[i] != null)
					model.setSrDueDt(srDueDt[i]);
				if (srCrntInfoCd[i] != null)
					model.setSrCrntInfoCd(srCrntInfoCd[i]);
				if (preSrNoAmdTpCd[i] != null)
					model.setPreSrNoAmdTpCd(preSrNoAmdTpCd[i]);
				if (chgInpFlg[i] != null)
					model.setChgInpFlg(chgInpFlg[i]);
				if (awkCgoInpFlg[i] != null)
					model.setAwkCgoInpFlg(awkCgoInpFlg[i]);
				if (usrGrpCd[i] != null)
					model.setUsrGrpCd(usrGrpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (custInpFlg[i] != null)
					model.setCustInpFlg(custInpFlg[i]);
				if (rtnFmUsrId[i] != null)
					model.setRtnFmUsrId(rtnFmUsrId[i]);
				if (dcgoInpFlg[i] != null)
					model.setDcgoInpFlg(dcgoInpFlg[i]);
				if (inpWrkCtnt[i] != null)
					model.setInpWrkCtnt(inpWrkCtnt[i]);
				if (preSrNo[i] != null)
					model.setPreSrNo(preSrNo[i]);
				if (maxSrNo[i] != null)
					model.setMaxSrNo(maxSrNo[i]);
				if (srWrkStsDt[i] != null)
					model.setSrWrkStsDt(srWrkStsDt[i]);
				if (blInfoInpFlg[i] != null)
					model.setBlInfoInpFlg(blInfoInpFlg[i]);
				if (rtnFmStsCd[i] != null)
					model.setRtnFmStsCd(rtnFmStsCd[i]);
				if (xterRqstNo2[i] != null)
					model.setXterRqstNo2(xterRqstNo2[i]);
				if (imgFileIp[i] != null)
					model.setImgFileIp(imgFileIp[i]);
				if (srAmdRsnCd[i] != null)
					model.setSrAmdRsnCd(srAmdRsnCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (rtnDt[i] != null)
					model.setRtnDt(rtnDt[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (split[i] != null)
					model.setSplit(split[i]);
				if (preBkgNo[i] != null)
					model.setPreBkgNo(preBkgNo[i]);
				if (imgFileNm[i] != null)
					model.setImgFileNm(imgFileNm[i]);
				if (splitFlg[i] != null)
					model.setSplitFlg(splitFlg[i]);
				if (srCrntStsCd[i] != null)
					model.setSrCrntStsCd(srCrntStsCd[i]);
				if (pndFlg[i] != null)
					model.setPndFlg(pndFlg[i]);
				if (cntrMfInpFlg[i] != null)
					model.setCntrMfInpFlg(cntrMfInpFlg[i]);
				if (preSrNoAmdSeq[i] != null)
					model.setPreSrNoAmdSeq(preSrNoAmdSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (srAmdSeq[i] != null)
					model.setSrAmdSeq(srAmdSeq[i]);
				if (rtnToRtnUsrId[i] != null)
					model.setRtnToRtnUsrId(rtnToRtnUsrId[i]);
				if (fntOfcSndrId[i] != null)
					model.setFntOfcSndrId(fntOfcSndrId[i]);
				if (rcvOfcCd[i] != null)
					model.setRcvOfcCd(rcvOfcCd[i]);
				if (imgFilePathCtnt[i] != null)
					model.setImgFilePathCtnt(imgFilePathCtnt[i]);
				if (newBkgCreFlg[i] != null)
					model.setNewBkgCreFlg(newBkgCreFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (srKndCd[i] != null)
					model.setSrKndCd(srKndCd[i]);
				if (srWrkStsCd[i] != null)
					model.setSrWrkStsCd(srWrkStsCd[i]);
				if (srWrkStsUsrId[i] != null)
					model.setSrWrkStsUsrId(srWrkStsUsrId[i]);
				if (fntOfcTrnsDt[i] != null)
					model.setFntOfcTrnsDt(fntOfcTrnsDt[i]);
				if (rlyPortInpFlg[i] != null)
					model.setRlyPortInpFlg(rlyPortInpFlg[i]);
				if (faxLogRefNo[i] != null)
					model.setFaxLogRefNo(faxLogRefNo[i]);
				if (rtWrkCtnt[i] != null)
					model.setRtWrkCtnt(rtWrkCtnt[i]);
				if (srAmdTpCd[i] != null)
					model.setSrAmdTpCd(srAmdTpCd[i]);
				if (maxHisSeq[i] != null)
					model.setMaxHisSeq(maxHisSeq[i]);
				if (srAmdKndCd[i] != null)
					model.setSrAmdKndCd(srAmdKndCd[i]);
				if (blSplitNo[i] != null)
					model.setBlSplitNo(blSplitNo[i]);
				if (srNo[i] != null)
					model.setSrNo(srNo[i]);
				if (crntDt[i] != null)
					model.setCrntDt(crntDt[i]);
				if (crntUsrId[i] != null)
					model.setCrntUsrId(crntUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (rtnToRtnStsCd[i] != null)
					model.setRtnToRtnStsCd(rtnToRtnStsCd[i]);
				if (creFlg[i] != null)
					model.setCreFlg(creFlg[i]);
				if (dpcsOfcCd[i] != null)
					model.setDpcsOfcCd(dpcsOfcCd[i]);
				if (fntOfcCd[i] != null)
					model.setFntOfcCd(fntOfcCd[i]);
				if (cntrInpFlg[i] != null)
					model.setCntrInpFlg(cntrInpFlg[i]);
				if (mkDescInpFlg[i] != null)
					model.setMkDescInpFlg(mkDescInpFlg[i]);
				if (blSplitTtlKnt[i] != null)
					model.setBlSplitTtlKnt(blSplitTtlKnt[i]);
				if (faxSvrOfcCd[i] != null)
					model.setFaxSvrOfcCd(faxSvrOfcCd[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (imgPgNo[i] != null)
					model.setImgPgNo(imgPgNo[i]);
				if (rcInpFlg[i] != null)
					model.setRcInpFlg(rcInpFlg[i]);
				if (srAmdRsnTpCd[i] != null)
					model.setSrAmdRsnTpCd(srAmdRsnTpCd[i]);
				if (preNisSrNo[i] != null)
					model.setPreNisSrNo(preNisSrNo[i]);
				if (xterRqstSeq[i] != null)
					model.setXterRqstSeq(xterRqstSeq[i]);
				if (rtnToRtnDt[i] != null)
					model.setRtnToRtnDt(rtnToRtnDt[i]);
				if (srUrgCd[i] != null)
					model.setSrUrgCd(srUrgCd[i]);
				if (audWrkCtnt[i] != null)
					model.setAudWrkCtnt(audWrkCtnt[i]);
				if (xterRqstNo[i] != null)
					model.setXterRqstNo(xterRqstNo[i]);
				if (bbCgoInpFlg[i] != null)
					model.setBbCgoInpFlg(bbCgoInpFlg[i]);
				if (fntOfcEml[i] != null)
					model.setFntOfcEml(fntOfcEml[i]);				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDocQueueBkgHistListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DocQueueBkgHistListVO[]
	 */
	public DocQueueBkgHistListVO[] getDocQueueBkgHistListVOs(){
		DocQueueBkgHistListVO[] vos = (DocQueueBkgHistListVO[])models.toArray(new DocQueueBkgHistListVO[models.size()]);
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
		this.totPgKnt = this.totPgKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hblInfoInpFlg = this.hblInfoInpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imgFileRealPath = this.imgFileRealPath .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdRespbUsrId = this.amdRespbUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.snaccsSrNo = this.snaccsSrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srAmdRsnSeq = this.srAmdRsnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srRtnToStsCd = this.srRtnToStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnToUsrId = this.rtnToUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srDueDt = this.srDueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srCrntInfoCd = this.srCrntInfoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preSrNoAmdTpCd = this.preSrNoAmdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgInpFlg = this.chgInpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoInpFlg = this.awkCgoInpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrGrpCd = this.usrGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custInpFlg = this.custInpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnFmUsrId = this.rtnFmUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoInpFlg = this.dcgoInpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpWrkCtnt = this.inpWrkCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preSrNo = this.preSrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxSrNo = this.maxSrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srWrkStsDt = this.srWrkStsDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blInfoInpFlg = this.blInfoInpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnFmStsCd = this.rtnFmStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRqstNo2 = this.xterRqstNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imgFileIp = this.imgFileIp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srAmdRsnCd = this.srAmdRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnDt = this.rtnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.split = this.split .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preBkgNo = this.preBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imgFileNm = this.imgFileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splitFlg = this.splitFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srCrntStsCd = this.srCrntStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pndFlg = this.pndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfInpFlg = this.cntrMfInpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preSrNoAmdSeq = this.preSrNoAmdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srAmdSeq = this.srAmdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnToRtnUsrId = this.rtnToRtnUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fntOfcSndrId = this.fntOfcSndrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvOfcCd = this.rcvOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imgFilePathCtnt = this.imgFilePathCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newBkgCreFlg = this.newBkgCreFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srKndCd = this.srKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srWrkStsCd = this.srWrkStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srWrkStsUsrId = this.srWrkStsUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fntOfcTrnsDt = this.fntOfcTrnsDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlyPortInpFlg = this.rlyPortInpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxLogRefNo = this.faxLogRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtWrkCtnt = this.rtWrkCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srAmdTpCd = this.srAmdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxHisSeq = this.maxHisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srAmdKndCd = this.srAmdKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSplitNo = this.blSplitNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srNo = this.srNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntDt = this.crntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntUsrId = this.crntUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnToRtnStsCd = this.rtnToRtnStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creFlg = this.creFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpcsOfcCd = this.dpcsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fntOfcCd = this.fntOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrInpFlg = this.cntrInpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mkDescInpFlg = this.mkDescInpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSplitTtlKnt = this.blSplitTtlKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSvrOfcCd = this.faxSvrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imgPgNo = this.imgPgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcInpFlg = this.rcInpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srAmdRsnTpCd = this.srAmdRsnTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preNisSrNo = this.preNisSrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRqstSeq = this.xterRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnToRtnDt = this.rtnToRtnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srUrgCd = this.srUrgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.audWrkCtnt = this.audWrkCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRqstNo = this.xterRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoInpFlg = this.bbCgoInpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fntOfcEml = this.fntOfcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
