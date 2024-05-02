/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SearchQtaAdjustmentForSectorListVO.java
*@FileTitle : SearchQtaAdjustmentForSectorListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.14
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2016.03.14 최성민 
* 1.0 Creation
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
 * @author 최성민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchQtaAdjustmentForSectorListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchQtaAdjustmentForSectorListVO> models = new ArrayList<SearchQtaAdjustmentForSectorListVO>();
	
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String flag = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String bseMon = null;
	/* Column Info */
	private String bseTpCd = null;
	/* Column Info */
	private String masPfGrpCd = null;
	/* Column Info */
	private String masVvd = null;
	/* Column Info */
	private String masSlsYr = null;
	/* Column Info */
	private String masCostYr = null;
	/* Column Info */
	private String hulBndCd = null;
	/* Column Info */
	private String masSlsYrmon = null;
	/* Column Info */
	private String slsYrmon = null;
	/* Column Info */
	private String masBseYrmon = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String qtaRlseVerNo = null;
	/* Column Info */
	private String fnlBsaCapa = null;
	/* Column Info */
	private String lodQty = null;
	/* Column Info */
	private String pfSvcTpCd = null;
	/* Column Info */
	private String grsRev = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String masCostYrmon = null;
	/* Column Info */
	private String stsFlag = null;
	/* Column Info */
	private String bseYrmon = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String masBseMon = null;
	/* Column Info */
	private String bseWk = null;
	/* Column Info */
	private String fClick = null;
	/* Column Info */
	private String slsYr = null;
	/* Column Info */
	private String iasRgnCd = null;
	/* Column Info */
	private String bsaZrFlg = null;
	/* Column Info */
	private String pfGrpCd = null;
	/* Column Info */
	private String bseYr = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String masPfSvcTpCd = null;
	/* Column Info */
	private String masBseWk = null;
	/* Column Info */
	private String bseQtrCd = null;
	/* Column Info */
	private String masFnlBsaCapa = null;
	/* Column Info */
	private String revenueQuarter = null;
	/* Column Info */
	private String dirCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchQtaAdjustmentForSectorListVO() {}

	public SearchQtaAdjustmentForSectorListVO(String ibflag, String pagerows, String masBseWk, String trdCd, String masBseMon, String rlaneCd, String iasRgnCd, String fnlBsaCapa, String bseMon, String bseQtrCd, String bseYrmon, String bseTpCd, String dirCd, String slsYr, String iocCd, String qtaRlseVerNo, String lodQty, String fClick, String hulBndCd, String stsFlag, String masSlsYrmon, String masCostYrmon, String bseYr, String masBseYrmon, String masSlsYr, String masCostYr, String bseWk, String masVvd, String masFnlBsaCapa, String vvd, String slsYrmon, String flag, String grsRev, String subTrdCd, String revenueQuarter, String bsaZrFlg, String pfGrpCd, String pfSvcTpCd, String masPfGrpCd, String masPfSvcTpCd) {
		this.rlaneCd = rlaneCd;
		this.flag = flag;
		this.ibflag = ibflag;
		this.iocCd = iocCd;
		this.bseMon = bseMon;
		this.bseTpCd = bseTpCd;
		this.masPfGrpCd = masPfGrpCd;
		this.masVvd = masVvd;
		this.masSlsYr = masSlsYr;
		this.masCostYr = masCostYr;
		this.hulBndCd = hulBndCd;
		this.masSlsYrmon = masSlsYrmon;
		this.slsYrmon = slsYrmon;
		this.masBseYrmon = masBseYrmon;
		this.pagerows = pagerows;
		this.qtaRlseVerNo = qtaRlseVerNo;
		this.fnlBsaCapa = fnlBsaCapa;
		this.lodQty = lodQty;
		this.pfSvcTpCd = pfSvcTpCd;
		this.grsRev = grsRev;
		this.vvd = vvd;
		this.masCostYrmon = masCostYrmon;
		this.stsFlag = stsFlag;
		this.bseYrmon = bseYrmon;
		this.trdCd = trdCd;
		this.masBseMon = masBseMon;
		this.bseWk = bseWk;
		this.fClick = fClick;
		this.slsYr = slsYr;
		this.iasRgnCd = iasRgnCd;
		this.bsaZrFlg = bsaZrFlg;
		this.pfGrpCd = pfGrpCd;
		this.bseYr = bseYr;
		this.subTrdCd = subTrdCd;
		this.masPfSvcTpCd = masPfSvcTpCd;
		this.masBseWk = masBseWk;
		this.bseQtrCd = bseQtrCd;
		this.masFnlBsaCapa = masFnlBsaCapa;
		this.revenueQuarter = revenueQuarter;
		this.dirCd = dirCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("flag", getFlag());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("bse_mon", getBseMon());
		this.hashColumns.put("bse_tp_cd", getBseTpCd());
		this.hashColumns.put("mas_pf_grp_cd", getMasPfGrpCd());
		this.hashColumns.put("mas_vvd", getMasVvd());
		this.hashColumns.put("mas_sls_yr", getMasSlsYr());
		this.hashColumns.put("mas_cost_yr", getMasCostYr());
		this.hashColumns.put("hul_bnd_cd", getHulBndCd());
		this.hashColumns.put("mas_sls_yrmon", getMasSlsYrmon());
		this.hashColumns.put("sls_yrmon", getSlsYrmon());
		this.hashColumns.put("mas_bse_yrmon", getMasBseYrmon());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("qta_rlse_ver_no", getQtaRlseVerNo());
		this.hashColumns.put("fnl_bsa_capa", getFnlBsaCapa());
		this.hashColumns.put("lod_qty", getLodQty());
		this.hashColumns.put("pf_svc_tp_cd", getPfSvcTpCd());
		this.hashColumns.put("grs_rev", getGrsRev());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("mas_cost_yrmon", getMasCostYrmon());
		this.hashColumns.put("sts_flag", getStsFlag());
		this.hashColumns.put("bse_yrmon", getBseYrmon());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("mas_bse_mon", getMasBseMon());
		this.hashColumns.put("bse_wk", getBseWk());
		this.hashColumns.put("f_click", getFClick());
		this.hashColumns.put("sls_yr", getSlsYr());
		this.hashColumns.put("ias_rgn_cd", getIasRgnCd());
		this.hashColumns.put("bsa_zr_flg", getBsaZrFlg());
		this.hashColumns.put("pf_grp_cd", getPfGrpCd());
		this.hashColumns.put("bse_yr", getBseYr());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("mas_pf_svc_tp_cd", getMasPfSvcTpCd());
		this.hashColumns.put("mas_bse_wk", getMasBseWk());
		this.hashColumns.put("bse_qtr_cd", getBseQtrCd());
		this.hashColumns.put("mas_fnl_bsa_capa", getMasFnlBsaCapa());
		this.hashColumns.put("revenue_quarter", getRevenueQuarter());
		this.hashColumns.put("dir_cd", getDirCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("flag", "flag");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("bse_mon", "bseMon");
		this.hashFields.put("bse_tp_cd", "bseTpCd");
		this.hashFields.put("mas_pf_grp_cd", "masPfGrpCd");
		this.hashFields.put("mas_vvd", "masVvd");
		this.hashFields.put("mas_sls_yr", "masSlsYr");
		this.hashFields.put("mas_cost_yr", "masCostYr");
		this.hashFields.put("hul_bnd_cd", "hulBndCd");
		this.hashFields.put("mas_sls_yrmon", "masSlsYrmon");
		this.hashFields.put("sls_yrmon", "slsYrmon");
		this.hashFields.put("mas_bse_yrmon", "masBseYrmon");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("qta_rlse_ver_no", "qtaRlseVerNo");
		this.hashFields.put("fnl_bsa_capa", "fnlBsaCapa");
		this.hashFields.put("lod_qty", "lodQty");
		this.hashFields.put("pf_svc_tp_cd", "pfSvcTpCd");
		this.hashFields.put("grs_rev", "grsRev");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("mas_cost_yrmon", "masCostYrmon");
		this.hashFields.put("sts_flag", "stsFlag");
		this.hashFields.put("bse_yrmon", "bseYrmon");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("mas_bse_mon", "masBseMon");
		this.hashFields.put("bse_wk", "bseWk");
		this.hashFields.put("f_click", "fClick");
		this.hashFields.put("sls_yr", "slsYr");
		this.hashFields.put("ias_rgn_cd", "iasRgnCd");
		this.hashFields.put("bsa_zr_flg", "bsaZrFlg");
		this.hashFields.put("pf_grp_cd", "pfGrpCd");
		this.hashFields.put("bse_yr", "bseYr");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("mas_pf_svc_tp_cd", "masPfSvcTpCd");
		this.hashFields.put("mas_bse_wk", "masBseWk");
		this.hashFields.put("bse_qtr_cd", "bseQtrCd");
		this.hashFields.put("mas_fnl_bsa_capa", "masFnlBsaCapa");
		this.hashFields.put("revenue_quarter", "revenueQuarter");
		this.hashFields.put("dir_cd", "dirCd");
		return this.hashFields;
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
	 * @return flag
	 */
	public String getFlag() {
		return this.flag;
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
	 * @return iocCd
	 */
	public String getIocCd() {
		return this.iocCd;
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
	 * @return bseTpCd
	 */
	public String getBseTpCd() {
		return this.bseTpCd;
	}
	
	/**
	 * Column Info
	 * @return masPfGrpCd
	 */
	public String getMasPfGrpCd() {
		return this.masPfGrpCd;
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
	 * @return hulBndCd
	 */
	public String getHulBndCd() {
		return this.hulBndCd;
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
	 * @return slsYrmon
	 */
	public String getSlsYrmon() {
		return this.slsYrmon;
	}
	
	/**
	 * Column Info
	 * @return masBseYrmon
	 */
	public String getMasBseYrmon() {
		return this.masBseYrmon;
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
	 * @return qtaRlseVerNo
	 */
	public String getQtaRlseVerNo() {
		return this.qtaRlseVerNo;
	}
	
	/**
	 * Column Info
	 * @return fnlBsaCapa
	 */
	public String getFnlBsaCapa() {
		return this.fnlBsaCapa;
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
	 * @return pfSvcTpCd
	 */
	public String getPfSvcTpCd() {
		return this.pfSvcTpCd;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return stsFlag
	 */
	public String getStsFlag() {
		return this.stsFlag;
	}
	
	/**
	 * Column Info
	 * @return bseYrmon
	 */
	public String getBseYrmon() {
		return this.bseYrmon;
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
	 * @return bseWk
	 */
	public String getBseWk() {
		return this.bseWk;
	}
	
	/**
	 * Column Info
	 * @return fClick
	 */
	public String getFClick() {
		return this.fClick;
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
	 * @return iasRgnCd
	 */
	public String getIasRgnCd() {
		return this.iasRgnCd;
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
	 * @return pfGrpCd
	 */
	public String getPfGrpCd() {
		return this.pfGrpCd;
	}
	
	/**
	 * Column Info
	 * @return bseYr
	 */
	public String getBseYr() {
		return this.bseYr;
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
	 * @return masPfSvcTpCd
	 */
	public String getMasPfSvcTpCd() {
		return this.masPfSvcTpCd;
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
	 * @return bseQtrCd
	 */
	public String getBseQtrCd() {
		return this.bseQtrCd;
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
	 * @return revenueQuarter
	 */
	public String getRevenueQuarter() {
		return this.revenueQuarter;
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
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param flag
	 */
	public void setFlag(String flag) {
		this.flag = flag;
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
	 * @param iocCd
	 */
	public void setIocCd(String iocCd) {
		this.iocCd = iocCd;
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
	 * @param bseTpCd
	 */
	public void setBseTpCd(String bseTpCd) {
		this.bseTpCd = bseTpCd;
	}
	
	/**
	 * Column Info
	 * @param masPfGrpCd
	 */
	public void setMasPfGrpCd(String masPfGrpCd) {
		this.masPfGrpCd = masPfGrpCd;
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
	 * @param hulBndCd
	 */
	public void setHulBndCd(String hulBndCd) {
		this.hulBndCd = hulBndCd;
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
	 * @param slsYrmon
	 */
	public void setSlsYrmon(String slsYrmon) {
		this.slsYrmon = slsYrmon;
	}
	
	/**
	 * Column Info
	 * @param masBseYrmon
	 */
	public void setMasBseYrmon(String masBseYrmon) {
		this.masBseYrmon = masBseYrmon;
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
	 * @param qtaRlseVerNo
	 */
	public void setQtaRlseVerNo(String qtaRlseVerNo) {
		this.qtaRlseVerNo = qtaRlseVerNo;
	}
	
	/**
	 * Column Info
	 * @param fnlBsaCapa
	 */
	public void setFnlBsaCapa(String fnlBsaCapa) {
		this.fnlBsaCapa = fnlBsaCapa;
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
	 * @param pfSvcTpCd
	 */
	public void setPfSvcTpCd(String pfSvcTpCd) {
		this.pfSvcTpCd = pfSvcTpCd;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param stsFlag
	 */
	public void setStsFlag(String stsFlag) {
		this.stsFlag = stsFlag;
	}
	
	/**
	 * Column Info
	 * @param bseYrmon
	 */
	public void setBseYrmon(String bseYrmon) {
		this.bseYrmon = bseYrmon;
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
	 * @param bseWk
	 */
	public void setBseWk(String bseWk) {
		this.bseWk = bseWk;
	}
	
	/**
	 * Column Info
	 * @param fClick
	 */
	public void setFClick(String fClick) {
		this.fClick = fClick;
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
	 * @param iasRgnCd
	 */
	public void setIasRgnCd(String iasRgnCd) {
		this.iasRgnCd = iasRgnCd;
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
	 * @param pfGrpCd
	 */
	public void setPfGrpCd(String pfGrpCd) {
		this.pfGrpCd = pfGrpCd;
	}
	
	/**
	 * Column Info
	 * @param bseYr
	 */
	public void setBseYr(String bseYr) {
		this.bseYr = bseYr;
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
	 * @param masPfSvcTpCd
	 */
	public void setMasPfSvcTpCd(String masPfSvcTpCd) {
		this.masPfSvcTpCd = masPfSvcTpCd;
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
	 * @param bseQtrCd
	 */
	public void setBseQtrCd(String bseQtrCd) {
		this.bseQtrCd = bseQtrCd;
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
	 * @param revenueQuarter
	 */
	public void setRevenueQuarter(String revenueQuarter) {
		this.revenueQuarter = revenueQuarter;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
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
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setFlag(JSPUtil.getParameter(request, prefix + "flag", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setIocCd(JSPUtil.getParameter(request, prefix + "ioc_cd", ""));
		setBseMon(JSPUtil.getParameter(request, prefix + "bse_mon", ""));
		setBseTpCd(JSPUtil.getParameter(request, prefix + "bse_tp_cd", ""));
		setMasPfGrpCd(JSPUtil.getParameter(request, prefix + "mas_pf_grp_cd", ""));
		setMasVvd(JSPUtil.getParameter(request, prefix + "mas_vvd", ""));
		setMasSlsYr(JSPUtil.getParameter(request, prefix + "mas_sls_yr", ""));
		setMasCostYr(JSPUtil.getParameter(request, prefix + "mas_cost_yr", ""));
		setHulBndCd(JSPUtil.getParameter(request, prefix + "hul_bnd_cd", ""));
		setMasSlsYrmon(JSPUtil.getParameter(request, prefix + "mas_sls_yrmon", ""));
		setSlsYrmon(JSPUtil.getParameter(request, prefix + "sls_yrmon", ""));
		setMasBseYrmon(JSPUtil.getParameter(request, prefix + "mas_bse_yrmon", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setQtaRlseVerNo(JSPUtil.getParameter(request, prefix + "qta_rlse_ver_no", ""));
		setFnlBsaCapa(JSPUtil.getParameter(request, prefix + "fnl_bsa_capa", ""));
		setLodQty(JSPUtil.getParameter(request, prefix + "lod_qty", ""));
		setPfSvcTpCd(JSPUtil.getParameter(request, prefix + "pf_svc_tp_cd", ""));
		setGrsRev(JSPUtil.getParameter(request, prefix + "grs_rev", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setMasCostYrmon(JSPUtil.getParameter(request, prefix + "mas_cost_yrmon", ""));
		setStsFlag(JSPUtil.getParameter(request, prefix + "sts_flag", ""));
		setBseYrmon(JSPUtil.getParameter(request, prefix + "bse_yrmon", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setMasBseMon(JSPUtil.getParameter(request, prefix + "mas_bse_mon", ""));
		setBseWk(JSPUtil.getParameter(request, prefix + "bse_wk", ""));
		setFClick(JSPUtil.getParameter(request, prefix + "f_click", ""));
		setSlsYr(JSPUtil.getParameter(request, prefix + "sls_yr", ""));
		setIasRgnCd(JSPUtil.getParameter(request, prefix + "ias_rgn_cd", ""));
		setBsaZrFlg(JSPUtil.getParameter(request, prefix + "bsa_zr_flg", ""));
		setPfGrpCd(JSPUtil.getParameter(request, prefix + "pf_grp_cd", ""));
		setBseYr(JSPUtil.getParameter(request, prefix + "bse_yr", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setMasPfSvcTpCd(JSPUtil.getParameter(request, prefix + "mas_pf_svc_tp_cd", ""));
		setMasBseWk(JSPUtil.getParameter(request, prefix + "mas_bse_wk", ""));
		setBseQtrCd(JSPUtil.getParameter(request, prefix + "bse_qtr_cd", ""));
		setMasFnlBsaCapa(JSPUtil.getParameter(request, prefix + "mas_fnl_bsa_capa", ""));
		setRevenueQuarter(JSPUtil.getParameter(request, prefix + "revenue_quarter", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchQtaAdjustmentForSectorListVO[]
	 */
	public SearchQtaAdjustmentForSectorListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchQtaAdjustmentForSectorListVO[]
	 */
	public SearchQtaAdjustmentForSectorListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchQtaAdjustmentForSectorListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] flag = (JSPUtil.getParameter(request, prefix	+ "flag", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] bseMon = (JSPUtil.getParameter(request, prefix	+ "bse_mon", length));
			String[] bseTpCd = (JSPUtil.getParameter(request, prefix	+ "bse_tp_cd", length));
			String[] masPfGrpCd = (JSPUtil.getParameter(request, prefix	+ "mas_pf_grp_cd", length));
			String[] masVvd = (JSPUtil.getParameter(request, prefix	+ "mas_vvd", length));
			String[] masSlsYr = (JSPUtil.getParameter(request, prefix	+ "mas_sls_yr", length));
			String[] masCostYr = (JSPUtil.getParameter(request, prefix	+ "mas_cost_yr", length));
			String[] hulBndCd = (JSPUtil.getParameter(request, prefix	+ "hul_bnd_cd", length));
			String[] masSlsYrmon = (JSPUtil.getParameter(request, prefix	+ "mas_sls_yrmon", length));
			String[] slsYrmon = (JSPUtil.getParameter(request, prefix	+ "sls_yrmon", length));
			String[] masBseYrmon = (JSPUtil.getParameter(request, prefix	+ "mas_bse_yrmon", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] qtaRlseVerNo = (JSPUtil.getParameter(request, prefix	+ "qta_rlse_ver_no", length));
			String[] fnlBsaCapa = (JSPUtil.getParameter(request, prefix	+ "fnl_bsa_capa", length));
			String[] lodQty = (JSPUtil.getParameter(request, prefix	+ "lod_qty", length));
			String[] pfSvcTpCd = (JSPUtil.getParameter(request, prefix	+ "pf_svc_tp_cd", length));
			String[] grsRev = (JSPUtil.getParameter(request, prefix	+ "grs_rev", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] masCostYrmon = (JSPUtil.getParameter(request, prefix	+ "mas_cost_yrmon", length));
			String[] stsFlag = (JSPUtil.getParameter(request, prefix	+ "sts_flag", length));
			String[] bseYrmon = (JSPUtil.getParameter(request, prefix	+ "bse_yrmon", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] masBseMon = (JSPUtil.getParameter(request, prefix	+ "mas_bse_mon", length));
			String[] bseWk = (JSPUtil.getParameter(request, prefix	+ "bse_wk", length));
			String[] fClick = (JSPUtil.getParameter(request, prefix	+ "f_click", length));
			String[] slsYr = (JSPUtil.getParameter(request, prefix	+ "sls_yr", length));
			String[] iasRgnCd = (JSPUtil.getParameter(request, prefix	+ "ias_rgn_cd", length));
			String[] bsaZrFlg = (JSPUtil.getParameter(request, prefix	+ "bsa_zr_flg", length));
			String[] pfGrpCd = (JSPUtil.getParameter(request, prefix	+ "pf_grp_cd", length));
			String[] bseYr = (JSPUtil.getParameter(request, prefix	+ "bse_yr", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] masPfSvcTpCd = (JSPUtil.getParameter(request, prefix	+ "mas_pf_svc_tp_cd", length));
			String[] masBseWk = (JSPUtil.getParameter(request, prefix	+ "mas_bse_wk", length));
			String[] bseQtrCd = (JSPUtil.getParameter(request, prefix	+ "bse_qtr_cd", length));
			String[] masFnlBsaCapa = (JSPUtil.getParameter(request, prefix	+ "mas_fnl_bsa_capa", length));
			String[] revenueQuarter = (JSPUtil.getParameter(request, prefix	+ "revenue_quarter", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchQtaAdjustmentForSectorListVO();
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (flag[i] != null)
					model.setFlag(flag[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (bseMon[i] != null)
					model.setBseMon(bseMon[i]);
				if (bseTpCd[i] != null)
					model.setBseTpCd(bseTpCd[i]);
				if (masPfGrpCd[i] != null)
					model.setMasPfGrpCd(masPfGrpCd[i]);
				if (masVvd[i] != null)
					model.setMasVvd(masVvd[i]);
				if (masSlsYr[i] != null)
					model.setMasSlsYr(masSlsYr[i]);
				if (masCostYr[i] != null)
					model.setMasCostYr(masCostYr[i]);
				if (hulBndCd[i] != null)
					model.setHulBndCd(hulBndCd[i]);
				if (masSlsYrmon[i] != null)
					model.setMasSlsYrmon(masSlsYrmon[i]);
				if (slsYrmon[i] != null)
					model.setSlsYrmon(slsYrmon[i]);
				if (masBseYrmon[i] != null)
					model.setMasBseYrmon(masBseYrmon[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (qtaRlseVerNo[i] != null)
					model.setQtaRlseVerNo(qtaRlseVerNo[i]);
				if (fnlBsaCapa[i] != null)
					model.setFnlBsaCapa(fnlBsaCapa[i]);
				if (lodQty[i] != null)
					model.setLodQty(lodQty[i]);
				if (pfSvcTpCd[i] != null)
					model.setPfSvcTpCd(pfSvcTpCd[i]);
				if (grsRev[i] != null)
					model.setGrsRev(grsRev[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (masCostYrmon[i] != null)
					model.setMasCostYrmon(masCostYrmon[i]);
				if (stsFlag[i] != null)
					model.setStsFlag(stsFlag[i]);
				if (bseYrmon[i] != null)
					model.setBseYrmon(bseYrmon[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (masBseMon[i] != null)
					model.setMasBseMon(masBseMon[i]);
				if (bseWk[i] != null)
					model.setBseWk(bseWk[i]);
				if (fClick[i] != null)
					model.setFClick(fClick[i]);
				if (slsYr[i] != null)
					model.setSlsYr(slsYr[i]);
				if (iasRgnCd[i] != null)
					model.setIasRgnCd(iasRgnCd[i]);
				if (bsaZrFlg[i] != null)
					model.setBsaZrFlg(bsaZrFlg[i]);
				if (pfGrpCd[i] != null)
					model.setPfGrpCd(pfGrpCd[i]);
				if (bseYr[i] != null)
					model.setBseYr(bseYr[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (masPfSvcTpCd[i] != null)
					model.setMasPfSvcTpCd(masPfSvcTpCd[i]);
				if (masBseWk[i] != null)
					model.setMasBseWk(masBseWk[i]);
				if (bseQtrCd[i] != null)
					model.setBseQtrCd(bseQtrCd[i]);
				if (masFnlBsaCapa[i] != null)
					model.setMasFnlBsaCapa(masFnlBsaCapa[i]);
				if (revenueQuarter[i] != null)
					model.setRevenueQuarter(revenueQuarter[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchQtaAdjustmentForSectorListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchQtaAdjustmentForSectorListVO[]
	 */
	public SearchQtaAdjustmentForSectorListVO[] getSearchQtaAdjustmentForSectorListVOs(){
		SearchQtaAdjustmentForSectorListVO[] vos = (SearchQtaAdjustmentForSectorListVO[])models.toArray(new SearchQtaAdjustmentForSectorListVO[models.size()]);
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
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flag = this.flag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseMon = this.bseMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseTpCd = this.bseTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masPfGrpCd = this.masPfGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masVvd = this.masVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masSlsYr = this.masSlsYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masCostYr = this.masCostYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hulBndCd = this.hulBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masSlsYrmon = this.masSlsYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsYrmon = this.slsYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masBseYrmon = this.masBseYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtaRlseVerNo = this.qtaRlseVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlBsaCapa = this.fnlBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodQty = this.lodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfSvcTpCd = this.pfSvcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsRev = this.grsRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masCostYrmon = this.masCostYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsFlag = this.stsFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYrmon = this.bseYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masBseMon = this.masBseMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseWk = this.bseWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fClick = this.fClick .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsYr = this.slsYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iasRgnCd = this.iasRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaZrFlg = this.bsaZrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfGrpCd = this.pfGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYr = this.bseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masPfSvcTpCd = this.masPfSvcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masBseWk = this.masBseWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseQtrCd = this.bseQtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masFnlBsaCapa = this.masFnlBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revenueQuarter = this.revenueQuarter .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
