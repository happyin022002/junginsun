/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AusDgSendDtlHistoryVO.java
*@FileTitle : AusDgSendDtlHistoryVO
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion :
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo;

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
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AusDgSendDtlHistoryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<AusDgSendDtlHistoryVO> models = new ArrayList<AusDgSendDtlHistoryVO>();

	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String eurEdiMsgTpId = null;
	/* Column Info */
	private String dgBlRefNo = null;
	/* Column Info */
	private String ediRspnSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String cntrCgoSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String msgSndNo = null;
	/* Column Info */
	private String dgItmRefNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String keyVal = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public AusDgSendDtlHistoryVO() {}

	public AusDgSendDtlHistoryVO(String ibflag, String pagerows, String eurEdiMsgTpId, String msgSndNo, String ediRspnSeq, String blNo, String cntrNo, String cntrCgoSeq, String dgBlRefNo, String dgItmRefNo, String creUsrId, String creDt, String updUsrId, String updDt, String keyVal) {
		this.updDt = updDt;
		this.eurEdiMsgTpId = eurEdiMsgTpId;
		this.dgBlRefNo = dgBlRefNo;
		this.ediRspnSeq = ediRspnSeq;
		this.creDt = creDt;
		this.blNo = blNo;
		this.cntrCgoSeq = cntrCgoSeq;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.cntrNo = cntrNo;
		this.msgSndNo = msgSndNo;
		this.dgItmRefNo = dgItmRefNo;
		this.updUsrId = updUsrId;
		this.keyVal = keyVal;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("eur_edi_msg_tp_id", getEurEdiMsgTpId());
		this.hashColumns.put("dg_bl_ref_no", getDgBlRefNo());
		this.hashColumns.put("edi_rspn_seq", getEdiRspnSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("cntr_cgo_seq", getCntrCgoSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("msg_snd_no", getMsgSndNo());
		this.hashColumns.put("dg_itm_ref_no", getDgItmRefNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("key_val", getKeyVal());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("eur_edi_msg_tp_id", "eurEdiMsgTpId");
		this.hashFields.put("dg_bl_ref_no", "dgBlRefNo");
		this.hashFields.put("edi_rspn_seq", "ediRspnSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("cntr_cgo_seq", "cntrCgoSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("msg_snd_no", "msgSndNo");
		this.hashFields.put("dg_itm_ref_no", "dgItmRefNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("key_val", "keyVal");
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
	 * @return dgBlRefNo
	 */
	public String getDgBlRefNo() {
		return this.dgBlRefNo;
	}

	/**
	 * Column Info
	 * @return ediRspnSeq
	 */
	public String getEdiRspnSeq() {
		return this.ediRspnSeq;
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
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}

	/**
	 * Column Info
	 * @return cntrCgoSeq
	 */
	public String getCntrCgoSeq() {
		return this.cntrCgoSeq;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}

	/**
	 * Column Info
	 * @return msgSndNo
	 */
	public String getMsgSndNo() {
		return this.msgSndNo;
	}

	/**
	 * Column Info
	 * @return dgItmRefNo
	 */
	public String getDgItmRefNo() {
		return this.dgItmRefNo;
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
	 * @return keyVal
	 */
	public String getKeyVal() {
		return this.keyVal;
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
	 * @param dgBlRefNo
	 */
	public void setDgBlRefNo(String dgBlRefNo) {
		this.dgBlRefNo = dgBlRefNo;
	}

	/**
	 * Column Info
	 * @param ediRspnSeq
	 */
	public void setEdiRspnSeq(String ediRspnSeq) {
		this.ediRspnSeq = ediRspnSeq;
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
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	/**
	 * Column Info
	 * @param cntrCgoSeq
	 */
	public void setCntrCgoSeq(String cntrCgoSeq) {
		this.cntrCgoSeq = cntrCgoSeq;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	/**
	 * Column Info
	 * @param msgSndNo
	 */
	public void setMsgSndNo(String msgSndNo) {
		this.msgSndNo = msgSndNo;
	}

	/**
	 * Column Info
	 * @param dgItmRefNo
	 */
	public void setDgItmRefNo(String dgItmRefNo) {
		this.dgItmRefNo = dgItmRefNo;
	}

	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	/**
	 * Column Info
	 * @param keyVal
	 */
	public void setKeyVal(String keyVal) {
		this.keyVal = keyVal;
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
		setEurEdiMsgTpId(JSPUtil.getParameter(request, prefix + "eur_edi_msg_tp_id", ""));
		setDgBlRefNo(JSPUtil.getParameter(request, prefix + "dg_bl_ref_no", ""));
		setEdiRspnSeq(JSPUtil.getParameter(request, prefix + "edi_rspn_seq", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setCntrCgoSeq(JSPUtil.getParameter(request, prefix + "cntr_cgo_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setMsgSndNo(JSPUtil.getParameter(request, prefix + "msg_snd_no", ""));
		setDgItmRefNo(JSPUtil.getParameter(request, prefix + "dg_itm_ref_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setKeyVal(JSPUtil.getParameter(request, prefix + "key_val", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AusDgSendDtlHistoryVO[]
	 */
	public AusDgSendDtlHistoryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return AusDgSendDtlHistoryVO[]
	 */
	public AusDgSendDtlHistoryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AusDgSendDtlHistoryVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] eurEdiMsgTpId = (JSPUtil.getParameter(request, prefix	+ "eur_edi_msg_tp_id", length));
			String[] dgBlRefNo = (JSPUtil.getParameter(request, prefix	+ "dg_bl_ref_no", length));
			String[] ediRspnSeq = (JSPUtil.getParameter(request, prefix	+ "edi_rspn_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] cntrCgoSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_cgo_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] msgSndNo = (JSPUtil.getParameter(request, prefix	+ "msg_snd_no", length));
			String[] dgItmRefNo = (JSPUtil.getParameter(request, prefix	+ "dg_itm_ref_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] keyVal = (JSPUtil.getParameter(request, prefix	+ "key_val", length));

			for (int i = 0; i < length; i++) {
				model = new AusDgSendDtlHistoryVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (eurEdiMsgTpId[i] != null)
					model.setEurEdiMsgTpId(eurEdiMsgTpId[i]);
				if (dgBlRefNo[i] != null)
					model.setDgBlRefNo(dgBlRefNo[i]);
				if (ediRspnSeq[i] != null)
					model.setEdiRspnSeq(ediRspnSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (cntrCgoSeq[i] != null)
					model.setCntrCgoSeq(cntrCgoSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (msgSndNo[i] != null)
					model.setMsgSndNo(msgSndNo[i]);
				if (dgItmRefNo[i] != null)
					model.setDgItmRefNo(dgItmRefNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (keyVal[i] != null)
					model.setKeyVal(keyVal[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAusDgSendDtlHistoryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AusDgSendDtlHistoryVO[]
	 */
	public AusDgSendDtlHistoryVO[] getAusDgSendDtlHistoryVOs(){
		AusDgSendDtlHistoryVO[] vos = (AusDgSendDtlHistoryVO[])models.toArray(new AusDgSendDtlHistoryVO[models.size()]);
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
		this.eurEdiMsgTpId = this.eurEdiMsgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgBlRefNo = this.dgBlRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRspnSeq = this.ediRspnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCgoSeq = this.cntrCgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgSndNo = this.msgSndNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgItmRefNo = this.dgItmRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keyVal = this.keyVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
