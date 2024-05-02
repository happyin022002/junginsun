/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VendorVO.java
*@FileTitle : VendorVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.29
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.04.29 김진일 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 서창열
 * @since J2EE 1.5
 */

public class VendorVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VendorVO> models = new ArrayList<VendorVO>();
	
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String vndrCntCd = null;
	/* Column Info */
	private String tcnt = null;
	/* Column Info */
	private String vndrNm = null;
	/* Column Info */
	private String vndrAbbrNm = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String updUsrId = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VendorVO() {}

	public VendorVO(String ibflag, String pagerows, String tcnt, String ofcCd, String vndrCntCd, String vndrLglEngNm, String vndrSeq, String vndrNm, String vndrAbbrNm, String updUsrId) {
		this.ibflag = ibflag;
		this.vndrSeq = vndrSeq;
		this.vndrCntCd = vndrCntCd;
		this.tcnt = tcnt;
		this.vndrNm = vndrNm;
		this.vndrAbbrNm = vndrAbbrNm;
		this.ofcCd = ofcCd;
		this.vndrLglEngNm = vndrLglEngNm;
		this.pagerows = pagerows;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("vndr_cnt_cd", getVndrCntCd());
		this.hashColumns.put("tcnt", getTcnt());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("vndr_cnt_cd", "vndrCntCd");
		this.hashFields.put("tcnt", "tcnt");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	public String getIbflag() {
		return this.ibflag;
	}
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	public String getVndrCntCd() {
		return this.vndrCntCd;
	}
	public String getTcnt() {
		return this.tcnt;
	}
	public String getVndrNm() {
		return this.vndrNm;
	}
	public String getVndrAbbrNm() {
		return this.vndrAbbrNm;
	}
	public String getOfcCd() {
		return this.ofcCd;
	}
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
	}
	public String getPagerows() {
		return this.pagerows;
	}
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}

	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
		//this.vndrSeq=true;
	}
	public void setVndrCntCd(String vndrCntCd) {
		this.vndrCntCd = vndrCntCd;
		//this.vndrCntCd=true;
	}
	public void setTcnt(String tcnt) {
		this.tcnt = tcnt;
		//this.tcnt=true;
	}
	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
		//this.vndrNm=true;
	}
	public void setVndrAbbrNm(String vndrAbbrNm) {
		this.vndrAbbrNm = vndrAbbrNm;
		//this.vndrAbbrNm=true;
	}
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
		//this.ofcCd=true;
	}
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
		//this.vndrLglEngNm=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setVndrCntCd(JSPUtil.getParameter(request, "vndr_cnt_cd", ""));
		setTcnt(JSPUtil.getParameter(request, "tcnt", ""));
		setVndrNm(JSPUtil.getParameter(request, "vndr_nm", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request, "vndr_abbr_nm", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, "vndr_lgl_eng_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	public VendorVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public VendorVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VendorVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq".trim(), length));
			String[] vndrCntCd = (JSPUtil.getParameter(request, prefix	+ "vndr_cnt_cd".trim(), length));
			String[] tcnt = (JSPUtil.getParameter(request, prefix	+ "tcnt".trim(), length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm".trim(), length));
			String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_abbr_nm".trim(), length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd".trim(), length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new VendorVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (vndrCntCd[i] != null)
					model.setVndrCntCd(vndrCntCd[i]);
				if (tcnt[i] != null)
					model.setTcnt(tcnt[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (vndrAbbrNm[i] != null)
					model.setVndrAbbrNm(vndrAbbrNm[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getVendorVOs();
	}

	public VendorVO[] getVendorVOs(){
		VendorVO[] vos = (VendorVO[])models.toArray(new VendorVO[models.size()]);
		return vos;
	}
	
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
		} catch (Exception ex) {}
		return ret.toString();
	}
	
	/**
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 * @throws IllegalAccessException
	 */
	private String[] getField(Field[] field, int i) throws IllegalAccessException {
		String[] arr;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void onDataFormat(){
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCntCd = this.vndrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tcnt = this.tcnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm = this.vndrAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
