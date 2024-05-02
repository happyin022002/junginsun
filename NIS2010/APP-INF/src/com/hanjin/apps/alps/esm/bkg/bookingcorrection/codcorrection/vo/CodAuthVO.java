/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CodAuthVO.java
*@FileTitle : CodAuthVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.15
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.10.15 최영희 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.vo;

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
 * @author 최영희
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CodAuthVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CodAuthVO> models = new ArrayList<CodAuthVO>();
	
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String codRqstSeq = null;
	/* Column Info */
	private String codstscd = null;
	/* Column Info */
	private String rejectrmk = null;
	/* Column Info */
	private String authflag = null;
	/* Column Info */
	private String rejectcd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CodAuthVO() {}

	public CodAuthVO(String ibflag, String pagerows, String bkgNo, String codRqstSeq, String authflag, String rejectcd, String rejectrmk, String codstscd) {
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.codRqstSeq = codRqstSeq;
		this.codstscd = codstscd;
		this.rejectrmk = rejectrmk;
		this.authflag = authflag;
		this.rejectcd = rejectcd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cod_rqst_seq", getCodRqstSeq());
		this.hashColumns.put("codstscd", getCodstscd());
		this.hashColumns.put("rejectrmk", getRejectrmk());
		this.hashColumns.put("authflag", getAuthflag());
		this.hashColumns.put("rejectcd", getRejectcd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cod_rqst_seq", "codRqstSeq");
		this.hashFields.put("codstscd", "codstscd");
		this.hashFields.put("rejectrmk", "rejectrmk");
		this.hashFields.put("authflag", "authflag");
		this.hashFields.put("rejectcd", "rejectcd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return codRqstSeq
	 */
	public String getCodRqstSeq() {
		return this.codRqstSeq;
	}
	
	/**
	 * Column Info
	 * @return codstscd
	 */
	public String getCodstscd() {
		return this.codstscd;
	}
	
	/**
	 * Column Info
	 * @return rejectrmk
	 */
	public String getRejectrmk() {
		return this.rejectrmk;
	}
	
	/**
	 * Column Info
	 * @return authflag
	 */
	public String getAuthflag() {
		return this.authflag;
	}
	
	/**
	 * Column Info
	 * @return rejectcd
	 */
	public String getRejectcd() {
		return this.rejectcd;
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
	 * @param codRqstSeq
	 */
	public void setCodRqstSeq(String codRqstSeq) {
		this.codRqstSeq = codRqstSeq;
	}
	
	/**
	 * Column Info
	 * @param codstscd
	 */
	public void setCodstscd(String codstscd) {
		this.codstscd = codstscd;
	}
	
	/**
	 * Column Info
	 * @param rejectrmk
	 */
	public void setRejectrmk(String rejectrmk) {
		this.rejectrmk = rejectrmk;
	}
	
	/**
	 * Column Info
	 * @param authflag
	 */
	public void setAuthflag(String authflag) {
		this.authflag = authflag;
	}
	
	/**
	 * Column Info
	 * @param rejectcd
	 */
	public void setRejectcd(String rejectcd) {
		this.rejectcd = rejectcd;
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
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCodRqstSeq(JSPUtil.getParameter(request, "cod_rqst_seq", ""));
		setCodstscd(JSPUtil.getParameter(request, "codstscd", ""));
		setRejectrmk(JSPUtil.getParameter(request, "rejectRmk", ""));
		setAuthflag(JSPUtil.getParameter(request, "authflag", ""));
		setRejectcd(JSPUtil.getParameter(request, "rejectcd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CodAuthVO[]
	 */
	public CodAuthVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CodAuthVO[]
	 */
	public CodAuthVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CodAuthVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] codRqstSeq = (JSPUtil.getParameter(request, prefix	+ "cod_rqst_seq", length));
			String[] codstscd = (JSPUtil.getParameter(request, prefix	+ "codstscd", length));
			String[] rejectrmk = (JSPUtil.getParameter(request, prefix	+ "rejectRmk", length));
			String[] authflag = (JSPUtil.getParameter(request, prefix	+ "authflag", length));
			String[] rejectcd = (JSPUtil.getParameter(request, prefix	+ "rejectcd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CodAuthVO();
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (codRqstSeq[i] != null)
					model.setCodRqstSeq(codRqstSeq[i]);
				if (codstscd[i] != null)
					model.setCodstscd(codstscd[i]);
				if (rejectrmk[i] != null)
					model.setRejectrmk(rejectrmk[i]);
				if (authflag[i] != null)
					model.setAuthflag(authflag[i]);
				if (rejectcd[i] != null)
					model.setRejectcd(rejectcd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCodAuthVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CodAuthVO[]
	 */
	public CodAuthVO[] getCodAuthVOs(){
		CodAuthVO[] vos = (CodAuthVO[])models.toArray(new CodAuthVO[models.size()]);
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
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codRqstSeq = this.codRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codstscd = this.codstscd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rejectrmk = this.rejectrmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authflag = this.authflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rejectcd = this.rejectcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
