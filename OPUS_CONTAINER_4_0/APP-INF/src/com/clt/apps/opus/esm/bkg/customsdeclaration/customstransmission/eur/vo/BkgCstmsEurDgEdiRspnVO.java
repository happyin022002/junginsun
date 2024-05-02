/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BkgCstmsEurDgEdiRspnVO.java
*@FileTitle : BkgCstmsEurDgEdiRspnVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.28
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo;

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
public class BkgCstmsEurDgEdiRspnVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgCstmsEurDgEdiRspnVO> models = new ArrayList<BkgCstmsEurDgEdiRspnVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	
	/* Page Number */
	private String pagerows = null;

	/* Column Info */
	private String eurEdiMsgTpId = null;

	/* Column Info */
	private String msgSndNo = null;

	/* Column Info */
	private String ediRspnSeq = null;

	/* Column Info */
	private String blNo = null;

	/* Column Info */
	private String cntrNo = null;

	/* Column Info */
	private String cntrCgoSeq = null;

	/* Column Info */
	private String dgBlRefNo = null;

	/* Column Info */
	private String dgItmRefNo = null;

	/* Column Info */
	private String creUsrId = null;

	/* Column Info */
	private String creDt = null;

	/* Column Info */
	private String updUsrId = null;

	/* Column Info */
	private String updDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BkgCstmsEurDgEdiRspnVO() {}

	public BkgCstmsEurDgEdiRspnVO(String ibflag, String pagerows, String eurEdiMsgTpId, String msgSndNo, String ediRspnSeq, String blNo, String cntrNo, String cntrCgoSeq, String dgBlRefNo, String dgItmRefNo, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.eurEdiMsgTpId = eurEdiMsgTpId;
		this.msgSndNo = msgSndNo;
		this.ediRspnSeq = ediRspnSeq;
		this.blNo = blNo;
		this.cntrNo = cntrNo;
		this.cntrCgoSeq = cntrCgoSeq;
		this.dgBlRefNo = dgBlRefNo;
		this.dgItmRefNo = dgItmRefNo;
		this.creUsrId = creUsrId;
		this.creDt = creDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eur_edi_msg_tp_id", getEurEdiMsgTpId());
		this.hashColumns.put("msg_snd_no", getMsgSndNo());
		this.hashColumns.put("edi_rspn_seq", getEdiRspnSeq());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_cgo_seq", getCntrCgoSeq());
		this.hashColumns.put("dg_bl_ref_no", getDgBlRefNo());
		this.hashColumns.put("dg_itm_ref_no", getDgItmRefNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eur_edi_msg_tp_id", "eurEdiMsgTpId");
		this.hashFields.put("msg_snd_no", "msgSndNo");
		this.hashFields.put("edi_rspn_seq", "ediRspnSeq");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_cgo_seq", "cntrCgoSeq");
		this.hashFields.put("dg_bl_ref_no", "dgBlRefNo");
		this.hashFields.put("dg_itm_ref_no", "dgItmRefNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		return this.hashFields;
	}
	
	/**
	 *
	 * @param String ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * 
	 * @return String ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 *
	 * @param String pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * 
	 * @return String pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 *
	 * @param String eurEdiMsgTpId
	 */
	public void setEurEdiMsgTpId(String eurEdiMsgTpId) {
		this.eurEdiMsgTpId = eurEdiMsgTpId;
	}
	
	/**
	 * 
	 * @return String eurEdiMsgTpId
	 */
	public String getEurEdiMsgTpId() {
		return this.eurEdiMsgTpId;
	}
	
	/**
	 *
	 * @param String msgSndNo
	 */
	public void setMsgSndNo(String msgSndNo) {
		this.msgSndNo = msgSndNo;
	}
	
	/**
	 * 
	 * @return String msgSndNo
	 */
	public String getMsgSndNo() {
		return this.msgSndNo;
	}
	
	/**
	 *
	 * @param String ediRspnSeq
	 */
	public void setEdiRspnSeq(String ediRspnSeq) {
		this.ediRspnSeq = ediRspnSeq;
	}
	
	/**
	 * 
	 * @return String ediRspnSeq
	 */
	public String getEdiRspnSeq() {
		return this.ediRspnSeq;
	}
	
	/**
	 *
	 * @param String blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * 
	 * @return String blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 *
	 * @param String cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * 
	 * @return String cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 *
	 * @param String cntrCgoSeq
	 */
	public void setCntrCgoSeq(String cntrCgoSeq) {
		this.cntrCgoSeq = cntrCgoSeq;
	}
	
	/**
	 * 
	 * @return String cntrCgoSeq
	 */
	public String getCntrCgoSeq() {
		return this.cntrCgoSeq;
	}
	
	/**
	 *
	 * @param String dgBlRefNo
	 */
	public void setDgBlRefNo(String dgBlRefNo) {
		this.dgBlRefNo = dgBlRefNo;
	}
	
	/**
	 * 
	 * @return String dgBlRefNo
	 */
	public String getDgBlRefNo() {
		return this.dgBlRefNo;
	}
	
	/**
	 *
	 * @param String dgItmRefNo
	 */
	public void setDgItmRefNo(String dgItmRefNo) {
		this.dgItmRefNo = dgItmRefNo;
	}
	
	/**
	 * 
	 * @return String dgItmRefNo
	 */
	public String getDgItmRefNo() {
		return this.dgItmRefNo;
	}
	
	/**
	 *
	 * @param String creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * 
	 * @return String creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 *
	 * @param String creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * 
	 * @return String creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 *
	 * @param String updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 
	 * @return String updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 *
	 * @param String updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * 
	 * @return String updDt
	 */
	public String getUpdDt() {
		return this.updDt;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEurEdiMsgTpId(JSPUtil.getParameter(request, prefix + "eur_edi_msg_tp_id", ""));
		setMsgSndNo(JSPUtil.getParameter(request, prefix + "msg_snd_no", ""));
		setEdiRspnSeq(JSPUtil.getParameter(request, prefix + "edi_rspn_seq", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCntrCgoSeq(JSPUtil.getParameter(request, prefix + "cntr_cgo_seq", ""));
		setDgBlRefNo(JSPUtil.getParameter(request, prefix + "dg_bl_ref_no", ""));
		setDgItmRefNo(JSPUtil.getParameter(request, prefix + "dg_itm_ref_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCstmsEurDgEdiRspnVO[]
	 */
	public BkgCstmsEurDgEdiRspnVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgCstmsEurDgEdiRspnVO[]
	 */
	public BkgCstmsEurDgEdiRspnVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgCstmsEurDgEdiRspnVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] eurEdiMsgTpId = (JSPUtil.getParameter(request, prefix	+ "eur_edi_msg_tp_id", length));
			String[] msgSndNo = (JSPUtil.getParameter(request, prefix	+ "msg_snd_no", length));
			String[] ediRspnSeq = (JSPUtil.getParameter(request, prefix	+ "edi_rspn_seq", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrCgoSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_cgo_seq", length));
			String[] dgBlRefNo = (JSPUtil.getParameter(request, prefix	+ "dg_bl_ref_no", length));
			String[] dgItmRefNo = (JSPUtil.getParameter(request, prefix	+ "dg_itm_ref_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			/* Add a field line, do not delete */
			
			for (int i = 0; i < length; i++) {
				model = new BkgCstmsEurDgEdiRspnVO();
				if (ibflag[i] != null) 
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null) 
					model.setPagerows(pagerows[i]);
				if (eurEdiMsgTpId[i] != null) 
					model.setEurEdiMsgTpId(eurEdiMsgTpId[i]);
				if (msgSndNo[i] != null) 
					model.setMsgSndNo(msgSndNo[i]);
				if (ediRspnSeq[i] != null) 
					model.setEdiRspnSeq(ediRspnSeq[i]);
				if (blNo[i] != null) 
					model.setBlNo(blNo[i]);
				if (cntrNo[i] != null) 
					model.setCntrNo(cntrNo[i]);
				if (cntrCgoSeq[i] != null) 
					model.setCntrCgoSeq(cntrCgoSeq[i]);
				if (dgBlRefNo[i] != null) 
					model.setDgBlRefNo(dgBlRefNo[i]);
				if (dgItmRefNo[i] != null) 
					model.setDgItmRefNo(dgItmRefNo[i]);
				if (creUsrId[i] != null) 
					model.setCreUsrId(creUsrId[i]);
				if (creDt[i] != null) 
					model.setCreDt(creDt[i]);
				if (updUsrId[i] != null) 
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null) 
					model.setUpdDt(updDt[i]);
				/* Add a Method line, do not delete */
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgCstmsEurDgEdiRspnVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgCstmsEurDgEdiRspnVO[]
	 */
	public BkgCstmsEurDgEdiRspnVO[] getBkgCstmsEurDgEdiRspnVOs(){
		BkgCstmsEurDgEdiRspnVO[] vos = (BkgCstmsEurDgEdiRspnVO[])models.toArray(new BkgCstmsEurDgEdiRspnVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eurEdiMsgTpId = this.eurEdiMsgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgSndNo = this.msgSndNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRspnSeq = this.ediRspnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCgoSeq = this.cntrCgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgBlRefNo = this.dgBlRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgItmRefNo = this.dgItmRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}