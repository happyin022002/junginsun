/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CHSInventoryByStaydaysMGTVO.java
*@FileTitle : CHSInventoryByStaydaysMGTVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.23
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.11.23 조재성 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo;

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
 * @author 조재성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CHSInventoryByStaydaysMGTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CHSInventoryByStaydaysMGTVO> models = new ArrayList<CHSInventoryByStaydaysMGTVO>();
	
	/* Column Info */
	private String n5thInqToDys = null;
	/* Column Info */
	private String n2ndInqFmDys = null;
	/* Column Info */
	private String chssMvmtDt0OrOver = null;
	/* Column Info */
	private String includeOutGated = null;
	/* Column Info */
	private String chssMvmtDt101180Rate = null;
	/* Column Info */
	private String includeStatusLst = null;
	/* Column Info */
	private String chssPoolCd = null;
	/* Column Info */
	private String location = null;
	/* Column Info */
	private String includeNp = null;
	/* Column Info */
	private String chssMvmtDt51100Rate = null;
	/* Column Info */
	private String n3rdInqFmDys = null;
	/* Column Info */
	private String crntYdCd = null;
	/* Column Info */
	private String chssMvmtDt181Over = null;
	/* Column Info */
	private String n1stInqFmDys = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String n2ndInqToDys = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String chssMvmtDtTot = null;
	/* Column Info */
	private String n1stInqToDys = null;
	/* Column Info */
	private String chssMvmtDt3150 = null;
	/* Column Info */
	private String group1 = null;
	/* Column Info */
	private String chssMvmtDt1630Rate = null;
	/* Column Info */
	private String chssMvmtDt1630 = null;
	/* Column Info */
	private String atchBare = null;
	/* Column Info */
	private String n4thInqFmDys = null;
	/* Column Info */
	private String chssMvmtDt101180 = null;
	/* Column Info */
	private String chssMvmtDt3150Rate = null;
	/* Column Info */
	private String n4thInqToDys = null;
	/* Column Info */
	private String n3rdInqToDys = null;
	/* Column Info */
	private String agmtLstmCd = null;
	/* Column Info */
	private String aciacDivCd = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String chssMvmtDt51100 = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String dmgSnd = null;
	/* Column Info */
	private String chssMvmtDt181OverRate = null;
	/* Column Info */
	private String chssMvmtDtToday15 = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String stayingDays = null;
	/* Column Info */
	private String chssMvmtDtToday15Rate = null;
	/* Column Info */
	private String chssMvmtStsCd = null;
	/* Column Info */
	private String chssMvmtDt0OrOverRate = null;
	/* Column Info */
	private String crntLocCd = null;
	/* Column Info */
	private String n5thInqFmDys = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CHSInventoryByStaydaysMGTVO() {}

	public CHSInventoryByStaydaysMGTVO(String ibflag, String pagerows, String eqKndCd, String location, String crntLocCd, String crntYdCd, String aciacDivCd, String chssPoolCd, String stayingDays, String includeStatusLst, String includeOutGated, String includeNp, String group1, String agmtLstmCd, String eqTpszCd, String vndrSeq, String chssMvmtStsCd, String chssMvmtDtTot, String chssMvmtDt0OrOver, String chssMvmtDt0OrOverRate, String chssMvmtDtToday15, String chssMvmtDtToday15Rate, String chssMvmtDt1630, String chssMvmtDt1630Rate, String chssMvmtDt3150, String chssMvmtDt3150Rate, String chssMvmtDt51100, String chssMvmtDt51100Rate, String chssMvmtDt101180, String chssMvmtDt101180Rate, String chssMvmtDt181Over, String chssMvmtDt181OverRate, String n1stInqFmDys, String n1stInqToDys, String n2ndInqFmDys, String n2ndInqToDys, String n3rdInqFmDys, String n3rdInqToDys, String n4thInqFmDys, String n4thInqToDys, String n5thInqFmDys, String n5thInqToDys, String atchBare, String dmgSnd) {
		this.n5thInqToDys = n5thInqToDys;
		this.n2ndInqFmDys = n2ndInqFmDys;
		this.chssMvmtDt0OrOver = chssMvmtDt0OrOver;
		this.includeOutGated = includeOutGated;
		this.chssMvmtDt101180Rate = chssMvmtDt101180Rate;
		this.includeStatusLst = includeStatusLst;
		this.chssPoolCd = chssPoolCd;
		this.location = location;
		this.includeNp = includeNp;
		this.chssMvmtDt51100Rate = chssMvmtDt51100Rate;
		this.n3rdInqFmDys = n3rdInqFmDys;
		this.crntYdCd = crntYdCd;
		this.chssMvmtDt181Over = chssMvmtDt181Over;
		this.n1stInqFmDys = n1stInqFmDys;
		this.pagerows = pagerows;
		this.n2ndInqToDys = n2ndInqToDys;
		this.ibflag = ibflag;
		this.chssMvmtDtTot = chssMvmtDtTot;
		this.n1stInqToDys = n1stInqToDys;
		this.chssMvmtDt3150 = chssMvmtDt3150;
		this.group1 = group1;
		this.chssMvmtDt1630Rate = chssMvmtDt1630Rate;
		this.chssMvmtDt1630 = chssMvmtDt1630;
		this.atchBare = atchBare;
		this.n4thInqFmDys = n4thInqFmDys;
		this.chssMvmtDt101180 = chssMvmtDt101180;
		this.chssMvmtDt3150Rate = chssMvmtDt3150Rate;
		this.n4thInqToDys = n4thInqToDys;
		this.n3rdInqToDys = n3rdInqToDys;
		this.agmtLstmCd = agmtLstmCd;
		this.aciacDivCd = aciacDivCd;
		this.eqKndCd = eqKndCd;
		this.chssMvmtDt51100 = chssMvmtDt51100;
		this.eqTpszCd = eqTpszCd;
		this.dmgSnd = dmgSnd;
		this.chssMvmtDt181OverRate = chssMvmtDt181OverRate;
		this.chssMvmtDtToday15 = chssMvmtDtToday15;
		this.vndrSeq = vndrSeq;
		this.stayingDays = stayingDays;
		this.chssMvmtDtToday15Rate = chssMvmtDtToday15Rate;
		this.chssMvmtStsCd = chssMvmtStsCd;
		this.chssMvmtDt0OrOverRate = chssMvmtDt0OrOverRate;
		this.crntLocCd = crntLocCd;
		this.n5thInqFmDys = n5thInqFmDys;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("n5th_inq_to_dys", getN5thInqToDys());
		this.hashColumns.put("n2nd_inq_fm_dys", getN2ndInqFmDys());
		this.hashColumns.put("chss_mvmt_dt_0_or_over", getChssMvmtDt0OrOver());
		this.hashColumns.put("include_out_gated", getIncludeOutGated());
		this.hashColumns.put("chss_mvmt_dt_101_180_rate", getChssMvmtDt101180Rate());
		this.hashColumns.put("include_status_lst", getIncludeStatusLst());
		this.hashColumns.put("chss_pool_cd", getChssPoolCd());
		this.hashColumns.put("location", getLocation());
		this.hashColumns.put("include_np", getIncludeNp());
		this.hashColumns.put("chss_mvmt_dt_51_100_rate", getChssMvmtDt51100Rate());
		this.hashColumns.put("n3rd_inq_fm_dys", getN3rdInqFmDys());
		this.hashColumns.put("crnt_yd_cd", getCrntYdCd());
		this.hashColumns.put("chss_mvmt_dt_181_over", getChssMvmtDt181Over());
		this.hashColumns.put("n1st_inq_fm_dys", getN1stInqFmDys());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("n2nd_inq_to_dys", getN2ndInqToDys());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("chss_mvmt_dt_tot", getChssMvmtDtTot());
		this.hashColumns.put("n1st_inq_to_dys", getN1stInqToDys());
		this.hashColumns.put("chss_mvmt_dt_31_50", getChssMvmtDt3150());
		this.hashColumns.put("group1", getGroup1());
		this.hashColumns.put("chss_mvmt_dt_16_30_rate", getChssMvmtDt1630Rate());
		this.hashColumns.put("chss_mvmt_dt_16_30", getChssMvmtDt1630());
		this.hashColumns.put("atch_bare", getAtchBare());
		this.hashColumns.put("n4th_inq_fm_dys", getN4thInqFmDys());
		this.hashColumns.put("chss_mvmt_dt_101_180", getChssMvmtDt101180());
		this.hashColumns.put("chss_mvmt_dt_31_50_rate", getChssMvmtDt3150Rate());
		this.hashColumns.put("n4th_inq_to_dys", getN4thInqToDys());
		this.hashColumns.put("n3rd_inq_to_dys", getN3rdInqToDys());
		this.hashColumns.put("agmt_lstm_cd", getAgmtLstmCd());
		this.hashColumns.put("aciac_div_cd", getAciacDivCd());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("chss_mvmt_dt_51_100", getChssMvmtDt51100());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("dmg_snd", getDmgSnd());
		this.hashColumns.put("chss_mvmt_dt_181_over_rate", getChssMvmtDt181OverRate());
		this.hashColumns.put("chss_mvmt_dt_today_15", getChssMvmtDtToday15());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("staying_days", getStayingDays());
		this.hashColumns.put("chss_mvmt_dt_today_15_rate", getChssMvmtDtToday15Rate());
		this.hashColumns.put("chss_mvmt_sts_cd", getChssMvmtStsCd());
		this.hashColumns.put("chss_mvmt_dt_0_or_over_rate", getChssMvmtDt0OrOverRate());
		this.hashColumns.put("crnt_loc_cd", getCrntLocCd());
		this.hashColumns.put("n5th_inq_fm_dys", getN5thInqFmDys());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("n5th_inq_to_dys", "n5thInqToDys");
		this.hashFields.put("n2nd_inq_fm_dys", "n2ndInqFmDys");
		this.hashFields.put("chss_mvmt_dt_0_or_over", "chssMvmtDt0OrOver");
		this.hashFields.put("include_out_gated", "includeOutGated");
		this.hashFields.put("chss_mvmt_dt_101_180_rate", "chssMvmtDt101180Rate");
		this.hashFields.put("include_status_lst", "includeStatusLst");
		this.hashFields.put("chss_pool_cd", "chssPoolCd");
		this.hashFields.put("location", "location");
		this.hashFields.put("include_np", "includeNp");
		this.hashFields.put("chss_mvmt_dt_51_100_rate", "chssMvmtDt51100Rate");
		this.hashFields.put("n3rd_inq_fm_dys", "n3rdInqFmDys");
		this.hashFields.put("crnt_yd_cd", "crntYdCd");
		this.hashFields.put("chss_mvmt_dt_181_over", "chssMvmtDt181Over");
		this.hashFields.put("n1st_inq_fm_dys", "n1stInqFmDys");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("n2nd_inq_to_dys", "n2ndInqToDys");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("chss_mvmt_dt_tot", "chssMvmtDtTot");
		this.hashFields.put("n1st_inq_to_dys", "n1stInqToDys");
		this.hashFields.put("chss_mvmt_dt_31_50", "chssMvmtDt3150");
		this.hashFields.put("group1", "group1");
		this.hashFields.put("chss_mvmt_dt_16_30_rate", "chssMvmtDt1630Rate");
		this.hashFields.put("chss_mvmt_dt_16_30", "chssMvmtDt1630");
		this.hashFields.put("atch_bare", "atchBare");
		this.hashFields.put("n4th_inq_fm_dys", "n4thInqFmDys");
		this.hashFields.put("chss_mvmt_dt_101_180", "chssMvmtDt101180");
		this.hashFields.put("chss_mvmt_dt_31_50_rate", "chssMvmtDt3150Rate");
		this.hashFields.put("n4th_inq_to_dys", "n4thInqToDys");
		this.hashFields.put("n3rd_inq_to_dys", "n3rdInqToDys");
		this.hashFields.put("agmt_lstm_cd", "agmtLstmCd");
		this.hashFields.put("aciac_div_cd", "aciacDivCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("chss_mvmt_dt_51_100", "chssMvmtDt51100");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("dmg_snd", "dmgSnd");
		this.hashFields.put("chss_mvmt_dt_181_over_rate", "chssMvmtDt181OverRate");
		this.hashFields.put("chss_mvmt_dt_today_15", "chssMvmtDtToday15");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("staying_days", "stayingDays");
		this.hashFields.put("chss_mvmt_dt_today_15_rate", "chssMvmtDtToday15Rate");
		this.hashFields.put("chss_mvmt_sts_cd", "chssMvmtStsCd");
		this.hashFields.put("chss_mvmt_dt_0_or_over_rate", "chssMvmtDt0OrOverRate");
		this.hashFields.put("crnt_loc_cd", "crntLocCd");
		this.hashFields.put("n5th_inq_fm_dys", "n5thInqFmDys");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return n5thInqToDys
	 */
	public String getN5thInqToDys() {
		return this.n5thInqToDys;
	}
	
	/**
	 * Column Info
	 * @return n2ndInqFmDys
	 */
	public String getN2ndInqFmDys() {
		return this.n2ndInqFmDys;
	}
	
	/**
	 * Column Info
	 * @return chssMvmtDt0OrOver
	 */
	public String getChssMvmtDt0OrOver() {
		return this.chssMvmtDt0OrOver;
	}
	
	/**
	 * Column Info
	 * @return includeOutGated
	 */
	public String getIncludeOutGated() {
		return this.includeOutGated;
	}
	
	/**
	 * Column Info
	 * @return chssMvmtDt101180Rate
	 */
	public String getChssMvmtDt101180Rate() {
		return this.chssMvmtDt101180Rate;
	}
	
	/**
	 * Column Info
	 * @return includeStatusLst
	 */
	public String getIncludeStatusLst() {
		return this.includeStatusLst;
	}
	
	/**
	 * Column Info
	 * @return chssPoolCd
	 */
	public String getChssPoolCd() {
		return this.chssPoolCd;
	}
	
	/**
	 * Column Info
	 * @return location
	 */
	public String getLocation() {
		return this.location;
	}
	
	/**
	 * Column Info
	 * @return includeNp
	 */
	public String getIncludeNp() {
		return this.includeNp;
	}
	
	/**
	 * Column Info
	 * @return chssMvmtDt51100Rate
	 */
	public String getChssMvmtDt51100Rate() {
		return this.chssMvmtDt51100Rate;
	}
	
	/**
	 * Column Info
	 * @return n3rdInqFmDys
	 */
	public String getN3rdInqFmDys() {
		return this.n3rdInqFmDys;
	}
	
	/**
	 * Column Info
	 * @return crntYdCd
	 */
	public String getCrntYdCd() {
		return this.crntYdCd;
	}
	
	/**
	 * Column Info
	 * @return chssMvmtDt181Over
	 */
	public String getChssMvmtDt181Over() {
		return this.chssMvmtDt181Over;
	}
	
	/**
	 * Column Info
	 * @return n1stInqFmDys
	 */
	public String getN1stInqFmDys() {
		return this.n1stInqFmDys;
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
	 * @return n2ndInqToDys
	 */
	public String getN2ndInqToDys() {
		return this.n2ndInqToDys;
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
	 * @return chssMvmtDtTot
	 */
	public String getChssMvmtDtTot() {
		return this.chssMvmtDtTot;
	}
	
	/**
	 * Column Info
	 * @return n1stInqToDys
	 */
	public String getN1stInqToDys() {
		return this.n1stInqToDys;
	}
	
	/**
	 * Column Info
	 * @return chssMvmtDt3150
	 */
	public String getChssMvmtDt3150() {
		return this.chssMvmtDt3150;
	}
	
	/**
	 * Column Info
	 * @return group1
	 */
	public String getGroup1() {
		return this.group1;
	}
	
	/**
	 * Column Info
	 * @return chssMvmtDt1630Rate
	 */
	public String getChssMvmtDt1630Rate() {
		return this.chssMvmtDt1630Rate;
	}
	
	/**
	 * Column Info
	 * @return chssMvmtDt1630
	 */
	public String getChssMvmtDt1630() {
		return this.chssMvmtDt1630;
	}
	
	/**
	 * Column Info
	 * @return atchBare
	 */
	public String getAtchBare() {
		return this.atchBare;
	}
	
	/**
	 * Column Info
	 * @return n4thInqFmDys
	 */
	public String getN4thInqFmDys() {
		return this.n4thInqFmDys;
	}
	
	/**
	 * Column Info
	 * @return chssMvmtDt101180
	 */
	public String getChssMvmtDt101180() {
		return this.chssMvmtDt101180;
	}
	
	/**
	 * Column Info
	 * @return chssMvmtDt3150Rate
	 */
	public String getChssMvmtDt3150Rate() {
		return this.chssMvmtDt3150Rate;
	}
	
	/**
	 * Column Info
	 * @return n4thInqToDys
	 */
	public String getN4thInqToDys() {
		return this.n4thInqToDys;
	}
	
	/**
	 * Column Info
	 * @return n3rdInqToDys
	 */
	public String getN3rdInqToDys() {
		return this.n3rdInqToDys;
	}
	
	/**
	 * Column Info
	 * @return agmtLstmCd
	 */
	public String getAgmtLstmCd() {
		return this.agmtLstmCd;
	}
	
	/**
	 * Column Info
	 * @return aciacDivCd
	 */
	public String getAciacDivCd() {
		return this.aciacDivCd;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	
	/**
	 * Column Info
	 * @return chssMvmtDt51100
	 */
	public String getChssMvmtDt51100() {
		return this.chssMvmtDt51100;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @return dmgSnd
	 */
	public String getDmgSnd() {
		return this.dmgSnd;
	}
	
	/**
	 * Column Info
	 * @return chssMvmtDt181OverRate
	 */
	public String getChssMvmtDt181OverRate() {
		return this.chssMvmtDt181OverRate;
	}
	
	/**
	 * Column Info
	 * @return chssMvmtDtToday15
	 */
	public String getChssMvmtDtToday15() {
		return this.chssMvmtDtToday15;
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
	 * @return stayingDays
	 */
	public String getStayingDays() {
		return this.stayingDays;
	}
	
	/**
	 * Column Info
	 * @return chssMvmtDtToday15Rate
	 */
	public String getChssMvmtDtToday15Rate() {
		return this.chssMvmtDtToday15Rate;
	}
	
	/**
	 * Column Info
	 * @return chssMvmtStsCd
	 */
	public String getChssMvmtStsCd() {
		return this.chssMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @return chssMvmtDt0OrOverRate
	 */
	public String getChssMvmtDt0OrOverRate() {
		return this.chssMvmtDt0OrOverRate;
	}
	
	/**
	 * Column Info
	 * @return crntLocCd
	 */
	public String getCrntLocCd() {
		return this.crntLocCd;
	}
	
	/**
	 * Column Info
	 * @return n5thInqFmDys
	 */
	public String getN5thInqFmDys() {
		return this.n5thInqFmDys;
	}
	

	/**
	 * Column Info
	 * @param n5thInqToDys
	 */
	public void setN5thInqToDys(String n5thInqToDys) {
		this.n5thInqToDys = n5thInqToDys;
	}
	
	/**
	 * Column Info
	 * @param n2ndInqFmDys
	 */
	public void setN2ndInqFmDys(String n2ndInqFmDys) {
		this.n2ndInqFmDys = n2ndInqFmDys;
	}
	
	/**
	 * Column Info
	 * @param chssMvmtDt0OrOver
	 */
	public void setChssMvmtDt0OrOver(String chssMvmtDt0OrOver) {
		this.chssMvmtDt0OrOver = chssMvmtDt0OrOver;
	}
	
	/**
	 * Column Info
	 * @param includeOutGated
	 */
	public void setIncludeOutGated(String includeOutGated) {
		this.includeOutGated = includeOutGated;
	}
	
	/**
	 * Column Info
	 * @param chssMvmtDt101180Rate
	 */
	public void setChssMvmtDt101180Rate(String chssMvmtDt101180Rate) {
		this.chssMvmtDt101180Rate = chssMvmtDt101180Rate;
	}
	
	/**
	 * Column Info
	 * @param includeStatusLst
	 */
	public void setIncludeStatusLst(String includeStatusLst) {
		this.includeStatusLst = includeStatusLst;
	}
	
	/**
	 * Column Info
	 * @param chssPoolCd
	 */
	public void setChssPoolCd(String chssPoolCd) {
		this.chssPoolCd = chssPoolCd;
	}
	
	/**
	 * Column Info
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * Column Info
	 * @param includeNp
	 */
	public void setIncludeNp(String includeNp) {
		this.includeNp = includeNp;
	}
	
	/**
	 * Column Info
	 * @param chssMvmtDt51100Rate
	 */
	public void setChssMvmtDt51100Rate(String chssMvmtDt51100Rate) {
		this.chssMvmtDt51100Rate = chssMvmtDt51100Rate;
	}
	
	/**
	 * Column Info
	 * @param n3rdInqFmDys
	 */
	public void setN3rdInqFmDys(String n3rdInqFmDys) {
		this.n3rdInqFmDys = n3rdInqFmDys;
	}
	
	/**
	 * Column Info
	 * @param crntYdCd
	 */
	public void setCrntYdCd(String crntYdCd) {
		this.crntYdCd = crntYdCd;
	}
	
	/**
	 * Column Info
	 * @param chssMvmtDt181Over
	 */
	public void setChssMvmtDt181Over(String chssMvmtDt181Over) {
		this.chssMvmtDt181Over = chssMvmtDt181Over;
	}
	
	/**
	 * Column Info
	 * @param n1stInqFmDys
	 */
	public void setN1stInqFmDys(String n1stInqFmDys) {
		this.n1stInqFmDys = n1stInqFmDys;
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
	 * @param n2ndInqToDys
	 */
	public void setN2ndInqToDys(String n2ndInqToDys) {
		this.n2ndInqToDys = n2ndInqToDys;
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
	 * @param chssMvmtDtTot
	 */
	public void setChssMvmtDtTot(String chssMvmtDtTot) {
		this.chssMvmtDtTot = chssMvmtDtTot;
	}
	
	/**
	 * Column Info
	 * @param n1stInqToDys
	 */
	public void setN1stInqToDys(String n1stInqToDys) {
		this.n1stInqToDys = n1stInqToDys;
	}
	
	/**
	 * Column Info
	 * @param chssMvmtDt3150
	 */
	public void setChssMvmtDt3150(String chssMvmtDt3150) {
		this.chssMvmtDt3150 = chssMvmtDt3150;
	}
	
	/**
	 * Column Info
	 * @param group1
	 */
	public void setGroup1(String group1) {
		this.group1 = group1;
	}
	
	/**
	 * Column Info
	 * @param chssMvmtDt1630Rate
	 */
	public void setChssMvmtDt1630Rate(String chssMvmtDt1630Rate) {
		this.chssMvmtDt1630Rate = chssMvmtDt1630Rate;
	}
	
	/**
	 * Column Info
	 * @param chssMvmtDt1630
	 */
	public void setChssMvmtDt1630(String chssMvmtDt1630) {
		this.chssMvmtDt1630 = chssMvmtDt1630;
	}
	
	/**
	 * Column Info
	 * @param atchBare
	 */
	public void setAtchBare(String atchBare) {
		this.atchBare = atchBare;
	}
	
	/**
	 * Column Info
	 * @param n4thInqFmDys
	 */
	public void setN4thInqFmDys(String n4thInqFmDys) {
		this.n4thInqFmDys = n4thInqFmDys;
	}
	
	/**
	 * Column Info
	 * @param chssMvmtDt101180
	 */
	public void setChssMvmtDt101180(String chssMvmtDt101180) {
		this.chssMvmtDt101180 = chssMvmtDt101180;
	}
	
	/**
	 * Column Info
	 * @param chssMvmtDt3150Rate
	 */
	public void setChssMvmtDt3150Rate(String chssMvmtDt3150Rate) {
		this.chssMvmtDt3150Rate = chssMvmtDt3150Rate;
	}
	
	/**
	 * Column Info
	 * @param n4thInqToDys
	 */
	public void setN4thInqToDys(String n4thInqToDys) {
		this.n4thInqToDys = n4thInqToDys;
	}
	
	/**
	 * Column Info
	 * @param n3rdInqToDys
	 */
	public void setN3rdInqToDys(String n3rdInqToDys) {
		this.n3rdInqToDys = n3rdInqToDys;
	}
	
	/**
	 * Column Info
	 * @param agmtLstmCd
	 */
	public void setAgmtLstmCd(String agmtLstmCd) {
		this.agmtLstmCd = agmtLstmCd;
	}
	
	/**
	 * Column Info
	 * @param aciacDivCd
	 */
	public void setAciacDivCd(String aciacDivCd) {
		this.aciacDivCd = aciacDivCd;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	
	/**
	 * Column Info
	 * @param chssMvmtDt51100
	 */
	public void setChssMvmtDt51100(String chssMvmtDt51100) {
		this.chssMvmtDt51100 = chssMvmtDt51100;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @param dmgSnd
	 */
	public void setDmgSnd(String dmgSnd) {
		this.dmgSnd = dmgSnd;
	}
	
	/**
	 * Column Info
	 * @param chssMvmtDt181OverRate
	 */
	public void setChssMvmtDt181OverRate(String chssMvmtDt181OverRate) {
		this.chssMvmtDt181OverRate = chssMvmtDt181OverRate;
	}
	
	/**
	 * Column Info
	 * @param chssMvmtDtToday15
	 */
	public void setChssMvmtDtToday15(String chssMvmtDtToday15) {
		this.chssMvmtDtToday15 = chssMvmtDtToday15;
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
	 * @param stayingDays
	 */
	public void setStayingDays(String stayingDays) {
		this.stayingDays = stayingDays;
	}
	
	/**
	 * Column Info
	 * @param chssMvmtDtToday15Rate
	 */
	public void setChssMvmtDtToday15Rate(String chssMvmtDtToday15Rate) {
		this.chssMvmtDtToday15Rate = chssMvmtDtToday15Rate;
	}
	
	/**
	 * Column Info
	 * @param chssMvmtStsCd
	 */
	public void setChssMvmtStsCd(String chssMvmtStsCd) {
		this.chssMvmtStsCd = chssMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @param chssMvmtDt0OrOverRate
	 */
	public void setChssMvmtDt0OrOverRate(String chssMvmtDt0OrOverRate) {
		this.chssMvmtDt0OrOverRate = chssMvmtDt0OrOverRate;
	}
	
	/**
	 * Column Info
	 * @param crntLocCd
	 */
	public void setCrntLocCd(String crntLocCd) {
		this.crntLocCd = crntLocCd;
	}
	
	/**
	 * Column Info
	 * @param n5thInqFmDys
	 */
	public void setN5thInqFmDys(String n5thInqFmDys) {
		this.n5thInqFmDys = n5thInqFmDys;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setN5thInqToDys(JSPUtil.getParameter(request, "n5th_inq_to_dys", ""));
		setN2ndInqFmDys(JSPUtil.getParameter(request, "n2nd_inq_fm_dys", ""));
		setChssMvmtDt0OrOver(JSPUtil.getParameter(request, "chss_mvmt_dt_0_or_over", ""));
		setIncludeOutGated(JSPUtil.getParameter(request, "include_out_gated", ""));
		setChssMvmtDt101180Rate(JSPUtil.getParameter(request, "chss_mvmt_dt_101_180_rate", ""));
		setIncludeStatusLst(JSPUtil.getParameter(request, "include_status_lst", ""));
		setChssPoolCd(JSPUtil.getParameter(request, "chss_pool_cd", ""));
		setLocation(JSPUtil.getParameter(request, "location", ""));
		setIncludeNp(JSPUtil.getParameter(request, "include_np", ""));
		setChssMvmtDt51100Rate(JSPUtil.getParameter(request, "chss_mvmt_dt_51_100_rate", ""));
		setN3rdInqFmDys(JSPUtil.getParameter(request, "n3rd_inq_fm_dys", ""));
		setCrntYdCd(JSPUtil.getParameter(request, "crnt_yd_cd", ""));
		setChssMvmtDt181Over(JSPUtil.getParameter(request, "chss_mvmt_dt_181_over", ""));
		setN1stInqFmDys(JSPUtil.getParameter(request, "n1st_inq_fm_dys", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setN2ndInqToDys(JSPUtil.getParameter(request, "n2nd_inq_to_dys", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setChssMvmtDtTot(JSPUtil.getParameter(request, "chss_mvmt_dt_tot", ""));
		setN1stInqToDys(JSPUtil.getParameter(request, "n1st_inq_to_dys", ""));
		setChssMvmtDt3150(JSPUtil.getParameter(request, "chss_mvmt_dt_31_50", ""));
		setGroup1(JSPUtil.getParameter(request, "group1", ""));
		setChssMvmtDt1630Rate(JSPUtil.getParameter(request, "chss_mvmt_dt_16_30_rate", ""));
		setChssMvmtDt1630(JSPUtil.getParameter(request, "chss_mvmt_dt_16_30", ""));
		setAtchBare(JSPUtil.getParameter(request, "atch_bare", ""));
		setN4thInqFmDys(JSPUtil.getParameter(request, "n4th_inq_fm_dys", ""));
		setChssMvmtDt101180(JSPUtil.getParameter(request, "chss_mvmt_dt_101_180", ""));
		setChssMvmtDt3150Rate(JSPUtil.getParameter(request, "chss_mvmt_dt_31_50_rate", ""));
		setN4thInqToDys(JSPUtil.getParameter(request, "n4th_inq_to_dys", ""));
		setN3rdInqToDys(JSPUtil.getParameter(request, "n3rd_inq_to_dys", ""));
		setAgmtLstmCd(JSPUtil.getParameter(request, "agmt_lstm_cd", ""));
		setAciacDivCd(JSPUtil.getParameter(request, "aciac_div_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setChssMvmtDt51100(JSPUtil.getParameter(request, "chss_mvmt_dt_51_100", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setDmgSnd(JSPUtil.getParameter(request, "dmg_snd", ""));
		setChssMvmtDt181OverRate(JSPUtil.getParameter(request, "chss_mvmt_dt_181_over_rate", ""));
		setChssMvmtDtToday15(JSPUtil.getParameter(request, "chss_mvmt_dt_today_15", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setStayingDays(JSPUtil.getParameter(request, "staying_days", ""));
		setChssMvmtDtToday15Rate(JSPUtil.getParameter(request, "chss_mvmt_dt_today_15_rate", ""));
		setChssMvmtStsCd(JSPUtil.getParameter(request, "chss_mvmt_sts_cd", ""));
		setChssMvmtDt0OrOverRate(JSPUtil.getParameter(request, "chss_mvmt_dt_0_or_over_rate", ""));
		setCrntLocCd(JSPUtil.getParameter(request, "crnt_loc_cd", ""));
		setN5thInqFmDys(JSPUtil.getParameter(request, "n5th_inq_fm_dys", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CHSInventoryByStaydaysMGTVO[]
	 */
	public CHSInventoryByStaydaysMGTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CHSInventoryByStaydaysMGTVO[]
	 */
	public CHSInventoryByStaydaysMGTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CHSInventoryByStaydaysMGTVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] n5thInqToDys = (JSPUtil.getParameter(request, prefix	+ "n5th_inq_to_dys", length));
			String[] n2ndInqFmDys = (JSPUtil.getParameter(request, prefix	+ "n2nd_inq_fm_dys", length));
			String[] chssMvmtDt0OrOver = (JSPUtil.getParameter(request, prefix	+ "chss_mvmt_dt_0_or_over", length));
			String[] includeOutGated = (JSPUtil.getParameter(request, prefix	+ "include_out_gated", length));
			String[] chssMvmtDt101180Rate = (JSPUtil.getParameter(request, prefix	+ "chss_mvmt_dt_101_180_rate", length));
			String[] includeStatusLst = (JSPUtil.getParameter(request, prefix	+ "include_status_lst", length));
			String[] chssPoolCd = (JSPUtil.getParameter(request, prefix	+ "chss_pool_cd", length));
			String[] location = (JSPUtil.getParameter(request, prefix	+ "location", length));
			String[] includeNp = (JSPUtil.getParameter(request, prefix	+ "include_np", length));
			String[] chssMvmtDt51100Rate = (JSPUtil.getParameter(request, prefix	+ "chss_mvmt_dt_51_100_rate", length));
			String[] n3rdInqFmDys = (JSPUtil.getParameter(request, prefix	+ "n3rd_inq_fm_dys", length));
			String[] crntYdCd = (JSPUtil.getParameter(request, prefix	+ "crnt_yd_cd", length));
			String[] chssMvmtDt181Over = (JSPUtil.getParameter(request, prefix	+ "chss_mvmt_dt_181_over", length));
			String[] n1stInqFmDys = (JSPUtil.getParameter(request, prefix	+ "n1st_inq_fm_dys", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] n2ndInqToDys = (JSPUtil.getParameter(request, prefix	+ "n2nd_inq_to_dys", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] chssMvmtDtTot = (JSPUtil.getParameter(request, prefix	+ "chss_mvmt_dt_tot", length));
			String[] n1stInqToDys = (JSPUtil.getParameter(request, prefix	+ "n1st_inq_to_dys", length));
			String[] chssMvmtDt3150 = (JSPUtil.getParameter(request, prefix	+ "chss_mvmt_dt_31_50", length));
			String[] group1 = (JSPUtil.getParameter(request, prefix	+ "group1", length));
			String[] chssMvmtDt1630Rate = (JSPUtil.getParameter(request, prefix	+ "chss_mvmt_dt_16_30_rate", length));
			String[] chssMvmtDt1630 = (JSPUtil.getParameter(request, prefix	+ "chss_mvmt_dt_16_30", length));
			String[] atchBare = (JSPUtil.getParameter(request, prefix	+ "atch_bare", length));
			String[] n4thInqFmDys = (JSPUtil.getParameter(request, prefix	+ "n4th_inq_fm_dys", length));
			String[] chssMvmtDt101180 = (JSPUtil.getParameter(request, prefix	+ "chss_mvmt_dt_101_180", length));
			String[] chssMvmtDt3150Rate = (JSPUtil.getParameter(request, prefix	+ "chss_mvmt_dt_31_50_rate", length));
			String[] n4thInqToDys = (JSPUtil.getParameter(request, prefix	+ "n4th_inq_to_dys", length));
			String[] n3rdInqToDys = (JSPUtil.getParameter(request, prefix	+ "n3rd_inq_to_dys", length));
			String[] agmtLstmCd = (JSPUtil.getParameter(request, prefix	+ "agmt_lstm_cd", length));
			String[] aciacDivCd = (JSPUtil.getParameter(request, prefix	+ "aciac_div_cd", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] chssMvmtDt51100 = (JSPUtil.getParameter(request, prefix	+ "chss_mvmt_dt_51_100", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] dmgSnd = (JSPUtil.getParameter(request, prefix	+ "dmg_snd", length));
			String[] chssMvmtDt181OverRate = (JSPUtil.getParameter(request, prefix	+ "chss_mvmt_dt_181_over_rate", length));
			String[] chssMvmtDtToday15 = (JSPUtil.getParameter(request, prefix	+ "chss_mvmt_dt_today_15", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] stayingDays = (JSPUtil.getParameter(request, prefix	+ "staying_days", length));
			String[] chssMvmtDtToday15Rate = (JSPUtil.getParameter(request, prefix	+ "chss_mvmt_dt_today_15_rate", length));
			String[] chssMvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "chss_mvmt_sts_cd", length));
			String[] chssMvmtDt0OrOverRate = (JSPUtil.getParameter(request, prefix	+ "chss_mvmt_dt_0_or_over_rate", length));
			String[] crntLocCd = (JSPUtil.getParameter(request, prefix	+ "crnt_loc_cd", length));
			String[] n5thInqFmDys = (JSPUtil.getParameter(request, prefix	+ "n5th_inq_fm_dys", length));
			
			for (int i = 0; i < length; i++) {
				model = new CHSInventoryByStaydaysMGTVO();
				if (n5thInqToDys[i] != null)
					model.setN5thInqToDys(n5thInqToDys[i]);
				if (n2ndInqFmDys[i] != null)
					model.setN2ndInqFmDys(n2ndInqFmDys[i]);
				if (chssMvmtDt0OrOver[i] != null)
					model.setChssMvmtDt0OrOver(chssMvmtDt0OrOver[i]);
				if (includeOutGated[i] != null)
					model.setIncludeOutGated(includeOutGated[i]);
				if (chssMvmtDt101180Rate[i] != null)
					model.setChssMvmtDt101180Rate(chssMvmtDt101180Rate[i]);
				if (includeStatusLst[i] != null)
					model.setIncludeStatusLst(includeStatusLst[i]);
				if (chssPoolCd[i] != null)
					model.setChssPoolCd(chssPoolCd[i]);
				if (location[i] != null)
					model.setLocation(location[i]);
				if (includeNp[i] != null)
					model.setIncludeNp(includeNp[i]);
				if (chssMvmtDt51100Rate[i] != null)
					model.setChssMvmtDt51100Rate(chssMvmtDt51100Rate[i]);
				if (n3rdInqFmDys[i] != null)
					model.setN3rdInqFmDys(n3rdInqFmDys[i]);
				if (crntYdCd[i] != null)
					model.setCrntYdCd(crntYdCd[i]);
				if (chssMvmtDt181Over[i] != null)
					model.setChssMvmtDt181Over(chssMvmtDt181Over[i]);
				if (n1stInqFmDys[i] != null)
					model.setN1stInqFmDys(n1stInqFmDys[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (n2ndInqToDys[i] != null)
					model.setN2ndInqToDys(n2ndInqToDys[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (chssMvmtDtTot[i] != null)
					model.setChssMvmtDtTot(chssMvmtDtTot[i]);
				if (n1stInqToDys[i] != null)
					model.setN1stInqToDys(n1stInqToDys[i]);
				if (chssMvmtDt3150[i] != null)
					model.setChssMvmtDt3150(chssMvmtDt3150[i]);
				if (group1[i] != null)
					model.setGroup1(group1[i]);
				if (chssMvmtDt1630Rate[i] != null)
					model.setChssMvmtDt1630Rate(chssMvmtDt1630Rate[i]);
				if (chssMvmtDt1630[i] != null)
					model.setChssMvmtDt1630(chssMvmtDt1630[i]);
				if (atchBare[i] != null)
					model.setAtchBare(atchBare[i]);
				if (n4thInqFmDys[i] != null)
					model.setN4thInqFmDys(n4thInqFmDys[i]);
				if (chssMvmtDt101180[i] != null)
					model.setChssMvmtDt101180(chssMvmtDt101180[i]);
				if (chssMvmtDt3150Rate[i] != null)
					model.setChssMvmtDt3150Rate(chssMvmtDt3150Rate[i]);
				if (n4thInqToDys[i] != null)
					model.setN4thInqToDys(n4thInqToDys[i]);
				if (n3rdInqToDys[i] != null)
					model.setN3rdInqToDys(n3rdInqToDys[i]);
				if (agmtLstmCd[i] != null)
					model.setAgmtLstmCd(agmtLstmCd[i]);
				if (aciacDivCd[i] != null)
					model.setAciacDivCd(aciacDivCd[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (chssMvmtDt51100[i] != null)
					model.setChssMvmtDt51100(chssMvmtDt51100[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (dmgSnd[i] != null)
					model.setDmgSnd(dmgSnd[i]);
				if (chssMvmtDt181OverRate[i] != null)
					model.setChssMvmtDt181OverRate(chssMvmtDt181OverRate[i]);
				if (chssMvmtDtToday15[i] != null)
					model.setChssMvmtDtToday15(chssMvmtDtToday15[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (stayingDays[i] != null)
					model.setStayingDays(stayingDays[i]);
				if (chssMvmtDtToday15Rate[i] != null)
					model.setChssMvmtDtToday15Rate(chssMvmtDtToday15Rate[i]);
				if (chssMvmtStsCd[i] != null)
					model.setChssMvmtStsCd(chssMvmtStsCd[i]);
				if (chssMvmtDt0OrOverRate[i] != null)
					model.setChssMvmtDt0OrOverRate(chssMvmtDt0OrOverRate[i]);
				if (crntLocCd[i] != null)
					model.setCrntLocCd(crntLocCd[i]);
				if (n5thInqFmDys[i] != null)
					model.setN5thInqFmDys(n5thInqFmDys[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCHSInventoryByStaydaysMGTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CHSInventoryByStaydaysMGTVO[]
	 */
	public CHSInventoryByStaydaysMGTVO[] getCHSInventoryByStaydaysMGTVOs(){
		CHSInventoryByStaydaysMGTVO[] vos = (CHSInventoryByStaydaysMGTVO[])models.toArray(new CHSInventoryByStaydaysMGTVO[models.size()]);
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
		this.n5thInqToDys = this.n5thInqToDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndInqFmDys = this.n2ndInqFmDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssMvmtDt0OrOver = this.chssMvmtDt0OrOver .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.includeOutGated = this.includeOutGated .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssMvmtDt101180Rate = this.chssMvmtDt101180Rate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.includeStatusLst = this.includeStatusLst .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssPoolCd = this.chssPoolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.location = this.location .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.includeNp = this.includeNp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssMvmtDt51100Rate = this.chssMvmtDt51100Rate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdInqFmDys = this.n3rdInqFmDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntYdCd = this.crntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssMvmtDt181Over = this.chssMvmtDt181Over .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stInqFmDys = this.n1stInqFmDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndInqToDys = this.n2ndInqToDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssMvmtDtTot = this.chssMvmtDtTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stInqToDys = this.n1stInqToDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssMvmtDt3150 = this.chssMvmtDt3150 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.group1 = this.group1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssMvmtDt1630Rate = this.chssMvmtDt1630Rate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssMvmtDt1630 = this.chssMvmtDt1630 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchBare = this.atchBare .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thInqFmDys = this.n4thInqFmDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssMvmtDt101180 = this.chssMvmtDt101180 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssMvmtDt3150Rate = this.chssMvmtDt3150Rate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thInqToDys = this.n4thInqToDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdInqToDys = this.n3rdInqToDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtLstmCd = this.agmtLstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aciacDivCd = this.aciacDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssMvmtDt51100 = this.chssMvmtDt51100 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgSnd = this.dmgSnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssMvmtDt181OverRate = this.chssMvmtDt181OverRate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssMvmtDtToday15 = this.chssMvmtDtToday15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayingDays = this.stayingDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssMvmtDtToday15Rate = this.chssMvmtDtToday15Rate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssMvmtStsCd = this.chssMvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssMvmtDt0OrOverRate = this.chssMvmtDt0OrOverRate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntLocCd = this.crntLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n5thInqFmDys = this.n5thInqFmDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
