/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BKGMainVO.java
*@FileTitle : BKGMainVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.05.21 정휘택 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 정휘택
 * @since J2EE 1.5
 * @see AbstractValueObject
 */

public class BKGMainVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BKGMainVO> models = new ArrayList<BKGMainVO>();
	
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String blSrcNo = null;
	/* Column Info */
	private String masterInv = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String bkgNoSplit = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String trunkVvd = null;
	/* Page Number */
	private String pagerows = null;

	/*	Table Column name으로 맴버변수 value 담는다*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	Table Column name으로 맴버변수 name 	담는다*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BKGMainVO() {}

	public BKGMainVO(String ibflag, String pagerows, String bkgNo, String bkgNoSplit, String blSrcNo, String trunkVvd, String porCd, String polCd, String podCd, String delCd, String svcScpCd, String masterInv) {
		this.podCd = podCd;
		this.porCd = porCd;
		this.blSrcNo = blSrcNo;
		this.masterInv = masterInv;
		this.polCd = polCd;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.svcScpCd = svcScpCd;
		this.bkgNoSplit = bkgNoSplit;
		this.delCd = delCd;
		this.trunkVvd = trunkVvd;
		this.pagerows = pagerows;
	}
	
	/**
	 * Table Column name 으로 맴버변수에 value를 리턴한다.
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("bl_src_no", getBlSrcNo());
		this.hashColumns.put("master_inv", getMasterInv());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("bkg_no_split", getBkgNoSplit());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("trunk_vvd", getTrunkVvd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * Table Column name 으로 맴버변수를 호출한다
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("master_inv", "masterInv");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("bkg_no_split", "bkgNoSplit");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("trunk_vvd", "trunkVvd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return blSrcNo
	 */
	public String getBlSrcNo() {
		return this.blSrcNo;
	}
	
	/**
	 * Column Info
	 * @return masterInv
	 */
	public String getMasterInv() {
		return this.masterInv;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Status
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return bkgNoSplit
	 */
	public String getBkgNoSplit() {
		return this.bkgNoSplit;
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
	 * @return trunkVvd
	 */
	public String getTrunkVvd() {
		return this.trunkVvd;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param blSrcNo
	 */
	public void setBlSrcNo(String blSrcNo) {
		this.blSrcNo = blSrcNo;
	}
	
	/**
	 * Column Info
	 * @param masterInv
	 */
	public void setMasterInv(String masterInv) {
		this.masterInv = masterInv;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Status
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param bkgNoSplit
	 */
	public void setBkgNoSplit(String bkgNoSplit) {
		this.bkgNoSplit = bkgNoSplit;
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
	 * @param trunkVvd
	 */
	public void setTrunkVvd(String trunkVvd) {
		this.trunkVvd = trunkVvd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Request 넘어온 단건 DATA를 VO Class 에 담는다. 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setBlSrcNo(JSPUtil.getParameter(request, "bl_src_no", ""));
		setMasterInv(JSPUtil.getParameter(request, "master_inv", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setBkgNoSplit(JSPUtil.getParameter(request, "bkg_no_split", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setTrunkVvd(JSPUtil.getParameter(request, "trunk_vvd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request를 VO Class를 담는다.
	 * @param request
	 * @return BKGMainVO[]
	 */
	public BKGMainVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BKGMainVO[]
	 */
	public BKGMainVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BKGMainVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd".trim(), length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd".trim(), length));
			String[] blSrcNo = (JSPUtil.getParameter(request, prefix	+ "bl_src_no".trim(), length));
			String[] masterInv = (JSPUtil.getParameter(request, prefix	+ "master_inv".trim(), length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd".trim(), length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd".trim(), length));
			String[] bkgNoSplit = (JSPUtil.getParameter(request, prefix	+ "bkg_no_split".trim(), length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd".trim(), length));
			String[] trunkVvd = (JSPUtil.getParameter(request, prefix	+ "trunk_vvd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new BKGMainVO();
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (blSrcNo[i] != null)
					model.setBlSrcNo(blSrcNo[i]);
				if (masterInv[i] != null)
					model.setMasterInv(masterInv[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (bkgNoSplit[i] != null)
					model.setBkgNoSplit(bkgNoSplit[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (trunkVvd[i] != null)
					model.setTrunkVvd(trunkVvd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBKGMainVOs();
	}

	/**
	 * 여러 VO Calss를 배열화 한다 
	 * @return BKGMainVO[]
	 */
	public BKGMainVO[] getBKGMainVOs(){
		BKGMainVO[] vos = (BKGMainVO[])models.toArray(new BKGMainVO[models.size()]);
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
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = getFieldCatct(field, i, arr);
		}
		return arr;
	}
	
	/**
	 * getField 에서 catch문에 대한 로직
	 * @param field
	 * @param i
	 * @param arr
	 * @return arr
	 */
	private String[] getFieldCatct(Field[] field, int i, String[] arr) {
		try {
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		} catch (IllegalAccessException e) {
			return null;
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void unDataFormat(){
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrcNo = this.blSrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masterInv = this.masterInv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNoSplit = this.bkgNoSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkVvd = this.trunkVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
