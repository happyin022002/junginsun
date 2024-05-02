/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : SearchPrnrDGListVO.java
 *@FileTitle : SearchPrnrDGListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.06.10
 *@LastModifier : Yona.Ha.
 *@LastVersion : 1.0
 * 2015.06.10 Yona.Ha. 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo;

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
 * Table Value Object<br>
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author Yona.Ha. 
 * @since J2EE 1.6
 * @see	..
 */
public class SearchPrnrDGListVO	extends	 AbstractValueObject {

	private	 static final long serialVersionUID = 1L;

	private	 Collection<SearchPrnrDGListVO>  models =	new	ArrayList<SearchPrnrDGListVO>();
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;
	/*	Column Info	*/
	private String no = null;
	/*	Column Info	*/
	private String rankSeq = null;
	/*	Column Info	*/
	private String bookingNo = null;
	/*	Column Info	*/
	private String bkgStsCd = null;
	/*	Column Info	*/
	private String dgCntrSeq = null;
	/*	Column Info	*/
	private String cntrCgoSeq = null;
	/*	Column Info	*/
	private String rqstDay = null;
	/*	Column Info	*/
	private String spclCgoAuthCd = null;
	/*	Column Info	*/
	private String spclCgoAuthRjctCd = null;
	/*	Column Info	*/
	private String aproRefNo = null;
	/*	Column Info	*/
	private String ediSndNo = null;
	/*	Column Info	*/
	private String emlSndNo = null;
	/*	Column Info	*/
	private String slanCd = null;
	/*	Column Info	*/
	private String vslCd = null;
	/*	Column Info	*/
	private String vslNm = null;
	/*	Column Info	*/
	private String skdVoyNo = null;
	/*	Column Info	*/
	private String skdDirCd = null;
	/*	Column Info	*/
	private String prpShpNm = null;
	/*	Column Info	*/
	private String diffRmk = null;
	/*	Column Info	*/
	private String dcgoStsCd = null;
	/*	Column Info	*/
	private String crrCd = null;
	/*	Column Info	*/
	private String crrCode = null;
	/*	Column Info	*/
	private String porCd = null;
	/*	Column Info	*/
	private String polCd = null;
	/*	Column Info	*/
	private String emlChk = null;
	/*	Column Info	*/
	private String emlAddr = null;
	/*	Column Info	*/
	private String ediChk = null;
	/*	Column Info	*/
	private String mapgTrsmBndCd = null;
	/*	Column Info	*/
	private String mapgTrsmDt = null;
	/*	Column Info	*/
	private String mapgTrsmSpclCgoCateCd = null;
	/*	Column Info	*/
	private String mapgPrnrSpclCgoSeq = null;
	/*	Column Info	*/
	private String mapgEdiTrsmStsCd = null;
	/*	Column Info	*/
	private String vpsEtaDt = null;
	/*	Column Info	*/
	private String podCd = null;
	/*	Column Info	*/
	private String delCd = null;
	/*	Column Info	*/
	private String cntrTpszCd = null;
	/*	Column Info	*/
	private String dgTp = null;
	/*	Column Info	*/
	private String imdgUnNo = null;
	/*	Column Info	*/
	private String imdgSegrGrpNm = null;
	/*	Column Info	*/
	private String imdgUnNoSeq = null;
	/*	Column Info	*/
	private String imdgClssCd = null;
	/*	Column Info	*/
	private String imdgSubsRskLblCd = null;
	/*	Column Info	*/
	private String mrnPolutFlg = null;
	/*	Column Info	*/
	private String imdgPckGrpCd = null;
	/*	Column Info	*/
	private String imdgLmtQtyFlg = null;
	/*	Column Info	*/
	private String imdgExptQtyFlg = null;
	/*	Column Info	*/
	private String flshPntCdoTemp = null;
	/*	Column Info	*/
	private String grsWgt = null;
	/*	Column Info	*/
	private String netWgt = null;
	/*	Column Info	*/
	private String psaNo = null;
	/*	Column Info	*/
	private String hcdgFlg = null;
	/*	Column Info	*/
	private String bkgNo = null;
	/*	Column Info	*/
	private String spclCgoAproRqstSeq = null;
	/*	Column Info	*/
	private String spclCgoRqstSeq = null;
	/*	Column Info	*/
	private String cntrNo = null;
	/*	Column Info	*/
	private String dcgoRefNo = null;
	/*	Column Info	*/
	private String dcgoSeq = null;	
	/*	Column Info	*/
	private String dcgoQty = null;
	/*	Column Info	*/
	private String lstRqstDatFlg = null;
	/*	Column Info	*/
	private String bkgRcvTermCd = null;
	/*	Column Info	*/
	private String bkgDeTermCd = null;
	/*	Column Info	*/
	private String polClptIndSeq = null;
	/*	Column Info	*/
	private String podClptIndSeq = null;
	/*	Column Info	*/
	private String polYdCd = null;
	/*	Column Info	*/
	private String podYdCd = null;
	/*	Column Info	*/
	private String rgnShpOprCd = null;
	/*	Column Info	*/
	private String spclCgoCateCd = null;
	/*	Column Info	*/
	private String spclCgoAuthNo = null;
	/*	Column Info	*/
	private String authOfcCd = null;
	/*	Column Info	*/
	private String spclCgoAuthSeq = null;
	/*	Column Info	*/
	private String netWgtSum = null;
	/*	Column Info	*/
	private String scgFlg = null;
	/*	Column Info	*/
	private String rqstAuthCd = null;
	/*	Column Info	*/
	private String rqstOfcCd = null;
	/*	Column Info	*/
	private String rqstDt = null;
	/*	Column Info	*/
	private String rqstGdt = null;
	/*	Column Info	*/
	private String rqstUsrId = null;
	/*	Column Info	*/
	private String authDt = null;
	/*	Column Info	*/
	private String authGdt = null;
	/*	Column Info	*/
	private String authUsrId = null;
	/*	Column Info	*/
	private String spclCgoAuthRmk = null;
	/*	Column Info	*/
	private String spclRqstDesc = null;
	/*	Column Info	*/
	private String inImdgPckQty1 = null;
	/*	Column Info	*/
	private String outImdgPckQty1 = null;
	/*	Column Info	*/
	private String intmdImdgPckQty1 = null;
	/*	Column Info	*/
	private String imdgSegrGrpNo = null;
	/*	Column Info	*/
	private String rsdFlg = null;
	/*	Column Info	*/
	private String dcgoCxlRqstSeq = null;
	/*	Column Info	*/
	private String cxlCgoKndCd = null;
	/*	Column Info	*/
	private String cxlCgoRqstDt = null;
	/*	Column Info	*/
	private String cxlCgoRsn = null;
	/*	Column Info	*/
	private String ediStatus = null;
	/*	Column Info	*/
	private String fltFileRefNo = null;
	/*	Column Info	*/
	private String cfrFlg = null;
	/*	Column Info	*/
	private String preSeq = null;
	/*	Column Info	*/
	private String ediMsgStsCd = null;
	/*	Column Info	*/
	private String ediDelStsCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();


	/**	Constructor	*/
	public SearchPrnrDGListVO(){}

