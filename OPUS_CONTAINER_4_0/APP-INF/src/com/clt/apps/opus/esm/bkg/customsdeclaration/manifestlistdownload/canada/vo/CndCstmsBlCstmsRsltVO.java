/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CndCstmsBlCstmsRsltVO.java
*@FileTitle : CndCstmsBlCstmsRsltVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.23
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.04.23 김민정 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo;

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
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CndCstmsBlCstmsRsltVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CndCstmsBlCstmsRsltVO> models = new ArrayList<CndCstmsBlCstmsRsltVO>();
	
	/* Column Info */
	private String cstmsFileTpCd = null;
	/* Column Info */
	private String rcvDtTime = null;
	/* Column Info */
	private String cndAckSubCd = null;
	/* Column Info */
	private String resultDesc = null;
	/* Column Info */
	private String rcvSeq = null;
	/* Column Info */
	private String cstmsRjctMsg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cndAckRcvId = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String errTpCtnt = null;
	/* Column Info */
	private String cndAckErrNoteDesc = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rcvDtDate = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String ackDesc = null;
	/* Column Info */
	private String errCdDesc = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String rnum = null;
	/* Column Info */
	private String rcvMsgTpId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CndCstmsBlCstmsRsltVO() {}

	public CndCstmsBlCstmsRsltVO(String ibflag, String pagerows, String rcvMsgTpId, String rcvSeq, String rcvDtDate, String rcvDtTime, String vvdCd, String polCd, String podCd, String cstmsFileTpCd, String cndAckRcvId, String cndAckSubCd, String cstmsRjctMsg, String cndAckErrNoteDesc, String ackDesc, String resultDesc, String errCdDesc, String errTpCtnt, String rnum) {
		this.cstmsFileTpCd = cstmsFileTpCd;
		this.rcvDtTime = rcvDtTime;
		this.cndAckSubCd = cndAckSubCd;
		this.resultDesc = resultDesc;
		this.rcvSeq = rcvSeq;
		this.cstmsRjctMsg = cstmsRjctMsg;
		this.pagerows = pagerows;
		this.cndAckRcvId = cndAckRcvId;
		this.podCd = podCd;
		this.errTpCtnt = errTpCtnt;
		this.cndAckErrNoteDesc = cndAckErrNoteDesc;
		this.ibflag = ibflag;
		this.rcvDtDate = rcvDtDate;
		this.polCd = polCd;
		this.ackDesc = ackDesc;
		this.errCdDesc = errCdDesc;
		this.vvdCd = vvdCd;
		this.rnum = rnum;
		this.rcvMsgTpId = rcvMsgTpId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cstms_file_tp_cd", getCstmsFileTpCd());
		this.hashColumns.put("rcv_dt_time", getRcvDtTime());
		this.hashColumns.put("cnd_ack_sub_cd", getCndAckSubCd());
		this.hashColumns.put("result_desc", getResultDesc());
		this.hashColumns.put("rcv_seq", getRcvSeq());
		this.hashColumns.put("cstms_rjct_msg", getCstmsRjctMsg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cnd_ack_rcv_id", getCndAckRcvId());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("err_tp_ctnt", getErrTpCtnt());
		this.hashColumns.put("cnd_ack_err_note_desc", getCndAckErrNoteDesc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rcv_dt_date", getRcvDtDate());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ack_desc", getAckDesc());
		this.hashColumns.put("err_cd_desc", getErrCdDesc());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("rnum", getRnum());
		this.hashColumns.put("rcv_msg_tp_id", getRcvMsgTpId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cstms_file_tp_cd", "cstmsFileTpCd");
		this.hashFields.put("rcv_dt_time", "rcvDtTime");
		this.hashFields.put("cnd_ack_sub_cd", "cndAckSubCd");
		this.hashFields.put("result_desc", "resultDesc");
		this.hashFields.put("rcv_seq", "rcvSeq");
		this.hashFields.put("cstms_rjct_msg", "cstmsRjctMsg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cnd_ack_rcv_id", "cndAckRcvId");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("err_tp_ctnt", "errTpCtnt");
		this.hashFields.put("cnd_ack_err_note_desc", "cndAckErrNoteDesc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rcv_dt_date", "rcvDtDate");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ack_desc", "ackDesc");
		this.hashFields.put("err_cd_desc", "errCdDesc");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("rnum", "rnum");
		this.hashFields.put("rcv_msg_tp_id", "rcvMsgTpId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cstmsFileTpCd
	 */
	public String getCstmsFileTpCd() {
		return this.cstmsFileTpCd;
	}
	
	/**
	 * Column Info
	 * @return rcvDtTime
	 */
	public String getRcvDtTime() {
		return this.rcvDtTime;
	}
	
	/**
	 * Column Info
	 * @return cndAckSubCd
	 */
	public String getCndAckSubCd() {
		return this.cndAckSubCd;
	}
	
	/**
	 * Column Info
	 * @return resultDesc
	 */
	public String getResultDesc() {
		return this.resultDesc;
	}
	
	/**
	 * Column Info
	 * @return rcvSeq
	 */
	public String getRcvSeq() {
		return this.rcvSeq;
	}
	
	/**
	 * Column Info
	 * @return cstmsRjctMsg
	 */
	public String getCstmsRjctMsg() {
		return this.cstmsRjctMsg;
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
	 * @return cndAckRcvId
	 */
	public String getCndAckRcvId() {
		return this.cndAckRcvId;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return errTpCtnt
	 */
	public String getErrTpCtnt() {
		return this.errTpCtnt;
	}
	
	/**
	 * Column Info
	 * @return cndAckErrNoteDesc
	 */
	public String getCndAckErrNoteDesc() {
		return this.cndAckErrNoteDesc;
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
	 * @return rcvDtDate
	 */
	public String getRcvDtDate() {
		return this.rcvDtDate;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return ackDesc
	 */
	public String getAckDesc() {
		return this.ackDesc;
	}
	
	/**
	 * Column Info
	 * @return errCdDesc
	 */
	public String getErrCdDesc() {
		return this.errCdDesc;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return rnum
	 */
	public String getRnum() {
		return this.rnum;
	}
	
	/**
	 * Column Info
	 * @return rcvMsgTpId
	 */
	public String getRcvMsgTpId() {
		return this.rcvMsgTpId;
	}
	

	/**
	 * Column Info
	 * @param cstmsFileTpCd
	 */
	public void setCstmsFileTpCd(String cstmsFileTpCd) {
		this.cstmsFileTpCd = cstmsFileTpCd;
	}
	
	/**
	 * Column Info
	 * @param rcvDtTime
	 */
	public void setRcvDtTime(String rcvDtTime) {
		this.rcvDtTime = rcvDtTime;
	}
	
	/**
	 * Column Info
	 * @param cndAckSubCd
	 */
	public void setCndAckSubCd(String cndAckSubCd) {
		this.cndAckSubCd = cndAckSubCd;
	}
	
	/**
	 * Column Info
	 * @param resultDesc
	 */
	public void setResultDesc(String resultDesc) {
		this.resultDesc = resultDesc;
	}
	
	/**
	 * Column Info
	 * @param rcvSeq
	 */
	public void setRcvSeq(String rcvSeq) {
		this.rcvSeq = rcvSeq;
	}
	
	/**
	 * Column Info
	 * @param cstmsRjctMsg
	 */
	public void setCstmsRjctMsg(String cstmsRjctMsg) {
		this.cstmsRjctMsg = cstmsRjctMsg;
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
	 * @param cndAckRcvId
	 */
	public void setCndAckRcvId(String cndAckRcvId) {
		this.cndAckRcvId = cndAckRcvId;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param errTpCtnt
	 */
	public void setErrTpCtnt(String errTpCtnt) {
		this.errTpCtnt = errTpCtnt;
	}
	
	/**
	 * Column Info
	 * @param cndAckErrNoteDesc
	 */
	public void setCndAckErrNoteDesc(String cndAckErrNoteDesc) {
		this.cndAckErrNoteDesc = cndAckErrNoteDesc;
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
	 * @param rcvDtDate
	 */
	public void setRcvDtDate(String rcvDtDate) {
		this.rcvDtDate = rcvDtDate;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param ackDesc
	 */
	public void setAckDesc(String ackDesc) {
		this.ackDesc = ackDesc;
	}
	
	/**
	 * Column Info
	 * @param errCdDesc
	 */
	public void setErrCdDesc(String errCdDesc) {
		this.errCdDesc = errCdDesc;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param rnum
	 */
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	
	/**
	 * Column Info
	 * @param rcvMsgTpId
	 */
	public void setRcvMsgTpId(String rcvMsgTpId) {
		this.rcvMsgTpId = rcvMsgTpId;
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
		setCstmsFileTpCd(JSPUtil.getParameter(request, prefix + "cstms_file_tp_cd", ""));
		setRcvDtTime(JSPUtil.getParameter(request, prefix + "rcv_dt_time", ""));
		setCndAckSubCd(JSPUtil.getParameter(request, prefix + "cnd_ack_sub_cd", ""));
		setResultDesc(JSPUtil.getParameter(request, prefix + "result_desc", ""));
		setRcvSeq(JSPUtil.getParameter(request, prefix + "rcv_seq", ""));
		setCstmsRjctMsg(JSPUtil.getParameter(request, prefix + "cstms_rjct_msg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCndAckRcvId(JSPUtil.getParameter(request, prefix + "cnd_ack_rcv_id", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setErrTpCtnt(JSPUtil.getParameter(request, prefix + "err_tp_ctnt", ""));
		setCndAckErrNoteDesc(JSPUtil.getParameter(request, prefix + "cnd_ack_err_note_desc", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRcvDtDate(JSPUtil.getParameter(request, prefix + "rcv_dt_date", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setAckDesc(JSPUtil.getParameter(request, prefix + "ack_desc", ""));
		setErrCdDesc(JSPUtil.getParameter(request, prefix + "err_cd_desc", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setRnum(JSPUtil.getParameter(request, prefix + "rnum", ""));
		setRcvMsgTpId(JSPUtil.getParameter(request, prefix + "rcv_msg_tp_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CndCstmsBlCstmsRsltVO[]
	 */
	public CndCstmsBlCstmsRsltVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CndCstmsBlCstmsRsltVO[]
	 */
	public CndCstmsBlCstmsRsltVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CndCstmsBlCstmsRsltVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cstmsFileTpCd = (JSPUtil.getParameter(request, prefix	+ "cstms_file_tp_cd", length));
			String[] rcvDtTime = (JSPUtil.getParameter(request, prefix	+ "rcv_dt_time", length));
			String[] cndAckSubCd = (JSPUtil.getParameter(request, prefix	+ "cnd_ack_sub_cd", length));
			String[] resultDesc = (JSPUtil.getParameter(request, prefix	+ "result_desc", length));
			String[] rcvSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_seq", length));
			String[] cstmsRjctMsg = (JSPUtil.getParameter(request, prefix	+ "cstms_rjct_msg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cndAckRcvId = (JSPUtil.getParameter(request, prefix	+ "cnd_ack_rcv_id", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] errTpCtnt = (JSPUtil.getParameter(request, prefix	+ "err_tp_ctnt", length));
			String[] cndAckErrNoteDesc = (JSPUtil.getParameter(request, prefix	+ "cnd_ack_err_note_desc", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rcvDtDate = (JSPUtil.getParameter(request, prefix	+ "rcv_dt_date", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ackDesc = (JSPUtil.getParameter(request, prefix	+ "ack_desc", length));
			String[] errCdDesc = (JSPUtil.getParameter(request, prefix	+ "err_cd_desc", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] rnum = (JSPUtil.getParameter(request, prefix	+ "rnum", length));
			String[] rcvMsgTpId = (JSPUtil.getParameter(request, prefix	+ "rcv_msg_tp_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new CndCstmsBlCstmsRsltVO();
				if (cstmsFileTpCd[i] != null)
					model.setCstmsFileTpCd(cstmsFileTpCd[i]);
				if (rcvDtTime[i] != null)
					model.setRcvDtTime(rcvDtTime[i]);
				if (cndAckSubCd[i] != null)
					model.setCndAckSubCd(cndAckSubCd[i]);
				if (resultDesc[i] != null)
					model.setResultDesc(resultDesc[i]);
				if (rcvSeq[i] != null)
					model.setRcvSeq(rcvSeq[i]);
				if (cstmsRjctMsg[i] != null)
					model.setCstmsRjctMsg(cstmsRjctMsg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cndAckRcvId[i] != null)
					model.setCndAckRcvId(cndAckRcvId[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (errTpCtnt[i] != null)
					model.setErrTpCtnt(errTpCtnt[i]);
				if (cndAckErrNoteDesc[i] != null)
					model.setCndAckErrNoteDesc(cndAckErrNoteDesc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rcvDtDate[i] != null)
					model.setRcvDtDate(rcvDtDate[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ackDesc[i] != null)
					model.setAckDesc(ackDesc[i]);
				if (errCdDesc[i] != null)
					model.setErrCdDesc(errCdDesc[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (rnum[i] != null)
					model.setRnum(rnum[i]);
				if (rcvMsgTpId[i] != null)
					model.setRcvMsgTpId(rcvMsgTpId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCndCstmsBlCstmsRsltVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CndCstmsBlCstmsRsltVO[]
	 */
	public CndCstmsBlCstmsRsltVO[] getCndCstmsBlCstmsRsltVOs(){
		CndCstmsBlCstmsRsltVO[] vos = (CndCstmsBlCstmsRsltVO[])models.toArray(new CndCstmsBlCstmsRsltVO[models.size()]);
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
		this.cstmsFileTpCd = this.cstmsFileTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDtTime = this.rcvDtTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cndAckSubCd = this.cndAckSubCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.resultDesc = this.resultDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvSeq = this.rcvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsRjctMsg = this.cstmsRjctMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cndAckRcvId = this.cndAckRcvId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errTpCtnt = this.errTpCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cndAckErrNoteDesc = this.cndAckErrNoteDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDtDate = this.rcvDtDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackDesc = this.ackDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errCdDesc = this.errCdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rnum = this.rnum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvMsgTpId = this.rcvMsgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
