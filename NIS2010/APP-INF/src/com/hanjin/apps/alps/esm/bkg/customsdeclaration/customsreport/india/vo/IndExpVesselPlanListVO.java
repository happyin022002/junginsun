/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : IndExpVesselPlanListVO.java
*@FileTitle : IndExpVesselPlanListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.02.24  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.india.vo;

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

public class IndExpVesselPlanListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<IndExpVesselPlanListVO> models = new ArrayList<IndExpVesselPlanListVO>();
	
	/* Column Info */
	private String imo = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String cnmvCycNo = null;
	/* Column Info */
	private String shipper = null;
	/* Column Info */
	private String origin = null;
	/* Column Info */
	private String polNodCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String tsLoc = null;
	/* Column Info */
	private String eventDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String sts = null;
	/* Column Info */
	private String fpd = null;
	/* Column Info */
	private String xterRmk = null;
	/* Column Info */
	private String docsDt = null;
	/* Column Info */
	private String isoCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public IndExpVesselPlanListVO() {}

	public IndExpVesselPlanListVO(String ibflag, String pagerows, String bkgNo, String cnmvCycNo, String polNodCd, String bkgCgoTpCd, String cntrNo, String measQty, String isoCd, String imo, String tsLoc, String sts, String fpd, String origin, String vvd, String shipper, String docsDt, String eventDt, String xterRmk) {
		this.imo = imo;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.cnmvCycNo = cnmvCycNo;
		this.shipper = shipper;
		this.origin = origin;
		this.polNodCd = polNodCd;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.tsLoc = tsLoc;
		this.eventDt = eventDt;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.cntrNo = cntrNo;
		this.measQty = measQty;
		this.sts = sts;
		this.fpd = fpd;
		this.xterRmk = xterRmk;
		this.docsDt = docsDt;
		this.isoCd = isoCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("imo", getImo());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("cnmv_cyc_no", getCnmvCycNo());
		this.hashColumns.put("shipper", getShipper());
		this.hashColumns.put("origin", getOrigin());
		this.hashColumns.put("pol_nod_cd", getPolNodCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ts_loc", getTsLoc());
		this.hashColumns.put("event_dt", getEventDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("sts", getSts());
		this.hashColumns.put("fpd", getFpd());
		this.hashColumns.put("xter_rmk", getXterRmk());
		this.hashColumns.put("docs_dt", getDocsDt());
		this.hashColumns.put("iso_cd", getIsoCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("imo", "imo");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("cnmv_cyc_no", "cnmvCycNo");
		this.hashFields.put("shipper", "shipper");
		this.hashFields.put("origin", "origin");
		this.hashFields.put("pol_nod_cd", "polNodCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ts_loc", "tsLoc");
		this.hashFields.put("event_dt", "eventDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("sts", "sts");
		this.hashFields.put("fpd", "fpd");
		this.hashFields.put("xter_rmk", "xterRmk");
		this.hashFields.put("docs_dt", "docsDt");
		this.hashFields.put("iso_cd", "isoCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return imo
	 */
	public String getImo() {
		return this.imo;
	}
	
	/**
	 * Column Info
	 * @return bkgCgoTpCd
	 */
	public String getBkgCgoTpCd() {
		return this.bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return cnmvCycNo
	 */
	public String getCnmvCycNo() {
		return this.cnmvCycNo;
	}
	
	/**
	 * Column Info
	 * @return shipper
	 */
	public String getShipper() {
		return this.shipper;
	}
	
	/**
	 * Column Info
	 * @return origin
	 */
	public String getOrigin() {
		return this.origin;
	}
	
	/**
	 * Column Info
	 * @return polNodCd
	 */
	public String getPolNodCd() {
		return this.polNodCd;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return tsLoc
	 */
	public String getTsLoc() {
		return this.tsLoc;
	}
	
	/**
	 * Column Info
	 * @return eventDt
	 */
	public String getEventDt() {
		return this.eventDt;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return measQty
	 */
	public String getMeasQty() {
		return this.measQty;
	}
	
	/**
	 * Column Info
	 * @return sts
	 */
	public String getSts() {
		return this.sts;
	}
	
	/**
	 * Column Info
	 * @return fpd
	 */
	public String getFpd() {
		return this.fpd;
	}
	
	/**
	 * Column Info
	 * @return xterRmk
	 */
	public String getXterRmk() {
		return this.xterRmk;
	}
	
	/**
	 * Column Info
	 * @return docsDt
	 */
	public String getDocsDt() {
		return this.docsDt;
	}
	
	/**
	 * Column Info
	 * @return isoCd
	 */
	public String getIsoCd() {
		return this.isoCd;
	}
	

	/**
	 * Column Info
	 * @param imo
	 */
	public void setImo(String imo) {
		this.imo = imo;
	}
	
	/**
	 * Column Info
	 * @param bkgCgoTpCd
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param cnmvCycNo
	 */
	public void setCnmvCycNo(String cnmvCycNo) {
		this.cnmvCycNo = cnmvCycNo;
	}
	
	/**
	 * Column Info
	 * @param shipper
	 */
	public void setShipper(String shipper) {
		this.shipper = shipper;
	}
	
	/**
	 * Column Info
	 * @param origin
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	/**
	 * Column Info
	 * @param polNodCd
	 */
	public void setPolNodCd(String polNodCd) {
		this.polNodCd = polNodCd;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param tsLoc
	 */
	public void setTsLoc(String tsLoc) {
		this.tsLoc = tsLoc;
	}
	
	/**
	 * Column Info
	 * @param eventDt
	 */
	public void setEventDt(String eventDt) {
		this.eventDt = eventDt;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param measQty
	 */
	public void setMeasQty(String measQty) {
		this.measQty = measQty;
	}
	
	/**
	 * Column Info
	 * @param sts
	 */
	public void setSts(String sts) {
		this.sts = sts;
	}
	
	/**
	 * Column Info
	 * @param fpd
	 */
	public void setFpd(String fpd) {
		this.fpd = fpd;
	}
	
	/**
	 * Column Info
	 * @param xterRmk
	 */
	public void setXterRmk(String xterRmk) {
		this.xterRmk = xterRmk;
	}
	
	/**
	 * Column Info
	 * @param docsDt
	 */
	public void setDocsDt(String docsDt) {
		this.docsDt = docsDt;
	}
	
	/**
	 * Column Info
	 * @param isoCd
	 */
	public void setIsoCd(String isoCd) {
		this.isoCd = isoCd;
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
		setImo(JSPUtil.getParameter(request, prefix + "imo", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
		setCnmvCycNo(JSPUtil.getParameter(request, prefix + "cnmv_cyc_no", ""));
		setShipper(JSPUtil.getParameter(request, prefix + "shipper", ""));
		setOrigin(JSPUtil.getParameter(request, prefix + "origin", ""));
		setPolNodCd(JSPUtil.getParameter(request, prefix + "pol_nod_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setTsLoc(JSPUtil.getParameter(request, prefix + "ts_loc", ""));
		setEventDt(JSPUtil.getParameter(request, prefix + "event_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
		setSts(JSPUtil.getParameter(request, prefix + "sts", ""));
		setFpd(JSPUtil.getParameter(request, prefix + "fpd", ""));
		setXterRmk(JSPUtil.getParameter(request, prefix + "xter_rmk", ""));
		setDocsDt(JSPUtil.getParameter(request, prefix + "docs_dt", ""));
		setIsoCd(JSPUtil.getParameter(request, prefix + "iso_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IndExpVesselPlanListVO[]
	 */
	public IndExpVesselPlanListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IndExpVesselPlanListVO[]
	 */
	public IndExpVesselPlanListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		IndExpVesselPlanListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] imo = (JSPUtil.getParameter(request, prefix	+ "imo", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] cnmvCycNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_cyc_no", length));
			String[] shipper = (JSPUtil.getParameter(request, prefix	+ "shipper", length));
			String[] origin = (JSPUtil.getParameter(request, prefix	+ "origin", length));
			String[] polNodCd = (JSPUtil.getParameter(request, prefix	+ "pol_nod_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] tsLoc = (JSPUtil.getParameter(request, prefix	+ "ts_loc", length));
			String[] eventDt = (JSPUtil.getParameter(request, prefix	+ "event_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] sts = (JSPUtil.getParameter(request, prefix	+ "sts", length));
			String[] fpd = (JSPUtil.getParameter(request, prefix	+ "fpd", length));
			String[] xterRmk = (JSPUtil.getParameter(request, prefix	+ "xter_rmk", length));
			String[] docsDt = (JSPUtil.getParameter(request, prefix	+ "docs_dt", length));
			String[] isoCd = (JSPUtil.getParameter(request, prefix	+ "iso_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new IndExpVesselPlanListVO();
				if (imo[i] != null)
					model.setImo(imo[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (cnmvCycNo[i] != null)
					model.setCnmvCycNo(cnmvCycNo[i]);
				if (shipper[i] != null)
					model.setShipper(shipper[i]);
				if (origin[i] != null)
					model.setOrigin(origin[i]);
				if (polNodCd[i] != null)
					model.setPolNodCd(polNodCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (tsLoc[i] != null)
					model.setTsLoc(tsLoc[i]);
				if (eventDt[i] != null)
					model.setEventDt(eventDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (sts[i] != null)
					model.setSts(sts[i]);
				if (fpd[i] != null)
					model.setFpd(fpd[i]);
				if (xterRmk[i] != null)
					model.setXterRmk(xterRmk[i]);
				if (docsDt[i] != null)
					model.setDocsDt(docsDt[i]);
				if (isoCd[i] != null)
					model.setIsoCd(isoCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getIndExpVesselPlanListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return IndExpVesselPlanListVO[]
	 */
	public IndExpVesselPlanListVO[] getIndExpVesselPlanListVOs(){
		IndExpVesselPlanListVO[] vos = (IndExpVesselPlanListVO[])models.toArray(new IndExpVesselPlanListVO[models.size()]);
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
		this.imo = this.imo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvCycNo = this.cnmvCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipper = this.shipper .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.origin = this.origin .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polNodCd = this.polNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsLoc = this.tsLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eventDt = this.eventDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sts = this.sts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fpd = this.fpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRmk = this.xterRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docsDt = this.docsDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isoCd = this.isoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
