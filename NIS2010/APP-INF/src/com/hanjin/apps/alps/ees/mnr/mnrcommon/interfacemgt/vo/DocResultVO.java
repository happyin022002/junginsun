/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DocResultVO.java
*@FileTitle : DocResultVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.30
*@LastModifier : 신혜정
*@LastVersion : 1.0
* 2009.09.15 함형석 
* 1.0 Creation
* --------------------------------------------------------
* History
* 2012.07.31 신혜정	[CHM-201219139]	FA Interface 로그 보완 작업	
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo;

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
 * @author 함형석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DocResultVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DocResultVO> models = new ArrayList<DocResultVO>();
	
	/* Column Info */
	private String mnrIfDt = null;
	/* Column Info */
	private String mnrGrpTpCd = null;
	/* Column Info */
	private String tmplMrd = null;
	/* Column Info */
	private String mnrIfMsgCtnt = null;
	/* Column Info */
	private String sndrEml = null;
	/* Column Info */
	private String emlCtnt = null;
	/* Column Info */
	private String faxOffice = null;
	/* Column Info */
	private String docTitNm = null;
	/* Column Info */
	private String pagerows = null;
	/* Column Info */
	private String emlFileKeys = null;
	/* Column Info */
	private String mnrOrdOfcCtyCd = null;
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String paraInfoCtnt = null;
	/* Column Info */
	private String batFlg = null;
	/* Column Info */
	private String receiverRmail = null;
	/* Column Info */
	private String mnrRefNo = null;
	/* Column Info */
	private String faxRcvInfo = null;
	/* Column Info */
	private String ediId = null;
	/* Column Info */
	private String trsmModCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String rdSubSysCd = null;
	/* Column Info */
	private String mnrOrdSeq = null;
	/* Column Info */
	private String templateFile = null;
	/* Column Info */
	private String flatFile = null;
	/* Column Info */
	private String sndrNm = null;
	/* Column Info */
	private String ifTrcSeq = null;
	/* Column Info */
	private String templateArgs = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DocResultVO() {}

	public DocResultVO(String ibflag, String pagerows, String faxRcvInfo, String tmplMrd, String sndrEml, String ediId, String emlCtnt, String trsmModCd, String faxOffice, String docTitNm, String emlFileKeys, String mnrOrdOfcCtyCd, String creUsrId, String rdSubSysCd, String paraInfoCtnt, String batFlg, String mnrOrdSeq, String templateFile, String receiverRmail, String mnrRefNo, String flatFile, String sndrNm, String ifTrcSeq, String templateArgs, String mnrIfDt, String mnrIfMsgCtnt, String mnrGrpTpCd) {
		this.mnrIfDt = mnrIfDt;
		this.mnrGrpTpCd = mnrGrpTpCd;
		this.tmplMrd = tmplMrd;
		this.mnrIfMsgCtnt = mnrIfMsgCtnt;
		this.sndrEml = sndrEml;
		this.emlCtnt = emlCtnt;
		this.faxOffice = faxOffice;
		this.docTitNm = docTitNm;
		this.pagerows = pagerows;
		this.emlFileKeys = emlFileKeys;
		this.mnrOrdOfcCtyCd = mnrOrdOfcCtyCd;
		this.ibflag = ibflag;
		this.paraInfoCtnt = paraInfoCtnt;
		this.batFlg = batFlg;
		this.receiverRmail = receiverRmail;
		this.mnrRefNo = mnrRefNo;
		this.faxRcvInfo = faxRcvInfo;
		this.ediId = ediId;
		this.trsmModCd = trsmModCd;
		this.creUsrId = creUsrId;
		this.rdSubSysCd = rdSubSysCd;
		this.mnrOrdSeq = mnrOrdSeq;
		this.templateFile = templateFile;
		this.flatFile = flatFile;
		this.sndrNm = sndrNm;
		this.ifTrcSeq = ifTrcSeq;
		this.templateArgs = templateArgs;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mnr_if_dt", getMnrIfDt());
		this.hashColumns.put("mnr_grp_tp_cd", getMnrGrpTpCd());
		this.hashColumns.put("tmpl_mrd", getTmplMrd());
		this.hashColumns.put("mnr_if_msg_ctnt", getMnrIfMsgCtnt());
		this.hashColumns.put("sndr_eml", getSndrEml());
		this.hashColumns.put("eml_ctnt", getEmlCtnt());
		this.hashColumns.put("fax_office", getFaxOffice());
		this.hashColumns.put("doc_tit_nm", getDocTitNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eml_file_keys", getEmlFileKeys());
		this.hashColumns.put("mnr_ord_ofc_cty_cd", getMnrOrdOfcCtyCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("para_info_ctnt", getParaInfoCtnt());
		this.hashColumns.put("bat_flg", getBatFlg());
		this.hashColumns.put("receiver_rmail", getReceiverRmail());
		this.hashColumns.put("mnr_ref_no", getMnrRefNo());
		this.hashColumns.put("fax_rcv_info", getFaxRcvInfo());
		this.hashColumns.put("edi_id", getEdiId());
		this.hashColumns.put("trsm_mod_cd", getTrsmModCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("rd_sub_sys_cd", getRdSubSysCd());
		this.hashColumns.put("mnr_ord_seq", getMnrOrdSeq());
		this.hashColumns.put("template_file", getTemplateFile());
		this.hashColumns.put("flat_file", getFlatFile());
		this.hashColumns.put("sndr_nm", getSndrNm());
		this.hashColumns.put("if_trc_seq", getIfTrcSeq());
		this.hashColumns.put("template_args", getTemplateArgs());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mnr_if_dt", "mnrIfDt");
		this.hashFields.put("mnr_grp_tp_cd", "mnrGrpTpCd");
		this.hashFields.put("tmpl_mrd", "tmplMrd");
		this.hashFields.put("mnr_if_msg_ctnt", "mnrIfMsgCtnt");
		this.hashFields.put("sndr_eml", "sndrEml");
		this.hashFields.put("eml_ctnt", "emlCtnt");
		this.hashFields.put("fax_office", "faxOffice");
		this.hashFields.put("doc_tit_nm", "docTitNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eml_file_keys", "emlFileKeys");
		this.hashFields.put("mnr_ord_ofc_cty_cd", "mnrOrdOfcCtyCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("para_info_ctnt", "paraInfoCtnt");
		this.hashFields.put("bat_flg", "batFlg");
		this.hashFields.put("receiver_rmail", "receiverRmail");
		this.hashFields.put("mnr_ref_no", "mnrRefNo");
		this.hashFields.put("fax_rcv_info", "faxRcvInfo");
		this.hashFields.put("edi_id", "ediId");
		this.hashFields.put("trsm_mod_cd", "trsmModCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("rd_sub_sys_cd", "rdSubSysCd");
		this.hashFields.put("mnr_ord_seq", "mnrOrdSeq");
		this.hashFields.put("template_file", "templateFile");
		this.hashFields.put("flat_file", "flatFile");
		this.hashFields.put("sndr_nm", "sndrNm");
		this.hashFields.put("if_trc_seq", "ifTrcSeq");
		this.hashFields.put("template_args", "templateArgs");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mnrIfDt
	 */
	public String getMnrIfDt() {
		return this.mnrIfDt;
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
	 * @return tmplMrd
	 */
	public String getTmplMrd() {
		return this.tmplMrd;
	}
	
	/**
	 * Column Info
	 * @return mnrIfMsgCtnt
	 */
	public String getMnrIfMsgCtnt() {
		return this.mnrIfMsgCtnt;
	}
	
	/**
	 * Column Info
	 * @return sndrEml
	 */
	public String getSndrEml() {
		return this.sndrEml;
	}
	
	/**
	 * Column Info
	 * @return emlCtnt
	 */
	public String getEmlCtnt() {
		return this.emlCtnt;
	}
	
	/**
	 * Column Info
	 * @return faxOffice
	 */
	public String getFaxOffice() {
		return this.faxOffice;
	}
	
	/**
	 * Column Info
	 * @return docTitNm
	 */
	public String getDocTitNm() {
		return this.docTitNm;
	}
	
	/**
	 * Column Info
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return emlFileKeys
	 */
	public String getEmlFileKeys() {
		return this.emlFileKeys;
	}
	
	/**
	 * Column Info
	 * @return mnrOrdOfcCtyCd
	 */
	public String getMnrOrdOfcCtyCd() {
		return this.mnrOrdOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return paraInfoCtnt
	 */
	public String getParaInfoCtnt() {
		return this.paraInfoCtnt;
	}
	
	/**
	 * Column Info
	 * @return batFlg
	 */
	public String getBatFlg() {
		return this.batFlg;
	}
	
	/**
	 * Column Info
	 * @return receiverRmail
	 */
	public String getReceiverRmail() {
		return this.receiverRmail;
	}
	
	/**
	 * Column Info
	 * @return mnrRefNo
	 */
	public String getMnrRefNo() {
		return this.mnrRefNo;
	}
	
	/**
	 * Column Info
	 * @return faxRcvInfo
	 */
	public String getFaxRcvInfo() {
		return this.faxRcvInfo;
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
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return rdSubSysCd
	 */
	public String getRdSubSysCd() {
		return this.rdSubSysCd;
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
	 * @return templateFile
	 */
	public String getTemplateFile() {
		return this.templateFile;
	}
	
	/**
	 * Column Info
	 * @return flatFile
	 */
	public String getFlatFile() {
		return this.flatFile;
	}
	
	/**
	 * Column Info
	 * @return sndrNm
	 */
	public String getSndrNm() {
		return this.sndrNm;
	}
	
	/**
	 * Column Info
	 * @return ifTrcSeq
	 */
	public String getIfTrcSeq() {
		return this.ifTrcSeq;
	}
	
	/**
	 * Column Info
	 * @return templateArgs
	 */
	public String getTemplateArgs() {
		return this.templateArgs;
	}
	

	/**
	 * Column Info
	 * @param mnrIfDt
	 */
	public void setMnrIfDt(String mnrIfDt) {
		this.mnrIfDt = mnrIfDt;
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
	 * @param tmplMrd
	 */
	public void setTmplMrd(String tmplMrd) {
		this.tmplMrd = tmplMrd;
	}
	
	/**
	 * Column Info
	 * @param mnrIfMsgCtnt
	 */
	public void setMnrIfMsgCtnt(String mnrIfMsgCtnt) {
		this.mnrIfMsgCtnt = mnrIfMsgCtnt;
	}
	
	/**
	 * Column Info
	 * @param sndrEml
	 */
	public void setSndrEml(String sndrEml) {
		this.sndrEml = sndrEml;
	}
	
	/**
	 * Column Info
	 * @param emlCtnt
	 */
	public void setEmlCtnt(String emlCtnt) {
		this.emlCtnt = emlCtnt;
	}
	
	/**
	 * Column Info
	 * @param faxOffice
	 */
	public void setFaxOffice(String faxOffice) {
		this.faxOffice = faxOffice;
	}
	
	/**
	 * Column Info
	 * @param docTitNm
	 */
	public void setDocTitNm(String docTitNm) {
		this.docTitNm = docTitNm;
	}
	
	/**
	 * Column Info
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param emlFileKeys
	 */
	public void setEmlFileKeys(String emlFileKeys) {
		this.emlFileKeys = emlFileKeys;
	}
	
	/**
	 * Column Info
	 * @param mnrOrdOfcCtyCd
	 */
	public void setMnrOrdOfcCtyCd(String mnrOrdOfcCtyCd) {
		this.mnrOrdOfcCtyCd = mnrOrdOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param paraInfoCtnt
	 */
	public void setParaInfoCtnt(String paraInfoCtnt) {
		this.paraInfoCtnt = paraInfoCtnt;
	}
	
	/**
	 * Column Info
	 * @param batFlg
	 */
	public void setBatFlg(String batFlg) {
		this.batFlg = batFlg;
	}
	
	/**
	 * Column Info
	 * @param receiverRmail
	 */
	public void setReceiverRmail(String receiverRmail) {
		this.receiverRmail = receiverRmail;
	}
	
	/**
	 * Column Info
	 * @param mnrRefNo
	 */
	public void setMnrRefNo(String mnrRefNo) {
		this.mnrRefNo = mnrRefNo;
	}
	
	/**
	 * Column Info
	 * @param faxRcvInfo
	 */
	public void setFaxRcvInfo(String faxRcvInfo) {
		this.faxRcvInfo = faxRcvInfo;
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
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param rdSubSysCd
	 */
	public void setRdSubSysCd(String rdSubSysCd) {
		this.rdSubSysCd = rdSubSysCd;
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
	 * @param templateFile
	 */
	public void setTemplateFile(String templateFile) {
		this.templateFile = templateFile;
	}
	
	/**
	 * Column Info
	 * @param flatFile
	 */
	public void setFlatFile(String flatFile) {
		this.flatFile = flatFile;
	}
	
	/**
	 * Column Info
	 * @param sndrNm
	 */
	public void setSndrNm(String sndrNm) {
		this.sndrNm = sndrNm;
	}
	
	/**
	 * Column Info
	 * @param ifTrcSeq
	 */
	public void setIfTrcSeq(String ifTrcSeq) {
		this.ifTrcSeq = ifTrcSeq;
	}
	
	/**
	 * Column Info
	 * @param templateArgs
	 */
	public void setTemplateArgs(String templateArgs) {
		this.templateArgs = templateArgs;
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
		setMnrIfDt(JSPUtil.getParameter(request, prefix + "mnr_if_dt", ""));
		setMnrGrpTpCd(JSPUtil.getParameter(request, prefix + "mnr_grp_tp_cd", ""));
		setTmplMrd(JSPUtil.getParameter(request, prefix + "tmpl_mrd", ""));
		setMnrIfMsgCtnt(JSPUtil.getParameter(request, prefix + "mnr_if_msg_ctnt", ""));
		setSndrEml(JSPUtil.getParameter(request, prefix + "sndr_eml", ""));
		setEmlCtnt(JSPUtil.getParameter(request, prefix + "eml_ctnt", ""));
		setFaxOffice(JSPUtil.getParameter(request, prefix + "fax_office", ""));
		setDocTitNm(JSPUtil.getParameter(request, prefix + "doc_tit_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEmlFileKeys(JSPUtil.getParameter(request, prefix + "eml_file_keys", ""));
		setMnrOrdOfcCtyCd(JSPUtil.getParameter(request, prefix + "mnr_ord_ofc_cty_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setParaInfoCtnt(JSPUtil.getParameter(request, prefix + "para_info_ctnt", ""));
		setBatFlg(JSPUtil.getParameter(request, prefix + "bat_flg", ""));
		setReceiverRmail(JSPUtil.getParameter(request, prefix + "receiver_rmail", ""));
		setMnrRefNo(JSPUtil.getParameter(request, prefix + "mnr_ref_no", ""));
		setFaxRcvInfo(JSPUtil.getParameter(request, prefix + "fax_rcv_info", ""));
		setEdiId(JSPUtil.getParameter(request, prefix + "edi_id", ""));
		setTrsmModCd(JSPUtil.getParameter(request, prefix + "trsm_mod_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setRdSubSysCd(JSPUtil.getParameter(request, prefix + "rd_sub_sys_cd", ""));
		setMnrOrdSeq(JSPUtil.getParameter(request, prefix + "mnr_ord_seq", ""));
		setTemplateFile(JSPUtil.getParameter(request, prefix + "template_file", ""));
		setFlatFile(JSPUtil.getParameter(request, prefix + "flat_file", ""));
		setSndrNm(JSPUtil.getParameter(request, prefix + "sndr_nm", ""));
		setIfTrcSeq(JSPUtil.getParameter(request, prefix + "if_trc_seq", ""));
		setTemplateArgs(JSPUtil.getParameter(request, prefix + "template_args", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DocResultVO[]
	 */
	public DocResultVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DocResultVO[]
	 */
	public DocResultVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DocResultVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mnrIfDt = (JSPUtil.getParameter(request, prefix	+ "mnr_if_dt", length));
			String[] mnrGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_grp_tp_cd", length));
			String[] tmplMrd = (JSPUtil.getParameter(request, prefix	+ "tmpl_mrd", length));
			String[] mnrIfMsgCtnt = (JSPUtil.getParameter(request, prefix	+ "mnr_if_msg_ctnt", length));
			String[] sndrEml = (JSPUtil.getParameter(request, prefix	+ "sndr_eml", length));
			String[] emlCtnt = (JSPUtil.getParameter(request, prefix	+ "eml_ctnt", length));
			String[] faxOffice = (JSPUtil.getParameter(request, prefix	+ "fax_office", length));
			String[] docTitNm = (JSPUtil.getParameter(request, prefix	+ "doc_tit_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] emlFileKeys = (JSPUtil.getParameter(request, prefix	+ "eml_file_keys", length));
			String[] mnrOrdOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "mnr_ord_ofc_cty_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] paraInfoCtnt = (JSPUtil.getParameter(request, prefix	+ "para_info_ctnt", length));
			String[] batFlg = (JSPUtil.getParameter(request, prefix	+ "bat_flg", length));
			String[] receiverRmail = (JSPUtil.getParameter(request, prefix	+ "receiver_rmail", length));
			String[] mnrRefNo = (JSPUtil.getParameter(request, prefix	+ "mnr_ref_no", length));
			String[] faxRcvInfo = (JSPUtil.getParameter(request, prefix	+ "fax_rcv_info", length));
			String[] ediId = (JSPUtil.getParameter(request, prefix	+ "edi_id", length));
			String[] trsmModCd = (JSPUtil.getParameter(request, prefix	+ "trsm_mod_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] rdSubSysCd = (JSPUtil.getParameter(request, prefix	+ "rd_sub_sys_cd", length));
			String[] mnrOrdSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_ord_seq", length));
			String[] templateFile = (JSPUtil.getParameter(request, prefix	+ "template_file", length));
			String[] flatFile = (JSPUtil.getParameter(request, prefix	+ "flat_file", length));
			String[] sndrNm = (JSPUtil.getParameter(request, prefix	+ "sndr_nm", length));
			String[] ifTrcSeq = (JSPUtil.getParameter(request, prefix	+ "if_trc_seq", length));
			String[] templateArgs = (JSPUtil.getParameter(request, prefix	+ "template_args", length));
			
			for (int i = 0; i < length; i++) {
				model = new DocResultVO();
				if (mnrIfDt[i] != null)
					model.setMnrIfDt(mnrIfDt[i]);
				if (mnrGrpTpCd[i] != null)
					model.setMnrGrpTpCd(mnrGrpTpCd[i]);
				if (tmplMrd[i] != null)
					model.setTmplMrd(tmplMrd[i]);
				if (mnrIfMsgCtnt[i] != null)
					model.setMnrIfMsgCtnt(mnrIfMsgCtnt[i]);
				if (sndrEml[i] != null)
					model.setSndrEml(sndrEml[i]);
				if (emlCtnt[i] != null)
					model.setEmlCtnt(emlCtnt[i]);
				if (faxOffice[i] != null)
					model.setFaxOffice(faxOffice[i]);
				if (docTitNm[i] != null)
					model.setDocTitNm(docTitNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (emlFileKeys[i] != null)
					model.setEmlFileKeys(emlFileKeys[i]);
				if (mnrOrdOfcCtyCd[i] != null)
					model.setMnrOrdOfcCtyCd(mnrOrdOfcCtyCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (paraInfoCtnt[i] != null)
					model.setParaInfoCtnt(paraInfoCtnt[i]);
				if (batFlg[i] != null)
					model.setBatFlg(batFlg[i]);
				if (receiverRmail[i] != null)
					model.setReceiverRmail(receiverRmail[i]);
				if (mnrRefNo[i] != null)
					model.setMnrRefNo(mnrRefNo[i]);
				if (faxRcvInfo[i] != null)
					model.setFaxRcvInfo(faxRcvInfo[i]);
				if (ediId[i] != null)
					model.setEdiId(ediId[i]);
				if (trsmModCd[i] != null)
					model.setTrsmModCd(trsmModCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (rdSubSysCd[i] != null)
					model.setRdSubSysCd(rdSubSysCd[i]);
				if (mnrOrdSeq[i] != null)
					model.setMnrOrdSeq(mnrOrdSeq[i]);
				if (templateFile[i] != null)
					model.setTemplateFile(templateFile[i]);
				if (flatFile[i] != null)
					model.setFlatFile(flatFile[i]);
				if (sndrNm[i] != null)
					model.setSndrNm(sndrNm[i]);
				if (ifTrcSeq[i] != null)
					model.setIfTrcSeq(ifTrcSeq[i]);
				if (templateArgs[i] != null)
					model.setTemplateArgs(templateArgs[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDocResultVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DocResultVO[]
	 */
	public DocResultVO[] getDocResultVOs(){
		DocResultVO[] vos = (DocResultVO[])models.toArray(new DocResultVO[models.size()]);
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
		this.mnrIfDt = this.mnrIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrGrpTpCd = this.mnrGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmplMrd = this.tmplMrd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrIfMsgCtnt = this.mnrIfMsgCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndrEml = this.sndrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlCtnt = this.emlCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxOffice = this.faxOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docTitNm = this.docTitNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlFileKeys = this.emlFileKeys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrOrdOfcCtyCd = this.mnrOrdOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paraInfoCtnt = this.paraInfoCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batFlg = this.batFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.receiverRmail = this.receiverRmail .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrRefNo = this.mnrRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxRcvInfo = this.faxRcvInfo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediId = this.ediId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmModCd = this.trsmModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdSubSysCd = this.rdSubSysCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrOrdSeq = this.mnrOrdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.templateFile = this.templateFile .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flatFile = this.flatFile .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndrNm = this.sndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifTrcSeq = this.ifTrcSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.templateArgs = this.templateArgs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
