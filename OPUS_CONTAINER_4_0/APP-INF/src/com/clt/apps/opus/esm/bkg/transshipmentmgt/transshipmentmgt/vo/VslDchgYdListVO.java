/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VslDchgYdListVO.java
*@FileTitle : VslDchgYdListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.05.21 최영희 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo;

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
 * @author 최영희
 * @since J2EE 1.5
 * @see AbstractValueObject
 */

public class VslDchgYdListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VslDchgYdListVO> models = new ArrayList<VslDchgYdListVO>();
	
	/* Column Info */
	private String etb = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String clptCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String skdCallSeq = null;
	/* Column Info */
	private String cvyRefNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String lane = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String uqVslIdNo = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String ydcd = null;

	/*	Table Column name으로 맴버변수 value 담는다*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	Table Column name으로 맴버변수 name 	담는다*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VslDchgYdListVO() {}

	public VslDchgYdListVO(String ibflag, String pagerows, String vvd, String lane, String skdCallSeq, String clptCd, String etb, String ydcd, String cvyRefNo, String uqVslIdNo, String vslCd, String skdVoyNo, String skdDirCd, String ydCd) {
		this.etb = etb;
		this.vslCd = vslCd;
		this.clptCd = clptCd;
		this.skdVoyNo = skdVoyNo;
		this.skdCallSeq = skdCallSeq;
		this.cvyRefNo = cvyRefNo;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.lane = lane;
		this.vvd = vvd;
		this.uqVslIdNo = uqVslIdNo;
		this.ibflag = ibflag;
		this.ydCd = ydCd;
		this.ydcd = ydcd;
	}
	
	/**
	 * Table Column name 으로 맴버변수에 value를 리턴한다.
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("etb", getEtb());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("clpt_cd", getClptCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_call_seq", getSkdCallSeq());
		this.hashColumns.put("cvy_ref_no", getCvyRefNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("uq_vsl_id_no", getUqVslIdNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("ydcd", getYdcd());
		return this.hashColumns;
	}
	
	/**
	 * Table Column name 으로 맴버변수를 호출한다
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("etb", "etb");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("clpt_cd", "clptCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_call_seq", "skdCallSeq");
		this.hashFields.put("cvy_ref_no", "cvyRefNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("uq_vsl_id_no", "uqVslIdNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("ydcd", "ydcd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return etb
	 */
	public String getEtb() {
		return this.etb;
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
	 * @return clptCd
	 */
	public String getClptCd() {
		return this.clptCd;
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
	 * @return skdCallSeq
	 */
	public String getSkdCallSeq() {
		return this.skdCallSeq;
	}
	
	/**
	 * Column Info
	 * @return cvyRefNo
	 */
	public String getCvyRefNo() {
		return this.cvyRefNo;
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
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
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
	 * @return uqVslIdNo
	 */
	public String getUqVslIdNo() {
		return this.uqVslIdNo;
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
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return ydcd
	 */
	public String getYdcd() {
		return this.ydcd;
	}
	

	/**
	 * Column Info
	 * @param etb
	 */
	public void setEtb(String etb) {
		this.etb = etb;
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
	 * @param clptCd
	 */
	public void setClptCd(String clptCd) {
		this.clptCd = clptCd;
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
	 * @param skdCallSeq
	 */
	public void setSkdCallSeq(String skdCallSeq) {
		this.skdCallSeq = skdCallSeq;
	}
	
	/**
	 * Column Info
	 * @param cvyRefNo
	 */
	public void setCvyRefNo(String cvyRefNo) {
		this.cvyRefNo = cvyRefNo;
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
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
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
	 * @param uqVslIdNo
	 */
	public void setUqVslIdNo(String uqVslIdNo) {
		this.uqVslIdNo = uqVslIdNo;
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
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param ydcd
	 */
	public void setYdcd(String ydcd) {
		this.ydcd = ydcd;
	}
	
	/**
	 * Request 넘어온 단건 DATA를 VO Class 에 담는다. 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setEtb(JSPUtil.getParameter(request, "etb", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setClptCd(JSPUtil.getParameter(request, "clpt_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setSkdCallSeq(JSPUtil.getParameter(request, "skd_call_seq", ""));
		setCvyRefNo(JSPUtil.getParameter(request, "cvy_ref_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setLane(JSPUtil.getParameter(request, "lane", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setUqVslIdNo(JSPUtil.getParameter(request, "uq_vsl_id_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setYdcd(JSPUtil.getParameter(request, "ydcd", ""));
	}

	/**
	 * Request를 VO Class를 담는다.
	 * @param request
	 * @return VslDchgYdListVO[]
	 */
	public VslDchgYdListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VslDchgYdListVO[]
	 */
	public VslDchgYdListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VslDchgYdListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] etb = (JSPUtil.getParameter(request, prefix	+ "etb".trim(), length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd".trim(), length));
			String[] clptCd = (JSPUtil.getParameter(request, prefix	+ "clpt_cd".trim(), length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no".trim(), length));
			String[] skdCallSeq = (JSPUtil.getParameter(request, prefix	+ "skd_call_seq".trim(), length));
			String[] cvyRefNo = (JSPUtil.getParameter(request, prefix	+ "cvy_ref_no".trim(), length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane".trim(), length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd".trim(), length));
			String[] uqVslIdNo = (JSPUtil.getParameter(request, prefix	+ "uq_vsl_id_no".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd".trim(), length));
			String[] ydcd = (JSPUtil.getParameter(request, prefix	+ "ydcd".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new VslDchgYdListVO();
				if (etb[i] != null)
					model.setEtb(etb[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (clptCd[i] != null)
					model.setClptCd(clptCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdCallSeq[i] != null)
					model.setSkdCallSeq(skdCallSeq[i]);
				if (cvyRefNo[i] != null)
					model.setCvyRefNo(cvyRefNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (uqVslIdNo[i] != null)
					model.setUqVslIdNo(uqVslIdNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (ydcd[i] != null)
					model.setYdcd(ydcd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVslDchgYdListVOs();
	}

	/**
	 * 여러 VO Calss를 배열화 한다 
	 * @return VslDchgYdListVO[]
	 */
	public VslDchgYdListVO[] getVslDchgYdListVOs(){
		VslDchgYdListVO[] vos = (VslDchgYdListVO[])models.toArray(new VslDchgYdListVO[models.size()]);
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
		this.etb = this.etb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptCd = this.clptCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdCallSeq = this.skdCallSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvyRefNo = this.cvyRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uqVslIdNo = this.uqVslIdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydcd = this.ydcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
