/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AGnCltRfndN3rdAmtSumVO.java
*@FileTitle : AGnCltRfndN3rdAmtSumVO
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

public class AGnCltRfndN3rdAmtSumVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AGnCltRfndN3rdAmtSumVO> models = new ArrayList<AGnCltRfndN3rdAmtSumVO>();
	
	/* Column Info */
	private String n3rdCurrCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String n3rdLoclAmt = null;
	/* Column Info */
	private String n3rdAmt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AGnCltRfndN3rdAmtSumVO() {}

	public AGnCltRfndN3rdAmtSumVO(String ibflag, String pagerows, String n3rdAmt, String n3rdCurrCd, String n3rdLoclAmt) {
		this.n3rdCurrCd = n3rdCurrCd;
		this.ibflag = ibflag;
		this.n3rdLoclAmt = n3rdLoclAmt;
		this.n3rdAmt = n3rdAmt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("n3rd_curr_cd", getN3rdCurrCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("n3rd_locl_amt", getN3rdLoclAmt());
		this.hashColumns.put("n3rd_amt", getN3rdAmt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("n3rd_curr_cd", "n3rdCurrCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("n3rd_locl_amt", "n3rdLoclAmt");
		this.hashFields.put("n3rd_amt", "n3rdAmt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return n3rdCurrCd
	 */
	public String getN3rdCurrCd() {
		return this.n3rdCurrCd;
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
	 * @return n3rdLoclAmt
	 */
	public String getN3rdLoclAmt() {
		return this.n3rdLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return n3rdAmt
	 */
	public String getN3rdAmt() {
		return this.n3rdAmt;
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
	 * @param n3rdCurrCd
	 */
	public void setN3rdCurrCd(String n3rdCurrCd) {
		this.n3rdCurrCd = n3rdCurrCd;
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
	 * @param n3rdLoclAmt
	 */
	public void setN3rdLoclAmt(String n3rdLoclAmt) {
		this.n3rdLoclAmt = n3rdLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param n3rdAmt
	 */
	public void setN3rdAmt(String n3rdAmt) {
		this.n3rdAmt = n3rdAmt;
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
		setN3rdCurrCd(JSPUtil.getParameter(request, prefix + "n3rd_curr_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setN3rdLoclAmt(JSPUtil.getParameter(request, prefix + "n3rd_locl_amt", ""));
		setN3rdAmt(JSPUtil.getParameter(request, prefix + "n3rd_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AGnCltRfndN3rdAmtSumVO[]
	 */
	public AGnCltRfndN3rdAmtSumVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AGnCltRfndN3rdAmtSumVO[]
	 */
	public AGnCltRfndN3rdAmtSumVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AGnCltRfndN3rdAmtSumVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] n3rdCurrCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_curr_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] n3rdLoclAmt = (JSPUtil.getParameter(request, prefix	+ "n3rd_locl_amt", length));
			String[] n3rdAmt = (JSPUtil.getParameter(request, prefix	+ "n3rd_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new AGnCltRfndN3rdAmtSumVO();
				if (n3rdCurrCd[i] != null)
					model.setN3rdCurrCd(n3rdCurrCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (n3rdLoclAmt[i] != null)
					model.setN3rdLoclAmt(n3rdLoclAmt[i]);
				if (n3rdAmt[i] != null)
					model.setN3rdAmt(n3rdAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAGnCltRfndN3rdAmtSumVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AGnCltRfndN3rdAmtSumVO[]
	 */
	public AGnCltRfndN3rdAmtSumVO[] getAGnCltRfndN3rdAmtSumVOs(){
		AGnCltRfndN3rdAmtSumVO[] vos = (AGnCltRfndN3rdAmtSumVO[])models.toArray(new AGnCltRfndN3rdAmtSumVO[models.size()]);
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
		this.n3rdCurrCd = this.n3rdCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdLoclAmt = this.n3rdLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdAmt = this.n3rdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
