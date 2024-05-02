/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchOwnDGListVO.java
*@FileTitle : SearchOwnDGListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.28
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2014.10.28 원종규 
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
 * @author 원종규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchOwnDGListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchOwnDGListVO> models = new ArrayList<SearchOwnDGListVO>();
	
	/* Column Info */
	private String spclCgoRqstSeq = null;
	/* Column Info */
	private String dcgoQty = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String no = null;
	/* Column Info */
	private String imdgUnNoSeq = null;
	/* Column Info */
	private String psaNo = null;
	/* Column Info */
	private String scgFlg = null;
	/* Column Info */
	private String netWgtSum = null;
	/* Column Info */
	private String dcgoSeq = null;
	/* Column Info */
	private String outImdgPckQty1 = null;
	/* Column Info */
	private String crrCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String polClptIndSeq = null;
	/* Column Info */
	private String mrnPolutFlg = null;
	/* Column Info */
	private String hcdgFlg = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Column Info */
	private String intmdImdgPckQty1 = null;
	/* Column Info */
	private String spclCgoAuthNo = null;
	/* Column Info */
	private String rgnShpOprCd = null;
	/* Column Info */
	private String authOfcCd = null;
	/* Column Info */
	private String dgTp = null;
	/* Column Info */
	private String authDt = null;
	/* Column Info */
	private String netWgt = null;
	/* Column Info */
	private String spclCgoCateCd = null;
	/* Column Info */
	private String podClptIndSeq = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String spclCgoAuthRjctCd = null;
	/* Column Info */
	private String vslPrePstNm = null;
	/* Column Info */
	private String cntrCgoSeq = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String imdgSegrGrpNo = null;
	/* Column Info */
	private String spclRqstDesc = null;
	/* Column Info */
	private String netExploWgt = null;
	/* Column Info */
	private String spclCgoAuthRmk = null;
	/* Column Info */
	private String spclCgoAuthSeq = null;
	/* Column Info */
	private String authUsrId = null;
	/* Column Info */
	private String aproRefNo = null;
	/* Column Info */
	private String imdgClssCd = null;
	/* Column Info */
	private String grsWgt = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String rqstUsrId = null;
	/* Column Info */
	private String rqstDay = null;
	/* Column Info */
	private String imdgPckGrpCd = null;
	/* Column Info */
	private String flshPntCdoTemp = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String bkgRcvTermCd = null;
	/* Column Info */
	private String vslSeq = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Column Info */
	private String rqstGdt = null;
	/* Column Info */
	private String lstRqstDatFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String spclCgoAproRqstSeq = null;
	/* Column Info */
	private String vslPrePstCd = null;
	/* Column Info */
	private String podYdCd = null;
	/* Column Info */
	private String imdgExptQtyFlg = null;
	/* Column Info */
	private String dgCntrSeq = null;
	/* Column Info */
	private String rqstDt = null;
	/* Column Info */
	private String rqstAuthCd = null;
	/* Column Info */
	private String spclCgoAuthCd = null;
	/* Column Info */
	private String bookingNo = null;
	/* Column Info */
	private String imdgSubsRskLblCd = null;
	/* Column Info */
	private String emlSndNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String crrCode = null;
	/* Column Info */
	private String authGdt = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String polYdCd = null;
	/* Column Info */
	private String inImdgPckQty1 = null;
	/* Column Info */
	private String rqstOfcCd = null;
	/* Column Info */
	private String bkgDeTermCd = null;
	/* Column Info */
	private String imdgLmtQtyFlg = null;
	/* Column Info */
	private String wgtUtCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchOwnDGListVO() {}

	public SearchOwnDGListVO(String ibflag, String pagerows, String spclCgoRqstSeq, String dcgoQty, String vslCd, String no, String imdgUnNoSeq, String psaNo, String scgFlg, String netWgtSum, String dcgoSeq, String outImdgPckQty1, String crrCd, String crrCode, String polCd, String cntrTpszCd, String polClptIndSeq, String mrnPolutFlg, String intmdImdgPckQty1, String imdgUnNo, String hcdgFlg, String spclCgoAuthNo, String rgnShpOprCd, String authOfcCd, String dgTp, String authDt, String netWgt, String netExploWgt, String spclCgoCateCd, String podClptIndSeq, String delCd, String skdVoyNo, String spclCgoAuthRjctCd, String cntrCgoSeq, String podCd, String bkgNo, String spclRqstDesc, String spclCgoAuthRmk, String spclCgoAuthSeq, String authUsrId, String aproRefNo, String imdgClssCd, String grsWgt, String porCd, String rqstUsrId, String rqstDay, String imdgPckGrpCd, String bkgStsCd, String flshPntCdoTemp, String bkgRcvTermCd, String vslSeq, String vpsEtaDt, String lstRqstDatFlg, String spclCgoAproRqstSeq, String vslPrePstCd, String vslPrePstNm, String podYdCd, String dgCntrSeq, String imdgExptQtyFlg, String rqstDt, String rqstAuthCd, String bookingNo, String spclCgoAuthCd, String imdgSubsRskLblCd, String emlSndNo, String skdDirCd, String slanCd, String polYdCd, String cntrNo, String inImdgPckQty1, String rqstOfcCd, String bkgDeTermCd, String imdgLmtQtyFlg, String rqstGdt, String authGdt, String imdgSegrGrpNo, String wgtUtCd) {
		this.spclCgoRqstSeq = spclCgoRqstSeq;
		this.dcgoQty = dcgoQty;
		this.vslCd = vslCd;
		this.no = no;
		this.imdgUnNoSeq = imdgUnNoSeq;
		this.psaNo = psaNo;
		this.scgFlg = scgFlg;
		this.netWgtSum = netWgtSum;
		this.dcgoSeq = dcgoSeq;
		this.outImdgPckQty1 = outImdgPckQty1;
		this.crrCd = crrCd;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.cntrTpszCd = cntrTpszCd;
		this.polClptIndSeq = polClptIndSeq;
		this.mrnPolutFlg = mrnPolutFlg;
		this.hcdgFlg = hcdgFlg;
		this.imdgUnNo = imdgUnNo;
		this.intmdImdgPckQty1 = intmdImdgPckQty1;
		this.spclCgoAuthNo = spclCgoAuthNo;
		this.rgnShpOprCd = rgnShpOprCd;
		this.authOfcCd = authOfcCd;
		this.dgTp = dgTp;
		this.authDt = authDt;
		this.netWgt = netWgt;
		this.spclCgoCateCd = spclCgoCateCd;
		this.podClptIndSeq = podClptIndSeq;
		this.delCd = delCd;
		this.skdVoyNo = skdVoyNo;
		this.spclCgoAuthRjctCd = spclCgoAuthRjctCd;
		this.vslPrePstNm = vslPrePstNm;
		this.cntrCgoSeq = cntrCgoSeq;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.imdgSegrGrpNo = imdgSegrGrpNo;
		this.spclRqstDesc = spclRqstDesc;
		this.netExploWgt = netExploWgt;
		this.spclCgoAuthRmk = spclCgoAuthRmk;
		this.spclCgoAuthSeq = spclCgoAuthSeq;
		this.authUsrId = authUsrId;
		this.aproRefNo = aproRefNo;
		this.imdgClssCd = imdgClssCd;
		this.grsWgt = grsWgt;
		this.porCd = porCd;
		this.rqstUsrId = rqstUsrId;
		this.rqstDay = rqstDay;
		this.imdgPckGrpCd = imdgPckGrpCd;
		this.flshPntCdoTemp = flshPntCdoTemp;
		this.bkgStsCd = bkgStsCd;
		this.bkgRcvTermCd = bkgRcvTermCd;
		this.vslSeq = vslSeq;
		this.vpsEtaDt = vpsEtaDt;
		this.rqstGdt = rqstGdt;
		this.lstRqstDatFlg = lstRqstDatFlg;
		this.ibflag = ibflag;
		this.spclCgoAproRqstSeq = spclCgoAproRqstSeq;
		this.vslPrePstCd = vslPrePstCd;
		this.podYdCd = podYdCd;
		this.imdgExptQtyFlg = imdgExptQtyFlg;
		this.dgCntrSeq = dgCntrSeq;
		this.rqstDt = rqstDt;
		this.rqstAuthCd = rqstAuthCd;
		this.spclCgoAuthCd = spclCgoAuthCd;
		this.bookingNo = bookingNo;
		this.imdgSubsRskLblCd = imdgSubsRskLblCd;
		this.emlSndNo = emlSndNo;
		this.skdDirCd = skdDirCd;
		this.crrCode = crrCode;
		this.authGdt = authGdt;
		this.slanCd = slanCd;
		this.cntrNo = cntrNo;
		this.polYdCd = polYdCd;
		this.inImdgPckQty1 = inImdgPckQty1;
		this.rqstOfcCd = rqstOfcCd;
		this.bkgDeTermCd = bkgDeTermCd;
		this.imdgLmtQtyFlg = imdgLmtQtyFlg;
		this.wgtUtCd       = wgtUtCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("spcl_cgo_rqst_seq", getSpclCgoRqstSeq());
		this.hashColumns.put("dcgo_qty", getDcgoQty());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("no", getNo());
		this.hashColumns.put("imdg_un_no_seq", getImdgUnNoSeq());
		this.hashColumns.put("psa_no", getPsaNo());
		this.hashColumns.put("scg_flg", getScgFlg());
		this.hashColumns.put("net_wgt_sum", getNetWgtSum());
		this.hashColumns.put("dcgo_seq", getDcgoSeq());
		this.hashColumns.put("out_imdg_pck_qty1", getOutImdgPckQty1());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("pol_clpt_ind_seq", getPolClptIndSeq());
		this.hashColumns.put("mrn_polut_flg", getMrnPolutFlg());
		this.hashColumns.put("hcdg_flg", getHcdgFlg());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("intmd_imdg_pck_qty1", getIntmdImdgPckQty1());
		this.hashColumns.put("spcl_cgo_auth_no", getSpclCgoAuthNo());
		this.hashColumns.put("rgn_shp_opr_cd", getRgnShpOprCd());
		this.hashColumns.put("auth_ofc_cd", getAuthOfcCd());
		this.hashColumns.put("dg_tp", getDgTp());
		this.hashColumns.put("auth_dt", getAuthDt());
		this.hashColumns.put("net_wgt", getNetWgt());
		this.hashColumns.put("spcl_cgo_cate_cd", getSpclCgoCateCd());
		this.hashColumns.put("pod_clpt_ind_seq", getPodClptIndSeq());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("spcl_cgo_auth_rjct_cd", getSpclCgoAuthRjctCd());
		this.hashColumns.put("vsl_pre_pst_nm", getVslPrePstNm());
		this.hashColumns.put("cntr_cgo_seq", getCntrCgoSeq());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("imdg_segr_grp_no", getImdgSegrGrpNo());
		this.hashColumns.put("spcl_rqst_desc", getSpclRqstDesc());
		this.hashColumns.put("net_explo_wgt", getNetExploWgt());
		this.hashColumns.put("spcl_cgo_auth_rmk", getSpclCgoAuthRmk());
		this.hashColumns.put("spcl_cgo_auth_seq", getSpclCgoAuthSeq());
		this.hashColumns.put("auth_usr_id", getAuthUsrId());
		this.hashColumns.put("apro_ref_no", getAproRefNo());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		this.hashColumns.put("grs_wgt", getGrsWgt());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("rqst_usr_id", getRqstUsrId());
		this.hashColumns.put("rqst_day", getRqstDay());
		this.hashColumns.put("imdg_pck_grp_cd", getImdgPckGrpCd());
		this.hashColumns.put("flsh_pnt_cdo_temp", getFlshPntCdoTemp());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("bkg_rcv_term_cd", getBkgRcvTermCd());
		this.hashColumns.put("vsl_seq", getVslSeq());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("rqst_gdt", getRqstGdt());
		this.hashColumns.put("lst_rqst_dat_flg", getLstRqstDatFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("spcl_cgo_apro_rqst_seq", getSpclCgoAproRqstSeq());
		this.hashColumns.put("vsl_pre_pst_cd", getVslPrePstCd());
		this.hashColumns.put("pod_yd_cd", getPodYdCd());
		this.hashColumns.put("imdg_expt_qty_flg", getImdgExptQtyFlg());
		this.hashColumns.put("dg_cntr_seq", getDgCntrSeq());
		this.hashColumns.put("rqst_dt", getRqstDt());
		this.hashColumns.put("rqst_auth_cd", getRqstAuthCd());
		this.hashColumns.put("spcl_cgo_auth_cd", getSpclCgoAuthCd());
		this.hashColumns.put("booking_no", getBookingNo());
		this.hashColumns.put("imdg_subs_rsk_lbl_cd", getImdgSubsRskLblCd());
		this.hashColumns.put("eml_snd_no", getEmlSndNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("crr_code", getCrrCode());
		this.hashColumns.put("auth_gdt", getAuthGdt());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("pol_yd_cd", getPolYdCd());
		this.hashColumns.put("in_imdg_pck_qty1", getInImdgPckQty1());
		this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
		this.hashColumns.put("bkg_de_term_cd", getBkgDeTermCd());
		this.hashColumns.put("imdg_lmt_qty_flg", getImdgLmtQtyFlg());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("spcl_cgo_rqst_seq", "spclCgoRqstSeq");
		this.hashFields.put("dcgo_qty", "dcgoQty");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("no", "no");
		this.hashFields.put("imdg_un_no_seq", "imdgUnNoSeq");
		this.hashFields.put("psa_no", "psaNo");
		this.hashFields.put("scg_flg", "scgFlg");
		this.hashFields.put("net_wgt_sum", "netWgtSum");
		this.hashFields.put("dcgo_seq", "dcgoSeq");
		this.hashFields.put("out_imdg_pck_qty1", "outImdgPckQty1");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("pol_clpt_ind_seq", "polClptIndSeq");
		this.hashFields.put("mrn_polut_flg", "mrnPolutFlg");
		this.hashFields.put("hcdg_flg", "hcdgFlg");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("intmd_imdg_pck_qty1", "intmdImdgPckQty1");
		this.hashFields.put("spcl_cgo_auth_no", "spclCgoAuthNo");
		this.hashFields.put("rgn_shp_opr_cd", "rgnShpOprCd");
		this.hashFields.put("auth_ofc_cd", "authOfcCd");
		this.hashFields.put("dg_tp", "dgTp");
		this.hashFields.put("auth_dt", "authDt");
		this.hashFields.put("net_wgt", "netWgt");
		this.hashFields.put("spcl_cgo_cate_cd", "spclCgoCateCd");
		this.hashFields.put("pod_clpt_ind_seq", "podClptIndSeq");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("spcl_cgo_auth_rjct_cd", "spclCgoAuthRjctCd");
		this.hashFields.put("vsl_pre_pst_nm", "vslPrePstNm");
		this.hashFields.put("cntr_cgo_seq", "cntrCgoSeq");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("imdg_segr_grp_no", "imdgSegrGrpNo");
		this.hashFields.put("spcl_rqst_desc", "spclRqstDesc");
		this.hashFields.put("net_explo_wgt", "netExploWgt");
		this.hashFields.put("spcl_cgo_auth_rmk", "spclCgoAuthRmk");
		this.hashFields.put("spcl_cgo_auth_seq", "spclCgoAuthSeq");
		this.hashFields.put("auth_usr_id", "authUsrId");
		this.hashFields.put("apro_ref_no", "aproRefNo");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("grs_wgt", "grsWgt");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("rqst_usr_id", "rqstUsrId");
		this.hashFields.put("rqst_day", "rqstDay");
		this.hashFields.put("imdg_pck_grp_cd", "imdgPckGrpCd");
		this.hashFields.put("flsh_pnt_cdo_temp", "flshPntCdoTemp");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("bkg_rcv_term_cd", "bkgRcvTermCd");
		this.hashFields.put("vsl_seq", "vslSeq");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("rqst_gdt", "rqstGdt");
		this.hashFields.put("lst_rqst_dat_flg", "lstRqstDatFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("spcl_cgo_apro_rqst_seq", "spclCgoAproRqstSeq");
		this.hashFields.put("vsl_pre_pst_cd", "vslPrePstCd");
		this.hashFields.put("pod_yd_cd", "podYdCd");
		this.hashFields.put("imdg_expt_qty_flg", "imdgExptQtyFlg");
		this.hashFields.put("dg_cntr_seq", "dgCntrSeq");
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("rqst_auth_cd", "rqstAuthCd");
		this.hashFields.put("spcl_cgo_auth_cd", "spclCgoAuthCd");
		this.hashFields.put("booking_no", "bookingNo");
		this.hashFields.put("imdg_subs_rsk_lbl_cd", "imdgSubsRskLblCd");
		this.hashFields.put("eml_snd_no", "emlSndNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("crr_code", "crrCode");
		this.hashFields.put("auth_gdt", "authGdt");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("pol_yd_cd", "polYdCd");
		this.hashFields.put("in_imdg_pck_qty1", "inImdgPckQty1");
		this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
		this.hashFields.put("bkg_de_term_cd", "bkgDeTermCd");
		this.hashFields.put("imdg_lmt_qty_flg", "imdgLmtQtyFlg");
		this.hashFields.put("wgt_ut_cd",        "wgtUtCd");
		return this.hashFields;
	}
	
	
	/**
	 * Column Info
	 * @return wgtUtCd
	 */
	public String  getWgtUtCd() {
		return this.wgtUtCd;	
	}
	
	/**
	 * Column Info
	 * @return spclCgoRqstSeq
	 */
	public String getSpclCgoRqstSeq() {
		return this.spclCgoRqstSeq;
	}
	
	/**
	 * Column Info
	 * @return dcgoQty
	 */
	public String getDcgoQty() {
		return this.dcgoQty;
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
	 * @return no
	 */
	public String getNo() {
		return this.no;
	}
	
	/**
	 * Column Info
	 * @return imdgUnNoSeq
	 */
	public String getImdgUnNoSeq() {
		return this.imdgUnNoSeq;
	}
	
	/**
	 * Column Info
	 * @return psaNo
	 */
	public String getPsaNo() {
		return this.psaNo;
	}
	
	/**
	 * Column Info
	 * @return scgFlg
	 */
	public String getScgFlg() {
		return this.scgFlg;
	}
	
	/**
	 * Column Info
	 * @return netWgtSum
	 */
	public String getNetWgtSum() {
		return this.netWgtSum;
	}
	
	/**
	 * Column Info
	 * @return dcgoSeq
	 */
	public String getDcgoSeq() {
		return this.dcgoSeq;
	}
	
	/**
	 * Column Info
	 * @return outImdgPckQty1
	 */
	public String getOutImdgPckQty1() {
		return this.outImdgPckQty1;
	}
	
	/**
	 * Column Info
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
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
	 * @return mrnPolutFlg
	 */
	public String getMrnPolutFlg() {
		return this.mrnPolutFlg;
	}
	
	/**
	 * Column Info
	 * @return hcdgFlg
	 */
	public String getHcdgFlg() {
		return this.hcdgFlg;
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
	 * @return intmdImdgPckQty1
	 */
	public String getIntmdImdgPckQty1() {
		return this.intmdImdgPckQty1;
	}
	
	/**
	 * Column Info
	 * @return spclCgoAuthNo
	 */
	public String getSpclCgoAuthNo() {
		return this.spclCgoAuthNo;
	}
	
	/**
	 * Column Info
	 * @return rgnShpOprCd
	 */
	public String getRgnShpOprCd() {
		return this.rgnShpOprCd;
	}
	
	/**
	 * Column Info
	 * @return authOfcCd
	 */
	public String getAuthOfcCd() {
		return this.authOfcCd;
	}
	
	/**
	 * Column Info
	 * @return dgTp
	 */
	public String getDgTp() {
		return this.dgTp;
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
	 * @return netWgt
	 */
	public String getNetWgt() {
		return this.netWgt;
	}
	
	/**
	 * Column Info
	 * @return spclCgoCateCd
	 */
	public String getSpclCgoCateCd() {
		return this.spclCgoCateCd;
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
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
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
	 * @return spclCgoAuthRjctCd
	 */
	public String getSpclCgoAuthRjctCd() {
		return this.spclCgoAuthRjctCd;
	}
	
	/**
	 * Column Info
	 * @return vslPrePstNm
	 */
	public String getVslPrePstNm() {
		return this.vslPrePstNm;
	}
	
	/**
	 * Column Info
	 * @return cntrCgoSeq
	 */
	public String getCntrCgoSeq() {
		return this.cntrCgoSeq;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return imdgSegrGrpNo
	 */
	public String getImdgSegrGrpNo() {
		return this.imdgSegrGrpNo;
	}
	
	/**
	 * Column Info
	 * @return spclRqstDesc
	 */
	public String getSpclRqstDesc() {
		return this.spclRqstDesc;
	}
	
	/**
	 * Column Info
	 * @return netExploWgt
	 */
	public String getNetExploWgt() {
		return this.netExploWgt;
	}
	
	/**
	 * Column Info
	 * @return spclCgoAuthRmk
	 */
	public String getSpclCgoAuthRmk() {
		return this.spclCgoAuthRmk;
	}
	
	/**
	 * Column Info
	 * @return spclCgoAuthSeq
	 */
	public String getSpclCgoAuthSeq() {
		return this.spclCgoAuthSeq;
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
	 * @return aproRefNo
	 */
	public String getAproRefNo() {
		return this.aproRefNo;
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
	 * @return grsWgt
	 */
	public String getGrsWgt() {
		return this.grsWgt;
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
	 * @return rqstUsrId
	 */
	public String getRqstUsrId() {
		return this.rqstUsrId;
	}
	
	/**
	 * Column Info
	 * @return rqstDay
	 */
	public String getRqstDay() {
		return this.rqstDay;
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
	 * @return flshPntCdoTemp
	 */
	public String getFlshPntCdoTemp() {
		return this.flshPntCdoTemp;
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
	 * @return bkgRcvTermCd
	 */
	public String getBkgRcvTermCd() {
		return this.bkgRcvTermCd;
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
	 * @return vpsEtaDt
	 */
	public String getVpsEtaDt() {
		return this.vpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @return rqstGdt
	 */
	public String getRqstGdt() {
		return this.rqstGdt;
	}
	
	/**
	 * Column Info
	 * @return lstRqstDatFlg
	 */
	public String getLstRqstDatFlg() {
		return this.lstRqstDatFlg;
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
	 * @return spclCgoAproRqstSeq
	 */
	public String getSpclCgoAproRqstSeq() {
		return this.spclCgoAproRqstSeq;
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
	 * @return imdgExptQtyFlg
	 */
	public String getImdgExptQtyFlg() {
		return this.imdgExptQtyFlg;
	}
	
	/**
	 * Column Info
	 * @return dgCntrSeq
	 */
	public String getDgCntrSeq() {
		return this.dgCntrSeq;
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
	 * @return rqstAuthCd
	 */
	public String getRqstAuthCd() {
		return this.rqstAuthCd;
	}
	
	/**
	 * Column Info
	 * @return spclCgoAuthCd
	 */
	public String getSpclCgoAuthCd() {
		return this.spclCgoAuthCd;
	}
	
	/**
	 * Column Info
	 * @return bookingNo
	 */
	public String getBookingNo() {
		return this.bookingNo;
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
	 * @return emlSndNo
	 */
	public String getEmlSndNo() {
		return this.emlSndNo;
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
	 * @return crrCode
	 */
	public String getCrrCode() {
		return this.crrCode;
	}
	
	/**
	 * Column Info
	 * @return authGdt
	 */
	public String getAuthGdt() {
		return this.authGdt;
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
	 * @return inImdgPckQty1
	 */
	public String getInImdgPckQty1() {
		return this.inImdgPckQty1;
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
	 * @return bkgDeTermCd
	 */
	public String getBkgDeTermCd() {
		return this.bkgDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return imdgLmtQtyFlg
	 */
	public String getImdgLmtQtyFlg() {
		return this.imdgLmtQtyFlg;
	}
	

	/**
	 * Column Info
	 * @return wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		 this.wgtUtCd = wgtUtCd;	
	}
	
	
	/**
	 * Column Info
	 * @param spclCgoRqstSeq
	 */
	public void setSpclCgoRqstSeq(String spclCgoRqstSeq) {
		this.spclCgoRqstSeq = spclCgoRqstSeq;
	}
	
	/**
	 * Column Info
	 * @param dcgoQty
	 */
	public void setDcgoQty(String dcgoQty) {
		this.dcgoQty = dcgoQty;
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
	 * @param no
	 */
	public void setNo(String no) {
		this.no = no;
	}
	
	/**
	 * Column Info
	 * @param imdgUnNoSeq
	 */
	public void setImdgUnNoSeq(String imdgUnNoSeq) {
		this.imdgUnNoSeq = imdgUnNoSeq;
	}
	
	/**
	 * Column Info
	 * @param psaNo
	 */
	public void setPsaNo(String psaNo) {
		this.psaNo = psaNo;
	}
	
	/**
	 * Column Info
	 * @param scgFlg
	 */
	public void setScgFlg(String scgFlg) {
		this.scgFlg = scgFlg;
	}
	
	/**
	 * Column Info
	 * @param netWgtSum
	 */
	public void setNetWgtSum(String netWgtSum) {
		this.netWgtSum = netWgtSum;
	}
	
	/**
	 * Column Info
	 * @param dcgoSeq
	 */
	public void setDcgoSeq(String dcgoSeq) {
		this.dcgoSeq = dcgoSeq;
	}
	
	/**
	 * Column Info
	 * @param outImdgPckQty1
	 */
	public void setOutImdgPckQty1(String outImdgPckQty1) {
		this.outImdgPckQty1 = outImdgPckQty1;
	}
	
	/**
	 * Column Info
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
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
	 * @param mrnPolutFlg
	 */
	public void setMrnPolutFlg(String mrnPolutFlg) {
		this.mrnPolutFlg = mrnPolutFlg;
	}
	
	/**
	 * Column Info
	 * @param hcdgFlg
	 */
	public void setHcdgFlg(String hcdgFlg) {
		this.hcdgFlg = hcdgFlg;
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
	 * @param intmdImdgPckQty1
	 */
	public void setIntmdImdgPckQty1(String intmdImdgPckQty1) {
		this.intmdImdgPckQty1 = intmdImdgPckQty1;
	}
	
	/**
	 * Column Info
	 * @param spclCgoAuthNo
	 */
	public void setSpclCgoAuthNo(String spclCgoAuthNo) {
		this.spclCgoAuthNo = spclCgoAuthNo;
	}
	
	/**
	 * Column Info
	 * @param rgnShpOprCd
	 */
	public void setRgnShpOprCd(String rgnShpOprCd) {
		this.rgnShpOprCd = rgnShpOprCd;
	}
	
	/**
	 * Column Info
	 * @param authOfcCd
	 */
	public void setAuthOfcCd(String authOfcCd) {
		this.authOfcCd = authOfcCd;
	}
	
	/**
	 * Column Info
	 * @param dgTp
	 */
	public void setDgTp(String dgTp) {
		this.dgTp = dgTp;
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
	 * @param netWgt
	 */
	public void setNetWgt(String netWgt) {
		this.netWgt = netWgt;
	}
	
	/**
	 * Column Info
	 * @param spclCgoCateCd
	 */
	public void setSpclCgoCateCd(String spclCgoCateCd) {
		this.spclCgoCateCd = spclCgoCateCd;
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
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
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
	 * @param spclCgoAuthRjctCd
	 */
	public void setSpclCgoAuthRjctCd(String spclCgoAuthRjctCd) {
		this.spclCgoAuthRjctCd = spclCgoAuthRjctCd;
	}
	
	/**
	 * Column Info
	 * @param vslPrePstNm
	 */
	public void setVslPrePstNm(String vslPrePstNm) {
		this.vslPrePstNm = vslPrePstNm;
	}
	
	/**
	 * Column Info
	 * @param cntrCgoSeq
	 */
	public void setCntrCgoSeq(String cntrCgoSeq) {
		this.cntrCgoSeq = cntrCgoSeq;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param imdgSegrGrpNo
	 */
	public void setImdgSegrGrpNo(String imdgSegrGrpNo) {
		this.imdgSegrGrpNo = imdgSegrGrpNo;
	}
	
	/**
	 * Column Info
	 * @param spclRqstDesc
	 */
	public void setSpclRqstDesc(String spclRqstDesc) {
		this.spclRqstDesc = spclRqstDesc;
	}
	
	/**
	 * Column Info
	 * @param netExploWgt
	 */
	public void setNetExploWgt(String netExploWgt) {
		this.netExploWgt = netExploWgt;
	}
	
	/**
	 * Column Info
	 * @param spclCgoAuthRmk
	 */
	public void setSpclCgoAuthRmk(String spclCgoAuthRmk) {
		this.spclCgoAuthRmk = spclCgoAuthRmk;
	}
	
	/**
	 * Column Info
	 * @param spclCgoAuthSeq
	 */
	public void setSpclCgoAuthSeq(String spclCgoAuthSeq) {
		this.spclCgoAuthSeq = spclCgoAuthSeq;
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
	 * @param aproRefNo
	 */
	public void setAproRefNo(String aproRefNo) {
		this.aproRefNo = aproRefNo;
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
	 * @param grsWgt
	 */
	public void setGrsWgt(String grsWgt) {
		this.grsWgt = grsWgt;
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
	 * @param rqstUsrId
	 */
	public void setRqstUsrId(String rqstUsrId) {
		this.rqstUsrId = rqstUsrId;
	}
	
	/**
	 * Column Info
	 * @param rqstDay
	 */
	public void setRqstDay(String rqstDay) {
		this.rqstDay = rqstDay;
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
	 * @param flshPntCdoTemp
	 */
	public void setFlshPntCdoTemp(String flshPntCdoTemp) {
		this.flshPntCdoTemp = flshPntCdoTemp;
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
	 * @param bkgRcvTermCd
	 */
	public void setBkgRcvTermCd(String bkgRcvTermCd) {
		this.bkgRcvTermCd = bkgRcvTermCd;
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
	 * @param vpsEtaDt
	 */
	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @param rqstGdt
	 */
	public void setRqstGdt(String rqstGdt) {
		this.rqstGdt = rqstGdt;
	}
	
	/**
	 * Column Info
	 * @param lstRqstDatFlg
	 */
	public void setLstRqstDatFlg(String lstRqstDatFlg) {
		this.lstRqstDatFlg = lstRqstDatFlg;
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
	 * @param spclCgoAproRqstSeq
	 */
	public void setSpclCgoAproRqstSeq(String spclCgoAproRqstSeq) {
		this.spclCgoAproRqstSeq = spclCgoAproRqstSeq;
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
	 * @param imdgExptQtyFlg
	 */
	public void setImdgExptQtyFlg(String imdgExptQtyFlg) {
		this.imdgExptQtyFlg = imdgExptQtyFlg;
	}
	
	/**
	 * Column Info
	 * @param dgCntrSeq
	 */
	public void setDgCntrSeq(String dgCntrSeq) {
		this.dgCntrSeq = dgCntrSeq;
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
	 * @param rqstAuthCd
	 */
	public void setRqstAuthCd(String rqstAuthCd) {
		this.rqstAuthCd = rqstAuthCd;
	}
	
	/**
	 * Column Info
	 * @param spclCgoAuthCd
	 */
	public void setSpclCgoAuthCd(String spclCgoAuthCd) {
		this.spclCgoAuthCd = spclCgoAuthCd;
	}
	
	/**
	 * Column Info
	 * @param bookingNo
	 */
	public void setBookingNo(String bookingNo) {
		this.bookingNo = bookingNo;
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
	 * @param emlSndNo
	 */
	public void setEmlSndNo(String emlSndNo) {
		this.emlSndNo = emlSndNo;
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
	 * @param crrCode
	 */
	public void setCrrCode(String crrCode) {
		this.crrCode = crrCode;
	}
	
	/**
	 * Column Info
	 * @param authGdt
	 */
	public void setAuthGdt(String authGdt) {
		this.authGdt = authGdt;
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
	 * @param inImdgPckQty1
	 */
	public void setInImdgPckQty1(String inImdgPckQty1) {
		this.inImdgPckQty1 = inImdgPckQty1;
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
	 * @param bkgDeTermCd
	 */
	public void setBkgDeTermCd(String bkgDeTermCd) {
		this.bkgDeTermCd = bkgDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param imdgLmtQtyFlg
	 */
	public void setImdgLmtQtyFlg(String imdgLmtQtyFlg) {
		this.imdgLmtQtyFlg = imdgLmtQtyFlg;
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
		setSpclCgoRqstSeq(JSPUtil.getParameter(request, prefix + "spcl_cgo_rqst_seq", ""));
		setDcgoQty(JSPUtil.getParameter(request, prefix + "dcgo_qty", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setNo(JSPUtil.getParameter(request, prefix + "no", ""));
		setImdgUnNoSeq(JSPUtil.getParameter(request, prefix + "imdg_un_no_seq", ""));
		setPsaNo(JSPUtil.getParameter(request, prefix + "psa_no", ""));
		setScgFlg(JSPUtil.getParameter(request, prefix + "scg_flg", ""));
		setNetWgtSum(JSPUtil.getParameter(request, prefix + "net_wgt_sum", ""));
		setDcgoSeq(JSPUtil.getParameter(request, prefix + "dcgo_seq", ""));
		setOutImdgPckQty1(JSPUtil.getParameter(request, prefix + "out_imdg_pck_qty1", ""));
		setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setPolClptIndSeq(JSPUtil.getParameter(request, prefix + "pol_clpt_ind_seq", ""));
		setMrnPolutFlg(JSPUtil.getParameter(request, prefix + "mrn_polut_flg", ""));
		setHcdgFlg(JSPUtil.getParameter(request, prefix + "hcdg_flg", ""));
		setImdgUnNo(JSPUtil.getParameter(request, prefix + "imdg_un_no", ""));
		setIntmdImdgPckQty1(JSPUtil.getParameter(request, prefix + "intmd_imdg_pck_qty1", ""));
		setSpclCgoAuthNo(JSPUtil.getParameter(request, prefix + "spcl_cgo_auth_no", ""));
		setRgnShpOprCd(JSPUtil.getParameter(request, prefix + "rgn_shp_opr_cd", ""));
		setAuthOfcCd(JSPUtil.getParameter(request, prefix + "auth_ofc_cd", ""));
		setDgTp(JSPUtil.getParameter(request, prefix + "dg_tp", ""));
		setAuthDt(JSPUtil.getParameter(request, prefix + "auth_dt", ""));
		setNetWgt(JSPUtil.getParameter(request, prefix + "net_wgt", ""));
		setSpclCgoCateCd(JSPUtil.getParameter(request, prefix + "spcl_cgo_cate_cd", ""));
		setPodClptIndSeq(JSPUtil.getParameter(request, prefix + "pod_clpt_ind_seq", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setSpclCgoAuthRjctCd(JSPUtil.getParameter(request, prefix + "spcl_cgo_auth_rjct_cd", ""));
		setVslPrePstNm(JSPUtil.getParameter(request, prefix + "vsl_pre_pst_nm", ""));
		setCntrCgoSeq(JSPUtil.getParameter(request, prefix + "cntr_cgo_seq", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setImdgSegrGrpNo(JSPUtil.getParameter(request, prefix + "imdg_segr_grp_no", ""));
		setSpclRqstDesc(JSPUtil.getParameter(request, prefix + "spcl_rqst_desc", ""));
		setNetExploWgt(JSPUtil.getParameter(request, prefix + "net_explo_wgt", ""));
		setSpclCgoAuthRmk(JSPUtil.getParameter(request, prefix + "spcl_cgo_auth_rmk", ""));
		setSpclCgoAuthSeq(JSPUtil.getParameter(request, prefix + "spcl_cgo_auth_seq", ""));
		setAuthUsrId(JSPUtil.getParameter(request, prefix + "auth_usr_id", ""));
		setAproRefNo(JSPUtil.getParameter(request, prefix + "apro_ref_no", ""));
		setImdgClssCd(JSPUtil.getParameter(request, prefix + "imdg_clss_cd", ""));
		setGrsWgt(JSPUtil.getParameter(request, prefix + "grs_wgt", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setRqstUsrId(JSPUtil.getParameter(request, prefix + "rqst_usr_id", ""));
		setRqstDay(JSPUtil.getParameter(request, prefix + "rqst_day", ""));
		setImdgPckGrpCd(JSPUtil.getParameter(request, prefix + "imdg_pck_grp_cd", ""));
		setFlshPntCdoTemp(JSPUtil.getParameter(request, prefix + "flsh_pnt_cdo_temp", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setBkgRcvTermCd(JSPUtil.getParameter(request, prefix + "bkg_rcv_term_cd", ""));
		setVslSeq(JSPUtil.getParameter(request, prefix + "vsl_seq", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, prefix + "vps_eta_dt", ""));
		setRqstGdt(JSPUtil.getParameter(request, prefix + "rqst_gdt", ""));
		setLstRqstDatFlg(JSPUtil.getParameter(request, prefix + "lst_rqst_dat_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSpclCgoAproRqstSeq(JSPUtil.getParameter(request, prefix + "spcl_cgo_apro_rqst_seq", ""));
		setVslPrePstCd(JSPUtil.getParameter(request, prefix + "vsl_pre_pst_cd", ""));
		setPodYdCd(JSPUtil.getParameter(request, prefix + "pod_yd_cd", ""));
		setImdgExptQtyFlg(JSPUtil.getParameter(request, prefix + "imdg_expt_qty_flg", ""));
		setDgCntrSeq(JSPUtil.getParameter(request, prefix + "dg_cntr_seq", ""));
		setRqstDt(JSPUtil.getParameter(request, prefix + "rqst_dt", ""));
		setRqstAuthCd(JSPUtil.getParameter(request, prefix + "rqst_auth_cd", ""));
		setSpclCgoAuthCd(JSPUtil.getParameter(request, prefix + "spcl_cgo_auth_cd", ""));
		setBookingNo(JSPUtil.getParameter(request, prefix + "booking_no", ""));
		setImdgSubsRskLblCd(JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_cd", ""));
		setEmlSndNo(JSPUtil.getParameter(request, prefix + "eml_snd_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setCrrCode(JSPUtil.getParameter(request, prefix + "crr_code", ""));
		setAuthGdt(JSPUtil.getParameter(request, prefix + "auth_gdt", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setPolYdCd(JSPUtil.getParameter(request, prefix + "pol_yd_cd", ""));
		setInImdgPckQty1(JSPUtil.getParameter(request, prefix + "in_imdg_pck_qty1", ""));
		setRqstOfcCd(JSPUtil.getParameter(request, prefix + "rqst_ofc_cd", ""));
		setBkgDeTermCd(JSPUtil.getParameter(request, prefix + "bkg_de_term_cd", ""));
		setImdgLmtQtyFlg(JSPUtil.getParameter(request, prefix + "imdg_lmt_qty_flg", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchOwnDGListVO[]
	 */
	public SearchOwnDGListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchOwnDGListVO[]
	 */
	public SearchOwnDGListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchOwnDGListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] spclCgoRqstSeq = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_rqst_seq", length));
			String[] dcgoQty = (JSPUtil.getParameter(request, prefix	+ "dcgo_qty", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] no = (JSPUtil.getParameter(request, prefix	+ "no", length));
			String[] imdgUnNoSeq = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no_seq", length));
			String[] psaNo = (JSPUtil.getParameter(request, prefix	+ "psa_no", length));
			String[] scgFlg = (JSPUtil.getParameter(request, prefix	+ "scg_flg", length));
			String[] netWgtSum = (JSPUtil.getParameter(request, prefix	+ "net_wgt_sum", length));
			String[] dcgoSeq = (JSPUtil.getParameter(request, prefix	+ "dcgo_seq", length));
			String[] outImdgPckQty1 = (JSPUtil.getParameter(request, prefix	+ "out_imdg_pck_qty1", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] polClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "pol_clpt_ind_seq", length));
			String[] mrnPolutFlg = (JSPUtil.getParameter(request, prefix	+ "mrn_polut_flg", length));
			String[] hcdgFlg = (JSPUtil.getParameter(request, prefix	+ "hcdg_flg", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			String[] intmdImdgPckQty1 = (JSPUtil.getParameter(request, prefix	+ "intmd_imdg_pck_qty1", length));
			String[] spclCgoAuthNo = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_auth_no", length));
			String[] rgnShpOprCd = (JSPUtil.getParameter(request, prefix	+ "rgn_shp_opr_cd", length));
			String[] authOfcCd = (JSPUtil.getParameter(request, prefix	+ "auth_ofc_cd", length));
			String[] dgTp = (JSPUtil.getParameter(request, prefix	+ "dg_tp", length));
			String[] authDt = (JSPUtil.getParameter(request, prefix	+ "auth_dt", length));
			String[] netWgt = (JSPUtil.getParameter(request, prefix	+ "net_wgt", length));
			String[] spclCgoCateCd = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_cate_cd", length));
			String[] podClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "pod_clpt_ind_seq", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] spclCgoAuthRjctCd = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_auth_rjct_cd", length));
			String[] vslPrePstNm = (JSPUtil.getParameter(request, prefix	+ "vsl_pre_pst_nm", length));
			String[] cntrCgoSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_cgo_seq", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] imdgSegrGrpNo = (JSPUtil.getParameter(request, prefix	+ "imdg_segr_grp_no", length));
			String[] spclRqstDesc = (JSPUtil.getParameter(request, prefix	+ "spcl_rqst_desc", length));
			String[] netExploWgt = (JSPUtil.getParameter(request, prefix	+ "net_explo_wgt", length));
			String[] spclCgoAuthRmk = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_auth_rmk", length));
			String[] spclCgoAuthSeq = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_auth_seq", length));
			String[] authUsrId = (JSPUtil.getParameter(request, prefix	+ "auth_usr_id", length));
			String[] aproRefNo = (JSPUtil.getParameter(request, prefix	+ "apro_ref_no", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			String[] grsWgt = (JSPUtil.getParameter(request, prefix	+ "grs_wgt", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] rqstUsrId = (JSPUtil.getParameter(request, prefix	+ "rqst_usr_id", length));
			String[] rqstDay = (JSPUtil.getParameter(request, prefix	+ "rqst_day", length));
			String[] imdgPckGrpCd = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_grp_cd", length));
			String[] flshPntCdoTemp = (JSPUtil.getParameter(request, prefix	+ "flsh_pnt_cdo_temp", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] bkgRcvTermCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rcv_term_cd", length));
			String[] vslSeq = (JSPUtil.getParameter(request, prefix	+ "vsl_seq", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] rqstGdt = (JSPUtil.getParameter(request, prefix	+ "rqst_gdt", length));
			String[] lstRqstDatFlg = (JSPUtil.getParameter(request, prefix	+ "lst_rqst_dat_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] spclCgoAproRqstSeq = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_apro_rqst_seq", length));
			String[] vslPrePstCd = (JSPUtil.getParameter(request, prefix	+ "vsl_pre_pst_cd", length));
			String[] podYdCd = (JSPUtil.getParameter(request, prefix	+ "pod_yd_cd", length));
			String[] imdgExptQtyFlg = (JSPUtil.getParameter(request, prefix	+ "imdg_expt_qty_flg", length));
			String[] dgCntrSeq = (JSPUtil.getParameter(request, prefix	+ "dg_cntr_seq", length));
			String[] rqstDt = (JSPUtil.getParameter(request, prefix	+ "rqst_dt", length));
			String[] rqstAuthCd = (JSPUtil.getParameter(request, prefix	+ "rqst_auth_cd", length));
			String[] spclCgoAuthCd = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_auth_cd", length));
			String[] bookingNo = (JSPUtil.getParameter(request, prefix	+ "booking_no", length));
			String[] imdgSubsRskLblCd = (JSPUtil.getParameter(request, prefix	+ "imdg_subs_rsk_lbl_cd", length));
			String[] emlSndNo = (JSPUtil.getParameter(request, prefix	+ "eml_snd_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] crrCode = (JSPUtil.getParameter(request, prefix	+ "crr_code", length));
			String[] authGdt = (JSPUtil.getParameter(request, prefix	+ "auth_gdt", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] polYdCd = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd", length));
			String[] inImdgPckQty1 = (JSPUtil.getParameter(request, prefix	+ "in_imdg_pck_qty1", length));
			String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_cd", length));
			String[] bkgDeTermCd = (JSPUtil.getParameter(request, prefix	+ "bkg_de_term_cd", length));
			String[] imdgLmtQtyFlg = (JSPUtil.getParameter(request, prefix	+ "imdg_lmt_qty_flg", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchOwnDGListVO();
				if (spclCgoRqstSeq[i] != null)
					model.setSpclCgoRqstSeq(spclCgoRqstSeq[i]);
				if (dcgoQty[i] != null)
					model.setDcgoQty(dcgoQty[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (no[i] != null)
					model.setNo(no[i]);
				if (imdgUnNoSeq[i] != null)
					model.setImdgUnNoSeq(imdgUnNoSeq[i]);
				if (psaNo[i] != null)
					model.setPsaNo(psaNo[i]);
				if (scgFlg[i] != null)
					model.setScgFlg(scgFlg[i]);
				if (netWgtSum[i] != null)
					model.setNetWgtSum(netWgtSum[i]);
				if (dcgoSeq[i] != null)
					model.setDcgoSeq(dcgoSeq[i]);
				if (outImdgPckQty1[i] != null)
					model.setOutImdgPckQty1(outImdgPckQty1[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (polClptIndSeq[i] != null)
					model.setPolClptIndSeq(polClptIndSeq[i]);
				if (mrnPolutFlg[i] != null)
					model.setMrnPolutFlg(mrnPolutFlg[i]);
				if (hcdgFlg[i] != null)
					model.setHcdgFlg(hcdgFlg[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (intmdImdgPckQty1[i] != null)
					model.setIntmdImdgPckQty1(intmdImdgPckQty1[i]);
				if (spclCgoAuthNo[i] != null)
					model.setSpclCgoAuthNo(spclCgoAuthNo[i]);
				if (rgnShpOprCd[i] != null)
					model.setRgnShpOprCd(rgnShpOprCd[i]);
				if (authOfcCd[i] != null)
					model.setAuthOfcCd(authOfcCd[i]);
				if (dgTp[i] != null)
					model.setDgTp(dgTp[i]);
				if (authDt[i] != null)
					model.setAuthDt(authDt[i]);
				if (netWgt[i] != null)
					model.setNetWgt(netWgt[i]);
				if (spclCgoCateCd[i] != null)
					model.setSpclCgoCateCd(spclCgoCateCd[i]);
				if (podClptIndSeq[i] != null)
					model.setPodClptIndSeq(podClptIndSeq[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (spclCgoAuthRjctCd[i] != null)
					model.setSpclCgoAuthRjctCd(spclCgoAuthRjctCd[i]);
				if (vslPrePstNm[i] != null)
					model.setVslPrePstNm(vslPrePstNm[i]);
				if (cntrCgoSeq[i] != null)
					model.setCntrCgoSeq(cntrCgoSeq[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (imdgSegrGrpNo[i] != null)
					model.setImdgSegrGrpNo(imdgSegrGrpNo[i]);
				if (spclRqstDesc[i] != null)
					model.setSpclRqstDesc(spclRqstDesc[i]);
				if (netExploWgt[i] != null)
					model.setNetExploWgt(netExploWgt[i]);
				if (spclCgoAuthRmk[i] != null)
					model.setSpclCgoAuthRmk(spclCgoAuthRmk[i]);
				if (spclCgoAuthSeq[i] != null)
					model.setSpclCgoAuthSeq(spclCgoAuthSeq[i]);
				if (authUsrId[i] != null)
					model.setAuthUsrId(authUsrId[i]);
				if (aproRefNo[i] != null)
					model.setAproRefNo(aproRefNo[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				if (grsWgt[i] != null)
					model.setGrsWgt(grsWgt[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (rqstUsrId[i] != null)
					model.setRqstUsrId(rqstUsrId[i]);
				if (rqstDay[i] != null)
					model.setRqstDay(rqstDay[i]);
				if (imdgPckGrpCd[i] != null)
					model.setImdgPckGrpCd(imdgPckGrpCd[i]);
				if (flshPntCdoTemp[i] != null)
					model.setFlshPntCdoTemp(flshPntCdoTemp[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (bkgRcvTermCd[i] != null)
					model.setBkgRcvTermCd(bkgRcvTermCd[i]);
				if (vslSeq[i] != null)
					model.setVslSeq(vslSeq[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (rqstGdt[i] != null)
					model.setRqstGdt(rqstGdt[i]);
				if (lstRqstDatFlg[i] != null)
					model.setLstRqstDatFlg(lstRqstDatFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (spclCgoAproRqstSeq[i] != null)
					model.setSpclCgoAproRqstSeq(spclCgoAproRqstSeq[i]);
				if (vslPrePstCd[i] != null)
					model.setVslPrePstCd(vslPrePstCd[i]);
				if (podYdCd[i] != null)
					model.setPodYdCd(podYdCd[i]);
				if (imdgExptQtyFlg[i] != null)
					model.setImdgExptQtyFlg(imdgExptQtyFlg[i]);
				if (dgCntrSeq[i] != null)
					model.setDgCntrSeq(dgCntrSeq[i]);
				if (rqstDt[i] != null)
					model.setRqstDt(rqstDt[i]);
				if (rqstAuthCd[i] != null)
					model.setRqstAuthCd(rqstAuthCd[i]);
				if (spclCgoAuthCd[i] != null)
					model.setSpclCgoAuthCd(spclCgoAuthCd[i]);
				if (bookingNo[i] != null)
					model.setBookingNo(bookingNo[i]);
				if (imdgSubsRskLblCd[i] != null)
					model.setImdgSubsRskLblCd(imdgSubsRskLblCd[i]);
				if (emlSndNo[i] != null)
					model.setEmlSndNo(emlSndNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (crrCode[i] != null)
					model.setCrrCode(crrCode[i]);
				if (authGdt[i] != null)
					model.setAuthGdt(authGdt[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (polYdCd[i] != null)
					model.setPolYdCd(polYdCd[i]);
				if (inImdgPckQty1[i] != null)
					model.setInImdgPckQty1(inImdgPckQty1[i]);
				if (rqstOfcCd[i] != null)
					model.setRqstOfcCd(rqstOfcCd[i]);
				if (bkgDeTermCd[i] != null)
					model.setBkgDeTermCd(bkgDeTermCd[i]);
				if (imdgLmtQtyFlg[i] != null)
					model.setImdgLmtQtyFlg(imdgLmtQtyFlg[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchOwnDGListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchOwnDGListVO[]
	 */
	public SearchOwnDGListVO[] getSearchOwnDGListVOs(){
		SearchOwnDGListVO[] vos = (SearchOwnDGListVO[])models.toArray(new SearchOwnDGListVO[models.size()]);
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
		this.spclCgoRqstSeq = this.spclCgoRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoQty = this.dcgoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.no = this.no .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNoSeq = this.imdgUnNoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psaNo = this.psaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgFlg = this.scgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netWgtSum = this.netWgtSum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoSeq = this.dcgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outImdgPckQty1 = this.outImdgPckQty1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polClptIndSeq = this.polClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnPolutFlg = this.mrnPolutFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcdgFlg = this.hcdgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intmdImdgPckQty1 = this.intmdImdgPckQty1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoAuthNo = this.spclCgoAuthNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnShpOprCd = this.rgnShpOprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authOfcCd = this.authOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgTp = this.dgTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authDt = this.authDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netWgt = this.netWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoCateCd = this.spclCgoCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podClptIndSeq = this.podClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoAuthRjctCd = this.spclCgoAuthRjctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslPrePstNm = this.vslPrePstNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCgoSeq = this.cntrCgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSegrGrpNo = this.imdgSegrGrpNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclRqstDesc = this.spclRqstDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netExploWgt = this.netExploWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoAuthRmk = this.spclCgoAuthRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoAuthSeq = this.spclCgoAuthSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authUsrId = this.authUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproRefNo = this.aproRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgt = this.grsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUsrId = this.rqstUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDay = this.rqstDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckGrpCd = this.imdgPckGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flshPntCdoTemp = this.flshPntCdoTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRcvTermCd = this.bkgRcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSeq = this.vslSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstGdt = this.rqstGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstRqstDatFlg = this.lstRqstDatFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoAproRqstSeq = this.spclCgoAproRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslPrePstCd = this.vslPrePstCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd = this.podYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgExptQtyFlg = this.imdgExptQtyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgCntrSeq = this.dgCntrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDt = this.rqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstAuthCd = this.rqstAuthCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoAuthCd = this.spclCgoAuthCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bookingNo = this.bookingNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSubsRskLblCd = this.imdgSubsRskLblCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndNo = this.emlSndNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCode = this.crrCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authGdt = this.authGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd = this.polYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inImdgPckQty1 = this.inImdgPckQty1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcCd = this.rqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDeTermCd = this.bkgDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgLmtQtyFlg = this.imdgLmtQtyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
