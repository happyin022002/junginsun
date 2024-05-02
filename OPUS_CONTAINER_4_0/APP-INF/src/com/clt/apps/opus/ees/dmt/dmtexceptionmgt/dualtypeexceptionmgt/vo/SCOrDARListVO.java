/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCOrDARListVO.java
*@FileTitle : SCOrDARListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.27
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.27  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SCOrDARListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SCOrDARListVO> models = new ArrayList<SCOrDARListVO>();
	
	/* Column Info */
	private String locTp = null;
	/* Column Info */
	private String dmdtCntrCgoTpCd = null;
	/* Column Info */
	private String rgnCd = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String darNo = null;
	/* Column Info */
	private String apvlNo = null;
	/* Column Info */
	private String ver = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String dmdtCntrCgoTpAllCd = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String dmdtCntrCgoTpAllNm = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String steCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SCOrDARListVO() {}

	public SCOrDARListVO(String ibflag, String pagerows, String scNo, String rfaNo, String propNo, String darNo, String ver, String apvlNo, String status, String effDt, String expDt, String ioBndCd, String cntCd, String rgnCd, String steCd, String locCd, String dmdtCntrCgoTpCd, String dmdtCntrCgoTpAllCd, String dmdtCntrCgoTpAllNm, String locTp) {
		this.locTp = locTp;
		this.dmdtCntrCgoTpCd = dmdtCntrCgoTpCd;
		this.rgnCd = rgnCd;
		this.status = status;
		this.darNo = darNo;
		this.apvlNo = apvlNo;
		this.ver = ver;
		this.ioBndCd = ioBndCd;
		this.pagerows = pagerows;
		this.rfaNo = rfaNo;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.dmdtCntrCgoTpAllCd = dmdtCntrCgoTpAllCd;
		this.propNo = propNo;
		this.scNo = scNo;
		this.cntCd = cntCd;
		this.dmdtCntrCgoTpAllNm = dmdtCntrCgoTpAllNm;
		this.expDt = expDt;
		this.steCd = steCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("loc_tp", getLocTp());
		this.hashColumns.put("dmdt_cntr_cgo_tp_cd", getDmdtCntrCgoTpCd());
		this.hashColumns.put("rgn_cd", getRgnCd());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("dar_no", getDarNo());
		this.hashColumns.put("apvl_no", getApvlNo());
		this.hashColumns.put("ver", getVer());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("dmdt_cntr_cgo_tp_all_cd", getDmdtCntrCgoTpAllCd());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("dmdt_cntr_cgo_tp_all_nm", getDmdtCntrCgoTpAllNm());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("ste_cd", getSteCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("loc_tp", "locTp");
		this.hashFields.put("dmdt_cntr_cgo_tp_cd", "dmdtCntrCgoTpCd");
		this.hashFields.put("rgn_cd", "rgnCd");
		this.hashFields.put("status", "status");
		this.hashFields.put("dar_no", "darNo");
		this.hashFields.put("apvl_no", "apvlNo");
		this.hashFields.put("ver", "ver");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("dmdt_cntr_cgo_tp_all_cd", "dmdtCntrCgoTpAllCd");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("dmdt_cntr_cgo_tp_all_nm", "dmdtCntrCgoTpAllNm");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("ste_cd", "steCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return locTp
	 */
	public String getLocTp() {
		return this.locTp;
	}
	
	/**
	 * Column Info
	 * @return dmdtCntrCgoTpCd
	 */
	public String getDmdtCntrCgoTpCd() {
		return this.dmdtCntrCgoTpCd;
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
	 * @return status
	 */
	public String getStatus() {
		return this.status;
	}
	
	/**
	 * Column Info
	 * @return darNo
	 */
	public String getDarNo() {
		return this.darNo;
	}
	
	/**
	 * Column Info
	 * @return apvlNo
	 */
	public String getApvlNo() {
		return this.apvlNo;
	}
	
	/**
	 * Column Info
	 * @return ver
	 */
	public String getVer() {
		return this.ver;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
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
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return dmdtCntrCgoTpAllCd
	 */
	public String getDmdtCntrCgoTpAllCd() {
		return this.dmdtCntrCgoTpAllCd;
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
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
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
	 * @return dmdtCntrCgoTpAllNm
	 */
	public String getDmdtCntrCgoTpAllNm() {
		return this.dmdtCntrCgoTpAllNm;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
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
	 * @param locTp
	 */
	public void setLocTp(String locTp) {
		this.locTp = locTp;
	}
	
	/**
	 * Column Info
	 * @param dmdtCntrCgoTpCd
	 */
	public void setDmdtCntrCgoTpCd(String dmdtCntrCgoTpCd) {
		this.dmdtCntrCgoTpCd = dmdtCntrCgoTpCd;
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
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Column Info
	 * @param darNo
	 */
	public void setDarNo(String darNo) {
		this.darNo = darNo;
	}
	
	/**
	 * Column Info
	 * @param apvlNo
	 */
	public void setApvlNo(String apvlNo) {
		this.apvlNo = apvlNo;
	}
	
	/**
	 * Column Info
	 * @param ver
	 */
	public void setVer(String ver) {
		this.ver = ver;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
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
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param dmdtCntrCgoTpAllCd
	 */
	public void setDmdtCntrCgoTpAllCd(String dmdtCntrCgoTpAllCd) {
		this.dmdtCntrCgoTpAllCd = dmdtCntrCgoTpAllCd;
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
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
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
	 * @param dmdtCntrCgoTpAllNm
	 */
	public void setDmdtCntrCgoTpAllNm(String dmdtCntrCgoTpAllNm) {
		this.dmdtCntrCgoTpAllNm = dmdtCntrCgoTpAllNm;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param steCd
	 */
	public void setSteCd(String steCd) {
		this.steCd = steCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setLocTp(JSPUtil.getParameter(request, "loc_tp", ""));
		setDmdtCntrCgoTpCd(JSPUtil.getParameter(request, "dmdt_cntr_cgo_tp_cd", ""));
		setRgnCd(JSPUtil.getParameter(request, "rgn_cd", ""));
		setStatus(JSPUtil.getParameter(request, "status", ""));
		setDarNo(JSPUtil.getParameter(request, "dar_no", ""));
		setApvlNo(JSPUtil.getParameter(request, "apvl_no", ""));
		setVer(JSPUtil.getParameter(request, "ver", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setRfaNo(JSPUtil.getParameter(request, "rfa_no", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setDmdtCntrCgoTpAllCd(JSPUtil.getParameter(request, "dmdt_cntr_cgo_tp_all_cd", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setDmdtCntrCgoTpAllNm(JSPUtil.getParameter(request, "dmdt_cntr_cgo_tp_all_nm", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setSteCd(JSPUtil.getParameter(request, "ste_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SCOrDARListVO[]
	 */
	public SCOrDARListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SCOrDARListVO[]
	 */
	public SCOrDARListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SCOrDARListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] locTp = (JSPUtil.getParameter(request, prefix	+ "loc_tp", length));
			String[] dmdtCntrCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_cntr_cgo_tp_cd", length));
			String[] rgnCd = (JSPUtil.getParameter(request, prefix	+ "rgn_cd", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] darNo = (JSPUtil.getParameter(request, prefix	+ "dar_no", length));
			String[] apvlNo = (JSPUtil.getParameter(request, prefix	+ "apvl_no", length));
			String[] ver = (JSPUtil.getParameter(request, prefix	+ "ver", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] dmdtCntrCgoTpAllCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_cntr_cgo_tp_all_cd", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] dmdtCntrCgoTpAllNm = (JSPUtil.getParameter(request, prefix	+ "dmdt_cntr_cgo_tp_all_nm", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] steCd = (JSPUtil.getParameter(request, prefix	+ "ste_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SCOrDARListVO();
				if (locTp[i] != null)
					model.setLocTp(locTp[i]);
				if (dmdtCntrCgoTpCd[i] != null)
					model.setDmdtCntrCgoTpCd(dmdtCntrCgoTpCd[i]);
				if (rgnCd[i] != null)
					model.setRgnCd(rgnCd[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (darNo[i] != null)
					model.setDarNo(darNo[i]);
				if (apvlNo[i] != null)
					model.setApvlNo(apvlNo[i]);
				if (ver[i] != null)
					model.setVer(ver[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (dmdtCntrCgoTpAllCd[i] != null)
					model.setDmdtCntrCgoTpAllCd(dmdtCntrCgoTpAllCd[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (dmdtCntrCgoTpAllNm[i] != null)
					model.setDmdtCntrCgoTpAllNm(dmdtCntrCgoTpAllNm[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (steCd[i] != null)
					model.setSteCd(steCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSCOrDARListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SCOrDARListVO[]
	 */
	public SCOrDARListVO[] getSCOrDARListVOs(){
		SCOrDARListVO[] vos = (SCOrDARListVO[])models.toArray(new SCOrDARListVO[models.size()]);
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
		this.locTp = this.locTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCntrCgoTpCd = this.dmdtCntrCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnCd = this.rgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.darNo = this.darNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apvlNo = this.apvlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ver = this.ver .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCntrCgoTpAllCd = this.dmdtCntrCgoTpAllCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCntrCgoTpAllNm = this.dmdtCntrCgoTpAllNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steCd = this.steCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
