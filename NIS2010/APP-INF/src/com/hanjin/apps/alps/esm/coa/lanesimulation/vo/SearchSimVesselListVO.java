/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : searchSimVesselListVO.java
*@FileTitle : searchSimVesselListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2009.08.06 윤진영 
* 1.0 Creation
* 2010.02.18 윤진영 미사용 변수 삭제
=========================================================*/

package com.hanjin.apps.alps.esm.coa.lanesimulation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 윤진영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSimVesselListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSimVesselListVO> models = new ArrayList<SearchSimVesselListVO>();
	
	/* Column Info */
	private String otrCrrBsaCapa2 = null;
	/* Column Info */
	private String subLseCapa3 = null;
	/* Column Info */
	private String subLseCapa4 = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String otrCrrBsaCapa1 = null;
	/* Column Info */
	private String hjsBfrBsaCapa = null;
	/* Column Info */
	private String otrCrrBsaCapa4 = null;
	/* Column Info */
	private String subLseCapa1 = null;
	/* Column Info */
	private String otrCrrBsaCapa3 = null;
	/* Column Info */
	private String subLseCapa2 = null;
	/* Column Info */
	private String subChtrCapa5 = null;
	/* Column Info */
	private String subChtrCapa4 = null;
	/* Column Info */
	private String otrCrrBsaCapa5 = null;
	/* Column Info */
	private String subChtrCapa3 = null;
	/* Column Info */
	private String subChtrCapa2 = null;
	/* Column Info */
	private String simDt = null;
	/* Column Info */
	private String sectNo = null;
	/* Column Info */
	private String simNo = null;
	/* Column Info */
	private String subLseCapa5 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ldfRto = null;
	/* Column Info */
	private String vslChg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String portClssCapa = null;
	/* Column Info */
	private String subChtrCapa1 = null;
	/* Column Info */
	private String vopCd = null;
	/* Column Info */
	private String vslFlg = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String vslCapa = null;
	/* Column Info */
	private String vopFlg = null;
	/* Column Info */
	private String bsaCapa = null;
	/* Column Info */
	private String flag = null;
	/* Column Info */
	private String simDivCd = null;
	/* Column Info */
	private String vslOshpCd = null;
	/* Column Info */
	private String vslClssCapa = null;
	/* Column Info */
	private String fnlHjsBsaCapa = null;
	/* Column Info */
	private String userId = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSimVesselListVO() {}

	public SearchSimVesselListVO(String ibflag, String pagerows, String flag, String vslFlg, String vslChg, String vslCd, String vslClssCapa, String portClssCapa, String vslOshpCd, String vopCd, String vopFlg, String skdDirCd, String vslCapa, String bsaCapa, String fnlHjsBsaCapa, String ldfRto, String otrCrrBsaCapa1, String otrCrrBsaCapa2, String otrCrrBsaCapa3, String otrCrrBsaCapa4, String otrCrrBsaCapa5, String hjsBfrBsaCapa, String subLseCapa1, String subLseCapa2, String subLseCapa3, String subLseCapa4, String subLseCapa5, String subChtrCapa1, String subChtrCapa2, String subChtrCapa3, String subChtrCapa4, String subChtrCapa5, String simDivCd, String simDt, String simNo, String sectNo) {
		this.otrCrrBsaCapa2 = otrCrrBsaCapa2;
		this.subLseCapa3 = subLseCapa3;
		this.subLseCapa4 = subLseCapa4;
		this.vslCd = vslCd;
		this.otrCrrBsaCapa1 = otrCrrBsaCapa1;
		this.hjsBfrBsaCapa = hjsBfrBsaCapa;
		this.otrCrrBsaCapa4 = otrCrrBsaCapa4;
		this.subLseCapa1 = subLseCapa1;
		this.otrCrrBsaCapa3 = otrCrrBsaCapa3;
		this.subLseCapa2 = subLseCapa2;
		this.subChtrCapa5 = subChtrCapa5;
		this.subChtrCapa4 = subChtrCapa4;
		this.otrCrrBsaCapa5 = otrCrrBsaCapa5;
		this.subChtrCapa3 = subChtrCapa3;
		this.subChtrCapa2 = subChtrCapa2;
		this.simDt = simDt;
		this.sectNo = sectNo;
		this.simNo = simNo;
		this.subLseCapa5 = subLseCapa5;
		this.pagerows = pagerows;
		this.ldfRto = ldfRto;
		this.vslChg = vslChg;
		this.ibflag = ibflag;
		this.portClssCapa = portClssCapa;
		this.subChtrCapa1 = subChtrCapa1;
		this.vopCd = vopCd;
		this.vslFlg = vslFlg;
		this.skdDirCd = skdDirCd;
		this.vslCapa = vslCapa;
		this.vopFlg = vopFlg;
		this.bsaCapa = bsaCapa;
		this.flag = flag;
		this.simDivCd = simDivCd;
		this.vslOshpCd = vslOshpCd;
		this.vslClssCapa = vslClssCapa;
		this.fnlHjsBsaCapa = fnlHjsBsaCapa;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("otr_crr_bsa_capa2", getOtrCrrBsaCapa2());
		this.hashColumns.put("sub_lse_capa3", getSubLseCapa3());
		this.hashColumns.put("sub_lse_capa4", getSubLseCapa4());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("otr_crr_bsa_capa1", getOtrCrrBsaCapa1());
		this.hashColumns.put("hjs_bfr_bsa_capa", getHjsBfrBsaCapa());
		this.hashColumns.put("otr_crr_bsa_capa4", getOtrCrrBsaCapa4());
		this.hashColumns.put("sub_lse_capa1", getSubLseCapa1());
		this.hashColumns.put("otr_crr_bsa_capa3", getOtrCrrBsaCapa3());
		this.hashColumns.put("sub_lse_capa2", getSubLseCapa2());
		this.hashColumns.put("sub_chtr_capa5", getSubChtrCapa5());
		this.hashColumns.put("sub_chtr_capa4", getSubChtrCapa4());
		this.hashColumns.put("otr_crr_bsa_capa5", getOtrCrrBsaCapa5());
		this.hashColumns.put("sub_chtr_capa3", getSubChtrCapa3());
		this.hashColumns.put("sub_chtr_capa2", getSubChtrCapa2());
		this.hashColumns.put("sim_dt", getSimDt());
		this.hashColumns.put("sect_no", getSectNo());
		this.hashColumns.put("sim_no", getSimNo());
		this.hashColumns.put("sub_lse_capa5", getSubLseCapa5());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ldf_rto", getLdfRto());
		this.hashColumns.put("vsl_chg", getVslChg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("port_clss_capa", getPortClssCapa());
		this.hashColumns.put("sub_chtr_capa1", getSubChtrCapa1());
		this.hashColumns.put("vop_cd", getVopCd());
		this.hashColumns.put("vsl_flg", getVslFlg());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("vsl_capa", getVslCapa());
		this.hashColumns.put("vop_flg", getVopFlg());
		this.hashColumns.put("bsa_capa", getBsaCapa());
		this.hashColumns.put("flag", getFlag());
		this.hashColumns.put("sim_div_cd", getSimDivCd());
		this.hashColumns.put("vsl_oshp_cd", getVslOshpCd());
		this.hashColumns.put("vsl_clss_capa", getVslClssCapa());
		this.hashColumns.put("fnl_hjs_bsa_capa", getFnlHjsBsaCapa());
		this.hashColumns.put("user_id",getUserId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("otr_crr_bsa_capa2", "otrCrrBsaCapa2");
		this.hashFields.put("sub_lse_capa3", "subLseCapa3");
		this.hashFields.put("sub_lse_capa4", "subLseCapa4");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("otr_crr_bsa_capa1", "otrCrrBsaCapa1");
		this.hashFields.put("hjs_bfr_bsa_capa", "hjsBfrBsaCapa");
		this.hashFields.put("otr_crr_bsa_capa4", "otrCrrBsaCapa4");
		this.hashFields.put("sub_lse_capa1", "subLseCapa1");
		this.hashFields.put("otr_crr_bsa_capa3", "otrCrrBsaCapa3");
		this.hashFields.put("sub_lse_capa2", "subLseCapa2");
		this.hashFields.put("sub_chtr_capa5", "subChtrCapa5");
		this.hashFields.put("sub_chtr_capa4", "subChtrCapa4");
		this.hashFields.put("otr_crr_bsa_capa5", "otrCrrBsaCapa5");
		this.hashFields.put("sub_chtr_capa3", "subChtrCapa3");
		this.hashFields.put("sub_chtr_capa2", "subChtrCapa2");
		this.hashFields.put("sim_dt", "simDt");
		this.hashFields.put("sect_no", "sectNo");
		this.hashFields.put("sim_no", "simNo");
		this.hashFields.put("sub_lse_capa5", "subLseCapa5");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ldf_rto", "ldfRto");
		this.hashFields.put("vsl_chg", "vslChg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("port_clss_capa", "portClssCapa");
		this.hashFields.put("sub_chtr_capa1", "subChtrCapa1");
		this.hashFields.put("vop_cd", "vopCd");
		this.hashFields.put("vsl_flg", "vslFlg");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("vsl_capa", "vslCapa");
		this.hashFields.put("vop_flg", "vopFlg");
		this.hashFields.put("bsa_capa", "bsaCapa");
		this.hashFields.put("flag", "flag");
		this.hashFields.put("sim_div_cd", "simDivCd");
		this.hashFields.put("vsl_oshp_cd", "vslOshpCd");
		this.hashFields.put("vsl_clss_capa", "vslClssCapa");
		this.hashFields.put("fnl_hjs_bsa_capa", "fnlHjsBsaCapa");
		this.hashFields.put("user_id", "userId");		
		return this.hashFields;
	}
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return otrCrrBsaCapa2
	 */
	public String getOtrCrrBsaCapa2() {
		return this.otrCrrBsaCapa2;
	}
	
	/**
	 * Column Info
	 * @return subLseCapa3
	 */
	public String getSubLseCapa3() {
		return this.subLseCapa3;
	}
	
	/**
	 * Column Info
	 * @return subLseCapa4
	 */
	public String getSubLseCapa4() {
		return this.subLseCapa4;
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
	 * @return otrCrrBsaCapa1
	 */
	public String getOtrCrrBsaCapa1() {
		return this.otrCrrBsaCapa1;
	}
	
	/**
	 * Column Info
	 * @return hjsBfrBsaCapa
	 */
	public String getHjsBfrBsaCapa() {
		return this.hjsBfrBsaCapa;
	}
	
	/**
	 * Column Info
	 * @return otrCrrBsaCapa4
	 */
	public String getOtrCrrBsaCapa4() {
		return this.otrCrrBsaCapa4;
	}
	
	/**
	 * Column Info
	 * @return subLseCapa1
	 */
	public String getSubLseCapa1() {
		return this.subLseCapa1;
	}
	
	/**
	 * Column Info
	 * @return otrCrrBsaCapa3
	 */
	public String getOtrCrrBsaCapa3() {
		return this.otrCrrBsaCapa3;
	}
	
	/**
	 * Column Info
	 * @return subLseCapa2
	 */
	public String getSubLseCapa2() {
		return this.subLseCapa2;
	}
	
	/**
	 * Column Info
	 * @return subChtrCapa5
	 */
	public String getSubChtrCapa5() {
		return this.subChtrCapa5;
	}
	
	/**
	 * Column Info
	 * @return subChtrCapa4
	 */
	public String getSubChtrCapa4() {
		return this.subChtrCapa4;
	}
	
	/**
	 * Column Info
	 * @return otrCrrBsaCapa5
	 */
	public String getOtrCrrBsaCapa5() {
		return this.otrCrrBsaCapa5;
	}
	
	/**
	 * Column Info
	 * @return subChtrCapa3
	 */
	public String getSubChtrCapa3() {
		return this.subChtrCapa3;
	}
	
	/**
	 * Column Info
	 * @return subChtrCapa2
	 */
	public String getSubChtrCapa2() {
		return this.subChtrCapa2;
	}
	
	/**
	 * Column Info
	 * @return simDt
	 */
	public String getSimDt() {
		return this.simDt;
	}
	
	/**
	 * Column Info
	 * @return sectNo
	 */
	public String getSectNo() {
		return this.sectNo;
	}
	
	/**
	 * Column Info
	 * @return simNo
	 */
	public String getSimNo() {
		return this.simNo;
	}
	
	/**
	 * Column Info
	 * @return subLseCapa5
	 */
	public String getSubLseCapa5() {
		return this.subLseCapa5;
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
	 * @return ldfRto
	 */
	public String getLdfRto() {
		return this.ldfRto;
	}
	
	/**
	 * Column Info
	 * @return vslChg
	 */
	public String getVslChg() {
		return this.vslChg;
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
	 * @return portClssCapa
	 */
	public String getPortClssCapa() {
		return this.portClssCapa;
	}
	
	/**
	 * Column Info
	 * @return subChtrCapa1
	 */
	public String getSubChtrCapa1() {
		return this.subChtrCapa1;
	}
	
	/**
	 * Column Info
	 * @return vopCd
	 */
	public String getVopCd() {
		return this.vopCd;
	}
	
	/**
	 * Column Info
	 * @return vslFlg
	 */
	public String getVslFlg() {
		return this.vslFlg;
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
	 * @return vslCapa
	 */
	public String getVslCapa() {
		return this.vslCapa;
	}
	
	/**
	 * Column Info
	 * @return vopFlg
	 */
	public String getVopFlg() {
		return this.vopFlg;
	}
	
	/**
	 * Column Info
	 * @return bsaCapa
	 */
	public String getBsaCapa() {
		return this.bsaCapa;
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
	 * @return simDivCd
	 */
	public String getSimDivCd() {
		return this.simDivCd;
	}
	
	/**
	 * Column Info
	 * @return vslOshpCd
	 */
	public String getVslOshpCd() {
		return this.vslOshpCd;
	}
	
	/**
	 * Column Info
	 * @return vslClssCapa
	 */
	public String getVslClssCapa() {
		return this.vslClssCapa;
	}
	
	/**
	 * Column Info
	 * @return fnlHjsBsaCapa
	 */
	public String getFnlHjsBsaCapa() {
		return this.fnlHjsBsaCapa;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param otrCrrBsaCapa2
	 */
	public void setOtrCrrBsaCapa2(String otrCrrBsaCapa2) {
		this.otrCrrBsaCapa2 = otrCrrBsaCapa2;
	}
	
	/**
	 * Column Info
	 * @param subLseCapa3
	 */
	public void setSubLseCapa3(String subLseCapa3) {
		this.subLseCapa3 = subLseCapa3;
	}
	
	/**
	 * Column Info
	 * @param subLseCapa4
	 */
	public void setSubLseCapa4(String subLseCapa4) {
		this.subLseCapa4 = subLseCapa4;
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
	 * @param otrCrrBsaCapa1
	 */
	public void setOtrCrrBsaCapa1(String otrCrrBsaCapa1) {
		this.otrCrrBsaCapa1 = otrCrrBsaCapa1;
	}
	
	/**
	 * Column Info
	 * @param hjsBfrBsaCapa
	 */
	public void setHjsBfrBsaCapa(String hjsBfrBsaCapa) {
		this.hjsBfrBsaCapa = hjsBfrBsaCapa;
	}
	
	/**
	 * Column Info
	 * @param otrCrrBsaCapa4
	 */
	public void setOtrCrrBsaCapa4(String otrCrrBsaCapa4) {
		this.otrCrrBsaCapa4 = otrCrrBsaCapa4;
	}
	
	/**
	 * Column Info
	 * @param subLseCapa1
	 */
	public void setSubLseCapa1(String subLseCapa1) {
		this.subLseCapa1 = subLseCapa1;
	}
	
	/**
	 * Column Info
	 * @param otrCrrBsaCapa3
	 */
	public void setOtrCrrBsaCapa3(String otrCrrBsaCapa3) {
		this.otrCrrBsaCapa3 = otrCrrBsaCapa3;
	}
	
	/**
	 * Column Info
	 * @param subLseCapa2
	 */
	public void setSubLseCapa2(String subLseCapa2) {
		this.subLseCapa2 = subLseCapa2;
	}
	
	/**
	 * Column Info
	 * @param subChtrCapa5
	 */
	public void setSubChtrCapa5(String subChtrCapa5) {
		this.subChtrCapa5 = subChtrCapa5;
	}
	
	/**
	 * Column Info
	 * @param subChtrCapa4
	 */
	public void setSubChtrCapa4(String subChtrCapa4) {
		this.subChtrCapa4 = subChtrCapa4;
	}
	
	/**
	 * Column Info
	 * @param otrCrrBsaCapa5
	 */
	public void setOtrCrrBsaCapa5(String otrCrrBsaCapa5) {
		this.otrCrrBsaCapa5 = otrCrrBsaCapa5;
	}
	
	/**
	 * Column Info
	 * @param subChtrCapa3
	 */
	public void setSubChtrCapa3(String subChtrCapa3) {
		this.subChtrCapa3 = subChtrCapa3;
	}
	
	/**
	 * Column Info
	 * @param subChtrCapa2
	 */
	public void setSubChtrCapa2(String subChtrCapa2) {
		this.subChtrCapa2 = subChtrCapa2;
	}
	
	/**
	 * Column Info
	 * @param simDt
	 */
	public void setSimDt(String simDt) {
		this.simDt = simDt;
	}
	
	/**
	 * Column Info
	 * @param sectNo
	 */
	public void setSectNo(String sectNo) {
		this.sectNo = sectNo;
	}
	
	/**
	 * Column Info
	 * @param simNo
	 */
	public void setSimNo(String simNo) {
		this.simNo = simNo;
	}
	
	/**
	 * Column Info
	 * @param subLseCapa5
	 */
	public void setSubLseCapa5(String subLseCapa5) {
		this.subLseCapa5 = subLseCapa5;
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
	 * @param ldfRto
	 */
	public void setLdfRto(String ldfRto) {
		this.ldfRto = ldfRto;
	}
	
	/**
	 * Column Info
	 * @param vslChg
	 */
	public void setVslChg(String vslChg) {
		this.vslChg = vslChg;
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
	 * @param portClssCapa
	 */
	public void setPortClssCapa(String portClssCapa) {
		this.portClssCapa = portClssCapa;
	}
	
	/**
	 * Column Info
	 * @param subChtrCapa1
	 */
	public void setSubChtrCapa1(String subChtrCapa1) {
		this.subChtrCapa1 = subChtrCapa1;
	}
	
	/**
	 * Column Info
	 * @param vopCd
	 */
	public void setVopCd(String vopCd) {
		this.vopCd = vopCd;
	}
	
	/**
	 * Column Info
	 * @param vslFlg
	 */
	public void setVslFlg(String vslFlg) {
		this.vslFlg = vslFlg;
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
	 * @param vslCapa
	 */
	public void setVslCapa(String vslCapa) {
		this.vslCapa = vslCapa;
	}
	
	/**
	 * Column Info
	 * @param vopFlg
	 */
	public void setVopFlg(String vopFlg) {
		this.vopFlg = vopFlg;
	}
	
	/**
	 * Column Info
	 * @param bsaCapa
	 */
	public void setBsaCapa(String bsaCapa) {
		this.bsaCapa = bsaCapa;
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
	 * @param simDivCd
	 */
	public void setSimDivCd(String simDivCd) {
		this.simDivCd = simDivCd;
	}
	
	/**
	 * Column Info
	 * @param vslOshpCd
	 */
	public void setVslOshpCd(String vslOshpCd) {
		this.vslOshpCd = vslOshpCd;
	}
	
	/**
	 * Column Info
	 * @param vslClssCapa
	 */
	public void setVslClssCapa(String vslClssCapa) {
		this.vslClssCapa = vslClssCapa;
	}
	
	/**
	 * Column Info
	 * @param fnlHjsBsaCapa
	 */
	public void setFnlHjsBsaCapa(String fnlHjsBsaCapa) {
		this.fnlHjsBsaCapa = fnlHjsBsaCapa;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setOtrCrrBsaCapa2(JSPUtil.getParameter(request, "otr_crr_bsa_capa2", ""));
		setSubLseCapa3(JSPUtil.getParameter(request, "sub_lse_capa3", ""));
		setSubLseCapa4(JSPUtil.getParameter(request, "sub_lse_capa4", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setOtrCrrBsaCapa1(JSPUtil.getParameter(request, "otr_crr_bsa_capa1", ""));
		setHjsBfrBsaCapa(JSPUtil.getParameter(request, "hjs_bfr_bsa_capa", ""));
		setOtrCrrBsaCapa4(JSPUtil.getParameter(request, "otr_crr_bsa_capa4", ""));
		setSubLseCapa1(JSPUtil.getParameter(request, "sub_lse_capa1", ""));
		setOtrCrrBsaCapa3(JSPUtil.getParameter(request, "otr_crr_bsa_capa3", ""));
		setSubLseCapa2(JSPUtil.getParameter(request, "sub_lse_capa2", ""));
		setSubChtrCapa5(JSPUtil.getParameter(request, "sub_chtr_capa5", ""));
		setSubChtrCapa4(JSPUtil.getParameter(request, "sub_chtr_capa4", ""));
		setOtrCrrBsaCapa5(JSPUtil.getParameter(request, "otr_crr_bsa_capa5", ""));
		setSubChtrCapa3(JSPUtil.getParameter(request, "sub_chtr_capa3", ""));
		setSubChtrCapa2(JSPUtil.getParameter(request, "sub_chtr_capa2", ""));
		setSimDt(JSPUtil.getParameter(request, "sim_dt", ""));
		setSectNo(JSPUtil.getParameter(request, "sect_no", ""));
		setSimNo(JSPUtil.getParameter(request, "sim_no", ""));
		setSubLseCapa5(JSPUtil.getParameter(request, "sub_lse_capa5", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setLdfRto(JSPUtil.getParameter(request, "ldf_rto", ""));
		setVslChg(JSPUtil.getParameter(request, "vsl_chg", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPortClssCapa(JSPUtil.getParameter(request, "port_clss_capa", ""));
		setSubChtrCapa1(JSPUtil.getParameter(request, "sub_chtr_capa1", ""));
		setVopCd(JSPUtil.getParameter(request, "vop_cd", ""));
		setVslFlg(JSPUtil.getParameter(request, "vsl_flg", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setVslCapa(JSPUtil.getParameter(request, "vsl_capa", ""));
		setVopFlg(JSPUtil.getParameter(request, "vop_flg", ""));
		setBsaCapa(JSPUtil.getParameter(request, "bsa_capa", ""));
		setFlag(JSPUtil.getParameter(request, "flag", ""));
		setSimDivCd(JSPUtil.getParameter(request, "sim_div_cd", ""));
		setVslOshpCd(JSPUtil.getParameter(request, "vsl_oshp_cd", ""));
		setVslClssCapa(JSPUtil.getParameter(request, "vsl_clss_capa", ""));
		setFnlHjsBsaCapa(JSPUtil.getParameter(request, "fnl_hjs_bsa_capa", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return searchSimVesselListVO[]
	 */
	public SearchSimVesselListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return searchSimVesselListVO[]
	 */
	public SearchSimVesselListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSimVesselListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] otrCrrBsaCapa2 = (JSPUtil.getParameter(request, prefix	+ "otr_crr_bsa_capa2", length));
			String[] subLseCapa3 = (JSPUtil.getParameter(request, prefix	+ "sub_lse_capa3", length));
			String[] subLseCapa4 = (JSPUtil.getParameter(request, prefix	+ "sub_lse_capa4", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] otrCrrBsaCapa1 = (JSPUtil.getParameter(request, prefix	+ "otr_crr_bsa_capa1", length));
			String[] hjsBfrBsaCapa = (JSPUtil.getParameter(request, prefix	+ "hjs_bfr_bsa_capa", length));
			String[] otrCrrBsaCapa4 = (JSPUtil.getParameter(request, prefix	+ "otr_crr_bsa_capa4", length));
			String[] subLseCapa1 = (JSPUtil.getParameter(request, prefix	+ "sub_lse_capa1", length));
			String[] otrCrrBsaCapa3 = (JSPUtil.getParameter(request, prefix	+ "otr_crr_bsa_capa3", length));
			String[] subLseCapa2 = (JSPUtil.getParameter(request, prefix	+ "sub_lse_capa2", length));
			String[] subChtrCapa5 = (JSPUtil.getParameter(request, prefix	+ "sub_chtr_capa5", length));
			String[] subChtrCapa4 = (JSPUtil.getParameter(request, prefix	+ "sub_chtr_capa4", length));
			String[] otrCrrBsaCapa5 = (JSPUtil.getParameter(request, prefix	+ "otr_crr_bsa_capa5", length));
			String[] subChtrCapa3 = (JSPUtil.getParameter(request, prefix	+ "sub_chtr_capa3", length));
			String[] subChtrCapa2 = (JSPUtil.getParameter(request, prefix	+ "sub_chtr_capa2", length));
			String[] simDt = (JSPUtil.getParameter(request, prefix	+ "sim_dt", length));
			String[] sectNo = (JSPUtil.getParameter(request, prefix	+ "sect_no", length));
			String[] simNo = (JSPUtil.getParameter(request, prefix	+ "sim_no", length));
			String[] subLseCapa5 = (JSPUtil.getParameter(request, prefix	+ "sub_lse_capa5", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ldfRto = (JSPUtil.getParameter(request, prefix	+ "ldf_rto", length));
			String[] vslChg = (JSPUtil.getParameter(request, prefix	+ "vsl_chg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] portClssCapa = (JSPUtil.getParameter(request, prefix	+ "port_clss_capa", length));
			String[] subChtrCapa1 = (JSPUtil.getParameter(request, prefix	+ "sub_chtr_capa1", length));
			String[] vopCd = (JSPUtil.getParameter(request, prefix	+ "vop_cd", length));
			String[] vslFlg = (JSPUtil.getParameter(request, prefix	+ "vsl_flg", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] vslCapa = (JSPUtil.getParameter(request, prefix	+ "vsl_capa", length));
			String[] vopFlg = (JSPUtil.getParameter(request, prefix	+ "vop_flg", length));
			String[] bsaCapa = (JSPUtil.getParameter(request, prefix	+ "bsa_capa", length));
			String[] flag = (JSPUtil.getParameter(request, prefix	+ "flag", length));
			String[] simDivCd = (JSPUtil.getParameter(request, prefix	+ "sim_div_cd", length));
			String[] vslOshpCd = (JSPUtil.getParameter(request, prefix	+ "vsl_oshp_cd", length));
			String[] vslClssCapa = (JSPUtil.getParameter(request, prefix	+ "vsl_clss_capa", length));
			String[] fnlHjsBsaCapa = (JSPUtil.getParameter(request, prefix	+ "fnl_hjs_bsa_capa", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSimVesselListVO();
				if (otrCrrBsaCapa2[i] != null)
					model.setOtrCrrBsaCapa2(otrCrrBsaCapa2[i]);
				if (subLseCapa3[i] != null)
					model.setSubLseCapa3(subLseCapa3[i]);
				if (subLseCapa4[i] != null)
					model.setSubLseCapa4(subLseCapa4[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (otrCrrBsaCapa1[i] != null)
					model.setOtrCrrBsaCapa1(otrCrrBsaCapa1[i]);
				if (hjsBfrBsaCapa[i] != null)
					model.setHjsBfrBsaCapa(hjsBfrBsaCapa[i]);
				if (otrCrrBsaCapa4[i] != null)
					model.setOtrCrrBsaCapa4(otrCrrBsaCapa4[i]);
				if (subLseCapa1[i] != null)
					model.setSubLseCapa1(subLseCapa1[i]);
				if (otrCrrBsaCapa3[i] != null)
					model.setOtrCrrBsaCapa3(otrCrrBsaCapa3[i]);
				if (subLseCapa2[i] != null)
					model.setSubLseCapa2(subLseCapa2[i]);
				if (subChtrCapa5[i] != null)
					model.setSubChtrCapa5(subChtrCapa5[i]);
				if (subChtrCapa4[i] != null)
					model.setSubChtrCapa4(subChtrCapa4[i]);
				if (otrCrrBsaCapa5[i] != null)
					model.setOtrCrrBsaCapa5(otrCrrBsaCapa5[i]);
				if (subChtrCapa3[i] != null)
					model.setSubChtrCapa3(subChtrCapa3[i]);
				if (subChtrCapa2[i] != null)
					model.setSubChtrCapa2(subChtrCapa2[i]);
				if (simDt[i] != null)
					model.setSimDt(simDt[i]);
				if (sectNo[i] != null)
					model.setSectNo(sectNo[i]);
				if (simNo[i] != null)
					model.setSimNo(simNo[i]);
				if (subLseCapa5[i] != null)
					model.setSubLseCapa5(subLseCapa5[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ldfRto[i] != null)
					model.setLdfRto(ldfRto[i]);
				if (vslChg[i] != null)
					model.setVslChg(vslChg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (portClssCapa[i] != null)
					model.setPortClssCapa(portClssCapa[i]);
				if (subChtrCapa1[i] != null)
					model.setSubChtrCapa1(subChtrCapa1[i]);
				if (vopCd[i] != null)
					model.setVopCd(vopCd[i]);
				if (vslFlg[i] != null)
					model.setVslFlg(vslFlg[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (vslCapa[i] != null)
					model.setVslCapa(vslCapa[i]);
				if (vopFlg[i] != null)
					model.setVopFlg(vopFlg[i]);
				if (bsaCapa[i] != null)
					model.setBsaCapa(bsaCapa[i]);
				if (flag[i] != null)
					model.setFlag(flag[i]);
				if (simDivCd[i] != null)
					model.setSimDivCd(simDivCd[i]);
				if (vslOshpCd[i] != null)
					model.setVslOshpCd(vslOshpCd[i]);
				if (vslClssCapa[i] != null)
					model.setVslClssCapa(vslClssCapa[i]);
				if (fnlHjsBsaCapa[i] != null)
					model.setFnlHjsBsaCapa(fnlHjsBsaCapa[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);

				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getsearchSimVesselListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return searchSimVesselListVO[]
	 */
	public SearchSimVesselListVO[] getsearchSimVesselListVOs(){
		SearchSimVesselListVO[] vos = (SearchSimVesselListVO[])models.toArray(new SearchSimVesselListVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.otrCrrBsaCapa2 = this.otrCrrBsaCapa2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subLseCapa3 = this.subLseCapa3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subLseCapa4 = this.subLseCapa4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otrCrrBsaCapa1 = this.otrCrrBsaCapa1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjsBfrBsaCapa = this.hjsBfrBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otrCrrBsaCapa4 = this.otrCrrBsaCapa4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subLseCapa1 = this.subLseCapa1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otrCrrBsaCapa3 = this.otrCrrBsaCapa3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subLseCapa2 = this.subLseCapa2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subChtrCapa5 = this.subChtrCapa5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subChtrCapa4 = this.subChtrCapa4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otrCrrBsaCapa5 = this.otrCrrBsaCapa5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subChtrCapa3 = this.subChtrCapa3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subChtrCapa2 = this.subChtrCapa2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simDt = this.simDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sectNo = this.sectNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simNo = this.simNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subLseCapa5 = this.subLseCapa5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ldfRto = this.ldfRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslChg = this.vslChg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portClssCapa = this.portClssCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subChtrCapa1 = this.subChtrCapa1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vopCd = this.vopCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslFlg = this.vslFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCapa = this.vslCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vopFlg = this.vopFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaCapa = this.bsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flag = this.flag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simDivCd = this.simDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslOshpCd = this.vslOshpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslClssCapa = this.vslClssCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlHjsBsaCapa = this.fnlHjsBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
