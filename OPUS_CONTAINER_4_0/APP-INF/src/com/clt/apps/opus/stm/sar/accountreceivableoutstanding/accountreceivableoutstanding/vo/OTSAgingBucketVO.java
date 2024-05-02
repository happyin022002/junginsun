/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : OTSAgingBucketVO.java
 *@FileTitle : OTSAgingBucketVO
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

public class OTSAgingBucketVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<OTSAgingBucketVO> models = new ArrayList<OTSAgingBucketVO>();

	/* Column Info */
	private String obBk6BalLoclAmt = null;
	/* Column Info */
	private String obBk5BalLoclAmt = null;
	/* Column Info */
	private String bilToCustCntCd = null;
	/* Column Info */
	private String stlFlg = null;
	/* Column Info */
	private String cltOfcCd = null;
	/* Column Info */
	private String rhq = null;
	/* Column Info */
	private String obBk5Cnt = null;
	/* Column Info */
	private String obBk4BalLoclAmt = null;
	/* Column Info */
	private String blInvTp = null;
	/* Column Info */
	private String blSumTp = null;
	/* Column Info */
	private String sailArrDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String totBk1Cnt = null;
	/* Column Info */
	private String obBk3BalLoclAmt = null;
	/* Column Info */
	private String totBk3BalUsdAmt = null;
	/* Column Info */
	private String ibBk3Cnt = null;
	/* Column Info */
	private String otsGrpTpCd = null;
	/* Column Info */
	private String totBk4BalLoclAmt = null;
	/* Column Info */
	private String otsSrcCd = null;
	/* Column Info */
	private String totBk6Cnt = null;
	/* Column Info */
	private String ibBk2BalLoclAmt = null;
	/* Column Info */
	private String obBk1Cnt = null;
	/* Column Info */
	private String totBk5BalLoclAmt = null;
	/* Column Info */
	private String bilToCustSeq = null;
	/* Column Info */
	private String obBk1BalLoclAmt = null;
	/* Column Info */
	private String totBk3Cnt = null;
	/* Column Info */
	private String obBk5BalUsdAmt = null;
	/* Column Info */
	private String ibBk3BalUsdAmt = null;
	/* Column Info */
	private String ibBk6BalLoclAmt = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String bk5 = null;
	/* Column Info */
	private String ibBk1Cnt = null;
	/* Column Info */
	private String bk6 = null;
	/* Column Info */
	private String ibBk6BalUsdAmt = null;
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
	private String obBk2BalUsdAmt = null;
	/* Column Info */
	private String ibBk4BalUsdAmt = null;
	/* Column Info */
	private String totBk5Cnt = null;
	/* Column Info */
	private String ibBk4BalLoclAmt = null;
	/* Column Info */
	private String totBk3BalLoclAmt = null;
	/* Column Info */
	private String totBk4BalUsdAmt = null;
	/* Column Info */
	private String obBk4Cnt = null;
	/* Column Info */
	private String sumTp = null;
	/* Column Info */
	private String ibBk2BalUsdAmt = null;
	/* Column Info */
	private String totBk4Cnt = null;
	/* Column Info */
	private String obBk2Cnt = null;
	/* Column Info */
	private String obBk1BalUsdAmt = null;
	/* Column Info */
	private String ibBk5BalUsdAmt = null;
	/* Column Info */
	private String ibBk5Cnt = null;
	/* Column Info */
	private String totBk2BalUsdAmt = null;
	/* Column Info */
	private String ibBk2Cnt = null;
	/* Column Info */
	private String obBk3BalUsdAmt = null;
	/* Column Info */
	private String obBk2BalLoclAmt = null;
	/* Column Info */
	private String totBk2BalLoclAmt = null;
	/* Column Info */
	private String ibBk1BalUsdAmt = null;
	/* Column Info */
	private String sumOfcCustTp = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String totBk6BalUsdAmt = null;
	/* Column Info */
	private String totBk6BalLoclAmt = null;
	/* Column Info */
	private String obBk3Cnt = null;
	/* Column Info */
	private String ibBk5BalLoclAmt = null;
	/* Column Info */
	private String ibBk3BalLoclAmt = null;
	/* Column Info */
	private String ibBk6Cnt = null;
	/* Column Info */
	private String totBk1BalLoclAmt = null;
	/* Column Info */
	private String dueDt = null;
	/* Column Info */
	private String otsRtFlg = null;
	/* Column Info */
	private String ibBk4Cnt = null;
	/* Column Info */
	private String obBk6BalUsdAmt = null;
	/* Column Info */
	private String ibBk1BalLoclAmt = null;
	/* Column Info */
	private String blCurrCd = null;
	/* Column Info */
	private String totBk5BalUsdAmt = null;
	/* Column Info */
	private String multiCltOfcCd = null;
	/* Column Info */
	private String obBk6Cnt = null;
	/* Column Info */
	private String obBk4BalUsdAmt = null;
	/* Column Info */
	private String totBk2Cnt = null;
	/* Column Info */
	private String totBk1BalUsdAmt = null;

	/* 테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/* 테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

	public OTSAgingBucketVO() {
	}

	public OTSAgingBucketVO(String ibflag, String pagerows, String sailArrDt,
			String stlFlg, String crMkFlg, String otsGrpTpCd, String otsRtFlg,
			String dueDt, String otsSrcCd, String blSumTp, String blInvTp,
			String sumTp, String blCurrCd, String multiCltOfcCd,
			String sumOfcCustTp, String bk1, String bk2, String bk3,
			String bk4, String bk5, String bk6, String cltOfcCd, String rhq,
			String bilToCustCntCd, String bilToCustSeq, String primaryKey,
			String custLglEngNm, String ibBk1Cnt, String obBk1Cnt,
			String totBk1Cnt, String ibBk1BalLoclAmt, String obBk1BalLoclAmt,
			String totBk1BalLoclAmt, String ibBk1BalUsdAmt,
			String obBk1BalUsdAmt, String totBk1BalUsdAmt, String ibBk2Cnt,
			String obBk2Cnt, String totBk2Cnt, String ibBk2BalLoclAmt,
			String obBk2BalLoclAmt, String totBk2BalLoclAmt,
			String ibBk2BalUsdAmt, String obBk2BalUsdAmt,
			String totBk2BalUsdAmt, String ibBk3Cnt, String obBk3Cnt,
			String totBk3Cnt, String ibBk3BalLoclAmt, String obBk3BalLoclAmt,
			String totBk3BalLoclAmt, String ibBk3BalUsdAmt,
			String obBk3BalUsdAmt, String totBk3BalUsdAmt, String ibBk4Cnt,
			String obBk4Cnt, String totBk4Cnt, String ibBk4BalLoclAmt,
			String obBk4BalLoclAmt, String totBk4BalLoclAmt,
			String ibBk4BalUsdAmt, String obBk4BalUsdAmt,
			String totBk4BalUsdAmt, String ibBk5Cnt, String obBk5Cnt,
			String totBk5Cnt, String ibBk5BalLoclAmt, String obBk5BalLoclAmt,
			String totBk5BalLoclAmt, String ibBk5BalUsdAmt,
			String obBk5BalUsdAmt, String totBk5BalUsdAmt, String ibBk6Cnt,
			String obBk6Cnt, String totBk6Cnt, String ibBk6BalLoclAmt,
			String obBk6BalLoclAmt, String totBk6BalLoclAmt,
			String ibBk6BalUsdAmt, String obBk6BalUsdAmt, String totBk6BalUsdAmt) {
		this.obBk6BalLoclAmt = obBk6BalLoclAmt;
		this.obBk5BalLoclAmt = obBk5BalLoclAmt;
		this.bilToCustCntCd = bilToCustCntCd;
		this.stlFlg = stlFlg;
		this.cltOfcCd = cltOfcCd;
		this.rhq = rhq;
		this.obBk5Cnt = obBk5Cnt;
		this.obBk4BalLoclAmt = obBk4BalLoclAmt;
		this.blInvTp = blInvTp;
		this.blSumTp = blSumTp;
		this.sailArrDt = sailArrDt;
		this.pagerows = pagerows;
		this.totBk1Cnt = totBk1Cnt;
		this.obBk3BalLoclAmt = obBk3BalLoclAmt;
		this.totBk3BalUsdAmt = totBk3BalUsdAmt;
		this.ibBk3Cnt = ibBk3Cnt;
		this.otsGrpTpCd = otsGrpTpCd;
		this.totBk4BalLoclAmt = totBk4BalLoclAmt;
		this.otsSrcCd = otsSrcCd;
		this.totBk6Cnt = totBk6Cnt;
		this.ibBk2BalLoclAmt = ibBk2BalLoclAmt;
		this.obBk1Cnt = obBk1Cnt;
		this.totBk5BalLoclAmt = totBk5BalLoclAmt;
		this.bilToCustSeq = bilToCustSeq;
		this.obBk1BalLoclAmt = obBk1BalLoclAmt;
		this.totBk3Cnt = totBk3Cnt;
		this.obBk5BalUsdAmt = obBk5BalUsdAmt;
		this.ibBk3BalUsdAmt = ibBk3BalUsdAmt;
		this.ibBk6BalLoclAmt = ibBk6BalLoclAmt;
		this.custLglEngNm = custLglEngNm;
		this.bk5 = bk5;
		this.ibBk1Cnt = ibBk1Cnt;
		this.bk6 = bk6;
		this.ibBk6BalUsdAmt = ibBk6BalUsdAmt;
		this.crMkFlg = crMkFlg;
		this.bk1 = bk1;
		this.bk2 = bk2;
		this.bk3 = bk3;
		this.primaryKey = primaryKey;
		this.bk4 = bk4;
		this.obBk2BalUsdAmt = obBk2BalUsdAmt;
		this.ibBk4BalUsdAmt = ibBk4BalUsdAmt;
		this.totBk5Cnt = totBk5Cnt;
		this.ibBk4BalLoclAmt = ibBk4BalLoclAmt;
		this.totBk3BalLoclAmt = totBk3BalLoclAmt;
		this.totBk4BalUsdAmt = totBk4BalUsdAmt;
		this.obBk4Cnt = obBk4Cnt;
		this.sumTp = sumTp;
		this.ibBk2BalUsdAmt = ibBk2BalUsdAmt;
		this.totBk4Cnt = totBk4Cnt;
		this.obBk2Cnt = obBk2Cnt;
		this.obBk1BalUsdAmt = obBk1BalUsdAmt;
		this.ibBk5BalUsdAmt = ibBk5BalUsdAmt;
		this.ibBk5Cnt = ibBk5Cnt;
		this.totBk2BalUsdAmt = totBk2BalUsdAmt;
		this.ibBk2Cnt = ibBk2Cnt;
		this.obBk3BalUsdAmt = obBk3BalUsdAmt;
		this.obBk2BalLoclAmt = obBk2BalLoclAmt;
		this.totBk2BalLoclAmt = totBk2BalLoclAmt;
		this.ibBk1BalUsdAmt = ibBk1BalUsdAmt;
		this.sumOfcCustTp = sumOfcCustTp;
		this.ibflag = ibflag;
		this.totBk6BalUsdAmt = totBk6BalUsdAmt;
		this.totBk6BalLoclAmt = totBk6BalLoclAmt;
		this.obBk3Cnt = obBk3Cnt;
		this.ibBk5BalLoclAmt = ibBk5BalLoclAmt;
		this.ibBk3BalLoclAmt = ibBk3BalLoclAmt;
		this.ibBk6Cnt = ibBk6Cnt;
		this.totBk1BalLoclAmt = totBk1BalLoclAmt;
		this.dueDt = dueDt;
		this.otsRtFlg = otsRtFlg;
		this.ibBk4Cnt = ibBk4Cnt;
		this.obBk6BalUsdAmt = obBk6BalUsdAmt;
		this.ibBk1BalLoclAmt = ibBk1BalLoclAmt;
		this.blCurrCd = blCurrCd;
		this.totBk5BalUsdAmt = totBk5BalUsdAmt;
		this.multiCltOfcCd = multiCltOfcCd;
		this.obBk6Cnt = obBk6Cnt;
		this.obBk4BalUsdAmt = obBk4BalUsdAmt;
		this.totBk2Cnt = totBk2Cnt;
		this.totBk1BalUsdAmt = totBk1BalUsdAmt;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * 
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues() {
		this.hashColumns.put("ob_bk6_bal_locl_amt", getObBk6BalLoclAmt());
		this.hashColumns.put("ob_bk5_bal_locl_amt", getObBk5BalLoclAmt());
		this.hashColumns.put("bil_to_cust_cnt_cd", getBilToCustCntCd());
		this.hashColumns.put("stl_flg", getStlFlg());
		this.hashColumns.put("clt_ofc_cd", getCltOfcCd());
		this.hashColumns.put("rhq", getRhq());
		this.hashColumns.put("ob_bk5_cnt", getObBk5Cnt());
		this.hashColumns.put("ob_bk4_bal_locl_amt", getObBk4BalLoclAmt());
		this.hashColumns.put("bl_inv_tp", getBlInvTp());
		this.hashColumns.put("bl_sum_tp", getBlSumTp());
		this.hashColumns.put("sail_arr_dt", getSailArrDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("tot_bk1_cnt", getTotBk1Cnt());
		this.hashColumns.put("ob_bk3_bal_locl_amt", getObBk3BalLoclAmt());
		this.hashColumns.put("tot_bk3_bal_usd_amt", getTotBk3BalUsdAmt());
		this.hashColumns.put("ib_bk3_cnt", getIbBk3Cnt());
		this.hashColumns.put("ots_grp_tp_cd", getOtsGrpTpCd());
		this.hashColumns.put("tot_bk4_bal_locl_amt", getTotBk4BalLoclAmt());
		this.hashColumns.put("ots_src_cd", getOtsSrcCd());
		this.hashColumns.put("tot_bk6_cnt", getTotBk6Cnt());
		this.hashColumns.put("ib_bk2_bal_locl_amt", getIbBk2BalLoclAmt());
		this.hashColumns.put("ob_bk1_cnt", getObBk1Cnt());
		this.hashColumns.put("tot_bk5_bal_locl_amt", getTotBk5BalLoclAmt());
		this.hashColumns.put("bil_to_cust_seq", getBilToCustSeq());
		this.hashColumns.put("ob_bk1_bal_locl_amt", getObBk1BalLoclAmt());
		this.hashColumns.put("tot_bk3_cnt", getTotBk3Cnt());
		this.hashColumns.put("ob_bk5_bal_usd_amt", getObBk5BalUsdAmt());
		this.hashColumns.put("ib_bk3_bal_usd_amt", getIbBk3BalUsdAmt());
		this.hashColumns.put("ib_bk6_bal_locl_amt", getIbBk6BalLoclAmt());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("bk5", getBk5());
		this.hashColumns.put("ib_bk1_cnt", getIbBk1Cnt());
		this.hashColumns.put("bk6", getBk6());
		this.hashColumns.put("ib_bk6_bal_usd_amt", getIbBk6BalUsdAmt());
		this.hashColumns.put("cr_mk_flg", getCrMkFlg());
		this.hashColumns.put("bk1", getBk1());
		this.hashColumns.put("bk2", getBk2());
		this.hashColumns.put("bk3", getBk3());
		this.hashColumns.put("primary_key", getPrimaryKey());
		this.hashColumns.put("bk4", getBk4());
		this.hashColumns.put("ob_bk2_bal_usd_amt", getObBk2BalUsdAmt());
		this.hashColumns.put("ib_bk4_bal_usd_amt", getIbBk4BalUsdAmt());
		this.hashColumns.put("tot_bk5_cnt", getTotBk5Cnt());
		this.hashColumns.put("ib_bk4_bal_locl_amt", getIbBk4BalLoclAmt());
		this.hashColumns.put("tot_bk3_bal_locl_amt", getTotBk3BalLoclAmt());
		this.hashColumns.put("tot_bk4_bal_usd_amt", getTotBk4BalUsdAmt());
		this.hashColumns.put("ob_bk4_cnt", getObBk4Cnt());
		this.hashColumns.put("sum_tp", getSumTp());
		this.hashColumns.put("ib_bk2_bal_usd_amt", getIbBk2BalUsdAmt());
		this.hashColumns.put("tot_bk4_cnt", getTotBk4Cnt());
		this.hashColumns.put("ob_bk2_cnt", getObBk2Cnt());
		this.hashColumns.put("ob_bk1_bal_usd_amt", getObBk1BalUsdAmt());
		this.hashColumns.put("ib_bk5_bal_usd_amt", getIbBk5BalUsdAmt());
		this.hashColumns.put("ib_bk5_cnt", getIbBk5Cnt());
		this.hashColumns.put("tot_bk2_bal_usd_amt", getTotBk2BalUsdAmt());
		this.hashColumns.put("ib_bk2_cnt", getIbBk2Cnt());
		this.hashColumns.put("ob_bk3_bal_usd_amt", getObBk3BalUsdAmt());
		this.hashColumns.put("ob_bk2_bal_locl_amt", getObBk2BalLoclAmt());
		this.hashColumns.put("tot_bk2_bal_locl_amt", getTotBk2BalLoclAmt());
		this.hashColumns.put("ib_bk1_bal_usd_amt", getIbBk1BalUsdAmt());
		this.hashColumns.put("sum_ofc_cust_tp", getSumOfcCustTp());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tot_bk6_bal_usd_amt", getTotBk6BalUsdAmt());
		this.hashColumns.put("tot_bk6_bal_locl_amt", getTotBk6BalLoclAmt());
		this.hashColumns.put("ob_bk3_cnt", getObBk3Cnt());
		this.hashColumns.put("ib_bk5_bal_locl_amt", getIbBk5BalLoclAmt());
		this.hashColumns.put("ib_bk3_bal_locl_amt", getIbBk3BalLoclAmt());
		this.hashColumns.put("ib_bk6_cnt", getIbBk6Cnt());
		this.hashColumns.put("tot_bk1_bal_locl_amt", getTotBk1BalLoclAmt());
		this.hashColumns.put("due_dt", getDueDt());
		this.hashColumns.put("ots_rt_flg", getOtsRtFlg());
		this.hashColumns.put("ib_bk4_cnt", getIbBk4Cnt());
		this.hashColumns.put("ob_bk6_bal_usd_amt", getObBk6BalUsdAmt());
		this.hashColumns.put("ib_bk1_bal_locl_amt", getIbBk1BalLoclAmt());
		this.hashColumns.put("bl_curr_cd", getBlCurrCd());
		this.hashColumns.put("tot_bk5_bal_usd_amt", getTotBk5BalUsdAmt());
		this.hashColumns.put("multi_clt_ofc_cd", getMultiCltOfcCd());
		this.hashColumns.put("ob_bk6_cnt", getObBk6Cnt());
		this.hashColumns.put("ob_bk4_bal_usd_amt", getObBk4BalUsdAmt());
		this.hashColumns.put("tot_bk2_cnt", getTotBk2Cnt());
		this.hashColumns.put("tot_bk1_bal_usd_amt", getTotBk1BalUsdAmt());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * 
	 * @return
	 */
	public HashMap<String, String> getFieldNames() {
		this.hashFields.put("ob_bk6_bal_locl_amt", "obBk6BalLoclAmt");
		this.hashFields.put("ob_bk5_bal_locl_amt", "obBk5BalLoclAmt");
		this.hashFields.put("bil_to_cust_cnt_cd", "bilToCustCntCd");
		this.hashFields.put("stl_flg", "stlFlg");
		this.hashFields.put("clt_ofc_cd", "cltOfcCd");
		this.hashFields.put("rhq", "rhq");
		this.hashFields.put("ob_bk5_cnt", "obBk5Cnt");
		this.hashFields.put("ob_bk4_bal_locl_amt", "obBk4BalLoclAmt");
		this.hashFields.put("bl_inv_tp", "blInvTp");
		this.hashFields.put("bl_sum_tp", "blSumTp");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("tot_bk1_cnt", "totBk1Cnt");
		this.hashFields.put("ob_bk3_bal_locl_amt", "obBk3BalLoclAmt");
		this.hashFields.put("tot_bk3_bal_usd_amt", "totBk3BalUsdAmt");
		this.hashFields.put("ib_bk3_cnt", "ibBk3Cnt");
		this.hashFields.put("ots_grp_tp_cd", "otsGrpTpCd");
		this.hashFields.put("tot_bk4_bal_locl_amt", "totBk4BalLoclAmt");
		this.hashFields.put("ots_src_cd", "otsSrcCd");
		this.hashFields.put("tot_bk6_cnt", "totBk6Cnt");
		this.hashFields.put("ib_bk2_bal_locl_amt", "ibBk2BalLoclAmt");
		this.hashFields.put("ob_bk1_cnt", "obBk1Cnt");
		this.hashFields.put("tot_bk5_bal_locl_amt", "totBk5BalLoclAmt");
		this.hashFields.put("bil_to_cust_seq", "bilToCustSeq");
		this.hashFields.put("ob_bk1_bal_locl_amt", "obBk1BalLoclAmt");
		this.hashFields.put("tot_bk3_cnt", "totBk3Cnt");
		this.hashFields.put("ob_bk5_bal_usd_amt", "obBk5BalUsdAmt");
		this.hashFields.put("ib_bk3_bal_usd_amt", "ibBk3BalUsdAmt");
		this.hashFields.put("ib_bk6_bal_locl_amt", "ibBk6BalLoclAmt");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("bk5", "bk5");
		this.hashFields.put("ib_bk1_cnt", "ibBk1Cnt");
		this.hashFields.put("bk6", "bk6");
		this.hashFields.put("ib_bk6_bal_usd_amt", "ibBk6BalUsdAmt");
		this.hashFields.put("cr_mk_flg", "crMkFlg");
		this.hashFields.put("bk1", "bk1");
		this.hashFields.put("bk2", "bk2");
		this.hashFields.put("bk3", "bk3");
		this.hashFields.put("primary_key", "primaryKey");
		this.hashFields.put("bk4", "bk4");
		this.hashFields.put("ob_bk2_bal_usd_amt", "obBk2BalUsdAmt");
		this.hashFields.put("ib_bk4_bal_usd_amt", "ibBk4BalUsdAmt");
		this.hashFields.put("tot_bk5_cnt", "totBk5Cnt");
		this.hashFields.put("ib_bk4_bal_locl_amt", "ibBk4BalLoclAmt");
		this.hashFields.put("tot_bk3_bal_locl_amt", "totBk3BalLoclAmt");
		this.hashFields.put("tot_bk4_bal_usd_amt", "totBk4BalUsdAmt");
		this.hashFields.put("ob_bk4_cnt", "obBk4Cnt");
		this.hashFields.put("sum_tp", "sumTp");
		this.hashFields.put("ib_bk2_bal_usd_amt", "ibBk2BalUsdAmt");
		this.hashFields.put("tot_bk4_cnt", "totBk4Cnt");
		this.hashFields.put("ob_bk2_cnt", "obBk2Cnt");
		this.hashFields.put("ob_bk1_bal_usd_amt", "obBk1BalUsdAmt");
		this.hashFields.put("ib_bk5_bal_usd_amt", "ibBk5BalUsdAmt");
		this.hashFields.put("ib_bk5_cnt", "ibBk5Cnt");
		this.hashFields.put("tot_bk2_bal_usd_amt", "totBk2BalUsdAmt");
		this.hashFields.put("ib_bk2_cnt", "ibBk2Cnt");
		this.hashFields.put("ob_bk3_bal_usd_amt", "obBk3BalUsdAmt");
		this.hashFields.put("ob_bk2_bal_locl_amt", "obBk2BalLoclAmt");
		this.hashFields.put("tot_bk2_bal_locl_amt", "totBk2BalLoclAmt");
		this.hashFields.put("ib_bk1_bal_usd_amt", "ibBk1BalUsdAmt");
		this.hashFields.put("sum_ofc_cust_tp", "sumOfcCustTp");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tot_bk6_bal_usd_amt", "totBk6BalUsdAmt");
		this.hashFields.put("tot_bk6_bal_locl_amt", "totBk6BalLoclAmt");
		this.hashFields.put("ob_bk3_cnt", "obBk3Cnt");
		this.hashFields.put("ib_bk5_bal_locl_amt", "ibBk5BalLoclAmt");
		this.hashFields.put("ib_bk3_bal_locl_amt", "ibBk3BalLoclAmt");
		this.hashFields.put("ib_bk6_cnt", "ibBk6Cnt");
		this.hashFields.put("tot_bk1_bal_locl_amt", "totBk1BalLoclAmt");
		this.hashFields.put("due_dt", "dueDt");
		this.hashFields.put("ots_rt_flg", "otsRtFlg");
		this.hashFields.put("ib_bk4_cnt", "ibBk4Cnt");
		this.hashFields.put("ob_bk6_bal_usd_amt", "obBk6BalUsdAmt");
		this.hashFields.put("ib_bk1_bal_locl_amt", "ibBk1BalLoclAmt");
		this.hashFields.put("bl_curr_cd", "blCurrCd");
		this.hashFields.put("tot_bk5_bal_usd_amt", "totBk5BalUsdAmt");
		this.hashFields.put("multi_clt_ofc_cd", "multiCltOfcCd");
		this.hashFields.put("ob_bk6_cnt", "obBk6Cnt");
		this.hashFields.put("ob_bk4_bal_usd_amt", "obBk4BalUsdAmt");
		this.hashFields.put("tot_bk2_cnt", "totBk2Cnt");
		this.hashFields.put("tot_bk1_bal_usd_amt", "totBk1BalUsdAmt");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * 
	 * @return obBk6BalLoclAmt
	 */
	public String getObBk6BalLoclAmt() {
		return this.obBk6BalLoclAmt;
	}

	/**
	 * Column Info
	 * 
	 * @return obBk5BalLoclAmt
	 */
	public String getObBk5BalLoclAmt() {
		return this.obBk5BalLoclAmt;
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
	 * @return stlFlg
	 */
	public String getStlFlg() {
		return this.stlFlg;
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
	 * @return obBk5Cnt
	 */
	public String getObBk5Cnt() {
		return this.obBk5Cnt;
	}

	/**
	 * Column Info
	 * 
	 * @return obBk4BalLoclAmt
	 */
	public String getObBk4BalLoclAmt() {
		return this.obBk4BalLoclAmt;
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
	 * Page Number
	 * 
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}

	/**
	 * Column Info
	 * 
	 * @return totBk1Cnt
	 */
	public String getTotBk1Cnt() {
		return this.totBk1Cnt;
	}

	/**
	 * Column Info
	 * 
	 * @return obBk3BalLoclAmt
	 */
	public String getObBk3BalLoclAmt() {
		return this.obBk3BalLoclAmt;
	}

	/**
	 * Column Info
	 * 
	 * @return totBk3BalUsdAmt
	 */
	public String getTotBk3BalUsdAmt() {
		return this.totBk3BalUsdAmt;
	}

	/**
	 * Column Info
	 * 
	 * @return ibBk3Cnt
	 */
	public String getIbBk3Cnt() {
		return this.ibBk3Cnt;
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
	 * @return totBk4BalLoclAmt
	 */
	public String getTotBk4BalLoclAmt() {
		return this.totBk4BalLoclAmt;
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
	 * @return totBk6Cnt
	 */
	public String getTotBk6Cnt() {
		return this.totBk6Cnt;
	}

	/**
	 * Column Info
	 * 
	 * @return ibBk2BalLoclAmt
	 */
	public String getIbBk2BalLoclAmt() {
		return this.ibBk2BalLoclAmt;
	}

	/**
	 * Column Info
	 * 
	 * @return obBk1Cnt
	 */
	public String getObBk1Cnt() {
		return this.obBk1Cnt;
	}

	/**
	 * Column Info
	 * 
	 * @return totBk5BalLoclAmt
	 */
	public String getTotBk5BalLoclAmt() {
		return this.totBk5BalLoclAmt;
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
	 * @return obBk1BalLoclAmt
	 */
	public String getObBk1BalLoclAmt() {
		return this.obBk1BalLoclAmt;
	}

	/**
	 * Column Info
	 * 
	 * @return totBk3Cnt
	 */
	public String getTotBk3Cnt() {
		return this.totBk3Cnt;
	}

	/**
	 * Column Info
	 * 
	 * @return obBk5BalUsdAmt
	 */
	public String getObBk5BalUsdAmt() {
		return this.obBk5BalUsdAmt;
	}

	/**
	 * Column Info
	 * 
	 * @return ibBk3BalUsdAmt
	 */
	public String getIbBk3BalUsdAmt() {
		return this.ibBk3BalUsdAmt;
	}

	/**
	 * Column Info
	 * 
	 * @return ibBk6BalLoclAmt
	 */
	public String getIbBk6BalLoclAmt() {
		return this.ibBk6BalLoclAmt;
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
	 * @return ibBk1Cnt
	 */
	public String getIbBk1Cnt() {
		return this.ibBk1Cnt;
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
	 * @return ibBk6BalUsdAmt
	 */
	public String getIbBk6BalUsdAmt() {
		return this.ibBk6BalUsdAmt;
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
	 * @return obBk2BalUsdAmt
	 */
	public String getObBk2BalUsdAmt() {
		return this.obBk2BalUsdAmt;
	}

	/**
	 * Column Info
	 * 
	 * @return ibBk4BalUsdAmt
	 */
	public String getIbBk4BalUsdAmt() {
		return this.ibBk4BalUsdAmt;
	}

	/**
	 * Column Info
	 * 
	 * @return totBk5Cnt
	 */
	public String getTotBk5Cnt() {
		return this.totBk5Cnt;
	}

	/**
	 * Column Info
	 * 
	 * @return ibBk4BalLoclAmt
	 */
	public String getIbBk4BalLoclAmt() {
		return this.ibBk4BalLoclAmt;
	}

	/**
	 * Column Info
	 * 
	 * @return totBk3BalLoclAmt
	 */
	public String getTotBk3BalLoclAmt() {
		return this.totBk3BalLoclAmt;
	}

	/**
	 * Column Info
	 * 
	 * @return totBk4BalUsdAmt
	 */
	public String getTotBk4BalUsdAmt() {
		return this.totBk4BalUsdAmt;
	}

	/**
	 * Column Info
	 * 
	 * @return obBk4Cnt
	 */
	public String getObBk4Cnt() {
		return this.obBk4Cnt;
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
	 * @return ibBk2BalUsdAmt
	 */
	public String getIbBk2BalUsdAmt() {
		return this.ibBk2BalUsdAmt;
	}

	/**
	 * Column Info
	 * 
	 * @return totBk4Cnt
	 */
	public String getTotBk4Cnt() {
		return this.totBk4Cnt;
	}

	/**
	 * Column Info
	 * 
	 * @return obBk2Cnt
	 */
	public String getObBk2Cnt() {
		return this.obBk2Cnt;
	}

	/**
	 * Column Info
	 * 
	 * @return obBk1BalUsdAmt
	 */
	public String getObBk1BalUsdAmt() {
		return this.obBk1BalUsdAmt;
	}

	/**
	 * Column Info
	 * 
	 * @return ibBk5BalUsdAmt
	 */
	public String getIbBk5BalUsdAmt() {
		return this.ibBk5BalUsdAmt;
	}

	/**
	 * Column Info
	 * 
	 * @return ibBk5Cnt
	 */
	public String getIbBk5Cnt() {
		return this.ibBk5Cnt;
	}

	/**
	 * Column Info
	 * 
	 * @return totBk2BalUsdAmt
	 */
	public String getTotBk2BalUsdAmt() {
		return this.totBk2BalUsdAmt;
	}

	/**
	 * Column Info
	 * 
	 * @return ibBk2Cnt
	 */
	public String getIbBk2Cnt() {
		return this.ibBk2Cnt;
	}

	/**
	 * Column Info
	 * 
	 * @return obBk3BalUsdAmt
	 */
	public String getObBk3BalUsdAmt() {
		return this.obBk3BalUsdAmt;
	}

	/**
	 * Column Info
	 * 
	 * @return obBk2BalLoclAmt
	 */
	public String getObBk2BalLoclAmt() {
		return this.obBk2BalLoclAmt;
	}

	/**
	 * Column Info
	 * 
	 * @return totBk2BalLoclAmt
	 */
	public String getTotBk2BalLoclAmt() {
		return this.totBk2BalLoclAmt;
	}

	/**
	 * Column Info
	 * 
	 * @return ibBk1BalUsdAmt
	 */
	public String getIbBk1BalUsdAmt() {
		return this.ibBk1BalUsdAmt;
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
	 * @return totBk6BalUsdAmt
	 */
	public String getTotBk6BalUsdAmt() {
		return this.totBk6BalUsdAmt;
	}

	/**
	 * Column Info
	 * 
	 * @return totBk6BalLoclAmt
	 */
	public String getTotBk6BalLoclAmt() {
		return this.totBk6BalLoclAmt;
	}

	/**
	 * Column Info
	 * 
	 * @return obBk3Cnt
	 */
	public String getObBk3Cnt() {
		return this.obBk3Cnt;
	}

	/**
	 * Column Info
	 * 
	 * @return ibBk5BalLoclAmt
	 */
	public String getIbBk5BalLoclAmt() {
		return this.ibBk5BalLoclAmt;
	}

	/**
	 * Column Info
	 * 
	 * @return ibBk3BalLoclAmt
	 */
	public String getIbBk3BalLoclAmt() {
		return this.ibBk3BalLoclAmt;
	}

	/**
	 * Column Info
	 * 
	 * @return ibBk6Cnt
	 */
	public String getIbBk6Cnt() {
		return this.ibBk6Cnt;
	}

	/**
	 * Column Info
	 * 
	 * @return totBk1BalLoclAmt
	 */
	public String getTotBk1BalLoclAmt() {
		return this.totBk1BalLoclAmt;
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
	 * @return ibBk4Cnt
	 */
	public String getIbBk4Cnt() {
		return this.ibBk4Cnt;
	}

	/**
	 * Column Info
	 * 
	 * @return obBk6BalUsdAmt
	 */
	public String getObBk6BalUsdAmt() {
		return this.obBk6BalUsdAmt;
	}

	/**
	 * Column Info
	 * 
	 * @return ibBk1BalLoclAmt
	 */
	public String getIbBk1BalLoclAmt() {
		return this.ibBk1BalLoclAmt;
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
	 * @return totBk5BalUsdAmt
	 */
	public String getTotBk5BalUsdAmt() {
		return this.totBk5BalUsdAmt;
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
	 * @return obBk6Cnt
	 */
	public String getObBk6Cnt() {
		return this.obBk6Cnt;
	}

	/**
	 * Column Info
	 * 
	 * @return obBk4BalUsdAmt
	 */
	public String getObBk4BalUsdAmt() {
		return this.obBk4BalUsdAmt;
	}

	/**
	 * Column Info
	 * 
	 * @return totBk2Cnt
	 */
	public String getTotBk2Cnt() {
		return this.totBk2Cnt;
	}

	/**
	 * Column Info
	 * 
	 * @return totBk1BalUsdAmt
	 */
	public String getTotBk1BalUsdAmt() {
		return this.totBk1BalUsdAmt;
	}

	/**
	 * Column Info
	 * 
	 * @param obBk6BalLoclAmt
	 */
	public void setObBk6BalLoclAmt(String obBk6BalLoclAmt) {
		this.obBk6BalLoclAmt = obBk6BalLoclAmt;
	}

	/**
	 * Column Info
	 * 
	 * @param obBk5BalLoclAmt
	 */
	public void setObBk5BalLoclAmt(String obBk5BalLoclAmt) {
		this.obBk5BalLoclAmt = obBk5BalLoclAmt;
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
	 * @param stlFlg
	 */
	public void setStlFlg(String stlFlg) {
		this.stlFlg = stlFlg;
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
	 * @param obBk5Cnt
	 */
	public void setObBk5Cnt(String obBk5Cnt) {
		this.obBk5Cnt = obBk5Cnt;
	}

	/**
	 * Column Info
	 * 
	 * @param obBk4BalLoclAmt
	 */
	public void setObBk4BalLoclAmt(String obBk4BalLoclAmt) {
		this.obBk4BalLoclAmt = obBk4BalLoclAmt;
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
	 * Page Number
	 * 
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	/**
	 * Column Info
	 * 
	 * @param totBk1Cnt
	 */
	public void setTotBk1Cnt(String totBk1Cnt) {
		this.totBk1Cnt = totBk1Cnt;
	}

	/**
	 * Column Info
	 * 
	 * @param obBk3BalLoclAmt
	 */
	public void setObBk3BalLoclAmt(String obBk3BalLoclAmt) {
		this.obBk3BalLoclAmt = obBk3BalLoclAmt;
	}

	/**
	 * Column Info
	 * 
	 * @param totBk3BalUsdAmt
	 */
	public void setTotBk3BalUsdAmt(String totBk3BalUsdAmt) {
		this.totBk3BalUsdAmt = totBk3BalUsdAmt;
	}

	/**
	 * Column Info
	 * 
	 * @param ibBk3Cnt
	 */
	public void setIbBk3Cnt(String ibBk3Cnt) {
		this.ibBk3Cnt = ibBk3Cnt;
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
	 * @param totBk4BalLoclAmt
	 */
	public void setTotBk4BalLoclAmt(String totBk4BalLoclAmt) {
		this.totBk4BalLoclAmt = totBk4BalLoclAmt;
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
	 * @param totBk6Cnt
	 */
	public void setTotBk6Cnt(String totBk6Cnt) {
		this.totBk6Cnt = totBk6Cnt;
	}

	/**
	 * Column Info
	 * 
	 * @param ibBk2BalLoclAmt
	 */
	public void setIbBk2BalLoclAmt(String ibBk2BalLoclAmt) {
		this.ibBk2BalLoclAmt = ibBk2BalLoclAmt;
	}

	/**
	 * Column Info
	 * 
	 * @param obBk1Cnt
	 */
	public void setObBk1Cnt(String obBk1Cnt) {
		this.obBk1Cnt = obBk1Cnt;
	}

	/**
	 * Column Info
	 * 
	 * @param totBk5BalLoclAmt
	 */
	public void setTotBk5BalLoclAmt(String totBk5BalLoclAmt) {
		this.totBk5BalLoclAmt = totBk5BalLoclAmt;
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
	 * @param obBk1BalLoclAmt
	 */
	public void setObBk1BalLoclAmt(String obBk1BalLoclAmt) {
		this.obBk1BalLoclAmt = obBk1BalLoclAmt;
	}

	/**
	 * Column Info
	 * 
	 * @param totBk3Cnt
	 */
	public void setTotBk3Cnt(String totBk3Cnt) {
		this.totBk3Cnt = totBk3Cnt;
	}

	/**
	 * Column Info
	 * 
	 * @param obBk5BalUsdAmt
	 */
	public void setObBk5BalUsdAmt(String obBk5BalUsdAmt) {
		this.obBk5BalUsdAmt = obBk5BalUsdAmt;
	}

	/**
	 * Column Info
	 * 
	 * @param ibBk3BalUsdAmt
	 */
	public void setIbBk3BalUsdAmt(String ibBk3BalUsdAmt) {
		this.ibBk3BalUsdAmt = ibBk3BalUsdAmt;
	}

	/**
	 * Column Info
	 * 
	 * @param ibBk6BalLoclAmt
	 */
	public void setIbBk6BalLoclAmt(String ibBk6BalLoclAmt) {
		this.ibBk6BalLoclAmt = ibBk6BalLoclAmt;
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
	 * @param ibBk1Cnt
	 */
	public void setIbBk1Cnt(String ibBk1Cnt) {
		this.ibBk1Cnt = ibBk1Cnt;
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
	 * @param ibBk6BalUsdAmt
	 */
	public void setIbBk6BalUsdAmt(String ibBk6BalUsdAmt) {
		this.ibBk6BalUsdAmt = ibBk6BalUsdAmt;
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
	 * @param obBk2BalUsdAmt
	 */
	public void setObBk2BalUsdAmt(String obBk2BalUsdAmt) {
		this.obBk2BalUsdAmt = obBk2BalUsdAmt;
	}

	/**
	 * Column Info
	 * 
	 * @param ibBk4BalUsdAmt
	 */
	public void setIbBk4BalUsdAmt(String ibBk4BalUsdAmt) {
		this.ibBk4BalUsdAmt = ibBk4BalUsdAmt;
	}

	/**
	 * Column Info
	 * 
	 * @param totBk5Cnt
	 */
	public void setTotBk5Cnt(String totBk5Cnt) {
		this.totBk5Cnt = totBk5Cnt;
	}

	/**
	 * Column Info
	 * 
	 * @param ibBk4BalLoclAmt
	 */
	public void setIbBk4BalLoclAmt(String ibBk4BalLoclAmt) {
		this.ibBk4BalLoclAmt = ibBk4BalLoclAmt;
	}

	/**
	 * Column Info
	 * 
	 * @param totBk3BalLoclAmt
	 */
	public void setTotBk3BalLoclAmt(String totBk3BalLoclAmt) {
		this.totBk3BalLoclAmt = totBk3BalLoclAmt;
	}

	/**
	 * Column Info
	 * 
	 * @param totBk4BalUsdAmt
	 */
	public void setTotBk4BalUsdAmt(String totBk4BalUsdAmt) {
		this.totBk4BalUsdAmt = totBk4BalUsdAmt;
	}

	/**
	 * Column Info
	 * 
	 * @param obBk4Cnt
	 */
	public void setObBk4Cnt(String obBk4Cnt) {
		this.obBk4Cnt = obBk4Cnt;
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
	 * @param ibBk2BalUsdAmt
	 */
	public void setIbBk2BalUsdAmt(String ibBk2BalUsdAmt) {
		this.ibBk2BalUsdAmt = ibBk2BalUsdAmt;
	}

	/**
	 * Column Info
	 * 
	 * @param totBk4Cnt
	 */
	public void setTotBk4Cnt(String totBk4Cnt) {
		this.totBk4Cnt = totBk4Cnt;
	}

	/**
	 * Column Info
	 * 
	 * @param obBk2Cnt
	 */
	public void setObBk2Cnt(String obBk2Cnt) {
		this.obBk2Cnt = obBk2Cnt;
	}

	/**
	 * Column Info
	 * 
	 * @param obBk1BalUsdAmt
	 */
	public void setObBk1BalUsdAmt(String obBk1BalUsdAmt) {
		this.obBk1BalUsdAmt = obBk1BalUsdAmt;
	}

	/**
	 * Column Info
	 * 
	 * @param ibBk5BalUsdAmt
	 */
	public void setIbBk5BalUsdAmt(String ibBk5BalUsdAmt) {
		this.ibBk5BalUsdAmt = ibBk5BalUsdAmt;
	}

	/**
	 * Column Info
	 * 
	 * @param ibBk5Cnt
	 */
	public void setIbBk5Cnt(String ibBk5Cnt) {
		this.ibBk5Cnt = ibBk5Cnt;
	}

	/**
	 * Column Info
	 * 
	 * @param totBk2BalUsdAmt
	 */
	public void setTotBk2BalUsdAmt(String totBk2BalUsdAmt) {
		this.totBk2BalUsdAmt = totBk2BalUsdAmt;
	}

	/**
	 * Column Info
	 * 
	 * @param ibBk2Cnt
	 */
	public void setIbBk2Cnt(String ibBk2Cnt) {
		this.ibBk2Cnt = ibBk2Cnt;
	}

	/**
	 * Column Info
	 * 
	 * @param obBk3BalUsdAmt
	 */
	public void setObBk3BalUsdAmt(String obBk3BalUsdAmt) {
		this.obBk3BalUsdAmt = obBk3BalUsdAmt;
	}

	/**
	 * Column Info
	 * 
	 * @param obBk2BalLoclAmt
	 */
	public void setObBk2BalLoclAmt(String obBk2BalLoclAmt) {
		this.obBk2BalLoclAmt = obBk2BalLoclAmt;
	}

	/**
	 * Column Info
	 * 
	 * @param totBk2BalLoclAmt
	 */
	public void setTotBk2BalLoclAmt(String totBk2BalLoclAmt) {
		this.totBk2BalLoclAmt = totBk2BalLoclAmt;
	}

	/**
	 * Column Info
	 * 
	 * @param ibBk1BalUsdAmt
	 */
	public void setIbBk1BalUsdAmt(String ibBk1BalUsdAmt) {
		this.ibBk1BalUsdAmt = ibBk1BalUsdAmt;
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
	 * @param totBk6BalUsdAmt
	 */
	public void setTotBk6BalUsdAmt(String totBk6BalUsdAmt) {
		this.totBk6BalUsdAmt = totBk6BalUsdAmt;
	}

	/**
	 * Column Info
	 * 
	 * @param totBk6BalLoclAmt
	 */
	public void setTotBk6BalLoclAmt(String totBk6BalLoclAmt) {
		this.totBk6BalLoclAmt = totBk6BalLoclAmt;
	}

	/**
	 * Column Info
	 * 
	 * @param obBk3Cnt
	 */
	public void setObBk3Cnt(String obBk3Cnt) {
		this.obBk3Cnt = obBk3Cnt;
	}

	/**
	 * Column Info
	 * 
	 * @param ibBk5BalLoclAmt
	 */
	public void setIbBk5BalLoclAmt(String ibBk5BalLoclAmt) {
		this.ibBk5BalLoclAmt = ibBk5BalLoclAmt;
	}

	/**
	 * Column Info
	 * 
	 * @param ibBk3BalLoclAmt
	 */
	public void setIbBk3BalLoclAmt(String ibBk3BalLoclAmt) {
		this.ibBk3BalLoclAmt = ibBk3BalLoclAmt;
	}

	/**
	 * Column Info
	 * 
	 * @param ibBk6Cnt
	 */
	public void setIbBk6Cnt(String ibBk6Cnt) {
		this.ibBk6Cnt = ibBk6Cnt;
	}

	/**
	 * Column Info
	 * 
	 * @param totBk1BalLoclAmt
	 */
	public void setTotBk1BalLoclAmt(String totBk1BalLoclAmt) {
		this.totBk1BalLoclAmt = totBk1BalLoclAmt;
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
	 * @param ibBk4Cnt
	 */
	public void setIbBk4Cnt(String ibBk4Cnt) {
		this.ibBk4Cnt = ibBk4Cnt;
	}

	/**
	 * Column Info
	 * 
	 * @param obBk6BalUsdAmt
	 */
	public void setObBk6BalUsdAmt(String obBk6BalUsdAmt) {
		this.obBk6BalUsdAmt = obBk6BalUsdAmt;
	}

	/**
	 * Column Info
	 * 
	 * @param ibBk1BalLoclAmt
	 */
	public void setIbBk1BalLoclAmt(String ibBk1BalLoclAmt) {
		this.ibBk1BalLoclAmt = ibBk1BalLoclAmt;
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
	 * @param totBk5BalUsdAmt
	 */
	public void setTotBk5BalUsdAmt(String totBk5BalUsdAmt) {
		this.totBk5BalUsdAmt = totBk5BalUsdAmt;
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
	 * @param obBk6Cnt
	 */
	public void setObBk6Cnt(String obBk6Cnt) {
		this.obBk6Cnt = obBk6Cnt;
	}

	/**
	 * Column Info
	 * 
	 * @param obBk4BalUsdAmt
	 */
	public void setObBk4BalUsdAmt(String obBk4BalUsdAmt) {
		this.obBk4BalUsdAmt = obBk4BalUsdAmt;
	}

	/**
	 * Column Info
	 * 
	 * @param totBk2Cnt
	 */
	public void setTotBk2Cnt(String totBk2Cnt) {
		this.totBk2Cnt = totBk2Cnt;
	}

	/**
	 * Column Info
	 * 
	 * @param totBk1BalUsdAmt
	 */
	public void setTotBk1BalUsdAmt(String totBk1BalUsdAmt) {
		this.totBk1BalUsdAmt = totBk1BalUsdAmt;
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
		setObBk6BalLoclAmt(JSPUtil.getParameter(request, prefix
				+ "ob_bk6_bal_locl_amt", ""));
		setObBk5BalLoclAmt(JSPUtil.getParameter(request, prefix
				+ "ob_bk5_bal_locl_amt", ""));
		setBilToCustCntCd(JSPUtil.getParameter(request, prefix
				+ "bil_to_cust_cnt_cd", ""));
		setStlFlg(JSPUtil.getParameter(request, prefix + "stl_flg", ""));
		setCltOfcCd(JSPUtil.getParameter(request, prefix + "clt_ofc_cd", ""));
		setRhq(JSPUtil.getParameter(request, prefix + "rhq", ""));
		setObBk5Cnt(JSPUtil.getParameter(request, prefix + "ob_bk5_cnt", ""));
		setObBk4BalLoclAmt(JSPUtil.getParameter(request, prefix
				+ "ob_bk4_bal_locl_amt", ""));
		setBlInvTp(JSPUtil.getParameter(request, prefix + "bl_inv_tp", ""));
		setBlSumTp(JSPUtil.getParameter(request, prefix + "bl_sum_tp", ""));
		setSailArrDt(JSPUtil.getParameter(request, prefix + "sail_arr_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTotBk1Cnt(JSPUtil.getParameter(request, prefix + "tot_bk1_cnt", ""));
		setObBk3BalLoclAmt(JSPUtil.getParameter(request, prefix
				+ "ob_bk3_bal_locl_amt", ""));
		setTotBk3BalUsdAmt(JSPUtil.getParameter(request, prefix
				+ "tot_bk3_bal_usd_amt", ""));
		setIbBk3Cnt(JSPUtil.getParameter(request, prefix + "ib_bk3_cnt", ""));
		setOtsGrpTpCd(JSPUtil.getParameter(request, prefix + "ots_grp_tp_cd",
				""));
		setTotBk4BalLoclAmt(JSPUtil.getParameter(request, prefix
				+ "tot_bk4_bal_locl_amt", ""));
		setOtsSrcCd(JSPUtil.getParameter(request, prefix + "ots_src_cd", ""));
		setTotBk6Cnt(JSPUtil.getParameter(request, prefix + "tot_bk6_cnt", ""));
		setIbBk2BalLoclAmt(JSPUtil.getParameter(request, prefix
				+ "ib_bk2_bal_locl_amt", ""));
		setObBk1Cnt(JSPUtil.getParameter(request, prefix + "ob_bk1_cnt", ""));
		setTotBk5BalLoclAmt(JSPUtil.getParameter(request, prefix
				+ "tot_bk5_bal_locl_amt", ""));
		setBilToCustSeq(JSPUtil.getParameter(request, prefix
				+ "bil_to_cust_seq", ""));
		setObBk1BalLoclAmt(JSPUtil.getParameter(request, prefix
				+ "ob_bk1_bal_locl_amt", ""));
		setTotBk3Cnt(JSPUtil.getParameter(request, prefix + "tot_bk3_cnt", ""));
		setObBk5BalUsdAmt(JSPUtil.getParameter(request, prefix
				+ "ob_bk5_bal_usd_amt", ""));
		setIbBk3BalUsdAmt(JSPUtil.getParameter(request, prefix
				+ "ib_bk3_bal_usd_amt", ""));
		setIbBk6BalLoclAmt(JSPUtil.getParameter(request, prefix
				+ "ib_bk6_bal_locl_amt", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix
				+ "cust_lgl_eng_nm", ""));
		setBk5(JSPUtil.getParameter(request, prefix + "bk5", ""));
		setIbBk1Cnt(JSPUtil.getParameter(request, prefix + "ib_bk1_cnt", ""));
		setBk6(JSPUtil.getParameter(request, prefix + "bk6", ""));
		setIbBk6BalUsdAmt(JSPUtil.getParameter(request, prefix
				+ "ib_bk6_bal_usd_amt", ""));
		setCrMkFlg(JSPUtil.getParameter(request, prefix + "cr_mk_flg", ""));
		setBk1(JSPUtil.getParameter(request, prefix + "bk1", ""));
		setBk2(JSPUtil.getParameter(request, prefix + "bk2", ""));
		setBk3(JSPUtil.getParameter(request, prefix + "bk3", ""));
		setPrimaryKey(JSPUtil.getParameter(request, prefix + "primary_key", ""));
		setBk4(JSPUtil.getParameter(request, prefix + "bk4", ""));
		setObBk2BalUsdAmt(JSPUtil.getParameter(request, prefix
				+ "ob_bk2_bal_usd_amt", ""));
		setIbBk4BalUsdAmt(JSPUtil.getParameter(request, prefix
				+ "ib_bk4_bal_usd_amt", ""));
		setTotBk5Cnt(JSPUtil.getParameter(request, prefix + "tot_bk5_cnt", ""));
		setIbBk4BalLoclAmt(JSPUtil.getParameter(request, prefix
				+ "ib_bk4_bal_locl_amt", ""));
		setTotBk3BalLoclAmt(JSPUtil.getParameter(request, prefix
				+ "tot_bk3_bal_locl_amt", ""));
		setTotBk4BalUsdAmt(JSPUtil.getParameter(request, prefix
				+ "tot_bk4_bal_usd_amt", ""));
		setObBk4Cnt(JSPUtil.getParameter(request, prefix + "ob_bk4_cnt", ""));
		setSumTp(JSPUtil.getParameter(request, prefix + "sum_tp", ""));
		setIbBk2BalUsdAmt(JSPUtil.getParameter(request, prefix
				+ "ib_bk2_bal_usd_amt", ""));
		setTotBk4Cnt(JSPUtil.getParameter(request, prefix + "tot_bk4_cnt", ""));
		setObBk2Cnt(JSPUtil.getParameter(request, prefix + "ob_bk2_cnt", ""));
		setObBk1BalUsdAmt(JSPUtil.getParameter(request, prefix
				+ "ob_bk1_bal_usd_amt", ""));
		setIbBk5BalUsdAmt(JSPUtil.getParameter(request, prefix
				+ "ib_bk5_bal_usd_amt", ""));
		setIbBk5Cnt(JSPUtil.getParameter(request, prefix + "ib_bk5_cnt", ""));
		setTotBk2BalUsdAmt(JSPUtil.getParameter(request, prefix
				+ "tot_bk2_bal_usd_amt", ""));
		setIbBk2Cnt(JSPUtil.getParameter(request, prefix + "ib_bk2_cnt", ""));
		setObBk3BalUsdAmt(JSPUtil.getParameter(request, prefix
				+ "ob_bk3_bal_usd_amt", ""));
		setObBk2BalLoclAmt(JSPUtil.getParameter(request, prefix
				+ "ob_bk2_bal_locl_amt", ""));
		setTotBk2BalLoclAmt(JSPUtil.getParameter(request, prefix
				+ "tot_bk2_bal_locl_amt", ""));
		setIbBk1BalUsdAmt(JSPUtil.getParameter(request, prefix
				+ "ib_bk1_bal_usd_amt", ""));
		setSumOfcCustTp(JSPUtil.getParameter(request, prefix
				+ "sum_ofc_cust_tp", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTotBk6BalUsdAmt(JSPUtil.getParameter(request, prefix
				+ "tot_bk6_bal_usd_amt", ""));
		setTotBk6BalLoclAmt(JSPUtil.getParameter(request, prefix
				+ "tot_bk6_bal_locl_amt", ""));
		setObBk3Cnt(JSPUtil.getParameter(request, prefix + "ob_bk3_cnt", ""));
		setIbBk5BalLoclAmt(JSPUtil.getParameter(request, prefix
				+ "ib_bk5_bal_locl_amt", ""));
		setIbBk3BalLoclAmt(JSPUtil.getParameter(request, prefix
				+ "ib_bk3_bal_locl_amt", ""));
		setIbBk6Cnt(JSPUtil.getParameter(request, prefix + "ib_bk6_cnt", ""));
		setTotBk1BalLoclAmt(JSPUtil.getParameter(request, prefix
				+ "tot_bk1_bal_locl_amt", ""));
		setDueDt(JSPUtil.getParameter(request, prefix + "due_dt", ""));
		setOtsRtFlg(JSPUtil.getParameter(request, prefix + "ots_rt_flg", ""));
		setIbBk4Cnt(JSPUtil.getParameter(request, prefix + "ib_bk4_cnt", ""));
		setObBk6BalUsdAmt(JSPUtil.getParameter(request, prefix
				+ "ob_bk6_bal_usd_amt", ""));
		setIbBk1BalLoclAmt(JSPUtil.getParameter(request, prefix
				+ "ib_bk1_bal_locl_amt", ""));
		setBlCurrCd(JSPUtil.getParameter(request, prefix + "bl_curr_cd", ""));
		setTotBk5BalUsdAmt(JSPUtil.getParameter(request, prefix
				+ "tot_bk5_bal_usd_amt", ""));
		setMultiCltOfcCd(JSPUtil.getParameter(request, prefix
				+ "multi_clt_ofc_cd", ""));
		setObBk6Cnt(JSPUtil.getParameter(request, prefix + "ob_bk6_cnt", ""));
		setObBk4BalUsdAmt(JSPUtil.getParameter(request, prefix
				+ "ob_bk4_bal_usd_amt", ""));
		setTotBk2Cnt(JSPUtil.getParameter(request, prefix + "tot_bk2_cnt", ""));
		setTotBk1BalUsdAmt(JSPUtil.getParameter(request, prefix
				+ "tot_bk1_bal_usd_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * 
	 * @param request
	 * @return OTSAgingBucketVO[]
	 */
	public OTSAgingBucketVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * 
	 * @param request
	 * @param prefix
	 * @return OTSAgingBucketVO[]
	 */
	public OTSAgingBucketVO[] fromRequestGrid(HttpServletRequest request,
			String prefix) {
		OTSAgingBucketVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] obBk6BalLoclAmt = (JSPUtil.getParameter(request, prefix
					+ "ob_bk6_bal_locl_amt", length));
			String[] obBk5BalLoclAmt = (JSPUtil.getParameter(request, prefix
					+ "ob_bk5_bal_locl_amt", length));
			String[] bilToCustCntCd = (JSPUtil.getParameter(request, prefix
					+ "bil_to_cust_cnt_cd", length));
			String[] stlFlg = (JSPUtil.getParameter(request,
					prefix + "stl_flg", length));
			String[] cltOfcCd = (JSPUtil.getParameter(request, prefix
					+ "clt_ofc_cd", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix
					+ "rhq", length));
			String[] obBk5Cnt = (JSPUtil.getParameter(request, prefix
					+ "ob_bk5_cnt", length));
			String[] obBk4BalLoclAmt = (JSPUtil.getParameter(request, prefix
					+ "ob_bk4_bal_locl_amt", length));
			String[] blInvTp = (JSPUtil.getParameter(request, prefix
					+ "bl_inv_tp", length));
			String[] blSumTp = (JSPUtil.getParameter(request, prefix
					+ "bl_sum_tp", length));
			String[] sailArrDt = (JSPUtil.getParameter(request, prefix
					+ "sail_arr_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix
					+ "pagerows", length));
			String[] totBk1Cnt = (JSPUtil.getParameter(request, prefix
					+ "tot_bk1_cnt", length));
			String[] obBk3BalLoclAmt = (JSPUtil.getParameter(request, prefix
					+ "ob_bk3_bal_locl_amt", length));
			String[] totBk3BalUsdAmt = (JSPUtil.getParameter(request, prefix
					+ "tot_bk3_bal_usd_amt", length));
			String[] ibBk3Cnt = (JSPUtil.getParameter(request, prefix
					+ "ib_bk3_cnt", length));
			String[] otsGrpTpCd = (JSPUtil.getParameter(request, prefix
					+ "ots_grp_tp_cd", length));
			String[] totBk4BalLoclAmt = (JSPUtil.getParameter(request, prefix
					+ "tot_bk4_bal_locl_amt", length));
			String[] otsSrcCd = (JSPUtil.getParameter(request, prefix
					+ "ots_src_cd", length));
			String[] totBk6Cnt = (JSPUtil.getParameter(request, prefix
					+ "tot_bk6_cnt", length));
			String[] ibBk2BalLoclAmt = (JSPUtil.getParameter(request, prefix
					+ "ib_bk2_bal_locl_amt", length));
			String[] obBk1Cnt = (JSPUtil.getParameter(request, prefix
					+ "ob_bk1_cnt", length));
			String[] totBk5BalLoclAmt = (JSPUtil.getParameter(request, prefix
					+ "tot_bk5_bal_locl_amt", length));
			String[] bilToCustSeq = (JSPUtil.getParameter(request, prefix
					+ "bil_to_cust_seq", length));
			String[] obBk1BalLoclAmt = (JSPUtil.getParameter(request, prefix
					+ "ob_bk1_bal_locl_amt", length));
			String[] totBk3Cnt = (JSPUtil.getParameter(request, prefix
					+ "tot_bk3_cnt", length));
			String[] obBk5BalUsdAmt = (JSPUtil.getParameter(request, prefix
					+ "ob_bk5_bal_usd_amt", length));
			String[] ibBk3BalUsdAmt = (JSPUtil.getParameter(request, prefix
					+ "ib_bk3_bal_usd_amt", length));
			String[] ibBk6BalLoclAmt = (JSPUtil.getParameter(request, prefix
					+ "ib_bk6_bal_locl_amt", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix
					+ "cust_lgl_eng_nm", length));
			String[] bk5 = (JSPUtil.getParameter(request, prefix + "bk5",
					length));
			String[] ibBk1Cnt = (JSPUtil.getParameter(request, prefix
					+ "ib_bk1_cnt", length));
			String[] bk6 = (JSPUtil.getParameter(request, prefix + "bk6",
					length));
			String[] ibBk6BalUsdAmt = (JSPUtil.getParameter(request, prefix
					+ "ib_bk6_bal_usd_amt", length));
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
			String[] obBk2BalUsdAmt = (JSPUtil.getParameter(request, prefix
					+ "ob_bk2_bal_usd_amt", length));
			String[] ibBk4BalUsdAmt = (JSPUtil.getParameter(request, prefix
					+ "ib_bk4_bal_usd_amt", length));
			String[] totBk5Cnt = (JSPUtil.getParameter(request, prefix
					+ "tot_bk5_cnt", length));
			String[] ibBk4BalLoclAmt = (JSPUtil.getParameter(request, prefix
					+ "ib_bk4_bal_locl_amt", length));
			String[] totBk3BalLoclAmt = (JSPUtil.getParameter(request, prefix
					+ "tot_bk3_bal_locl_amt", length));
			String[] totBk4BalUsdAmt = (JSPUtil.getParameter(request, prefix
					+ "tot_bk4_bal_usd_amt", length));
			String[] obBk4Cnt = (JSPUtil.getParameter(request, prefix
					+ "ob_bk4_cnt", length));
			String[] sumTp = (JSPUtil.getParameter(request, prefix + "sum_tp",
					length));
			String[] ibBk2BalUsdAmt = (JSPUtil.getParameter(request, prefix
					+ "ib_bk2_bal_usd_amt", length));
			String[] totBk4Cnt = (JSPUtil.getParameter(request, prefix
					+ "tot_bk4_cnt", length));
			String[] obBk2Cnt = (JSPUtil.getParameter(request, prefix
					+ "ob_bk2_cnt", length));
			String[] obBk1BalUsdAmt = (JSPUtil.getParameter(request, prefix
					+ "ob_bk1_bal_usd_amt", length));
			String[] ibBk5BalUsdAmt = (JSPUtil.getParameter(request, prefix
					+ "ib_bk5_bal_usd_amt", length));
			String[] ibBk5Cnt = (JSPUtil.getParameter(request, prefix
					+ "ib_bk5_cnt", length));
			String[] totBk2BalUsdAmt = (JSPUtil.getParameter(request, prefix
					+ "tot_bk2_bal_usd_amt", length));
			String[] ibBk2Cnt = (JSPUtil.getParameter(request, prefix
					+ "ib_bk2_cnt", length));
			String[] obBk3BalUsdAmt = (JSPUtil.getParameter(request, prefix
					+ "ob_bk3_bal_usd_amt", length));
			String[] obBk2BalLoclAmt = (JSPUtil.getParameter(request, prefix
					+ "ob_bk2_bal_locl_amt", length));
			String[] totBk2BalLoclAmt = (JSPUtil.getParameter(request, prefix
					+ "tot_bk2_bal_locl_amt", length));
			String[] ibBk1BalUsdAmt = (JSPUtil.getParameter(request, prefix
					+ "ib_bk1_bal_usd_amt", length));
			String[] sumOfcCustTp = (JSPUtil.getParameter(request, prefix
					+ "sum_ofc_cust_tp", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag",
					length));
			String[] totBk6BalUsdAmt = (JSPUtil.getParameter(request, prefix
					+ "tot_bk6_bal_usd_amt", length));
			String[] totBk6BalLoclAmt = (JSPUtil.getParameter(request, prefix
					+ "tot_bk6_bal_locl_amt", length));
			String[] obBk3Cnt = (JSPUtil.getParameter(request, prefix
					+ "ob_bk3_cnt", length));
			String[] ibBk5BalLoclAmt = (JSPUtil.getParameter(request, prefix
					+ "ib_bk5_bal_locl_amt", length));
			String[] ibBk3BalLoclAmt = (JSPUtil.getParameter(request, prefix
					+ "ib_bk3_bal_locl_amt", length));
			String[] ibBk6Cnt = (JSPUtil.getParameter(request, prefix
					+ "ib_bk6_cnt", length));
			String[] totBk1BalLoclAmt = (JSPUtil.getParameter(request, prefix
					+ "tot_bk1_bal_locl_amt", length));
			String[] dueDt = (JSPUtil.getParameter(request, prefix + "due_dt",
					length));
			String[] otsRtFlg = (JSPUtil.getParameter(request, prefix
					+ "ots_rt_flg", length));
			String[] ibBk4Cnt = (JSPUtil.getParameter(request, prefix
					+ "ib_bk4_cnt", length));
			String[] obBk6BalUsdAmt = (JSPUtil.getParameter(request, prefix
					+ "ob_bk6_bal_usd_amt", length));
			String[] ibBk1BalLoclAmt = (JSPUtil.getParameter(request, prefix
					+ "ib_bk1_bal_locl_amt", length));
			String[] blCurrCd = (JSPUtil.getParameter(request, prefix
					+ "bl_curr_cd", length));
			String[] totBk5BalUsdAmt = (JSPUtil.getParameter(request, prefix
					+ "tot_bk5_bal_usd_amt", length));
			String[] multiCltOfcCd = (JSPUtil.getParameter(request, prefix
					+ "multi_clt_ofc_cd", length));
			String[] obBk6Cnt = (JSPUtil.getParameter(request, prefix
					+ "ob_bk6_cnt", length));
			String[] obBk4BalUsdAmt = (JSPUtil.getParameter(request, prefix
					+ "ob_bk4_bal_usd_amt", length));
			String[] totBk2Cnt = (JSPUtil.getParameter(request, prefix
					+ "tot_bk2_cnt", length));
			String[] totBk1BalUsdAmt = (JSPUtil.getParameter(request, prefix
					+ "tot_bk1_bal_usd_amt", length));

			for (int i = 0; i < length; i++) {
				model = new OTSAgingBucketVO();
				if (obBk6BalLoclAmt[i] != null)
					model.setObBk6BalLoclAmt(obBk6BalLoclAmt[i]);
				if (obBk5BalLoclAmt[i] != null)
					model.setObBk5BalLoclAmt(obBk5BalLoclAmt[i]);
				if (bilToCustCntCd[i] != null)
					model.setBilToCustCntCd(bilToCustCntCd[i]);
				if (stlFlg[i] != null)
					model.setStlFlg(stlFlg[i]);
				if (cltOfcCd[i] != null)
					model.setCltOfcCd(cltOfcCd[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				if (obBk5Cnt[i] != null)
					model.setObBk5Cnt(obBk5Cnt[i]);
				if (obBk4BalLoclAmt[i] != null)
					model.setObBk4BalLoclAmt(obBk4BalLoclAmt[i]);
				if (blInvTp[i] != null)
					model.setBlInvTp(blInvTp[i]);
				if (blSumTp[i] != null)
					model.setBlSumTp(blSumTp[i]);
				if (sailArrDt[i] != null)
					model.setSailArrDt(sailArrDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (totBk1Cnt[i] != null)
					model.setTotBk1Cnt(totBk1Cnt[i]);
				if (obBk3BalLoclAmt[i] != null)
					model.setObBk3BalLoclAmt(obBk3BalLoclAmt[i]);
				if (totBk3BalUsdAmt[i] != null)
					model.setTotBk3BalUsdAmt(totBk3BalUsdAmt[i]);
				if (ibBk3Cnt[i] != null)
					model.setIbBk3Cnt(ibBk3Cnt[i]);
				if (otsGrpTpCd[i] != null)
					model.setOtsGrpTpCd(otsGrpTpCd[i]);
				if (totBk4BalLoclAmt[i] != null)
					model.setTotBk4BalLoclAmt(totBk4BalLoclAmt[i]);
				if (otsSrcCd[i] != null)
					model.setOtsSrcCd(otsSrcCd[i]);
				if (totBk6Cnt[i] != null)
					model.setTotBk6Cnt(totBk6Cnt[i]);
				if (ibBk2BalLoclAmt[i] != null)
					model.setIbBk2BalLoclAmt(ibBk2BalLoclAmt[i]);
				if (obBk1Cnt[i] != null)
					model.setObBk1Cnt(obBk1Cnt[i]);
				if (totBk5BalLoclAmt[i] != null)
					model.setTotBk5BalLoclAmt(totBk5BalLoclAmt[i]);
				if (bilToCustSeq[i] != null)
					model.setBilToCustSeq(bilToCustSeq[i]);
				if (obBk1BalLoclAmt[i] != null)
					model.setObBk1BalLoclAmt(obBk1BalLoclAmt[i]);
				if (totBk3Cnt[i] != null)
					model.setTotBk3Cnt(totBk3Cnt[i]);
				if (obBk5BalUsdAmt[i] != null)
					model.setObBk5BalUsdAmt(obBk5BalUsdAmt[i]);
				if (ibBk3BalUsdAmt[i] != null)
					model.setIbBk3BalUsdAmt(ibBk3BalUsdAmt[i]);
				if (ibBk6BalLoclAmt[i] != null)
					model.setIbBk6BalLoclAmt(ibBk6BalLoclAmt[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (bk5[i] != null)
					model.setBk5(bk5[i]);
				if (ibBk1Cnt[i] != null)
					model.setIbBk1Cnt(ibBk1Cnt[i]);
				if (bk6[i] != null)
					model.setBk6(bk6[i]);
				if (ibBk6BalUsdAmt[i] != null)
					model.setIbBk6BalUsdAmt(ibBk6BalUsdAmt[i]);
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
				if (obBk2BalUsdAmt[i] != null)
					model.setObBk2BalUsdAmt(obBk2BalUsdAmt[i]);
				if (ibBk4BalUsdAmt[i] != null)
					model.setIbBk4BalUsdAmt(ibBk4BalUsdAmt[i]);
				if (totBk5Cnt[i] != null)
					model.setTotBk5Cnt(totBk5Cnt[i]);
				if (ibBk4BalLoclAmt[i] != null)
					model.setIbBk4BalLoclAmt(ibBk4BalLoclAmt[i]);
				if (totBk3BalLoclAmt[i] != null)
					model.setTotBk3BalLoclAmt(totBk3BalLoclAmt[i]);
				if (totBk4BalUsdAmt[i] != null)
					model.setTotBk4BalUsdAmt(totBk4BalUsdAmt[i]);
				if (obBk4Cnt[i] != null)
					model.setObBk4Cnt(obBk4Cnt[i]);
				if (sumTp[i] != null)
					model.setSumTp(sumTp[i]);
				if (ibBk2BalUsdAmt[i] != null)
					model.setIbBk2BalUsdAmt(ibBk2BalUsdAmt[i]);
				if (totBk4Cnt[i] != null)
					model.setTotBk4Cnt(totBk4Cnt[i]);
				if (obBk2Cnt[i] != null)
					model.setObBk2Cnt(obBk2Cnt[i]);
				if (obBk1BalUsdAmt[i] != null)
					model.setObBk1BalUsdAmt(obBk1BalUsdAmt[i]);
				if (ibBk5BalUsdAmt[i] != null)
					model.setIbBk5BalUsdAmt(ibBk5BalUsdAmt[i]);
				if (ibBk5Cnt[i] != null)
					model.setIbBk5Cnt(ibBk5Cnt[i]);
				if (totBk2BalUsdAmt[i] != null)
					model.setTotBk2BalUsdAmt(totBk2BalUsdAmt[i]);
				if (ibBk2Cnt[i] != null)
					model.setIbBk2Cnt(ibBk2Cnt[i]);
				if (obBk3BalUsdAmt[i] != null)
					model.setObBk3BalUsdAmt(obBk3BalUsdAmt[i]);
				if (obBk2BalLoclAmt[i] != null)
					model.setObBk2BalLoclAmt(obBk2BalLoclAmt[i]);
				if (totBk2BalLoclAmt[i] != null)
					model.setTotBk2BalLoclAmt(totBk2BalLoclAmt[i]);
				if (ibBk1BalUsdAmt[i] != null)
					model.setIbBk1BalUsdAmt(ibBk1BalUsdAmt[i]);
				if (sumOfcCustTp[i] != null)
					model.setSumOfcCustTp(sumOfcCustTp[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (totBk6BalUsdAmt[i] != null)
					model.setTotBk6BalUsdAmt(totBk6BalUsdAmt[i]);
				if (totBk6BalLoclAmt[i] != null)
					model.setTotBk6BalLoclAmt(totBk6BalLoclAmt[i]);
				if (obBk3Cnt[i] != null)
					model.setObBk3Cnt(obBk3Cnt[i]);
				if (ibBk5BalLoclAmt[i] != null)
					model.setIbBk5BalLoclAmt(ibBk5BalLoclAmt[i]);
				if (ibBk3BalLoclAmt[i] != null)
					model.setIbBk3BalLoclAmt(ibBk3BalLoclAmt[i]);
				if (ibBk6Cnt[i] != null)
					model.setIbBk6Cnt(ibBk6Cnt[i]);
				if (totBk1BalLoclAmt[i] != null)
					model.setTotBk1BalLoclAmt(totBk1BalLoclAmt[i]);
				if (dueDt[i] != null)
					model.setDueDt(dueDt[i]);
				if (otsRtFlg[i] != null)
					model.setOtsRtFlg(otsRtFlg[i]);
				if (ibBk4Cnt[i] != null)
					model.setIbBk4Cnt(ibBk4Cnt[i]);
				if (obBk6BalUsdAmt[i] != null)
					model.setObBk6BalUsdAmt(obBk6BalUsdAmt[i]);
				if (ibBk1BalLoclAmt[i] != null)
					model.setIbBk1BalLoclAmt(ibBk1BalLoclAmt[i]);
				if (blCurrCd[i] != null)
					model.setBlCurrCd(blCurrCd[i]);
				if (totBk5BalUsdAmt[i] != null)
					model.setTotBk5BalUsdAmt(totBk5BalUsdAmt[i]);
				if (multiCltOfcCd[i] != null)
					model.setMultiCltOfcCd(multiCltOfcCd[i]);
				if (obBk6Cnt[i] != null)
					model.setObBk6Cnt(obBk6Cnt[i]);
				if (obBk4BalUsdAmt[i] != null)
					model.setObBk4BalUsdAmt(obBk4BalUsdAmt[i]);
				if (totBk2Cnt[i] != null)
					model.setTotBk2Cnt(totBk2Cnt[i]);
				if (totBk1BalUsdAmt[i] != null)
					model.setTotBk1BalUsdAmt(totBk1BalUsdAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOTSAgingBucketVOs();
	}

	/**
	 * VO 배열을 반환
	 * 
	 * @return OTSAgingBucketVO[]
	 */
	public OTSAgingBucketVO[] getOTSAgingBucketVOs() {
		OTSAgingBucketVO[] vos = (OTSAgingBucketVO[]) models
				.toArray(new OTSAgingBucketVO[models.size()]);
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
		this.obBk6BalLoclAmt = this.obBk6BalLoclAmt.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obBk5BalLoclAmt = this.obBk5BalLoclAmt.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilToCustCntCd = this.bilToCustCntCd.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlFlg = this.stlFlg.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.cltOfcCd = this.cltOfcCd.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.obBk5Cnt = this.obBk5Cnt.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.obBk4BalLoclAmt = this.obBk4BalLoclAmt.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blInvTp = this.blInvTp.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.blSumTp = this.blSumTp.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt = this.sailArrDt.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.totBk1Cnt = this.totBk1Cnt.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.obBk3BalLoclAmt = this.obBk3BalLoclAmt.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totBk3BalUsdAmt = this.totBk3BalUsdAmt.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibBk3Cnt = this.ibBk3Cnt.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.otsGrpTpCd = this.otsGrpTpCd.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totBk4BalLoclAmt = this.totBk4BalLoclAmt.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsSrcCd = this.otsSrcCd.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.totBk6Cnt = this.totBk6Cnt.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.ibBk2BalLoclAmt = this.ibBk2BalLoclAmt.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obBk1Cnt = this.obBk1Cnt.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.totBk5BalLoclAmt = this.totBk5BalLoclAmt.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilToCustSeq = this.bilToCustSeq.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obBk1BalLoclAmt = this.obBk1BalLoclAmt.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totBk3Cnt = this.totBk3Cnt.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.obBk5BalUsdAmt = this.obBk5BalUsdAmt.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibBk3BalUsdAmt = this.ibBk3BalUsdAmt.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibBk6BalLoclAmt = this.ibBk6BalLoclAmt.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bk5 = this.bk5.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.ibBk1Cnt = this.ibBk1Cnt.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.bk6 = this.bk6.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.ibBk6BalUsdAmt = this.ibBk6BalUsdAmt.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
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
		this.obBk2BalUsdAmt = this.obBk2BalUsdAmt.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibBk4BalUsdAmt = this.ibBk4BalUsdAmt.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totBk5Cnt = this.totBk5Cnt.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.ibBk4BalLoclAmt = this.ibBk4BalLoclAmt.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totBk3BalLoclAmt = this.totBk3BalLoclAmt.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totBk4BalUsdAmt = this.totBk4BalUsdAmt.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obBk4Cnt = this.obBk4Cnt.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.sumTp = this.sumTp.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.ibBk2BalUsdAmt = this.ibBk2BalUsdAmt.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totBk4Cnt = this.totBk4Cnt.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.obBk2Cnt = this.obBk2Cnt.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.obBk1BalUsdAmt = this.obBk1BalUsdAmt.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibBk5BalUsdAmt = this.ibBk5BalUsdAmt.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibBk5Cnt = this.ibBk5Cnt.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.totBk2BalUsdAmt = this.totBk2BalUsdAmt.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibBk2Cnt = this.ibBk2Cnt.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.obBk3BalUsdAmt = this.obBk3BalUsdAmt.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obBk2BalLoclAmt = this.obBk2BalLoclAmt.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totBk2BalLoclAmt = this.totBk2BalLoclAmt.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibBk1BalUsdAmt = this.ibBk1BalUsdAmt.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumOfcCustTp = this.sumOfcCustTp.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.totBk6BalUsdAmt = this.totBk6BalUsdAmt.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totBk6BalLoclAmt = this.totBk6BalLoclAmt.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obBk3Cnt = this.obBk3Cnt.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.ibBk5BalLoclAmt = this.ibBk5BalLoclAmt.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibBk3BalLoclAmt = this.ibBk3BalLoclAmt.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibBk6Cnt = this.ibBk6Cnt.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.totBk1BalLoclAmt = this.totBk1BalLoclAmt.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDt = this.dueDt.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.otsRtFlg = this.otsRtFlg.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.ibBk4Cnt = this.ibBk4Cnt.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.obBk6BalUsdAmt = this.obBk6BalUsdAmt.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibBk1BalLoclAmt = this.ibBk1BalLoclAmt.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCurrCd = this.blCurrCd.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.totBk5BalUsdAmt = this.totBk5BalUsdAmt.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.multiCltOfcCd = this.multiCltOfcCd.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obBk6Cnt = this.obBk6Cnt.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.obBk4BalUsdAmt = this.obBk4BalUsdAmt.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totBk2Cnt = this.totBk2Cnt.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.totBk1BalUsdAmt = this.totBk1BalUsdAmt.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
