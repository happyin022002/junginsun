/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchMTCostDetailListVO.java
*@FileTitle : SearchMTCostDetailListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.16
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.16  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.stdunitcost.mtcost.vo;

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

public class SearchMTCostDetailListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMTCostDetailListVO> models = new ArrayList<SearchMTCostDetailListVO>();
	
	/* Column Info */
	private String ydCd1 = null;
	/* Column Info */
	private String ydCd2 = null;
	/* Column Info */
	private String ydCd3 = null;
	/* Column Info */
	private String ydCd4 = null;
	/* Column Info */
	private String mtyTrspTtlAmt9 = null;
	/* Column Info */
	private String ydCd5 = null;
	/* Column Info */
	private String lstYdInConti = null;
	/* Column Info */
	private String ttlQty = null;
	/* Column Info */
	private String ydCd6 = null;
	/* Column Info */
	private String ydCd7 = null;
	/* Column Info */
	private String ydCd8 = null;
	/* Column Info */
	private String ydCd9 = null;
	/* Column Info */
	private String ttlCntrRt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mtyTrspTtlAmt1 = null;
	/* Column Info */
	private String mtyTrspTtlAmt2 = null;
	/* Column Info */
	private String mtyTrspTtlAmt3 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mtyTrspTtlAmt4 = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String mtyTrspTtlAmt5 = null;
	/* Column Info */
	private String mtyTrspTtlAmt6 = null;
	/* Column Info */
	private String mtyTrspTtlAmt7 = null;
	/* Column Info */
	private String mtyTrspTtlAmt8 = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String mtyStvgTtlAmt4 = null;
	/* Column Info */
	private String mtyStvgTtlAmt5 = null;
	/* Column Info */
	private String mtyStvgTtlAmt6 = null;
	/* Column Info */
	private String mtyStvgTtlAmt7 = null;
	/* Column Info */
	private String mtyStvgTtlAmt1 = null;
	/* Column Info */
	private String mtyStvgTtlAmt2 = null;
	/* Column Info */
	private String eccCd = null;
	/* Column Info */
	private String mtyStvgTtlAmt3 = null;
	/* Column Info */
	private String ttlCntrQty = null;
	/* Column Info */
	private String mtyTrspTtlAmt10 = null;
	/* Column Info */
	private String mtyStvgTtlAmt8 = null;
	/* Column Info */
	private String mtyStvgTtlAmt10 = null;
	/* Column Info */
	private String mtyStvgTtlAmt9 = null;
	/* Column Info */
	private String lstMvmtInConti = null;
	/* Column Info */
	private String oriDestCd = null;
	/* Column Info */
	private String mtyTtlAmt = null;
	/* Column Info */
	private String ydCd10 = null;
	/* Column Info */
	private String mtyTtlUcAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchMTCostDetailListVO() {}

	public SearchMTCostDetailListVO(String ibflag, String pagerows, String costYrmon, String eccCd, String cntrTpszCd, String oriDestCd, String ttlCntrQty, String ttlQty, String ttlCntrRt, String ydCd1, String ydCd2, String ydCd3, String ydCd4, String ydCd5, String ydCd6, String ydCd7, String ydCd8, String ydCd9, String ydCd10, String lstYdInConti, String lstMvmtInConti, String mtyStvgTtlAmt1, String mtyStvgTtlAmt2, String mtyStvgTtlAmt3, String mtyStvgTtlAmt4, String mtyStvgTtlAmt5, String mtyStvgTtlAmt6, String mtyStvgTtlAmt7, String mtyStvgTtlAmt8, String mtyStvgTtlAmt9, String mtyStvgTtlAmt10, String mtyTrspTtlAmt1, String mtyTrspTtlAmt2, String mtyTrspTtlAmt3, String mtyTrspTtlAmt4, String mtyTrspTtlAmt5, String mtyTrspTtlAmt6, String mtyTrspTtlAmt7, String mtyTrspTtlAmt8, String mtyTrspTtlAmt9, String mtyTrspTtlAmt10, String mtyTtlAmt, String mtyTtlUcAmt) {
		this.ydCd1 = ydCd1;
		this.ydCd2 = ydCd2;
		this.ydCd3 = ydCd3;
		this.ydCd4 = ydCd4;
		this.mtyTrspTtlAmt9 = mtyTrspTtlAmt9;
		this.ydCd5 = ydCd5;
		this.lstYdInConti = lstYdInConti;
		this.ttlQty = ttlQty;
		this.ydCd6 = ydCd6;
		this.ydCd7 = ydCd7;
		this.ydCd8 = ydCd8;
		this.ydCd9 = ydCd9;
		this.ttlCntrRt = ttlCntrRt;
		this.pagerows = pagerows;
		this.mtyTrspTtlAmt1 = mtyTrspTtlAmt1;
		this.mtyTrspTtlAmt2 = mtyTrspTtlAmt2;
		this.mtyTrspTtlAmt3 = mtyTrspTtlAmt3;
		this.ibflag = ibflag;
		this.mtyTrspTtlAmt4 = mtyTrspTtlAmt4;
		this.costYrmon = costYrmon;
		this.mtyTrspTtlAmt5 = mtyTrspTtlAmt5;
		this.mtyTrspTtlAmt6 = mtyTrspTtlAmt6;
		this.mtyTrspTtlAmt7 = mtyTrspTtlAmt7;
		this.mtyTrspTtlAmt8 = mtyTrspTtlAmt8;
		this.cntrTpszCd = cntrTpszCd;
		this.mtyStvgTtlAmt4 = mtyStvgTtlAmt4;
		this.mtyStvgTtlAmt5 = mtyStvgTtlAmt5;
		this.mtyStvgTtlAmt6 = mtyStvgTtlAmt6;
		this.mtyStvgTtlAmt7 = mtyStvgTtlAmt7;
		this.mtyStvgTtlAmt1 = mtyStvgTtlAmt1;
		this.mtyStvgTtlAmt2 = mtyStvgTtlAmt2;
		this.eccCd = eccCd;
		this.mtyStvgTtlAmt3 = mtyStvgTtlAmt3;
		this.ttlCntrQty = ttlCntrQty;
		this.mtyTrspTtlAmt10 = mtyTrspTtlAmt10;
		this.mtyStvgTtlAmt8 = mtyStvgTtlAmt8;
		this.mtyStvgTtlAmt10 = mtyStvgTtlAmt10;
		this.mtyStvgTtlAmt9 = mtyStvgTtlAmt9;
		this.lstMvmtInConti = lstMvmtInConti;
		this.oriDestCd = oriDestCd;
		this.mtyTtlAmt = mtyTtlAmt;
		this.ydCd10 = ydCd10;
		this.mtyTtlUcAmt = mtyTtlUcAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("yd_cd1", getYdCd1());
		this.hashColumns.put("yd_cd2", getYdCd2());
		this.hashColumns.put("yd_cd3", getYdCd3());
		this.hashColumns.put("yd_cd4", getYdCd4());
		this.hashColumns.put("mty_trsp_ttl_amt9", getMtyTrspTtlAmt9());
		this.hashColumns.put("yd_cd5", getYdCd5());
		this.hashColumns.put("lst_yd_in_conti", getLstYdInConti());
		this.hashColumns.put("ttl_qty", getTtlQty());
		this.hashColumns.put("yd_cd6", getYdCd6());
		this.hashColumns.put("yd_cd7", getYdCd7());
		this.hashColumns.put("yd_cd8", getYdCd8());
		this.hashColumns.put("yd_cd9", getYdCd9());
		this.hashColumns.put("ttl_cntr_rt", getTtlCntrRt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mty_trsp_ttl_amt1", getMtyTrspTtlAmt1());
		this.hashColumns.put("mty_trsp_ttl_amt2", getMtyTrspTtlAmt2());
		this.hashColumns.put("mty_trsp_ttl_amt3", getMtyTrspTtlAmt3());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mty_trsp_ttl_amt4", getMtyTrspTtlAmt4());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("mty_trsp_ttl_amt5", getMtyTrspTtlAmt5());
		this.hashColumns.put("mty_trsp_ttl_amt6", getMtyTrspTtlAmt6());
		this.hashColumns.put("mty_trsp_ttl_amt7", getMtyTrspTtlAmt7());
		this.hashColumns.put("mty_trsp_ttl_amt8", getMtyTrspTtlAmt8());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("mty_stvg_ttl_amt4", getMtyStvgTtlAmt4());
		this.hashColumns.put("mty_stvg_ttl_amt5", getMtyStvgTtlAmt5());
		this.hashColumns.put("mty_stvg_ttl_amt6", getMtyStvgTtlAmt6());
		this.hashColumns.put("mty_stvg_ttl_amt7", getMtyStvgTtlAmt7());
		this.hashColumns.put("mty_stvg_ttl_amt1", getMtyStvgTtlAmt1());
		this.hashColumns.put("mty_stvg_ttl_amt2", getMtyStvgTtlAmt2());
		this.hashColumns.put("ecc_cd", getEccCd());
		this.hashColumns.put("mty_stvg_ttl_amt3", getMtyStvgTtlAmt3());
		this.hashColumns.put("ttl_cntr_qty", getTtlCntrQty());
		this.hashColumns.put("mty_trsp_ttl_amt10", getMtyTrspTtlAmt10());
		this.hashColumns.put("mty_stvg_ttl_amt8", getMtyStvgTtlAmt8());
		this.hashColumns.put("mty_stvg_ttl_amt10", getMtyStvgTtlAmt10());
		this.hashColumns.put("mty_stvg_ttl_amt9", getMtyStvgTtlAmt9());
		this.hashColumns.put("lst_mvmt_in_conti", getLstMvmtInConti());
		this.hashColumns.put("ori_dest_cd", getOriDestCd());
		this.hashColumns.put("mty_ttl_amt", getMtyTtlAmt());
		this.hashColumns.put("yd_cd10", getYdCd10());
		this.hashColumns.put("mty_ttl_uc_amt", getMtyTtlUcAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("yd_cd1", "ydCd1");
		this.hashFields.put("yd_cd2", "ydCd2");
		this.hashFields.put("yd_cd3", "ydCd3");
		this.hashFields.put("yd_cd4", "ydCd4");
		this.hashFields.put("mty_trsp_ttl_amt9", "mtyTrspTtlAmt9");
		this.hashFields.put("yd_cd5", "ydCd5");
		this.hashFields.put("lst_yd_in_conti", "lstYdInConti");
		this.hashFields.put("ttl_qty", "ttlQty");
		this.hashFields.put("yd_cd6", "ydCd6");
		this.hashFields.put("yd_cd7", "ydCd7");
		this.hashFields.put("yd_cd8", "ydCd8");
		this.hashFields.put("yd_cd9", "ydCd9");
		this.hashFields.put("ttl_cntr_rt", "ttlCntrRt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mty_trsp_ttl_amt1", "mtyTrspTtlAmt1");
		this.hashFields.put("mty_trsp_ttl_amt2", "mtyTrspTtlAmt2");
		this.hashFields.put("mty_trsp_ttl_amt3", "mtyTrspTtlAmt3");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mty_trsp_ttl_amt4", "mtyTrspTtlAmt4");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("mty_trsp_ttl_amt5", "mtyTrspTtlAmt5");
		this.hashFields.put("mty_trsp_ttl_amt6", "mtyTrspTtlAmt6");
		this.hashFields.put("mty_trsp_ttl_amt7", "mtyTrspTtlAmt7");
		this.hashFields.put("mty_trsp_ttl_amt8", "mtyTrspTtlAmt8");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("mty_stvg_ttl_amt4", "mtyStvgTtlAmt4");
		this.hashFields.put("mty_stvg_ttl_amt5", "mtyStvgTtlAmt5");
		this.hashFields.put("mty_stvg_ttl_amt6", "mtyStvgTtlAmt6");
		this.hashFields.put("mty_stvg_ttl_amt7", "mtyStvgTtlAmt7");
		this.hashFields.put("mty_stvg_ttl_amt1", "mtyStvgTtlAmt1");
		this.hashFields.put("mty_stvg_ttl_amt2", "mtyStvgTtlAmt2");
		this.hashFields.put("ecc_cd", "eccCd");
		this.hashFields.put("mty_stvg_ttl_amt3", "mtyStvgTtlAmt3");
		this.hashFields.put("ttl_cntr_qty", "ttlCntrQty");
		this.hashFields.put("mty_trsp_ttl_amt10", "mtyTrspTtlAmt10");
		this.hashFields.put("mty_stvg_ttl_amt8", "mtyStvgTtlAmt8");
		this.hashFields.put("mty_stvg_ttl_amt10", "mtyStvgTtlAmt10");
		this.hashFields.put("mty_stvg_ttl_amt9", "mtyStvgTtlAmt9");
		this.hashFields.put("lst_mvmt_in_conti", "lstMvmtInConti");
		this.hashFields.put("ori_dest_cd", "oriDestCd");
		this.hashFields.put("mty_ttl_amt", "mtyTtlAmt");
		this.hashFields.put("yd_cd10", "ydCd10");
		this.hashFields.put("mty_ttl_uc_amt", "mtyTtlUcAmt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ydCd1
	 */
	public String getYdCd1() {
		return this.ydCd1;
	}
	
	/**
	 * Column Info
	 * @return ydCd2
	 */
	public String getYdCd2() {
		return this.ydCd2;
	}
	
	/**
	 * Column Info
	 * @return ydCd3
	 */
	public String getYdCd3() {
		return this.ydCd3;
	}
	
	/**
	 * Column Info
	 * @return ydCd4
	 */
	public String getYdCd4() {
		return this.ydCd4;
	}
	
	/**
	 * Column Info
	 * @return mtyTrspTtlAmt9
	 */
	public String getMtyTrspTtlAmt9() {
		return this.mtyTrspTtlAmt9;
	}
	
	/**
	 * Column Info
	 * @return ydCd5
	 */
	public String getYdCd5() {
		return this.ydCd5;
	}
	
	/**
	 * Column Info
	 * @return lstYdInConti
	 */
	public String getLstYdInConti() {
		return this.lstYdInConti;
	}
	
	/**
	 * Column Info
	 * @return ttlQty
	 */
	public String getTtlQty() {
		return this.ttlQty;
	}
	
	/**
	 * Column Info
	 * @return ydCd6
	 */
	public String getYdCd6() {
		return this.ydCd6;
	}
	
	/**
	 * Column Info
	 * @return ydCd7
	 */
	public String getYdCd7() {
		return this.ydCd7;
	}
	
	/**
	 * Column Info
	 * @return ydCd8
	 */
	public String getYdCd8() {
		return this.ydCd8;
	}
	
	/**
	 * Column Info
	 * @return ydCd9
	 */
	public String getYdCd9() {
		return this.ydCd9;
	}
	
	/**
	 * Column Info
	 * @return ttlCntrRt
	 */
	public String getTtlCntrRt() {
		return this.ttlCntrRt;
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
	 * @return mtyTrspTtlAmt1
	 */
	public String getMtyTrspTtlAmt1() {
		return this.mtyTrspTtlAmt1;
	}
	
	/**
	 * Column Info
	 * @return mtyTrspTtlAmt2
	 */
	public String getMtyTrspTtlAmt2() {
		return this.mtyTrspTtlAmt2;
	}
	
	/**
	 * Column Info
	 * @return mtyTrspTtlAmt3
	 */
	public String getMtyTrspTtlAmt3() {
		return this.mtyTrspTtlAmt3;
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
	 * @return mtyTrspTtlAmt4
	 */
	public String getMtyTrspTtlAmt4() {
		return this.mtyTrspTtlAmt4;
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
	 * @return mtyTrspTtlAmt5
	 */
	public String getMtyTrspTtlAmt5() {
		return this.mtyTrspTtlAmt5;
	}
	
	/**
	 * Column Info
	 * @return mtyTrspTtlAmt6
	 */
	public String getMtyTrspTtlAmt6() {
		return this.mtyTrspTtlAmt6;
	}
	
	/**
	 * Column Info
	 * @return mtyTrspTtlAmt7
	 */
	public String getMtyTrspTtlAmt7() {
		return this.mtyTrspTtlAmt7;
	}
	
	/**
	 * Column Info
	 * @return mtyTrspTtlAmt8
	 */
	public String getMtyTrspTtlAmt8() {
		return this.mtyTrspTtlAmt8;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return mtyStvgTtlAmt4
	 */
	public String getMtyStvgTtlAmt4() {
		return this.mtyStvgTtlAmt4;
	}
	
	/**
	 * Column Info
	 * @return mtyStvgTtlAmt5
	 */
	public String getMtyStvgTtlAmt5() {
		return this.mtyStvgTtlAmt5;
	}
	
	/**
	 * Column Info
	 * @return mtyStvgTtlAmt6
	 */
	public String getMtyStvgTtlAmt6() {
		return this.mtyStvgTtlAmt6;
	}
	
	/**
	 * Column Info
	 * @return mtyStvgTtlAmt7
	 */
	public String getMtyStvgTtlAmt7() {
		return this.mtyStvgTtlAmt7;
	}
	
	/**
	 * Column Info
	 * @return mtyStvgTtlAmt1
	 */
	public String getMtyStvgTtlAmt1() {
		return this.mtyStvgTtlAmt1;
	}
	
	/**
	 * Column Info
	 * @return mtyStvgTtlAmt2
	 */
	public String getMtyStvgTtlAmt2() {
		return this.mtyStvgTtlAmt2;
	}
	
	/**
	 * Column Info
	 * @return eccCd
	 */
	public String getEccCd() {
		return this.eccCd;
	}
	
	/**
	 * Column Info
	 * @return mtyStvgTtlAmt3
	 */
	public String getMtyStvgTtlAmt3() {
		return this.mtyStvgTtlAmt3;
	}
	
	/**
	 * Column Info
	 * @return ttlCntrQty
	 */
	public String getTtlCntrQty() {
		return this.ttlCntrQty;
	}
	
	/**
	 * Column Info
	 * @return mtyTrspTtlAmt10
	 */
	public String getMtyTrspTtlAmt10() {
		return this.mtyTrspTtlAmt10;
	}
	
	/**
	 * Column Info
	 * @return mtyStvgTtlAmt8
	 */
	public String getMtyStvgTtlAmt8() {
		return this.mtyStvgTtlAmt8;
	}
	
	/**
	 * Column Info
	 * @return mtyStvgTtlAmt10
	 */
	public String getMtyStvgTtlAmt10() {
		return this.mtyStvgTtlAmt10;
	}
	
	/**
	 * Column Info
	 * @return mtyStvgTtlAmt9
	 */
	public String getMtyStvgTtlAmt9() {
		return this.mtyStvgTtlAmt9;
	}
	
	/**
	 * Column Info
	 * @return lstMvmtInConti
	 */
	public String getLstMvmtInConti() {
		return this.lstMvmtInConti;
	}
	
	/**
	 * Column Info
	 * @return oriDestCd
	 */
	public String getOriDestCd() {
		return this.oriDestCd;
	}
	
	/**
	 * Column Info
	 * @return mtyTtlAmt
	 */
	public String getMtyTtlAmt() {
		return this.mtyTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return ydCd10
	 */
	public String getYdCd10() {
		return this.ydCd10;
	}
	
	/**
	 * Column Info
	 * @return mtyTtlUcAmt
	 */
	public String getMtyTtlUcAmt() {
		return this.mtyTtlUcAmt;
	}
	

	/**
	 * Column Info
	 * @param ydCd1
	 */
	public void setYdCd1(String ydCd1) {
		this.ydCd1 = ydCd1;
	}
	
	/**
	 * Column Info
	 * @param ydCd2
	 */
	public void setYdCd2(String ydCd2) {
		this.ydCd2 = ydCd2;
	}
	
	/**
	 * Column Info
	 * @param ydCd3
	 */
	public void setYdCd3(String ydCd3) {
		this.ydCd3 = ydCd3;
	}
	
	/**
	 * Column Info
	 * @param ydCd4
	 */
	public void setYdCd4(String ydCd4) {
		this.ydCd4 = ydCd4;
	}
	
	/**
	 * Column Info
	 * @param mtyTrspTtlAmt9
	 */
	public void setMtyTrspTtlAmt9(String mtyTrspTtlAmt9) {
		this.mtyTrspTtlAmt9 = mtyTrspTtlAmt9;
	}
	
	/**
	 * Column Info
	 * @param ydCd5
	 */
	public void setYdCd5(String ydCd5) {
		this.ydCd5 = ydCd5;
	}
	
	/**
	 * Column Info
	 * @param lstYdInConti
	 */
	public void setLstYdInConti(String lstYdInConti) {
		this.lstYdInConti = lstYdInConti;
	}
	
	/**
	 * Column Info
	 * @param ttlQty
	 */
	public void setTtlQty(String ttlQty) {
		this.ttlQty = ttlQty;
	}
	
	/**
	 * Column Info
	 * @param ydCd6
	 */
	public void setYdCd6(String ydCd6) {
		this.ydCd6 = ydCd6;
	}
	
	/**
	 * Column Info
	 * @param ydCd7
	 */
	public void setYdCd7(String ydCd7) {
		this.ydCd7 = ydCd7;
	}
	
	/**
	 * Column Info
	 * @param ydCd8
	 */
	public void setYdCd8(String ydCd8) {
		this.ydCd8 = ydCd8;
	}
	
	/**
	 * Column Info
	 * @param ydCd9
	 */
	public void setYdCd9(String ydCd9) {
		this.ydCd9 = ydCd9;
	}
	
	/**
	 * Column Info
	 * @param ttlCntrRt
	 */
	public void setTtlCntrRt(String ttlCntrRt) {
		this.ttlCntrRt = ttlCntrRt;
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
	 * @param mtyTrspTtlAmt1
	 */
	public void setMtyTrspTtlAmt1(String mtyTrspTtlAmt1) {
		this.mtyTrspTtlAmt1 = mtyTrspTtlAmt1;
	}
	
	/**
	 * Column Info
	 * @param mtyTrspTtlAmt2
	 */
	public void setMtyTrspTtlAmt2(String mtyTrspTtlAmt2) {
		this.mtyTrspTtlAmt2 = mtyTrspTtlAmt2;
	}
	
	/**
	 * Column Info
	 * @param mtyTrspTtlAmt3
	 */
	public void setMtyTrspTtlAmt3(String mtyTrspTtlAmt3) {
		this.mtyTrspTtlAmt3 = mtyTrspTtlAmt3;
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
	 * @param mtyTrspTtlAmt4
	 */
	public void setMtyTrspTtlAmt4(String mtyTrspTtlAmt4) {
		this.mtyTrspTtlAmt4 = mtyTrspTtlAmt4;
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
	 * @param mtyTrspTtlAmt5
	 */
	public void setMtyTrspTtlAmt5(String mtyTrspTtlAmt5) {
		this.mtyTrspTtlAmt5 = mtyTrspTtlAmt5;
	}
	
	/**
	 * Column Info
	 * @param mtyTrspTtlAmt6
	 */
	public void setMtyTrspTtlAmt6(String mtyTrspTtlAmt6) {
		this.mtyTrspTtlAmt6 = mtyTrspTtlAmt6;
	}
	
	/**
	 * Column Info
	 * @param mtyTrspTtlAmt7
	 */
	public void setMtyTrspTtlAmt7(String mtyTrspTtlAmt7) {
		this.mtyTrspTtlAmt7 = mtyTrspTtlAmt7;
	}
	
	/**
	 * Column Info
	 * @param mtyTrspTtlAmt8
	 */
	public void setMtyTrspTtlAmt8(String mtyTrspTtlAmt8) {
		this.mtyTrspTtlAmt8 = mtyTrspTtlAmt8;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param mtyStvgTtlAmt4
	 */
	public void setMtyStvgTtlAmt4(String mtyStvgTtlAmt4) {
		this.mtyStvgTtlAmt4 = mtyStvgTtlAmt4;
	}
	
	/**
	 * Column Info
	 * @param mtyStvgTtlAmt5
	 */
	public void setMtyStvgTtlAmt5(String mtyStvgTtlAmt5) {
		this.mtyStvgTtlAmt5 = mtyStvgTtlAmt5;
	}
	
	/**
	 * Column Info
	 * @param mtyStvgTtlAmt6
	 */
	public void setMtyStvgTtlAmt6(String mtyStvgTtlAmt6) {
		this.mtyStvgTtlAmt6 = mtyStvgTtlAmt6;
	}
	
	/**
	 * Column Info
	 * @param mtyStvgTtlAmt7
	 */
	public void setMtyStvgTtlAmt7(String mtyStvgTtlAmt7) {
		this.mtyStvgTtlAmt7 = mtyStvgTtlAmt7;
	}
	
	/**
	 * Column Info
	 * @param mtyStvgTtlAmt1
	 */
	public void setMtyStvgTtlAmt1(String mtyStvgTtlAmt1) {
		this.mtyStvgTtlAmt1 = mtyStvgTtlAmt1;
	}
	
	/**
	 * Column Info
	 * @param mtyStvgTtlAmt2
	 */
	public void setMtyStvgTtlAmt2(String mtyStvgTtlAmt2) {
		this.mtyStvgTtlAmt2 = mtyStvgTtlAmt2;
	}
	
	/**
	 * Column Info
	 * @param eccCd
	 */
	public void setEccCd(String eccCd) {
		this.eccCd = eccCd;
	}
	
	/**
	 * Column Info
	 * @param mtyStvgTtlAmt3
	 */
	public void setMtyStvgTtlAmt3(String mtyStvgTtlAmt3) {
		this.mtyStvgTtlAmt3 = mtyStvgTtlAmt3;
	}
	
	/**
	 * Column Info
	 * @param ttlCntrQty
	 */
	public void setTtlCntrQty(String ttlCntrQty) {
		this.ttlCntrQty = ttlCntrQty;
	}
	
	/**
	 * Column Info
	 * @param mtyTrspTtlAmt10
	 */
	public void setMtyTrspTtlAmt10(String mtyTrspTtlAmt10) {
		this.mtyTrspTtlAmt10 = mtyTrspTtlAmt10;
	}
	
	/**
	 * Column Info
	 * @param mtyStvgTtlAmt8
	 */
	public void setMtyStvgTtlAmt8(String mtyStvgTtlAmt8) {
		this.mtyStvgTtlAmt8 = mtyStvgTtlAmt8;
	}
	
	/**
	 * Column Info
	 * @param mtyStvgTtlAmt10
	 */
	public void setMtyStvgTtlAmt10(String mtyStvgTtlAmt10) {
		this.mtyStvgTtlAmt10 = mtyStvgTtlAmt10;
	}
	
	/**
	 * Column Info
	 * @param mtyStvgTtlAmt9
	 */
	public void setMtyStvgTtlAmt9(String mtyStvgTtlAmt9) {
		this.mtyStvgTtlAmt9 = mtyStvgTtlAmt9;
	}
	
	/**
	 * Column Info
	 * @param lstMvmtInConti
	 */
	public void setLstMvmtInConti(String lstMvmtInConti) {
		this.lstMvmtInConti = lstMvmtInConti;
	}
	
	/**
	 * Column Info
	 * @param oriDestCd
	 */
	public void setOriDestCd(String oriDestCd) {
		this.oriDestCd = oriDestCd;
	}
	
	/**
	 * Column Info
	 * @param mtyTtlAmt
	 */
	public void setMtyTtlAmt(String mtyTtlAmt) {
		this.mtyTtlAmt = mtyTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param ydCd10
	 */
	public void setYdCd10(String ydCd10) {
		this.ydCd10 = ydCd10;
	}
	
	/**
	 * Column Info
	 * @param mtyTtlUcAmt
	 */
	public void setMtyTtlUcAmt(String mtyTtlUcAmt) {
		this.mtyTtlUcAmt = mtyTtlUcAmt;
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
		setYdCd1(JSPUtil.getParameter(request, prefix + "yd_cd1", ""));
		setYdCd2(JSPUtil.getParameter(request, prefix + "yd_cd2", ""));
		setYdCd3(JSPUtil.getParameter(request, prefix + "yd_cd3", ""));
		setYdCd4(JSPUtil.getParameter(request, prefix + "yd_cd4", ""));
		setMtyTrspTtlAmt9(JSPUtil.getParameter(request, prefix + "mty_trsp_ttl_amt9", ""));
		setYdCd5(JSPUtil.getParameter(request, prefix + "yd_cd5", ""));
		setLstYdInConti(JSPUtil.getParameter(request, prefix + "lst_yd_in_conti", ""));
		setTtlQty(JSPUtil.getParameter(request, prefix + "ttl_qty", ""));
		setYdCd6(JSPUtil.getParameter(request, prefix + "yd_cd6", ""));
		setYdCd7(JSPUtil.getParameter(request, prefix + "yd_cd7", ""));
		setYdCd8(JSPUtil.getParameter(request, prefix + "yd_cd8", ""));
		setYdCd9(JSPUtil.getParameter(request, prefix + "yd_cd9", ""));
		setTtlCntrRt(JSPUtil.getParameter(request, prefix + "ttl_cntr_rt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setMtyTrspTtlAmt1(JSPUtil.getParameter(request, prefix + "mty_trsp_ttl_amt1", ""));
		setMtyTrspTtlAmt2(JSPUtil.getParameter(request, prefix + "mty_trsp_ttl_amt2", ""));
		setMtyTrspTtlAmt3(JSPUtil.getParameter(request, prefix + "mty_trsp_ttl_amt3", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMtyTrspTtlAmt4(JSPUtil.getParameter(request, prefix + "mty_trsp_ttl_amt4", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setMtyTrspTtlAmt5(JSPUtil.getParameter(request, prefix + "mty_trsp_ttl_amt5", ""));
		setMtyTrspTtlAmt6(JSPUtil.getParameter(request, prefix + "mty_trsp_ttl_amt6", ""));
		setMtyTrspTtlAmt7(JSPUtil.getParameter(request, prefix + "mty_trsp_ttl_amt7", ""));
		setMtyTrspTtlAmt8(JSPUtil.getParameter(request, prefix + "mty_trsp_ttl_amt8", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setMtyStvgTtlAmt4(JSPUtil.getParameter(request, prefix + "mty_stvg_ttl_amt4", ""));
		setMtyStvgTtlAmt5(JSPUtil.getParameter(request, prefix + "mty_stvg_ttl_amt5", ""));
		setMtyStvgTtlAmt6(JSPUtil.getParameter(request, prefix + "mty_stvg_ttl_amt6", ""));
		setMtyStvgTtlAmt7(JSPUtil.getParameter(request, prefix + "mty_stvg_ttl_amt7", ""));
		setMtyStvgTtlAmt1(JSPUtil.getParameter(request, prefix + "mty_stvg_ttl_amt1", ""));
		setMtyStvgTtlAmt2(JSPUtil.getParameter(request, prefix + "mty_stvg_ttl_amt2", ""));
		setEccCd(JSPUtil.getParameter(request, prefix + "ecc_cd", ""));
		setMtyStvgTtlAmt3(JSPUtil.getParameter(request, prefix + "mty_stvg_ttl_amt3", ""));
		setTtlCntrQty(JSPUtil.getParameter(request, prefix + "ttl_cntr_qty", ""));
		setMtyTrspTtlAmt10(JSPUtil.getParameter(request, prefix + "mty_trsp_ttl_amt10", ""));
		setMtyStvgTtlAmt8(JSPUtil.getParameter(request, prefix + "mty_stvg_ttl_amt8", ""));
		setMtyStvgTtlAmt10(JSPUtil.getParameter(request, prefix + "mty_stvg_ttl_amt10", ""));
		setMtyStvgTtlAmt9(JSPUtil.getParameter(request, prefix + "mty_stvg_ttl_amt9", ""));
		setLstMvmtInConti(JSPUtil.getParameter(request, prefix + "lst_mvmt_in_conti", ""));
		setOriDestCd(JSPUtil.getParameter(request, prefix + "ori_dest_cd", ""));
		setMtyTtlAmt(JSPUtil.getParameter(request, prefix + "mty_ttl_amt", ""));
		setYdCd10(JSPUtil.getParameter(request, prefix + "yd_cd10", ""));
		setMtyTtlUcAmt(JSPUtil.getParameter(request, prefix + "mty_ttl_uc_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMTCostDetailListVO[]
	 */
	public SearchMTCostDetailListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMTCostDetailListVO[]
	 */
	public SearchMTCostDetailListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMTCostDetailListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ydCd1 = (JSPUtil.getParameter(request, prefix	+ "yd_cd1", length));
			String[] ydCd2 = (JSPUtil.getParameter(request, prefix	+ "yd_cd2", length));
			String[] ydCd3 = (JSPUtil.getParameter(request, prefix	+ "yd_cd3", length));
			String[] ydCd4 = (JSPUtil.getParameter(request, prefix	+ "yd_cd4", length));
			String[] mtyTrspTtlAmt9 = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_ttl_amt9", length));
			String[] ydCd5 = (JSPUtil.getParameter(request, prefix	+ "yd_cd5", length));
			String[] lstYdInConti = (JSPUtil.getParameter(request, prefix	+ "lst_yd_in_conti", length));
			String[] ttlQty = (JSPUtil.getParameter(request, prefix	+ "ttl_qty", length));
			String[] ydCd6 = (JSPUtil.getParameter(request, prefix	+ "yd_cd6", length));
			String[] ydCd7 = (JSPUtil.getParameter(request, prefix	+ "yd_cd7", length));
			String[] ydCd8 = (JSPUtil.getParameter(request, prefix	+ "yd_cd8", length));
			String[] ydCd9 = (JSPUtil.getParameter(request, prefix	+ "yd_cd9", length));
			String[] ttlCntrRt = (JSPUtil.getParameter(request, prefix	+ "ttl_cntr_rt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mtyTrspTtlAmt1 = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_ttl_amt1", length));
			String[] mtyTrspTtlAmt2 = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_ttl_amt2", length));
			String[] mtyTrspTtlAmt3 = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_ttl_amt3", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mtyTrspTtlAmt4 = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_ttl_amt4", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] mtyTrspTtlAmt5 = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_ttl_amt5", length));
			String[] mtyTrspTtlAmt6 = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_ttl_amt6", length));
			String[] mtyTrspTtlAmt7 = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_ttl_amt7", length));
			String[] mtyTrspTtlAmt8 = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_ttl_amt8", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] mtyStvgTtlAmt4 = (JSPUtil.getParameter(request, prefix	+ "mty_stvg_ttl_amt4", length));
			String[] mtyStvgTtlAmt5 = (JSPUtil.getParameter(request, prefix	+ "mty_stvg_ttl_amt5", length));
			String[] mtyStvgTtlAmt6 = (JSPUtil.getParameter(request, prefix	+ "mty_stvg_ttl_amt6", length));
			String[] mtyStvgTtlAmt7 = (JSPUtil.getParameter(request, prefix	+ "mty_stvg_ttl_amt7", length));
			String[] mtyStvgTtlAmt1 = (JSPUtil.getParameter(request, prefix	+ "mty_stvg_ttl_amt1", length));
			String[] mtyStvgTtlAmt2 = (JSPUtil.getParameter(request, prefix	+ "mty_stvg_ttl_amt2", length));
			String[] eccCd = (JSPUtil.getParameter(request, prefix	+ "ecc_cd", length));
			String[] mtyStvgTtlAmt3 = (JSPUtil.getParameter(request, prefix	+ "mty_stvg_ttl_amt3", length));
			String[] ttlCntrQty = (JSPUtil.getParameter(request, prefix	+ "ttl_cntr_qty", length));
			String[] mtyTrspTtlAmt10 = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_ttl_amt10", length));
			String[] mtyStvgTtlAmt8 = (JSPUtil.getParameter(request, prefix	+ "mty_stvg_ttl_amt8", length));
			String[] mtyStvgTtlAmt10 = (JSPUtil.getParameter(request, prefix	+ "mty_stvg_ttl_amt10", length));
			String[] mtyStvgTtlAmt9 = (JSPUtil.getParameter(request, prefix	+ "mty_stvg_ttl_amt9", length));
			String[] lstMvmtInConti = (JSPUtil.getParameter(request, prefix	+ "lst_mvmt_in_conti", length));
			String[] oriDestCd = (JSPUtil.getParameter(request, prefix	+ "ori_dest_cd", length));
			String[] mtyTtlAmt = (JSPUtil.getParameter(request, prefix	+ "mty_ttl_amt", length));
			String[] ydCd10 = (JSPUtil.getParameter(request, prefix	+ "yd_cd10", length));
			String[] mtyTtlUcAmt = (JSPUtil.getParameter(request, prefix	+ "mty_ttl_uc_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMTCostDetailListVO();
				if (ydCd1[i] != null)
					model.setYdCd1(ydCd1[i]);
				if (ydCd2[i] != null)
					model.setYdCd2(ydCd2[i]);
				if (ydCd3[i] != null)
					model.setYdCd3(ydCd3[i]);
				if (ydCd4[i] != null)
					model.setYdCd4(ydCd4[i]);
				if (mtyTrspTtlAmt9[i] != null)
					model.setMtyTrspTtlAmt9(mtyTrspTtlAmt9[i]);
				if (ydCd5[i] != null)
					model.setYdCd5(ydCd5[i]);
				if (lstYdInConti[i] != null)
					model.setLstYdInConti(lstYdInConti[i]);
				if (ttlQty[i] != null)
					model.setTtlQty(ttlQty[i]);
				if (ydCd6[i] != null)
					model.setYdCd6(ydCd6[i]);
				if (ydCd7[i] != null)
					model.setYdCd7(ydCd7[i]);
				if (ydCd8[i] != null)
					model.setYdCd8(ydCd8[i]);
				if (ydCd9[i] != null)
					model.setYdCd9(ydCd9[i]);
				if (ttlCntrRt[i] != null)
					model.setTtlCntrRt(ttlCntrRt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mtyTrspTtlAmt1[i] != null)
					model.setMtyTrspTtlAmt1(mtyTrspTtlAmt1[i]);
				if (mtyTrspTtlAmt2[i] != null)
					model.setMtyTrspTtlAmt2(mtyTrspTtlAmt2[i]);
				if (mtyTrspTtlAmt3[i] != null)
					model.setMtyTrspTtlAmt3(mtyTrspTtlAmt3[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mtyTrspTtlAmt4[i] != null)
					model.setMtyTrspTtlAmt4(mtyTrspTtlAmt4[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (mtyTrspTtlAmt5[i] != null)
					model.setMtyTrspTtlAmt5(mtyTrspTtlAmt5[i]);
				if (mtyTrspTtlAmt6[i] != null)
					model.setMtyTrspTtlAmt6(mtyTrspTtlAmt6[i]);
				if (mtyTrspTtlAmt7[i] != null)
					model.setMtyTrspTtlAmt7(mtyTrspTtlAmt7[i]);
				if (mtyTrspTtlAmt8[i] != null)
					model.setMtyTrspTtlAmt8(mtyTrspTtlAmt8[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (mtyStvgTtlAmt4[i] != null)
					model.setMtyStvgTtlAmt4(mtyStvgTtlAmt4[i]);
				if (mtyStvgTtlAmt5[i] != null)
					model.setMtyStvgTtlAmt5(mtyStvgTtlAmt5[i]);
				if (mtyStvgTtlAmt6[i] != null)
					model.setMtyStvgTtlAmt6(mtyStvgTtlAmt6[i]);
				if (mtyStvgTtlAmt7[i] != null)
					model.setMtyStvgTtlAmt7(mtyStvgTtlAmt7[i]);
				if (mtyStvgTtlAmt1[i] != null)
					model.setMtyStvgTtlAmt1(mtyStvgTtlAmt1[i]);
				if (mtyStvgTtlAmt2[i] != null)
					model.setMtyStvgTtlAmt2(mtyStvgTtlAmt2[i]);
				if (eccCd[i] != null)
					model.setEccCd(eccCd[i]);
				if (mtyStvgTtlAmt3[i] != null)
					model.setMtyStvgTtlAmt3(mtyStvgTtlAmt3[i]);
				if (ttlCntrQty[i] != null)
					model.setTtlCntrQty(ttlCntrQty[i]);
				if (mtyTrspTtlAmt10[i] != null)
					model.setMtyTrspTtlAmt10(mtyTrspTtlAmt10[i]);
				if (mtyStvgTtlAmt8[i] != null)
					model.setMtyStvgTtlAmt8(mtyStvgTtlAmt8[i]);
				if (mtyStvgTtlAmt10[i] != null)
					model.setMtyStvgTtlAmt10(mtyStvgTtlAmt10[i]);
				if (mtyStvgTtlAmt9[i] != null)
					model.setMtyStvgTtlAmt9(mtyStvgTtlAmt9[i]);
				if (lstMvmtInConti[i] != null)
					model.setLstMvmtInConti(lstMvmtInConti[i]);
				if (oriDestCd[i] != null)
					model.setOriDestCd(oriDestCd[i]);
				if (mtyTtlAmt[i] != null)
					model.setMtyTtlAmt(mtyTtlAmt[i]);
				if (ydCd10[i] != null)
					model.setYdCd10(ydCd10[i]);
				if (mtyTtlUcAmt[i] != null)
					model.setMtyTtlUcAmt(mtyTtlUcAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMTCostDetailListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMTCostDetailListVO[]
	 */
	public SearchMTCostDetailListVO[] getSearchMTCostDetailListVOs(){
		SearchMTCostDetailListVO[] vos = (SearchMTCostDetailListVO[])models.toArray(new SearchMTCostDetailListVO[models.size()]);
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
		this.ydCd1 = this.ydCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd2 = this.ydCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd3 = this.ydCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd4 = this.ydCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrspTtlAmt9 = this.mtyTrspTtlAmt9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd5 = this.ydCd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstYdInConti = this.lstYdInConti .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlQty = this.ttlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd6 = this.ydCd6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd7 = this.ydCd7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd8 = this.ydCd8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd9 = this.ydCd9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlCntrRt = this.ttlCntrRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrspTtlAmt1 = this.mtyTrspTtlAmt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrspTtlAmt2 = this.mtyTrspTtlAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrspTtlAmt3 = this.mtyTrspTtlAmt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrspTtlAmt4 = this.mtyTrspTtlAmt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrspTtlAmt5 = this.mtyTrspTtlAmt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrspTtlAmt6 = this.mtyTrspTtlAmt6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrspTtlAmt7 = this.mtyTrspTtlAmt7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrspTtlAmt8 = this.mtyTrspTtlAmt8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyStvgTtlAmt4 = this.mtyStvgTtlAmt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyStvgTtlAmt5 = this.mtyStvgTtlAmt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyStvgTtlAmt6 = this.mtyStvgTtlAmt6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyStvgTtlAmt7 = this.mtyStvgTtlAmt7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyStvgTtlAmt1 = this.mtyStvgTtlAmt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyStvgTtlAmt2 = this.mtyStvgTtlAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eccCd = this.eccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyStvgTtlAmt3 = this.mtyStvgTtlAmt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlCntrQty = this.ttlCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrspTtlAmt10 = this.mtyTrspTtlAmt10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyStvgTtlAmt8 = this.mtyStvgTtlAmt8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyStvgTtlAmt10 = this.mtyStvgTtlAmt10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyStvgTtlAmt9 = this.mtyStvgTtlAmt9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstMvmtInConti = this.lstMvmtInConti .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriDestCd = this.oriDestCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTtlAmt = this.mtyTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd10 = this.ydCd10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTtlUcAmt = this.mtyTtlUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
