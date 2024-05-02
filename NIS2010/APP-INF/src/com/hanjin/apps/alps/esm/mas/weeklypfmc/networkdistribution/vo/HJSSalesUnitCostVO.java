/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : HJSSalesUnitCostVO.java
*@FileTitle : HJSSalesUnitCostVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.04
*@LastModifier : 유제량
*@LastVersion : 1.0
* 2015.06.04 유제량 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.vo;

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
 * @author 유제량
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class HJSSalesUnitCostVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<HJSSalesUnitCostVO> models = new ArrayList<HJSSalesUnitCostVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String bsaOpNm = null;
	/* Column Info */
	private String amt208 = null;
	/* Column Info */
	private String amt209 = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String amt206 = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String amt207 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String amt113 = null;
	/* Column Info */
	private String amt201 = null;
	/* Column Info */
	private String amt112 = null;
	/* Column Info */
	private String amt111 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String amt110 = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String amt205 = null;
	/* Column Info */
	private String amt204 = null;
	/* Column Info */
	private String amt203 = null;
	/* Column Info */
	private String amt114 = null;
	/* Column Info */
	private String amt202 = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String hulBndCd = null;
	/* Column Info */
	private String vopCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String amt213 = null;
	/* Column Info */
	private String amt214 = null;
	/* Column Info */
	private String amt211 = null;
	/* Column Info */
	private String amt107 = null;
	/* Column Info */
	private String amt212 = null;
	/* Column Info */
	private String amt108 = null;
	/* Column Info */
	private String amt109 = null;
	/* Column Info */
	private String amt210 = null;
	/* Column Info */
	private String vslCapa = null;
	/* Column Info */
	private String bsaCapa = null;
	/* Column Info */
	private String amt104 = null;
	/* Column Info */
	private String amt103 = null;
	/* Column Info */
	private String amt106 = null;
	/* Column Info */
	private String amt105 = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String hjsSlsUcQty = null;
	/* Column Info */
	private String amt102 = null;
	/* Column Info */
	private String amt101 = null;
	/* Column Info */
	private String bsaOpCd = null;
	/* Column Info */
	private String vslOshpCd = null;
	/* Column Info */
	private String hjsSlsAmt = null;
	/* Column Info */
	private String fnlHjsBsaCapa = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public HJSSalesUnitCostVO() {}

	public HJSSalesUnitCostVO(String ibflag, String pagerows, String costYrmon, String costWk, String trdCd, String rlaneCd, String vslCd, String skdVoyNo, String dirCd, String hulBndCd, String vopCd, String vslOshpCd, String vslCapa, String bsaCapa, String bsaOpNm, String hjsSlsUcQty, String fnlHjsBsaCapa, String hjsSlsAmt, String amt101, String amt201, String amt102, String amt202, String amt103, String amt203, String amt104, String amt204, String amt105, String amt205, String amt106, String amt206, String amt107, String amt207, String amt108, String amt208, String amt109, String amt209, String amt110, String amt210, String amt111, String amt211, String amt112, String amt212, String amt113, String amt213, String amt114, String amt214, String bsaOpCd) {
		this.vslCd = vslCd;
		this.bsaOpNm = bsaOpNm;
		this.amt208 = amt208;
		this.amt209 = amt209;
		this.trdCd = trdCd;
		this.amt206 = amt206;
		this.rlaneCd = rlaneCd;
		this.amt207 = amt207;
		this.pagerows = pagerows;
		this.amt113 = amt113;
		this.amt201 = amt201;
		this.amt112 = amt112;
		this.amt111 = amt111;
		this.ibflag = ibflag;
		this.amt110 = amt110;
		this.costYrmon = costYrmon;
		this.amt205 = amt205;
		this.amt204 = amt204;
		this.amt203 = amt203;
		this.amt114 = amt114;
		this.amt202 = amt202;
		this.dirCd = dirCd;
		this.hulBndCd = hulBndCd;
		this.vopCd = vopCd;
		this.skdVoyNo = skdVoyNo;
		this.amt213 = amt213;
		this.amt214 = amt214;
		this.amt211 = amt211;
		this.amt107 = amt107;
		this.amt212 = amt212;
		this.amt108 = amt108;
		this.amt109 = amt109;
		this.amt210 = amt210;
		this.vslCapa = vslCapa;
		this.bsaCapa = bsaCapa;
		this.amt104 = amt104;
		this.amt103 = amt103;
		this.amt106 = amt106;
		this.amt105 = amt105;
		this.costWk = costWk;
		this.hjsSlsUcQty = hjsSlsUcQty;
		this.amt102 = amt102;
		this.amt101 = amt101;
		this.bsaOpCd = bsaOpCd;
		this.vslOshpCd = vslOshpCd;
		this.hjsSlsAmt = hjsSlsAmt;
		this.fnlHjsBsaCapa = fnlHjsBsaCapa;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("bsa_op_nm", getBsaOpNm());
		this.hashColumns.put("amt_2_08", getAmt208());
		this.hashColumns.put("amt_2_09", getAmt209());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("amt_2_06", getAmt206());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("amt_2_07", getAmt207());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("amt_1_13", getAmt113());
		this.hashColumns.put("amt_2_01", getAmt201());
		this.hashColumns.put("amt_1_12", getAmt112());
		this.hashColumns.put("amt_1_11", getAmt111());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("amt_1_10", getAmt110());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("amt_2_05", getAmt205());
		this.hashColumns.put("amt_2_04", getAmt204());
		this.hashColumns.put("amt_2_03", getAmt203());
		this.hashColumns.put("amt_1_14", getAmt114());
		this.hashColumns.put("amt_2_02", getAmt202());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("hul_bnd_cd", getHulBndCd());
		this.hashColumns.put("vop_cd", getVopCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("amt_2_13", getAmt213());
		this.hashColumns.put("amt_2_14", getAmt214());
		this.hashColumns.put("amt_2_11", getAmt211());
		this.hashColumns.put("amt_1_07", getAmt107());
		this.hashColumns.put("amt_2_12", getAmt212());
		this.hashColumns.put("amt_1_08", getAmt108());
		this.hashColumns.put("amt_1_09", getAmt109());
		this.hashColumns.put("amt_2_10", getAmt210());
		this.hashColumns.put("vsl_capa", getVslCapa());
		this.hashColumns.put("bsa_capa", getBsaCapa());
		this.hashColumns.put("amt_1_04", getAmt104());
		this.hashColumns.put("amt_1_03", getAmt103());
		this.hashColumns.put("amt_1_06", getAmt106());
		this.hashColumns.put("amt_1_05", getAmt105());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("hjs_sls_uc_qty", getHjsSlsUcQty());
		this.hashColumns.put("amt_1_02", getAmt102());
		this.hashColumns.put("amt_1_01", getAmt101());
		this.hashColumns.put("bsa_op_cd", getBsaOpCd());
		this.hashColumns.put("vsl_oshp_cd", getVslOshpCd());
		this.hashColumns.put("hjs_sls_amt", getHjsSlsAmt());
		this.hashColumns.put("fnl_hjs_bsa_capa", getFnlHjsBsaCapa());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("bsa_op_nm", "bsaOpNm");
		this.hashFields.put("amt_2_08", "amt208");
		this.hashFields.put("amt_2_09", "amt209");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("amt_2_06", "amt206");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("amt_2_07", "amt207");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("amt_1_13", "amt113");
		this.hashFields.put("amt_2_01", "amt201");
		this.hashFields.put("amt_1_12", "amt112");
		this.hashFields.put("amt_1_11", "amt111");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("amt_1_10", "amt110");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("amt_2_05", "amt205");
		this.hashFields.put("amt_2_04", "amt204");
		this.hashFields.put("amt_2_03", "amt203");
		this.hashFields.put("amt_1_14", "amt114");
		this.hashFields.put("amt_2_02", "amt202");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("hul_bnd_cd", "hulBndCd");
		this.hashFields.put("vop_cd", "vopCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("amt_2_13", "amt213");
		this.hashFields.put("amt_2_14", "amt214");
		this.hashFields.put("amt_2_11", "amt211");
		this.hashFields.put("amt_1_07", "amt107");
		this.hashFields.put("amt_2_12", "amt212");
		this.hashFields.put("amt_1_08", "amt108");
		this.hashFields.put("amt_1_09", "amt109");
		this.hashFields.put("amt_2_10", "amt210");
		this.hashFields.put("vsl_capa", "vslCapa");
		this.hashFields.put("bsa_capa", "bsaCapa");
		this.hashFields.put("amt_1_04", "amt104");
		this.hashFields.put("amt_1_03", "amt103");
		this.hashFields.put("amt_1_06", "amt106");
		this.hashFields.put("amt_1_05", "amt105");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("hjs_sls_uc_qty", "hjsSlsUcQty");
		this.hashFields.put("amt_1_02", "amt102");
		this.hashFields.put("amt_1_01", "amt101");
		this.hashFields.put("bsa_op_cd", "bsaOpCd");
		this.hashFields.put("vsl_oshp_cd", "vslOshpCd");
		this.hashFields.put("hjs_sls_amt", "hjsSlsAmt");
		this.hashFields.put("fnl_hjs_bsa_capa", "fnlHjsBsaCapa");
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
	 * @return bsaOpNm
	 */
	public String getBsaOpNm() {
		return this.bsaOpNm;
	}
	
	/**
	 * Column Info
	 * @return amt208
	 */
	public String getAmt208() {
		return this.amt208;
	}
	
	/**
	 * Column Info
	 * @return amt209
	 */
	public String getAmt209() {
		return this.amt209;
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
	 * @return amt206
	 */
	public String getAmt206() {
		return this.amt206;
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
	 * @return amt207
	 */
	public String getAmt207() {
		return this.amt207;
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
	 * @return amt113
	 */
	public String getAmt113() {
		return this.amt113;
	}
	
	/**
	 * Column Info
	 * @return amt201
	 */
	public String getAmt201() {
		return this.amt201;
	}
	
	/**
	 * Column Info
	 * @return amt112
	 */
	public String getAmt112() {
		return this.amt112;
	}
	
	/**
	 * Column Info
	 * @return amt111
	 */
	public String getAmt111() {
		return this.amt111;
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
	 * @return amt110
	 */
	public String getAmt110() {
		return this.amt110;
	}
	
	/**
	 * Column Info
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
	}
	
	/**
	 * Column Info
	 * @return amt205
	 */
	public String getAmt205() {
		return this.amt205;
	}
	
	/**
	 * Column Info
	 * @return amt204
	 */
	public String getAmt204() {
		return this.amt204;
	}
	
	/**
	 * Column Info
	 * @return amt203
	 */
	public String getAmt203() {
		return this.amt203;
	}
	
	/**
	 * Column Info
	 * @return amt114
	 */
	public String getAmt114() {
		return this.amt114;
	}
	
	/**
	 * Column Info
	 * @return amt202
	 */
	public String getAmt202() {
		return this.amt202;
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
	 * @return hulBndCd
	 */
	public String getHulBndCd() {
		return this.hulBndCd;
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return amt213
	 */
	public String getAmt213() {
		return this.amt213;
	}
	
	/**
	 * Column Info
	 * @return amt214
	 */
	public String getAmt214() {
		return this.amt214;
	}
	
	/**
	 * Column Info
	 * @return amt211
	 */
	public String getAmt211() {
		return this.amt211;
	}
	
	/**
	 * Column Info
	 * @return amt107
	 */
	public String getAmt107() {
		return this.amt107;
	}
	
	/**
	 * Column Info
	 * @return amt212
	 */
	public String getAmt212() {
		return this.amt212;
	}
	
	/**
	 * Column Info
	 * @return amt108
	 */
	public String getAmt108() {
		return this.amt108;
	}
	
	/**
	 * Column Info
	 * @return amt109
	 */
	public String getAmt109() {
		return this.amt109;
	}
	
	/**
	 * Column Info
	 * @return amt210
	 */
	public String getAmt210() {
		return this.amt210;
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
	 * @return bsaCapa
	 */
	public String getBsaCapa() {
		return this.bsaCapa;
	}
	
	/**
	 * Column Info
	 * @return amt104
	 */
	public String getAmt104() {
		return this.amt104;
	}
	
	/**
	 * Column Info
	 * @return amt103
	 */
	public String getAmt103() {
		return this.amt103;
	}
	
	/**
	 * Column Info
	 * @return amt106
	 */
	public String getAmt106() {
		return this.amt106;
	}
	
	/**
	 * Column Info
	 * @return amt105
	 */
	public String getAmt105() {
		return this.amt105;
	}
	
	/**
	 * Column Info
	 * @return costWk
	 */
	public String getCostWk() {
		return this.costWk;
	}
	
	/**
	 * Column Info
	 * @return hjsSlsUcQty
	 */
	public String getHjsSlsUcQty() {
		return this.hjsSlsUcQty;
	}
	
	/**
	 * Column Info
	 * @return amt102
	 */
	public String getAmt102() {
		return this.amt102;
	}
	
	/**
	 * Column Info
	 * @return amt101
	 */
	public String getAmt101() {
		return this.amt101;
	}
	
	/**
	 * Column Info
	 * @return bsaOpCd
	 */
	public String getBsaOpCd() {
		return this.bsaOpCd;
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
	 * @return hjsSlsAmt
	 */
	public String getHjsSlsAmt() {
		return this.hjsSlsAmt;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param bsaOpNm
	 */
	public void setBsaOpNm(String bsaOpNm) {
		this.bsaOpNm = bsaOpNm;
	}
	
	/**
	 * Column Info
	 * @param amt208
	 */
	public void setAmt208(String amt208) {
		this.amt208 = amt208;
	}
	
	/**
	 * Column Info
	 * @param amt209
	 */
	public void setAmt209(String amt209) {
		this.amt209 = amt209;
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
	 * @param amt206
	 */
	public void setAmt206(String amt206) {
		this.amt206 = amt206;
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
	 * @param amt207
	 */
	public void setAmt207(String amt207) {
		this.amt207 = amt207;
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
	 * @param amt113
	 */
	public void setAmt113(String amt113) {
		this.amt113 = amt113;
	}
	
	/**
	 * Column Info
	 * @param amt201
	 */
	public void setAmt201(String amt201) {
		this.amt201 = amt201;
	}
	
	/**
	 * Column Info
	 * @param amt112
	 */
	public void setAmt112(String amt112) {
		this.amt112 = amt112;
	}
	
	/**
	 * Column Info
	 * @param amt111
	 */
	public void setAmt111(String amt111) {
		this.amt111 = amt111;
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
	 * @param amt110
	 */
	public void setAmt110(String amt110) {
		this.amt110 = amt110;
	}
	
	/**
	 * Column Info
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
	}
	
	/**
	 * Column Info
	 * @param amt205
	 */
	public void setAmt205(String amt205) {
		this.amt205 = amt205;
	}
	
	/**
	 * Column Info
	 * @param amt204
	 */
	public void setAmt204(String amt204) {
		this.amt204 = amt204;
	}
	
	/**
	 * Column Info
	 * @param amt203
	 */
	public void setAmt203(String amt203) {
		this.amt203 = amt203;
	}
	
	/**
	 * Column Info
	 * @param amt114
	 */
	public void setAmt114(String amt114) {
		this.amt114 = amt114;
	}
	
	/**
	 * Column Info
	 * @param amt202
	 */
	public void setAmt202(String amt202) {
		this.amt202 = amt202;
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
	 * @param hulBndCd
	 */
	public void setHulBndCd(String hulBndCd) {
		this.hulBndCd = hulBndCd;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param amt213
	 */
	public void setAmt213(String amt213) {
		this.amt213 = amt213;
	}
	
	/**
	 * Column Info
	 * @param amt214
	 */
	public void setAmt214(String amt214) {
		this.amt214 = amt214;
	}
	
	/**
	 * Column Info
	 * @param amt211
	 */
	public void setAmt211(String amt211) {
		this.amt211 = amt211;
	}
	
	/**
	 * Column Info
	 * @param amt107
	 */
	public void setAmt107(String amt107) {
		this.amt107 = amt107;
	}
	
	/**
	 * Column Info
	 * @param amt212
	 */
	public void setAmt212(String amt212) {
		this.amt212 = amt212;
	}
	
	/**
	 * Column Info
	 * @param amt108
	 */
	public void setAmt108(String amt108) {
		this.amt108 = amt108;
	}
	
	/**
	 * Column Info
	 * @param amt109
	 */
	public void setAmt109(String amt109) {
		this.amt109 = amt109;
	}
	
	/**
	 * Column Info
	 * @param amt210
	 */
	public void setAmt210(String amt210) {
		this.amt210 = amt210;
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
	 * @param bsaCapa
	 */
	public void setBsaCapa(String bsaCapa) {
		this.bsaCapa = bsaCapa;
	}
	
	/**
	 * Column Info
	 * @param amt104
	 */
	public void setAmt104(String amt104) {
		this.amt104 = amt104;
	}
	
	/**
	 * Column Info
	 * @param amt103
	 */
	public void setAmt103(String amt103) {
		this.amt103 = amt103;
	}
	
	/**
	 * Column Info
	 * @param amt106
	 */
	public void setAmt106(String amt106) {
		this.amt106 = amt106;
	}
	
	/**
	 * Column Info
	 * @param amt105
	 */
	public void setAmt105(String amt105) {
		this.amt105 = amt105;
	}
	
	/**
	 * Column Info
	 * @param costWk
	 */
	public void setCostWk(String costWk) {
		this.costWk = costWk;
	}
	
	/**
	 * Column Info
	 * @param hjsSlsUcQty
	 */
	public void setHjsSlsUcQty(String hjsSlsUcQty) {
		this.hjsSlsUcQty = hjsSlsUcQty;
	}
	
	/**
	 * Column Info
	 * @param amt102
	 */
	public void setAmt102(String amt102) {
		this.amt102 = amt102;
	}
	
	/**
	 * Column Info
	 * @param amt101
	 */
	public void setAmt101(String amt101) {
		this.amt101 = amt101;
	}
	
	/**
	 * Column Info
	 * @param bsaOpCd
	 */
	public void setBsaOpCd(String bsaOpCd) {
		this.bsaOpCd = bsaOpCd;
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
	 * @param hjsSlsAmt
	 */
	public void setHjsSlsAmt(String hjsSlsAmt) {
		this.hjsSlsAmt = hjsSlsAmt;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setBsaOpNm(JSPUtil.getParameter(request, prefix + "bsa_op_nm", ""));
		setAmt208(JSPUtil.getParameter(request, prefix + "amt_2_08", ""));
		setAmt209(JSPUtil.getParameter(request, prefix + "amt_2_09", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setAmt206(JSPUtil.getParameter(request, prefix + "amt_2_06", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setAmt207(JSPUtil.getParameter(request, prefix + "amt_2_07", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAmt113(JSPUtil.getParameter(request, prefix + "amt_1_13", ""));
		setAmt201(JSPUtil.getParameter(request, prefix + "amt_2_01", ""));
		setAmt112(JSPUtil.getParameter(request, prefix + "amt_1_12", ""));
		setAmt111(JSPUtil.getParameter(request, prefix + "amt_1_11", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAmt110(JSPUtil.getParameter(request, prefix + "amt_1_10", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setAmt205(JSPUtil.getParameter(request, prefix + "amt_2_05", ""));
		setAmt204(JSPUtil.getParameter(request, prefix + "amt_2_04", ""));
		setAmt203(JSPUtil.getParameter(request, prefix + "amt_2_03", ""));
		setAmt114(JSPUtil.getParameter(request, prefix + "amt_1_14", ""));
		setAmt202(JSPUtil.getParameter(request, prefix + "amt_2_02", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setHulBndCd(JSPUtil.getParameter(request, prefix + "hul_bnd_cd", ""));
		setVopCd(JSPUtil.getParameter(request, prefix + "vop_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setAmt213(JSPUtil.getParameter(request, prefix + "amt_2_13", ""));
		setAmt214(JSPUtil.getParameter(request, prefix + "amt_2_14", ""));
		setAmt211(JSPUtil.getParameter(request, prefix + "amt_2_11", ""));
		setAmt107(JSPUtil.getParameter(request, prefix + "amt_1_07", ""));
		setAmt212(JSPUtil.getParameter(request, prefix + "amt_2_12", ""));
		setAmt108(JSPUtil.getParameter(request, prefix + "amt_1_08", ""));
		setAmt109(JSPUtil.getParameter(request, prefix + "amt_1_09", ""));
		setAmt210(JSPUtil.getParameter(request, prefix + "amt_2_10", ""));
		setVslCapa(JSPUtil.getParameter(request, prefix + "vsl_capa", ""));
		setBsaCapa(JSPUtil.getParameter(request, prefix + "bsa_capa", ""));
		setAmt104(JSPUtil.getParameter(request, prefix + "amt_1_04", ""));
		setAmt103(JSPUtil.getParameter(request, prefix + "amt_1_03", ""));
		setAmt106(JSPUtil.getParameter(request, prefix + "amt_1_06", ""));
		setAmt105(JSPUtil.getParameter(request, prefix + "amt_1_05", ""));
		setCostWk(JSPUtil.getParameter(request, prefix + "cost_wk", ""));
		setHjsSlsUcQty(JSPUtil.getParameter(request, prefix + "hjs_sls_uc_qty", ""));
		setAmt102(JSPUtil.getParameter(request, prefix + "amt_1_02", ""));
		setAmt101(JSPUtil.getParameter(request, prefix + "amt_1_01", ""));
		setBsaOpCd(JSPUtil.getParameter(request, prefix + "bsa_op_cd", ""));
		setVslOshpCd(JSPUtil.getParameter(request, prefix + "vsl_oshp_cd", ""));
		setHjsSlsAmt(JSPUtil.getParameter(request, prefix + "hjs_sls_amt", ""));
		setFnlHjsBsaCapa(JSPUtil.getParameter(request, prefix + "fnl_hjs_bsa_capa", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return HJSSalesUnitCostVO[]
	 */
	public HJSSalesUnitCostVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return HJSSalesUnitCostVO[]
	 */
	public HJSSalesUnitCostVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		HJSSalesUnitCostVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] bsaOpNm = (JSPUtil.getParameter(request, prefix	+ "bsa_op_nm", length));
			String[] amt208 = (JSPUtil.getParameter(request, prefix	+ "amt_2_08", length));
			String[] amt209 = (JSPUtil.getParameter(request, prefix	+ "amt_2_09", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] amt206 = (JSPUtil.getParameter(request, prefix	+ "amt_2_06", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] amt207 = (JSPUtil.getParameter(request, prefix	+ "amt_2_07", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] amt113 = (JSPUtil.getParameter(request, prefix	+ "amt_1_13", length));
			String[] amt201 = (JSPUtil.getParameter(request, prefix	+ "amt_2_01", length));
			String[] amt112 = (JSPUtil.getParameter(request, prefix	+ "amt_1_12", length));
			String[] amt111 = (JSPUtil.getParameter(request, prefix	+ "amt_1_11", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] amt110 = (JSPUtil.getParameter(request, prefix	+ "amt_1_10", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] amt205 = (JSPUtil.getParameter(request, prefix	+ "amt_2_05", length));
			String[] amt204 = (JSPUtil.getParameter(request, prefix	+ "amt_2_04", length));
			String[] amt203 = (JSPUtil.getParameter(request, prefix	+ "amt_2_03", length));
			String[] amt114 = (JSPUtil.getParameter(request, prefix	+ "amt_1_14", length));
			String[] amt202 = (JSPUtil.getParameter(request, prefix	+ "amt_2_02", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] hulBndCd = (JSPUtil.getParameter(request, prefix	+ "hul_bnd_cd", length));
			String[] vopCd = (JSPUtil.getParameter(request, prefix	+ "vop_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] amt213 = (JSPUtil.getParameter(request, prefix	+ "amt_2_13", length));
			String[] amt214 = (JSPUtil.getParameter(request, prefix	+ "amt_2_14", length));
			String[] amt211 = (JSPUtil.getParameter(request, prefix	+ "amt_2_11", length));
			String[] amt107 = (JSPUtil.getParameter(request, prefix	+ "amt_1_07", length));
			String[] amt212 = (JSPUtil.getParameter(request, prefix	+ "amt_2_12", length));
			String[] amt108 = (JSPUtil.getParameter(request, prefix	+ "amt_1_08", length));
			String[] amt109 = (JSPUtil.getParameter(request, prefix	+ "amt_1_09", length));
			String[] amt210 = (JSPUtil.getParameter(request, prefix	+ "amt_2_10", length));
			String[] vslCapa = (JSPUtil.getParameter(request, prefix	+ "vsl_capa", length));
			String[] bsaCapa = (JSPUtil.getParameter(request, prefix	+ "bsa_capa", length));
			String[] amt104 = (JSPUtil.getParameter(request, prefix	+ "amt_1_04", length));
			String[] amt103 = (JSPUtil.getParameter(request, prefix	+ "amt_1_03", length));
			String[] amt106 = (JSPUtil.getParameter(request, prefix	+ "amt_1_06", length));
			String[] amt105 = (JSPUtil.getParameter(request, prefix	+ "amt_1_05", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] hjsSlsUcQty = (JSPUtil.getParameter(request, prefix	+ "hjs_sls_uc_qty", length));
			String[] amt102 = (JSPUtil.getParameter(request, prefix	+ "amt_1_02", length));
			String[] amt101 = (JSPUtil.getParameter(request, prefix	+ "amt_1_01", length));
			String[] bsaOpCd = (JSPUtil.getParameter(request, prefix	+ "bsa_op_cd", length));
			String[] vslOshpCd = (JSPUtil.getParameter(request, prefix	+ "vsl_oshp_cd", length));
			String[] hjsSlsAmt = (JSPUtil.getParameter(request, prefix	+ "hjs_sls_amt", length));
			String[] fnlHjsBsaCapa = (JSPUtil.getParameter(request, prefix	+ "fnl_hjs_bsa_capa", length));
			
			for (int i = 0; i < length; i++) {
				model = new HJSSalesUnitCostVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (bsaOpNm[i] != null)
					model.setBsaOpNm(bsaOpNm[i]);
				if (amt208[i] != null)
					model.setAmt208(amt208[i]);
				if (amt209[i] != null)
					model.setAmt209(amt209[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (amt206[i] != null)
					model.setAmt206(amt206[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (amt207[i] != null)
					model.setAmt207(amt207[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (amt113[i] != null)
					model.setAmt113(amt113[i]);
				if (amt201[i] != null)
					model.setAmt201(amt201[i]);
				if (amt112[i] != null)
					model.setAmt112(amt112[i]);
				if (amt111[i] != null)
					model.setAmt111(amt111[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (amt110[i] != null)
					model.setAmt110(amt110[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (amt205[i] != null)
					model.setAmt205(amt205[i]);
				if (amt204[i] != null)
					model.setAmt204(amt204[i]);
				if (amt203[i] != null)
					model.setAmt203(amt203[i]);
				if (amt114[i] != null)
					model.setAmt114(amt114[i]);
				if (amt202[i] != null)
					model.setAmt202(amt202[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (hulBndCd[i] != null)
					model.setHulBndCd(hulBndCd[i]);
				if (vopCd[i] != null)
					model.setVopCd(vopCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (amt213[i] != null)
					model.setAmt213(amt213[i]);
				if (amt214[i] != null)
					model.setAmt214(amt214[i]);
				if (amt211[i] != null)
					model.setAmt211(amt211[i]);
				if (amt107[i] != null)
					model.setAmt107(amt107[i]);
				if (amt212[i] != null)
					model.setAmt212(amt212[i]);
				if (amt108[i] != null)
					model.setAmt108(amt108[i]);
				if (amt109[i] != null)
					model.setAmt109(amt109[i]);
				if (amt210[i] != null)
					model.setAmt210(amt210[i]);
				if (vslCapa[i] != null)
					model.setVslCapa(vslCapa[i]);
				if (bsaCapa[i] != null)
					model.setBsaCapa(bsaCapa[i]);
				if (amt104[i] != null)
					model.setAmt104(amt104[i]);
				if (amt103[i] != null)
					model.setAmt103(amt103[i]);
				if (amt106[i] != null)
					model.setAmt106(amt106[i]);
				if (amt105[i] != null)
					model.setAmt105(amt105[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (hjsSlsUcQty[i] != null)
					model.setHjsSlsUcQty(hjsSlsUcQty[i]);
				if (amt102[i] != null)
					model.setAmt102(amt102[i]);
				if (amt101[i] != null)
					model.setAmt101(amt101[i]);
				if (bsaOpCd[i] != null)
					model.setBsaOpCd(bsaOpCd[i]);
				if (vslOshpCd[i] != null)
					model.setVslOshpCd(vslOshpCd[i]);
				if (hjsSlsAmt[i] != null)
					model.setHjsSlsAmt(hjsSlsAmt[i]);
				if (fnlHjsBsaCapa[i] != null)
					model.setFnlHjsBsaCapa(fnlHjsBsaCapa[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getHJSSalesUnitCostVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return HJSSalesUnitCostVO[]
	 */
	public HJSSalesUnitCostVO[] getHJSSalesUnitCostVOs(){
		HJSSalesUnitCostVO[] vos = (HJSSalesUnitCostVO[])models.toArray(new HJSSalesUnitCostVO[models.size()]);
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
		this.bsaOpNm = this.bsaOpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt208 = this.amt208 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt209 = this.amt209 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt206 = this.amt206 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt207 = this.amt207 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt113 = this.amt113 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt201 = this.amt201 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt112 = this.amt112 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt111 = this.amt111 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt110 = this.amt110 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt205 = this.amt205 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt204 = this.amt204 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt203 = this.amt203 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt114 = this.amt114 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt202 = this.amt202 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hulBndCd = this.hulBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vopCd = this.vopCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt213 = this.amt213 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt214 = this.amt214 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt211 = this.amt211 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt107 = this.amt107 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt212 = this.amt212 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt108 = this.amt108 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt109 = this.amt109 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt210 = this.amt210 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCapa = this.vslCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaCapa = this.bsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt104 = this.amt104 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt103 = this.amt103 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt106 = this.amt106 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt105 = this.amt105 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjsSlsUcQty = this.hjsSlsUcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt102 = this.amt102 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt101 = this.amt101 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaOpCd = this.bsaOpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslOshpCd = this.vslOshpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjsSlsAmt = this.hjsSlsAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlHjsBsaCapa = this.fnlHjsBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
