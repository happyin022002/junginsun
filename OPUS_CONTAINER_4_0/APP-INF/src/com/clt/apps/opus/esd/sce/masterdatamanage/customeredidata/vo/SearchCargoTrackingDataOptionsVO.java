/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchCargoTrackingDataOptionsVO.java
*@FileTitle : SearchCargoTrackingDataOptionsVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 전병석
*@LastVersion : 1.0
* 2009.09.23 전병석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 전병석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchCargoTrackingDataOptionsVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchCargoTrackingDataOptionsVO> models = new ArrayList<SearchCargoTrackingDataOptionsVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String ediGrpCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String vvdNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String ediSts = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String iPage = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchCargoTrackingDataOptionsVO() {}

	public SearchCargoTrackingDataOptionsVO(String ibflag, String pagerows, String bkgNo, String cntrNo, String ediSts, String ediGrpCd, String vvdNo, String porCd, String polCd, String podCd, String delCd, String copNo, String iPage) {
		this.porCd = porCd;
		this.ediGrpCd = ediGrpCd;
		this.delCd = delCd;
		this.copNo = copNo;
		this.vvdNo = vvdNo;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.ediSts = ediSts;
		this.polCd = polCd;
		this.cntrNo = cntrNo;
		this.iPage = iPage;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("edi_grp_cd", getEdiGrpCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("vvd_no", getVvdNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("edi_sts", getEdiSts());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("i_page", getIPage());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("edi_grp_cd", "ediGrpCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("vvd_no", "vvdNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("edi_sts", "ediSts");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("i_page", "iPage");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return ediGrpCd
	 */
	public String getEdiGrpCd() {
		return this.ediGrpCd;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return copNo
	 */
	public String getCopNo() {
		return this.copNo;
	}
	
	/**
	 * Column Info
	 * @return vvdNo
	 */
	public String getVvdNo() {
		return this.vvdNo;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
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
	 * @return ediSts
	 */
	public String getEdiSts() {
		return this.ediSts;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return iPage
	 */
	public String getIPage() {
		return this.iPage;
	}
	

	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param ediGrpCd
	 */
	public void setEdiGrpCd(String ediGrpCd) {
		this.ediGrpCd = ediGrpCd;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param copNo
	 */
	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}
	
	/**
	 * Column Info
	 * @param vvdNo
	 */
	public void setVvdNo(String vvdNo) {
		this.vvdNo = vvdNo;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
	 * @param ediSts
	 */
	public void setEdiSts(String ediSts) {
		this.ediSts = ediSts;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param iPage
	 */
	public void setIPage(String iPage) {
		this.iPage = iPage;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setEdiGrpCd(JSPUtil.getParameter(request, "edi_grp_cd", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setCopNo(JSPUtil.getParameter(request, "cop_no", ""));
		setVvdNo(JSPUtil.getParameter(request, "vvd_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setEdiSts(JSPUtil.getParameter(request, "edi_sts", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setIPage(JSPUtil.getParameter(request, "i_page", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCargoTrackingDataOptionsVO[]
	 */
	public SearchCargoTrackingDataOptionsVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCargoTrackingDataOptionsVO[]
	 */
	public SearchCargoTrackingDataOptionsVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchCargoTrackingDataOptionsVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] ediGrpCd = (JSPUtil.getParameter(request, prefix	+ "edi_grp_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] vvdNo = (JSPUtil.getParameter(request, prefix	+ "vvd_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ediSts = (JSPUtil.getParameter(request, prefix	+ "edi_sts", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] iPage = (JSPUtil.getParameter(request, prefix	+ "i_page", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchCargoTrackingDataOptionsVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (ediGrpCd[i] != null)
					model.setEdiGrpCd(ediGrpCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (vvdNo[i] != null)
					model.setVvdNo(vvdNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ediSts[i] != null)
					model.setEdiSts(ediSts[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (iPage[i] != null)
					model.setIPage(iPage[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchCargoTrackingDataOptionsVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchCargoTrackingDataOptionsVO[]
	 */
	public SearchCargoTrackingDataOptionsVO[] getSearchCargoTrackingDataOptionsVOs(){
		SearchCargoTrackingDataOptionsVO[] vos = (SearchCargoTrackingDataOptionsVO[])models.toArray(new SearchCargoTrackingDataOptionsVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediGrpCd = this.ediGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdNo = this.vvdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSts = this.ediSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iPage = this.iPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
