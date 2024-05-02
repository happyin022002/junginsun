/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCExceptionTariffVO.java
*@FileTitle : SCExceptionTariffVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.08
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2010.04.08 황효근 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo;

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
 * @author 황효근
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SCExceptionTariffVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SCExceptionTariffVO> models = new ArrayList<SCExceptionTariffVO>();
	
	/* Column Info */
	private String xcldSatFlg = null;
	/* Column Info */
	private String xcldSunFlg = null;
	/* Column Info */
	private String bzcTrfCurrCd = null;
	/* Column Info */
	private String scRfaExptAplyDt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String scRfaExptAmt = null;
	/* Column Info */
	private String cntrFtRtAmt = null;
	/* Column Info */
	private String rqstUsrNm = null;
	/* Column Info */
	private String scRfaExptOvrDys = null;
	/* Column Info */
	private String aproUsrNm = null;
	/* Column Info */
	private String aproOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ttlDys = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String scApvlNo = null;
	/* Column Info */
	private String addDys = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String rqstOfcCd = null;
	/* Column Info */
	private String xcldHolFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SCExceptionTariffVO() {}

	public SCExceptionTariffVO(String ibflag, String pagerows, String rqstOfcCd, String rqstUsrNm, String aproOfcCd, String aproUsrNm, String scApvlNo, String addDys, String ttlDys, String xcldSatFlg, String xcldSunFlg, String xcldHolFlg, String currCd, String cntrFtRtAmt, String propNo, String scRfaExptAplyDt, String scRfaExptOvrDys, String scRfaExptAmt, String bzcTrfCurrCd) {
		this.xcldSatFlg = xcldSatFlg;
		this.xcldSunFlg = xcldSunFlg;
		this.bzcTrfCurrCd = bzcTrfCurrCd;
		this.scRfaExptAplyDt = scRfaExptAplyDt;
		this.currCd = currCd;
		this.scRfaExptAmt = scRfaExptAmt;
		this.cntrFtRtAmt = cntrFtRtAmt;
		this.rqstUsrNm = rqstUsrNm;
		this.scRfaExptOvrDys = scRfaExptOvrDys;
		this.aproUsrNm = aproUsrNm;
		this.aproOfcCd = aproOfcCd;
		this.pagerows = pagerows;
		this.ttlDys = ttlDys;
		this.ibflag = ibflag;
		this.scApvlNo = scApvlNo;
		this.addDys = addDys;
		this.propNo = propNo;
		this.rqstOfcCd = rqstOfcCd;
		this.xcldHolFlg = xcldHolFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("xcld_sat_flg", getXcldSatFlg());
		this.hashColumns.put("xcld_sun_flg", getXcldSunFlg());
		this.hashColumns.put("bzc_trf_curr_cd", getBzcTrfCurrCd());
		this.hashColumns.put("sc_rfa_expt_aply_dt", getScRfaExptAplyDt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("sc_rfa_expt_amt", getScRfaExptAmt());
		this.hashColumns.put("cntr_ft_rt_amt", getCntrFtRtAmt());
		this.hashColumns.put("rqst_usr_nm", getRqstUsrNm());
		this.hashColumns.put("sc_rfa_expt_ovr_dys", getScRfaExptOvrDys());
		this.hashColumns.put("apro_usr_nm", getAproUsrNm());
		this.hashColumns.put("apro_ofc_cd", getAproOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ttl_dys", getTtlDys());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sc_apvl_no", getScApvlNo());
		this.hashColumns.put("add_dys", getAddDys());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
		this.hashColumns.put("xcld_hol_flg", getXcldHolFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("xcld_sat_flg", "xcldSatFlg");
		this.hashFields.put("xcld_sun_flg", "xcldSunFlg");
		this.hashFields.put("bzc_trf_curr_cd", "bzcTrfCurrCd");
		this.hashFields.put("sc_rfa_expt_aply_dt", "scRfaExptAplyDt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("sc_rfa_expt_amt", "scRfaExptAmt");
		this.hashFields.put("cntr_ft_rt_amt", "cntrFtRtAmt");
		this.hashFields.put("rqst_usr_nm", "rqstUsrNm");
		this.hashFields.put("sc_rfa_expt_ovr_dys", "scRfaExptOvrDys");
		this.hashFields.put("apro_usr_nm", "aproUsrNm");
		this.hashFields.put("apro_ofc_cd", "aproOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ttl_dys", "ttlDys");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sc_apvl_no", "scApvlNo");
		this.hashFields.put("add_dys", "addDys");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
		this.hashFields.put("xcld_hol_flg", "xcldHolFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return xcldSatFlg
	 */
	public String getXcldSatFlg() {
		return this.xcldSatFlg;
	}
	
	/**
	 * Column Info
	 * @return xcldSunFlg
	 */
	public String getXcldSunFlg() {
		return this.xcldSunFlg;
	}
	
	/**
	 * Column Info
	 * @return bzcTrfCurrCd
	 */
	public String getBzcTrfCurrCd() {
		return this.bzcTrfCurrCd;
	}
	
	/**
	 * Column Info
	 * @return scRfaExptAplyDt
	 */
	public String getScRfaExptAplyDt() {
		return this.scRfaExptAplyDt;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return scRfaExptAmt
	 */
	public String getScRfaExptAmt() {
		return this.scRfaExptAmt;
	}
	
	/**
	 * Column Info
	 * @return cntrFtRtAmt
	 */
	public String getCntrFtRtAmt() {
		return this.cntrFtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return rqstUsrNm
	 */
	public String getRqstUsrNm() {
		return this.rqstUsrNm;
	}
	
	/**
	 * Column Info
	 * @return scRfaExptOvrDys
	 */
	public String getScRfaExptOvrDys() {
		return this.scRfaExptOvrDys;
	}
	
	/**
	 * Column Info
	 * @return aproUsrNm
	 */
	public String getAproUsrNm() {
		return this.aproUsrNm;
	}
	
	/**
	 * Column Info
	 * @return aproOfcCd
	 */
	public String getAproOfcCd() {
		return this.aproOfcCd;
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
	 * @return ttlDys
	 */
	public String getTtlDys() {
		return this.ttlDys;
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
	 * @return scApvlNo
	 */
	public String getScApvlNo() {
		return this.scApvlNo;
	}
	
	/**
	 * Column Info
	 * @return addDys
	 */
	public String getAddDys() {
		return this.addDys;
	}
	
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return rqstOfcCd
	 */
	public String getRqstOfcCd() {
		return this.rqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @return xcldHolFlg
	 */
	public String getXcldHolFlg() {
		return this.xcldHolFlg;
	}
	

	/**
	 * Column Info
	 * @param xcldSatFlg
	 */
	public void setXcldSatFlg(String xcldSatFlg) {
		this.xcldSatFlg = xcldSatFlg;
	}
	
	/**
	 * Column Info
	 * @param xcldSunFlg
	 */
	public void setXcldSunFlg(String xcldSunFlg) {
		this.xcldSunFlg = xcldSunFlg;
	}
	
	/**
	 * Column Info
	 * @param bzcTrfCurrCd
	 */
	public void setBzcTrfCurrCd(String bzcTrfCurrCd) {
		this.bzcTrfCurrCd = bzcTrfCurrCd;
	}
	
	/**
	 * Column Info
	 * @param scRfaExptAplyDt
	 */
	public void setScRfaExptAplyDt(String scRfaExptAplyDt) {
		this.scRfaExptAplyDt = scRfaExptAplyDt;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param scRfaExptAmt
	 */
	public void setScRfaExptAmt(String scRfaExptAmt) {
		this.scRfaExptAmt = scRfaExptAmt;
	}
	
	/**
	 * Column Info
	 * @param cntrFtRtAmt
	 */
	public void setCntrFtRtAmt(String cntrFtRtAmt) {
		this.cntrFtRtAmt = cntrFtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param rqstUsrNm
	 */
	public void setRqstUsrNm(String rqstUsrNm) {
		this.rqstUsrNm = rqstUsrNm;
	}
	
	/**
	 * Column Info
	 * @param scRfaExptOvrDys
	 */
	public void setScRfaExptOvrDys(String scRfaExptOvrDys) {
		this.scRfaExptOvrDys = scRfaExptOvrDys;
	}
	
	/**
	 * Column Info
	 * @param aproUsrNm
	 */
	public void setAproUsrNm(String aproUsrNm) {
		this.aproUsrNm = aproUsrNm;
	}
	
	/**
	 * Column Info
	 * @param aproOfcCd
	 */
	public void setAproOfcCd(String aproOfcCd) {
		this.aproOfcCd = aproOfcCd;
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
	 * @param ttlDys
	 */
	public void setTtlDys(String ttlDys) {
		this.ttlDys = ttlDys;
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
	 * @param scApvlNo
	 */
	public void setScApvlNo(String scApvlNo) {
		this.scApvlNo = scApvlNo;
	}
	
	/**
	 * Column Info
	 * @param addDys
	 */
	public void setAddDys(String addDys) {
		this.addDys = addDys;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param rqstOfcCd
	 */
	public void setRqstOfcCd(String rqstOfcCd) {
		this.rqstOfcCd = rqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @param xcldHolFlg
	 */
	public void setXcldHolFlg(String xcldHolFlg) {
		this.xcldHolFlg = xcldHolFlg;
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
		setXcldSatFlg(JSPUtil.getParameter(request, prefix + "xcld_sat_flg", ""));
		setXcldSunFlg(JSPUtil.getParameter(request, prefix + "xcld_sun_flg", ""));
		setBzcTrfCurrCd(JSPUtil.getParameter(request, prefix + "bzc_trf_curr_cd", ""));
		setScRfaExptAplyDt(JSPUtil.getParameter(request, prefix + "sc_rfa_expt_aply_dt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setScRfaExptAmt(JSPUtil.getParameter(request, prefix + "sc_rfa_expt_amt", ""));
		setCntrFtRtAmt(JSPUtil.getParameter(request, prefix + "cntr_ft_rt_amt", ""));
		setRqstUsrNm(JSPUtil.getParameter(request, prefix + "rqst_usr_nm", ""));
		setScRfaExptOvrDys(JSPUtil.getParameter(request, prefix + "sc_rfa_expt_ovr_dys", ""));
		setAproUsrNm(JSPUtil.getParameter(request, prefix + "apro_usr_nm", ""));
		setAproOfcCd(JSPUtil.getParameter(request, prefix + "apro_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTtlDys(JSPUtil.getParameter(request, prefix + "ttl_dys", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setScApvlNo(JSPUtil.getParameter(request, prefix + "sc_apvl_no", ""));
		setAddDys(JSPUtil.getParameter(request, prefix + "add_dys", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
		setRqstOfcCd(JSPUtil.getParameter(request, prefix + "rqst_ofc_cd", ""));
		setXcldHolFlg(JSPUtil.getParameter(request, prefix + "xcld_hol_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SCExceptionTariffVO[]
	 */
	public SCExceptionTariffVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SCExceptionTariffVO[]
	 */
	public SCExceptionTariffVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SCExceptionTariffVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] xcldSatFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_sat_flg", length));
			String[] xcldSunFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_sun_flg", length));
			String[] bzcTrfCurrCd = (JSPUtil.getParameter(request, prefix	+ "bzc_trf_curr_cd", length));
			String[] scRfaExptAplyDt = (JSPUtil.getParameter(request, prefix	+ "sc_rfa_expt_aply_dt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] scRfaExptAmt = (JSPUtil.getParameter(request, prefix	+ "sc_rfa_expt_amt", length));
			String[] cntrFtRtAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_ft_rt_amt", length));
			String[] rqstUsrNm = (JSPUtil.getParameter(request, prefix	+ "rqst_usr_nm", length));
			String[] scRfaExptOvrDys = (JSPUtil.getParameter(request, prefix	+ "sc_rfa_expt_ovr_dys", length));
			String[] aproUsrNm = (JSPUtil.getParameter(request, prefix	+ "apro_usr_nm", length));
			String[] aproOfcCd = (JSPUtil.getParameter(request, prefix	+ "apro_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ttlDys = (JSPUtil.getParameter(request, prefix	+ "ttl_dys", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] scApvlNo = (JSPUtil.getParameter(request, prefix	+ "sc_apvl_no", length));
			String[] addDys = (JSPUtil.getParameter(request, prefix	+ "add_dys", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_cd", length));
			String[] xcldHolFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_hol_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new SCExceptionTariffVO();
				if (xcldSatFlg[i] != null)
					model.setXcldSatFlg(xcldSatFlg[i]);
				if (xcldSunFlg[i] != null)
					model.setXcldSunFlg(xcldSunFlg[i]);
				if (bzcTrfCurrCd[i] != null)
					model.setBzcTrfCurrCd(bzcTrfCurrCd[i]);
				if (scRfaExptAplyDt[i] != null)
					model.setScRfaExptAplyDt(scRfaExptAplyDt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (scRfaExptAmt[i] != null)
					model.setScRfaExptAmt(scRfaExptAmt[i]);
				if (cntrFtRtAmt[i] != null)
					model.setCntrFtRtAmt(cntrFtRtAmt[i]);
				if (rqstUsrNm[i] != null)
					model.setRqstUsrNm(rqstUsrNm[i]);
				if (scRfaExptOvrDys[i] != null)
					model.setScRfaExptOvrDys(scRfaExptOvrDys[i]);
				if (aproUsrNm[i] != null)
					model.setAproUsrNm(aproUsrNm[i]);
				if (aproOfcCd[i] != null)
					model.setAproOfcCd(aproOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ttlDys[i] != null)
					model.setTtlDys(ttlDys[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (scApvlNo[i] != null)
					model.setScApvlNo(scApvlNo[i]);
				if (addDys[i] != null)
					model.setAddDys(addDys[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (rqstOfcCd[i] != null)
					model.setRqstOfcCd(rqstOfcCd[i]);
				if (xcldHolFlg[i] != null)
					model.setXcldHolFlg(xcldHolFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSCExceptionTariffVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SCExceptionTariffVO[]
	 */
	public SCExceptionTariffVO[] getSCExceptionTariffVOs(){
		SCExceptionTariffVO[] vos = (SCExceptionTariffVO[])models.toArray(new SCExceptionTariffVO[models.size()]);
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
		this.xcldSatFlg = this.xcldSatFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xcldSunFlg = this.xcldSunFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcTrfCurrCd = this.bzcTrfCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaExptAplyDt = this.scRfaExptAplyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaExptAmt = this.scRfaExptAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrFtRtAmt = this.cntrFtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUsrNm = this.rqstUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaExptOvrDys = this.scRfaExptOvrDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproUsrNm = this.aproUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproOfcCd = this.aproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlDys = this.ttlDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scApvlNo = this.scApvlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addDys = this.addDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcCd = this.rqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xcldHolFlg = this.xcldHolFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
