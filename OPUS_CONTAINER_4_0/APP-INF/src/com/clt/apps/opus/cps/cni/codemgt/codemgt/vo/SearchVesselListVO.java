/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchVesselListVO.java
*@FileTitle : SearchVesselListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.11
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.12.11 윤세영 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.cps.cni.codemgt.codemgt.vo;

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
 * @author 윤세영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchVesselListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchVesselListVO> models = new ArrayList<SearchVesselListVO>();
	
	/* Column Info */
	private String tov = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String cntNm = null;
	/* Column Info */
	private String lnchDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vslRgstCntCd = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String crrNm = null;
	/* Column Info */
	private String grsRgstTongWgt = null;
	/* Column Info */
	private String vslOwnIndCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchVesselListVO() {}

	public SearchVesselListVO(String ibflag, String pagerows, String vslCd, String vslEngNm, String tov, String vslOwnIndCd, String lnchDt, String vslRgstCntCd, String cntNm, String grsRgstTongWgt, String crrNm) {
		this.tov = tov;
		this.vslCd = vslCd;
		this.cntNm = cntNm;
		this.lnchDt = lnchDt;
		this.ibflag = ibflag;
		this.vslRgstCntCd = vslRgstCntCd;
		this.vslEngNm = vslEngNm;
		this.crrNm = crrNm;
		this.grsRgstTongWgt = grsRgstTongWgt;
		this.vslOwnIndCd = vslOwnIndCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tov", getTov());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("cnt_nm", getCntNm());
		this.hashColumns.put("lnch_dt", getLnchDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_rgst_cnt_cd", getVslRgstCntCd());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("crr_nm", getCrrNm());
		this.hashColumns.put("grs_rgst_tong_wgt", getGrsRgstTongWgt());
		this.hashColumns.put("vsl_own_ind_cd", getVslOwnIndCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tov", "tov");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("cnt_nm", "cntNm");
		this.hashFields.put("lnch_dt", "lnchDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_rgst_cnt_cd", "vslRgstCntCd");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("crr_nm", "crrNm");
		this.hashFields.put("grs_rgst_tong_wgt", "grsRgstTongWgt");
		this.hashFields.put("vsl_own_ind_cd", "vslOwnIndCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return tov
	 */
	public String getTov() {
		return this.tov;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return cntNm
	 */
	public String getCntNm() {
		return this.cntNm;
	}
	
	/**
	 * Column Info
	 * @return lnchDt
	 */
	public String getLnchDt() {
		return this.lnchDt;
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
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	
	/**
	 * Column Info
	 * @return crrNm
	 */
	public String getCrrNm() {
		return this.crrNm;
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
	 * @return vslOwnIndCd
	 */
	public String getVslOwnIndCd() {
		return this.vslOwnIndCd;
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
	 * @param tov
	 */
	public void setTov(String tov) {
		this.tov = tov;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param cntNm
	 */
	public void setCntNm(String cntNm) {
		this.cntNm = cntNm;
	}
	
	/**
	 * Column Info
	 * @param lnchDt
	 */
	public void setLnchDt(String lnchDt) {
		this.lnchDt = lnchDt;
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
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}
	
	/**
	 * Column Info
	 * @param crrNm
	 */
	public void setCrrNm(String crrNm) {
		this.crrNm = crrNm;
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
	 * @param vslOwnIndCd
	 */
	public void setVslOwnIndCd(String vslOwnIndCd) {
		this.vslOwnIndCd = vslOwnIndCd;
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
		setTov(JSPUtil.getParameter(request, "tov", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setCntNm(JSPUtil.getParameter(request, "cnt_nm", ""));
		setLnchDt(JSPUtil.getParameter(request, "lnch_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVslRgstCntCd(JSPUtil.getParameter(request, "vsl_rgst_cnt_cd", ""));
		setVslEngNm(JSPUtil.getParameter(request, "vsl_eng_nm", ""));
		setCrrNm(JSPUtil.getParameter(request, "crr_nm", ""));
		setGrsRgstTongWgt(JSPUtil.getParameter(request, "grs_rgst_tong_wgt", ""));
		setVslOwnIndCd(JSPUtil.getParameter(request, "vsl_own_ind_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchVesselListVO[]
	 */
	public SearchVesselListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchVesselListVO[]
	 */
	public SearchVesselListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchVesselListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] tov = (JSPUtil.getParameter(request, prefix	+ "tov", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] cntNm = (JSPUtil.getParameter(request, prefix	+ "cnt_nm", length));
			String[] lnchDt = (JSPUtil.getParameter(request, prefix	+ "lnch_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vslRgstCntCd = (JSPUtil.getParameter(request, prefix	+ "vsl_rgst_cnt_cd", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] crrNm = (JSPUtil.getParameter(request, prefix	+ "crr_nm", length));
			String[] grsRgstTongWgt = (JSPUtil.getParameter(request, prefix	+ "grs_rgst_tong_wgt", length));
			String[] vslOwnIndCd = (JSPUtil.getParameter(request, prefix	+ "vsl_own_ind_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchVesselListVO();
				if (tov[i] != null)
					model.setTov(tov[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (cntNm[i] != null)
					model.setCntNm(cntNm[i]);
				if (lnchDt[i] != null)
					model.setLnchDt(lnchDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslRgstCntCd[i] != null)
					model.setVslRgstCntCd(vslRgstCntCd[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (crrNm[i] != null)
					model.setCrrNm(crrNm[i]);
				if (grsRgstTongWgt[i] != null)
					model.setGrsRgstTongWgt(grsRgstTongWgt[i]);
				if (vslOwnIndCd[i] != null)
					model.setVslOwnIndCd(vslOwnIndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchVesselListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchVesselListVO[]
	 */
	public SearchVesselListVO[] getSearchVesselListVOs(){
		SearchVesselListVO[] vos = (SearchVesselListVO[])models.toArray(new SearchVesselListVO[models.size()]);
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
		this.tov = this.tov .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntNm = this.cntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnchDt = this.lnchDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslRgstCntCd = this.vslRgstCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrNm = this.crrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsRgstTongWgt = this.grsRgstTongWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslOwnIndCd = this.vslOwnIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
