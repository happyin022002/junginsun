/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AGnCltRfndUsdLclAmtSumVO.java
*@FileTitle : AGnCltRfndUsdLclAmtSumVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.18
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.18  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class AGnCltRfndUsdLclAmtSumVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AGnCltRfndUsdLclAmtSumVO> models = new ArrayList<AGnCltRfndUsdLclAmtSumVO>();
	
	/* Column Info */
	private String chgUsdAmt = null;
	/* Column Info */
	private String usdAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String loclAmt = null;
	/* Column Info */
	private String eqvLoclAmt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AGnCltRfndUsdLclAmtSumVO() {}

	public AGnCltRfndUsdLclAmtSumVO(String ibflag, String pagerows, String usdAmt, String eqvLoclAmt, String loclAmt, String chgUsdAmt) {
		this.chgUsdAmt = chgUsdAmt;
		this.usdAmt = usdAmt;
		this.ibflag = ibflag;
		this.loclAmt = loclAmt;
		this.eqvLoclAmt = eqvLoclAmt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("chg_usd_amt", getChgUsdAmt());
		this.hashColumns.put("usd_amt", getUsdAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("locl_amt", getLoclAmt());
		this.hashColumns.put("eqv_locl_amt", getEqvLoclAmt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("chg_usd_amt", "chgUsdAmt");
		this.hashFields.put("usd_amt", "usdAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("locl_amt", "loclAmt");
		this.hashFields.put("eqv_locl_amt", "eqvLoclAmt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return chgUsdAmt
	 */
	public String getChgUsdAmt() {
		return this.chgUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return usdAmt
	 */
	public String getUsdAmt() {
		return this.usdAmt;
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
	 * @return loclAmt
	 */
	public String getLoclAmt() {
		return this.loclAmt;
	}
	
	/**
	 * Column Info
	 * @return eqvLoclAmt
	 */
	public String getEqvLoclAmt() {
		return this.eqvLoclAmt;
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
	 * @param chgUsdAmt
	 */
	public void setChgUsdAmt(String chgUsdAmt) {
		this.chgUsdAmt = chgUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param usdAmt
	 */
	public void setUsdAmt(String usdAmt) {
		this.usdAmt = usdAmt;
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
	 * @param loclAmt
	 */
	public void setLoclAmt(String loclAmt) {
		this.loclAmt = loclAmt;
	}
	
	/**
	 * Column Info
	 * @param eqvLoclAmt
	 */
	public void setEqvLoclAmt(String eqvLoclAmt) {
		this.eqvLoclAmt = eqvLoclAmt;
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
		setChgUsdAmt(JSPUtil.getParameter(request, prefix + "chg_usd_amt", ""));
		setUsdAmt(JSPUtil.getParameter(request, prefix + "usd_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLoclAmt(JSPUtil.getParameter(request, prefix + "locl_amt", ""));
		setEqvLoclAmt(JSPUtil.getParameter(request, prefix + "eqv_locl_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AGnCltRfndUsdLclAmtSumVO[]
	 */
	public AGnCltRfndUsdLclAmtSumVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AGnCltRfndUsdLclAmtSumVO[]
	 */
	public AGnCltRfndUsdLclAmtSumVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AGnCltRfndUsdLclAmtSumVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] chgUsdAmt = (JSPUtil.getParameter(request, prefix	+ "chg_usd_amt", length));
			String[] usdAmt = (JSPUtil.getParameter(request, prefix	+ "usd_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] loclAmt = (JSPUtil.getParameter(request, prefix	+ "locl_amt", length));
			String[] eqvLoclAmt = (JSPUtil.getParameter(request, prefix	+ "eqv_locl_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new AGnCltRfndUsdLclAmtSumVO();
				if (chgUsdAmt[i] != null)
					model.setChgUsdAmt(chgUsdAmt[i]);
				if (usdAmt[i] != null)
					model.setUsdAmt(usdAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (loclAmt[i] != null)
					model.setLoclAmt(loclAmt[i]);
				if (eqvLoclAmt[i] != null)
					model.setEqvLoclAmt(eqvLoclAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAGnCltRfndUsdLclAmtSumVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AGnCltRfndUsdLclAmtSumVO[]
	 */
	public AGnCltRfndUsdLclAmtSumVO[] getAGnCltRfndUsdLclAmtSumVOs(){
		AGnCltRfndUsdLclAmtSumVO[] vos = (AGnCltRfndUsdLclAmtSumVO[])models.toArray(new AGnCltRfndUsdLclAmtSumVO[models.size()]);
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
		this.chgUsdAmt = this.chgUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdAmt = this.usdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclAmt = this.loclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqvLoclAmt = this.eqvLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
