/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : searchWONoInquiryListDataVO.java
*@FileTitle : searchWONoInquiryListDataVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.07  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

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

public class WONoInquiryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<WONoInquiryVO> models = new ArrayList<WONoInquiryVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String wono = null;
	/* Column Info */
	private String mnrGrpTpCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String mnrWrkAmt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String trsmModNm = null;
	/* Column Info */
	private String senddt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public WONoInquiryVO() {}

	public WONoInquiryVO(String ibflag, String pagerows, String mnrGrpTpCd, String senddt, String wono, String vndrLglEngNm, String agmtSeq, String trsmModNm, String creDt, String mnrWrkAmt, String vndrSeq, String eqKndCd) {
		this.ibflag = ibflag;
		this.wono = wono;
		this.mnrGrpTpCd = mnrGrpTpCd;
		this.vndrSeq = vndrSeq;
		this.agmtSeq = agmtSeq;
		this.mnrWrkAmt = mnrWrkAmt;
		this.creDt = creDt;
		this.vndrLglEngNm = vndrLglEngNm;
		this.eqKndCd = eqKndCd;
		this.trsmModNm = trsmModNm;
		this.senddt = senddt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("wono", getWono());
		this.hashColumns.put("mnr_grp_tp_cd", getMnrGrpTpCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("mnr_wrk_amt", getMnrWrkAmt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("trsm_mod_nm", getTrsmModNm());
		this.hashColumns.put("senddt", getSenddt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("wono", "wono");
		this.hashFields.put("mnr_grp_tp_cd", "mnrGrpTpCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("mnr_wrk_amt", "mnrWrkAmt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("trsm_mod_nm", "trsmModNm");
		this.hashFields.put("senddt", "senddt");
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
	 * @return wono
	 */
	public String getWono() {
		return this.wono;
	}
	
	/**
	 * Column Info
	 * @return mnrGrpTpCd
	 */
	public String getMnrGrpTpCd() {
		return this.mnrGrpTpCd;
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
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
	}
	
	/**
	 * Column Info
	 * @return mnrWrkAmt
	 */
	public String getMnrWrkAmt() {
		return this.mnrWrkAmt;
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
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	
	/**
	 * Column Info
	 * @return trsmModNm
	 */
	public String getTrsmModNm() {
		return this.trsmModNm;
	}
	
	/**
	 * Column Info
	 * @return senddt
	 */
	public String getSenddt() {
		return this.senddt;
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
	 * @param wono
	 */
	public void setWono(String wono) {
		this.wono = wono;
	}
	
	/**
	 * Column Info
	 * @param mnrGrpTpCd
	 */
	public void setMnrGrpTpCd(String mnrGrpTpCd) {
		this.mnrGrpTpCd = mnrGrpTpCd;
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
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}
	
	/**
	 * Column Info
	 * @param mnrWrkAmt
	 */
	public void setMnrWrkAmt(String mnrWrkAmt) {
		this.mnrWrkAmt = mnrWrkAmt;
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
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	
	/**
	 * Column Info
	 * @param trsmModNm
	 */
	public void setTrsmModNm(String trsmModNm) {
		this.trsmModNm = trsmModNm;
	}
	
	/**
	 * Column Info
	 * @param senddt
	 */
	public void setSenddt(String senddt) {
		this.senddt = senddt;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setWono(JSPUtil.getParameter(request, "wono", ""));
		setMnrGrpTpCd(JSPUtil.getParameter(request, "mnr_grp_tp_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setMnrWrkAmt(JSPUtil.getParameter(request, "mnr_wrk_amt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, "vndr_lgl_eng_nm", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setTrsmModNm(JSPUtil.getParameter(request, "trsm_mod_nm", ""));
		setSenddt(JSPUtil.getParameter(request, "senddt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return searchWONoInquiryListDataVO[]
	 */
	public WONoInquiryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return searchWONoInquiryListDataVO[]
	 */
	public WONoInquiryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		WONoInquiryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] wono = (JSPUtil.getParameter(request, prefix	+ "wono", length));
			String[] mnrGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_grp_tp_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] mnrWrkAmt = (JSPUtil.getParameter(request, prefix	+ "mnr_wrk_amt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] trsmModNm = (JSPUtil.getParameter(request, prefix	+ "trsm_mod_nm", length));
			String[] senddt = (JSPUtil.getParameter(request, prefix	+ "senddt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new WONoInquiryVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (wono[i] != null)
					model.setWono(wono[i]);
				if (mnrGrpTpCd[i] != null)
					model.setMnrGrpTpCd(mnrGrpTpCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (mnrWrkAmt[i] != null)
					model.setMnrWrkAmt(mnrWrkAmt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (trsmModNm[i] != null)
					model.setTrsmModNm(trsmModNm[i]);
				if (senddt[i] != null)
					model.setSenddt(senddt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getsearchWONoInquiryListDataVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return searchWONoInquiryListDataVO[]
	 */
	public WONoInquiryVO[] getsearchWONoInquiryListDataVOs(){
		WONoInquiryVO[] vos = (WONoInquiryVO[])models.toArray(new WONoInquiryVO[models.size()]);
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
		this.wono = this.wono .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrGrpTpCd = this.mnrGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrWrkAmt = this.mnrWrkAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmModNm = this.trsmModNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.senddt = this.senddt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
