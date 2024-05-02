/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MasEMUCreditListVO.java
*@FileTitle : MasEMUCreditListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.19
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2014.09.19 최성민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo;

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

public class MasEMUCreditListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MasEMUCreditListVO> models = new ArrayList<MasEMUCreditListVO>();
	
	/* Column Info */
	private String tpszR2 = null;
	/* Column Info */
	private String tpszF2Rto = null;
	/* Column Info */
	private String tpszR5 = null;
	/* Column Info */
	private String tpszR9 = null;
	/* Column Info */
	private String tpszR2Rto = null;
	/* Column Info */
	private String tpszF4Rto = null;
	/* Column Info */
	private String tpszD4Amt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String tpszR9Amt = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String tpszD5Amt = null;
	/* Column Info */
	private String tpszF5Rto = null;
	/* Column Info */
	private String tpszD7Rto = null;
	/* Column Info */
	private String tpszF2 = null;
	/* Column Info */
	private String ruleCd = null;
	/* Column Info */
	private String tpszF2Amt = null;
	/* Column Info */
	private String tpszF5Amt = null;
	/* Column Info */
	private String tpszD3Rto = null;
	/* Column Info */
	private String tpszO5 = null;
	/* Column Info */
	private String tpszD7Amt = null;
	/* Column Info */
	private String tpszO4 = null;
	/* Column Info */
	private String tpszR5Amt = null;
	/* Column Info */
	private String tpszO5Amt = null;
	/* Column Info */
	private String tpszD5Rto = null;
	/* Column Info */
	private String tpszF5 = null;
	/* Column Info */
	private String tpszO2 = null;
	/* Column Info */
	private String tpszF4 = null;
	/* Column Info */
	private String tpszO2Rto = null;
	/* Column Info */
	private String tpszR5Rto = null;
	/* Column Info */
	private String tpszR9Rto = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntNm = null;
	/* Column Info */
	private String tpszR2Amt = null;
	/* Column Info */
	private String eccCd = null;
	/* Column Info */
	private String tpszO4Rto = null;
	/* Column Info */
	private String tpszD4Rto = null;
	/* Column Info */
	private String rccCd = null;
	/* Column Info */
	private String tpszO5Rto = null;
	/* Column Info */
	private String lccCd = null;
	/* Column Info */
	private String tpszD2Amt = null;
	/* Column Info */
	private String tpszO2Amt = null;
	/* Column Info */
	private String tpszF4Amt = null;
	/* Column Info */
	private String contiNm = null;
	/* Column Info */
	private String tpszD3 = null;
	/* Column Info */
	private String tpszD4 = null;
	/* Column Info */
	private String tpszD2 = null;
	/* Column Info */
	private String tpszO4Amt = null;
	/* Column Info */
	private String tpszD2Rto = null;
	/* Column Info */
	private String tpszD7 = null;
	/* Column Info */
	private String tpszD5 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public MasEMUCreditListVO() {}

	public MasEMUCreditListVO(String ibflag, String pagerows, String costYrmon, String contiNm, String cntNm, String eccCd, String rccCd, String lccCd, String ruleCd, String tpszD2, String tpszD3, String tpszD4, String tpszD5, String tpszD7, String tpszR2, String tpszR5, String tpszR9, String tpszF2, String tpszF4, String tpszF5, String tpszO2, String tpszO4, String tpszO5, String tpszD2Rto, String tpszD3Rto, String tpszD4Rto, String tpszD5Rto, String tpszD7Rto, String tpszR2Rto, String tpszR5Rto, String tpszR9Rto, String tpszF2Rto, String tpszF4Rto, String tpszF5Rto, String tpszO2Rto, String tpszO4Rto, String tpszO5Rto, String tpszD2Amt, String tpszD4Amt, String tpszD5Amt, String tpszD7Amt, String tpszR2Amt, String tpszR5Amt, String tpszR9Amt, String tpszF2Amt, String tpszF4Amt, String tpszF5Amt, String tpszO2Amt, String tpszO4Amt, String tpszO5Amt) {
		this.tpszR2 = tpszR2;
		this.tpszF2Rto = tpszF2Rto;
		this.tpszR5 = tpszR5;
		this.tpszR9 = tpszR9;
		this.tpszR2Rto = tpszR2Rto;
		this.tpszF4Rto = tpszF4Rto;
		this.tpszD4Amt = tpszD4Amt;
		this.pagerows = pagerows;
		this.tpszR9Amt = tpszR9Amt;
		this.costYrmon = costYrmon;
		this.tpszD5Amt = tpszD5Amt;
		this.tpszF5Rto = tpszF5Rto;
		this.tpszD7Rto = tpszD7Rto;
		this.tpszF2 = tpszF2;
		this.ruleCd = ruleCd;
		this.tpszF2Amt = tpszF2Amt;
		this.tpszF5Amt = tpszF5Amt;
		this.tpszD3Rto = tpszD3Rto;
		this.tpszO5 = tpszO5;
		this.tpszD7Amt = tpszD7Amt;
		this.tpszO4 = tpszO4;
		this.tpszR5Amt = tpszR5Amt;
		this.tpszO5Amt = tpszO5Amt;
		this.tpszD5Rto = tpszD5Rto;
		this.tpszF5 = tpszF5;
		this.tpszO2 = tpszO2;
		this.tpszF4 = tpszF4;
		this.tpszO2Rto = tpszO2Rto;
		this.tpszR5Rto = tpszR5Rto;
		this.tpszR9Rto = tpszR9Rto;
		this.ibflag = ibflag;
		this.cntNm = cntNm;
		this.tpszR2Amt = tpszR2Amt;
		this.eccCd = eccCd;
		this.tpszO4Rto = tpszO4Rto;
		this.tpszD4Rto = tpszD4Rto;
		this.rccCd = rccCd;
		this.tpszO5Rto = tpszO5Rto;
		this.lccCd = lccCd;
		this.tpszD2Amt = tpszD2Amt;
		this.tpszO2Amt = tpszO2Amt;
		this.tpszF4Amt = tpszF4Amt;
		this.contiNm = contiNm;
		this.tpszD3 = tpszD3;
		this.tpszD4 = tpszD4;
		this.tpszD2 = tpszD2;
		this.tpszO4Amt = tpszO4Amt;
		this.tpszD2Rto = tpszD2Rto;
		this.tpszD7 = tpszD7;
		this.tpszD5 = tpszD5;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tpsz_r2", getTpszR2());
		this.hashColumns.put("tpsz_f2_rto", getTpszF2Rto());
		this.hashColumns.put("tpsz_r5", getTpszR5());
		this.hashColumns.put("tpsz_r9", getTpszR9());
		this.hashColumns.put("tpsz_r2_rto", getTpszR2Rto());
		this.hashColumns.put("tpsz_f4_rto", getTpszF4Rto());
		this.hashColumns.put("tpsz_d4_amt", getTpszD4Amt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("tpsz_r9_amt", getTpszR9Amt());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("tpsz_d5_amt", getTpszD5Amt());
		this.hashColumns.put("tpsz_f5_rto", getTpszF5Rto());
		this.hashColumns.put("tpsz_d7_rto", getTpszD7Rto());
		this.hashColumns.put("tpsz_f2", getTpszF2());
		this.hashColumns.put("rule_cd", getRuleCd());
		this.hashColumns.put("tpsz_f2_amt", getTpszF2Amt());
		this.hashColumns.put("tpsz_f5_amt", getTpszF5Amt());
		this.hashColumns.put("tpsz_d3_rto", getTpszD3Rto());
		this.hashColumns.put("tpsz_o5", getTpszO5());
		this.hashColumns.put("tpsz_d7_amt", getTpszD7Amt());
		this.hashColumns.put("tpsz_o4", getTpszO4());
		this.hashColumns.put("tpsz_r5_amt", getTpszR5Amt());
		this.hashColumns.put("tpsz_o5_amt", getTpszO5Amt());
		this.hashColumns.put("tpsz_d5_rto", getTpszD5Rto());
		this.hashColumns.put("tpsz_f5", getTpszF5());
		this.hashColumns.put("tpsz_o2", getTpszO2());
		this.hashColumns.put("tpsz_f4", getTpszF4());
		this.hashColumns.put("tpsz_o2_rto", getTpszO2Rto());
		this.hashColumns.put("tpsz_r5_rto", getTpszR5Rto());
		this.hashColumns.put("tpsz_r9_rto", getTpszR9Rto());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnt_nm", getCntNm());
		this.hashColumns.put("tpsz_r2_amt", getTpszR2Amt());
		this.hashColumns.put("ecc_cd", getEccCd());
		this.hashColumns.put("tpsz_o4_rto", getTpszO4Rto());
		this.hashColumns.put("tpsz_d4_rto", getTpszD4Rto());
		this.hashColumns.put("rcc_cd", getRccCd());
		this.hashColumns.put("tpsz_o5_rto", getTpszO5Rto());
		this.hashColumns.put("lcc_cd", getLccCd());
		this.hashColumns.put("tpsz_d2_amt", getTpszD2Amt());
		this.hashColumns.put("tpsz_o2_amt", getTpszO2Amt());
		this.hashColumns.put("tpsz_f4_amt", getTpszF4Amt());
		this.hashColumns.put("conti_nm", getContiNm());
		this.hashColumns.put("tpsz_d3", getTpszD3());
		this.hashColumns.put("tpsz_d4", getTpszD4());
		this.hashColumns.put("tpsz_d2", getTpszD2());
		this.hashColumns.put("tpsz_o4_amt", getTpszO4Amt());
		this.hashColumns.put("tpsz_d2_rto", getTpszD2Rto());
		this.hashColumns.put("tpsz_d7", getTpszD7());
		this.hashColumns.put("tpsz_d5", getTpszD5());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tpsz_r2", "tpszR2");
		this.hashFields.put("tpsz_f2_rto", "tpszF2Rto");
		this.hashFields.put("tpsz_r5", "tpszR5");
		this.hashFields.put("tpsz_r9", "tpszR9");
		this.hashFields.put("tpsz_r2_rto", "tpszR2Rto");
		this.hashFields.put("tpsz_f4_rto", "tpszF4Rto");
		this.hashFields.put("tpsz_d4_amt", "tpszD4Amt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("tpsz_r9_amt", "tpszR9Amt");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("tpsz_d5_amt", "tpszD5Amt");
		this.hashFields.put("tpsz_f5_rto", "tpszF5Rto");
		this.hashFields.put("tpsz_d7_rto", "tpszD7Rto");
		this.hashFields.put("tpsz_f2", "tpszF2");
		this.hashFields.put("rule_cd", "ruleCd");
		this.hashFields.put("tpsz_f2_amt", "tpszF2Amt");
		this.hashFields.put("tpsz_f5_amt", "tpszF5Amt");
		this.hashFields.put("tpsz_d3_rto", "tpszD3Rto");
		this.hashFields.put("tpsz_o5", "tpszO5");
		this.hashFields.put("tpsz_d7_amt", "tpszD7Amt");
		this.hashFields.put("tpsz_o4", "tpszO4");
		this.hashFields.put("tpsz_r5_amt", "tpszR5Amt");
		this.hashFields.put("tpsz_o5_amt", "tpszO5Amt");
		this.hashFields.put("tpsz_d5_rto", "tpszD5Rto");
		this.hashFields.put("tpsz_f5", "tpszF5");
		this.hashFields.put("tpsz_o2", "tpszO2");
		this.hashFields.put("tpsz_f4", "tpszF4");
		this.hashFields.put("tpsz_o2_rto", "tpszO2Rto");
		this.hashFields.put("tpsz_r5_rto", "tpszR5Rto");
		this.hashFields.put("tpsz_r9_rto", "tpszR9Rto");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnt_nm", "cntNm");
		this.hashFields.put("tpsz_r2_amt", "tpszR2Amt");
		this.hashFields.put("ecc_cd", "eccCd");
		this.hashFields.put("tpsz_o4_rto", "tpszO4Rto");
		this.hashFields.put("tpsz_d4_rto", "tpszD4Rto");
		this.hashFields.put("rcc_cd", "rccCd");
		this.hashFields.put("tpsz_o5_rto", "tpszO5Rto");
		this.hashFields.put("lcc_cd", "lccCd");
		this.hashFields.put("tpsz_d2_amt", "tpszD2Amt");
		this.hashFields.put("tpsz_o2_amt", "tpszO2Amt");
		this.hashFields.put("tpsz_f4_amt", "tpszF4Amt");
		this.hashFields.put("conti_nm", "contiNm");
		this.hashFields.put("tpsz_d3", "tpszD3");
		this.hashFields.put("tpsz_d4", "tpszD4");
		this.hashFields.put("tpsz_d2", "tpszD2");
		this.hashFields.put("tpsz_o4_amt", "tpszO4Amt");
		this.hashFields.put("tpsz_d2_rto", "tpszD2Rto");
		this.hashFields.put("tpsz_d7", "tpszD7");
		this.hashFields.put("tpsz_d5", "tpszD5");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return tpszR2
	 */
	public String getTpszR2() {
		return this.tpszR2;
	}
	
	/**
	 * Column Info
	 * @return tpszF2Rto
	 */
	public String getTpszF2Rto() {
		return this.tpszF2Rto;
	}
	
	/**
	 * Column Info
	 * @return tpszR5
	 */
	public String getTpszR5() {
		return this.tpszR5;
	}
	
	/**
	 * Column Info
	 * @return tpszR9
	 */
	public String getTpszR9() {
		return this.tpszR9;
	}
	
	/**
	 * Column Info
	 * @return tpszR2Rto
	 */
	public String getTpszR2Rto() {
		return this.tpszR2Rto;
	}
	
	/**
	 * Column Info
	 * @return tpszF4Rto
	 */
	public String getTpszF4Rto() {
		return this.tpszF4Rto;
	}
	
	/**
	 * Column Info
	 * @return tpszD4Amt
	 */
	public String getTpszD4Amt() {
		return this.tpszD4Amt;
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
	 * @return tpszR9Amt
	 */
	public String getTpszR9Amt() {
		return this.tpszR9Amt;
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
	 * @return tpszD5Amt
	 */
	public String getTpszD5Amt() {
		return this.tpszD5Amt;
	}
	
	/**
	 * Column Info
	 * @return tpszF5Rto
	 */
	public String getTpszF5Rto() {
		return this.tpszF5Rto;
	}
	
	/**
	 * Column Info
	 * @return tpszD7Rto
	 */
	public String getTpszD7Rto() {
		return this.tpszD7Rto;
	}
	
	/**
	 * Column Info
	 * @return tpszF2
	 */
	public String getTpszF2() {
		return this.tpszF2;
	}
	
	/**
	 * Column Info
	 * @return ruleCd
	 */
	public String getRuleCd() {
		return this.ruleCd;
	}
	
	/**
	 * Column Info
	 * @return tpszF2Amt
	 */
	public String getTpszF2Amt() {
		return this.tpszF2Amt;
	}
	
	/**
	 * Column Info
	 * @return tpszF5Amt
	 */
	public String getTpszF5Amt() {
		return this.tpszF5Amt;
	}
	
	/**
	 * Column Info
	 * @return tpszD3Rto
	 */
	public String getTpszD3Rto() {
		return this.tpszD3Rto;
	}
	
	/**
	 * Column Info
	 * @return tpszO5
	 */
	public String getTpszO5() {
		return this.tpszO5;
	}
	
	/**
	 * Column Info
	 * @return tpszD7Amt
	 */
	public String getTpszD7Amt() {
		return this.tpszD7Amt;
	}
	
	/**
	 * Column Info
	 * @return tpszO4
	 */
	public String getTpszO4() {
		return this.tpszO4;
	}
	
	/**
	 * Column Info
	 * @return tpszR5Amt
	 */
	public String getTpszR5Amt() {
		return this.tpszR5Amt;
	}
	
	/**
	 * Column Info
	 * @return tpszO5Amt
	 */
	public String getTpszO5Amt() {
		return this.tpszO5Amt;
	}
	
	/**
	 * Column Info
	 * @return tpszD5Rto
	 */
	public String getTpszD5Rto() {
		return this.tpszD5Rto;
	}
	
	/**
	 * Column Info
	 * @return tpszF5
	 */
	public String getTpszF5() {
		return this.tpszF5;
	}
	
	/**
	 * Column Info
	 * @return tpszO2
	 */
	public String getTpszO2() {
		return this.tpszO2;
	}
	
	/**
	 * Column Info
	 * @return tpszF4
	 */
	public String getTpszF4() {
		return this.tpszF4;
	}
	
	/**
	 * Column Info
	 * @return tpszO2Rto
	 */
	public String getTpszO2Rto() {
		return this.tpszO2Rto;
	}
	
	/**
	 * Column Info
	 * @return tpszR5Rto
	 */
	public String getTpszR5Rto() {
		return this.tpszR5Rto;
	}
	
	/**
	 * Column Info
	 * @return tpszR9Rto
	 */
	public String getTpszR9Rto() {
		return this.tpszR9Rto;
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
	 * @return cntNm
	 */
	public String getCntNm() {
		return this.cntNm;
	}
	
	/**
	 * Column Info
	 * @return tpszR2Amt
	 */
	public String getTpszR2Amt() {
		return this.tpszR2Amt;
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
	 * @return tpszO4Rto
	 */
	public String getTpszO4Rto() {
		return this.tpszO4Rto;
	}
	
	/**
	 * Column Info
	 * @return tpszD4Rto
	 */
	public String getTpszD4Rto() {
		return this.tpszD4Rto;
	}
	
	/**
	 * Column Info
	 * @return rccCd
	 */
	public String getRccCd() {
		return this.rccCd;
	}
	
	/**
	 * Column Info
	 * @return tpszO5Rto
	 */
	public String getTpszO5Rto() {
		return this.tpszO5Rto;
	}
	
	/**
	 * Column Info
	 * @return lccCd
	 */
	public String getLccCd() {
		return this.lccCd;
	}
	
	/**
	 * Column Info
	 * @return tpszD2Amt
	 */
	public String getTpszD2Amt() {
		return this.tpszD2Amt;
	}
	
	/**
	 * Column Info
	 * @return tpszO2Amt
	 */
	public String getTpszO2Amt() {
		return this.tpszO2Amt;
	}
	
	/**
	 * Column Info
	 * @return tpszF4Amt
	 */
	public String getTpszF4Amt() {
		return this.tpszF4Amt;
	}
	
	/**
	 * Column Info
	 * @return contiNm
	 */
	public String getContiNm() {
		return this.contiNm;
	}
	
	/**
	 * Column Info
	 * @return tpszD3
	 */
	public String getTpszD3() {
		return this.tpszD3;
	}
	
	/**
	 * Column Info
	 * @return tpszD4
	 */
	public String getTpszD4() {
		return this.tpszD4;
	}
	
	/**
	 * Column Info
	 * @return tpszD2
	 */
	public String getTpszD2() {
		return this.tpszD2;
	}
	
	/**
	 * Column Info
	 * @return tpszO4Amt
	 */
	public String getTpszO4Amt() {
		return this.tpszO4Amt;
	}
	
	/**
	 * Column Info
	 * @return tpszD2Rto
	 */
	public String getTpszD2Rto() {
		return this.tpszD2Rto;
	}
	
	/**
	 * Column Info
	 * @return tpszD7
	 */
	public String getTpszD7() {
		return this.tpszD7;
	}
	
	/**
	 * Column Info
	 * @return tpszD5
	 */
	public String getTpszD5() {
		return this.tpszD5;
	}
	

	/**
	 * Column Info
	 * @param tpszR2
	 */
	public void setTpszR2(String tpszR2) {
		this.tpszR2 = tpszR2;
	}
	
	/**
	 * Column Info
	 * @param tpszF2Rto
	 */
	public void setTpszF2Rto(String tpszF2Rto) {
		this.tpszF2Rto = tpszF2Rto;
	}
	
	/**
	 * Column Info
	 * @param tpszR5
	 */
	public void setTpszR5(String tpszR5) {
		this.tpszR5 = tpszR5;
	}
	
	/**
	 * Column Info
	 * @param tpszR9
	 */
	public void setTpszR9(String tpszR9) {
		this.tpszR9 = tpszR9;
	}
	
	/**
	 * Column Info
	 * @param tpszR2Rto
	 */
	public void setTpszR2Rto(String tpszR2Rto) {
		this.tpszR2Rto = tpszR2Rto;
	}
	
	/**
	 * Column Info
	 * @param tpszF4Rto
	 */
	public void setTpszF4Rto(String tpszF4Rto) {
		this.tpszF4Rto = tpszF4Rto;
	}
	
	/**
	 * Column Info
	 * @param tpszD4Amt
	 */
	public void setTpszD4Amt(String tpszD4Amt) {
		this.tpszD4Amt = tpszD4Amt;
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
	 * @param tpszR9Amt
	 */
	public void setTpszR9Amt(String tpszR9Amt) {
		this.tpszR9Amt = tpszR9Amt;
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
	 * @param tpszD5Amt
	 */
	public void setTpszD5Amt(String tpszD5Amt) {
		this.tpszD5Amt = tpszD5Amt;
	}
	
	/**
	 * Column Info
	 * @param tpszF5Rto
	 */
	public void setTpszF5Rto(String tpszF5Rto) {
		this.tpszF5Rto = tpszF5Rto;
	}
	
	/**
	 * Column Info
	 * @param tpszD7Rto
	 */
	public void setTpszD7Rto(String tpszD7Rto) {
		this.tpszD7Rto = tpszD7Rto;
	}
	
	/**
	 * Column Info
	 * @param tpszF2
	 */
	public void setTpszF2(String tpszF2) {
		this.tpszF2 = tpszF2;
	}
	
	/**
	 * Column Info
	 * @param ruleCd
	 */
	public void setRuleCd(String ruleCd) {
		this.ruleCd = ruleCd;
	}
	
	/**
	 * Column Info
	 * @param tpszF2Amt
	 */
	public void setTpszF2Amt(String tpszF2Amt) {
		this.tpszF2Amt = tpszF2Amt;
	}
	
	/**
	 * Column Info
	 * @param tpszF5Amt
	 */
	public void setTpszF5Amt(String tpszF5Amt) {
		this.tpszF5Amt = tpszF5Amt;
	}
	
	/**
	 * Column Info
	 * @param tpszD3Rto
	 */
	public void setTpszD3Rto(String tpszD3Rto) {
		this.tpszD3Rto = tpszD3Rto;
	}
	
	/**
	 * Column Info
	 * @param tpszO5
	 */
	public void setTpszO5(String tpszO5) {
		this.tpszO5 = tpszO5;
	}
	
	/**
	 * Column Info
	 * @param tpszD7Amt
	 */
	public void setTpszD7Amt(String tpszD7Amt) {
		this.tpszD7Amt = tpszD7Amt;
	}
	
	/**
	 * Column Info
	 * @param tpszO4
	 */
	public void setTpszO4(String tpszO4) {
		this.tpszO4 = tpszO4;
	}
	
	/**
	 * Column Info
	 * @param tpszR5Amt
	 */
	public void setTpszR5Amt(String tpszR5Amt) {
		this.tpszR5Amt = tpszR5Amt;
	}
	
	/**
	 * Column Info
	 * @param tpszO5Amt
	 */
	public void setTpszO5Amt(String tpszO5Amt) {
		this.tpszO5Amt = tpszO5Amt;
	}
	
	/**
	 * Column Info
	 * @param tpszD5Rto
	 */
	public void setTpszD5Rto(String tpszD5Rto) {
		this.tpszD5Rto = tpszD5Rto;
	}
	
	/**
	 * Column Info
	 * @param tpszF5
	 */
	public void setTpszF5(String tpszF5) {
		this.tpszF5 = tpszF5;
	}
	
	/**
	 * Column Info
	 * @param tpszO2
	 */
	public void setTpszO2(String tpszO2) {
		this.tpszO2 = tpszO2;
	}
	
	/**
	 * Column Info
	 * @param tpszF4
	 */
	public void setTpszF4(String tpszF4) {
		this.tpszF4 = tpszF4;
	}
	
	/**
	 * Column Info
	 * @param tpszO2Rto
	 */
	public void setTpszO2Rto(String tpszO2Rto) {
		this.tpszO2Rto = tpszO2Rto;
	}
	
	/**
	 * Column Info
	 * @param tpszR5Rto
	 */
	public void setTpszR5Rto(String tpszR5Rto) {
		this.tpszR5Rto = tpszR5Rto;
	}
	
	/**
	 * Column Info
	 * @param tpszR9Rto
	 */
	public void setTpszR9Rto(String tpszR9Rto) {
		this.tpszR9Rto = tpszR9Rto;
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
	 * @param cntNm
	 */
	public void setCntNm(String cntNm) {
		this.cntNm = cntNm;
	}
	
	/**
	 * Column Info
	 * @param tpszR2Amt
	 */
	public void setTpszR2Amt(String tpszR2Amt) {
		this.tpszR2Amt = tpszR2Amt;
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
	 * @param tpszO4Rto
	 */
	public void setTpszO4Rto(String tpszO4Rto) {
		this.tpszO4Rto = tpszO4Rto;
	}
	
	/**
	 * Column Info
	 * @param tpszD4Rto
	 */
	public void setTpszD4Rto(String tpszD4Rto) {
		this.tpszD4Rto = tpszD4Rto;
	}
	
	/**
	 * Column Info
	 * @param rccCd
	 */
	public void setRccCd(String rccCd) {
		this.rccCd = rccCd;
	}
	
	/**
	 * Column Info
	 * @param tpszO5Rto
	 */
	public void setTpszO5Rto(String tpszO5Rto) {
		this.tpszO5Rto = tpszO5Rto;
	}
	
	/**
	 * Column Info
	 * @param lccCd
	 */
	public void setLccCd(String lccCd) {
		this.lccCd = lccCd;
	}
	
	/**
	 * Column Info
	 * @param tpszD2Amt
	 */
	public void setTpszD2Amt(String tpszD2Amt) {
		this.tpszD2Amt = tpszD2Amt;
	}
	
	/**
	 * Column Info
	 * @param tpszO2Amt
	 */
	public void setTpszO2Amt(String tpszO2Amt) {
		this.tpszO2Amt = tpszO2Amt;
	}
	
	/**
	 * Column Info
	 * @param tpszF4Amt
	 */
	public void setTpszF4Amt(String tpszF4Amt) {
		this.tpszF4Amt = tpszF4Amt;
	}
	
	/**
	 * Column Info
	 * @param contiNm
	 */
	public void setContiNm(String contiNm) {
		this.contiNm = contiNm;
	}
	
	/**
	 * Column Info
	 * @param tpszD3
	 */
	public void setTpszD3(String tpszD3) {
		this.tpszD3 = tpszD3;
	}
	
	/**
	 * Column Info
	 * @param tpszD4
	 */
	public void setTpszD4(String tpszD4) {
		this.tpszD4 = tpszD4;
	}
	
	/**
	 * Column Info
	 * @param tpszD2
	 */
	public void setTpszD2(String tpszD2) {
		this.tpszD2 = tpszD2;
	}
	
	/**
	 * Column Info
	 * @param tpszO4Amt
	 */
	public void setTpszO4Amt(String tpszO4Amt) {
		this.tpszO4Amt = tpszO4Amt;
	}
	
	/**
	 * Column Info
	 * @param tpszD2Rto
	 */
	public void setTpszD2Rto(String tpszD2Rto) {
		this.tpszD2Rto = tpszD2Rto;
	}
	
	/**
	 * Column Info
	 * @param tpszD7
	 */
	public void setTpszD7(String tpszD7) {
		this.tpszD7 = tpszD7;
	}
	
	/**
	 * Column Info
	 * @param tpszD5
	 */
	public void setTpszD5(String tpszD5) {
		this.tpszD5 = tpszD5;
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
		setTpszR2(JSPUtil.getParameter(request, prefix + "tpsz_r2", ""));
		setTpszF2Rto(JSPUtil.getParameter(request, prefix + "tpsz_f2_rto", ""));
		setTpszR5(JSPUtil.getParameter(request, prefix + "tpsz_r5", ""));
		setTpszR9(JSPUtil.getParameter(request, prefix + "tpsz_r9", ""));
		setTpszR2Rto(JSPUtil.getParameter(request, prefix + "tpsz_r2_rto", ""));
		setTpszF4Rto(JSPUtil.getParameter(request, prefix + "tpsz_f4_rto", ""));
		setTpszD4Amt(JSPUtil.getParameter(request, prefix + "tpsz_d4_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTpszR9Amt(JSPUtil.getParameter(request, prefix + "tpsz_r9_amt", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setTpszD5Amt(JSPUtil.getParameter(request, prefix + "tpsz_d5_amt", ""));
		setTpszF5Rto(JSPUtil.getParameter(request, prefix + "tpsz_f5_rto", ""));
		setTpszD7Rto(JSPUtil.getParameter(request, prefix + "tpsz_d7_rto", ""));
		setTpszF2(JSPUtil.getParameter(request, prefix + "tpsz_f2", ""));
		setRuleCd(JSPUtil.getParameter(request, prefix + "rule_cd", ""));
		setTpszF2Amt(JSPUtil.getParameter(request, prefix + "tpsz_f2_amt", ""));
		setTpszF5Amt(JSPUtil.getParameter(request, prefix + "tpsz_f5_amt", ""));
		setTpszD3Rto(JSPUtil.getParameter(request, prefix + "tpsz_d3_rto", ""));
		setTpszO5(JSPUtil.getParameter(request, prefix + "tpsz_o5", ""));
		setTpszD7Amt(JSPUtil.getParameter(request, prefix + "tpsz_d7_amt", ""));
		setTpszO4(JSPUtil.getParameter(request, prefix + "tpsz_o4", ""));
		setTpszR5Amt(JSPUtil.getParameter(request, prefix + "tpsz_r5_amt", ""));
		setTpszO5Amt(JSPUtil.getParameter(request, prefix + "tpsz_o5_amt", ""));
		setTpszD5Rto(JSPUtil.getParameter(request, prefix + "tpsz_d5_rto", ""));
		setTpszF5(JSPUtil.getParameter(request, prefix + "tpsz_f5", ""));
		setTpszO2(JSPUtil.getParameter(request, prefix + "tpsz_o2", ""));
		setTpszF4(JSPUtil.getParameter(request, prefix + "tpsz_f4", ""));
		setTpszO2Rto(JSPUtil.getParameter(request, prefix + "tpsz_o2_rto", ""));
		setTpszR5Rto(JSPUtil.getParameter(request, prefix + "tpsz_r5_rto", ""));
		setTpszR9Rto(JSPUtil.getParameter(request, prefix + "tpsz_r9_rto", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntNm(JSPUtil.getParameter(request, prefix + "cnt_nm", ""));
		setTpszR2Amt(JSPUtil.getParameter(request, prefix + "tpsz_r2_amt", ""));
		setEccCd(JSPUtil.getParameter(request, prefix + "ecc_cd", ""));
		setTpszO4Rto(JSPUtil.getParameter(request, prefix + "tpsz_o4_rto", ""));
		setTpszD4Rto(JSPUtil.getParameter(request, prefix + "tpsz_d4_rto", ""));
		setRccCd(JSPUtil.getParameter(request, prefix + "rcc_cd", ""));
		setTpszO5Rto(JSPUtil.getParameter(request, prefix + "tpsz_o5_rto", ""));
		setLccCd(JSPUtil.getParameter(request, prefix + "lcc_cd", ""));
		setTpszD2Amt(JSPUtil.getParameter(request, prefix + "tpsz_d2_amt", ""));
		setTpszO2Amt(JSPUtil.getParameter(request, prefix + "tpsz_o2_amt", ""));
		setTpszF4Amt(JSPUtil.getParameter(request, prefix + "tpsz_f4_amt", ""));
		setContiNm(JSPUtil.getParameter(request, prefix + "conti_nm", ""));
		setTpszD3(JSPUtil.getParameter(request, prefix + "tpsz_d3", ""));
		setTpszD4(JSPUtil.getParameter(request, prefix + "tpsz_d4", ""));
		setTpszD2(JSPUtil.getParameter(request, prefix + "tpsz_d2", ""));
		setTpszO4Amt(JSPUtil.getParameter(request, prefix + "tpsz_o4_amt", ""));
		setTpszD2Rto(JSPUtil.getParameter(request, prefix + "tpsz_d2_rto", ""));
		setTpszD7(JSPUtil.getParameter(request, prefix + "tpsz_d7", ""));
		setTpszD5(JSPUtil.getParameter(request, prefix + "tpsz_d5", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MasEMUCreditListVO[]
	 */
	public MasEMUCreditListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MasEMUCreditListVO[]
	 */
	public MasEMUCreditListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MasEMUCreditListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] tpszR2 = (JSPUtil.getParameter(request, prefix	+ "tpsz_r2", length));
			String[] tpszF2Rto = (JSPUtil.getParameter(request, prefix	+ "tpsz_f2_rto", length));
			String[] tpszR5 = (JSPUtil.getParameter(request, prefix	+ "tpsz_r5", length));
			String[] tpszR9 = (JSPUtil.getParameter(request, prefix	+ "tpsz_r9", length));
			String[] tpszR2Rto = (JSPUtil.getParameter(request, prefix	+ "tpsz_r2_rto", length));
			String[] tpszF4Rto = (JSPUtil.getParameter(request, prefix	+ "tpsz_f4_rto", length));
			String[] tpszD4Amt = (JSPUtil.getParameter(request, prefix	+ "tpsz_d4_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] tpszR9Amt = (JSPUtil.getParameter(request, prefix	+ "tpsz_r9_amt", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] tpszD5Amt = (JSPUtil.getParameter(request, prefix	+ "tpsz_d5_amt", length));
			String[] tpszF5Rto = (JSPUtil.getParameter(request, prefix	+ "tpsz_f5_rto", length));
			String[] tpszD7Rto = (JSPUtil.getParameter(request, prefix	+ "tpsz_d7_rto", length));
			String[] tpszF2 = (JSPUtil.getParameter(request, prefix	+ "tpsz_f2", length));
			String[] ruleCd = (JSPUtil.getParameter(request, prefix	+ "rule_cd", length));
			String[] tpszF2Amt = (JSPUtil.getParameter(request, prefix	+ "tpsz_f2_amt", length));
			String[] tpszF5Amt = (JSPUtil.getParameter(request, prefix	+ "tpsz_f5_amt", length));
			String[] tpszD3Rto = (JSPUtil.getParameter(request, prefix	+ "tpsz_d3_rto", length));
			String[] tpszO5 = (JSPUtil.getParameter(request, prefix	+ "tpsz_o5", length));
			String[] tpszD7Amt = (JSPUtil.getParameter(request, prefix	+ "tpsz_d7_amt", length));
			String[] tpszO4 = (JSPUtil.getParameter(request, prefix	+ "tpsz_o4", length));
			String[] tpszR5Amt = (JSPUtil.getParameter(request, prefix	+ "tpsz_r5_amt", length));
			String[] tpszO5Amt = (JSPUtil.getParameter(request, prefix	+ "tpsz_o5_amt", length));
			String[] tpszD5Rto = (JSPUtil.getParameter(request, prefix	+ "tpsz_d5_rto", length));
			String[] tpszF5 = (JSPUtil.getParameter(request, prefix	+ "tpsz_f5", length));
			String[] tpszO2 = (JSPUtil.getParameter(request, prefix	+ "tpsz_o2", length));
			String[] tpszF4 = (JSPUtil.getParameter(request, prefix	+ "tpsz_f4", length));
			String[] tpszO2Rto = (JSPUtil.getParameter(request, prefix	+ "tpsz_o2_rto", length));
			String[] tpszR5Rto = (JSPUtil.getParameter(request, prefix	+ "tpsz_r5_rto", length));
			String[] tpszR9Rto = (JSPUtil.getParameter(request, prefix	+ "tpsz_r9_rto", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntNm = (JSPUtil.getParameter(request, prefix	+ "cnt_nm", length));
			String[] tpszR2Amt = (JSPUtil.getParameter(request, prefix	+ "tpsz_r2_amt", length));
			String[] eccCd = (JSPUtil.getParameter(request, prefix	+ "ecc_cd", length));
			String[] tpszO4Rto = (JSPUtil.getParameter(request, prefix	+ "tpsz_o4_rto", length));
			String[] tpszD4Rto = (JSPUtil.getParameter(request, prefix	+ "tpsz_d4_rto", length));
			String[] rccCd = (JSPUtil.getParameter(request, prefix	+ "rcc_cd", length));
			String[] tpszO5Rto = (JSPUtil.getParameter(request, prefix	+ "tpsz_o5_rto", length));
			String[] lccCd = (JSPUtil.getParameter(request, prefix	+ "lcc_cd", length));
			String[] tpszD2Amt = (JSPUtil.getParameter(request, prefix	+ "tpsz_d2_amt", length));
			String[] tpszO2Amt = (JSPUtil.getParameter(request, prefix	+ "tpsz_o2_amt", length));
			String[] tpszF4Amt = (JSPUtil.getParameter(request, prefix	+ "tpsz_f4_amt", length));
			String[] contiNm = (JSPUtil.getParameter(request, prefix	+ "conti_nm", length));
			String[] tpszD3 = (JSPUtil.getParameter(request, prefix	+ "tpsz_d3", length));
			String[] tpszD4 = (JSPUtil.getParameter(request, prefix	+ "tpsz_d4", length));
			String[] tpszD2 = (JSPUtil.getParameter(request, prefix	+ "tpsz_d2", length));
			String[] tpszO4Amt = (JSPUtil.getParameter(request, prefix	+ "tpsz_o4_amt", length));
			String[] tpszD2Rto = (JSPUtil.getParameter(request, prefix	+ "tpsz_d2_rto", length));
			String[] tpszD7 = (JSPUtil.getParameter(request, prefix	+ "tpsz_d7", length));
			String[] tpszD5 = (JSPUtil.getParameter(request, prefix	+ "tpsz_d5", length));
			
			for (int i = 0; i < length; i++) {
				model = new MasEMUCreditListVO();
				if (tpszR2[i] != null)
					model.setTpszR2(tpszR2[i]);
				if (tpszF2Rto[i] != null)
					model.setTpszF2Rto(tpszF2Rto[i]);
				if (tpszR5[i] != null)
					model.setTpszR5(tpszR5[i]);
				if (tpszR9[i] != null)
					model.setTpszR9(tpszR9[i]);
				if (tpszR2Rto[i] != null)
					model.setTpszR2Rto(tpszR2Rto[i]);
				if (tpszF4Rto[i] != null)
					model.setTpszF4Rto(tpszF4Rto[i]);
				if (tpszD4Amt[i] != null)
					model.setTpszD4Amt(tpszD4Amt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (tpszR9Amt[i] != null)
					model.setTpszR9Amt(tpszR9Amt[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (tpszD5Amt[i] != null)
					model.setTpszD5Amt(tpszD5Amt[i]);
				if (tpszF5Rto[i] != null)
					model.setTpszF5Rto(tpszF5Rto[i]);
				if (tpszD7Rto[i] != null)
					model.setTpszD7Rto(tpszD7Rto[i]);
				if (tpszF2[i] != null)
					model.setTpszF2(tpszF2[i]);
				if (ruleCd[i] != null)
					model.setRuleCd(ruleCd[i]);
				if (tpszF2Amt[i] != null)
					model.setTpszF2Amt(tpszF2Amt[i]);
				if (tpszF5Amt[i] != null)
					model.setTpszF5Amt(tpszF5Amt[i]);
				if (tpszD3Rto[i] != null)
					model.setTpszD3Rto(tpszD3Rto[i]);
				if (tpszO5[i] != null)
					model.setTpszO5(tpszO5[i]);
				if (tpszD7Amt[i] != null)
					model.setTpszD7Amt(tpszD7Amt[i]);
				if (tpszO4[i] != null)
					model.setTpszO4(tpszO4[i]);
				if (tpszR5Amt[i] != null)
					model.setTpszR5Amt(tpszR5Amt[i]);
				if (tpszO5Amt[i] != null)
					model.setTpszO5Amt(tpszO5Amt[i]);
				if (tpszD5Rto[i] != null)
					model.setTpszD5Rto(tpszD5Rto[i]);
				if (tpszF5[i] != null)
					model.setTpszF5(tpszF5[i]);
				if (tpszO2[i] != null)
					model.setTpszO2(tpszO2[i]);
				if (tpszF4[i] != null)
					model.setTpszF4(tpszF4[i]);
				if (tpszO2Rto[i] != null)
					model.setTpszO2Rto(tpszO2Rto[i]);
				if (tpszR5Rto[i] != null)
					model.setTpszR5Rto(tpszR5Rto[i]);
				if (tpszR9Rto[i] != null)
					model.setTpszR9Rto(tpszR9Rto[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntNm[i] != null)
					model.setCntNm(cntNm[i]);
				if (tpszR2Amt[i] != null)
					model.setTpszR2Amt(tpszR2Amt[i]);
				if (eccCd[i] != null)
					model.setEccCd(eccCd[i]);
				if (tpszO4Rto[i] != null)
					model.setTpszO4Rto(tpszO4Rto[i]);
				if (tpszD4Rto[i] != null)
					model.setTpszD4Rto(tpszD4Rto[i]);
				if (rccCd[i] != null)
					model.setRccCd(rccCd[i]);
				if (tpszO5Rto[i] != null)
					model.setTpszO5Rto(tpszO5Rto[i]);
				if (lccCd[i] != null)
					model.setLccCd(lccCd[i]);
				if (tpszD2Amt[i] != null)
					model.setTpszD2Amt(tpszD2Amt[i]);
				if (tpszO2Amt[i] != null)
					model.setTpszO2Amt(tpszO2Amt[i]);
				if (tpszF4Amt[i] != null)
					model.setTpszF4Amt(tpszF4Amt[i]);
				if (contiNm[i] != null)
					model.setContiNm(contiNm[i]);
				if (tpszD3[i] != null)
					model.setTpszD3(tpszD3[i]);
				if (tpszD4[i] != null)
					model.setTpszD4(tpszD4[i]);
				if (tpszD2[i] != null)
					model.setTpszD2(tpszD2[i]);
				if (tpszO4Amt[i] != null)
					model.setTpszO4Amt(tpszO4Amt[i]);
				if (tpszD2Rto[i] != null)
					model.setTpszD2Rto(tpszD2Rto[i]);
				if (tpszD7[i] != null)
					model.setTpszD7(tpszD7[i]);
				if (tpszD5[i] != null)
					model.setTpszD5(tpszD5[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMasEMUCreditListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MasEMUCreditListVO[]
	 */
	public MasEMUCreditListVO[] getMasEMUCreditListVOs(){
		MasEMUCreditListVO[] vos = (MasEMUCreditListVO[])models.toArray(new MasEMUCreditListVO[models.size()]);
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
		this.tpszR2 = this.tpszR2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszF2Rto = this.tpszF2Rto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszR5 = this.tpszR5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszR9 = this.tpszR9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszR2Rto = this.tpszR2Rto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszF4Rto = this.tpszF4Rto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszD4Amt = this.tpszD4Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszR9Amt = this.tpszR9Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszD5Amt = this.tpszD5Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszF5Rto = this.tpszF5Rto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszD7Rto = this.tpszD7Rto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszF2 = this.tpszF2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ruleCd = this.ruleCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszF2Amt = this.tpszF2Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszF5Amt = this.tpszF5Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszD3Rto = this.tpszD3Rto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszO5 = this.tpszO5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszD7Amt = this.tpszD7Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszO4 = this.tpszO4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszR5Amt = this.tpszR5Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszO5Amt = this.tpszO5Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszD5Rto = this.tpszD5Rto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszF5 = this.tpszF5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszO2 = this.tpszO2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszF4 = this.tpszF4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszO2Rto = this.tpszO2Rto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszR5Rto = this.tpszR5Rto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszR9Rto = this.tpszR9Rto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntNm = this.cntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszR2Amt = this.tpszR2Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eccCd = this.eccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszO4Rto = this.tpszO4Rto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszD4Rto = this.tpszD4Rto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccCd = this.rccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszO5Rto = this.tpszO5Rto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lccCd = this.lccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszD2Amt = this.tpszD2Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszO2Amt = this.tpszO2Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszF4Amt = this.tpszF4Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contiNm = this.contiNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszD3 = this.tpszD3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszD4 = this.tpszD4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszD2 = this.tpszD2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszO4Amt = this.tpszO4Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszD2Rto = this.tpszD2Rto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszD7 = this.tpszD7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszD5 = this.tpszD5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
