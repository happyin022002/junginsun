/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VesselLoadableInfoVO.java
*@FileTitle : VesselLoadableInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.12
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.12  
* 1.0 Creation
* 
* 2014.03.17 박다은 [CHM-201428939-01] vessel particular - performance
* 2014.04.16 박다은 [CHM-201429675-01] Voyage Performance내 Lane Code 구분 
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo;

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

public class VesselLoadableInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VesselLoadableInfoVO> models = new ArrayList<VesselLoadableInfoVO>();
	
	/* Column Info */
	private String hdHulTtlWgt = null;
	/* Column Info */
	private String hdHulHcDeckQty = null;
	/* Column Info */
	private String bakHulNewSltRt = null;
	/* Column Info */
	private String bakHulInclIcrzQty = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String bakHulXcldIcrzQty = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String hdHulXcldIcrzQty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bakHulActUtWgt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bakHulHcDeckQty = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String bakHulHcXcldQty = null;
	/* Column Info */
	private String hdHulCrntSltRt = null;
	/* Column Info */
	private String ldbCapaRmk = null;
	/* Column Info */
	private String hdHulActUtWgt = null;
	/* Column Info */
	private String hdHulNewSltRt = null;
	/* Column Info */
	private String capaSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String hdHulInclIcrzQty = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String ttlBsaWgt = null;
	/* Column Info */
	private String hcXcldBsaQty = null;
	/* Column Info */
	private String bakHulNewWgtRt = null;
	/* Column Info */
	private String hdHulHcXcldQty = null;
	/* Column Info */
	private String bakHulHcInclQty = null;
	/* Column Info */
	private String bakHulTtlWgt = null;
	/* Column Info */
	private String actBsaUtWgt = null;
	/* Column Info */
	private String ctrtBsaUtWgt = null;
	/* Column Info */
	private String hcInclBsaQty = null;
	/* Column Info */
	private String maxCgoSmrMtWgt = null;
	/* Column Info */
	private String cntrDznCapa = null;
	/* Column Info */
	private String hdHulNewWgtRt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String hdHulHcInclQty = null;
	/* Column Info */
	private String hdHulHcHldQty = null;
	/* Column Info */
	private String bakHulCrntSltRt = null;
	/* Column Info */
	private String bakHulHcHldQty = null;
	/* Column Info */
	private String vslSlanCtnt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VesselLoadableInfoVO() {}

	public VesselLoadableInfoVO(String ibflag, String pagerows, String vslSlanCd, String capaSeq, String trdCd, String cntrDznCapa, String maxCgoSmrMtWgt, String hcInclBsaQty, String hcXcldBsaQty, String ctrtBsaUtWgt, String actBsaUtWgt, String ttlBsaWgt, String hdHulHcHldQty, String hdHulHcDeckQty, String hdHulHcInclQty, String hdHulHcXcldQty, String hdHulActUtWgt, String hdHulTtlWgt, String hdHulCrntSltRt, String hdHulNewSltRt, String hdHulNewWgtRt, String hdHulInclIcrzQty, String hdHulXcldIcrzQty, String bakHulHcHldQty, String bakHulHcDeckQty, String bakHulHcInclQty, String bakHulHcXcldQty, String bakHulActUtWgt, String bakHulTtlWgt, String bakHulCrntSltRt, String bakHulNewSltRt, String bakHulNewWgtRt, String bakHulInclIcrzQty, String bakHulXcldIcrzQty, String ldbCapaRmk, String usrId, String creUsrId, String creDt, String updUsrId, String updDt, String vslSlanCtnt) {
		this.hdHulTtlWgt = hdHulTtlWgt;
		this.hdHulHcDeckQty = hdHulHcDeckQty;
		this.bakHulNewSltRt = bakHulNewSltRt;
		this.bakHulInclIcrzQty = bakHulInclIcrzQty;
		this.creDt = creDt;
		this.trdCd = trdCd;
		this.bakHulXcldIcrzQty = bakHulXcldIcrzQty;
		this.vslSlanCd = vslSlanCd;
		this.hdHulXcldIcrzQty = hdHulXcldIcrzQty;
		this.pagerows = pagerows;
		this.bakHulActUtWgt = bakHulActUtWgt;
		this.ibflag = ibflag;
		this.bakHulHcDeckQty = bakHulHcDeckQty;
		this.usrId = usrId;
		this.bakHulHcXcldQty = bakHulHcXcldQty;
		this.hdHulCrntSltRt = hdHulCrntSltRt;
		this.ldbCapaRmk = ldbCapaRmk;
		this.hdHulActUtWgt = hdHulActUtWgt;
		this.hdHulNewSltRt = hdHulNewSltRt;
		this.capaSeq = capaSeq;
		this.updUsrId = updUsrId;
		this.hdHulInclIcrzQty = hdHulInclIcrzQty;
		this.updDt = updDt;
		this.ttlBsaWgt = ttlBsaWgt;
		this.hcXcldBsaQty = hcXcldBsaQty;
		this.bakHulNewWgtRt = bakHulNewWgtRt;
		this.hdHulHcXcldQty = hdHulHcXcldQty;
		this.bakHulHcInclQty = bakHulHcInclQty;
		this.bakHulTtlWgt = bakHulTtlWgt;
		this.actBsaUtWgt = actBsaUtWgt;
		this.ctrtBsaUtWgt = ctrtBsaUtWgt;
		this.hcInclBsaQty = hcInclBsaQty;
		this.maxCgoSmrMtWgt = maxCgoSmrMtWgt;
		this.cntrDznCapa = cntrDznCapa;
		this.hdHulNewWgtRt = hdHulNewWgtRt;
		this.creUsrId = creUsrId;
		this.hdHulHcInclQty = hdHulHcInclQty;
		this.hdHulHcHldQty = hdHulHcHldQty;
		this.bakHulCrntSltRt = bakHulCrntSltRt;
		this.bakHulHcHldQty = bakHulHcHldQty;
		this.vslSlanCtnt = vslSlanCtnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("hd_hul_ttl_wgt", getHdHulTtlWgt());
		this.hashColumns.put("hd_hul_hc_deck_qty", getHdHulHcDeckQty());
		this.hashColumns.put("bak_hul_new_slt_rt", getBakHulNewSltRt());
		this.hashColumns.put("bak_hul_incl_icrz_qty", getBakHulInclIcrzQty());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("bak_hul_xcld_icrz_qty", getBakHulXcldIcrzQty());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("hd_hul_xcld_icrz_qty", getHdHulXcldIcrzQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bak_hul_act_ut_wgt", getBakHulActUtWgt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bak_hul_hc_deck_qty", getBakHulHcDeckQty());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("bak_hul_hc_xcld_qty", getBakHulHcXcldQty());
		this.hashColumns.put("hd_hul_crnt_slt_rt", getHdHulCrntSltRt());
		this.hashColumns.put("ldb_capa_rmk", getLdbCapaRmk());
		this.hashColumns.put("hd_hul_act_ut_wgt", getHdHulActUtWgt());
		this.hashColumns.put("hd_hul_new_slt_rt", getHdHulNewSltRt());
		this.hashColumns.put("capa_seq", getCapaSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("hd_hul_incl_icrz_qty", getHdHulInclIcrzQty());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ttl_bsa_wgt", getTtlBsaWgt());
		this.hashColumns.put("hc_xcld_bsa_qty", getHcXcldBsaQty());
		this.hashColumns.put("bak_hul_new_wgt_rt", getBakHulNewWgtRt());
		this.hashColumns.put("hd_hul_hc_xcld_qty", getHdHulHcXcldQty());
		this.hashColumns.put("bak_hul_hc_incl_qty", getBakHulHcInclQty());
		this.hashColumns.put("bak_hul_ttl_wgt", getBakHulTtlWgt());
		this.hashColumns.put("act_bsa_ut_wgt", getActBsaUtWgt());
		this.hashColumns.put("ctrt_bsa_ut_wgt", getCtrtBsaUtWgt());
		this.hashColumns.put("hc_incl_bsa_qty", getHcInclBsaQty());
		this.hashColumns.put("max_cgo_smr_mt_wgt", getMaxCgoSmrMtWgt());
		this.hashColumns.put("cntr_dzn_capa", getCntrDznCapa());
		this.hashColumns.put("hd_hul_new_wgt_rt", getHdHulNewWgtRt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("hd_hul_hc_incl_qty", getHdHulHcInclQty());
		this.hashColumns.put("hd_hul_hc_hld_qty", getHdHulHcHldQty());
		this.hashColumns.put("bak_hul_crnt_slt_rt", getBakHulCrntSltRt());
		this.hashColumns.put("bak_hul_hc_hld_qty", getBakHulHcHldQty());
		this.hashColumns.put("vsl_slan_ctnt", getVslSlanCtnt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("hd_hul_ttl_wgt", "hdHulTtlWgt");
		this.hashFields.put("hd_hul_hc_deck_qty", "hdHulHcDeckQty");
		this.hashFields.put("bak_hul_new_slt_rt", "bakHulNewSltRt");
		this.hashFields.put("bak_hul_incl_icrz_qty", "bakHulInclIcrzQty");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("bak_hul_xcld_icrz_qty", "bakHulXcldIcrzQty");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("hd_hul_xcld_icrz_qty", "hdHulXcldIcrzQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bak_hul_act_ut_wgt", "bakHulActUtWgt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bak_hul_hc_deck_qty", "bakHulHcDeckQty");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("bak_hul_hc_xcld_qty", "bakHulHcXcldQty");
		this.hashFields.put("hd_hul_crnt_slt_rt", "hdHulCrntSltRt");
		this.hashFields.put("ldb_capa_rmk", "ldbCapaRmk");
		this.hashFields.put("hd_hul_act_ut_wgt", "hdHulActUtWgt");
		this.hashFields.put("hd_hul_new_slt_rt", "hdHulNewSltRt");
		this.hashFields.put("capa_seq", "capaSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("hd_hul_incl_icrz_qty", "hdHulInclIcrzQty");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ttl_bsa_wgt", "ttlBsaWgt");
		this.hashFields.put("hc_xcld_bsa_qty", "hcXcldBsaQty");
		this.hashFields.put("bak_hul_new_wgt_rt", "bakHulNewWgtRt");
		this.hashFields.put("hd_hul_hc_xcld_qty", "hdHulHcXcldQty");
		this.hashFields.put("bak_hul_hc_incl_qty", "bakHulHcInclQty");
		this.hashFields.put("bak_hul_ttl_wgt", "bakHulTtlWgt");
		this.hashFields.put("act_bsa_ut_wgt", "actBsaUtWgt");
		this.hashFields.put("ctrt_bsa_ut_wgt", "ctrtBsaUtWgt");
		this.hashFields.put("hc_incl_bsa_qty", "hcInclBsaQty");
		this.hashFields.put("max_cgo_smr_mt_wgt", "maxCgoSmrMtWgt");
		this.hashFields.put("cntr_dzn_capa", "cntrDznCapa");
		this.hashFields.put("hd_hul_new_wgt_rt", "hdHulNewWgtRt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("hd_hul_hc_incl_qty", "hdHulHcInclQty");
		this.hashFields.put("hd_hul_hc_hld_qty", "hdHulHcHldQty");
		this.hashFields.put("bak_hul_crnt_slt_rt", "bakHulCrntSltRt");
		this.hashFields.put("bak_hul_hc_hld_qty", "bakHulHcHldQty");
		this.hashFields.put("vsl_slan_ctnt", "vslSlanCtnt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return hdHulTtlWgt
	 */
	public String getHdHulTtlWgt() {
		return this.hdHulTtlWgt;
	}
	
	/**
	 * Column Info
	 * @return hdHulHcDeckQty
	 */
	public String getHdHulHcDeckQty() {
		return this.hdHulHcDeckQty;
	}
	
	/**
	 * Column Info
	 * @return bakHulNewSltRt
	 */
	public String getBakHulNewSltRt() {
		return this.bakHulNewSltRt;
	}
	
	/**
	 * Column Info
	 * @return bakHulInclIcrzQty
	 */
	public String getBakHulInclIcrzQty() {
		return this.bakHulInclIcrzQty;
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
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return bakHulXcldIcrzQty
	 */
	public String getBakHulXcldIcrzQty() {
		return this.bakHulXcldIcrzQty;
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
	 * @return hdHulXcldIcrzQty
	 */
	public String getHdHulXcldIcrzQty() {
		return this.hdHulXcldIcrzQty;
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
	 * @return bakHulActUtWgt
	 */
	public String getBakHulActUtWgt() {
		return this.bakHulActUtWgt;
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
	 * @return bakHulHcDeckQty
	 */
	public String getBakHulHcDeckQty() {
		return this.bakHulHcDeckQty;
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
	 * @return bakHulHcXcldQty
	 */
	public String getBakHulHcXcldQty() {
		return this.bakHulHcXcldQty;
	}
	
	/**
	 * Column Info
	 * @return hdHulCrntSltRt
	 */
	public String getHdHulCrntSltRt() {
		return this.hdHulCrntSltRt;
	}
	
	/**
	 * Column Info
	 * @return ldbCapaRmk
	 */
	public String getLdbCapaRmk() {
		return this.ldbCapaRmk;
	}
	
	/**
	 * Column Info
	 * @return hdHulActUtWgt
	 */
	public String getHdHulActUtWgt() {
		return this.hdHulActUtWgt;
	}
	
	/**
	 * Column Info
	 * @return hdHulNewSltRt
	 */
	public String getHdHulNewSltRt() {
		return this.hdHulNewSltRt;
	}
	
	/**
	 * Column Info
	 * @return capaSeq
	 */
	public String getCapaSeq() {
		return this.capaSeq;
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
	 * @return hdHulInclIcrzQty
	 */
	public String getHdHulInclIcrzQty() {
		return this.hdHulInclIcrzQty;
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
	 * @return ttlBsaWgt
	 */
	public String getTtlBsaWgt() {
		return this.ttlBsaWgt;
	}
	
	/**
	 * Column Info
	 * @return hcXcldBsaQty
	 */
	public String getHcXcldBsaQty() {
		return this.hcXcldBsaQty;
	}
	
	/**
	 * Column Info
	 * @return bakHulNewWgtRt
	 */
	public String getBakHulNewWgtRt() {
		return this.bakHulNewWgtRt;
	}
	
	/**
	 * Column Info
	 * @return hdHulHcXcldQty
	 */
	public String getHdHulHcXcldQty() {
		return this.hdHulHcXcldQty;
	}
	
	/**
	 * Column Info
	 * @return bakHulHcInclQty
	 */
	public String getBakHulHcInclQty() {
		return this.bakHulHcInclQty;
	}
	
	/**
	 * Column Info
	 * @return bakHulTtlWgt
	 */
	public String getBakHulTtlWgt() {
		return this.bakHulTtlWgt;
	}
	
	/**
	 * Column Info
	 * @return actBsaUtWgt
	 */
	public String getActBsaUtWgt() {
		return this.actBsaUtWgt;
	}
	
	/**
	 * Column Info
	 * @return ctrtBsaUtWgt
	 */
	public String getCtrtBsaUtWgt() {
		return this.ctrtBsaUtWgt;
	}
	
	/**
	 * Column Info
	 * @return hcInclBsaQty
	 */
	public String getHcInclBsaQty() {
		return this.hcInclBsaQty;
	}
	
	/**
	 * Column Info
	 * @return maxCgoSmrMtWgt
	 */
	public String getMaxCgoSmrMtWgt() {
		return this.maxCgoSmrMtWgt;
	}
	
	/**
	 * Column Info
	 * @return cntrDznCapa
	 */
	public String getCntrDznCapa() {
		return this.cntrDznCapa;
	}
	
	/**
	 * Column Info
	 * @return hdHulNewWgtRt
	 */
	public String getHdHulNewWgtRt() {
		return this.hdHulNewWgtRt;
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
	 * @return hdHulHcInclQty
	 */
	public String getHdHulHcInclQty() {
		return this.hdHulHcInclQty;
	}
	
	/**
	 * Column Info
	 * @return hdHulHcHldQty
	 */
	public String getHdHulHcHldQty() {
		return this.hdHulHcHldQty;
	}
	
	/**
	 * Column Info
	 * @return bakHulCrntSltRt
	 */
	public String getBakHulCrntSltRt() {
		return this.bakHulCrntSltRt;
	}
	
	/**
	 * Column Info
	 * @return bakHulHcHldQty
	 */
	public String getBakHulHcHldQty() {
		return this.bakHulHcHldQty;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCtnt
	 */
	public String getVslSlanCtnt() {
		return this.vslSlanCtnt;
	}
	

	/**
	 * Column Info
	 * @param hdHulTtlWgt
	 */
	public void setHdHulTtlWgt(String hdHulTtlWgt) {
		this.hdHulTtlWgt = hdHulTtlWgt;
	}
	
	/**
	 * Column Info
	 * @param hdHulHcDeckQty
	 */
	public void setHdHulHcDeckQty(String hdHulHcDeckQty) {
		this.hdHulHcDeckQty = hdHulHcDeckQty;
	}
	
	/**
	 * Column Info
	 * @param bakHulNewSltRt
	 */
	public void setBakHulNewSltRt(String bakHulNewSltRt) {
		this.bakHulNewSltRt = bakHulNewSltRt;
	}
	
	/**
	 * Column Info
	 * @param bakHulInclIcrzQty
	 */
	public void setBakHulInclIcrzQty(String bakHulInclIcrzQty) {
		this.bakHulInclIcrzQty = bakHulInclIcrzQty;
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
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param bakHulXcldIcrzQty
	 */
	public void setBakHulXcldIcrzQty(String bakHulXcldIcrzQty) {
		this.bakHulXcldIcrzQty = bakHulXcldIcrzQty;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param hdHulXcldIcrzQty
	 */
	public void setHdHulXcldIcrzQty(String hdHulXcldIcrzQty) {
		this.hdHulXcldIcrzQty = hdHulXcldIcrzQty;
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
	 * @param bakHulActUtWgt
	 */
	public void setBakHulActUtWgt(String bakHulActUtWgt) {
		this.bakHulActUtWgt = bakHulActUtWgt;
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
	 * @param bakHulHcDeckQty
	 */
	public void setBakHulHcDeckQty(String bakHulHcDeckQty) {
		this.bakHulHcDeckQty = bakHulHcDeckQty;
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
	 * @param bakHulHcXcldQty
	 */
	public void setBakHulHcXcldQty(String bakHulHcXcldQty) {
		this.bakHulHcXcldQty = bakHulHcXcldQty;
	}
	
	/**
	 * Column Info
	 * @param hdHulCrntSltRt
	 */
	public void setHdHulCrntSltRt(String hdHulCrntSltRt) {
		this.hdHulCrntSltRt = hdHulCrntSltRt;
	}
	
	/**
	 * Column Info
	 * @param ldbCapaRmk
	 */
	public void setLdbCapaRmk(String ldbCapaRmk) {
		this.ldbCapaRmk = ldbCapaRmk;
	}
	
	/**
	 * Column Info
	 * @param hdHulActUtWgt
	 */
	public void setHdHulActUtWgt(String hdHulActUtWgt) {
		this.hdHulActUtWgt = hdHulActUtWgt;
	}
	
	/**
	 * Column Info
	 * @param hdHulNewSltRt
	 */
	public void setHdHulNewSltRt(String hdHulNewSltRt) {
		this.hdHulNewSltRt = hdHulNewSltRt;
	}
	
	/**
	 * Column Info
	 * @param capaSeq
	 */
	public void setCapaSeq(String capaSeq) {
		this.capaSeq = capaSeq;
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
	 * @param hdHulInclIcrzQty
	 */
	public void setHdHulInclIcrzQty(String hdHulInclIcrzQty) {
		this.hdHulInclIcrzQty = hdHulInclIcrzQty;
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
	 * @param ttlBsaWgt
	 */
	public void setTtlBsaWgt(String ttlBsaWgt) {
		this.ttlBsaWgt = ttlBsaWgt;
	}
	
	/**
	 * Column Info
	 * @param hcXcldBsaQty
	 */
	public void setHcXcldBsaQty(String hcXcldBsaQty) {
		this.hcXcldBsaQty = hcXcldBsaQty;
	}
	
	/**
	 * Column Info
	 * @param bakHulNewWgtRt
	 */
	public void setBakHulNewWgtRt(String bakHulNewWgtRt) {
		this.bakHulNewWgtRt = bakHulNewWgtRt;
	}
	
	/**
	 * Column Info
	 * @param hdHulHcXcldQty
	 */
	public void setHdHulHcXcldQty(String hdHulHcXcldQty) {
		this.hdHulHcXcldQty = hdHulHcXcldQty;
	}
	
	/**
	 * Column Info
	 * @param bakHulHcInclQty
	 */
	public void setBakHulHcInclQty(String bakHulHcInclQty) {
		this.bakHulHcInclQty = bakHulHcInclQty;
	}
	
	/**
	 * Column Info
	 * @param bakHulTtlWgt
	 */
	public void setBakHulTtlWgt(String bakHulTtlWgt) {
		this.bakHulTtlWgt = bakHulTtlWgt;
	}
	
	/**
	 * Column Info
	 * @param actBsaUtWgt
	 */
	public void setActBsaUtWgt(String actBsaUtWgt) {
		this.actBsaUtWgt = actBsaUtWgt;
	}
	
	/**
	 * Column Info
	 * @param ctrtBsaUtWgt
	 */
	public void setCtrtBsaUtWgt(String ctrtBsaUtWgt) {
		this.ctrtBsaUtWgt = ctrtBsaUtWgt;
	}
	
	/**
	 * Column Info
	 * @param hcInclBsaQty
	 */
	public void setHcInclBsaQty(String hcInclBsaQty) {
		this.hcInclBsaQty = hcInclBsaQty;
	}
	
	/**
	 * Column Info
	 * @param maxCgoSmrMtWgt
	 */
	public void setMaxCgoSmrMtWgt(String maxCgoSmrMtWgt) {
		this.maxCgoSmrMtWgt = maxCgoSmrMtWgt;
	}
	
	/**
	 * Column Info
	 * @param cntrDznCapa
	 */
	public void setCntrDznCapa(String cntrDznCapa) {
		this.cntrDznCapa = cntrDznCapa;
	}
	
	/**
	 * Column Info
	 * @param hdHulNewWgtRt
	 */
	public void setHdHulNewWgtRt(String hdHulNewWgtRt) {
		this.hdHulNewWgtRt = hdHulNewWgtRt;
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
	 * @param hdHulHcInclQty
	 */
	public void setHdHulHcInclQty(String hdHulHcInclQty) {
		this.hdHulHcInclQty = hdHulHcInclQty;
	}
	
	/**
	 * Column Info
	 * @param hdHulHcHldQty
	 */
	public void setHdHulHcHldQty(String hdHulHcHldQty) {
		this.hdHulHcHldQty = hdHulHcHldQty;
	}
	
	/**
	 * Column Info
	 * @param bakHulCrntSltRt
	 */
	public void setBakHulCrntSltRt(String bakHulCrntSltRt) {
		this.bakHulCrntSltRt = bakHulCrntSltRt;
	}
	
	/**
	 * Column Info
	 * @param bakHulHcHldQty
	 */
	public void setBakHulHcHldQty(String bakHulHcHldQty) {
		this.bakHulHcHldQty = bakHulHcHldQty;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCtnt
	 */
	public void setVslSlanCtnt(String vslSlanCtnt) {
		this.vslSlanCtnt = vslSlanCtnt;
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
		setHdHulTtlWgt(JSPUtil.getParameter(request, prefix + "hd_hul_ttl_wgt", ""));
		setHdHulHcDeckQty(JSPUtil.getParameter(request, prefix + "hd_hul_hc_deck_qty", ""));
		setBakHulNewSltRt(JSPUtil.getParameter(request, prefix + "bak_hul_new_slt_rt", ""));
		setBakHulInclIcrzQty(JSPUtil.getParameter(request, prefix + "bak_hul_incl_icrz_qty", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setBakHulXcldIcrzQty(JSPUtil.getParameter(request, prefix + "bak_hul_xcld_icrz_qty", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setHdHulXcldIcrzQty(JSPUtil.getParameter(request, prefix + "hd_hul_xcld_icrz_qty", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBakHulActUtWgt(JSPUtil.getParameter(request, prefix + "bak_hul_act_ut_wgt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBakHulHcDeckQty(JSPUtil.getParameter(request, prefix + "bak_hul_hc_deck_qty", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setBakHulHcXcldQty(JSPUtil.getParameter(request, prefix + "bak_hul_hc_xcld_qty", ""));
		setHdHulCrntSltRt(JSPUtil.getParameter(request, prefix + "hd_hul_crnt_slt_rt", ""));
		setLdbCapaRmk(JSPUtil.getParameter(request, prefix + "ldb_capa_rmk", ""));
		setHdHulActUtWgt(JSPUtil.getParameter(request, prefix + "hd_hul_act_ut_wgt", ""));
		setHdHulNewSltRt(JSPUtil.getParameter(request, prefix + "hd_hul_new_slt_rt", ""));
		setCapaSeq(JSPUtil.getParameter(request, prefix + "capa_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setHdHulInclIcrzQty(JSPUtil.getParameter(request, prefix + "hd_hul_incl_icrz_qty", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setTtlBsaWgt(JSPUtil.getParameter(request, prefix + "ttl_bsa_wgt", ""));
		setHcXcldBsaQty(JSPUtil.getParameter(request, prefix + "hc_xcld_bsa_qty", ""));
		setBakHulNewWgtRt(JSPUtil.getParameter(request, prefix + "bak_hul_new_wgt_rt", ""));
		setHdHulHcXcldQty(JSPUtil.getParameter(request, prefix + "hd_hul_hc_xcld_qty", ""));
		setBakHulHcInclQty(JSPUtil.getParameter(request, prefix + "bak_hul_hc_incl_qty", ""));
		setBakHulTtlWgt(JSPUtil.getParameter(request, prefix + "bak_hul_ttl_wgt", ""));
		setActBsaUtWgt(JSPUtil.getParameter(request, prefix + "act_bsa_ut_wgt", ""));
		setCtrtBsaUtWgt(JSPUtil.getParameter(request, prefix + "ctrt_bsa_ut_wgt", ""));
		setHcInclBsaQty(JSPUtil.getParameter(request, prefix + "hc_incl_bsa_qty", ""));
		setMaxCgoSmrMtWgt(JSPUtil.getParameter(request, prefix + "max_cgo_smr_mt_wgt", ""));
		setCntrDznCapa(JSPUtil.getParameter(request, prefix + "cntr_dzn_capa", ""));
		setHdHulNewWgtRt(JSPUtil.getParameter(request, prefix + "hd_hul_new_wgt_rt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setHdHulHcInclQty(JSPUtil.getParameter(request, prefix + "hd_hul_hc_incl_qty", ""));
		setHdHulHcHldQty(JSPUtil.getParameter(request, prefix + "hd_hul_hc_hld_qty", ""));
		setBakHulCrntSltRt(JSPUtil.getParameter(request, prefix + "bak_hul_crnt_slt_rt", ""));
		setBakHulHcHldQty(JSPUtil.getParameter(request, prefix + "bak_hul_hc_hld_qty", ""));
		setVslSlanCtnt(JSPUtil.getParameter(request, prefix + "vsl_slan_ctnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VesselLoadableInfoVO[]
	 */
	public VesselLoadableInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VesselLoadableInfoVO[]
	 */
	public VesselLoadableInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VesselLoadableInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] hdHulTtlWgt = (JSPUtil.getParameter(request, prefix	+ "hd_hul_ttl_wgt", length));
			String[] hdHulHcDeckQty = (JSPUtil.getParameter(request, prefix	+ "hd_hul_hc_deck_qty", length));
			String[] bakHulNewSltRt = (JSPUtil.getParameter(request, prefix	+ "bak_hul_new_slt_rt", length));
			String[] bakHulInclIcrzQty = (JSPUtil.getParameter(request, prefix	+ "bak_hul_incl_icrz_qty", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] bakHulXcldIcrzQty = (JSPUtil.getParameter(request, prefix	+ "bak_hul_xcld_icrz_qty", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] hdHulXcldIcrzQty = (JSPUtil.getParameter(request, prefix	+ "hd_hul_xcld_icrz_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bakHulActUtWgt = (JSPUtil.getParameter(request, prefix	+ "bak_hul_act_ut_wgt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bakHulHcDeckQty = (JSPUtil.getParameter(request, prefix	+ "bak_hul_hc_deck_qty", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] bakHulHcXcldQty = (JSPUtil.getParameter(request, prefix	+ "bak_hul_hc_xcld_qty", length));
			String[] hdHulCrntSltRt = (JSPUtil.getParameter(request, prefix	+ "hd_hul_crnt_slt_rt", length));
			String[] ldbCapaRmk = (JSPUtil.getParameter(request, prefix	+ "ldb_capa_rmk", length));
			String[] hdHulActUtWgt = (JSPUtil.getParameter(request, prefix	+ "hd_hul_act_ut_wgt", length));
			String[] hdHulNewSltRt = (JSPUtil.getParameter(request, prefix	+ "hd_hul_new_slt_rt", length));
			String[] capaSeq = (JSPUtil.getParameter(request, prefix	+ "capa_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] hdHulInclIcrzQty = (JSPUtil.getParameter(request, prefix	+ "hd_hul_incl_icrz_qty", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] ttlBsaWgt = (JSPUtil.getParameter(request, prefix	+ "ttl_bsa_wgt", length));
			String[] hcXcldBsaQty = (JSPUtil.getParameter(request, prefix	+ "hc_xcld_bsa_qty", length));
			String[] bakHulNewWgtRt = (JSPUtil.getParameter(request, prefix	+ "bak_hul_new_wgt_rt", length));
			String[] hdHulHcXcldQty = (JSPUtil.getParameter(request, prefix	+ "hd_hul_hc_xcld_qty", length));
			String[] bakHulHcInclQty = (JSPUtil.getParameter(request, prefix	+ "bak_hul_hc_incl_qty", length));
			String[] bakHulTtlWgt = (JSPUtil.getParameter(request, prefix	+ "bak_hul_ttl_wgt", length));
			String[] actBsaUtWgt = (JSPUtil.getParameter(request, prefix	+ "act_bsa_ut_wgt", length));
			String[] ctrtBsaUtWgt = (JSPUtil.getParameter(request, prefix	+ "ctrt_bsa_ut_wgt", length));
			String[] hcInclBsaQty = (JSPUtil.getParameter(request, prefix	+ "hc_incl_bsa_qty", length));
			String[] maxCgoSmrMtWgt = (JSPUtil.getParameter(request, prefix	+ "max_cgo_smr_mt_wgt", length));
			String[] cntrDznCapa = (JSPUtil.getParameter(request, prefix	+ "cntr_dzn_capa", length));
			String[] hdHulNewWgtRt = (JSPUtil.getParameter(request, prefix	+ "hd_hul_new_wgt_rt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] hdHulHcInclQty = (JSPUtil.getParameter(request, prefix	+ "hd_hul_hc_incl_qty", length));
			String[] hdHulHcHldQty = (JSPUtil.getParameter(request, prefix	+ "hd_hul_hc_hld_qty", length));
			String[] bakHulCrntSltRt = (JSPUtil.getParameter(request, prefix	+ "bak_hul_crnt_slt_rt", length));
			String[] bakHulHcHldQty = (JSPUtil.getParameter(request, prefix	+ "bak_hul_hc_hld_qty", length));
			String[] vslSlanCtnt = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_ctnt", length));
			
			for (int i = 0; i < length; i++) {
				model = new VesselLoadableInfoVO();
				if (hdHulTtlWgt[i] != null)
					model.setHdHulTtlWgt(hdHulTtlWgt[i]);
				if (hdHulHcDeckQty[i] != null)
					model.setHdHulHcDeckQty(hdHulHcDeckQty[i]);
				if (bakHulNewSltRt[i] != null)
					model.setBakHulNewSltRt(bakHulNewSltRt[i]);
				if (bakHulInclIcrzQty[i] != null)
					model.setBakHulInclIcrzQty(bakHulInclIcrzQty[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (bakHulXcldIcrzQty[i] != null)
					model.setBakHulXcldIcrzQty(bakHulXcldIcrzQty[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (hdHulXcldIcrzQty[i] != null)
					model.setHdHulXcldIcrzQty(hdHulXcldIcrzQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bakHulActUtWgt[i] != null)
					model.setBakHulActUtWgt(bakHulActUtWgt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bakHulHcDeckQty[i] != null)
					model.setBakHulHcDeckQty(bakHulHcDeckQty[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (bakHulHcXcldQty[i] != null)
					model.setBakHulHcXcldQty(bakHulHcXcldQty[i]);
				if (hdHulCrntSltRt[i] != null)
					model.setHdHulCrntSltRt(hdHulCrntSltRt[i]);
				if (ldbCapaRmk[i] != null)
					model.setLdbCapaRmk(ldbCapaRmk[i]);
				if (hdHulActUtWgt[i] != null)
					model.setHdHulActUtWgt(hdHulActUtWgt[i]);
				if (hdHulNewSltRt[i] != null)
					model.setHdHulNewSltRt(hdHulNewSltRt[i]);
				if (capaSeq[i] != null)
					model.setCapaSeq(capaSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (hdHulInclIcrzQty[i] != null)
					model.setHdHulInclIcrzQty(hdHulInclIcrzQty[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ttlBsaWgt[i] != null)
					model.setTtlBsaWgt(ttlBsaWgt[i]);
				if (hcXcldBsaQty[i] != null)
					model.setHcXcldBsaQty(hcXcldBsaQty[i]);
				if (bakHulNewWgtRt[i] != null)
					model.setBakHulNewWgtRt(bakHulNewWgtRt[i]);
				if (hdHulHcXcldQty[i] != null)
					model.setHdHulHcXcldQty(hdHulHcXcldQty[i]);
				if (bakHulHcInclQty[i] != null)
					model.setBakHulHcInclQty(bakHulHcInclQty[i]);
				if (bakHulTtlWgt[i] != null)
					model.setBakHulTtlWgt(bakHulTtlWgt[i]);
				if (actBsaUtWgt[i] != null)
					model.setActBsaUtWgt(actBsaUtWgt[i]);
				if (ctrtBsaUtWgt[i] != null)
					model.setCtrtBsaUtWgt(ctrtBsaUtWgt[i]);
				if (hcInclBsaQty[i] != null)
					model.setHcInclBsaQty(hcInclBsaQty[i]);
				if (maxCgoSmrMtWgt[i] != null)
					model.setMaxCgoSmrMtWgt(maxCgoSmrMtWgt[i]);
				if (cntrDznCapa[i] != null)
					model.setCntrDznCapa(cntrDznCapa[i]);
				if (hdHulNewWgtRt[i] != null)
					model.setHdHulNewWgtRt(hdHulNewWgtRt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (hdHulHcInclQty[i] != null)
					model.setHdHulHcInclQty(hdHulHcInclQty[i]);
				if (hdHulHcHldQty[i] != null)
					model.setHdHulHcHldQty(hdHulHcHldQty[i]);
				if (bakHulCrntSltRt[i] != null)
					model.setBakHulCrntSltRt(bakHulCrntSltRt[i]);
				if (bakHulHcHldQty[i] != null)
					model.setBakHulHcHldQty(bakHulHcHldQty[i]);
				if (vslSlanCtnt[i] != null)
					model.setVslSlanCtnt(vslSlanCtnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVesselLoadableInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VesselLoadableInfoVO[]
	 */
	public VesselLoadableInfoVO[] getVesselLoadableInfoVOs(){
		VesselLoadableInfoVO[] vos = (VesselLoadableInfoVO[])models.toArray(new VesselLoadableInfoVO[models.size()]);
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
		this.hdHulTtlWgt = this.hdHulTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdHulHcDeckQty = this.hdHulHcDeckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bakHulNewSltRt = this.bakHulNewSltRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bakHulInclIcrzQty = this.bakHulInclIcrzQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bakHulXcldIcrzQty = this.bakHulXcldIcrzQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdHulXcldIcrzQty = this.hdHulXcldIcrzQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bakHulActUtWgt = this.bakHulActUtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bakHulHcDeckQty = this.bakHulHcDeckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bakHulHcXcldQty = this.bakHulHcXcldQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdHulCrntSltRt = this.hdHulCrntSltRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ldbCapaRmk = this.ldbCapaRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdHulActUtWgt = this.hdHulActUtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdHulNewSltRt = this.hdHulNewSltRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.capaSeq = this.capaSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdHulInclIcrzQty = this.hdHulInclIcrzQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlBsaWgt = this.ttlBsaWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcXcldBsaQty = this.hcXcldBsaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bakHulNewWgtRt = this.bakHulNewWgtRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdHulHcXcldQty = this.hdHulHcXcldQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bakHulHcInclQty = this.bakHulHcInclQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bakHulTtlWgt = this.bakHulTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actBsaUtWgt = this.actBsaUtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtBsaUtWgt = this.ctrtBsaUtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcInclBsaQty = this.hcInclBsaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxCgoSmrMtWgt = this.maxCgoSmrMtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDznCapa = this.cntrDznCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdHulNewWgtRt = this.hdHulNewWgtRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdHulHcInclQty = this.hdHulHcInclQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdHulHcHldQty = this.hdHulHcHldQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bakHulCrntSltRt = this.bakHulCrntSltRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bakHulHcHldQty = this.bakHulHcHldQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCtnt = this.vslSlanCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
