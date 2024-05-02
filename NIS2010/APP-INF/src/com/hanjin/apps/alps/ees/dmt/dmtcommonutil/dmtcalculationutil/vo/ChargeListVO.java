/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeListVO.java
*@FileTitle : ChargeListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.16
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.11.16 최성환 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo;

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
 * @author 최성환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ChargeListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ChargeListVO> models = new ArrayList<ChargeListVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ftUndDys = null;
	/* Column Info */
	private String rtAmt = null;
	/* Column Info */
	private String ftOvrDys = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ChargeListVO() {}

	public ChargeListVO(String ibflag, String pagerows, String ftOvrDys, String ftUndDys, String rtAmt) {
		this.ibflag = ibflag;
		this.ftUndDys = ftUndDys;
		this.rtAmt = rtAmt;
		this.ftOvrDys = ftOvrDys;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ft_und_dys", getFtUndDys());
		this.hashColumns.put("rt_amt", getRtAmt());
		this.hashColumns.put("ft_ovr_dys", getFtOvrDys());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ft_und_dys", "ftUndDys");
		this.hashFields.put("rt_amt", "rtAmt");
		this.hashFields.put("ft_ovr_dys", "ftOvrDys");
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
	 * @return ftUndDys
	 */
	public String getFtUndDys() {
		return this.ftUndDys;
	}
	
	/**
	 * Column Info
	 * @return rtAmt
	 */
	public String getRtAmt() {
		return this.rtAmt;
	}
	
	/**
	 * Column Info
	 * @return ftOvrDys
	 */
	public String getFtOvrDys() {
		return this.ftOvrDys;
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
	 * @param ftUndDys
	 */
	public void setFtUndDys(String ftUndDys) {
		this.ftUndDys = ftUndDys;
	}
	
	/**
	 * Column Info
	 * @param rtAmt
	 */
	public void setRtAmt(String rtAmt) {
		this.rtAmt = rtAmt;
	}
	
	/**
	 * Column Info
	 * @param ftOvrDys
	 */
	public void setFtOvrDys(String ftOvrDys) {
		this.ftOvrDys = ftOvrDys;
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
		setFtUndDys(JSPUtil.getParameter(request, "ft_und_dys", ""));
		setRtAmt(JSPUtil.getParameter(request, "rt_amt", ""));
		setFtOvrDys(JSPUtil.getParameter(request, "ft_ovr_dys", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChargeListVO[]
	 */
	public ChargeListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ChargeListVO[]
	 */
	public ChargeListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChargeListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ftUndDys = (JSPUtil.getParameter(request, prefix	+ "ft_und_dys", length));
			String[] rtAmt = (JSPUtil.getParameter(request, prefix	+ "rt_amt", length));
			String[] ftOvrDys = (JSPUtil.getParameter(request, prefix	+ "ft_ovr_dys", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ChargeListVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ftUndDys[i] != null)
					model.setFtUndDys(ftUndDys[i]);
				if (rtAmt[i] != null)
					model.setRtAmt(rtAmt[i]);
				if (ftOvrDys[i] != null)
					model.setFtOvrDys(ftOvrDys[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChargeListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChargeListVO[]
	 */
	public ChargeListVO[] getChargeListVOs(){
		ChargeListVO[] vos = (ChargeListVO[])models.toArray(new ChargeListVO[models.size()]);
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
		this.ftUndDys = this.ftUndDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAmt = this.rtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftOvrDys = this.ftOvrDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