	public SearchPrnrDGListVO(String ibflag,String pagerows,String no,String rankSeq,String bookingNo,String bkgStsCd,String dgCntrSeq,String cntrCgoSeq,String rqstDay,String spclCgoAuthCd,String spclCgoAuthRjctCd,String vslPrePstNm,String aproRefNo,String ediSndNo,String emlSndNo,String slanCd,String vslCd,String vslNm,String skdVoyNo,String skdDirCd,String prpShpNm,String diffRmk,String dcgoStsCd,String crrCd,String crrCode,String porCd,String polCd,String emlChk,String emlAddr,String ediChk,String mapgTrsmBndCd,String mapgTrsmDt,String mapgTrsmSpclCgoCateCd,String mapgPrnrSpclCgoSeq,String mapgEdiTrsmStsCd,String vpsEtaDt,String podCd,String delCd,String cntrTpszCd,String dgTp,String imdgUnNo,String imdgSegrGrpNm,String imdgUnNoSeq,String imdgClssCd,String imdgSubsRskLblCd,String mrnPolutFlg,String imdgPckGrpCd,String imdgLmtQtyFlg,String imdgExptQtyFlg,String flshPntCdoTemp,String grsWgt,String netWgt,String psaNo,String hcdgFlg,String bkgNo,String spclCgoAproRqstSeq,String spclCgoRqstSeq,String cntrNo,String dcgoRefNo,String dcgoSeq,String dcgoQty,String lstRqstDatFlg,String bkgRcvTermCd,String bkgDeTermCd,String polClptIndSeq,String podClptIndSeq,String polYdCd,String podYdCd,String rgnShpOprCd,String spclCgoCateCd,String spclCgoAuthNo,String authOfcCd,String spclCgoAuthSeq,String netWgtSum,String scgFlg,String rqstAuthCd,String rqstOfcCd,String rqstDt,String rqstGdt,String rqstUsrId,String authDt,String authGdt,String authUsrId,String spclCgoAuthRmk,String spclRqstDesc,String inImdgPckQty1,String outImdgPckQty1,String intmdImdgPckQty1,String imdgSegrGrpNo,String rsdFlg,String dcgoCxlRqstSeq,String cxlCgoKndCd,String cxlCgoRqstDt,String cxlCgoRsn,String ediStatus,String fltFileRefNo,String cfrFlg,String preSeq,String ediMsgStsCd,String ediDelStsCd)	{
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.no = no;
		this.rankSeq = rankSeq;
		this.bookingNo = bookingNo;
		this.bkgStsCd = bkgStsCd;
		this.dgCntrSeq = dgCntrSeq;
		this.cntrCgoSeq = cntrCgoSeq;
		this.rqstDay = rqstDay;
		this.spclCgoAuthCd = spclCgoAuthCd;
		this.spclCgoAuthRjctCd = spclCgoAuthRjctCd;
		this.aproRefNo = aproRefNo;
		this.ediSndNo = ediSndNo;
		this.emlSndNo = emlSndNo;
		this.slanCd = slanCd;
		this.vslCd = vslCd;
		this.vslNm = vslNm;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd = skdDirCd;
		this.prpShpNm = prpShpNm;
		this.diffRmk = diffRmk;
		this.dcgoStsCd = dcgoStsCd;
		this.crrCd = crrCd;
		this.crrCode = crrCode;
		this.porCd = porCd;
		this.polCd = polCd;
		this.emlChk = emlChk;
		this.emlAddr = emlAddr;
		this.ediChk = ediChk;
		this.mapgTrsmBndCd = mapgTrsmBndCd;
		this.mapgTrsmDt = mapgTrsmDt;
		this.mapgTrsmSpclCgoCateCd = mapgTrsmSpclCgoCateCd;
		this.mapgPrnrSpclCgoSeq = mapgPrnrSpclCgoSeq;
		this.mapgEdiTrsmStsCd = mapgEdiTrsmStsCd;
		this.vpsEtaDt = vpsEtaDt;
		this.podCd = podCd;
		this.delCd = delCd;
		this.cntrTpszCd = cntrTpszCd;
		this.dgTp = dgTp;
		this.imdgUnNo = imdgUnNo;
		this.imdgSegrGrpNm = imdgSegrGrpNm;
		this.imdgUnNoSeq = imdgUnNoSeq;
		this.imdgClssCd = imdgClssCd;
		this.imdgSubsRskLblCd = imdgSubsRskLblCd;
		this.mrnPolutFlg = mrnPolutFlg;
		this.imdgPckGrpCd = imdgPckGrpCd;
		this.imdgLmtQtyFlg = imdgLmtQtyFlg;
		this.imdgExptQtyFlg = imdgExptQtyFlg;
		this.flshPntCdoTemp = flshPntCdoTemp;
		this.grsWgt = grsWgt;
		this.netWgt = netWgt;
		this.psaNo = psaNo;
		this.hcdgFlg = hcdgFlg;
		this.bkgNo = bkgNo;
		this.spclCgoAproRqstSeq = spclCgoAproRqstSeq;
		this.spclCgoRqstSeq = spclCgoRqstSeq;
		this.cntrNo = cntrNo;
		this.dcgoRefNo = dcgoRefNo;
		this.dcgoSeq = dcgoSeq;
		this.dcgoQty = dcgoQty;
		this.lstRqstDatFlg = lstRqstDatFlg;
		this.bkgRcvTermCd = bkgRcvTermCd;
		this.bkgDeTermCd = bkgDeTermCd;
		this.polClptIndSeq = polClptIndSeq;
		this.podClptIndSeq = podClptIndSeq;
		this.polYdCd = polYdCd;
		this.podYdCd = podYdCd;
		this.rgnShpOprCd = rgnShpOprCd;
		this.spclCgoCateCd = spclCgoCateCd;
		this.spclCgoAuthNo = spclCgoAuthNo;
		this.authOfcCd = authOfcCd;
		this.spclCgoAuthSeq = spclCgoAuthSeq;
		this.netWgtSum = netWgtSum;
		this.scgFlg = scgFlg;
		this.rqstAuthCd = rqstAuthCd;
		this.rqstOfcCd = rqstOfcCd;
		this.rqstDt = rqstDt;
		this.rqstGdt = rqstGdt;
		this.rqstUsrId = rqstUsrId;
		this.authDt = authDt;
		this.authGdt = authGdt;
		this.authUsrId = authUsrId;
		this.spclCgoAuthRmk = spclCgoAuthRmk;
		this.spclRqstDesc = spclRqstDesc;
		this.inImdgPckQty1 = inImdgPckQty1;
		this.outImdgPckQty1 = outImdgPckQty1;
		this.intmdImdgPckQty1 = intmdImdgPckQty1;
		this.imdgSegrGrpNo = imdgSegrGrpNo;
		this.rsdFlg = rsdFlg;
		this.dcgoCxlRqstSeq = dcgoCxlRqstSeq;
		this.cxlCgoKndCd = cxlCgoKndCd;
		this.cxlCgoRqstDt = cxlCgoRqstDt;
		this.cxlCgoRsn = cxlCgoRsn;
		this.ediStatus = ediStatus;
		this.fltFileRefNo = fltFileRefNo;
		this.cfrFlg = cfrFlg;
		this.preSeq = preSeq;
		this.ediMsgStsCd = ediMsgStsCd;
		this.ediDelStsCd = ediDelStsCd;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("no", getNo());
		this.hashColumns.put("rank_seq", getRankSeq());
		this.hashColumns.put("booking_no", getBookingNo());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("dg_cntr_seq", getDgCntrSeq());
		this.hashColumns.put("cntr_cgo_seq", getCntrCgoSeq());
		this.hashColumns.put("rqst_day", getRqstDay());
		this.hashColumns.put("spcl_cgo_auth_cd", getSpclCgoAuthCd());
		this.hashColumns.put("spcl_cgo_auth_rjct_cd", getSpclCgoAuthRjctCd());
		this.hashColumns.put("apro_ref_no", getAproRefNo());
		this.hashColumns.put("edi_snd_no", getEdiSndNo());
		this.hashColumns.put("eml_snd_no", getEmlSndNo());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("prp_shp_nm", getPrpShpNm());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("dcgo_sts_cd", getDcgoStsCd());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("crr_code", getCrrCode());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("eml_chk", getEmlChk());
		this.hashColumns.put("eml_addr", getEmlAddr());
		this.hashColumns.put("edi_chk", getEdiChk());
		this.hashColumns.put("mapg_trsm_bnd_cd", getMapgTrsmBndCd());
		this.hashColumns.put("mapg_trsm_dt", getMapgTrsmDt());
		this.hashColumns.put("mapg_trsm_spcl_cgo_cate_cd", getMapgTrsmSpclCgoCateCd());
		this.hashColumns.put("mapg_prnr_spcl_cgo_seq", getMapgPrnrSpclCgoSeq());
		this.hashColumns.put("mapg_edi_trsm_sts_cd", getMapgEdiTrsmStsCd());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("dg_tp", getDgTp());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("imdg_segr_grp_nm", getImdgSegrGrpNm());
		this.hashColumns.put("imdg_un_no_seq", getImdgUnNoSeq());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		this.hashColumns.put("imdg_subs_rsk_lbl_cd", getImdgSubsRskLblCd());
		this.hashColumns.put("mrn_polut_flg", getMrnPolutFlg());
		this.hashColumns.put("imdg_pck_grp_cd", getImdgPckGrpCd());
		this.hashColumns.put("imdg_lmt_qty_flg", getImdgLmtQtyFlg());
		this.hashColumns.put("imdg_expt_qty_flg", getImdgExptQtyFlg());
		this.hashColumns.put("flsh_pnt_cdo_temp", getFlshPntCdoTemp());
		this.hashColumns.put("grs_wgt", getGrsWgt());
		this.hashColumns.put("net_wgt", getNetWgt());
		this.hashColumns.put("psa_no", getPsaNo());
		this.hashColumns.put("hcdg_flg", getHcdgFlg());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("spcl_cgo_apro_rqst_seq", getSpclCgoAproRqstSeq());
		this.hashColumns.put("spcl_cgo_rqst_seq", getSpclCgoRqstSeq());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("dcgo_ref_no", getDcgoRefNo());
		this.hashColumns.put("dcgo_seq", getDcgoSeq());
		this.hashColumns.put("dcgo_qty", getDcgoQty());
		this.hashColumns.put("lst_rqst_dat_flg", getLstRqstDatFlg());
		this.hashColumns.put("bkg_rcv_term_cd", getBkgRcvTermCd());
		this.hashColumns.put("bkg_de_term_cd", getBkgDeTermCd());
		this.hashColumns.put("pol_clpt_ind_seq", getPolClptIndSeq());
		this.hashColumns.put("pod_clpt_ind_seq", getPodClptIndSeq());
		this.hashColumns.put("pol_yd_cd", getPolYdCd());
		this.hashColumns.put("pod_yd_cd", getPodYdCd());
		this.hashColumns.put("rgn_shp_opr_cd", getRgnShpOprCd());
		this.hashColumns.put("spcl_cgo_cate_cd", getSpclCgoCateCd());
		this.hashColumns.put("spcl_cgo_auth_no", getSpclCgoAuthNo());
		this.hashColumns.put("auth_ofc_cd", getAuthOfcCd());
		this.hashColumns.put("spcl_cgo_auth_seq", getSpclCgoAuthSeq());
		this.hashColumns.put("net_wgt_sum", getNetWgtSum());
		this.hashColumns.put("scg_flg", getScgFlg());
		this.hashColumns.put("rqst_auth_cd", getRqstAuthCd());
		this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
		this.hashColumns.put("rqst_dt", getRqstDt());
		this.hashColumns.put("rqst_gdt", getRqstGdt());
		this.hashColumns.put("rqst_usr_id", getRqstUsrId());
		this.hashColumns.put("auth_dt", getAuthDt());
		this.hashColumns.put("auth_gdt", getAuthGdt());
		this.hashColumns.put("auth_usr_id", getAuthUsrId());
		this.hashColumns.put("spcl_cgo_auth_rmk", getSpclCgoAuthRmk());
		this.hashColumns.put("spcl_rqst_desc", getSpclRqstDesc());
		this.hashColumns.put("in_imdg_pck_qty1", getInImdgPckQty1());
		this.hashColumns.put("out_imdg_pck_qty1", getOutImdgPckQty1());
		this.hashColumns.put("intmd_imdg_pck_qty1", getIntmdImdgPckQty1());
		this.hashColumns.put("imdg_segr_grp_no", getImdgSegrGrpNo());
		this.hashColumns.put("rsd_flg", getRsdFlg());
		this.hashColumns.put("dcgo_cxl_rqst_seq", getDcgoCxlRqstSeq());
		this.hashColumns.put("cxl_cgo_knd_cd", getCxlCgoKndCd());
		this.hashColumns.put("cxl_cgo_rqst_dt", getCxlCgoRqstDt());
		this.hashColumns.put("cxl_cgo_rsn", getCxlCgoRsn());
		this.hashColumns.put("edi_status", getEdiStatus());
		this.hashColumns.put("flt_file_ref_no", getFltFileRefNo());
		this.hashColumns.put("cfr_flg", getCfrFlg());
		this.hashColumns.put("pre_seq", getPreSeq());
		this.hashColumns.put("edi_msg_sts_cd", getEdiMsgStsCd());
		this.hashColumns.put("edi_del_sts_cd", getEdiDelStsCd());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("no", "no");
		this.hashFields.put("rank_seq", "rankSeq");
		this.hashFields.put("booking_no", "bookingNo");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("dg_cntr_seq", "dgCntrSeq");
		this.hashFields.put("cntr_cgo_seq", "cntrCgoSeq");
		this.hashFields.put("rqst_day", "rqstDay");
		this.hashFields.put("spcl_cgo_auth_cd", "spclCgoAuthCd");
		this.hashFields.put("spcl_cgo_auth_rjct_cd", "spclCgoAuthRjctCd");
		this.hashFields.put("vsl_pre_pst_nm", "vslPrePstNm");
		this.hashFields.put("apro_ref_no", "aproRefNo");
		this.hashFields.put("edi_snd_no", "ediSndNo");
		this.hashFields.put("eml_snd_no", "emlSndNo");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("prp_shp_nm", "prpShpNm");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("dcgo_sts_cd", "dcgoStsCd");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("crr_code", "crrCode");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("eml_chk", "emlChk");
		this.hashFields.put("eml_addr", "emlAddr");
		this.hashFields.put("edi_chk", "ediChk");
		this.hashFields.put("mapg_trsm_bnd_cd", "mapgTrsmBndCd");
		this.hashFields.put("mapg_trsm_dt", "mapgTrsmDt");
		this.hashFields.put("mapg_trsm_spcl_cgo_cate_cd", "mapgTrsmSpclCgoCateCd");
		this.hashFields.put("mapg_prnr_spcl_cgo_seq", "mapgPrnrSpclCgoSeq");
		this.hashFields.put("mapg_edi_trsm_sts_cd", "mapgEdiTrsmStsCd");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("dg_tp", "dgTp");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("imdg_segr_grp_nm", "imdgSegrGrpNm");
		this.hashFields.put("imdg_un_no_seq", "imdgUnNoSeq");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("imdg_subs_rsk_lbl_cd", "imdgSubsRskLblCd");
		this.hashFields.put("mrn_polut_flg", "mrnPolutFlg");
		this.hashFields.put("imdg_pck_grp_cd", "imdgPckGrpCd");
		this.hashFields.put("imdg_lmt_qty_flg", "imdgLmtQtyFlg");
		this.hashFields.put("imdg_expt_qty_flg", "imdgExptQtyFlg");
		this.hashFields.put("flsh_pnt_cdo_temp", "flshPntCdoTemp");
		this.hashFields.put("grs_wgt", "grsWgt");
		this.hashFields.put("net_wgt", "netWgt");
		this.hashFields.put("psa_no", "psaNo");
		this.hashFields.put("hcdg_flg", "hcdgFlg");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("spcl_cgo_apro_rqst_seq", "spclCgoAproRqstSeq");
		this.hashFields.put("spcl_cgo_rqst_seq", "spclCgoRqstSeq");
		this.hashFields.put("vsl_seq", "vslSeq");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("dcgo_ref_no", "dcgoRefNo");
		this.hashFields.put("dcgo_seq", "dcgoSeq");
		this.hashFields.put("dcgo_qty", "dcgoQty");
		this.hashFields.put("lst_rqst_dat_flg", "lstRqstDatFlg");
		this.hashFields.put("bkg_rcv_term_cd", "bkgRcvTermCd");
		this.hashFields.put("bkg_de_term_cd", "bkgDeTermCd");
		this.hashFields.put("pol_clpt_ind_seq", "polClptIndSeq");
		this.hashFields.put("pod_clpt_ind_seq", "podClptIndSeq");
		this.hashFields.put("pol_yd_cd", "polYdCd");
		this.hashFields.put("pod_yd_cd", "podYdCd");
		this.hashFields.put("rgn_shp_opr_cd", "rgnShpOprCd");
		this.hashFields.put("spcl_cgo_cate_cd", "spclCgoCateCd");
		this.hashFields.put("spcl_cgo_auth_no", "spclCgoAuthNo");
		this.hashFields.put("auth_ofc_cd", "authOfcCd");
		this.hashFields.put("spcl_cgo_auth_seq", "spclCgoAuthSeq");
		this.hashFields.put("net_wgt_sum", "netWgtSum");
		this.hashFields.put("scg_flg", "scgFlg");
		this.hashFields.put("rqst_auth_cd", "rqstAuthCd");
		this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("rqst_gdt", "rqstGdt");
		this.hashFields.put("rqst_usr_id", "rqstUsrId");
		this.hashFields.put("auth_dt", "authDt");
		this.hashFields.put("auth_gdt", "authGdt");
		this.hashFields.put("auth_usr_id", "authUsrId");
		this.hashFields.put("spcl_cgo_auth_rmk", "spclCgoAuthRmk");
		this.hashFields.put("spcl_rqst_desc", "spclRqstDesc");
		this.hashFields.put("in_imdg_pck_qty1", "inImdgPckQty1");
		this.hashFields.put("out_imdg_pck_qty1", "outImdgPckQty1");
		this.hashFields.put("intmd_imdg_pck_qty1", "intmdImdgPckQty1");
		this.hashFields.put("imdg_segr_grp_no", "imdgSegrGrpNo");
		this.hashFields.put("rsd_flg", "rsdFlg");
		this.hashFields.put("dcgo_cxl_rqst_seq", "dcgoCxlRqstSeq");
		this.hashFields.put("cxl_cgo_knd_cd", "cxlCgoKndCd");
		this.hashFields.put("cxl_cgo_rqst_dt", "cxlCgoRqstDt");
		this.hashFields.put("cxl_cgo_rsn", "cxlCgoRsn");
		this.hashFields.put("edi_status", "ediStatus");
		this.hashFields.put("flt_file_ref_no", "fltFileRefNo");
		this.hashFields.put("cfr_flg", "cfrFlg");
		this.hashFields.put("pre_seq", "preSeq");
		this.hashFields.put("edi_msg_sts_cd", "ediMsgStsCd");
		this.hashFields.put("edi_del_sts_cd", "ediDelStsCd");
		return this.hashFields;
	}

