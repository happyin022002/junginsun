/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChinaCncusVvdVO.java
*@FileTitle : ChinaCncusVvdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.21  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

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
	private String senddate = null;
	/* Column Info */
	private String eta = null;
	/* Column Info */
	private String nportname = null;
	/* Column Info */
	private String polname = null;
	/* Column Info */
	private String imoNo = null;
	/* Column Info */
	private String etd = null;
	/* Column Info */
	private String pport = null;
	/* Column Info */
	private String callsign = null;
	/* Column Info */
	private String lane = null;
	/* Page Number */
	private String pagerows = null;
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
	private String pportname = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String repPerson = null;
	/* Column Info */
	private String vsldir = null;
	/* Column Info */
	private String vslfullname = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ChinaCncusVvdVO() {}

	public ChinaCncusVvdVO(String ibflag, String pagerows, String vslfullname, String vslcd, String vslvoy, String vsldir, String callsign, String senddate, String repPerson, String pol, String polname, String polEtd, String pport, String pportname, String nport, String nportname, String eta, String etd, String imoNo, String lane) {
		this.senddate = senddate;
		this.eta = eta;
		this.nportname = nportname;
		this.polname = polname;
		this.imoNo = imoNo;
		this.etd = etd;
		this.pport = pport;
		this.callsign = callsign;
		this.lane = lane;
		this.pagerows = pagerows;
		this.vslcd = vslcd;
		this.nport = nport;
		this.polEtd = polEtd;
		this.ibflag = ibflag;
		this.vslvoy = vslvoy;
		this.pportname = pportname;
		this.pol = pol;
		this.repPerson = repPerson;
		this.vsldir = vsldir;
		this.vslfullname = vslfullname;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("senddate", getSenddate());
		this.hashColumns.put("eta", getEta());
		this.hashColumns.put("nportname", getNportname());
		this.hashColumns.put("polname", getPolname());
		this.hashColumns.put("imo_no", getImoNo());
		this.hashColumns.put("etd", getEtd());
		this.hashColumns.put("pport", getPport());
		this.hashColumns.put("callsign", getCallsign());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vslcd", getVslcd());
		this.hashColumns.put("nport", getNport());
		this.hashColumns.put("pol_etd", getPolEtd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vslvoy", getVslvoy());
		this.hashColumns.put("pportname", getPportname());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("rep_person", getRepPerson());
		this.hashColumns.put("vsldir", getVsldir());
		this.hashColumns.put("vslfullname", getVslfullname());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("senddate", "senddate");
		this.hashFields.put("eta", "eta");
		this.hashFields.put("nportname", "nportname");
		this.hashFields.put("polname", "polname");
		this.hashFields.put("imo_no", "imoNo");
		this.hashFields.put("etd", "etd");
		this.hashFields.put("pport", "pport");
		this.hashFields.put("callsign", "callsign");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vslcd", "vslcd");
		this.hashFields.put("nport", "nport");
		this.hashFields.put("pol_etd", "polEtd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vslvoy", "vslvoy");
		this.hashFields.put("pportname", "pportname");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("rep_person", "repPerson");
		this.hashFields.put("vsldir", "vsldir");
		this.hashFields.put("vslfullname", "vslfullname");
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
	 * @return eta
	 */
	public String getEta() {
		return this.eta;
	}
	
	/**
	 * Column Info
	 * @return nportname
	 */
	public String getNportname() {
		return this.nportname;
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
	 * @return etd
	 */
	public String getEtd() {
		return this.etd;
	}
	
	/**
	 * Column Info
	 * @return pport
	 */
	public String getPport() {
		return this.pport;
	}
	
	/**
	 * Column Info
	 * @return callsign
	 */
	public String getCallsign() {
		return this.callsign;
	}
	
	/**
	 * Column Info
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
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
	 * @return pportname
	 */
	public String getPportname() {
		return this.pportname;
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
	 * @param senddate
	 */
	public void setSenddate(String senddate) {
		this.senddate = senddate;
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
	 * @param nportname
	 */
	public void setNportname(String nportname) {
		this.nportname = nportname;
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
	 * @param etd
	 */
	public void setEtd(String etd) {
		this.etd = etd;
	}
	
	/**
	 * Column Info
	 * @param pport
	 */
	public void setPport(String pport) {
		this.pport = pport;
	}
	
	/**
	 * Column Info
	 * @param callsign
	 */
	public void setCallsign(String callsign) {
		this.callsign = callsign;
	}
	
	/**
	 * Column Info
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
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
	 * @param pportname
	 */
	public void setPportname(String pportname) {
		this.pportname = pportname;
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
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSenddate(JSPUtil.getParameter(request, "senddate", ""));
		setEta(JSPUtil.getParameter(request, "eta", ""));
		setNportname(JSPUtil.getParameter(request, "nportname", ""));
		setPolname(JSPUtil.getParameter(request, "polname", ""));
		setImoNo(JSPUtil.getParameter(request, "imo_no", ""));
		setEtd(JSPUtil.getParameter(request, "etd", ""));
		setPport(JSPUtil.getParameter(request, "pport", ""));
		setCallsign(JSPUtil.getParameter(request, "callsign", ""));
		setLane(JSPUtil.getParameter(request, "lane", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVslcd(JSPUtil.getParameter(request, "vslcd", ""));
		setNport(JSPUtil.getParameter(request, "nport", ""));
		setPolEtd(JSPUtil.getParameter(request, "pol_etd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVslvoy(JSPUtil.getParameter(request, "vslvoy", ""));
		setPportname(JSPUtil.getParameter(request, "pportname", ""));
		setPol(JSPUtil.getParameter(request, "pol", ""));
		setRepPerson(JSPUtil.getParameter(request, "rep_person", ""));
		setVsldir(JSPUtil.getParameter(request, "vsldir", ""));
		setVslfullname(JSPUtil.getParameter(request, "vslfullname", ""));
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
			String[] senddate = (JSPUtil.getParameter(request, prefix	+ "senddate", length));
			String[] eta = (JSPUtil.getParameter(request, prefix	+ "eta", length));
			String[] nportname = (JSPUtil.getParameter(request, prefix	+ "nportname", length));
			String[] polname = (JSPUtil.getParameter(request, prefix	+ "polname", length));
			String[] imoNo = (JSPUtil.getParameter(request, prefix	+ "imo_no", length));
			String[] etd = (JSPUtil.getParameter(request, prefix	+ "etd", length));
			String[] pport = (JSPUtil.getParameter(request, prefix	+ "pport", length));
			String[] callsign = (JSPUtil.getParameter(request, prefix	+ "callsign", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vslcd = (JSPUtil.getParameter(request, prefix	+ "vslcd", length));
			String[] nport = (JSPUtil.getParameter(request, prefix	+ "nport", length));
			String[] polEtd = (JSPUtil.getParameter(request, prefix	+ "pol_etd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vslvoy = (JSPUtil.getParameter(request, prefix	+ "vslvoy", length));
			String[] pportname = (JSPUtil.getParameter(request, prefix	+ "pportname", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] repPerson = (JSPUtil.getParameter(request, prefix	+ "rep_person", length));
			String[] vsldir = (JSPUtil.getParameter(request, prefix	+ "vsldir", length));
			String[] vslfullname = (JSPUtil.getParameter(request, prefix	+ "vslfullname", length));
			
			for (int i = 0; i < length; i++) {
				model = new ChinaCncusVvdVO();
				if (senddate[i] != null)
					model.setSenddate(senddate[i]);
				if (eta[i] != null)
					model.setEta(eta[i]);
				if (nportname[i] != null)
					model.setNportname(nportname[i]);
				if (polname[i] != null)
					model.setPolname(polname[i]);
				if (imoNo[i] != null)
					model.setImoNo(imoNo[i]);
				if (etd[i] != null)
					model.setEtd(etd[i]);
				if (pport[i] != null)
					model.setPport(pport[i]);
				if (callsign[i] != null)
					model.setCallsign(callsign[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
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
				if (pportname[i] != null)
					model.setPportname(pportname[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (repPerson[i] != null)
					model.setRepPerson(repPerson[i]);
				if (vsldir[i] != null)
					model.setVsldir(vsldir[i]);
				if (vslfullname[i] != null)
					model.setVslfullname(vslfullname[i]);
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
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.senddate = this.senddate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eta = this.eta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nportname = this.nportname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polname = this.polname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imoNo = this.imoNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etd = this.etd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pport = this.pport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callsign = this.callsign .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslcd = this.vslcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nport = this.nport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polEtd = this.polEtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslvoy = this.vslvoy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pportname = this.pportname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repPerson = this.repPerson .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vsldir = this.vsldir .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslfullname = this.vslfullname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
