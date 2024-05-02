/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EurSearchSendLogCondVO.java
*@FileTitle : EurSearchSendLogCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.13
*@LastModifier : 
*@LastVersion : 1.0
* 2014.02.13  
* 1.0 Creation
* 2014.12.29 [CHM-201432728] [IE 세관] 시스템 추가 보완 요청 사항
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.eur.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.SendLogCondVO;
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

public class EurSearchSendLogCondVO extends SendLogCondVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<EurSearchSendLogCondVO> models = new ArrayList<EurSearchSendLogCondVO>();
	
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String vvdForFr = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String eVpsEtaDt = null;
	/* Column Info */
	private String sVpsEtaDt = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String frAck = null;
	/* Page Number */
	private String pagerows = null;
	/* Page Number */
	private String pType = null;
	/* Page Number */
	private String ieVvd = null;
	/* Page Number */
	private String ioBndCd = null;
	/* Page Number */
	private String portCd = null;
	
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EurSearchSendLogCondVO() {}

	public EurSearchSendLogCondVO(String ibflag, String pagerows, String sVpsEtaDt, String eVpsEtaDt, String blNo, String cntrNo, String vvd, String frAck, String vvdForFr, String ieVvd, String ioBndCd, String portCd, String pType) {
		this.vvd = vvd;
		this.vvdForFr = vvdForFr;
		this.ibflag = ibflag;
		this.cntrNo = cntrNo;
		this.eVpsEtaDt = eVpsEtaDt;
		this.sVpsEtaDt = sVpsEtaDt;
		this.blNo = blNo;
		this.frAck = frAck;
		this.pagerows = pagerows;
		this.pType = pType;
		this.ieVvd = ieVvd;
		this.ioBndCd = ioBndCd;
		this.portCd = portCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("vvd_for_fr", getVvdForFr());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("e_vps_eta_dt", getEVpsEtaDt());
		this.hashColumns.put("s_vps_eta_dt", getSVpsEtaDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("fr_ack", getFrAck());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("p_type", getPType());
		this.hashColumns.put("ie_vvd", getIeVvd());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("port_cd", getPortCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("vvd_for_fr", "vvdForFr");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("e_vps_eta_dt", "eVpsEtaDt");
		this.hashFields.put("s_vps_eta_dt", "sVpsEtaDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("fr_ack", "frAck");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("p_type", "pType");
		this.hashFields.put("ie_vvd", "ieVvd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("port_cd", "portCd");
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
	 * Column Info
	 * @return vvdForFr
	 */
	public String getVvdForFr() {
		return this.vvdForFr;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return eVpsEtaDt
	 */
	public String getEVpsEtaDt() {
		return this.eVpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @return sVpsEtaDt
	 */
	public String getSVpsEtaDt() {
		return this.sVpsEtaDt;
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
	 * @return frAck
	 */
	public String getFrAck() {
		return this.frAck;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}

	/**
	 * Page Info
	 * @return pType
	 */
	public String getPType() {
		return this.pType;
	}
	
	/**
	 * Page Info
	 * @return ieVvd
	 */
	public String getIeVvd() {
		return this.ieVvd;
	}

	/**
	 * Page Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}

	/**
	 * Page Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
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
	 * @param vvdForFr
	 */
	public void setVvdForFr(String vvdForFr) {
		this.vvdForFr = vvdForFr;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param eVpsEtaDt
	 */
	public void setEVpsEtaDt(String eVpsEtaDt) {
		this.eVpsEtaDt = eVpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @param sVpsEtaDt
	 */
	public void setSVpsEtaDt(String sVpsEtaDt) {
		this.sVpsEtaDt = sVpsEtaDt;
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
	 * @param frAck
	 */
	public void setFrAck(String frAck) {
		this.frAck = frAck;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}	
	
	/**
	 * Page Info
	 * @param pType
	 */
	public void setPType(String pType) {
		this.pType = pType;
	}
	
	/**
	 * Page Info
	 * @param ieVvd
	 */
	public void setIeVvd(String ieVvd) {
		this.ieVvd = ieVvd;
	}
	
	/**
	 * Page Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Page Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
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
		setVvdForFr(JSPUtil.getParameter(request, prefix + "vvd_for_fr", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setEVpsEtaDt(JSPUtil.getParameter(request, prefix + "e_vps_eta_dt", ""));
		setSVpsEtaDt(JSPUtil.getParameter(request, prefix + "s_vps_eta_dt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setFrAck(JSPUtil.getParameter(request, prefix + "fr_ack", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPType(JSPUtil.getParameter(request, prefix + "p_type", ""));
		setIeVvd(JSPUtil.getParameter(request, prefix + "ie_vvd", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EurSearchSendLogCondVO[]
	 */
	public EurSearchSendLogCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EurSearchSendLogCondVO[]
	 */
	public EurSearchSendLogCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EurSearchSendLogCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] vvdForFr = (JSPUtil.getParameter(request, prefix	+ "vvd_for_fr", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] eVpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "e_vps_eta_dt", length));
			String[] sVpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "s_vps_eta_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] frAck = (JSPUtil.getParameter(request, prefix	+ "fr_ack", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pType = (JSPUtil.getParameter(request, prefix	+ "p_type", length));
			String[] ieVvd = (JSPUtil.getParameter(request, prefix	+ "ie_vvd", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new EurSearchSendLogCondVO();
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (vvdForFr[i] != null)
					model.setVvdForFr(vvdForFr[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (eVpsEtaDt[i] != null)
					model.setEVpsEtaDt(eVpsEtaDt[i]);
				if (sVpsEtaDt[i] != null)
					model.setSVpsEtaDt(sVpsEtaDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (frAck[i] != null)
					model.setFrAck(frAck[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pType[i] != null)
					model.setPType(pType[i]);
				if (ieVvd[i] != null)
					model.setIeVvd(ieVvd[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEurSearchSendLogCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EurSearchSendLogCondVO[]
	 */
	public EurSearchSendLogCondVO[] getEurSearchSendLogCondVOs(){
		EurSearchSendLogCondVO[] vos = (EurSearchSendLogCondVO[])models.toArray(new EurSearchSendLogCondVO[models.size()]);
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
		this.vvdForFr = this.vvdForFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eVpsEtaDt = this.eVpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVpsEtaDt = this.sVpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frAck = this.frAck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pType = this.pType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ieVvd = this.ieVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
