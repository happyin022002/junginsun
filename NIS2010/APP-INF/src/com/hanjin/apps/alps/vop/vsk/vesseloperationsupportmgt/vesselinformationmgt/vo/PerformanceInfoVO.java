/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PerformanceInfoVO.java
*@FileTitle : PerformanceInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.07
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.07  
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

public class PerformanceInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PerformanceInfoVO> models = new ArrayList<PerformanceInfoVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String bowHgt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String shpIdxScre = null;
	/* Column Info */
	private String slwStmngFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String ctclRpmNo = null;
	/* Column Info */
	private String opMinSpd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String onDeckPerTrKnt = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String trsmHgt = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String onDeckPerRowKnt = null;
	/* Column Info */
	private String htchCvrInHldKnt = null;
	/* Column Info */
	private String fuelSavEqFlg = null;
	/* Column Info */
	private String opMinRpmNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String inHldPerRowKnt = null;
	/* Column Info */
	private String sprSlwStmngFlg = null;
	/* Column Info */
	private String inHldPerTrKnt = null;
	/* Column Info */
	private String vslLodRto = null;	
	/* Column Info */
	private String ctclToRpmNo = null;	
	/* Column Info */
	private String mnEngTrKnt = null;	
	/* Column Info */
	private String gnrTrKnt = null;	
	/* Column Info */
	private String bwthstTrKnt = null;	
	/* Column Info */
	private String ampTpCd = null;	
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PerformanceInfoVO() {}

	public PerformanceInfoVO(String ibflag, String pagerows, String vslCd, String ctclRpmNo, String opMinRpmNo, String opMinSpd, String slwStmngFlg, String sprSlwStmngFlg, String fuelSavEqFlg, String inHldPerTrKnt, String inHldPerRowKnt, String htchCvrInHldKnt, String onDeckPerTrKnt, String onDeckPerRowKnt, String bowHgt, String trsmHgt, String creUsrId, String creDt, String updUsrId, String updDt, String shpIdxScre, String usrId, String ctclToRpmNo, String vslLodRto
					, String mnEngTrKnt, String gnrTrKnt, String bwthstTrKnt, String ampTpCd) {
		this.updDt = updDt;
		this.bowHgt = bowHgt;
		this.vslCd = vslCd;
		this.shpIdxScre = shpIdxScre;
		this.slwStmngFlg = slwStmngFlg;
		this.creDt = creDt;
		this.ctclRpmNo = ctclRpmNo;
		this.opMinSpd = opMinSpd;
		this.pagerows = pagerows;
		this.onDeckPerTrKnt = onDeckPerTrKnt;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.trsmHgt = trsmHgt;
		this.usrId = usrId;
		this.onDeckPerRowKnt = onDeckPerRowKnt;
		this.htchCvrInHldKnt = htchCvrInHldKnt;
		this.fuelSavEqFlg = fuelSavEqFlg;
		this.opMinRpmNo = opMinRpmNo;
		this.updUsrId = updUsrId;
		this.inHldPerRowKnt = inHldPerRowKnt;
		this.sprSlwStmngFlg = sprSlwStmngFlg;
		this.inHldPerTrKnt = inHldPerTrKnt;
		this.ctclToRpmNo = ctclToRpmNo;
		this.vslLodRto = vslLodRto;
		this.mnEngTrKnt = mnEngTrKnt;
		this.gnrTrKnt = gnrTrKnt;
		this.bwthstTrKnt = bwthstTrKnt;
		this.ampTpCd = ampTpCd;

	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("bow_hgt", getBowHgt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("shp_idx_scre", getShpIdxScre());
		this.hashColumns.put("slw_stmng_flg", getSlwStmngFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("ctcl_rpm_no", getCtclRpmNo());
		this.hashColumns.put("op_min_spd", getOpMinSpd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("on_deck_per_tr_knt", getOnDeckPerTrKnt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("trsm_hgt", getTrsmHgt());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("on_deck_per_row_knt", getOnDeckPerRowKnt());
		this.hashColumns.put("htch_cvr_in_hld_knt", getHtchCvrInHldKnt());
		this.hashColumns.put("fuel_sav_eq_flg", getFuelSavEqFlg());
		this.hashColumns.put("op_min_rpm_no", getOpMinRpmNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("in_hld_per_row_knt", getInHldPerRowKnt());
		this.hashColumns.put("spr_slw_stmng_flg", getSprSlwStmngFlg());
		this.hashColumns.put("in_hld_per_tr_knt", getInHldPerTrKnt());
		this.hashColumns.put("ctcl_to_rpm_no", getCtclToRpmNo());
		this.hashColumns.put("vsl_lod_rto", getVslLodRto());
		this.hashColumns.put("mn_eng_tr_knt", getMnEngTrKnt());	
		this.hashColumns.put("gnr_tr_knt", getGnrTrKnt());	
		this.hashColumns.put("bwthst_tr_knt", getBwthstTrKnt());
		this.hashColumns.put("amp_tp_cd", getAmpTpCd());

		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("bow_hgt", "bowHgt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("shp_idx_scre", "shpIdxScre");
		this.hashFields.put("slw_stmng_flg", "slwStmngFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("ctcl_rpm_no", "ctclRpmNo");
		this.hashFields.put("op_min_spd", "opMinSpd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("on_deck_per_tr_knt", "onDeckPerTrKnt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("trsm_hgt", "trsmHgt");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("on_deck_per_row_knt", "onDeckPerRowKnt");
		this.hashFields.put("htch_cvr_in_hld_knt", "htchCvrInHldKnt");
		this.hashFields.put("fuel_sav_eq_flg", "fuelSavEqFlg");
		this.hashFields.put("op_min_rpm_no", "opMinRpmNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("in_hld_per_row_knt", "inHldPerRowKnt");
		this.hashFields.put("spr_slw_stmng_flg", "sprSlwStmngFlg");
		this.hashFields.put("in_hld_per_tr_knt", "inHldPerTrKnt");
		this.hashFields.put("ctcl_to_rpm_no", "ctclToRpmNo");
		this.hashFields.put("vsl_lod_rto", "vslLodRto");
		this.hashFields.put("mn_eng_tr_knt", "mnEngTrKnt");
		this.hashFields.put("gnr_tr_knt", "gnrTrKnt");
		this.hashFields.put("bwthst_tr_knt", "bwthstTrKnt");
		this.hashFields.put("amp_tp_cd", "ampTpCd");

		return this.hashFields;
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
	 * @return bowHgt
	 */
	public String getBowHgt() {
		return this.bowHgt;
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
	 * @return shpIdxScre
	 */
	public String getShpIdxScre() {
		return this.shpIdxScre;
	}
	
	/**
	 * Column Info
	 * @return slwStmngFlg
	 */
	public String getSlwStmngFlg() {
		return this.slwStmngFlg;
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
	 * @return ctclRpmNo
	 */
	public String getCtclRpmNo() {
		return this.ctclRpmNo;
	}
	
	/**
	 * Column Info
	 * @return opMinSpd
	 */
	public String getOpMinSpd() {
		return this.opMinSpd;
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
	 * @return onDeckPerTrKnt
	 */
	public String getOnDeckPerTrKnt() {
		return this.onDeckPerTrKnt;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return trsmHgt
	 */
	public String getTrsmHgt() {
		return this.trsmHgt;
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
	 * @return onDeckPerRowKnt
	 */
	public String getOnDeckPerRowKnt() {
		return this.onDeckPerRowKnt;
	}
	
	/**
	 * Column Info
	 * @return htchCvrInHldKnt
	 */
	public String getHtchCvrInHldKnt() {
		return this.htchCvrInHldKnt;
	}
	
	/**
	 * Column Info
	 * @return fuelSavEqFlg
	 */
	public String getFuelSavEqFlg() {
		return this.fuelSavEqFlg;
	}
	
	/**
	 * Column Info
	 * @return opMinRpmNo
	 */
	public String getOpMinRpmNo() {
		return this.opMinRpmNo;
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
	 * @return inHldPerRowKnt
	 */
	public String getInHldPerRowKnt() {
		return this.inHldPerRowKnt;
	}
	
	/**
	 * Column Info
	 * @return sprSlwStmngFlg
	 */
	public String getSprSlwStmngFlg() {
		return this.sprSlwStmngFlg;
	}
	
	/**
	 * Column Info
	 * @return inHldPerTrKnt
	 */
	public String getInHldPerTrKnt() {
		return this.inHldPerTrKnt;
	}
	
	/**
	 * Column Info
	 * @return ctclToRpmNo
	 */
	public String getCtclToRpmNo() {
		return this.ctclToRpmNo;
	}

	/**
	 * Column Info
	 * @return vslLodRto
	 */
	public String getVslLodRto() {
		return this.vslLodRto;
	}
	
	/**
	 * Column Info
	 * @return mnEngTrKnt
	 */
	public String getMnEngTrKnt() {
		return this.mnEngTrKnt;
	}
	
	/**
	 * Column Info
	 * @return gnrTrKnt
	 */
	public String getGnrTrKnt() {
		return this.gnrTrKnt;
	}
	
	/**
	 * Column Info
	 * @return bwthstTrKnt
	 */
	public String getBwthstTrKnt() {
		return this.bwthstTrKnt;
	}
	
	/**
	 * Column Info
	 * @return ampTpCd
	 */
	public String getAmpTpCd() {
		return this.ampTpCd;
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
	 * @param bowHgt
	 */
	public void setBowHgt(String bowHgt) {
		this.bowHgt = bowHgt;
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
	 * @param shpIdxScre
	 */
	public void setShpIdxScre(String shpIdxScre) {
		this.shpIdxScre = shpIdxScre;
	}
	
	/**
	 * Column Info
	 * @param slwStmngFlg
	 */
	public void setSlwStmngFlg(String slwStmngFlg) {
		this.slwStmngFlg = slwStmngFlg;
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
	 * @param ctclRpmNo
	 */
	public void setCtclRpmNo(String ctclRpmNo) {
		this.ctclRpmNo = ctclRpmNo;
	}
	
	/**
	 * Column Info
	 * @param opMinSpd
	 */
	public void setOpMinSpd(String opMinSpd) {
		this.opMinSpd = opMinSpd;
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
	 * @param onDeckPerTrKnt
	 */
	public void setOnDeckPerTrKnt(String onDeckPerTrKnt) {
		this.onDeckPerTrKnt = onDeckPerTrKnt;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param trsmHgt
	 */
	public void setTrsmHgt(String trsmHgt) {
		this.trsmHgt = trsmHgt;
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
	 * @param onDeckPerRowKnt
	 */
	public void setOnDeckPerRowKnt(String onDeckPerRowKnt) {
		this.onDeckPerRowKnt = onDeckPerRowKnt;
	}
	
	/**
	 * Column Info
	 * @param htchCvrInHldKnt
	 */
	public void setHtchCvrInHldKnt(String htchCvrInHldKnt) {
		this.htchCvrInHldKnt = htchCvrInHldKnt;
	}
	
	/**
	 * Column Info
	 * @param fuelSavEqFlg
	 */
	public void setFuelSavEqFlg(String fuelSavEqFlg) {
		this.fuelSavEqFlg = fuelSavEqFlg;
	}
	
	/**
	 * Column Info
	 * @param opMinRpmNo
	 */
	public void setOpMinRpmNo(String opMinRpmNo) {
		this.opMinRpmNo = opMinRpmNo;
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
	 * @param inHldPerRowKnt
	 */
	public void setInHldPerRowKnt(String inHldPerRowKnt) {
		this.inHldPerRowKnt = inHldPerRowKnt;
	}
	
	/**
	 * Column Info
	 * @param sprSlwStmngFlg
	 */
	public void setSprSlwStmngFlg(String sprSlwStmngFlg) {
		this.sprSlwStmngFlg = sprSlwStmngFlg;
	}
	
	/**
	 * Column Info
	 * @param inHldPerTrKnt
	 */
	public void setInHldPerTrKnt(String inHldPerTrKnt) {
		this.inHldPerTrKnt = inHldPerTrKnt;
	}
	
	/**
	 * Column Info
	 * @param ctclToRpmNo
	 */
	public void setCtclToRpmNo(String ctclToRpmNo) {
		this.ctclToRpmNo = ctclToRpmNo;
	}
	
	/**
	 * Column Info
	 * @param vslLodRto
	 */
	public void setVslLodRto(String vslLodRto) {
		this.vslLodRto = vslLodRto;
	}	
	
	/**
	 * Column Info
	 * @param mnEngTrKnt
	 */
	public void setMnEngTrKnt(String mnEngTrKnt) {
		this.mnEngTrKnt = mnEngTrKnt;
	}	
	
	/**
	 * Column Info
	 * @param gnrTrKnt
	 */
	public void setGnrTrKnt(String gnrTrKnt) {
		this.gnrTrKnt = gnrTrKnt;
	}	
	
	/**
	 * Column Info
	 * @param bwthstTrKnt
	 */
	public void setBwthstTrKnt(String bwthstTrKnt) {
		this.bwthstTrKnt = bwthstTrKnt;
	}	
	
	/**
	 * Column Info
	 * @param ampTpCd
	 */
	public void setAmpTpCd(String ampTpCd) {
		this.ampTpCd = ampTpCd;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setBowHgt(JSPUtil.getParameter(request, prefix + "bow_hgt", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setShpIdxScre(JSPUtil.getParameter(request, prefix + "shp_idx_scre", ""));
		setSlwStmngFlg(JSPUtil.getParameter(request, prefix + "slw_stmng_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCtclRpmNo(JSPUtil.getParameter(request, prefix + "ctcl_rpm_no", ""));
		setOpMinSpd(JSPUtil.getParameter(request, prefix + "op_min_spd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOnDeckPerTrKnt(JSPUtil.getParameter(request, prefix + "on_deck_per_tr_knt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTrsmHgt(JSPUtil.getParameter(request, prefix + "trsm_hgt", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setOnDeckPerRowKnt(JSPUtil.getParameter(request, prefix + "on_deck_per_row_knt", ""));
		setHtchCvrInHldKnt(JSPUtil.getParameter(request, prefix + "htch_cvr_in_hld_knt", ""));
		setFuelSavEqFlg(JSPUtil.getParameter(request, prefix + "fuel_sav_eq_flg", ""));
		setOpMinRpmNo(JSPUtil.getParameter(request, prefix + "op_min_rpm_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setInHldPerRowKnt(JSPUtil.getParameter(request, prefix + "in_hld_per_row_knt", ""));
		setSprSlwStmngFlg(JSPUtil.getParameter(request, prefix + "spr_slw_stmng_flg", ""));
		setInHldPerTrKnt(JSPUtil.getParameter(request, prefix + "in_hld_per_tr_knt", ""));
		setCtclToRpmNo(JSPUtil.getParameter(request, prefix + "ctcl_to_rpm_no", ""));
		setVslLodRto(JSPUtil.getParameter(request, prefix + "vsl_lod_rto", ""));
		setMnEngTrKnt(JSPUtil.getParameter(request, prefix + "mn_eng_tr_knt", ""));
		setGnrTrKnt(JSPUtil.getParameter(request, prefix + "gnr_tr_knt", ""));
		setBwthstTrKnt(JSPUtil.getParameter(request, prefix + "bwthst_tr_knt", ""));
		setAmpTpCd(JSPUtil.getParameter(request, prefix + "amp_tp_cd", ""));

	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PerformanceInfoVO[]
	 */
	public PerformanceInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PerformanceInfoVO[]
	 */
	public PerformanceInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PerformanceInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] bowHgt = (JSPUtil.getParameter(request, prefix	+ "bow_hgt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] shpIdxScre = (JSPUtil.getParameter(request, prefix	+ "shp_idx_scre", length));
			String[] slwStmngFlg = (JSPUtil.getParameter(request, prefix	+ "slw_stmng_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] ctclRpmNo = (JSPUtil.getParameter(request, prefix	+ "ctcl_rpm_no", length));
			String[] opMinSpd = (JSPUtil.getParameter(request, prefix	+ "op_min_spd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] onDeckPerTrKnt = (JSPUtil.getParameter(request, prefix	+ "on_deck_per_tr_knt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] trsmHgt = (JSPUtil.getParameter(request, prefix	+ "trsm_hgt", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] onDeckPerRowKnt = (JSPUtil.getParameter(request, prefix	+ "on_deck_per_row_knt", length));
			String[] htchCvrInHldKnt = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_in_hld_knt", length));
			String[] fuelSavEqFlg = (JSPUtil.getParameter(request, prefix	+ "fuel_sav_eq_flg", length));
			String[] opMinRpmNo = (JSPUtil.getParameter(request, prefix	+ "op_min_rpm_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] inHldPerRowKnt = (JSPUtil.getParameter(request, prefix	+ "in_hld_per_row_knt", length));
			String[] sprSlwStmngFlg = (JSPUtil.getParameter(request, prefix	+ "spr_slw_stmng_flg", length));
			String[] inHldPerTrKnt = (JSPUtil.getParameter(request, prefix	+ "in_hld_per_tr_knt", length));
			String[] ctclToRpmNo = (JSPUtil.getParameter(request, prefix	+ "ctcl_to_rpm_no", length));
			String[] vslLodRto = (JSPUtil.getParameter(request, prefix	+ "vsl_lod_rto", length));			
			String[] mnEngTrKnt = (JSPUtil.getParameter(request, prefix	+ "mn_eng_tr_knt", length));	
			String[] gnrTrKnt = (JSPUtil.getParameter(request, prefix	+ "gnr_tr_knt", length));	
			String[] bwthstTrKnt = (JSPUtil.getParameter(request, prefix	+ "bwthst_tr_knt", length));	
			String[] ampTpCd = (JSPUtil.getParameter(request, prefix	+ "amp_tp_cd", length));	

			
			for (int i = 0; i < length; i++) {
				model = new PerformanceInfoVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (bowHgt[i] != null)
					model.setBowHgt(bowHgt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (shpIdxScre[i] != null)
					model.setShpIdxScre(shpIdxScre[i]);
				if (slwStmngFlg[i] != null)
					model.setSlwStmngFlg(slwStmngFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (ctclRpmNo[i] != null)
					model.setCtclRpmNo(ctclRpmNo[i]);
				if (opMinSpd[i] != null)
					model.setOpMinSpd(opMinSpd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (onDeckPerTrKnt[i] != null)
					model.setOnDeckPerTrKnt(onDeckPerTrKnt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (trsmHgt[i] != null)
					model.setTrsmHgt(trsmHgt[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (onDeckPerRowKnt[i] != null)
					model.setOnDeckPerRowKnt(onDeckPerRowKnt[i]);
				if (htchCvrInHldKnt[i] != null)
					model.setHtchCvrInHldKnt(htchCvrInHldKnt[i]);
				if (fuelSavEqFlg[i] != null)
					model.setFuelSavEqFlg(fuelSavEqFlg[i]);
				if (opMinRpmNo[i] != null)
					model.setOpMinRpmNo(opMinRpmNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (inHldPerRowKnt[i] != null)
					model.setInHldPerRowKnt(inHldPerRowKnt[i]);
				if (sprSlwStmngFlg[i] != null)
					model.setSprSlwStmngFlg(sprSlwStmngFlg[i]);
				if (inHldPerTrKnt[i] != null)
					model.setInHldPerTrKnt(inHldPerTrKnt[i]);
				if (ctclToRpmNo[i] != null)
					model.setCtclToRpmNo(ctclToRpmNo[i]);	
				if (vslLodRto[i] != null)
					model.setVslLodRto(vslLodRto[i]);				
				if (mnEngTrKnt[i] != null)
					model.setMnEngTrKnt(mnEngTrKnt[i]);	
				if (gnrTrKnt[i] != null)
					model.setGnrTrKnt(gnrTrKnt[i]);	
				if (bwthstTrKnt[i] != null)
					model.setBwthstTrKnt(bwthstTrKnt[i]);	
				if (ampTpCd[i] != null)
					model.setAmpTpCd(ampTpCd[i]);	
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPerformanceInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PerformanceInfoVO[]
	 */
	public PerformanceInfoVO[] getPerformanceInfoVOs(){
		PerformanceInfoVO[] vos = (PerformanceInfoVO[])models.toArray(new PerformanceInfoVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bowHgt = this.bowHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpIdxScre = this.shpIdxScre .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slwStmngFlg = this.slwStmngFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctclRpmNo = this.ctclRpmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opMinSpd = this.opMinSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onDeckPerTrKnt = this.onDeckPerTrKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmHgt = this.trsmHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onDeckPerRowKnt = this.onDeckPerRowKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvrInHldKnt = this.htchCvrInHldKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fuelSavEqFlg = this.fuelSavEqFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opMinRpmNo = this.opMinRpmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inHldPerRowKnt = this.inHldPerRowKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprSlwStmngFlg = this.sprSlwStmngFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inHldPerTrKnt = this.inHldPerTrKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctclToRpmNo = this.ctclToRpmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslLodRto = this.vslLodRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnEngTrKnt = this.mnEngTrKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gnrTrKnt = this.gnrTrKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bwthstTrKnt = this.bwthstTrKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ampTpCd = this.ampTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}
}
