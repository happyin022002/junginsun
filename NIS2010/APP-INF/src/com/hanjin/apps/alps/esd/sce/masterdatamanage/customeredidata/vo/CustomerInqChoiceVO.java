/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CustomerInqChoiceVO.java
*@FileTitle : CustomerInqChoiceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.09
*@LastModifier : 
*@LastVersion : 1.0
* 2012.08.09  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo;

import java.lang.reflect.Field;
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomerInqChoiceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomerInqChoiceVO> models = new ArrayList<CustomerInqChoiceVO>();
	
	/* Column Info */
	private String sHiddenFlg = null;
	/* Column Info */
	private String sRptColNm = null;
	/* Column Info */
	private String custEdiStsCd = null;
	/* Column Info */
	private String sRptColDesc = null;
	/* Column Info */
	private String sEdiStsFlg = null;
	/* Column Info */
	private String csCd = null;
	/* Column Info */
	private String ediStndStsCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ediCgoRmk = null;
	/* Column Info */
	private String sEdiGrpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String custTrdPrnrId = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String csNm = null;
	/* Column Info */
	private String ediGrpDesc = null;
	/* Column Info */
	private String sUseFlg = null;
	/* Column Info */
	private String ediGrpCd = null;
	/* Column Info */
	private String sRptColSeq = null;
	/* Column Info */
	private String sCustEdiStsCd = null;
	/* Column Info */
	private String csGrpId = null;
	/* Column Info */
	private String hjTpId = null;
	/* Column Info */
	private String sCreUsrId = null;
	/* Column Info */
	private String ediGrpId = null;
	/* Column Info */
	private String tpId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomerInqChoiceVO() {}

	public CustomerInqChoiceVO(String ibflag, String pagerows, String ediGrpDesc, String ediGrpCd, String custEdiStsCd, String csCd, String csGrpId, String ediStndStsCd, String ediCgoRmk, String ediGrpId, String scNo, String userId, String custTrdPrnrId, String tpId, String csNm, String hjTpId, String sCreUsrId, String sEdiGrpCd, String sRptColDesc, String sEdiStsFlg, String sUseFlg, String sRptColSeq, String sRptColNm, String sCustEdiStsCd, String sHiddenFlg) {
		this.sHiddenFlg = sHiddenFlg;
		this.sRptColNm = sRptColNm;
		this.custEdiStsCd = custEdiStsCd;
		this.sRptColDesc = sRptColDesc;
		this.sEdiStsFlg = sEdiStsFlg;
		this.csCd = csCd;
		this.ediStndStsCd = ediStndStsCd;
		this.pagerows = pagerows;
		this.ediCgoRmk = ediCgoRmk;
		this.sEdiGrpCd = sEdiGrpCd;
		this.ibflag = ibflag;
		this.scNo = scNo;
		this.custTrdPrnrId = custTrdPrnrId;
		this.userId = userId;
		this.csNm = csNm;
		this.ediGrpDesc = ediGrpDesc;
		this.sUseFlg = sUseFlg;
		this.ediGrpCd = ediGrpCd;
		this.sRptColSeq = sRptColSeq;
		this.sCustEdiStsCd = sCustEdiStsCd;
		this.csGrpId = csGrpId;
		this.hjTpId = hjTpId;
		this.sCreUsrId = sCreUsrId;
		this.ediGrpId = ediGrpId;
		this.tpId = tpId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("s_hidden_flg", getSHiddenFlg());
		this.hashColumns.put("s_rpt_col_nm", getSRptColNm());
		this.hashColumns.put("cust_edi_sts_cd", getCustEdiStsCd());
		this.hashColumns.put("s_rpt_col_desc", getSRptColDesc());
		this.hashColumns.put("s_edi_sts_flg", getSEdiStsFlg());
		this.hashColumns.put("cs_cd", getCsCd());
		this.hashColumns.put("edi_stnd_sts_cd", getEdiStndStsCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("edi_cgo_rmk", getEdiCgoRmk());
		this.hashColumns.put("s_edi_grp_cd", getSEdiGrpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("cust_trd_prnr_id", getCustTrdPrnrId());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("cs_nm", getCsNm());
		this.hashColumns.put("edi_grp_desc", getEdiGrpDesc());
		this.hashColumns.put("s_use_flg", getSUseFlg());
		this.hashColumns.put("edi_grp_cd", getEdiGrpCd());
		this.hashColumns.put("s_rpt_col_seq", getSRptColSeq());
		this.hashColumns.put("s_cust_edi_sts_cd", getSCustEdiStsCd());
		this.hashColumns.put("cs_grp_id", getCsGrpId());
		this.hashColumns.put("hj_tp_id", getHjTpId());
		this.hashColumns.put("s_cre_usr_id", getSCreUsrId());
		this.hashColumns.put("edi_grp_id", getEdiGrpId());
		this.hashColumns.put("tp_id", getTpId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("s_hidden_flg", "sHiddenFlg");
		this.hashFields.put("s_rpt_col_nm", "sRptColNm");
		this.hashFields.put("cust_edi_sts_cd", "custEdiStsCd");
		this.hashFields.put("s_rpt_col_desc", "sRptColDesc");
		this.hashFields.put("s_edi_sts_flg", "sEdiStsFlg");
		this.hashFields.put("cs_cd", "csCd");
		this.hashFields.put("edi_stnd_sts_cd", "ediStndStsCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("edi_cgo_rmk", "ediCgoRmk");
		this.hashFields.put("s_edi_grp_cd", "sEdiGrpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("cust_trd_prnr_id", "custTrdPrnrId");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("cs_nm", "csNm");
		this.hashFields.put("edi_grp_desc", "ediGrpDesc");
		this.hashFields.put("s_use_flg", "sUseFlg");
		this.hashFields.put("edi_grp_cd", "ediGrpCd");
		this.hashFields.put("s_rpt_col_seq", "sRptColSeq");
		this.hashFields.put("s_cust_edi_sts_cd", "sCustEdiStsCd");
		this.hashFields.put("cs_grp_id", "csGrpId");
		this.hashFields.put("hj_tp_id", "hjTpId");
		this.hashFields.put("s_cre_usr_id", "sCreUsrId");
		this.hashFields.put("edi_grp_id", "ediGrpId");
		this.hashFields.put("tp_id", "tpId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sHiddenFlg
	 */
	public String getSHiddenFlg() {
		return this.sHiddenFlg;
	}
	
	/**
	 * Column Info
	 * @return sRptColNm
	 */
	public String getSRptColNm() {
		return this.sRptColNm;
	}
	
	/**
	 * Column Info
	 * @return custEdiStsCd
	 */
	public String getCustEdiStsCd() {
		return this.custEdiStsCd;
	}
	
	/**
	 * Column Info
	 * @return sRptColDesc
	 */
	public String getSRptColDesc() {
		return this.sRptColDesc;
	}
	
	/**
	 * Column Info
	 * @return sEdiStsFlg
	 */
	public String getSEdiStsFlg() {
		return this.sEdiStsFlg;
	}
	
	/**
	 * Column Info
	 * @return csCd
	 */
	public String getCsCd() {
		return this.csCd;
	}
	
	/**
	 * Column Info
	 * @return ediStndStsCd
	 */
	public String getEdiStndStsCd() {
		return this.ediStndStsCd;
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
	 * @return ediCgoRmk
	 */
	public String getEdiCgoRmk() {
		return this.ediCgoRmk;
	}
	
	/**
	 * Column Info
	 * @return sEdiGrpCd
	 */
	public String getSEdiGrpCd() {
		return this.sEdiGrpCd;
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
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return custTrdPrnrId
	 */
	public String getCustTrdPrnrId() {
		return this.custTrdPrnrId;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return csNm
	 */
	public String getCsNm() {
		return this.csNm;
	}
	
	/**
	 * Column Info
	 * @return ediGrpDesc
	 */
	public String getEdiGrpDesc() {
		return this.ediGrpDesc;
	}
	
	/**
	 * Column Info
	 * @return sUseFlg
	 */
	public String getSUseFlg() {
		return this.sUseFlg;
	}
	
	/**
	 * Column Info
	 * @return ediGrpCd
	 */
	public String getEdiGrpCd() {
		return this.ediGrpCd;
	}
	
	/**
	 * Column Info
	 * @return sRptColSeq
	 */
	public String getSRptColSeq() {
		return this.sRptColSeq;
	}
	
	/**
	 * Column Info
	 * @return sCustEdiStsCd
	 */
	public String getSCustEdiStsCd() {
		return this.sCustEdiStsCd;
	}
	
	/**
	 * Column Info
	 * @return csGrpId
	 */
	public String getCsGrpId() {
		return this.csGrpId;
	}
	
	/**
	 * Column Info
	 * @return hjTpId
	 */
	public String getHjTpId() {
		return this.hjTpId;
	}
	
	/**
	 * Column Info
	 * @return sCreUsrId
	 */
	public String getSCreUsrId() {
		return this.sCreUsrId;
	}
	
	/**
	 * Column Info
	 * @return ediGrpId
	 */
	public String getEdiGrpId() {
		return this.ediGrpId;
	}
	
	/**
	 * Column Info
	 * @return tpId
	 */
	public String getTpId() {
		return this.tpId;
	}
	

	/**
	 * Column Info
	 * @param sHiddenFlg
	 */
	public void setSHiddenFlg(String sHiddenFlg) {
		this.sHiddenFlg = sHiddenFlg;
	}
	
	/**
	 * Column Info
	 * @param sRptColNm
	 */
	public void setSRptColNm(String sRptColNm) {
		this.sRptColNm = sRptColNm;
	}
	
	/**
	 * Column Info
	 * @param custEdiStsCd
	 */
	public void setCustEdiStsCd(String custEdiStsCd) {
		this.custEdiStsCd = custEdiStsCd;
	}
	
	/**
	 * Column Info
	 * @param sRptColDesc
	 */
	public void setSRptColDesc(String sRptColDesc) {
		this.sRptColDesc = sRptColDesc;
	}
	
	/**
	 * Column Info
	 * @param sEdiStsFlg
	 */
	public void setSEdiStsFlg(String sEdiStsFlg) {
		this.sEdiStsFlg = sEdiStsFlg;
	}
	
	/**
	 * Column Info
	 * @param csCd
	 */
	public void setCsCd(String csCd) {
		this.csCd = csCd;
	}
	
	/**
	 * Column Info
	 * @param ediStndStsCd
	 */
	public void setEdiStndStsCd(String ediStndStsCd) {
		this.ediStndStsCd = ediStndStsCd;
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
	 * @param ediCgoRmk
	 */
	public void setEdiCgoRmk(String ediCgoRmk) {
		this.ediCgoRmk = ediCgoRmk;
	}
	
	/**
	 * Column Info
	 * @param sEdiGrpCd
	 */
	public void setSEdiGrpCd(String sEdiGrpCd) {
		this.sEdiGrpCd = sEdiGrpCd;
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
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param custTrdPrnrId
	 */
	public void setCustTrdPrnrId(String custTrdPrnrId) {
		this.custTrdPrnrId = custTrdPrnrId;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param csNm
	 */
	public void setCsNm(String csNm) {
		this.csNm = csNm;
	}
	
	/**
	 * Column Info
	 * @param ediGrpDesc
	 */
	public void setEdiGrpDesc(String ediGrpDesc) {
		this.ediGrpDesc = ediGrpDesc;
	}
	
	/**
	 * Column Info
	 * @param sUseFlg
	 */
	public void setSUseFlg(String sUseFlg) {
		this.sUseFlg = sUseFlg;
	}
	
	/**
	 * Column Info
	 * @param ediGrpCd
	 */
	public void setEdiGrpCd(String ediGrpCd) {
		this.ediGrpCd = ediGrpCd;
	}
	
	/**
	 * Column Info
	 * @param sRptColSeq
	 */
	public void setSRptColSeq(String sRptColSeq) {
		this.sRptColSeq = sRptColSeq;
	}
	
	/**
	 * Column Info
	 * @param sCustEdiStsCd
	 */
	public void setSCustEdiStsCd(String sCustEdiStsCd) {
		this.sCustEdiStsCd = sCustEdiStsCd;
	}
	
	/**
	 * Column Info
	 * @param csGrpId
	 */
	public void setCsGrpId(String csGrpId) {
		this.csGrpId = csGrpId;
	}
	
	/**
	 * Column Info
	 * @param hjTpId
	 */
	public void setHjTpId(String hjTpId) {
		this.hjTpId = hjTpId;
	}
	
	/**
	 * Column Info
	 * @param sCreUsrId
	 */
	public void setSCreUsrId(String sCreUsrId) {
		this.sCreUsrId = sCreUsrId;
	}
	
	/**
	 * Column Info
	 * @param ediGrpId
	 */
	public void setEdiGrpId(String ediGrpId) {
		this.ediGrpId = ediGrpId;
	}
	
	/**
	 * Column Info
	 * @param tpId
	 */
	public void setTpId(String tpId) {
		this.tpId = tpId;
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
		setSHiddenFlg(JSPUtil.getParameter(request, prefix + "s_hidden_flg", ""));
		setSRptColNm(JSPUtil.getParameter(request, prefix + "s_rpt_col_nm", ""));
		setCustEdiStsCd(JSPUtil.getParameter(request, prefix + "cust_edi_sts_cd", ""));
		setSRptColDesc(JSPUtil.getParameter(request, prefix + "s_rpt_col_desc", ""));
		setSEdiStsFlg(JSPUtil.getParameter(request, prefix + "s_edi_sts_flg", ""));
		setCsCd(JSPUtil.getParameter(request, prefix + "cs_cd", ""));
		setEdiStndStsCd(JSPUtil.getParameter(request, prefix + "edi_stnd_sts_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEdiCgoRmk(JSPUtil.getParameter(request, prefix + "edi_cgo_rmk", ""));
		setSEdiGrpCd(JSPUtil.getParameter(request, prefix + "s_edi_grp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setCustTrdPrnrId(JSPUtil.getParameter(request, prefix + "cust_trd_prnr_id", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setCsNm(JSPUtil.getParameter(request, prefix + "cs_nm", ""));
		setEdiGrpDesc(JSPUtil.getParameter(request, prefix + "edi_grp_desc", ""));
		setSUseFlg(JSPUtil.getParameter(request, prefix + "s_use_flg", ""));
		setEdiGrpCd(JSPUtil.getParameter(request, prefix + "edi_grp_cd", ""));
		setSRptColSeq(JSPUtil.getParameter(request, prefix + "s_rpt_col_seq", ""));
		setSCustEdiStsCd(JSPUtil.getParameter(request, prefix + "s_cust_edi_sts_cd", ""));
		setCsGrpId(JSPUtil.getParameter(request, prefix + "cs_grp_id", ""));
		setHjTpId(JSPUtil.getParameter(request, prefix + "hj_tp_id", ""));
		setSCreUsrId(JSPUtil.getParameter(request, prefix + "s_cre_usr_id", ""));
		setEdiGrpId(JSPUtil.getParameter(request, prefix + "edi_grp_id", ""));
		setTpId(JSPUtil.getParameter(request, prefix + "tp_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomerInqChoiceVO[]
	 */
	public CustomerInqChoiceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomerInqChoiceVO[]
	 */
	public CustomerInqChoiceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomerInqChoiceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sHiddenFlg = (JSPUtil.getParameter(request, prefix	+ "s_hidden_flg", length));
			String[] sRptColNm = (JSPUtil.getParameter(request, prefix	+ "s_rpt_col_nm", length));
			String[] custEdiStsCd = (JSPUtil.getParameter(request, prefix	+ "cust_edi_sts_cd", length));
			String[] sRptColDesc = (JSPUtil.getParameter(request, prefix	+ "s_rpt_col_desc", length));
			String[] sEdiStsFlg = (JSPUtil.getParameter(request, prefix	+ "s_edi_sts_flg", length));
			String[] csCd = (JSPUtil.getParameter(request, prefix	+ "cs_cd", length));
			String[] ediStndStsCd = (JSPUtil.getParameter(request, prefix	+ "edi_stnd_sts_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ediCgoRmk = (JSPUtil.getParameter(request, prefix	+ "edi_cgo_rmk", length));
			String[] sEdiGrpCd = (JSPUtil.getParameter(request, prefix	+ "s_edi_grp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] custTrdPrnrId = (JSPUtil.getParameter(request, prefix	+ "cust_trd_prnr_id", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] csNm = (JSPUtil.getParameter(request, prefix	+ "cs_nm", length));
			String[] ediGrpDesc = (JSPUtil.getParameter(request, prefix	+ "edi_grp_desc", length));
			String[] sUseFlg = (JSPUtil.getParameter(request, prefix	+ "s_use_flg", length));
			String[] ediGrpCd = (JSPUtil.getParameter(request, prefix	+ "edi_grp_cd", length));
			String[] sRptColSeq = (JSPUtil.getParameter(request, prefix	+ "s_rpt_col_seq", length));
			String[] sCustEdiStsCd = (JSPUtil.getParameter(request, prefix	+ "s_cust_edi_sts_cd", length));
			String[] csGrpId = (JSPUtil.getParameter(request, prefix	+ "cs_grp_id", length));
			String[] hjTpId = (JSPUtil.getParameter(request, prefix	+ "hj_tp_id", length));
			String[] sCreUsrId = (JSPUtil.getParameter(request, prefix	+ "s_cre_usr_id", length));
			String[] ediGrpId = (JSPUtil.getParameter(request, prefix	+ "edi_grp_id", length));
			String[] tpId = (JSPUtil.getParameter(request, prefix	+ "tp_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomerInqChoiceVO();
				if (sHiddenFlg[i] != null)
					model.setSHiddenFlg(sHiddenFlg[i]);
				if (sRptColNm[i] != null)
					model.setSRptColNm(sRptColNm[i]);
				if (custEdiStsCd[i] != null)
					model.setCustEdiStsCd(custEdiStsCd[i]);
				if (sRptColDesc[i] != null)
					model.setSRptColDesc(sRptColDesc[i]);
				if (sEdiStsFlg[i] != null)
					model.setSEdiStsFlg(sEdiStsFlg[i]);
				if (csCd[i] != null)
					model.setCsCd(csCd[i]);
				if (ediStndStsCd[i] != null)
					model.setEdiStndStsCd(ediStndStsCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ediCgoRmk[i] != null)
					model.setEdiCgoRmk(ediCgoRmk[i]);
				if (sEdiGrpCd[i] != null)
					model.setSEdiGrpCd(sEdiGrpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (custTrdPrnrId[i] != null)
					model.setCustTrdPrnrId(custTrdPrnrId[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (csNm[i] != null)
					model.setCsNm(csNm[i]);
				if (ediGrpDesc[i] != null)
					model.setEdiGrpDesc(ediGrpDesc[i]);
				if (sUseFlg[i] != null)
					model.setSUseFlg(sUseFlg[i]);
				if (ediGrpCd[i] != null)
					model.setEdiGrpCd(ediGrpCd[i]);
				if (sRptColSeq[i] != null)
					model.setSRptColSeq(sRptColSeq[i]);
				if (sCustEdiStsCd[i] != null)
					model.setSCustEdiStsCd(sCustEdiStsCd[i]);
				if (csGrpId[i] != null)
					model.setCsGrpId(csGrpId[i]);
				if (hjTpId[i] != null)
					model.setHjTpId(hjTpId[i]);
				if (sCreUsrId[i] != null)
					model.setSCreUsrId(sCreUsrId[i]);
				if (ediGrpId[i] != null)
					model.setEdiGrpId(ediGrpId[i]);
				if (tpId[i] != null)
					model.setTpId(tpId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomerInqChoiceVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomerInqChoiceVO[]
	 */
	public CustomerInqChoiceVO[] getCustomerInqChoiceVOs(){
		CustomerInqChoiceVO[] vos = (CustomerInqChoiceVO[])models.toArray(new CustomerInqChoiceVO[models.size()]);
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
		this.sHiddenFlg = this.sHiddenFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRptColNm = this.sRptColNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custEdiStsCd = this.custEdiStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRptColDesc = this.sRptColDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEdiStsFlg = this.sEdiStsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csCd = this.csCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediStndStsCd = this.ediStndStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediCgoRmk = this.ediCgoRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEdiGrpCd = this.sEdiGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTrdPrnrId = this.custTrdPrnrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csNm = this.csNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediGrpDesc = this.ediGrpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sUseFlg = this.sUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediGrpCd = this.ediGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRptColSeq = this.sRptColSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustEdiStsCd = this.sCustEdiStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csGrpId = this.csGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjTpId = this.hjTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCreUsrId = this.sCreUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediGrpId = this.ediGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpId = this.tpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
