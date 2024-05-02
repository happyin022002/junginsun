/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TPBEdiSndLogDtlVO.java
*@FileTitle : TPBEdiSndLogDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.17
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.17  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

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

public class TPBEdiSndLogDtlVO extends AbstractValueObject { 


	private static final long serialVersionUID = 8020933718070758404L;


	private Collection<TPBEdiSndLogDtlVO> models = new ArrayList<TPBEdiSndLogDtlVO>();
	

	/* Column Info */
	private String n3ptyEdiSndIndCd = null;
	/* Column Info */
	private String sndDt = null;	
	/* Column Info */
	private String fltFileRefNo = null;
	/* Column Info */
	private String n3ptyEdiSndSeq = null;
	/* Column Info */
	private String logDtlSeq = null;
	/* Column Info */
	private String n3ptyNo = null;
	/* Column Info */
	private String n3ptyInvNo = null;	
	/* Column Info */
	private String ediSndMsg = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/**
	 * @return the models
	 */
	public Collection<TPBEdiSndLogDtlVO> getModels() {
		return models;
	}
	/**
	 * @param models the models to set
	 */
	public void setModels(Collection<TPBEdiSndLogDtlVO> models) {
		this.models = models;
	}
	/**
	 * @return the n3ptyEdiSndIndCd
	 */
	public String getN3ptyEdiSndIndCd() {
		return n3ptyEdiSndIndCd;
	}
	/**
	 * @param ediSndIndCd the n3ptyEdiSndIndCd to set
	 */
	public void setN3ptyEdiSndIndCd(String ediSndIndCd) {
		n3ptyEdiSndIndCd = ediSndIndCd;
	}
	/**
	 * @return the sndDt
	 */
	public String getSndDt() {
		return sndDt;
	}
	/**
	 * @param sndDt the sndDt to set
	 */
	public void setSndDt(String sndDt) {
		this.sndDt = sndDt;
	}
	/**
	 * @return the fltFileRefNo
	 */
	public String getFltFileRefNo() {
		return fltFileRefNo;
	}
	/**
	 * @param fltFileRefNo the fltFileRefNo to set
	 */
	public void setFltFileRefNo(String fltFileRefNo) {
		this.fltFileRefNo = fltFileRefNo;
	}
	/**
	 * @return the n3ptyEdiSndSeq
	 */
	public String getN3ptyEdiSndSeq() {
		return n3ptyEdiSndSeq;
	}
	/**
	 * @param ediSndSeq the n3ptyEdiSndSeq to set
	 */
	public void setN3ptyEdiSndSeq(String ediSndSeq) {
		n3ptyEdiSndSeq = ediSndSeq;
	}
	/**
	 * @return the logDtlSeq
	 */
	public String getLogDtlSeq() {
		return logDtlSeq;
	}
	/**
	 * @param logDtlSeq the logDtlSeq to set
	 */
	public void setLogDtlSeq(String logDtlSeq) {
		this.logDtlSeq = logDtlSeq;
	}
	/**
	 * @return the n3ptyNo
	 */
	public String getN3ptyNo() {
		return n3ptyNo;
	}
	/**
	 * @param no the n3ptyNo to set
	 */
	public void setN3ptyNo(String no) {
		n3ptyNo = no;
	}
	/**
	 * @return the n3ptyInvNo
	 */
	public String getN3ptyInvNo() {
		return n3ptyInvNo;
	}
	/**
	 * @param invNo the n3ptyInvNo to set
	 */
	public void setN3ptyInvNo(String invNo) {
		n3ptyInvNo = invNo;
	}
	/**
	 * @return the ediSndMsg
	 */
	public String getEdiSndMsg() {
		return ediSndMsg;
	}
	/**
	 * @param ediSndMsg the ediSndMsg to set
	 */
	public void setEdiSndMsg(String ediSndMsg) {
		this.ediSndMsg = ediSndMsg;
	}
	/**
	 * @return the creUsrId
	 */
	public String getCreUsrId() {
		return creUsrId;
	}
	/**
	 * @param creUsrId the creUsrId to set
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	/**
	 * @return the creDt
	 */
	public String getCreDt() {
		return creDt;
	}
	/**
	 * @param creDt the creDt to set
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	/**
	 * @return the updUsrId
	 */
	public String getUpdUsrId() {
		return updUsrId;
	}
	/**
	 * @param updUsrId the updUsrId to set
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	/**
	 * @return the updDt
	 */
	public String getUpdDt() {
		return updDt;
	}
	/**
	 * @param updDt the updDt to set
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TPBEdiSndLogDtlVO() {}

	public TPBEdiSndLogDtlVO(String n3ptyEdiSndIndCd, String sndDt, String fltFileRefNo, String n3ptyEdiSndSeq, String logDtlSeq, String n3ptyNo, String n3ptyInvNo, String ediSndMsg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.n3ptyEdiSndIndCd = n3ptyEdiSndIndCd;
		this.sndDt = sndDt;
		this.fltFileRefNo = fltFileRefNo;
		this.n3ptyEdiSndSeq = n3ptyEdiSndSeq;
		this.logDtlSeq = logDtlSeq;
		this.n3ptyNo = n3ptyNo;
		this.n3ptyInvNo = n3ptyInvNo;
		this.ediSndMsg = ediSndMsg;
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
		this.hashColumns.put("n3pty_edi_snd_ind_cd", getN3ptyEdiSndIndCd());
		this.hashColumns.put("snd_dt", getSndDt());
		this.hashColumns.put("flt_file_ref_no", getFltFileRefNo());
		this.hashColumns.put("n3pty_edi_snd_seq", getN3ptyEdiSndSeq());
		this.hashColumns.put("log_dtl_seq", getLogDtlSeq());
		this.hashColumns.put("n3pty_no", getN3ptyNo());
		this.hashColumns.put("n3pty_inv_no", getN3ptyInvNo());
		this.hashColumns.put("edi_snd_msg", getEdiSndMsg());
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
		this.hashFields.put("n3pty_edi_snd_ind_cd", "n3ptyEdiSndIndCd");
		this.hashFields.put("snd_dt", "sndDt");
		this.hashFields.put("flt_file_ref_no", "fltFileRefNo");
		this.hashFields.put("n3pty_edi_snd_seq", "n3ptyEdiSndSeq");
		this.hashFields.put("log_dtl_seq", "logDtlSeq");
		this.hashFields.put("n3pty_no", "n3ptyNo");
		this.hashFields.put("n3pty_inv_no", "n3ptyInvNo");
		this.hashFields.put("edi_snd_msg", "ediSndMsg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		return this.hashFields;
	}
	
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setN3ptyEdiSndIndCd(JSPUtil.getParameter(request, "n3pty_edi_snd_ind_cd", ""));
		setSndDt(JSPUtil.getParameter(request, "snd_dt", ""));
		setFltFileRefNo(JSPUtil.getParameter(request, "flt_file_ref_no", ""));
		setN3ptyEdiSndSeq(JSPUtil.getParameter(request, "n3pty_edi_snd_seq", ""));
		setLogDtlSeq(JSPUtil.getParameter(request, "log_dtl_seq", ""));
		setN3ptyNo(JSPUtil.getParameter(request, "n3pty_no", ""));
		setN3ptyInvNo(JSPUtil.getParameter(request, "n3pty_inv_no", ""));
		setEdiSndMsg(JSPUtil.getParameter(request, "edi_snd_msg", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));

	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TPBEdiSndLogDtlVO[]
	 */
	public TPBEdiSndLogDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TPBEdiSndLogDtlVO[]
	 */
	public TPBEdiSndLogDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TPBEdiSndLogDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] n3ptyEdiSndIndCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_edi_snd_ind_cd", length));
			String[] sndDt = (JSPUtil.getParameter(request, prefix	+ "snd_dt", length));
			String[] fltFileRefNo = (JSPUtil.getParameter(request, prefix	+ "flt_file_ref_no", length));
			String[] n3ptyEdiSndSeq = (JSPUtil.getParameter(request, prefix	+ "n3pty_edi_snd_seq", length));
			String[] logDtlSeq = (JSPUtil.getParameter(request, prefix	+ "log_dtl_seq", length));
			String[] n3ptyNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_no", length));
			String[] n3ptyInvNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_inv_no", length));
			String[] ediSndMsg = (JSPUtil.getParameter(request, prefix	+ "edi_snd_msg", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));

			
			for (int i = 0; i < length; i++) {
				model = new TPBEdiSndLogDtlVO();
				if (n3ptyEdiSndIndCd[i] != null)
					model.setN3ptyEdiSndIndCd(n3ptyEdiSndIndCd[i]);
				if (sndDt[i] != null)
					model.setSndDt(sndDt[i]);
				if (fltFileRefNo[i] != null)
					model.setFltFileRefNo(fltFileRefNo[i]);
				if (n3ptyEdiSndSeq[i] != null)
					model.setN3ptyEdiSndSeq(n3ptyEdiSndSeq[i]);
				if (logDtlSeq[i] != null)
					model.setLogDtlSeq(logDtlSeq[i]);
				if (n3ptyNo[i] != null)
					model.setN3ptyNo(n3ptyNo[i]);
				if (n3ptyInvNo[i] != null)
					model.setN3ptyInvNo(n3ptyInvNo[i]);
				if (ediSndMsg[i] != null)
					model.setEdiSndMsg(ediSndMsg[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);

				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTPBEdiSndLogDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TPBEdiSndLogDtlVO[]
	 */
	public TPBEdiSndLogDtlVO[] getTPBEdiSndLogDtlVOs(){
		TPBEdiSndLogDtlVO[] vos = (TPBEdiSndLogDtlVO[])models.toArray(new TPBEdiSndLogDtlVO[models.size()]);
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
		this.n3ptyEdiSndIndCd = this.n3ptyEdiSndIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDt = this.sndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fltFileRefNo = this.fltFileRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyEdiSndSeq = this.n3ptyEdiSndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.logDtlSeq = this.logDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyNo = this.n3ptyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyInvNo = this.n3ptyInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndMsg = this.ediSndMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	

}
