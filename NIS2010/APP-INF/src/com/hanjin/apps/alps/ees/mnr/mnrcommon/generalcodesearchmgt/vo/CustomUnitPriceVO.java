/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustomUnitPriceVO.java
*@FileTitle : CustomUnitPriceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.29
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.10.29 박명신 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo;

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
 * @author 박명신
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomUnitPriceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomUnitPriceVO> models = new ArrayList<CustomUnitPriceVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String matchCnt = null;
	/* Column Info */
	private String matchType = null;
	/* Column Info */
	private String requestDt = null;
	/* Column Info */
	private String crntYdCd = null;
	/* Column Info */
	private String mnrDispTrfTot = null;
	/* Column Info */
	private String mnrDispTrfAvg = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomUnitPriceVO() {}

	public CustomUnitPriceVO(String ibflag, String pagerows, String currCd, String crntYdCd, String eqTpszCd, String requestDt, String matchType, String matchCnt, String mnrDispTrfTot, String mnrDispTrfAvg) {
		this.ibflag = ibflag;
		this.currCd = currCd;
		this.matchCnt = matchCnt;
		this.matchType = matchType;
		this.requestDt = requestDt;
		this.crntYdCd = crntYdCd;
		this.mnrDispTrfTot = mnrDispTrfTot;
		this.mnrDispTrfAvg = mnrDispTrfAvg;
		this.eqTpszCd = eqTpszCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("match_cnt", getMatchCnt());
		this.hashColumns.put("match_type", getMatchType());
		this.hashColumns.put("request_dt", getRequestDt());
		this.hashColumns.put("crnt_yd_cd", getCrntYdCd());
		this.hashColumns.put("mnr_disp_trf_tot", getMnrDispTrfTot());
		this.hashColumns.put("mnr_disp_trf_avg", getMnrDispTrfAvg());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("match_cnt", "matchCnt");
		this.hashFields.put("match_type", "matchType");
		this.hashFields.put("request_dt", "requestDt");
		this.hashFields.put("crnt_yd_cd", "crntYdCd");
		this.hashFields.put("mnr_disp_trf_tot", "mnrDispTrfTot");
		this.hashFields.put("mnr_disp_trf_avg", "mnrDispTrfAvg");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return matchCnt
	 */
	public String getMatchCnt() {
		return this.matchCnt;
	}
	
	/**
	 * Column Info
	 * @return matchType
	 */
	public String getMatchType() {
		return this.matchType;
	}
	
	/**
	 * Column Info
	 * @return requestDt
	 */
	public String getRequestDt() {
		return this.requestDt;
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
	 * @return mnrDispTrfTot
	 */
	public String getMnrDispTrfTot() {
		return this.mnrDispTrfTot;
	}
	
	/**
	 * Column Info
	 * @return mnrDispTrfAvg
	 */
	public String getMnrDispTrfAvg() {
		return this.mnrDispTrfAvg;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param matchCnt
	 */
	public void setMatchCnt(String matchCnt) {
		this.matchCnt = matchCnt;
	}
	
	/**
	 * Column Info
	 * @param matchType
	 */
	public void setMatchType(String matchType) {
		this.matchType = matchType;
	}
	
	/**
	 * Column Info
	 * @param requestDt
	 */
	public void setRequestDt(String requestDt) {
		this.requestDt = requestDt;
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
	 * @param mnrDispTrfTot
	 */
	public void setMnrDispTrfTot(String mnrDispTrfTot) {
		this.mnrDispTrfTot = mnrDispTrfTot;
	}
	
	/**
	 * Column Info
	 * @param mnrDispTrfAvg
	 */
	public void setMnrDispTrfAvg(String mnrDispTrfAvg) {
		this.mnrDispTrfAvg = mnrDispTrfAvg;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setMatchCnt(JSPUtil.getParameter(request, prefix + "match_cnt", ""));
		setMatchType(JSPUtil.getParameter(request, prefix + "match_type", ""));
		setRequestDt(JSPUtil.getParameter(request, prefix + "request_dt", ""));
		setCrntYdCd(JSPUtil.getParameter(request, prefix + "crnt_yd_cd", ""));
		setMnrDispTrfTot(JSPUtil.getParameter(request, prefix + "mnr_disp_trf_tot", ""));
		setMnrDispTrfAvg(JSPUtil.getParameter(request, prefix + "mnr_disp_trf_avg", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomUnitPriceVO[]
	 */
	public CustomUnitPriceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomUnitPriceVO[]
	 */
	public CustomUnitPriceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomUnitPriceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] matchCnt = (JSPUtil.getParameter(request, prefix	+ "match_cnt", length));
			String[] matchType = (JSPUtil.getParameter(request, prefix	+ "match_type", length));
			String[] requestDt = (JSPUtil.getParameter(request, prefix	+ "request_dt", length));
			String[] crntYdCd = (JSPUtil.getParameter(request, prefix	+ "crnt_yd_cd", length));
			String[] mnrDispTrfTot = (JSPUtil.getParameter(request, prefix	+ "mnr_disp_trf_tot", length));
			String[] mnrDispTrfAvg = (JSPUtil.getParameter(request, prefix	+ "mnr_disp_trf_avg", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomUnitPriceVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (matchCnt[i] != null)
					model.setMatchCnt(matchCnt[i]);
				if (matchType[i] != null)
					model.setMatchType(matchType[i]);
				if (requestDt[i] != null)
					model.setRequestDt(requestDt[i]);
				if (crntYdCd[i] != null)
					model.setCrntYdCd(crntYdCd[i]);
				if (mnrDispTrfTot[i] != null)
					model.setMnrDispTrfTot(mnrDispTrfTot[i]);
				if (mnrDispTrfAvg[i] != null)
					model.setMnrDispTrfAvg(mnrDispTrfAvg[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomUnitPriceVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomUnitPriceVO[]
	 */
	public CustomUnitPriceVO[] getCustomUnitPriceVOs(){
		CustomUnitPriceVO[] vos = (CustomUnitPriceVO[])models.toArray(new CustomUnitPriceVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.matchCnt = this.matchCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.matchType = this.matchType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.requestDt = this.requestDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntYdCd = this.crntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDispTrfTot = this.mnrDispTrfTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDispTrfAvg = this.mnrDispTrfAvg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
