/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCommonVO.java
*@FileTitle : EesCommonVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.31
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.07.31  정은호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.common.eqrcommon.vo;

import java.util.HashMap;
import java.util.List;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.syscommon.common.table.EqrEqRepoPlnVO;

public class EesCommonVO extends AbstractValueObject{
	/**
	 * Table Value Ojbect<br>
	 * EesCommonEvent 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
	 * 기존 EES_COMMONEventResponse 에 담을 내용을 상속받았음
	 * @author 
	 * @since J2EE 1.6
	 * @see AbstractValueObject
	 */
	private static final long serialVersionUID = 1L;
	// Database ResultSet
	private DBRowSet   rowSet;
	private DBRowSet   rowSet1;
	private List<EqrEqRepoPlnVO> list;

	// Success Flag
	private String successFlag;
	private String resultset3;
	private String resultECC;

	private String[] resultset;
	private String[] resultset1;
	private String[] resultset2;
	private String[] resultset4;
	private String resultset5;
	private String[] resultset6;
	private String resultset7;
	private String resultset8;
	private String[] resultset9;
	private String resultset10;
	private String resultset11;
		
	//private boolean check;
	private boolean check;

	//---- SEARCH LOC CD EXIST -------
	private String loccdResult = null;
	
	//---- SEARCH LOC YARD COMBO BOX -------
	private String[] locyardResult = null;

	//---- SEARCH LOC YARD Company COMBO BOX -------
	private String[] locyardCompanyResult = null;
	
	//---- SEARCH LOC YARD EXIST -------
	private String locyardExistResult = null;

	//---- SEARCH LOC YARD COMPANY EXIST -------
	private String locyardExistCompanyResult = null;

	//---- SEARCH LOC YARD INITIAL -------
	private String[] locyardInitialResult = null;
	
	//---- SEARCH LOC YARD-ECC COMBO BOX -------
	private String[] locyardeccResult = null;

	//---- SEARCH VENDOR COMBO BOX -------
	private String[] vendorResult = null;
	private String[] seqResult = null;

	//---- SEARCH VVD COMBO BOX -------
	private String[] vvdResult = null;

	//---- SEARCH VVD INLAND COMBO BOX -------
	private String[] vvdInlandResult = null;

	//---- SEARCH VVD EXIST -------
	private String[] vvdExistResult = null;
	private String vvdExistVvdcheck = null;

	private String scnrId = null;
	
	//----- Country MULTI BOX --------------	
	private String[] countryinfo = null;
	
	//----- currency Week & Gap week --------------
	private String[] weekinfo = null;
	
	//----- Week Valid Check --------------
	private String checkweek = null;
	private String[] resultarr = null;
	
	//----- week daily    ----------------	
	private String weekDaily  = null;
	
	// ----	WEEK DATE PERIOD -------------
	private String weekPeriodFromdate = null;
	private String weekPeriodTodate   = null;
	
	// ---- ETA DATE -------------------------
	private String etadate = null;
	
	// ---- duplicate_check POD --------------
	private String 	duplicateCheck = null;
	
	// --- vssel SKD  check -----------
	private String[] etaEtdEtb; 
	
	private String slaneCd = null;
	private String company = null;
	
	
	
	public DBRowSet getRowSet() {
		return rowSet;
	}
	public void setRowSet(DBRowSet rowSet) {
		this.rowSet = rowSet;
	}
	public DBRowSet getRowSet1() {
		return rowSet1;
	}
	public void setRowSet1(DBRowSet rowSet1) {
		this.rowSet1 = rowSet1;
	}
	
