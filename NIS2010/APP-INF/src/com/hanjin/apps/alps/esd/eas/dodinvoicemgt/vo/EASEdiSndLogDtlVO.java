/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EASEdiSndLogDtlVO.java
*@FileTitle : EASEdiSndLogDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.15
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.15
* 1.0 Creation  
=========================================================*/
  
package com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo;

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

public class EASEdiSndLogDtlVO extends AbstractValueObject { 


	private static final long serialVersionUID = 8020933718070758404L;


	private Collection<EASEdiSndLogDtlVO> models = new ArrayList<EASEdiSndLogDtlVO>();
	

	/* Column Info */
	private String ediSndIndCd = null;
	/* Column Info */
	private String sndDt = null;	
	/* Column Info */
	private String fltFileRefNo = null;
	/* Column Info */
	private String ediSndSeq = null;
	/* Column Info */
	private String ediDtlSeq = null;
	/* Column Info */
	private String dodInvNo = null;
	/* Column Info */
	private String arIfNo = null;	
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
	public Collection<EASEdiSndLogDtlVO> getModels() {
		return models;
	}
	/**
	 * @param models 
	 */
	public void setModels(Collection<EASEdiSndLogDtlVO> models) {
		this.models = models;
	}
	/**
	 * @return ediSndIndCd
	 */
	public String getEdiSndIndCd() {
		return ediSndIndCd;
	}
	/**
	 * @param ediSndIndCd the ediSndIndCd to set
	 */
	public void setEdiSndIndCd(String ediSndIndCd) {
		this.ediSndIndCd = ediSndIndCd;
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
	 * @param fltFileRefNo 
	 */
	public void setFltFileRefNo(String fltFileRefNo) {
		this.fltFileRefNo = fltFileRefNo;
	}
	/**
	 * @return the ediSndSeq
	 */
	public String getEdiSndSeq() {
		return ediSndSeq;
	}
	/**
	 * @param ediSndSeq 
	 */
	public void setEdiSndSeq(String ediSndSeq) {
		this.ediSndSeq = ediSndSeq;
	}
	/**
	 * @return the ediDtlSeq
	 */
	public String getEdiDtlSeq() {
		return ediDtlSeq;
	}
	/**
	 * @param ediDtlSeq 
	 */
	public void setEdiDtlSeq(String ediDtlSeq) {
		this.ediDtlSeq = ediDtlSeq;
	}
	/**
	 * @return the dodInvNo
	 */
	public String getDodInvNo() {
		return dodInvNo;
	}
	/**
	 * @param dodInvNo
	 */
	public void setDodInvNo(String dodInvNo) {
		this.dodInvNo = dodInvNo;
	}
	/**
	 * @return the arIfNo
	 */
	public String getArIfNo() {
		return arIfNo;
	}
	/**
	 * @param arIfNo
	 */
	public void setArIfNo(String arIfNo) {
		this.arIfNo = arIfNo;
	}
	/**
	 * @return the ediSndMsg
	 */
	public String getEdiSndMsg() {
		return ediSndMsg;
	}
	/**
	 * @param ediSndMsg
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
	 * @param creUsrId 
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
	 * @param updUsrId 
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
	 * @param updDt 
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EASEdiSndLogDtlVO() {}

	public EASEdiSndLogDtlVO(String ediSndIndCd, String sndDt, String fltFileRefNo, String ediSndSeq, String ediDtlSeq, String dodInvNo, String arIfNo, String ediSndMsg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.ediSndIndCd = ediSndIndCd;
		this.sndDt = sndDt;
		this.fltFileRefNo = fltFileRefNo;
		this.ediSndSeq = ediSndSeq;
		this.ediDtlSeq = ediDtlSeq;
		this.dodInvNo = dodInvNo;
		this.arIfNo = arIfNo;
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
		this.hashColumns.put("edi_snd_ind_cd", getEdiSndIndCd());
		this.hashColumns.put("snd_dt", getSndDt());
		this.hashColumns.put("flt_file_ref_no", getFltFileRefNo());
		this.hashColumns.put("edi_snd_seq", getEdiSndSeq());
		this.hashColumns.put("edi_dtl_seq", getEdiDtlSeq());
		this.hashColumns.put("dod_inv_no", getDodInvNo());
		this.hashColumns.put("ar_if_no", getArIfNo());
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
		this.hashFields.put("edi_snd_ind_cd", "ediSndIndCd");
		this.hashFields.put("snd_dt", "sndDt");
		this.hashFields.put("flt_file_ref_no", "fltFileRefNo");
		this.hashFields.put("edi_snd_seq", "ediSndSeq");
		this.hashFields.put("edi_dtl_seq", "ediDtlSeq");
		this.hashFields.put("dod_inv_no", "dodInvNo");
		this.hashFields.put("ar_if_no", "arIfNo");
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
		setEdiSndIndCd(JSPUtil.getParameter(request, "edi_snd_ind_cd", ""));
		setSndDt(JSPUtil.getParameter(request, "snd_dt", ""));
		setFltFileRefNo(JSPUtil.getParameter(request, "flt_file_ref_no", ""));
		setEdiSndSeq(JSPUtil.getParameter(request, "edi_snd_seq", ""));
		setEdiDtlSeq(JSPUtil.getParameter(request, "edi_dtl_seq", ""));
		setDodInvNo(JSPUtil.getParameter(request, "dod_inv_no", ""));
		setArIfNo(JSPUtil.getParameter(request, "ar_if_no", ""));
		setEdiSndMsg(JSPUtil.getParameter(request, "edi_snd_msg", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));

	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EASEdiSndLogDtlVO[]
	 */
	public EASEdiSndLogDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EASEdiSndLogDtlVO[]
	 */
	public EASEdiSndLogDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EASEdiSndLogDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ediSndIndCd = (JSPUtil.getParameter(request, prefix	+ "edi_snd_ind_cd", length));
			String[] sndDt = (JSPUtil.getParameter(request, prefix	+ "snd_dt", length));
			String[] fltFileRefNo = (JSPUtil.getParameter(request, prefix	+ "flt_file_ref_no", length));
			String[] ediSndSeq = (JSPUtil.getParameter(request, prefix	+ "edi_snd_seq", length));
			String[] ediDtlSeq = (JSPUtil.getParameter(request, prefix	+ "edi_dtl_seq", length));
			String[] dodInvNo = (JSPUtil.getParameter(request, prefix	+ "dod_inv_no", length));
			String[] arIfNo = (JSPUtil.getParameter(request, prefix	+ "ar_if_no", length));
			String[] ediSndMsg = (JSPUtil.getParameter(request, prefix	+ "edi_snd_msg", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));

			
			for (int i = 0; i < length; i++) {
				model = new EASEdiSndLogDtlVO();
				if (ediSndIndCd[i] != null)
					model.setEdiSndIndCd(ediSndIndCd[i]);
				if (sndDt[i] != null)
					model.setSndDt(sndDt[i]);
				if (fltFileRefNo[i] != null)
					model.setFltFileRefNo(fltFileRefNo[i]);
				if (ediSndSeq[i] != null)
					model.setEdiSndSeq(ediSndSeq[i]);
				if (ediDtlSeq[i] != null)
					model.setEdiDtlSeq(ediDtlSeq[i]);
				if (dodInvNo[i] != null)
					model.setDodInvNo(dodInvNo[i]);
				if (arIfNo[i] != null)
					model.setArIfNo(arIfNo[i]);
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
		return getEASEdiSndLogDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EASEdiSndLogDtlVO[]
	 */
	public EASEdiSndLogDtlVO[] getEASEdiSndLogDtlVOs(){
		EASEdiSndLogDtlVO[] vos = (EASEdiSndLogDtlVO[])models.toArray(new EASEdiSndLogDtlVO[models.size()]);
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
		this.ediSndIndCd = this.ediSndIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDt = this.sndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fltFileRefNo = this.fltFileRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndSeq = this.ediSndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediDtlSeq = this.ediDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dodInvNo = this.dodInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfNo = this.arIfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndMsg = this.ediSndMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	

}
