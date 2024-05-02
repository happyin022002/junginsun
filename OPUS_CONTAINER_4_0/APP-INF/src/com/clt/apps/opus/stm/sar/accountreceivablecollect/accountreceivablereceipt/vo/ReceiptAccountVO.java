/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ReceiptAccountVO.java
*@FileTitle : ReceiptAccountVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.14  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo;

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

public class ReceiptAccountVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ReceiptAccountVO> models = new ArrayList<ReceiptAccountVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String arAcctCd = null;
	/* Column Info */
	private String acctMtxSeq = null;
	/* Column Info */
	private String acctCtnt2 = null;
	/* Column Info */
	private String acctCtnt3 = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ReceiptAccountVO() {}

	public ReceiptAccountVO(String ibflag, String pagerows, String acctMtxSeq, String acctCtnt2, String acctCtnt3, String arAcctCd) {
		this.ibflag = ibflag;
		this.arAcctCd = arAcctCd;
		this.acctMtxSeq = acctMtxSeq;
		this.acctCtnt2 = acctCtnt2;
		this.acctCtnt3 = acctCtnt3;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ar_acct_cd", getArAcctCd());
		this.hashColumns.put("acct_mtx_seq", getAcctMtxSeq());
		this.hashColumns.put("acct_ctnt2", getAcctCtnt2());
		this.hashColumns.put("acct_ctnt3", getAcctCtnt3());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ar_acct_cd", "arAcctCd");
		this.hashFields.put("acct_mtx_seq", "acctMtxSeq");
		this.hashFields.put("acct_ctnt2", "acctCtnt2");
		this.hashFields.put("acct_ctnt3", "acctCtnt3");
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
	 * Column Info
	 * @return acctCtnt2
	 */
	public String getAcctCtnt2() {
		return this.acctCtnt2;
	}
	
	/**
	 * Column Info
	 * @return acctCtnt3
	 */
	public String getAcctCtnt3() {
		return this.acctCtnt3;
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
	 * Column Info
	 * @param acctCtnt2
	 */
	public void setAcctCtnt2(String acctCtnt2) {
		this.acctCtnt2 = acctCtnt2;
	}
	
	/**
	 * Column Info
	 * @param acctCtnt3
	 */
	public void setAcctCtnt3(String acctCtnt3) {
		this.acctCtnt3 = acctCtnt3;
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
		setArAcctCd(JSPUtil.getParameter(request, prefix + "ar_acct_cd", ""));
		setAcctMtxSeq(JSPUtil.getParameter(request, prefix + "acct_mtx_seq", ""));
		setAcctCtnt2(JSPUtil.getParameter(request, prefix + "acct_ctnt2", ""));
		setAcctCtnt3(JSPUtil.getParameter(request, prefix + "acct_ctnt3", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ReceiptAccountVO[]
	 */
	public ReceiptAccountVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ReceiptAccountVO[]
	 */
	public ReceiptAccountVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ReceiptAccountVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] arAcctCd = (JSPUtil.getParameter(request, prefix	+ "ar_acct_cd", length));
			String[] acctMtxSeq = (JSPUtil.getParameter(request, prefix	+ "acct_mtx_seq", length));
			String[] acctCtnt2 = (JSPUtil.getParameter(request, prefix	+ "acct_ctnt2", length));
			String[] acctCtnt3 = (JSPUtil.getParameter(request, prefix	+ "acct_ctnt3", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ReceiptAccountVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (arAcctCd[i] != null)
					model.setArAcctCd(arAcctCd[i]);
				if (acctMtxSeq[i] != null)
					model.setAcctMtxSeq(acctMtxSeq[i]);
				if (acctCtnt2[i] != null)
					model.setAcctCtnt2(acctCtnt2[i]);
				if (acctCtnt3[i] != null)
					model.setAcctCtnt3(acctCtnt3[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getReceiptAccountVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ReceiptAccountVO[]
	 */
	public ReceiptAccountVO[] getReceiptAccountVOs(){
		ReceiptAccountVO[] vos = (ReceiptAccountVO[])models.toArray(new ReceiptAccountVO[models.size()]);
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
		this.arAcctCd = this.arAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctMtxSeq = this.acctMtxSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCtnt2 = this.acctCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCtnt3 = this.acctCtnt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
