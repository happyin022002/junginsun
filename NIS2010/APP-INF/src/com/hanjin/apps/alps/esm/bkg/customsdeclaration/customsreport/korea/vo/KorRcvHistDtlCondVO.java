/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorTransmitHistDtlCondVO.java
*@FileTitle : KorTransmitHistDtlCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.15
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.07.15 박상훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.RcvHistDetailCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.ReceiveLogCondVO;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorRcvHistDtlCondVO extends ReceiveLogCondVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorRcvHistDtlCondVO> models = new ArrayList<KorRcvHistDtlCondVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rcvDt = null;
	/* Column Info */
	private String msgLogTpId = null;
	/* Column Info */
	private String smtAmdNo = null;
	/* Column Info */
	private String rcvSeq = null;
	
	private String fltFileRefNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KorRcvHistDtlCondVO() {}

	public KorRcvHistDtlCondVO(String ibflag, String rcvDt, String msgLogTpId, String smtAmdNo, String rcvSeq, String fltFileRefNo) {
		this.ibflag = ibflag;
		this.rcvDt = rcvDt;
		this.msgLogTpId = msgLogTpId;
		this.smtAmdNo = smtAmdNo;
		this.rcvSeq = rcvSeq;
		this.fltFileRefNo = fltFileRefNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rcv_dt", getRcvDt());
		this.hashColumns.put("msg_log_tp_id", getMsgLogTpId());
		this.hashColumns.put("smt_amd_no", getSmtAmdNo());
		this.hashColumns.put("rcv_seq", getRcvSeq());
		this.hashColumns.put("flt_file_ref_no", getFltFileRefNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rcv_dt", "rcvDt");
		this.hashFields.put("msg_log_tp_id", "msgLogTpId");
		this.hashFields.put("smt_amd_no", "smtAmdNo");
		this.hashFields.put("rcv_seq", "rcvSeq");
		this.hashFields.put("flt_file_ref_no", "fltFileRefNo");
		return this.hashFields;
	}
	
	/**
	 * @return the smtAmdNo
	 */
	public String getSmtAmdNo() {
		return smtAmdNo;
	}

	/**
	 * @param smtAmdNo the smtAmdNo to set
	 */
	public void setSmtAmdNo(String smtAmdNo) {
		this.smtAmdNo = smtAmdNo;
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
	 * @return rcvDt
	 */
	public String getRcvDt() {
		return this.rcvDt;
	}
	
	/**
	 * Column Info
	 * @return msgLogTpId
	 */
	public String getMsgLogTpId() {
		return this.msgLogTpId;
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
	 * @return fltFileRefNo
	 */
	public String getFltFileRefNo() {
		return this.fltFileRefNo;
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
	 * @param rcvDt
	 */
	public void setRcvDt(String rcvDt) {
		this.rcvDt = rcvDt;
	}
	
	/**
	 * Column Info
	 * @param msgLogTpId
	 */
	public void setMsgLogTpId(String msgLogTpId) {
		this.msgLogTpId = msgLogTpId;
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
	 * @param fltFileRefNo
	 */
	public void setFltFileRefNo(String fltFileRefNo) {
		this.fltFileRefNo = fltFileRefNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRcvDt(JSPUtil.getParameter(request, "rcv_dt", ""));
		setMsgLogTpId(JSPUtil.getParameter(request, "msg_log_tp_id", ""));
		setSmtAmdNo(JSPUtil.getParameter(request, "smt_amd_no", ""));
		setRcvSeq(JSPUtil.getParameter(request, "rcv_seq", ""));
		setFltFileRefNo(JSPUtil.getParameter(request, "flt_file_ref_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorTransmitHistDtlCondVO[]
	 */
	public KorRcvHistDtlCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorTransmitHistDtlCondVO[]
	 */
	public KorRcvHistDtlCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorRcvHistDtlCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rcvDt = (JSPUtil.getParameter(request, prefix	+ "rcv_dt", length));
			String[] msgLogTpId = (JSPUtil.getParameter(request, prefix	+ "msg_log_tp_id", length));
			String[] smtAmdNo = (JSPUtil.getParameter(request, prefix	+ "smt_amd_no", length));
			String[] rcvSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_seq", length));
			String[] fltFileRefNo = (JSPUtil.getParameter(request, prefix	+ "flt_file_ref_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorRcvHistDtlCondVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rcvDt[i] != null)
					model.setRcvDt(rcvDt[i]);
				if (msgLogTpId[i] != null)
					model.setMsgLogTpId(msgLogTpId[i]);
				if (smtAmdNo[i] != null)
					model.setSmtAmdNo(smtAmdNo[i]);
				if (rcvSeq[i] != null)
					model.setRcvSeq(rcvSeq[i]);
				if (fltFileRefNo[i] != null)
					model.setFltFileRefNo(fltFileRefNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorRcvHistDtlCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorTransmitHistDtlCondVO[]
	 */
	public KorRcvHistDtlCondVO[] getKorRcvHistDtlCondVOs(){
		KorRcvHistDtlCondVO[] vos = (KorRcvHistDtlCondVO[])models.toArray(new KorRcvHistDtlCondVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDt = this.rcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgLogTpId = this.msgLogTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smtAmdNo = this.smtAmdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvSeq = this.rcvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fltFileRefNo = this.fltFileRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
