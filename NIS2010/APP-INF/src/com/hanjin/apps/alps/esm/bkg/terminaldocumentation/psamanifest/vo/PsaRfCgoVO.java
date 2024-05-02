/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PsaRfCgoVO.java
*@FileTitle : PsaRfCgoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.08
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.02.08 박상훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo;

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
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PsaRfCgoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PsaRfCgoVO> models = new ArrayList<PsaRfCgoVO>();
	
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rfQty = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String rfTempC = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String humidNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PsaRfCgoVO() {}

	public PsaRfCgoVO(String ibflag, String pagerows, String rfTempC, String rfQty, String bkgNo, String cntrTpszCd, String humidNo) {
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.rfQty = rfQty;
		this.cntrTpszCd = cntrTpszCd;
		this.rfTempC = rfTempC;
		this.pagerows = pagerows;
		this.humidNo = humidNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rf_qty", getRfQty());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("rf_temp_c", getRfTempC());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("humid_no", getHumidNo());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rf_qty", "rfQty");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("rf_temp_c", "rfTempC");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("humid_no", "humidNo");
		
		return this.hashFields;
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
	 * @return rfQty
	 */
	public String getRfQty() {
		return this.rfQty;
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
	 * @return rfTempC
	 */
	public String getRfTempC() {
		return this.rfTempC;
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
	 * @param rfQty
	 */
	public void setRfQty(String rfQty) {
		this.rfQty = rfQty;
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
	 * @param rfTempC
	 */
	public void setRfTempC(String rfTempC) {
		this.rfTempC = rfTempC;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	public String getHumidNo() {
		return humidNo;
	}

	public void setHumidNo(String humidNo) {
		this.humidNo = humidNo;
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
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRfQty(JSPUtil.getParameter(request, prefix + "rf_qty", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setRfTempC(JSPUtil.getParameter(request, prefix + "rf_temp_c", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setHumidNo(JSPUtil.getParameter(request, prefix + "humid_no", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PsaRfCgoVO[]
	 */
	public PsaRfCgoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PsaRfCgoVO[]
	 */
	public PsaRfCgoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PsaRfCgoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rfQty = (JSPUtil.getParameter(request, prefix	+ "rf_qty", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] rfTempC = (JSPUtil.getParameter(request, prefix	+ "rf_temp_c", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] humidNo = (JSPUtil.getParameter(request, prefix	+ "humid_no", length));
			
			
			for (int i = 0; i < length; i++) {
				model = new PsaRfCgoVO();
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rfQty[i] != null)
					model.setRfQty(rfQty[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (rfTempC[i] != null)
					model.setRfTempC(rfTempC[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (humidNo[i] != null)
					model.setHumidNo(humidNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPsaRfCgoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PsaRfCgoVO[]
	 */
	public PsaRfCgoVO[] getPsaRfCgoVOs(){
		PsaRfCgoVO[] vos = (PsaRfCgoVO[])models.toArray(new PsaRfCgoVO[models.size()]);
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
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfQty = this.rfQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfTempC = this.rfTempC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.humidNo = this.humidNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
}
