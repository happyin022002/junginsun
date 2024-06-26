/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CHGCommAmtVO.java
*@FileTitle : CHGCommAmtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.24
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.24  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CHGCommAmtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CHGCommAmtVO> models = new ArrayList<CHGCommAmtVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String usdChgComm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String payChgComm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CHGCommAmtVO() {}

	public CHGCommAmtVO(String ibflag, String pagerows, String usdChgComm, String payChgComm) {
		this.pagerows = pagerows;
		this.usdChgComm = usdChgComm;
		this.ibflag = ibflag;
		this.payChgComm = payChgComm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("usd_chg_comm", getUsdChgComm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pay_chg_comm", getPayChgComm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("usd_chg_comm", "usdChgComm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pay_chg_comm", "payChgComm");
		return this.hashFields;
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
	 * @return usdChgComm
	 */
	public String getUsdChgComm() {
		return this.usdChgComm;
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
	 * @return payChgComm
	 */
	public String getPayChgComm() {
		return this.payChgComm;
	}
	

	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param usdChgComm
	 */
	public void setUsdChgComm(String usdChgComm) {
		this.usdChgComm = usdChgComm;
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
	 * @param payChgComm
	 */
	public void setPayChgComm(String payChgComm) {
		this.payChgComm = payChgComm;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setUsdChgComm(JSPUtil.getParameter(request, prefix + "usd_chg_comm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPayChgComm(JSPUtil.getParameter(request, prefix + "pay_chg_comm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CHGCommAmtVO[]
	 */
	public CHGCommAmtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CHGCommAmtVO[]
	 */
	public CHGCommAmtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CHGCommAmtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] usdChgComm = (JSPUtil.getParameter(request, prefix	+ "usd_chg_comm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] payChgComm = (JSPUtil.getParameter(request, prefix	+ "pay_chg_comm", length));
			
			for (int i = 0; i < length; i++) {
				model = new CHGCommAmtVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (usdChgComm[i] != null)
					model.setUsdChgComm(usdChgComm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (payChgComm[i] != null)
					model.setPayChgComm(payChgComm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCHGCommAmtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CHGCommAmtVO[]
	 */
	public CHGCommAmtVO[] getCHGCommAmtVOs(){
		CHGCommAmtVO[] vos = (CHGCommAmtVO[])models.toArray(new CHGCommAmtVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdChgComm = this.usdChgComm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payChgComm = this.payChgComm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
