/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DvLeasedUnitVO.java
*@FileTitle : DvLeasedUnitVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.12
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2011.04.12 김영오 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.vo;

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
 * @author 김영오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DvLeasedUnitVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DvLeasedUnitVO> models = new ArrayList<DvLeasedUnitVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String phnNo = null;
	/* Column Info */
	private String manuDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String mnrPrnrAddr = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String eqDpcYr = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String dvValue = null;
	/* Column Info */
	private String dvCur = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqDpcRt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String mnrPrnrRmk = null;
	/* Column Info */
	private String mnrPrnrEml = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String connNo = null;
	/* Column Info */
	private String faxNo = null;
	/* Column Info */
	private String mnrCntcPrnrNm = null;
	/* Column Info */
	private String intlFaxNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String intlPhnNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DvLeasedUnitVO() {}

	public DvLeasedUnitVO(String ibflag, String pagerows, String updDt, String phnNo, String creDt, String mnrPrnrAddr, String eqKndCd, String eqDpcYr, String eqDpcRt, String creUsrId, String eqNo, String mnrPrnrRmk, String vndrSeq, String mnrPrnrEml, String mnrCntcPrnrNm, String faxNo, String intlFaxNo, String updUsrId, String intlPhnNo, String connNo, String manuDt, String dvCur, String dvValue) {
		this.updDt = updDt;
		this.phnNo = phnNo;
		this.manuDt = manuDt;
		this.creDt = creDt;
		this.mnrPrnrAddr = mnrPrnrAddr;
		this.eqKndCd = eqKndCd;
		this.eqDpcYr = eqDpcYr;
		this.pagerows = pagerows;
		this.dvValue = dvValue;
		this.dvCur = dvCur;
		this.ibflag = ibflag;
		this.eqDpcRt = eqDpcRt;
		this.creUsrId = creUsrId;
		this.eqNo = eqNo;
		this.mnrPrnrRmk = mnrPrnrRmk;
		this.mnrPrnrEml = mnrPrnrEml;
		this.vndrSeq = vndrSeq;
		this.connNo = connNo;
		this.faxNo = faxNo;
		this.mnrCntcPrnrNm = mnrCntcPrnrNm;
		this.intlFaxNo = intlFaxNo;
		this.updUsrId = updUsrId;
		this.intlPhnNo = intlPhnNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("phn_no", getPhnNo());
		this.hashColumns.put("manu_dt", getManuDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("mnr_prnr_addr", getMnrPrnrAddr());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("eq_dpc_yr", getEqDpcYr());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dv_value", getDvValue());
		this.hashColumns.put("dv_cur", getDvCur());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_dpc_rt", getEqDpcRt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("mnr_prnr_rmk", getMnrPrnrRmk());
		this.hashColumns.put("mnr_prnr_eml", getMnrPrnrEml());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("conn_no", getConnNo());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("mnr_cntc_prnr_nm", getMnrCntcPrnrNm());
		this.hashColumns.put("intl_fax_no", getIntlFaxNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("intl_phn_no", getIntlPhnNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("phn_no", "phnNo");
		this.hashFields.put("manu_dt", "manuDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("mnr_prnr_addr", "mnrPrnrAddr");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("eq_dpc_yr", "eqDpcYr");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dv_value", "dvValue");
		this.hashFields.put("dv_cur", "dvCur");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_dpc_rt", "eqDpcRt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("mnr_prnr_rmk", "mnrPrnrRmk");
		this.hashFields.put("mnr_prnr_eml", "mnrPrnrEml");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("conn_no", "connNo");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("mnr_cntc_prnr_nm", "mnrCntcPrnrNm");
		this.hashFields.put("intl_fax_no", "intlFaxNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("intl_phn_no", "intlPhnNo");
		return this.hashFields;
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
	 * @return phnNo
	 */
	public String getPhnNo() {
		return this.phnNo;
	}
	
	/**
	 * Column Info
	 * @return manuDt
	 */
	public String getManuDt() {
		return this.manuDt;
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
	 * @return mnrPrnrAddr
	 */
	public String getMnrPrnrAddr() {
		return this.mnrPrnrAddr;
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
	 * @return eqDpcYr
	 */
	public String getEqDpcYr() {
		return this.eqDpcYr;
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
	 * @return dvValue
	 */
	public String getDvValue() {
		return this.dvValue;
	}
	
	/**
	 * Column Info
	 * @return dvCur
	 */
	public String getDvCur() {
		return this.dvCur;
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
	 * @return eqDpcRt
	 */
	public String getEqDpcRt() {
		return this.eqDpcRt;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return mnrPrnrRmk
	 */
	public String getMnrPrnrRmk() {
		return this.mnrPrnrRmk;
	}
	
	/**
	 * Column Info
	 * @return mnrPrnrEml
	 */
	public String getMnrPrnrEml() {
		return this.mnrPrnrEml;
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
	 * @return connNo
	 */
	public String getConnNo() {
		return this.connNo;
	}
	
	/**
	 * Column Info
	 * @return faxNo
	 */
	public String getFaxNo() {
		return this.faxNo;
	}
	
	/**
	 * Column Info
	 * @return mnrCntcPrnrNm
	 */
	public String getMnrCntcPrnrNm() {
		return this.mnrCntcPrnrNm;
	}
	
	/**
	 * Column Info
	 * @return intlFaxNo
	 */
	public String getIntlFaxNo() {
		return this.intlFaxNo;
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
	 * @return intlPhnNo
	 */
	public String getIntlPhnNo() {
		return this.intlPhnNo;
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
	 * @param phnNo
	 */
	public void setPhnNo(String phnNo) {
		this.phnNo = phnNo;
	}
	
	/**
	 * Column Info
	 * @param manuDt
	 */
	public void setManuDt(String manuDt) {
		this.manuDt = manuDt;
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
	 * @param mnrPrnrAddr
	 */
	public void setMnrPrnrAddr(String mnrPrnrAddr) {
		this.mnrPrnrAddr = mnrPrnrAddr;
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
	 * @param eqDpcYr
	 */
	public void setEqDpcYr(String eqDpcYr) {
		this.eqDpcYr = eqDpcYr;
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
	 * @param dvValue
	 */
	public void setDvValue(String dvValue) {
		this.dvValue = dvValue;
	}
	
	/**
	 * Column Info
	 * @param dvCur
	 */
	public void setDvCur(String dvCur) {
		this.dvCur = dvCur;
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
	 * @param eqDpcRt
	 */
	public void setEqDpcRt(String eqDpcRt) {
		this.eqDpcRt = eqDpcRt;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param mnrPrnrRmk
	 */
	public void setMnrPrnrRmk(String mnrPrnrRmk) {
		this.mnrPrnrRmk = mnrPrnrRmk;
	}
	
	/**
	 * Column Info
	 * @param mnrPrnrEml
	 */
	public void setMnrPrnrEml(String mnrPrnrEml) {
		this.mnrPrnrEml = mnrPrnrEml;
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
	 * @param connNo
	 */
	public void setConnNo(String connNo) {
		this.connNo = connNo;
	}
	
	/**
	 * Column Info
	 * @param faxNo
	 */
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}
	
	/**
	 * Column Info
	 * @param mnrCntcPrnrNm
	 */
	public void setMnrCntcPrnrNm(String mnrCntcPrnrNm) {
		this.mnrCntcPrnrNm = mnrCntcPrnrNm;
	}
	
	/**
	 * Column Info
	 * @param intlFaxNo
	 */
	public void setIntlFaxNo(String intlFaxNo) {
		this.intlFaxNo = intlFaxNo;
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
	 * @param intlPhnNo
	 */
	public void setIntlPhnNo(String intlPhnNo) {
		this.intlPhnNo = intlPhnNo;
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
		setPhnNo(JSPUtil.getParameter(request, prefix + "phn_no", ""));
		setManuDt(JSPUtil.getParameter(request, prefix + "manu_dt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setMnrPrnrAddr(JSPUtil.getParameter(request, prefix + "mnr_prnr_addr", ""));
		setEqKndCd(JSPUtil.getParameter(request, prefix + "eq_knd_cd", ""));
		setEqDpcYr(JSPUtil.getParameter(request, prefix + "eq_dpc_yr", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDvValue(JSPUtil.getParameter(request, prefix + "dv_value", ""));
		setDvCur(JSPUtil.getParameter(request, prefix + "dv_cur", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEqDpcRt(JSPUtil.getParameter(request, prefix + "eq_dpc_rt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setMnrPrnrRmk(JSPUtil.getParameter(request, prefix + "mnr_prnr_rmk", ""));
		setMnrPrnrEml(JSPUtil.getParameter(request, prefix + "mnr_prnr_eml", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setConnNo(JSPUtil.getParameter(request, prefix + "conn_no", ""));
		setFaxNo(JSPUtil.getParameter(request, prefix + "fax_no", ""));
		setMnrCntcPrnrNm(JSPUtil.getParameter(request, prefix + "mnr_cntc_prnr_nm", ""));
		setIntlFaxNo(JSPUtil.getParameter(request, prefix + "intl_fax_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setIntlPhnNo(JSPUtil.getParameter(request, prefix + "intl_phn_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DvLeasedUnitVO[]
	 */
	public DvLeasedUnitVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DvLeasedUnitVO[]
	 */
	public DvLeasedUnitVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DvLeasedUnitVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] phnNo = (JSPUtil.getParameter(request, prefix	+ "phn_no", length));
			String[] manuDt = (JSPUtil.getParameter(request, prefix	+ "manu_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] mnrPrnrAddr = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_addr", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] eqDpcYr = (JSPUtil.getParameter(request, prefix	+ "eq_dpc_yr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] dvValue = (JSPUtil.getParameter(request, prefix	+ "dv_value", length));
			String[] dvCur = (JSPUtil.getParameter(request, prefix	+ "dv_cur", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqDpcRt = (JSPUtil.getParameter(request, prefix	+ "eq_dpc_rt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] mnrPrnrRmk = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_rmk", length));
			String[] mnrPrnrEml = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_eml", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] connNo = (JSPUtil.getParameter(request, prefix	+ "conn_no", length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no", length));
			String[] mnrCntcPrnrNm = (JSPUtil.getParameter(request, prefix	+ "mnr_cntc_prnr_nm", length));
			String[] intlFaxNo = (JSPUtil.getParameter(request, prefix	+ "intl_fax_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] intlPhnNo = (JSPUtil.getParameter(request, prefix	+ "intl_phn_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new DvLeasedUnitVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (phnNo[i] != null)
					model.setPhnNo(phnNo[i]);
				if (manuDt[i] != null)
					model.setManuDt(manuDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (mnrPrnrAddr[i] != null)
					model.setMnrPrnrAddr(mnrPrnrAddr[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (eqDpcYr[i] != null)
					model.setEqDpcYr(eqDpcYr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (dvValue[i] != null)
					model.setDvValue(dvValue[i]);
				if (dvCur[i] != null)
					model.setDvCur(dvCur[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqDpcRt[i] != null)
					model.setEqDpcRt(eqDpcRt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (mnrPrnrRmk[i] != null)
					model.setMnrPrnrRmk(mnrPrnrRmk[i]);
				if (mnrPrnrEml[i] != null)
					model.setMnrPrnrEml(mnrPrnrEml[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (connNo[i] != null)
					model.setConnNo(connNo[i]);
				if (faxNo[i] != null)
					model.setFaxNo(faxNo[i]);
				if (mnrCntcPrnrNm[i] != null)
					model.setMnrCntcPrnrNm(mnrCntcPrnrNm[i]);
				if (intlFaxNo[i] != null)
					model.setIntlFaxNo(intlFaxNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (intlPhnNo[i] != null)
					model.setIntlPhnNo(intlPhnNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDvLeasedUnitVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DvLeasedUnitVO[]
	 */
	public DvLeasedUnitVO[] getDvLeasedUnitVOs(){
		DvLeasedUnitVO[] vos = (DvLeasedUnitVO[])models.toArray(new DvLeasedUnitVO[models.size()]);
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
		this.phnNo = this.phnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.manuDt = this.manuDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrAddr = this.mnrPrnrAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqDpcYr = this.eqDpcYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dvValue = this.dvValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dvCur = this.dvCur .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqDpcRt = this.eqDpcRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrRmk = this.mnrPrnrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrEml = this.mnrPrnrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.connNo = this.connNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrCntcPrnrNm = this.mnrCntcPrnrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intlFaxNo = this.intlFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intlPhnNo = this.intlPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
