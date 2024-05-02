/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchApproSetupInfoListVO.java
*@FileTitle : SearchApproSetupInfoListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.26
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.26  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo;

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

public class SearchApproSetupInfoListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchApproSetupInfoListVO> models = new ArrayList<SearchApproSetupInfoListVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String dmdtBrncSubstId = null;
	/* Column Info */
	private String dmdtOfcCd = null;
	/* Column Info */
	private String dcFlg = null;
	/* Column Info */
	private String dmdtRhqPicFlg = null;
	/* Column Info */
	private String ofcLvl = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String dcRto = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String dmdtBrncFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String dmdtHoFlg = null;
	/* Column Info */
	private String ftTtlDys = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dcAmt = null;
	/* Column Info */
	private String dmdtSeq = null;
	/* Column Info */
	private String dmdtHoSubstId = null;
	/* Column Info */
	private String dmdtRhqFlg = null;
	/* Column Info */
	private String dmdtExptAproTpCd = null;
	/* Column Info */
	private String ftAddDys = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String dmdtRhqSubstId = null;
	/* Column Info */
	private String custCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchApproSetupInfoListVO() {}

	public SearchApproSetupInfoListVO(String ibflag, String pagerows, String dmdtExptAproTpCd, String ofcLvl, String dmdtOfcCd, String dmdtSeq, String custCntCd, String custSeq, String ftAddDys, String ftTtlDys, String dcFlg, String dcRto, String dcAmt, String dmdtBrncFlg, String dmdtBrncSubstId, String dmdtRhqPicFlg, String dmdtRhqFlg, String dmdtRhqSubstId, String dmdtHoFlg, String dmdtHoSubstId, String creUsrId, String creDt, String updUsrId, String updDt, String custCd) {
		this.updDt = updDt;
		this.dmdtBrncSubstId = dmdtBrncSubstId;
		this.dmdtOfcCd = dmdtOfcCd;
		this.dcFlg = dcFlg;
		this.dmdtRhqPicFlg = dmdtRhqPicFlg;
		this.ofcLvl = ofcLvl;
		this.creDt = creDt;
		this.dcRto = dcRto;
		this.custSeq = custSeq;
		this.dmdtBrncFlg = dmdtBrncFlg;
		this.pagerows = pagerows;
		this.dmdtHoFlg = dmdtHoFlg;
		this.ftTtlDys = ftTtlDys;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.dcAmt = dcAmt;
		this.dmdtSeq = dmdtSeq;
		this.dmdtHoSubstId = dmdtHoSubstId;
		this.dmdtRhqFlg = dmdtRhqFlg;
		this.dmdtExptAproTpCd = dmdtExptAproTpCd;
		this.ftAddDys = ftAddDys;
		this.updUsrId = updUsrId;
		this.custCntCd = custCntCd;
		this.dmdtRhqSubstId = dmdtRhqSubstId;
		this.custCd = custCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("dmdt_brnc_subst_id", getDmdtBrncSubstId());
		this.hashColumns.put("dmdt_ofc_cd", getDmdtOfcCd());
		this.hashColumns.put("dc_flg", getDcFlg());
		this.hashColumns.put("dmdt_rhq_pic_flg", getDmdtRhqPicFlg());
		this.hashColumns.put("ofc_lvl", getOfcLvl());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("dc_rto", getDcRto());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("dmdt_brnc_flg", getDmdtBrncFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dmdt_ho_flg", getDmdtHoFlg());
		this.hashColumns.put("ft_ttl_dys", getFtTtlDys());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dc_amt", getDcAmt());
		this.hashColumns.put("dmdt_seq", getDmdtSeq());
		this.hashColumns.put("dmdt_ho_subst_id", getDmdtHoSubstId());
		this.hashColumns.put("dmdt_rhq_flg", getDmdtRhqFlg());
		this.hashColumns.put("dmdt_expt_apro_tp_cd", getDmdtExptAproTpCd());
		this.hashColumns.put("ft_add_dys", getFtAddDys());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("dmdt_rhq_subst_id", getDmdtRhqSubstId());
		this.hashColumns.put("cust_cd", getCustCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("dmdt_brnc_subst_id", "dmdtBrncSubstId");
		this.hashFields.put("dmdt_ofc_cd", "dmdtOfcCd");
		this.hashFields.put("dc_flg", "dcFlg");
		this.hashFields.put("dmdt_rhq_pic_flg", "dmdtRhqPicFlg");
		this.hashFields.put("ofc_lvl", "ofcLvl");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("dc_rto", "dcRto");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("dmdt_brnc_flg", "dmdtBrncFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dmdt_ho_flg", "dmdtHoFlg");
		this.hashFields.put("ft_ttl_dys", "ftTtlDys");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dc_amt", "dcAmt");
		this.hashFields.put("dmdt_seq", "dmdtSeq");
		this.hashFields.put("dmdt_ho_subst_id", "dmdtHoSubstId");
		this.hashFields.put("dmdt_rhq_flg", "dmdtRhqFlg");
		this.hashFields.put("dmdt_expt_apro_tp_cd", "dmdtExptAproTpCd");
		this.hashFields.put("ft_add_dys", "ftAddDys");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("dmdt_rhq_subst_id", "dmdtRhqSubstId");
		this.hashFields.put("cust_cd", "custCd");
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
	 * @return dmdtBrncSubstId
	 */
	public String getDmdtBrncSubstId() {
		return this.dmdtBrncSubstId;
	}
	
	/**
	 * Column Info
	 * @return dmdtOfcCd
	 */
	public String getDmdtOfcCd() {
		return this.dmdtOfcCd;
	}
	
	/**
	 * Column Info
	 * @return dcFlg
	 */
	public String getDcFlg() {
		return this.dcFlg;
	}
	
	/**
	 * Column Info
	 * @return dmdtRhqPicFlg
	 */
	public String getDmdtRhqPicFlg() {
		return this.dmdtRhqPicFlg;
	}
	
	/**
	 * Column Info
	 * @return ofcLvl
	 */
	public String getOfcLvl() {
		return this.ofcLvl;
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
	 * @return dcRto
	 */
	public String getDcRto() {
		return this.dcRto;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return dmdtBrncFlg
	 */
	public String getDmdtBrncFlg() {
		return this.dmdtBrncFlg;
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
	 * @return dmdtHoFlg
	 */
	public String getDmdtHoFlg() {
		return this.dmdtHoFlg;
	}
	
	/**
	 * Column Info
	 * @return ftTtlDys
	 */
	public String getFtTtlDys() {
		return this.ftTtlDys;
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
	 * @return dcAmt
	 */
	public String getDcAmt() {
		return this.dcAmt;
	}
	
	/**
	 * Column Info
	 * @return dmdtSeq
	 */
	public String getDmdtSeq() {
		return this.dmdtSeq;
	}
	
	/**
	 * Column Info
	 * @return dmdtHoSubstId
	 */
	public String getDmdtHoSubstId() {
		return this.dmdtHoSubstId;
	}
	
	/**
	 * Column Info
	 * @return dmdtRhqFlg
	 */
	public String getDmdtRhqFlg() {
		return this.dmdtRhqFlg;
	}
	
	/**
	 * Column Info
	 * @return dmdtExptAproTpCd
	 */
	public String getDmdtExptAproTpCd() {
		return this.dmdtExptAproTpCd;
	}
	
	/**
	 * Column Info
	 * @return ftAddDys
	 */
	public String getFtAddDys() {
		return this.ftAddDys;
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
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtRhqSubstId
	 */
	public String getDmdtRhqSubstId() {
		return this.dmdtRhqSubstId;
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
	 * @param dmdtBrncSubstId
	 */
	public void setDmdtBrncSubstId(String dmdtBrncSubstId) {
		this.dmdtBrncSubstId = dmdtBrncSubstId;
	}
	
	/**
	 * Column Info
	 * @param dmdtOfcCd
	 */
	public void setDmdtOfcCd(String dmdtOfcCd) {
		this.dmdtOfcCd = dmdtOfcCd;
	}
	
	/**
	 * Column Info
	 * @param dcFlg
	 */
	public void setDcFlg(String dcFlg) {
		this.dcFlg = dcFlg;
	}
	
	/**
	 * Column Info
	 * @param dmdtRhqPicFlg
	 */
	public void setDmdtRhqPicFlg(String dmdtRhqPicFlg) {
		this.dmdtRhqPicFlg = dmdtRhqPicFlg;
	}
	
	/**
	 * Column Info
	 * @param ofcLvl
	 */
	public void setOfcLvl(String ofcLvl) {
		this.ofcLvl = ofcLvl;
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
	 * @param dcRto
	 */
	public void setDcRto(String dcRto) {
		this.dcRto = dcRto;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param dmdtBrncFlg
	 */
	public void setDmdtBrncFlg(String dmdtBrncFlg) {
		this.dmdtBrncFlg = dmdtBrncFlg;
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
	 * @param dmdtHoFlg
	 */
	public void setDmdtHoFlg(String dmdtHoFlg) {
		this.dmdtHoFlg = dmdtHoFlg;
	}
	
	/**
	 * Column Info
	 * @param ftTtlDys
	 */
	public void setFtTtlDys(String ftTtlDys) {
		this.ftTtlDys = ftTtlDys;
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
	 * @param dcAmt
	 */
	public void setDcAmt(String dcAmt) {
		this.dcAmt = dcAmt;
	}
	
	/**
	 * Column Info
	 * @param dmdtSeq
	 */
	public void setDmdtSeq(String dmdtSeq) {
		this.dmdtSeq = dmdtSeq;
	}
	
	/**
	 * Column Info
	 * @param dmdtHoSubstId
	 */
	public void setDmdtHoSubstId(String dmdtHoSubstId) {
		this.dmdtHoSubstId = dmdtHoSubstId;
	}
	
	/**
	 * Column Info
	 * @param dmdtRhqFlg
	 */
	public void setDmdtRhqFlg(String dmdtRhqFlg) {
		this.dmdtRhqFlg = dmdtRhqFlg;
	}
	
	/**
	 * Column Info
	 * @param dmdtExptAproTpCd
	 */
	public void setDmdtExptAproTpCd(String dmdtExptAproTpCd) {
		this.dmdtExptAproTpCd = dmdtExptAproTpCd;
	}
	
	/**
	 * Column Info
	 * @param ftAddDys
	 */
	public void setFtAddDys(String ftAddDys) {
		this.ftAddDys = ftAddDys;
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
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtRhqSubstId
	 */
	public void setDmdtRhqSubstId(String dmdtRhqSubstId) {
		this.dmdtRhqSubstId = dmdtRhqSubstId;
	}
	
	public String getCustCd() {
		return custCd;
	}

	public void setCustCd(String custCd) {
		this.custCd = custCd;
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
		setDmdtBrncSubstId(JSPUtil.getParameter(request, prefix + "dmdt_brnc_subst_id", ""));
		setDmdtOfcCd(JSPUtil.getParameter(request, prefix + "dmdt_ofc_cd", ""));
		setDcFlg(JSPUtil.getParameter(request, prefix + "dc_flg", ""));
		setDmdtRhqPicFlg(JSPUtil.getParameter(request, prefix + "dmdt_rhq_pic_flg", ""));
		setOfcLvl(JSPUtil.getParameter(request, prefix + "ofc_lvl", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setDcRto(JSPUtil.getParameter(request, prefix + "dc_rto", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setDmdtBrncFlg(JSPUtil.getParameter(request, prefix + "dmdt_brnc_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDmdtHoFlg(JSPUtil.getParameter(request, prefix + "dmdt_ho_flg", ""));
		setFtTtlDys(JSPUtil.getParameter(request, prefix + "ft_ttl_dys", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDcAmt(JSPUtil.getParameter(request, prefix + "dc_amt", ""));
		setDmdtSeq(JSPUtil.getParameter(request, prefix + "dmdt_seq", ""));
		setDmdtHoSubstId(JSPUtil.getParameter(request, prefix + "dmdt_ho_subst_id", ""));
		setDmdtRhqFlg(JSPUtil.getParameter(request, prefix + "dmdt_rhq_flg", ""));
		setDmdtExptAproTpCd(JSPUtil.getParameter(request, prefix + "dmdt_expt_apro_tp_cd", ""));
		setFtAddDys(JSPUtil.getParameter(request, prefix + "ft_add_dys", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setDmdtRhqSubstId(JSPUtil.getParameter(request, prefix + "dmdt_rhq_subst_id", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchApproSetupInfoListVO[]
	 */
	public SearchApproSetupInfoListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchApproSetupInfoListVO[]
	 */
	public SearchApproSetupInfoListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchApproSetupInfoListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] dmdtBrncSubstId = (JSPUtil.getParameter(request, prefix	+ "dmdt_brnc_subst_id", length));
			String[] dmdtOfcCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_ofc_cd", length));
			String[] dcFlg = (JSPUtil.getParameter(request, prefix	+ "dc_flg", length));
			String[] dmdtRhqPicFlg = (JSPUtil.getParameter(request, prefix	+ "dmdt_rhq_pic_flg", length));
			String[] ofcLvl = (JSPUtil.getParameter(request, prefix	+ "ofc_lvl", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] dcRto = (JSPUtil.getParameter(request, prefix	+ "dc_rto", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] dmdtBrncFlg = (JSPUtil.getParameter(request, prefix	+ "dmdt_brnc_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] dmdtHoFlg = (JSPUtil.getParameter(request, prefix	+ "dmdt_ho_flg", length));
			String[] ftTtlDys = (JSPUtil.getParameter(request, prefix	+ "ft_ttl_dys", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dcAmt = (JSPUtil.getParameter(request, prefix	+ "dc_amt", length));
			String[] dmdtSeq = (JSPUtil.getParameter(request, prefix	+ "dmdt_seq", length));
			String[] dmdtHoSubstId = (JSPUtil.getParameter(request, prefix	+ "dmdt_ho_subst_id", length));
			String[] dmdtRhqFlg = (JSPUtil.getParameter(request, prefix	+ "dmdt_rhq_flg", length));
			String[] dmdtExptAproTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_expt_apro_tp_cd", length));
			String[] ftAddDys = (JSPUtil.getParameter(request, prefix	+ "ft_add_dys", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] dmdtRhqSubstId = (JSPUtil.getParameter(request, prefix	+ "dmdt_rhq_subst_id", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchApproSetupInfoListVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (dmdtBrncSubstId[i] != null)
					model.setDmdtBrncSubstId(dmdtBrncSubstId[i]);
				if (dmdtOfcCd[i] != null)
					model.setDmdtOfcCd(dmdtOfcCd[i]);
				if (dcFlg[i] != null)
					model.setDcFlg(dcFlg[i]);
				if (dmdtRhqPicFlg[i] != null)
					model.setDmdtRhqPicFlg(dmdtRhqPicFlg[i]);
				if (ofcLvl[i] != null)
					model.setOfcLvl(ofcLvl[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (dcRto[i] != null)
					model.setDcRto(dcRto[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (dmdtBrncFlg[i] != null)
					model.setDmdtBrncFlg(dmdtBrncFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (dmdtHoFlg[i] != null)
					model.setDmdtHoFlg(dmdtHoFlg[i]);
				if (ftTtlDys[i] != null)
					model.setFtTtlDys(ftTtlDys[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dcAmt[i] != null)
					model.setDcAmt(dcAmt[i]);
				if (dmdtSeq[i] != null)
					model.setDmdtSeq(dmdtSeq[i]);
				if (dmdtHoSubstId[i] != null)
					model.setDmdtHoSubstId(dmdtHoSubstId[i]);
				if (dmdtRhqFlg[i] != null)
					model.setDmdtRhqFlg(dmdtRhqFlg[i]);
				if (dmdtExptAproTpCd[i] != null)
					model.setDmdtExptAproTpCd(dmdtExptAproTpCd[i]);
				if (ftAddDys[i] != null)
					model.setFtAddDys(ftAddDys[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (dmdtRhqSubstId[i] != null)
					model.setDmdtRhqSubstId(dmdtRhqSubstId[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchApproSetupInfoListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchApproSetupInfoListVO[]
	 */
	public SearchApproSetupInfoListVO[] getSearchApproSetupInfoListVOs(){
		SearchApproSetupInfoListVO[] vos = (SearchApproSetupInfoListVO[])models.toArray(new SearchApproSetupInfoListVO[models.size()]);
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
		this.dmdtBrncSubstId = this.dmdtBrncSubstId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtOfcCd = this.dmdtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcFlg = this.dcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtRhqPicFlg = this.dmdtRhqPicFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcLvl = this.ofcLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcRto = this.dcRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtBrncFlg = this.dmdtBrncFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtHoFlg = this.dmdtHoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftTtlDys = this.ftTtlDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcAmt = this.dcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtSeq = this.dmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtHoSubstId = this.dmdtHoSubstId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtRhqFlg = this.dmdtRhqFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtExptAproTpCd = this.dmdtExptAproTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftAddDys = this.ftAddDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtRhqSubstId = this.dmdtRhqSubstId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
