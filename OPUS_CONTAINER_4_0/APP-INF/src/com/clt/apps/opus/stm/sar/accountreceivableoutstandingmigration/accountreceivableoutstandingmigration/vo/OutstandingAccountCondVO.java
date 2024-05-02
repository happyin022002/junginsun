/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OutstandingAccountCondVO.java
*@FileTitle : OutstandingAccountCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.27  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.vo;

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

public class OutstandingAccountCondVO extends AbstractValueObject {
 
	private static final long serialVersionUID = 1L;
	
	private Collection<OutstandingAccountCondVO> models = new ArrayList<OutstandingAccountCondVO>();
	
	/* Column Info */
	private String glDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String acctCtnt1 = null;
	/* Column Info */
	private String acctCtnt2 = null;
	/* Column Info */
	private String acctCtnt3 = null;
	/* Column Info */
	private String acctCtnt4 = null;
	/* Column Info */
	private String acctTpCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public OutstandingAccountCondVO() {}

	public OutstandingAccountCondVO(String ibflag, String pagerows, String acctCtnt1, String acctCtnt2, String acctCtnt3, String acctCtnt4, String acctTpCd, String glDt) {
		this.glDt = glDt;
		this.ibflag = ibflag;
		this.acctCtnt1 = acctCtnt1;
		this.acctCtnt2 = acctCtnt2;
		this.acctCtnt3 = acctCtnt3;
		this.acctCtnt4 = acctCtnt4;
		this.acctTpCd = acctTpCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("gl_dt", getGlDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("acct_ctnt1", getAcctCtnt1());
		this.hashColumns.put("acct_ctnt2", getAcctCtnt2());
		this.hashColumns.put("acct_ctnt3", getAcctCtnt3());
		this.hashColumns.put("acct_ctnt4", getAcctCtnt4());
		this.hashColumns.put("acct_tp_cd", getAcctTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("gl_dt", "glDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("acct_ctnt1", "acctCtnt1");
		this.hashFields.put("acct_ctnt2", "acctCtnt2");
		this.hashFields.put("acct_ctnt3", "acctCtnt3");
		this.hashFields.put("acct_ctnt4", "acctCtnt4");
		this.hashFields.put("acct_tp_cd", "acctTpCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return glDt
	 */
	public String getGlDt() {
		return this.glDt;
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
	 * @return acctCtnt1
	 */
	public String getAcctCtnt1() {
		return this.acctCtnt1;
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
	 * Column Info
	 * @return acctCtnt4
	 */
	public String getAcctCtnt4() {
		return this.acctCtnt4;
	}
	
	/**
	 * Column Info
	 * @return acctTpCd
	 */
	public String getAcctTpCd() {
		return this.acctTpCd;
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
	 * @param glDt
	 */
	public void setGlDt(String glDt) {
		this.glDt = glDt;
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
	 * @param acctCtnt1
	 */
	public void setAcctCtnt1(String acctCtnt1) {
		this.acctCtnt1 = acctCtnt1;
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
	 * Column Info
	 * @param acctCtnt4
	 */
	public void setAcctCtnt4(String acctCtnt4) {
		this.acctCtnt4 = acctCtnt4;
	}
	
	/**
	 * Column Info
	 * @param acctTpCd
	 */
	public void setAcctTpCd(String acctTpCd) {
		this.acctTpCd = acctTpCd;
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
		setGlDt(JSPUtil.getParameter(request, prefix + "gl_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAcctCtnt1(JSPUtil.getParameter(request, prefix + "acct_ctnt1", ""));
		setAcctCtnt2(JSPUtil.getParameter(request, prefix + "acct_ctnt2", ""));
		setAcctCtnt3(JSPUtil.getParameter(request, prefix + "acct_ctnt3", ""));
		setAcctCtnt4(JSPUtil.getParameter(request, prefix + "acct_ctnt4", ""));
		setAcctTpCd(JSPUtil.getParameter(request, prefix + "acct_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OutstandingAccountCondVO[]
	 */
	public OutstandingAccountCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OutstandingAccountCondVO[]
	 */
	public OutstandingAccountCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OutstandingAccountCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] glDt = (JSPUtil.getParameter(request, prefix	+ "gl_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] acctCtnt1 = (JSPUtil.getParameter(request, prefix	+ "acct_ctnt1", length));
			String[] acctCtnt2 = (JSPUtil.getParameter(request, prefix	+ "acct_ctnt2", length));
			String[] acctCtnt3 = (JSPUtil.getParameter(request, prefix	+ "acct_ctnt3", length));
			String[] acctCtnt4 = (JSPUtil.getParameter(request, prefix	+ "acct_ctnt4", length));
			String[] acctTpCd = (JSPUtil.getParameter(request, prefix	+ "acct_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new OutstandingAccountCondVO();
				if (glDt[i] != null)
					model.setGlDt(glDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (acctCtnt1[i] != null)
					model.setAcctCtnt1(acctCtnt1[i]);
				if (acctCtnt2[i] != null)
					model.setAcctCtnt2(acctCtnt2[i]);
				if (acctCtnt3[i] != null)
					model.setAcctCtnt3(acctCtnt3[i]);
				if (acctCtnt4[i] != null)
					model.setAcctCtnt4(acctCtnt4[i]);
				if (acctTpCd[i] != null)
					model.setAcctTpCd(acctTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOutstandingAccountCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OutstandingAccountCondVO[]
	 */
	public OutstandingAccountCondVO[] getOutstandingAccountCondVOs(){
		OutstandingAccountCondVO[] vos = (OutstandingAccountCondVO[])models.toArray(new OutstandingAccountCondVO[models.size()]);
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
		this.glDt = this.glDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCtnt1 = this.acctCtnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCtnt2 = this.acctCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCtnt3 = this.acctCtnt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCtnt4 = this.acctCtnt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctTpCd = this.acctTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}