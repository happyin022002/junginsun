/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvIssMainVO.java
*@FileTitle : InvIssMainVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.04
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2010.01.04 최우석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo;

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
 * @author 최우석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InvIssMainVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvIssMainVO> models = new ArrayList<InvIssMainVO>();
	
	/* Column Info */
	private String fKey = null;
	/* Column Info */
	private String titleFlag = null;
	/* Column Info */
	private String emlSndDt = null;
	/* Column Info */
	private String rissDt = null;
	/* Column Info */
	private String issOfcCd = null;
	/* Column Info */
	private String usdXchRt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String invSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String issDt = null;
	/* Column Info */
	private String invIssCmbFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rdName = null;
	/* Column Info */
	private String invIssRmk = null;
	/* Column Info */
	private String invXchRtDt = null;
	/* Column Info */
	private String custFaxNo = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String sendFlag = null;
	/* Column Info */
	private String blSrcNo = null;
	/* Column Info */
	private String actInvNo = null;
	/* Column Info */
	private String emlSndNo = null;
	/* Column Info */
	private String custEml = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String issueGubn = null;
	/* Column Info */
	private String nameFlag = null;
	/* Column Info */
	private String attach = null;
	/* Column Info */
	private String faxSndDt = null;
	/* Column Info */
	private String faxSndNo = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String attachView = null;
	/* Column Info */
	private String loclPoNo = null;
	/* Column Info */
	private String attach2 = null;
	/* Column Info */
	private String attachView2 = null;
	/* Column Info */
	private String issueType = null;
	/* Column Info */
	private String copyCnt = null;
	/* Column Info */
	private String vnInvPayMzdCd = null;
	/* Column Info */
	private String invEmlSplitFlg = null;
	/* Column Info */
	private String ifNo = null;
	/* Column Info */
	private String autoInvIssFlg = null;
	/* Column Info */
	private String userNm = null;
	/* Column Info */
	private String userEml = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InvIssMainVO() {}

	public InvIssMainVO(String ibflag, String pagerows, String titleFlag, String fKey, String emlSndDt, String rissDt, String usdXchRt, String issOfcCd, String creDt, String invSeq, String issDt, String invIssRmk, String rdName, String invXchRtDt, String custFaxNo, String portCd, String updUsrId, String updDt, String sendFlag, String blSrcNo, String invIssCmbFlg, String actInvNo, String emlSndNo, String custEml, String invNo, String vvd, String creUsrId, String issueGubn, String nameFlag, String attach, String faxSndDt, String faxSndNo, String custCd, String custNm, String ioBndCd, String attachView, String loclPoNo, String attach2, String attachView2, String issueType, String copyCnt, String vnInvPayMzdCd, String invEmlSplitFlg, String ifNo, String autoInvIssFlg, String userNm, String userEml) {
		this.fKey = fKey;
		this.titleFlag = titleFlag;
		this.emlSndDt = emlSndDt;
		this.rissDt = rissDt;
		this.issOfcCd = issOfcCd;
		this.usdXchRt = usdXchRt;
		this.creDt = creDt;
		this.invSeq = invSeq;
		this.pagerows = pagerows;
		this.issDt = issDt;
		this.invIssCmbFlg = invIssCmbFlg;
		this.ibflag = ibflag;
		this.rdName = rdName;
		this.invIssRmk = invIssRmk;
		this.invXchRtDt = invXchRtDt;
		this.custFaxNo = custFaxNo;
		this.portCd = portCd;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.sendFlag = sendFlag;
		this.blSrcNo = blSrcNo;
		this.actInvNo = actInvNo;
		this.emlSndNo = emlSndNo;
		this.custEml = custEml;
		this.vvd = vvd;
		this.invNo = invNo;
		this.creUsrId = creUsrId;
		this.issueGubn = issueGubn;
		this.nameFlag = nameFlag;
		this.attach = attach;
		this.faxSndDt = faxSndDt;
		this.faxSndNo = faxSndNo;
		this.custCd = custCd;
		this.custNm = custNm;
		this.ioBndCd = ioBndCd;
		this.attachView = attachView;
		this.loclPoNo = loclPoNo;
		this.attach2 = attach2;
		this.attachView2 = attachView2;
		this.issueType = issueType;
		this.copyCnt = copyCnt;
		this.vnInvPayMzdCd = vnInvPayMzdCd;
		this.invEmlSplitFlg = invEmlSplitFlg;
		this.ifNo = ifNo;
		this.autoInvIssFlg = autoInvIssFlg;
		this.userNm = userNm;
		this.userEml = userEml;
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("f_key", getFKey());
		this.hashColumns.put("title_flag", getTitleFlag());
		this.hashColumns.put("eml_snd_dt", getEmlSndDt());
		this.hashColumns.put("riss_dt", getRissDt());
		this.hashColumns.put("iss_ofc_cd", getIssOfcCd());
		this.hashColumns.put("usd_xch_rt", getUsdXchRt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("inv_seq", getInvSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("iss_dt", getIssDt());
		this.hashColumns.put("inv_iss_cmb_flg", getInvIssCmbFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rd_name", getRdName());
		this.hashColumns.put("inv_iss_rmk", getInvIssRmk());
		this.hashColumns.put("inv_xch_rt_dt", getInvXchRtDt());
		this.hashColumns.put("cust_fax_no", getCustFaxNo());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("send_flag", getSendFlag());
		this.hashColumns.put("bl_src_no", getBlSrcNo());
		this.hashColumns.put("act_inv_no", getActInvNo());
		this.hashColumns.put("eml_snd_no", getEmlSndNo());
		this.hashColumns.put("cust_eml", getCustEml());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("issue_gubn", getIssueGubn());
		this.hashColumns.put("name_flag", getNameFlag());
		this.hashColumns.put("attach", getAttach());
		this.hashColumns.put("fax_snd_dt", getFaxSndDt());
		this.hashColumns.put("fax_snd_no", getFaxSndNo());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("attach_view", getAttachView());
		this.hashColumns.put("locl_po_no", getLoclPoNo());
		this.hashColumns.put("attach2", getAttach2());
		this.hashColumns.put("attach_view2", getAttachView2());
		this.hashColumns.put("issue_type", getIssueType());
		this.hashColumns.put("copy_cnt", getCopyCnt());
		this.hashColumns.put("vn_inv_pay_mzd_cd", getVnInvPayMzdCd());
		this.hashColumns.put("inv_eml_split_flg", getInvEmlSplitFlg());
		this.hashColumns.put("if_no", getIfNo());
		this.hashColumns.put("auto_inv_iss_flg", getAutoInvIssFlg());
		this.hashColumns.put("user_nm", getUserNm());
		this.hashColumns.put("user_eml", getUserEml());
		
		return this.hashColumns;
	}
	

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("f_key", "fKey");
		this.hashFields.put("title_flag", "titleFlag");
		this.hashFields.put("eml_snd_dt", "emlSndDt");
		this.hashFields.put("riss_dt", "rissDt");
		this.hashFields.put("iss_ofc_cd", "issOfcCd");
		this.hashFields.put("usd_xch_rt", "usdXchRt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("iss_dt", "issDt");
		this.hashFields.put("inv_iss_cmb_flg", "invIssCmbFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rd_name", "rdName");
		this.hashFields.put("inv_iss_rmk", "invIssRmk");
		this.hashFields.put("inv_xch_rt_dt", "invXchRtDt");
		this.hashFields.put("cust_fax_no", "custFaxNo");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("send_flag", "sendFlag");
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("act_inv_no", "actInvNo");
		this.hashFields.put("eml_snd_no", "emlSndNo");
		this.hashFields.put("cust_eml", "custEml");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("issue_gubn", "issueGubn");
		this.hashFields.put("name_flag", "nameFlag");
		this.hashFields.put("attach", "attach");
		this.hashFields.put("fax_snd_dt", "faxSndDt");
		this.hashFields.put("fax_snd_no", "faxSndNo");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("attach_view", "attachView");
		this.hashFields.put("locl_po_no", "loclPoNo");
		this.hashFields.put("attach2", "attach2");
		this.hashFields.put("attach_view2", "attachView2");
		this.hashFields.put("issue_type", "issueType");
		this.hashFields.put("copy_cnt", "copyCnt");
		this.hashFields.put("vn_inv_pay_mzd_cd", "vnInvPayMzdCd");
		this.hashFields.put("inv_eml_split_flg", "invEmlSplitFlg");
		this.hashFields.put("if_no", "ifNo");
		this.hashFields.put("auto_inv_iss_flg", "autoInvIssFlg");
		this.hashFields.put("user_nm", "userNm");
		this.hashFields.put("user_eml", "userEml");
        
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fKey
	 */
	public String getFKey() {
		return this.fKey;
	}
	
	/**
	 * Column Info
	 * @return titleFlag
	 */
	public String getTitleFlag() {
		return this.titleFlag;
	}
	
	/**
	 * Column Info
	 * @return emlSndDt
	 */
	public String getEmlSndDt() {
		return this.emlSndDt;
	}
	
	/**
	 * Column Info
	 * @return rissDt
	 */
	public String getRissDt() {
		return this.rissDt;
	}
	
	/**
	 * Column Info
	 * @return issOfcCd
	 */
	public String getIssOfcCd() {
		return this.issOfcCd;
	}
	
	/**
	 * Column Info
	 * @return usdXchRt
	 */
	public String getUsdXchRt() {
		return this.usdXchRt;
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
	 * @return invSeq
	 */
	public String getInvSeq() {
		return this.invSeq;
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
	 * @return issDt
	 */
	public String getIssDt() {
		return this.issDt;
	}
	
	/**
	 * Column Info
	 * @return invIssCmbFlg
	 */
	public String getInvIssCmbFlg() {
		return this.invIssCmbFlg;
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
	 * @return rdName
	 */
	public String getRdName() {
		return this.rdName;
	}
	
	/**
	 * Column Info
	 * @return invIssRmk
	 */
	public String getInvIssRmk() {
		return this.invIssRmk;
	}
	
	/**
	 * Column Info
	 * @return invXchRtDt
	 */
	public String getInvXchRtDt() {
		return this.invXchRtDt;
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
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return sendFlag
	 */
	public String getSendFlag() {
		return this.sendFlag;
	}
	
	/**
	 * Column Info
	 * @return blSrcNo
	 */
	public String getBlSrcNo() {
		return this.blSrcNo;
	}
	
	/**
	 * Column Info
	 * @return actInvNo
	 */
	public String getActInvNo() {
		return this.actInvNo;
	}
	
	/**
	 * Column Info
	 * @return emlSndNo
	 */
	public String getEmlSndNo() {
		return this.emlSndNo;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
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
	 * @return issueGubn
	 */
	public String getIssueGubn() {
		return this.issueGubn;
	}
	
	/**
	 * Column Info
	 * @return nameFlag
	 */
	public String getNameFlag() {
		return this.nameFlag;
	}
	
	/**
	 * Column Info
	 * @return attach
	 */
	public String getAttach() {
		return this.attach;
	}
	
	/**
	 * Column Info
	 * @return faxSndDt
	 */
	public String getFaxSndDt() {
		return this.faxSndDt;
	}
	
	/**
	 * Column Info
	 * @return faxSndNo
	 */
	public String getFaxSndNo() {
		return this.faxSndNo;
	}
	
	/**
	 * Column Info
	 * @return autoInvIssFlg
	 */
	public String getAutoInvIssFlg() {
		return this.autoInvIssFlg;
	}
	
	/**
	 * Column Info
	 * @return userNm
	 */
	public String getUserNm() {
		return this.userNm;
	}
	
	/**
	 * Column Info
	 * @return userEml
	 */
	public String getUserEml() {
		return this.userEml;
	}
	

	/**
	 * Column Info
	 * @param fKey
	 */
	public void setFKey(String fKey) {
		this.fKey = fKey;
	}
	
	/**
	 * Column Info
	 * @param titleFlag
	 */
	public void setTitleFlag(String titleFlag) {
		this.titleFlag = titleFlag;
	}
	
	/**
	 * Column Info
	 * @param emlSndDt
	 */
	public void setEmlSndDt(String emlSndDt) {
		this.emlSndDt = emlSndDt;
	}
	
	/**
	 * Column Info
	 * @param rissDt
	 */
	public void setRissDt(String rissDt) {
		this.rissDt = rissDt;
	}
	
	/**
	 * Column Info
	 * @param issOfcCd
	 */
	public void setIssOfcCd(String issOfcCd) {
		this.issOfcCd = issOfcCd;
	}
	
	/**
	 * Column Info
	 * @param usdXchRt
	 */
	public void setUsdXchRt(String usdXchRt) {
		this.usdXchRt = usdXchRt;
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
	 * @param invSeq
	 */
	public void setInvSeq(String invSeq) {
		this.invSeq = invSeq;
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
	 * @param issDt
	 */
	public void setIssDt(String issDt) {
		this.issDt = issDt;
	}
	
	/**
	 * Column Info
	 * @param invIssCmbFlg
	 */
	public void setInvIssCmbFlg(String invIssCmbFlg) {
		this.invIssCmbFlg = invIssCmbFlg;
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
	 * @param rdName
	 */
	public void setRdName(String rdName) {
		this.rdName = rdName;
	}
	
	/**
	 * Column Info
	 * @param invIssRmk
	 */
	public void setInvIssRmk(String invIssRmk) {
		this.invIssRmk = invIssRmk;
	}
	
	/**
	 * Column Info
	 * @param invXchRtDt
	 */
	public void setInvXchRtDt(String invXchRtDt) {
		this.invXchRtDt = invXchRtDt;
	}
	
	/**
	 * Column Info
	 * @param custFaxNo
	 */
	public void setCustFaxNo(String custFaxNo) {
		this.custFaxNo = custFaxNo;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param sendFlag
	 */
	public void setSendFlag(String sendFlag) {
		this.sendFlag = sendFlag;
	}
	
	/**
	 * Column Info
	 * @param blSrcNo
	 */
	public void setBlSrcNo(String blSrcNo) {
		this.blSrcNo = blSrcNo;
	}
	
	/**
	 * Column Info
	 * @param actInvNo
	 */
	public void setActInvNo(String actInvNo) {
		this.actInvNo = actInvNo;
	}
	
	/**
	 * Column Info
	 * @param emlSndNo
	 */
	public void setEmlSndNo(String emlSndNo) {
		this.emlSndNo = emlSndNo;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
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
	 * @param issueGubn
	 */
	public void setIssueGubn(String issueGubn) {
		this.issueGubn = issueGubn;
	}
	
	/**
	 * Column Info
	 * @param nameFlag
	 */
	public void setNameFlag(String nameFlag) {
		this.nameFlag = nameFlag;
	}
	
	/**
	 * Column Info
	 * @param attach
	 */
	public void setAttach(String attach) {
		this.attach = attach;
	}
	
	/**
	 * Column Info
	 * @param faxSndDt
	 */
	public void setFaxSndDt(String faxSndDt) {
		this.faxSndDt = faxSndDt;
	}
	
	/**
	 * Column Info
	 * @param faxSndNo
	 */
	public void setFaxSndNo(String faxSndNo) {
		this.faxSndNo = faxSndNo;
	}
	
	/**
	 * @return the custCd
	 */
	public String getCustCd() {
		return custCd;
	}

	/**
	 * @param custCd the custCd to set
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}

	/**
	 * @return the custNm
	 */
	public String getCustNm() {
		return custNm;
	}

	/**
	 * @param custNm the custNm to set
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}

	/**
	 * @return the ioBndCd
	 */
	public String getIoBndCd() {
		return ioBndCd;
	}

	/**
	 * @param ioBndCd the ioBndCd to set
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}

	/**
	 * @return the attachView
	 */
	public String getAttachView() {
		return attachView;
	}

	/**
	 * @param attachView the attachView to set
	 */
	public void setAttachView(String attachView) {
		this.attachView = attachView;
	}

	/**
	 * @return the loclPoNo
	 */
	public String getLoclPoNo() {
		return loclPoNo;
	}

	/**
	 * @param loclPoNo the loclPoNo to set
	 */
	public void setLoclPoNo(String loclPoNo) {
		this.loclPoNo = loclPoNo;
	}

	/**
	 * @return the attach2
	 */
	public String getAttach2() {
		return attach2;
	}

	/**
	 * @param attach2 the attach2 to set
	 */
	public void setAttach2(String attach2) {
		this.attach2 = attach2;
	}

	/**
	 * @return the attachView2
	 */
	public String getAttachView2() {
		return attachView2;
	}

	/**
	 * @param attachView2 the attachView2 to set
	 */
	public void setAttachView2(String attachView2) {
		this.attachView2 = attachView2;
	}

	/**
	 * @return the issueType
	 */
	public String getIssueType() {
		return issueType;
	}

	/**
	 * @param issueType the issueType to set
	 */
	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}

	public String getCopyCnt() {
		return copyCnt;
	}

	public void setCopyCnt(String copyCnt) {
		this.copyCnt = copyCnt;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * @return
	 */
	public String getVnInvPayMzdCd() {
		return vnInvPayMzdCd;
	}
	            
	/**
	 * @param vnInvPayMzdCd
	 */
	public void setVnInvPayMzdCd(String vnInvPayMzdCd) {
		this.vnInvPayMzdCd = vnInvPayMzdCd;
	}
	
	
	/**
	 * @return the invEmlSplitFlg
	 */
	public String getInvEmlSplitFlg() {
		return invEmlSplitFlg;
	}

	/**
	 * @param invEmlSplitFlg the invEmlSplitFlg to set
	 */
	public void setInvEmlSplitFlg(String invEmlSplitFlg) {
		this.invEmlSplitFlg = invEmlSplitFlg;
	}

	/**
	 * @return the ifNo
	 */
	public String getIfNo() {
		return ifNo;
	}

	/**
	 * @param ifNo the ifNo to set
	 */
	public void setIfNo(String ifNo) {
		this.ifNo = ifNo;
	}
	
	/**
	 * @param autoInvIssFlg the autoInvIssFlg to set
	 */
	public void setAutoInvIssFlg(String autoInvIssFlg) {
		this.autoInvIssFlg = autoInvIssFlg;
	}
	
	/**
	 * @param userNm the userNm to set
	 */
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	
	/**
	 * @param userEml the userEml to set
	 */
	public void setUserEml(String userEml) {
		this.userEml = userEml;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setFKey(JSPUtil.getParameter(request, prefix + "f_key", ""));
		setTitleFlag(JSPUtil.getParameter(request, prefix + "title_flag", ""));
		setEmlSndDt(JSPUtil.getParameter(request, prefix + "eml_snd_dt", ""));
		setRissDt(JSPUtil.getParameter(request, prefix + "riss_dt", ""));
		setIssOfcCd(JSPUtil.getParameter(request, prefix + "iss_ofc_cd", ""));
		setUsdXchRt(JSPUtil.getParameter(request, prefix + "usd_xch_rt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setInvSeq(JSPUtil.getParameter(request, prefix + "inv_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIssDt(JSPUtil.getParameter(request, prefix + "iss_dt", ""));
		setInvIssCmbFlg(JSPUtil.getParameter(request, prefix + "inv_iss_cmb_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRdName(JSPUtil.getParameter(request, prefix + "rd_name", ""));
		setInvIssRmk(JSPUtil.getParameter(request, prefix + "inv_iss_rmk", ""));
		setInvXchRtDt(JSPUtil.getParameter(request, prefix + "inv_xch_rt_dt", ""));
		setCustFaxNo(JSPUtil.getParameter(request, prefix + "cust_fax_no", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setSendFlag(JSPUtil.getParameter(request, prefix + "send_flag", ""));
		setBlSrcNo(JSPUtil.getParameter(request, prefix + "bl_src_no", ""));
		setActInvNo(JSPUtil.getParameter(request, prefix + "act_inv_no", ""));
		setEmlSndNo(JSPUtil.getParameter(request, prefix + "eml_snd_no", ""));
		setCustEml(JSPUtil.getParameter(request, prefix + "cust_eml", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIssueGubn(JSPUtil.getParameter(request, prefix + "issue_gubn", ""));
		setNameFlag(JSPUtil.getParameter(request, prefix + "name_flag", ""));
		setAttach(JSPUtil.getParameter(request, prefix + "attach", ""));
		setFaxSndDt(JSPUtil.getParameter(request, prefix + "fax_snd_dt", ""));
		setFaxSndNo(JSPUtil.getParameter(request, prefix + "fax_snd_no", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setAttachView(JSPUtil.getParameter(request, prefix + "attach_view", ""));
		setLoclPoNo(JSPUtil.getParameter(request, prefix + "locl_po_no", ""));
		setAttach2(JSPUtil.getParameter(request, prefix + "attach2", ""));
		setAttachView2(JSPUtil.getParameter(request, prefix + "attach_view2", ""));
		setIssueType(JSPUtil.getParameter(request, prefix + "issue_type", ""));
		setCopyCnt(JSPUtil.getParameter(request, prefix + "copy_cnt", ""));
		setVnInvPayMzdCd(JSPUtil.getParameter(request, prefix + "vn_inv_pay_mzd_cd", ""));
		setInvEmlSplitFlg(JSPUtil.getParameter(request, prefix + "inv_eml_split_flg", ""));
		setIfNo(JSPUtil.getParameter(request, prefix + "if_no", ""));
		setAutoInvIssFlg(JSPUtil.getParameter(request, prefix + "auto_inv_iss_flg", ""));
		setUserNm(JSPUtil.getParameter(request, prefix + "user_nm", ""));
		setUserEml(JSPUtil.getParameter(request, prefix + "user_eml", ""));
						
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvIssMainVO[]
	 */
	public InvIssMainVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvIssMainVO[]
	 */
	public InvIssMainVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvIssMainVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fKey = (JSPUtil.getParameter(request, prefix	+ "f_key", length));
			String[] titleFlag = (JSPUtil.getParameter(request, prefix	+ "title_flag", length));
			String[] emlSndDt = (JSPUtil.getParameter(request, prefix	+ "eml_snd_dt", length));
			String[] rissDt = (JSPUtil.getParameter(request, prefix	+ "riss_dt", length));
			String[] issOfcCd = (JSPUtil.getParameter(request, prefix	+ "iss_ofc_cd", length));
			String[] usdXchRt = (JSPUtil.getParameter(request, prefix	+ "usd_xch_rt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] invSeq = (JSPUtil.getParameter(request, prefix	+ "inv_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] issDt = (JSPUtil.getParameter(request, prefix	+ "iss_dt", length));
			String[] invIssCmbFlg = (JSPUtil.getParameter(request, prefix	+ "inv_iss_cmb_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rdName = (JSPUtil.getParameter(request, prefix	+ "rd_name", length));
			String[] invIssRmk = (JSPUtil.getParameter(request, prefix	+ "inv_iss_rmk", length));
			String[] invXchRtDt = (JSPUtil.getParameter(request, prefix	+ "inv_xch_rt_dt", length));
			String[] custFaxNo = (JSPUtil.getParameter(request, prefix	+ "cust_fax_no", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] sendFlag = (JSPUtil.getParameter(request, prefix	+ "send_flag", length));
			String[] blSrcNo = (JSPUtil.getParameter(request, prefix	+ "bl_src_no", length));
			String[] actInvNo = (JSPUtil.getParameter(request, prefix	+ "act_inv_no", length));
			String[] emlSndNo = (JSPUtil.getParameter(request, prefix	+ "eml_snd_no", length));
			String[] custEml = (JSPUtil.getParameter(request, prefix	+ "cust_eml", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] issueGubn = (JSPUtil.getParameter(request, prefix	+ "issue_gubn", length));
			String[] nameFlag = (JSPUtil.getParameter(request, prefix	+ "name_flag", length));
			String[] attach = (JSPUtil.getParameter(request, prefix	+ "attach", length));
			String[] faxSndDt = (JSPUtil.getParameter(request, prefix	+ "fax_snd_dt", length));
			String[] faxSndNo = (JSPUtil.getParameter(request, prefix	+ "fax_snd_no", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] attachView = (JSPUtil.getParameter(request, prefix	+ "attach_view", length));
			String[] loclPoNo = (JSPUtil.getParameter(request, prefix	+ "locl_po_no", length));
			String[] attach2 = (JSPUtil.getParameter(request, prefix	+ "attach2", length));
			String[] attachView2 = (JSPUtil.getParameter(request, prefix	+ "attach_view2", length));
			String[] issueType = (JSPUtil.getParameter(request, prefix	+ "issue_type", length));
			String[] copyCnt = (JSPUtil.getParameter(request, prefix	+ "copy_cnt", length));
			String[] vnInvPayMzdCd = (JSPUtil.getParameter(request, prefix	+ "vn_inv_pay_mzd_cd", length));
			String[] invEmlSplitFlg = (JSPUtil.getParameter(request, prefix	+ "inv_eml_split_flg", length));
			String[] ifNo = (JSPUtil.getParameter(request, prefix	+ "if_no", length));
			String[] autoInvIssFlg = (JSPUtil.getParameter(request, prefix	+ "auto_inv_iss_flg", length));
			String[] userNm = (JSPUtil.getParameter(request, prefix	+ "user_nm", length));
			String[] userEml = (JSPUtil.getParameter(request, prefix	+ "user_eml", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvIssMainVO();
				if (fKey[i] != null)
					model.setFKey(fKey[i]);
				if (titleFlag[i] != null)
					model.setTitleFlag(titleFlag[i]);
				if (emlSndDt[i] != null)
					model.setEmlSndDt(emlSndDt[i]);
				if (rissDt[i] != null)
					model.setRissDt(rissDt[i]);
				if (issOfcCd[i] != null)
					model.setIssOfcCd(issOfcCd[i]);
				if (usdXchRt[i] != null)
					model.setUsdXchRt(usdXchRt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (invSeq[i] != null)
					model.setInvSeq(invSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (issDt[i] != null)
					model.setIssDt(issDt[i]);
				if (invIssCmbFlg[i] != null)
					model.setInvIssCmbFlg(invIssCmbFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rdName[i] != null)
					model.setRdName(rdName[i]);
				if (invIssRmk[i] != null)
					model.setInvIssRmk(invIssRmk[i]);
				if (invXchRtDt[i] != null)
					model.setInvXchRtDt(invXchRtDt[i]);
				if (custFaxNo[i] != null)
					model.setCustFaxNo(custFaxNo[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (sendFlag[i] != null)
					model.setSendFlag(sendFlag[i]);
				if (blSrcNo[i] != null)
					model.setBlSrcNo(blSrcNo[i]);
				if (actInvNo[i] != null)
					model.setActInvNo(actInvNo[i]);
				if (emlSndNo[i] != null)
					model.setEmlSndNo(emlSndNo[i]);
				if (custEml[i] != null)
					model.setCustEml(custEml[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (issueGubn[i] != null)
					model.setIssueGubn(issueGubn[i]);
				if (nameFlag[i] != null)
					model.setNameFlag(nameFlag[i]);
				if (attach[i] != null)
					model.setAttach(attach[i]);
				if (faxSndDt[i] != null)
					model.setFaxSndDt(faxSndDt[i]);
				if (faxSndNo[i] != null)
					model.setFaxSndNo(faxSndNo[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (attachView[i] != null)
					model.setAttachView(attachView[i]);
				if (loclPoNo[i] != null)
					model.setLoclPoNo(loclPoNo[i]);
				if (attach2[i] != null)
					model.setAttach2(attach2[i]);
				if (attachView2[i] != null)
					model.setAttachView2(attachView2[i]);
				if (issueType[i] != null)
					model.setIssueType(issueType[i]);
				if (copyCnt[i] != null)
					model.setCopyCnt(copyCnt[i]);
				if (copyCnt[i] != null)
					model.setVnInvPayMzdCd(vnInvPayMzdCd[i]);
                if(invEmlSplitFlg[i] != null)
                    model.setInvEmlSplitFlg(invEmlSplitFlg[i]);
                if(ifNo[i] != null)
                    model.setIfNo(ifNo[i]);
                if(autoInvIssFlg[i] != null)
                    model.setAutoInvIssFlg(autoInvIssFlg[i]);
                if(userNm[i] != null)
                    model.setUserNm(userNm[i]);
                if(userEml[i] != null)
                    model.setUserEml(userEml[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvIssMainVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvIssMainVO[]
	 */
	public InvIssMainVO[] getInvIssMainVOs(){
		InvIssMainVO[] vos = (InvIssMainVO[])models.toArray(new InvIssMainVO[models.size()]);
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
		this.fKey = this.fKey .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.titleFlag = this.titleFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndDt = this.emlSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rissDt = this.rissDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issOfcCd = this.issOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdXchRt = this.usdXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq = this.invSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt = this.issDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIssCmbFlg = this.invIssCmbFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdName = this.rdName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIssRmk = this.invIssRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRtDt = this.invXchRtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custFaxNo = this.custFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sendFlag = this.sendFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrcNo = this.blSrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actInvNo = this.actInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndNo = this.emlSndNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custEml = this.custEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issueGubn = this.issueGubn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nameFlag = this.nameFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attach = this.attach .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndDt = this.faxSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndNo = this.faxSndNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attachView = this.attachView .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclPoNo = this.loclPoNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attach2 = this.attach2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attachView2 = this.attachView2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issueType = this.issueType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copyCnt = this.copyCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnInvPayMzdCd = this.vnInvPayMzdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEmlSplitFlg = invEmlSplitFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifNo = ifNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoInvIssFlg = this.autoInvIssFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userNm = this.userNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userEml = this.userEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
