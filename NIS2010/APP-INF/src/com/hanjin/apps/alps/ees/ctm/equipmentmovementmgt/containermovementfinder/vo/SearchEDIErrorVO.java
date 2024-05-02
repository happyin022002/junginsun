/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchEDIErrorVO.java
*@FileTitle : SearchEDIErrorVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.04
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2010.01.04 김상수 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo;

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
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchEDIErrorVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchEDIErrorVO> models = new ArrayList<SearchEDIErrorVO>();
	
	/* Column Info */
	private String yard = null;
	/* Column Info */
	private String ediGateIoCd = null;
	/* Column Info */
	private String lcc = null;
	/* Column Info */
	private String corrErrRatio = null;
	/* Column Info */
	private String mvmtEdiRmk = null;
	/* Column Info */
	private String corrOk = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String initTtl = null;
	/* Column Info */
	private String pDate1 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String evntYdCd = null;
	/* Column Info */
	private String pDate2 = null;
	/* Column Info */
	private String initOk = null;
	/* Column Info */
	private String initErrRatio = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String tpCd = null;
	/* Column Info */
	private String evntDt = null;
	/* Column Info */
	private String initErr = null;
	/* Column Info */
	private String ediMvmtStsCd = null;
	/* Column Info */
	private String loc = null;
	/* Column Info */
	private String rccCd = null;
	/* Column Info */
	private String divide = null;
	/* Column Info */
	private String corrOkRatio = null;
	/* Column Info */
	private String lccCd = null;
	/* Column Info */
	private String dataRadio = null;
	/* Column Info */
	private String creLoclDt = null;
	/* Column Info */
	private String cn = null;
	/* Column Info */
	private String pYard2 = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String initOkRatio = null;
	/* Column Info */
	private String pYard1 = null;
	/* Column Info */
	private String corrTtl = null;
	/* Column Info */
	private String rcc = null;
	/* Column Info */
	private String corrErr = null;
	/* Column Info */
	private String sourceRadio = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchEDIErrorVO() {}

	public SearchEDIErrorVO(String ibflag, String pagerows, String cn, String cntrNo, String cntrTpszCd, String corrErr, String corrErrRatio, String corrOk, String corrOkRatio, String corrTtl, String creLoclDt, String dataRadio, String divide, String ediGateIoCd, String ediMvmtStsCd, String evntDt, String evntYdCd, String initErr, String initErrRatio, String initOk, String initOkRatio, String initTtl, String lcc, String lccCd, String loc, String mvmtEdiRmk, String pDate1, String pDate2, String pYard1, String pYard2, String rcc, String rccCd, String sourceRadio, String tpCd, String yard) {
		this.yard = yard;
		this.ediGateIoCd = ediGateIoCd;
		this.lcc = lcc;
		this.corrErrRatio = corrErrRatio;
		this.mvmtEdiRmk = mvmtEdiRmk;
		this.corrOk = corrOk;
		this.pagerows = pagerows;
		this.initTtl = initTtl;
		this.pDate1 = pDate1;
		this.ibflag = ibflag;
		this.evntYdCd = evntYdCd;
		this.pDate2 = pDate2;
		this.initOk = initOk;
		this.initErrRatio = initErrRatio;
		this.cntrTpszCd = cntrTpszCd;
		this.tpCd = tpCd;
		this.evntDt = evntDt;
		this.initErr = initErr;
		this.ediMvmtStsCd = ediMvmtStsCd;
		this.loc = loc;
		this.rccCd = rccCd;
		this.divide = divide;
		this.corrOkRatio = corrOkRatio;
		this.lccCd = lccCd;
		this.dataRadio = dataRadio;
		this.creLoclDt = creLoclDt;
		this.cn = cn;
		this.pYard2 = pYard2;
		this.cntrNo = cntrNo;
		this.initOkRatio = initOkRatio;
		this.pYard1 = pYard1;
		this.corrTtl = corrTtl;
		this.rcc = rcc;
		this.corrErr = corrErr;
		this.sourceRadio = sourceRadio;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("yard", getYard());
		this.hashColumns.put("edi_gate_io_cd", getEdiGateIoCd());
		this.hashColumns.put("lcc", getLcc());
		this.hashColumns.put("corr_err_ratio", getCorrErrRatio());
		this.hashColumns.put("mvmt_edi_rmk", getMvmtEdiRmk());
		this.hashColumns.put("corr_ok", getCorrOk());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("init_ttl", getInitTtl());
		this.hashColumns.put("p_date1", getPDate1());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("evnt_yd_cd", getEvntYdCd());
		this.hashColumns.put("p_date2", getPDate2());
		this.hashColumns.put("init_ok", getInitOk());
		this.hashColumns.put("init_err_ratio", getInitErrRatio());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("tp_cd", getTpCd());
		this.hashColumns.put("evnt_dt", getEvntDt());
		this.hashColumns.put("init_err", getInitErr());
		this.hashColumns.put("edi_mvmt_sts_cd", getEdiMvmtStsCd());
		this.hashColumns.put("loc", getLoc());
		this.hashColumns.put("rcc_cd", getRccCd());
		this.hashColumns.put("divide", getDivide());
		this.hashColumns.put("corr_ok_ratio", getCorrOkRatio());
		this.hashColumns.put("lcc_cd", getLccCd());
		this.hashColumns.put("data_radio", getDataRadio());
		this.hashColumns.put("cre_locl_dt", getCreLoclDt());
		this.hashColumns.put("cn", getCn());
		this.hashColumns.put("p_yard2", getPYard2());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("init_ok_ratio", getInitOkRatio());
		this.hashColumns.put("p_yard1", getPYard1());
		this.hashColumns.put("corr_ttl", getCorrTtl());
		this.hashColumns.put("rcc", getRcc());
		this.hashColumns.put("corr_err", getCorrErr());
		this.hashColumns.put("source_radio", getSourceRadio());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("yard", "yard");
		this.hashFields.put("edi_gate_io_cd", "ediGateIoCd");
		this.hashFields.put("lcc", "lcc");
		this.hashFields.put("corr_err_ratio", "corrErrRatio");
		this.hashFields.put("mvmt_edi_rmk", "mvmtEdiRmk");
		this.hashFields.put("corr_ok", "corrOk");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("init_ttl", "initTtl");
		this.hashFields.put("p_date1", "pDate1");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("evnt_yd_cd", "evntYdCd");
		this.hashFields.put("p_date2", "pDate2");
		this.hashFields.put("init_ok", "initOk");
		this.hashFields.put("init_err_ratio", "initErrRatio");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("tp_cd", "tpCd");
		this.hashFields.put("evnt_dt", "evntDt");
		this.hashFields.put("init_err", "initErr");
		this.hashFields.put("edi_mvmt_sts_cd", "ediMvmtStsCd");
		this.hashFields.put("loc", "loc");
		this.hashFields.put("rcc_cd", "rccCd");
		this.hashFields.put("divide", "divide");
		this.hashFields.put("corr_ok_ratio", "corrOkRatio");
		this.hashFields.put("lcc_cd", "lccCd");
		this.hashFields.put("data_radio", "dataRadio");
		this.hashFields.put("cre_locl_dt", "creLoclDt");
		this.hashFields.put("cn", "cn");
		this.hashFields.put("p_yard2", "pYard2");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("init_ok_ratio", "initOkRatio");
		this.hashFields.put("p_yard1", "pYard1");
		this.hashFields.put("corr_ttl", "corrTtl");
		this.hashFields.put("rcc", "rcc");
		this.hashFields.put("corr_err", "corrErr");
		this.hashFields.put("source_radio", "sourceRadio");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return yard
	 */
	public String getYard() {
		return this.yard;
	}
	
	/**
	 * Column Info
	 * @return ediGateIoCd
	 */
	public String getEdiGateIoCd() {
		return this.ediGateIoCd;
	}
	
	/**
	 * Column Info
	 * @return lcc
	 */
	public String getLcc() {
		return this.lcc;
	}
	
	/**
	 * Column Info
	 * @return corrErrRatio
	 */
	public String getCorrErrRatio() {
		return this.corrErrRatio;
	}
	
	/**
	 * Column Info
	 * @return mvmtEdiRmk
	 */
	public String getMvmtEdiRmk() {
		return this.mvmtEdiRmk;
	}
	
	/**
	 * Column Info
	 * @return corrOk
	 */
	public String getCorrOk() {
		return this.corrOk;
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
	 * @return initTtl
	 */
	public String getInitTtl() {
		return this.initTtl;
	}
	
	/**
	 * Column Info
	 * @return pDate1
	 */
	public String getPDate1() {
		return this.pDate1;
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
	 * @return evntYdCd
	 */
	public String getEvntYdCd() {
		return this.evntYdCd;
	}
	
	/**
	 * Column Info
	 * @return pDate2
	 */
	public String getPDate2() {
		return this.pDate2;
	}
	
	/**
	 * Column Info
	 * @return initOk
	 */
	public String getInitOk() {
		return this.initOk;
	}
	
	/**
	 * Column Info
	 * @return initErrRatio
	 */
	public String getInitErrRatio() {
		return this.initErrRatio;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return tpCd
	 */
	public String getTpCd() {
		return this.tpCd;
	}
	
	/**
	 * Column Info
	 * @return evntDt
	 */
	public String getEvntDt() {
		return this.evntDt;
	}
	
	/**
	 * Column Info
	 * @return initErr
	 */
	public String getInitErr() {
		return this.initErr;
	}
	
	/**
	 * Column Info
	 * @return ediMvmtStsCd
	 */
	public String getEdiMvmtStsCd() {
		return this.ediMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @return loc
	 */
	public String getLoc() {
		return this.loc;
	}
	
	/**
	 * Column Info
	 * @return rccCd
	 */
	public String getRccCd() {
		return this.rccCd;
	}
	
	/**
	 * Column Info
	 * @return divide
	 */
	public String getDivide() {
		return this.divide;
	}
	
	/**
	 * Column Info
	 * @return corrOkRatio
	 */
	public String getCorrOkRatio() {
		return this.corrOkRatio;
	}
	
	/**
	 * Column Info
	 * @return lccCd
	 */
	public String getLccCd() {
		return this.lccCd;
	}
	
	/**
	 * Column Info
	 * @return dataRadio
	 */
	public String getDataRadio() {
		return this.dataRadio;
	}
	
	/**
	 * Column Info
	 * @return creLoclDt
	 */
	public String getCreLoclDt() {
		return this.creLoclDt;
	}
	
	/**
	 * Column Info
	 * @return cn
	 */
	public String getCn() {
		return this.cn;
	}
	
	/**
	 * Column Info
	 * @return pYard2
	 */
	public String getPYard2() {
		return this.pYard2;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return initOkRatio
	 */
	public String getInitOkRatio() {
		return this.initOkRatio;
	}
	
	/**
	 * Column Info
	 * @return pYard1
	 */
	public String getPYard1() {
		return this.pYard1;
	}
	
	/**
	 * Column Info
	 * @return corrTtl
	 */
	public String getCorrTtl() {
		return this.corrTtl;
	}
	
	/**
	 * Column Info
	 * @return rcc
	 */
	public String getRcc() {
		return this.rcc;
	}
	
	/**
	 * Column Info
	 * @return corrErr
	 */
	public String getCorrErr() {
		return this.corrErr;
	}
	
	/**
	 * Column Info
	 * @return sourceRadio
	 */
	public String getSourceRadio() {
		return this.sourceRadio;
	}
	

	/**
	 * Column Info
	 * @param yard
	 */
	public void setYard(String yard) {
		this.yard = yard;
	}
	
	/**
	 * Column Info
	 * @param ediGateIoCd
	 */
	public void setEdiGateIoCd(String ediGateIoCd) {
		this.ediGateIoCd = ediGateIoCd;
	}
	
	/**
	 * Column Info
	 * @param lcc
	 */
	public void setLcc(String lcc) {
		this.lcc = lcc;
	}
	
	/**
	 * Column Info
	 * @param corrErrRatio
	 */
	public void setCorrErrRatio(String corrErrRatio) {
		this.corrErrRatio = corrErrRatio;
	}
	
	/**
	 * Column Info
	 * @param mvmtEdiRmk
	 */
	public void setMvmtEdiRmk(String mvmtEdiRmk) {
		this.mvmtEdiRmk = mvmtEdiRmk;
	}
	
	/**
	 * Column Info
	 * @param corrOk
	 */
	public void setCorrOk(String corrOk) {
		this.corrOk = corrOk;
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
	 * @param initTtl
	 */
	public void setInitTtl(String initTtl) {
		this.initTtl = initTtl;
	}
	
	/**
	 * Column Info
	 * @param pDate1
	 */
	public void setPDate1(String pDate1) {
		this.pDate1 = pDate1;
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
	 * @param evntYdCd
	 */
	public void setEvntYdCd(String evntYdCd) {
		this.evntYdCd = evntYdCd;
	}
	
	/**
	 * Column Info
	 * @param pDate2
	 */
	public void setPDate2(String pDate2) {
		this.pDate2 = pDate2;
	}
	
	/**
	 * Column Info
	 * @param initOk
	 */
	public void setInitOk(String initOk) {
		this.initOk = initOk;
	}
	
	/**
	 * Column Info
	 * @param initErrRatio
	 */
	public void setInitErrRatio(String initErrRatio) {
		this.initErrRatio = initErrRatio;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param tpCd
	 */
	public void setTpCd(String tpCd) {
		this.tpCd = tpCd;
	}
	
	/**
	 * Column Info
	 * @param evntDt
	 */
	public void setEvntDt(String evntDt) {
		this.evntDt = evntDt;
	}
	
	/**
	 * Column Info
	 * @param initErr
	 */
	public void setInitErr(String initErr) {
		this.initErr = initErr;
	}
	
	/**
	 * Column Info
	 * @param ediMvmtStsCd
	 */
	public void setEdiMvmtStsCd(String ediMvmtStsCd) {
		this.ediMvmtStsCd = ediMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @param loc
	 */
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	/**
	 * Column Info
	 * @param rccCd
	 */
	public void setRccCd(String rccCd) {
		this.rccCd = rccCd;
	}
	
	/**
	 * Column Info
	 * @param divide
	 */
	public void setDivide(String divide) {
		this.divide = divide;
	}
	
	/**
	 * Column Info
	 * @param corrOkRatio
	 */
	public void setCorrOkRatio(String corrOkRatio) {
		this.corrOkRatio = corrOkRatio;
	}
	
	/**
	 * Column Info
	 * @param lccCd
	 */
	public void setLccCd(String lccCd) {
		this.lccCd = lccCd;
	}
	
	/**
	 * Column Info
	 * @param dataRadio
	 */
	public void setDataRadio(String dataRadio) {
		this.dataRadio = dataRadio;
	}
	
	/**
	 * Column Info
	 * @param creLoclDt
	 */
	public void setCreLoclDt(String creLoclDt) {
		this.creLoclDt = creLoclDt;
	}
	
	/**
	 * Column Info
	 * @param cn
	 */
	public void setCn(String cn) {
		this.cn = cn;
	}
	
	/**
	 * Column Info
	 * @param pYard2
	 */
	public void setPYard2(String pYard2) {
		this.pYard2 = pYard2;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param initOkRatio
	 */
	public void setInitOkRatio(String initOkRatio) {
		this.initOkRatio = initOkRatio;
	}
	
	/**
	 * Column Info
	 * @param pYard1
	 */
	public void setPYard1(String pYard1) {
		this.pYard1 = pYard1;
	}
	
	/**
	 * Column Info
	 * @param corrTtl
	 */
	public void setCorrTtl(String corrTtl) {
		this.corrTtl = corrTtl;
	}
	
	/**
	 * Column Info
	 * @param rcc
	 */
	public void setRcc(String rcc) {
		this.rcc = rcc;
	}
	
	/**
	 * Column Info
	 * @param corrErr
	 */
	public void setCorrErr(String corrErr) {
		this.corrErr = corrErr;
	}
	
	/**
	 * Column Info
	 * @param sourceRadio
	 */
	public void setSourceRadio(String sourceRadio) {
		this.sourceRadio = sourceRadio;
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
		setYard(JSPUtil.getParameter(request, prefix + "yard", ""));
		setEdiGateIoCd(JSPUtil.getParameter(request, prefix + "edi_gate_io_cd", ""));
		setLcc(JSPUtil.getParameter(request, prefix + "lcc", ""));
		setCorrErrRatio(JSPUtil.getParameter(request, prefix + "corr_err_ratio", ""));
		setMvmtEdiRmk(JSPUtil.getParameter(request, prefix + "mvmt_edi_rmk", ""));
		setCorrOk(JSPUtil.getParameter(request, prefix + "corr_ok", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setInitTtl(JSPUtil.getParameter(request, prefix + "init_ttl", ""));
		setPDate1(JSPUtil.getParameter(request, prefix + "p_date1", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEvntYdCd(JSPUtil.getParameter(request, prefix + "evnt_yd_cd", ""));
		setPDate2(JSPUtil.getParameter(request, prefix + "p_date2", ""));
		setInitOk(JSPUtil.getParameter(request, prefix + "init_ok", ""));
		setInitErrRatio(JSPUtil.getParameter(request, prefix + "init_err_ratio", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setTpCd(JSPUtil.getParameter(request, prefix + "tp_cd", ""));
		setEvntDt(JSPUtil.getParameter(request, prefix + "evnt_dt", ""));
		setInitErr(JSPUtil.getParameter(request, prefix + "init_err", ""));
		setEdiMvmtStsCd(JSPUtil.getParameter(request, prefix + "edi_mvmt_sts_cd", ""));
		setLoc(JSPUtil.getParameter(request, prefix + "loc", ""));
		setRccCd(JSPUtil.getParameter(request, prefix + "rcc_cd", ""));
		setDivide(JSPUtil.getParameter(request, prefix + "divide", ""));
		setCorrOkRatio(JSPUtil.getParameter(request, prefix + "corr_ok_ratio", ""));
		setLccCd(JSPUtil.getParameter(request, prefix + "lcc_cd", ""));
		setDataRadio(JSPUtil.getParameter(request, prefix + "data_radio", ""));
		setCreLoclDt(JSPUtil.getParameter(request, prefix + "cre_locl_dt", ""));
		setCn(JSPUtil.getParameter(request, prefix + "cn", ""));
		setPYard2(JSPUtil.getParameter(request, prefix + "p_yard2", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setInitOkRatio(JSPUtil.getParameter(request, prefix + "init_ok_ratio", ""));
		setPYard1(JSPUtil.getParameter(request, prefix + "p_yard1", ""));
		setCorrTtl(JSPUtil.getParameter(request, prefix + "corr_ttl", ""));
		setRcc(JSPUtil.getParameter(request, prefix + "rcc", ""));
		setCorrErr(JSPUtil.getParameter(request, prefix + "corr_err", ""));
		setSourceRadio(JSPUtil.getParameter(request, prefix + "source_radio", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchEDIErrorVO[]
	 */
	public SearchEDIErrorVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchEDIErrorVO[]
	 */
	public SearchEDIErrorVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchEDIErrorVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] yard = (JSPUtil.getParameter(request, prefix	+ "yard", length));
			String[] ediGateIoCd = (JSPUtil.getParameter(request, prefix	+ "edi_gate_io_cd", length));
			String[] lcc = (JSPUtil.getParameter(request, prefix	+ "lcc", length));
			String[] corrErrRatio = (JSPUtil.getParameter(request, prefix	+ "corr_err_ratio", length));
			String[] mvmtEdiRmk = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_rmk", length));
			String[] corrOk = (JSPUtil.getParameter(request, prefix	+ "corr_ok", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] initTtl = (JSPUtil.getParameter(request, prefix	+ "init_ttl", length));
			String[] pDate1 = (JSPUtil.getParameter(request, prefix	+ "p_date1", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] evntYdCd = (JSPUtil.getParameter(request, prefix	+ "evnt_yd_cd", length));
			String[] pDate2 = (JSPUtil.getParameter(request, prefix	+ "p_date2", length));
			String[] initOk = (JSPUtil.getParameter(request, prefix	+ "init_ok", length));
			String[] initErrRatio = (JSPUtil.getParameter(request, prefix	+ "init_err_ratio", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] tpCd = (JSPUtil.getParameter(request, prefix	+ "tp_cd", length));
			String[] evntDt = (JSPUtil.getParameter(request, prefix	+ "evnt_dt", length));
			String[] initErr = (JSPUtil.getParameter(request, prefix	+ "init_err", length));
			String[] ediMvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "edi_mvmt_sts_cd", length));
			String[] loc = (JSPUtil.getParameter(request, prefix	+ "loc", length));
			String[] rccCd = (JSPUtil.getParameter(request, prefix	+ "rcc_cd", length));
			String[] divide = (JSPUtil.getParameter(request, prefix	+ "divide", length));
			String[] corrOkRatio = (JSPUtil.getParameter(request, prefix	+ "corr_ok_ratio", length));
			String[] lccCd = (JSPUtil.getParameter(request, prefix	+ "lcc_cd", length));
			String[] dataRadio = (JSPUtil.getParameter(request, prefix	+ "data_radio", length));
			String[] creLoclDt = (JSPUtil.getParameter(request, prefix	+ "cre_locl_dt", length));
			String[] cn = (JSPUtil.getParameter(request, prefix	+ "cn", length));
			String[] pYard2 = (JSPUtil.getParameter(request, prefix	+ "p_yard2", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] initOkRatio = (JSPUtil.getParameter(request, prefix	+ "init_ok_ratio", length));
			String[] pYard1 = (JSPUtil.getParameter(request, prefix	+ "p_yard1", length));
			String[] corrTtl = (JSPUtil.getParameter(request, prefix	+ "corr_ttl", length));
			String[] rcc = (JSPUtil.getParameter(request, prefix	+ "rcc", length));
			String[] corrErr = (JSPUtil.getParameter(request, prefix	+ "corr_err", length));
			String[] sourceRadio = (JSPUtil.getParameter(request, prefix	+ "source_radio", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchEDIErrorVO();
				if (yard[i] != null)
					model.setYard(yard[i]);
				if (ediGateIoCd[i] != null)
					model.setEdiGateIoCd(ediGateIoCd[i]);
				if (lcc[i] != null)
					model.setLcc(lcc[i]);
				if (corrErrRatio[i] != null)
					model.setCorrErrRatio(corrErrRatio[i]);
				if (mvmtEdiRmk[i] != null)
					model.setMvmtEdiRmk(mvmtEdiRmk[i]);
				if (corrOk[i] != null)
					model.setCorrOk(corrOk[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (initTtl[i] != null)
					model.setInitTtl(initTtl[i]);
				if (pDate1[i] != null)
					model.setPDate1(pDate1[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (evntYdCd[i] != null)
					model.setEvntYdCd(evntYdCd[i]);
				if (pDate2[i] != null)
					model.setPDate2(pDate2[i]);
				if (initOk[i] != null)
					model.setInitOk(initOk[i]);
				if (initErrRatio[i] != null)
					model.setInitErrRatio(initErrRatio[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (tpCd[i] != null)
					model.setTpCd(tpCd[i]);
				if (evntDt[i] != null)
					model.setEvntDt(evntDt[i]);
				if (initErr[i] != null)
					model.setInitErr(initErr[i]);
				if (ediMvmtStsCd[i] != null)
					model.setEdiMvmtStsCd(ediMvmtStsCd[i]);
				if (loc[i] != null)
					model.setLoc(loc[i]);
				if (rccCd[i] != null)
					model.setRccCd(rccCd[i]);
				if (divide[i] != null)
					model.setDivide(divide[i]);
				if (corrOkRatio[i] != null)
					model.setCorrOkRatio(corrOkRatio[i]);
				if (lccCd[i] != null)
					model.setLccCd(lccCd[i]);
				if (dataRadio[i] != null)
					model.setDataRadio(dataRadio[i]);
				if (creLoclDt[i] != null)
					model.setCreLoclDt(creLoclDt[i]);
				if (cn[i] != null)
					model.setCn(cn[i]);
				if (pYard2[i] != null)
					model.setPYard2(pYard2[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (initOkRatio[i] != null)
					model.setInitOkRatio(initOkRatio[i]);
				if (pYard1[i] != null)
					model.setPYard1(pYard1[i]);
				if (corrTtl[i] != null)
					model.setCorrTtl(corrTtl[i]);
				if (rcc[i] != null)
					model.setRcc(rcc[i]);
				if (corrErr[i] != null)
					model.setCorrErr(corrErr[i]);
				if (sourceRadio[i] != null)
					model.setSourceRadio(sourceRadio[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchEDIErrorVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchEDIErrorVO[]
	 */
	public SearchEDIErrorVO[] getSearchEDIErrorVOs(){
		SearchEDIErrorVO[] vos = (SearchEDIErrorVO[])models.toArray(new SearchEDIErrorVO[models.size()]);
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
		this.yard = this.yard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediGateIoCd = this.ediGateIoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lcc = this.lcc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrErrRatio = this.corrErrRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiRmk = this.mvmtEdiRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrOk = this.corrOk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initTtl = this.initTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate1 = this.pDate1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntYdCd = this.evntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate2 = this.pDate2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initOk = this.initOk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initErrRatio = this.initErrRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpCd = this.tpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDt = this.evntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initErr = this.initErr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediMvmtStsCd = this.ediMvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loc = this.loc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccCd = this.rccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divide = this.divide .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrOkRatio = this.corrOkRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lccCd = this.lccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dataRadio = this.dataRadio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creLoclDt = this.creLoclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cn = this.cn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pYard2 = this.pYard2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initOkRatio = this.initOkRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pYard1 = this.pYard1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrTtl = this.corrTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcc = this.rcc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrErr = this.corrErr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sourceRadio = this.sourceRadio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
