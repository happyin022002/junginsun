/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : OTSAgingBaseVO.java
 *@FileTitle : OTSAgingBaseVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.07.22
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.07.22  
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 * 
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OTSAgingBaseVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<OTSAgingBaseVO> models = new ArrayList<OTSAgingBaseVO>();

	/* Column Info */
	private String balUsdAmt = null;
	/* Column Info */
	private String sumTp = null;
	/* Column Info */
	private String balLoclAmt = null;
	/* Column Info */
	private String stlFlg = null;
	/* Column Info */
	private String bilToCustCntCd = null;
	/* Column Info */
	private String cltOfcCd = null;
	/* Column Info */
	private String rhq = null;
	/* Column Info */
	private String blInvTp = null;
	/* Column Info */
	private String obCnt = null;
	/* Column Info */
	private String blSumTp = null;
	/* Column Info */
	private String sailArrDt = null;
	/* Column Info */
	private String ibBalLoclAmt = null;
	/* Column Info */
	private String dueTp = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sumOfcCustTp = null;
	/* Column Info */
	private String obBalLoclAmt = null;
	/* Column Info */
	private String otsGrpTpCd = null;
	/* Column Info */
	private String ibBalUsdAmt = null;
	/* Column Info */
	private String otsSrcCd = null;
	/* Column Info */
	private String dueDt = null;
	/* Column Info */
	private String otsRtFlg = null;
	/* Column Info */
	private String totCnt = null;
	/* Column Info */
	private String obBalUsdAmt = null;
	/* Column Info */
	private String blCurrCd = null;
	/* Column Info */
	private String bilToCustSeq = null;
	/* Column Info */
	private String multiCltOfcCd = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String bk5 = null;
	/* Column Info */
	private String bk6 = null;
	/* Column Info */
	private String crMkFlg = null;
	/* Column Info */
	private String bk1 = null;
	/* Column Info */
	private String bk2 = null;
	/* Column Info */
	private String bk3 = null;
	/* Column Info */
	private String primaryKey = null;
	/* Column Info */
	private String bk4 = null;
	/* Column Info */
	private String ibCnt = null;

	/* 테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/* 테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

	public OTSAgingBaseVO() {
	}

	public OTSAgingBaseVO(String ibflag, String pagerows, String sailArrDt,
			String stlFlg, String crMkFlg, String otsGrpTpCd, String otsRtFlg,
			String dueDt, String dueTp, String otsSrcCd, String blSumTp,
			String blInvTp, String sumTp, String blCurrCd,
			String multiCltOfcCd, String sumOfcCustTp, String bk1, String bk2,
			String bk3, String bk4, String bk5, String bk6, String cltOfcCd,
			String rhq, String bilToCustCntCd, String bilToCustSeq,
			String primaryKey, String custLglEngNm, String ibCnt, String obCnt,
			String ibBalLoclAmt, String obBalLoclAmt, String ibBalUsdAmt,
			String obBalUsdAmt, String balLoclAmt, String balUsdAmt,
			String totCnt) {
		this.balUsdAmt = balUsdAmt;
		this.sumTp = sumTp;
		this.balLoclAmt = balLoclAmt;
		this.stlFlg = stlFlg;
		this.bilToCustCntCd = bilToCustCntCd;
		this.cltOfcCd = cltOfcCd;
		this.rhq = rhq;
		this.blInvTp = blInvTp;
		this.obCnt = obCnt;
		this.blSumTp = blSumTp;
		this.sailArrDt = sailArrDt;
		this.ibBalLoclAmt = ibBalLoclAmt;
		this.dueTp = dueTp;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.sumOfcCustTp = sumOfcCustTp;
		this.obBalLoclAmt = obBalLoclAmt;
		this.otsGrpTpCd = otsGrpTpCd;
		this.ibBalUsdAmt = ibBalUsdAmt;
		this.otsSrcCd = otsSrcCd;
		this.dueDt = dueDt;
		this.otsRtFlg = otsRtFlg;
		this.totCnt = totCnt;
		this.obBalUsdAmt = obBalUsdAmt;
		this.blCurrCd = blCurrCd;
		this.bilToCustSeq = bilToCustSeq;
		this.multiCltOfcCd = multiCltOfcCd;
		this.custLglEngNm = custLglEngNm;
		this.bk5 = bk5;
		this.bk6 = bk6;
		this.crMkFlg = crMkFlg;
		this.bk1 = bk1;
		this.bk2 = bk2;
		this.bk3 = bk3;
		this.primaryKey = primaryKey;
		this.bk4 = bk4;
		this.ibCnt = ibCnt;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * 
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues() {
		this.hashColumns.put("bal_usd_amt", getBalUsdAmt());
		this.hashColumns.put("sum_tp", getSumTp());
		this.hashColumns.put("bal_locl_amt", getBalLoclAmt());
		this.hashColumns.put("stl_flg", getStlFlg());
		this.hashColumns.put("bil_to_cust_cnt_cd", getBilToCustCntCd());
		this.hashColumns.put("clt_ofc_cd", getCltOfcCd());
		this.hashColumns.put("rhq", getRhq());
		this.hashColumns.put("bl_inv_tp", getBlInvTp());
		this.hashColumns.put("ob_cnt", getObCnt());
		this.hashColumns.put("bl_sum_tp", getBlSumTp());
		this.hashColumns.put("sail_arr_dt", getSailArrDt());
		this.hashColumns.put("ib_bal_locl_amt", getIbBalLoclAmt());
		this.hashColumns.put("due_tp", getDueTp());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sum_ofc_cust_tp", getSumOfcCustTp());
		this.hashColumns.put("ob_bal_locl_amt", getObBalLoclAmt());
		this.hashColumns.put("ots_grp_tp_cd", getOtsGrpTpCd());
		this.hashColumns.put("ib_bal_usd_amt", getIbBalUsdAmt());
		this.hashColumns.put("ots_src_cd", getOtsSrcCd());
		this.hashColumns.put("due_dt", getDueDt());
		this.hashColumns.put("ots_rt_flg", getOtsRtFlg());
		this.hashColumns.put("tot_cnt", getTotCnt());
		this.hashColumns.put("ob_bal_usd_amt", getObBalUsdAmt());
		this.hashColumns.put("bl_curr_cd", getBlCurrCd());
		this.hashColumns.put("bil_to_cust_seq", getBilToCustSeq());
		this.hashColumns.put("multi_clt_ofc_cd", getMultiCltOfcCd());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("bk5", getBk5());
		this.hashColumns.put("bk6", getBk6());
		this.hashColumns.put("cr_mk_flg", getCrMkFlg());
		this.hashColumns.put("bk1", getBk1());
		this.hashColumns.put("bk2", getBk2());
		this.hashColumns.put("bk3", getBk3());
		this.hashColumns.put("primary_key", getPrimaryKey());
		this.hashColumns.put("bk4", getBk4());
		this.hashColumns.put("ib_cnt", getIbCnt());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * 
	 * @return
	 */
	public HashMap<String, String> getFieldNames() {
		this.hashFields.put("bal_usd_amt", "balUsdAmt");
		this.hashFields.put("sum_tp", "sumTp");
		this.hashFields.put("bal_locl_amt", "balLoclAmt");
		this.hashFields.put("stl_flg", "stlFlg");
		this.hashFields.put("bil_to_cust_cnt_cd", "bilToCustCntCd");
		this.hashFields.put("clt_ofc_cd", "cltOfcCd");
		this.hashFields.put("rhq", "rhq");
		this.hashFields.put("bl_inv_tp", "blInvTp");
		this.hashFields.put("ob_cnt", "obCnt");
		this.hashFields.put("bl_sum_tp", "blSumTp");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("ib_bal_locl_amt", "ibBalLoclAmt");
		this.hashFields.put("due_tp", "dueTp");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sum_ofc_cust_tp", "sumOfcCustTp");
		this.hashFields.put("ob_bal_locl_amt", "obBalLoclAmt");
		this.hashFields.put("ots_grp_tp_cd", "otsGrpTpCd");
		this.hashFields.put("ib_bal_usd_amt", "ibBalUsdAmt");
		this.hashFields.put("ots_src_cd", "otsSrcCd");
		this.hashFields.put("due_dt", "dueDt");
		this.hashFields.put("ots_rt_flg", "otsRtFlg");
		this.hashFields.put("tot_cnt", "totCnt");
		this.hashFields.put("ob_bal_usd_amt", "obBalUsdAmt");
		this.hashFields.put("bl_curr_cd", "blCurrCd");
		this.hashFields.put("bil_to_cust_seq", "bilToCustSeq");
		this.hashFields.put("multi_clt_ofc_cd", "multiCltOfcCd");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("bk5", "bk5");
		this.hashFields.put("bk6", "bk6");
		this.hashFields.put("cr_mk_flg", "crMkFlg");
		this.hashFields.put("bk1", "bk1");
		this.hashFields.put("bk2", "bk2");
		this.hashFields.put("bk3", "bk3");
		this.hashFields.put("primary_key", "primaryKey");
		this.hashFields.put("bk4", "bk4");
		this.hashFields.put("ib_cnt", "ibCnt");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * 
	 * @return balUsdAmt
	 */
	public String getBalUsdAmt() {
		return this.balUsdAmt;
	}

	/**
	 * Column Info
	 * 
	 * @return sumTp
	 */
	public String getSumTp() {
		return this.sumTp;
	}

	/**
	 * Column Info
	 * 
	 * @return balLoclAmt
	 */
	public String getBalLoclAmt() {
		return this.balLoclAmt;
	}

	/**
	 * Column Info
	 * 
	 * @return stlFlg
	 */
	public String getStlFlg() {
		return this.stlFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return bilToCustCntCd
	 */
	public String getBilToCustCntCd() {
		return this.bilToCustCntCd;
	}

	/**
	 * Column Info
	 * 
	 * @return cltOfcCd
	 */
	public String getCltOfcCd() {
		return this.cltOfcCd;
	}

	/**
	 * Column Info
	 * 
	 * @return blInvTp
	 */
	public String getBlInvTp() {
		return this.blInvTp;
	}

	/**
	 * Column Info
	 * 
	 * @return obCnt
	 */
	public String getObCnt() {
		return this.obCnt;
	}

	/**
	 * Column Info
	 * 
	 * @return blSumTp
	 */
	public String getBlSumTp() {
		return this.blSumTp;
	}

	/**
	 * Column Info
	 * 
	 * @return sailArrDt
	 */
	public String getSailArrDt() {
		return this.sailArrDt;
	}

	/**
	 * Column Info
	 * 
	 * @return ibBalLoclAmt
	 */
	public String getIbBalLoclAmt() {
		return this.ibBalLoclAmt;
	}

	/**
	 * Column Info
	 * 
	 * @return dueTp
	 */
	public String getDueTp() {
		return this.dueTp;
	}

	/**
	 * Page Number
	 * 
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * 
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}

	/**
	 * Column Info
	 * 
	 * @return sumOfcCustTp
	 */
	public String getSumOfcCustTp() {
		return this.sumOfcCustTp;
	}

	/**
	 * Column Info
	 * 
	 * @return obBalLoclAmt
	 */
	public String getObBalLoclAmt() {
		return this.obBalLoclAmt;
	}

	/**
	 * Column Info
	 * 
	 * @return otsGrpTpCd
	 */
	public String getOtsGrpTpCd() {
		return this.otsGrpTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @return ibBalUsdAmt
	 */
	public String getIbBalUsdAmt() {
		return this.ibBalUsdAmt;
	}

	/**
	 * Column Info
	 * 
	 * @return otsSrcCd
	 */
	public String getOtsSrcCd() {
		return this.otsSrcCd;
	}

	/**
	 * Column Info
	 * 
	 * @return dueDt
	 */
	public String getDueDt() {
		return this.dueDt;
	}

	/**
	 * Column Info
	 * 
	 * @return otsRtFlg
	 */
	public String getOtsRtFlg() {
		return this.otsRtFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return totCnt
	 */
	public String getTotCnt() {
		return this.totCnt;
	}

	/**
	 * Column Info
	 * 
	 * @return obBalUsdAmt
	 */
	public String getObBalUsdAmt() {
		return this.obBalUsdAmt;
	}

	/**
	 * Column Info
	 * 
	 * @return blCurrCd
	 */
	public String getBlCurrCd() {
		return this.blCurrCd;
	}

	/**
	 * Column Info
	 * 
	 * @return bilToCustSeq
	 */
	public String getBilToCustSeq() {
		return this.bilToCustSeq;
	}

	/**
	 * Column Info
	 * 
	 * @return multiCltOfcCd
	 */
	public String getMultiCltOfcCd() {
		return this.multiCltOfcCd;
	}

	/**
	 * Column Info
	 * 
	 * @return custLglEngNm
	 */
	public String getCustLglEngNm() {
		return this.custLglEngNm;
	}

	/**
	 * Column Info
	 * 
	 * @return bk5
	 */
	public String getBk5() {
		return this.bk5;
	}

	/**
	 * Column Info
	 * 
	 * @return bk6
	 */
	public String getBk6() {
		return this.bk6;
	}

	/**
	 * Column Info
	 * 
	 * @return crMkFlg
	 */
	public String getCrMkFlg() {
		return this.crMkFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return bk1
	 */
	public String getBk1() {
		return this.bk1;
	}

	/**
	 * Column Info
	 * 
	 * @return bk2
	 */
	public String getBk2() {
		return this.bk2;
	}

	/**
	 * Column Info
	 * 
	 * @return bk3
	 */
	public String getBk3() {
		return this.bk3;
	}

	/**
	 * Column Info
	 * 
	 * @return primaryKey
	 */
	public String getPrimaryKey() {
		return this.primaryKey;
	}

	/**
	 * Column Info
	 * 
	 * @return bk4
	 */
	public String getBk4() {
		return this.bk4;
	}

	/**
	 * Column Info
	 * 
	 * @return ibCnt
	 */
	public String getIbCnt() {
		return this.ibCnt;
	}

	/**
	 * Column Info
	 * 
	 * @param balUsdAmt
	 */
	public void setBalUsdAmt(String balUsdAmt) {
		this.balUsdAmt = balUsdAmt;
	}

	/**
	 * Column Info
	 * 
	 * @param sumTp
	 */
	public void setSumTp(String sumTp) {
		this.sumTp = sumTp;
	}

	/**
	 * Column Info
	 * 
	 * @param balLoclAmt
	 */
	public void setBalLoclAmt(String balLoclAmt) {
		this.balLoclAmt = balLoclAmt;
	}

	/**
	 * Column Info
	 * 
	 * @param stlFlg
	 */
	public void setStlFlg(String stlFlg) {
		this.stlFlg = stlFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param bilToCustCntCd
	 */
	public void setBilToCustCntCd(String bilToCustCntCd) {
		this.bilToCustCntCd = bilToCustCntCd;
	}

	/**
	 * Column Info
	 * 
	 * @param cltOfcCd
	 */
	public void setCltOfcCd(String cltOfcCd) {
		this.cltOfcCd = cltOfcCd;
	}

	/**
	 * Column Info
	 * 
	 * @param blInvTp
	 */
	public void setBlInvTp(String blInvTp) {
		this.blInvTp = blInvTp;
	}

	/**
	 * Column Info
	 * 
	 * @param obCnt
	 */
	public void setObCnt(String obCnt) {
		this.obCnt = obCnt;
	}

	/**
	 * Column Info
	 * 
	 * @param blSumTp
	 */
	public void setBlSumTp(String blSumTp) {
		this.blSumTp = blSumTp;
	}

	/**
	 * Column Info
	 * 
	 * @param sailArrDt
	 */
	public void setSailArrDt(String sailArrDt) {
		this.sailArrDt = sailArrDt;
	}

	/**
	 * Column Info
	 * 
	 * @param ibBalLoclAmt
	 */
	public void setIbBalLoclAmt(String ibBalLoclAmt) {
		this.ibBalLoclAmt = ibBalLoclAmt;
	}

	/**
	 * Column Info
	 * 
	 * @param dueTp
	 */
	public void setDueTp(String dueTp) {
		this.dueTp = dueTp;
	}

	/**
	 * Page Number
	 * 
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * 
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	/**
	 * Column Info
	 * 
	 * @param sumOfcCustTp
	 */
	public void setSumOfcCustTp(String sumOfcCustTp) {
		this.sumOfcCustTp = sumOfcCustTp;
	}

	/**
	 * Column Info
	 * 
	 * @param obBalLoclAmt
	 */
	public void setObBalLoclAmt(String obBalLoclAmt) {
		this.obBalLoclAmt = obBalLoclAmt;
	}

	/**
	 * Column Info
	 * 
	 * @param otsGrpTpCd
	 */
	public void setOtsGrpTpCd(String otsGrpTpCd) {
		this.otsGrpTpCd = otsGrpTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @param ibBalUsdAmt
	 */
	public void setIbBalUsdAmt(String ibBalUsdAmt) {
		this.ibBalUsdAmt = ibBalUsdAmt;
	}

	/**
	 * Column Info
	 * 
	 * @param otsSrcCd
	 */
	public void setOtsSrcCd(String otsSrcCd) {
		this.otsSrcCd = otsSrcCd;
	}

	/**
	 * Column Info
	 * 
	 * @param dueDt
	 */
	public void setDueDt(String dueDt) {
		this.dueDt = dueDt;
	}

	/**
	 * Column Info
	 * 
	 * @param otsRtFlg
	 */
	public void setOtsRtFlg(String otsRtFlg) {
		this.otsRtFlg = otsRtFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param totCnt
	 */
	public void setTotCnt(String totCnt) {
		this.totCnt = totCnt;
	}

	/**
	 * Column Info
	 * 
	 * @param obBalUsdAmt
	 */
	public void setObBalUsdAmt(String obBalUsdAmt) {
		this.obBalUsdAmt = obBalUsdAmt;
	}

	/**
	 * Column Info
	 * 
	 * @param blCurrCd
	 */
	public void setBlCurrCd(String blCurrCd) {
		this.blCurrCd = blCurrCd;
	}

	/**
	 * Column Info
	 * 
	 * @param bilToCustSeq
	 */
	public void setBilToCustSeq(String bilToCustSeq) {
		this.bilToCustSeq = bilToCustSeq;
	}

	/**
	 * Column Info
	 * 
	 * @param multiCltOfcCd
	 */
	public void setMultiCltOfcCd(String multiCltOfcCd) {
		this.multiCltOfcCd = multiCltOfcCd;
	}

	/**
	 * Column Info
	 * 
	 * @param custLglEngNm
	 */
	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
	}

	/**
	 * Column Info
	 * 
	 * @param bk5
	 */
	public void setBk5(String bk5) {
		this.bk5 = bk5;
	}

	/**
	 * Column Info
	 * 
	 * @param bk6
	 */
	public void setBk6(String bk6) {
		this.bk6 = bk6;
	}

	/**
	 * Column Info
	 * 
	 * @param crMkFlg
	 */
	public void setCrMkFlg(String crMkFlg) {
		this.crMkFlg = crMkFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param bk1
	 */
	public void setBk1(String bk1) {
		this.bk1 = bk1;
	}

	/**
	 * Column Info
	 * 
	 * @param bk2
	 */
	public void setBk2(String bk2) {
		this.bk2 = bk2;
	}

	/**
	 * Column Info
	 * 
	 * @param bk3
	 */
	public void setBk3(String bk3) {
		this.bk3 = bk3;
	}

	/**
	 * Column Info
	 * 
	 * @param primaryKey
	 */
	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}

	/**
	 * Column Info
	 * 
	 * @param bk4
	 */
	public void setBk4(String bk4) {
		this.bk4 = bk4;
	}

	/**
	 * Column Info
	 * 
	 * @param ibCnt
	 */
	public void setIbCnt(String ibCnt) {
		this.ibCnt = ibCnt;
	}

	public String getRhq() {
		return rhq;
	}

	public void setRhq(String rhq) {
		this.rhq = rhq;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request, "");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setBalUsdAmt(JSPUtil.getParameter(request, prefix + "bal_usd_amt", ""));
		setSumTp(JSPUtil.getParameter(request, prefix + "sum_tp", ""));
		setBalLoclAmt(JSPUtil
				.getParameter(request, prefix + "bal_locl_amt", ""));
		setStlFlg(JSPUtil.getParameter(request, prefix + "stl_flg", ""));
		setBilToCustCntCd(JSPUtil.getParameter(request, prefix
				+ "bil_to_cust_cnt_cd", ""));
		setCltOfcCd(JSPUtil.getParameter(request, prefix + "clt_ofc_cd", ""));
		setRhq(JSPUtil.getParameter(request, prefix + "rhq", ""));
		setBlInvTp(JSPUtil.getParameter(request, prefix + "bl_inv_tp", ""));
		setObCnt(JSPUtil.getParameter(request, prefix + "ob_cnt", ""));
		setBlSumTp(JSPUtil.getParameter(request, prefix + "bl_sum_tp", ""));
		setSailArrDt(JSPUtil.getParameter(request, prefix + "sail_arr_dt", ""));
		setIbBalLoclAmt(JSPUtil.getParameter(request, prefix
				+ "ib_bal_locl_amt", ""));
		setDueTp(JSPUtil.getParameter(request, prefix + "due_tp", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSumOfcCustTp(JSPUtil.getParameter(request, prefix
				+ "sum_ofc_cust_tp", ""));
		setObBalLoclAmt(JSPUtil.getParameter(request, prefix
				+ "ob_bal_locl_amt", ""));
		setOtsGrpTpCd(JSPUtil.getParameter(request, prefix + "ots_grp_tp_cd",
				""));
		setIbBalUsdAmt(JSPUtil.getParameter(request, prefix + "ib_bal_usd_amt",
				""));
		setOtsSrcCd(JSPUtil.getParameter(request, prefix + "ots_src_cd", ""));
		setDueDt(JSPUtil.getParameter(request, prefix + "due_dt", ""));
		setOtsRtFlg(JSPUtil.getParameter(request, prefix + "ots_rt_flg", ""));
		setTotCnt(JSPUtil.getParameter(request, prefix + "tot_cnt", ""));
		setObBalUsdAmt(JSPUtil.getParameter(request, prefix + "ob_bal_usd_amt",
				""));
		setBlCurrCd(JSPUtil.getParameter(request, prefix + "bl_curr_cd", ""));
		setBilToCustSeq(JSPUtil.getParameter(request, prefix
				+ "bil_to_cust_seq", ""));
		setMultiCltOfcCd(JSPUtil.getParameter(request, prefix
				+ "multi_clt_ofc_cd", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix
				+ "cust_lgl_eng_nm", ""));
		setBk5(JSPUtil.getParameter(request, prefix + "bk5", ""));
		setBk6(JSPUtil.getParameter(request, prefix + "bk6", ""));
		setCrMkFlg(JSPUtil.getParameter(request, prefix + "cr_mk_flg", ""));
		setBk1(JSPUtil.getParameter(request, prefix + "bk1", ""));
		setBk2(JSPUtil.getParameter(request, prefix + "bk2", ""));
		setBk3(JSPUtil.getParameter(request, prefix + "bk3", ""));
		setPrimaryKey(JSPUtil.getParameter(request, prefix + "primary_key", ""));
		setBk4(JSPUtil.getParameter(request, prefix + "bk4", ""));
		setIbCnt(JSPUtil.getParameter(request, prefix + "ib_cnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * 
	 * @param request
	 * @return OTSAgingBaseVO[]
	 */
	public OTSAgingBaseVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * 
	 * @param request
	 * @param prefix
	 * @return OTSAgingBaseVO[]
	 */
	public OTSAgingBaseVO[] fromRequestGrid(HttpServletRequest request,
			String prefix) {
		OTSAgingBaseVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] balUsdAmt = (JSPUtil.getParameter(request, prefix
					+ "bal_usd_amt", length));
			String[] sumTp = (JSPUtil.getParameter(request, prefix + "sum_tp",
					length));
			String[] balLoclAmt = (JSPUtil.getParameter(request, prefix
					+ "bal_locl_amt", length));
			String[] stlFlg = (JSPUtil.getParameter(request,
					prefix + "stl_flg", length));
			String[] bilToCustCntCd = (JSPUtil.getParameter(request, prefix
					+ "bil_to_cust_cnt_cd", length));
			String[] cltOfcCd = (JSPUtil.getParameter(request, prefix
					+ "clt_ofc_cd", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix
					+ "rhq", length));
			String[] blInvTp = (JSPUtil.getParameter(request, prefix
					+ "bl_inv_tp", length));
			String[] obCnt = (JSPUtil.getParameter(request, prefix + "ob_cnt",
					length));
			String[] blSumTp = (JSPUtil.getParameter(request, prefix
					+ "bl_sum_tp", length));
			String[] sailArrDt = (JSPUtil.getParameter(request, prefix
					+ "sail_arr_dt", length));
			String[] ibBalLoclAmt = (JSPUtil.getParameter(request, prefix
					+ "ib_bal_locl_amt", length));
			String[] dueTp = (JSPUtil.getParameter(request, prefix + "due_tp",
					length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix
					+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag",
					length));
			String[] sumOfcCustTp = (JSPUtil.getParameter(request, prefix
					+ "sum_ofc_cust_tp", length));
			String[] obBalLoclAmt = (JSPUtil.getParameter(request, prefix
					+ "ob_bal_locl_amt", length));
			String[] otsGrpTpCd = (JSPUtil.getParameter(request, prefix
					+ "ots_grp_tp_cd", length));
			String[] ibBalUsdAmt = (JSPUtil.getParameter(request, prefix
					+ "ib_bal_usd_amt", length));
			String[] otsSrcCd = (JSPUtil.getParameter(request, prefix
					+ "ots_src_cd", length));
			String[] dueDt = (JSPUtil.getParameter(request, prefix + "due_dt",
					length));
			String[] otsRtFlg = (JSPUtil.getParameter(request, prefix
					+ "ots_rt_flg", length));
			String[] totCnt = (JSPUtil.getParameter(request,
					prefix + "tot_cnt", length));
			String[] obBalUsdAmt = (JSPUtil.getParameter(request, prefix
					+ "ob_bal_usd_amt", length));
			String[] blCurrCd = (JSPUtil.getParameter(request, prefix
					+ "bl_curr_cd", length));
			String[] bilToCustSeq = (JSPUtil.getParameter(request, prefix
					+ "bil_to_cust_seq", length));
			String[] multiCltOfcCd = (JSPUtil.getParameter(request, prefix
					+ "multi_clt_ofc_cd", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix
					+ "cust_lgl_eng_nm", length));
			String[] bk5 = (JSPUtil.getParameter(request, prefix + "bk5",
					length));
			String[] bk6 = (JSPUtil.getParameter(request, prefix + "bk6",
					length));
			String[] crMkFlg = (JSPUtil.getParameter(request, prefix
					+ "cr_mk_flg", length));
			String[] bk1 = (JSPUtil.getParameter(request, prefix + "bk1",
					length));
			String[] bk2 = (JSPUtil.getParameter(request, prefix + "bk2",
					length));
			String[] bk3 = (JSPUtil.getParameter(request, prefix + "bk3",
					length));
			String[] primaryKey = (JSPUtil.getParameter(request, prefix
					+ "primary_key", length));
			String[] bk4 = (JSPUtil.getParameter(request, prefix + "bk4",
					length));
			String[] ibCnt = (JSPUtil.getParameter(request, prefix + "ib_cnt",
					length));

			for (int i = 0; i < length; i++) {
				model = new OTSAgingBaseVO();
				if (balUsdAmt[i] != null)
					model.setBalUsdAmt(balUsdAmt[i]);
				if (sumTp[i] != null)
					model.setSumTp(sumTp[i]);
				if (balLoclAmt[i] != null)
					model.setBalLoclAmt(balLoclAmt[i]);
				if (stlFlg[i] != null)
					model.setStlFlg(stlFlg[i]);
				if (bilToCustCntCd[i] != null)
					model.setBilToCustCntCd(bilToCustCntCd[i]);
				if (cltOfcCd[i] != null)
					model.setCltOfcCd(cltOfcCd[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				if (blInvTp[i] != null)
					model.setBlInvTp(blInvTp[i]);
				if (obCnt[i] != null)
					model.setObCnt(obCnt[i]);
				if (blSumTp[i] != null)
					model.setBlSumTp(blSumTp[i]);
				if (sailArrDt[i] != null)
					model.setSailArrDt(sailArrDt[i]);
				if (ibBalLoclAmt[i] != null)
					model.setIbBalLoclAmt(ibBalLoclAmt[i]);
				if (dueTp[i] != null)
					model.setDueTp(dueTp[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sumOfcCustTp[i] != null)
					model.setSumOfcCustTp(sumOfcCustTp[i]);
				if (obBalLoclAmt[i] != null)
					model.setObBalLoclAmt(obBalLoclAmt[i]);
				if (otsGrpTpCd[i] != null)
					model.setOtsGrpTpCd(otsGrpTpCd[i]);
				if (ibBalUsdAmt[i] != null)
					model.setIbBalUsdAmt(ibBalUsdAmt[i]);
				if (otsSrcCd[i] != null)
					model.setOtsSrcCd(otsSrcCd[i]);
				if (dueDt[i] != null)
					model.setDueDt(dueDt[i]);
				if (otsRtFlg[i] != null)
					model.setOtsRtFlg(otsRtFlg[i]);
				if (totCnt[i] != null)
					model.setTotCnt(totCnt[i]);
				if (obBalUsdAmt[i] != null)
					model.setObBalUsdAmt(obBalUsdAmt[i]);
				if (blCurrCd[i] != null)
					model.setBlCurrCd(blCurrCd[i]);
				if (bilToCustSeq[i] != null)
					model.setBilToCustSeq(bilToCustSeq[i]);
				if (multiCltOfcCd[i] != null)
					model.setMultiCltOfcCd(multiCltOfcCd[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (bk5[i] != null)
					model.setBk5(bk5[i]);
				if (bk6[i] != null)
					model.setBk6(bk6[i]);
				if (crMkFlg[i] != null)
					model.setCrMkFlg(crMkFlg[i]);
				if (bk1[i] != null)
					model.setBk1(bk1[i]);
				if (bk2[i] != null)
					model.setBk2(bk2[i]);
				if (bk3[i] != null)
					model.setBk3(bk3[i]);
				if (primaryKey[i] != null)
					model.setPrimaryKey(primaryKey[i]);
				if (bk4[i] != null)
					model.setBk4(bk4[i]);
				if (ibCnt[i] != null)
					model.setIbCnt(ibCnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOTSAgingBaseVOs();
	}

	/**
	 * VO 배열을 반환
	 * 
	 * @return OTSAgingBaseVO[]
	 */
	public OTSAgingBaseVO[] getOTSAgingBaseVOs() {
		OTSAgingBaseVO[] vos = (OTSAgingBaseVO[]) models
				.toArray(new OTSAgingBaseVO[models.size()]);
		return vos;
	}

	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

	/**
	 * 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	 */
	public void unDataFormat() {
		this.balUsdAmt = this.balUsdAmt.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.sumTp = this.sumTp.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.balLoclAmt = this.balLoclAmt.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlFlg = this.stlFlg.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.bilToCustCntCd = this.bilToCustCntCd.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltOfcCd = this.cltOfcCd.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.blInvTp = this.blInvTp.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.obCnt = this.obCnt.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.blSumTp = this.blSumTp.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt = this.sailArrDt.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.ibBalLoclAmt = this.ibBalLoclAmt.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueTp = this.dueTp.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.sumOfcCustTp = this.sumOfcCustTp.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obBalLoclAmt = this.obBalLoclAmt.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsGrpTpCd = this.otsGrpTpCd.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibBalUsdAmt = this.ibBalUsdAmt.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsSrcCd = this.otsSrcCd.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.dueDt = this.dueDt.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.otsRtFlg = this.otsRtFlg.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.totCnt = this.totCnt.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.obBalUsdAmt = this.obBalUsdAmt.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCurrCd = this.blCurrCd.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.bilToCustSeq = this.bilToCustSeq.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.multiCltOfcCd = this.multiCltOfcCd.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bk5 = this.bk5.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.bk6 = this.bk6.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.crMkFlg = this.crMkFlg.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.bk1 = this.bk1.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.bk2 = this.bk2.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.bk3 = this.bk3.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.primaryKey = this.primaryKey.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bk4 = this.bk4.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.ibCnt = this.ibCnt.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
	}
}
