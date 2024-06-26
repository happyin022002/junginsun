/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AgentCollectionListVO.java
*@FileTitle : AgentCollectionListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.16  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo;

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

public class AgentCollectionListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AgentCollectionListVO> models = new ArrayList<AgentCollectionListVO>();
	
	/* Column Info */
	private String chgTpCd = null;
	/* Column Info */
	private String glYrmon = null;
	/* Column Info */
	private String n3rdCurrCd1 = null;
	/* Column Info */
	private String n3rdLoclAmt4 = null;
	/* Column Info */
	private String n3rdLoclAmt3 = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String n3rdLoclAmt2 = null;
	/* Column Info */
	private String n3rdLoclAmt1 = null;
	/* Column Info */
	private String n3rdCurrCd4 = null;
	/* Column Info */
	private String ttlAmt = null;
	/* Column Info */
	private String n3rdCurrCd3 = null;
	/* Column Info */
	private String n3rdCurrCd2 = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String sailArrDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String option1 = null;
	/* Column Info */
	private String option2 = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String asaRmk = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String asaTpCd = null;
	/* Column Info */
	private String glYrmonFm = null;
	/* Column Info */
	private String asaNo1 = null;
	/* Column Info */
	private String asaNo3 = null;
	/* Column Info */
	private String asaNo2 = null;
	/* Column Info */
	private String loclCurrCd = null;
	/* Column Info */
	private String eqvLoclAmt2 = null;
	/* Column Info */
	private String bnd = null;
	/* Column Info */
	private String n3rdAmt3 = null;
	/* Column Info */
	private String n3rdAmt4 = null;
	/* Column Info */
	private String n3rdAmt1 = null;
	/* Column Info */
	private String n3rdAmt2 = null;
	/* Column Info */
	private String asaNo = null;
	/* Column Info */
	private String eqvLoclAmt = null;
	/* Column Info */
	private String asaCurrCd = null;
	/* Column Info */
	private String agnCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String asaCltSeq = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String dueDt = null;
	/* Column Info */
	private String glYrmonTo = null;
	/* Column Info */
	private String chgUsdAmt = null;
	/* Column Info */
	private String dueDtTo = null;
	/* Column Info */
	private String loclAmt = null;
	/* Column Info */
	private String ibObCd = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String n3rdXchRt1 = null;
	/* Column Info */
	private String n3rdXchRt2 = null;
	/* Column Info */
	private String usdAmt = null;
	/* Column Info */
	private String dueDtFm = null;
	/* Column Info */
	private String n3rdXchRt3 = null;
	/* Column Info */
	private String n3rdXchRt4 = null;
	/* Column Info */
	private String asaXchRt1 = null;
	/* Column Info */
	private String asaXchRt2 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AgentCollectionListVO() {}

	public AgentCollectionListVO(String ibflag, String pagerows, String chgTpCd, String glYrmon, String n3rdCurrCd1, String n3rdLoclAmt4, String n3rdLoclAmt3, String svcScpCd, String n3rdLoclAmt2, String n3rdLoclAmt1, String n3rdCurrCd4, String ttlAmt, String n3rdCurrCd3, String n3rdCurrCd2, String sailArrDt, String blNo, String option1, String option2, String effDt, String asaRmk, String vvdCd, String asaTpCd, String glYrmonFm, String asaNo1, String asaNo3, String asaNo2, String loclCurrCd, String eqvLoclAmt2, String bnd, String n3rdAmt3, String n3rdAmt4, String n3rdAmt1, String n3rdAmt2, String asaNo, String eqvLoclAmt, String asaCurrCd, String agnCd, String asaCltSeq, String portCd, String dueDt, String glYrmonTo, String chgUsdAmt, String dueDtTo, String loclAmt, String ibObCd, String arOfcCd, String invNo, String n3rdXchRt1, String dueDtFm, String usdAmt, String n3rdXchRt2, String n3rdXchRt3, String asaXchRt1, String n3rdXchRt4, String asaXchRt2, String usrId) {
		this.chgTpCd = chgTpCd;
		this.glYrmon = glYrmon;
		this.n3rdCurrCd1 = n3rdCurrCd1;
		this.n3rdLoclAmt4 = n3rdLoclAmt4;
		this.n3rdLoclAmt3 = n3rdLoclAmt3;
		this.svcScpCd = svcScpCd;
		this.n3rdLoclAmt2 = n3rdLoclAmt2;
		this.n3rdLoclAmt1 = n3rdLoclAmt1;
		this.n3rdCurrCd4 = n3rdCurrCd4;
		this.ttlAmt = ttlAmt;
		this.n3rdCurrCd3 = n3rdCurrCd3;
		this.n3rdCurrCd2 = n3rdCurrCd2;
		this.blNo = blNo;
		this.sailArrDt = sailArrDt;
		this.pagerows = pagerows;
		this.option1 = option1;
		this.option2 = option2;
		this.effDt = effDt;
		this.asaRmk = asaRmk;
		this.vvdCd = vvdCd;
		this.asaTpCd = asaTpCd;
		this.glYrmonFm = glYrmonFm;
		this.asaNo1 = asaNo1;
		this.asaNo3 = asaNo3;
		this.asaNo2 = asaNo2;
		this.loclCurrCd = loclCurrCd;
		this.eqvLoclAmt2 = eqvLoclAmt2;
		this.bnd = bnd;
		this.n3rdAmt3 = n3rdAmt3;
		this.n3rdAmt4 = n3rdAmt4;
		this.n3rdAmt1 = n3rdAmt1;
		this.n3rdAmt2 = n3rdAmt2;
		this.asaNo = asaNo;
		this.eqvLoclAmt = eqvLoclAmt;
		this.asaCurrCd = asaCurrCd;
		this.agnCd = agnCd;
		this.ibflag = ibflag;
		this.usrId = usrId;
		this.asaCltSeq = asaCltSeq;
		this.portCd = portCd;
		this.dueDt = dueDt;
		this.glYrmonTo = glYrmonTo;
		this.chgUsdAmt = chgUsdAmt;
		this.dueDtTo = dueDtTo;
		this.loclAmt = loclAmt;
		this.ibObCd = ibObCd;
		this.arOfcCd = arOfcCd;
		this.invNo = invNo;
		this.n3rdXchRt1 = n3rdXchRt1;
		this.n3rdXchRt2 = n3rdXchRt2;
		this.usdAmt = usdAmt;
		this.dueDtFm = dueDtFm;
		this.n3rdXchRt3 = n3rdXchRt3;
		this.n3rdXchRt4 = n3rdXchRt4;
		this.asaXchRt1 = asaXchRt1;
		this.asaXchRt2 = asaXchRt2;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("chg_tp_cd", getChgTpCd());
		this.hashColumns.put("gl_yrmon", getGlYrmon());
		this.hashColumns.put("n3rd_curr_cd1", getN3rdCurrCd1());
		this.hashColumns.put("n3rd_locl_amt4", getN3rdLoclAmt4());
		this.hashColumns.put("n3rd_locl_amt3", getN3rdLoclAmt3());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("n3rd_locl_amt2", getN3rdLoclAmt2());
		this.hashColumns.put("n3rd_locl_amt1", getN3rdLoclAmt1());
		this.hashColumns.put("n3rd_curr_cd4", getN3rdCurrCd4());
		this.hashColumns.put("ttl_amt", getTtlAmt());
		this.hashColumns.put("n3rd_curr_cd3", getN3rdCurrCd3());
		this.hashColumns.put("n3rd_curr_cd2", getN3rdCurrCd2());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("sail_arr_dt", getSailArrDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("option1", getOption1());
		this.hashColumns.put("option2", getOption2());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("asa_rmk", getAsaRmk());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("asa_tp_cd", getAsaTpCd());
		this.hashColumns.put("gl_yrmon_fm", getGlYrmonFm());
		this.hashColumns.put("asa_no1", getAsaNo1());
		this.hashColumns.put("asa_no3", getAsaNo3());
		this.hashColumns.put("asa_no2", getAsaNo2());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("eqv_locl_amt2", getEqvLoclAmt2());
		this.hashColumns.put("bnd", getBnd());
		this.hashColumns.put("n3rd_amt3", getN3rdAmt3());
		this.hashColumns.put("n3rd_amt4", getN3rdAmt4());
		this.hashColumns.put("n3rd_amt1", getN3rdAmt1());
		this.hashColumns.put("n3rd_amt2", getN3rdAmt2());
		this.hashColumns.put("asa_no", getAsaNo());
		this.hashColumns.put("eqv_locl_amt", getEqvLoclAmt());
		this.hashColumns.put("asa_curr_cd", getAsaCurrCd());
		this.hashColumns.put("agn_cd", getAgnCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("asa_clt_seq", getAsaCltSeq());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("due_dt", getDueDt());
		this.hashColumns.put("gl_yrmon_to", getGlYrmonTo());
		this.hashColumns.put("chg_usd_amt", getChgUsdAmt());
		this.hashColumns.put("due_dt_to", getDueDtTo());
		this.hashColumns.put("locl_amt", getLoclAmt());
		this.hashColumns.put("ib_ob_cd", getIbObCd());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("n3rd_xch_rt1", getN3rdXchRt1());
		this.hashColumns.put("n3rd_xch_rt2", getN3rdXchRt2());
		this.hashColumns.put("usd_amt", getUsdAmt());
		this.hashColumns.put("due_dt_fm", getDueDtFm());
		this.hashColumns.put("n3rd_xch_rt3", getN3rdXchRt3());
		this.hashColumns.put("n3rd_xch_rt4", getN3rdXchRt4());
		this.hashColumns.put("asa_xch_rt1", getAsaXchRt1());
		this.hashColumns.put("asa_xch_rt2", getAsaXchRt2());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("chg_tp_cd", "chgTpCd");
		this.hashFields.put("gl_yrmon", "glYrmon");
		this.hashFields.put("n3rd_curr_cd1", "n3rdCurrCd1");
		this.hashFields.put("n3rd_locl_amt4", "n3rdLoclAmt4");
		this.hashFields.put("n3rd_locl_amt3", "n3rdLoclAmt3");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("n3rd_locl_amt2", "n3rdLoclAmt2");
		this.hashFields.put("n3rd_locl_amt1", "n3rdLoclAmt1");
		this.hashFields.put("n3rd_curr_cd4", "n3rdCurrCd4");
		this.hashFields.put("ttl_amt", "ttlAmt");
		this.hashFields.put("n3rd_curr_cd3", "n3rdCurrCd3");
		this.hashFields.put("n3rd_curr_cd2", "n3rdCurrCd2");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("option1", "option1");
		this.hashFields.put("option2", "option2");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("asa_rmk", "asaRmk");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("asa_tp_cd", "asaTpCd");
		this.hashFields.put("gl_yrmon_fm", "glYrmonFm");
		this.hashFields.put("asa_no1", "asaNo1");
		this.hashFields.put("asa_no3", "asaNo3");
		this.hashFields.put("asa_no2", "asaNo2");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("eqv_locl_amt2", "eqvLoclAmt2");
		this.hashFields.put("bnd", "bnd");
		this.hashFields.put("n3rd_amt3", "n3rdAmt3");
		this.hashFields.put("n3rd_amt4", "n3rdAmt4");
		this.hashFields.put("n3rd_amt1", "n3rdAmt1");
		this.hashFields.put("n3rd_amt2", "n3rdAmt2");
		this.hashFields.put("asa_no", "asaNo");
		this.hashFields.put("eqv_locl_amt", "eqvLoclAmt");
		this.hashFields.put("asa_curr_cd", "asaCurrCd");
		this.hashFields.put("agn_cd", "agnCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("asa_clt_seq", "asaCltSeq");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("due_dt", "dueDt");
		this.hashFields.put("gl_yrmon_to", "glYrmonTo");
		this.hashFields.put("chg_usd_amt", "chgUsdAmt");
		this.hashFields.put("due_dt_to", "dueDtTo");
		this.hashFields.put("locl_amt", "loclAmt");
		this.hashFields.put("ib_ob_cd", "ibObCd");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("n3rd_xch_rt1", "n3rdXchRt1");
		this.hashFields.put("n3rd_xch_rt2", "n3rdXchRt2");
		this.hashFields.put("usd_amt", "usdAmt");
		this.hashFields.put("due_dt_fm", "dueDtFm");
		this.hashFields.put("n3rd_xch_rt3", "n3rdXchRt3");
		this.hashFields.put("n3rd_xch_rt4", "n3rdXchRt4");
		this.hashFields.put("asa_xch_rt1", "asaXchRt1");
		this.hashFields.put("asa_xch_rt2", "asaXchRt2");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return chgTpCd
	 */
	public String getChgTpCd() {
		return this.chgTpCd;
	}
	
	/**
	 * Column Info
	 * @return glYrmon
	 */
	public String getGlYrmon() {
		return this.glYrmon;
	}
	
	/**
	 * Column Info
	 * @return n3rdCurrCd1
	 */
	public String getN3rdCurrCd1() {
		return this.n3rdCurrCd1;
	}
	
	/**
	 * Column Info
	 * @return n3rdLoclAmt4
	 */
	public String getN3rdLoclAmt4() {
		return this.n3rdLoclAmt4;
	}
	
	/**
	 * Column Info
	 * @return n3rdLoclAmt3
	 */
	public String getN3rdLoclAmt3() {
		return this.n3rdLoclAmt3;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return n3rdLoclAmt2
	 */
	public String getN3rdLoclAmt2() {
		return this.n3rdLoclAmt2;
	}
	
	/**
	 * Column Info
	 * @return n3rdLoclAmt1
	 */
	public String getN3rdLoclAmt1() {
		return this.n3rdLoclAmt1;
	}
	
	/**
	 * Column Info
	 * @return n3rdCurrCd4
	 */
	public String getN3rdCurrCd4() {
		return this.n3rdCurrCd4;
	}
	
	/**
	 * Column Info
	 * @return ttlAmt
	 */
	public String getTtlAmt() {
		return this.ttlAmt;
	}
	
	/**
	 * Column Info
	 * @return n3rdCurrCd3
	 */
	public String getN3rdCurrCd3() {
		return this.n3rdCurrCd3;
	}
	
	/**
	 * Column Info
	 * @return n3rdCurrCd2
	 */
	public String getN3rdCurrCd2() {
		return this.n3rdCurrCd2;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return sailArrDt
	 */
	public String getSailArrDt() {
		return this.sailArrDt;
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
	 * @return option1
	 */
	public String getOption1() {
		return this.option1;
	}
	
	/**
	 * Column Info
	 * @return option2
	 */
	public String getOption2() {
		return this.option2;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return asaRmk
	 */
	public String getAsaRmk() {
		return this.asaRmk;
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
	 * @return asaTpCd
	 */
	public String getAsaTpCd() {
		return this.asaTpCd;
	}
	
	/**
	 * Column Info
	 * @return glYrmonFm
	 */
	public String getGlYrmonFm() {
		return this.glYrmonFm;
	}
	
	/**
	 * Column Info
	 * @return asaNo1
	 */
	public String getAsaNo1() {
		return this.asaNo1;
	}
	
	/**
	 * Column Info
	 * @return asaNo3
	 */
	public String getAsaNo3() {
		return this.asaNo3;
	}
	
	/**
	 * Column Info
	 * @return asaNo2
	 */
	public String getAsaNo2() {
		return this.asaNo2;
	}
	
	/**
	 * Column Info
	 * @return loclCurrCd
	 */
	public String getLoclCurrCd() {
		return this.loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return eqvLoclAmt2
	 */
	public String getEqvLoclAmt2() {
		return this.eqvLoclAmt2;
	}
	
	/**
	 * Column Info
	 * @return bnd
	 */
	public String getBnd() {
		return this.bnd;
	}
	
	/**
	 * Column Info
	 * @return n3rdAmt3
	 */
	public String getN3rdAmt3() {
		return this.n3rdAmt3;
	}
	
	/**
	 * Column Info
	 * @return n3rdAmt4
	 */
	public String getN3rdAmt4() {
		return this.n3rdAmt4;
	}
	
	/**
	 * Column Info
	 * @return n3rdAmt1
	 */
	public String getN3rdAmt1() {
		return this.n3rdAmt1;
	}
	
	/**
	 * Column Info
	 * @return n3rdAmt2
	 */
	public String getN3rdAmt2() {
		return this.n3rdAmt2;
	}
	
	/**
	 * Column Info
	 * @return asaNo
	 */
	public String getAsaNo() {
		return this.asaNo;
	}
	
	/**
	 * Column Info
	 * @return eqvLoclAmt
	 */
	public String getEqvLoclAmt() {
		return this.eqvLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return asaCurrCd
	 */
	public String getAsaCurrCd() {
		return this.asaCurrCd;
	}
	
	/**
	 * Column Info
	 * @return agnCd
	 */
	public String getAgnCd() {
		return this.agnCd;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return asaCltSeq
	 */
	public String getAsaCltSeq() {
		return this.asaCltSeq;
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
	 * @return dueDt
	 */
	public String getDueDt() {
		return this.dueDt;
	}
	
	/**
	 * Column Info
	 * @return glYrmonTo
	 */
	public String getGlYrmonTo() {
		return this.glYrmonTo;
	}
	
	/**
	 * Column Info
	 * @return chgUsdAmt
	 */
	public String getChgUsdAmt() {
		return this.chgUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return dueDtTo
	 */
	public String getDueDtTo() {
		return this.dueDtTo;
	}
	
	/**
	 * Column Info
	 * @return loclAmt
	 */
	public String getLoclAmt() {
		return this.loclAmt;
	}
	
	/**
	 * Column Info
	 * @return ibObCd
	 */
	public String getIbObCd() {
		return this.ibObCd;
	}
	
	/**
	 * Column Info
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
	}
	
	/**
	 * Column Info
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
	}
	
	/**
	 * Column Info
	 * @return n3rdXchRt1
	 */
	public String getN3rdXchRt1() {
		return this.n3rdXchRt1;
	}
	
	/**
	 * Column Info
	 * @return n3rdXchRt2
	 */
	public String getN3rdXchRt2() {
		return this.n3rdXchRt2;
	}
	
	/**
	 * Column Info
	 * @return usdAmt
	 */
	public String getUsdAmt() {
		return this.usdAmt;
	}
	
	/**
	 * Column Info
	 * @return dueDtFm
	 */
	public String getDueDtFm() {
		return this.dueDtFm;
	}
	
	/**
	 * Column Info
	 * @return n3rdXchRt3
	 */
	public String getN3rdXchRt3() {
		return this.n3rdXchRt3;
	}
	
	/**
	 * Column Info
	 * @return n3rdXchRt4
	 */
	public String getN3rdXchRt4() {
		return this.n3rdXchRt4;
	}
	
	/**
	 * Column Info
	 * @return asaXchRt1
	 */
	public String getAsaXchRt1() {
		return this.asaXchRt1;
	}
	
	/**
	 * Column Info
	 * @return asaXchRt2
	 */
	public String getAsaXchRt2() {
		return this.asaXchRt2;
	}
	

	/**
	 * Column Info
	 * @param chgTpCd
	 */
	public void setChgTpCd(String chgTpCd) {
		this.chgTpCd = chgTpCd;
	}
	
	/**
	 * Column Info
	 * @param glYrmon
	 */
	public void setGlYrmon(String glYrmon) {
		this.glYrmon = glYrmon;
	}
	
	/**
	 * Column Info
	 * @param n3rdCurrCd1
	 */
	public void setN3rdCurrCd1(String n3rdCurrCd1) {
		this.n3rdCurrCd1 = n3rdCurrCd1;
	}
	
	/**
	 * Column Info
	 * @param n3rdLoclAmt4
	 */
	public void setN3rdLoclAmt4(String n3rdLoclAmt4) {
		this.n3rdLoclAmt4 = n3rdLoclAmt4;
	}
	
	/**
	 * Column Info
	 * @param n3rdLoclAmt3
	 */
	public void setN3rdLoclAmt3(String n3rdLoclAmt3) {
		this.n3rdLoclAmt3 = n3rdLoclAmt3;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param n3rdLoclAmt2
	 */
	public void setN3rdLoclAmt2(String n3rdLoclAmt2) {
		this.n3rdLoclAmt2 = n3rdLoclAmt2;
	}
	
	/**
	 * Column Info
	 * @param n3rdLoclAmt1
	 */
	public void setN3rdLoclAmt1(String n3rdLoclAmt1) {
		this.n3rdLoclAmt1 = n3rdLoclAmt1;
	}
	
	/**
	 * Column Info
	 * @param n3rdCurrCd4
	 */
	public void setN3rdCurrCd4(String n3rdCurrCd4) {
		this.n3rdCurrCd4 = n3rdCurrCd4;
	}
	
	/**
	 * Column Info
	 * @param ttlAmt
	 */
	public void setTtlAmt(String ttlAmt) {
		this.ttlAmt = ttlAmt;
	}
	
	/**
	 * Column Info
	 * @param n3rdCurrCd3
	 */
	public void setN3rdCurrCd3(String n3rdCurrCd3) {
		this.n3rdCurrCd3 = n3rdCurrCd3;
	}
	
	/**
	 * Column Info
	 * @param n3rdCurrCd2
	 */
	public void setN3rdCurrCd2(String n3rdCurrCd2) {
		this.n3rdCurrCd2 = n3rdCurrCd2;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param sailArrDt
	 */
	public void setSailArrDt(String sailArrDt) {
		this.sailArrDt = sailArrDt;
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
	 * @param option1
	 */
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	
	/**
	 * Column Info
	 * @param option2
	 */
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	
	/**
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param asaRmk
	 */
	public void setAsaRmk(String asaRmk) {
		this.asaRmk = asaRmk;
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
	 * @param asaTpCd
	 */
	public void setAsaTpCd(String asaTpCd) {
		this.asaTpCd = asaTpCd;
	}
	
	/**
	 * Column Info
	 * @param glYrmonFm
	 */
	public void setGlYrmonFm(String glYrmonFm) {
		this.glYrmonFm = glYrmonFm;
	}
	
	/**
	 * Column Info
	 * @param asaNo1
	 */
	public void setAsaNo1(String asaNo1) {
		this.asaNo1 = asaNo1;
	}
	
	/**
	 * Column Info
	 * @param asaNo3
	 */
	public void setAsaNo3(String asaNo3) {
		this.asaNo3 = asaNo3;
	}
	
	/**
	 * Column Info
	 * @param asaNo2
	 */
	public void setAsaNo2(String asaNo2) {
		this.asaNo2 = asaNo2;
	}
	
	/**
	 * Column Info
	 * @param loclCurrCd
	 */
	public void setLoclCurrCd(String loclCurrCd) {
		this.loclCurrCd = loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param eqvLoclAmt2
	 */
	public void setEqvLoclAmt2(String eqvLoclAmt2) {
		this.eqvLoclAmt2 = eqvLoclAmt2;
	}
	
	/**
	 * Column Info
	 * @param bnd
	 */
	public void setBnd(String bnd) {
		this.bnd = bnd;
	}
	
	/**
	 * Column Info
	 * @param n3rdAmt3
	 */
	public void setN3rdAmt3(String n3rdAmt3) {
		this.n3rdAmt3 = n3rdAmt3;
	}
	
	/**
	 * Column Info
	 * @param n3rdAmt4
	 */
	public void setN3rdAmt4(String n3rdAmt4) {
		this.n3rdAmt4 = n3rdAmt4;
	}
	
	/**
	 * Column Info
	 * @param n3rdAmt1
	 */
	public void setN3rdAmt1(String n3rdAmt1) {
		this.n3rdAmt1 = n3rdAmt1;
	}
	
	/**
	 * Column Info
	 * @param n3rdAmt2
	 */
	public void setN3rdAmt2(String n3rdAmt2) {
		this.n3rdAmt2 = n3rdAmt2;
	}
	
	/**
	 * Column Info
	 * @param asaNo
	 */
	public void setAsaNo(String asaNo) {
		this.asaNo = asaNo;
	}
	
	/**
	 * Column Info
	 * @param eqvLoclAmt
	 */
	public void setEqvLoclAmt(String eqvLoclAmt) {
		this.eqvLoclAmt = eqvLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param asaCurrCd
	 */
	public void setAsaCurrCd(String asaCurrCd) {
		this.asaCurrCd = asaCurrCd;
	}
	
	/**
	 * Column Info
	 * @param agnCd
	 */
	public void setAgnCd(String agnCd) {
		this.agnCd = agnCd;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param asaCltSeq
	 */
	public void setAsaCltSeq(String asaCltSeq) {
		this.asaCltSeq = asaCltSeq;
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
	 * @param dueDt
	 */
	public void setDueDt(String dueDt) {
		this.dueDt = dueDt;
	}
	
	/**
	 * Column Info
	 * @param glYrmonTo
	 */
	public void setGlYrmonTo(String glYrmonTo) {
		this.glYrmonTo = glYrmonTo;
	}
	
	/**
	 * Column Info
	 * @param chgUsdAmt
	 */
	public void setChgUsdAmt(String chgUsdAmt) {
		this.chgUsdAmt = chgUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param dueDtTo
	 */
	public void setDueDtTo(String dueDtTo) {
		this.dueDtTo = dueDtTo;
	}
	
	/**
	 * Column Info
	 * @param loclAmt
	 */
	public void setLoclAmt(String loclAmt) {
		this.loclAmt = loclAmt;
	}
	
	/**
	 * Column Info
	 * @param ibObCd
	 */
	public void setIbObCd(String ibObCd) {
		this.ibObCd = ibObCd;
	}
	
	/**
	 * Column Info
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
	}
	
	/**
	 * Column Info
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	
	/**
	 * Column Info
	 * @param n3rdXchRt1
	 */
	public void setN3rdXchRt1(String n3rdXchRt1) {
		this.n3rdXchRt1 = n3rdXchRt1;
	}
	
	/**
	 * Column Info
	 * @param n3rdXchRt2
	 */
	public void setN3rdXchRt2(String n3rdXchRt2) {
		this.n3rdXchRt2 = n3rdXchRt2;
	}
	
	/**
	 * Column Info
	 * @param usdAmt
	 */
	public void setUsdAmt(String usdAmt) {
		this.usdAmt = usdAmt;
	}
	
	/**
	 * Column Info
	 * @param dueDtFm
	 */
	public void setDueDtFm(String dueDtFm) {
		this.dueDtFm = dueDtFm;
	}
	
	/**
	 * Column Info
	 * @param n3rdXchRt3
	 */
	public void setN3rdXchRt3(String n3rdXchRt3) {
		this.n3rdXchRt3 = n3rdXchRt3;
	}
	
	/**
	 * Column Info
	 * @param n3rdXchRt4
	 */
	public void setN3rdXchRt4(String n3rdXchRt4) {
		this.n3rdXchRt4 = n3rdXchRt4;
	}
	
	/**
	 * Column Info
	 * @param asaXchRt1
	 */
	public void setAsaXchRt1(String asaXchRt1) {
		this.asaXchRt1 = asaXchRt1;
	}
	
	/**
	 * Column Info
	 * @param asaXchRt2
	 */
	public void setAsaXchRt2(String asaXchRt2) {
		this.asaXchRt2 = asaXchRt2;
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
		setChgTpCd(JSPUtil.getParameter(request, prefix + "chg_tp_cd", ""));
		setGlYrmon(JSPUtil.getParameter(request, prefix + "gl_yrmon", ""));
		setN3rdCurrCd1(JSPUtil.getParameter(request, prefix + "n3rd_curr_cd1", ""));
		setN3rdLoclAmt4(JSPUtil.getParameter(request, prefix + "n3rd_locl_amt4", ""));
		setN3rdLoclAmt3(JSPUtil.getParameter(request, prefix + "n3rd_locl_amt3", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setN3rdLoclAmt2(JSPUtil.getParameter(request, prefix + "n3rd_locl_amt2", ""));
		setN3rdLoclAmt1(JSPUtil.getParameter(request, prefix + "n3rd_locl_amt1", ""));
		setN3rdCurrCd4(JSPUtil.getParameter(request, prefix + "n3rd_curr_cd4", ""));
		setTtlAmt(JSPUtil.getParameter(request, prefix + "ttl_amt", ""));
		setN3rdCurrCd3(JSPUtil.getParameter(request, prefix + "n3rd_curr_cd3", ""));
		setN3rdCurrCd2(JSPUtil.getParameter(request, prefix + "n3rd_curr_cd2", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setSailArrDt(JSPUtil.getParameter(request, prefix + "sail_arr_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOption1(JSPUtil.getParameter(request, prefix + "option1", ""));
		setOption2(JSPUtil.getParameter(request, prefix + "option2", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setAsaRmk(JSPUtil.getParameter(request, prefix + "asa_rmk", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setAsaTpCd(JSPUtil.getParameter(request, prefix + "asa_tp_cd", ""));
		setGlYrmonFm(JSPUtil.getParameter(request, prefix + "gl_yrmon_fm", ""));
		setAsaNo1(JSPUtil.getParameter(request, prefix + "asa_no1", ""));
		setAsaNo3(JSPUtil.getParameter(request, prefix + "asa_no3", ""));
		setAsaNo2(JSPUtil.getParameter(request, prefix + "asa_no2", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, prefix + "locl_curr_cd", ""));
		setEqvLoclAmt2(JSPUtil.getParameter(request, prefix + "eqv_locl_amt2", ""));
		setBnd(JSPUtil.getParameter(request, prefix + "bnd", ""));
		setN3rdAmt3(JSPUtil.getParameter(request, prefix + "n3rd_amt3", ""));
		setN3rdAmt4(JSPUtil.getParameter(request, prefix + "n3rd_amt4", ""));
		setN3rdAmt1(JSPUtil.getParameter(request, prefix + "n3rd_amt1", ""));
		setN3rdAmt2(JSPUtil.getParameter(request, prefix + "n3rd_amt2", ""));
		setAsaNo(JSPUtil.getParameter(request, prefix + "asa_no", ""));
		setEqvLoclAmt(JSPUtil.getParameter(request, prefix + "eqv_locl_amt", ""));
		setAsaCurrCd(JSPUtil.getParameter(request, prefix + "asa_curr_cd", ""));
		setAgnCd(JSPUtil.getParameter(request, prefix + "agn_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setAsaCltSeq(JSPUtil.getParameter(request, prefix + "asa_clt_seq", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setDueDt(JSPUtil.getParameter(request, prefix + "due_dt", ""));
		setGlYrmonTo(JSPUtil.getParameter(request, prefix + "gl_yrmon_to", ""));
		setChgUsdAmt(JSPUtil.getParameter(request, prefix + "chg_usd_amt", ""));
		setDueDtTo(JSPUtil.getParameter(request, prefix + "due_dt_to", ""));
		setLoclAmt(JSPUtil.getParameter(request, prefix + "locl_amt", ""));
		setIbObCd(JSPUtil.getParameter(request, prefix + "ib_ob_cd", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setN3rdXchRt1(JSPUtil.getParameter(request, prefix + "n3rd_xch_rt1", ""));
		setN3rdXchRt2(JSPUtil.getParameter(request, prefix + "n3rd_xch_rt2", ""));
		setUsdAmt(JSPUtil.getParameter(request, prefix + "usd_amt", ""));
		setDueDtFm(JSPUtil.getParameter(request, prefix + "due_dt_fm", ""));
		setN3rdXchRt3(JSPUtil.getParameter(request, prefix + "n3rd_xch_rt3", ""));
		setN3rdXchRt4(JSPUtil.getParameter(request, prefix + "n3rd_xch_rt4", ""));
		setAsaXchRt1(JSPUtil.getParameter(request, prefix + "asa_xch_rt1", ""));
		setAsaXchRt2(JSPUtil.getParameter(request, prefix + "asa_xch_rt2", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AgentCollectionListVO[]
	 */
	public AgentCollectionListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AgentCollectionListVO[]
	 */
	public AgentCollectionListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AgentCollectionListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] chgTpCd = (JSPUtil.getParameter(request, prefix	+ "chg_tp_cd", length));
			String[] glYrmon = (JSPUtil.getParameter(request, prefix	+ "gl_yrmon", length));
			String[] n3rdCurrCd1 = (JSPUtil.getParameter(request, prefix	+ "n3rd_curr_cd1", length));
			String[] n3rdLoclAmt4 = (JSPUtil.getParameter(request, prefix	+ "n3rd_locl_amt4", length));
			String[] n3rdLoclAmt3 = (JSPUtil.getParameter(request, prefix	+ "n3rd_locl_amt3", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] n3rdLoclAmt2 = (JSPUtil.getParameter(request, prefix	+ "n3rd_locl_amt2", length));
			String[] n3rdLoclAmt1 = (JSPUtil.getParameter(request, prefix	+ "n3rd_locl_amt1", length));
			String[] n3rdCurrCd4 = (JSPUtil.getParameter(request, prefix	+ "n3rd_curr_cd4", length));
			String[] ttlAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_amt", length));
			String[] n3rdCurrCd3 = (JSPUtil.getParameter(request, prefix	+ "n3rd_curr_cd3", length));
			String[] n3rdCurrCd2 = (JSPUtil.getParameter(request, prefix	+ "n3rd_curr_cd2", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] sailArrDt = (JSPUtil.getParameter(request, prefix	+ "sail_arr_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] option1 = (JSPUtil.getParameter(request, prefix	+ "option1", length));
			String[] option2 = (JSPUtil.getParameter(request, prefix	+ "option2", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] asaRmk = (JSPUtil.getParameter(request, prefix	+ "asa_rmk", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] asaTpCd = (JSPUtil.getParameter(request, prefix	+ "asa_tp_cd", length));
			String[] glYrmonFm = (JSPUtil.getParameter(request, prefix	+ "gl_yrmon_fm", length));
			String[] asaNo1 = (JSPUtil.getParameter(request, prefix	+ "asa_no1", length));
			String[] asaNo3 = (JSPUtil.getParameter(request, prefix	+ "asa_no3", length));
			String[] asaNo2 = (JSPUtil.getParameter(request, prefix	+ "asa_no2", length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd", length));
			String[] eqvLoclAmt2 = (JSPUtil.getParameter(request, prefix	+ "eqv_locl_amt2", length));
			String[] bnd = (JSPUtil.getParameter(request, prefix	+ "bnd", length));
			String[] n3rdAmt3 = (JSPUtil.getParameter(request, prefix	+ "n3rd_amt3", length));
			String[] n3rdAmt4 = (JSPUtil.getParameter(request, prefix	+ "n3rd_amt4", length));
			String[] n3rdAmt1 = (JSPUtil.getParameter(request, prefix	+ "n3rd_amt1", length));
			String[] n3rdAmt2 = (JSPUtil.getParameter(request, prefix	+ "n3rd_amt2", length));
			String[] asaNo = (JSPUtil.getParameter(request, prefix	+ "asa_no", length));
			String[] eqvLoclAmt = (JSPUtil.getParameter(request, prefix	+ "eqv_locl_amt", length));
			String[] asaCurrCd = (JSPUtil.getParameter(request, prefix	+ "asa_curr_cd", length));
			String[] agnCd = (JSPUtil.getParameter(request, prefix	+ "agn_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] asaCltSeq = (JSPUtil.getParameter(request, prefix	+ "asa_clt_seq", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] dueDt = (JSPUtil.getParameter(request, prefix	+ "due_dt", length));
			String[] glYrmonTo = (JSPUtil.getParameter(request, prefix	+ "gl_yrmon_to", length));
			String[] chgUsdAmt = (JSPUtil.getParameter(request, prefix	+ "chg_usd_amt", length));
			String[] dueDtTo = (JSPUtil.getParameter(request, prefix	+ "due_dt_to", length));
			String[] loclAmt = (JSPUtil.getParameter(request, prefix	+ "locl_amt", length));
			String[] ibObCd = (JSPUtil.getParameter(request, prefix	+ "ib_ob_cd", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] n3rdXchRt1 = (JSPUtil.getParameter(request, prefix	+ "n3rd_xch_rt1", length));
			String[] n3rdXchRt2 = (JSPUtil.getParameter(request, prefix	+ "n3rd_xch_rt2", length));
			String[] usdAmt = (JSPUtil.getParameter(request, prefix	+ "usd_amt", length));
			String[] dueDtFm = (JSPUtil.getParameter(request, prefix	+ "due_dt_fm", length));
			String[] n3rdXchRt3 = (JSPUtil.getParameter(request, prefix	+ "n3rd_xch_rt3", length));
			String[] n3rdXchRt4 = (JSPUtil.getParameter(request, prefix	+ "n3rd_xch_rt4", length));
			String[] asaXchRt1 = (JSPUtil.getParameter(request, prefix	+ "asa_xch_rt1", length));
			String[] asaXchRt2 = (JSPUtil.getParameter(request, prefix	+ "asa_xch_rt2", length));
			
			for (int i = 0; i < length; i++) {
				model = new AgentCollectionListVO();
				if (chgTpCd[i] != null)
					model.setChgTpCd(chgTpCd[i]);
				if (glYrmon[i] != null)
					model.setGlYrmon(glYrmon[i]);
				if (n3rdCurrCd1[i] != null)
					model.setN3rdCurrCd1(n3rdCurrCd1[i]);
				if (n3rdLoclAmt4[i] != null)
					model.setN3rdLoclAmt4(n3rdLoclAmt4[i]);
				if (n3rdLoclAmt3[i] != null)
					model.setN3rdLoclAmt3(n3rdLoclAmt3[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (n3rdLoclAmt2[i] != null)
					model.setN3rdLoclAmt2(n3rdLoclAmt2[i]);
				if (n3rdLoclAmt1[i] != null)
					model.setN3rdLoclAmt1(n3rdLoclAmt1[i]);
				if (n3rdCurrCd4[i] != null)
					model.setN3rdCurrCd4(n3rdCurrCd4[i]);
				if (ttlAmt[i] != null)
					model.setTtlAmt(ttlAmt[i]);
				if (n3rdCurrCd3[i] != null)
					model.setN3rdCurrCd3(n3rdCurrCd3[i]);
				if (n3rdCurrCd2[i] != null)
					model.setN3rdCurrCd2(n3rdCurrCd2[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (sailArrDt[i] != null)
					model.setSailArrDt(sailArrDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (option1[i] != null)
					model.setOption1(option1[i]);
				if (option2[i] != null)
					model.setOption2(option2[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (asaRmk[i] != null)
					model.setAsaRmk(asaRmk[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (asaTpCd[i] != null)
					model.setAsaTpCd(asaTpCd[i]);
				if (glYrmonFm[i] != null)
					model.setGlYrmonFm(glYrmonFm[i]);
				if (asaNo1[i] != null)
					model.setAsaNo1(asaNo1[i]);
				if (asaNo3[i] != null)
					model.setAsaNo3(asaNo3[i]);
				if (asaNo2[i] != null)
					model.setAsaNo2(asaNo2[i]);
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (eqvLoclAmt2[i] != null)
					model.setEqvLoclAmt2(eqvLoclAmt2[i]);
				if (bnd[i] != null)
					model.setBnd(bnd[i]);
				if (n3rdAmt3[i] != null)
					model.setN3rdAmt3(n3rdAmt3[i]);
				if (n3rdAmt4[i] != null)
					model.setN3rdAmt4(n3rdAmt4[i]);
				if (n3rdAmt1[i] != null)
					model.setN3rdAmt1(n3rdAmt1[i]);
				if (n3rdAmt2[i] != null)
					model.setN3rdAmt2(n3rdAmt2[i]);
				if (asaNo[i] != null)
					model.setAsaNo(asaNo[i]);
				if (eqvLoclAmt[i] != null)
					model.setEqvLoclAmt(eqvLoclAmt[i]);
				if (asaCurrCd[i] != null)
					model.setAsaCurrCd(asaCurrCd[i]);
				if (agnCd[i] != null)
					model.setAgnCd(agnCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (asaCltSeq[i] != null)
					model.setAsaCltSeq(asaCltSeq[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (dueDt[i] != null)
					model.setDueDt(dueDt[i]);
				if (glYrmonTo[i] != null)
					model.setGlYrmonTo(glYrmonTo[i]);
				if (chgUsdAmt[i] != null)
					model.setChgUsdAmt(chgUsdAmt[i]);
				if (dueDtTo[i] != null)
					model.setDueDtTo(dueDtTo[i]);
				if (loclAmt[i] != null)
					model.setLoclAmt(loclAmt[i]);
				if (ibObCd[i] != null)
					model.setIbObCd(ibObCd[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (n3rdXchRt1[i] != null)
					model.setN3rdXchRt1(n3rdXchRt1[i]);
				if (n3rdXchRt2[i] != null)
					model.setN3rdXchRt2(n3rdXchRt2[i]);
				if (usdAmt[i] != null)
					model.setUsdAmt(usdAmt[i]);
				if (dueDtFm[i] != null)
					model.setDueDtFm(dueDtFm[i]);
				if (n3rdXchRt3[i] != null)
					model.setN3rdXchRt3(n3rdXchRt3[i]);
				if (n3rdXchRt4[i] != null)
					model.setN3rdXchRt4(n3rdXchRt4[i]);
				if (asaXchRt1[i] != null)
					model.setAsaXchRt1(asaXchRt1[i]);
				if (asaXchRt2[i] != null)
					model.setAsaXchRt2(asaXchRt2[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAgentCollectionListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AgentCollectionListVO[]
	 */
	public AgentCollectionListVO[] getAgentCollectionListVOs(){
		AgentCollectionListVO[] vos = (AgentCollectionListVO[])models.toArray(new AgentCollectionListVO[models.size()]);
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
		this.chgTpCd = this.chgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glYrmon = this.glYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdCurrCd1 = this.n3rdCurrCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdLoclAmt4 = this.n3rdLoclAmt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdLoclAmt3 = this.n3rdLoclAmt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdLoclAmt2 = this.n3rdLoclAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdLoclAmt1 = this.n3rdLoclAmt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdCurrCd4 = this.n3rdCurrCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlAmt = this.ttlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdCurrCd3 = this.n3rdCurrCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdCurrCd2 = this.n3rdCurrCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt = this.sailArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.option1 = this.option1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.option2 = this.option2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaRmk = this.asaRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaTpCd = this.asaTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glYrmonFm = this.glYrmonFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaNo1 = this.asaNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaNo3 = this.asaNo3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaNo2 = this.asaNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqvLoclAmt2 = this.eqvLoclAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bnd = this.bnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdAmt3 = this.n3rdAmt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdAmt4 = this.n3rdAmt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdAmt1 = this.n3rdAmt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdAmt2 = this.n3rdAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaNo = this.asaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqvLoclAmt = this.eqvLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaCurrCd = this.asaCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCd = this.agnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaCltSeq = this.asaCltSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDt = this.dueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glYrmonTo = this.glYrmonTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgUsdAmt = this.chgUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDtTo = this.dueDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclAmt = this.loclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibObCd = this.ibObCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdXchRt1 = this.n3rdXchRt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdXchRt2 = this.n3rdXchRt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdAmt = this.usdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDtFm = this.dueDtFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdXchRt3 = this.n3rdXchRt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdXchRt4 = this.n3rdXchRt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaXchRt1 = this.asaXchRt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaXchRt2 = this.asaXchRt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
