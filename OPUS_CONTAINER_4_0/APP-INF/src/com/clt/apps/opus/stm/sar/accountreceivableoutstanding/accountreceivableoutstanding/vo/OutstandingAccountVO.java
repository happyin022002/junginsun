/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : OutstandingAccountVO.java
*@FileTitle : OutstandingAccountVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.10
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.10  
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

public class OutstandingAccountVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OutstandingAccountVO> models = new ArrayList<OutstandingAccountVO>();
	
	/* Column Info */
	private String revAcctDivCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String clrAcctCd = null;
	/* Column Info */
	private String arAcctCd = null;
	/* Column Info */
	private String acctMtxSeq = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public OutstandingAccountVO() {}

	public OutstandingAccountVO(String ibflag, String pagerows, String acctMtxSeq, String clrAcctCd, String revAcctDivCd, String arAcctCd) {
		this.revAcctDivCd = revAcctDivCd;
		this.ibflag = ibflag;
		this.clrAcctCd = clrAcctCd;
		this.arAcctCd = arAcctCd;
		this.acctMtxSeq = acctMtxSeq;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rev_acct_div_cd", getRevAcctDivCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("clr_acct_cd", getClrAcctCd());
		this.hashColumns.put("ar_acct_cd", getArAcctCd());
		this.hashColumns.put("acct_mtx_seq", getAcctMtxSeq());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rev_acct_div_cd", "revAcctDivCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("clr_acct_cd", "clrAcctCd");
		this.hashFields.put("ar_acct_cd", "arAcctCd");
		this.hashFields.put("acct_mtx_seq", "acctMtxSeq");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return revAcctDivCd
	 */
	public String getRevAcctDivCd() {
		return this.revAcctDivCd;
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
	 * @return clrAcctCd
	 */
	public String getClrAcctCd() {
		return this.clrAcctCd;
	}
	
	/**
	 * Column Info
	 * @return arAcctCd
	 */
	public String getArAcctCd() {
		return this.arAcctCd;
	}
	
	/**
	 * Column Info
	 * @return acctMtxSeq
	 */
	public String getAcctMtxSeq() {
		return this.acctMtxSeq;
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
	 * @param revAcctDivCd
	 */
	public void setRevAcctDivCd(String revAcctDivCd) {
		this.revAcctDivCd = revAcctDivCd;
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
	 * @param clrAcctCd
	 */
	public void setClrAcctCd(String clrAcctCd) {
		this.clrAcctCd = clrAcctCd;
	}
	
	/**
	 * Column Info
	 * @param arAcctCd
	 */
	public void setArAcctCd(String arAcctCd) {
		this.arAcctCd = arAcctCd;
	}
	
	/**
	 * Column Info
	 * @param acctMtxSeq
	 */
	public void setAcctMtxSeq(String acctMtxSeq) {
		this.acctMtxSeq = acctMtxSeq;
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
		setRevAcctDivCd(JSPUtil.getParameter(request, prefix + "rev_acct_div_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setClrAcctCd(JSPUtil.getParameter(request, prefix + "clr_acct_cd", ""));
		setArAcctCd(JSPUtil.getParameter(request, prefix + "ar_acct_cd", ""));
		setAcctMtxSeq(JSPUtil.getParameter(request, prefix + "acct_mtx_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OutstandingAccountVO[]
	 */
	public OutstandingAccountVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OutstandingAccountVO[]
	 */
	public OutstandingAccountVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OutstandingAccountVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] revAcctDivCd = (JSPUtil.getParameter(request, prefix	+ "rev_acct_div_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] clrAcctCd = (JSPUtil.getParameter(request, prefix	+ "clr_acct_cd", length));
			String[] arAcctCd = (JSPUtil.getParameter(request, prefix	+ "ar_acct_cd", length));
			String[] acctMtxSeq = (JSPUtil.getParameter(request, prefix	+ "acct_mtx_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new OutstandingAccountVO();
				if (revAcctDivCd[i] != null)
					model.setRevAcctDivCd(revAcctDivCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (clrAcctCd[i] != null)
					model.setClrAcctCd(clrAcctCd[i]);
				if (arAcctCd[i] != null)
					model.setArAcctCd(arAcctCd[i]);
				if (acctMtxSeq[i] != null)
					model.setAcctMtxSeq(acctMtxSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOutstandingAccountVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OutstandingAccountVO[]
	 */
	public OutstandingAccountVO[] getOutstandingAccountVOs(){
		OutstandingAccountVO[] vos = (OutstandingAccountVO[])models.toArray(new OutstandingAccountVO[models.size()]);
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
		this.revAcctDivCd = this.revAcctDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clrAcctCd = this.clrAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arAcctCd = this.arAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctMtxSeq = this.acctMtxSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