	//	Getters	and	Setters

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public	String getIbflag() {
		return	this.ibflag;
	}

	/**
	 * Page Number
	 * @return pagerows
	 */
	public	String getPagerows() {
		return	this.pagerows;
	}

	/**
	 * Column Info
	 * @return no
	 */
	public	String getNo() {
		return	this.no;
	}

	/**
	 * Column Info
	 * @return rankSeq
	 */
	public	String getRankSeq() {
		return	this.rankSeq;
	}

	/**
	 * Column Info
	 * @return bookingNo
	 */
	public	String getBookingNo() {
		return	this.bookingNo;
	}

	/**
	 * Column Info
	 * @return bkgStsCd
	 */
	public	String getBkgStsCd() {
		return	this.bkgStsCd;
	}

	/**
	 * Column Info
	 * @return dgCntrSeq
	 */
	public	String getDgCntrSeq() {
		return	this.dgCntrSeq;
	}

	/**
	 * Column Info
	 * @return cntrCgoSeq
	 */
	public	String getCntrCgoSeq() {
		return	this.cntrCgoSeq;
	}

	/**
	 * Column Info
	 * @return rqstDay
	 */
	public	String getRqstDay() {
		return	this.rqstDay;
	}

	/**
	 * Column Info
	 * @return spclCgoAuthCd
	 */
	public	String getSpclCgoAuthCd() {
		return	this.spclCgoAuthCd;
	}

	/**
	 * Column Info
	 * @return spclCgoAuthRjctCd
	 */
	public	String getSpclCgoAuthRjctCd() {
		return	this.spclCgoAuthRjctCd;
	}

	/**
	 * Column Info
	 * @return aproRefNo
	 */
	public	String getAproRefNo() {
		return	this.aproRefNo;
	}

	/**
	 * Column Info
	 * @return ediSndNo
	 */
	public	String getEdiSndNo() {
		return	this.ediSndNo;
	}

	/**
	 * Column Info
	 * @return emlSndNo
	 */
	public	String getEmlSndNo() {
		return	this.emlSndNo;
	}

	/**
	 * Column Info
	 * @return slanCd
	 */
	public	String getSlanCd() {
		return	this.slanCd;
	}

	/**
	 * Column Info
	 * @return vslCd
	 */
	public	String getVslCd() {
		return	this.vslCd;
	}

	/**
	 * Column Info
	 * @return vslNm
	 */
	public	String getVslNm() {
		return	this.vslNm;
	}

	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public	String getSkdVoyNo() {
		return	this.skdVoyNo;
	}

	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public	String getSkdDirCd() {
		return	this.skdDirCd;
	}

	/**
	 * Column Info
	 * @return prpShpNm
	 */
	public	String getPrpShpNm() {
		return	this.prpShpNm;
	}

	/**
	 * Column Info
	 * @return diffRmk
	 */
	public	String getDiffRmk() {
		return	this.diffRmk;
	}

	/**
	 * Column Info
	 * @return dcgoStsCd
	 */
	public	String getDcgoStsCd() {
		return	this.dcgoStsCd;
	}

	/**
	 * Column Info
	 * @return crrCd
	 */
	public	String getCrrCd() {
		return	this.crrCd;
	}

	/**
	 * Column Info
	 * @return crrCode
	 */
	public	String getCrrCode() {
		return	this.crrCode;
	}

	/**
	 * Column Info
	 * @return porCd
	 */
	public	String getPorCd() {
		return	this.porCd;
	}

	/**
	 * Column Info
	 * @return polCd
	 */
	public	String getPolCd() {
		return	this.polCd;
	}

	/**
	 * Column Info
	 * @return emlChk
	 */
	public	String getEmlChk() {
		return	this.emlChk;
	}

	/**
	 * Column Info
	 * @return emlAddr
	 */
	public	String getEmlAddr() {
		return	this.emlAddr;
	}

	/**
	 * Column Info
	 * @return ediChk
	 */
	public	String getEdiChk() {
		return	this.ediChk;
	}

	/**
	 * Column Info
	 * @return mapgTrsmBndCd
	 */
	public	String getMapgTrsmBndCd() {
		return	this.mapgTrsmBndCd;
	}

	/**
	 * Column Info
	 * @return mapgTrsmDt
	 */
	public	String getMapgTrsmDt() {
		return	this.mapgTrsmDt;
	}

	/**
	 * Column Info
	 * @return mapgTrsmSpclCgoCateCd
	 */
	public	String getMapgTrsmSpclCgoCateCd() {
		return	this.mapgTrsmSpclCgoCateCd;
	}

	/**
	 * Column Info
	 * @return mapgPrnrSpclCgoSeq
	 */
	public	String getMapgPrnrSpclCgoSeq() {
		return	this.mapgPrnrSpclCgoSeq;
	}

	/**
	 * Column Info
	 * @return mapgEdiTrsmStsCd
	 */
	public	String getMapgEdiTrsmStsCd() {
		return	this.mapgEdiTrsmStsCd;
	}

	/**
	 * Column Info
	 * @return vpsEtaDt
	 */
	public	String getVpsEtaDt() {
		return	this.vpsEtaDt;
	}

	/**
	 * Column Info
	 * @return podCd
	 */
	public	String getPodCd() {
		return	this.podCd;
	}

	/**
	 * Column Info
	 * @return delCd
	 */
	public	String getDelCd() {
		return	this.delCd;
	}

	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public	String getCntrTpszCd() {
		return	this.cntrTpszCd;
	}

	/**
	 * Column Info
	 * @return dgTp
	 */
	public	String getDgTp() {
		return	this.dgTp;
	}

	/**
	 * Column Info
	 * @return imdgUnNo
	 */
	public	String getImdgUnNo() {
		return	this.imdgUnNo;
	}

	/**
	 * Column Info
	 * @return imdgSegrGrpNm
	 */
	public	String getImdgSegrGrpNm() {
		return	this.imdgSegrGrpNm;
	}

	/**
	 * Column Info
	 * @return imdgUnNoSeq
	 */
	public	String getImdgUnNoSeq() {
		return	this.imdgUnNoSeq;
	}

	/**
	 * Column Info
	 * @return imdgClssCd
	 */
	public	String getImdgClssCd() {
		return	this.imdgClssCd;
	}

	/**
	 * Column Info
	 * @return imdgSubsRskLblCd
	 */
	public	String getImdgSubsRskLblCd() {
		return	this.imdgSubsRskLblCd;
	}

	/**
	 * Column Info
	 * @return mrnPolutFlg
	 */
	public	String getMrnPolutFlg() {
		return	this.mrnPolutFlg;
	}

	/**
	 * Column Info
	 * @return imdgPckGrpCd
	 */
	public	String getImdgPckGrpCd() {
		return	this.imdgPckGrpCd;
	}

	/**
	 * Column Info
	 * @return imdgLmtQtyFlg
	 */
	public	String getImdgLmtQtyFlg() {
		return	this.imdgLmtQtyFlg;
	}

	/**
	 * Column Info
	 * @return imdgExptQtyFlg
	 */
	public	String getImdgExptQtyFlg() {
		return	this.imdgExptQtyFlg;
	}

	/**
	 * Column Info
	 * @return flshPntCdoTemp
	 */
	public	String getFlshPntCdoTemp() {
		return	this.flshPntCdoTemp;
	}

	/**
	 * Column Info
	 * @return grsWgt
	 */
	public	String getGrsWgt() {
		return	this.grsWgt;
	}

	/**
	 * Column Info
	 * @return netWgt
	 */
	public	String getNetWgt() {
		return	this.netWgt;
	}

	/**
	 * Column Info
	 * @return psaNo
	 */
	public	String getPsaNo() {
		return	this.psaNo;
	}

	/**
	 * Column Info
	 * @return hcdgFlg
	 */
	public	String getHcdgFlg() {
		return	this.hcdgFlg;
	}

	/**
	 * Column Info
	 * @return bkgNo
	 */
	public	String getBkgNo() {
		return	this.bkgNo;
	}

	/**
	 * Column Info
	 * @return spclCgoAproRqstSeq
	 */
	public	String getSpclCgoAproRqstSeq() {
		return	this.spclCgoAproRqstSeq;
	}

	/**
	 * Column Info
	 * @return spclCgoRqstSeq
	 */
	public	String getSpclCgoRqstSeq() {
		return	this.spclCgoRqstSeq;
	}

	/**
	 * Column Info
	 * @return cntrNo
	 */
	public	String getCntrNo() {
		return	this.cntrNo;
	}

	/**
	 * Column Info
	 * @return dcgoRefNo
	 */
	public	String getDcgoRefNo() {
		return	this.dcgoRefNo;
	}

	/**
	 * Column Info
	 * @return dcgoSeq
	 */
	public	String getDcgoSeq() {
		return	this.dcgoSeq;
	}
	
	/**
	 * Column Info
	 * @return dcgoQty
	 */
	public	String getDcgoQty() {
		return	this.dcgoQty;
	}

	/**
	 * Column Info
	 * @return lstRqstDatFlg
	 */
	public	String getLstRqstDatFlg() {
		return	this.lstRqstDatFlg;
	}

	/**
	 * Column Info
	 * @return bkgRcvTermCd
	 */
	public	String getBkgRcvTermCd() {
		return	this.bkgRcvTermCd;
	}

	/**
	 * Column Info
	 * @return bkgDeTermCd
	 */
	public	String getBkgDeTermCd() {
		return	this.bkgDeTermCd;
	}

	/**
	 * Column Info
	 * @return polClptIndSeq
	 */
	public	String getPolClptIndSeq() {
		return	this.polClptIndSeq;
	}

	/**
	 * Column Info
	 * @return podClptIndSeq
	 */
	public	String getPodClptIndSeq() {
		return	this.podClptIndSeq;
	}

	/**
	 * Column Info
	 * @return polYdCd
	 */
	public	String getPolYdCd() {
		return	this.polYdCd;
	}

	/**
	 * Column Info
	 * @return podYdCd
	 */
	public	String getPodYdCd() {
		return	this.podYdCd;
	}

	/**
	 * Column Info
	 * @return rgnShpOprCd
	 */
	public	String getRgnShpOprCd() {
		return	this.rgnShpOprCd;
	}

	/**
	 * Column Info
	 * @return spclCgoCateCd
	 */
	public	String getSpclCgoCateCd() {
		return	this.spclCgoCateCd;
	}

	/**
	 * Column Info
	 * @return spclCgoAuthNo
	 */
	public	String getSpclCgoAuthNo() {
		return	this.spclCgoAuthNo;
	}

	/**
	 * Column Info
	 * @return authOfcCd
	 */
	public	String getAuthOfcCd() {
		return	this.authOfcCd;
	}

	/**
	 * Column Info
	 * @return spclCgoAuthSeq
	 */
	public	String getSpclCgoAuthSeq() {
		return	this.spclCgoAuthSeq;
	}

	/**
	 * Column Info
	 * @return netWgtSum
	 */
	public	String getNetWgtSum() {
		return	this.netWgtSum;
	}

	/**
	 * Column Info
	 * @return scgFlg
	 */
	public	String getScgFlg() {
		return	this.scgFlg;
	}

