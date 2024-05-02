/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DeclBaseInfoVO.java
*@FileTitle : DeclBaseInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.06  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo;

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

public class DeclBaseInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DeclBaseInfoVO> models = new ArrayList<DeclBaseInfoVO>();
	
	/* Column Info */
	private String msgFunc = null;
	/* Column Info */
	private String partyType = null;
	/* Column Info */
	private String docNo = null;
	/* Column Info */
	private String imoNo = null;
	/* Column Info */
	private String vesselNm = null;
	/* Column Info */
	private String msgDate = null;
	/* Column Info */
	private String sendType = null;
	/* Column Info */
	private String handling = null;
	/* Column Info */
	private String transStage = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String deptEmploy = null;
	/* Column Info */
	private String comNo = null;
	/* Column Info */
	private String docCd = null;
	/* Column Info */
	private String transMode = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String refNo = null;
	/* Column Info */
	private String carrierNm = null;
	/* Column Info */
	private String voyageNo = null;
	/* Column Info */
	private String comCh = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public DeclBaseInfoVO() {}

	public DeclBaseInfoVO(String ibflag, String pagerows, String msgFunc, String partyType, String docNo, String imoNo, String vesselNm, String msgDate, String handling, String transStage, String deptEmploy, String comNo, String docCd, String transMode, String refNo, String carrierNm, String comCh, String voyageNo, String sendType) {
		this.msgFunc = msgFunc;
		this.partyType = partyType;
		this.docNo = docNo;
		this.imoNo = imoNo;
		this.vesselNm = vesselNm;
		this.msgDate = msgDate;
		this.sendType = sendType;
		this.handling = handling;
		this.transStage = transStage;
		this.pagerows = pagerows;
		this.deptEmploy = deptEmploy;
		this.comNo = comNo;
		this.docCd = docCd;
		this.transMode = transMode;
		this.ibflag = ibflag;
		this.refNo = refNo;
		this.carrierNm = carrierNm;
		this.voyageNo = voyageNo;
		this.comCh = comCh;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("msg_func", getMsgFunc());
		this.hashColumns.put("party_type", getPartyType());
		this.hashColumns.put("doc_no", getDocNo());
		this.hashColumns.put("imo_no", getImoNo());
		this.hashColumns.put("vessel_nm", getVesselNm());
		this.hashColumns.put("msg_date", getMsgDate());
		this.hashColumns.put("send_type", getSendType());
		this.hashColumns.put("handling", getHandling());
		this.hashColumns.put("trans_stage", getTransStage());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dept_employ", getDeptEmploy());
		this.hashColumns.put("com_no", getComNo());
		this.hashColumns.put("doc_cd", getDocCd());
		this.hashColumns.put("trans_mode", getTransMode());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ref_no", getRefNo());
		this.hashColumns.put("carrier_nm", getCarrierNm());
		this.hashColumns.put("voyage_no", getVoyageNo());
		this.hashColumns.put("com_ch", getComCh());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("msg_func", "msgFunc");
		this.hashFields.put("party_type", "partyType");
		this.hashFields.put("doc_no", "docNo");
		this.hashFields.put("imo_no", "imoNo");
		this.hashFields.put("vessel_nm", "vesselNm");
		this.hashFields.put("msg_date", "msgDate");
		this.hashFields.put("send_type", "sendType");
		this.hashFields.put("handling", "handling");
		this.hashFields.put("trans_stage", "transStage");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dept_employ", "deptEmploy");
		this.hashFields.put("com_no", "comNo");
		this.hashFields.put("doc_cd", "docCd");
		this.hashFields.put("trans_mode", "transMode");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("carrier_nm", "carrierNm");
		this.hashFields.put("voyage_no", "voyageNo");
		this.hashFields.put("com_ch", "comCh");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return msgFunc
	 */
	public String getMsgFunc() {
		return this.msgFunc;
	}
	
	/**
	 * Column Info
	 * @return partyType
	 */
	public String getPartyType() {
		return this.partyType;
	}
	
	/**
	 * Column Info
	 * @return docNo
	 */
	public String getDocNo() {
		return this.docNo;
	}
	
	/**
	 * Column Info
	 * @return imoNo
	 */
	public String getImoNo() {
		return this.imoNo;
	}
	
	/**
	 * Column Info
	 * @return vesselNm
	 */
	public String getVesselNm() {
		return this.vesselNm;
	}
	
	/**
	 * Column Info
	 * @return msgDate
	 */
	public String getMsgDate() {
		return this.msgDate;
	}
	
	/**
	 * Column Info
	 * @return sendType
	 */
	public String getSendType() {
		return this.sendType;
	}
	
	/**
	 * Column Info
	 * @return handling
	 */
	public String getHandling() {
		return this.handling;
	}
	
	/**
	 * Column Info
	 * @return transStage
	 */
	public String getTransStage() {
		return this.transStage;
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
	 * @return deptEmploy
	 */
	public String getDeptEmploy() {
		return this.deptEmploy;
	}
	
	/**
	 * Column Info
	 * @return comNo
	 */
	public String getComNo() {
		return this.comNo;
	}
	
	/**
	 * Column Info
	 * @return docCd
	 */
	public String getDocCd() {
		return this.docCd;
	}
	
	/**
	 * Column Info
	 * @return transMode
	 */
	public String getTransMode() {
		return this.transMode;
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
	 * @return refNo
	 */
	public String getRefNo() {
		return this.refNo;
	}
	
	/**
	 * Column Info
	 * @return carrierNm
	 */
	public String getCarrierNm() {
		return this.carrierNm;
	}
	
	/**
	 * Column Info
	 * @return voyageNo
	 */
	public String getVoyageNo() {
		return this.voyageNo;
	}
	
	/**
	 * Column Info
	 * @return comCh
	 */
	public String getComCh() {
		return this.comCh;
	}
	

	/**
	 * Column Info
	 * @param msgFunc
	 */
	public void setMsgFunc(String msgFunc) {
		this.msgFunc = msgFunc;
	}
	
	/**
	 * Column Info
	 * @param partyType
	 */
	public void setPartyType(String partyType) {
		this.partyType = partyType;
	}
	
	/**
	 * Column Info
	 * @param docNo
	 */
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}
	
	/**
	 * Column Info
	 * @param imoNo
	 */
	public void setImoNo(String imoNo) {
		this.imoNo = imoNo;
	}
	
	/**
	 * Column Info
	 * @param vesselNm
	 */
	public void setVesselNm(String vesselNm) {
		this.vesselNm = vesselNm;
	}
	
	/**
	 * Column Info
	 * @param msgDate
	 */
	public void setMsgDate(String msgDate) {
		this.msgDate = msgDate;
	}
	
	/**
	 * Column Info
	 * @param sendType
	 */
	public void setSendType(String sendType) {
		this.sendType = sendType;
	}
	
	/**
	 * Column Info
	 * @param handling
	 */
	public void setHandling(String handling) {
		this.handling = handling;
	}
	
	/**
	 * Column Info
	 * @param transStage
	 */
	public void setTransStage(String transStage) {
		this.transStage = transStage;
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
	 * @param deptEmploy
	 */
	public void setDeptEmploy(String deptEmploy) {
		this.deptEmploy = deptEmploy;
	}
	
	/**
	 * Column Info
	 * @param comNo
	 */
	public void setComNo(String comNo) {
		this.comNo = comNo;
	}
	
	/**
	 * Column Info
	 * @param docCd
	 */
	public void setDocCd(String docCd) {
		this.docCd = docCd;
	}
	
	/**
	 * Column Info
	 * @param transMode
	 */
	public void setTransMode(String transMode) {
		this.transMode = transMode;
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
	 * @param refNo
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	
	/**
	 * Column Info
	 * @param carrierNm
	 */
	public void setCarrierNm(String carrierNm) {
		this.carrierNm = carrierNm;
	}
	
	/**
	 * Column Info
	 * @param voyageNo
	 */
	public void setVoyageNo(String voyageNo) {
		this.voyageNo = voyageNo;
	}
	
	/**
	 * Column Info
	 * @param comCh
	 */
	public void setComCh(String comCh) {
		this.comCh = comCh;
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
		setMsgFunc(JSPUtil.getParameter(request, prefix + "msg_func", ""));
		setPartyType(JSPUtil.getParameter(request, prefix + "party_type", ""));
		setDocNo(JSPUtil.getParameter(request, prefix + "doc_no", ""));
		setImoNo(JSPUtil.getParameter(request, prefix + "imo_no", ""));
		setVesselNm(JSPUtil.getParameter(request, prefix + "vessel_nm", ""));
		setMsgDate(JSPUtil.getParameter(request, prefix + "msg_date", ""));
		setSendType(JSPUtil.getParameter(request, prefix + "send_type", ""));
		setHandling(JSPUtil.getParameter(request, prefix + "handling", ""));
		setTransStage(JSPUtil.getParameter(request, prefix + "trans_stage", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDeptEmploy(JSPUtil.getParameter(request, prefix + "dept_employ", ""));
		setComNo(JSPUtil.getParameter(request, prefix + "com_no", ""));
		setDocCd(JSPUtil.getParameter(request, prefix + "doc_cd", ""));
		setTransMode(JSPUtil.getParameter(request, prefix + "trans_mode", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRefNo(JSPUtil.getParameter(request, prefix + "ref_no", ""));
		setCarrierNm(JSPUtil.getParameter(request, prefix + "carrier_nm", ""));
		setVoyageNo(JSPUtil.getParameter(request, prefix + "voyage_no", ""));
		setComCh(JSPUtil.getParameter(request, prefix + "com_ch", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DeclBaseInfoVO[]
	 */
	public DeclBaseInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DeclBaseInfoVO[]
	 */
	public DeclBaseInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DeclBaseInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] msgFunc = (JSPUtil.getParameter(request, prefix	+ "msg_func", length));
			String[] partyType = (JSPUtil.getParameter(request, prefix	+ "party_type", length));
			String[] docNo = (JSPUtil.getParameter(request, prefix	+ "doc_no", length));
			String[] imoNo = (JSPUtil.getParameter(request, prefix	+ "imo_no", length));
			String[] vesselNm = (JSPUtil.getParameter(request, prefix	+ "vessel_nm", length));
			String[] msgDate = (JSPUtil.getParameter(request, prefix	+ "msg_date", length));
			String[] sendType = (JSPUtil.getParameter(request, prefix	+ "send_type", length));
			String[] handling = (JSPUtil.getParameter(request, prefix	+ "handling", length));
			String[] transStage = (JSPUtil.getParameter(request, prefix	+ "trans_stage", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] deptEmploy = (JSPUtil.getParameter(request, prefix	+ "dept_employ", length));
			String[] comNo = (JSPUtil.getParameter(request, prefix	+ "com_no", length));
			String[] docCd = (JSPUtil.getParameter(request, prefix	+ "doc_cd", length));
			String[] transMode = (JSPUtil.getParameter(request, prefix	+ "trans_mode", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] refNo = (JSPUtil.getParameter(request, prefix	+ "ref_no", length));
			String[] carrierNm = (JSPUtil.getParameter(request, prefix	+ "carrier_nm", length));
			String[] voyageNo = (JSPUtil.getParameter(request, prefix	+ "voyage_no", length));
			String[] comCh = (JSPUtil.getParameter(request, prefix	+ "com_ch", length));
			
			for (int i = 0; i < length; i++) {
				model = new DeclBaseInfoVO();
				if (msgFunc[i] != null)
					model.setMsgFunc(msgFunc[i]);
				if (partyType[i] != null)
					model.setPartyType(partyType[i]);
				if (docNo[i] != null)
					model.setDocNo(docNo[i]);
				if (imoNo[i] != null)
					model.setImoNo(imoNo[i]);
				if (vesselNm[i] != null)
					model.setVesselNm(vesselNm[i]);
				if (msgDate[i] != null)
					model.setMsgDate(msgDate[i]);
				if (sendType[i] != null)
					model.setSendType(sendType[i]);
				if (handling[i] != null)
					model.setHandling(handling[i]);
				if (transStage[i] != null)
					model.setTransStage(transStage[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (deptEmploy[i] != null)
					model.setDeptEmploy(deptEmploy[i]);
				if (comNo[i] != null)
					model.setComNo(comNo[i]);
				if (docCd[i] != null)
					model.setDocCd(docCd[i]);
				if (transMode[i] != null)
					model.setTransMode(transMode[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (refNo[i] != null)
					model.setRefNo(refNo[i]);
				if (carrierNm[i] != null)
					model.setCarrierNm(carrierNm[i]);
				if (voyageNo[i] != null)
					model.setVoyageNo(voyageNo[i]);
				if (comCh[i] != null)
					model.setComCh(comCh[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDeclBaseInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DeclBaseInfoVO[]
	 */
	public DeclBaseInfoVO[] getDeclBaseInfoVOs(){
		DeclBaseInfoVO[] vos = (DeclBaseInfoVO[])models.toArray(new DeclBaseInfoVO[models.size()]);
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
		this.msgFunc = this.msgFunc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.partyType = this.partyType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docNo = this.docNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imoNo = this.imoNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vesselNm = this.vesselNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgDate = this.msgDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sendType = this.sendType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.handling = this.handling .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transStage = this.transStage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deptEmploy = this.deptEmploy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comNo = this.comNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docCd = this.docCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transMode = this.transMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo = this.refNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.carrierNm = this.carrierNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voyageNo = this.voyageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comCh = this.comCh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
