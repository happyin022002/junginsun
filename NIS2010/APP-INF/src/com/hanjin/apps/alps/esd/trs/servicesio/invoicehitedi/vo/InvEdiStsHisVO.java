/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvEdiStsHisVO.java
*@FileTitle : InvEdiStsHisVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.28
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.06.28 신동일 
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

public class InvEdiStsHisVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvEdiStsHisVO> models = new ArrayList<InvEdiStsHisVO>();
	
	/* Column Info */
	private String invNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String invVndrSeq = null;
	/* Column Info */
	private String invEdiRcvSeq = null;
	/* Column Info */
	private String invEdiStsHisSeq = null;
	/* Column Info */
	private String invEdiRcvStsId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public InvEdiStsHisVO() {}

	public InvEdiStsHisVO(String ibflag, String pagerows, String invEdiRcvSeq, String invEdiStsHisSeq, String invNo, String invVndrSeq, String invEdiRcvStsId) {
		this.invNo = invNo;
		this.ibflag = ibflag;
		this.invVndrSeq = invVndrSeq;
		this.invEdiRcvSeq = invEdiRcvSeq;
		this.invEdiStsHisSeq = invEdiStsHisSeq;
		this.invEdiRcvStsId = invEdiRcvStsId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("inv_vndr_seq", getInvVndrSeq());
		this.hashColumns.put("inv_edi_rcv_seq", getInvEdiRcvSeq());
		this.hashColumns.put("inv_edi_sts_his_seq", getInvEdiStsHisSeq());
		this.hashColumns.put("inv_edi_rcv_sts_id", getInvEdiRcvStsId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inv_vndr_seq", "invVndrSeq");
		this.hashFields.put("inv_edi_rcv_seq", "invEdiRcvSeq");
		this.hashFields.put("inv_edi_sts_his_seq", "invEdiStsHisSeq");
		this.hashFields.put("inv_edi_rcv_sts_id", "invEdiRcvStsId");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return invVndrSeq
	 */
	public String getInvVndrSeq() {
		return this.invVndrSeq;
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
	 * @return invEdiStsHisSeq
	 */
	public String getInvEdiStsHisSeq() {
		return this.invEdiStsHisSeq;
	}
	
	/**
	 * Column Info
	 * @return invEdiRcvStsId
	 */
	public String getInvEdiRcvStsId() {
		return this.invEdiRcvStsId;
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
	 * @param invVndrSeq
	 */
	public void setInvVndrSeq(String invVndrSeq) {
		this.invVndrSeq = invVndrSeq;
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
	 * @param invEdiStsHisSeq
	 */
	public void setInvEdiStsHisSeq(String invEdiStsHisSeq) {
		this.invEdiStsHisSeq = invEdiStsHisSeq;
	}
	
	/**
	 * Column Info
	 * @param invEdiRcvStsId
	 */
	public void setInvEdiRcvStsId(String invEdiRcvStsId) {
		this.invEdiRcvStsId = invEdiRcvStsId;
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
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setInvVndrSeq(JSPUtil.getParameter(request, prefix + "inv_vndr_seq", ""));
		setInvEdiRcvSeq(JSPUtil.getParameter(request, prefix + "inv_edi_rcv_seq", ""));
		setInvEdiStsHisSeq(JSPUtil.getParameter(request, prefix + "inv_edi_sts_his_seq", ""));
		setInvEdiRcvStsId(JSPUtil.getParameter(request, prefix + "inv_edi_rcv_sts_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvEdiStsHisVO[]
	 */
	public InvEdiStsHisVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvEdiStsHisVO[]
	 */
	public InvEdiStsHisVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvEdiStsHisVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] invVndrSeq = (JSPUtil.getParameter(request, prefix	+ "inv_vndr_seq", length));
			String[] invEdiRcvSeq = (JSPUtil.getParameter(request, prefix	+ "inv_edi_rcv_seq", length));
			String[] invEdiStsHisSeq = (JSPUtil.getParameter(request, prefix	+ "inv_edi_sts_his_seq", length));
			String[] invEdiRcvStsId = (JSPUtil.getParameter(request, prefix	+ "inv_edi_rcv_sts_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvEdiStsHisVO();
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (invVndrSeq[i] != null)
					model.setInvVndrSeq(invVndrSeq[i]);
				if (invEdiRcvSeq[i] != null)
					model.setInvEdiRcvSeq(invEdiRcvSeq[i]);
				if (invEdiStsHisSeq[i] != null)
					model.setInvEdiStsHisSeq(invEdiStsHisSeq[i]);
				if (invEdiRcvStsId[i] != null)
					model.setInvEdiRcvStsId(invEdiRcvStsId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvEdiStsHisVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvEdiStsHisVO[]
	 */
	public InvEdiStsHisVO[] getInvEdiStsHisVOs(){
		InvEdiStsHisVO[] vos = (InvEdiStsHisVO[])models.toArray(new InvEdiStsHisVO[models.size()]);
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
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invVndrSeq = this.invVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEdiRcvSeq = this.invEdiRcvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEdiStsHisSeq = this.invEdiStsHisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEdiRcvStsId = this.invEdiRcvStsId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
