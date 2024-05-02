/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SearchEDICtmEqMvmtListVO.java
*@FileTitle : SearchEDICtmEqMvmtListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.07  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchEDICtmEqMvmtListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchEDICtmEqMvmtListVO> models = new ArrayList<SearchEDICtmEqMvmtListVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String datMnplCd = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String prctFlg = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String polClptIndSeq = null;
	/* Column Info */
	private String blNoTp = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String hcmtCmbFlg = null;
	/* Column Info */
	private String preRlyPortCd = null;
	/* Column Info */
	private String awkCgoFlg = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String podClptIndSeq = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String cnmvEvntDt = null;
	/* Column Info */
	private String cnmvIdNo = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String toBkgNo = null;
	/* Column Info */
	private String spclHideFlg = null;
	/* Column Info */
	private String fmBkgNo = null;
	/* Column Info */
	private String opCd = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String cntrVolQty = null;
	/* Column Info */
	private String pstRlyPortCd = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String splitFlg = null;
	/* Column Info */
	private String destLocCd = null;
	/* Column Info */
	private String cnmvCycNo = null;
	/* Column Info */
	private String stTurnFlg = null;
	/* Column Info */
	private String rdCgoFlg = null;
	/* Column Info */
	private String dmstBkgNo = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String vslSeq = null;
	/* Column Info */
	private String edwUpdDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cnmvStsCd = null;
	/* Column Info */
	private String railBlkCd = null;
	/* Column Info */
	private String mtySplitAvalCd = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String cudFlg = null;
	/* Column Info */
	private String bbCgoFlg = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String vslPrePstCd = null;
	/* Column Info */
	private String podYdCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String revVvdFlg = null;
	/* Column Info */
	private String cntrCfmFlg = null;
	/* Column Info */
	private String bkgTrspMzdCd = null;
	/* Column Info */
	private String etdDt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String brgTpId = null;
	/* Column Info */
	private String blTpCd = null;
	/* Column Info */
	private String socFlg = null;
	/* Column Info */
	private String bkgCreTpCd = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String cntrLodgFlg = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String polYdCd = null;
	/* Column Info */
	private String hngrFlg = null;
	/* Column Info */
	private String cnmvYr = null;
	/* Column Info */
	private String repCmdtCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchEDICtmEqMvmtListVO() {}

	public SearchEDICtmEqMvmtListVO(String ibflag, String pagerows, String vslCd, String datMnplCd, String bkgCgoTpCd, String svcScpCd, String blNo, String polCd, String prctFlg, String cntrTpszCd, String polClptIndSeq, String blNoTp, String hcmtCmbFlg, String updUsrId, String preRlyPortCd, String awkCgoFlg, String podClptIndSeq, String delCd, String cnmvEvntDt, String skdVoyNo, String cnmvIdNo, String podCd, String bkgNo, String creUsrId, String toBkgNo, String spclHideFlg, String fmBkgNo, String opCd, String rcFlg, String cntrVolQty, String pstRlyPortCd, String porCd, String splitFlg, String destLocCd, String cnmvCycNo, String stTurnFlg, String rdCgoFlg, String dmstBkgNo, String bkgStsCd, String creDt, String vslSeq, String edwUpdDt, String cnmvStsCd, String railBlkCd, String mtySplitAvalCd, String cmdtCd, String cudFlg, String bbCgoFlg, String dcgoFlg, String vslPrePstCd, String rcvTermCd, String podYdCd, String updDt, String revVvdFlg, String bkgTrspMzdCd, String cntrCfmFlg, String brgTpId, String skdDirCd, String blTpCd, String socFlg, String deTermCd, String bkgCreTpCd, String slanCd, String cntrLodgFlg, String polYdCd, String cntrNo, String hngrFlg, String cnmvYr, String repCmdtCd, String etdDt) {
		this.vslCd = vslCd;
		this.datMnplCd = datMnplCd;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.svcScpCd = svcScpCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.prctFlg = prctFlg;
		this.cntrTpszCd = cntrTpszCd;
		this.polClptIndSeq = polClptIndSeq;
		this.blNoTp = blNoTp;
		this.updUsrId = updUsrId;
		this.hcmtCmbFlg = hcmtCmbFlg;
		this.preRlyPortCd = preRlyPortCd;
		this.awkCgoFlg = awkCgoFlg;
		this.delCd = delCd;
		this.podClptIndSeq = podClptIndSeq;
		this.skdVoyNo = skdVoyNo;
		this.cnmvEvntDt = cnmvEvntDt;
		this.cnmvIdNo = cnmvIdNo;
		this.podCd = podCd;
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.toBkgNo = toBkgNo;
		this.spclHideFlg = spclHideFlg;
		this.fmBkgNo = fmBkgNo;
		this.opCd = opCd;
		this.rcFlg = rcFlg;
		this.cntrVolQty = cntrVolQty;
		this.pstRlyPortCd = pstRlyPortCd;
		this.porCd = porCd;
		this.splitFlg = splitFlg;
		this.destLocCd = destLocCd;
		this.cnmvCycNo = cnmvCycNo;
		this.stTurnFlg = stTurnFlg;
		this.rdCgoFlg = rdCgoFlg;
		this.dmstBkgNo = dmstBkgNo;
		this.bkgStsCd = bkgStsCd;
		this.creDt = creDt;
		this.vslSeq = vslSeq;
		this.edwUpdDt = edwUpdDt;
		this.ibflag = ibflag;
		this.cnmvStsCd = cnmvStsCd;
		this.railBlkCd = railBlkCd;
		this.mtySplitAvalCd = mtySplitAvalCd;
		this.cmdtCd = cmdtCd;
		this.cudFlg = cudFlg;
		this.bbCgoFlg = bbCgoFlg;
		this.dcgoFlg = dcgoFlg;
		this.rcvTermCd = rcvTermCd;
		this.vslPrePstCd = vslPrePstCd;
		this.podYdCd = podYdCd;
		this.updDt = updDt;
		this.revVvdFlg = revVvdFlg;
		this.cntrCfmFlg = cntrCfmFlg;
		this.bkgTrspMzdCd = bkgTrspMzdCd;
		this.etdDt = etdDt;
		this.skdDirCd = skdDirCd;
		this.brgTpId = brgTpId;
		this.blTpCd = blTpCd;
		this.socFlg = socFlg;
		this.bkgCreTpCd = bkgCreTpCd;
		this.deTermCd = deTermCd;
		this.slanCd = slanCd;
		this.cntrLodgFlg = cntrLodgFlg;
		this.cntrNo = cntrNo;
		this.polYdCd = polYdCd;
		this.hngrFlg = hngrFlg;
		this.cnmvYr = cnmvYr;
		this.repCmdtCd = repCmdtCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("dat_mnpl_cd", getDatMnplCd());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("prct_flg", getPrctFlg());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("pol_clpt_ind_seq", getPolClptIndSeq());
		this.hashColumns.put("bl_no_tp", getBlNoTp());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("hcmt_cmb_flg", getHcmtCmbFlg());
		this.hashColumns.put("pre_rly_port_cd", getPreRlyPortCd());
		this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("pod_clpt_ind_seq", getPodClptIndSeq());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("cnmv_evnt_dt", getCnmvEvntDt());
		this.hashColumns.put("cnmv_id_no", getCnmvIdNo());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("to_bkg_no", getToBkgNo());
		this.hashColumns.put("spcl_hide_flg", getSpclHideFlg());
		this.hashColumns.put("fm_bkg_no", getFmBkgNo());
		this.hashColumns.put("op_cd", getOpCd());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("cntr_vol_qty", getCntrVolQty());
		this.hashColumns.put("pst_rly_port_cd", getPstRlyPortCd());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("split_flg", getSplitFlg());
		this.hashColumns.put("dest_loc_cd", getDestLocCd());
		this.hashColumns.put("cnmv_cyc_no", getCnmvCycNo());
		this.hashColumns.put("st_turn_flg", getStTurnFlg());
		this.hashColumns.put("rd_cgo_flg", getRdCgoFlg());
		this.hashColumns.put("dmst_bkg_no", getDmstBkgNo());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("vsl_seq", getVslSeq());
		this.hashColumns.put("edw_upd_dt", getEdwUpdDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());
		this.hashColumns.put("rail_blk_cd", getRailBlkCd());
		this.hashColumns.put("mty_split_aval_cd", getMtySplitAvalCd());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("cud_flg", getCudFlg());
		this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("vsl_pre_pst_cd", getVslPrePstCd());
		this.hashColumns.put("pod_yd_cd", getPodYdCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rev_vvd_flg", getRevVvdFlg());
		this.hashColumns.put("cntr_cfm_flg", getCntrCfmFlg());
		this.hashColumns.put("bkg_trsp_mzd_cd", getBkgTrspMzdCd());
		this.hashColumns.put("etd_dt", getEtdDt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("brg_tp_id", getBrgTpId());
		this.hashColumns.put("bl_tp_cd", getBlTpCd());
		this.hashColumns.put("soc_flg", getSocFlg());
		this.hashColumns.put("bkg_cre_tp_cd", getBkgCreTpCd());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("cntr_lodg_flg", getCntrLodgFlg());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("pol_yd_cd", getPolYdCd());
		this.hashColumns.put("hngr_flg", getHngrFlg());
		this.hashColumns.put("cnmv_yr", getCnmvYr());
		this.hashColumns.put("rep_cmdt_cd", getRepCmdtCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("dat_mnpl_cd", "datMnplCd");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("prct_flg", "prctFlg");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("pol_clpt_ind_seq", "polClptIndSeq");
		this.hashFields.put("bl_no_tp", "blNoTp");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("hcmt_cmb_flg", "hcmtCmbFlg");
		this.hashFields.put("pre_rly_port_cd", "preRlyPortCd");
		this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("pod_clpt_ind_seq", "podClptIndSeq");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("cnmv_evnt_dt", "cnmvEvntDt");
		this.hashFields.put("cnmv_id_no", "cnmvIdNo");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("to_bkg_no", "toBkgNo");
		this.hashFields.put("spcl_hide_flg", "spclHideFlg");
		this.hashFields.put("fm_bkg_no", "fmBkgNo");
		this.hashFields.put("op_cd", "opCd");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("cntr_vol_qty", "cntrVolQty");
		this.hashFields.put("pst_rly_port_cd", "pstRlyPortCd");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("split_flg", "splitFlg");
		this.hashFields.put("dest_loc_cd", "destLocCd");
		this.hashFields.put("cnmv_cyc_no", "cnmvCycNo");
		this.hashFields.put("st_turn_flg", "stTurnFlg");
		this.hashFields.put("rd_cgo_flg", "rdCgoFlg");
		this.hashFields.put("dmst_bkg_no", "dmstBkgNo");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("vsl_seq", "vslSeq");
		this.hashFields.put("edw_upd_dt", "edwUpdDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("rail_blk_cd", "railBlkCd");
		this.hashFields.put("mty_split_aval_cd", "mtySplitAvalCd");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("cud_flg", "cudFlg");
		this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("vsl_pre_pst_cd", "vslPrePstCd");
		this.hashFields.put("pod_yd_cd", "podYdCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rev_vvd_flg", "revVvdFlg");
		this.hashFields.put("cntr_cfm_flg", "cntrCfmFlg");
		this.hashFields.put("bkg_trsp_mzd_cd", "bkgTrspMzdCd");
		this.hashFields.put("etd_dt", "etdDt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("brg_tp_id", "brgTpId");
		this.hashFields.put("bl_tp_cd", "blTpCd");
		this.hashFields.put("soc_flg", "socFlg");
		this.hashFields.put("bkg_cre_tp_cd", "bkgCreTpCd");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("cntr_lodg_flg", "cntrLodgFlg");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("pol_yd_cd", "polYdCd");
		this.hashFields.put("hngr_flg", "hngrFlg");
		this.hashFields.put("cnmv_yr", "cnmvYr");
		this.hashFields.put("rep_cmdt_cd", "repCmdtCd");
		return this.hashFields;
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
	 * @return datMnplCd
	 */
	public String getDatMnplCd() {
		return this.datMnplCd;
	}
	
	/**
	 * Column Info
	 * @return bkgCgoTpCd
	 */
	public String getBkgCgoTpCd() {
		return this.bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return prctFlg
	 */
	public String getPrctFlg() {
		return this.prctFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return polClptIndSeq
	 */
	public String getPolClptIndSeq() {
		return this.polClptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return blNoTp
	 */
	public String getBlNoTp() {
		return this.blNoTp;
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
	 * @return hcmtCmbFlg
	 */
	public String getHcmtCmbFlg() {
		return this.hcmtCmbFlg;
	}
	
	/**
	 * Column Info
	 * @return preRlyPortCd
	 */
	public String getPreRlyPortCd() {
		return this.preRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @return awkCgoFlg
	 */
	public String getAwkCgoFlg() {
		return this.awkCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return podClptIndSeq
	 */
	public String getPodClptIndSeq() {
		return this.podClptIndSeq;
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
	 * @return cnmvEvntDt
	 */
	public String getCnmvEvntDt() {
		return this.cnmvEvntDt;
	}
	
	/**
	 * Column Info
	 * @return cnmvIdNo
	 */
	public String getCnmvIdNo() {
		return this.cnmvIdNo;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return toBkgNo
	 */
	public String getToBkgNo() {
		return this.toBkgNo;
	}
	
	/**
	 * Column Info
	 * @return spclHideFlg
	 */
	public String getSpclHideFlg() {
		return this.spclHideFlg;
	}
	
	/**
	 * Column Info
	 * @return fmBkgNo
	 */
	public String getFmBkgNo() {
		return this.fmBkgNo;
	}
	
	/**
	 * Column Info
	 * @return opCd
	 */
	public String getOpCd() {
		return this.opCd;
	}
	
	/**
	 * Column Info
	 * @return rcFlg
	 */
	public String getRcFlg() {
		return this.rcFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrVolQty
	 */
	public String getCntrVolQty() {
		return this.cntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return pstRlyPortCd
	 */
	public String getPstRlyPortCd() {
		return this.pstRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
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
	 * @return destLocCd
	 */
	public String getDestLocCd() {
		return this.destLocCd;
	}
	
	/**
	 * Column Info
	 * @return cnmvCycNo
	 */
	public String getCnmvCycNo() {
		return this.cnmvCycNo;
	}
	
	/**
	 * Column Info
	 * @return stTurnFlg
	 */
	public String getStTurnFlg() {
		return this.stTurnFlg;
	}
	
	/**
	 * Column Info
	 * @return rdCgoFlg
	 */
	public String getRdCgoFlg() {
		return this.rdCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return dmstBkgNo
	 */
	public String getDmstBkgNo() {
		return this.dmstBkgNo;
	}
	
	/**
	 * Column Info
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
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
	 * @return vslSeq
	 */
	public String getVslSeq() {
		return this.vslSeq;
	}
	
	/**
	 * Column Info
	 * @return edwUpdDt
	 */
	public String getEdwUpdDt() {
		return this.edwUpdDt;
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
	 * @return cnmvStsCd
	 */
	public String getCnmvStsCd() {
		return this.cnmvStsCd;
	}
	
	/**
	 * Column Info
	 * @return railBlkCd
	 */
	public String getRailBlkCd() {
		return this.railBlkCd;
	}
	
	/**
	 * Column Info
	 * @return mtySplitAvalCd
	 */
	public String getMtySplitAvalCd() {
		return this.mtySplitAvalCd;
	}
	
	/**
	 * Column Info
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}
	
	/**
	 * Column Info
	 * @return cudFlg
	 */
	public String getCudFlg() {
		return this.cudFlg;
	}
	
	/**
	 * Column Info
	 * @return bbCgoFlg
	 */
	public String getBbCgoFlg() {
		return this.bbCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return dcgoFlg
	 */
	public String getDcgoFlg() {
		return this.dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return vslPrePstCd
	 */
	public String getVslPrePstCd() {
		return this.vslPrePstCd;
	}
	
	/**
	 * Column Info
	 * @return podYdCd
	 */
	public String getPodYdCd() {
		return this.podYdCd;
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
	 * @return revVvdFlg
	 */
	public String getRevVvdFlg() {
		return this.revVvdFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrCfmFlg
	 */
	public String getCntrCfmFlg() {
		return this.cntrCfmFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgTrspMzdCd
	 */
	public String getBkgTrspMzdCd() {
		return this.bkgTrspMzdCd;
	}
	
	/**
	 * Column Info
	 * @return etdDt
	 */
	public String getEtdDt() {
		return this.etdDt;
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
	 * @return brgTpId
	 */
	public String getBrgTpId() {
		return this.brgTpId;
	}
	
	/**
	 * Column Info
	 * @return blTpCd
	 */
	public String getBlTpCd() {
		return this.blTpCd;
	}
	
	/**
	 * Column Info
	 * @return socFlg
	 */
	public String getSocFlg() {
		return this.socFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgCreTpCd
	 */
	public String getBkgCreTpCd() {
		return this.bkgCreTpCd;
	}
	
	/**
	 * Column Info
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
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
	 * @return cntrLodgFlg
	 */
	public String getCntrLodgFlg() {
		return this.cntrLodgFlg;
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
	 * @return polYdCd
	 */
	public String getPolYdCd() {
		return this.polYdCd;
	}
	
	/**
	 * Column Info
	 * @return hngrFlg
	 */
	public String getHngrFlg() {
		return this.hngrFlg;
	}
	
	/**
	 * Column Info
	 * @return cnmvYr
	 */
	public String getCnmvYr() {
		return this.cnmvYr;
	}
	
	/**
	 * Column Info
	 * @return repCmdtCd
	 */
	public String getRepCmdtCd() {
		return this.repCmdtCd;
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
	 * @param datMnplCd
	 */
	public void setDatMnplCd(String datMnplCd) {
		this.datMnplCd = datMnplCd;
	}
	
	/**
	 * Column Info
	 * @param bkgCgoTpCd
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param prctFlg
	 */
	public void setPrctFlg(String prctFlg) {
		this.prctFlg = prctFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param polClptIndSeq
	 */
	public void setPolClptIndSeq(String polClptIndSeq) {
		this.polClptIndSeq = polClptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param blNoTp
	 */
	public void setBlNoTp(String blNoTp) {
		this.blNoTp = blNoTp;
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
	 * @param hcmtCmbFlg
	 */
	public void setHcmtCmbFlg(String hcmtCmbFlg) {
		this.hcmtCmbFlg = hcmtCmbFlg;
	}
	
	/**
	 * Column Info
	 * @param preRlyPortCd
	 */
	public void setPreRlyPortCd(String preRlyPortCd) {
		this.preRlyPortCd = preRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @param awkCgoFlg
	 */
	public void setAwkCgoFlg(String awkCgoFlg) {
		this.awkCgoFlg = awkCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param podClptIndSeq
	 */
	public void setPodClptIndSeq(String podClptIndSeq) {
		this.podClptIndSeq = podClptIndSeq;
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
	 * @param cnmvEvntDt
	 */
	public void setCnmvEvntDt(String cnmvEvntDt) {
		this.cnmvEvntDt = cnmvEvntDt;
	}
	
	/**
	 * Column Info
	 * @param cnmvIdNo
	 */
	public void setCnmvIdNo(String cnmvIdNo) {
		this.cnmvIdNo = cnmvIdNo;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param toBkgNo
	 */
	public void setToBkgNo(String toBkgNo) {
		this.toBkgNo = toBkgNo;
	}
	
	/**
	 * Column Info
	 * @param spclHideFlg
	 */
	public void setSpclHideFlg(String spclHideFlg) {
		this.spclHideFlg = spclHideFlg;
	}
	
	/**
	 * Column Info
	 * @param fmBkgNo
	 */
	public void setFmBkgNo(String fmBkgNo) {
		this.fmBkgNo = fmBkgNo;
	}
	
	/**
	 * Column Info
	 * @param opCd
	 */
	public void setOpCd(String opCd) {
		this.opCd = opCd;
	}
	
	/**
	 * Column Info
	 * @param rcFlg
	 */
	public void setRcFlg(String rcFlg) {
		this.rcFlg = rcFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrVolQty
	 */
	public void setCntrVolQty(String cntrVolQty) {
		this.cntrVolQty = cntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param pstRlyPortCd
	 */
	public void setPstRlyPortCd(String pstRlyPortCd) {
		this.pstRlyPortCd = pstRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
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
	 * @param destLocCd
	 */
	public void setDestLocCd(String destLocCd) {
		this.destLocCd = destLocCd;
	}
	
	/**
	 * Column Info
	 * @param cnmvCycNo
	 */
	public void setCnmvCycNo(String cnmvCycNo) {
		this.cnmvCycNo = cnmvCycNo;
	}
	
	/**
	 * Column Info
	 * @param stTurnFlg
	 */
	public void setStTurnFlg(String stTurnFlg) {
		this.stTurnFlg = stTurnFlg;
	}
	
	/**
	 * Column Info
	 * @param rdCgoFlg
	 */
	public void setRdCgoFlg(String rdCgoFlg) {
		this.rdCgoFlg = rdCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param dmstBkgNo
	 */
	public void setDmstBkgNo(String dmstBkgNo) {
		this.dmstBkgNo = dmstBkgNo;
	}
	
	/**
	 * Column Info
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
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
	 * @param vslSeq
	 */
	public void setVslSeq(String vslSeq) {
		this.vslSeq = vslSeq;
	}
	
	/**
	 * Column Info
	 * @param edwUpdDt
	 */
	public void setEdwUpdDt(String edwUpdDt) {
		this.edwUpdDt = edwUpdDt;
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
	 * @param cnmvStsCd
	 */
	public void setCnmvStsCd(String cnmvStsCd) {
		this.cnmvStsCd = cnmvStsCd;
	}
	
	/**
	 * Column Info
	 * @param railBlkCd
	 */
	public void setRailBlkCd(String railBlkCd) {
		this.railBlkCd = railBlkCd;
	}
	
	/**
	 * Column Info
	 * @param mtySplitAvalCd
	 */
	public void setMtySplitAvalCd(String mtySplitAvalCd) {
		this.mtySplitAvalCd = mtySplitAvalCd;
	}
	
	/**
	 * Column Info
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}
	
	/**
	 * Column Info
	 * @param cudFlg
	 */
	public void setCudFlg(String cudFlg) {
		this.cudFlg = cudFlg;
	}
	
	/**
	 * Column Info
	 * @param bbCgoFlg
	 */
	public void setBbCgoFlg(String bbCgoFlg) {
		this.bbCgoFlg = bbCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param dcgoFlg
	 */
	public void setDcgoFlg(String dcgoFlg) {
		this.dcgoFlg = dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param vslPrePstCd
	 */
	public void setVslPrePstCd(String vslPrePstCd) {
		this.vslPrePstCd = vslPrePstCd;
	}
	
	/**
	 * Column Info
	 * @param podYdCd
	 */
	public void setPodYdCd(String podYdCd) {
		this.podYdCd = podYdCd;
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
	 * @param revVvdFlg
	 */
	public void setRevVvdFlg(String revVvdFlg) {
		this.revVvdFlg = revVvdFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrCfmFlg
	 */
	public void setCntrCfmFlg(String cntrCfmFlg) {
		this.cntrCfmFlg = cntrCfmFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgTrspMzdCd
	 */
	public void setBkgTrspMzdCd(String bkgTrspMzdCd) {
		this.bkgTrspMzdCd = bkgTrspMzdCd;
	}
	
	/**
	 * Column Info
	 * @param etdDt
	 */
	public void setEtdDt(String etdDt) {
		this.etdDt = etdDt;
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
	 * @param brgTpId
	 */
	public void setBrgTpId(String brgTpId) {
		this.brgTpId = brgTpId;
	}
	
	/**
	 * Column Info
	 * @param blTpCd
	 */
	public void setBlTpCd(String blTpCd) {
		this.blTpCd = blTpCd;
	}
	
	/**
	 * Column Info
	 * @param socFlg
	 */
	public void setSocFlg(String socFlg) {
		this.socFlg = socFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgCreTpCd
	 */
	public void setBkgCreTpCd(String bkgCreTpCd) {
		this.bkgCreTpCd = bkgCreTpCd;
	}
	
	/**
	 * Column Info
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
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
	 * @param cntrLodgFlg
	 */
	public void setCntrLodgFlg(String cntrLodgFlg) {
		this.cntrLodgFlg = cntrLodgFlg;
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
	 * @param polYdCd
	 */
	public void setPolYdCd(String polYdCd) {
		this.polYdCd = polYdCd;
	}
	
	/**
	 * Column Info
	 * @param hngrFlg
	 */
	public void setHngrFlg(String hngrFlg) {
		this.hngrFlg = hngrFlg;
	}
	
	/**
	 * Column Info
	 * @param cnmvYr
	 */
	public void setCnmvYr(String cnmvYr) {
		this.cnmvYr = cnmvYr;
	}
	
	/**
	 * Column Info
	 * @param repCmdtCd
	 */
	public void setRepCmdtCd(String repCmdtCd) {
		this.repCmdtCd = repCmdtCd;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setDatMnplCd(JSPUtil.getParameter(request, prefix + "dat_mnpl_cd", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setPrctFlg(JSPUtil.getParameter(request, prefix + "prct_flg", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setPolClptIndSeq(JSPUtil.getParameter(request, prefix + "pol_clpt_ind_seq", ""));
		setBlNoTp(JSPUtil.getParameter(request, prefix + "bl_no_tp", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setHcmtCmbFlg(JSPUtil.getParameter(request, prefix + "hcmt_cmb_flg", ""));
		setPreRlyPortCd(JSPUtil.getParameter(request, prefix + "pre_rly_port_cd", ""));
		setAwkCgoFlg(JSPUtil.getParameter(request, prefix + "awk_cgo_flg", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setPodClptIndSeq(JSPUtil.getParameter(request, prefix + "pod_clpt_ind_seq", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setCnmvEvntDt(JSPUtil.getParameter(request, prefix + "cnmv_evnt_dt", ""));
		setCnmvIdNo(JSPUtil.getParameter(request, prefix + "cnmv_id_no", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setToBkgNo(JSPUtil.getParameter(request, prefix + "to_bkg_no", ""));
		setSpclHideFlg(JSPUtil.getParameter(request, prefix + "spcl_hide_flg", ""));
		setFmBkgNo(JSPUtil.getParameter(request, prefix + "fm_bkg_no", ""));
		setOpCd(JSPUtil.getParameter(request, prefix + "op_cd", ""));
		setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
		setCntrVolQty(JSPUtil.getParameter(request, prefix + "cntr_vol_qty", ""));
		setPstRlyPortCd(JSPUtil.getParameter(request, prefix + "pst_rly_port_cd", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setSplitFlg(JSPUtil.getParameter(request, prefix + "split_flg", ""));
		setDestLocCd(JSPUtil.getParameter(request, prefix + "dest_loc_cd", ""));
		setCnmvCycNo(JSPUtil.getParameter(request, prefix + "cnmv_cyc_no", ""));
		setStTurnFlg(JSPUtil.getParameter(request, prefix + "st_turn_flg", ""));
		setRdCgoFlg(JSPUtil.getParameter(request, prefix + "rd_cgo_flg", ""));
		setDmstBkgNo(JSPUtil.getParameter(request, prefix + "dmst_bkg_no", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setVslSeq(JSPUtil.getParameter(request, prefix + "vsl_seq", ""));
		setEdwUpdDt(JSPUtil.getParameter(request, prefix + "edw_upd_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCnmvStsCd(JSPUtil.getParameter(request, prefix + "cnmv_sts_cd", ""));
		setRailBlkCd(JSPUtil.getParameter(request, prefix + "rail_blk_cd", ""));
		setMtySplitAvalCd(JSPUtil.getParameter(request, prefix + "mty_split_aval_cd", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setCudFlg(JSPUtil.getParameter(request, prefix + "cud_flg", ""));
		setBbCgoFlg(JSPUtil.getParameter(request, prefix + "bb_cgo_flg", ""));
		setDcgoFlg(JSPUtil.getParameter(request, prefix + "dcgo_flg", ""));
		setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
		setVslPrePstCd(JSPUtil.getParameter(request, prefix + "vsl_pre_pst_cd", ""));
		setPodYdCd(JSPUtil.getParameter(request, prefix + "pod_yd_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setRevVvdFlg(JSPUtil.getParameter(request, prefix + "rev_vvd_flg", ""));
		setCntrCfmFlg(JSPUtil.getParameter(request, prefix + "cntr_cfm_flg", ""));
		setBkgTrspMzdCd(JSPUtil.getParameter(request, prefix + "bkg_trsp_mzd_cd", ""));
		setEtdDt(JSPUtil.getParameter(request, prefix + "etd_dt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setBrgTpId(JSPUtil.getParameter(request, prefix + "brg_tp_id", ""));
		setBlTpCd(JSPUtil.getParameter(request, prefix + "bl_tp_cd", ""));
		setSocFlg(JSPUtil.getParameter(request, prefix + "soc_flg", ""));
		setBkgCreTpCd(JSPUtil.getParameter(request, prefix + "bkg_cre_tp_cd", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setCntrLodgFlg(JSPUtil.getParameter(request, prefix + "cntr_lodg_flg", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setPolYdCd(JSPUtil.getParameter(request, prefix + "pol_yd_cd", ""));
		setHngrFlg(JSPUtil.getParameter(request, prefix + "hngr_flg", ""));
		setCnmvYr(JSPUtil.getParameter(request, prefix + "cnmv_yr", ""));
		setRepCmdtCd(JSPUtil.getParameter(request, prefix + "rep_cmdt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchEDICtmEqMvmtListVO[]
	 */
	public SearchEDICtmEqMvmtListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchEDICtmEqMvmtListVO[]
	 */
	public SearchEDICtmEqMvmtListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchEDICtmEqMvmtListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] datMnplCd = (JSPUtil.getParameter(request, prefix	+ "dat_mnpl_cd", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] prctFlg = (JSPUtil.getParameter(request, prefix	+ "prct_flg", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] polClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "pol_clpt_ind_seq", length));
			String[] blNoTp = (JSPUtil.getParameter(request, prefix	+ "bl_no_tp", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] hcmtCmbFlg = (JSPUtil.getParameter(request, prefix	+ "hcmt_cmb_flg", length));
			String[] preRlyPortCd = (JSPUtil.getParameter(request, prefix	+ "pre_rly_port_cd", length));
			String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_flg", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] podClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "pod_clpt_ind_seq", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] cnmvEvntDt = (JSPUtil.getParameter(request, prefix	+ "cnmv_evnt_dt", length));
			String[] cnmvIdNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_id_no", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] toBkgNo = (JSPUtil.getParameter(request, prefix	+ "to_bkg_no", length));
			String[] spclHideFlg = (JSPUtil.getParameter(request, prefix	+ "spcl_hide_flg", length));
			String[] fmBkgNo = (JSPUtil.getParameter(request, prefix	+ "fm_bkg_no", length));
			String[] opCd = (JSPUtil.getParameter(request, prefix	+ "op_cd", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] cntrVolQty = (JSPUtil.getParameter(request, prefix	+ "cntr_vol_qty", length));
			String[] pstRlyPortCd = (JSPUtil.getParameter(request, prefix	+ "pst_rly_port_cd", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] splitFlg = (JSPUtil.getParameter(request, prefix	+ "split_flg", length));
			String[] destLocCd = (JSPUtil.getParameter(request, prefix	+ "dest_loc_cd", length));
			String[] cnmvCycNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_cyc_no", length));
			String[] stTurnFlg = (JSPUtil.getParameter(request, prefix	+ "st_turn_flg", length));
			String[] rdCgoFlg = (JSPUtil.getParameter(request, prefix	+ "rd_cgo_flg", length));
			String[] dmstBkgNo = (JSPUtil.getParameter(request, prefix	+ "dmst_bkg_no", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] vslSeq = (JSPUtil.getParameter(request, prefix	+ "vsl_seq", length));
			String[] edwUpdDt = (JSPUtil.getParameter(request, prefix	+ "edw_upd_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cnmvStsCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_sts_cd", length));
			String[] railBlkCd = (JSPUtil.getParameter(request, prefix	+ "rail_blk_cd", length));
			String[] mtySplitAvalCd = (JSPUtil.getParameter(request, prefix	+ "mty_split_aval_cd", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] cudFlg = (JSPUtil.getParameter(request, prefix	+ "cud_flg", length));
			String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_flg", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] vslPrePstCd = (JSPUtil.getParameter(request, prefix	+ "vsl_pre_pst_cd", length));
			String[] podYdCd = (JSPUtil.getParameter(request, prefix	+ "pod_yd_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] revVvdFlg = (JSPUtil.getParameter(request, prefix	+ "rev_vvd_flg", length));
			String[] cntrCfmFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_cfm_flg", length));
			String[] bkgTrspMzdCd = (JSPUtil.getParameter(request, prefix	+ "bkg_trsp_mzd_cd", length));
			String[] etdDt = (JSPUtil.getParameter(request, prefix	+ "etd_dt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] brgTpId = (JSPUtil.getParameter(request, prefix	+ "brg_tp_id", length));
			String[] blTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_tp_cd", length));
			String[] socFlg = (JSPUtil.getParameter(request, prefix	+ "soc_flg", length));
			String[] bkgCreTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cre_tp_cd", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] cntrLodgFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_lodg_flg", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] polYdCd = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd", length));
			String[] hngrFlg = (JSPUtil.getParameter(request, prefix	+ "hngr_flg", length));
			String[] cnmvYr = (JSPUtil.getParameter(request, prefix	+ "cnmv_yr", length));
			String[] repCmdtCd = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchEDICtmEqMvmtListVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (datMnplCd[i] != null)
					model.setDatMnplCd(datMnplCd[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (prctFlg[i] != null)
					model.setPrctFlg(prctFlg[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (polClptIndSeq[i] != null)
					model.setPolClptIndSeq(polClptIndSeq[i]);
				if (blNoTp[i] != null)
					model.setBlNoTp(blNoTp[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (hcmtCmbFlg[i] != null)
					model.setHcmtCmbFlg(hcmtCmbFlg[i]);
				if (preRlyPortCd[i] != null)
					model.setPreRlyPortCd(preRlyPortCd[i]);
				if (awkCgoFlg[i] != null)
					model.setAwkCgoFlg(awkCgoFlg[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (podClptIndSeq[i] != null)
					model.setPodClptIndSeq(podClptIndSeq[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (cnmvEvntDt[i] != null)
					model.setCnmvEvntDt(cnmvEvntDt[i]);
				if (cnmvIdNo[i] != null)
					model.setCnmvIdNo(cnmvIdNo[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (toBkgNo[i] != null)
					model.setToBkgNo(toBkgNo[i]);
				if (spclHideFlg[i] != null)
					model.setSpclHideFlg(spclHideFlg[i]);
				if (fmBkgNo[i] != null)
					model.setFmBkgNo(fmBkgNo[i]);
				if (opCd[i] != null)
					model.setOpCd(opCd[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (cntrVolQty[i] != null)
					model.setCntrVolQty(cntrVolQty[i]);
				if (pstRlyPortCd[i] != null)
					model.setPstRlyPortCd(pstRlyPortCd[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (splitFlg[i] != null)
					model.setSplitFlg(splitFlg[i]);
				if (destLocCd[i] != null)
					model.setDestLocCd(destLocCd[i]);
				if (cnmvCycNo[i] != null)
					model.setCnmvCycNo(cnmvCycNo[i]);
				if (stTurnFlg[i] != null)
					model.setStTurnFlg(stTurnFlg[i]);
				if (rdCgoFlg[i] != null)
					model.setRdCgoFlg(rdCgoFlg[i]);
				if (dmstBkgNo[i] != null)
					model.setDmstBkgNo(dmstBkgNo[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (vslSeq[i] != null)
					model.setVslSeq(vslSeq[i]);
				if (edwUpdDt[i] != null)
					model.setEdwUpdDt(edwUpdDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cnmvStsCd[i] != null)
					model.setCnmvStsCd(cnmvStsCd[i]);
				if (railBlkCd[i] != null)
					model.setRailBlkCd(railBlkCd[i]);
				if (mtySplitAvalCd[i] != null)
					model.setMtySplitAvalCd(mtySplitAvalCd[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (cudFlg[i] != null)
					model.setCudFlg(cudFlg[i]);
				if (bbCgoFlg[i] != null)
					model.setBbCgoFlg(bbCgoFlg[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (vslPrePstCd[i] != null)
					model.setVslPrePstCd(vslPrePstCd[i]);
				if (podYdCd[i] != null)
					model.setPodYdCd(podYdCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (revVvdFlg[i] != null)
					model.setRevVvdFlg(revVvdFlg[i]);
				if (cntrCfmFlg[i] != null)
					model.setCntrCfmFlg(cntrCfmFlg[i]);
				if (bkgTrspMzdCd[i] != null)
					model.setBkgTrspMzdCd(bkgTrspMzdCd[i]);
				if (etdDt[i] != null)
					model.setEtdDt(etdDt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (brgTpId[i] != null)
					model.setBrgTpId(brgTpId[i]);
				if (blTpCd[i] != null)
					model.setBlTpCd(blTpCd[i]);
				if (socFlg[i] != null)
					model.setSocFlg(socFlg[i]);
				if (bkgCreTpCd[i] != null)
					model.setBkgCreTpCd(bkgCreTpCd[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (cntrLodgFlg[i] != null)
					model.setCntrLodgFlg(cntrLodgFlg[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (polYdCd[i] != null)
					model.setPolYdCd(polYdCd[i]);
				if (hngrFlg[i] != null)
					model.setHngrFlg(hngrFlg[i]);
				if (cnmvYr[i] != null)
					model.setCnmvYr(cnmvYr[i]);
				if (repCmdtCd[i] != null)
					model.setRepCmdtCd(repCmdtCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchEDICtmEqMvmtListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchEDICtmEqMvmtListVO[]
	 */
	public SearchEDICtmEqMvmtListVO[] getSearchEDICtmEqMvmtListVOs(){
		SearchEDICtmEqMvmtListVO[] vos = (SearchEDICtmEqMvmtListVO[])models.toArray(new SearchEDICtmEqMvmtListVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.datMnplCd = this.datMnplCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prctFlg = this.prctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polClptIndSeq = this.polClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNoTp = this.blNoTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcmtCmbFlg = this.hcmtCmbFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preRlyPortCd = this.preRlyPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoFlg = this.awkCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podClptIndSeq = this.podClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvEvntDt = this.cnmvEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvIdNo = this.cnmvIdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toBkgNo = this.toBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclHideFlg = this.spclHideFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmBkgNo = this.fmBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCd = this.opCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVolQty = this.cntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pstRlyPortCd = this.pstRlyPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splitFlg = this.splitFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destLocCd = this.destLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvCycNo = this.cnmvCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stTurnFlg = this.stTurnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdCgoFlg = this.rdCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmstBkgNo = this.dmstBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSeq = this.vslSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edwUpdDt = this.edwUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd = this.cnmvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railBlkCd = this.railBlkCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtySplitAvalCd = this.mtySplitAvalCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cudFlg = this.cudFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoFlg = this.bbCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslPrePstCd = this.vslPrePstCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd = this.podYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revVvdFlg = this.revVvdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCfmFlg = this.cntrCfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTrspMzdCd = this.bkgTrspMzdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDt = this.etdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brgTpId = this.brgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTpCd = this.blTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socFlg = this.socFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCreTpCd = this.bkgCreTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrLodgFlg = this.cntrLodgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd = this.polYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hngrFlg = this.hngrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvYr = this.cnmvYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtCd = this.repCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
