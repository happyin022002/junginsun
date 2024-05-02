/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BkgTerminalEdiJapanRfCgoVO.java
*@FileTitle : BkgTerminalEdiJapanRfCgoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.24  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgTerminalEdiJapanRfCgoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgTerminalEdiJapanRfCgoVO> models = new ArrayList<BkgTerminalEdiJapanRfCgoVO>();
	
	/* Column Info */
	private String rcSeq = null;
	/* Column Info */
	private String bkgSkdSeq = null;
	/* Column Info */
	private String fdoTemp = null;
	/* Column Info */
	private String ventUnit = null;
	/* Column Info */
	private String clngTpCd = null;
	/* Column Info */
	private String ventRto = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String snaccsTmlEdiVentRtoCd = null;
	/* Column Info */
	private String humidNo = null;
	/* Column Info */
	private String cntrVentTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cdoTemp = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String cbmPerHrQty = null;
	/* Column Info */
	private String cntrVolQty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BkgTerminalEdiJapanRfCgoVO() {}

	public BkgTerminalEdiJapanRfCgoVO(String ibflag, String pagerows, String rcSeq, String bkgSkdSeq, String fdoTemp, String clngTpCd, String ventRto, String ventUnit, String cbmPerHrQty, String snaccsTmlEdiVentRtoCd, String humidNo, String cntrVentTpCd, String bkgNo, String cdoTemp, String cntrNo, String cntrTpszCd, String cntrVolQty) {
		this.rcSeq = rcSeq;
		this.bkgSkdSeq = bkgSkdSeq;
		this.fdoTemp = fdoTemp;
		this.ventUnit = ventUnit;
		this.clngTpCd = clngTpCd;
		this.ventRto = ventRto;
		this.pagerows = pagerows;
		this.snaccsTmlEdiVentRtoCd = snaccsTmlEdiVentRtoCd;
		this.humidNo = humidNo;
		this.cntrVentTpCd = cntrVentTpCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.cdoTemp = cdoTemp;
		this.cntrNo = cntrNo;
		this.cntrTpszCd = cntrTpszCd;
		this.cbmPerHrQty = cbmPerHrQty;
		this.cntrVolQty = cntrVolQty;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rc_seq", getRcSeq());
		this.hashColumns.put("bkg_skd_seq", getBkgSkdSeq());
		this.hashColumns.put("fdo_temp", getFdoTemp());
		this.hashColumns.put("vent_unit", getVentUnit());
		this.hashColumns.put("clng_tp_cd", getClngTpCd());
		this.hashColumns.put("vent_rto", getVentRto());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("snaccs_tml_edi_vent_rto_cd", getSnaccsTmlEdiVentRtoCd());
		this.hashColumns.put("humid_no", getHumidNo());
		this.hashColumns.put("cntr_vent_tp_cd", getCntrVentTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cdo_temp", getCdoTemp());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cbm_per_hr_qty", getCbmPerHrQty());
		this.hashColumns.put("cntr_vol_qty", getCntrVolQty());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rc_seq", "rcSeq");
		this.hashFields.put("bkg_skd_seq", "bkgSkdSeq");
		this.hashFields.put("fdo_temp", "fdoTemp");
		this.hashFields.put("vent_unit", "ventUnit");
		this.hashFields.put("clng_tp_cd", "clngTpCd");
		this.hashFields.put("vent_rto", "ventRto");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("snaccs_tml_edi_vent_rto_cd", "snaccsTmlEdiVentRtoCd");
		this.hashFields.put("humid_no", "humidNo");
		this.hashFields.put("cntr_vent_tp_cd", "cntrVentTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cdo_temp", "cdoTemp");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cbm_per_hr_qty", "cbmPerHrQty");
		this.hashFields.put("cntr_vol_qty", "cntrVolQty");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rcSeq
	 */
	public String getRcSeq() {
		return this.rcSeq;
	}
	
	/**
	 * Column Info
	 * @return bkgSkdSeq
	 */
	public String getBkgSkdSeq() {
		return this.bkgSkdSeq;
	}
	
	/**
	 * Column Info
	 * @return fdoTemp
	 */
	public String getFdoTemp() {
		return this.fdoTemp;
	}
	
	/**
	 * Column Info
	 * @return ventUnit
	 */
	public String getVentUnit() {
		return this.ventUnit;
	}
	
	/**
	 * Column Info
	 * @return clngTpCd
	 */
	public String getClngTpCd() {
		return this.clngTpCd;
	}
	
	/**
	 * Column Info
	 * @return ventRto
	 */
	public String getVentRto() {
		return this.ventRto;
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
	 * @return snaccsTmlEdiVentRtoCd
	 */
	public String getSnaccsTmlEdiVentRtoCd() {
		return this.snaccsTmlEdiVentRtoCd;
	}
	
	/**
	 * Column Info
	 * @return humidNo
	 */
	public String getHumidNo() {
		return this.humidNo;
	}
	
	/**
	 * Column Info
	 * @return cntrVentTpCd
	 */
	public String getCntrVentTpCd() {
		return this.cntrVentTpCd;
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
	 * @return cdoTemp
	 */
	public String getCdoTemp() {
		return this.cdoTemp;
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
	 * @return cbmPerHrQty
	 */
	public String getCbmPerHrQty() {
		return this.cbmPerHrQty;
	}
	
	/**
	 * Column Info
	 * @return cntrVolQty
	 */
	public String getCntrVolQty() {
		return this.cntrVolQty;
	}
	

	/**
	 * Column Info
	 * @param rcSeq
	 */
	public void setRcSeq(String rcSeq) {
		this.rcSeq = rcSeq;
	}
	
	/**
	 * Column Info
	 * @param bkgSkdSeq
	 */
	public void setBkgSkdSeq(String bkgSkdSeq) {
		this.bkgSkdSeq = bkgSkdSeq;
	}
	
	/**
	 * Column Info
	 * @param fdoTemp
	 */
	public void setFdoTemp(String fdoTemp) {
		this.fdoTemp = fdoTemp;
	}
	
	/**
	 * Column Info
	 * @param ventUnit
	 */
	public void setVentUnit(String ventUnit) {
		this.ventUnit = ventUnit;
	}
	
	/**
	 * Column Info
	 * @param clngTpCd
	 */
	public void setClngTpCd(String clngTpCd) {
		this.clngTpCd = clngTpCd;
	}
	
	/**
	 * Column Info
	 * @param ventRto
	 */
	public void setVentRto(String ventRto) {
		this.ventRto = ventRto;
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
	 * @param snaccsTmlEdiVentRtoCd
	 */
	public void setSnaccsTmlEdiVentRtoCd(String snaccsTmlEdiVentRtoCd) {
		this.snaccsTmlEdiVentRtoCd = snaccsTmlEdiVentRtoCd;
	}
	
	/**
	 * Column Info
	 * @param humidNo
	 */
	public void setHumidNo(String humidNo) {
		this.humidNo = humidNo;
	}
	
	/**
	 * Column Info
	 * @param cntrVentTpCd
	 */
	public void setCntrVentTpCd(String cntrVentTpCd) {
		this.cntrVentTpCd = cntrVentTpCd;
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
	 * @param cdoTemp
	 */
	public void setCdoTemp(String cdoTemp) {
		this.cdoTemp = cdoTemp;
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
	 * @param cbmPerHrQty
	 */
	public void setCbmPerHrQty(String cbmPerHrQty) {
		this.cbmPerHrQty = cbmPerHrQty;
	}
	
	/**
	 * Column Info
	 * @param cntrVolQty
	 */
	public void setCntrVolQty(String cntrVolQty) {
		this.cntrVolQty = cntrVolQty;
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
		setRcSeq(JSPUtil.getParameter(request, prefix + "rc_seq", ""));
		setBkgSkdSeq(JSPUtil.getParameter(request, prefix + "bkg_skd_seq", ""));
		setFdoTemp(JSPUtil.getParameter(request, prefix + "fdo_temp", ""));
		setVentUnit(JSPUtil.getParameter(request, prefix + "vent_unit", ""));
		setClngTpCd(JSPUtil.getParameter(request, prefix + "clng_tp_cd", ""));
		setVentRto(JSPUtil.getParameter(request, prefix + "vent_rto", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSnaccsTmlEdiVentRtoCd(JSPUtil.getParameter(request, prefix + "snaccs_tml_edi_vent_rto_cd", ""));
		setHumidNo(JSPUtil.getParameter(request, prefix + "humid_no", ""));
		setCntrVentTpCd(JSPUtil.getParameter(request, prefix + "cntr_vent_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCdoTemp(JSPUtil.getParameter(request, prefix + "cdo_temp", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setCbmPerHrQty(JSPUtil.getParameter(request, prefix + "cbm_per_hr_qty", ""));
		setCntrVolQty(JSPUtil.getParameter(request, prefix + "cntr_vol_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgTerminalEdiJapanRfCgoVO[]
	 */
	public BkgTerminalEdiJapanRfCgoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgTerminalEdiJapanRfCgoVO[]
	 */
	public BkgTerminalEdiJapanRfCgoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgTerminalEdiJapanRfCgoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rcSeq = (JSPUtil.getParameter(request, prefix	+ "rc_seq", length));
			String[] bkgSkdSeq = (JSPUtil.getParameter(request, prefix	+ "bkg_skd_seq", length));
			String[] fdoTemp = (JSPUtil.getParameter(request, prefix	+ "fdo_temp", length));
			String[] ventUnit = (JSPUtil.getParameter(request, prefix	+ "vent_unit", length));
			String[] clngTpCd = (JSPUtil.getParameter(request, prefix	+ "clng_tp_cd", length));
			String[] ventRto = (JSPUtil.getParameter(request, prefix	+ "vent_rto", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] snaccsTmlEdiVentRtoCd = (JSPUtil.getParameter(request, prefix	+ "snaccs_tml_edi_vent_rto_cd", length));
			String[] humidNo = (JSPUtil.getParameter(request, prefix	+ "humid_no", length));
			String[] cntrVentTpCd = (JSPUtil.getParameter(request, prefix	+ "cntr_vent_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cdoTemp = (JSPUtil.getParameter(request, prefix	+ "cdo_temp", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] cbmPerHrQty = (JSPUtil.getParameter(request, prefix	+ "cbm_per_hr_qty", length));
			String[] cntrVolQty = (JSPUtil.getParameter(request, prefix	+ "cntr_vol_qty", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgTerminalEdiJapanRfCgoVO();
				if (rcSeq[i] != null)
					model.setRcSeq(rcSeq[i]);
				if (bkgSkdSeq[i] != null)
					model.setBkgSkdSeq(bkgSkdSeq[i]);
				if (fdoTemp[i] != null)
					model.setFdoTemp(fdoTemp[i]);
				if (ventUnit[i] != null)
					model.setVentUnit(ventUnit[i]);
				if (clngTpCd[i] != null)
					model.setClngTpCd(clngTpCd[i]);
				if (ventRto[i] != null)
					model.setVentRto(ventRto[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (snaccsTmlEdiVentRtoCd[i] != null)
					model.setSnaccsTmlEdiVentRtoCd(snaccsTmlEdiVentRtoCd[i]);
				if (humidNo[i] != null)
					model.setHumidNo(humidNo[i]);
				if (cntrVentTpCd[i] != null)
					model.setCntrVentTpCd(cntrVentTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cdoTemp[i] != null)
					model.setCdoTemp(cdoTemp[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (cbmPerHrQty[i] != null)
					model.setCbmPerHrQty(cbmPerHrQty[i]);
				if (cntrVolQty[i] != null)
					model.setCntrVolQty(cntrVolQty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgTerminalEdiJapanRfCgoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgTerminalEdiJapanRfCgoVO[]
	 */
	public BkgTerminalEdiJapanRfCgoVO[] getBkgTerminalEdiJapanRfCgoVOs(){
		BkgTerminalEdiJapanRfCgoVO[] vos = (BkgTerminalEdiJapanRfCgoVO[])models.toArray(new BkgTerminalEdiJapanRfCgoVO[models.size()]);
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
		this.rcSeq = this.rcSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSkdSeq = this.bkgSkdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdoTemp = this.fdoTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ventUnit = this.ventUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clngTpCd = this.clngTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ventRto = this.ventRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.snaccsTmlEdiVentRtoCd = this.snaccsTmlEdiVentRtoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.humidNo = this.humidNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVentTpCd = this.cntrVentTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cdoTemp = this.cdoTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cbmPerHrQty = this.cbmPerHrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVolQty = this.cntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
