/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VIEDailyExrateReturnVO.java
*@FileTitle : VIEDailyExrateReturnVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.10.28 최우석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo;

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
 * @author 최우석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VIEDailyExrateReturnVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VIEDailyExrateReturnVO> models = new ArrayList<VIEDailyExrateReturnVO>();
	
	/* Column Info */
	private String xchDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String xchRt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VIEDailyExrateReturnVO() {}

	public VIEDailyExrateReturnVO(String ibflag, String pagerows, String xchRt, String xchDt) {
		this.xchDt = xchDt;
		this.ibflag = ibflag;
		this.xchRt = xchRt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("xch_dt", getXchDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("xch_rt", getXchRt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("xch_dt", "xchDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("xch_rt", "xchRt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return xchDt
	 */
	public String getXchDt() {
		return this.xchDt;
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
	 * @return xchRt
	 */
	public String getXchRt() {
		return this.xchRt;
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
	 * @param xchDt
	 */
	public void setXchDt(String xchDt) {
		this.xchDt = xchDt;
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
	 * @param xchRt
	 */
	public void setXchRt(String xchRt) {
		this.xchRt = xchRt;
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
		setXchDt(JSPUtil.getParameter(request, "xch_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setXchRt(JSPUtil.getParameter(request, "xch_rt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VIEDailyExrateReturnVO[]
	 */
	public VIEDailyExrateReturnVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VIEDailyExrateReturnVO[]
	 */
	public VIEDailyExrateReturnVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VIEDailyExrateReturnVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] xchDt = (JSPUtil.getParameter(request, prefix	+ "xch_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] xchRt = (JSPUtil.getParameter(request, prefix	+ "xch_rt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new VIEDailyExrateReturnVO();
				if (xchDt[i] != null)
					model.setXchDt(xchDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (xchRt[i] != null)
					model.setXchRt(xchRt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVIEDailyExrateReturnVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VIEDailyExrateReturnVO[]
	 */
	public VIEDailyExrateReturnVO[] getVIEDailyExrateReturnVOs(){
		VIEDailyExrateReturnVO[] vos = (VIEDailyExrateReturnVO[])models.toArray(new VIEDailyExrateReturnVO[models.size()]);
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
		this.xchDt = this.xchDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRt = this.xchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
