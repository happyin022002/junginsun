/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DgInqModiVO.java
*@FileTitle : DgInqModiVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.25
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2011.05.25 박성진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.vo;

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
 * @author 박성진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DgInqModiVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DgInqModiVO> models = new ArrayList<DgInqModiVO>();
	
	/* Column Info */
	private String brthYdCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String cntrTpszIsoCd = null;
	/* Column Info */
	private String imdgUnNoSeq = null;
	/* Column Info */
	private String eurPckDesc = null;
	/* Column Info */
	private String outImdgPckQty1 = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String saveType = null;
	/* Column Info */
	private String anrCrrTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String brthYdNm = null;
	/* Column Info */
	private String imdgCompGrpCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String dType = null;
	/* Column Info */
	private String xtdStayPrmtNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String eurDgDeclTpCd = null;
	/* Column Info */
	private String fdrVvdId = null;
	/* Column Info */
	private String hcdgFlg = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Column Info */
	private String inImdgPckCd1 = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String netWgt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String cstmsErrMsg = null;
	/* Column Info */
	private String cntrCgoSeq = null;
	/* Column Info */
	private String fwrdNm = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String netExploWgt = null;
	/* Column Info */
	private String ackRcvStsCd = null;
	/* Column Info */
	private String emerRspnGidNo = null;
	/* Column Info */
	private String hzdDesc = null;
	/* Column Info */
	private String imdgClssCd = null;
	/* Column Info */
	private String outImdgPckCd1 = null;
	/* Column Info */
	private String grsWgt = null;
	/* Column Info */
	private String fdrVslNm = null;
	/* Column Info */
	private String imdgPckGrpCd = null;
	/* Column Info */
	private String flshPntCdoTemp = null;
	/* Column Info */
	private String emsNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mfagNo = null;
	/* Column Info */
	private String anrFwrdId = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String eurOutrPckDesc = null;
	/* Column Info */
	private String dcgoMrnPolutCd = null;
	/* Column Info */
	private String eurInrPckDesc = null;
	/* Column Info */
	private String cellPsnNo = null;
	/* Column Info */
	private String fdrSvcRqstNo = null;
	/* Column Info */
	private String fdrVslLloydNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String anrSpclTpId = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String inImdgPckQty1 = null;
	/* Column Info */
	private String imdgSubsRskLblCd2 = null;
	/* Column Info */
	private String imdgSubsRskLblCd1 = null;
	/* Column Info */
	private String prpShpNm = null;
	/* Column Info */
	private String imdgSubsRskLblCd4 = null;
	/* Column Info */
	private String crrDt = null;
	/* Column Info */
	private String imdgSubsRskLblCd3 = null;
	/* Column Info */
	private String imdgLmtQtyFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DgInqModiVO() {}

	public DgInqModiVO(String ibflag, String pagerows, String brthYdCd, String vslCd, String cntrTpszIsoCd, String imdgUnNoSeq, String eurPckDesc, String outImdgPckQty1, String blNo, String saveType, String anrCrrTpCd, String brthYdNm, String imdgCompGrpCd, String vvdCd, String dType, String cntrTpszCd, String xtdStayPrmtNo, String eurDgDeclTpCd, String fdrVvdId, String updUsrId, String inImdgPckCd1, String imdgUnNo, String hcdgFlg, String netWgt, String skdVoyNo, String cstmsErrMsg, String cntrCgoSeq, String fwrdNm, String creUsrId, String bkgNo, String netExploWgt, String ackRcvStsCd, String emerRspnGidNo, String hzdDesc, String imdgClssCd, String outImdgPckCd1, String grsWgt, String fdrVslNm, String imdgPckGrpCd, String flshPntCdoTemp, String emsNo, String mfagNo, String anrFwrdId, String portCd, String eurOutrPckDesc, String dcgoMrnPolutCd, String eurInrPckDesc, String cellPsnNo, String fdrSvcRqstNo, String fdrVslLloydNo, String skdDirCd, String diffRmk, String cntrNo, String anrSpclTpId, String inImdgPckQty1, String prpShpNm, String crrDt, String imdgLmtQtyFlg, String imdgSubsRskLblCd1, String imdgSubsRskLblCd2, String imdgSubsRskLblCd3, String imdgSubsRskLblCd4) {
		this.brthYdCd = brthYdCd;
		this.vslCd = vslCd;
		this.cntrTpszIsoCd = cntrTpszIsoCd;
		this.imdgUnNoSeq = imdgUnNoSeq;
		this.eurPckDesc = eurPckDesc;
		this.outImdgPckQty1 = outImdgPckQty1;
		this.blNo = blNo;
		this.saveType = saveType;
		this.anrCrrTpCd = anrCrrTpCd;
		this.pagerows = pagerows;
		this.brthYdNm = brthYdNm;
		this.imdgCompGrpCd = imdgCompGrpCd;
		this.vvdCd = vvdCd;
		this.dType = dType;
		this.xtdStayPrmtNo = xtdStayPrmtNo;
		this.cntrTpszCd = cntrTpszCd;
		this.eurDgDeclTpCd = eurDgDeclTpCd;
		this.fdrVvdId = fdrVvdId;
		this.hcdgFlg = hcdgFlg;
		this.imdgUnNo = imdgUnNo;
		this.inImdgPckCd1 = inImdgPckCd1;
		this.updUsrId = updUsrId;
		this.netWgt = netWgt;
		this.skdVoyNo = skdVoyNo;
		this.cstmsErrMsg = cstmsErrMsg;
		this.cntrCgoSeq = cntrCgoSeq;
		this.fwrdNm = fwrdNm;
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.netExploWgt = netExploWgt;
		this.ackRcvStsCd = ackRcvStsCd;
		this.emerRspnGidNo = emerRspnGidNo;
		this.hzdDesc = hzdDesc;
		this.imdgClssCd = imdgClssCd;
		this.outImdgPckCd1 = outImdgPckCd1;
		this.grsWgt = grsWgt;
		this.fdrVslNm = fdrVslNm;
		this.imdgPckGrpCd = imdgPckGrpCd;
		this.flshPntCdoTemp = flshPntCdoTemp;
		this.emsNo = emsNo;
		this.ibflag = ibflag;
		this.mfagNo = mfagNo;
		this.anrFwrdId = anrFwrdId;
		this.portCd = portCd;
		this.eurOutrPckDesc = eurOutrPckDesc;
		this.dcgoMrnPolutCd = dcgoMrnPolutCd;
		this.eurInrPckDesc = eurInrPckDesc;
		this.cellPsnNo = cellPsnNo;
		this.fdrSvcRqstNo = fdrSvcRqstNo;
		this.fdrVslLloydNo = fdrVslLloydNo;
		this.skdDirCd = skdDirCd;
		this.diffRmk = diffRmk;
		this.anrSpclTpId = anrSpclTpId;
		this.cntrNo = cntrNo;
		this.inImdgPckQty1 = inImdgPckQty1;
		this.imdgSubsRskLblCd2 = imdgSubsRskLblCd2;
		this.imdgSubsRskLblCd1 = imdgSubsRskLblCd1;
		this.prpShpNm = prpShpNm;
		this.imdgSubsRskLblCd4 = imdgSubsRskLblCd4;
		this.crrDt = crrDt;
		this.imdgSubsRskLblCd3 = imdgSubsRskLblCd3;
		this.imdgLmtQtyFlg = imdgLmtQtyFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("brth_yd_cd", getBrthYdCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("cntr_tpsz_iso_cd", getCntrTpszIsoCd());
		this.hashColumns.put("imdg_un_no_seq", getImdgUnNoSeq());
		this.hashColumns.put("eur_pck_desc", getEurPckDesc());
		this.hashColumns.put("out_imdg_pck_qty1", getOutImdgPckQty1());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("save_type", getSaveType());
		this.hashColumns.put("anr_crr_tp_cd", getAnrCrrTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("brth_yd_nm", getBrthYdNm());
		this.hashColumns.put("imdg_comp_grp_cd", getImdgCompGrpCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("d_type", getDType());
		this.hashColumns.put("xtd_stay_prmt_no", getXtdStayPrmtNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("eur_dg_decl_tp_cd", getEurDgDeclTpCd());
		this.hashColumns.put("fdr_vvd_id", getFdrVvdId());
		this.hashColumns.put("hcdg_flg", getHcdgFlg());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("in_imdg_pck_cd1", getInImdgPckCd1());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("net_wgt", getNetWgt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("cstms_err_msg", getCstmsErrMsg());
		this.hashColumns.put("cntr_cgo_seq", getCntrCgoSeq());
		this.hashColumns.put("fwrd_nm", getFwrdNm());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("net_explo_wgt", getNetExploWgt());
		this.hashColumns.put("ack_rcv_sts_cd", getAckRcvStsCd());
		this.hashColumns.put("emer_rspn_gid_no", getEmerRspnGidNo());
		this.hashColumns.put("hzd_desc", getHzdDesc());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		this.hashColumns.put("out_imdg_pck_cd1", getOutImdgPckCd1());
		this.hashColumns.put("grs_wgt", getGrsWgt());
		this.hashColumns.put("fdr_vsl_nm", getFdrVslNm());
		this.hashColumns.put("imdg_pck_grp_cd", getImdgPckGrpCd());
		this.hashColumns.put("flsh_pnt_cdo_temp", getFlshPntCdoTemp());
		this.hashColumns.put("ems_no", getEmsNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mfag_no", getMfagNo());
		this.hashColumns.put("anr_fwrd_id", getAnrFwrdId());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("eur_outr_pck_desc", getEurOutrPckDesc());
		this.hashColumns.put("dcgo_mrn_polut_cd", getDcgoMrnPolutCd());
		this.hashColumns.put("eur_inr_pck_desc", getEurInrPckDesc());
		this.hashColumns.put("cell_psn_no", getCellPsnNo());
		this.hashColumns.put("fdr_svc_rqst_no", getFdrSvcRqstNo());
		this.hashColumns.put("fdr_vsl_lloyd_no", getFdrVslLloydNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("anr_spcl_tp_id", getAnrSpclTpId());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("in_imdg_pck_qty1", getInImdgPckQty1());
		this.hashColumns.put("imdg_subs_rsk_lbl_cd2", getImdgSubsRskLblCd2());
		this.hashColumns.put("imdg_subs_rsk_lbl_cd1", getImdgSubsRskLblCd1());
		this.hashColumns.put("prp_shp_nm", getPrpShpNm());
		this.hashColumns.put("imdg_subs_rsk_lbl_cd4", getImdgSubsRskLblCd4());
		this.hashColumns.put("crr_dt", getCrrDt());
		this.hashColumns.put("imdg_subs_rsk_lbl_cd3", getImdgSubsRskLblCd3());
		this.hashColumns.put("imdg_lmt_qty_flg", getImdgLmtQtyFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("brth_yd_cd", "brthYdCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("cntr_tpsz_iso_cd", "cntrTpszIsoCd");
		this.hashFields.put("imdg_un_no_seq", "imdgUnNoSeq");
		this.hashFields.put("eur_pck_desc", "eurPckDesc");
		this.hashFields.put("out_imdg_pck_qty1", "outImdgPckQty1");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("save_type", "saveType");
		this.hashFields.put("anr_crr_tp_cd", "anrCrrTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("brth_yd_nm", "brthYdNm");
		this.hashFields.put("imdg_comp_grp_cd", "imdgCompGrpCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("d_type", "dType");
		this.hashFields.put("xtd_stay_prmt_no", "xtdStayPrmtNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("eur_dg_decl_tp_cd", "eurDgDeclTpCd");
		this.hashFields.put("fdr_vvd_id", "fdrVvdId");
		this.hashFields.put("hcdg_flg", "hcdgFlg");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("in_imdg_pck_cd1", "inImdgPckCd1");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("net_wgt", "netWgt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("cstms_err_msg", "cstmsErrMsg");
		this.hashFields.put("cntr_cgo_seq", "cntrCgoSeq");
		this.hashFields.put("fwrd_nm", "fwrdNm");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("net_explo_wgt", "netExploWgt");
		this.hashFields.put("ack_rcv_sts_cd", "ackRcvStsCd");
		this.hashFields.put("emer_rspn_gid_no", "emerRspnGidNo");
		this.hashFields.put("hzd_desc", "hzdDesc");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("out_imdg_pck_cd1", "outImdgPckCd1");
		this.hashFields.put("grs_wgt", "grsWgt");
		this.hashFields.put("fdr_vsl_nm", "fdrVslNm");
		this.hashFields.put("imdg_pck_grp_cd", "imdgPckGrpCd");
		this.hashFields.put("flsh_pnt_cdo_temp", "flshPntCdoTemp");
		this.hashFields.put("ems_no", "emsNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mfag_no", "mfagNo");
		this.hashFields.put("anr_fwrd_id", "anrFwrdId");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("eur_outr_pck_desc", "eurOutrPckDesc");
		this.hashFields.put("dcgo_mrn_polut_cd", "dcgoMrnPolutCd");
		this.hashFields.put("eur_inr_pck_desc", "eurInrPckDesc");
		this.hashFields.put("cell_psn_no", "cellPsnNo");
		this.hashFields.put("fdr_svc_rqst_no", "fdrSvcRqstNo");
		this.hashFields.put("fdr_vsl_lloyd_no", "fdrVslLloydNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("anr_spcl_tp_id", "anrSpclTpId");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("in_imdg_pck_qty1", "inImdgPckQty1");
		this.hashFields.put("imdg_subs_rsk_lbl_cd2", "imdgSubsRskLblCd2");
		this.hashFields.put("imdg_subs_rsk_lbl_cd1", "imdgSubsRskLblCd1");
		this.hashFields.put("prp_shp_nm", "prpShpNm");
		this.hashFields.put("imdg_subs_rsk_lbl_cd4", "imdgSubsRskLblCd4");
		this.hashFields.put("crr_dt", "crrDt");
		this.hashFields.put("imdg_subs_rsk_lbl_cd3", "imdgSubsRskLblCd3");
		this.hashFields.put("imdg_lmt_qty_flg", "imdgLmtQtyFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return brthYdCd
	 */
	public String getBrthYdCd() {
		return this.brthYdCd;
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
	 * @return cntrTpszIsoCd
	 */
	public String getCntrTpszIsoCd() {
		return this.cntrTpszIsoCd;
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
	 * @return eurPckDesc
	 */
	public String getEurPckDesc() {
		return this.eurPckDesc;
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
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return saveType
	 */
	public String getSaveType() {
		return this.saveType;
	}
	
	/**
	 * Column Info
	 * @return anrCrrTpCd
	 */
	public String getAnrCrrTpCd() {
		return this.anrCrrTpCd;
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
	 * @return brthYdNm
	 */
	public String getBrthYdNm() {
		return this.brthYdNm;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return dType
	 */
	public String getDType() {
		return this.dType;
	}
	
	/**
	 * Column Info
	 * @return xtdStayPrmtNo
	 */
	public String getXtdStayPrmtNo() {
		return this.xtdStayPrmtNo;
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
	 * @return eurDgDeclTpCd
	 */
	public String getEurDgDeclTpCd() {
		return this.eurDgDeclTpCd;
	}
	
	/**
	 * Column Info
	 * @return fdrVvdId
	 */
	public String getFdrVvdId() {
		return this.fdrVvdId;
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
	 * @return inImdgPckCd1
	 */
	public String getInImdgPckCd1() {
		return this.inImdgPckCd1;
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
	 * @return netWgt
	 */
	public String getNetWgt() {
		return this.netWgt;
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
	 * @return cstmsErrMsg
	 */
	public String getCstmsErrMsg() {
		return this.cstmsErrMsg;
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
	 * @return fwrdNm
	 */
	public String getFwrdNm() {
		return this.fwrdNm;
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
	 * @return netExploWgt
	 */
	public String getNetExploWgt() {
		return this.netExploWgt;
	}
	
	/**
	 * Column Info
	 * @return ackRcvStsCd
	 */
	public String getAckRcvStsCd() {
		return this.ackRcvStsCd;
	}
	
	/**
	 * Column Info
	 * @return emerRspnGidNo
	 */
	public String getEmerRspnGidNo() {
		return this.emerRspnGidNo;
	}
	
	/**
	 * Column Info
	 * @return hzdDesc
	 */
	public String getHzdDesc() {
		return this.hzdDesc;
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
	 * @return outImdgPckCd1
	 */
	public String getOutImdgPckCd1() {
		return this.outImdgPckCd1;
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
	 * @return fdrVslNm
	 */
	public String getFdrVslNm() {
		return this.fdrVslNm;
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
	 * @return emsNo
	 */
	public String getEmsNo() {
		return this.emsNo;
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
	 * @return mfagNo
	 */
	public String getMfagNo() {
		return this.mfagNo;
	}
	
	/**
	 * Column Info
	 * @return anrFwrdId
	 */
	public String getAnrFwrdId() {
		return this.anrFwrdId;
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
	 * @return eurOutrPckDesc
	 */
	public String getEurOutrPckDesc() {
		return this.eurOutrPckDesc;
	}
	
	/**
	 * Column Info
	 * @return dcgoMrnPolutCd
	 */
	public String getDcgoMrnPolutCd() {
		return this.dcgoMrnPolutCd;
	}
	
	/**
	 * Column Info
	 * @return eurInrPckDesc
	 */
	public String getEurInrPckDesc() {
		return this.eurInrPckDesc;
	}
	
	/**
	 * Column Info
	 * @return cellPsnNo
	 */
	public String getCellPsnNo() {
		return this.cellPsnNo;
	}
	
	/**
	 * Column Info
	 * @return fdrSvcRqstNo
	 */
	public String getFdrSvcRqstNo() {
		return this.fdrSvcRqstNo;
	}
	
	/**
	 * Column Info
	 * @return fdrVslLloydNo
	 */
	public String getFdrVslLloydNo() {
		return this.fdrVslLloydNo;
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
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
	}
	
	/**
	 * Column Info
	 * @return anrSpclTpId
	 */
	public String getAnrSpclTpId() {
		return this.anrSpclTpId;
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
	 * @return inImdgPckQty1
	 */
	public String getInImdgPckQty1() {
		return this.inImdgPckQty1;
	}
	
	/**
	 * Column Info
	 * @return imdgSubsRskLblCd2
	 */
	public String getImdgSubsRskLblCd2() {
		return this.imdgSubsRskLblCd2;
	}
	
	/**
	 * Column Info
	 * @return imdgSubsRskLblCd1
	 */
	public String getImdgSubsRskLblCd1() {
		return this.imdgSubsRskLblCd1;
	}
	
	/**
	 * Column Info
	 * @return prpShpNm
	 */
	public String getPrpShpNm() {
		return this.prpShpNm;
	}
	
	/**
	 * Column Info
	 * @return imdgSubsRskLblCd4
	 */
	public String getImdgSubsRskLblCd4() {
		return this.imdgSubsRskLblCd4;
	}
	
	/**
	 * Column Info
	 * @return crrDt
	 */
	public String getCrrDt() {
		return this.crrDt;
	}
	
	/**
	 * Column Info
	 * @return imdgSubsRskLblCd3
	 */
	public String getImdgSubsRskLblCd3() {
		return this.imdgSubsRskLblCd3;
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
	 * @param brthYdCd
	 */
	public void setBrthYdCd(String brthYdCd) {
		this.brthYdCd = brthYdCd;
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
	 * @param cntrTpszIsoCd
	 */
	public void setCntrTpszIsoCd(String cntrTpszIsoCd) {
		this.cntrTpszIsoCd = cntrTpszIsoCd;
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
	 * @param eurPckDesc
	 */
	public void setEurPckDesc(String eurPckDesc) {
		this.eurPckDesc = eurPckDesc;
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
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param saveType
	 */
	public void setSaveType(String saveType) {
		this.saveType = saveType;
	}
	
	/**
	 * Column Info
	 * @param anrCrrTpCd
	 */
	public void setAnrCrrTpCd(String anrCrrTpCd) {
		this.anrCrrTpCd = anrCrrTpCd;
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
	 * @param brthYdNm
	 */
	public void setBrthYdNm(String brthYdNm) {
		this.brthYdNm = brthYdNm;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param dType
	 */
	public void setDType(String dType) {
		this.dType = dType;
	}
	
	/**
	 * Column Info
	 * @param xtdStayPrmtNo
	 */
	public void setXtdStayPrmtNo(String xtdStayPrmtNo) {
		this.xtdStayPrmtNo = xtdStayPrmtNo;
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
	 * @param eurDgDeclTpCd
	 */
	public void setEurDgDeclTpCd(String eurDgDeclTpCd) {
		this.eurDgDeclTpCd = eurDgDeclTpCd;
	}
	
	/**
	 * Column Info
	 * @param fdrVvdId
	 */
	public void setFdrVvdId(String fdrVvdId) {
		this.fdrVvdId = fdrVvdId;
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
	 * @param inImdgPckCd1
	 */
	public void setInImdgPckCd1(String inImdgPckCd1) {
		this.inImdgPckCd1 = inImdgPckCd1;
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
	 * @param netWgt
	 */
	public void setNetWgt(String netWgt) {
		this.netWgt = netWgt;
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
	 * @param cstmsErrMsg
	 */
	public void setCstmsErrMsg(String cstmsErrMsg) {
		this.cstmsErrMsg = cstmsErrMsg;
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
	 * @param fwrdNm
	 */
	public void setFwrdNm(String fwrdNm) {
		this.fwrdNm = fwrdNm;
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
	 * @param netExploWgt
	 */
	public void setNetExploWgt(String netExploWgt) {
		this.netExploWgt = netExploWgt;
	}
	
	/**
	 * Column Info
	 * @param ackRcvStsCd
	 */
	public void setAckRcvStsCd(String ackRcvStsCd) {
		this.ackRcvStsCd = ackRcvStsCd;
	}
	
	/**
	 * Column Info
	 * @param emerRspnGidNo
	 */
	public void setEmerRspnGidNo(String emerRspnGidNo) {
		this.emerRspnGidNo = emerRspnGidNo;
	}
	
	/**
	 * Column Info
	 * @param hzdDesc
	 */
	public void setHzdDesc(String hzdDesc) {
		this.hzdDesc = hzdDesc;
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
	 * @param outImdgPckCd1
	 */
	public void setOutImdgPckCd1(String outImdgPckCd1) {
		this.outImdgPckCd1 = outImdgPckCd1;
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
	 * @param fdrVslNm
	 */
	public void setFdrVslNm(String fdrVslNm) {
		this.fdrVslNm = fdrVslNm;
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
	 * @param emsNo
	 */
	public void setEmsNo(String emsNo) {
		this.emsNo = emsNo;
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
	 * @param mfagNo
	 */
	public void setMfagNo(String mfagNo) {
		this.mfagNo = mfagNo;
	}
	
	/**
	 * Column Info
	 * @param anrFwrdId
	 */
	public void setAnrFwrdId(String anrFwrdId) {
		this.anrFwrdId = anrFwrdId;
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
	 * @param eurOutrPckDesc
	 */
	public void setEurOutrPckDesc(String eurOutrPckDesc) {
		this.eurOutrPckDesc = eurOutrPckDesc;
	}
	
	/**
	 * Column Info
	 * @param dcgoMrnPolutCd
	 */
	public void setDcgoMrnPolutCd(String dcgoMrnPolutCd) {
		this.dcgoMrnPolutCd = dcgoMrnPolutCd;
	}
	
	/**
	 * Column Info
	 * @param eurInrPckDesc
	 */
	public void setEurInrPckDesc(String eurInrPckDesc) {
		this.eurInrPckDesc = eurInrPckDesc;
	}
	
	/**
	 * Column Info
	 * @param cellPsnNo
	 */
	public void setCellPsnNo(String cellPsnNo) {
		this.cellPsnNo = cellPsnNo;
	}
	
	/**
	 * Column Info
	 * @param fdrSvcRqstNo
	 */
	public void setFdrSvcRqstNo(String fdrSvcRqstNo) {
		this.fdrSvcRqstNo = fdrSvcRqstNo;
	}
	
	/**
	 * Column Info
	 * @param fdrVslLloydNo
	 */
	public void setFdrVslLloydNo(String fdrVslLloydNo) {
		this.fdrVslLloydNo = fdrVslLloydNo;
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
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
	}
	
	/**
	 * Column Info
	 * @param anrSpclTpId
	 */
	public void setAnrSpclTpId(String anrSpclTpId) {
		this.anrSpclTpId = anrSpclTpId;
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
	 * @param inImdgPckQty1
	 */
	public void setInImdgPckQty1(String inImdgPckQty1) {
		this.inImdgPckQty1 = inImdgPckQty1;
	}
	
	/**
	 * Column Info
	 * @param imdgSubsRskLblCd2
	 */
	public void setImdgSubsRskLblCd2(String imdgSubsRskLblCd2) {
		this.imdgSubsRskLblCd2 = imdgSubsRskLblCd2;
	}
	
	/**
	 * Column Info
	 * @param imdgSubsRskLblCd1
	 */
	public void setImdgSubsRskLblCd1(String imdgSubsRskLblCd1) {
		this.imdgSubsRskLblCd1 = imdgSubsRskLblCd1;
	}
	
	/**
	 * Column Info
	 * @param prpShpNm
	 */
	public void setPrpShpNm(String prpShpNm) {
		this.prpShpNm = prpShpNm;
	}
	
	/**
	 * Column Info
	 * @param imdgSubsRskLblCd4
	 */
	public void setImdgSubsRskLblCd4(String imdgSubsRskLblCd4) {
		this.imdgSubsRskLblCd4 = imdgSubsRskLblCd4;
	}
	
	/**
	 * Column Info
	 * @param crrDt
	 */
	public void setCrrDt(String crrDt) {
		this.crrDt = crrDt;
	}
	
	/**
	 * Column Info
	 * @param imdgSubsRskLblCd3
	 */
	public void setImdgSubsRskLblCd3(String imdgSubsRskLblCd3) {
		this.imdgSubsRskLblCd3 = imdgSubsRskLblCd3;
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
		setBrthYdCd(JSPUtil.getParameter(request, prefix + "brth_yd_cd", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setCntrTpszIsoCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_iso_cd", ""));
		setImdgUnNoSeq(JSPUtil.getParameter(request, prefix + "imdg_un_no_seq", ""));
		setEurPckDesc(JSPUtil.getParameter(request, prefix + "eur_pck_desc", ""));
		setOutImdgPckQty1(JSPUtil.getParameter(request, prefix + "out_imdg_pck_qty1", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setSaveType(JSPUtil.getParameter(request, prefix + "save_type", ""));
		setAnrCrrTpCd(JSPUtil.getParameter(request, prefix + "anr_crr_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBrthYdNm(JSPUtil.getParameter(request, prefix + "brth_yd_nm", ""));
		setImdgCompGrpCd(JSPUtil.getParameter(request, prefix + "imdg_comp_grp_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setDType(JSPUtil.getParameter(request, prefix + "d_type", ""));
		setXtdStayPrmtNo(JSPUtil.getParameter(request, prefix + "xtd_stay_prmt_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setEurDgDeclTpCd(JSPUtil.getParameter(request, prefix + "eur_dg_decl_tp_cd", ""));
		setFdrVvdId(JSPUtil.getParameter(request, prefix + "fdr_vvd_id", ""));
		setHcdgFlg(JSPUtil.getParameter(request, prefix + "hcdg_flg", ""));
		setImdgUnNo(JSPUtil.getParameter(request, prefix + "imdg_un_no", ""));
		setInImdgPckCd1(JSPUtil.getParameter(request, prefix + "in_imdg_pck_cd1", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setNetWgt(JSPUtil.getParameter(request, prefix + "net_wgt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setCstmsErrMsg(JSPUtil.getParameter(request, prefix + "cstms_err_msg", ""));
		setCntrCgoSeq(JSPUtil.getParameter(request, prefix + "cntr_cgo_seq", ""));
		setFwrdNm(JSPUtil.getParameter(request, prefix + "fwrd_nm", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setNetExploWgt(JSPUtil.getParameter(request, prefix + "net_explo_wgt", ""));
		setAckRcvStsCd(JSPUtil.getParameter(request, prefix + "ack_rcv_sts_cd", ""));
		setEmerRspnGidNo(JSPUtil.getParameter(request, prefix + "emer_rspn_gid_no", ""));
		setHzdDesc(JSPUtil.getParameter(request, prefix + "hzd_desc", ""));
		setImdgClssCd(JSPUtil.getParameter(request, prefix + "imdg_clss_cd", ""));
		setOutImdgPckCd1(JSPUtil.getParameter(request, prefix + "out_imdg_pck_cd1", ""));
		setGrsWgt(JSPUtil.getParameter(request, prefix + "grs_wgt", ""));
		setFdrVslNm(JSPUtil.getParameter(request, prefix + "fdr_vsl_nm", ""));
		setImdgPckGrpCd(JSPUtil.getParameter(request, prefix + "imdg_pck_grp_cd", ""));
		setFlshPntCdoTemp(JSPUtil.getParameter(request, prefix + "flsh_pnt_cdo_temp", ""));
		setEmsNo(JSPUtil.getParameter(request, prefix + "ems_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMfagNo(JSPUtil.getParameter(request, prefix + "mfag_no", ""));
		setAnrFwrdId(JSPUtil.getParameter(request, prefix + "anr_fwrd_id", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setEurOutrPckDesc(JSPUtil.getParameter(request, prefix + "eur_outr_pck_desc", ""));
		setDcgoMrnPolutCd(JSPUtil.getParameter(request, prefix + "dcgo_mrn_polut_cd", ""));
		setEurInrPckDesc(JSPUtil.getParameter(request, prefix + "eur_inr_pck_desc", ""));
		setCellPsnNo(JSPUtil.getParameter(request, prefix + "cell_psn_no", ""));
		setFdrSvcRqstNo(JSPUtil.getParameter(request, prefix + "fdr_svc_rqst_no", ""));
		setFdrVslLloydNo(JSPUtil.getParameter(request, prefix + "fdr_vsl_lloyd_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setDiffRmk(JSPUtil.getParameter(request, prefix + "diff_rmk", ""));
		setAnrSpclTpId(JSPUtil.getParameter(request, prefix + "anr_spcl_tp_id", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setInImdgPckQty1(JSPUtil.getParameter(request, prefix + "in_imdg_pck_qty1", ""));
		setImdgSubsRskLblCd2(JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_cd2", ""));
		setImdgSubsRskLblCd1(JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_cd1", ""));
		setPrpShpNm(JSPUtil.getParameter(request, prefix + "prp_shp_nm", ""));
		setImdgSubsRskLblCd4(JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_cd4", ""));
		setCrrDt(JSPUtil.getParameter(request, prefix + "crr_dt", ""));
		setImdgSubsRskLblCd3(JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_cd3", ""));
		setImdgLmtQtyFlg(JSPUtil.getParameter(request, prefix + "imdg_lmt_qty_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DgInqModiVO[]
	 */
	public DgInqModiVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DgInqModiVO[]
	 */
	public DgInqModiVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DgInqModiVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] brthYdCd = (JSPUtil.getParameter(request, prefix	+ "brth_yd_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] cntrTpszIsoCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_iso_cd", length));
			String[] imdgUnNoSeq = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no_seq", length));
			String[] eurPckDesc = (JSPUtil.getParameter(request, prefix	+ "eur_pck_desc", length));
			String[] outImdgPckQty1 = (JSPUtil.getParameter(request, prefix	+ "out_imdg_pck_qty1", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] saveType = (JSPUtil.getParameter(request, prefix	+ "save_type", length));
			String[] anrCrrTpCd = (JSPUtil.getParameter(request, prefix	+ "anr_crr_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] brthYdNm = (JSPUtil.getParameter(request, prefix	+ "brth_yd_nm", length));
			String[] imdgCompGrpCd = (JSPUtil.getParameter(request, prefix	+ "imdg_comp_grp_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] dType = (JSPUtil.getParameter(request, prefix	+ "d_type", length));
			String[] xtdStayPrmtNo = (JSPUtil.getParameter(request, prefix	+ "xtd_stay_prmt_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] eurDgDeclTpCd = (JSPUtil.getParameter(request, prefix	+ "eur_dg_decl_tp_cd", length));
			String[] fdrVvdId = (JSPUtil.getParameter(request, prefix	+ "fdr_vvd_id", length));
			String[] hcdgFlg = (JSPUtil.getParameter(request, prefix	+ "hcdg_flg", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			String[] inImdgPckCd1 = (JSPUtil.getParameter(request, prefix	+ "in_imdg_pck_cd1", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] netWgt = (JSPUtil.getParameter(request, prefix	+ "net_wgt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] cstmsErrMsg = (JSPUtil.getParameter(request, prefix	+ "cstms_err_msg", length));
			String[] cntrCgoSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_cgo_seq", length));
			String[] fwrdNm = (JSPUtil.getParameter(request, prefix	+ "fwrd_nm", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] netExploWgt = (JSPUtil.getParameter(request, prefix	+ "net_explo_wgt", length));
			String[] ackRcvStsCd = (JSPUtil.getParameter(request, prefix	+ "ack_rcv_sts_cd", length));
			String[] emerRspnGidNo = (JSPUtil.getParameter(request, prefix	+ "emer_rspn_gid_no", length));
			String[] hzdDesc = (JSPUtil.getParameter(request, prefix	+ "hzd_desc", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			String[] outImdgPckCd1 = (JSPUtil.getParameter(request, prefix	+ "out_imdg_pck_cd1", length));
			String[] grsWgt = (JSPUtil.getParameter(request, prefix	+ "grs_wgt", length));
			String[] fdrVslNm = (JSPUtil.getParameter(request, prefix	+ "fdr_vsl_nm", length));
			String[] imdgPckGrpCd = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_grp_cd", length));
			String[] flshPntCdoTemp = (JSPUtil.getParameter(request, prefix	+ "flsh_pnt_cdo_temp", length));
			String[] emsNo = (JSPUtil.getParameter(request, prefix	+ "ems_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mfagNo = (JSPUtil.getParameter(request, prefix	+ "mfag_no", length));
			String[] anrFwrdId = (JSPUtil.getParameter(request, prefix	+ "anr_fwrd_id", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] eurOutrPckDesc = (JSPUtil.getParameter(request, prefix	+ "eur_outr_pck_desc", length));
			String[] dcgoMrnPolutCd = (JSPUtil.getParameter(request, prefix	+ "dcgo_mrn_polut_cd", length));
			String[] eurInrPckDesc = (JSPUtil.getParameter(request, prefix	+ "eur_inr_pck_desc", length));
			String[] cellPsnNo = (JSPUtil.getParameter(request, prefix	+ "cell_psn_no", length));
			String[] fdrSvcRqstNo = (JSPUtil.getParameter(request, prefix	+ "fdr_svc_rqst_no", length));
			String[] fdrVslLloydNo = (JSPUtil.getParameter(request, prefix	+ "fdr_vsl_lloyd_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] anrSpclTpId = (JSPUtil.getParameter(request, prefix	+ "anr_spcl_tp_id", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] inImdgPckQty1 = (JSPUtil.getParameter(request, prefix	+ "in_imdg_pck_qty1", length));
			String[] imdgSubsRskLblCd2 = (JSPUtil.getParameter(request, prefix	+ "imdg_subs_rsk_lbl_cd2", length));
			String[] imdgSubsRskLblCd1 = (JSPUtil.getParameter(request, prefix	+ "imdg_subs_rsk_lbl_cd1", length));
			String[] prpShpNm = (JSPUtil.getParameter(request, prefix	+ "prp_shp_nm", length));
			String[] imdgSubsRskLblCd4 = (JSPUtil.getParameter(request, prefix	+ "imdg_subs_rsk_lbl_cd4", length));
			String[] crrDt = (JSPUtil.getParameter(request, prefix	+ "crr_dt", length));
			String[] imdgSubsRskLblCd3 = (JSPUtil.getParameter(request, prefix	+ "imdg_subs_rsk_lbl_cd3", length));
			String[] imdgLmtQtyFlg = (JSPUtil.getParameter(request, prefix	+ "imdg_lmt_qty_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new DgInqModiVO();
				if (brthYdCd[i] != null)
					model.setBrthYdCd(brthYdCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (cntrTpszIsoCd[i] != null)
					model.setCntrTpszIsoCd(cntrTpszIsoCd[i]);
				if (imdgUnNoSeq[i] != null)
					model.setImdgUnNoSeq(imdgUnNoSeq[i]);
				if (eurPckDesc[i] != null)
					model.setEurPckDesc(eurPckDesc[i]);
				if (outImdgPckQty1[i] != null)
					model.setOutImdgPckQty1(outImdgPckQty1[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (saveType[i] != null)
					model.setSaveType(saveType[i]);
				if (anrCrrTpCd[i] != null)
					model.setAnrCrrTpCd(anrCrrTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (brthYdNm[i] != null)
					model.setBrthYdNm(brthYdNm[i]);
				if (imdgCompGrpCd[i] != null)
					model.setImdgCompGrpCd(imdgCompGrpCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (dType[i] != null)
					model.setDType(dType[i]);
				if (xtdStayPrmtNo[i] != null)
					model.setXtdStayPrmtNo(xtdStayPrmtNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (eurDgDeclTpCd[i] != null)
					model.setEurDgDeclTpCd(eurDgDeclTpCd[i]);
				if (fdrVvdId[i] != null)
					model.setFdrVvdId(fdrVvdId[i]);
				if (hcdgFlg[i] != null)
					model.setHcdgFlg(hcdgFlg[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (inImdgPckCd1[i] != null)
					model.setInImdgPckCd1(inImdgPckCd1[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (netWgt[i] != null)
					model.setNetWgt(netWgt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (cstmsErrMsg[i] != null)
					model.setCstmsErrMsg(cstmsErrMsg[i]);
				if (cntrCgoSeq[i] != null)
					model.setCntrCgoSeq(cntrCgoSeq[i]);
				if (fwrdNm[i] != null)
					model.setFwrdNm(fwrdNm[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (netExploWgt[i] != null)
					model.setNetExploWgt(netExploWgt[i]);
				if (ackRcvStsCd[i] != null)
					model.setAckRcvStsCd(ackRcvStsCd[i]);
				if (emerRspnGidNo[i] != null)
					model.setEmerRspnGidNo(emerRspnGidNo[i]);
				if (hzdDesc[i] != null)
					model.setHzdDesc(hzdDesc[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				if (outImdgPckCd1[i] != null)
					model.setOutImdgPckCd1(outImdgPckCd1[i]);
				if (grsWgt[i] != null)
					model.setGrsWgt(grsWgt[i]);
				if (fdrVslNm[i] != null)
					model.setFdrVslNm(fdrVslNm[i]);
				if (imdgPckGrpCd[i] != null)
					model.setImdgPckGrpCd(imdgPckGrpCd[i]);
				if (flshPntCdoTemp[i] != null)
					model.setFlshPntCdoTemp(flshPntCdoTemp[i]);
				if (emsNo[i] != null)
					model.setEmsNo(emsNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mfagNo[i] != null)
					model.setMfagNo(mfagNo[i]);
				if (anrFwrdId[i] != null)
					model.setAnrFwrdId(anrFwrdId[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (eurOutrPckDesc[i] != null)
					model.setEurOutrPckDesc(eurOutrPckDesc[i]);
				if (dcgoMrnPolutCd[i] != null)
					model.setDcgoMrnPolutCd(dcgoMrnPolutCd[i]);
				if (eurInrPckDesc[i] != null)
					model.setEurInrPckDesc(eurInrPckDesc[i]);
				if (cellPsnNo[i] != null)
					model.setCellPsnNo(cellPsnNo[i]);
				if (fdrSvcRqstNo[i] != null)
					model.setFdrSvcRqstNo(fdrSvcRqstNo[i]);
				if (fdrVslLloydNo[i] != null)
					model.setFdrVslLloydNo(fdrVslLloydNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (anrSpclTpId[i] != null)
					model.setAnrSpclTpId(anrSpclTpId[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (inImdgPckQty1[i] != null)
					model.setInImdgPckQty1(inImdgPckQty1[i]);
				if (imdgSubsRskLblCd2[i] != null)
					model.setImdgSubsRskLblCd2(imdgSubsRskLblCd2[i]);
				if (imdgSubsRskLblCd1[i] != null)
					model.setImdgSubsRskLblCd1(imdgSubsRskLblCd1[i]);
				if (prpShpNm[i] != null)
					model.setPrpShpNm(prpShpNm[i]);
				if (imdgSubsRskLblCd4[i] != null)
					model.setImdgSubsRskLblCd4(imdgSubsRskLblCd4[i]);
				if (crrDt[i] != null)
					model.setCrrDt(crrDt[i]);
				if (imdgSubsRskLblCd3[i] != null)
					model.setImdgSubsRskLblCd3(imdgSubsRskLblCd3[i]);
				if (imdgLmtQtyFlg[i] != null)
					model.setImdgLmtQtyFlg(imdgLmtQtyFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDgInqModiVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DgInqModiVO[]
	 */
	public DgInqModiVO[] getDgInqModiVOs(){
		DgInqModiVO[] vos = (DgInqModiVO[])models.toArray(new DgInqModiVO[models.size()]);
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
		this.brthYdCd = this.brthYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszIsoCd = this.cntrTpszIsoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNoSeq = this.imdgUnNoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eurPckDesc = this.eurPckDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outImdgPckQty1 = this.outImdgPckQty1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saveType = this.saveType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anrCrrTpCd = this.anrCrrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brthYdNm = this.brthYdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgCompGrpCd = this.imdgCompGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dType = this.dType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xtdStayPrmtNo = this.xtdStayPrmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eurDgDeclTpCd = this.eurDgDeclTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrVvdId = this.fdrVvdId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcdgFlg = this.hcdgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inImdgPckCd1 = this.inImdgPckCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netWgt = this.netWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsErrMsg = this.cstmsErrMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCgoSeq = this.cntrCgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fwrdNm = this.fwrdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netExploWgt = this.netExploWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackRcvStsCd = this.ackRcvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emerRspnGidNo = this.emerRspnGidNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hzdDesc = this.hzdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outImdgPckCd1 = this.outImdgPckCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgt = this.grsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrVslNm = this.fdrVslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckGrpCd = this.imdgPckGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flshPntCdoTemp = this.flshPntCdoTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emsNo = this.emsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfagNo = this.mfagNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anrFwrdId = this.anrFwrdId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eurOutrPckDesc = this.eurOutrPckDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoMrnPolutCd = this.dcgoMrnPolutCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eurInrPckDesc = this.eurInrPckDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cellPsnNo = this.cellPsnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrSvcRqstNo = this.fdrSvcRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrVslLloydNo = this.fdrVslLloydNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anrSpclTpId = this.anrSpclTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inImdgPckQty1 = this.inImdgPckQty1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSubsRskLblCd2 = this.imdgSubsRskLblCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSubsRskLblCd1 = this.imdgSubsRskLblCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prpShpNm = this.prpShpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSubsRskLblCd4 = this.imdgSubsRskLblCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrDt = this.crrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSubsRskLblCd3 = this.imdgSubsRskLblCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgLmtQtyFlg = this.imdgLmtQtyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
