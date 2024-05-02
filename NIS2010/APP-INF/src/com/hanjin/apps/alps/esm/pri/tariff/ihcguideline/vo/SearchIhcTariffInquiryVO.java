/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SearchIhcTariffInquiryVO.java
*@FileTitle : SearchIhcTariffInquiryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.07
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2012.11.07 서미진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Object<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 서미진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchIhcTariffInquiryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchIhcTariffInquiryVO> models = new ArrayList<SearchIhcTariffInquiryVO>();
	
	/* Column Info */
	private String svcTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String zipCd = null;
	/* Column Info */
	private String pntLocCd = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String orgDestTpCd = null;
	/* Column Info */
	private String accDt = null;
	/* Column Info */
	private String ihcCgoTpCd = null;
	/* Column Info */
	private String bsePortLocCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchIhcTariffInquiryVO() {}

	public SearchIhcTariffInquiryVO(String ibflag, String pagerows, String svcScpCd, String pntLocCd, String cntCd, String accDt, String bsePortLocCd, String orgDestTpCd, String ihcCgoTpCd, String zipCd, String rhqCd, String svcTpCd) {
		this.svcTpCd = svcTpCd;
		this.ibflag = ibflag;
		this.rhqCd = rhqCd;
		this.zipCd = zipCd;
		this.pntLocCd = pntLocCd;
		this.svcScpCd = svcScpCd;
		this.cntCd = cntCd;
		this.orgDestTpCd = orgDestTpCd;
		this.accDt = accDt;
		this.ihcCgoTpCd = ihcCgoTpCd;
		this.bsePortLocCd = bsePortLocCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("svc_tp_cd", getSvcTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("zip_cd", getZipCd());
		this.hashColumns.put("pnt_loc_cd", getPntLocCd());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("org_dest_tp_cd", getOrgDestTpCd());
		this.hashColumns.put("acc_dt", getAccDt());
		this.hashColumns.put("ihc_cgo_tp_cd", getIhcCgoTpCd());
		this.hashColumns.put("bse_port_loc_cd", getBsePortLocCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("svc_tp_cd", "svcTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("zip_cd", "zipCd");
		this.hashFields.put("pnt_loc_cd", "pntLocCd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("org_dest_tp_cd", "orgDestTpCd");
		this.hashFields.put("acc_dt", "accDt");
		this.hashFields.put("ihc_cgo_tp_cd", "ihcCgoTpCd");
		this.hashFields.put("bse_port_loc_cd", "bsePortLocCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return svcTpCd
	 */
	public String getSvcTpCd() {
		return this.svcTpCd;
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
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return zipCd
	 */
	public String getZipCd() {
		return this.zipCd;
	}
	
	/**
	 * Column Info
	 * @return pntLocCd
	 */
	public String getPntLocCd() {
		return this.pntLocCd;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return orgDestTpCd
	 */
	public String getOrgDestTpCd() {
		return this.orgDestTpCd;
	}
	
	/**
	 * Column Info
	 * @return accDt
	 */
	public String getAccDt() {
		return this.accDt;
	}
	
	/**
	 * Column Info
	 * @return ihcCgoTpCd
	 */
	public String getIhcCgoTpCd() {
		return this.ihcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return bsePortLocCd
	 */
	public String getBsePortLocCd() {
		return this.bsePortLocCd;
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
	 * @param svcTpCd
	 */
	public void setSvcTpCd(String svcTpCd) {
		this.svcTpCd = svcTpCd;
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
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param zipCd
	 */
	public void setZipCd(String zipCd) {
		this.zipCd = zipCd;
	}
	
	/**
	 * Column Info
	 * @param pntLocCd
	 */
	public void setPntLocCd(String pntLocCd) {
		this.pntLocCd = pntLocCd;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param orgDestTpCd
	 */
	public void setOrgDestTpCd(String orgDestTpCd) {
		this.orgDestTpCd = orgDestTpCd;
	}
	
	/**
	 * Column Info
	 * @param accDt
	 */
	public void setAccDt(String accDt) {
		this.accDt = accDt;
	}
	
	/**
	 * Column Info
	 * @param ihcCgoTpCd
	 */
	public void setIhcCgoTpCd(String ihcCgoTpCd) {
		this.ihcCgoTpCd = ihcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param bsePortLocCd
	 */
	public void setBsePortLocCd(String bsePortLocCd) {
		this.bsePortLocCd = bsePortLocCd;
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
		setSvcTpCd(JSPUtil.getParameter(request, prefix + "svc_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setZipCd(JSPUtil.getParameter(request, prefix + "zip_cd", ""));
		setPntLocCd(JSPUtil.getParameter(request, prefix + "pnt_loc_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setOrgDestTpCd(JSPUtil.getParameter(request, prefix + "org_dest_tp_cd", ""));
		setAccDt(JSPUtil.getParameter(request, prefix + "acc_dt", ""));
		setIhcCgoTpCd(JSPUtil.getParameter(request, prefix + "ihc_cgo_tp_cd", ""));
		setBsePortLocCd(JSPUtil.getParameter(request, prefix + "bse_port_loc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchIhcTariffInquiryVO[]
	 */
	public SearchIhcTariffInquiryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchIhcTariffInquiryVO[]
	 */
	public SearchIhcTariffInquiryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchIhcTariffInquiryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] svcTpCd = (JSPUtil.getParameter(request, prefix	+ "svc_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] zipCd = (JSPUtil.getParameter(request, prefix	+ "zip_cd", length));
			String[] pntLocCd = (JSPUtil.getParameter(request, prefix	+ "pnt_loc_cd", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] orgDestTpCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_tp_cd", length));
			String[] accDt = (JSPUtil.getParameter(request, prefix	+ "acc_dt", length));
			String[] ihcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "ihc_cgo_tp_cd", length));
			String[] bsePortLocCd = (JSPUtil.getParameter(request, prefix	+ "bse_port_loc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchIhcTariffInquiryVO();
				if (svcTpCd[i] != null)
					model.setSvcTpCd(svcTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (zipCd[i] != null)
					model.setZipCd(zipCd[i]);
				if (pntLocCd[i] != null)
					model.setPntLocCd(pntLocCd[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (orgDestTpCd[i] != null)
					model.setOrgDestTpCd(orgDestTpCd[i]);
				if (accDt[i] != null)
					model.setAccDt(accDt[i]);
				if (ihcCgoTpCd[i] != null)
					model.setIhcCgoTpCd(ihcCgoTpCd[i]);
				if (bsePortLocCd[i] != null)
					model.setBsePortLocCd(bsePortLocCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchIhcTariffInquiryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchIhcTariffInquiryVO[]
	 */
	public SearchIhcTariffInquiryVO[] getSearchIhcTariffInquiryVOs(){
		SearchIhcTariffInquiryVO[] vos = (SearchIhcTariffInquiryVO[])models.toArray(new SearchIhcTariffInquiryVO[models.size()]);
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
		this.svcTpCd = this.svcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zipCd = this.zipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pntLocCd = this.pntLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestTpCd = this.orgDestTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accDt = this.accDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ihcCgoTpCd = this.ihcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsePortLocCd = this.bsePortLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
