/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : Eur24VesselArrivalTransmitVO.java
*@FileTitle : Eur24VesselArrivalTransmitVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.27
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.05.27 김보배 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.VesselArrivalTransmitVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김보배
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class Eur24VesselArrivalTransmitVO extends VesselArrivalTransmitVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<Eur24VesselArrivalTransmitVO> models = new ArrayList<Eur24VesselArrivalTransmitVO>();
	
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String form1CvyRefNo = null;
	/* Column Info */
	private String form1CstmsPortCd = null;
	/* Column Info */
	private String cvyRefNo = null;
	/* Column Info */
	private String form1Vvd = null;
	/* Column Info */
	private String pType = null;
	/* Column Info */
	private String cstmsPortCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Page Number */
	private String blNo = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public Eur24VesselArrivalTransmitVO() {}

	public Eur24VesselArrivalTransmitVO(String ibflag, String pagerows, String vvd, String form1CvyRefNo, String cvyRefNo, String form1Vvd, String cstmsPortCd, String form1CstmsPortCd, String pType, String blNo) {
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.form1CvyRefNo = form1CvyRefNo;
		this.form1CstmsPortCd = form1CstmsPortCd;
		this.cvyRefNo = cvyRefNo;
		this.form1Vvd = form1Vvd;
		this.pType = pType;
		this.cstmsPortCd = cstmsPortCd;
		this.pagerows = pagerows;
		this.blNo = blNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("form1_cvy_ref_no", getForm1CvyRefNo());
		this.hashColumns.put("form1_cstms_port_cd", getForm1CstmsPortCd());
		this.hashColumns.put("cvy_ref_no", getCvyRefNo());
		this.hashColumns.put("form1_vvd", getForm1Vvd());
		this.hashColumns.put("p_type", getPType());
		this.hashColumns.put("cstms_port_cd", getCstmsPortCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bl_no", getBlNo());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("form1_cvy_ref_no", "form1CvyRefNo");
		this.hashFields.put("form1_cstms_port_cd", "form1CstmsPortCd");
		this.hashFields.put("cvy_ref_no", "cvyRefNo");
		this.hashFields.put("form1_vvd", "form1Vvd");
		this.hashFields.put("p_type", "pType");
		this.hashFields.put("cstms_port_cd", "cstmsPortCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bl_no", "blNo");
		return this.hashFields;
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
	 * @return form1CvyRefNo
	 */
	public String getForm1CvyRefNo() {
		return this.form1CvyRefNo;
	}
	
	/**
	 * Column Info
	 * @return form1CstmsPortCd
	 */
	public String getForm1CstmsPortCd() {
		return this.form1CstmsPortCd;
	}
	
	/**
	 * Column Info
	 * @return cvyRefNo
	 */
	public String getCvyRefNo() {
		return this.cvyRefNo;
	}
	
	/**
	 * Column Info
	 * @return form1Vvd
	 */
	public String getForm1Vvd() {
		return this.form1Vvd;
	}
	
	/**
	 * Column Info
	 * @return pType
	 */
	public String getPType() {
		return this.pType;
	}
	
	/**
	 * Column Info
	 * @return cstmsPortCd
	 */
	public String getCstmsPortCd() {
		return this.cstmsPortCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Page Number
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @param form1CvyRefNo
	 */
	public void setForm1CvyRefNo(String form1CvyRefNo) {
		this.form1CvyRefNo = form1CvyRefNo;
	}
	
	/**
	 * Column Info
	 * @param form1CstmsPortCd
	 */
	public void setForm1CstmsPortCd(String form1CstmsPortCd) {
		this.form1CstmsPortCd = form1CstmsPortCd;
	}
	
	/**
	 * Column Info
	 * @param cvyRefNo
	 */
	public void setCvyRefNo(String cvyRefNo) {
		this.cvyRefNo = cvyRefNo;
	}
	
	/**
	 * Column Info
	 * @param form1Vvd
	 */
	public void setForm1Vvd(String form1Vvd) {
		this.form1Vvd = form1Vvd;
	}
	
	/**
	 * Column Info
	 * @param pType
	 */
	public void setPType(String pType) {
		this.pType = pType;
	}
	
	/**
	 * Column Info
	 * @param cstmsPortCd
	 */
	public void setCstmsPortCd(String cstmsPortCd) {
		this.cstmsPortCd = cstmsPortCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Page Number
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setForm1CvyRefNo(JSPUtil.getParameter(request, prefix + "form1_cvy_ref_no", ""));
		setForm1CstmsPortCd(JSPUtil.getParameter(request, prefix + "form1_cstms_port_cd", ""));
		setCvyRefNo(JSPUtil.getParameter(request, prefix + "cvy_ref_no", ""));
		setForm1Vvd(JSPUtil.getParameter(request, prefix + "form1_vvd", ""));
		setPType(JSPUtil.getParameter(request, prefix + "p_type", ""));
		setCstmsPortCd(JSPUtil.getParameter(request, prefix + "cstms_port_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Eur24VesselArrivalTransmitVO[]
	 */
	public Eur24VesselArrivalTransmitVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return Eur24VesselArrivalTransmitVO[]
	 */
	public Eur24VesselArrivalTransmitVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Eur24VesselArrivalTransmitVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] form1CvyRefNo = (JSPUtil.getParameter(request, prefix	+ "form1_cvy_ref_no", length));
			String[] form1CstmsPortCd = (JSPUtil.getParameter(request, prefix	+ "form1_cstms_port_cd", length));
			String[] cvyRefNo = (JSPUtil.getParameter(request, prefix	+ "cvy_ref_no", length));
			String[] form1Vvd = (JSPUtil.getParameter(request, prefix	+ "form1_vvd", length));
			String[] pType = (JSPUtil.getParameter(request, prefix	+ "p_type", length));
			String[] cstmsPortCd = (JSPUtil.getParameter(request, prefix	+ "cstms_port_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new Eur24VesselArrivalTransmitVO();
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (form1CvyRefNo[i] != null)
					model.setForm1CvyRefNo(form1CvyRefNo[i]);
				if (form1CstmsPortCd[i] != null)
					model.setForm1CstmsPortCd(form1CstmsPortCd[i]);
				if (cvyRefNo[i] != null)
					model.setCvyRefNo(cvyRefNo[i]);
				if (form1Vvd[i] != null)
					model.setForm1Vvd(form1Vvd[i]);
				if (pType[i] != null)
					model.setPType(pType[i]);
				if (cstmsPortCd[i] != null)
					model.setCstmsPortCd(cstmsPortCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEur24VesselArrivalTransmitVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Eur24VesselArrivalTransmitVO[]
	 */
	public Eur24VesselArrivalTransmitVO[] getEur24VesselArrivalTransmitVOs(){
		Eur24VesselArrivalTransmitVO[] vos = (Eur24VesselArrivalTransmitVO[])models.toArray(new Eur24VesselArrivalTransmitVO[models.size()]);
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
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.form1CvyRefNo = this.form1CvyRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.form1CstmsPortCd = this.form1CstmsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvyRefNo = this.cvyRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.form1Vvd = this.form1Vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pType = this.pType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsPortCd = this.cstmsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
