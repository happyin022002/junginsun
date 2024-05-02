/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChinaCncusVvdVO.java
*@FileTitle : ChinaCncusVvdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.26
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.26  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo;

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

public class ChinaCncusVvdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ChinaCncusVvdVO> models = new ArrayList<ChinaCncusVvdVO>();
	
	/* Column Info */
	private String eta = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String vslFullName = null;
	/* Column Info */
	private String imoNo = null;
	/* Column Info */
	private String etd = null;
	/* Column Info */
	private String pPortName = null;
	/* Column Info */
	private String orgPortName = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String lane = null;
	/* Column Info */
	private String sendDate = null;
	/* Column Info */
	private String orgPort = null;
	/* Column Info */
	private String polEtd = null;
	/* Column Info */
	private String vslDir = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pPort = null;
	/* Column Info */
	private String nPort = null;
	/* Column Info */
	private String callSign = null;
	/* Column Info */
	private String vslVoy = null;
	/* Column Info */
	private String nPortName = null;
	/* Column Info */
	private String repPerson = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ChinaCncusVvdVO() {}

	public ChinaCncusVvdVO(String ibflag, String pagerows, String sendDate, String eta, String nPortName, String orgPortName, String imoNo, String etd, String pPort, String callSign, String lane, String vslCd, String nPort, String polEtd, String vslVoy, String pPortName, String orgPort, String repPerson, String vslDir, String vslFullName) {
		this.eta = eta;
		this.vslCd = vslCd;
		this.vslFullName = vslFullName;
		this.imoNo = imoNo;
		this.etd = etd;
		this.pPortName = pPortName;
		this.orgPortName = orgPortName;
		this.pagerows = pagerows;
		this.lane = lane;
		this.sendDate = sendDate;
		this.orgPort = orgPort;
		this.polEtd = polEtd;
		this.vslDir = vslDir;
		this.ibflag = ibflag;
		this.pPort = pPort;
		this.nPort = nPort;
		this.callSign = callSign;
		this.vslVoy = vslVoy;
		this.nPortName = nPortName;
		this.repPerson = repPerson;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eta", getEta());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("vsl_full_name", getVslFullName());
		this.hashColumns.put("imo_no", getImoNo());
		this.hashColumns.put("etd", getEtd());
		this.hashColumns.put("p_port_name", getPPortName());
		this.hashColumns.put("org_port_name", getOrgPortName());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("send_date", getSendDate());
		this.hashColumns.put("org_port", getOrgPort());
		this.hashColumns.put("pol_etd", getPolEtd());
		this.hashColumns.put("vsl_dir", getVslDir());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("p_port", getPPort());
		this.hashColumns.put("n_port", getNPort());
		this.hashColumns.put("call_sign", getCallSign());
		this.hashColumns.put("vsl_voy", getVslVoy());
		this.hashColumns.put("n_port_name", getNPortName());
		this.hashColumns.put("rep_person", getRepPerson());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eta", "eta");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vsl_full_name", "vslFullName");
		this.hashFields.put("imo_no", "imoNo");
		this.hashFields.put("etd", "etd");
		this.hashFields.put("p_port_name", "pPortName");
		this.hashFields.put("org_port_name", "orgPortName");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("send_date", "sendDate");
		this.hashFields.put("org_port", "orgPort");
		this.hashFields.put("pol_etd", "polEtd");
		this.hashFields.put("vsl_dir", "vslDir");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("p_port", "pPort");
		this.hashFields.put("n_port", "nPort");
		this.hashFields.put("call_sign", "callSign");
		this.hashFields.put("vsl_voy", "vslVoy");
		this.hashFields.put("n_port_name", "nPortName");
		this.hashFields.put("rep_person", "repPerson");
		return this.hashFields;
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
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return vslFullName
	 */
	public String getVslFullName() {
		return this.vslFullName;
	}
	
	/**
	 * Column Info
	 * @return imoNo
	 */
	public String getImoNo() {
		return this.imoNo;
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
	 * @return pPortName
	 */
	public String getPPortName() {
		return this.pPortName;
	}
	
	/**
	 * Column Info
	 * @return orgPortName
	 */
	public String getOrgPortName() {
		return this.orgPortName;
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
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
	}
	
	/**
	 * Column Info
	 * @return sendDate
	 */
	public String getSendDate() {
		return this.sendDate;
	}
	
	/**
	 * Column Info
	 * @return orgPort
	 */
	public String getOrgPort() {
		return this.orgPort;
	}
	
	/**
	 * Column Info
	 * @return polEtd
	 */
	public String getPolEtd() {
		return this.polEtd;
	}
	
	/**
	 * Column Info
	 * @return vslDir
	 */
	public String getVslDir() {
		return this.vslDir;
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
	 * @return pPort
	 */
	public String getPPort() {
		return this.pPort;
	}
	
	/**
	 * Column Info
	 * @return nPort
	 */
	public String getNPort() {
		return this.nPort;
	}
	
	/**
	 * Column Info
	 * @return callSign
	 */
	public String getCallSign() {
		return this.callSign;
	}
	
	/**
	 * Column Info
	 * @return vslVoy
	 */
	public String getVslVoy() {
		return this.vslVoy;
	}
	
	/**
	 * Column Info
	 * @return nPortName
	 */
	public String getNPortName() {
		return this.nPortName;
	}
	
	/**
	 * Column Info
	 * @return repPerson
	 */
	public String getRepPerson() {
		return this.repPerson;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param vslFullName
	 */
	public void setVslFullName(String vslFullName) {
		this.vslFullName = vslFullName;
	}
	
	/**
	 * Column Info
	 * @param imoNo
	 */
	public void setImoNo(String imoNo) {
		this.imoNo = imoNo;
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
	 * @param pPortName
	 */
	public void setPPortName(String pPortName) {
		this.pPortName = pPortName;
	}
	
	/**
	 * Column Info
	 * @param orgPortName
	 */
	public void setOrgPortName(String orgPortName) {
		this.orgPortName = orgPortName;
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
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
	}
	
	/**
	 * Column Info
	 * @param sendDate
	 */
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}
	
	/**
	 * Column Info
	 * @param orgPort
	 */
	public void setOrgPort(String orgPort) {
		this.orgPort = orgPort;
	}
	
	/**
	 * Column Info
	 * @param polEtd
	 */
	public void setPolEtd(String polEtd) {
		this.polEtd = polEtd;
	}
	
	/**
	 * Column Info
	 * @param vslDir
	 */
	public void setVslDir(String vslDir) {
		this.vslDir = vslDir;
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
	 * @param pPort
	 */
	public void setPPort(String pPort) {
		this.pPort = pPort;
	}
	
	/**
	 * Column Info
	 * @param nPort
	 */
	public void setNPort(String nPort) {
		this.nPort = nPort;
	}
	
	/**
	 * Column Info
	 * @param callSign
	 */
	public void setCallSign(String callSign) {
		this.callSign = callSign;
	}
	
	/**
	 * Column Info
	 * @param vslVoy
	 */
	public void setVslVoy(String vslVoy) {
		this.vslVoy = vslVoy;
	}
	
	/**
	 * Column Info
	 * @param nPortName
	 */
	public void setNPortName(String nPortName) {
		this.nPortName = nPortName;
	}
	
	/**
	 * Column Info
	 * @param repPerson
	 */
	public void setRepPerson(String repPerson) {
		this.repPerson = repPerson;
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
		setEta(JSPUtil.getParameter(request, prefix + "eta", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setVslFullName(JSPUtil.getParameter(request, prefix + "vsl_full_name", ""));
		setImoNo(JSPUtil.getParameter(request, prefix + "imo_no", ""));
		setEtd(JSPUtil.getParameter(request, prefix + "etd", ""));
		setPPortName(JSPUtil.getParameter(request, prefix + "p_port_name", ""));
		setOrgPortName(JSPUtil.getParameter(request, prefix + "org_port_name", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setLane(JSPUtil.getParameter(request, prefix + "lane", ""));
		setSendDate(JSPUtil.getParameter(request, prefix + "send_date", ""));
		setOrgPort(JSPUtil.getParameter(request, prefix + "org_port", ""));
		setPolEtd(JSPUtil.getParameter(request, prefix + "pol_etd", ""));
		setVslDir(JSPUtil.getParameter(request, prefix + "vsl_dir", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPPort(JSPUtil.getParameter(request, prefix + "p_port", ""));
		setNPort(JSPUtil.getParameter(request, prefix + "n_port", ""));
		setCallSign(JSPUtil.getParameter(request, prefix + "call_sign", ""));
		setVslVoy(JSPUtil.getParameter(request, prefix + "vsl_voy", ""));
		setNPortName(JSPUtil.getParameter(request, prefix + "n_port_name", ""));
		setRepPerson(JSPUtil.getParameter(request, prefix + "rep_person", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChinaCncusVvdVO[]
	 */
	public ChinaCncusVvdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ChinaCncusVvdVO[]
	 */
	public ChinaCncusVvdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChinaCncusVvdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] eta = (JSPUtil.getParameter(request, prefix	+ "eta", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] vslFullName = (JSPUtil.getParameter(request, prefix	+ "vsl_full_name", length));
			String[] imoNo = (JSPUtil.getParameter(request, prefix	+ "imo_no", length));
			String[] etd = (JSPUtil.getParameter(request, prefix	+ "etd", length));
			String[] pPortName = (JSPUtil.getParameter(request, prefix	+ "p_port_name", length));
			String[] orgPortName = (JSPUtil.getParameter(request, prefix	+ "org_port_name", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] sendDate = (JSPUtil.getParameter(request, prefix	+ "send_date", length));
			String[] orgPort = (JSPUtil.getParameter(request, prefix	+ "org_port", length));
			String[] polEtd = (JSPUtil.getParameter(request, prefix	+ "pol_etd", length));
			String[] vslDir = (JSPUtil.getParameter(request, prefix	+ "vsl_dir", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pPort = (JSPUtil.getParameter(request, prefix	+ "p_port", length));
			String[] nPort = (JSPUtil.getParameter(request, prefix	+ "n_port", length));
			String[] callSign = (JSPUtil.getParameter(request, prefix	+ "call_sign", length));
			String[] vslVoy = (JSPUtil.getParameter(request, prefix	+ "vsl_voy", length));
			String[] nPortName = (JSPUtil.getParameter(request, prefix	+ "n_port_name", length));
			String[] repPerson = (JSPUtil.getParameter(request, prefix	+ "rep_person", length));
			
			for (int i = 0; i < length; i++) {
				model = new ChinaCncusVvdVO();
				if (eta[i] != null)
					model.setEta(eta[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (vslFullName[i] != null)
					model.setVslFullName(vslFullName[i]);
				if (imoNo[i] != null)
					model.setImoNo(imoNo[i]);
				if (etd[i] != null)
					model.setEtd(etd[i]);
				if (pPortName[i] != null)
					model.setPPortName(pPortName[i]);
				if (orgPortName[i] != null)
					model.setOrgPortName(orgPortName[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (sendDate[i] != null)
					model.setSendDate(sendDate[i]);
				if (orgPort[i] != null)
					model.setOrgPort(orgPort[i]);
				if (polEtd[i] != null)
					model.setPolEtd(polEtd[i]);
				if (vslDir[i] != null)
					model.setVslDir(vslDir[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pPort[i] != null)
					model.setPPort(pPort[i]);
				if (nPort[i] != null)
					model.setNPort(nPort[i]);
				if (callSign[i] != null)
					model.setCallSign(callSign[i]);
				if (vslVoy[i] != null)
					model.setVslVoy(vslVoy[i]);
				if (nPortName[i] != null)
					model.setNPortName(nPortName[i]);
				if (repPerson[i] != null)
					model.setRepPerson(repPerson[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChinaCncusVvdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChinaCncusVvdVO[]
	 */
	public ChinaCncusVvdVO[] getChinaCncusVvdVOs(){
		ChinaCncusVvdVO[] vos = (ChinaCncusVvdVO[])models.toArray(new ChinaCncusVvdVO[models.size()]);
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
		this.eta = this.eta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslFullName = this.vslFullName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imoNo = this.imoNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etd = this.etd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pPortName = this.pPortName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgPortName = this.orgPortName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sendDate = this.sendDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgPort = this.orgPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polEtd = this.polEtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDir = this.vslDir .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pPort = this.pPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nPort = this.nPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSign = this.callSign .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslVoy = this.vslVoy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nPortName = this.nPortName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repPerson = this.repPerson .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
