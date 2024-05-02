/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChAuditTroArManageVO.java
*@FileTitle : ChAuditTroArManageVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.17
*@LastModifier : 양봉준
*@LastVersion : 1.0
* 2009.12.17 양봉준 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.eas.transportmanage.vo;

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
 * @author 양봉준
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ChAuditTroArManageVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ChAuditTroArManageVO> models = new ArrayList<ChAuditTroArManageVO>();
	
	/* Column Info */
	private String fromsodate = null;
	/* Column Info */
	private String somonth = null;
	/* Column Info */
	private String bkgno = null;
	/* Column Info */
	private String sDtltype = null;
	/* Column Info */
	private String blno = null;
	/* Column Info */
	private String toinvdate = null;
	/* Column Info */
	private String ctrlOfcCd = null;
	/* Column Info */
	private String vvdno = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String tosodate = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String frominvdate = null;
	/* Column Info */
	private String oldOfcCd = null;
	/* Column Info */
	private String sType = null;
	/* Column Info */
	private String dType = null;
	/* Column Info */
	private String ctrlUserId = null;
	/* Column Info */
	private String sBnd = null;
	/* Column Info */
	private String invmonth = null;
	/* Column Info */
	private String selOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ChAuditTroArManageVO() {}

	public ChAuditTroArManageVO(String ibflag, String pagerows, String fromsodate, String somonth, String bkgno, String dType, String sDtltype, String blno, String toinvdate, String ctrlOfcCd, String vvdno, String tosodate, String frominvdate, String oldOfcCd, String sType, String ctrlUserId, String sBnd, String invmonth, String selOfcCd) {
		this.fromsodate = fromsodate;
		this.somonth = somonth;
		this.bkgno = bkgno;
		this.sDtltype = sDtltype;
		this.blno = blno;
		this.toinvdate = toinvdate;
		this.ctrlOfcCd = ctrlOfcCd;
		this.vvdno = vvdno;
		this.pagerows = pagerows;
		this.tosodate = tosodate;
		this.ibflag = ibflag;
		this.frominvdate = frominvdate;
		this.oldOfcCd = oldOfcCd;
		this.sType = sType;
		this.dType = dType;
		this.ctrlUserId = ctrlUserId;
		this.sBnd = sBnd;
		this.invmonth = invmonth;
		this.selOfcCd = selOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("fromsodate", getFromsodate());
		this.hashColumns.put("somonth", getSomonth());
		this.hashColumns.put("bkgno", getBkgno());
		this.hashColumns.put("s_dtltype", getSDtltype());
		this.hashColumns.put("blno", getBlno());
		this.hashColumns.put("toinvdate", getToinvdate());
		this.hashColumns.put("ctrl_ofc_cd", getCtrlOfcCd());
		this.hashColumns.put("vvdno", getVvdno());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("tosodate", getTosodate());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("frominvdate", getFrominvdate());
		this.hashColumns.put("old_ofc_cd", getOldOfcCd());
		this.hashColumns.put("s_type", getSType());
		this.hashColumns.put("d_type", getDType());
		this.hashColumns.put("ctrl_user_id", getCtrlUserId());
		this.hashColumns.put("s_bnd", getSBnd());
		this.hashColumns.put("invmonth", getInvmonth());
		this.hashColumns.put("sel_ofc_cd", getSelOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("fromsodate", "fromsodate");
		this.hashFields.put("somonth", "somonth");
		this.hashFields.put("bkgno", "bkgno");
		this.hashFields.put("s_dtltype", "sDtltype");
		this.hashFields.put("blno", "blno");
		this.hashFields.put("toinvdate", "toinvdate");
		this.hashFields.put("ctrl_ofc_cd", "ctrlOfcCd");
		this.hashFields.put("vvdno", "vvdno");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("tosodate", "tosodate");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("frominvdate", "frominvdate");
		this.hashFields.put("old_ofc_cd", "oldOfcCd");
		this.hashFields.put("s_type", "sType");
		this.hashFields.put("d_type", "dType");
		this.hashFields.put("ctrl_user_id", "ctrlUserId");
		this.hashFields.put("s_bnd", "sBnd");
		this.hashFields.put("invmonth", "invmonth");
		this.hashFields.put("sel_ofc_cd", "selOfcCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fromsodate
	 */
	public String getFromsodate() {
		return this.fromsodate;
	}
	
	/**
	 * Column Info
	 * @return somonth
	 */
	public String getSomonth() {
		return this.somonth;
	}
	
	/**
	 * Column Info
	 * @return bkgno
	 */
	public String getBkgno() {
		return this.bkgno;
	}
	
	/**
	 * Column Info
	 * @return sDtltype
	 */
	public String getSDtltype() {
		return this.sDtltype;
	}
	
	/**
	 * Column Info
	 * @return blno
	 */
	public String getBlno() {
		return this.blno;
	}
	
	/**
	 * Column Info
	 * @return toinvdate
	 */
	public String getToinvdate() {
		return this.toinvdate;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCd
	 */
	public String getCtrlOfcCd() {
		return this.ctrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return vvdno
	 */
	public String getVvdno() {
		return this.vvdno;
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
	 * @return tosodate
	 */
	public String getTosodate() {
		return this.tosodate;
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
	 * @return frominvdate
	 */
	public String getFrominvdate() {
		return this.frominvdate;
	}
	
	/**
	 * Column Info
	 * @return oldOfcCd
	 */
	public String getOldOfcCd() {
		return this.oldOfcCd;
	}
	
	/**
	 * Column Info
	 * @return sType
	 */
	public String getSType() {
		return this.sType;
	}
	
	/**
	 * Column Info
	 * @return dType
	 */
	public String getDType() {
		return this.dType;
	}
	
	/**
	 * Column Info
	 * @return ctrlUserId
	 */
	public String getCtrlUserId() {
		return this.ctrlUserId;
	}
	
	/**
	 * Column Info
	 * @return sBnd
	 */
	public String getSBnd() {
		return this.sBnd;
	}
	
	/**
	 * Column Info
	 * @return invmonth
	 */
	public String getInvmonth() {
		return this.invmonth;
	}
	
	/**
	 * Column Info
	 * @return selOfcCd
	 */
	public String getSelOfcCd() {
		return this.selOfcCd;
	}
	

	/**
	 * Column Info
	 * @param fromsodate
	 */
	public void setFromsodate(String fromsodate) {
		this.fromsodate = fromsodate;
	}
	
	/**
	 * Column Info
	 * @param somonth
	 */
	public void setSomonth(String somonth) {
		this.somonth = somonth;
	}
	
	/**
	 * Column Info
	 * @param bkgno
	 */
	public void setBkgno(String bkgno) {
		this.bkgno = bkgno;
	}
	
	/**
	 * Column Info
	 * @param sDtltype
	 */
	public void setSDtltype(String sDtltype) {
		this.sDtltype = sDtltype;
	}
	
	/**
	 * Column Info
	 * @param blno
	 */
	public void setBlno(String blno) {
		this.blno = blno;
	}
	
	/**
	 * Column Info
	 * @param toinvdate
	 */
	public void setToinvdate(String toinvdate) {
		this.toinvdate = toinvdate;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCd
	 */
	public void setCtrlOfcCd(String ctrlOfcCd) {
		this.ctrlOfcCd = ctrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param vvdno
	 */
	public void setVvdno(String vvdno) {
		this.vvdno = vvdno;
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
	 * @param tosodate
	 */
	public void setTosodate(String tosodate) {
		this.tosodate = tosodate;
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
	 * @param frominvdate
	 */
	public void setFrominvdate(String frominvdate) {
		this.frominvdate = frominvdate;
	}
	
	/**
	 * Column Info
	 * @param oldOfcCd
	 */
	public void setOldOfcCd(String oldOfcCd) {
		this.oldOfcCd = oldOfcCd;
	}
	
	/**
	 * Column Info
	 * @param sType
	 */
	public void setSType(String sType) {
		this.sType = sType;
	}
	
	/**
	 * Column Info
	 * @param dType
	 */
	public void setDType(String dType) {
		this.dType = dType;
	}
	
	/**
	 * Column Info
	 * @param ctrlUserId
	 */
	public void setCtrlUserId(String ctrlUserId) {
		this.ctrlUserId = ctrlUserId;
	}
	
	/**
	 * Column Info
	 * @param sBnd
	 */
	public void setSBnd(String sBnd) {
		this.sBnd = sBnd;
	}
	
	/**
	 * Column Info
	 * @param invmonth
	 */
	public void setInvmonth(String invmonth) {
		this.invmonth = invmonth;
	}
	
	/**
	 * Column Info
	 * @param selOfcCd
	 */
	public void setSelOfcCd(String selOfcCd) {
		this.selOfcCd = selOfcCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFromsodate(JSPUtil.getParameter(request, "fromsodate", ""));
		setSomonth(JSPUtil.getParameter(request, "somonth", ""));
		setBkgno(JSPUtil.getParameter(request, "bkgno", ""));
		setSDtltype(JSPUtil.getParameter(request, "s_dtltype", ""));
		setBlno(JSPUtil.getParameter(request, "blno", ""));
		setToinvdate(JSPUtil.getParameter(request, "toinvdate", ""));
		setCtrlOfcCd(JSPUtil.getParameter(request, "ctrl_ofc_cd", ""));
		setVvdno(JSPUtil.getParameter(request, "vvdno", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setTosodate(JSPUtil.getParameter(request, "tosodate", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFrominvdate(JSPUtil.getParameter(request, "frominvdate", ""));
		setOldOfcCd(JSPUtil.getParameter(request, "old_ofc_cd", ""));
		setSType(JSPUtil.getParameter(request, "s_type", ""));
		setDType(JSPUtil.getParameter(request, "d_type", ""));
		setCtrlUserId(JSPUtil.getParameter(request, "ctrl_user_id", ""));
		setSBnd(JSPUtil.getParameter(request, "s_bnd", ""));
		setInvmonth(JSPUtil.getParameter(request, "invmonth", ""));
		setSelOfcCd(JSPUtil.getParameter(request, "sel_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChAuditTroArManageVO[]
	 */
	public ChAuditTroArManageVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ChAuditTroArManageVO[]
	 */
	public ChAuditTroArManageVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChAuditTroArManageVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fromsodate = (JSPUtil.getParameter(request, prefix	+ "fromsodate", length));
			String[] somonth = (JSPUtil.getParameter(request, prefix	+ "somonth", length));
			String[] bkgno = (JSPUtil.getParameter(request, prefix	+ "bkgno", length));
			String[] sDtltype = (JSPUtil.getParameter(request, prefix	+ "s_dtltype", length));
			String[] blno = (JSPUtil.getParameter(request, prefix	+ "blno", length));
			String[] toinvdate = (JSPUtil.getParameter(request, prefix	+ "toinvdate", length));
			String[] ctrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd", length));
			String[] vvdno = (JSPUtil.getParameter(request, prefix	+ "vvdno", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] tosodate = (JSPUtil.getParameter(request, prefix	+ "tosodate", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] frominvdate = (JSPUtil.getParameter(request, prefix	+ "frominvdate", length));
			String[] oldOfcCd = (JSPUtil.getParameter(request, prefix	+ "old_ofc_cd", length));
			String[] sType = (JSPUtil.getParameter(request, prefix	+ "s_type", length));
			String[] dType = (JSPUtil.getParameter(request, prefix	+ "d_type", length));
			String[] ctrlUserId = (JSPUtil.getParameter(request, prefix	+ "ctrl_user_id", length));
			String[] sBnd = (JSPUtil.getParameter(request, prefix	+ "s_bnd", length));
			String[] invmonth = (JSPUtil.getParameter(request, prefix	+ "invmonth", length));
			String[] selOfcCd = (JSPUtil.getParameter(request, prefix	+ "sel_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new ChAuditTroArManageVO();
				if (fromsodate[i] != null)
					model.setFromsodate(fromsodate[i]);
				if (somonth[i] != null)
					model.setSomonth(somonth[i]);
				if (bkgno[i] != null)
					model.setBkgno(bkgno[i]);
				if (sDtltype[i] != null)
					model.setSDtltype(sDtltype[i]);
				if (blno[i] != null)
					model.setBlno(blno[i]);
				if (toinvdate[i] != null)
					model.setToinvdate(toinvdate[i]);
				if (ctrlOfcCd[i] != null)
					model.setCtrlOfcCd(ctrlOfcCd[i]);
				if (vvdno[i] != null)
					model.setVvdno(vvdno[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (tosodate[i] != null)
					model.setTosodate(tosodate[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (frominvdate[i] != null)
					model.setFrominvdate(frominvdate[i]);
				if (oldOfcCd[i] != null)
					model.setOldOfcCd(oldOfcCd[i]);
				if (sType[i] != null)
					model.setSType(sType[i]);
				if (dType[i] != null)
					model.setDType(dType[i]);
				if (ctrlUserId[i] != null)
					model.setCtrlUserId(ctrlUserId[i]);
				if (sBnd[i] != null)
					model.setSBnd(sBnd[i]);
				if (invmonth[i] != null)
					model.setInvmonth(invmonth[i]);
				if (selOfcCd[i] != null)
					model.setSelOfcCd(selOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChAuditTroArManageVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChAuditTroArManageVO[]
	 */
	public ChAuditTroArManageVO[] getChAuditTroArManageVOs(){
		ChAuditTroArManageVO[] vos = (ChAuditTroArManageVO[])models.toArray(new ChAuditTroArManageVO[models.size()]);
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
		this.fromsodate = this.fromsodate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.somonth = this.somonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgno = this.bkgno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDtltype = this.sDtltype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blno = this.blno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toinvdate = this.toinvdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd = this.ctrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdno = this.vvdno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tosodate = this.tosodate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frominvdate = this.frominvdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldOfcCd = this.oldOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sType = this.sType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dType = this.dType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlUserId = this.ctrlUserId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBnd = this.sBnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invmonth = this.invmonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selOfcCd = this.selOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
