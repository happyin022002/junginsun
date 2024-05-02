/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MyanmarManifestVslInfoVO.java
*@FileTitle : MyanmarManifestVslInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.09
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.09  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.myanmar.vo;

import java.lang.reflect.Field;
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MyanmarManifestVslInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MyanmarManifestVslInfoVO> models = new ArrayList<MyanmarManifestVslInfoVO>();
	
	/* Column Info */
	private String port = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String eta = null;
	/* Column Info */
	private String vslFullname = null;
	/* Column Info */
	private String portNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String etd = null;
	/* Column Info */
	private String vslNationCd = null;
	/* Column Info */
	private String eIInd = null;
	/* Column Info */
	private String vslAuthNo = null;
	/* Column Info */
	private String tsTpCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MyanmarManifestVslInfoVO() {}

	public MyanmarManifestVslInfoVO(String ibflag, String pagerows, String eIInd, String tsTpCd, String status, String vvd, String vslFullname, String vslAuthNo, String vslNationCd, String port, String portNm, String eta, String etd) {
		this.port = port;
		this.vvd = vvd;
		this.eta = eta;
		this.vslFullname = vslFullname;
		this.portNm = portNm;
		this.ibflag = ibflag;
		this.status = status;
		this.etd = etd;
		this.vslNationCd = vslNationCd;
		this.eIInd = eIInd;
		this.vslAuthNo = vslAuthNo;
		this.pagerows = pagerows;
		this.tsTpCd = tsTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("port", getPort());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("eta", getEta());
		this.hashColumns.put("vsl_fullname", getVslFullname());
		this.hashColumns.put("port_nm", getPortNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("etd", getEtd());
		this.hashColumns.put("vsl_nation_cd", getVslNationCd());
		this.hashColumns.put("e_i_ind", getEIInd());
		this.hashColumns.put("vsl_auth_no", getVslAuthNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ts_tp_cd", getTsTpCd());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("port", "port");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("eta", "eta");
		this.hashFields.put("vsl_fullname", "vslFullname");
		this.hashFields.put("port_nm", "portNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("status", "status");
		this.hashFields.put("etd", "etd");
		this.hashFields.put("vsl_nation_cd", "vslNationCd");
		this.hashFields.put("e_i_ind", "eIInd");
		this.hashFields.put("vsl_auth_no", "vslAuthNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ts_tp_cd", "tsTpCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return port
	 */
	public String getPort() {
		return this.port;
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
	 * @return eta
	 */
	public String getEta() {
		return this.eta;
	}
	
	/**
	 * Column Info
	 * @return vslFullname
	 */
	public String getVslFullname() {
		return this.vslFullname;
	}
	
	/**
	 * Column Info
	 * @return portNm
	 */
	public String getPortNm() {
		return this.portNm;
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
	 * @return status
	 */
	public String getStatus() {
		return this.status;
	}
	
	/**
	 * Column Info
	 * @return etd
	 */
	public String getEtd() {
		return this.etd;
	}
	
	/**
	 * Column Info
	 * @return vslNationCd
	 */
	public String getVslNationCd() {
		return this.vslNationCd;
	}
	
	/**
	 * Column Info
	 * @return eIInd
	 */
	public String getEIInd() {
		return this.eIInd;
	}
	
	/**
	 * Column Info
	 * @return vslAuthNo
	 */
	public String getVslAuthNo() {
		return this.vslAuthNo;
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
	 * @return tsTpCd
	 */
	public String getTsTpCd() {
		return this.tsTpCd;
	}
	

	/**
	 * Column Info
	 * @param port
	 */
	public void setPort(String port) {
		this.port = port;
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
	 * @param eta
	 */
	public void setEta(String eta) {
		this.eta = eta;
	}
	
	/**
	 * Column Info
	 * @param vslFullname
	 */
	public void setVslFullname(String vslFullname) {
		this.vslFullname = vslFullname;
	}
	
	/**
	 * Column Info
	 * @param portNm
	 */
	public void setPortNm(String portNm) {
		this.portNm = portNm;
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
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Column Info
	 * @param etd
	 */
	public void setEtd(String etd) {
		this.etd = etd;
	}
	
	/**
	 * Column Info
	 * @param vslNationCd
	 */
	public void setVslNationCd(String vslNationCd) {
		this.vslNationCd = vslNationCd;
	}
	
	/**
	 * Column Info
	 * @param eIInd
	 */
	public void setEIInd(String eIInd) {
		this.eIInd = eIInd;
	}
	
	/**
	 * Column Info
	 * @param vslAuthNo
	 */
	public void setVslAuthNo(String vslAuthNo) {
		this.vslAuthNo = vslAuthNo;
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
	 * @param tsTpCd
	 */
	public void setTsTpCd(String tsTpCd) {
		this.tsTpCd = tsTpCd;
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
		setPort(JSPUtil.getParameter(request, prefix + "port", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setEta(JSPUtil.getParameter(request, prefix + "eta", ""));
		setVslFullname(JSPUtil.getParameter(request, prefix + "vsl_fullname", ""));
		setPortNm(JSPUtil.getParameter(request, prefix + "port_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setStatus(JSPUtil.getParameter(request, prefix + "status", ""));
		setEtd(JSPUtil.getParameter(request, prefix + "etd", ""));
		setVslNationCd(JSPUtil.getParameter(request, prefix + "vsl_nation_cd", ""));
		setEIInd(JSPUtil.getParameter(request, prefix + "e_i_ind", ""));
		setVslAuthNo(JSPUtil.getParameter(request, prefix + "vsl_auth_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTsTpCd(JSPUtil.getParameter(request, prefix + "ts_tp_cd", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MyanmarManifestVslInfoVO[]
	 */
	public MyanmarManifestVslInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MyanmarManifestVslInfoVO[]
	 */
	public MyanmarManifestVslInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MyanmarManifestVslInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] port = (JSPUtil.getParameter(request, prefix	+ "port", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] eta = (JSPUtil.getParameter(request, prefix	+ "eta", length));
			String[] vslFullname = (JSPUtil.getParameter(request, prefix	+ "vsl_fullname", length));
			String[] portNm = (JSPUtil.getParameter(request, prefix	+ "port_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] etd = (JSPUtil.getParameter(request, prefix	+ "etd", length));
			String[] vslNationCd = (JSPUtil.getParameter(request, prefix	+ "vsl_nation_cd", length));
			String[] eIInd = (JSPUtil.getParameter(request, prefix	+ "e_i_ind", length));
			String[] vslAuthNo = (JSPUtil.getParameter(request, prefix	+ "vsl_auth_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] tsTpCd = (JSPUtil.getParameter(request, prefix	+ "ts_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new MyanmarManifestVslInfoVO();
				if (port[i] != null)
					model.setPort(port[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (eta[i] != null)
					model.setEta(eta[i]);
				if (vslFullname[i] != null)
					model.setVslFullname(vslFullname[i]);
				if (portNm[i] != null)
					model.setPortNm(portNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (etd[i] != null)
					model.setEtd(etd[i]);
				if (vslNationCd[i] != null)
					model.setVslNationCd(vslNationCd[i]);
				if (eIInd[i] != null)
					model.setEIInd(eIInd[i]);
				if (vslAuthNo[i] != null)
					model.setVslAuthNo(vslAuthNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (tsTpCd[i] != null)
					model.setTsTpCd(tsTpCd[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMyanmarManifestVslInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MyanmarManifestVslInfoVO[]
	 */
	public MyanmarManifestVslInfoVO[] getMyanmarManifestVslInfoVOs(){
		MyanmarManifestVslInfoVO[] vos = (MyanmarManifestVslInfoVO[])models.toArray(new MyanmarManifestVslInfoVO[models.size()]);
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
		this.port = this.port .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eta = this.eta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslFullname = this.vslFullname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portNm = this.portNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etd = this.etd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNationCd = this.vslNationCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eIInd = this.eIInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslAuthNo = this.vslAuthNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsTpCd = this.tsTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
}
