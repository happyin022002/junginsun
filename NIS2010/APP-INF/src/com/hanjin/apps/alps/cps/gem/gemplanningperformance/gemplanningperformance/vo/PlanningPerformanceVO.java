/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PlanningPerformanceVO.java
*@FileTitle : PlanningPerformanceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 박창준
*@LastVersion : 1.0
* 2009.06.10 박창준 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo;

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
 * @author 박창준
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PlanningPerformanceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PlanningPerformanceVO> models = new ArrayList<PlanningPerformanceVO>();
	
	/* Column Info */
	private String ratio1 = null;
	/* Column Info */
	private String diff = null;
	/* Column Info */
	private String yearAssExp = null;
	/* Column Info */
	private String abbrNm = null;
	/* Column Info */
	private String loclCurrCd = null;
	/* Column Info */
	private String ytdAssExp = null;
	/* Column Info */
	private String genExpnCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String genExpnOvrRtoRsn = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ratio = null;
	/* Column Info */
	private String ytdPerf = null;
	/* Column Info */
	private String rqstUtVal = null;
	/* Column Info */
	private String monAssExp = null;
	/* Column Info */
	private String monPerf = null;
	/* Column Info */
	private String rsltYrmon = null;
	/* Column Info */
	private String chaPer = null;
	/* Column Info */
	private String chaPer1 = null;
	/* Column Info */
	private String ofcCoDivCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PlanningPerformanceVO() {}

	public PlanningPerformanceVO(String ibflag, String pagerows, String ofcCd, String genExpnCd, String loclCurrCd, String rqstUtVal, String yearAssExp, String monAssExp, String monPerf, String ratio, String ytdAssExp, String ytdPerf, String ratio1, String diff, String genExpnOvrRtoRsn, String abbrNm, String rsltYrmon, String chaPer, String chaPer1, String ofcCoDivCd) {
		this.ratio1 = ratio1;
		this.diff = diff;
		this.yearAssExp = yearAssExp;
		this.abbrNm = abbrNm;
		this.loclCurrCd = loclCurrCd;
		this.ytdAssExp = ytdAssExp;
		this.genExpnCd = genExpnCd;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.genExpnOvrRtoRsn = genExpnOvrRtoRsn;
		this.ibflag = ibflag;
		this.ratio = ratio;
		this.ytdPerf = ytdPerf;
		this.rqstUtVal = rqstUtVal;
		this.monAssExp = monAssExp;
		this.monPerf = monPerf;
		this.rsltYrmon = rsltYrmon;
		this.chaPer = chaPer;
		this.chaPer1 = chaPer1;
		this.ofcCoDivCd = ofcCoDivCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ratio1", getRatio1());
		this.hashColumns.put("diff", getDiff());
		this.hashColumns.put("year_ass_exp", getYearAssExp());
		this.hashColumns.put("abbr_nm", getAbbrNm());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("ytd_ass_exp", getYtdAssExp());
		this.hashColumns.put("gen_expn_cd", getGenExpnCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("gen_expn_ovr_rto_rsn", getGenExpnOvrRtoRsn());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ratio", getRatio());
		this.hashColumns.put("ytd_perf", getYtdPerf());
		this.hashColumns.put("rqst_ut_val", getRqstUtVal());
		this.hashColumns.put("mon_ass_exp", getMonAssExp());
		this.hashColumns.put("mon_perf", getMonPerf());
		this.hashColumns.put("rslt_yrmon", getRsltYrmon());
		this.hashColumns.put("cha_per", getChaPer());
		this.hashColumns.put("cha_per1", getChaPer1());
		this.hashColumns.put("ofc_co_div_cd", getOfcCoDivCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ratio1", "ratio1");
		this.hashFields.put("diff", "diff");
		this.hashFields.put("year_ass_exp", "yearAssExp");
		this.hashFields.put("abbr_nm", "abbrNm");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("ytd_ass_exp", "ytdAssExp");
		this.hashFields.put("gen_expn_cd", "genExpnCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("gen_expn_ovr_rto_rsn", "genExpnOvrRtoRsn");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ratio", "ratio");
		this.hashFields.put("ytd_perf", "ytdPerf");
		this.hashFields.put("rqst_ut_val", "rqstUtVal");
		this.hashFields.put("mon_ass_exp", "monAssExp");
		this.hashFields.put("mon_perf", "monPerf");
		this.hashFields.put("rslt_yrmon", "rsltYrmon");
		this.hashFields.put("cha_per", "chaPer");
		this.hashFields.put("cha_per1", "chaPer1");
		this.hashFields.put("ofc_co_div_cd", "ofcCoDivCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ratio1
	 */
	public String getRatio1() {
		return this.ratio1;
	}
	
	/**
	 * Column Info
	 * @return diff
	 */
	public String getDiff() {
		return this.diff;
	}
	
	/**
	 * Column Info
	 * @return yearAssExp
	 */
	public String getYearAssExp() {
		return this.yearAssExp;
	}
	
	/**
	 * Column Info
	 * @return abbrNm
	 */
	public String getAbbrNm() {
		return this.abbrNm;
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
	 * @return ytdAssExp
	 */
	public String getYtdAssExp() {
		return this.ytdAssExp;
	}
	
	/**
	 * Column Info
	 * @return genExpnCd
	 */
	public String getGenExpnCd() {
		return this.genExpnCd;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return genExpnOvrRtoRsn
	 */
	public String getGenExpnOvrRtoRsn() {
		return this.genExpnOvrRtoRsn;
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
	 * @return ratio
	 */
	public String getRatio() {
		return this.ratio;
	}
	
	/**
	 * Column Info
	 * @return ytdPerf
	 */
	public String getYtdPerf() {
		return this.ytdPerf;
	}
	
	/**
	 * Column Info
	 * @return rqstUtVal
	 */
	public String getRqstUtVal() {
		return this.rqstUtVal;
	}
	
	/**
	 * Column Info
	 * @return monAssExp
	 */
	public String getMonAssExp() {
		return this.monAssExp;
	}
	
	/**
	 * Column Info
	 * @return monPerf
	 */
	public String getMonPerf() {
		return this.monPerf;
	}
	
	/**
	 * Column Info
	 * @return rsltYrmon
	 */
	public String getRsltYrmon() {
		return this.rsltYrmon;
	}
	
	/**
	 * Column Info
	 * @return chaPer
	 */
	public String getChaPer() {
		return this.chaPer;
	}
	
	/**
	 * Column Info
	 * @return chaPer1
	 */
	public String getChaPer1() {
		return this.chaPer1;
	}
	
	/**
	 * Column Info
	 * @return ofcCoDivCd
	 */
	public String getOfcCoDivCd() {
		return this.ofcCoDivCd;
	}
	

	/**
	 * Column Info
	 * @param ratio1
	 */
	public void setRatio1(String ratio1) {
		this.ratio1 = ratio1;
	}
	
	/**
	 * Column Info
	 * @param diff
	 */
	public void setDiff(String diff) {
		this.diff = diff;
	}
	
	/**
	 * Column Info
	 * @param yearAssExp
	 */
	public void setYearAssExp(String yearAssExp) {
		this.yearAssExp = yearAssExp;
	}
	
	/**
	 * Column Info
	 * @param abbrNm
	 */
	public void setAbbrNm(String abbrNm) {
		this.abbrNm = abbrNm;
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
	 * @param ytdAssExp
	 */
	public void setYtdAssExp(String ytdAssExp) {
		this.ytdAssExp = ytdAssExp;
	}
	
	/**
	 * Column Info
	 * @param genExpnCd
	 */
	public void setGenExpnCd(String genExpnCd) {
		this.genExpnCd = genExpnCd;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param genExpnOvrRtoRsn
	 */
	public void setGenExpnOvrRtoRsn(String genExpnOvrRtoRsn) {
		this.genExpnOvrRtoRsn = genExpnOvrRtoRsn;
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
	 * @param ratio
	 */
	public void setRatio(String ratio) {
		this.ratio = ratio;
	}
	
	/**
	 * Column Info
	 * @param ytdPerf
	 */
	public void setYtdPerf(String ytdPerf) {
		this.ytdPerf = ytdPerf;
	}
	
	/**
	 * Column Info
	 * @param rqstUtVal
	 */
	public void setRqstUtVal(String rqstUtVal) {
		this.rqstUtVal = rqstUtVal;
	}
	
	/**
	 * Column Info
	 * @param monAssExp
	 */
	public void setMonAssExp(String monAssExp) {
		this.monAssExp = monAssExp;
	}
	
	/**
	 * Column Info
	 * @param monPerf
	 */
	public void setMonPerf(String monPerf) {
		this.monPerf = monPerf;
	}
	
	/**
	 * Column Info
	 * @param rsltYrmon
	 */
	public void setRsltYrmon(String rsltYrmon) {
		this.rsltYrmon = rsltYrmon;
	}
	
	/**
	 * Column Info
	 * @param chaPer
	 */
	public void setChaPer(String chaPer) {
		this.chaPer = chaPer;
	}
	
	/**
	 * Column Info
	 * @param chaPer1
	 */
	public void setChaPer1(String chaPer1) {
		this.chaPer1 = chaPer1;
	}
	
	/**
	 * Column Info
	 * @param ofcCoDivCd
	 */
	public void setOfcCoDivCd(String ofcCoDivCd) {
		this.ofcCoDivCd = ofcCoDivCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRatio1(JSPUtil.getParameter(request, "ratio1", ""));
		setDiff(JSPUtil.getParameter(request, "diff", ""));
		setYearAssExp(JSPUtil.getParameter(request, "year_ass_exp", ""));
		setAbbrNm(JSPUtil.getParameter(request, "abbr_nm", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, "locl_curr_cd", ""));
		setYtdAssExp(JSPUtil.getParameter(request, "ytd_ass_exp", ""));
		setGenExpnCd(JSPUtil.getParameter(request, "gen_expn_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setGenExpnOvrRtoRsn(JSPUtil.getParameter(request, "gen_expn_ovr_rto_rsn", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRatio(JSPUtil.getParameter(request, "ratio", ""));
		setYtdPerf(JSPUtil.getParameter(request, "ytd_perf", ""));
		setRqstUtVal(JSPUtil.getParameter(request, "rqst_ut_val", ""));
		setMonAssExp(JSPUtil.getParameter(request, "mon_ass_exp", ""));
		setMonPerf(JSPUtil.getParameter(request, "mon_perf", ""));
		setRsltYrmon(JSPUtil.getParameter(request, "rslt_yrmon", ""));
		setChaPer(JSPUtil.getParameter(request, "cha_per", ""));
		setChaPer1(JSPUtil.getParameter(request, "cha_per1", ""));
		setOfcCoDivCd(JSPUtil.getParameter(request, "ofc_co_div_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PlanningPerformanceVO[]
	 */
	public PlanningPerformanceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PlanningPerformanceVO[]
	 */
	public PlanningPerformanceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PlanningPerformanceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ratio1 = (JSPUtil.getParameter(request, prefix	+ "ratio1", length));
			String[] diff = (JSPUtil.getParameter(request, prefix	+ "diff", length));
			String[] yearAssExp = (JSPUtil.getParameter(request, prefix	+ "year_ass_exp", length));
			String[] abbrNm = (JSPUtil.getParameter(request, prefix	+ "abbr_nm", length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd", length));
			String[] ytdAssExp = (JSPUtil.getParameter(request, prefix	+ "ytd_ass_exp", length));
			String[] genExpnCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] genExpnOvrRtoRsn = (JSPUtil.getParameter(request, prefix	+ "gen_expn_ovr_rto_rsn", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ratio = (JSPUtil.getParameter(request, prefix	+ "ratio", length));
			String[] ytdPerf = (JSPUtil.getParameter(request, prefix	+ "ytd_perf", length));
			String[] rqstUtVal = (JSPUtil.getParameter(request, prefix	+ "rqst_ut_val", length));
			String[] monAssExp = (JSPUtil.getParameter(request, prefix	+ "mon_ass_exp", length));
			String[] monPerf = (JSPUtil.getParameter(request, prefix	+ "mon_perf", length));
			String[] rsltYrmon = (JSPUtil.getParameter(request, prefix	+ "rslt_yrmon", length));
			String[] chaPer = (JSPUtil.getParameter(request, prefix	+ "cha_per", length));
			String[] chaPer1 = (JSPUtil.getParameter(request, prefix	+ "cha_per1", length));
			String[] ofcCoDivCd = (JSPUtil.getParameter(request, prefix	+ "ofc_co_div_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new PlanningPerformanceVO();
				if (ratio1[i] != null)
					model.setRatio1(ratio1[i]);
				if (diff[i] != null)
					model.setDiff(diff[i]);
				if (yearAssExp[i] != null)
					model.setYearAssExp(yearAssExp[i]);
				if (abbrNm[i] != null)
					model.setAbbrNm(abbrNm[i]);
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (ytdAssExp[i] != null)
					model.setYtdAssExp(ytdAssExp[i]);
				if (genExpnCd[i] != null)
					model.setGenExpnCd(genExpnCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (genExpnOvrRtoRsn[i] != null)
					model.setGenExpnOvrRtoRsn(genExpnOvrRtoRsn[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ratio[i] != null)
					model.setRatio(ratio[i]);
				if (ytdPerf[i] != null)
					model.setYtdPerf(ytdPerf[i]);
				if (rqstUtVal[i] != null)
					model.setRqstUtVal(rqstUtVal[i]);
				if (monAssExp[i] != null)
					model.setMonAssExp(monAssExp[i]);
				if (monPerf[i] != null)
					model.setMonPerf(monPerf[i]);
				if (rsltYrmon[i] != null)
					model.setRsltYrmon(rsltYrmon[i]);
				if (chaPer[i] != null)
					model.setChaPer(chaPer[i]);
				if (chaPer1[i] != null)
					model.setChaPer1(chaPer1[i]);
				if (ofcCoDivCd[i] != null)
					model.setOfcCoDivCd(ofcCoDivCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPlanningPerformanceVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PlanningPerformanceVO[]
	 */
	public PlanningPerformanceVO[] getPlanningPerformanceVOs(){
		PlanningPerformanceVO[] vos = (PlanningPerformanceVO[])models.toArray(new PlanningPerformanceVO[models.size()]);
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
		this.ratio1 = this.ratio1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diff = this.diff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yearAssExp = this.yearAssExp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.abbrNm = this.abbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ytdAssExp = this.ytdAssExp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnCd = this.genExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnOvrRtoRsn = this.genExpnOvrRtoRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratio = this.ratio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ytdPerf = this.ytdPerf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUtVal = this.rqstUtVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.monAssExp = this.monAssExp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.monPerf = this.monPerf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsltYrmon = this.rsltYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chaPer = this.chaPer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chaPer1 = this.chaPer1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCoDivCd = this.ofcCoDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