	/**
	 * Column Info
	 * @return rqstAuthCd
	 */
	public	String getRqstAuthCd() {
		return	this.rqstAuthCd;
	}

	/**
	 * Column Info
	 * @return rqstOfcCd
	 */
	public	String getRqstOfcCd() {
		return	this.rqstOfcCd;
	}

	/**
	 * Column Info
	 * @return rqstDt
	 */
	public	String getRqstDt() {
		return	this.rqstDt;
	}

	/**
	 * Column Info
	 * @return rqstGdt
	 */
	public	String getRqstGdt() {
		return	this.rqstGdt;
	}

	/**
	 * Column Info
	 * @return rqstUsrId
	 */
	public	String getRqstUsrId() {
		return	this.rqstUsrId;
	}

	/**
	 * Column Info
	 * @return authDt
	 */
	public	String getAuthDt() {
		return	this.authDt;
	}

	/**
	 * Column Info
	 * @return authGdt
	 */
	public	String getAuthGdt() {
		return	this.authGdt;
	}

	/**
	 * Column Info
	 * @return authUsrId
	 */
	public	String getAuthUsrId() {
		return	this.authUsrId;
	}

	/**
	 * Column Info
	 * @return spclCgoAuthRmk
	 */
	public	String getSpclCgoAuthRmk() {
		return	this.spclCgoAuthRmk;
	}

	/**
	 * Column Info
	 * @return spclRqstDesc
	 */
	public	String getSpclRqstDesc() {
		return	this.spclRqstDesc;
	}

	/**
	 * Column Info
	 * @return inImdgPckQty1
	 */
	public	String getInImdgPckQty1() {
		return	this.inImdgPckQty1;
	}

	/**
	 * Column Info
	 * @return outImdgPckQty1
	 */
	public	String getOutImdgPckQty1() {
		return	this.outImdgPckQty1;
	}

	/**
	 * Column Info
	 * @return intmdImdgPckQty1
	 */
	public	String getIntmdImdgPckQty1() {
		return	this.intmdImdgPckQty1;
	}

	/**
	 * Column Info
	 * @return imdgSegrGrpNo
	 */
	public	String getImdgSegrGrpNo() {
		return	this.imdgSegrGrpNo;
	}

	/**
	 * Column Info
	 * @return rsdFlg
	 */
	public	String getRsdFlg() {
		return	this.rsdFlg;
	}

	/**
	 * Column Info
	 * @return dcgoCxlRqstSeq
	 */
	public	String getDcgoCxlRqstSeq() {
		return	this.dcgoCxlRqstSeq;
	}

	/**
	 * Column Info
	 * @return cxlCgoKndCd
	 */
	public	String getCxlCgoKndCd() {
		return	this.cxlCgoKndCd;
	}

	/**
	 * Column Info
	 * @return cxlCgoRqstDt
	 */
	public	String getCxlCgoRqstDt() {
		return	this.cxlCgoRqstDt;
	}

	/**
	 * Column Info
	 * @return cxlCgoRsn
	 */
	public	String getCxlCgoRsn() {
		return	this.cxlCgoRsn;
	}

	/**
	 * Column Info
	 * @return ediStatus
	 */
	public	String getEdiStatus() {
		return	this.ediStatus;
	}

	/**
	 * Column Info
	 * @return fltFileRefNo
	 */
	public	String getFltFileRefNo() {
		return	this.fltFileRefNo;
	}

	/**
	 * Column Info
	 * @return cfrFlg
	 */
	public	String getCfrFlg() {
		return	this.cfrFlg;
	}

	/**
	 * Column Info
	 * @return preSeq
	 */
	public	String getPreSeq() {
		return	this.preSeq;
	}

	/**
	 * Column Info
	 * @return ediMsgStsCd
	 */
	public	String getEdiMsgStsCd() {
		return	this.ediMsgStsCd;
	}

