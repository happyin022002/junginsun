/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ChinaAckVO.java
*@FileTitle : ChinaAckVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.30
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2014.05.30 김상수 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.vo;

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
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ChinaAckVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ChinaAckVO> models = new ArrayList<ChinaAckVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String msgKind = null;
	/* Column Info */
	private String ackUpdDt = null;
	/* Column Info */
	private String ackImoNo = null;
	/* Column Info */
	private String chnCstmsAckTpCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String ackCtnt = null;
	/* Column Info */
	private String ediRefId = null;
	/* Column Info */
	private String ackRcvDt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ChinaAckVO() {}

	public ChinaAckVO(String ibflag, String pagerows, String ackUpdDt, String ackImoNo, String chnCstmsAckTpCd, String cntrNo, String ackCtnt, String ediRefId, String blNo, String ackRcvDt, String msgKind) {
		this.ibflag = ibflag;
		this.msgKind = msgKind;
		this.ackUpdDt = ackUpdDt;
		this.ackImoNo = ackImoNo;
		this.chnCstmsAckTpCd = chnCstmsAckTpCd;
		this.cntrNo = cntrNo;
		this.ackCtnt = ackCtnt;
		this.ediRefId = ediRefId;
		this.ackRcvDt = ackRcvDt;
		this.blNo = blNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("msg_kind", getMsgKind());
		this.hashColumns.put("ack_upd_dt", getAckUpdDt());
		this.hashColumns.put("ack_imo_no", getAckImoNo());
		this.hashColumns.put("chn_cstms_ack_tp_cd", getChnCstmsAckTpCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("ack_ctnt", getAckCtnt());
		this.hashColumns.put("edi_ref_id", getEdiRefId());
		this.hashColumns.put("ack_rcv_dt", getAckRcvDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("msg_kind", "msgKind");
		this.hashFields.put("ack_upd_dt", "ackUpdDt");
		this.hashFields.put("ack_imo_no", "ackImoNo");
		this.hashFields.put("chn_cstms_ack_tp_cd", "chnCstmsAckTpCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("ack_ctnt", "ackCtnt");
		this.hashFields.put("edi_ref_id", "ediRefId");
		this.hashFields.put("ack_rcv_dt", "ackRcvDt");
		this.hashFields.put("bl_no", "blNo");
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
	 * @return msgKind
	 */
	public String getMsgKind() {
		return this.msgKind;
	}
	
	/**
	 * Column Info
	 * @return ackUpdDt
	 */
	public String getAckUpdDt() {
		return this.ackUpdDt;
	}
	
	/**
	 * Column Info
	 * @return ackImoNo
	 */
	public String getAckImoNo() {
		return this.ackImoNo;
	}
	
	/**
	 * Column Info
	 * @return chnCstmsAckTpCd
	 */
	public String getChnCstmsAckTpCd() {
		return this.chnCstmsAckTpCd;
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
	 * @return ackCtnt
	 */
	public String getAckCtnt() {
		return this.ackCtnt;
	}
	
	/**
	 * Column Info
	 * @return ediRefId
	 */
	public String getEdiRefId() {
		return this.ediRefId;
	}
	
	/**
	 * Column Info
	 * @return ackRcvDt
	 */
	public String getAckRcvDt() {
		return this.ackRcvDt;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @param msgKind
	 */
	public void setMsgKind(String msgKind) {
		this.msgKind = msgKind;
	}
	
	/**
	 * Column Info
	 * @param ackUpdDt
	 */
	public void setAckUpdDt(String ackUpdDt) {
		this.ackUpdDt = ackUpdDt;
	}
	
	/**
	 * Column Info
	 * @param ackImoNo
	 */
	public void setAckImoNo(String ackImoNo) {
		this.ackImoNo = ackImoNo;
	}
	
	/**
	 * Column Info
	 * @param chnCstmsAckTpCd
	 */
	public void setChnCstmsAckTpCd(String chnCstmsAckTpCd) {
		this.chnCstmsAckTpCd = chnCstmsAckTpCd;
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
	 * @param ackCtnt
	 */
	public void setAckCtnt(String ackCtnt) {
		this.ackCtnt = ackCtnt;
	}
	
	/**
	 * Column Info
	 * @param ediRefId
	 */
	public void setEdiRefId(String ediRefId) {
		this.ediRefId = ediRefId;
	}
	
	/**
	 * Column Info
	 * @param ackRcvDt
	 */
	public void setAckRcvDt(String ackRcvDt) {
		this.ackRcvDt = ackRcvDt;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
		setMsgKind(JSPUtil.getParameter(request, prefix + "msg_kind", ""));
		setAckUpdDt(JSPUtil.getParameter(request, prefix + "ack_upd_dt", ""));
		setAckImoNo(JSPUtil.getParameter(request, prefix + "ack_imo_no", ""));
		setChnCstmsAckTpCd(JSPUtil.getParameter(request, prefix + "chn_cstms_ack_tp_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setAckCtnt(JSPUtil.getParameter(request, prefix + "ack_ctnt", ""));
		setEdiRefId(JSPUtil.getParameter(request, prefix + "edi_ref_id", ""));
		setAckRcvDt(JSPUtil.getParameter(request, prefix + "ack_rcv_dt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChinaAckVO[]
	 */
	public ChinaAckVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ChinaAckVO[]
	 */
	public ChinaAckVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChinaAckVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] msgKind = (JSPUtil.getParameter(request, prefix	+ "msg_kind", length));
			String[] ackUpdDt = (JSPUtil.getParameter(request, prefix	+ "ack_upd_dt", length));
			String[] ackImoNo = (JSPUtil.getParameter(request, prefix	+ "ack_imo_no", length));
			String[] chnCstmsAckTpCd = (JSPUtil.getParameter(request, prefix	+ "chn_cstms_ack_tp_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] ackCtnt = (JSPUtil.getParameter(request, prefix	+ "ack_ctnt", length));
			String[] ediRefId = (JSPUtil.getParameter(request, prefix	+ "edi_ref_id", length));
			String[] ackRcvDt = (JSPUtil.getParameter(request, prefix	+ "ack_rcv_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ChinaAckVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (msgKind[i] != null)
					model.setMsgKind(msgKind[i]);
				if (ackUpdDt[i] != null)
					model.setAckUpdDt(ackUpdDt[i]);
				if (ackImoNo[i] != null)
					model.setAckImoNo(ackImoNo[i]);
				if (chnCstmsAckTpCd[i] != null)
					model.setChnCstmsAckTpCd(chnCstmsAckTpCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (ackCtnt[i] != null)
					model.setAckCtnt(ackCtnt[i]);
				if (ediRefId[i] != null)
					model.setEdiRefId(ediRefId[i]);
				if (ackRcvDt[i] != null)
					model.setAckRcvDt(ackRcvDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChinaAckVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChinaAckVO[]
	 */
	public ChinaAckVO[] getChinaAckVOs(){
		ChinaAckVO[] vos = (ChinaAckVO[])models.toArray(new ChinaAckVO[models.size()]);
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
		this.msgKind = this.msgKind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackUpdDt = this.ackUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackImoNo = this.ackImoNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chnCstmsAckTpCd = this.chnCstmsAckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackCtnt = this.ackCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRefId = this.ediRefId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackRcvDt = this.ackRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
