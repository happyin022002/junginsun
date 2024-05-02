/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchEDIResultVO.java
*@FileTitle : SearchEDIResultVO
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

public class SearchEDIResultVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchEDIResultVO> models = new ArrayList<SearchEDIResultVO>();
	
	/* Column Info */
	private String yard = null;
	/* Column Info */
	private String intErrRatio = null;
	/* Column Info */
	private String ediGateIoCd = null;
	/* Column Info */
	private String lcc = null;
	/* Column Info */
	private String intErr = null;
	/* Column Info */
	private String intTtl = null;
	/* Column Info */
	private String mvmtEdiRmk = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pDate1 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String edi12hRatio = null;
	/* Column Info */
	private String evntYdCd = null;
	/* Column Info */
	private String pDate2 = null;
	/* Column Info */
	private String ediOver = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String tpCd = null;
	/* Column Info */
	private String edi12h = null;
	/* Column Info */
	private String ediTtl = null;
	/* Column Info */
	private String evntDt = null;
	/* Column Info */
	private String edi24h = null;
	/* Column Info */
	private String ediMvmtStsCd = null;
	/* Column Info */
	private String intOk = null;
	/* Column Info */
	private String loc = null;
	/* Column Info */
	private String ediOverRatio = null;
	/* Column Info */
	private String rccCd = null;
	/* Column Info */
	private String divide = null;
	/* Column Info */
	private String edi48hRatio = null;
	/* Column Info */
	private String lccCd = null;
	/* Column Info */
	private String edi48h = null;
	/* Column Info */
	private String creLoclDt = null;
	/* Column Info */
	private String cn = null;
	/* Column Info */
	private String pYard2 = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String intOkRatio = null;
	/* Column Info */
	private String gapRadio = null;
	/* Column Info */
	private String pYard1 = null;
	/* Column Info */
	private String method = null;
	/* Column Info */
	private String edi24hRatio = null;
	/* Column Info */
	private String rcc = null;
	/* Column Info */
	private String sourceRadio = null;
	/* Column Info */
	private String gap = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchEDIResultVO() {}

	public SearchEDIResultVO(String ibflag, String pagerows, String cn, String cntrNo, String cntrTpszCd, String creLoclDt, String divide, String edi12h, String edi12hRatio, String edi24h, String edi24hRatio, String edi48h, String edi48hRatio, String ediGateIoCd, String ediMvmtStsCd, String ediOver, String ediOverRatio, String ediTtl, String evntDt, String evntYdCd, String gap, String gapRadio, String intErr, String intErrRatio, String intOk, String intOkRatio, String intTtl, String lcc, String lccCd, String loc, String method, String mvmtEdiRmk, String pDate1, String pDate2, String pYard1, String pYard2, String rcc, String rccCd, String sourceRadio, String tpCd, String yard) {
		this.yard = yard;
		this.intErrRatio = intErrRatio;
		this.ediGateIoCd = ediGateIoCd;
		this.lcc = lcc;
		this.intErr = intErr;
		this.intTtl = intTtl;
		this.mvmtEdiRmk = mvmtEdiRmk;
		this.pagerows = pagerows;
		this.pDate1 = pDate1;
		this.ibflag = ibflag;
		this.edi12hRatio = edi12hRatio;
		this.evntYdCd = evntYdCd;
		this.pDate2 = pDate2;
		this.ediOver = ediOver;
		this.cntrTpszCd = cntrTpszCd;
		this.tpCd = tpCd;
		this.edi12h = edi12h;
		this.ediTtl = ediTtl;
		this.evntDt = evntDt;
		this.edi24h = edi24h;
		this.ediMvmtStsCd = ediMvmtStsCd;
		this.intOk = intOk;
		this.loc = loc;
		this.ediOverRatio = ediOverRatio;
		this.rccCd = rccCd;
		this.divide = divide;
		this.edi48hRatio = edi48hRatio;
		this.lccCd = lccCd;
		this.edi48h = edi48h;
		this.creLoclDt = creLoclDt;
		this.cn = cn;
		this.pYard2 = pYard2;
		this.cntrNo = cntrNo;
		this.intOkRatio = intOkRatio;
		this.gapRadio = gapRadio;
		this.pYard1 = pYard1;
		this.method = method;
		this.edi24hRatio = edi24hRatio;
		this.rcc = rcc;
		this.sourceRadio = sourceRadio;
		this.gap = gap;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("yard", getYard());
		this.hashColumns.put("int_err_ratio", getIntErrRatio());
		this.hashColumns.put("edi_gate_io_cd", getEdiGateIoCd());
		this.hashColumns.put("lcc", getLcc());
		this.hashColumns.put("int_err", getIntErr());
		this.hashColumns.put("int_ttl", getIntTtl());
		this.hashColumns.put("mvmt_edi_rmk", getMvmtEdiRmk());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("p_date1", getPDate1());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("edi_12h_ratio", getEdi12hRatio());
		this.hashColumns.put("evnt_yd_cd", getEvntYdCd());
		this.hashColumns.put("p_date2", getPDate2());
		this.hashColumns.put("edi_over", getEdiOver());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("tp_cd", getTpCd());
		this.hashColumns.put("edi_12h", getEdi12h());
		this.hashColumns.put("edi_ttl", getEdiTtl());
		this.hashColumns.put("evnt_dt", getEvntDt());
		this.hashColumns.put("edi_24h", getEdi24h());
		this.hashColumns.put("edi_mvmt_sts_cd", getEdiMvmtStsCd());
		this.hashColumns.put("int_ok", getIntOk());
		this.hashColumns.put("loc", getLoc());
		this.hashColumns.put("edi_over_ratio", getEdiOverRatio());
		this.hashColumns.put("rcc_cd", getRccCd());
		this.hashColumns.put("divide", getDivide());
		this.hashColumns.put("edi_48h_ratio", getEdi48hRatio());
		this.hashColumns.put("lcc_cd", getLccCd());
		this.hashColumns.put("edi_48h", getEdi48h());
		this.hashColumns.put("cre_locl_dt", getCreLoclDt());
		this.hashColumns.put("cn", getCn());
		this.hashColumns.put("p_yard2", getPYard2());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("int_ok_ratio", getIntOkRatio());
		this.hashColumns.put("gap_radio", getGapRadio());
		this.hashColumns.put("p_yard1", getPYard1());
		this.hashColumns.put("method", getMethod());
		this.hashColumns.put("edi_24h_ratio", getEdi24hRatio());
		this.hashColumns.put("rcc", getRcc());
		this.hashColumns.put("source_radio", getSourceRadio());
		this.hashColumns.put("gap", getGap());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("yard", "yard");
		this.hashFields.put("int_err_ratio", "intErrRatio");
		this.hashFields.put("edi_gate_io_cd", "ediGateIoCd");
		this.hashFields.put("lcc", "lcc");
		this.hashFields.put("int_err", "intErr");
		this.hashFields.put("int_ttl", "intTtl");
		this.hashFields.put("mvmt_edi_rmk", "mvmtEdiRmk");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("p_date1", "pDate1");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("edi_12h_ratio", "edi12hRatio");
		this.hashFields.put("evnt_yd_cd", "evntYdCd");
		this.hashFields.put("p_date2", "pDate2");
		this.hashFields.put("edi_over", "ediOver");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("tp_cd", "tpCd");
		this.hashFields.put("edi_12h", "edi12h");
		this.hashFields.put("edi_ttl", "ediTtl");
		this.hashFields.put("evnt_dt", "evntDt");
		this.hashFields.put("edi_24h", "edi24h");
		this.hashFields.put("edi_mvmt_sts_cd", "ediMvmtStsCd");
		this.hashFields.put("int_ok", "intOk");
		this.hashFields.put("loc", "loc");
		this.hashFields.put("edi_over_ratio", "ediOverRatio");
		this.hashFields.put("rcc_cd", "rccCd");
		this.hashFields.put("divide", "divide");
		this.hashFields.put("edi_48h_ratio", "edi48hRatio");
		this.hashFields.put("lcc_cd", "lccCd");
		this.hashFields.put("edi_48h", "edi48h");
		this.hashFields.put("cre_locl_dt", "creLoclDt");
		this.hashFields.put("cn", "cn");
		this.hashFields.put("p_yard2", "pYard2");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("int_ok_ratio", "intOkRatio");
		this.hashFields.put("gap_radio", "gapRadio");
		this.hashFields.put("p_yard1", "pYard1");
		this.hashFields.put("method", "method");
		this.hashFields.put("edi_24h_ratio", "edi24hRatio");
		this.hashFields.put("rcc", "rcc");
		this.hashFields.put("source_radio", "sourceRadio");
		this.hashFields.put("gap", "gap");
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
	 * @return intErrRatio
	 */
	public String getIntErrRatio() {
		return this.intErrRatio;
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
	 * @return intErr
	 */
	public String getIntErr() {
		return this.intErr;
	}
	
	/**
	 * Column Info
	 * @return intTtl
	 */
	public String getIntTtl() {
		return this.intTtl;
	}
	
	/**
	 * Column Info
	 * @return mvmtEdiRmk
	 */
	public String getMvmtEdiRmk() {
		return this.mvmtEdiRmk;
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
	 * @return edi12hRatio
	 */
	public String getEdi12hRatio() {
		return this.edi12hRatio;
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
	 * @return ediOver
	 */
	public String getEdiOver() {
		return this.ediOver;
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
	 * @return edi12h
	 */
	public String getEdi12h() {
		return this.edi12h;
	}
	
	/**
	 * Column Info
	 * @return ediTtl
	 */
	public String getEdiTtl() {
		return this.ediTtl;
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
	 * @return edi24h
	 */
	public String getEdi24h() {
		return this.edi24h;
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
	 * @return intOk
	 */
	public String getIntOk() {
		return this.intOk;
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
	 * @return ediOverRatio
	 */
	public String getEdiOverRatio() {
		return this.ediOverRatio;
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
	 * @return edi48hRatio
	 */
	public String getEdi48hRatio() {
		return this.edi48hRatio;
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
	 * @return edi48h
	 */
	public String getEdi48h() {
		return this.edi48h;
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
	 * @return intOkRatio
	 */
	public String getIntOkRatio() {
		return this.intOkRatio;
	}
	
	/**
	 * Column Info
	 * @return gapRadio
	 */
	public String getGapRadio() {
		return this.gapRadio;
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
	 * @return method
	 */
	public String getMethod() {
		return this.method;
	}
	
	/**
	 * Column Info
	 * @return edi24hRatio
	 */
	public String getEdi24hRatio() {
		return this.edi24hRatio;
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
	 * @return sourceRadio
	 */
	public String getSourceRadio() {
		return this.sourceRadio;
	}
	
	/**
	 * Column Info
	 * @return gap
	 */
	public String getGap() {
		return this.gap;
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
	 * @param intErrRatio
	 */
	public void setIntErrRatio(String intErrRatio) {
		this.intErrRatio = intErrRatio;
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
	 * @param intErr
	 */
	public void setIntErr(String intErr) {
		this.intErr = intErr;
	}
	
	/**
	 * Column Info
	 * @param intTtl
	 */
	public void setIntTtl(String intTtl) {
		this.intTtl = intTtl;
	}
	
	/**
	 * Column Info
	 * @param mvmtEdiRmk
	 */
	public void setMvmtEdiRmk(String mvmtEdiRmk) {
		this.mvmtEdiRmk = mvmtEdiRmk;
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
	 * @param edi12hRatio
	 */
	public void setEdi12hRatio(String edi12hRatio) {
		this.edi12hRatio = edi12hRatio;
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
	 * @param ediOver
	 */
	public void setEdiOver(String ediOver) {
		this.ediOver = ediOver;
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
	 * @param edi12h
	 */
	public void setEdi12h(String edi12h) {
		this.edi12h = edi12h;
	}
	
	/**
	 * Column Info
	 * @param ediTtl
	 */
	public void setEdiTtl(String ediTtl) {
		this.ediTtl = ediTtl;
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
	 * @param edi24h
	 */
	public void setEdi24h(String edi24h) {
		this.edi24h = edi24h;
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
	 * @param intOk
	 */
	public void setIntOk(String intOk) {
		this.intOk = intOk;
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
	 * @param ediOverRatio
	 */
	public void setEdiOverRatio(String ediOverRatio) {
		this.ediOverRatio = ediOverRatio;
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
	 * @param edi48hRatio
	 */
	public void setEdi48hRatio(String edi48hRatio) {
		this.edi48hRatio = edi48hRatio;
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
	 * @param edi48h
	 */
	public void setEdi48h(String edi48h) {
		this.edi48h = edi48h;
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
	 * @param intOkRatio
	 */
	public void setIntOkRatio(String intOkRatio) {
		this.intOkRatio = intOkRatio;
	}
	
	/**
	 * Column Info
	 * @param gapRadio
	 */
	public void setGapRadio(String gapRadio) {
		this.gapRadio = gapRadio;
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
	 * @param method
	 */
	public void setMethod(String method) {
		this.method = method;
	}
	
	/**
	 * Column Info
	 * @param edi24hRatio
	 */
	public void setEdi24hRatio(String edi24hRatio) {
		this.edi24hRatio = edi24hRatio;
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
	 * @param sourceRadio
	 */
	public void setSourceRadio(String sourceRadio) {
		this.sourceRadio = sourceRadio;
	}
	
	/**
	 * Column Info
	 * @param gap
	 */
	public void setGap(String gap) {
		this.gap = gap;
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
		setIntErrRatio(JSPUtil.getParameter(request, prefix + "int_err_ratio", ""));
		setEdiGateIoCd(JSPUtil.getParameter(request, prefix + "edi_gate_io_cd", ""));
		setLcc(JSPUtil.getParameter(request, prefix + "lcc", ""));
		setIntErr(JSPUtil.getParameter(request, prefix + "int_err", ""));
		setIntTtl(JSPUtil.getParameter(request, prefix + "int_ttl", ""));
		setMvmtEdiRmk(JSPUtil.getParameter(request, prefix + "mvmt_edi_rmk", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPDate1(JSPUtil.getParameter(request, prefix + "p_date1", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEdi12hRatio(JSPUtil.getParameter(request, prefix + "edi_12h_ratio", ""));
		setEvntYdCd(JSPUtil.getParameter(request, prefix + "evnt_yd_cd", ""));
		setPDate2(JSPUtil.getParameter(request, prefix + "p_date2", ""));
		setEdiOver(JSPUtil.getParameter(request, prefix + "edi_over", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setTpCd(JSPUtil.getParameter(request, prefix + "tp_cd", ""));
		setEdi12h(JSPUtil.getParameter(request, prefix + "edi_12h", ""));
		setEdiTtl(JSPUtil.getParameter(request, prefix + "edi_ttl", ""));
		setEvntDt(JSPUtil.getParameter(request, prefix + "evnt_dt", ""));
		setEdi24h(JSPUtil.getParameter(request, prefix + "edi_24h", ""));
		setEdiMvmtStsCd(JSPUtil.getParameter(request, prefix + "edi_mvmt_sts_cd", ""));
		setIntOk(JSPUtil.getParameter(request, prefix + "int_ok", ""));
		setLoc(JSPUtil.getParameter(request, prefix + "loc", ""));
		setEdiOverRatio(JSPUtil.getParameter(request, prefix + "edi_over_ratio", ""));
		setRccCd(JSPUtil.getParameter(request, prefix + "rcc_cd", ""));
		setDivide(JSPUtil.getParameter(request, prefix + "divide", ""));
		setEdi48hRatio(JSPUtil.getParameter(request, prefix + "edi_48h_ratio", ""));
		setLccCd(JSPUtil.getParameter(request, prefix + "lcc_cd", ""));
		setEdi48h(JSPUtil.getParameter(request, prefix + "edi_48h", ""));
		setCreLoclDt(JSPUtil.getParameter(request, prefix + "cre_locl_dt", ""));
		setCn(JSPUtil.getParameter(request, prefix + "cn", ""));
		setPYard2(JSPUtil.getParameter(request, prefix + "p_yard2", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setIntOkRatio(JSPUtil.getParameter(request, prefix + "int_ok_ratio", ""));
		setGapRadio(JSPUtil.getParameter(request, prefix + "gap_radio", ""));
		setPYard1(JSPUtil.getParameter(request, prefix + "p_yard1", ""));
		setMethod(JSPUtil.getParameter(request, prefix + "method", ""));
		setEdi24hRatio(JSPUtil.getParameter(request, prefix + "edi_24h_ratio", ""));
		setRcc(JSPUtil.getParameter(request, prefix + "rcc", ""));
		setSourceRadio(JSPUtil.getParameter(request, prefix + "source_radio", ""));
		setGap(JSPUtil.getParameter(request, prefix + "gap", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchEDIResultVO[]
	 */
	public SearchEDIResultVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchEDIResultVO[]
	 */
	public SearchEDIResultVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchEDIResultVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] yard = (JSPUtil.getParameter(request, prefix	+ "yard", length));
			String[] intErrRatio = (JSPUtil.getParameter(request, prefix	+ "int_err_ratio", length));
			String[] ediGateIoCd = (JSPUtil.getParameter(request, prefix	+ "edi_gate_io_cd", length));
			String[] lcc = (JSPUtil.getParameter(request, prefix	+ "lcc", length));
			String[] intErr = (JSPUtil.getParameter(request, prefix	+ "int_err", length));
			String[] intTtl = (JSPUtil.getParameter(request, prefix	+ "int_ttl", length));
			String[] mvmtEdiRmk = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_rmk", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pDate1 = (JSPUtil.getParameter(request, prefix	+ "p_date1", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] edi12hRatio = (JSPUtil.getParameter(request, prefix	+ "edi_12h_ratio", length));
			String[] evntYdCd = (JSPUtil.getParameter(request, prefix	+ "evnt_yd_cd", length));
			String[] pDate2 = (JSPUtil.getParameter(request, prefix	+ "p_date2", length));
			String[] ediOver = (JSPUtil.getParameter(request, prefix	+ "edi_over", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] tpCd = (JSPUtil.getParameter(request, prefix	+ "tp_cd", length));
			String[] edi12h = (JSPUtil.getParameter(request, prefix	+ "edi_12h", length));
			String[] ediTtl = (JSPUtil.getParameter(request, prefix	+ "edi_ttl", length));
			String[] evntDt = (JSPUtil.getParameter(request, prefix	+ "evnt_dt", length));
			String[] edi24h = (JSPUtil.getParameter(request, prefix	+ "edi_24h", length));
			String[] ediMvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "edi_mvmt_sts_cd", length));
			String[] intOk = (JSPUtil.getParameter(request, prefix	+ "int_ok", length));
			String[] loc = (JSPUtil.getParameter(request, prefix	+ "loc", length));
			String[] ediOverRatio = (JSPUtil.getParameter(request, prefix	+ "edi_over_ratio", length));
			String[] rccCd = (JSPUtil.getParameter(request, prefix	+ "rcc_cd", length));
			String[] divide = (JSPUtil.getParameter(request, prefix	+ "divide", length));
			String[] edi48hRatio = (JSPUtil.getParameter(request, prefix	+ "edi_48h_ratio", length));
			String[] lccCd = (JSPUtil.getParameter(request, prefix	+ "lcc_cd", length));
			String[] edi48h = (JSPUtil.getParameter(request, prefix	+ "edi_48h", length));
			String[] creLoclDt = (JSPUtil.getParameter(request, prefix	+ "cre_locl_dt", length));
			String[] cn = (JSPUtil.getParameter(request, prefix	+ "cn", length));
			String[] pYard2 = (JSPUtil.getParameter(request, prefix	+ "p_yard2", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] intOkRatio = (JSPUtil.getParameter(request, prefix	+ "int_ok_ratio", length));
			String[] gapRadio = (JSPUtil.getParameter(request, prefix	+ "gap_radio", length));
			String[] pYard1 = (JSPUtil.getParameter(request, prefix	+ "p_yard1", length));
			String[] method = (JSPUtil.getParameter(request, prefix	+ "method", length));
			String[] edi24hRatio = (JSPUtil.getParameter(request, prefix	+ "edi_24h_ratio", length));
			String[] rcc = (JSPUtil.getParameter(request, prefix	+ "rcc", length));
			String[] sourceRadio = (JSPUtil.getParameter(request, prefix	+ "source_radio", length));
			String[] gap = (JSPUtil.getParameter(request, prefix	+ "gap", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchEDIResultVO();
				if (yard[i] != null)
					model.setYard(yard[i]);
				if (intErrRatio[i] != null)
					model.setIntErrRatio(intErrRatio[i]);
				if (ediGateIoCd[i] != null)
					model.setEdiGateIoCd(ediGateIoCd[i]);
				if (lcc[i] != null)
					model.setLcc(lcc[i]);
				if (intErr[i] != null)
					model.setIntErr(intErr[i]);
				if (intTtl[i] != null)
					model.setIntTtl(intTtl[i]);
				if (mvmtEdiRmk[i] != null)
					model.setMvmtEdiRmk(mvmtEdiRmk[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pDate1[i] != null)
					model.setPDate1(pDate1[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (edi12hRatio[i] != null)
					model.setEdi12hRatio(edi12hRatio[i]);
				if (evntYdCd[i] != null)
					model.setEvntYdCd(evntYdCd[i]);
				if (pDate2[i] != null)
					model.setPDate2(pDate2[i]);
				if (ediOver[i] != null)
					model.setEdiOver(ediOver[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (tpCd[i] != null)
					model.setTpCd(tpCd[i]);
				if (edi12h[i] != null)
					model.setEdi12h(edi12h[i]);
				if (ediTtl[i] != null)
					model.setEdiTtl(ediTtl[i]);
				if (evntDt[i] != null)
					model.setEvntDt(evntDt[i]);
				if (edi24h[i] != null)
					model.setEdi24h(edi24h[i]);
				if (ediMvmtStsCd[i] != null)
					model.setEdiMvmtStsCd(ediMvmtStsCd[i]);
				if (intOk[i] != null)
					model.setIntOk(intOk[i]);
				if (loc[i] != null)
					model.setLoc(loc[i]);
				if (ediOverRatio[i] != null)
					model.setEdiOverRatio(ediOverRatio[i]);
				if (rccCd[i] != null)
					model.setRccCd(rccCd[i]);
				if (divide[i] != null)
					model.setDivide(divide[i]);
				if (edi48hRatio[i] != null)
					model.setEdi48hRatio(edi48hRatio[i]);
				if (lccCd[i] != null)
					model.setLccCd(lccCd[i]);
				if (edi48h[i] != null)
					model.setEdi48h(edi48h[i]);
				if (creLoclDt[i] != null)
					model.setCreLoclDt(creLoclDt[i]);
				if (cn[i] != null)
					model.setCn(cn[i]);
				if (pYard2[i] != null)
					model.setPYard2(pYard2[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (intOkRatio[i] != null)
					model.setIntOkRatio(intOkRatio[i]);
				if (gapRadio[i] != null)
					model.setGapRadio(gapRadio[i]);
				if (pYard1[i] != null)
					model.setPYard1(pYard1[i]);
				if (method[i] != null)
					model.setMethod(method[i]);
				if (edi24hRatio[i] != null)
					model.setEdi24hRatio(edi24hRatio[i]);
				if (rcc[i] != null)
					model.setRcc(rcc[i]);
				if (sourceRadio[i] != null)
					model.setSourceRadio(sourceRadio[i]);
				if (gap[i] != null)
					model.setGap(gap[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchEDIResultVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchEDIResultVO[]
	 */
	public SearchEDIResultVO[] getSearchEDIResultVOs(){
		SearchEDIResultVO[] vos = (SearchEDIResultVO[])models.toArray(new SearchEDIResultVO[models.size()]);
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
		this.intErrRatio = this.intErrRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediGateIoCd = this.ediGateIoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lcc = this.lcc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intErr = this.intErr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intTtl = this.intTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiRmk = this.mvmtEdiRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate1 = this.pDate1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edi12hRatio = this.edi12hRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntYdCd = this.evntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate2 = this.pDate2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediOver = this.ediOver .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpCd = this.tpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edi12h = this.edi12h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediTtl = this.ediTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDt = this.evntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edi24h = this.edi24h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediMvmtStsCd = this.ediMvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intOk = this.intOk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loc = this.loc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediOverRatio = this.ediOverRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccCd = this.rccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divide = this.divide .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edi48hRatio = this.edi48hRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lccCd = this.lccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edi48h = this.edi48h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creLoclDt = this.creLoclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cn = this.cn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pYard2 = this.pYard2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intOkRatio = this.intOkRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gapRadio = this.gapRadio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pYard1 = this.pYard1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.method = this.method .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edi24hRatio = this.edi24hRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcc = this.rcc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sourceRadio = this.sourceRadio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gap = this.gap .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
