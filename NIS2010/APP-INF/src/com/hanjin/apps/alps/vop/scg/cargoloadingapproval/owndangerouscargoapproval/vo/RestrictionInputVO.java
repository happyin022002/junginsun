/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RestrictionInputVO.java
*@FileTitle : RestrictionInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.09.23 김현욱 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo;

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
 * @author 김현욱
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RestrictionInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RestrictionInputVO> models = new ArrayList<RestrictionInputVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String polPortCd = null;
	/* Column Info */
	private String imdgUnNoSeq = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String imdgCmptnAuthCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String portType = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String podPortCd = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String podVpsPortCd = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String polVpsPortCd = null;
	/* Column Info */
	private String txtDesc = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Column Info */
	private String imdgClssCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RestrictionInputVO() {}

	public RestrictionInputVO(String ibflag, String pagerows, String polPortCd, String imdgUnNoSeq, String imdgCmptnAuthCd, String portType, String podPortCd, String slanCd, String podVpsPortCd, String portCd, String polVpsPortCd, String txtDesc, String imdgClssCd, String imdgUnNo, String bkgNo, String vslCd, String skdVoyNo, String skdDirCd) {
		this.vslCd = vslCd;
		this.polPortCd = polPortCd;
		this.imdgUnNoSeq = imdgUnNoSeq;
		this.skdVoyNo = skdVoyNo;
		this.imdgCmptnAuthCd = imdgCmptnAuthCd;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.portType = portType;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.podPortCd = podPortCd;
		this.slanCd = slanCd;
		this.podVpsPortCd = podVpsPortCd;
		this.portCd = portCd;
		this.polVpsPortCd = polVpsPortCd;
		this.txtDesc = txtDesc;
		this.imdgUnNo = imdgUnNo;
		this.imdgClssCd = imdgClssCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("pol_port_cd", getPolPortCd());
		this.hashColumns.put("imdg_un_no_seq", getImdgUnNoSeq());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("imdg_cmptn_auth_cd", getImdgCmptnAuthCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("port_type", getPortType());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pod_port_cd", getPodPortCd());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("pod_vps_port_cd", getPodVpsPortCd());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("pol_vps_port_cd", getPolVpsPortCd());
		this.hashColumns.put("txt_desc", getTxtDesc());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("pol_port_cd", "polPortCd");
		this.hashFields.put("imdg_un_no_seq", "imdgUnNoSeq");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("imdg_cmptn_auth_cd", "imdgCmptnAuthCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("port_type", "portType");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pod_port_cd", "podPortCd");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("pod_vps_port_cd", "podVpsPortCd");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("pol_vps_port_cd", "polVpsPortCd");
		this.hashFields.put("txt_desc", "txtDesc");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		return this.hashFields;
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
	 * @return polPortCd
	 */
	public String getPolPortCd() {
		return this.polPortCd;
	}
	
	/**
	 * Column Info
	 * @return imdgUnNoSeq
	 */
	public String getImdgUnNoSeq() {
		return this.imdgUnNoSeq;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return imdgCmptnAuthCd
	 */
	public String getImdgCmptnAuthCd() {
		return this.imdgCmptnAuthCd;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return portType
	 */
	public String getPortType() {
		return this.portType;
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
	 * @return podPortCd
	 */
	public String getPodPortCd() {
		return this.podPortCd;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return podVpsPortCd
	 */
	public String getPodVpsPortCd() {
		return this.podVpsPortCd;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return polVpsPortCd
	 */
	public String getPolVpsPortCd() {
		return this.polVpsPortCd;
	}
	
	/**
	 * Column Info
	 * @return txtDesc
	 */
	public String getTxtDesc() {
		return this.txtDesc;
	}
	
	/**
	 * Column Info
	 * @return imdgUnNo
	 */
	public String getImdgUnNo() {
		return this.imdgUnNo;
	}
	
	/**
	 * Column Info
	 * @return imdgClssCd
	 */
	public String getImdgClssCd() {
		return this.imdgClssCd;
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
	 * @param polPortCd
	 */
	public void setPolPortCd(String polPortCd) {
		this.polPortCd = polPortCd;
	}
	
	/**
	 * Column Info
	 * @param imdgUnNoSeq
	 */
	public void setImdgUnNoSeq(String imdgUnNoSeq) {
		this.imdgUnNoSeq = imdgUnNoSeq;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param imdgCmptnAuthCd
	 */
	public void setImdgCmptnAuthCd(String imdgCmptnAuthCd) {
		this.imdgCmptnAuthCd = imdgCmptnAuthCd;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param portType
	 */
	public void setPortType(String portType) {
		this.portType = portType;
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
	 * @param podPortCd
	 */
	public void setPodPortCd(String podPortCd) {
		this.podPortCd = podPortCd;
	}
	
	/**
	 * Column Info
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param podVpsPortCd
	 */
	public void setPodVpsPortCd(String podVpsPortCd) {
		this.podVpsPortCd = podVpsPortCd;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param polVpsPortCd
	 */
	public void setPolVpsPortCd(String polVpsPortCd) {
		this.polVpsPortCd = polVpsPortCd;
	}
	
	/**
	 * Column Info
	 * @param txtDesc
	 */
	public void setTxtDesc(String txtDesc) {
		this.txtDesc = txtDesc;
	}
	
	/**
	 * Column Info
	 * @param imdgUnNo
	 */
	public void setImdgUnNo(String imdgUnNo) {
		this.imdgUnNo = imdgUnNo;
	}
	
	/**
	 * Column Info
	 * @param imdgClssCd
	 */
	public void setImdgClssCd(String imdgClssCd) {
		this.imdgClssCd = imdgClssCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setPolPortCd(JSPUtil.getParameter(request, "pol_port_cd", ""));
		setImdgUnNoSeq(JSPUtil.getParameter(request, "imdg_un_no_seq", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setImdgCmptnAuthCd(JSPUtil.getParameter(request, "imdg_cmptn_auth_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPortType(JSPUtil.getParameter(request, "port_type", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPodPortCd(JSPUtil.getParameter(request, "pod_port_cd", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setPodVpsPortCd(JSPUtil.getParameter(request, "pod_vps_port_cd", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setPolVpsPortCd(JSPUtil.getParameter(request, "pol_vps_port_cd", ""));
		setTxtDesc(JSPUtil.getParameter(request, "txt_desc", ""));
		setImdgUnNo(JSPUtil.getParameter(request, "imdg_un_no", ""));
		setImdgClssCd(JSPUtil.getParameter(request, "imdg_clss_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RestrictionInputVO[]
	 */
	public RestrictionInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RestrictionInputVO[]
	 */
	public RestrictionInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RestrictionInputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] polPortCd = (JSPUtil.getParameter(request, prefix	+ "pol_port_cd", length));
			String[] imdgUnNoSeq = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no_seq", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] imdgCmptnAuthCd = (JSPUtil.getParameter(request, prefix	+ "imdg_cmptn_auth_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] portType = (JSPUtil.getParameter(request, prefix	+ "port_type", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] podPortCd = (JSPUtil.getParameter(request, prefix	+ "pod_port_cd", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] podVpsPortCd = (JSPUtil.getParameter(request, prefix	+ "pod_vps_port_cd", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] polVpsPortCd = (JSPUtil.getParameter(request, prefix	+ "pol_vps_port_cd", length));
			String[] txtDesc = (JSPUtil.getParameter(request, prefix	+ "txt_desc", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new RestrictionInputVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (polPortCd[i] != null)
					model.setPolPortCd(polPortCd[i]);
				if (imdgUnNoSeq[i] != null)
					model.setImdgUnNoSeq(imdgUnNoSeq[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (imdgCmptnAuthCd[i] != null)
					model.setImdgCmptnAuthCd(imdgCmptnAuthCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (portType[i] != null)
					model.setPortType(portType[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (podPortCd[i] != null)
					model.setPodPortCd(podPortCd[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (podVpsPortCd[i] != null)
					model.setPodVpsPortCd(podVpsPortCd[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (polVpsPortCd[i] != null)
					model.setPolVpsPortCd(polVpsPortCd[i]);
				if (txtDesc[i] != null)
					model.setTxtDesc(txtDesc[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRestrictionInputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RestrictionInputVO[]
	 */
	public RestrictionInputVO[] getRestrictionInputVOs(){
		RestrictionInputVO[] vos = (RestrictionInputVO[])models.toArray(new RestrictionInputVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polPortCd = this.polPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNoSeq = this.imdgUnNoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgCmptnAuthCd = this.imdgCmptnAuthCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portType = this.portType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podPortCd = this.podPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podVpsPortCd = this.podVpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polVpsPortCd = this.polVpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.txtDesc = this.txtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
