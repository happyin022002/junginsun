/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustomDocHeaderVO.java
*@FileTitle : CustomDocHeaderVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.15
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2010.01.15 김완규 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo;

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
 * @author 김완규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomDocHeaderVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomDocHeaderVO> models = new ArrayList<CustomDocHeaderVO>();
	
	/* Column Info */
	private String docSubject = null;
	/* Column Info */
	private String dispNo = null;
	/* Column Info */
	private String memo = null;
	/* Column Info */
	private String mnrGrpTpCd = null;
	/* Column Info */
	private String mnrPrnrCntCd = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String ediId = null;
	/* Column Info */
	private String trsmModCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mnrPrnrSeq = null;
	/* Column Info */
	private String userNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String woTypeCode = null;
	/* Column Info */
	private String woType = null;
	/* Column Info */
	private String mnrOrdSeq = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String mnrPrnrEml = null;
	/* Column Info */
	private String faxNo = null;
	/* Column Info */
	private String sel = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomDocHeaderVO() {}

	public CustomDocHeaderVO(String ibflag, String pagerows, String docSubject, String memo, String mnrGrpTpCd, String vndrLglEngNm, String ediId, String trsmModCd, String woTypeCode, String woType, String mnrOrdSeq, String vndrSeq, String mnrPrnrEml, String faxNo, String sel, String dispNo, String userNm, String mnrPrnrCntCd, String mnrPrnrSeq) {
		this.docSubject = docSubject;
		this.dispNo = dispNo;
		this.memo = memo;
		this.mnrGrpTpCd = mnrGrpTpCd;
		this.mnrPrnrCntCd = mnrPrnrCntCd;
		this.vndrLglEngNm = vndrLglEngNm;
		this.ediId = ediId;
		this.trsmModCd = trsmModCd;
		this.pagerows = pagerows;
		this.mnrPrnrSeq = mnrPrnrSeq;
		this.userNm = userNm;
		this.ibflag = ibflag;
		this.woTypeCode = woTypeCode;
		this.woType = woType;
		this.mnrOrdSeq = mnrOrdSeq;
		this.vndrSeq = vndrSeq;
		this.mnrPrnrEml = mnrPrnrEml;
		this.faxNo = faxNo;
		this.sel = sel;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("doc_subject", getDocSubject());
		this.hashColumns.put("disp_no", getDispNo());
		this.hashColumns.put("memo", getMemo());
		this.hashColumns.put("mnr_grp_tp_cd", getMnrGrpTpCd());
		this.hashColumns.put("mnr_prnr_cnt_cd", getMnrPrnrCntCd());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("edi_id", getEdiId());
		this.hashColumns.put("trsm_mod_cd", getTrsmModCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mnr_prnr_seq", getMnrPrnrSeq());
		this.hashColumns.put("user_nm", getUserNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("wo_type_code", getWoTypeCode());
		this.hashColumns.put("wo_type", getWoType());
		this.hashColumns.put("mnr_ord_seq", getMnrOrdSeq());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("mnr_prnr_eml", getMnrPrnrEml());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("sel", getSel());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("doc_subject", "docSubject");
		this.hashFields.put("disp_no", "dispNo");
		this.hashFields.put("memo", "memo");
		this.hashFields.put("mnr_grp_tp_cd", "mnrGrpTpCd");
		this.hashFields.put("mnr_prnr_cnt_cd", "mnrPrnrCntCd");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("edi_id", "ediId");
		this.hashFields.put("trsm_mod_cd", "trsmModCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mnr_prnr_seq", "mnrPrnrSeq");
		this.hashFields.put("user_nm", "userNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("wo_type_code", "woTypeCode");
		this.hashFields.put("wo_type", "woType");
		this.hashFields.put("mnr_ord_seq", "mnrOrdSeq");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("mnr_prnr_eml", "mnrPrnrEml");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("sel", "sel");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return docSubject
	 */
	public String getDocSubject() {
		return this.docSubject;
	}
	
	/**
	 * Column Info
	 * @return dispNo
	 */
	public String getDispNo() {
		return this.dispNo;
	}
	
	/**
	 * Column Info
	 * @return memo
	 */
	public String getMemo() {
		return this.memo;
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
	 * @return mnrPrnrCntCd
	 */
	public String getMnrPrnrCntCd() {
		return this.mnrPrnrCntCd;
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
	 * @return ediId
	 */
	public String getEdiId() {
		return this.ediId;
	}
	
	/**
	 * Column Info
	 * @return trsmModCd
	 */
	public String getTrsmModCd() {
		return this.trsmModCd;
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
	 * @return mnrPrnrSeq
	 */
	public String getMnrPrnrSeq() {
		return this.mnrPrnrSeq;
	}
	
	/**
	 * Column Info
	 * @return userNm
	 */
	public String getUserNm() {
		return this.userNm;
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
	 * @return woTypeCode
	 */
	public String getWoTypeCode() {
		return this.woTypeCode;
	}
	
	/**
	 * Column Info
	 * @return woType
	 */
	public String getWoType() {
		return this.woType;
	}
	
	/**
	 * Column Info
	 * @return mnrOrdSeq
	 */
	public String getMnrOrdSeq() {
		return this.mnrOrdSeq;
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
	 * @return mnrPrnrEml
	 */
	public String getMnrPrnrEml() {
		return this.mnrPrnrEml;
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
	 * @return sel
	 */
	public String getSel() {
		return this.sel;
	}
	

	/**
	 * Column Info
	 * @param docSubject
	 */
	public void setDocSubject(String docSubject) {
		this.docSubject = docSubject;
	}
	
	/**
	 * Column Info
	 * @param dispNo
	 */
	public void setDispNo(String dispNo) {
		this.dispNo = dispNo;
	}
	
	/**
	 * Column Info
	 * @param memo
	 */
	public void setMemo(String memo) {
		this.memo = memo;
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
	 * @param mnrPrnrCntCd
	 */
	public void setMnrPrnrCntCd(String mnrPrnrCntCd) {
		this.mnrPrnrCntCd = mnrPrnrCntCd;
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
	 * @param ediId
	 */
	public void setEdiId(String ediId) {
		this.ediId = ediId;
	}
	
	/**
	 * Column Info
	 * @param trsmModCd
	 */
	public void setTrsmModCd(String trsmModCd) {
		this.trsmModCd = trsmModCd;
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
	 * @param mnrPrnrSeq
	 */
	public void setMnrPrnrSeq(String mnrPrnrSeq) {
		this.mnrPrnrSeq = mnrPrnrSeq;
	}
	
	/**
	 * Column Info
	 * @param userNm
	 */
	public void setUserNm(String userNm) {
		this.userNm = userNm;
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
	 * @param woTypeCode
	 */
	public void setWoTypeCode(String woTypeCode) {
		this.woTypeCode = woTypeCode;
	}
	
	/**
	 * Column Info
	 * @param woType
	 */
	public void setWoType(String woType) {
		this.woType = woType;
	}
	
	/**
	 * Column Info
	 * @param mnrOrdSeq
	 */
	public void setMnrOrdSeq(String mnrOrdSeq) {
		this.mnrOrdSeq = mnrOrdSeq;
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
	 * @param mnrPrnrEml
	 */
	public void setMnrPrnrEml(String mnrPrnrEml) {
		this.mnrPrnrEml = mnrPrnrEml;
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
	 * @param sel
	 */
	public void setSel(String sel) {
		this.sel = sel;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setDocSubject(JSPUtil.getParameter(request, "doc_subject", ""));
		setDispNo(JSPUtil.getParameter(request, "disp_no", ""));
		setMemo(JSPUtil.getParameter(request, "memo", ""));
		setMnrGrpTpCd(JSPUtil.getParameter(request, "mnr_grp_tp_cd", ""));
		setMnrPrnrCntCd(JSPUtil.getParameter(request, "mnr_prnr_cnt_cd", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, "vndr_lgl_eng_nm", ""));
		setEdiId(JSPUtil.getParameter(request, "edi_id", ""));
		setTrsmModCd(JSPUtil.getParameter(request, "trsm_mod_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setMnrPrnrSeq(JSPUtil.getParameter(request, "mnr_prnr_seq", ""));
		setUserNm(JSPUtil.getParameter(request, "user_nm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setWoTypeCode(JSPUtil.getParameter(request, "wo_type_code", ""));
		setWoType(JSPUtil.getParameter(request, "wo_type", ""));
		setMnrOrdSeq(JSPUtil.getParameter(request, "mnr_ord_seq", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setMnrPrnrEml(JSPUtil.getParameter(request, "mnr_prnr_eml", ""));
		setFaxNo(JSPUtil.getParameter(request, "fax_no", ""));
		setSel(JSPUtil.getParameter(request, "sel", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomDocHeaderVO[]
	 */
	public CustomDocHeaderVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomDocHeaderVO[]
	 */
	public CustomDocHeaderVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomDocHeaderVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] docSubject = (JSPUtil.getParameter(request, prefix	+ "doc_subject", length));
			String[] dispNo = (JSPUtil.getParameter(request, prefix	+ "disp_no", length));
			String[] memo = (JSPUtil.getParameter(request, prefix	+ "memo", length));
			String[] mnrGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_grp_tp_cd", length));
			String[] mnrPrnrCntCd = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_cnt_cd", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] ediId = (JSPUtil.getParameter(request, prefix	+ "edi_id", length));
			String[] trsmModCd = (JSPUtil.getParameter(request, prefix	+ "trsm_mod_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mnrPrnrSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_seq", length));
			String[] userNm = (JSPUtil.getParameter(request, prefix	+ "user_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] woTypeCode = (JSPUtil.getParameter(request, prefix	+ "wo_type_code", length));
			String[] woType = (JSPUtil.getParameter(request, prefix	+ "wo_type", length));
			String[] mnrOrdSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_ord_seq", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] mnrPrnrEml = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_eml", length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no", length));
			String[] sel = (JSPUtil.getParameter(request, prefix	+ "sel", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomDocHeaderVO();
				if (docSubject[i] != null)
					model.setDocSubject(docSubject[i]);
				if (dispNo[i] != null)
					model.setDispNo(dispNo[i]);
				if (memo[i] != null)
					model.setMemo(memo[i]);
				if (mnrGrpTpCd[i] != null)
					model.setMnrGrpTpCd(mnrGrpTpCd[i]);
				if (mnrPrnrCntCd[i] != null)
					model.setMnrPrnrCntCd(mnrPrnrCntCd[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (ediId[i] != null)
					model.setEdiId(ediId[i]);
				if (trsmModCd[i] != null)
					model.setTrsmModCd(trsmModCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mnrPrnrSeq[i] != null)
					model.setMnrPrnrSeq(mnrPrnrSeq[i]);
				if (userNm[i] != null)
					model.setUserNm(userNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (woTypeCode[i] != null)
					model.setWoTypeCode(woTypeCode[i]);
				if (woType[i] != null)
					model.setWoType(woType[i]);
				if (mnrOrdSeq[i] != null)
					model.setMnrOrdSeq(mnrOrdSeq[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (mnrPrnrEml[i] != null)
					model.setMnrPrnrEml(mnrPrnrEml[i]);
				if (faxNo[i] != null)
					model.setFaxNo(faxNo[i]);
				if (sel[i] != null)
					model.setSel(sel[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomDocHeaderVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomDocHeaderVO[]
	 */
	public CustomDocHeaderVO[] getCustomDocHeaderVOs(){
		CustomDocHeaderVO[] vos = (CustomDocHeaderVO[])models.toArray(new CustomDocHeaderVO[models.size()]);
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
		this.docSubject = this.docSubject .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispNo = this.dispNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.memo = this.memo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrGrpTpCd = this.mnrGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrCntCd = this.mnrPrnrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediId = this.ediId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmModCd = this.trsmModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrSeq = this.mnrPrnrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userNm = this.userNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woTypeCode = this.woTypeCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woType = this.woType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrOrdSeq = this.mnrOrdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrEml = this.mnrPrnrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sel = this.sel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
