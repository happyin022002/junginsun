/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchRatingApplyDateVO.java
*@FileTitle : SearchRatingApplyDateVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.29
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2010.03.29 김태경 
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
 * @author 김태경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchRatingApplyDateVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchRatingApplyDateVO> models = new ArrayList<SearchRatingApplyDateVO>();
	
	/* Column Info */
	private String etb = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String firstVvd = null;
	/* Column Info */
	private String ocDate = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String etd = null;
	/* Column Info */
	private String ocCy = null;
	/* Column Info */
	private String caFlg = null;
	/* Column Info */
	private String applyDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchRatingApplyDateVO() {}

	public SearchRatingApplyDateVO(String ibflag, String pagerows, String bkgNo, String firstVvd, String polCd, String etb, String etd, String cntrNo, String ocDate, String ocCy, String applyDt, String caFlg) {
		this.etb = etb;
		this.polCd = polCd;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.firstVvd = firstVvd;
		this.ocDate = ocDate;
		this.cntrNo = cntrNo;
		this.etd = etd;
		this.ocCy = ocCy;
		this.caFlg = caFlg;
		this.applyDt = applyDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("etb", getEtb());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("first_vvd", getFirstVvd());
		this.hashColumns.put("oc_date", getOcDate());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("etd", getEtd());
		this.hashColumns.put("oc_cy", getOcCy());
		this.hashColumns.put("ca_flg", getCaFlg());
		this.hashColumns.put("apply_dt", getApplyDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("etb", "etb");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("first_vvd", "firstVvd");
		this.hashFields.put("oc_date", "ocDate");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("etd", "etd");
		this.hashFields.put("oc_cy", "ocCy");
		this.hashFields.put("ca_flg", "caFlg");
		this.hashFields.put("apply_dt", "applyDt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return etb
	 */
	public String getEtb() {
		return this.etb;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return firstVvd
	 */
	public String getFirstVvd() {
		return this.firstVvd;
	}
	
	/**
	 * Column Info
	 * @return ocDate
	 */
	public String getOcDate() {
		return this.ocDate;
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
	 * @return etd
	 */
	public String getEtd() {
		return this.etd;
	}
	
	/**
	 * Column Info
	 * @return ocCy
	 */
	public String getOcCy() {
		return this.ocCy;
	}
	
	/**
	 * Column Info
	 * @return caFlg
	 */
	public String getCaFlg() {
		return this.caFlg;
	}
	
	/**
	 * Column Info
	 * @return applyDt
	 */
	public String getApplyDt() {
		return this.applyDt;
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
	 * @param etb
	 */
	public void setEtb(String etb) {
		this.etb = etb;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param firstVvd
	 */
	public void setFirstVvd(String firstVvd) {
		this.firstVvd = firstVvd;
	}
	
	/**
	 * Column Info
	 * @param ocDate
	 */
	public void setOcDate(String ocDate) {
		this.ocDate = ocDate;
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
	 * @param etd
	 */
	public void setEtd(String etd) {
		this.etd = etd;
	}
	
	/**
	 * Column Info
	 * @param ocCy
	 */
	public void setOcCy(String ocCy) {
		this.ocCy = ocCy;
	}
	
	/**
	 * Column Info
	 * @param caFlg
	 */
	public void setCaFlg(String caFlg) {
		this.caFlg = caFlg;
	}
	
	/**
	 * Column Info
	 * @param applyDt
	 */
	public void setApplyDt(String applyDt) {
		this.applyDt = applyDt;
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
		setEtb(JSPUtil.getParameter(request, prefix + "etb", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFirstVvd(JSPUtil.getParameter(request, prefix + "first_vvd", ""));
		setOcDate(JSPUtil.getParameter(request, prefix + "oc_date", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setEtd(JSPUtil.getParameter(request, prefix + "etd", ""));
		setOcCy(JSPUtil.getParameter(request, prefix + "oc_cy", ""));
		setCaFlg(JSPUtil.getParameter(request, prefix + "ca_flg", ""));
		setApplyDt(JSPUtil.getParameter(request, prefix + "apply_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchRatingApplyDateVO[]
	 */
	public SearchRatingApplyDateVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchRatingApplyDateVO[]
	 */
	public SearchRatingApplyDateVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchRatingApplyDateVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] etb = (JSPUtil.getParameter(request, prefix	+ "etb", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] firstVvd = (JSPUtil.getParameter(request, prefix	+ "first_vvd", length));
			String[] ocDate = (JSPUtil.getParameter(request, prefix	+ "oc_date", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] etd = (JSPUtil.getParameter(request, prefix	+ "etd", length));
			String[] ocCy = (JSPUtil.getParameter(request, prefix	+ "oc_cy", length));
			String[] caFlg = (JSPUtil.getParameter(request, prefix	+ "ca_flg", length));
			String[] applyDt = (JSPUtil.getParameter(request, prefix	+ "apply_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchRatingApplyDateVO();
				if (etb[i] != null)
					model.setEtb(etb[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (firstVvd[i] != null)
					model.setFirstVvd(firstVvd[i]);
				if (ocDate[i] != null)
					model.setOcDate(ocDate[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (etd[i] != null)
					model.setEtd(etd[i]);
				if (ocCy[i] != null)
					model.setOcCy(ocCy[i]);
				if (caFlg[i] != null)
					model.setCaFlg(caFlg[i]);
				if (applyDt[i] != null)
					model.setApplyDt(applyDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchRatingApplyDateVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchRatingApplyDateVO[]
	 */
	public SearchRatingApplyDateVO[] getSearchRatingApplyDateVOs(){
		SearchRatingApplyDateVO[] vos = (SearchRatingApplyDateVO[])models.toArray(new SearchRatingApplyDateVO[models.size()]);
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
		this.etb = this.etb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.firstVvd = this.firstVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ocDate = this.ocDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etd = this.etd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ocCy = this.ocCy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caFlg = this.caFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.applyDt = this.applyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
