/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UnreportedOtsReportVO.java
*@FileTitle : UnreportedOtsReportVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.15
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.15  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo;

import java.lang.reflect.Field;
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

public class UnreportedOtsReportVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UnreportedOtsReportVO> models = new ArrayList<UnreportedOtsReportVO>();
	
	/* Column Info */
	private String asaNo1 = null;
	/* Column Info */
	private String asaNo3 = null;
	/* Column Info */
	private String asaNo2 = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String sailArrDt = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String dueDtFm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String tobeUsd = null;
	/* Column Info */
	private String dueDt = null;
	/* Column Info */
	private String actUsd = null;
	/* Column Info */
	private String asaUsd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public UnreportedOtsReportVO() {}

	public UnreportedOtsReportVO(String ibflag, String pagerows, String ofcCd, String vvdCd, String blNo, String sailArrDt, String dueDt, String actUsd, String asaUsd, String tobeUsd, String arOfcCd, String asaNo1, String asaNo2, String asaNo3, String dueDtFm) {
		this.asaNo1 = asaNo1;
		this.asaNo3 = asaNo3;
		this.asaNo2 = asaNo2;
		this.blNo = blNo;
		this.sailArrDt = sailArrDt;
		this.arOfcCd = arOfcCd;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.dueDtFm = dueDtFm;
		this.ibflag = ibflag;
		this.vvdCd = vvdCd;
		this.tobeUsd = tobeUsd;
		this.dueDt = dueDt;
		this.actUsd = actUsd;
		this.asaUsd = asaUsd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("asa_no1", getAsaNo1());
		this.hashColumns.put("asa_no3", getAsaNo3());
		this.hashColumns.put("asa_no2", getAsaNo2());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("sail_arr_dt", getSailArrDt());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("due_dt_fm", getDueDtFm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("tobe_usd", getTobeUsd());
		this.hashColumns.put("due_dt", getDueDt());
		this.hashColumns.put("act_usd", getActUsd());
		this.hashColumns.put("asa_usd", getAsaUsd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("asa_no1", "asaNo1");
		this.hashFields.put("asa_no3", "asaNo3");
		this.hashFields.put("asa_no2", "asaNo2");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("due_dt_fm", "dueDtFm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("tobe_usd", "tobeUsd");
		this.hashFields.put("due_dt", "dueDt");
		this.hashFields.put("act_usd", "actUsd");
		this.hashFields.put("asa_usd", "asaUsd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return asaNo1
	 */
	public String getAsaNo1() {
		return this.asaNo1;
	}
	
	/**
	 * Column Info
	 * @return asaNo3
	 */
	public String getAsaNo3() {
		return this.asaNo3;
	}
	
	/**
	 * Column Info
	 * @return asaNo2
	 */
	public String getAsaNo2() {
		return this.asaNo2;
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
	 * @return sailArrDt
	 */
	public String getSailArrDt() {
		return this.sailArrDt;
	}
	
	/**
	 * Column Info
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return dueDtFm
	 */
	public String getDueDtFm() {
		return this.dueDtFm;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return tobeUsd
	 */
	public String getTobeUsd() {
		return this.tobeUsd;
	}
	
	/**
	 * Column Info
	 * @return dueDt
	 */
	public String getDueDt() {
		return this.dueDt;
	}
	
	/**
	 * Column Info
	 * @return actUsd
	 */
	public String getActUsd() {
		return this.actUsd;
	}
	
	/**
	 * Column Info
	 * @return asaUsd
	 */
	public String getAsaUsd() {
		return this.asaUsd;
	}
	

	/**
	 * Column Info
	 * @param asaNo1
	 */
	public void setAsaNo1(String asaNo1) {
		this.asaNo1 = asaNo1;
	}
	
	/**
	 * Column Info
	 * @param asaNo3
	 */
	public void setAsaNo3(String asaNo3) {
		this.asaNo3 = asaNo3;
	}
	
	/**
	 * Column Info
	 * @param asaNo2
	 */
	public void setAsaNo2(String asaNo2) {
		this.asaNo2 = asaNo2;
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
	 * @param sailArrDt
	 */
	public void setSailArrDt(String sailArrDt) {
		this.sailArrDt = sailArrDt;
	}
	
	/**
	 * Column Info
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param dueDtFm
	 */
	public void setDueDtFm(String dueDtFm) {
		this.dueDtFm = dueDtFm;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param tobeUsd
	 */
	public void setTobeUsd(String tobeUsd) {
		this.tobeUsd = tobeUsd;
	}
	
	/**
	 * Column Info
	 * @param dueDt
	 */
	public void setDueDt(String dueDt) {
		this.dueDt = dueDt;
	}
	
	/**
	 * Column Info
	 * @param actUsd
	 */
	public void setActUsd(String actUsd) {
		this.actUsd = actUsd;
	}
	
	/**
	 * Column Info
	 * @param asaUsd
	 */
	public void setAsaUsd(String asaUsd) {
		this.asaUsd = asaUsd;
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
		setAsaNo1(JSPUtil.getParameter(request, prefix + "asa_no1", ""));
		setAsaNo3(JSPUtil.getParameter(request, prefix + "asa_no3", ""));
		setAsaNo2(JSPUtil.getParameter(request, prefix + "asa_no2", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setSailArrDt(JSPUtil.getParameter(request, prefix + "sail_arr_dt", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setDueDtFm(JSPUtil.getParameter(request, prefix + "due_dt_fm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setTobeUsd(JSPUtil.getParameter(request, prefix + "tobe_usd", ""));
		setDueDt(JSPUtil.getParameter(request, prefix + "due_dt", ""));
		setActUsd(JSPUtil.getParameter(request, prefix + "act_usd", ""));
		setAsaUsd(JSPUtil.getParameter(request, prefix + "asa_usd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UnreportedOtsReportVO[]
	 */
	public UnreportedOtsReportVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UnreportedOtsReportVO[]
	 */
	public UnreportedOtsReportVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UnreportedOtsReportVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] asaNo1 = (JSPUtil.getParameter(request, prefix	+ "asa_no1", length));
			String[] asaNo3 = (JSPUtil.getParameter(request, prefix	+ "asa_no3", length));
			String[] asaNo2 = (JSPUtil.getParameter(request, prefix	+ "asa_no2", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] sailArrDt = (JSPUtil.getParameter(request, prefix	+ "sail_arr_dt", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] dueDtFm = (JSPUtil.getParameter(request, prefix	+ "due_dt_fm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] tobeUsd = (JSPUtil.getParameter(request, prefix	+ "tobe_usd", length));
			String[] dueDt = (JSPUtil.getParameter(request, prefix	+ "due_dt", length));
			String[] actUsd = (JSPUtil.getParameter(request, prefix	+ "act_usd", length));
			String[] asaUsd = (JSPUtil.getParameter(request, prefix	+ "asa_usd", length));
			
			for (int i = 0; i < length; i++) {
				model = new UnreportedOtsReportVO();
				if (asaNo1[i] != null)
					model.setAsaNo1(asaNo1[i]);
				if (asaNo3[i] != null)
					model.setAsaNo3(asaNo3[i]);
				if (asaNo2[i] != null)
					model.setAsaNo2(asaNo2[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (sailArrDt[i] != null)
					model.setSailArrDt(sailArrDt[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (dueDtFm[i] != null)
					model.setDueDtFm(dueDtFm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (tobeUsd[i] != null)
					model.setTobeUsd(tobeUsd[i]);
				if (dueDt[i] != null)
					model.setDueDt(dueDt[i]);
				if (actUsd[i] != null)
					model.setActUsd(actUsd[i]);
				if (asaUsd[i] != null)
					model.setAsaUsd(asaUsd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUnreportedOtsReportVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UnreportedOtsReportVO[]
	 */
	public UnreportedOtsReportVO[] getUnreportedOtsReportVOs(){
		UnreportedOtsReportVO[] vos = (UnreportedOtsReportVO[])models.toArray(new UnreportedOtsReportVO[models.size()]);
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
		this.asaNo1 = this.asaNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaNo3 = this.asaNo3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaNo2 = this.asaNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt = this.sailArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDtFm = this.dueDtFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tobeUsd = this.tobeUsd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDt = this.dueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actUsd = this.actUsd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaUsd = this.asaUsd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
