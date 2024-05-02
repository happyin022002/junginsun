/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CgmEqAtchDtchHisMGTVO.java
*@FileTitle : CgmEqAtchDtchHisMGTVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.16
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.09.16 최민회 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최민회
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CHSAtchDtchHisMGTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CHSAtchDtchHisMGTVO> models = new ArrayList<CHSAtchDtchHisMGTVO>();
	
	/* Column Info */
	private String lagDtYd = null;
	/* Column Info */
	private String dtchDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String lagDt = null;
	/* Column Info */
	private String dtchYdCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String atchYdCd = null;
	/* Column Info */
	private String leadDt = null;
	/* Column Info */
	private String atchDt = null;
	/* Column Info */
	private String leadDtYd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CHSAtchDtchHisMGTVO() {}

	public CHSAtchDtchHisMGTVO(String ibflag, String pagerows, String eqNo, String cntrNo, String atchYdCd, String atchDt, String dtchYdCd, String dtchDt, String lagDt, String lagDtYd, String leadDt, String leadDtYd) {
		this.lagDtYd = lagDtYd;
		this.dtchDt = dtchDt;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.lagDt = lagDt;
		this.dtchYdCd = dtchYdCd;
		this.cntrNo = cntrNo;
		this.atchYdCd = atchYdCd;
		this.leadDt = leadDt;
		this.atchDt = atchDt;
		this.leadDtYd = leadDtYd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("lag_dt_yd", getLagDtYd());
		this.hashColumns.put("dtch_dt", getDtchDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("lag_dt", getLagDt());
		this.hashColumns.put("dtch_yd_cd", getDtchYdCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("atch_yd_cd", getAtchYdCd());
		this.hashColumns.put("lead_dt", getLeadDt());
		this.hashColumns.put("atch_dt", getAtchDt());
		this.hashColumns.put("lead_dt_yd", getLeadDtYd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("lag_dt_yd", "lagDtYd");
		this.hashFields.put("dtch_dt", "dtchDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("lag_dt", "lagDt");
		this.hashFields.put("dtch_yd_cd", "dtchYdCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("atch_yd_cd", "atchYdCd");
		this.hashFields.put("lead_dt", "leadDt");
		this.hashFields.put("atch_dt", "atchDt");
		this.hashFields.put("lead_dt_yd", "leadDtYd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return lagDtYd
	 */
	public String getLagDtYd() {
		return this.lagDtYd;
	}
	
	/**
	 * Column Info
	 * @return dtchDt
	 */
	public String getDtchDt() {
		return this.dtchDt;
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
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return lagDt
	 */
	public String getLagDt() {
		return this.lagDt;
	}
	
	/**
	 * Column Info
	 * @return dtchYdCd
	 */
	public String getDtchYdCd() {
		return this.dtchYdCd;
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
	 * @return atchYdCd
	 */
	public String getAtchYdCd() {
		return this.atchYdCd;
	}
	
	/**
	 * Column Info
	 * @return leadDt
	 */
	public String getLeadDt() {
		return this.leadDt;
	}
	
	/**
	 * Column Info
	 * @return atchDt
	 */
	public String getAtchDt() {
		return this.atchDt;
	}
	
	/**
	 * Column Info
	 * @return leadDtYd
	 */
	public String getLeadDtYd() {
		return this.leadDtYd;
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
	 * @param lagDtYd
	 */
	public void setLagDtYd(String lagDtYd) {
		this.lagDtYd = lagDtYd;
	}
	
	/**
	 * Column Info
	 * @param dtchDt
	 */
	public void setDtchDt(String dtchDt) {
		this.dtchDt = dtchDt;
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
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param lagDt
	 */
	public void setLagDt(String lagDt) {
		this.lagDt = lagDt;
	}
	
	/**
	 * Column Info
	 * @param dtchYdCd
	 */
	public void setDtchYdCd(String dtchYdCd) {
		this.dtchYdCd = dtchYdCd;
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
	 * @param atchYdCd
	 */
	public void setAtchYdCd(String atchYdCd) {
		this.atchYdCd = atchYdCd;
	}
	
	/**
	 * Column Info
	 * @param leadDt
	 */
	public void setLeadDt(String leadDt) {
		this.leadDt = leadDt;
	}
	
	/**
	 * Column Info
	 * @param atchDt
	 */
	public void setAtchDt(String atchDt) {
		this.atchDt = atchDt;
	}
	
	/**
	 * Column Info
	 * @param leadDtYd
	 */
	public void setLeadDtYd(String leadDtYd) {
		this.leadDtYd = leadDtYd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setLagDtYd(JSPUtil.getParameter(request, "lag_dt_yd", ""));
		setDtchDt(JSPUtil.getParameter(request, "dtch_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setLagDt(JSPUtil.getParameter(request, "lag_dt", ""));
		setDtchYdCd(JSPUtil.getParameter(request, "dtch_yd_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setAtchYdCd(JSPUtil.getParameter(request, "atch_yd_cd", ""));
		setLeadDt(JSPUtil.getParameter(request, "lead_dt", ""));
		setAtchDt(JSPUtil.getParameter(request, "atch_dt", ""));
		setLeadDtYd(JSPUtil.getParameter(request, "lead_dt_yd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CgmEqAtchDtchHisMGTVO[]
	 */
	public CHSAtchDtchHisMGTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CgmEqAtchDtchHisMGTVO[]
	 */
	public CHSAtchDtchHisMGTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CHSAtchDtchHisMGTVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] lagDtYd = (JSPUtil.getParameter(request, prefix	+ "lag_dt_yd", length));
			String[] dtchDt = (JSPUtil.getParameter(request, prefix	+ "dtch_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] lagDt = (JSPUtil.getParameter(request, prefix	+ "lag_dt", length));
			String[] dtchYdCd = (JSPUtil.getParameter(request, prefix	+ "dtch_yd_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] atchYdCd = (JSPUtil.getParameter(request, prefix	+ "atch_yd_cd", length));
			String[] leadDt = (JSPUtil.getParameter(request, prefix	+ "lead_dt", length));
			String[] atchDt = (JSPUtil.getParameter(request, prefix	+ "atch_dt", length));
			String[] leadDtYd = (JSPUtil.getParameter(request, prefix	+ "lead_dt_yd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CHSAtchDtchHisMGTVO();
				if (lagDtYd[i] != null)
					model.setLagDtYd(lagDtYd[i]);
				if (dtchDt[i] != null)
					model.setDtchDt(dtchDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (lagDt[i] != null)
					model.setLagDt(lagDt[i]);
				if (dtchYdCd[i] != null)
					model.setDtchYdCd(dtchYdCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (atchYdCd[i] != null)
					model.setAtchYdCd(atchYdCd[i]);
				if (leadDt[i] != null)
					model.setLeadDt(leadDt[i]);
				if (atchDt[i] != null)
					model.setAtchDt(atchDt[i]);
				if (leadDtYd[i] != null)
					model.setLeadDtYd(leadDtYd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCgmEqAtchDtchHisMGTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CgmEqAtchDtchHisMGTVO[]
	 */
	public CHSAtchDtchHisMGTVO[] getCgmEqAtchDtchHisMGTVOs(){
		CHSAtchDtchHisMGTVO[] vos = (CHSAtchDtchHisMGTVO[])models.toArray(new CHSAtchDtchHisMGTVO[models.size()]);
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
		this.lagDtYd = this.lagDtYd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtchDt = this.dtchDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lagDt = this.lagDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtchYdCd = this.dtchYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchYdCd = this.atchYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.leadDt = this.leadDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchDt = this.atchDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.leadDtYd = this.leadDtYd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
