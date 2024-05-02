/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AverageUCVO.java
*@FileTitle : AverageUCVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.22  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.vo;

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

public class AverageUCVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AverageUCVO> models = new ArrayList<AverageUCVO>();
	
	/* Column Info */
	private String freqNo = null;
	/* Column Info */
	private String fixOthFreqNo = null;
	/* Column Info */
	private String fDirCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String amt03 = null;
	/* Column Info */
	private String amt02 = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String fixChtFreqNo = null;
	/* Column Info */
	private String amt01 = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String amt07 = null;
	/* Column Info */
	private String amt06 = null;
	/* Column Info */
	private String ucOwnFreqNo = null;
	/* Column Info */
	private String amt05 = null;
	/* Column Info */
	private String amt04 = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String amt08 = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String amt09 = null;
	/* Column Info */
	private String opLaneTpCd = null;
	/* Column Info */
	private String costUseTpCd = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String stndCostCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String fCostYrmon = null;
	/* Column Info */
	private String hulBndCd = null;
	/* Column Info */
	private String fixOwnFreqNo = null;
	/* Column Info */
	private String amt10 = null;
	/* Column Info */
	private String amt12 = null;
	/* Column Info */
	private String fToYrwk = null;
	/* Column Info */
	private String amt11 = null;
	/* Column Info */
	private String amt14 = null;
	/* Column Info */
	private String amt13 = null;
	/* Column Info */
	private String ucOthFreqNo = null;
	/* Column Info */
	private String fFmYrwk = null;
	/* Column Info */
	private String fTrdCd = null;
	/* Column Info */
	private String hjsBsaCapa = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String fRlaneCd = null;
	/* Column Info */
	private String vslOshpCd = null;
	/* Column Info */
	private String ucChtFreqNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AverageUCVO() {}

	public AverageUCVO(String ibflag, String pagerows, String costYrmon, String trdCd, String rlaneCd, String dirCd, String hulBndCd, String amt01, String amt02, String amt03, String amt04, String amt05, String amt06, String amt07, String amt08, String amt09, String amt10, String amt11, String amt12, String amt13, String amt14, String opLaneTpCd, String ucOwnFreqNo, String ucChtFreqNo, String ucOthFreqNo, String fixOwnFreqNo, String fixChtFreqNo, String fixOthFreqNo, String stndCostCd, String costUseTpCd, String creUsrId, String creDt, String updUsrId, String updDt, String fCostYrmon, String fTrdCd, String fDirCd, String fRlaneCd, String fFmYrwk, String fToYrwk, String vslOshpCd, String hjsBsaCapa, String freqNo) {
		this.freqNo = freqNo;
		this.fixOthFreqNo = fixOthFreqNo;
		this.fDirCd = fDirCd;
		this.creDt = creDt;
		this.amt03 = amt03;
		this.amt02 = amt02;
		this.trdCd = trdCd;
		this.fixChtFreqNo = fixChtFreqNo;
		this.amt01 = amt01;
		this.rlaneCd = rlaneCd;
		this.amt07 = amt07;
		this.amt06 = amt06;
		this.ucOwnFreqNo = ucOwnFreqNo;
		this.amt05 = amt05;
		this.amt04 = amt04;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.amt08 = amt08;
		this.costYrmon = costYrmon;
		this.amt09 = amt09;
		this.opLaneTpCd = opLaneTpCd;
		this.costUseTpCd = costUseTpCd;
		this.dirCd = dirCd;
		this.updUsrId = updUsrId;
		this.stndCostCd = stndCostCd;
		this.updDt = updDt;
		this.fCostYrmon = fCostYrmon;
		this.hulBndCd = hulBndCd;
		this.fixOwnFreqNo = fixOwnFreqNo;
		this.amt10 = amt10;
		this.amt12 = amt12;
		this.fToYrwk = fToYrwk;
		this.amt11 = amt11;
		this.amt14 = amt14;
		this.amt13 = amt13;
		this.ucOthFreqNo = ucOthFreqNo;
		this.fFmYrwk = fFmYrwk;
		this.fTrdCd = fTrdCd;
		this.hjsBsaCapa = hjsBsaCapa;
		this.creUsrId = creUsrId;
		this.fRlaneCd = fRlaneCd;
		this.vslOshpCd = vslOshpCd;
		this.ucChtFreqNo = ucChtFreqNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("freq_no", getFreqNo());
		this.hashColumns.put("fix_oth_freq_no", getFixOthFreqNo());
		this.hashColumns.put("f_dir_cd", getFDirCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("amt_03", getAmt03());
		this.hashColumns.put("amt_02", getAmt02());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("fix_cht_freq_no", getFixChtFreqNo());
		this.hashColumns.put("amt_01", getAmt01());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("amt_07", getAmt07());
		this.hashColumns.put("amt_06", getAmt06());
		this.hashColumns.put("uc_own_freq_no", getUcOwnFreqNo());
		this.hashColumns.put("amt_05", getAmt05());
		this.hashColumns.put("amt_04", getAmt04());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("amt_08", getAmt08());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("amt_09", getAmt09());
		this.hashColumns.put("op_lane_tp_cd", getOpLaneTpCd());
		this.hashColumns.put("cost_use_tp_cd", getCostUseTpCd());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("stnd_cost_cd", getStndCostCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("f_cost_yrmon", getFCostYrmon());
		this.hashColumns.put("hul_bnd_cd", getHulBndCd());
		this.hashColumns.put("fix_own_freq_no", getFixOwnFreqNo());
		this.hashColumns.put("amt_10", getAmt10());
		this.hashColumns.put("amt_12", getAmt12());
		this.hashColumns.put("f_to_yrwk", getFToYrwk());
		this.hashColumns.put("amt_11", getAmt11());
		this.hashColumns.put("amt_14", getAmt14());
		this.hashColumns.put("amt_13", getAmt13());
		this.hashColumns.put("uc_oth_freq_no", getUcOthFreqNo());
		this.hashColumns.put("f_fm_yrwk", getFFmYrwk());
		this.hashColumns.put("f_trd_cd", getFTrdCd());
		this.hashColumns.put("hjs_bsa_capa", getHjsBsaCapa());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("f_rlane_cd", getFRlaneCd());
		this.hashColumns.put("vsl_oshp_cd", getVslOshpCd());
		this.hashColumns.put("uc_cht_freq_no", getUcChtFreqNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("freq_no", "freqNo");
		this.hashFields.put("fix_oth_freq_no", "fixOthFreqNo");
		this.hashFields.put("f_dir_cd", "fDirCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("amt_03", "amt03");
		this.hashFields.put("amt_02", "amt02");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("fix_cht_freq_no", "fixChtFreqNo");
		this.hashFields.put("amt_01", "amt01");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("amt_07", "amt07");
		this.hashFields.put("amt_06", "amt06");
		this.hashFields.put("uc_own_freq_no", "ucOwnFreqNo");
		this.hashFields.put("amt_05", "amt05");
		this.hashFields.put("amt_04", "amt04");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("amt_08", "amt08");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("amt_09", "amt09");
		this.hashFields.put("op_lane_tp_cd", "opLaneTpCd");
		this.hashFields.put("cost_use_tp_cd", "costUseTpCd");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("stnd_cost_cd", "stndCostCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("f_cost_yrmon", "fCostYrmon");
		this.hashFields.put("hul_bnd_cd", "hulBndCd");
		this.hashFields.put("fix_own_freq_no", "fixOwnFreqNo");
		this.hashFields.put("amt_10", "amt10");
		this.hashFields.put("amt_12", "amt12");
		this.hashFields.put("f_to_yrwk", "fToYrwk");
		this.hashFields.put("amt_11", "amt11");
		this.hashFields.put("amt_14", "amt14");
		this.hashFields.put("amt_13", "amt13");
		this.hashFields.put("uc_oth_freq_no", "ucOthFreqNo");
		this.hashFields.put("f_fm_yrwk", "fFmYrwk");
		this.hashFields.put("f_trd_cd", "fTrdCd");
		this.hashFields.put("hjs_bsa_capa", "hjsBsaCapa");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("f_rlane_cd", "fRlaneCd");
		this.hashFields.put("vsl_oshp_cd", "vslOshpCd");
		this.hashFields.put("uc_cht_freq_no", "ucChtFreqNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return freqNo
	 */
	public String getFreqNo() {
		return this.freqNo;
	}
	
	/**
	 * Column Info
	 * @return fixOthFreqNo
	 */
	public String getFixOthFreqNo() {
		return this.fixOthFreqNo;
	}
	
	/**
	 * Column Info
	 * @return fDirCd
	 */
	public String getFDirCd() {
		return this.fDirCd;
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
	 * @return amt03
	 */
	public String getAmt03() {
		return this.amt03;
	}
	
	/**
	 * Column Info
	 * @return amt02
	 */
	public String getAmt02() {
		return this.amt02;
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
	 * @return fixChtFreqNo
	 */
	public String getFixChtFreqNo() {
		return this.fixChtFreqNo;
	}
	
	/**
	 * Column Info
	 * @return amt01
	 */
	public String getAmt01() {
		return this.amt01;
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
	 * @return amt07
	 */
	public String getAmt07() {
		return this.amt07;
	}
	
	/**
	 * Column Info
	 * @return amt06
	 */
	public String getAmt06() {
		return this.amt06;
	}
	
	/**
	 * Column Info
	 * @return ucOwnFreqNo
	 */
	public String getUcOwnFreqNo() {
		return this.ucOwnFreqNo;
	}
	
	/**
	 * Column Info
	 * @return amt05
	 */
	public String getAmt05() {
		return this.amt05;
	}
	
	/**
	 * Column Info
	 * @return amt04
	 */
	public String getAmt04() {
		return this.amt04;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return amt08
	 */
	public String getAmt08() {
		return this.amt08;
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
	 * @return amt09
	 */
	public String getAmt09() {
		return this.amt09;
	}
	
	/**
	 * Column Info
	 * @return opLaneTpCd
	 */
	public String getOpLaneTpCd() {
		return this.opLaneTpCd;
	}
	
	/**
	 * Column Info
	 * @return costUseTpCd
	 */
	public String getCostUseTpCd() {
		return this.costUseTpCd;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return stndCostCd
	 */
	public String getStndCostCd() {
		return this.stndCostCd;
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
	 * @return fCostYrmon
	 */
	public String getFCostYrmon() {
		return this.fCostYrmon;
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
	 * @return fixOwnFreqNo
	 */
	public String getFixOwnFreqNo() {
		return this.fixOwnFreqNo;
	}
	
	/**
	 * Column Info
	 * @return amt10
	 */
	public String getAmt10() {
		return this.amt10;
	}
	
	/**
	 * Column Info
	 * @return amt12
	 */
	public String getAmt12() {
		return this.amt12;
	}
	
	/**
	 * Column Info
	 * @return fToYrwk
	 */
	public String getFToYrwk() {
		return this.fToYrwk;
	}
	
	/**
	 * Column Info
	 * @return amt11
	 */
	public String getAmt11() {
		return this.amt11;
	}
	
	/**
	 * Column Info
	 * @return amt14
	 */
	public String getAmt14() {
		return this.amt14;
	}
	
	/**
	 * Column Info
	 * @return amt13
	 */
	public String getAmt13() {
		return this.amt13;
	}
	
	/**
	 * Column Info
	 * @return ucOthFreqNo
	 */
	public String getUcOthFreqNo() {
		return this.ucOthFreqNo;
	}
	
	/**
	 * Column Info
	 * @return fFmYrwk
	 */
	public String getFFmYrwk() {
		return this.fFmYrwk;
	}
	
	/**
	 * Column Info
	 * @return fTrdCd
	 */
	public String getFTrdCd() {
		return this.fTrdCd;
	}
	
	/**
	 * Column Info
	 * @return hjsBsaCapa
	 */
	public String getHjsBsaCapa() {
		return this.hjsBsaCapa;
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
	 * @return fRlaneCd
	 */
	public String getFRlaneCd() {
		return this.fRlaneCd;
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
	 * @return ucChtFreqNo
	 */
	public String getUcChtFreqNo() {
		return this.ucChtFreqNo;
	}
	

	/**
	 * Column Info
	 * @param freqNo
	 */
	public void setFreqNo(String freqNo) {
		this.freqNo = freqNo;
	}
	
	/**
	 * Column Info
	 * @param fixOthFreqNo
	 */
	public void setFixOthFreqNo(String fixOthFreqNo) {
		this.fixOthFreqNo = fixOthFreqNo;
	}
	
	/**
	 * Column Info
	 * @param fDirCd
	 */
	public void setFDirCd(String fDirCd) {
		this.fDirCd = fDirCd;
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
	 * @param amt03
	 */
	public void setAmt03(String amt03) {
		this.amt03 = amt03;
	}
	
	/**
	 * Column Info
	 * @param amt02
	 */
	public void setAmt02(String amt02) {
		this.amt02 = amt02;
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
	 * @param fixChtFreqNo
	 */
	public void setFixChtFreqNo(String fixChtFreqNo) {
		this.fixChtFreqNo = fixChtFreqNo;
	}
	
	/**
	 * Column Info
	 * @param amt01
	 */
	public void setAmt01(String amt01) {
		this.amt01 = amt01;
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
	 * @param amt07
	 */
	public void setAmt07(String amt07) {
		this.amt07 = amt07;
	}
	
	/**
	 * Column Info
	 * @param amt06
	 */
	public void setAmt06(String amt06) {
		this.amt06 = amt06;
	}
	
	/**
	 * Column Info
	 * @param ucOwnFreqNo
	 */
	public void setUcOwnFreqNo(String ucOwnFreqNo) {
		this.ucOwnFreqNo = ucOwnFreqNo;
	}
	
	/**
	 * Column Info
	 * @param amt05
	 */
	public void setAmt05(String amt05) {
		this.amt05 = amt05;
	}
	
	/**
	 * Column Info
	 * @param amt04
	 */
	public void setAmt04(String amt04) {
		this.amt04 = amt04;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param amt08
	 */
	public void setAmt08(String amt08) {
		this.amt08 = amt08;
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
	 * @param amt09
	 */
	public void setAmt09(String amt09) {
		this.amt09 = amt09;
	}
	
	/**
	 * Column Info
	 * @param opLaneTpCd
	 */
	public void setOpLaneTpCd(String opLaneTpCd) {
		this.opLaneTpCd = opLaneTpCd;
	}
	
	/**
	 * Column Info
	 * @param costUseTpCd
	 */
	public void setCostUseTpCd(String costUseTpCd) {
		this.costUseTpCd = costUseTpCd;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param stndCostCd
	 */
	public void setStndCostCd(String stndCostCd) {
		this.stndCostCd = stndCostCd;
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
	 * @param fCostYrmon
	 */
	public void setFCostYrmon(String fCostYrmon) {
		this.fCostYrmon = fCostYrmon;
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
	 * @param fixOwnFreqNo
	 */
	public void setFixOwnFreqNo(String fixOwnFreqNo) {
		this.fixOwnFreqNo = fixOwnFreqNo;
	}
	
	/**
	 * Column Info
	 * @param amt10
	 */
	public void setAmt10(String amt10) {
		this.amt10 = amt10;
	}
	
	/**
	 * Column Info
	 * @param amt12
	 */
	public void setAmt12(String amt12) {
		this.amt12 = amt12;
	}
	
	/**
	 * Column Info
	 * @param fToYrwk
	 */
	public void setFToYrwk(String fToYrwk) {
		this.fToYrwk = fToYrwk;
	}
	
	/**
	 * Column Info
	 * @param amt11
	 */
	public void setAmt11(String amt11) {
		this.amt11 = amt11;
	}
	
	/**
	 * Column Info
	 * @param amt14
	 */
	public void setAmt14(String amt14) {
		this.amt14 = amt14;
	}
	
	/**
	 * Column Info
	 * @param amt13
	 */
	public void setAmt13(String amt13) {
		this.amt13 = amt13;
	}
	
	/**
	 * Column Info
	 * @param ucOthFreqNo
	 */
	public void setUcOthFreqNo(String ucOthFreqNo) {
		this.ucOthFreqNo = ucOthFreqNo;
	}
	
	/**
	 * Column Info
	 * @param fFmYrwk
	 */
	public void setFFmYrwk(String fFmYrwk) {
		this.fFmYrwk = fFmYrwk;
	}
	
	/**
	 * Column Info
	 * @param fTrdCd
	 */
	public void setFTrdCd(String fTrdCd) {
		this.fTrdCd = fTrdCd;
	}
	
	/**
	 * Column Info
	 * @param hjsBsaCapa
	 */
	public void setHjsBsaCapa(String hjsBsaCapa) {
		this.hjsBsaCapa = hjsBsaCapa;
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
	 * @param fRlaneCd
	 */
	public void setFRlaneCd(String fRlaneCd) {
		this.fRlaneCd = fRlaneCd;
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
	 * @param ucChtFreqNo
	 */
	public void setUcChtFreqNo(String ucChtFreqNo) {
		this.ucChtFreqNo = ucChtFreqNo;
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
		setFreqNo(JSPUtil.getParameter(request, prefix + "freq_no", ""));
		setFixOthFreqNo(JSPUtil.getParameter(request, prefix + "fix_oth_freq_no", ""));
		setFDirCd(JSPUtil.getParameter(request, prefix + "f_dir_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setAmt03(JSPUtil.getParameter(request, prefix + "amt_03", ""));
		setAmt02(JSPUtil.getParameter(request, prefix + "amt_02", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setFixChtFreqNo(JSPUtil.getParameter(request, prefix + "fix_cht_freq_no", ""));
		setAmt01(JSPUtil.getParameter(request, prefix + "amt_01", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setAmt07(JSPUtil.getParameter(request, prefix + "amt_07", ""));
		setAmt06(JSPUtil.getParameter(request, prefix + "amt_06", ""));
		setUcOwnFreqNo(JSPUtil.getParameter(request, prefix + "uc_own_freq_no", ""));
		setAmt05(JSPUtil.getParameter(request, prefix + "amt_05", ""));
		setAmt04(JSPUtil.getParameter(request, prefix + "amt_04", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAmt08(JSPUtil.getParameter(request, prefix + "amt_08", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setAmt09(JSPUtil.getParameter(request, prefix + "amt_09", ""));
		setOpLaneTpCd(JSPUtil.getParameter(request, prefix + "op_lane_tp_cd", ""));
		setCostUseTpCd(JSPUtil.getParameter(request, prefix + "cost_use_tp_cd", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setStndCostCd(JSPUtil.getParameter(request, prefix + "stnd_cost_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setFCostYrmon(JSPUtil.getParameter(request, prefix + "f_cost_yrmon", ""));
		setHulBndCd(JSPUtil.getParameter(request, prefix + "hul_bnd_cd", ""));
		setFixOwnFreqNo(JSPUtil.getParameter(request, prefix + "fix_own_freq_no", ""));
		setAmt10(JSPUtil.getParameter(request, prefix + "amt_10", ""));
		setAmt12(JSPUtil.getParameter(request, prefix + "amt_12", ""));
		setFToYrwk(JSPUtil.getParameter(request, prefix + "f_to_yrwk", ""));
		setAmt11(JSPUtil.getParameter(request, prefix + "amt_11", ""));
		setAmt14(JSPUtil.getParameter(request, prefix + "amt_14", ""));
		setAmt13(JSPUtil.getParameter(request, prefix + "amt_13", ""));
		setUcOthFreqNo(JSPUtil.getParameter(request, prefix + "uc_oth_freq_no", ""));
		setFFmYrwk(JSPUtil.getParameter(request, prefix + "f_fm_yrwk", ""));
		setFTrdCd(JSPUtil.getParameter(request, prefix + "f_trd_cd", ""));
		setHjsBsaCapa(JSPUtil.getParameter(request, prefix + "hjs_bsa_capa", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setFRlaneCd(JSPUtil.getParameter(request, prefix + "f_rlane_cd", ""));
		setVslOshpCd(JSPUtil.getParameter(request, prefix + "vsl_oshp_cd", ""));
		setUcChtFreqNo(JSPUtil.getParameter(request, prefix + "uc_cht_freq_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AverageUCVO[]
	 */
	public AverageUCVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AverageUCVO[]
	 */
	public AverageUCVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AverageUCVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] freqNo = (JSPUtil.getParameter(request, prefix	+ "freq_no", length));
			String[] fixOthFreqNo = (JSPUtil.getParameter(request, prefix	+ "fix_oth_freq_no", length));
			String[] fDirCd = (JSPUtil.getParameter(request, prefix	+ "f_dir_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] amt03 = (JSPUtil.getParameter(request, prefix	+ "amt_03", length));
			String[] amt02 = (JSPUtil.getParameter(request, prefix	+ "amt_02", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] fixChtFreqNo = (JSPUtil.getParameter(request, prefix	+ "fix_cht_freq_no", length));
			String[] amt01 = (JSPUtil.getParameter(request, prefix	+ "amt_01", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] amt07 = (JSPUtil.getParameter(request, prefix	+ "amt_07", length));
			String[] amt06 = (JSPUtil.getParameter(request, prefix	+ "amt_06", length));
			String[] ucOwnFreqNo = (JSPUtil.getParameter(request, prefix	+ "uc_own_freq_no", length));
			String[] amt05 = (JSPUtil.getParameter(request, prefix	+ "amt_05", length));
			String[] amt04 = (JSPUtil.getParameter(request, prefix	+ "amt_04", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] amt08 = (JSPUtil.getParameter(request, prefix	+ "amt_08", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] amt09 = (JSPUtil.getParameter(request, prefix	+ "amt_09", length));
			String[] opLaneTpCd = (JSPUtil.getParameter(request, prefix	+ "op_lane_tp_cd", length));
			String[] costUseTpCd = (JSPUtil.getParameter(request, prefix	+ "cost_use_tp_cd", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] stndCostCd = (JSPUtil.getParameter(request, prefix	+ "stnd_cost_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] fCostYrmon = (JSPUtil.getParameter(request, prefix	+ "f_cost_yrmon", length));
			String[] hulBndCd = (JSPUtil.getParameter(request, prefix	+ "hul_bnd_cd", length));
			String[] fixOwnFreqNo = (JSPUtil.getParameter(request, prefix	+ "fix_own_freq_no", length));
			String[] amt10 = (JSPUtil.getParameter(request, prefix	+ "amt_10", length));
			String[] amt12 = (JSPUtil.getParameter(request, prefix	+ "amt_12", length));
			String[] fToYrwk = (JSPUtil.getParameter(request, prefix	+ "f_to_yrwk", length));
			String[] amt11 = (JSPUtil.getParameter(request, prefix	+ "amt_11", length));
			String[] amt14 = (JSPUtil.getParameter(request, prefix	+ "amt_14", length));
			String[] amt13 = (JSPUtil.getParameter(request, prefix	+ "amt_13", length));
			String[] ucOthFreqNo = (JSPUtil.getParameter(request, prefix	+ "uc_oth_freq_no", length));
			String[] fFmYrwk = (JSPUtil.getParameter(request, prefix	+ "f_fm_yrwk", length));
			String[] fTrdCd = (JSPUtil.getParameter(request, prefix	+ "f_trd_cd", length));
			String[] hjsBsaCapa = (JSPUtil.getParameter(request, prefix	+ "hjs_bsa_capa", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] fRlaneCd = (JSPUtil.getParameter(request, prefix	+ "f_rlane_cd", length));
			String[] vslOshpCd = (JSPUtil.getParameter(request, prefix	+ "vsl_oshp_cd", length));
			String[] ucChtFreqNo = (JSPUtil.getParameter(request, prefix	+ "uc_cht_freq_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new AverageUCVO();
				if (freqNo[i] != null)
					model.setFreqNo(freqNo[i]);
				if (fixOthFreqNo[i] != null)
					model.setFixOthFreqNo(fixOthFreqNo[i]);
				if (fDirCd[i] != null)
					model.setFDirCd(fDirCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (amt03[i] != null)
					model.setAmt03(amt03[i]);
				if (amt02[i] != null)
					model.setAmt02(amt02[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (fixChtFreqNo[i] != null)
					model.setFixChtFreqNo(fixChtFreqNo[i]);
				if (amt01[i] != null)
					model.setAmt01(amt01[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (amt07[i] != null)
					model.setAmt07(amt07[i]);
				if (amt06[i] != null)
					model.setAmt06(amt06[i]);
				if (ucOwnFreqNo[i] != null)
					model.setUcOwnFreqNo(ucOwnFreqNo[i]);
				if (amt05[i] != null)
					model.setAmt05(amt05[i]);
				if (amt04[i] != null)
					model.setAmt04(amt04[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (amt08[i] != null)
					model.setAmt08(amt08[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (amt09[i] != null)
					model.setAmt09(amt09[i]);
				if (opLaneTpCd[i] != null)
					model.setOpLaneTpCd(opLaneTpCd[i]);
				if (costUseTpCd[i] != null)
					model.setCostUseTpCd(costUseTpCd[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (stndCostCd[i] != null)
					model.setStndCostCd(stndCostCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (fCostYrmon[i] != null)
					model.setFCostYrmon(fCostYrmon[i]);
				if (hulBndCd[i] != null)
					model.setHulBndCd(hulBndCd[i]);
				if (fixOwnFreqNo[i] != null)
					model.setFixOwnFreqNo(fixOwnFreqNo[i]);
				if (amt10[i] != null)
					model.setAmt10(amt10[i]);
				if (amt12[i] != null)
					model.setAmt12(amt12[i]);
				if (fToYrwk[i] != null)
					model.setFToYrwk(fToYrwk[i]);
				if (amt11[i] != null)
					model.setAmt11(amt11[i]);
				if (amt14[i] != null)
					model.setAmt14(amt14[i]);
				if (amt13[i] != null)
					model.setAmt13(amt13[i]);
				if (ucOthFreqNo[i] != null)
					model.setUcOthFreqNo(ucOthFreqNo[i]);
				if (fFmYrwk[i] != null)
					model.setFFmYrwk(fFmYrwk[i]);
				if (fTrdCd[i] != null)
					model.setFTrdCd(fTrdCd[i]);
				if (hjsBsaCapa[i] != null)
					model.setHjsBsaCapa(hjsBsaCapa[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (fRlaneCd[i] != null)
					model.setFRlaneCd(fRlaneCd[i]);
				if (vslOshpCd[i] != null)
					model.setVslOshpCd(vslOshpCd[i]);
				if (ucChtFreqNo[i] != null)
					model.setUcChtFreqNo(ucChtFreqNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAverageUCVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AverageUCVO[]
	 */
	public AverageUCVO[] getAverageUCVOs(){
		AverageUCVO[] vos = (AverageUCVO[])models.toArray(new AverageUCVO[models.size()]);
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
		this.freqNo = this.freqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fixOthFreqNo = this.fixOthFreqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDirCd = this.fDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt03 = this.amt03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt02 = this.amt02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fixChtFreqNo = this.fixChtFreqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt01 = this.amt01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt07 = this.amt07 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt06 = this.amt06 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ucOwnFreqNo = this.ucOwnFreqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt05 = this.amt05 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt04 = this.amt04 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt08 = this.amt08 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt09 = this.amt09 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opLaneTpCd = this.opLaneTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costUseTpCd = this.costUseTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndCostCd = this.stndCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCostYrmon = this.fCostYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hulBndCd = this.hulBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fixOwnFreqNo = this.fixOwnFreqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt10 = this.amt10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt12 = this.amt12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fToYrwk = this.fToYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt11 = this.amt11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt14 = this.amt14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt13 = this.amt13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ucOthFreqNo = this.ucOthFreqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFmYrwk = this.fFmYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fTrdCd = this.fTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjsBsaCapa = this.hjsBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRlaneCd = this.fRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslOshpCd = this.vslOshpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ucChtFreqNo = this.ucChtFreqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
