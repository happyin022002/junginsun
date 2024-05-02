/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CreditSmmrIssueVO.java
*@FileTitle : CreditSmmrIssueVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.10
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.06.10 신동일 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivesummary.vo;

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

public class CreditSmmrIssueVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CreditSmmrIssueVO> models = new ArrayList<CreditSmmrIssueVO>();
	
	/* Column Info */
	private String vndrNm = null;
	/* Column Info */
	private String balAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String issAmt = null;
	/* Column Info */
	private String crSrc = null;
	/* Column Info */
	private String teamCd = null;
	/* Column Info */
	private String bseYr = null;
	/* Column Info */
	private String usedAmt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CreditSmmrIssueVO() {}

	public CreditSmmrIssueVO(String ibflag, String pagerows, String bseYr, String balAmt, String vndrNm, String issAmt, String vndrSeq, String crSrc, String teamCd, String usedAmt) {
		this.vndrNm = vndrNm;
		this.balAmt = balAmt;
		this.ibflag = ibflag;
		this.vndrSeq = vndrSeq;
		this.issAmt = issAmt;
		this.crSrc = crSrc;
		this.teamCd = teamCd;
		this.bseYr = bseYr;
		this.usedAmt = usedAmt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("bal_amt", getBalAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("iss_amt", getIssAmt());
		this.hashColumns.put("cr_src", getCrSrc());
		this.hashColumns.put("team_cd", getTeamCd());
		this.hashColumns.put("bse_yr", getBseYr());
		this.hashColumns.put("used_amt", getUsedAmt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("bal_amt", "balAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("iss_amt", "issAmt");
		this.hashFields.put("cr_src", "crSrc");
		this.hashFields.put("team_cd", "teamCd");
		this.hashFields.put("bse_yr", "bseYr");
		this.hashFields.put("used_amt", "usedAmt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return balAmt
	 */
	public String getBalAmt() {
		return this.balAmt;
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return issAmt
	 */
	public String getIssAmt() {
		return this.issAmt;
	}
	
	/**
	 * Column Info
	 * @return crSrc
	 */
	public String getCrSrc() {
		return this.crSrc;
	}
	
	/**
	 * Column Info
	 * @return teamCd
	 */
	public String getTeamCd() {
		return this.teamCd;
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
	 * @return usedAmt
	 */
	public String getUsedAmt() {
		return this.usedAmt;
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
	 * @param vndrNm
	 */
	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
	}
	
	/**
	 * Column Info
	 * @param balAmt
	 */
	public void setBalAmt(String balAmt) {
		this.balAmt = balAmt;
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
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param issAmt
	 */
	public void setIssAmt(String issAmt) {
		this.issAmt = issAmt;
	}
	
	/**
	 * Column Info
	 * @param crSrc
	 */
	public void setCrSrc(String crSrc) {
		this.crSrc = crSrc;
	}
	
	/**
	 * Column Info
	 * @param teamCd
	 */
	public void setTeamCd(String teamCd) {
		this.teamCd = teamCd;
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
	 * @param usedAmt
	 */
	public void setUsedAmt(String usedAmt) {
		this.usedAmt = usedAmt;
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
		setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
		setBalAmt(JSPUtil.getParameter(request, prefix + "bal_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setIssAmt(JSPUtil.getParameter(request, prefix + "iss_amt", ""));
		setCrSrc(JSPUtil.getParameter(request, prefix + "cr_src", ""));
		setTeamCd(JSPUtil.getParameter(request, prefix + "team_cd", ""));
		setBseYr(JSPUtil.getParameter(request, prefix + "bse_yr", ""));
		setUsedAmt(JSPUtil.getParameter(request, prefix + "used_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CreditSmmrIssueVO[]
	 */
	public CreditSmmrIssueVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CreditSmmrIssueVO[]
	 */
	public CreditSmmrIssueVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CreditSmmrIssueVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] balAmt = (JSPUtil.getParameter(request, prefix	+ "bal_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] issAmt = (JSPUtil.getParameter(request, prefix	+ "iss_amt", length));
			String[] crSrc = (JSPUtil.getParameter(request, prefix	+ "cr_src", length));
			String[] teamCd = (JSPUtil.getParameter(request, prefix	+ "team_cd", length));
			String[] bseYr = (JSPUtil.getParameter(request, prefix	+ "bse_yr", length));
			String[] usedAmt = (JSPUtil.getParameter(request, prefix	+ "used_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CreditSmmrIssueVO();
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (balAmt[i] != null)
					model.setBalAmt(balAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (issAmt[i] != null)
					model.setIssAmt(issAmt[i]);
				if (crSrc[i] != null)
					model.setCrSrc(crSrc[i]);
				if (teamCd[i] != null)
					model.setTeamCd(teamCd[i]);
				if (bseYr[i] != null)
					model.setBseYr(bseYr[i]);
				if (usedAmt[i] != null)
					model.setUsedAmt(usedAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCreditSmmrIssueVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CreditSmmrIssueVO[]
	 */
	public CreditSmmrIssueVO[] getCreditSmmrIssueVOs(){
		CreditSmmrIssueVO[] vos = (CreditSmmrIssueVO[])models.toArray(new CreditSmmrIssueVO[models.size()]);
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
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.balAmt = this.balAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issAmt = this.issAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crSrc = this.crSrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teamCd = this.teamCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYr = this.bseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usedAmt = this.usedAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
