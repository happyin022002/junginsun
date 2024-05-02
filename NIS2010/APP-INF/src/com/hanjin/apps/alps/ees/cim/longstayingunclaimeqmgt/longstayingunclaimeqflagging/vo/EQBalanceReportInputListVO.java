/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EQBalanceReportInputListVO.java
*@FileTitle : EQBalanceReportInputListVO
*Open Issues : 장비 과부족현황 Mailing (2014.03 ~ 2014.04)
*Change history :
*@LastModifyDate : 2014.04.02
*@LastModifier : Chang Young Kim
*@LastVersion : 1.0
* 2014.04.02 Chang Young Kim
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo;

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

public class EQBalanceReportInputListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EQBalanceReportInputListVO> models = new ArrayList<EQBalanceReportInputListVO>();
	
	/* Column Info */
	private String d4Bal = null;
	/* Column Info */
	private String o4Rto = null;
	/* Column Info */
	private String d4Sts2 = null;
	/* Column Info */
	private String r2Sts2 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String r5Bal = null;
	/* Column Info */
	private String d5Rto = null;
	/* Column Info */
	private String o2Rto = null;
	/* Column Info */
	private String o4Sts = null;
	/* Column Info */
	private String f4Sts = null;
	/* Column Info */
	private String o2Sts = null;
	/* Column Info */
	private String f2Sts2 = null;
	/* Column Info */
	private String d5Bal = null;
	/* Column Info */
	private String d5Sts = null;
	/* Column Info */
	private String d7Rto = null;
	/* Column Info */
	private String o2Sts2 = null;
	/* Column Info */
	private String d7Sts2 = null;
	/* Column Info */
	private String d4Rto = null;
	/* Column Info */
	private String d2Bal = null;
	/* Column Info */
	private String d7Bal = null;
	/* Column Info */
	private String d7Sts = null;
	/* Column Info */
	private String d2Rto = null;
	/* Column Info */
	private String scontiNm = null;
	/* Column Info */
	private String o4Bal = null;
	/* Column Info */
	private String d2Sts2 = null;
	/* Column Info */
	private String d4Sts = null;
	/* Column Info */
	private String r5Sts2 = null;
	/* Column Info */
	private String r2Bal = null;
	/* Column Info */
	private String d2Sts = null;
	/* Column Info */
	private String d5Sts2 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String f2Sts = null;
	/* Column Info */
	private String r5Rto = null;
	/* Column Info */
	private String f2Rto = null;
	/* Column Info */
	private String r5Sts = null;
	/* Column Info */
	private String f4Bal = null;
	/* Column Info */
	private String f2Bal = null;
	/* Column Info */
	private String eccCd = null;
	/* Column Info */
	private String rccCd = null;
	/* Column Info */
	private String o2Bal = null;
	/* Column Info */
	private String cfmFlg = null;
	/* Column Info */
	private String f4Rto = null;
	/* Column Info */
	private String r2Rto = null;
	/* Column Info */
	private String lccCd = null;
	/* Column Info */
	private String tgtYrwk = null;
	/* Column Info */
	private String r2Sts = null;
	/* Column Info */
	private String stsRmk = null;
	/* Column Info */
	private String f4Sts2 = null;
	/* Column Info */
	private String o4Sts2 = null;
	/* Column Info */
	private String scontiCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public EQBalanceReportInputListVO() {}

	public EQBalanceReportInputListVO(String ibflag, String pagerows, String rccCd, String scontiCd, String lccCd, String eccCd, String tgtYrwk, String scontiNm, String d2Rto, String d4Rto, String d5Rto, String d7Rto, String r2Rto, String r5Rto, String o2Rto, String o4Rto, String f2Rto, String f4Rto, String d2Bal, String d4Bal, String d5Bal, String d7Bal, String r2Bal, String r5Bal, String o2Bal, String o4Bal, String f2Bal, String f4Bal, String d2Sts, String d4Sts, String d5Sts, String d7Sts, String r2Sts, String r5Sts, String o2Sts, String o4Sts, String f2Sts, String f4Sts, String d2Sts2, String d4Sts2, String d5Sts2, String d7Sts2, String r2Sts2, String r5Sts2, String o2Sts2, String o4Sts2, String f2Sts2, String f4Sts2, String cfmFlg, String stsRmk) {
		this.d4Bal = d4Bal;
		this.o4Rto = o4Rto;
		this.d4Sts2 = d4Sts2;
		this.r2Sts2 = r2Sts2;
		this.pagerows = pagerows;
		this.r5Bal = r5Bal;
		this.d5Rto = d5Rto;
		this.o2Rto = o2Rto;
		this.o4Sts = o4Sts;
		this.f4Sts = f4Sts;
		this.o2Sts = o2Sts;
		this.f2Sts2 = f2Sts2;
		this.d5Bal = d5Bal;
		this.d5Sts = d5Sts;
		this.d7Rto = d7Rto;
		this.o2Sts2 = o2Sts2;
		this.d7Sts2 = d7Sts2;
		this.d4Rto = d4Rto;
		this.d2Bal = d2Bal;
		this.d7Bal = d7Bal;
		this.d7Sts = d7Sts;
		this.d2Rto = d2Rto;
		this.scontiNm = scontiNm;
		this.o4Bal = o4Bal;
		this.d2Sts2 = d2Sts2;
		this.d4Sts = d4Sts;
		this.r5Sts2 = r5Sts2;
		this.r2Bal = r2Bal;
		this.d2Sts = d2Sts;
		this.d5Sts2 = d5Sts2;
		this.ibflag = ibflag;
		this.f2Sts = f2Sts;
		this.r5Rto = r5Rto;
		this.f2Rto = f2Rto;
		this.r5Sts = r5Sts;
		this.f4Bal = f4Bal;
		this.f2Bal = f2Bal;
		this.eccCd = eccCd;
		this.rccCd = rccCd;
		this.o2Bal = o2Bal;
		this.cfmFlg = cfmFlg;
		this.f4Rto = f4Rto;
		this.r2Rto = r2Rto;
		this.lccCd = lccCd;
		this.tgtYrwk = tgtYrwk;
		this.r2Sts = r2Sts;
		this.stsRmk = stsRmk;
		this.f4Sts2 = f4Sts2;
		this.o4Sts2 = o4Sts2;
		this.scontiCd = scontiCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("d4_bal", getD4Bal());
		this.hashColumns.put("o4_rto", getO4Rto());
		this.hashColumns.put("d4_sts2", getD4Sts2());
		this.hashColumns.put("r2_sts2", getR2Sts2());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("r5_bal", getR5Bal());
		this.hashColumns.put("d5_rto", getD5Rto());
		this.hashColumns.put("o2_rto", getO2Rto());
		this.hashColumns.put("o4_sts", getO4Sts());
		this.hashColumns.put("f4_sts", getF4Sts());
		this.hashColumns.put("o2_sts", getO2Sts());
		this.hashColumns.put("f2_sts2", getF2Sts2());
		this.hashColumns.put("d5_bal", getD5Bal());
		this.hashColumns.put("d5_sts", getD5Sts());
		this.hashColumns.put("d7_rto", getD7Rto());
		this.hashColumns.put("o2_sts2", getO2Sts2());
		this.hashColumns.put("d7_sts2", getD7Sts2());
		this.hashColumns.put("d4_rto", getD4Rto());
		this.hashColumns.put("d2_bal", getD2Bal());
		this.hashColumns.put("d7_bal", getD7Bal());
		this.hashColumns.put("d7_sts", getD7Sts());
		this.hashColumns.put("d2_rto", getD2Rto());
		this.hashColumns.put("sconti_nm", getScontiNm());
		this.hashColumns.put("o4_bal", getO4Bal());
		this.hashColumns.put("d2_sts2", getD2Sts2());
		this.hashColumns.put("d4_sts", getD4Sts());
		this.hashColumns.put("r5_sts2", getR5Sts2());
		this.hashColumns.put("r2_bal", getR2Bal());
		this.hashColumns.put("d2_sts", getD2Sts());
		this.hashColumns.put("d5_sts2", getD5Sts2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("f2_sts", getF2Sts());
		this.hashColumns.put("r5_rto", getR5Rto());
		this.hashColumns.put("f2_rto", getF2Rto());
		this.hashColumns.put("r5_sts", getR5Sts());
		this.hashColumns.put("f4_bal", getF4Bal());
		this.hashColumns.put("f2_bal", getF2Bal());
		this.hashColumns.put("ecc_cd", getEccCd());
		this.hashColumns.put("rcc_cd", getRccCd());
		this.hashColumns.put("o2_bal", getO2Bal());
		this.hashColumns.put("cfm_flg", getCfmFlg());
		this.hashColumns.put("f4_rto", getF4Rto());
		this.hashColumns.put("r2_rto", getR2Rto());
		this.hashColumns.put("lcc_cd", getLccCd());
		this.hashColumns.put("tgt_yrwk", getTgtYrwk());
		this.hashColumns.put("r2_sts", getR2Sts());
		this.hashColumns.put("sts_rmk", getStsRmk());
		this.hashColumns.put("f4_sts2", getF4Sts2());
		this.hashColumns.put("o4_sts2", getO4Sts2());
		this.hashColumns.put("sconti_cd", getScontiCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("d4_bal", "d4Bal");
		this.hashFields.put("o4_rto", "o4Rto");
		this.hashFields.put("d4_sts2", "d4Sts2");
		this.hashFields.put("r2_sts2", "r2Sts2");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("r5_bal", "r5Bal");
		this.hashFields.put("d5_rto", "d5Rto");
		this.hashFields.put("o2_rto", "o2Rto");
		this.hashFields.put("o4_sts", "o4Sts");
		this.hashFields.put("f4_sts", "f4Sts");
		this.hashFields.put("o2_sts", "o2Sts");
		this.hashFields.put("f2_sts2", "f2Sts2");
		this.hashFields.put("d5_bal", "d5Bal");
		this.hashFields.put("d5_sts", "d5Sts");
		this.hashFields.put("d7_rto", "d7Rto");
		this.hashFields.put("o2_sts2", "o2Sts2");
		this.hashFields.put("d7_sts2", "d7Sts2");
		this.hashFields.put("d4_rto", "d4Rto");
		this.hashFields.put("d2_bal", "d2Bal");
		this.hashFields.put("d7_bal", "d7Bal");
		this.hashFields.put("d7_sts", "d7Sts");
		this.hashFields.put("d2_rto", "d2Rto");
		this.hashFields.put("sconti_nm", "scontiNm");
		this.hashFields.put("o4_bal", "o4Bal");
		this.hashFields.put("d2_sts2", "d2Sts2");
		this.hashFields.put("d4_sts", "d4Sts");
		this.hashFields.put("r5_sts2", "r5Sts2");
		this.hashFields.put("r2_bal", "r2Bal");
		this.hashFields.put("d2_sts", "d2Sts");
		this.hashFields.put("d5_sts2", "d5Sts2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("f2_sts", "f2Sts");
		this.hashFields.put("r5_rto", "r5Rto");
		this.hashFields.put("f2_rto", "f2Rto");
		this.hashFields.put("r5_sts", "r5Sts");
		this.hashFields.put("f4_bal", "f4Bal");
		this.hashFields.put("f2_bal", "f2Bal");
		this.hashFields.put("ecc_cd", "eccCd");
		this.hashFields.put("rcc_cd", "rccCd");
		this.hashFields.put("o2_bal", "o2Bal");
		this.hashFields.put("cfm_flg", "cfmFlg");
		this.hashFields.put("f4_rto", "f4Rto");
		this.hashFields.put("r2_rto", "r2Rto");
		this.hashFields.put("lcc_cd", "lccCd");
		this.hashFields.put("tgt_yrwk", "tgtYrwk");
		this.hashFields.put("r2_sts", "r2Sts");
		this.hashFields.put("sts_rmk", "stsRmk");
		this.hashFields.put("f4_sts2", "f4Sts2");
		this.hashFields.put("o4_sts2", "o4Sts2");
		this.hashFields.put("sconti_cd", "scontiCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return d4Bal
	 */
	public String getD4Bal() {
		return this.d4Bal;
	}
	
	/**
	 * Column Info
	 * @return o4Rto
	 */
	public String getO4Rto() {
		return this.o4Rto;
	}
	
	/**
	 * Column Info
	 * @return d4Sts2
	 */
	public String getD4Sts2() {
		return this.d4Sts2;
	}
	
	/**
	 * Column Info
	 * @return r2Sts2
	 */
	public String getR2Sts2() {
		return this.r2Sts2;
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
	 * @return r5Bal
	 */
	public String getR5Bal() {
		return this.r5Bal;
	}
	
	/**
	 * Column Info
	 * @return d5Rto
	 */
	public String getD5Rto() {
		return this.d5Rto;
	}
	
	/**
	 * Column Info
	 * @return o2Rto
	 */
	public String getO2Rto() {
		return this.o2Rto;
	}
	
	/**
	 * Column Info
	 * @return o4Sts
	 */
	public String getO4Sts() {
		return this.o4Sts;
	}
	
	/**
	 * Column Info
	 * @return f4Sts
	 */
	public String getF4Sts() {
		return this.f4Sts;
	}
	
	/**
	 * Column Info
	 * @return o2Sts
	 */
	public String getO2Sts() {
		return this.o2Sts;
	}
	
	/**
	 * Column Info
	 * @return f2Sts2
	 */
	public String getF2Sts2() {
		return this.f2Sts2;
	}
	
	/**
	 * Column Info
	 * @return d5Bal
	 */
	public String getD5Bal() {
		return this.d5Bal;
	}
	
	/**
	 * Column Info
	 * @return d5Sts
	 */
	public String getD5Sts() {
		return this.d5Sts;
	}
	
	/**
	 * Column Info
	 * @return d7Rto
	 */
	public String getD7Rto() {
		return this.d7Rto;
	}
	
	/**
	 * Column Info
	 * @return o2Sts2
	 */
	public String getO2Sts2() {
		return this.o2Sts2;
	}
	
	/**
	 * Column Info
	 * @return d7Sts2
	 */
	public String getD7Sts2() {
		return this.d7Sts2;
	}
	
	/**
	 * Column Info
	 * @return d4Rto
	 */
	public String getD4Rto() {
		return this.d4Rto;
	}
	
	/**
	 * Column Info
	 * @return d2Bal
	 */
	public String getD2Bal() {
		return this.d2Bal;
	}
	
	/**
	 * Column Info
	 * @return d7Bal
	 */
	public String getD7Bal() {
		return this.d7Bal;
	}
	
	/**
	 * Column Info
	 * @return d7Sts
	 */
	public String getD7Sts() {
		return this.d7Sts;
	}
	
	/**
	 * Column Info
	 * @return d2Rto
	 */
	public String getD2Rto() {
		return this.d2Rto;
	}
	
	/**
	 * Column Info
	 * @return scontiNm
	 */
	public String getScontiNm() {
		return this.scontiNm;
	}
	
	/**
	 * Column Info
	 * @return o4Bal
	 */
	public String getO4Bal() {
		return this.o4Bal;
	}
	
	/**
	 * Column Info
	 * @return d2Sts2
	 */
	public String getD2Sts2() {
		return this.d2Sts2;
	}
	
	/**
	 * Column Info
	 * @return d4Sts
	 */
	public String getD4Sts() {
		return this.d4Sts;
	}
	
	/**
	 * Column Info
	 * @return r5Sts2
	 */
	public String getR5Sts2() {
		return this.r5Sts2;
	}
	
	/**
	 * Column Info
	 * @return r2Bal
	 */
	public String getR2Bal() {
		return this.r2Bal;
	}
	
	/**
	 * Column Info
	 * @return d2Sts
	 */
	public String getD2Sts() {
		return this.d2Sts;
	}
	
	/**
	 * Column Info
	 * @return d5Sts2
	 */
	public String getD5Sts2() {
		return this.d5Sts2;
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
	 * @return f2Sts
	 */
	public String getF2Sts() {
		return this.f2Sts;
	}
	
	/**
	 * Column Info
	 * @return r5Rto
	 */
	public String getR5Rto() {
		return this.r5Rto;
	}
	
	/**
	 * Column Info
	 * @return f2Rto
	 */
	public String getF2Rto() {
		return this.f2Rto;
	}
	
	/**
	 * Column Info
	 * @return r5Sts
	 */
	public String getR5Sts() {
		return this.r5Sts;
	}
	
	/**
	 * Column Info
	 * @return f4Bal
	 */
	public String getF4Bal() {
		return this.f4Bal;
	}
	
	/**
	 * Column Info
	 * @return f2Bal
	 */
	public String getF2Bal() {
		return this.f2Bal;
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
	 * @return rccCd
	 */
	public String getRccCd() {
		return this.rccCd;
	}
	
	/**
	 * Column Info
	 * @return o2Bal
	 */
	public String getO2Bal() {
		return this.o2Bal;
	}
	
	/**
	 * Column Info
	 * @return cfmFlg
	 */
	public String getCfmFlg() {
		return this.cfmFlg;
	}
	
	/**
	 * Column Info
	 * @return f4Rto
	 */
	public String getF4Rto() {
		return this.f4Rto;
	}
	
	/**
	 * Column Info
	 * @return r2Rto
	 */
	public String getR2Rto() {
		return this.r2Rto;
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
	 * @return tgtYrwk
	 */
	public String getTgtYrwk() {
		return this.tgtYrwk;
	}
	
	/**
	 * Column Info
	 * @return r2Sts
	 */
	public String getR2Sts() {
		return this.r2Sts;
	}
	
	/**
	 * Column Info
	 * @return stsRmk
	 */
	public String getStsRmk() {
		return this.stsRmk;
	}
	
	/**
	 * Column Info
	 * @return f4Sts2
	 */
	public String getF4Sts2() {
		return this.f4Sts2;
	}
	
	/**
	 * Column Info
	 * @return o4Sts2
	 */
	public String getO4Sts2() {
		return this.o4Sts2;
	}
	
	/**
	 * Column Info
	 * @return scontiCd
	 */
	public String getScontiCd() {
		return this.scontiCd;
	}
	

	/**
	 * Column Info
	 * @param d4Bal
	 */
	public void setD4Bal(String d4Bal) {
		this.d4Bal = d4Bal;
	}
	
	/**
	 * Column Info
	 * @param o4Rto
	 */
	public void setO4Rto(String o4Rto) {
		this.o4Rto = o4Rto;
	}
	
	/**
	 * Column Info
	 * @param d4Sts2
	 */
	public void setD4Sts2(String d4Sts2) {
		this.d4Sts2 = d4Sts2;
	}
	
	/**
	 * Column Info
	 * @param r2Sts2
	 */
	public void setR2Sts2(String r2Sts2) {
		this.r2Sts2 = r2Sts2;
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
	 * @param r5Bal
	 */
	public void setR5Bal(String r5Bal) {
		this.r5Bal = r5Bal;
	}
	
	/**
	 * Column Info
	 * @param d5Rto
	 */
	public void setD5Rto(String d5Rto) {
		this.d5Rto = d5Rto;
	}
	
	/**
	 * Column Info
	 * @param o2Rto
	 */
	public void setO2Rto(String o2Rto) {
		this.o2Rto = o2Rto;
	}
	
	/**
	 * Column Info
	 * @param o4Sts
	 */
	public void setO4Sts(String o4Sts) {
		this.o4Sts = o4Sts;
	}
	
	/**
	 * Column Info
	 * @param f4Sts
	 */
	public void setF4Sts(String f4Sts) {
		this.f4Sts = f4Sts;
	}
	
	/**
	 * Column Info
	 * @param o2Sts
	 */
	public void setO2Sts(String o2Sts) {
		this.o2Sts = o2Sts;
	}
	
	/**
	 * Column Info
	 * @param f2Sts2
	 */
	public void setF2Sts2(String f2Sts2) {
		this.f2Sts2 = f2Sts2;
	}
	
	/**
	 * Column Info
	 * @param d5Bal
	 */
	public void setD5Bal(String d5Bal) {
		this.d5Bal = d5Bal;
	}
	
	/**
	 * Column Info
	 * @param d5Sts
	 */
	public void setD5Sts(String d5Sts) {
		this.d5Sts = d5Sts;
	}
	
	/**
	 * Column Info
	 * @param d7Rto
	 */
	public void setD7Rto(String d7Rto) {
		this.d7Rto = d7Rto;
	}
	
	/**
	 * Column Info
	 * @param o2Sts2
	 */
	public void setO2Sts2(String o2Sts2) {
		this.o2Sts2 = o2Sts2;
	}
	
	/**
	 * Column Info
	 * @param d7Sts2
	 */
	public void setD7Sts2(String d7Sts2) {
		this.d7Sts2 = d7Sts2;
	}
	
	/**
	 * Column Info
	 * @param d4Rto
	 */
	public void setD4Rto(String d4Rto) {
		this.d4Rto = d4Rto;
	}
	
	/**
	 * Column Info
	 * @param d2Bal
	 */
	public void setD2Bal(String d2Bal) {
		this.d2Bal = d2Bal;
	}
	
	/**
	 * Column Info
	 * @param d7Bal
	 */
	public void setD7Bal(String d7Bal) {
		this.d7Bal = d7Bal;
	}
	
	/**
	 * Column Info
	 * @param d7Sts
	 */
	public void setD7Sts(String d7Sts) {
		this.d7Sts = d7Sts;
	}
	
	/**
	 * Column Info
	 * @param d2Rto
	 */
	public void setD2Rto(String d2Rto) {
		this.d2Rto = d2Rto;
	}
	
	/**
	 * Column Info
	 * @param scontiNm
	 */
	public void setScontiNm(String scontiNm) {
		this.scontiNm = scontiNm;
	}
	
	/**
	 * Column Info
	 * @param o4Bal
	 */
	public void setO4Bal(String o4Bal) {
		this.o4Bal = o4Bal;
	}
	
	/**
	 * Column Info
	 * @param d2Sts2
	 */
	public void setD2Sts2(String d2Sts2) {
		this.d2Sts2 = d2Sts2;
	}
	
	/**
	 * Column Info
	 * @param d4Sts
	 */
	public void setD4Sts(String d4Sts) {
		this.d4Sts = d4Sts;
	}
	
	/**
	 * Column Info
	 * @param r5Sts2
	 */
	public void setR5Sts2(String r5Sts2) {
		this.r5Sts2 = r5Sts2;
	}
	
	/**
	 * Column Info
	 * @param r2Bal
	 */
	public void setR2Bal(String r2Bal) {
		this.r2Bal = r2Bal;
	}
	
	/**
	 * Column Info
	 * @param d2Sts
	 */
	public void setD2Sts(String d2Sts) {
		this.d2Sts = d2Sts;
	}
	
	/**
	 * Column Info
	 * @param d5Sts2
	 */
	public void setD5Sts2(String d5Sts2) {
		this.d5Sts2 = d5Sts2;
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
	 * @param f2Sts
	 */
	public void setF2Sts(String f2Sts) {
		this.f2Sts = f2Sts;
	}
	
	/**
	 * Column Info
	 * @param r5Rto
	 */
	public void setR5Rto(String r5Rto) {
		this.r5Rto = r5Rto;
	}
	
	/**
	 * Column Info
	 * @param f2Rto
	 */
	public void setF2Rto(String f2Rto) {
		this.f2Rto = f2Rto;
	}
	
	/**
	 * Column Info
	 * @param r5Sts
	 */
	public void setR5Sts(String r5Sts) {
		this.r5Sts = r5Sts;
	}
	
	/**
	 * Column Info
	 * @param f4Bal
	 */
	public void setF4Bal(String f4Bal) {
		this.f4Bal = f4Bal;
	}
	
	/**
	 * Column Info
	 * @param f2Bal
	 */
	public void setF2Bal(String f2Bal) {
		this.f2Bal = f2Bal;
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
	 * @param rccCd
	 */
	public void setRccCd(String rccCd) {
		this.rccCd = rccCd;
	}
	
	/**
	 * Column Info
	 * @param o2Bal
	 */
	public void setO2Bal(String o2Bal) {
		this.o2Bal = o2Bal;
	}
	
	/**
	 * Column Info
	 * @param cfmFlg
	 */
	public void setCfmFlg(String cfmFlg) {
		this.cfmFlg = cfmFlg;
	}
	
	/**
	 * Column Info
	 * @param f4Rto
	 */
	public void setF4Rto(String f4Rto) {
		this.f4Rto = f4Rto;
	}
	
	/**
	 * Column Info
	 * @param r2Rto
	 */
	public void setR2Rto(String r2Rto) {
		this.r2Rto = r2Rto;
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
	 * @param tgtYrwk
	 */
	public void setTgtYrwk(String tgtYrwk) {
		this.tgtYrwk = tgtYrwk;
	}
	
	/**
	 * Column Info
	 * @param r2Sts
	 */
	public void setR2Sts(String r2Sts) {
		this.r2Sts = r2Sts;
	}
	
	/**
	 * Column Info
	 * @param stsRmk
	 */
	public void setStsRmk(String stsRmk) {
		this.stsRmk = stsRmk;
	}
	
	/**
	 * Column Info
	 * @param f4Sts2
	 */
	public void setF4Sts2(String f4Sts2) {
		this.f4Sts2 = f4Sts2;
	}
	
	/**
	 * Column Info
	 * @param o4Sts2
	 */
	public void setO4Sts2(String o4Sts2) {
		this.o4Sts2 = o4Sts2;
	}
	
	/**
	 * Column Info
	 * @param scontiCd
	 */
	public void setScontiCd(String scontiCd) {
		this.scontiCd = scontiCd;
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
		setD4Bal(JSPUtil.getParameter(request, prefix + "d4_bal", ""));
		setO4Rto(JSPUtil.getParameter(request, prefix + "o4_rto", ""));
		setD4Sts2(JSPUtil.getParameter(request, prefix + "d4_sts2", ""));
		setR2Sts2(JSPUtil.getParameter(request, prefix + "r2_sts2", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setR5Bal(JSPUtil.getParameter(request, prefix + "r5_bal", ""));
		setD5Rto(JSPUtil.getParameter(request, prefix + "d5_rto", ""));
		setO2Rto(JSPUtil.getParameter(request, prefix + "o2_rto", ""));
		setO4Sts(JSPUtil.getParameter(request, prefix + "o4_sts", ""));
		setF4Sts(JSPUtil.getParameter(request, prefix + "f4_sts", ""));
		setO2Sts(JSPUtil.getParameter(request, prefix + "o2_sts", ""));
		setF2Sts2(JSPUtil.getParameter(request, prefix + "f2_sts2", ""));
		setD5Bal(JSPUtil.getParameter(request, prefix + "d5_bal", ""));
		setD5Sts(JSPUtil.getParameter(request, prefix + "d5_sts", ""));
		setD7Rto(JSPUtil.getParameter(request, prefix + "d7_rto", ""));
		setO2Sts2(JSPUtil.getParameter(request, prefix + "o2_sts2", ""));
		setD7Sts2(JSPUtil.getParameter(request, prefix + "d7_sts2", ""));
		setD4Rto(JSPUtil.getParameter(request, prefix + "d4_rto", ""));
		setD2Bal(JSPUtil.getParameter(request, prefix + "d2_bal", ""));
		setD7Bal(JSPUtil.getParameter(request, prefix + "d7_bal", ""));
		setD7Sts(JSPUtil.getParameter(request, prefix + "d7_sts", ""));
		setD2Rto(JSPUtil.getParameter(request, prefix + "d2_rto", ""));
		setScontiNm(JSPUtil.getParameter(request, prefix + "sconti_nm", ""));
		setO4Bal(JSPUtil.getParameter(request, prefix + "o4_bal", ""));
		setD2Sts2(JSPUtil.getParameter(request, prefix + "d2_sts2", ""));
		setD4Sts(JSPUtil.getParameter(request, prefix + "d4_sts", ""));
		setR5Sts2(JSPUtil.getParameter(request, prefix + "r5_sts2", ""));
		setR2Bal(JSPUtil.getParameter(request, prefix + "r2_bal", ""));
		setD2Sts(JSPUtil.getParameter(request, prefix + "d2_sts", ""));
		setD5Sts2(JSPUtil.getParameter(request, prefix + "d5_sts2", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setF2Sts(JSPUtil.getParameter(request, prefix + "f2_sts", ""));
		setR5Rto(JSPUtil.getParameter(request, prefix + "r5_rto", ""));
		setF2Rto(JSPUtil.getParameter(request, prefix + "f2_rto", ""));
		setR5Sts(JSPUtil.getParameter(request, prefix + "r5_sts", ""));
		setF4Bal(JSPUtil.getParameter(request, prefix + "f4_bal", ""));
		setF2Bal(JSPUtil.getParameter(request, prefix + "f2_bal", ""));
		setEccCd(JSPUtil.getParameter(request, prefix + "ecc_cd", ""));
		setRccCd(JSPUtil.getParameter(request, prefix + "rcc_cd", ""));
		setO2Bal(JSPUtil.getParameter(request, prefix + "o2_bal", ""));
		setCfmFlg(JSPUtil.getParameter(request, prefix + "cfm_flg", ""));
		setF4Rto(JSPUtil.getParameter(request, prefix + "f4_rto", ""));
		setR2Rto(JSPUtil.getParameter(request, prefix + "r2_rto", ""));
		setLccCd(JSPUtil.getParameter(request, prefix + "lcc_cd", ""));
		setTgtYrwk(JSPUtil.getParameter(request, prefix + "tgt_yrwk", ""));
		setR2Sts(JSPUtil.getParameter(request, prefix + "r2_sts", ""));
		setStsRmk(JSPUtil.getParameter(request, prefix + "sts_rmk", ""));
		setF4Sts2(JSPUtil.getParameter(request, prefix + "f4_sts2", ""));
		setO4Sts2(JSPUtil.getParameter(request, prefix + "o4_sts2", ""));
		setScontiCd(JSPUtil.getParameter(request, prefix + "sconti_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EQBalanceReportInputListVO[]
	 */
	public EQBalanceReportInputListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EQBalanceReportInputListVO[]
	 */
	public EQBalanceReportInputListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EQBalanceReportInputListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] d4Bal = (JSPUtil.getParameter(request, prefix	+ "d4_bal", length));
			String[] o4Rto = (JSPUtil.getParameter(request, prefix	+ "o4_rto", length));
			String[] d4Sts2 = (JSPUtil.getParameter(request, prefix	+ "d4_sts2", length));
			String[] r2Sts2 = (JSPUtil.getParameter(request, prefix	+ "r2_sts2", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] r5Bal = (JSPUtil.getParameter(request, prefix	+ "r5_bal", length));
			String[] d5Rto = (JSPUtil.getParameter(request, prefix	+ "d5_rto", length));
			String[] o2Rto = (JSPUtil.getParameter(request, prefix	+ "o2_rto", length));
			String[] o4Sts = (JSPUtil.getParameter(request, prefix	+ "o4_sts", length));
			String[] f4Sts = (JSPUtil.getParameter(request, prefix	+ "f4_sts", length));
			String[] o2Sts = (JSPUtil.getParameter(request, prefix	+ "o2_sts", length));
			String[] f2Sts2 = (JSPUtil.getParameter(request, prefix	+ "f2_sts2", length));
			String[] d5Bal = (JSPUtil.getParameter(request, prefix	+ "d5_bal", length));
			String[] d5Sts = (JSPUtil.getParameter(request, prefix	+ "d5_sts", length));
			String[] d7Rto = (JSPUtil.getParameter(request, prefix	+ "d7_rto", length));
			String[] o2Sts2 = (JSPUtil.getParameter(request, prefix	+ "o2_sts2", length));
			String[] d7Sts2 = (JSPUtil.getParameter(request, prefix	+ "d7_sts2", length));
			String[] d4Rto = (JSPUtil.getParameter(request, prefix	+ "d4_rto", length));
			String[] d2Bal = (JSPUtil.getParameter(request, prefix	+ "d2_bal", length));
			String[] d7Bal = (JSPUtil.getParameter(request, prefix	+ "d7_bal", length));
			String[] d7Sts = (JSPUtil.getParameter(request, prefix	+ "d7_sts", length));
			String[] d2Rto = (JSPUtil.getParameter(request, prefix	+ "d2_rto", length));
			String[] scontiNm = (JSPUtil.getParameter(request, prefix	+ "sconti_nm", length));
			String[] o4Bal = (JSPUtil.getParameter(request, prefix	+ "o4_bal", length));
			String[] d2Sts2 = (JSPUtil.getParameter(request, prefix	+ "d2_sts2", length));
			String[] d4Sts = (JSPUtil.getParameter(request, prefix	+ "d4_sts", length));
			String[] r5Sts2 = (JSPUtil.getParameter(request, prefix	+ "r5_sts2", length));
			String[] r2Bal = (JSPUtil.getParameter(request, prefix	+ "r2_bal", length));
			String[] d2Sts = (JSPUtil.getParameter(request, prefix	+ "d2_sts", length));
			String[] d5Sts2 = (JSPUtil.getParameter(request, prefix	+ "d5_sts2", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] f2Sts = (JSPUtil.getParameter(request, prefix	+ "f2_sts", length));
			String[] r5Rto = (JSPUtil.getParameter(request, prefix	+ "r5_rto", length));
			String[] f2Rto = (JSPUtil.getParameter(request, prefix	+ "f2_rto", length));
			String[] r5Sts = (JSPUtil.getParameter(request, prefix	+ "r5_sts", length));
			String[] f4Bal = (JSPUtil.getParameter(request, prefix	+ "f4_bal", length));
			String[] f2Bal = (JSPUtil.getParameter(request, prefix	+ "f2_bal", length));
			String[] eccCd = (JSPUtil.getParameter(request, prefix	+ "ecc_cd", length));
			String[] rccCd = (JSPUtil.getParameter(request, prefix	+ "rcc_cd", length));
			String[] o2Bal = (JSPUtil.getParameter(request, prefix	+ "o2_bal", length));
			String[] cfmFlg = (JSPUtil.getParameter(request, prefix	+ "cfm_flg", length));
			String[] f4Rto = (JSPUtil.getParameter(request, prefix	+ "f4_rto", length));
			String[] r2Rto = (JSPUtil.getParameter(request, prefix	+ "r2_rto", length));
			String[] lccCd = (JSPUtil.getParameter(request, prefix	+ "lcc_cd", length));
			String[] tgtYrwk = (JSPUtil.getParameter(request, prefix	+ "tgt_yrwk", length));
			String[] r2Sts = (JSPUtil.getParameter(request, prefix	+ "r2_sts", length));
			String[] stsRmk = (JSPUtil.getParameter(request, prefix	+ "sts_rmk", length));
			String[] f4Sts2 = (JSPUtil.getParameter(request, prefix	+ "f4_sts2", length));
			String[] o4Sts2 = (JSPUtil.getParameter(request, prefix	+ "o4_sts2", length));
			String[] scontiCd = (JSPUtil.getParameter(request, prefix	+ "sconti_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new EQBalanceReportInputListVO();
				if (d4Bal[i] != null)
					model.setD4Bal(d4Bal[i]);
				if (o4Rto[i] != null)
					model.setO4Rto(o4Rto[i]);
				if (d4Sts2[i] != null)
					model.setD4Sts2(d4Sts2[i]);
				if (r2Sts2[i] != null)
					model.setR2Sts2(r2Sts2[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (r5Bal[i] != null)
					model.setR5Bal(r5Bal[i]);
				if (d5Rto[i] != null)
					model.setD5Rto(d5Rto[i]);
				if (o2Rto[i] != null)
					model.setO2Rto(o2Rto[i]);
				if (o4Sts[i] != null)
					model.setO4Sts(o4Sts[i]);
				if (f4Sts[i] != null)
					model.setF4Sts(f4Sts[i]);
				if (o2Sts[i] != null)
					model.setO2Sts(o2Sts[i]);
				if (f2Sts2[i] != null)
					model.setF2Sts2(f2Sts2[i]);
				if (d5Bal[i] != null)
					model.setD5Bal(d5Bal[i]);
				if (d5Sts[i] != null)
					model.setD5Sts(d5Sts[i]);
				if (d7Rto[i] != null)
					model.setD7Rto(d7Rto[i]);
				if (o2Sts2[i] != null)
					model.setO2Sts2(o2Sts2[i]);
				if (d7Sts2[i] != null)
					model.setD7Sts2(d7Sts2[i]);
				if (d4Rto[i] != null)
					model.setD4Rto(d4Rto[i]);
				if (d2Bal[i] != null)
					model.setD2Bal(d2Bal[i]);
				if (d7Bal[i] != null)
					model.setD7Bal(d7Bal[i]);
				if (d7Sts[i] != null)
					model.setD7Sts(d7Sts[i]);
				if (d2Rto[i] != null)
					model.setD2Rto(d2Rto[i]);
				if (scontiNm[i] != null)
					model.setScontiNm(scontiNm[i]);
				if (o4Bal[i] != null)
					model.setO4Bal(o4Bal[i]);
				if (d2Sts2[i] != null)
					model.setD2Sts2(d2Sts2[i]);
				if (d4Sts[i] != null)
					model.setD4Sts(d4Sts[i]);
				if (r5Sts2[i] != null)
					model.setR5Sts2(r5Sts2[i]);
				if (r2Bal[i] != null)
					model.setR2Bal(r2Bal[i]);
				if (d2Sts[i] != null)
					model.setD2Sts(d2Sts[i]);
				if (d5Sts2[i] != null)
					model.setD5Sts2(d5Sts2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (f2Sts[i] != null)
					model.setF2Sts(f2Sts[i]);
				if (r5Rto[i] != null)
					model.setR5Rto(r5Rto[i]);
				if (f2Rto[i] != null)
					model.setF2Rto(f2Rto[i]);
				if (r5Sts[i] != null)
					model.setR5Sts(r5Sts[i]);
				if (f4Bal[i] != null)
					model.setF4Bal(f4Bal[i]);
				if (f2Bal[i] != null)
					model.setF2Bal(f2Bal[i]);
				if (eccCd[i] != null)
					model.setEccCd(eccCd[i]);
				if (rccCd[i] != null)
					model.setRccCd(rccCd[i]);
				if (o2Bal[i] != null)
					model.setO2Bal(o2Bal[i]);
				if (cfmFlg[i] != null)
					model.setCfmFlg(cfmFlg[i]);
				if (f4Rto[i] != null)
					model.setF4Rto(f4Rto[i]);
				if (r2Rto[i] != null)
					model.setR2Rto(r2Rto[i]);
				if (lccCd[i] != null)
					model.setLccCd(lccCd[i]);
				if (tgtYrwk[i] != null)
					model.setTgtYrwk(tgtYrwk[i]);
				if (r2Sts[i] != null)
					model.setR2Sts(r2Sts[i]);
				if (stsRmk[i] != null)
					model.setStsRmk(stsRmk[i]);
				if (f4Sts2[i] != null)
					model.setF4Sts2(f4Sts2[i]);
				if (o4Sts2[i] != null)
					model.setO4Sts2(o4Sts2[i]);
				if (scontiCd[i] != null)
					model.setScontiCd(scontiCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEQBalanceReportInputListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EQBalanceReportInputListVO[]
	 */
	public EQBalanceReportInputListVO[] getEQBalanceReportInputListVOs(){
		EQBalanceReportInputListVO[] vos = (EQBalanceReportInputListVO[])models.toArray(new EQBalanceReportInputListVO[models.size()]);
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
		this.d4Bal = this.d4Bal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o4Rto = this.o4Rto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4Sts2 = this.d4Sts2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r2Sts2 = this.r2Sts2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r5Bal = this.r5Bal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5Rto = this.d5Rto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o2Rto = this.o2Rto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o4Sts = this.o4Sts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f4Sts = this.f4Sts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o2Sts = this.o2Sts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f2Sts2 = this.f2Sts2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5Bal = this.d5Bal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5Sts = this.d5Sts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7Rto = this.d7Rto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o2Sts2 = this.o2Sts2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7Sts2 = this.d7Sts2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4Rto = this.d4Rto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2Bal = this.d2Bal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7Bal = this.d7Bal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7Sts = this.d7Sts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2Rto = this.d2Rto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scontiNm = this.scontiNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o4Bal = this.o4Bal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2Sts2 = this.d2Sts2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4Sts = this.d4Sts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r5Sts2 = this.r5Sts2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r2Bal = this.r2Bal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2Sts = this.d2Sts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5Sts2 = this.d5Sts2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f2Sts = this.f2Sts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r5Rto = this.r5Rto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f2Rto = this.f2Rto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r5Sts = this.r5Sts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f4Bal = this.f4Bal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f2Bal = this.f2Bal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eccCd = this.eccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccCd = this.rccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o2Bal = this.o2Bal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmFlg = this.cfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f4Rto = this.f4Rto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r2Rto = this.r2Rto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lccCd = this.lccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tgtYrwk = this.tgtYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r2Sts = this.r2Sts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsRmk = this.stsRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f4Sts2 = this.f4Sts2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o4Sts2 = this.o4Sts2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scontiCd = this.scontiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
