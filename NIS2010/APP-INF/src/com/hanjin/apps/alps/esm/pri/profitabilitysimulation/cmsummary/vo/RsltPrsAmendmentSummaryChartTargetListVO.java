/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltPrsAmendmentSummaryChartTargetListVO.java
*@FileTitle : RsltPrsAmendmentSummaryChartTargetListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.10.16 송민석 
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

public class RsltPrsAmendmentSummaryChartTargetListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPrsAmendmentSummaryChartTargetListVO> models = new ArrayList<RsltPrsAmendmentSummaryChartTargetListVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String codeTpCd = null;
	/* Column Info */
	private String targetCode = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPrsAmendmentSummaryChartTargetListVO() {}

	public RsltPrsAmendmentSummaryChartTargetListVO(String ibflag, String pagerows, String targetCode, String codeTpCd) {
		this.ibflag = ibflag;
		this.codeTpCd = codeTpCd;
		this.targetCode = targetCode;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("code_tp_cd", getCodeTpCd());
		this.hashColumns.put("target_code", getTargetCode());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("code_tp_cd", "codeTpCd");
		this.hashFields.put("target_code", "targetCode");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return codeTpCd
	 */
	public String getCodeTpCd() {
		return this.codeTpCd;
	}
	
	/**
	 * Column Info
	 * @return targetCode
	 */
	public String getTargetCode() {
		return this.targetCode;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @param codeTpCd
	 */
	public void setCodeTpCd(String codeTpCd) {
		this.codeTpCd = codeTpCd;
	}
	
	/**
	 * Column Info
	 * @param targetCode
	 */
	public void setTargetCode(String targetCode) {
		this.targetCode = targetCode;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCodeTpCd(JSPUtil.getParameter(request, "code_tp_cd", ""));
		setTargetCode(JSPUtil.getParameter(request, "target_code", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPrsAmendmentSummaryChartTargetListVO[]
	 */
	public RsltPrsAmendmentSummaryChartTargetListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPrsAmendmentSummaryChartTargetListVO[]
	 */
	public RsltPrsAmendmentSummaryChartTargetListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPrsAmendmentSummaryChartTargetListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] codeTpCd = (JSPUtil.getParameter(request, prefix	+ "code_tp_cd", length));
			String[] targetCode = (JSPUtil.getParameter(request, prefix	+ "target_code", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPrsAmendmentSummaryChartTargetListVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (codeTpCd[i] != null)
					model.setCodeTpCd(codeTpCd[i]);
				if (targetCode[i] != null)
					model.setTargetCode(targetCode[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPrsAmendmentSummaryChartTargetListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPrsAmendmentSummaryChartTargetListVO[]
	 */
	public RsltPrsAmendmentSummaryChartTargetListVO[] getRsltPrsAmendmentSummaryChartTargetListVOs(){
		RsltPrsAmendmentSummaryChartTargetListVO[] vos = (RsltPrsAmendmentSummaryChartTargetListVO[])models.toArray(new RsltPrsAmendmentSummaryChartTargetListVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codeTpCd = this.codeTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.targetCode = this.targetCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
