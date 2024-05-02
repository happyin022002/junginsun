/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : InvEdiAckVO.java
*@FileTitle : InvEdiAckVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.09
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2011.02.09 최도순 
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최도순
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InvEdiAckVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvEdiAckVO> models = new ArrayList<InvEdiAckVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String ackHdrMsg = null;
	/* Column Info */
	private String ackMsgTpCd = null;
	/* Column Info */
	private String ackDt = null;
	/* Column Info */
	private String creDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ackKeyNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ackMsgNm = null;
	/* Column Info */
	private String ackTpCd = null;
	/* Column Info */
	private String ackRsltCd = null;
	/* Column Info */
	private String ackSndrId = null;
	/* Column Info */
	private String ackRjctRsn = null;
	/* Column Info */
	private String ackUpdCd = null;
	/* Column Info */
	private String ackRefNo = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InvEdiAckVO() {}

	public InvEdiAckVO(String ibflag, String pagerows, String ackHdrMsg, String ackSndrId, String ackKeyNo, String ackMsgTpCd, String ackUpdCd, String ackMsgNm, String ackTpCd, String ackRsltCd, String ackDt, String ackRjctRsn, String ackRefNo, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.ackHdrMsg = ackHdrMsg;
		this.ackMsgTpCd = ackMsgTpCd;
		this.ackDt = ackDt;
		this.creDt = creDt;
		this.pagerows = pagerows;
		this.ackKeyNo = ackKeyNo;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.ackMsgNm = ackMsgNm;
		this.ackTpCd = ackTpCd;
		this.ackRsltCd = ackRsltCd;
		this.ackSndrId = ackSndrId;
		this.ackRjctRsn = ackRjctRsn;
		this.ackUpdCd = ackUpdCd;
		this.ackRefNo = ackRefNo;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ack_hdr_msg", getAckHdrMsg());
		this.hashColumns.put("ack_msg_tp_cd", getAckMsgTpCd());
		this.hashColumns.put("ack_dt", getAckDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ack_key_no", getAckKeyNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ack_msg_nm", getAckMsgNm());
		this.hashColumns.put("ack_tp_cd", getAckTpCd());
		this.hashColumns.put("ack_rslt_cd", getAckRsltCd());
		this.hashColumns.put("ack_sndr_id", getAckSndrId());
		this.hashColumns.put("ack_rjct_rsn", getAckRjctRsn());
		this.hashColumns.put("ack_upd_cd", getAckUpdCd());
		this.hashColumns.put("ack_ref_no", getAckRefNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ack_hdr_msg", "ackHdrMsg");
		this.hashFields.put("ack_msg_tp_cd", "ackMsgTpCd");
		this.hashFields.put("ack_dt", "ackDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ack_key_no", "ackKeyNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ack_msg_nm", "ackMsgNm");
		this.hashFields.put("ack_tp_cd", "ackTpCd");
		this.hashFields.put("ack_rslt_cd", "ackRsltCd");
		this.hashFields.put("ack_sndr_id", "ackSndrId");
		this.hashFields.put("ack_rjct_rsn", "ackRjctRsn");
		this.hashFields.put("ack_upd_cd", "ackUpdCd");
		this.hashFields.put("ack_ref_no", "ackRefNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return ackHdrMsg
	 */
	public String getAckHdrMsg() {
		return this.ackHdrMsg;
	}
	
	/**
	 * Column Info
	 * @return ackMsgTpCd
	 */
	public String getAckMsgTpCd() {
		return this.ackMsgTpCd;
	}
	
	/**
	 * Column Info
	 * @return ackDt
	 */
	public String getAckDt() {
		return this.ackDt;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return ackKeyNo
	 */
	public String getAckKeyNo() {
		return this.ackKeyNo;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return ackMsgNm
	 */
	public String getAckMsgNm() {
		return this.ackMsgNm;
	}
	
	/**
	 * Column Info
	 * @return ackTpCd
	 */
	public String getAckTpCd() {
		return this.ackTpCd;
	}
	
	/**
	 * Column Info
	 * @return ackRsltCd
	 */
	public String getAckRsltCd() {
		return this.ackRsltCd;
	}
	
	/**
	 * Column Info
	 * @return ackSndrId
	 */
	public String getAckSndrId() {
		return this.ackSndrId;
	}
	
	/**
	 * Column Info
	 * @return ackRjctRsn
	 */
	public String getAckRjctRsn() {
		return this.ackRjctRsn;
	}
	
	/**
	 * Column Info
	 * @return ackUpdCd
	 */
	public String getAckUpdCd() {
		return this.ackUpdCd;
	}
	
	/**
	 * Column Info
	 * @return ackRefNo
	 */
	public String getAckRefNo() {
		return this.ackRefNo;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	

	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param ackHdrMsg
	 */
	public void setAckHdrMsg(String ackHdrMsg) {
		this.ackHdrMsg = ackHdrMsg;
	}
	
	/**
	 * Column Info
	 * @param ackMsgTpCd
	 */
	public void setAckMsgTpCd(String ackMsgTpCd) {
		this.ackMsgTpCd = ackMsgTpCd;
	}
	
	/**
	 * Column Info
	 * @param ackDt
	 */
	public void setAckDt(String ackDt) {
		this.ackDt = ackDt;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param ackKeyNo
	 */
	public void setAckKeyNo(String ackKeyNo) {
		this.ackKeyNo = ackKeyNo;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param ackMsgNm
	 */
	public void setAckMsgNm(String ackMsgNm) {
		this.ackMsgNm = ackMsgNm;
	}
	
	/**
	 * Column Info
	 * @param ackTpCd
	 */
	public void setAckTpCd(String ackTpCd) {
		this.ackTpCd = ackTpCd;
	}
	
	/**
	 * Column Info
	 * @param ackRsltCd
	 */
	public void setAckRsltCd(String ackRsltCd) {
		this.ackRsltCd = ackRsltCd;
	}
	
	/**
	 * Column Info
	 * @param ackSndrId
	 */
	public void setAckSndrId(String ackSndrId) {
		this.ackSndrId = ackSndrId;
	}
	
	/**
	 * Column Info
	 * @param ackRjctRsn
	 */
	public void setAckRjctRsn(String ackRjctRsn) {
		this.ackRjctRsn = ackRjctRsn;
	}
	
	/**
	 * Column Info
	 * @param ackUpdCd
	 */
	public void setAckUpdCd(String ackUpdCd) {
		this.ackUpdCd = ackUpdCd;
	}
	
	/**
	 * Column Info
	 * @param ackRefNo
	 */
	public void setAckRefNo(String ackRefNo) {
		this.ackRefNo = ackRefNo;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setAckHdrMsg(JSPUtil.getParameter(request, prefix + "ack_hdr_msg", ""));
		setAckMsgTpCd(JSPUtil.getParameter(request, prefix + "ack_msg_tp_cd", ""));
		setAckDt(JSPUtil.getParameter(request, prefix + "ack_dt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAckKeyNo(JSPUtil.getParameter(request, prefix + "ack_key_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAckMsgNm(JSPUtil.getParameter(request, prefix + "ack_msg_nm", ""));
		setAckTpCd(JSPUtil.getParameter(request, prefix + "ack_tp_cd", ""));
		setAckRsltCd(JSPUtil.getParameter(request, prefix + "ack_rslt_cd", ""));
		setAckSndrId(JSPUtil.getParameter(request, prefix + "ack_sndr_id", ""));
		setAckRjctRsn(JSPUtil.getParameter(request, prefix + "ack_rjct_rsn", ""));
		setAckUpdCd(JSPUtil.getParameter(request, prefix + "ack_upd_cd", ""));
		setAckRefNo(JSPUtil.getParameter(request, prefix + "ack_ref_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvEdiAckVO[]
	 */
	public InvEdiAckVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvEdiAckVO[]
	 */
	public InvEdiAckVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvEdiAckVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] ackHdrMsg = (JSPUtil.getParameter(request, prefix	+ "ack_hdr_msg", length));
			String[] ackMsgTpCd = (JSPUtil.getParameter(request, prefix	+ "ack_msg_tp_cd", length));
			String[] ackDt = (JSPUtil.getParameter(request, prefix	+ "ack_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ackKeyNo = (JSPUtil.getParameter(request, prefix	+ "ack_key_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ackMsgNm = (JSPUtil.getParameter(request, prefix	+ "ack_msg_nm", length));
			String[] ackTpCd = (JSPUtil.getParameter(request, prefix	+ "ack_tp_cd", length));
			String[] ackRsltCd = (JSPUtil.getParameter(request, prefix	+ "ack_rslt_cd", length));
			String[] ackSndrId = (JSPUtil.getParameter(request, prefix	+ "ack_sndr_id", length));
			String[] ackRjctRsn = (JSPUtil.getParameter(request, prefix	+ "ack_rjct_rsn", length));
			String[] ackUpdCd = (JSPUtil.getParameter(request, prefix	+ "ack_upd_cd", length));
			String[] ackRefNo = (JSPUtil.getParameter(request, prefix	+ "ack_ref_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvEdiAckVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ackHdrMsg[i] != null)
					model.setAckHdrMsg(ackHdrMsg[i]);
				if (ackMsgTpCd[i] != null)
					model.setAckMsgTpCd(ackMsgTpCd[i]);
				if (ackDt[i] != null)
					model.setAckDt(ackDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ackKeyNo[i] != null)
					model.setAckKeyNo(ackKeyNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ackMsgNm[i] != null)
					model.setAckMsgNm(ackMsgNm[i]);
				if (ackTpCd[i] != null)
					model.setAckTpCd(ackTpCd[i]);
				if (ackRsltCd[i] != null)
					model.setAckRsltCd(ackRsltCd[i]);
				if (ackSndrId[i] != null)
					model.setAckSndrId(ackSndrId[i]);
				if (ackRjctRsn[i] != null)
					model.setAckRjctRsn(ackRjctRsn[i]);
				if (ackUpdCd[i] != null)
					model.setAckUpdCd(ackUpdCd[i]);
				if (ackRefNo[i] != null)
					model.setAckRefNo(ackRefNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvEdiAckVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvEdiAckVO[]
	 */
	public InvEdiAckVO[] getInvEdiAckVOs(){
		InvEdiAckVO[] vos = (InvEdiAckVO[])models.toArray(new InvEdiAckVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackHdrMsg = this.ackHdrMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackMsgTpCd = this.ackMsgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackDt = this.ackDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackKeyNo = this.ackKeyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackMsgNm = this.ackMsgNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackTpCd = this.ackTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackRsltCd = this.ackRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackSndrId = this.ackSndrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackRjctRsn = this.ackRjctRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackUpdCd = this.ackUpdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackRefNo = this.ackRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
