/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KORInvoiceVO.java
*@FileTitle : KORInvoiceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.09.10 박정진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박정진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KORInvoiceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KORInvoiceVO> models = new ArrayList<KORInvoiceVO>();
	
	/* Column Info */
	private String indivCorpDivCd = null;
	/* Column Info */
	private String issDivCd = null;
	/* Column Info */
	private String bzctNm = null;
	/* Column Info */
	private String loclNm = null;
	/* Column Info */
	private String actCustSeq = null;
	/* Column Info */
	private String bztpNm = null;
	/* Column Info */
	private String custRgstNo = null;
	/* Column Info */
	private String custEml = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String loclAddr = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String invRmk = null;
	/* Column Info */
	private String cntcPsonNm = null;
	/* Column Info */
	private String actCustCntCd = null;
	/* Column Info */
	private String custFaxNo = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String invSeq = null;
	/* Column Info */
	private String issDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String sendFlg = null;
	/* Column Info */
	private String emailSubject = null;
	/* Column Info */
	private String emailFileName = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/** Table Value Object Multi Data 처리 */
	private List<KORInvoiceBLListVO> korInvoiceBLListVO;
	
	/** Table Value Object Multi Data 처리 */
	private List<InvArKrIssChgVO> invArKrIssChgVO;
	
	public KORInvoiceVO() {}

	public KORInvoiceVO(String ibflag, String pagerows, String arOfcCd, String actCustCntCd, String actCustSeq, String loclNm, String custRgstNo, String indivCorpDivCd, String issDivCd, String cntcPsonNm, String loclAddr, String bzctNm, String bztpNm, String invRmk, String custFaxNo, String custEml, String invNo, String invSeq, String issDt, String creUsrId, String creDt, String updUsrId, String updDt, String sendFlg, String emailSubject, String emailFileName) {
		this.indivCorpDivCd = indivCorpDivCd;
		this.issDivCd = issDivCd;
		this.bzctNm = bzctNm;
		this.loclNm = loclNm;
		this.actCustSeq = actCustSeq;
		this.bztpNm = bztpNm;
		this.custRgstNo = custRgstNo;
		this.custEml = custEml;
		this.arOfcCd = arOfcCd;
		this.loclAddr = loclAddr;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.invRmk = invRmk;
		this.cntcPsonNm = cntcPsonNm;
		this.actCustCntCd = actCustCntCd;
		this.custFaxNo = custFaxNo;
		this.invNo = invNo;
		this.invSeq = invSeq;
		this.issDt = issDt;
		this.creUsrId = creUsrId;
		this.creDt = creDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.sendFlg = sendFlg;
		this.emailSubject = emailSubject;
		this.emailFileName = emailFileName;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("indiv_corp_div_cd", getIndivCorpDivCd());
		this.hashColumns.put("iss_div_cd", getIssDivCd());
		this.hashColumns.put("bzct_nm", getBzctNm());
		this.hashColumns.put("locl_nm", getLoclNm());
		this.hashColumns.put("act_cust_seq", getActCustSeq());
		this.hashColumns.put("bztp_nm", getBztpNm());
		this.hashColumns.put("cust_rgst_no", getCustRgstNo());
		this.hashColumns.put("cust_eml", getCustEml());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("locl_addr", getLoclAddr());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("inv_rmk", getInvRmk());
		this.hashColumns.put("cntc_pson_nm", getCntcPsonNm());
		this.hashColumns.put("act_cust_cnt_cd", getActCustCntCd());
		this.hashColumns.put("cust_fax_no", getCustFaxNo());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("inv_seq", getInvSeq());
		this.hashColumns.put("iss_dt", getIssDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("send_flg", getSendFlg());
		this.hashColumns.put("email_subject", getEmailSubject());
		this.hashColumns.put("email_file_name", getEmailFileName());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("indiv_corp_div_cd", "indivCorpDivCd");
		this.hashFields.put("iss_div_cd", "issDivCd");
		this.hashFields.put("bzct_nm", "bzctNm");
		this.hashFields.put("locl_nm", "loclNm");
		this.hashFields.put("act_cust_seq", "actCustSeq");
		this.hashFields.put("bztp_nm", "bztpNm");
		this.hashFields.put("cust_rgst_no", "custRgstNo");
		this.hashFields.put("cust_eml", "custEml");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("locl_addr", "loclAddr");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inv_rmk", "invRmk");
		this.hashFields.put("cntc_pson_nm", "cntcPsonNm");
		this.hashFields.put("act_cust_cnt_cd", "actCustCntCd");
		this.hashFields.put("cust_fax_no", "custFaxNo");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("iss_dt", "issDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("send_flg", "sendFlg");
		this.hashFields.put("email_subject", "emailSubject");
		this.hashFields.put("email_file_name", "emailFileName");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return indivCorpDivCd
	 */
	public String getIndivCorpDivCd() {
		return this.indivCorpDivCd;
	}
	
	/**
	 * Column Info
	 * @return issDivCd
	 */
	public String getIssDivCd() {
		return this.issDivCd;
	}
	
	/**
	 * Column Info
	 * @return bzctNm
	 */
	public String getBzctNm() {
		return this.bzctNm;
	}
	
	/**
	 * Column Info
	 * @return loclNm
	 */
	public String getLoclNm() {
		return this.loclNm;
	}
	
	/**
	 * Column Info
	 * @return actCustSeq
	 */
	public String getActCustSeq() {
		return this.actCustSeq;
	}
	
	/**
	 * Column Info
	 * @return bztpNm
	 */
	public String getBztpNm() {
		return this.bztpNm;
	}
	
	/**
	 * Column Info
	 * @return custRgstNo
	 */
	public String getCustRgstNo() {
		return this.custRgstNo;
	}
	
	/**
	 * Column Info
	 * @return custEml
	 */
	public String getCustEml() {
		return this.custEml;
	}
	
	/**
	 * Column Info
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
	}
	
	/**
	 * Column Info
	 * @return loclAddr
	 */
	public String getLoclAddr() {
		return this.loclAddr;
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
	 * @return invRmk
	 */
	public String getInvRmk() {
		return this.invRmk;
	}
	
	/**
	 * Column Info
	 * @return cntcPsonNm
	 */
	public String getCntcPsonNm() {
		return this.cntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @return actCustCntCd
	 */
	public String getActCustCntCd() {
		return this.actCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return custFaxNo
	 */
	public String getCustFaxNo() {
		return this.custFaxNo;
	}
	

	/**
	 * Column Info
	 * @param indivCorpDivCd
	 */
	public void setIndivCorpDivCd(String indivCorpDivCd) {
		this.indivCorpDivCd = indivCorpDivCd;
	}
	
	/**
	 * Column Info
	 * @param issDivCd
	 */
	public void setIssDivCd(String issDivCd) {
		this.issDivCd = issDivCd;
	}
	
	/**
	 * Column Info
	 * @param bzctNm
	 */
	public void setBzctNm(String bzctNm) {
		this.bzctNm = bzctNm;
	}
	
	/**
	 * Column Info
	 * @param loclNm
	 */
	public void setLoclNm(String loclNm) {
		this.loclNm = loclNm;
	}
	
	/**
	 * Column Info
	 * @param actCustSeq
	 */
	public void setActCustSeq(String actCustSeq) {
		this.actCustSeq = actCustSeq;
	}
	
	/**
	 * Column Info
	 * @param bztpNm
	 */
	public void setBztpNm(String bztpNm) {
		this.bztpNm = bztpNm;
	}
	
	/**
	 * Column Info
	 * @param custRgstNo
	 */
	public void setCustRgstNo(String custRgstNo) {
		this.custRgstNo = custRgstNo;
	}
	
	/**
	 * Column Info
	 * @param custEml
	 */
	public void setCustEml(String custEml) {
		this.custEml = custEml;
	}
	
	/**
	 * Column Info
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
	}
	
	/**
	 * Column Info
	 * @param loclAddr
	 */
	public void setLoclAddr(String loclAddr) {
		this.loclAddr = loclAddr;
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
	 * @param invRmk
	 */
	public void setInvRmk(String invRmk) {
		this.invRmk = invRmk;
	}
	
	/**
	 * Column Info
	 * @param cntcPsonNm
	 */
	public void setCntcPsonNm(String cntcPsonNm) {
		this.cntcPsonNm = cntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @param actCustCntCd
	 */
	public void setActCustCntCd(String actCustCntCd) {
		this.actCustCntCd = actCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param custFaxNo
	 */
	public void setCustFaxNo(String custFaxNo) {
		this.custFaxNo = custFaxNo;
	}
	
	public String getInvNo() {
		return invNo;
	}

	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}

	public String getIssDt() {
		return issDt;
	}

	public void setIssDt(String issDt) {
		this.issDt = issDt;
	}

	public String getInvSeq() {
		return invSeq;
	}

	public void setInvSeq(String invSeq) {
		this.invSeq = invSeq;
	}

	public String getCreUsrId() {
		return creUsrId;
	}

	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	public String getCreDt() {
		return creDt;
	}

	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}

	public String getUpdUsrId() {
		return updUsrId;
	}

	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	public String getUpdDt() {
		return updDt;
	}

	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}

	public String getSendFlg() {
		return sendFlg;
	}

	public void setSendFlg(String sendFlg) {
		this.sendFlg = sendFlg;
	}

	public String getEmailSubject() {
		return emailSubject;
	}

	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	public String getEmailFileName() {
		return emailFileName;
	}

	public void setEmailFileName(String emailFileName) {
		this.emailFileName = emailFileName;
	}

	public List<KORInvoiceBLListVO> getKorInvoiceBLListVO() {
		return korInvoiceBLListVO;
	}

	public void setKorInvoiceBLListVO(List<KORInvoiceBLListVO> korInvoiceBLListVO) {
		this.korInvoiceBLListVO = korInvoiceBLListVO;
	}

	public List<InvArKrIssChgVO> getInvArKrIssChgVO() {
		return invArKrIssChgVO;
	}

	public void setInvArKrIssChgVO(List<InvArKrIssChgVO> invArKrIssChgVO) {
		this.invArKrIssChgVO = invArKrIssChgVO;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIndivCorpDivCd(JSPUtil.getParameter(request, "indiv_corp_div_cd", ""));
		setIssDivCd(JSPUtil.getParameter(request, "iss_div_cd", ""));
		setBzctNm(JSPUtil.getParameter(request, "bzct_nm", ""));
		setLoclNm(JSPUtil.getParameter(request, "locl_nm", ""));
		setActCustSeq(JSPUtil.getParameter(request, "act_cust_seq", ""));
		setBztpNm(JSPUtil.getParameter(request, "bztp_nm", ""));
		setCustRgstNo(JSPUtil.getParameter(request, "cust_rgst_no", ""));
		setCustEml(JSPUtil.getParameter(request, "cust_eml", ""));
		setArOfcCd(JSPUtil.getParameter(request, "ar_ofc_cd", ""));
		setLoclAddr(JSPUtil.getParameter(request, "locl_addr", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setInvRmk(JSPUtil.getParameter(request, "inv_rmk", ""));
		setCntcPsonNm(JSPUtil.getParameter(request, "cntc_pson_nm", ""));
		setActCustCntCd(JSPUtil.getParameter(request, "act_cust_cnt_cd", ""));
		setCustFaxNo(JSPUtil.getParameter(request, "cust_fax_no", ""));
		setInvNo(JSPUtil.getParameter(request, "inv_no", ""));
		setInvSeq(JSPUtil.getParameter(request, "inv_seq", ""));
		setIssDt(JSPUtil.getParameter(request, "iss_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setSendFlg(JSPUtil.getParameter(request, "send_flg", ""));
		setEmailSubject(JSPUtil.getParameter(request, "email_subject", ""));
		setEmailFileName(JSPUtil.getParameter(request, "email_file_name", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KORInvoiceVO[]
	 */
	public KORInvoiceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KORInvoiceVO[]
	 */
	public KORInvoiceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KORInvoiceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] indivCorpDivCd = (JSPUtil.getParameter(request, prefix	+ "indiv_corp_div_cd", length));
			String[] issDivCd = (JSPUtil.getParameter(request, prefix	+ "iss_div_cd", length));
			String[] bzctNm = (JSPUtil.getParameter(request, prefix	+ "bzct_nm", length));
			String[] loclNm = (JSPUtil.getParameter(request, prefix	+ "locl_nm", length));
			String[] actCustSeq = (JSPUtil.getParameter(request, prefix	+ "act_cust_seq", length));
			String[] bztpNm = (JSPUtil.getParameter(request, prefix	+ "bztp_nm", length));
			String[] custRgstNo = (JSPUtil.getParameter(request, prefix	+ "cust_rgst_no", length));
			String[] custEml = (JSPUtil.getParameter(request, prefix	+ "cust_eml", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] loclAddr = (JSPUtil.getParameter(request, prefix	+ "locl_addr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] invRmk = (JSPUtil.getParameter(request, prefix	+ "inv_rmk", length));
			String[] cntcPsonNm = (JSPUtil.getParameter(request, prefix	+ "cntc_pson_nm", length));
			String[] actCustCntCd = (JSPUtil.getParameter(request, prefix	+ "act_cust_cnt_cd", length));
			String[] custFaxNo = (JSPUtil.getParameter(request, prefix	+ "cust_fax_no", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] invSeq = (JSPUtil.getParameter(request, prefix	+ "inv_seq", length));
			String[] issDt = (JSPUtil.getParameter(request, prefix	+ "iss_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] sendFlg = (JSPUtil.getParameter(request, prefix	+ "send_flg", length));
			String[] emailSubject = (JSPUtil.getParameter(request, prefix	+ "email_subject", length));
			String[] emailFileName = (JSPUtil.getParameter(request, prefix	+ "email_file_name", length));
			
			for (int i = 0; i < length; i++) {
				model = new KORInvoiceVO();
				if (indivCorpDivCd[i] != null)
					model.setIndivCorpDivCd(indivCorpDivCd[i]);
				if (issDivCd[i] != null)
					model.setIssDivCd(issDivCd[i]);
				if (bzctNm[i] != null)
					model.setBzctNm(bzctNm[i]);
				if (loclNm[i] != null)
					model.setLoclNm(loclNm[i]);
				if (actCustSeq[i] != null)
					model.setActCustSeq(actCustSeq[i]);
				if (bztpNm[i] != null)
					model.setBztpNm(bztpNm[i]);
				if (custRgstNo[i] != null)
					model.setCustRgstNo(custRgstNo[i]);
				if (custEml[i] != null)
					model.setCustEml(custEml[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (loclAddr[i] != null)
					model.setLoclAddr(loclAddr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (invRmk[i] != null)
					model.setInvRmk(invRmk[i]);
				if (cntcPsonNm[i] != null)
					model.setCntcPsonNm(cntcPsonNm[i]);
				if (actCustCntCd[i] != null)
					model.setActCustCntCd(actCustCntCd[i]);
				if (custFaxNo[i] != null)
					model.setCustFaxNo(custFaxNo[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (invSeq[i] != null)
					model.setInvSeq(invSeq[i]);
				if (issDt[i] != null)
					model.setIssDt(issDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (sendFlg[i] != null)
					model.setSendFlg(sendFlg[i]);
				if (emailSubject[i] != null)
					model.setEmailSubject(emailSubject[i]);
				if (emailFileName[i] != null)
					model.setEmailFileName(emailFileName[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKORInvoiceVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KORInvoiceVO[]
	 */
	public KORInvoiceVO[] getKORInvoiceVOs(){
		KORInvoiceVO[] vos = (KORInvoiceVO[])models.toArray(new KORInvoiceVO[models.size()]);
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
		this.indivCorpDivCd = this.indivCorpDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDivCd = this.issDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzctNm = this.bzctNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclNm = this.loclNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustSeq = this.actCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bztpNm = this.bztpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRgstNo = this.custRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custEml = this.custEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclAddr = this.loclAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRmk = this.invRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonNm = this.cntcPsonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCntCd = this.actCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custFaxNo = this.custFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq = this.invSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt = this.issDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sendFlg = this.sendFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emailSubject = this.emailSubject .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emailFileName = this.emailFileName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
