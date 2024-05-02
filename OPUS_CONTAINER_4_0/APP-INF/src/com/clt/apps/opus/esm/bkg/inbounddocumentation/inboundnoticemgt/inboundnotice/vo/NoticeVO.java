/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : NoticeVO.java
*@FileTitle : NoticeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.19
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.19  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

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

public class NoticeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<NoticeVO> models = new ArrayList<NoticeVO>();
	
	/* Column Info */
	private String bkgNtcSndRsltCtnt = null;
	/* Column Info */
	private String sndRqstDt = null;
	/* Column Info */
	private String sndOfcCd = null;
	/* Column Info */
	private String sndGdt = null;
	/* Column Info */
	private String ntcKndCdDesc = null;
	/* Column Info */
	private String rowCount = null;
	/* Column Info */
	private String sndDt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ntcFaxNoEml = null;
	/* Column Info */
	private String sndUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String nfNm = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String sndRtyKnt = null;
	/* Column Info */
	private String bkgNtcSndRsltCd = null;
	/* Column Info */
	private String cnNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public NoticeVO() {}

	public NoticeVO(String ibflag, String pagerows, String ntcKndCdDesc, String blNo, String bkgNo, String cnNm, String nfNm, String sndRtyKnt, String bkgNtcSndRsltCd, String bkgNtcSndRsltCtnt, String ntcFaxNoEml, String sndRqstDt, String sndDt, String sndGdt, String sndOfcCd, String sndUsrId, String usrNm, String rowCount) {
		this.bkgNtcSndRsltCtnt = bkgNtcSndRsltCtnt;
		this.sndRqstDt = sndRqstDt;
		this.sndOfcCd = sndOfcCd;
		this.sndGdt = sndGdt;
		this.ntcKndCdDesc = ntcKndCdDesc;
		this.rowCount = rowCount;
		this.sndDt = sndDt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.ntcFaxNoEml = ntcFaxNoEml;
		this.sndUsrId = sndUsrId;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.nfNm = nfNm;
		this.usrNm = usrNm;
		this.sndRtyKnt = sndRtyKnt;
		this.bkgNtcSndRsltCd = bkgNtcSndRsltCd;
		this.cnNm = cnNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_ntc_snd_rslt_ctnt", getBkgNtcSndRsltCtnt());
		this.hashColumns.put("snd_rqst_dt", getSndRqstDt());
		this.hashColumns.put("snd_ofc_cd", getSndOfcCd());
		this.hashColumns.put("snd_gdt", getSndGdt());
		this.hashColumns.put("ntc_knd_cd_desc", getNtcKndCdDesc());
		this.hashColumns.put("row_count", getRowCount());
		this.hashColumns.put("snd_dt", getSndDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ntc_fax_no_eml", getNtcFaxNoEml());
		this.hashColumns.put("snd_usr_id", getSndUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("nf_nm", getNfNm());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("snd_rty_knt", getSndRtyKnt());
		this.hashColumns.put("bkg_ntc_snd_rslt_cd", getBkgNtcSndRsltCd());
		this.hashColumns.put("cn_nm", getCnNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_ntc_snd_rslt_ctnt", "bkgNtcSndRsltCtnt");
		this.hashFields.put("snd_rqst_dt", "sndRqstDt");
		this.hashFields.put("snd_ofc_cd", "sndOfcCd");
		this.hashFields.put("snd_gdt", "sndGdt");
		this.hashFields.put("ntc_knd_cd_desc", "ntcKndCdDesc");
		this.hashFields.put("row_count", "rowCount");
		this.hashFields.put("snd_dt", "sndDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ntc_fax_no_eml", "ntcFaxNoEml");
		this.hashFields.put("snd_usr_id", "sndUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("nf_nm", "nfNm");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("snd_rty_knt", "sndRtyKnt");
		this.hashFields.put("bkg_ntc_snd_rslt_cd", "bkgNtcSndRsltCd");
		this.hashFields.put("cn_nm", "cnNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgNtcSndRsltCtnt
	 */
	public String getBkgNtcSndRsltCtnt() {
		return this.bkgNtcSndRsltCtnt;
	}
	
	/**
	 * Column Info
	 * @return sndRqstDt
	 */
	public String getSndRqstDt() {
		return this.sndRqstDt;
	}
	
	/**
	 * Column Info
	 * @return sndOfcCd
	 */
	public String getSndOfcCd() {
		return this.sndOfcCd;
	}
	
	/**
	 * Column Info
	 * @return sndGdt
	 */
	public String getSndGdt() {
		return this.sndGdt;
	}
	
	/**
	 * Column Info
	 * @return ntcKndCdDesc
	 */
	public String getNtcKndCdDesc() {
		return this.ntcKndCdDesc;
	}
	
	/**
	 * Column Info
	 * @return rowCount
	 */
	public String getRowCount() {
		return this.rowCount;
	}
	
	/**
	 * Column Info
	 * @return sndDt
	 */
	public String getSndDt() {
		return this.sndDt;
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
	 * Column Info
	 * @return ntcFaxNoEml
	 */
	public String getNtcFaxNoEml() {
		return this.ntcFaxNoEml;
	}
	
	/**
	 * Column Info
	 * @return sndUsrId
	 */
	public String getSndUsrId() {
		return this.sndUsrId;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return nfNm
	 */
	public String getNfNm() {
		return this.nfNm;
	}
	
	/**
	 * Column Info
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
	}
	
	/**
	 * Column Info
	 * @return sndRtyKnt
	 */
	public String getSndRtyKnt() {
		return this.sndRtyKnt;
	}
	
	/**
	 * Column Info
	 * @return bkgNtcSndRsltCd
	 */
	public String getBkgNtcSndRsltCd() {
		return this.bkgNtcSndRsltCd;
	}
	
	/**
	 * Column Info
	 * @return cnNm
	 */
	public String getCnNm() {
		return this.cnNm;
	}
	

	/**
	 * Column Info
	 * @param bkgNtcSndRsltCtnt
	 */
	public void setBkgNtcSndRsltCtnt(String bkgNtcSndRsltCtnt) {
		this.bkgNtcSndRsltCtnt = bkgNtcSndRsltCtnt;
	}
	
	/**
	 * Column Info
	 * @param sndRqstDt
	 */
	public void setSndRqstDt(String sndRqstDt) {
		this.sndRqstDt = sndRqstDt;
	}
	
	/**
	 * Column Info
	 * @param sndOfcCd
	 */
	public void setSndOfcCd(String sndOfcCd) {
		this.sndOfcCd = sndOfcCd;
	}
	
	/**
	 * Column Info
	 * @param sndGdt
	 */
	public void setSndGdt(String sndGdt) {
		this.sndGdt = sndGdt;
	}
	
	/**
	 * Column Info
	 * @param ntcKndCdDesc
	 */
	public void setNtcKndCdDesc(String ntcKndCdDesc) {
		this.ntcKndCdDesc = ntcKndCdDesc;
	}
	
	/**
	 * Column Info
	 * @param rowCount
	 */
	public void setRowCount(String rowCount) {
		this.rowCount = rowCount;
	}
	
	/**
	 * Column Info
	 * @param sndDt
	 */
	public void setSndDt(String sndDt) {
		this.sndDt = sndDt;
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
	 * Column Info
	 * @param ntcFaxNoEml
	 */
	public void setNtcFaxNoEml(String ntcFaxNoEml) {
		this.ntcFaxNoEml = ntcFaxNoEml;
	}
	
	/**
	 * Column Info
	 * @param sndUsrId
	 */
	public void setSndUsrId(String sndUsrId) {
		this.sndUsrId = sndUsrId;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param nfNm
	 */
	public void setNfNm(String nfNm) {
		this.nfNm = nfNm;
	}
	
	/**
	 * Column Info
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	
	/**
	 * Column Info
	 * @param sndRtyKnt
	 */
	public void setSndRtyKnt(String sndRtyKnt) {
		this.sndRtyKnt = sndRtyKnt;
	}
	
	/**
	 * Column Info
	 * @param bkgNtcSndRsltCd
	 */
	public void setBkgNtcSndRsltCd(String bkgNtcSndRsltCd) {
		this.bkgNtcSndRsltCd = bkgNtcSndRsltCd;
	}
	
	/**
	 * Column Info
	 * @param cnNm
	 */
	public void setCnNm(String cnNm) {
		this.cnNm = cnNm;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBkgNtcSndRsltCtnt(JSPUtil.getParameter(request, "bkg_ntc_snd_rslt_ctnt", ""));
		setSndRqstDt(JSPUtil.getParameter(request, "snd_rqst_dt", ""));
		setSndOfcCd(JSPUtil.getParameter(request, "snd_ofc_cd", ""));
		setSndGdt(JSPUtil.getParameter(request, "snd_gdt", ""));
		setNtcKndCdDesc(JSPUtil.getParameter(request, "ntc_knd_cd_desc", ""));
		setRowCount(JSPUtil.getParameter(request, "row_count", ""));
		setSndDt(JSPUtil.getParameter(request, "snd_dt", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setNtcFaxNoEml(JSPUtil.getParameter(request, "ntc_fax_no_eml", ""));
		setSndUsrId(JSPUtil.getParameter(request, "snd_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setNfNm(JSPUtil.getParameter(request, "nf_nm", ""));
		setUsrNm(JSPUtil.getParameter(request, "usr_nm", ""));
		setSndRtyKnt(JSPUtil.getParameter(request, "snd_rty_knt", ""));
		setBkgNtcSndRsltCd(JSPUtil.getParameter(request, "bkg_ntc_snd_rslt_cd", ""));
		setCnNm(JSPUtil.getParameter(request, "cn_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return NoticeVO[]
	 */
	public NoticeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return NoticeVO[]
	 */
	public NoticeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		NoticeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgNtcSndRsltCtnt = (JSPUtil.getParameter(request, prefix	+ "bkg_ntc_snd_rslt_ctnt", length));
			String[] sndRqstDt = (JSPUtil.getParameter(request, prefix	+ "snd_rqst_dt", length));
			String[] sndOfcCd = (JSPUtil.getParameter(request, prefix	+ "snd_ofc_cd", length));
			String[] sndGdt = (JSPUtil.getParameter(request, prefix	+ "snd_gdt", length));
			String[] ntcKndCdDesc = (JSPUtil.getParameter(request, prefix	+ "ntc_knd_cd_desc", length));
			String[] rowCount = (JSPUtil.getParameter(request, prefix	+ "row_count", length));
			String[] sndDt = (JSPUtil.getParameter(request, prefix	+ "snd_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ntcFaxNoEml = (JSPUtil.getParameter(request, prefix	+ "ntc_fax_no_eml", length));
			String[] sndUsrId = (JSPUtil.getParameter(request, prefix	+ "snd_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] nfNm = (JSPUtil.getParameter(request, prefix	+ "nf_nm", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] sndRtyKnt = (JSPUtil.getParameter(request, prefix	+ "snd_rty_knt", length));
			String[] bkgNtcSndRsltCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ntc_snd_rslt_cd", length));
			String[] cnNm = (JSPUtil.getParameter(request, prefix	+ "cn_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new NoticeVO();
				if (bkgNtcSndRsltCtnt[i] != null)
					model.setBkgNtcSndRsltCtnt(bkgNtcSndRsltCtnt[i]);
				if (sndRqstDt[i] != null)
					model.setSndRqstDt(sndRqstDt[i]);
				if (sndOfcCd[i] != null)
					model.setSndOfcCd(sndOfcCd[i]);
				if (sndGdt[i] != null)
					model.setSndGdt(sndGdt[i]);
				if (ntcKndCdDesc[i] != null)
					model.setNtcKndCdDesc(ntcKndCdDesc[i]);
				if (rowCount[i] != null)
					model.setRowCount(rowCount[i]);
				if (sndDt[i] != null)
					model.setSndDt(sndDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ntcFaxNoEml[i] != null)
					model.setNtcFaxNoEml(ntcFaxNoEml[i]);
				if (sndUsrId[i] != null)
					model.setSndUsrId(sndUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (nfNm[i] != null)
					model.setNfNm(nfNm[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (sndRtyKnt[i] != null)
					model.setSndRtyKnt(sndRtyKnt[i]);
				if (bkgNtcSndRsltCd[i] != null)
					model.setBkgNtcSndRsltCd(bkgNtcSndRsltCd[i]);
				if (cnNm[i] != null)
					model.setCnNm(cnNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getNoticeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return NoticeVO[]
	 */
	public NoticeVO[] getNoticeVOs(){
		NoticeVO[] vos = (NoticeVO[])models.toArray(new NoticeVO[models.size()]);
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
		this.bkgNtcSndRsltCtnt = this.bkgNtcSndRsltCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndRqstDt = this.sndRqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndOfcCd = this.sndOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndGdt = this.sndGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcKndCdDesc = this.ntcKndCdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowCount = this.rowCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDt = this.sndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcFaxNoEml = this.ntcFaxNoEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndUsrId = this.sndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfNm = this.nfNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndRtyKnt = this.sndRtyKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNtcSndRsltCd = this.bkgNtcSndRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnNm = this.cnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
