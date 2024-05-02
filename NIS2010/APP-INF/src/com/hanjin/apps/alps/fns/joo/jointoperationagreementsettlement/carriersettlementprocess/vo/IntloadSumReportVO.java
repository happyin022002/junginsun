/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : IntloadSumReportVO.java
*@FileTitle : IntloadSumReportVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.09
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2012.07.09 원종규 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo;

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
 * @author 원종규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class IntloadSumReportVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<IntloadSumReportVO> models = new ArrayList<IntloadSumReportVO>();
	
	/* Column Info */
	private String joVoidTeuQty = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String additionalCd = null;
	/* Column Info */
	private String remark = null;
	/* Column Info */
	private String akJoVoidTeuQty = null;
	/* Column Info */
	private String actuWt = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String mt40 = null;
	/* Column Info */
	private String add40hcTeu = null;
	/* Column Info */
	private String hidJoShrtLegRmkSctrNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String full40 = null;
	/* Column Info */
	private String preFr = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* Column Info */
	private String joAlocAdjRmkYn = null;
	/* Column Info */
	private String actSlot = null;
	/* Column Info */
	private String full45 = null;
	/* Column Info */
	private String iudFlag = null;
	/* Column Info */
	private String actuTeu = null;
	/* Column Info */
	private String hcLd40 = null;
	/* Column Info */
	private String full20hc = null;
	/* Column Info */
	private String joRfIptQty = null;
	/* Column Info */
	private String joRgnCd = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String superCd1 = null;
	/* Column Info */
	private String add45Teu = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String grandTtlSlot = null;
	/* Column Info */
	private String akUnit = null;
	/* Column Info */
	private String emptyWt = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String preTo = null;
	/* Column Info */
	private String remarkYn = null;
	/* Column Info */
	private String emptyTeu = null;
	/* Column Info */
	private String region = null;
	/* Column Info */
	private String totalTeu = null;
	/* Column Info */
	private String joShrtLegRmkWgt = null;
	/* Column Info */
	private String full40hc = null;
	/* Column Info */
	private String hcLd20 = null;
	/* Column Info */
	private String full20 = null;
	/* Column Info */
	private String add20hcTeu = null;
	/* Column Info */
	private String allWgt = null;
	/* Column Info */
	private String mtTeu = null;
	/* Column Info */
	private String overSlot = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String joAlocAdjWgt = null;
	/* Column Info */
	private String joAlocAdjTeuQty = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String allocWt = null;
	/* Column Info */
	private String mtWt = null;
	/* Column Info */
	private String joAlocAdjRmk = null;
	/* Column Info */
	private String joShrtLegRmkSctrNm = null;
	/* Column Info */
	private String joShrtLegRmkTeuQty = null;
	/* Column Info */
	private String joCrrCd = null;
	/* Column Info */
	private String overWgt = null;
	/* Column Info */
	private String allTeu = null;
	/* Column Info */
	private String joRfOcnQty = null;
	/* Column Info */
	private String overLongWt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String overLongTeu = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String hidJoShrtLegRmkWgt = null;
	/* Column Info */
	private String source = null;
	/* Column Info */
	private String oprCd = null;
	/* Column Info */
	private String grandTtlWgt = null;
	/* Column Info */
	private String rfI = null;
	/* Column Info */
	private String reDivrCd = null;
	/* Column Info */
	private String hidJoShrtLegRmkTeuQty = null;
	/* Column Info */
	private String rfO = null;
	/* Column Info */
	private String allocTeu = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public IntloadSumReportVO() {}

	public IntloadSumReportVO(String ibflag, String pagerows, String joVoidTeuQty, String vslCd, String additionalCd, String remark, String akJoVoidTeuQty, String actuWt, String rlaneCd, String mt40, String add40hcTeu, String full40, String preFr, String vpsPortCd, String joAlocAdjRmkYn, String iudFlag, String full45, String actSlot, String actuTeu, String hcLd40, String joRfIptQty, String joRgnCd, String vpsEtdDt, String joShrtLegRmkSctrNm, String superCd1, String add45Teu, String skdVoyNo, String grandTtlSlot, String akUnit, String emptyWt, String vvd, String creUsrId, String preTo, String remarkYn, String emptyTeu, String region, String totalTeu, String joShrtLegRmkWgt, String full40hc, String hcLd20, String full20, String allWgt, String mtTeu, String overSlot, String usrId, String joAlocAdjWgt, String joAlocAdjTeuQty, String portCd, String mtWt, String allocWt, String joAlocAdjRmk, String joShrtLegRmkTeuQty, String joCrrCd, String overWgt, String allTeu, String overLongWt, String joRfOcnQty, String overLongTeu, String skdDirCd, String slanCd, String source, String grandTtlWgt, String oprCd, String reDivrCd, String rfI, String allocTeu, String rfO, String add20hcTeu, String full20hc, String hidJoShrtLegRmkTeuQty, String hidJoShrtLegRmkWgt, String hidJoShrtLegRmkSctrNm) {
		this.joVoidTeuQty = joVoidTeuQty;
		this.vslCd = vslCd;
		this.additionalCd = additionalCd;
		this.remark = remark;
		this.akJoVoidTeuQty = akJoVoidTeuQty;
		this.actuWt = actuWt;
		this.rlaneCd = rlaneCd;
		this.mt40 = mt40;
		this.add40hcTeu = add40hcTeu;
		this.hidJoShrtLegRmkSctrNm = hidJoShrtLegRmkSctrNm;
		this.pagerows = pagerows;
		this.full40 = full40;
		this.preFr = preFr;
		this.vpsPortCd = vpsPortCd;
		this.joAlocAdjRmkYn = joAlocAdjRmkYn;
		this.actSlot = actSlot;
		this.full45 = full45;
		this.iudFlag = iudFlag;
		this.actuTeu = actuTeu;
		this.hcLd40 = hcLd40;
		this.full20hc = full20hc;
		this.joRfIptQty = joRfIptQty;
		this.joRgnCd = joRgnCd;
		this.vpsEtdDt = vpsEtdDt;
		this.superCd1 = superCd1;
		this.add45Teu = add45Teu;
		this.skdVoyNo = skdVoyNo;
		this.grandTtlSlot = grandTtlSlot;
		this.akUnit = akUnit;
		this.emptyWt = emptyWt;
		this.vvd = vvd;
		this.creUsrId = creUsrId;
		this.preTo = preTo;
		this.remarkYn = remarkYn;
		this.emptyTeu = emptyTeu;
		this.region = region;
		this.totalTeu = totalTeu;
		this.joShrtLegRmkWgt = joShrtLegRmkWgt;
		this.full40hc = full40hc;
		this.hcLd20 = hcLd20;
		this.full20 = full20;
		this.add20hcTeu = add20hcTeu;
		this.allWgt = allWgt;
		this.mtTeu = mtTeu;
		this.overSlot = overSlot;
		this.ibflag = ibflag;
		this.usrId = usrId;
		this.joAlocAdjWgt = joAlocAdjWgt;
		this.joAlocAdjTeuQty = joAlocAdjTeuQty;
		this.portCd = portCd;
		this.allocWt = allocWt;
		this.mtWt = mtWt;
		this.joAlocAdjRmk = joAlocAdjRmk;
		this.joShrtLegRmkSctrNm = joShrtLegRmkSctrNm;
		this.joShrtLegRmkTeuQty = joShrtLegRmkTeuQty;
		this.joCrrCd = joCrrCd;
		this.overWgt = overWgt;
		this.allTeu = allTeu;
		this.joRfOcnQty = joRfOcnQty;
		this.overLongWt = overLongWt;
		this.skdDirCd = skdDirCd;
		this.overLongTeu = overLongTeu;
		this.slanCd = slanCd;
		this.hidJoShrtLegRmkWgt = hidJoShrtLegRmkWgt;
		this.source = source;
		this.oprCd = oprCd;
		this.grandTtlWgt = grandTtlWgt;
		this.rfI = rfI;
		this.reDivrCd = reDivrCd;
		this.hidJoShrtLegRmkTeuQty = hidJoShrtLegRmkTeuQty;
		this.rfO = rfO;
		this.allocTeu = allocTeu;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("jo_void_teu_qty", getJoVoidTeuQty());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("additional_cd", getAdditionalCd());
		this.hashColumns.put("remark", getRemark());
		this.hashColumns.put("ak_jo_void_teu_qty", getAkJoVoidTeuQty());
		this.hashColumns.put("actu_wt", getActuWt());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("mt_40", getMt40());
		this.hashColumns.put("add_40hc_teu", getAdd40hcTeu());
		this.hashColumns.put("hid_jo_shrt_leg_rmk_sctr_nm", getHidJoShrtLegRmkSctrNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("full_40", getFull40());
		this.hashColumns.put("pre_fr", getPreFr());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("jo_aloc_adj_rmk_yn", getJoAlocAdjRmkYn());
		this.hashColumns.put("act_slot", getActSlot());
		this.hashColumns.put("full_45", getFull45());
		this.hashColumns.put("iud_flag", getIudFlag());
		this.hashColumns.put("actu_teu", getActuTeu());
		this.hashColumns.put("hc_ld_40", getHcLd40());
		this.hashColumns.put("full_20hc", getFull20hc());
		this.hashColumns.put("jo_rf_ipt_qty", getJoRfIptQty());
		this.hashColumns.put("jo_rgn_cd", getJoRgnCd());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("super_cd1", getSuperCd1());
		this.hashColumns.put("add_45_teu", getAdd45Teu());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("grand_ttl_slot", getGrandTtlSlot());
		this.hashColumns.put("ak_unit", getAkUnit());
		this.hashColumns.put("empty_wt", getEmptyWt());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("pre_to", getPreTo());
		this.hashColumns.put("remark_yn", getRemarkYn());
		this.hashColumns.put("empty_teu", getEmptyTeu());
		this.hashColumns.put("region", getRegion());
		this.hashColumns.put("total_teu", getTotalTeu());
		this.hashColumns.put("jo_shrt_leg_rmk_wgt", getJoShrtLegRmkWgt());
		this.hashColumns.put("full_40hc", getFull40hc());
		this.hashColumns.put("hc_ld_20", getHcLd20());
		this.hashColumns.put("full_20", getFull20());
		this.hashColumns.put("add_20hc_teu", getAdd20hcTeu());
		this.hashColumns.put("all_wgt", getAllWgt());
		this.hashColumns.put("mt_teu", getMtTeu());
		this.hashColumns.put("over_slot", getOverSlot());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("jo_aloc_adj_wgt", getJoAlocAdjWgt());
		this.hashColumns.put("jo_aloc_adj_teu_qty", getJoAlocAdjTeuQty());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("alloc_wt", getAllocWt());
		this.hashColumns.put("mt_wt", getMtWt());
		this.hashColumns.put("jo_aloc_adj_rmk", getJoAlocAdjRmk());
		this.hashColumns.put("jo_shrt_leg_rmk_sctr_nm", getJoShrtLegRmkSctrNm());
		this.hashColumns.put("jo_shrt_leg_rmk_teu_qty", getJoShrtLegRmkTeuQty());
		this.hashColumns.put("jo_crr_cd", getJoCrrCd());
		this.hashColumns.put("over_wgt", getOverWgt());
		this.hashColumns.put("all_teu", getAllTeu());
		this.hashColumns.put("jo_rf_ocn_qty", getJoRfOcnQty());
		this.hashColumns.put("over_long_wt", getOverLongWt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("over_long_teu", getOverLongTeu());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("hid_jo_shrt_leg_rmk_wgt", getHidJoShrtLegRmkWgt());
		this.hashColumns.put("source", getSource());
		this.hashColumns.put("opr_cd", getOprCd());
		this.hashColumns.put("grand_ttl_wgt", getGrandTtlWgt());
		this.hashColumns.put("rf_i", getRfI());
		this.hashColumns.put("re_divr_cd", getReDivrCd());
		this.hashColumns.put("hid_jo_shrt_leg_rmk_teu_qty", getHidJoShrtLegRmkTeuQty());
		this.hashColumns.put("rf_o", getRfO());
		this.hashColumns.put("alloc_teu", getAllocTeu());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("jo_void_teu_qty", "joVoidTeuQty");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("additional_cd", "additionalCd");
		this.hashFields.put("remark", "remark");
		this.hashFields.put("ak_jo_void_teu_qty", "akJoVoidTeuQty");
		this.hashFields.put("actu_wt", "actuWt");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("mt_40", "mt40");
		this.hashFields.put("add_40hc_teu", "add40hcTeu");
		this.hashFields.put("hid_jo_shrt_leg_rmk_sctr_nm", "hidJoShrtLegRmkSctrNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("full_40", "full40");
		this.hashFields.put("pre_fr", "preFr");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("jo_aloc_adj_rmk_yn", "joAlocAdjRmkYn");
		this.hashFields.put("act_slot", "actSlot");
		this.hashFields.put("full_45", "full45");
		this.hashFields.put("iud_flag", "iudFlag");
		this.hashFields.put("actu_teu", "actuTeu");
		this.hashFields.put("hc_ld_40", "hcLd40");
		this.hashFields.put("full_20hc", "full20hc");
		this.hashFields.put("jo_rf_ipt_qty", "joRfIptQty");
		this.hashFields.put("jo_rgn_cd", "joRgnCd");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("super_cd1", "superCd1");
		this.hashFields.put("add_45_teu", "add45Teu");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("grand_ttl_slot", "grandTtlSlot");
		this.hashFields.put("ak_unit", "akUnit");
		this.hashFields.put("empty_wt", "emptyWt");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("pre_to", "preTo");
		this.hashFields.put("remark_yn", "remarkYn");
		this.hashFields.put("empty_teu", "emptyTeu");
		this.hashFields.put("region", "region");
		this.hashFields.put("total_teu", "totalTeu");
		this.hashFields.put("jo_shrt_leg_rmk_wgt", "joShrtLegRmkWgt");
		this.hashFields.put("full_40hc", "full40hc");
		this.hashFields.put("hc_ld_20", "hcLd20");
		this.hashFields.put("full_20", "full20");
		this.hashFields.put("add_20hc_teu", "add20hcTeu");
		this.hashFields.put("all_wgt", "allWgt");
		this.hashFields.put("mt_teu", "mtTeu");
		this.hashFields.put("over_slot", "overSlot");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("jo_aloc_adj_wgt", "joAlocAdjWgt");
		this.hashFields.put("jo_aloc_adj_teu_qty", "joAlocAdjTeuQty");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("alloc_wt", "allocWt");
		this.hashFields.put("mt_wt", "mtWt");
		this.hashFields.put("jo_aloc_adj_rmk", "joAlocAdjRmk");
		this.hashFields.put("jo_shrt_leg_rmk_sctr_nm", "joShrtLegRmkSctrNm");
		this.hashFields.put("jo_shrt_leg_rmk_teu_qty", "joShrtLegRmkTeuQty");
		this.hashFields.put("jo_crr_cd", "joCrrCd");
		this.hashFields.put("over_wgt", "overWgt");
		this.hashFields.put("all_teu", "allTeu");
		this.hashFields.put("jo_rf_ocn_qty", "joRfOcnQty");
		this.hashFields.put("over_long_wt", "overLongWt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("over_long_teu", "overLongTeu");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("hid_jo_shrt_leg_rmk_wgt", "hidJoShrtLegRmkWgt");
		this.hashFields.put("source", "source");
		this.hashFields.put("opr_cd", "oprCd");
		this.hashFields.put("grand_ttl_wgt", "grandTtlWgt");
		this.hashFields.put("rf_i", "rfI");
		this.hashFields.put("re_divr_cd", "reDivrCd");
		this.hashFields.put("hid_jo_shrt_leg_rmk_teu_qty", "hidJoShrtLegRmkTeuQty");
		this.hashFields.put("rf_o", "rfO");
		this.hashFields.put("alloc_teu", "allocTeu");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return joVoidTeuQty
	 */
	public String getJoVoidTeuQty() {
		return this.joVoidTeuQty;
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
	 * @return additionalCd
	 */
	public String getAdditionalCd() {
		return this.additionalCd;
	}
	
	/**
	 * Column Info
	 * @return remark
	 */
	public String getRemark() {
		return this.remark;
	}
	
	/**
	 * Column Info
	 * @return akJoVoidTeuQty
	 */
	public String getAkJoVoidTeuQty() {
		return this.akJoVoidTeuQty;
	}
	
	/**
	 * Column Info
	 * @return actuWt
	 */
	public String getActuWt() {
		return this.actuWt;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return mt40
	 */
	public String getMt40() {
		return this.mt40;
	}
	
	/**
	 * Column Info
	 * @return add40hcTeu
	 */
	public String getAdd40hcTeu() {
		return this.add40hcTeu;
	}
	
	/**
	 * Column Info
	 * @return hidJoShrtLegRmkSctrNm
	 */
	public String getHidJoShrtLegRmkSctrNm() {
		return this.hidJoShrtLegRmkSctrNm;
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
	 * @return full40
	 */
	public String getFull40() {
		return this.full40;
	}
	
	/**
	 * Column Info
	 * @return preFr
	 */
	public String getPreFr() {
		return this.preFr;
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
	 * @return joAlocAdjRmkYn
	 */
	public String getJoAlocAdjRmkYn() {
		return this.joAlocAdjRmkYn;
	}
	
	/**
	 * Column Info
	 * @return actSlot
	 */
	public String getActSlot() {
		return this.actSlot;
	}
	
	/**
	 * Column Info
	 * @return full45
	 */
	public String getFull45() {
		return this.full45;
	}
	
	/**
	 * Column Info
	 * @return iudFlag
	 */
	public String getIudFlag() {
		return this.iudFlag;
	}
	
	/**
	 * Column Info
	 * @return actuTeu
	 */
	public String getActuTeu() {
		return this.actuTeu;
	}
	
	/**
	 * Column Info
	 * @return hcLd40
	 */
	public String getHcLd40() {
		return this.hcLd40;
	}
	
	/**
	 * Column Info
	 * @return full20hc
	 */
	public String getFull20hc() {
		return this.full20hc;
	}
	
	/**
	 * Column Info
	 * @return joRfIptQty
	 */
	public String getJoRfIptQty() {
		return this.joRfIptQty;
	}
	
	/**
	 * Column Info
	 * @return joRgnCd
	 */
	public String getJoRgnCd() {
		return this.joRgnCd;
	}
	
	/**
	 * Column Info
	 * @return vpsEtdDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @return superCd1
	 */
	public String getSuperCd1() {
		return this.superCd1;
	}
	
	/**
	 * Column Info
	 * @return add45Teu
	 */
	public String getAdd45Teu() {
		return this.add45Teu;
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
	 * @return grandTtlSlot
	 */
	public String getGrandTtlSlot() {
		return this.grandTtlSlot;
	}
	
	/**
	 * Column Info
	 * @return akUnit
	 */
	public String getAkUnit() {
		return this.akUnit;
	}
	
	/**
	 * Column Info
	 * @return emptyWt
	 */
	public String getEmptyWt() {
		return this.emptyWt;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return preTo
	 */
	public String getPreTo() {
		return this.preTo;
	}
	
	/**
	 * Column Info
	 * @return remarkYn
	 */
	public String getRemarkYn() {
		return this.remarkYn;
	}
	
	/**
	 * Column Info
	 * @return emptyTeu
	 */
	public String getEmptyTeu() {
		return this.emptyTeu;
	}
	
	/**
	 * Column Info
	 * @return region
	 */
	public String getRegion() {
		return this.region;
	}
	
	/**
	 * Column Info
	 * @return totalTeu
	 */
	public String getTotalTeu() {
		return this.totalTeu;
	}
	
	/**
	 * Column Info
	 * @return joShrtLegRmkWgt
	 */
	public String getJoShrtLegRmkWgt() {
		return this.joShrtLegRmkWgt;
	}
	
	/**
	 * Column Info
	 * @return full40hc
	 */
	public String getFull40hc() {
		return this.full40hc;
	}
	
	/**
	 * Column Info
	 * @return hcLd20
	 */
	public String getHcLd20() {
		return this.hcLd20;
	}
	
	/**
	 * Column Info
	 * @return full20
	 */
	public String getFull20() {
		return this.full20;
	}
	
	/**
	 * Column Info
	 * @return add20hcTeu
	 */
	public String getAdd20hcTeu() {
		return this.add20hcTeu;
	}
	
	/**
	 * Column Info
	 * @return allWgt
	 */
	public String getAllWgt() {
		return this.allWgt;
	}
	
	/**
	 * Column Info
	 * @return mtTeu
	 */
	public String getMtTeu() {
		return this.mtTeu;
	}
	
	/**
	 * Column Info
	 * @return overSlot
	 */
	public String getOverSlot() {
		return this.overSlot;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return joAlocAdjWgt
	 */
	public String getJoAlocAdjWgt() {
		return this.joAlocAdjWgt;
	}
	
	/**
	 * Column Info
	 * @return joAlocAdjTeuQty
	 */
	public String getJoAlocAdjTeuQty() {
		return this.joAlocAdjTeuQty;
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
	 * @return allocWt
	 */
	public String getAllocWt() {
		return this.allocWt;
	}
	
	/**
	 * Column Info
	 * @return mtWt
	 */
	public String getMtWt() {
		return this.mtWt;
	}
	
	/**
	 * Column Info
	 * @return joAlocAdjRmk
	 */
	public String getJoAlocAdjRmk() {
		return this.joAlocAdjRmk;
	}
	
	/**
	 * Column Info
	 * @return joShrtLegRmkSctrNm
	 */
	public String getJoShrtLegRmkSctrNm() {
		return this.joShrtLegRmkSctrNm;
	}
	
	/**
	 * Column Info
	 * @return joShrtLegRmkTeuQty
	 */
	public String getJoShrtLegRmkTeuQty() {
		return this.joShrtLegRmkTeuQty;
	}
	
	/**
	 * Column Info
	 * @return joCrrCd
	 */
	public String getJoCrrCd() {
		return this.joCrrCd;
	}
	
	/**
	 * Column Info
	 * @return overWgt
	 */
	public String getOverWgt() {
		return this.overWgt;
	}
	
	/**
	 * Column Info
	 * @return allTeu
	 */
	public String getAllTeu() {
		return this.allTeu;
	}
	
	/**
	 * Column Info
	 * @return joRfOcnQty
	 */
	public String getJoRfOcnQty() {
		return this.joRfOcnQty;
	}
	
	/**
	 * Column Info
	 * @return overLongWt
	 */
	public String getOverLongWt() {
		return this.overLongWt;
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
	 * @return overLongTeu
	 */
	public String getOverLongTeu() {
		return this.overLongTeu;
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
	 * @return hidJoShrtLegRmkWgt
	 */
	public String getHidJoShrtLegRmkWgt() {
		return this.hidJoShrtLegRmkWgt;
	}
	
	/**
	 * Column Info
	 * @return source
	 */
	public String getSource() {
		return this.source;
	}
	
	/**
	 * Column Info
	 * @return oprCd
	 */
	public String getOprCd() {
		return this.oprCd;
	}
	
	/**
	 * Column Info
	 * @return grandTtlWgt
	 */
	public String getGrandTtlWgt() {
		return this.grandTtlWgt;
	}
	
	/**
	 * Column Info
	 * @return rfI
	 */
	public String getRfI() {
		return this.rfI;
	}
	
	/**
	 * Column Info
	 * @return reDivrCd
	 */
	public String getReDivrCd() {
		return this.reDivrCd;
	}
	
	/**
	 * Column Info
	 * @return hidJoShrtLegRmkTeuQty
	 */
	public String getHidJoShrtLegRmkTeuQty() {
		return this.hidJoShrtLegRmkTeuQty;
	}
	
	/**
	 * Column Info
	 * @return rfO
	 */
	public String getRfO() {
		return this.rfO;
	}
	
	/**
	 * Column Info
	 * @return allocTeu
	 */
	public String getAllocTeu() {
		return this.allocTeu;
	}
	

	/**
	 * Column Info
	 * @param joVoidTeuQty
	 */
	public void setJoVoidTeuQty(String joVoidTeuQty) {
		this.joVoidTeuQty = joVoidTeuQty;
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
	 * @param additionalCd
	 */
	public void setAdditionalCd(String additionalCd) {
		this.additionalCd = additionalCd;
	}
	
	/**
	 * Column Info
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * Column Info
	 * @param akJoVoidTeuQty
	 */
	public void setAkJoVoidTeuQty(String akJoVoidTeuQty) {
		this.akJoVoidTeuQty = akJoVoidTeuQty;
	}
	
	/**
	 * Column Info
	 * @param actuWt
	 */
	public void setActuWt(String actuWt) {
		this.actuWt = actuWt;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param mt40
	 */
	public void setMt40(String mt40) {
		this.mt40 = mt40;
	}
	
	/**
	 * Column Info
	 * @param add40hcTeu
	 */
	public void setAdd40hcTeu(String add40hcTeu) {
		this.add40hcTeu = add40hcTeu;
	}
	
	/**
	 * Column Info
	 * @param hidJoShrtLegRmkSctrNm
	 */
	public void setHidJoShrtLegRmkSctrNm(String hidJoShrtLegRmkSctrNm) {
		this.hidJoShrtLegRmkSctrNm = hidJoShrtLegRmkSctrNm;
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
	 * @param full40
	 */
	public void setFull40(String full40) {
		this.full40 = full40;
	}
	
	/**
	 * Column Info
	 * @param preFr
	 */
	public void setPreFr(String preFr) {
		this.preFr = preFr;
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
	 * @param joAlocAdjRmkYn
	 */
	public void setJoAlocAdjRmkYn(String joAlocAdjRmkYn) {
		this.joAlocAdjRmkYn = joAlocAdjRmkYn;
	}
	
	/**
	 * Column Info
	 * @param actSlot
	 */
	public void setActSlot(String actSlot) {
		this.actSlot = actSlot;
	}
	
	/**
	 * Column Info
	 * @param full45
	 */
	public void setFull45(String full45) {
		this.full45 = full45;
	}
	
	/**
	 * Column Info
	 * @param iudFlag
	 */
	public void setIudFlag(String iudFlag) {
		this.iudFlag = iudFlag;
	}
	
	/**
	 * Column Info
	 * @param actuTeu
	 */
	public void setActuTeu(String actuTeu) {
		this.actuTeu = actuTeu;
	}
	
	/**
	 * Column Info
	 * @param hcLd40
	 */
	public void setHcLd40(String hcLd40) {
		this.hcLd40 = hcLd40;
	}
	
	/**
	 * Column Info
	 * @param full20hc
	 */
	public void setFull20hc(String full20hc) {
		this.full20hc = full20hc;
	}
	
	/**
	 * Column Info
	 * @param joRfIptQty
	 */
	public void setJoRfIptQty(String joRfIptQty) {
		this.joRfIptQty = joRfIptQty;
	}
	
	/**
	 * Column Info
	 * @param joRgnCd
	 */
	public void setJoRgnCd(String joRgnCd) {
		this.joRgnCd = joRgnCd;
	}
	
	/**
	 * Column Info
	 * @param vpsEtdDt
	 */
	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @param superCd1
	 */
	public void setSuperCd1(String superCd1) {
		this.superCd1 = superCd1;
	}
	
	/**
	 * Column Info
	 * @param add45Teu
	 */
	public void setAdd45Teu(String add45Teu) {
		this.add45Teu = add45Teu;
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
	 * @param grandTtlSlot
	 */
	public void setGrandTtlSlot(String grandTtlSlot) {
		this.grandTtlSlot = grandTtlSlot;
	}
	
	/**
	 * Column Info
	 * @param akUnit
	 */
	public void setAkUnit(String akUnit) {
		this.akUnit = akUnit;
	}
	
	/**
	 * Column Info
	 * @param emptyWt
	 */
	public void setEmptyWt(String emptyWt) {
		this.emptyWt = emptyWt;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param preTo
	 */
	public void setPreTo(String preTo) {
		this.preTo = preTo;
	}
	
	/**
	 * Column Info
	 * @param remarkYn
	 */
	public void setRemarkYn(String remarkYn) {
		this.remarkYn = remarkYn;
	}
	
	/**
	 * Column Info
	 * @param emptyTeu
	 */
	public void setEmptyTeu(String emptyTeu) {
		this.emptyTeu = emptyTeu;
	}
	
	/**
	 * Column Info
	 * @param region
	 */
	public void setRegion(String region) {
		this.region = region;
	}
	
	/**
	 * Column Info
	 * @param totalTeu
	 */
	public void setTotalTeu(String totalTeu) {
		this.totalTeu = totalTeu;
	}
	
	/**
	 * Column Info
	 * @param joShrtLegRmkWgt
	 */
	public void setJoShrtLegRmkWgt(String joShrtLegRmkWgt) {
		this.joShrtLegRmkWgt = joShrtLegRmkWgt;
	}
	
	/**
	 * Column Info
	 * @param full40hc
	 */
	public void setFull40hc(String full40hc) {
		this.full40hc = full40hc;
	}
	
	/**
	 * Column Info
	 * @param hcLd20
	 */
	public void setHcLd20(String hcLd20) {
		this.hcLd20 = hcLd20;
	}
	
	/**
	 * Column Info
	 * @param full20
	 */
	public void setFull20(String full20) {
		this.full20 = full20;
	}
	
	/**
	 * Column Info
	 * @param add20hcTeu
	 */
	public void setAdd20hcTeu(String add20hcTeu) {
		this.add20hcTeu = add20hcTeu;
	}
	
	/**
	 * Column Info
	 * @param allWgt
	 */
	public void setAllWgt(String allWgt) {
		this.allWgt = allWgt;
	}
	
	/**
	 * Column Info
	 * @param mtTeu
	 */
	public void setMtTeu(String mtTeu) {
		this.mtTeu = mtTeu;
	}
	
	/**
	 * Column Info
	 * @param overSlot
	 */
	public void setOverSlot(String overSlot) {
		this.overSlot = overSlot;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param joAlocAdjWgt
	 */
	public void setJoAlocAdjWgt(String joAlocAdjWgt) {
		this.joAlocAdjWgt = joAlocAdjWgt;
	}
	
	/**
	 * Column Info
	 * @param joAlocAdjTeuQty
	 */
	public void setJoAlocAdjTeuQty(String joAlocAdjTeuQty) {
		this.joAlocAdjTeuQty = joAlocAdjTeuQty;
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
	 * @param allocWt
	 */
	public void setAllocWt(String allocWt) {
		this.allocWt = allocWt;
	}
	
	/**
	 * Column Info
	 * @param mtWt
	 */
	public void setMtWt(String mtWt) {
		this.mtWt = mtWt;
	}
	
	/**
	 * Column Info
	 * @param joAlocAdjRmk
	 */
	public void setJoAlocAdjRmk(String joAlocAdjRmk) {
		this.joAlocAdjRmk = joAlocAdjRmk;
	}
	
	/**
	 * Column Info
	 * @param joShrtLegRmkSctrNm
	 */
	public void setJoShrtLegRmkSctrNm(String joShrtLegRmkSctrNm) {
		this.joShrtLegRmkSctrNm = joShrtLegRmkSctrNm;
	}
	
	/**
	 * Column Info
	 * @param joShrtLegRmkTeuQty
	 */
	public void setJoShrtLegRmkTeuQty(String joShrtLegRmkTeuQty) {
		this.joShrtLegRmkTeuQty = joShrtLegRmkTeuQty;
	}
	
	/**
	 * Column Info
	 * @param joCrrCd
	 */
	public void setJoCrrCd(String joCrrCd) {
		this.joCrrCd = joCrrCd;
	}
	
	/**
	 * Column Info
	 * @param overWgt
	 */
	public void setOverWgt(String overWgt) {
		this.overWgt = overWgt;
	}
	
	/**
	 * Column Info
	 * @param allTeu
	 */
	public void setAllTeu(String allTeu) {
		this.allTeu = allTeu;
	}
	
	/**
	 * Column Info
	 * @param joRfOcnQty
	 */
	public void setJoRfOcnQty(String joRfOcnQty) {
		this.joRfOcnQty = joRfOcnQty;
	}
	
	/**
	 * Column Info
	 * @param overLongWt
	 */
	public void setOverLongWt(String overLongWt) {
		this.overLongWt = overLongWt;
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
	 * @param overLongTeu
	 */
	public void setOverLongTeu(String overLongTeu) {
		this.overLongTeu = overLongTeu;
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
	 * @param hidJoShrtLegRmkWgt
	 */
	public void setHidJoShrtLegRmkWgt(String hidJoShrtLegRmkWgt) {
		this.hidJoShrtLegRmkWgt = hidJoShrtLegRmkWgt;
	}
	
	/**
	 * Column Info
	 * @param source
	 */
	public void setSource(String source) {
		this.source = source;
	}
	
	/**
	 * Column Info
	 * @param oprCd
	 */
	public void setOprCd(String oprCd) {
		this.oprCd = oprCd;
	}
	
	/**
	 * Column Info
	 * @param grandTtlWgt
	 */
	public void setGrandTtlWgt(String grandTtlWgt) {
		this.grandTtlWgt = grandTtlWgt;
	}
	
	/**
	 * Column Info
	 * @param rfI
	 */
	public void setRfI(String rfI) {
		this.rfI = rfI;
	}
	
	/**
	 * Column Info
	 * @param reDivrCd
	 */
	public void setReDivrCd(String reDivrCd) {
		this.reDivrCd = reDivrCd;
	}
	
	/**
	 * Column Info
	 * @param hidJoShrtLegRmkTeuQty
	 */
	public void setHidJoShrtLegRmkTeuQty(String hidJoShrtLegRmkTeuQty) {
		this.hidJoShrtLegRmkTeuQty = hidJoShrtLegRmkTeuQty;
	}
	
	/**
	 * Column Info
	 * @param rfO
	 */
	public void setRfO(String rfO) {
		this.rfO = rfO;
	}
	
	/**
	 * Column Info
	 * @param allocTeu
	 */
	public void setAllocTeu(String allocTeu) {
		this.allocTeu = allocTeu;
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
		setJoVoidTeuQty(JSPUtil.getParameter(request, prefix + "jo_void_teu_qty", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setAdditionalCd(JSPUtil.getParameter(request, prefix + "additional_cd", ""));
		setRemark(JSPUtil.getParameter(request, prefix + "remark", ""));
		setAkJoVoidTeuQty(JSPUtil.getParameter(request, prefix + "ak_jo_void_teu_qty", ""));
		setActuWt(JSPUtil.getParameter(request, prefix + "actu_wt", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setMt40(JSPUtil.getParameter(request, prefix + "mt_40", ""));
		setAdd40hcTeu(JSPUtil.getParameter(request, prefix + "add_40hc_teu", ""));
		setHidJoShrtLegRmkSctrNm(JSPUtil.getParameter(request, prefix + "hid_jo_shrt_leg_rmk_sctr_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFull40(JSPUtil.getParameter(request, prefix + "full_40", ""));
		setPreFr(JSPUtil.getParameter(request, prefix + "pre_fr", ""));
		setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
		setJoAlocAdjRmkYn(JSPUtil.getParameter(request, prefix + "jo_aloc_adj_rmk_yn", ""));
		setActSlot(JSPUtil.getParameter(request, prefix + "act_slot", ""));
		setFull45(JSPUtil.getParameter(request, prefix + "full_45", ""));
		setIudFlag(JSPUtil.getParameter(request, prefix + "iud_flag", ""));
		setActuTeu(JSPUtil.getParameter(request, prefix + "actu_teu", ""));
		setHcLd40(JSPUtil.getParameter(request, prefix + "hc_ld_40", ""));
		setFull20hc(JSPUtil.getParameter(request, prefix + "full_20hc", ""));
		setJoRfIptQty(JSPUtil.getParameter(request, prefix + "jo_rf_ipt_qty", ""));
		setJoRgnCd(JSPUtil.getParameter(request, prefix + "jo_rgn_cd", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setSuperCd1(JSPUtil.getParameter(request, prefix + "super_cd1", ""));
		setAdd45Teu(JSPUtil.getParameter(request, prefix + "add_45_teu", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setGrandTtlSlot(JSPUtil.getParameter(request, prefix + "grand_ttl_slot", ""));
		setAkUnit(JSPUtil.getParameter(request, prefix + "ak_unit", ""));
		setEmptyWt(JSPUtil.getParameter(request, prefix + "empty_wt", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setPreTo(JSPUtil.getParameter(request, prefix + "pre_to", ""));
		setRemarkYn(JSPUtil.getParameter(request, prefix + "remark_yn", ""));
		setEmptyTeu(JSPUtil.getParameter(request, prefix + "empty_teu", ""));
		setRegion(JSPUtil.getParameter(request, prefix + "region", ""));
		setTotalTeu(JSPUtil.getParameter(request, prefix + "total_teu", ""));
		setJoShrtLegRmkWgt(JSPUtil.getParameter(request, prefix + "jo_shrt_leg_rmk_wgt", ""));
		setFull40hc(JSPUtil.getParameter(request, prefix + "full_40hc", ""));
		setHcLd20(JSPUtil.getParameter(request, prefix + "hc_ld_20", ""));
		setFull20(JSPUtil.getParameter(request, prefix + "full_20", ""));
		setAdd20hcTeu(JSPUtil.getParameter(request, prefix + "add_20hc_teu", ""));
		setAllWgt(JSPUtil.getParameter(request, prefix + "all_wgt", ""));
		setMtTeu(JSPUtil.getParameter(request, prefix + "mt_teu", ""));
		setOverSlot(JSPUtil.getParameter(request, prefix + "over_slot", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setJoAlocAdjWgt(JSPUtil.getParameter(request, prefix + "jo_aloc_adj_wgt", ""));
		setJoAlocAdjTeuQty(JSPUtil.getParameter(request, prefix + "jo_aloc_adj_teu_qty", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setAllocWt(JSPUtil.getParameter(request, prefix + "alloc_wt", ""));
		setMtWt(JSPUtil.getParameter(request, prefix + "mt_wt", ""));
		setJoAlocAdjRmk(JSPUtil.getParameter(request, prefix + "jo_aloc_adj_rmk", ""));
		setJoShrtLegRmkSctrNm(JSPUtil.getParameter(request, prefix + "jo_shrt_leg_rmk_sctr_nm", ""));
		setJoShrtLegRmkTeuQty(JSPUtil.getParameter(request, prefix + "jo_shrt_leg_rmk_teu_qty", ""));
		setJoCrrCd(JSPUtil.getParameter(request, prefix + "jo_crr_cd", ""));
		setOverWgt(JSPUtil.getParameter(request, prefix + "over_wgt", ""));
		setAllTeu(JSPUtil.getParameter(request, prefix + "all_teu", ""));
		setJoRfOcnQty(JSPUtil.getParameter(request, prefix + "jo_rf_ocn_qty", ""));
		setOverLongWt(JSPUtil.getParameter(request, prefix + "over_long_wt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setOverLongTeu(JSPUtil.getParameter(request, prefix + "over_long_teu", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setHidJoShrtLegRmkWgt(JSPUtil.getParameter(request, prefix + "hid_jo_shrt_leg_rmk_wgt", ""));
		setSource(JSPUtil.getParameter(request, prefix + "source", ""));
		setOprCd(JSPUtil.getParameter(request, prefix + "opr_cd", ""));
		setGrandTtlWgt(JSPUtil.getParameter(request, prefix + "grand_ttl_wgt", ""));
		setRfI(JSPUtil.getParameter(request, prefix + "rf_i", ""));
		setReDivrCd(JSPUtil.getParameter(request, prefix + "re_divr_cd", ""));
		setHidJoShrtLegRmkTeuQty(JSPUtil.getParameter(request, prefix + "hid_jo_shrt_leg_rmk_teu_qty", ""));
		setRfO(JSPUtil.getParameter(request, prefix + "rf_o", ""));
		setAllocTeu(JSPUtil.getParameter(request, prefix + "alloc_teu", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IntloadSumReportVO[]
	 */
	public IntloadSumReportVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IntloadSumReportVO[]
	 */
	public IntloadSumReportVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		IntloadSumReportVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] joVoidTeuQty = (JSPUtil.getParameter(request, prefix	+ "jo_void_teu_qty", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] additionalCd = (JSPUtil.getParameter(request, prefix	+ "additional_cd", length));
			String[] remark = (JSPUtil.getParameter(request, prefix	+ "remark", length));
			String[] akJoVoidTeuQty = (JSPUtil.getParameter(request, prefix	+ "ak_jo_void_teu_qty", length));
			String[] actuWt = (JSPUtil.getParameter(request, prefix	+ "actu_wt", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] mt40 = (JSPUtil.getParameter(request, prefix	+ "mt_40", length));
			String[] add40hcTeu = (JSPUtil.getParameter(request, prefix	+ "add_40hc_teu", length));
			String[] hidJoShrtLegRmkSctrNm = (JSPUtil.getParameter(request, prefix	+ "hid_jo_shrt_leg_rmk_sctr_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] full40 = (JSPUtil.getParameter(request, prefix	+ "full_40", length));
			String[] preFr = (JSPUtil.getParameter(request, prefix	+ "pre_fr", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] joAlocAdjRmkYn = (JSPUtil.getParameter(request, prefix	+ "jo_aloc_adj_rmk_yn", length));
			String[] actSlot = (JSPUtil.getParameter(request, prefix	+ "act_slot", length));
			String[] full45 = (JSPUtil.getParameter(request, prefix	+ "full_45", length));
			String[] iudFlag = (JSPUtil.getParameter(request, prefix	+ "iud_flag", length));
			String[] actuTeu = (JSPUtil.getParameter(request, prefix	+ "actu_teu", length));
			String[] hcLd40 = (JSPUtil.getParameter(request, prefix	+ "hc_ld_40", length));
			String[] full20hc = (JSPUtil.getParameter(request, prefix	+ "full_20hc", length));
			String[] joRfIptQty = (JSPUtil.getParameter(request, prefix	+ "jo_rf_ipt_qty", length));
			String[] joRgnCd = (JSPUtil.getParameter(request, prefix	+ "jo_rgn_cd", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] superCd1 = (JSPUtil.getParameter(request, prefix	+ "super_cd1", length));
			String[] add45Teu = (JSPUtil.getParameter(request, prefix	+ "add_45_teu", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] grandTtlSlot = (JSPUtil.getParameter(request, prefix	+ "grand_ttl_slot", length));
			String[] akUnit = (JSPUtil.getParameter(request, prefix	+ "ak_unit", length));
			String[] emptyWt = (JSPUtil.getParameter(request, prefix	+ "empty_wt", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] preTo = (JSPUtil.getParameter(request, prefix	+ "pre_to", length));
			String[] remarkYn = (JSPUtil.getParameter(request, prefix	+ "remark_yn", length));
			String[] emptyTeu = (JSPUtil.getParameter(request, prefix	+ "empty_teu", length));
			String[] region = (JSPUtil.getParameter(request, prefix	+ "region", length));
			String[] totalTeu = (JSPUtil.getParameter(request, prefix	+ "total_teu", length));
			String[] joShrtLegRmkWgt = (JSPUtil.getParameter(request, prefix	+ "jo_shrt_leg_rmk_wgt", length));
			String[] full40hc = (JSPUtil.getParameter(request, prefix	+ "full_40hc", length));
			String[] hcLd20 = (JSPUtil.getParameter(request, prefix	+ "hc_ld_20", length));
			String[] full20 = (JSPUtil.getParameter(request, prefix	+ "full_20", length));
			String[] add20hcTeu = (JSPUtil.getParameter(request, prefix	+ "add_20hc_teu", length));
			String[] allWgt = (JSPUtil.getParameter(request, prefix	+ "all_wgt", length));
			String[] mtTeu = (JSPUtil.getParameter(request, prefix	+ "mt_teu", length));
			String[] overSlot = (JSPUtil.getParameter(request, prefix	+ "over_slot", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] joAlocAdjWgt = (JSPUtil.getParameter(request, prefix	+ "jo_aloc_adj_wgt", length));
			String[] joAlocAdjTeuQty = (JSPUtil.getParameter(request, prefix	+ "jo_aloc_adj_teu_qty", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] allocWt = (JSPUtil.getParameter(request, prefix	+ "alloc_wt", length));
			String[] mtWt = (JSPUtil.getParameter(request, prefix	+ "mt_wt", length));
			String[] joAlocAdjRmk = (JSPUtil.getParameter(request, prefix	+ "jo_aloc_adj_rmk", length));
			String[] joShrtLegRmkSctrNm = (JSPUtil.getParameter(request, prefix	+ "jo_shrt_leg_rmk_sctr_nm", length));
			String[] joShrtLegRmkTeuQty = (JSPUtil.getParameter(request, prefix	+ "jo_shrt_leg_rmk_teu_qty", length));
			String[] joCrrCd = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd", length));
			String[] overWgt = (JSPUtil.getParameter(request, prefix	+ "over_wgt", length));
			String[] allTeu = (JSPUtil.getParameter(request, prefix	+ "all_teu", length));
			String[] joRfOcnQty = (JSPUtil.getParameter(request, prefix	+ "jo_rf_ocn_qty", length));
			String[] overLongWt = (JSPUtil.getParameter(request, prefix	+ "over_long_wt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] overLongTeu = (JSPUtil.getParameter(request, prefix	+ "over_long_teu", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] hidJoShrtLegRmkWgt = (JSPUtil.getParameter(request, prefix	+ "hid_jo_shrt_leg_rmk_wgt", length));
			String[] source = (JSPUtil.getParameter(request, prefix	+ "source", length));
			String[] oprCd = (JSPUtil.getParameter(request, prefix	+ "opr_cd", length));
			String[] grandTtlWgt = (JSPUtil.getParameter(request, prefix	+ "grand_ttl_wgt", length));
			String[] rfI = (JSPUtil.getParameter(request, prefix	+ "rf_i", length));
			String[] reDivrCd = (JSPUtil.getParameter(request, prefix	+ "re_divr_cd", length));
			String[] hidJoShrtLegRmkTeuQty = (JSPUtil.getParameter(request, prefix	+ "hid_jo_shrt_leg_rmk_teu_qty", length));
			String[] rfO = (JSPUtil.getParameter(request, prefix	+ "rf_o", length));
			String[] allocTeu = (JSPUtil.getParameter(request, prefix	+ "alloc_teu", length));
			
			for (int i = 0; i < length; i++) {
				model = new IntloadSumReportVO();
				if (joVoidTeuQty[i] != null)
					model.setJoVoidTeuQty(joVoidTeuQty[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (additionalCd[i] != null)
					model.setAdditionalCd(additionalCd[i]);
				if (remark[i] != null)
					model.setRemark(remark[i]);
				if (akJoVoidTeuQty[i] != null)
					model.setAkJoVoidTeuQty(akJoVoidTeuQty[i]);
				if (actuWt[i] != null)
					model.setActuWt(actuWt[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (mt40[i] != null)
					model.setMt40(mt40[i]);
				if (add40hcTeu[i] != null)
					model.setAdd40hcTeu(add40hcTeu[i]);
				if (hidJoShrtLegRmkSctrNm[i] != null)
					model.setHidJoShrtLegRmkSctrNm(hidJoShrtLegRmkSctrNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (full40[i] != null)
					model.setFull40(full40[i]);
				if (preFr[i] != null)
					model.setPreFr(preFr[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (joAlocAdjRmkYn[i] != null)
					model.setJoAlocAdjRmkYn(joAlocAdjRmkYn[i]);
				if (actSlot[i] != null)
					model.setActSlot(actSlot[i]);
				if (full45[i] != null)
					model.setFull45(full45[i]);
				if (iudFlag[i] != null)
					model.setIudFlag(iudFlag[i]);
				if (actuTeu[i] != null)
					model.setActuTeu(actuTeu[i]);
				if (hcLd40[i] != null)
					model.setHcLd40(hcLd40[i]);
				if (full20hc[i] != null)
					model.setFull20hc(full20hc[i]);
				if (joRfIptQty[i] != null)
					model.setJoRfIptQty(joRfIptQty[i]);
				if (joRgnCd[i] != null)
					model.setJoRgnCd(joRgnCd[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (superCd1[i] != null)
					model.setSuperCd1(superCd1[i]);
				if (add45Teu[i] != null)
					model.setAdd45Teu(add45Teu[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (grandTtlSlot[i] != null)
					model.setGrandTtlSlot(grandTtlSlot[i]);
				if (akUnit[i] != null)
					model.setAkUnit(akUnit[i]);
				if (emptyWt[i] != null)
					model.setEmptyWt(emptyWt[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (preTo[i] != null)
					model.setPreTo(preTo[i]);
				if (remarkYn[i] != null)
					model.setRemarkYn(remarkYn[i]);
				if (emptyTeu[i] != null)
					model.setEmptyTeu(emptyTeu[i]);
				if (region[i] != null)
					model.setRegion(region[i]);
				if (totalTeu[i] != null)
					model.setTotalTeu(totalTeu[i]);
				if (joShrtLegRmkWgt[i] != null)
					model.setJoShrtLegRmkWgt(joShrtLegRmkWgt[i]);
				if (full40hc[i] != null)
					model.setFull40hc(full40hc[i]);
				if (hcLd20[i] != null)
					model.setHcLd20(hcLd20[i]);
				if (full20[i] != null)
					model.setFull20(full20[i]);
				if (add20hcTeu[i] != null)
					model.setAdd20hcTeu(add20hcTeu[i]);
				if (allWgt[i] != null)
					model.setAllWgt(allWgt[i]);
				if (mtTeu[i] != null)
					model.setMtTeu(mtTeu[i]);
				if (overSlot[i] != null)
					model.setOverSlot(overSlot[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (joAlocAdjWgt[i] != null)
					model.setJoAlocAdjWgt(joAlocAdjWgt[i]);
				if (joAlocAdjTeuQty[i] != null)
					model.setJoAlocAdjTeuQty(joAlocAdjTeuQty[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (allocWt[i] != null)
					model.setAllocWt(allocWt[i]);
				if (mtWt[i] != null)
					model.setMtWt(mtWt[i]);
				if (joAlocAdjRmk[i] != null)
					model.setJoAlocAdjRmk(joAlocAdjRmk[i]);
				if (joShrtLegRmkSctrNm[i] != null)
					model.setJoShrtLegRmkSctrNm(joShrtLegRmkSctrNm[i]);
				if (joShrtLegRmkTeuQty[i] != null)
					model.setJoShrtLegRmkTeuQty(joShrtLegRmkTeuQty[i]);
				if (joCrrCd[i] != null)
					model.setJoCrrCd(joCrrCd[i]);
				if (overWgt[i] != null)
					model.setOverWgt(overWgt[i]);
				if (allTeu[i] != null)
					model.setAllTeu(allTeu[i]);
				if (joRfOcnQty[i] != null)
					model.setJoRfOcnQty(joRfOcnQty[i]);
				if (overLongWt[i] != null)
					model.setOverLongWt(overLongWt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (overLongTeu[i] != null)
					model.setOverLongTeu(overLongTeu[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (hidJoShrtLegRmkWgt[i] != null)
					model.setHidJoShrtLegRmkWgt(hidJoShrtLegRmkWgt[i]);
				if (source[i] != null)
					model.setSource(source[i]);
				if (oprCd[i] != null)
					model.setOprCd(oprCd[i]);
				if (grandTtlWgt[i] != null)
					model.setGrandTtlWgt(grandTtlWgt[i]);
				if (rfI[i] != null)
					model.setRfI(rfI[i]);
				if (reDivrCd[i] != null)
					model.setReDivrCd(reDivrCd[i]);
				if (hidJoShrtLegRmkTeuQty[i] != null)
					model.setHidJoShrtLegRmkTeuQty(hidJoShrtLegRmkTeuQty[i]);
				if (rfO[i] != null)
					model.setRfO(rfO[i]);
				if (allocTeu[i] != null)
					model.setAllocTeu(allocTeu[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getIntloadSumReportVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return IntloadSumReportVO[]
	 */
	public IntloadSumReportVO[] getIntloadSumReportVOs(){
		IntloadSumReportVO[] vos = (IntloadSumReportVO[])models.toArray(new IntloadSumReportVO[models.size()]);
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
		this.joVoidTeuQty = this.joVoidTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.additionalCd = this.additionalCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark = this.remark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.akJoVoidTeuQty = this.akJoVoidTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actuWt = this.actuWt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mt40 = this.mt40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.add40hcTeu = this.add40hcTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidJoShrtLegRmkSctrNm = this.hidJoShrtLegRmkSctrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.full40 = this.full40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preFr = this.preFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joAlocAdjRmkYn = this.joAlocAdjRmkYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actSlot = this.actSlot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.full45 = this.full45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iudFlag = this.iudFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actuTeu = this.actuTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcLd40 = this.hcLd40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.full20hc = this.full20hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joRfIptQty = this.joRfIptQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joRgnCd = this.joRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.superCd1 = this.superCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.add45Teu = this.add45Teu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grandTtlSlot = this.grandTtlSlot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.akUnit = this.akUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emptyWt = this.emptyWt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preTo = this.preTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remarkYn = this.remarkYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emptyTeu = this.emptyTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.region = this.region .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalTeu = this.totalTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joShrtLegRmkWgt = this.joShrtLegRmkWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.full40hc = this.full40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcLd20 = this.hcLd20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.full20 = this.full20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.add20hcTeu = this.add20hcTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.allWgt = this.allWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtTeu = this.mtTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overSlot = this.overSlot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joAlocAdjWgt = this.joAlocAdjWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joAlocAdjTeuQty = this.joAlocAdjTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.allocWt = this.allocWt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtWt = this.mtWt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joAlocAdjRmk = this.joAlocAdjRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joShrtLegRmkSctrNm = this.joShrtLegRmkSctrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joShrtLegRmkTeuQty = this.joShrtLegRmkTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrCd = this.joCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overWgt = this.overWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.allTeu = this.allTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joRfOcnQty = this.joRfOcnQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overLongWt = this.overLongWt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overLongTeu = this.overLongTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidJoShrtLegRmkWgt = this.hidJoShrtLegRmkWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.source = this.source .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oprCd = this.oprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grandTtlWgt = this.grandTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfI = this.rfI .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reDivrCd = this.reDivrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidJoShrtLegRmkTeuQty = this.hidJoShrtLegRmkTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfO = this.rfO .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.allocTeu = this.allocTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
