/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchCallSceEstDueVO.java
*@FileTitle : SearchCallSceEstDueVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.26
*@LastModifier : 이중환
*@LastVersion : 1.0
* 2009.11.26 이중환 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.visibilitymanage.edi214Receive.vo;

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
 * @author 이중환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchCallSceEstDueVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchCallSceEstDueVO> models = new ArrayList<SearchCallSceEstDueVO>();
	
	/* Column Info */
	private String actRcvNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String actRcvDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchCallSceEstDueVO() {}

	public SearchCallSceEstDueVO(String ibflag, String pagerows, String actRcvDt, String actRcvNo) {
		this.actRcvNo = actRcvNo;
		this.ibflag = ibflag;
		this.actRcvDt = actRcvDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("act_rcv_no", getActRcvNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("act_rcv_dt", getActRcvDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("act_rcv_no", "actRcvNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("act_rcv_dt", "actRcvDt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return actRcvNo
	 */
	public String getActRcvNo() {
		return this.actRcvNo;
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
	 * @return actRcvDt
	 */
	public String getActRcvDt() {
		return this.actRcvDt;
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
	 * @param actRcvNo
	 */
	public void setActRcvNo(String actRcvNo) {
		this.actRcvNo = actRcvNo;
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
	 * @param actRcvDt
	 */
	public void setActRcvDt(String actRcvDt) {
		this.actRcvDt = actRcvDt;
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
		setActRcvNo(JSPUtil.getParameter(request, "act_rcv_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setActRcvDt(JSPUtil.getParameter(request, "act_rcv_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCallSceEstDueVO[]
	 */
	public SearchCallSceEstDueVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCallSceEstDueVO[]
	 */
	public SearchCallSceEstDueVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchCallSceEstDueVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] actRcvNo = (JSPUtil.getParameter(request, prefix	+ "act_rcv_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] actRcvDt = (JSPUtil.getParameter(request, prefix	+ "act_rcv_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchCallSceEstDueVO();
				if (actRcvNo[i] != null)
					model.setActRcvNo(actRcvNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (actRcvDt[i] != null)
					model.setActRcvDt(actRcvDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchCallSceEstDueVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchCallSceEstDueVO[]
	 */
	public SearchCallSceEstDueVO[] getSearchCallSceEstDueVOs(){
		SearchCallSceEstDueVO[] vos = (SearchCallSceEstDueVO[])models.toArray(new SearchCallSceEstDueVO[models.size()]);
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
		this.actRcvNo = this.actRcvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actRcvDt = this.actRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
