/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SearchPerfSpDtlListVO.java
*@FileTitle : SearchPerfSpDtlListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.25  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.expnaud.audperf.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchPerfSpDtlListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchPerfSpDtlListVO> models = new ArrayList<SearchPerfSpDtlListVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String sYm = null;
	/* Column Info */
	private String usdAmt = null;
	/* Column Info */
	private String sMdlCd = null;
	/* Column Info */
	private String sCompareMon = null;
	/* Column Info */
	private String sRhqYn = null;
	/* Column Info */
	private String ymTpCd = null;
	/* Column Info */
	private String invQty = null;
	/* Column Info */
	private String stndYm = null;
	/* Column Info */
	private String mdlCd = null;
	/* Column Info */
	private String glMon = null;
	/* Column Info */
	private String vndrNm = null;
	/* Column Info */
	private String sOfcCd = null;
	/* Column Info */
	private String currAmt = null;
	/* Column Info */
	private String vndrNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchPerfSpDtlListVO() {}

	public SearchPerfSpDtlListVO(String ibflag, String pagerows, String ofcCd, String glMon, String mdlCd, String vndrNo, String vndrNm, String locCd, String invQty, String currCd, String currAmt, String usdAmt, String stndYm, String ymTpCd, String sYm, String sCompareMon, String sMdlCd, String sOfcCd, String sRhqYn) {
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.currCd = currCd;
		this.sYm = sYm;
		this.usdAmt = usdAmt;
		this.sMdlCd = sMdlCd;
		this.sCompareMon = sCompareMon;
		this.sRhqYn = sRhqYn;
		this.ymTpCd = ymTpCd;
		this.invQty = invQty;
		this.stndYm = stndYm;
		this.mdlCd = mdlCd;
		this.glMon = glMon;
		this.vndrNm = vndrNm;
		this.sOfcCd = sOfcCd;
		this.currAmt = currAmt;
		this.vndrNo = vndrNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("s_ym", getSYm());
		this.hashColumns.put("usd_amt", getUsdAmt());
		this.hashColumns.put("s_mdl_cd", getSMdlCd());
		this.hashColumns.put("s_compare_mon", getSCompareMon());
		this.hashColumns.put("s_rhq_yn", getSRhqYn());
		this.hashColumns.put("ym_tp_cd", getYmTpCd());
		this.hashColumns.put("inv_qty", getInvQty());
		this.hashColumns.put("stnd_ym", getStndYm());
		this.hashColumns.put("mdl_cd", getMdlCd());
		this.hashColumns.put("gl_mon", getGlMon());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("s_ofc_cd", getSOfcCd());
		this.hashColumns.put("curr_amt", getCurrAmt());
		this.hashColumns.put("vndr_no", getVndrNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("s_ym", "sYm");
		this.hashFields.put("usd_amt", "usdAmt");
		this.hashFields.put("s_mdl_cd", "sMdlCd");
		this.hashFields.put("s_compare_mon", "sCompareMon");
		this.hashFields.put("s_rhq_yn", "sRhqYn");
		this.hashFields.put("ym_tp_cd", "ymTpCd");
		this.hashFields.put("inv_qty", "invQty");
		this.hashFields.put("stnd_ym", "stndYm");
		this.hashFields.put("mdl_cd", "mdlCd");
		this.hashFields.put("gl_mon", "glMon");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("s_ofc_cd", "sOfcCd");
		this.hashFields.put("curr_amt", "currAmt");
		this.hashFields.put("vndr_no", "vndrNo");
		return this.hashFields;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return sYm
	 */
	public String getSYm() {
		return this.sYm;
	}
	
	/**
	 * Column Info
	 * @return usdAmt
	 */
	public String getUsdAmt() {
		return this.usdAmt;
	}
	
	/**
	 * Column Info
	 * @return sMdlCd
	 */
	public String getSMdlCd() {
		return this.sMdlCd;
	}
	
	/**
	 * Column Info
	 * @return sCompareMon
	 */
	public String getSCompareMon() {
		return this.sCompareMon;
	}
	
	/**
	 * Column Info
	 * @return sRhqYn
	 */
	public String getSRhqYn() {
		return this.sRhqYn;
	}
	
	/**
	 * Column Info
	 * @return ymTpCd
	 */
	public String getYmTpCd() {
		return this.ymTpCd;
	}
	
	/**
	 * Column Info
	 * @return invQty
	 */
	public String getInvQty() {
		return this.invQty;
	}
	
	/**
	 * Column Info
	 * @return stndYm
	 */
	public String getStndYm() {
		return this.stndYm;
	}
	
	/**
	 * Column Info
	 * @return mdlCd
	 */
	public String getMdlCd() {
		return this.mdlCd;
	}
	
	/**
	 * Column Info
	 * @return glMon
	 */
	public String getGlMon() {
		return this.glMon;
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
	 * @return sOfcCd
	 */
	public String getSOfcCd() {
		return this.sOfcCd;
	}
	
	/**
	 * Column Info
	 * @return currAmt
	 */
	public String getCurrAmt() {
		return this.currAmt;
	}
	
	/**
	 * Column Info
	 * @return vndrNo
	 */
	public String getVndrNo() {
		return this.vndrNo;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param sYm
	 */
	public void setSYm(String sYm) {
		this.sYm = sYm;
	}
	
	/**
	 * Column Info
	 * @param usdAmt
	 */
	public void setUsdAmt(String usdAmt) {
		this.usdAmt = usdAmt;
	}
	
	/**
	 * Column Info
	 * @param sMdlCd
	 */
	public void setSMdlCd(String sMdlCd) {
		this.sMdlCd = sMdlCd;
	}
	
	/**
	 * Column Info
	 * @param sCompareMon
	 */
	public void setSCompareMon(String sCompareMon) {
		this.sCompareMon = sCompareMon;
	}
	
	/**
	 * Column Info
	 * @param sRhqYn
	 */
	public void setSRhqYn(String sRhqYn) {
		this.sRhqYn = sRhqYn;
	}
	
	/**
	 * Column Info
	 * @param ymTpCd
	 */
	public void setYmTpCd(String ymTpCd) {
		this.ymTpCd = ymTpCd;
	}
	
	/**
	 * Column Info
	 * @param invQty
	 */
	public void setInvQty(String invQty) {
		this.invQty = invQty;
	}
	
	/**
	 * Column Info
	 * @param stndYm
	 */
	public void setStndYm(String stndYm) {
		this.stndYm = stndYm;
	}
	
	/**
	 * Column Info
	 * @param mdlCd
	 */
	public void setMdlCd(String mdlCd) {
		this.mdlCd = mdlCd;
	}
	
	/**
	 * Column Info
	 * @param glMon
	 */
	public void setGlMon(String glMon) {
		this.glMon = glMon;
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
	 * @param sOfcCd
	 */
	public void setSOfcCd(String sOfcCd) {
		this.sOfcCd = sOfcCd;
	}
	
	/**
	 * Column Info
	 * @param currAmt
	 */
	public void setCurrAmt(String currAmt) {
		this.currAmt = currAmt;
	}
	
	/**
	 * Column Info
	 * @param vndrNo
	 */
	public void setVndrNo(String vndrNo) {
		this.vndrNo = vndrNo;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setSYm(JSPUtil.getParameter(request, prefix + "s_ym", ""));
		setUsdAmt(JSPUtil.getParameter(request, prefix + "usd_amt", ""));
		setSMdlCd(JSPUtil.getParameter(request, prefix + "s_mdl_cd", ""));
		setSCompareMon(JSPUtil.getParameter(request, prefix + "s_compare_mon", ""));
		setSRhqYn(JSPUtil.getParameter(request, prefix + "s_rhq_yn", ""));
		setYmTpCd(JSPUtil.getParameter(request, prefix + "ym_tp_cd", ""));
		setInvQty(JSPUtil.getParameter(request, prefix + "inv_qty", ""));
		setStndYm(JSPUtil.getParameter(request, prefix + "stnd_ym", ""));
		setMdlCd(JSPUtil.getParameter(request, prefix + "mdl_cd", ""));
		setGlMon(JSPUtil.getParameter(request, prefix + "gl_mon", ""));
		setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
		setSOfcCd(JSPUtil.getParameter(request, prefix + "s_ofc_cd", ""));
		setCurrAmt(JSPUtil.getParameter(request, prefix + "curr_amt", ""));
		setVndrNo(JSPUtil.getParameter(request, prefix + "vndr_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchPerfSpDtlListVO[]
	 */
	public SearchPerfSpDtlListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchPerfSpDtlListVO[]
	 */
	public SearchPerfSpDtlListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchPerfSpDtlListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] sYm = (JSPUtil.getParameter(request, prefix	+ "s_ym", length));
			String[] usdAmt = (JSPUtil.getParameter(request, prefix	+ "usd_amt", length));
			String[] sMdlCd = (JSPUtil.getParameter(request, prefix	+ "s_mdl_cd", length));
			String[] sCompareMon = (JSPUtil.getParameter(request, prefix	+ "s_compare_mon", length));
			String[] sRhqYn = (JSPUtil.getParameter(request, prefix	+ "s_rhq_yn", length));
			String[] ymTpCd = (JSPUtil.getParameter(request, prefix	+ "ym_tp_cd", length));
			String[] invQty = (JSPUtil.getParameter(request, prefix	+ "inv_qty", length));
			String[] stndYm = (JSPUtil.getParameter(request, prefix	+ "stnd_ym", length));
			String[] mdlCd = (JSPUtil.getParameter(request, prefix	+ "mdl_cd", length));
			String[] glMon = (JSPUtil.getParameter(request, prefix	+ "gl_mon", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] sOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_ofc_cd", length));
			String[] currAmt = (JSPUtil.getParameter(request, prefix	+ "curr_amt", length));
			String[] vndrNo = (JSPUtil.getParameter(request, prefix	+ "vndr_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchPerfSpDtlListVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (sYm[i] != null)
					model.setSYm(sYm[i]);
				if (usdAmt[i] != null)
					model.setUsdAmt(usdAmt[i]);
				if (sMdlCd[i] != null)
					model.setSMdlCd(sMdlCd[i]);
				if (sCompareMon[i] != null)
					model.setSCompareMon(sCompareMon[i]);
				if (sRhqYn[i] != null)
					model.setSRhqYn(sRhqYn[i]);
				if (ymTpCd[i] != null)
					model.setYmTpCd(ymTpCd[i]);
				if (invQty[i] != null)
					model.setInvQty(invQty[i]);
				if (stndYm[i] != null)
					model.setStndYm(stndYm[i]);
				if (mdlCd[i] != null)
					model.setMdlCd(mdlCd[i]);
				if (glMon[i] != null)
					model.setGlMon(glMon[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (sOfcCd[i] != null)
					model.setSOfcCd(sOfcCd[i]);
				if (currAmt[i] != null)
					model.setCurrAmt(currAmt[i]);
				if (vndrNo[i] != null)
					model.setVndrNo(vndrNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchPerfSpDtlListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchPerfSpDtlListVO[]
	 */
	public SearchPerfSpDtlListVO[] getSearchPerfSpDtlListVOs(){
		SearchPerfSpDtlListVO[] vos = (SearchPerfSpDtlListVO[])models.toArray(new SearchPerfSpDtlListVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sYm = this.sYm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdAmt = this.usdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sMdlCd = this.sMdlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCompareMon = this.sCompareMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRhqYn = this.sRhqYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ymTpCd = this.ymTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invQty = this.invQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndYm = this.stndYm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdlCd = this.mdlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glMon = this.glMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOfcCd = this.sOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currAmt = this.currAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNo = this.vndrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
