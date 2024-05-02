/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EurSearchSendLogDetailVO.java
*@FileTitle : EurSearchSendLogDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.14  
* 1.0 Creation
* -------------------------------------------------------
* history
* 2011.02.28 김영철 [] Transmit History (ESM_BKG_1032) 화면에서 조건 추가 ( VVD )
* 2014.12.29 [CHM-201432728] [IE 세관] 시스템 추가 보완 요청 사항
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.eur.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.SendLogDetailVO;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EurSearchSendLogDetailVO extends SendLogDetailVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<EurSearchSendLogDetailVO> models = new ArrayList<EurSearchSendLogDetailVO>();
	
	/* Column Info */
	private String ackDt = null;
	/* Column Info */
	private String msgAcptRefNo = null;
	/* Column Info */
	private String cstmsErrId = null;
	/* Column Info */
	private String msgRcvNo = null;
	/* Column Info */
	private String aproDt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String msgFuncId = null;
	/* Column Info */
	private String ackRcvStsCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String orgMsgTpId = null;
	/* Column Info */
	private String ackKndId = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String cntrPrtFlg = null;
	/* Column Info */
	private String ieVvd = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String portCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EurSearchSendLogDetailVO() {}

	public EurSearchSendLogDetailVO(String ibflag, String pagerows, String orgMsgTpId, String msgFuncId, String ackKndId, String ackRcvStsCd, String ackDt, String aproDt, String blNo, String cntrNo, String cstmsErrId, String msgAcptRefNo, String msgRcvNo, String vvd, String cntrPrtFlg, String ieVvd, String ioBndCd, String portCd) {
		this.ackDt = ackDt;
		this.msgAcptRefNo = msgAcptRefNo;
		this.cstmsErrId = cstmsErrId;
		this.msgRcvNo = msgRcvNo;
		this.aproDt = aproDt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.msgFuncId = msgFuncId;
		this.ackRcvStsCd = ackRcvStsCd;
		this.cntrNo = cntrNo;
		this.orgMsgTpId = orgMsgTpId;
		this.ackKndId = ackKndId;
		this.vvd = vvd;
		this.cntrPrtFlg = cntrPrtFlg;
		this.ieVvd = ieVvd;
		this.ioBndCd = ioBndCd;
		this.portCd = portCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ack_dt", getAckDt());
		this.hashColumns.put("msg_acpt_ref_no", getMsgAcptRefNo());
		this.hashColumns.put("cstms_err_id", getCstmsErrId());
		this.hashColumns.put("msg_rcv_no", getMsgRcvNo());
		this.hashColumns.put("apro_dt", getAproDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("msg_func_id", getMsgFuncId());
		this.hashColumns.put("ack_rcv_sts_cd", getAckRcvStsCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("org_msg_tp_id", getOrgMsgTpId());
		this.hashColumns.put("ack_knd_id", getAckKndId());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("cntr_prt_flg", getCntrPrtFlg());
		this.hashColumns.put("ie_vvd", getIeVvd());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("port_cd", getPortCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ack_dt", "ackDt");
		this.hashFields.put("msg_acpt_ref_no", "msgAcptRefNo");
		this.hashFields.put("cstms_err_id", "cstmsErrId");
		this.hashFields.put("msg_rcv_no", "msgRcvNo");
		this.hashFields.put("apro_dt", "aproDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("msg_func_id", "msgFuncId");
		this.hashFields.put("ack_rcv_sts_cd", "ackRcvStsCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("org_msg_tp_id", "orgMsgTpId");
		this.hashFields.put("ack_knd_id", "ackKndId");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("cntr_prt_flg", "cntrPrtFlg");
		this.hashFields.put("ie_vvd", "ieVvd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("port_cd", "portCd");
		return this.hashFields;
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
	 * @return cstmsErrId
	 */
	public String getCstmsErrId() {
		return this.cstmsErrId;
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
	 * @return aproDt
	 */
	public String getAproDt() {
		return this.aproDt;
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
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
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
	 * @return ackRcvStsCd
	 */
	public String getAckRcvStsCd() {
		return this.ackRcvStsCd;
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
	 * @return orgMsgTpId
	 */
	public String getOrgMsgTpId() {
		return this.orgMsgTpId;
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
	 * @return vvd
	 */
	public String getVvd() {
		return vvd;
	}
	
	/**
	 * Column Info
	 * @return cntrPrtFlg
	 */
	public String getCntrPrtFlg(){
		return this.cntrPrtFlg;
	}	
	
	/**
	 * Column Info
	 * @return ieVvd
	 */
	public String getIeVvd(){
		return this.ieVvd;
	}	
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd(){
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd(){
		return this.portCd;
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
	 * @param cstmsErrId
	 */
	public void setCstmsErrId(String cstmsErrId) {
		this.cstmsErrId = cstmsErrId;
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
	 * @param aproDt
	 */
	public void setAproDt(String aproDt) {
		this.aproDt = aproDt;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
	 * @param ackRcvStsCd
	 */
	public void setAckRcvStsCd(String ackRcvStsCd) {
		this.ackRcvStsCd = ackRcvStsCd;
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
	 * @param orgMsgTpId
	 */
	public void setOrgMsgTpId(String orgMsgTpId) {
		this.orgMsgTpId = orgMsgTpId;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param cntrPrtFlg
	 */
	public void setCntrPrtFlg(String cntrPrtFlg){
		this.cntrPrtFlg = cntrPrtFlg;
	}
	
	/**
	 * Column Info
	 * @param ieVvd
	 */
	public void setIeVvd(String ieVvd){
		this.ieVvd = ieVvd;
	}	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd){
		this.ioBndCd = ioBndCd;
	}	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd){
		this.portCd = portCd;
	}
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setAckDt(JSPUtil.getParameter(request, "ack_dt", ""));
		setMsgAcptRefNo(JSPUtil.getParameter(request, "msg_acpt_ref_no", ""));
		setCstmsErrId(JSPUtil.getParameter(request, "cstms_err_id", ""));
		setMsgRcvNo(JSPUtil.getParameter(request, "msg_rcv_no", ""));
		setAproDt(JSPUtil.getParameter(request, "apro_dt", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMsgFuncId(JSPUtil.getParameter(request, "msg_func_id", ""));
		setAckRcvStsCd(JSPUtil.getParameter(request, "ack_rcv_sts_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setOrgMsgTpId(JSPUtil.getParameter(request, "org_msg_tp_id", ""));
		setAckKndId(JSPUtil.getParameter(request, "ack_knd_id", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setCntrPrtFlg(JSPUtil.getParameter(request, "cntr_prt_flg", ""));
		setIeVvd(JSPUtil.getParameter(request, "ie_vvd", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EurSearchSendLogDetailVO[]
	 */
	public EurSearchSendLogDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EurSearchSendLogDetailVO[]
	 */
	public EurSearchSendLogDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EurSearchSendLogDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ackDt = (JSPUtil.getParameter(request, prefix	+ "ack_dt", length));
			String[] msgAcptRefNo = (JSPUtil.getParameter(request, prefix	+ "msg_acpt_ref_no", length));
			String[] cstmsErrId = (JSPUtil.getParameter(request, prefix	+ "cstms_err_id", length));
			String[] msgRcvNo = (JSPUtil.getParameter(request, prefix	+ "msg_rcv_no", length));
			String[] aproDt = (JSPUtil.getParameter(request, prefix	+ "apro_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] msgFuncId = (JSPUtil.getParameter(request, prefix	+ "msg_func_id", length));
			String[] ackRcvStsCd = (JSPUtil.getParameter(request, prefix	+ "ack_rcv_sts_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] orgMsgTpId = (JSPUtil.getParameter(request, prefix	+ "org_msg_tp_id", length));
			String[] ackKndId = (JSPUtil.getParameter(request, prefix	+ "ack_knd_id", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] cntrPrtFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_prt_flg", length));
			String[] ieVvd = (JSPUtil.getParameter(request, prefix	+ "ie_vvd", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new EurSearchSendLogDetailVO();
				if (ackDt[i] != null)
					model.setAckDt(ackDt[i]);
				if (msgAcptRefNo[i] != null)
					model.setMsgAcptRefNo(msgAcptRefNo[i]);
				if (cstmsErrId[i] != null)
					model.setCstmsErrId(cstmsErrId[i]);
				if (msgRcvNo[i] != null)
					model.setMsgRcvNo(msgRcvNo[i]);
				if (aproDt[i] != null)
					model.setAproDt(aproDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (msgFuncId[i] != null)
					model.setMsgFuncId(msgFuncId[i]);
				if (ackRcvStsCd[i] != null)
					model.setAckRcvStsCd(ackRcvStsCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (orgMsgTpId[i] != null)
					model.setOrgMsgTpId(orgMsgTpId[i]);
				if (ackKndId[i] != null)
					model.setAckKndId(ackKndId[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (cntrPrtFlg[i] != null)
					model.setCntrPrtFlg(cntrPrtFlg[i]);
				if (ieVvd[i] != null)
					model.setIeVvd(ieVvd[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEurSearchSendLogDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EurSearchSendLogDetailVO[]
	 */
	public EurSearchSendLogDetailVO[] getEurSearchSendLogDetailVOs(){
		EurSearchSendLogDetailVO[] vos = (EurSearchSendLogDetailVO[])models.toArray(new EurSearchSendLogDetailVO[models.size()]);
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
		this.ackDt = this.ackDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgAcptRefNo = this.msgAcptRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsErrId = this.cstmsErrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgRcvNo = this.msgRcvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproDt = this.aproDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgFuncId = this.msgFuncId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackRcvStsCd = this.ackRcvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgMsgTpId = this.orgMsgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackKndId = this.ackKndId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPrtFlg = this.cntrPrtFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ieVvd = this.ieVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
