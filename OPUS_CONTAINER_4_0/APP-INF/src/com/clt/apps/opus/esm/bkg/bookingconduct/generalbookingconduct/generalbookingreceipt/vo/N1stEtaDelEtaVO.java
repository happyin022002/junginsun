/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : N1stEtaDelEtaVO.java
*@FileTitle : N1stEtaDelEtaVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.22
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2009.12.22 류대영 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo;

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
 * @author 류대영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class N1stEtaDelEtaVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<N1stEtaDelEtaVO> models = new ArrayList<N1stEtaDelEtaVO>();
	
	/* Column Info */
	private String n1stEtaDay = null;
	/* Column Info */
	private String n1stEtaTime = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String delEtaDay = null;
	/* Column Info */
	private String n1stEta = null;
	/* Column Info */
	private String delEtaTime = null;
	/* Column Info */
	private String delEta = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public N1stEtaDelEtaVO() {}

	public N1stEtaDelEtaVO(String ibflag, String pagerows, String n1stEta, String n1stEtaDay, String n1stEtaTime, String delEta, String delEtaDay, String delEtaTime) {
		this.n1stEtaDay = n1stEtaDay;
		this.n1stEtaTime = n1stEtaTime;
		this.ibflag = ibflag;
		this.delEtaDay = delEtaDay;
		this.n1stEta = n1stEta;
		this.delEtaTime = delEtaTime;
		this.delEta = delEta;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("n1st_eta_day", getN1stEtaDay());
		this.hashColumns.put("n1st_eta_time", getN1stEtaTime());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("del_eta_day", getDelEtaDay());
		this.hashColumns.put("n1st_eta", getN1stEta());
		this.hashColumns.put("del_eta_time", getDelEtaTime());
		this.hashColumns.put("del_eta", getDelEta());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("n1st_eta_day", "n1stEtaDay");
		this.hashFields.put("n1st_eta_time", "n1stEtaTime");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("del_eta_day", "delEtaDay");
		this.hashFields.put("n1st_eta", "n1stEta");
		this.hashFields.put("del_eta_time", "delEtaTime");
		this.hashFields.put("del_eta", "delEta");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return n1stEtaDay
	 */
	public String getN1stEtaDay() {
		return this.n1stEtaDay;
	}
	
	/**
	 * Column Info
	 * @return n1stEtaTime
	 */
	public String getN1stEtaTime() {
		return this.n1stEtaTime;
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
	 * @return delEtaDay
	 */
	public String getDelEtaDay() {
		return this.delEtaDay;
	}
	
	/**
	 * Column Info
	 * @return n1stEta
	 */
	public String getN1stEta() {
		return this.n1stEta;
	}
	
	/**
	 * Column Info
	 * @return delEtaTime
	 */
	public String getDelEtaTime() {
		return this.delEtaTime;
	}
	
	/**
	 * Column Info
	 * @return delEta
	 */
	public String getDelEta() {
		return this.delEta;
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
	 * @param n1stEtaDay
	 */
	public void setN1stEtaDay(String n1stEtaDay) {
		this.n1stEtaDay = n1stEtaDay;
	}
	
	/**
	 * Column Info
	 * @param n1stEtaTime
	 */
	public void setN1stEtaTime(String n1stEtaTime) {
		this.n1stEtaTime = n1stEtaTime;
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
	 * @param delEtaDay
	 */
	public void setDelEtaDay(String delEtaDay) {
		this.delEtaDay = delEtaDay;
	}
	
	/**
	 * Column Info
	 * @param n1stEta
	 */
	public void setN1stEta(String n1stEta) {
		this.n1stEta = n1stEta;
	}
	
	/**
	 * Column Info
	 * @param delEtaTime
	 */
	public void setDelEtaTime(String delEtaTime) {
		this.delEtaTime = delEtaTime;
	}
	
	/**
	 * Column Info
	 * @param delEta
	 */
	public void setDelEta(String delEta) {
		this.delEta = delEta;
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
		setN1stEtaDay(JSPUtil.getParameter(request, "n1st_eta_day", ""));
		setN1stEtaTime(JSPUtil.getParameter(request, "n1st_eta_time", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDelEtaDay(JSPUtil.getParameter(request, "del_eta_day", ""));
		setN1stEta(JSPUtil.getParameter(request, "n1st_eta", ""));
		setDelEtaTime(JSPUtil.getParameter(request, "del_eta_time", ""));
		setDelEta(JSPUtil.getParameter(request, "del_eta", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return N1stEtaDelEtaVO[]
	 */
	public N1stEtaDelEtaVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return N1stEtaDelEtaVO[]
	 */
	public N1stEtaDelEtaVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		N1stEtaDelEtaVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] n1stEtaDay = (JSPUtil.getParameter(request, prefix	+ "n1st_eta_day", length));
			String[] n1stEtaTime = (JSPUtil.getParameter(request, prefix	+ "n1st_eta_time", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] delEtaDay = (JSPUtil.getParameter(request, prefix	+ "del_eta_day", length));
			String[] n1stEta = (JSPUtil.getParameter(request, prefix	+ "n1st_eta", length));
			String[] delEtaTime = (JSPUtil.getParameter(request, prefix	+ "del_eta_time", length));
			String[] delEta = (JSPUtil.getParameter(request, prefix	+ "del_eta", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new N1stEtaDelEtaVO();
				if (n1stEtaDay[i] != null)
					model.setN1stEtaDay(n1stEtaDay[i]);
				if (n1stEtaTime[i] != null)
					model.setN1stEtaTime(n1stEtaTime[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (delEtaDay[i] != null)
					model.setDelEtaDay(delEtaDay[i]);
				if (n1stEta[i] != null)
					model.setN1stEta(n1stEta[i]);
				if (delEtaTime[i] != null)
					model.setDelEtaTime(delEtaTime[i]);
				if (delEta[i] != null)
					model.setDelEta(delEta[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getN1stEtaDelEtaVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return N1stEtaDelEtaVO[]
	 */
	public N1stEtaDelEtaVO[] getN1stEtaDelEtaVOs(){
		N1stEtaDelEtaVO[] vos = (N1stEtaDelEtaVO[])models.toArray(new N1stEtaDelEtaVO[models.size()]);
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
		this.n1stEtaDay = this.n1stEtaDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stEtaTime = this.n1stEtaTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delEtaDay = this.delEtaDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stEta = this.n1stEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delEtaTime = this.delEtaTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delEta = this.delEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