	public List<EqrEqRepoPlnVO> getList() {
		return list;
	}
	public void setList(List<EqrEqRepoPlnVO> list) {
		this.list = list;
	}
	public String getSuccessFlag() {
		return successFlag;
	}
	public void setSuccessFlag(String successFlag) {
		this.successFlag = successFlag;
	}
	public String getResultset3() {
		return resultset3;
	}
	public void setResultset3(String resultset3) {
		this.resultset3 = resultset3;
	}
	public String getResultECC() {
		return resultECC;
	}
	public void setResultECC(String resultECC) {
		this.resultECC = resultECC;
	}
	public String[] getResultset() {
		return resultset;
	}
	public void setResultset(String[] resultset) {
		this.resultset = resultset;
	}
	public String[] getResultset1() {
		return resultset1;
	}
	public void setResultset1(String[] resultset1) {
		this.resultset1 = resultset1;
	}
	public String[] getResultset2() {
		return resultset2;
	}
	public void setResultset2(String[] resultset2) {
		this.resultset2 = resultset2;
	}
	public String[] getResultset4() {
		return resultset4;
	}
	public void setResultset4(String[] resultset4) {
		this.resultset4 = resultset4;
	}
	public String getResultset5() {
		return resultset5;
	}
	public void setResultset5(String resultset5) {
		this.resultset5 = resultset5;
	}
	public String[] getResultset6() {
		return resultset6;
	}
	public void setResultset6(String[] resultset6) {
		this.resultset6 = resultset6;
	}
	public String getResultset7() {
		return resultset7;
	}
	public void setResultset7(String resultset7) {
		this.resultset7 = resultset7;
	}
	public String getResultset8() {
		return resultset8;
	}
	public void setResultset8(String resultset8) {
		this.resultset8 = resultset8;
	}
	public String[] getResultset9() {
		return resultset9;
	}
	public void setResultset9(String[] resultset9) {
		this.resultset9 = resultset9;
	}
	public String getResultset10() {
		return resultset10;
	}
	public void setResultset10(String resultset10) {
		this.resultset10 = resultset10;
	}
	public String getResultset11() {
		return resultset11;
	}
	public void setResultset11(String resultset11) {
		this.resultset11 = resultset11;
	}
	public boolean isCheck() {
		return check;
	}
	public void setCheck(boolean check) {
		this.check = check;
	}
	public String getLoccdResult() {
		return loccdResult;
	}
	public void setLoccdResult(String loccdResult) {
		this.loccdResult = loccdResult;
	}
	public String[] getLocyardResult() {
		return locyardResult;
	}
	public void setLocyardResult(String[] locyardResult) {
		this.locyardResult = locyardResult;
	}
	public String[] getLocyardCompanyResult() {
		return locyardCompanyResult;
	}
	public void setLocyardCompanyResult(String[] locyardCompanyResult) {
		this.locyardCompanyResult = locyardCompanyResult;
	}
	public String getLocyardExistResult() {
		return locyardExistResult;
	}
	public void setLocyardExistResult(String locyardExistResult) {
		this.locyardExistResult = locyardExistResult;
	}
	public String getLocyardExistCompanyResult() {
		return locyardExistCompanyResult;
	}
	public void setLocyardExistCompanyResult(String locyardExistCompanyResult) {
		this.locyardExistCompanyResult = locyardExistCompanyResult;
	}
	public String[] getLocyardInitialResult() {
		return locyardInitialResult;
	}
	public void setLocyardInitialResult(String[] locyardInitialResult) {
		this.locyardInitialResult = locyardInitialResult;
	}
	public String[] getLocyardeccResult() {
		return locyardeccResult;
	}
	public void setLocyardeccResult(String[] locyardeccResult) {
		this.locyardeccResult = locyardeccResult;
	}
	public String[] getVendorResult() {
		return vendorResult;
	}
	public void setVendorResult(String[] vendorResult) {
		this.vendorResult = vendorResult;
	}
	public String[] getSeqResult() {
		return seqResult;
	}
	public void setSeqResult(String[] seqResult) {
		this.seqResult = seqResult;
	}
	public String[] getVvdResult() {
		return vvdResult;
	}
	public void setVvdResult(String[] vvdResult) {
		this.vvdResult = vvdResult;
	}
	public String[] getVvdInlandResult() {
		return vvdInlandResult;
	}
	public void setVvdInlandResult(String[] vvdInlandResult) {
		this.vvdInlandResult = vvdInlandResult;
	}
	public String[] getVvdExistResult() {
		return vvdExistResult;
	}
	public void setVvdExistResult(String[] vvdExistResult) {
		this.vvdExistResult = vvdExistResult;
	}
	public String getVvdExistVvdcheck() {
		return vvdExistVvdcheck;
	}
	public void setVvdExistVvdcheck(String vvdExistVvdcheck) {
		this.vvdExistVvdcheck = vvdExistVvdcheck;
	}
	public String getScnrId() {
		return scnrId;
	}
	public void setScnrId(String scnrId) {
		this.scnrId = scnrId;
	}
	public String[] getCountryinfo() {
		return countryinfo;
	}
	public void setCountryinfo(String[] countryinfo) {
		this.countryinfo = countryinfo;
	}
	public String[] getWeekinfo() {
		return weekinfo;
	}
	public void setWeekinfo(String[] weekinfo) {
		this.weekinfo = weekinfo;
	}
	public String getCheckweek() {
		return checkweek;
	}
	public void setCheckweek(String checkweek) {
		this.checkweek = checkweek;
	}
	public String[] getResultarr() {
		return resultarr;
	}
	public void setResultarr(String[] resultarr) {
		this.resultarr = resultarr;
	}
	public String getWeekDaily() {
		return weekDaily;
	}
	public void setWeekDaily(String weekDaily) {
		this.weekDaily = weekDaily;
	}
	public String getWeekPeriodFromdate() {
		return weekPeriodFromdate;
	}
	public void setWeekPeriodFromdate(String weekPeriodFromdate) {
		this.weekPeriodFromdate = weekPeriodFromdate;
	}
	public String getWeekPeriodTodate() {
		return weekPeriodTodate;
	}
	public void setWeekPeriodTodate(String weekPeriodTodate) {
		this.weekPeriodTodate = weekPeriodTodate;
	}
	public String getEtadate() {
		return etadate;
	}
	public void setEtadate(String etadate) {
		this.etadate = etadate;
	}
	public String getDuplicateCheck() {
		return duplicateCheck;
	}
	public void setDuplicateCheck(String duplicateCheck) {
		this.duplicateCheck = duplicateCheck;
	}
	public String[] getEtaEtdEtb() {
		return etaEtdEtb;
	}
	public void setEtaEtdEtb(String[] etaEtdEtb) {
		this.etaEtdEtb = etaEtdEtb;
	}
	public String getSlaneCd() {
		return slaneCd;
	}
	public void setSlaneCd(String slaneCd) {
		this.slaneCd = slaneCd;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Override
	public HashMap<String, String> getColumnValues() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public HashMap<String, String> getFieldNames() {
		// TODO Auto-generated method stub
		return null;
	}
}
