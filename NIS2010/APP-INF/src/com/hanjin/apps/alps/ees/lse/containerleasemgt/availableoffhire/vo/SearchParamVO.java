/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SearchParamVO.java
*@FileTitle : SearchParamVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.29
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2011.12.29 김종옥 
* 1.0 Creation
* 2014-08-11 길정권 [CHM-201431528] ALPS LSE-Office Hire 절차 변경(e-mail 기능 / Confirm 기능/LSO때 MST로 Interface하는 기능)
=========================================================*/

package com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchParamVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchParamVO> models = new ArrayList<SearchParamVO>();
	
	/* Column Info */
	private String complexPk11 = null;
	/* Column Info */
	private String complexPk10 = null;
	/* Column Info */
	private String complexPk2 = null;
	/* Column Info */
	private String complexPk13 = null;
	/* Column Info */
	private String complexPk12 = null;
	/* Column Info */
	private String complexPk15 = null;
	/* Column Info */
	private String endEstmDt = null;
	/* Column Info */
	private String complexPk14 = null;
	/* Column Info */
	private String usedDys = null;
	/* Column Info */
	private String complexPk6 = null;
	/* Column Info */
	private String complexPk5 = null;
	/* Column Info */
	private String complexPk4 = null;
	/* Column Info */
	private String complexPk3 = null;
	/* Column Info */
	private String complexPk9 = null;
	/* Column Info */
	private String complexPk8 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String complexPk7 = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String complexPk16 = null;
	/* Column Info */
	private String complexPk17 = null;
	/* Column Info */
	private String complexPk18 = null;
	/* Column Info */
	private String complexPk19 = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String dolTp = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String strEstmDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String locCase = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cnmvStsCd = null;
	/* Column Info */
	private String agmtCtyCd = null;
	/* Column Info */
	private String minOnhDysTp = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String complexPk = null;
	/* Column Info */
	private String locTp = null;
	/* Column Info */
	private String sentTp = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String freeDys = null;
	/* Column Info */
	private String estmTp = null;
	/* Column Info */
	private String ydTp = null;
	/* Column Info */
	private String cntrList = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchParamVO() {}

	public SearchParamVO(String ibflag, String pagerows, String strEstmDt, String endEstmDt, String usedDys, String creDt, String locCase, String cnmvStsCd, String locCd, String vvdCd, String agmtCtyCd, String cntrTpszCd, String minOnhDysTp, String portCd, String lstmCd, String updUsrId, String updDt, String locTp, String agmtSeq, String delCd, String sentTp, String dolTp, String ofcCd, String creUsrId, String slanCd, String ydCd, String freeDys, String vndrSeq, String estmTp, String ydTp, String complexPk, String complexPk2, String complexPk3, String complexPk4, String complexPk5, String complexPk6, String complexPk7, String complexPk8, String complexPk9, String complexPk10, String complexPk11, String complexPk12, String complexPk13, String complexPk14, String complexPk15, String complexPk16, String complexPk17, String complexPk18, String complexPk19, String cntrList) {
		this.complexPk11 = complexPk11;
		this.complexPk10 = complexPk10;
		this.complexPk2 = complexPk2;
		this.complexPk13 = complexPk13;
		this.complexPk12 = complexPk12;
		this.complexPk15 = complexPk15;
		this.endEstmDt = endEstmDt;
		this.complexPk14 = complexPk14;
		this.usedDys = usedDys;
		this.complexPk6 = complexPk6;
		this.complexPk5 = complexPk5;
		this.complexPk4 = complexPk4;
		this.complexPk3 = complexPk3;
		this.complexPk9 = complexPk9;
		this.complexPk8 = complexPk8;
		this.pagerows = pagerows;
		this.complexPk7 = complexPk7;
		this.locCd = locCd;
		this.vvdCd = vvdCd;
		this.cntrTpszCd = cntrTpszCd;
		this.complexPk16 = complexPk16;
		this.complexPk17 = complexPk17;
		this.complexPk18 = complexPk18;
		this.complexPk19 = complexPk19;
		this.lstmCd = lstmCd;
		this.updUsrId = updUsrId;
		this.agmtSeq = agmtSeq;
		this.delCd = delCd;
		this.dolTp = dolTp;
		this.creUsrId = creUsrId;
		this.vndrSeq = vndrSeq;
		this.strEstmDt = strEstmDt;
		this.creDt = creDt;
		this.locCase = locCase;
		this.ibflag = ibflag;
		this.cnmvStsCd = cnmvStsCd;
		this.agmtCtyCd = agmtCtyCd;
		this.minOnhDysTp = minOnhDysTp;
		this.portCd = portCd;
		this.updDt = updDt;
		this.complexPk = complexPk;
		this.locTp = locTp;
		this.sentTp = sentTp;
		this.ofcCd = ofcCd;
		this.slanCd = slanCd;
		this.ydCd = ydCd;
		this.freeDys = freeDys;
		this.estmTp = estmTp;
		this.ydTp = ydTp;
		this.cntrList = cntrList;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("complex_pk11", getComplexPk11());
		this.hashColumns.put("complex_pk10", getComplexPk10());
		this.hashColumns.put("complex_pk2", getComplexPk2());
		this.hashColumns.put("complex_pk13", getComplexPk13());
		this.hashColumns.put("complex_pk12", getComplexPk12());
		this.hashColumns.put("complex_pk15", getComplexPk15());
		this.hashColumns.put("end_estm_dt", getEndEstmDt());
		this.hashColumns.put("complex_pk14", getComplexPk14());
		this.hashColumns.put("used_dys", getUsedDys());
		this.hashColumns.put("complex_pk6", getComplexPk6());
		this.hashColumns.put("complex_pk5", getComplexPk5());
		this.hashColumns.put("complex_pk4", getComplexPk4());
		this.hashColumns.put("complex_pk3", getComplexPk3());
		this.hashColumns.put("complex_pk9", getComplexPk9());
		this.hashColumns.put("complex_pk8", getComplexPk8());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("complex_pk7", getComplexPk7());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("complex_pk16", getComplexPk16());
		this.hashColumns.put("complex_pk17", getComplexPk17());
		this.hashColumns.put("complex_pk18", getComplexPk18());
		this.hashColumns.put("complex_pk19", getComplexPk19());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("dol_tp", getDolTp());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("str_estm_dt", getStrEstmDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("loc_case", getLocCase());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());
		this.hashColumns.put("min_onh_dys_tp", getMinOnhDysTp());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("complex_pk", getComplexPk());
		this.hashColumns.put("loc_tp", getLocTp());
		this.hashColumns.put("sent_tp", getSentTp());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("free_dys", getFreeDys());
		this.hashColumns.put("estm_tp", getEstmTp());
		this.hashColumns.put("yd_tp", getYdTp());
		this.hashColumns.put("cntr_list", getCntrList());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("complex_pk11", "complexPk11");
		this.hashFields.put("complex_pk10", "complexPk10");
		this.hashFields.put("complex_pk2", "complexPk2");
		this.hashFields.put("complex_pk13", "complexPk13");
		this.hashFields.put("complex_pk12", "complexPk12");
		this.hashFields.put("complex_pk15", "complexPk15");
		this.hashFields.put("end_estm_dt", "endEstmDt");
		this.hashFields.put("complex_pk14", "complexPk14");
		this.hashFields.put("used_dys", "usedDys");
		this.hashFields.put("complex_pk6", "complexPk6");
		this.hashFields.put("complex_pk5", "complexPk5");
		this.hashFields.put("complex_pk4", "complexPk4");
		this.hashFields.put("complex_pk3", "complexPk3");
		this.hashFields.put("complex_pk9", "complexPk9");
		this.hashFields.put("complex_pk8", "complexPk8");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("complex_pk7", "complexPk7");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("complex_pk16", "complexPk16");
		this.hashFields.put("complex_pk17", "complexPk17");
		this.hashFields.put("complex_pk18", "complexPk18");
		this.hashFields.put("complex_pk19", "complexPk19");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("dol_tp", "dolTp");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("str_estm_dt", "strEstmDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("loc_case", "locCase");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("min_onh_dys_tp", "minOnhDysTp");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("complex_pk", "complexPk");
		this.hashFields.put("loc_tp", "locTp");
		this.hashFields.put("sent_tp", "sentTp");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("free_dys", "freeDys");
		this.hashFields.put("estm_tp", "estmTp");
		this.hashFields.put("yd_tp", "ydTp");
		this.hashFields.put("cntr_list", "cntrList");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return complexPk11
	 */
	public String getComplexPk11() {
		return this.complexPk11;
	}
	
	/**
	 * Column Info
	 * @return complexPk10
	 */
	public String getComplexPk10() {
		return this.complexPk10;
	}
	
	/**
	 * Column Info
	 * @return complexPk2
	 */
	public String getComplexPk2() {
		return this.complexPk2;
	}
	
	/**
	 * Column Info
	 * @return complexPk13
	 */
	public String getComplexPk13() {
		return this.complexPk13;
	}
	
	/**
	 * Column Info
	 * @return complexPk12
	 */
	public String getComplexPk12() {
		return this.complexPk12;
	}
	
	/**
	 * Column Info
	 * @return complexPk15
	 */
	public String getComplexPk15() {
		return this.complexPk15;
	}
	
	/**
	 * Column Info
	 * @return endEstmDt
	 */
	public String getEndEstmDt() {
		return this.endEstmDt;
	}
	
	/**
	 * Column Info
	 * @return complexPk14
	 */
	public String getComplexPk14() {
		return this.complexPk14;
	}
	
	/**
	 * Column Info
	 * @return usedDys
	 */
	public String getUsedDys() {
		return this.usedDys;
	}
	
	/**
	 * Column Info
	 * @return complexPk6
	 */
	public String getComplexPk6() {
		return this.complexPk6;
	}
	
	/**
	 * Column Info
	 * @return complexPk5
	 */
	public String getComplexPk5() {
		return this.complexPk5;
	}
	
	/**
	 * Column Info
	 * @return complexPk4
	 */
	public String getComplexPk4() {
		return this.complexPk4;
	}
	
	/**
	 * Column Info
	 * @return complexPk3
	 */
	public String getComplexPk3() {
		return this.complexPk3;
	}
	
	/**
	 * Column Info
	 * @return complexPk9
	 */
	public String getComplexPk9() {
		return this.complexPk9;
	}
	
	/**
	 * Column Info
	 * @return complexPk8
	 */
	public String getComplexPk8() {
		return this.complexPk8;
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
	 * @return complexPk7
	 */
	public String getComplexPk7() {
		return this.complexPk7;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
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
	 * @return complexPk16
	 */
	public String getComplexPk16() {
		return this.complexPk16;
	}
	
	/**
	 * Column Info
	 * @return complexPk17
	 */
	public String getComplexPk17() {
		return this.complexPk17;
	}
	
	/**
	 * Column Info
	 * @return complexPk18
	 */
	public String getComplexPk18() {
		return this.complexPk18;
	}
	
	/**
	 * Column Info
	 * @return complexPk19
	 */
	public String getComplexPk19() {
		return this.complexPk19;
	}
	
	/**
	 * Column Info
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
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
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return dolTp
	 */
	public String getDolTp() {
		return this.dolTp;
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return strEstmDt
	 */
	public String getStrEstmDt() {
		return this.strEstmDt;
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
	 * @return locCase
	 */
	public String getLocCase() {
		return this.locCase;
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
	 * @return cnmvStsCd
	 */
	public String getCnmvStsCd() {
		return this.cnmvStsCd;
	}
	
	/**
	 * Column Info
	 * @return agmtCtyCd
	 */
	public String getAgmtCtyCd() {
		return this.agmtCtyCd;
	}
	
	/**
	 * Column Info
	 * @return minOnhDysTp
	 */
	public String getMinOnhDysTp() {
		return this.minOnhDysTp;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
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
	 * @return complexPk
	 */
	public String getComplexPk() {
		return this.complexPk;
	}
	
	/**
	 * Column Info
	 * @return locTp
	 */
	public String getLocTp() {
		return this.locTp;
	}
	
	/**
	 * Column Info
	 * @return sentTp
	 */
	public String getSentTp() {
		return this.sentTp;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return freeDys
	 */
	public String getFreeDys() {
		return this.freeDys;
	}
	
	/**
	 * Column Info
	 * @return estmTp
	 */
	public String getEstmTp() {
		return this.estmTp;
	}
	
	/**
	 * Column Info
	 * @return ydTp
	 */
	public String getYdTp() {
		return this.ydTp;
	}
	
	/**
	 * Column Info
	 * @return cntrList
	 */
	public String getCntrList() {
		return this.cntrList;
	}
	

	/**
	 * Column Info
	 * @param complexPk11
	 */
	public void setComplexPk11(String complexPk11) {
		this.complexPk11 = complexPk11;
	}
	
	/**
	 * Column Info
	 * @param complexPk10
	 */
	public void setComplexPk10(String complexPk10) {
		this.complexPk10 = complexPk10;
	}
	
	/**
	 * Column Info
	 * @param complexPk2
	 */
	public void setComplexPk2(String complexPk2) {
		this.complexPk2 = complexPk2;
	}
	
	/**
	 * Column Info
	 * @param complexPk13
	 */
	public void setComplexPk13(String complexPk13) {
		this.complexPk13 = complexPk13;
	}
	
	/**
	 * Column Info
	 * @param complexPk12
	 */
	public void setComplexPk12(String complexPk12) {
		this.complexPk12 = complexPk12;
	}
	
	/**
	 * Column Info
	 * @param complexPk15
	 */
	public void setComplexPk15(String complexPk15) {
		this.complexPk15 = complexPk15;
	}
	
	/**
	 * Column Info
	 * @param endEstmDt
	 */
	public void setEndEstmDt(String endEstmDt) {
		this.endEstmDt = endEstmDt;
	}
	
	/**
	 * Column Info
	 * @param complexPk14
	 */
	public void setComplexPk14(String complexPk14) {
		this.complexPk14 = complexPk14;
	}
	
	/**
	 * Column Info
	 * @param usedDys
	 */
	public void setUsedDys(String usedDys) {
		this.usedDys = usedDys;
	}
	
	/**
	 * Column Info
	 * @param complexPk6
	 */
	public void setComplexPk6(String complexPk6) {
		this.complexPk6 = complexPk6;
	}
	
	/**
	 * Column Info
	 * @param complexPk5
	 */
	public void setComplexPk5(String complexPk5) {
		this.complexPk5 = complexPk5;
	}
	
	/**
	 * Column Info
	 * @param complexPk4
	 */
	public void setComplexPk4(String complexPk4) {
		this.complexPk4 = complexPk4;
	}
	
	/**
	 * Column Info
	 * @param complexPk3
	 */
	public void setComplexPk3(String complexPk3) {
		this.complexPk3 = complexPk3;
	}
	
	/**
	 * Column Info
	 * @param complexPk9
	 */
	public void setComplexPk9(String complexPk9) {
		this.complexPk9 = complexPk9;
	}
	
	/**
	 * Column Info
	 * @param complexPk8
	 */
	public void setComplexPk8(String complexPk8) {
		this.complexPk8 = complexPk8;
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
	 * @param complexPk7
	 */
	public void setComplexPk7(String complexPk7) {
		this.complexPk7 = complexPk7;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
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
	 * @param complexPk16
	 */
	public void setComplexPk16(String complexPk16) {
		this.complexPk16 = complexPk16;
	}
	
	/**
	 * Column Info
	 * @param complexPk17
	 */
	public void setComplexPk17(String complexPk17) {
		this.complexPk17 = complexPk17;
	}
	
	/**
	 * Column Info
	 * @param complexPk18
	 */
	public void setComplexPk18(String complexPk18) {
		this.complexPk18 = complexPk18;
	}
	
	/**
	 * Column Info
	 * @param complexPk19
	 */
	public void setComplexPk19(String complexPk19) {
		this.complexPk19 = complexPk19;
	}
	
	/**
	 * Column Info
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
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
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param dolTp
	 */
	public void setDolTp(String dolTp) {
		this.dolTp = dolTp;
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
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param strEstmDt
	 */
	public void setStrEstmDt(String strEstmDt) {
		this.strEstmDt = strEstmDt;
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
	 * @param locCase
	 */
	public void setLocCase(String locCase) {
		this.locCase = locCase;
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
	 * @param cnmvStsCd
	 */
	public void setCnmvStsCd(String cnmvStsCd) {
		this.cnmvStsCd = cnmvStsCd;
	}
	
	/**
	 * Column Info
	 * @param agmtCtyCd
	 */
	public void setAgmtCtyCd(String agmtCtyCd) {
		this.agmtCtyCd = agmtCtyCd;
	}
	
	/**
	 * Column Info
	 * @param minOnhDysTp
	 */
	public void setMinOnhDysTp(String minOnhDysTp) {
		this.minOnhDysTp = minOnhDysTp;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
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
	 * @param complexPk
	 */
	public void setComplexPk(String complexPk) {
		this.complexPk = complexPk;
	}
	
	/**
	 * Column Info
	 * @param locTp
	 */
	public void setLocTp(String locTp) {
		this.locTp = locTp;
	}
	
	/**
	 * Column Info
	 * @param sentTp
	 */
	public void setSentTp(String sentTp) {
		this.sentTp = sentTp;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param freeDys
	 */
	public void setFreeDys(String freeDys) {
		this.freeDys = freeDys;
	}
	
	/**
	 * Column Info
	 * @param estmTp
	 */
	public void setEstmTp(String estmTp) {
		this.estmTp = estmTp;
	}
	
	/**
	 * Column Info
	 * @param ydTp
	 */
	public void setYdTp(String ydTp) {
		this.ydTp = ydTp;
	}

	/**
	 * Column Info
	 * @param cntrList
	 */
	public void setCntrList(String cntrList) {
		this.cntrList = cntrList;
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
		setComplexPk11(JSPUtil.getParameter(request, prefix + "complex_pk11", ""));
		setComplexPk10(JSPUtil.getParameter(request, prefix + "complex_pk10", ""));
		setComplexPk2(JSPUtil.getParameter(request, prefix + "complex_pk2", ""));
		setComplexPk13(JSPUtil.getParameter(request, prefix + "complex_pk13", ""));
		setComplexPk12(JSPUtil.getParameter(request, prefix + "complex_pk12", ""));
		setComplexPk15(JSPUtil.getParameter(request, prefix + "complex_pk15", ""));
		setEndEstmDt(JSPUtil.getParameter(request, prefix + "end_estm_dt", ""));
		setComplexPk14(JSPUtil.getParameter(request, prefix + "complex_pk14", ""));
		setUsedDys(JSPUtil.getParameter(request, prefix + "used_dys", ""));
		setComplexPk6(JSPUtil.getParameter(request, prefix + "complex_pk6", ""));
		setComplexPk5(JSPUtil.getParameter(request, prefix + "complex_pk5", ""));
		setComplexPk4(JSPUtil.getParameter(request, prefix + "complex_pk4", ""));
		setComplexPk3(JSPUtil.getParameter(request, prefix + "complex_pk3", ""));
		setComplexPk9(JSPUtil.getParameter(request, prefix + "complex_pk9", ""));
		setComplexPk8(JSPUtil.getParameter(request, prefix + "complex_pk8", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setComplexPk7(JSPUtil.getParameter(request, prefix + "complex_pk7", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setComplexPk16(JSPUtil.getParameter(request, prefix + "complex_pk16", ""));
		setComplexPk17(JSPUtil.getParameter(request, prefix + "complex_pk17", ""));
		setComplexPk18(JSPUtil.getParameter(request, prefix + "complex_pk18", ""));
		setComplexPk19(JSPUtil.getParameter(request, prefix + "complex_pk19", ""));
		setLstmCd(JSPUtil.getParameter(request, prefix + "lstm_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setAgmtSeq(JSPUtil.getParameter(request, prefix + "agmt_seq", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setDolTp(JSPUtil.getParameter(request, prefix + "dol_tp", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setStrEstmDt(JSPUtil.getParameter(request, prefix + "str_estm_dt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setLocCase(JSPUtil.getParameter(request, prefix + "loc_case", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCnmvStsCd(JSPUtil.getParameter(request, prefix + "cnmv_sts_cd", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request, prefix + "agmt_cty_cd", ""));
		setMinOnhDysTp(JSPUtil.getParameter(request, prefix + "min_onh_dys_tp", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setComplexPk(JSPUtil.getParameter(request, prefix + "complex_pk", ""));
		setLocTp(JSPUtil.getParameter(request, prefix + "loc_tp", ""));
		setSentTp(JSPUtil.getParameter(request, prefix + "sent_tp", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setFreeDys(JSPUtil.getParameter(request, prefix + "free_dys", ""));
		setEstmTp(JSPUtil.getParameter(request, prefix + "estm_tp", ""));
		setYdTp(JSPUtil.getParameter(request, prefix + "yd_tp", ""));
		setCntrList(JSPUtil.getParameter(request, prefix + "cntr_list", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchParamVO[]
	 */
	public SearchParamVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchParamVO[]
	 */
	public SearchParamVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchParamVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] complexPk11 = (JSPUtil.getParameter(request, prefix	+ "complex_pk11", length));
			String[] complexPk10 = (JSPUtil.getParameter(request, prefix	+ "complex_pk10", length));
			String[] complexPk2 = (JSPUtil.getParameter(request, prefix	+ "complex_pk2", length));
			String[] complexPk13 = (JSPUtil.getParameter(request, prefix	+ "complex_pk13", length));
			String[] complexPk12 = (JSPUtil.getParameter(request, prefix	+ "complex_pk12", length));
			String[] complexPk15 = (JSPUtil.getParameter(request, prefix	+ "complex_pk15", length));
			String[] endEstmDt = (JSPUtil.getParameter(request, prefix	+ "end_estm_dt", length));
			String[] complexPk14 = (JSPUtil.getParameter(request, prefix	+ "complex_pk14", length));
			String[] usedDys = (JSPUtil.getParameter(request, prefix	+ "used_dys", length));
			String[] complexPk6 = (JSPUtil.getParameter(request, prefix	+ "complex_pk6", length));
			String[] complexPk5 = (JSPUtil.getParameter(request, prefix	+ "complex_pk5", length));
			String[] complexPk4 = (JSPUtil.getParameter(request, prefix	+ "complex_pk4", length));
			String[] complexPk3 = (JSPUtil.getParameter(request, prefix	+ "complex_pk3", length));
			String[] complexPk9 = (JSPUtil.getParameter(request, prefix	+ "complex_pk9", length));
			String[] complexPk8 = (JSPUtil.getParameter(request, prefix	+ "complex_pk8", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] complexPk7 = (JSPUtil.getParameter(request, prefix	+ "complex_pk7", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] complexPk16 = (JSPUtil.getParameter(request, prefix	+ "complex_pk16", length));
			String[] complexPk17 = (JSPUtil.getParameter(request, prefix	+ "complex_pk17", length));
			String[] complexPk18 = (JSPUtil.getParameter(request, prefix	+ "complex_pk18", length));
			String[] complexPk19 = (JSPUtil.getParameter(request, prefix	+ "complex_pk19", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] dolTp = (JSPUtil.getParameter(request, prefix	+ "dol_tp", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] strEstmDt = (JSPUtil.getParameter(request, prefix	+ "str_estm_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] locCase = (JSPUtil.getParameter(request, prefix	+ "loc_case", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cnmvStsCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_sts_cd", length));
			String[] agmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cty_cd", length));
			String[] minOnhDysTp = (JSPUtil.getParameter(request, prefix	+ "min_onh_dys_tp", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] complexPk = (JSPUtil.getParameter(request, prefix	+ "complex_pk", length));
			String[] locTp = (JSPUtil.getParameter(request, prefix	+ "loc_tp", length));
			String[] sentTp = (JSPUtil.getParameter(request, prefix	+ "sent_tp", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] freeDys = (JSPUtil.getParameter(request, prefix	+ "free_dys", length));
			String[] estmTp = (JSPUtil.getParameter(request, prefix	+ "estm_tp", length));
			String[] ydTp = (JSPUtil.getParameter(request, prefix	+ "yd_tp", length));
			String[] cntrList = (JSPUtil.getParameter(request, prefix	+ "cntr_list", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchParamVO();
				if (complexPk11[i] != null)
					model.setComplexPk11(complexPk11[i]);
				if (complexPk10[i] != null)
					model.setComplexPk10(complexPk10[i]);
				if (complexPk2[i] != null)
					model.setComplexPk2(complexPk2[i]);
				if (complexPk13[i] != null)
					model.setComplexPk13(complexPk13[i]);
				if (complexPk12[i] != null)
					model.setComplexPk12(complexPk12[i]);
				if (complexPk15[i] != null)
					model.setComplexPk15(complexPk15[i]);
				if (endEstmDt[i] != null)
					model.setEndEstmDt(endEstmDt[i]);
				if (complexPk14[i] != null)
					model.setComplexPk14(complexPk14[i]);
				if (usedDys[i] != null)
					model.setUsedDys(usedDys[i]);
				if (complexPk6[i] != null)
					model.setComplexPk6(complexPk6[i]);
				if (complexPk5[i] != null)
					model.setComplexPk5(complexPk5[i]);
				if (complexPk4[i] != null)
					model.setComplexPk4(complexPk4[i]);
				if (complexPk3[i] != null)
					model.setComplexPk3(complexPk3[i]);
				if (complexPk9[i] != null)
					model.setComplexPk9(complexPk9[i]);
				if (complexPk8[i] != null)
					model.setComplexPk8(complexPk8[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (complexPk7[i] != null)
					model.setComplexPk7(complexPk7[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (complexPk16[i] != null)
					model.setComplexPk16(complexPk16[i]);
				if (complexPk17[i] != null)
					model.setComplexPk17(complexPk17[i]);
				if (complexPk18[i] != null)
					model.setComplexPk18(complexPk18[i]);
				if (complexPk19[i] != null)
					model.setComplexPk19(complexPk19[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (dolTp[i] != null)
					model.setDolTp(dolTp[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (strEstmDt[i] != null)
					model.setStrEstmDt(strEstmDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (locCase[i] != null)
					model.setLocCase(locCase[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cnmvStsCd[i] != null)
					model.setCnmvStsCd(cnmvStsCd[i]);
				if (agmtCtyCd[i] != null)
					model.setAgmtCtyCd(agmtCtyCd[i]);
				if (minOnhDysTp[i] != null)
					model.setMinOnhDysTp(minOnhDysTp[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (complexPk[i] != null)
					model.setComplexPk(complexPk[i]);
				if (locTp[i] != null)
					model.setLocTp(locTp[i]);
				if (sentTp[i] != null)
					model.setSentTp(sentTp[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (freeDys[i] != null)
					model.setFreeDys(freeDys[i]);
				if (estmTp[i] != null)
					model.setEstmTp(estmTp[i]);
				if (ydTp[i] != null)
					model.setYdTp(ydTp[i]);
				if (cntrList[i] != null)
					model.setCntrList(cntrList[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchParamVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchParamVO[]
	 */
	public SearchParamVO[] getSearchParamVOs(){
		SearchParamVO[] vos = (SearchParamVO[])models.toArray(new SearchParamVO[models.size()]);
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
		this.complexPk11 = this.complexPk11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.complexPk10 = this.complexPk10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.complexPk2 = this.complexPk2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.complexPk13 = this.complexPk13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.complexPk12 = this.complexPk12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.complexPk15 = this.complexPk15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endEstmDt = this.endEstmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.complexPk14 = this.complexPk14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usedDys = this.usedDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.complexPk6 = this.complexPk6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.complexPk5 = this.complexPk5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.complexPk4 = this.complexPk4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.complexPk3 = this.complexPk3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.complexPk9 = this.complexPk9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.complexPk8 = this.complexPk8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.complexPk7 = this.complexPk7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.complexPk16 = this.complexPk16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.complexPk17 = this.complexPk17 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.complexPk18 = this.complexPk18 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.complexPk19 = this.complexPk19 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dolTp = this.dolTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.strEstmDt = this.strEstmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCase = this.locCase .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd = this.cnmvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd = this.agmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minOnhDysTp = this.minOnhDysTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.complexPk = this.complexPk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locTp = this.locTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sentTp = this.sentTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.freeDys = this.freeDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmTp = this.estmTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydTp = this.ydTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrList = this.cntrList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
