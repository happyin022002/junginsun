/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CondDeliveryScheduleVO.java
*@FileTitle : CondDeliveryScheduleVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.22
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.04.22 최우석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.vo;

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
 * @author 최우석
 * @see
 * @since J2EE 1.5
 */

public class CondDeliveryScheduleVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CondDeliveryScheduleVO> models = new ArrayList<CondDeliveryScheduleVO>();
	
	/* 而щ읆 �ㅻ챸 */
	private String shpNm = null;
	/* 而щ읆 �ㅻ챸 */
	private String vslDeDt1 = null;
	/* �곹깭 */
	private String ibflag = null;
	/* 而щ읆 �ㅻ챸 */
	private String vslCdSize2 = null;
	/* 而щ읆 �ㅻ챸 */
	private String periodFlag = null;
	/* 而щ읆 �ㅻ챸 */
	private String ownrSeq = null;
	/* 而щ읆 �ㅻ챸 */
	private String vslCdSizeFlag = null;
	/* 而щ읆 �ㅻ챸 */
	private String vslDeDt2 = null;
	/* 而щ읆 �ㅻ챸 */
	private String vslCdSize1 = null;
	/* 而щ읆 �ㅻ챸 */
	private String ydSeq = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CondDeliveryScheduleVO() {}

	public CondDeliveryScheduleVO(String ibflag, String pagerows, String shpNm, String vslDeDt1, String vslCdSize1, String ownrSeq, String vslCdSize2, String vslDeDt2, String ydSeq, String periodFlag, String vslCdSizeFlag) {
		this.shpNm = shpNm;
		this.vslDeDt1 = vslDeDt1;
		this.ibflag = ibflag;
		this.vslCdSize2 = vslCdSize2;
		this.periodFlag = periodFlag;
		this.ownrSeq = ownrSeq;
		this.vslCdSizeFlag = vslCdSizeFlag;
		this.vslDeDt2 = vslDeDt2;
		this.vslCdSize1 = vslCdSize1;
		this.ydSeq = ydSeq;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("shp_nm", getShpNm());
		this.hashColumns.put("vsl_de_dt1", getVslDeDt1());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_cd_size2", getVslCdSize2());
		this.hashColumns.put("period_flag", getPeriodFlag());
		this.hashColumns.put("ownr_seq", getOwnrSeq());
		this.hashColumns.put("vsl_cd_size_flag", getVslCdSizeFlag());
		this.hashColumns.put("vsl_de_dt2", getVslDeDt2());
		this.hashColumns.put("vsl_cd_size1", getVslCdSize1());
		this.hashColumns.put("yd_seq", getYdSeq());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("shp_nm", "shpNm");
		this.hashFields.put("vsl_de_dt1", "vslDeDt1");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_cd_size2", "vslCdSize2");
		this.hashFields.put("period_flag", "periodFlag");
		this.hashFields.put("ownr_seq", "ownrSeq");
		this.hashFields.put("vsl_cd_size_flag", "vslCdSizeFlag");
		this.hashFields.put("vsl_de_dt2", "vslDeDt2");
		this.hashFields.put("vsl_cd_size1", "vslCdSize1");
		this.hashFields.put("yd_seq", "ydSeq");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getShpNm() {
		return this.shpNm;
	}
	public String getVslDeDt1() {
		return this.vslDeDt1;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getVslCdSize2() {
		return this.vslCdSize2;
	}
	public String getPeriodFlag() {
		return this.periodFlag;
	}
	public String getOwnrSeq() {
		return this.ownrSeq;
	}
	public String getVslCdSizeFlag() {
		return this.vslCdSizeFlag;
	}
	public String getVslDeDt2() {
		return this.vslDeDt2;
	}
	public String getVslCdSize1() {
		return this.vslCdSize1;
	}
	public String getYdSeq() {
		return this.ydSeq;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setShpNm(String shpNm) {
		this.shpNm = shpNm;
		//this.shpNm=true;
	}
	public void setVslDeDt1(String vslDeDt1) {
		this.vslDeDt1 = vslDeDt1;
		//this.vslDeDt1=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setVslCdSize2(String vslCdSize2) {
		this.vslCdSize2 = vslCdSize2;
		//this.vslCdSize2=true;
	}
	public void setPeriodFlag(String periodFlag) {
		this.periodFlag = periodFlag;
		//this.periodFlag=true;
	}
	public void setOwnrSeq(String ownrSeq) {
		this.ownrSeq = ownrSeq;
		//this.ownrSeq=true;
	}
	public void setVslCdSizeFlag(String vslCdSizeFlag) {
		this.vslCdSizeFlag = vslCdSizeFlag;
		//this.vslCdSizeFlag=true;
	}
	public void setVslDeDt2(String vslDeDt2) {
		this.vslDeDt2 = vslDeDt2;
		//this.vslDeDt2=true;
	}
	public void setVslCdSize1(String vslCdSize1) {
		this.vslCdSize1 = vslCdSize1;
		//this.vslCdSize1=true;
	}
	public void setYdSeq(String ydSeq) {
		this.ydSeq = ydSeq;
		//this.ydSeq=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setShpNm(JSPUtil.getParameter(request, "shpNm", ""));
		setVslDeDt1(JSPUtil.getParameter(request, "vslDeDt1", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVslCdSize2(JSPUtil.getParameter(request, "vslCdSize2", ""));
		setPeriodFlag(JSPUtil.getParameter(request, "periodFlag", ""));
		setOwnrSeq(JSPUtil.getParameter(request, "ownrSeq", ""));
		setVslCdSizeFlag(JSPUtil.getParameter(request, "vslCdSizeFlag", ""));
		setVslDeDt2(JSPUtil.getParameter(request, "vslDeDt2", ""));
		setVslCdSize1(JSPUtil.getParameter(request, "vslCdSize1", ""));
		setYdSeq(JSPUtil.getParameter(request, "ydSeq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public CondDeliveryScheduleVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public CondDeliveryScheduleVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CondDeliveryScheduleVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] shpNm = (JSPUtil.getParameter(request, prefix	+ "shp_nm".trim(), length));
			String[] vslDeDt1 = (JSPUtil.getParameter(request, prefix	+ "vsl_de_dt1".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] vslCdSize2 = (JSPUtil.getParameter(request, prefix	+ "vsl_cd_size2".trim(), length));
			String[] periodFlag = (JSPUtil.getParameter(request, prefix	+ "period_flag".trim(), length));
			String[] ownrSeq = (JSPUtil.getParameter(request, prefix	+ "ownr_seq".trim(), length));
			String[] vslCdSizeFlag = (JSPUtil.getParameter(request, prefix	+ "vsl_cd_size_flag".trim(), length));
			String[] vslDeDt2 = (JSPUtil.getParameter(request, prefix	+ "vsl_de_dt2".trim(), length));
			String[] vslCdSize1 = (JSPUtil.getParameter(request, prefix	+ "vsl_cd_size1".trim(), length));
			String[] ydSeq = (JSPUtil.getParameter(request, prefix	+ "yd_seq".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new CondDeliveryScheduleVO();
				if (shpNm[i] != null)
					model.setShpNm(shpNm[i]);
				if (vslDeDt1[i] != null)
					model.setVslDeDt1(vslDeDt1[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslCdSize2[i] != null)
					model.setVslCdSize2(vslCdSize2[i]);
				if (periodFlag[i] != null)
					model.setPeriodFlag(periodFlag[i]);
				if (ownrSeq[i] != null)
					model.setOwnrSeq(ownrSeq[i]);
				if (vslCdSizeFlag[i] != null)
					model.setVslCdSizeFlag(vslCdSizeFlag[i]);
				if (vslDeDt2[i] != null)
					model.setVslDeDt2(vslDeDt2[i]);
				if (vslCdSize1[i] != null)
					model.setVslCdSize1(vslCdSize1[i]);
				if (ydSeq[i] != null)
					model.setYdSeq(ydSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getCondDeliveryScheduleVOs();
	}

	public CondDeliveryScheduleVO[] getCondDeliveryScheduleVOs(){
		CondDeliveryScheduleVO[] vos = (CondDeliveryScheduleVO[])models.toArray(new CondDeliveryScheduleVO[models.size()]);
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
		this.shpNm = this.shpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDeDt1 = this.vslDeDt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCdSize2 = this.vslCdSize2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.periodFlag = this.periodFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrSeq = this.ownrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCdSizeFlag = this.vslCdSizeFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDeDt2 = this.vslDeDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCdSize1 = this.vslCdSize1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydSeq = this.ydSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
