/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RsltSearchMOFListVO.java
*@FileTitle : RsltSearchMOFListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.06
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.06  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.screport.screport.vo;

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

public class RsltSearchMOFListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltSearchMOFListVO> models = new ArrayList<RsltSearchMOFListVO>();
	
	/* Column Info */
	private String othAmt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String ctrtEffDt = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String sizeCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ctrtNo = null;
	/* Column Info */
	private String mofOrgLocCd = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String inOut = null;
	/* Column Info */
	private String bafAmt = null;
	/* Column Info */
	private String genSpclRtTpCd = null;
	/* Column Info */
	private String oftAmt = null;
	/* Column Info */
	private String dthAmt = null;
	/* Column Info */
	private String dthCurr = null;
	/* Column Info */
	private String ctrtExpDt = null;
	/* Column Info */
	private String cmdtHdrSeq = null;
	/* Column Info */
	private String bqSeq = null;
	/* Column Info */
	private String mofLaneCd = null;
	/* Column Info */
	private String qty = null;
	/* Column Info */
	private String routScgTp = null;
	/* Column Info */
	private String rtSeq = null;
	/* Column Info */
	private String bafCurr = null;
	/* Column Info */
	private String routSeq = null;
	/* Column Info */
	private String bletDpSeq = null;
	/* Column Info */
	private String propOfcCd = null;
	/* Column Info */
	private String cafAmt = null;
	/* Column Info */
	private String propAproOfcCd = null;
	/* Column Info */
	private String othCurr = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String ctrtType = null;
	/* Column Info */
	private String mofDestLocCd = null;
	/* Column Info */
	private String cafCurr = null;
	/* Column Info */
	private String typeCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RsltSearchMOFListVO() {}

	public RsltSearchMOFListVO(String ibflag, String pagerows, String ctrtType, String ctrtNo, String custNm, String bqSeq, String propNo, String amdtSeq, String svcScpCd, String genSpclRtTpCd, String cmdtHdrSeq, String bletDpSeq, String routSeq, String rtSeq, String mofLaneCd, String inOut, String mofOrgLocCd, String mofDestLocCd, String typeCd, String sizeCd, String qty, String currCd, String oftAmt, String bafCurr, String bafAmt, String cafCurr, String cafAmt, String othCurr, String othAmt, String dthCurr, String dthAmt, String propOfcCd, String propAproOfcCd, String effDt, String ctrtEffDt, String ctrtExpDt, String routScgTp) {
		this.othAmt = othAmt;
		this.currCd = currCd;
		this.ctrtEffDt = ctrtEffDt;
		this.custNm = custNm;
		this.amdtSeq = amdtSeq;
		this.svcScpCd = svcScpCd;
		this.sizeCd = sizeCd;
		this.pagerows = pagerows;
		this.ctrtNo = ctrtNo;
		this.mofOrgLocCd = mofOrgLocCd;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.inOut = inOut;
		this.bafAmt = bafAmt;
		this.genSpclRtTpCd = genSpclRtTpCd;
		this.oftAmt = oftAmt;
		this.dthAmt = dthAmt;
		this.dthCurr = dthCurr;
		this.ctrtExpDt = ctrtExpDt;
		this.cmdtHdrSeq = cmdtHdrSeq;
		this.bqSeq = bqSeq;
		this.mofLaneCd = mofLaneCd;
		this.qty = qty;
		this.routScgTp = routScgTp;
		this.rtSeq = rtSeq;
		this.bafCurr = bafCurr;
		this.routSeq = routSeq;
		this.bletDpSeq = bletDpSeq;
		this.propOfcCd = propOfcCd;
		this.cafAmt = cafAmt;
		this.propAproOfcCd = propAproOfcCd;
		this.othCurr = othCurr;
		this.propNo = propNo;
		this.ctrtType = ctrtType;
		this.mofDestLocCd = mofDestLocCd;
		this.cafCurr = cafCurr;
		this.typeCd = typeCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("oth_amt", getOthAmt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("ctrt_eff_dt", getCtrtEffDt());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("size_cd", getSizeCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ctrt_no", getCtrtNo());
		this.hashColumns.put("mof_org_loc_cd", getMofOrgLocCd());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("in_out", getInOut());
		this.hashColumns.put("baf_amt", getBafAmt());
		this.hashColumns.put("gen_spcl_rt_tp_cd", getGenSpclRtTpCd());
		this.hashColumns.put("oft_amt", getOftAmt());
		this.hashColumns.put("dth_amt", getDthAmt());
		this.hashColumns.put("dth_curr", getDthCurr());
		this.hashColumns.put("ctrt_exp_dt", getCtrtExpDt());
		this.hashColumns.put("cmdt_hdr_seq", getCmdtHdrSeq());
		this.hashColumns.put("bq_seq", getBqSeq());
		this.hashColumns.put("mof_lane_cd", getMofLaneCd());
		this.hashColumns.put("qty", getQty());
		this.hashColumns.put("rout_scg_tp", getRoutScgTp());
		this.hashColumns.put("rt_seq", getRtSeq());
		this.hashColumns.put("baf_curr", getBafCurr());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("blet_dp_seq", getBletDpSeq());
		this.hashColumns.put("prop_ofc_cd", getPropOfcCd());
		this.hashColumns.put("caf_amt", getCafAmt());
		this.hashColumns.put("prop_apro_ofc_cd", getPropAproOfcCd());
		this.hashColumns.put("oth_curr", getOthCurr());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("ctrt_type", getCtrtType());
		this.hashColumns.put("mof_dest_loc_cd", getMofDestLocCd());
		this.hashColumns.put("caf_curr", getCafCurr());
		this.hashColumns.put("type_cd", getTypeCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("oth_amt", "othAmt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("ctrt_eff_dt", "ctrtEffDt");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("size_cd", "sizeCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ctrt_no", "ctrtNo");
		this.hashFields.put("mof_org_loc_cd", "mofOrgLocCd");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("in_out", "inOut");
		this.hashFields.put("baf_amt", "bafAmt");
		this.hashFields.put("gen_spcl_rt_tp_cd", "genSpclRtTpCd");
		this.hashFields.put("oft_amt", "oftAmt");
		this.hashFields.put("dth_amt", "dthAmt");
		this.hashFields.put("dth_curr", "dthCurr");
		this.hashFields.put("ctrt_exp_dt", "ctrtExpDt");
		this.hashFields.put("cmdt_hdr_seq", "cmdtHdrSeq");
		this.hashFields.put("bq_seq", "bqSeq");
		this.hashFields.put("mof_lane_cd", "mofLaneCd");
		this.hashFields.put("qty", "qty");
		this.hashFields.put("rout_scg_tp", "routScgTp");
		this.hashFields.put("rt_seq", "rtSeq");
		this.hashFields.put("baf_curr", "bafCurr");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("blet_dp_seq", "bletDpSeq");
		this.hashFields.put("prop_ofc_cd", "propOfcCd");
		this.hashFields.put("caf_amt", "cafAmt");
		this.hashFields.put("prop_apro_ofc_cd", "propAproOfcCd");
		this.hashFields.put("oth_curr", "othCurr");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("ctrt_type", "ctrtType");
		this.hashFields.put("mof_dest_loc_cd", "mofDestLocCd");
		this.hashFields.put("caf_curr", "cafCurr");
		this.hashFields.put("type_cd", "typeCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return othAmt
	 */
	public String getOthAmt() {
		return this.othAmt;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtEffDt
	 */
	public String getCtrtEffDt() {
		return this.ctrtEffDt;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
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
	 * @return sizeCd
	 */
	public String getSizeCd() {
		return this.sizeCd;
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
	 * @return ctrtNo
	 */
	public String getCtrtNo() {
		return this.ctrtNo;
	}
	
	/**
	 * Column Info
	 * @return mofOrgLocCd
	 */
	public String getMofOrgLocCd() {
		return this.mofOrgLocCd;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return inOut
	 */
	public String getInOut() {
		return this.inOut;
	}
	
	/**
	 * Column Info
	 * @return bafAmt
	 */
	public String getBafAmt() {
		return this.bafAmt;
	}
	
	/**
	 * Column Info
	 * @return genSpclRtTpCd
	 */
	public String getGenSpclRtTpCd() {
		return this.genSpclRtTpCd;
	}
	
	/**
	 * Column Info
	 * @return oftAmt
	 */
	public String getOftAmt() {
		return this.oftAmt;
	}
	
	/**
	 * Column Info
	 * @return dthAmt
	 */
	public String getDthAmt() {
		return this.dthAmt;
	}
	
	/**
	 * Column Info
	 * @return dthCurr
	 */
	public String getDthCurr() {
		return this.dthCurr;
	}
	
	/**
	 * Column Info
	 * @return ctrtExpDt
	 */
	public String getCtrtExpDt() {
		return this.ctrtExpDt;
	}
	
	/**
	 * Column Info
	 * @return cmdtHdrSeq
	 */
	public String getCmdtHdrSeq() {
		return this.cmdtHdrSeq;
	}
	
	/**
	 * Column Info
	 * @return bqSeq
	 */
	public String getBqSeq() {
		return this.bqSeq;
	}
	
	/**
	 * Column Info
	 * @return mofLaneCd
	 */
	public String getMofLaneCd() {
		return this.mofLaneCd;
	}
	
	/**
	 * Column Info
	 * @return qty
	 */
	public String getQty() {
		return this.qty;
	}
	
	/**
	 * Column Info
	 * @return routScgTp
	 */
	public String getRoutScgTp() {
		return this.routScgTp;
	}
	
	/**
	 * Column Info
	 * @return rtSeq
	 */
	public String getRtSeq() {
		return this.rtSeq;
	}
	
	/**
	 * Column Info
	 * @return bafCurr
	 */
	public String getBafCurr() {
		return this.bafCurr;
	}
	
	/**
	 * Column Info
	 * @return routSeq
	 */
	public String getRoutSeq() {
		return this.routSeq;
	}
	
	/**
	 * Column Info
	 * @return bletDpSeq
	 */
	public String getBletDpSeq() {
		return this.bletDpSeq;
	}
	
	/**
	 * Column Info
	 * @return propOfcCd
	 */
	public String getPropOfcCd() {
		return this.propOfcCd;
	}
	
	/**
	 * Column Info
	 * @return cafAmt
	 */
	public String getCafAmt() {
		return this.cafAmt;
	}
	
	/**
	 * Column Info
	 * @return propAproOfcCd
	 */
	public String getPropAproOfcCd() {
		return this.propAproOfcCd;
	}
	
	/**
	 * Column Info
	 * @return othCurr
	 */
	public String getOthCurr() {
		return this.othCurr;
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
	 * @return ctrtType
	 */
	public String getCtrtType() {
		return this.ctrtType;
	}
	
	/**
	 * Column Info
	 * @return mofDestLocCd
	 */
	public String getMofDestLocCd() {
		return this.mofDestLocCd;
	}
	
	/**
	 * Column Info
	 * @return cafCurr
	 */
	public String getCafCurr() {
		return this.cafCurr;
	}
	
	/**
	 * Column Info
	 * @return typeCd
	 */
	public String getTypeCd() {
		return this.typeCd;
	}
	

	/**
	 * Column Info
	 * @param othAmt
	 */
	public void setOthAmt(String othAmt) {
		this.othAmt = othAmt;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtEffDt
	 */
	public void setCtrtEffDt(String ctrtEffDt) {
		this.ctrtEffDt = ctrtEffDt;
	}
	
	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
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
	 * @param sizeCd
	 */
	public void setSizeCd(String sizeCd) {
		this.sizeCd = sizeCd;
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
	 * @param ctrtNo
	 */
	public void setCtrtNo(String ctrtNo) {
		this.ctrtNo = ctrtNo;
	}
	
	/**
	 * Column Info
	 * @param mofOrgLocCd
	 */
	public void setMofOrgLocCd(String mofOrgLocCd) {
		this.mofOrgLocCd = mofOrgLocCd;
	}
	
	/**
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param inOut
	 */
	public void setInOut(String inOut) {
		this.inOut = inOut;
	}
	
	/**
	 * Column Info
	 * @param bafAmt
	 */
	public void setBafAmt(String bafAmt) {
		this.bafAmt = bafAmt;
	}
	
	/**
	 * Column Info
	 * @param genSpclRtTpCd
	 */
	public void setGenSpclRtTpCd(String genSpclRtTpCd) {
		this.genSpclRtTpCd = genSpclRtTpCd;
	}
	
	/**
	 * Column Info
	 * @param oftAmt
	 */
	public void setOftAmt(String oftAmt) {
		this.oftAmt = oftAmt;
	}
	
	/**
	 * Column Info
	 * @param dthAmt
	 */
	public void setDthAmt(String dthAmt) {
		this.dthAmt = dthAmt;
	}
	
	/**
	 * Column Info
	 * @param dthCurr
	 */
	public void setDthCurr(String dthCurr) {
		this.dthCurr = dthCurr;
	}
	
	/**
	 * Column Info
	 * @param ctrtExpDt
	 */
	public void setCtrtExpDt(String ctrtExpDt) {
		this.ctrtExpDt = ctrtExpDt;
	}
	
	/**
	 * Column Info
	 * @param cmdtHdrSeq
	 */
	public void setCmdtHdrSeq(String cmdtHdrSeq) {
		this.cmdtHdrSeq = cmdtHdrSeq;
	}
	
	/**
	 * Column Info
	 * @param bqSeq
	 */
	public void setBqSeq(String bqSeq) {
		this.bqSeq = bqSeq;
	}
	
	/**
	 * Column Info
	 * @param mofLaneCd
	 */
	public void setMofLaneCd(String mofLaneCd) {
		this.mofLaneCd = mofLaneCd;
	}
	
	/**
	 * Column Info
	 * @param qty
	 */
	public void setQty(String qty) {
		this.qty = qty;
	}
	
	/**
	 * Column Info
	 * @param routScgTp
	 */
	public void setRoutScgTp(String routScgTp) {
		this.routScgTp = routScgTp;
	}
	
	/**
	 * Column Info
	 * @param rtSeq
	 */
	public void setRtSeq(String rtSeq) {
		this.rtSeq = rtSeq;
	}
	
	/**
	 * Column Info
	 * @param bafCurr
	 */
	public void setBafCurr(String bafCurr) {
		this.bafCurr = bafCurr;
	}
	
	/**
	 * Column Info
	 * @param routSeq
	 */
	public void setRoutSeq(String routSeq) {
		this.routSeq = routSeq;
	}
	
	/**
	 * Column Info
	 * @param bletDpSeq
	 */
	public void setBletDpSeq(String bletDpSeq) {
		this.bletDpSeq = bletDpSeq;
	}
	
	/**
	 * Column Info
	 * @param propOfcCd
	 */
	public void setPropOfcCd(String propOfcCd) {
		this.propOfcCd = propOfcCd;
	}
	
	/**
	 * Column Info
	 * @param cafAmt
	 */
	public void setCafAmt(String cafAmt) {
		this.cafAmt = cafAmt;
	}
	
	/**
	 * Column Info
	 * @param propAproOfcCd
	 */
	public void setPropAproOfcCd(String propAproOfcCd) {
		this.propAproOfcCd = propAproOfcCd;
	}
	
	/**
	 * Column Info
	 * @param othCurr
	 */
	public void setOthCurr(String othCurr) {
		this.othCurr = othCurr;
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
	 * @param ctrtType
	 */
	public void setCtrtType(String ctrtType) {
		this.ctrtType = ctrtType;
	}
	
	/**
	 * Column Info
	 * @param mofDestLocCd
	 */
	public void setMofDestLocCd(String mofDestLocCd) {
		this.mofDestLocCd = mofDestLocCd;
	}
	
	/**
	 * Column Info
	 * @param cafCurr
	 */
	public void setCafCurr(String cafCurr) {
		this.cafCurr = cafCurr;
	}
	
	/**
	 * Column Info
	 * @param typeCd
	 */
	public void setTypeCd(String typeCd) {
		this.typeCd = typeCd;
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
		setOthAmt(JSPUtil.getParameter(request, prefix + "oth_amt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setCtrtEffDt(JSPUtil.getParameter(request, prefix + "ctrt_eff_dt", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setSizeCd(JSPUtil.getParameter(request, prefix + "size_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCtrtNo(JSPUtil.getParameter(request, prefix + "ctrt_no", ""));
		setMofOrgLocCd(JSPUtil.getParameter(request, prefix + "mof_org_loc_cd", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setInOut(JSPUtil.getParameter(request, prefix + "in_out", ""));
		setBafAmt(JSPUtil.getParameter(request, prefix + "baf_amt", ""));
		setGenSpclRtTpCd(JSPUtil.getParameter(request, prefix + "gen_spcl_rt_tp_cd", ""));
		setOftAmt(JSPUtil.getParameter(request, prefix + "oft_amt", ""));
		setDthAmt(JSPUtil.getParameter(request, prefix + "dth_amt", ""));
		setDthCurr(JSPUtil.getParameter(request, prefix + "dth_curr", ""));
		setCtrtExpDt(JSPUtil.getParameter(request, prefix + "ctrt_exp_dt", ""));
		setCmdtHdrSeq(JSPUtil.getParameter(request, prefix + "cmdt_hdr_seq", ""));
		setBqSeq(JSPUtil.getParameter(request, prefix + "bq_seq", ""));
		setMofLaneCd(JSPUtil.getParameter(request, prefix + "mof_lane_cd", ""));
		setQty(JSPUtil.getParameter(request, prefix + "qty", ""));
		setRoutScgTp(JSPUtil.getParameter(request, prefix + "rout_scg_tp", ""));
		setRtSeq(JSPUtil.getParameter(request, prefix + "rt_seq", ""));
		setBafCurr(JSPUtil.getParameter(request, prefix + "baf_curr", ""));
		setRoutSeq(JSPUtil.getParameter(request, prefix + "rout_seq", ""));
		setBletDpSeq(JSPUtil.getParameter(request, prefix + "blet_dp_seq", ""));
		setPropOfcCd(JSPUtil.getParameter(request, prefix + "prop_ofc_cd", ""));
		setCafAmt(JSPUtil.getParameter(request, prefix + "caf_amt", ""));
		setPropAproOfcCd(JSPUtil.getParameter(request, prefix + "prop_apro_ofc_cd", ""));
		setOthCurr(JSPUtil.getParameter(request, prefix + "oth_curr", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
		setCtrtType(JSPUtil.getParameter(request, prefix + "ctrt_type", ""));
		setMofDestLocCd(JSPUtil.getParameter(request, prefix + "mof_dest_loc_cd", ""));
		setCafCurr(JSPUtil.getParameter(request, prefix + "caf_curr", ""));
		setTypeCd(JSPUtil.getParameter(request, prefix + "type_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltSearchMOFListVO[]
	 */
	public RsltSearchMOFListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltSearchMOFListVO[]
	 */
	public RsltSearchMOFListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltSearchMOFListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] othAmt = (JSPUtil.getParameter(request, prefix	+ "oth_amt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] ctrtEffDt = (JSPUtil.getParameter(request, prefix	+ "ctrt_eff_dt", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] sizeCd = (JSPUtil.getParameter(request, prefix	+ "size_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ctrtNo = (JSPUtil.getParameter(request, prefix	+ "ctrt_no", length));
			String[] mofOrgLocCd = (JSPUtil.getParameter(request, prefix	+ "mof_org_loc_cd", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] inOut = (JSPUtil.getParameter(request, prefix	+ "in_out", length));
			String[] bafAmt = (JSPUtil.getParameter(request, prefix	+ "baf_amt", length));
			String[] genSpclRtTpCd = (JSPUtil.getParameter(request, prefix	+ "gen_spcl_rt_tp_cd", length));
			String[] oftAmt = (JSPUtil.getParameter(request, prefix	+ "oft_amt", length));
			String[] dthAmt = (JSPUtil.getParameter(request, prefix	+ "dth_amt", length));
			String[] dthCurr = (JSPUtil.getParameter(request, prefix	+ "dth_curr", length));
			String[] ctrtExpDt = (JSPUtil.getParameter(request, prefix	+ "ctrt_exp_dt", length));
			String[] cmdtHdrSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_hdr_seq", length));
			String[] bqSeq = (JSPUtil.getParameter(request, prefix	+ "bq_seq", length));
			String[] mofLaneCd = (JSPUtil.getParameter(request, prefix	+ "mof_lane_cd", length));
			String[] qty = (JSPUtil.getParameter(request, prefix	+ "qty", length));
			String[] routScgTp = (JSPUtil.getParameter(request, prefix	+ "rout_scg_tp", length));
			String[] rtSeq = (JSPUtil.getParameter(request, prefix	+ "rt_seq", length));
			String[] bafCurr = (JSPUtil.getParameter(request, prefix	+ "baf_curr", length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix	+ "rout_seq", length));
			String[] bletDpSeq = (JSPUtil.getParameter(request, prefix	+ "blet_dp_seq", length));
			String[] propOfcCd = (JSPUtil.getParameter(request, prefix	+ "prop_ofc_cd", length));
			String[] cafAmt = (JSPUtil.getParameter(request, prefix	+ "caf_amt", length));
			String[] propAproOfcCd = (JSPUtil.getParameter(request, prefix	+ "prop_apro_ofc_cd", length));
			String[] othCurr = (JSPUtil.getParameter(request, prefix	+ "oth_curr", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] ctrtType = (JSPUtil.getParameter(request, prefix	+ "ctrt_type", length));
			String[] mofDestLocCd = (JSPUtil.getParameter(request, prefix	+ "mof_dest_loc_cd", length));
			String[] cafCurr = (JSPUtil.getParameter(request, prefix	+ "caf_curr", length));
			String[] typeCd = (JSPUtil.getParameter(request, prefix	+ "type_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltSearchMOFListVO();
				if (othAmt[i] != null)
					model.setOthAmt(othAmt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (ctrtEffDt[i] != null)
					model.setCtrtEffDt(ctrtEffDt[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (sizeCd[i] != null)
					model.setSizeCd(sizeCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ctrtNo[i] != null)
					model.setCtrtNo(ctrtNo[i]);
				if (mofOrgLocCd[i] != null)
					model.setMofOrgLocCd(mofOrgLocCd[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (inOut[i] != null)
					model.setInOut(inOut[i]);
				if (bafAmt[i] != null)
					model.setBafAmt(bafAmt[i]);
				if (genSpclRtTpCd[i] != null)
					model.setGenSpclRtTpCd(genSpclRtTpCd[i]);
				if (oftAmt[i] != null)
					model.setOftAmt(oftAmt[i]);
				if (dthAmt[i] != null)
					model.setDthAmt(dthAmt[i]);
				if (dthCurr[i] != null)
					model.setDthCurr(dthCurr[i]);
				if (ctrtExpDt[i] != null)
					model.setCtrtExpDt(ctrtExpDt[i]);
				if (cmdtHdrSeq[i] != null)
					model.setCmdtHdrSeq(cmdtHdrSeq[i]);
				if (bqSeq[i] != null)
					model.setBqSeq(bqSeq[i]);
				if (mofLaneCd[i] != null)
					model.setMofLaneCd(mofLaneCd[i]);
				if (qty[i] != null)
					model.setQty(qty[i]);
				if (routScgTp[i] != null)
					model.setRoutScgTp(routScgTp[i]);
				if (rtSeq[i] != null)
					model.setRtSeq(rtSeq[i]);
				if (bafCurr[i] != null)
					model.setBafCurr(bafCurr[i]);
				if (routSeq[i] != null)
					model.setRoutSeq(routSeq[i]);
				if (bletDpSeq[i] != null)
					model.setBletDpSeq(bletDpSeq[i]);
				if (propOfcCd[i] != null)
					model.setPropOfcCd(propOfcCd[i]);
				if (cafAmt[i] != null)
					model.setCafAmt(cafAmt[i]);
				if (propAproOfcCd[i] != null)
					model.setPropAproOfcCd(propAproOfcCd[i]);
				if (othCurr[i] != null)
					model.setOthCurr(othCurr[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (ctrtType[i] != null)
					model.setCtrtType(ctrtType[i]);
				if (mofDestLocCd[i] != null)
					model.setMofDestLocCd(mofDestLocCd[i]);
				if (cafCurr[i] != null)
					model.setCafCurr(cafCurr[i]);
				if (typeCd[i] != null)
					model.setTypeCd(typeCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltSearchMOFListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltSearchMOFListVO[]
	 */
	public RsltSearchMOFListVO[] getRsltSearchMOFListVOs(){
		RsltSearchMOFListVO[] vos = (RsltSearchMOFListVO[])models.toArray(new RsltSearchMOFListVO[models.size()]);
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
		this.othAmt = this.othAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtEffDt = this.ctrtEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sizeCd = this.sizeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtNo = this.ctrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mofOrgLocCd = this.mofOrgLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inOut = this.inOut .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bafAmt = this.bafAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genSpclRtTpCd = this.genSpclRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oftAmt = this.oftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dthAmt = this.dthAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dthCurr = this.dthCurr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtExpDt = this.ctrtExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHdrSeq = this.cmdtHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bqSeq = this.bqSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mofLaneCd = this.mofLaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty = this.qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routScgTp = this.routScgTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtSeq = this.rtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bafCurr = this.bafCurr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq = this.routSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bletDpSeq = this.bletDpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propOfcCd = this.propOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cafAmt = this.cafAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propAproOfcCd = this.propAproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.othCurr = this.othCurr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtType = this.ctrtType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mofDestLocCd = this.mofDestLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cafCurr = this.cafCurr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.typeCd = this.typeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
