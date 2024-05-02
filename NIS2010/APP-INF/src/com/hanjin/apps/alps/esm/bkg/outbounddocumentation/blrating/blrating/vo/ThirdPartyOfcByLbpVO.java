/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ThirdPartyOfcByLbpVO.java
*@FileTitle : ThirdPartyOfcByLbpVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.26
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2012.01.26 조원주 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo;

import java.lang.reflect.Field;
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
 * @author 조원주
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ThirdPartyOfcByLbpVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ThirdPartyOfcByLbpVO> models = new ArrayList<ThirdPartyOfcByLbpVO>();
	
	/* Column Info */
	private String thirdPartyOfc = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String repCustCntCd = null;
	/* Column Info */
	private String frtTermCd = null;
	/* Column Info */
	private String repCustSeq = null;
	/* Column Info */
	private String loginOffice = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ThirdPartyOfcByLbpVO() {}

	public ThirdPartyOfcByLbpVO(String ibflag, String pagerows, String bkgNo, String loginOffice, String thirdPartyOfc, String repCustCntCd, String repCustSeq, String frtTermCd) {
		this.thirdPartyOfc = thirdPartyOfc;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.repCustCntCd = repCustCntCd;
		this.frtTermCd = frtTermCd;
		this.repCustSeq = repCustSeq;
		this.loginOffice = loginOffice;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("third_party_ofc", getThirdPartyOfc());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rep_cust_cnt_cd", getRepCustCntCd());
		this.hashColumns.put("frt_term_cd", getFrtTermCd());
		this.hashColumns.put("rep_cust_seq", getRepCustSeq());
		this.hashColumns.put("login_office", getLoginOffice());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("third_party_ofc", "thirdPartyOfc");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rep_cust_cnt_cd", "repCustCntCd");
		this.hashFields.put("frt_term_cd", "frtTermCd");
		this.hashFields.put("rep_cust_seq", "repCustSeq");
		this.hashFields.put("login_office", "loginOffice");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return thirdPartyOfc
	 */
	public String getThirdPartyOfc() {
		return this.thirdPartyOfc;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return repCustCntCd
	 */
	public String getRepCustCntCd() {
		return this.repCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return frtTermCd
	 */
	public String getFrtTermCd() {
		return this.frtTermCd;
	}
	
	/**
	 * Column Info
	 * @return repCustSeq
	 */
	public String getRepCustSeq() {
		return this.repCustSeq;
	}
	
	/**
	 * Column Info
	 * @return loginOffice
	 */
	public String getLoginOffice() {
		return this.loginOffice;
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
	 * @param thirdPartyOfc
	 */
	public void setThirdPartyOfc(String thirdPartyOfc) {
		this.thirdPartyOfc = thirdPartyOfc;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param repCustCntCd
	 */
	public void setRepCustCntCd(String repCustCntCd) {
		this.repCustCntCd = repCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param frtTermCd
	 */
	public void setFrtTermCd(String frtTermCd) {
		this.frtTermCd = frtTermCd;
	}
	
	/**
	 * Column Info
	 * @param repCustSeq
	 */
	public void setRepCustSeq(String repCustSeq) {
		this.repCustSeq = repCustSeq;
	}
	
	/**
	 * Column Info
	 * @param loginOffice
	 */
	public void setLoginOffice(String loginOffice) {
		this.loginOffice = loginOffice;
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
		setThirdPartyOfc(JSPUtil.getParameter(request, prefix + "third_party_ofc", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRepCustCntCd(JSPUtil.getParameter(request, prefix + "rep_cust_cnt_cd", ""));
		setFrtTermCd(JSPUtil.getParameter(request, prefix + "frt_term_cd", ""));
		setRepCustSeq(JSPUtil.getParameter(request, prefix + "rep_cust_seq", ""));
		setLoginOffice(JSPUtil.getParameter(request, prefix + "login_office", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ThirdPartyOfcByLbpVO[]
	 */
	public ThirdPartyOfcByLbpVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ThirdPartyOfcByLbpVO[]
	 */
	public ThirdPartyOfcByLbpVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ThirdPartyOfcByLbpVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] thirdPartyOfc = (JSPUtil.getParameter(request, prefix	+ "third_party_ofc", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] repCustCntCd = (JSPUtil.getParameter(request, prefix	+ "rep_cust_cnt_cd", length));
			String[] frtTermCd = (JSPUtil.getParameter(request, prefix	+ "frt_term_cd", length));
			String[] repCustSeq = (JSPUtil.getParameter(request, prefix	+ "rep_cust_seq", length));
			String[] loginOffice = (JSPUtil.getParameter(request, prefix	+ "login_office", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ThirdPartyOfcByLbpVO();
				if (thirdPartyOfc[i] != null)
					model.setThirdPartyOfc(thirdPartyOfc[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (repCustCntCd[i] != null)
					model.setRepCustCntCd(repCustCntCd[i]);
				if (frtTermCd[i] != null)
					model.setFrtTermCd(frtTermCd[i]);
				if (repCustSeq[i] != null)
					model.setRepCustSeq(repCustSeq[i]);
				if (loginOffice[i] != null)
					model.setLoginOffice(loginOffice[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getThirdPartyOfcByLbpVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ThirdPartyOfcByLbpVO[]
	 */
	public ThirdPartyOfcByLbpVO[] getThirdPartyOfcByLbpVOs(){
		ThirdPartyOfcByLbpVO[] vos = (ThirdPartyOfcByLbpVO[])models.toArray(new ThirdPartyOfcByLbpVO[models.size()]);
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
		this.thirdPartyOfc = this.thirdPartyOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCustCntCd = this.repCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtTermCd = this.frtTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCustSeq = this.repCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loginOffice = this.loginOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
