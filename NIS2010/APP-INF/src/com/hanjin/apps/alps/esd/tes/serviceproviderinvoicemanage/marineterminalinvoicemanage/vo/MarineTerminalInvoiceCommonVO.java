/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MarineTerminalInvoiceCommonVO.java
*@FileTitle : MarineTerminalInvoiceCommonVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.19
*@LastModifier : 박재흥
*@LastVersion : 1.0
* 2010.03.19 박재흥 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.vo;

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
 * @author 박재흥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MarineTerminalInvoiceCommonVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MarineTerminalInvoiceCommonVO> models = new ArrayList<MarineTerminalInvoiceCommonVO>();
	
	/* Column Info */
	private String tmpIfAmt = null;
	/* Column Info */
	private String rvisCalcCostGrpCd = null;
	/* Column Info */
	private String ediFlg = null;
	/* Column Info */
	private String tempLgsCostCd = null;
	/* Column Info */
	private String vvdType = null;
	/* Column Info */
	private String rvisCntrTpszCd = null;
	/* Column Info */
	private String revisedvolSum = null;
	/* Column Info */
	private String tmpCostCd = null;
	/* Column Info */
	private String rvisDiv = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fmTp = null;
	/* Column Info */
	private String rvisRmk = null;
	/* Column Info */
	private String rvisTmlSoRvisListSeq = null;
	/* Column Info */
	private String vvdSkdDirCd = null;
	/* Column Info */
	private String vvdSkdVoyNo2 = null;
	/* Column Info */
	private String vvdSkdVoyNo = null;
	/* Column Info */
	private String tmlSoDtlSeq = null;
	/* Column Info */
	private String rvisLgsCostCd = null;
	/* Column Info */
	private String tmpCtrtRt = null;
	/* Column Info */
	private String reverifyYn = null;
	/* Column Info */
	private String deleteMode = null;
	/* Column Info */
	private String rvisRhndRsnCd = null;
	/* Column Info */
	private String tmpInvXchRt = null;
	/* Column Info */
	private String costCalcFlg = null;
	/* Column Info */
	private String invDateType = null;
	/* Column Info */
	private String delIfSeq = null;
	/* Column Info */
	private String vvd2 = null;
	/* Column Info */
	private String rvisTmlSoDtlSeq = null;
	/* Column Info */
	private String rvisTmlSoSeq = null;
	/* Column Info */
	private String rvisTmlSoOfcCtyCd = null;
	/* Column Info */
	private String tsTp = null;
	/* Column Info */
	private String rvisLoclCreDt = null;
	/* Column Info */
	private String rvisCntrNo = null;
	/* Column Info */
	private String tmlSoSeq = null;
	/* Column Info */
	private String rvisGateInFlg = null;
	/* Column Info */
	private String rvisCreDt = null;
	/* Column Info */
	private String revisedvolMinus = null;
	/* Column Info */
	private String tmpDtlSeq = null;
	/* Column Info */
	private String allTp = null;
	/* Column Info */
	private String costCode = null;
	/* Column Info */
	private String rvisCreUsrId = null;
	/* Column Info */
	private String fileImportYn = null;
	/* Column Info */
	private String rvisIndFlg = null;
	/* Column Info */
	private String vvdVslCd = null;
	/* Column Info */
	private String cntrStyCode = null;
	/* Column Info */
	private String rvisLoclUpdDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rvisUpdDt = null;
	/* Column Info */
	private String rvisTmlInvTpCd = null;
	/* Column Info */
	private String delCntrSeq = null;
	/* Column Info */
	private String flgYn = null;
	/* Column Info */
	private String tmpCalcVolQty = null;
	/* Column Info */
	private String woNo = null;
	/* Column Info */
	private String rvisBkgNo = null;
	/* Column Info */
	private String rvisPlugIn = null;
	/* Column Info */
	private String rvisPlugOut = null;
	/* Column Info */
	private String rvisPlugTerm = null;
	/* Column Info */
	private String rvisCntrStyCd = null;
	/* Column Info */
	private String rvisVslCd = null;
	/* Column Info */
	private String tmpRvisVolQty = null;
	/* Column Info */
	private String srcOfc = null;
	/* Column Info */
	private String ioBndCd2 = null;
	/* Column Info */
	private String rvisInvGateOutDt = null;
	/* Column Info */
	private String rvisGateOutFlg = null;
	/* Column Info */
	private String rvisSkdVoyNo = null;
	/* Column Info */
	private String rvisTmlRvisTpCd = null;
	/* Column Info */
	private String rvisCuzCntrNo = null;
	/* Column Info */
	private String rvisUpdUsrId = null;
	/* Column Info */
	private String rvisTmlSoCntrListSeq = null;
	/* Column Info */
	private String rvisInvGateInDt = null;
	/* Column Info */
	private String atbDt2 = null;
	/* Column Info */
	private String rvisSkdDirCd = null;
	/* Column Info */
	private String tmlSoOfcCtyCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MarineTerminalInvoiceCommonVO() {}

	public MarineTerminalInvoiceCommonVO(String ibflag, String pagerows, String costCode, String cntrStyCode, String invDateType, String rvisDiv, String vvdType, String allTp, String fmTp, String tsTp, String woNo, String fileImportYn, String reverifyYn, String delIfSeq, String delCntrSeq, String tempLgsCostCd, String deleteMode, String ediFlg, String costCalcFlg, String tmlSoOfcCtyCd, String tmlSoSeq, String tmlSoDtlSeq, String rvisTmlSoOfcCtyCd, String rvisTmlSoSeq, String rvisTmlSoDtlSeq, String rvisTmlSoRvisListSeq, String rvisTmlInvTpCd, String rvisCalcCostGrpCd, String rvisTmlRvisTpCd, String rvisLgsCostCd, String rvisIndFlg, String rvisGateInFlg, String rvisGateOutFlg, String rvisInvGateInDt, String rvisInvGateOutDt, String rvisCntrNo, String rvisCntrTpszCd, String rvisCntrStyCd, String rvisBkgNo, String rvisPlugIn, String rvisPlugOut, String rvisPlugTerm, String rvisVslCd, String rvisSkdVoyNo, String rvisSkdDirCd, String rvisCuzCntrNo, String rvisRhndRsnCd, String rvisRmk, String rvisCreUsrId, String rvisCreDt, String rvisUpdUsrId, String rvisUpdDt, String rvisLoclCreDt, String rvisLoclUpdDt, String rvisTmlSoCntrListSeq, String flgYn, String vvdSkdVoyNo2, String vvd2, String revisedvolSum, String revisedvolMinus, String vvdVslCd, String vvdSkdVoyNo, String vvdSkdDirCd, String ioBndCd2, String atbDt2, String tmpIfAmt, String tmpCalcVolQty, String tmpRvisVolQty, String tmpCtrtRt, String tmpInvXchRt, String tmpDtlSeq, String tmpCostCd, String srcOfc) {
		this.tmpIfAmt = tmpIfAmt;
		this.rvisCalcCostGrpCd = rvisCalcCostGrpCd;
		this.ediFlg = ediFlg;
		this.tempLgsCostCd = tempLgsCostCd;
		this.vvdType = vvdType;
		this.rvisCntrTpszCd = rvisCntrTpszCd;
		this.revisedvolSum = revisedvolSum;
		this.tmpCostCd = tmpCostCd;
		this.rvisDiv = rvisDiv;
		this.pagerows = pagerows;
		this.fmTp = fmTp;
		this.rvisRmk = rvisRmk;
		this.rvisTmlSoRvisListSeq = rvisTmlSoRvisListSeq;
		this.vvdSkdDirCd = vvdSkdDirCd;
		this.vvdSkdVoyNo2 = vvdSkdVoyNo2;
		this.vvdSkdVoyNo = vvdSkdVoyNo;
		this.tmlSoDtlSeq = tmlSoDtlSeq;
		this.rvisLgsCostCd = rvisLgsCostCd;
		this.tmpCtrtRt = tmpCtrtRt;
		this.reverifyYn = reverifyYn;
		this.deleteMode = deleteMode;
		this.rvisRhndRsnCd = rvisRhndRsnCd;
		this.tmpInvXchRt = tmpInvXchRt;
		this.costCalcFlg = costCalcFlg;
		this.invDateType = invDateType;
		this.delIfSeq = delIfSeq;
		this.vvd2 = vvd2;
		this.rvisTmlSoDtlSeq = rvisTmlSoDtlSeq;
		this.rvisTmlSoSeq = rvisTmlSoSeq;
		this.rvisTmlSoOfcCtyCd = rvisTmlSoOfcCtyCd;
		this.tsTp = tsTp;
		this.rvisLoclCreDt = rvisLoclCreDt;
		this.rvisCntrNo = rvisCntrNo;
		this.tmlSoSeq = tmlSoSeq;
		this.rvisGateInFlg = rvisGateInFlg;
		this.rvisCreDt = rvisCreDt;
		this.revisedvolMinus = revisedvolMinus;
		this.tmpDtlSeq = tmpDtlSeq;
		this.allTp = allTp;
		this.costCode = costCode;
		this.rvisCreUsrId = rvisCreUsrId;
		this.fileImportYn = fileImportYn;
		this.rvisIndFlg = rvisIndFlg;
		this.vvdVslCd = vvdVslCd;
		this.cntrStyCode = cntrStyCode;
		this.rvisLoclUpdDt = rvisLoclUpdDt;
		this.ibflag = ibflag;
		this.rvisUpdDt = rvisUpdDt;
		this.rvisTmlInvTpCd = rvisTmlInvTpCd;
		this.delCntrSeq = delCntrSeq;
		this.flgYn = flgYn;
		this.tmpCalcVolQty = tmpCalcVolQty;
		this.woNo = woNo;
		this.rvisBkgNo = rvisBkgNo;
		this.rvisPlugIn = rvisPlugIn;
		this.rvisPlugOut = rvisPlugOut;
		this.rvisPlugTerm = rvisPlugTerm;
		this.rvisCntrStyCd = rvisCntrStyCd;
		this.rvisVslCd = rvisVslCd;
		this.tmpRvisVolQty = tmpRvisVolQty;
		this.srcOfc = srcOfc;
		this.ioBndCd2 = ioBndCd2;
		this.rvisInvGateOutDt = rvisInvGateOutDt;
		this.rvisGateOutFlg = rvisGateOutFlg;
		this.rvisSkdVoyNo = rvisSkdVoyNo;
		this.rvisTmlRvisTpCd = rvisTmlRvisTpCd;
		this.rvisCuzCntrNo = rvisCuzCntrNo;
		this.rvisUpdUsrId = rvisUpdUsrId;
		this.rvisTmlSoCntrListSeq = rvisTmlSoCntrListSeq;
		this.rvisInvGateInDt = rvisInvGateInDt;
		this.atbDt2 = atbDt2;
		this.rvisSkdDirCd = rvisSkdDirCd;
		this.tmlSoOfcCtyCd = tmlSoOfcCtyCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tmp_if_amt", getTmpIfAmt());
		this.hashColumns.put("rvis_calc_cost_grp_cd", getRvisCalcCostGrpCd());
		this.hashColumns.put("edi_flg", getEdiFlg());
		this.hashColumns.put("temp_lgs_cost_cd", getTempLgsCostCd());
		this.hashColumns.put("vvd_type", getVvdType());
		this.hashColumns.put("rvis_cntr_tpsz_cd", getRvisCntrTpszCd());
		this.hashColumns.put("revisedvol_sum", getRevisedvolSum());
		this.hashColumns.put("tmp_cost_cd", getTmpCostCd());
		this.hashColumns.put("rvis_div", getRvisDiv());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fm_tp", getFmTp());
		this.hashColumns.put("rvis_rmk", getRvisRmk());
		this.hashColumns.put("rvis_tml_so_rvis_list_seq", getRvisTmlSoRvisListSeq());
		this.hashColumns.put("vvd_skd_dir_cd", getVvdSkdDirCd());
		this.hashColumns.put("vvd_skd_voy_no2", getVvdSkdVoyNo2());
		this.hashColumns.put("vvd_skd_voy_no", getVvdSkdVoyNo());
		this.hashColumns.put("tml_so_dtl_seq", getTmlSoDtlSeq());
		this.hashColumns.put("rvis_lgs_cost_cd", getRvisLgsCostCd());
		this.hashColumns.put("tmp_ctrt_rt", getTmpCtrtRt());
		this.hashColumns.put("reverify_yn", getReverifyYn());
		this.hashColumns.put("delete_mode", getDeleteMode());
		this.hashColumns.put("rvis_rhnd_rsn_cd", getRvisRhndRsnCd());
		this.hashColumns.put("tmp_inv_xch_rt", getTmpInvXchRt());
		this.hashColumns.put("cost_calc_flg", getCostCalcFlg());
		this.hashColumns.put("inv_date_type", getInvDateType());
		this.hashColumns.put("del_if_seq", getDelIfSeq());
		this.hashColumns.put("vvd2", getVvd2());
		this.hashColumns.put("rvis_tml_so_dtl_seq", getRvisTmlSoDtlSeq());
		this.hashColumns.put("rvis_tml_so_seq", getRvisTmlSoSeq());
		this.hashColumns.put("rvis_tml_so_ofc_cty_cd", getRvisTmlSoOfcCtyCd());
		this.hashColumns.put("ts_tp", getTsTp());
		this.hashColumns.put("rvis_locl_cre_dt", getRvisLoclCreDt());
		this.hashColumns.put("rvis_cntr_no", getRvisCntrNo());
		this.hashColumns.put("tml_so_seq", getTmlSoSeq());
		this.hashColumns.put("rvis_gate_in_flg", getRvisGateInFlg());
		this.hashColumns.put("rvis_cre_dt", getRvisCreDt());
		this.hashColumns.put("revisedvol_minus", getRevisedvolMinus());
		this.hashColumns.put("tmp_dtl_seq", getTmpDtlSeq());
		this.hashColumns.put("all_tp", getAllTp());
		this.hashColumns.put("cost_code", getCostCode());
		this.hashColumns.put("rvis_cre_usr_id", getRvisCreUsrId());
		this.hashColumns.put("file_import_yn", getFileImportYn());
		this.hashColumns.put("rvis_ind_flg", getRvisIndFlg());
		this.hashColumns.put("vvd_vsl_cd", getVvdVslCd());
		this.hashColumns.put("cntr_sty_code", getCntrStyCode());
		this.hashColumns.put("rvis_locl_upd_dt", getRvisLoclUpdDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rvis_upd_dt", getRvisUpdDt());
		this.hashColumns.put("rvis_tml_inv_tp_cd", getRvisTmlInvTpCd());
		this.hashColumns.put("del_cntr_seq", getDelCntrSeq());
		this.hashColumns.put("flg_yn", getFlgYn());
		this.hashColumns.put("tmp_calc_vol_qty", getTmpCalcVolQty());
		this.hashColumns.put("wo_no", getWoNo());
		this.hashColumns.put("rvis_bkg_no", getRvisBkgNo());
		this.hashColumns.put("rvis_plug_in", getRvisPlugIn());
		this.hashColumns.put("rvis_plug_out", getRvisPlugOut());
		this.hashColumns.put("rvis_plug_term", getRvisPlugTerm());
		this.hashColumns.put("rvis_cntr_sty_cd", getRvisCntrStyCd());
		this.hashColumns.put("rvis_vsl_cd", getRvisVslCd());
		this.hashColumns.put("tmp_rvis_vol_qty", getTmpRvisVolQty());
		this.hashColumns.put("src_ofc", getSrcOfc());
		this.hashColumns.put("io_bnd_cd2", getIoBndCd2());
		this.hashColumns.put("rvis_inv_gate_out_dt", getRvisInvGateOutDt());
		this.hashColumns.put("rvis_gate_out_flg", getRvisGateOutFlg());
		this.hashColumns.put("rvis_skd_voy_no", getRvisSkdVoyNo());
		this.hashColumns.put("rvis_tml_rvis_tp_cd", getRvisTmlRvisTpCd());
		this.hashColumns.put("rvis_cuz_cntr_no", getRvisCuzCntrNo());
		this.hashColumns.put("rvis_upd_usr_id", getRvisUpdUsrId());
		this.hashColumns.put("rvis_tml_so_cntr_list_seq", getRvisTmlSoCntrListSeq());
		this.hashColumns.put("rvis_inv_gate_in_dt", getRvisInvGateInDt());
		this.hashColumns.put("atb_dt2", getAtbDt2());
		this.hashColumns.put("rvis_skd_dir_cd", getRvisSkdDirCd());
		this.hashColumns.put("tml_so_ofc_cty_cd", getTmlSoOfcCtyCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tmp_if_amt", "tmpIfAmt");
		this.hashFields.put("rvis_calc_cost_grp_cd", "rvisCalcCostGrpCd");
		this.hashFields.put("edi_flg", "ediFlg");
		this.hashFields.put("temp_lgs_cost_cd", "tempLgsCostCd");
		this.hashFields.put("vvd_type", "vvdType");
		this.hashFields.put("rvis_cntr_tpsz_cd", "rvisCntrTpszCd");
		this.hashFields.put("revisedvol_sum", "revisedvolSum");
		this.hashFields.put("tmp_cost_cd", "tmpCostCd");
		this.hashFields.put("rvis_div", "rvisDiv");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fm_tp", "fmTp");
		this.hashFields.put("rvis_rmk", "rvisRmk");
		this.hashFields.put("rvis_tml_so_rvis_list_seq", "rvisTmlSoRvisListSeq");
		this.hashFields.put("vvd_skd_dir_cd", "vvdSkdDirCd");
		this.hashFields.put("vvd_skd_voy_no2", "vvdSkdVoyNo2");
		this.hashFields.put("vvd_skd_voy_no", "vvdSkdVoyNo");
		this.hashFields.put("tml_so_dtl_seq", "tmlSoDtlSeq");
		this.hashFields.put("rvis_lgs_cost_cd", "rvisLgsCostCd");
		this.hashFields.put("tmp_ctrt_rt", "tmpCtrtRt");
		this.hashFields.put("reverify_yn", "reverifyYn");
		this.hashFields.put("delete_mode", "deleteMode");
		this.hashFields.put("rvis_rhnd_rsn_cd", "rvisRhndRsnCd");
		this.hashFields.put("tmp_inv_xch_rt", "tmpInvXchRt");
		this.hashFields.put("cost_calc_flg", "costCalcFlg");
		this.hashFields.put("inv_date_type", "invDateType");
		this.hashFields.put("del_if_seq", "delIfSeq");
		this.hashFields.put("vvd2", "vvd2");
		this.hashFields.put("rvis_tml_so_dtl_seq", "rvisTmlSoDtlSeq");
		this.hashFields.put("rvis_tml_so_seq", "rvisTmlSoSeq");
		this.hashFields.put("rvis_tml_so_ofc_cty_cd", "rvisTmlSoOfcCtyCd");
		this.hashFields.put("ts_tp", "tsTp");
		this.hashFields.put("rvis_locl_cre_dt", "rvisLoclCreDt");
		this.hashFields.put("rvis_cntr_no", "rvisCntrNo");
		this.hashFields.put("tml_so_seq", "tmlSoSeq");
		this.hashFields.put("rvis_gate_in_flg", "rvisGateInFlg");
		this.hashFields.put("rvis_cre_dt", "rvisCreDt");
		this.hashFields.put("revisedvol_minus", "revisedvolMinus");
		this.hashFields.put("tmp_dtl_seq", "tmpDtlSeq");
		this.hashFields.put("all_tp", "allTp");
		this.hashFields.put("cost_code", "costCode");
		this.hashFields.put("rvis_cre_usr_id", "rvisCreUsrId");
		this.hashFields.put("file_import_yn", "fileImportYn");
		this.hashFields.put("rvis_ind_flg", "rvisIndFlg");
		this.hashFields.put("vvd_vsl_cd", "vvdVslCd");
		this.hashFields.put("cntr_sty_code", "cntrStyCode");
		this.hashFields.put("rvis_locl_upd_dt", "rvisLoclUpdDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rvis_upd_dt", "rvisUpdDt");
		this.hashFields.put("rvis_tml_inv_tp_cd", "rvisTmlInvTpCd");
		this.hashFields.put("del_cntr_seq", "delCntrSeq");
		this.hashFields.put("flg_yn", "flgYn");
		this.hashFields.put("tmp_calc_vol_qty", "tmpCalcVolQty");
		this.hashFields.put("wo_no", "woNo");
		this.hashFields.put("rvis_bkg_no", "rvisBkgNo");
		this.hashFields.put("rvis_plug_in", "rvisPlugIn");
		this.hashFields.put("rvis_plug_out", "rvisPlugOut");
		this.hashFields.put("rvis_plug_term", "rvisPlugTerm");
		this.hashFields.put("rvis_cntr_sty_cd", "rvisCntrStyCd");
		this.hashFields.put("rvis_vsl_cd", "rvisVslCd");
		this.hashFields.put("tmp_rvis_vol_qty", "tmpRvisVolQty");
		this.hashFields.put("src_ofc", "srcOfc");
		this.hashFields.put("io_bnd_cd2", "ioBndCd2");
		this.hashFields.put("rvis_inv_gate_out_dt", "rvisInvGateOutDt");
		this.hashFields.put("rvis_gate_out_flg", "rvisGateOutFlg");
		this.hashFields.put("rvis_skd_voy_no", "rvisSkdVoyNo");
		this.hashFields.put("rvis_tml_rvis_tp_cd", "rvisTmlRvisTpCd");
		this.hashFields.put("rvis_cuz_cntr_no", "rvisCuzCntrNo");
		this.hashFields.put("rvis_upd_usr_id", "rvisUpdUsrId");
		this.hashFields.put("rvis_tml_so_cntr_list_seq", "rvisTmlSoCntrListSeq");
		this.hashFields.put("rvis_inv_gate_in_dt", "rvisInvGateInDt");
		this.hashFields.put("atb_dt2", "atbDt2");
		this.hashFields.put("rvis_skd_dir_cd", "rvisSkdDirCd");
		this.hashFields.put("tml_so_ofc_cty_cd", "tmlSoOfcCtyCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return tmpIfAmt
	 */
	public String getTmpIfAmt() {
		return this.tmpIfAmt;
	}
	
	/**
	 * Column Info
	 * @return rvisCalcCostGrpCd
	 */
	public String getRvisCalcCostGrpCd() {
		return this.rvisCalcCostGrpCd;
	}
	
	/**
	 * Column Info
	 * @return ediFlg
	 */
	public String getEdiFlg() {
		return this.ediFlg;
	}
	
	/**
	 * Column Info
	 * @return tempLgsCostCd
	 */
	public String getTempLgsCostCd() {
		return this.tempLgsCostCd;
	}
	
	/**
	 * Column Info
	 * @return vvdType
	 */
	public String getVvdType() {
		return this.vvdType;
	}
	
	/**
	 * Column Info
	 * @return rvisCntrTpszCd
	 */
	public String getRvisCntrTpszCd() {
		return this.rvisCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return revisedvolSum
	 */
	public String getRevisedvolSum() {
		return this.revisedvolSum;
	}
	
	/**
	 * Column Info
	 * @return tmpCostCd
	 */
	public String getTmpCostCd() {
		return this.tmpCostCd;
	}
	
	/**
	 * Column Info
	 * @return rvisDiv
	 */
	public String getRvisDiv() {
		return this.rvisDiv;
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
	 * @return fmTp
	 */
	public String getFmTp() {
		return this.fmTp;
	}
	
	/**
	 * Column Info
	 * @return rvisRmk
	 */
	public String getRvisRmk() {
		return this.rvisRmk;
	}
	
	/**
	 * Column Info
	 * @return rvisTmlSoRvisListSeq
	 */
	public String getRvisTmlSoRvisListSeq() {
		return this.rvisTmlSoRvisListSeq;
	}
	
	/**
	 * Column Info
	 * @return vvdSkdDirCd
	 */
	public String getVvdSkdDirCd() {
		return this.vvdSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return vvdSkdVoyNo2
	 */
	public String getVvdSkdVoyNo2() {
		return this.vvdSkdVoyNo2;
	}
	
	/**
	 * Column Info
	 * @return vvdSkdVoyNo
	 */
	public String getVvdSkdVoyNo() {
		return this.vvdSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return tmlSoDtlSeq
	 */
	public String getTmlSoDtlSeq() {
		return this.tmlSoDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return rvisLgsCostCd
	 */
	public String getRvisLgsCostCd() {
		return this.rvisLgsCostCd;
	}
	
	/**
	 * Column Info
	 * @return tmpCtrtRt
	 */
	public String getTmpCtrtRt() {
		return this.tmpCtrtRt;
	}
	
	/**
	 * Column Info
	 * @return reverifyYn
	 */
	public String getReverifyYn() {
		return this.reverifyYn;
	}
	
	/**
	 * Column Info
	 * @return deleteMode
	 */
	public String getDeleteMode() {
		return this.deleteMode;
	}
	
	/**
	 * Column Info
	 * @return rvisRhndRsnCd
	 */
	public String getRvisRhndRsnCd() {
		return this.rvisRhndRsnCd;
	}
	
	/**
	 * Column Info
	 * @return tmpInvXchRt
	 */
	public String getTmpInvXchRt() {
		return this.tmpInvXchRt;
	}
	
	/**
	 * Column Info
	 * @return costCalcFlg
	 */
	public String getCostCalcFlg() {
		return this.costCalcFlg;
	}
	
	/**
	 * Column Info
	 * @return invDateType
	 */
	public String getInvDateType() {
		return this.invDateType;
	}
	
	/**
	 * Column Info
	 * @return delIfSeq
	 */
	public String getDelIfSeq() {
		return this.delIfSeq;
	}
	
	/**
	 * Column Info
	 * @return vvd2
	 */
	public String getVvd2() {
		return this.vvd2;
	}
	
	/**
	 * Column Info
	 * @return rvisTmlSoDtlSeq
	 */
	public String getRvisTmlSoDtlSeq() {
		return this.rvisTmlSoDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return rvisTmlSoSeq
	 */
	public String getRvisTmlSoSeq() {
		return this.rvisTmlSoSeq;
	}
	
	/**
	 * Column Info
	 * @return rvisTmlSoOfcCtyCd
	 */
	public String getRvisTmlSoOfcCtyCd() {
		return this.rvisTmlSoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return tsTp
	 */
	public String getTsTp() {
		return this.tsTp;
	}
	
	/**
	 * Column Info
	 * @return rvisLoclCreDt
	 */
	public String getRvisLoclCreDt() {
		return this.rvisLoclCreDt;
	}
	
	/**
	 * Column Info
	 * @return rvisCntrNo
	 */
	public String getRvisCntrNo() {
		return this.rvisCntrNo;
	}
	
	/**
	 * Column Info
	 * @return tmlSoSeq
	 */
	public String getTmlSoSeq() {
		return this.tmlSoSeq;
	}
	
	/**
	 * Column Info
	 * @return rvisGateInFlg
	 */
	public String getRvisGateInFlg() {
		return this.rvisGateInFlg;
	}
	
	/**
	 * Column Info
	 * @return rvisCreDt
	 */
	public String getRvisCreDt() {
		return this.rvisCreDt;
	}
	
	/**
	 * Column Info
	 * @return revisedvolMinus
	 */
	public String getRevisedvolMinus() {
		return this.revisedvolMinus;
	}
	
	/**
	 * Column Info
	 * @return tmpDtlSeq
	 */
	public String getTmpDtlSeq() {
		return this.tmpDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return allTp
	 */
	public String getAllTp() {
		return this.allTp;
	}
	
	/**
	 * Column Info
	 * @return costCode
	 */
	public String getCostCode() {
		return this.costCode;
	}
	
	/**
	 * Column Info
	 * @return rvisCreUsrId
	 */
	public String getRvisCreUsrId() {
		return this.rvisCreUsrId;
	}
	
	/**
	 * Column Info
	 * @return fileImportYn
	 */
	public String getFileImportYn() {
		return this.fileImportYn;
	}
	
	/**
	 * Column Info
	 * @return rvisIndFlg
	 */
	public String getRvisIndFlg() {
		return this.rvisIndFlg;
	}
	
	/**
	 * Column Info
	 * @return vvdVslCd
	 */
	public String getVvdVslCd() {
		return this.vvdVslCd;
	}
	
	/**
	 * Column Info
	 * @return cntrStyCode
	 */
	public String getCntrStyCode() {
		return this.cntrStyCode;
	}
	
	/**
	 * Column Info
	 * @return rvisLoclUpdDt
	 */
	public String getRvisLoclUpdDt() {
		return this.rvisLoclUpdDt;
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
	 * @return rvisUpdDt
	 */
	public String getRvisUpdDt() {
		return this.rvisUpdDt;
	}
	
	/**
	 * Column Info
	 * @return rvisTmlInvTpCd
	 */
	public String getRvisTmlInvTpCd() {
		return this.rvisTmlInvTpCd;
	}
	
	/**
	 * Column Info
	 * @return delCntrSeq
	 */
	public String getDelCntrSeq() {
		return this.delCntrSeq;
	}
	
	/**
	 * Column Info
	 * @return flgYn
	 */
	public String getFlgYn() {
		return this.flgYn;
	}
	
	/**
	 * Column Info
	 * @return tmpCalcVolQty
	 */
	public String getTmpCalcVolQty() {
		return this.tmpCalcVolQty;
	}
	
	/**
	 * Column Info
	 * @return woNo
	 */
	public String getWoNo() {
		return this.woNo;
	}
	
	/**
	 * Column Info
	 * @return rvisBkgNo
	 */
	public String getRvisBkgNo() {
		return this.rvisBkgNo;
	}
	
	/**
	 * Column Info
	 * @return rvisPlugIn
	 */
	public String getRvisPlugIn() {
		return this.rvisPlugIn;
	}

	/**
	 * Column Info
	 * @return rvisPlugOut
	 */
	public String getRvisPlugOut() {
		return this.rvisPlugOut;
	}

	/**
	 * Column Info
	 * @return rvisPlugTerm
	 */
	public String getRvisPlugTerm() {
		return this.rvisPlugTerm;
	}
	
	/**
	 * Column Info
	 * @return rvisCntrStyCd
	 */
	public String getRvisCntrStyCd() {
		return this.rvisCntrStyCd;
	}
	
	/**
	 * Column Info
	 * @return rvisVslCd
	 */
	public String getRvisVslCd() {
		return this.rvisVslCd;
	}
	
	/**
	 * Column Info
	 * @return tmpRvisVolQty
	 */
	public String getTmpRvisVolQty() {
		return this.tmpRvisVolQty;
	}
	
	/**
	 * Column Info
	 * @return srcOfc
	 */
	public String getSrcOfc() {
		return this.srcOfc;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd2
	 */
	public String getIoBndCd2() {
		return this.ioBndCd2;
	}
	
	/**
	 * Column Info
	 * @return rvisInvGateOutDt
	 */
	public String getRvisInvGateOutDt() {
		return this.rvisInvGateOutDt;
	}
	
	/**
	 * Column Info
	 * @return rvisGateOutFlg
	 */
	public String getRvisGateOutFlg() {
		return this.rvisGateOutFlg;
	}
	
	/**
	 * Column Info
	 * @return rvisSkdVoyNo
	 */
	public String getRvisSkdVoyNo() {
		return this.rvisSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return rvisTmlRvisTpCd
	 */
	public String getRvisTmlRvisTpCd() {
		return this.rvisTmlRvisTpCd;
	}
	
	/**
	 * Column Info
	 * @return rvisCuzCntrNo
	 */
	public String getRvisCuzCntrNo() {
		return this.rvisCuzCntrNo;
	}
	
	/**
	 * Column Info
	 * @return rvisUpdUsrId
	 */
	public String getRvisUpdUsrId() {
		return this.rvisUpdUsrId;
	}
	
	/**
	 * Column Info
	 * @return rvisTmlSoCntrListSeq
	 */
	public String getRvisTmlSoCntrListSeq() {
		return this.rvisTmlSoCntrListSeq;
	}
	
	/**
	 * Column Info
	 * @return rvisInvGateInDt
	 */
	public String getRvisInvGateInDt() {
		return this.rvisInvGateInDt;
	}
	
	/**
	 * Column Info
	 * @return atbDt2
	 */
	public String getAtbDt2() {
		return this.atbDt2;
	}
	
	/**
	 * Column Info
	 * @return rvisSkdDirCd
	 */
	public String getRvisSkdDirCd() {
		return this.rvisSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return tmlSoOfcCtyCd
	 */
	public String getTmlSoOfcCtyCd() {
		return this.tmlSoOfcCtyCd;
	}
	

	/**
	 * Column Info
	 * @param tmpIfAmt
	 */
	public void setTmpIfAmt(String tmpIfAmt) {
		this.tmpIfAmt = tmpIfAmt;
	}
	
	/**
	 * Column Info
	 * @param rvisCalcCostGrpCd
	 */
	public void setRvisCalcCostGrpCd(String rvisCalcCostGrpCd) {
		this.rvisCalcCostGrpCd = rvisCalcCostGrpCd;
	}
	
	/**
	 * Column Info
	 * @param ediFlg
	 */
	public void setEdiFlg(String ediFlg) {
		this.ediFlg = ediFlg;
	}
	
	/**
	 * Column Info
	 * @param tempLgsCostCd
	 */
	public void setTempLgsCostCd(String tempLgsCostCd) {
		this.tempLgsCostCd = tempLgsCostCd;
	}
	
	/**
	 * Column Info
	 * @param vvdType
	 */
	public void setVvdType(String vvdType) {
		this.vvdType = vvdType;
	}
	
	/**
	 * Column Info
	 * @param rvisCntrTpszCd
	 */
	public void setRvisCntrTpszCd(String rvisCntrTpszCd) {
		this.rvisCntrTpszCd = rvisCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param revisedvolSum
	 */
	public void setRevisedvolSum(String revisedvolSum) {
		this.revisedvolSum = revisedvolSum;
	}
	
	/**
	 * Column Info
	 * @param tmpCostCd
	 */
	public void setTmpCostCd(String tmpCostCd) {
		this.tmpCostCd = tmpCostCd;
	}
	
	/**
	 * Column Info
	 * @param rvisDiv
	 */
	public void setRvisDiv(String rvisDiv) {
		this.rvisDiv = rvisDiv;
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
	 * @param fmTp
	 */
	public void setFmTp(String fmTp) {
		this.fmTp = fmTp;
	}
	
	/**
	 * Column Info
	 * @param rvisRmk
	 */
	public void setRvisRmk(String rvisRmk) {
		this.rvisRmk = rvisRmk;
	}
	
	/**
	 * Column Info
	 * @param rvisTmlSoRvisListSeq
	 */
	public void setRvisTmlSoRvisListSeq(String rvisTmlSoRvisListSeq) {
		this.rvisTmlSoRvisListSeq = rvisTmlSoRvisListSeq;
	}
	
	/**
	 * Column Info
	 * @param vvdSkdDirCd
	 */
	public void setVvdSkdDirCd(String vvdSkdDirCd) {
		this.vvdSkdDirCd = vvdSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param vvdSkdVoyNo2
	 */
	public void setVvdSkdVoyNo2(String vvdSkdVoyNo2) {
		this.vvdSkdVoyNo2 = vvdSkdVoyNo2;
	}
	
	/**
	 * Column Info
	 * @param vvdSkdVoyNo
	 */
	public void setVvdSkdVoyNo(String vvdSkdVoyNo) {
		this.vvdSkdVoyNo = vvdSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param tmlSoDtlSeq
	 */
	public void setTmlSoDtlSeq(String tmlSoDtlSeq) {
		this.tmlSoDtlSeq = tmlSoDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param rvisLgsCostCd
	 */
	public void setRvisLgsCostCd(String rvisLgsCostCd) {
		this.rvisLgsCostCd = rvisLgsCostCd;
	}
	
	/**
	 * Column Info
	 * @param tmpCtrtRt
	 */
	public void setTmpCtrtRt(String tmpCtrtRt) {
		this.tmpCtrtRt = tmpCtrtRt;
	}
	
	/**
	 * Column Info
	 * @param reverifyYn
	 */
	public void setReverifyYn(String reverifyYn) {
		this.reverifyYn = reverifyYn;
	}
	
	/**
	 * Column Info
	 * @param deleteMode
	 */
	public void setDeleteMode(String deleteMode) {
		this.deleteMode = deleteMode;
	}
	
	/**
	 * Column Info
	 * @param rvisRhndRsnCd
	 */
	public void setRvisRhndRsnCd(String rvisRhndRsnCd) {
		this.rvisRhndRsnCd = rvisRhndRsnCd;
	}
	
	/**
	 * Column Info
	 * @param tmpInvXchRt
	 */
	public void setTmpInvXchRt(String tmpInvXchRt) {
		this.tmpInvXchRt = tmpInvXchRt;
	}
	
	/**
	 * Column Info
	 * @param costCalcFlg
	 */
	public void setCostCalcFlg(String costCalcFlg) {
		this.costCalcFlg = costCalcFlg;
	}
	
	/**
	 * Column Info
	 * @param invDateType
	 */
	public void setInvDateType(String invDateType) {
		this.invDateType = invDateType;
	}
	
	/**
	 * Column Info
	 * @param delIfSeq
	 */
	public void setDelIfSeq(String delIfSeq) {
		this.delIfSeq = delIfSeq;
	}
	
	/**
	 * Column Info
	 * @param vvd2
	 */
	public void setVvd2(String vvd2) {
		this.vvd2 = vvd2;
	}
	
	/**
	 * Column Info
	 * @param rvisTmlSoDtlSeq
	 */
	public void setRvisTmlSoDtlSeq(String rvisTmlSoDtlSeq) {
		this.rvisTmlSoDtlSeq = rvisTmlSoDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param rvisTmlSoSeq
	 */
	public void setRvisTmlSoSeq(String rvisTmlSoSeq) {
		this.rvisTmlSoSeq = rvisTmlSoSeq;
	}
	
	/**
	 * Column Info
	 * @param rvisTmlSoOfcCtyCd
	 */
	public void setRvisTmlSoOfcCtyCd(String rvisTmlSoOfcCtyCd) {
		this.rvisTmlSoOfcCtyCd = rvisTmlSoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param tsTp
	 */
	public void setTsTp(String tsTp) {
		this.tsTp = tsTp;
	}
	
	/**
	 * Column Info
	 * @param rvisLoclCreDt
	 */
	public void setRvisLoclCreDt(String rvisLoclCreDt) {
		this.rvisLoclCreDt = rvisLoclCreDt;
	}
	
	/**
	 * Column Info
	 * @param rvisCntrNo
	 */
	public void setRvisCntrNo(String rvisCntrNo) {
		this.rvisCntrNo = rvisCntrNo;
	}
	
	/**
	 * Column Info
	 * @param tmlSoSeq
	 */
	public void setTmlSoSeq(String tmlSoSeq) {
		this.tmlSoSeq = tmlSoSeq;
	}
	
	/**
	 * Column Info
	 * @param rvisGateInFlg
	 */
	public void setRvisGateInFlg(String rvisGateInFlg) {
		this.rvisGateInFlg = rvisGateInFlg;
	}
	
	/**
	 * Column Info
	 * @param rvisCreDt
	 */
	public void setRvisCreDt(String rvisCreDt) {
		this.rvisCreDt = rvisCreDt;
	}
	
	/**
	 * Column Info
	 * @param revisedvolMinus
	 */
	public void setRevisedvolMinus(String revisedvolMinus) {
		this.revisedvolMinus = revisedvolMinus;
	}
	
	/**
	 * Column Info
	 * @param tmpDtlSeq
	 */
	public void setTmpDtlSeq(String tmpDtlSeq) {
		this.tmpDtlSeq = tmpDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param allTp
	 */
	public void setAllTp(String allTp) {
		this.allTp = allTp;
	}
	
	/**
	 * Column Info
	 * @param costCode
	 */
	public void setCostCode(String costCode) {
		this.costCode = costCode;
	}
	
	/**
	 * Column Info
	 * @param rvisCreUsrId
	 */
	public void setRvisCreUsrId(String rvisCreUsrId) {
		this.rvisCreUsrId = rvisCreUsrId;
	}
	
	/**
	 * Column Info
	 * @param fileImportYn
	 */
	public void setFileImportYn(String fileImportYn) {
		this.fileImportYn = fileImportYn;
	}
	
	/**
	 * Column Info
	 * @param rvisIndFlg
	 */
	public void setRvisIndFlg(String rvisIndFlg) {
		this.rvisIndFlg = rvisIndFlg;
	}
	
	/**
	 * Column Info
	 * @param vvdVslCd
	 */
	public void setVvdVslCd(String vvdVslCd) {
		this.vvdVslCd = vvdVslCd;
	}
	
	/**
	 * Column Info
	 * @param cntrStyCode
	 */
	public void setCntrStyCode(String cntrStyCode) {
		this.cntrStyCode = cntrStyCode;
	}
	
	/**
	 * Column Info
	 * @param rvisLoclUpdDt
	 */
	public void setRvisLoclUpdDt(String rvisLoclUpdDt) {
		this.rvisLoclUpdDt = rvisLoclUpdDt;
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
	 * @param rvisUpdDt
	 */
	public void setRvisUpdDt(String rvisUpdDt) {
		this.rvisUpdDt = rvisUpdDt;
	}
	
	/**
	 * Column Info
	 * @param rvisTmlInvTpCd
	 */
	public void setRvisTmlInvTpCd(String rvisTmlInvTpCd) {
		this.rvisTmlInvTpCd = rvisTmlInvTpCd;
	}
	
	/**
	 * Column Info
	 * @param delCntrSeq
	 */
	public void setDelCntrSeq(String delCntrSeq) {
		this.delCntrSeq = delCntrSeq;
	}
	
	/**
	 * Column Info
	 * @param flgYn
	 */
	public void setFlgYn(String flgYn) {
		this.flgYn = flgYn;
	}
	
	/**
	 * Column Info
	 * @param tmpCalcVolQty
	 */
	public void setTmpCalcVolQty(String tmpCalcVolQty) {
		this.tmpCalcVolQty = tmpCalcVolQty;
	}
	
	/**
	 * Column Info
	 * @param woNo
	 */
	public void setWoNo(String woNo) {
		this.woNo = woNo;
	}
	
	/**
	 * Column Info
	 * @param rvisBkgNo
	 */
	public void setRvisBkgNo(String rvisBkgNo) {
		this.rvisBkgNo = rvisBkgNo;
	}
	
	/**
	 * Column Info
	 * @param rvisPlugIn
	 */
	public void setRvisPlugIn(String rvisPlugIn) {
		this.rvisPlugIn = rvisPlugIn;
	}
	
	/**
	 * Column Info
	 * @param rvisPlugOut
	 */
	public void setRvisPlugOut(String rvisPlugOut) {
		this.rvisPlugOut = rvisPlugOut;
	}
	
	/**
	 * Column Info
	 * @param rvisPlugTerm
	 */
	public void setRvisPlugTerm(String rvisPlugTerm) {
		this.rvisPlugTerm = rvisPlugTerm;
	}
	
	/**
	 * Column Info
	 * @param rvisCntrStyCd
	 */
	public void setRvisCntrStyCd(String rvisCntrStyCd) {
		this.rvisCntrStyCd = rvisCntrStyCd;
	}
	
	/**
	 * Column Info
	 * @param rvisVslCd
	 */
	public void setRvisVslCd(String rvisVslCd) {
		this.rvisVslCd = rvisVslCd;
	}
	
	/**
	 * Column Info
	 * @param tmpRvisVolQty
	 */
	public void setTmpRvisVolQty(String tmpRvisVolQty) {
		this.tmpRvisVolQty = tmpRvisVolQty;
	}
	
	/**
	 * Column Info
	 * @param srcOfc
	 */
	public void setSrcOfc(String srcOfc) {
		this.srcOfc = srcOfc;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd2
	 */
	public void setIoBndCd2(String ioBndCd2) {
		this.ioBndCd2 = ioBndCd2;
	}
	
	/**
	 * Column Info
	 * @param rvisInvGateOutDt
	 */
	public void setRvisInvGateOutDt(String rvisInvGateOutDt) {
		this.rvisInvGateOutDt = rvisInvGateOutDt;
	}
	
	/**
	 * Column Info
	 * @param rvisGateOutFlg
	 */
	public void setRvisGateOutFlg(String rvisGateOutFlg) {
		this.rvisGateOutFlg = rvisGateOutFlg;
	}
	
	/**
	 * Column Info
	 * @param rvisSkdVoyNo
	 */
	public void setRvisSkdVoyNo(String rvisSkdVoyNo) {
		this.rvisSkdVoyNo = rvisSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param rvisTmlRvisTpCd
	 */
	public void setRvisTmlRvisTpCd(String rvisTmlRvisTpCd) {
		this.rvisTmlRvisTpCd = rvisTmlRvisTpCd;
	}
	
	/**
	 * Column Info
	 * @param rvisCuzCntrNo
	 */
	public void setRvisCuzCntrNo(String rvisCuzCntrNo) {
		this.rvisCuzCntrNo = rvisCuzCntrNo;
	}
	
	/**
	 * Column Info
	 * @param rvisUpdUsrId
	 */
	public void setRvisUpdUsrId(String rvisUpdUsrId) {
		this.rvisUpdUsrId = rvisUpdUsrId;
	}
	
	/**
	 * Column Info
	 * @param rvisTmlSoCntrListSeq
	 */
	public void setRvisTmlSoCntrListSeq(String rvisTmlSoCntrListSeq) {
		this.rvisTmlSoCntrListSeq = rvisTmlSoCntrListSeq;
	}
	
	/**
	 * Column Info
	 * @param rvisInvGateInDt
	 */
	public void setRvisInvGateInDt(String rvisInvGateInDt) {
		this.rvisInvGateInDt = rvisInvGateInDt;
	}
	
	/**
	 * Column Info
	 * @param atbDt2
	 */
	public void setAtbDt2(String atbDt2) {
		this.atbDt2 = atbDt2;
	}
	
	/**
	 * Column Info
	 * @param rvisSkdDirCd
	 */
	public void setRvisSkdDirCd(String rvisSkdDirCd) {
		this.rvisSkdDirCd = rvisSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param tmlSoOfcCtyCd
	 */
	public void setTmlSoOfcCtyCd(String tmlSoOfcCtyCd) {
		this.tmlSoOfcCtyCd = tmlSoOfcCtyCd;
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
		setTmpIfAmt(JSPUtil.getParameter(request, prefix + "tmp_if_amt", ""));
		setRvisCalcCostGrpCd(JSPUtil.getParameter(request, prefix + "rvis_calc_cost_grp_cd", ""));
		setEdiFlg(JSPUtil.getParameter(request, prefix + "edi_flg", ""));
		setTempLgsCostCd(JSPUtil.getParameter(request, prefix + "temp_lgs_cost_cd", ""));
		setVvdType(JSPUtil.getParameter(request, prefix + "vvd_type", ""));
		setRvisCntrTpszCd(JSPUtil.getParameter(request, prefix + "rvis_cntr_tpsz_cd", ""));
		setRevisedvolSum(JSPUtil.getParameter(request, prefix + "revisedvol_sum", ""));
		setTmpCostCd(JSPUtil.getParameter(request, prefix + "tmp_cost_cd", ""));
		setRvisDiv(JSPUtil.getParameter(request, prefix + "rvis_div", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFmTp(JSPUtil.getParameter(request, prefix + "fm_tp", ""));
		setRvisRmk(JSPUtil.getParameter(request, prefix + "rvis_rmk", ""));
		setRvisTmlSoRvisListSeq(JSPUtil.getParameter(request, prefix + "rvis_tml_so_rvis_list_seq", ""));
		setVvdSkdDirCd(JSPUtil.getParameter(request, prefix + "vvd_skd_dir_cd", ""));
		setVvdSkdVoyNo2(JSPUtil.getParameter(request, prefix + "vvd_skd_voy_no2", ""));
		setVvdSkdVoyNo(JSPUtil.getParameter(request, prefix + "vvd_skd_voy_no", ""));
		setTmlSoDtlSeq(JSPUtil.getParameter(request, prefix + "tml_so_dtl_seq", ""));
		setRvisLgsCostCd(JSPUtil.getParameter(request, prefix + "rvis_lgs_cost_cd", ""));
		setTmpCtrtRt(JSPUtil.getParameter(request, prefix + "tmp_ctrt_rt", ""));
		setReverifyYn(JSPUtil.getParameter(request, prefix + "reverify_yn", ""));
		setDeleteMode(JSPUtil.getParameter(request, prefix + "delete_mode", ""));
		setRvisRhndRsnCd(JSPUtil.getParameter(request, prefix + "rvis_rhnd_rsn_cd", ""));
		setTmpInvXchRt(JSPUtil.getParameter(request, prefix + "tmp_inv_xch_rt", ""));
		setCostCalcFlg(JSPUtil.getParameter(request, prefix + "cost_calc_flg", ""));
		setInvDateType(JSPUtil.getParameter(request, prefix + "inv_date_type", ""));
		setDelIfSeq(JSPUtil.getParameter(request, prefix + "del_if_seq", ""));
		setVvd2(JSPUtil.getParameter(request, prefix + "vvd2", ""));
		setRvisTmlSoDtlSeq(JSPUtil.getParameter(request, prefix + "rvis_tml_so_dtl_seq", ""));
		setRvisTmlSoSeq(JSPUtil.getParameter(request, prefix + "rvis_tml_so_seq", ""));
		setRvisTmlSoOfcCtyCd(JSPUtil.getParameter(request, prefix + "rvis_tml_so_ofc_cty_cd", ""));
		setTsTp(JSPUtil.getParameter(request, prefix + "ts_tp", ""));
		setRvisLoclCreDt(JSPUtil.getParameter(request, prefix + "rvis_locl_cre_dt", ""));
		setRvisCntrNo(JSPUtil.getParameter(request, prefix + "rvis_cntr_no", ""));
		setTmlSoSeq(JSPUtil.getParameter(request, prefix + "tml_so_seq", ""));
		setRvisGateInFlg(JSPUtil.getParameter(request, prefix + "rvis_gate_in_flg", ""));
		setRvisCreDt(JSPUtil.getParameter(request, prefix + "rvis_cre_dt", ""));
		setRevisedvolMinus(JSPUtil.getParameter(request, prefix + "revisedvol_minus", ""));
		setTmpDtlSeq(JSPUtil.getParameter(request, prefix + "tmp_dtl_seq", ""));
		setAllTp(JSPUtil.getParameter(request, prefix + "all_tp", ""));
		setCostCode(JSPUtil.getParameter(request, prefix + "cost_code", ""));
		setRvisCreUsrId(JSPUtil.getParameter(request, prefix + "rvis_cre_usr_id", ""));
		setFileImportYn(JSPUtil.getParameter(request, prefix + "file_import_yn", ""));
		setRvisIndFlg(JSPUtil.getParameter(request, prefix + "rvis_ind_flg", ""));
		setVvdVslCd(JSPUtil.getParameter(request, prefix + "vvd_vsl_cd", ""));
		setCntrStyCode(JSPUtil.getParameter(request, prefix + "cntr_sty_code", ""));
		setRvisLoclUpdDt(JSPUtil.getParameter(request, prefix + "rvis_locl_upd_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRvisUpdDt(JSPUtil.getParameter(request, prefix + "rvis_upd_dt", ""));
		setRvisTmlInvTpCd(JSPUtil.getParameter(request, prefix + "rvis_tml_inv_tp_cd", ""));
		setDelCntrSeq(JSPUtil.getParameter(request, prefix + "del_cntr_seq", ""));
		setFlgYn(JSPUtil.getParameter(request, prefix + "flg_yn", ""));
		setTmpCalcVolQty(JSPUtil.getParameter(request, prefix + "tmp_calc_vol_qty", ""));
		setWoNo(JSPUtil.getParameter(request, prefix + "wo_no", ""));
		setRvisBkgNo(JSPUtil.getParameter(request, prefix + "rvis_bkg_no", ""));
		setRvisPlugIn(JSPUtil.getParameter(request, prefix + "rvis_plug_in", ""));
		setRvisPlugOut(JSPUtil.getParameter(request, prefix + "rvis_plug_out", ""));
		setRvisPlugTerm(JSPUtil.getParameter(request, prefix + "rvis_plug_term", ""));
		setRvisCntrStyCd(JSPUtil.getParameter(request, prefix + "rvis_cntr_sty_cd", ""));
		setRvisVslCd(JSPUtil.getParameter(request, prefix + "rvis_vsl_cd", ""));
		setTmpRvisVolQty(JSPUtil.getParameter(request, prefix + "tmp_rvis_vol_qty", ""));
		setSrcOfc(JSPUtil.getParameter(request, prefix + "src_ofc", ""));
		setIoBndCd2(JSPUtil.getParameter(request, prefix + "io_bnd_cd2", ""));
		setRvisInvGateOutDt(JSPUtil.getParameter(request, prefix + "rvis_inv_gate_out_dt", ""));
		setRvisGateOutFlg(JSPUtil.getParameter(request, prefix + "rvis_gate_out_flg", ""));
		setRvisSkdVoyNo(JSPUtil.getParameter(request, prefix + "rvis_skd_voy_no", ""));
		setRvisTmlRvisTpCd(JSPUtil.getParameter(request, prefix + "rvis_tml_rvis_tp_cd", ""));
		setRvisCuzCntrNo(JSPUtil.getParameter(request, prefix + "rvis_cuz_cntr_no", ""));
		setRvisUpdUsrId(JSPUtil.getParameter(request, prefix + "rvis_upd_usr_id", ""));
		setRvisTmlSoCntrListSeq(JSPUtil.getParameter(request, prefix + "rvis_tml_so_cntr_list_seq", ""));
		setRvisInvGateInDt(JSPUtil.getParameter(request, prefix + "rvis_inv_gate_in_dt", ""));
		setAtbDt2(JSPUtil.getParameter(request, prefix + "atb_dt2", ""));
		setRvisSkdDirCd(JSPUtil.getParameter(request, prefix + "rvis_skd_dir_cd", ""));
		setTmlSoOfcCtyCd(JSPUtil.getParameter(request, prefix + "tml_so_ofc_cty_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MarineTerminalInvoiceCommonVO[]
	 */
	public MarineTerminalInvoiceCommonVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MarineTerminalInvoiceCommonVO[]
	 */
	public MarineTerminalInvoiceCommonVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MarineTerminalInvoiceCommonVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] tmpIfAmt = (JSPUtil.getParameter(request, prefix	+ "tmp_if_amt", length));
			String[] rvisCalcCostGrpCd = (JSPUtil.getParameter(request, prefix	+ "rvis_calc_cost_grp_cd", length));
			String[] ediFlg = (JSPUtil.getParameter(request, prefix	+ "edi_flg", length));
			String[] tempLgsCostCd = (JSPUtil.getParameter(request, prefix	+ "temp_lgs_cost_cd", length));
			String[] vvdType = (JSPUtil.getParameter(request, prefix	+ "vvd_type", length));
			String[] rvisCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "rvis_cntr_tpsz_cd", length));
			String[] revisedvolSum = (JSPUtil.getParameter(request, prefix	+ "revisedvol_sum", length));
			String[] tmpCostCd = (JSPUtil.getParameter(request, prefix	+ "tmp_cost_cd", length));
			String[] rvisDiv = (JSPUtil.getParameter(request, prefix	+ "rvis_div", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fmTp = (JSPUtil.getParameter(request, prefix	+ "fm_tp", length));
			String[] rvisRmk = (JSPUtil.getParameter(request, prefix	+ "rvis_rmk", length));
			String[] rvisTmlSoRvisListSeq = (JSPUtil.getParameter(request, prefix	+ "rvis_tml_so_rvis_list_seq", length));
			String[] vvdSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "vvd_skd_dir_cd", length));
			String[] vvdSkdVoyNo2 = (JSPUtil.getParameter(request, prefix	+ "vvd_skd_voy_no2", length));
			String[] vvdSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "vvd_skd_voy_no", length));
			String[] tmlSoDtlSeq = (JSPUtil.getParameter(request, prefix	+ "tml_so_dtl_seq", length));
			String[] rvisLgsCostCd = (JSPUtil.getParameter(request, prefix	+ "rvis_lgs_cost_cd", length));
			String[] tmpCtrtRt = (JSPUtil.getParameter(request, prefix	+ "tmp_ctrt_rt", length));
			String[] reverifyYn = (JSPUtil.getParameter(request, prefix	+ "reverify_yn", length));
			String[] deleteMode = (JSPUtil.getParameter(request, prefix	+ "delete_mode", length));
			String[] rvisRhndRsnCd = (JSPUtil.getParameter(request, prefix	+ "rvis_rhnd_rsn_cd", length));
			String[] tmpInvXchRt = (JSPUtil.getParameter(request, prefix	+ "tmp_inv_xch_rt", length));
			String[] costCalcFlg = (JSPUtil.getParameter(request, prefix	+ "cost_calc_flg", length));
			String[] invDateType = (JSPUtil.getParameter(request, prefix	+ "inv_date_type", length));
			String[] delIfSeq = (JSPUtil.getParameter(request, prefix	+ "del_if_seq", length));
			String[] vvd2 = (JSPUtil.getParameter(request, prefix	+ "vvd2", length));
			String[] rvisTmlSoDtlSeq = (JSPUtil.getParameter(request, prefix	+ "rvis_tml_so_dtl_seq", length));
			String[] rvisTmlSoSeq = (JSPUtil.getParameter(request, prefix	+ "rvis_tml_so_seq", length));
			String[] rvisTmlSoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "rvis_tml_so_ofc_cty_cd", length));
			String[] tsTp = (JSPUtil.getParameter(request, prefix	+ "ts_tp", length));
			String[] rvisLoclCreDt = (JSPUtil.getParameter(request, prefix	+ "rvis_locl_cre_dt", length));
			String[] rvisCntrNo = (JSPUtil.getParameter(request, prefix	+ "rvis_cntr_no", length));
			String[] tmlSoSeq = (JSPUtil.getParameter(request, prefix	+ "tml_so_seq", length));
			String[] rvisGateInFlg = (JSPUtil.getParameter(request, prefix	+ "rvis_gate_in_flg", length));
			String[] rvisCreDt = (JSPUtil.getParameter(request, prefix	+ "rvis_cre_dt", length));
			String[] revisedvolMinus = (JSPUtil.getParameter(request, prefix	+ "revisedvol_minus", length));
			String[] tmpDtlSeq = (JSPUtil.getParameter(request, prefix	+ "tmp_dtl_seq", length));
			String[] allTp = (JSPUtil.getParameter(request, prefix	+ "all_tp", length));
			String[] costCode = (JSPUtil.getParameter(request, prefix	+ "cost_code", length));
			String[] rvisCreUsrId = (JSPUtil.getParameter(request, prefix	+ "rvis_cre_usr_id", length));
			String[] fileImportYn = (JSPUtil.getParameter(request, prefix	+ "file_import_yn", length));
			String[] rvisIndFlg = (JSPUtil.getParameter(request, prefix	+ "rvis_ind_flg", length));
			String[] vvdVslCd = (JSPUtil.getParameter(request, prefix	+ "vvd_vsl_cd", length));
			String[] cntrStyCode = (JSPUtil.getParameter(request, prefix	+ "cntr_sty_code", length));
			String[] rvisLoclUpdDt = (JSPUtil.getParameter(request, prefix	+ "rvis_locl_upd_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rvisUpdDt = (JSPUtil.getParameter(request, prefix	+ "rvis_upd_dt", length));
			String[] rvisTmlInvTpCd = (JSPUtil.getParameter(request, prefix	+ "rvis_tml_inv_tp_cd", length));
			String[] delCntrSeq = (JSPUtil.getParameter(request, prefix	+ "del_cntr_seq", length));
			String[] flgYn = (JSPUtil.getParameter(request, prefix	+ "flg_yn", length));
			String[] tmpCalcVolQty = (JSPUtil.getParameter(request, prefix	+ "tmp_calc_vol_qty", length));
			String[] woNo = (JSPUtil.getParameter(request, prefix	+ "wo_no", length));
			String[] rvisBkgNo = (JSPUtil.getParameter(request, prefix	+ "rvis_bkg_no", length));
			String[] rvisPlugIn = (JSPUtil.getParameter(request, prefix	+ "rvis_plug_in", length));
			String[] rvisPlugOut = (JSPUtil.getParameter(request, prefix	+ "rvis_plug_out", length));
			String[] rvisPlugTerm = (JSPUtil.getParameter(request, prefix	+ "rvis_plug_term", length));
			String[] rvisCntrStyCd = (JSPUtil.getParameter(request, prefix	+ "rvis_cntr_sty_cd", length));
			String[] rvisVslCd = (JSPUtil.getParameter(request, prefix	+ "rvis_vsl_cd", length));
			String[] tmpRvisVolQty = (JSPUtil.getParameter(request, prefix	+ "tmp_rvis_vol_qty", length));
			String[] srcOfc = (JSPUtil.getParameter(request, prefix	+ "src_ofc", length));
			String[] ioBndCd2 = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd2", length));
			String[] rvisInvGateOutDt = (JSPUtil.getParameter(request, prefix	+ "rvis_inv_gate_out_dt", length));
			String[] rvisGateOutFlg = (JSPUtil.getParameter(request, prefix	+ "rvis_gate_out_flg", length));
			String[] rvisSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "rvis_skd_voy_no", length));
			String[] rvisTmlRvisTpCd = (JSPUtil.getParameter(request, prefix	+ "rvis_tml_rvis_tp_cd", length));
			String[] rvisCuzCntrNo = (JSPUtil.getParameter(request, prefix	+ "rvis_cuz_cntr_no", length));
			String[] rvisUpdUsrId = (JSPUtil.getParameter(request, prefix	+ "rvis_upd_usr_id", length));
			String[] rvisTmlSoCntrListSeq = (JSPUtil.getParameter(request, prefix	+ "rvis_tml_so_cntr_list_seq", length));
			String[] rvisInvGateInDt = (JSPUtil.getParameter(request, prefix	+ "rvis_inv_gate_in_dt", length));
			String[] atbDt2 = (JSPUtil.getParameter(request, prefix	+ "atb_dt2", length));
			String[] rvisSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "rvis_skd_dir_cd", length));
			String[] tmlSoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "tml_so_ofc_cty_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new MarineTerminalInvoiceCommonVO();
				if (tmpIfAmt[i] != null)
					model.setTmpIfAmt(tmpIfAmt[i]);
				if (rvisCalcCostGrpCd[i] != null)
					model.setRvisCalcCostGrpCd(rvisCalcCostGrpCd[i]);
				if (ediFlg[i] != null)
					model.setEdiFlg(ediFlg[i]);
				if (tempLgsCostCd[i] != null)
					model.setTempLgsCostCd(tempLgsCostCd[i]);
				if (vvdType[i] != null)
					model.setVvdType(vvdType[i]);
				if (rvisCntrTpszCd[i] != null)
					model.setRvisCntrTpszCd(rvisCntrTpszCd[i]);
				if (revisedvolSum[i] != null)
					model.setRevisedvolSum(revisedvolSum[i]);
				if (tmpCostCd[i] != null)
					model.setTmpCostCd(tmpCostCd[i]);
				if (rvisDiv[i] != null)
					model.setRvisDiv(rvisDiv[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fmTp[i] != null)
					model.setFmTp(fmTp[i]);
				if (rvisRmk[i] != null)
					model.setRvisRmk(rvisRmk[i]);
				if (rvisTmlSoRvisListSeq[i] != null)
					model.setRvisTmlSoRvisListSeq(rvisTmlSoRvisListSeq[i]);
				if (vvdSkdDirCd[i] != null)
					model.setVvdSkdDirCd(vvdSkdDirCd[i]);
				if (vvdSkdVoyNo2[i] != null)
					model.setVvdSkdVoyNo2(vvdSkdVoyNo2[i]);
				if (vvdSkdVoyNo[i] != null)
					model.setVvdSkdVoyNo(vvdSkdVoyNo[i]);
				if (tmlSoDtlSeq[i] != null)
					model.setTmlSoDtlSeq(tmlSoDtlSeq[i]);
				if (rvisLgsCostCd[i] != null)
					model.setRvisLgsCostCd(rvisLgsCostCd[i]);
				if (tmpCtrtRt[i] != null)
					model.setTmpCtrtRt(tmpCtrtRt[i]);
				if (reverifyYn[i] != null)
					model.setReverifyYn(reverifyYn[i]);
				if (deleteMode[i] != null)
					model.setDeleteMode(deleteMode[i]);
				if (rvisRhndRsnCd[i] != null)
					model.setRvisRhndRsnCd(rvisRhndRsnCd[i]);
				if (tmpInvXchRt[i] != null)
					model.setTmpInvXchRt(tmpInvXchRt[i]);
				if (costCalcFlg[i] != null)
					model.setCostCalcFlg(costCalcFlg[i]);
				if (invDateType[i] != null)
					model.setInvDateType(invDateType[i]);
				if (delIfSeq[i] != null)
					model.setDelIfSeq(delIfSeq[i]);
				if (vvd2[i] != null)
					model.setVvd2(vvd2[i]);
				if (rvisTmlSoDtlSeq[i] != null)
					model.setRvisTmlSoDtlSeq(rvisTmlSoDtlSeq[i]);
				if (rvisTmlSoSeq[i] != null)
					model.setRvisTmlSoSeq(rvisTmlSoSeq[i]);
				if (rvisTmlSoOfcCtyCd[i] != null)
					model.setRvisTmlSoOfcCtyCd(rvisTmlSoOfcCtyCd[i]);
				if (tsTp[i] != null)
					model.setTsTp(tsTp[i]);
				if (rvisLoclCreDt[i] != null)
					model.setRvisLoclCreDt(rvisLoclCreDt[i]);
				if (rvisCntrNo[i] != null)
					model.setRvisCntrNo(rvisCntrNo[i]);
				if (tmlSoSeq[i] != null)
					model.setTmlSoSeq(tmlSoSeq[i]);
				if (rvisGateInFlg[i] != null)
					model.setRvisGateInFlg(rvisGateInFlg[i]);
				if (rvisCreDt[i] != null)
					model.setRvisCreDt(rvisCreDt[i]);
				if (revisedvolMinus[i] != null)
					model.setRevisedvolMinus(revisedvolMinus[i]);
				if (tmpDtlSeq[i] != null)
					model.setTmpDtlSeq(tmpDtlSeq[i]);
				if (allTp[i] != null)
					model.setAllTp(allTp[i]);
				if (costCode[i] != null)
					model.setCostCode(costCode[i]);
				if (rvisCreUsrId[i] != null)
					model.setRvisCreUsrId(rvisCreUsrId[i]);
				if (fileImportYn[i] != null)
					model.setFileImportYn(fileImportYn[i]);
				if (rvisIndFlg[i] != null)
					model.setRvisIndFlg(rvisIndFlg[i]);
				if (vvdVslCd[i] != null)
					model.setVvdVslCd(vvdVslCd[i]);
				if (cntrStyCode[i] != null)
					model.setCntrStyCode(cntrStyCode[i]);
				if (rvisLoclUpdDt[i] != null)
					model.setRvisLoclUpdDt(rvisLoclUpdDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rvisUpdDt[i] != null)
					model.setRvisUpdDt(rvisUpdDt[i]);
				if (rvisTmlInvTpCd[i] != null)
					model.setRvisTmlInvTpCd(rvisTmlInvTpCd[i]);
				if (delCntrSeq[i] != null)
					model.setDelCntrSeq(delCntrSeq[i]);
				if (flgYn[i] != null)
					model.setFlgYn(flgYn[i]);
				if (tmpCalcVolQty[i] != null)
					model.setTmpCalcVolQty(tmpCalcVolQty[i]);
				if (woNo[i] != null)
					model.setWoNo(woNo[i]);
				if (rvisBkgNo[i] != null)
					model.setRvisBkgNo(rvisBkgNo[i]);
				if (rvisPlugIn[i] != null)
					model.setRvisPlugIn(rvisPlugIn[i]);
				if (rvisPlugOut[i] != null)
					model.setRvisPlugOut(rvisPlugOut[i]);
				if (rvisPlugTerm[i] != null)
					model.setRvisPlugTerm(rvisPlugTerm[i]);
				if (rvisCntrStyCd[i] != null)
					model.setRvisCntrStyCd(rvisCntrStyCd[i]);
				if (rvisVslCd[i] != null)
					model.setRvisVslCd(rvisVslCd[i]);
				if (tmpRvisVolQty[i] != null)
					model.setTmpRvisVolQty(tmpRvisVolQty[i]);
				if (srcOfc[i] != null)
					model.setSrcOfc(srcOfc[i]);
				if (ioBndCd2[i] != null)
					model.setIoBndCd2(ioBndCd2[i]);
				if (rvisInvGateOutDt[i] != null)
					model.setRvisInvGateOutDt(rvisInvGateOutDt[i]);
				if (rvisGateOutFlg[i] != null)
					model.setRvisGateOutFlg(rvisGateOutFlg[i]);
				if (rvisSkdVoyNo[i] != null)
					model.setRvisSkdVoyNo(rvisSkdVoyNo[i]);
				if (rvisTmlRvisTpCd[i] != null)
					model.setRvisTmlRvisTpCd(rvisTmlRvisTpCd[i]);
				if (rvisCuzCntrNo[i] != null)
					model.setRvisCuzCntrNo(rvisCuzCntrNo[i]);
				if (rvisUpdUsrId[i] != null)
					model.setRvisUpdUsrId(rvisUpdUsrId[i]);
				if (rvisTmlSoCntrListSeq[i] != null)
					model.setRvisTmlSoCntrListSeq(rvisTmlSoCntrListSeq[i]);
				if (rvisInvGateInDt[i] != null)
					model.setRvisInvGateInDt(rvisInvGateInDt[i]);
				if (atbDt2[i] != null)
					model.setAtbDt2(atbDt2[i]);
				if (rvisSkdDirCd[i] != null)
					model.setRvisSkdDirCd(rvisSkdDirCd[i]);
				if (tmlSoOfcCtyCd[i] != null)
					model.setTmlSoOfcCtyCd(tmlSoOfcCtyCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMarineTerminalInvoiceCommonVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MarineTerminalInvoiceCommonVO[]
	 */
	public MarineTerminalInvoiceCommonVO[] getMarineTerminalInvoiceCommonVOs(){
		MarineTerminalInvoiceCommonVO[] vos = (MarineTerminalInvoiceCommonVO[])models.toArray(new MarineTerminalInvoiceCommonVO[models.size()]);
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
		this.tmpIfAmt = this.tmpIfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisCalcCostGrpCd = this.rvisCalcCostGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediFlg = this.ediFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tempLgsCostCd = this.tempLgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdType = this.vvdType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisCntrTpszCd = this.rvisCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revisedvolSum = this.revisedvolSum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpCostCd = this.tmpCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisDiv = this.rvisDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmTp = this.fmTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisRmk = this.rvisRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisTmlSoRvisListSeq = this.rvisTmlSoRvisListSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdSkdDirCd = this.vvdSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdSkdVoyNo2 = this.vvdSkdVoyNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdSkdVoyNo = this.vvdSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlSoDtlSeq = this.tmlSoDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisLgsCostCd = this.rvisLgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpCtrtRt = this.tmpCtrtRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reverifyYn = this.reverifyYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deleteMode = this.deleteMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisRhndRsnCd = this.rvisRhndRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpInvXchRt = this.tmpInvXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCalcFlg = this.costCalcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDateType = this.invDateType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delIfSeq = this.delIfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd2 = this.vvd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisTmlSoDtlSeq = this.rvisTmlSoDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisTmlSoSeq = this.rvisTmlSoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisTmlSoOfcCtyCd = this.rvisTmlSoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsTp = this.tsTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisLoclCreDt = this.rvisLoclCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisCntrNo = this.rvisCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlSoSeq = this.tmlSoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisGateInFlg = this.rvisGateInFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisCreDt = this.rvisCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revisedvolMinus = this.revisedvolMinus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpDtlSeq = this.tmpDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.allTp = this.allTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCode = this.costCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisCreUsrId = this.rvisCreUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileImportYn = this.fileImportYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisIndFlg = this.rvisIndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdVslCd = this.vvdVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStyCode = this.cntrStyCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisLoclUpdDt = this.rvisLoclUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisUpdDt = this.rvisUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisTmlInvTpCd = this.rvisTmlInvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCntrSeq = this.delCntrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flgYn = this.flgYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpCalcVolQty = this.tmpCalcVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNo = this.woNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisBkgNo = this.rvisBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisPlugIn = this.rvisPlugIn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisPlugOut = this.rvisPlugOut .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisPlugTerm = this.rvisPlugTerm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisCntrStyCd = this.rvisCntrStyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisVslCd = this.rvisVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpRvisVolQty = this.tmpRvisVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcOfc = this.srcOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd2 = this.ioBndCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisInvGateOutDt = this.rvisInvGateOutDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisGateOutFlg = this.rvisGateOutFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisSkdVoyNo = this.rvisSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisTmlRvisTpCd = this.rvisTmlRvisTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisCuzCntrNo = this.rvisCuzCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisUpdUsrId = this.rvisUpdUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisTmlSoCntrListSeq = this.rvisTmlSoCntrListSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisInvGateInDt = this.rvisInvGateInDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atbDt2 = this.atbDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisSkdDirCd = this.rvisSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlSoOfcCtyCd = this.tmlSoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
