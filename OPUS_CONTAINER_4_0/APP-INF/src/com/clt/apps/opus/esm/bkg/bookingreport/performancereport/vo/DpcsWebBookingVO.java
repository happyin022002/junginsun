/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DpcsWebBookingVO.java
*@FileTitle : DpcsWebBookingVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.09
*@LastModifier : 이일민
*@LastVersion : 1.0
* 2009.12.09 이일민 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이일민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DpcsWebBookingVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DpcsWebBookingVO> models = new ArrayList<DpcsWebBookingVO>();
	
	/* Column Info */
	private String xterSndrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String errorCode = null;
	/* Column Info */
	private String xterRqstSeq = null;
	/* Column Info */
	private String errorMsg = null;
	/* Column Info */
	private String xterRqstNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Page Number */
	private String xterRqstChgFlg = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DpcsWebBookingVO() {}

	public DpcsWebBookingVO(String ibflag, String pagerows, String xterSndrId, String xterRqstNo, String xterRqstSeq, String errorCode, String errorMsg, String xterRqstChgFlg) {
		this.xterSndrId = xterSndrId;
		this.ibflag = ibflag;
		this.errorCode = errorCode;
		this.xterRqstSeq = xterRqstSeq;
		this.errorMsg = errorMsg;
		this.xterRqstNo = xterRqstNo;
		this.pagerows = pagerows;
		this.xterRqstChgFlg = xterRqstChgFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("xter_sndr_id", getXterSndrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("error_code", getErrorCode());
		this.hashColumns.put("xter_rqst_seq", getXterRqstSeq());
		this.hashColumns.put("error_msg", getErrorMsg());
		this.hashColumns.put("xter_rqst_no", getXterRqstNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("xter_rqst_chg_flg", getXterRqstChgFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("xter_sndr_id", "xterSndrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("error_code", "errorCode");
		this.hashFields.put("xter_rqst_seq", "xterRqstSeq");
		this.hashFields.put("error_msg", "errorMsg");
		this.hashFields.put("xter_rqst_no", "xterRqstNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("xter_rqst_chg_flg", "xterRqstChgFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return xterSndrId
	 */
	public String getXterSndrId() {
		return this.xterSndrId;
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
	 * @return errorCode
	 */
	public String getErrorCode() {
		return this.errorCode;
	}
	
	/**
	 * Column Info
	 * @return xterRqstSeq
	 */
	public String getXterRqstSeq() {
		return this.xterRqstSeq;
	}
	
	/**
	 * Column Info
	 * @return errorMsg
	 */
	public String getErrorMsg() {
		return this.errorMsg;
	}
	
	/**
	 * Column Info
	 * @return xterRqstNo
	 */
	public String getXterRqstNo() {
		return this.xterRqstNo;
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
	 * @param xterSndrId
	 */
	public void setXterSndrId(String xterSndrId) {
		this.xterSndrId = xterSndrId;
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
	 * @param errorCode
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	/**
	 * Column Info
	 * @param xterRqstSeq
	 */
	public void setXterRqstSeq(String xterRqstSeq) {
		this.xterRqstSeq = xterRqstSeq;
	}
	
	/**
	 * Column Info
	 * @param errorMsg
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	/**
	 * Column Info
	 * @param xterRqstNo
	 */
	public void setXterRqstNo(String xterRqstNo) {
		this.xterRqstNo = xterRqstNo;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	
	public String getXterRqstChgFlg() {
		return xterRqstChgFlg;
	}

	public void setXterRqstChgFlg(String xterRqstChgFlg) {
		this.xterRqstChgFlg = xterRqstChgFlg;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setXterSndrId(JSPUtil.getParameter(request, "xter_sndr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setErrorCode(JSPUtil.getParameter(request, "error_code", ""));
		setXterRqstSeq(JSPUtil.getParameter(request, "xter_rqst_seq", ""));
		setErrorMsg(JSPUtil.getParameter(request, "error_msg", ""));
		setXterRqstNo(JSPUtil.getParameter(request, "xter_rqst_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setXterRqstChgFlg(JSPUtil.getParameter(request, "xter_rqst_chg_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DpcsWebBookingVO[]
	 */
	public DpcsWebBookingVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DpcsWebBookingVO[]
	 */
	public DpcsWebBookingVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DpcsWebBookingVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] xterSndrId = (JSPUtil.getParameter(request, prefix	+ "xter_sndr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] errorCode = (JSPUtil.getParameter(request, prefix	+ "error_code", length));
			String[] xterRqstSeq = (JSPUtil.getParameter(request, prefix	+ "xter_rqst_seq", length));
			String[] errorMsg = (JSPUtil.getParameter(request, prefix	+ "error_msg", length));
			String[] xterRqstNo = (JSPUtil.getParameter(request, prefix	+ "xter_rqst_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] xterRqstChgFlg = (JSPUtil.getParameter(request, prefix	+ "xter_rqst_chg_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new DpcsWebBookingVO();
				if (xterSndrId[i] != null)
					model.setXterSndrId(xterSndrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (errorCode[i] != null)
					model.setErrorCode(errorCode[i]);
				if (xterRqstSeq[i] != null)
					model.setXterRqstSeq(xterRqstSeq[i]);
				if (errorMsg[i] != null)
					model.setErrorMsg(errorMsg[i]);
				if (xterRqstNo[i] != null)
					model.setXterRqstNo(xterRqstNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (xterRqstChgFlg[i] != null)
					model.setXterRqstChgFlg(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDpcsWebBookingVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DpcsWebBookingVO[]
	 */
	public DpcsWebBookingVO[] getDpcsWebBookingVOs(){
		DpcsWebBookingVO[] vos = (DpcsWebBookingVO[])models.toArray(new DpcsWebBookingVO[models.size()]);
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
		this.xterSndrId = this.xterSndrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errorCode = this.errorCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRqstSeq = this.xterRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errorMsg = this.errorMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRqstNo = this.xterRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRqstChgFlg = this.xterRqstChgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
