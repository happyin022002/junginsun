/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrMvntDtlsVO.java
*@FileTitle : CntrMvntDtlsVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.02
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.02  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

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

public class CntrMvntDtlsVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CntrMvntDtlsVO> models = new ArrayList<CntrMvntDtlsVO>();
	
	/* Column Info */
	private String sealNo = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String stsNm = null;
	/* Column Info */
	private String msg = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String eventDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String fcusFlg = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String actNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CntrMvntDtlsVO() {}

	public CntrMvntDtlsVO(String ibflag, String pagerows, String stsNm, String eventDt, String actNm, String locCd, String vvd, String sealNo, String msg, String blNo, String updDt, String cntrNo, String fcusFlg) {
		this.sealNo = sealNo;
		this.updDt = updDt;
		this.stsNm = stsNm;
		this.msg = msg;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.eventDt = eventDt;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.fcusFlg = fcusFlg;
		this.cntrNo = cntrNo;
		this.actNm = actNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("seal_no", getSealNo());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("sts_nm", getStsNm());
		this.hashColumns.put("msg", getMsg());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("event_dt", getEventDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("fcus_flg", getFcusFlg());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("act_nm", getActNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("seal_no", "sealNo");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("sts_nm", "stsNm");
		this.hashFields.put("msg", "msg");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("event_dt", "eventDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("fcus_flg", "fcusFlg");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("act_nm", "actNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sealNo
	 */
	public String getSealNo() {
		return this.sealNo;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return stsNm
	 */
	public String getStsNm() {
		return this.stsNm;
	}
	
	/**
	 * Column Info
	 * @return msg
	 */
	public String getMsg() {
		return this.msg;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return eventDt
	 */
	public String getEventDt() {
		return this.eventDt;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return fcusFlg
	 */
	public String getFcusFlg() {
		return this.fcusFlg;
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
	 * @return actNm
	 */
	public String getActNm() {
		return this.actNm;
	}
	

	/**
	 * Column Info
	 * @param sealNo
	 */
	public void setSealNo(String sealNo) {
		this.sealNo = sealNo;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param stsNm
	 */
	public void setStsNm(String stsNm) {
		this.stsNm = stsNm;
	}
	
	/**
	 * Column Info
	 * @param msg
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param eventDt
	 */
	public void setEventDt(String eventDt) {
		this.eventDt = eventDt;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param fcusFlg
	 */
	public void setFcusFlg(String fcusFlg) {
		this.fcusFlg = fcusFlg;
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
	 * @param actNm
	 */
	public void setActNm(String actNm) {
		this.actNm = actNm;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSealNo(JSPUtil.getParameter(request, "seal_no", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setStsNm(JSPUtil.getParameter(request, "sts_nm", ""));
		setMsg(JSPUtil.getParameter(request, "msg", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setEventDt(JSPUtil.getParameter(request, "event_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setFcusFlg(JSPUtil.getParameter(request, "fcus_flg", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setActNm(JSPUtil.getParameter(request, "act_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CntrMvntDtlsVO[]
	 */
	public CntrMvntDtlsVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CntrMvntDtlsVO[]
	 */
	public CntrMvntDtlsVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CntrMvntDtlsVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sealNo = (JSPUtil.getParameter(request, prefix	+ "seal_no", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] stsNm = (JSPUtil.getParameter(request, prefix	+ "sts_nm", length));
			String[] msg = (JSPUtil.getParameter(request, prefix	+ "msg", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] eventDt = (JSPUtil.getParameter(request, prefix	+ "event_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] fcusFlg = (JSPUtil.getParameter(request, prefix	+ "fcus_flg", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] actNm = (JSPUtil.getParameter(request, prefix	+ "act_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new CntrMvntDtlsVO();
				if (sealNo[i] != null)
					model.setSealNo(sealNo[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (stsNm[i] != null)
					model.setStsNm(stsNm[i]);
				if (msg[i] != null)
					model.setMsg(msg[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (eventDt[i] != null)
					model.setEventDt(eventDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (fcusFlg[i] != null)
					model.setFcusFlg(fcusFlg[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (actNm[i] != null)
					model.setActNm(actNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCntrMvntDtlsVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CntrMvntDtlsVO[]
	 */
	public CntrMvntDtlsVO[] getCntrMvntDtlsVOs(){
		CntrMvntDtlsVO[] vos = (CntrMvntDtlsVO[])models.toArray(new CntrMvntDtlsVO[models.size()]);
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
		this.sealNo = this.sealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsNm = this.stsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msg = this.msg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eventDt = this.eventDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcusFlg = this.fcusFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actNm = this.actNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
