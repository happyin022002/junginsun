/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AfterBookingDetailFlgVO.java
*@FileTitle : AfterBookingDetailFlgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.01
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.01  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo;

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

public class AfterBookingDetailFlgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AfterBookingDetailFlgVO> models = new ArrayList<AfterBookingDetailFlgVO>();
	
	/* Column Info */
	private String rsnDcFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String attFileFlg = null;
	/* Column Info */
	private String rsnCd = null;
	/* Column Info */
	private String expCleFlg = null;
	/* Column Info */
	private String actCostFlg = null;
	/* Column Info */
	private String cgoInvOldFlg = null;
	/* Column Info */
	private String othAttFlg = null;
	/* Column Info */
	private String custRqstFlg = null;
	/* Column Info */
	private String rsnCleFlg = null;
	/* Column Info */
	private String cgoInvNewFlg = null;
	/* Column Info */
	private String custSalPfmcFlg = null;
	/* Column Info */
	private String rsnDtlRmkFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Page Number */
	private String dmtPfmcFlg = null;
	/* Page Number */
	private String fullHisFlg = null;
	/* Page Number */
	private String rsnDesc = null;
	/* Page Number */
	private String highLowFlg = null;
	/* Page Number */
	private String gnteLtrFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AfterBookingDetailFlgVO() {}

	public AfterBookingDetailFlgVO(String ibflag, String pagerows, String rsnDcFlg, String rsnCleFlg, String custRqstFlg, String actCostFlg, String othAttFlg, String cgoInvOldFlg, String cgoInvNewFlg, String expCleFlg, String custSalPfmcFlg, String rsnCd, String attFileFlg, String rsnDtlRmkFlg, String dmtPfmcFlg, String fullHisFlg, String rsnDesc, String highLowFlg, String gnteLtrFlg) {
		this.rsnDcFlg = rsnDcFlg;
		this.ibflag = ibflag;
		this.attFileFlg = attFileFlg;
		this.rsnCd = rsnCd;
		this.expCleFlg = expCleFlg;
		this.actCostFlg = actCostFlg;
		this.cgoInvOldFlg = cgoInvOldFlg;
		this.othAttFlg = othAttFlg;
		this.custRqstFlg = custRqstFlg;
		this.rsnCleFlg = rsnCleFlg;
		this.cgoInvNewFlg = cgoInvNewFlg;
		this.custSalPfmcFlg = custSalPfmcFlg;
		this.rsnDtlRmkFlg = rsnDtlRmkFlg;
		this.pagerows = pagerows;
		this.dmtPfmcFlg = dmtPfmcFlg;
		this.fullHisFlg = fullHisFlg;
		this.rsnDesc = rsnDesc;
		this.highLowFlg = highLowFlg;
		this.gnteLtrFlg = gnteLtrFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rsn_dc_flg", getRsnDcFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("att_file_flg", getAttFileFlg());
		this.hashColumns.put("rsn_cd", getRsnCd());
		this.hashColumns.put("exp_cle_flg", getExpCleFlg());
		this.hashColumns.put("act_cost_flg", getActCostFlg());
		this.hashColumns.put("cgo_inv_old_flg", getCgoInvOldFlg());
		this.hashColumns.put("oth_att_flg", getOthAttFlg());
		this.hashColumns.put("cust_rqst_flg", getCustRqstFlg());
		this.hashColumns.put("rsn_cle_flg", getRsnCleFlg());
		this.hashColumns.put("cgo_inv_new_flg", getCgoInvNewFlg());
		this.hashColumns.put("cust_sal_pfmc_flg", getCustSalPfmcFlg());
		this.hashColumns.put("rsn_dtl_rmk_flg", getRsnDtlRmkFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dmt_pfmc_flg", getDmtPfmcFlg());
		this.hashColumns.put("full_his_flg", getFullHisFlg());
		this.hashColumns.put("rsn_desc", getRsnDesc());
		this.hashColumns.put("high_low_flg", getHighLowFlg());
		this.hashColumns.put("gnte_ltr_flg", getGnteLtrFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rsn_dc_flg", "rsnDcFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("att_file_flg", "attFileFlg");
		this.hashFields.put("rsn_cd", "rsnCd");
		this.hashFields.put("exp_cle_flg", "expCleFlg");
		this.hashFields.put("act_cost_flg", "actCostFlg");
		this.hashFields.put("cgo_inv_old_flg", "cgoInvOldFlg");
		this.hashFields.put("oth_att_flg", "othAttFlg");
		this.hashFields.put("cust_rqst_flg", "custRqstFlg");
		this.hashFields.put("rsn_cle_flg", "rsnCleFlg");
		this.hashFields.put("cgo_inv_new_flg", "cgoInvNewFlg");
		this.hashFields.put("cust_sal_pfmc_flg", "custSalPfmcFlg");
		this.hashFields.put("rsn_dtl_rmk_flg", "rsnDtlRmkFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dmt_pfmc_flg", "dmtPfmcFlg");
		this.hashFields.put("full_his_flg", "fullHisFlg");
		this.hashFields.put("rsn_desc", "rsnDesc");
		this.hashFields.put("high_low_flg", "highLowFlg");
		this.hashFields.put("gnte_ltr_flg", "gnteLtrFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rsnDcFlg
	 */
	public String getRsnDcFlg() {
		return this.rsnDcFlg;
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
	 * @return attFileFlg
	 */
	public String getAttFileFlg() {
		return this.attFileFlg;
	}
	
	/**
	 * Column Info
	 * @return rsnCd
	 */
	public String getRsnCd() {
		return this.rsnCd;
	}
	
	/**
	 * Column Info
	 * @return expCleFlg
	 */
	public String getExpCleFlg() {
		return this.expCleFlg;
	}
	
	/**
	 * Column Info
	 * @return actCostFlg
	 */
	public String getActCostFlg() {
		return this.actCostFlg;
	}
	
	/**
	 * Column Info
	 * @return cgoInvOldFlg
	 */
	public String getCgoInvOldFlg() {
		return this.cgoInvOldFlg;
	}
	
	/**
	 * Column Info
	 * @return othAttFlg
	 */
	public String getOthAttFlg() {
		return this.othAttFlg;
	}
	
	/**
	 * Column Info
	 * @return custRqstFlg
	 */
	public String getCustRqstFlg() {
		return this.custRqstFlg;
	}
	
	/**
	 * Column Info
	 * @return rsnCleFlg
	 */
	public String getRsnCleFlg() {
		return this.rsnCleFlg;
	}
	
	/**
	 * Column Info
	 * @return cgoInvNewFlg
	 */
	public String getCgoInvNewFlg() {
		return this.cgoInvNewFlg;
	}
	
	/**
	 * Column Info
	 * @return custSalPfmcFlg
	 */
	public String getCustSalPfmcFlg() {
		return this.custSalPfmcFlg;
	}
	
	/**
	 * Column Info
	 * @return rsnDtlRmkFlg
	 */
	public String getRsnDtlRmkFlg() {
		return this.rsnDtlRmkFlg;
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
	 * @param rsnDcFlg
	 */
	public void setRsnDcFlg(String rsnDcFlg) {
		this.rsnDcFlg = rsnDcFlg;
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
	 * @param attFileFlg
	 */
	public void setAttFileFlg(String attFileFlg) {
		this.attFileFlg = attFileFlg;
	}
	
	/**
	 * Column Info
	 * @param rsnCd
	 */
	public void setRsnCd(String rsnCd) {
		this.rsnCd = rsnCd;
	}
	
	/**
	 * Column Info
	 * @param expCleFlg
	 */
	public void setExpCleFlg(String expCleFlg) {
		this.expCleFlg = expCleFlg;
	}
	
	/**
	 * Column Info
	 * @param actCostFlg
	 */
	public void setActCostFlg(String actCostFlg) {
		this.actCostFlg = actCostFlg;
	}
	
	/**
	 * Column Info
	 * @param cgoInvOldFlg
	 */
	public void setCgoInvOldFlg(String cgoInvOldFlg) {
		this.cgoInvOldFlg = cgoInvOldFlg;
	}
	
	/**
	 * Column Info
	 * @param othAttFlg
	 */
	public void setOthAttFlg(String othAttFlg) {
		this.othAttFlg = othAttFlg;
	}
	
	/**
	 * Column Info
	 * @param custRqstFlg
	 */
	public void setCustRqstFlg(String custRqstFlg) {
		this.custRqstFlg = custRqstFlg;
	}
	
	/**
	 * Column Info
	 * @param rsnCleFlg
	 */
	public void setRsnCleFlg(String rsnCleFlg) {
		this.rsnCleFlg = rsnCleFlg;
	}
	
	/**
	 * Column Info
	 * @param cgoInvNewFlg
	 */
	public void setCgoInvNewFlg(String cgoInvNewFlg) {
		this.cgoInvNewFlg = cgoInvNewFlg;
	}
	
	/**
	 * Column Info
	 * @param custSalPfmcFlg
	 */
	public void setCustSalPfmcFlg(String custSalPfmcFlg) {
		this.custSalPfmcFlg = custSalPfmcFlg;
	}
	
	/**
	 * Column Info
	 * @param rsnDtlRmkFlg
	 */
	public void setRsnDtlRmkFlg(String rsnDtlRmkFlg) {
		this.rsnDtlRmkFlg = rsnDtlRmkFlg;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	public String getDmtPfmcFlg() {
		return dmtPfmcFlg;
	}

	public void setDmtPfmcFlg(String dmtPfmcFlg) {
		this.dmtPfmcFlg = dmtPfmcFlg;
	}

	public String getFullHisFlg() {
		return fullHisFlg;
	}

	public void setFullHisFlg(String fullHisFlg) {
		this.fullHisFlg = fullHisFlg;
	}

	public String getRsnDesc() {
		return rsnDesc;
	}

	public void setRsnDesc(String rsnDesc) {
		this.rsnDesc = rsnDesc;
	}

	public String getHighLowFlg() {
		return highLowFlg;
	}

	public void setHighLowFlg(String highLowFlg) {
		this.highLowFlg = highLowFlg;
	}

	public String getGnteLtrFlg() {
		return gnteLtrFlg;
	}

	public void setGnteLtrFlg(String gnteLtrFlg) {
		this.gnteLtrFlg = gnteLtrFlg;
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
		setRsnDcFlg(JSPUtil.getParameter(request, prefix + "rsn_dc_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAttFileFlg(JSPUtil.getParameter(request, prefix + "att_file_flg", ""));
		setRsnCd(JSPUtil.getParameter(request, prefix + "rsn_cd", ""));
		setExpCleFlg(JSPUtil.getParameter(request, prefix + "exp_cle_flg", ""));
		setActCostFlg(JSPUtil.getParameter(request, prefix + "act_cost_flg", ""));
		setCgoInvOldFlg(JSPUtil.getParameter(request, prefix + "cgo_inv_old_flg", ""));
		setOthAttFlg(JSPUtil.getParameter(request, prefix + "oth_att_flg", ""));
		setCustRqstFlg(JSPUtil.getParameter(request, prefix + "cust_rqst_flg", ""));
		setRsnCleFlg(JSPUtil.getParameter(request, prefix + "rsn_cle_flg", ""));
		setCgoInvNewFlg(JSPUtil.getParameter(request, prefix + "cgo_inv_new_flg", ""));
		setCustSalPfmcFlg(JSPUtil.getParameter(request, prefix + "cust_sal_pfmc_flg", ""));
		setRsnDtlRmkFlg(JSPUtil.getParameter(request, prefix + "rsn_dtl_rmk_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDmtPfmcFlg(JSPUtil.getParameter(request, prefix + "dmt_pfmc_flg", ""));
		setFullHisFlg(JSPUtil.getParameter(request, prefix + "full_his_flg", ""));
		setRsnDesc(JSPUtil.getParameter(request, prefix + "rsn_desc", ""));
		setHighLowFlg(JSPUtil.getParameter(request, prefix + "high_low_flg", ""));
		setGnteLtrFlg(JSPUtil.getParameter(request, prefix + "gnte_ltr_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AfterBookingDetailFlgVO[]
	 */
	public AfterBookingDetailFlgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AfterBookingDetailFlgVO[]
	 */
	public AfterBookingDetailFlgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AfterBookingDetailFlgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rsnDcFlg = (JSPUtil.getParameter(request, prefix	+ "rsn_dc_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] attFileFlg = (JSPUtil.getParameter(request, prefix	+ "att_file_flg", length));
			String[] rsnCd = (JSPUtil.getParameter(request, prefix	+ "rsn_cd", length));
			String[] expCleFlg = (JSPUtil.getParameter(request, prefix	+ "exp_cle_flg", length));
			String[] actCostFlg = (JSPUtil.getParameter(request, prefix	+ "act_cost_flg", length));
			String[] cgoInvOldFlg = (JSPUtil.getParameter(request, prefix	+ "cgo_inv_old_flg", length));
			String[] othAttFlg = (JSPUtil.getParameter(request, prefix	+ "oth_att_flg", length));
			String[] custRqstFlg = (JSPUtil.getParameter(request, prefix	+ "cust_rqst_flg", length));
			String[] rsnCleFlg = (JSPUtil.getParameter(request, prefix	+ "rsn_cle_flg", length));
			String[] cgoInvNewFlg = (JSPUtil.getParameter(request, prefix	+ "cgo_inv_new_flg", length));
			String[] custSalPfmcFlg = (JSPUtil.getParameter(request, prefix	+ "cust_sal_pfmc_flg", length));
			String[] rsnDtlRmkFlg = (JSPUtil.getParameter(request, prefix	+ "rsn_dtl_rmk_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] dmtPfmcFlg = (JSPUtil.getParameter(request, prefix	+ "dmt_pfmc_flg", length));
			String[] fullHisFlg = (JSPUtil.getParameter(request, prefix	+ "full_his_flg", length));
			String[] rsnDesc = (JSPUtil.getParameter(request, prefix	+ "rsn_desc", length));
			String[] highLowFlg = (JSPUtil.getParameter(request, prefix	+ "high_low_flg", length));
			String[] gnteLtrFlg = (JSPUtil.getParameter(request, prefix	+ "gnteLtrFlg", length));
			
			for (int i = 0; i < length; i++) {
				model = new AfterBookingDetailFlgVO();
				if (rsnDcFlg[i] != null)
					model.setRsnDcFlg(rsnDcFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (attFileFlg[i] != null)
					model.setAttFileFlg(attFileFlg[i]);
				if (rsnCd[i] != null)
					model.setRsnCd(rsnCd[i]);
				if (expCleFlg[i] != null)
					model.setExpCleFlg(expCleFlg[i]);
				if (actCostFlg[i] != null)
					model.setActCostFlg(actCostFlg[i]);
				if (cgoInvOldFlg[i] != null)
					model.setCgoInvOldFlg(cgoInvOldFlg[i]);
				if (othAttFlg[i] != null)
					model.setOthAttFlg(othAttFlg[i]);
				if (custRqstFlg[i] != null)
					model.setCustRqstFlg(custRqstFlg[i]);
				if (rsnCleFlg[i] != null)
					model.setRsnCleFlg(rsnCleFlg[i]);
				if (cgoInvNewFlg[i] != null)
					model.setCgoInvNewFlg(cgoInvNewFlg[i]);
				if (custSalPfmcFlg[i] != null)
					model.setCustSalPfmcFlg(custSalPfmcFlg[i]);
				if (rsnDtlRmkFlg[i] != null)
					model.setRsnDtlRmkFlg(rsnDtlRmkFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (dmtPfmcFlg[i] != null)
					model.setDmtPfmcFlg(dmtPfmcFlg[i]);
				if (fullHisFlg[i] != null)
					model.setFullHisFlg(fullHisFlg[i]);
				if (rsnDesc[i] != null)
					model.setRsnDesc(rsnDesc[i]);
				if (highLowFlg[i] != null)
					model.setHighLowFlg(highLowFlg[i]);
				if (gnteLtrFlg[i] != null)
					model.setGnteLtrFlg(gnteLtrFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAfterBookingDetailFlgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AfterBookingDetailFlgVO[]
	 */
	public AfterBookingDetailFlgVO[] getAfterBookingDetailFlgVOs(){
		AfterBookingDetailFlgVO[] vos = (AfterBookingDetailFlgVO[])models.toArray(new AfterBookingDetailFlgVO[models.size()]);
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
		this.rsnDcFlg = this.rsnDcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attFileFlg = this.attFileFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsnCd = this.rsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expCleFlg = this.expCleFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCostFlg = this.actCostFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoInvOldFlg = this.cgoInvOldFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.othAttFlg = this.othAttFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRqstFlg = this.custRqstFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsnCleFlg = this.rsnCleFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoInvNewFlg = this.cgoInvNewFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSalPfmcFlg = this.custSalPfmcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsnDtlRmkFlg = this.rsnDtlRmkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmtPfmcFlg = this.dmtPfmcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullHisFlg = this.fullHisFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsnDesc = this.rsnDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.highLowFlg = this.highLowFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gnteLtrFlg = this.gnteLtrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
