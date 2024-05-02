/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SearchQtaAdjustmentListVO.java
*@FileTitle : SearchQtaAdjustmentListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.25  
* 1.0 Creation
* 2015.07.22 김용습 [CHM-201537172] [CSR 전환건] QTA Adjustment by VVD 화면 내 신규 기능 추가
* 2015.08.13 김용습 [CHM-201537586] QTA Adjustment by VVD 화면내 BSA Flag 칼럼 추가 
* 2015.09.09 김용습 [CHM-201537818] QTA Adjustment by VVD, QTA Adjustment by VVD for IAS Sector 두 화면내 칼럼 수정
* 2016.03.22 CHM-201640709 Adjusted 클릭시 Contract 컬럼을 Contract O/B와 Contract N/OB로 나눠서 보여주도록 로직 수정
=========================================================*/

package com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchQtaAdjustmentListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchQtaAdjustmentListVO> models = new ArrayList<SearchQtaAdjustmentListVO>();
	
	/* Column Info */
	private String masBseWk = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String masBseMon = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String fnlBsaCapa = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bseMon = null;
	/* Column Info */
	private String bseYrmon = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String potnLnk = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String slsYr = null;
	/* Column Info */
	private String qtaRlseVerNo = null;
	/* Column Info */
	private String lodQty = null;
	/* Column Info */
	private String hulBndCd = null;
	/* Column Info */
	private String masLodQty = null;
	/* Column Info */
	private String stsFlag = null;
	/* Column Info */
	private String masSlsYrmon = null;
	/* Column Info */
	private String masCostYrmon = null;
	/* Column Info */
	private String masBseYrmon = null;
	/* Column Info */
	private String masSlsYr = null;
	/* Column Info */
	private String masCostYr = null;
	/* Column Info */
	private String bseWk = null;
	/* Column Info */
	private String masFnlBsaCapa = null;
	/* Column Info */
	private String masVvd = null;
	/* Column Info */
	private String slsYrmon = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String sqmCngTpCd = null;
	/* Column Info */
	private String flag = null;
	/* Column Info */
	private String grsRev = null;
	/* Column Info */
	private String masGrsRev = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String holResult = null;
	/* Column Info */
	private String hocResult = null;
	/* Column Info */
	private String rhqlResult = null;
	/* Column Info */
	private String rhqOCResult = null;
	/* Column Info */
	private String rhqNCResult = null;
	/* Column Info */
	private String bsaZrFlg = null;
	/* Column Info */
	private String revenueQuarter = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchQtaAdjustmentListVO() {}

	public SearchQtaAdjustmentListVO(String ibflag, String pagerows, String masBseWk, String trdCd, String rlaneCd, String masBseMon, String fnlBsaCapa, String bseMon, String potnLnk, String dirCd, String slsYr, String iocCd, String qtaRlseVerNo, String lodQty, String hulBndCd, String masLodQty, String stsFlag, String masSlsYrmon, String masCostYrmon, String masSlsYr, String masCostYr, String bseWk, String masFnlBsaCapa, String masVvd, String slsYrmon, String vvd, String sqmCngTpCd, String flag, String masGrsRev, String grsRev, String subTrdCd, String bseYrmon, String masBseYrmon, String holResult, String hocResult, String rhqlResult, String rhqOCResult, String rhqNCResult,String bsaZrFlg, String revenueQuarter) {
		this.masBseWk = masBseWk;
		this.trdCd = trdCd;
		this.masBseMon = masBseMon;
		this.rlaneCd = rlaneCd;
		this.fnlBsaCapa = fnlBsaCapa;
		this.pagerows = pagerows;
		this.bseMon = bseMon;
		this.bseYrmon = bseYrmon;
		this.ibflag = ibflag;
		this.potnLnk = potnLnk;
		this.dirCd = dirCd;
		this.iocCd = iocCd;
		this.slsYr = slsYr;
		this.qtaRlseVerNo = qtaRlseVerNo;
		this.lodQty = lodQty;
		this.hulBndCd = hulBndCd;
		this.masLodQty = masLodQty;
		this.stsFlag = stsFlag;
		this.masSlsYrmon = masSlsYrmon;
		this.masCostYrmon = masCostYrmon;
		this.masBseYrmon = masBseYrmon;
		this.masSlsYr = masSlsYr;
		this.masCostYr = masCostYr;
		this.bseWk = bseWk;
		this.masFnlBsaCapa = masFnlBsaCapa;
		this.masVvd = masVvd;
		this.slsYrmon = slsYrmon;
		this.vvd = vvd;
		this.sqmCngTpCd = sqmCngTpCd;
		this.flag = flag;
		this.grsRev = grsRev;
		this.masGrsRev = masGrsRev;
		this.subTrdCd = subTrdCd;
		this.holResult = holResult;
		this.hocResult = hocResult;
		this.rhqlResult = rhqlResult;
		this.rhqOCResult = rhqOCResult;
		this.rhqNCResult = rhqNCResult;
		this.bsaZrFlg = bsaZrFlg;
		this.revenueQuarter = revenueQuarter;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mas_bse_wk", getMasBseWk());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("mas_bse_mon", getMasBseMon());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("fnl_bsa_capa", getFnlBsaCapa());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bse_mon", getBseMon());
		this.hashColumns.put("bse_yrmon", getBseYrmon());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("potn_lnk", getPotnLnk());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("sls_yr", getSlsYr());
		this.hashColumns.put("qta_rlse_ver_no", getQtaRlseVerNo());
		this.hashColumns.put("lod_qty", getLodQty());
		this.hashColumns.put("hul_bnd_cd", getHulBndCd());
		this.hashColumns.put("mas_lod_qty", getMasLodQty());
		this.hashColumns.put("sts_flag", getStsFlag());
		this.hashColumns.put("mas_sls_yrmon", getMasSlsYrmon());
		this.hashColumns.put("mas_cost_yrmon", getMasCostYrmon());
		this.hashColumns.put("mas_bse_yrmon", getMasBseYrmon());
		this.hashColumns.put("mas_sls_yr", getMasSlsYr());
		this.hashColumns.put("mas_cost_yr", getMasCostYr());
		this.hashColumns.put("bse_wk", getBseWk());
		this.hashColumns.put("mas_fnl_bsa_capa", getMasFnlBsaCapa());
		this.hashColumns.put("mas_vvd", getMasVvd());
		this.hashColumns.put("sls_yrmon", getSlsYrmon());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("sqm_cng_tp_cd", getSqmCngTpCd());
		this.hashColumns.put("flag", getFlag());
		this.hashColumns.put("grs_rev", getGrsRev());
		this.hashColumns.put("mas_grs_rev", getMasGrsRev());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("hol_result", getHolResult());
		this.hashColumns.put("hoc_result", getHocResult());
		this.hashColumns.put("rhql_result", getRhqlResult());
		this.hashColumns.put("rhqoc_result", getRhqOCResult());
		this.hashColumns.put("rhqnc_result", getRhqNCResult());
		this.hashColumns.put("bsa_zr_flg", getBsaZrFlg());
		this.hashColumns.put("revenue_quarter", getRevenueQuarter());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mas_bse_wk", "masBseWk");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("mas_bse_mon", "masBseMon");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("fnl_bsa_capa", "fnlBsaCapa");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bse_mon", "bseMon");
		this.hashFields.put("bse_yrmon", "bseYrmon");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("potn_lnk", "potnLnk");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("sls_yr", "slsYr");
		this.hashFields.put("qta_rlse_ver_no", "qtaRlseVerNo");
		this.hashFields.put("lod_qty", "lodQty");
		this.hashFields.put("hul_bnd_cd", "hulBndCd");
		this.hashFields.put("mas_lod_qty", "masLodQty");
		this.hashFields.put("sts_flag", "stsFlag");
		this.hashFields.put("mas_sls_yrmon", "masSlsYrmon");
		this.hashFields.put("mas_cost_yrmon", "masCostYrmon");
		this.hashFields.put("mas_bse_yrmon", "masBseYrmon");
		this.hashFields.put("mas_sls_yr", "masSlsYr");
		this.hashFields.put("mas_cost_yr", "masCostYr");
		this.hashFields.put("bse_wk", "bseWk");
		this.hashFields.put("mas_fnl_bsa_capa", "masFnlBsaCapa");
		this.hashFields.put("mas_vvd", "masVvd");
		this.hashFields.put("sls_yrmon", "slsYrmon");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("sqm_cng_tp_cd", "sqmCngTpCd");
		this.hashFields.put("flag", "flag");
		this.hashFields.put("grs_rev", "grsRev");
		this.hashFields.put("mas_grs_rev", "masGrsRev");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("hol_result", "holResult");
		this.hashFields.put("hoc_result", "hocResult");
		this.hashFields.put("rhql_result", "rhqlResult");
		this.hashFields.put("rhqoc_result", "rhqOCResult");
		this.hashFields.put("rhqnc_result", "rhqNCResult");
		this.hashFields.put("bsa_zr_flg", "bsaZrFlg");
		this.hashFields.put("revenue_quarter", "revenueQuarter");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return masBseWk
	 */
	public String getMasBseWk() {
		return this.masBseWk;
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
	 * @return masBseMon
	 */
	public String getMasBseMon() {
		return this.masBseMon;
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
	 * @return fnlBsaCapa
	 */
	public String getFnlBsaCapa() {
		return this.fnlBsaCapa;
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
	 * @return bseMon
	 */
	public String getBseMon() {
		return this.bseMon;
	}
	
	/**
	 * Column Info
	 * @return bseYrmon
	 */
	public String getBseYrmon() {
		return this.bseYrmon;
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
	 * @return potnLnk
	 */
	public String getPotnLnk() {
		return this.potnLnk;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return iocCd
	 */
	public String getIocCd() {
		return this.iocCd;
	}
	
	/**
	 * Column Info
	 * @return slsYr
	 */
	public String getSlsYr() {
		return this.slsYr;
	}
	
	/**
	 * Column Info
	 * @return qtaRlseVerNo
	 */
	public String getQtaRlseVerNo() {
		return this.qtaRlseVerNo;
	}
	
	/**
	 * Column Info
	 * @return lodQty
	 */
	public String getLodQty() {
		return this.lodQty;
	}
	
	/**
	 * Column Info
	 * @return hulBndCd
	 */
	public String getHulBndCd() {
		return this.hulBndCd;
	}
	
	/**
	 * Column Info
	 * @return masLodQty
	 */
	public String getMasLodQty() {
		return this.masLodQty;
	}
	
	/**
	 * Column Info
	 * @return stsFlag
	 */
	public String getStsFlag() {
		return this.stsFlag;
	}
	
	/**
	 * Column Info
	 * @return masSlsYrmon
	 */
	public String getMasSlsYrmon() {
		return this.masSlsYrmon;
	}
	
	/**
	 * Column Info
	 * @return masCostYrmon
	 */
	public String getMasCostYrmon() {
		return this.masCostYrmon;
	}
	
	/**
	 * Column Info
	 * @return masBseYrmon
	 */
	public String getMasBseYrmon() {
		return this.masBseYrmon;
	}
	
	/**
	 * Column Info
	 * @return masSlsYr
	 */
	public String getMasSlsYr() {
		return this.masSlsYr;
	}
	
	/**
	 * Column Info
	 * @return masCostYr
	 */
	public String getMasCostYr() {
		return this.masCostYr;
	}
	
	/**
	 * Column Info
	 * @return bseWk
	 */
	public String getBseWk() {
		return this.bseWk;
	}
	
	/**
	 * Column Info
	 * @return masFnlBsaCapa
	 */
	public String getMasFnlBsaCapa() {
		return this.masFnlBsaCapa;
	}
	
	/**
	 * Column Info
	 * @return masVvd
	 */
	public String getMasVvd() {
		return this.masVvd;
	}
	
	/**
	 * Column Info
	 * @return slsYrmon
	 */
	public String getSlsYrmon() {
		return this.slsYrmon;
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
	 * @return sqmCngTpCd
	 */
	public String getSqmCngTpCd() {
		return this.sqmCngTpCd;
	}
	
	/**
	 * Column Info
	 * @return flag
	 */
	public String getFlag() {
		return this.flag;
	}
	
	/**
	 * Column Info
	 * @return grsRev
	 */
	public String getGrsRev() {
		return this.grsRev;
	}
	
	/**
	 * Column Info
	 * @return masGrsRev
	 */
	public String getMasGrsRev() {
		return this.masGrsRev;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	
	/**
	 * Column Info
	 * @return holResult
	 */
	public String getHolResult() {
		return this.holResult;
	}
	
	/**
	 * Column Info
	 * @return hocResult
	 */
	public String getHocResult() {
		return this.hocResult;
	}
	
	/**
	 * Column Info
	 * @return rhqlResult
	 */
	public String getRhqlResult() {
		return this.rhqlResult;
	}
	
	/**
	 * Column Info
	 * @return rhqOCResult
	 */
	public String getRhqOCResult() {
		return this.rhqOCResult;
	}
	
	/**
	 * Column Info
	 * @return rhqNCResult
	 */
	public String getRhqNCResult() {
		return this.rhqNCResult;
	}
	
	/**
	 * Column Info
	 * @return bsaZrFlg
	 */
	public String getBsaZrFlg() {
		return this.bsaZrFlg;
	}
	
	/**
	 * Column Info
	 * @return revenueQuarter
	 */
	public String getRevenueQuarter() {
		return this.revenueQuarter;
	}
	

	/**
	 * Column Info
	 * @param masBseWk
	 */
	public void setMasBseWk(String masBseWk) {
		this.masBseWk = masBseWk;
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
	 * @param masBseMon
	 */
	public void setMasBseMon(String masBseMon) {
		this.masBseMon = masBseMon;
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
	 * @param fnlBsaCapa
	 */
	public void setFnlBsaCapa(String fnlBsaCapa) {
		this.fnlBsaCapa = fnlBsaCapa;
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
	 * @param bseMon
	 */
	public void setBseMon(String bseMon) {
		this.bseMon = bseMon;
	}
	
	/**
	 * Column Info
	 * @param bseYrmon
	 */
	public void setBseYrmon(String bseYrmon) {
		this.bseYrmon = bseYrmon;
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
	 * @param potnLnk
	 */
	public void setPotnLnk(String potnLnk) {
		this.potnLnk = potnLnk;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param iocCd
	 */
	public void setIocCd(String iocCd) {
		this.iocCd = iocCd;
	}
	
	/**
	 * Column Info
	 * @param slsYr
	 */
	public void setSlsYr(String slsYr) {
		this.slsYr = slsYr;
	}
	
	/**
	 * Column Info
	 * @param qtaRlseVerNo
	 */
	public void setQtaRlseVerNo(String qtaRlseVerNo) {
		this.qtaRlseVerNo = qtaRlseVerNo;
	}
	
	/**
	 * Column Info
	 * @param lodQty
	 */
	public void setLodQty(String lodQty) {
		this.lodQty = lodQty;
	}
	
	/**
	 * Column Info
	 * @param hulBndCd
	 */
	public void setHulBndCd(String hulBndCd) {
		this.hulBndCd = hulBndCd;
	}
	
	/**
	 * Column Info
	 * @param masLodQty
	 */
	public void setMasLodQty(String masLodQty) {
		this.masLodQty = masLodQty;
	}
	
	/**
	 * Column Info
	 * @param stsFlag
	 */
	public void setStsFlag(String stsFlag) {
		this.stsFlag = stsFlag;
	}
	
	/**
	 * Column Info
	 * @param masSlsYrmon
	 */
	public void setMasSlsYrmon(String masSlsYrmon) {
		this.masSlsYrmon = masSlsYrmon;
	}
	
	/**
	 * Column Info
	 * @param masCostYrmon
	 */
	public void setMasCostYrmon(String masCostYrmon) {
		this.masCostYrmon = masCostYrmon;
	}
	
	/**
	 * Column Info
	 * @param masBseYrmon
	 */
	public void setMasBseYrmon(String masBseYrmon) {
		this.masBseYrmon = masBseYrmon;
	}
	
	/**
	 * Column Info
	 * @param masSlsYr
	 */
	public void setMasSlsYr(String masSlsYr) {
		this.masSlsYr = masSlsYr;
	}
	
	/**
	 * Column Info
	 * @param masCostYr
	 */
	public void setMasCostYr(String masCostYr) {
		this.masCostYr = masCostYr;
	}
	
	/**
	 * Column Info
	 * @param bseWk
	 */
	public void setBseWk(String bseWk) {
		this.bseWk = bseWk;
	}
	
	/**
	 * Column Info
	 * @param masFnlBsaCapa
	 */
	public void setMasFnlBsaCapa(String masFnlBsaCapa) {
		this.masFnlBsaCapa = masFnlBsaCapa;
	}
	
	/**
	 * Column Info
	 * @param masVvd
	 */
	public void setMasVvd(String masVvd) {
		this.masVvd = masVvd;
	}
	
	/**
	 * Column Info
	 * @param slsYrmon
	 */
	public void setSlsYrmon(String slsYrmon) {
		this.slsYrmon = slsYrmon;
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
	 * @param sqmCngTpCd
	 */
	public void setSqmCngTpCd(String sqmCngTpCd) {
		this.sqmCngTpCd = sqmCngTpCd;
	}
	
	/**
	 * Column Info
	 * @param flag
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	/**
	 * Column Info
	 * @param grsRev
	 */
	public void setGrsRev(String grsRev) {
		this.grsRev = grsRev;
	}
	
	/**
	 * Column Info
	 * @param masGrsRev
	 */
	public void setMasGrsRev(String masGrsRev) {
		this.masGrsRev = masGrsRev;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Column Info
	 * @param holResult
	 */
	public void setHolResult(String holResult) {
		this.holResult = holResult;
	}
	
	/**
	 * Column Info
	 * @param hocResult
	 */
	public void setHocResult(String hocResult) {
		this.hocResult = hocResult;
	}
	
	/**
	 * Column Info
	 * @param holResult
	 */
	public void setRhqlResult(String rhqlResult) {
		this.rhqlResult = rhqlResult;
	}
	
	/**
	 * Column Info
	 * @param rhqOCResult
	 */
	public void setRhqOCResult(String rhqOCResult) {
		this.rhqOCResult = rhqOCResult;
	}
	
	/**
	 * Column Info
	 * @param rhqNCResult
	 */
	public void setRhqNCResult(String rhqNCResult) {
		this.rhqNCResult = rhqNCResult;
	}
	
	/**
	 * Column Info
	 * @param bsaZrFlg
	 */
	public void setBsaZrFlg(String bsaZrFlg) {
		this.bsaZrFlg = bsaZrFlg;
	}
	
	/**
	 * Column Info
	 * @param revenueQuarter
	 */
	public void setRevenueQuarter(String revenueQuarter) {
		this.revenueQuarter = revenueQuarter;
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
		setMasBseWk(JSPUtil.getParameter(request, prefix + "mas_bse_wk", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setMasBseMon(JSPUtil.getParameter(request, prefix + "mas_bse_mon", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setFnlBsaCapa(JSPUtil.getParameter(request, prefix + "fnl_bsa_capa", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBseMon(JSPUtil.getParameter(request, prefix + "bse_mon", ""));
		setBseYrmon(JSPUtil.getParameter(request, prefix + "bse_yrmon", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPotnLnk(JSPUtil.getParameter(request, prefix + "potn_lnk", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setIocCd(JSPUtil.getParameter(request, prefix + "ioc_cd", ""));
		setSlsYr(JSPUtil.getParameter(request, prefix + "sls_yr", ""));
		setQtaRlseVerNo(JSPUtil.getParameter(request, prefix + "qta_rlse_ver_no", ""));
		setLodQty(JSPUtil.getParameter(request, prefix + "lod_qty", ""));
		setHulBndCd(JSPUtil.getParameter(request, prefix + "hul_bnd_cd", ""));
		setMasLodQty(JSPUtil.getParameter(request, prefix + "mas_lod_qty", ""));
		setStsFlag(JSPUtil.getParameter(request, prefix + "sts_flag", ""));
		setMasSlsYrmon(JSPUtil.getParameter(request, prefix + "mas_sls_yrmon", ""));
		setMasCostYrmon(JSPUtil.getParameter(request, prefix + "mas_cost_yrmon", ""));
		setMasBseYrmon(JSPUtil.getParameter(request, prefix + "mas_bse_yrmon", ""));
		setMasSlsYr(JSPUtil.getParameter(request, prefix + "mas_sls_yr", ""));
		setMasCostYr(JSPUtil.getParameter(request, prefix + "mas_cost_yr", ""));
		setBseWk(JSPUtil.getParameter(request, prefix + "bse_wk", ""));
		setMasFnlBsaCapa(JSPUtil.getParameter(request, prefix + "mas_fnl_bsa_capa", ""));
		setMasVvd(JSPUtil.getParameter(request, prefix + "mas_vvd", ""));
		setSlsYrmon(JSPUtil.getParameter(request, prefix + "sls_yrmon", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setSqmCngTpCd(JSPUtil.getParameter(request, prefix + "sqm_cng_tp_cd", ""));
		setFlag(JSPUtil.getParameter(request, prefix + "flag", ""));
		setGrsRev(JSPUtil.getParameter(request, prefix + "grs_rev", ""));
		setMasGrsRev(JSPUtil.getParameter(request, prefix + "mas_grs_rev", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setHolResult(JSPUtil.getParameter(request, prefix + "hol_result", ""));
		setHocResult(JSPUtil.getParameter(request, prefix + "hoc_result", ""));
		setRhqlResult(JSPUtil.getParameter(request, prefix + "rhql_result", ""));
		setRhqOCResult(JSPUtil.getParameter(request, prefix + "rhqoc_result", ""));
		setRhqNCResult(JSPUtil.getParameter(request, prefix + "rhqnc_result", ""));
		setBsaZrFlg(JSPUtil.getParameter(request, prefix + "bsa_zr_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchQtaAdjustmentListVO[]
	 */
	public SearchQtaAdjustmentListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchQtaAdjustmentListVO[]
	 */
	public SearchQtaAdjustmentListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchQtaAdjustmentListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] masBseWk = (JSPUtil.getParameter(request, prefix	+ "mas_bse_wk", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] masBseMon = (JSPUtil.getParameter(request, prefix	+ "mas_bse_mon", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] fnlBsaCapa = (JSPUtil.getParameter(request, prefix	+ "fnl_bsa_capa", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bseMon = (JSPUtil.getParameter(request, prefix	+ "bse_mon", length));
			String[] bseYrmon = (JSPUtil.getParameter(request, prefix	+ "bse_yrmon", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] potnLnk = (JSPUtil.getParameter(request, prefix	+ "potn_lnk", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] slsYr = (JSPUtil.getParameter(request, prefix	+ "sls_yr", length));
			String[] qtaRlseVerNo = (JSPUtil.getParameter(request, prefix	+ "qta_rlse_ver_no", length));
			String[] lodQty = (JSPUtil.getParameter(request, prefix	+ "lod_qty", length));
			String[] hulBndCd = (JSPUtil.getParameter(request, prefix	+ "hul_bnd_cd", length));
			String[] masLodQty = (JSPUtil.getParameter(request, prefix	+ "mas_lod_qty", length));
			String[] stsFlag = (JSPUtil.getParameter(request, prefix	+ "sts_flag", length));
			String[] masSlsYrmon = (JSPUtil.getParameter(request, prefix	+ "mas_sls_yrmon", length));
			String[] masCostYrmon = (JSPUtil.getParameter(request, prefix	+ "mas_cost_yrmon", length));
			String[] masBseYrmon = (JSPUtil.getParameter(request, prefix	+ "mas_bse_yrmon", length));
			String[] masSlsYr = (JSPUtil.getParameter(request, prefix	+ "mas_sls_yr", length));
			String[] masCostYr = (JSPUtil.getParameter(request, prefix	+ "mas_cost_yr", length));
			String[] bseWk = (JSPUtil.getParameter(request, prefix	+ "bse_wk", length));
			String[] masFnlBsaCapa = (JSPUtil.getParameter(request, prefix	+ "mas_fnl_bsa_capa", length));
			String[] masVvd = (JSPUtil.getParameter(request, prefix	+ "mas_vvd", length));
			String[] slsYrmon = (JSPUtil.getParameter(request, prefix	+ "sls_yrmon", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] sqmCngTpCd = (JSPUtil.getParameter(request, prefix	+ "sqm_cng_tp_cd", length));
			String[] flag = (JSPUtil.getParameter(request, prefix	+ "flag", length));
			String[] grsRev = (JSPUtil.getParameter(request, prefix	+ "grs_rev", length));
			String[] masGrsRev = (JSPUtil.getParameter(request, prefix	+ "mas_grs_rev", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] holResult = (JSPUtil.getParameter(request, prefix	+ "hol_result", length));
			String[] hocResult = (JSPUtil.getParameter(request, prefix	+ "hoc_result", length));
			String[] rhqlResult = (JSPUtil.getParameter(request, prefix	+ "rhql_result", length));
			String[] rhqOCResult = (JSPUtil.getParameter(request, prefix	+ "rhqoc_result", length));
			String[] rhqNCResult = (JSPUtil.getParameter(request, prefix	+ "rhqnc_result", length));
			String[] bsaZrFlg = (JSPUtil.getParameter(request, prefix	+ "bsa_zr_flg", length));
			String[] revenueQuarter = (JSPUtil.getParameter(request, prefix	+ "revenue_quarter", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchQtaAdjustmentListVO();
				if (masBseWk[i] != null)
					model.setMasBseWk(masBseWk[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (masBseMon[i] != null)
					model.setMasBseMon(masBseMon[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (fnlBsaCapa[i] != null)
					model.setFnlBsaCapa(fnlBsaCapa[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bseMon[i] != null)
					model.setBseMon(bseMon[i]);
				if (bseYrmon[i] != null)
					model.setBseYrmon(bseYrmon[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (potnLnk[i] != null)
					model.setPotnLnk(potnLnk[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (slsYr[i] != null)
					model.setSlsYr(slsYr[i]);
				if (qtaRlseVerNo[i] != null)
					model.setQtaRlseVerNo(qtaRlseVerNo[i]);
				if (lodQty[i] != null)
					model.setLodQty(lodQty[i]);
				if (hulBndCd[i] != null)
					model.setHulBndCd(hulBndCd[i]);
				if (masLodQty[i] != null)
					model.setMasLodQty(masLodQty[i]);
				if (stsFlag[i] != null)
					model.setStsFlag(stsFlag[i]);
				if (masSlsYrmon[i] != null)
					model.setMasSlsYrmon(masSlsYrmon[i]);
				if (masCostYrmon[i] != null)
					model.setMasCostYrmon(masCostYrmon[i]);
				if (masBseYrmon[i] != null)
					model.setMasBseYrmon(masBseYrmon[i]);
				if (masSlsYr[i] != null)
					model.setMasSlsYr(masSlsYr[i]);
				if (masCostYr[i] != null)
					model.setMasCostYr(masCostYr[i]);
				if (bseWk[i] != null)
					model.setBseWk(bseWk[i]);
				if (masFnlBsaCapa[i] != null)
					model.setMasFnlBsaCapa(masFnlBsaCapa[i]);
				if (masVvd[i] != null)
					model.setMasVvd(masVvd[i]);
				if (slsYrmon[i] != null)
					model.setSlsYrmon(slsYrmon[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (sqmCngTpCd[i] != null)
					model.setSqmCngTpCd(sqmCngTpCd[i]);
				if (flag[i] != null)
					model.setFlag(flag[i]);
				if (grsRev[i] != null)
					model.setGrsRev(grsRev[i]);
				if (masGrsRev[i] != null)
					model.setMasGrsRev(masGrsRev[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (holResult[i] != null)
					model.setHolResult(holResult[i]);
				if (hocResult[i] != null)
					model.setHocResult(hocResult[i]);
				if (rhqlResult[i] != null)
					model.setRhqlResult(rhqlResult[i]);
				if (rhqOCResult[i] != null)
					model.setRhqOCResult(rhqOCResult[i]);
				if (rhqNCResult[i] != null)
					model.setRhqNCResult(rhqNCResult[i]);
				if (bsaZrFlg[i] != null)
					model.setBsaZrFlg(bsaZrFlg[i]);
				if (revenueQuarter[i] != null)
					model.setRevenueQuarter(revenueQuarter[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchQtaAdjustmentListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchQtaAdjustmentListVO[]
	 */
	public SearchQtaAdjustmentListVO[] getSearchQtaAdjustmentListVOs(){
		SearchQtaAdjustmentListVO[] vos = (SearchQtaAdjustmentListVO[])models.toArray(new SearchQtaAdjustmentListVO[models.size()]);
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
		this.masBseWk = this.masBseWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masBseMon = this.masBseMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlBsaCapa = this.fnlBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseMon = this.bseMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYrmon = this.bseYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.potnLnk = this.potnLnk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsYr = this.slsYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtaRlseVerNo = this.qtaRlseVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodQty = this.lodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hulBndCd = this.hulBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masLodQty = this.masLodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsFlag = this.stsFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masSlsYrmon = this.masSlsYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masCostYrmon = this.masCostYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masBseYrmon = this.masBseYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masSlsYr = this.masSlsYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masCostYr = this.masCostYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseWk = this.bseWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masFnlBsaCapa = this.masFnlBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masVvd = this.masVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsYrmon = this.slsYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sqmCngTpCd = this.sqmCngTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flag = this.flag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsRev = this.grsRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masGrsRev = this.masGrsRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.holResult = this.holResult .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hocResult = this.hocResult .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqlResult = this.rhqlResult .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqOCResult = this.rhqOCResult .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqNCResult = this.rhqNCResult .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaZrFlg = this.bsaZrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revenueQuarter = this.revenueQuarter .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
