/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SearchSeasonalSMUCostListVO.java
*@FileTitle : SearchSeasonalSMUCostListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.07
*@LastModifier : 김성훈
*@LastVersion : 1.0
* 2012.06.07 김성훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.vo;

import java.lang.reflect.Field;
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
 * @author 김성훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSeasonalSMUCostListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSeasonalSMUCostListVO> models = new ArrayList<SearchSeasonalSMUCostListVO>();
	
	/* Column Info */
	private String plcyPrcUtAmt = null;
	/* Column Info */
	private String ssnlDiffAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String vslSlanDirCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSeasonalSMUCostListVO() {}

	public SearchSeasonalSMUCostListVO(String ibflag, String pagerows, String costYrmon, String trdCd, String subTrdCd, String rlaneCd, String vslSlanDirCd, String plcyPrcUtAmt, String ssnlDiffAmt) {
		this.plcyPrcUtAmt = plcyPrcUtAmt;
		this.ssnlDiffAmt = ssnlDiffAmt;
		this.ibflag = ibflag;
		this.costYrmon = costYrmon;
		this.trdCd = trdCd;
		this.vslSlanDirCd = vslSlanDirCd;
		this.rlaneCd = rlaneCd;
		this.subTrdCd = subTrdCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("plcy_prc_ut_amt", getPlcyPrcUtAmt());
		this.hashColumns.put("ssnl_diff_amt", getSsnlDiffAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("vsl_slan_dir_cd", getVslSlanDirCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("plcy_prc_ut_amt", "plcyPrcUtAmt");
		this.hashFields.put("ssnl_diff_amt", "ssnlDiffAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("vsl_slan_dir_cd", "vslSlanDirCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return plcyPrcUtAmt
	 */
	public String getPlcyPrcUtAmt() {
		return this.plcyPrcUtAmt;
	}
	
	/**
	 * Column Info
	 * @return ssnlDiffAmt
	 */
	public String getSsnlDiffAmt() {
		return this.ssnlDiffAmt;
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
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return vslSlanDirCd
	 */
	public String getVslSlanDirCd() {
		return this.vslSlanDirCd;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
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
	 * @param plcyPrcUtAmt
	 */
	public void setPlcyPrcUtAmt(String plcyPrcUtAmt) {
		this.plcyPrcUtAmt = plcyPrcUtAmt;
	}
	
	/**
	 * Column Info
	 * @param ssnlDiffAmt
	 */
	public void setSsnlDiffAmt(String ssnlDiffAmt) {
		this.ssnlDiffAmt = ssnlDiffAmt;
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
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param vslSlanDirCd
	 */
	public void setVslSlanDirCd(String vslSlanDirCd) {
		this.vslSlanDirCd = vslSlanDirCd;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setPlcyPrcUtAmt(JSPUtil.getParameter(request, prefix + "plcy_prc_ut_amt", ""));
		setSsnlDiffAmt(JSPUtil.getParameter(request, prefix + "ssnl_diff_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setVslSlanDirCd(JSPUtil.getParameter(request, prefix + "vsl_slan_dir_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSeasonalSMUCostListVO[]
	 */
	public SearchSeasonalSMUCostListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSeasonalSMUCostListVO[]
	 */
	public SearchSeasonalSMUCostListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSeasonalSMUCostListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] plcyPrcUtAmt = (JSPUtil.getParameter(request, prefix	+ "plcy_prc_ut_amt", length));
			String[] ssnlDiffAmt = (JSPUtil.getParameter(request, prefix	+ "ssnl_diff_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] vslSlanDirCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_dir_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSeasonalSMUCostListVO();
				if (plcyPrcUtAmt[i] != null)
					model.setPlcyPrcUtAmt(plcyPrcUtAmt[i]);
				if (ssnlDiffAmt[i] != null)
					model.setSsnlDiffAmt(ssnlDiffAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (vslSlanDirCd[i] != null)
					model.setVslSlanDirCd(vslSlanDirCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSeasonalSMUCostListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSeasonalSMUCostListVO[]
	 */
	public SearchSeasonalSMUCostListVO[] getSearchSeasonalSMUCostListVOs(){
		SearchSeasonalSMUCostListVO[] vos = (SearchSeasonalSMUCostListVO[])models.toArray(new SearchSeasonalSMUCostListVO[models.size()]);
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
		this.plcyPrcUtAmt = this.plcyPrcUtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ssnlDiffAmt = this.ssnlDiffAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanDirCd = this.vslSlanDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
