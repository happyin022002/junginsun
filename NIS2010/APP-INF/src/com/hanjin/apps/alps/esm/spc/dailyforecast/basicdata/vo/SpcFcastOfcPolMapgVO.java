/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpcFcastOfcPolMapgVO.java
*@FileTitle : SpcFcastOfcPolMapgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.24
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.07.24 한상훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.spc.dailyforecast.basicdata.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 한상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SpcFcastOfcPolMapgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SpcFcastOfcPolMapgVO> models = new ArrayList<SpcFcastOfcPolMapgVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String slsAqCd = null;
	/* Column Info */
	private String iocTsCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String repTrdCd = null;
	/* Column Info */
	private String slsRhqCd = null;
	/* Column Info */
	private String bseYrwk = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cdDpSeq = null;
	/* Column Info */
	private String polYdCd = null;
	/* Column Info */
	private String polYdCd1 = null;
	/* Column Info */
	private String polYdCd2 = null;
	/* Column Info */
	private String polYdCd3 = null;
	/* Column Info */
	private String polYdCd4 = null;
	/* Column Info */
	private String polYdCd5 = null;
	/* Column Info */
	private String polYdCd6 = null;
	/* Column Info */
	private String polYdCd7 = null;
	/* Column Info */
	private String polYdCd8 = null;
	/* Column Info */
	private String polYdCd9 = null;
	/* Column Info */
	private String polYdCd10 = null;
	/* Column Info */
	private String slsOfcCd = null;
	/* Column Info */
	private String slsRgnOfcCd = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String repSubTrdCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String subTrdCd = null;	
	/* Column Info */
	private String bseYr = null;
	/* Column Info */
	private String bseWk = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SpcFcastOfcPolMapgVO() {}

	public SpcFcastOfcPolMapgVO(String ibflag, String pagerows, String repTrdCd, String repSubTrdCd, String rlaneCd, String bseYrwk, String slsOfcCd, String polYdCd, String polYdCd1, String polYdCd2, String polYdCd3, String polYdCd4, String polYdCd5, String polYdCd6, String polYdCd7, String polYdCd8, String polYdCd9, String polYdCd10, String iocTsCd, String dirCd, String cdDpSeq, String trdCd, String subTrdCd, String slsRhqCd, String slsAqCd, String slsRgnOfcCd, String creUsrId, String creDt, String updUsrId, String updDt, String bseYr, String bseWk) {
		this.updDt = updDt;
		this.slsAqCd = slsAqCd;
		this.iocTsCd = iocTsCd;
		this.creDt = creDt;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.repTrdCd = repTrdCd;
		this.slsRhqCd = slsRhqCd;
		this.bseYrwk = bseYrwk;
		this.pagerows = pagerows;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.cdDpSeq = cdDpSeq;
		this.polYdCd= polYdCd;
		this.polYdCd1= polYdCd1;
		this.polYdCd2= polYdCd2;
		this.polYdCd3= polYdCd3;
		this.polYdCd4= polYdCd4;
		this.polYdCd5= polYdCd5;
		this.polYdCd6= polYdCd6;
		this.polYdCd7= polYdCd7;
		this.polYdCd8= polYdCd8;
		this.polYdCd9= polYdCd9;
		this.polYdCd10= polYdCd10;
		this.slsOfcCd = slsOfcCd;
		this.slsRgnOfcCd = slsRgnOfcCd;
		this.dirCd = dirCd;
		this.repSubTrdCd = repSubTrdCd;
		this.updUsrId = updUsrId;
		this.subTrdCd = subTrdCd;
		this.bseYr = bseYr;
		this.bseWk = bseWk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("sls_aq_cd", getSlsAqCd());
		this.hashColumns.put("ioc_ts_cd", getIocTsCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("rep_trd_cd", getRepTrdCd());
		this.hashColumns.put("sls_rhq_cd", getSlsRhqCd());
		this.hashColumns.put("bse_yrwk", getBseYrwk());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cd_dp_seq", getCdDpSeq());
		this.hashColumns.put("pol_cd", getPolYdCd());
		this.hashColumns.put("pol_cd1", getPolYdCd1());
		this.hashColumns.put("pol_cd2", getPolYdCd2());
		this.hashColumns.put("pol_cd3", getPolYdCd3());
		this.hashColumns.put("pol_cd4", getPolYdCd4());
		this.hashColumns.put("pol_cd5", getPolYdCd5());
		this.hashColumns.put("pol_cd6", getPolYdCd6());
		this.hashColumns.put("pol_cd7", getPolYdCd7());
		this.hashColumns.put("pol_cd8", getPolYdCd8());
		this.hashColumns.put("pol_cd9", getPolYdCd9());
		this.hashColumns.put("pol_cd10", getPolYdCd10());		
		this.hashColumns.put("sls_ofc_cd", getSlsOfcCd());
		this.hashColumns.put("sls_rgn_ofc_cd", getSlsRgnOfcCd());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("rep_sub_trd_cd", getRepSubTrdCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("bse_yr", getBseYr());
		this.hashColumns.put("bse_wk", getBseWk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("sls_aq_cd", "slsAqCd");
		this.hashFields.put("ioc_ts_cd", "iocTsCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("rep_trd_cd", "repTrdCd");
		this.hashFields.put("sls_rhq_cd", "slsRhqCd");
		this.hashFields.put("bse_yrwk", "bseYrwk");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cd_dp_seq", "cdDpSeq");
		this.hashFields.put("pol_yd_cd", "polYdCd");
		this.hashFields.put("pol_cd1", "polYdCd1");
		this.hashFields.put("pol_cd2", "polYdCd2");
		this.hashFields.put("pol_cd3", "polYdCd3");
		this.hashFields.put("pol_cd4", "polYdCd4");
		this.hashFields.put("pol_cd5", "polYdCd5");
		this.hashFields.put("pol_cd6", "polYdCd6");
		this.hashFields.put("pol_cd7", "polYdCd7");
		this.hashFields.put("pol_cd8", "polYdCd8");
		this.hashFields.put("pol_cd9", "polYdCd9");
		this.hashFields.put("pol_cd10", "polYdCd10");
		this.hashFields.put("sls_ofc_cd", "slsOfcCd");
		this.hashFields.put("sls_rgn_ofc_cd", "slsRgnOfcCd");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("rep_sub_trd_cd", "repSubTrdCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("bse_yr", "bseYr");
		this.hashFields.put("bse_wk", "bseWk");
		return this.hashFields;
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
	 * @return slsAqCd
	 */
	public String getSlsAqCd() {
		return this.slsAqCd;
	}
	
	/**
	 * Column Info
	 * @return iocTsCd
	 */
	public String getIocTsCd() {
		return this.iocTsCd;
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
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
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
	 * @return repTrdCd
	 */
	public String getRepTrdCd() {
		return this.repTrdCd;
	}
	
	/**
	 * Column Info
	 * @return slsRhqCd
	 */
	public String getSlsRhqCd() {
		return this.slsRhqCd;
	}
	
	/**
	 * Column Info
	 * @return bseYrwk
	 */
	public String getBseYrwk() {
		return this.bseYrwk;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return cdDpSeq
	 */
	public String getCdDpSeq() {
		return this.cdDpSeq;
	}

	/**
	 * Column Info
	 * @return polYdCd
	 */
	public String getPolYdCd() {
		return this.polYdCd;
	}

	/**
	 * Column Info
	 * @return polYdCd1
	 */
	public String getPolYdCd1() {
		return this.polYdCd1;
	}

	/**
	 * Column Info
	 * @return polYdCd2
	 */
	public String getPolYdCd2() {
		return this.polYdCd2;
	}

	/**
	 * Column Info
	 * @return polYdCd3
	 */
	public String getPolYdCd3() {
		return this.polYdCd3;
	}

	/**
	 * Column Info
	 * @return polYdCd4
	 */
	public String getPolYdCd4() {
		return this.polYdCd4;
	}

	/**
	 * Column Info
	 * @return polYdCd5
	 */
	public String getPolYdCd5() {
		return this.polYdCd5;
	}

	/**
	 * Column Info
	 * @return polYdCd6
	 */
	public String getPolYdCd6() {
		return this.polYdCd6;
	}

	/**
	 * Column Info
	 * @return polYdCd7
	 */
	public String getPolYdCd7() {
		return this.polYdCd7;
	}

	/**
	 * Column Info
	 * @return polYdCd8
	 */
	public String getPolYdCd8() {
		return this.polYdCd8;
	}

	/**
	 * Column Info
	 * @return polYdCd9
	 */
	public String getPolYdCd9() {
		return this.polYdCd9;
	}

	/**
	 * Column Info
	 * @return polYdCd10
	 */
	public String getPolYdCd10() {
		return this.polYdCd10;
	}

	
	/**
	 * Column Info
	 * @return slsOfcCd
	 */
	public String getSlsOfcCd() {
		return this.slsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return slsRgnOfcCd
	 */
	public String getSlsRgnOfcCd() {
		return this.slsRgnOfcCd;
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
	 * @return repSubTrdCd
	 */
	public String getRepSubTrdCd() {
		return this.repSubTrdCd;
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
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
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
	 * @return bseWk
	 */
	public String getBseWk() {
		return this.bseWk;
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
	 * @param slsAqCd
	 */
	public void setSlsAqCd(String slsAqCd) {
		this.slsAqCd = slsAqCd;
	}
	
	/**
	 * Column Info
	 * @param iocTsCd
	 */
	public void setIocTsCd(String iocTsCd) {
		this.iocTsCd = iocTsCd;
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
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
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
	 * @param repTrdCd
	 */
	public void setRepTrdCd(String repTrdCd) {
		this.repTrdCd = repTrdCd;
	}
	
	/**
	 * Column Info
	 * @param slsRhqCd
	 */
	public void setSlsRhqCd(String slsRhqCd) {
		this.slsRhqCd = slsRhqCd;
	}
	
	/**
	 * Column Info
	 * @param bseYrwk
	 */
	public void setBseYrwk(String bseYrwk) {
		this.bseYrwk = bseYrwk;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param cdDpSeq
	 */
	public void setCdDpSeq(String cdDpSeq) {
		this.cdDpSeq = cdDpSeq;
	}

	/**
	 * Column Info
	 * @param polYdCd
	 */
	public void setPolYdCd(String polYdCd) {
		this.polYdCd = polYdCd;
	}

	/**
	 * Column Info
	 * @param polYdCd1
	 */
	public void setPolYdCd1(String polYdCd1) {
		this.polYdCd1 = polYdCd1;
	}

	/**
	 * Column Info
	 * @param polYdCd2
	 */
	public void setPolYdCd2(String polYdCd2) {
		this.polYdCd2 = polYdCd2;
	}

	/**
	 * Column Info
	 * @param polYdCd3
	 */
	public void setPolYdCd3(String polYdCd3) {
		this.polYdCd3 = polYdCd3;
	}

	/**
	 * Column Info
	 * @param polYdCd4
	 */
	public void setPolYdCd4(String polYdCd4) {
		this.polYdCd4 = polYdCd4;
	}

	/**
	 * Column Info
	 * @param polYdCd5
	 */
	public void setPolYdCd5(String polYdCd5) {
		this.polYdCd5 = polYdCd5;
	}

	/**
	 * Column Info
	 * @param polYdCd6
	 */
	public void setPolYdCd6(String polYdCd6) {
		this.polYdCd6 = polYdCd6;
	}

	/**
	 * Column Info
	 * @param polYdCd7
	 */
	public void setPolYdCd7(String polYdCd7) {
		this.polYdCd7 = polYdCd7;
	}

	/**
	 * Column Info
	 * @param polYdCd8
	 */
	public void setPolYdCd8(String polYdCd8) {
		this.polYdCd8 = polYdCd8;
	}

	/**
	 * Column Info
	 * @param polYdCd9
	 */
	public void setPolYdCd9(String polYdCd9) {
		this.polYdCd9 = polYdCd9;
	}

	/**
	 * Column Info
	 * @param polYdCd10
	 */
	public void setPolYdCd10(String polYdCd10) {
		this.polYdCd10 = polYdCd10;
	}

	
	
	/**
	 * Column Info
	 * @param slsOfcCd
	 */
	public void setSlsOfcCd(String slsOfcCd) {
		this.slsOfcCd = slsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param slsRgnOfcCd
	 */
	public void setSlsRgnOfcCd(String slsRgnOfcCd) {
		this.slsRgnOfcCd = slsRgnOfcCd;
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
	 * @param repSubTrdCd
	 */
	public void setRepSubTrdCd(String repSubTrdCd) {
		this.repSubTrdCd = repSubTrdCd;
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
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
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
	 * @param bseWk
	 */
	public void setBseWk(String bseWk) {
		this.bseWk = bseWk;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setSlsAqCd(JSPUtil.getParameter(request, "sls_aq_cd", ""));
		setIocTsCd(JSPUtil.getParameter(request, "ioc_ts_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setRepTrdCd(JSPUtil.getParameter(request, "rep_trd_cd", ""));
		setSlsRhqCd(JSPUtil.getParameter(request, "sls_rhq_cd", ""));
		setBseYrwk(JSPUtil.getParameter(request, "bse_yrwk", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCdDpSeq(JSPUtil.getParameter(request, "cd_dp_seq", ""));
		setPolYdCd(JSPUtil.getParameter(request, "pol_yd_cd", ""));
		setPolYdCd1(JSPUtil.getParameter(request, "pol_cd1", ""));
		setPolYdCd2(JSPUtil.getParameter(request, "pol_cd2", ""));
		setPolYdCd3(JSPUtil.getParameter(request, "pol_cd3", ""));
		setPolYdCd4(JSPUtil.getParameter(request, "pol_cd4", ""));
		setPolYdCd5(JSPUtil.getParameter(request, "pol_cd5", ""));
		setPolYdCd6(JSPUtil.getParameter(request, "pol_cd6", ""));
		setPolYdCd7(JSPUtil.getParameter(request, "pol_cd7", ""));
		setPolYdCd8(JSPUtil.getParameter(request, "pol_cd8", ""));
		setPolYdCd9(JSPUtil.getParameter(request, "pol_cd9", ""));
		setPolYdCd10(JSPUtil.getParameter(request, "pol_cd10", ""));
		setSlsOfcCd(JSPUtil.getParameter(request, "sls_ofc_cd", ""));
		setSlsRgnOfcCd(JSPUtil.getParameter(request, "sls_rgn_ofc_cd", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setRepSubTrdCd(JSPUtil.getParameter(request, "rep_sub_trd_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setSubTrdCd(JSPUtil.getParameter(request, "sub_trd_cd", ""));
		setBseYr(JSPUtil.getParameter(request, "bse_yr", ""));
		setBseWk(JSPUtil.getParameter(request, "bse_wk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SpcFcastOfcPolMapgVO[]
	 */
	public SpcFcastOfcPolMapgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SpcFcastOfcPolMapgVO[]
	 */
	public SpcFcastOfcPolMapgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SpcFcastOfcPolMapgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] slsAqCd = (JSPUtil.getParameter(request, prefix	+ "sls_aq_cd", length));
			String[] iocTsCd = (JSPUtil.getParameter(request, prefix	+ "ioc_ts_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] repTrdCd = (JSPUtil.getParameter(request, prefix	+ "rep_trd_cd", length));
			String[] slsRhqCd = (JSPUtil.getParameter(request, prefix	+ "sls_rhq_cd", length));
			String[] bseYrwk = (JSPUtil.getParameter(request, prefix	+ "bse_yrwk", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cdDpSeq = (JSPUtil.getParameter(request, prefix	+ "cd_dp_seq", length));
			//String[] polYdCd = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd", length));
			String[] polYdCd1 = (JSPUtil.getParameter(request, prefix	+ "pol_cd1", length));
			String[] polYdCd2 = (JSPUtil.getParameter(request, prefix	+ "pol_cd2", length));
			String[] polYdCd3 = (JSPUtil.getParameter(request, prefix	+ "pol_cd3", length));
			String[] polYdCd4 = (JSPUtil.getParameter(request, prefix	+ "pol_cd4", length));
			String[] polYdCd5 = (JSPUtil.getParameter(request, prefix	+ "pol_cd5", length));
			String[] polYdCd6 = (JSPUtil.getParameter(request, prefix	+ "pol_cd6", length));
			String[] polYdCd7 = (JSPUtil.getParameter(request, prefix	+ "pol_cd7", length));
			String[] polYdCd8 = (JSPUtil.getParameter(request, prefix	+ "pol_cd8", length));
			String[] polYdCd9 = (JSPUtil.getParameter(request, prefix	+ "pol_cd9", length));
			String[] polYdCd10 = (JSPUtil.getParameter(request, prefix	+ "pol_cd10", length));
			String[] slsOfcCd = (JSPUtil.getParameter(request, prefix	+ "sls_ofc_cd", length));
			String[] slsRgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "sls_rgn_ofc_cd", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] repSubTrdCd = (JSPUtil.getParameter(request, prefix	+ "rep_sub_trd_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] bseYr = (JSPUtil.getParameter(request, prefix	+ "bse_yr", length));
			String[] bseWk = (JSPUtil.getParameter(request, prefix	+ "bse_wk", length));
			
			for (int i = 0; i < length; i++) {				
				String polYdCd = polYdCd1[i] + ":" + polYdCd2[i] + ":" + polYdCd3[i] + ":" + polYdCd4[i] + ":" + polYdCd5[i] + ":" + polYdCd6[i] + ":" + polYdCd7[i] + ":" + polYdCd8[i] + ":" + polYdCd9[i] + ":" + polYdCd10[i];
				String[] st = polYdCd.split(":");
				
				for (int j = 0; j <st.length ; j++) {					
					model = new SpcFcastOfcPolMapgVO();
					
					if (updDt[i] != null)
						model.setUpdDt(updDt[i]);
					if (slsAqCd[i] != null)
						model.setSlsAqCd(slsAqCd[i]);
					if (iocTsCd[i] != null)
						model.setIocTsCd(iocTsCd[i]);
					if (creDt[i] != null)
						model.setCreDt(creDt[i]);
					if (trdCd[i] != null)
						model.setTrdCd(trdCd[i]);
					if (rlaneCd[i] != null)
						model.setRlaneCd(rlaneCd[i]);
					if (repTrdCd[i] != null)
						model.setRepTrdCd(repTrdCd[i]);
					if (slsRhqCd[i] != null)
						model.setSlsRhqCd(slsRhqCd[i]);
					if (bseYrwk[i] != null)
						model.setBseYrwk(bseYrwk[i]);
					if (pagerows[i] != null)
						model.setPagerows(pagerows[i]);
					if (creUsrId[i] != null)
						model.setCreUsrId(creUsrId[i]);
					if (ibflag[i] != null)
						model.setIbflag(ibflag[i]);
					if (cdDpSeq[i] != null)
						model.setCdDpSeq(cdDpSeq[i]);
					
					if(st[j] != null)
						model.setPolYdCd(st[j]);
						
					if (polYdCd1[i] != null)
						model.setPolYdCd1(polYdCd1[i]);
					if (polYdCd2[i] != null)
						model.setPolYdCd2(polYdCd2[i]);
					if (polYdCd3[i] != null)
						model.setPolYdCd3(polYdCd3[i]);
					if (polYdCd4[i] != null)
						model.setPolYdCd4(polYdCd4[i]);
					if (polYdCd5[i] != null)
						model.setPolYdCd5(polYdCd5[i]);
					if (polYdCd6[i] != null)
						model.setPolYdCd6(polYdCd6[i]);
					if (polYdCd7[i] != null)
						model.setPolYdCd7(polYdCd7[i]);
					if (polYdCd8[i] != null)
						model.setPolYdCd8(polYdCd8[i]);
					if (polYdCd9[i] != null)
						model.setPolYdCd9(polYdCd9[i]);
					if (polYdCd10[i] != null)
						model.setPolYdCd10(polYdCd10[i]);
					if (slsOfcCd[i] != null)
						model.setSlsOfcCd(slsOfcCd[i]);
					if (slsRgnOfcCd[i] != null)
						model.setSlsRgnOfcCd(slsRgnOfcCd[i]);
					if (dirCd[i] != null)
						model.setDirCd(dirCd[i]);
					if (repSubTrdCd[i] != null)
						model.setRepSubTrdCd(repSubTrdCd[i]);
					if (updUsrId[i] != null)
						model.setUpdUsrId(updUsrId[i]);
					if (subTrdCd[i] != null)
						model.setSubTrdCd(subTrdCd[i]);
					if (bseYr[i] != null)
						model.setBseYr(bseYr[i]);
					if (bseWk[i] != null)
						model.setBseWk(bseWk[i]);
					models.add(model);
				}
			}

		} catch (Exception e) {
			return null;
		}
		return getSpcFcastOfcPolMapgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SpcFcastOfcPolMapgVO[]
	 */
	public SpcFcastOfcPolMapgVO[] getSpcFcastOfcPolMapgVOs(){
		SpcFcastOfcPolMapgVO[] vos = (SpcFcastOfcPolMapgVO[])models.toArray(new SpcFcastOfcPolMapgVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsAqCd = this.slsAqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocTsCd = this.iocTsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repTrdCd = this.repTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsRhqCd = this.slsRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYrwk = this.bseYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cdDpSeq = this.cdDpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd = this.polYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd1 = this.polYdCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd2 = this.polYdCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd3 = this.polYdCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd4 = this.polYdCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd5 = this.polYdCd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd6 = this.polYdCd6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd7 = this.polYdCd7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd8 = this.polYdCd8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd9 = this.polYdCd9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd10 = this.polYdCd10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsOfcCd = this.slsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsRgnOfcCd = this.slsRgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repSubTrdCd = this.repSubTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYr = this.bseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseWk = this.bseWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
