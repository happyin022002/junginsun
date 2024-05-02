/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RussiaCncusVvdVO.java
*@FileTitle : RussiaCncusVvdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.18
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.18  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class RussiaCncusVvdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RussiaCncusVvdVO> models = new ArrayList<RussiaCncusVvdVO>();
	
	/* Column Info */
	private String senddate = null;
	/* Column Info */
	private String podEtd = null;
	/* Column Info */
	private String polname = null;
	/* Column Info */
	private String imoNo = null;
	/* Column Info */
	private String nportNm = null;
	/* Column Info */
	private String callsign = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String lane = null;
	/* Column Info */
	private String vslcd = null;
	/* Column Info */
	private String nport = null;
	/* Column Info */
	private String polEtd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vslvoy = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String repPerson = null;
	/* Column Info */
	private String podname = null;
	/* Column Info */
	private String polEta = null;
	/* Column Info */
	private String vsldir = null;
	/* Column Info */
	private String vslfullname = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String podEta = null;
	/* Column Info */
	private String crrNm = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RussiaCncusVvdVO() {}

	public RussiaCncusVvdVO(String ibflag, String pagerows, String senddate, String podEtd, String polname, String imoNo, String callsign, String lane, String vslcd, String polEtd, String vslvoy, String pol, String polEta, String podname, String repPerson, String vsldir, String vslfullname, String podEta, String pod, String nport, String nportNm, String crrNm) {
		this.senddate = senddate;
		this.podEtd = podEtd;
		this.polname = polname;
		this.imoNo = imoNo;
		this.nportNm = nportNm;
		this.callsign = callsign;
		this.pagerows = pagerows;
		this.lane = lane;
		this.vslcd = vslcd;
		this.nport = nport;
		this.polEtd = polEtd;
		this.ibflag = ibflag;
		this.vslvoy = vslvoy;
		this.pol = pol;
		this.repPerson = repPerson;
		this.podname = podname;
		this.polEta = polEta;
		this.vsldir = vsldir;
		this.vslfullname = vslfullname;
		this.pod = pod;
		this.podEta = podEta;
		this.crrNm = crrNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("senddate", getSenddate());
		this.hashColumns.put("pod_etd", getPodEtd());
		this.hashColumns.put("polname", getPolname());
		this.hashColumns.put("imo_no", getImoNo());
		this.hashColumns.put("nport_nm", getNportNm());
		this.hashColumns.put("callsign", getCallsign());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("vslcd", getVslcd());
		this.hashColumns.put("nport", getNport());
		this.hashColumns.put("pol_etd", getPolEtd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vslvoy", getVslvoy());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("rep_person", getRepPerson());
		this.hashColumns.put("podname", getPodname());
		this.hashColumns.put("pol_eta", getPolEta());
		this.hashColumns.put("vsldir", getVsldir());
		this.hashColumns.put("vslfullname", getVslfullname());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("pod_eta", getPodEta());
		this.hashColumns.put("crr_nm", getCrrNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("senddate", "senddate");
		this.hashFields.put("pod_etd", "podEtd");
		this.hashFields.put("polname", "polname");
		this.hashFields.put("imo_no", "imoNo");
		this.hashFields.put("nport_nm", "nportNm");
		this.hashFields.put("callsign", "callsign");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("vslcd", "vslcd");
		this.hashFields.put("nport", "nport");
		this.hashFields.put("pol_etd", "polEtd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vslvoy", "vslvoy");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("rep_person", "repPerson");
		this.hashFields.put("podname", "podname");
		this.hashFields.put("pol_eta", "polEta");
		this.hashFields.put("vsldir", "vsldir");
		this.hashFields.put("vslfullname", "vslfullname");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("pod_eta", "podEta");
		this.hashFields.put("crr_nm", "crrNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return senddate
	 */
	public String getSenddate() {
		return this.senddate;
	}
	
	/**
	 * Column Info
	 * @return podEtd
	 */
	public String getPodEtd() {
		return this.podEtd;
	}
	
	/**
	 * Column Info
	 * @return polname
	 */
	public String getPolname() {
		return this.polname;
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
	 * @return nportNm
	 */
	public String getNportNm() {
		return this.nportNm;
	}
	
	/**
	 * Column Info
	 * @return callsign
	 */
	public String getCallsign() {
		return this.callsign;
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
	 * @return vslcd
	 */
	public String getVslcd() {
		return this.vslcd;
	}
	
	/**
	 * Column Info
	 * @return nport
	 */
	public String getNport() {
		return this.nport;
	}
	
	/**
	 * Column Info
	 * @return polEtd
	 */
	public String getPolEtd() {
		return this.polEtd;
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
	 * @return vslvoy
	 */
	public String getVslvoy() {
		return this.vslvoy;
	}
	
	/**
	 * Column Info
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
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
	 * @return podname
	 */
	public String getPodname() {
		return this.podname;
	}
	
	/**
	 * Column Info
	 * @return polEta
	 */
	public String getPolEta() {
		return this.polEta;
	}
	
	/**
	 * Column Info
	 * @return vsldir
	 */
	public String getVsldir() {
		return this.vsldir;
	}
	
	/**
	 * Column Info
	 * @return vslfullname
	 */
	public String getVslfullname() {
		return this.vslfullname;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}
	
	/**
	 * Column Info
	 * @return podEta
	 */
	public String getPodEta() {
		return this.podEta;
	}
	
	/**
	 * Column Info
	 * @return crrNm
	 */
	public String getCrrNm() {
		return this.crrNm;
	}
	

	/**
	 * Column Info
	 * @param senddate
	 */
	public void setSenddate(String senddate) {
		this.senddate = senddate;
	}
	
	/**
	 * Column Info
	 * @param podEtd
	 */
	public void setPodEtd(String podEtd) {
		this.podEtd = podEtd;
	}
	
	/**
	 * Column Info
	 * @param polname
	 */
	public void setPolname(String polname) {
		this.polname = polname;
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
	 * @param nportNm
	 */
	public void setNportNm(String nportNm) {
		this.nportNm = nportNm;
	}
	
	/**
	 * Column Info
	 * @param callsign
	 */
	public void setCallsign(String callsign) {
		this.callsign = callsign;
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
	 * @param vslcd
	 */
	public void setVslcd(String vslcd) {
		this.vslcd = vslcd;
	}
	
	/**
	 * Column Info
	 * @param nport
	 */
	public void setNport(String nport) {
		this.nport = nport;
	}
	
	/**
	 * Column Info
	 * @param polEtd
	 */
	public void setPolEtd(String polEtd) {
		this.polEtd = polEtd;
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
	 * @param vslvoy
	 */
	public void setVslvoy(String vslvoy) {
		this.vslvoy = vslvoy;
	}
	
	/**
	 * Column Info
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	/**
	 * Column Info
	 * @param repPerson
	 */
	public void setRepPerson(String repPerson) {
		this.repPerson = repPerson;
	}
	
	/**
	 * Column Info
	 * @param podname
	 */
	public void setPodname(String podname) {
		this.podname = podname;
	}
	
	/**
	 * Column Info
	 * @param polEta
	 */
	public void setPolEta(String polEta) {
		this.polEta = polEta;
	}
	
	/**
	 * Column Info
	 * @param vsldir
	 */
	public void setVsldir(String vsldir) {
		this.vsldir = vsldir;
	}
	
	/**
	 * Column Info
	 * @param vslfullname
	 */
	public void setVslfullname(String vslfullname) {
		this.vslfullname = vslfullname;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}
	
	/**
	 * Column Info
	 * @param podEta
	 */
	public void setPodEta(String podEta) {
		this.podEta = podEta;
	}
		
	/**
	 * Column Info
	 * @param crrNm
	 */
	public void setCrrNm(String crrNm) {
		this.crrNm = crrNm;
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
		setSenddate(JSPUtil.getParameter(request, prefix + "senddate", ""));
		setPodEtd(JSPUtil.getParameter(request, prefix + "pod_etd", ""));
		setPolname(JSPUtil.getParameter(request, prefix + "polname", ""));
		setImoNo(JSPUtil.getParameter(request, prefix + "imo_no", ""));
		setNportNm(JSPUtil.getParameter(request, prefix + "nport_nm", ""));
		setCallsign(JSPUtil.getParameter(request, prefix + "callsign", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setLane(JSPUtil.getParameter(request, prefix + "lane", ""));
		setVslcd(JSPUtil.getParameter(request, prefix + "vslcd", ""));
		setNport(JSPUtil.getParameter(request, prefix + "nport", ""));
		setPolEtd(JSPUtil.getParameter(request, prefix + "pol_etd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVslvoy(JSPUtil.getParameter(request, prefix + "vslvoy", ""));
		setPol(JSPUtil.getParameter(request, prefix + "pol", ""));
		setRepPerson(JSPUtil.getParameter(request, prefix + "rep_person", ""));
		setPodname(JSPUtil.getParameter(request, prefix + "podname", ""));
		setPolEta(JSPUtil.getParameter(request, prefix + "pol_eta", ""));
		setVsldir(JSPUtil.getParameter(request, prefix + "vsldir", ""));
		setVslfullname(JSPUtil.getParameter(request, prefix + "vslfullname", ""));
		setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
		setPodEta(JSPUtil.getParameter(request, prefix + "pod_eta", ""));
		setCrrNm(JSPUtil.getParameter(request, prefix + "crr_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RussiaCncusVvdVO[]
	 */
	public RussiaCncusVvdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RussiaCncusVvdVO[]
	 */
	public RussiaCncusVvdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RussiaCncusVvdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] senddate = (JSPUtil.getParameter(request, prefix	+ "senddate", length));
			String[] podEtd = (JSPUtil.getParameter(request, prefix	+ "pod_etd", length));
			String[] polname = (JSPUtil.getParameter(request, prefix	+ "polname", length));
			String[] imoNo = (JSPUtil.getParameter(request, prefix	+ "imo_no", length));
			String[] nportNm = (JSPUtil.getParameter(request, prefix	+ "nport_nm", length));
			String[] callsign = (JSPUtil.getParameter(request, prefix	+ "callsign", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] vslcd = (JSPUtil.getParameter(request, prefix	+ "vslcd", length));
			String[] nport = (JSPUtil.getParameter(request, prefix	+ "nport", length));
			String[] polEtd = (JSPUtil.getParameter(request, prefix	+ "pol_etd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vslvoy = (JSPUtil.getParameter(request, prefix	+ "vslvoy", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] repPerson = (JSPUtil.getParameter(request, prefix	+ "rep_person", length));
			String[] podname = (JSPUtil.getParameter(request, prefix	+ "podname", length));
			String[] polEta = (JSPUtil.getParameter(request, prefix	+ "pol_eta", length));
			String[] vsldir = (JSPUtil.getParameter(request, prefix	+ "vsldir", length));
			String[] vslfullname = (JSPUtil.getParameter(request, prefix	+ "vslfullname", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] podEta = (JSPUtil.getParameter(request, prefix	+ "pod_eta", length));
			String[] crrNm = (JSPUtil.getParameter(request, prefix	+ "crr_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new RussiaCncusVvdVO();
				if (senddate[i] != null)
					model.setSenddate(senddate[i]);
				if (podEtd[i] != null)
					model.setPodEtd(podEtd[i]);
				if (polname[i] != null)
					model.setPolname(polname[i]);
				if (imoNo[i] != null)
					model.setImoNo(imoNo[i]);
				if (nportNm[i] != null)
					model.setNportNm(nportNm[i]);
				if (callsign[i] != null)
					model.setCallsign(callsign[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (vslcd[i] != null)
					model.setVslcd(vslcd[i]);
				if (nport[i] != null)
					model.setNport(nport[i]);
				if (polEtd[i] != null)
					model.setPolEtd(polEtd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslvoy[i] != null)
					model.setVslvoy(vslvoy[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (repPerson[i] != null)
					model.setRepPerson(repPerson[i]);
				if (podname[i] != null)
					model.setPodname(podname[i]);
				if (polEta[i] != null)
					model.setPolEta(polEta[i]);
				if (vsldir[i] != null)
					model.setVsldir(vsldir[i]);
				if (vslfullname[i] != null)
					model.setVslfullname(vslfullname[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (podEta[i] != null)
					model.setPodEta(podEta[i]);
				if (crrNm[i] != null)
					model.setCrrNm(crrNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRussiaCncusVvdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RussiaCncusVvdVO[]
	 */
	public RussiaCncusVvdVO[] getRussiaCncusVvdVOs(){
		RussiaCncusVvdVO[] vos = (RussiaCncusVvdVO[])models.toArray(new RussiaCncusVvdVO[models.size()]);
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
		this.senddate = this.senddate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podEtd = this.podEtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polname = this.polname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imoNo = this.imoNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nportNm = this.nportNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callsign = this.callsign .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslcd = this.vslcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nport = this.nport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polEtd = this.polEtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslvoy = this.vslvoy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repPerson = this.repPerson .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podname = this.podname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polEta = this.polEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vsldir = this.vsldir .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslfullname = this.vslfullname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podEta = this.podEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrNm = this.crrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
