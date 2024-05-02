/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MalaysiaManifestVslInfoVO.java
*@FileTitle : MalaysiaManifestVslInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.21
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.21  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.malaysia.vo;

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

public class MalaysiaManifestVslInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MalaysiaManifestVslInfoVO> models = new ArrayList<MalaysiaManifestVslInfoVO>();
	
	/* Column Info */
	private String vslCallNo = null;
	/* Column Info */
	private String port = null;
	/* Column Info */
	private String eta = null;
	/* Column Info */
	private String vslFullname = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String etd = null;
	/* Column Info */
	private String tsVslFullname = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String portNm = null;
	/* Column Info */
	private String tsTpCd = null;
	/* Column Info */
	private String tsVvd = null;
	/* Column Info */
	private String vslNationCd = null;
	/* Column Info */
	private String eIInd = null;
	/* Column Info */
	private String tsVslScn = null;
	/* Column Info */
	private String tsVslNationCd = null;
	/* Column Info */
	private String conVvd = null;
	/* Column Info */
	private String vslAuthNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public MalaysiaManifestVslInfoVO() {}

	public MalaysiaManifestVslInfoVO(String ibflag, String pagerows, String port, String vvd, String eta, String vslFullname, String portNm, String status, String etd, String vslNationCd, String eIInd, String vslAuthNo, String tsTpCd, String conVvd, String tsVvd, String tsVslFullname, String tsVslNationCd, String tsVslScn, String vslCallNo) {
		this.vslCallNo = vslCallNo;
		this.port = port;
		this.eta = eta;
		this.vslFullname = vslFullname;
		this.status = status;
		this.etd = etd;
		this.tsVslFullname = tsVslFullname;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.portNm = portNm;
		this.tsTpCd = tsTpCd;
		this.tsVvd = tsVvd;
		this.vslNationCd = vslNationCd;
		this.eIInd = eIInd;
		this.tsVslScn = tsVslScn;
		this.tsVslNationCd = tsVslNationCd;
		this.conVvd = conVvd;
		this.vslAuthNo = vslAuthNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_call_no", getVslCallNo());
		this.hashColumns.put("port", getPort());
		this.hashColumns.put("eta", getEta());
		this.hashColumns.put("vsl_fullname", getVslFullname());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("etd", getEtd());
		this.hashColumns.put("ts_vsl_fullname", getTsVslFullname());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("port_nm", getPortNm());
		this.hashColumns.put("ts_tp_cd", getTsTpCd());
		this.hashColumns.put("ts_vvd", getTsVvd());
		this.hashColumns.put("vsl_nation_cd", getVslNationCd());
		this.hashColumns.put("e_i_ind", getEIInd());
		this.hashColumns.put("ts_vsl_scn", getTsVslScn());
		this.hashColumns.put("ts_vsl_nation_cd", getTsVslNationCd());
		this.hashColumns.put("con_vvd", getConVvd());
		this.hashColumns.put("vsl_auth_no", getVslAuthNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_call_no", "vslCallNo");
		this.hashFields.put("port", "port");
		this.hashFields.put("eta", "eta");
		this.hashFields.put("vsl_fullname", "vslFullname");
		this.hashFields.put("status", "status");
		this.hashFields.put("etd", "etd");
		this.hashFields.put("ts_vsl_fullname", "tsVslFullname");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("port_nm", "portNm");
		this.hashFields.put("ts_tp_cd", "tsTpCd");
		this.hashFields.put("ts_vvd", "tsVvd");
		this.hashFields.put("vsl_nation_cd", "vslNationCd");
		this.hashFields.put("e_i_ind", "eIInd");
		this.hashFields.put("ts_vsl_scn", "tsVslScn");
		this.hashFields.put("ts_vsl_nation_cd", "tsVslNationCd");
		this.hashFields.put("con_vvd", "conVvd");
		this.hashFields.put("vsl_auth_no", "vslAuthNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCallNo
	 */
	public String getVslCallNo() {
		return this.vslCallNo;
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
	 * @return tsVslFullname
	 */
	public String getTsVslFullname() {
		return this.tsVslFullname;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return portNm
	 */
	public String getPortNm() {
		return this.portNm;
	}
	
	/**
	 * Column Info
	 * @return tsTpCd
	 */
	public String getTsTpCd() {
		return this.tsTpCd;
	}
	
	/**
	 * Column Info
	 * @return tsVvd
	 */
	public String getTsVvd() {
		return this.tsVvd;
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
	 * @return tsVslScn
	 */
	public String getTsVslScn() {
		return this.tsVslScn;
	}
	
	/**
	 * Column Info
	 * @return tsVslNationCd
	 */
	public String getTsVslNationCd() {
		return this.tsVslNationCd;
	}
	
	/**
	 * Column Info
	 * @return conVvd
	 */
	public String getConVvd() {
		return this.conVvd;
	}
	
	/**
	 * Column Info
	 * @return vslAuthNo
	 */
	public String getVslAuthNo() {
		return this.vslAuthNo;
	}
	

	/**
	 * Column Info
	 * @param vslCallNo
	 */
	public void setVslCallNo(String vslCallNo) {
		this.vslCallNo = vslCallNo;
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
	 * @param tsVslFullname
	 */
	public void setTsVslFullname(String tsVslFullname) {
		this.tsVslFullname = tsVslFullname;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param portNm
	 */
	public void setPortNm(String portNm) {
		this.portNm = portNm;
	}
	
	/**
	 * Column Info
	 * @param tsTpCd
	 */
	public void setTsTpCd(String tsTpCd) {
		this.tsTpCd = tsTpCd;
	}
	
	/**
	 * Column Info
	 * @param tsVvd
	 */
	public void setTsVvd(String tsVvd) {
		this.tsVvd = tsVvd;
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
	 * @param tsVslScn
	 */
	public void setTsVslScn(String tsVslScn) {
		this.tsVslScn = tsVslScn;
	}
	
	/**
	 * Column Info
	 * @param tsVslNationCd
	 */
	public void setTsVslNationCd(String tsVslNationCd) {
		this.tsVslNationCd = tsVslNationCd;
	}
	
	/**
	 * Column Info
	 * @param conVvd
	 */
	public void setConVvd(String conVvd) {
		this.conVvd = conVvd;
	}
	
	/**
	 * Column Info
	 * @param vslAuthNo
	 */
	public void setVslAuthNo(String vslAuthNo) {
		this.vslAuthNo = vslAuthNo;
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
		setVslCallNo(JSPUtil.getParameter(request, prefix + "vsl_call_no", ""));
		setPort(JSPUtil.getParameter(request, prefix + "port", ""));
		setEta(JSPUtil.getParameter(request, prefix + "eta", ""));
		setVslFullname(JSPUtil.getParameter(request, prefix + "vsl_fullname", ""));
		setStatus(JSPUtil.getParameter(request, prefix + "status", ""));
		setEtd(JSPUtil.getParameter(request, prefix + "etd", ""));
		setTsVslFullname(JSPUtil.getParameter(request, prefix + "ts_vsl_fullname", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPortNm(JSPUtil.getParameter(request, prefix + "port_nm", ""));
		setTsTpCd(JSPUtil.getParameter(request, prefix + "ts_tp_cd", ""));
		setTsVvd(JSPUtil.getParameter(request, prefix + "ts_vvd", ""));
		setVslNationCd(JSPUtil.getParameter(request, prefix + "vsl_nation_cd", ""));
		setEIInd(JSPUtil.getParameter(request, prefix + "e_i_ind", ""));
		setTsVslScn(JSPUtil.getParameter(request, prefix + "ts_vsl_scn", ""));
		setTsVslNationCd(JSPUtil.getParameter(request, prefix + "ts_vsl_nation_cd", ""));
		setConVvd(JSPUtil.getParameter(request, prefix + "con_vvd", ""));
		setVslAuthNo(JSPUtil.getParameter(request, prefix + "vsl_auth_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MalaysiaManifestVslInfoVO[]
	 */
	public MalaysiaManifestVslInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MalaysiaManifestVslInfoVO[]
	 */
	public MalaysiaManifestVslInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MalaysiaManifestVslInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCallNo = (JSPUtil.getParameter(request, prefix	+ "vsl_call_no", length));
			String[] port = (JSPUtil.getParameter(request, prefix	+ "port", length));
			String[] eta = (JSPUtil.getParameter(request, prefix	+ "eta", length));
			String[] vslFullname = (JSPUtil.getParameter(request, prefix	+ "vsl_fullname", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] etd = (JSPUtil.getParameter(request, prefix	+ "etd", length));
			String[] tsVslFullname = (JSPUtil.getParameter(request, prefix	+ "ts_vsl_fullname", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] portNm = (JSPUtil.getParameter(request, prefix	+ "port_nm", length));
			String[] tsTpCd = (JSPUtil.getParameter(request, prefix	+ "ts_tp_cd", length));
			String[] tsVvd = (JSPUtil.getParameter(request, prefix	+ "ts_vvd", length));
			String[] vslNationCd = (JSPUtil.getParameter(request, prefix	+ "vsl_nation_cd", length));
			String[] eIInd = (JSPUtil.getParameter(request, prefix	+ "e_i_ind", length));
			String[] tsVslScn = (JSPUtil.getParameter(request, prefix	+ "ts_vsl_scn", length));
			String[] tsVslNationCd = (JSPUtil.getParameter(request, prefix	+ "ts_vsl_nation_cd", length));
			String[] conVvd = (JSPUtil.getParameter(request, prefix	+ "con_vvd", length));
			String[] vslAuthNo = (JSPUtil.getParameter(request, prefix	+ "vsl_auth_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new MalaysiaManifestVslInfoVO();
				if (vslCallNo[i] != null)
					model.setVslCallNo(vslCallNo[i]);
				if (port[i] != null)
					model.setPort(port[i]);
				if (eta[i] != null)
					model.setEta(eta[i]);
				if (vslFullname[i] != null)
					model.setVslFullname(vslFullname[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (etd[i] != null)
					model.setEtd(etd[i]);
				if (tsVslFullname[i] != null)
					model.setTsVslFullname(tsVslFullname[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (portNm[i] != null)
					model.setPortNm(portNm[i]);
				if (tsTpCd[i] != null)
					model.setTsTpCd(tsTpCd[i]);
				if (tsVvd[i] != null)
					model.setTsVvd(tsVvd[i]);
				if (vslNationCd[i] != null)
					model.setVslNationCd(vslNationCd[i]);
				if (eIInd[i] != null)
					model.setEIInd(eIInd[i]);
				if (tsVslScn[i] != null)
					model.setTsVslScn(tsVslScn[i]);
				if (tsVslNationCd[i] != null)
					model.setTsVslNationCd(tsVslNationCd[i]);
				if (conVvd[i] != null)
					model.setConVvd(conVvd[i]);
				if (vslAuthNo[i] != null)
					model.setVslAuthNo(vslAuthNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMalaysiaManifestVslInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MalaysiaManifestVslInfoVO[]
	 */
	public MalaysiaManifestVslInfoVO[] getMalaysiaManifestVslInfoVOs(){
		MalaysiaManifestVslInfoVO[] vos = (MalaysiaManifestVslInfoVO[])models.toArray(new MalaysiaManifestVslInfoVO[models.size()]);
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
		this.vslCallNo = this.vslCallNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port = this.port .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eta = this.eta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslFullname = this.vslFullname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etd = this.etd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsVslFullname = this.tsVslFullname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portNm = this.portNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsTpCd = this.tsTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsVvd = this.tsVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNationCd = this.vslNationCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eIInd = this.eIInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsVslScn = this.tsVslScn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsVslNationCd = this.tsVslNationCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.conVvd = this.conVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslAuthNo = this.vslAuthNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
