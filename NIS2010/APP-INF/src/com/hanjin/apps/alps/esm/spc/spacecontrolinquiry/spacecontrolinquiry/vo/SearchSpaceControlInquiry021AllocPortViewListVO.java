/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchSpaceControlInquiry021AllocPortViewListVO.java
*@FileTitle : SearchSpaceControlInquiry021AllocPortViewListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.24  
* 1.0 Creation
* 2014.07.31 [CHM-201431081] SPC Allocation Control Option 추가 보완 요청
* 2014.11.05 [CHM-201432345] SMP Report 신규 생성(요건 변경으로 FCST&PFMC Status by ACCT탭 수정) 
				- Accout Class삭제, L.OFC 체크박스 추가, Fcast 체크박스 추가
				- TTL CM, CMPB, Load% BKG옆에 추가
				- Inqurity by Customized Condition 팝업링크 추가
* 2016.01.12 이혜민 [CHM-201539227] Daily FCST status _ Allocation status(HO) & Allocation status(RHQ) 기능추가				
=========================================================*/

package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo;

//import java.lang.reflect.Field;
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

public class SearchSpaceControlInquiry021AllocPortViewListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSpaceControlInquiry021AllocPortViewListVO> models = new ArrayList<SearchSpaceControlInquiry021AllocPortViewListVO>();
	
	/* Column Info */
	private String bkgR221 = null;
	/* Column Info */
	private String bkgHc11 = null;
	/* Column Info */
	private String cmOp61 = null;
	/* Column Info */
	private String bkgR551 = null;
	/* Column Info */
	private String bkgRd21 = null;
	/* Column Info */
	private String bkgAvgQty41 = null;
	/* Column Info */
	private String fct61 = null;
	/* Column Info */
	private String bkg4531 = null;
	/* Column Info */
	private String custCtrlCd = null;
	/* Column Info */
	private String cmVl61 = null;
	/* Column Info */
	private String fct11 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String maxQty51 = null;
	/* Column Info */
	private String cmOc61 = null;
	/* Column Info */
	private String bkgD211 = null;
	/* Column Info */
	private String alcRf61 = null;
	/* Column Info */
	private String bkgAvgQty31 = null;
	/* Column Info */
	private String custGrpNm = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String bkg5331 = null;
	/* Column Info */
	private String bkgRf31 = null;
	/* Column Info */
	private String bkg2041 = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String prefRf61 = null;
	/* Column Info */
	private String bkg21 = null;
	/* Column Info */
	private String bkgR231 = null;
	/* Column Info */
	private String alc11 = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String cmOp51 = null;
	/* Column Info */
	private String bkgR541 = null;
	/* Column Info */
	private String cmVl51 = null;
	/* Column Info */
	private String cfct61 = null;
	/* Column Info */
	private String bkgAvgQty51 = null;
	/* Column Info */
	private String bkg4541 = null;
	/* Column Info */
	private String bkgRd31 = null;
	/* Column Info */
	private String vvd2 = null;
	/* Column Info */
	private String vvd3 = null;
	/* Column Info */
	private String vvd1 = null;
	/* Column Info */
	private String maxQty61 = null;
	/* Column Info */
	private String vvd6 = null;
	/* Column Info */
	private String vvd5 = null;
	/* Column Info */
	private String vvd4 = null;
	/* Column Info */
	private String qta61 = null;
	/* Column Info */
	private String bkgD221 = null;
	/* Column Info */
	private String gid = null;
	/* Column Info */
	private String bkgRf21 = null;
	/* Column Info */
	private String bkg5321 = null;
	/* Column Info */
	private String bkg2031 = null;
	/* Column Info */
	private String prefRf51 = null;
	/* Column Info */
	private String othCustNm = null;
	/* Column Info */
	private String alcRf51 = null;
	/* Column Info */
	private String bkg11 = null;
	/* Column Info */
	private String bkgR241 = null;
	/* Column Info */
	private String custNo = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String fct41 = null;
	/* Column Info */
	private String fct31 = null;
	/* Column Info */
	private String maxQty31 = null;
	/* Column Info */
	private String alc21 = null;
	/* Column Info */
	private String cmOp41 = null;
	/* Column Info */
	private String bkg4511 = null;
	/* Column Info */
	private String bkgHc31 = null;
	/* Column Info */
	private String cmVl41 = null;
	/* Column Info */
	private String port4 = null;
	/* Column Info */
	private String cfct51 = null;
	/* Column Info */
	private String qta51 = null;
	/* Column Info */
	private String port3 = null;
	/* Column Info */
	private String bkgAvgQty11 = null;
	/* Column Info */
	private String port2 = null;
	/* Column Info */
	private String port1 = null;
	/* Column Info */
	private String port6 = null;
	/* Column Info */
	private String port5 = null;
	/* Column Info */
	private String bkg4021 = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String bkg2021 = null;
	/* Column Info */
	private String bkgD421 = null;
	/* Column Info */
	private String bkgRf11 = null;
	/* Column Info */
	private String aqCd = null;
	/* Column Info */
	private String bkg5351 = null;
	/* Column Info */
	private String bkgR561 = null;
	/* Column Info */
	private String cmOc11 = null;
	/* Column Info */
	private String bkgR251 = null;
	/* Column Info */
	private String bkgHc21 = null;
	/* Column Info */
	private String cnt = null;
	/* Column Info */
	private String bsaAvg = null;
	/* Column Info */
	private String alc31 = null;
	/* Column Info */
	private String fct21 = null;
	/* Column Info */
	private String custClss = null;
	/* Column Info */
	private String fct51 = null;
	/* Column Info */
	private String cmVl31 = null;
	/* Column Info */
	private String pref61 = null;
	/* Column Info */
	private String cmOp31 = null;
	/* Column Info */
	private String bkg4521 = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String subOfcCd = null;
	/* Column Info */
	private String bkgRd11 = null;
	/* Column Info */
	private String cfct41 = null;
	/* Column Info */
	private String qta41 = null;
	/* Column Info */
	private String bkgAvgQty21 = null;
	/* Column Info */
	private String dest = null;
	/* Column Info */
	private String t = null;
	/* Column Info */
	private String bkg4011 = null;
	/* Column Info */
	private String maxQty41 = null;
	/* Column Info */
	private String bkgD411 = null;
	/* Column Info */
	private String bkg5341 = null;
	/* Column Info */
	private String bkg2011 = null;
	/* Column Info */
	private String bkgD441 = null;
	/* Column Info */
	private String cmOp21 = null;
	/* Column Info */
	private String maxQty11 = null;
	/* Column Info */
	private String pref11 = null;
	/* Column Info */
	private String prf11 = null;
	/* Column Info */
	private String prf21 = null;
	/* Column Info */
	private String prf31 = null;
	/* Column Info */
	private String prf41 = null;
	/* Column Info */
	private String prf51 = null;
	/* Column Info */
	private String prf61 = null;
	/* Column Info */
	private String bkgRd61 = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String cmVl11 = null;
	/* Column Info */
	private String bkg4051 = null;
	/* Column Info */
	private String bkg31 = null;
	/* Column Info */
	private String cmOc21 = null;
	/* Column Info */
	private String alc51 = null;
	/* Column Info */
	private String cmVl21 = null;
	/* Column Info */
	private String acctTp = null;
	/* Column Info */
	private String prefRf21 = null;
	/* Column Info */
	private String bkgHc51 = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String alcRf21 = null;
	/* Column Info */
	private String qta31 = null;
	/* Column Info */
	private String bkgRf61 = null;
	/* Column Info */
	private String bkgR261 = null;
	/* Column Info */
	private String bkgD251 = null;
	/* Column Info */
	private String cfct31 = null;
	/* Column Info */
	private String cmOp11 = null;
	/* Column Info */
	private String custGrpId = null;
	/* Column Info */
	private String maxQty21 = null;
	/* Column Info */
	private String pref21 = null;
	/* Column Info */
	private String bkgD431 = null;
	/* Column Info */
	private String bkg41 = null;
	/* Column Info */
	private String cmOc31 = null;
	/* Column Info */
	private String bkg4061 = null;
	/* Column Info */
	private String prefRf11 = null;
	/* Column Info */
	private String bkgD261 = null;
	/* Column Info */
	private String alcRf11 = null;
	/* Column Info */
	private String alc41 = null;
	/* Column Info */
	private String bkgHc41 = null;
	/* Column Info */
	private String qta21 = null;
	/* Column Info */
	private String cfct21 = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String bkg5361 = null;
	/* Column Info */
	private String pref31 = null;
	/* Column Info */
	private String bkgR511 = null;
	/* Column Info */
	private String bkgD461 = null;
	/* Column Info */
	private String bkgAvgQty61 = null;
	/* Column Info */
	private String bkgRd41 = null;
	/* Column Info */
	private String bkg4031 = null;
	/* Column Info */
	private String bkg51 = null;
	/* Column Info */
	private String cmOc41 = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String alcRf41 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkg5311 = null;
	/* Column Info */
	private String bkg4551 = null;
	/* Column Info */
	private String prefRf41 = null;
	/* Column Info */
	private String bsa5 = null;
	/* Column Info */
	private String bsa4 = null;
	/* Column Info */
	private String bsa6 = null;
	/* Column Info */
	private String bkgD231 = null;
	/* Column Info */
	private String cfct11 = null;
	/* Column Info */
	private String qta11 = null;
	/* Column Info */
	private String bsa1 = null;
	
	private String bsaw1 = null;
	private String bsaw2 = null;
	private String bsaw3 = null;
	private String bsaw4 = null;
	private String bsaw5 = null;
	private String bsaw6 = null;
	
	private String bkgw1 = null;
	private String bkgw2 = null;
	private String bkgw3 = null;
	private String bkgw4 = null;
	private String bkgw5 = null;
	private String bkgw6 = null;
	
	/* Column Info */
	private String bkgRf41 = null;
	/* Column Info */
	private String bsa3 = null;
	/* Column Info */
	private String bkg2061 = null;
	/* Column Info */
	private String bsa2 = null;
	/* Column Info */
	private String pref41 = null;
	/* Column Info */
	private String bkgR521 = null;
	/* Column Info */
	private String bkgD451 = null;
	/* Column Info */
	private String bkgRd51 = null;
	/* Column Info */
	private String bkg4041 = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String bkg61 = null;
	/* Column Info */
	private String cmOc51 = null;
	/* Column Info */
	private String bkgR211 = null;
	/* Column Info */
	private String alcRf31 = null;
	/* Column Info */
	private String alc61 = null;
	/* Column Info */
	private String bkg4561 = null;
	/* Column Info */
	private String bkg2051 = null;
	/* Column Info */
	private String bkgHc61 = null;
	/* Column Info */
	private String prefRf31 = null;
	/* Column Info */
	private String bkgD241 = null;
	/* Column Info */
	private String bkgRf51 = null;
	/* Column Info */
	private String pref51 = null;
	/* Column Info */
	private String bkgR531 = null;
	/* Column Info */
	private String usaBkgModCd = null;
	/* Column Info */
	private String destLocCd = null;
	/* Column Info */
	private String acctCd = null;
	
	/* Column Info */
	private String ratio51 = null;
	/* Column Info */
	private String cm41 = null;
	/* Column Info */
	private String ratio11 = null;
	/* Column Info */
	private String ratio31 = null;
	/* Column Info */
	private String cm21 = null;
	/* Column Info */
	private String ratio21 = null;
	/* Column Info */
	private String cm11 = null;
	/* Column Info */
	private String cm51 = null;
	/* Column Info */
	private String ratio61 = null;
	/* Column Info */
	private String cm61 = null;
	/* Column Info */
	private String ratio41 = null;
	/* Column Info */
	private String cm31 = null;
	/* Column Info */
	private String cmb31 = null;
	/* Column Info */
	private String cmb41 = null;
	/* Column Info */
	private String cmb61 = null;
	/* Column Info */
	private String cmb11 = null;
	/* Column Info */
	private String cmb51 = null;
	/* Column Info */
	private String cmb21 = null;	
	/* Column Info */
	private String cmEn11 = null;
	/* Column Info */
	private String cmEn21 = null;
	/* Column Info */
	private String cmEn31 = null;
	/* Column Info */
	private String cmEn41 = null;
	/* Column Info */
	private String cmEn51 = null;
	/* Column Info */
	private String cmEn61 = null;

	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchSpaceControlInquiry021AllocPortViewListVO() {}

	public SearchSpaceControlInquiry021AllocPortViewListVO(String ibflag, String pagerows, String bsaAvg, String trdCd, String subTrdCd, String rlaneCd, String dirCd, String rhqCd, String aqCd, String ofcCd,String subOfcCd, String t, String dest, String cnt, String port1, String port2, String port3, String port4, String port5, String port6, String vvd1, String vvd2, String vvd3, String vvd4, String vvd5, String vvd6, String bsa1, String bsa2, String bsa3, String bsa4, String bsa5, String bsa6, String qta11, String qta21, String qta31, String qta41, String qta51, String qta61, String alc11, String alc21, String alc31, String alc41, String alc51, String alc61, String alcRf11, String alcRf21, String alcRf31, String alcRf41, String alcRf51, String alcRf61, String bkg11, String bkg21, String bkg31, String bkg41, String bkg51, String bkg61, String bkg2011, String bkg2021, String bkg2031, String bkg2041, String bkg2051, String bkg2061, String bkg4011, String bkg4021, String bkg4031, String bkg4041, String bkg4051, String bkg4061, String bkgD211, String bkgD221, String bkgD231, String bkgD241, String bkgD251, String bkgD261, String bkgD411, String bkgD421, String bkgD431, String bkgD441, String bkgD451, String bkgD461, String bkgHc11, String bkgHc21, String bkgHc31, String bkgHc41, String bkgHc51, String bkgHc61, String bkgRd11, String bkgRd21, String bkgRd31, String bkgRd41, String bkgRd51, String bkgRd61, String bkg4511, String bkg4521, String bkg4531, String bkg4541, String bkg4551, String bkg4561, String bkg5311, String bkg5321, String bkg5331, String bkg5341, String bkg5351, String bkg5361, String bkgRf11, String bkgRf21, String bkgRf31, String bkgRf41, String bkgRf51, String bkgRf61, String bkgR211, String bkgR221, String bkgR231, String bkgR241, String bkgR251, String bkgR261, String bkgR511, String bkgR521, String bkgR531, String bkgR541, String bkgR551, String bkgR561
																					, String cmEn11, String cmEn21, String cmEn31, String cmEn41, String cmEn51, String cmEn61																		
																					, String cmOp11, String cmOp21, String cmOp31, String cmOp41, String cmOp51, String cmOp61
																					, String cmOc11, String cmOc21, String cmOc31, String cmOc41, String cmOc51, String cmOc61
																					, String cmVl11, String cmVl21, String cmVl31, String cmVl41, String cmVl51, String cmVl61
																					, String pref11, String pref21, String pref31, String pref41, String pref51, String pref61, String fct11, String fct21, String fct31, String fct41, String fct51, String fct61, String prefRf11, String prefRf21, String prefRf31, String prefRf41, String prefRf51, String prefRf61, String maxQty11, String maxQty21, String maxQty31, String maxQty41, String maxQty51, String maxQty61, String bkgAvgQty11, String bkgAvgQty21, String bkgAvgQty31, String bkgAvgQty41, String bkgAvgQty51, String bkgAvgQty61, String cfct11, String cfct21, String cfct31, String cfct41, String cfct51, String cfct61, String acctTp, String custSeq, String custCntCd, String custGrpId, String custNo, String custGrpNm, String custNm, String othCustNm, String scNo, String ctrtOfcCd, String custClss, String custCtrlCd, String gid, String rfaNo
																					, String usaBkgModCd, String destLocCd, String acctCd
																					, String cm11, String cm21, String cm31, String cm41, String cm51, String cm61, String cmb11, String cmb21, String cmb31, String cmb41, String cmb51, String cmb61, String ratio11, String ratio21, String ratio31, String ratio41, String ratio51, String ratio61
																					, String prf11, String prf21,String prf31,String prf41,String prf51,String prf61
																					, String bsaw1, String bsaw2, String bsaw3, String bsaw4, String bsaw5, String bsaw6
																					, String bkgw1, String bkgw2, String bkgw3, String bkgw4, String bkgw5, String bkgw6
																					
	) {
		this.bkgR221 = bkgR221;
		this.bkgHc11 = bkgHc11;
		this.cmOp61 = cmOp61;
		this.bkgR551 = bkgR551;
		this.bkgRd21 = bkgRd21;
		this.bkgAvgQty41 = bkgAvgQty41;
		this.fct61 = fct61;
		this.bkg4531 = bkg4531;
		this.custCtrlCd = custCtrlCd;
		this.cmVl61 = cmVl61;
		this.fct11 = fct11;
		this.pagerows = pagerows;
		this.maxQty51 = maxQty51;
		this.cmOc61 = cmOc61;
		this.bkgD211 = bkgD211;
		this.alcRf61 = alcRf61;
		this.bkgAvgQty31 = bkgAvgQty31;
		this.custGrpNm = custGrpNm;
		this.ctrtOfcCd = ctrtOfcCd;
		this.bkg5331 = bkg5331;
		this.bkgRf31 = bkgRf31;
		this.bkg2041 = bkg2041;
		this.custCntCd = custCntCd;
		this.prefRf61 = prefRf61;
		this.bkg21 = bkg21;
		this.bkgR231 = bkgR231;
		this.alc11 = alc11;
		this.rhqCd = rhqCd;
		this.cmOp51 = cmOp51;
		this.bkgR541 = bkgR541;
		this.cmVl51 = cmVl51;
		this.cfct61 = cfct61;
		this.bkgAvgQty51 = bkgAvgQty51;
		this.bkg4541 = bkg4541;
		this.bkgRd31 = bkgRd31;
		this.vvd2 = vvd2;
		this.vvd3 = vvd3;
		this.vvd1 = vvd1;
		this.maxQty61 = maxQty61;
		this.vvd6 = vvd6;
		this.vvd5 = vvd5;
		this.vvd4 = vvd4;
		this.qta61 = qta61;
		this.bkgD221 = bkgD221;
		this.gid = gid;
		this.bkgRf21 = bkgRf21;
		this.bkg5321 = bkg5321;
		this.bkg2031 = bkg2031;
		this.prefRf51 = prefRf51;
		this.othCustNm = othCustNm;
		this.alcRf51 = alcRf51;
		this.bkg11 = bkg11;
		this.bkgR241 = bkgR241;
		this.custNo = custNo;
		this.custNm = custNm;
		this.fct41 = fct41;
		this.fct31 = fct31;
		this.maxQty31 = maxQty31;
		this.alc21 = alc21;
		this.cmOp41 = cmOp41;
		this.bkg4511 = bkg4511;
		this.bkgHc31 = bkgHc31;
		this.cmVl41 = cmVl41;
		this.port4 = port4;
		this.cfct51 = cfct51;
		this.qta51 = qta51;
		this.port3 = port3;
		this.bkgAvgQty11 = bkgAvgQty11;
		this.port2 = port2;
		this.port1 = port1;
		this.port6 = port6;
		this.port5 = port5;
		this.bkg4021 = bkg4021;
		this.dirCd = dirCd;
		this.bkg2021 = bkg2021;
		this.bkgD421 = bkgD421;
		this.bkgRf11 = bkgRf11;
		this.aqCd = aqCd;
		this.bkg5351 = bkg5351;
		this.bkgR561 = bkgR561;
		this.cmOc11 = cmOc11;
		this.bkgR251 = bkgR251;
		this.bkgHc21 = bkgHc21;
		this.cnt = cnt;
		this.bsaAvg = bsaAvg;
		this.alc31 = alc31;
		this.fct21 = fct21;
		this.custClss = custClss;
		this.fct51 = fct51;
		this.cmVl31 = cmVl31;
		this.pref61 = pref61;
		this.cmOp31 = cmOp31;
		this.bkg4521 = bkg4521;
		this.ofcCd = ofcCd;
		this.subOfcCd = subOfcCd;
		this.bkgRd11 = bkgRd11;
		this.cfct41 = cfct41;
		this.qta41 = qta41;
		this.bkgAvgQty21 = bkgAvgQty21;
		this.dest = dest;
		this.t = t;
		this.bkg4011 = bkg4011;
		this.maxQty41 = maxQty41;
		this.bkgD411 = bkgD411;
		this.bkg5341 = bkg5341;
		this.bkg2011 = bkg2011;
		this.bkgD441 = bkgD441;
		this.cmOp21 = cmOp21;
		this.maxQty11 = maxQty11;
		this.pref11 = pref11;
		this.bkgRd61 = bkgRd61;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.cmVl11 = cmVl11;
		this.bkg4051 = bkg4051;
		this.bkg31 = bkg31;
		this.cmOc21 = cmOc21;
		this.alc51 = alc51;
		this.cmVl21 = cmVl21;
		this.acctTp = acctTp;
		this.prefRf21 = prefRf21;
		this.bkgHc51 = bkgHc51;
		this.scNo = scNo;
		this.alcRf21 = alcRf21;
		this.qta31 = qta31;
		this.bkgRf61 = bkgRf61;
		this.bkgR261 = bkgR261;
		this.bkgD251 = bkgD251;
		this.cfct31 = cfct31;
		this.cmOp11 = cmOp11;
		this.custGrpId = custGrpId;
		this.maxQty21 = maxQty21;
		this.pref21 = pref21;
		this.bkgD431 = bkgD431;
		this.bkg41 = bkg41;
		this.cmOc31 = cmOc31;
		this.bkg4061 = bkg4061;
		this.prefRf11 = prefRf11;
		this.bkgD261 = bkgD261;
		this.alcRf11 = alcRf11;
		this.alc41 = alc41;
		this.bkgHc41 = bkgHc41;
		this.qta21 = qta21;
		this.cfct21 = cfct21;
		this.subTrdCd = subTrdCd;
		this.bkg5361 = bkg5361;
		this.pref31 = pref31;
		this.bkgR511 = bkgR511;
		this.bkgD461 = bkgD461;
		this.bkgAvgQty61 = bkgAvgQty61;
		this.bkgRd41 = bkgRd41;
		this.bkg4031 = bkg4031;
		this.bkg51 = bkg51;
		this.cmOc41 = cmOc41;
		this.rfaNo = rfaNo;
		this.alcRf41 = alcRf41;
		this.ibflag = ibflag;
		this.bkg5311 = bkg5311;
		this.bkg4551 = bkg4551;
		this.prefRf41 = prefRf41;
		this.bsa5 = bsa5;
		this.bsa4 = bsa4;
		this.bsa6 = bsa6;
		this.bkgD231 = bkgD231;
		this.cfct11 = cfct11;
		this.qta11 = qta11;
		this.bsa1 = bsa1;
		this.bkgRf41 = bkgRf41;
		this.bsa3 = bsa3;
		this.bkg2061 = bkg2061;
		this.bsa2 = bsa2;
		this.pref41 = pref41;
		this.bkgR521 = bkgR521;
		this.bkgD451 = bkgD451;
		this.bkgRd51 = bkgRd51;
		this.bkg4041 = bkg4041;
		this.custSeq = custSeq;
		this.bkg61 = bkg61;
		this.cmOc51 = cmOc51;
		this.bkgR211 = bkgR211;
		this.alcRf31 = alcRf31;
		this.alc61 = alc61;
		this.bkg4561 = bkg4561;
		this.bkg2051 = bkg2051;
		this.bkgHc61 = bkgHc61;
		this.prefRf31 = prefRf31;
		this.bkgD241 = bkgD241;
		this.bkgRf51 = bkgRf51;
		this.pref51 = pref51;
		this.bkgR531 = bkgR531;
		this.usaBkgModCd = usaBkgModCd;
		this.destLocCd = destLocCd;
		this.acctCd = acctCd;
		
		this.ratio51 = ratio51;
		this.cm41 = cm41;
		this.ratio11 = ratio11;
		this.ratio31 = ratio31;
		this.cm21 = cm21;
		this.ratio21 = ratio21;
		this.cm11 = cm11;
		this.cm51 = cm51;
		this.ratio61 = ratio61;
		this.cm61 = cm61;
		this.ratio41 = ratio41;
		this.cm31 = cm31;
		this.cmb31 = cmb31;
		this.cmb41 = cmb41;
		this.cmb61 = cmb61;
		this.cmb11 = cmb11;
		this.cmb51 = cmb51;
		this.cmb21 = cmb21;
		
		this.cmEn11 = cmEn11;
		this.cmEn21 = cmEn21;
		this.cmEn31 = cmEn31;
		this.cmEn41 = cmEn41;
		this.cmEn51 = cmEn51;
		this.cmEn61 = cmEn61;
		
		this.prf11 = prf11;
		this.prf21 = prf21;
		this.prf31 = prf31;
		this.prf41 = prf41;
		this.prf51 = prf51;
		this.prf61 = prf61;
		
		this.bsaw1 = bsaw1;
		this.bsaw2 = bsaw2;
		this.bsaw3 = bsaw3;
		this.bsaw4 = bsaw4;
		this.bsaw5 = bsaw5;
		this.bsaw6 = bsaw6;
		
		this.bkgw1 = bkgw1;
		this.bkgw2 = bkgw2;
		this.bkgw3 = bkgw3;
		this.bkgw4 = bkgw4;
		this.bkgw5 = bkgw5;
		this.bkgw6 = bkgw6;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_r221", getBkgR221());
		this.hashColumns.put("bkg_hc11", getBkgHc11());
		this.hashColumns.put("cm_op61", getCmOp61());
		this.hashColumns.put("bkg_r551", getBkgR551());
		this.hashColumns.put("bkg_rd21", getBkgRd21());
		this.hashColumns.put("bkg_avg_qty41", getBkgAvgQty41());
		this.hashColumns.put("fct61", getFct61());
		this.hashColumns.put("bkg_4531", getBkg4531());
		this.hashColumns.put("cust_ctrl_cd", getCustCtrlCd());
		this.hashColumns.put("cm_vl61", getCmVl61());
		this.hashColumns.put("fct11", getFct11());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("max_qty51", getMaxQty51());
		this.hashColumns.put("cm_oc61", getCmOc61());
		this.hashColumns.put("bkg_d211", getBkgD211());
		this.hashColumns.put("alc_rf61", getAlcRf61());
		this.hashColumns.put("bkg_avg_qty31", getBkgAvgQty31());
		this.hashColumns.put("cust_grp_nm", getCustGrpNm());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("bkg_5331", getBkg5331());
		this.hashColumns.put("bkg_rf31", getBkgRf31());
		this.hashColumns.put("bkg_2041", getBkg2041());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("pref_rf61", getPrefRf61());
		this.hashColumns.put("bkg21", getBkg21());
		this.hashColumns.put("bkg_r231", getBkgR231());
		this.hashColumns.put("alc11", getAlc11());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("cm_op51", getCmOp51());
		this.hashColumns.put("bkg_r541", getBkgR541());
		this.hashColumns.put("cm_vl51", getCmVl51());
		this.hashColumns.put("cfct61", getCfct61());
		this.hashColumns.put("bkg_avg_qty51", getBkgAvgQty51());
		this.hashColumns.put("bkg_4541", getBkg4541());
		this.hashColumns.put("bkg_rd31", getBkgRd31());
		this.hashColumns.put("vvd2", getVvd2());
		this.hashColumns.put("vvd3", getVvd3());
		this.hashColumns.put("vvd1", getVvd1());
		this.hashColumns.put("max_qty61", getMaxQty61());
		this.hashColumns.put("vvd6", getVvd6());
		this.hashColumns.put("vvd5", getVvd5());
		this.hashColumns.put("vvd4", getVvd4());
		this.hashColumns.put("qta61", getQta61());
		this.hashColumns.put("bkg_d221", getBkgD221());
		this.hashColumns.put("gid", getGid());
		this.hashColumns.put("bkg_rf21", getBkgRf21());
		this.hashColumns.put("bkg_5321", getBkg5321());
		this.hashColumns.put("bkg_2031", getBkg2031());
		this.hashColumns.put("pref_rf51", getPrefRf51());
		this.hashColumns.put("oth_cust_nm", getOthCustNm());
		this.hashColumns.put("alc_rf51", getAlcRf51());
		this.hashColumns.put("bkg11", getBkg11());
		this.hashColumns.put("bkg_r241", getBkgR241());
		this.hashColumns.put("cust_no", getCustNo());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("fct41", getFct41());
		this.hashColumns.put("fct31", getFct31());
		this.hashColumns.put("max_qty31", getMaxQty31());
		this.hashColumns.put("alc21", getAlc21());
		this.hashColumns.put("cm_op41", getCmOp41());
		this.hashColumns.put("bkg_4511", getBkg4511());
		this.hashColumns.put("bkg_hc31", getBkgHc31());
		this.hashColumns.put("cm_vl41", getCmVl41());
		this.hashColumns.put("port4", getPort4());
		this.hashColumns.put("cfct51", getCfct51());
		this.hashColumns.put("qta51", getQta51());
		this.hashColumns.put("port3", getPort3());
		this.hashColumns.put("bkg_avg_qty11", getBkgAvgQty11());
		this.hashColumns.put("port2", getPort2());
		this.hashColumns.put("port1", getPort1());
		this.hashColumns.put("port6", getPort6());
		this.hashColumns.put("port5", getPort5());
		this.hashColumns.put("bkg_4021", getBkg4021());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("bkg_2021", getBkg2021());
		this.hashColumns.put("bkg_d421", getBkgD421());
		this.hashColumns.put("bkg_rf11", getBkgRf11());
		this.hashColumns.put("aq_cd", getAqCd());
		this.hashColumns.put("bkg_5351", getBkg5351());
		this.hashColumns.put("bkg_r561", getBkgR561());
		this.hashColumns.put("cm_oc11", getCmOc11());
		this.hashColumns.put("bkg_r251", getBkgR251());
		this.hashColumns.put("bkg_hc21", getBkgHc21());
		this.hashColumns.put("cnt", getCnt());
		this.hashColumns.put("bsa_avg", getBsaAvg());
		this.hashColumns.put("alc31", getAlc31());
		this.hashColumns.put("fct21", getFct21());
		this.hashColumns.put("cust_clss", getCustClss());
		this.hashColumns.put("fct51", getFct51());
		this.hashColumns.put("cm_vl31", getCmVl31());
		this.hashColumns.put("pref61", getPref61());
		this.hashColumns.put("cm_op31", getCmOp31());
		this.hashColumns.put("bkg_4521", getBkg4521());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("sub_ofc_cd", getSubOfcCd());
		this.hashColumns.put("bkg_rd11", getBkgRd11());
		this.hashColumns.put("cfct41", getCfct41());
		this.hashColumns.put("qta41", getQta41());
		this.hashColumns.put("bkg_avg_qty21", getBkgAvgQty21());
		this.hashColumns.put("dest", getDest());
		this.hashColumns.put("t", getT());
		this.hashColumns.put("bkg_4011", getBkg4011());
		this.hashColumns.put("max_qty41", getMaxQty41());
		this.hashColumns.put("bkg_d411", getBkgD411());
		this.hashColumns.put("bkg_5341", getBkg5341());
		this.hashColumns.put("bkg_2011", getBkg2011());
		this.hashColumns.put("bkg_d441", getBkgD441());
		this.hashColumns.put("cm_op21", getCmOp21());
		this.hashColumns.put("max_qty11", getMaxQty11());
		this.hashColumns.put("pref11", getPref11());
		this.hashColumns.put("bkg_rd61", getBkgRd61());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("cm_vl11", getCmVl11());
		this.hashColumns.put("bkg_4051", getBkg4051());
		this.hashColumns.put("bkg31", getBkg31());
		this.hashColumns.put("cm_oc21", getCmOc21());
		this.hashColumns.put("alc51", getAlc51());
		this.hashColumns.put("cm_vl21", getCmVl21());
		this.hashColumns.put("acct_tp", getAcctTp());
		this.hashColumns.put("pref_rf21", getPrefRf21());
		this.hashColumns.put("bkg_hc51", getBkgHc51());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("alc_rf21", getAlcRf21());
		this.hashColumns.put("qta31", getQta31());
		this.hashColumns.put("bkg_rf61", getBkgRf61());
		this.hashColumns.put("bkg_r261", getBkgR261());
		this.hashColumns.put("bkg_d251", getBkgD251());
		this.hashColumns.put("cfct31", getCfct31());
		this.hashColumns.put("cm_op11", getCmOp11());
		this.hashColumns.put("cust_grp_id", getCustGrpId());
		this.hashColumns.put("max_qty21", getMaxQty21());
		this.hashColumns.put("pref21", getPref21());
		this.hashColumns.put("bkg_d431", getBkgD431());
		this.hashColumns.put("bkg41", getBkg41());
		this.hashColumns.put("cm_oc31", getCmOc31());
		this.hashColumns.put("bkg_4061", getBkg4061());
		this.hashColumns.put("pref_rf11", getPrefRf11());
		this.hashColumns.put("bkg_d261", getBkgD261());
		this.hashColumns.put("alc_rf11", getAlcRf11());
		this.hashColumns.put("alc41", getAlc41());
		this.hashColumns.put("bkg_hc41", getBkgHc41());
		this.hashColumns.put("qta21", getQta21());
		this.hashColumns.put("cfct21", getCfct21());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("bkg_5361", getBkg5361());
		this.hashColumns.put("pref31", getPref31());
		this.hashColumns.put("bkg_r511", getBkgR511());
		this.hashColumns.put("bkg_d461", getBkgD461());
		this.hashColumns.put("bkg_avg_qty61", getBkgAvgQty61());
		this.hashColumns.put("bkg_rd41", getBkgRd41());
		this.hashColumns.put("bkg_4031", getBkg4031());
		this.hashColumns.put("bkg51", getBkg51());
		this.hashColumns.put("cm_oc41", getCmOc41());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("alc_rf41", getAlcRf41());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_5311", getBkg5311());
		this.hashColumns.put("bkg_4551", getBkg4551());
		this.hashColumns.put("pref_rf41", getPrefRf41());
		this.hashColumns.put("bsa5", getBsa5());
		this.hashColumns.put("bsa4", getBsa4());
		this.hashColumns.put("bsa6", getBsa6());
		this.hashColumns.put("bkg_d231", getBkgD231());
		this.hashColumns.put("cfct11", getCfct11());
		this.hashColumns.put("qta11", getQta11());
		this.hashColumns.put("bsa1", getBsa1());
		this.hashColumns.put("bkg_rf41", getBkgRf41());
		this.hashColumns.put("bsa3", getBsa3());
		this.hashColumns.put("bkg_2061", getBkg2061());
		this.hashColumns.put("bsa2", getBsa2());
		this.hashColumns.put("pref41", getPref41());
		this.hashColumns.put("bkg_r521", getBkgR521());
		this.hashColumns.put("bkg_d451", getBkgD451());
		this.hashColumns.put("bkg_rd51", getBkgRd51());
		this.hashColumns.put("bkg_4041", getBkg4041());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("bkg61", getBkg61());
		this.hashColumns.put("cm_oc51", getCmOc51());
		this.hashColumns.put("bkg_r211", getBkgR211());
		this.hashColumns.put("alc_rf31", getAlcRf31());
		this.hashColumns.put("alc61", getAlc61());
		this.hashColumns.put("bkg_4561", getBkg4561());
		this.hashColumns.put("bkg_2051", getBkg2051());
		this.hashColumns.put("bkg_hc61", getBkgHc61());
		this.hashColumns.put("pref_rf31", getPrefRf31());
		this.hashColumns.put("bkg_d241", getBkgD241());
		this.hashColumns.put("bkg_rf51", getBkgRf51());
		this.hashColumns.put("pref51", getPref51());
		this.hashColumns.put("bkg_r531", getBkgR531());
		this.hashColumns.put("usa_bkg_mod_cd", getUsaBkgModCd());
		this.hashColumns.put("dest_loc_cd", getDestLocCd());
		this.hashColumns.put("acct_cd", getAcctCd());
		
		this.hashColumns.put("ratio51", getRatio51());
		this.hashColumns.put("cm41", getCm41());
		this.hashColumns.put("ratio11", getRatio11());
		this.hashColumns.put("ratio31", getRatio31());
		this.hashColumns.put("cm21", getCm21());
		this.hashColumns.put("ratio21", getRatio21());
		this.hashColumns.put("cm11", getCm11());
		this.hashColumns.put("cm51", getCm51());
		this.hashColumns.put("ratio61", getRatio61());
		this.hashColumns.put("cm61", getCm61());
		this.hashColumns.put("ratio41", getRatio41());
		this.hashColumns.put("cm31", getCm31());
		this.hashColumns.put("cmb31", getCmb31());
		this.hashColumns.put("cmb41", getCmb41());
		this.hashColumns.put("cmb61", getCmb61());
		this.hashColumns.put("cmb11", getCmb11());
		this.hashColumns.put("cmb51", getCmb51());
		this.hashColumns.put("cmb21", getCmb21());
		this.hashColumns.put("cm_en11", getCmEn11());
		this.hashColumns.put("cm_en21", getCmEn21());
		this.hashColumns.put("cm_en31", getCmEn31());
		this.hashColumns.put("cm_en41", getCmEn41());
		this.hashColumns.put("cm_en51", getCmEn51());
		this.hashColumns.put("cm_en61", getCmEn61());		
		this.hashColumns.put("pref11", getPrf11());
		this.hashColumns.put("pref21", getPrf21());
		this.hashColumns.put("pref31", getPrf31());
		this.hashColumns.put("pref41", getPrf41());
		this.hashColumns.put("pref51", getPrf51());
		this.hashColumns.put("pref61", getPrf61());		
		this.hashColumns.put("bsaw1", getBsaw1());
		this.hashColumns.put("bsaw2", getBsaw2());
		this.hashColumns.put("bsaw3", getBsaw3());
		this.hashColumns.put("bsaw4", getBsaw4());
		this.hashColumns.put("bsaw5", getBsaw5());
		this.hashColumns.put("bsaw6", getBsaw6());
		this.hashColumns.put("bkgw1", getBkgw1());
		this.hashColumns.put("bkgw2", getBkgw2());
		this.hashColumns.put("bkgw3", getBkgw3());
		this.hashColumns.put("bkgw4", getBkgw4());
		this.hashColumns.put("bkgw5", getBkgw5());
		this.hashColumns.put("bkgw6", getBkgw6());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_r221", "bkgR221");
		this.hashFields.put("bkg_hc11", "bkgHc11");
		this.hashFields.put("cm_op61", "cmOp61");
		this.hashFields.put("bkg_r551", "bkgR551");
		this.hashFields.put("bkg_rd21", "bkgRd21");
		this.hashFields.put("bkg_avg_qty41", "bkgAvgQty41");
		this.hashFields.put("fct61", "fct61");
		this.hashFields.put("bkg_4531", "bkg4531");
		this.hashFields.put("cust_ctrl_cd", "custCtrlCd");
		this.hashFields.put("cm_vl61", "cmVl61");
		this.hashFields.put("fct11", "fct11");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("max_qty51", "maxQty51");
		this.hashFields.put("cm_oc61", "cmOc61");
		this.hashFields.put("bkg_d211", "bkgD211");
		this.hashFields.put("alc_rf61", "alcRf61");
		this.hashFields.put("bkg_avg_qty31", "bkgAvgQty31");
		this.hashFields.put("cust_grp_nm", "custGrpNm");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("bkg_5331", "bkg5331");
		this.hashFields.put("bkg_rf31", "bkgRf31");
		this.hashFields.put("bkg_2041", "bkg2041");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("pref_rf61", "prefRf61");
		this.hashFields.put("bkg21", "bkg21");
		this.hashFields.put("bkg_r231", "bkgR231");
		this.hashFields.put("alc11", "alc11");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("cm_op51", "cmOp51");
		this.hashFields.put("bkg_r541", "bkgR541");
		this.hashFields.put("cm_vl51", "cmVl51");
		this.hashFields.put("cfct61", "cfct61");
		this.hashFields.put("bkg_avg_qty51", "bkgAvgQty51");
		this.hashFields.put("bkg_4541", "bkg4541");
		this.hashFields.put("bkg_rd31", "bkgRd31");
		this.hashFields.put("vvd2", "vvd2");
		this.hashFields.put("vvd3", "vvd3");
		this.hashFields.put("vvd1", "vvd1");
		this.hashFields.put("max_qty61", "maxQty61");
		this.hashFields.put("vvd6", "vvd6");
		this.hashFields.put("vvd5", "vvd5");
		this.hashFields.put("vvd4", "vvd4");
		this.hashFields.put("qta61", "qta61");
		this.hashFields.put("bkg_d221", "bkgD221");
		this.hashFields.put("gid", "gid");
		this.hashFields.put("bkg_rf21", "bkgRf21");
		this.hashFields.put("bkg_5321", "bkg5321");
		this.hashFields.put("bkg_2031", "bkg2031");
		this.hashFields.put("pref_rf51", "prefRf51");
		this.hashFields.put("oth_cust_nm", "othCustNm");
		this.hashFields.put("alc_rf51", "alcRf51");
		this.hashFields.put("bkg11", "bkg11");
		this.hashFields.put("bkg_r241", "bkgR241");
		this.hashFields.put("cust_no", "custNo");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("fct41", "fct41");
		this.hashFields.put("fct31", "fct31");
		this.hashFields.put("max_qty31", "maxQty31");
		this.hashFields.put("alc21", "alc21");
		this.hashFields.put("cm_op41", "cmOp41");
		this.hashFields.put("bkg_4511", "bkg4511");
		this.hashFields.put("bkg_hc31", "bkgHc31");
		this.hashFields.put("cm_vl41", "cmVl41");
		this.hashFields.put("port4", "port4");
		this.hashFields.put("cfct51", "cfct51");
		this.hashFields.put("qta51", "qta51");
		this.hashFields.put("port3", "port3");
		this.hashFields.put("bkg_avg_qty11", "bkgAvgQty11");
		this.hashFields.put("port2", "port2");
		this.hashFields.put("port1", "port1");
		this.hashFields.put("port6", "port6");
		this.hashFields.put("port5", "port5");
		this.hashFields.put("bkg_4021", "bkg4021");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("bkg_2021", "bkg2021");
		this.hashFields.put("bkg_d421", "bkgD421");
		this.hashFields.put("bkg_rf11", "bkgRf11");
		this.hashFields.put("aq_cd", "aqCd");
		this.hashFields.put("bkg_5351", "bkg5351");
		this.hashFields.put("bkg_r561", "bkgR561");
		this.hashFields.put("cm_oc11", "cmOc11");
		this.hashFields.put("bkg_r251", "bkgR251");
		this.hashFields.put("bkg_hc21", "bkgHc21");
		this.hashFields.put("cnt", "cnt");
		this.hashFields.put("bsa_avg", "bsaAvg");
		this.hashFields.put("alc31", "alc31");
		this.hashFields.put("fct21", "fct21");
		this.hashFields.put("cust_clss", "custClss");
		this.hashFields.put("fct51", "fct51");
		this.hashFields.put("cm_vl31", "cmVl31");
		this.hashFields.put("pref61", "pref61");
		this.hashFields.put("cm_op31", "cmOp31");
		this.hashFields.put("bkg_4521", "bkg4521");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("sub_ofc_cd", "subOfcCd");
		this.hashFields.put("bkg_rd11", "bkgRd11");
		this.hashFields.put("cfct41", "cfct41");
		this.hashFields.put("qta41", "qta41");
		this.hashFields.put("bkg_avg_qty21", "bkgAvgQty21");
		this.hashFields.put("dest", "dest");
		this.hashFields.put("t", "t");
		this.hashFields.put("bkg_4011", "bkg4011");
		this.hashFields.put("max_qty41", "maxQty41");
		this.hashFields.put("bkg_d411", "bkgD411");
		this.hashFields.put("bkg_5341", "bkg5341");
		this.hashFields.put("bkg_2011", "bkg2011");
		this.hashFields.put("bkg_d441", "bkgD441");
		this.hashFields.put("cm_op21", "cmOp21");
		this.hashFields.put("max_qty11", "maxQty11");
		this.hashFields.put("pref11", "pref11");
		this.hashFields.put("bkg_rd61", "bkgRd61");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("cm_vl11", "cmVl11");
		this.hashFields.put("bkg_4051", "bkg4051");
		this.hashFields.put("bkg31", "bkg31");
		this.hashFields.put("cm_oc21", "cmOc21");
		this.hashFields.put("alc51", "alc51");
		this.hashFields.put("cm_vl21", "cmVl21");
		this.hashFields.put("acct_tp", "acctTp");
		this.hashFields.put("pref_rf21", "prefRf21");
		this.hashFields.put("bkg_hc51", "bkgHc51");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("alc_rf21", "alcRf21");
		this.hashFields.put("qta31", "qta31");
		this.hashFields.put("bkg_rf61", "bkgRf61");
		this.hashFields.put("bkg_r261", "bkgR261");
		this.hashFields.put("bkg_d251", "bkgD251");
		this.hashFields.put("cfct31", "cfct31");
		this.hashFields.put("cm_op11", "cmOp11");
		this.hashFields.put("cust_grp_id", "custGrpId");
		this.hashFields.put("max_qty21", "maxQty21");
		this.hashFields.put("pref21", "pref21");
		this.hashFields.put("bkg_d431", "bkgD431");
		this.hashFields.put("bkg41", "bkg41");
		this.hashFields.put("cm_oc31", "cmOc31");
		this.hashFields.put("bkg_4061", "bkg4061");
		this.hashFields.put("pref_rf11", "prefRf11");
		this.hashFields.put("bkg_d261", "bkgD261");
		this.hashFields.put("alc_rf11", "alcRf11");
		this.hashFields.put("alc41", "alc41");
		this.hashFields.put("bkg_hc41", "bkgHc41");
		this.hashFields.put("qta21", "qta21");
		this.hashFields.put("cfct21", "cfct21");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("bkg_5361", "bkg5361");
		this.hashFields.put("pref31", "pref31");
		this.hashFields.put("bkg_r511", "bkgR511");
		this.hashFields.put("bkg_d461", "bkgD461");
		this.hashFields.put("bkg_avg_qty61", "bkgAvgQty61");
		this.hashFields.put("bkg_rd41", "bkgRd41");
		this.hashFields.put("bkg_4031", "bkg4031");
		this.hashFields.put("bkg51", "bkg51");
		this.hashFields.put("cm_oc41", "cmOc41");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("alc_rf41", "alcRf41");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_5311", "bkg5311");
		this.hashFields.put("bkg_4551", "bkg4551");
		this.hashFields.put("pref_rf41", "prefRf41");
		this.hashFields.put("bsa5", "bsa5");
		this.hashFields.put("bsa4", "bsa4");
		this.hashFields.put("bsa6", "bsa6");
		this.hashFields.put("bkg_d231", "bkgD231");
		this.hashFields.put("cfct11", "cfct11");
		this.hashFields.put("qta11", "qta11");
		this.hashFields.put("bsa1", "bsa1");
		this.hashFields.put("bkg_rf41", "bkgRf41");
		this.hashFields.put("bsa3", "bsa3");
		this.hashFields.put("bkg_2061", "bkg2061");
		this.hashFields.put("bsa2", "bsa2");
		this.hashFields.put("pref41", "pref41");
		this.hashFields.put("bkg_r521", "bkgR521");
		this.hashFields.put("bkg_d451", "bkgD451");
		this.hashFields.put("bkg_rd51", "bkgRd51");
		this.hashFields.put("bkg_4041", "bkg4041");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("bkg61", "bkg61");
		this.hashFields.put("cm_oc51", "cmOc51");
		this.hashFields.put("bkg_r211", "bkgR211");
		this.hashFields.put("alc_rf31", "alcRf31");
		this.hashFields.put("alc61", "alc61");
		this.hashFields.put("bkg_4561", "bkg4561");
		this.hashFields.put("bkg_2051", "bkg2051");
		this.hashFields.put("bkg_hc61", "bkgHc61");
		this.hashFields.put("pref_rf31", "prefRf31");
		this.hashFields.put("bkg_d241", "bkgD241");
		this.hashFields.put("bkg_rf51", "bkgRf51");
		this.hashFields.put("pref51", "pref51");
		this.hashFields.put("bkg_r531", "bkgR531");
		this.hashFields.put("usa_bkg_mod_cd", "usaBkgModCd");
		this.hashFields.put("dest_loc_cd", "destLocCd");
		this.hashFields.put("acct_cd", "acctCd");
		
		this.hashFields.put("ratio51", "ratio51");
		this.hashFields.put("cm41", "cm41");
		this.hashFields.put("ratio11", "ratio11");
		this.hashFields.put("ratio31", "ratio31");
		this.hashFields.put("cm21", "cm21");
		this.hashFields.put("ratio21", "ratio21");
		this.hashFields.put("cm11", "cm11");
		this.hashFields.put("cm51", "cm51");
		this.hashFields.put("ratio61", "ratio61");
		this.hashFields.put("cm61", "cm61");
		this.hashFields.put("ratio41", "ratio41");
		this.hashFields.put("cm31", "cm31");
		this.hashFields.put("cmb31", "cmb31");
		this.hashFields.put("cmb41", "cmb41");
		this.hashFields.put("cmb61", "cmb61");
		this.hashFields.put("cmb11", "cmb11");
		this.hashFields.put("cmb51", "cmb51");
		this.hashFields.put("cmb21", "cmb21");
		
		this.hashFields.put("cm_en11", "cmEn11");
		this.hashFields.put("cm_en21", "cmEn21");
		this.hashFields.put("cm_en31", "cmEn31");
		this.hashFields.put("cm_en41", "cmEn41");
		this.hashFields.put("cm_en51", "cmEn51");
		this.hashFields.put("cm_en61", "cmEn61");
		
		this.hashFields.put("prf11", "prf11");
		this.hashFields.put("prf21", "prf21");
		this.hashFields.put("prf31", "prf31");
		this.hashFields.put("prf41", "prf41");
		this.hashFields.put("prf51", "prf51");
		this.hashFields.put("prf61", "prf61");
		
		this.hashFields.put("bsaw1", "bsaw1");
		this.hashFields.put("bsaw2", "bsaw2");
		this.hashFields.put("bsaw3", "bsaw3");
		this.hashFields.put("bsaw4", "bsaw4");
		this.hashFields.put("bsaw5", "bsaw5");
		this.hashFields.put("bsaw6", "bsaw6");
		
		this.hashFields.put("bkgw1", "bkgw1");
		this.hashFields.put("bkgw2", "bkgw2");
		this.hashFields.put("bkgw3", "bkgw3");
		this.hashFields.put("bkgw4", "bkgw4");
		this.hashFields.put("bkgw5", "bkgw5");
		this.hashFields.put("bkgw6", "bkgw6");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgR221
	 */
	public String getBkgR221() {
		return this.bkgR221;
	}
	
	/**
	 * Column Info
	 * @return bkgHc11
	 */
	public String getBkgHc11() {
		return this.bkgHc11;
	}
	
	/**
	 * Column Info
	 * @return cmOp61
	 */
	public String getCmOp61() {
		return this.cmOp61;
	}
	
	/**
	 * Column Info
	 * @return bkgR551
	 */
	public String getBkgR551() {
		return this.bkgR551;
	}
	
	/**
	 * Column Info
	 * @return bkgRd21
	 */
	public String getBkgRd21() {
		return this.bkgRd21;
	}
	
	/**
	 * Column Info
	 * @return bkgAvgQty41
	 */
	public String getBkgAvgQty41() {
		return this.bkgAvgQty41;
	}
	
	/**
	 * Column Info
	 * @return fct61
	 */
	public String getFct61() {
		return this.fct61;
	}
	
	/**
	 * Column Info
	 * @return bkg4531
	 */
	public String getBkg4531() {
		return this.bkg4531;
	}
	
	/**
	 * Column Info
	 * @return custCtrlCd
	 */
	public String getCustCtrlCd() {
		return this.custCtrlCd;
	}
	
	/**
	 * Column Info
	 * @return cmVl61
	 */
	public String getCmVl61() {
		return this.cmVl61;
	}
	
	/**
	 * Column Info
	 * @return fct11
	 */
	public String getFct11() {
		return this.fct11;
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
	 * @return maxQty51
	 */
	public String getMaxQty51() {
		return this.maxQty51;
	}
	
	/**
	 * Column Info
	 * @return cmOc61
	 */
	public String getCmOc61() {
		return this.cmOc61;
	}
	
	/**
	 * Column Info
	 * @return bkgD211
	 */
	public String getBkgD211() {
		return this.bkgD211;
	}
	
	/**
	 * Column Info
	 * @return alcRf61
	 */
	public String getAlcRf61() {
		return this.alcRf61;
	}
	
	/**
	 * Column Info
	 * @return bkgAvgQty31
	 */
	public String getBkgAvgQty31() {
		return this.bkgAvgQty31;
	}
	
	/**
	 * Column Info
	 * @return custGrpNm
	 */
	public String getCustGrpNm() {
		return this.custGrpNm;
	}
	
	/**
	 * Column Info
	 * @return ctrtOfcCd
	 */
	public String getCtrtOfcCd() {
		return this.ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @return bkg5331
	 */
	public String getBkg5331() {
		return this.bkg5331;
	}
	
	/**
	 * Column Info
	 * @return bkgRf31
	 */
	public String getBkgRf31() {
		return this.bkgRf31;
	}
	
	/**
	 * Column Info
	 * @return bkg2041
	 */
	public String getBkg2041() {
		return this.bkg2041;
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
	 * @return prefRf61
	 */
	public String getPrefRf61() {
		return this.prefRf61;
	}
	
	/**
	 * Column Info
	 * @return bkg21
	 */
	public String getBkg21() {
		return this.bkg21;
	}
	
	/**
	 * Column Info
	 * @return bkgR231
	 */
	public String getBkgR231() {
		return this.bkgR231;
	}
	
	/**
	 * Column Info
	 * @return alc11
	 */
	public String getAlc11() {
		return this.alc11;
	}
	
	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return cmOp51
	 */
	public String getCmOp51() {
		return this.cmOp51;
	}
	
	/**
	 * Column Info
	 * @return bkgR541
	 */
	public String getBkgR541() {
		return this.bkgR541;
	}
	
	/**
	 * Column Info
	 * @return cmVl51
	 */
	public String getCmVl51() {
		return this.cmVl51;
	}
	
	/**
	 * Column Info
	 * @return cfct61
	 */
	public String getCfct61() {
		return this.cfct61;
	}
	
	/**
	 * Column Info
	 * @return bkgAvgQty51
	 */
	public String getBkgAvgQty51() {
		return this.bkgAvgQty51;
	}
	
	/**
	 * Column Info
	 * @return bkg4541
	 */
	public String getBkg4541() {
		return this.bkg4541;
	}
	
	/**
	 * Column Info
	 * @return bkgRd31
	 */
	public String getBkgRd31() {
		return this.bkgRd31;
	}
	
	/**
	 * Column Info
	 * @return vvd2
	 */
	public String getVvd2() {
		return this.vvd2;
	}
	
	/**
	 * Column Info
	 * @return vvd3
	 */
	public String getVvd3() {
		return this.vvd3;
	}
	
	/**
	 * Column Info
	 * @return vvd1
	 */
	public String getVvd1() {
		return this.vvd1;
	}
	
	/**
	 * Column Info
	 * @return maxQty61
	 */
	public String getMaxQty61() {
		return this.maxQty61;
	}
	
	/**
	 * Column Info
	 * @return vvd6
	 */
	public String getVvd6() {
		return this.vvd6;
	}
	
	/**
	 * Column Info
	 * @return vvd5
	 */
	public String getVvd5() {
		return this.vvd5;
	}
	
	/**
	 * Column Info
	 * @return vvd4
	 */
	public String getVvd4() {
		return this.vvd4;
	}
	
	/**
	 * Column Info
	 * @return qta61
	 */
	public String getQta61() {
		return this.qta61;
	}
	
	/**
	 * Column Info
	 * @return bkgD221
	 */
	public String getBkgD221() {
		return this.bkgD221;
	}
	
	/**
	 * Column Info
	 * @return gid
	 */
	public String getGid() {
		return this.gid;
	}
	
	/**
	 * Column Info
	 * @return bkgRf21
	 */
	public String getBkgRf21() {
		return this.bkgRf21;
	}
	
	/**
	 * Column Info
	 * @return bkg5321
	 */
	public String getBkg5321() {
		return this.bkg5321;
	}
	
	/**
	 * Column Info
	 * @return bkg2031
	 */
	public String getBkg2031() {
		return this.bkg2031;
	}
	
	/**
	 * Column Info
	 * @return prefRf51
	 */
	public String getPrefRf51() {
		return this.prefRf51;
	}
	
	/**
	 * Column Info
	 * @return othCustNm
	 */
	public String getOthCustNm() {
		return this.othCustNm;
	}
	
	/**
	 * Column Info
	 * @return alcRf51
	 */
	public String getAlcRf51() {
		return this.alcRf51;
	}
	
	/**
	 * Column Info
	 * @return bkg11
	 */
	public String getBkg11() {
		return this.bkg11;
	}
	
	/**
	 * Column Info
	 * @return bkgR241
	 */
	public String getBkgR241() {
		return this.bkgR241;
	}
	
	/**
	 * Column Info
	 * @return custNo
	 */
	public String getCustNo() {
		return this.custNo;
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
	 * @return fct41
	 */
	public String getFct41() {
		return this.fct41;
	}
	
	/**
	 * Column Info
	 * @return fct31
	 */
	public String getFct31() {
		return this.fct31;
	}
	
	/**
	 * Column Info
	 * @return maxQty31
	 */
	public String getMaxQty31() {
		return this.maxQty31;
	}
	
	/**
	 * Column Info
	 * @return alc21
	 */
	public String getAlc21() {
		return this.alc21;
	}
	
	/**
	 * Column Info
	 * @return cmOp41
	 */
	public String getCmOp41() {
		return this.cmOp41;
	}
	
	/**
	 * Column Info
	 * @return bkg4511
	 */
	public String getBkg4511() {
		return this.bkg4511;
	}
	
	/**
	 * Column Info
	 * @return bkgHc31
	 */
	public String getBkgHc31() {
		return this.bkgHc31;
	}
	
	/**
	 * Column Info
	 * @return cmVl41
	 */
	public String getCmVl41() {
		return this.cmVl41;
	}
	
	/**
	 * Column Info
	 * @return port4
	 */
	public String getPort4() {
		return this.port4;
	}
	
	/**
	 * Column Info
	 * @return cfct51
	 */
	public String getCfct51() {
		return this.cfct51;
	}
	
	/**
	 * Column Info
	 * @return qta51
	 */
	public String getQta51() {
		return this.qta51;
	}
	
	/**
	 * Column Info
	 * @return port3
	 */
	public String getPort3() {
		return this.port3;
	}
	
	/**
	 * Column Info
	 * @return bkgAvgQty11
	 */
	public String getBkgAvgQty11() {
		return this.bkgAvgQty11;
	}
	
	/**
	 * Column Info
	 * @return port2
	 */
	public String getPort2() {
		return this.port2;
	}
	
	/**
	 * Column Info
	 * @return port1
	 */
	public String getPort1() {
		return this.port1;
	}
	
	/**
	 * Column Info
	 * @return port6
	 */
	public String getPort6() {
		return this.port6;
	}
	
	/**
	 * Column Info
	 * @return port5
	 */
	public String getPort5() {
		return this.port5;
	}
	
	/**
	 * Column Info
	 * @return bkg4021
	 */
	public String getBkg4021() {
		return this.bkg4021;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return bkg2021
	 */
	public String getBkg2021() {
		return this.bkg2021;
	}
	
	/**
	 * Column Info
	 * @return bkgD421
	 */
	public String getBkgD421() {
		return this.bkgD421;
	}
	
	/**
	 * Column Info
	 * @return bkgRf11
	 */
	public String getBkgRf11() {
		return this.bkgRf11;
	}
	
	/**
	 * Column Info
	 * @return aqCd
	 */
	public String getAqCd() {
		return this.aqCd;
	}
	
	/**
	 * Column Info
	 * @return bkg5351
	 */
	public String getBkg5351() {
		return this.bkg5351;
	}
	
	/**
	 * Column Info
	 * @return bkgR561
	 */
	public String getBkgR561() {
		return this.bkgR561;
	}
	
	/**
	 * Column Info
	 * @return cmOc11
	 */
	public String getCmOc11() {
		return this.cmOc11;
	}
	
	/**
	 * Column Info
	 * @return bkgR251
	 */
	public String getBkgR251() {
		return this.bkgR251;
	}
	
	/**
	 * Column Info
	 * @return bkgHc21
	 */
	public String getBkgHc21() {
		return this.bkgHc21;
	}
	
	/**
	 * Column Info
	 * @return cnt
	 */
	public String getCnt() {
		return this.cnt;
	}
	
	/**
	 * Column Info
	 * @return bsaAvg
	 */
	public String getBsaAvg() {
		return this.bsaAvg;
	}
	
	/**
	 * Column Info
	 * @return alc31
	 */
	public String getAlc31() {
		return this.alc31;
	}
	
	/**
	 * Column Info
	 * @return fct21
	 */
	public String getFct21() {
		return this.fct21;
	}
	
	/**
	 * Column Info
	 * @return custClss
	 */
	public String getCustClss() {
		return this.custClss;
	}
	
	/**
	 * Column Info
	 * @return fct51
	 */
	public String getFct51() {
		return this.fct51;
	}
	
	/**
	 * Column Info
	 * @return cmVl31
	 */
	public String getCmVl31() {
		return this.cmVl31;
	}
	
	/**
	 * Column Info
	 * @return pref61
	 */
	public String getPref61() {
		return this.pref61;
	}
	
	/**
	 * Column Info
	 * @return cmOp31
	 */
	public String getCmOp31() {
		return this.cmOp31;
	}
	
	/**
	 * Column Info
	 * @return bkg4521
	 */
	public String getBkg4521() {
		return this.bkg4521;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return subOfcCd
	 */
	public String getSubOfcCd() {
		return this.subOfcCd;
	}
	
	/**
	 * Column Info
	 * @return bkgRd11
	 */
	public String getBkgRd11() {
		return this.bkgRd11;
	}
	
	/**
	 * Column Info
	 * @return cfct41
	 */
	public String getCfct41() {
		return this.cfct41;
	}
	
	/**
	 * Column Info
	 * @return qta41
	 */
	public String getQta41() {
		return this.qta41;
	}
	
	/**
	 * Column Info
	 * @return bkgAvgQty21
	 */
	public String getBkgAvgQty21() {
		return this.bkgAvgQty21;
	}
	
	/**
	 * Column Info
	 * @return dest
	 */
	public String getDest() {
		return this.dest;
	}
	
	/**
	 * Column Info
	 * @return t
	 */
	public String getT() {
		return this.t;
	}
	
	/**
	 * Column Info
	 * @return bkg4011
	 */
	public String getBkg4011() {
		return this.bkg4011;
	}
	
	/**
	 * Column Info
	 * @return maxQty41
	 */
	public String getMaxQty41() {
		return this.maxQty41;
	}
	
	/**
	 * Column Info
	 * @return bkgD411
	 */
	public String getBkgD411() {
		return this.bkgD411;
	}
	
	/**
	 * Column Info
	 * @return bkg5341
	 */
	public String getBkg5341() {
		return this.bkg5341;
	}
	
	/**
	 * Column Info
	 * @return bkg2011
	 */
	public String getBkg2011() {
		return this.bkg2011;
	}
	
	/**
	 * Column Info
	 * @return bkgD441
	 */
	public String getBkgD441() {
		return this.bkgD441;
	}
	
	/**
	 * Column Info
	 * @return cmOp21
	 */
	public String getCmOp21() {
		return this.cmOp21;
	}
	
	/**
	 * Column Info
	 * @return maxQty11
	 */
	public String getMaxQty11() {
		return this.maxQty11;
	}
	
	/**
	 * Column Info
	 * @return pref11
	 */
	public String getPref11() {
		return this.pref11;
	}
	
	/**
	 * Column Info
	 * @return bkgRd61
	 */
	public String getBkgRd61() {
		return this.bkgRd61;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return cmVl11
	 */
	public String getCmVl11() {
		return this.cmVl11;
	}
	
	/**
	 * Column Info
	 * @return bkg4051
	 */
	public String getBkg4051() {
		return this.bkg4051;
	}
	
	/**
	 * Column Info
	 * @return bkg31
	 */
	public String getBkg31() {
		return this.bkg31;
	}
	
	/**
	 * Column Info
	 * @return cmOc21
	 */
	public String getCmOc21() {
		return this.cmOc21;
	}
	
	/**
	 * Column Info
	 * @return alc51
	 */
	public String getAlc51() {
		return this.alc51;
	}
	
	/**
	 * Column Info
	 * @return cmVl21
	 */
	public String getCmVl21() {
		return this.cmVl21;
	}
	
	/**
	 * Column Info
	 * @return acctTp
	 */
	public String getAcctTp() {
		return this.acctTp;
	}
	
	/**
	 * Column Info
	 * @return prefRf21
	 */
	public String getPrefRf21() {
		return this.prefRf21;
	}
	
	/**
	 * Column Info
	 * @return bkgHc51
	 */
	public String getBkgHc51() {
		return this.bkgHc51;
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
	 * @return alcRf21
	 */
	public String getAlcRf21() {
		return this.alcRf21;
	}
	
	/**
	 * Column Info
	 * @return qta31
	 */
	public String getQta31() {
		return this.qta31;
	}
	
	/**
	 * Column Info
	 * @return bkgRf61
	 */
	public String getBkgRf61() {
		return this.bkgRf61;
	}
	
	/**
	 * Column Info
	 * @return bkgR261
	 */
	public String getBkgR261() {
		return this.bkgR261;
	}
	
	/**
	 * Column Info
	 * @return bkgD251
	 */
	public String getBkgD251() {
		return this.bkgD251;
	}
	
	/**
	 * Column Info
	 * @return cfct31
	 */
	public String getCfct31() {
		return this.cfct31;
	}
	
	/**
	 * Column Info
	 * @return cmOp11
	 */
	public String getCmOp11() {
		return this.cmOp11;
	}
	
	/**
	 * Column Info
	 * @return custGrpId
	 */
	public String getCustGrpId() {
		return this.custGrpId;
	}
	
	/**
	 * Column Info
	 * @return maxQty21
	 */
	public String getMaxQty21() {
		return this.maxQty21;
	}
	
	/**
	 * Column Info
	 * @return pref21
	 */
	public String getPref21() {
		return this.pref21;
	}
	
	/**
	 * Column Info
	 * @return bkgD431
	 */
	public String getBkgD431() {
		return this.bkgD431;
	}
	
	/**
	 * Column Info
	 * @return bkg41
	 */
	public String getBkg41() {
		return this.bkg41;
	}
	
	/**
	 * Column Info
	 * @return cmOc31
	 */
	public String getCmOc31() {
		return this.cmOc31;
	}
	
	/**
	 * Column Info
	 * @return bkg4061
	 */
	public String getBkg4061() {
		return this.bkg4061;
	}
	
	/**
	 * Column Info
	 * @return prefRf11
	 */
	public String getPrefRf11() {
		return this.prefRf11;
	}
	
	/**
	 * Column Info
	 * @return bkgD261
	 */
	public String getBkgD261() {
		return this.bkgD261;
	}
	
	/**
	 * Column Info
	 * @return alcRf11
	 */
	public String getAlcRf11() {
		return this.alcRf11;
	}
	
	/**
	 * Column Info
	 * @return alc41
	 */
	public String getAlc41() {
		return this.alc41;
	}
	
	/**
	 * Column Info
	 * @return bkgHc41
	 */
	public String getBkgHc41() {
		return this.bkgHc41;
	}
	
	/**
	 * Column Info
	 * @return qta21
	 */
	public String getQta21() {
		return this.qta21;
	}
	
	/**
	 * Column Info
	 * @return cfct21
	 */
	public String getCfct21() {
		return this.cfct21;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	
	/**
	 * Column Info
	 * @return bkg5361
	 */
	public String getBkg5361() {
		return this.bkg5361;
	}
	
	/**
	 * Column Info
	 * @return pref31
	 */
	public String getPref31() {
		return this.pref31;
	}
	
	/**
	 * Column Info
	 * @return bkgR511
	 */
	public String getBkgR511() {
		return this.bkgR511;
	}
	
	/**
	 * Column Info
	 * @return bkgD461
	 */
	public String getBkgD461() {
		return this.bkgD461;
	}
	
	/**
	 * Column Info
	 * @return bkgAvgQty61
	 */
	public String getBkgAvgQty61() {
		return this.bkgAvgQty61;
	}
	
	/**
	 * Column Info
	 * @return bkgRd41
	 */
	public String getBkgRd41() {
		return this.bkgRd41;
	}
	
	/**
	 * Column Info
	 * @return bkg4031
	 */
	public String getBkg4031() {
		return this.bkg4031;
	}
	
	/**
	 * Column Info
	 * @return bkg51
	 */
	public String getBkg51() {
		return this.bkg51;
	}
	
	/**
	 * Column Info
	 * @return cmOc41
	 */
	public String getCmOc41() {
		return this.cmOc41;
	}
	
	/**
	 * Column Info
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
	}
	
	/**
	 * Column Info
	 * @return alcRf41
	 */
	public String getAlcRf41() {
		return this.alcRf41;
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
	 * @return bkg5311
	 */
	public String getBkg5311() {
		return this.bkg5311;
	}
	
	/**
	 * Column Info
	 * @return bkg4551
	 */
	public String getBkg4551() {
		return this.bkg4551;
	}
	
	/**
	 * Column Info
	 * @return prefRf41
	 */
	public String getPrefRf41() {
		return this.prefRf41;
	}
	
	/**
	 * Column Info
	 * @return bsa5
	 */
	public String getBsa5() {
		return this.bsa5;
	}
	
	/**
	 * Column Info
	 * @return bsa4
	 */
	public String getBsa4() {
		return this.bsa4;
	}
	
	/**
	 * Column Info
	 * @return bsa6
	 */
	public String getBsa6() {
		return this.bsa6;
	}
	
	/**
	 * Column Info
	 * @return bkgD231
	 */
	public String getBkgD231() {
		return this.bkgD231;
	}
	
	/**
	 * Column Info
	 * @return cfct11
	 */
	public String getCfct11() {
		return this.cfct11;
	}
	
	/**
	 * Column Info
	 * @return qta11
	 */
	public String getQta11() {
		return this.qta11;
	}
	
	/**
	 * Column Info
	 * @return bsa1
	 */
	public String getBsa1() {
		return this.bsa1;
	}
	
	/**
	 * Column Info
	 * @return bkgRf41
	 */
	public String getBkgRf41() {
		return this.bkgRf41;
	}
	
	/**
	 * Column Info
	 * @return bsa3
	 */
	public String getBsa3() {
		return this.bsa3;
	}
	
	/**
	 * Column Info
	 * @return bkg2061
	 */
	public String getBkg2061() {
		return this.bkg2061;
	}
	
	/**
	 * Column Info
	 * @return bsa2
	 */
	public String getBsa2() {
		return this.bsa2;
	}
	
	/**
	 * Column Info
	 * @return pref41
	 */
	public String getPref41() {
		return this.pref41;
	}
	
	/**
	 * Column Info
	 * @return bkgR521
	 */
	public String getBkgR521() {
		return this.bkgR521;
	}
	
	/**
	 * Column Info
	 * @return bkgD451
	 */
	public String getBkgD451() {
		return this.bkgD451;
	}
	
	/**
	 * Column Info
	 * @return bkgRd51
	 */
	public String getBkgRd51() {
		return this.bkgRd51;
	}
	
	/**
	 * Column Info
	 * @return bkg4041
	 */
	public String getBkg4041() {
		return this.bkg4041;
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
	 * @return bkg61
	 */
	public String getBkg61() {
		return this.bkg61;
	}
	
	/**
	 * Column Info
	 * @return cmOc51
	 */
	public String getCmOc51() {
		return this.cmOc51;
	}
	
	/**
	 * Column Info
	 * @return bkgR211
	 */
	public String getBkgR211() {
		return this.bkgR211;
	}
	
	/**
	 * Column Info
	 * @return alcRf31
	 */
	public String getAlcRf31() {
		return this.alcRf31;
	}
	
	/**
	 * Column Info
	 * @return alc61
	 */
	public String getAlc61() {
		return this.alc61;
	}
	
	/**
	 * Column Info
	 * @return bkg4561
	 */
	public String getBkg4561() {
		return this.bkg4561;
	}
	
	/**
	 * Column Info
	 * @return bkg2051
	 */
	public String getBkg2051() {
		return this.bkg2051;
	}
	
	/**
	 * Column Info
	 * @return bkgHc61
	 */
	public String getBkgHc61() {
		return this.bkgHc61;
	}
	
	/**
	 * Column Info
	 * @return prefRf31
	 */
	public String getPrefRf31() {
		return this.prefRf31;
	}
	
	/**
	 * Column Info
	 * @return bkgD241
	 */
	public String getBkgD241() {
		return this.bkgD241;
	}
	
	/**
	 * Column Info
	 * @return bkgRf51
	 */
	public String getBkgRf51() {
		return this.bkgRf51;
	}
	
	/**
	 * Column Info
	 * @return pref51
	 */
	public String getPref51() {
		return this.pref51;
	}
	
	/**
	 * Column Info
	 * @return bkgR531
	 */
	public String getBkgR531() {
		return this.bkgR531;
	}
	

	/**
	 * Column Info
	 * @param bkgR221
	 */
	public void setBkgR221(String bkgR221) {
		this.bkgR221 = bkgR221;
	}
	
	/**
	 * Column Info
	 * @param bkgHc11
	 */
	public void setBkgHc11(String bkgHc11) {
		this.bkgHc11 = bkgHc11;
	}
	
	/**
	 * Column Info
	 * @param cmOp61
	 */
	public void setCmOp61(String cmOp61) {
		this.cmOp61 = cmOp61;
	}
	
	/**
	 * Column Info
	 * @param bkgR551
	 */
	public void setBkgR551(String bkgR551) {
		this.bkgR551 = bkgR551;
	}
	
	/**
	 * Column Info
	 * @param bkgRd21
	 */
	public void setBkgRd21(String bkgRd21) {
		this.bkgRd21 = bkgRd21;
	}
	
	/**
	 * Column Info
	 * @param bkgAvgQty41
	 */
	public void setBkgAvgQty41(String bkgAvgQty41) {
		this.bkgAvgQty41 = bkgAvgQty41;
	}
	
	/**
	 * Column Info
	 * @param fct61
	 */
	public void setFct61(String fct61) {
		this.fct61 = fct61;
	}
	
	/**
	 * Column Info
	 * @param bkg4531
	 */
	public void setBkg4531(String bkg4531) {
		this.bkg4531 = bkg4531;
	}
	
	/**
	 * Column Info
	 * @param custCtrlCd
	 */
	public void setCustCtrlCd(String custCtrlCd) {
		this.custCtrlCd = custCtrlCd;
	}
	
	/**
	 * Column Info
	 * @param cmVl61
	 */
	public void setCmVl61(String cmVl61) {
		this.cmVl61 = cmVl61;
	}
	
	/**
	 * Column Info
	 * @param fct11
	 */
	public void setFct11(String fct11) {
		this.fct11 = fct11;
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
	 * @param maxQty51
	 */
	public void setMaxQty51(String maxQty51) {
		this.maxQty51 = maxQty51;
	}
	
	/**
	 * Column Info
	 * @param cmOc61
	 */
	public void setCmOc61(String cmOc61) {
		this.cmOc61 = cmOc61;
	}
	
	/**
	 * Column Info
	 * @param bkgD211
	 */
	public void setBkgD211(String bkgD211) {
		this.bkgD211 = bkgD211;
	}
	
	/**
	 * Column Info
	 * @param alcRf61
	 */
	public void setAlcRf61(String alcRf61) {
		this.alcRf61 = alcRf61;
	}
	
	/**
	 * Column Info
	 * @param bkgAvgQty31
	 */
	public void setBkgAvgQty31(String bkgAvgQty31) {
		this.bkgAvgQty31 = bkgAvgQty31;
	}
	
	/**
	 * Column Info
	 * @param custGrpNm
	 */
	public void setCustGrpNm(String custGrpNm) {
		this.custGrpNm = custGrpNm;
	}
	
	/**
	 * Column Info
	 * @param ctrtOfcCd
	 */
	public void setCtrtOfcCd(String ctrtOfcCd) {
		this.ctrtOfcCd = ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @param bkg5331
	 */
	public void setBkg5331(String bkg5331) {
		this.bkg5331 = bkg5331;
	}
	
	/**
	 * Column Info
	 * @param bkgRf31
	 */
	public void setBkgRf31(String bkgRf31) {
		this.bkgRf31 = bkgRf31;
	}
	
	/**
	 * Column Info
	 * @param bkg2041
	 */
	public void setBkg2041(String bkg2041) {
		this.bkg2041 = bkg2041;
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
	 * @param prefRf61
	 */
	public void setPrefRf61(String prefRf61) {
		this.prefRf61 = prefRf61;
	}
	
	/**
	 * Column Info
	 * @param bkg21
	 */
	public void setBkg21(String bkg21) {
		this.bkg21 = bkg21;
	}
	
	/**
	 * Column Info
	 * @param bkgR231
	 */
	public void setBkgR231(String bkgR231) {
		this.bkgR231 = bkgR231;
	}
	
	/**
	 * Column Info
	 * @param alc11
	 */
	public void setAlc11(String alc11) {
		this.alc11 = alc11;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param cmOp51
	 */
	public void setCmOp51(String cmOp51) {
		this.cmOp51 = cmOp51;
	}
	
	/**
	 * Column Info
	 * @param bkgR541
	 */
	public void setBkgR541(String bkgR541) {
		this.bkgR541 = bkgR541;
	}
	
	/**
	 * Column Info
	 * @param cmVl51
	 */
	public void setCmVl51(String cmVl51) {
		this.cmVl51 = cmVl51;
	}
	
	/**
	 * Column Info
	 * @param cfct61
	 */
	public void setCfct61(String cfct61) {
		this.cfct61 = cfct61;
	}
	
	/**
	 * Column Info
	 * @param bkgAvgQty51
	 */
	public void setBkgAvgQty51(String bkgAvgQty51) {
		this.bkgAvgQty51 = bkgAvgQty51;
	}
	
	/**
	 * Column Info
	 * @param bkg4541
	 */
	public void setBkg4541(String bkg4541) {
		this.bkg4541 = bkg4541;
	}
	
	/**
	 * Column Info
	 * @param bkgRd31
	 */
	public void setBkgRd31(String bkgRd31) {
		this.bkgRd31 = bkgRd31;
	}
	
	/**
	 * Column Info
	 * @param vvd2
	 */
	public void setVvd2(String vvd2) {
		this.vvd2 = vvd2;
	}
	
	/**
	 * Column Info
	 * @param vvd3
	 */
	public void setVvd3(String vvd3) {
		this.vvd3 = vvd3;
	}
	
	/**
	 * Column Info
	 * @param vvd1
	 */
	public void setVvd1(String vvd1) {
		this.vvd1 = vvd1;
	}
	
	/**
	 * Column Info
	 * @param maxQty61
	 */
	public void setMaxQty61(String maxQty61) {
		this.maxQty61 = maxQty61;
	}
	
	/**
	 * Column Info
	 * @param vvd6
	 */
	public void setVvd6(String vvd6) {
		this.vvd6 = vvd6;
	}
	
	/**
	 * Column Info
	 * @param vvd5
	 */
	public void setVvd5(String vvd5) {
		this.vvd5 = vvd5;
	}
	
	/**
	 * Column Info
	 * @param vvd4
	 */
	public void setVvd4(String vvd4) {
		this.vvd4 = vvd4;
	}
	
	/**
	 * Column Info
	 * @param qta61
	 */
	public void setQta61(String qta61) {
		this.qta61 = qta61;
	}
	
	/**
	 * Column Info
	 * @param bkgD221
	 */
	public void setBkgD221(String bkgD221) {
		this.bkgD221 = bkgD221;
	}
	
	/**
	 * Column Info
	 * @param gid
	 */
	public void setGid(String gid) {
		this.gid = gid;
	}
	
	/**
	 * Column Info
	 * @param bkgRf21
	 */
	public void setBkgRf21(String bkgRf21) {
		this.bkgRf21 = bkgRf21;
	}
	
	/**
	 * Column Info
	 * @param bkg5321
	 */
	public void setBkg5321(String bkg5321) {
		this.bkg5321 = bkg5321;
	}
	
	/**
	 * Column Info
	 * @param bkg2031
	 */
	public void setBkg2031(String bkg2031) {
		this.bkg2031 = bkg2031;
	}
	
	/**
	 * Column Info
	 * @param prefRf51
	 */
	public void setPrefRf51(String prefRf51) {
		this.prefRf51 = prefRf51;
	}
	
	/**
	 * Column Info
	 * @param othCustNm
	 */
	public void setOthCustNm(String othCustNm) {
		this.othCustNm = othCustNm;
	}
	
	/**
	 * Column Info
	 * @param alcRf51
	 */
	public void setAlcRf51(String alcRf51) {
		this.alcRf51 = alcRf51;
	}
	
	/**
	 * Column Info
	 * @param bkg11
	 */
	public void setBkg11(String bkg11) {
		this.bkg11 = bkg11;
	}
	
	/**
	 * Column Info
	 * @param bkgR241
	 */
	public void setBkgR241(String bkgR241) {
		this.bkgR241 = bkgR241;
	}
	
	/**
	 * Column Info
	 * @param custNo
	 */
	public void setCustNo(String custNo) {
		this.custNo = custNo;
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
	 * @param fct41
	 */
	public void setFct41(String fct41) {
		this.fct41 = fct41;
	}
	
	/**
	 * Column Info
	 * @param fct31
	 */
	public void setFct31(String fct31) {
		this.fct31 = fct31;
	}
	
	/**
	 * Column Info
	 * @param maxQty31
	 */
	public void setMaxQty31(String maxQty31) {
		this.maxQty31 = maxQty31;
	}
	
	/**
	 * Column Info
	 * @param alc21
	 */
	public void setAlc21(String alc21) {
		this.alc21 = alc21;
	}
	
	/**
	 * Column Info
	 * @param cmOp41
	 */
	public void setCmOp41(String cmOp41) {
		this.cmOp41 = cmOp41;
	}
	
	/**
	 * Column Info
	 * @param bkg4511
	 */
	public void setBkg4511(String bkg4511) {
		this.bkg4511 = bkg4511;
	}
	
	/**
	 * Column Info
	 * @param bkgHc31
	 */
	public void setBkgHc31(String bkgHc31) {
		this.bkgHc31 = bkgHc31;
	}
	
	/**
	 * Column Info
	 * @param cmVl41
	 */
	public void setCmVl41(String cmVl41) {
		this.cmVl41 = cmVl41;
	}
	
	/**
	 * Column Info
	 * @param port4
	 */
	public void setPort4(String port4) {
		this.port4 = port4;
	}
	
	/**
	 * Column Info
	 * @param cfct51
	 */
	public void setCfct51(String cfct51) {
		this.cfct51 = cfct51;
	}
	
	/**
	 * Column Info
	 * @param qta51
	 */
	public void setQta51(String qta51) {
		this.qta51 = qta51;
	}
	
	/**
	 * Column Info
	 * @param port3
	 */
	public void setPort3(String port3) {
		this.port3 = port3;
	}
	
	/**
	 * Column Info
	 * @param bkgAvgQty11
	 */
	public void setBkgAvgQty11(String bkgAvgQty11) {
		this.bkgAvgQty11 = bkgAvgQty11;
	}
	
	/**
	 * Column Info
	 * @param port2
	 */
	public void setPort2(String port2) {
		this.port2 = port2;
	}
	
	/**
	 * Column Info
	 * @param port1
	 */
	public void setPort1(String port1) {
		this.port1 = port1;
	}
	
	/**
	 * Column Info
	 * @param port6
	 */
	public void setPort6(String port6) {
		this.port6 = port6;
	}
	
	/**
	 * Column Info
	 * @param port5
	 */
	public void setPort5(String port5) {
		this.port5 = port5;
	}
	
	/**
	 * Column Info
	 * @param bkg4021
	 */
	public void setBkg4021(String bkg4021) {
		this.bkg4021 = bkg4021;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param bkg2021
	 */
	public void setBkg2021(String bkg2021) {
		this.bkg2021 = bkg2021;
	}
	
	/**
	 * Column Info
	 * @param bkgD421
	 */
	public void setBkgD421(String bkgD421) {
		this.bkgD421 = bkgD421;
	}
	
	/**
	 * Column Info
	 * @param bkgRf11
	 */
	public void setBkgRf11(String bkgRf11) {
		this.bkgRf11 = bkgRf11;
	}
	
	/**
	 * Column Info
	 * @param aqCd
	 */
	public void setAqCd(String aqCd) {
		this.aqCd = aqCd;
	}
	
	/**
	 * Column Info
	 * @param bkg5351
	 */
	public void setBkg5351(String bkg5351) {
		this.bkg5351 = bkg5351;
	}
	
	/**
	 * Column Info
	 * @param bkgR561
	 */
	public void setBkgR561(String bkgR561) {
		this.bkgR561 = bkgR561;
	}
	
	/**
	 * Column Info
	 * @param cmOc11
	 */
	public void setCmOc11(String cmOc11) {
		this.cmOc11 = cmOc11;
	}
	
	/**
	 * Column Info
	 * @param bkgR251
	 */
	public void setBkgR251(String bkgR251) {
		this.bkgR251 = bkgR251;
	}
	
	/**
	 * Column Info
	 * @param bkgHc21
	 */
	public void setBkgHc21(String bkgHc21) {
		this.bkgHc21 = bkgHc21;
	}
	
	/**
	 * Column Info
	 * @param cnt
	 */
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	
	/**
	 * Column Info
	 * @param bsaAvg
	 */
	public void setBsaAvg(String bsaAvg) {
		this.bsaAvg = bsaAvg;
	}
	
	/**
	 * Column Info
	 * @param alc31
	 */
	public void setAlc31(String alc31) {
		this.alc31 = alc31;
	}
	
	/**
	 * Column Info
	 * @param fct21
	 */
	public void setFct21(String fct21) {
		this.fct21 = fct21;
	}
	
	/**
	 * Column Info
	 * @param custClss
	 */
	public void setCustClss(String custClss) {
		this.custClss = custClss;
	}
	
	/**
	 * Column Info
	 * @param fct51
	 */
	public void setFct51(String fct51) {
		this.fct51 = fct51;
	}
	
	/**
	 * Column Info
	 * @param cmVl31
	 */
	public void setCmVl31(String cmVl31) {
		this.cmVl31 = cmVl31;
	}
	
	/**
	 * Column Info
	 * @param pref61
	 */
	public void setPref61(String pref61) {
		this.pref61 = pref61;
	}
	
	/**
	 * Column Info
	 * @param cmOp31
	 */
	public void setCmOp31(String cmOp31) {
		this.cmOp31 = cmOp31;
	}
	
	/**
	 * Column Info
	 * @param bkg4521
	 */
	public void setBkg4521(String bkg4521) {
		this.bkg4521 = bkg4521;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param subOfcCd
	 */
	public void setSubOfcCd(String subOfcCd) {
		this.subOfcCd = subOfcCd;
	}
	
	/**
	 * Column Info
	 * @param bkgRd11
	 */
	public void setBkgRd11(String bkgRd11) {
		this.bkgRd11 = bkgRd11;
	}
	
	/**
	 * Column Info
	 * @param cfct41
	 */
	public void setCfct41(String cfct41) {
		this.cfct41 = cfct41;
	}
	
	/**
	 * Column Info
	 * @param qta41
	 */
	public void setQta41(String qta41) {
		this.qta41 = qta41;
	}
	
	/**
	 * Column Info
	 * @param bkgAvgQty21
	 */
	public void setBkgAvgQty21(String bkgAvgQty21) {
		this.bkgAvgQty21 = bkgAvgQty21;
	}
	
	/**
	 * Column Info
	 * @param dest
	 */
	public void setDest(String dest) {
		this.dest = dest;
	}
	
	/**
	 * Column Info
	 * @param t
	 */
	public void setT(String t) {
		this.t = t;
	}
	
	/**
	 * Column Info
	 * @param bkg4011
	 */
	public void setBkg4011(String bkg4011) {
		this.bkg4011 = bkg4011;
	}
	
	/**
	 * Column Info
	 * @param maxQty41
	 */
	public void setMaxQty41(String maxQty41) {
		this.maxQty41 = maxQty41;
	}
	
	/**
	 * Column Info
	 * @param bkgD411
	 */
	public void setBkgD411(String bkgD411) {
		this.bkgD411 = bkgD411;
	}
	
	/**
	 * Column Info
	 * @param bkg5341
	 */
	public void setBkg5341(String bkg5341) {
		this.bkg5341 = bkg5341;
	}
	
	/**
	 * Column Info
	 * @param bkg2011
	 */
	public void setBkg2011(String bkg2011) {
		this.bkg2011 = bkg2011;
	}
	
	/**
	 * Column Info
	 * @param bkgD441
	 */
	public void setBkgD441(String bkgD441) {
		this.bkgD441 = bkgD441;
	}
	
	/**
	 * Column Info
	 * @param cmOp21
	 */
	public void setCmOp21(String cmOp21) {
		this.cmOp21 = cmOp21;
	}
	
	/**
	 * Column Info
	 * @param maxQty11
	 */
	public void setMaxQty11(String maxQty11) {
		this.maxQty11 = maxQty11;
	}
	
	/**
	 * Column Info
	 * @param pref11
	 */
	public void setPref11(String pref11) {
		this.pref11 = pref11;
	}
	
	/**
	 * Column Info
	 * @param bkgRd61
	 */
	public void setBkgRd61(String bkgRd61) {
		this.bkgRd61 = bkgRd61;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param cmVl11
	 */
	public void setCmVl11(String cmVl11) {
		this.cmVl11 = cmVl11;
	}
	
	/**
	 * Column Info
	 * @param bkg4051
	 */
	public void setBkg4051(String bkg4051) {
		this.bkg4051 = bkg4051;
	}
	
	/**
	 * Column Info
	 * @param bkg31
	 */
	public void setBkg31(String bkg31) {
		this.bkg31 = bkg31;
	}
	
	/**
	 * Column Info
	 * @param cmOc21
	 */
	public void setCmOc21(String cmOc21) {
		this.cmOc21 = cmOc21;
	}
	
	/**
	 * Column Info
	 * @param alc51
	 */
	public void setAlc51(String alc51) {
		this.alc51 = alc51;
	}
	
	/**
	 * Column Info
	 * @param cmVl21
	 */
	public void setCmVl21(String cmVl21) {
		this.cmVl21 = cmVl21;
	}
	
	/**
	 * Column Info
	 * @param acctTp
	 */
	public void setAcctTp(String acctTp) {
		this.acctTp = acctTp;
	}
	
	/**
	 * Column Info
	 * @param prefRf21
	 */
	public void setPrefRf21(String prefRf21) {
		this.prefRf21 = prefRf21;
	}
	
	/**
	 * Column Info
	 * @param bkgHc51
	 */
	public void setBkgHc51(String bkgHc51) {
		this.bkgHc51 = bkgHc51;
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
	 * @param alcRf21
	 */
	public void setAlcRf21(String alcRf21) {
		this.alcRf21 = alcRf21;
	}
	
	/**
	 * Column Info
	 * @param qta31
	 */
	public void setQta31(String qta31) {
		this.qta31 = qta31;
	}
	
	/**
	 * Column Info
	 * @param bkgRf61
	 */
	public void setBkgRf61(String bkgRf61) {
		this.bkgRf61 = bkgRf61;
	}
	
	/**
	 * Column Info
	 * @param bkgR261
	 */
	public void setBkgR261(String bkgR261) {
		this.bkgR261 = bkgR261;
	}
	
	/**
	 * Column Info
	 * @param bkgD251
	 */
	public void setBkgD251(String bkgD251) {
		this.bkgD251 = bkgD251;
	}
	
	/**
	 * Column Info
	 * @param cfct31
	 */
	public void setCfct31(String cfct31) {
		this.cfct31 = cfct31;
	}
	
	/**
	 * Column Info
	 * @param cmOp11
	 */
	public void setCmOp11(String cmOp11) {
		this.cmOp11 = cmOp11;
	}
	
	/**
	 * Column Info
	 * @param custGrpId
	 */
	public void setCustGrpId(String custGrpId) {
		this.custGrpId = custGrpId;
	}
	
	/**
	 * Column Info
	 * @param maxQty21
	 */
	public void setMaxQty21(String maxQty21) {
		this.maxQty21 = maxQty21;
	}
	
	/**
	 * Column Info
	 * @param pref21
	 */
	public void setPref21(String pref21) {
		this.pref21 = pref21;
	}
	
	/**
	 * Column Info
	 * @param bkgD431
	 */
	public void setBkgD431(String bkgD431) {
		this.bkgD431 = bkgD431;
	}
	
	/**
	 * Column Info
	 * @param bkg41
	 */
	public void setBkg41(String bkg41) {
		this.bkg41 = bkg41;
	}
	
	/**
	 * Column Info
	 * @param cmOc31
	 */
	public void setCmOc31(String cmOc31) {
		this.cmOc31 = cmOc31;
	}
	
	/**
	 * Column Info
	 * @param bkg4061
	 */
	public void setBkg4061(String bkg4061) {
		this.bkg4061 = bkg4061;
	}
	
	/**
	 * Column Info
	 * @param prefRf11
	 */
	public void setPrefRf11(String prefRf11) {
		this.prefRf11 = prefRf11;
	}
	
	/**
	 * Column Info
	 * @param bkgD261
	 */
	public void setBkgD261(String bkgD261) {
		this.bkgD261 = bkgD261;
	}
	
	/**
	 * Column Info
	 * @param alcRf11
	 */
	public void setAlcRf11(String alcRf11) {
		this.alcRf11 = alcRf11;
	}
	
	/**
	 * Column Info
	 * @param alc41
	 */
	public void setAlc41(String alc41) {
		this.alc41 = alc41;
	}
	
	/**
	 * Column Info
	 * @param bkgHc41
	 */
	public void setBkgHc41(String bkgHc41) {
		this.bkgHc41 = bkgHc41;
	}
	
	/**
	 * Column Info
	 * @param qta21
	 */
	public void setQta21(String qta21) {
		this.qta21 = qta21;
	}
	
	/**
	 * Column Info
	 * @param cfct21
	 */
	public void setCfct21(String cfct21) {
		this.cfct21 = cfct21;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Column Info
	 * @param bkg5361
	 */
	public void setBkg5361(String bkg5361) {
		this.bkg5361 = bkg5361;
	}
	
	/**
	 * Column Info
	 * @param pref31
	 */
	public void setPref31(String pref31) {
		this.pref31 = pref31;
	}
	
	/**
	 * Column Info
	 * @param bkgR511
	 */
	public void setBkgR511(String bkgR511) {
		this.bkgR511 = bkgR511;
	}
	
	/**
	 * Column Info
	 * @param bkgD461
	 */
	public void setBkgD461(String bkgD461) {
		this.bkgD461 = bkgD461;
	}
	
	/**
	 * Column Info
	 * @param bkgAvgQty61
	 */
	public void setBkgAvgQty61(String bkgAvgQty61) {
		this.bkgAvgQty61 = bkgAvgQty61;
	}
	
	/**
	 * Column Info
	 * @param bkgRd41
	 */
	public void setBkgRd41(String bkgRd41) {
		this.bkgRd41 = bkgRd41;
	}
	
	/**
	 * Column Info
	 * @param bkg4031
	 */
	public void setBkg4031(String bkg4031) {
		this.bkg4031 = bkg4031;
	}
	
	/**
	 * Column Info
	 * @param bkg51
	 */
	public void setBkg51(String bkg51) {
		this.bkg51 = bkg51;
	}
	
	/**
	 * Column Info
	 * @param cmOc41
	 */
	public void setCmOc41(String cmOc41) {
		this.cmOc41 = cmOc41;
	}
	
	/**
	 * Column Info
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
	}
	
	/**
	 * Column Info
	 * @param alcRf41
	 */
	public void setAlcRf41(String alcRf41) {
		this.alcRf41 = alcRf41;
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
	 * @param bkg5311
	 */
	public void setBkg5311(String bkg5311) {
		this.bkg5311 = bkg5311;
	}
	
	/**
	 * Column Info
	 * @param bkg4551
	 */
	public void setBkg4551(String bkg4551) {
		this.bkg4551 = bkg4551;
	}
	
	/**
	 * Column Info
	 * @param prefRf41
	 */
	public void setPrefRf41(String prefRf41) {
		this.prefRf41 = prefRf41;
	}
	
	/**
	 * Column Info
	 * @param bsa5
	 */
	public void setBsa5(String bsa5) {
		this.bsa5 = bsa5;
	}
	
	/**
	 * Column Info
	 * @param bsa4
	 */
	public void setBsa4(String bsa4) {
		this.bsa4 = bsa4;
	}
	
	/**
	 * Column Info
	 * @param bsa6
	 */
	public void setBsa6(String bsa6) {
		this.bsa6 = bsa6;
	}
	
	/**
	 * Column Info
	 * @param bkgD231
	 */
	public void setBkgD231(String bkgD231) {
		this.bkgD231 = bkgD231;
	}
	
	/**
	 * Column Info
	 * @param cfct11
	 */
	public void setCfct11(String cfct11) {
		this.cfct11 = cfct11;
	}
	
	/**
	 * Column Info
	 * @param qta11
	 */
	public void setQta11(String qta11) {
		this.qta11 = qta11;
	}
	
	/**
	 * Column Info
	 * @param bsa1
	 */
	public void setBsa1(String bsa1) {
		this.bsa1 = bsa1;
	}
	
	/**
	 * Column Info
	 * @param bkgRf41
	 */
	public void setBkgRf41(String bkgRf41) {
		this.bkgRf41 = bkgRf41;
	}
	
	/**
	 * Column Info
	 * @param bsa3
	 */
	public void setBsa3(String bsa3) {
		this.bsa3 = bsa3;
	}
	
	/**
	 * Column Info
	 * @param bkg2061
	 */
	public void setBkg2061(String bkg2061) {
		this.bkg2061 = bkg2061;
	}
	
	/**
	 * Column Info
	 * @param bsa2
	 */
	public void setBsa2(String bsa2) {
		this.bsa2 = bsa2;
	}
	
	/**
	 * Column Info
	 * @param pref41
	 */
	public void setPref41(String pref41) {
		this.pref41 = pref41;
	}
	
	/**
	 * Column Info
	 * @param bkgR521
	 */
	public void setBkgR521(String bkgR521) {
		this.bkgR521 = bkgR521;
	}
	
	/**
	 * Column Info
	 * @param bkgD451
	 */
	public void setBkgD451(String bkgD451) {
		this.bkgD451 = bkgD451;
	}
	
	/**
	 * Column Info
	 * @param bkgRd51
	 */
	public void setBkgRd51(String bkgRd51) {
		this.bkgRd51 = bkgRd51;
	}
	
	/**
	 * Column Info
	 * @param bkg4041
	 */
	public void setBkg4041(String bkg4041) {
		this.bkg4041 = bkg4041;
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
	 * @param bkg61
	 */
	public void setBkg61(String bkg61) {
		this.bkg61 = bkg61;
	}
	
	/**
	 * Column Info
	 * @param cmOc51
	 */
	public void setCmOc51(String cmOc51) {
		this.cmOc51 = cmOc51;
	}
	
	/**
	 * Column Info
	 * @param bkgR211
	 */
	public void setBkgR211(String bkgR211) {
		this.bkgR211 = bkgR211;
	}
	
	/**
	 * Column Info
	 * @param alcRf31
	 */
	public void setAlcRf31(String alcRf31) {
		this.alcRf31 = alcRf31;
	}
	
	/**
	 * Column Info
	 * @param alc61
	 */
	public void setAlc61(String alc61) {
		this.alc61 = alc61;
	}
	
	/**
	 * Column Info
	 * @param bkg4561
	 */
	public void setBkg4561(String bkg4561) {
		this.bkg4561 = bkg4561;
	}
	
	/**
	 * Column Info
	 * @param bkg2051
	 */
	public void setBkg2051(String bkg2051) {
		this.bkg2051 = bkg2051;
	}
	
	/**
	 * Column Info
	 * @param bkgHc61
	 */
	public void setBkgHc61(String bkgHc61) {
		this.bkgHc61 = bkgHc61;
	}
	
	/**
	 * Column Info
	 * @param prefRf31
	 */
	public void setPrefRf31(String prefRf31) {
		this.prefRf31 = prefRf31;
	}
	
	/**
	 * Column Info
	 * @param bkgD241
	 */
	public void setBkgD241(String bkgD241) {
		this.bkgD241 = bkgD241;
	}
	
	/**
	 * Column Info
	 * @param bkgRf51
	 */
	public void setBkgRf51(String bkgRf51) {
		this.bkgRf51 = bkgRf51;
	}
	
	/**
	 * Column Info
	 * @param pref51
	 */
	public void setPref51(String pref51) {
		this.pref51 = pref51;
	}
	
	/**
	 * Column Info
	 * @param bkgR531
	 */
	public void setBkgR531(String bkgR531) {
		this.bkgR531 = bkgR531;
	}
	
	
   /**
	 * @return the usaBkgModCd
	 */
	public String getUsaBkgModCd() {
		return usaBkgModCd;
	}

	/**
	 * @return the destLocCd
	 */
	public String getDestLocCd() {
		return destLocCd;
	}

	/**
	 * @return the acctCd
	 */
	public String getAcctCd() {
		return acctCd;
	}

	/**
	 * @param usaBkgModCd the usaBkgModCd to set
	 */
	public void setUsaBkgModCd(String usaBkgModCd) {
		this.usaBkgModCd = usaBkgModCd;
	}

	/**
	 * @param destLocCd the destLocCd to set
	 */
	public void setDestLocCd(String destLocCd) {
		this.destLocCd = destLocCd;
	}

	/**
	 * @param acctCd the acctCd to set
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	
	
	/**
	 * Column Info
	 * @return ratio51
	 */
	public String getRatio51() {
		return this.ratio51;
	}
	
	/**
	 * Column Info
	 * @return cm41
	 */
	public String getCm41() {
		return this.cm41;
	}
	
	/**
	 * Column Info
	 * @return ratio11
	 */
	public String getRatio11() {
		return this.ratio11;
	}
	
	/**
	 * Column Info
	 * @return ratio31
	 */
	public String getRatio31() {
		return this.ratio31;
	}
	
	/**
	 * Column Info
	 * @return cm21
	 */
	public String getCm21() {
		return this.cm21;
	}
	
	/**
	 * Column Info
	 * @return ratio21
	 */
	public String getRatio21() {
		return this.ratio21;
	}
	
	/**
	 * Column Info
	 * @return cm11
	 */
	public String getCm11() {
		return this.cm11;
	}
	
	/**
	 * Column Info
	 * @return cm51
	 */
	public String getCm51() {
		return this.cm51;
	}
	
	/**
	 * Column Info
	 * @return ratio61
	 */
	public String getRatio61() {
		return this.ratio61;
	}
	
	/**
	 * Column Info
	 * @return cm61
	 */
	public String getCm61() {
		return this.cm61;
	}
	
	/**
	 * Column Info
	 * @return ratio41
	 */
	public String getRatio41() {
		return this.ratio41;
	}
	
	/**
	 * Column Info
	 * @return cm31
	 */
	public String getCm31() {
		return this.cm31;
	}
	
	/**
	 * Column Info
	 * @return cmb31
	 */
	public String getCmb31() {
		return this.cmb31;
	}
	
	/**
	 * Column Info
	 * @return cmb41
	 */
	public String getCmb41() {
		return this.cmb41;
	}
	
	/**
	 * Column Info
	 * @return cmb61
	 */
	public String getCmb61() {
		return this.cmb61;
	}
	
	/**
	 * Column Info
	 * @return cmb11
	 */
	public String getCmb11() {
		return this.cmb11;
	}
	
	/**
	 * Column Info
	 * @return cmb51
	 */
	public String getCmb51() {
		return this.cmb51;
	}
	
	/**
	 * Column Info
	 * @return cmb21
	 */
	public String getCmb21() {
		return this.cmb21;
	}
	

	/**
	 * Column Info
	 * @param ratio51
	 */
	public void setRatio51(String ratio51) {
		this.ratio51 = ratio51;
	}
	
	/**
	 * Column Info
	 * @param cm41
	 */
	public void setCm41(String cm41) {
		this.cm41 = cm41;
	}
	
	/**
	 * Column Info
	 * @param ratio11
	 */
	public void setRatio11(String ratio11) {
		this.ratio11 = ratio11;
	}
	
	/**
	 * Column Info
	 * @param ratio31
	 */
	public void setRatio31(String ratio31) {
		this.ratio31 = ratio31;
	}
	
	/**
	 * Column Info
	 * @param cm21
	 */
	public void setCm21(String cm21) {
		this.cm21 = cm21;
	}
	
	/**
	 * Column Info
	 * @param ratio21
	 */
	public void setRatio21(String ratio21) {
		this.ratio21 = ratio21;
	}
	
	/**
	 * Column Info
	 * @param cm11
	 */
	public void setCm11(String cm11) {
		this.cm11 = cm11;
	}
	
	/**
	 * Column Info
	 * @param cm51
	 */
	public void setCm51(String cm51) {
		this.cm51 = cm51;
	}
	
	/**
	 * Column Info
	 * @param ratio61
	 */
	public void setRatio61(String ratio61) {
		this.ratio61 = ratio61;
	}
	
	/**
	 * Column Info
	 * @param cm61
	 */
	public void setCm61(String cm61) {
		this.cm61 = cm61;
	}
	
	/**
	 * Column Info
	 * @param ratio41
	 */
	public void setRatio41(String ratio41) {
		this.ratio41 = ratio41;
	}
	
	/**
	 * Column Info
	 * @param cm31
	 */
	public void setCm31(String cm31) {
		this.cm31 = cm31;
	}
	
	/**
	 * Column Info
	 * @param cmb31
	 */
	public void setCmb31(String cmb31) {
		this.cmb31 = cmb31;
	}
	
	/**
	 * Column Info
	 * @param cmb41
	 */
	public void setCmb41(String cmb41) {
		this.cmb41 = cmb41;
	}
	
	/**
	 * Column Info
	 * @param cmb61
	 */
	public void setCmb61(String cmb61) {
		this.cmb61 = cmb61;
	}
	
	/**
	 * Column Info
	 * @param cmb11
	 */
	public void setCmb11(String cmb11) {
		this.cmb11 = cmb11;
	}
	
	/**
	 * Column Info
	 * @param cmb51
	 */
	public void setCmb51(String cmb51) {
		this.cmb51 = cmb51;
	}
	
	/**
	 * Column Info
	 * @param cmb21
	 */
	public void setCmb21(String cmb21) {
		this.cmb21 = cmb21;
	}

	/**
	 * @return the cmEn11
	 */
	public String getCmEn11() {
		return cmEn11;
	}

	/**
	 * @param cmEn11 the cmEn11 to set
	 */
	public void setCmEn11(String cmEn11) {
		this.cmEn11 = cmEn11;
	}

	/**
	 * @return the cmEn21
	 */
	public String getCmEn21() {
		return cmEn21;
	}

	/**
	 * @param cmEn21 the cmEn21 to set
	 */
	public void setCmEn21(String cmEn21) {
		this.cmEn21 = cmEn21;
	}

	/**
	 * @return the cmEn31
	 */
	public String getCmEn31() {
		return cmEn31;
	}

	/**
	 * @param cmEn31 the cmEn31 to set
	 */
	public void setCmEn31(String cmEn31) {
		this.cmEn31 = cmEn31;
	}

	/**
	 * @return the cmEn41
	 */
	public String getCmEn41() {
		return cmEn41;
	}

	/**
	 * @param cmEn41 the cmEn41 to set
	 */
	public void setCmEn41(String cmEn41) {
		this.cmEn41 = cmEn41;
	}

	/**
	 * @return the cmEn51
	 */
	public String getCmEn51() {
		return cmEn51;
	}

	/**
	 * @param cmEn51 the cmEn51 to set
	 */
	public void setCmEn51(String cmEn51) {
		this.cmEn51 = cmEn51;
	}

	/**
	 * @return the cmEn61
	 */
	public String getCmEn61() {
		return cmEn61;
	}

	/**
	 * @param cmEn61 the cmEn61 to set
	 */
	public void setCmEn61(String cmEn61) {
		this.cmEn61 = cmEn61;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}
	/**
	 * @return the prf11
	 */
	public String getPrf11() {
		return prf11;
	}
	/**
	 * @param prf11 the prf11 to set
	 */
	public void setPrf11(String prf11) {
		this.prf11 = prf11;
	}
	/**
	 * @return the prf21
	 */
	public String getPrf21() {
		return prf21;
	}
	/**
	 * @param prf21 the prf21 to set
	 */
	public void setPrf21(String prf21) {
		this.prf21 = prf21;
	}
	/**
	 * @return the prf31
	 */
	public String getPrf31() {
		return prf31;
	}
	/**
	 * @param prf31 the prf31 to set
	 */
	public void setPrf31(String prf31) {
		this.prf31 = prf31;
	}
	/**
	 * @return the prf41
	 */
	public String getPrf41() {
		return prf41;
	}
	/**
	 * @param prf41 the prf41 to set
	 */
	public void setPrf41(String prf41) {
		this.prf41 = prf41;
	}
	/**
	 * @return the prf51
	 */
	public String getPrf51() {
		return prf51;
	}
	/**
	 * @param prf51 the prf51 to set
	 */
	public void setPrf51(String prf51) {
		this.prf51 = prf51;
	}
	/**
	 * @return the prf61
	 */
	public String getPrf61() {
		return prf61;
	}
	/**
	 * @param prf61 the prf61 to set
	 */
	public void setPrf61(String prf61) {
		this.prf61 = prf61;
	}
	/**
	 * @return the bsaw1
	 */
	public String getBsaw1() {
		return bsaw1;
	}
	/**
	 * @param bsaw1 the bsaw1 to set
	 */
	public void setBsaw1(String bsaw1) {
		this.bsaw1 = bsaw1;
	}
	/**
	 * @return the bsaw2
	 */
	public String getBsaw2() {
		return bsaw2;
	}
	/**
	 * @param bsaw2 the bsaw2 to set
	 */
	public void setBsaw2(String bsaw2) {
		this.bsaw2 = bsaw2;
	}
	/**
	 * @return the bsaw3
	 */
	public String getBsaw3() {
		return bsaw3;
	}
	/**
	 * @param bsaw3 the bsaw3 to set
	 */
	public void setBsaw3(String bsaw3) {
		this.bsaw3 = bsaw3;
	}
	/**
	 * @return the bsaw4
	 */
	public String getBsaw4() {
		return bsaw4;
	}
	/**
	 * @param bsaw4 the bsaw4 to set
	 */
	public void setBsaw4(String bsaw4) {
		this.bsaw4 = bsaw4;
	}
	/**
	 * @return the bsaw5
	 */
	public String getBsaw5() {
		return bsaw5;
	}
	/**
	 * @param bsaw5 the bsaw5 to set
	 */
	public void setBsaw5(String bsaw5) {
		this.bsaw5 = bsaw5;
	}
	/**
	 * @return the bsaw6
	 */
	public String getBsaw6() {
		return bsaw6;
	}
	/**
	 * @param bsaw6 the bsaw6 to set
	 */
	public void setBsaw6(String bsaw6) {
		this.bsaw6 = bsaw6;
	}
	/**
	 * @return the bkgw1
	 */
	public String getBkgw1() {
		return bkgw1;
	}
	/**
	 * @param bkgw1 the bkgw1 to set
	 */
	public void setBkgw1(String bkgw1) {
		this.bkgw1 = bkgw1;
	}
	/**
	 * @return the bkgw2
	 */
	public String getBkgw2() {
		return bkgw2;
	}
	/**
	 * @param bkgw2 the bkgw2 to set
	 */
	public void setBkgw2(String bkgw2) {
		this.bkgw2 = bkgw2;
	}
	/**
	 * @return the bkgw3
	 */
	public String getBkgw3() {
		return bkgw3;
	}
	/**
	 * @param bkgw3 the bkgw3 to set
	 */
	public void setBkgw3(String bkgw3) {
		this.bkgw3 = bkgw3;
	}
	/**
	 * @return the bkgw4
	 */
	public String getBkgw4() {
		return bkgw4;
	}
	/**
	 * @param bkgw4 the bkgw4 to set
	 */
	public void setBkgw4(String bkgw4) {
		this.bkgw4 = bkgw4;
	}
	/**
	 * @return the bkgw5
	 */
	public String getBkgw5() {
		return bkgw5;
	}
	/**
	 * @param bkgw5 the bkgw5 to set
	 */
	public void setBkgw5(String bkgw5) {
		this.bkgw5 = bkgw5;
	}
	/**
	 * @return the bkgw6
	 */
	public String getBkgw6() {
		return bkgw6;
	}
	/**
	 * @param bkgw6 the bkgw6 to set
	 */
	public void setBkgw6(String bkgw6) {
		this.bkgw6 = bkgw6;
	}
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setBkgR221(JSPUtil.getParameter(request, prefix + "bkg_r221", ""));
		setBkgHc11(JSPUtil.getParameter(request, prefix + "bkg_hc11", ""));
		setCmOp61(JSPUtil.getParameter(request, prefix + "cm_op61", ""));
		setBkgR551(JSPUtil.getParameter(request, prefix + "bkg_r551", ""));
		setBkgRd21(JSPUtil.getParameter(request, prefix + "bkg_rd21", ""));
		setBkgAvgQty41(JSPUtil.getParameter(request, prefix + "bkg_avg_qty41", ""));
		setFct61(JSPUtil.getParameter(request, prefix + "fct61", ""));
		setBkg4531(JSPUtil.getParameter(request, prefix + "bkg_4531", ""));
		setCustCtrlCd(JSPUtil.getParameter(request, prefix + "cust_ctrl_cd", ""));
		setCmVl61(JSPUtil.getParameter(request, prefix + "cm_vl61", ""));
		setFct11(JSPUtil.getParameter(request, prefix + "fct11", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setMaxQty51(JSPUtil.getParameter(request, prefix + "max_qty51", ""));
		setCmOc61(JSPUtil.getParameter(request, prefix + "cm_oc61", ""));
		setBkgD211(JSPUtil.getParameter(request, prefix + "bkg_d211", ""));
		setAlcRf61(JSPUtil.getParameter(request, prefix + "alc_rf61", ""));
		setBkgAvgQty31(JSPUtil.getParameter(request, prefix + "bkg_avg_qty31", ""));
		setCustGrpNm(JSPUtil.getParameter(request, prefix + "cust_grp_nm", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
		setBkg5331(JSPUtil.getParameter(request, prefix + "bkg_5331", ""));
		setBkgRf31(JSPUtil.getParameter(request, prefix + "bkg_rf31", ""));
		setBkg2041(JSPUtil.getParameter(request, prefix + "bkg_2041", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setPrefRf61(JSPUtil.getParameter(request, prefix + "pref_rf61", ""));
		setBkg21(JSPUtil.getParameter(request, prefix + "bkg21", ""));
		setBkgR231(JSPUtil.getParameter(request, prefix + "bkg_r231", ""));
		setAlc11(JSPUtil.getParameter(request, prefix + "alc11", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setCmOp51(JSPUtil.getParameter(request, prefix + "cm_op51", ""));
		setBkgR541(JSPUtil.getParameter(request, prefix + "bkg_r541", ""));
		setCmVl51(JSPUtil.getParameter(request, prefix + "cm_vl51", ""));
		setCfct61(JSPUtil.getParameter(request, prefix + "cfct61", ""));
		setBkgAvgQty51(JSPUtil.getParameter(request, prefix + "bkg_avg_qty51", ""));
		setBkg4541(JSPUtil.getParameter(request, prefix + "bkg_4541", ""));
		setBkgRd31(JSPUtil.getParameter(request, prefix + "bkg_rd31", ""));
		setVvd2(JSPUtil.getParameter(request, prefix + "vvd2", ""));
		setVvd3(JSPUtil.getParameter(request, prefix + "vvd3", ""));
		setVvd1(JSPUtil.getParameter(request, prefix + "vvd1", ""));
		setMaxQty61(JSPUtil.getParameter(request, prefix + "max_qty61", ""));
		setVvd6(JSPUtil.getParameter(request, prefix + "vvd6", ""));
		setVvd5(JSPUtil.getParameter(request, prefix + "vvd5", ""));
		setVvd4(JSPUtil.getParameter(request, prefix + "vvd4", ""));
		setQta61(JSPUtil.getParameter(request, prefix + "qta61", ""));
		setBkgD221(JSPUtil.getParameter(request, prefix + "bkg_d221", ""));
		setGid(JSPUtil.getParameter(request, prefix + "gid", ""));
		setBkgRf21(JSPUtil.getParameter(request, prefix + "bkg_rf21", ""));
		setBkg5321(JSPUtil.getParameter(request, prefix + "bkg_5321", ""));
		setBkg2031(JSPUtil.getParameter(request, prefix + "bkg_2031", ""));
		setPrefRf51(JSPUtil.getParameter(request, prefix + "pref_rf51", ""));
		setOthCustNm(JSPUtil.getParameter(request, prefix + "oth_cust_nm", ""));
		setAlcRf51(JSPUtil.getParameter(request, prefix + "alc_rf51", ""));
		setBkg11(JSPUtil.getParameter(request, prefix + "bkg11", ""));
		setBkgR241(JSPUtil.getParameter(request, prefix + "bkg_r241", ""));
		setCustNo(JSPUtil.getParameter(request, prefix + "cust_no", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setFct41(JSPUtil.getParameter(request, prefix + "fct41", ""));
		setFct31(JSPUtil.getParameter(request, prefix + "fct31", ""));
		setMaxQty31(JSPUtil.getParameter(request, prefix + "max_qty31", ""));
		setAlc21(JSPUtil.getParameter(request, prefix + "alc21", ""));
		setCmOp41(JSPUtil.getParameter(request, prefix + "cm_op41", ""));
		setBkg4511(JSPUtil.getParameter(request, prefix + "bkg_4511", ""));
		setBkgHc31(JSPUtil.getParameter(request, prefix + "bkg_hc31", ""));
		setCmVl41(JSPUtil.getParameter(request, prefix + "cm_vl41", ""));
		setPort4(JSPUtil.getParameter(request, prefix + "port4", ""));
		setCfct51(JSPUtil.getParameter(request, prefix + "cfct51", ""));
		setQta51(JSPUtil.getParameter(request, prefix + "qta51", ""));
		setPort3(JSPUtil.getParameter(request, prefix + "port3", ""));
		setBkgAvgQty11(JSPUtil.getParameter(request, prefix + "bkg_avg_qty11", ""));
		setPort2(JSPUtil.getParameter(request, prefix + "port2", ""));
		setPort1(JSPUtil.getParameter(request, prefix + "port1", ""));
		setPort6(JSPUtil.getParameter(request, prefix + "port6", ""));
		setPort5(JSPUtil.getParameter(request, prefix + "port5", ""));
		setBkg4021(JSPUtil.getParameter(request, prefix + "bkg_4021", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setBkg2021(JSPUtil.getParameter(request, prefix + "bkg_2021", ""));
		setBkgD421(JSPUtil.getParameter(request, prefix + "bkg_d421", ""));
		setBkgRf11(JSPUtil.getParameter(request, prefix + "bkg_rf11", ""));
		setAqCd(JSPUtil.getParameter(request, prefix + "aq_cd", ""));
		setBkg5351(JSPUtil.getParameter(request, prefix + "bkg_5351", ""));
		setBkgR561(JSPUtil.getParameter(request, prefix + "bkg_r561", ""));
		setCmOc11(JSPUtil.getParameter(request, prefix + "cm_oc11", ""));
		setBkgR251(JSPUtil.getParameter(request, prefix + "bkg_r251", ""));
		setBkgHc21(JSPUtil.getParameter(request, prefix + "bkg_hc21", ""));
		setCnt(JSPUtil.getParameter(request, prefix + "cnt", ""));
		setBsaAvg(JSPUtil.getParameter(request, prefix + "bsa_avg", ""));
		setAlc31(JSPUtil.getParameter(request, prefix + "alc31", ""));
		setFct21(JSPUtil.getParameter(request, prefix + "fct21", ""));
		setCustClss(JSPUtil.getParameter(request, prefix + "cust_clss", ""));
		setFct51(JSPUtil.getParameter(request, prefix + "fct51", ""));
		setCmVl31(JSPUtil.getParameter(request, prefix + "cm_vl31", ""));
		setPref61(JSPUtil.getParameter(request, prefix + "pref61", ""));
		setCmOp31(JSPUtil.getParameter(request, prefix + "cm_op31", ""));
		setBkg4521(JSPUtil.getParameter(request, prefix + "bkg_4521", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setSubOfcCd(JSPUtil.getParameter(request, prefix + "sub_ofc_cd", ""));
		setBkgRd11(JSPUtil.getParameter(request, prefix + "bkg_rd11", ""));
		setCfct41(JSPUtil.getParameter(request, prefix + "cfct41", ""));
		setQta41(JSPUtil.getParameter(request, prefix + "qta41", ""));
		setBkgAvgQty21(JSPUtil.getParameter(request, prefix + "bkg_avg_qty21", ""));
		setDest(JSPUtil.getParameter(request, prefix + "dest", ""));
		setT(JSPUtil.getParameter(request, prefix + "t", ""));
		setBkg4011(JSPUtil.getParameter(request, prefix + "bkg_4011", ""));
		setMaxQty41(JSPUtil.getParameter(request, prefix + "max_qty41", ""));
		setBkgD411(JSPUtil.getParameter(request, prefix + "bkg_d411", ""));
		setBkg5341(JSPUtil.getParameter(request, prefix + "bkg_5341", ""));
		setBkg2011(JSPUtil.getParameter(request, prefix + "bkg_2011", ""));
		setBkgD441(JSPUtil.getParameter(request, prefix + "bkg_d441", ""));
		setCmOp21(JSPUtil.getParameter(request, prefix + "cm_op21", ""));
		setMaxQty11(JSPUtil.getParameter(request, prefix + "max_qty11", ""));
		setPref11(JSPUtil.getParameter(request, prefix + "pref11", ""));
		setBkgRd61(JSPUtil.getParameter(request, prefix + "bkg_rd61", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setCmVl11(JSPUtil.getParameter(request, prefix + "cm_vl11", ""));
		setBkg4051(JSPUtil.getParameter(request, prefix + "bkg_4051", ""));
		setBkg31(JSPUtil.getParameter(request, prefix + "bkg31", ""));
		setCmOc21(JSPUtil.getParameter(request, prefix + "cm_oc21", ""));
		setAlc51(JSPUtil.getParameter(request, prefix + "alc51", ""));
		setCmVl21(JSPUtil.getParameter(request, prefix + "cm_vl21", ""));
		setAcctTp(JSPUtil.getParameter(request, prefix + "acct_tp", ""));
		setPrefRf21(JSPUtil.getParameter(request, prefix + "pref_rf21", ""));
		setBkgHc51(JSPUtil.getParameter(request, prefix + "bkg_hc51", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setAlcRf21(JSPUtil.getParameter(request, prefix + "alc_rf21", ""));
		setQta31(JSPUtil.getParameter(request, prefix + "qta31", ""));
		setBkgRf61(JSPUtil.getParameter(request, prefix + "bkg_rf61", ""));
		setBkgR261(JSPUtil.getParameter(request, prefix + "bkg_r261", ""));
		setBkgD251(JSPUtil.getParameter(request, prefix + "bkg_d251", ""));
		setCfct31(JSPUtil.getParameter(request, prefix + "cfct31", ""));
		setCmOp11(JSPUtil.getParameter(request, prefix + "cm_op11", ""));
		setCustGrpId(JSPUtil.getParameter(request, prefix + "cust_grp_id", ""));
		setMaxQty21(JSPUtil.getParameter(request, prefix + "max_qty21", ""));
		setPref21(JSPUtil.getParameter(request, prefix + "pref21", ""));
		setBkgD431(JSPUtil.getParameter(request, prefix + "bkg_d431", ""));
		setBkg41(JSPUtil.getParameter(request, prefix + "bkg41", ""));
		setCmOc31(JSPUtil.getParameter(request, prefix + "cm_oc31", ""));
		setBkg4061(JSPUtil.getParameter(request, prefix + "bkg_4061", ""));
		setPrefRf11(JSPUtil.getParameter(request, prefix + "pref_rf11", ""));
		setBkgD261(JSPUtil.getParameter(request, prefix + "bkg_d261", ""));
		setAlcRf11(JSPUtil.getParameter(request, prefix + "alc_rf11", ""));
		setAlc41(JSPUtil.getParameter(request, prefix + "alc41", ""));
		setBkgHc41(JSPUtil.getParameter(request, prefix + "bkg_hc41", ""));
		setQta21(JSPUtil.getParameter(request, prefix + "qta21", ""));
		setCfct21(JSPUtil.getParameter(request, prefix + "cfct21", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setBkg5361(JSPUtil.getParameter(request, prefix + "bkg_5361", ""));
		setPref31(JSPUtil.getParameter(request, prefix + "pref31", ""));
		setBkgR511(JSPUtil.getParameter(request, prefix + "bkg_r511", ""));
		setBkgD461(JSPUtil.getParameter(request, prefix + "bkg_d461", ""));
		setBkgAvgQty61(JSPUtil.getParameter(request, prefix + "bkg_avg_qty61", ""));
		setBkgRd41(JSPUtil.getParameter(request, prefix + "bkg_rd41", ""));
		setBkg4031(JSPUtil.getParameter(request, prefix + "bkg_4031", ""));
		setBkg51(JSPUtil.getParameter(request, prefix + "bkg51", ""));
		setCmOc41(JSPUtil.getParameter(request, prefix + "cm_oc41", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setAlcRf41(JSPUtil.getParameter(request, prefix + "alc_rf41", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkg5311(JSPUtil.getParameter(request, prefix + "bkg_5311", ""));
		setBkg4551(JSPUtil.getParameter(request, prefix + "bkg_4551", ""));
		setPrefRf41(JSPUtil.getParameter(request, prefix + "pref_rf41", ""));
		setBsa5(JSPUtil.getParameter(request, prefix + "bsa5", ""));
		setBsa4(JSPUtil.getParameter(request, prefix + "bsa4", ""));
		setBsa6(JSPUtil.getParameter(request, prefix + "bsa6", ""));
		setBkgD231(JSPUtil.getParameter(request, prefix + "bkg_d231", ""));
		setCfct11(JSPUtil.getParameter(request, prefix + "cfct11", ""));
		setQta11(JSPUtil.getParameter(request, prefix + "qta11", ""));
		setBsa1(JSPUtil.getParameter(request, prefix + "bsa1", ""));
		setBkgRf41(JSPUtil.getParameter(request, prefix + "bkg_rf41", ""));
		setBsa3(JSPUtil.getParameter(request, prefix + "bsa3", ""));
		setBkg2061(JSPUtil.getParameter(request, prefix + "bkg_2061", ""));
		setBsa2(JSPUtil.getParameter(request, prefix + "bsa2", ""));
		setPref41(JSPUtil.getParameter(request, prefix + "pref41", ""));
		setBkgR521(JSPUtil.getParameter(request, prefix + "bkg_r521", ""));
		setBkgD451(JSPUtil.getParameter(request, prefix + "bkg_d451", ""));
		setBkgRd51(JSPUtil.getParameter(request, prefix + "bkg_rd51", ""));
		setBkg4041(JSPUtil.getParameter(request, prefix + "bkg_4041", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setBkg61(JSPUtil.getParameter(request, prefix + "bkg61", ""));
		setCmOc51(JSPUtil.getParameter(request, prefix + "cm_oc51", ""));
		setBkgR211(JSPUtil.getParameter(request, prefix + "bkg_r211", ""));
		setAlcRf31(JSPUtil.getParameter(request, prefix + "alc_rf31", ""));
		setAlc61(JSPUtil.getParameter(request, prefix + "alc61", ""));
		setBkg4561(JSPUtil.getParameter(request, prefix + "bkg_4561", ""));
		setBkg2051(JSPUtil.getParameter(request, prefix + "bkg_2051", ""));
		setBkgHc61(JSPUtil.getParameter(request, prefix + "bkg_hc61", ""));
		setPrefRf31(JSPUtil.getParameter(request, prefix + "pref_rf31", ""));
		setBkgD241(JSPUtil.getParameter(request, prefix + "bkg_d241", ""));
		setBkgRf51(JSPUtil.getParameter(request, prefix + "bkg_rf51", ""));
		setPref51(JSPUtil.getParameter(request, prefix + "pref51", ""));
		setBkgR531(JSPUtil.getParameter(request, prefix + "bkg_r531", ""));
		setUsaBkgModCd(JSPUtil.getParameter(request, prefix + "usa_bkg_mod_cd", ""));
		setDestLocCd(JSPUtil.getParameter(request, prefix + "dest_loc_cd", ""));
		setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
		
		setRatio51(JSPUtil.getParameter(request, prefix + "ratio51", ""));
		setCm41(JSPUtil.getParameter(request, prefix + "cm41", ""));
		setRatio11(JSPUtil.getParameter(request, prefix + "ratio11", ""));
		setRatio31(JSPUtil.getParameter(request, prefix + "ratio31", ""));
		setCm21(JSPUtil.getParameter(request, prefix + "cm21", ""));
		setRatio21(JSPUtil.getParameter(request, prefix + "ratio21", ""));
		setCm11(JSPUtil.getParameter(request, prefix + "cm11", ""));
		setCm51(JSPUtil.getParameter(request, prefix + "cm51", ""));
		setRatio61(JSPUtil.getParameter(request, prefix + "ratio61", ""));
		setCm61(JSPUtil.getParameter(request, prefix + "cm61", ""));
		setRatio41(JSPUtil.getParameter(request, prefix + "ratio41", ""));
		setCm31(JSPUtil.getParameter(request, prefix + "cm31", ""));
		
		setCmEn11(JSPUtil.getParameter(request, prefix + "cm_en11", ""));
		setCmEn21(JSPUtil.getParameter(request, prefix + "cm_en21", ""));
		setCmEn31(JSPUtil.getParameter(request, prefix + "cm_en31", ""));
		setCmEn41(JSPUtil.getParameter(request, prefix + "cm_en41", ""));
		setCmEn51(JSPUtil.getParameter(request, prefix + "cm_en51", ""));
		setCmEn61(JSPUtil.getParameter(request, prefix + "cm_en61", ""));
		
		setPrf11(JSPUtil.getParameter(request, prefix + "prf11", ""));
		setPrf21(JSPUtil.getParameter(request, prefix + "prf21", ""));
		setPrf31(JSPUtil.getParameter(request, prefix + "prf31", ""));
		setPrf41(JSPUtil.getParameter(request, prefix + "prf41", ""));
		setPrf51(JSPUtil.getParameter(request, prefix + "prf51", ""));
		setPrf61(JSPUtil.getParameter(request, prefix + "prf61", ""));
	
		setBsaw1(JSPUtil.getParameter(request, prefix + "bsaw1", ""));
		setBsaw2(JSPUtil.getParameter(request, prefix + "bsaw2", ""));
		setBsaw3(JSPUtil.getParameter(request, prefix + "bsaw3", ""));
		setBsaw4(JSPUtil.getParameter(request, prefix + "bsaw4", ""));
		setBsaw5(JSPUtil.getParameter(request, prefix + "bsaw5", ""));
		setBsaw6(JSPUtil.getParameter(request, prefix + "bsaw6", ""));
		
		setBkgw1(JSPUtil.getParameter(request, prefix + "bkgw1", ""));
		setBkgw2(JSPUtil.getParameter(request, prefix + "bkgw2", ""));
		setBkgw3(JSPUtil.getParameter(request, prefix + "bkgw3", ""));
		setBkgw4(JSPUtil.getParameter(request, prefix + "bkgw4", ""));
		setBkgw5(JSPUtil.getParameter(request, prefix + "bkgw5", ""));
		setBkgw6(JSPUtil.getParameter(request, prefix + "bkgw6", ""));	
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSpaceControlInquiry021AllocPortViewListVO[]
	 */
	public SearchSpaceControlInquiry021AllocPortViewListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSpaceControlInquiry021AllocPortViewListVO[]
	 */
	public SearchSpaceControlInquiry021AllocPortViewListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSpaceControlInquiry021AllocPortViewListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgR221 = (JSPUtil.getParameter(request, prefix	+ "bkg_r221", length));
			String[] bkgHc11 = (JSPUtil.getParameter(request, prefix	+ "bkg_hc11", length));
			String[] cmOp61 = (JSPUtil.getParameter(request, prefix	+ "cm_op61", length));
			String[] bkgR551 = (JSPUtil.getParameter(request, prefix	+ "bkg_r551", length));
			String[] bkgRd21 = (JSPUtil.getParameter(request, prefix	+ "bkg_rd21", length));
			String[] bkgAvgQty41 = (JSPUtil.getParameter(request, prefix	+ "bkg_avg_qty41", length));
			String[] fct61 = (JSPUtil.getParameter(request, prefix	+ "fct61", length));
			String[] bkg4531 = (JSPUtil.getParameter(request, prefix	+ "bkg_4531", length));
			String[] custCtrlCd = (JSPUtil.getParameter(request, prefix	+ "cust_ctrl_cd", length));
			String[] cmVl61 = (JSPUtil.getParameter(request, prefix	+ "cm_vl61", length));
			String[] fct11 = (JSPUtil.getParameter(request, prefix	+ "fct11", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] maxQty51 = (JSPUtil.getParameter(request, prefix	+ "max_qty51", length));
			String[] cmOc61 = (JSPUtil.getParameter(request, prefix	+ "cm_oc61", length));
			String[] bkgD211 = (JSPUtil.getParameter(request, prefix	+ "bkg_d211", length));
			String[] alcRf61 = (JSPUtil.getParameter(request, prefix	+ "alc_rf61", length));
			String[] bkgAvgQty31 = (JSPUtil.getParameter(request, prefix	+ "bkg_avg_qty31", length));
			String[] custGrpNm = (JSPUtil.getParameter(request, prefix	+ "cust_grp_nm", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] bkg5331 = (JSPUtil.getParameter(request, prefix	+ "bkg_5331", length));
			String[] bkgRf31 = (JSPUtil.getParameter(request, prefix	+ "bkg_rf31", length));
			String[] bkg2041 = (JSPUtil.getParameter(request, prefix	+ "bkg_2041", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] prefRf61 = (JSPUtil.getParameter(request, prefix	+ "pref_rf61", length));
			String[] bkg21 = (JSPUtil.getParameter(request, prefix	+ "bkg21", length));
			String[] bkgR231 = (JSPUtil.getParameter(request, prefix	+ "bkg_r231", length));
			String[] alc11 = (JSPUtil.getParameter(request, prefix	+ "alc11", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] cmOp51 = (JSPUtil.getParameter(request, prefix	+ "cm_op51", length));
			String[] bkgR541 = (JSPUtil.getParameter(request, prefix	+ "bkg_r541", length));
			String[] cmVl51 = (JSPUtil.getParameter(request, prefix	+ "cm_vl51", length));
			String[] cfct61 = (JSPUtil.getParameter(request, prefix	+ "cfct61", length));
			String[] bkgAvgQty51 = (JSPUtil.getParameter(request, prefix	+ "bkg_avg_qty51", length));
			String[] bkg4541 = (JSPUtil.getParameter(request, prefix	+ "bkg_4541", length));
			String[] bkgRd31 = (JSPUtil.getParameter(request, prefix	+ "bkg_rd31", length));
			String[] vvd2 = (JSPUtil.getParameter(request, prefix	+ "vvd2", length));
			String[] vvd3 = (JSPUtil.getParameter(request, prefix	+ "vvd3", length));
			String[] vvd1 = (JSPUtil.getParameter(request, prefix	+ "vvd1", length));
			String[] maxQty61 = (JSPUtil.getParameter(request, prefix	+ "max_qty61", length));
			String[] vvd6 = (JSPUtil.getParameter(request, prefix	+ "vvd6", length));
			String[] vvd5 = (JSPUtil.getParameter(request, prefix	+ "vvd5", length));
			String[] vvd4 = (JSPUtil.getParameter(request, prefix	+ "vvd4", length));
			String[] qta61 = (JSPUtil.getParameter(request, prefix	+ "qta61", length));
			String[] bkgD221 = (JSPUtil.getParameter(request, prefix	+ "bkg_d221", length));
			String[] gid = (JSPUtil.getParameter(request, prefix	+ "gid", length));
			String[] bkgRf21 = (JSPUtil.getParameter(request, prefix	+ "bkg_rf21", length));
			String[] bkg5321 = (JSPUtil.getParameter(request, prefix	+ "bkg_5321", length));
			String[] bkg2031 = (JSPUtil.getParameter(request, prefix	+ "bkg_2031", length));
			String[] prefRf51 = (JSPUtil.getParameter(request, prefix	+ "pref_rf51", length));
			String[] othCustNm = (JSPUtil.getParameter(request, prefix	+ "oth_cust_nm", length));
			String[] alcRf51 = (JSPUtil.getParameter(request, prefix	+ "alc_rf51", length));
			String[] bkg11 = (JSPUtil.getParameter(request, prefix	+ "bkg11", length));
			String[] bkgR241 = (JSPUtil.getParameter(request, prefix	+ "bkg_r241", length));
			String[] custNo = (JSPUtil.getParameter(request, prefix	+ "cust_no", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] fct41 = (JSPUtil.getParameter(request, prefix	+ "fct41", length));
			String[] fct31 = (JSPUtil.getParameter(request, prefix	+ "fct31", length));
			String[] maxQty31 = (JSPUtil.getParameter(request, prefix	+ "max_qty31", length));
			String[] alc21 = (JSPUtil.getParameter(request, prefix	+ "alc21", length));
			String[] cmOp41 = (JSPUtil.getParameter(request, prefix	+ "cm_op41", length));
			String[] bkg4511 = (JSPUtil.getParameter(request, prefix	+ "bkg_4511", length));
			String[] bkgHc31 = (JSPUtil.getParameter(request, prefix	+ "bkg_hc31", length));
			String[] cmVl41 = (JSPUtil.getParameter(request, prefix	+ "cm_vl41", length));
			String[] port4 = (JSPUtil.getParameter(request, prefix	+ "port4", length));
			String[] cfct51 = (JSPUtil.getParameter(request, prefix	+ "cfct51", length));
			String[] qta51 = (JSPUtil.getParameter(request, prefix	+ "qta51", length));
			String[] port3 = (JSPUtil.getParameter(request, prefix	+ "port3", length));
			String[] bkgAvgQty11 = (JSPUtil.getParameter(request, prefix	+ "bkg_avg_qty11", length));
			String[] port2 = (JSPUtil.getParameter(request, prefix	+ "port2", length));
			String[] port1 = (JSPUtil.getParameter(request, prefix	+ "port1", length));
			String[] port6 = (JSPUtil.getParameter(request, prefix	+ "port6", length));
			String[] port5 = (JSPUtil.getParameter(request, prefix	+ "port5", length));
			String[] bkg4021 = (JSPUtil.getParameter(request, prefix	+ "bkg_4021", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] bkg2021 = (JSPUtil.getParameter(request, prefix	+ "bkg_2021", length));
			String[] bkgD421 = (JSPUtil.getParameter(request, prefix	+ "bkg_d421", length));
			String[] bkgRf11 = (JSPUtil.getParameter(request, prefix	+ "bkg_rf11", length));
			String[] aqCd = (JSPUtil.getParameter(request, prefix	+ "aq_cd", length));
			String[] bkg5351 = (JSPUtil.getParameter(request, prefix	+ "bkg_5351", length));
			String[] bkgR561 = (JSPUtil.getParameter(request, prefix	+ "bkg_r561", length));
			String[] cmOc11 = (JSPUtil.getParameter(request, prefix	+ "cm_oc11", length));
			String[] bkgR251 = (JSPUtil.getParameter(request, prefix	+ "bkg_r251", length));
			String[] bkgHc21 = (JSPUtil.getParameter(request, prefix	+ "bkg_hc21", length));
			String[] cnt = (JSPUtil.getParameter(request, prefix	+ "cnt", length));
			String[] bsaAvg = (JSPUtil.getParameter(request, prefix	+ "bsa_avg", length));
			String[] alc31 = (JSPUtil.getParameter(request, prefix	+ "alc31", length));
			String[] fct21 = (JSPUtil.getParameter(request, prefix	+ "fct21", length));
			String[] custClss = (JSPUtil.getParameter(request, prefix	+ "cust_clss", length));
			String[] fct51 = (JSPUtil.getParameter(request, prefix	+ "fct51", length));
			String[] cmVl31 = (JSPUtil.getParameter(request, prefix	+ "cm_vl31", length));
			String[] pref61 = (JSPUtil.getParameter(request, prefix	+ "pref61", length));
			String[] cmOp31 = (JSPUtil.getParameter(request, prefix	+ "cm_op31", length));
			String[] bkg4521 = (JSPUtil.getParameter(request, prefix	+ "bkg_4521", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] subOfcCd = (JSPUtil.getParameter(request, prefix	+ "sub_ofc_cd", length));
			String[] bkgRd11 = (JSPUtil.getParameter(request, prefix	+ "bkg_rd11", length));
			String[] cfct41 = (JSPUtil.getParameter(request, prefix	+ "cfct41", length));
			String[] qta41 = (JSPUtil.getParameter(request, prefix	+ "qta41", length));
			String[] bkgAvgQty21 = (JSPUtil.getParameter(request, prefix	+ "bkg_avg_qty21", length));
			String[] dest = (JSPUtil.getParameter(request, prefix	+ "dest", length));
			String[] t = (JSPUtil.getParameter(request, prefix	+ "t", length));
			String[] bkg4011 = (JSPUtil.getParameter(request, prefix	+ "bkg_4011", length));
			String[] maxQty41 = (JSPUtil.getParameter(request, prefix	+ "max_qty41", length));
			String[] bkgD411 = (JSPUtil.getParameter(request, prefix	+ "bkg_d411", length));
			String[] bkg5341 = (JSPUtil.getParameter(request, prefix	+ "bkg_5341", length));
			String[] bkg2011 = (JSPUtil.getParameter(request, prefix	+ "bkg_2011", length));
			String[] bkgD441 = (JSPUtil.getParameter(request, prefix	+ "bkg_d441", length));
			String[] cmOp21 = (JSPUtil.getParameter(request, prefix	+ "cm_op21", length));
			String[] maxQty11 = (JSPUtil.getParameter(request, prefix	+ "max_qty11", length));
			String[] pref11 = (JSPUtil.getParameter(request, prefix	+ "pref11", length));
			String[] bkgRd61 = (JSPUtil.getParameter(request, prefix	+ "bkg_rd61", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] cmVl11 = (JSPUtil.getParameter(request, prefix	+ "cm_vl11", length));
			String[] bkg4051 = (JSPUtil.getParameter(request, prefix	+ "bkg_4051", length));
			String[] bkg31 = (JSPUtil.getParameter(request, prefix	+ "bkg31", length));
			String[] cmOc21 = (JSPUtil.getParameter(request, prefix	+ "cm_oc21", length));
			String[] alc51 = (JSPUtil.getParameter(request, prefix	+ "alc51", length));
			String[] cmVl21 = (JSPUtil.getParameter(request, prefix	+ "cm_vl21", length));
			String[] acctTp = (JSPUtil.getParameter(request, prefix	+ "acct_tp", length));
			String[] prefRf21 = (JSPUtil.getParameter(request, prefix	+ "pref_rf21", length));
			String[] bkgHc51 = (JSPUtil.getParameter(request, prefix	+ "bkg_hc51", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] alcRf21 = (JSPUtil.getParameter(request, prefix	+ "alc_rf21", length));
			String[] qta31 = (JSPUtil.getParameter(request, prefix	+ "qta31", length));
			String[] bkgRf61 = (JSPUtil.getParameter(request, prefix	+ "bkg_rf61", length));
			String[] bkgR261 = (JSPUtil.getParameter(request, prefix	+ "bkg_r261", length));
			String[] bkgD251 = (JSPUtil.getParameter(request, prefix	+ "bkg_d251", length));
			String[] cfct31 = (JSPUtil.getParameter(request, prefix	+ "cfct31", length));
			String[] cmOp11 = (JSPUtil.getParameter(request, prefix	+ "cm_op11", length));
			String[] custGrpId = (JSPUtil.getParameter(request, prefix	+ "cust_grp_id", length));
			String[] maxQty21 = (JSPUtil.getParameter(request, prefix	+ "max_qty21", length));
			String[] pref21 = (JSPUtil.getParameter(request, prefix	+ "pref21", length));
			String[] bkgD431 = (JSPUtil.getParameter(request, prefix	+ "bkg_d431", length));
			String[] bkg41 = (JSPUtil.getParameter(request, prefix	+ "bkg41", length));
			String[] cmOc31 = (JSPUtil.getParameter(request, prefix	+ "cm_oc31", length));
			String[] bkg4061 = (JSPUtil.getParameter(request, prefix	+ "bkg_4061", length));
			String[] prefRf11 = (JSPUtil.getParameter(request, prefix	+ "pref_rf11", length));
			String[] bkgD261 = (JSPUtil.getParameter(request, prefix	+ "bkg_d261", length));
			String[] alcRf11 = (JSPUtil.getParameter(request, prefix	+ "alc_rf11", length));
			String[] alc41 = (JSPUtil.getParameter(request, prefix	+ "alc41", length));
			String[] bkgHc41 = (JSPUtil.getParameter(request, prefix	+ "bkg_hc41", length));
			String[] qta21 = (JSPUtil.getParameter(request, prefix	+ "qta21", length));
			String[] cfct21 = (JSPUtil.getParameter(request, prefix	+ "cfct21", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] bkg5361 = (JSPUtil.getParameter(request, prefix	+ "bkg_5361", length));
			String[] pref31 = (JSPUtil.getParameter(request, prefix	+ "pref31", length));
			String[] bkgR511 = (JSPUtil.getParameter(request, prefix	+ "bkg_r511", length));
			String[] bkgD461 = (JSPUtil.getParameter(request, prefix	+ "bkg_d461", length));
			String[] bkgAvgQty61 = (JSPUtil.getParameter(request, prefix	+ "bkg_avg_qty61", length));
			String[] bkgRd41 = (JSPUtil.getParameter(request, prefix	+ "bkg_rd41", length));
			String[] bkg4031 = (JSPUtil.getParameter(request, prefix	+ "bkg_4031", length));
			String[] bkg51 = (JSPUtil.getParameter(request, prefix	+ "bkg51", length));
			String[] cmOc41 = (JSPUtil.getParameter(request, prefix	+ "cm_oc41", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] alcRf41 = (JSPUtil.getParameter(request, prefix	+ "alc_rf41", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkg5311 = (JSPUtil.getParameter(request, prefix	+ "bkg_5311", length));
			String[] bkg4551 = (JSPUtil.getParameter(request, prefix	+ "bkg_4551", length));
			String[] prefRf41 = (JSPUtil.getParameter(request, prefix	+ "pref_rf41", length));
			String[] bsa5 = (JSPUtil.getParameter(request, prefix	+ "bsa5", length));
			String[] bsa4 = (JSPUtil.getParameter(request, prefix	+ "bsa4", length));
			String[] bsa6 = (JSPUtil.getParameter(request, prefix	+ "bsa6", length));
			String[] bkgD231 = (JSPUtil.getParameter(request, prefix	+ "bkg_d231", length));
			String[] cfct11 = (JSPUtil.getParameter(request, prefix	+ "cfct11", length));
			String[] qta11 = (JSPUtil.getParameter(request, prefix	+ "qta11", length));
			String[] bsa1 = (JSPUtil.getParameter(request, prefix	+ "bsa1", length));
			String[] bkgRf41 = (JSPUtil.getParameter(request, prefix	+ "bkg_rf41", length));
			String[] bsa3 = (JSPUtil.getParameter(request, prefix	+ "bsa3", length));
			String[] bkg2061 = (JSPUtil.getParameter(request, prefix	+ "bkg_2061", length));
			String[] bsa2 = (JSPUtil.getParameter(request, prefix	+ "bsa2", length));
			String[] pref41 = (JSPUtil.getParameter(request, prefix	+ "pref41", length));
			String[] bkgR521 = (JSPUtil.getParameter(request, prefix	+ "bkg_r521", length));
			String[] bkgD451 = (JSPUtil.getParameter(request, prefix	+ "bkg_d451", length));
			String[] bkgRd51 = (JSPUtil.getParameter(request, prefix	+ "bkg_rd51", length));
			String[] bkg4041 = (JSPUtil.getParameter(request, prefix	+ "bkg_4041", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] bkg61 = (JSPUtil.getParameter(request, prefix	+ "bkg61", length));
			String[] cmOc51 = (JSPUtil.getParameter(request, prefix	+ "cm_oc51", length));
			String[] bkgR211 = (JSPUtil.getParameter(request, prefix	+ "bkg_r211", length));
			String[] alcRf31 = (JSPUtil.getParameter(request, prefix	+ "alc_rf31", length));
			String[] alc61 = (JSPUtil.getParameter(request, prefix	+ "alc61", length));
			String[] bkg4561 = (JSPUtil.getParameter(request, prefix	+ "bkg_4561", length));
			String[] bkg2051 = (JSPUtil.getParameter(request, prefix	+ "bkg_2051", length));
			String[] bkgHc61 = (JSPUtil.getParameter(request, prefix	+ "bkg_hc61", length));
			String[] prefRf31 = (JSPUtil.getParameter(request, prefix	+ "pref_rf31", length));
			String[] bkgD241 = (JSPUtil.getParameter(request, prefix	+ "bkg_d241", length));
			String[] bkgRf51 = (JSPUtil.getParameter(request, prefix	+ "bkg_rf51", length));
			String[] pref51 = (JSPUtil.getParameter(request, prefix	+ "pref51", length));
			String[] bkgR531 = (JSPUtil.getParameter(request, prefix	+ "bkg_r531", length));
			String[] usaBkgModCd = (JSPUtil.getParameter(request, prefix	+ "usa_bkg_mod_cd", length));
			String[] destLocCd = (JSPUtil.getParameter(request, prefix	+ "dest_loc_cd", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			
			String[] ratio51 = (JSPUtil.getParameter(request, prefix	+ "ratio51", length));
			String[] cm41 = (JSPUtil.getParameter(request, prefix	+ "cm41", length));
			String[] ratio11 = (JSPUtil.getParameter(request, prefix	+ "ratio11", length));
			String[] ratio31 = (JSPUtil.getParameter(request, prefix	+ "ratio31", length));
			String[] cm21 = (JSPUtil.getParameter(request, prefix	+ "cm21", length));
			String[] ratio21 = (JSPUtil.getParameter(request, prefix	+ "ratio21", length));
			String[] cm11 = (JSPUtil.getParameter(request, prefix	+ "cm11", length));
			String[] cm51 = (JSPUtil.getParameter(request, prefix	+ "cm51", length));
			String[] ratio61 = (JSPUtil.getParameter(request, prefix	+ "ratio61", length));
			String[] cm61 = (JSPUtil.getParameter(request, prefix	+ "cm61", length));
			String[] ratio41 = (JSPUtil.getParameter(request, prefix	+ "ratio41", length));
			String[] cm31 = (JSPUtil.getParameter(request, prefix	+ "cm31", length));
			String[] cmb31 = (JSPUtil.getParameter(request, prefix	+ "cmb31", length));
			String[] cmb41 = (JSPUtil.getParameter(request, prefix	+ "cmb41", length));
			String[] cmb61 = (JSPUtil.getParameter(request, prefix	+ "cmb61", length));
			String[] cmb11 = (JSPUtil.getParameter(request, prefix	+ "cmb11", length));
			String[] cmb51 = (JSPUtil.getParameter(request, prefix	+ "cmb51", length));
			String[] cmb21 = (JSPUtil.getParameter(request, prefix	+ "cmb21", length));

			String[] cmEn11 = (JSPUtil.getParameter(request, prefix	+ "cmEn11", length));
			String[] cmEn21 = (JSPUtil.getParameter(request, prefix	+ "cmEn21", length));
			String[] cmEn31 = (JSPUtil.getParameter(request, prefix	+ "cmEn31", length));
			String[] cmEn41 = (JSPUtil.getParameter(request, prefix	+ "cmEn41", length));
			String[] cmEn51 = (JSPUtil.getParameter(request, prefix	+ "cmEn51", length));
			String[] cmEn61 = (JSPUtil.getParameter(request, prefix	+ "cmEn61", length));
			
			String[] prf11 = (JSPUtil.getParameter(request, prefix	+ "prf11", length));
			String[] prf21 = (JSPUtil.getParameter(request, prefix	+ "prf21", length));
			String[] prf31 = (JSPUtil.getParameter(request, prefix	+ "prf31", length));
			String[] prf41 = (JSPUtil.getParameter(request, prefix	+ "prf41", length));
			String[] prf51 = (JSPUtil.getParameter(request, prefix	+ "prf51", length));
			String[] prf61 = (JSPUtil.getParameter(request, prefix	+ "prf61", length));
			
			String[] bsaw1 = (JSPUtil.getParameter(request, prefix	+ "bsaw1", length));
			String[] bsaw2 = (JSPUtil.getParameter(request, prefix	+ "bsaw2", length));
			String[] bsaw3 = (JSPUtil.getParameter(request, prefix	+ "bsaw3", length));
			String[] bsaw4 = (JSPUtil.getParameter(request, prefix	+ "bsaw4", length));
			String[] bsaw5 = (JSPUtil.getParameter(request, prefix	+ "bsaw5", length));
			String[] bsaw6 = (JSPUtil.getParameter(request, prefix	+ "bsaw6", length));
			
			String[] bkgw1 = (JSPUtil.getParameter(request, prefix	+ "bkgw1", length));
			String[] bkgw2 = (JSPUtil.getParameter(request, prefix	+ "bkgw2", length));
			String[] bkgw3 = (JSPUtil.getParameter(request, prefix	+ "bkgw3", length));
			String[] bkgw4 = (JSPUtil.getParameter(request, prefix	+ "bkgw4", length));
			String[] bkgw5 = (JSPUtil.getParameter(request, prefix	+ "bkgw5", length));
			String[] bkgw6 = (JSPUtil.getParameter(request, prefix	+ "bkgw6", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSpaceControlInquiry021AllocPortViewListVO();
				if (bkgR221[i] != null)
					model.setBkgR221(bkgR221[i]);
				if (bkgHc11[i] != null)
					model.setBkgHc11(bkgHc11[i]);
				if (cmOp61[i] != null)
					model.setCmOp61(cmOp61[i]);
				if (bkgR551[i] != null)
					model.setBkgR551(bkgR551[i]);
				if (bkgRd21[i] != null)
					model.setBkgRd21(bkgRd21[i]);
				if (bkgAvgQty41[i] != null)
					model.setBkgAvgQty41(bkgAvgQty41[i]);
				if (fct61[i] != null)
					model.setFct61(fct61[i]);
				if (bkg4531[i] != null)
					model.setBkg4531(bkg4531[i]);
				if (custCtrlCd[i] != null)
					model.setCustCtrlCd(custCtrlCd[i]);
				if (cmVl61[i] != null)
					model.setCmVl61(cmVl61[i]);
				if (fct11[i] != null)
					model.setFct11(fct11[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (maxQty51[i] != null)
					model.setMaxQty51(maxQty51[i]);
				if (cmOc61[i] != null)
					model.setCmOc61(cmOc61[i]);
				if (bkgD211[i] != null)
					model.setBkgD211(bkgD211[i]);
				if (alcRf61[i] != null)
					model.setAlcRf61(alcRf61[i]);
				if (bkgAvgQty31[i] != null)
					model.setBkgAvgQty31(bkgAvgQty31[i]);
				if (custGrpNm[i] != null)
					model.setCustGrpNm(custGrpNm[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (bkg5331[i] != null)
					model.setBkg5331(bkg5331[i]);
				if (bkgRf31[i] != null)
					model.setBkgRf31(bkgRf31[i]);
				if (bkg2041[i] != null)
					model.setBkg2041(bkg2041[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (prefRf61[i] != null)
					model.setPrefRf61(prefRf61[i]);
				if (bkg21[i] != null)
					model.setBkg21(bkg21[i]);
				if (bkgR231[i] != null)
					model.setBkgR231(bkgR231[i]);
				if (alc11[i] != null)
					model.setAlc11(alc11[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (cmOp51[i] != null)
					model.setCmOp51(cmOp51[i]);
				if (bkgR541[i] != null)
					model.setBkgR541(bkgR541[i]);
				if (cmVl51[i] != null)
					model.setCmVl51(cmVl51[i]);
				if (cfct61[i] != null)
					model.setCfct61(cfct61[i]);
				if (bkgAvgQty51[i] != null)
					model.setBkgAvgQty51(bkgAvgQty51[i]);
				if (bkg4541[i] != null)
					model.setBkg4541(bkg4541[i]);
				if (bkgRd31[i] != null)
					model.setBkgRd31(bkgRd31[i]);
				if (vvd2[i] != null)
					model.setVvd2(vvd2[i]);
				if (vvd3[i] != null)
					model.setVvd3(vvd3[i]);
				if (vvd1[i] != null)
					model.setVvd1(vvd1[i]);
				if (maxQty61[i] != null)
					model.setMaxQty61(maxQty61[i]);
				if (vvd6[i] != null)
					model.setVvd6(vvd6[i]);
				if (vvd5[i] != null)
					model.setVvd5(vvd5[i]);
				if (vvd4[i] != null)
					model.setVvd4(vvd4[i]);
				if (qta61[i] != null)
					model.setQta61(qta61[i]);
				if (bkgD221[i] != null)
					model.setBkgD221(bkgD221[i]);
				if (gid[i] != null)
					model.setGid(gid[i]);
				if (bkgRf21[i] != null)
					model.setBkgRf21(bkgRf21[i]);
				if (bkg5321[i] != null)
					model.setBkg5321(bkg5321[i]);
				if (bkg2031[i] != null)
					model.setBkg2031(bkg2031[i]);
				if (prefRf51[i] != null)
					model.setPrefRf51(prefRf51[i]);
				if (othCustNm[i] != null)
					model.setOthCustNm(othCustNm[i]);
				if (alcRf51[i] != null)
					model.setAlcRf51(alcRf51[i]);
				if (bkg11[i] != null)
					model.setBkg11(bkg11[i]);
				if (bkgR241[i] != null)
					model.setBkgR241(bkgR241[i]);
				if (custNo[i] != null)
					model.setCustNo(custNo[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (fct41[i] != null)
					model.setFct41(fct41[i]);
				if (fct31[i] != null)
					model.setFct31(fct31[i]);
				if (maxQty31[i] != null)
					model.setMaxQty31(maxQty31[i]);
				if (alc21[i] != null)
					model.setAlc21(alc21[i]);
				if (cmOp41[i] != null)
					model.setCmOp41(cmOp41[i]);
				if (bkg4511[i] != null)
					model.setBkg4511(bkg4511[i]);
				if (bkgHc31[i] != null)
					model.setBkgHc31(bkgHc31[i]);
				if (cmVl41[i] != null)
					model.setCmVl41(cmVl41[i]);
				if (port4[i] != null)
					model.setPort4(port4[i]);
				if (cfct51[i] != null)
					model.setCfct51(cfct51[i]);
				if (qta51[i] != null)
					model.setQta51(qta51[i]);
				if (port3[i] != null)
					model.setPort3(port3[i]);
				if (bkgAvgQty11[i] != null)
					model.setBkgAvgQty11(bkgAvgQty11[i]);
				if (port2[i] != null)
					model.setPort2(port2[i]);
				if (port1[i] != null)
					model.setPort1(port1[i]);
				if (port6[i] != null)
					model.setPort6(port6[i]);
				if (port5[i] != null)
					model.setPort5(port5[i]);
				if (bkg4021[i] != null)
					model.setBkg4021(bkg4021[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (bkg2021[i] != null)
					model.setBkg2021(bkg2021[i]);
				if (bkgD421[i] != null)
					model.setBkgD421(bkgD421[i]);
				if (bkgRf11[i] != null)
					model.setBkgRf11(bkgRf11[i]);
				if (aqCd[i] != null)
					model.setAqCd(aqCd[i]);
				if (bkg5351[i] != null)
					model.setBkg5351(bkg5351[i]);
				if (bkgR561[i] != null)
					model.setBkgR561(bkgR561[i]);
				if (cmOc11[i] != null)
					model.setCmOc11(cmOc11[i]);
				if (bkgR251[i] != null)
					model.setBkgR251(bkgR251[i]);
				if (bkgHc21[i] != null)
					model.setBkgHc21(bkgHc21[i]);
				if (cnt[i] != null)
					model.setCnt(cnt[i]);
				if (bsaAvg[i] != null)
					model.setBsaAvg(bsaAvg[i]);
				if (alc31[i] != null)
					model.setAlc31(alc31[i]);
				if (fct21[i] != null)
					model.setFct21(fct21[i]);
				if (custClss[i] != null)
					model.setCustClss(custClss[i]);
				if (fct51[i] != null)
					model.setFct51(fct51[i]);
				if (cmVl31[i] != null)
					model.setCmVl31(cmVl31[i]);
				if (pref61[i] != null)
					model.setPref61(pref61[i]);
				if (cmOp31[i] != null)
					model.setCmOp31(cmOp31[i]);
				if (bkg4521[i] != null)
					model.setBkg4521(bkg4521[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (subOfcCd[i] != null)
					model.setSubOfcCd(subOfcCd[i]);
				if (bkgRd11[i] != null)
					model.setBkgRd11(bkgRd11[i]);
				if (cfct41[i] != null)
					model.setCfct41(cfct41[i]);
				if (qta41[i] != null)
					model.setQta41(qta41[i]);
				if (bkgAvgQty21[i] != null)
					model.setBkgAvgQty21(bkgAvgQty21[i]);
				if (dest[i] != null)
					model.setDest(dest[i]);
				if (t[i] != null)
					model.setT(t[i]);
				if (bkg4011[i] != null)
					model.setBkg4011(bkg4011[i]);
				if (maxQty41[i] != null)
					model.setMaxQty41(maxQty41[i]);
				if (bkgD411[i] != null)
					model.setBkgD411(bkgD411[i]);
				if (bkg5341[i] != null)
					model.setBkg5341(bkg5341[i]);
				if (bkg2011[i] != null)
					model.setBkg2011(bkg2011[i]);
				if (bkgD441[i] != null)
					model.setBkgD441(bkgD441[i]);
				if (cmOp21[i] != null)
					model.setCmOp21(cmOp21[i]);
				if (maxQty11[i] != null)
					model.setMaxQty11(maxQty11[i]);
				if (pref11[i] != null)
					model.setPref11(pref11[i]);
				if (bkgRd61[i] != null)
					model.setBkgRd61(bkgRd61[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (cmVl11[i] != null)
					model.setCmVl11(cmVl11[i]);
				if (bkg4051[i] != null)
					model.setBkg4051(bkg4051[i]);
				if (bkg31[i] != null)
					model.setBkg31(bkg31[i]);
				if (cmOc21[i] != null)
					model.setCmOc21(cmOc21[i]);
				if (alc51[i] != null)
					model.setAlc51(alc51[i]);
				if (cmVl21[i] != null)
					model.setCmVl21(cmVl21[i]);
				if (acctTp[i] != null)
					model.setAcctTp(acctTp[i]);
				if (prefRf21[i] != null)
					model.setPrefRf21(prefRf21[i]);
				if (bkgHc51[i] != null)
					model.setBkgHc51(bkgHc51[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (alcRf21[i] != null)
					model.setAlcRf21(alcRf21[i]);
				if (qta31[i] != null)
					model.setQta31(qta31[i]);
				if (bkgRf61[i] != null)
					model.setBkgRf61(bkgRf61[i]);
				if (bkgR261[i] != null)
					model.setBkgR261(bkgR261[i]);
				if (bkgD251[i] != null)
					model.setBkgD251(bkgD251[i]);
				if (cfct31[i] != null)
					model.setCfct31(cfct31[i]);
				if (cmOp11[i] != null)
					model.setCmOp11(cmOp11[i]);
				if (custGrpId[i] != null)
					model.setCustGrpId(custGrpId[i]);
				if (maxQty21[i] != null)
					model.setMaxQty21(maxQty21[i]);
				if (pref21[i] != null)
					model.setPref21(pref21[i]);
				if (bkgD431[i] != null)
					model.setBkgD431(bkgD431[i]);
				if (bkg41[i] != null)
					model.setBkg41(bkg41[i]);
				if (cmOc31[i] != null)
					model.setCmOc31(cmOc31[i]);
				if (bkg4061[i] != null)
					model.setBkg4061(bkg4061[i]);
				if (prefRf11[i] != null)
					model.setPrefRf11(prefRf11[i]);
				if (bkgD261[i] != null)
					model.setBkgD261(bkgD261[i]);
				if (alcRf11[i] != null)
					model.setAlcRf11(alcRf11[i]);
				if (alc41[i] != null)
					model.setAlc41(alc41[i]);
				if (bkgHc41[i] != null)
					model.setBkgHc41(bkgHc41[i]);
				if (qta21[i] != null)
					model.setQta21(qta21[i]);
				if (cfct21[i] != null)
					model.setCfct21(cfct21[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (bkg5361[i] != null)
					model.setBkg5361(bkg5361[i]);
				if (pref31[i] != null)
					model.setPref31(pref31[i]);
				if (bkgR511[i] != null)
					model.setBkgR511(bkgR511[i]);
				if (bkgD461[i] != null)
					model.setBkgD461(bkgD461[i]);
				if (bkgAvgQty61[i] != null)
					model.setBkgAvgQty61(bkgAvgQty61[i]);
				if (bkgRd41[i] != null)
					model.setBkgRd41(bkgRd41[i]);
				if (bkg4031[i] != null)
					model.setBkg4031(bkg4031[i]);
				if (bkg51[i] != null)
					model.setBkg51(bkg51[i]);
				if (cmOc41[i] != null)
					model.setCmOc41(cmOc41[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (alcRf41[i] != null)
					model.setAlcRf41(alcRf41[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkg5311[i] != null)
					model.setBkg5311(bkg5311[i]);
				if (bkg4551[i] != null)
					model.setBkg4551(bkg4551[i]);
				if (prefRf41[i] != null)
					model.setPrefRf41(prefRf41[i]);
				if (bsa5[i] != null)
					model.setBsa5(bsa5[i]);
				if (bsa4[i] != null)
					model.setBsa4(bsa4[i]);
				if (bsa6[i] != null)
					model.setBsa6(bsa6[i]);
				if (bkgD231[i] != null)
					model.setBkgD231(bkgD231[i]);
				if (cfct11[i] != null)
					model.setCfct11(cfct11[i]);
				if (qta11[i] != null)
					model.setQta11(qta11[i]);
				if (bsa1[i] != null)
					model.setBsa1(bsa1[i]);
				if (bkgRf41[i] != null)
					model.setBkgRf41(bkgRf41[i]);
				if (bsa3[i] != null)
					model.setBsa3(bsa3[i]);
				if (bkg2061[i] != null)
					model.setBkg2061(bkg2061[i]);
				if (bsa2[i] != null)
					model.setBsa2(bsa2[i]);
				if (pref41[i] != null)
					model.setPref41(pref41[i]);
				if (bkgR521[i] != null)
					model.setBkgR521(bkgR521[i]);
				if (bkgD451[i] != null)
					model.setBkgD451(bkgD451[i]);
				if (bkgRd51[i] != null)
					model.setBkgRd51(bkgRd51[i]);
				if (bkg4041[i] != null)
					model.setBkg4041(bkg4041[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (bkg61[i] != null)
					model.setBkg61(bkg61[i]);
				if (cmOc51[i] != null)
					model.setCmOc51(cmOc51[i]);
				if (bkgR211[i] != null)
					model.setBkgR211(bkgR211[i]);
				if (alcRf31[i] != null)
					model.setAlcRf31(alcRf31[i]);
				if (alc61[i] != null)
					model.setAlc61(alc61[i]);
				if (bkg4561[i] != null)
					model.setBkg4561(bkg4561[i]);
				if (bkg2051[i] != null)
					model.setBkg2051(bkg2051[i]);
				if (bkgHc61[i] != null)
					model.setBkgHc61(bkgHc61[i]);
				if (prefRf31[i] != null)
					model.setPrefRf31(prefRf31[i]);
				if (bkgD241[i] != null)
					model.setBkgD241(bkgD241[i]);
				if (bkgRf51[i] != null)
					model.setBkgRf51(bkgRf51[i]);
				if (pref51[i] != null)
					model.setPref51(pref51[i]);
				if (bkgR531[i] != null)
					model.setBkgR531(bkgR531[i]);
				if (usaBkgModCd[i] != null)
					model.setUsaBkgModCd(usaBkgModCd[i]);
				if (destLocCd[i] != null)
					model.setUsaBkgModCd(destLocCd[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);

				if (ratio51[i] != null)
					model.setRatio51(ratio51[i]);
				if (cm41[i] != null)
					model.setCm41(cm41[i]);
				if (ratio11[i] != null)
					model.setRatio11(ratio11[i]);
				if (ratio31[i] != null)
					model.setRatio31(ratio31[i]);
				if (cm21[i] != null)
					model.setCm21(cm21[i]);
				if (ratio21[i] != null)
					model.setRatio21(ratio21[i]);
				if (cm11[i] != null)
					model.setCm11(cm11[i]);
				if (cm51[i] != null)
					model.setCm51(cm51[i]);
				if (ratio61[i] != null)
					model.setRatio61(ratio61[i]);
				if (cm61[i] != null)
					model.setCm61(cm61[i]);
				if (ratio41[i] != null)
					model.setRatio41(ratio41[i]);
				if (cm31[i] != null)
					model.setCm31(cm31[i]);
				if (cmb31[i] != null)
					model.setCmb31(cmb31[i]);
				if (cmb41[i] != null)
					model.setCmb41(cmb41[i]);
				if (cmb61[i] != null)
					model.setCmb61(cmb61[i]);
				if (cmb11[i] != null)
					model.setCmb11(cmb11[i]);
				if (cmb51[i] != null)
					model.setCmb51(cmb51[i]);
				if (cmb21[i] != null)
					model.setCmb21(cmb21[i]);
				
				if (cmEn11[i] != null) model.setCmEn11(cmEn11[i]);
				if (cmEn21[i] != null) model.setCmEn21(cmEn21[i]);
				if (cmEn31[i] != null) model.setCmEn31(cmEn31[i]);
				if (cmEn41[i] != null) model.setCmEn41(cmEn41[i]);
				if (cmEn51[i] != null) model.setCmEn51(cmEn51[i]);
				if (cmEn61[i] != null) model.setCmEn61(cmEn61[i]);
				
				if (prf11[i] != null) model.setPrf11(prf11[i]);
				if (prf21[i] != null) model.setPrf21(prf21[i]);
				if (prf31[i] != null) model.setPrf31(prf31[i]);
				if (prf41[i] != null) model.setPrf41(prf41[i]);
				if (prf51[i] != null) model.setPrf51(prf51[i]);
				if (prf61[i] != null) model.setPrf61(prf61[i]);

				if (bsaw1[i] != null) model.setBsaw1(bsaw1[i]);
				if (bsaw2[i] != null) model.setBsaw2(bsaw2[i]);
				if (bsaw3[i] != null) model.setBsaw3(bsaw3[i]);
				if (bsaw4[i] != null) model.setBsaw4(bsaw4[i]);
				if (bsaw5[i] != null) model.setBsaw5(bsaw5[i]);
				if (bsaw6[i] != null) model.setBsaw6(bsaw6[i]);
				
				if (bkgw1[i] != null) model.setBkgw1(bkgw1[i]);
				if (bkgw2[i] != null) model.setBkgw2(bkgw2[i]);
				if (bkgw3[i] != null) model.setBkgw3(bkgw3[i]);
				if (bkgw4[i] != null) model.setBkgw4(bkgw4[i]);
				if (bkgw5[i] != null) model.setBkgw5(bkgw5[i]);
				if (bkgw6[i] != null) model.setBkgw6(bkgw6[i]);
								
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSpaceControlInquiry021AllocPortViewListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSpaceControlInquiry021AllocPortViewListVO[]
	 */
	public SearchSpaceControlInquiry021AllocPortViewListVO[] getSearchSpaceControlInquiry021AllocPortViewListVOs(){
		SearchSpaceControlInquiry021AllocPortViewListVO[] vos = (SearchSpaceControlInquiry021AllocPortViewListVO[])models.toArray(new SearchSpaceControlInquiry021AllocPortViewListVO[models.size()]);
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
		this.bkgR221 = this.bkgR221 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgHc11 = this.bkgHc11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmOp61 = this.cmOp61 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgR551 = this.bkgR551 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRd21 = this.bkgRd21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAvgQty41 = this.bkgAvgQty41 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fct61 = this.fct61 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg4531 = this.bkg4531 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCtrlCd = this.custCtrlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmVl61 = this.cmVl61 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fct11 = this.fct11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxQty51 = this.maxQty51 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmOc61 = this.cmOc61 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgD211 = this.bkgD211 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alcRf61 = this.alcRf61 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAvgQty31 = this.bkgAvgQty31 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custGrpNm = this.custGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg5331 = this.bkg5331 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRf31 = this.bkgRf31 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg2041 = this.bkg2041 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prefRf61 = this.prefRf61 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg21 = this.bkg21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgR231 = this.bkgR231 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alc11 = this.alc11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmOp51 = this.cmOp51 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgR541 = this.bkgR541 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmVl51 = this.cmVl51 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfct61 = this.cfct61 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAvgQty51 = this.bkgAvgQty51 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg4541 = this.bkg4541 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRd31 = this.bkgRd31 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd2 = this.vvd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd3 = this.vvd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd1 = this.vvd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxQty61 = this.maxQty61 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd6 = this.vvd6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd5 = this.vvd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd4 = this.vvd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qta61 = this.qta61 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgD221 = this.bkgD221 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gid = this.gid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRf21 = this.bkgRf21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg5321 = this.bkg5321 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg2031 = this.bkg2031 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prefRf51 = this.prefRf51 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.othCustNm = this.othCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alcRf51 = this.alcRf51 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg11 = this.bkg11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgR241 = this.bkgR241 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNo = this.custNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fct41 = this.fct41 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fct31 = this.fct31 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxQty31 = this.maxQty31 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alc21 = this.alc21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmOp41 = this.cmOp41 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg4511 = this.bkg4511 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgHc31 = this.bkgHc31 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmVl41 = this.cmVl41 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port4 = this.port4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfct51 = this.cfct51 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qta51 = this.qta51 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port3 = this.port3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAvgQty11 = this.bkgAvgQty11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port2 = this.port2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port1 = this.port1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port6 = this.port6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port5 = this.port5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg4021 = this.bkg4021 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg2021 = this.bkg2021 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgD421 = this.bkgD421 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRf11 = this.bkgRf11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aqCd = this.aqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg5351 = this.bkg5351 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgR561 = this.bkgR561 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmOc11 = this.cmOc11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgR251 = this.bkgR251 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgHc21 = this.bkgHc21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnt = this.cnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaAvg = this.bsaAvg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alc31 = this.alc31 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fct21 = this.fct21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custClss = this.custClss .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fct51 = this.fct51 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmVl31 = this.cmVl31 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pref61 = this.pref61 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmOp31 = this.cmOp31 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg4521 = this.bkg4521 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subOfcCd = this.subOfcCd  .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRd11 = this.bkgRd11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfct41 = this.cfct41 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qta41 = this.qta41 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAvgQty21 = this.bkgAvgQty21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dest = this.dest .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.t = this.t .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg4011 = this.bkg4011 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxQty41 = this.maxQty41 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgD411 = this.bkgD411 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg5341 = this.bkg5341 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg2011 = this.bkg2011 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgD441 = this.bkgD441 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmOp21 = this.cmOp21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxQty11 = this.maxQty11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pref11 = this.pref11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRd61 = this.bkgRd61 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmVl11 = this.cmVl11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg4051 = this.bkg4051 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg31 = this.bkg31 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmOc21 = this.cmOc21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alc51 = this.alc51 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmVl21 = this.cmVl21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctTp = this.acctTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prefRf21 = this.prefRf21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgHc51 = this.bkgHc51 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alcRf21 = this.alcRf21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qta31 = this.qta31 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRf61 = this.bkgRf61 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgR261 = this.bkgR261 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgD251 = this.bkgD251 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfct31 = this.cfct31 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmOp11 = this.cmOp11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custGrpId = this.custGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxQty21 = this.maxQty21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pref21 = this.pref21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgD431 = this.bkgD431 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg41 = this.bkg41 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmOc31 = this.cmOc31 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg4061 = this.bkg4061 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prefRf11 = this.prefRf11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgD261 = this.bkgD261 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alcRf11 = this.alcRf11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alc41 = this.alc41 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgHc41 = this.bkgHc41 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qta21 = this.qta21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfct21 = this.cfct21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg5361 = this.bkg5361 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pref31 = this.pref31 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgR511 = this.bkgR511 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgD461 = this.bkgD461 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAvgQty61 = this.bkgAvgQty61 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRd41 = this.bkgRd41 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg4031 = this.bkg4031 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg51 = this.bkg51 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmOc41 = this.cmOc41 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alcRf41 = this.alcRf41 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg5311 = this.bkg5311 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg4551 = this.bkg4551 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prefRf41 = this.prefRf41 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa5 = this.bsa5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa4 = this.bsa4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa6 = this.bsa6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgD231 = this.bkgD231 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfct11 = this.cfct11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qta11 = this.qta11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa1 = this.bsa1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRf41 = this.bkgRf41 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa3 = this.bsa3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg2061 = this.bkg2061 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa2 = this.bsa2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pref41 = this.pref41 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgR521 = this.bkgR521 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgD451 = this.bkgD451 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRd51 = this.bkgRd51 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg4041 = this.bkg4041 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg61 = this.bkg61 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmOc51 = this.cmOc51 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgR211 = this.bkgR211 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alcRf31 = this.alcRf31 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alc61 = this.alc61 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg4561 = this.bkg4561 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg2051 = this.bkg2051 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgHc61 = this.bkgHc61 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prefRf31 = this.prefRf31 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgD241 = this.bkgD241 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRf51 = this.bkgRf51 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pref51 = this.pref51 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgR531 = this.bkgR531 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaBkgModCd = this.usaBkgModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destLocCd = this.destLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.ratio51 = this.ratio51 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cm41 = this.cm41 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratio11 = this.ratio11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratio31 = this.ratio31 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cm21 = this.cm21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratio21 = this.ratio21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cm11 = this.cm11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cm51 = this.cm51 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratio61 = this.ratio61 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cm61 = this.cm61 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratio41 = this.ratio41 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cm31 = this.cm31 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmb31 = this.cmb31 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmb41 = this.cmb41 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmb61 = this.cmb61 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmb11 = this.cmb11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmb51 = this.cmb51 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmb21 = this.cmb21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.cmEn11 = this.cmEn11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmEn21 = this.cmEn21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmEn31 = this.cmEn31 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmEn41 = this.cmEn41 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmEn51 = this.cmEn51 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmEn61 = this.cmEn61 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.prf11 = this.prf11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prf21 = this.prf21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prf31 = this.prf31 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prf41 = this.prf41 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prf51 = this.prf51 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prf61 = this.prf61 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.bsaw1 = this.bsaw1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaw2 = this.bsaw2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaw3 = this.bsaw3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaw4 = this.bsaw4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaw5 = this.bsaw5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaw6 = this.bsaw6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.bkgw1 = this.bkgw1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgw2 = this.bkgw2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgw3 = this.bkgw3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgw4 = this.bkgw4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgw5 = this.bkgw5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgw6 = this.bkgw6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
