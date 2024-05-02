/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PerformanceInfoVO.java
*@FileTitle : PerformanceInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier : 박창준
*@LastVersion : 1.0
* 2009.07.01 박창준 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박창준
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PerformanceInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PerformanceInfoVO> models = new ArrayList<PerformanceInfoVO>();
	
	/* Column Info */
	private String yearAssExp = null;
	/* Column Info */
	private String loclCurrCd = null;
	/* Column Info */
	private String ytdAssExp = null;
	/* Column Info */
	private String genExpnCd = null;
	/* Column Info */
	private String fmTo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String adAmt = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ytdPerf = null;
	/* Column Info */
	private String yearRate = null;
	/* Column Info */
	private String rqstUtVal = null;
	/* Column Info */
	private String ytdRate = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PerformanceInfoVO() {}

	public PerformanceInfoVO(String ibflag, String pagerows, String fmTo, String ofcCd, String genExpnCd, String loclCurrCd, String rqstUtVal, String yearRate, String ytdRate, String yearAssExp, String ytdAssExp, String ytdPerf, String adAmt) {
		this.yearAssExp = yearAssExp;
		this.loclCurrCd = loclCurrCd;
		this.ytdAssExp = ytdAssExp;
		this.genExpnCd = genExpnCd;
		this.fmTo = fmTo;
		this.pagerows = pagerows;
		this.adAmt = adAmt;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.ytdPerf = ytdPerf;
		this.yearRate = yearRate;
		this.rqstUtVal = rqstUtVal;
		this.ytdRate = ytdRate;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("year_ass_exp", getYearAssExp());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("ytd_ass_exp", getYtdAssExp());
		this.hashColumns.put("gen_expn_cd", getGenExpnCd());
		this.hashColumns.put("fm_to", getFmTo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ad_amt", getAdAmt());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ytd_perf", getYtdPerf());
		this.hashColumns.put("year_rate", getYearRate());
		this.hashColumns.put("rqst_ut_val", getRqstUtVal());
		this.hashColumns.put("ytd_rate", getYtdRate());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("year_ass_exp", "yearAssExp");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("ytd_ass_exp", "ytdAssExp");
		this.hashFields.put("gen_expn_cd", "genExpnCd");
		this.hashFields.put("fm_to", "fmTo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ad_amt", "adAmt");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ytd_perf", "ytdPerf");
		this.hashFields.put("year_rate", "yearRate");
		this.hashFields.put("rqst_ut_val", "rqstUtVal");
		this.hashFields.put("ytd_rate", "ytdRate");
		return this.hashFields;
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
	 * Column Info
	 * @return fmTo
	 */
	public String getFmTo() {
		return this.fmTo;
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
	 * @return adAmt
	 */
	public String getAdAmt() {
		return this.adAmt;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return ytdPerf
	 */
	public String getYtdPerf() {
		return this.ytdPerf;
	}
	
	/**
	 * Column Info
	 * @return yearRate
	 */
	public String getYearRate() {
		return this.yearRate;
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
	 * @return ytdRate
	 */
	public String getYtdRate() {
		return this.ytdRate;
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
	 * Column Info
	 * @param fmTo
	 */
	public void setFmTo(String fmTo) {
		this.fmTo = fmTo;
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
	 * @param adAmt
	 */
	public void setAdAmt(String adAmt) {
		this.adAmt = adAmt;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param ytdPerf
	 */
	public void setYtdPerf(String ytdPerf) {
		this.ytdPerf = ytdPerf;
	}
	
	/**
	 * Column Info
	 * @param yearRate
	 */
	public void setYearRate(String yearRate) {
		this.yearRate = yearRate;
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
	 * @param ytdRate
	 */
	public void setYtdRate(String ytdRate) {
		this.ytdRate = ytdRate;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setYearAssExp(JSPUtil.getParameter(request, "year_ass_exp", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, "locl_curr_cd", ""));
		setYtdAssExp(JSPUtil.getParameter(request, "ytd_ass_exp", ""));
		setGenExpnCd(JSPUtil.getParameter(request, "gen_expn_cd", ""));
		setFmTo(JSPUtil.getParameter(request, "fm_to", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setAdAmt(JSPUtil.getParameter(request, "ad_amt", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setYtdPerf(JSPUtil.getParameter(request, "ytd_perf", ""));
		setYearRate(JSPUtil.getParameter(request, "year_rate", ""));
		setRqstUtVal(JSPUtil.getParameter(request, "rqst_ut_val", ""));
		setYtdRate(JSPUtil.getParameter(request, "ytd_rate", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PerformanceInfoVO[]
	 */
	public PerformanceInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PerformanceInfoVO[]
	 */
	public PerformanceInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PerformanceInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] yearAssExp = (JSPUtil.getParameter(request, prefix	+ "year_ass_exp", length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd", length));
			String[] ytdAssExp = (JSPUtil.getParameter(request, prefix	+ "ytd_ass_exp", length));
			String[] genExpnCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_cd", length));
			String[] fmTo = (JSPUtil.getParameter(request, prefix	+ "fm_to", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] adAmt = (JSPUtil.getParameter(request, prefix	+ "ad_amt", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ytdPerf = (JSPUtil.getParameter(request, prefix	+ "ytd_perf", length));
			String[] yearRate = (JSPUtil.getParameter(request, prefix	+ "year_rate", length));
			String[] rqstUtVal = (JSPUtil.getParameter(request, prefix	+ "rqst_ut_val", length));
			String[] ytdRate = (JSPUtil.getParameter(request, prefix	+ "ytd_rate", length));
			
			for (int i = 0; i < length; i++) {
				model = new PerformanceInfoVO();
				if (yearAssExp[i] != null)
					model.setYearAssExp(yearAssExp[i]);
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (ytdAssExp[i] != null)
					model.setYtdAssExp(ytdAssExp[i]);
				if (genExpnCd[i] != null)
					model.setGenExpnCd(genExpnCd[i]);
				if (fmTo[i] != null)
					model.setFmTo(fmTo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (adAmt[i] != null)
					model.setAdAmt(adAmt[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ytdPerf[i] != null)
					model.setYtdPerf(ytdPerf[i]);
				if (yearRate[i] != null)
					model.setYearRate(yearRate[i]);
				if (rqstUtVal[i] != null)
					model.setRqstUtVal(rqstUtVal[i]);
				if (ytdRate[i] != null)
					model.setYtdRate(ytdRate[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPerformanceInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PerformanceInfoVO[]
	 */
	public PerformanceInfoVO[] getPerformanceInfoVOs(){
		PerformanceInfoVO[] vos = (PerformanceInfoVO[])models.toArray(new PerformanceInfoVO[models.size()]);
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
		this.yearAssExp = this.yearAssExp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ytdAssExp = this.ytdAssExp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnCd = this.genExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmTo = this.fmTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adAmt = this.adAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ytdPerf = this.ytdPerf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yearRate = this.yearRate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUtVal = this.rqstUtVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ytdRate = this.ytdRate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
