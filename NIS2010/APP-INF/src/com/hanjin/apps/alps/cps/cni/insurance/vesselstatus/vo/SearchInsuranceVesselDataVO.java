/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchInsuranceVesselDataVO.java
*@FileTitle : SearchInsuranceVesselDataVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.18
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2010.01.18 윤세영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.cni.insurance.vesselstatus.vo;

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
 * @author 윤세영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchInsuranceVesselDataVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchInsuranceVesselDataVO> models = new ArrayList<SearchInsuranceVesselDataVO>();
	
	/* Column Info */
	private String vslDeDt = null;
	/* Column Info */
	private String cntNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vslRgstCntCd = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String dwtWgt = null;
	/* Column Info */
	private String grsRgstTongWgt = null;
	/* Column Info */
	private String clssNoRgstAreaNm = null;
	/* Column Info */
	private String vslLnchDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchInsuranceVesselDataVO() {}

	public SearchInsuranceVesselDataVO(String ibflag, String pagerows, String vslLnchDt, String vslRgstCntCd, String clssNoRgstAreaNm, String grsRgstTongWgt, String dwtWgt, String vslDeDt, String cntCd, String cntNm) {
		this.vslDeDt = vslDeDt;
		this.cntNm = cntNm;
		this.ibflag = ibflag;
		this.vslRgstCntCd = vslRgstCntCd;
		this.cntCd = cntCd;
		this.dwtWgt = dwtWgt;
		this.grsRgstTongWgt = grsRgstTongWgt;
		this.clssNoRgstAreaNm = clssNoRgstAreaNm;
		this.vslLnchDt = vslLnchDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_de_dt", getVslDeDt());
		this.hashColumns.put("cnt_nm", getCntNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_rgst_cnt_cd", getVslRgstCntCd());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("dwt_wgt", getDwtWgt());
		this.hashColumns.put("grs_rgst_tong_wgt", getGrsRgstTongWgt());
		this.hashColumns.put("clss_no_rgst_area_nm", getClssNoRgstAreaNm());
		this.hashColumns.put("vsl_lnch_dt", getVslLnchDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_de_dt", "vslDeDt");
		this.hashFields.put("cnt_nm", "cntNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_rgst_cnt_cd", "vslRgstCntCd");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("dwt_wgt", "dwtWgt");
		this.hashFields.put("grs_rgst_tong_wgt", "grsRgstTongWgt");
		this.hashFields.put("clss_no_rgst_area_nm", "clssNoRgstAreaNm");
		this.hashFields.put("vsl_lnch_dt", "vslLnchDt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslDeDt
	 */
	public String getVslDeDt() {
		return this.vslDeDt;
	}
	
	/**
	 * Column Info
	 * @return cntNm
	 */
	public String getCntNm() {
		return this.cntNm;
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
	 * @return vslRgstCntCd
	 */
	public String getVslRgstCntCd() {
		return this.vslRgstCntCd;
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
	 * @return dwtWgt
	 */
	public String getDwtWgt() {
		return this.dwtWgt;
	}
	
	/**
	 * Column Info
	 * @return grsRgstTongWgt
	 */
	public String getGrsRgstTongWgt() {
		return this.grsRgstTongWgt;
	}
	
	/**
	 * Column Info
	 * @return clssNoRgstAreaNm
	 */
	public String getClssNoRgstAreaNm() {
		return this.clssNoRgstAreaNm;
	}
	
	/**
	 * Column Info
	 * @return vslLnchDt
	 */
	public String getVslLnchDt() {
		return this.vslLnchDt;
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
	 * @param vslDeDt
	 */
	public void setVslDeDt(String vslDeDt) {
		this.vslDeDt = vslDeDt;
	}
	
	/**
	 * Column Info
	 * @param cntNm
	 */
	public void setCntNm(String cntNm) {
		this.cntNm = cntNm;
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
	 * @param vslRgstCntCd
	 */
	public void setVslRgstCntCd(String vslRgstCntCd) {
		this.vslRgstCntCd = vslRgstCntCd;
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
	 * @param dwtWgt
	 */
	public void setDwtWgt(String dwtWgt) {
		this.dwtWgt = dwtWgt;
	}
	
	/**
	 * Column Info
	 * @param grsRgstTongWgt
	 */
	public void setGrsRgstTongWgt(String grsRgstTongWgt) {
		this.grsRgstTongWgt = grsRgstTongWgt;
	}
	
	/**
	 * Column Info
	 * @param clssNoRgstAreaNm
	 */
	public void setClssNoRgstAreaNm(String clssNoRgstAreaNm) {
		this.clssNoRgstAreaNm = clssNoRgstAreaNm;
	}
	
	/**
	 * Column Info
	 * @param vslLnchDt
	 */
	public void setVslLnchDt(String vslLnchDt) {
		this.vslLnchDt = vslLnchDt;
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
		setVslDeDt(JSPUtil.getParameter(request, "vsl_de_dt", ""));
		setCntNm(JSPUtil.getParameter(request, "cnt_nm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVslRgstCntCd(JSPUtil.getParameter(request, "vsl_rgst_cnt_cd", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setDwtWgt(JSPUtil.getParameter(request, "dwt_wgt", ""));
		setGrsRgstTongWgt(JSPUtil.getParameter(request, "grs_rgst_tong_wgt", ""));
		setClssNoRgstAreaNm(JSPUtil.getParameter(request, "clss_no_rgst_area_nm", ""));
		setVslLnchDt(JSPUtil.getParameter(request, "vsl_lnch_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchInsuranceVesselDataVO[]
	 */
	public SearchInsuranceVesselDataVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchInsuranceVesselDataVO[]
	 */
	public SearchInsuranceVesselDataVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchInsuranceVesselDataVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslDeDt = (JSPUtil.getParameter(request, prefix	+ "vsl_de_dt", length));
			String[] cntNm = (JSPUtil.getParameter(request, prefix	+ "cnt_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vslRgstCntCd = (JSPUtil.getParameter(request, prefix	+ "vsl_rgst_cnt_cd", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] dwtWgt = (JSPUtil.getParameter(request, prefix	+ "dwt_wgt", length));
			String[] grsRgstTongWgt = (JSPUtil.getParameter(request, prefix	+ "grs_rgst_tong_wgt", length));
			String[] clssNoRgstAreaNm = (JSPUtil.getParameter(request, prefix	+ "clss_no_rgst_area_nm", length));
			String[] vslLnchDt = (JSPUtil.getParameter(request, prefix	+ "vsl_lnch_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchInsuranceVesselDataVO();
				if (vslDeDt[i] != null)
					model.setVslDeDt(vslDeDt[i]);
				if (cntNm[i] != null)
					model.setCntNm(cntNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslRgstCntCd[i] != null)
					model.setVslRgstCntCd(vslRgstCntCd[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (dwtWgt[i] != null)
					model.setDwtWgt(dwtWgt[i]);
				if (grsRgstTongWgt[i] != null)
					model.setGrsRgstTongWgt(grsRgstTongWgt[i]);
				if (clssNoRgstAreaNm[i] != null)
					model.setClssNoRgstAreaNm(clssNoRgstAreaNm[i]);
				if (vslLnchDt[i] != null)
					model.setVslLnchDt(vslLnchDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchInsuranceVesselDataVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchInsuranceVesselDataVO[]
	 */
	public SearchInsuranceVesselDataVO[] getSearchInsuranceVesselDataVOs(){
		SearchInsuranceVesselDataVO[] vos = (SearchInsuranceVesselDataVO[])models.toArray(new SearchInsuranceVesselDataVO[models.size()]);
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
		this.vslDeDt = this.vslDeDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntNm = this.cntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslRgstCntCd = this.vslRgstCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwtWgt = this.dwtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsRgstTongWgt = this.grsRgstTongWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clssNoRgstAreaNm = this.clssNoRgstAreaNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslLnchDt = this.vslLnchDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
