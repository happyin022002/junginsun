/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvEdiErrLogVO.java
*@FileTitle : InvEdiErrLogVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.15
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.07.15 신동일 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.vo;

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
 * @author 신동일
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InvEdiErrLogVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvEdiErrLogVO> models = new ArrayList<InvEdiErrLogVO>();
	
	/* Column Info */
	private String invEdiErrLogSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String invEdiStsCd = null;
	/* Column Info */
	private String invEdiRcvSeq = null;
	/* Column Info */
	private String errMsg = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public InvEdiErrLogVO() {}

	public InvEdiErrLogVO(String ibflag, String pagerows, String invEdiErrLogSeq, String invEdiRcvSeq, String invEdiStsCd, String errMsg) {
		this.invEdiErrLogSeq = invEdiErrLogSeq;
		this.ibflag = ibflag;
		this.invEdiStsCd = invEdiStsCd;
		this.invEdiRcvSeq = invEdiRcvSeq;
		this.errMsg = errMsg;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("inv_edi_err_log_seq", getInvEdiErrLogSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("inv_edi_sts_cd", getInvEdiStsCd());
		this.hashColumns.put("inv_edi_rcv_seq", getInvEdiRcvSeq());
		this.hashColumns.put("err_msg", getErrMsg());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("inv_edi_err_log_seq", "invEdiErrLogSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inv_edi_sts_cd", "invEdiStsCd");
		this.hashFields.put("inv_edi_rcv_seq", "invEdiRcvSeq");
		this.hashFields.put("err_msg", "errMsg");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return invEdiErrLogSeq
	 */
	public String getInvEdiErrLogSeq() {
		return this.invEdiErrLogSeq;
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
	 * @return invEdiStsCd
	 */
	public String getInvEdiStsCd() {
		return this.invEdiStsCd;
	}
	
	/**
	 * Column Info
	 * @return invEdiRcvSeq
	 */
	public String getInvEdiRcvSeq() {
		return this.invEdiRcvSeq;
	}
	
	/**
	 * Column Info
	 * @return errMsg
	 */
	public String getErrMsg() {
		return this.errMsg;
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
	 * @param invEdiErrLogSeq
	 */
	public void setInvEdiErrLogSeq(String invEdiErrLogSeq) {
		this.invEdiErrLogSeq = invEdiErrLogSeq;
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
	 * @param invEdiStsCd
	 */
	public void setInvEdiStsCd(String invEdiStsCd) {
		this.invEdiStsCd = invEdiStsCd;
	}
	
	/**
	 * Column Info
	 * @param invEdiRcvSeq
	 */
	public void setInvEdiRcvSeq(String invEdiRcvSeq) {
		this.invEdiRcvSeq = invEdiRcvSeq;
	}
	
	/**
	 * Column Info
	 * @param errMsg
	 */
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
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
		setInvEdiErrLogSeq(JSPUtil.getParameter(request, prefix + "inv_edi_err_log_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setInvEdiStsCd(JSPUtil.getParameter(request, prefix + "inv_edi_sts_cd", ""));
		setInvEdiRcvSeq(JSPUtil.getParameter(request, prefix + "inv_edi_rcv_seq", ""));
		setErrMsg(JSPUtil.getParameter(request, prefix + "err_msg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvEdiErrLogVO[]
	 */
	public InvEdiErrLogVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvEdiErrLogVO[]
	 */
	public InvEdiErrLogVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvEdiErrLogVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] invEdiErrLogSeq = (JSPUtil.getParameter(request, prefix	+ "inv_edi_err_log_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] invEdiStsCd = (JSPUtil.getParameter(request, prefix	+ "inv_edi_sts_cd", length));
			String[] invEdiRcvSeq = (JSPUtil.getParameter(request, prefix	+ "inv_edi_rcv_seq", length));
			String[] errMsg = (JSPUtil.getParameter(request, prefix	+ "err_msg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvEdiErrLogVO();
				if (invEdiErrLogSeq[i] != null)
					model.setInvEdiErrLogSeq(invEdiErrLogSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (invEdiStsCd[i] != null)
					model.setInvEdiStsCd(invEdiStsCd[i]);
				if (invEdiRcvSeq[i] != null)
					model.setInvEdiRcvSeq(invEdiRcvSeq[i]);
				if (errMsg[i] != null)
					model.setErrMsg(errMsg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvEdiErrLogVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvEdiErrLogVO[]
	 */
	public InvEdiErrLogVO[] getInvEdiErrLogVOs(){
		InvEdiErrLogVO[] vos = (InvEdiErrLogVO[])models.toArray(new InvEdiErrLogVO[models.size()]);
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
		this.invEdiErrLogSeq = this.invEdiErrLogSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEdiStsCd = this.invEdiStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEdiRcvSeq = this.invEdiRcvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errMsg = this.errMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
