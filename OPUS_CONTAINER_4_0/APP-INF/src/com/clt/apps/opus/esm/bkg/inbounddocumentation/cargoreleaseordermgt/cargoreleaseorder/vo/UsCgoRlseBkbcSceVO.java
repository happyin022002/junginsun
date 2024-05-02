/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsCgoRlseBkbcSceVO.java
*@FileTitle : UsCgoRlseBkbcSceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.04
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.04  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

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

public class UsCgoRlseBkbcSceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsCgoRlseBkbcSceVO> models = new ArrayList<UsCgoRlseBkbcSceVO>();
	
	/* Column Info */
	private String eventYd = null;
	/* Column Info */
	private String sceOb = null;
	/* Column Info */
	private String sceCfCnt = null;
	/* Column Info */
	private String sceCf = null;
	/* Column Info */
	private String sceCc = null;
	/* Column Info */
	private String sceCcCnt = null;
	/* Column Info */
	private String sceHr = null;
	/* Column Info */
	private String sceKnd = null;
	/* Column Info */
	private String scePa = null;
	/* Column Info */
	private String sceCrCnt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String eventDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sceFr = null;
	/* Column Info */
	private String scePqCnt = null;
	/* Column Info */
	private String sceCr = null;
	/* Column Info */
	private String sceObCnt = null;
	/* Column Info */
	private String scePaCnt = null;
	/* Column Info */
	private String sceCt = null;
	/* Column Info */
	private String sceHrCnt = null;
	/* Column Info */
	private String sceFrCnt = null;
	/* Column Info */
	private String scePq = null;
	/* Column Info */
	private String sceCtCnt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsCgoRlseBkbcSceVO() {}

	public UsCgoRlseBkbcSceVO(String ibflag, String pagerows, String sceCf, String sceCfCnt, String sceCt, String sceCtCnt, String sceCc, String sceCcCnt, String sceCr, String sceCrCnt, String sceHr, String sceHrCnt, String scePa, String scePaCnt, String scePq, String scePqCnt, String sceFr, String sceFrCnt, String sceOb, String sceObCnt, String sceKnd, String eventYd, String eventDt) {
		this.eventYd = eventYd;
		this.sceOb = sceOb;
		this.sceCfCnt = sceCfCnt;
		this.sceCf = sceCf;
		this.sceCc = sceCc;
		this.sceCcCnt = sceCcCnt;
		this.sceHr = sceHr;
		this.sceKnd = sceKnd;
		this.scePa = scePa;
		this.sceCrCnt = sceCrCnt;
		this.pagerows = pagerows;
		this.eventDt = eventDt;
		this.ibflag = ibflag;
		this.sceFr = sceFr;
		this.scePqCnt = scePqCnt;
		this.sceCr = sceCr;
		this.sceObCnt = sceObCnt;
		this.scePaCnt = scePaCnt;
		this.sceCt = sceCt;
		this.sceHrCnt = sceHrCnt;
		this.sceFrCnt = sceFrCnt;
		this.scePq = scePq;
		this.sceCtCnt = sceCtCnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("event_yd", getEventYd());
		this.hashColumns.put("sce_ob", getSceOb());
		this.hashColumns.put("sce_cf_cnt", getSceCfCnt());
		this.hashColumns.put("sce_cf", getSceCf());
		this.hashColumns.put("sce_cc", getSceCc());
		this.hashColumns.put("sce_cc_cnt", getSceCcCnt());
		this.hashColumns.put("sce_hr", getSceHr());
		this.hashColumns.put("sce_knd", getSceKnd());
		this.hashColumns.put("sce_pa", getScePa());
		this.hashColumns.put("sce_cr_cnt", getSceCrCnt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("event_dt", getEventDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sce_fr", getSceFr());
		this.hashColumns.put("sce_pq_cnt", getScePqCnt());
		this.hashColumns.put("sce_cr", getSceCr());
		this.hashColumns.put("sce_ob_cnt", getSceObCnt());
		this.hashColumns.put("sce_pa_cnt", getScePaCnt());
		this.hashColumns.put("sce_ct", getSceCt());
		this.hashColumns.put("sce_hr_cnt", getSceHrCnt());
		this.hashColumns.put("sce_fr_cnt", getSceFrCnt());
		this.hashColumns.put("sce_pq", getScePq());
		this.hashColumns.put("sce_ct_cnt", getSceCtCnt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("event_yd", "eventYd");
		this.hashFields.put("sce_ob", "sceOb");
		this.hashFields.put("sce_cf_cnt", "sceCfCnt");
		this.hashFields.put("sce_cf", "sceCf");
		this.hashFields.put("sce_cc", "sceCc");
		this.hashFields.put("sce_cc_cnt", "sceCcCnt");
		this.hashFields.put("sce_hr", "sceHr");
		this.hashFields.put("sce_knd", "sceKnd");
		this.hashFields.put("sce_pa", "scePa");
		this.hashFields.put("sce_cr_cnt", "sceCrCnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("event_dt", "eventDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sce_fr", "sceFr");
		this.hashFields.put("sce_pq_cnt", "scePqCnt");
		this.hashFields.put("sce_cr", "sceCr");
		this.hashFields.put("sce_ob_cnt", "sceObCnt");
		this.hashFields.put("sce_pa_cnt", "scePaCnt");
		this.hashFields.put("sce_ct", "sceCt");
		this.hashFields.put("sce_hr_cnt", "sceHrCnt");
		this.hashFields.put("sce_fr_cnt", "sceFrCnt");
		this.hashFields.put("sce_pq", "scePq");
		this.hashFields.put("sce_ct_cnt", "sceCtCnt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return eventYd
	 */
	public String getEventYd() {
		return this.eventYd;
	}
	
	/**
	 * Column Info
	 * @return sceOb
	 */
	public String getSceOb() {
		return this.sceOb;
	}
	
	/**
	 * Column Info
	 * @return sceCfCnt
	 */
	public String getSceCfCnt() {
		return this.sceCfCnt;
	}
	
	/**
	 * Column Info
	 * @return sceCf
	 */
	public String getSceCf() {
		return this.sceCf;
	}
	
	/**
	 * Column Info
	 * @return sceCc
	 */
	public String getSceCc() {
		return this.sceCc;
	}
	
	/**
	 * Column Info
	 * @return sceCcCnt
	 */
	public String getSceCcCnt() {
		return this.sceCcCnt;
	}
	
	/**
	 * Column Info
	 * @return sceHr
	 */
	public String getSceHr() {
		return this.sceHr;
	}
	
	/**
	 * Column Info
	 * @return sceKnd
	 */
	public String getSceKnd() {
		return this.sceKnd;
	}
	
	/**
	 * Column Info
	 * @return scePa
	 */
	public String getScePa() {
		return this.scePa;
	}
	
	/**
	 * Column Info
	 * @return sceCrCnt
	 */
	public String getSceCrCnt() {
		return this.sceCrCnt;
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
	 * @return sceFr
	 */
	public String getSceFr() {
		return this.sceFr;
	}
	
	/**
	 * Column Info
	 * @return scePqCnt
	 */
	public String getScePqCnt() {
		return this.scePqCnt;
	}
	
	/**
	 * Column Info
	 * @return sceCr
	 */
	public String getSceCr() {
		return this.sceCr;
	}
	
	/**
	 * Column Info
	 * @return sceObCnt
	 */
	public String getSceObCnt() {
		return this.sceObCnt;
	}
	
	/**
	 * Column Info
	 * @return scePaCnt
	 */
	public String getScePaCnt() {
		return this.scePaCnt;
	}
	
	/**
	 * Column Info
	 * @return sceCt
	 */
	public String getSceCt() {
		return this.sceCt;
	}
	
	/**
	 * Column Info
	 * @return sceHrCnt
	 */
	public String getSceHrCnt() {
		return this.sceHrCnt;
	}
	
	/**
	 * Column Info
	 * @return sceFrCnt
	 */
	public String getSceFrCnt() {
		return this.sceFrCnt;
	}
	
	/**
	 * Column Info
	 * @return scePq
	 */
	public String getScePq() {
		return this.scePq;
	}
	
	/**
	 * Column Info
	 * @return sceCtCnt
	 */
	public String getSceCtCnt() {
		return this.sceCtCnt;
	}
	

	/**
	 * Column Info
	 * @param eventYd
	 */
	public void setEventYd(String eventYd) {
		this.eventYd = eventYd;
	}
	
	/**
	 * Column Info
	 * @param sceOb
	 */
	public void setSceOb(String sceOb) {
		this.sceOb = sceOb;
	}
	
	/**
	 * Column Info
	 * @param sceCfCnt
	 */
	public void setSceCfCnt(String sceCfCnt) {
		this.sceCfCnt = sceCfCnt;
	}
	
	/**
	 * Column Info
	 * @param sceCf
	 */
	public void setSceCf(String sceCf) {
		this.sceCf = sceCf;
	}
	
	/**
	 * Column Info
	 * @param sceCc
	 */
	public void setSceCc(String sceCc) {
		this.sceCc = sceCc;
	}
	
	/**
	 * Column Info
	 * @param sceCcCnt
	 */
	public void setSceCcCnt(String sceCcCnt) {
		this.sceCcCnt = sceCcCnt;
	}
	
	/**
	 * Column Info
	 * @param sceHr
	 */
	public void setSceHr(String sceHr) {
		this.sceHr = sceHr;
	}
	
	/**
	 * Column Info
	 * @param sceKnd
	 */
	public void setSceKnd(String sceKnd) {
		this.sceKnd = sceKnd;
	}
	
	/**
	 * Column Info
	 * @param scePa
	 */
	public void setScePa(String scePa) {
		this.scePa = scePa;
	}
	
	/**
	 * Column Info
	 * @param sceCrCnt
	 */
	public void setSceCrCnt(String sceCrCnt) {
		this.sceCrCnt = sceCrCnt;
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
	 * @param sceFr
	 */
	public void setSceFr(String sceFr) {
		this.sceFr = sceFr;
	}
	
	/**
	 * Column Info
	 * @param scePqCnt
	 */
	public void setScePqCnt(String scePqCnt) {
		this.scePqCnt = scePqCnt;
	}
	
	/**
	 * Column Info
	 * @param sceCr
	 */
	public void setSceCr(String sceCr) {
		this.sceCr = sceCr;
	}
	
	/**
	 * Column Info
	 * @param sceObCnt
	 */
	public void setSceObCnt(String sceObCnt) {
		this.sceObCnt = sceObCnt;
	}
	
	/**
	 * Column Info
	 * @param scePaCnt
	 */
	public void setScePaCnt(String scePaCnt) {
		this.scePaCnt = scePaCnt;
	}
	
	/**
	 * Column Info
	 * @param sceCt
	 */
	public void setSceCt(String sceCt) {
		this.sceCt = sceCt;
	}
	
	/**
	 * Column Info
	 * @param sceHrCnt
	 */
	public void setSceHrCnt(String sceHrCnt) {
		this.sceHrCnt = sceHrCnt;
	}
	
	/**
	 * Column Info
	 * @param sceFrCnt
	 */
	public void setSceFrCnt(String sceFrCnt) {
		this.sceFrCnt = sceFrCnt;
	}
	
	/**
	 * Column Info
	 * @param scePq
	 */
	public void setScePq(String scePq) {
		this.scePq = scePq;
	}
	
	/**
	 * Column Info
	 * @param sceCtCnt
	 */
	public void setSceCtCnt(String sceCtCnt) {
		this.sceCtCnt = sceCtCnt;
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
		setEventYd(JSPUtil.getParameter(request, prefix + "event_yd", ""));
		setSceOb(JSPUtil.getParameter(request, prefix + "sce_ob", ""));
		setSceCfCnt(JSPUtil.getParameter(request, prefix + "sce_cf_cnt", ""));
		setSceCf(JSPUtil.getParameter(request, prefix + "sce_cf", ""));
		setSceCc(JSPUtil.getParameter(request, prefix + "sce_cc", ""));
		setSceCcCnt(JSPUtil.getParameter(request, prefix + "sce_cc_cnt", ""));
		setSceHr(JSPUtil.getParameter(request, prefix + "sce_hr", ""));
		setSceKnd(JSPUtil.getParameter(request, prefix + "sce_knd", ""));
		setScePa(JSPUtil.getParameter(request, prefix + "sce_pa", ""));
		setSceCrCnt(JSPUtil.getParameter(request, prefix + "sce_cr_cnt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEventDt(JSPUtil.getParameter(request, prefix + "event_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSceFr(JSPUtil.getParameter(request, prefix + "sce_fr", ""));
		setScePqCnt(JSPUtil.getParameter(request, prefix + "sce_pq_cnt", ""));
		setSceCr(JSPUtil.getParameter(request, prefix + "sce_cr", ""));
		setSceObCnt(JSPUtil.getParameter(request, prefix + "sce_ob_cnt", ""));
		setScePaCnt(JSPUtil.getParameter(request, prefix + "sce_pa_cnt", ""));
		setSceCt(JSPUtil.getParameter(request, prefix + "sce_ct", ""));
		setSceHrCnt(JSPUtil.getParameter(request, prefix + "sce_hr_cnt", ""));
		setSceFrCnt(JSPUtil.getParameter(request, prefix + "sce_fr_cnt", ""));
		setScePq(JSPUtil.getParameter(request, prefix + "sce_pq", ""));
		setSceCtCnt(JSPUtil.getParameter(request, prefix + "sce_ct_cnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsCgoRlseBkbcSceVO[]
	 */
	public UsCgoRlseBkbcSceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsCgoRlseBkbcSceVO[]
	 */
	public UsCgoRlseBkbcSceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsCgoRlseBkbcSceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] eventYd = (JSPUtil.getParameter(request, prefix	+ "event_yd", length));
			String[] sceOb = (JSPUtil.getParameter(request, prefix	+ "sce_ob", length));
			String[] sceCfCnt = (JSPUtil.getParameter(request, prefix	+ "sce_cf_cnt", length));
			String[] sceCf = (JSPUtil.getParameter(request, prefix	+ "sce_cf", length));
			String[] sceCc = (JSPUtil.getParameter(request, prefix	+ "sce_cc", length));
			String[] sceCcCnt = (JSPUtil.getParameter(request, prefix	+ "sce_cc_cnt", length));
			String[] sceHr = (JSPUtil.getParameter(request, prefix	+ "sce_hr", length));
			String[] sceKnd = (JSPUtil.getParameter(request, prefix	+ "sce_knd", length));
			String[] scePa = (JSPUtil.getParameter(request, prefix	+ "sce_pa", length));
			String[] sceCrCnt = (JSPUtil.getParameter(request, prefix	+ "sce_cr_cnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] eventDt = (JSPUtil.getParameter(request, prefix	+ "event_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sceFr = (JSPUtil.getParameter(request, prefix	+ "sce_fr", length));
			String[] scePqCnt = (JSPUtil.getParameter(request, prefix	+ "sce_pq_cnt", length));
			String[] sceCr = (JSPUtil.getParameter(request, prefix	+ "sce_cr", length));
			String[] sceObCnt = (JSPUtil.getParameter(request, prefix	+ "sce_ob_cnt", length));
			String[] scePaCnt = (JSPUtil.getParameter(request, prefix	+ "sce_pa_cnt", length));
			String[] sceCt = (JSPUtil.getParameter(request, prefix	+ "sce_ct", length));
			String[] sceHrCnt = (JSPUtil.getParameter(request, prefix	+ "sce_hr_cnt", length));
			String[] sceFrCnt = (JSPUtil.getParameter(request, prefix	+ "sce_fr_cnt", length));
			String[] scePq = (JSPUtil.getParameter(request, prefix	+ "sce_pq", length));
			String[] sceCtCnt = (JSPUtil.getParameter(request, prefix	+ "sce_ct_cnt", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsCgoRlseBkbcSceVO();
				if (eventYd[i] != null)
					model.setEventYd(eventYd[i]);
				if (sceOb[i] != null)
					model.setSceOb(sceOb[i]);
				if (sceCfCnt[i] != null)
					model.setSceCfCnt(sceCfCnt[i]);
				if (sceCf[i] != null)
					model.setSceCf(sceCf[i]);
				if (sceCc[i] != null)
					model.setSceCc(sceCc[i]);
				if (sceCcCnt[i] != null)
					model.setSceCcCnt(sceCcCnt[i]);
				if (sceHr[i] != null)
					model.setSceHr(sceHr[i]);
				if (sceKnd[i] != null)
					model.setSceKnd(sceKnd[i]);
				if (scePa[i] != null)
					model.setScePa(scePa[i]);
				if (sceCrCnt[i] != null)
					model.setSceCrCnt(sceCrCnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (eventDt[i] != null)
					model.setEventDt(eventDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sceFr[i] != null)
					model.setSceFr(sceFr[i]);
				if (scePqCnt[i] != null)
					model.setScePqCnt(scePqCnt[i]);
				if (sceCr[i] != null)
					model.setSceCr(sceCr[i]);
				if (sceObCnt[i] != null)
					model.setSceObCnt(sceObCnt[i]);
				if (scePaCnt[i] != null)
					model.setScePaCnt(scePaCnt[i]);
				if (sceCt[i] != null)
					model.setSceCt(sceCt[i]);
				if (sceHrCnt[i] != null)
					model.setSceHrCnt(sceHrCnt[i]);
				if (sceFrCnt[i] != null)
					model.setSceFrCnt(sceFrCnt[i]);
				if (scePq[i] != null)
					model.setScePq(scePq[i]);
				if (sceCtCnt[i] != null)
					model.setSceCtCnt(sceCtCnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsCgoRlseBkbcSceVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsCgoRlseBkbcSceVO[]
	 */
	public UsCgoRlseBkbcSceVO[] getUsCgoRlseBkbcSceVOs(){
		UsCgoRlseBkbcSceVO[] vos = (UsCgoRlseBkbcSceVO[])models.toArray(new UsCgoRlseBkbcSceVO[models.size()]);
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
		this.eventYd = this.eventYd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sceOb = this.sceOb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sceCfCnt = this.sceCfCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sceCf = this.sceCf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sceCc = this.sceCc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sceCcCnt = this.sceCcCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sceHr = this.sceHr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sceKnd = this.sceKnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scePa = this.scePa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sceCrCnt = this.sceCrCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eventDt = this.eventDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sceFr = this.sceFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scePqCnt = this.scePqCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sceCr = this.sceCr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sceObCnt = this.sceObCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scePaCnt = this.scePaCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sceCt = this.sceCt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sceHrCnt = this.sceHrCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sceFrCnt = this.sceFrCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scePq = this.scePq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sceCtCnt = this.sceCtCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
