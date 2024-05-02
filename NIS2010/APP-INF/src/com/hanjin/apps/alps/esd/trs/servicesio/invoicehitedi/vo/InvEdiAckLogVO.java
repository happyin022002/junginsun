/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvEdiAckLogVO.java
*@FileTitle : InvEdiAckLogVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.04
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.07.04 신동일 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.vo;

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
 * @author 신동일
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InvEdiAckLogVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvEdiAckLogVO> models = new ArrayList<InvEdiAckLogVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String invEdiSndDt = null;
	/* Column Info */
	private String rcvrId = null;
	/* Column Info */
	private String invEdiSndLogSeq = null;
	/* Column Info */
	private String sndrId = null;
	/* Column Info */
	private String ediMsg = null;
	/* Column Info */
	private String ackSndStsCd = null;
	/* Column Info */
	private String actSndDt = null;
	/* Column Info */
	private String fileSeq = null;
	/* Column Info */
	private String ediRmk = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public InvEdiAckLogVO() {}

	public InvEdiAckLogVO(String ibflag, String pagerows, String invEdiSndDt, String invEdiSndLogSeq, String actSndDt, String ackSndStsCd, String ediMsg, String rcvrId, String sndrId, String ediRmk, String fileSeq) {
		this.ibflag = ibflag;
		this.invEdiSndDt = invEdiSndDt;
		this.rcvrId = rcvrId;
		this.invEdiSndLogSeq = invEdiSndLogSeq;
		this.sndrId = sndrId;
		this.ediMsg = ediMsg;
		this.ackSndStsCd = ackSndStsCd;
		this.actSndDt = actSndDt;
		this.fileSeq = fileSeq;
		this.ediRmk = ediRmk;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("inv_edi_snd_dt", getInvEdiSndDt());
		this.hashColumns.put("rcvr_id", getRcvrId());
		this.hashColumns.put("inv_edi_snd_log_seq", getInvEdiSndLogSeq());
		this.hashColumns.put("sndr_id", getSndrId());
		this.hashColumns.put("edi_msg", getEdiMsg());
		this.hashColumns.put("ack_snd_sts_cd", getAckSndStsCd());
		this.hashColumns.put("act_snd_dt", getActSndDt());
		this.hashColumns.put("file_seq", getFileSeq());
		this.hashColumns.put("edi_rmk", getEdiRmk());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inv_edi_snd_dt", "invEdiSndDt");
		this.hashFields.put("rcvr_id", "rcvrId");
		this.hashFields.put("inv_edi_snd_log_seq", "invEdiSndLogSeq");
		this.hashFields.put("sndr_id", "sndrId");
		this.hashFields.put("edi_msg", "ediMsg");
		this.hashFields.put("ack_snd_sts_cd", "ackSndStsCd");
		this.hashFields.put("act_snd_dt", "actSndDt");
		this.hashFields.put("file_seq", "fileSeq");
		this.hashFields.put("edi_rmk", "ediRmk");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return invEdiSndDt
	 */
	public String getInvEdiSndDt() {
		return this.invEdiSndDt;
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
	 * @return invEdiSndLogSeq
	 */
	public String getInvEdiSndLogSeq() {
		return this.invEdiSndLogSeq;
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
	 * @return ediMsg
	 */
	public String getEdiMsg() {
		return this.ediMsg;
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
	 * @return actSndDt
	 */
	public String getActSndDt() {
		return this.actSndDt;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param invEdiSndDt
	 */
	public void setInvEdiSndDt(String invEdiSndDt) {
		this.invEdiSndDt = invEdiSndDt;
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
	 * @param invEdiSndLogSeq
	 */
	public void setInvEdiSndLogSeq(String invEdiSndLogSeq) {
		this.invEdiSndLogSeq = invEdiSndLogSeq;
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
	 * @param ediMsg
	 */
	public void setEdiMsg(String ediMsg) {
		this.ediMsg = ediMsg;
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
	 * @param actSndDt
	 */
	public void setActSndDt(String actSndDt) {
		this.actSndDt = actSndDt;
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
		setInvEdiSndDt(JSPUtil.getParameter(request, prefix + "inv_edi_snd_dt", ""));
		setRcvrId(JSPUtil.getParameter(request, prefix + "rcvr_id", ""));
		setInvEdiSndLogSeq(JSPUtil.getParameter(request, prefix + "inv_edi_snd_log_seq", ""));
		setSndrId(JSPUtil.getParameter(request, prefix + "sndr_id", ""));
		setEdiMsg(JSPUtil.getParameter(request, prefix + "edi_msg", ""));
		setAckSndStsCd(JSPUtil.getParameter(request, prefix + "ack_snd_sts_cd", ""));
		setActSndDt(JSPUtil.getParameter(request, prefix + "act_snd_dt", ""));
		setFileSeq(JSPUtil.getParameter(request, prefix + "file_seq", ""));
		setEdiRmk(JSPUtil.getParameter(request, prefix + "edi_rmk", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvEdiAckLogVO[]
	 */
	public InvEdiAckLogVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvEdiAckLogVO[]
	 */
	public InvEdiAckLogVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvEdiAckLogVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] invEdiSndDt = (JSPUtil.getParameter(request, prefix	+ "inv_edi_snd_dt", length));
			String[] rcvrId = (JSPUtil.getParameter(request, prefix	+ "rcvr_id", length));
			String[] invEdiSndLogSeq = (JSPUtil.getParameter(request, prefix	+ "inv_edi_snd_log_seq", length));
			String[] sndrId = (JSPUtil.getParameter(request, prefix	+ "sndr_id", length));
			String[] ediMsg = (JSPUtil.getParameter(request, prefix	+ "edi_msg", length));
			String[] ackSndStsCd = (JSPUtil.getParameter(request, prefix	+ "ack_snd_sts_cd", length));
			String[] actSndDt = (JSPUtil.getParameter(request, prefix	+ "act_snd_dt", length));
			String[] fileSeq = (JSPUtil.getParameter(request, prefix	+ "file_seq", length));
			String[] ediRmk = (JSPUtil.getParameter(request, prefix	+ "edi_rmk", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvEdiAckLogVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (invEdiSndDt[i] != null)
					model.setInvEdiSndDt(invEdiSndDt[i]);
				if (rcvrId[i] != null)
					model.setRcvrId(rcvrId[i]);
				if (invEdiSndLogSeq[i] != null)
					model.setInvEdiSndLogSeq(invEdiSndLogSeq[i]);
				if (sndrId[i] != null)
					model.setSndrId(sndrId[i]);
				if (ediMsg[i] != null)
					model.setEdiMsg(ediMsg[i]);
				if (ackSndStsCd[i] != null)
					model.setAckSndStsCd(ackSndStsCd[i]);
				if (actSndDt[i] != null)
					model.setActSndDt(actSndDt[i]);
				if (fileSeq[i] != null)
					model.setFileSeq(fileSeq[i]);
				if (ediRmk[i] != null)
					model.setEdiRmk(ediRmk[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvEdiAckLogVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvEdiAckLogVO[]
	 */
	public InvEdiAckLogVO[] getInvEdiAckLogVOs(){
		InvEdiAckLogVO[] vos = (InvEdiAckLogVO[])models.toArray(new InvEdiAckLogVO[models.size()]);
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
		this.invEdiSndDt = this.invEdiSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrId = this.rcvrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEdiSndLogSeq = this.invEdiSndLogSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndrId = this.sndrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediMsg = this.ediMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackSndStsCd = this.ackSndStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actSndDt = this.actSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSeq = this.fileSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRmk = this.ediRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
