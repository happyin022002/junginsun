/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CHSMvmtINVO.java
*@FileTitle : CHSMvmtINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.25
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2010.02.25 최민회 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최민회
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CHSMvmtINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CHSMvmtINVO> models = new ArrayList<CHSMvmtINVO>();
	
	/* Column Info */
	private String chssPoolCd = null;
	/* Column Info */
	private String location = null;
	/* Column Info */
	private String np = null;
	/* Column Info */
	private String endPage = null;
	/* Column Info */
	private String agmtLstmCd = null;
	/* Column Info */
	private String aciacDivCd = null;
	/* Column Info */
	private String strMvmtDt = null;
	/* Column Info */
	private String endMvmtDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String strPage = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String sccCd = null;
	/* Column Info */
	private String days = null;
	/* Column Info */
	private String iPage = null;
	/* Column Info */
	private String chssMvmtStsCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CHSMvmtINVO() {}

	public CHSMvmtINVO(String ibflag, String pagerows, String chssMvmtStsCd, String chssPoolCd, String location, String np, String endPage, String agmtLstmCd, String aciacDivCd, String strMvmtDt, String endMvmtDt, String strPage, String eqTpszCd, String sccCd, String eqNo, String days, String iPage) {
		this.chssPoolCd = chssPoolCd;
		this.location = location;
		this.np = np;
		this.endPage = endPage;
		this.agmtLstmCd = agmtLstmCd;
		this.aciacDivCd = aciacDivCd;
		this.strMvmtDt = strMvmtDt;
		this.endMvmtDt = endMvmtDt;
		this.pagerows = pagerows;
		this.strPage = strPage;
		this.eqTpszCd = eqTpszCd;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.sccCd = sccCd;
		this.days = days;
		this.iPage = iPage;
		this.chssMvmtStsCd = chssMvmtStsCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("chss_pool_cd", getChssPoolCd());
		this.hashColumns.put("location", getLocation());
		this.hashColumns.put("np", getNp());
		this.hashColumns.put("end_page", getEndPage());
		this.hashColumns.put("agmt_lstm_cd", getAgmtLstmCd());
		this.hashColumns.put("aciac_div_cd", getAciacDivCd());
		this.hashColumns.put("str_mvmt_dt", getStrMvmtDt());
		this.hashColumns.put("end_mvmt_dt", getEndMvmtDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("str_page", getStrPage());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("scc_cd", getSccCd());
		this.hashColumns.put("days", getDays());
		this.hashColumns.put("i_page", getIPage());
		this.hashColumns.put("chss_mvmt_sts_cd", getChssMvmtStsCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("chss_pool_cd", "chssPoolCd");
		this.hashFields.put("location", "location");
		this.hashFields.put("np", "np");
		this.hashFields.put("end_page", "endPage");
		this.hashFields.put("agmt_lstm_cd", "agmtLstmCd");
		this.hashFields.put("aciac_div_cd", "aciacDivCd");
		this.hashFields.put("str_mvmt_dt", "strMvmtDt");
		this.hashFields.put("end_mvmt_dt", "endMvmtDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("str_page", "strPage");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("scc_cd", "sccCd");
		this.hashFields.put("days", "days");
		this.hashFields.put("i_page", "iPage");
		this.hashFields.put("chss_mvmt_sts_cd", "chssMvmtStsCd");
		return this.hashFields;
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
	 * @return np
	 */
	public String getNp() {
		return this.np;
	}
	
	/**
	 * Column Info
	 * @return endPage
	 */
	public String getEndPage() {
		return this.endPage;
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
	 * @return strMvmtDt
	 */
	public String getStrMvmtDt() {
		return this.strMvmtDt;
	}
	
	/**
	 * Column Info
	 * @return endMvmtDt
	 */
	public String getEndMvmtDt() {
		return this.endMvmtDt;
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
	 * @return strPage
	 */
	public String getStrPage() {
		return this.strPage;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
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
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return sccCd
	 */
	public String getSccCd() {
		return this.sccCd;
	}
	
	/**
	 * Column Info
	 * @return days
	 */
	public String getDays() {
		return this.days;
	}
	
	/**
	 * Column Info
	 * @return iPage
	 */
	public String getIPage() {
		return this.iPage;
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
	 * @param np
	 */
	public void setNp(String np) {
		this.np = np;
	}
	
	/**
	 * Column Info
	 * @param endPage
	 */
	public void setEndPage(String endPage) {
		this.endPage = endPage;
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
	 * @param strMvmtDt
	 */
	public void setStrMvmtDt(String strMvmtDt) {
		this.strMvmtDt = strMvmtDt;
	}
	
	/**
	 * Column Info
	 * @param endMvmtDt
	 */
	public void setEndMvmtDt(String endMvmtDt) {
		this.endMvmtDt = endMvmtDt;
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
	 * @param strPage
	 */
	public void setStrPage(String strPage) {
		this.strPage = strPage;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
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
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param sccCd
	 */
	public void setSccCd(String sccCd) {
		this.sccCd = sccCd;
	}
	
	/**
	 * Column Info
	 * @param days
	 */
	public void setDays(String days) {
		this.days = days;
	}
	
	/**
	 * Column Info
	 * @param iPage
	 */
	public void setIPage(String iPage) {
		this.iPage = iPage;
	}
	
	/**
	 * Column Info
	 * @param chssMvmtStsCd
	 */
	public void setChssMvmtStsCd(String chssMvmtStsCd) {
		this.chssMvmtStsCd = chssMvmtStsCd;
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
		setChssPoolCd(JSPUtil.getParameter(request, prefix + "chss_pool_cd", ""));
		setLocation(JSPUtil.getParameter(request, prefix + "location", ""));
		setNp(JSPUtil.getParameter(request, prefix + "np", ""));
		setEndPage(JSPUtil.getParameter(request, prefix + "end_page", ""));
		setAgmtLstmCd(JSPUtil.getParameter(request, prefix + "agmt_lstm_cd", ""));
		setAciacDivCd(JSPUtil.getParameter(request, prefix + "aciac_div_cd", ""));
		setStrMvmtDt(JSPUtil.getParameter(request, prefix + "str_mvmt_dt", ""));
		setEndMvmtDt(JSPUtil.getParameter(request, prefix + "end_mvmt_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setStrPage(JSPUtil.getParameter(request, prefix + "str_page", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setSccCd(JSPUtil.getParameter(request, prefix + "scc_cd", ""));
		setDays(JSPUtil.getParameter(request, prefix + "days", ""));
		setIPage(JSPUtil.getParameter(request, prefix + "i_page", ""));
		setChssMvmtStsCd(JSPUtil.getParameter(request, prefix + "chss_mvmt_sts_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CHSMvmtINVO[]
	 */
	public CHSMvmtINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CHSMvmtINVO[]
	 */
	public CHSMvmtINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CHSMvmtINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] chssPoolCd = (JSPUtil.getParameter(request, prefix	+ "chss_pool_cd", length));
			String[] location = (JSPUtil.getParameter(request, prefix	+ "location", length));
			String[] np = (JSPUtil.getParameter(request, prefix	+ "np", length));
			String[] endPage = (JSPUtil.getParameter(request, prefix	+ "end_page", length));
			String[] agmtLstmCd = (JSPUtil.getParameter(request, prefix	+ "agmt_lstm_cd", length));
			String[] aciacDivCd = (JSPUtil.getParameter(request, prefix	+ "aciac_div_cd", length));
			String[] strMvmtDt = (JSPUtil.getParameter(request, prefix	+ "str_mvmt_dt", length));
			String[] endMvmtDt = (JSPUtil.getParameter(request, prefix	+ "end_mvmt_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] strPage = (JSPUtil.getParameter(request, prefix	+ "str_page", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] sccCd = (JSPUtil.getParameter(request, prefix	+ "scc_cd", length));
			String[] days = (JSPUtil.getParameter(request, prefix	+ "days", length));
			String[] iPage = (JSPUtil.getParameter(request, prefix	+ "i_page", length));
			String[] chssMvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "chss_mvmt_sts_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CHSMvmtINVO();
				if (chssPoolCd[i] != null)
					model.setChssPoolCd(chssPoolCd[i]);
				if (location[i] != null)
					model.setLocation(location[i]);
				if (np[i] != null)
					model.setNp(np[i]);
				if (endPage[i] != null)
					model.setEndPage(endPage[i]);
				if (agmtLstmCd[i] != null)
					model.setAgmtLstmCd(agmtLstmCd[i]);
				if (aciacDivCd[i] != null)
					model.setAciacDivCd(aciacDivCd[i]);
				if (strMvmtDt[i] != null)
					model.setStrMvmtDt(strMvmtDt[i]);
				if (endMvmtDt[i] != null)
					model.setEndMvmtDt(endMvmtDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (strPage[i] != null)
					model.setStrPage(strPage[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (sccCd[i] != null)
					model.setSccCd(sccCd[i]);
				if (days[i] != null)
					model.setDays(days[i]);
				if (iPage[i] != null)
					model.setIPage(iPage[i]);
				if (chssMvmtStsCd[i] != null)
					model.setChssMvmtStsCd(chssMvmtStsCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCHSMvmtINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CHSMvmtINVO[]
	 */
	public CHSMvmtINVO[] getCHSMvmtINVOs(){
		CHSMvmtINVO[] vos = (CHSMvmtINVO[])models.toArray(new CHSMvmtINVO[models.size()]);
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
		this.chssPoolCd = this.chssPoolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.location = this.location .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.np = this.np .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endPage = this.endPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtLstmCd = this.agmtLstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aciacDivCd = this.aciacDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.strMvmtDt = this.strMvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endMvmtDt = this.endMvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.strPage = this.strPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd = this.sccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.days = this.days .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iPage = this.iPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssMvmtStsCd = this.chssMvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
