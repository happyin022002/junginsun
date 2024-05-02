/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TesAgreementManageCommonVO.java
*@FileTitle : TesAgreementManageCommonVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.12
*@LastModifier : yOnghO
*@LastVersion : 1.0
* 2016.02.12 yOnghO 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.vo;

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
 * @author yOnghO
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TesAgreementManageCommonVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TesAgreementManageCommonVO> models = new ArrayList<TesAgreementManageCommonVO>();
	
	/* Column Info */
	private String accmSeq = null;
	/* Column Info */
	private String f2R = null;
	/* Column Info */
	private String s2R = null;
	/* Column Info */
	private String r2R = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String moveRate = null;
	/* Column Info */
	private String laneCdstring = null;
	/* Column Info */
	private String a2Fd = null;
	/* Column Info */
	private String dcgoN7thClssFlgR = null;
	/* Column Info */
	private String sepDgNoneFd = null;
	/* Column Info */
	private String dcgoN2ndClssFlgR = null;
	/* Column Info */
	private String dcgoNonClssFlg = null;
	/* Column Info */
	private String dxFd = null;
	/* Column Info */
	private String o2R = null;
	/* Column Info */
	private String r9Fd = null;
	/* Column Info */
	private String dcgoN5thClssFlg = null;
	/* Column Info */
	private String r5Fd = null;
	/* Column Info */
	private String ydCdDeltflg = null;
	/* Column Info */
	private String effAgmt = null;
	/* Column Info */
	private String s4R = null;
	/* Column Info */
	private String dw = null;
	/* Column Info */
	private String dx = null;
	/* Column Info */
	private String sameDgNoneFd = null;
	/* Column Info */
	private String vfsarray = null;
	/* Column Info */
	private String dcgoN4thClssFlgR = null;
	/* Column Info */
	private String o5R = null;
	/* Column Info */
	private String dcgoN8thClssFlg = null;
	/* Column Info */
	private String teuRate = null;
	/* Column Info */
	private String f2 = null;
	/* Column Info */
	private String f5 = null;
	/* Column Info */
	private String f4 = null;
	/* Column Info */
	private String c2Fd = null;
	/* Column Info */
	private String sameDgR = null;
	/* Column Info */
	private String dcgoN7thClssFlg = null;
	/* Column Info */
	private String o4R = null;
	/* Column Info */
	private String dcgoN4thClssFlgFd = null;
	/* Column Info */
	private String isValidVndrSeq = null;
	/* Column Info */
	private String amendCd = null;
	/* Column Info */
	private String dgNoneR = null;
	/* Column Info */
	private String wkdyFlgFd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String lgsCostCd = null;
	/* Column Info */
	private String dcgoN6thClssFlg = null;
	/* Column Info */
	private String a5Fd = null;
	/* Column Info */
	private String accmCostSeq = null;
	/* Column Info */
	private String fCmd = null;
	/* Column Info */
	private String d9 = null;
	/* Column Info */
	private String d8 = null;
	/* Column Info */
	private String d5 = null;
	/* Column Info */
	private String d4 = null;
	/* Column Info */
	private String d7 = null;
	/* Column Info */
	private String d2Fd = null;
	/* Column Info */
	private String sheetPrefix = null;
	/* Column Info */
	private String d2 = null;
	/* Column Info */
	private String p2Fd = null;
	/* Column Info */
	private String effOn = null;
	/* Column Info */
	private String copyTmlAgmtOfcCtyCd = null;
	/* Column Info */
	private String sameDgNoneR = null;
	/* Column Info */
	private String p4Fd = null;
	/* Column Info */
	private String dcgoN3rdClssFlgFd = null;
	/* Column Info */
	private String d9Fd = null;
	/* Column Info */
	private String selectTab = null;
	/* Column Info */
	private String dcgoN9thClssFlg = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String t4 = null;
	/* Column Info */
	private String gangHourRate = null;
	/* Column Info */
	private String r7R = null;
	/* Column Info */
	private String dcgoN7thClssFlgFd = null;
	/* Column Info */
	private String t2 = null;
	/* Column Info */
	private String r4R = null;
	/* Column Info */
	private String dcgoN2ndClssFlg = null;
	/* Column Info */
	private String ipage = null;
	/* Column Info */
	private String dcgoN6thClssFlgR = null;
	/* Column Info */
	private String f4R = null;
	/* Column Info */
	private String s4Fd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String f2Fd = null;
	/* Column Info */
	private String inputListVerifyFlg = null;
	/* Column Info */
	private String o4Fd = null;
	/* Column Info */
	private String o5Fd = null;
	/* Column Info */
	private String t4R = null;
	/* Column Info */
	private String s4 = null;
	/* Column Info */
	private String sunFlgFd = null;
	/* Column Info */
	private String s2 = null;
	/* Column Info */
	private String dgNoneFd = null;
	/* Column Info */
	private String d7Fd = null;
	/* Column Info */
	private String dcgoN9thClssFlgR = null;
	/* Column Info */
	private String d5Fd = null;
	/* Column Info */
	private String loopValue = null;
	/* Column Info */
	private String c4 = null;
	/* Column Info */
	private String f5R = null;
	/* Column Info */
	private String sameDgNone = null;
	/* Column Info */
	private String p4R = null;
	/* Column Info */
	private String c2 = null;
	/* Column Info */
	private String d2R = null;
	/* Column Info */
	private String s2Fd = null;
	/* Column Info */
	private String r7 = null;
	/* Column Info */
	private String r8 = null;
	/* Column Info */
	private String r5R = null;
	/* Column Info */
	private String r9 = null;
	/* Column Info */
	private String r2 = null;
	/* Column Info */
	private String r4 = null;
	/* Column Info */
	private String r5 = null;
	/* Column Info */
	private String tmlAgmtVolUtCd = null;
	/* Column Info */
	private String a5R = null;
	/* Column Info */
	private String p4 = null;
	/* Column Info */
	private String dcgoN5thClssFlgR = null;
	/* Column Info */
	private String p2 = null;
	/* Column Info */
	private String dcgoN9thClssFlgFd = null;
	/* Column Info */
	private String c4R = null;
	/* Column Info */
	private String d4R = null;
	/* Column Info */
	private String dcgoN1stClssFlgR = null;
	/* Column Info */
	private String t4Fd = null;
	/* Column Info */
	private String dcgoN8thClssFlgR = null;
	/* Column Info */
	private String agmthdrcreadjflg = null;
	/* Column Info */
	private String r7Fd = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String dcgoN5thClssFlgFd = null;
	/* Column Info */
	private String tonRate = null;
	/* Column Info */
	private String accmDtlSeq = null;
	/* Column Info */
	private String commandH = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String t2R = null;
	/* Column Info */
	private String thrpflg = null;
	/* Column Info */
	private String d5R = null;
	/* Column Info */
	private String o2Fd = null;
	/* Column Info */
	private String p2R = null;
	/* Column Info */
	private String vndrSeqHidden = null;
	/* Column Info */
	private String dcgoN1stClssFlgFd = null;
	/* Column Info */
	private String r8R = null;
	/* Column Info */
	private String c2R = null;
	/* Column Info */
	private String sepDgNoneR = null;
	/* Column Info */
	private String dxR = null;
	/* Column Info */
	private String dcgoN8thClssFlgFd = null;
	/* Column Info */
	private String regagmthdrflg = null;
	/* Column Info */
	private String d7R = null;
	/* Column Info */
	private String initformdtlflg = null;
	/* Column Info */
	private String a2 = null;
	/* Column Info */
	private String dcgoN3rdClssFlgR = null;
	/* Column Info */
	private String a2R = null;
	/* Column Info */
	private String a4 = null;
	/* Column Info */
	private String a5 = null;
	/* Column Info */
	private String d8Fd = null;
	/* Column Info */
	private String dcgoN6thClssFlgFd = null;
	/* Column Info */
	private String isValidYdCd = null;
	/* Column Info */
	private String o2 = null;
	/* Column Info */
	private String o4 = null;
	/* Column Info */
	private String dcgoN4thClssFlg = null;
	/* Column Info */
	private String r9R = null;
	/* Column Info */
	private String o5 = null;
	/* Column Info */
	private String a4R = null;
	/* Column Info */
	private String dwR = null;
	/* Column Info */
	private String c4Fd = null;
	/* Column Info */
	private String d4Fd = null;
	/* Column Info */
	private String d8R = null;
	/* Column Info */
	private String sepDgNone = null;
	/* Column Info */
	private String a4Fd = null;
	/* Column Info */
	private String satFlgFd = null;
	/* Column Info */
	private String sameDgFd = null;
	/* Column Info */
	private String tmlAgmtStsCd = null;
	/* Column Info */
	private String ydCdName = null;
	/* Column Info */
	private String r8Fd = null;
	/* Column Info */
	private String d9R = null;
	/* Column Info */
	private String regagmtflg = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String vndrSeqDeltflg = null;
	/* Column Info */
	private String sameDg = null;
	/* Column Info */
	private String rowNum = null;
	/* Column Info */
	private String r4Fd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String tsRt = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String dcgoNonClssFlgFd = null;
	/* Column Info */
	private String dwFd = null;
	/* Column Info */
	private String tmlAgmtOfcNo = null;
	/* Column Info */
	private String dgNone = null;
	/* Column Info */
	private String dcgoN2ndClssFlgFd = null;
	/* Column Info */
	private String tmlAgmtTpCd = null;
	/* Column Info */
	private String dcgoNonClssFlgR = null;
	/* Column Info */
	private String dcgoN1stClssFlg = null;
	/* Column Info */
	private String r2Fd = null;
	/* Column Info */
	private String creOfcCd2 = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String inquiryflg = null;
	/* Column Info */
	private String dcgoN3rdClssFlg = null;
	/* Column Info */
	private String agmtConfirmFlg = null;
	/* Column Info */
	private String fileimportflg = null;
	/* Column Info */
	private String ydCdHidden = null;
	/* Column Info */
	private String f5Fd = null;
	/* Column Info */
	private String holFlgFd = null;
	/* Column Info */
	private String f4Fd = null;
	/* Column Info */
	private String boxRate = null;
	/* Column Info */
	private String t2Fd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public TesAgreementManageCommonVO() {}

	public TesAgreementManageCommonVO(String ibflag, String pagerows, String fCmd, String ipage, String isValidYdCd, String ydCd, String ydCdName, String ydCdHidden, String ydCdDeltflg, String vndrSeq, String isValidVndrSeq, String vndrSeqHidden, String vndrSeqDeltflg, String rowNum, String accmSeq, String accmCostSeq, String accmDtlSeq, String effAgmt, String ofcCd, String effOn, String loopValue, String tmlAgmtOfcNo, String tmlAgmtStsCd, String tmlAgmtTpCd, String lgsCostCd, String tmlAgmtVolUtCd, String ioBndCd, String currCd, String selectTab, String sheetPrefix, String regagmtflg, String regagmthdrflg, String initformdtlflg, String agmthdrcreadjflg, String commandH, String inputListVerifyFlg, String thrpflg, String vfsarray, String fileimportflg, String laneCdstring, String copyTmlAgmtOfcCtyCd, String agmtConfirmFlg, String creOfcCd, String creUsrId, String updUsrId, String inquiryflg, String amendCd, String wkdyFlgFd, String satFlgFd, String sunFlgFd, String holFlgFd, String dgNone, String sameDgNone, String sameDg, String sepDgNone, String dcgoN1stClssFlg, String dcgoN2ndClssFlg, String dcgoN3rdClssFlg, String dcgoN4thClssFlg, String dcgoN5thClssFlg, String dcgoN6thClssFlg, String dcgoN7thClssFlg, String dcgoN8thClssFlg, String dcgoN9thClssFlg, String dcgoNonClssFlg, String dgNoneFd, String sameDgNoneFd, String sameDgFd, String sepDgNoneFd, String dcgoN1stClssFlgFd, String dcgoN2ndClssFlgFd, String dcgoN3rdClssFlgFd, String dcgoN4thClssFlgFd, String dcgoN5thClssFlgFd, String dcgoN6thClssFlgFd, String dcgoN7thClssFlgFd, String dcgoN8thClssFlgFd, String dcgoN9thClssFlgFd, String dcgoNonClssFlgFd, String dgNoneR, String sameDgNoneR, String sameDgR, String sepDgNoneR, String dcgoN1stClssFlgR, String dcgoN2ndClssFlgR, String dcgoN3rdClssFlgR, String dcgoN4thClssFlgR, String dcgoN5thClssFlgR, String dcgoN6thClssFlgR, String dcgoN7thClssFlgR, String dcgoN8thClssFlgR, String dcgoN9thClssFlgR, String dcgoNonClssFlgR, String d2, String d4, String d5, String d7, String d8, String d9, String dw, String dx, String r2, String r4, String r5, String r7, String r8, String r9, String f2, String f4, String o2, String o4, String o5, String s2, String s4, String t2, String t4, String a2, String a4, String a5, String p2, String p4, String f5, String c2, String c4, String d2Fd, String d4Fd, String d5Fd, String d7Fd, String d8Fd, String d9Fd, String dwFd, String dxFd, String r2Fd, String r4Fd, String r5Fd, String r7Fd, String r8Fd, String r9Fd, String f2Fd, String f4Fd, String o2Fd, String o4Fd, String o5Fd, String s2Fd, String s4Fd, String t2Fd, String t4Fd, String a2Fd, String a4Fd, String a5Fd, String p2Fd, String p4Fd, String f5Fd, String c2Fd, String c4Fd, String d2R, String d4R, String d5R, String d7R, String d8R, String d9R, String dwR, String dxR, String r2R, String r4R, String r5R, String r7R, String r8R, String r9R, String f2R, String f4R, String o2R, String o4R, String o5R, String s2R, String s4R, String t2R, String t4R, String a2R, String a4R, String a5R, String p2R, String p4R, String f5R, String c2R, String c4R, String teuRate, String boxRate, String moveRate, String gangHourRate, String tonRate, String tsRt, String locCd, String creOfcCd2) {
		this.accmSeq = accmSeq;
		this.f2R = f2R;
		this.s2R = s2R;
		this.r2R = r2R;
		this.pagerows = pagerows;
		this.moveRate = moveRate;
		this.laneCdstring = laneCdstring;
		this.a2Fd = a2Fd;
		this.dcgoN7thClssFlgR = dcgoN7thClssFlgR;
		this.sepDgNoneFd = sepDgNoneFd;
		this.dcgoN2ndClssFlgR = dcgoN2ndClssFlgR;
		this.dcgoNonClssFlg = dcgoNonClssFlg;
		this.dxFd = dxFd;
		this.o2R = o2R;
		this.r9Fd = r9Fd;
		this.dcgoN5thClssFlg = dcgoN5thClssFlg;
		this.r5Fd = r5Fd;
		this.ydCdDeltflg = ydCdDeltflg;
		this.effAgmt = effAgmt;
		this.s4R = s4R;
		this.dw = dw;
		this.dx = dx;
		this.sameDgNoneFd = sameDgNoneFd;
		this.vfsarray = vfsarray;
		this.dcgoN4thClssFlgR = dcgoN4thClssFlgR;
		this.o5R = o5R;
		this.dcgoN8thClssFlg = dcgoN8thClssFlg;
		this.teuRate = teuRate;
		this.f2 = f2;
		this.f5 = f5;
		this.f4 = f4;
		this.c2Fd = c2Fd;
		this.sameDgR = sameDgR;
		this.dcgoN7thClssFlg = dcgoN7thClssFlg;
		this.o4R = o4R;
		this.dcgoN4thClssFlgFd = dcgoN4thClssFlgFd;
		this.isValidVndrSeq = isValidVndrSeq;
		this.amendCd = amendCd;
		this.dgNoneR = dgNoneR;
		this.wkdyFlgFd = wkdyFlgFd;
		this.ofcCd = ofcCd;
		this.ydCd = ydCd;
		this.lgsCostCd = lgsCostCd;
		this.dcgoN6thClssFlg = dcgoN6thClssFlg;
		this.a5Fd = a5Fd;
		this.accmCostSeq = accmCostSeq;
		this.fCmd = fCmd;
		this.d9 = d9;
		this.d8 = d8;
		this.d5 = d5;
		this.d4 = d4;
		this.d7 = d7;
		this.d2Fd = d2Fd;
		this.sheetPrefix = sheetPrefix;
		this.d2 = d2;
		this.p2Fd = p2Fd;
		this.effOn = effOn;
		this.copyTmlAgmtOfcCtyCd = copyTmlAgmtOfcCtyCd;
		this.sameDgNoneR = sameDgNoneR;
		this.p4Fd = p4Fd;
		this.dcgoN3rdClssFlgFd = dcgoN3rdClssFlgFd;
		this.d9Fd = d9Fd;
		this.selectTab = selectTab;
		this.dcgoN9thClssFlg = dcgoN9thClssFlg;
		this.creUsrId = creUsrId;
		this.t4 = t4;
		this.gangHourRate = gangHourRate;
		this.r7R = r7R;
		this.dcgoN7thClssFlgFd = dcgoN7thClssFlgFd;
		this.t2 = t2;
		this.r4R = r4R;
		this.dcgoN2ndClssFlg = dcgoN2ndClssFlg;
		this.ipage = ipage;
		this.dcgoN6thClssFlgR = dcgoN6thClssFlgR;
		this.f4R = f4R;
		this.s4Fd = s4Fd;
		this.ibflag = ibflag;
		this.f2Fd = f2Fd;
		this.inputListVerifyFlg = inputListVerifyFlg;
		this.o4Fd = o4Fd;
		this.o5Fd = o5Fd;
		this.t4R = t4R;
		this.s4 = s4;
		this.sunFlgFd = sunFlgFd;
		this.s2 = s2;
		this.dgNoneFd = dgNoneFd;
		this.d7Fd = d7Fd;
		this.dcgoN9thClssFlgR = dcgoN9thClssFlgR;
		this.d5Fd = d5Fd;
		this.loopValue = loopValue;
		this.c4 = c4;
		this.f5R = f5R;
		this.sameDgNone = sameDgNone;
		this.p4R = p4R;
		this.c2 = c2;
		this.d2R = d2R;
		this.s2Fd = s2Fd;
		this.r7 = r7;
		this.r8 = r8;
		this.r5R = r5R;
		this.r9 = r9;
		this.r2 = r2;
		this.r4 = r4;
		this.r5 = r5;
		this.tmlAgmtVolUtCd = tmlAgmtVolUtCd;
		this.a5R = a5R;
		this.p4 = p4;
		this.dcgoN5thClssFlgR = dcgoN5thClssFlgR;
		this.p2 = p2;
		this.dcgoN9thClssFlgFd = dcgoN9thClssFlgFd;
		this.c4R = c4R;
		this.d4R = d4R;
		this.dcgoN1stClssFlgR = dcgoN1stClssFlgR;
		this.t4Fd = t4Fd;
		this.dcgoN8thClssFlgR = dcgoN8thClssFlgR;
		this.agmthdrcreadjflg = agmthdrcreadjflg;
		this.r7Fd = r7Fd;
		this.locCd = locCd;
		this.dcgoN5thClssFlgFd = dcgoN5thClssFlgFd;
		this.tonRate = tonRate;
		this.accmDtlSeq = accmDtlSeq;
		this.commandH = commandH;
		this.updUsrId = updUsrId;
		this.t2R = t2R;
		this.thrpflg = thrpflg;
		this.d5R = d5R;
		this.o2Fd = o2Fd;
		this.p2R = p2R;
		this.vndrSeqHidden = vndrSeqHidden;
		this.dcgoN1stClssFlgFd = dcgoN1stClssFlgFd;
		this.r8R = r8R;
		this.c2R = c2R;
		this.sepDgNoneR = sepDgNoneR;
		this.dxR = dxR;
		this.dcgoN8thClssFlgFd = dcgoN8thClssFlgFd;
		this.regagmthdrflg = regagmthdrflg;
		this.d7R = d7R;
		this.initformdtlflg = initformdtlflg;
		this.a2 = a2;
		this.dcgoN3rdClssFlgR = dcgoN3rdClssFlgR;
		this.a2R = a2R;
		this.a4 = a4;
		this.a5 = a5;
		this.d8Fd = d8Fd;
		this.dcgoN6thClssFlgFd = dcgoN6thClssFlgFd;
		this.isValidYdCd = isValidYdCd;
		this.o2 = o2;
		this.o4 = o4;
		this.dcgoN4thClssFlg = dcgoN4thClssFlg;
		this.r9R = r9R;
		this.o5 = o5;
		this.a4R = a4R;
		this.dwR = dwR;
		this.c4Fd = c4Fd;
		this.d4Fd = d4Fd;
		this.d8R = d8R;
		this.sepDgNone = sepDgNone;
		this.a4Fd = a4Fd;
		this.satFlgFd = satFlgFd;
		this.sameDgFd = sameDgFd;
		this.tmlAgmtStsCd = tmlAgmtStsCd;
		this.ydCdName = ydCdName;
		this.r8Fd = r8Fd;
		this.d9R = d9R;
		this.regagmtflg = regagmtflg;
		this.vndrSeq = vndrSeq;
		this.vndrSeqDeltflg = vndrSeqDeltflg;
		this.sameDg = sameDg;
		this.rowNum = rowNum;
		this.r4Fd = r4Fd;
		this.currCd = currCd;
		this.tsRt = tsRt;
		this.creOfcCd = creOfcCd;
		this.dcgoNonClssFlgFd = dcgoNonClssFlgFd;
		this.dwFd = dwFd;
		this.tmlAgmtOfcNo = tmlAgmtOfcNo;
		this.dgNone = dgNone;
		this.dcgoN2ndClssFlgFd = dcgoN2ndClssFlgFd;
		this.tmlAgmtTpCd = tmlAgmtTpCd;
		this.dcgoNonClssFlgR = dcgoNonClssFlgR;
		this.dcgoN1stClssFlg = dcgoN1stClssFlg;
		this.r2Fd = r2Fd;
		this.creOfcCd2 = creOfcCd2;
		this.ioBndCd = ioBndCd;
		this.inquiryflg = inquiryflg;
		this.dcgoN3rdClssFlg = dcgoN3rdClssFlg;
		this.agmtConfirmFlg = agmtConfirmFlg;
		this.fileimportflg = fileimportflg;
		this.ydCdHidden = ydCdHidden;
		this.f5Fd = f5Fd;
		this.holFlgFd = holFlgFd;
		this.f4Fd = f4Fd;
		this.boxRate = boxRate;
		this.t2Fd = t2Fd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("accm_seq", getAccmSeq());
		this.hashColumns.put("f2_r", getF2R());
		this.hashColumns.put("s2_r", getS2R());
		this.hashColumns.put("r2_r", getR2R());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("move_rate", getMoveRate());
		this.hashColumns.put("lane_cdstring", getLaneCdstring());
		this.hashColumns.put("a2_fd", getA2Fd());
		this.hashColumns.put("dcgo_n7th_clss_flg_r", getDcgoN7thClssFlgR());
		this.hashColumns.put("sep_dg_none_fd", getSepDgNoneFd());
		this.hashColumns.put("dcgo_n2nd_clss_flg_r", getDcgoN2ndClssFlgR());
		this.hashColumns.put("dcgo_non_clss_flg", getDcgoNonClssFlg());
		this.hashColumns.put("dx_fd", getDxFd());
		this.hashColumns.put("o2_r", getO2R());
		this.hashColumns.put("r9_fd", getR9Fd());
		this.hashColumns.put("dcgo_n5th_clss_flg", getDcgoN5thClssFlg());
		this.hashColumns.put("r5_fd", getR5Fd());
		this.hashColumns.put("yd_cd_deltflg", getYdCdDeltflg());
		this.hashColumns.put("eff_agmt", getEffAgmt());
		this.hashColumns.put("s4_r", getS4R());
		this.hashColumns.put("dw", getDw());
		this.hashColumns.put("dx", getDx());
		this.hashColumns.put("same_dg_none_fd", getSameDgNoneFd());
		this.hashColumns.put("vfsarray", getVfsarray());
		this.hashColumns.put("dcgo_n4th_clss_flg_r", getDcgoN4thClssFlgR());
		this.hashColumns.put("o5_r", getO5R());
		this.hashColumns.put("dcgo_n8th_clss_flg", getDcgoN8thClssFlg());
		this.hashColumns.put("teu_rate", getTeuRate());
		this.hashColumns.put("f2", getF2());
		this.hashColumns.put("f5", getF5());
		this.hashColumns.put("f4", getF4());
		this.hashColumns.put("c2_fd", getC2Fd());
		this.hashColumns.put("same_dg_r", getSameDgR());
		this.hashColumns.put("dcgo_n7th_clss_flg", getDcgoN7thClssFlg());
		this.hashColumns.put("o4_r", getO4R());
		this.hashColumns.put("dcgo_n4th_clss_flg_fd", getDcgoN4thClssFlgFd());
		this.hashColumns.put("is_valid_vndr_seq", getIsValidVndrSeq());
		this.hashColumns.put("amend_cd", getAmendCd());
		this.hashColumns.put("dg_none_r", getDgNoneR());
		this.hashColumns.put("wkdy_flg_fd", getWkdyFlgFd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("lgs_cost_cd", getLgsCostCd());
		this.hashColumns.put("dcgo_n6th_clss_flg", getDcgoN6thClssFlg());
		this.hashColumns.put("a5_fd", getA5Fd());
		this.hashColumns.put("accm_cost_seq", getAccmCostSeq());
		this.hashColumns.put("f_cmd", getFCmd());
		this.hashColumns.put("d9", getD9());
		this.hashColumns.put("d8", getD8());
		this.hashColumns.put("d5", getD5());
		this.hashColumns.put("d4", getD4());
		this.hashColumns.put("d7", getD7());
		this.hashColumns.put("d2_fd", getD2Fd());
		this.hashColumns.put("sheet_prefix", getSheetPrefix());
		this.hashColumns.put("d2", getD2());
		this.hashColumns.put("p2_fd", getP2Fd());
		this.hashColumns.put("eff_on", getEffOn());
		this.hashColumns.put("copy_tml_agmt_ofc_cty_cd", getCopyTmlAgmtOfcCtyCd());
		this.hashColumns.put("same_dg_none_r", getSameDgNoneR());
		this.hashColumns.put("p4_fd", getP4Fd());
		this.hashColumns.put("dcgo_n3rd_clss_flg_fd", getDcgoN3rdClssFlgFd());
		this.hashColumns.put("d9_fd", getD9Fd());
		this.hashColumns.put("select_tab", getSelectTab());
		this.hashColumns.put("dcgo_n9th_clss_flg", getDcgoN9thClssFlg());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("t4", getT4());
		this.hashColumns.put("gang_hour_rate", getGangHourRate());
		this.hashColumns.put("r7_r", getR7R());
		this.hashColumns.put("dcgo_n7th_clss_flg_fd", getDcgoN7thClssFlgFd());
		this.hashColumns.put("t2", getT2());
		this.hashColumns.put("r4_r", getR4R());
		this.hashColumns.put("dcgo_n2nd_clss_flg", getDcgoN2ndClssFlg());
		this.hashColumns.put("ipage", getIpage());
		this.hashColumns.put("dcgo_n6th_clss_flg_r", getDcgoN6thClssFlgR());
		this.hashColumns.put("f4_r", getF4R());
		this.hashColumns.put("s4_fd", getS4Fd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("f2_fd", getF2Fd());
		this.hashColumns.put("input_list_verify_flg", getInputListVerifyFlg());
		this.hashColumns.put("o4_fd", getO4Fd());
		this.hashColumns.put("o5_fd", getO5Fd());
		this.hashColumns.put("t4_r", getT4R());
		this.hashColumns.put("s4", getS4());
		this.hashColumns.put("sun_flg_fd", getSunFlgFd());
		this.hashColumns.put("s2", getS2());
		this.hashColumns.put("dg_none_fd", getDgNoneFd());
		this.hashColumns.put("d7_fd", getD7Fd());
		this.hashColumns.put("dcgo_n9th_clss_flg_r", getDcgoN9thClssFlgR());
		this.hashColumns.put("d5_fd", getD5Fd());
		this.hashColumns.put("loop_value", getLoopValue());
		this.hashColumns.put("c4", getC4());
		this.hashColumns.put("f5_r", getF5R());
		this.hashColumns.put("same_dg_none", getSameDgNone());
		this.hashColumns.put("p4_r", getP4R());
		this.hashColumns.put("c2", getC2());
		this.hashColumns.put("d2_r", getD2R());
		this.hashColumns.put("s2_fd", getS2Fd());
		this.hashColumns.put("r7", getR7());
		this.hashColumns.put("r8", getR8());
		this.hashColumns.put("r5_r", getR5R());
		this.hashColumns.put("r9", getR9());
		this.hashColumns.put("r2", getR2());
		this.hashColumns.put("r4", getR4());
		this.hashColumns.put("r5", getR5());
		this.hashColumns.put("tml_agmt_vol_ut_cd", getTmlAgmtVolUtCd());
		this.hashColumns.put("a5_r", getA5R());
		this.hashColumns.put("p4", getP4());
		this.hashColumns.put("dcgo_n5th_clss_flg_r", getDcgoN5thClssFlgR());
		this.hashColumns.put("p2", getP2());
		this.hashColumns.put("dcgo_n9th_clss_flg_fd", getDcgoN9thClssFlgFd());
		this.hashColumns.put("c4_r", getC4R());
		this.hashColumns.put("d4_r", getD4R());
		this.hashColumns.put("dcgo_n1st_clss_flg_r", getDcgoN1stClssFlgR());
		this.hashColumns.put("t4_fd", getT4Fd());
		this.hashColumns.put("dcgo_n8th_clss_flg_r", getDcgoN8thClssFlgR());
		this.hashColumns.put("agmthdrcreadjflg", getAgmthdrcreadjflg());
		this.hashColumns.put("r7_fd", getR7Fd());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("dcgo_n5th_clss_flg_fd", getDcgoN5thClssFlgFd());
		this.hashColumns.put("ton_rate", getTonRate());
		this.hashColumns.put("accm_dtl_seq", getAccmDtlSeq());
		this.hashColumns.put("command_h", getCommandH());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("t2_r", getT2R());
		this.hashColumns.put("thrpflg", getThrpflg());
		this.hashColumns.put("d5_r", getD5R());
		this.hashColumns.put("o2_fd", getO2Fd());
		this.hashColumns.put("p2_r", getP2R());
		this.hashColumns.put("vndr_seq_hidden", getVndrSeqHidden());
		this.hashColumns.put("dcgo_n1st_clss_flg_fd", getDcgoN1stClssFlgFd());
		this.hashColumns.put("r8_r", getR8R());
		this.hashColumns.put("c2_r", getC2R());
		this.hashColumns.put("sep_dg_none_r", getSepDgNoneR());
		this.hashColumns.put("dx_r", getDxR());
		this.hashColumns.put("dcgo_n8th_clss_flg_fd", getDcgoN8thClssFlgFd());
		this.hashColumns.put("regagmthdrflg", getRegagmthdrflg());
		this.hashColumns.put("d7_r", getD7R());
		this.hashColumns.put("initformdtlflg", getInitformdtlflg());
		this.hashColumns.put("a2", getA2());
		this.hashColumns.put("dcgo_n3rd_clss_flg_r", getDcgoN3rdClssFlgR());
		this.hashColumns.put("a2_r", getA2R());
		this.hashColumns.put("a4", getA4());
		this.hashColumns.put("a5", getA5());
		this.hashColumns.put("d8_fd", getD8Fd());
		this.hashColumns.put("dcgo_n6th_clss_flg_fd", getDcgoN6thClssFlgFd());
		this.hashColumns.put("is_valid_yd_cd", getIsValidYdCd());
		this.hashColumns.put("o2", getO2());
		this.hashColumns.put("o4", getO4());
		this.hashColumns.put("dcgo_n4th_clss_flg", getDcgoN4thClssFlg());
		this.hashColumns.put("r9_r", getR9R());
		this.hashColumns.put("o5", getO5());
		this.hashColumns.put("a4_r", getA4R());
		this.hashColumns.put("dw_r", getDwR());
		this.hashColumns.put("c4_fd", getC4Fd());
		this.hashColumns.put("d4_fd", getD4Fd());
		this.hashColumns.put("d8_r", getD8R());
		this.hashColumns.put("sep_dg_none", getSepDgNone());
		this.hashColumns.put("a4_fd", getA4Fd());
		this.hashColumns.put("sat_flg_fd", getSatFlgFd());
		this.hashColumns.put("same_dg_fd", getSameDgFd());
		this.hashColumns.put("tml_agmt_sts_cd", getTmlAgmtStsCd());
		this.hashColumns.put("yd_cd_name", getYdCdName());
		this.hashColumns.put("r8_fd", getR8Fd());
		this.hashColumns.put("d9_r", getD9R());
		this.hashColumns.put("regagmtflg", getRegagmtflg());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("vndr_seq_deltflg", getVndrSeqDeltflg());
		this.hashColumns.put("same_dg", getSameDg());
		this.hashColumns.put("row_num", getRowNum());
		this.hashColumns.put("r4_fd", getR4Fd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("ts_rt", getTsRt());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("dcgo_non_clss_flg_fd", getDcgoNonClssFlgFd());
		this.hashColumns.put("dw_fd", getDwFd());
		this.hashColumns.put("tml_agmt_ofc_no", getTmlAgmtOfcNo());
		this.hashColumns.put("dg_none", getDgNone());
		this.hashColumns.put("dcgo_n2nd_clss_flg_fd", getDcgoN2ndClssFlgFd());
		this.hashColumns.put("tml_agmt_tp_cd", getTmlAgmtTpCd());
		this.hashColumns.put("dcgo_non_clss_flg_r", getDcgoNonClssFlgR());
		this.hashColumns.put("dcgo_n1st_clss_flg", getDcgoN1stClssFlg());
		this.hashColumns.put("r2_fd", getR2Fd());
		this.hashColumns.put("cre_ofc_cd2", getCreOfcCd2());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("inquiryflg", getInquiryflg());
		this.hashColumns.put("dcgo_n3rd_clss_flg", getDcgoN3rdClssFlg());
		this.hashColumns.put("agmt_confirm_flg", getAgmtConfirmFlg());
		this.hashColumns.put("fileimportflg", getFileimportflg());
		this.hashColumns.put("yd_cd_hidden", getYdCdHidden());
		this.hashColumns.put("f5_fd", getF5Fd());
		this.hashColumns.put("hol_flg_fd", getHolFlgFd());
		this.hashColumns.put("f4_fd", getF4Fd());
		this.hashColumns.put("box_rate", getBoxRate());
		this.hashColumns.put("t2_fd", getT2Fd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("accm_seq", "accmSeq");
		this.hashFields.put("f2_r", "f2R");
		this.hashFields.put("s2_r", "s2R");
		this.hashFields.put("r2_r", "r2R");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("move_rate", "moveRate");
		this.hashFields.put("lane_cdstring", "laneCdstring");
		this.hashFields.put("a2_fd", "a2Fd");
		this.hashFields.put("dcgo_n7th_clss_flg_r", "dcgoN7thClssFlgR");
		this.hashFields.put("sep_dg_none_fd", "sepDgNoneFd");
		this.hashFields.put("dcgo_n2nd_clss_flg_r", "dcgoN2ndClssFlgR");
		this.hashFields.put("dcgo_non_clss_flg", "dcgoNonClssFlg");
		this.hashFields.put("dx_fd", "dxFd");
		this.hashFields.put("o2_r", "o2R");
		this.hashFields.put("r9_fd", "r9Fd");
		this.hashFields.put("dcgo_n5th_clss_flg", "dcgoN5thClssFlg");
		this.hashFields.put("r5_fd", "r5Fd");
		this.hashFields.put("yd_cd_deltflg", "ydCdDeltflg");
		this.hashFields.put("eff_agmt", "effAgmt");
		this.hashFields.put("s4_r", "s4R");
		this.hashFields.put("dw", "dw");
		this.hashFields.put("dx", "dx");
		this.hashFields.put("same_dg_none_fd", "sameDgNoneFd");
		this.hashFields.put("vfsarray", "vfsarray");
		this.hashFields.put("dcgo_n4th_clss_flg_r", "dcgoN4thClssFlgR");
		this.hashFields.put("o5_r", "o5R");
		this.hashFields.put("dcgo_n8th_clss_flg", "dcgoN8thClssFlg");
		this.hashFields.put("teu_rate", "teuRate");
		this.hashFields.put("f2", "f2");
		this.hashFields.put("f5", "f5");
		this.hashFields.put("f4", "f4");
		this.hashFields.put("c2_fd", "c2Fd");
		this.hashFields.put("same_dg_r", "sameDgR");
		this.hashFields.put("dcgo_n7th_clss_flg", "dcgoN7thClssFlg");
		this.hashFields.put("o4_r", "o4R");
		this.hashFields.put("dcgo_n4th_clss_flg_fd", "dcgoN4thClssFlgFd");
		this.hashFields.put("is_valid_vndr_seq", "isValidVndrSeq");
		this.hashFields.put("amend_cd", "amendCd");
		this.hashFields.put("dg_none_r", "dgNoneR");
		this.hashFields.put("wkdy_flg_fd", "wkdyFlgFd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("lgs_cost_cd", "lgsCostCd");
		this.hashFields.put("dcgo_n6th_clss_flg", "dcgoN6thClssFlg");
		this.hashFields.put("a5_fd", "a5Fd");
		this.hashFields.put("accm_cost_seq", "accmCostSeq");
		this.hashFields.put("f_cmd", "fCmd");
		this.hashFields.put("d9", "d9");
		this.hashFields.put("d8", "d8");
		this.hashFields.put("d5", "d5");
		this.hashFields.put("d4", "d4");
		this.hashFields.put("d7", "d7");
		this.hashFields.put("d2_fd", "d2Fd");
		this.hashFields.put("sheet_prefix", "sheetPrefix");
		this.hashFields.put("d2", "d2");
		this.hashFields.put("p2_fd", "p2Fd");
		this.hashFields.put("eff_on", "effOn");
		this.hashFields.put("copy_tml_agmt_ofc_cty_cd", "copyTmlAgmtOfcCtyCd");
		this.hashFields.put("same_dg_none_r", "sameDgNoneR");
		this.hashFields.put("p4_fd", "p4Fd");
		this.hashFields.put("dcgo_n3rd_clss_flg_fd", "dcgoN3rdClssFlgFd");
		this.hashFields.put("d9_fd", "d9Fd");
		this.hashFields.put("select_tab", "selectTab");
		this.hashFields.put("dcgo_n9th_clss_flg", "dcgoN9thClssFlg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("t4", "t4");
		this.hashFields.put("gang_hour_rate", "gangHourRate");
		this.hashFields.put("r7_r", "r7R");
		this.hashFields.put("dcgo_n7th_clss_flg_fd", "dcgoN7thClssFlgFd");
		this.hashFields.put("t2", "t2");
		this.hashFields.put("r4_r", "r4R");
		this.hashFields.put("dcgo_n2nd_clss_flg", "dcgoN2ndClssFlg");
		this.hashFields.put("ipage", "ipage");
		this.hashFields.put("dcgo_n6th_clss_flg_r", "dcgoN6thClssFlgR");
		this.hashFields.put("f4_r", "f4R");
		this.hashFields.put("s4_fd", "s4Fd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("f2_fd", "f2Fd");
		this.hashFields.put("input_list_verify_flg", "inputListVerifyFlg");
		this.hashFields.put("o4_fd", "o4Fd");
		this.hashFields.put("o5_fd", "o5Fd");
		this.hashFields.put("t4_r", "t4R");
		this.hashFields.put("s4", "s4");
		this.hashFields.put("sun_flg_fd", "sunFlgFd");
		this.hashFields.put("s2", "s2");
		this.hashFields.put("dg_none_fd", "dgNoneFd");
		this.hashFields.put("d7_fd", "d7Fd");
		this.hashFields.put("dcgo_n9th_clss_flg_r", "dcgoN9thClssFlgR");
		this.hashFields.put("d5_fd", "d5Fd");
		this.hashFields.put("loop_value", "loopValue");
		this.hashFields.put("c4", "c4");
		this.hashFields.put("f5_r", "f5R");
		this.hashFields.put("same_dg_none", "sameDgNone");
		this.hashFields.put("p4_r", "p4R");
		this.hashFields.put("c2", "c2");
		this.hashFields.put("d2_r", "d2R");
		this.hashFields.put("s2_fd", "s2Fd");
		this.hashFields.put("r7", "r7");
		this.hashFields.put("r8", "r8");
		this.hashFields.put("r5_r", "r5R");
		this.hashFields.put("r9", "r9");
		this.hashFields.put("r2", "r2");
		this.hashFields.put("r4", "r4");
		this.hashFields.put("r5", "r5");
		this.hashFields.put("tml_agmt_vol_ut_cd", "tmlAgmtVolUtCd");
		this.hashFields.put("a5_r", "a5R");
		this.hashFields.put("p4", "p4");
		this.hashFields.put("dcgo_n5th_clss_flg_r", "dcgoN5thClssFlgR");
		this.hashFields.put("p2", "p2");
		this.hashFields.put("dcgo_n9th_clss_flg_fd", "dcgoN9thClssFlgFd");
		this.hashFields.put("c4_r", "c4R");
		this.hashFields.put("d4_r", "d4R");
		this.hashFields.put("dcgo_n1st_clss_flg_r", "dcgoN1stClssFlgR");
		this.hashFields.put("t4_fd", "t4Fd");
		this.hashFields.put("dcgo_n8th_clss_flg_r", "dcgoN8thClssFlgR");
		this.hashFields.put("agmthdrcreadjflg", "agmthdrcreadjflg");
		this.hashFields.put("r7_fd", "r7Fd");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("dcgo_n5th_clss_flg_fd", "dcgoN5thClssFlgFd");
		this.hashFields.put("ton_rate", "tonRate");
		this.hashFields.put("accm_dtl_seq", "accmDtlSeq");
		this.hashFields.put("command_h", "commandH");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("t2_r", "t2R");
		this.hashFields.put("thrpflg", "thrpflg");
		this.hashFields.put("d5_r", "d5R");
		this.hashFields.put("o2_fd", "o2Fd");
		this.hashFields.put("p2_r", "p2R");
		this.hashFields.put("vndr_seq_hidden", "vndrSeqHidden");
		this.hashFields.put("dcgo_n1st_clss_flg_fd", "dcgoN1stClssFlgFd");
		this.hashFields.put("r8_r", "r8R");
		this.hashFields.put("c2_r", "c2R");
		this.hashFields.put("sep_dg_none_r", "sepDgNoneR");
		this.hashFields.put("dx_r", "dxR");
		this.hashFields.put("dcgo_n8th_clss_flg_fd", "dcgoN8thClssFlgFd");
		this.hashFields.put("regagmthdrflg", "regagmthdrflg");
		this.hashFields.put("d7_r", "d7R");
		this.hashFields.put("initformdtlflg", "initformdtlflg");
		this.hashFields.put("a2", "a2");
		this.hashFields.put("dcgo_n3rd_clss_flg_r", "dcgoN3rdClssFlgR");
		this.hashFields.put("a2_r", "a2R");
		this.hashFields.put("a4", "a4");
		this.hashFields.put("a5", "a5");
		this.hashFields.put("d8_fd", "d8Fd");
		this.hashFields.put("dcgo_n6th_clss_flg_fd", "dcgoN6thClssFlgFd");
		this.hashFields.put("is_valid_yd_cd", "isValidYdCd");
		this.hashFields.put("o2", "o2");
		this.hashFields.put("o4", "o4");
		this.hashFields.put("dcgo_n4th_clss_flg", "dcgoN4thClssFlg");
		this.hashFields.put("r9_r", "r9R");
		this.hashFields.put("o5", "o5");
		this.hashFields.put("a4_r", "a4R");
		this.hashFields.put("dw_r", "dwR");
		this.hashFields.put("c4_fd", "c4Fd");
		this.hashFields.put("d4_fd", "d4Fd");
		this.hashFields.put("d8_r", "d8R");
		this.hashFields.put("sep_dg_none", "sepDgNone");
		this.hashFields.put("a4_fd", "a4Fd");
		this.hashFields.put("sat_flg_fd", "satFlgFd");
		this.hashFields.put("same_dg_fd", "sameDgFd");
		this.hashFields.put("tml_agmt_sts_cd", "tmlAgmtStsCd");
		this.hashFields.put("yd_cd_name", "ydCdName");
		this.hashFields.put("r8_fd", "r8Fd");
		this.hashFields.put("d9_r", "d9R");
		this.hashFields.put("regagmtflg", "regagmtflg");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("vndr_seq_deltflg", "vndrSeqDeltflg");
		this.hashFields.put("same_dg", "sameDg");
		this.hashFields.put("row_num", "rowNum");
		this.hashFields.put("r4_fd", "r4Fd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("ts_rt", "tsRt");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("dcgo_non_clss_flg_fd", "dcgoNonClssFlgFd");
		this.hashFields.put("dw_fd", "dwFd");
		this.hashFields.put("tml_agmt_ofc_no", "tmlAgmtOfcNo");
		this.hashFields.put("dg_none", "dgNone");
		this.hashFields.put("dcgo_n2nd_clss_flg_fd", "dcgoN2ndClssFlgFd");
		this.hashFields.put("tml_agmt_tp_cd", "tmlAgmtTpCd");
		this.hashFields.put("dcgo_non_clss_flg_r", "dcgoNonClssFlgR");
		this.hashFields.put("dcgo_n1st_clss_flg", "dcgoN1stClssFlg");
		this.hashFields.put("r2_fd", "r2Fd");
		this.hashFields.put("cre_ofc_cd2", "creOfcCd2");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("inquiryflg", "inquiryflg");
		this.hashFields.put("dcgo_n3rd_clss_flg", "dcgoN3rdClssFlg");
		this.hashFields.put("agmt_confirm_flg", "agmtConfirmFlg");
		this.hashFields.put("fileimportflg", "fileimportflg");
		this.hashFields.put("yd_cd_hidden", "ydCdHidden");
		this.hashFields.put("f5_fd", "f5Fd");
		this.hashFields.put("hol_flg_fd", "holFlgFd");
		this.hashFields.put("f4_fd", "f4Fd");
		this.hashFields.put("box_rate", "boxRate");
		this.hashFields.put("t2_fd", "t2Fd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return accmSeq
	 */
	public String getAccmSeq() {
		return this.accmSeq;
	}
	
	/**
	 * Column Info
	 * @return f2R
	 */
	public String getF2R() {
		return this.f2R;
	}
	
	/**
	 * Column Info
	 * @return s2R
	 */
	public String getS2R() {
		return this.s2R;
	}
	
	/**
	 * Column Info
	 * @return r2R
	 */
	public String getR2R() {
		return this.r2R;
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
	 * @return moveRate
	 */
	public String getMoveRate() {
		return this.moveRate;
	}
	
	/**
	 * Column Info
	 * @return laneCdstring
	 */
	public String getLaneCdstring() {
		return this.laneCdstring;
	}
	
	/**
	 * Column Info
	 * @return a2Fd
	 */
	public String getA2Fd() {
		return this.a2Fd;
	}
	
	/**
	 * Column Info
	 * @return dcgoN7thClssFlgR
	 */
	public String getDcgoN7thClssFlgR() {
		return this.dcgoN7thClssFlgR;
	}
	
	/**
	 * Column Info
	 * @return sepDgNoneFd
	 */
	public String getSepDgNoneFd() {
		return this.sepDgNoneFd;
	}
	
	/**
	 * Column Info
	 * @return dcgoN2ndClssFlgR
	 */
	public String getDcgoN2ndClssFlgR() {
		return this.dcgoN2ndClssFlgR;
	}
	
	/**
	 * Column Info
	 * @return dcgoNonClssFlg
	 */
	public String getDcgoNonClssFlg() {
		return this.dcgoNonClssFlg;
	}
	
	/**
	 * Column Info
	 * @return dxFd
	 */
	public String getDxFd() {
		return this.dxFd;
	}
	
	/**
	 * Column Info
	 * @return o2R
	 */
	public String getO2R() {
		return this.o2R;
	}
	
	/**
	 * Column Info
	 * @return r9Fd
	 */
	public String getR9Fd() {
		return this.r9Fd;
	}
	
	/**
	 * Column Info
	 * @return dcgoN5thClssFlg
	 */
	public String getDcgoN5thClssFlg() {
		return this.dcgoN5thClssFlg;
	}
	
	/**
	 * Column Info
	 * @return r5Fd
	 */
	public String getR5Fd() {
		return this.r5Fd;
	}
	
	/**
	 * Column Info
	 * @return ydCdDeltflg
	 */
	public String getYdCdDeltflg() {
		return this.ydCdDeltflg;
	}
	
	/**
	 * Column Info
	 * @return effAgmt
	 */
	public String getEffAgmt() {
		return this.effAgmt;
	}
	
	/**
	 * Column Info
	 * @return s4R
	 */
	public String getS4R() {
		return this.s4R;
	}
	
	/**
	 * Column Info
	 * @return dw
	 */
	public String getDw() {
		return this.dw;
	}
	
	/**
	 * Column Info
	 * @return dx
	 */
	public String getDx() {
		return this.dx;
	}
	
	/**
	 * Column Info
	 * @return sameDgNoneFd
	 */
	public String getSameDgNoneFd() {
		return this.sameDgNoneFd;
	}
	
	/**
	 * Column Info
	 * @return vfsarray
	 */
	public String getVfsarray() {
		return this.vfsarray;
	}
	
	/**
	 * Column Info
	 * @return dcgoN4thClssFlgR
	 */
	public String getDcgoN4thClssFlgR() {
		return this.dcgoN4thClssFlgR;
	}
	
	/**
	 * Column Info
	 * @return o5R
	 */
	public String getO5R() {
		return this.o5R;
	}
	
	/**
	 * Column Info
	 * @return dcgoN8thClssFlg
	 */
	public String getDcgoN8thClssFlg() {
		return this.dcgoN8thClssFlg;
	}
	
	/**
	 * Column Info
	 * @return teuRate
	 */
	public String getTeuRate() {
		return this.teuRate;
	}
	
	/**
	 * Column Info
	 * @return f2
	 */
	public String getF2() {
		return this.f2;
	}
	
	/**
	 * Column Info
	 * @return f5
	 */
	public String getF5() {
		return this.f5;
	}
	
	/**
	 * Column Info
	 * @return f4
	 */
	public String getF4() {
		return this.f4;
	}
	
	/**
	 * Column Info
	 * @return c2Fd
	 */
	public String getC2Fd() {
		return this.c2Fd;
	}
	
	/**
	 * Column Info
	 * @return sameDgR
	 */
	public String getSameDgR() {
		return this.sameDgR;
	}
	
	/**
	 * Column Info
	 * @return dcgoN7thClssFlg
	 */
	public String getDcgoN7thClssFlg() {
		return this.dcgoN7thClssFlg;
	}
	
	/**
	 * Column Info
	 * @return o4R
	 */
	public String getO4R() {
		return this.o4R;
	}
	
	/**
	 * Column Info
	 * @return dcgoN4thClssFlgFd
	 */
	public String getDcgoN4thClssFlgFd() {
		return this.dcgoN4thClssFlgFd;
	}
	
	/**
	 * Column Info
	 * @return isValidVndrSeq
	 */
	public String getIsValidVndrSeq() {
		return this.isValidVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return amendCd
	 */
	public String getAmendCd() {
		return this.amendCd;
	}
	
	/**
	 * Column Info
	 * @return dgNoneR
	 */
	public String getDgNoneR() {
		return this.dgNoneR;
	}
	
	/**
	 * Column Info
	 * @return wkdyFlgFd
	 */
	public String getWkdyFlgFd() {
		return this.wkdyFlgFd;
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
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return lgsCostCd
	 */
	public String getLgsCostCd() {
		return this.lgsCostCd;
	}
	
	/**
	 * Column Info
	 * @return dcgoN6thClssFlg
	 */
	public String getDcgoN6thClssFlg() {
		return this.dcgoN6thClssFlg;
	}
	
	/**
	 * Column Info
	 * @return a5Fd
	 */
	public String getA5Fd() {
		return this.a5Fd;
	}
	
	/**
	 * Column Info
	 * @return accmCostSeq
	 */
	public String getAccmCostSeq() {
		return this.accmCostSeq;
	}
	
	/**
	 * Column Info
	 * @return fCmd
	 */
	public String getFCmd() {
		return this.fCmd;
	}
	
	/**
	 * Column Info
	 * @return d9
	 */
	public String getD9() {
		return this.d9;
	}
	
	/**
	 * Column Info
	 * @return d8
	 */
	public String getD8() {
		return this.d8;
	}
	
	/**
	 * Column Info
	 * @return d5
	 */
	public String getD5() {
		return this.d5;
	}
	
	/**
	 * Column Info
	 * @return d4
	 */
	public String getD4() {
		return this.d4;
	}
	
	/**
	 * Column Info
	 * @return d7
	 */
	public String getD7() {
		return this.d7;
	}
	
	/**
	 * Column Info
	 * @return d2Fd
	 */
	public String getD2Fd() {
		return this.d2Fd;
	}
	
	/**
	 * Column Info
	 * @return sheetPrefix
	 */
	public String getSheetPrefix() {
		return this.sheetPrefix;
	}
	
	/**
	 * Column Info
	 * @return d2
	 */
	public String getD2() {
		return this.d2;
	}
	
	/**
	 * Column Info
	 * @return p2Fd
	 */
	public String getP2Fd() {
		return this.p2Fd;
	}
	
	/**
	 * Column Info
	 * @return effOn
	 */
	public String getEffOn() {
		return this.effOn;
	}
	
	/**
	 * Column Info
	 * @return copyTmlAgmtOfcCtyCd
	 */
	public String getCopyTmlAgmtOfcCtyCd() {
		return this.copyTmlAgmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return sameDgNoneR
	 */
	public String getSameDgNoneR() {
		return this.sameDgNoneR;
	}
	
	/**
	 * Column Info
	 * @return p4Fd
	 */
	public String getP4Fd() {
		return this.p4Fd;
	}
	
	/**
	 * Column Info
	 * @return dcgoN3rdClssFlgFd
	 */
	public String getDcgoN3rdClssFlgFd() {
		return this.dcgoN3rdClssFlgFd;
	}
	
	/**
	 * Column Info
	 * @return d9Fd
	 */
	public String getD9Fd() {
		return this.d9Fd;
	}
	
	/**
	 * Column Info
	 * @return selectTab
	 */
	public String getSelectTab() {
		return this.selectTab;
	}
	
	/**
	 * Column Info
	 * @return dcgoN9thClssFlg
	 */
	public String getDcgoN9thClssFlg() {
		return this.dcgoN9thClssFlg;
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
	 * @return t4
	 */
	public String getT4() {
		return this.t4;
	}
	
	/**
	 * Column Info
	 * @return gangHourRate
	 */
	public String getGangHourRate() {
		return this.gangHourRate;
	}
	
	/**
	 * Column Info
	 * @return r7R
	 */
	public String getR7R() {
		return this.r7R;
	}
	
	/**
	 * Column Info
	 * @return dcgoN7thClssFlgFd
	 */
	public String getDcgoN7thClssFlgFd() {
		return this.dcgoN7thClssFlgFd;
	}
	
	/**
	 * Column Info
	 * @return t2
	 */
	public String getT2() {
		return this.t2;
	}
	
	/**
	 * Column Info
	 * @return r4R
	 */
	public String getR4R() {
		return this.r4R;
	}
	
	/**
	 * Column Info
	 * @return dcgoN2ndClssFlg
	 */
	public String getDcgoN2ndClssFlg() {
		return this.dcgoN2ndClssFlg;
	}
	
	/**
	 * Column Info
	 * @return ipage
	 */
	public String getIpage() {
		return this.ipage;
	}
	
	/**
	 * Column Info
	 * @return dcgoN6thClssFlgR
	 */
	public String getDcgoN6thClssFlgR() {
		return this.dcgoN6thClssFlgR;
	}
	
	/**
	 * Column Info
	 * @return f4R
	 */
	public String getF4R() {
		return this.f4R;
	}
	
	/**
	 * Column Info
	 * @return s4Fd
	 */
	public String getS4Fd() {
		return this.s4Fd;
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
	 * @return f2Fd
	 */
	public String getF2Fd() {
		return this.f2Fd;
	}
	
	/**
	 * Column Info
	 * @return inputListVerifyFlg
	 */
	public String getInputListVerifyFlg() {
		return this.inputListVerifyFlg;
	}
	
	/**
	 * Column Info
	 * @return o4Fd
	 */
	public String getO4Fd() {
		return this.o4Fd;
	}
	
	/**
	 * Column Info
	 * @return o5Fd
	 */
	public String getO5Fd() {
		return this.o5Fd;
	}
	
	/**
	 * Column Info
	 * @return t4R
	 */
	public String getT4R() {
		return this.t4R;
	}
	
	/**
	 * Column Info
	 * @return s4
	 */
	public String getS4() {
		return this.s4;
	}
	
	/**
	 * Column Info
	 * @return sunFlgFd
	 */
	public String getSunFlgFd() {
		return this.sunFlgFd;
	}
	
	/**
	 * Column Info
	 * @return s2
	 */
	public String getS2() {
		return this.s2;
	}
	
	/**
	 * Column Info
	 * @return dgNoneFd
	 */
	public String getDgNoneFd() {
		return this.dgNoneFd;
	}
	
	/**
	 * Column Info
	 * @return d7Fd
	 */
	public String getD7Fd() {
		return this.d7Fd;
	}
	
	/**
	 * Column Info
	 * @return dcgoN9thClssFlgR
	 */
	public String getDcgoN9thClssFlgR() {
		return this.dcgoN9thClssFlgR;
	}
	
	/**
	 * Column Info
	 * @return d5Fd
	 */
	public String getD5Fd() {
		return this.d5Fd;
	}
	
	/**
	 * Column Info
	 * @return loopValue
	 */
	public String getLoopValue() {
		return this.loopValue;
	}
	
	/**
	 * Column Info
	 * @return c4
	 */
	public String getC4() {
		return this.c4;
	}
	
	/**
	 * Column Info
	 * @return f5R
	 */
	public String getF5R() {
		return this.f5R;
	}
	
	/**
	 * Column Info
	 * @return sameDgNone
	 */
	public String getSameDgNone() {
		return this.sameDgNone;
	}
	
	/**
	 * Column Info
	 * @return p4R
	 */
	public String getP4R() {
		return this.p4R;
	}
	
	/**
	 * Column Info
	 * @return c2
	 */
	public String getC2() {
		return this.c2;
	}
	
	/**
	 * Column Info
	 * @return d2R
	 */
	public String getD2R() {
		return this.d2R;
	}
	
	/**
	 * Column Info
	 * @return s2Fd
	 */
	public String getS2Fd() {
		return this.s2Fd;
	}
	
	/**
	 * Column Info
	 * @return r7
	 */
	public String getR7() {
		return this.r7;
	}
	
	/**
	 * Column Info
	 * @return r8
	 */
	public String getR8() {
		return this.r8;
	}
	
	/**
	 * Column Info
	 * @return r5R
	 */
	public String getR5R() {
		return this.r5R;
	}
	
	/**
	 * Column Info
	 * @return r9
	 */
	public String getR9() {
		return this.r9;
	}
	
	/**
	 * Column Info
	 * @return r2
	 */
	public String getR2() {
		return this.r2;
	}
	
	/**
	 * Column Info
	 * @return r4
	 */
	public String getR4() {
		return this.r4;
	}
	
	/**
	 * Column Info
	 * @return r5
	 */
	public String getR5() {
		return this.r5;
	}
	
	/**
	 * Column Info
	 * @return tmlAgmtVolUtCd
	 */
	public String getTmlAgmtVolUtCd() {
		return this.tmlAgmtVolUtCd;
	}
	
	/**
	 * Column Info
	 * @return a5R
	 */
	public String getA5R() {
		return this.a5R;
	}
	
	/**
	 * Column Info
	 * @return p4
	 */
	public String getP4() {
		return this.p4;
	}
	
	/**
	 * Column Info
	 * @return dcgoN5thClssFlgR
	 */
	public String getDcgoN5thClssFlgR() {
		return this.dcgoN5thClssFlgR;
	}
	
	/**
	 * Column Info
	 * @return p2
	 */
	public String getP2() {
		return this.p2;
	}
	
	/**
	 * Column Info
	 * @return dcgoN9thClssFlgFd
	 */
	public String getDcgoN9thClssFlgFd() {
		return this.dcgoN9thClssFlgFd;
	}
	
	/**
	 * Column Info
	 * @return c4R
	 */
	public String getC4R() {
		return this.c4R;
	}
	
	/**
	 * Column Info
	 * @return d4R
	 */
	public String getD4R() {
		return this.d4R;
	}
	
	/**
	 * Column Info
	 * @return dcgoN1stClssFlgR
	 */
	public String getDcgoN1stClssFlgR() {
		return this.dcgoN1stClssFlgR;
	}
	
	/**
	 * Column Info
	 * @return t4Fd
	 */
	public String getT4Fd() {
		return this.t4Fd;
	}
	
	/**
	 * Column Info
	 * @return dcgoN8thClssFlgR
	 */
	public String getDcgoN8thClssFlgR() {
		return this.dcgoN8thClssFlgR;
	}
	
	/**
	 * Column Info
	 * @return agmthdrcreadjflg
	 */
	public String getAgmthdrcreadjflg() {
		return this.agmthdrcreadjflg;
	}
	
	/**
	 * Column Info
	 * @return r7Fd
	 */
	public String getR7Fd() {
		return this.r7Fd;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return dcgoN5thClssFlgFd
	 */
	public String getDcgoN5thClssFlgFd() {
		return this.dcgoN5thClssFlgFd;
	}
	
	/**
	 * Column Info
	 * @return tonRate
	 */
	public String getTonRate() {
		return this.tonRate;
	}
	
	/**
	 * Column Info
	 * @return accmDtlSeq
	 */
	public String getAccmDtlSeq() {
		return this.accmDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return commandH
	 */
	public String getCommandH() {
		return this.commandH;
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
	 * @return t2R
	 */
	public String getT2R() {
		return this.t2R;
	}
	
	/**
	 * Column Info
	 * @return thrpflg
	 */
	public String getThrpflg() {
		return this.thrpflg;
	}
	
	/**
	 * Column Info
	 * @return d5R
	 */
	public String getD5R() {
		return this.d5R;
	}
	
	/**
	 * Column Info
	 * @return o2Fd
	 */
	public String getO2Fd() {
		return this.o2Fd;
	}
	
	/**
	 * Column Info
	 * @return p2R
	 */
	public String getP2R() {
		return this.p2R;
	}
	
	/**
	 * Column Info
	 * @return vndrSeqHidden
	 */
	public String getVndrSeqHidden() {
		return this.vndrSeqHidden;
	}
	
	/**
	 * Column Info
	 * @return dcgoN1stClssFlgFd
	 */
	public String getDcgoN1stClssFlgFd() {
		return this.dcgoN1stClssFlgFd;
	}
	
	/**
	 * Column Info
	 * @return r8R
	 */
	public String getR8R() {
		return this.r8R;
	}
	
	/**
	 * Column Info
	 * @return c2R
	 */
	public String getC2R() {
		return this.c2R;
	}
	
	/**
	 * Column Info
	 * @return sepDgNoneR
	 */
	public String getSepDgNoneR() {
		return this.sepDgNoneR;
	}
	
	/**
	 * Column Info
	 * @return dxR
	 */
	public String getDxR() {
		return this.dxR;
	}
	
	/**
	 * Column Info
	 * @return dcgoN8thClssFlgFd
	 */
	public String getDcgoN8thClssFlgFd() {
		return this.dcgoN8thClssFlgFd;
	}
	
	/**
	 * Column Info
	 * @return regagmthdrflg
	 */
	public String getRegagmthdrflg() {
		return this.regagmthdrflg;
	}
	
	/**
	 * Column Info
	 * @return d7R
	 */
	public String getD7R() {
		return this.d7R;
	}
	
	/**
	 * Column Info
	 * @return initformdtlflg
	 */
	public String getInitformdtlflg() {
		return this.initformdtlflg;
	}
	
	/**
	 * Column Info
	 * @return a2
	 */
	public String getA2() {
		return this.a2;
	}
	
	/**
	 * Column Info
	 * @return dcgoN3rdClssFlgR
	 */
	public String getDcgoN3rdClssFlgR() {
		return this.dcgoN3rdClssFlgR;
	}
	
	/**
	 * Column Info
	 * @return a2R
	 */
	public String getA2R() {
		return this.a2R;
	}
	
	/**
	 * Column Info
	 * @return a4
	 */
	public String getA4() {
		return this.a4;
	}
	
	/**
	 * Column Info
	 * @return a5
	 */
	public String getA5() {
		return this.a5;
	}
	
	/**
	 * Column Info
	 * @return d8Fd
	 */
	public String getD8Fd() {
		return this.d8Fd;
	}
	
	/**
	 * Column Info
	 * @return dcgoN6thClssFlgFd
	 */
	public String getDcgoN6thClssFlgFd() {
		return this.dcgoN6thClssFlgFd;
	}
	
	/**
	 * Column Info
	 * @return isValidYdCd
	 */
	public String getIsValidYdCd() {
		return this.isValidYdCd;
	}
	
	/**
	 * Column Info
	 * @return o2
	 */
	public String getO2() {
		return this.o2;
	}
	
	/**
	 * Column Info
	 * @return o4
	 */
	public String getO4() {
		return this.o4;
	}
	
	/**
	 * Column Info
	 * @return dcgoN4thClssFlg
	 */
	public String getDcgoN4thClssFlg() {
		return this.dcgoN4thClssFlg;
	}
	
	/**
	 * Column Info
	 * @return r9R
	 */
	public String getR9R() {
		return this.r9R;
	}
	
	/**
	 * Column Info
	 * @return o5
	 */
	public String getO5() {
		return this.o5;
	}
	
	/**
	 * Column Info
	 * @return a4R
	 */
	public String getA4R() {
		return this.a4R;
	}
	
	/**
	 * Column Info
	 * @return dwR
	 */
	public String getDwR() {
		return this.dwR;
	}
	
	/**
	 * Column Info
	 * @return c4Fd
	 */
	public String getC4Fd() {
		return this.c4Fd;
	}
	
	/**
	 * Column Info
	 * @return d4Fd
	 */
	public String getD4Fd() {
		return this.d4Fd;
	}
	
	/**
	 * Column Info
	 * @return d8R
	 */
	public String getD8R() {
		return this.d8R;
	}
	
	/**
	 * Column Info
	 * @return sepDgNone
	 */
	public String getSepDgNone() {
		return this.sepDgNone;
	}
	
	/**
	 * Column Info
	 * @return a4Fd
	 */
	public String getA4Fd() {
		return this.a4Fd;
	}
	
	/**
	 * Column Info
	 * @return satFlgFd
	 */
	public String getSatFlgFd() {
		return this.satFlgFd;
	}
	
	/**
	 * Column Info
	 * @return sameDgFd
	 */
	public String getSameDgFd() {
		return this.sameDgFd;
	}
	
	/**
	 * Column Info
	 * @return tmlAgmtStsCd
	 */
	public String getTmlAgmtStsCd() {
		return this.tmlAgmtStsCd;
	}
	
	/**
	 * Column Info
	 * @return ydCdName
	 */
	public String getYdCdName() {
		return this.ydCdName;
	}
	
	/**
	 * Column Info
	 * @return r8Fd
	 */
	public String getR8Fd() {
		return this.r8Fd;
	}
	
	/**
	 * Column Info
	 * @return d9R
	 */
	public String getD9R() {
		return this.d9R;
	}
	
	/**
	 * Column Info
	 * @return regagmtflg
	 */
	public String getRegagmtflg() {
		return this.regagmtflg;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return vndrSeqDeltflg
	 */
	public String getVndrSeqDeltflg() {
		return this.vndrSeqDeltflg;
	}
	
	/**
	 * Column Info
	 * @return sameDg
	 */
	public String getSameDg() {
		return this.sameDg;
	}
	
	/**
	 * Column Info
	 * @return rowNum
	 */
	public String getRowNum() {
		return this.rowNum;
	}
	
	/**
	 * Column Info
	 * @return r4Fd
	 */
	public String getR4Fd() {
		return this.r4Fd;
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
	 * @return tsRt
	 */
	public String getTsRt() {
		return this.tsRt;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return dcgoNonClssFlgFd
	 */
	public String getDcgoNonClssFlgFd() {
		return this.dcgoNonClssFlgFd;
	}
	
	/**
	 * Column Info
	 * @return dwFd
	 */
	public String getDwFd() {
		return this.dwFd;
	}
	
	/**
	 * Column Info
	 * @return tmlAgmtOfcNo
	 */
	public String getTmlAgmtOfcNo() {
		return this.tmlAgmtOfcNo;
	}
	
	/**
	 * Column Info
	 * @return dgNone
	 */
	public String getDgNone() {
		return this.dgNone;
	}
	
	/**
	 * Column Info
	 * @return dcgoN2ndClssFlgFd
	 */
	public String getDcgoN2ndClssFlgFd() {
		return this.dcgoN2ndClssFlgFd;
	}
	
	/**
	 * Column Info
	 * @return tmlAgmtTpCd
	 */
	public String getTmlAgmtTpCd() {
		return this.tmlAgmtTpCd;
	}
	
	/**
	 * Column Info
	 * @return dcgoNonClssFlgR
	 */
	public String getDcgoNonClssFlgR() {
		return this.dcgoNonClssFlgR;
	}
	
	/**
	 * Column Info
	 * @return dcgoN1stClssFlg
	 */
	public String getDcgoN1stClssFlg() {
		return this.dcgoN1stClssFlg;
	}
	
	/**
	 * Column Info
	 * @return r2Fd
	 */
	public String getR2Fd() {
		return this.r2Fd;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd2
	 */
	public String getCreOfcCd2() {
		return this.creOfcCd2;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return inquiryflg
	 */
	public String getInquiryflg() {
		return this.inquiryflg;
	}
	
	/**
	 * Column Info
	 * @return dcgoN3rdClssFlg
	 */
	public String getDcgoN3rdClssFlg() {
		return this.dcgoN3rdClssFlg;
	}
	
	/**
	 * Column Info
	 * @return agmtConfirmFlg
	 */
	public String getAgmtConfirmFlg() {
		return this.agmtConfirmFlg;
	}
	
	/**
	 * Column Info
	 * @return fileimportflg
	 */
	public String getFileimportflg() {
		return this.fileimportflg;
	}
	
	/**
	 * Column Info
	 * @return ydCdHidden
	 */
	public String getYdCdHidden() {
		return this.ydCdHidden;
	}
	
	/**
	 * Column Info
	 * @return f5Fd
	 */
	public String getF5Fd() {
		return this.f5Fd;
	}
	
	/**
	 * Column Info
	 * @return holFlgFd
	 */
	public String getHolFlgFd() {
		return this.holFlgFd;
	}
	
	/**
	 * Column Info
	 * @return f4Fd
	 */
	public String getF4Fd() {
		return this.f4Fd;
	}
	
	/**
	 * Column Info
	 * @return boxRate
	 */
	public String getBoxRate() {
		return this.boxRate;
	}
	
	/**
	 * Column Info
	 * @return t2Fd
	 */
	public String getT2Fd() {
		return this.t2Fd;
	}
	

	/**
	 * Column Info
	 * @param accmSeq
	 */
	public void setAccmSeq(String accmSeq) {
		this.accmSeq = accmSeq;
	}
	
	/**
	 * Column Info
	 * @param f2R
	 */
	public void setF2R(String f2R) {
		this.f2R = f2R;
	}
	
	/**
	 * Column Info
	 * @param s2R
	 */
	public void setS2R(String s2R) {
		this.s2R = s2R;
	}
	
	/**
	 * Column Info
	 * @param r2R
	 */
	public void setR2R(String r2R) {
		this.r2R = r2R;
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
	 * @param moveRate
	 */
	public void setMoveRate(String moveRate) {
		this.moveRate = moveRate;
	}
	
	/**
	 * Column Info
	 * @param laneCdstring
	 */
	public void setLaneCdstring(String laneCdstring) {
		this.laneCdstring = laneCdstring;
	}
	
	/**
	 * Column Info
	 * @param a2Fd
	 */
	public void setA2Fd(String a2Fd) {
		this.a2Fd = a2Fd;
	}
	
	/**
	 * Column Info
	 * @param dcgoN7thClssFlgR
	 */
	public void setDcgoN7thClssFlgR(String dcgoN7thClssFlgR) {
		this.dcgoN7thClssFlgR = dcgoN7thClssFlgR;
	}
	
	/**
	 * Column Info
	 * @param sepDgNoneFd
	 */
	public void setSepDgNoneFd(String sepDgNoneFd) {
		this.sepDgNoneFd = sepDgNoneFd;
	}
	
	/**
	 * Column Info
	 * @param dcgoN2ndClssFlgR
	 */
	public void setDcgoN2ndClssFlgR(String dcgoN2ndClssFlgR) {
		this.dcgoN2ndClssFlgR = dcgoN2ndClssFlgR;
	}
	
	/**
	 * Column Info
	 * @param dcgoNonClssFlg
	 */
	public void setDcgoNonClssFlg(String dcgoNonClssFlg) {
		this.dcgoNonClssFlg = dcgoNonClssFlg;
	}
	
	/**
	 * Column Info
	 * @param dxFd
	 */
	public void setDxFd(String dxFd) {
		this.dxFd = dxFd;
	}
	
	/**
	 * Column Info
	 * @param o2R
	 */
	public void setO2R(String o2R) {
		this.o2R = o2R;
	}
	
	/**
	 * Column Info
	 * @param r9Fd
	 */
	public void setR9Fd(String r9Fd) {
		this.r9Fd = r9Fd;
	}
	
	/**
	 * Column Info
	 * @param dcgoN5thClssFlg
	 */
	public void setDcgoN5thClssFlg(String dcgoN5thClssFlg) {
		this.dcgoN5thClssFlg = dcgoN5thClssFlg;
	}
	
	/**
	 * Column Info
	 * @param r5Fd
	 */
	public void setR5Fd(String r5Fd) {
		this.r5Fd = r5Fd;
	}
	
	/**
	 * Column Info
	 * @param ydCdDeltflg
	 */
	public void setYdCdDeltflg(String ydCdDeltflg) {
		this.ydCdDeltflg = ydCdDeltflg;
	}
	
	/**
	 * Column Info
	 * @param effAgmt
	 */
	public void setEffAgmt(String effAgmt) {
		this.effAgmt = effAgmt;
	}
	
	/**
	 * Column Info
	 * @param s4R
	 */
	public void setS4R(String s4R) {
		this.s4R = s4R;
	}
	
	/**
	 * Column Info
	 * @param dw
	 */
	public void setDw(String dw) {
		this.dw = dw;
	}
	
	/**
	 * Column Info
	 * @param dx
	 */
	public void setDx(String dx) {
		this.dx = dx;
	}
	
	/**
	 * Column Info
	 * @param sameDgNoneFd
	 */
	public void setSameDgNoneFd(String sameDgNoneFd) {
		this.sameDgNoneFd = sameDgNoneFd;
	}
	
	/**
	 * Column Info
	 * @param vfsarray
	 */
	public void setVfsarray(String vfsarray) {
		this.vfsarray = vfsarray;
	}
	
	/**
	 * Column Info
	 * @param dcgoN4thClssFlgR
	 */
	public void setDcgoN4thClssFlgR(String dcgoN4thClssFlgR) {
		this.dcgoN4thClssFlgR = dcgoN4thClssFlgR;
	}
	
	/**
	 * Column Info
	 * @param o5R
	 */
	public void setO5R(String o5R) {
		this.o5R = o5R;
	}
	
	/**
	 * Column Info
	 * @param dcgoN8thClssFlg
	 */
	public void setDcgoN8thClssFlg(String dcgoN8thClssFlg) {
		this.dcgoN8thClssFlg = dcgoN8thClssFlg;
	}
	
	/**
	 * Column Info
	 * @param teuRate
	 */
	public void setTeuRate(String teuRate) {
		this.teuRate = teuRate;
	}
	
	/**
	 * Column Info
	 * @param f2
	 */
	public void setF2(String f2) {
		this.f2 = f2;
	}
	
	/**
	 * Column Info
	 * @param f5
	 */
	public void setF5(String f5) {
		this.f5 = f5;
	}
	
	/**
	 * Column Info
	 * @param f4
	 */
	public void setF4(String f4) {
		this.f4 = f4;
	}
	
	/**
	 * Column Info
	 * @param c2Fd
	 */
	public void setC2Fd(String c2Fd) {
		this.c2Fd = c2Fd;
	}
	
	/**
	 * Column Info
	 * @param sameDgR
	 */
	public void setSameDgR(String sameDgR) {
		this.sameDgR = sameDgR;
	}
	
	/**
	 * Column Info
	 * @param dcgoN7thClssFlg
	 */
	public void setDcgoN7thClssFlg(String dcgoN7thClssFlg) {
		this.dcgoN7thClssFlg = dcgoN7thClssFlg;
	}
	
	/**
	 * Column Info
	 * @param o4R
	 */
	public void setO4R(String o4R) {
		this.o4R = o4R;
	}
	
	/**
	 * Column Info
	 * @param dcgoN4thClssFlgFd
	 */
	public void setDcgoN4thClssFlgFd(String dcgoN4thClssFlgFd) {
		this.dcgoN4thClssFlgFd = dcgoN4thClssFlgFd;
	}
	
	/**
	 * Column Info
	 * @param isValidVndrSeq
	 */
	public void setIsValidVndrSeq(String isValidVndrSeq) {
		this.isValidVndrSeq = isValidVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param amendCd
	 */
	public void setAmendCd(String amendCd) {
		this.amendCd = amendCd;
	}
	
	/**
	 * Column Info
	 * @param dgNoneR
	 */
	public void setDgNoneR(String dgNoneR) {
		this.dgNoneR = dgNoneR;
	}
	
	/**
	 * Column Info
	 * @param wkdyFlgFd
	 */
	public void setWkdyFlgFd(String wkdyFlgFd) {
		this.wkdyFlgFd = wkdyFlgFd;
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
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param lgsCostCd
	 */
	public void setLgsCostCd(String lgsCostCd) {
		this.lgsCostCd = lgsCostCd;
	}
	
	/**
	 * Column Info
	 * @param dcgoN6thClssFlg
	 */
	public void setDcgoN6thClssFlg(String dcgoN6thClssFlg) {
		this.dcgoN6thClssFlg = dcgoN6thClssFlg;
	}
	
	/**
	 * Column Info
	 * @param a5Fd
	 */
	public void setA5Fd(String a5Fd) {
		this.a5Fd = a5Fd;
	}
	
	/**
	 * Column Info
	 * @param accmCostSeq
	 */
	public void setAccmCostSeq(String accmCostSeq) {
		this.accmCostSeq = accmCostSeq;
	}
	
	/**
	 * Column Info
	 * @param fCmd
	 */
	public void setFCmd(String fCmd) {
		this.fCmd = fCmd;
	}
	
	/**
	 * Column Info
	 * @param d9
	 */
	public void setD9(String d9) {
		this.d9 = d9;
	}
	
	/**
	 * Column Info
	 * @param d8
	 */
	public void setD8(String d8) {
		this.d8 = d8;
	}
	
	/**
	 * Column Info
	 * @param d5
	 */
	public void setD5(String d5) {
		this.d5 = d5;
	}
	
	/**
	 * Column Info
	 * @param d4
	 */
	public void setD4(String d4) {
		this.d4 = d4;
	}
	
	/**
	 * Column Info
	 * @param d7
	 */
	public void setD7(String d7) {
		this.d7 = d7;
	}
	
	/**
	 * Column Info
	 * @param d2Fd
	 */
	public void setD2Fd(String d2Fd) {
		this.d2Fd = d2Fd;
	}
	
	/**
	 * Column Info
	 * @param sheetPrefix
	 */
	public void setSheetPrefix(String sheetPrefix) {
		this.sheetPrefix = sheetPrefix;
	}
	
	/**
	 * Column Info
	 * @param d2
	 */
	public void setD2(String d2) {
		this.d2 = d2;
	}
	
	/**
	 * Column Info
	 * @param p2Fd
	 */
	public void setP2Fd(String p2Fd) {
		this.p2Fd = p2Fd;
	}
	
	/**
	 * Column Info
	 * @param effOn
	 */
	public void setEffOn(String effOn) {
		this.effOn = effOn;
	}
	
	/**
	 * Column Info
	 * @param copyTmlAgmtOfcCtyCd
	 */
	public void setCopyTmlAgmtOfcCtyCd(String copyTmlAgmtOfcCtyCd) {
		this.copyTmlAgmtOfcCtyCd = copyTmlAgmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param sameDgNoneR
	 */
	public void setSameDgNoneR(String sameDgNoneR) {
		this.sameDgNoneR = sameDgNoneR;
	}
	
	/**
	 * Column Info
	 * @param p4Fd
	 */
	public void setP4Fd(String p4Fd) {
		this.p4Fd = p4Fd;
	}
	
	/**
	 * Column Info
	 * @param dcgoN3rdClssFlgFd
	 */
	public void setDcgoN3rdClssFlgFd(String dcgoN3rdClssFlgFd) {
		this.dcgoN3rdClssFlgFd = dcgoN3rdClssFlgFd;
	}
	
	/**
	 * Column Info
	 * @param d9Fd
	 */
	public void setD9Fd(String d9Fd) {
		this.d9Fd = d9Fd;
	}
	
	/**
	 * Column Info
	 * @param selectTab
	 */
	public void setSelectTab(String selectTab) {
		this.selectTab = selectTab;
	}
	
	/**
	 * Column Info
	 * @param dcgoN9thClssFlg
	 */
	public void setDcgoN9thClssFlg(String dcgoN9thClssFlg) {
		this.dcgoN9thClssFlg = dcgoN9thClssFlg;
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
	 * @param t4
	 */
	public void setT4(String t4) {
		this.t4 = t4;
	}
	
	/**
	 * Column Info
	 * @param gangHourRate
	 */
	public void setGangHourRate(String gangHourRate) {
		this.gangHourRate = gangHourRate;
	}
	
	/**
	 * Column Info
	 * @param r7R
	 */
	public void setR7R(String r7R) {
		this.r7R = r7R;
	}
	
	/**
	 * Column Info
	 * @param dcgoN7thClssFlgFd
	 */
	public void setDcgoN7thClssFlgFd(String dcgoN7thClssFlgFd) {
		this.dcgoN7thClssFlgFd = dcgoN7thClssFlgFd;
	}
	
	/**
	 * Column Info
	 * @param t2
	 */
	public void setT2(String t2) {
		this.t2 = t2;
	}
	
	/**
	 * Column Info
	 * @param r4R
	 */
	public void setR4R(String r4R) {
		this.r4R = r4R;
	}
	
	/**
	 * Column Info
	 * @param dcgoN2ndClssFlg
	 */
	public void setDcgoN2ndClssFlg(String dcgoN2ndClssFlg) {
		this.dcgoN2ndClssFlg = dcgoN2ndClssFlg;
	}
	
	/**
	 * Column Info
	 * @param ipage
	 */
	public void setIpage(String ipage) {
		this.ipage = ipage;
	}
	
	/**
	 * Column Info
	 * @param dcgoN6thClssFlgR
	 */
	public void setDcgoN6thClssFlgR(String dcgoN6thClssFlgR) {
		this.dcgoN6thClssFlgR = dcgoN6thClssFlgR;
	}
	
	/**
	 * Column Info
	 * @param f4R
	 */
	public void setF4R(String f4R) {
		this.f4R = f4R;
	}
	
	/**
	 * Column Info
	 * @param s4Fd
	 */
	public void setS4Fd(String s4Fd) {
		this.s4Fd = s4Fd;
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
	 * @param f2Fd
	 */
	public void setF2Fd(String f2Fd) {
		this.f2Fd = f2Fd;
	}
	
	/**
	 * Column Info
	 * @param inputListVerifyFlg
	 */
	public void setInputListVerifyFlg(String inputListVerifyFlg) {
		this.inputListVerifyFlg = inputListVerifyFlg;
	}
	
	/**
	 * Column Info
	 * @param o4Fd
	 */
	public void setO4Fd(String o4Fd) {
		this.o4Fd = o4Fd;
	}
	
	/**
	 * Column Info
	 * @param o5Fd
	 */
	public void setO5Fd(String o5Fd) {
		this.o5Fd = o5Fd;
	}
	
	/**
	 * Column Info
	 * @param t4R
	 */
	public void setT4R(String t4R) {
		this.t4R = t4R;
	}
	
	/**
	 * Column Info
	 * @param s4
	 */
	public void setS4(String s4) {
		this.s4 = s4;
	}
	
	/**
	 * Column Info
	 * @param sunFlgFd
	 */
	public void setSunFlgFd(String sunFlgFd) {
		this.sunFlgFd = sunFlgFd;
	}
	
	/**
	 * Column Info
	 * @param s2
	 */
	public void setS2(String s2) {
		this.s2 = s2;
	}
	
	/**
	 * Column Info
	 * @param dgNoneFd
	 */
	public void setDgNoneFd(String dgNoneFd) {
		this.dgNoneFd = dgNoneFd;
	}
	
	/**
	 * Column Info
	 * @param d7Fd
	 */
	public void setD7Fd(String d7Fd) {
		this.d7Fd = d7Fd;
	}
	
	/**
	 * Column Info
	 * @param dcgoN9thClssFlgR
	 */
	public void setDcgoN9thClssFlgR(String dcgoN9thClssFlgR) {
		this.dcgoN9thClssFlgR = dcgoN9thClssFlgR;
	}
	
	/**
	 * Column Info
	 * @param d5Fd
	 */
	public void setD5Fd(String d5Fd) {
		this.d5Fd = d5Fd;
	}
	
	/**
	 * Column Info
	 * @param loopValue
	 */
	public void setLoopValue(String loopValue) {
		this.loopValue = loopValue;
	}
	
	/**
	 * Column Info
	 * @param c4
	 */
	public void setC4(String c4) {
		this.c4 = c4;
	}
	
	/**
	 * Column Info
	 * @param f5R
	 */
	public void setF5R(String f5R) {
		this.f5R = f5R;
	}
	
	/**
	 * Column Info
	 * @param sameDgNone
	 */
	public void setSameDgNone(String sameDgNone) {
		this.sameDgNone = sameDgNone;
	}
	
	/**
	 * Column Info
	 * @param p4R
	 */
	public void setP4R(String p4R) {
		this.p4R = p4R;
	}
	
	/**
	 * Column Info
	 * @param c2
	 */
	public void setC2(String c2) {
		this.c2 = c2;
	}
	
	/**
	 * Column Info
	 * @param d2R
	 */
	public void setD2R(String d2R) {
		this.d2R = d2R;
	}
	
	/**
	 * Column Info
	 * @param s2Fd
	 */
	public void setS2Fd(String s2Fd) {
		this.s2Fd = s2Fd;
	}
	
	/**
	 * Column Info
	 * @param r7
	 */
	public void setR7(String r7) {
		this.r7 = r7;
	}
	
	/**
	 * Column Info
	 * @param r8
	 */
	public void setR8(String r8) {
		this.r8 = r8;
	}
	
	/**
	 * Column Info
	 * @param r5R
	 */
	public void setR5R(String r5R) {
		this.r5R = r5R;
	}
	
	/**
	 * Column Info
	 * @param r9
	 */
	public void setR9(String r9) {
		this.r9 = r9;
	}
	
	/**
	 * Column Info
	 * @param r2
	 */
	public void setR2(String r2) {
		this.r2 = r2;
	}
	
	/**
	 * Column Info
	 * @param r4
	 */
	public void setR4(String r4) {
		this.r4 = r4;
	}
	
	/**
	 * Column Info
	 * @param r5
	 */
	public void setR5(String r5) {
		this.r5 = r5;
	}
	
	/**
	 * Column Info
	 * @param tmlAgmtVolUtCd
	 */
	public void setTmlAgmtVolUtCd(String tmlAgmtVolUtCd) {
		this.tmlAgmtVolUtCd = tmlAgmtVolUtCd;
	}
	
	/**
	 * Column Info
	 * @param a5R
	 */
	public void setA5R(String a5R) {
		this.a5R = a5R;
	}
	
	/**
	 * Column Info
	 * @param p4
	 */
	public void setP4(String p4) {
		this.p4 = p4;
	}
	
	/**
	 * Column Info
	 * @param dcgoN5thClssFlgR
	 */
	public void setDcgoN5thClssFlgR(String dcgoN5thClssFlgR) {
		this.dcgoN5thClssFlgR = dcgoN5thClssFlgR;
	}
	
	/**
	 * Column Info
	 * @param p2
	 */
	public void setP2(String p2) {
		this.p2 = p2;
	}
	
	/**
	 * Column Info
	 * @param dcgoN9thClssFlgFd
	 */
	public void setDcgoN9thClssFlgFd(String dcgoN9thClssFlgFd) {
		this.dcgoN9thClssFlgFd = dcgoN9thClssFlgFd;
	}
	
	/**
	 * Column Info
	 * @param c4R
	 */
	public void setC4R(String c4R) {
		this.c4R = c4R;
	}
	
	/**
	 * Column Info
	 * @param d4R
	 */
	public void setD4R(String d4R) {
		this.d4R = d4R;
	}
	
	/**
	 * Column Info
	 * @param dcgoN1stClssFlgR
	 */
	public void setDcgoN1stClssFlgR(String dcgoN1stClssFlgR) {
		this.dcgoN1stClssFlgR = dcgoN1stClssFlgR;
	}
	
	/**
	 * Column Info
	 * @param t4Fd
	 */
	public void setT4Fd(String t4Fd) {
		this.t4Fd = t4Fd;
	}
	
	/**
	 * Column Info
	 * @param dcgoN8thClssFlgR
	 */
	public void setDcgoN8thClssFlgR(String dcgoN8thClssFlgR) {
		this.dcgoN8thClssFlgR = dcgoN8thClssFlgR;
	}
	
	/**
	 * Column Info
	 * @param agmthdrcreadjflg
	 */
	public void setAgmthdrcreadjflg(String agmthdrcreadjflg) {
		this.agmthdrcreadjflg = agmthdrcreadjflg;
	}
	
	/**
	 * Column Info
	 * @param r7Fd
	 */
	public void setR7Fd(String r7Fd) {
		this.r7Fd = r7Fd;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param dcgoN5thClssFlgFd
	 */
	public void setDcgoN5thClssFlgFd(String dcgoN5thClssFlgFd) {
		this.dcgoN5thClssFlgFd = dcgoN5thClssFlgFd;
	}
	
	/**
	 * Column Info
	 * @param tonRate
	 */
	public void setTonRate(String tonRate) {
		this.tonRate = tonRate;
	}
	
	/**
	 * Column Info
	 * @param accmDtlSeq
	 */
	public void setAccmDtlSeq(String accmDtlSeq) {
		this.accmDtlSeq = accmDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param commandH
	 */
	public void setCommandH(String commandH) {
		this.commandH = commandH;
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
	 * @param t2R
	 */
	public void setT2R(String t2R) {
		this.t2R = t2R;
	}
	
	/**
	 * Column Info
	 * @param thrpflg
	 */
	public void setThrpflg(String thrpflg) {
		this.thrpflg = thrpflg;
	}
	
	/**
	 * Column Info
	 * @param d5R
	 */
	public void setD5R(String d5R) {
		this.d5R = d5R;
	}
	
	/**
	 * Column Info
	 * @param o2Fd
	 */
	public void setO2Fd(String o2Fd) {
		this.o2Fd = o2Fd;
	}
	
	/**
	 * Column Info
	 * @param p2R
	 */
	public void setP2R(String p2R) {
		this.p2R = p2R;
	}
	
	/**
	 * Column Info
	 * @param vndrSeqHidden
	 */
	public void setVndrSeqHidden(String vndrSeqHidden) {
		this.vndrSeqHidden = vndrSeqHidden;
	}
	
	/**
	 * Column Info
	 * @param dcgoN1stClssFlgFd
	 */
	public void setDcgoN1stClssFlgFd(String dcgoN1stClssFlgFd) {
		this.dcgoN1stClssFlgFd = dcgoN1stClssFlgFd;
	}
	
	/**
	 * Column Info
	 * @param r8R
	 */
	public void setR8R(String r8R) {
		this.r8R = r8R;
	}
	
	/**
	 * Column Info
	 * @param c2R
	 */
	public void setC2R(String c2R) {
		this.c2R = c2R;
	}
	
	/**
	 * Column Info
	 * @param sepDgNoneR
	 */
	public void setSepDgNoneR(String sepDgNoneR) {
		this.sepDgNoneR = sepDgNoneR;
	}
	
	/**
	 * Column Info
	 * @param dxR
	 */
	public void setDxR(String dxR) {
		this.dxR = dxR;
	}
	
	/**
	 * Column Info
	 * @param dcgoN8thClssFlgFd
	 */
	public void setDcgoN8thClssFlgFd(String dcgoN8thClssFlgFd) {
		this.dcgoN8thClssFlgFd = dcgoN8thClssFlgFd;
	}
	
	/**
	 * Column Info
	 * @param regagmthdrflg
	 */
	public void setRegagmthdrflg(String regagmthdrflg) {
		this.regagmthdrflg = regagmthdrflg;
	}
	
	/**
	 * Column Info
	 * @param d7R
	 */
	public void setD7R(String d7R) {
		this.d7R = d7R;
	}
	
	/**
	 * Column Info
	 * @param initformdtlflg
	 */
	public void setInitformdtlflg(String initformdtlflg) {
		this.initformdtlflg = initformdtlflg;
	}
	
	/**
	 * Column Info
	 * @param a2
	 */
	public void setA2(String a2) {
		this.a2 = a2;
	}
	
	/**
	 * Column Info
	 * @param dcgoN3rdClssFlgR
	 */
	public void setDcgoN3rdClssFlgR(String dcgoN3rdClssFlgR) {
		this.dcgoN3rdClssFlgR = dcgoN3rdClssFlgR;
	}
	
	/**
	 * Column Info
	 * @param a2R
	 */
	public void setA2R(String a2R) {
		this.a2R = a2R;
	}
	
	/**
	 * Column Info
	 * @param a4
	 */
	public void setA4(String a4) {
		this.a4 = a4;
	}
	
	/**
	 * Column Info
	 * @param a5
	 */
	public void setA5(String a5) {
		this.a5 = a5;
	}
	
	/**
	 * Column Info
	 * @param d8Fd
	 */
	public void setD8Fd(String d8Fd) {
		this.d8Fd = d8Fd;
	}
	
	/**
	 * Column Info
	 * @param dcgoN6thClssFlgFd
	 */
	public void setDcgoN6thClssFlgFd(String dcgoN6thClssFlgFd) {
		this.dcgoN6thClssFlgFd = dcgoN6thClssFlgFd;
	}
	
	/**
	 * Column Info
	 * @param isValidYdCd
	 */
	public void setIsValidYdCd(String isValidYdCd) {
		this.isValidYdCd = isValidYdCd;
	}
	
	/**
	 * Column Info
	 * @param o2
	 */
	public void setO2(String o2) {
		this.o2 = o2;
	}
	
	/**
	 * Column Info
	 * @param o4
	 */
	public void setO4(String o4) {
		this.o4 = o4;
	}
	
	/**
	 * Column Info
	 * @param dcgoN4thClssFlg
	 */
	public void setDcgoN4thClssFlg(String dcgoN4thClssFlg) {
		this.dcgoN4thClssFlg = dcgoN4thClssFlg;
	}
	
	/**
	 * Column Info
	 * @param r9R
	 */
	public void setR9R(String r9R) {
		this.r9R = r9R;
	}
	
	/**
	 * Column Info
	 * @param o5
	 */
	public void setO5(String o5) {
		this.o5 = o5;
	}
	
	/**
	 * Column Info
	 * @param a4R
	 */
	public void setA4R(String a4R) {
		this.a4R = a4R;
	}
	
	/**
	 * Column Info
	 * @param dwR
	 */
	public void setDwR(String dwR) {
		this.dwR = dwR;
	}
	
	/**
	 * Column Info
	 * @param c4Fd
	 */
	public void setC4Fd(String c4Fd) {
		this.c4Fd = c4Fd;
	}
	
	/**
	 * Column Info
	 * @param d4Fd
	 */
	public void setD4Fd(String d4Fd) {
		this.d4Fd = d4Fd;
	}
	
	/**
	 * Column Info
	 * @param d8R
	 */
	public void setD8R(String d8R) {
		this.d8R = d8R;
	}
	
	/**
	 * Column Info
	 * @param sepDgNone
	 */
	public void setSepDgNone(String sepDgNone) {
		this.sepDgNone = sepDgNone;
	}
	
	/**
	 * Column Info
	 * @param a4Fd
	 */
	public void setA4Fd(String a4Fd) {
		this.a4Fd = a4Fd;
	}
	
	/**
	 * Column Info
	 * @param satFlgFd
	 */
	public void setSatFlgFd(String satFlgFd) {
		this.satFlgFd = satFlgFd;
	}
	
	/**
	 * Column Info
	 * @param sameDgFd
	 */
	public void setSameDgFd(String sameDgFd) {
		this.sameDgFd = sameDgFd;
	}
	
	/**
	 * Column Info
	 * @param tmlAgmtStsCd
	 */
	public void setTmlAgmtStsCd(String tmlAgmtStsCd) {
		this.tmlAgmtStsCd = tmlAgmtStsCd;
	}
	
	/**
	 * Column Info
	 * @param ydCdName
	 */
	public void setYdCdName(String ydCdName) {
		this.ydCdName = ydCdName;
	}
	
	/**
	 * Column Info
	 * @param r8Fd
	 */
	public void setR8Fd(String r8Fd) {
		this.r8Fd = r8Fd;
	}
	
	/**
	 * Column Info
	 * @param d9R
	 */
	public void setD9R(String d9R) {
		this.d9R = d9R;
	}
	
	/**
	 * Column Info
	 * @param regagmtflg
	 */
	public void setRegagmtflg(String regagmtflg) {
		this.regagmtflg = regagmtflg;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param vndrSeqDeltflg
	 */
	public void setVndrSeqDeltflg(String vndrSeqDeltflg) {
		this.vndrSeqDeltflg = vndrSeqDeltflg;
	}
	
	/**
	 * Column Info
	 * @param sameDg
	 */
	public void setSameDg(String sameDg) {
		this.sameDg = sameDg;
	}
	
	/**
	 * Column Info
	 * @param rowNum
	 */
	public void setRowNum(String rowNum) {
		this.rowNum = rowNum;
	}
	
	/**
	 * Column Info
	 * @param r4Fd
	 */
	public void setR4Fd(String r4Fd) {
		this.r4Fd = r4Fd;
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
	 * @param tsRt
	 */
	public void setTsRt(String tsRt) {
		this.tsRt = tsRt;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param dcgoNonClssFlgFd
	 */
	public void setDcgoNonClssFlgFd(String dcgoNonClssFlgFd) {
		this.dcgoNonClssFlgFd = dcgoNonClssFlgFd;
	}
	
	/**
	 * Column Info
	 * @param dwFd
	 */
	public void setDwFd(String dwFd) {
		this.dwFd = dwFd;
	}
	
	/**
	 * Column Info
	 * @param tmlAgmtOfcNo
	 */
	public void setTmlAgmtOfcNo(String tmlAgmtOfcNo) {
		this.tmlAgmtOfcNo = tmlAgmtOfcNo;
	}
	
	/**
	 * Column Info
	 * @param dgNone
	 */
	public void setDgNone(String dgNone) {
		this.dgNone = dgNone;
	}
	
	/**
	 * Column Info
	 * @param dcgoN2ndClssFlgFd
	 */
	public void setDcgoN2ndClssFlgFd(String dcgoN2ndClssFlgFd) {
		this.dcgoN2ndClssFlgFd = dcgoN2ndClssFlgFd;
	}
	
	/**
	 * Column Info
	 * @param tmlAgmtTpCd
	 */
	public void setTmlAgmtTpCd(String tmlAgmtTpCd) {
		this.tmlAgmtTpCd = tmlAgmtTpCd;
	}
	
	/**
	 * Column Info
	 * @param dcgoNonClssFlgR
	 */
	public void setDcgoNonClssFlgR(String dcgoNonClssFlgR) {
		this.dcgoNonClssFlgR = dcgoNonClssFlgR;
	}
	
	/**
	 * Column Info
	 * @param dcgoN1stClssFlg
	 */
	public void setDcgoN1stClssFlg(String dcgoN1stClssFlg) {
		this.dcgoN1stClssFlg = dcgoN1stClssFlg;
	}
	
	/**
	 * Column Info
	 * @param r2Fd
	 */
	public void setR2Fd(String r2Fd) {
		this.r2Fd = r2Fd;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd2
	 */
	public void setCreOfcCd2(String creOfcCd2) {
		this.creOfcCd2 = creOfcCd2;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param inquiryflg
	 */
	public void setInquiryflg(String inquiryflg) {
		this.inquiryflg = inquiryflg;
	}
	
	/**
	 * Column Info
	 * @param dcgoN3rdClssFlg
	 */
	public void setDcgoN3rdClssFlg(String dcgoN3rdClssFlg) {
		this.dcgoN3rdClssFlg = dcgoN3rdClssFlg;
	}
	
	/**
	 * Column Info
	 * @param agmtConfirmFlg
	 */
	public void setAgmtConfirmFlg(String agmtConfirmFlg) {
		this.agmtConfirmFlg = agmtConfirmFlg;
	}
	
	/**
	 * Column Info
	 * @param fileimportflg
	 */
	public void setFileimportflg(String fileimportflg) {
		this.fileimportflg = fileimportflg;
	}
	
	/**
	 * Column Info
	 * @param ydCdHidden
	 */
	public void setYdCdHidden(String ydCdHidden) {
		this.ydCdHidden = ydCdHidden;
	}
	
	/**
	 * Column Info
	 * @param f5Fd
	 */
	public void setF5Fd(String f5Fd) {
		this.f5Fd = f5Fd;
	}
	
	/**
	 * Column Info
	 * @param holFlgFd
	 */
	public void setHolFlgFd(String holFlgFd) {
		this.holFlgFd = holFlgFd;
	}
	
	/**
	 * Column Info
	 * @param f4Fd
	 */
	public void setF4Fd(String f4Fd) {
		this.f4Fd = f4Fd;
	}
	
	/**
	 * Column Info
	 * @param boxRate
	 */
	public void setBoxRate(String boxRate) {
		this.boxRate = boxRate;
	}
	
	/**
	 * Column Info
	 * @param t2Fd
	 */
	public void setT2Fd(String t2Fd) {
		this.t2Fd = t2Fd;
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
		setAccmSeq(JSPUtil.getParameter(request, prefix + "accm_seq", ""));
		setF2R(JSPUtil.getParameter(request, prefix + "f2_r", ""));
		setS2R(JSPUtil.getParameter(request, prefix + "s2_r", ""));
		setR2R(JSPUtil.getParameter(request, prefix + "r2_r", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setMoveRate(JSPUtil.getParameter(request, prefix + "move_rate", ""));
		setLaneCdstring(JSPUtil.getParameter(request, prefix + "lane_cdstring", ""));
		setA2Fd(JSPUtil.getParameter(request, prefix + "a2_fd", ""));
		setDcgoN7thClssFlgR(JSPUtil.getParameter(request, prefix + "dcgo_n7th_clss_flg_r", ""));
		setSepDgNoneFd(JSPUtil.getParameter(request, prefix + "sep_dg_none_fd", ""));
		setDcgoN2ndClssFlgR(JSPUtil.getParameter(request, prefix + "dcgo_n2nd_clss_flg_r", ""));
		setDcgoNonClssFlg(JSPUtil.getParameter(request, prefix + "dcgo_non_clss_flg", ""));
		setDxFd(JSPUtil.getParameter(request, prefix + "dx_fd", ""));
		setO2R(JSPUtil.getParameter(request, prefix + "o2_r", ""));
		setR9Fd(JSPUtil.getParameter(request, prefix + "r9_fd", ""));
		setDcgoN5thClssFlg(JSPUtil.getParameter(request, prefix + "dcgo_n5th_clss_flg", ""));
		setR5Fd(JSPUtil.getParameter(request, prefix + "r5_fd", ""));
		setYdCdDeltflg(JSPUtil.getParameter(request, prefix + "yd_cd_deltflg", ""));
		setEffAgmt(JSPUtil.getParameter(request, prefix + "eff_agmt", ""));
		setS4R(JSPUtil.getParameter(request, prefix + "s4_r", ""));
		setDw(JSPUtil.getParameter(request, prefix + "dw", ""));
		setDx(JSPUtil.getParameter(request, prefix + "dx", ""));
		setSameDgNoneFd(JSPUtil.getParameter(request, prefix + "same_dg_none_fd", ""));
		setVfsarray(JSPUtil.getParameter(request, prefix + "vfsarray", ""));
		setDcgoN4thClssFlgR(JSPUtil.getParameter(request, prefix + "dcgo_n4th_clss_flg_r", ""));
		setO5R(JSPUtil.getParameter(request, prefix + "o5_r", ""));
		setDcgoN8thClssFlg(JSPUtil.getParameter(request, prefix + "dcgo_n8th_clss_flg", ""));
		setTeuRate(JSPUtil.getParameter(request, prefix + "teu_rate", ""));
		setF2(JSPUtil.getParameter(request, prefix + "f2", ""));
		setF5(JSPUtil.getParameter(request, prefix + "f5", ""));
		setF4(JSPUtil.getParameter(request, prefix + "f4", ""));
		setC2Fd(JSPUtil.getParameter(request, prefix + "c2_fd", ""));
		setSameDgR(JSPUtil.getParameter(request, prefix + "same_dg_r", ""));
		setDcgoN7thClssFlg(JSPUtil.getParameter(request, prefix + "dcgo_n7th_clss_flg", ""));
		setO4R(JSPUtil.getParameter(request, prefix + "o4_r", ""));
		setDcgoN4thClssFlgFd(JSPUtil.getParameter(request, prefix + "dcgo_n4th_clss_flg_fd", ""));
		setIsValidVndrSeq(JSPUtil.getParameter(request, prefix + "is_valid_vndr_seq", ""));
		setAmendCd(JSPUtil.getParameter(request, prefix + "amend_cd", ""));
		setDgNoneR(JSPUtil.getParameter(request, prefix + "dg_none_r", ""));
		setWkdyFlgFd(JSPUtil.getParameter(request, prefix + "wkdy_flg_fd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setLgsCostCd(JSPUtil.getParameter(request, prefix + "lgs_cost_cd", ""));
		setDcgoN6thClssFlg(JSPUtil.getParameter(request, prefix + "dcgo_n6th_clss_flg", ""));
		setA5Fd(JSPUtil.getParameter(request, prefix + "a5_fd", ""));
		setAccmCostSeq(JSPUtil.getParameter(request, prefix + "accm_cost_seq", ""));
		setFCmd(JSPUtil.getParameter(request, prefix + "f_cmd", ""));
		setD9(JSPUtil.getParameter(request, prefix + "d9", ""));
		setD8(JSPUtil.getParameter(request, prefix + "d8", ""));
		setD5(JSPUtil.getParameter(request, prefix + "d5", ""));
		setD4(JSPUtil.getParameter(request, prefix + "d4", ""));
		setD7(JSPUtil.getParameter(request, prefix + "d7", ""));
		setD2Fd(JSPUtil.getParameter(request, prefix + "d2_fd", ""));
		setSheetPrefix(JSPUtil.getParameter(request, prefix + "sheet_prefix", ""));
		setD2(JSPUtil.getParameter(request, prefix + "d2", ""));
		setP2Fd(JSPUtil.getParameter(request, prefix + "p2_fd", ""));
		setEffOn(JSPUtil.getParameter(request, prefix + "eff_on", ""));
		setCopyTmlAgmtOfcCtyCd(JSPUtil.getParameter(request, prefix + "copy_tml_agmt_ofc_cty_cd", ""));
		setSameDgNoneR(JSPUtil.getParameter(request, prefix + "same_dg_none_r", ""));
		setP4Fd(JSPUtil.getParameter(request, prefix + "p4_fd", ""));
		setDcgoN3rdClssFlgFd(JSPUtil.getParameter(request, prefix + "dcgo_n3rd_clss_flg_fd", ""));
		setD9Fd(JSPUtil.getParameter(request, prefix + "d9_fd", ""));
		setSelectTab(JSPUtil.getParameter(request, prefix + "select_tab", ""));
		setDcgoN9thClssFlg(JSPUtil.getParameter(request, prefix + "dcgo_n9th_clss_flg", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setT4(JSPUtil.getParameter(request, prefix + "t4", ""));
		setGangHourRate(JSPUtil.getParameter(request, prefix + "gang_hour_rate", ""));
		setR7R(JSPUtil.getParameter(request, prefix + "r7_r", ""));
		setDcgoN7thClssFlgFd(JSPUtil.getParameter(request, prefix + "dcgo_n7th_clss_flg_fd", ""));
		setT2(JSPUtil.getParameter(request, prefix + "t2", ""));
		setR4R(JSPUtil.getParameter(request, prefix + "r4_r", ""));
		setDcgoN2ndClssFlg(JSPUtil.getParameter(request, prefix + "dcgo_n2nd_clss_flg", ""));
		setIpage(JSPUtil.getParameter(request, prefix + "ipage", ""));
		setDcgoN6thClssFlgR(JSPUtil.getParameter(request, prefix + "dcgo_n6th_clss_flg_r", ""));
		setF4R(JSPUtil.getParameter(request, prefix + "f4_r", ""));
		setS4Fd(JSPUtil.getParameter(request, prefix + "s4_fd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setF2Fd(JSPUtil.getParameter(request, prefix + "f2_fd", ""));
		setInputListVerifyFlg(JSPUtil.getParameter(request, prefix + "input_list_verify_flg", ""));
		setO4Fd(JSPUtil.getParameter(request, prefix + "o4_fd", ""));
		setO5Fd(JSPUtil.getParameter(request, prefix + "o5_fd", ""));
		setT4R(JSPUtil.getParameter(request, prefix + "t4_r", ""));
		setS4(JSPUtil.getParameter(request, prefix + "s4", ""));
		setSunFlgFd(JSPUtil.getParameter(request, prefix + "sun_flg_fd", ""));
		setS2(JSPUtil.getParameter(request, prefix + "s2", ""));
		setDgNoneFd(JSPUtil.getParameter(request, prefix + "dg_none_fd", ""));
		setD7Fd(JSPUtil.getParameter(request, prefix + "d7_fd", ""));
		setDcgoN9thClssFlgR(JSPUtil.getParameter(request, prefix + "dcgo_n9th_clss_flg_r", ""));
		setD5Fd(JSPUtil.getParameter(request, prefix + "d5_fd", ""));
		setLoopValue(JSPUtil.getParameter(request, prefix + "loop_value", ""));
		setC4(JSPUtil.getParameter(request, prefix + "c4", ""));
		setF5R(JSPUtil.getParameter(request, prefix + "f5_r", ""));
		setSameDgNone(JSPUtil.getParameter(request, prefix + "same_dg_none", ""));
		setP4R(JSPUtil.getParameter(request, prefix + "p4_r", ""));
		setC2(JSPUtil.getParameter(request, prefix + "c2", ""));
		setD2R(JSPUtil.getParameter(request, prefix + "d2_r", ""));
		setS2Fd(JSPUtil.getParameter(request, prefix + "s2_fd", ""));
		setR7(JSPUtil.getParameter(request, prefix + "r7", ""));
		setR8(JSPUtil.getParameter(request, prefix + "r8", ""));
		setR5R(JSPUtil.getParameter(request, prefix + "r5_r", ""));
		setR9(JSPUtil.getParameter(request, prefix + "r9", ""));
		setR2(JSPUtil.getParameter(request, prefix + "r2", ""));
		setR4(JSPUtil.getParameter(request, prefix + "r4", ""));
		setR5(JSPUtil.getParameter(request, prefix + "r5", ""));
		setTmlAgmtVolUtCd(JSPUtil.getParameter(request, prefix + "tml_agmt_vol_ut_cd", ""));
		setA5R(JSPUtil.getParameter(request, prefix + "a5_r", ""));
		setP4(JSPUtil.getParameter(request, prefix + "p4", ""));
		setDcgoN5thClssFlgR(JSPUtil.getParameter(request, prefix + "dcgo_n5th_clss_flg_r", ""));
		setP2(JSPUtil.getParameter(request, prefix + "p2", ""));
		setDcgoN9thClssFlgFd(JSPUtil.getParameter(request, prefix + "dcgo_n9th_clss_flg_fd", ""));
		setC4R(JSPUtil.getParameter(request, prefix + "c4_r", ""));
		setD4R(JSPUtil.getParameter(request, prefix + "d4_r", ""));
		setDcgoN1stClssFlgR(JSPUtil.getParameter(request, prefix + "dcgo_n1st_clss_flg_r", ""));
		setT4Fd(JSPUtil.getParameter(request, prefix + "t4_fd", ""));
		setDcgoN8thClssFlgR(JSPUtil.getParameter(request, prefix + "dcgo_n8th_clss_flg_r", ""));
		setAgmthdrcreadjflg(JSPUtil.getParameter(request, prefix + "agmthdrcreadjflg", ""));
		setR7Fd(JSPUtil.getParameter(request, prefix + "r7_fd", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setDcgoN5thClssFlgFd(JSPUtil.getParameter(request, prefix + "dcgo_n5th_clss_flg_fd", ""));
		setTonRate(JSPUtil.getParameter(request, prefix + "ton_rate", ""));
		setAccmDtlSeq(JSPUtil.getParameter(request, prefix + "accm_dtl_seq", ""));
		setCommandH(JSPUtil.getParameter(request, prefix + "command_h", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setT2R(JSPUtil.getParameter(request, prefix + "t2_r", ""));
		setThrpflg(JSPUtil.getParameter(request, prefix + "thrpflg", ""));
		setD5R(JSPUtil.getParameter(request, prefix + "d5_r", ""));
		setO2Fd(JSPUtil.getParameter(request, prefix + "o2_fd", ""));
		setP2R(JSPUtil.getParameter(request, prefix + "p2_r", ""));
		setVndrSeqHidden(JSPUtil.getParameter(request, prefix + "vndr_seq_hidden", ""));
		setDcgoN1stClssFlgFd(JSPUtil.getParameter(request, prefix + "dcgo_n1st_clss_flg_fd", ""));
		setR8R(JSPUtil.getParameter(request, prefix + "r8_r", ""));
		setC2R(JSPUtil.getParameter(request, prefix + "c2_r", ""));
		setSepDgNoneR(JSPUtil.getParameter(request, prefix + "sep_dg_none_r", ""));
		setDxR(JSPUtil.getParameter(request, prefix + "dx_r", ""));
		setDcgoN8thClssFlgFd(JSPUtil.getParameter(request, prefix + "dcgo_n8th_clss_flg_fd", ""));
		setRegagmthdrflg(JSPUtil.getParameter(request, prefix + "regagmthdrflg", ""));
		setD7R(JSPUtil.getParameter(request, prefix + "d7_r", ""));
		setInitformdtlflg(JSPUtil.getParameter(request, prefix + "initformdtlflg", ""));
		setA2(JSPUtil.getParameter(request, prefix + "a2", ""));
		setDcgoN3rdClssFlgR(JSPUtil.getParameter(request, prefix + "dcgo_n3rd_clss_flg_r", ""));
		setA2R(JSPUtil.getParameter(request, prefix + "a2_r", ""));
		setA4(JSPUtil.getParameter(request, prefix + "a4", ""));
		setA5(JSPUtil.getParameter(request, prefix + "a5", ""));
		setD8Fd(JSPUtil.getParameter(request, prefix + "d8_fd", ""));
		setDcgoN6thClssFlgFd(JSPUtil.getParameter(request, prefix + "dcgo_n6th_clss_flg_fd", ""));
		setIsValidYdCd(JSPUtil.getParameter(request, prefix + "is_valid_yd_cd", ""));
		setO2(JSPUtil.getParameter(request, prefix + "o2", ""));
		setO4(JSPUtil.getParameter(request, prefix + "o4", ""));
		setDcgoN4thClssFlg(JSPUtil.getParameter(request, prefix + "dcgo_n4th_clss_flg", ""));
		setR9R(JSPUtil.getParameter(request, prefix + "r9_r", ""));
		setO5(JSPUtil.getParameter(request, prefix + "o5", ""));
		setA4R(JSPUtil.getParameter(request, prefix + "a4_r", ""));
		setDwR(JSPUtil.getParameter(request, prefix + "dw_r", ""));
		setC4Fd(JSPUtil.getParameter(request, prefix + "c4_fd", ""));
		setD4Fd(JSPUtil.getParameter(request, prefix + "d4_fd", ""));
		setD8R(JSPUtil.getParameter(request, prefix + "d8_r", ""));
		setSepDgNone(JSPUtil.getParameter(request, prefix + "sep_dg_none", ""));
		setA4Fd(JSPUtil.getParameter(request, prefix + "a4_fd", ""));
		setSatFlgFd(JSPUtil.getParameter(request, prefix + "sat_flg_fd", ""));
		setSameDgFd(JSPUtil.getParameter(request, prefix + "same_dg_fd", ""));
		setTmlAgmtStsCd(JSPUtil.getParameter(request, prefix + "tml_agmt_sts_cd", ""));
		setYdCdName(JSPUtil.getParameter(request, prefix + "yd_cd_name", ""));
		setR8Fd(JSPUtil.getParameter(request, prefix + "r8_fd", ""));
		setD9R(JSPUtil.getParameter(request, prefix + "d9_r", ""));
		setRegagmtflg(JSPUtil.getParameter(request, prefix + "regagmtflg", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setVndrSeqDeltflg(JSPUtil.getParameter(request, prefix + "vndr_seq_deltflg", ""));
		setSameDg(JSPUtil.getParameter(request, prefix + "same_dg", ""));
		setRowNum(JSPUtil.getParameter(request, prefix + "row_num", ""));
		setR4Fd(JSPUtil.getParameter(request, prefix + "r4_fd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setTsRt(JSPUtil.getParameter(request, prefix + "ts_rt", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setDcgoNonClssFlgFd(JSPUtil.getParameter(request, prefix + "dcgo_non_clss_flg_fd", ""));
		setDwFd(JSPUtil.getParameter(request, prefix + "dw_fd", ""));
		setTmlAgmtOfcNo(JSPUtil.getParameter(request, prefix + "tml_agmt_ofc_no", ""));
		setDgNone(JSPUtil.getParameter(request, prefix + "dg_none", ""));
		setDcgoN2ndClssFlgFd(JSPUtil.getParameter(request, prefix + "dcgo_n2nd_clss_flg_fd", ""));
		setTmlAgmtTpCd(JSPUtil.getParameter(request, prefix + "tml_agmt_tp_cd", ""));
		setDcgoNonClssFlgR(JSPUtil.getParameter(request, prefix + "dcgo_non_clss_flg_r", ""));
		setDcgoN1stClssFlg(JSPUtil.getParameter(request, prefix + "dcgo_n1st_clss_flg", ""));
		setR2Fd(JSPUtil.getParameter(request, prefix + "r2_fd", ""));
		setCreOfcCd2(JSPUtil.getParameter(request, prefix + "cre_ofc_cd2", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setInquiryflg(JSPUtil.getParameter(request, prefix + "inquiryflg", ""));
		setDcgoN3rdClssFlg(JSPUtil.getParameter(request, prefix + "dcgo_n3rd_clss_flg", ""));
		setAgmtConfirmFlg(JSPUtil.getParameter(request, prefix + "agmt_confirm_flg", ""));
		setFileimportflg(JSPUtil.getParameter(request, prefix + "fileimportflg", ""));
		setYdCdHidden(JSPUtil.getParameter(request, prefix + "yd_cd_hidden", ""));
		setF5Fd(JSPUtil.getParameter(request, prefix + "f5_fd", ""));
		setHolFlgFd(JSPUtil.getParameter(request, prefix + "hol_flg_fd", ""));
		setF4Fd(JSPUtil.getParameter(request, prefix + "f4_fd", ""));
		setBoxRate(JSPUtil.getParameter(request, prefix + "box_rate", ""));
		setT2Fd(JSPUtil.getParameter(request, prefix + "t2_fd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TesAgreementManageCommonVO[]
	 */
	public TesAgreementManageCommonVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TesAgreementManageCommonVO[]
	 */
	public TesAgreementManageCommonVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TesAgreementManageCommonVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] accmSeq = (JSPUtil.getParameter(request, prefix	+ "accm_seq", length));
			String[] f2R = (JSPUtil.getParameter(request, prefix	+ "f2_r", length));
			String[] s2R = (JSPUtil.getParameter(request, prefix	+ "s2_r", length));
			String[] r2R = (JSPUtil.getParameter(request, prefix	+ "r2_r", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] moveRate = (JSPUtil.getParameter(request, prefix	+ "move_rate", length));
			String[] laneCdstring = (JSPUtil.getParameter(request, prefix	+ "lane_cdstring", length));
			String[] a2Fd = (JSPUtil.getParameter(request, prefix	+ "a2_fd", length));
			String[] dcgoN7thClssFlgR = (JSPUtil.getParameter(request, prefix	+ "dcgo_n7th_clss_flg_r", length));
			String[] sepDgNoneFd = (JSPUtil.getParameter(request, prefix	+ "sep_dg_none_fd", length));
			String[] dcgoN2ndClssFlgR = (JSPUtil.getParameter(request, prefix	+ "dcgo_n2nd_clss_flg_r", length));
			String[] dcgoNonClssFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_non_clss_flg", length));
			String[] dxFd = (JSPUtil.getParameter(request, prefix	+ "dx_fd", length));
			String[] o2R = (JSPUtil.getParameter(request, prefix	+ "o2_r", length));
			String[] r9Fd = (JSPUtil.getParameter(request, prefix	+ "r9_fd", length));
			String[] dcgoN5thClssFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_n5th_clss_flg", length));
			String[] r5Fd = (JSPUtil.getParameter(request, prefix	+ "r5_fd", length));
			String[] ydCdDeltflg = (JSPUtil.getParameter(request, prefix	+ "yd_cd_deltflg", length));
			String[] effAgmt = (JSPUtil.getParameter(request, prefix	+ "eff_agmt", length));
			String[] s4R = (JSPUtil.getParameter(request, prefix	+ "s4_r", length));
			String[] dw = (JSPUtil.getParameter(request, prefix	+ "dw", length));
			String[] dx = (JSPUtil.getParameter(request, prefix	+ "dx", length));
			String[] sameDgNoneFd = (JSPUtil.getParameter(request, prefix	+ "same_dg_none_fd", length));
			String[] vfsarray = (JSPUtil.getParameter(request, prefix	+ "vfsarray", length));
			String[] dcgoN4thClssFlgR = (JSPUtil.getParameter(request, prefix	+ "dcgo_n4th_clss_flg_r", length));
			String[] o5R = (JSPUtil.getParameter(request, prefix	+ "o5_r", length));
			String[] dcgoN8thClssFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_n8th_clss_flg", length));
			String[] teuRate = (JSPUtil.getParameter(request, prefix	+ "teu_rate", length));
			String[] f2 = (JSPUtil.getParameter(request, prefix	+ "f2", length));
			String[] f5 = (JSPUtil.getParameter(request, prefix	+ "f5", length));
			String[] f4 = (JSPUtil.getParameter(request, prefix	+ "f4", length));
			String[] c2Fd = (JSPUtil.getParameter(request, prefix	+ "c2_fd", length));
			String[] sameDgR = (JSPUtil.getParameter(request, prefix	+ "same_dg_r", length));
			String[] dcgoN7thClssFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_n7th_clss_flg", length));
			String[] o4R = (JSPUtil.getParameter(request, prefix	+ "o4_r", length));
			String[] dcgoN4thClssFlgFd = (JSPUtil.getParameter(request, prefix	+ "dcgo_n4th_clss_flg_fd", length));
			String[] isValidVndrSeq = (JSPUtil.getParameter(request, prefix	+ "is_valid_vndr_seq", length));
			String[] amendCd = (JSPUtil.getParameter(request, prefix	+ "amend_cd", length));
			String[] dgNoneR = (JSPUtil.getParameter(request, prefix	+ "dg_none_r", length));
			String[] wkdyFlgFd = (JSPUtil.getParameter(request, prefix	+ "wkdy_flg_fd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] lgsCostCd = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_cd", length));
			String[] dcgoN6thClssFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_n6th_clss_flg", length));
			String[] a5Fd = (JSPUtil.getParameter(request, prefix	+ "a5_fd", length));
			String[] accmCostSeq = (JSPUtil.getParameter(request, prefix	+ "accm_cost_seq", length));
			String[] fCmd = (JSPUtil.getParameter(request, prefix	+ "f_cmd", length));
			String[] d9 = (JSPUtil.getParameter(request, prefix	+ "d9", length));
			String[] d8 = (JSPUtil.getParameter(request, prefix	+ "d8", length));
			String[] d5 = (JSPUtil.getParameter(request, prefix	+ "d5", length));
			String[] d4 = (JSPUtil.getParameter(request, prefix	+ "d4", length));
			String[] d7 = (JSPUtil.getParameter(request, prefix	+ "d7", length));
			String[] d2Fd = (JSPUtil.getParameter(request, prefix	+ "d2_fd", length));
			String[] sheetPrefix = (JSPUtil.getParameter(request, prefix	+ "sheet_prefix", length));
			String[] d2 = (JSPUtil.getParameter(request, prefix	+ "d2", length));
			String[] p2Fd = (JSPUtil.getParameter(request, prefix	+ "p2_fd", length));
			String[] effOn = (JSPUtil.getParameter(request, prefix	+ "eff_on", length));
			String[] copyTmlAgmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "copy_tml_agmt_ofc_cty_cd", length));
			String[] sameDgNoneR = (JSPUtil.getParameter(request, prefix	+ "same_dg_none_r", length));
			String[] p4Fd = (JSPUtil.getParameter(request, prefix	+ "p4_fd", length));
			String[] dcgoN3rdClssFlgFd = (JSPUtil.getParameter(request, prefix	+ "dcgo_n3rd_clss_flg_fd", length));
			String[] d9Fd = (JSPUtil.getParameter(request, prefix	+ "d9_fd", length));
			String[] selectTab = (JSPUtil.getParameter(request, prefix	+ "select_tab", length));
			String[] dcgoN9thClssFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_n9th_clss_flg", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] t4 = (JSPUtil.getParameter(request, prefix	+ "t4", length));
			String[] gangHourRate = (JSPUtil.getParameter(request, prefix	+ "gang_hour_rate", length));
			String[] r7R = (JSPUtil.getParameter(request, prefix	+ "r7_r", length));
			String[] dcgoN7thClssFlgFd = (JSPUtil.getParameter(request, prefix	+ "dcgo_n7th_clss_flg_fd", length));
			String[] t2 = (JSPUtil.getParameter(request, prefix	+ "t2", length));
			String[] r4R = (JSPUtil.getParameter(request, prefix	+ "r4_r", length));
			String[] dcgoN2ndClssFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_n2nd_clss_flg", length));
			String[] ipage = (JSPUtil.getParameter(request, prefix	+ "ipage", length));
			String[] dcgoN6thClssFlgR = (JSPUtil.getParameter(request, prefix	+ "dcgo_n6th_clss_flg_r", length));
			String[] f4R = (JSPUtil.getParameter(request, prefix	+ "f4_r", length));
			String[] s4Fd = (JSPUtil.getParameter(request, prefix	+ "s4_fd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] f2Fd = (JSPUtil.getParameter(request, prefix	+ "f2_fd", length));
			String[] inputListVerifyFlg = (JSPUtil.getParameter(request, prefix	+ "input_list_verify_flg", length));
			String[] o4Fd = (JSPUtil.getParameter(request, prefix	+ "o4_fd", length));
			String[] o5Fd = (JSPUtil.getParameter(request, prefix	+ "o5_fd", length));
			String[] t4R = (JSPUtil.getParameter(request, prefix	+ "t4_r", length));
			String[] s4 = (JSPUtil.getParameter(request, prefix	+ "s4", length));
			String[] sunFlgFd = (JSPUtil.getParameter(request, prefix	+ "sun_flg_fd", length));
			String[] s2 = (JSPUtil.getParameter(request, prefix	+ "s2", length));
			String[] dgNoneFd = (JSPUtil.getParameter(request, prefix	+ "dg_none_fd", length));
			String[] d7Fd = (JSPUtil.getParameter(request, prefix	+ "d7_fd", length));
			String[] dcgoN9thClssFlgR = (JSPUtil.getParameter(request, prefix	+ "dcgo_n9th_clss_flg_r", length));
			String[] d5Fd = (JSPUtil.getParameter(request, prefix	+ "d5_fd", length));
			String[] loopValue = (JSPUtil.getParameter(request, prefix	+ "loop_value", length));
			String[] c4 = (JSPUtil.getParameter(request, prefix	+ "c4", length));
			String[] f5R = (JSPUtil.getParameter(request, prefix	+ "f5_r", length));
			String[] sameDgNone = (JSPUtil.getParameter(request, prefix	+ "same_dg_none", length));
			String[] p4R = (JSPUtil.getParameter(request, prefix	+ "p4_r", length));
			String[] c2 = (JSPUtil.getParameter(request, prefix	+ "c2", length));
			String[] d2R = (JSPUtil.getParameter(request, prefix	+ "d2_r", length));
			String[] s2Fd = (JSPUtil.getParameter(request, prefix	+ "s2_fd", length));
			String[] r7 = (JSPUtil.getParameter(request, prefix	+ "r7", length));
			String[] r8 = (JSPUtil.getParameter(request, prefix	+ "r8", length));
			String[] r5R = (JSPUtil.getParameter(request, prefix	+ "r5_r", length));
			String[] r9 = (JSPUtil.getParameter(request, prefix	+ "r9", length));
			String[] r2 = (JSPUtil.getParameter(request, prefix	+ "r2", length));
			String[] r4 = (JSPUtil.getParameter(request, prefix	+ "r4", length));
			String[] r5 = (JSPUtil.getParameter(request, prefix	+ "r5", length));
			String[] tmlAgmtVolUtCd = (JSPUtil.getParameter(request, prefix	+ "tml_agmt_vol_ut_cd", length));
			String[] a5R = (JSPUtil.getParameter(request, prefix	+ "a5_r", length));
			String[] p4 = (JSPUtil.getParameter(request, prefix	+ "p4", length));
			String[] dcgoN5thClssFlgR = (JSPUtil.getParameter(request, prefix	+ "dcgo_n5th_clss_flg_r", length));
			String[] p2 = (JSPUtil.getParameter(request, prefix	+ "p2", length));
			String[] dcgoN9thClssFlgFd = (JSPUtil.getParameter(request, prefix	+ "dcgo_n9th_clss_flg_fd", length));
			String[] c4R = (JSPUtil.getParameter(request, prefix	+ "c4_r", length));
			String[] d4R = (JSPUtil.getParameter(request, prefix	+ "d4_r", length));
			String[] dcgoN1stClssFlgR = (JSPUtil.getParameter(request, prefix	+ "dcgo_n1st_clss_flg_r", length));
			String[] t4Fd = (JSPUtil.getParameter(request, prefix	+ "t4_fd", length));
			String[] dcgoN8thClssFlgR = (JSPUtil.getParameter(request, prefix	+ "dcgo_n8th_clss_flg_r", length));
			String[] agmthdrcreadjflg = (JSPUtil.getParameter(request, prefix	+ "agmthdrcreadjflg", length));
			String[] r7Fd = (JSPUtil.getParameter(request, prefix	+ "r7_fd", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] dcgoN5thClssFlgFd = (JSPUtil.getParameter(request, prefix	+ "dcgo_n5th_clss_flg_fd", length));
			String[] tonRate = (JSPUtil.getParameter(request, prefix	+ "ton_rate", length));
			String[] accmDtlSeq = (JSPUtil.getParameter(request, prefix	+ "accm_dtl_seq", length));
			String[] commandH = (JSPUtil.getParameter(request, prefix	+ "command_h", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] t2R = (JSPUtil.getParameter(request, prefix	+ "t2_r", length));
			String[] thrpflg = (JSPUtil.getParameter(request, prefix	+ "thrpflg", length));
			String[] d5R = (JSPUtil.getParameter(request, prefix	+ "d5_r", length));
			String[] o2Fd = (JSPUtil.getParameter(request, prefix	+ "o2_fd", length));
			String[] p2R = (JSPUtil.getParameter(request, prefix	+ "p2_r", length));
			String[] vndrSeqHidden = (JSPUtil.getParameter(request, prefix	+ "vndr_seq_hidden", length));
			String[] dcgoN1stClssFlgFd = (JSPUtil.getParameter(request, prefix	+ "dcgo_n1st_clss_flg_fd", length));
			String[] r8R = (JSPUtil.getParameter(request, prefix	+ "r8_r", length));
			String[] c2R = (JSPUtil.getParameter(request, prefix	+ "c2_r", length));
			String[] sepDgNoneR = (JSPUtil.getParameter(request, prefix	+ "sep_dg_none_r", length));
			String[] dxR = (JSPUtil.getParameter(request, prefix	+ "dx_r", length));
			String[] dcgoN8thClssFlgFd = (JSPUtil.getParameter(request, prefix	+ "dcgo_n8th_clss_flg_fd", length));
			String[] regagmthdrflg = (JSPUtil.getParameter(request, prefix	+ "regagmthdrflg", length));
			String[] d7R = (JSPUtil.getParameter(request, prefix	+ "d7_r", length));
			String[] initformdtlflg = (JSPUtil.getParameter(request, prefix	+ "initformdtlflg", length));
			String[] a2 = (JSPUtil.getParameter(request, prefix	+ "a2", length));
			String[] dcgoN3rdClssFlgR = (JSPUtil.getParameter(request, prefix	+ "dcgo_n3rd_clss_flg_r", length));
			String[] a2R = (JSPUtil.getParameter(request, prefix	+ "a2_r", length));
			String[] a4 = (JSPUtil.getParameter(request, prefix	+ "a4", length));
			String[] a5 = (JSPUtil.getParameter(request, prefix	+ "a5", length));
			String[] d8Fd = (JSPUtil.getParameter(request, prefix	+ "d8_fd", length));
			String[] dcgoN6thClssFlgFd = (JSPUtil.getParameter(request, prefix	+ "dcgo_n6th_clss_flg_fd", length));
			String[] isValidYdCd = (JSPUtil.getParameter(request, prefix	+ "is_valid_yd_cd", length));
			String[] o2 = (JSPUtil.getParameter(request, prefix	+ "o2", length));
			String[] o4 = (JSPUtil.getParameter(request, prefix	+ "o4", length));
			String[] dcgoN4thClssFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_n4th_clss_flg", length));
			String[] r9R = (JSPUtil.getParameter(request, prefix	+ "r9_r", length));
			String[] o5 = (JSPUtil.getParameter(request, prefix	+ "o5", length));
			String[] a4R = (JSPUtil.getParameter(request, prefix	+ "a4_r", length));
			String[] dwR = (JSPUtil.getParameter(request, prefix	+ "dw_r", length));
			String[] c4Fd = (JSPUtil.getParameter(request, prefix	+ "c4_fd", length));
			String[] d4Fd = (JSPUtil.getParameter(request, prefix	+ "d4_fd", length));
			String[] d8R = (JSPUtil.getParameter(request, prefix	+ "d8_r", length));
			String[] sepDgNone = (JSPUtil.getParameter(request, prefix	+ "sep_dg_none", length));
			String[] a4Fd = (JSPUtil.getParameter(request, prefix	+ "a4_fd", length));
			String[] satFlgFd = (JSPUtil.getParameter(request, prefix	+ "sat_flg_fd", length));
			String[] sameDgFd = (JSPUtil.getParameter(request, prefix	+ "same_dg_fd", length));
			String[] tmlAgmtStsCd = (JSPUtil.getParameter(request, prefix	+ "tml_agmt_sts_cd", length));
			String[] ydCdName = (JSPUtil.getParameter(request, prefix	+ "yd_cd_name", length));
			String[] r8Fd = (JSPUtil.getParameter(request, prefix	+ "r8_fd", length));
			String[] d9R = (JSPUtil.getParameter(request, prefix	+ "d9_r", length));
			String[] regagmtflg = (JSPUtil.getParameter(request, prefix	+ "regagmtflg", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] vndrSeqDeltflg = (JSPUtil.getParameter(request, prefix	+ "vndr_seq_deltflg", length));
			String[] sameDg = (JSPUtil.getParameter(request, prefix	+ "same_dg", length));
			String[] rowNum = (JSPUtil.getParameter(request, prefix	+ "row_num", length));
			String[] r4Fd = (JSPUtil.getParameter(request, prefix	+ "r4_fd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] tsRt = (JSPUtil.getParameter(request, prefix	+ "ts_rt", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] dcgoNonClssFlgFd = (JSPUtil.getParameter(request, prefix	+ "dcgo_non_clss_flg_fd", length));
			String[] dwFd = (JSPUtil.getParameter(request, prefix	+ "dw_fd", length));
			String[] tmlAgmtOfcNo = (JSPUtil.getParameter(request, prefix	+ "tml_agmt_ofc_no", length));
			String[] dgNone = (JSPUtil.getParameter(request, prefix	+ "dg_none", length));
			String[] dcgoN2ndClssFlgFd = (JSPUtil.getParameter(request, prefix	+ "dcgo_n2nd_clss_flg_fd", length));
			String[] tmlAgmtTpCd = (JSPUtil.getParameter(request, prefix	+ "tml_agmt_tp_cd", length));
			String[] dcgoNonClssFlgR = (JSPUtil.getParameter(request, prefix	+ "dcgo_non_clss_flg_r", length));
			String[] dcgoN1stClssFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_n1st_clss_flg", length));
			String[] r2Fd = (JSPUtil.getParameter(request, prefix	+ "r2_fd", length));
			String[] creOfcCd2 = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd2", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] inquiryflg = (JSPUtil.getParameter(request, prefix	+ "inquiryflg", length));
			String[] dcgoN3rdClssFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_n3rd_clss_flg", length));
			String[] agmtConfirmFlg = (JSPUtil.getParameter(request, prefix	+ "agmt_confirm_flg", length));
			String[] fileimportflg = (JSPUtil.getParameter(request, prefix	+ "fileimportflg", length));
			String[] ydCdHidden = (JSPUtil.getParameter(request, prefix	+ "yd_cd_hidden", length));
			String[] f5Fd = (JSPUtil.getParameter(request, prefix	+ "f5_fd", length));
			String[] holFlgFd = (JSPUtil.getParameter(request, prefix	+ "hol_flg_fd", length));
			String[] f4Fd = (JSPUtil.getParameter(request, prefix	+ "f4_fd", length));
			String[] boxRate = (JSPUtil.getParameter(request, prefix	+ "box_rate", length));
			String[] t2Fd = (JSPUtil.getParameter(request, prefix	+ "t2_fd", length));
			
			for (int i = 0; i < length; i++) {
				model = new TesAgreementManageCommonVO();
				if (accmSeq[i] != null)
					model.setAccmSeq(accmSeq[i]);
				if (f2R[i] != null)
					model.setF2R(f2R[i]);
				if (s2R[i] != null)
					model.setS2R(s2R[i]);
				if (r2R[i] != null)
					model.setR2R(r2R[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (moveRate[i] != null)
					model.setMoveRate(moveRate[i]);
				if (laneCdstring[i] != null)
					model.setLaneCdstring(laneCdstring[i]);
				if (a2Fd[i] != null)
					model.setA2Fd(a2Fd[i]);
				if (dcgoN7thClssFlgR[i] != null)
					model.setDcgoN7thClssFlgR(dcgoN7thClssFlgR[i]);
				if (sepDgNoneFd[i] != null)
					model.setSepDgNoneFd(sepDgNoneFd[i]);
				if (dcgoN2ndClssFlgR[i] != null)
					model.setDcgoN2ndClssFlgR(dcgoN2ndClssFlgR[i]);
				if (dcgoNonClssFlg[i] != null)
					model.setDcgoNonClssFlg(dcgoNonClssFlg[i]);
				if (dxFd[i] != null)
					model.setDxFd(dxFd[i]);
				if (o2R[i] != null)
					model.setO2R(o2R[i]);
				if (r9Fd[i] != null)
					model.setR9Fd(r9Fd[i]);
				if (dcgoN5thClssFlg[i] != null)
					model.setDcgoN5thClssFlg(dcgoN5thClssFlg[i]);
				if (r5Fd[i] != null)
					model.setR5Fd(r5Fd[i]);
				if (ydCdDeltflg[i] != null)
					model.setYdCdDeltflg(ydCdDeltflg[i]);
				if (effAgmt[i] != null)
					model.setEffAgmt(effAgmt[i]);
				if (s4R[i] != null)
					model.setS4R(s4R[i]);
				if (dw[i] != null)
					model.setDw(dw[i]);
				if (dx[i] != null)
					model.setDx(dx[i]);
				if (sameDgNoneFd[i] != null)
					model.setSameDgNoneFd(sameDgNoneFd[i]);
				if (vfsarray[i] != null)
					model.setVfsarray(vfsarray[i]);
				if (dcgoN4thClssFlgR[i] != null)
					model.setDcgoN4thClssFlgR(dcgoN4thClssFlgR[i]);
				if (o5R[i] != null)
					model.setO5R(o5R[i]);
				if (dcgoN8thClssFlg[i] != null)
					model.setDcgoN8thClssFlg(dcgoN8thClssFlg[i]);
				if (teuRate[i] != null)
					model.setTeuRate(teuRate[i]);
				if (f2[i] != null)
					model.setF2(f2[i]);
				if (f5[i] != null)
					model.setF5(f5[i]);
				if (f4[i] != null)
					model.setF4(f4[i]);
				if (c2Fd[i] != null)
					model.setC2Fd(c2Fd[i]);
				if (sameDgR[i] != null)
					model.setSameDgR(sameDgR[i]);
				if (dcgoN7thClssFlg[i] != null)
					model.setDcgoN7thClssFlg(dcgoN7thClssFlg[i]);
				if (o4R[i] != null)
					model.setO4R(o4R[i]);
				if (dcgoN4thClssFlgFd[i] != null)
					model.setDcgoN4thClssFlgFd(dcgoN4thClssFlgFd[i]);
				if (isValidVndrSeq[i] != null)
					model.setIsValidVndrSeq(isValidVndrSeq[i]);
				if (amendCd[i] != null)
					model.setAmendCd(amendCd[i]);
				if (dgNoneR[i] != null)
					model.setDgNoneR(dgNoneR[i]);
				if (wkdyFlgFd[i] != null)
					model.setWkdyFlgFd(wkdyFlgFd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (lgsCostCd[i] != null)
					model.setLgsCostCd(lgsCostCd[i]);
				if (dcgoN6thClssFlg[i] != null)
					model.setDcgoN6thClssFlg(dcgoN6thClssFlg[i]);
				if (a5Fd[i] != null)
					model.setA5Fd(a5Fd[i]);
				if (accmCostSeq[i] != null)
					model.setAccmCostSeq(accmCostSeq[i]);
				if (fCmd[i] != null)
					model.setFCmd(fCmd[i]);
				if (d9[i] != null)
					model.setD9(d9[i]);
				if (d8[i] != null)
					model.setD8(d8[i]);
				if (d5[i] != null)
					model.setD5(d5[i]);
				if (d4[i] != null)
					model.setD4(d4[i]);
				if (d7[i] != null)
					model.setD7(d7[i]);
				if (d2Fd[i] != null)
					model.setD2Fd(d2Fd[i]);
				if (sheetPrefix[i] != null)
					model.setSheetPrefix(sheetPrefix[i]);
				if (d2[i] != null)
					model.setD2(d2[i]);
				if (p2Fd[i] != null)
					model.setP2Fd(p2Fd[i]);
				if (effOn[i] != null)
					model.setEffOn(effOn[i]);
				if (copyTmlAgmtOfcCtyCd[i] != null)
					model.setCopyTmlAgmtOfcCtyCd(copyTmlAgmtOfcCtyCd[i]);
				if (sameDgNoneR[i] != null)
					model.setSameDgNoneR(sameDgNoneR[i]);
				if (p4Fd[i] != null)
					model.setP4Fd(p4Fd[i]);
				if (dcgoN3rdClssFlgFd[i] != null)
					model.setDcgoN3rdClssFlgFd(dcgoN3rdClssFlgFd[i]);
				if (d9Fd[i] != null)
					model.setD9Fd(d9Fd[i]);
				if (selectTab[i] != null)
					model.setSelectTab(selectTab[i]);
				if (dcgoN9thClssFlg[i] != null)
					model.setDcgoN9thClssFlg(dcgoN9thClssFlg[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (t4[i] != null)
					model.setT4(t4[i]);
				if (gangHourRate[i] != null)
					model.setGangHourRate(gangHourRate[i]);
				if (r7R[i] != null)
					model.setR7R(r7R[i]);
				if (dcgoN7thClssFlgFd[i] != null)
					model.setDcgoN7thClssFlgFd(dcgoN7thClssFlgFd[i]);
				if (t2[i] != null)
					model.setT2(t2[i]);
				if (r4R[i] != null)
					model.setR4R(r4R[i]);
				if (dcgoN2ndClssFlg[i] != null)
					model.setDcgoN2ndClssFlg(dcgoN2ndClssFlg[i]);
				if (ipage[i] != null)
					model.setIpage(ipage[i]);
				if (dcgoN6thClssFlgR[i] != null)
					model.setDcgoN6thClssFlgR(dcgoN6thClssFlgR[i]);
				if (f4R[i] != null)
					model.setF4R(f4R[i]);
				if (s4Fd[i] != null)
					model.setS4Fd(s4Fd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (f2Fd[i] != null)
					model.setF2Fd(f2Fd[i]);
				if (inputListVerifyFlg[i] != null)
					model.setInputListVerifyFlg(inputListVerifyFlg[i]);
				if (o4Fd[i] != null)
					model.setO4Fd(o4Fd[i]);
				if (o5Fd[i] != null)
					model.setO5Fd(o5Fd[i]);
				if (t4R[i] != null)
					model.setT4R(t4R[i]);
				if (s4[i] != null)
					model.setS4(s4[i]);
				if (sunFlgFd[i] != null)
					model.setSunFlgFd(sunFlgFd[i]);
				if (s2[i] != null)
					model.setS2(s2[i]);
				if (dgNoneFd[i] != null)
					model.setDgNoneFd(dgNoneFd[i]);
				if (d7Fd[i] != null)
					model.setD7Fd(d7Fd[i]);
				if (dcgoN9thClssFlgR[i] != null)
					model.setDcgoN9thClssFlgR(dcgoN9thClssFlgR[i]);
				if (d5Fd[i] != null)
					model.setD5Fd(d5Fd[i]);
				if (loopValue[i] != null)
					model.setLoopValue(loopValue[i]);
				if (c4[i] != null)
					model.setC4(c4[i]);
				if (f5R[i] != null)
					model.setF5R(f5R[i]);
				if (sameDgNone[i] != null)
					model.setSameDgNone(sameDgNone[i]);
				if (p4R[i] != null)
					model.setP4R(p4R[i]);
				if (c2[i] != null)
					model.setC2(c2[i]);
				if (d2R[i] != null)
					model.setD2R(d2R[i]);
				if (s2Fd[i] != null)
					model.setS2Fd(s2Fd[i]);
				if (r7[i] != null)
					model.setR7(r7[i]);
				if (r8[i] != null)
					model.setR8(r8[i]);
				if (r5R[i] != null)
					model.setR5R(r5R[i]);
				if (r9[i] != null)
					model.setR9(r9[i]);
				if (r2[i] != null)
					model.setR2(r2[i]);
				if (r4[i] != null)
					model.setR4(r4[i]);
				if (r5[i] != null)
					model.setR5(r5[i]);
				if (tmlAgmtVolUtCd[i] != null)
					model.setTmlAgmtVolUtCd(tmlAgmtVolUtCd[i]);
				if (a5R[i] != null)
					model.setA5R(a5R[i]);
				if (p4[i] != null)
					model.setP4(p4[i]);
				if (dcgoN5thClssFlgR[i] != null)
					model.setDcgoN5thClssFlgR(dcgoN5thClssFlgR[i]);
				if (p2[i] != null)
					model.setP2(p2[i]);
				if (dcgoN9thClssFlgFd[i] != null)
					model.setDcgoN9thClssFlgFd(dcgoN9thClssFlgFd[i]);
				if (c4R[i] != null)
					model.setC4R(c4R[i]);
				if (d4R[i] != null)
					model.setD4R(d4R[i]);
				if (dcgoN1stClssFlgR[i] != null)
					model.setDcgoN1stClssFlgR(dcgoN1stClssFlgR[i]);
				if (t4Fd[i] != null)
					model.setT4Fd(t4Fd[i]);
				if (dcgoN8thClssFlgR[i] != null)
					model.setDcgoN8thClssFlgR(dcgoN8thClssFlgR[i]);
				if (agmthdrcreadjflg[i] != null)
					model.setAgmthdrcreadjflg(agmthdrcreadjflg[i]);
				if (r7Fd[i] != null)
					model.setR7Fd(r7Fd[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (dcgoN5thClssFlgFd[i] != null)
					model.setDcgoN5thClssFlgFd(dcgoN5thClssFlgFd[i]);
				if (tonRate[i] != null)
					model.setTonRate(tonRate[i]);
				if (accmDtlSeq[i] != null)
					model.setAccmDtlSeq(accmDtlSeq[i]);
				if (commandH[i] != null)
					model.setCommandH(commandH[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (t2R[i] != null)
					model.setT2R(t2R[i]);
				if (thrpflg[i] != null)
					model.setThrpflg(thrpflg[i]);
				if (d5R[i] != null)
					model.setD5R(d5R[i]);
				if (o2Fd[i] != null)
					model.setO2Fd(o2Fd[i]);
				if (p2R[i] != null)
					model.setP2R(p2R[i]);
				if (vndrSeqHidden[i] != null)
					model.setVndrSeqHidden(vndrSeqHidden[i]);
				if (dcgoN1stClssFlgFd[i] != null)
					model.setDcgoN1stClssFlgFd(dcgoN1stClssFlgFd[i]);
				if (r8R[i] != null)
					model.setR8R(r8R[i]);
				if (c2R[i] != null)
					model.setC2R(c2R[i]);
				if (sepDgNoneR[i] != null)
					model.setSepDgNoneR(sepDgNoneR[i]);
				if (dxR[i] != null)
					model.setDxR(dxR[i]);
				if (dcgoN8thClssFlgFd[i] != null)
					model.setDcgoN8thClssFlgFd(dcgoN8thClssFlgFd[i]);
				if (regagmthdrflg[i] != null)
					model.setRegagmthdrflg(regagmthdrflg[i]);
				if (d7R[i] != null)
					model.setD7R(d7R[i]);
				if (initformdtlflg[i] != null)
					model.setInitformdtlflg(initformdtlflg[i]);
				if (a2[i] != null)
					model.setA2(a2[i]);
				if (dcgoN3rdClssFlgR[i] != null)
					model.setDcgoN3rdClssFlgR(dcgoN3rdClssFlgR[i]);
				if (a2R[i] != null)
					model.setA2R(a2R[i]);
				if (a4[i] != null)
					model.setA4(a4[i]);
				if (a5[i] != null)
					model.setA5(a5[i]);
				if (d8Fd[i] != null)
					model.setD8Fd(d8Fd[i]);
				if (dcgoN6thClssFlgFd[i] != null)
					model.setDcgoN6thClssFlgFd(dcgoN6thClssFlgFd[i]);
				if (isValidYdCd[i] != null)
					model.setIsValidYdCd(isValidYdCd[i]);
				if (o2[i] != null)
					model.setO2(o2[i]);
				if (o4[i] != null)
					model.setO4(o4[i]);
				if (dcgoN4thClssFlg[i] != null)
					model.setDcgoN4thClssFlg(dcgoN4thClssFlg[i]);
				if (r9R[i] != null)
					model.setR9R(r9R[i]);
				if (o5[i] != null)
					model.setO5(o5[i]);
				if (a4R[i] != null)
					model.setA4R(a4R[i]);
				if (dwR[i] != null)
					model.setDwR(dwR[i]);
				if (c4Fd[i] != null)
					model.setC4Fd(c4Fd[i]);
				if (d4Fd[i] != null)
					model.setD4Fd(d4Fd[i]);
				if (d8R[i] != null)
					model.setD8R(d8R[i]);
				if (sepDgNone[i] != null)
					model.setSepDgNone(sepDgNone[i]);
				if (a4Fd[i] != null)
					model.setA4Fd(a4Fd[i]);
				if (satFlgFd[i] != null)
					model.setSatFlgFd(satFlgFd[i]);
				if (sameDgFd[i] != null)
					model.setSameDgFd(sameDgFd[i]);
				if (tmlAgmtStsCd[i] != null)
					model.setTmlAgmtStsCd(tmlAgmtStsCd[i]);
				if (ydCdName[i] != null)
					model.setYdCdName(ydCdName[i]);
				if (r8Fd[i] != null)
					model.setR8Fd(r8Fd[i]);
				if (d9R[i] != null)
					model.setD9R(d9R[i]);
				if (regagmtflg[i] != null)
					model.setRegagmtflg(regagmtflg[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (vndrSeqDeltflg[i] != null)
					model.setVndrSeqDeltflg(vndrSeqDeltflg[i]);
				if (sameDg[i] != null)
					model.setSameDg(sameDg[i]);
				if (rowNum[i] != null)
					model.setRowNum(rowNum[i]);
				if (r4Fd[i] != null)
					model.setR4Fd(r4Fd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (tsRt[i] != null)
					model.setTsRt(tsRt[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (dcgoNonClssFlgFd[i] != null)
					model.setDcgoNonClssFlgFd(dcgoNonClssFlgFd[i]);
				if (dwFd[i] != null)
					model.setDwFd(dwFd[i]);
				if (tmlAgmtOfcNo[i] != null)
					model.setTmlAgmtOfcNo(tmlAgmtOfcNo[i]);
				if (dgNone[i] != null)
					model.setDgNone(dgNone[i]);
				if (dcgoN2ndClssFlgFd[i] != null)
					model.setDcgoN2ndClssFlgFd(dcgoN2ndClssFlgFd[i]);
				if (tmlAgmtTpCd[i] != null)
					model.setTmlAgmtTpCd(tmlAgmtTpCd[i]);
				if (dcgoNonClssFlgR[i] != null)
					model.setDcgoNonClssFlgR(dcgoNonClssFlgR[i]);
				if (dcgoN1stClssFlg[i] != null)
					model.setDcgoN1stClssFlg(dcgoN1stClssFlg[i]);
				if (r2Fd[i] != null)
					model.setR2Fd(r2Fd[i]);
				if (creOfcCd2[i] != null)
					model.setCreOfcCd2(creOfcCd2[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (inquiryflg[i] != null)
					model.setInquiryflg(inquiryflg[i]);
				if (dcgoN3rdClssFlg[i] != null)
					model.setDcgoN3rdClssFlg(dcgoN3rdClssFlg[i]);
				if (agmtConfirmFlg[i] != null)
					model.setAgmtConfirmFlg(agmtConfirmFlg[i]);
				if (fileimportflg[i] != null)
					model.setFileimportflg(fileimportflg[i]);
				if (ydCdHidden[i] != null)
					model.setYdCdHidden(ydCdHidden[i]);
				if (f5Fd[i] != null)
					model.setF5Fd(f5Fd[i]);
				if (holFlgFd[i] != null)
					model.setHolFlgFd(holFlgFd[i]);
				if (f4Fd[i] != null)
					model.setF4Fd(f4Fd[i]);
				if (boxRate[i] != null)
					model.setBoxRate(boxRate[i]);
				if (t2Fd[i] != null)
					model.setT2Fd(t2Fd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTesAgreementManageCommonVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TesAgreementManageCommonVO[]
	 */
	public TesAgreementManageCommonVO[] getTesAgreementManageCommonVOs(){
		TesAgreementManageCommonVO[] vos = (TesAgreementManageCommonVO[])models.toArray(new TesAgreementManageCommonVO[models.size()]);
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
		this.accmSeq = this.accmSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f2R = this.f2R .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s2R = this.s2R .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r2R = this.r2R .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.moveRate = this.moveRate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneCdstring = this.laneCdstring .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a2Fd = this.a2Fd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoN7thClssFlgR = this.dcgoN7thClssFlgR .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sepDgNoneFd = this.sepDgNoneFd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoN2ndClssFlgR = this.dcgoN2ndClssFlgR .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoNonClssFlg = this.dcgoNonClssFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dxFd = this.dxFd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o2R = this.o2R .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r9Fd = this.r9Fd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoN5thClssFlg = this.dcgoN5thClssFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r5Fd = this.r5Fd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCdDeltflg = this.ydCdDeltflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effAgmt = this.effAgmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s4R = this.s4R .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dw = this.dw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dx = this.dx .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sameDgNoneFd = this.sameDgNoneFd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vfsarray = this.vfsarray .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoN4thClssFlgR = this.dcgoN4thClssFlgR .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o5R = this.o5R .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoN8thClssFlg = this.dcgoN8thClssFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teuRate = this.teuRate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f2 = this.f2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f5 = this.f5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f4 = this.f4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.c2Fd = this.c2Fd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sameDgR = this.sameDgR .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoN7thClssFlg = this.dcgoN7thClssFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o4R = this.o4R .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoN4thClssFlgFd = this.dcgoN4thClssFlgFd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isValidVndrSeq = this.isValidVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amendCd = this.amendCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgNoneR = this.dgNoneR .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wkdyFlgFd = this.wkdyFlgFd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostCd = this.lgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoN6thClssFlg = this.dcgoN6thClssFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a5Fd = this.a5Fd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accmCostSeq = this.accmCostSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCmd = this.fCmd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d9 = this.d9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d8 = this.d8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5 = this.d5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4 = this.d4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7 = this.d7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2Fd = this.d2Fd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sheetPrefix = this.sheetPrefix .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2 = this.d2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.p2Fd = this.p2Fd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effOn = this.effOn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copyTmlAgmtOfcCtyCd = this.copyTmlAgmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sameDgNoneR = this.sameDgNoneR .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.p4Fd = this.p4Fd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoN3rdClssFlgFd = this.dcgoN3rdClssFlgFd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d9Fd = this.d9Fd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selectTab = this.selectTab .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoN9thClssFlg = this.dcgoN9thClssFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.t4 = this.t4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gangHourRate = this.gangHourRate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r7R = this.r7R .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoN7thClssFlgFd = this.dcgoN7thClssFlgFd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.t2 = this.t2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r4R = this.r4R .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoN2ndClssFlg = this.dcgoN2ndClssFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ipage = this.ipage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoN6thClssFlgR = this.dcgoN6thClssFlgR .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f4R = this.f4R .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s4Fd = this.s4Fd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f2Fd = this.f2Fd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inputListVerifyFlg = this.inputListVerifyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o4Fd = this.o4Fd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o5Fd = this.o5Fd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.t4R = this.t4R .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s4 = this.s4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sunFlgFd = this.sunFlgFd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s2 = this.s2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgNoneFd = this.dgNoneFd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7Fd = this.d7Fd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoN9thClssFlgR = this.dcgoN9thClssFlgR .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5Fd = this.d5Fd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loopValue = this.loopValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.c4 = this.c4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f5R = this.f5R .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sameDgNone = this.sameDgNone .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.p4R = this.p4R .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.c2 = this.c2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2R = this.d2R .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s2Fd = this.s2Fd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r7 = this.r7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r8 = this.r8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r5R = this.r5R .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r9 = this.r9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r2 = this.r2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r4 = this.r4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r5 = this.r5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlAgmtVolUtCd = this.tmlAgmtVolUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a5R = this.a5R .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.p4 = this.p4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoN5thClssFlgR = this.dcgoN5thClssFlgR .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.p2 = this.p2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoN9thClssFlgFd = this.dcgoN9thClssFlgFd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.c4R = this.c4R .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4R = this.d4R .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoN1stClssFlgR = this.dcgoN1stClssFlgR .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.t4Fd = this.t4Fd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoN8thClssFlgR = this.dcgoN8thClssFlgR .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmthdrcreadjflg = this.agmthdrcreadjflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r7Fd = this.r7Fd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoN5thClssFlgFd = this.dcgoN5thClssFlgFd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tonRate = this.tonRate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accmDtlSeq = this.accmDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commandH = this.commandH .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.t2R = this.t2R .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.thrpflg = this.thrpflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5R = this.d5R .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o2Fd = this.o2Fd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.p2R = this.p2R .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeqHidden = this.vndrSeqHidden .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoN1stClssFlgFd = this.dcgoN1stClssFlgFd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r8R = this.r8R .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.c2R = this.c2R .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sepDgNoneR = this.sepDgNoneR .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dxR = this.dxR .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoN8thClssFlgFd = this.dcgoN8thClssFlgFd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.regagmthdrflg = this.regagmthdrflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7R = this.d7R .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initformdtlflg = this.initformdtlflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a2 = this.a2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoN3rdClssFlgR = this.dcgoN3rdClssFlgR .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a2R = this.a2R .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a4 = this.a4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a5 = this.a5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d8Fd = this.d8Fd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoN6thClssFlgFd = this.dcgoN6thClssFlgFd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isValidYdCd = this.isValidYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o2 = this.o2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o4 = this.o4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoN4thClssFlg = this.dcgoN4thClssFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r9R = this.r9R .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o5 = this.o5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a4R = this.a4R .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwR = this.dwR .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.c4Fd = this.c4Fd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4Fd = this.d4Fd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d8R = this.d8R .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sepDgNone = this.sepDgNone .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a4Fd = this.a4Fd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.satFlgFd = this.satFlgFd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sameDgFd = this.sameDgFd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlAgmtStsCd = this.tmlAgmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCdName = this.ydCdName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r8Fd = this.r8Fd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d9R = this.d9R .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.regagmtflg = this.regagmtflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeqDeltflg = this.vndrSeqDeltflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sameDg = this.sameDg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowNum = this.rowNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r4Fd = this.r4Fd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsRt = this.tsRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoNonClssFlgFd = this.dcgoNonClssFlgFd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwFd = this.dwFd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlAgmtOfcNo = this.tmlAgmtOfcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgNone = this.dgNone .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoN2ndClssFlgFd = this.dcgoN2ndClssFlgFd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlAgmtTpCd = this.tmlAgmtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoNonClssFlgR = this.dcgoNonClssFlgR .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoN1stClssFlg = this.dcgoN1stClssFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r2Fd = this.r2Fd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd2 = this.creOfcCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inquiryflg = this.inquiryflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoN3rdClssFlg = this.dcgoN3rdClssFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtConfirmFlg = this.agmtConfirmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileimportflg = this.fileimportflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCdHidden = this.ydCdHidden .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f5Fd = this.f5Fd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.holFlgFd = this.holFlgFd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f4Fd = this.f4Fd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.boxRate = this.boxRate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.t2Fd = this.t2Fd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
