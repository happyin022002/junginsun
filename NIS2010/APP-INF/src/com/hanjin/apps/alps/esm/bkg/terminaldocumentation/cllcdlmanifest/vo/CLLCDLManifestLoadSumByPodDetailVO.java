/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CLLCDLManifestLoadSumByPodDetailVO.java
*@FileTitle : CLLCDLManifestLoadSumByPodDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.05  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class CLLCDLManifestLoadSumByPodDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CLLCDLManifestLoadSumByPodDetailVO> models = new ArrayList<CLLCDLManifestLoadSumByPodDetailVO>();
	
	/* Column Info */
	private String mt45 = null;
	/* Column Info */
	private String mt40h = null;
	/* Column Info */
	private String ts45 = null;
	/* Column Info */
	private String gubunCd2 = null;
	/* Column Info */
	private String wgtMt = null;
	/* Column Info */
	private String to40 = null;
	/* Column Info */
	private String ts20 = null;
	/* Column Info */
	private String mt20 = null;
	/* Column Info */
	private String mt40 = null;
	/* Column Info */
	private String to45 = null;
	/* Column Info */
	private String lo40 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String to20 = null;
	/* Column Info */
	private String lo45 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String lo20 = null;
	/* Column Info */
	private String ts40h = null;
	/* Column Info */
	private String lo40h = null;
	/* Column Info */
	private String to40h = null;
	/* Column Info */
	private String ts40 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CLLCDLManifestLoadSumByPodDetailVO() {}

	public CLLCDLManifestLoadSumByPodDetailVO(String ibflag, String pagerows, String mt45, String mt40h, String ts45, String wgtMt, String to40, String ts20, String mt20, String mt40, String to45, String lo40, String to20, String podCd, String lo45, String lo20, String ts40h, String to40h, String lo40h, String ts40, String gubunCd2) {
		this.mt45 = mt45;
		this.mt40h = mt40h;
		this.ts45 = ts45;
		this.gubunCd2 = gubunCd2;
		this.wgtMt = wgtMt;
		this.to40 = to40;
		this.ts20 = ts20;
		this.mt20 = mt20;
		this.mt40 = mt40;
		this.to45 = to45;
		this.lo40 = lo40;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.to20 = to20;
		this.lo45 = lo45;
		this.ibflag = ibflag;
		this.lo20 = lo20;
		this.ts40h = ts40h;
		this.lo40h = lo40h;
		this.to40h = to40h;
		this.ts40 = ts40;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mt_45", getMt45());
		this.hashColumns.put("mt_40h", getMt40h());
		this.hashColumns.put("ts_45", getTs45());
		this.hashColumns.put("gubun_cd2", getGubunCd2());
		this.hashColumns.put("wgt_mt", getWgtMt());
		this.hashColumns.put("to_40", getTo40());
		this.hashColumns.put("ts_20", getTs20());
		this.hashColumns.put("mt_20", getMt20());
		this.hashColumns.put("mt_40", getMt40());
		this.hashColumns.put("to_45", getTo45());
		this.hashColumns.put("lo_40", getLo40());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("to_20", getTo20());
		this.hashColumns.put("lo_45", getLo45());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("lo_20", getLo20());
		this.hashColumns.put("ts_40h", getTs40h());
		this.hashColumns.put("lo_40h", getLo40h());
		this.hashColumns.put("to_40h", getTo40h());
		this.hashColumns.put("ts_40", getTs40());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mt_45", "mt45");
		this.hashFields.put("mt_40h", "mt40h");
		this.hashFields.put("ts_45", "ts45");
		this.hashFields.put("gubun_cd2", "gubunCd2");
		this.hashFields.put("wgt_mt", "wgtMt");
		this.hashFields.put("to_40", "to40");
		this.hashFields.put("ts_20", "ts20");
		this.hashFields.put("mt_20", "mt20");
		this.hashFields.put("mt_40", "mt40");
		this.hashFields.put("to_45", "to45");
		this.hashFields.put("lo_40", "lo40");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("to_20", "to20");
		this.hashFields.put("lo_45", "lo45");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("lo_20", "lo20");
		this.hashFields.put("ts_40h", "ts40h");
		this.hashFields.put("lo_40h", "lo40h");
		this.hashFields.put("to_40h", "to40h");
		this.hashFields.put("ts_40", "ts40");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mt45
	 */
	public String getMt45() {
		return this.mt45;
	}
	
	/**
	 * Column Info
	 * @return mt40h
	 */
	public String getMt40h() {
		return this.mt40h;
	}
	
	/**
	 * Column Info
	 * @return ts45
	 */
	public String getTs45() {
		return this.ts45;
	}
	
	/**
	 * Column Info
	 * @return gubunCd2
	 */
	public String getGubunCd2() {
		return this.gubunCd2;
	}
	
	/**
	 * Column Info
	 * @return wgtMt
	 */
	public String getWgtMt() {
		return this.wgtMt;
	}
	
	/**
	 * Column Info
	 * @return to40
	 */
	public String getTo40() {
		return this.to40;
	}
	
	/**
	 * Column Info
	 * @return ts20
	 */
	public String getTs20() {
		return this.ts20;
	}
	
	/**
	 * Column Info
	 * @return mt20
	 */
	public String getMt20() {
		return this.mt20;
	}
	
	/**
	 * Column Info
	 * @return mt40
	 */
	public String getMt40() {
		return this.mt40;
	}
	
	/**
	 * Column Info
	 * @return to45
	 */
	public String getTo45() {
		return this.to45;
	}
	
	/**
	 * Column Info
	 * @return lo40
	 */
	public String getLo40() {
		return this.lo40;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return to20
	 */
	public String getTo20() {
		return this.to20;
	}
	
	/**
	 * Column Info
	 * @return lo45
	 */
	public String getLo45() {
		return this.lo45;
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
	 * @return lo20
	 */
	public String getLo20() {
		return this.lo20;
	}
	
	/**
	 * Column Info
	 * @return ts40h
	 */
	public String getTs40h() {
		return this.ts40h;
	}
	
	/**
	 * Column Info
	 * @return lo40h
	 */
	public String getLo40h() {
		return this.lo40h;
	}
	
	/**
	 * Column Info
	 * @return to40h
	 */
	public String getTo40h() {
		return this.to40h;
	}
	
	/**
	 * Column Info
	 * @return ts40
	 */
	public String getTs40() {
		return this.ts40;
	}
	

	/**
	 * Column Info
	 * @param mt45
	 */
	public void setMt45(String mt45) {
		this.mt45 = mt45;
	}
	
	/**
	 * Column Info
	 * @param mt40h
	 */
	public void setMt40h(String mt40h) {
		this.mt40h = mt40h;
	}
	
	/**
	 * Column Info
	 * @param ts45
	 */
	public void setTs45(String ts45) {
		this.ts45 = ts45;
	}
	
	/**
	 * Column Info
	 * @param gubunCd2
	 */
	public void setGubunCd2(String gubunCd2) {
		this.gubunCd2 = gubunCd2;
	}
	
	/**
	 * Column Info
	 * @param wgtMt
	 */
	public void setWgtMt(String wgtMt) {
		this.wgtMt = wgtMt;
	}
	
	/**
	 * Column Info
	 * @param to40
	 */
	public void setTo40(String to40) {
		this.to40 = to40;
	}
	
	/**
	 * Column Info
	 * @param ts20
	 */
	public void setTs20(String ts20) {
		this.ts20 = ts20;
	}
	
	/**
	 * Column Info
	 * @param mt20
	 */
	public void setMt20(String mt20) {
		this.mt20 = mt20;
	}
	
	/**
	 * Column Info
	 * @param mt40
	 */
	public void setMt40(String mt40) {
		this.mt40 = mt40;
	}
	
	/**
	 * Column Info
	 * @param to45
	 */
	public void setTo45(String to45) {
		this.to45 = to45;
	}
	
	/**
	 * Column Info
	 * @param lo40
	 */
	public void setLo40(String lo40) {
		this.lo40 = lo40;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param to20
	 */
	public void setTo20(String to20) {
		this.to20 = to20;
	}
	
	/**
	 * Column Info
	 * @param lo45
	 */
	public void setLo45(String lo45) {
		this.lo45 = lo45;
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
	 * @param lo20
	 */
	public void setLo20(String lo20) {
		this.lo20 = lo20;
	}
	
	/**
	 * Column Info
	 * @param ts40h
	 */
	public void setTs40h(String ts40h) {
		this.ts40h = ts40h;
	}
	
	/**
	 * Column Info
	 * @param lo40h
	 */
	public void setLo40h(String lo40h) {
		this.lo40h = lo40h;
	}
	
	/**
	 * Column Info
	 * @param to40h
	 */
	public void setTo40h(String to40h) {
		this.to40h = to40h;
	}
	
	/**
	 * Column Info
	 * @param ts40
	 */
	public void setTs40(String ts40) {
		this.ts40 = ts40;
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
		setMt45(JSPUtil.getParameter(request, prefix + "mt_45", ""));
		setMt40h(JSPUtil.getParameter(request, prefix + "mt_40h", ""));
		setTs45(JSPUtil.getParameter(request, prefix + "ts_45", ""));
		setGubunCd2(JSPUtil.getParameter(request, prefix + "gubun_cd2", ""));
		setWgtMt(JSPUtil.getParameter(request, prefix + "wgt_mt", ""));
		setTo40(JSPUtil.getParameter(request, prefix + "to_40", ""));
		setTs20(JSPUtil.getParameter(request, prefix + "ts_20", ""));
		setMt20(JSPUtil.getParameter(request, prefix + "mt_20", ""));
		setMt40(JSPUtil.getParameter(request, prefix + "mt_40", ""));
		setTo45(JSPUtil.getParameter(request, prefix + "to_45", ""));
		setLo40(JSPUtil.getParameter(request, prefix + "lo_40", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setTo20(JSPUtil.getParameter(request, prefix + "to_20", ""));
		setLo45(JSPUtil.getParameter(request, prefix + "lo_45", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLo20(JSPUtil.getParameter(request, prefix + "lo_20", ""));
		setTs40h(JSPUtil.getParameter(request, prefix + "ts_40h", ""));
		setLo40h(JSPUtil.getParameter(request, prefix + "lo_40h", ""));
		setTo40h(JSPUtil.getParameter(request, prefix + "to_40h", ""));
		setTs40(JSPUtil.getParameter(request, prefix + "ts_40", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CLLCDLManifestLoadSumByPodDetailVO[]
	 */
	public CLLCDLManifestLoadSumByPodDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CLLCDLManifestLoadSumByPodDetailVO[]
	 */
	public CLLCDLManifestLoadSumByPodDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CLLCDLManifestLoadSumByPodDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mt45 = (JSPUtil.getParameter(request, prefix	+ "mt_45", length));
			String[] mt40h = (JSPUtil.getParameter(request, prefix	+ "mt_40h", length));
			String[] ts45 = (JSPUtil.getParameter(request, prefix	+ "ts_45", length));
			String[] gubunCd2 = (JSPUtil.getParameter(request, prefix	+ "gubun_cd2", length));
			String[] wgtMt = (JSPUtil.getParameter(request, prefix	+ "wgt_mt", length));
			String[] to40 = (JSPUtil.getParameter(request, prefix	+ "to_40", length));
			String[] ts20 = (JSPUtil.getParameter(request, prefix	+ "ts_20", length));
			String[] mt20 = (JSPUtil.getParameter(request, prefix	+ "mt_20", length));
			String[] mt40 = (JSPUtil.getParameter(request, prefix	+ "mt_40", length));
			String[] to45 = (JSPUtil.getParameter(request, prefix	+ "to_45", length));
			String[] lo40 = (JSPUtil.getParameter(request, prefix	+ "lo_40", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] to20 = (JSPUtil.getParameter(request, prefix	+ "to_20", length));
			String[] lo45 = (JSPUtil.getParameter(request, prefix	+ "lo_45", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] lo20 = (JSPUtil.getParameter(request, prefix	+ "lo_20", length));
			String[] ts40h = (JSPUtil.getParameter(request, prefix	+ "ts_40h", length));
			String[] lo40h = (JSPUtil.getParameter(request, prefix	+ "lo_40h", length));
			String[] to40h = (JSPUtil.getParameter(request, prefix	+ "to_40h", length));
			String[] ts40 = (JSPUtil.getParameter(request, prefix	+ "ts_40", length));
			
			for (int i = 0; i < length; i++) {
				model = new CLLCDLManifestLoadSumByPodDetailVO();
				if (mt45[i] != null)
					model.setMt45(mt45[i]);
				if (mt40h[i] != null)
					model.setMt40h(mt40h[i]);
				if (ts45[i] != null)
					model.setTs45(ts45[i]);
				if (gubunCd2[i] != null)
					model.setGubunCd2(gubunCd2[i]);
				if (wgtMt[i] != null)
					model.setWgtMt(wgtMt[i]);
				if (to40[i] != null)
					model.setTo40(to40[i]);
				if (ts20[i] != null)
					model.setTs20(ts20[i]);
				if (mt20[i] != null)
					model.setMt20(mt20[i]);
				if (mt40[i] != null)
					model.setMt40(mt40[i]);
				if (to45[i] != null)
					model.setTo45(to45[i]);
				if (lo40[i] != null)
					model.setLo40(lo40[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (to20[i] != null)
					model.setTo20(to20[i]);
				if (lo45[i] != null)
					model.setLo45(lo45[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (lo20[i] != null)
					model.setLo20(lo20[i]);
				if (ts40h[i] != null)
					model.setTs40h(ts40h[i]);
				if (lo40h[i] != null)
					model.setLo40h(lo40h[i]);
				if (to40h[i] != null)
					model.setTo40h(to40h[i]);
				if (ts40[i] != null)
					model.setTs40(ts40[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCLLCDLManifestLoadSumByPodDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CLLCDLManifestLoadSumByPodDetailVO[]
	 */
	public CLLCDLManifestLoadSumByPodDetailVO[] getCLLCDLManifestLoadSumByPodDetailVOs(){
		CLLCDLManifestLoadSumByPodDetailVO[] vos = (CLLCDLManifestLoadSumByPodDetailVO[])models.toArray(new CLLCDLManifestLoadSumByPodDetailVO[models.size()]);
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
		this.mt45 = this.mt45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mt40h = this.mt40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts45 = this.ts45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gubunCd2 = this.gubunCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtMt = this.wgtMt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.to40 = this.to40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts20 = this.ts20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mt20 = this.mt20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mt40 = this.mt40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.to45 = this.to45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lo40 = this.lo40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.to20 = this.to20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lo45 = this.lo45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lo20 = this.lo20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts40h = this.ts40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lo40h = this.lo40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.to40h = this.to40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts40 = this.ts40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
