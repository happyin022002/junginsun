/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BkgReactivateVO.java
*@FileTitle : BkgReactivateVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.01
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.01  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo;

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

public class BkgReactivateVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgReactivateVO> models = new ArrayList<BkgReactivateVO>();
	
	/* Column Info */
	private String ractDt = null;
	/* Column Info */
	private String ractOfc = null;
	/* Column Info */
	private String cxlDt = null;
	/* Column Info */
	private String ractBy = null;
	/* Column Info */
	private String polEtdDt = null;
	/* Column Info */
	private String cxlBy = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String tLane = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String tVvd = null;
	/* Column Info */
	private String cxlOfc = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String cxlRsn = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BkgReactivateVO() {}

	public BkgReactivateVO(String ibflag, String pagerows, String bkgNo, String tVvd, String tLane, String polCd, String podCd, String bkgStsCd, String polEtdDt, String cxlDt, String cxlBy, String cxlOfc, String ractDt, String ractBy, String ractOfc, String cxlRsn) {
		this.ractDt = ractDt;
		this.ractOfc = ractOfc;
		this.cxlDt = cxlDt;
		this.ractBy = ractBy;
		this.polEtdDt = polEtdDt;
		this.cxlBy = cxlBy;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.tLane = tLane;
		this.polCd = polCd;
		this.tVvd = tVvd;
		this.cxlOfc = cxlOfc;
		this.bkgStsCd = bkgStsCd;
		this.cxlRsn = cxlRsn;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ract_dt", getRactDt());
		this.hashColumns.put("ract_ofc", getRactOfc());
		this.hashColumns.put("cxl_dt", getCxlDt());
		this.hashColumns.put("ract_by", getRactBy());
		this.hashColumns.put("pol_etd_dt", getPolEtdDt());
		this.hashColumns.put("cxl_by", getCxlBy());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("t_lane", getTLane());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("t_vvd", getTVvd());
		this.hashColumns.put("cxl_ofc", getCxlOfc());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("cxl_rsn", getCxlRsn());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ract_dt", "ractDt");
		this.hashFields.put("ract_ofc", "ractOfc");
		this.hashFields.put("cxl_dt", "cxlDt");
		this.hashFields.put("ract_by", "ractBy");
		this.hashFields.put("pol_etd_dt", "polEtdDt");
		this.hashFields.put("cxl_by", "cxlBy");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("t_lane", "tLane");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("t_vvd", "tVvd");
		this.hashFields.put("cxl_ofc", "cxlOfc");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("cxl_rsn", "cxlRsn");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ractDt
	 */
	public String getCxlRsn() {
		return this.cxlRsn;
	}
	
	/**
	 * Column Info
	 * @return ractDt
	 */
	public String getRactDt() {
		return this.ractDt;
	}
	
	/**
	 * Column Info
	 * @return ractOfc
	 */
	public String getRactOfc() {
		return this.ractOfc;
	}
	
	/**
	 * Column Info
	 * @return cxlDt
	 */
	public String getCxlDt() {
		return this.cxlDt;
	}
	
	/**
	 * Column Info
	 * @return ractBy
	 */
	public String getRactBy() {
		return this.ractBy;
	}
	
	/**
	 * Column Info
	 * @return polEtdDt
	 */
	public String getPolEtdDt() {
		return this.polEtdDt;
	}
	
	/**
	 * Column Info
	 * @return cxlBy
	 */
	public String getCxlBy() {
		return this.cxlBy;
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
	 * @return tLane
	 */
	public String getTLane() {
		return this.tLane;
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
	 * @return tVvd
	 */
	public String getTVvd() {
		return this.tVvd;
	}
	
	/**
	 * Column Info
	 * @return cxlOfc
	 */
	public String getCxlOfc() {
		return this.cxlOfc;
	}
	
	/**
	 * Column Info
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @param cxlRsn
	 */
	public void setCxlRsn(String cxlRsn) {
		this.cxlRsn = cxlRsn;
	}

	/**
	 * Column Info
	 * @param ractDt
	 */
	public void setRactDt(String ractDt) {
		this.ractDt = ractDt;
	}
	
	/**
	 * Column Info
	 * @param ractOfc
	 */
	public void setRactOfc(String ractOfc) {
		this.ractOfc = ractOfc;
	}
	
	/**
	 * Column Info
	 * @param cxlDt
	 */
	public void setCxlDt(String cxlDt) {
		this.cxlDt = cxlDt;
	}
	
	/**
	 * Column Info
	 * @param ractBy
	 */
	public void setRactBy(String ractBy) {
		this.ractBy = ractBy;
	}
	
	/**
	 * Column Info
	 * @param polEtdDt
	 */
	public void setPolEtdDt(String polEtdDt) {
		this.polEtdDt = polEtdDt;
	}
	
	/**
	 * Column Info
	 * @param cxlBy
	 */
	public void setCxlBy(String cxlBy) {
		this.cxlBy = cxlBy;
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
	 * @param tLane
	 */
	public void setTLane(String tLane) {
		this.tLane = tLane;
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
	 * @param tVvd
	 */
	public void setTVvd(String tVvd) {
		this.tVvd = tVvd;
	}
	
	/**
	 * Column Info
	 * @param cxlOfc
	 */
	public void setCxlOfc(String cxlOfc) {
		this.cxlOfc = cxlOfc;
	}
	
	/**
	 * Column Info
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
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
		setRactDt(JSPUtil.getParameter(request, prefix + "ract_dt", ""));
		setRactOfc(JSPUtil.getParameter(request, prefix + "ract_ofc", ""));
		setCxlDt(JSPUtil.getParameter(request, prefix + "cxl_dt", ""));
		setRactBy(JSPUtil.getParameter(request, prefix + "ract_by", ""));
		setPolEtdDt(JSPUtil.getParameter(request, prefix + "pol_etd_dt", ""));
		setCxlBy(JSPUtil.getParameter(request, prefix + "cxl_by", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setTLane(JSPUtil.getParameter(request, prefix + "t_lane", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setTVvd(JSPUtil.getParameter(request, prefix + "t_vvd", ""));
		setCxlOfc(JSPUtil.getParameter(request, prefix + "cxl_ofc", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setCxlRsn(JSPUtil.getParameter(request, prefix + "cxl_rsn", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgReactivateVO[]
	 */
	public BkgReactivateVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgReactivateVO[]
	 */
	public BkgReactivateVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgReactivateVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ractDt = (JSPUtil.getParameter(request, prefix	+ "ract_dt", length));
			String[] ractOfc = (JSPUtil.getParameter(request, prefix	+ "ract_ofc", length));
			String[] cxlDt = (JSPUtil.getParameter(request, prefix	+ "cxl_dt", length));
			String[] ractBy = (JSPUtil.getParameter(request, prefix	+ "ract_by", length));
			String[] polEtdDt = (JSPUtil.getParameter(request, prefix	+ "pol_etd_dt", length));
			String[] cxlBy = (JSPUtil.getParameter(request, prefix	+ "cxl_by", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] tLane = (JSPUtil.getParameter(request, prefix	+ "t_lane", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] tVvd = (JSPUtil.getParameter(request, prefix	+ "t_vvd", length));
			String[] cxlOfc = (JSPUtil.getParameter(request, prefix	+ "cxl_ofc", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] cxlRsn = (JSPUtil.getParameter(request, prefix	+ "cxl_rsn", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgReactivateVO();
				if (ractDt[i] != null)
					model.setRactDt(ractDt[i]);
				if (ractOfc[i] != null)
					model.setRactOfc(ractOfc[i]);
				if (cxlDt[i] != null)
					model.setCxlDt(cxlDt[i]);
				if (ractBy[i] != null)
					model.setRactBy(ractBy[i]);
				if (polEtdDt[i] != null)
					model.setPolEtdDt(polEtdDt[i]);
				if (cxlBy[i] != null)
					model.setCxlBy(cxlBy[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (tLane[i] != null)
					model.setTLane(tLane[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (tVvd[i] != null)
					model.setTVvd(tVvd[i]);
				if (cxlOfc[i] != null)
					model.setCxlOfc(cxlOfc[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (cxlRsn[i] != null)
					model.setCxlRsn(cxlRsn[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgReactivateVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgReactivateVO[]
	 */
	public BkgReactivateVO[] getBkgReactivateVOs(){
		BkgReactivateVO[] vos = (BkgReactivateVO[])models.toArray(new BkgReactivateVO[models.size()]);
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
		this.ractDt = this.ractDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ractOfc = this.ractOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlDt = this.cxlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ractBy = this.ractBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polEtdDt = this.polEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlBy = this.cxlBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tLane = this.tLane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tVvd = this.tVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlOfc = this.cxlOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlRsn = this.cxlRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
