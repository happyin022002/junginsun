/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DgReceiveDtlHistoryVO.java
*@FileTitle : DgReceiveDtlHistoryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier :
*@LastVersion : 1.0
* 2009.09.14
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DgReceiveDtlHistoryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<DgReceiveDtlHistoryVO> models = new ArrayList<DgReceiveDtlHistoryVO>();

	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String eurEdiMsgTpId = null;
	/* Column Info */
	private String cstmsErrRefNo2 = null;
	/* Column Info */
	private String cstmsErrRefNo1 = null;
	/* Column Info */
	private String cstmsErrId = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String msgRcvNo = null;
	/* Column Info */
	private String cstmsErrMsg = null;
	/* Column Info */
	private String rcvLogErrSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String rcvLogSeq = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public DgReceiveDtlHistoryVO() {}

	public DgReceiveDtlHistoryVO(String ibflag, String pagerows, String eurEdiMsgTpId, String msgRcvNo, String rcvLogSeq, String rcvLogErrSeq, String cstmsErrId, String cstmsErrMsg, String cstmsErrRefNo1, String cstmsErrRefNo2, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.eurEdiMsgTpId = eurEdiMsgTpId;
		this.cstmsErrRefNo2 = cstmsErrRefNo2;
		this.cstmsErrRefNo1 = cstmsErrRefNo1;
		this.cstmsErrId = cstmsErrId;
		this.creDt = creDt;
		this.msgRcvNo = msgRcvNo;
		this.cstmsErrMsg = cstmsErrMsg;
		this.rcvLogErrSeq = rcvLogErrSeq;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.rcvLogSeq = rcvLogSeq;
		this.updUsrId = updUsrId;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("eur_edi_msg_tp_id", getEurEdiMsgTpId());
		this.hashColumns.put("cstms_err_ref_no2", getCstmsErrRefNo2());
		this.hashColumns.put("cstms_err_ref_no1", getCstmsErrRefNo1());
		this.hashColumns.put("cstms_err_id", getCstmsErrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("msg_rcv_no", getMsgRcvNo());
		this.hashColumns.put("cstms_err_msg", getCstmsErrMsg());
		this.hashColumns.put("rcv_log_err_seq", getRcvLogErrSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("rcv_log_seq", getRcvLogSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("eur_edi_msg_tp_id", "eurEdiMsgTpId");
		this.hashFields.put("cstms_err_ref_no2", "cstmsErrRefNo2");
		this.hashFields.put("cstms_err_ref_no1", "cstmsErrRefNo1");
		this.hashFields.put("cstms_err_id", "cstmsErrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("msg_rcv_no", "msgRcvNo");
		this.hashFields.put("cstms_err_msg", "cstmsErrMsg");
		this.hashFields.put("rcv_log_err_seq", "rcvLogErrSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("rcv_log_seq", "rcvLogSeq");
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
	 * @return eurEdiMsgTpId
	 */
	public String getEurEdiMsgTpId() {
		return this.eurEdiMsgTpId;
	}

	/**
	 * Column Info
	 * @return cstmsErrRefNo2
	 */
	public String getCstmsErrRefNo2() {
		return this.cstmsErrRefNo2;
	}

	/**
	 * Column Info
	 * @return cstmsErrRefNo1
	 */
	public String getCstmsErrRefNo1() {
		return this.cstmsErrRefNo1;
	}

	/**
	 * Column Info
	 * @return cstmsErrId
	 */
	public String getCstmsErrId() {
		return this.cstmsErrId;
	}

	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}

	/**
	 * Column Info
	 * @return msgRcvNo
	 */
	public String getMsgRcvNo() {
		return this.msgRcvNo;
	}

	/**
	 * Column Info
	 * @return cstmsErrMsg
	 */
	public String getCstmsErrMsg() {
		return this.cstmsErrMsg;
	}

	/**
	 * Column Info
	 * @return rcvLogErrSeq
	 */
	public String getRcvLogErrSeq() {
		return this.rcvLogErrSeq;
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
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}

	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}

	/**
	 * Column Info
	 * @return rcvLogSeq
	 */
	public String getRcvLogSeq() {
		return this.rcvLogSeq;
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
	 * @param eurEdiMsgTpId
	 */
	public void setEurEdiMsgTpId(String eurEdiMsgTpId) {
		this.eurEdiMsgTpId = eurEdiMsgTpId;
	}

	/**
	 * Column Info
	 * @param cstmsErrRefNo2
	 */
	public void setCstmsErrRefNo2(String cstmsErrRefNo2) {
		this.cstmsErrRefNo2 = cstmsErrRefNo2;
	}

	/**
	 * Column Info
	 * @param cstmsErrRefNo1
	 */
	public void setCstmsErrRefNo1(String cstmsErrRefNo1) {
		this.cstmsErrRefNo1 = cstmsErrRefNo1;
	}

	/**
	 * Column Info
	 * @param cstmsErrId
	 */
	public void setCstmsErrId(String cstmsErrId) {
		this.cstmsErrId = cstmsErrId;
	}

	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}

	/**
	 * Column Info
	 * @param msgRcvNo
	 */
	public void setMsgRcvNo(String msgRcvNo) {
		this.msgRcvNo = msgRcvNo;
	}

	/**
	 * Column Info
	 * @param cstmsErrMsg
	 */
	public void setCstmsErrMsg(String cstmsErrMsg) {
		this.cstmsErrMsg = cstmsErrMsg;
	}

	/**
	 * Column Info
	 * @param rcvLogErrSeq
	 */
	public void setRcvLogErrSeq(String rcvLogErrSeq) {
		this.rcvLogErrSeq = rcvLogErrSeq;
	}

	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	/**
	 * Column Info
	 * @param rcvLogSeq
	 */
	public void setRcvLogSeq(String rcvLogSeq) {
		this.rcvLogSeq = rcvLogSeq;
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
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setEurEdiMsgTpId(JSPUtil.getParameter(request, "eur_edi_msg_tp_id", ""));
		setCstmsErrRefNo2(JSPUtil.getParameter(request, "cstms_err_ref_no2", ""));
		setCstmsErrRefNo1(JSPUtil.getParameter(request, "cstms_err_ref_no1", ""));
		setCstmsErrId(JSPUtil.getParameter(request, "cstms_err_id", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setMsgRcvNo(JSPUtil.getParameter(request, "msg_rcv_no", ""));
		setCstmsErrMsg(JSPUtil.getParameter(request, "cstms_err_msg", ""));
		setRcvLogErrSeq(JSPUtil.getParameter(request, "rcv_log_err_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setRcvLogSeq(JSPUtil.getParameter(request, "rcv_log_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DgReceiveDtlHistoryVO[]
	 */
	public DgReceiveDtlHistoryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return DgReceiveDtlHistoryVO[]
	 */
	public DgReceiveDtlHistoryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DgReceiveDtlHistoryVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] eurEdiMsgTpId = (JSPUtil.getParameter(request, prefix	+ "eur_edi_msg_tp_id", length));
			String[] cstmsErrRefNo2 = (JSPUtil.getParameter(request, prefix	+ "cstms_err_ref_no2", length));
			String[] cstmsErrRefNo1 = (JSPUtil.getParameter(request, prefix	+ "cstms_err_ref_no1", length));
			String[] cstmsErrId = (JSPUtil.getParameter(request, prefix	+ "cstms_err_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] msgRcvNo = (JSPUtil.getParameter(request, prefix	+ "msg_rcv_no", length));
			String[] cstmsErrMsg = (JSPUtil.getParameter(request, prefix	+ "cstms_err_msg", length));
			String[] rcvLogErrSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_log_err_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] rcvLogSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_log_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));

			for (int i = 0; i < length; i++) {
				model = new DgReceiveDtlHistoryVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (eurEdiMsgTpId[i] != null)
					model.setEurEdiMsgTpId(eurEdiMsgTpId[i]);
				if (cstmsErrRefNo2[i] != null)
					model.setCstmsErrRefNo2(cstmsErrRefNo2[i]);
				if (cstmsErrRefNo1[i] != null)
					model.setCstmsErrRefNo1(cstmsErrRefNo1[i]);
				if (cstmsErrId[i] != null)
					model.setCstmsErrId(cstmsErrId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (msgRcvNo[i] != null)
					model.setMsgRcvNo(msgRcvNo[i]);
				if (cstmsErrMsg[i] != null)
					model.setCstmsErrMsg(cstmsErrMsg[i]);
				if (rcvLogErrSeq[i] != null)
					model.setRcvLogErrSeq(rcvLogErrSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (rcvLogSeq[i] != null)
					model.setRcvLogSeq(rcvLogSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDgReceiveDtlHistoryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DgReceiveDtlHistoryVO[]
	 */
	public DgReceiveDtlHistoryVO[] getDgReceiveDtlHistoryVOs(){
		DgReceiveDtlHistoryVO[] vos = (DgReceiveDtlHistoryVO[])models.toArray(new DgReceiveDtlHistoryVO[models.size()]);
		return vos;
	}

	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}

	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eurEdiMsgTpId = this.eurEdiMsgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsErrRefNo2 = this.cstmsErrRefNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsErrRefNo1 = this.cstmsErrRefNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsErrId = this.cstmsErrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgRcvNo = this.msgRcvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsErrMsg = this.cstmsErrMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvLogErrSeq = this.rcvLogErrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvLogSeq = this.rcvLogSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
