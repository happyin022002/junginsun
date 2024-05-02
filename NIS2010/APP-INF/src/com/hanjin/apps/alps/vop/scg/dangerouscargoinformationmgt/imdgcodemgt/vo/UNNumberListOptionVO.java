/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UNNumberListOptionaVO.java
*@FileTitle : UNNumberListOptionaVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.07
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.07  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo;

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

public class UNNumberListOptionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UNNumberListOptionVO> models = new ArrayList<UNNumberListOptionVO>();
	
	/* Column Info */
	private String total = null;
	/* Column Info */
	private String n2ndImdgIbcProviSeq = null;
	/* Column Info */
	private String n3rdImdgIbcInstrFile = null;
	/* Column Info */
	private String n2ndImdgPckProviCd = null;
	/* Column Info */
	private String cfrRstrOprNm = null;
	/* Column Info */
	private String n3rdImdgTnkInstrProviSeq = null;
	/* Column Info */
	private String imdgUnNoSeq = null;
	/* Column Info */
	private String n2ndImdgUnTnkInstrCd = null;
	/* Column Info */
	private String imdgSubsRskLblRmk = null;
	/* Column Info */
	private String n2ndImdgPckProviSeq = null;
	/* Column Info */
	private String n2ndImdgTnkInstrProviFile = null;
	/* Column Info */
	private String imdgOrgRactTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String n1stImdgIbcInstrSeq = null;
	/* Column Info */
	private String imdgCompGrpCd = null;
	/* Column Info */
	private String segrDesc = null;
	/* Column Info */
	private String cfrDgWetCd = null;
	/* Column Info */
	private String n4thImdgIbcInstrCd = null;
	/* Column Info */
	private String n1stImdgTnkInstrProviFile = null;
	/* Column Info */
	private String n3rdImdgPckProviSeq = null;
	/* Column Info */
	private String n5thImdgPckProviCd = null;
	/* Column Info */
	private String n4thImdgIbcProviCd = null;
	/* Column Info */
	private String n5thImdgPckProviSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String hcdgFlg = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Column Info */
	private String n5thImdgIbcProviSeq = null;
	/* Column Info */
	private String n1stImdgUnTnkInstrSeq = null;
	/* Column Info */
	private String n3rdImdgPckInstrSeq = null;
	/* Column Info */
	private String n3rdImdgPckProviCd = null;
	/* Column Info */
	private String sprtFmImdgClssFlg = null;
	/* Column Info */
	private String awayFmImdgClssFlg = null;
	/* Column Info */
	private String eaiIfFlg = null;
	/* Column Info */
	private String hcdgIntmdBcRstrDesc = null;
	/* Column Info */
	private String n4thImdgTnkInstrProviFile = null;
	/* Column Info */
	private String n3rdImdgIbcInstrCd = null;
	/* Column Info */
	private String sprtLonFmImdgClssCd = null;
	/* Column Info */
	private String n1stImdgUnTnkInstrFile = null;
	/* Column Info */
	private String pageNo = null;
	/* Column Info */
	private String cfrRstrPortNm = null;
	/* Column Info */
	private String emerRspnGidNo = null;
	/* Column Info */
	private String n3rdImdgPckInstrFile = null;
	/* Column Info */
	private String n2ndImdgIbcInstrSeq = null;
	/* Column Info */
	private String n4thBomPortTrstNo = null;
	/* Column Info */
	private String imdgConcRtCtnt = null;
	/* Column Info */
	private String n3rdImdgIbcProviFile = null;
	/* Column Info */
	private String imdgClssCd = null;
	/* Column Info */
	private String imdgPckGrpCd = null;
	/* Column Info */
	private String n3rdImdgIbcInstrSeq = null;
	/* Column Info */
	private String imdgLmtQtyMeasUtCd = null;
	/* Column Info */
	private String n1stBomPortTrstNo = null;
	/* Column Info */
	private String imdgLmtQty = null;
	/* Column Info */
	private String n3rdBomPortTrstNo = null;
	/* Column Info */
	private String n4thImdgIbcInstrSeq = null;
	/* Column Info */
	private String sprtHldFmImdgClssCd = null;
	/* Column Info */
	private String flshPntTempCtnt = null;
	/* Column Info */
	private String n2ndImdgUnTnkInstrSeq = null;
	/* Column Info */
	private String cfrPsnInhZnCd = null;
	/* Column Info */
	private String imdgTecNm = null;
	/* Column Info */
	private String awayFmImdgClssCd = null;
	/* Column Info */
	private String n3rdImdgTnkInstrProviCd = null;
	/* Column Info */
	private String n3rdImdgPckProviFile = null;
	/* Column Info */
	private String imdgSbstPptDesc = null;
	/* Column Info */
	private String n1stImdgTnkInstrProviCd = null;
	/* Column Info */
	private String n2ndImdgIbcInstrCd = null;
	/* Column Info */
	private String imdgFdStufStwgCd = null;
	/* Column Info */
	private String imdgSubsRskLblCd = null;
	/* Column Info */
	private String cfrToxcCd = null;
	/* Column Info */
	private String imdgExptQtyDesc = null;
	/* Column Info */
	private String imdgPckMzdCd = null;
	/* Column Info */
	private String hcdgTnkRstrDesc3 = null;
	/* Column Info */
	private String hcdgTnkRstrDesc4 = null;
	/* Column Info */
	private String n1stImdgPckInstrFile = null;
	/* Column Info */
	private String n2ndImdgPckInstrSeq = null;
	/* Column Info */
	private String hcdgTnkRstrDesc2 = null;
	/* Column Info */
	private String hcdgTnkRstrDesc1 = null;
	/* Column Info */
	private String sprtDpSeq = null;
	/* Column Info */
	private String n2ndImdgTnkInstrProviCd = null;
	/* Column Info */
	private String n1stImdgUnTnkInstrCd = null;
	/* Column Info */
	private String n5thImdgIbcProviFile = null;
	/* Column Info */
	private String n3rdImdgTnkInstrProviFile = null;
	/* Column Info */
	private String n5thImdgTnkInstrProviSeq = null;
	/* Column Info */
	private String n2ndImdgPckInstrFile = null;
	/* Column Info */
	private String sprtFmImdgClssCd = null;
	/* Column Info */
	private String awayFmImdgSegrGrpFlg = null;
	/* Column Info */
	private String hcdgRmk = null;
	/* Column Info */
	private String psaNo = null;
	/* Column Info */
	private String n2ndImdgUnTnkInstrFile = null;
	/* Column Info */
	private String n2ndImdgPckInstrCd = null;
	/* Column Info */
	private String n1stImdgIbcProviCd = null;
	/* Column Info */
	private String n1stImdgPckInstrSeq = null;
	/* Column Info */
	private String imdgSpclProviNo = null;
	/* Column Info */
	private String imdgCrrRstrExptNm = null;
	/* Column Info */
	private String n1stImdgPckProviSeq = null;
	/* Column Info */
	private String n4thImdgPckProviCd = null;
	/* Column Info */
	private String n1stImdgIbcProviSeq = null;
	/* Column Info */
	private String n3rdImdgIbcProviSeq = null;
	/* Column Info */
	private String n3rdImdgPckInstrCd = null;
	/* Column Info */
	private String sprtFmImdgSegrGrpFlg = null;
	/* Column Info */
	private String n1stImdgPckInstrCd = null;
	/* Column Info */
	private String n4thImdgIbcProviSeq = null;
	/* Column Info */
	private String n5thImdgIbcInstrCd = null;
	/* Column Info */
	private String n4thImdgTnkInstrProviCd = null;
	/* Column Info */
	private String imdgSpclProviNo8 = null;
	/* Column Info */
	private String imdgUnNoHldFlg = null;
	/* Column Info */
	private String imdgSpclProviNo4 = null;
	/* Column Info */
	private String imdgSpclProviNo5 = null;
	/* Column Info */
	private String imdgSpclProviNo6 = null;
	/* Column Info */
	private String imdgSpclProviNo7 = null;
	/* Column Info */
	private String n1stImdgPckProviFile = null;
	/* Column Info */
	private String n2ndImdgPckProviFile = null;
	/* Column Info */
	private String sprtLonFmImdgClssFlg = null;
	/* Column Info */
	private String n2ndImdgIbcInstrFile = null;
	/* Column Info */
	private String segrAsForImdgClssCd = null;
	/* Column Info */
	private String n5thImdgTnkInstrProviCd = null;
	/* Column Info */
	private String n5thImdgPckProviFile = null;
	/* Column Info */
	private String awayDpSeq = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String n5thImdgIbcInstrSeq = null;
	/* Column Info */
	private String n4thImdgTnkInstrProviSeq = null;
	/* Column Info */
	private String emerRspnGidChrNo = null;
	/* Column Info */
	private String rowNum = null;
	/* Column Info */
	private String n2ndImdgTnkInstrProviSeq = null;
	/* Column Info */
	private String n4thImdgPckProviSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String eaiIfId = null;
	/* Column Info */
	private String pkgAuthNo = null;
	/* Column Info */
	private String n4thImdgPckProviFile = null;
	/* Column Info */
	private String n5thImdgIbcProviCd = null;
	/* Column Info */
	private String segrAsForImdgClssFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String n2ndImdgIbcProviCd = null;
	/* Column Info */
	private String imdgExptQtyCd = null;
	/* Column Info */
	private String lkPortAuthNo = null;
	/* Column Info */
	private String n1stImdgPckProviCd = null;
	/* Column Info */
	private String n2ndImdgIbcProviFile = null;
	/* Column Info */
	private String imdgCrrRstrExptCd = null;
	/* Column Info */
	private String imdgCtrlTemp = null;
	/* Column Info */
	private String hcdgPckRstrDesc = null;
	/* Column Info */
	private String n4thImdgIbcInstrFile = null;
	/* Column Info */
	private String imdgSpclProviNo3 = null;
	/* Column Info */
	private String n4thImdgIbcProviFile = null;
	/* Column Info */
	private String imdgSpclProviNo2 = null;
	/* Column Info */
	private String cfrRptQty = null;
	/* Column Info */
	private String imdgSpclProviNo1 = null;
	/* Column Info */
	private String n1stImdgTnkInstrProviSeq = null;
	/* Column Info */
	private String imdgHtSrcStwgCd = null;
	/* Column Info */
	private String clrLivQtrStwgFlg = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String n1stImdgIbcInstrCd = null;
	/* Column Info */
	private String imdgStwgCateCd = null;
	/* Column Info */
	private String n3rdImdgIbcProviCd = null;
	/* Column Info */
	private String eaiEvntDt = null;
	/* Column Info */
	private String imdgLmtQtyDesc = null;
	/* Column Info */
	private String n5thImdgTnkInstrProviFile = null;
	/* Column Info */
	private String n5thImdgIbcInstrFile = null;
	/* Column Info */
	private String sprtHldFmImdgClssFlg = null;
	/* Column Info */
	private String imdgEmerNo = null;
	/* Column Info */
	private String n2ndBomPortTrstNo = null;
	/* Column Info */
	private String imdgEmerTemp = null;
	/* Column Info */
	private String hcdgTnkRstrDesc = null;
	/* Column Info */
	private String imdgMrnPolutCd = null;
	/* Column Info */
	private String cfrXtdClssCd = null;
	/* Column Info */
	private String hcdgDpndQtyFlg = null;
	/* Column Info */
	private String imdgSubsRskLblCd2 = null;
	/* Column Info */
	private String n1stImdgIbcProviFile = null;
	/* Column Info */
	private String imdgSubsRskLblCd1 = null;
	/* Column Info */
	private String prpShpNm = null;
	/* Column Info */
	private String n1stImdgIbcInstrFile = null;
	/* Column Info */
	private String imdgSubsRskLblCd4 = null;
	/* Column Info */
	private String imdgSubsRskLblCd3 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public UNNumberListOptionVO() {}

	public UNNumberListOptionVO(String ibflag, String pagerows, String n3rdImdgIbcInstrFile, String n2ndImdgPckProviCd, String cfrRstrOprNm, String imdgUnNoSeq, String imdgSubsRskLblRmk, String n2ndImdgUnTnkInstrCd, String n2ndImdgTnkInstrProviFile, String imdgOrgRactTpCd, String imdgCompGrpCd, String segrDesc, String cfrDgWetCd, String n4thImdgIbcInstrCd, String n1stImdgTnkInstrProviFile, String n5thImdgPckProviCd, String n4thImdgIbcProviCd, String updUsrId, String hcdgFlg, String imdgUnNo, String n3rdImdgPckProviCd, String sprtFmImdgClssFlg, String awayFmImdgClssFlg, String hcdgIntmdBcRstrDesc, String n3rdImdgIbcInstrCd, String n4thImdgTnkInstrProviFile, String sprtLonFmImdgClssCd, String n1stImdgUnTnkInstrFile, String cfrRstrPortNm, String emerRspnGidNo, String n3rdImdgPckInstrFile, String imdgConcRtCtnt, String n4thBomPortTrstNo, String n3rdImdgIbcProviFile, String imdgClssCd, String imdgPckGrpCd, String imdgLmtQtyMeasUtCd, String n1stBomPortTrstNo, String imdgLmtQty, String n3rdBomPortTrstNo, String sprtHldFmImdgClssCd, String flshPntTempCtnt, String imdgTecNm, String cfrPsnInhZnCd, String awayFmImdgClssCd, String n3rdImdgTnkInstrProviCd, String imdgSbstPptDesc, String n3rdImdgPckProviFile, String n1stImdgTnkInstrProviCd, String n2ndImdgIbcInstrCd, String imdgFdStufStwgCd, String imdgSubsRskLblCd, String cfrToxcCd, String imdgExptQtyDesc, String imdgPckMzdCd, String hcdgTnkRstrDesc3, String hcdgTnkRstrDesc4, String n1stImdgPckInstrFile, String hcdgTnkRstrDesc2, String hcdgTnkRstrDesc1, String sprtDpSeq, String n2ndImdgTnkInstrProviCd, String n1stImdgUnTnkInstrCd, String n5thImdgIbcProviFile, String n3rdImdgTnkInstrProviFile, String n2ndImdgPckInstrFile, String sprtFmImdgClssCd, String awayFmImdgSegrGrpFlg, String hcdgRmk, String psaNo, String n2ndImdgUnTnkInstrFile, String n2ndImdgPckInstrCd, String n1stImdgIbcProviCd, String imdgSpclProviNo, String imdgCrrRstrExptNm, String n4thImdgPckProviCd, String n3rdImdgPckInstrCd, String sprtFmImdgSegrGrpFlg, String n1stImdgPckInstrCd, String n5thImdgIbcInstrCd, String n4thImdgTnkInstrProviCd, String imdgSpclProviNo8, String imdgUnNoHldFlg, String imdgSpclProviNo4, String imdgSpclProviNo5, String imdgSpclProviNo6, String imdgSpclProviNo7, String n1stImdgPckProviFile, String n2ndImdgPckProviFile, String sprtLonFmImdgClssFlg, String n2ndImdgIbcInstrFile, String segrAsForImdgClssCd, String n5thImdgTnkInstrProviCd, String n5thImdgPckProviFile, String awayDpSeq, String creUsrId, String emerRspnGidChrNo, String creDt, String pkgAuthNo, String n4thImdgPckProviFile, String n5thImdgIbcProviCd, String segrAsForImdgClssFlg, String imdgExptQtyCd, String n2ndImdgIbcProviCd, String n1stImdgPckProviCd, String lkPortAuthNo, String imdgCrrRstrExptCd, String n2ndImdgIbcProviFile, String imdgCtrlTemp, String hcdgPckRstrDesc, String n4thImdgIbcInstrFile, String imdgSpclProviNo3, String imdgSpclProviNo2, String n4thImdgIbcProviFile, String imdgSpclProviNo1, String cfrRptQty, String clrLivQtrStwgFlg, String imdgHtSrcStwgCd, String updDt, String n1stImdgIbcInstrCd, String imdgStwgCateCd, String n3rdImdgIbcProviCd, String imdgLmtQtyDesc, String sprtHldFmImdgClssFlg, String n5thImdgIbcInstrFile, String n5thImdgTnkInstrProviFile, String imdgEmerNo, String n2ndBomPortTrstNo, String imdgEmerTemp, String imdgSubsRskLblCd2, String hcdgDpndQtyFlg, String cfrXtdClssCd, String imdgMrnPolutCd, String hcdgTnkRstrDesc, String imdgSubsRskLblCd1, String n1stImdgIbcProviFile, String prpShpNm, String imdgSubsRskLblCd4, String n1stImdgIbcInstrFile, String imdgSubsRskLblCd3, String n2ndImdgIbcProviSeq, String n3rdImdgPckInstrSeq, String n3rdImdgIbcInstrSeq, String n4thImdgPckProviSeq, String n2ndImdgPckProviSeq, String n1stImdgPckInstrSeq, String n1stImdgPckProviSeq, String n1stImdgIbcProviSeq, String n2ndImdgPckInstrSeq, String n1stImdgIbcInstrSeq, String n4thImdgIbcInstrSeq, String n3rdImdgIbcProviSeq, String n5thImdgIbcInstrSeq, String n3rdImdgPckProviSeq, String n4thImdgIbcProviSeq, String n2ndImdgIbcInstrSeq, String n5thImdgPckProviSeq, String n5thImdgIbcProviSeq, String n2ndImdgTnkInstrProviSeq, String n1stImdgUnTnkInstrSeq, String n3rdImdgTnkInstrProviSeq, String n4thImdgTnkInstrProviSeq, String n2ndImdgUnTnkInstrSeq, String n5thImdgTnkInstrProviSeq, String n1stImdgTnkInstrProviSeq, String eaiIfFlg, String eaiEvntDt, String eaiIfId, String pageNo, String rowNum, String total) {
		this.total = total;
		this.n2ndImdgIbcProviSeq = n2ndImdgIbcProviSeq;
		this.n3rdImdgIbcInstrFile = n3rdImdgIbcInstrFile;
		this.n2ndImdgPckProviCd = n2ndImdgPckProviCd;
		this.cfrRstrOprNm = cfrRstrOprNm;
		this.n3rdImdgTnkInstrProviSeq = n3rdImdgTnkInstrProviSeq;
		this.imdgUnNoSeq = imdgUnNoSeq;
		this.n2ndImdgUnTnkInstrCd = n2ndImdgUnTnkInstrCd;
		this.imdgSubsRskLblRmk = imdgSubsRskLblRmk;
		this.n2ndImdgPckProviSeq = n2ndImdgPckProviSeq;
		this.n2ndImdgTnkInstrProviFile = n2ndImdgTnkInstrProviFile;
		this.imdgOrgRactTpCd = imdgOrgRactTpCd;
		this.pagerows = pagerows;
		this.n1stImdgIbcInstrSeq = n1stImdgIbcInstrSeq;
		this.imdgCompGrpCd = imdgCompGrpCd;
		this.segrDesc = segrDesc;
		this.cfrDgWetCd = cfrDgWetCd;
		this.n4thImdgIbcInstrCd = n4thImdgIbcInstrCd;
		this.n1stImdgTnkInstrProviFile = n1stImdgTnkInstrProviFile;
		this.n3rdImdgPckProviSeq = n3rdImdgPckProviSeq;
		this.n5thImdgPckProviCd = n5thImdgPckProviCd;
		this.n4thImdgIbcProviCd = n4thImdgIbcProviCd;
		this.n5thImdgPckProviSeq = n5thImdgPckProviSeq;
		this.updUsrId = updUsrId;
		this.hcdgFlg = hcdgFlg;
		this.imdgUnNo = imdgUnNo;
		this.n5thImdgIbcProviSeq = n5thImdgIbcProviSeq;
		this.n1stImdgUnTnkInstrSeq = n1stImdgUnTnkInstrSeq;
		this.n3rdImdgPckInstrSeq = n3rdImdgPckInstrSeq;
		this.n3rdImdgPckProviCd = n3rdImdgPckProviCd;
		this.sprtFmImdgClssFlg = sprtFmImdgClssFlg;
		this.awayFmImdgClssFlg = awayFmImdgClssFlg;
		this.eaiIfFlg = eaiIfFlg;
		this.hcdgIntmdBcRstrDesc = hcdgIntmdBcRstrDesc;
		this.n4thImdgTnkInstrProviFile = n4thImdgTnkInstrProviFile;
		this.n3rdImdgIbcInstrCd = n3rdImdgIbcInstrCd;
		this.sprtLonFmImdgClssCd = sprtLonFmImdgClssCd;
		this.n1stImdgUnTnkInstrFile = n1stImdgUnTnkInstrFile;
		this.pageNo = pageNo;
		this.cfrRstrPortNm = cfrRstrPortNm;
		this.emerRspnGidNo = emerRspnGidNo;
		this.n3rdImdgPckInstrFile = n3rdImdgPckInstrFile;
		this.n2ndImdgIbcInstrSeq = n2ndImdgIbcInstrSeq;
		this.n4thBomPortTrstNo = n4thBomPortTrstNo;
		this.imdgConcRtCtnt = imdgConcRtCtnt;
		this.n3rdImdgIbcProviFile = n3rdImdgIbcProviFile;
		this.imdgClssCd = imdgClssCd;
		this.imdgPckGrpCd = imdgPckGrpCd;
		this.n3rdImdgIbcInstrSeq = n3rdImdgIbcInstrSeq;
		this.imdgLmtQtyMeasUtCd = imdgLmtQtyMeasUtCd;
		this.n1stBomPortTrstNo = n1stBomPortTrstNo;
		this.imdgLmtQty = imdgLmtQty;
		this.n3rdBomPortTrstNo = n3rdBomPortTrstNo;
		this.n4thImdgIbcInstrSeq = n4thImdgIbcInstrSeq;
		this.sprtHldFmImdgClssCd = sprtHldFmImdgClssCd;
		this.flshPntTempCtnt = flshPntTempCtnt;
		this.n2ndImdgUnTnkInstrSeq = n2ndImdgUnTnkInstrSeq;
		this.cfrPsnInhZnCd = cfrPsnInhZnCd;
		this.imdgTecNm = imdgTecNm;
		this.awayFmImdgClssCd = awayFmImdgClssCd;
		this.n3rdImdgTnkInstrProviCd = n3rdImdgTnkInstrProviCd;
		this.n3rdImdgPckProviFile = n3rdImdgPckProviFile;
		this.imdgSbstPptDesc = imdgSbstPptDesc;
		this.n1stImdgTnkInstrProviCd = n1stImdgTnkInstrProviCd;
		this.n2ndImdgIbcInstrCd = n2ndImdgIbcInstrCd;
		this.imdgFdStufStwgCd = imdgFdStufStwgCd;
		this.imdgSubsRskLblCd = imdgSubsRskLblCd;
		this.cfrToxcCd = cfrToxcCd;
		this.imdgExptQtyDesc = imdgExptQtyDesc;
		this.imdgPckMzdCd = imdgPckMzdCd;
		this.hcdgTnkRstrDesc3 = hcdgTnkRstrDesc3;
		this.hcdgTnkRstrDesc4 = hcdgTnkRstrDesc4;
		this.n1stImdgPckInstrFile = n1stImdgPckInstrFile;
		this.n2ndImdgPckInstrSeq = n2ndImdgPckInstrSeq;
		this.hcdgTnkRstrDesc2 = hcdgTnkRstrDesc2;
		this.hcdgTnkRstrDesc1 = hcdgTnkRstrDesc1;
		this.sprtDpSeq = sprtDpSeq;
		this.n2ndImdgTnkInstrProviCd = n2ndImdgTnkInstrProviCd;
		this.n1stImdgUnTnkInstrCd = n1stImdgUnTnkInstrCd;
		this.n5thImdgIbcProviFile = n5thImdgIbcProviFile;
		this.n3rdImdgTnkInstrProviFile = n3rdImdgTnkInstrProviFile;
		this.n5thImdgTnkInstrProviSeq = n5thImdgTnkInstrProviSeq;
		this.n2ndImdgPckInstrFile = n2ndImdgPckInstrFile;
		this.sprtFmImdgClssCd = sprtFmImdgClssCd;
		this.awayFmImdgSegrGrpFlg = awayFmImdgSegrGrpFlg;
		this.hcdgRmk = hcdgRmk;
		this.psaNo = psaNo;
		this.n2ndImdgUnTnkInstrFile = n2ndImdgUnTnkInstrFile;
		this.n2ndImdgPckInstrCd = n2ndImdgPckInstrCd;
		this.n1stImdgIbcProviCd = n1stImdgIbcProviCd;
		this.n1stImdgPckInstrSeq = n1stImdgPckInstrSeq;
		this.imdgSpclProviNo = imdgSpclProviNo;
		this.imdgCrrRstrExptNm = imdgCrrRstrExptNm;
		this.n1stImdgPckProviSeq = n1stImdgPckProviSeq;
		this.n4thImdgPckProviCd = n4thImdgPckProviCd;
		this.n1stImdgIbcProviSeq = n1stImdgIbcProviSeq;
		this.n3rdImdgIbcProviSeq = n3rdImdgIbcProviSeq;
		this.n3rdImdgPckInstrCd = n3rdImdgPckInstrCd;
		this.sprtFmImdgSegrGrpFlg = sprtFmImdgSegrGrpFlg;
		this.n1stImdgPckInstrCd = n1stImdgPckInstrCd;
		this.n4thImdgIbcProviSeq = n4thImdgIbcProviSeq;
		this.n5thImdgIbcInstrCd = n5thImdgIbcInstrCd;
		this.n4thImdgTnkInstrProviCd = n4thImdgTnkInstrProviCd;
		this.imdgSpclProviNo8 = imdgSpclProviNo8;
		this.imdgUnNoHldFlg = imdgUnNoHldFlg;
		this.imdgSpclProviNo4 = imdgSpclProviNo4;
		this.imdgSpclProviNo5 = imdgSpclProviNo5;
		this.imdgSpclProviNo6 = imdgSpclProviNo6;
		this.imdgSpclProviNo7 = imdgSpclProviNo7;
		this.n1stImdgPckProviFile = n1stImdgPckProviFile;
		this.n2ndImdgPckProviFile = n2ndImdgPckProviFile;
		this.sprtLonFmImdgClssFlg = sprtLonFmImdgClssFlg;
		this.n2ndImdgIbcInstrFile = n2ndImdgIbcInstrFile;
		this.segrAsForImdgClssCd = segrAsForImdgClssCd;
		this.n5thImdgTnkInstrProviCd = n5thImdgTnkInstrProviCd;
		this.n5thImdgPckProviFile = n5thImdgPckProviFile;
		this.awayDpSeq = awayDpSeq;
		this.creUsrId = creUsrId;
		this.n5thImdgIbcInstrSeq = n5thImdgIbcInstrSeq;
		this.n4thImdgTnkInstrProviSeq = n4thImdgTnkInstrProviSeq;
		this.emerRspnGidChrNo = emerRspnGidChrNo;
		this.rowNum = rowNum;
		this.n2ndImdgTnkInstrProviSeq = n2ndImdgTnkInstrProviSeq;
		this.n4thImdgPckProviSeq = n4thImdgPckProviSeq;
		this.creDt = creDt;
		this.eaiIfId = eaiIfId;
		this.pkgAuthNo = pkgAuthNo;
		this.n4thImdgPckProviFile = n4thImdgPckProviFile;
		this.n5thImdgIbcProviCd = n5thImdgIbcProviCd;
		this.segrAsForImdgClssFlg = segrAsForImdgClssFlg;
		this.ibflag = ibflag;
		this.n2ndImdgIbcProviCd = n2ndImdgIbcProviCd;
		this.imdgExptQtyCd = imdgExptQtyCd;
		this.lkPortAuthNo = lkPortAuthNo;
		this.n1stImdgPckProviCd = n1stImdgPckProviCd;
		this.n2ndImdgIbcProviFile = n2ndImdgIbcProviFile;
		this.imdgCrrRstrExptCd = imdgCrrRstrExptCd;
		this.imdgCtrlTemp = imdgCtrlTemp;
		this.hcdgPckRstrDesc = hcdgPckRstrDesc;
		this.n4thImdgIbcInstrFile = n4thImdgIbcInstrFile;
		this.imdgSpclProviNo3 = imdgSpclProviNo3;
		this.n4thImdgIbcProviFile = n4thImdgIbcProviFile;
		this.imdgSpclProviNo2 = imdgSpclProviNo2;
		this.cfrRptQty = cfrRptQty;
		this.imdgSpclProviNo1 = imdgSpclProviNo1;
		this.n1stImdgTnkInstrProviSeq = n1stImdgTnkInstrProviSeq;
		this.imdgHtSrcStwgCd = imdgHtSrcStwgCd;
		this.clrLivQtrStwgFlg = clrLivQtrStwgFlg;
		this.updDt = updDt;
		this.n1stImdgIbcInstrCd = n1stImdgIbcInstrCd;
		this.imdgStwgCateCd = imdgStwgCateCd;
		this.n3rdImdgIbcProviCd = n3rdImdgIbcProviCd;
		this.eaiEvntDt = eaiEvntDt;
		this.imdgLmtQtyDesc = imdgLmtQtyDesc;
		this.n5thImdgTnkInstrProviFile = n5thImdgTnkInstrProviFile;
		this.n5thImdgIbcInstrFile = n5thImdgIbcInstrFile;
		this.sprtHldFmImdgClssFlg = sprtHldFmImdgClssFlg;
		this.imdgEmerNo = imdgEmerNo;
		this.n2ndBomPortTrstNo = n2ndBomPortTrstNo;
		this.imdgEmerTemp = imdgEmerTemp;
		this.hcdgTnkRstrDesc = hcdgTnkRstrDesc;
		this.imdgMrnPolutCd = imdgMrnPolutCd;
		this.cfrXtdClssCd = cfrXtdClssCd;
		this.hcdgDpndQtyFlg = hcdgDpndQtyFlg;
		this.imdgSubsRskLblCd2 = imdgSubsRskLblCd2;
		this.n1stImdgIbcProviFile = n1stImdgIbcProviFile;
		this.imdgSubsRskLblCd1 = imdgSubsRskLblCd1;
		this.prpShpNm = prpShpNm;
		this.n1stImdgIbcInstrFile = n1stImdgIbcInstrFile;
		this.imdgSubsRskLblCd4 = imdgSubsRskLblCd4;
		this.imdgSubsRskLblCd3 = imdgSubsRskLblCd3;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("total", getTotal());
		this.hashColumns.put("n2nd_imdg_ibc_provi_seq", getN2ndImdgIbcProviSeq());
		this.hashColumns.put("n3rd_imdg_ibc_instr_file", getN3rdImdgIbcInstrFile());
		this.hashColumns.put("n2nd_imdg_pck_provi_cd", getN2ndImdgPckProviCd());
		this.hashColumns.put("cfr_rstr_opr_nm", getCfrRstrOprNm());
		this.hashColumns.put("n3rd_imdg_tnk_instr_provi_seq", getN3rdImdgTnkInstrProviSeq());
		this.hashColumns.put("imdg_un_no_seq", getImdgUnNoSeq());
		this.hashColumns.put("n2nd_imdg_un_tnk_instr_cd", getN2ndImdgUnTnkInstrCd());
		this.hashColumns.put("imdg_subs_rsk_lbl_rmk", getImdgSubsRskLblRmk());
		this.hashColumns.put("n2nd_imdg_pck_provi_seq", getN2ndImdgPckProviSeq());
		this.hashColumns.put("n2nd_imdg_tnk_instr_provi_file", getN2ndImdgTnkInstrProviFile());
		this.hashColumns.put("imdg_org_ract_tp_cd", getImdgOrgRactTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("n1st_imdg_ibc_instr_seq", getN1stImdgIbcInstrSeq());
		this.hashColumns.put("imdg_comp_grp_cd", getImdgCompGrpCd());
		this.hashColumns.put("segr_desc", getSegrDesc());
		this.hashColumns.put("cfr_dg_wet_cd", getCfrDgWetCd());
		this.hashColumns.put("n4th_imdg_ibc_instr_cd", getN4thImdgIbcInstrCd());
		this.hashColumns.put("n1st_imdg_tnk_instr_provi_file", getN1stImdgTnkInstrProviFile());
		this.hashColumns.put("n3rd_imdg_pck_provi_seq", getN3rdImdgPckProviSeq());
		this.hashColumns.put("n5th_imdg_pck_provi_cd", getN5thImdgPckProviCd());
		this.hashColumns.put("n4th_imdg_ibc_provi_cd", getN4thImdgIbcProviCd());
		this.hashColumns.put("n5th_imdg_pck_provi_seq", getN5thImdgPckProviSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("hcdg_flg", getHcdgFlg());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("n5th_imdg_ibc_provi_seq", getN5thImdgIbcProviSeq());
		this.hashColumns.put("n1st_imdg_un_tnk_instr_seq", getN1stImdgUnTnkInstrSeq());
		this.hashColumns.put("n3rd_imdg_pck_instr_seq", getN3rdImdgPckInstrSeq());
		this.hashColumns.put("n3rd_imdg_pck_provi_cd", getN3rdImdgPckProviCd());
		this.hashColumns.put("sprt_fm_imdg_clss_flg", getSprtFmImdgClssFlg());
		this.hashColumns.put("away_fm_imdg_clss_flg", getAwayFmImdgClssFlg());
		this.hashColumns.put("eai_if_flg", getEaiIfFlg());
		this.hashColumns.put("hcdg_intmd_bc_rstr_desc", getHcdgIntmdBcRstrDesc());
		this.hashColumns.put("n4th_imdg_tnk_instr_provi_file", getN4thImdgTnkInstrProviFile());
		this.hashColumns.put("n3rd_imdg_ibc_instr_cd", getN3rdImdgIbcInstrCd());
		this.hashColumns.put("sprt_lon_fm_imdg_clss_cd", getSprtLonFmImdgClssCd());
		this.hashColumns.put("n1st_imdg_un_tnk_instr_file", getN1stImdgUnTnkInstrFile());
		this.hashColumns.put("page_no", getPageNo());
		this.hashColumns.put("cfr_rstr_port_nm", getCfrRstrPortNm());
		this.hashColumns.put("emer_rspn_gid_no", getEmerRspnGidNo());
		this.hashColumns.put("n3rd_imdg_pck_instr_file", getN3rdImdgPckInstrFile());
		this.hashColumns.put("n2nd_imdg_ibc_instr_seq", getN2ndImdgIbcInstrSeq());
		this.hashColumns.put("n4th_bom_port_trst_no", getN4thBomPortTrstNo());
		this.hashColumns.put("imdg_conc_rt_ctnt", getImdgConcRtCtnt());
		this.hashColumns.put("n3rd_imdg_ibc_provi_file", getN3rdImdgIbcProviFile());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		this.hashColumns.put("imdg_pck_grp_cd", getImdgPckGrpCd());
		this.hashColumns.put("n3rd_imdg_ibc_instr_seq", getN3rdImdgIbcInstrSeq());
		this.hashColumns.put("imdg_lmt_qty_meas_ut_cd", getImdgLmtQtyMeasUtCd());
		this.hashColumns.put("n1st_bom_port_trst_no", getN1stBomPortTrstNo());
		this.hashColumns.put("imdg_lmt_qty", getImdgLmtQty());
		this.hashColumns.put("n3rd_bom_port_trst_no", getN3rdBomPortTrstNo());
		this.hashColumns.put("n4th_imdg_ibc_instr_seq", getN4thImdgIbcInstrSeq());
		this.hashColumns.put("sprt_hld_fm_imdg_clss_cd", getSprtHldFmImdgClssCd());
		this.hashColumns.put("flsh_pnt_temp_ctnt", getFlshPntTempCtnt());
		this.hashColumns.put("n2nd_imdg_un_tnk_instr_seq", getN2ndImdgUnTnkInstrSeq());
		this.hashColumns.put("cfr_psn_inh_zn_cd", getCfrPsnInhZnCd());
		this.hashColumns.put("imdg_tec_nm", getImdgTecNm());
		this.hashColumns.put("away_fm_imdg_clss_cd", getAwayFmImdgClssCd());
		this.hashColumns.put("n3rd_imdg_tnk_instr_provi_cd", getN3rdImdgTnkInstrProviCd());
		this.hashColumns.put("n3rd_imdg_pck_provi_file", getN3rdImdgPckProviFile());
		this.hashColumns.put("imdg_sbst_ppt_desc", getImdgSbstPptDesc());
		this.hashColumns.put("n1st_imdg_tnk_instr_provi_cd", getN1stImdgTnkInstrProviCd());
		this.hashColumns.put("n2nd_imdg_ibc_instr_cd", getN2ndImdgIbcInstrCd());
		this.hashColumns.put("imdg_fd_stuf_stwg_cd", getImdgFdStufStwgCd());
		this.hashColumns.put("imdg_subs_rsk_lbl_cd", getImdgSubsRskLblCd());
		this.hashColumns.put("cfr_toxc_cd", getCfrToxcCd());
		this.hashColumns.put("imdg_expt_qty_desc", getImdgExptQtyDesc());
		this.hashColumns.put("imdg_pck_mzd_cd", getImdgPckMzdCd());
		this.hashColumns.put("hcdg_tnk_rstr_desc3", getHcdgTnkRstrDesc3());
		this.hashColumns.put("hcdg_tnk_rstr_desc4", getHcdgTnkRstrDesc4());
		this.hashColumns.put("n1st_imdg_pck_instr_file", getN1stImdgPckInstrFile());
		this.hashColumns.put("n2nd_imdg_pck_instr_seq", getN2ndImdgPckInstrSeq());
		this.hashColumns.put("hcdg_tnk_rstr_desc2", getHcdgTnkRstrDesc2());
		this.hashColumns.put("hcdg_tnk_rstr_desc1", getHcdgTnkRstrDesc1());
		this.hashColumns.put("sprt_dp_seq", getSprtDpSeq());
		this.hashColumns.put("n2nd_imdg_tnk_instr_provi_cd", getN2ndImdgTnkInstrProviCd());
		this.hashColumns.put("n1st_imdg_un_tnk_instr_cd", getN1stImdgUnTnkInstrCd());
		this.hashColumns.put("n5th_imdg_ibc_provi_file", getN5thImdgIbcProviFile());
		this.hashColumns.put("n3rd_imdg_tnk_instr_provi_file", getN3rdImdgTnkInstrProviFile());
		this.hashColumns.put("n5th_imdg_tnk_instr_provi_seq", getN5thImdgTnkInstrProviSeq());
		this.hashColumns.put("n2nd_imdg_pck_instr_file", getN2ndImdgPckInstrFile());
		this.hashColumns.put("sprt_fm_imdg_clss_cd", getSprtFmImdgClssCd());
		this.hashColumns.put("away_fm_imdg_segr_grp_flg", getAwayFmImdgSegrGrpFlg());
		this.hashColumns.put("hcdg_rmk", getHcdgRmk());
		this.hashColumns.put("psa_no", getPsaNo());
		this.hashColumns.put("n2nd_imdg_un_tnk_instr_file", getN2ndImdgUnTnkInstrFile());
		this.hashColumns.put("n2nd_imdg_pck_instr_cd", getN2ndImdgPckInstrCd());
		this.hashColumns.put("n1st_imdg_ibc_provi_cd", getN1stImdgIbcProviCd());
		this.hashColumns.put("n1st_imdg_pck_instr_seq", getN1stImdgPckInstrSeq());
		this.hashColumns.put("imdg_spcl_provi_no", getImdgSpclProviNo());
		this.hashColumns.put("imdg_crr_rstr_expt_nm", getImdgCrrRstrExptNm());
		this.hashColumns.put("n1st_imdg_pck_provi_seq", getN1stImdgPckProviSeq());
		this.hashColumns.put("n4th_imdg_pck_provi_cd", getN4thImdgPckProviCd());
		this.hashColumns.put("n1st_imdg_ibc_provi_seq", getN1stImdgIbcProviSeq());
		this.hashColumns.put("n3rd_imdg_ibc_provi_seq", getN3rdImdgIbcProviSeq());
		this.hashColumns.put("n3rd_imdg_pck_instr_cd", getN3rdImdgPckInstrCd());
		this.hashColumns.put("sprt_fm_imdg_segr_grp_flg", getSprtFmImdgSegrGrpFlg());
		this.hashColumns.put("n1st_imdg_pck_instr_cd", getN1stImdgPckInstrCd());
		this.hashColumns.put("n4th_imdg_ibc_provi_seq", getN4thImdgIbcProviSeq());
		this.hashColumns.put("n5th_imdg_ibc_instr_cd", getN5thImdgIbcInstrCd());
		this.hashColumns.put("n4th_imdg_tnk_instr_provi_cd", getN4thImdgTnkInstrProviCd());
		this.hashColumns.put("imdg_spcl_provi_no8", getImdgSpclProviNo8());
		this.hashColumns.put("imdg_un_no_hld_flg", getImdgUnNoHldFlg());
		this.hashColumns.put("imdg_spcl_provi_no4", getImdgSpclProviNo4());
		this.hashColumns.put("imdg_spcl_provi_no5", getImdgSpclProviNo5());
		this.hashColumns.put("imdg_spcl_provi_no6", getImdgSpclProviNo6());
		this.hashColumns.put("imdg_spcl_provi_no7", getImdgSpclProviNo7());
		this.hashColumns.put("n1st_imdg_pck_provi_file", getN1stImdgPckProviFile());
		this.hashColumns.put("n2nd_imdg_pck_provi_file", getN2ndImdgPckProviFile());
		this.hashColumns.put("sprt_lon_fm_imdg_clss_flg", getSprtLonFmImdgClssFlg());
		this.hashColumns.put("n2nd_imdg_ibc_instr_file", getN2ndImdgIbcInstrFile());
		this.hashColumns.put("segr_as_for_imdg_clss_cd", getSegrAsForImdgClssCd());
		this.hashColumns.put("n5th_imdg_tnk_instr_provi_cd", getN5thImdgTnkInstrProviCd());
		this.hashColumns.put("n5th_imdg_pck_provi_file", getN5thImdgPckProviFile());
		this.hashColumns.put("away_dp_seq", getAwayDpSeq());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("n5th_imdg_ibc_instr_seq", getN5thImdgIbcInstrSeq());
		this.hashColumns.put("n4th_imdg_tnk_instr_provi_seq", getN4thImdgTnkInstrProviSeq());
		this.hashColumns.put("emer_rspn_gid_chr_no", getEmerRspnGidChrNo());
		this.hashColumns.put("row_num", getRowNum());
		this.hashColumns.put("n2nd_imdg_tnk_instr_provi_seq", getN2ndImdgTnkInstrProviSeq());
		this.hashColumns.put("n4th_imdg_pck_provi_seq", getN4thImdgPckProviSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("eai_if_id", getEaiIfId());
		this.hashColumns.put("pkg_auth_no", getPkgAuthNo());
		this.hashColumns.put("n4th_imdg_pck_provi_file", getN4thImdgPckProviFile());
		this.hashColumns.put("n5th_imdg_ibc_provi_cd", getN5thImdgIbcProviCd());
		this.hashColumns.put("segr_as_for_imdg_clss_flg", getSegrAsForImdgClssFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("n2nd_imdg_ibc_provi_cd", getN2ndImdgIbcProviCd());
		this.hashColumns.put("imdg_expt_qty_cd", getImdgExptQtyCd());
		this.hashColumns.put("lk_port_auth_no", getLkPortAuthNo());
		this.hashColumns.put("n1st_imdg_pck_provi_cd", getN1stImdgPckProviCd());
		this.hashColumns.put("n2nd_imdg_ibc_provi_file", getN2ndImdgIbcProviFile());
		this.hashColumns.put("imdg_crr_rstr_expt_cd", getImdgCrrRstrExptCd());
		this.hashColumns.put("imdg_ctrl_temp", getImdgCtrlTemp());
		this.hashColumns.put("hcdg_pck_rstr_desc", getHcdgPckRstrDesc());
		this.hashColumns.put("n4th_imdg_ibc_instr_file", getN4thImdgIbcInstrFile());
		this.hashColumns.put("imdg_spcl_provi_no3", getImdgSpclProviNo3());
		this.hashColumns.put("n4th_imdg_ibc_provi_file", getN4thImdgIbcProviFile());
		this.hashColumns.put("imdg_spcl_provi_no2", getImdgSpclProviNo2());
		this.hashColumns.put("cfr_rpt_qty", getCfrRptQty());
		this.hashColumns.put("imdg_spcl_provi_no1", getImdgSpclProviNo1());
		this.hashColumns.put("n1st_imdg_tnk_instr_provi_seq", getN1stImdgTnkInstrProviSeq());
		this.hashColumns.put("imdg_ht_src_stwg_cd", getImdgHtSrcStwgCd());
		this.hashColumns.put("clr_liv_qtr_stwg_flg", getClrLivQtrStwgFlg());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("n1st_imdg_ibc_instr_cd", getN1stImdgIbcInstrCd());
		this.hashColumns.put("imdg_stwg_cate_cd", getImdgStwgCateCd());
		this.hashColumns.put("n3rd_imdg_ibc_provi_cd", getN3rdImdgIbcProviCd());
		this.hashColumns.put("eai_evnt_dt", getEaiEvntDt());
		this.hashColumns.put("imdg_lmt_qty_desc", getImdgLmtQtyDesc());
		this.hashColumns.put("n5th_imdg_tnk_instr_provi_file", getN5thImdgTnkInstrProviFile());
		this.hashColumns.put("n5th_imdg_ibc_instr_file", getN5thImdgIbcInstrFile());
		this.hashColumns.put("sprt_hld_fm_imdg_clss_flg", getSprtHldFmImdgClssFlg());
		this.hashColumns.put("imdg_emer_no", getImdgEmerNo());
		this.hashColumns.put("n2nd_bom_port_trst_no", getN2ndBomPortTrstNo());
		this.hashColumns.put("imdg_emer_temp", getImdgEmerTemp());
		this.hashColumns.put("hcdg_tnk_rstr_desc", getHcdgTnkRstrDesc());
		this.hashColumns.put("imdg_mrn_polut_cd", getImdgMrnPolutCd());
		this.hashColumns.put("cfr_xtd_clss_cd", getCfrXtdClssCd());
		this.hashColumns.put("hcdg_dpnd_qty_flg", getHcdgDpndQtyFlg());
		this.hashColumns.put("imdg_subs_rsk_lbl_cd2", getImdgSubsRskLblCd2());
		this.hashColumns.put("n1st_imdg_ibc_provi_file", getN1stImdgIbcProviFile());
		this.hashColumns.put("imdg_subs_rsk_lbl_cd1", getImdgSubsRskLblCd1());
		this.hashColumns.put("prp_shp_nm", getPrpShpNm());
		this.hashColumns.put("n1st_imdg_ibc_instr_file", getN1stImdgIbcInstrFile());
		this.hashColumns.put("imdg_subs_rsk_lbl_cd4", getImdgSubsRskLblCd4());
		this.hashColumns.put("imdg_subs_rsk_lbl_cd3", getImdgSubsRskLblCd3());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("total", "total");
		this.hashFields.put("n2nd_imdg_ibc_provi_seq", "n2ndImdgIbcProviSeq");
		this.hashFields.put("n3rd_imdg_ibc_instr_file", "n3rdImdgIbcInstrFile");
		this.hashFields.put("n2nd_imdg_pck_provi_cd", "n2ndImdgPckProviCd");
		this.hashFields.put("cfr_rstr_opr_nm", "cfrRstrOprNm");
		this.hashFields.put("n3rd_imdg_tnk_instr_provi_seq", "n3rdImdgTnkInstrProviSeq");
		this.hashFields.put("imdg_un_no_seq", "imdgUnNoSeq");
		this.hashFields.put("n2nd_imdg_un_tnk_instr_cd", "n2ndImdgUnTnkInstrCd");
		this.hashFields.put("imdg_subs_rsk_lbl_rmk", "imdgSubsRskLblRmk");
		this.hashFields.put("n2nd_imdg_pck_provi_seq", "n2ndImdgPckProviSeq");
		this.hashFields.put("n2nd_imdg_tnk_instr_provi_file", "n2ndImdgTnkInstrProviFile");
		this.hashFields.put("imdg_org_ract_tp_cd", "imdgOrgRactTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("n1st_imdg_ibc_instr_seq", "n1stImdgIbcInstrSeq");
		this.hashFields.put("imdg_comp_grp_cd", "imdgCompGrpCd");
		this.hashFields.put("segr_desc", "segrDesc");
		this.hashFields.put("cfr_dg_wet_cd", "cfrDgWetCd");
		this.hashFields.put("n4th_imdg_ibc_instr_cd", "n4thImdgIbcInstrCd");
		this.hashFields.put("n1st_imdg_tnk_instr_provi_file", "n1stImdgTnkInstrProviFile");
		this.hashFields.put("n3rd_imdg_pck_provi_seq", "n3rdImdgPckProviSeq");
		this.hashFields.put("n5th_imdg_pck_provi_cd", "n5thImdgPckProviCd");
		this.hashFields.put("n4th_imdg_ibc_provi_cd", "n4thImdgIbcProviCd");
		this.hashFields.put("n5th_imdg_pck_provi_seq", "n5thImdgPckProviSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("hcdg_flg", "hcdgFlg");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("n5th_imdg_ibc_provi_seq", "n5thImdgIbcProviSeq");
		this.hashFields.put("n1st_imdg_un_tnk_instr_seq", "n1stImdgUnTnkInstrSeq");
		this.hashFields.put("n3rd_imdg_pck_instr_seq", "n3rdImdgPckInstrSeq");
		this.hashFields.put("n3rd_imdg_pck_provi_cd", "n3rdImdgPckProviCd");
		this.hashFields.put("sprt_fm_imdg_clss_flg", "sprtFmImdgClssFlg");
		this.hashFields.put("away_fm_imdg_clss_flg", "awayFmImdgClssFlg");
		this.hashFields.put("eai_if_flg", "eaiIfFlg");
		this.hashFields.put("hcdg_intmd_bc_rstr_desc", "hcdgIntmdBcRstrDesc");
		this.hashFields.put("n4th_imdg_tnk_instr_provi_file", "n4thImdgTnkInstrProviFile");
		this.hashFields.put("n3rd_imdg_ibc_instr_cd", "n3rdImdgIbcInstrCd");
		this.hashFields.put("sprt_lon_fm_imdg_clss_cd", "sprtLonFmImdgClssCd");
		this.hashFields.put("n1st_imdg_un_tnk_instr_file", "n1stImdgUnTnkInstrFile");
		this.hashFields.put("page_no", "pageNo");
		this.hashFields.put("cfr_rstr_port_nm", "cfrRstrPortNm");
		this.hashFields.put("emer_rspn_gid_no", "emerRspnGidNo");
		this.hashFields.put("n3rd_imdg_pck_instr_file", "n3rdImdgPckInstrFile");
		this.hashFields.put("n2nd_imdg_ibc_instr_seq", "n2ndImdgIbcInstrSeq");
		this.hashFields.put("n4th_bom_port_trst_no", "n4thBomPortTrstNo");
		this.hashFields.put("imdg_conc_rt_ctnt", "imdgConcRtCtnt");
		this.hashFields.put("n3rd_imdg_ibc_provi_file", "n3rdImdgIbcProviFile");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("imdg_pck_grp_cd", "imdgPckGrpCd");
		this.hashFields.put("n3rd_imdg_ibc_instr_seq", "n3rdImdgIbcInstrSeq");
		this.hashFields.put("imdg_lmt_qty_meas_ut_cd", "imdgLmtQtyMeasUtCd");
		this.hashFields.put("n1st_bom_port_trst_no", "n1stBomPortTrstNo");
		this.hashFields.put("imdg_lmt_qty", "imdgLmtQty");
		this.hashFields.put("n3rd_bom_port_trst_no", "n3rdBomPortTrstNo");
		this.hashFields.put("n4th_imdg_ibc_instr_seq", "n4thImdgIbcInstrSeq");
		this.hashFields.put("sprt_hld_fm_imdg_clss_cd", "sprtHldFmImdgClssCd");
		this.hashFields.put("flsh_pnt_temp_ctnt", "flshPntTempCtnt");
		this.hashFields.put("n2nd_imdg_un_tnk_instr_seq", "n2ndImdgUnTnkInstrSeq");
		this.hashFields.put("cfr_psn_inh_zn_cd", "cfrPsnInhZnCd");
		this.hashFields.put("imdg_tec_nm", "imdgTecNm");
		this.hashFields.put("away_fm_imdg_clss_cd", "awayFmImdgClssCd");
		this.hashFields.put("n3rd_imdg_tnk_instr_provi_cd", "n3rdImdgTnkInstrProviCd");
		this.hashFields.put("n3rd_imdg_pck_provi_file", "n3rdImdgPckProviFile");
		this.hashFields.put("imdg_sbst_ppt_desc", "imdgSbstPptDesc");
		this.hashFields.put("n1st_imdg_tnk_instr_provi_cd", "n1stImdgTnkInstrProviCd");
		this.hashFields.put("n2nd_imdg_ibc_instr_cd", "n2ndImdgIbcInstrCd");
		this.hashFields.put("imdg_fd_stuf_stwg_cd", "imdgFdStufStwgCd");
		this.hashFields.put("imdg_subs_rsk_lbl_cd", "imdgSubsRskLblCd");
		this.hashFields.put("cfr_toxc_cd", "cfrToxcCd");
		this.hashFields.put("imdg_expt_qty_desc", "imdgExptQtyDesc");
		this.hashFields.put("imdg_pck_mzd_cd", "imdgPckMzdCd");
		this.hashFields.put("hcdg_tnk_rstr_desc3", "hcdgTnkRstrDesc3");
		this.hashFields.put("hcdg_tnk_rstr_desc4", "hcdgTnkRstrDesc4");
		this.hashFields.put("n1st_imdg_pck_instr_file", "n1stImdgPckInstrFile");
		this.hashFields.put("n2nd_imdg_pck_instr_seq", "n2ndImdgPckInstrSeq");
		this.hashFields.put("hcdg_tnk_rstr_desc2", "hcdgTnkRstrDesc2");
		this.hashFields.put("hcdg_tnk_rstr_desc1", "hcdgTnkRstrDesc1");
		this.hashFields.put("sprt_dp_seq", "sprtDpSeq");
		this.hashFields.put("n2nd_imdg_tnk_instr_provi_cd", "n2ndImdgTnkInstrProviCd");
		this.hashFields.put("n1st_imdg_un_tnk_instr_cd", "n1stImdgUnTnkInstrCd");
		this.hashFields.put("n5th_imdg_ibc_provi_file", "n5thImdgIbcProviFile");
		this.hashFields.put("n3rd_imdg_tnk_instr_provi_file", "n3rdImdgTnkInstrProviFile");
		this.hashFields.put("n5th_imdg_tnk_instr_provi_seq", "n5thImdgTnkInstrProviSeq");
		this.hashFields.put("n2nd_imdg_pck_instr_file", "n2ndImdgPckInstrFile");
		this.hashFields.put("sprt_fm_imdg_clss_cd", "sprtFmImdgClssCd");
		this.hashFields.put("away_fm_imdg_segr_grp_flg", "awayFmImdgSegrGrpFlg");
		this.hashFields.put("hcdg_rmk", "hcdgRmk");
		this.hashFields.put("psa_no", "psaNo");
		this.hashFields.put("n2nd_imdg_un_tnk_instr_file", "n2ndImdgUnTnkInstrFile");
		this.hashFields.put("n2nd_imdg_pck_instr_cd", "n2ndImdgPckInstrCd");
		this.hashFields.put("n1st_imdg_ibc_provi_cd", "n1stImdgIbcProviCd");
		this.hashFields.put("n1st_imdg_pck_instr_seq", "n1stImdgPckInstrSeq");
		this.hashFields.put("imdg_spcl_provi_no", "imdgSpclProviNo");
		this.hashFields.put("imdg_crr_rstr_expt_nm", "imdgCrrRstrExptNm");
		this.hashFields.put("n1st_imdg_pck_provi_seq", "n1stImdgPckProviSeq");
		this.hashFields.put("n4th_imdg_pck_provi_cd", "n4thImdgPckProviCd");
		this.hashFields.put("n1st_imdg_ibc_provi_seq", "n1stImdgIbcProviSeq");
		this.hashFields.put("n3rd_imdg_ibc_provi_seq", "n3rdImdgIbcProviSeq");
		this.hashFields.put("n3rd_imdg_pck_instr_cd", "n3rdImdgPckInstrCd");
		this.hashFields.put("sprt_fm_imdg_segr_grp_flg", "sprtFmImdgSegrGrpFlg");
		this.hashFields.put("n1st_imdg_pck_instr_cd", "n1stImdgPckInstrCd");
		this.hashFields.put("n4th_imdg_ibc_provi_seq", "n4thImdgIbcProviSeq");
		this.hashFields.put("n5th_imdg_ibc_instr_cd", "n5thImdgIbcInstrCd");
		this.hashFields.put("n4th_imdg_tnk_instr_provi_cd", "n4thImdgTnkInstrProviCd");
		this.hashFields.put("imdg_spcl_provi_no8", "imdgSpclProviNo8");
		this.hashFields.put("imdg_un_no_hld_flg", "imdgUnNoHldFlg");
		this.hashFields.put("imdg_spcl_provi_no4", "imdgSpclProviNo4");
		this.hashFields.put("imdg_spcl_provi_no5", "imdgSpclProviNo5");
		this.hashFields.put("imdg_spcl_provi_no6", "imdgSpclProviNo6");
		this.hashFields.put("imdg_spcl_provi_no7", "imdgSpclProviNo7");
		this.hashFields.put("n1st_imdg_pck_provi_file", "n1stImdgPckProviFile");
		this.hashFields.put("n2nd_imdg_pck_provi_file", "n2ndImdgPckProviFile");
		this.hashFields.put("sprt_lon_fm_imdg_clss_flg", "sprtLonFmImdgClssFlg");
		this.hashFields.put("n2nd_imdg_ibc_instr_file", "n2ndImdgIbcInstrFile");
		this.hashFields.put("segr_as_for_imdg_clss_cd", "segrAsForImdgClssCd");
		this.hashFields.put("n5th_imdg_tnk_instr_provi_cd", "n5thImdgTnkInstrProviCd");
		this.hashFields.put("n5th_imdg_pck_provi_file", "n5thImdgPckProviFile");
		this.hashFields.put("away_dp_seq", "awayDpSeq");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("n5th_imdg_ibc_instr_seq", "n5thImdgIbcInstrSeq");
		this.hashFields.put("n4th_imdg_tnk_instr_provi_seq", "n4thImdgTnkInstrProviSeq");
		this.hashFields.put("emer_rspn_gid_chr_no", "emerRspnGidChrNo");
		this.hashFields.put("row_num", "rowNum");
		this.hashFields.put("n2nd_imdg_tnk_instr_provi_seq", "n2ndImdgTnkInstrProviSeq");
		this.hashFields.put("n4th_imdg_pck_provi_seq", "n4thImdgPckProviSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("eai_if_id", "eaiIfId");
		this.hashFields.put("pkg_auth_no", "pkgAuthNo");
		this.hashFields.put("n4th_imdg_pck_provi_file", "n4thImdgPckProviFile");
		this.hashFields.put("n5th_imdg_ibc_provi_cd", "n5thImdgIbcProviCd");
		this.hashFields.put("segr_as_for_imdg_clss_flg", "segrAsForImdgClssFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("n2nd_imdg_ibc_provi_cd", "n2ndImdgIbcProviCd");
		this.hashFields.put("imdg_expt_qty_cd", "imdgExptQtyCd");
		this.hashFields.put("lk_port_auth_no", "lkPortAuthNo");
		this.hashFields.put("n1st_imdg_pck_provi_cd", "n1stImdgPckProviCd");
		this.hashFields.put("n2nd_imdg_ibc_provi_file", "n2ndImdgIbcProviFile");
		this.hashFields.put("imdg_crr_rstr_expt_cd", "imdgCrrRstrExptCd");
		this.hashFields.put("imdg_ctrl_temp", "imdgCtrlTemp");
		this.hashFields.put("hcdg_pck_rstr_desc", "hcdgPckRstrDesc");
		this.hashFields.put("n4th_imdg_ibc_instr_file", "n4thImdgIbcInstrFile");
		this.hashFields.put("imdg_spcl_provi_no3", "imdgSpclProviNo3");
		this.hashFields.put("n4th_imdg_ibc_provi_file", "n4thImdgIbcProviFile");
		this.hashFields.put("imdg_spcl_provi_no2", "imdgSpclProviNo2");
		this.hashFields.put("cfr_rpt_qty", "cfrRptQty");
		this.hashFields.put("imdg_spcl_provi_no1", "imdgSpclProviNo1");
		this.hashFields.put("n1st_imdg_tnk_instr_provi_seq", "n1stImdgTnkInstrProviSeq");
		this.hashFields.put("imdg_ht_src_stwg_cd", "imdgHtSrcStwgCd");
		this.hashFields.put("clr_liv_qtr_stwg_flg", "clrLivQtrStwgFlg");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("n1st_imdg_ibc_instr_cd", "n1stImdgIbcInstrCd");
		this.hashFields.put("imdg_stwg_cate_cd", "imdgStwgCateCd");
		this.hashFields.put("n3rd_imdg_ibc_provi_cd", "n3rdImdgIbcProviCd");
		this.hashFields.put("eai_evnt_dt", "eaiEvntDt");
		this.hashFields.put("imdg_lmt_qty_desc", "imdgLmtQtyDesc");
		this.hashFields.put("n5th_imdg_tnk_instr_provi_file", "n5thImdgTnkInstrProviFile");
		this.hashFields.put("n5th_imdg_ibc_instr_file", "n5thImdgIbcInstrFile");
		this.hashFields.put("sprt_hld_fm_imdg_clss_flg", "sprtHldFmImdgClssFlg");
		this.hashFields.put("imdg_emer_no", "imdgEmerNo");
		this.hashFields.put("n2nd_bom_port_trst_no", "n2ndBomPortTrstNo");
		this.hashFields.put("imdg_emer_temp", "imdgEmerTemp");
		this.hashFields.put("hcdg_tnk_rstr_desc", "hcdgTnkRstrDesc");
		this.hashFields.put("imdg_mrn_polut_cd", "imdgMrnPolutCd");
		this.hashFields.put("cfr_xtd_clss_cd", "cfrXtdClssCd");
		this.hashFields.put("hcdg_dpnd_qty_flg", "hcdgDpndQtyFlg");
		this.hashFields.put("imdg_subs_rsk_lbl_cd2", "imdgSubsRskLblCd2");
		this.hashFields.put("n1st_imdg_ibc_provi_file", "n1stImdgIbcProviFile");
		this.hashFields.put("imdg_subs_rsk_lbl_cd1", "imdgSubsRskLblCd1");
		this.hashFields.put("prp_shp_nm", "prpShpNm");
		this.hashFields.put("n1st_imdg_ibc_instr_file", "n1stImdgIbcInstrFile");
		this.hashFields.put("imdg_subs_rsk_lbl_cd4", "imdgSubsRskLblCd4");
		this.hashFields.put("imdg_subs_rsk_lbl_cd3", "imdgSubsRskLblCd3");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return total
	 */
	public String getTotal() {
		return this.total;
	}
	
	/**
	 * Column Info
	 * @return n2ndImdgIbcProviSeq
	 */
	public String getN2ndImdgIbcProviSeq() {
		return this.n2ndImdgIbcProviSeq;
	}
	
	/**
	 * Column Info
	 * @return n3rdImdgIbcInstrFile
	 */
	public String getN3rdImdgIbcInstrFile() {
		return this.n3rdImdgIbcInstrFile;
	}
	
	/**
	 * Column Info
	 * @return n2ndImdgPckProviCd
	 */
	public String getN2ndImdgPckProviCd() {
		return this.n2ndImdgPckProviCd;
	}
	
	/**
	 * Column Info
	 * @return cfrRstrOprNm
	 */
	public String getCfrRstrOprNm() {
		return this.cfrRstrOprNm;
	}
	
	/**
	 * Column Info
	 * @return n3rdImdgTnkInstrProviSeq
	 */
	public String getN3rdImdgTnkInstrProviSeq() {
		return this.n3rdImdgTnkInstrProviSeq;
	}
	
	/**
	 * Column Info
	 * @return imdgUnNoSeq
	 */
	public String getImdgUnNoSeq() {
		return this.imdgUnNoSeq;
	}
	
	/**
	 * Column Info
	 * @return n2ndImdgUnTnkInstrCd
	 */
	public String getN2ndImdgUnTnkInstrCd() {
		return this.n2ndImdgUnTnkInstrCd;
	}
	
	/**
	 * Column Info
	 * @return imdgSubsRskLblRmk
	 */
	public String getImdgSubsRskLblRmk() {
		return this.imdgSubsRskLblRmk;
	}
	
	/**
	 * Column Info
	 * @return n2ndImdgPckProviSeq
	 */
	public String getN2ndImdgPckProviSeq() {
		return this.n2ndImdgPckProviSeq;
	}
	
	/**
	 * Column Info
	 * @return n2ndImdgTnkInstrProviFile
	 */
	public String getN2ndImdgTnkInstrProviFile() {
		return this.n2ndImdgTnkInstrProviFile;
	}
	
	/**
	 * Column Info
	 * @return imdgOrgRactTpCd
	 */
	public String getImdgOrgRactTpCd() {
		return this.imdgOrgRactTpCd;
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
	 * @return n1stImdgIbcInstrSeq
	 */
	public String getN1stImdgIbcInstrSeq() {
		return this.n1stImdgIbcInstrSeq;
	}
	
	/**
	 * Column Info
	 * @return imdgCompGrpCd
	 */
	public String getImdgCompGrpCd() {
		return this.imdgCompGrpCd;
	}
	
	/**
	 * Column Info
	 * @return segrDesc
	 */
	public String getSegrDesc() {
		return this.segrDesc;
	}
	
	/**
	 * Column Info
	 * @return cfrDgWetCd
	 */
	public String getCfrDgWetCd() {
		return this.cfrDgWetCd;
	}
	
	/**
	 * Column Info
	 * @return n4thImdgIbcInstrCd
	 */
	public String getN4thImdgIbcInstrCd() {
		return this.n4thImdgIbcInstrCd;
	}
	
	/**
	 * Column Info
	 * @return n1stImdgTnkInstrProviFile
	 */
	public String getN1stImdgTnkInstrProviFile() {
		return this.n1stImdgTnkInstrProviFile;
	}
	
	/**
	 * Column Info
	 * @return n3rdImdgPckProviSeq
	 */
	public String getN3rdImdgPckProviSeq() {
		return this.n3rdImdgPckProviSeq;
	}
	
	/**
	 * Column Info
	 * @return n5thImdgPckProviCd
	 */
	public String getN5thImdgPckProviCd() {
		return this.n5thImdgPckProviCd;
	}
	
	/**
	 * Column Info
	 * @return n4thImdgIbcProviCd
	 */
	public String getN4thImdgIbcProviCd() {
		return this.n4thImdgIbcProviCd;
	}
	
	/**
	 * Column Info
	 * @return n5thImdgPckProviSeq
	 */
	public String getN5thImdgPckProviSeq() {
		return this.n5thImdgPckProviSeq;
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
	 * @return hcdgFlg
	 */
	public String getHcdgFlg() {
		return this.hcdgFlg;
	}
	
	/**
	 * Column Info
	 * @return imdgUnNo
	 */
	public String getImdgUnNo() {
		return this.imdgUnNo;
	}
	
	/**
	 * Column Info
	 * @return n5thImdgIbcProviSeq
	 */
	public String getN5thImdgIbcProviSeq() {
		return this.n5thImdgIbcProviSeq;
	}
	
	/**
	 * Column Info
	 * @return n1stImdgUnTnkInstrSeq
	 */
	public String getN1stImdgUnTnkInstrSeq() {
		return this.n1stImdgUnTnkInstrSeq;
	}
	
	/**
	 * Column Info
	 * @return n3rdImdgPckInstrSeq
	 */
	public String getN3rdImdgPckInstrSeq() {
		return this.n3rdImdgPckInstrSeq;
	}
	
	/**
	 * Column Info
	 * @return n3rdImdgPckProviCd
	 */
	public String getN3rdImdgPckProviCd() {
		return this.n3rdImdgPckProviCd;
	}
	
	/**
	 * Column Info
	 * @return sprtFmImdgClssFlg
	 */
	public String getSprtFmImdgClssFlg() {
		return this.sprtFmImdgClssFlg;
	}
	
	/**
	 * Column Info
	 * @return awayFmImdgClssFlg
	 */
	public String getAwayFmImdgClssFlg() {
		return this.awayFmImdgClssFlg;
	}
	
	/**
	 * Column Info
	 * @return eaiIfFlg
	 */
	public String getEaiIfFlg() {
		return this.eaiIfFlg;
	}
	
	/**
	 * Column Info
	 * @return hcdgIntmdBcRstrDesc
	 */
	public String getHcdgIntmdBcRstrDesc() {
		return this.hcdgIntmdBcRstrDesc;
	}
	
	/**
	 * Column Info
	 * @return n4thImdgTnkInstrProviFile
	 */
	public String getN4thImdgTnkInstrProviFile() {
		return this.n4thImdgTnkInstrProviFile;
	}
	
	/**
	 * Column Info
	 * @return n3rdImdgIbcInstrCd
	 */
	public String getN3rdImdgIbcInstrCd() {
		return this.n3rdImdgIbcInstrCd;
	}
	
	/**
	 * Column Info
	 * @return sprtLonFmImdgClssCd
	 */
	public String getSprtLonFmImdgClssCd() {
		return this.sprtLonFmImdgClssCd;
	}
	
	/**
	 * Column Info
	 * @return n1stImdgUnTnkInstrFile
	 */
	public String getN1stImdgUnTnkInstrFile() {
		return this.n1stImdgUnTnkInstrFile;
	}
	
	/**
	 * Column Info
	 * @return pageNo
	 */
	public String getPageNo() {
		return this.pageNo;
	}
	
	/**
	 * Column Info
	 * @return cfrRstrPortNm
	 */
	public String getCfrRstrPortNm() {
		return this.cfrRstrPortNm;
	}
	
	/**
	 * Column Info
	 * @return emerRspnGidNo
	 */
	public String getEmerRspnGidNo() {
		return this.emerRspnGidNo;
	}
	
	/**
	 * Column Info
	 * @return n3rdImdgPckInstrFile
	 */
	public String getN3rdImdgPckInstrFile() {
		return this.n3rdImdgPckInstrFile;
	}
	
	/**
	 * Column Info
	 * @return n2ndImdgIbcInstrSeq
	 */
	public String getN2ndImdgIbcInstrSeq() {
		return this.n2ndImdgIbcInstrSeq;
	}
	
	/**
	 * Column Info
	 * @return n4thBomPortTrstNo
	 */
	public String getN4thBomPortTrstNo() {
		return this.n4thBomPortTrstNo;
	}
	
	/**
	 * Column Info
	 * @return imdgConcRtCtnt
	 */
	public String getImdgConcRtCtnt() {
		return this.imdgConcRtCtnt;
	}
	
	/**
	 * Column Info
	 * @return n3rdImdgIbcProviFile
	 */
	public String getN3rdImdgIbcProviFile() {
		return this.n3rdImdgIbcProviFile;
	}
	
	/**
	 * Column Info
	 * @return imdgClssCd
	 */
	public String getImdgClssCd() {
		return this.imdgClssCd;
	}
	
	/**
	 * Column Info
	 * @return imdgPckGrpCd
	 */
	public String getImdgPckGrpCd() {
		return this.imdgPckGrpCd;
	}
	
	/**
	 * Column Info
	 * @return n3rdImdgIbcInstrSeq
	 */
	public String getN3rdImdgIbcInstrSeq() {
		return this.n3rdImdgIbcInstrSeq;
	}
	
	/**
	 * Column Info
	 * @return imdgLmtQtyMeasUtCd
	 */
	public String getImdgLmtQtyMeasUtCd() {
		return this.imdgLmtQtyMeasUtCd;
	}
	
	/**
	 * Column Info
	 * @return n1stBomPortTrstNo
	 */
	public String getN1stBomPortTrstNo() {
		return this.n1stBomPortTrstNo;
	}
	
	/**
	 * Column Info
	 * @return imdgLmtQty
	 */
	public String getImdgLmtQty() {
		return this.imdgLmtQty;
	}
	
	/**
	 * Column Info
	 * @return n3rdBomPortTrstNo
	 */
	public String getN3rdBomPortTrstNo() {
		return this.n3rdBomPortTrstNo;
	}
	
	/**
	 * Column Info
	 * @return n4thImdgIbcInstrSeq
	 */
	public String getN4thImdgIbcInstrSeq() {
		return this.n4thImdgIbcInstrSeq;
	}
	
	/**
	 * Column Info
	 * @return sprtHldFmImdgClssCd
	 */
	public String getSprtHldFmImdgClssCd() {
		return this.sprtHldFmImdgClssCd;
	}
	
	/**
	 * Column Info
	 * @return flshPntTempCtnt
	 */
	public String getFlshPntTempCtnt() {
		return this.flshPntTempCtnt;
	}
	
	/**
	 * Column Info
	 * @return n2ndImdgUnTnkInstrSeq
	 */
	public String getN2ndImdgUnTnkInstrSeq() {
		return this.n2ndImdgUnTnkInstrSeq;
	}
	
	/**
	 * Column Info
	 * @return cfrPsnInhZnCd
	 */
	public String getCfrPsnInhZnCd() {
		return this.cfrPsnInhZnCd;
	}
	
	/**
	 * Column Info
	 * @return imdgTecNm
	 */
	public String getImdgTecNm() {
		return this.imdgTecNm;
	}
	
	/**
	 * Column Info
	 * @return awayFmImdgClssCd
	 */
	public String getAwayFmImdgClssCd() {
		return this.awayFmImdgClssCd;
	}
	
	/**
	 * Column Info
	 * @return n3rdImdgTnkInstrProviCd
	 */
	public String getN3rdImdgTnkInstrProviCd() {
		return this.n3rdImdgTnkInstrProviCd;
	}
	
	/**
	 * Column Info
	 * @return n3rdImdgPckProviFile
	 */
	public String getN3rdImdgPckProviFile() {
		return this.n3rdImdgPckProviFile;
	}
	
	/**
	 * Column Info
	 * @return imdgSbstPptDesc
	 */
	public String getImdgSbstPptDesc() {
		return this.imdgSbstPptDesc;
	}
	
	/**
	 * Column Info
	 * @return n1stImdgTnkInstrProviCd
	 */
	public String getN1stImdgTnkInstrProviCd() {
		return this.n1stImdgTnkInstrProviCd;
	}
	
	/**
	 * Column Info
	 * @return n2ndImdgIbcInstrCd
	 */
	public String getN2ndImdgIbcInstrCd() {
		return this.n2ndImdgIbcInstrCd;
	}
	
	/**
	 * Column Info
	 * @return imdgFdStufStwgCd
	 */
	public String getImdgFdStufStwgCd() {
		return this.imdgFdStufStwgCd;
	}
	
	/**
	 * Column Info
	 * @return imdgSubsRskLblCd
	 */
	public String getImdgSubsRskLblCd() {
		return this.imdgSubsRskLblCd;
	}
	
	/**
	 * Column Info
	 * @return cfrToxcCd
	 */
	public String getCfrToxcCd() {
		return this.cfrToxcCd;
	}
	
	/**
	 * Column Info
	 * @return imdgExptQtyDesc
	 */
	public String getImdgExptQtyDesc() {
		return this.imdgExptQtyDesc;
	}
	
	/**
	 * Column Info
	 * @return imdgPckMzdCd
	 */
	public String getImdgPckMzdCd() {
		return this.imdgPckMzdCd;
	}
	
	/**
	 * Column Info
	 * @return hcdgTnkRstrDesc3
	 */
	public String getHcdgTnkRstrDesc3() {
		return this.hcdgTnkRstrDesc3;
	}
	
	/**
	 * Column Info
	 * @return hcdgTnkRstrDesc4
	 */
	public String getHcdgTnkRstrDesc4() {
		return this.hcdgTnkRstrDesc4;
	}
	
	/**
	 * Column Info
	 * @return n1stImdgPckInstrFile
	 */
	public String getN1stImdgPckInstrFile() {
		return this.n1stImdgPckInstrFile;
	}
	
	/**
	 * Column Info
	 * @return n2ndImdgPckInstrSeq
	 */
	public String getN2ndImdgPckInstrSeq() {
		return this.n2ndImdgPckInstrSeq;
	}
	
	/**
	 * Column Info
	 * @return hcdgTnkRstrDesc2
	 */
	public String getHcdgTnkRstrDesc2() {
		return this.hcdgTnkRstrDesc2;
	}
	
	/**
	 * Column Info
	 * @return hcdgTnkRstrDesc1
	 */
	public String getHcdgTnkRstrDesc1() {
		return this.hcdgTnkRstrDesc1;
	}
	
	/**
	 * Column Info
	 * @return sprtDpSeq
	 */
	public String getSprtDpSeq() {
		return this.sprtDpSeq;
	}
	
	/**
	 * Column Info
	 * @return n2ndImdgTnkInstrProviCd
	 */
	public String getN2ndImdgTnkInstrProviCd() {
		return this.n2ndImdgTnkInstrProviCd;
	}
	
	/**
	 * Column Info
	 * @return n1stImdgUnTnkInstrCd
	 */
	public String getN1stImdgUnTnkInstrCd() {
		return this.n1stImdgUnTnkInstrCd;
	}
	
	/**
	 * Column Info
	 * @return n5thImdgIbcProviFile
	 */
	public String getN5thImdgIbcProviFile() {
		return this.n5thImdgIbcProviFile;
	}
	
	/**
	 * Column Info
	 * @return n3rdImdgTnkInstrProviFile
	 */
	public String getN3rdImdgTnkInstrProviFile() {
		return this.n3rdImdgTnkInstrProviFile;
	}
	
	/**
	 * Column Info
	 * @return n5thImdgTnkInstrProviSeq
	 */
	public String getN5thImdgTnkInstrProviSeq() {
		return this.n5thImdgTnkInstrProviSeq;
	}
	
	/**
	 * Column Info
	 * @return n2ndImdgPckInstrFile
	 */
	public String getN2ndImdgPckInstrFile() {
		return this.n2ndImdgPckInstrFile;
	}
	
	/**
	 * Column Info
	 * @return sprtFmImdgClssCd
	 */
	public String getSprtFmImdgClssCd() {
		return this.sprtFmImdgClssCd;
	}
	
	/**
	 * Column Info
	 * @return awayFmImdgSegrGrpFlg
	 */
	public String getAwayFmImdgSegrGrpFlg() {
		return this.awayFmImdgSegrGrpFlg;
	}
	
	/**
	 * Column Info
	 * @return hcdgRmk
	 */
	public String getHcdgRmk() {
		return this.hcdgRmk;
	}
	
	/**
	 * Column Info
	 * @return psaNo
	 */
	public String getPsaNo() {
		return this.psaNo;
	}
	
	/**
	 * Column Info
	 * @return n2ndImdgUnTnkInstrFile
	 */
	public String getN2ndImdgUnTnkInstrFile() {
		return this.n2ndImdgUnTnkInstrFile;
	}
	
	/**
	 * Column Info
	 * @return n2ndImdgPckInstrCd
	 */
	public String getN2ndImdgPckInstrCd() {
		return this.n2ndImdgPckInstrCd;
	}
	
	/**
	 * Column Info
	 * @return n1stImdgIbcProviCd
	 */
	public String getN1stImdgIbcProviCd() {
		return this.n1stImdgIbcProviCd;
	}
	
	/**
	 * Column Info
	 * @return n1stImdgPckInstrSeq
	 */
	public String getN1stImdgPckInstrSeq() {
		return this.n1stImdgPckInstrSeq;
	}
	
	/**
	 * Column Info
	 * @return imdgSpclProviNo
	 */
	public String getImdgSpclProviNo() {
		return this.imdgSpclProviNo;
	}
	
	/**
	 * Column Info
	 * @return imdgCrrRstrExptNm
	 */
	public String getImdgCrrRstrExptNm() {
		return this.imdgCrrRstrExptNm;
	}
	
	/**
	 * Column Info
	 * @return n1stImdgPckProviSeq
	 */
	public String getN1stImdgPckProviSeq() {
		return this.n1stImdgPckProviSeq;
	}
	
	/**
	 * Column Info
	 * @return n4thImdgPckProviCd
	 */
	public String getN4thImdgPckProviCd() {
		return this.n4thImdgPckProviCd;
	}
	
	/**
	 * Column Info
	 * @return n1stImdgIbcProviSeq
	 */
	public String getN1stImdgIbcProviSeq() {
		return this.n1stImdgIbcProviSeq;
	}
	
	/**
	 * Column Info
	 * @return n3rdImdgIbcProviSeq
	 */
	public String getN3rdImdgIbcProviSeq() {
		return this.n3rdImdgIbcProviSeq;
	}
	
	/**
	 * Column Info
	 * @return n3rdImdgPckInstrCd
	 */
	public String getN3rdImdgPckInstrCd() {
		return this.n3rdImdgPckInstrCd;
	}
	
	/**
	 * Column Info
	 * @return sprtFmImdgSegrGrpFlg
	 */
	public String getSprtFmImdgSegrGrpFlg() {
		return this.sprtFmImdgSegrGrpFlg;
	}
	
	/**
	 * Column Info
	 * @return n1stImdgPckInstrCd
	 */
	public String getN1stImdgPckInstrCd() {
		return this.n1stImdgPckInstrCd;
	}
	
	/**
	 * Column Info
	 * @return n4thImdgIbcProviSeq
	 */
	public String getN4thImdgIbcProviSeq() {
		return this.n4thImdgIbcProviSeq;
	}
	
	/**
	 * Column Info
	 * @return n5thImdgIbcInstrCd
	 */
	public String getN5thImdgIbcInstrCd() {
		return this.n5thImdgIbcInstrCd;
	}
	
	/**
	 * Column Info
	 * @return n4thImdgTnkInstrProviCd
	 */
	public String getN4thImdgTnkInstrProviCd() {
		return this.n4thImdgTnkInstrProviCd;
	}
	
	/**
	 * Column Info
	 * @return imdgSpclProviNo8
	 */
	public String getImdgSpclProviNo8() {
		return this.imdgSpclProviNo8;
	}
	
	/**
	 * Column Info
	 * @return imdgUnNoHldFlg
	 */
	public String getImdgUnNoHldFlg() {
		return this.imdgUnNoHldFlg;
	}
	
	/**
	 * Column Info
	 * @return imdgSpclProviNo4
	 */
	public String getImdgSpclProviNo4() {
		return this.imdgSpclProviNo4;
	}
	
	/**
	 * Column Info
	 * @return imdgSpclProviNo5
	 */
	public String getImdgSpclProviNo5() {
		return this.imdgSpclProviNo5;
	}
	
	/**
	 * Column Info
	 * @return imdgSpclProviNo6
	 */
	public String getImdgSpclProviNo6() {
		return this.imdgSpclProviNo6;
	}
	
	/**
	 * Column Info
	 * @return imdgSpclProviNo7
	 */
	public String getImdgSpclProviNo7() {
		return this.imdgSpclProviNo7;
	}
	
	/**
	 * Column Info
	 * @return n1stImdgPckProviFile
	 */
	public String getN1stImdgPckProviFile() {
		return this.n1stImdgPckProviFile;
	}
	
	/**
	 * Column Info
	 * @return n2ndImdgPckProviFile
	 */
	public String getN2ndImdgPckProviFile() {
		return this.n2ndImdgPckProviFile;
	}
	
	/**
	 * Column Info
	 * @return sprtLonFmImdgClssFlg
	 */
	public String getSprtLonFmImdgClssFlg() {
		return this.sprtLonFmImdgClssFlg;
	}
	
	/**
	 * Column Info
	 * @return n2ndImdgIbcInstrFile
	 */
	public String getN2ndImdgIbcInstrFile() {
		return this.n2ndImdgIbcInstrFile;
	}
	
	/**
	 * Column Info
	 * @return segrAsForImdgClssCd
	 */
	public String getSegrAsForImdgClssCd() {
		return this.segrAsForImdgClssCd;
	}
	
	/**
	 * Column Info
	 * @return n5thImdgTnkInstrProviCd
	 */
	public String getN5thImdgTnkInstrProviCd() {
		return this.n5thImdgTnkInstrProviCd;
	}
	
	/**
	 * Column Info
	 * @return n5thImdgPckProviFile
	 */
	public String getN5thImdgPckProviFile() {
		return this.n5thImdgPckProviFile;
	}
	
	/**
	 * Column Info
	 * @return awayDpSeq
	 */
	public String getAwayDpSeq() {
		return this.awayDpSeq;
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
	 * @return n5thImdgIbcInstrSeq
	 */
	public String getN5thImdgIbcInstrSeq() {
		return this.n5thImdgIbcInstrSeq;
	}
	
	/**
	 * Column Info
	 * @return n4thImdgTnkInstrProviSeq
	 */
	public String getN4thImdgTnkInstrProviSeq() {
		return this.n4thImdgTnkInstrProviSeq;
	}
	
	/**
	 * Column Info
	 * @return emerRspnGidChrNo
	 */
	public String getEmerRspnGidChrNo() {
		return this.emerRspnGidChrNo;
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
	 * @return n2ndImdgTnkInstrProviSeq
	 */
	public String getN2ndImdgTnkInstrProviSeq() {
		return this.n2ndImdgTnkInstrProviSeq;
	}
	
	/**
	 * Column Info
	 * @return n4thImdgPckProviSeq
	 */
	public String getN4thImdgPckProviSeq() {
		return this.n4thImdgPckProviSeq;
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
	 * @return eaiIfId
	 */
	public String getEaiIfId() {
		return this.eaiIfId;
	}
	
	/**
	 * Column Info
	 * @return pkgAuthNo
	 */
	public String getPkgAuthNo() {
		return this.pkgAuthNo;
	}
	
	/**
	 * Column Info
	 * @return n4thImdgPckProviFile
	 */
	public String getN4thImdgPckProviFile() {
		return this.n4thImdgPckProviFile;
	}
	
	/**
	 * Column Info
	 * @return n5thImdgIbcProviCd
	 */
	public String getN5thImdgIbcProviCd() {
		return this.n5thImdgIbcProviCd;
	}
	
	/**
	 * Column Info
	 * @return segrAsForImdgClssFlg
	 */
	public String getSegrAsForImdgClssFlg() {
		return this.segrAsForImdgClssFlg;
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
	 * @return n2ndImdgIbcProviCd
	 */
	public String getN2ndImdgIbcProviCd() {
		return this.n2ndImdgIbcProviCd;
	}
	
	/**
	 * Column Info
	 * @return imdgExptQtyCd
	 */
	public String getImdgExptQtyCd() {
		return this.imdgExptQtyCd;
	}
	
	/**
	 * Column Info
	 * @return lkPortAuthNo
	 */
	public String getLkPortAuthNo() {
		return this.lkPortAuthNo;
	}
	
	/**
	 * Column Info
	 * @return n1stImdgPckProviCd
	 */
	public String getN1stImdgPckProviCd() {
		return this.n1stImdgPckProviCd;
	}
	
	/**
	 * Column Info
	 * @return n2ndImdgIbcProviFile
	 */
	public String getN2ndImdgIbcProviFile() {
		return this.n2ndImdgIbcProviFile;
	}
	
	/**
	 * Column Info
	 * @return imdgCrrRstrExptCd
	 */
	public String getImdgCrrRstrExptCd() {
		return this.imdgCrrRstrExptCd;
	}
	
	/**
	 * Column Info
	 * @return imdgCtrlTemp
	 */
	public String getImdgCtrlTemp() {
		return this.imdgCtrlTemp;
	}
	
	/**
	 * Column Info
	 * @return hcdgPckRstrDesc
	 */
	public String getHcdgPckRstrDesc() {
		return this.hcdgPckRstrDesc;
	}
	
	/**
	 * Column Info
	 * @return n4thImdgIbcInstrFile
	 */
	public String getN4thImdgIbcInstrFile() {
		return this.n4thImdgIbcInstrFile;
	}
	
	/**
	 * Column Info
	 * @return imdgSpclProviNo3
	 */
	public String getImdgSpclProviNo3() {
		return this.imdgSpclProviNo3;
	}
	
	/**
	 * Column Info
	 * @return n4thImdgIbcProviFile
	 */
	public String getN4thImdgIbcProviFile() {
		return this.n4thImdgIbcProviFile;
	}
	
	/**
	 * Column Info
	 * @return imdgSpclProviNo2
	 */
	public String getImdgSpclProviNo2() {
		return this.imdgSpclProviNo2;
	}
	
	/**
	 * Column Info
	 * @return cfrRptQty
	 */
	public String getCfrRptQty() {
		return this.cfrRptQty;
	}
	
	/**
	 * Column Info
	 * @return imdgSpclProviNo1
	 */
	public String getImdgSpclProviNo1() {
		return this.imdgSpclProviNo1;
	}
	
	/**
	 * Column Info
	 * @return n1stImdgTnkInstrProviSeq
	 */
	public String getN1stImdgTnkInstrProviSeq() {
		return this.n1stImdgTnkInstrProviSeq;
	}
	
	/**
	 * Column Info
	 * @return imdgHtSrcStwgCd
	 */
	public String getImdgHtSrcStwgCd() {
		return this.imdgHtSrcStwgCd;
	}
	
	/**
	 * Column Info
	 * @return clrLivQtrStwgFlg
	 */
	public String getClrLivQtrStwgFlg() {
		return this.clrLivQtrStwgFlg;
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
	 * @return n1stImdgIbcInstrCd
	 */
	public String getN1stImdgIbcInstrCd() {
		return this.n1stImdgIbcInstrCd;
	}
	
	/**
	 * Column Info
	 * @return imdgStwgCateCd
	 */
	public String getImdgStwgCateCd() {
		return this.imdgStwgCateCd;
	}
	
	/**
	 * Column Info
	 * @return n3rdImdgIbcProviCd
	 */
	public String getN3rdImdgIbcProviCd() {
		return this.n3rdImdgIbcProviCd;
	}
	
	/**
	 * Column Info
	 * @return eaiEvntDt
	 */
	public String getEaiEvntDt() {
		return this.eaiEvntDt;
	}
	
	/**
	 * Column Info
	 * @return imdgLmtQtyDesc
	 */
	public String getImdgLmtQtyDesc() {
		return this.imdgLmtQtyDesc;
	}
	
	/**
	 * Column Info
	 * @return n5thImdgTnkInstrProviFile
	 */
	public String getN5thImdgTnkInstrProviFile() {
		return this.n5thImdgTnkInstrProviFile;
	}
	
	/**
	 * Column Info
	 * @return n5thImdgIbcInstrFile
	 */
	public String getN5thImdgIbcInstrFile() {
		return this.n5thImdgIbcInstrFile;
	}
	
	/**
	 * Column Info
	 * @return sprtHldFmImdgClssFlg
	 */
	public String getSprtHldFmImdgClssFlg() {
		return this.sprtHldFmImdgClssFlg;
	}
	
	/**
	 * Column Info
	 * @return imdgEmerNo
	 */
	public String getImdgEmerNo() {
		return this.imdgEmerNo;
	}
	
	/**
	 * Column Info
	 * @return n2ndBomPortTrstNo
	 */
	public String getN2ndBomPortTrstNo() {
		return this.n2ndBomPortTrstNo;
	}
	
	/**
	 * Column Info
	 * @return imdgEmerTemp
	 */
	public String getImdgEmerTemp() {
		return this.imdgEmerTemp;
	}
	
	/**
	 * Column Info
	 * @return hcdgTnkRstrDesc
	 */
	public String getHcdgTnkRstrDesc() {
		return this.hcdgTnkRstrDesc;
	}
	
	/**
	 * Column Info
	 * @return imdgMrnPolutCd
	 */
	public String getImdgMrnPolutCd() {
		return this.imdgMrnPolutCd;
	}
	
	/**
	 * Column Info
	 * @return cfrXtdClssCd
	 */
	public String getCfrXtdClssCd() {
		return this.cfrXtdClssCd;
	}
	
	/**
	 * Column Info
	 * @return hcdgDpndQtyFlg
	 */
	public String getHcdgDpndQtyFlg() {
		return this.hcdgDpndQtyFlg;
	}
	
	/**
	 * Column Info
	 * @return imdgSubsRskLblCd2
	 */
	public String getImdgSubsRskLblCd2() {
		return this.imdgSubsRskLblCd2;
	}
	
	/**
	 * Column Info
	 * @return n1stImdgIbcProviFile
	 */
	public String getN1stImdgIbcProviFile() {
		return this.n1stImdgIbcProviFile;
	}
	
	/**
	 * Column Info
	 * @return imdgSubsRskLblCd1
	 */
	public String getImdgSubsRskLblCd1() {
		return this.imdgSubsRskLblCd1;
	}
	
	/**
	 * Column Info
	 * @return prpShpNm
	 */
	public String getPrpShpNm() {
		return this.prpShpNm;
	}
	
	/**
	 * Column Info
	 * @return n1stImdgIbcInstrFile
	 */
	public String getN1stImdgIbcInstrFile() {
		return this.n1stImdgIbcInstrFile;
	}
	
	/**
	 * Column Info
	 * @return imdgSubsRskLblCd4
	 */
	public String getImdgSubsRskLblCd4() {
		return this.imdgSubsRskLblCd4;
	}
	
	/**
	 * Column Info
	 * @return imdgSubsRskLblCd3
	 */
	public String getImdgSubsRskLblCd3() {
		return this.imdgSubsRskLblCd3;
	}
	

	/**
	 * Column Info
	 * @param total
	 */
	public void setTotal(String total) {
		this.total = total;
	}
	
	/**
	 * Column Info
	 * @param n2ndImdgIbcProviSeq
	 */
	public void setN2ndImdgIbcProviSeq(String n2ndImdgIbcProviSeq) {
		this.n2ndImdgIbcProviSeq = n2ndImdgIbcProviSeq;
	}
	
	/**
	 * Column Info
	 * @param n3rdImdgIbcInstrFile
	 */
	public void setN3rdImdgIbcInstrFile(String n3rdImdgIbcInstrFile) {
		this.n3rdImdgIbcInstrFile = n3rdImdgIbcInstrFile;
	}
	
	/**
	 * Column Info
	 * @param n2ndImdgPckProviCd
	 */
	public void setN2ndImdgPckProviCd(String n2ndImdgPckProviCd) {
		this.n2ndImdgPckProviCd = n2ndImdgPckProviCd;
	}
	
	/**
	 * Column Info
	 * @param cfrRstrOprNm
	 */
	public void setCfrRstrOprNm(String cfrRstrOprNm) {
		this.cfrRstrOprNm = cfrRstrOprNm;
	}
	
	/**
	 * Column Info
	 * @param n3rdImdgTnkInstrProviSeq
	 */
	public void setN3rdImdgTnkInstrProviSeq(String n3rdImdgTnkInstrProviSeq) {
		this.n3rdImdgTnkInstrProviSeq = n3rdImdgTnkInstrProviSeq;
	}
	
	/**
	 * Column Info
	 * @param imdgUnNoSeq
	 */
	public void setImdgUnNoSeq(String imdgUnNoSeq) {
		this.imdgUnNoSeq = imdgUnNoSeq;
	}
	
	/**
	 * Column Info
	 * @param n2ndImdgUnTnkInstrCd
	 */
	public void setN2ndImdgUnTnkInstrCd(String n2ndImdgUnTnkInstrCd) {
		this.n2ndImdgUnTnkInstrCd = n2ndImdgUnTnkInstrCd;
	}
	
	/**
	 * Column Info
	 * @param imdgSubsRskLblRmk
	 */
	public void setImdgSubsRskLblRmk(String imdgSubsRskLblRmk) {
		this.imdgSubsRskLblRmk = imdgSubsRskLblRmk;
	}
	
	/**
	 * Column Info
	 * @param n2ndImdgPckProviSeq
	 */
	public void setN2ndImdgPckProviSeq(String n2ndImdgPckProviSeq) {
		this.n2ndImdgPckProviSeq = n2ndImdgPckProviSeq;
	}
	
	/**
	 * Column Info
	 * @param n2ndImdgTnkInstrProviFile
	 */
	public void setN2ndImdgTnkInstrProviFile(String n2ndImdgTnkInstrProviFile) {
		this.n2ndImdgTnkInstrProviFile = n2ndImdgTnkInstrProviFile;
	}
	
	/**
	 * Column Info
	 * @param imdgOrgRactTpCd
	 */
	public void setImdgOrgRactTpCd(String imdgOrgRactTpCd) {
		this.imdgOrgRactTpCd = imdgOrgRactTpCd;
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
	 * @param n1stImdgIbcInstrSeq
	 */
	public void setN1stImdgIbcInstrSeq(String n1stImdgIbcInstrSeq) {
		this.n1stImdgIbcInstrSeq = n1stImdgIbcInstrSeq;
	}
	
	/**
	 * Column Info
	 * @param imdgCompGrpCd
	 */
	public void setImdgCompGrpCd(String imdgCompGrpCd) {
		this.imdgCompGrpCd = imdgCompGrpCd;
	}
	
	/**
	 * Column Info
	 * @param segrDesc
	 */
	public void setSegrDesc(String segrDesc) {
		this.segrDesc = segrDesc;
	}
	
	/**
	 * Column Info
	 * @param cfrDgWetCd
	 */
	public void setCfrDgWetCd(String cfrDgWetCd) {
		this.cfrDgWetCd = cfrDgWetCd;
	}
	
	/**
	 * Column Info
	 * @param n4thImdgIbcInstrCd
	 */
	public void setN4thImdgIbcInstrCd(String n4thImdgIbcInstrCd) {
		this.n4thImdgIbcInstrCd = n4thImdgIbcInstrCd;
	}
	
	/**
	 * Column Info
	 * @param n1stImdgTnkInstrProviFile
	 */
	public void setN1stImdgTnkInstrProviFile(String n1stImdgTnkInstrProviFile) {
		this.n1stImdgTnkInstrProviFile = n1stImdgTnkInstrProviFile;
	}
	
	/**
	 * Column Info
	 * @param n3rdImdgPckProviSeq
	 */
	public void setN3rdImdgPckProviSeq(String n3rdImdgPckProviSeq) {
		this.n3rdImdgPckProviSeq = n3rdImdgPckProviSeq;
	}
	
	/**
	 * Column Info
	 * @param n5thImdgPckProviCd
	 */
	public void setN5thImdgPckProviCd(String n5thImdgPckProviCd) {
		this.n5thImdgPckProviCd = n5thImdgPckProviCd;
	}
	
	/**
	 * Column Info
	 * @param n4thImdgIbcProviCd
	 */
	public void setN4thImdgIbcProviCd(String n4thImdgIbcProviCd) {
		this.n4thImdgIbcProviCd = n4thImdgIbcProviCd;
	}
	
	/**
	 * Column Info
	 * @param n5thImdgPckProviSeq
	 */
	public void setN5thImdgPckProviSeq(String n5thImdgPckProviSeq) {
		this.n5thImdgPckProviSeq = n5thImdgPckProviSeq;
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
	 * @param hcdgFlg
	 */
	public void setHcdgFlg(String hcdgFlg) {
		this.hcdgFlg = hcdgFlg;
	}
	
	/**
	 * Column Info
	 * @param imdgUnNo
	 */
	public void setImdgUnNo(String imdgUnNo) {
		this.imdgUnNo = imdgUnNo;
	}
	
	/**
	 * Column Info
	 * @param n5thImdgIbcProviSeq
	 */
	public void setN5thImdgIbcProviSeq(String n5thImdgIbcProviSeq) {
		this.n5thImdgIbcProviSeq = n5thImdgIbcProviSeq;
	}
	
	/**
	 * Column Info
	 * @param n1stImdgUnTnkInstrSeq
	 */
	public void setN1stImdgUnTnkInstrSeq(String n1stImdgUnTnkInstrSeq) {
		this.n1stImdgUnTnkInstrSeq = n1stImdgUnTnkInstrSeq;
	}
	
	/**
	 * Column Info
	 * @param n3rdImdgPckInstrSeq
	 */
	public void setN3rdImdgPckInstrSeq(String n3rdImdgPckInstrSeq) {
		this.n3rdImdgPckInstrSeq = n3rdImdgPckInstrSeq;
	}
	
	/**
	 * Column Info
	 * @param n3rdImdgPckProviCd
	 */
	public void setN3rdImdgPckProviCd(String n3rdImdgPckProviCd) {
		this.n3rdImdgPckProviCd = n3rdImdgPckProviCd;
	}
	
	/**
	 * Column Info
	 * @param sprtFmImdgClssFlg
	 */
	public void setSprtFmImdgClssFlg(String sprtFmImdgClssFlg) {
		this.sprtFmImdgClssFlg = sprtFmImdgClssFlg;
	}
	
	/**
	 * Column Info
	 * @param awayFmImdgClssFlg
	 */
	public void setAwayFmImdgClssFlg(String awayFmImdgClssFlg) {
		this.awayFmImdgClssFlg = awayFmImdgClssFlg;
	}
	
	/**
	 * Column Info
	 * @param eaiIfFlg
	 */
	public void setEaiIfFlg(String eaiIfFlg) {
		this.eaiIfFlg = eaiIfFlg;
	}
	
	/**
	 * Column Info
	 * @param hcdgIntmdBcRstrDesc
	 */
	public void setHcdgIntmdBcRstrDesc(String hcdgIntmdBcRstrDesc) {
		this.hcdgIntmdBcRstrDesc = hcdgIntmdBcRstrDesc;
	}
	
	/**
	 * Column Info
	 * @param n4thImdgTnkInstrProviFile
	 */
	public void setN4thImdgTnkInstrProviFile(String n4thImdgTnkInstrProviFile) {
		this.n4thImdgTnkInstrProviFile = n4thImdgTnkInstrProviFile;
	}
	
	/**
	 * Column Info
	 * @param n3rdImdgIbcInstrCd
	 */
	public void setN3rdImdgIbcInstrCd(String n3rdImdgIbcInstrCd) {
		this.n3rdImdgIbcInstrCd = n3rdImdgIbcInstrCd;
	}
	
	/**
	 * Column Info
	 * @param sprtLonFmImdgClssCd
	 */
	public void setSprtLonFmImdgClssCd(String sprtLonFmImdgClssCd) {
		this.sprtLonFmImdgClssCd = sprtLonFmImdgClssCd;
	}
	
	/**
	 * Column Info
	 * @param n1stImdgUnTnkInstrFile
	 */
	public void setN1stImdgUnTnkInstrFile(String n1stImdgUnTnkInstrFile) {
		this.n1stImdgUnTnkInstrFile = n1stImdgUnTnkInstrFile;
	}
	
	/**
	 * Column Info
	 * @param pageNo
	 */
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	
	/**
	 * Column Info
	 * @param cfrRstrPortNm
	 */
	public void setCfrRstrPortNm(String cfrRstrPortNm) {
		this.cfrRstrPortNm = cfrRstrPortNm;
	}
	
	/**
	 * Column Info
	 * @param emerRspnGidNo
	 */
	public void setEmerRspnGidNo(String emerRspnGidNo) {
		this.emerRspnGidNo = emerRspnGidNo;
	}
	
	/**
	 * Column Info
	 * @param n3rdImdgPckInstrFile
	 */
	public void setN3rdImdgPckInstrFile(String n3rdImdgPckInstrFile) {
		this.n3rdImdgPckInstrFile = n3rdImdgPckInstrFile;
	}
	
	/**
	 * Column Info
	 * @param n2ndImdgIbcInstrSeq
	 */
	public void setN2ndImdgIbcInstrSeq(String n2ndImdgIbcInstrSeq) {
		this.n2ndImdgIbcInstrSeq = n2ndImdgIbcInstrSeq;
	}
	
	/**
	 * Column Info
	 * @param n4thBomPortTrstNo
	 */
	public void setN4thBomPortTrstNo(String n4thBomPortTrstNo) {
		this.n4thBomPortTrstNo = n4thBomPortTrstNo;
	}
	
	/**
	 * Column Info
	 * @param imdgConcRtCtnt
	 */
	public void setImdgConcRtCtnt(String imdgConcRtCtnt) {
		this.imdgConcRtCtnt = imdgConcRtCtnt;
	}
	
	/**
	 * Column Info
	 * @param n3rdImdgIbcProviFile
	 */
	public void setN3rdImdgIbcProviFile(String n3rdImdgIbcProviFile) {
		this.n3rdImdgIbcProviFile = n3rdImdgIbcProviFile;
	}
	
	/**
	 * Column Info
	 * @param imdgClssCd
	 */
	public void setImdgClssCd(String imdgClssCd) {
		this.imdgClssCd = imdgClssCd;
	}
	
	/**
	 * Column Info
	 * @param imdgPckGrpCd
	 */
	public void setImdgPckGrpCd(String imdgPckGrpCd) {
		this.imdgPckGrpCd = imdgPckGrpCd;
	}
	
	/**
	 * Column Info
	 * @param n3rdImdgIbcInstrSeq
	 */
	public void setN3rdImdgIbcInstrSeq(String n3rdImdgIbcInstrSeq) {
		this.n3rdImdgIbcInstrSeq = n3rdImdgIbcInstrSeq;
	}
	
	/**
	 * Column Info
	 * @param imdgLmtQtyMeasUtCd
	 */
	public void setImdgLmtQtyMeasUtCd(String imdgLmtQtyMeasUtCd) {
		this.imdgLmtQtyMeasUtCd = imdgLmtQtyMeasUtCd;
	}
	
	/**
	 * Column Info
	 * @param n1stBomPortTrstNo
	 */
	public void setN1stBomPortTrstNo(String n1stBomPortTrstNo) {
		this.n1stBomPortTrstNo = n1stBomPortTrstNo;
	}
	
	/**
	 * Column Info
	 * @param imdgLmtQty
	 */
	public void setImdgLmtQty(String imdgLmtQty) {
		this.imdgLmtQty = imdgLmtQty;
	}
	
	/**
	 * Column Info
	 * @param n3rdBomPortTrstNo
	 */
	public void setN3rdBomPortTrstNo(String n3rdBomPortTrstNo) {
		this.n3rdBomPortTrstNo = n3rdBomPortTrstNo;
	}
	
	/**
	 * Column Info
	 * @param n4thImdgIbcInstrSeq
	 */
	public void setN4thImdgIbcInstrSeq(String n4thImdgIbcInstrSeq) {
		this.n4thImdgIbcInstrSeq = n4thImdgIbcInstrSeq;
	}
	
	/**
	 * Column Info
	 * @param sprtHldFmImdgClssCd
	 */
	public void setSprtHldFmImdgClssCd(String sprtHldFmImdgClssCd) {
		this.sprtHldFmImdgClssCd = sprtHldFmImdgClssCd;
	}
	
	/**
	 * Column Info
	 * @param flshPntTempCtnt
	 */
	public void setFlshPntTempCtnt(String flshPntTempCtnt) {
		this.flshPntTempCtnt = flshPntTempCtnt;
	}
	
	/**
	 * Column Info
	 * @param n2ndImdgUnTnkInstrSeq
	 */
	public void setN2ndImdgUnTnkInstrSeq(String n2ndImdgUnTnkInstrSeq) {
		this.n2ndImdgUnTnkInstrSeq = n2ndImdgUnTnkInstrSeq;
	}
	
	/**
	 * Column Info
	 * @param cfrPsnInhZnCd
	 */
	public void setCfrPsnInhZnCd(String cfrPsnInhZnCd) {
		this.cfrPsnInhZnCd = cfrPsnInhZnCd;
	}
	
	/**
	 * Column Info
	 * @param imdgTecNm
	 */
	public void setImdgTecNm(String imdgTecNm) {
		this.imdgTecNm = imdgTecNm;
	}
	
	/**
	 * Column Info
	 * @param awayFmImdgClssCd
	 */
	public void setAwayFmImdgClssCd(String awayFmImdgClssCd) {
		this.awayFmImdgClssCd = awayFmImdgClssCd;
	}
	
	/**
	 * Column Info
	 * @param n3rdImdgTnkInstrProviCd
	 */
	public void setN3rdImdgTnkInstrProviCd(String n3rdImdgTnkInstrProviCd) {
		this.n3rdImdgTnkInstrProviCd = n3rdImdgTnkInstrProviCd;
	}
	
	/**
	 * Column Info
	 * @param n3rdImdgPckProviFile
	 */
	public void setN3rdImdgPckProviFile(String n3rdImdgPckProviFile) {
		this.n3rdImdgPckProviFile = n3rdImdgPckProviFile;
	}
	
	/**
	 * Column Info
	 * @param imdgSbstPptDesc
	 */
	public void setImdgSbstPptDesc(String imdgSbstPptDesc) {
		this.imdgSbstPptDesc = imdgSbstPptDesc;
	}
	
	/**
	 * Column Info
	 * @param n1stImdgTnkInstrProviCd
	 */
	public void setN1stImdgTnkInstrProviCd(String n1stImdgTnkInstrProviCd) {
		this.n1stImdgTnkInstrProviCd = n1stImdgTnkInstrProviCd;
	}
	
	/**
	 * Column Info
	 * @param n2ndImdgIbcInstrCd
	 */
	public void setN2ndImdgIbcInstrCd(String n2ndImdgIbcInstrCd) {
		this.n2ndImdgIbcInstrCd = n2ndImdgIbcInstrCd;
	}
	
	/**
	 * Column Info
	 * @param imdgFdStufStwgCd
	 */
	public void setImdgFdStufStwgCd(String imdgFdStufStwgCd) {
		this.imdgFdStufStwgCd = imdgFdStufStwgCd;
	}
	
	/**
	 * Column Info
	 * @param imdgSubsRskLblCd
	 */
	public void setImdgSubsRskLblCd(String imdgSubsRskLblCd) {
		this.imdgSubsRskLblCd = imdgSubsRskLblCd;
	}
	
	/**
	 * Column Info
	 * @param cfrToxcCd
	 */
	public void setCfrToxcCd(String cfrToxcCd) {
		this.cfrToxcCd = cfrToxcCd;
	}
	
	/**
	 * Column Info
	 * @param imdgExptQtyDesc
	 */
	public void setImdgExptQtyDesc(String imdgExptQtyDesc) {
		this.imdgExptQtyDesc = imdgExptQtyDesc;
	}
	
	/**
	 * Column Info
	 * @param imdgPckMzdCd
	 */
	public void setImdgPckMzdCd(String imdgPckMzdCd) {
		this.imdgPckMzdCd = imdgPckMzdCd;
	}
	
	/**
	 * Column Info
	 * @param hcdgTnkRstrDesc3
	 */
	public void setHcdgTnkRstrDesc3(String hcdgTnkRstrDesc3) {
		this.hcdgTnkRstrDesc3 = hcdgTnkRstrDesc3;
	}
	
	/**
	 * Column Info
	 * @param hcdgTnkRstrDesc4
	 */
	public void setHcdgTnkRstrDesc4(String hcdgTnkRstrDesc4) {
		this.hcdgTnkRstrDesc4 = hcdgTnkRstrDesc4;
	}
	
	/**
	 * Column Info
	 * @param n1stImdgPckInstrFile
	 */
	public void setN1stImdgPckInstrFile(String n1stImdgPckInstrFile) {
		this.n1stImdgPckInstrFile = n1stImdgPckInstrFile;
	}
	
	/**
	 * Column Info
	 * @param n2ndImdgPckInstrSeq
	 */
	public void setN2ndImdgPckInstrSeq(String n2ndImdgPckInstrSeq) {
		this.n2ndImdgPckInstrSeq = n2ndImdgPckInstrSeq;
	}
	
	/**
	 * Column Info
	 * @param hcdgTnkRstrDesc2
	 */
	public void setHcdgTnkRstrDesc2(String hcdgTnkRstrDesc2) {
		this.hcdgTnkRstrDesc2 = hcdgTnkRstrDesc2;
	}
	
	/**
	 * Column Info
	 * @param hcdgTnkRstrDesc1
	 */
	public void setHcdgTnkRstrDesc1(String hcdgTnkRstrDesc1) {
		this.hcdgTnkRstrDesc1 = hcdgTnkRstrDesc1;
	}
	
	/**
	 * Column Info
	 * @param sprtDpSeq
	 */
	public void setSprtDpSeq(String sprtDpSeq) {
		this.sprtDpSeq = sprtDpSeq;
	}
	
	/**
	 * Column Info
	 * @param n2ndImdgTnkInstrProviCd
	 */
	public void setN2ndImdgTnkInstrProviCd(String n2ndImdgTnkInstrProviCd) {
		this.n2ndImdgTnkInstrProviCd = n2ndImdgTnkInstrProviCd;
	}
	
	/**
	 * Column Info
	 * @param n1stImdgUnTnkInstrCd
	 */
	public void setN1stImdgUnTnkInstrCd(String n1stImdgUnTnkInstrCd) {
		this.n1stImdgUnTnkInstrCd = n1stImdgUnTnkInstrCd;
	}
	
	/**
	 * Column Info
	 * @param n5thImdgIbcProviFile
	 */
	public void setN5thImdgIbcProviFile(String n5thImdgIbcProviFile) {
		this.n5thImdgIbcProviFile = n5thImdgIbcProviFile;
	}
	
	/**
	 * Column Info
	 * @param n3rdImdgTnkInstrProviFile
	 */
	public void setN3rdImdgTnkInstrProviFile(String n3rdImdgTnkInstrProviFile) {
		this.n3rdImdgTnkInstrProviFile = n3rdImdgTnkInstrProviFile;
	}
	
	/**
	 * Column Info
	 * @param n5thImdgTnkInstrProviSeq
	 */
	public void setN5thImdgTnkInstrProviSeq(String n5thImdgTnkInstrProviSeq) {
		this.n5thImdgTnkInstrProviSeq = n5thImdgTnkInstrProviSeq;
	}
	
	/**
	 * Column Info
	 * @param n2ndImdgPckInstrFile
	 */
	public void setN2ndImdgPckInstrFile(String n2ndImdgPckInstrFile) {
		this.n2ndImdgPckInstrFile = n2ndImdgPckInstrFile;
	}
	
	/**
	 * Column Info
	 * @param sprtFmImdgClssCd
	 */
	public void setSprtFmImdgClssCd(String sprtFmImdgClssCd) {
		this.sprtFmImdgClssCd = sprtFmImdgClssCd;
	}
	
	/**
	 * Column Info
	 * @param awayFmImdgSegrGrpFlg
	 */
	public void setAwayFmImdgSegrGrpFlg(String awayFmImdgSegrGrpFlg) {
		this.awayFmImdgSegrGrpFlg = awayFmImdgSegrGrpFlg;
	}
	
	/**
	 * Column Info
	 * @param hcdgRmk
	 */
	public void setHcdgRmk(String hcdgRmk) {
		this.hcdgRmk = hcdgRmk;
	}
	
	/**
	 * Column Info
	 * @param psaNo
	 */
	public void setPsaNo(String psaNo) {
		this.psaNo = psaNo;
	}
	
	/**
	 * Column Info
	 * @param n2ndImdgUnTnkInstrFile
	 */
	public void setN2ndImdgUnTnkInstrFile(String n2ndImdgUnTnkInstrFile) {
		this.n2ndImdgUnTnkInstrFile = n2ndImdgUnTnkInstrFile;
	}
	
	/**
	 * Column Info
	 * @param n2ndImdgPckInstrCd
	 */
	public void setN2ndImdgPckInstrCd(String n2ndImdgPckInstrCd) {
		this.n2ndImdgPckInstrCd = n2ndImdgPckInstrCd;
	}
	
	/**
	 * Column Info
	 * @param n1stImdgIbcProviCd
	 */
	public void setN1stImdgIbcProviCd(String n1stImdgIbcProviCd) {
		this.n1stImdgIbcProviCd = n1stImdgIbcProviCd;
	}
	
	/**
	 * Column Info
	 * @param n1stImdgPckInstrSeq
	 */
	public void setN1stImdgPckInstrSeq(String n1stImdgPckInstrSeq) {
		this.n1stImdgPckInstrSeq = n1stImdgPckInstrSeq;
	}
	
	/**
	 * Column Info
	 * @param imdgSpclProviNo
	 */
	public void setImdgSpclProviNo(String imdgSpclProviNo) {
		this.imdgSpclProviNo = imdgSpclProviNo;
	}
	
	/**
	 * Column Info
	 * @param imdgCrrRstrExptNm
	 */
	public void setImdgCrrRstrExptNm(String imdgCrrRstrExptNm) {
		this.imdgCrrRstrExptNm = imdgCrrRstrExptNm;
	}
	
	/**
	 * Column Info
	 * @param n1stImdgPckProviSeq
	 */
	public void setN1stImdgPckProviSeq(String n1stImdgPckProviSeq) {
		this.n1stImdgPckProviSeq = n1stImdgPckProviSeq;
	}
	
	/**
	 * Column Info
	 * @param n4thImdgPckProviCd
	 */
	public void setN4thImdgPckProviCd(String n4thImdgPckProviCd) {
		this.n4thImdgPckProviCd = n4thImdgPckProviCd;
	}
	
	/**
	 * Column Info
	 * @param n1stImdgIbcProviSeq
	 */
	public void setN1stImdgIbcProviSeq(String n1stImdgIbcProviSeq) {
		this.n1stImdgIbcProviSeq = n1stImdgIbcProviSeq;
	}
	
	/**
	 * Column Info
	 * @param n3rdImdgIbcProviSeq
	 */
	public void setN3rdImdgIbcProviSeq(String n3rdImdgIbcProviSeq) {
		this.n3rdImdgIbcProviSeq = n3rdImdgIbcProviSeq;
	}
	
	/**
	 * Column Info
	 * @param n3rdImdgPckInstrCd
	 */
	public void setN3rdImdgPckInstrCd(String n3rdImdgPckInstrCd) {
		this.n3rdImdgPckInstrCd = n3rdImdgPckInstrCd;
	}
	
	/**
	 * Column Info
	 * @param sprtFmImdgSegrGrpFlg
	 */
	public void setSprtFmImdgSegrGrpFlg(String sprtFmImdgSegrGrpFlg) {
		this.sprtFmImdgSegrGrpFlg = sprtFmImdgSegrGrpFlg;
	}
	
	/**
	 * Column Info
	 * @param n1stImdgPckInstrCd
	 */
	public void setN1stImdgPckInstrCd(String n1stImdgPckInstrCd) {
		this.n1stImdgPckInstrCd = n1stImdgPckInstrCd;
	}
	
	/**
	 * Column Info
	 * @param n4thImdgIbcProviSeq
	 */
	public void setN4thImdgIbcProviSeq(String n4thImdgIbcProviSeq) {
		this.n4thImdgIbcProviSeq = n4thImdgIbcProviSeq;
	}
	
	/**
	 * Column Info
	 * @param n5thImdgIbcInstrCd
	 */
	public void setN5thImdgIbcInstrCd(String n5thImdgIbcInstrCd) {
		this.n5thImdgIbcInstrCd = n5thImdgIbcInstrCd;
	}
	
	/**
	 * Column Info
	 * @param n4thImdgTnkInstrProviCd
	 */
	public void setN4thImdgTnkInstrProviCd(String n4thImdgTnkInstrProviCd) {
		this.n4thImdgTnkInstrProviCd = n4thImdgTnkInstrProviCd;
	}
	
	/**
	 * Column Info
	 * @param imdgSpclProviNo8
	 */
	public void setImdgSpclProviNo8(String imdgSpclProviNo8) {
		this.imdgSpclProviNo8 = imdgSpclProviNo8;
	}
	
	/**
	 * Column Info
	 * @param imdgUnNoHldFlg
	 */
	public void setImdgUnNoHldFlg(String imdgUnNoHldFlg) {
		this.imdgUnNoHldFlg = imdgUnNoHldFlg;
	}
	
	/**
	 * Column Info
	 * @param imdgSpclProviNo4
	 */
	public void setImdgSpclProviNo4(String imdgSpclProviNo4) {
		this.imdgSpclProviNo4 = imdgSpclProviNo4;
	}
	
	/**
	 * Column Info
	 * @param imdgSpclProviNo5
	 */
	public void setImdgSpclProviNo5(String imdgSpclProviNo5) {
		this.imdgSpclProviNo5 = imdgSpclProviNo5;
	}
	
	/**
	 * Column Info
	 * @param imdgSpclProviNo6
	 */
	public void setImdgSpclProviNo6(String imdgSpclProviNo6) {
		this.imdgSpclProviNo6 = imdgSpclProviNo6;
	}
	
	/**
	 * Column Info
	 * @param imdgSpclProviNo7
	 */
	public void setImdgSpclProviNo7(String imdgSpclProviNo7) {
		this.imdgSpclProviNo7 = imdgSpclProviNo7;
	}
	
	/**
	 * Column Info
	 * @param n1stImdgPckProviFile
	 */
	public void setN1stImdgPckProviFile(String n1stImdgPckProviFile) {
		this.n1stImdgPckProviFile = n1stImdgPckProviFile;
	}
	
	/**
	 * Column Info
	 * @param n2ndImdgPckProviFile
	 */
	public void setN2ndImdgPckProviFile(String n2ndImdgPckProviFile) {
		this.n2ndImdgPckProviFile = n2ndImdgPckProviFile;
	}
	
	/**
	 * Column Info
	 * @param sprtLonFmImdgClssFlg
	 */
	public void setSprtLonFmImdgClssFlg(String sprtLonFmImdgClssFlg) {
		this.sprtLonFmImdgClssFlg = sprtLonFmImdgClssFlg;
	}
	
	/**
	 * Column Info
	 * @param n2ndImdgIbcInstrFile
	 */
	public void setN2ndImdgIbcInstrFile(String n2ndImdgIbcInstrFile) {
		this.n2ndImdgIbcInstrFile = n2ndImdgIbcInstrFile;
	}
	
	/**
	 * Column Info
	 * @param segrAsForImdgClssCd
	 */
	public void setSegrAsForImdgClssCd(String segrAsForImdgClssCd) {
		this.segrAsForImdgClssCd = segrAsForImdgClssCd;
	}
	
	/**
	 * Column Info
	 * @param n5thImdgTnkInstrProviCd
	 */
	public void setN5thImdgTnkInstrProviCd(String n5thImdgTnkInstrProviCd) {
		this.n5thImdgTnkInstrProviCd = n5thImdgTnkInstrProviCd;
	}
	
	/**
	 * Column Info
	 * @param n5thImdgPckProviFile
	 */
	public void setN5thImdgPckProviFile(String n5thImdgPckProviFile) {
		this.n5thImdgPckProviFile = n5thImdgPckProviFile;
	}
	
	/**
	 * Column Info
	 * @param awayDpSeq
	 */
	public void setAwayDpSeq(String awayDpSeq) {
		this.awayDpSeq = awayDpSeq;
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
	 * @param n5thImdgIbcInstrSeq
	 */
	public void setN5thImdgIbcInstrSeq(String n5thImdgIbcInstrSeq) {
		this.n5thImdgIbcInstrSeq = n5thImdgIbcInstrSeq;
	}
	
	/**
	 * Column Info
	 * @param n4thImdgTnkInstrProviSeq
	 */
	public void setN4thImdgTnkInstrProviSeq(String n4thImdgTnkInstrProviSeq) {
		this.n4thImdgTnkInstrProviSeq = n4thImdgTnkInstrProviSeq;
	}
	
	/**
	 * Column Info
	 * @param emerRspnGidChrNo
	 */
	public void setEmerRspnGidChrNo(String emerRspnGidChrNo) {
		this.emerRspnGidChrNo = emerRspnGidChrNo;
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
	 * @param n2ndImdgTnkInstrProviSeq
	 */
	public void setN2ndImdgTnkInstrProviSeq(String n2ndImdgTnkInstrProviSeq) {
		this.n2ndImdgTnkInstrProviSeq = n2ndImdgTnkInstrProviSeq;
	}
	
	/**
	 * Column Info
	 * @param n4thImdgPckProviSeq
	 */
	public void setN4thImdgPckProviSeq(String n4thImdgPckProviSeq) {
		this.n4thImdgPckProviSeq = n4thImdgPckProviSeq;
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
	 * @param eaiIfId
	 */
	public void setEaiIfId(String eaiIfId) {
		this.eaiIfId = eaiIfId;
	}
	
	/**
	 * Column Info
	 * @param pkgAuthNo
	 */
	public void setPkgAuthNo(String pkgAuthNo) {
		this.pkgAuthNo = pkgAuthNo;
	}
	
	/**
	 * Column Info
	 * @param n4thImdgPckProviFile
	 */
	public void setN4thImdgPckProviFile(String n4thImdgPckProviFile) {
		this.n4thImdgPckProviFile = n4thImdgPckProviFile;
	}
	
	/**
	 * Column Info
	 * @param n5thImdgIbcProviCd
	 */
	public void setN5thImdgIbcProviCd(String n5thImdgIbcProviCd) {
		this.n5thImdgIbcProviCd = n5thImdgIbcProviCd;
	}
	
	/**
	 * Column Info
	 * @param segrAsForImdgClssFlg
	 */
	public void setSegrAsForImdgClssFlg(String segrAsForImdgClssFlg) {
		this.segrAsForImdgClssFlg = segrAsForImdgClssFlg;
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
	 * @param n2ndImdgIbcProviCd
	 */
	public void setN2ndImdgIbcProviCd(String n2ndImdgIbcProviCd) {
		this.n2ndImdgIbcProviCd = n2ndImdgIbcProviCd;
	}
	
	/**
	 * Column Info
	 * @param imdgExptQtyCd
	 */
	public void setImdgExptQtyCd(String imdgExptQtyCd) {
		this.imdgExptQtyCd = imdgExptQtyCd;
	}
	
	/**
	 * Column Info
	 * @param lkPortAuthNo
	 */
	public void setLkPortAuthNo(String lkPortAuthNo) {
		this.lkPortAuthNo = lkPortAuthNo;
	}
	
	/**
	 * Column Info
	 * @param n1stImdgPckProviCd
	 */
	public void setN1stImdgPckProviCd(String n1stImdgPckProviCd) {
		this.n1stImdgPckProviCd = n1stImdgPckProviCd;
	}
	
	/**
	 * Column Info
	 * @param n2ndImdgIbcProviFile
	 */
	public void setN2ndImdgIbcProviFile(String n2ndImdgIbcProviFile) {
		this.n2ndImdgIbcProviFile = n2ndImdgIbcProviFile;
	}
	
	/**
	 * Column Info
	 * @param imdgCrrRstrExptCd
	 */
	public void setImdgCrrRstrExptCd(String imdgCrrRstrExptCd) {
		this.imdgCrrRstrExptCd = imdgCrrRstrExptCd;
	}
	
	/**
	 * Column Info
	 * @param imdgCtrlTemp
	 */
	public void setImdgCtrlTemp(String imdgCtrlTemp) {
		this.imdgCtrlTemp = imdgCtrlTemp;
	}
	
	/**
	 * Column Info
	 * @param hcdgPckRstrDesc
	 */
	public void setHcdgPckRstrDesc(String hcdgPckRstrDesc) {
		this.hcdgPckRstrDesc = hcdgPckRstrDesc;
	}
	
	/**
	 * Column Info
	 * @param n4thImdgIbcInstrFile
	 */
	public void setN4thImdgIbcInstrFile(String n4thImdgIbcInstrFile) {
		this.n4thImdgIbcInstrFile = n4thImdgIbcInstrFile;
	}
	
	/**
	 * Column Info
	 * @param imdgSpclProviNo3
	 */
	public void setImdgSpclProviNo3(String imdgSpclProviNo3) {
		this.imdgSpclProviNo3 = imdgSpclProviNo3;
	}
	
	/**
	 * Column Info
	 * @param n4thImdgIbcProviFile
	 */
	public void setN4thImdgIbcProviFile(String n4thImdgIbcProviFile) {
		this.n4thImdgIbcProviFile = n4thImdgIbcProviFile;
	}
	
	/**
	 * Column Info
	 * @param imdgSpclProviNo2
	 */
	public void setImdgSpclProviNo2(String imdgSpclProviNo2) {
		this.imdgSpclProviNo2 = imdgSpclProviNo2;
	}
	
	/**
	 * Column Info
	 * @param cfrRptQty
	 */
	public void setCfrRptQty(String cfrRptQty) {
		this.cfrRptQty = cfrRptQty;
	}
	
	/**
	 * Column Info
	 * @param imdgSpclProviNo1
	 */
	public void setImdgSpclProviNo1(String imdgSpclProviNo1) {
		this.imdgSpclProviNo1 = imdgSpclProviNo1;
	}
	
	/**
	 * Column Info
	 * @param n1stImdgTnkInstrProviSeq
	 */
	public void setN1stImdgTnkInstrProviSeq(String n1stImdgTnkInstrProviSeq) {
		this.n1stImdgTnkInstrProviSeq = n1stImdgTnkInstrProviSeq;
	}
	
	/**
	 * Column Info
	 * @param imdgHtSrcStwgCd
	 */
	public void setImdgHtSrcStwgCd(String imdgHtSrcStwgCd) {
		this.imdgHtSrcStwgCd = imdgHtSrcStwgCd;
	}
	
	/**
	 * Column Info
	 * @param clrLivQtrStwgFlg
	 */
	public void setClrLivQtrStwgFlg(String clrLivQtrStwgFlg) {
		this.clrLivQtrStwgFlg = clrLivQtrStwgFlg;
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
	 * @param n1stImdgIbcInstrCd
	 */
	public void setN1stImdgIbcInstrCd(String n1stImdgIbcInstrCd) {
		this.n1stImdgIbcInstrCd = n1stImdgIbcInstrCd;
	}
	
	/**
	 * Column Info
	 * @param imdgStwgCateCd
	 */
	public void setImdgStwgCateCd(String imdgStwgCateCd) {
		this.imdgStwgCateCd = imdgStwgCateCd;
	}
	
	/**
	 * Column Info
	 * @param n3rdImdgIbcProviCd
	 */
	public void setN3rdImdgIbcProviCd(String n3rdImdgIbcProviCd) {
		this.n3rdImdgIbcProviCd = n3rdImdgIbcProviCd;
	}
	
	/**
	 * Column Info
	 * @param eaiEvntDt
	 */
	public void setEaiEvntDt(String eaiEvntDt) {
		this.eaiEvntDt = eaiEvntDt;
	}
	
	/**
	 * Column Info
	 * @param imdgLmtQtyDesc
	 */
	public void setImdgLmtQtyDesc(String imdgLmtQtyDesc) {
		this.imdgLmtQtyDesc = imdgLmtQtyDesc;
	}
	
	/**
	 * Column Info
	 * @param n5thImdgTnkInstrProviFile
	 */
	public void setN5thImdgTnkInstrProviFile(String n5thImdgTnkInstrProviFile) {
		this.n5thImdgTnkInstrProviFile = n5thImdgTnkInstrProviFile;
	}
	
	/**
	 * Column Info
	 * @param n5thImdgIbcInstrFile
	 */
	public void setN5thImdgIbcInstrFile(String n5thImdgIbcInstrFile) {
		this.n5thImdgIbcInstrFile = n5thImdgIbcInstrFile;
	}
	
	/**
	 * Column Info
	 * @param sprtHldFmImdgClssFlg
	 */
	public void setSprtHldFmImdgClssFlg(String sprtHldFmImdgClssFlg) {
		this.sprtHldFmImdgClssFlg = sprtHldFmImdgClssFlg;
	}
	
	/**
	 * Column Info
	 * @param imdgEmerNo
	 */
	public void setImdgEmerNo(String imdgEmerNo) {
		this.imdgEmerNo = imdgEmerNo;
	}
	
	/**
	 * Column Info
	 * @param n2ndBomPortTrstNo
	 */
	public void setN2ndBomPortTrstNo(String n2ndBomPortTrstNo) {
		this.n2ndBomPortTrstNo = n2ndBomPortTrstNo;
	}
	
	/**
	 * Column Info
	 * @param imdgEmerTemp
	 */
	public void setImdgEmerTemp(String imdgEmerTemp) {
		this.imdgEmerTemp = imdgEmerTemp;
	}
	
	/**
	 * Column Info
	 * @param hcdgTnkRstrDesc
	 */
	public void setHcdgTnkRstrDesc(String hcdgTnkRstrDesc) {
		this.hcdgTnkRstrDesc = hcdgTnkRstrDesc;
	}
	
	/**
	 * Column Info
	 * @param imdgMrnPolutCd
	 */
	public void setImdgMrnPolutCd(String imdgMrnPolutCd) {
		this.imdgMrnPolutCd = imdgMrnPolutCd;
	}
	
	/**
	 * Column Info
	 * @param cfrXtdClssCd
	 */
	public void setCfrXtdClssCd(String cfrXtdClssCd) {
		this.cfrXtdClssCd = cfrXtdClssCd;
	}
	
	/**
	 * Column Info
	 * @param hcdgDpndQtyFlg
	 */
	public void setHcdgDpndQtyFlg(String hcdgDpndQtyFlg) {
		this.hcdgDpndQtyFlg = hcdgDpndQtyFlg;
	}
	
	/**
	 * Column Info
	 * @param imdgSubsRskLblCd2
	 */
	public void setImdgSubsRskLblCd2(String imdgSubsRskLblCd2) {
		this.imdgSubsRskLblCd2 = imdgSubsRskLblCd2;
	}
	
	/**
	 * Column Info
	 * @param n1stImdgIbcProviFile
	 */
	public void setN1stImdgIbcProviFile(String n1stImdgIbcProviFile) {
		this.n1stImdgIbcProviFile = n1stImdgIbcProviFile;
	}
	
	/**
	 * Column Info
	 * @param imdgSubsRskLblCd1
	 */
	public void setImdgSubsRskLblCd1(String imdgSubsRskLblCd1) {
		this.imdgSubsRskLblCd1 = imdgSubsRskLblCd1;
	}
	
	/**
	 * Column Info
	 * @param prpShpNm
	 */
	public void setPrpShpNm(String prpShpNm) {
		this.prpShpNm = prpShpNm;
	}
	
	/**
	 * Column Info
	 * @param n1stImdgIbcInstrFile
	 */
	public void setN1stImdgIbcInstrFile(String n1stImdgIbcInstrFile) {
		this.n1stImdgIbcInstrFile = n1stImdgIbcInstrFile;
	}
	
	/**
	 * Column Info
	 * @param imdgSubsRskLblCd4
	 */
	public void setImdgSubsRskLblCd4(String imdgSubsRskLblCd4) {
		this.imdgSubsRskLblCd4 = imdgSubsRskLblCd4;
	}
	
	/**
	 * Column Info
	 * @param imdgSubsRskLblCd3
	 */
	public void setImdgSubsRskLblCd3(String imdgSubsRskLblCd3) {
		this.imdgSubsRskLblCd3 = imdgSubsRskLblCd3;
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
		setTotal(JSPUtil.getParameter(request, prefix + "total", ""));
		setN2ndImdgIbcProviSeq(JSPUtil.getParameter(request, prefix + "n2nd_imdg_ibc_provi_seq", ""));
		setN3rdImdgIbcInstrFile(JSPUtil.getParameter(request, prefix + "n3rd_imdg_ibc_instr_file", ""));
		setN2ndImdgPckProviCd(JSPUtil.getParameter(request, prefix + "n2nd_imdg_pck_provi_cd", ""));
		setCfrRstrOprNm(JSPUtil.getParameter(request, prefix + "cfr_rstr_opr_nm", ""));
		setN3rdImdgTnkInstrProviSeq(JSPUtil.getParameter(request, prefix + "n3rd_imdg_tnk_instr_provi_seq", ""));
		setImdgUnNoSeq(JSPUtil.getParameter(request, prefix + "imdg_un_no_seq", ""));
		setN2ndImdgUnTnkInstrCd(JSPUtil.getParameter(request, prefix + "n2nd_imdg_un_tnk_instr_cd", ""));
		setImdgSubsRskLblRmk(JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_rmk", ""));
		setN2ndImdgPckProviSeq(JSPUtil.getParameter(request, prefix + "n2nd_imdg_pck_provi_seq", ""));
		setN2ndImdgTnkInstrProviFile(JSPUtil.getParameter(request, prefix + "n2nd_imdg_tnk_instr_provi_file", ""));
		setImdgOrgRactTpCd(JSPUtil.getParameter(request, prefix + "imdg_org_ract_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setN1stImdgIbcInstrSeq(JSPUtil.getParameter(request, prefix + "n1st_imdg_ibc_instr_seq", ""));
		setImdgCompGrpCd(JSPUtil.getParameter(request, prefix + "imdg_comp_grp_cd", ""));
		setSegrDesc(JSPUtil.getParameter(request, prefix + "segr_desc", ""));
		setCfrDgWetCd(JSPUtil.getParameter(request, prefix + "cfr_dg_wet_cd", ""));
		setN4thImdgIbcInstrCd(JSPUtil.getParameter(request, prefix + "n4th_imdg_ibc_instr_cd", ""));
		setN1stImdgTnkInstrProviFile(JSPUtil.getParameter(request, prefix + "n1st_imdg_tnk_instr_provi_file", ""));
		setN3rdImdgPckProviSeq(JSPUtil.getParameter(request, prefix + "n3rd_imdg_pck_provi_seq", ""));
		setN5thImdgPckProviCd(JSPUtil.getParameter(request, prefix + "n5th_imdg_pck_provi_cd", ""));
		setN4thImdgIbcProviCd(JSPUtil.getParameter(request, prefix + "n4th_imdg_ibc_provi_cd", ""));
		setN5thImdgPckProviSeq(JSPUtil.getParameter(request, prefix + "n5th_imdg_pck_provi_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setHcdgFlg(JSPUtil.getParameter(request, prefix + "hcdg_flg", ""));
		setImdgUnNo(JSPUtil.getParameter(request, prefix + "imdg_un_no", ""));
		setN5thImdgIbcProviSeq(JSPUtil.getParameter(request, prefix + "n5th_imdg_ibc_provi_seq", ""));
		setN1stImdgUnTnkInstrSeq(JSPUtil.getParameter(request, prefix + "n1st_imdg_un_tnk_instr_seq", ""));
		setN3rdImdgPckInstrSeq(JSPUtil.getParameter(request, prefix + "n3rd_imdg_pck_instr_seq", ""));
		setN3rdImdgPckProviCd(JSPUtil.getParameter(request, prefix + "n3rd_imdg_pck_provi_cd", ""));
		setSprtFmImdgClssFlg(JSPUtil.getParameter(request, prefix + "sprt_fm_imdg_clss_flg", ""));
		setAwayFmImdgClssFlg(JSPUtil.getParameter(request, prefix + "away_fm_imdg_clss_flg", ""));
		setEaiIfFlg(JSPUtil.getParameter(request, prefix + "eai_if_flg", ""));
		setHcdgIntmdBcRstrDesc(JSPUtil.getParameter(request, prefix + "hcdg_intmd_bc_rstr_desc", ""));
		setN4thImdgTnkInstrProviFile(JSPUtil.getParameter(request, prefix + "n4th_imdg_tnk_instr_provi_file", ""));
		setN3rdImdgIbcInstrCd(JSPUtil.getParameter(request, prefix + "n3rd_imdg_ibc_instr_cd", ""));
		setSprtLonFmImdgClssCd(JSPUtil.getParameter(request, prefix + "sprt_lon_fm_imdg_clss_cd", ""));
		setN1stImdgUnTnkInstrFile(JSPUtil.getParameter(request, prefix + "n1st_imdg_un_tnk_instr_file", ""));
		setPageNo(JSPUtil.getParameter(request, prefix + "page_no", ""));
		setCfrRstrPortNm(JSPUtil.getParameter(request, prefix + "cfr_rstr_port_nm", ""));
		setEmerRspnGidNo(JSPUtil.getParameter(request, prefix + "emer_rspn_gid_no", ""));
		setN3rdImdgPckInstrFile(JSPUtil.getParameter(request, prefix + "n3rd_imdg_pck_instr_file", ""));
		setN2ndImdgIbcInstrSeq(JSPUtil.getParameter(request, prefix + "n2nd_imdg_ibc_instr_seq", ""));
		setN4thBomPortTrstNo(JSPUtil.getParameter(request, prefix + "n4th_bom_port_trst_no", ""));
		setImdgConcRtCtnt(JSPUtil.getParameter(request, prefix + "imdg_conc_rt_ctnt", ""));
		setN3rdImdgIbcProviFile(JSPUtil.getParameter(request, prefix + "n3rd_imdg_ibc_provi_file", ""));
		setImdgClssCd(JSPUtil.getParameter(request, prefix + "imdg_clss_cd", ""));
		setImdgPckGrpCd(JSPUtil.getParameter(request, prefix + "imdg_pck_grp_cd", ""));
		setN3rdImdgIbcInstrSeq(JSPUtil.getParameter(request, prefix + "n3rd_imdg_ibc_instr_seq", ""));
		setImdgLmtQtyMeasUtCd(JSPUtil.getParameter(request, prefix + "imdg_lmt_qty_meas_ut_cd", ""));
		setN1stBomPortTrstNo(JSPUtil.getParameter(request, prefix + "n1st_bom_port_trst_no", ""));
		setImdgLmtQty(JSPUtil.getParameter(request, prefix + "imdg_lmt_qty", ""));
		setN3rdBomPortTrstNo(JSPUtil.getParameter(request, prefix + "n3rd_bom_port_trst_no", ""));
		setN4thImdgIbcInstrSeq(JSPUtil.getParameter(request, prefix + "n4th_imdg_ibc_instr_seq", ""));
		setSprtHldFmImdgClssCd(JSPUtil.getParameter(request, prefix + "sprt_hld_fm_imdg_clss_cd", ""));
		setFlshPntTempCtnt(JSPUtil.getParameter(request, prefix + "flsh_pnt_temp_ctnt", ""));
		setN2ndImdgUnTnkInstrSeq(JSPUtil.getParameter(request, prefix + "n2nd_imdg_un_tnk_instr_seq", ""));
		setCfrPsnInhZnCd(JSPUtil.getParameter(request, prefix + "cfr_psn_inh_zn_cd", ""));
		setImdgTecNm(JSPUtil.getParameter(request, prefix + "imdg_tec_nm", ""));
		setAwayFmImdgClssCd(JSPUtil.getParameter(request, prefix + "away_fm_imdg_clss_cd", ""));
		setN3rdImdgTnkInstrProviCd(JSPUtil.getParameter(request, prefix + "n3rd_imdg_tnk_instr_provi_cd", ""));
		setN3rdImdgPckProviFile(JSPUtil.getParameter(request, prefix + "n3rd_imdg_pck_provi_file", ""));
		setImdgSbstPptDesc(JSPUtil.getParameter(request, prefix + "imdg_sbst_ppt_desc", ""));
		setN1stImdgTnkInstrProviCd(JSPUtil.getParameter(request, prefix + "n1st_imdg_tnk_instr_provi_cd", ""));
		setN2ndImdgIbcInstrCd(JSPUtil.getParameter(request, prefix + "n2nd_imdg_ibc_instr_cd", ""));
		setImdgFdStufStwgCd(JSPUtil.getParameter(request, prefix + "imdg_fd_stuf_stwg_cd", ""));
		setImdgSubsRskLblCd(JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_cd", ""));
		setCfrToxcCd(JSPUtil.getParameter(request, prefix + "cfr_toxc_cd", ""));
		setImdgExptQtyDesc(JSPUtil.getParameter(request, prefix + "imdg_expt_qty_desc", ""));
		setImdgPckMzdCd(JSPUtil.getParameter(request, prefix + "imdg_pck_mzd_cd", ""));
		setHcdgTnkRstrDesc3(JSPUtil.getParameter(request, prefix + "hcdg_tnk_rstr_desc3", ""));
		setHcdgTnkRstrDesc4(JSPUtil.getParameter(request, prefix + "hcdg_tnk_rstr_desc4", ""));
		setN1stImdgPckInstrFile(JSPUtil.getParameter(request, prefix + "n1st_imdg_pck_instr_file", ""));
		setN2ndImdgPckInstrSeq(JSPUtil.getParameter(request, prefix + "n2nd_imdg_pck_instr_seq", ""));
		setHcdgTnkRstrDesc2(JSPUtil.getParameter(request, prefix + "hcdg_tnk_rstr_desc2", ""));
		setHcdgTnkRstrDesc1(JSPUtil.getParameter(request, prefix + "hcdg_tnk_rstr_desc1", ""));
		setSprtDpSeq(JSPUtil.getParameter(request, prefix + "sprt_dp_seq", ""));
		setN2ndImdgTnkInstrProviCd(JSPUtil.getParameter(request, prefix + "n2nd_imdg_tnk_instr_provi_cd", ""));
		setN1stImdgUnTnkInstrCd(JSPUtil.getParameter(request, prefix + "n1st_imdg_un_tnk_instr_cd", ""));
		setN5thImdgIbcProviFile(JSPUtil.getParameter(request, prefix + "n5th_imdg_ibc_provi_file", ""));
		setN3rdImdgTnkInstrProviFile(JSPUtil.getParameter(request, prefix + "n3rd_imdg_tnk_instr_provi_file", ""));
		setN5thImdgTnkInstrProviSeq(JSPUtil.getParameter(request, prefix + "n5th_imdg_tnk_instr_provi_seq", ""));
		setN2ndImdgPckInstrFile(JSPUtil.getParameter(request, prefix + "n2nd_imdg_pck_instr_file", ""));
		setSprtFmImdgClssCd(JSPUtil.getParameter(request, prefix + "sprt_fm_imdg_clss_cd", ""));
		setAwayFmImdgSegrGrpFlg(JSPUtil.getParameter(request, prefix + "away_fm_imdg_segr_grp_flg", ""));
		setHcdgRmk(JSPUtil.getParameter(request, prefix + "hcdg_rmk", ""));
		setPsaNo(JSPUtil.getParameter(request, prefix + "psa_no", ""));
		setN2ndImdgUnTnkInstrFile(JSPUtil.getParameter(request, prefix + "n2nd_imdg_un_tnk_instr_file", ""));
		setN2ndImdgPckInstrCd(JSPUtil.getParameter(request, prefix + "n2nd_imdg_pck_instr_cd", ""));
		setN1stImdgIbcProviCd(JSPUtil.getParameter(request, prefix + "n1st_imdg_ibc_provi_cd", ""));
		setN1stImdgPckInstrSeq(JSPUtil.getParameter(request, prefix + "n1st_imdg_pck_instr_seq", ""));
		setImdgSpclProviNo(JSPUtil.getParameter(request, prefix + "imdg_spcl_provi_no", ""));
		setImdgCrrRstrExptNm(JSPUtil.getParameter(request, prefix + "imdg_crr_rstr_expt_nm", ""));
		setN1stImdgPckProviSeq(JSPUtil.getParameter(request, prefix + "n1st_imdg_pck_provi_seq", ""));
		setN4thImdgPckProviCd(JSPUtil.getParameter(request, prefix + "n4th_imdg_pck_provi_cd", ""));
		setN1stImdgIbcProviSeq(JSPUtil.getParameter(request, prefix + "n1st_imdg_ibc_provi_seq", ""));
		setN3rdImdgIbcProviSeq(JSPUtil.getParameter(request, prefix + "n3rd_imdg_ibc_provi_seq", ""));
		setN3rdImdgPckInstrCd(JSPUtil.getParameter(request, prefix + "n3rd_imdg_pck_instr_cd", ""));
		setSprtFmImdgSegrGrpFlg(JSPUtil.getParameter(request, prefix + "sprt_fm_imdg_segr_grp_flg", ""));
		setN1stImdgPckInstrCd(JSPUtil.getParameter(request, prefix + "n1st_imdg_pck_instr_cd", ""));
		setN4thImdgIbcProviSeq(JSPUtil.getParameter(request, prefix + "n4th_imdg_ibc_provi_seq", ""));
		setN5thImdgIbcInstrCd(JSPUtil.getParameter(request, prefix + "n5th_imdg_ibc_instr_cd", ""));
		setN4thImdgTnkInstrProviCd(JSPUtil.getParameter(request, prefix + "n4th_imdg_tnk_instr_provi_cd", ""));
		setImdgSpclProviNo8(JSPUtil.getParameter(request, prefix + "imdg_spcl_provi_no8", ""));
		setImdgUnNoHldFlg(JSPUtil.getParameter(request, prefix + "imdg_un_no_hld_flg", ""));
		setImdgSpclProviNo4(JSPUtil.getParameter(request, prefix + "imdg_spcl_provi_no4", ""));
		setImdgSpclProviNo5(JSPUtil.getParameter(request, prefix + "imdg_spcl_provi_no5", ""));
		setImdgSpclProviNo6(JSPUtil.getParameter(request, prefix + "imdg_spcl_provi_no6", ""));
		setImdgSpclProviNo7(JSPUtil.getParameter(request, prefix + "imdg_spcl_provi_no7", ""));
		setN1stImdgPckProviFile(JSPUtil.getParameter(request, prefix + "n1st_imdg_pck_provi_file", ""));
		setN2ndImdgPckProviFile(JSPUtil.getParameter(request, prefix + "n2nd_imdg_pck_provi_file", ""));
		setSprtLonFmImdgClssFlg(JSPUtil.getParameter(request, prefix + "sprt_lon_fm_imdg_clss_flg", ""));
		setN2ndImdgIbcInstrFile(JSPUtil.getParameter(request, prefix + "n2nd_imdg_ibc_instr_file", ""));
		setSegrAsForImdgClssCd(JSPUtil.getParameter(request, prefix + "segr_as_for_imdg_clss_cd", ""));
		setN5thImdgTnkInstrProviCd(JSPUtil.getParameter(request, prefix + "n5th_imdg_tnk_instr_provi_cd", ""));
		setN5thImdgPckProviFile(JSPUtil.getParameter(request, prefix + "n5th_imdg_pck_provi_file", ""));
		setAwayDpSeq(JSPUtil.getParameter(request, prefix + "away_dp_seq", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setN5thImdgIbcInstrSeq(JSPUtil.getParameter(request, prefix + "n5th_imdg_ibc_instr_seq", ""));
		setN4thImdgTnkInstrProviSeq(JSPUtil.getParameter(request, prefix + "n4th_imdg_tnk_instr_provi_seq", ""));
		setEmerRspnGidChrNo(JSPUtil.getParameter(request, prefix + "emer_rspn_gid_chr_no", ""));
		setRowNum(JSPUtil.getParameter(request, prefix + "row_num", ""));
		setN2ndImdgTnkInstrProviSeq(JSPUtil.getParameter(request, prefix + "n2nd_imdg_tnk_instr_provi_seq", ""));
		setN4thImdgPckProviSeq(JSPUtil.getParameter(request, prefix + "n4th_imdg_pck_provi_seq", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setEaiIfId(JSPUtil.getParameter(request, prefix + "eai_if_id", ""));
		setPkgAuthNo(JSPUtil.getParameter(request, prefix + "pkg_auth_no", ""));
		setN4thImdgPckProviFile(JSPUtil.getParameter(request, prefix + "n4th_imdg_pck_provi_file", ""));
		setN5thImdgIbcProviCd(JSPUtil.getParameter(request, prefix + "n5th_imdg_ibc_provi_cd", ""));
		setSegrAsForImdgClssFlg(JSPUtil.getParameter(request, prefix + "segr_as_for_imdg_clss_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setN2ndImdgIbcProviCd(JSPUtil.getParameter(request, prefix + "n2nd_imdg_ibc_provi_cd", ""));
		setImdgExptQtyCd(JSPUtil.getParameter(request, prefix + "imdg_expt_qty_cd", ""));
		setLkPortAuthNo(JSPUtil.getParameter(request, prefix + "lk_port_auth_no", ""));
		setN1stImdgPckProviCd(JSPUtil.getParameter(request, prefix + "n1st_imdg_pck_provi_cd", ""));
		setN2ndImdgIbcProviFile(JSPUtil.getParameter(request, prefix + "n2nd_imdg_ibc_provi_file", ""));
		setImdgCrrRstrExptCd(JSPUtil.getParameter(request, prefix + "imdg_crr_rstr_expt_cd", ""));
		setImdgCtrlTemp(JSPUtil.getParameter(request, prefix + "imdg_ctrl_temp", ""));
		setHcdgPckRstrDesc(JSPUtil.getParameter(request, prefix + "hcdg_pck_rstr_desc", ""));
		setN4thImdgIbcInstrFile(JSPUtil.getParameter(request, prefix + "n4th_imdg_ibc_instr_file", ""));
		setImdgSpclProviNo3(JSPUtil.getParameter(request, prefix + "imdg_spcl_provi_no3", ""));
		setN4thImdgIbcProviFile(JSPUtil.getParameter(request, prefix + "n4th_imdg_ibc_provi_file", ""));
		setImdgSpclProviNo2(JSPUtil.getParameter(request, prefix + "imdg_spcl_provi_no2", ""));
		setCfrRptQty(JSPUtil.getParameter(request, prefix + "cfr_rpt_qty", ""));
		setImdgSpclProviNo1(JSPUtil.getParameter(request, prefix + "imdg_spcl_provi_no1", ""));
		setN1stImdgTnkInstrProviSeq(JSPUtil.getParameter(request, prefix + "n1st_imdg_tnk_instr_provi_seq", ""));
		setImdgHtSrcStwgCd(JSPUtil.getParameter(request, prefix + "imdg_ht_src_stwg_cd", ""));
		setClrLivQtrStwgFlg(JSPUtil.getParameter(request, prefix + "clr_liv_qtr_stwg_flg", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setN1stImdgIbcInstrCd(JSPUtil.getParameter(request, prefix + "n1st_imdg_ibc_instr_cd", ""));
		setImdgStwgCateCd(JSPUtil.getParameter(request, prefix + "imdg_stwg_cate_cd", ""));
		setN3rdImdgIbcProviCd(JSPUtil.getParameter(request, prefix + "n3rd_imdg_ibc_provi_cd", ""));
		setEaiEvntDt(JSPUtil.getParameter(request, prefix + "eai_evnt_dt", ""));
		setImdgLmtQtyDesc(JSPUtil.getParameter(request, prefix + "imdg_lmt_qty_desc", ""));
		setN5thImdgTnkInstrProviFile(JSPUtil.getParameter(request, prefix + "n5th_imdg_tnk_instr_provi_file", ""));
		setN5thImdgIbcInstrFile(JSPUtil.getParameter(request, prefix + "n5th_imdg_ibc_instr_file", ""));
		setSprtHldFmImdgClssFlg(JSPUtil.getParameter(request, prefix + "sprt_hld_fm_imdg_clss_flg", ""));
		setImdgEmerNo(JSPUtil.getParameter(request, prefix + "imdg_emer_no", ""));
		setN2ndBomPortTrstNo(JSPUtil.getParameter(request, prefix + "n2nd_bom_port_trst_no", ""));
		setImdgEmerTemp(JSPUtil.getParameter(request, prefix + "imdg_emer_temp", ""));
		setHcdgTnkRstrDesc(JSPUtil.getParameter(request, prefix + "hcdg_tnk_rstr_desc", ""));
		setImdgMrnPolutCd(JSPUtil.getParameter(request, prefix + "imdg_mrn_polut_cd", ""));
		setCfrXtdClssCd(JSPUtil.getParameter(request, prefix + "cfr_xtd_clss_cd", ""));
		setHcdgDpndQtyFlg(JSPUtil.getParameter(request, prefix + "hcdg_dpnd_qty_flg", ""));
		setImdgSubsRskLblCd2(JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_cd2", ""));
		setN1stImdgIbcProviFile(JSPUtil.getParameter(request, prefix + "n1st_imdg_ibc_provi_file", ""));
		setImdgSubsRskLblCd1(JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_cd1", ""));
		setPrpShpNm(JSPUtil.getParameter(request, prefix + "prp_shp_nm", ""));
		setN1stImdgIbcInstrFile(JSPUtil.getParameter(request, prefix + "n1st_imdg_ibc_instr_file", ""));
		setImdgSubsRskLblCd4(JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_cd4", ""));
		setImdgSubsRskLblCd3(JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_cd3", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UNNumberListOptionaVO[]
	 */
	public UNNumberListOptionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UNNumberListOptionaVO[]
	 */
	public UNNumberListOptionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UNNumberListOptionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] total = (JSPUtil.getParameter(request, prefix	+ "total", length));
			String[] n2ndImdgIbcProviSeq = (JSPUtil.getParameter(request, prefix	+ "n2nd_imdg_ibc_provi_seq", length));
			String[] n3rdImdgIbcInstrFile = (JSPUtil.getParameter(request, prefix	+ "n3rd_imdg_ibc_instr_file", length));
			String[] n2ndImdgPckProviCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_imdg_pck_provi_cd", length));
			String[] cfrRstrOprNm = (JSPUtil.getParameter(request, prefix	+ "cfr_rstr_opr_nm", length));
			String[] n3rdImdgTnkInstrProviSeq = (JSPUtil.getParameter(request, prefix	+ "n3rd_imdg_tnk_instr_provi_seq", length));
			String[] imdgUnNoSeq = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no_seq", length));
			String[] n2ndImdgUnTnkInstrCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_imdg_un_tnk_instr_cd", length));
			String[] imdgSubsRskLblRmk = (JSPUtil.getParameter(request, prefix	+ "imdg_subs_rsk_lbl_rmk", length));
			String[] n2ndImdgPckProviSeq = (JSPUtil.getParameter(request, prefix	+ "n2nd_imdg_pck_provi_seq", length));
			String[] n2ndImdgTnkInstrProviFile = (JSPUtil.getParameter(request, prefix	+ "n2nd_imdg_tnk_instr_provi_file", length));
			String[] imdgOrgRactTpCd = (JSPUtil.getParameter(request, prefix	+ "imdg_org_ract_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] n1stImdgIbcInstrSeq = (JSPUtil.getParameter(request, prefix	+ "n1st_imdg_ibc_instr_seq", length));
			String[] imdgCompGrpCd = (JSPUtil.getParameter(request, prefix	+ "imdg_comp_grp_cd", length));
			String[] segrDesc = (JSPUtil.getParameter(request, prefix	+ "segr_desc", length));
			String[] cfrDgWetCd = (JSPUtil.getParameter(request, prefix	+ "cfr_dg_wet_cd", length));
			String[] n4thImdgIbcInstrCd = (JSPUtil.getParameter(request, prefix	+ "n4th_imdg_ibc_instr_cd", length));
			String[] n1stImdgTnkInstrProviFile = (JSPUtil.getParameter(request, prefix	+ "n1st_imdg_tnk_instr_provi_file", length));
			String[] n3rdImdgPckProviSeq = (JSPUtil.getParameter(request, prefix	+ "n3rd_imdg_pck_provi_seq", length));
			String[] n5thImdgPckProviCd = (JSPUtil.getParameter(request, prefix	+ "n5th_imdg_pck_provi_cd", length));
			String[] n4thImdgIbcProviCd = (JSPUtil.getParameter(request, prefix	+ "n4th_imdg_ibc_provi_cd", length));
			String[] n5thImdgPckProviSeq = (JSPUtil.getParameter(request, prefix	+ "n5th_imdg_pck_provi_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] hcdgFlg = (JSPUtil.getParameter(request, prefix	+ "hcdg_flg", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			String[] n5thImdgIbcProviSeq = (JSPUtil.getParameter(request, prefix	+ "n5th_imdg_ibc_provi_seq", length));
			String[] n1stImdgUnTnkInstrSeq = (JSPUtil.getParameter(request, prefix	+ "n1st_imdg_un_tnk_instr_seq", length));
			String[] n3rdImdgPckInstrSeq = (JSPUtil.getParameter(request, prefix	+ "n3rd_imdg_pck_instr_seq", length));
			String[] n3rdImdgPckProviCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_imdg_pck_provi_cd", length));
			String[] sprtFmImdgClssFlg = (JSPUtil.getParameter(request, prefix	+ "sprt_fm_imdg_clss_flg", length));
			String[] awayFmImdgClssFlg = (JSPUtil.getParameter(request, prefix	+ "away_fm_imdg_clss_flg", length));
			String[] eaiIfFlg = (JSPUtil.getParameter(request, prefix	+ "eai_if_flg", length));
			String[] hcdgIntmdBcRstrDesc = (JSPUtil.getParameter(request, prefix	+ "hcdg_intmd_bc_rstr_desc", length));
			String[] n4thImdgTnkInstrProviFile = (JSPUtil.getParameter(request, prefix	+ "n4th_imdg_tnk_instr_provi_file", length));
			String[] n3rdImdgIbcInstrCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_imdg_ibc_instr_cd", length));
			String[] sprtLonFmImdgClssCd = (JSPUtil.getParameter(request, prefix	+ "sprt_lon_fm_imdg_clss_cd", length));
			String[] n1stImdgUnTnkInstrFile = (JSPUtil.getParameter(request, prefix	+ "n1st_imdg_un_tnk_instr_file", length));
			String[] pageNo = (JSPUtil.getParameter(request, prefix	+ "page_no", length));
			String[] cfrRstrPortNm = (JSPUtil.getParameter(request, prefix	+ "cfr_rstr_port_nm", length));
			String[] emerRspnGidNo = (JSPUtil.getParameter(request, prefix	+ "emer_rspn_gid_no", length));
			String[] n3rdImdgPckInstrFile = (JSPUtil.getParameter(request, prefix	+ "n3rd_imdg_pck_instr_file", length));
			String[] n2ndImdgIbcInstrSeq = (JSPUtil.getParameter(request, prefix	+ "n2nd_imdg_ibc_instr_seq", length));
			String[] n4thBomPortTrstNo = (JSPUtil.getParameter(request, prefix	+ "n4th_bom_port_trst_no", length));
			String[] imdgConcRtCtnt = (JSPUtil.getParameter(request, prefix	+ "imdg_conc_rt_ctnt", length));
			String[] n3rdImdgIbcProviFile = (JSPUtil.getParameter(request, prefix	+ "n3rd_imdg_ibc_provi_file", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			String[] imdgPckGrpCd = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_grp_cd", length));
			String[] n3rdImdgIbcInstrSeq = (JSPUtil.getParameter(request, prefix	+ "n3rd_imdg_ibc_instr_seq", length));
			String[] imdgLmtQtyMeasUtCd = (JSPUtil.getParameter(request, prefix	+ "imdg_lmt_qty_meas_ut_cd", length));
			String[] n1stBomPortTrstNo = (JSPUtil.getParameter(request, prefix	+ "n1st_bom_port_trst_no", length));
			String[] imdgLmtQty = (JSPUtil.getParameter(request, prefix	+ "imdg_lmt_qty", length));
			String[] n3rdBomPortTrstNo = (JSPUtil.getParameter(request, prefix	+ "n3rd_bom_port_trst_no", length));
			String[] n4thImdgIbcInstrSeq = (JSPUtil.getParameter(request, prefix	+ "n4th_imdg_ibc_instr_seq", length));
			String[] sprtHldFmImdgClssCd = (JSPUtil.getParameter(request, prefix	+ "sprt_hld_fm_imdg_clss_cd", length));
			String[] flshPntTempCtnt = (JSPUtil.getParameter(request, prefix	+ "flsh_pnt_temp_ctnt", length));
			String[] n2ndImdgUnTnkInstrSeq = (JSPUtil.getParameter(request, prefix	+ "n2nd_imdg_un_tnk_instr_seq", length));
			String[] cfrPsnInhZnCd = (JSPUtil.getParameter(request, prefix	+ "cfr_psn_inh_zn_cd", length));
			String[] imdgTecNm = (JSPUtil.getParameter(request, prefix	+ "imdg_tec_nm", length));
			String[] awayFmImdgClssCd = (JSPUtil.getParameter(request, prefix	+ "away_fm_imdg_clss_cd", length));
			String[] n3rdImdgTnkInstrProviCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_imdg_tnk_instr_provi_cd", length));
			String[] n3rdImdgPckProviFile = (JSPUtil.getParameter(request, prefix	+ "n3rd_imdg_pck_provi_file", length));
			String[] imdgSbstPptDesc = (JSPUtil.getParameter(request, prefix	+ "imdg_sbst_ppt_desc", length));
			String[] n1stImdgTnkInstrProviCd = (JSPUtil.getParameter(request, prefix	+ "n1st_imdg_tnk_instr_provi_cd", length));
			String[] n2ndImdgIbcInstrCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_imdg_ibc_instr_cd", length));
			String[] imdgFdStufStwgCd = (JSPUtil.getParameter(request, prefix	+ "imdg_fd_stuf_stwg_cd", length));
			String[] imdgSubsRskLblCd = (JSPUtil.getParameter(request, prefix	+ "imdg_subs_rsk_lbl_cd", length));
			String[] cfrToxcCd = (JSPUtil.getParameter(request, prefix	+ "cfr_toxc_cd", length));
			String[] imdgExptQtyDesc = (JSPUtil.getParameter(request, prefix	+ "imdg_expt_qty_desc", length));
			String[] imdgPckMzdCd = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_mzd_cd", length));
			String[] hcdgTnkRstrDesc3 = (JSPUtil.getParameter(request, prefix	+ "hcdg_tnk_rstr_desc3", length));
			String[] hcdgTnkRstrDesc4 = (JSPUtil.getParameter(request, prefix	+ "hcdg_tnk_rstr_desc4", length));
			String[] n1stImdgPckInstrFile = (JSPUtil.getParameter(request, prefix	+ "n1st_imdg_pck_instr_file", length));
			String[] n2ndImdgPckInstrSeq = (JSPUtil.getParameter(request, prefix	+ "n2nd_imdg_pck_instr_seq", length));
			String[] hcdgTnkRstrDesc2 = (JSPUtil.getParameter(request, prefix	+ "hcdg_tnk_rstr_desc2", length));
			String[] hcdgTnkRstrDesc1 = (JSPUtil.getParameter(request, prefix	+ "hcdg_tnk_rstr_desc1", length));
			String[] sprtDpSeq = (JSPUtil.getParameter(request, prefix	+ "sprt_dp_seq", length));
			String[] n2ndImdgTnkInstrProviCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_imdg_tnk_instr_provi_cd", length));
			String[] n1stImdgUnTnkInstrCd = (JSPUtil.getParameter(request, prefix	+ "n1st_imdg_un_tnk_instr_cd", length));
			String[] n5thImdgIbcProviFile = (JSPUtil.getParameter(request, prefix	+ "n5th_imdg_ibc_provi_file", length));
			String[] n3rdImdgTnkInstrProviFile = (JSPUtil.getParameter(request, prefix	+ "n3rd_imdg_tnk_instr_provi_file", length));
			String[] n5thImdgTnkInstrProviSeq = (JSPUtil.getParameter(request, prefix	+ "n5th_imdg_tnk_instr_provi_seq", length));
			String[] n2ndImdgPckInstrFile = (JSPUtil.getParameter(request, prefix	+ "n2nd_imdg_pck_instr_file", length));
			String[] sprtFmImdgClssCd = (JSPUtil.getParameter(request, prefix	+ "sprt_fm_imdg_clss_cd", length));
			String[] awayFmImdgSegrGrpFlg = (JSPUtil.getParameter(request, prefix	+ "away_fm_imdg_segr_grp_flg", length));
			String[] hcdgRmk = (JSPUtil.getParameter(request, prefix	+ "hcdg_rmk", length));
			String[] psaNo = (JSPUtil.getParameter(request, prefix	+ "psa_no", length));
			String[] n2ndImdgUnTnkInstrFile = (JSPUtil.getParameter(request, prefix	+ "n2nd_imdg_un_tnk_instr_file", length));
			String[] n2ndImdgPckInstrCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_imdg_pck_instr_cd", length));
			String[] n1stImdgIbcProviCd = (JSPUtil.getParameter(request, prefix	+ "n1st_imdg_ibc_provi_cd", length));
			String[] n1stImdgPckInstrSeq = (JSPUtil.getParameter(request, prefix	+ "n1st_imdg_pck_instr_seq", length));
			String[] imdgSpclProviNo = (JSPUtil.getParameter(request, prefix	+ "imdg_spcl_provi_no", length));
			String[] imdgCrrRstrExptNm = (JSPUtil.getParameter(request, prefix	+ "imdg_crr_rstr_expt_nm", length));
			String[] n1stImdgPckProviSeq = (JSPUtil.getParameter(request, prefix	+ "n1st_imdg_pck_provi_seq", length));
			String[] n4thImdgPckProviCd = (JSPUtil.getParameter(request, prefix	+ "n4th_imdg_pck_provi_cd", length));
			String[] n1stImdgIbcProviSeq = (JSPUtil.getParameter(request, prefix	+ "n1st_imdg_ibc_provi_seq", length));
			String[] n3rdImdgIbcProviSeq = (JSPUtil.getParameter(request, prefix	+ "n3rd_imdg_ibc_provi_seq", length));
			String[] n3rdImdgPckInstrCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_imdg_pck_instr_cd", length));
			String[] sprtFmImdgSegrGrpFlg = (JSPUtil.getParameter(request, prefix	+ "sprt_fm_imdg_segr_grp_flg", length));
			String[] n1stImdgPckInstrCd = (JSPUtil.getParameter(request, prefix	+ "n1st_imdg_pck_instr_cd", length));
			String[] n4thImdgIbcProviSeq = (JSPUtil.getParameter(request, prefix	+ "n4th_imdg_ibc_provi_seq", length));
			String[] n5thImdgIbcInstrCd = (JSPUtil.getParameter(request, prefix	+ "n5th_imdg_ibc_instr_cd", length));
			String[] n4thImdgTnkInstrProviCd = (JSPUtil.getParameter(request, prefix	+ "n4th_imdg_tnk_instr_provi_cd", length));
			String[] imdgSpclProviNo8 = (JSPUtil.getParameter(request, prefix	+ "imdg_spcl_provi_no8", length));
			String[] imdgUnNoHldFlg = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no_hld_flg", length));
			String[] imdgSpclProviNo4 = (JSPUtil.getParameter(request, prefix	+ "imdg_spcl_provi_no4", length));
			String[] imdgSpclProviNo5 = (JSPUtil.getParameter(request, prefix	+ "imdg_spcl_provi_no5", length));
			String[] imdgSpclProviNo6 = (JSPUtil.getParameter(request, prefix	+ "imdg_spcl_provi_no6", length));
			String[] imdgSpclProviNo7 = (JSPUtil.getParameter(request, prefix	+ "imdg_spcl_provi_no7", length));
			String[] n1stImdgPckProviFile = (JSPUtil.getParameter(request, prefix	+ "n1st_imdg_pck_provi_file", length));
			String[] n2ndImdgPckProviFile = (JSPUtil.getParameter(request, prefix	+ "n2nd_imdg_pck_provi_file", length));
			String[] sprtLonFmImdgClssFlg = (JSPUtil.getParameter(request, prefix	+ "sprt_lon_fm_imdg_clss_flg", length));
			String[] n2ndImdgIbcInstrFile = (JSPUtil.getParameter(request, prefix	+ "n2nd_imdg_ibc_instr_file", length));
			String[] segrAsForImdgClssCd = (JSPUtil.getParameter(request, prefix	+ "segr_as_for_imdg_clss_cd", length));
			String[] n5thImdgTnkInstrProviCd = (JSPUtil.getParameter(request, prefix	+ "n5th_imdg_tnk_instr_provi_cd", length));
			String[] n5thImdgPckProviFile = (JSPUtil.getParameter(request, prefix	+ "n5th_imdg_pck_provi_file", length));
			String[] awayDpSeq = (JSPUtil.getParameter(request, prefix	+ "away_dp_seq", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] n5thImdgIbcInstrSeq = (JSPUtil.getParameter(request, prefix	+ "n5th_imdg_ibc_instr_seq", length));
			String[] n4thImdgTnkInstrProviSeq = (JSPUtil.getParameter(request, prefix	+ "n4th_imdg_tnk_instr_provi_seq", length));
			String[] emerRspnGidChrNo = (JSPUtil.getParameter(request, prefix	+ "emer_rspn_gid_chr_no", length));
			String[] rowNum = (JSPUtil.getParameter(request, prefix	+ "row_num", length));
			String[] n2ndImdgTnkInstrProviSeq = (JSPUtil.getParameter(request, prefix	+ "n2nd_imdg_tnk_instr_provi_seq", length));
			String[] n4thImdgPckProviSeq = (JSPUtil.getParameter(request, prefix	+ "n4th_imdg_pck_provi_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] eaiIfId = (JSPUtil.getParameter(request, prefix	+ "eai_if_id", length));
			String[] pkgAuthNo = (JSPUtil.getParameter(request, prefix	+ "pkg_auth_no", length));
			String[] n4thImdgPckProviFile = (JSPUtil.getParameter(request, prefix	+ "n4th_imdg_pck_provi_file", length));
			String[] n5thImdgIbcProviCd = (JSPUtil.getParameter(request, prefix	+ "n5th_imdg_ibc_provi_cd", length));
			String[] segrAsForImdgClssFlg = (JSPUtil.getParameter(request, prefix	+ "segr_as_for_imdg_clss_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] n2ndImdgIbcProviCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_imdg_ibc_provi_cd", length));
			String[] imdgExptQtyCd = (JSPUtil.getParameter(request, prefix	+ "imdg_expt_qty_cd", length));
			String[] lkPortAuthNo = (JSPUtil.getParameter(request, prefix	+ "lk_port_auth_no", length));
			String[] n1stImdgPckProviCd = (JSPUtil.getParameter(request, prefix	+ "n1st_imdg_pck_provi_cd", length));
			String[] n2ndImdgIbcProviFile = (JSPUtil.getParameter(request, prefix	+ "n2nd_imdg_ibc_provi_file", length));
			String[] imdgCrrRstrExptCd = (JSPUtil.getParameter(request, prefix	+ "imdg_crr_rstr_expt_cd", length));
			String[] imdgCtrlTemp = (JSPUtil.getParameter(request, prefix	+ "imdg_ctrl_temp", length));
			String[] hcdgPckRstrDesc = (JSPUtil.getParameter(request, prefix	+ "hcdg_pck_rstr_desc", length));
			String[] n4thImdgIbcInstrFile = (JSPUtil.getParameter(request, prefix	+ "n4th_imdg_ibc_instr_file", length));
			String[] imdgSpclProviNo3 = (JSPUtil.getParameter(request, prefix	+ "imdg_spcl_provi_no3", length));
			String[] n4thImdgIbcProviFile = (JSPUtil.getParameter(request, prefix	+ "n4th_imdg_ibc_provi_file", length));
			String[] imdgSpclProviNo2 = (JSPUtil.getParameter(request, prefix	+ "imdg_spcl_provi_no2", length));
			String[] cfrRptQty = (JSPUtil.getParameter(request, prefix	+ "cfr_rpt_qty", length));
			String[] imdgSpclProviNo1 = (JSPUtil.getParameter(request, prefix	+ "imdg_spcl_provi_no1", length));
			String[] n1stImdgTnkInstrProviSeq = (JSPUtil.getParameter(request, prefix	+ "n1st_imdg_tnk_instr_provi_seq", length));
			String[] imdgHtSrcStwgCd = (JSPUtil.getParameter(request, prefix	+ "imdg_ht_src_stwg_cd", length));
			String[] clrLivQtrStwgFlg = (JSPUtil.getParameter(request, prefix	+ "clr_liv_qtr_stwg_flg", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] n1stImdgIbcInstrCd = (JSPUtil.getParameter(request, prefix	+ "n1st_imdg_ibc_instr_cd", length));
			String[] imdgStwgCateCd = (JSPUtil.getParameter(request, prefix	+ "imdg_stwg_cate_cd", length));
			String[] n3rdImdgIbcProviCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_imdg_ibc_provi_cd", length));
			String[] eaiEvntDt = (JSPUtil.getParameter(request, prefix	+ "eai_evnt_dt", length));
			String[] imdgLmtQtyDesc = (JSPUtil.getParameter(request, prefix	+ "imdg_lmt_qty_desc", length));
			String[] n5thImdgTnkInstrProviFile = (JSPUtil.getParameter(request, prefix	+ "n5th_imdg_tnk_instr_provi_file", length));
			String[] n5thImdgIbcInstrFile = (JSPUtil.getParameter(request, prefix	+ "n5th_imdg_ibc_instr_file", length));
			String[] sprtHldFmImdgClssFlg = (JSPUtil.getParameter(request, prefix	+ "sprt_hld_fm_imdg_clss_flg", length));
			String[] imdgEmerNo = (JSPUtil.getParameter(request, prefix	+ "imdg_emer_no", length));
			String[] n2ndBomPortTrstNo = (JSPUtil.getParameter(request, prefix	+ "n2nd_bom_port_trst_no", length));
			String[] imdgEmerTemp = (JSPUtil.getParameter(request, prefix	+ "imdg_emer_temp", length));
			String[] hcdgTnkRstrDesc = (JSPUtil.getParameter(request, prefix	+ "hcdg_tnk_rstr_desc", length));
			String[] imdgMrnPolutCd = (JSPUtil.getParameter(request, prefix	+ "imdg_mrn_polut_cd", length));
			String[] cfrXtdClssCd = (JSPUtil.getParameter(request, prefix	+ "cfr_xtd_clss_cd", length));
			String[] hcdgDpndQtyFlg = (JSPUtil.getParameter(request, prefix	+ "hcdg_dpnd_qty_flg", length));
			String[] imdgSubsRskLblCd2 = (JSPUtil.getParameter(request, prefix	+ "imdg_subs_rsk_lbl_cd2", length));
			String[] n1stImdgIbcProviFile = (JSPUtil.getParameter(request, prefix	+ "n1st_imdg_ibc_provi_file", length));
			String[] imdgSubsRskLblCd1 = (JSPUtil.getParameter(request, prefix	+ "imdg_subs_rsk_lbl_cd1", length));
			String[] prpShpNm = (JSPUtil.getParameter(request, prefix	+ "prp_shp_nm", length));
			String[] n1stImdgIbcInstrFile = (JSPUtil.getParameter(request, prefix	+ "n1st_imdg_ibc_instr_file", length));
			String[] imdgSubsRskLblCd4 = (JSPUtil.getParameter(request, prefix	+ "imdg_subs_rsk_lbl_cd4", length));
			String[] imdgSubsRskLblCd3 = (JSPUtil.getParameter(request, prefix	+ "imdg_subs_rsk_lbl_cd3", length));
			
			for (int i = 0; i < length; i++) {
				model = new UNNumberListOptionVO();
				if (total[i] != null)
					model.setTotal(total[i]);
				if (n2ndImdgIbcProviSeq[i] != null)
					model.setN2ndImdgIbcProviSeq(n2ndImdgIbcProviSeq[i]);
				if (n3rdImdgIbcInstrFile[i] != null)
					model.setN3rdImdgIbcInstrFile(n3rdImdgIbcInstrFile[i]);
				if (n2ndImdgPckProviCd[i] != null)
					model.setN2ndImdgPckProviCd(n2ndImdgPckProviCd[i]);
				if (cfrRstrOprNm[i] != null)
					model.setCfrRstrOprNm(cfrRstrOprNm[i]);
				if (n3rdImdgTnkInstrProviSeq[i] != null)
					model.setN3rdImdgTnkInstrProviSeq(n3rdImdgTnkInstrProviSeq[i]);
				if (imdgUnNoSeq[i] != null)
					model.setImdgUnNoSeq(imdgUnNoSeq[i]);
				if (n2ndImdgUnTnkInstrCd[i] != null)
					model.setN2ndImdgUnTnkInstrCd(n2ndImdgUnTnkInstrCd[i]);
				if (imdgSubsRskLblRmk[i] != null)
					model.setImdgSubsRskLblRmk(imdgSubsRskLblRmk[i]);
				if (n2ndImdgPckProviSeq[i] != null)
					model.setN2ndImdgPckProviSeq(n2ndImdgPckProviSeq[i]);
				if (n2ndImdgTnkInstrProviFile[i] != null)
					model.setN2ndImdgTnkInstrProviFile(n2ndImdgTnkInstrProviFile[i]);
				if (imdgOrgRactTpCd[i] != null)
					model.setImdgOrgRactTpCd(imdgOrgRactTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (n1stImdgIbcInstrSeq[i] != null)
					model.setN1stImdgIbcInstrSeq(n1stImdgIbcInstrSeq[i]);
				if (imdgCompGrpCd[i] != null)
					model.setImdgCompGrpCd(imdgCompGrpCd[i]);
				if (segrDesc[i] != null)
					model.setSegrDesc(segrDesc[i]);
				if (cfrDgWetCd[i] != null)
					model.setCfrDgWetCd(cfrDgWetCd[i]);
				if (n4thImdgIbcInstrCd[i] != null)
					model.setN4thImdgIbcInstrCd(n4thImdgIbcInstrCd[i]);
				if (n1stImdgTnkInstrProviFile[i] != null)
					model.setN1stImdgTnkInstrProviFile(n1stImdgTnkInstrProviFile[i]);
				if (n3rdImdgPckProviSeq[i] != null)
					model.setN3rdImdgPckProviSeq(n3rdImdgPckProviSeq[i]);
				if (n5thImdgPckProviCd[i] != null)
					model.setN5thImdgPckProviCd(n5thImdgPckProviCd[i]);
				if (n4thImdgIbcProviCd[i] != null)
					model.setN4thImdgIbcProviCd(n4thImdgIbcProviCd[i]);
				if (n5thImdgPckProviSeq[i] != null)
					model.setN5thImdgPckProviSeq(n5thImdgPckProviSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (hcdgFlg[i] != null)
					model.setHcdgFlg(hcdgFlg[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (n5thImdgIbcProviSeq[i] != null)
					model.setN5thImdgIbcProviSeq(n5thImdgIbcProviSeq[i]);
				if (n1stImdgUnTnkInstrSeq[i] != null)
					model.setN1stImdgUnTnkInstrSeq(n1stImdgUnTnkInstrSeq[i]);
				if (n3rdImdgPckInstrSeq[i] != null)
					model.setN3rdImdgPckInstrSeq(n3rdImdgPckInstrSeq[i]);
				if (n3rdImdgPckProviCd[i] != null)
					model.setN3rdImdgPckProviCd(n3rdImdgPckProviCd[i]);
				if (sprtFmImdgClssFlg[i] != null)
					model.setSprtFmImdgClssFlg(sprtFmImdgClssFlg[i]);
				if (awayFmImdgClssFlg[i] != null)
					model.setAwayFmImdgClssFlg(awayFmImdgClssFlg[i]);
				if (eaiIfFlg[i] != null)
					model.setEaiIfFlg(eaiIfFlg[i]);
				if (hcdgIntmdBcRstrDesc[i] != null)
					model.setHcdgIntmdBcRstrDesc(hcdgIntmdBcRstrDesc[i]);
				if (n4thImdgTnkInstrProviFile[i] != null)
					model.setN4thImdgTnkInstrProviFile(n4thImdgTnkInstrProviFile[i]);
				if (n3rdImdgIbcInstrCd[i] != null)
					model.setN3rdImdgIbcInstrCd(n3rdImdgIbcInstrCd[i]);
				if (sprtLonFmImdgClssCd[i] != null)
					model.setSprtLonFmImdgClssCd(sprtLonFmImdgClssCd[i]);
				if (n1stImdgUnTnkInstrFile[i] != null)
					model.setN1stImdgUnTnkInstrFile(n1stImdgUnTnkInstrFile[i]);
				if (pageNo[i] != null)
					model.setPageNo(pageNo[i]);
				if (cfrRstrPortNm[i] != null)
					model.setCfrRstrPortNm(cfrRstrPortNm[i]);
				if (emerRspnGidNo[i] != null)
					model.setEmerRspnGidNo(emerRspnGidNo[i]);
				if (n3rdImdgPckInstrFile[i] != null)
					model.setN3rdImdgPckInstrFile(n3rdImdgPckInstrFile[i]);
				if (n2ndImdgIbcInstrSeq[i] != null)
					model.setN2ndImdgIbcInstrSeq(n2ndImdgIbcInstrSeq[i]);
				if (n4thBomPortTrstNo[i] != null)
					model.setN4thBomPortTrstNo(n4thBomPortTrstNo[i]);
				if (imdgConcRtCtnt[i] != null)
					model.setImdgConcRtCtnt(imdgConcRtCtnt[i]);
				if (n3rdImdgIbcProviFile[i] != null)
					model.setN3rdImdgIbcProviFile(n3rdImdgIbcProviFile[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				if (imdgPckGrpCd[i] != null)
					model.setImdgPckGrpCd(imdgPckGrpCd[i]);
				if (n3rdImdgIbcInstrSeq[i] != null)
					model.setN3rdImdgIbcInstrSeq(n3rdImdgIbcInstrSeq[i]);
				if (imdgLmtQtyMeasUtCd[i] != null)
					model.setImdgLmtQtyMeasUtCd(imdgLmtQtyMeasUtCd[i]);
				if (n1stBomPortTrstNo[i] != null)
					model.setN1stBomPortTrstNo(n1stBomPortTrstNo[i]);
				if (imdgLmtQty[i] != null)
					model.setImdgLmtQty(imdgLmtQty[i]);
				if (n3rdBomPortTrstNo[i] != null)
					model.setN3rdBomPortTrstNo(n3rdBomPortTrstNo[i]);
				if (n4thImdgIbcInstrSeq[i] != null)
					model.setN4thImdgIbcInstrSeq(n4thImdgIbcInstrSeq[i]);
				if (sprtHldFmImdgClssCd[i] != null)
					model.setSprtHldFmImdgClssCd(sprtHldFmImdgClssCd[i]);
				if (flshPntTempCtnt[i] != null)
					model.setFlshPntTempCtnt(flshPntTempCtnt[i]);
				if (n2ndImdgUnTnkInstrSeq[i] != null)
					model.setN2ndImdgUnTnkInstrSeq(n2ndImdgUnTnkInstrSeq[i]);
				if (cfrPsnInhZnCd[i] != null)
					model.setCfrPsnInhZnCd(cfrPsnInhZnCd[i]);
				if (imdgTecNm[i] != null)
					model.setImdgTecNm(imdgTecNm[i]);
				if (awayFmImdgClssCd[i] != null)
					model.setAwayFmImdgClssCd(awayFmImdgClssCd[i]);
				if (n3rdImdgTnkInstrProviCd[i] != null)
					model.setN3rdImdgTnkInstrProviCd(n3rdImdgTnkInstrProviCd[i]);
				if (n3rdImdgPckProviFile[i] != null)
					model.setN3rdImdgPckProviFile(n3rdImdgPckProviFile[i]);
				if (imdgSbstPptDesc[i] != null)
					model.setImdgSbstPptDesc(imdgSbstPptDesc[i]);
				if (n1stImdgTnkInstrProviCd[i] != null)
					model.setN1stImdgTnkInstrProviCd(n1stImdgTnkInstrProviCd[i]);
				if (n2ndImdgIbcInstrCd[i] != null)
					model.setN2ndImdgIbcInstrCd(n2ndImdgIbcInstrCd[i]);
				if (imdgFdStufStwgCd[i] != null)
					model.setImdgFdStufStwgCd(imdgFdStufStwgCd[i]);
				if (imdgSubsRskLblCd[i] != null)
					model.setImdgSubsRskLblCd(imdgSubsRskLblCd[i]);
				if (cfrToxcCd[i] != null)
					model.setCfrToxcCd(cfrToxcCd[i]);
				if (imdgExptQtyDesc[i] != null)
					model.setImdgExptQtyDesc(imdgExptQtyDesc[i]);
				if (imdgPckMzdCd[i] != null)
					model.setImdgPckMzdCd(imdgPckMzdCd[i]);
				if (hcdgTnkRstrDesc3[i] != null)
					model.setHcdgTnkRstrDesc3(hcdgTnkRstrDesc3[i]);
				if (hcdgTnkRstrDesc4[i] != null)
					model.setHcdgTnkRstrDesc4(hcdgTnkRstrDesc4[i]);
				if (n1stImdgPckInstrFile[i] != null)
					model.setN1stImdgPckInstrFile(n1stImdgPckInstrFile[i]);
				if (n2ndImdgPckInstrSeq[i] != null)
					model.setN2ndImdgPckInstrSeq(n2ndImdgPckInstrSeq[i]);
				if (hcdgTnkRstrDesc2[i] != null)
					model.setHcdgTnkRstrDesc2(hcdgTnkRstrDesc2[i]);
				if (hcdgTnkRstrDesc1[i] != null)
					model.setHcdgTnkRstrDesc1(hcdgTnkRstrDesc1[i]);
				if (sprtDpSeq[i] != null)
					model.setSprtDpSeq(sprtDpSeq[i]);
				if (n2ndImdgTnkInstrProviCd[i] != null)
					model.setN2ndImdgTnkInstrProviCd(n2ndImdgTnkInstrProviCd[i]);
				if (n1stImdgUnTnkInstrCd[i] != null)
					model.setN1stImdgUnTnkInstrCd(n1stImdgUnTnkInstrCd[i]);
				if (n5thImdgIbcProviFile[i] != null)
					model.setN5thImdgIbcProviFile(n5thImdgIbcProviFile[i]);
				if (n3rdImdgTnkInstrProviFile[i] != null)
					model.setN3rdImdgTnkInstrProviFile(n3rdImdgTnkInstrProviFile[i]);
				if (n5thImdgTnkInstrProviSeq[i] != null)
					model.setN5thImdgTnkInstrProviSeq(n5thImdgTnkInstrProviSeq[i]);
				if (n2ndImdgPckInstrFile[i] != null)
					model.setN2ndImdgPckInstrFile(n2ndImdgPckInstrFile[i]);
				if (sprtFmImdgClssCd[i] != null)
					model.setSprtFmImdgClssCd(sprtFmImdgClssCd[i]);
				if (awayFmImdgSegrGrpFlg[i] != null)
					model.setAwayFmImdgSegrGrpFlg(awayFmImdgSegrGrpFlg[i]);
				if (hcdgRmk[i] != null)
					model.setHcdgRmk(hcdgRmk[i]);
				if (psaNo[i] != null)
					model.setPsaNo(psaNo[i]);
				if (n2ndImdgUnTnkInstrFile[i] != null)
					model.setN2ndImdgUnTnkInstrFile(n2ndImdgUnTnkInstrFile[i]);
				if (n2ndImdgPckInstrCd[i] != null)
					model.setN2ndImdgPckInstrCd(n2ndImdgPckInstrCd[i]);
				if (n1stImdgIbcProviCd[i] != null)
					model.setN1stImdgIbcProviCd(n1stImdgIbcProviCd[i]);
				if (n1stImdgPckInstrSeq[i] != null)
					model.setN1stImdgPckInstrSeq(n1stImdgPckInstrSeq[i]);
				if (imdgSpclProviNo[i] != null)
					model.setImdgSpclProviNo(imdgSpclProviNo[i]);
				if (imdgCrrRstrExptNm[i] != null)
					model.setImdgCrrRstrExptNm(imdgCrrRstrExptNm[i]);
				if (n1stImdgPckProviSeq[i] != null)
					model.setN1stImdgPckProviSeq(n1stImdgPckProviSeq[i]);
				if (n4thImdgPckProviCd[i] != null)
					model.setN4thImdgPckProviCd(n4thImdgPckProviCd[i]);
				if (n1stImdgIbcProviSeq[i] != null)
					model.setN1stImdgIbcProviSeq(n1stImdgIbcProviSeq[i]);
				if (n3rdImdgIbcProviSeq[i] != null)
					model.setN3rdImdgIbcProviSeq(n3rdImdgIbcProviSeq[i]);
				if (n3rdImdgPckInstrCd[i] != null)
					model.setN3rdImdgPckInstrCd(n3rdImdgPckInstrCd[i]);
				if (sprtFmImdgSegrGrpFlg[i] != null)
					model.setSprtFmImdgSegrGrpFlg(sprtFmImdgSegrGrpFlg[i]);
				if (n1stImdgPckInstrCd[i] != null)
					model.setN1stImdgPckInstrCd(n1stImdgPckInstrCd[i]);
				if (n4thImdgIbcProviSeq[i] != null)
					model.setN4thImdgIbcProviSeq(n4thImdgIbcProviSeq[i]);
				if (n5thImdgIbcInstrCd[i] != null)
					model.setN5thImdgIbcInstrCd(n5thImdgIbcInstrCd[i]);
				if (n4thImdgTnkInstrProviCd[i] != null)
					model.setN4thImdgTnkInstrProviCd(n4thImdgTnkInstrProviCd[i]);
				if (imdgSpclProviNo8[i] != null)
					model.setImdgSpclProviNo8(imdgSpclProviNo8[i]);
				if (imdgUnNoHldFlg[i] != null)
					model.setImdgUnNoHldFlg(imdgUnNoHldFlg[i]);
				if (imdgSpclProviNo4[i] != null)
					model.setImdgSpclProviNo4(imdgSpclProviNo4[i]);
				if (imdgSpclProviNo5[i] != null)
					model.setImdgSpclProviNo5(imdgSpclProviNo5[i]);
				if (imdgSpclProviNo6[i] != null)
					model.setImdgSpclProviNo6(imdgSpclProviNo6[i]);
				if (imdgSpclProviNo7[i] != null)
					model.setImdgSpclProviNo7(imdgSpclProviNo7[i]);
				if (n1stImdgPckProviFile[i] != null)
					model.setN1stImdgPckProviFile(n1stImdgPckProviFile[i]);
				if (n2ndImdgPckProviFile[i] != null)
					model.setN2ndImdgPckProviFile(n2ndImdgPckProviFile[i]);
				if (sprtLonFmImdgClssFlg[i] != null)
					model.setSprtLonFmImdgClssFlg(sprtLonFmImdgClssFlg[i]);
				if (n2ndImdgIbcInstrFile[i] != null)
					model.setN2ndImdgIbcInstrFile(n2ndImdgIbcInstrFile[i]);
				if (segrAsForImdgClssCd[i] != null)
					model.setSegrAsForImdgClssCd(segrAsForImdgClssCd[i]);
				if (n5thImdgTnkInstrProviCd[i] != null)
					model.setN5thImdgTnkInstrProviCd(n5thImdgTnkInstrProviCd[i]);
				if (n5thImdgPckProviFile[i] != null)
					model.setN5thImdgPckProviFile(n5thImdgPckProviFile[i]);
				if (awayDpSeq[i] != null)
					model.setAwayDpSeq(awayDpSeq[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (n5thImdgIbcInstrSeq[i] != null)
					model.setN5thImdgIbcInstrSeq(n5thImdgIbcInstrSeq[i]);
				if (n4thImdgTnkInstrProviSeq[i] != null)
					model.setN4thImdgTnkInstrProviSeq(n4thImdgTnkInstrProviSeq[i]);
				if (emerRspnGidChrNo[i] != null)
					model.setEmerRspnGidChrNo(emerRspnGidChrNo[i]);
				if (rowNum[i] != null)
					model.setRowNum(rowNum[i]);
				if (n2ndImdgTnkInstrProviSeq[i] != null)
					model.setN2ndImdgTnkInstrProviSeq(n2ndImdgTnkInstrProviSeq[i]);
				if (n4thImdgPckProviSeq[i] != null)
					model.setN4thImdgPckProviSeq(n4thImdgPckProviSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (eaiIfId[i] != null)
					model.setEaiIfId(eaiIfId[i]);
				if (pkgAuthNo[i] != null)
					model.setPkgAuthNo(pkgAuthNo[i]);
				if (n4thImdgPckProviFile[i] != null)
					model.setN4thImdgPckProviFile(n4thImdgPckProviFile[i]);
				if (n5thImdgIbcProviCd[i] != null)
					model.setN5thImdgIbcProviCd(n5thImdgIbcProviCd[i]);
				if (segrAsForImdgClssFlg[i] != null)
					model.setSegrAsForImdgClssFlg(segrAsForImdgClssFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (n2ndImdgIbcProviCd[i] != null)
					model.setN2ndImdgIbcProviCd(n2ndImdgIbcProviCd[i]);
				if (imdgExptQtyCd[i] != null)
					model.setImdgExptQtyCd(imdgExptQtyCd[i]);
				if (lkPortAuthNo[i] != null)
					model.setLkPortAuthNo(lkPortAuthNo[i]);
				if (n1stImdgPckProviCd[i] != null)
					model.setN1stImdgPckProviCd(n1stImdgPckProviCd[i]);
				if (n2ndImdgIbcProviFile[i] != null)
					model.setN2ndImdgIbcProviFile(n2ndImdgIbcProviFile[i]);
				if (imdgCrrRstrExptCd[i] != null)
					model.setImdgCrrRstrExptCd(imdgCrrRstrExptCd[i]);
				if (imdgCtrlTemp[i] != null)
					model.setImdgCtrlTemp(imdgCtrlTemp[i]);
				if (hcdgPckRstrDesc[i] != null)
					model.setHcdgPckRstrDesc(hcdgPckRstrDesc[i]);
				if (n4thImdgIbcInstrFile[i] != null)
					model.setN4thImdgIbcInstrFile(n4thImdgIbcInstrFile[i]);
				if (imdgSpclProviNo3[i] != null)
					model.setImdgSpclProviNo3(imdgSpclProviNo3[i]);
				if (n4thImdgIbcProviFile[i] != null)
					model.setN4thImdgIbcProviFile(n4thImdgIbcProviFile[i]);
				if (imdgSpclProviNo2[i] != null)
					model.setImdgSpclProviNo2(imdgSpclProviNo2[i]);
				if (cfrRptQty[i] != null)
					model.setCfrRptQty(cfrRptQty[i]);
				if (imdgSpclProviNo1[i] != null)
					model.setImdgSpclProviNo1(imdgSpclProviNo1[i]);
				if (n1stImdgTnkInstrProviSeq[i] != null)
					model.setN1stImdgTnkInstrProviSeq(n1stImdgTnkInstrProviSeq[i]);
				if (imdgHtSrcStwgCd[i] != null)
					model.setImdgHtSrcStwgCd(imdgHtSrcStwgCd[i]);
				if (clrLivQtrStwgFlg[i] != null)
					model.setClrLivQtrStwgFlg(clrLivQtrStwgFlg[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (n1stImdgIbcInstrCd[i] != null)
					model.setN1stImdgIbcInstrCd(n1stImdgIbcInstrCd[i]);
				if (imdgStwgCateCd[i] != null)
					model.setImdgStwgCateCd(imdgStwgCateCd[i]);
				if (n3rdImdgIbcProviCd[i] != null)
					model.setN3rdImdgIbcProviCd(n3rdImdgIbcProviCd[i]);
				if (eaiEvntDt[i] != null)
					model.setEaiEvntDt(eaiEvntDt[i]);
				if (imdgLmtQtyDesc[i] != null)
					model.setImdgLmtQtyDesc(imdgLmtQtyDesc[i]);
				if (n5thImdgTnkInstrProviFile[i] != null)
					model.setN5thImdgTnkInstrProviFile(n5thImdgTnkInstrProviFile[i]);
				if (n5thImdgIbcInstrFile[i] != null)
					model.setN5thImdgIbcInstrFile(n5thImdgIbcInstrFile[i]);
				if (sprtHldFmImdgClssFlg[i] != null)
					model.setSprtHldFmImdgClssFlg(sprtHldFmImdgClssFlg[i]);
				if (imdgEmerNo[i] != null)
					model.setImdgEmerNo(imdgEmerNo[i]);
				if (n2ndBomPortTrstNo[i] != null)
					model.setN2ndBomPortTrstNo(n2ndBomPortTrstNo[i]);
				if (imdgEmerTemp[i] != null)
					model.setImdgEmerTemp(imdgEmerTemp[i]);
				if (hcdgTnkRstrDesc[i] != null)
					model.setHcdgTnkRstrDesc(hcdgTnkRstrDesc[i]);
				if (imdgMrnPolutCd[i] != null)
					model.setImdgMrnPolutCd(imdgMrnPolutCd[i]);
				if (cfrXtdClssCd[i] != null)
					model.setCfrXtdClssCd(cfrXtdClssCd[i]);
				if (hcdgDpndQtyFlg[i] != null)
					model.setHcdgDpndQtyFlg(hcdgDpndQtyFlg[i]);
				if (imdgSubsRskLblCd2[i] != null)
					model.setImdgSubsRskLblCd2(imdgSubsRskLblCd2[i]);
				if (n1stImdgIbcProviFile[i] != null)
					model.setN1stImdgIbcProviFile(n1stImdgIbcProviFile[i]);
				if (imdgSubsRskLblCd1[i] != null)
					model.setImdgSubsRskLblCd1(imdgSubsRskLblCd1[i]);
				if (prpShpNm[i] != null)
					model.setPrpShpNm(prpShpNm[i]);
				if (n1stImdgIbcInstrFile[i] != null)
					model.setN1stImdgIbcInstrFile(n1stImdgIbcInstrFile[i]);
				if (imdgSubsRskLblCd4[i] != null)
					model.setImdgSubsRskLblCd4(imdgSubsRskLblCd4[i]);
				if (imdgSubsRskLblCd3[i] != null)
					model.setImdgSubsRskLblCd3(imdgSubsRskLblCd3[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUNNumberListOptionaVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UNNumberListOptionaVO[]
	 */
	public UNNumberListOptionVO[] getUNNumberListOptionaVOs(){
		UNNumberListOptionVO[] vos = (UNNumberListOptionVO[])models.toArray(new UNNumberListOptionVO[models.size()]);
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
		this.total = this.total .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndImdgIbcProviSeq = this.n2ndImdgIbcProviSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdImdgIbcInstrFile = this.n3rdImdgIbcInstrFile .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndImdgPckProviCd = this.n2ndImdgPckProviCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfrRstrOprNm = this.cfrRstrOprNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdImdgTnkInstrProviSeq = this.n3rdImdgTnkInstrProviSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNoSeq = this.imdgUnNoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndImdgUnTnkInstrCd = this.n2ndImdgUnTnkInstrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSubsRskLblRmk = this.imdgSubsRskLblRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndImdgPckProviSeq = this.n2ndImdgPckProviSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndImdgTnkInstrProviFile = this.n2ndImdgTnkInstrProviFile .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgOrgRactTpCd = this.imdgOrgRactTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stImdgIbcInstrSeq = this.n1stImdgIbcInstrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgCompGrpCd = this.imdgCompGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.segrDesc = this.segrDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfrDgWetCd = this.cfrDgWetCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thImdgIbcInstrCd = this.n4thImdgIbcInstrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stImdgTnkInstrProviFile = this.n1stImdgTnkInstrProviFile .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdImdgPckProviSeq = this.n3rdImdgPckProviSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n5thImdgPckProviCd = this.n5thImdgPckProviCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thImdgIbcProviCd = this.n4thImdgIbcProviCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n5thImdgPckProviSeq = this.n5thImdgPckProviSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcdgFlg = this.hcdgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n5thImdgIbcProviSeq = this.n5thImdgIbcProviSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stImdgUnTnkInstrSeq = this.n1stImdgUnTnkInstrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdImdgPckInstrSeq = this.n3rdImdgPckInstrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdImdgPckProviCd = this.n3rdImdgPckProviCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprtFmImdgClssFlg = this.sprtFmImdgClssFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awayFmImdgClssFlg = this.awayFmImdgClssFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiIfFlg = this.eaiIfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcdgIntmdBcRstrDesc = this.hcdgIntmdBcRstrDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thImdgTnkInstrProviFile = this.n4thImdgTnkInstrProviFile .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdImdgIbcInstrCd = this.n3rdImdgIbcInstrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprtLonFmImdgClssCd = this.sprtLonFmImdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stImdgUnTnkInstrFile = this.n1stImdgUnTnkInstrFile .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pageNo = this.pageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfrRstrPortNm = this.cfrRstrPortNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emerRspnGidNo = this.emerRspnGidNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdImdgPckInstrFile = this.n3rdImdgPckInstrFile .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndImdgIbcInstrSeq = this.n2ndImdgIbcInstrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thBomPortTrstNo = this.n4thBomPortTrstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgConcRtCtnt = this.imdgConcRtCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdImdgIbcProviFile = this.n3rdImdgIbcProviFile .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckGrpCd = this.imdgPckGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdImdgIbcInstrSeq = this.n3rdImdgIbcInstrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgLmtQtyMeasUtCd = this.imdgLmtQtyMeasUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stBomPortTrstNo = this.n1stBomPortTrstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgLmtQty = this.imdgLmtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdBomPortTrstNo = this.n3rdBomPortTrstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thImdgIbcInstrSeq = this.n4thImdgIbcInstrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprtHldFmImdgClssCd = this.sprtHldFmImdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flshPntTempCtnt = this.flshPntTempCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndImdgUnTnkInstrSeq = this.n2ndImdgUnTnkInstrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfrPsnInhZnCd = this.cfrPsnInhZnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgTecNm = this.imdgTecNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awayFmImdgClssCd = this.awayFmImdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdImdgTnkInstrProviCd = this.n3rdImdgTnkInstrProviCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdImdgPckProviFile = this.n3rdImdgPckProviFile .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSbstPptDesc = this.imdgSbstPptDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stImdgTnkInstrProviCd = this.n1stImdgTnkInstrProviCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndImdgIbcInstrCd = this.n2ndImdgIbcInstrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgFdStufStwgCd = this.imdgFdStufStwgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSubsRskLblCd = this.imdgSubsRskLblCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfrToxcCd = this.cfrToxcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgExptQtyDesc = this.imdgExptQtyDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckMzdCd = this.imdgPckMzdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcdgTnkRstrDesc3 = this.hcdgTnkRstrDesc3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcdgTnkRstrDesc4 = this.hcdgTnkRstrDesc4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stImdgPckInstrFile = this.n1stImdgPckInstrFile .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndImdgPckInstrSeq = this.n2ndImdgPckInstrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcdgTnkRstrDesc2 = this.hcdgTnkRstrDesc2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcdgTnkRstrDesc1 = this.hcdgTnkRstrDesc1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprtDpSeq = this.sprtDpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndImdgTnkInstrProviCd = this.n2ndImdgTnkInstrProviCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stImdgUnTnkInstrCd = this.n1stImdgUnTnkInstrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n5thImdgIbcProviFile = this.n5thImdgIbcProviFile .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdImdgTnkInstrProviFile = this.n3rdImdgTnkInstrProviFile .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n5thImdgTnkInstrProviSeq = this.n5thImdgTnkInstrProviSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndImdgPckInstrFile = this.n2ndImdgPckInstrFile .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprtFmImdgClssCd = this.sprtFmImdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awayFmImdgSegrGrpFlg = this.awayFmImdgSegrGrpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcdgRmk = this.hcdgRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psaNo = this.psaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndImdgUnTnkInstrFile = this.n2ndImdgUnTnkInstrFile .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndImdgPckInstrCd = this.n2ndImdgPckInstrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stImdgIbcProviCd = this.n1stImdgIbcProviCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stImdgPckInstrSeq = this.n1stImdgPckInstrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSpclProviNo = this.imdgSpclProviNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgCrrRstrExptNm = this.imdgCrrRstrExptNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stImdgPckProviSeq = this.n1stImdgPckProviSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thImdgPckProviCd = this.n4thImdgPckProviCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stImdgIbcProviSeq = this.n1stImdgIbcProviSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdImdgIbcProviSeq = this.n3rdImdgIbcProviSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdImdgPckInstrCd = this.n3rdImdgPckInstrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprtFmImdgSegrGrpFlg = this.sprtFmImdgSegrGrpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stImdgPckInstrCd = this.n1stImdgPckInstrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thImdgIbcProviSeq = this.n4thImdgIbcProviSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n5thImdgIbcInstrCd = this.n5thImdgIbcInstrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thImdgTnkInstrProviCd = this.n4thImdgTnkInstrProviCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSpclProviNo8 = this.imdgSpclProviNo8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNoHldFlg = this.imdgUnNoHldFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSpclProviNo4 = this.imdgSpclProviNo4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSpclProviNo5 = this.imdgSpclProviNo5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSpclProviNo6 = this.imdgSpclProviNo6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSpclProviNo7 = this.imdgSpclProviNo7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stImdgPckProviFile = this.n1stImdgPckProviFile .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndImdgPckProviFile = this.n2ndImdgPckProviFile .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprtLonFmImdgClssFlg = this.sprtLonFmImdgClssFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndImdgIbcInstrFile = this.n2ndImdgIbcInstrFile .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.segrAsForImdgClssCd = this.segrAsForImdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n5thImdgTnkInstrProviCd = this.n5thImdgTnkInstrProviCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n5thImdgPckProviFile = this.n5thImdgPckProviFile .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awayDpSeq = this.awayDpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n5thImdgIbcInstrSeq = this.n5thImdgIbcInstrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thImdgTnkInstrProviSeq = this.n4thImdgTnkInstrProviSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emerRspnGidChrNo = this.emerRspnGidChrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowNum = this.rowNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndImdgTnkInstrProviSeq = this.n2ndImdgTnkInstrProviSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thImdgPckProviSeq = this.n4thImdgPckProviSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiIfId = this.eaiIfId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkgAuthNo = this.pkgAuthNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thImdgPckProviFile = this.n4thImdgPckProviFile .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n5thImdgIbcProviCd = this.n5thImdgIbcProviCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.segrAsForImdgClssFlg = this.segrAsForImdgClssFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndImdgIbcProviCd = this.n2ndImdgIbcProviCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgExptQtyCd = this.imdgExptQtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lkPortAuthNo = this.lkPortAuthNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stImdgPckProviCd = this.n1stImdgPckProviCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndImdgIbcProviFile = this.n2ndImdgIbcProviFile .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgCrrRstrExptCd = this.imdgCrrRstrExptCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgCtrlTemp = this.imdgCtrlTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcdgPckRstrDesc = this.hcdgPckRstrDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thImdgIbcInstrFile = this.n4thImdgIbcInstrFile .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSpclProviNo3 = this.imdgSpclProviNo3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thImdgIbcProviFile = this.n4thImdgIbcProviFile .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSpclProviNo2 = this.imdgSpclProviNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfrRptQty = this.cfrRptQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSpclProviNo1 = this.imdgSpclProviNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stImdgTnkInstrProviSeq = this.n1stImdgTnkInstrProviSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgHtSrcStwgCd = this.imdgHtSrcStwgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clrLivQtrStwgFlg = this.clrLivQtrStwgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stImdgIbcInstrCd = this.n1stImdgIbcInstrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgStwgCateCd = this.imdgStwgCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdImdgIbcProviCd = this.n3rdImdgIbcProviCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiEvntDt = this.eaiEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgLmtQtyDesc = this.imdgLmtQtyDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n5thImdgTnkInstrProviFile = this.n5thImdgTnkInstrProviFile .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n5thImdgIbcInstrFile = this.n5thImdgIbcInstrFile .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprtHldFmImdgClssFlg = this.sprtHldFmImdgClssFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgEmerNo = this.imdgEmerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndBomPortTrstNo = this.n2ndBomPortTrstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgEmerTemp = this.imdgEmerTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcdgTnkRstrDesc = this.hcdgTnkRstrDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgMrnPolutCd = this.imdgMrnPolutCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfrXtdClssCd = this.cfrXtdClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcdgDpndQtyFlg = this.hcdgDpndQtyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSubsRskLblCd2 = this.imdgSubsRskLblCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stImdgIbcProviFile = this.n1stImdgIbcProviFile .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSubsRskLblCd1 = this.imdgSubsRskLblCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prpShpNm = this.prpShpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stImdgIbcInstrFile = this.n1stImdgIbcInstrFile .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSubsRskLblCd4 = this.imdgSubsRskLblCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSubsRskLblCd3 = this.imdgSubsRskLblCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
