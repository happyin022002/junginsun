/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OpfStvDmgCreateVO.java
*@FileTitle : OpfStvDmgCreateVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.18
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.11.18 장석현 
* 1.0 Creation
* 2011.04.01 공창식 [CHM-201109535-01] SDMS Damage Creation 변경 요청사항
=========================================================*/

package com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo;

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
 * @author 장석현
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OpfStvDmgCreateVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OpfStvDmgCreateVO> models = new ArrayList<OpfStvDmgCreateVO>();
	
	/* Column Info */
	private String stvDmgDocAtchKnt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String vslOshpCntrBlkTpCd = null;
	/* Column Info */
	private String vslOshpCntrBlkTpDesc = null;
	/* Column Info */
	private String stvDmgPictAtchFlg = null;
	/* Column Info */
	private String stvDmgLocDesc = null;
	/* Column Info */
	private String stvDmgDocAtchFlg = null;
	/* Column Info */
	private String stvDmgRespbCd = null;
	/* Column Info */
	private String stvDmgRespbPtyKwnCd = null;
	/* Column Info */
	private String fmTmLssDt = null;
	/* Column Info */
	private String stvDmgPictAtchKnt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* Column Info */
	private String cntrDmgFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String reqSkdVoyNo = null;
	/* Column Info */
	private String stepCnt = null;
	/* Column Info */
	private String reqPortCd = null;
	/* Column Info */
	private String stvDmgRespbDesc = null;
	/* Column Info */
	private String stvDmgQttnRsnDesc = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String stvDmgReqCateCd = null;
	/* Column Info */
	private String stvDmgRmk = null;
	/* Column Info */
	private String stvDmgRptAtchFlg = null;
	/* Column Info */
	private String stvDmgQttnCd = null;
	/* Column Info */
	private String stvDmgPrtCateCd = null;
	/* Column Info */
	private String stvDmgRptAtchKnt = null;
	/* Column Info */
	private String dmgAuthStsCd = null;
	/* Column Info */
	private String authDt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String toTmLssDt = null;
	/* Column Info */
	private String cgoDmgFlg = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String dmgEmlSndNo = null;
	/* Column Info */
	private String stvDmgRefNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String stvDmgTpCd = null;
	/* Column Info */
	private String reqSkdDirCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String clmHndlOfcCd = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String stvDmgEvntDt = null;
	/* Column Info */
	private String reqEtaDt = null;
	/* Column Info */
	private String authUsrId = null;
	/* Column Info */
	private String stvDmgNo = null;
	/* Column Info */
	private String creUsrOfc = null;
	/* Column Info */
	private String stvDmgPrtCd = null;
	/* Column Info */
	private String reqVslCd = null;
	/* Column Info */
	private String vslSlanCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OpfStvDmgCreateVO() {}

	public OpfStvDmgCreateVO(String ibflag, String pagerows, String stvDmgNo, String vslCd, String skdVoyNo, String skdDirCd, String vpsPortCd, String stvDmgEvntDt, String vslOshpCntrBlkTpCd, String vslOshpCntrBlkTpDesc, String stvDmgRefNo, String clmHndlOfcCd, String dmgAuthStsCd, String authUsrId, String authDt, String creUsrId, String updUsrId, String creUsrOfc, String stvDmgPrtCateCd, String stvDmgPrtCd, String stvDmgTpCd, String stvDmgLocDesc, String stvDmgRptAtchFlg, String stvDmgPictAtchFlg, String stvDmgDocAtchFlg, String cntrDmgFlg, String cgoDmgFlg, String cntrNo, String fmTmLssDt, String toTmLssDt, String stvDmgRmk, String stvDmgReqCateCd, String reqVslCd, String vslSlanCd, String reqSkdVoyNo, String reqSkdDirCd, String reqPortCd, String reqEtaDt, String stvDmgQttnCd, String stvDmgQttnRsnDesc, String stvDmgRespbPtyKwnCd, String stvDmgRespbCd, String stvDmgRespbDesc, String dmgEmlSndNo, String stepCnt, String stvDmgRptAtchKnt, String stvDmgPictAtchKnt, String stvDmgDocAtchKnt, String seq) {
		this.stvDmgDocAtchKnt = stvDmgDocAtchKnt;
		this.vslCd = vslCd;
		this.vslOshpCntrBlkTpCd = vslOshpCntrBlkTpCd;
		this.vslOshpCntrBlkTpDesc = vslOshpCntrBlkTpDesc;
		this.stvDmgPictAtchFlg = stvDmgPictAtchFlg;
		this.stvDmgLocDesc = stvDmgLocDesc;
		this.stvDmgDocAtchFlg = stvDmgDocAtchFlg;
		this.stvDmgRespbCd = stvDmgRespbCd;
		this.stvDmgRespbPtyKwnCd = stvDmgRespbPtyKwnCd;
		this.fmTmLssDt = fmTmLssDt;
		this.stvDmgPictAtchKnt = stvDmgPictAtchKnt;
		this.pagerows = pagerows;
		this.vpsPortCd = vpsPortCd;
		this.cntrDmgFlg = cntrDmgFlg;
		this.ibflag = ibflag;
		this.reqSkdVoyNo = reqSkdVoyNo;
		this.stepCnt = stepCnt;
		this.reqPortCd = reqPortCd;
		this.stvDmgRespbDesc = stvDmgRespbDesc;
		this.stvDmgQttnRsnDesc = stvDmgQttnRsnDesc;
		this.updUsrId = updUsrId;
		this.stvDmgReqCateCd = stvDmgReqCateCd;
		this.stvDmgRmk = stvDmgRmk;
		this.stvDmgRptAtchFlg = stvDmgRptAtchFlg;
		this.stvDmgQttnCd = stvDmgQttnCd;
		this.stvDmgPrtCateCd = stvDmgPrtCateCd;
		this.stvDmgRptAtchKnt = stvDmgRptAtchKnt;
		this.dmgAuthStsCd = dmgAuthStsCd;
		this.authDt = authDt;
		this.skdVoyNo = skdVoyNo;
		this.toTmLssDt = toTmLssDt;
		this.cgoDmgFlg = cgoDmgFlg;
		this.skdDirCd = skdDirCd;
		this.dmgEmlSndNo = dmgEmlSndNo;
		this.stvDmgRefNo = stvDmgRefNo;
		this.creUsrId = creUsrId;
		this.stvDmgTpCd = stvDmgTpCd;
		this.reqSkdDirCd = reqSkdDirCd;
		this.cntrNo = cntrNo;
		this.clmHndlOfcCd = clmHndlOfcCd;
		this.seq = seq;
		this.stvDmgEvntDt = stvDmgEvntDt;
		this.reqEtaDt = reqEtaDt;
		this.authUsrId = authUsrId;
		this.stvDmgNo = stvDmgNo;
		this.creUsrOfc = creUsrOfc;
		this.stvDmgPrtCd = stvDmgPrtCd;
		this.reqVslCd = reqVslCd;
		this.vslSlanCd = vslSlanCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("stv_dmg_doc_atch_knt", getStvDmgDocAtchKnt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("vsl_oshp_cntr_blk_tp_cd", getVslOshpCntrBlkTpCd());
		this.hashColumns.put("vsl_oshp_cntr_blk_tp_desc", getVslOshpCntrBlkTpDesc());
		this.hashColumns.put("stv_dmg_pict_atch_flg", getStvDmgPictAtchFlg());
		this.hashColumns.put("stv_dmg_loc_desc", getStvDmgLocDesc());
		this.hashColumns.put("stv_dmg_doc_atch_flg", getStvDmgDocAtchFlg());
		this.hashColumns.put("stv_dmg_respb_cd", getStvDmgRespbCd());
		this.hashColumns.put("stv_dmg_respb_pty_kwn_cd", getStvDmgRespbPtyKwnCd());
		this.hashColumns.put("fm_tm_lss_dt", getFmTmLssDt());
		this.hashColumns.put("stv_dmg_pict_atch_knt", getStvDmgPictAtchKnt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("cntr_dmg_flg", getCntrDmgFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("req_skd_voy_no", getReqSkdVoyNo());
		this.hashColumns.put("step_cnt", getStepCnt());
		this.hashColumns.put("req_port_cd", getReqPortCd());
		this.hashColumns.put("stv_dmg_respb_desc", getStvDmgRespbDesc());
		this.hashColumns.put("stv_dmg_qttn_rsn_desc", getStvDmgQttnRsnDesc());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("stv_dmg_req_cate_cd", getStvDmgReqCateCd());
		this.hashColumns.put("stv_dmg_rmk", getStvDmgRmk());
		this.hashColumns.put("stv_dmg_rpt_atch_flg", getStvDmgRptAtchFlg());
		this.hashColumns.put("stv_dmg_qttn_cd", getStvDmgQttnCd());
		this.hashColumns.put("stv_dmg_prt_cate_cd", getStvDmgPrtCateCd());
		this.hashColumns.put("stv_dmg_rpt_atch_knt", getStvDmgRptAtchKnt());
		this.hashColumns.put("dmg_auth_sts_cd", getDmgAuthStsCd());
		this.hashColumns.put("auth_dt", getAuthDt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("to_tm_lss_dt", getToTmLssDt());
		this.hashColumns.put("cgo_dmg_flg", getCgoDmgFlg());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("dmg_eml_snd_no", getDmgEmlSndNo());
		this.hashColumns.put("stv_dmg_ref_no", getStvDmgRefNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("stv_dmg_tp_cd", getStvDmgTpCd());
		this.hashColumns.put("req_skd_dir_cd", getReqSkdDirCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("clm_hndl_ofc_cd", getClmHndlOfcCd());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("stv_dmg_evnt_dt", getStvDmgEvntDt());
		this.hashColumns.put("req_eta_dt", getReqEtaDt());
		this.hashColumns.put("auth_usr_id", getAuthUsrId());
		this.hashColumns.put("stv_dmg_no", getStvDmgNo());
		this.hashColumns.put("cre_usr_ofc", getCreUsrOfc());
		this.hashColumns.put("stv_dmg_prt_cd", getStvDmgPrtCd());
		this.hashColumns.put("req_vsl_cd", getReqVslCd());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("stv_dmg_doc_atch_knt", "stvDmgDocAtchKnt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vsl_oshp_cntr_blk_tp_cd", "vslOshpCntrBlkTpCd");
		this.hashFields.put("vsl_oshp_cntr_blk_tp_desc", "vslOshpCntrBlkTpDesc");
		this.hashFields.put("stv_dmg_pict_atch_flg", "stvDmgPictAtchFlg");
		this.hashFields.put("stv_dmg_loc_desc", "stvDmgLocDesc");
		this.hashFields.put("stv_dmg_doc_atch_flg", "stvDmgDocAtchFlg");
		this.hashFields.put("stv_dmg_respb_cd", "stvDmgRespbCd");
		this.hashFields.put("stv_dmg_respb_pty_kwn_cd", "stvDmgRespbPtyKwnCd");
		this.hashFields.put("fm_tm_lss_dt", "fmTmLssDt");
		this.hashFields.put("stv_dmg_pict_atch_knt", "stvDmgPictAtchKnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("cntr_dmg_flg", "cntrDmgFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("req_skd_voy_no", "reqSkdVoyNo");
		this.hashFields.put("step_cnt", "stepCnt");
		this.hashFields.put("req_port_cd", "reqPortCd");
		this.hashFields.put("stv_dmg_respb_desc", "stvDmgRespbDesc");
		this.hashFields.put("stv_dmg_qttn_rsn_desc", "stvDmgQttnRsnDesc");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("stv_dmg_req_cate_cd", "stvDmgReqCateCd");
		this.hashFields.put("stv_dmg_rmk", "stvDmgRmk");
		this.hashFields.put("stv_dmg_rpt_atch_flg", "stvDmgRptAtchFlg");
		this.hashFields.put("stv_dmg_qttn_cd", "stvDmgQttnCd");
		this.hashFields.put("stv_dmg_prt_cate_cd", "stvDmgPrtCateCd");
		this.hashFields.put("stv_dmg_rpt_atch_knt", "stvDmgRptAtchKnt");
		this.hashFields.put("dmg_auth_sts_cd", "dmgAuthStsCd");
		this.hashFields.put("auth_dt", "authDt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("to_tm_lss_dt", "toTmLssDt");
		this.hashFields.put("cgo_dmg_flg", "cgoDmgFlg");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("dmg_eml_snd_no", "dmgEmlSndNo");
		this.hashFields.put("stv_dmg_ref_no", "stvDmgRefNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("stv_dmg_tp_cd", "stvDmgTpCd");
		this.hashFields.put("req_skd_dir_cd", "reqSkdDirCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("clm_hndl_ofc_cd", "clmHndlOfcCd");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("stv_dmg_evnt_dt", "stvDmgEvntDt");
		this.hashFields.put("req_eta_dt", "reqEtaDt");
		this.hashFields.put("auth_usr_id", "authUsrId");
		this.hashFields.put("stv_dmg_no", "stvDmgNo");
		this.hashFields.put("cre_usr_ofc", "creUsrOfc");
		this.hashFields.put("stv_dmg_prt_cd", "stvDmgPrtCd");
		this.hashFields.put("req_vsl_cd", "reqVslCd");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return stvDmgDocAtchKnt
	 */
	public String getStvDmgDocAtchKnt() {
		return this.stvDmgDocAtchKnt;
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
	 * @return vslOshpCntrBlkTpCd
	 */
	public String getVslOshpCntrBlkTpCd() {
		return this.vslOshpCntrBlkTpCd;
	}
	
	/**
	 * Column Info
	 * @return vslOshpCntrBlkTpDesc
	 */
	public String getVslOshpCntrBlkTpDesc() {
		return this.vslOshpCntrBlkTpDesc;
	}
	
	/**
	 * Column Info
	 * @return stvDmgPictAtchFlg
	 */
	public String getStvDmgPictAtchFlg() {
		return this.stvDmgPictAtchFlg;
	}
	
	/**
	 * Column Info
	 * @return stvDmgLocDesc
	 */
	public String getStvDmgLocDesc() {
		return this.stvDmgLocDesc;
	}
	
	/**
	 * Column Info
	 * @return stvDmgDocAtchFlg
	 */
	public String getStvDmgDocAtchFlg() {
		return this.stvDmgDocAtchFlg;
	}
	
	/**
	 * Column Info
	 * @return stvDmgRespbCd
	 */
	public String getStvDmgRespbCd() {
		return this.stvDmgRespbCd;
	}
	
	/**
	 * Column Info
	 * @return stvDmgRespbPtyKwnCd
	 */
	public String getStvDmgRespbPtyKwnCd() {
		return this.stvDmgRespbPtyKwnCd;
	}
	
	/**
	 * Column Info
	 * @return fmTmLssDt
	 */
	public String getFmTmLssDt() {
		return this.fmTmLssDt;
	}
	
	/**
	 * Column Info
	 * @return stvDmgPictAtchKnt
	 */
	public String getStvDmgPictAtchKnt() {
		return this.stvDmgPictAtchKnt;
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
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @return cntrDmgFlg
	 */
	public String getCntrDmgFlg() {
		return this.cntrDmgFlg;
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
	 * @return reqSkdVoyNo
	 */
	public String getReqSkdVoyNo() {
		return this.reqSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return stepCnt
	 */
	public String getStepCnt() {
		return this.stepCnt;
	}
	
	/**
	 * Column Info
	 * @return reqPortCd
	 */
	public String getReqPortCd() {
		return this.reqPortCd;
	}
	
	/**
	 * Column Info
	 * @return stvDmgRespbDesc
	 */
	public String getStvDmgRespbDesc() {
		return this.stvDmgRespbDesc;
	}
	
	/**
	 * Column Info
	 * @return stvDmgQttnRsnDesc
	 */
	public String getStvDmgQttnRsnDesc() {
		return this.stvDmgQttnRsnDesc;
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
	 * @return stvDmgReqCateCd
	 */
	public String getStvDmgReqCateCd() {
		return this.stvDmgReqCateCd;
	}
	
	/**
	 * Column Info
	 * @return stvDmgRmk
	 */
	public String getStvDmgRmk() {
		return this.stvDmgRmk;
	}
	
	/**
	 * Column Info
	 * @return stvDmgRptAtchFlg
	 */
	public String getStvDmgRptAtchFlg() {
		return this.stvDmgRptAtchFlg;
	}
	
	/**
	 * Column Info
	 * @return stvDmgQttnCd
	 */
	public String getStvDmgQttnCd() {
		return this.stvDmgQttnCd;
	}
	
	/**
	 * Column Info
	 * @return stvDmgPrtCateCd
	 */
	public String getStvDmgPrtCateCd() {
		return this.stvDmgPrtCateCd;
	}
	
	/**
	 * Column Info
	 * @return stvDmgRptAtchKnt
	 */
	public String getStvDmgRptAtchKnt() {
		return this.stvDmgRptAtchKnt;
	}
	
	/**
	 * Column Info
	 * @return dmgAuthStsCd
	 */
	public String getDmgAuthStsCd() {
		return this.dmgAuthStsCd;
	}
	
	/**
	 * Column Info
	 * @return authDt
	 */
	public String getAuthDt() {
		return this.authDt;
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
	 * @return toTmLssDt
	 */
	public String getToTmLssDt() {
		return this.toTmLssDt;
	}
	
	/**
	 * Column Info
	 * @return cgoDmgFlg
	 */
	public String getCgoDmgFlg() {
		return this.cgoDmgFlg;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return dmgEmlSndNo
	 */
	public String getDmgEmlSndNo() {
		return this.dmgEmlSndNo;
	}
	
	/**
	 * Column Info
	 * @return stvDmgRefNo
	 */
	public String getStvDmgRefNo() {
		return this.stvDmgRefNo;
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
	 * @return stvDmgTpCd
	 */
	public String getStvDmgTpCd() {
		return this.stvDmgTpCd;
	}
	
	/**
	 * Column Info
	 * @return reqSkdDirCd
	 */
	public String getReqSkdDirCd() {
		return this.reqSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return clmHndlOfcCd
	 */
	public String getClmHndlOfcCd() {
		return this.clmHndlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return stvDmgEvntDt
	 */
	public String getStvDmgEvntDt() {
		return this.stvDmgEvntDt;
	}
	
	/**
	 * Column Info
	 * @return reqEtaDt
	 */
	public String getReqEtaDt() {
		return this.reqEtaDt;
	}
	
	/**
	 * Column Info
	 * @return authUsrId
	 */
	public String getAuthUsrId() {
		return this.authUsrId;
	}
	
	/**
	 * Column Info
	 * @return stvDmgNo
	 */
	public String getStvDmgNo() {
		return this.stvDmgNo;
	}
	
	/**
	 * Column Info
	 * @return creUsrOfc
	 */
	public String getCreUsrOfc() {
		return this.creUsrOfc;
	}
	
	/**
	 * Column Info
	 * @return stvDmgPrtCd
	 */
	public String getStvDmgPrtCd() {
		return this.stvDmgPrtCd;
	}
	
	/**
	 * Column Info
	 * @return reqVslCd
	 */
	public String getReqVslCd() {
		return this.reqVslCd;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
	}
	

	/**
	 * Column Info
	 * @param stvDmgDocAtchKnt
	 */
	public void setStvDmgDocAtchKnt(String stvDmgDocAtchKnt) {
		this.stvDmgDocAtchKnt = stvDmgDocAtchKnt;
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
	 * @param vslOshpCntrBlkTpCd
	 */
	public void setVslOshpCntrBlkTpCd(String vslOshpCntrBlkTpCd) {
		this.vslOshpCntrBlkTpCd = vslOshpCntrBlkTpCd;
	}
	
	/**
	 * Column Info
	 * @param vslOshpCntrBlkTpDesc
	 */
	public void setVslOshpCntrBlkTpDesc(String vslOshpCntrBlkTpDesc) {
		this.vslOshpCntrBlkTpDesc = vslOshpCntrBlkTpDesc;
	}
	
	/**
	 * Column Info
	 * @param stvDmgPictAtchFlg
	 */
	public void setStvDmgPictAtchFlg(String stvDmgPictAtchFlg) {
		this.stvDmgPictAtchFlg = stvDmgPictAtchFlg;
	}
	
	/**
	 * Column Info
	 * @param stvDmgLocDesc
	 */
	public void setStvDmgLocDesc(String stvDmgLocDesc) {
		this.stvDmgLocDesc = stvDmgLocDesc;
	}
	
	/**
	 * Column Info
	 * @param stvDmgDocAtchFlg
	 */
	public void setStvDmgDocAtchFlg(String stvDmgDocAtchFlg) {
		this.stvDmgDocAtchFlg = stvDmgDocAtchFlg;
	}
	
	/**
	 * Column Info
	 * @param stvDmgRespbCd
	 */
	public void setStvDmgRespbCd(String stvDmgRespbCd) {
		this.stvDmgRespbCd = stvDmgRespbCd;
	}
	
	/**
	 * Column Info
	 * @param stvDmgRespbPtyKwnCd
	 */
	public void setStvDmgRespbPtyKwnCd(String stvDmgRespbPtyKwnCd) {
		this.stvDmgRespbPtyKwnCd = stvDmgRespbPtyKwnCd;
	}
	
	/**
	 * Column Info
	 * @param fmTmLssDt
	 */
	public void setFmTmLssDt(String fmTmLssDt) {
		this.fmTmLssDt = fmTmLssDt;
	}
	
	/**
	 * Column Info
	 * @param stvDmgPictAtchKnt
	 */
	public void setStvDmgPictAtchKnt(String stvDmgPictAtchKnt) {
		this.stvDmgPictAtchKnt = stvDmgPictAtchKnt;
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
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @param cntrDmgFlg
	 */
	public void setCntrDmgFlg(String cntrDmgFlg) {
		this.cntrDmgFlg = cntrDmgFlg;
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
	 * @param reqSkdVoyNo
	 */
	public void setReqSkdVoyNo(String reqSkdVoyNo) {
		this.reqSkdVoyNo = reqSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param stepCnt
	 */
	public void setStepCnt(String stepCnt) {
		this.stepCnt = stepCnt;
	}
	
	/**
	 * Column Info
	 * @param reqPortCd
	 */
	public void setReqPortCd(String reqPortCd) {
		this.reqPortCd = reqPortCd;
	}
	
	/**
	 * Column Info
	 * @param stvDmgRespbDesc
	 */
	public void setStvDmgRespbDesc(String stvDmgRespbDesc) {
		this.stvDmgRespbDesc = stvDmgRespbDesc;
	}
	
	/**
	 * Column Info
	 * @param stvDmgQttnRsnDesc
	 */
	public void setStvDmgQttnRsnDesc(String stvDmgQttnRsnDesc) {
		this.stvDmgQttnRsnDesc = stvDmgQttnRsnDesc;
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
	 * @param stvDmgReqCateCd
	 */
	public void setStvDmgReqCateCd(String stvDmgReqCateCd) {
		this.stvDmgReqCateCd = stvDmgReqCateCd;
	}
	
	/**
	 * Column Info
	 * @param stvDmgRmk
	 */
	public void setStvDmgRmk(String stvDmgRmk) {
		this.stvDmgRmk = stvDmgRmk;
	}
	
	/**
	 * Column Info
	 * @param stvDmgRptAtchFlg
	 */
	public void setStvDmgRptAtchFlg(String stvDmgRptAtchFlg) {
		this.stvDmgRptAtchFlg = stvDmgRptAtchFlg;
	}
	
	/**
	 * Column Info
	 * @param stvDmgQttnCd
	 */
	public void setStvDmgQttnCd(String stvDmgQttnCd) {
		this.stvDmgQttnCd = stvDmgQttnCd;
	}
	
	/**
	 * Column Info
	 * @param stvDmgPrtCateCd
	 */
	public void setStvDmgPrtCateCd(String stvDmgPrtCateCd) {
		this.stvDmgPrtCateCd = stvDmgPrtCateCd;
	}
	
	/**
	 * Column Info
	 * @param stvDmgRptAtchKnt
	 */
	public void setStvDmgRptAtchKnt(String stvDmgRptAtchKnt) {
		this.stvDmgRptAtchKnt = stvDmgRptAtchKnt;
	}
	
	/**
	 * Column Info
	 * @param dmgAuthStsCd
	 */
	public void setDmgAuthStsCd(String dmgAuthStsCd) {
		this.dmgAuthStsCd = dmgAuthStsCd;
	}
	
	/**
	 * Column Info
	 * @param authDt
	 */
	public void setAuthDt(String authDt) {
		this.authDt = authDt;
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
	 * @param toTmLssDt
	 */
	public void setToTmLssDt(String toTmLssDt) {
		this.toTmLssDt = toTmLssDt;
	}
	
	/**
	 * Column Info
	 * @param cgoDmgFlg
	 */
	public void setCgoDmgFlg(String cgoDmgFlg) {
		this.cgoDmgFlg = cgoDmgFlg;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param dmgEmlSndNo
	 */
	public void setDmgEmlSndNo(String dmgEmlSndNo) {
		this.dmgEmlSndNo = dmgEmlSndNo;
	}
	
	/**
	 * Column Info
	 * @param stvDmgRefNo
	 */
	public void setStvDmgRefNo(String stvDmgRefNo) {
		this.stvDmgRefNo = stvDmgRefNo;
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
	 * @param stvDmgTpCd
	 */
	public void setStvDmgTpCd(String stvDmgTpCd) {
		this.stvDmgTpCd = stvDmgTpCd;
	}
	
	/**
	 * Column Info
	 * @param reqSkdDirCd
	 */
	public void setReqSkdDirCd(String reqSkdDirCd) {
		this.reqSkdDirCd = reqSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param clmHndlOfcCd
	 */
	public void setClmHndlOfcCd(String clmHndlOfcCd) {
		this.clmHndlOfcCd = clmHndlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param stvDmgEvntDt
	 */
	public void setStvDmgEvntDt(String stvDmgEvntDt) {
		this.stvDmgEvntDt = stvDmgEvntDt;
	}
	
	/**
	 * Column Info
	 * @param reqEtaDt
	 */
	public void setReqEtaDt(String reqEtaDt) {
		this.reqEtaDt = reqEtaDt;
	}
	
	/**
	 * Column Info
	 * @param authUsrId
	 */
	public void setAuthUsrId(String authUsrId) {
		this.authUsrId = authUsrId;
	}
	
	/**
	 * Column Info
	 * @param stvDmgNo
	 */
	public void setStvDmgNo(String stvDmgNo) {
		this.stvDmgNo = stvDmgNo;
	}
	
	/**
	 * Column Info
	 * @param creUsrOfc
	 */
	public void setCreUsrOfc(String creUsrOfc) {
		this.creUsrOfc = creUsrOfc;
	}
	
	/**
	 * Column Info
	 * @param stvDmgPrtCd
	 */
	public void setStvDmgPrtCd(String stvDmgPrtCd) {
		this.stvDmgPrtCd = stvDmgPrtCd;
	}
	
	/**
	 * Column Info
	 * @param reqVslCd
	 */
	public void setReqVslCd(String reqVslCd) {
		this.reqVslCd = reqVslCd;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setStvDmgDocAtchKnt(JSPUtil.getParameter(request, "stv_dmg_doc_atch_knt", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setVslOshpCntrBlkTpCd(JSPUtil.getParameter(request, "vsl_oshp_cntr_blk_tp_cd", ""));
		setVslOshpCntrBlkTpDesc(JSPUtil.getParameter(request, "vsl_oshp_cntr_blk_tp_desc", ""));
		setStvDmgPictAtchFlg(JSPUtil.getParameter(request, "stv_dmg_pict_atch_flg", ""));
		setStvDmgLocDesc(JSPUtil.getParameter(request, "stv_dmg_loc_desc", ""));
		setStvDmgDocAtchFlg(JSPUtil.getParameter(request, "stv_dmg_doc_atch_flg", ""));
		setStvDmgRespbCd(JSPUtil.getParameter(request, "stv_dmg_respb_cd", ""));
		setStvDmgRespbPtyKwnCd(JSPUtil.getParameter(request, "stv_dmg_respb_pty_kwn_cd", ""));
		setFmTmLssDt(JSPUtil.getParameter(request, "fm_tm_lss_dt", ""));
		setStvDmgPictAtchKnt(JSPUtil.getParameter(request, "stv_dmg_pict_atch_knt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVpsPortCd(JSPUtil.getParameter(request, "vps_port_cd", ""));
		setCntrDmgFlg(JSPUtil.getParameter(request, "cntr_dmg_flg", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setReqSkdVoyNo(JSPUtil.getParameter(request, "req_skd_voy_no", ""));
		setStepCnt(JSPUtil.getParameter(request, "step_cnt", ""));
		setReqPortCd(JSPUtil.getParameter(request, "req_port_cd", ""));
		setStvDmgRespbDesc(JSPUtil.getParameter(request, "stv_dmg_respb_desc", ""));
		setStvDmgQttnRsnDesc(JSPUtil.getParameter(request, "stv_dmg_qttn_rsn_desc", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setStvDmgReqCateCd(JSPUtil.getParameter(request, "stv_dmg_req_cate_cd", ""));
		setStvDmgRmk(JSPUtil.getParameter(request, "stv_dmg_rmk", ""));
		setStvDmgRptAtchFlg(JSPUtil.getParameter(request, "stv_dmg_rpt_atch_flg", ""));
		setStvDmgQttnCd(JSPUtil.getParameter(request, "stv_dmg_qttn_cd", ""));
		setStvDmgPrtCateCd(JSPUtil.getParameter(request, "stv_dmg_prt_cate_cd", ""));
		setStvDmgRptAtchKnt(JSPUtil.getParameter(request, "stv_dmg_rpt_atch_knt", ""));
		setDmgAuthStsCd(JSPUtil.getParameter(request, "dmg_auth_sts_cd", ""));
		setAuthDt(JSPUtil.getParameter(request, "auth_dt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setToTmLssDt(JSPUtil.getParameter(request, "to_tm_lss_dt", ""));
		setCgoDmgFlg(JSPUtil.getParameter(request, "cgo_dmg_flg", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setDmgEmlSndNo(JSPUtil.getParameter(request, "dmg_eml_snd_no", ""));
		setStvDmgRefNo(JSPUtil.getParameter(request, "stv_dmg_ref_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setStvDmgTpCd(JSPUtil.getParameter(request, "stv_dmg_tp_cd", ""));
		setReqSkdDirCd(JSPUtil.getParameter(request, "req_skd_dir_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setClmHndlOfcCd(JSPUtil.getParameter(request, "clm_hndl_ofc_cd", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setStvDmgEvntDt(JSPUtil.getParameter(request, "stv_dmg_evnt_dt", ""));
		setReqEtaDt(JSPUtil.getParameter(request, "req_eta_dt", ""));
		setAuthUsrId(JSPUtil.getParameter(request, "auth_usr_id", ""));
		setStvDmgNo(JSPUtil.getParameter(request, "stv_dmg_no", ""));
		setCreUsrOfc(JSPUtil.getParameter(request, "cre_usr_ofc", ""));
		setStvDmgPrtCd(JSPUtil.getParameter(request, "stv_dmg_prt_cd", ""));
		setReqVslCd(JSPUtil.getParameter(request, "req_vsl_cd", ""));
		setVslSlanCd(JSPUtil.getParameter(request, "vsl_slan_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OpfStvDmgCreateVO[]
	 */
	public OpfStvDmgCreateVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OpfStvDmgCreateVO[]
	 */
	public OpfStvDmgCreateVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OpfStvDmgCreateVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] stvDmgDocAtchKnt = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_doc_atch_knt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] vslOshpCntrBlkTpCd = (JSPUtil.getParameter(request, prefix	+ "vsl_oshp_cntr_blk_tp_cd", length));
			String[] vslOshpCntrBlkTpDesc = (JSPUtil.getParameter(request, prefix	+ "vsl_oshp_cntr_blk_tp_desc", length));
			String[] stvDmgPictAtchFlg = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_pict_atch_flg", length));
			String[] stvDmgLocDesc = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_loc_desc", length));
			String[] stvDmgDocAtchFlg = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_doc_atch_flg", length));
			String[] stvDmgRespbCd = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_respb_cd", length));
			String[] stvDmgRespbPtyKwnCd = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_respb_pty_kwn_cd", length));
			String[] fmTmLssDt = (JSPUtil.getParameter(request, prefix	+ "fm_tm_lss_dt", length));
			String[] stvDmgPictAtchKnt = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_pict_atch_knt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] cntrDmgFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_dmg_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] reqSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "req_skd_voy_no", length));
			String[] stepCnt = (JSPUtil.getParameter(request, prefix	+ "step_cnt", length));
			String[] reqPortCd = (JSPUtil.getParameter(request, prefix	+ "req_port_cd", length));
			String[] stvDmgRespbDesc = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_respb_desc", length));
			String[] stvDmgQttnRsnDesc = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_qttn_rsn_desc", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] stvDmgReqCateCd = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_req_cate_cd", length));
			String[] stvDmgRmk = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_rmk", length));
			String[] stvDmgRptAtchFlg = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_rpt_atch_flg", length));
			String[] stvDmgQttnCd = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_qttn_cd", length));
			String[] stvDmgPrtCateCd = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_prt_cate_cd", length));
			String[] stvDmgRptAtchKnt = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_rpt_atch_knt", length));
			String[] dmgAuthStsCd = (JSPUtil.getParameter(request, prefix	+ "dmg_auth_sts_cd", length));
			String[] authDt = (JSPUtil.getParameter(request, prefix	+ "auth_dt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] toTmLssDt = (JSPUtil.getParameter(request, prefix	+ "to_tm_lss_dt", length));
			String[] cgoDmgFlg = (JSPUtil.getParameter(request, prefix	+ "cgo_dmg_flg", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] dmgEmlSndNo = (JSPUtil.getParameter(request, prefix	+ "dmg_eml_snd_no", length));
			String[] stvDmgRefNo = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_ref_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] stvDmgTpCd = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_tp_cd", length));
			String[] reqSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "req_skd_dir_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] clmHndlOfcCd = (JSPUtil.getParameter(request, prefix	+ "clm_hndl_ofc_cd", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] stvDmgEvntDt = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_evnt_dt", length));
			String[] reqEtaDt = (JSPUtil.getParameter(request, prefix	+ "req_eta_dt", length));
			String[] authUsrId = (JSPUtil.getParameter(request, prefix	+ "auth_usr_id", length));
			String[] stvDmgNo = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_no", length));
			String[] creUsrOfc = (JSPUtil.getParameter(request, prefix	+ "cre_usr_ofc", length));
			String[] stvDmgPrtCd = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_prt_cd", length));
			String[] reqVslCd = (JSPUtil.getParameter(request, prefix	+ "req_vsl_cd", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new OpfStvDmgCreateVO();
				if (stvDmgDocAtchKnt[i] != null)
					model.setStvDmgDocAtchKnt(stvDmgDocAtchKnt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (vslOshpCntrBlkTpCd[i] != null)
					model.setVslOshpCntrBlkTpCd(vslOshpCntrBlkTpCd[i]);
				if (vslOshpCntrBlkTpDesc[i] != null)
					model.setVslOshpCntrBlkTpDesc(vslOshpCntrBlkTpDesc[i]);
				if (stvDmgPictAtchFlg[i] != null)
					model.setStvDmgPictAtchFlg(stvDmgPictAtchFlg[i]);
				if (stvDmgLocDesc[i] != null)
					model.setStvDmgLocDesc(stvDmgLocDesc[i]);
				if (stvDmgDocAtchFlg[i] != null)
					model.setStvDmgDocAtchFlg(stvDmgDocAtchFlg[i]);
				if (stvDmgRespbCd[i] != null)
					model.setStvDmgRespbCd(stvDmgRespbCd[i]);
				if (stvDmgRespbPtyKwnCd[i] != null)
					model.setStvDmgRespbPtyKwnCd(stvDmgRespbPtyKwnCd[i]);
				if (fmTmLssDt[i] != null)
					model.setFmTmLssDt(fmTmLssDt[i]);
				if (stvDmgPictAtchKnt[i] != null)
					model.setStvDmgPictAtchKnt(stvDmgPictAtchKnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (cntrDmgFlg[i] != null)
					model.setCntrDmgFlg(cntrDmgFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (reqSkdVoyNo[i] != null)
					model.setReqSkdVoyNo(reqSkdVoyNo[i]);
				if (stepCnt[i] != null)
					model.setStepCnt(stepCnt[i]);
				if (reqPortCd[i] != null)
					model.setReqPortCd(reqPortCd[i]);
				if (stvDmgRespbDesc[i] != null)
					model.setStvDmgRespbDesc(stvDmgRespbDesc[i]);
				if (stvDmgQttnRsnDesc[i] != null)
					model.setStvDmgQttnRsnDesc(stvDmgQttnRsnDesc[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (stvDmgReqCateCd[i] != null)
					model.setStvDmgReqCateCd(stvDmgReqCateCd[i]);
				if (stvDmgRmk[i] != null)
					model.setStvDmgRmk(stvDmgRmk[i]);
				if (stvDmgRptAtchFlg[i] != null)
					model.setStvDmgRptAtchFlg(stvDmgRptAtchFlg[i]);
				if (stvDmgQttnCd[i] != null)
					model.setStvDmgQttnCd(stvDmgQttnCd[i]);
				if (stvDmgPrtCateCd[i] != null)
					model.setStvDmgPrtCateCd(stvDmgPrtCateCd[i]);
				if (stvDmgRptAtchKnt[i] != null)
					model.setStvDmgRptAtchKnt(stvDmgRptAtchKnt[i]);
				if (dmgAuthStsCd[i] != null)
					model.setDmgAuthStsCd(dmgAuthStsCd[i]);
				if (authDt[i] != null)
					model.setAuthDt(authDt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (toTmLssDt[i] != null)
					model.setToTmLssDt(toTmLssDt[i]);
				if (cgoDmgFlg[i] != null)
					model.setCgoDmgFlg(cgoDmgFlg[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (dmgEmlSndNo[i] != null)
					model.setDmgEmlSndNo(dmgEmlSndNo[i]);
				if (stvDmgRefNo[i] != null)
					model.setStvDmgRefNo(stvDmgRefNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (stvDmgTpCd[i] != null)
					model.setStvDmgTpCd(stvDmgTpCd[i]);
				if (reqSkdDirCd[i] != null)
					model.setReqSkdDirCd(reqSkdDirCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (clmHndlOfcCd[i] != null)
					model.setClmHndlOfcCd(clmHndlOfcCd[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (stvDmgEvntDt[i] != null)
					model.setStvDmgEvntDt(stvDmgEvntDt[i]);
				if (reqEtaDt[i] != null)
					model.setReqEtaDt(reqEtaDt[i]);
				if (authUsrId[i] != null)
					model.setAuthUsrId(authUsrId[i]);
				if (stvDmgNo[i] != null)
					model.setStvDmgNo(stvDmgNo[i]);
				if (creUsrOfc[i] != null)
					model.setCreUsrOfc(creUsrOfc[i]);
				if (stvDmgPrtCd[i] != null)
					model.setStvDmgPrtCd(stvDmgPrtCd[i]);
				if (reqVslCd[i] != null)
					model.setReqVslCd(reqVslCd[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOpfStvDmgCreateVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OpfStvDmgCreateVO[]
	 */
	public OpfStvDmgCreateVO[] getOpfStvDmgCreateVOs(){
		OpfStvDmgCreateVO[] vos = (OpfStvDmgCreateVO[])models.toArray(new OpfStvDmgCreateVO[models.size()]);
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
		this.stvDmgDocAtchKnt = this.stvDmgDocAtchKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslOshpCntrBlkTpCd = this.vslOshpCntrBlkTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslOshpCntrBlkTpDesc = this.vslOshpCntrBlkTpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgPictAtchFlg = this.stvDmgPictAtchFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgLocDesc = this.stvDmgLocDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgDocAtchFlg = this.stvDmgDocAtchFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgRespbCd = this.stvDmgRespbCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgRespbPtyKwnCd = this.stvDmgRespbPtyKwnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmTmLssDt = this.fmTmLssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgPictAtchKnt = this.stvDmgPictAtchKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDmgFlg = this.cntrDmgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reqSkdVoyNo = this.reqSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stepCnt = this.stepCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reqPortCd = this.reqPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgRespbDesc = this.stvDmgRespbDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgQttnRsnDesc = this.stvDmgQttnRsnDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgReqCateCd = this.stvDmgReqCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgRmk = this.stvDmgRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgRptAtchFlg = this.stvDmgRptAtchFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgQttnCd = this.stvDmgQttnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgPrtCateCd = this.stvDmgPrtCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgRptAtchKnt = this.stvDmgRptAtchKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgAuthStsCd = this.dmgAuthStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authDt = this.authDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toTmLssDt = this.toTmLssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoDmgFlg = this.cgoDmgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgEmlSndNo = this.dmgEmlSndNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgRefNo = this.stvDmgRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgTpCd = this.stvDmgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reqSkdDirCd = this.reqSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmHndlOfcCd = this.clmHndlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgEvntDt = this.stvDmgEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reqEtaDt = this.reqEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authUsrId = this.authUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgNo = this.stvDmgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrOfc = this.creUsrOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgPrtCd = this.stvDmgPrtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reqVslCd = this.reqVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
