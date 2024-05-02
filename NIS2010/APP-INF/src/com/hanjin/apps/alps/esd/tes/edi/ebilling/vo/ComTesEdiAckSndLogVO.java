/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : TesEdiAckSndLogVO.java
*@FileTitle : TesEdiAckSndLogVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2013.02.15  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.tes.edi.ebilling.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ComTesEdiAckSndLogVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ComTesEdiAckSndLogVO> models = new ArrayList<ComTesEdiAckSndLogVO>();
	
	/* flat file */
	private String ff = null;

	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String ackActTpCd = null;
	/* Column Info */
	private String rcvrId = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String ackSndStsCd = null;
	/* Column Info */
	private String ediMsg = null;
	/* Column Info */
	private String ediRmk = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String sndLogSeq = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String actSndDt = null;
	/* Column Info */
	private String sndrId = null;
	/* Column Info */
	private String fileSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String ediSndDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ComTesEdiAckSndLogVO() {}

	public ComTesEdiAckSndLogVO(String ibflag, String pagerows, String ediSndDt, String sndLogSeq, String actSndDt, String ackSndStsCd, String ackActTpCd, String ediMsg, String rcvrId, String sndrId, String fileSeq, String vndrSeq, String ofcCd, String ediRmk, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.ackActTpCd = ackActTpCd;
		this.rcvrId = rcvrId;
		this.creDt = creDt;
		this.ackSndStsCd = ackSndStsCd;
		this.ediMsg = ediMsg;
		this.ediRmk = ediRmk;
		this.pagerows = pagerows;
		this.sndLogSeq = sndLogSeq;
		this.ofcCd = ofcCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.vndrSeq = vndrSeq;
		this.actSndDt = actSndDt;
		this.sndrId = sndrId;
		this.fileSeq = fileSeq;
		this.updUsrId = updUsrId;
		this.ediSndDt = ediSndDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ack_act_tp_cd", getAckActTpCd());
		this.hashColumns.put("rcvr_id", getRcvrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("ack_snd_sts_cd", getAckSndStsCd());
		this.hashColumns.put("edi_msg", getEdiMsg());
		this.hashColumns.put("edi_rmk", getEdiRmk());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("snd_log_seq", getSndLogSeq());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("act_snd_dt", getActSndDt());
		this.hashColumns.put("sndr_id", getSndrId());
		this.hashColumns.put("file_seq", getFileSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("edi_snd_dt", getEdiSndDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ack_act_tp_cd", "ackActTpCd");
		this.hashFields.put("rcvr_id", "rcvrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("ack_snd_sts_cd", "ackSndStsCd");
		this.hashFields.put("edi_msg", "ediMsg");
		this.hashFields.put("edi_rmk", "ediRmk");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("snd_log_seq", "sndLogSeq");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("act_snd_dt", "actSndDt");
		this.hashFields.put("sndr_id", "sndrId");
		this.hashFields.put("file_seq", "fileSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("edi_snd_dt", "ediSndDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ff
	 */
	public String getFF() {
		return this.ff;
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
	 * @return ackActTpCd
	 */
	public String getAckActTpCd() {
		return this.ackActTpCd;
	}
	
	/**
	 * Column Info
	 * @return rcvrId
	 */
	public String getRcvrId() {
		return this.rcvrId;
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
	 * @return ackSndStsCd
	 */
	public String getAckSndStsCd() {
		return this.ackSndStsCd;
	}
	
	/**
	 * Column Info
	 * @return ediMsg
	 */
	public String getEdiMsg() {
		return this.ediMsg;
	}
	
	/**
	 * Column Info
	 * @return ediRmk
	 */
	public String getEdiRmk() {
		return this.ediRmk;
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
	 * @return sndLogSeq
	 */
	public String getSndLogSeq() {
		return this.sndLogSeq;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return actSndDt
	 */
	public String getActSndDt() {
		return this.actSndDt;
	}
	
	/**
	 * Column Info
	 * @return sndrId
	 */
	public String getSndrId() {
		return this.sndrId;
	}
	
	/**
	 * Column Info
	 * @return fileSeq
	 */
	public String getFileSeq() {
		return this.fileSeq;
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
	 * @return ediSndDt
	 */
	public String getEdiSndDt() {
		return this.ediSndDt;
	}

	
	/**
	 * Column Info
	 * @param ff
	 */
	public void setFF(String ff) {
		this.ff = ff;
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
	 * @param ackActTpCd
	 */
	public void setAckActTpCd(String ackActTpCd) {
		this.ackActTpCd = ackActTpCd;
	}
	
	/**
	 * Column Info
	 * @param rcvrId
	 */
	public void setRcvrId(String rcvrId) {
		this.rcvrId = rcvrId;
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
	 * @param ackSndStsCd
	 */
	public void setAckSndStsCd(String ackSndStsCd) {
		this.ackSndStsCd = ackSndStsCd;
	}
	
	/**
	 * Column Info
	 * @param ediMsg
	 */
	public void setEdiMsg(String ediMsg) {
		this.ediMsg = ediMsg;
	}
	
	/**
	 * Column Info
	 * @param ediRmk
	 */
	public void setEdiRmk(String ediRmk) {
		this.ediRmk = ediRmk;
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
	 * @param sndLogSeq
	 */
	public void setSndLogSeq(String sndLogSeq) {
		this.sndLogSeq = sndLogSeq;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param actSndDt
	 */
	public void setActSndDt(String actSndDt) {
		this.actSndDt = actSndDt;
	}
	
	/**
	 * Column Info
	 * @param sndrId
	 */
	public void setSndrId(String sndrId) {
		this.sndrId = sndrId;
	}
	
	/**
	 * Column Info
	 * @param fileSeq
	 */
	public void setFileSeq(String fileSeq) {
		this.fileSeq = fileSeq;
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
	 * @param ediSndDt
	 */
	public void setEdiSndDt(String ediSndDt) {
		this.ediSndDt = ediSndDt;
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
		setAckActTpCd(JSPUtil.getParameter(request, prefix + "ack_act_tp_cd", ""));
		setRcvrId(JSPUtil.getParameter(request, prefix + "rcvr_id", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setAckSndStsCd(JSPUtil.getParameter(request, prefix + "ack_snd_sts_cd", ""));
		setEdiMsg(JSPUtil.getParameter(request, prefix + "edi_msg", ""));
		setEdiRmk(JSPUtil.getParameter(request, prefix + "edi_rmk", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSndLogSeq(JSPUtil.getParameter(request, prefix + "snd_log_seq", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setActSndDt(JSPUtil.getParameter(request, prefix + "act_snd_dt", ""));
		setSndrId(JSPUtil.getParameter(request, prefix + "sndr_id", ""));
		setFileSeq(JSPUtil.getParameter(request, prefix + "file_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setEdiSndDt(JSPUtil.getParameter(request, prefix + "edi_snd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TesEdiAckSndLogVO[]
	 */
	public ComTesEdiAckSndLogVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TesEdiAckSndLogVO[]
	 */
	public ComTesEdiAckSndLogVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ComTesEdiAckSndLogVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] ackActTpCd = (JSPUtil.getParameter(request, prefix	+ "ack_act_tp_cd", length));
			String[] rcvrId = (JSPUtil.getParameter(request, prefix	+ "rcvr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] ackSndStsCd = (JSPUtil.getParameter(request, prefix	+ "ack_snd_sts_cd", length));
			String[] ediMsg = (JSPUtil.getParameter(request, prefix	+ "edi_msg", length));
			String[] ediRmk = (JSPUtil.getParameter(request, prefix	+ "edi_rmk", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] sndLogSeq = (JSPUtil.getParameter(request, prefix	+ "snd_log_seq", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] actSndDt = (JSPUtil.getParameter(request, prefix	+ "act_snd_dt", length));
			String[] sndrId = (JSPUtil.getParameter(request, prefix	+ "sndr_id", length));
			String[] fileSeq = (JSPUtil.getParameter(request, prefix	+ "file_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] ediSndDt = (JSPUtil.getParameter(request, prefix	+ "edi_snd_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new ComTesEdiAckSndLogVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ackActTpCd[i] != null)
					model.setAckActTpCd(ackActTpCd[i]);
				if (rcvrId[i] != null)
					model.setRcvrId(rcvrId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (ackSndStsCd[i] != null)
					model.setAckSndStsCd(ackSndStsCd[i]);
				if (ediMsg[i] != null)
					model.setEdiMsg(ediMsg[i]);
				if (ediRmk[i] != null)
					model.setEdiRmk(ediRmk[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (sndLogSeq[i] != null)
					model.setSndLogSeq(sndLogSeq[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (actSndDt[i] != null)
					model.setActSndDt(actSndDt[i]);
				if (sndrId[i] != null)
					model.setSndrId(sndrId[i]);
				if (fileSeq[i] != null)
					model.setFileSeq(fileSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (ediSndDt[i] != null)
					model.setEdiSndDt(ediSndDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTesEdiAckSndLogVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TesEdiAckSndLogVO[]
	 */
	public ComTesEdiAckSndLogVO[] getTesEdiAckSndLogVOs(){
		ComTesEdiAckSndLogVO[] vos = (ComTesEdiAckSndLogVO[])models.toArray(new ComTesEdiAckSndLogVO[models.size()]);
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
		this.ackActTpCd = this.ackActTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrId = this.rcvrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackSndStsCd = this.ackSndStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediMsg = this.ediMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRmk = this.ediRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndLogSeq = this.sndLogSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actSndDt = this.actSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndrId = this.sndrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSeq = this.fileSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndDt = this.ediSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
