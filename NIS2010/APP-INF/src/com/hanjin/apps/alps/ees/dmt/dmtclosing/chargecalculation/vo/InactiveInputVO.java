/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InactiveInputVO.java
*@FileTitle : InactiveInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.21
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.21  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo;

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

public class InactiveInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InactiveInputVO> models = new ArrayList<InactiveInputVO>();
	
	/* Column Info */
	private String dtTp = null;
	/* Column Info */
	private String specRsnCd = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String apvlNo = null;
	/* Column Info */
	private String chgDeltPathCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String trfCd = null;
	/* Column Info */
	private String condType = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String usrOfcCd = null;
	/* Column Info */
	private String inactNo = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String inactStsCd = null;
	/* Column Info */
	private String inactRsnCd = null;
	/* Column Info */
	private String tabCd = null;
	/* Column Info */
	private String groupBy = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public InactiveInputVO() {}

	public InactiveInputVO(String ibflag, String pagerows, String condType, String dtTp, String fmDt, String toDt, String inactStsCd, String ofcCd, String trfCd, String inactNo, String apvlNo, String bkgNo, String inactRsnCd, String specRsnCd, String tabCd, String usrId, String usrOfcCd, String chgDeltPathCd, String blNo, String groupBy) {
		this.dtTp = dtTp;
		this.specRsnCd = specRsnCd;
		this.fmDt = fmDt;
		this.apvlNo = apvlNo;
		this.chgDeltPathCd = chgDeltPathCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.trfCd = trfCd;
		this.condType = condType;
		this.toDt = toDt;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.usrOfcCd = usrOfcCd;
		this.inactNo = inactNo;
		this.usrId = usrId;
		this.inactStsCd = inactStsCd;
		this.inactRsnCd = inactRsnCd;
		this.tabCd = tabCd;
		this.groupBy = groupBy;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dt_tp", getDtTp());
		this.hashColumns.put("spec_rsn_cd", getSpecRsnCd());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("apvl_no", getApvlNo());
		this.hashColumns.put("chg_delt_path_cd", getChgDeltPathCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("trf_cd", getTrfCd());
		this.hashColumns.put("cond_type", getCondType());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("usr_ofc_cd", getUsrOfcCd());
		this.hashColumns.put("inact_no", getInactNo());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("inact_sts_cd", getInactStsCd());
		this.hashColumns.put("inact_rsn_cd", getInactRsnCd());
		this.hashColumns.put("tab_cd", getTabCd());
		this.hashColumns.put("group_by", getGroupBy());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dt_tp", "dtTp");
		this.hashFields.put("spec_rsn_cd", "specRsnCd");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("apvl_no", "apvlNo");
		this.hashFields.put("chg_delt_path_cd", "chgDeltPathCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("trf_cd", "trfCd");
		this.hashFields.put("cond_type", "condType");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("usr_ofc_cd", "usrOfcCd");
		this.hashFields.put("inact_no", "inactNo");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("inact_sts_cd", "inactStsCd");
		this.hashFields.put("inact_rsn_cd", "inactRsnCd");
		this.hashFields.put("tab_cd", "tabCd");
		this.hashFields.put("group_by", "groupBy");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dtTp
	 */
	public String getDtTp() {
		return this.dtTp;
	}
	
	/**
	 * Column Info
	 * @return specRsnCd
	 */
	public String getSpecRsnCd() {
		return this.specRsnCd;
	}
	
	/**
	 * Column Info
	 * @return fmDt
	 */
	public String getFmDt() {
		return this.fmDt;
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
	 * @return chgDeltPathCd
	 */
	public String getChgDeltPathCd() {
		return this.chgDeltPathCd;
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
	 * @return trfCd
	 */
	public String getTrfCd() {
		return this.trfCd;
	}
	
	/**
	 * Column Info
	 * @return condType
	 */
	public String getCondType() {
		return this.condType;
	}
	
	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return usrOfcCd
	 */
	public String getUsrOfcCd() {
		return this.usrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return inactNo
	 */
	public String getInactNo() {
		return this.inactNo;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return inactStsCd
	 */
	public String getInactStsCd() {
		return this.inactStsCd;
	}
	
	/**
	 * Column Info
	 * @return inactRsnCd
	 */
	public String getInactRsnCd() {
		return this.inactRsnCd;
	}
	
	/**
	 * Column Info
	 * @return tabCd
	 */
	public String getTabCd() {
		return this.tabCd;
	}
	

	/**
	 * Column Info
	 * @param dtTp
	 */
	public void setDtTp(String dtTp) {
		this.dtTp = dtTp;
	}
	
	/**
	 * Column Info
	 * @param specRsnCd
	 */
	public void setSpecRsnCd(String specRsnCd) {
		this.specRsnCd = specRsnCd;
	}
	
	/**
	 * Column Info
	 * @param fmDt
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
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
	 * @param chgDeltPathCd
	 */
	public void setChgDeltPathCd(String chgDeltPathCd) {
		this.chgDeltPathCd = chgDeltPathCd;
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
	 * @param trfCd
	 */
	public void setTrfCd(String trfCd) {
		this.trfCd = trfCd;
	}
	
	/**
	 * Column Info
	 * @param condType
	 */
	public void setCondType(String condType) {
		this.condType = condType;
	}
	
	/**
	 * Column Info
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param usrOfcCd
	 */
	public void setUsrOfcCd(String usrOfcCd) {
		this.usrOfcCd = usrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param inactNo
	 */
	public void setInactNo(String inactNo) {
		this.inactNo = inactNo;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param inactStsCd
	 */
	public void setInactStsCd(String inactStsCd) {
		this.inactStsCd = inactStsCd;
	}
	
	/**
	 * Column Info
	 * @param inactRsnCd
	 */
	public void setInactRsnCd(String inactRsnCd) {
		this.inactRsnCd = inactRsnCd;
	}
	
	/**
	 * Column Info
	 * @param tabCd
	 */
	public void setTabCd(String tabCd) {
		this.tabCd = tabCd;
	}
	
	public String getGroupBy() {
		return groupBy;
	}

	public void setGroupBy(String groupBy) {
		this.groupBy = groupBy;
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
		setDtTp(JSPUtil.getParameter(request, prefix + "dt_tp", ""));
		setSpecRsnCd(JSPUtil.getParameter(request, prefix + "spec_rsn_cd", ""));
		setFmDt(JSPUtil.getParameter(request, prefix + "fm_dt", ""));
		setApvlNo(JSPUtil.getParameter(request, prefix + "apvl_no", ""));
		setChgDeltPathCd(JSPUtil.getParameter(request, prefix + "chg_delt_path_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTrfCd(JSPUtil.getParameter(request, prefix + "trf_cd", ""));
		setCondType(JSPUtil.getParameter(request, prefix + "cond_type", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setUsrOfcCd(JSPUtil.getParameter(request, prefix + "usr_ofc_cd", ""));
		setInactNo(JSPUtil.getParameter(request, prefix + "inact_no", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setInactStsCd(JSPUtil.getParameter(request, prefix + "inact_sts_cd", ""));
		setInactRsnCd(JSPUtil.getParameter(request, prefix + "inact_rsn_cd", ""));
		setTabCd(JSPUtil.getParameter(request, prefix + "tab_cd", ""));
		setGroupBy(JSPUtil.getParameter(request, prefix + "group_by", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InactiveInputVO[]
	 */
	public InactiveInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InactiveInputVO[]
	 */
	public InactiveInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InactiveInputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dtTp = (JSPUtil.getParameter(request, prefix	+ "dt_tp", length));
			String[] specRsnCd = (JSPUtil.getParameter(request, prefix	+ "spec_rsn_cd", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] apvlNo = (JSPUtil.getParameter(request, prefix	+ "apvl_no", length));
			String[] chgDeltPathCd = (JSPUtil.getParameter(request, prefix	+ "chg_delt_path_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] trfCd = (JSPUtil.getParameter(request, prefix	+ "trf_cd", length));
			String[] condType = (JSPUtil.getParameter(request, prefix	+ "cond_type", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] usrOfcCd = (JSPUtil.getParameter(request, prefix	+ "usr_ofc_cd", length));
			String[] inactNo = (JSPUtil.getParameter(request, prefix	+ "inact_no", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] inactStsCd = (JSPUtil.getParameter(request, prefix	+ "inact_sts_cd", length));
			String[] inactRsnCd = (JSPUtil.getParameter(request, prefix	+ "inact_rsn_cd", length));
			String[] tabCd = (JSPUtil.getParameter(request, prefix	+ "tab_cd", length));
			String[] groupBy = (JSPUtil.getParameter(request, prefix	+ "group_by", length));
			
			for (int i = 0; i < length; i++) {
				model = new InactiveInputVO();
				if (dtTp[i] != null)
					model.setDtTp(dtTp[i]);
				if (specRsnCd[i] != null)
					model.setSpecRsnCd(specRsnCd[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (apvlNo[i] != null)
					model.setApvlNo(apvlNo[i]);
				if (chgDeltPathCd[i] != null)
					model.setChgDeltPathCd(chgDeltPathCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (trfCd[i] != null)
					model.setTrfCd(trfCd[i]);
				if (condType[i] != null)
					model.setCondType(condType[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (usrOfcCd[i] != null)
					model.setUsrOfcCd(usrOfcCd[i]);
				if (inactNo[i] != null)
					model.setInactNo(inactNo[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (inactStsCd[i] != null)
					model.setInactStsCd(inactStsCd[i]);
				if (inactRsnCd[i] != null)
					model.setInactRsnCd(inactRsnCd[i]);
				if (tabCd[i] != null)
					model.setTabCd(tabCd[i]);
				if (groupBy[i] != null)
					model.setGroupBy(groupBy[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInactiveInputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InactiveInputVO[]
	 */
	public InactiveInputVO[] getInactiveInputVOs(){
		InactiveInputVO[] vos = (InactiveInputVO[])models.toArray(new InactiveInputVO[models.size()]);
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
		this.dtTp = this.dtTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.specRsnCd = this.specRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apvlNo = this.apvlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgDeltPathCd = this.chgDeltPathCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfCd = this.trfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.condType = this.condType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrOfcCd = this.usrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inactNo = this.inactNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inactStsCd = this.inactStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inactRsnCd = this.inactRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tabCd = this.tabCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.groupBy = this.groupBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
