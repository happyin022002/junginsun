/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OpfPrnrEdiLogVO.java
*@FileTitle : OpfPrnrEdiLogVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.23 
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OpfPrnrEdiLogVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OpfPrnrEdiLogVO> models = new ArrayList<OpfPrnrEdiLogVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String ediSkdDirNm = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ediSndId = null;
	/* Column Info */
	private String scsFlg = null;
	/* Column Info */
	private String rsltMsg = null;
	/* Column Info */
	private String ediVslNm = null;
	/* Column Info */
	private String rcvDt = null;
	/* Column Info */
	private String crrNm = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String rcvSeq = null;
	/* Column Info */
	private String ediMsgTpId = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public OpfPrnrEdiLogVO() {}

	public OpfPrnrEdiLogVO(String ibflag, String pagerows, String rcvDt, String rcvSeq, String ediMsgTpId, String ediSndId, String crrNm, String ediVslNm, String ediSkdDirNm, String scsFlg, String rsltMsg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.ediSkdDirNm = ediSkdDirNm;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.ediSndId = ediSndId;
		this.scsFlg = scsFlg;
		this.rsltMsg = rsltMsg;
		this.ediVslNm = ediVslNm;
		this.rcvDt = rcvDt;
		this.crrNm = crrNm;
		this.creDt = creDt;
		this.rcvSeq = rcvSeq;
		this.ediMsgTpId = ediMsgTpId;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("edi_skd_dir_nm", getEdiSkdDirNm());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("edi_snd_id", getEdiSndId());
		this.hashColumns.put("scs_flg", getScsFlg());
		this.hashColumns.put("rslt_msg", getRsltMsg());
		this.hashColumns.put("edi_vsl_nm", getEdiVslNm());
		this.hashColumns.put("rcv_dt", getRcvDt());
		this.hashColumns.put("crr_nm", getCrrNm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("rcv_seq", getRcvSeq());
		this.hashColumns.put("edi_msg_tp_id", getEdiMsgTpId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("edi_skd_dir_nm", "ediSkdDirNm");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("edi_snd_id", "ediSndId");
		this.hashFields.put("scs_flg", "scsFlg");
		this.hashFields.put("rslt_msg", "rsltMsg");
		this.hashFields.put("edi_vsl_nm", "ediVslNm");
		this.hashFields.put("rcv_dt", "rcvDt");
		this.hashFields.put("crr_nm", "crrNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("rcv_seq", "rcvSeq");
		this.hashFields.put("edi_msg_tp_id", "ediMsgTpId");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pagerows", "pagerows");
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
	 * @return ediSkdDirNm
	 */
	public String getEdiSkdDirNm() {
		return this.ediSkdDirNm;
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
	 * @return ediSndId
	 */
	public String getEdiSndId() {
		return this.ediSndId;
	}
	
	/**
	 * Column Info
	 * @return scsFlg
	 */
	public String getScsFlg() {
		return this.scsFlg;
	}
	
	/**
	 * Column Info
	 * @return rsltMsg
	 */
	public String getRsltMsg() {
		return this.rsltMsg;
	}
	
	/**
	 * Column Info
	 * @return ediVslNm
	 */
	public String getEdiVslNm() {
		return this.ediVslNm;
	}
	
	/**
	 * Column Info
	 * @return rcvDt
	 */
	public String getRcvDt() {
		return this.rcvDt;
	}
	
	/**
	 * Column Info
	 * @return crrNm
	 */
	public String getCrrNm() {
		return this.crrNm;
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
	 * @return rcvSeq
	 */
	public String getRcvSeq() {
		return this.rcvSeq;
	}
	
	/**
	 * Column Info
	 * @return ediMsgTpId
	 */
	public String getEdiMsgTpId() {
		return this.ediMsgTpId;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param ediSkdDirNm
	 */
	public void setEdiSkdDirNm(String ediSkdDirNm) {
		this.ediSkdDirNm = ediSkdDirNm;
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
	 * @param ediSndId
	 */
	public void setEdiSndId(String ediSndId) {
		this.ediSndId = ediSndId;
	}
	
	/**
	 * Column Info
	 * @param scsFlg
	 */
	public void setScsFlg(String scsFlg) {
		this.scsFlg = scsFlg;
	}
	
	/**
	 * Column Info
	 * @param rsltMsg
	 */
	public void setRsltMsg(String rsltMsg) {
		this.rsltMsg = rsltMsg;
	}
	
	/**
	 * Column Info
	 * @param ediVslNm
	 */
	public void setEdiVslNm(String ediVslNm) {
		this.ediVslNm = ediVslNm;
	}
	
	/**
	 * Column Info
	 * @param rcvDt
	 */
	public void setRcvDt(String rcvDt) {
		this.rcvDt = rcvDt;
	}
	
	/**
	 * Column Info
	 * @param crrNm
	 */
	public void setCrrNm(String crrNm) {
		this.crrNm = crrNm;
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
	 * @param rcvSeq
	 */
	public void setRcvSeq(String rcvSeq) {
		this.rcvSeq = rcvSeq;
	}
	
	/**
	 * Column Info
	 * @param ediMsgTpId
	 */
	public void setEdiMsgTpId(String ediMsgTpId) {
		this.ediMsgTpId = ediMsgTpId;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setEdiSkdDirNm(JSPUtil.getParameter(request, prefix + "edi_skd_dir_nm", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEdiSndId(JSPUtil.getParameter(request, prefix + "edi_snd_id", ""));
		setScsFlg(JSPUtil.getParameter(request, prefix + "scs_flg", ""));
		setRsltMsg(JSPUtil.getParameter(request, prefix + "rslt_msg", ""));
		setEdiVslNm(JSPUtil.getParameter(request, prefix + "edi_vsl_nm", ""));
		setRcvDt(JSPUtil.getParameter(request, prefix + "rcv_dt", ""));
		setCrrNm(JSPUtil.getParameter(request, prefix + "crr_nm", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setRcvSeq(JSPUtil.getParameter(request, prefix + "rcv_seq", ""));
		setEdiMsgTpId(JSPUtil.getParameter(request, prefix + "edi_msg_tp_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OpfPrnrEdiLogVO[]
	 */
	public OpfPrnrEdiLogVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OpfPrnrEdiLogVO[]
	 */
	public OpfPrnrEdiLogVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OpfPrnrEdiLogVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] ediSkdDirNm = (JSPUtil.getParameter(request, prefix	+ "edi_skd_dir_nm", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ediSndId = (JSPUtil.getParameter(request, prefix	+ "edi_snd_id", length));
			String[] scsFlg = (JSPUtil.getParameter(request, prefix	+ "scs_flg", length));
			String[] rsltMsg = (JSPUtil.getParameter(request, prefix	+ "rslt_msg", length));
			String[] ediVslNm = (JSPUtil.getParameter(request, prefix	+ "edi_vsl_nm", length));
			String[] rcvDt = (JSPUtil.getParameter(request, prefix	+ "rcv_dt", length));
			String[] crrNm = (JSPUtil.getParameter(request, prefix	+ "crr_nm", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] rcvSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_seq", length));
			String[] ediMsgTpId = (JSPUtil.getParameter(request, prefix	+ "edi_msg_tp_id", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new OpfPrnrEdiLogVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ediSkdDirNm[i] != null)
					model.setEdiSkdDirNm(ediSkdDirNm[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ediSndId[i] != null)
					model.setEdiSndId(ediSndId[i]);
				if (scsFlg[i] != null)
					model.setScsFlg(scsFlg[i]);
				if (rsltMsg[i] != null)
					model.setRsltMsg(rsltMsg[i]);
				if (ediVslNm[i] != null)
					model.setEdiVslNm(ediVslNm[i]);
				if (rcvDt[i] != null)
					model.setRcvDt(rcvDt[i]);
				if (crrNm[i] != null)
					model.setCrrNm(crrNm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (rcvSeq[i] != null)
					model.setRcvSeq(rcvSeq[i]);
				if (ediMsgTpId[i] != null)
					model.setEdiMsgTpId(ediMsgTpId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOpfPrnrEdiLogVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OpfPrnrEdiLogVO[]
	 */
	public OpfPrnrEdiLogVO[] getOpfPrnrEdiLogVOs(){
		OpfPrnrEdiLogVO[] vos = (OpfPrnrEdiLogVO[])models.toArray(new OpfPrnrEdiLogVO[models.size()]);
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
		this.ediSkdDirNm = this.ediSkdDirNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndId = this.ediSndId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scsFlg = this.scsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsltMsg = this.rsltMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediVslNm = this.ediVslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDt = this.rcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrNm = this.crrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvSeq = this.rcvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediMsgTpId = this.ediMsgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
