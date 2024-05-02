/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchEstimationListVO.java
*@FileTitle : SearchEstimationListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.18
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.18  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchEstimationListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchEstimationListVO> models = new ArrayList<SearchEstimationListVO>();
	
	/* Column Info */
	private String csGrpId = null;
	/* Column Info */
	private String eveLoc = null;
	/* Column Info */
	private String ediStsCd = null;
	/* Column Info */
	private String delays = null;
	/* Column Info */
	private String fmaDt = null;
	/* Column Info */
	private String custStsCd = null;
	/* Column Info */
	private String mycust = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String eveSel = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String estmDt = null;
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String toaDt = null;
	/* Column Info */
	private String fmdDt = null;
	/* Column Info */
	private String actDt = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String datRcvDt = null;
	/* Column Info */
	private String todDt = null;
	/* Column Info */
	private String nodCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchEstimationListVO() {}

	public SearchEstimationListVO(String ibflag, String pagerows, String bkgNo, String blNo, String cntrNo, String ediStsCd, String custStsCd, String nodCd, String vvd, String estmDt, String actDt, String delays, String datRcvDt, String mycust, String eveSel, String eveLoc, String fmdDt, String fmaDt, String toaDt, String todDt,String csGrpId) {
		this.csGrpId =csGrpId;
		this.eveLoc = eveLoc;
		this.ediStsCd = ediStsCd;
		this.delays = delays;
		this.fmaDt = fmaDt;
		this.custStsCd = custStsCd;
		this.mycust = mycust;
		this.blNo = blNo;
		this.eveSel = eveSel;
		this.pagerows = pagerows;
		this.estmDt = estmDt;
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.toaDt = toaDt;
		this.fmdDt = fmdDt;
		this.actDt = actDt;
		this.cntrNo = cntrNo;
		this.datRcvDt = datRcvDt;
		this.todDt = todDt;
		this.nodCd = nodCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cs_grp_id", getCsGrpId());
		this.hashColumns.put("eve_loc", getEveLoc());
		this.hashColumns.put("edi_sts_cd", getEdiStsCd());
		this.hashColumns.put("delays", getDelays());
		this.hashColumns.put("fma_dt", getFmaDt());
		this.hashColumns.put("cust_sts_cd", getCustStsCd());
		this.hashColumns.put("mycust", getMycust());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("eve_sel", getEveSel());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("estm_dt", getEstmDt());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("toa_dt", getToaDt());
		this.hashColumns.put("fmd_dt", getFmdDt());
		this.hashColumns.put("act_dt", getActDt());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("dat_rcv_dt", getDatRcvDt());
		this.hashColumns.put("tod_dt", getTodDt());
		this.hashColumns.put("nod_cd", getNodCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cs_grp_id", "csGrpId");
		this.hashFields.put("eve_loc", "eveLoc");
		this.hashFields.put("edi_sts_cd", "ediStsCd");
		this.hashFields.put("delays", "delays");
		this.hashFields.put("fma_dt", "fmaDt");
		this.hashFields.put("cust_sts_cd", "custStsCd");
		this.hashFields.put("mycust", "mycust");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("eve_sel", "eveSel");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("estm_dt", "estmDt");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("toa_dt", "toaDt");
		this.hashFields.put("fmd_dt", "fmdDt");
		this.hashFields.put("act_dt", "actDt");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("dat_rcv_dt", "datRcvDt");
		this.hashFields.put("tod_dt", "todDt");
		this.hashFields.put("nod_cd", "nodCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return csGrpId
	 */
	public String getCsGrpId() {
		return this.csGrpId;
	}
	
	/**
	 * Column Info
	 * @return eveLoc
	 */
	public String getEveLoc() {
		return this.eveLoc;
	}
	
	/**
	 * Column Info
	 * @return ediStsCd
	 */
	public String getEdiStsCd() {
		return this.ediStsCd;
	}
	
	/**
	 * Column Info
	 * @return delays
	 */
	public String getDelays() {
		return this.delays;
	}
	
	/**
	 * Column Info
	 * @return fmaDt
	 */
	public String getFmaDt() {
		return this.fmaDt;
	}
	
	/**
	 * Column Info
	 * @return custStsCd
	 */
	public String getCustStsCd() {
		return this.custStsCd;
	}
	
	/**
	 * Column Info
	 * @return mycust
	 */
	public String getMycust() {
		return this.mycust;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return eveSel
	 */
	public String getEveSel() {
		return this.eveSel;
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
	 * @return estmDt
	 */
	public String getEstmDt() {
		return this.estmDt;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return toaDt
	 */
	public String getToaDt() {
		return this.toaDt;
	}
	
	/**
	 * Column Info
	 * @return fmdDt
	 */
	public String getFmdDt() {
		return this.fmdDt;
	}
	
	/**
	 * Column Info
	 * @return actDt
	 */
	public String getActDt() {
		return this.actDt;
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
	 * @return datRcvDt
	 */
	public String getDatRcvDt() {
		return this.datRcvDt;
	}
	
	/**
	 * Column Info
	 * @return todDt
	 */
	public String getTodDt() {
		return this.todDt;
	}
	
	/**
	 * Column Info
	 * @return nodCd
	 */
	public String getNodCd() {
		return this.nodCd;
	}
	
	
	/**
	 * Column Info
	 * @param csGrpId
	 */
	public void setCsGrpId(String csGrpId) {
		this.csGrpId = csGrpId;
	}

	/**
	 * Column Info
	 * @param eveLoc
	 */
	public void setEveLoc(String eveLoc) {
		this.eveLoc = eveLoc;
	}
	
	/**
	 * Column Info
	 * @param ediStsCd
	 */
	public void setEdiStsCd(String ediStsCd) {
		this.ediStsCd = ediStsCd;
	}
	
	/**
	 * Column Info
	 * @param delays
	 */
	public void setDelays(String delays) {
		this.delays = delays;
	}
	
	/**
	 * Column Info
	 * @param fmaDt
	 */
	public void setFmaDt(String fmaDt) {
		this.fmaDt = fmaDt;
	}
	
	/**
	 * Column Info
	 * @param custStsCd
	 */
	public void setCustStsCd(String custStsCd) {
		this.custStsCd = custStsCd;
	}
	
	/**
	 * Column Info
	 * @param mycust
	 */
	public void setMycust(String mycust) {
		this.mycust = mycust;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param eveSel
	 */
	public void setEveSel(String eveSel) {
		this.eveSel = eveSel;
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
	 * @param estmDt
	 */
	public void setEstmDt(String estmDt) {
		this.estmDt = estmDt;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param toaDt
	 */
	public void setToaDt(String toaDt) {
		this.toaDt = toaDt;
	}
	
	/**
	 * Column Info
	 * @param fmdDt
	 */
	public void setFmdDt(String fmdDt) {
		this.fmdDt = fmdDt;
	}
	
	/**
	 * Column Info
	 * @param actDt
	 */
	public void setActDt(String actDt) {
		this.actDt = actDt;
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
	 * @param datRcvDt
	 */
	public void setDatRcvDt(String datRcvDt) {
		this.datRcvDt = datRcvDt;
	}
	
	/**
	 * Column Info
	 * @param todDt
	 */
	public void setTodDt(String todDt) {
		this.todDt = todDt;
	}
	
	/**
	 * Column Info
	 * @param nodCd
	 */
	public void setNodCd(String nodCd) {
		this.nodCd = nodCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCsGrpId(JSPUtil.getParameter(request, "cs_grp_id", ""));
		setEveLoc(JSPUtil.getParameter(request, "eve_loc", ""));
		setEdiStsCd(JSPUtil.getParameter(request, "edi_sts_cd", ""));
		setDelays(JSPUtil.getParameter(request, "delays", ""));
		setFmaDt(JSPUtil.getParameter(request, "fma_dt", ""));
		setCustStsCd(JSPUtil.getParameter(request, "cust_sts_cd", ""));
		setMycust(JSPUtil.getParameter(request, "mycust", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setEveSel(JSPUtil.getParameter(request, "eve_sel", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setEstmDt(JSPUtil.getParameter(request, "estm_dt", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setToaDt(JSPUtil.getParameter(request, "toa_dt", ""));
		setFmdDt(JSPUtil.getParameter(request, "fmd_dt", ""));
		setActDt(JSPUtil.getParameter(request, "act_dt", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setDatRcvDt(JSPUtil.getParameter(request, "dat_rcv_dt", ""));
		setTodDt(JSPUtil.getParameter(request, "tod_dt", ""));
		setNodCd(JSPUtil.getParameter(request, "nod_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchEstimationListVO[]
	 */
	public SearchEstimationListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchEstimationListVO[]
	 */
	public SearchEstimationListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchEstimationListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] csGrpId = (JSPUtil.getParameter(request, prefix	+ "cs_grp_id", length));
			String[] eveLoc = (JSPUtil.getParameter(request, prefix	+ "eve_loc", length));
			String[] ediStsCd = (JSPUtil.getParameter(request, prefix	+ "edi_sts_cd", length));
			String[] delays = (JSPUtil.getParameter(request, prefix	+ "delays", length));
			String[] fmaDt = (JSPUtil.getParameter(request, prefix	+ "fma_dt", length));
			String[] custStsCd = (JSPUtil.getParameter(request, prefix	+ "cust_sts_cd", length));
			String[] mycust = (JSPUtil.getParameter(request, prefix	+ "mycust", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] eveSel = (JSPUtil.getParameter(request, prefix	+ "eve_sel", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] estmDt = (JSPUtil.getParameter(request, prefix	+ "estm_dt", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] toaDt = (JSPUtil.getParameter(request, prefix	+ "toa_dt", length));
			String[] fmdDt = (JSPUtil.getParameter(request, prefix	+ "fmd_dt", length));
			String[] actDt = (JSPUtil.getParameter(request, prefix	+ "act_dt", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] datRcvDt = (JSPUtil.getParameter(request, prefix	+ "dat_rcv_dt", length));
			String[] todDt = (JSPUtil.getParameter(request, prefix	+ "tod_dt", length));
			String[] nodCd = (JSPUtil.getParameter(request, prefix	+ "nod_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchEstimationListVO();
				if (csGrpId[i] != null)
					model.setCsGrpId(csGrpId[i]);
				if (eveLoc[i] != null)
					model.setEveLoc(eveLoc[i]);
				if (ediStsCd[i] != null)
					model.setEdiStsCd(ediStsCd[i]);
				if (delays[i] != null)
					model.setDelays(delays[i]);
				if (fmaDt[i] != null)
					model.setFmaDt(fmaDt[i]);
				if (custStsCd[i] != null)
					model.setCustStsCd(custStsCd[i]);
				if (mycust[i] != null)
					model.setMycust(mycust[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (eveSel[i] != null)
					model.setEveSel(eveSel[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (estmDt[i] != null)
					model.setEstmDt(estmDt[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (toaDt[i] != null)
					model.setToaDt(toaDt[i]);
				if (fmdDt[i] != null)
					model.setFmdDt(fmdDt[i]);
				if (actDt[i] != null)
					model.setActDt(actDt[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (datRcvDt[i] != null)
					model.setDatRcvDt(datRcvDt[i]);
				if (todDt[i] != null)
					model.setTodDt(todDt[i]);
				if (nodCd[i] != null)
					model.setNodCd(nodCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchEstimationListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchEstimationListVO[]
	 */
	public SearchEstimationListVO[] getSearchEstimationListVOs(){
		SearchEstimationListVO[] vos = (SearchEstimationListVO[])models.toArray(new SearchEstimationListVO[models.size()]);
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
		this.csGrpId = this.csGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eveLoc = this.eveLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediStsCd = this.ediStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delays = this.delays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmaDt = this.fmaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custStsCd = this.custStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mycust = this.mycust .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eveSel = this.eveSel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmDt = this.estmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toaDt = this.toaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmdDt = this.fmdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDt = this.actDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.datRcvDt = this.datRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.todDt = this.todDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodCd = this.nodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
