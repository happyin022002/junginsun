/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : FcmMonFoilSavCostVO.java
*@FileTitle : FcmMonFoilSavCostVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.18
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2011.12.12 진마리아 
* 1.0 Creation
* 
* 2012.07.18 이혜민 [CHM-201219005-01] fuel_adt 컬럼명 fuel_adtv 로 수정
=========================================================*/

package com.clt.apps.opus.vop.fcm.performance.performance.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 진마리아
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FcmMonFoilSavCostVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FcmMonFoilSavCostVO> models = new ArrayList<FcmMonFoilSavCostVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String fuelAdtvCsmWgt = null;
	/* Column Info */
	private String foilCsmWgt = null;
	/* Column Info */
	private String fuelAdtvCsmCostAmt = null;
	/* Column Info */
	private String savRto = null;
	/* Column Info */
	private String portPairSeaFoilCsmWgt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String savQty = null;
	/* Column Info */
	private String fuelAdtvDepCsmCostAmt = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vslClssCd = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String foilCsmCostAmt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String lodIndQty = null;
	/* Column Info */
	private String savCostAmt = null;
	/* Column Info */
	private String avgRpmPwr = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String savItmCd = null;
	/* Column Info */
	private String fuelAdtvUcAmt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String avgSpd = null;
	/* Column Info */
	private String nvgtDist = null;
	/* Column Info */
	private String vslClssSubCd = null;
	/* Column Info */
	private String fuelAdtvSavCostAmt = null;
	/* Column Info */
	private String savCostCreYrmon = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String itmCsmRto = null;
	/* Column Info */
	private String itmUtPrc = null;
	/* Column Info */
	private String savRtoN1st = null;
	/* Column Info */
	private String savRtoN2nd = null;
	/* Column Info */
	private String savRtoCons = null;
	/* Column Info */
	private String fmYrmon = null;
	/* Column Info */
	private String toYrmon = null;
	/* Column Info */
	private String clptIndSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FcmMonFoilSavCostVO() {}

	public FcmMonFoilSavCostVO(String ibflag, String pagerows, String savItmCd, String savCostCreYrmon, String vslCd, String skdVoyNo, String skdDirCd, String vpsPortCd, String vslClssCd, String vslClssSubCd, String vslSlanCd, String nvgtDist, String avgSpd, String avgRpmPwr, String lodIndQty, String foilCsmWgt, String foilCsmCostAmt, String savRto, String savQty, String savCostAmt, String portPairSeaFoilCsmWgt, String fuelAdtvCsmWgt, String fuelAdtvUcAmt, String fuelAdtvCsmCostAmt, String fuelAdtvDepCsmCostAmt, String fuelAdtvSavCostAmt, String creUsrId, String creDt, String updUsrId, String updDt, String vvd, String itmCsmRto, String itmUtPrc, String savRtoN1st, String savRtoN2nd, String savRtoCons, String fmYrmon, String toYrmon, String clptIndSeq) {
		this.vslCd = vslCd;
		this.fuelAdtvCsmWgt = fuelAdtvCsmWgt;
		this.foilCsmWgt = foilCsmWgt;
		this.fuelAdtvCsmCostAmt = fuelAdtvCsmCostAmt;
		this.savRto = savRto;
		this.portPairSeaFoilCsmWgt = portPairSeaFoilCsmWgt;
		this.creDt = creDt;
		this.savQty = savQty;
		this.fuelAdtvDepCsmCostAmt = fuelAdtvDepCsmCostAmt;
		this.vslSlanCd = vslSlanCd;
		this.pagerows = pagerows;
		this.vslClssCd = vslClssCd;
		this.vpsPortCd = vpsPortCd;
		this.ibflag = ibflag;
		this.foilCsmCostAmt = foilCsmCostAmt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.lodIndQty = lodIndQty;
		this.savCostAmt = savCostAmt;
		this.avgRpmPwr = avgRpmPwr;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd = skdDirCd;
		this.savItmCd = savItmCd;
		this.fuelAdtvUcAmt = fuelAdtvUcAmt;
		this.creUsrId = creUsrId;
		this.avgSpd = avgSpd;
		this.nvgtDist = nvgtDist;
		this.vslClssSubCd = vslClssSubCd;
		this.fuelAdtvSavCostAmt = fuelAdtvSavCostAmt;
		this.savCostCreYrmon = savCostCreYrmon;
		this.vvd = vvd;
		this.itmCsmRto = itmCsmRto;
		this.itmUtPrc = itmUtPrc;
		this.savRtoN1st = savRtoN1st;
		this.savRtoN2nd = savRtoN2nd;
		this.savRtoCons = savRtoCons;
		this.fmYrmon = fmYrmon;
		this.toYrmon = toYrmon;
		this.clptIndSeq = clptIndSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("fuel_adtv_csm_wgt", getFuelAdtvCsmWgt());
		this.hashColumns.put("foil_csm_wgt", getFoilCsmWgt());
		this.hashColumns.put("fuel_adtv_csm_cost_amt", getFuelAdtvCsmCostAmt());
		this.hashColumns.put("sav_rto", getSavRto());
		this.hashColumns.put("port_pair_sea_foil_csm_wgt", getPortPairSeaFoilCsmWgt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("sav_qty", getSavQty());
		this.hashColumns.put("fuel_adtv_dep_csm_cost_amt", getFuelAdtvDepCsmCostAmt());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vsl_clss_cd", getVslClssCd());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("foil_csm_cost_amt", getFoilCsmCostAmt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("lod_ind_qty", getLodIndQty());
		this.hashColumns.put("sav_cost_amt", getSavCostAmt());
		this.hashColumns.put("avg_rpm_pwr", getAvgRpmPwr());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("sav_itm_cd", getSavItmCd());
		this.hashColumns.put("fuel_adtv_uc_amt", getFuelAdtvUcAmt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("avg_spd", getAvgSpd());
		this.hashColumns.put("nvgt_dist", getNvgtDist());
		this.hashColumns.put("vsl_clss_sub_cd", getVslClssSubCd());
		this.hashColumns.put("fuel_adtv_sav_cost_amt", getFuelAdtvSavCostAmt());
		this.hashColumns.put("sav_cost_cre_yrmon", getSavCostCreYrmon());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("itm_csm_rto", getItmCsmRto());
		this.hashColumns.put("itm_ut_prc", getItmUtPrc());
		this.hashColumns.put("sav_rto_n1st", getSavRtoN1st());
		this.hashColumns.put("sav_rto_n2nd", getSavRtoN2nd());
		this.hashColumns.put("sav_rto_cons", getSavRtoCons());
		this.hashColumns.put("fm_yrmon", getFmYrmon());
		this.hashColumns.put("to_yrmon", getToYrmon());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("fuel_adtv_csm_wgt", "fuelAdtvCsmWgt");
		this.hashFields.put("foil_csm_wgt", "foilCsmWgt");
		this.hashFields.put("fuel_adtv_csm_cost_amt", "fuelAdtvCsmCostAmt");
		this.hashFields.put("sav_rto", "savRto");
		this.hashFields.put("port_pair_sea_foil_csm_wgt", "portPairSeaFoilCsmWgt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("sav_qty", "savQty");
		this.hashFields.put("fuel_adtv_dep_csm_cost_amt", "fuelAdtvDepCsmCostAmt");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vsl_clss_cd", "vslClssCd");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("foil_csm_cost_amt", "foilCsmCostAmt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("lod_ind_qty", "lodIndQty");
		this.hashFields.put("sav_cost_amt", "savCostAmt");
		this.hashFields.put("avg_rpm_pwr", "avgRpmPwr");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("sav_itm_cd", "savItmCd");
		this.hashFields.put("fuel_adtv_uc_amt", "fuelAdtvUcAmt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("avg_spd", "avgSpd");
		this.hashFields.put("nvgt_dist", "nvgtDist");
		this.hashFields.put("vsl_clss_sub_cd", "vslClssSubCd");
		this.hashFields.put("fuel_adtv_sav_cost_amt", "fuelAdtvSavCostAmt");
		this.hashFields.put("sav_cost_cre_yrmon", "savCostCreYrmon");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("itm_csm_rto", "itmCsmRto");
		this.hashFields.put("itm_ut_prc", "itmUtPrc");
		this.hashFields.put("sav_rto_n1st", "savRtoN1st");
		this.hashFields.put("sav_rto_n2nd", "savRtoN2nd");
		this.hashFields.put("sav_rto_cons", "savRtoCons");
		this.hashFields.put("fm_yrmon", "fmYrmon");
		this.hashFields.put("to_yrmon", "toYrmon");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
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
	 * @return fuelAdtvCsmWgt
	 */
	public String getFuelAdtvCsmWgt() {
		return this.fuelAdtvCsmWgt;
	}
	
	/**
	 * Column Info
	 * @return foilCsmWgt
	 */
	public String getFoilCsmWgt() {
		return this.foilCsmWgt;
	}
	
	/**
	 * Column Info
	 * @return fuelAdtvCsmCostAmt
	 */
	public String getFuelAdtvCsmCostAmt() {
		return this.fuelAdtvCsmCostAmt;
	}
	
	/**
	 * Column Info
	 * @return savRto
	 */
	public String getSavRto() {
		return this.savRto;
	}
	
	/**
	 * Column Info
	 * @return portPairSeaFoilCsmWgt
	 */
	public String getPortPairSeaFoilCsmWgt() {
		return this.portPairSeaFoilCsmWgt;
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
	 * @return savQty
	 */
	public String getSavQty() {
		return this.savQty;
	}
	
	/**
	 * Column Info
	 * @return fuelAdtvDepCsmCostAmt
	 */
	public String getFuelAdtvDepCsmCostAmt() {
		return this.fuelAdtvDepCsmCostAmt;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
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
	 * @return vslClssCd
	 */
	public String getVslClssCd() {
		return this.vslClssCd;
	}
	
	/**
	 * Column Info
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
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
	 * @return foilCsmCostAmt
	 */
	public String getFoilCsmCostAmt() {
		return this.foilCsmCostAmt;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return lodIndQty
	 */
	public String getLodIndQty() {
		return this.lodIndQty;
	}
	
	/**
	 * Column Info
	 * @return savCostAmt
	 */
	public String getSavCostAmt() {
		return this.savCostAmt;
	}
	
	/**
	 * Column Info
	 * @return avgRpmPwr
	 */
	public String getAvgRpmPwr() {
		return this.avgRpmPwr;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return savItmCd
	 */
	public String getSavItmCd() {
		return this.savItmCd;
	}
	
	/**
	 * Column Info
	 * @return fuelAdtvUcAmt
	 */
	public String getFuelAdtvUcAmt() {
		return this.fuelAdtvUcAmt;
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
	 * @return avgSpd
	 */
	public String getAvgSpd() {
		return this.avgSpd;
	}
	
	/**
	 * Column Info
	 * @return nvgtDist
	 */
	public String getNvgtDist() {
		return this.nvgtDist;
	}
	
	/**
	 * Column Info
	 * @return vslClssSubCd
	 */
	public String getVslClssSubCd() {
		return this.vslClssSubCd;
	}
	
	/**
	 * Column Info
	 * @return fuelAdtvSavCostAmt
	 */
	public String getFuelAdtvSavCostAmt() {
		return this.fuelAdtvSavCostAmt;
	}
	
	/**
	 * Column Info
	 * @return savCostCreYrmon
	 */
	public String getSavCostCreYrmon() {
		return this.savCostCreYrmon;
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
	 * @return itmCsmRto
	 */
	public String getItmCsmRto() {
		return this.itmCsmRto;
	}
	
	/**
	 * Column Info
	 * @return itmUtPrc
	 */
	public String getItmUtPrc() {
		return this.itmUtPrc;
	}
	
	/**
	 * Column Info
	 * @return savRtoN1st
	 */
	public String getSavRtoN1st() {
		return this.savRtoN1st;
	}
	
	/**
	 * Column Info
	 * @return savRtoN2nd
	 */
	public String getSavRtoN2nd() {
		return this.savRtoN2nd;
	}
	
	/**
	 * Column Info
	 * @return savRtoCons
	 */
	public String getSavRtoCons() {
		return this.savRtoCons;
	}
	
	/**
	 * Column Info
	 * @return fmYrmon
	 */
	public String getFmYrmon() {
		return this.fmYrmon;
	}
	
	/**
	 * Column Info
	 * @return toYrmon
	 */
	public String getToYrmon() {
		return this.toYrmon;
	}
	
	/**
	 * Column Info
	 * @return clptIndSeq
	 */
	public String getClptIndSeq() {
		return this.clptIndSeq;
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
	 * @param fuelAdtvCsmWgt
	 */
	public void setFuelAdtvCsmWgt(String fuelAdtvCsmWgt) {
		this.fuelAdtvCsmWgt = fuelAdtvCsmWgt;
	}
	
	/**
	 * Column Info
	 * @param foilCsmWgt
	 */
	public void setFoilCsmWgt(String foilCsmWgt) {
		this.foilCsmWgt = foilCsmWgt;
	}
	
	/**
	 * Column Info
	 * @param fuelAdtvCsmCostAmt
	 */
	public void setFuelAdtvCsmCostAmt(String fuelAdtvCsmCostAmt) {
		this.fuelAdtvCsmCostAmt = fuelAdtvCsmCostAmt;
	}
	
	/**
	 * Column Info
	 * @param savRto
	 */
	public void setSavRto(String savRto) {
		this.savRto = savRto;
	}
	
	/**
	 * Column Info
	 * @param portPairSeaFoilCsmWgt
	 */
	public void setPortPairSeaFoilCsmWgt(String portPairSeaFoilCsmWgt) {
		this.portPairSeaFoilCsmWgt = portPairSeaFoilCsmWgt;
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
	 * @param savQty
	 */
	public void setSavQty(String savQty) {
		this.savQty = savQty;
	}
	
	/**
	 * Column Info
	 * @param fuelAdtvDepCsmCostAmt
	 */
	public void setFuelAdtvDepCsmCostAmt(String fuelAdtvDepCsmCostAmt) {
		this.fuelAdtvDepCsmCostAmt = fuelAdtvDepCsmCostAmt;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
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
	 * @param vslClssCd
	 */
	public void setVslClssCd(String vslClssCd) {
		this.vslClssCd = vslClssCd;
	}
	
	/**
	 * Column Info
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
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
	 * @param foilCsmCostAmt
	 */
	public void setFoilCsmCostAmt(String foilCsmCostAmt) {
		this.foilCsmCostAmt = foilCsmCostAmt;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param lodIndQty
	 */
	public void setLodIndQty(String lodIndQty) {
		this.lodIndQty = lodIndQty;
	}
	
	/**
	 * Column Info
	 * @param savCostAmt
	 */
	public void setSavCostAmt(String savCostAmt) {
		this.savCostAmt = savCostAmt;
	}
	
	/**
	 * Column Info
	 * @param avgRpmPwr
	 */
	public void setAvgRpmPwr(String avgRpmPwr) {
		this.avgRpmPwr = avgRpmPwr;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param savItmCd
	 */
	public void setSavItmCd(String savItmCd) {
		this.savItmCd = savItmCd;
	}
	
	/**
	 * Column Info
	 * @param fuelAdtvUcAmt
	 */
	public void setFuelAdtvUcAmt(String fuelAdtvUcAmt) {
		this.fuelAdtvUcAmt = fuelAdtvUcAmt;
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
	 * @param avgSpd
	 */
	public void setAvgSpd(String avgSpd) {
		this.avgSpd = avgSpd;
	}
	
	/**
	 * Column Info
	 * @param nvgtDist
	 */
	public void setNvgtDist(String nvgtDist) {
		this.nvgtDist = nvgtDist;
	}
	
	/**
	 * Column Info
	 * @param vslClssSubCd
	 */
	public void setVslClssSubCd(String vslClssSubCd) {
		this.vslClssSubCd = vslClssSubCd;
	}
	
	/**
	 * Column Info
	 * @param fuelAdtvSavCostAmt
	 */
	public void setFuelAdtvSavCostAmt(String fuelAdtvSavCostAmt) {
		this.fuelAdtvSavCostAmt = fuelAdtvSavCostAmt;
	}
	
	/**
	 * Column Info
	 * @param savCostCreYrmon
	 */
	public void setSavCostCreYrmon(String savCostCreYrmon) {
		this.savCostCreYrmon = savCostCreYrmon;
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
	 * @param itmCsmRto
	 */
	public void setItmCsmRto(String itmCsmRto) {
		this.itmCsmRto = itmCsmRto;
	}
	
	/**
	 * Column Info
	 * @param itmUtPrc
	 */
	public void setItmUtPrc(String itmUtPrc) {
		this.itmUtPrc = itmUtPrc;
	}
	
	/**
	 * Column Info
	 * @param savRtoN1st
	 */
	public void setSavRtoN1st(String savRtoN1st) {
		this.savRtoN1st = savRtoN1st;
	}
	
	/**
	 * Column Info
	 * @param savRtoN2nd
	 */
	public void setSavRtoN2nd(String savRtoN2nd) {
		this.savRtoN2nd = savRtoN2nd;
	}
	
	/**
	 * Column Info
	 * @param savRtoCons
	 */
	public void setSavRtoCons(String savRtoCons) {
		this.savRtoCons = savRtoCons;
	}
	
	/**
	 * Column Info
	 * @param fmYrmon
	 */
	public void setFmYrmon(String fmYrmon) {
		this.fmYrmon = fmYrmon;
	}
	
	/**
	 * Column Info
	 * @param toYrmon
	 */
	public void setToYrmon(String toYrmon) {
		this.toYrmon = toYrmon;
	}
	
	/**
	 * Column Info
	 * @param clptIndSeq
	 */
	public void setClptIndSeq(String clptIndSeq) {
		this.clptIndSeq = clptIndSeq;
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
		setFuelAdtvCsmWgt(JSPUtil.getParameter(request, prefix + "fuel_adtv_csm_wgt", ""));
		setFoilCsmWgt(JSPUtil.getParameter(request, prefix + "foil_csm_wgt", ""));
		setFuelAdtvCsmCostAmt(JSPUtil.getParameter(request, prefix + "fuel_adtv_csm_cost_amt", ""));
		setSavRto(JSPUtil.getParameter(request, prefix + "sav_rto", ""));
		setPortPairSeaFoilCsmWgt(JSPUtil.getParameter(request, prefix + "port_pair_sea_foil_csm_wgt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSavQty(JSPUtil.getParameter(request, prefix + "sav_qty", ""));
		setFuelAdtvDepCsmCostAmt(JSPUtil.getParameter(request, prefix + "fuel_adtv_dep_csm_cost_amt", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVslClssCd(JSPUtil.getParameter(request, prefix + "vsl_clss_cd", ""));
		setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFoilCsmCostAmt(JSPUtil.getParameter(request, prefix + "foil_csm_cost_amt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setLodIndQty(JSPUtil.getParameter(request, prefix + "lod_ind_qty", ""));
		setSavCostAmt(JSPUtil.getParameter(request, prefix + "sav_cost_amt", ""));
		setAvgRpmPwr(JSPUtil.getParameter(request, prefix + "avg_rpm_pwr", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setSavItmCd(JSPUtil.getParameter(request, prefix + "sav_itm_cd", ""));
		setFuelAdtvUcAmt(JSPUtil.getParameter(request, prefix + "fuel_adtv_uc_amt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setAvgSpd(JSPUtil.getParameter(request, prefix + "avg_spd", ""));
		setNvgtDist(JSPUtil.getParameter(request, prefix + "nvgt_dist", ""));
		setVslClssSubCd(JSPUtil.getParameter(request, prefix + "vsl_clss_sub_cd", ""));
		setFuelAdtvSavCostAmt(JSPUtil.getParameter(request, prefix + "fuel_adtv_sav_cost_amt", ""));
		setSavCostCreYrmon(JSPUtil.getParameter(request, prefix + "sav_cost_cre_yrmon", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setItmCsmRto(JSPUtil.getParameter(request, prefix + "itm_csm_rto", ""));
		setItmUtPrc(JSPUtil.getParameter(request, prefix + "itm_ut_prc", ""));
		setSavRtoN1st(JSPUtil.getParameter(request, prefix + "sav_rto_n1st", ""));
		setSavRtoN2nd(JSPUtil.getParameter(request, prefix + "sav_rto_n2nd", ""));
		setSavRtoCons(JSPUtil.getParameter(request, prefix + "sav_rto_cons", ""));
		setFmYrmon(JSPUtil.getParameter(request, prefix + "fm_yrmon", ""));
		setToYrmon(JSPUtil.getParameter(request, prefix + "to_yrmon", ""));
		setClptIndSeq(JSPUtil.getParameter(request, prefix + "clpt_ind_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FcmMonFoilSavCostVO[]
	 */
	public FcmMonFoilSavCostVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FcmMonFoilSavCostVO[]
	 */
	public FcmMonFoilSavCostVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FcmMonFoilSavCostVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] fuelAdtvCsmWgt = (JSPUtil.getParameter(request, prefix	+ "fuel_adtv_csm_wgt", length));
			String[] foilCsmWgt = (JSPUtil.getParameter(request, prefix	+ "foil_csm_wgt", length));
			String[] fuelAdtvCsmCostAmt = (JSPUtil.getParameter(request, prefix	+ "fuel_adtv_csm_cost_amt", length));
			String[] savRto = (JSPUtil.getParameter(request, prefix	+ "sav_rto", length));
			String[] portPairSeaFoilCsmWgt = (JSPUtil.getParameter(request, prefix	+ "port_pair_sea_foil_csm_wgt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] savQty = (JSPUtil.getParameter(request, prefix	+ "sav_qty", length));
			String[] fuelAdtvDepCsmCostAmt = (JSPUtil.getParameter(request, prefix	+ "fuel_adtv_dep_csm_cost_amt", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vslClssCd = (JSPUtil.getParameter(request, prefix	+ "vsl_clss_cd", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] foilCsmCostAmt = (JSPUtil.getParameter(request, prefix	+ "foil_csm_cost_amt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] lodIndQty = (JSPUtil.getParameter(request, prefix	+ "lod_ind_qty", length));
			String[] savCostAmt = (JSPUtil.getParameter(request, prefix	+ "sav_cost_amt", length));
			String[] avgRpmPwr = (JSPUtil.getParameter(request, prefix	+ "avg_rpm_pwr", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] savItmCd = (JSPUtil.getParameter(request, prefix	+ "sav_itm_cd", length));
			String[] fuelAdtvUcAmt = (JSPUtil.getParameter(request, prefix	+ "fuel_adtv_uc_amt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] avgSpd = (JSPUtil.getParameter(request, prefix	+ "avg_spd", length));
			String[] nvgtDist = (JSPUtil.getParameter(request, prefix	+ "nvgt_dist", length));
			String[] vslClssSubCd = (JSPUtil.getParameter(request, prefix	+ "vsl_clss_sub_cd", length));
			String[] fuelAdtvSavCostAmt = (JSPUtil.getParameter(request, prefix	+ "fuel_adtv_sav_cost_amt", length));
			String[] savCostCreYrmon = (JSPUtil.getParameter(request, prefix	+ "sav_cost_cre_yrmon", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] itmCsmRto = (JSPUtil.getParameter(request, prefix	+ "itm_csm_rto", length));
			String[] itmUtPrc = (JSPUtil.getParameter(request, prefix	+ "itm_ut_prc", length));
			String[] savRtoN1st = (JSPUtil.getParameter(request, prefix	+ "sav_rto_n1st", length));
			String[] savRtoN2nd = (JSPUtil.getParameter(request, prefix	+ "sav_rto_n2nd", length));
			String[] savRtoCons = (JSPUtil.getParameter(request, prefix	+ "sav_rto_cons", length));
			String[] fmYrmon = (JSPUtil.getParameter(request, prefix	+ "fm_yrmon", length));
			String[] toYrmon = (JSPUtil.getParameter(request, prefix	+ "to_yrmon", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new FcmMonFoilSavCostVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (fuelAdtvCsmWgt[i] != null)
					model.setFuelAdtvCsmWgt(fuelAdtvCsmWgt[i]);
				if (foilCsmWgt[i] != null)
					model.setFoilCsmWgt(foilCsmWgt[i]);
				if (fuelAdtvCsmCostAmt[i] != null)
					model.setFuelAdtvCsmCostAmt(fuelAdtvCsmCostAmt[i]);
				if (savRto[i] != null)
					model.setSavRto(savRto[i]);
				if (portPairSeaFoilCsmWgt[i] != null)
					model.setPortPairSeaFoilCsmWgt(portPairSeaFoilCsmWgt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (savQty[i] != null)
					model.setSavQty(savQty[i]);
				if (fuelAdtvDepCsmCostAmt[i] != null)
					model.setFuelAdtvDepCsmCostAmt(fuelAdtvDepCsmCostAmt[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vslClssCd[i] != null)
					model.setVslClssCd(vslClssCd[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (foilCsmCostAmt[i] != null)
					model.setFoilCsmCostAmt(foilCsmCostAmt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (lodIndQty[i] != null)
					model.setLodIndQty(lodIndQty[i]);
				if (savCostAmt[i] != null)
					model.setSavCostAmt(savCostAmt[i]);
				if (avgRpmPwr[i] != null)
					model.setAvgRpmPwr(avgRpmPwr[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (savItmCd[i] != null)
					model.setSavItmCd(savItmCd[i]);
				if (fuelAdtvUcAmt[i] != null)
					model.setFuelAdtvUcAmt(fuelAdtvUcAmt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (avgSpd[i] != null)
					model.setAvgSpd(avgSpd[i]);
				if (nvgtDist[i] != null)
					model.setNvgtDist(nvgtDist[i]);
				if (vslClssSubCd[i] != null)
					model.setVslClssSubCd(vslClssSubCd[i]);
				if (fuelAdtvSavCostAmt[i] != null)
					model.setFuelAdtvSavCostAmt(fuelAdtvSavCostAmt[i]);
				if (savCostCreYrmon[i] != null)
					model.setSavCostCreYrmon(savCostCreYrmon[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (itmCsmRto[i] != null)
					model.setItmCsmRto(itmCsmRto[i]);
				if (itmUtPrc[i] != null)
					model.setItmUtPrc(itmUtPrc[i]);
				if (savRtoN1st[i] != null)
					model.setSavRtoN1st(savRtoN1st[i]);
				if (savRtoN2nd[i] != null)
					model.setSavRtoN2nd(savRtoN2nd[i]);
				if (savRtoCons[i] != null)
					model.setSavRtoCons(savRtoCons[i]);
				if (fmYrmon[i] != null)
					model.setFmYrmon(fmYrmon[i]);
				if (toYrmon[i] != null)
					model.setToYrmon(toYrmon[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFcmMonFoilSavCostVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FcmMonFoilSavCostVO[]
	 */
	public FcmMonFoilSavCostVO[] getFcmMonFoilSavCostVOs(){
		FcmMonFoilSavCostVO[] vos = (FcmMonFoilSavCostVO[])models.toArray(new FcmMonFoilSavCostVO[models.size()]);
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
		this.fuelAdtvCsmWgt = this.fuelAdtvCsmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilCsmWgt = this.foilCsmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fuelAdtvCsmCostAmt = this.fuelAdtvCsmCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.savRto = this.savRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portPairSeaFoilCsmWgt = this.portPairSeaFoilCsmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.savQty = this.savQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fuelAdtvDepCsmCostAmt = this.fuelAdtvDepCsmCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslClssCd = this.vslClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilCsmCostAmt = this.foilCsmCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodIndQty = this.lodIndQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.savCostAmt = this.savCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgRpmPwr = this.avgRpmPwr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.savItmCd = this.savItmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fuelAdtvUcAmt = this.fuelAdtvUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgSpd = this.avgSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nvgtDist = this.nvgtDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslClssSubCd = this.vslClssSubCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fuelAdtvSavCostAmt = this.fuelAdtvSavCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.savCostCreYrmon = this.savCostCreYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itmCsmRto = this.itmCsmRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itmUtPrc = this.itmUtPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.savRtoN1st = this.savRtoN1st .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.savRtoN2nd = this.savRtoN2nd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.savRtoCons = this.savRtoCons .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmYrmon = this.fmYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toYrmon = this.toYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
