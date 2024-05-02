/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MGSAtdtHistoryMGTVO.java
*@FileTitle : MGSAtdtHistoryMGTVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.26
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2010.04.26 조재성 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo;

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
 * @author 조재성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MGSAtdtHistoryMGTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MGSAtdtHistoryMGTVO> models = new ArrayList<MGSAtdtHistoryMGTVO>();
	
	/* Column Info */
	private String orgAtchDt = null;
	/* Column Info */
	private String atchDtHd = null;
	/* Column Info */
	private String atchYdCd = null;
	/* Column Info */
	private String atchDt = null;
	/* Column Info */
	private String dtchDtHd = null;
	/* Column Info */
	private String cntrChss = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String dtchDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String dtchYdCd = null;
	/* Column Info */
	private String dtchDtDay = null;
	/* Column Info */
	private String atchDtDay = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MGSAtdtHistoryMGTVO() {}

	public MGSAtdtHistoryMGTVO(String ibflag, String pagerows, String dtchDt, String dtchDtDay, String dtchDtHd, String dtchYdCd, String atchYdCd, String atchDt, String atchDtDay, String atchDtHd, String cntrChss, String eqNo, String updUsrId, String orgAtchDt) {
		this.orgAtchDt = orgAtchDt;
		this.atchDtHd = atchDtHd;
		this.atchYdCd = atchYdCd;
		this.atchDt = atchDt;
		this.dtchDtHd = dtchDtHd;
		this.cntrChss = cntrChss;
		this.pagerows = pagerows;
		this.dtchDt = dtchDt;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.dtchYdCd = dtchYdCd;
		this.dtchDtDay = dtchDtDay;
		this.atchDtDay = atchDtDay;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("org_atch_dt", getOrgAtchDt());
		this.hashColumns.put("atch_dt_hd", getAtchDtHd());
		this.hashColumns.put("atch_yd_cd", getAtchYdCd());
		this.hashColumns.put("atch_dt", getAtchDt());
		this.hashColumns.put("dtch_dt_hd", getDtchDtHd());
		this.hashColumns.put("cntr_chss", getCntrChss());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dtch_dt", getDtchDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("dtch_yd_cd", getDtchYdCd());
		this.hashColumns.put("dtch_dt_day", getDtchDtDay());
		this.hashColumns.put("atch_dt_day", getAtchDtDay());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("org_atch_dt", "orgAtchDt");
		this.hashFields.put("atch_dt_hd", "atchDtHd");
		this.hashFields.put("atch_yd_cd", "atchYdCd");
		this.hashFields.put("atch_dt", "atchDt");
		this.hashFields.put("dtch_dt_hd", "dtchDtHd");
		this.hashFields.put("cntr_chss", "cntrChss");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dtch_dt", "dtchDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("dtch_yd_cd", "dtchYdCd");
		this.hashFields.put("dtch_dt_day", "dtchDtDay");
		this.hashFields.put("atch_dt_day", "atchDtDay");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return orgAtchDt
	 */
	public String getOrgAtchDt() {
		return this.orgAtchDt;
	}
	
	/**
	 * Column Info
	 * @return atchDtHd
	 */
	public String getAtchDtHd() {
		return this.atchDtHd;
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
	 * @return atchDt
	 */
	public String getAtchDt() {
		return this.atchDt;
	}
	
	/**
	 * Column Info
	 * @return dtchDtHd
	 */
	public String getDtchDtHd() {
		return this.dtchDtHd;
	}
	
	/**
	 * Column Info
	 * @return cntrChss
	 */
	public String getCntrChss() {
		return this.cntrChss;
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
	 * @return dtchYdCd
	 */
	public String getDtchYdCd() {
		return this.dtchYdCd;
	}
	
	/**
	 * Column Info
	 * @return dtchDtDay
	 */
	public String getDtchDtDay() {
		return this.dtchDtDay;
	}
	
	/**
	 * Column Info
	 * @return atchDtDay
	 */
	public String getAtchDtDay() {
		return this.atchDtDay;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	

	/**
	 * Column Info
	 * @param orgAtchDt
	 */
	public void setOrgAtchDt(String orgAtchDt) {
		this.orgAtchDt = orgAtchDt;
	}
	
	/**
	 * Column Info
	 * @param atchDtHd
	 */
	public void setAtchDtHd(String atchDtHd) {
		this.atchDtHd = atchDtHd;
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
	 * @param atchDt
	 */
	public void setAtchDt(String atchDt) {
		this.atchDt = atchDt;
	}
	
	/**
	 * Column Info
	 * @param dtchDtHd
	 */
	public void setDtchDtHd(String dtchDtHd) {
		this.dtchDtHd = dtchDtHd;
	}
	
	/**
	 * Column Info
	 * @param cntrChss
	 */
	public void setCntrChss(String cntrChss) {
		this.cntrChss = cntrChss;
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
	 * @param dtchYdCd
	 */
	public void setDtchYdCd(String dtchYdCd) {
		this.dtchYdCd = dtchYdCd;
	}
	
	/**
	 * Column Info
	 * @param dtchDtDay
	 */
	public void setDtchDtDay(String dtchDtDay) {
		this.dtchDtDay = dtchDtDay;
	}
	
	/**
	 * Column Info
	 * @param atchDtDay
	 */
	public void setAtchDtDay(String atchDtDay) {
		this.atchDtDay = atchDtDay;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setOrgAtchDt(JSPUtil.getParameter(request, prefix + "org_atch_dt", ""));
		setAtchDtHd(JSPUtil.getParameter(request, prefix + "atch_dt_hd", ""));
		setAtchYdCd(JSPUtil.getParameter(request, prefix + "atch_yd_cd", ""));
		setAtchDt(JSPUtil.getParameter(request, prefix + "atch_dt", ""));
		setDtchDtHd(JSPUtil.getParameter(request, prefix + "dtch_dt_hd", ""));
		setCntrChss(JSPUtil.getParameter(request, prefix + "cntr_chss", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDtchDt(JSPUtil.getParameter(request, prefix + "dtch_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setDtchYdCd(JSPUtil.getParameter(request, prefix + "dtch_yd_cd", ""));
		setDtchDtDay(JSPUtil.getParameter(request, prefix + "dtch_dt_day", ""));
		setAtchDtDay(JSPUtil.getParameter(request, prefix + "atch_dt_day", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MGSAtdtHistoryMGTVO[]
	 */
	public MGSAtdtHistoryMGTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MGSAtdtHistoryMGTVO[]
	 */
	public MGSAtdtHistoryMGTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MGSAtdtHistoryMGTVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] orgAtchDt = (JSPUtil.getParameter(request, prefix	+ "org_atch_dt", length));
			String[] atchDtHd = (JSPUtil.getParameter(request, prefix	+ "atch_dt_hd", length));
			String[] atchYdCd = (JSPUtil.getParameter(request, prefix	+ "atch_yd_cd", length));
			String[] atchDt = (JSPUtil.getParameter(request, prefix	+ "atch_dt", length));
			String[] dtchDtHd = (JSPUtil.getParameter(request, prefix	+ "dtch_dt_hd", length));
			String[] cntrChss = (JSPUtil.getParameter(request, prefix	+ "cntr_chss", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] dtchDt = (JSPUtil.getParameter(request, prefix	+ "dtch_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] dtchYdCd = (JSPUtil.getParameter(request, prefix	+ "dtch_yd_cd", length));
			String[] dtchDtDay = (JSPUtil.getParameter(request, prefix	+ "dtch_dt_day", length));
			String[] atchDtDay = (JSPUtil.getParameter(request, prefix	+ "atch_dt_day", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new MGSAtdtHistoryMGTVO();
				if (orgAtchDt[i] != null)
					model.setOrgAtchDt(orgAtchDt[i]);
				if (atchDtHd[i] != null)
					model.setAtchDtHd(atchDtHd[i]);
				if (atchYdCd[i] != null)
					model.setAtchYdCd(atchYdCd[i]);
				if (atchDt[i] != null)
					model.setAtchDt(atchDt[i]);
				if (dtchDtHd[i] != null)
					model.setDtchDtHd(dtchDtHd[i]);
				if (cntrChss[i] != null)
					model.setCntrChss(cntrChss[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (dtchDt[i] != null)
					model.setDtchDt(dtchDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (dtchYdCd[i] != null)
					model.setDtchYdCd(dtchYdCd[i]);
				if (dtchDtDay[i] != null)
					model.setDtchDtDay(dtchDtDay[i]);
				if (atchDtDay[i] != null)
					model.setAtchDtDay(atchDtDay[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMGSAtdtHistoryMGTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MGSAtdtHistoryMGTVO[]
	 */
	public MGSAtdtHistoryMGTVO[] getMGSAtdtHistoryMGTVOs(){
		MGSAtdtHistoryMGTVO[] vos = (MGSAtdtHistoryMGTVO[])models.toArray(new MGSAtdtHistoryMGTVO[models.size()]);
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
		this.orgAtchDt = this.orgAtchDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchDtHd = this.atchDtHd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchYdCd = this.atchYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchDt = this.atchDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtchDtHd = this.dtchDtHd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrChss = this.cntrChss .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtchDt = this.dtchDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtchYdCd = this.dtchYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtchDtDay = this.dtchDtDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchDtDay = this.atchDtDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
