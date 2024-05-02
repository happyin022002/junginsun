/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PortLimitsDataVO.java
*@FileTitle : PortLimitsDataVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.10  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.vo;

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

public class PortLimitsDataVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PortLimitsDataVO> models = new ArrayList<PortLimitsDataVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String pptExploFlg = null;
	/* Column Info */
	private String unLocCd = null;
	/* Column Info */
	private String pierTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String imdgCompGrpCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String dchgCgoWgt = null;
	/* Column Info */
	private String arrDepProhiFlg = null;
	/* Column Info */
	private String toEtaDt = null;
	/* Column Info */
	private String imdgClssCdDesc = null;
	/* Column Info */
	private String fromEtdDt = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Column Info */
	private String lodMaxLmt = null;
	/* Column Info */
	private String cgoWgt = null;
	/* Column Info */
	private String lodLmtRto = null;
	/* Column Info */
	private String arrMaxLmt = null;
	/* Column Info */
	private String arrLmtRto = null;
	/* Column Info */
	private String vImdgSubsRskLblCd = null;
	/* Column Info */
	private String portLmtKnd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String depLmtRto = null;
	/* Column Info */
	private String portLmtSubPptCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String pptFlgRmk = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String fpChk = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String dchgMaxQty = null;
	/* Column Info */
	private String arrMaxQty = null;
	/* Column Info */
	private String lodCgoWgt = null;
	/* Column Info */
	private String portLmtRepDesc = null;
	/* Column Info */
	private String imdgClssCd = null;
	/* Column Info */
	private String dpSeq = null;
	/* Column Info */
	private String rn = null;
	/* Column Info */
	private String imdgPckGrpCd = null;
	/* Column Info */
	private String flshPntTemp = null;
	/* Column Info */
	private String slanCd1 = null;
	/* Column Info */
	private String flshPntCdoTemp = null;
	/* Column Info */
	private String depMaxLmt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String ldisAplyTgtFlg = null;
	/* Column Info */
	private String lodMaxQty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrTpCd = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String fromEtaDt = null;
	/* Column Info */
	private String toEtdDt = null;
	/* Column Info */
	private String depCgoWgt = null;
	/* Column Info */
	private String portLmtSeq = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String cgoLmtRto = null;
	/* Column Info */
	private String ldisProhiFlg = null;
	/* Column Info */
	private String imdgSubsRskLblCd = null;
	/* Column Info */
	private String dchgMaxLmt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String dchgLmtRto = null;
	/* Column Info */
	private String arrCgoWgt = null;
	/* Column Info */
	private String lmtWgtTpCd = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String depMaxQty = null;
	/* Column Info */
	private String vClssInfo = null;
	/* Column Info */
	private String pptProhiFlg = null;
	/* Column Info */
	private String unLocCdFlg = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String lodMaxTeuQty = null;
	/* Column Info */
	private String dchgMaxTeuQty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PortLimitsDataVO() {}

	public PortLimitsDataVO(String ibflag, String pagerows, String vslCd, String unLocCd, String cgoLmtRto, String slanCd1, String portLmtKnd, String skdVoyNo, String pierTpCd, String skdDirCd, String pptFlgRmk, String lmtWgtTpCd, String slanCd, String imdgClssCdDesc, String toEtdDt, String fromEtdDt, String portCd, String unLocCdFlg, String imdgClssCd, String cgoWgt, String podCd, String toEtaDt, String fromEtaDt, String polCd, String fpChk, String flshPntTemp, String flshPntCdoTemp, String imdgPckGrpCd, String imdgSubsRskLblCd, String imdgUnNo, String imdgCompGrpCd, String cntrTpCd, String rn, String bkgNo, String arrMaxLmt, String dchgMaxLmt, String lodMaxLmt, String depMaxLmt, String arrLmtRto, String dchgLmtRto, String lodLmtRto, String depLmtRto, String arrCgoWgt, String dchgCgoWgt, String lodCgoWgt, String depCgoWgt, String arrDepProhiFlg, String ldisProhiFlg, String portLmtRepDesc, String portLmtSeq, String creUsrId, String creDt, String updUsrId, String updDt, String vImdgSubsRskLblCd, String dpSeq, String cmdtCd, String arrMaxQty, String depMaxQty, String ldisAplyTgtFlg, String lodMaxQty, String dchgMaxQty, String portLmtSubPptCd, String pptExploFlg, String pptProhiFlg, String vClssInfo, String creOfcCd, String updOfcCd, String ydCd, String lodMaxTeuQty,String dchgMaxTeuQty) {
		this.vslCd = vslCd;
		this.pptExploFlg = pptExploFlg;
		this.unLocCd = unLocCd;
		this.pierTpCd = pierTpCd;
		this.pagerows = pagerows;
		this.imdgCompGrpCd = imdgCompGrpCd;
		this.polCd = polCd;
		this.dchgCgoWgt = dchgCgoWgt;
		this.arrDepProhiFlg = arrDepProhiFlg;
		this.toEtaDt = toEtaDt;
		this.imdgClssCdDesc = imdgClssCdDesc;
		this.fromEtdDt = fromEtdDt;
		this.updOfcCd = updOfcCd;
		this.updUsrId = updUsrId;
		this.imdgUnNo = imdgUnNo;
		this.lodMaxLmt = lodMaxLmt;
		this.cgoWgt = cgoWgt;
		this.lodLmtRto = lodLmtRto;
		this.arrMaxLmt = arrMaxLmt;
		this.arrLmtRto = arrLmtRto;
		this.vImdgSubsRskLblCd = vImdgSubsRskLblCd;
		this.portLmtKnd = portLmtKnd;
		this.skdVoyNo = skdVoyNo;
		this.depLmtRto = depLmtRto;
		this.portLmtSubPptCd = portLmtSubPptCd;
		this.podCd = podCd;
		this.pptFlgRmk = pptFlgRmk;
		this.creUsrId = creUsrId;
		this.fpChk = fpChk;
		this.bkgNo = bkgNo;
		this.dchgMaxQty = dchgMaxQty;
		this.arrMaxQty = arrMaxQty;
		this.lodCgoWgt = lodCgoWgt;
		this.portLmtRepDesc = portLmtRepDesc;
		this.imdgClssCd = imdgClssCd;
		this.dpSeq = dpSeq;
		this.rn = rn;
		this.imdgPckGrpCd = imdgPckGrpCd;
		this.flshPntTemp = flshPntTemp;
		this.slanCd1 = slanCd1;
		this.flshPntCdoTemp = flshPntCdoTemp;
		this.depMaxLmt = depMaxLmt;
		this.creDt = creDt;
		this.ldisAplyTgtFlg = ldisAplyTgtFlg;
		this.lodMaxQty = lodMaxQty;
		this.ibflag = ibflag;
		this.cntrTpCd = cntrTpCd;
		this.cmdtCd = cmdtCd;
		this.creOfcCd = creOfcCd;
		this.fromEtaDt = fromEtaDt;
		this.toEtdDt = toEtdDt;
		this.depCgoWgt = depCgoWgt;
		this.portLmtSeq = portLmtSeq;
		this.portCd = portCd;
		this.updDt = updDt;
		this.cgoLmtRto = cgoLmtRto;
		this.ldisProhiFlg = ldisProhiFlg;
		this.imdgSubsRskLblCd = imdgSubsRskLblCd;
		this.dchgMaxLmt = dchgMaxLmt;
		this.skdDirCd = skdDirCd;
		this.dchgLmtRto = dchgLmtRto;
		this.arrCgoWgt = arrCgoWgt;
		this.lmtWgtTpCd = lmtWgtTpCd;
		this.slanCd = slanCd;
		this.depMaxQty = depMaxQty;
		this.vClssInfo = vClssInfo;
		this.pptProhiFlg = pptProhiFlg;
		this.unLocCdFlg = unLocCdFlg;
		this.ydCd = ydCd;
		this.lodMaxTeuQty = lodMaxTeuQty;
		this.dchgMaxTeuQty = dchgMaxTeuQty;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("ppt_explo_flg", getPptExploFlg());
		this.hashColumns.put("un_loc_cd", getUnLocCd());
		this.hashColumns.put("pier_tp_cd", getPierTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("imdg_comp_grp_cd", getImdgCompGrpCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("dchg_cgo_wgt", getDchgCgoWgt());
		this.hashColumns.put("arr_dep_prohi_flg", getArrDepProhiFlg());
		this.hashColumns.put("to_eta_dt", getToEtaDt());
		this.hashColumns.put("imdg_clss_cd_desc", getImdgClssCdDesc());
		this.hashColumns.put("from_etd_dt", getFromEtdDt());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("lod_max_lmt", getLodMaxLmt());
		this.hashColumns.put("cgo_wgt", getCgoWgt());
		this.hashColumns.put("lod_lmt_rto", getLodLmtRto());
		this.hashColumns.put("arr_max_lmt", getArrMaxLmt());
		this.hashColumns.put("arr_lmt_rto", getArrLmtRto());
		this.hashColumns.put("v_imdg_subs_rsk_lbl_cd", getVImdgSubsRskLblCd());
		this.hashColumns.put("port_lmt_knd", getPortLmtKnd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("dep_lmt_rto", getDepLmtRto());
		this.hashColumns.put("port_lmt_sub_ppt_cd", getPortLmtSubPptCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ppt_flg_rmk", getPptFlgRmk());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("fp_chk", getFpChk());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("dchg_max_qty", getDchgMaxQty());
		this.hashColumns.put("arr_max_qty", getArrMaxQty());
		this.hashColumns.put("lod_cgo_wgt", getLodCgoWgt());
		this.hashColumns.put("port_lmt_rep_desc", getPortLmtRepDesc());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		this.hashColumns.put("dp_seq", getDpSeq());
		this.hashColumns.put("rn", getRn());
		this.hashColumns.put("imdg_pck_grp_cd", getImdgPckGrpCd());
		this.hashColumns.put("flsh_pnt_temp", getFlshPntTemp());
		this.hashColumns.put("slan_cd1", getSlanCd1());
		this.hashColumns.put("flsh_pnt_cdo_temp", getFlshPntCdoTemp());
		this.hashColumns.put("dep_max_lmt", getDepMaxLmt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("ldis_aply_tgt_flg", getLdisAplyTgtFlg());
		this.hashColumns.put("lod_max_qty", getLodMaxQty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_tp_cd", getCntrTpCd());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("from_eta_dt", getFromEtaDt());
		this.hashColumns.put("to_etd_dt", getToEtdDt());
		this.hashColumns.put("dep_cgo_wgt", getDepCgoWgt());
		this.hashColumns.put("port_lmt_seq", getPortLmtSeq());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cgo_lmt_rto", getCgoLmtRto());
		this.hashColumns.put("ldis_prohi_flg", getLdisProhiFlg());
		this.hashColumns.put("imdg_subs_rsk_lbl_cd", getImdgSubsRskLblCd());
		this.hashColumns.put("dchg_max_lmt", getDchgMaxLmt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("dchg_lmt_rto", getDchgLmtRto());
		this.hashColumns.put("arr_cgo_wgt", getArrCgoWgt());
		this.hashColumns.put("lmt_wgt_tp_cd", getLmtWgtTpCd());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("dep_max_qty", getDepMaxQty());
		this.hashColumns.put("v_clss_info", getVClssInfo());
		this.hashColumns.put("ppt_prohi_flg", getPptProhiFlg());
		this.hashColumns.put("un_loc_cd_flg", getUnLocCdFlg());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("lod_max_teu_qty", getLodMaxTeuQty());
		this.hashColumns.put("dchg_max_teu_qty", getDchgMaxTeuQty());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("ppt_explo_flg", "pptExploFlg");
		this.hashFields.put("un_loc_cd", "unLocCd");
		this.hashFields.put("pier_tp_cd", "pierTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("imdg_comp_grp_cd", "imdgCompGrpCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("dchg_cgo_wgt", "dchgCgoWgt");
		this.hashFields.put("arr_dep_prohi_flg", "arrDepProhiFlg");
		this.hashFields.put("to_eta_dt", "toEtaDt");
		this.hashFields.put("imdg_clss_cd_desc", "imdgClssCdDesc");
		this.hashFields.put("from_etd_dt", "fromEtdDt");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("lod_max_lmt", "lodMaxLmt");
		this.hashFields.put("cgo_wgt", "cgoWgt");
		this.hashFields.put("lod_lmt_rto", "lodLmtRto");
		this.hashFields.put("arr_max_lmt", "arrMaxLmt");
		this.hashFields.put("arr_lmt_rto", "arrLmtRto");
		this.hashFields.put("v_imdg_subs_rsk_lbl_cd", "vImdgSubsRskLblCd");
		this.hashFields.put("port_lmt_knd", "portLmtKnd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("dep_lmt_rto", "depLmtRto");
		this.hashFields.put("port_lmt_sub_ppt_cd", "portLmtSubPptCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ppt_flg_rmk", "pptFlgRmk");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("fp_chk", "fpChk");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("dchg_max_qty", "dchgMaxQty");
		this.hashFields.put("arr_max_qty", "arrMaxQty");
		this.hashFields.put("lod_cgo_wgt", "lodCgoWgt");
		this.hashFields.put("port_lmt_rep_desc", "portLmtRepDesc");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("dp_seq", "dpSeq");
		this.hashFields.put("rn", "rn");
		this.hashFields.put("imdg_pck_grp_cd", "imdgPckGrpCd");
		this.hashFields.put("flsh_pnt_temp", "flshPntTemp");
		this.hashFields.put("slan_cd1", "slanCd1");
		this.hashFields.put("flsh_pnt_cdo_temp", "flshPntCdoTemp");
		this.hashFields.put("dep_max_lmt", "depMaxLmt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("ldis_aply_tgt_flg", "ldisAplyTgtFlg");
		this.hashFields.put("lod_max_qty", "lodMaxQty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_tp_cd", "cntrTpCd");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("from_eta_dt", "fromEtaDt");
		this.hashFields.put("to_etd_dt", "toEtdDt");
		this.hashFields.put("dep_cgo_wgt", "depCgoWgt");
		this.hashFields.put("port_lmt_seq", "portLmtSeq");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cgo_lmt_rto", "cgoLmtRto");
		this.hashFields.put("ldis_prohi_flg", "ldisProhiFlg");
		this.hashFields.put("imdg_subs_rsk_lbl_cd", "imdgSubsRskLblCd");
		this.hashFields.put("dchg_max_lmt", "dchgMaxLmt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("dchg_lmt_rto", "dchgLmtRto");
		this.hashFields.put("arr_cgo_wgt", "arrCgoWgt");
		this.hashFields.put("lmt_wgt_tp_cd", "lmtWgtTpCd");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("dep_max_qty", "depMaxQty");
		this.hashFields.put("v_clss_info", "vClssInfo");
		this.hashFields.put("ppt_prohi_flg", "pptProhiFlg");
		this.hashFields.put("un_loc_cd_flg", "unLocCdFlg");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("lod_max_teu_qty", "lodMaxTeuQty");
		this.hashFields.put("dchg_max_teu_qty", "dchgMaxTeuQty");
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
	 * @return pptExploFlg
	 */
	public String getPptExploFlg() {
		return this.pptExploFlg;
	}
	
	/**
	 * Column Info
	 * @return unLocCd
	 */
	public String getUnLocCd() {
		return this.unLocCd;
	}
	
	/**
	 * Column Info
	 * @return pierTpCd
	 */
	public String getPierTpCd() {
		return this.pierTpCd;
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
	 * @return imdgCompGrpCd
	 */
	public String getImdgCompGrpCd() {
		return this.imdgCompGrpCd;
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
	 * @return dchgCgoWgt
	 */
	public String getDchgCgoWgt() {
		return this.dchgCgoWgt;
	}
	
	/**
	 * Column Info
	 * @return arrDepProhiFlg
	 */
	public String getArrDepProhiFlg() {
		return this.arrDepProhiFlg;
	}
	
	/**
	 * Column Info
	 * @return toEtaDt
	 */
	public String getToEtaDt() {
		return this.toEtaDt;
	}
	
	/**
	 * Column Info
	 * @return imdgClssCdDesc
	 */
	public String getImdgClssCdDesc() {
		return this.imdgClssCdDesc;
	}
	
	/**
	 * Column Info
	 * @return fromEtdDt
	 */
	public String getFromEtdDt() {
		return this.fromEtdDt;
	}
	
	/**
	 * Column Info
	 * @return updOfcCd
	 */
	public String getUpdOfcCd() {
		return this.updOfcCd;
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
	 * @return imdgUnNo
	 */
	public String getImdgUnNo() {
		return this.imdgUnNo;
	}
	
	/**
	 * Column Info
	 * @return lodMaxLmt
	 */
	public String getLodMaxLmt() {
		return this.lodMaxLmt;
	}
	
	/**
	 * Column Info
	 * @return cgoWgt
	 */
	public String getCgoWgt() {
		return this.cgoWgt;
	}
	
	/**
	 * Column Info
	 * @return lodLmtRto
	 */
	public String getLodLmtRto() {
		return this.lodLmtRto;
	}
	
	/**
	 * Column Info
	 * @return arrMaxLmt
	 */
	public String getArrMaxLmt() {
		return this.arrMaxLmt;
	}
	
	/**
	 * Column Info
	 * @return arrLmtRto
	 */
	public String getArrLmtRto() {
		return this.arrLmtRto;
	}
	
	/**
	 * Column Info
	 * @return vImdgSubsRskLblCd
	 */
	public String getVImdgSubsRskLblCd() {
		return this.vImdgSubsRskLblCd;
	}
	
	/**
	 * Column Info
	 * @return portLmtKnd
	 */
	public String getPortLmtKnd() {
		return this.portLmtKnd;
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
	 * @return depLmtRto
	 */
	public String getDepLmtRto() {
		return this.depLmtRto;
	}
	
	/**
	 * Column Info
	 * @return portLmtSubPptCd
	 */
	public String getPortLmtSubPptCd() {
		return this.portLmtSubPptCd;
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
	 * @return pptFlgRmk
	 */
	public String getPptFlgRmk() {
		return this.pptFlgRmk;
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
	 * @return fpChk
	 */
	public String getFpChk() {
		return this.fpChk;
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
	 * @return dchgMaxQty
	 */
	public String getDchgMaxQty() {
		return this.dchgMaxQty;
	}
	
	/**
	 * Column Info
	 * @return arrMaxQty
	 */
	public String getArrMaxQty() {
		return this.arrMaxQty;
	}
	
	/**
	 * Column Info
	 * @return lodCgoWgt
	 */
	public String getLodCgoWgt() {
		return this.lodCgoWgt;
	}
	
	/**
	 * Column Info
	 * @return portLmtRepDesc
	 */
	public String getPortLmtRepDesc() {
		return this.portLmtRepDesc;
	}
	
	/**
	 * Column Info
	 * @return imdgClssCd
	 */
	public String getImdgClssCd() {
		return this.imdgClssCd;
	}
	
	/**
	 * Column Info
	 * @return dpSeq
	 */
	public String getDpSeq() {
		return this.dpSeq;
	}
	
	/**
	 * Column Info
	 * @return rn
	 */
	public String getRn() {
		return this.rn;
	}
	
	/**
	 * Column Info
	 * @return imdgPckGrpCd
	 */
	public String getImdgPckGrpCd() {
		return this.imdgPckGrpCd;
	}
	
	/**
	 * Column Info
	 * @return flshPntTemp
	 */
	public String getFlshPntTemp() {
		return this.flshPntTemp;
	}
	
	/**
	 * Column Info
	 * @return slanCd1
	 */
	public String getSlanCd1() {
		return this.slanCd1;
	}
	
	/**
	 * Column Info
	 * @return flshPntCdoTemp
	 */
	public String getFlshPntCdoTemp() {
		return this.flshPntCdoTemp;
	}
	
	/**
	 * Column Info
	 * @return depMaxLmt
	 */
	public String getDepMaxLmt() {
		return this.depMaxLmt;
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
	 * @return ldisAplyTgtFlg
	 */
	public String getLdisAplyTgtFlg() {
		return this.ldisAplyTgtFlg;
	}
	
	/**
	 * Column Info
	 * @return lodMaxQty
	 */
	public String getLodMaxQty() {
		return this.lodMaxQty;
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
	 * @return cntrTpCd
	 */
	public String getCntrTpCd() {
		return this.cntrTpCd;
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
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return fromEtaDt
	 */
	public String getFromEtaDt() {
		return this.fromEtaDt;
	}
	
	/**
	 * Column Info
	 * @return toEtdDt
	 */
	public String getToEtdDt() {
		return this.toEtdDt;
	}
	
	/**
	 * Column Info
	 * @return depCgoWgt
	 */
	public String getDepCgoWgt() {
		return this.depCgoWgt;
	}
	
	/**
	 * Column Info
	 * @return portLmtSeq
	 */
	public String getPortLmtSeq() {
		return this.portLmtSeq;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
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
	 * @return cgoLmtRto
	 */
	public String getCgoLmtRto() {
		return this.cgoLmtRto;
	}
	
	/**
	 * Column Info
	 * @return ldisProhiFlg
	 */
	public String getLdisProhiFlg() {
		return this.ldisProhiFlg;
	}
	
	/**
	 * Column Info
	 * @return imdgSubsRskLblCd
	 */
	public String getImdgSubsRskLblCd() {
		return this.imdgSubsRskLblCd;
	}
	
	/**
	 * Column Info
	 * @return dchgMaxLmt
	 */
	public String getDchgMaxLmt() {
		return this.dchgMaxLmt;
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
	 * @return dchgLmtRto
	 */
	public String getDchgLmtRto() {
		return this.dchgLmtRto;
	}
	
	/**
	 * Column Info
	 * @return arrCgoWgt
	 */
	public String getArrCgoWgt() {
		return this.arrCgoWgt;
	}
	
	/**
	 * Column Info
	 * @return lmtWgtTpCd
	 */
	public String getLmtWgtTpCd() {
		return this.lmtWgtTpCd;
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
	 * @return depMaxQty
	 */
	public String getDepMaxQty() {
		return this.depMaxQty;
	}
	
	/**
	 * Column Info
	 * @return vClssInfo
	 */
	public String getVClssInfo() {
		return this.vClssInfo;
	}
	
	/**
	 * Column Info
	 * @return pptProhiFlg
	 */
	public String getPptProhiFlg() {
		return this.pptProhiFlg;
	}
	
	/**
	 * Column Info
	 * @return unLocCdFlg
	 */
	public String getUnLocCdFlg() {
		return this.unLocCdFlg;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return lodMaxTeuQty
	 */
	public String getLodMaxTeuQty() {
		return this.lodMaxTeuQty;
	}
	
	/**
	 * Column Info
	 * @return dchgMaxTeuQty
	 */
	public String getDchgMaxTeuQty() {
		return this.dchgMaxTeuQty;
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
	 * @param pptExploFlg
	 */
	public void setPptExploFlg(String pptExploFlg) {
		this.pptExploFlg = pptExploFlg;
	}
	
	/**
	 * Column Info
	 * @param unLocCd
	 */
	public void setUnLocCd(String unLocCd) {
		this.unLocCd = unLocCd;
	}
	
	/**
	 * Column Info
	 * @param pierTpCd
	 */
	public void setPierTpCd(String pierTpCd) {
		this.pierTpCd = pierTpCd;
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
	 * @param imdgCompGrpCd
	 */
	public void setImdgCompGrpCd(String imdgCompGrpCd) {
		this.imdgCompGrpCd = imdgCompGrpCd;
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
	 * @param dchgCgoWgt
	 */
	public void setDchgCgoWgt(String dchgCgoWgt) {
		this.dchgCgoWgt = dchgCgoWgt;
	}
	
	/**
	 * Column Info
	 * @param arrDepProhiFlg
	 */
	public void setArrDepProhiFlg(String arrDepProhiFlg) {
		this.arrDepProhiFlg = arrDepProhiFlg;
	}
	
	/**
	 * Column Info
	 * @param toEtaDt
	 */
	public void setToEtaDt(String toEtaDt) {
		this.toEtaDt = toEtaDt;
	}
	
	/**
	 * Column Info
	 * @param imdgClssCdDesc
	 */
	public void setImdgClssCdDesc(String imdgClssCdDesc) {
		this.imdgClssCdDesc = imdgClssCdDesc;
	}
	
	/**
	 * Column Info
	 * @param fromEtdDt
	 */
	public void setFromEtdDt(String fromEtdDt) {
		this.fromEtdDt = fromEtdDt;
	}
	
	/**
	 * Column Info
	 * @param updOfcCd
	 */
	public void setUpdOfcCd(String updOfcCd) {
		this.updOfcCd = updOfcCd;
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
	 * @param imdgUnNo
	 */
	public void setImdgUnNo(String imdgUnNo) {
		this.imdgUnNo = imdgUnNo;
	}
	
	/**
	 * Column Info
	 * @param lodMaxLmt
	 */
	public void setLodMaxLmt(String lodMaxLmt) {
		this.lodMaxLmt = lodMaxLmt;
	}
	
	/**
	 * Column Info
	 * @param cgoWgt
	 */
	public void setCgoWgt(String cgoWgt) {
		this.cgoWgt = cgoWgt;
	}
	
	/**
	 * Column Info
	 * @param lodLmtRto
	 */
	public void setLodLmtRto(String lodLmtRto) {
		this.lodLmtRto = lodLmtRto;
	}
	
	/**
	 * Column Info
	 * @param arrMaxLmt
	 */
	public void setArrMaxLmt(String arrMaxLmt) {
		this.arrMaxLmt = arrMaxLmt;
	}
	
	/**
	 * Column Info
	 * @param arrLmtRto
	 */
	public void setArrLmtRto(String arrLmtRto) {
		this.arrLmtRto = arrLmtRto;
	}
	
	/**
	 * Column Info
	 * @param vImdgSubsRskLblCd
	 */
	public void setVImdgSubsRskLblCd(String vImdgSubsRskLblCd) {
		this.vImdgSubsRskLblCd = vImdgSubsRskLblCd;
	}
	
	/**
	 * Column Info
	 * @param portLmtKnd
	 */
	public void setPortLmtKnd(String portLmtKnd) {
		this.portLmtKnd = portLmtKnd;
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
	 * @param depLmtRto
	 */
	public void setDepLmtRto(String depLmtRto) {
		this.depLmtRto = depLmtRto;
	}
	
	/**
	 * Column Info
	 * @param portLmtSubPptCd
	 */
	public void setPortLmtSubPptCd(String portLmtSubPptCd) {
		this.portLmtSubPptCd = portLmtSubPptCd;
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
	 * @param pptFlgRmk
	 */
	public void setPptFlgRmk(String pptFlgRmk) {
		this.pptFlgRmk = pptFlgRmk;
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
	 * @param fpChk
	 */
	public void setFpChk(String fpChk) {
		this.fpChk = fpChk;
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
	 * @param dchgMaxQty
	 */
	public void setDchgMaxQty(String dchgMaxQty) {
		this.dchgMaxQty = dchgMaxQty;
	}
	
	/**
	 * Column Info
	 * @param arrMaxQty
	 */
	public void setArrMaxQty(String arrMaxQty) {
		this.arrMaxQty = arrMaxQty;
	}
	
	/**
	 * Column Info
	 * @param lodCgoWgt
	 */
	public void setLodCgoWgt(String lodCgoWgt) {
		this.lodCgoWgt = lodCgoWgt;
	}
	
	/**
	 * Column Info
	 * @param portLmtRepDesc
	 */
	public void setPortLmtRepDesc(String portLmtRepDesc) {
		this.portLmtRepDesc = portLmtRepDesc;
	}
	
	/**
	 * Column Info
	 * @param imdgClssCd
	 */
	public void setImdgClssCd(String imdgClssCd) {
		this.imdgClssCd = imdgClssCd;
	}
	
	/**
	 * Column Info
	 * @param dpSeq
	 */
	public void setDpSeq(String dpSeq) {
		this.dpSeq = dpSeq;
	}
	
	/**
	 * Column Info
	 * @param rn
	 */
	public void setRn(String rn) {
		this.rn = rn;
	}
	
	/**
	 * Column Info
	 * @param imdgPckGrpCd
	 */
	public void setImdgPckGrpCd(String imdgPckGrpCd) {
		this.imdgPckGrpCd = imdgPckGrpCd;
	}
	
	/**
	 * Column Info
	 * @param flshPntTemp
	 */
	public void setFlshPntTemp(String flshPntTemp) {
		this.flshPntTemp = flshPntTemp;
	}
	
	/**
	 * Column Info
	 * @param slanCd1
	 */
	public void setSlanCd1(String slanCd1) {
		this.slanCd1 = slanCd1;
	}
	
	/**
	 * Column Info
	 * @param flshPntCdoTemp
	 */
	public void setFlshPntCdoTemp(String flshPntCdoTemp) {
		this.flshPntCdoTemp = flshPntCdoTemp;
	}
	
	/**
	 * Column Info
	 * @param depMaxLmt
	 */
	public void setDepMaxLmt(String depMaxLmt) {
		this.depMaxLmt = depMaxLmt;
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
	 * @param ldisAplyTgtFlg
	 */
	public void setLdisAplyTgtFlg(String ldisAplyTgtFlg) {
		this.ldisAplyTgtFlg = ldisAplyTgtFlg;
	}
	
	/**
	 * Column Info
	 * @param lodMaxQty
	 */
	public void setLodMaxQty(String lodMaxQty) {
		this.lodMaxQty = lodMaxQty;
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
	 * @param cntrTpCd
	 */
	public void setCntrTpCd(String cntrTpCd) {
		this.cntrTpCd = cntrTpCd;
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
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param fromEtaDt
	 */
	public void setFromEtaDt(String fromEtaDt) {
		this.fromEtaDt = fromEtaDt;
	}
	
	/**
	 * Column Info
	 * @param toEtdDt
	 */
	public void setToEtdDt(String toEtdDt) {
		this.toEtdDt = toEtdDt;
	}
	
	/**
	 * Column Info
	 * @param depCgoWgt
	 */
	public void setDepCgoWgt(String depCgoWgt) {
		this.depCgoWgt = depCgoWgt;
	}
	
	/**
	 * Column Info
	 * @param portLmtSeq
	 */
	public void setPortLmtSeq(String portLmtSeq) {
		this.portLmtSeq = portLmtSeq;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
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
	 * @param cgoLmtRto
	 */
	public void setCgoLmtRto(String cgoLmtRto) {
		this.cgoLmtRto = cgoLmtRto;
	}
	
	/**
	 * Column Info
	 * @param ldisProhiFlg
	 */
	public void setLdisProhiFlg(String ldisProhiFlg) {
		this.ldisProhiFlg = ldisProhiFlg;
	}
	
	/**
	 * Column Info
	 * @param imdgSubsRskLblCd
	 */
	public void setImdgSubsRskLblCd(String imdgSubsRskLblCd) {
		this.imdgSubsRskLblCd = imdgSubsRskLblCd;
	}
	
	/**
	 * Column Info
	 * @param dchgMaxLmt
	 */
	public void setDchgMaxLmt(String dchgMaxLmt) {
		this.dchgMaxLmt = dchgMaxLmt;
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
	 * @param dchgLmtRto
	 */
	public void setDchgLmtRto(String dchgLmtRto) {
		this.dchgLmtRto = dchgLmtRto;
	}
	
	/**
	 * Column Info
	 * @param arrCgoWgt
	 */
	public void setArrCgoWgt(String arrCgoWgt) {
		this.arrCgoWgt = arrCgoWgt;
	}
	
	/**
	 * Column Info
	 * @param lmtWgtTpCd
	 */
	public void setLmtWgtTpCd(String lmtWgtTpCd) {
		this.lmtWgtTpCd = lmtWgtTpCd;
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
	 * @param depMaxQty
	 */
	public void setDepMaxQty(String depMaxQty) {
		this.depMaxQty = depMaxQty;
	}
	
	/**
	 * Column Info
	 * @param vClssInfo
	 */
	public void setVClssInfo(String vClssInfo) {
		this.vClssInfo = vClssInfo;
	}
	
	/**
	 * Column Info
	 * @param pptProhiFlg
	 */
	public void setPptProhiFlg(String pptProhiFlg) {
		this.pptProhiFlg = pptProhiFlg;
	}
	
	/**
	 * Column Info
	 * @param unLocCdFlg
	 */
	public void setUnLocCdFlg(String unLocCdFlg) {
		this.unLocCdFlg = unLocCdFlg;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param lodMaxTeuQty
	 */
	public void setLodMaxTeuQty(String lodMaxTeuQty) {
		this.lodMaxTeuQty = lodMaxTeuQty;
	}
	
	/**
	 * Column Info
	 * @param dchgMaxTeuQty
	 */
	public void setDchgMaxTeuQty(String dchgMaxTeuQty) {
		this.dchgMaxTeuQty = dchgMaxTeuQty;
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
		setPptExploFlg(JSPUtil.getParameter(request, prefix + "ppt_explo_flg", ""));
		setUnLocCd(JSPUtil.getParameter(request, prefix + "un_loc_cd", ""));
		setPierTpCd(JSPUtil.getParameter(request, prefix + "pier_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setImdgCompGrpCd(JSPUtil.getParameter(request, prefix + "imdg_comp_grp_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setDchgCgoWgt(JSPUtil.getParameter(request, prefix + "dchg_cgo_wgt", ""));
		setArrDepProhiFlg(JSPUtil.getParameter(request, prefix + "arr_dep_prohi_flg", ""));
		setToEtaDt(JSPUtil.getParameter(request, prefix + "to_eta_dt", ""));
		setImdgClssCdDesc(JSPUtil.getParameter(request, prefix + "imdg_clss_cd_desc", ""));
		setFromEtdDt(JSPUtil.getParameter(request, prefix + "from_etd_dt", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, prefix + "upd_ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setImdgUnNo(JSPUtil.getParameter(request, prefix + "imdg_un_no", ""));
		setLodMaxLmt(JSPUtil.getParameter(request, prefix + "lod_max_lmt", ""));
		setCgoWgt(JSPUtil.getParameter(request, prefix + "cgo_wgt", ""));
		setLodLmtRto(JSPUtil.getParameter(request, prefix + "lod_lmt_rto", ""));
		setArrMaxLmt(JSPUtil.getParameter(request, prefix + "arr_max_lmt", ""));
		setArrLmtRto(JSPUtil.getParameter(request, prefix + "arr_lmt_rto", ""));
		setVImdgSubsRskLblCd(JSPUtil.getParameter(request, prefix + "v_imdg_subs_rsk_lbl_cd", ""));
		setPortLmtKnd(JSPUtil.getParameter(request, prefix + "port_lmt_knd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setDepLmtRto(JSPUtil.getParameter(request, prefix + "dep_lmt_rto", ""));
		setPortLmtSubPptCd(JSPUtil.getParameter(request, prefix + "port_lmt_sub_ppt_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setPptFlgRmk(JSPUtil.getParameter(request, prefix + "ppt_flg_rmk", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setFpChk(JSPUtil.getParameter(request, prefix + "fp_chk", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setDchgMaxQty(JSPUtil.getParameter(request, prefix + "dchg_max_qty", ""));
		setArrMaxQty(JSPUtil.getParameter(request, prefix + "arr_max_qty", ""));
		setLodCgoWgt(JSPUtil.getParameter(request, prefix + "lod_cgo_wgt", ""));
		setPortLmtRepDesc(JSPUtil.getParameter(request, prefix + "port_lmt_rep_desc", ""));
		setImdgClssCd(JSPUtil.getParameter(request, prefix + "imdg_clss_cd", ""));
		setDpSeq(JSPUtil.getParameter(request, prefix + "dp_seq", ""));
		setRn(JSPUtil.getParameter(request, prefix + "rn", ""));
		setImdgPckGrpCd(JSPUtil.getParameter(request, prefix + "imdg_pck_grp_cd", ""));
		setFlshPntTemp(JSPUtil.getParameter(request, prefix + "flsh_pnt_temp", ""));
		setSlanCd1(JSPUtil.getParameter(request, prefix + "slan_cd1", ""));
		setFlshPntCdoTemp(JSPUtil.getParameter(request, prefix + "flsh_pnt_cdo_temp", ""));
		setDepMaxLmt(JSPUtil.getParameter(request, prefix + "dep_max_lmt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setLdisAplyTgtFlg(JSPUtil.getParameter(request, prefix + "ldis_aply_tgt_flg", ""));
		setLodMaxQty(JSPUtil.getParameter(request, prefix + "lod_max_qty", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntrTpCd(JSPUtil.getParameter(request, prefix + "cntr_tp_cd", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setFromEtaDt(JSPUtil.getParameter(request, prefix + "from_eta_dt", ""));
		setToEtdDt(JSPUtil.getParameter(request, prefix + "to_etd_dt", ""));
		setDepCgoWgt(JSPUtil.getParameter(request, prefix + "dep_cgo_wgt", ""));
		setPortLmtSeq(JSPUtil.getParameter(request, prefix + "port_lmt_seq", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCgoLmtRto(JSPUtil.getParameter(request, prefix + "cgo_lmt_rto", ""));
		setLdisProhiFlg(JSPUtil.getParameter(request, prefix + "ldis_prohi_flg", ""));
		setImdgSubsRskLblCd(JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_cd", ""));
		setDchgMaxLmt(JSPUtil.getParameter(request, prefix + "dchg_max_lmt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setDchgLmtRto(JSPUtil.getParameter(request, prefix + "dchg_lmt_rto", ""));
		setArrCgoWgt(JSPUtil.getParameter(request, prefix + "arr_cgo_wgt", ""));
		setLmtWgtTpCd(JSPUtil.getParameter(request, prefix + "lmt_wgt_tp_cd", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setDepMaxQty(JSPUtil.getParameter(request, prefix + "dep_max_qty", ""));
		setVClssInfo(JSPUtil.getParameter(request, prefix + "v_clss_info", ""));
		setPptProhiFlg(JSPUtil.getParameter(request, prefix + "ppt_prohi_flg", ""));
		setUnLocCdFlg(JSPUtil.getParameter(request, prefix + "un_loc_cd_flg", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setLodMaxTeuQty(JSPUtil.getParameter(request, prefix + "lod_max_teu_qty", ""));
		setDchgMaxTeuQty(JSPUtil.getParameter(request, prefix + "dchg_max_teu_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PortLimitsDataVO[]
	 */
	public PortLimitsDataVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PortLimitsDataVO[]
	 */
	public PortLimitsDataVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PortLimitsDataVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] pptExploFlg = (JSPUtil.getParameter(request, prefix	+ "ppt_explo_flg", length));
			String[] unLocCd = (JSPUtil.getParameter(request, prefix	+ "un_loc_cd", length));
			String[] pierTpCd = (JSPUtil.getParameter(request, prefix	+ "pier_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] imdgCompGrpCd = (JSPUtil.getParameter(request, prefix	+ "imdg_comp_grp_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] dchgCgoWgt = (JSPUtil.getParameter(request, prefix	+ "dchg_cgo_wgt", length));
			String[] arrDepProhiFlg = (JSPUtil.getParameter(request, prefix	+ "arr_dep_prohi_flg", length));
			String[] toEtaDt = (JSPUtil.getParameter(request, prefix	+ "to_eta_dt", length));
			String[] imdgClssCdDesc = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd_desc", length));
			String[] fromEtdDt = (JSPUtil.getParameter(request, prefix	+ "from_etd_dt", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			String[] lodMaxLmt = (JSPUtil.getParameter(request, prefix	+ "lod_max_lmt", length));
			String[] cgoWgt = (JSPUtil.getParameter(request, prefix	+ "cgo_wgt", length));
			String[] lodLmtRto = (JSPUtil.getParameter(request, prefix	+ "lod_lmt_rto", length));
			String[] arrMaxLmt = (JSPUtil.getParameter(request, prefix	+ "arr_max_lmt", length));
			String[] arrLmtRto = (JSPUtil.getParameter(request, prefix	+ "arr_lmt_rto", length));
			String[] vImdgSubsRskLblCd = (JSPUtil.getParameter(request, prefix	+ "v_imdg_subs_rsk_lbl_cd", length));
			String[] portLmtKnd = (JSPUtil.getParameter(request, prefix	+ "port_lmt_knd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] depLmtRto = (JSPUtil.getParameter(request, prefix	+ "dep_lmt_rto", length));
			String[] portLmtSubPptCd = (JSPUtil.getParameter(request, prefix	+ "port_lmt_sub_ppt_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] pptFlgRmk = (JSPUtil.getParameter(request, prefix	+ "ppt_flg_rmk", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] fpChk = (JSPUtil.getParameter(request, prefix	+ "fp_chk", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] dchgMaxQty = (JSPUtil.getParameter(request, prefix	+ "dchg_max_qty", length));
			String[] arrMaxQty = (JSPUtil.getParameter(request, prefix	+ "arr_max_qty", length));
			String[] lodCgoWgt = (JSPUtil.getParameter(request, prefix	+ "lod_cgo_wgt", length));
			String[] portLmtRepDesc = (JSPUtil.getParameter(request, prefix	+ "port_lmt_rep_desc", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			String[] dpSeq = (JSPUtil.getParameter(request, prefix	+ "dp_seq", length));
			String[] rn = (JSPUtil.getParameter(request, prefix	+ "rn", length));
			String[] imdgPckGrpCd = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_grp_cd", length));
			String[] flshPntTemp = (JSPUtil.getParameter(request, prefix	+ "flsh_pnt_temp", length));
			String[] slanCd1 = (JSPUtil.getParameter(request, prefix	+ "slan_cd1", length));
			String[] flshPntCdoTemp = (JSPUtil.getParameter(request, prefix	+ "flsh_pnt_cdo_temp", length));
			String[] depMaxLmt = (JSPUtil.getParameter(request, prefix	+ "dep_max_lmt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] ldisAplyTgtFlg = (JSPUtil.getParameter(request, prefix	+ "ldis_aply_tgt_flg", length));
			String[] lodMaxQty = (JSPUtil.getParameter(request, prefix	+ "lod_max_qty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrTpCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tp_cd", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] fromEtaDt = (JSPUtil.getParameter(request, prefix	+ "from_eta_dt", length));
			String[] toEtdDt = (JSPUtil.getParameter(request, prefix	+ "to_etd_dt", length));
			String[] depCgoWgt = (JSPUtil.getParameter(request, prefix	+ "dep_cgo_wgt", length));
			String[] portLmtSeq = (JSPUtil.getParameter(request, prefix	+ "port_lmt_seq", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] cgoLmtRto = (JSPUtil.getParameter(request, prefix	+ "cgo_lmt_rto", length));
			String[] ldisProhiFlg = (JSPUtil.getParameter(request, prefix	+ "ldis_prohi_flg", length));
			String[] imdgSubsRskLblCd = (JSPUtil.getParameter(request, prefix	+ "imdg_subs_rsk_lbl_cd", length));
			String[] dchgMaxLmt = (JSPUtil.getParameter(request, prefix	+ "dchg_max_lmt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] dchgLmtRto = (JSPUtil.getParameter(request, prefix	+ "dchg_lmt_rto", length));
			String[] arrCgoWgt = (JSPUtil.getParameter(request, prefix	+ "arr_cgo_wgt", length));
			String[] lmtWgtTpCd = (JSPUtil.getParameter(request, prefix	+ "lmt_wgt_tp_cd", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] depMaxQty = (JSPUtil.getParameter(request, prefix	+ "dep_max_qty", length));
			String[] vClssInfo = (JSPUtil.getParameter(request, prefix	+ "v_clss_info", length));
			String[] pptProhiFlg = (JSPUtil.getParameter(request, prefix	+ "ppt_prohi_flg", length));
			String[] unLocCdFlg = (JSPUtil.getParameter(request, prefix	+ "un_loc_cd_flg", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] lodMaxTeuQty = (JSPUtil.getParameter(request, prefix	+ "lod_max_teu_qty", length));
			String[] dchgMaxTeuQty = (JSPUtil.getParameter(request, prefix	+ "dchg_max_teu_qty", length));
			
			for (int i = 0; i < length; i++) {
				model = new PortLimitsDataVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (pptExploFlg[i] != null)
					model.setPptExploFlg(pptExploFlg[i]);
				if (unLocCd[i] != null)
					model.setUnLocCd(unLocCd[i]);
				if (pierTpCd[i] != null)
					model.setPierTpCd(pierTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (imdgCompGrpCd[i] != null)
					model.setImdgCompGrpCd(imdgCompGrpCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (dchgCgoWgt[i] != null)
					model.setDchgCgoWgt(dchgCgoWgt[i]);
				if (arrDepProhiFlg[i] != null)
					model.setArrDepProhiFlg(arrDepProhiFlg[i]);
				if (toEtaDt[i] != null)
					model.setToEtaDt(toEtaDt[i]);
				if (imdgClssCdDesc[i] != null)
					model.setImdgClssCdDesc(imdgClssCdDesc[i]);
				if (fromEtdDt[i] != null)
					model.setFromEtdDt(fromEtdDt[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (lodMaxLmt[i] != null)
					model.setLodMaxLmt(lodMaxLmt[i]);
				if (cgoWgt[i] != null)
					model.setCgoWgt(cgoWgt[i]);
				if (lodLmtRto[i] != null)
					model.setLodLmtRto(lodLmtRto[i]);
				if (arrMaxLmt[i] != null)
					model.setArrMaxLmt(arrMaxLmt[i]);
				if (arrLmtRto[i] != null)
					model.setArrLmtRto(arrLmtRto[i]);
				if (vImdgSubsRskLblCd[i] != null)
					model.setVImdgSubsRskLblCd(vImdgSubsRskLblCd[i]);
				if (portLmtKnd[i] != null)
					model.setPortLmtKnd(portLmtKnd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (depLmtRto[i] != null)
					model.setDepLmtRto(depLmtRto[i]);
				if (portLmtSubPptCd[i] != null)
					model.setPortLmtSubPptCd(portLmtSubPptCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (pptFlgRmk[i] != null)
					model.setPptFlgRmk(pptFlgRmk[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (fpChk[i] != null)
					model.setFpChk(fpChk[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (dchgMaxQty[i] != null)
					model.setDchgMaxQty(dchgMaxQty[i]);
				if (arrMaxQty[i] != null)
					model.setArrMaxQty(arrMaxQty[i]);
				if (lodCgoWgt[i] != null)
					model.setLodCgoWgt(lodCgoWgt[i]);
				if (portLmtRepDesc[i] != null)
					model.setPortLmtRepDesc(portLmtRepDesc[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				if (dpSeq[i] != null)
					model.setDpSeq(dpSeq[i]);
				if (rn[i] != null)
					model.setRn(rn[i]);
				if (imdgPckGrpCd[i] != null)
					model.setImdgPckGrpCd(imdgPckGrpCd[i]);
				if (flshPntTemp[i] != null)
					model.setFlshPntTemp(flshPntTemp[i]);
				if (slanCd1[i] != null)
					model.setSlanCd1(slanCd1[i]);
				if (flshPntCdoTemp[i] != null)
					model.setFlshPntCdoTemp(flshPntCdoTemp[i]);
				if (depMaxLmt[i] != null)
					model.setDepMaxLmt(depMaxLmt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (ldisAplyTgtFlg[i] != null)
					model.setLdisAplyTgtFlg(ldisAplyTgtFlg[i]);
				if (lodMaxQty[i] != null)
					model.setLodMaxQty(lodMaxQty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrTpCd[i] != null)
					model.setCntrTpCd(cntrTpCd[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (fromEtaDt[i] != null)
					model.setFromEtaDt(fromEtaDt[i]);
				if (toEtdDt[i] != null)
					model.setToEtdDt(toEtdDt[i]);
				if (depCgoWgt[i] != null)
					model.setDepCgoWgt(depCgoWgt[i]);
				if (portLmtSeq[i] != null)
					model.setPortLmtSeq(portLmtSeq[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (cgoLmtRto[i] != null)
					model.setCgoLmtRto(cgoLmtRto[i]);
				if (ldisProhiFlg[i] != null)
					model.setLdisProhiFlg(ldisProhiFlg[i]);
				if (imdgSubsRskLblCd[i] != null)
					model.setImdgSubsRskLblCd(imdgSubsRskLblCd[i]);
				if (dchgMaxLmt[i] != null)
					model.setDchgMaxLmt(dchgMaxLmt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (dchgLmtRto[i] != null)
					model.setDchgLmtRto(dchgLmtRto[i]);
				if (arrCgoWgt[i] != null)
					model.setArrCgoWgt(arrCgoWgt[i]);
				if (lmtWgtTpCd[i] != null)
					model.setLmtWgtTpCd(lmtWgtTpCd[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (depMaxQty[i] != null)
					model.setDepMaxQty(depMaxQty[i]);
				if (vClssInfo[i] != null)
					model.setVClssInfo(vClssInfo[i]);
				if (pptProhiFlg[i] != null)
					model.setPptProhiFlg(pptProhiFlg[i]);
				if (unLocCdFlg[i] != null)
					model.setUnLocCdFlg(unLocCdFlg[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (lodMaxTeuQty[i] != null)
					model.setLodMaxTeuQty(lodMaxTeuQty[i]);
				if (dchgMaxTeuQty[i] != null)
					model.setDchgMaxTeuQty(dchgMaxTeuQty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPortLimitsDataVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PortLimitsDataVO[]
	 */
	public PortLimitsDataVO[] getPortLimitsDataVOs(){
		PortLimitsDataVO[] vos = (PortLimitsDataVO[])models.toArray(new PortLimitsDataVO[models.size()]);
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
		this.pptExploFlg = this.pptExploFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unLocCd = this.unLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pierTpCd = this.pierTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgCompGrpCd = this.imdgCompGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dchgCgoWgt = this.dchgCgoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrDepProhiFlg = this.arrDepProhiFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEtaDt = this.toEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCdDesc = this.imdgClssCdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromEtdDt = this.fromEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodMaxLmt = this.lodMaxLmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoWgt = this.cgoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodLmtRto = this.lodLmtRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrMaxLmt = this.arrMaxLmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrLmtRto = this.arrLmtRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vImdgSubsRskLblCd = this.vImdgSubsRskLblCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portLmtKnd = this.portLmtKnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depLmtRto = this.depLmtRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portLmtSubPptCd = this.portLmtSubPptCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pptFlgRmk = this.pptFlgRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fpChk = this.fpChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dchgMaxQty = this.dchgMaxQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrMaxQty = this.arrMaxQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodCgoWgt = this.lodCgoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portLmtRepDesc = this.portLmtRepDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpSeq = this.dpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rn = this.rn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckGrpCd = this.imdgPckGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flshPntTemp = this.flshPntTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd1 = this.slanCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flshPntCdoTemp = this.flshPntCdoTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depMaxLmt = this.depMaxLmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ldisAplyTgtFlg = this.ldisAplyTgtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodMaxQty = this.lodMaxQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpCd = this.cntrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromEtaDt = this.fromEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEtdDt = this.toEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depCgoWgt = this.depCgoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portLmtSeq = this.portLmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoLmtRto = this.cgoLmtRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ldisProhiFlg = this.ldisProhiFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSubsRskLblCd = this.imdgSubsRskLblCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dchgMaxLmt = this.dchgMaxLmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dchgLmtRto = this.dchgLmtRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrCgoWgt = this.arrCgoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lmtWgtTpCd = this.lmtWgtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depMaxQty = this.depMaxQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vClssInfo = this.vClssInfo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pptProhiFlg = this.pptProhiFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unLocCdFlg = this.unLocCdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodMaxTeuQty = this.lodMaxTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dchgMaxTeuQty = this.dchgMaxTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
