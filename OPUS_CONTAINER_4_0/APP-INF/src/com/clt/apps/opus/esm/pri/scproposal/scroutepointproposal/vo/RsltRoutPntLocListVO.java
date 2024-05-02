/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RsltRoutPntLocListVO.java
*@FileTitle : RsltRoutPntLocListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.04
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.01.04 최성민 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.scproposal.scroutepointproposal.vo;

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
 * @author 최성민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltRoutPntLocListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltRoutPntLocListVO> models = new ArrayList<RsltRoutPntLocListVO>();
	
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String firstOrder = null;
	/* Column Info */
	private String routPntLocDefCd = null;
	/* Column Info */
	private String orgSrcInfoCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String orgPrcProgStsCd = null;
	/* Column Info */
	private String prcProgStsCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String secondOrder = null;
	/* Column Info */
	private String orgTpCd = null;
	/* Column Info */
	private String destSrcInfoCd = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String routPntSeq = null;
	/* Column Info */
	private String routPntLocTpCd = null;
	/* Column Info */
	private String acptOfcCd = null;
	/* Column Info */
	private String acptDt = null;
	/* Column Info */
	private String routPntLocDefNm = null;
	/* Column Info */
	private String acptUsrNm = null;
	/* Column Info */
	private String srcInfoCd = null;
	/* Column Info */
	private String orgDestTpCd = null;
	/* Column Info */
	private String destPrcProgStsCd = null;
	/* Column Info */
	private String n1stCmncAmdtSeq = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String amendCnt = null;
	/* Column Info */
	private String destTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltRoutPntLocListVO() {}

	public RsltRoutPntLocListVO(String ibflag, String pagerows, String acptDt, String acptOfcCd, String amdtSeq, String routPntLocDefNm, String firstOrder, String acptUsrNm, String svcScpCd, String srcInfoCd, String orgDestTpCd, String routPntLocDefCd, String prcProgStsCd, String effDt, String secondOrder, String n1stCmncAmdtSeq, String propNo, String expDt, String amendCnt, String routPntSeq, String routPntLocTpCd, String orgTpCd, String destTpCd, String orgSrcInfoCd, String destSrcInfoCd, String orgPrcProgStsCd, String destPrcProgStsCd) {
		this.amdtSeq = amdtSeq;
		this.svcScpCd = svcScpCd;
		this.firstOrder = firstOrder;
		this.routPntLocDefCd = routPntLocDefCd;
		this.orgSrcInfoCd = orgSrcInfoCd;
		this.pagerows = pagerows;
		this.orgPrcProgStsCd = orgPrcProgStsCd;
		this.prcProgStsCd = prcProgStsCd;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.secondOrder = secondOrder;
		this.orgTpCd = orgTpCd;
		this.destSrcInfoCd = destSrcInfoCd;
		this.expDt = expDt;
		this.routPntSeq = routPntSeq;
		this.routPntLocTpCd = routPntLocTpCd;
		this.acptOfcCd = acptOfcCd;
		this.acptDt = acptDt;
		this.routPntLocDefNm = routPntLocDefNm;
		this.acptUsrNm = acptUsrNm;
		this.srcInfoCd = srcInfoCd;
		this.orgDestTpCd = orgDestTpCd;
		this.destPrcProgStsCd = destPrcProgStsCd;
		this.n1stCmncAmdtSeq = n1stCmncAmdtSeq;
		this.propNo = propNo;
		this.amendCnt = amendCnt;
		this.destTpCd = destTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("first_order", getFirstOrder());
		this.hashColumns.put("rout_pnt_loc_def_cd", getRoutPntLocDefCd());
		this.hashColumns.put("org_src_info_cd", getOrgSrcInfoCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("org_prc_prog_sts_cd", getOrgPrcProgStsCd());
		this.hashColumns.put("prc_prog_sts_cd", getPrcProgStsCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("second_order", getSecondOrder());
		this.hashColumns.put("org_tp_cd", getOrgTpCd());
		this.hashColumns.put("dest_src_info_cd", getDestSrcInfoCd());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("rout_pnt_seq", getRoutPntSeq());
		this.hashColumns.put("rout_pnt_loc_tp_cd", getRoutPntLocTpCd());
		this.hashColumns.put("acpt_ofc_cd", getAcptOfcCd());
		this.hashColumns.put("acpt_dt", getAcptDt());
		this.hashColumns.put("rout_pnt_loc_def_nm", getRoutPntLocDefNm());
		this.hashColumns.put("acpt_usr_nm", getAcptUsrNm());
		this.hashColumns.put("src_info_cd", getSrcInfoCd());
		this.hashColumns.put("org_dest_tp_cd", getOrgDestTpCd());
		this.hashColumns.put("dest_prc_prog_sts_cd", getDestPrcProgStsCd());
		this.hashColumns.put("n1st_cmnc_amdt_seq", getN1stCmncAmdtSeq());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("amend_cnt", getAmendCnt());
		this.hashColumns.put("dest_tp_cd", getDestTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("first_order", "firstOrder");
		this.hashFields.put("rout_pnt_loc_def_cd", "routPntLocDefCd");
		this.hashFields.put("org_src_info_cd", "orgSrcInfoCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("org_prc_prog_sts_cd", "orgPrcProgStsCd");
		this.hashFields.put("prc_prog_sts_cd", "prcProgStsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("second_order", "secondOrder");
		this.hashFields.put("org_tp_cd", "orgTpCd");
		this.hashFields.put("dest_src_info_cd", "destSrcInfoCd");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("rout_pnt_seq", "routPntSeq");
		this.hashFields.put("rout_pnt_loc_tp_cd", "routPntLocTpCd");
		this.hashFields.put("acpt_ofc_cd", "acptOfcCd");
		this.hashFields.put("acpt_dt", "acptDt");
		this.hashFields.put("rout_pnt_loc_def_nm", "routPntLocDefNm");
		this.hashFields.put("acpt_usr_nm", "acptUsrNm");
		this.hashFields.put("src_info_cd", "srcInfoCd");
		this.hashFields.put("org_dest_tp_cd", "orgDestTpCd");
		this.hashFields.put("dest_prc_prog_sts_cd", "destPrcProgStsCd");
		this.hashFields.put("n1st_cmnc_amdt_seq", "n1stCmncAmdtSeq");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("amend_cnt", "amendCnt");
		this.hashFields.put("dest_tp_cd", "destTpCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return firstOrder
	 */
	public String getFirstOrder() {
		return this.firstOrder;
	}
	
	/**
	 * Column Info
	 * @return routPntLocDefCd
	 */
	public String getRoutPntLocDefCd() {
		return this.routPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @return orgSrcInfoCd
	 */
	public String getOrgSrcInfoCd() {
		return this.orgSrcInfoCd;
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
	 * @return orgPrcProgStsCd
	 */
	public String getOrgPrcProgStsCd() {
		return this.orgPrcProgStsCd;
	}
	
	/**
	 * Column Info
	 * @return prcProgStsCd
	 */
	public String getPrcProgStsCd() {
		return this.prcProgStsCd;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return secondOrder
	 */
	public String getSecondOrder() {
		return this.secondOrder;
	}
	
	/**
	 * Column Info
	 * @return orgTpCd
	 */
	public String getOrgTpCd() {
		return this.orgTpCd;
	}
	
	/**
	 * Column Info
	 * @return destSrcInfoCd
	 */
	public String getDestSrcInfoCd() {
		return this.destSrcInfoCd;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return routPntSeq
	 */
	public String getRoutPntSeq() {
		return this.routPntSeq;
	}
	
	/**
	 * Column Info
	 * @return routPntLocTpCd
	 */
	public String getRoutPntLocTpCd() {
		return this.routPntLocTpCd;
	}
	
	/**
	 * Column Info
	 * @return acptOfcCd
	 */
	public String getAcptOfcCd() {
		return this.acptOfcCd;
	}
	
	/**
	 * Column Info
	 * @return acptDt
	 */
	public String getAcptDt() {
		return this.acptDt;
	}
	
	/**
	 * Column Info
	 * @return routPntLocDefNm
	 */
	public String getRoutPntLocDefNm() {
		return this.routPntLocDefNm;
	}
	
	/**
	 * Column Info
	 * @return acptUsrNm
	 */
	public String getAcptUsrNm() {
		return this.acptUsrNm;
	}
	
	/**
	 * Column Info
	 * @return srcInfoCd
	 */
	public String getSrcInfoCd() {
		return this.srcInfoCd;
	}
	
	/**
	 * Column Info
	 * @return orgDestTpCd
	 */
	public String getOrgDestTpCd() {
		return this.orgDestTpCd;
	}
	
	/**
	 * Column Info
	 * @return destPrcProgStsCd
	 */
	public String getDestPrcProgStsCd() {
		return this.destPrcProgStsCd;
	}
	
	/**
	 * Column Info
	 * @return n1stCmncAmdtSeq
	 */
	public String getN1stCmncAmdtSeq() {
		return this.n1stCmncAmdtSeq;
	}
	
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return amendCnt
	 */
	public String getAmendCnt() {
		return this.amendCnt;
	}
	
	/**
	 * Column Info
	 * @return destTpCd
	 */
	public String getDestTpCd() {
		return this.destTpCd;
	}
	

	/**
	 * Column Info
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param firstOrder
	 */
	public void setFirstOrder(String firstOrder) {
		this.firstOrder = firstOrder;
	}
	
	/**
	 * Column Info
	 * @param routPntLocDefCd
	 */
	public void setRoutPntLocDefCd(String routPntLocDefCd) {
		this.routPntLocDefCd = routPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @param orgSrcInfoCd
	 */
	public void setOrgSrcInfoCd(String orgSrcInfoCd) {
		this.orgSrcInfoCd = orgSrcInfoCd;
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
	 * @param orgPrcProgStsCd
	 */
	public void setOrgPrcProgStsCd(String orgPrcProgStsCd) {
		this.orgPrcProgStsCd = orgPrcProgStsCd;
	}
	
	/**
	 * Column Info
	 * @param prcProgStsCd
	 */
	public void setPrcProgStsCd(String prcProgStsCd) {
		this.prcProgStsCd = prcProgStsCd;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param secondOrder
	 */
	public void setSecondOrder(String secondOrder) {
		this.secondOrder = secondOrder;
	}
	
	/**
	 * Column Info
	 * @param orgTpCd
	 */
	public void setOrgTpCd(String orgTpCd) {
		this.orgTpCd = orgTpCd;
	}
	
	/**
	 * Column Info
	 * @param destSrcInfoCd
	 */
	public void setDestSrcInfoCd(String destSrcInfoCd) {
		this.destSrcInfoCd = destSrcInfoCd;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param routPntSeq
	 */
	public void setRoutPntSeq(String routPntSeq) {
		this.routPntSeq = routPntSeq;
	}
	
	/**
	 * Column Info
	 * @param routPntLocTpCd
	 */
	public void setRoutPntLocTpCd(String routPntLocTpCd) {
		this.routPntLocTpCd = routPntLocTpCd;
	}
	
	/**
	 * Column Info
	 * @param acptOfcCd
	 */
	public void setAcptOfcCd(String acptOfcCd) {
		this.acptOfcCd = acptOfcCd;
	}
	
	/**
	 * Column Info
	 * @param acptDt
	 */
	public void setAcptDt(String acptDt) {
		this.acptDt = acptDt;
	}
	
	/**
	 * Column Info
	 * @param routPntLocDefNm
	 */
	public void setRoutPntLocDefNm(String routPntLocDefNm) {
		this.routPntLocDefNm = routPntLocDefNm;
	}
	
	/**
	 * Column Info
	 * @param acptUsrNm
	 */
	public void setAcptUsrNm(String acptUsrNm) {
		this.acptUsrNm = acptUsrNm;
	}
	
	/**
	 * Column Info
	 * @param srcInfoCd
	 */
	public void setSrcInfoCd(String srcInfoCd) {
		this.srcInfoCd = srcInfoCd;
	}
	
	/**
	 * Column Info
	 * @param orgDestTpCd
	 */
	public void setOrgDestTpCd(String orgDestTpCd) {
		this.orgDestTpCd = orgDestTpCd;
	}
	
	/**
	 * Column Info
	 * @param destPrcProgStsCd
	 */
	public void setDestPrcProgStsCd(String destPrcProgStsCd) {
		this.destPrcProgStsCd = destPrcProgStsCd;
	}
	
	/**
	 * Column Info
	 * @param n1stCmncAmdtSeq
	 */
	public void setN1stCmncAmdtSeq(String n1stCmncAmdtSeq) {
		this.n1stCmncAmdtSeq = n1stCmncAmdtSeq;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param amendCnt
	 */
	public void setAmendCnt(String amendCnt) {
		this.amendCnt = amendCnt;
	}
	
	/**
	 * Column Info
	 * @param destTpCd
	 */
	public void setDestTpCd(String destTpCd) {
		this.destTpCd = destTpCd;
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
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setFirstOrder(JSPUtil.getParameter(request, prefix + "first_order", ""));
		setRoutPntLocDefCd(JSPUtil.getParameter(request, prefix + "rout_pnt_loc_def_cd", ""));
		setOrgSrcInfoCd(JSPUtil.getParameter(request, prefix + "org_src_info_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOrgPrcProgStsCd(JSPUtil.getParameter(request, prefix + "org_prc_prog_sts_cd", ""));
		setPrcProgStsCd(JSPUtil.getParameter(request, prefix + "prc_prog_sts_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setSecondOrder(JSPUtil.getParameter(request, prefix + "second_order", ""));
		setOrgTpCd(JSPUtil.getParameter(request, prefix + "org_tp_cd", ""));
		setDestSrcInfoCd(JSPUtil.getParameter(request, prefix + "dest_src_info_cd", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setRoutPntSeq(JSPUtil.getParameter(request, prefix + "rout_pnt_seq", ""));
		setRoutPntLocTpCd(JSPUtil.getParameter(request, prefix + "rout_pnt_loc_tp_cd", ""));
		setAcptOfcCd(JSPUtil.getParameter(request, prefix + "acpt_ofc_cd", ""));
		setAcptDt(JSPUtil.getParameter(request, prefix + "acpt_dt", ""));
		setRoutPntLocDefNm(JSPUtil.getParameter(request, prefix + "rout_pnt_loc_def_nm", ""));
		setAcptUsrNm(JSPUtil.getParameter(request, prefix + "acpt_usr_nm", ""));
		setSrcInfoCd(JSPUtil.getParameter(request, prefix + "src_info_cd", ""));
		setOrgDestTpCd(JSPUtil.getParameter(request, prefix + "org_dest_tp_cd", ""));
		setDestPrcProgStsCd(JSPUtil.getParameter(request, prefix + "dest_prc_prog_sts_cd", ""));
		setN1stCmncAmdtSeq(JSPUtil.getParameter(request, prefix + "n1st_cmnc_amdt_seq", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
		setAmendCnt(JSPUtil.getParameter(request, prefix + "amend_cnt", ""));
		setDestTpCd(JSPUtil.getParameter(request, prefix + "dest_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltRoutPntLocListVO[]
	 */
	public RsltRoutPntLocListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltRoutPntLocListVO[]
	 */
	public RsltRoutPntLocListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltRoutPntLocListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] firstOrder = (JSPUtil.getParameter(request, prefix	+ "first_order", length));
			String[] routPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "rout_pnt_loc_def_cd", length));
			String[] orgSrcInfoCd = (JSPUtil.getParameter(request, prefix	+ "org_src_info_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] orgPrcProgStsCd = (JSPUtil.getParameter(request, prefix	+ "org_prc_prog_sts_cd", length));
			String[] prcProgStsCd = (JSPUtil.getParameter(request, prefix	+ "prc_prog_sts_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] secondOrder = (JSPUtil.getParameter(request, prefix	+ "second_order", length));
			String[] orgTpCd = (JSPUtil.getParameter(request, prefix	+ "org_tp_cd", length));
			String[] destSrcInfoCd = (JSPUtil.getParameter(request, prefix	+ "dest_src_info_cd", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] routPntSeq = (JSPUtil.getParameter(request, prefix	+ "rout_pnt_seq", length));
			String[] routPntLocTpCd = (JSPUtil.getParameter(request, prefix	+ "rout_pnt_loc_tp_cd", length));
			String[] acptOfcCd = (JSPUtil.getParameter(request, prefix	+ "acpt_ofc_cd", length));
			String[] acptDt = (JSPUtil.getParameter(request, prefix	+ "acpt_dt", length));
			String[] routPntLocDefNm = (JSPUtil.getParameter(request, prefix	+ "rout_pnt_loc_def_nm", length));
			String[] acptUsrNm = (JSPUtil.getParameter(request, prefix	+ "acpt_usr_nm", length));
			String[] srcInfoCd = (JSPUtil.getParameter(request, prefix	+ "src_info_cd", length));
			String[] orgDestTpCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_tp_cd", length));
			String[] destPrcProgStsCd = (JSPUtil.getParameter(request, prefix	+ "dest_prc_prog_sts_cd", length));
			String[] n1stCmncAmdtSeq = (JSPUtil.getParameter(request, prefix	+ "n1st_cmnc_amdt_seq", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] amendCnt = (JSPUtil.getParameter(request, prefix	+ "amend_cnt", length));
			String[] destTpCd = (JSPUtil.getParameter(request, prefix	+ "dest_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltRoutPntLocListVO();
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (firstOrder[i] != null)
					model.setFirstOrder(firstOrder[i]);
				if (routPntLocDefCd[i] != null)
					model.setRoutPntLocDefCd(routPntLocDefCd[i]);
				if (orgSrcInfoCd[i] != null)
					model.setOrgSrcInfoCd(orgSrcInfoCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (orgPrcProgStsCd[i] != null)
					model.setOrgPrcProgStsCd(orgPrcProgStsCd[i]);
				if (prcProgStsCd[i] != null)
					model.setPrcProgStsCd(prcProgStsCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (secondOrder[i] != null)
					model.setSecondOrder(secondOrder[i]);
				if (orgTpCd[i] != null)
					model.setOrgTpCd(orgTpCd[i]);
				if (destSrcInfoCd[i] != null)
					model.setDestSrcInfoCd(destSrcInfoCd[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (routPntSeq[i] != null)
					model.setRoutPntSeq(routPntSeq[i]);
				if (routPntLocTpCd[i] != null)
					model.setRoutPntLocTpCd(routPntLocTpCd[i]);
				if (acptOfcCd[i] != null)
					model.setAcptOfcCd(acptOfcCd[i]);
				if (acptDt[i] != null)
					model.setAcptDt(acptDt[i]);
				if (routPntLocDefNm[i] != null)
					model.setRoutPntLocDefNm(routPntLocDefNm[i]);
				if (acptUsrNm[i] != null)
					model.setAcptUsrNm(acptUsrNm[i]);
				if (srcInfoCd[i] != null)
					model.setSrcInfoCd(srcInfoCd[i]);
				if (orgDestTpCd[i] != null)
					model.setOrgDestTpCd(orgDestTpCd[i]);
				if (destPrcProgStsCd[i] != null)
					model.setDestPrcProgStsCd(destPrcProgStsCd[i]);
				if (n1stCmncAmdtSeq[i] != null)
					model.setN1stCmncAmdtSeq(n1stCmncAmdtSeq[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (amendCnt[i] != null)
					model.setAmendCnt(amendCnt[i]);
				if (destTpCd[i] != null)
					model.setDestTpCd(destTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltRoutPntLocListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltRoutPntLocListVO[]
	 */
	public RsltRoutPntLocListVO[] getRsltRoutPntLocListVOs(){
		RsltRoutPntLocListVO[] vos = (RsltRoutPntLocListVO[])models.toArray(new RsltRoutPntLocListVO[models.size()]);
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
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.firstOrder = this.firstOrder .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routPntLocDefCd = this.routPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSrcInfoCd = this.orgSrcInfoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgPrcProgStsCd = this.orgPrcProgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcProgStsCd = this.prcProgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.secondOrder = this.secondOrder .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgTpCd = this.orgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destSrcInfoCd = this.destSrcInfoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routPntSeq = this.routPntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routPntLocTpCd = this.routPntLocTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acptOfcCd = this.acptOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acptDt = this.acptDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routPntLocDefNm = this.routPntLocDefNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acptUsrNm = this.acptUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcInfoCd = this.srcInfoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestTpCd = this.orgDestTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destPrcProgStsCd = this.destPrcProgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stCmncAmdtSeq = this.n1stCmncAmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amendCnt = this.amendCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destTpCd = this.destTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
