/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VslStatusIncntVO.java
*@FileTitle : VslStatusIncntVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.15
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.06.15 신동일 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.vo;

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
 * @author 신동일
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VslStatusIncntVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VslStatusIncntVO> models = new ArrayList<VslStatusIncntVO>();
	
	/* Column Info */
	private String mayRcvIncntAmt = null;
	/* Column Info */
	private String octRcvIncntAmt = null;
	/* Column Info */
	private String janRcvIncntAmt = null;
	/* Column Info */
	private String sepEstmIncntAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String atchFileLnkId = null;
	/* Column Info */
	private String vndrNm = null;
	/* Column Info */
	private String mayEstmIncntAmt = null;
	/* Column Info */
	private String decRcvIncntAmt = null;
	/* Column Info */
	private String atch2Flg = null;
	/* Column Info */
	private String janEstmIncntAmt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String ttlRcvAmt = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String julEstmIncntAmt = null;
	/* Column Info */
	private String decEstmIncntAmt = null;
	/* Column Info */
	private String atchFlg = null;
	/* Column Info */
	private String febEstmIncntAmt = null;
	/* Column Info */
	private String atchN2ndFileLnkId = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String yearUsdEstmIncntAmt = null;
	/* Column Info */
	private String sepRcvIncntAmt = null;
	/* Column Info */
	private String ttlRmnAmt = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String julRcvIncntAmt = null;
	/* Column Info */
	private String aprEstmIncntAmt = null;
	/* Column Info */
	private String junEstmIncntAmt = null;
	/* Column Info */
	private String octEstmIncntAmt = null;
	/* Column Info */
	private String marRcvIncntAmt = null;
	/* Column Info */
	private String ttlIncntAmt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String incntNo = null;
	/* Column Info */
	private String aprRcvIncntAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String itmCd = null;
	/* Column Info */
	private String junRcvIncntAmt = null;
	/* Column Info */
	private String febRcvIncntAmt = null;
	/* Column Info */
	private String augEstmIncntAmt = null;
	/* Column Info */
	private String novRcvIncntAmt = null;
	/* Column Info */
	private String marEstmIncntAmt = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String novEstmIncntAmt = null;
	/* Column Info */
	private String stlRmk = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String yearUsdBalIncntAmt = null;
	/* Column Info */
	private String yearUsdRcvIncntAmt = null;
	/* Column Info */
	private String augRcvIncntAmt = null;
	/* Column Info */
	private String bseYr = null;
	/* Column Info */
	private String instrRmk = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String usdRt = null;
	/* Column Info */
	private String incntRmk = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public VslStatusIncntVO() {}

	public VslStatusIncntVO(String ibflag, String pagerows, String bseYr, String incntNo, String rhqCd, String ofcCd, String portCd, String itmCd, String vndrSeq, String vndrNm, String currCd, String janEstmIncntAmt, String janRcvIncntAmt, String febEstmIncntAmt, String febRcvIncntAmt, String marEstmIncntAmt, String marRcvIncntAmt, String aprEstmIncntAmt, String aprRcvIncntAmt, String mayEstmIncntAmt, String mayRcvIncntAmt, String junEstmIncntAmt, String junRcvIncntAmt, String julEstmIncntAmt, String julRcvIncntAmt, String augEstmIncntAmt, String augRcvIncntAmt, String sepEstmIncntAmt, String sepRcvIncntAmt, String octEstmIncntAmt, String octRcvIncntAmt, String novEstmIncntAmt, String novRcvIncntAmt, String decEstmIncntAmt, String decRcvIncntAmt, String ttlIncntAmt, String ttlRcvAmt, String ttlRmnAmt, String yearUsdEstmIncntAmt, String yearUsdRcvIncntAmt, String yearUsdBalIncntAmt, String instrRmk, String stlRmk, String incntRmk, String atch2Flg, String atchN2ndFileLnkId, String atchFlg, String atchFileLnkId, String usdRt, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.mayRcvIncntAmt = mayRcvIncntAmt;
		this.octRcvIncntAmt = octRcvIncntAmt;
		this.janRcvIncntAmt = janRcvIncntAmt;
		this.sepEstmIncntAmt = sepEstmIncntAmt;
		this.pagerows = pagerows;
		this.atchFileLnkId = atchFileLnkId;
		this.vndrNm = vndrNm;
		this.mayEstmIncntAmt = mayEstmIncntAmt;
		this.decRcvIncntAmt = decRcvIncntAmt;
		this.atch2Flg = atch2Flg;
		this.janEstmIncntAmt = janEstmIncntAmt;
		this.updUsrId = updUsrId;
		this.ttlRcvAmt = ttlRcvAmt;
		this.rhqCd = rhqCd;
		this.julEstmIncntAmt = julEstmIncntAmt;
		this.decEstmIncntAmt = decEstmIncntAmt;
		this.atchFlg = atchFlg;
		this.febEstmIncntAmt = febEstmIncntAmt;
		this.atchN2ndFileLnkId = atchN2ndFileLnkId;
		this.creUsrId = creUsrId;
		this.yearUsdEstmIncntAmt = yearUsdEstmIncntAmt;
		this.sepRcvIncntAmt = sepRcvIncntAmt;
		this.ttlRmnAmt = ttlRmnAmt;
		this.vndrSeq = vndrSeq;
		this.julRcvIncntAmt = julRcvIncntAmt;
		this.aprEstmIncntAmt = aprEstmIncntAmt;
		this.junEstmIncntAmt = junEstmIncntAmt;
		this.octEstmIncntAmt = octEstmIncntAmt;
		this.marRcvIncntAmt = marRcvIncntAmt;
		this.ttlIncntAmt = ttlIncntAmt;
		this.currCd = currCd;
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.incntNo = incntNo;
		this.aprRcvIncntAmt = aprRcvIncntAmt;
		this.ibflag = ibflag;
		this.itmCd = itmCd;
		this.junRcvIncntAmt = junRcvIncntAmt;
		this.febRcvIncntAmt = febRcvIncntAmt;
		this.augEstmIncntAmt = augEstmIncntAmt;
		this.novRcvIncntAmt = novRcvIncntAmt;
		this.marEstmIncntAmt = marEstmIncntAmt;
		this.portCd = portCd;
		this.novEstmIncntAmt = novEstmIncntAmt;
		this.stlRmk = stlRmk;
		this.updDt = updDt;
		this.yearUsdBalIncntAmt = yearUsdBalIncntAmt;
		this.yearUsdRcvIncntAmt = yearUsdRcvIncntAmt;
		this.augRcvIncntAmt = augRcvIncntAmt;
		this.bseYr = bseYr;
		this.instrRmk = instrRmk;
		this.ofcCd = ofcCd;
		this.usdRt = usdRt;
		this.incntRmk = incntRmk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("may_rcv_incnt_amt", getMayRcvIncntAmt());
		this.hashColumns.put("oct_rcv_incnt_amt", getOctRcvIncntAmt());
		this.hashColumns.put("jan_rcv_incnt_amt", getJanRcvIncntAmt());
		this.hashColumns.put("sep_estm_incnt_amt", getSepEstmIncntAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("atch_file_lnk_id", getAtchFileLnkId());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("may_estm_incnt_amt", getMayEstmIncntAmt());
		this.hashColumns.put("dec_rcv_incnt_amt", getDecRcvIncntAmt());
		this.hashColumns.put("atch2_flg", getAtch2Flg());
		this.hashColumns.put("jan_estm_incnt_amt", getJanEstmIncntAmt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("ttl_rcv_amt", getTtlRcvAmt());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("jul_estm_incnt_amt", getJulEstmIncntAmt());
		this.hashColumns.put("dec_estm_incnt_amt", getDecEstmIncntAmt());
		this.hashColumns.put("atch_flg", getAtchFlg());
		this.hashColumns.put("feb_estm_incnt_amt", getFebEstmIncntAmt());
		this.hashColumns.put("atch_n2nd_file_lnk_id", getAtchN2ndFileLnkId());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("year_usd_estm_incnt_amt", getYearUsdEstmIncntAmt());
		this.hashColumns.put("sep_rcv_incnt_amt", getSepRcvIncntAmt());
		this.hashColumns.put("ttl_rmn_amt", getTtlRmnAmt());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("jul_rcv_incnt_amt", getJulRcvIncntAmt());
		this.hashColumns.put("apr_estm_incnt_amt", getAprEstmIncntAmt());
		this.hashColumns.put("jun_estm_incnt_amt", getJunEstmIncntAmt());
		this.hashColumns.put("oct_estm_incnt_amt", getOctEstmIncntAmt());
		this.hashColumns.put("mar_rcv_incnt_amt", getMarRcvIncntAmt());
		this.hashColumns.put("ttl_incnt_amt", getTtlIncntAmt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("incnt_no", getIncntNo());
		this.hashColumns.put("apr_rcv_incnt_amt", getAprRcvIncntAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("itm_cd", getItmCd());
		this.hashColumns.put("jun_rcv_incnt_amt", getJunRcvIncntAmt());
		this.hashColumns.put("feb_rcv_incnt_amt", getFebRcvIncntAmt());
		this.hashColumns.put("aug_estm_incnt_amt", getAugEstmIncntAmt());
		this.hashColumns.put("nov_rcv_incnt_amt", getNovRcvIncntAmt());
		this.hashColumns.put("mar_estm_incnt_amt", getMarEstmIncntAmt());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("nov_estm_incnt_amt", getNovEstmIncntAmt());
		this.hashColumns.put("stl_rmk", getStlRmk());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("year_usd_bal_incnt_amt", getYearUsdBalIncntAmt());
		this.hashColumns.put("year_usd_rcv_incnt_amt", getYearUsdRcvIncntAmt());
		this.hashColumns.put("aug_rcv_incnt_amt", getAugRcvIncntAmt());
		this.hashColumns.put("bse_yr", getBseYr());
		this.hashColumns.put("instr_rmk", getInstrRmk());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("usd_rt", getUsdRt());
		this.hashColumns.put("incnt_rmk", getIncntRmk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("may_rcv_incnt_amt", "mayRcvIncntAmt");
		this.hashFields.put("oct_rcv_incnt_amt", "octRcvIncntAmt");
		this.hashFields.put("jan_rcv_incnt_amt", "janRcvIncntAmt");
		this.hashFields.put("sep_estm_incnt_amt", "sepEstmIncntAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("atch_file_lnk_id", "atchFileLnkId");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("may_estm_incnt_amt", "mayEstmIncntAmt");
		this.hashFields.put("dec_rcv_incnt_amt", "decRcvIncntAmt");
		this.hashFields.put("atch2_flg", "atch2Flg");
		this.hashFields.put("jan_estm_incnt_amt", "janEstmIncntAmt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("ttl_rcv_amt", "ttlRcvAmt");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("jul_estm_incnt_amt", "julEstmIncntAmt");
		this.hashFields.put("dec_estm_incnt_amt", "decEstmIncntAmt");
		this.hashFields.put("atch_flg", "atchFlg");
		this.hashFields.put("feb_estm_incnt_amt", "febEstmIncntAmt");
		this.hashFields.put("atch_n2nd_file_lnk_id", "atchN2ndFileLnkId");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("year_usd_estm_incnt_amt", "yearUsdEstmIncntAmt");
		this.hashFields.put("sep_rcv_incnt_amt", "sepRcvIncntAmt");
		this.hashFields.put("ttl_rmn_amt", "ttlRmnAmt");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("jul_rcv_incnt_amt", "julRcvIncntAmt");
		this.hashFields.put("apr_estm_incnt_amt", "aprEstmIncntAmt");
		this.hashFields.put("jun_estm_incnt_amt", "junEstmIncntAmt");
		this.hashFields.put("oct_estm_incnt_amt", "octEstmIncntAmt");
		this.hashFields.put("mar_rcv_incnt_amt", "marRcvIncntAmt");
		this.hashFields.put("ttl_incnt_amt", "ttlIncntAmt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("incnt_no", "incntNo");
		this.hashFields.put("apr_rcv_incnt_amt", "aprRcvIncntAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("itm_cd", "itmCd");
		this.hashFields.put("jun_rcv_incnt_amt", "junRcvIncntAmt");
		this.hashFields.put("feb_rcv_incnt_amt", "febRcvIncntAmt");
		this.hashFields.put("aug_estm_incnt_amt", "augEstmIncntAmt");
		this.hashFields.put("nov_rcv_incnt_amt", "novRcvIncntAmt");
		this.hashFields.put("mar_estm_incnt_amt", "marEstmIncntAmt");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("nov_estm_incnt_amt", "novEstmIncntAmt");
		this.hashFields.put("stl_rmk", "stlRmk");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("year_usd_bal_incnt_amt", "yearUsdBalIncntAmt");
		this.hashFields.put("year_usd_rcv_incnt_amt", "yearUsdRcvIncntAmt");
		this.hashFields.put("aug_rcv_incnt_amt", "augRcvIncntAmt");
		this.hashFields.put("bse_yr", "bseYr");
		this.hashFields.put("instr_rmk", "instrRmk");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("usd_rt", "usdRt");
		this.hashFields.put("incnt_rmk", "incntRmk");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mayRcvIncntAmt
	 */
	public String getMayRcvIncntAmt() {
		return this.mayRcvIncntAmt;
	}
	
	/**
	 * Column Info
	 * @return octRcvIncntAmt
	 */
	public String getOctRcvIncntAmt() {
		return this.octRcvIncntAmt;
	}
	
	/**
	 * Column Info
	 * @return janRcvIncntAmt
	 */
	public String getJanRcvIncntAmt() {
		return this.janRcvIncntAmt;
	}
	
	/**
	 * Column Info
	 * @return sepEstmIncntAmt
	 */
	public String getSepEstmIncntAmt() {
		return this.sepEstmIncntAmt;
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
	 * @return atchFileLnkId
	 */
	public String getAtchFileLnkId() {
		return this.atchFileLnkId;
	}
	
	/**
	 * Column Info
	 * @return vndrNm
	 */
	public String getVndrNm() {
		return this.vndrNm;
	}
	
	/**
	 * Column Info
	 * @return mayEstmIncntAmt
	 */
	public String getMayEstmIncntAmt() {
		return this.mayEstmIncntAmt;
	}
	
	/**
	 * Column Info
	 * @return decRcvIncntAmt
	 */
	public String getDecRcvIncntAmt() {
		return this.decRcvIncntAmt;
	}
	
	/**
	 * Column Info
	 * @return atch2Flg
	 */
	public String getAtch2Flg() {
		return this.atch2Flg;
	}
	
	/**
	 * Column Info
	 * @return janEstmIncntAmt
	 */
	public String getJanEstmIncntAmt() {
		return this.janEstmIncntAmt;
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
	 * @return ttlRcvAmt
	 */
	public String getTtlRcvAmt() {
		return this.ttlRcvAmt;
	}
	
	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return julEstmIncntAmt
	 */
	public String getJulEstmIncntAmt() {
		return this.julEstmIncntAmt;
	}
	
	/**
	 * Column Info
	 * @return decEstmIncntAmt
	 */
	public String getDecEstmIncntAmt() {
		return this.decEstmIncntAmt;
	}
	
	/**
	 * Column Info
	 * @return atchFlg
	 */
	public String getAtchFlg() {
		return this.atchFlg;
	}
	
	/**
	 * Column Info
	 * @return febEstmIncntAmt
	 */
	public String getFebEstmIncntAmt() {
		return this.febEstmIncntAmt;
	}
	
	/**
	 * Column Info
	 * @return atchN2ndFileLnkId
	 */
	public String getAtchN2ndFileLnkId() {
		return this.atchN2ndFileLnkId;
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
	 * @return yearUsdEstmIncntAmt
	 */
	public String getYearUsdEstmIncntAmt() {
		return this.yearUsdEstmIncntAmt;
	}
	
	/**
	 * Column Info
	 * @return sepRcvIncntAmt
	 */
	public String getSepRcvIncntAmt() {
		return this.sepRcvIncntAmt;
	}
	
	/**
	 * Column Info
	 * @return ttlRmnAmt
	 */
	public String getTtlRmnAmt() {
		return this.ttlRmnAmt;
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
	 * @return julRcvIncntAmt
	 */
	public String getJulRcvIncntAmt() {
		return this.julRcvIncntAmt;
	}
	
	/**
	 * Column Info
	 * @return aprEstmIncntAmt
	 */
	public String getAprEstmIncntAmt() {
		return this.aprEstmIncntAmt;
	}
	
	/**
	 * Column Info
	 * @return junEstmIncntAmt
	 */
	public String getJunEstmIncntAmt() {
		return this.junEstmIncntAmt;
	}
	
	/**
	 * Column Info
	 * @return octEstmIncntAmt
	 */
	public String getOctEstmIncntAmt() {
		return this.octEstmIncntAmt;
	}
	
	/**
	 * Column Info
	 * @return marRcvIncntAmt
	 */
	public String getMarRcvIncntAmt() {
		return this.marRcvIncntAmt;
	}
	
	/**
	 * Column Info
	 * @return ttlIncntAmt
	 */
	public String getTtlIncntAmt() {
		return this.ttlIncntAmt;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
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
	 * @return incntNo
	 */
	public String getIncntNo() {
		return this.incntNo;
	}
	
	/**
	 * Column Info
	 * @return aprRcvIncntAmt
	 */
	public String getAprRcvIncntAmt() {
		return this.aprRcvIncntAmt;
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
	 * @return itmCd
	 */
	public String getItmCd() {
		return this.itmCd;
	}
	
	/**
	 * Column Info
	 * @return junRcvIncntAmt
	 */
	public String getJunRcvIncntAmt() {
		return this.junRcvIncntAmt;
	}
	
	/**
	 * Column Info
	 * @return febRcvIncntAmt
	 */
	public String getFebRcvIncntAmt() {
		return this.febRcvIncntAmt;
	}
	
	/**
	 * Column Info
	 * @return augEstmIncntAmt
	 */
	public String getAugEstmIncntAmt() {
		return this.augEstmIncntAmt;
	}
	
	/**
	 * Column Info
	 * @return novRcvIncntAmt
	 */
	public String getNovRcvIncntAmt() {
		return this.novRcvIncntAmt;
	}
	
	/**
	 * Column Info
	 * @return marEstmIncntAmt
	 */
	public String getMarEstmIncntAmt() {
		return this.marEstmIncntAmt;
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
	 * @return novEstmIncntAmt
	 */
	public String getNovEstmIncntAmt() {
		return this.novEstmIncntAmt;
	}
	
	/**
	 * Column Info
	 * @return stlRmk
	 */
	public String getStlRmk() {
		return this.stlRmk;
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
	 * @return yearUsdBalIncntAmt
	 */
	public String getYearUsdBalIncntAmt() {
		return this.yearUsdBalIncntAmt;
	}
	
	/**
	 * Column Info
	 * @return yearUsdRcvIncntAmt
	 */
	public String getYearUsdRcvIncntAmt() {
		return this.yearUsdRcvIncntAmt;
	}
	
	/**
	 * Column Info
	 * @return augRcvIncntAmt
	 */
	public String getAugRcvIncntAmt() {
		return this.augRcvIncntAmt;
	}
	
	/**
	 * Column Info
	 * @return bseYr
	 */
	public String getBseYr() {
		return this.bseYr;
	}
	
	/**
	 * Column Info
	 * @return instrRmk
	 */
	public String getInstrRmk() {
		return this.instrRmk;
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
	 * @return usdRt
	 */
	public String getUsdRt() {
		return this.usdRt;
	}
	
	/**
	 * Column Info
	 * @return incntRmk
	 */
	public String getIncntRmk() {
		return this.incntRmk;
	}
	

	/**
	 * Column Info
	 * @param mayRcvIncntAmt
	 */
	public void setMayRcvIncntAmt(String mayRcvIncntAmt) {
		this.mayRcvIncntAmt = mayRcvIncntAmt;
	}
	
	/**
	 * Column Info
	 * @param octRcvIncntAmt
	 */
	public void setOctRcvIncntAmt(String octRcvIncntAmt) {
		this.octRcvIncntAmt = octRcvIncntAmt;
	}
	
	/**
	 * Column Info
	 * @param janRcvIncntAmt
	 */
	public void setJanRcvIncntAmt(String janRcvIncntAmt) {
		this.janRcvIncntAmt = janRcvIncntAmt;
	}
	
	/**
	 * Column Info
	 * @param sepEstmIncntAmt
	 */
	public void setSepEstmIncntAmt(String sepEstmIncntAmt) {
		this.sepEstmIncntAmt = sepEstmIncntAmt;
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
	 * @param atchFileLnkId
	 */
	public void setAtchFileLnkId(String atchFileLnkId) {
		this.atchFileLnkId = atchFileLnkId;
	}
	
	/**
	 * Column Info
	 * @param vndrNm
	 */
	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
	}
	
	/**
	 * Column Info
	 * @param mayEstmIncntAmt
	 */
	public void setMayEstmIncntAmt(String mayEstmIncntAmt) {
		this.mayEstmIncntAmt = mayEstmIncntAmt;
	}
	
	/**
	 * Column Info
	 * @param decRcvIncntAmt
	 */
	public void setDecRcvIncntAmt(String decRcvIncntAmt) {
		this.decRcvIncntAmt = decRcvIncntAmt;
	}
	
	/**
	 * Column Info
	 * @param atch2Flg
	 */
	public void setAtch2Flg(String atch2Flg) {
		this.atch2Flg = atch2Flg;
	}
	
	/**
	 * Column Info
	 * @param janEstmIncntAmt
	 */
	public void setJanEstmIncntAmt(String janEstmIncntAmt) {
		this.janEstmIncntAmt = janEstmIncntAmt;
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
	 * @param ttlRcvAmt
	 */
	public void setTtlRcvAmt(String ttlRcvAmt) {
		this.ttlRcvAmt = ttlRcvAmt;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param julEstmIncntAmt
	 */
	public void setJulEstmIncntAmt(String julEstmIncntAmt) {
		this.julEstmIncntAmt = julEstmIncntAmt;
	}
	
	/**
	 * Column Info
	 * @param decEstmIncntAmt
	 */
	public void setDecEstmIncntAmt(String decEstmIncntAmt) {
		this.decEstmIncntAmt = decEstmIncntAmt;
	}
	
	/**
	 * Column Info
	 * @param atchFlg
	 */
	public void setAtchFlg(String atchFlg) {
		this.atchFlg = atchFlg;
	}
	
	/**
	 * Column Info
	 * @param febEstmIncntAmt
	 */
	public void setFebEstmIncntAmt(String febEstmIncntAmt) {
		this.febEstmIncntAmt = febEstmIncntAmt;
	}
	
	/**
	 * Column Info
	 * @param atchN2ndFileLnkId
	 */
	public void setAtchN2ndFileLnkId(String atchN2ndFileLnkId) {
		this.atchN2ndFileLnkId = atchN2ndFileLnkId;
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
	 * @param yearUsdEstmIncntAmt
	 */
	public void setYearUsdEstmIncntAmt(String yearUsdEstmIncntAmt) {
		this.yearUsdEstmIncntAmt = yearUsdEstmIncntAmt;
	}
	
	/**
	 * Column Info
	 * @param sepRcvIncntAmt
	 */
	public void setSepRcvIncntAmt(String sepRcvIncntAmt) {
		this.sepRcvIncntAmt = sepRcvIncntAmt;
	}
	
	/**
	 * Column Info
	 * @param ttlRmnAmt
	 */
	public void setTtlRmnAmt(String ttlRmnAmt) {
		this.ttlRmnAmt = ttlRmnAmt;
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
	 * @param julRcvIncntAmt
	 */
	public void setJulRcvIncntAmt(String julRcvIncntAmt) {
		this.julRcvIncntAmt = julRcvIncntAmt;
	}
	
	/**
	 * Column Info
	 * @param aprEstmIncntAmt
	 */
	public void setAprEstmIncntAmt(String aprEstmIncntAmt) {
		this.aprEstmIncntAmt = aprEstmIncntAmt;
	}
	
	/**
	 * Column Info
	 * @param junEstmIncntAmt
	 */
	public void setJunEstmIncntAmt(String junEstmIncntAmt) {
		this.junEstmIncntAmt = junEstmIncntAmt;
	}
	
	/**
	 * Column Info
	 * @param octEstmIncntAmt
	 */
	public void setOctEstmIncntAmt(String octEstmIncntAmt) {
		this.octEstmIncntAmt = octEstmIncntAmt;
	}
	
	/**
	 * Column Info
	 * @param marRcvIncntAmt
	 */
	public void setMarRcvIncntAmt(String marRcvIncntAmt) {
		this.marRcvIncntAmt = marRcvIncntAmt;
	}
	
	/**
	 * Column Info
	 * @param ttlIncntAmt
	 */
	public void setTtlIncntAmt(String ttlIncntAmt) {
		this.ttlIncntAmt = ttlIncntAmt;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
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
	 * @param incntNo
	 */
	public void setIncntNo(String incntNo) {
		this.incntNo = incntNo;
	}
	
	/**
	 * Column Info
	 * @param aprRcvIncntAmt
	 */
	public void setAprRcvIncntAmt(String aprRcvIncntAmt) {
		this.aprRcvIncntAmt = aprRcvIncntAmt;
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
	 * @param itmCd
	 */
	public void setItmCd(String itmCd) {
		this.itmCd = itmCd;
	}
	
	/**
	 * Column Info
	 * @param junRcvIncntAmt
	 */
	public void setJunRcvIncntAmt(String junRcvIncntAmt) {
		this.junRcvIncntAmt = junRcvIncntAmt;
	}
	
	/**
	 * Column Info
	 * @param febRcvIncntAmt
	 */
	public void setFebRcvIncntAmt(String febRcvIncntAmt) {
		this.febRcvIncntAmt = febRcvIncntAmt;
	}
	
	/**
	 * Column Info
	 * @param augEstmIncntAmt
	 */
	public void setAugEstmIncntAmt(String augEstmIncntAmt) {
		this.augEstmIncntAmt = augEstmIncntAmt;
	}
	
	/**
	 * Column Info
	 * @param novRcvIncntAmt
	 */
	public void setNovRcvIncntAmt(String novRcvIncntAmt) {
		this.novRcvIncntAmt = novRcvIncntAmt;
	}
	
	/**
	 * Column Info
	 * @param marEstmIncntAmt
	 */
	public void setMarEstmIncntAmt(String marEstmIncntAmt) {
		this.marEstmIncntAmt = marEstmIncntAmt;
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
	 * @param novEstmIncntAmt
	 */
	public void setNovEstmIncntAmt(String novEstmIncntAmt) {
		this.novEstmIncntAmt = novEstmIncntAmt;
	}
	
	/**
	 * Column Info
	 * @param stlRmk
	 */
	public void setStlRmk(String stlRmk) {
		this.stlRmk = stlRmk;
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
	 * @param yearUsdBalIncntAmt
	 */
	public void setYearUsdBalIncntAmt(String yearUsdBalIncntAmt) {
		this.yearUsdBalIncntAmt = yearUsdBalIncntAmt;
	}
	
	/**
	 * Column Info
	 * @param yearUsdRcvIncntAmt
	 */
	public void setYearUsdRcvIncntAmt(String yearUsdRcvIncntAmt) {
		this.yearUsdRcvIncntAmt = yearUsdRcvIncntAmt;
	}
	
	/**
	 * Column Info
	 * @param augRcvIncntAmt
	 */
	public void setAugRcvIncntAmt(String augRcvIncntAmt) {
		this.augRcvIncntAmt = augRcvIncntAmt;
	}
	
	/**
	 * Column Info
	 * @param bseYr
	 */
	public void setBseYr(String bseYr) {
		this.bseYr = bseYr;
	}
	
	/**
	 * Column Info
	 * @param instrRmk
	 */
	public void setInstrRmk(String instrRmk) {
		this.instrRmk = instrRmk;
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
	 * @param usdRt
	 */
	public void setUsdRt(String usdRt) {
		this.usdRt = usdRt;
	}
	
	/**
	 * Column Info
	 * @param incntRmk
	 */
	public void setIncntRmk(String incntRmk) {
		this.incntRmk = incntRmk;
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
		setMayRcvIncntAmt(JSPUtil.getParameter(request, prefix + "may_rcv_incnt_amt", ""));
		setOctRcvIncntAmt(JSPUtil.getParameter(request, prefix + "oct_rcv_incnt_amt", ""));
		setJanRcvIncntAmt(JSPUtil.getParameter(request, prefix + "jan_rcv_incnt_amt", ""));
		setSepEstmIncntAmt(JSPUtil.getParameter(request, prefix + "sep_estm_incnt_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAtchFileLnkId(JSPUtil.getParameter(request, prefix + "atch_file_lnk_id", ""));
		setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
		setMayEstmIncntAmt(JSPUtil.getParameter(request, prefix + "may_estm_incnt_amt", ""));
		setDecRcvIncntAmt(JSPUtil.getParameter(request, prefix + "dec_rcv_incnt_amt", ""));
		setAtch2Flg(JSPUtil.getParameter(request, prefix + "atch2_flg", ""));
		setJanEstmIncntAmt(JSPUtil.getParameter(request, prefix + "jan_estm_incnt_amt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setTtlRcvAmt(JSPUtil.getParameter(request, prefix + "ttl_rcv_amt", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setJulEstmIncntAmt(JSPUtil.getParameter(request, prefix + "jul_estm_incnt_amt", ""));
		setDecEstmIncntAmt(JSPUtil.getParameter(request, prefix + "dec_estm_incnt_amt", ""));
		setAtchFlg(JSPUtil.getParameter(request, prefix + "atch_flg", ""));
		setFebEstmIncntAmt(JSPUtil.getParameter(request, prefix + "feb_estm_incnt_amt", ""));
		setAtchN2ndFileLnkId(JSPUtil.getParameter(request, prefix + "atch_n2nd_file_lnk_id", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setYearUsdEstmIncntAmt(JSPUtil.getParameter(request, prefix + "year_usd_estm_incnt_amt", ""));
		setSepRcvIncntAmt(JSPUtil.getParameter(request, prefix + "sep_rcv_incnt_amt", ""));
		setTtlRmnAmt(JSPUtil.getParameter(request, prefix + "ttl_rmn_amt", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setJulRcvIncntAmt(JSPUtil.getParameter(request, prefix + "jul_rcv_incnt_amt", ""));
		setAprEstmIncntAmt(JSPUtil.getParameter(request, prefix + "apr_estm_incnt_amt", ""));
		setJunEstmIncntAmt(JSPUtil.getParameter(request, prefix + "jun_estm_incnt_amt", ""));
		setOctEstmIncntAmt(JSPUtil.getParameter(request, prefix + "oct_estm_incnt_amt", ""));
		setMarRcvIncntAmt(JSPUtil.getParameter(request, prefix + "mar_rcv_incnt_amt", ""));
		setTtlIncntAmt(JSPUtil.getParameter(request, prefix + "ttl_incnt_amt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setIncntNo(JSPUtil.getParameter(request, prefix + "incnt_no", ""));
		setAprRcvIncntAmt(JSPUtil.getParameter(request, prefix + "apr_rcv_incnt_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setItmCd(JSPUtil.getParameter(request, prefix + "itm_cd", ""));
		setJunRcvIncntAmt(JSPUtil.getParameter(request, prefix + "jun_rcv_incnt_amt", ""));
		setFebRcvIncntAmt(JSPUtil.getParameter(request, prefix + "feb_rcv_incnt_amt", ""));
		setAugEstmIncntAmt(JSPUtil.getParameter(request, prefix + "aug_estm_incnt_amt", ""));
		setNovRcvIncntAmt(JSPUtil.getParameter(request, prefix + "nov_rcv_incnt_amt", ""));
		setMarEstmIncntAmt(JSPUtil.getParameter(request, prefix + "mar_estm_incnt_amt", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setNovEstmIncntAmt(JSPUtil.getParameter(request, prefix + "nov_estm_incnt_amt", ""));
		setStlRmk(JSPUtil.getParameter(request, prefix + "stl_rmk", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setYearUsdBalIncntAmt(JSPUtil.getParameter(request, prefix + "year_usd_bal_incnt_amt", ""));
		setYearUsdRcvIncntAmt(JSPUtil.getParameter(request, prefix + "year_usd_rcv_incnt_amt", ""));
		setAugRcvIncntAmt(JSPUtil.getParameter(request, prefix + "aug_rcv_incnt_amt", ""));
		setBseYr(JSPUtil.getParameter(request, prefix + "bse_yr", ""));
		setInstrRmk(JSPUtil.getParameter(request, prefix + "instr_rmk", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setUsdRt(JSPUtil.getParameter(request, prefix + "usd_rt", ""));
		setIncntRmk(JSPUtil.getParameter(request, prefix + "incnt_rmk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VslStatusIncntVO[]
	 */
	public VslStatusIncntVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VslStatusIncntVO[]
	 */
	public VslStatusIncntVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VslStatusIncntVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mayRcvIncntAmt = (JSPUtil.getParameter(request, prefix	+ "may_rcv_incnt_amt", length));
			String[] octRcvIncntAmt = (JSPUtil.getParameter(request, prefix	+ "oct_rcv_incnt_amt", length));
			String[] janRcvIncntAmt = (JSPUtil.getParameter(request, prefix	+ "jan_rcv_incnt_amt", length));
			String[] sepEstmIncntAmt = (JSPUtil.getParameter(request, prefix	+ "sep_estm_incnt_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] atchFileLnkId = (JSPUtil.getParameter(request, prefix	+ "atch_file_lnk_id", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] mayEstmIncntAmt = (JSPUtil.getParameter(request, prefix	+ "may_estm_incnt_amt", length));
			String[] decRcvIncntAmt = (JSPUtil.getParameter(request, prefix	+ "dec_rcv_incnt_amt", length));
			String[] atch2Flg = (JSPUtil.getParameter(request, prefix	+ "atch2_flg", length));
			String[] janEstmIncntAmt = (JSPUtil.getParameter(request, prefix	+ "jan_estm_incnt_amt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] ttlRcvAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_rcv_amt", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] julEstmIncntAmt = (JSPUtil.getParameter(request, prefix	+ "jul_estm_incnt_amt", length));
			String[] decEstmIncntAmt = (JSPUtil.getParameter(request, prefix	+ "dec_estm_incnt_amt", length));
			String[] atchFlg = (JSPUtil.getParameter(request, prefix	+ "atch_flg", length));
			String[] febEstmIncntAmt = (JSPUtil.getParameter(request, prefix	+ "feb_estm_incnt_amt", length));
			String[] atchN2ndFileLnkId = (JSPUtil.getParameter(request, prefix	+ "atch_n2nd_file_lnk_id", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] yearUsdEstmIncntAmt = (JSPUtil.getParameter(request, prefix	+ "year_usd_estm_incnt_amt", length));
			String[] sepRcvIncntAmt = (JSPUtil.getParameter(request, prefix	+ "sep_rcv_incnt_amt", length));
			String[] ttlRmnAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_rmn_amt", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] julRcvIncntAmt = (JSPUtil.getParameter(request, prefix	+ "jul_rcv_incnt_amt", length));
			String[] aprEstmIncntAmt = (JSPUtil.getParameter(request, prefix	+ "apr_estm_incnt_amt", length));
			String[] junEstmIncntAmt = (JSPUtil.getParameter(request, prefix	+ "jun_estm_incnt_amt", length));
			String[] octEstmIncntAmt = (JSPUtil.getParameter(request, prefix	+ "oct_estm_incnt_amt", length));
			String[] marRcvIncntAmt = (JSPUtil.getParameter(request, prefix	+ "mar_rcv_incnt_amt", length));
			String[] ttlIncntAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_incnt_amt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] incntNo = (JSPUtil.getParameter(request, prefix	+ "incnt_no", length));
			String[] aprRcvIncntAmt = (JSPUtil.getParameter(request, prefix	+ "apr_rcv_incnt_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] itmCd = (JSPUtil.getParameter(request, prefix	+ "itm_cd", length));
			String[] junRcvIncntAmt = (JSPUtil.getParameter(request, prefix	+ "jun_rcv_incnt_amt", length));
			String[] febRcvIncntAmt = (JSPUtil.getParameter(request, prefix	+ "feb_rcv_incnt_amt", length));
			String[] augEstmIncntAmt = (JSPUtil.getParameter(request, prefix	+ "aug_estm_incnt_amt", length));
			String[] novRcvIncntAmt = (JSPUtil.getParameter(request, prefix	+ "nov_rcv_incnt_amt", length));
			String[] marEstmIncntAmt = (JSPUtil.getParameter(request, prefix	+ "mar_estm_incnt_amt", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] novEstmIncntAmt = (JSPUtil.getParameter(request, prefix	+ "nov_estm_incnt_amt", length));
			String[] stlRmk = (JSPUtil.getParameter(request, prefix	+ "stl_rmk", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] yearUsdBalIncntAmt = (JSPUtil.getParameter(request, prefix	+ "year_usd_bal_incnt_amt", length));
			String[] yearUsdRcvIncntAmt = (JSPUtil.getParameter(request, prefix	+ "year_usd_rcv_incnt_amt", length));
			String[] augRcvIncntAmt = (JSPUtil.getParameter(request, prefix	+ "aug_rcv_incnt_amt", length));
			String[] bseYr = (JSPUtil.getParameter(request, prefix	+ "bse_yr", length));
			String[] instrRmk = (JSPUtil.getParameter(request, prefix	+ "instr_rmk", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] usdRt = (JSPUtil.getParameter(request, prefix	+ "usd_rt", length));
			String[] incntRmk = (JSPUtil.getParameter(request, prefix	+ "incnt_rmk", length));
			
			for (int i = 0; i < length; i++) {
				model = new VslStatusIncntVO();
				if (mayRcvIncntAmt[i] != null)
					model.setMayRcvIncntAmt(mayRcvIncntAmt[i]);
				if (octRcvIncntAmt[i] != null)
					model.setOctRcvIncntAmt(octRcvIncntAmt[i]);
				if (janRcvIncntAmt[i] != null)
					model.setJanRcvIncntAmt(janRcvIncntAmt[i]);
				if (sepEstmIncntAmt[i] != null)
					model.setSepEstmIncntAmt(sepEstmIncntAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (atchFileLnkId[i] != null)
					model.setAtchFileLnkId(atchFileLnkId[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (mayEstmIncntAmt[i] != null)
					model.setMayEstmIncntAmt(mayEstmIncntAmt[i]);
				if (decRcvIncntAmt[i] != null)
					model.setDecRcvIncntAmt(decRcvIncntAmt[i]);
				if (atch2Flg[i] != null)
					model.setAtch2Flg(atch2Flg[i]);
				if (janEstmIncntAmt[i] != null)
					model.setJanEstmIncntAmt(janEstmIncntAmt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (ttlRcvAmt[i] != null)
					model.setTtlRcvAmt(ttlRcvAmt[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (julEstmIncntAmt[i] != null)
					model.setJulEstmIncntAmt(julEstmIncntAmt[i]);
				if (decEstmIncntAmt[i] != null)
					model.setDecEstmIncntAmt(decEstmIncntAmt[i]);
				if (atchFlg[i] != null)
					model.setAtchFlg(atchFlg[i]);
				if (febEstmIncntAmt[i] != null)
					model.setFebEstmIncntAmt(febEstmIncntAmt[i]);
				if (atchN2ndFileLnkId[i] != null)
					model.setAtchN2ndFileLnkId(atchN2ndFileLnkId[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (yearUsdEstmIncntAmt[i] != null)
					model.setYearUsdEstmIncntAmt(yearUsdEstmIncntAmt[i]);
				if (sepRcvIncntAmt[i] != null)
					model.setSepRcvIncntAmt(sepRcvIncntAmt[i]);
				if (ttlRmnAmt[i] != null)
					model.setTtlRmnAmt(ttlRmnAmt[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (julRcvIncntAmt[i] != null)
					model.setJulRcvIncntAmt(julRcvIncntAmt[i]);
				if (aprEstmIncntAmt[i] != null)
					model.setAprEstmIncntAmt(aprEstmIncntAmt[i]);
				if (junEstmIncntAmt[i] != null)
					model.setJunEstmIncntAmt(junEstmIncntAmt[i]);
				if (octEstmIncntAmt[i] != null)
					model.setOctEstmIncntAmt(octEstmIncntAmt[i]);
				if (marRcvIncntAmt[i] != null)
					model.setMarRcvIncntAmt(marRcvIncntAmt[i]);
				if (ttlIncntAmt[i] != null)
					model.setTtlIncntAmt(ttlIncntAmt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (incntNo[i] != null)
					model.setIncntNo(incntNo[i]);
				if (aprRcvIncntAmt[i] != null)
					model.setAprRcvIncntAmt(aprRcvIncntAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (itmCd[i] != null)
					model.setItmCd(itmCd[i]);
				if (junRcvIncntAmt[i] != null)
					model.setJunRcvIncntAmt(junRcvIncntAmt[i]);
				if (febRcvIncntAmt[i] != null)
					model.setFebRcvIncntAmt(febRcvIncntAmt[i]);
				if (augEstmIncntAmt[i] != null)
					model.setAugEstmIncntAmt(augEstmIncntAmt[i]);
				if (novRcvIncntAmt[i] != null)
					model.setNovRcvIncntAmt(novRcvIncntAmt[i]);
				if (marEstmIncntAmt[i] != null)
					model.setMarEstmIncntAmt(marEstmIncntAmt[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (novEstmIncntAmt[i] != null)
					model.setNovEstmIncntAmt(novEstmIncntAmt[i]);
				if (stlRmk[i] != null)
					model.setStlRmk(stlRmk[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (yearUsdBalIncntAmt[i] != null)
					model.setYearUsdBalIncntAmt(yearUsdBalIncntAmt[i]);
				if (yearUsdRcvIncntAmt[i] != null)
					model.setYearUsdRcvIncntAmt(yearUsdRcvIncntAmt[i]);
				if (augRcvIncntAmt[i] != null)
					model.setAugRcvIncntAmt(augRcvIncntAmt[i]);
				if (bseYr[i] != null)
					model.setBseYr(bseYr[i]);
				if (instrRmk[i] != null)
					model.setInstrRmk(instrRmk[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (usdRt[i] != null)
					model.setUsdRt(usdRt[i]);
				if (incntRmk[i] != null)
					model.setIncntRmk(incntRmk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVslStatusIncntVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VslStatusIncntVO[]
	 */
	public VslStatusIncntVO[] getVslStatusIncntVOs(){
		VslStatusIncntVO[] vos = (VslStatusIncntVO[])models.toArray(new VslStatusIncntVO[models.size()]);
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
		this.mayRcvIncntAmt = this.mayRcvIncntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.octRcvIncntAmt = this.octRcvIncntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.janRcvIncntAmt = this.janRcvIncntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sepEstmIncntAmt = this.sepEstmIncntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFileLnkId = this.atchFileLnkId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mayEstmIncntAmt = this.mayEstmIncntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.decRcvIncntAmt = this.decRcvIncntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atch2Flg = this.atch2Flg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.janEstmIncntAmt = this.janEstmIncntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlRcvAmt = this.ttlRcvAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.julEstmIncntAmt = this.julEstmIncntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.decEstmIncntAmt = this.decEstmIncntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFlg = this.atchFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.febEstmIncntAmt = this.febEstmIncntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchN2ndFileLnkId = this.atchN2ndFileLnkId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yearUsdEstmIncntAmt = this.yearUsdEstmIncntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sepRcvIncntAmt = this.sepRcvIncntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlRmnAmt = this.ttlRmnAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.julRcvIncntAmt = this.julRcvIncntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aprEstmIncntAmt = this.aprEstmIncntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.junEstmIncntAmt = this.junEstmIncntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.octEstmIncntAmt = this.octEstmIncntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.marRcvIncntAmt = this.marRcvIncntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlIncntAmt = this.ttlIncntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.incntNo = this.incntNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aprRcvIncntAmt = this.aprRcvIncntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itmCd = this.itmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.junRcvIncntAmt = this.junRcvIncntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.febRcvIncntAmt = this.febRcvIncntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.augEstmIncntAmt = this.augEstmIncntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.novRcvIncntAmt = this.novRcvIncntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.marEstmIncntAmt = this.marEstmIncntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.novEstmIncntAmt = this.novEstmIncntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlRmk = this.stlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yearUsdBalIncntAmt = this.yearUsdBalIncntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yearUsdRcvIncntAmt = this.yearUsdRcvIncntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.augRcvIncntAmt = this.augRcvIncntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYr = this.bseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.instrRmk = this.instrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdRt = this.usdRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.incntRmk = this.incntRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
