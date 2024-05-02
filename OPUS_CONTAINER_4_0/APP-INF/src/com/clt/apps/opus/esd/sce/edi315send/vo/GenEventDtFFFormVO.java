/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GenEventDtFFFormVO.java
*@FileTitle : GenEventDtFFFormVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.18
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2009.11.18 이윤정 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.edi315send.vo;

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
 * @author 이윤정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class GenEventDtFFFormVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GenEventDtFFFormVO> models = new ArrayList<GenEventDtFFFormVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ffEventDt = null;
	/* Column Info */
	private String ffEventDtGmt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public GenEventDtFFFormVO() {}

	public GenEventDtFFFormVO(String ibflag, String pagerows, String ffEventDtGmt, String ffEventDt) {
		this.ibflag = ibflag;
		this.ffEventDt = ffEventDt;
		this.ffEventDtGmt = ffEventDtGmt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ff_event_dt", getFfEventDt());
		this.hashColumns.put("ff_event_dt_gmt", getFfEventDtGmt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ff_event_dt", "ffEventDt");
		this.hashFields.put("ff_event_dt_gmt", "ffEventDtGmt");
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
	 * @return ffEventDt
	 */
	public String getFfEventDt() {
		return this.ffEventDt;
	}
	
	/**
	 * Column Info
	 * @return ffEventDtGmt
	 */
	public String getFfEventDtGmt() {
		return this.ffEventDtGmt;
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
	 * @param ffEventDt
	 */
	public void setFfEventDt(String ffEventDt) {
		this.ffEventDt = ffEventDt;
	}
	
	/**
	 * Column Info
	 * @param ffEventDtGmt
	 */
	public void setFfEventDtGmt(String ffEventDtGmt) {
		this.ffEventDtGmt = ffEventDtGmt;
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
		setFfEventDt(JSPUtil.getParameter(request, "ff_event_dt", ""));
		setFfEventDtGmt(JSPUtil.getParameter(request, "ff_event_dt_gmt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GenEventDtFFFormVO[]
	 */
	public GenEventDtFFFormVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GenEventDtFFFormVO[]
	 */
	public GenEventDtFFFormVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GenEventDtFFFormVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ffEventDt = (JSPUtil.getParameter(request, prefix	+ "ff_event_dt", length));
			String[] ffEventDtGmt = (JSPUtil.getParameter(request, prefix	+ "ff_event_dt_gmt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new GenEventDtFFFormVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ffEventDt[i] != null)
					model.setFfEventDt(ffEventDt[i]);
				if (ffEventDtGmt[i] != null)
					model.setFfEventDtGmt(ffEventDtGmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGenEventDtFFFormVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GenEventDtFFFormVO[]
	 */
	public GenEventDtFFFormVO[] getGenEventDtFFFormVOs(){
		GenEventDtFFFormVO[] vos = (GenEventDtFFFormVO[])models.toArray(new GenEventDtFFFormVO[models.size()]);
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
		this.ffEventDt = this.ffEventDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffEventDtGmt = this.ffEventDtGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}