	/**
	 * Column Info
	 * @return ediDelStsCd
	 */
	public	String getEdiDelStsCd() {
		return	this.ediDelStsCd;
	}

 	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param  ibflag
 	 */
	public void	setIbflag(String ibflag ) {
		this.ibflag =	ibflag;
	}
 	/**
	 * Page Number
	 * @param  pagerows
 	 */
	public void	setPagerows(String pagerows ) {
		this.pagerows =	pagerows;
	}
 	/**
	 * Column Info
	 * @param  no
 	 */
	public void	setNo(String no ) {
		this.no =	no;
	}
 	/**
	 * Column Info
	 * @param  rankSeq
 	 */
	public void	setRankSeq(String rankSeq ) {
		this.rankSeq =	rankSeq;
	}
 	/**
	 * Column Info
	 * @param  bookingNo
 	 */
	public void	setBookingNo(String bookingNo ) {
		this.bookingNo =	bookingNo;
	}
 	/**
	 * Column Info
	 * @param  bkgStsCd
 	 */
	public void	setBkgStsCd(String bkgStsCd ) {
		this.bkgStsCd =	bkgStsCd;
	}
 	/**
	 * Column Info
	 * @param  dgCntrSeq
 	 */
	public void	setDgCntrSeq(String dgCntrSeq ) {
		this.dgCntrSeq =	dgCntrSeq;
	}
 	/**
	 * Column Info
	 * @param  cntrCgoSeq
 	 */
	public void	setCntrCgoSeq(String cntrCgoSeq ) {
		this.cntrCgoSeq =	cntrCgoSeq;
	}
 	/**
	 * Column Info
	 * @param  rqstDay
 	 */
	public void	setRqstDay(String rqstDay ) {
		this.rqstDay =	rqstDay;
	}
 	/**
	 * Column Info
	 * @param  spclCgoAuthCd
 	 */
	public void	setSpclCgoAuthCd(String spclCgoAuthCd ) {
		this.spclCgoAuthCd =	spclCgoAuthCd;
	}
 	/**
	 * Column Info
	 * @param  spclCgoAuthRjctCd
 	 */
	public void	setSpclCgoAuthRjctCd(String spclCgoAuthRjctCd ) {
		this.spclCgoAuthRjctCd =	spclCgoAuthRjctCd;
	}
 	/**
	 * Column Info
	 * @param  aproRefNo
 	 */
	public void	setAproRefNo(String aproRefNo ) {
		this.aproRefNo =	aproRefNo;
	}
 	/**
	 * Column Info
	 * @param  ediSndNo
 	 */
	public void	setEdiSndNo(String ediSndNo ) {
		this.ediSndNo =	ediSndNo;
	}
 	/**
	 * Column Info
	 * @param  emlSndNo
 	 */
	public void	setEmlSndNo(String emlSndNo ) {
		this.emlSndNo =	emlSndNo;
	}
 	/**
	 * Column Info
	 * @param  slanCd
 	 */
	public void	setSlanCd(String slanCd ) {
		this.slanCd =	slanCd;
	}
 	/**
	 * Column Info
	 * @param  vslCd
 	 */
	public void	setVslCd(String vslCd ) {
		this.vslCd =	vslCd;
	}
 	/**
	 * Column Info
	 * @param  vslNm
 	 */
	public void	setVslNm(String vslNm ) {
		this.vslNm =	vslNm;
	}
 	/**
	 * Column Info
	 * @param  skdVoyNo
 	 */
	public void	setSkdVoyNo(String skdVoyNo ) {
		this.skdVoyNo =	skdVoyNo;
	}
 	/**
	 * Column Info
	 * @param  skdDirCd
 	 */
	public void	setSkdDirCd(String skdDirCd ) {
		this.skdDirCd =	skdDirCd;
	}
 	/**
	 * Column Info
	 * @param  prpShpNm
 	 */
	public void	setPrpShpNm(String prpShpNm ) {
		this.prpShpNm =	prpShpNm;
	}
 	/**
	 * Column Info
	 * @param  diffRmk
 	 */
	public void	setDiffRmk(String diffRmk ) {
		this.diffRmk =	diffRmk;
	}
 	/**
	 * Column Info
	 * @param  dcgoStsCd
 	 */
	public void	setDcgoStsCd(String dcgoStsCd ) {
		this.dcgoStsCd =	dcgoStsCd;
	}
 	/**
	 * Column Info
	 * @param  crrCd
 	 */
	public void	setCrrCd(String crrCd ) {
		this.crrCd =	crrCd;
	}
 	/**
	 * Column Info
	 * @param  crrCode
 	 */
	public void	setCrrCode(String crrCode ) {
		this.crrCode =	crrCode;
	}
 	/**
	 * Column Info
	 * @param  porCd
 	 */
	public void	setPorCd(String porCd ) {
		this.porCd =	porCd;
	}
 	/**
	 * Column Info
	 * @param  polCd
 	 */
	public void	setPolCd(String polCd ) {
		this.polCd =	polCd;
	}
 	/**
	 * Column Info
	 * @param  emlChk
 	 */
	public void	setEmlChk(String emlChk ) {
		this.emlChk =	emlChk;
	}
 	/**
	 * Column Info
	 * @param  emlAddr
 	 */
	public void	setEmlAddr(String emlAddr ) {
		this.emlAddr =	emlAddr;
	}
 	/**
	 * Column Info
	 * @param  ediChk
 	 */
	public void	setEdiChk(String ediChk ) {
		this.ediChk =	ediChk;
	}
 	/**
	 * Column Info
	 * @param  mapgTrsmBndCd
 	 */
	public void	setMapgTrsmBndCd(String mapgTrsmBndCd ) {
		this.mapgTrsmBndCd =	mapgTrsmBndCd;
	}
 	/**
	 * Column Info
	 * @param  mapgTrsmDt
 	 */
	public void	setMapgTrsmDt(String mapgTrsmDt ) {
		this.mapgTrsmDt =	mapgTrsmDt;
	}
 	/**
	 * Column Info
	 * @param  mapgTrsmSpclCgoCateCd
 	 */
	public void	setMapgTrsmSpclCgoCateCd(String mapgTrsmSpclCgoCateCd ) {
		this.mapgTrsmSpclCgoCateCd =	mapgTrsmSpclCgoCateCd;
	}
 	/**
	 * Column Info
	 * @param  mapgPrnrSpclCgoSeq
 	 */
	public void	setMapgPrnrSpclCgoSeq(String mapgPrnrSpclCgoSeq ) {
		this.mapgPrnrSpclCgoSeq =	mapgPrnrSpclCgoSeq;
	}
 	/**
	 * Column Info
	 * @param  mapgEdiTrsmStsCd
 	 */
	public void	setMapgEdiTrsmStsCd(String mapgEdiTrsmStsCd ) {
		this.mapgEdiTrsmStsCd =	mapgEdiTrsmStsCd;
	}
 	/**
	 * Column Info
	 * @param  vpsEtaDt
 	 */
	public void	setVpsEtaDt(String vpsEtaDt ) {
		this.vpsEtaDt =	vpsEtaDt;
	}
 	/**
	 * Column Info
	 * @param  podCd
 	 */
	public void	setPodCd(String podCd ) {
		this.podCd =	podCd;
	}
 	/**
	 * Column Info
	 * @param  delCd
 	 */
	public void	setDelCd(String delCd ) {
		this.delCd =	delCd;
	}
 	/**
	 * Column Info
	 * @param  cntrTpszCd
 	 */
	public void	setCntrTpszCd(String cntrTpszCd ) {
		this.cntrTpszCd =	cntrTpszCd;
	}
 	/**
	 * Column Info
	 * @param  dgTp
 	 */
	public void	setDgTp(String dgTp ) {
		this.dgTp =	dgTp;
	}
 	/**
	 * Column Info
	 * @param  imdgUnNo
 	 */
	public void	setImdgUnNo(String imdgUnNo ) {
		this.imdgUnNo =	imdgUnNo;
	}
 	/**
	 * Column Info
	 * @param  imdgSegrGrpNm
 	 */
	public void	setImdgSegrGrpNm(String imdgSegrGrpNm ) {
		this.imdgSegrGrpNm =	imdgSegrGrpNm;
	}
 	/**
	 * Column Info
	 * @param  imdgUnNoSeq
 	 */
	public void	setImdgUnNoSeq(String imdgUnNoSeq ) {
		this.imdgUnNoSeq =	imdgUnNoSeq;
	}
 	/**
	 * Column Info
	 * @param  imdgClssCd
 	 */
	public void	setImdgClssCd(String imdgClssCd ) {
		this.imdgClssCd =	imdgClssCd;
	}
 	/**
	 * Column Info
	 * @param  imdgSubsRskLblCd
 	 */
	public void	setImdgSubsRskLblCd(String imdgSubsRskLblCd ) {
		this.imdgSubsRskLblCd =	imdgSubsRskLblCd;
	}
 	/**
	 * Column Info
	 * @param  mrnPolutFlg
 	 */
	public void	setMrnPolutFlg(String mrnPolutFlg ) {
		this.mrnPolutFlg =	mrnPolutFlg;
	}
 	/**
	 * Column Info
	 * @param  imdgPckGrpCd
 	 */
	public void	setImdgPckGrpCd(String imdgPckGrpCd ) {
		this.imdgPckGrpCd =	imdgPckGrpCd;
	}
 	/**
	 * Column Info
	 * @param  imdgLmtQtyFlg
 	 */
	public void	setImdgLmtQtyFlg(String imdgLmtQtyFlg ) {
		this.imdgLmtQtyFlg =	imdgLmtQtyFlg;
	}
 	/**
	 * Column Info
	 * @param  imdgExptQtyFlg
 	 */
	public void	setImdgExptQtyFlg(String imdgExptQtyFlg ) {
		this.imdgExptQtyFlg =	imdgExptQtyFlg;
	}
 	/**
	 * Column Info
	 * @param  flshPntCdoTemp
 	 */
	public void	setFlshPntCdoTemp(String flshPntCdoTemp ) {
		this.flshPntCdoTemp =	flshPntCdoTemp;
	}
 	/**
	 * Column Info
	 * @param  grsWgt
 	 */
	public void	setGrsWgt(String grsWgt ) {
		this.grsWgt =	grsWgt;
	}
 	/**
	 * Column Info
	 * @param  netWgt
 	 */
	public void	setNetWgt(String netWgt ) {
		this.netWgt =	netWgt;
	}
 	/**
	 * Column Info
	 * @param  psaNo
 	 */
	public void	setPsaNo(String psaNo ) {
		this.psaNo =	psaNo;
	}
 	/**
	 * Column Info
	 * @param  hcdgFlg
 	 */
	public void	setHcdgFlg(String hcdgFlg ) {
		this.hcdgFlg =	hcdgFlg;
	}
 	/**
	 * Column Info
	 * @param  bkgNo
 	 */
	public void	setBkgNo(String bkgNo ) {
		this.bkgNo =	bkgNo;
	}
 	/**
	 * Column Info
	 * @param  spclCgoAproRqstSeq
 	 */
	public void	setSpclCgoAproRqstSeq(String spclCgoAproRqstSeq ) {
		this.spclCgoAproRqstSeq =	spclCgoAproRqstSeq;
	}
 	/**
	 * Column Info
	 * @param  spclCgoRqstSeq
 	 */
	public void	setSpclCgoRqstSeq(String spclCgoRqstSeq ) {
		this.spclCgoRqstSeq =	spclCgoRqstSeq;
	}
 	/**
	 * Column Info
	 * @param  cntrNo
 	 */
	public void	setCntrNo(String cntrNo ) {
		this.cntrNo =	cntrNo;
	}
 	/**
	 * Column Info
	 * @param  dcgoRefNo
 	 */
	public void	setDcgoRefNo(String dcgoRefNo ) {
		this.dcgoRefNo =	dcgoRefNo;
	}
 	/**
	 * Column Info
	 * @param  dcgoSeq
 	 */
	public void	setDcgoSeq(String dcgoSeq ) {
		this.dcgoSeq =	dcgoSeq;
	}	
 	/**
	 * Column Info
	 * @param  dcgoQty
 	 */
	public void	setDcgoQty(String dcgoQty ) {
		this.dcgoQty =	dcgoQty;
	}
 	/**
	 * Column Info
	 * @param  lstRqstDatFlg
 	 */
	public void	setLstRqstDatFlg(String lstRqstDatFlg ) {
		this.lstRqstDatFlg =	lstRqstDatFlg;
	}
 	/**
	 * Column Info
	 * @param  bkgRcvTermCd
 	 */
	public void	setBkgRcvTermCd(String bkgRcvTermCd ) {
		this.bkgRcvTermCd =	bkgRcvTermCd;
	}
 	/**
	 * Column Info
	 * @param  bkgDeTermCd
 	 */
	public void	setBkgDeTermCd(String bkgDeTermCd ) {
		this.bkgDeTermCd =	bkgDeTermCd;
	}
 	/**
	 * Column Info
	 * @param  polClptIndSeq
 	 */
	public void	setPolClptIndSeq(String polClptIndSeq ) {
		this.polClptIndSeq =	polClptIndSeq;
	}
 	/**
	 * Column Info
	 * @param  podClptIndSeq
 	 */
	public void	setPodClptIndSeq(String podClptIndSeq ) {
		this.podClptIndSeq =	podClptIndSeq;
	}
 	/**
	 * Column Info
	 * @param  polYdCd
 	 */
	public void	setPolYdCd(String polYdCd ) {
		this.polYdCd =	polYdCd;
	}
 	/**
	 * Column Info
	 * @param  podYdCd
 	 */
	public void	setPodYdCd(String podYdCd ) {
		this.podYdCd =	podYdCd;
	}
 	/**
	 * Column Info
	 * @param  rgnShpOprCd
 	 */
	public void	setRgnShpOprCd(String rgnShpOprCd ) {
		this.rgnShpOprCd =	rgnShpOprCd;
	}
 	/**
	 * Column Info
	 * @param  spclCgoCateCd
 	 */
	public void	setSpclCgoCateCd(String spclCgoCateCd ) {
		this.spclCgoCateCd =	spclCgoCateCd;
	}
 	/**
	 * Column Info
	 * @param  spclCgoAuthNo
 	 */
	public void	setSpclCgoAuthNo(String spclCgoAuthNo ) {
		this.spclCgoAuthNo =	spclCgoAuthNo;
	}
 	/**
	 * Column Info
	 * @param  authOfcCd
 	 */
	public void	setAuthOfcCd(String authOfcCd ) {
		this.authOfcCd =	authOfcCd;
	}
 	/**
	 * Column Info
	 * @param  spclCgoAuthSeq
 	 */
	public void	setSpclCgoAuthSeq(String spclCgoAuthSeq ) {
		this.spclCgoAuthSeq =	spclCgoAuthSeq;
	}
 	/**
	 * Column Info
	 * @param  netWgtSum
 	 */
	public void	setNetWgtSum(String netWgtSum ) {
		this.netWgtSum =	netWgtSum;
	}
 	/**
	 * Column Info
	 * @param  scgFlg
 	 */
	public void	setScgFlg(String scgFlg ) {
		this.scgFlg =	scgFlg;
	}
 	/**
	 * Column Info
	 * @param  rqstAuthCd
 	 */
	public void	setRqstAuthCd(String rqstAuthCd ) {
		this.rqstAuthCd =	rqstAuthCd;
	}
 	/**
	 * Column Info
	 * @param  rqstOfcCd
 	 */
	public void	setRqstOfcCd(String rqstOfcCd ) {
		this.rqstOfcCd =	rqstOfcCd;
	}
 	/**
	 * Column Info
	 * @param  rqstDt
 	 */
	public void	setRqstDt(String rqstDt ) {
		this.rqstDt =	rqstDt;
	}
 	/**
	 * Column Info
	 * @param  rqstGdt
 	 */
	public void	setRqstGdt(String rqstGdt ) {
		this.rqstGdt =	rqstGdt;
	}
 	/**
	 * Column Info
	 * @param  rqstUsrId
 	 */
	public void	setRqstUsrId(String rqstUsrId ) {
		this.rqstUsrId =	rqstUsrId;
	}
 	/**
	 * Column Info
	 * @param  authDt
 	 */
	public void	setAuthDt(String authDt ) {
		this.authDt =	authDt;
	}
 	/**
	 * Column Info
	 * @param  authGdt
 	 */
	public void	setAuthGdt(String authGdt ) {
		this.authGdt =	authGdt;
	}
 	/**
	 * Column Info
	 * @param  authUsrId
 	 */
	public void	setAuthUsrId(String authUsrId ) {
		this.authUsrId =	authUsrId;
	}
 	/**
	 * Column Info
	 * @param  spclCgoAuthRmk
 	 */
	public void	setSpclCgoAuthRmk(String spclCgoAuthRmk ) {
		this.spclCgoAuthRmk =	spclCgoAuthRmk;
	}
 	/**
	 * Column Info
	 * @param  spclRqstDesc
 	 */
	public void	setSpclRqstDesc(String spclRqstDesc ) {
		this.spclRqstDesc =	spclRqstDesc;
	}
 	/**
	 * Column Info
	 * @param  inImdgPckQty1
 	 */
	public void	setInImdgPckQty1(String inImdgPckQty1 ) {
		this.inImdgPckQty1 =	inImdgPckQty1;
	}
 	/**
	 * Column Info
	 * @param  outImdgPckQty1
 	 */
	public void	setOutImdgPckQty1(String outImdgPckQty1 ) {
		this.outImdgPckQty1 =	outImdgPckQty1;
	}
 	/**
	 * Column Info
	 * @param  intmdImdgPckQty1
 	 */
	public void	setIntmdImdgPckQty1(String intmdImdgPckQty1 ) {
		this.intmdImdgPckQty1 =	intmdImdgPckQty1;
	}
 	/**
	 * Column Info
	 * @param  imdgSegrGrpNo
 	 */
	public void	setImdgSegrGrpNo(String imdgSegrGrpNo ) {
		this.imdgSegrGrpNo =	imdgSegrGrpNo;
	}
 	/**
	 * Column Info
	 * @param  rsdFlg
 	 */
	public void	setRsdFlg(String rsdFlg ) {
		this.rsdFlg =	rsdFlg;
	}
 	/**
	 * Column Info
	 * @param  dcgoCxlRqstSeq
 	 */
	public void	setDcgoCxlRqstSeq(String dcgoCxlRqstSeq ) {
		this.dcgoCxlRqstSeq =	dcgoCxlRqstSeq;
	}
 	/**
	 * Column Info
	 * @param  cxlCgoKndCd
 	 */
	public void	setCxlCgoKndCd(String cxlCgoKndCd ) {
		this.cxlCgoKndCd =	cxlCgoKndCd;
	}
 	/**
	 * Column Info
	 * @param  cxlCgoRqstDt
 	 */
	public void	setCxlCgoRqstDt(String cxlCgoRqstDt ) {
		this.cxlCgoRqstDt =	cxlCgoRqstDt;
	}
 	/**
	 * Column Info
	 * @param  cxlCgoRsn
 	 */
	public void	setCxlCgoRsn(String cxlCgoRsn ) {
		this.cxlCgoRsn =	cxlCgoRsn;
	}
 	/**
	 * Column Info
	 * @param  ediStatus
 	 */
	public void	setEdiStatus(String ediStatus ) {
		this.ediStatus =	ediStatus;
	}
 	/**
	 * Column Info
	 * @param  fltFileRefNo
 	 */
	public void	setFltFileRefNo(String fltFileRefNo ) {
		this.fltFileRefNo =	fltFileRefNo;
	}
 	/**
	 * Column Info
	 * @param  cfrFlg
 	 */
	public void	setCfrFlg(String cfrFlg ) {
		this.cfrFlg =	cfrFlg;
	}
 	/**
	 * Column Info
	 * @param  preSeq
 	 */
	public void	setPreSeq(String preSeq ) {
		this.preSeq =	preSeq;
	}
 	/**
	 * Column Info
	 * @param  ediMsgStsCd
 	 */
	public void	setEdiMsgStsCd(String ediMsgStsCd ) {
		this.ediMsgStsCd =	ediMsgStsCd;
	}
 	/**
	 * Column Info
	 * @param  ediDelStsCd
 	 */
	public void	setEdiDelStsCd(String ediDelStsCd ) {
		this.ediDelStsCd =	ediDelStsCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request)	{
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request,	String prefix) {
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setNo(JSPUtil.getParameter(request,	prefix + "no", ""));
		setRankSeq(JSPUtil.getParameter(request,	prefix + "rank_seq", ""));
		setBookingNo(JSPUtil.getParameter(request,	prefix + "booking_no", ""));
		setBkgStsCd(JSPUtil.getParameter(request,	prefix + "bkg_sts_cd", ""));
		setDgCntrSeq(JSPUtil.getParameter(request,	prefix + "dg_cntr_seq", ""));
		setCntrCgoSeq(JSPUtil.getParameter(request,	prefix + "cntr_cgo_seq", ""));
		setRqstDay(JSPUtil.getParameter(request,	prefix + "rqst_day", ""));
		setSpclCgoAuthCd(JSPUtil.getParameter(request,	prefix + "spcl_cgo_auth_cd", ""));
		setSpclCgoAuthRjctCd(JSPUtil.getParameter(request,	prefix + "spcl_cgo_auth_rjct_cd", ""));
		setAproRefNo(JSPUtil.getParameter(request,	prefix + "apro_ref_no", ""));
		setEdiSndNo(JSPUtil.getParameter(request,	prefix + "edi_snd_no", ""));
		setEmlSndNo(JSPUtil.getParameter(request,	prefix + "eml_snd_no", ""));
		setSlanCd(JSPUtil.getParameter(request,	prefix + "slan_cd", ""));
		setVslCd(JSPUtil.getParameter(request,	prefix + "vsl_cd", ""));
		setVslNm(JSPUtil.getParameter(request,	prefix + "vsl_nm", ""));
		setSkdVoyNo(JSPUtil.getParameter(request,	prefix + "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request,	prefix + "skd_dir_cd", ""));
		setPrpShpNm(JSPUtil.getParameter(request,	prefix + "prp_shp_nm", ""));
		setDiffRmk(JSPUtil.getParameter(request,	prefix + "diff_rmk", ""));
		setDcgoStsCd(JSPUtil.getParameter(request,	prefix + "dcgo_sts_cd", ""));
		setCrrCd(JSPUtil.getParameter(request,	prefix + "crr_cd", ""));
		setCrrCode(JSPUtil.getParameter(request,	prefix + "crr_code", ""));
		setPorCd(JSPUtil.getParameter(request,	prefix + "por_cd", ""));
		setPolCd(JSPUtil.getParameter(request,	prefix + "pol_cd", ""));
		setEmlChk(JSPUtil.getParameter(request,	prefix + "eml_chk", ""));
		setEmlAddr(JSPUtil.getParameter(request,	prefix + "eml_addr", ""));
		setEdiChk(JSPUtil.getParameter(request,	prefix + "edi_chk", ""));
		setMapgTrsmBndCd(JSPUtil.getParameter(request,	prefix + "mapg_trsm_bnd_cd", ""));
		setMapgTrsmDt(JSPUtil.getParameter(request,	prefix + "mapg_trsm_dt", ""));
		setMapgTrsmSpclCgoCateCd(JSPUtil.getParameter(request,	prefix + "mapg_trsm_spcl_cgo_cate_cd", ""));
		setMapgPrnrSpclCgoSeq(JSPUtil.getParameter(request,	prefix + "mapg_prnr_spcl_cgo_seq", ""));
		setMapgEdiTrsmStsCd(JSPUtil.getParameter(request,	prefix + "mapg_edi_trsm_sts_cd", ""));
		setVpsEtaDt(JSPUtil.getParameter(request,	prefix + "vps_eta_dt", ""));
		setPodCd(JSPUtil.getParameter(request,	prefix + "pod_cd", ""));
		setDelCd(JSPUtil.getParameter(request,	prefix + "del_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd", ""));
		setDgTp(JSPUtil.getParameter(request,	prefix + "dg_tp", ""));
		setImdgUnNo(JSPUtil.getParameter(request,	prefix + "imdg_un_no", ""));
		setImdgSegrGrpNm(JSPUtil.getParameter(request,	prefix + "imdg_segr_grp_nm", ""));
		setImdgUnNoSeq(JSPUtil.getParameter(request,	prefix + "imdg_un_no_seq", ""));
		setImdgClssCd(JSPUtil.getParameter(request,	prefix + "imdg_clss_cd", ""));
		setImdgSubsRskLblCd(JSPUtil.getParameter(request,	prefix + "imdg_subs_rsk_lbl_cd", ""));
		setMrnPolutFlg(JSPUtil.getParameter(request,	prefix + "mrn_polut_flg", ""));
		setImdgPckGrpCd(JSPUtil.getParameter(request,	prefix + "imdg_pck_grp_cd", ""));
		setImdgLmtQtyFlg(JSPUtil.getParameter(request,	prefix + "imdg_lmt_qty_flg", ""));
		setImdgExptQtyFlg(JSPUtil.getParameter(request,	prefix + "imdg_expt_qty_flg", ""));
		setFlshPntCdoTemp(JSPUtil.getParameter(request,	prefix + "flsh_pnt_cdo_temp", ""));
		setGrsWgt(JSPUtil.getParameter(request,	prefix + "grs_wgt", ""));
		setNetWgt(JSPUtil.getParameter(request,	prefix + "net_wgt", ""));
		setPsaNo(JSPUtil.getParameter(request,	prefix + "psa_no", ""));
		setHcdgFlg(JSPUtil.getParameter(request,	prefix + "hcdg_flg", ""));
		setBkgNo(JSPUtil.getParameter(request,	prefix + "bkg_no", ""));
		setSpclCgoAproRqstSeq(JSPUtil.getParameter(request,	prefix + "spcl_cgo_apro_rqst_seq", ""));
		setSpclCgoRqstSeq(JSPUtil.getParameter(request,	prefix + "spcl_cgo_rqst_seq", ""));
		setCntrNo(JSPUtil.getParameter(request,	prefix + "cntr_no", ""));
		setDcgoRefNo(JSPUtil.getParameter(request,	prefix + "dcgo_ref_no", ""));
		setDcgoSeq(JSPUtil.getParameter(request,	prefix + "dcgo_seq", ""));
		setDcgoQty(JSPUtil.getParameter(request,	prefix + "dcgo_qty", ""));
		setLstRqstDatFlg(JSPUtil.getParameter(request,	prefix + "lst_rqst_dat_flg", ""));
		setBkgRcvTermCd(JSPUtil.getParameter(request,	prefix + "bkg_rcv_term_cd", ""));
		setBkgDeTermCd(JSPUtil.getParameter(request,	prefix + "bkg_de_term_cd", ""));
		setPolClptIndSeq(JSPUtil.getParameter(request,	prefix + "pol_clpt_ind_seq", ""));
		setPodClptIndSeq(JSPUtil.getParameter(request,	prefix + "pod_clpt_ind_seq", ""));
		setPolYdCd(JSPUtil.getParameter(request,	prefix + "pol_yd_cd", ""));
		setPodYdCd(JSPUtil.getParameter(request,	prefix + "pod_yd_cd", ""));
		setRgnShpOprCd(JSPUtil.getParameter(request,	prefix + "rgn_shp_opr_cd", ""));
		setSpclCgoCateCd(JSPUtil.getParameter(request,	prefix + "spcl_cgo_cate_cd", ""));
		setSpclCgoAuthNo(JSPUtil.getParameter(request,	prefix + "spcl_cgo_auth_no", ""));
		setAuthOfcCd(JSPUtil.getParameter(request,	prefix + "auth_ofc_cd", ""));
		setSpclCgoAuthSeq(JSPUtil.getParameter(request,	prefix + "spcl_cgo_auth_seq", ""));
		setNetWgtSum(JSPUtil.getParameter(request,	prefix + "net_wgt_sum", ""));
		setScgFlg(JSPUtil.getParameter(request,	prefix + "scg_flg", ""));
		setRqstAuthCd(JSPUtil.getParameter(request,	prefix + "rqst_auth_cd", ""));
		setRqstOfcCd(JSPUtil.getParameter(request,	prefix + "rqst_ofc_cd", ""));
		setRqstDt(JSPUtil.getParameter(request,	prefix + "rqst_dt", ""));
		setRqstGdt(JSPUtil.getParameter(request,	prefix + "rqst_gdt", ""));
		setRqstUsrId(JSPUtil.getParameter(request,	prefix + "rqst_usr_id", ""));
		setAuthDt(JSPUtil.getParameter(request,	prefix + "auth_dt", ""));
		setAuthGdt(JSPUtil.getParameter(request,	prefix + "auth_gdt", ""));
		setAuthUsrId(JSPUtil.getParameter(request,	prefix + "auth_usr_id", ""));
		setSpclCgoAuthRmk(JSPUtil.getParameter(request,	prefix + "spcl_cgo_auth_rmk", ""));
		setSpclRqstDesc(JSPUtil.getParameter(request,	prefix + "spcl_rqst_desc", ""));
		setInImdgPckQty1(JSPUtil.getParameter(request,	prefix + "in_imdg_pck_qty1", ""));
		setOutImdgPckQty1(JSPUtil.getParameter(request,	prefix + "out_imdg_pck_qty1", ""));
		setIntmdImdgPckQty1(JSPUtil.getParameter(request,	prefix + "intmd_imdg_pck_qty1", ""));
		setImdgSegrGrpNo(JSPUtil.getParameter(request,	prefix + "imdg_segr_grp_no", ""));
		setRsdFlg(JSPUtil.getParameter(request,	prefix + "rsd_flg", ""));
		setDcgoCxlRqstSeq(JSPUtil.getParameter(request,	prefix + "dcgo_cxl_rqst_seq", ""));
		setCxlCgoKndCd(JSPUtil.getParameter(request,	prefix + "cxl_cgo_knd_cd", ""));
		setCxlCgoRqstDt(JSPUtil.getParameter(request,	prefix + "cxl_cgo_rqst_dt", ""));
		setCxlCgoRsn(JSPUtil.getParameter(request,	prefix + "cxl_cgo_rsn", ""));
		setEdiStatus(JSPUtil.getParameter(request,	prefix + "edi_status", ""));
		setFltFileRefNo(JSPUtil.getParameter(request,	prefix + "flt_file_ref_no", ""));
		setCfrFlg(JSPUtil.getParameter(request,	prefix + "cfr_flg", ""));
		setPreSeq(JSPUtil.getParameter(request,	prefix + "pre_seq", ""));
		setEdiMsgStsCd(JSPUtil.getParameter(request,	prefix + "edi_msg_sts_cd", ""));
		setEdiDelStsCd(JSPUtil.getParameter(request,	prefix + "edi_del_sts_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchPrnrDGListVO[]
	 */
	public SearchPrnrDGListVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return SearchPrnrDGListVO[]
	 */
	public SearchPrnrDGListVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		SearchPrnrDGListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
			String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag",	length));
			String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows",	length));
			String[] no =	(JSPUtil.getParameter(request, prefix +	"no",	length));
			String[] rankSeq =	(JSPUtil.getParameter(request, prefix +	"rank_seq",	length));
			String[] bookingNo =	(JSPUtil.getParameter(request, prefix +	"booking_no",	length));
			String[] bkgStsCd =	(JSPUtil.getParameter(request, prefix +	"bkg_sts_cd",	length));
			String[] dgCntrSeq =	(JSPUtil.getParameter(request, prefix +	"dg_cntr_seq",	length));
			String[] cntrCgoSeq =	(JSPUtil.getParameter(request, prefix +	"cntr_cgo_seq",	length));
			String[] rqstDay =	(JSPUtil.getParameter(request, prefix +	"rqst_day",	length));
			String[] spclCgoAuthCd =	(JSPUtil.getParameter(request, prefix +	"spcl_cgo_auth_cd",	length));
			String[] spclCgoAuthRjctCd =	(JSPUtil.getParameter(request, prefix +	"spcl_cgo_auth_rjct_cd",	length));
			String[] vslPrePstNm =	(JSPUtil.getParameter(request, prefix +	"vsl_pre_pst_nm",	length));
			String[] aproRefNo =	(JSPUtil.getParameter(request, prefix +	"apro_ref_no",	length));
			String[] ediSndNo =	(JSPUtil.getParameter(request, prefix +	"edi_snd_no",	length));
			String[] emlSndNo =	(JSPUtil.getParameter(request, prefix +	"eml_snd_no",	length));
			String[] slanCd =	(JSPUtil.getParameter(request, prefix +	"slan_cd",	length));
			String[] vslCd =	(JSPUtil.getParameter(request, prefix +	"vsl_cd",	length));
			String[] vslNm =	(JSPUtil.getParameter(request, prefix +	"vsl_nm",	length));
			String[] skdVoyNo =	(JSPUtil.getParameter(request, prefix +	"skd_voy_no",	length));
			String[] skdDirCd =	(JSPUtil.getParameter(request, prefix +	"skd_dir_cd",	length));
			String[] prpShpNm =	(JSPUtil.getParameter(request, prefix +	"prp_shp_nm",	length));
			String[] diffRmk =	(JSPUtil.getParameter(request, prefix +	"diff_rmk",	length));
			String[] dcgoStsCd =	(JSPUtil.getParameter(request, prefix +	"dcgo_sts_cd",	length));
			String[] crrCd =	(JSPUtil.getParameter(request, prefix +	"crr_cd",	length));
			String[] crrCode =	(JSPUtil.getParameter(request, prefix +	"crr_code",	length));
			String[] porCd =	(JSPUtil.getParameter(request, prefix +	"por_cd",	length));
			String[] polCd =	(JSPUtil.getParameter(request, prefix +	"pol_cd",	length));
			String[] emlChk =	(JSPUtil.getParameter(request, prefix +	"eml_chk",	length));
			String[] emlAddr =	(JSPUtil.getParameter(request, prefix +	"eml_addr",	length));
			String[] ediChk =	(JSPUtil.getParameter(request, prefix +	"edi_chk",	length));
			String[] mapgTrsmBndCd =	(JSPUtil.getParameter(request, prefix +	"mapg_trsm_bnd_cd",	length));
			String[] mapgTrsmDt =	(JSPUtil.getParameter(request, prefix +	"mapg_trsm_dt",	length));
			String[] mapgTrsmSpclCgoCateCd =	(JSPUtil.getParameter(request, prefix +	"mapg_trsm_spcl_cgo_cate_cd",	length));
			String[] mapgPrnrSpclCgoSeq =	(JSPUtil.getParameter(request, prefix +	"mapg_prnr_spcl_cgo_seq",	length));
			String[] mapgEdiTrsmStsCd =	(JSPUtil.getParameter(request, prefix +	"mapg_edi_trsm_sts_cd",	length));
			String[] vpsEtaDt =	(JSPUtil.getParameter(request, prefix +	"vps_eta_dt",	length));
			String[] podCd =	(JSPUtil.getParameter(request, prefix +	"pod_cd",	length));
			String[] delCd =	(JSPUtil.getParameter(request, prefix +	"del_cd",	length));
			String[] cntrTpszCd =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd",	length));
			String[] dgTp =	(JSPUtil.getParameter(request, prefix +	"dg_tp",	length));
			String[] imdgUnNo =	(JSPUtil.getParameter(request, prefix +	"imdg_un_no",	length));
			String[] imdgSegrGrpNm =	(JSPUtil.getParameter(request, prefix +	"imdg_segr_grp_nm",	length));
			String[] imdgUnNoSeq =	(JSPUtil.getParameter(request, prefix +	"imdg_un_no_seq",	length));
			String[] imdgClssCd =	(JSPUtil.getParameter(request, prefix +	"imdg_clss_cd",	length));
			String[] imdgSubsRskLblCd =	(JSPUtil.getParameter(request, prefix +	"imdg_subs_rsk_lbl_cd",	length));
			String[] mrnPolutFlg =	(JSPUtil.getParameter(request, prefix +	"mrn_polut_flg",	length));
			String[] imdgPckGrpCd =	(JSPUtil.getParameter(request, prefix +	"imdg_pck_grp_cd",	length));
			String[] imdgLmtQtyFlg =	(JSPUtil.getParameter(request, prefix +	"imdg_lmt_qty_flg",	length));
			String[] imdgExptQtyFlg =	(JSPUtil.getParameter(request, prefix +	"imdg_expt_qty_flg",	length));
			String[] flshPntCdoTemp =	(JSPUtil.getParameter(request, prefix +	"flsh_pnt_cdo_temp",	length));
			String[] grsWgt =	(JSPUtil.getParameter(request, prefix +	"grs_wgt",	length));
			String[] netWgt =	(JSPUtil.getParameter(request, prefix +	"net_wgt",	length));
			String[] psaNo =	(JSPUtil.getParameter(request, prefix +	"psa_no",	length));
			String[] hcdgFlg =	(JSPUtil.getParameter(request, prefix +	"hcdg_flg",	length));
			String[] bkgNo =	(JSPUtil.getParameter(request, prefix +	"bkg_no",	length));
			String[] spclCgoAproRqstSeq =	(JSPUtil.getParameter(request, prefix +	"spcl_cgo_apro_rqst_seq",	length));
			String[] spclCgoRqstSeq =	(JSPUtil.getParameter(request, prefix +	"spcl_cgo_rqst_seq",	length));
			String[] vslPrePstCd =	(JSPUtil.getParameter(request, prefix +	"vsl_pre_pst_cd",	length));
			String[] vslSeq =	(JSPUtil.getParameter(request, prefix +	"vsl_seq",	length));
			String[] cntrNo =	(JSPUtil.getParameter(request, prefix +	"cntr_no",	length));
			String[] dcgoRefNo =	(JSPUtil.getParameter(request, prefix +	"dcgo_ref_no",	length));
			String[] dcgoSeq =	(JSPUtil.getParameter(request, prefix +	"dcgo_seq",	length));
			String[] dcgoQty =	(JSPUtil.getParameter(request, prefix +	"dcgo_qty",	length));
			String[] lstRqstDatFlg =	(JSPUtil.getParameter(request, prefix +	"lst_rqst_dat_flg",	length));
			String[] bkgRcvTermCd =	(JSPUtil.getParameter(request, prefix +	"bkg_rcv_term_cd",	length));
			String[] bkgDeTermCd =	(JSPUtil.getParameter(request, prefix +	"bkg_de_term_cd",	length));
			String[] polClptIndSeq =	(JSPUtil.getParameter(request, prefix +	"pol_clpt_ind_seq",	length));
			String[] podClptIndSeq =	(JSPUtil.getParameter(request, prefix +	"pod_clpt_ind_seq",	length));
			String[] polYdCd =	(JSPUtil.getParameter(request, prefix +	"pol_yd_cd",	length));
			String[] podYdCd =	(JSPUtil.getParameter(request, prefix +	"pod_yd_cd",	length));
			String[] rgnShpOprCd =	(JSPUtil.getParameter(request, prefix +	"rgn_shp_opr_cd",	length));
			String[] spclCgoCateCd =	(JSPUtil.getParameter(request, prefix +	"spcl_cgo_cate_cd",	length));
			String[] spclCgoAuthNo =	(JSPUtil.getParameter(request, prefix +	"spcl_cgo_auth_no",	length));
			String[] authOfcCd =	(JSPUtil.getParameter(request, prefix +	"auth_ofc_cd",	length));
			String[] spclCgoAuthSeq =	(JSPUtil.getParameter(request, prefix +	"spcl_cgo_auth_seq",	length));
			String[] netWgtSum =	(JSPUtil.getParameter(request, prefix +	"net_wgt_sum",	length));
			String[] scgFlg =	(JSPUtil.getParameter(request, prefix +	"scg_flg",	length));
			String[] rqstAuthCd =	(JSPUtil.getParameter(request, prefix +	"rqst_auth_cd",	length));
			String[] rqstOfcCd =	(JSPUtil.getParameter(request, prefix +	"rqst_ofc_cd",	length));
			String[] rqstDt =	(JSPUtil.getParameter(request, prefix +	"rqst_dt",	length));
			String[] rqstGdt =	(JSPUtil.getParameter(request, prefix +	"rqst_gdt",	length));
			String[] rqstUsrId =	(JSPUtil.getParameter(request, prefix +	"rqst_usr_id",	length));
			String[] authDt =	(JSPUtil.getParameter(request, prefix +	"auth_dt",	length));
			String[] authGdt =	(JSPUtil.getParameter(request, prefix +	"auth_gdt",	length));
			String[] authUsrId =	(JSPUtil.getParameter(request, prefix +	"auth_usr_id",	length));
			String[] spclCgoAuthRmk =	(JSPUtil.getParameter(request, prefix +	"spcl_cgo_auth_rmk",	length));
			String[] spclRqstDesc =	(JSPUtil.getParameter(request, prefix +	"spcl_rqst_desc",	length));
			String[] inImdgPckQty1 =	(JSPUtil.getParameter(request, prefix +	"in_imdg_pck_qty1",	length));
			String[] outImdgPckQty1 =	(JSPUtil.getParameter(request, prefix +	"out_imdg_pck_qty1",	length));
			String[] intmdImdgPckQty1 =	(JSPUtil.getParameter(request, prefix +	"intmd_imdg_pck_qty1",	length));
			String[] imdgSegrGrpNo =	(JSPUtil.getParameter(request, prefix +	"imdg_segr_grp_no",	length));
			String[] rsdFlg =	(JSPUtil.getParameter(request, prefix +	"rsd_flg",	length));
			String[] dcgoCxlRqstSeq =	(JSPUtil.getParameter(request, prefix +	"dcgo_cxl_rqst_seq",	length));
			String[] cxlCgoKndCd =	(JSPUtil.getParameter(request, prefix +	"cxl_cgo_knd_cd",	length));
			String[] cxlCgoRqstDt =	(JSPUtil.getParameter(request, prefix +	"cxl_cgo_rqst_dt",	length));
			String[] cxlCgoRsn =	(JSPUtil.getParameter(request, prefix +	"cxl_cgo_rsn",	length));
			String[] ediStatus =	(JSPUtil.getParameter(request, prefix +	"edi_status",	length));
			String[] fltFileRefNo =	(JSPUtil.getParameter(request, prefix +	"flt_file_ref_no",	length));
			String[] cfrFlg =	(JSPUtil.getParameter(request, prefix +	"cfr_flg",	length));
			String[] preSeq =	(JSPUtil.getParameter(request, prefix +	"pre_seq",	length));
			String[] ediMsgStsCd =	(JSPUtil.getParameter(request, prefix +	"edi_msg_sts_cd",	length));
			String[] ediDelStsCd =	(JSPUtil.getParameter(request, prefix +	"edi_del_sts_cd",	length));
			for	(int i = 0;	i <	length;	i++) {
				model =	new	SearchPrnrDGListVO();
				if ( ibflag[i] !=	null)
					model.setIbflag( ibflag[i]);
				if ( pagerows[i] !=	null)
					model.setPagerows( pagerows[i]);
				if ( no[i] !=	null)
					model.setNo( no[i]);
				if ( rankSeq[i] !=	null)
					model.setRankSeq( rankSeq[i]);
				if ( bookingNo[i] !=	null)
					model.setBookingNo( bookingNo[i]);
				if ( bkgStsCd[i] !=	null)
					model.setBkgStsCd( bkgStsCd[i]);
				if ( dgCntrSeq[i] !=	null)
					model.setDgCntrSeq( dgCntrSeq[i]);
				if ( cntrCgoSeq[i] !=	null)
					model.setCntrCgoSeq( cntrCgoSeq[i]);
				if ( rqstDay[i] !=	null)
					model.setRqstDay( rqstDay[i]);
				if ( spclCgoAuthCd[i] !=	null)
					model.setSpclCgoAuthCd( spclCgoAuthCd[i]);
				if ( spclCgoAuthRjctCd[i] !=	null)
					model.setSpclCgoAuthRjctCd( spclCgoAuthRjctCd[i]);
				if ( aproRefNo[i] !=	null)
					model.setAproRefNo( aproRefNo[i]);
				if ( ediSndNo[i] !=	null)
					model.setEdiSndNo( ediSndNo[i]);
				if ( emlSndNo[i] !=	null)
					model.setEmlSndNo( emlSndNo[i]);
				if ( slanCd[i] !=	null)
					model.setSlanCd( slanCd[i]);
				if ( vslCd[i] !=	null)
					model.setVslCd( vslCd[i]);
				if ( vslNm[i] !=	null)
					model.setVslNm( vslNm[i]);
				if ( skdVoyNo[i] !=	null)
					model.setSkdVoyNo( skdVoyNo[i]);
				if ( skdDirCd[i] !=	null)
					model.setSkdDirCd( skdDirCd[i]);
				if ( prpShpNm[i] !=	null)
					model.setPrpShpNm( prpShpNm[i]);
				if ( diffRmk[i] !=	null)
					model.setDiffRmk( diffRmk[i]);
				if ( dcgoStsCd[i] !=	null)
					model.setDcgoStsCd( dcgoStsCd[i]);
				if ( crrCd[i] !=	null)
					model.setCrrCd( crrCd[i]);
				if ( crrCode[i] !=	null)
					model.setCrrCode( crrCode[i]);
				if ( porCd[i] !=	null)
					model.setPorCd( porCd[i]);
				if ( polCd[i] !=	null)
					model.setPolCd( polCd[i]);
				if ( emlChk[i] !=	null)
					model.setEmlChk( emlChk[i]);
				if ( emlAddr[i] !=	null)
					model.setEmlAddr( emlAddr[i]);
				if ( ediChk[i] !=	null)
					model.setEdiChk( ediChk[i]);
				if ( mapgTrsmBndCd[i] !=	null)
					model.setMapgTrsmBndCd( mapgTrsmBndCd[i]);
				if ( mapgTrsmDt[i] !=	null)
					model.setMapgTrsmDt( mapgTrsmDt[i]);
				if ( mapgTrsmSpclCgoCateCd[i] !=	null)
					model.setMapgTrsmSpclCgoCateCd( mapgTrsmSpclCgoCateCd[i]);
				if ( mapgPrnrSpclCgoSeq[i] !=	null)
					model.setMapgPrnrSpclCgoSeq( mapgPrnrSpclCgoSeq[i]);
				if ( mapgEdiTrsmStsCd[i] !=	null)
					model.setMapgEdiTrsmStsCd( mapgEdiTrsmStsCd[i]);
				if ( vpsEtaDt[i] !=	null)
					model.setVpsEtaDt( vpsEtaDt[i]);
				if ( podCd[i] !=	null)
					model.setPodCd( podCd[i]);
				if ( delCd[i] !=	null)
					model.setDelCd( delCd[i]);
				if ( cntrTpszCd[i] !=	null)
					model.setCntrTpszCd( cntrTpszCd[i]);
				if ( dgTp[i] !=	null)
					model.setDgTp( dgTp[i]);
				if ( imdgUnNo[i] !=	null)
					model.setImdgUnNo( imdgUnNo[i]);
				if ( imdgSegrGrpNm[i] !=	null)
					model.setImdgSegrGrpNm( imdgSegrGrpNm[i]);
				if ( imdgUnNoSeq[i] !=	null)
					model.setImdgUnNoSeq( imdgUnNoSeq[i]);
				if ( imdgClssCd[i] !=	null)
					model.setImdgClssCd( imdgClssCd[i]);
				if ( imdgSubsRskLblCd[i] !=	null)
					model.setImdgSubsRskLblCd( imdgSubsRskLblCd[i]);
				if ( mrnPolutFlg[i] !=	null)
					model.setMrnPolutFlg( mrnPolutFlg[i]);
				if ( imdgPckGrpCd[i] !=	null)
					model.setImdgPckGrpCd( imdgPckGrpCd[i]);
				if ( imdgLmtQtyFlg[i] !=	null)
					model.setImdgLmtQtyFlg( imdgLmtQtyFlg[i]);
				if ( imdgExptQtyFlg[i] !=	null)
					model.setImdgExptQtyFlg( imdgExptQtyFlg[i]);
				if ( flshPntCdoTemp[i] !=	null)
					model.setFlshPntCdoTemp( flshPntCdoTemp[i]);
				if ( grsWgt[i] !=	null)
					model.setGrsWgt( grsWgt[i]);
				if ( netWgt[i] !=	null)
					model.setNetWgt( netWgt[i]);
				if ( psaNo[i] !=	null)
					model.setPsaNo( psaNo[i]);
				if ( hcdgFlg[i] !=	null)
					model.setHcdgFlg( hcdgFlg[i]);
				if ( bkgNo[i] !=	null)
					model.setBkgNo( bkgNo[i]);
				if ( spclCgoAproRqstSeq[i] !=	null)
					model.setSpclCgoAproRqstSeq( spclCgoAproRqstSeq[i]);
				if ( spclCgoRqstSeq[i] !=	null)
					model.setSpclCgoRqstSeq( spclCgoRqstSeq[i]);
				if ( cntrNo[i] !=	null)
					model.setCntrNo( cntrNo[i]);
				if ( dcgoRefNo[i] !=	null)
					model.setDcgoRefNo( dcgoRefNo[i]);
				if ( dcgoSeq[i] !=	null)
					model.setDcgoSeq( dcgoSeq[i]);
				if ( dcgoQty[i] !=	null)
					model.setDcgoQty( dcgoQty[i]);
				if ( lstRqstDatFlg[i] !=	null)
					model.setLstRqstDatFlg( lstRqstDatFlg[i]);
				if ( bkgRcvTermCd[i] !=	null)
					model.setBkgRcvTermCd( bkgRcvTermCd[i]);
				if ( bkgDeTermCd[i] !=	null)
					model.setBkgDeTermCd( bkgDeTermCd[i]);
				if ( polClptIndSeq[i] !=	null)
					model.setPolClptIndSeq( polClptIndSeq[i]);
				if ( podClptIndSeq[i] !=	null)
					model.setPodClptIndSeq( podClptIndSeq[i]);
				if ( polYdCd[i] !=	null)
					model.setPolYdCd( polYdCd[i]);
				if ( podYdCd[i] !=	null)
					model.setPodYdCd( podYdCd[i]);
				if ( rgnShpOprCd[i] !=	null)
					model.setRgnShpOprCd( rgnShpOprCd[i]);
				if ( spclCgoCateCd[i] !=	null)
					model.setSpclCgoCateCd( spclCgoCateCd[i]);
				if ( spclCgoAuthNo[i] !=	null)
					model.setSpclCgoAuthNo( spclCgoAuthNo[i]);
				if ( authOfcCd[i] !=	null)
					model.setAuthOfcCd( authOfcCd[i]);
				if ( spclCgoAuthSeq[i] !=	null)
					model.setSpclCgoAuthSeq( spclCgoAuthSeq[i]);
				if ( netWgtSum[i] !=	null)
					model.setNetWgtSum( netWgtSum[i]);
				if ( scgFlg[i] !=	null)
					model.setScgFlg( scgFlg[i]);
				if ( rqstAuthCd[i] !=	null)
					model.setRqstAuthCd( rqstAuthCd[i]);
				if ( rqstOfcCd[i] !=	null)
					model.setRqstOfcCd( rqstOfcCd[i]);
				if ( rqstDt[i] !=	null)
					model.setRqstDt( rqstDt[i]);
				if ( rqstGdt[i] !=	null)
					model.setRqstGdt( rqstGdt[i]);
				if ( rqstUsrId[i] !=	null)
					model.setRqstUsrId( rqstUsrId[i]);
				if ( authDt[i] !=	null)
					model.setAuthDt( authDt[i]);
				if ( authGdt[i] !=	null)
					model.setAuthGdt( authGdt[i]);
				if ( authUsrId[i] !=	null)
					model.setAuthUsrId( authUsrId[i]);
				if ( spclCgoAuthRmk[i] !=	null)
					model.setSpclCgoAuthRmk( spclCgoAuthRmk[i]);
				if ( spclRqstDesc[i] !=	null)
					model.setSpclRqstDesc( spclRqstDesc[i]);
				if ( inImdgPckQty1[i] !=	null)
					model.setInImdgPckQty1( inImdgPckQty1[i]);
				if ( outImdgPckQty1[i] !=	null)
					model.setOutImdgPckQty1( outImdgPckQty1[i]);
				if ( intmdImdgPckQty1[i] !=	null)
					model.setIntmdImdgPckQty1( intmdImdgPckQty1[i]);
				if ( imdgSegrGrpNo[i] !=	null)
					model.setImdgSegrGrpNo( imdgSegrGrpNo[i]);
				if ( rsdFlg[i] !=	null)
					model.setRsdFlg( rsdFlg[i]);
				if ( dcgoCxlRqstSeq[i] !=	null)
					model.setDcgoCxlRqstSeq( dcgoCxlRqstSeq[i]);
				if ( cxlCgoKndCd[i] !=	null)
					model.setCxlCgoKndCd( cxlCgoKndCd[i]);
				if ( cxlCgoRqstDt[i] !=	null)
					model.setCxlCgoRqstDt( cxlCgoRqstDt[i]);
				if ( cxlCgoRsn[i] !=	null)
					model.setCxlCgoRsn( cxlCgoRsn[i]);
				if ( ediStatus[i] !=	null)
					model.setEdiStatus( ediStatus[i]);
				if ( fltFileRefNo[i] !=	null)
					model.setFltFileRefNo( fltFileRefNo[i]);
				if ( cfrFlg[i] !=	null)
					model.setCfrFlg( cfrFlg[i]);
				if ( preSeq[i] !=	null)
					model.setPreSeq( preSeq[i]);
				if ( ediMsgStsCd[i] !=	null)
					model.setEdiMsgStsCd( ediMsgStsCd[i]);
				if ( ediDelStsCd[i] !=	null)
					model.setEdiDelStsCd( ediDelStsCd[i]);
				models.add(model);
			}

		} catch	(Exception e) {
			return null;
		}
		return getSearchPrnrDGListVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return SearchPrnrDGListVO[]
	 */
	public SearchPrnrDGListVO[]	 getSearchPrnrDGListVOs(){
		SearchPrnrDGListVO[] vos = (SearchPrnrDGListVO[])models.toArray(new	SearchPrnrDGListVO[models.size()]);
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
	public void	unDataFormat(){
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.no =	this.no.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rankSeq =	this.rankSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bookingNo =	this.bookingNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd =	this.bkgStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgCntrSeq =	this.dgCntrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCgoSeq =	this.cntrCgoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDay =	this.rqstDay.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoAuthCd =	this.spclCgoAuthCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoAuthRjctCd =	this.spclCgoAuthRjctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproRefNo =	this.aproRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndNo =	this.ediSndNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndNo =	this.emlSndNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd =	this.slanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd =	this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm =	this.vslNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo =	this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd =	this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prpShpNm =	this.prpShpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk =	this.diffRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoStsCd =	this.dcgoStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd =	this.crrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCode =	this.crrCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd =	this.porCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd =	this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlChk =	this.emlChk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlAddr =	this.emlAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediChk =	this.ediChk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mapgTrsmBndCd =	this.mapgTrsmBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mapgTrsmDt =	this.mapgTrsmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mapgTrsmSpclCgoCateCd =	this.mapgTrsmSpclCgoCateCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mapgPrnrSpclCgoSeq =	this.mapgPrnrSpclCgoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mapgEdiTrsmStsCd =	this.mapgEdiTrsmStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt =	this.vpsEtaDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd =	this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd =	this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd =	this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgTp =	this.dgTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo =	this.imdgUnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSegrGrpNm =	this.imdgSegrGrpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNoSeq =	this.imdgUnNoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd =	this.imdgClssCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSubsRskLblCd =	this.imdgSubsRskLblCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnPolutFlg =	this.mrnPolutFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckGrpCd =	this.imdgPckGrpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgLmtQtyFlg =	this.imdgLmtQtyFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgExptQtyFlg =	this.imdgExptQtyFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flshPntCdoTemp =	this.flshPntCdoTemp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgt =	this.grsWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netWgt =	this.netWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psaNo =	this.psaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcdgFlg =	this.hcdgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo =	this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoAproRqstSeq =	this.spclCgoAproRqstSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoRqstSeq =	this.spclCgoRqstSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo =	this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoRefNo =	this.dcgoRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoSeq =	this.dcgoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoQty =	this.dcgoQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstRqstDatFlg =	this.lstRqstDatFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRcvTermCd =	this.bkgRcvTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDeTermCd =	this.bkgDeTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polClptIndSeq =	this.polClptIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podClptIndSeq =	this.podClptIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd =	this.polYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd =	this.podYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnShpOprCd =	this.rgnShpOprCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoCateCd =	this.spclCgoCateCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoAuthNo =	this.spclCgoAuthNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authOfcCd =	this.authOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoAuthSeq =	this.spclCgoAuthSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netWgtSum =	this.netWgtSum.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgFlg =	this.scgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstAuthCd =	this.rqstAuthCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcCd =	this.rqstOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDt =	this.rqstDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstGdt =	this.rqstGdt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUsrId =	this.rqstUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authDt =	this.authDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authGdt =	this.authGdt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authUsrId =	this.authUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoAuthRmk =	this.spclCgoAuthRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclRqstDesc =	this.spclRqstDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inImdgPckQty1 =	this.inImdgPckQty1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outImdgPckQty1 =	this.outImdgPckQty1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intmdImdgPckQty1 =	this.intmdImdgPckQty1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSegrGrpNo =	this.imdgSegrGrpNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsdFlg =	this.rsdFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoCxlRqstSeq =	this.dcgoCxlRqstSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlCgoKndCd =	this.cxlCgoKndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlCgoRqstDt =	this.cxlCgoRqstDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlCgoRsn =	this.cxlCgoRsn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediStatus =	this.ediStatus.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fltFileRefNo =	this.fltFileRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfrFlg =	this.cfrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preSeq =	this.preSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediMsgStsCd =	this.ediMsgStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediDelStsCd =	this.ediDelStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}