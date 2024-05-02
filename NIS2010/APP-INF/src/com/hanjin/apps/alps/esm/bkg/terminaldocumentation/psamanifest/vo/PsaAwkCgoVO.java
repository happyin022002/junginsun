/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PsaAwkCgoVO.java
*@FileTitle : PsaAwkCgoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.08
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.02.08 박상훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo;

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
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PsaAwkCgoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PsaAwkCgoVO> models = new ArrayList<PsaAwkCgoVO>();
	
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String akQty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String akOl = null;
	/* Column Info */
	private String akOw = null;
	/* Column Info */
	private String akOh = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PsaAwkCgoVO() {}

	public PsaAwkCgoVO(String ibflag, String pagerows, String akOh, String akOw, String akOl, String akQty, String bkgNo, String cntrTpszCd) {
		this.bkgNo = bkgNo;
		this.akQty = akQty;
		this.ibflag = ibflag;
		this.cntrTpszCd = cntrTpszCd;
		this.akOl = akOl;
		this.akOw = akOw;
		this.akOh = akOh;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ak_qty", getAkQty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("ak_ol", getAkOl());
		this.hashColumns.put("ak_ow", getAkOw());
		this.hashColumns.put("ak_oh", getAkOh());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ak_qty", "akQty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("ak_ol", "akOl");
		this.hashFields.put("ak_ow", "akOw");
		this.hashFields.put("ak_oh", "akOh");
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
	 * Column Info
	 * @return akQty
	 */
	public String getAkQty() {
		return this.akQty;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return akOl
	 */
	public String getAkOl() {
		return this.akOl;
	}
	
	/**
	 * Column Info
	 * @return akOw
	 */
	public String getAkOw() {
		return this.akOw;
	}
	
	/**
	 * Column Info
	 * @return akOh
	 */
	public String getAkOh() {
		return this.akOh;
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
	 * Column Info
	 * @param akQty
	 */
	public void setAkQty(String akQty) {
		this.akQty = akQty;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param akOl
	 */
	public void setAkOl(String akOl) {
		this.akOl = akOl;
	}
	
	/**
	 * Column Info
	 * @param akOw
	 */
	public void setAkOw(String akOw) {
		this.akOw = akOw;
	}
	
	/**
	 * Column Info
	 * @param akOh
	 */
	public void setAkOh(String akOh) {
		this.akOh = akOh;
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
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setAkQty(JSPUtil.getParameter(request, prefix + "ak_qty", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setAkOl(JSPUtil.getParameter(request, prefix + "ak_ol", ""));
		setAkOw(JSPUtil.getParameter(request, prefix + "ak_ow", ""));
		setAkOh(JSPUtil.getParameter(request, prefix + "ak_oh", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PsaAwkCgoVO[]
	 */
	public PsaAwkCgoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PsaAwkCgoVO[]
	 */
	public PsaAwkCgoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PsaAwkCgoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] akQty = (JSPUtil.getParameter(request, prefix	+ "ak_qty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] akOl = (JSPUtil.getParameter(request, prefix	+ "ak_ol", length));
			String[] akOw = (JSPUtil.getParameter(request, prefix	+ "ak_ow", length));
			String[] akOh = (JSPUtil.getParameter(request, prefix	+ "ak_oh", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new PsaAwkCgoVO();
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (akQty[i] != null)
					model.setAkQty(akQty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (akOl[i] != null)
					model.setAkOl(akOl[i]);
				if (akOw[i] != null)
					model.setAkOw(akOw[i]);
				if (akOh[i] != null)
					model.setAkOh(akOh[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPsaAwkCgoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PsaAwkCgoVO[]
	 */
	public PsaAwkCgoVO[] getPsaAwkCgoVOs(){
		PsaAwkCgoVO[] vos = (PsaAwkCgoVO[])models.toArray(new PsaAwkCgoVO[models.size()]);
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
		this.akQty = this.akQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.akOl = this.akOl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.akOw = this.akOw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.akOh = this.akOh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
