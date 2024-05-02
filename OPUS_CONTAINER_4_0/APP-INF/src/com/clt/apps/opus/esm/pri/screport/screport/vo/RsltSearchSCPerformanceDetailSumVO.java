/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RsltSearchSCPerformanceDetailSumVO.java
*@FileTitle : RsltSearchSCPerformanceDetailSumVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.26
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2010.01.26 김대호 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.screport.screport.vo;

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
 * @author 김대호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltSearchSCPerformanceDetailSumVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltSearchSCPerformanceDetailSumVO> models = new ArrayList<RsltSearchSCPerformanceDetailSumVO>();
	
	/* Column Info */
	private String blObrdDtFrom = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String proRtMqcPerf = null;
	/* Column Info */
	private String fnlMqcQty = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String opCntrQty = null;
	/* Column Info */
	private String mqcPerf = null;
	/* Column Info */
	private String blObrdDtTo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltSearchSCPerformanceDetailSumVO() {}

	public RsltSearchSCPerformanceDetailSumVO(String ibflag, String pagerows, String fnlMqcQty, String opCntrQty, String mqcPerf, String proRtMqcPerf, String scNo, String blObrdDtFrom, String blObrdDtTo) {
		this.blObrdDtFrom = blObrdDtFrom;
		this.ibflag = ibflag;
		this.proRtMqcPerf = proRtMqcPerf;
		this.fnlMqcQty = fnlMqcQty;
		this.scNo = scNo;
		this.opCntrQty = opCntrQty;
		this.mqcPerf = mqcPerf;
		this.blObrdDtTo = blObrdDtTo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bl_obrd_dt_from", getBlObrdDtFrom());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pro_rt_mqc_perf", getProRtMqcPerf());
		this.hashColumns.put("fnl_mqc_qty", getFnlMqcQty());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("op_cntr_qty", getOpCntrQty());
		this.hashColumns.put("mqc_perf", getMqcPerf());
		this.hashColumns.put("bl_obrd_dt_to", getBlObrdDtTo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bl_obrd_dt_from", "blObrdDtFrom");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pro_rt_mqc_perf", "proRtMqcPerf");
		this.hashFields.put("fnl_mqc_qty", "fnlMqcQty");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("op_cntr_qty", "opCntrQty");
		this.hashFields.put("mqc_perf", "mqcPerf");
		this.hashFields.put("bl_obrd_dt_to", "blObrdDtTo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return blObrdDtFrom
	 */
	public String getBlObrdDtFrom() {
		return this.blObrdDtFrom;
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
	 * @return proRtMqcPerf
	 */
	public String getProRtMqcPerf() {
		return this.proRtMqcPerf;
	}
	
	/**
	 * Column Info
	 * @return fnlMqcQty
	 */
	public String getFnlMqcQty() {
		return this.fnlMqcQty;
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
	 * @return opCntrQty
	 */
	public String getOpCntrQty() {
		return this.opCntrQty;
	}
	
	/**
	 * Column Info
	 * @return mqcPerf
	 */
	public String getMqcPerf() {
		return this.mqcPerf;
	}
	
	/**
	 * Column Info
	 * @return blObrdDtTo
	 */
	public String getBlObrdDtTo() {
		return this.blObrdDtTo;
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
	 * @param blObrdDtFrom
	 */
	public void setBlObrdDtFrom(String blObrdDtFrom) {
		this.blObrdDtFrom = blObrdDtFrom;
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
	 * @param proRtMqcPerf
	 */
	public void setProRtMqcPerf(String proRtMqcPerf) {
		this.proRtMqcPerf = proRtMqcPerf;
	}
	
	/**
	 * Column Info
	 * @param fnlMqcQty
	 */
	public void setFnlMqcQty(String fnlMqcQty) {
		this.fnlMqcQty = fnlMqcQty;
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
	 * @param opCntrQty
	 */
	public void setOpCntrQty(String opCntrQty) {
		this.opCntrQty = opCntrQty;
	}
	
	/**
	 * Column Info
	 * @param mqcPerf
	 */
	public void setMqcPerf(String mqcPerf) {
		this.mqcPerf = mqcPerf;
	}
	
	/**
	 * Column Info
	 * @param blObrdDtTo
	 */
	public void setBlObrdDtTo(String blObrdDtTo) {
		this.blObrdDtTo = blObrdDtTo;
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
		setBlObrdDtFrom(JSPUtil.getParameter(request, prefix + "bl_obrd_dt_from", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setProRtMqcPerf(JSPUtil.getParameter(request, prefix + "pro_rt_mqc_perf", ""));
		setFnlMqcQty(JSPUtil.getParameter(request, prefix + "fnl_mqc_qty", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setOpCntrQty(JSPUtil.getParameter(request, prefix + "op_cntr_qty", ""));
		setMqcPerf(JSPUtil.getParameter(request, prefix + "mqc_perf", ""));
		setBlObrdDtTo(JSPUtil.getParameter(request, prefix + "bl_obrd_dt_to", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltSearchSCPerformanceDetailSumVO[]
	 */
	public RsltSearchSCPerformanceDetailSumVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltSearchSCPerformanceDetailSumVO[]
	 */
	public RsltSearchSCPerformanceDetailSumVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltSearchSCPerformanceDetailSumVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] blObrdDtFrom = (JSPUtil.getParameter(request, prefix	+ "bl_obrd_dt_from", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] proRtMqcPerf = (JSPUtil.getParameter(request, prefix	+ "pro_rt_mqc_perf", length));
			String[] fnlMqcQty = (JSPUtil.getParameter(request, prefix	+ "fnl_mqc_qty", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] opCntrQty = (JSPUtil.getParameter(request, prefix	+ "op_cntr_qty", length));
			String[] mqcPerf = (JSPUtil.getParameter(request, prefix	+ "mqc_perf", length));
			String[] blObrdDtTo = (JSPUtil.getParameter(request, prefix	+ "bl_obrd_dt_to", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltSearchSCPerformanceDetailSumVO();
				if (blObrdDtFrom[i] != null)
					model.setBlObrdDtFrom(blObrdDtFrom[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (proRtMqcPerf[i] != null)
					model.setProRtMqcPerf(proRtMqcPerf[i]);
				if (fnlMqcQty[i] != null)
					model.setFnlMqcQty(fnlMqcQty[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (opCntrQty[i] != null)
					model.setOpCntrQty(opCntrQty[i]);
				if (mqcPerf[i] != null)
					model.setMqcPerf(mqcPerf[i]);
				if (blObrdDtTo[i] != null)
					model.setBlObrdDtTo(blObrdDtTo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltSearchSCPerformanceDetailSumVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltSearchSCPerformanceDetailSumVO[]
	 */
	public RsltSearchSCPerformanceDetailSumVO[] getRsltSearchSCPerformanceDetailSumVOs(){
		RsltSearchSCPerformanceDetailSumVO[] vos = (RsltSearchSCPerformanceDetailSumVO[])models.toArray(new RsltSearchSCPerformanceDetailSumVO[models.size()]);
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
		this.blObrdDtFrom = this.blObrdDtFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.proRtMqcPerf = this.proRtMqcPerf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlMqcQty = this.fnlMqcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCntrQty = this.opCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mqcPerf = this.mqcPerf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blObrdDtTo = this.blObrdDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
