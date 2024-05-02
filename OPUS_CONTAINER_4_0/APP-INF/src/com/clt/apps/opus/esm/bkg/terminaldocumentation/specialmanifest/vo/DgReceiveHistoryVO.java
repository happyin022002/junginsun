/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DgReceiveHistoryVO.java
*@FileTitle : DgReceiveHistoryVO
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

public class DgReceiveHistoryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<DgReceiveHistoryVO> models = new ArrayList<DgReceiveHistoryVO>();

	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String eurEdiMsgTpId = null;
	/* Column Info */
	private String ackDt = null;
	/* Column Info */
	private String msgAcptRefNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String msgRcvNo = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String aproDt = null;
	/* Column Info */
	private String orgMsgRcvrNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cstmsPhnNo = null;
	/* Column Info */
	private String msgFuncId = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String ackRcvStsCd = null;
	/* Column Info */
	private String orgMsgTpId = null;
	/* Column Info */
	private String ediSndMsgNm = null;
	/* Column Info */
	private String rcvLogSeq = null;
	/* Column Info */
	private String scrFileNo = null;
	/* Column Info */
	private String cstmsFaxNo = null;
	/* Column Info */
	private String ackKndId = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public DgReceiveHistoryVO() {}

	public DgReceiveHistoryVO(String ibflag, String pagerows, String eurEdiMsgTpId, String msgRcvNo, String rcvLogSeq, String orgMsgRcvrNo, String orgMsgTpId, String msgFuncId, String ediSndMsgNm, String ackKndId, String ackRcvStsCd, String ackDt, String aproDt, String cstmsPhnNo, String cstmsFaxNo, String cntrNo, String blNo, String scrFileNo, String msgAcptRefNo, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.eurEdiMsgTpId = eurEdiMsgTpId;
		this.ackDt = ackDt;
		this.msgAcptRefNo = msgAcptRefNo;
		this.creDt = creDt;
		this.msgRcvNo = msgRcvNo;
		this.blNo = blNo;
		this.aproDt = aproDt;
		this.orgMsgRcvrNo = orgMsgRcvrNo;
		this.pagerows = pagerows;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.cstmsPhnNo = cstmsPhnNo;
		this.msgFuncId = msgFuncId;
		this.cntrNo = cntrNo;
		this.ackRcvStsCd = ackRcvStsCd;
		this.orgMsgTpId = orgMsgTpId;
		this.ediSndMsgNm = ediSndMsgNm;
		this.rcvLogSeq = rcvLogSeq;
		this.scrFileNo = scrFileNo;
		this.cstmsFaxNo = cstmsFaxNo;
		this.ackKndId = ackKndId;
		this.updUsrId = updUsrId;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("eur_edi_msg_tp_id", getEurEdiMsgTpId());
		this.hashColumns.put("ack_dt", getAckDt());
		this.hashColumns.put("msg_acpt_ref_no", getMsgAcptRefNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("msg_rcv_no", getMsgRcvNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("apro_dt", getAproDt());
		this.hashColumns.put("org_msg_rcvr_no", getOrgMsgRcvrNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cstms_phn_no", getCstmsPhnNo());
		this.hashColumns.put("msg_func_id", getMsgFuncId());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("ack_rcv_sts_cd", getAckRcvStsCd());
		this.hashColumns.put("org_msg_tp_id", getOrgMsgTpId());
		this.hashColumns.put("edi_snd_msg_nm", getEdiSndMsgNm());
		this.hashColumns.put("rcv_log_seq", getRcvLogSeq());
		this.hashColumns.put("scr_file_no", getScrFileNo());
		this.hashColumns.put("cstms_fax_no", getCstmsFaxNo());
		this.hashColumns.put("ack_knd_id", getAckKndId());
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
		this.hashFields.put("ack_dt", "ackDt");
		this.hashFields.put("msg_acpt_ref_no", "msgAcptRefNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("msg_rcv_no", "msgRcvNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("apro_dt", "aproDt");
		this.hashFields.put("org_msg_rcvr_no", "orgMsgRcvrNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cstms_phn_no", "cstmsPhnNo");
		this.hashFields.put("msg_func_id", "msgFuncId");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("ack_rcv_sts_cd", "ackRcvStsCd");
		this.hashFields.put("org_msg_tp_id", "orgMsgTpId");
		this.hashFields.put("edi_snd_msg_nm", "ediSndMsgNm");
		this.hashFields.put("rcv_log_seq", "rcvLogSeq");
		this.hashFields.put("scr_file_no", "scrFileNo");
		this.hashFields.put("cstms_fax_no", "cstmsFaxNo");
		this.hashFields.put("ack_knd_id", "ackKndId");
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
	 * @return ackDt
	 */
	public String getAckDt() {
		return this.ackDt;
	}

	/**
	 * Column Info
	 * @return msgAcptRefNo
	 */
	public String getMsgAcptRefNo() {
		return this.msgAcptRefNo;
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
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}

	/**
	 * Column Info
	 * @return aproDt
	 */
	public String getAproDt() {
		return this.aproDt;
	}

	/**
	 * Column Info
	 * @return orgMsgRcvrNo
	 */
	public String getOrgMsgRcvrNo() {
		return this.orgMsgRcvrNo;
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
	 * @return cstmsPhnNo
	 */
	public String getCstmsPhnNo() {
		return this.cstmsPhnNo;
	}

	/**
	 * Column Info
	 * @return msgFuncId
	 */
	public String getMsgFuncId() {
		return this.msgFuncId;
	}

	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}

	/**
	 * Column Info
	 * @return ackRcvStsCd
	 */
	public String getAckRcvStsCd() {
		return this.ackRcvStsCd;
	}

	/**
	 * Column Info
	 * @return orgMsgTpId
	 */
	public String getOrgMsgTpId() {
		return this.orgMsgTpId;
	}

	/**
	 * Column Info
	 * @return ediSndMsgNm
	 */
	public String getEdiSndMsgNm() {
		return this.ediSndMsgNm;
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
	 * @return scrFileNo
	 */
	public String getScrFileNo() {
		return this.scrFileNo;
	}

	/**
	 * Column Info
	 * @return cstmsFaxNo
	 */
	public String getCstmsFaxNo() {
		return this.cstmsFaxNo;
	}

	/**
	 * Column Info
	 * @return ackKndId
	 */
	public String getAckKndId() {
		return this.ackKndId;
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
	 * @param ackDt
	 */
	public void setAckDt(String ackDt) {
		this.ackDt = ackDt;
	}

	/**
	 * Column Info
	 * @param msgAcptRefNo
	 */
	public void setMsgAcptRefNo(String msgAcptRefNo) {
		this.msgAcptRefNo = msgAcptRefNo;
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
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	/**
	 * Column Info
	 * @param aproDt
	 */
	public void setAproDt(String aproDt) {
		this.aproDt = aproDt;
	}

	/**
	 * Column Info
	 * @param orgMsgRcvrNo
	 */
	public void setOrgMsgRcvrNo(String orgMsgRcvrNo) {
		this.orgMsgRcvrNo = orgMsgRcvrNo;
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
	 * @param cstmsPhnNo
	 */
	public void setCstmsPhnNo(String cstmsPhnNo) {
		this.cstmsPhnNo = cstmsPhnNo;
	}

	/**
	 * Column Info
	 * @param msgFuncId
	 */
	public void setMsgFuncId(String msgFuncId) {
		this.msgFuncId = msgFuncId;
	}

	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	/**
	 * Column Info
	 * @param ackRcvStsCd
	 */
	public void setAckRcvStsCd(String ackRcvStsCd) {
		this.ackRcvStsCd = ackRcvStsCd;
	}

	/**
	 * Column Info
	 * @param orgMsgTpId
	 */
	public void setOrgMsgTpId(String orgMsgTpId) {
		this.orgMsgTpId = orgMsgTpId;
	}

	/**
	 * Column Info
	 * @param ediSndMsgNm
	 */
	public void setEdiSndMsgNm(String ediSndMsgNm) {
		this.ediSndMsgNm = ediSndMsgNm;
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
	 * @param scrFileNo
	 */
	public void setScrFileNo(String scrFileNo) {
		this.scrFileNo = scrFileNo;
	}

	/**
	 * Column Info
	 * @param cstmsFaxNo
	 */
	public void setCstmsFaxNo(String cstmsFaxNo) {
		this.cstmsFaxNo = cstmsFaxNo;
	}

	/**
	 * Column Info
	 * @param ackKndId
	 */
	public void setAckKndId(String ackKndId) {
		this.ackKndId = ackKndId;
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
		setAckDt(JSPUtil.getParameter(request, "ack_dt", ""));
		setMsgAcptRefNo(JSPUtil.getParameter(request, "msg_acpt_ref_no", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setMsgRcvNo(JSPUtil.getParameter(request, "msg_rcv_no", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setAproDt(JSPUtil.getParameter(request, "apro_dt", ""));
		setOrgMsgRcvrNo(JSPUtil.getParameter(request, "org_msg_rcvr_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCstmsPhnNo(JSPUtil.getParameter(request, "cstms_phn_no", ""));
		setMsgFuncId(JSPUtil.getParameter(request, "msg_func_id", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setAckRcvStsCd(JSPUtil.getParameter(request, "ack_rcv_sts_cd", ""));
		setOrgMsgTpId(JSPUtil.getParameter(request, "org_msg_tp_id", ""));
		setEdiSndMsgNm(JSPUtil.getParameter(request, "edi_snd_msg_nm", ""));
		setRcvLogSeq(JSPUtil.getParameter(request, "rcv_log_seq", ""));
		setScrFileNo(JSPUtil.getParameter(request, "scr_file_no", ""));
		setCstmsFaxNo(JSPUtil.getParameter(request, "cstms_fax_no", ""));
		setAckKndId(JSPUtil.getParameter(request, "ack_knd_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DgReceiveHistoryVO[]
	 */
	public DgReceiveHistoryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return DgReceiveHistoryVO[]
	 */
	public DgReceiveHistoryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DgReceiveHistoryVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] eurEdiMsgTpId = (JSPUtil.getParameter(request, prefix	+ "eur_edi_msg_tp_id", length));
			String[] ackDt = (JSPUtil.getParameter(request, prefix	+ "ack_dt", length));
			String[] msgAcptRefNo = (JSPUtil.getParameter(request, prefix	+ "msg_acpt_ref_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] msgRcvNo = (JSPUtil.getParameter(request, prefix	+ "msg_rcv_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] aproDt = (JSPUtil.getParameter(request, prefix	+ "apro_dt", length));
			String[] orgMsgRcvrNo = (JSPUtil.getParameter(request, prefix	+ "org_msg_rcvr_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cstmsPhnNo = (JSPUtil.getParameter(request, prefix	+ "cstms_phn_no", length));
			String[] msgFuncId = (JSPUtil.getParameter(request, prefix	+ "msg_func_id", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] ackRcvStsCd = (JSPUtil.getParameter(request, prefix	+ "ack_rcv_sts_cd", length));
			String[] orgMsgTpId = (JSPUtil.getParameter(request, prefix	+ "org_msg_tp_id", length));
			String[] ediSndMsgNm = (JSPUtil.getParameter(request, prefix	+ "edi_snd_msg_nm", length));
			String[] rcvLogSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_log_seq", length));
			String[] scrFileNo = (JSPUtil.getParameter(request, prefix	+ "scr_file_no", length));
			String[] cstmsFaxNo = (JSPUtil.getParameter(request, prefix	+ "cstms_fax_no", length));
			String[] ackKndId = (JSPUtil.getParameter(request, prefix	+ "ack_knd_id", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));

			for (int i = 0; i < length; i++) {
				model = new DgReceiveHistoryVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (eurEdiMsgTpId[i] != null)
					model.setEurEdiMsgTpId(eurEdiMsgTpId[i]);
				if (ackDt[i] != null)
					model.setAckDt(ackDt[i]);
				if (msgAcptRefNo[i] != null)
					model.setMsgAcptRefNo(msgAcptRefNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (msgRcvNo[i] != null)
					model.setMsgRcvNo(msgRcvNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (aproDt[i] != null)
					model.setAproDt(aproDt[i]);
				if (orgMsgRcvrNo[i] != null)
					model.setOrgMsgRcvrNo(orgMsgRcvrNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cstmsPhnNo[i] != null)
					model.setCstmsPhnNo(cstmsPhnNo[i]);
				if (msgFuncId[i] != null)
					model.setMsgFuncId(msgFuncId[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (ackRcvStsCd[i] != null)
					model.setAckRcvStsCd(ackRcvStsCd[i]);
				if (orgMsgTpId[i] != null)
					model.setOrgMsgTpId(orgMsgTpId[i]);
				if (ediSndMsgNm[i] != null)
					model.setEdiSndMsgNm(ediSndMsgNm[i]);
				if (rcvLogSeq[i] != null)
					model.setRcvLogSeq(rcvLogSeq[i]);
				if (scrFileNo[i] != null)
					model.setScrFileNo(scrFileNo[i]);
				if (cstmsFaxNo[i] != null)
					model.setCstmsFaxNo(cstmsFaxNo[i]);
				if (ackKndId[i] != null)
					model.setAckKndId(ackKndId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDgReceiveHistoryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DgReceiveHistoryVO[]
	 */
	public DgReceiveHistoryVO[] getDgReceiveHistoryVOs(){
		DgReceiveHistoryVO[] vos = (DgReceiveHistoryVO[])models.toArray(new DgReceiveHistoryVO[models.size()]);
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
		this.ackDt = this.ackDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgAcptRefNo = this.msgAcptRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgRcvNo = this.msgRcvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproDt = this.aproDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgMsgRcvrNo = this.orgMsgRcvrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsPhnNo = this.cstmsPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgFuncId = this.msgFuncId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackRcvStsCd = this.ackRcvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgMsgTpId = this.orgMsgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndMsgNm = this.ediSndMsgNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvLogSeq = this.rcvLogSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scrFileNo = this.scrFileNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsFaxNo = this.cstmsFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackKndId = this.ackKndId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
