/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BkgCstmsPnmRcvErrVO.java
*@FileTitle : BkgCstmsPnmRcvErrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.vo;

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
public class BkgCstmsPnmRcvErrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgCstmsPnmRcvErrVO> models = new ArrayList<BkgCstmsPnmRcvErrVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	
	/* Page Number */
	private String pagerows = null;

	/* Column Info */
	private String rcvDt = null;

	/* Column Info */
	private String rcvLogSeq = null;

	/* Column Info */
	private String vstNo = null;

	/* Column Info */
	private String rcvLogErrSeq = null;

	/* Column Info */
	private String cstmsErrId = null;

	/* Column Info */
	private String cstmsErrMsg = null;

	/* Column Info */
	private String creUsrId = null;

	/* Column Info */
	private String creDt = null;

	/* Column Info */
	private String updUsrId = null;

	/* Column Info */
	private String updDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BkgCstmsPnmRcvErrVO() {}

	public BkgCstmsPnmRcvErrVO(String ibflag, String pagerows, String rcvDt, String rcvLogSeq, String vstNo, String rcvLogErrSeq, String cstmsErrId, String cstmsErrMsg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.rcvDt = rcvDt;
		this.rcvLogSeq = rcvLogSeq;
		this.vstNo = vstNo;
		this.rcvLogErrSeq = rcvLogErrSeq;
		this.cstmsErrId = cstmsErrId;
		this.cstmsErrMsg = cstmsErrMsg;
		this.creUsrId = creUsrId;
		this.creDt = creDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rcv_dt", getRcvDt());
		this.hashColumns.put("rcv_log_seq", getRcvLogSeq());
		this.hashColumns.put("vst_no", getVstNo());
		this.hashColumns.put("rcv_log_err_seq", getRcvLogErrSeq());
		this.hashColumns.put("cstms_err_id", getCstmsErrId());
		this.hashColumns.put("cstms_err_msg", getCstmsErrMsg());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rcv_dt", "rcvDt");
		this.hashFields.put("rcv_log_seq", "rcvLogSeq");
		this.hashFields.put("vst_no", "vstNo");
		this.hashFields.put("rcv_log_err_seq", "rcvLogErrSeq");
		this.hashFields.put("cstms_err_id", "cstmsErrId");
		this.hashFields.put("cstms_err_msg", "cstmsErrMsg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		return this.hashFields;
	}
	
	/**
	 *
	 * @param String ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * 
	 * @return String ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 *
	 * @param String pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * 
	 * @return String pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 *
	 * @param String rcvDt
	 */
	public void setRcvDt(String rcvDt) {
		this.rcvDt = rcvDt;
	}
	
	/**
	 * 
	 * @return String rcvDt
	 */
	public String getRcvDt() {
		return this.rcvDt;
	}
	
	/**
	 *
	 * @param String rcvLogSeq
	 */
	public void setRcvLogSeq(String rcvLogSeq) {
		this.rcvLogSeq = rcvLogSeq;
	}
	
	/**
	 * 
	 * @return String rcvLogSeq
	 */
	public String getRcvLogSeq() {
		return this.rcvLogSeq;
	}
	
	/**
	 *
	 * @param String vstNo
	 */
	public void setVstNo(String vstNo) {
		this.vstNo = vstNo;
	}
	
	/**
	 * 
	 * @return String vstNo
	 */
	public String getVstNo() {
		return this.vstNo;
	}
	
	/**
	 *
	 * @param String rcvLogErrSeq
	 */
	public void setRcvLogErrSeq(String rcvLogErrSeq) {
		this.rcvLogErrSeq = rcvLogErrSeq;
	}
	
	/**
	 * 
	 * @return String rcvLogErrSeq
	 */
	public String getRcvLogErrSeq() {
		return this.rcvLogErrSeq;
	}
	
	/**
	 *
	 * @param String cstmsErrId
	 */
	public void setCstmsErrId(String cstmsErrId) {
		this.cstmsErrId = cstmsErrId;
	}
	
	/**
	 * 
	 * @return String cstmsErrId
	 */
	public String getCstmsErrId() {
		return this.cstmsErrId;
	}
	
	/**
	 *
	 * @param String cstmsErrMsg
	 */
	public void setCstmsErrMsg(String cstmsErrMsg) {
		this.cstmsErrMsg = cstmsErrMsg;
	}
	
	/**
	 * 
	 * @return String cstmsErrMsg
	 */
	public String getCstmsErrMsg() {
		return this.cstmsErrMsg;
	}
	
	/**
	 *
	 * @param String creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * 
	 * @return String creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 *
	 * @param String creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * 
	 * @return String creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 *
	 * @param String updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 
	 * @return String updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 *
	 * @param String updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * 
	 * @return String updDt
	 */
	public String getUpdDt() {
		return this.updDt;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRcvDt(JSPUtil.getParameter(request, prefix + "rcv_dt", ""));
		setRcvLogSeq(JSPUtil.getParameter(request, prefix + "rcv_log_seq", ""));
		setVstNo(JSPUtil.getParameter(request, prefix + "vst_no", ""));
		setRcvLogErrSeq(JSPUtil.getParameter(request, prefix + "rcv_log_err_seq", ""));
		setCstmsErrId(JSPUtil.getParameter(request, prefix + "cstms_err_id", ""));
		setCstmsErrMsg(JSPUtil.getParameter(request, prefix + "cstms_err_msg", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCstmsPnmRcvErrVO[]
	 */
	public BkgCstmsPnmRcvErrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgCstmsPnmRcvErrVO[]
	 */
	public BkgCstmsPnmRcvErrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgCstmsPnmRcvErrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rcvDt = (JSPUtil.getParameter(request, prefix	+ "rcv_dt", length));
			String[] rcvLogSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_log_seq", length));
			String[] vstNo = (JSPUtil.getParameter(request, prefix	+ "vst_no", length));
			String[] rcvLogErrSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_log_err_seq", length));
			String[] cstmsErrId = (JSPUtil.getParameter(request, prefix	+ "cstms_err_id", length));
			String[] cstmsErrMsg = (JSPUtil.getParameter(request, prefix	+ "cstms_err_msg", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			/* Add a field line, do not delete */
			
			for (int i = 0; i < length; i++) {
				model = new BkgCstmsPnmRcvErrVO();
				if (ibflag[i] != null) 
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null) 
					model.setPagerows(pagerows[i]);
				if (rcvDt[i] != null) 
					model.setRcvDt(rcvDt[i]);
				if (rcvLogSeq[i] != null) 
					model.setRcvLogSeq(rcvLogSeq[i]);
				if (vstNo[i] != null) 
					model.setVstNo(vstNo[i]);
				if (rcvLogErrSeq[i] != null) 
					model.setRcvLogErrSeq(rcvLogErrSeq[i]);
				if (cstmsErrId[i] != null) 
					model.setCstmsErrId(cstmsErrId[i]);
				if (cstmsErrMsg[i] != null) 
					model.setCstmsErrMsg(cstmsErrMsg[i]);
				if (creUsrId[i] != null) 
					model.setCreUsrId(creUsrId[i]);
				if (creDt[i] != null) 
					model.setCreDt(creDt[i]);
				if (updUsrId[i] != null) 
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null) 
					model.setUpdDt(updDt[i]);
				/* Add a Method line, do not delete */
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgCstmsPnmRcvErrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgCstmsPnmRcvErrVO[]
	 */
	public BkgCstmsPnmRcvErrVO[] getBkgCstmsPnmRcvErrVOs(){
		BkgCstmsPnmRcvErrVO[] vos = (BkgCstmsPnmRcvErrVO[])models.toArray(new BkgCstmsPnmRcvErrVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDt = this.rcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvLogSeq = this.rcvLogSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vstNo = this.vstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvLogErrSeq = this.rcvLogErrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsErrId = this.cstmsErrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsErrMsg = this.cstmsErrMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}