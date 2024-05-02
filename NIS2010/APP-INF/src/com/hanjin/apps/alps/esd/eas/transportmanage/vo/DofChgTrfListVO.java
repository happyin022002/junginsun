/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DofChgTrfListVO.java
*@FileTitle : DofChgTrfListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.19
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.19  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.transportmanage.vo;

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

public class DofChgTrfListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DofChgTrfListVO> models = new ArrayList<DofChgTrfListVO>();
	
	/* Column Info */
	private String custRmk = null;
	/* Column Info */
	private String custInfo = null;
	/* Column Info */
	private String contiCd = null;
	/* Column Info */
	private String contiCdOld = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String chrrFrtTaxVal = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String cntrTpCd = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String fmLocCd = null;
	/* Column Info */
	private String effdt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DofChgTrfListVO() {}

	public DofChgTrfListVO(String ibflag, String pagerows, String effdt, String fmLocCd, String custInfo, String contiCd, String contiCdOld, String cntrTpCd, String currCd, String chrrFrtTaxVal, String creUsrId, String custRmk, String creOfcCd) {
		this.custRmk = custRmk;
		this.custInfo = custInfo;
		this.contiCd = contiCd;
		this.contiCdOld = contiCdOld;
		this.creUsrId = creUsrId;
		this.chrrFrtTaxVal = chrrFrtTaxVal;
		this.ibflag = ibflag;
		this.currCd = currCd;
		this.cntrTpCd = cntrTpCd;
		this.creOfcCd = creOfcCd;
		this.fmLocCd = fmLocCd;
		this.effdt = effdt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cust_rmk", getCustRmk());
		this.hashColumns.put("cust_info", getCustInfo());
		this.hashColumns.put("conti_cd", getContiCd());
		this.hashColumns.put("conti_cd_old", getContiCdOld());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("chrr_frt_tax_val", getChrrFrtTaxVal());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("cntr_tp_cd", getCntrTpCd());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("fm_loc_cd", getFmLocCd());
		this.hashColumns.put("effdt", getEffdt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cust_rmk", "custRmk");
		this.hashFields.put("cust_info", "custInfo");
		this.hashFields.put("conti_cd", "contiCd");
		this.hashFields.put("conti_cd_old", "contiCdOld");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("chrr_frt_tax_val", "chrrFrtTaxVal");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("cntr_tp_cd", "cntrTpCd");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("fm_loc_cd", "fmLocCd");
		this.hashFields.put("effdt", "effdt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return custRmk
	 */
	public String getCustRmk() {
		return this.custRmk;
	}
	
	/**
	 * Column Info
	 * @return custInfo
	 */
	public String getCustInfo() {
		return this.custInfo;
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
	 * @return contiCdOld
	 */
	public String getContiCdOld() {
		return this.contiCdOld;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return chrrFrtTaxVal
	 */
	public String getChrrFrtTaxVal() {
		return this.chrrFrtTaxVal;
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
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return cntrTpCd
	 */
	public String getCntrTpCd() {
		return this.cntrTpCd;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return fmLocCd
	 */
	public String getFmLocCd() {
		return this.fmLocCd;
	}
	
	/**
	 * Column Info
	 * @return effdt
	 */
	public String getEffdt() {
		return this.effdt;
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
	 * @param custRmk
	 */
	public void setCustRmk(String custRmk) {
		this.custRmk = custRmk;
	}
	
	/**
	 * Column Info
	 * @param custInfo
	 */
	public void setCustInfo(String custInfo) {
		this.custInfo = custInfo;
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
	 * @param contiCdOld
	 */
	public void setContiCdOld(String contiCdOld) {
		this.contiCdOld = contiCdOld;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param chrrFrtTaxVal
	 */
	public void setChrrFrtTaxVal(String chrrFrtTaxVal) {
		this.chrrFrtTaxVal = chrrFrtTaxVal;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param cntrTpCd
	 */
	public void setCntrTpCd(String cntrTpCd) {
		this.cntrTpCd = cntrTpCd;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param fmLocCd
	 */
	public void setFmLocCd(String fmLocCd) {
		this.fmLocCd = fmLocCd;
	}
	
	/**
	 * Column Info
	 * @param effdt
	 */
	public void setEffdt(String effdt) {
		this.effdt = effdt;
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
		setCustRmk(JSPUtil.getParameter(request, "cust_rmk", ""));
		setCustInfo(JSPUtil.getParameter(request, "cust_info", ""));
		setContiCd(JSPUtil.getParameter(request, "conti_cd", ""));
		setContiCdOld(JSPUtil.getParameter(request, "conti_cd_old", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setChrrFrtTaxVal(JSPUtil.getParameter(request, "chrr_frt_tax_val", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setCntrTpCd(JSPUtil.getParameter(request, "cntr_tp_cd", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setFmLocCd(JSPUtil.getParameter(request, "fm_loc_cd", ""));
		setEffdt(JSPUtil.getParameter(request, "effdt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DofChgTrfListVO[]
	 */
	public DofChgTrfListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DofChgTrfListVO[]
	 */
	public DofChgTrfListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DofChgTrfListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] custRmk = (JSPUtil.getParameter(request, prefix	+ "cust_rmk", length));
			String[] custInfo = (JSPUtil.getParameter(request, prefix	+ "cust_info", length));
			String[] contiCd = (JSPUtil.getParameter(request, prefix	+ "conti_cd", length));
			String[] contiCdOld = (JSPUtil.getParameter(request, prefix	+ "conti_cd_old", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] chrrFrtTaxVal = (JSPUtil.getParameter(request, prefix	+ "chrr_frt_tax_val", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] cntrTpCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tp_cd", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] fmLocCd = (JSPUtil.getParameter(request, prefix	+ "fm_loc_cd", length));
			String[] effdt = (JSPUtil.getParameter(request, prefix	+ "effdt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new DofChgTrfListVO();
				if (custRmk[i] != null)
					model.setCustRmk(custRmk[i]);
				if (custInfo[i] != null)
					model.setCustInfo(custInfo[i]);
				if (contiCd[i] != null)
					model.setContiCd(contiCd[i]);
				if (contiCdOld[i] != null)
					model.setContiCdOld(contiCdOld[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (chrrFrtTaxVal[i] != null)
					model.setChrrFrtTaxVal(chrrFrtTaxVal[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (cntrTpCd[i] != null)
					model.setCntrTpCd(cntrTpCd[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (fmLocCd[i] != null)
					model.setFmLocCd(fmLocCd[i]);
				if (effdt[i] != null)
					model.setEffdt(effdt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDofChgTrfListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DofChgTrfListVO[]
	 */
	public DofChgTrfListVO[] getDofChgTrfListVOs(){
		DofChgTrfListVO[] vos = (DofChgTrfListVO[])models.toArray(new DofChgTrfListVO[models.size()]);
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
		this.custRmk = this.custRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custInfo = this.custInfo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contiCd = this.contiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contiCdOld = this.contiCdOld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chrrFrtTaxVal = this.chrrFrtTaxVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpCd = this.cntrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmLocCd = this.fmLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effdt = this.effdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
