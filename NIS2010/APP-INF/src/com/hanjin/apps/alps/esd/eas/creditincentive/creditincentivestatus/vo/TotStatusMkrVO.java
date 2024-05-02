/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TotStatusMkrVO.java
*@FileTitle : TotStatusMkrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.06
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.05.06 신동일 
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

public class TotStatusMkrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TotStatusMkrVO> models = new ArrayList<TotStatusMkrVO>();
	
	/* Column Info */
	private String crBalAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mkrCd = null;
	/* Column Info */
	private String crIssAmt = null;
	/* Column Info */
	private String mkrNm = null;
	/* Column Info */
	private String crUsdAmt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public TotStatusMkrVO() {}

	public TotStatusMkrVO(String ibflag, String pagerows, String mkrCd, String mkrNm, String crIssAmt, String crUsdAmt, String crBalAmt) {
		this.crBalAmt = crBalAmt;
		this.ibflag = ibflag;
		this.mkrCd = mkrCd;
		this.crIssAmt = crIssAmt;
		this.mkrNm = mkrNm;
		this.crUsdAmt = crUsdAmt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cr_bal_amt", getCrBalAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mkr_cd", getMkrCd());
		this.hashColumns.put("cr_iss_amt", getCrIssAmt());
		this.hashColumns.put("mkr_nm", getMkrNm());
		this.hashColumns.put("cr_usd_amt", getCrUsdAmt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cr_bal_amt", "crBalAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mkr_cd", "mkrCd");
		this.hashFields.put("cr_iss_amt", "crIssAmt");
		this.hashFields.put("mkr_nm", "mkrNm");
		this.hashFields.put("cr_usd_amt", "crUsdAmt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return crBalAmt
	 */
	public String getCrBalAmt() {
		return this.crBalAmt;
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
	 * @return mkrCd
	 */
	public String getMkrCd() {
		return this.mkrCd;
	}
	
	/**
	 * Column Info
	 * @return crIssAmt
	 */
	public String getCrIssAmt() {
		return this.crIssAmt;
	}
	
	/**
	 * Column Info
	 * @return mkrNm
	 */
	public String getMkrNm() {
		return this.mkrNm;
	}
	
	/**
	 * Column Info
	 * @return crUsdAmt
	 */
	public String getCrUsdAmt() {
		return this.crUsdAmt;
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
	 * @param crBalAmt
	 */
	public void setCrBalAmt(String crBalAmt) {
		this.crBalAmt = crBalAmt;
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
	 * @param mkrCd
	 */
	public void setMkrCd(String mkrCd) {
		this.mkrCd = mkrCd;
	}
	
	/**
	 * Column Info
	 * @param crIssAmt
	 */
	public void setCrIssAmt(String crIssAmt) {
		this.crIssAmt = crIssAmt;
	}
	
	/**
	 * Column Info
	 * @param mkrNm
	 */
	public void setMkrNm(String mkrNm) {
		this.mkrNm = mkrNm;
	}
	
	/**
	 * Column Info
	 * @param crUsdAmt
	 */
	public void setCrUsdAmt(String crUsdAmt) {
		this.crUsdAmt = crUsdAmt;
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
		setCrBalAmt(JSPUtil.getParameter(request, prefix + "cr_bal_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMkrCd(JSPUtil.getParameter(request, prefix + "mkr_cd", ""));
		setCrIssAmt(JSPUtil.getParameter(request, prefix + "cr_iss_amt", ""));
		setMkrNm(JSPUtil.getParameter(request, prefix + "mkr_nm", ""));
		setCrUsdAmt(JSPUtil.getParameter(request, prefix + "cr_usd_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TotStatusMkrVO[]
	 */
	public TotStatusMkrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TotStatusMkrVO[]
	 */
	public TotStatusMkrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TotStatusMkrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] crBalAmt = (JSPUtil.getParameter(request, prefix	+ "cr_bal_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mkrCd = (JSPUtil.getParameter(request, prefix	+ "mkr_cd", length));
			String[] crIssAmt = (JSPUtil.getParameter(request, prefix	+ "cr_iss_amt", length));
			String[] mkrNm = (JSPUtil.getParameter(request, prefix	+ "mkr_nm", length));
			String[] crUsdAmt = (JSPUtil.getParameter(request, prefix	+ "cr_usd_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new TotStatusMkrVO();
				if (crBalAmt[i] != null)
					model.setCrBalAmt(crBalAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mkrCd[i] != null)
					model.setMkrCd(mkrCd[i]);
				if (crIssAmt[i] != null)
					model.setCrIssAmt(crIssAmt[i]);
				if (mkrNm[i] != null)
					model.setMkrNm(mkrNm[i]);
				if (crUsdAmt[i] != null)
					model.setCrUsdAmt(crUsdAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTotStatusMkrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TotStatusMkrVO[]
	 */
	public TotStatusMkrVO[] getTotStatusMkrVOs(){
		TotStatusMkrVO[] vos = (TotStatusMkrVO[])models.toArray(new TotStatusMkrVO[models.size()]);
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
		this.crBalAmt = this.crBalAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mkrCd = this.mkrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crIssAmt = this.crIssAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mkrNm = this.mkrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crUsdAmt = this.crUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
