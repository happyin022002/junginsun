/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltPRSCMDataVO.java
*@FileTitle : RsltPRSCMDataVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.26
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.11.26 공백진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo;

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
 * @author 공백진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltPRSCMDataVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPRSCMDataVO> models = new ArrayList<RsltPRSCMDataVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String prsEstmCmAmt = null;
	/* Column Info */
	private String prsCrntCmAmt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPRSCMDataVO() {}

	public RsltPRSCMDataVO(String ibflag, String pagerows, String prsCrntCmAmt, String prsEstmCmAmt) {
		this.ibflag = ibflag;
		this.prsEstmCmAmt = prsEstmCmAmt;
		this.prsCrntCmAmt = prsCrntCmAmt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("prs_estm_cm_amt", getPrsEstmCmAmt());
		this.hashColumns.put("prs_crnt_cm_amt", getPrsCrntCmAmt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("prs_estm_cm_amt", "prsEstmCmAmt");
		this.hashFields.put("prs_crnt_cm_amt", "prsCrntCmAmt");
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
	 * @return prsEstmCmAmt
	 */
	public String getPrsEstmCmAmt() {
		return this.prsEstmCmAmt;
	}
	
	/**
	 * Column Info
	 * @return prsCrntCmAmt
	 */
	public String getPrsCrntCmAmt() {
		return this.prsCrntCmAmt;
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
	 * @param prsEstmCmAmt
	 */
	public void setPrsEstmCmAmt(String prsEstmCmAmt) {
		this.prsEstmCmAmt = prsEstmCmAmt;
	}
	
	/**
	 * Column Info
	 * @param prsCrntCmAmt
	 */
	public void setPrsCrntCmAmt(String prsCrntCmAmt) {
		this.prsCrntCmAmt = prsCrntCmAmt;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPrsEstmCmAmt(JSPUtil.getParameter(request, "prs_estm_cm_amt", ""));
		setPrsCrntCmAmt(JSPUtil.getParameter(request, "prs_crnt_cm_amt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPRSCMDataVO[]
	 */
	public RsltPRSCMDataVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPRSCMDataVO[]
	 */
	public RsltPRSCMDataVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPRSCMDataVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] prsEstmCmAmt = (JSPUtil.getParameter(request, prefix	+ "prs_estm_cm_amt", length));
			String[] prsCrntCmAmt = (JSPUtil.getParameter(request, prefix	+ "prs_crnt_cm_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPRSCMDataVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (prsEstmCmAmt[i] != null)
					model.setPrsEstmCmAmt(prsEstmCmAmt[i]);
				if (prsCrntCmAmt[i] != null)
					model.setPrsCrntCmAmt(prsCrntCmAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPRSCMDataVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPRSCMDataVO[]
	 */
	public RsltPRSCMDataVO[] getRsltPRSCMDataVOs(){
		RsltPRSCMDataVO[] vos = (RsltPRSCMDataVO[])models.toArray(new RsltPRSCMDataVO[models.size()]);
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
		this.prsEstmCmAmt = this.prsEstmCmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsCrntCmAmt = this.prsCrntCmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
