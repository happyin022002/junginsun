/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DocsQueueDetailVO.java
*@FileTitle : DocsQueueDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.09.07 김경섭 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김경섭
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DocsQueueDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DocsQueueDetailVO> models = new ArrayList<DocsQueueDetailVO>();
	
	/* Column Info */
	private String bkgSplit = null;
	/* Column Info */
	private String bkgMain = null;
	/* Column Info */
	private String awkward = null;
	/* Column Info */
	private String newBkg = null;
	/* Column Info */
	private String frtCharge = null;
	/* Column Info */
	private String nvoHouseBl = null;
	/* Column Info */
	private String blInform = null;
	/* Column Info */
	private String customerInfo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String customerVerification = null;
	/* Column Info */
	private String bBulk = null;
	/* Column Info */
	private String containerManifest = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String srKndCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String danger = null;
	/* Column Info */
	private String rlyVvdPort = null;
	/* Column Info */
	private String container = null;
	/* Column Info */
	private String reefer = null;
	/* Column Info */
	private String srNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DocsQueueDetailVO() {}

	public DocsQueueDetailVO(String ibflag, String pagerows, String srKndCd, String bkgNo, String srNo, String bkgMain, String customerInfo, String frtCharge, String container, String containerManifest, String danger, String awkward, String reefer, String bBulk, String rlyVvdPort, String newBkg, String bkgSplit, String blInform, String nvoHouseBl, String customerVerification) {
		this.bkgSplit = bkgSplit;
		this.bkgMain = bkgMain;
		this.awkward = awkward;
		this.newBkg = newBkg;
		this.frtCharge = frtCharge;
		this.nvoHouseBl = nvoHouseBl;
		this.blInform = blInform;
		this.customerInfo = customerInfo;
		this.pagerows = pagerows;
		this.customerVerification = customerVerification;
		this.bBulk = bBulk;
		this.containerManifest = containerManifest;
		this.ibflag = ibflag;
		this.srKndCd = srKndCd;
		this.bkgNo = bkgNo;
		this.danger = danger;
		this.rlyVvdPort = rlyVvdPort;
		this.container = container;
		this.reefer = reefer;
		this.srNo = srNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_split", getBkgSplit());
		this.hashColumns.put("bkg_main", getBkgMain());
		this.hashColumns.put("awkward", getAwkward());
		this.hashColumns.put("new_bkg", getNewBkg());
		this.hashColumns.put("frt_charge", getFrtCharge());
		this.hashColumns.put("nvo_house_bl", getNvoHouseBl());
		this.hashColumns.put("bl_inform", getBlInform());
		this.hashColumns.put("customer_info", getCustomerInfo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("customer_verification", getCustomerVerification());
		this.hashColumns.put("b_bulk", getBBulk());
		this.hashColumns.put("container_manifest", getContainerManifest());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sr_knd_cd", getSrKndCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("danger", getDanger());
		this.hashColumns.put("rly_vvd_port", getRlyVvdPort());
		this.hashColumns.put("container", getContainer());
		this.hashColumns.put("reefer", getReefer());
		this.hashColumns.put("sr_no", getSrNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_split", "bkgSplit");
		this.hashFields.put("bkg_main", "bkgMain");
		this.hashFields.put("awkward", "awkward");
		this.hashFields.put("new_bkg", "newBkg");
		this.hashFields.put("frt_charge", "frtCharge");
		this.hashFields.put("nvo_house_bl", "nvoHouseBl");
		this.hashFields.put("bl_inform", "blInform");
		this.hashFields.put("customer_info", "customerInfo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("customer_verification", "customerVerification");
		this.hashFields.put("b_bulk", "bBulk");
		this.hashFields.put("container_manifest", "containerManifest");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sr_knd_cd", "srKndCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("danger", "danger");
		this.hashFields.put("rly_vvd_port", "rlyVvdPort");
		this.hashFields.put("container", "container");
		this.hashFields.put("reefer", "reefer");
		this.hashFields.put("sr_no", "srNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgSplit
	 */
	public String getBkgSplit() {
		return this.bkgSplit;
	}
	
	/**
	 * Column Info
	 * @return bkgMain
	 */
	public String getBkgMain() {
		return this.bkgMain;
	}
	
	/**
	 * Column Info
	 * @return awkward
	 */
	public String getAwkward() {
		return this.awkward;
	}
	
	/**
	 * Column Info
	 * @return newBkg
	 */
	public String getNewBkg() {
		return this.newBkg;
	}
	
	/**
	 * Column Info
	 * @return frtCharge
	 */
	public String getFrtCharge() {
		return this.frtCharge;
	}
	
	/**
	 * Column Info
	 * @return nvoHouseBl
	 */
	public String getNvoHouseBl() {
		return this.nvoHouseBl;
	}
	
	/**
	 * Column Info
	 * @return blInform
	 */
	public String getBlInform() {
		return this.blInform;
	}
	
	/**
	 * Column Info
	 * @return customerInfo
	 */
	public String getCustomerInfo() {
		return this.customerInfo;
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
	 * @return customerVerification
	 */
	public String getCustomerVerification() {
		return this.customerVerification;
	}
	
	/**
	 * Column Info
	 * @return bBulk
	 */
	public String getBBulk() {
		return this.bBulk;
	}
	
	/**
	 * Column Info
	 * @return containerManifest
	 */
	public String getContainerManifest() {
		return this.containerManifest;
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
	 * @return srKndCd
	 */
	public String getSrKndCd() {
		return this.srKndCd;
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
	 * @return danger
	 */
	public String getDanger() {
		return this.danger;
	}
	
	/**
	 * Column Info
	 * @return rlyVvdPort
	 */
	public String getRlyVvdPort() {
		return this.rlyVvdPort;
	}
	
	/**
	 * Column Info
	 * @return container
	 */
	public String getContainer() {
		return this.container;
	}
	
	/**
	 * Column Info
	 * @return reefer
	 */
	public String getReefer() {
		return this.reefer;
	}
	
	/**
	 * Column Info
	 * @return srNo
	 */
	public String getSrNo() {
		return this.srNo;
	}
	

	/**
	 * Column Info
	 * @param bkgSplit
	 */
	public void setBkgSplit(String bkgSplit) {
		this.bkgSplit = bkgSplit;
	}
	
	/**
	 * Column Info
	 * @param bkgMain
	 */
	public void setBkgMain(String bkgMain) {
		this.bkgMain = bkgMain;
	}
	
	/**
	 * Column Info
	 * @param awkward
	 */
	public void setAwkward(String awkward) {
		this.awkward = awkward;
	}
	
	/**
	 * Column Info
	 * @param newBkg
	 */
	public void setNewBkg(String newBkg) {
		this.newBkg = newBkg;
	}
	
	/**
	 * Column Info
	 * @param frtCharge
	 */
	public void setFrtCharge(String frtCharge) {
		this.frtCharge = frtCharge;
	}
	
	/**
	 * Column Info
	 * @param nvoHouseBl
	 */
	public void setNvoHouseBl(String nvoHouseBl) {
		this.nvoHouseBl = nvoHouseBl;
	}
	
	/**
	 * Column Info
	 * @param blInform
	 */
	public void setBlInform(String blInform) {
		this.blInform = blInform;
	}
	
	/**
	 * Column Info
	 * @param customerInfo
	 */
	public void setCustomerInfo(String customerInfo) {
		this.customerInfo = customerInfo;
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
	 * @param customerVerification
	 */
	public void setCustomerVerification(String customerVerification) {
		this.customerVerification = customerVerification;
	}
	
	/**
	 * Column Info
	 * @param bBulk
	 */
	public void setBBulk(String bBulk) {
		this.bBulk = bBulk;
	}
	
	/**
	 * Column Info
	 * @param containerManifest
	 */
	public void setContainerManifest(String containerManifest) {
		this.containerManifest = containerManifest;
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
	 * @param srKndCd
	 */
	public void setSrKndCd(String srKndCd) {
		this.srKndCd = srKndCd;
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
	 * @param danger
	 */
	public void setDanger(String danger) {
		this.danger = danger;
	}
	
	/**
	 * Column Info
	 * @param rlyVvdPort
	 */
	public void setRlyVvdPort(String rlyVvdPort) {
		this.rlyVvdPort = rlyVvdPort;
	}
	
	/**
	 * Column Info
	 * @param container
	 */
	public void setContainer(String container) {
		this.container = container;
	}
	
	/**
	 * Column Info
	 * @param reefer
	 */
	public void setReefer(String reefer) {
		this.reefer = reefer;
	}
	
	/**
	 * Column Info
	 * @param srNo
	 */
	public void setSrNo(String srNo) {
		this.srNo = srNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBkgSplit(JSPUtil.getParameter(request, "bkg_split", ""));
		setBkgMain(JSPUtil.getParameter(request, "bkg_main", ""));
		setAwkward(JSPUtil.getParameter(request, "awkward", ""));
		setNewBkg(JSPUtil.getParameter(request, "new_bkg", ""));
		setFrtCharge(JSPUtil.getParameter(request, "frt_charge", ""));
		setNvoHouseBl(JSPUtil.getParameter(request, "nvo_house_bl", ""));
		setBlInform(JSPUtil.getParameter(request, "bl_inform", ""));
		setCustomerInfo(JSPUtil.getParameter(request, "customer_info", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCustomerVerification(JSPUtil.getParameter(request, "customer_verification", ""));
		setBBulk(JSPUtil.getParameter(request, "b_bulk", ""));
		setContainerManifest(JSPUtil.getParameter(request, "container_manifest", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSrKndCd(JSPUtil.getParameter(request, "sr_knd_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setDanger(JSPUtil.getParameter(request, "danger", ""));
		setRlyVvdPort(JSPUtil.getParameter(request, "rly_vvd_port", ""));
		setContainer(JSPUtil.getParameter(request, "container", ""));
		setReefer(JSPUtil.getParameter(request, "reefer", ""));
		setSrNo(JSPUtil.getParameter(request, "sr_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DocsQueueDetailVO[]
	 */
	public DocsQueueDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DocsQueueDetailVO[]
	 */
	public DocsQueueDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DocsQueueDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgSplit = (JSPUtil.getParameter(request, prefix	+ "bkg_split", length));
			String[] bkgMain = (JSPUtil.getParameter(request, prefix	+ "bkg_main", length));
			String[] awkward = (JSPUtil.getParameter(request, prefix	+ "awkward", length));
			String[] newBkg = (JSPUtil.getParameter(request, prefix	+ "new_bkg", length));
			String[] frtCharge = (JSPUtil.getParameter(request, prefix	+ "frt_charge", length));
			String[] nvoHouseBl = (JSPUtil.getParameter(request, prefix	+ "nvo_house_bl", length));
			String[] blInform = (JSPUtil.getParameter(request, prefix	+ "bl_inform", length));
			String[] customerInfo = (JSPUtil.getParameter(request, prefix	+ "customer_info", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] customerVerification = (JSPUtil.getParameter(request, prefix	+ "customer_verification", length));
			String[] bBulk = (JSPUtil.getParameter(request, prefix	+ "b_bulk", length));
			String[] containerManifest = (JSPUtil.getParameter(request, prefix	+ "container_manifest", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] srKndCd = (JSPUtil.getParameter(request, prefix	+ "sr_knd_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] danger = (JSPUtil.getParameter(request, prefix	+ "danger", length));
			String[] rlyVvdPort = (JSPUtil.getParameter(request, prefix	+ "rly_vvd_port", length));
			String[] container = (JSPUtil.getParameter(request, prefix	+ "container", length));
			String[] reefer = (JSPUtil.getParameter(request, prefix	+ "reefer", length));
			String[] srNo = (JSPUtil.getParameter(request, prefix	+ "sr_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new DocsQueueDetailVO();
				if (bkgSplit[i] != null)
					model.setBkgSplit(bkgSplit[i]);
				if (bkgMain[i] != null)
					model.setBkgMain(bkgMain[i]);
				if (awkward[i] != null)
					model.setAwkward(awkward[i]);
				if (newBkg[i] != null)
					model.setNewBkg(newBkg[i]);
				if (frtCharge[i] != null)
					model.setFrtCharge(frtCharge[i]);
				if (nvoHouseBl[i] != null)
					model.setNvoHouseBl(nvoHouseBl[i]);
				if (blInform[i] != null)
					model.setBlInform(blInform[i]);
				if (customerInfo[i] != null)
					model.setCustomerInfo(customerInfo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (customerVerification[i] != null)
					model.setCustomerVerification(customerVerification[i]);
				if (bBulk[i] != null)
					model.setBBulk(bBulk[i]);
				if (containerManifest[i] != null)
					model.setContainerManifest(containerManifest[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (srKndCd[i] != null)
					model.setSrKndCd(srKndCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (danger[i] != null)
					model.setDanger(danger[i]);
				if (rlyVvdPort[i] != null)
					model.setRlyVvdPort(rlyVvdPort[i]);
				if (container[i] != null)
					model.setContainer(container[i]);
				if (reefer[i] != null)
					model.setReefer(reefer[i]);
				if (srNo[i] != null)
					model.setSrNo(srNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDocsQueueDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DocsQueueDetailVO[]
	 */
	public DocsQueueDetailVO[] getDocsQueueDetailVOs(){
		DocsQueueDetailVO[] vos = (DocsQueueDetailVO[])models.toArray(new DocsQueueDetailVO[models.size()]);
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
		this.bkgSplit = this.bkgSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgMain = this.bkgMain .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkward = this.awkward .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newBkg = this.newBkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtCharge = this.frtCharge .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nvoHouseBl = this.nvoHouseBl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blInform = this.blInform .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customerInfo = this.customerInfo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customerVerification = this.customerVerification .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bBulk = this.bBulk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.containerManifest = this.containerManifest .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srKndCd = this.srKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.danger = this.danger .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlyVvdPort = this.rlyVvdPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.container = this.container .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reefer = this.reefer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srNo = this.srNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
