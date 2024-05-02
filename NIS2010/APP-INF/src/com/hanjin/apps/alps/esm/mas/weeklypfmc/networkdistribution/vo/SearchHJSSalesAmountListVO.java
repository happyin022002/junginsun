/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SearchHJSSalesAmountListVO.java
*@FileTitle : SearchHJSSalesAmountListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.14
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.14  
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchHJSSalesAmountListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchHJSSalesAmountListVO> models = new ArrayList<SearchHJSSalesAmountListVO>();
	
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String amt308 = null;
	/* Column Info */
	private String amt109 = null;
	/* Column Info */
	private String amt307 = null;
	/* Column Info */
	private String amt108 = null;
	/* Column Info */
	private String amt306 = null;
	/* Column Info */
	private String amt107 = null;
	/* Column Info */
	private String amt305 = null;
	/* Column Info */
	private String bsaOpNm = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String hulBndCd = null;
	/* Column Info */
	private String amt309 = null;
	/* Column Info */
	private String amt102 = null;
	/* Column Info */
	private String amt101 = null;
	/* Column Info */
	private String compareKey = null;
	/* Column Info */
	private String amt106 = null;
	/* Column Info */
	private String amt304 = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String amt105 = null;
	/* Column Info */
	private String amt303 = null;
	/* Column Info */
	private String amt104 = null;
	/* Column Info */
	private String amt302 = null;
	/* Column Info */
	private String amt103 = null;
	/* Column Info */
	private String amt301 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String vopCd = null;
	/* Column Info */
	private String bsaOpCd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String amt212 = null;
	/* Column Info */
	private String amt211 = null;
	/* Column Info */
	private String amt210 = null;
	/* Column Info */
	private String hjsBsaRto = null;
	/* Column Info */
	private String amt214 = null;
	/* Column Info */
	private String amt213 = null;
	/* Column Info */
	private String vslOshpCd = null;
	/* Column Info */
	private String coBsaCapa = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String opLaneTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String chtrBsaRto = null;
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String amt209 = null;
	/* Column Info */
	private String bsaCapa = null;
	/* Column Info */
	private String amt208 = null;
	/* Column Info */
	private String amt207 = null;
	/* Column Info */
	private String fnlHjsBsaCapa = null;
	/* Column Info */
	private String amt206 = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String vslCapa = null;
	/* Column Info */
	private String amt201 = null;
	/* Column Info */
	private String amt205 = null;
	/* Column Info */
	private String amt204 = null;
	/* Column Info */
	private String amt203 = null;
	/* Column Info */
	private String amt202 = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String tsUcAmt = null;
	/* Column Info */
	private String amt113 = null;
	/* Column Info */
	private String amt311 = null;
	/* Column Info */
	private String amt112 = null;
	/* Column Info */
	private String amt310 = null;
	/* Column Info */
	private String amt111 = null;
	/* Column Info */
	private String amt110 = null;
	/* Column Info */
	private String amt314 = null;
	/* Column Info */
	private String amt313 = null;
	/* Column Info */
	private String spcIncome = null;
	/* Column Info */
	private String amt114 = null;
	/* Column Info */
	private String amt312 = null;
	/* Column Info */
	private String dirCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchHJSSalesAmountListVO() {}

	public SearchHJSSalesAmountListVO(String ibflag, String pagerows, String costYrmon, String costWk, String trdCd, String rlaneCd, String vslCd, String skdVoyNo, String dirCd, String hulBndCd, String vopCd, String vslOshpCd, String vslCapa, String bsaCapa, String bsaOpCd, String bsaOpNm, String fnlHjsBsaCapa, String opLaneTpCd, String spcIncome, String coBsaCapa, String hjsBsaRto, String chtrBsaRto, String tsUcAmt, String amt101, String amt102, String amt103, String amt104, String amt105, String amt106, String amt107, String amt108, String amt109, String amt110, String amt111, String amt112, String amt113, String amt114, String amt201, String amt202, String amt203, String amt204, String amt205, String amt206, String amt207, String amt208, String amt209, String amt210, String amt211, String amt212, String amt213, String amt214, String amt301, String amt302, String amt303, String amt304, String amt305, String amt306, String amt307, String amt308, String amt309, String amt310, String amt311, String amt312, String amt313, String amt314, String iocCd, String compareKey, String creUsrId, String updUsrId) {
		this.rlaneCd = rlaneCd;
		this.amt308 = amt308;
		this.amt109 = amt109;
		this.amt307 = amt307;
		this.amt108 = amt108;
		this.amt306 = amt306;
		this.amt107 = amt107;
		this.amt305 = amt305;
		this.bsaOpNm = bsaOpNm;
		this.updUsrId = updUsrId;
		this.hulBndCd = hulBndCd;
		this.amt309 = amt309;
		this.amt102 = amt102;
		this.amt101 = amt101;
		this.compareKey = compareKey;
		this.amt106 = amt106;
		this.amt304 = amt304;
		this.costYrmon = costYrmon;
		this.amt105 = amt105;
		this.amt303 = amt303;
		this.amt104 = amt104;
		this.amt302 = amt302;
		this.amt103 = amt103;
		this.amt301 = amt301;
		this.pagerows = pagerows;
		this.vslCd = vslCd;
		this.vopCd = vopCd;
		this.bsaOpCd = bsaOpCd;
		this.trdCd = trdCd;
		this.amt212 = amt212;
		this.amt211 = amt211;
		this.amt210 = amt210;
		this.hjsBsaRto = hjsBsaRto;
		this.amt214 = amt214;
		this.amt213 = amt213;
		this.vslOshpCd = vslOshpCd;
		this.coBsaCapa = coBsaCapa;
		this.costWk = costWk;
		this.opLaneTpCd = opLaneTpCd;
		this.ibflag = ibflag;
		this.chtrBsaRto = chtrBsaRto;
		this.iocCd = iocCd;
		this.amt209 = amt209;
		this.bsaCapa = bsaCapa;
		this.amt208 = amt208;
		this.amt207 = amt207;
		this.fnlHjsBsaCapa = fnlHjsBsaCapa;
		this.amt206 = amt206;
		this.creUsrId = creUsrId;
		this.vslCapa = vslCapa;
		this.amt201 = amt201;
		this.amt205 = amt205;
		this.amt204 = amt204;
		this.amt203 = amt203;
		this.amt202 = amt202;
		this.skdVoyNo = skdVoyNo;
		this.tsUcAmt = tsUcAmt;
		this.amt113 = amt113;
		this.amt311 = amt311;
		this.amt112 = amt112;
		this.amt310 = amt310;
		this.amt111 = amt111;
		this.amt110 = amt110;
		this.amt314 = amt314;
		this.amt313 = amt313;
		this.spcIncome = spcIncome;
		this.amt114 = amt114;
		this.amt312 = amt312;
		this.dirCd = dirCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("amt_3_08", getAmt308());
		this.hashColumns.put("amt_1_09", getAmt109());
		this.hashColumns.put("amt_3_07", getAmt307());
		this.hashColumns.put("amt_1_08", getAmt108());
		this.hashColumns.put("amt_3_06", getAmt306());
		this.hashColumns.put("amt_1_07", getAmt107());
		this.hashColumns.put("amt_3_05", getAmt305());
		this.hashColumns.put("bsa_op_nm", getBsaOpNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("hul_bnd_cd", getHulBndCd());
		this.hashColumns.put("amt_3_09", getAmt309());
		this.hashColumns.put("amt_1_02", getAmt102());
		this.hashColumns.put("amt_1_01", getAmt101());
		this.hashColumns.put("compare_key", getCompareKey());
		this.hashColumns.put("amt_1_06", getAmt106());
		this.hashColumns.put("amt_3_04", getAmt304());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("amt_1_05", getAmt105());
		this.hashColumns.put("amt_3_03", getAmt303());
		this.hashColumns.put("amt_1_04", getAmt104());
		this.hashColumns.put("amt_3_02", getAmt302());
		this.hashColumns.put("amt_1_03", getAmt103());
		this.hashColumns.put("amt_3_01", getAmt301());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("vop_cd", getVopCd());
		this.hashColumns.put("bsa_op_cd", getBsaOpCd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("amt_2_12", getAmt212());
		this.hashColumns.put("amt_2_11", getAmt211());
		this.hashColumns.put("amt_2_10", getAmt210());
		this.hashColumns.put("hjs_bsa_rto", getHjsBsaRto());
		this.hashColumns.put("amt_2_14", getAmt214());
		this.hashColumns.put("amt_2_13", getAmt213());
		this.hashColumns.put("vsl_oshp_cd", getVslOshpCd());
		this.hashColumns.put("co_bsa_capa", getCoBsaCapa());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("op_lane_tp_cd", getOpLaneTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("chtr_bsa_rto", getChtrBsaRto());
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("amt_2_09", getAmt209());
		this.hashColumns.put("bsa_capa", getBsaCapa());
		this.hashColumns.put("amt_2_08", getAmt208());
		this.hashColumns.put("amt_2_07", getAmt207());
		this.hashColumns.put("fnl_hjs_bsa_capa", getFnlHjsBsaCapa());
		this.hashColumns.put("amt_2_06", getAmt206());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("vsl_capa", getVslCapa());
		this.hashColumns.put("amt_2_01", getAmt201());
		this.hashColumns.put("amt_2_05", getAmt205());
		this.hashColumns.put("amt_2_04", getAmt204());
		this.hashColumns.put("amt_2_03", getAmt203());
		this.hashColumns.put("amt_2_02", getAmt202());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("ts_uc_amt", getTsUcAmt());
		this.hashColumns.put("amt_1_13", getAmt113());
		this.hashColumns.put("amt_3_11", getAmt311());
		this.hashColumns.put("amt_1_12", getAmt112());
		this.hashColumns.put("amt_3_10", getAmt310());
		this.hashColumns.put("amt_1_11", getAmt111());
		this.hashColumns.put("amt_1_10", getAmt110());
		this.hashColumns.put("amt_3_14", getAmt314());
		this.hashColumns.put("amt_3_13", getAmt313());
		this.hashColumns.put("spc_income", getSpcIncome());
		this.hashColumns.put("amt_1_14", getAmt114());
		this.hashColumns.put("amt_3_12", getAmt312());
		this.hashColumns.put("dir_cd", getDirCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("amt_3_08", "amt308");
		this.hashFields.put("amt_1_09", "amt109");
		this.hashFields.put("amt_3_07", "amt307");
		this.hashFields.put("amt_1_08", "amt108");
		this.hashFields.put("amt_3_06", "amt306");
		this.hashFields.put("amt_1_07", "amt107");
		this.hashFields.put("amt_3_05", "amt305");
		this.hashFields.put("bsa_op_nm", "bsaOpNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("hul_bnd_cd", "hulBndCd");
		this.hashFields.put("amt_3_09", "amt309");
		this.hashFields.put("amt_1_02", "amt102");
		this.hashFields.put("amt_1_01", "amt101");
		this.hashFields.put("compare_key", "compareKey");
		this.hashFields.put("amt_1_06", "amt106");
		this.hashFields.put("amt_3_04", "amt304");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("amt_1_05", "amt105");
		this.hashFields.put("amt_3_03", "amt303");
		this.hashFields.put("amt_1_04", "amt104");
		this.hashFields.put("amt_3_02", "amt302");
		this.hashFields.put("amt_1_03", "amt103");
		this.hashFields.put("amt_3_01", "amt301");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vop_cd", "vopCd");
		this.hashFields.put("bsa_op_cd", "bsaOpCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("amt_2_12", "amt212");
		this.hashFields.put("amt_2_11", "amt211");
		this.hashFields.put("amt_2_10", "amt210");
		this.hashFields.put("hjs_bsa_rto", "hjsBsaRto");
		this.hashFields.put("amt_2_14", "amt214");
		this.hashFields.put("amt_2_13", "amt213");
		this.hashFields.put("vsl_oshp_cd", "vslOshpCd");
		this.hashFields.put("co_bsa_capa", "coBsaCapa");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("op_lane_tp_cd", "opLaneTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("chtr_bsa_rto", "chtrBsaRto");
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("amt_2_09", "amt209");
		this.hashFields.put("bsa_capa", "bsaCapa");
		this.hashFields.put("amt_2_08", "amt208");
		this.hashFields.put("amt_2_07", "amt207");
		this.hashFields.put("fnl_hjs_bsa_capa", "fnlHjsBsaCapa");
		this.hashFields.put("amt_2_06", "amt206");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("vsl_capa", "vslCapa");
		this.hashFields.put("amt_2_01", "amt201");
		this.hashFields.put("amt_2_05", "amt205");
		this.hashFields.put("amt_2_04", "amt204");
		this.hashFields.put("amt_2_03", "amt203");
		this.hashFields.put("amt_2_02", "amt202");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("ts_uc_amt", "tsUcAmt");
		this.hashFields.put("amt_1_13", "amt113");
		this.hashFields.put("amt_3_11", "amt311");
		this.hashFields.put("amt_1_12", "amt112");
		this.hashFields.put("amt_3_10", "amt310");
		this.hashFields.put("amt_1_11", "amt111");
		this.hashFields.put("amt_1_10", "amt110");
		this.hashFields.put("amt_3_14", "amt314");
		this.hashFields.put("amt_3_13", "amt313");
		this.hashFields.put("spc_income", "spcIncome");
		this.hashFields.put("amt_1_14", "amt114");
		this.hashFields.put("amt_3_12", "amt312");
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
	 * @return amt308
	 */
	public String getAmt308() {
		return this.amt308;
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
	 * @return amt307
	 */
	public String getAmt307() {
		return this.amt307;
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
	 * @return amt306
	 */
	public String getAmt306() {
		return this.amt306;
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
	 * @return amt305
	 */
	public String getAmt305() {
		return this.amt305;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @return amt309
	 */
	public String getAmt309() {
		return this.amt309;
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
	 * @return compareKey
	 */
	public String getCompareKey() {
		return this.compareKey;
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
	 * @return amt304
	 */
	public String getAmt304() {
		return this.amt304;
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
	 * @return amt105
	 */
	public String getAmt105() {
		return this.amt105;
	}
	
	/**
	 * Column Info
	 * @return amt303
	 */
	public String getAmt303() {
		return this.amt303;
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
	 * @return amt302
	 */
	public String getAmt302() {
		return this.amt302;
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
	 * @return amt301
	 */
	public String getAmt301() {
		return this.amt301;
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
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
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
	 * @return bsaOpCd
	 */
	public String getBsaOpCd() {
		return this.bsaOpCd;
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
	 * @return amt212
	 */
	public String getAmt212() {
		return this.amt212;
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
	 * @return amt210
	 */
	public String getAmt210() {
		return this.amt210;
	}
	
	/**
	 * Column Info
	 * @return hjsBsaRto
	 */
	public String getHjsBsaRto() {
		return this.hjsBsaRto;
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
	 * @return amt213
	 */
	public String getAmt213() {
		return this.amt213;
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
	 * @return coBsaCapa
	 */
	public String getCoBsaCapa() {
		return this.coBsaCapa;
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
	 * @return opLaneTpCd
	 */
	public String getOpLaneTpCd() {
		return this.opLaneTpCd;
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
	 * @return chtrBsaRto
	 */
	public String getChtrBsaRto() {
		return this.chtrBsaRto;
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
	 * @return amt209
	 */
	public String getAmt209() {
		return this.amt209;
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
	 * @return amt208
	 */
	public String getAmt208() {
		return this.amt208;
	}
	
	/**
	 * Column Info
	 * @return amt207
	 */
	public String getAmt207() {
		return this.amt207;
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
	 * @return amt206
	 */
	public String getAmt206() {
		return this.amt206;
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
	 * @return vslCapa
	 */
	public String getVslCapa() {
		return this.vslCapa;
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
	 * @return amt202
	 */
	public String getAmt202() {
		return this.amt202;
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
	 * @return tsUcAmt
	 */
	public String getTsUcAmt() {
		return this.tsUcAmt;
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
	 * @return amt311
	 */
	public String getAmt311() {
		return this.amt311;
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
	 * @return amt310
	 */
	public String getAmt310() {
		return this.amt310;
	}
	
	/**
	 * Column Info
	 * @return amt111
	 */
	public String getAmt111() {
		return this.amt111;
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
	 * @return amt314
	 */
	public String getAmt314() {
		return this.amt314;
	}
	
	/**
	 * Column Info
	 * @return amt313
	 */
	public String getAmt313() {
		return this.amt313;
	}
	
	/**
	 * Column Info
	 * @return spcIncome
	 */
	public String getSpcIncome() {
		return this.spcIncome;
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
	 * @return amt312
	 */
	public String getAmt312() {
		return this.amt312;
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
	 * @param amt308
	 */
	public void setAmt308(String amt308) {
		this.amt308 = amt308;
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
	 * @param amt307
	 */
	public void setAmt307(String amt307) {
		this.amt307 = amt307;
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
	 * @param amt306
	 */
	public void setAmt306(String amt306) {
		this.amt306 = amt306;
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
	 * @param amt305
	 */
	public void setAmt305(String amt305) {
		this.amt305 = amt305;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
	 * @param amt309
	 */
	public void setAmt309(String amt309) {
		this.amt309 = amt309;
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
	 * @param compareKey
	 */
	public void setCompareKey(String compareKey) {
		this.compareKey = compareKey;
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
	 * @param amt304
	 */
	public void setAmt304(String amt304) {
		this.amt304 = amt304;
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
	 * @param amt105
	 */
	public void setAmt105(String amt105) {
		this.amt105 = amt105;
	}
	
	/**
	 * Column Info
	 * @param amt303
	 */
	public void setAmt303(String amt303) {
		this.amt303 = amt303;
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
	 * @param amt302
	 */
	public void setAmt302(String amt302) {
		this.amt302 = amt302;
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
	 * @param amt301
	 */
	public void setAmt301(String amt301) {
		this.amt301 = amt301;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
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
	 * @param bsaOpCd
	 */
	public void setBsaOpCd(String bsaOpCd) {
		this.bsaOpCd = bsaOpCd;
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
	 * @param amt212
	 */
	public void setAmt212(String amt212) {
		this.amt212 = amt212;
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
	 * @param amt210
	 */
	public void setAmt210(String amt210) {
		this.amt210 = amt210;
	}
	
	/**
	 * Column Info
	 * @param hjsBsaRto
	 */
	public void setHjsBsaRto(String hjsBsaRto) {
		this.hjsBsaRto = hjsBsaRto;
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
	 * @param amt213
	 */
	public void setAmt213(String amt213) {
		this.amt213 = amt213;
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
	 * @param coBsaCapa
	 */
	public void setCoBsaCapa(String coBsaCapa) {
		this.coBsaCapa = coBsaCapa;
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
	 * @param opLaneTpCd
	 */
	public void setOpLaneTpCd(String opLaneTpCd) {
		this.opLaneTpCd = opLaneTpCd;
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
	 * @param chtrBsaRto
	 */
	public void setChtrBsaRto(String chtrBsaRto) {
		this.chtrBsaRto = chtrBsaRto;
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
	 * @param amt209
	 */
	public void setAmt209(String amt209) {
		this.amt209 = amt209;
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
	 * @param amt208
	 */
	public void setAmt208(String amt208) {
		this.amt208 = amt208;
	}
	
	/**
	 * Column Info
	 * @param amt207
	 */
	public void setAmt207(String amt207) {
		this.amt207 = amt207;
	}
	
	/**
	 * Column Info
	 * @param fnlHjsBsaCapa
	 */
	public void setFnlHjsBsaCapa(String fnlHjsBsaCapa) {
		this.fnlHjsBsaCapa = fnlHjsBsaCapa;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param amt201
	 */
	public void setAmt201(String amt201) {
		this.amt201 = amt201;
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
	 * @param amt202
	 */
	public void setAmt202(String amt202) {
		this.amt202 = amt202;
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
	 * @param tsUcAmt
	 */
	public void setTsUcAmt(String tsUcAmt) {
		this.tsUcAmt = tsUcAmt;
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
	 * @param amt311
	 */
	public void setAmt311(String amt311) {
		this.amt311 = amt311;
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
	 * @param amt310
	 */
	public void setAmt310(String amt310) {
		this.amt310 = amt310;
	}
	
	/**
	 * Column Info
	 * @param amt111
	 */
	public void setAmt111(String amt111) {
		this.amt111 = amt111;
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
	 * @param amt314
	 */
	public void setAmt314(String amt314) {
		this.amt314 = amt314;
	}
	
	/**
	 * Column Info
	 * @param amt313
	 */
	public void setAmt313(String amt313) {
		this.amt313 = amt313;
	}
	
	/**
	 * Column Info
	 * @param spcIncome
	 */
	public void setSpcIncome(String spcIncome) {
		this.spcIncome = spcIncome;
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
	 * @param amt312
	 */
	public void setAmt312(String amt312) {
		this.amt312 = amt312;
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
		setAmt308(JSPUtil.getParameter(request, prefix + "amt_3_08", ""));
		setAmt109(JSPUtil.getParameter(request, prefix + "amt_1_09", ""));
		setAmt307(JSPUtil.getParameter(request, prefix + "amt_3_07", ""));
		setAmt108(JSPUtil.getParameter(request, prefix + "amt_1_08", ""));
		setAmt306(JSPUtil.getParameter(request, prefix + "amt_3_06", ""));
		setAmt107(JSPUtil.getParameter(request, prefix + "amt_1_07", ""));
		setAmt305(JSPUtil.getParameter(request, prefix + "amt_3_05", ""));
		setBsaOpNm(JSPUtil.getParameter(request, prefix + "bsa_op_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setHulBndCd(JSPUtil.getParameter(request, prefix + "hul_bnd_cd", ""));
		setAmt309(JSPUtil.getParameter(request, prefix + "amt_3_09", ""));
		setAmt102(JSPUtil.getParameter(request, prefix + "amt_1_02", ""));
		setAmt101(JSPUtil.getParameter(request, prefix + "amt_1_01", ""));
		setCompareKey(JSPUtil.getParameter(request, prefix + "compare_key", ""));
		setAmt106(JSPUtil.getParameter(request, prefix + "amt_1_06", ""));
		setAmt304(JSPUtil.getParameter(request, prefix + "amt_3_04", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setAmt105(JSPUtil.getParameter(request, prefix + "amt_1_05", ""));
		setAmt303(JSPUtil.getParameter(request, prefix + "amt_3_03", ""));
		setAmt104(JSPUtil.getParameter(request, prefix + "amt_1_04", ""));
		setAmt302(JSPUtil.getParameter(request, prefix + "amt_3_02", ""));
		setAmt103(JSPUtil.getParameter(request, prefix + "amt_1_03", ""));
		setAmt301(JSPUtil.getParameter(request, prefix + "amt_3_01", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setVopCd(JSPUtil.getParameter(request, prefix + "vop_cd", ""));
		setBsaOpCd(JSPUtil.getParameter(request, prefix + "bsa_op_cd", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setAmt212(JSPUtil.getParameter(request, prefix + "amt_2_12", ""));
		setAmt211(JSPUtil.getParameter(request, prefix + "amt_2_11", ""));
		setAmt210(JSPUtil.getParameter(request, prefix + "amt_2_10", ""));
		setHjsBsaRto(JSPUtil.getParameter(request, prefix + "hjs_bsa_rto", ""));
		setAmt214(JSPUtil.getParameter(request, prefix + "amt_2_14", ""));
		setAmt213(JSPUtil.getParameter(request, prefix + "amt_2_13", ""));
		setVslOshpCd(JSPUtil.getParameter(request, prefix + "vsl_oshp_cd", ""));
		setCoBsaCapa(JSPUtil.getParameter(request, prefix + "co_bsa_capa", ""));
		setCostWk(JSPUtil.getParameter(request, prefix + "cost_wk", ""));
		setOpLaneTpCd(JSPUtil.getParameter(request, prefix + "op_lane_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setChtrBsaRto(JSPUtil.getParameter(request, prefix + "chtr_bsa_rto", ""));
		setIocCd(JSPUtil.getParameter(request, prefix + "ioc_cd", ""));
		setAmt209(JSPUtil.getParameter(request, prefix + "amt_2_09", ""));
		setBsaCapa(JSPUtil.getParameter(request, prefix + "bsa_capa", ""));
		setAmt208(JSPUtil.getParameter(request, prefix + "amt_2_08", ""));
		setAmt207(JSPUtil.getParameter(request, prefix + "amt_2_07", ""));
		setFnlHjsBsaCapa(JSPUtil.getParameter(request, prefix + "fnl_hjs_bsa_capa", ""));
		setAmt206(JSPUtil.getParameter(request, prefix + "amt_2_06", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setVslCapa(JSPUtil.getParameter(request, prefix + "vsl_capa", ""));
		setAmt201(JSPUtil.getParameter(request, prefix + "amt_2_01", ""));
		setAmt205(JSPUtil.getParameter(request, prefix + "amt_2_05", ""));
		setAmt204(JSPUtil.getParameter(request, prefix + "amt_2_04", ""));
		setAmt203(JSPUtil.getParameter(request, prefix + "amt_2_03", ""));
		setAmt202(JSPUtil.getParameter(request, prefix + "amt_2_02", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setTsUcAmt(JSPUtil.getParameter(request, prefix + "ts_uc_amt", ""));
		setAmt113(JSPUtil.getParameter(request, prefix + "amt_1_13", ""));
		setAmt311(JSPUtil.getParameter(request, prefix + "amt_3_11", ""));
		setAmt112(JSPUtil.getParameter(request, prefix + "amt_1_12", ""));
		setAmt310(JSPUtil.getParameter(request, prefix + "amt_3_10", ""));
		setAmt111(JSPUtil.getParameter(request, prefix + "amt_1_11", ""));
		setAmt110(JSPUtil.getParameter(request, prefix + "amt_1_10", ""));
		setAmt314(JSPUtil.getParameter(request, prefix + "amt_3_14", ""));
		setAmt313(JSPUtil.getParameter(request, prefix + "amt_3_13", ""));
		setSpcIncome(JSPUtil.getParameter(request, prefix + "spc_income", ""));
		setAmt114(JSPUtil.getParameter(request, prefix + "amt_1_14", ""));
		setAmt312(JSPUtil.getParameter(request, prefix + "amt_3_12", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchHJSSalesAmountListVO[]
	 */
	public SearchHJSSalesAmountListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchHJSSalesAmountListVO[]
	 */
	public SearchHJSSalesAmountListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchHJSSalesAmountListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] amt308 = (JSPUtil.getParameter(request, prefix	+ "amt_3_08", length));
			String[] amt109 = (JSPUtil.getParameter(request, prefix	+ "amt_1_09", length));
			String[] amt307 = (JSPUtil.getParameter(request, prefix	+ "amt_3_07", length));
			String[] amt108 = (JSPUtil.getParameter(request, prefix	+ "amt_1_08", length));
			String[] amt306 = (JSPUtil.getParameter(request, prefix	+ "amt_3_06", length));
			String[] amt107 = (JSPUtil.getParameter(request, prefix	+ "amt_1_07", length));
			String[] amt305 = (JSPUtil.getParameter(request, prefix	+ "amt_3_05", length));
			String[] bsaOpNm = (JSPUtil.getParameter(request, prefix	+ "bsa_op_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] hulBndCd = (JSPUtil.getParameter(request, prefix	+ "hul_bnd_cd", length));
			String[] amt309 = (JSPUtil.getParameter(request, prefix	+ "amt_3_09", length));
			String[] amt102 = (JSPUtil.getParameter(request, prefix	+ "amt_1_02", length));
			String[] amt101 = (JSPUtil.getParameter(request, prefix	+ "amt_1_01", length));
			String[] compareKey = (JSPUtil.getParameter(request, prefix	+ "compare_key", length));
			String[] amt106 = (JSPUtil.getParameter(request, prefix	+ "amt_1_06", length));
			String[] amt304 = (JSPUtil.getParameter(request, prefix	+ "amt_3_04", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] amt105 = (JSPUtil.getParameter(request, prefix	+ "amt_1_05", length));
			String[] amt303 = (JSPUtil.getParameter(request, prefix	+ "amt_3_03", length));
			String[] amt104 = (JSPUtil.getParameter(request, prefix	+ "amt_1_04", length));
			String[] amt302 = (JSPUtil.getParameter(request, prefix	+ "amt_3_02", length));
			String[] amt103 = (JSPUtil.getParameter(request, prefix	+ "amt_1_03", length));
			String[] amt301 = (JSPUtil.getParameter(request, prefix	+ "amt_3_01", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] vopCd = (JSPUtil.getParameter(request, prefix	+ "vop_cd", length));
			String[] bsaOpCd = (JSPUtil.getParameter(request, prefix	+ "bsa_op_cd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] amt212 = (JSPUtil.getParameter(request, prefix	+ "amt_2_12", length));
			String[] amt211 = (JSPUtil.getParameter(request, prefix	+ "amt_2_11", length));
			String[] amt210 = (JSPUtil.getParameter(request, prefix	+ "amt_2_10", length));
			String[] hjsBsaRto = (JSPUtil.getParameter(request, prefix	+ "hjs_bsa_rto", length));
			String[] amt214 = (JSPUtil.getParameter(request, prefix	+ "amt_2_14", length));
			String[] amt213 = (JSPUtil.getParameter(request, prefix	+ "amt_2_13", length));
			String[] vslOshpCd = (JSPUtil.getParameter(request, prefix	+ "vsl_oshp_cd", length));
			String[] coBsaCapa = (JSPUtil.getParameter(request, prefix	+ "co_bsa_capa", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] opLaneTpCd = (JSPUtil.getParameter(request, prefix	+ "op_lane_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] chtrBsaRto = (JSPUtil.getParameter(request, prefix	+ "chtr_bsa_rto", length));
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] amt209 = (JSPUtil.getParameter(request, prefix	+ "amt_2_09", length));
			String[] bsaCapa = (JSPUtil.getParameter(request, prefix	+ "bsa_capa", length));
			String[] amt208 = (JSPUtil.getParameter(request, prefix	+ "amt_2_08", length));
			String[] amt207 = (JSPUtil.getParameter(request, prefix	+ "amt_2_07", length));
			String[] fnlHjsBsaCapa = (JSPUtil.getParameter(request, prefix	+ "fnl_hjs_bsa_capa", length));
			String[] amt206 = (JSPUtil.getParameter(request, prefix	+ "amt_2_06", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] vslCapa = (JSPUtil.getParameter(request, prefix	+ "vsl_capa", length));
			String[] amt201 = (JSPUtil.getParameter(request, prefix	+ "amt_2_01", length));
			String[] amt205 = (JSPUtil.getParameter(request, prefix	+ "amt_2_05", length));
			String[] amt204 = (JSPUtil.getParameter(request, prefix	+ "amt_2_04", length));
			String[] amt203 = (JSPUtil.getParameter(request, prefix	+ "amt_2_03", length));
			String[] amt202 = (JSPUtil.getParameter(request, prefix	+ "amt_2_02", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] tsUcAmt = (JSPUtil.getParameter(request, prefix	+ "ts_uc_amt", length));
			String[] amt113 = (JSPUtil.getParameter(request, prefix	+ "amt_1_13", length));
			String[] amt311 = (JSPUtil.getParameter(request, prefix	+ "amt_3_11", length));
			String[] amt112 = (JSPUtil.getParameter(request, prefix	+ "amt_1_12", length));
			String[] amt310 = (JSPUtil.getParameter(request, prefix	+ "amt_3_10", length));
			String[] amt111 = (JSPUtil.getParameter(request, prefix	+ "amt_1_11", length));
			String[] amt110 = (JSPUtil.getParameter(request, prefix	+ "amt_1_10", length));
			String[] amt314 = (JSPUtil.getParameter(request, prefix	+ "amt_3_14", length));
			String[] amt313 = (JSPUtil.getParameter(request, prefix	+ "amt_3_13", length));
			String[] spcIncome = (JSPUtil.getParameter(request, prefix	+ "spc_income", length));
			String[] amt114 = (JSPUtil.getParameter(request, prefix	+ "amt_1_14", length));
			String[] amt312 = (JSPUtil.getParameter(request, prefix	+ "amt_3_12", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchHJSSalesAmountListVO();
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (amt308[i] != null)
					model.setAmt308(amt308[i]);
				if (amt109[i] != null)
					model.setAmt109(amt109[i]);
				if (amt307[i] != null)
					model.setAmt307(amt307[i]);
				if (amt108[i] != null)
					model.setAmt108(amt108[i]);
				if (amt306[i] != null)
					model.setAmt306(amt306[i]);
				if (amt107[i] != null)
					model.setAmt107(amt107[i]);
				if (amt305[i] != null)
					model.setAmt305(amt305[i]);
				if (bsaOpNm[i] != null)
					model.setBsaOpNm(bsaOpNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (hulBndCd[i] != null)
					model.setHulBndCd(hulBndCd[i]);
				if (amt309[i] != null)
					model.setAmt309(amt309[i]);
				if (amt102[i] != null)
					model.setAmt102(amt102[i]);
				if (amt101[i] != null)
					model.setAmt101(amt101[i]);
				if (compareKey[i] != null)
					model.setCompareKey(compareKey[i]);
				if (amt106[i] != null)
					model.setAmt106(amt106[i]);
				if (amt304[i] != null)
					model.setAmt304(amt304[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (amt105[i] != null)
					model.setAmt105(amt105[i]);
				if (amt303[i] != null)
					model.setAmt303(amt303[i]);
				if (amt104[i] != null)
					model.setAmt104(amt104[i]);
				if (amt302[i] != null)
					model.setAmt302(amt302[i]);
				if (amt103[i] != null)
					model.setAmt103(amt103[i]);
				if (amt301[i] != null)
					model.setAmt301(amt301[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (vopCd[i] != null)
					model.setVopCd(vopCd[i]);
				if (bsaOpCd[i] != null)
					model.setBsaOpCd(bsaOpCd[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (amt212[i] != null)
					model.setAmt212(amt212[i]);
				if (amt211[i] != null)
					model.setAmt211(amt211[i]);
				if (amt210[i] != null)
					model.setAmt210(amt210[i]);
				if (hjsBsaRto[i] != null)
					model.setHjsBsaRto(hjsBsaRto[i]);
				if (amt214[i] != null)
					model.setAmt214(amt214[i]);
				if (amt213[i] != null)
					model.setAmt213(amt213[i]);
				if (vslOshpCd[i] != null)
					model.setVslOshpCd(vslOshpCd[i]);
				if (coBsaCapa[i] != null)
					model.setCoBsaCapa(coBsaCapa[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (opLaneTpCd[i] != null)
					model.setOpLaneTpCd(opLaneTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (chtrBsaRto[i] != null)
					model.setChtrBsaRto(chtrBsaRto[i]);
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (amt209[i] != null)
					model.setAmt209(amt209[i]);
				if (bsaCapa[i] != null)
					model.setBsaCapa(bsaCapa[i]);
				if (amt208[i] != null)
					model.setAmt208(amt208[i]);
				if (amt207[i] != null)
					model.setAmt207(amt207[i]);
				if (fnlHjsBsaCapa[i] != null)
					model.setFnlHjsBsaCapa(fnlHjsBsaCapa[i]);
				if (amt206[i] != null)
					model.setAmt206(amt206[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (vslCapa[i] != null)
					model.setVslCapa(vslCapa[i]);
				if (amt201[i] != null)
					model.setAmt201(amt201[i]);
				if (amt205[i] != null)
					model.setAmt205(amt205[i]);
				if (amt204[i] != null)
					model.setAmt204(amt204[i]);
				if (amt203[i] != null)
					model.setAmt203(amt203[i]);
				if (amt202[i] != null)
					model.setAmt202(amt202[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (tsUcAmt[i] != null)
					model.setTsUcAmt(tsUcAmt[i]);
				if (amt113[i] != null)
					model.setAmt113(amt113[i]);
				if (amt311[i] != null)
					model.setAmt311(amt311[i]);
				if (amt112[i] != null)
					model.setAmt112(amt112[i]);
				if (amt310[i] != null)
					model.setAmt310(amt310[i]);
				if (amt111[i] != null)
					model.setAmt111(amt111[i]);
				if (amt110[i] != null)
					model.setAmt110(amt110[i]);
				if (amt314[i] != null)
					model.setAmt314(amt314[i]);
				if (amt313[i] != null)
					model.setAmt313(amt313[i]);
				if (spcIncome[i] != null)
					model.setSpcIncome(spcIncome[i]);
				if (amt114[i] != null)
					model.setAmt114(amt114[i]);
				if (amt312[i] != null)
					model.setAmt312(amt312[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchHJSSalesAmountListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchHJSSalesAmountListVO[]
	 */
	public SearchHJSSalesAmountListVO[] getSearchHJSSalesAmountListVOs(){
		SearchHJSSalesAmountListVO[] vos = (SearchHJSSalesAmountListVO[])models.toArray(new SearchHJSSalesAmountListVO[models.size()]);
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
		this.amt308 = this.amt308 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt109 = this.amt109 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt307 = this.amt307 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt108 = this.amt108 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt306 = this.amt306 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt107 = this.amt107 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt305 = this.amt305 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaOpNm = this.bsaOpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hulBndCd = this.hulBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt309 = this.amt309 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt102 = this.amt102 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt101 = this.amt101 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.compareKey = this.compareKey .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt106 = this.amt106 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt304 = this.amt304 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt105 = this.amt105 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt303 = this.amt303 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt104 = this.amt104 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt302 = this.amt302 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt103 = this.amt103 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt301 = this.amt301 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vopCd = this.vopCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaOpCd = this.bsaOpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt212 = this.amt212 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt211 = this.amt211 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt210 = this.amt210 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjsBsaRto = this.hjsBsaRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt214 = this.amt214 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt213 = this.amt213 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslOshpCd = this.vslOshpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coBsaCapa = this.coBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opLaneTpCd = this.opLaneTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chtrBsaRto = this.chtrBsaRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt209 = this.amt209 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaCapa = this.bsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt208 = this.amt208 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt207 = this.amt207 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlHjsBsaCapa = this.fnlHjsBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt206 = this.amt206 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCapa = this.vslCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt201 = this.amt201 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt205 = this.amt205 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt204 = this.amt204 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt203 = this.amt203 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt202 = this.amt202 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsUcAmt = this.tsUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt113 = this.amt113 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt311 = this.amt311 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt112 = this.amt112 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt310 = this.amt310 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt111 = this.amt111 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt110 = this.amt110 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt314 = this.amt314 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt313 = this.amt313 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spcIncome = this.spcIncome .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt114 = this.amt114 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt312 = this.amt312 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
