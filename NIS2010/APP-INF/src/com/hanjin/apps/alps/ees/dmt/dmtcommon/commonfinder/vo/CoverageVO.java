/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CoverageVO.java
*@FileTitle : CoverageVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.21
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.21  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo;

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

public class CoverageVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CoverageVO> models = new ArrayList<CoverageVO>();
	
	public static final String CVRG_RHQ = "RHQ";
	
	public static final String CVRG_STATE = "STE";
	
	public static final String CVRG_REGION = "RGN";
	
	public static final String CVRG_COUNTRY = "CNT";
	
	public static final String CVRG_CONTINENT = "CONTI";
	
	/* Column Info */
	private String contiCd = null;
	/* Column Info */
	private String rgnCd = null;
	/* Column Info */
	private String ydCd1 = null;
	/* Column Info */
	private String ydCd2 = null;
	/* Column Info */
	private String tp = null;
	/* Column Info */
	private String rgnNm = null;
	/* Column Info */
	private String code = null;
	/* Column Info */
	private String locNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String svrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntNm = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String rtCurrCd = null;
	/* Column Info */
	private String steNm = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String contiNm = null;
	/* Column Info */
	private String name = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String useRtCurr = null;
	/* Column Info */
	private String ydNm = null;
	/* Column Info */
	private String steCd = null;
	/* Column Info */
	private String ioBnd = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String expDt = null;

	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CoverageVO() {}

	public CoverageVO(String ibflag, String pagerows, String contiCd, String contiNm, String svrId, String cntCd, String cntNm, String rgnCd, String rgnNm, String steCd, String steNm, String locCd, String locNm, String ydCd, String ydNm, String tp, String ydCd1, String ydCd2, String rtCurrCd, String useRtCurr, String code, String name, String ioBnd, String effDt, String expDt) {
		this.contiCd = contiCd;
		this.rgnCd = rgnCd;
		this.ydCd1 = ydCd1;
		this.ydCd2 = ydCd2;
		this.tp = tp;
		this.rgnNm = rgnNm;
		this.code = code;
		this.locNm = locNm;
		this.pagerows = pagerows;
		this.svrId = svrId;
		this.ibflag = ibflag;
		this.cntNm = cntNm;
		this.locCd = locCd;
		this.rtCurrCd = rtCurrCd;
		this.steNm = steNm;
		this.ydCd = ydCd;
		this.contiNm = contiNm;
		this.name = name;
		this.cntCd = cntCd;
		this.useRtCurr = useRtCurr;
		this.ydNm = ydNm;
		this.steCd = steCd;
		this.ioBnd = ioBnd;
		this.effDt = effDt;
		this.expDt = expDt;

	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("conti_cd", getContiCd());
		this.hashColumns.put("rgn_cd", getRgnCd());
		this.hashColumns.put("yd_cd1", getYdCd1());
		this.hashColumns.put("yd_cd2", getYdCd2());
		this.hashColumns.put("tp", getTp());
		this.hashColumns.put("rgn_nm", getRgnNm());
		this.hashColumns.put("loc_nm", getLocNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnt_nm", getCntNm());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("rt_curr_cd", getRtCurrCd());
		this.hashColumns.put("ste_nm", getSteNm());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("conti_nm", getContiNm());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("use_rt_curr", getUseRtCurr());
		this.hashColumns.put("yd_nm", getYdNm());
		this.hashColumns.put("ste_cd", getSteCd());
		this.hashColumns.put("io_bnd", getIoBnd());		
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("exp_dt", getExpDt());
	
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("conti_cd", "contiCd");
		this.hashFields.put("rgn_cd", "rgnCd");
		this.hashFields.put("yd_cd1", "ydCd1");
		this.hashFields.put("yd_cd2", "ydCd2");
		this.hashFields.put("tp", "tp");
		this.hashFields.put("rgn_nm", "rgnNm");
		this.hashFields.put("code", "code");
		this.hashFields.put("loc_nm", "locNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnt_nm", "cntNm");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("rt_curr_cd", "rtCurrCd");
		this.hashFields.put("ste_nm", "steNm");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("conti_nm", "contiNm");
		this.hashFields.put("name", "name");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("use_rt_curr", "useRtCurr");
		this.hashFields.put("yd_nm", "ydNm");
		this.hashFields.put("ste_cd", "steCd");
		this.hashFields.put("io_bnd", "ioBnd");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("exp_dt", "expDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return contiCd
	 */
	public String getContiCd() {
		return this.contiCd;
	}
	
	/**
	 * Column Info
	 * @return rgnCd
	 */
	public String getRgnCd() {
		return this.rgnCd;
	}
	
	/**
	 * Column Info
	 * @return ydCd1
	 */
	public String getYdCd1() {
		return this.ydCd1;
	}
	
	/**
	 * Column Info
	 * @return ydCd2
	 */
	public String getYdCd2() {
		return this.ydCd2;
	}
	
	/**
	 * Column Info
	 * @return tp
	 */
	public String getTp() {
		return this.tp;
	}
	
	/**
	 * Column Info
	 * @return rgnNm
	 */
	public String getRgnNm() {
		return this.rgnNm;
	}
	
	/**
	 * Column Info
	 * @return code
	 */
	public String getCode(String key) {
		
		if (CVRG_CONTINENT.equalsIgnoreCase(key)) {
			return getContiCd();
		}
		else if (CVRG_COUNTRY.equalsIgnoreCase(key)) {
			return getCntCd();
		}
		else if (CVRG_REGION.equalsIgnoreCase(key)) {
			return getRgnCd();
		}
		else if (CVRG_STATE.equalsIgnoreCase(key)) {
			return getSteCd();
		}
		else
			return "";
	}
	
	/**
	 * Column Info
	 * @return locNm
	 */
	public String getLocNm() {
		return this.locNm;
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
	 * @return svrId
	 */
	public String getSvrId() {
		return this.svrId;
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
	 * @return cntNm
	 */
	public String getCntNm() {
		return this.cntNm;
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
	 * @return rtCurrCd
	 */
	public String getRtCurrCd() {
		return this.rtCurrCd;
	}
	
	/**
	 * Column Info
	 * @return steNm
	 */
	public String getSteNm() {
		return this.steNm;
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
	 * @return contiNm
	 */
	public String getContiNm() {
		return this.contiNm;
	}
	
	/**
	 * Column Info
	 * @return name
	 */
	public String getName(String key) {
		
		if (CVRG_CONTINENT.equalsIgnoreCase(key)) {
			return getContiNm();
		}
		else if (CVRG_COUNTRY.equalsIgnoreCase(key)) {
			return getCntNm();
		}
		else if (CVRG_REGION.equalsIgnoreCase(key)) {
			return getRgnNm();
		}
		else if (CVRG_STATE.equalsIgnoreCase(key)) {
			return getSteNm();
		}
		else
			return "";
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return useRtCurr
	 */
	public String getUseRtCurr() {
		return this.useRtCurr;
	}
	
	/**
	 * Column Info
	 * @return ydNm
	 */
	public String getYdNm() {
		return this.ydNm;
	}
	
	/**
	 * Column Info
	 * @return steCd
	 */
	public String getSteCd() {
		return this.steCd;
	}
	/**
	 * Column Info
	 * @return ioBnd
	 */
	public String getIoBnd() {
		return ioBnd;
	}

	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return effDt;
	}

	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return expDt;
	}

	/**
	 * Column Info
	 * @param contiCd
	 */
	public void setContiCd(String contiCd) {
		this.contiCd = contiCd;
	}
	
	/**
	 * Column Info
	 * @param rgnCd
	 */
	public void setRgnCd(String rgnCd) {
		this.rgnCd = rgnCd;
	}
	
	/**
	 * Column Info
	 * @param ydCd1
	 */
	public void setYdCd1(String ydCd1) {
		this.ydCd1 = ydCd1;
	}
	
	/**
	 * Column Info
	 * @param ydCd2
	 */
	public void setYdCd2(String ydCd2) {
		this.ydCd2 = ydCd2;
	}
	
	/**
	 * Column Info
	 * @param tp
	 */
	public void setTp(String tp) {
		this.tp = tp;
	}
	
	/**
	 * Column Info
	 * @param rgnNm
	 */
	public void setRgnNm(String rgnNm) {
		this.rgnNm = rgnNm;
	}
	
	/**
	 * Column Info
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * Column Info
	 * @param locNm
	 */
	public void setLocNm(String locNm) {
		this.locNm = locNm;
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
	 * @param svrId
	 */
	public void setSvrId(String svrId) {
		this.svrId = svrId;
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
	 * @param cntNm
	 */
	public void setCntNm(String cntNm) {
		this.cntNm = cntNm;
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
	 * @param rtCurrCd
	 */
	public void setRtCurrCd(String rtCurrCd) {
		this.rtCurrCd = rtCurrCd;
	}
	
	/**
	 * Column Info
	 * @param steNm
	 */
	public void setSteNm(String steNm) {
		this.steNm = steNm;
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
	 * @param contiNm
	 */
	public void setContiNm(String contiNm) {
		this.contiNm = contiNm;
	}
	
	/**
	 * Column Info
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param useRtCurr
	 */
	public void setUseRtCurr(String useRtCurr) {
		this.useRtCurr = useRtCurr;
	}
	
	/**
	 * Column Info
	 * @param ydNm
	 */
	public void setYdNm(String ydNm) {
		this.ydNm = ydNm;
	}
	
	/**
	 * Column Info
	 * @param steCd
	 */
	public void setSteCd(String steCd) {
		this.steCd = steCd;
	}
	
	/**
	 * Column Info
	 * @return ioBnd
	 */
	public void setIoBnd(String ioBnd) {
		this.ioBnd = ioBnd;
	}
	/**
	 * Column Info
	 * @return effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	/**
	 * Column Info
	 * @return expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
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
		setContiCd(JSPUtil.getParameter(request, prefix + "conti_cd", ""));
		setRgnCd(JSPUtil.getParameter(request, prefix + "rgn_cd", ""));
		setYdCd1(JSPUtil.getParameter(request, prefix + "yd_cd1", ""));
		setYdCd2(JSPUtil.getParameter(request, prefix + "yd_cd2", ""));
		setTp(JSPUtil.getParameter(request, prefix + "tp", ""));
		setRgnNm(JSPUtil.getParameter(request, prefix + "rgn_nm", ""));
		setCode(JSPUtil.getParameter(request, prefix + "code", ""));
		setLocNm(JSPUtil.getParameter(request, prefix + "loc_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSvrId(JSPUtil.getParameter(request, prefix + "svr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntNm(JSPUtil.getParameter(request, prefix + "cnt_nm", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setRtCurrCd(JSPUtil.getParameter(request, prefix + "rt_curr_cd", ""));
		setSteNm(JSPUtil.getParameter(request, prefix + "ste_nm", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setContiNm(JSPUtil.getParameter(request, prefix + "conti_nm", ""));
		setName(JSPUtil.getParameter(request, prefix + "name", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setUseRtCurr(JSPUtil.getParameter(request, prefix + "use_rt_curr", ""));
		setYdNm(JSPUtil.getParameter(request, prefix + "yd_nm", ""));
		setSteCd(JSPUtil.getParameter(request, prefix + "ste_cd", ""));
		setIoBnd(JSPUtil.getParameter(request, prefix + "io_bnd", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CoverageVO[]
	 */
	public CoverageVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CoverageVO[]
	 */
	public CoverageVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CoverageVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] contiCd = (JSPUtil.getParameter(request, prefix	+ "conti_cd", length));
			String[] rgnCd = (JSPUtil.getParameter(request, prefix	+ "rgn_cd", length));
			String[] ydCd1 = (JSPUtil.getParameter(request, prefix	+ "yd_cd1", length));
			String[] ydCd2 = (JSPUtil.getParameter(request, prefix	+ "yd_cd2", length));
			String[] tp = (JSPUtil.getParameter(request, prefix	+ "tp", length));
			String[] rgnNm = (JSPUtil.getParameter(request, prefix	+ "rgn_nm", length));
			String[] code = (JSPUtil.getParameter(request, prefix	+ "code", length));
			String[] locNm = (JSPUtil.getParameter(request, prefix	+ "loc_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntNm = (JSPUtil.getParameter(request, prefix	+ "cnt_nm", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] rtCurrCd = (JSPUtil.getParameter(request, prefix	+ "rt_curr_cd", length));
			String[] steNm = (JSPUtil.getParameter(request, prefix	+ "ste_nm", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] contiNm = (JSPUtil.getParameter(request, prefix	+ "conti_nm", length));
			String[] name = (JSPUtil.getParameter(request, prefix	+ "name", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] useRtCurr = (JSPUtil.getParameter(request, prefix	+ "use_rt_curr", length));
			String[] ydNm = (JSPUtil.getParameter(request, prefix	+ "yd_nm", length));
			String[] steCd = (JSPUtil.getParameter(request, prefix	+ "ste_cd", length));
			String[] ioBnd = (JSPUtil.getParameter(request, prefix	+ "io_bnd", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new CoverageVO();
				if (contiCd[i] != null)
					model.setContiCd(contiCd[i]);
				if (rgnCd[i] != null)
					model.setRgnCd(rgnCd[i]);
				if (ydCd1[i] != null)
					model.setYdCd1(ydCd1[i]);
				if (ydCd2[i] != null)
					model.setYdCd2(ydCd2[i]);
				if (tp[i] != null)
					model.setTp(tp[i]);
				if (rgnNm[i] != null)
					model.setRgnNm(rgnNm[i]);
				if (code[i] != null)
					model.setCode(code[i]);
				if (locNm[i] != null)
					model.setLocNm(locNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (svrId[i] != null)
					model.setSvrId(svrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntNm[i] != null)
					model.setCntNm(cntNm[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (rtCurrCd[i] != null)
					model.setRtCurrCd(rtCurrCd[i]);
				if (steNm[i] != null)
					model.setSteNm(steNm[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (contiNm[i] != null)
					model.setContiNm(contiNm[i]);
				if (name[i] != null)
					model.setName(name[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (useRtCurr[i] != null)
					model.setUseRtCurr(useRtCurr[i]);
				if (ydNm[i] != null)
					model.setYdNm(ydNm[i]);
				if (steCd[i] != null)
					model.setSteCd(steCd[i]);
				if (ioBnd[i] != null)
					model.setIoBnd(ioBnd[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCoverageVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CoverageVO[]
	 */
	public CoverageVO[] getCoverageVOs(){
		CoverageVO[] vos = (CoverageVO[])models.toArray(new CoverageVO[models.size()]);
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
		this.contiCd = this.contiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnCd = this.rgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd1 = this.ydCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd2 = this.ydCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tp = this.tp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnNm = this.rgnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.code = this.code .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locNm = this.locNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntNm = this.cntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtCurrCd = this.rtCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steNm = this.steNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contiNm = this.contiNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.name = this.name .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.useRtCurr = this.useRtCurr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydNm = this.ydNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steCd = this.steCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBnd = this.ioBnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
