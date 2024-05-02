/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SearchSREmlAtchFileListVO.java
*@FileTitle : SearchSREmlAtchFileListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.22
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2011.03.22 김기종 
* 1.0 Creation
* 2011.10.04 정선용 [CHM-201112445] SI Automation System 구축
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo;

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
 * @author 김기종
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSREmlAtchFileListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSREmlAtchFileListVO> models = new ArrayList<SearchSREmlAtchFileListVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String emlAtchFileNm = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String atchFilePathCtnt = null;
	/* Column Info */
	private String emlOrgSubjCtnt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String srKndCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String faxLogRefNo = null;
	/* Column Info */
	private String emlSubjCtnt = null;
	/* Column Info */
	private String emlAtchFileSzCapa = null;
	/* Column Info */
	private String srNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String emlAtchFileSeq = null;
	/* Column Info */
	private String convPdfFlg = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSREmlAtchFileListVO() {}

	public SearchSREmlAtchFileListVO(String ibflag, String pagerows, String srNo, String faxLogRefNo, String srKndCd, String emlAtchFileSeq, String atchFilePathCtnt, String emlAtchFileNm, String creUsrId, String creDt, String updUsrId, String updDt, String emlAtchFileSzCapa, String emlSubjCtnt, String emlOrgSubjCtnt, String convPdfFlg) {
		this.updDt = updDt;
		this.emlAtchFileNm = emlAtchFileNm;
		this.creDt = creDt;
		this.atchFilePathCtnt = atchFilePathCtnt;
		this.emlOrgSubjCtnt = emlOrgSubjCtnt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.srKndCd = srKndCd;
		this.creUsrId = creUsrId;
		this.faxLogRefNo = faxLogRefNo;
		this.emlSubjCtnt = emlSubjCtnt;
		this.emlAtchFileSzCapa = emlAtchFileSzCapa;
		this.srNo = srNo;
		this.updUsrId = updUsrId;
		this.emlAtchFileSeq = emlAtchFileSeq;
		this.convPdfFlg = convPdfFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("eml_atch_file_nm", getEmlAtchFileNm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("atch_file_path_ctnt", getAtchFilePathCtnt());
		this.hashColumns.put("eml_org_subj_ctnt", getEmlOrgSubjCtnt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sr_knd_cd", getSrKndCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("fax_log_ref_no", getFaxLogRefNo());
		this.hashColumns.put("eml_subj_ctnt", getEmlSubjCtnt());
		this.hashColumns.put("eml_atch_file_sz_capa", getEmlAtchFileSzCapa());
		this.hashColumns.put("sr_no", getSrNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("eml_atch_file_seq", getEmlAtchFileSeq());
		this.hashColumns.put("conv_pdf_flg", getConvPdfFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("eml_atch_file_nm", "emlAtchFileNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("atch_file_path_ctnt", "atchFilePathCtnt");
		this.hashFields.put("eml_org_subj_ctnt", "emlOrgSubjCtnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sr_knd_cd", "srKndCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("fax_log_ref_no", "faxLogRefNo");
		this.hashFields.put("eml_subj_ctnt", "emlSubjCtnt");
		this.hashFields.put("eml_atch_file_sz_capa", "emlAtchFileSzCapa");
		this.hashFields.put("sr_no", "srNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("eml_atch_file_seq", "emlAtchFileSeq");
		this.hashFields.put("conv_pdf_flg", "convPdfFlg");
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
	 * @return emlAtchFileNm
	 */
	public String getEmlAtchFileNm() {
		return this.emlAtchFileNm;
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
	 * @return atchFilePathCtnt
	 */
	public String getAtchFilePathCtnt() {
		return this.atchFilePathCtnt;
	}
	
	/**
	 * Column Info
	 * @return emlOrgSubjCtnt
	 */
	public String getEmlOrgSubjCtnt() {
		return this.emlOrgSubjCtnt;
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
	 * @return srKndCd
	 */
	public String getSrKndCd() {
		return this.srKndCd;
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
	 * @return faxLogRefNo
	 */
	public String getFaxLogRefNo() {
		return this.faxLogRefNo;
	}
	
	/**
	 * Column Info
	 * @return emlSubjCtnt
	 */
	public String getEmlSubjCtnt() {
		return this.emlSubjCtnt;
	}
	
	/**
	 * Column Info
	 * @return emlAtchFileSzCapa
	 */
	public String getEmlAtchFileSzCapa() {
		return this.emlAtchFileSzCapa;
	}
	
	/**
	 * Column Info
	 * @return srNo
	 */
	public String getSrNo() {
		return this.srNo;
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
	 * @return emlAtchFileSeq
	 */
	public String getEmlAtchFileSeq() {
		return this.emlAtchFileSeq;
	}
	

	public String getConvPdfFlg() {
		return convPdfFlg;
	}

	public void setConvPdfFlg(String convPdfFlg) {
		this.convPdfFlg = convPdfFlg;
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
	 * @param emlAtchFileNm
	 */
	public void setEmlAtchFileNm(String emlAtchFileNm) {
		this.emlAtchFileNm = emlAtchFileNm;
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
	 * @param atchFilePathCtnt
	 */
	public void setAtchFilePathCtnt(String atchFilePathCtnt) {
		this.atchFilePathCtnt = atchFilePathCtnt;
	}
	
	/**
	 * Column Info
	 * @param emlOrgSubjCtnt
	 */
	public void setEmlOrgSubjCtnt(String emlOrgSubjCtnt) {
		this.emlOrgSubjCtnt = emlOrgSubjCtnt;
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
	 * @param srKndCd
	 */
	public void setSrKndCd(String srKndCd) {
		this.srKndCd = srKndCd;
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
	 * @param faxLogRefNo
	 */
	public void setFaxLogRefNo(String faxLogRefNo) {
		this.faxLogRefNo = faxLogRefNo;
	}
	
	/**
	 * Column Info
	 * @param emlSubjCtnt
	 */
	public void setEmlSubjCtnt(String emlSubjCtnt) {
		this.emlSubjCtnt = emlSubjCtnt;
	}
	
	/**
	 * Column Info
	 * @param emlAtchFileSzCapa
	 */
	public void setEmlAtchFileSzCapa(String emlAtchFileSzCapa) {
		this.emlAtchFileSzCapa = emlAtchFileSzCapa;
	}
	
	/**
	 * Column Info
	 * @param srNo
	 */
	public void setSrNo(String srNo) {
		this.srNo = srNo;
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
	 * @param emlAtchFileSeq
	 */
	public void setEmlAtchFileSeq(String emlAtchFileSeq) {
		this.emlAtchFileSeq = emlAtchFileSeq;
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
		setEmlAtchFileNm(JSPUtil.getParameter(request, prefix + "eml_atch_file_nm", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setAtchFilePathCtnt(JSPUtil.getParameter(request, prefix + "atch_file_path_ctnt", ""));
		setEmlOrgSubjCtnt(JSPUtil.getParameter(request, prefix + "eml_org_subj_ctnt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSrKndCd(JSPUtil.getParameter(request, prefix + "sr_knd_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setFaxLogRefNo(JSPUtil.getParameter(request, prefix + "fax_log_ref_no", ""));
		setEmlSubjCtnt(JSPUtil.getParameter(request, prefix + "eml_subj_ctnt", ""));
		setEmlAtchFileSzCapa(JSPUtil.getParameter(request, prefix + "eml_atch_file_sz_capa", ""));
		setSrNo(JSPUtil.getParameter(request, prefix + "sr_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setEmlAtchFileSeq(JSPUtil.getParameter(request, prefix + "eml_atch_file_seq", ""));
		setConvPdfFlg(JSPUtil.getParameter(request, prefix + "conv_pdf_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSREmlAtchFileListVO[]
	 */
	public SearchSREmlAtchFileListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSREmlAtchFileListVO[]
	 */
	public SearchSREmlAtchFileListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSREmlAtchFileListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] emlAtchFileNm = (JSPUtil.getParameter(request, prefix	+ "eml_atch_file_nm", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] atchFilePathCtnt = (JSPUtil.getParameter(request, prefix	+ "atch_file_path_ctnt", length));
			String[] emlOrgSubjCtnt = (JSPUtil.getParameter(request, prefix	+ "eml_org_subj_ctnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] srKndCd = (JSPUtil.getParameter(request, prefix	+ "sr_knd_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] faxLogRefNo = (JSPUtil.getParameter(request, prefix	+ "fax_log_ref_no", length));
			String[] emlSubjCtnt = (JSPUtil.getParameter(request, prefix	+ "eml_subj_ctnt", length));
			String[] emlAtchFileSzCapa = (JSPUtil.getParameter(request, prefix	+ "eml_atch_file_sz_capa", length));
			String[] srNo = (JSPUtil.getParameter(request, prefix	+ "sr_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] emlAtchFileSeq = (JSPUtil.getParameter(request, prefix	+ "eml_atch_file_seq", length));
			String[] convPdfFlg = (JSPUtil.getParameter(request, prefix	+ "conv_pdf_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSREmlAtchFileListVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (emlAtchFileNm[i] != null)
					model.setEmlAtchFileNm(emlAtchFileNm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (atchFilePathCtnt[i] != null)
					model.setAtchFilePathCtnt(atchFilePathCtnt[i]);
				if (emlOrgSubjCtnt[i] != null)
					model.setEmlOrgSubjCtnt(emlOrgSubjCtnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (srKndCd[i] != null)
					model.setSrKndCd(srKndCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (faxLogRefNo[i] != null)
					model.setFaxLogRefNo(faxLogRefNo[i]);
				if (emlSubjCtnt[i] != null)
					model.setEmlSubjCtnt(emlSubjCtnt[i]);
				if (emlAtchFileSzCapa[i] != null)
					model.setEmlAtchFileSzCapa(emlAtchFileSzCapa[i]);
				if (srNo[i] != null)
					model.setSrNo(srNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (emlAtchFileSeq[i] != null)
					model.setEmlAtchFileSeq(emlAtchFileSeq[i]);
				if (convPdfFlg[i] != null)
					model.setConvPdfFlg(convPdfFlg[i]);				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSREmlAtchFileListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSREmlAtchFileListVO[]
	 */
	public SearchSREmlAtchFileListVO[] getSearchSREmlAtchFileListVOs(){
		SearchSREmlAtchFileListVO[] vos = (SearchSREmlAtchFileListVO[])models.toArray(new SearchSREmlAtchFileListVO[models.size()]);
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
		this.emlAtchFileNm = this.emlAtchFileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFilePathCtnt = this.atchFilePathCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlOrgSubjCtnt = this.emlOrgSubjCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srKndCd = this.srKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxLogRefNo = this.faxLogRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSubjCtnt = this.emlSubjCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlAtchFileSzCapa = this.emlAtchFileSzCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srNo = this.srNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlAtchFileSeq = this.emlAtchFileSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convPdfFlg = this.convPdfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
