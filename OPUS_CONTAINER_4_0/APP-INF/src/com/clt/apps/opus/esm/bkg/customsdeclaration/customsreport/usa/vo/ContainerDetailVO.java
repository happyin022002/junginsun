/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerDetailVO.java
*@FileTitle : ContainerDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.20  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ContainerDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ContainerDetailVO> models = new ArrayList<ContainerDetailVO>();
	
	/* Column Info */
	private String fFlg = null;
	/* Column Info */
	private String ibdTrspNo = null;
	/* Column Info */
	private String ibdTrspTpCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cFlg = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String oFlg = null;
	/* Column Info */
	private String hubLocCd = null;
	/* Column Info */
	private String mfNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ContainerDetailVO() {}

	public ContainerDetailVO(String ibflag, String pagerows, String cntrNo, String vvd, String blNo, String vpsEtaDt, String podCd, String delCd, String hubLocCd, String ibdTrspNo, String ibdTrspTpCd, String fFlg, String oFlg, String cFlg, String mfNo) {
		this.fFlg = fFlg;
		this.ibdTrspNo = ibdTrspNo;
		this.ibdTrspTpCd = ibdTrspTpCd;
		this.delCd = delCd;
		this.blNo = blNo;
		this.vpsEtaDt = vpsEtaDt;
		this.pagerows = pagerows;
		this.cFlg = cFlg;
		this.vvd = vvd;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.cntrNo = cntrNo;
		this.oFlg = oFlg;
		this.hubLocCd = hubLocCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("f_flg", getFFlg());
		this.hashColumns.put("ibd_trsp_no", getIbdTrspNo());
		this.hashColumns.put("ibd_trsp_tp_cd", getIbdTrspTpCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("c_flg", getCFlg());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("o_flg", getOFlg());
		this.hashColumns.put("hub_loc_cd", getHubLocCd());
		this.hashColumns.put("mf_no", getMfNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("f_flg", "fFlg");
		this.hashFields.put("ibd_trsp_no", "ibdTrspNo");
		this.hashFields.put("ibd_trsp_tp_cd", "ibdTrspTpCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("c_flg", "cFlg");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("o_flg", "oFlg");
		this.hashFields.put("hub_loc_cd", "hubLocCd");
		this.hashFields.put("mf_no", "mfNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fFlg
	 */
	public String getFFlg() {
		return this.fFlg;
	}
	
	/**
	 * Column Info
	 * @return ibdTrspNo
	 */
	public String getIbdTrspNo() {
		return this.ibdTrspNo;
	}
	
	/**
	 * Column Info
	 * @return ibdTrspTpCd
	 */
	public String getIbdTrspTpCd() {
		return this.ibdTrspTpCd;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
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
	 * Column Info
	 * @return cFlg
	 */
	public String getCFlg() {
		return this.cFlg;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return oFlg
	 */
	public String getOFlg() {
		return this.oFlg;
	}
	
	/**
	 * Column Info
	 * @return hubLocCd
	 */
	public String getHubLocCd() {
		return this.hubLocCd;
	}
	
	/**
	 * Column Info
	 * @return mfNo
	 */
	public String getMfNo() {
		return this.mfNo;
	}
	
	/**
	 * Column Info
	 * @param fFlg
	 */
	public void setFFlg(String fFlg) {
		this.fFlg = fFlg;
	}
	
	/**
	 * Column Info
	 * @param ibdTrspNo
	 */
	public void setIbdTrspNo(String ibdTrspNo) {
		this.ibdTrspNo = ibdTrspNo;
	}
	
	/**
	 * Column Info
	 * @param ibdTrspTpCd
	 */
	public void setIbdTrspTpCd(String ibdTrspTpCd) {
		this.ibdTrspTpCd = ibdTrspTpCd;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
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
	 * Column Info
	 * @param cFlg
	 */
	public void setCFlg(String cFlg) {
		this.cFlg = cFlg;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param oFlg
	 */
	public void setOFlg(String oFlg) {
		this.oFlg = oFlg;
	}
	
	/**
	 * Column Info
	 * @param hubLocCd
	 */
	public void setHubLocCd(String hubLocCd) {
		this.hubLocCd = hubLocCd;
	}
	
	/**
	 * Column Info
	 * @param mfNo
	 */
	public void setMfNo(String mfNo) {
		this.mfNo = mfNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFFlg(JSPUtil.getParameter(request, "f_flg", ""));
		setIbdTrspNo(JSPUtil.getParameter(request, "ibd_trsp_no", ""));
		setIbdTrspTpCd(JSPUtil.getParameter(request, "ibd_trsp_tp_cd", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, "vps_eta_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCFlg(JSPUtil.getParameter(request, "c_flg", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setOFlg(JSPUtil.getParameter(request, "o_flg", ""));
		setHubLocCd(JSPUtil.getParameter(request, "hub_loc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ContainerDetailVO[]
	 */
	public ContainerDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ContainerDetailVO[]
	 */
	public ContainerDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ContainerDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fFlg = (JSPUtil.getParameter(request, prefix	+ "f_flg", length));
			String[] ibdTrspNo = (JSPUtil.getParameter(request, prefix	+ "ibd_trsp_no", length));
			String[] ibdTrspTpCd = (JSPUtil.getParameter(request, prefix	+ "ibd_trsp_tp_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cFlg = (JSPUtil.getParameter(request, prefix	+ "c_flg", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] oFlg = (JSPUtil.getParameter(request, prefix	+ "o_flg", length));
			String[] hubLocCd = (JSPUtil.getParameter(request, prefix	+ "hub_loc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new ContainerDetailVO();
				if (fFlg[i] != null)
					model.setFFlg(fFlg[i]);
				if (ibdTrspNo[i] != null)
					model.setIbdTrspNo(ibdTrspNo[i]);
				if (ibdTrspTpCd[i] != null)
					model.setIbdTrspTpCd(ibdTrspTpCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cFlg[i] != null)
					model.setCFlg(cFlg[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (oFlg[i] != null)
					model.setOFlg(oFlg[i]);
				if (hubLocCd[i] != null)
					model.setHubLocCd(hubLocCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getContainerDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ContainerDetailVO[]
	 */
	public ContainerDetailVO[] getContainerDetailVOs(){
		ContainerDetailVO[] vos = (ContainerDetailVO[])models.toArray(new ContainerDetailVO[models.size()]);
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
		this.fFlg = this.fFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdTrspNo = this.ibdTrspNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdTrspTpCd = this.ibdTrspTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cFlg = this.cFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oFlg = this.oFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hubLocCd = this.hubLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
