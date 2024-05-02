/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : OutstandingSumByBlVO.java
*@FileTitle : OutstandingSumByBlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.22  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo;

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

public class OutstandingSumByBlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OutstandingSumByBlVO> models = new ArrayList<OutstandingSumByBlVO>();
	
	/* Column Info */
	private String rctUsdAmt = null;
	/* Column Info */
	private String invUsdAmt = null;
	/* Column Info */
	private String balUsdAmt = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String balLoclAmt = null;
	/* Column Info */
	private String invLoclAmt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String invNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String otsOfcCd = null;
	/* Column Info */
	private String adjLoclAmt = null;
	/* Column Info */
	private String rctLoclAmt = null;
	/* Column Info */
	private String adjUsdAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public OutstandingSumByBlVO() {}

	public OutstandingSumByBlVO(String ibflag, String pagerows, String rhqCd, String otsOfcCd, String blNo, String invNo, String invLoclAmt, String invUsdAmt, String rctLoclAmt, String rctUsdAmt, String adjLoclAmt, String adjUsdAmt, String balLoclAmt, String balUsdAmt) {
		this.rctUsdAmt = rctUsdAmt;
		this.invUsdAmt = invUsdAmt;
		this.balUsdAmt = balUsdAmt;
		this.rhqCd = rhqCd;
		this.balLoclAmt = balLoclAmt;
		this.invLoclAmt = invLoclAmt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.invNo = invNo;
		this.ibflag = ibflag;
		this.otsOfcCd = otsOfcCd;
		this.adjLoclAmt = adjLoclAmt;
		this.rctLoclAmt = rctLoclAmt;
		this.adjUsdAmt = adjUsdAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rct_usd_amt", getRctUsdAmt());
		this.hashColumns.put("inv_usd_amt", getInvUsdAmt());
		this.hashColumns.put("bal_usd_amt", getBalUsdAmt());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("bal_locl_amt", getBalLoclAmt());
		this.hashColumns.put("inv_locl_amt", getInvLoclAmt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ots_ofc_cd", getOtsOfcCd());
		this.hashColumns.put("adj_locl_amt", getAdjLoclAmt());
		this.hashColumns.put("rct_locl_amt", getRctLoclAmt());
		this.hashColumns.put("adj_usd_amt", getAdjUsdAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rct_usd_amt", "rctUsdAmt");
		this.hashFields.put("inv_usd_amt", "invUsdAmt");
		this.hashFields.put("bal_usd_amt", "balUsdAmt");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("bal_locl_amt", "balLoclAmt");
		this.hashFields.put("inv_locl_amt", "invLoclAmt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ots_ofc_cd", "otsOfcCd");
		this.hashFields.put("adj_locl_amt", "adjLoclAmt");
		this.hashFields.put("rct_locl_amt", "rctLoclAmt");
		this.hashFields.put("adj_usd_amt", "adjUsdAmt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rctUsdAmt
	 */
	public String getRctUsdAmt() {
		return this.rctUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return invUsdAmt
	 */
	public String getInvUsdAmt() {
		return this.invUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return balUsdAmt
	 */
	public String getBalUsdAmt() {
		return this.balUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return balLoclAmt
	 */
	public String getBalLoclAmt() {
		return this.balLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return invLoclAmt
	 */
	public String getInvLoclAmt() {
		return this.invLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
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
	 * @return otsOfcCd
	 */
	public String getOtsOfcCd() {
		return this.otsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return adjLoclAmt
	 */
	public String getAdjLoclAmt() {
		return this.adjLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return rctLoclAmt
	 */
	public String getRctLoclAmt() {
		return this.rctLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return adjUsdAmt
	 */
	public String getAdjUsdAmt() {
		return this.adjUsdAmt;
	}
	

	/**
	 * Column Info
	 * @param rctUsdAmt
	 */
	public void setRctUsdAmt(String rctUsdAmt) {
		this.rctUsdAmt = rctUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param invUsdAmt
	 */
	public void setInvUsdAmt(String invUsdAmt) {
		this.invUsdAmt = invUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param balUsdAmt
	 */
	public void setBalUsdAmt(String balUsdAmt) {
		this.balUsdAmt = balUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param balLoclAmt
	 */
	public void setBalLoclAmt(String balLoclAmt) {
		this.balLoclAmt = balLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param invLoclAmt
	 */
	public void setInvLoclAmt(String invLoclAmt) {
		this.invLoclAmt = invLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
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
	 * @param otsOfcCd
	 */
	public void setOtsOfcCd(String otsOfcCd) {
		this.otsOfcCd = otsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param adjLoclAmt
	 */
	public void setAdjLoclAmt(String adjLoclAmt) {
		this.adjLoclAmt = adjLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param rctLoclAmt
	 */
	public void setRctLoclAmt(String rctLoclAmt) {
		this.rctLoclAmt = rctLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param adjUsdAmt
	 */
	public void setAdjUsdAmt(String adjUsdAmt) {
		this.adjUsdAmt = adjUsdAmt;
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
		setRctUsdAmt(JSPUtil.getParameter(request, prefix + "rct_usd_amt", ""));
		setInvUsdAmt(JSPUtil.getParameter(request, prefix + "inv_usd_amt", ""));
		setBalUsdAmt(JSPUtil.getParameter(request, prefix + "bal_usd_amt", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setBalLoclAmt(JSPUtil.getParameter(request, prefix + "bal_locl_amt", ""));
		setInvLoclAmt(JSPUtil.getParameter(request, prefix + "inv_locl_amt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOtsOfcCd(JSPUtil.getParameter(request, prefix + "ots_ofc_cd", ""));
		setAdjLoclAmt(JSPUtil.getParameter(request, prefix + "adj_locl_amt", ""));
		setRctLoclAmt(JSPUtil.getParameter(request, prefix + "rct_locl_amt", ""));
		setAdjUsdAmt(JSPUtil.getParameter(request, prefix + "adj_usd_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OutstandingSumByBlVO[]
	 */
	public OutstandingSumByBlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OutstandingSumByBlVO[]
	 */
	public OutstandingSumByBlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OutstandingSumByBlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rctUsdAmt = (JSPUtil.getParameter(request, prefix	+ "rct_usd_amt", length));
			String[] invUsdAmt = (JSPUtil.getParameter(request, prefix	+ "inv_usd_amt", length));
			String[] balUsdAmt = (JSPUtil.getParameter(request, prefix	+ "bal_usd_amt", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] balLoclAmt = (JSPUtil.getParameter(request, prefix	+ "bal_locl_amt", length));
			String[] invLoclAmt = (JSPUtil.getParameter(request, prefix	+ "inv_locl_amt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] otsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ots_ofc_cd", length));
			String[] adjLoclAmt = (JSPUtil.getParameter(request, prefix	+ "adj_locl_amt", length));
			String[] rctLoclAmt = (JSPUtil.getParameter(request, prefix	+ "rct_locl_amt", length));
			String[] adjUsdAmt = (JSPUtil.getParameter(request, prefix	+ "adj_usd_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new OutstandingSumByBlVO();
				if (rctUsdAmt[i] != null)
					model.setRctUsdAmt(rctUsdAmt[i]);
				if (invUsdAmt[i] != null)
					model.setInvUsdAmt(invUsdAmt[i]);
				if (balUsdAmt[i] != null)
					model.setBalUsdAmt(balUsdAmt[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (balLoclAmt[i] != null)
					model.setBalLoclAmt(balLoclAmt[i]);
				if (invLoclAmt[i] != null)
					model.setInvLoclAmt(invLoclAmt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (otsOfcCd[i] != null)
					model.setOtsOfcCd(otsOfcCd[i]);
				if (adjLoclAmt[i] != null)
					model.setAdjLoclAmt(adjLoclAmt[i]);
				if (rctLoclAmt[i] != null)
					model.setRctLoclAmt(rctLoclAmt[i]);
				if (adjUsdAmt[i] != null)
					model.setAdjUsdAmt(adjUsdAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOutstandingSumByBlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OutstandingSumByBlVO[]
	 */
	public OutstandingSumByBlVO[] getOutstandingSumByBlVOs(){
		OutstandingSumByBlVO[] vos = (OutstandingSumByBlVO[])models.toArray(new OutstandingSumByBlVO[models.size()]);
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
		this.rctUsdAmt = this.rctUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invUsdAmt = this.invUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.balUsdAmt = this.balUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.balLoclAmt = this.balLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invLoclAmt = this.invLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsOfcCd = this.otsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjLoclAmt = this.adjLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctLoclAmt = this.rctLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjUsdAmt = this.adjUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
