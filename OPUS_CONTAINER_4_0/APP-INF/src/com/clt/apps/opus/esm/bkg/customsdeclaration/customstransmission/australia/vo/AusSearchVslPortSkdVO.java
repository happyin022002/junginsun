/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AusSearchVslPortSkdVO.java
*@FileTitle : AusSearchVslPortSkdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.20  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo;

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

public class AusSearchVslPortSkdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AusSearchVslPortSkdVO> models = new ArrayList<AusSearchVslPortSkdVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String fPortNm = null;
	/* Column Info */
	private String ibCssmVoyNo = null;
	/* Column Info */
	private String fPort = null;
	/* Column Info */
	private String obCssmVoyNo = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AusSearchVslPortSkdVO() {}

	public AusSearchVslPortSkdVO(String ibflag, String pagerows, String fPort, String fPortNm, String ibCssmVoyNo, String obCssmVoyNo, String vpsEtaDt, String vpsEtdDt) {
		this.ibflag = ibflag;
		this.vpsEtdDt = vpsEtdDt;
		this.fPortNm = fPortNm;
		this.ibCssmVoyNo = ibCssmVoyNo;
		this.fPort = fPort;
		this.obCssmVoyNo = obCssmVoyNo;
		this.vpsEtaDt = vpsEtaDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("f_port_nm", getFPortNm());
		this.hashColumns.put("ib_cssm_voy_no", getIbCssmVoyNo());
		this.hashColumns.put("f_port", getFPort());
		this.hashColumns.put("ob_cssm_voy_no", getObCssmVoyNo());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("f_port_nm", "fPortNm");
		this.hashFields.put("ib_cssm_voy_no", "ibCssmVoyNo");
		this.hashFields.put("f_port", "fPort");
		this.hashFields.put("ob_cssm_voy_no", "obCssmVoyNo");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return vpsEtdDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @return fPortNm
	 */
	public String getFPortNm() {
		return this.fPortNm;
	}
	
	/**
	 * Column Info
	 * @return ibCssmVoyNo
	 */
	public String getIbCssmVoyNo() {
		return this.ibCssmVoyNo;
	}
	
	/**
	 * Column Info
	 * @return fPort
	 */
	public String getFPort() {
		return this.fPort;
	}
	
	/**
	 * Column Info
	 * @return obCssmVoyNo
	 */
	public String getObCssmVoyNo() {
		return this.obCssmVoyNo;
	}
	
	/**
	 * Column Info
	 * @return vpsEtaDt
	 */
	public String getVpsEtaDt() {
		return this.vpsEtaDt;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @param vpsEtdDt
	 */
	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @param fPortNm
	 */
	public void setFPortNm(String fPortNm) {
		this.fPortNm = fPortNm;
	}
	
	/**
	 * Column Info
	 * @param ibCssmVoyNo
	 */
	public void setIbCssmVoyNo(String ibCssmVoyNo) {
		this.ibCssmVoyNo = ibCssmVoyNo;
	}
	
	/**
	 * Column Info
	 * @param fPort
	 */
	public void setFPort(String fPort) {
		this.fPort = fPort;
	}
	
	/**
	 * Column Info
	 * @param obCssmVoyNo
	 */
	public void setObCssmVoyNo(String obCssmVoyNo) {
		this.obCssmVoyNo = obCssmVoyNo;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaDt
	 */
	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setFPortNm(JSPUtil.getParameter(request, prefix + "f_port_nm", ""));
		setIbCssmVoyNo(JSPUtil.getParameter(request, prefix + "ib_cssm_voy_no", ""));
		setFPort(JSPUtil.getParameter(request, prefix + "f_port", ""));
		setObCssmVoyNo(JSPUtil.getParameter(request, prefix + "ob_cssm_voy_no", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, prefix + "vps_eta_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AusSearchVslPortSkdVO[]
	 */
	public AusSearchVslPortSkdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AusSearchVslPortSkdVO[]
	 */
	public AusSearchVslPortSkdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AusSearchVslPortSkdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] fPortNm = (JSPUtil.getParameter(request, prefix	+ "f_port_nm", length));
			String[] ibCssmVoyNo = (JSPUtil.getParameter(request, prefix	+ "ib_cssm_voy_no", length));
			String[] fPort = (JSPUtil.getParameter(request, prefix	+ "f_port", length));
			String[] obCssmVoyNo = (JSPUtil.getParameter(request, prefix	+ "ob_cssm_voy_no", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new AusSearchVslPortSkdVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (fPortNm[i] != null)
					model.setFPortNm(fPortNm[i]);
				if (ibCssmVoyNo[i] != null)
					model.setIbCssmVoyNo(ibCssmVoyNo[i]);
				if (fPort[i] != null)
					model.setFPort(fPort[i]);
				if (obCssmVoyNo[i] != null)
					model.setObCssmVoyNo(obCssmVoyNo[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAusSearchVslPortSkdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AusSearchVslPortSkdVO[]
	 */
	public AusSearchVslPortSkdVO[] getAusSearchVslPortSkdVOs(){
		AusSearchVslPortSkdVO[] vos = (AusSearchVslPortSkdVO[])models.toArray(new AusSearchVslPortSkdVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fPortNm = this.fPortNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibCssmVoyNo = this.ibCssmVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fPort = this.fPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obCssmVoyNo = this.obCssmVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
