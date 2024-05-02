/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ComApCsrHisVO.java
*@FileTitle : ComApCsrHisVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.15  
* 1.0 Creation
=========================================================*/

package com.hanjin.bizcommon.csr.csrapproval.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

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

public class ComApCsrHisVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ComApCsrHisVO> models = new ArrayList<ComApCsrHisVO>();
	
	/* Column Info */
	private String aproRmk = null;
	/* Column Info */
	private String aproUsrJbTitNm = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String ifDt = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String comApCsrAproHisSeq = null;
	/* Column Info */
	private String corrHisRmk = null;
	/* Column Info */
	private String gwAproRsltCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String aproUsrNm = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String gwAproUrlCtnt = null;
	/* Column Info */
	private String gwCsrRqstId = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String aproUsrId = null;
	/* Column Info */
	private String invStsCd = null;
	/* Column Info */
	private String apCsrIfStsCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String autoMnlFlg = null;
	/* Column Info */
	private String csrAproTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ComApCsrHisVO() {}

	public ComApCsrHisVO(String ibflag, String pagerows, String comApCsrAproHisSeq, String csrNo, String csrAproTpCd, String autoMnlFlg, String invStsCd, String ioBndCd, String ifDt, String gwCsrRqstId, String gwAproUrlCtnt, String gwAproRsltCd, String corrHisRmk, String creUsrId, String creDt, String updUsrId, String updDt, String aproUsrId, String aproUsrNm, String aproUsrJbTitNm, String aproRmk, String apCsrIfStsCd) {
		this.aproRmk = aproRmk;
		this.aproUsrJbTitNm = aproUsrJbTitNm;
		this.updDt = updDt;
		this.ifDt = ifDt;
		this.csrNo = csrNo;
		this.comApCsrAproHisSeq = comApCsrAproHisSeq;
		this.corrHisRmk = corrHisRmk;
		this.gwAproRsltCd = gwAproRsltCd;
		this.creDt = creDt;
		this.aproUsrNm = aproUsrNm;
		this.ioBndCd = ioBndCd;
		this.pagerows = pagerows;
		this.gwAproUrlCtnt = gwAproUrlCtnt;
		this.gwCsrRqstId = gwCsrRqstId;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.aproUsrId = aproUsrId;
		this.invStsCd = invStsCd;
		this.apCsrIfStsCd = apCsrIfStsCd;
		this.updUsrId = updUsrId;
		this.autoMnlFlg = autoMnlFlg;
		this.csrAproTpCd = csrAproTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("apro_rmk", getAproRmk());
		this.hashColumns.put("apro_usr_jb_tit_nm", getAproUsrJbTitNm());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("if_dt", getIfDt());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("com_ap_csr_apro_his_seq", getComApCsrAproHisSeq());
		this.hashColumns.put("corr_his_rmk", getCorrHisRmk());
		this.hashColumns.put("gw_apro_rslt_cd", getGwAproRsltCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("apro_usr_nm", getAproUsrNm());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("gw_apro_url_ctnt", getGwAproUrlCtnt());
		this.hashColumns.put("gw_csr_rqst_id", getGwCsrRqstId());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("apro_usr_id", getAproUsrId());
		this.hashColumns.put("inv_sts_cd", getInvStsCd());
		this.hashColumns.put("ap_csr_if_sts_cd", getApCsrIfStsCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("auto_mnl_flg", getAutoMnlFlg());
		this.hashColumns.put("csr_apro_tp_cd", getCsrAproTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("apro_rmk", "aproRmk");
		this.hashFields.put("apro_usr_jb_tit_nm", "aproUsrJbTitNm");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("if_dt", "ifDt");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("com_ap_csr_apro_his_seq", "comApCsrAproHisSeq");
		this.hashFields.put("corr_his_rmk", "corrHisRmk");
		this.hashFields.put("gw_apro_rslt_cd", "gwAproRsltCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("apro_usr_nm", "aproUsrNm");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("gw_apro_url_ctnt", "gwAproUrlCtnt");
		this.hashFields.put("gw_csr_rqst_id", "gwCsrRqstId");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("apro_usr_id", "aproUsrId");
		this.hashFields.put("inv_sts_cd", "invStsCd");
		this.hashFields.put("ap_csr_if_sts_cd", "apCsrIfStsCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("auto_mnl_flg", "autoMnlFlg");
		this.hashFields.put("csr_apro_tp_cd", "csrAproTpCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return aproRmk
	 */
	public String getAproRmk() {
		return this.aproRmk;
	}
	
	/**
	 * Column Info
	 * @return aproUsrJbTitNm
	 */
	public String getAproUsrJbTitNm() {
		return this.aproUsrJbTitNm;
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
	 * @return ifDt
	 */
	public String getIfDt() {
		return this.ifDt;
	}
	
	/**
	 * Column Info
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
	}
	
	/**
	 * Column Info
	 * @return comApCsrAproHisSeq
	 */
	public String getComApCsrAproHisSeq() {
		return this.comApCsrAproHisSeq;
	}
	
	/**
	 * Column Info
	 * @return corrHisRmk
	 */
	public String getCorrHisRmk() {
		return this.corrHisRmk;
	}
	
	/**
	 * Column Info
	 * @return gwAproRsltCd
	 */
	public String getGwAproRsltCd() {
		return this.gwAproRsltCd;
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
	 * @return aproUsrNm
	 */
	public String getAproUsrNm() {
		return this.aproUsrNm;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
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
	 * @return gwAproUrlCtnt
	 */
	public String getGwAproUrlCtnt() {
		return this.gwAproUrlCtnt;
	}
	
	/**
	 * Column Info
	 * @return gwCsrRqstId
	 */
	public String getGwCsrRqstId() {
		return this.gwCsrRqstId;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return aproUsrId
	 */
	public String getAproUsrId() {
		return this.aproUsrId;
	}
	
	/**
	 * Column Info
	 * @return invStsCd
	 */
	public String getInvStsCd() {
		return this.invStsCd;
	}
	
	/**
	 * Column Info
	 * @return apCsrIfStsCd
	 */
	public String getApCsrIfStsCd() {
		return this.apCsrIfStsCd;
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
	 * @return autoMnlFlg
	 */
	public String getAutoMnlFlg() {
		return this.autoMnlFlg;
	}
	
	/**
	 * Column Info
	 * @return csrAproTpCd
	 */
	public String getCsrAproTpCd() {
		return this.csrAproTpCd;
	}
	

	/**
	 * Column Info
	 * @param aproRmk
	 */
	public void setAproRmk(String aproRmk) {
		this.aproRmk = aproRmk;
	}
	
	/**
	 * Column Info
	 * @param aproUsrJbTitNm
	 */
	public void setAproUsrJbTitNm(String aproUsrJbTitNm) {
		this.aproUsrJbTitNm = aproUsrJbTitNm;
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
	 * @param ifDt
	 */
	public void setIfDt(String ifDt) {
		this.ifDt = ifDt;
	}
	
	/**
	 * Column Info
	 * @param csrNo
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}
	
	/**
	 * Column Info
	 * @param comApCsrAproHisSeq
	 */
	public void setComApCsrAproHisSeq(String comApCsrAproHisSeq) {
		this.comApCsrAproHisSeq = comApCsrAproHisSeq;
	}
	
	/**
	 * Column Info
	 * @param corrHisRmk
	 */
	public void setCorrHisRmk(String corrHisRmk) {
		this.corrHisRmk = corrHisRmk;
	}
	
	/**
	 * Column Info
	 * @param gwAproRsltCd
	 */
	public void setGwAproRsltCd(String gwAproRsltCd) {
		this.gwAproRsltCd = gwAproRsltCd;
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
	 * @param aproUsrNm
	 */
	public void setAproUsrNm(String aproUsrNm) {
		this.aproUsrNm = aproUsrNm;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
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
	 * @param gwAproUrlCtnt
	 */
	public void setGwAproUrlCtnt(String gwAproUrlCtnt) {
		this.gwAproUrlCtnt = gwAproUrlCtnt;
	}
	
	/**
	 * Column Info
	 * @param gwCsrRqstId
	 */
	public void setGwCsrRqstId(String gwCsrRqstId) {
		this.gwCsrRqstId = gwCsrRqstId;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param aproUsrId
	 */
	public void setAproUsrId(String aproUsrId) {
		this.aproUsrId = aproUsrId;
	}
	
	/**
	 * Column Info
	 * @param invStsCd
	 */
	public void setInvStsCd(String invStsCd) {
		this.invStsCd = invStsCd;
	}
	
	/**
	 * Column Info
	 * @param apCsrIfStsCd
	 */
	public void setApCsrIfStsCd(String apCsrIfStsCd) {
		this.apCsrIfStsCd = apCsrIfStsCd;
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
	 * @param autoMnlFlg
	 */
	public void setAutoMnlFlg(String autoMnlFlg) {
		this.autoMnlFlg = autoMnlFlg;
	}
	
	/**
	 * Column Info
	 * @param csrAproTpCd
	 */
	public void setCsrAproTpCd(String csrAproTpCd) {
		this.csrAproTpCd = csrAproTpCd;
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
		setAproRmk(JSPUtil.getParameter(request, prefix + "apro_rmk", ""));
		setAproUsrJbTitNm(JSPUtil.getParameter(request, prefix + "apro_usr_jb_tit_nm", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setIfDt(JSPUtil.getParameter(request, prefix + "if_dt", ""));
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
		setComApCsrAproHisSeq(JSPUtil.getParameter(request, prefix + "com_ap_csr_apro_his_seq", ""));
		setCorrHisRmk(JSPUtil.getParameter(request, prefix + "corr_his_rmk", ""));
		setGwAproRsltCd(JSPUtil.getParameter(request, prefix + "gw_apro_rslt_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setAproUsrNm(JSPUtil.getParameter(request, prefix + "apro_usr_nm", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setGwAproUrlCtnt(JSPUtil.getParameter(request, prefix + "gw_apro_url_ctnt", ""));
		setGwCsrRqstId(JSPUtil.getParameter(request, prefix + "gw_csr_rqst_id", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAproUsrId(JSPUtil.getParameter(request, prefix + "apro_usr_id", ""));
		setInvStsCd(JSPUtil.getParameter(request, prefix + "inv_sts_cd", ""));
		setApCsrIfStsCd(JSPUtil.getParameter(request, prefix + "ap_csr_if_sts_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setAutoMnlFlg(JSPUtil.getParameter(request, prefix + "auto_mnl_flg", ""));
		setCsrAproTpCd(JSPUtil.getParameter(request, prefix + "csr_apro_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ComApCsrHisVO[]
	 */
	public ComApCsrHisVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ComApCsrHisVO[]
	 */
	public ComApCsrHisVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ComApCsrHisVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] aproRmk = (JSPUtil.getParameter(request, prefix	+ "apro_rmk", length));
			String[] aproUsrJbTitNm = (JSPUtil.getParameter(request, prefix	+ "apro_usr_jb_tit_nm", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] ifDt = (JSPUtil.getParameter(request, prefix	+ "if_dt", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] comApCsrAproHisSeq = (JSPUtil.getParameter(request, prefix	+ "com_ap_csr_apro_his_seq", length));
			String[] corrHisRmk = (JSPUtil.getParameter(request, prefix	+ "corr_his_rmk", length));
			String[] gwAproRsltCd = (JSPUtil.getParameter(request, prefix	+ "gw_apro_rslt_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] aproUsrNm = (JSPUtil.getParameter(request, prefix	+ "apro_usr_nm", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] gwAproUrlCtnt = (JSPUtil.getParameter(request, prefix	+ "gw_apro_url_ctnt", length));
			String[] gwCsrRqstId = (JSPUtil.getParameter(request, prefix	+ "gw_csr_rqst_id", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] aproUsrId = (JSPUtil.getParameter(request, prefix	+ "apro_usr_id", length));
			String[] invStsCd = (JSPUtil.getParameter(request, prefix	+ "inv_sts_cd", length));
			String[] apCsrIfStsCd = (JSPUtil.getParameter(request, prefix	+ "ap_csr_if_sts_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] autoMnlFlg = (JSPUtil.getParameter(request, prefix	+ "auto_mnl_flg", length));
			String[] csrAproTpCd = (JSPUtil.getParameter(request, prefix	+ "csr_apro_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new ComApCsrHisVO();
				if (aproRmk[i] != null)
					model.setAproRmk(aproRmk[i]);
				if (aproUsrJbTitNm[i] != null)
					model.setAproUsrJbTitNm(aproUsrJbTitNm[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ifDt[i] != null)
					model.setIfDt(ifDt[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (comApCsrAproHisSeq[i] != null)
					model.setComApCsrAproHisSeq(comApCsrAproHisSeq[i]);
				if (corrHisRmk[i] != null)
					model.setCorrHisRmk(corrHisRmk[i]);
				if (gwAproRsltCd[i] != null)
					model.setGwAproRsltCd(gwAproRsltCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (aproUsrNm[i] != null)
					model.setAproUsrNm(aproUsrNm[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (gwAproUrlCtnt[i] != null)
					model.setGwAproUrlCtnt(gwAproUrlCtnt[i]);
				if (gwCsrRqstId[i] != null)
					model.setGwCsrRqstId(gwCsrRqstId[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (aproUsrId[i] != null)
					model.setAproUsrId(aproUsrId[i]);
				if (invStsCd[i] != null)
					model.setInvStsCd(invStsCd[i]);
				if (apCsrIfStsCd[i] != null)
					model.setApCsrIfStsCd(apCsrIfStsCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (autoMnlFlg[i] != null)
					model.setAutoMnlFlg(autoMnlFlg[i]);
				if (csrAproTpCd[i] != null)
					model.setCsrAproTpCd(csrAproTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getComApCsrHisVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ComApCsrHisVO[]
	 */
	public ComApCsrHisVO[] getComApCsrHisVOs(){
		ComApCsrHisVO[] vos = (ComApCsrHisVO[])models.toArray(new ComApCsrHisVO[models.size()]);
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
		this.aproRmk = this.aproRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproUsrJbTitNm = this.aproUsrJbTitNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifDt = this.ifDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comApCsrAproHisSeq = this.comApCsrAproHisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrHisRmk = this.corrHisRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gwAproRsltCd = this.gwAproRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproUsrNm = this.aproUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gwAproUrlCtnt = this.gwAproUrlCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gwCsrRqstId = this.gwCsrRqstId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproUsrId = this.aproUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invStsCd = this.invStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apCsrIfStsCd = this.apCsrIfStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoMnlFlg = this.autoMnlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrAproTpCd = this.csrAproTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
