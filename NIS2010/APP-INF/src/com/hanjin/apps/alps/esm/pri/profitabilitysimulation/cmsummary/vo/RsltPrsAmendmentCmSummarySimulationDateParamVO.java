/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RsltPrsAmendmentCmSummarySimulationDateParamVO.java
*@FileTitle : RsltPrsAmendmentCmSummarySimulationDateParamVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.09
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.02.09 송민석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo;

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
 * @author 송민석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltPrsAmendmentCmSummarySimulationDateParamVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPrsAmendmentCmSummarySimulationDateParamVO> models = new ArrayList<RsltPrsAmendmentCmSummarySimulationDateParamVO>();
	
	/* Column Info */
	private String rToYrwk = null;
	/* Column Info */
	private String rFmYrwk = null;
	/* Column Info */
	private String sSlsFmDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cSlsToDt = null;
	/* Column Info */
	private String rSlsToDt = null;
	/* Column Info */
	private String rSlsFmDt = null;
	/* Column Info */
	private String sSlsToDt = null;
	/* Column Info */
	private String cSlsFmDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPrsAmendmentCmSummarySimulationDateParamVO() {}

	public RsltPrsAmendmentCmSummarySimulationDateParamVO(String ibflag, String pagerows, String cSlsFmDt, String cSlsToDt, String sSlsFmDt, String sSlsToDt, String rSlsFmDt, String rSlsToDt, String rFmYrwk, String rToYrwk) {
		this.rToYrwk = rToYrwk;
		this.rFmYrwk = rFmYrwk;
		this.sSlsFmDt = sSlsFmDt;
		this.ibflag = ibflag;
		this.cSlsToDt = cSlsToDt;
		this.rSlsToDt = rSlsToDt;
		this.rSlsFmDt = rSlsFmDt;
		this.sSlsToDt = sSlsToDt;
		this.cSlsFmDt = cSlsFmDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("r_to_yrwk", getRToYrwk());
		this.hashColumns.put("r_fm_yrwk", getRFmYrwk());
		this.hashColumns.put("s_sls_fm_dt", getSSlsFmDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("c_sls_to_dt", getCSlsToDt());
		this.hashColumns.put("r_sls_to_dt", getRSlsToDt());
		this.hashColumns.put("r_sls_fm_dt", getRSlsFmDt());
		this.hashColumns.put("s_sls_to_dt", getSSlsToDt());
		this.hashColumns.put("c_sls_fm_dt", getCSlsFmDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("r_to_yrwk", "rToYrwk");
		this.hashFields.put("r_fm_yrwk", "rFmYrwk");
		this.hashFields.put("s_sls_fm_dt", "sSlsFmDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("c_sls_to_dt", "cSlsToDt");
		this.hashFields.put("r_sls_to_dt", "rSlsToDt");
		this.hashFields.put("r_sls_fm_dt", "rSlsFmDt");
		this.hashFields.put("s_sls_to_dt", "sSlsToDt");
		this.hashFields.put("c_sls_fm_dt", "cSlsFmDt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rToYrwk
	 */
	public String getRToYrwk() {
		return this.rToYrwk;
	}
	
	/**
	 * Column Info
	 * @return rFmYrwk
	 */
	public String getRFmYrwk() {
		return this.rFmYrwk;
	}
	
	/**
	 * Column Info
	 * @return sSlsFmDt
	 */
	public String getSSlsFmDt() {
		return this.sSlsFmDt;
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
	 * @return cSlsToDt
	 */
	public String getCSlsToDt() {
		return this.cSlsToDt;
	}
	
	/**
	 * Column Info
	 * @return rSlsToDt
	 */
	public String getRSlsToDt() {
		return this.rSlsToDt;
	}
	
	/**
	 * Column Info
	 * @return rSlsFmDt
	 */
	public String getRSlsFmDt() {
		return this.rSlsFmDt;
	}
	
	/**
	 * Column Info
	 * @return sSlsToDt
	 */
	public String getSSlsToDt() {
		return this.sSlsToDt;
	}
	
	/**
	 * Column Info
	 * @return cSlsFmDt
	 */
	public String getCSlsFmDt() {
		return this.cSlsFmDt;
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
	 * @param rToYrwk
	 */
	public void setRToYrwk(String rToYrwk) {
		this.rToYrwk = rToYrwk;
	}
	
	/**
	 * Column Info
	 * @param rFmYrwk
	 */
	public void setRFmYrwk(String rFmYrwk) {
		this.rFmYrwk = rFmYrwk;
	}
	
	/**
	 * Column Info
	 * @param sSlsFmDt
	 */
	public void setSSlsFmDt(String sSlsFmDt) {
		this.sSlsFmDt = sSlsFmDt;
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
	 * @param cSlsToDt
	 */
	public void setCSlsToDt(String cSlsToDt) {
		this.cSlsToDt = cSlsToDt;
	}
	
	/**
	 * Column Info
	 * @param rSlsToDt
	 */
	public void setRSlsToDt(String rSlsToDt) {
		this.rSlsToDt = rSlsToDt;
	}
	
	/**
	 * Column Info
	 * @param rSlsFmDt
	 */
	public void setRSlsFmDt(String rSlsFmDt) {
		this.rSlsFmDt = rSlsFmDt;
	}
	
	/**
	 * Column Info
	 * @param sSlsToDt
	 */
	public void setSSlsToDt(String sSlsToDt) {
		this.sSlsToDt = sSlsToDt;
	}
	
	/**
	 * Column Info
	 * @param cSlsFmDt
	 */
	public void setCSlsFmDt(String cSlsFmDt) {
		this.cSlsFmDt = cSlsFmDt;
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
		setRToYrwk(JSPUtil.getParameter(request, prefix + "r_to_yrwk", ""));
		setRFmYrwk(JSPUtil.getParameter(request, prefix + "r_fm_yrwk", ""));
		setSSlsFmDt(JSPUtil.getParameter(request, prefix + "s_sls_fm_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCSlsToDt(JSPUtil.getParameter(request, prefix + "c_sls_to_dt", ""));
		setRSlsToDt(JSPUtil.getParameter(request, prefix + "r_sls_to_dt", ""));
		setRSlsFmDt(JSPUtil.getParameter(request, prefix + "r_sls_fm_dt", ""));
		setSSlsToDt(JSPUtil.getParameter(request, prefix + "s_sls_to_dt", ""));
		setCSlsFmDt(JSPUtil.getParameter(request, prefix + "c_sls_fm_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPrsAmendmentCmSummarySimulationDateParamVO[]
	 */
	public RsltPrsAmendmentCmSummarySimulationDateParamVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPrsAmendmentCmSummarySimulationDateParamVO[]
	 */
	public RsltPrsAmendmentCmSummarySimulationDateParamVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPrsAmendmentCmSummarySimulationDateParamVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rToYrwk = (JSPUtil.getParameter(request, prefix	+ "r_to_yrwk", length));
			String[] rFmYrwk = (JSPUtil.getParameter(request, prefix	+ "r_fm_yrwk", length));
			String[] sSlsFmDt = (JSPUtil.getParameter(request, prefix	+ "s_sls_fm_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cSlsToDt = (JSPUtil.getParameter(request, prefix	+ "c_sls_to_dt", length));
			String[] rSlsToDt = (JSPUtil.getParameter(request, prefix	+ "r_sls_to_dt", length));
			String[] rSlsFmDt = (JSPUtil.getParameter(request, prefix	+ "r_sls_fm_dt", length));
			String[] sSlsToDt = (JSPUtil.getParameter(request, prefix	+ "s_sls_to_dt", length));
			String[] cSlsFmDt = (JSPUtil.getParameter(request, prefix	+ "c_sls_fm_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPrsAmendmentCmSummarySimulationDateParamVO();
				if (rToYrwk[i] != null)
					model.setRToYrwk(rToYrwk[i]);
				if (rFmYrwk[i] != null)
					model.setRFmYrwk(rFmYrwk[i]);
				if (sSlsFmDt[i] != null)
					model.setSSlsFmDt(sSlsFmDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cSlsToDt[i] != null)
					model.setCSlsToDt(cSlsToDt[i]);
				if (rSlsToDt[i] != null)
					model.setRSlsToDt(rSlsToDt[i]);
				if (rSlsFmDt[i] != null)
					model.setRSlsFmDt(rSlsFmDt[i]);
				if (sSlsToDt[i] != null)
					model.setSSlsToDt(sSlsToDt[i]);
				if (cSlsFmDt[i] != null)
					model.setCSlsFmDt(cSlsFmDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPrsAmendmentCmSummarySimulationDateParamVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPrsAmendmentCmSummarySimulationDateParamVO[]
	 */
	public RsltPrsAmendmentCmSummarySimulationDateParamVO[] getRsltPrsAmendmentCmSummarySimulationDateParamVOs(){
		RsltPrsAmendmentCmSummarySimulationDateParamVO[] vos = (RsltPrsAmendmentCmSummarySimulationDateParamVO[])models.toArray(new RsltPrsAmendmentCmSummarySimulationDateParamVO[models.size()]);
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
		this.rToYrwk = this.rToYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rFmYrwk = this.rFmYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSlsFmDt = this.sSlsFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cSlsToDt = this.cSlsToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rSlsToDt = this.rSlsToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rSlsFmDt = this.rSlsFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSlsToDt = this.sSlsToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cSlsFmDt = this.cSlsFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
