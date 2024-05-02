/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GetEvntDtVO.java
*@FileTitle : GetEvntDtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.06
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.04.06 이윤정 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.edi315send.vo;

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
 * @author 이윤정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class GetEvntDtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GetEvntDtVO> models = new ArrayList<GetEvntDtVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String gmtEstmDt = null;
	/* Column Info */
	private String actDt = null;
	/* Column Info */
	private String gmtActDt = null;
	/* Column Info */
	private String estmDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public GetEvntDtVO() {}

	public GetEvntDtVO(String ibflag, String pagerows, String estmDt, String actDt, String gmtEstmDt, String gmtActDt) {
		this.ibflag = ibflag;
		this.gmtEstmDt = gmtEstmDt;
		this.actDt = actDt;
		this.gmtActDt = gmtActDt;
		this.estmDt = estmDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("gmt_estm_dt", getGmtEstmDt());
		this.hashColumns.put("act_dt", getActDt());
		this.hashColumns.put("gmt_act_dt", getGmtActDt());
		this.hashColumns.put("estm_dt", getEstmDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("gmt_estm_dt", "gmtEstmDt");
		this.hashFields.put("act_dt", "actDt");
		this.hashFields.put("gmt_act_dt", "gmtActDt");
		this.hashFields.put("estm_dt", "estmDt");
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
	 * @return gmtEstmDt
	 */
	public String getGmtEstmDt() {
		return this.gmtEstmDt;
	}
	
	/**
	 * Column Info
	 * @return actDt
	 */
	public String getActDt() {
		return this.actDt;
	}
	
	/**
	 * Column Info
	 * @return gmtActDt
	 */
	public String getGmtActDt() {
		return this.gmtActDt;
	}
	
	/**
	 * Column Info
	 * @return estmDt
	 */
	public String getEstmDt() {
		return this.estmDt;
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
	 * @param gmtEstmDt
	 */
	public void setGmtEstmDt(String gmtEstmDt) {
		this.gmtEstmDt = gmtEstmDt;
	}
	
	/**
	 * Column Info
	 * @param actDt
	 */
	public void setActDt(String actDt) {
		this.actDt = actDt;
	}
	
	/**
	 * Column Info
	 * @param gmtActDt
	 */
	public void setGmtActDt(String gmtActDt) {
		this.gmtActDt = gmtActDt;
	}
	
	/**
	 * Column Info
	 * @param estmDt
	 */
	public void setEstmDt(String estmDt) {
		this.estmDt = estmDt;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setGmtEstmDt(JSPUtil.getParameter(request, prefix + "gmt_estm_dt", ""));
		setActDt(JSPUtil.getParameter(request, prefix + "act_dt", ""));
		setGmtActDt(JSPUtil.getParameter(request, prefix + "gmt_act_dt", ""));
		setEstmDt(JSPUtil.getParameter(request, prefix + "estm_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GetEvntDtVO[]
	 */
	public GetEvntDtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GetEvntDtVO[]
	 */
	public GetEvntDtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GetEvntDtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] gmtEstmDt = (JSPUtil.getParameter(request, prefix	+ "gmt_estm_dt", length));
			String[] actDt = (JSPUtil.getParameter(request, prefix	+ "act_dt", length));
			String[] gmtActDt = (JSPUtil.getParameter(request, prefix	+ "gmt_act_dt", length));
			String[] estmDt = (JSPUtil.getParameter(request, prefix	+ "estm_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new GetEvntDtVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (gmtEstmDt[i] != null)
					model.setGmtEstmDt(gmtEstmDt[i]);
				if (actDt[i] != null)
					model.setActDt(actDt[i]);
				if (gmtActDt[i] != null)
					model.setGmtActDt(gmtActDt[i]);
				if (estmDt[i] != null)
					model.setEstmDt(estmDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGetEvntDtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GetEvntDtVO[]
	 */
	public GetEvntDtVO[] getGetEvntDtVOs(){
		GetEvntDtVO[] vos = (GetEvntDtVO[])models.toArray(new GetEvntDtVO[models.size()]);
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
		this.gmtEstmDt = this.gmtEstmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDt = this.actDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gmtActDt = this.gmtActDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmDt = this.estmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
