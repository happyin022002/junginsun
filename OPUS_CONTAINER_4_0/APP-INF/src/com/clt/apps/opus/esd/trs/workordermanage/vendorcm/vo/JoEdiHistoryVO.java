/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JoEdiHistoryVO.java
*@FileTitle : JoEdiHistoryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.03  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.trs.workordermanage.vendorcm.vo;

import java.lang.reflect.Field;
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

public class JoEdiHistoryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<JoEdiHistoryVO> models = new ArrayList<JoEdiHistoryVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String msgBndNm = null;
	/* Column Info */
	private String soNo = null;
	/* Column Info */
	private String ediMsgSeq = null;
	/* Column Info */
	private String trspWoSeq = null;
	/* Column Info */
	private String trspSoSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String loclCreDt = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String msgTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String trspSoOfcCtyCd = null;
	/* Column Info */
	private String trspWoOfcCtyCd = null;
	/* Column Info */
	private String msgTpNm = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String woNo = null;
	/* Column Info */
	private String msgBndCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public JoEdiHistoryVO() {}

	public JoEdiHistoryVO(String ibflag, String pagerows, String trspSoOfcCtyCd, String trspSoSeq, String soNo, String ediMsgSeq, String trspWoOfcCtyCd, String trspWoSeq, String woNo, String vndrSeq, String vndrLglEngNm, String msgBndCd, String msgBndNm, String msgTpCd, String msgTpNm, String loclCreDt, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.msgBndNm = msgBndNm;
		this.soNo = soNo;
		this.ediMsgSeq = ediMsgSeq;
		this.trspWoSeq = trspWoSeq;
		this.trspSoSeq = trspSoSeq;
		this.creDt = creDt;
		this.loclCreDt = loclCreDt;
		this.vndrLglEngNm = vndrLglEngNm;
		this.msgTpCd = msgTpCd;
		this.pagerows = pagerows;
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
		this.trspWoOfcCtyCd = trspWoOfcCtyCd;
		this.msgTpNm = msgTpNm;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.vndrSeq = vndrSeq;
		this.woNo = woNo;
		this.msgBndCd = msgBndCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("msg_bnd_nm", getMsgBndNm());
		this.hashColumns.put("so_no", getSoNo());
		this.hashColumns.put("edi_msg_seq", getEdiMsgSeq());
		this.hashColumns.put("trsp_wo_seq", getTrspWoSeq());
		this.hashColumns.put("trsp_so_seq", getTrspSoSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("locl_cre_dt", getLoclCreDt());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("msg_tp_cd", getMsgTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("trsp_so_ofc_cty_cd", getTrspSoOfcCtyCd());
		this.hashColumns.put("trsp_wo_ofc_cty_cd", getTrspWoOfcCtyCd());
		this.hashColumns.put("msg_tp_nm", getMsgTpNm());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("wo_no", getWoNo());
		this.hashColumns.put("msg_bnd_cd", getMsgBndCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("msg_bnd_nm", "msgBndNm");
		this.hashFields.put("so_no", "soNo");
		this.hashFields.put("edi_msg_seq", "ediMsgSeq");
		this.hashFields.put("trsp_wo_seq", "trspWoSeq");
		this.hashFields.put("trsp_so_seq", "trspSoSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("locl_cre_dt", "loclCreDt");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("msg_tp_cd", "msgTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("trsp_so_ofc_cty_cd", "trspSoOfcCtyCd");
		this.hashFields.put("trsp_wo_ofc_cty_cd", "trspWoOfcCtyCd");
		this.hashFields.put("msg_tp_nm", "msgTpNm");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("wo_no", "woNo");
		this.hashFields.put("msg_bnd_cd", "msgBndCd");
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
	 * @return msgBndNm
	 */
	public String getMsgBndNm() {
		return this.msgBndNm;
	}
	
	/**
	 * Column Info
	 * @return soNo
	 */
	public String getSoNo() {
		return this.soNo;
	}
	
	/**
	 * Column Info
	 * @return ediMsgSeq
	 */
	public String getEdiMsgSeq() {
		return this.ediMsgSeq;
	}
	
	/**
	 * Column Info
	 * @return trspWoSeq
	 */
	public String getTrspWoSeq() {
		return this.trspWoSeq;
	}
	
	/**
	 * Column Info
	 * @return trspSoSeq
	 */
	public String getTrspSoSeq() {
		return this.trspSoSeq;
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
	 * @return loclCreDt
	 */
	public String getLoclCreDt() {
		return this.loclCreDt;
	}
	
	/**
	 * Column Info
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return msgTpCd
	 */
	public String getMsgTpCd() {
		return this.msgTpCd;
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
	 * @return trspSoOfcCtyCd
	 */
	public String getTrspSoOfcCtyCd() {
		return this.trspSoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return trspWoOfcCtyCd
	 */
	public String getTrspWoOfcCtyCd() {
		return this.trspWoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return msgTpNm
	 */
	public String getMsgTpNm() {
		return this.msgTpNm;
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return woNo
	 */
	public String getWoNo() {
		return this.woNo;
	}
	
	/**
	 * Column Info
	 * @return msgBndCd
	 */
	public String getMsgBndCd() {
		return this.msgBndCd;
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
	 * @param msgBndNm
	 */
	public void setMsgBndNm(String msgBndNm) {
		this.msgBndNm = msgBndNm;
	}
	
	/**
	 * Column Info
	 * @param soNo
	 */
	public void setSoNo(String soNo) {
		this.soNo = soNo;
	}
	
	/**
	 * Column Info
	 * @param ediMsgSeq
	 */
	public void setEdiMsgSeq(String ediMsgSeq) {
		this.ediMsgSeq = ediMsgSeq;
	}
	
	/**
	 * Column Info
	 * @param trspWoSeq
	 */
	public void setTrspWoSeq(String trspWoSeq) {
		this.trspWoSeq = trspWoSeq;
	}
	
	/**
	 * Column Info
	 * @param trspSoSeq
	 */
	public void setTrspSoSeq(String trspSoSeq) {
		this.trspSoSeq = trspSoSeq;
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
	 * @param loclCreDt
	 */
	public void setLoclCreDt(String loclCreDt) {
		this.loclCreDt = loclCreDt;
	}
	
	/**
	 * Column Info
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param msgTpCd
	 */
	public void setMsgTpCd(String msgTpCd) {
		this.msgTpCd = msgTpCd;
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
	 * @param trspSoOfcCtyCd
	 */
	public void setTrspSoOfcCtyCd(String trspSoOfcCtyCd) {
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param trspWoOfcCtyCd
	 */
	public void setTrspWoOfcCtyCd(String trspWoOfcCtyCd) {
		this.trspWoOfcCtyCd = trspWoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param msgTpNm
	 */
	public void setMsgTpNm(String msgTpNm) {
		this.msgTpNm = msgTpNm;
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
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param woNo
	 */
	public void setWoNo(String woNo) {
		this.woNo = woNo;
	}
	
	/**
	 * Column Info
	 * @param msgBndCd
	 */
	public void setMsgBndCd(String msgBndCd) {
		this.msgBndCd = msgBndCd;
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
		setMsgBndNm(JSPUtil.getParameter(request, prefix + "msg_bnd_nm", ""));
		setSoNo(JSPUtil.getParameter(request, prefix + "so_no", ""));
		setEdiMsgSeq(JSPUtil.getParameter(request, prefix + "edi_msg_seq", ""));
		setTrspWoSeq(JSPUtil.getParameter(request, prefix + "trsp_wo_seq", ""));
		setTrspSoSeq(JSPUtil.getParameter(request, prefix + "trsp_so_seq", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setLoclCreDt(JSPUtil.getParameter(request, prefix + "locl_cre_dt", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
		setMsgTpCd(JSPUtil.getParameter(request, prefix + "msg_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTrspSoOfcCtyCd(JSPUtil.getParameter(request, prefix + "trsp_so_ofc_cty_cd", ""));
		setTrspWoOfcCtyCd(JSPUtil.getParameter(request, prefix + "trsp_wo_ofc_cty_cd", ""));
		setMsgTpNm(JSPUtil.getParameter(request, prefix + "msg_tp_nm", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setWoNo(JSPUtil.getParameter(request, prefix + "wo_no", ""));
		setMsgBndCd(JSPUtil.getParameter(request, prefix + "msg_bnd_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return JoEdiHistoryVO[]
	 */
	public JoEdiHistoryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return JoEdiHistoryVO[]
	 */
	public JoEdiHistoryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		JoEdiHistoryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] msgBndNm = (JSPUtil.getParameter(request, prefix	+ "msg_bnd_nm", length));
			String[] soNo = (JSPUtil.getParameter(request, prefix	+ "so_no", length));
			String[] ediMsgSeq = (JSPUtil.getParameter(request, prefix	+ "edi_msg_seq", length));
			String[] trspWoSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_wo_seq", length));
			String[] trspSoSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_so_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] loclCreDt = (JSPUtil.getParameter(request, prefix	+ "locl_cre_dt", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] msgTpCd = (JSPUtil.getParameter(request, prefix	+ "msg_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] trspSoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_ofc_cty_cd", length));
			String[] trspWoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_wo_ofc_cty_cd", length));
			String[] msgTpNm = (JSPUtil.getParameter(request, prefix	+ "msg_tp_nm", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] woNo = (JSPUtil.getParameter(request, prefix	+ "wo_no", length));
			String[] msgBndCd = (JSPUtil.getParameter(request, prefix	+ "msg_bnd_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new JoEdiHistoryVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (msgBndNm[i] != null)
					model.setMsgBndNm(msgBndNm[i]);
				if (soNo[i] != null)
					model.setSoNo(soNo[i]);
				if (ediMsgSeq[i] != null)
					model.setEdiMsgSeq(ediMsgSeq[i]);
				if (trspWoSeq[i] != null)
					model.setTrspWoSeq(trspWoSeq[i]);
				if (trspSoSeq[i] != null)
					model.setTrspSoSeq(trspSoSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (loclCreDt[i] != null)
					model.setLoclCreDt(loclCreDt[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (msgTpCd[i] != null)
					model.setMsgTpCd(msgTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (trspSoOfcCtyCd[i] != null)
					model.setTrspSoOfcCtyCd(trspSoOfcCtyCd[i]);
				if (trspWoOfcCtyCd[i] != null)
					model.setTrspWoOfcCtyCd(trspWoOfcCtyCd[i]);
				if (msgTpNm[i] != null)
					model.setMsgTpNm(msgTpNm[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (woNo[i] != null)
					model.setWoNo(woNo[i]);
				if (msgBndCd[i] != null)
					model.setMsgBndCd(msgBndCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getJoEdiHistoryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return JoEdiHistoryVO[]
	 */
	public JoEdiHistoryVO[] getJoEdiHistoryVOs(){
		JoEdiHistoryVO[] vos = (JoEdiHistoryVO[])models.toArray(new JoEdiHistoryVO[models.size()]);
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
		this.msgBndNm = this.msgBndNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soNo = this.soNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediMsgSeq = this.ediMsgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspWoSeq = this.trspWoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoSeq = this.trspSoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCreDt = this.loclCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgTpCd = this.msgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoOfcCtyCd = this.trspSoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspWoOfcCtyCd = this.trspWoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgTpNm = this.msgTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNo = this.woNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgBndCd = this.msgBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
