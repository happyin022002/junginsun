/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EmptyBkgHangerListVO.java
*@FileTitle : EmptyBkgHangerListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.20
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2014.02.20 류대영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo;

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
 * @author 류대영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
 
public class EmptyBkgHangerListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EmptyBkgHangerListVO> models = new ArrayList<EmptyBkgHangerListVO>();
	
	/* Column Info */
	private String hbq = null;
	/* Column Info */
	private String hbt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String hrt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String preBkgNo = null;
	/* Column Info */
	private String sBarQty = null;
	/* Column Info */
	private String podEta = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public EmptyBkgHangerListVO() {}

	public EmptyBkgHangerListVO(String ibflag, String pagerows, String polCd, String podCd, String podEta, String cntrNo, String cntrTpszCd, String hrt, String hbt, String hbq, String bkgNo, String preBkgNo, String sBarQty) {
		this.hbq = hbq;
		this.hbt = hbt;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.hrt = hrt;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.bkgNo = bkgNo;
		this.cntrNo = cntrNo;
		this.cntrTpszCd = cntrTpszCd;
		this.preBkgNo = preBkgNo;
		this.sBarQty = sBarQty;
		this.podEta = podEta;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("hbq", getHbq());
		this.hashColumns.put("hbt", getHbt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("hrt", getHrt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("pre_bkg_no", getPreBkgNo());
		this.hashColumns.put("s_bar_qty", getSBarQty());
		this.hashColumns.put("pod_eta", getPodEta());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("hbq", "hbq");
		this.hashFields.put("hbt", "hbt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("hrt", "hrt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("pre_bkg_no", "preBkgNo");
		this.hashFields.put("s_bar_qty", "sBarQty");
		this.hashFields.put("pod_eta", "podEta");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return hbq
	 */
	public String getHbq() {
		return this.hbq;
	}
	
	/**
	 * Column Info
	 * @return hbt
	 */
	public String getHbt() {
		return this.hbt;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return hrt
	 */
	public String getHrt() {
		return this.hrt;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
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
	 * @return preBkgNo
	 */
	public String getPreBkgNo() {
		return this.preBkgNo;
	}
	
	/**
	 * Column Info
	 * @return sBarQty
	 */
	public String getSBarQty() {
		return this.sBarQty;
	}
	
	/**
	 * Column Info
	 * @return podEta
	 */
	public String getPodEta() {
		return this.podEta;
	}
	

	/**
	 * Column Info
	 * @param hbq
	 */
	public void setHbq(String hbq) {
		this.hbq = hbq;
	}
	
	/**
	 * Column Info
	 * @param hbt
	 */
	public void setHbt(String hbt) {
		this.hbt = hbt;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param hrt
	 */
	public void setHrt(String hrt) {
		this.hrt = hrt;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
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
	 * @param preBkgNo
	 */
	public void setPreBkgNo(String preBkgNo) {
		this.preBkgNo = preBkgNo;
	}
	
	/**
	 * Column Info
	 * @param sBarQty
	 */
	public void setSBarQty(String sBarQty) {
		this.sBarQty = sBarQty;
	}
	
	/**
	 * Column Info
	 * @param podEta
	 */
	public void setPodEta(String podEta) {
		this.podEta = podEta;
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
		setHbq(JSPUtil.getParameter(request, prefix + "hbq", ""));
		setHbt(JSPUtil.getParameter(request, prefix + "hbt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setHrt(JSPUtil.getParameter(request, prefix + "hrt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setPreBkgNo(JSPUtil.getParameter(request, prefix + "pre_bkg_no", ""));
		setSBarQty(JSPUtil.getParameter(request, prefix + "s_bar_qty", ""));
		setPodEta(JSPUtil.getParameter(request, prefix + "pod_eta", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EmptyBkgHangerListVO[]
	 */
	public EmptyBkgHangerListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EmptyBkgHangerListVO[]
	 */
	public EmptyBkgHangerListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EmptyBkgHangerListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] hbq = (JSPUtil.getParameter(request, prefix	+ "hbq", length));
			String[] hbt = (JSPUtil.getParameter(request, prefix	+ "hbt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] hrt = (JSPUtil.getParameter(request, prefix	+ "hrt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] preBkgNo = (JSPUtil.getParameter(request, prefix	+ "pre_bkg_no", length));
			String[] sBarQty = (JSPUtil.getParameter(request, prefix	+ "s_bar_qty", length));
			String[] podEta = (JSPUtil.getParameter(request, prefix	+ "pod_eta", length));
			
			for (int i = 0; i < length; i++) {
				model = new EmptyBkgHangerListVO();
				if (hbq[i] != null)
					model.setHbq(hbq[i]);
				if (hbt[i] != null)
					model.setHbt(hbt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (hrt[i] != null)
					model.setHrt(hrt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (preBkgNo[i] != null)
					model.setPreBkgNo(preBkgNo[i]);
				if (sBarQty[i] != null)
					model.setSBarQty(sBarQty[i]);
				if (podEta[i] != null)
					model.setPodEta(podEta[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEmptyBkgHangerListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EmptyBkgHangerListVO[]
	 */
	public EmptyBkgHangerListVO[] getEmptyBkgHangerListVOs(){
		EmptyBkgHangerListVO[] vos = (EmptyBkgHangerListVO[])models.toArray(new EmptyBkgHangerListVO[models.size()]);
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
		this.hbq = this.hbq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hbt = this.hbt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hrt = this.hrt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preBkgNo = this.preBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBarQty = this.sBarQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podEta = this.podEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
