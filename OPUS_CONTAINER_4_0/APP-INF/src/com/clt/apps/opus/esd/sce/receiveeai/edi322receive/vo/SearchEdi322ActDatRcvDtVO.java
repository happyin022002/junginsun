/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchEdi322ActDatRcvDtVO.java
*@FileTitle : SearchEdi322ActDatRcvDtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.20
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.20  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.receiveeai.edi322receive.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchEdi322ActDatRcvDtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchEdi322ActDatRcvDtVO> models = new ArrayList<SearchEdi322ActDatRcvDtVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eventYard = null;
	/* Column Info */
	private String actDatRcvDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchEdi322ActDatRcvDtVO() {}

	public SearchEdi322ActDatRcvDtVO(String ibflag, String pagerows, String actDatRcvDt, String eventYard) {
		this.ibflag = ibflag;
		this.eventYard = eventYard;
		this.actDatRcvDt = actDatRcvDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("event_yard", getEventYard());
		this.hashColumns.put("act_dat_rcv_dt", getActDatRcvDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("event_yard", "eventYard");
		this.hashFields.put("act_dat_rcv_dt", "actDatRcvDt");
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
	 * @return eventYard
	 */
	public String getEventYard() {
		return this.eventYard;
	}
	
	/**
	 * Column Info
	 * @return actDatRcvDt
	 */
	public String getActDatRcvDt() {
		return this.actDatRcvDt;
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
	 * @param eventYard
	 */
	public void setEventYard(String eventYard) {
		this.eventYard = eventYard;
	}
	
	/**
	 * Column Info
	 * @param actDatRcvDt
	 */
	public void setActDatRcvDt(String actDatRcvDt) {
		this.actDatRcvDt = actDatRcvDt;
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
		setEventYard(JSPUtil.getParameter(request, "event_yard", ""));
		setActDatRcvDt(JSPUtil.getParameter(request, "act_dat_rcv_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchEdi322ActDatRcvDtVO[]
	 */
	public SearchEdi322ActDatRcvDtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchEdi322ActDatRcvDtVO[]
	 */
	public SearchEdi322ActDatRcvDtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchEdi322ActDatRcvDtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eventYard = (JSPUtil.getParameter(request, prefix	+ "event_yard", length));
			String[] actDatRcvDt = (JSPUtil.getParameter(request, prefix	+ "act_dat_rcv_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchEdi322ActDatRcvDtVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eventYard[i] != null)
					model.setEventYard(eventYard[i]);
				if (actDatRcvDt[i] != null)
					model.setActDatRcvDt(actDatRcvDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchEdi322ActDatRcvDtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchEdi322ActDatRcvDtVO[]
	 */
	public SearchEdi322ActDatRcvDtVO[] getSearchEdi322ActDatRcvDtVOs(){
		SearchEdi322ActDatRcvDtVO[] vos = (SearchEdi322ActDatRcvDtVO[])models.toArray(new SearchEdi322ActDatRcvDtVO[models.size()]);
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
		this.eventYard = this.eventYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDatRcvDt = this.actDatRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
