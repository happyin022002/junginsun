/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0012MultiVO.java
*@FileTitle : EesEqr0012MultiVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.09.01 채창호 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 채창호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr0012MultiVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0012MultiVO> models = new ArrayList<EesEqr0012MultiVO>();
	
	/* Column Info */
	private String fmEccCdTmp = null;
	/* Column Info */
	private String laneCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String toEtbDt = null;
	/* Column Info */
	private String coCd = null;
	/* Column Info */
	private String toEccCdFlg = null;
	/* Column Info */
	private String toEccCd = null;
	/* Column Info */
	private String fmEtdDt1 = null;
	/* Column Info */
	private String toEccCdTmp = null;
	/* Column Info */
	private String fmEccCdFlg = null;
	/* Column Info */
	private String ldisTsFlg = null;
	/* Column Info */
	private String fmEccCdTmp1 = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String plnYrwk = null;
	/* Column Info */
	private String fixToEcc = null;
	/* Column Info */
	private String toEccCdTmp1 = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String fmEccCd = null;
	/* Column Info */
	private String pastRepoPlnFlg = null;
	/* Column Info */
	private String fmEtdDt = null;
	/* Column Info */
	private String toEtbDt1 = null;
	/* Column Info */
	private String planSeq = null;
	/* Column Info */
	private String repoPlanId = null;
	/* Column Info */
	private String fmYard = null;
	/* Column Info */
	private String toYard = null;

	
	private List<String> volList = null;
	private List<String> flagList = null;
	private List<String> fixList = null;

	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0012MultiVO() {}

	public EesEqr0012MultiVO(String ibflag, String pagerows, String plnYrwk, String fmEccCd, String fmEccCdTmp, String fmEtdDt, String toEccCd, String toEccCdTmp, String toEtbDt, String coCd, String laneCd, String vslCd, String skdVoyNo, String skdDirCd, String vvd, String fmEccCdTmp1, String fmEtdDt1, String toEccCdTmp1, String toEtbDt1, String fmEccCdFlg, String toEccCdFlg, String pastRepoPlnFlg, String fixToEcc, String ldisTsFlg ,String fmYard , String toYard) {
		this.fmEccCdTmp = fmEccCdTmp;
		this.laneCd = laneCd;
		this.vslCd = vslCd;
		this.toEtbDt = toEtbDt;
		this.coCd = coCd;
		this.toEccCdFlg = toEccCdFlg;
		this.toEccCd = toEccCd;
		this.fmEtdDt1 = fmEtdDt1;
		this.toEccCdTmp = toEccCdTmp;
		this.fmEccCdFlg = fmEccCdFlg;
		this.ldisTsFlg = ldisTsFlg;
		this.fmEccCdTmp1 = fmEccCdTmp1;
		this.skdVoyNo = skdVoyNo;
		this.plnYrwk = plnYrwk;
		this.fixToEcc = fixToEcc;
		this.toEccCdTmp1 = toEccCdTmp1;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.fmEccCd = fmEccCd;
		this.pastRepoPlnFlg = pastRepoPlnFlg;
		this.fmEtdDt = fmEtdDt;
		this.toEtbDt1 = toEtbDt1;
		this.toYard = toYard;
		this.fmYard = fmYard;
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("fm_ecc_cd_tmp", getFmEccCdTmp());
		this.hashColumns.put("lane_cd", getLaneCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("to_etb_dt", getToEtbDt());
		this.hashColumns.put("co_cd", getCoCd());
		this.hashColumns.put("to_ecc_cd_flg", getToEccCdFlg());
		this.hashColumns.put("to_ecc_cd", getToEccCd());
		this.hashColumns.put("fm_etd_dt1", getFmEtdDt1());
		this.hashColumns.put("to_ecc_cd_tmp", getToEccCdTmp());
		this.hashColumns.put("fm_ecc_cd_flg", getFmEccCdFlg());
		this.hashColumns.put("ldis_ts_flg", getLdisTsFlg());
		this.hashColumns.put("fm_ecc_cd_tmp1", getFmEccCdTmp1());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("pln_yrwk", getPlnYrwk());
		this.hashColumns.put("fix_to_ecc", getFixToEcc());
		this.hashColumns.put("to_ecc_cd_tmp1", getToEccCdTmp1());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fm_ecc_cd", getFmEccCd());
		this.hashColumns.put("past_repo_pln_flg", getPastRepoPlnFlg());
		this.hashColumns.put("fm_etd_dt", getFmEtdDt());
		this.hashColumns.put("to_etb_dt1", getToEtbDt1());
		this.hashColumns.put("plan_seq", getPlanSeq());
		this.hashColumns.put("repo_pln_id", getRepoPlanId());
		this.hashColumns.put("fm_yard", getFmYard());
		this.hashColumns.put("to_yard", getToYard());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("fm_ecc_cd_tmp", "fmEccCdTmp");
		this.hashFields.put("lane_cd", "laneCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("to_etb_dt", "toEtbDt");
		this.hashFields.put("co_cd", "coCd");
		this.hashFields.put("to_ecc_cd_flg", "toEccCdFlg");
		this.hashFields.put("to_ecc_cd", "toEccCd");
		this.hashFields.put("fm_etd_dt1", "fmEtdDt1");
		this.hashFields.put("to_ecc_cd_tmp", "toEccCdTmp");
		this.hashFields.put("fm_ecc_cd_flg", "fmEccCdFlg");
		this.hashFields.put("ldis_ts_flg", "ldisTsFlg");
		this.hashFields.put("fm_ecc_cd_tmp1", "fmEccCdTmp1");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("pln_yrwk", "plnYrwk");
		this.hashFields.put("fix_to_ecc", "fixToEcc");
		this.hashFields.put("to_ecc_cd_tmp1", "toEccCdTmp1");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fm_ecc_cd", "fmEccCd");
		this.hashFields.put("past_repo_pln_flg", "pastRepoPlnFlg");
		this.hashFields.put("fm_etd_dt", "fmEtdDt");
		this.hashFields.put("to_etb_dt1", "toEtbDt1");
		this.hashFields.put("plan_seq", "planSeq");
		this.hashFields.put("repo_pln_id", "repoPlanId");
		this.hashFields.put("fm_yard", "fmYard");
		this.hashFields.put("to_yard", "toYard");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fmEccCdTmp
	 */
	public String getFmEccCdTmp() {
		return this.fmEccCdTmp;
	}
	
	/**
	 * Column Info
	 * @return laneCd
	 */
	public String getLaneCd() {
		return this.laneCd;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return toEtbDt
	 */
	public String getToEtbDt() {
		return this.toEtbDt;
	}
	
	/**
	 * Column Info
	 * @return coCd
	 */
	public String getCoCd() {
		return this.coCd;
	}
	
	/**
	 * Column Info
	 * @return toEccCdFlg
	 */
	public String getToEccCdFlg() {
		return this.toEccCdFlg;
	}
	
	/**
	 * Column Info
	 * @return toEccCd
	 */
	public String getToEccCd() {
		return this.toEccCd;
	}
	
	/**
	 * Column Info
	 * @return fmEtdDt1
	 */
	public String getFmEtdDt1() {
		return this.fmEtdDt1;
	}
	
	/**
	 * Column Info
	 * @return toEccCdTmp
	 */
	public String getToEccCdTmp() {
		return this.toEccCdTmp;
	}
	
	/**
	 * Column Info
	 * @return fmEccCdFlg
	 */
	public String getFmEccCdFlg() {
		return this.fmEccCdFlg;
	}
	
	/**
	 * Column Info
	 * @return ldisTsFlg
	 */
	public String getLdisTsFlg() {
		return this.ldisTsFlg;
	}
	
	/**
	 * Column Info
	 * @return fmEccCdTmp1
	 */
	public String getFmEccCdTmp1() {
		return this.fmEccCdTmp1;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return plnYrwk
	 */
	public String getPlnYrwk() {
		return this.plnYrwk;
	}
	
	/**
	 * Column Info
	 * @return fixToEcc
	 */
	public String getFixToEcc() {
		return this.fixToEcc;
	}
	
	/**
	 * Column Info
	 * @return toEccCdTmp1
	 */
	public String getToEccCdTmp1() {
		return this.toEccCdTmp1;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return fmEccCd
	 */
	public String getFmEccCd() {
		return this.fmEccCd;
	}
	
	/**
	 * Column Info
	 * @return pastRepoPlnFlg
	 */
	public String getPastRepoPlnFlg() {
		return this.pastRepoPlnFlg;
	}
	
	/**
	 * Column Info
	 * @return fmEtdDt
	 */
	public String getFmEtdDt() {
		return this.fmEtdDt;
	}
	
	/**
	 * Column Info
	 * @return toEtbDt1
	 */
	public String getToEtbDt1() {
		return this.toEtbDt1;
	}
	

	/**
	 * Column Info
	 * @param fmEccCdTmp
	 */
	public void setFmEccCdTmp(String fmEccCdTmp) {
		this.fmEccCdTmp = fmEccCdTmp;
	}
	
	/**
	 * Column Info
	 * @param laneCd
	 */
	public void setLaneCd(String laneCd) {
		this.laneCd = laneCd;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param toEtbDt
	 */
	public void setToEtbDt(String toEtbDt) {
		this.toEtbDt = toEtbDt;
	}
	
	/**
	 * Column Info
	 * @param coCd
	 */
	public void setCoCd(String coCd) {
		this.coCd = coCd;
	}
	
	/**
	 * Column Info
	 * @param toEccCdFlg
	 */
	public void setToEccCdFlg(String toEccCdFlg) {
		this.toEccCdFlg = toEccCdFlg;
	}
	
	/**
	 * Column Info
	 * @param toEccCd
	 */
	public void setToEccCd(String toEccCd) {
		this.toEccCd = toEccCd;
	}
	
	/**
	 * Column Info
	 * @param fmEtdDt1
	 */
	public void setFmEtdDt1(String fmEtdDt1) {
		this.fmEtdDt1 = fmEtdDt1;
	}
	
	/**
	 * Column Info
	 * @param toEccCdTmp
	 */
	public void setToEccCdTmp(String toEccCdTmp) {
		this.toEccCdTmp = toEccCdTmp;
	}
	
	/**
	 * Column Info
	 * @param fmEccCdFlg
	 */
	public void setFmEccCdFlg(String fmEccCdFlg) {
		this.fmEccCdFlg = fmEccCdFlg;
	}
	
	/**
	 * Column Info
	 * @param ldisTsFlg
	 */
	public void setLdisTsFlg(String ldisTsFlg) {
		this.ldisTsFlg = ldisTsFlg;
	}
	
	/**
	 * Column Info
	 * @param fmEccCdTmp1
	 */
	public void setFmEccCdTmp1(String fmEccCdTmp1) {
		this.fmEccCdTmp1 = fmEccCdTmp1;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param plnYrwk
	 */
	public void setPlnYrwk(String plnYrwk) {
		this.plnYrwk = plnYrwk;
	}
	
	/**
	 * Column Info
	 * @param fixToEcc
	 */
	public void setFixToEcc(String fixToEcc) {
		this.fixToEcc = fixToEcc;
	}
	
	/**
	 * Column Info
	 * @param toEccCdTmp1
	 */
	public void setToEccCdTmp1(String toEccCdTmp1) {
		this.toEccCdTmp1 = toEccCdTmp1;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param fmEccCd
	 */
	public void setFmEccCd(String fmEccCd) {
		this.fmEccCd = fmEccCd;
	}
	
	/**
	 * Column Info
	 * @param pastRepoPlnFlg
	 */
	public void setPastRepoPlnFlg(String pastRepoPlnFlg) {
		this.pastRepoPlnFlg = pastRepoPlnFlg;
	}
	
	/**
	 * Column Info
	 * @param fmEtdDt
	 */
	public void setFmEtdDt(String fmEtdDt) {
		this.fmEtdDt = fmEtdDt;
	}
	
	/**
	 * Column Info
	 * @param toEtbDt1
	 */
	public void setToEtbDt1(String toEtbDt1) {
		this.toEtbDt1 = toEtbDt1;
	}
	
	
	/**
	 * @return the volList
	 */
	public List<String> getVolList() {
		return volList;
	}

	/**
	 * @param volList the volList to set
	 */
	public void setVolList(List<String> volList) {
		this.volList = volList;
	}

	/**
	 * @return the flagList
	 */
	public List<String> getFlagList() {
		return flagList;
	}

	/**
	 * @param flagList the flagList to set
	 */
	public void setFlagList(List<String> flagList) {
		this.flagList = flagList;
	}

	/**
	 * @return the fixList
	 */
	public List<String> getFixList() {
		return fixList;
	}

	/**
	 * @param fixList the fixList to set
	 */
	public void setFixList(List<String> fixList) {
		this.fixList = fixList;
	}
    
	/**
	 * @return the planSeq
	 */
	public String getPlanSeq() {
		return planSeq;
	}

	/**
	 * @param planSeq the planSeq to set
	 */
	public void setPlanSeq(String planSeq) {
		this.planSeq = planSeq;
	}

	
	/**
	 * @return the repoPlanId
	 */
	public String getRepoPlanId() {
		return repoPlanId;
	}

	/**
	 * @param repoPlanId the repoPlanId to set
	 */
	public void setRepoPlanId(String repoPlanId) {
		this.repoPlanId = repoPlanId;
	}

	
	/**
	 * @return the fmYard
	 */
	public String getFmYard() {
		return fmYard;
	}

	/**
	 * @param fmYard the fmYard to set
	 */
	public void setFmYard(String fmYard) {
		this.fmYard = fmYard;
	}

	/**
	 * @return the toYard
	 */
	public String getToYard() {
		return toYard;
	}

	/**
	 * @param toYard the toYard to set
	 */
	public void setToYard(String toYard) {
		this.toYard = toYard;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFmEccCdTmp(JSPUtil.getParameter(request, "fm_ecc_cd_tmp", ""));
		setLaneCd(JSPUtil.getParameter(request, "lane_cd", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setToEtbDt(JSPUtil.getParameter(request, "to_etb_dt", ""));
		setCoCd(JSPUtil.getParameter(request, "co_cd", ""));
		setToEccCdFlg(JSPUtil.getParameter(request, "to_ecc_cd_flg", ""));
		setToEccCd(JSPUtil.getParameter(request, "to_ecc_cd", ""));
		setFmEtdDt1(JSPUtil.getParameter(request, "fm_etd_dt1", ""));
		setToEccCdTmp(JSPUtil.getParameter(request, "to_ecc_cd_tmp", ""));
		setFmEccCdFlg(JSPUtil.getParameter(request, "fm_ecc_cd_flg", ""));
		setLdisTsFlg(JSPUtil.getParameter(request, "ldis_ts_flg", ""));
		setFmEccCdTmp1(JSPUtil.getParameter(request, "fm_ecc_cd_tmp1", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setPlnYrwk(JSPUtil.getParameter(request, "pln_yrwk", ""));
		setFixToEcc(JSPUtil.getParameter(request, "fix_to_ecc", ""));
		setToEccCdTmp1(JSPUtil.getParameter(request, "to_ecc_cd_tmp1", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFmEccCd(JSPUtil.getParameter(request, "fm_ecc_cd", ""));
		setPastRepoPlnFlg(JSPUtil.getParameter(request, "past_repo_pln_flg", ""));
		setFmEtdDt(JSPUtil.getParameter(request, "fm_etd_dt", ""));
		setToEtbDt1(JSPUtil.getParameter(request, "to_etb_dt1", ""));
		setFmYard(JSPUtil.getParameter(request, "fm_yard", ""));
		setToYard(JSPUtil.getParameter(request, "to_yard", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr0012MultiVO[]
	 */
	public EesEqr0012MultiVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr0012MultiVO[]
	 */
	public EesEqr0012MultiVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0012MultiVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			
			String tpsztype = (JSPUtil.getParameter(request, "tpszCurrent".trim(), "")); // tpsz value
	    	String[] tpszArr = tpsztype.split(","); 
	    	
	    	String[] repoPlnId = (JSPUtil.getParameter(request,  "repo_pln_id", length));
	    	String[] planSeq = (JSPUtil.getParameter(request, prefix	+ "pln_seq", length));
			String[] fmEccCdTmp = (JSPUtil.getParameter(request, prefix	+ "fm_ecc_cd_tmp", length));
			String[] laneCd = (JSPUtil.getParameter(request, prefix	+ "land_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] toEtbDt = (JSPUtil.getParameter(request, prefix	+ "to_etb_dt", length));
			String[] coCd = (JSPUtil.getParameter(request, prefix	+ "co_cd", length));
			String[] toEccCdFlg = (JSPUtil.getParameter(request, prefix	+ "to_ecc_cd_flg", length));
			String[] toEccCd = (JSPUtil.getParameter(request, prefix	+ "to_ecc_cd", length));
			String[] fmEtdDt1 = (JSPUtil.getParameter(request, prefix	+ "fm_etd_dt1", length));
			String[] toEccCdTmp = (JSPUtil.getParameter(request, prefix	+ "to_ecc_cd_tmp", length));
			String[] fmEccCdFlg = (JSPUtil.getParameter(request, prefix	+ "fm_ecc_cd_flg", length));
			String[] ldisTsFlg = (JSPUtil.getParameter(request, prefix	+ "ldis_ts_flg", length));
			String[] fmEccCdTmp1 = (JSPUtil.getParameter(request, prefix	+ "fm_ecc_cd_tmp1", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] plnYrwk = (JSPUtil.getParameter(request, prefix	+ "pln_yrwk", length));
			String[] fixToEcc = (JSPUtil.getParameter(request, prefix	+ "fix_to_ecc", length));
			String[] toEccCdTmp1 = (JSPUtil.getParameter(request, prefix	+ "to_ecc_cd_tmp1", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fmEccCd = (JSPUtil.getParameter(request, prefix	+ "fm_ecc_cd", length));
			String[] pastRepoPlnFlg = (JSPUtil.getParameter(request, prefix	+ "past_repo_pln_flg", length));
			String[] fmEtdDt = (JSPUtil.getParameter(request, prefix	+ "fm_etd_dt", length));
			String[] toEtbDt1 = (JSPUtil.getParameter(request, prefix	+ "to_etb_dt1", length));
			String[] fmYard = (JSPUtil.getParameter(request, prefix	+ "fm_yard", length));
			String[] toYard = (JSPUtil.getParameter(request, prefix	+ "to_yard", length));
			
			List<String[]> volListArr = new ArrayList<String[]>();
			List<String[]> flagListArr = new ArrayList<String[]>();
			List<String[]> fixListArr = new ArrayList<String[]>();
			
				for(int i=0; i<tpszArr.length; i++) {
					String[] volArr = (JSPUtil.getParameter(request, prefix	+ tpszArr[i].toLowerCase(), length));
					String[] flagArr = (JSPUtil.getParameter(request, prefix	+ tpszArr[i].toLowerCase()+"_flag".toLowerCase(), length));
					String[] fixArr = (JSPUtil.getParameter(request, prefix	+ "fix_"+tpszArr[i].toLowerCase(), length));
						
					volListArr.add(volArr);
					flagListArr.add(flagArr);
					fixListArr.add(fixArr);
				}
				
				for (int i = 0; i < length; i++) {
					model = new EesEqr0012MultiVO();
					
					List<String> volList = new ArrayList<String>();
					List<String> flagList = new ArrayList<String>();
					List<String> fixList = new ArrayList<String>();
				
					for(int t=0; t<tpszArr.length; t++) {
						String[] volArr  = (String[])volListArr.get(t);
						String[] flagArr = (String[])flagListArr.get(t);
						String[] fixArr = (String[])fixListArr.get(t);
						if(volArr[i] != null)
							volList.add(volArr[i]);
						if(flagArr[i] != null)
							flagList.add(flagArr[i]);
						if(fixArr[i] != null)
							fixList.add(fixArr[i]);
						
					}
					model.setVolList(volList);
					model.setFlagList(flagList);
					model.setFixList(fixList);
				if (repoPlnId[i] != null)
						model.setRepoPlanId(repoPlnId[i]);
				if (planSeq[i] != null)
						model.setPlanSeq(planSeq[i]);
				if (fmEccCdTmp[i] != null)
					model.setFmEccCdTmp(fmEccCdTmp[i]);
				if (laneCd[i] != null)
					model.setLaneCd(laneCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (toEtbDt[i] != null)
					model.setToEtbDt(toEtbDt[i]);
				if (coCd[i] != null)
					model.setCoCd(coCd[i]);
				if (toEccCdFlg[i] != null)
					model.setToEccCdFlg(toEccCdFlg[i]);
				if (toEccCd[i] != null)
					model.setToEccCd(toEccCd[i]);
				if (fmEtdDt1[i] != null)
					model.setFmEtdDt1(fmEtdDt1[i]);
				if (toEccCdTmp[i] != null)
					model.setToEccCdTmp(toEccCdTmp[i]);
				if (fmEccCdFlg[i] != null)
					model.setFmEccCdFlg(fmEccCdFlg[i]);
				if (ldisTsFlg[i] != null)
					model.setLdisTsFlg(ldisTsFlg[i]);
				if (fmEccCdTmp1[i] != null)
					model.setFmEccCdTmp1(fmEccCdTmp1[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (plnYrwk[i] != null)
					model.setPlnYrwk(plnYrwk[i]);
				if (fixToEcc[i] != null)
					model.setFixToEcc(fixToEcc[i]);
				if (toEccCdTmp1[i] != null)
					model.setToEccCdTmp1(toEccCdTmp1[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fmEccCd[i] != null)
					model.setFmEccCd(fmEccCd[i]);
				if (pastRepoPlnFlg[i] != null)
					model.setPastRepoPlnFlg(pastRepoPlnFlg[i]);
				if (fmEtdDt[i] != null)
					model.setFmEtdDt(fmEtdDt[i]);
				if (toEtbDt1[i] != null)
					model.setToEtbDt1(toEtbDt1[i]);
				if (fmYard[i] != null)
					model.setFmYard(fmYard[i]); 
				if (toYard[i] != null)
					model.setToYard(toYard[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr0012MultiVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr0012MultiVO[]
	 */
	public EesEqr0012MultiVO[] getEesEqr0012MultiVOs(){
		EesEqr0012MultiVO[] vos = (EesEqr0012MultiVO[])models.toArray(new EesEqr0012MultiVO[models.size()]);
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
		this.fmEccCdTmp = this.fmEccCdTmp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneCd = this.laneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEtbDt = this.toEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coCd = this.coCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEccCdFlg = this.toEccCdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEccCd = this.toEccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEtdDt1 = this.fmEtdDt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEccCdTmp = this.toEccCdTmp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEccCdFlg = this.fmEccCdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ldisTsFlg = this.ldisTsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEccCdTmp1 = this.fmEccCdTmp1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYrwk = this.plnYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fixToEcc = this.fixToEcc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEccCdTmp1 = this.toEccCdTmp1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEccCd = this.fmEccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pastRepoPlnFlg = this.pastRepoPlnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEtdDt = this.fmEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEtbDt1 = this.toEtbDt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
