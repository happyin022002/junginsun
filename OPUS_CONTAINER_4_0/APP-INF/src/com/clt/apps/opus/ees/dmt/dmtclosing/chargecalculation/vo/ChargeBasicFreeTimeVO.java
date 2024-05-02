/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeBasicFreeTimeVO.java
*@FileTitle : ChargeBasicFreeTimeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.09.11 황효근 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

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

public class ChargeBasicFreeTimeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ChargeBasicFreeTimeVO> models = new ArrayList<ChargeBasicFreeTimeVO>();
	
	/* Column Info */
	private String xcldSatFlg = null;
	/* Column Info */
	private String xcldSunFlg = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String cntrFtRtAmt = null;
	/* Column Info */
	private String bzcTrfAplyDt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ftDys = null;
	/* Column Info */
	private String bzcChgCalc = null;
	/* Column Info */
	private String orgFtOvrDys = null;
	/* Column Info */
	private String cvrgCd = null;
	/* Column Info */
	private String ftOvrUndDys = null;
	/* Column Info */
	private String xcldHolFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ChargeBasicFreeTimeVO() {}

	public ChargeBasicFreeTimeVO(String ibflag, String pagerows, String xcldSatFlg, String xcldSunFlg, String xcldHolFlg, String bzcTrfAplyDt, String cvrgCd, String ftDys, String orgFtOvrDys, String currCd, String ftOvrUndDys, String cntrFtRtAmt, String bzcChgCalc) {
		this.xcldSatFlg = xcldSatFlg;
		this.xcldSunFlg = xcldSunFlg;
		this.currCd = currCd;
		this.cntrFtRtAmt = cntrFtRtAmt;
		this.bzcTrfAplyDt = bzcTrfAplyDt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.ftDys = ftDys;
		this.bzcChgCalc = bzcChgCalc;
		this.orgFtOvrDys = orgFtOvrDys;
		this.cvrgCd = cvrgCd;
		this.ftOvrUndDys = ftOvrUndDys;
		this.xcldHolFlg = xcldHolFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("xcld_sat_flg", getXcldSatFlg());
		this.hashColumns.put("xcld_sun_flg", getXcldSunFlg());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("cntr_ft_rt_amt", getCntrFtRtAmt());
		this.hashColumns.put("bzc_trf_aply_dt", getBzcTrfAplyDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ft_dys", getFtDys());
		this.hashColumns.put("bzc_chg_calc", getBzcChgCalc());
		this.hashColumns.put("org_ft_ovr_dys", getOrgFtOvrDys());
		this.hashColumns.put("cvrg_cd", getCvrgCd());
		this.hashColumns.put("ft_ovr_und_dys", getFtOvrUndDys());
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
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("cntr_ft_rt_amt", "cntrFtRtAmt");
		this.hashFields.put("bzc_trf_aply_dt", "bzcTrfAplyDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ft_dys", "ftDys");
		this.hashFields.put("bzc_chg_calc", "bzcChgCalc");
		this.hashFields.put("org_ft_ovr_dys", "orgFtOvrDys");
		this.hashFields.put("cvrg_cd", "cvrgCd");
		this.hashFields.put("ft_ovr_und_dys", "ftOvrUndDys");
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
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
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
	 * @return bzcTrfAplyDt
	 */
	public String getBzcTrfAplyDt() {
		return this.bzcTrfAplyDt;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return ftDys
	 */
	public String getFtDys() {
		return this.ftDys;
	}
	
	/**
	 * Column Info
	 * @return bzcChgCalc
	 */
	public String getBzcChgCalc() {
		return this.bzcChgCalc;
	}
	
	/**
	 * Column Info
	 * @return orgFtOvrDys
	 */
	public String getOrgFtOvrDys() {
		return this.orgFtOvrDys;
	}
	
	/**
	 * Column Info
	 * @return cvrgCd
	 */
	public String getCvrgCd() {
		return this.cvrgCd;
	}
	
	/**
	 * Column Info
	 * @return ftOvrUndDys
	 */
	public String getFtOvrUndDys() {
		return this.ftOvrUndDys;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
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
	 * @param bzcTrfAplyDt
	 */
	public void setBzcTrfAplyDt(String bzcTrfAplyDt) {
		this.bzcTrfAplyDt = bzcTrfAplyDt;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param ftDys
	 */
	public void setFtDys(String ftDys) {
		this.ftDys = ftDys;
	}
	
	/**
	 * Column Info
	 * @param bzcChgCalc
	 */
	public void setBzcChgCalc(String bzcChgCalc) {
		this.bzcChgCalc = bzcChgCalc;
	}
	
	/**
	 * Column Info
	 * @param orgFtOvrDys
	 */
	public void setOrgFtOvrDys(String orgFtOvrDys) {
		this.orgFtOvrDys = orgFtOvrDys;
	}
	
	/**
	 * Column Info
	 * @param cvrgCd
	 */
	public void setCvrgCd(String cvrgCd) {
		this.cvrgCd = cvrgCd;
	}
	
	/**
	 * Column Info
	 * @param ftOvrUndDys
	 */
	public void setFtOvrUndDys(String ftOvrUndDys) {
		this.ftOvrUndDys = ftOvrUndDys;
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
		setXcldSatFlg(JSPUtil.getParameter(request, "xcld_sat_flg", ""));
		setXcldSunFlg(JSPUtil.getParameter(request, "xcld_sun_flg", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setCntrFtRtAmt(JSPUtil.getParameter(request, "cntr_ft_rt_amt", ""));
		setBzcTrfAplyDt(JSPUtil.getParameter(request, "bzc_trf_aply_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFtDys(JSPUtil.getParameter(request, "ft_dys", ""));
		setBzcChgCalc(JSPUtil.getParameter(request, "bzc_chg_calc", ""));
		setOrgFtOvrDys(JSPUtil.getParameter(request, "org_ft_ovr_dys", ""));
		setCvrgCd(JSPUtil.getParameter(request, "cvrg_cd", ""));
		setFtOvrUndDys(JSPUtil.getParameter(request, "ft_ovr_und_dys", ""));
		setXcldHolFlg(JSPUtil.getParameter(request, "xcld_hol_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChargeBasicFreeTimeVO[]
	 */
	public ChargeBasicFreeTimeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ChargeBasicFreeTimeVO[]
	 */
	public ChargeBasicFreeTimeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChargeBasicFreeTimeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] xcldSatFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_sat_flg", length));
			String[] xcldSunFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_sun_flg", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] cntrFtRtAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_ft_rt_amt", length));
			String[] bzcTrfAplyDt = (JSPUtil.getParameter(request, prefix	+ "bzc_trf_aply_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ftDys = (JSPUtil.getParameter(request, prefix	+ "ft_dys", length));
			String[] bzcChgCalc = (JSPUtil.getParameter(request, prefix	+ "bzc_chg_calc", length));
			String[] orgFtOvrDys = (JSPUtil.getParameter(request, prefix	+ "org_ft_ovr_dys", length));
			String[] cvrgCd = (JSPUtil.getParameter(request, prefix	+ "cvrg_cd", length));
			String[] ftOvrUndDys = (JSPUtil.getParameter(request, prefix	+ "ft_ovr_und_dys", length));
			String[] xcldHolFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_hol_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new ChargeBasicFreeTimeVO();
				if (xcldSatFlg[i] != null)
					model.setXcldSatFlg(xcldSatFlg[i]);
				if (xcldSunFlg[i] != null)
					model.setXcldSunFlg(xcldSunFlg[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (cntrFtRtAmt[i] != null)
					model.setCntrFtRtAmt(cntrFtRtAmt[i]);
				if (bzcTrfAplyDt[i] != null)
					model.setBzcTrfAplyDt(bzcTrfAplyDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ftDys[i] != null)
					model.setFtDys(ftDys[i]);
				if (bzcChgCalc[i] != null)
					model.setBzcChgCalc(bzcChgCalc[i]);
				if (orgFtOvrDys[i] != null)
					model.setOrgFtOvrDys(orgFtOvrDys[i]);
				if (cvrgCd[i] != null)
					model.setCvrgCd(cvrgCd[i]);
				if (ftOvrUndDys[i] != null)
					model.setFtOvrUndDys(ftOvrUndDys[i]);
				if (xcldHolFlg[i] != null)
					model.setXcldHolFlg(xcldHolFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChargeBasicFreeTimeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChargeBasicFreeTimeVO[]
	 */
	public ChargeBasicFreeTimeVO[] getChargeBasicFreeTimeVOs(){
		ChargeBasicFreeTimeVO[] vos = (ChargeBasicFreeTimeVO[])models.toArray(new ChargeBasicFreeTimeVO[models.size()]);
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
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.xcldSatFlg = this.xcldSatFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xcldSunFlg = this.xcldSunFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrFtRtAmt = this.cntrFtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcTrfAplyDt = this.bzcTrfAplyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftDys = this.ftDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcChgCalc = this.bzcChgCalc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgFtOvrDys = this.orgFtOvrDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvrgCd = this.cvrgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftOvrUndDys = this.ftOvrUndDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xcldHolFlg = this.xcldHolFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
