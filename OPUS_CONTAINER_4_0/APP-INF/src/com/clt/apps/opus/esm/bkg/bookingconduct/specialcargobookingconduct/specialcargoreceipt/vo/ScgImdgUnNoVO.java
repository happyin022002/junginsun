/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScgImdgUnNoVO.java
*@FileTitle : ScgImdgUnNoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.23
*@LastModifier : 이병규
*@LastVersion : 1.0
* 2009.11.23 이병규 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo;

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
 * @author 이병규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ScgImdgUnNoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ScgImdgUnNoVO> models = new ArrayList<ScgImdgUnNoVO>();
	
	/* Column Info */
	private String n2ndImdgPckProviCd = null;
	/* Column Info */
	private String cfrRstrOprNm = null;
	/* Column Info */
	private String awayFmImdgSegrGrpFlg = null;
	/* Column Info */
	private String imdgUnNoSeq = null;
	/* Column Info */
	private String srl3 = null;
	/* Column Info */
	private String n2ndImdgUnTnkInstrCd = null;
	/* Column Info */
	private String psaNo = null;
	/* Column Info */
	private String imdgSubsRskLblRmk = null;
	/* Column Info */
	private String hcdgRmk = null;
	/* Column Info */
	private String srl4 = null;
	/* Column Info */
	private String n2ndImdgPckInstrCd = null;
	/* Column Info */
	private String srl1 = null;
	/* Column Info */
	private String n1stImdgIbcProviCd = null;
	/* Column Info */
	private String srl2 = null;
	/* Column Info */
	private String imdgSpclProviNo = null;
	/* Column Info */
	private String crrCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String n4thImdgPckProviCd = null;
	/* Column Info */
	private String imdgCompGrpCd = null;
	/* Column Info */
	private String segrDesc = null;
	/* Column Info */
	private String cfrDgWetCd = null;
	/* Column Info */
	private String n4thImdgIbcInstrCd = null;
	/* Column Info */
	private String n3rdImdgPckInstrCd = null;
	/* Column Info */
	private String sprtFmImdgSegrGrpFlg = null;
	/* Column Info */
	private String n1stImdgPckInstrCd = null;
	/* Column Info */
	private String n5thImdgIbcInstrCd = null;
	/* Column Info */
	private String n4thImdgTnkInstrProviCd = null;
	/* Column Info */
	private String n4thImdgIbcProviCd = null;
	/* Column Info */
	private String n5thImdgPckProviCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Column Info */
	private String hcdgFlg = null;
	/* Column Info */
	private String imdgUnNoHldFlg = null;
	/* Column Info */
	private String n3rdImdgPckProviCd = null;
	/* Column Info */
	private String sprtFmImdgClssFlg = null;
	/* Column Info */
	private String awayFmImdgClssFlg = null;
	/* Column Info */
	private String hcdgIntmdBcRstrDesc = null;
	/* Column Info */
	private String n3rdImdgIbcInstrCd = null;
	/* Column Info */
	private String segrAsForImdgClssCd = null;
	/* Column Info */
	private String n5thImdgTnkInstrProviCd = null;
	/* Column Info */
	private String imdgTblNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cfrRstrPortNm = null;
	/* Column Info */
	private String emerRspnGidNo = null;
	/* Column Info */
	private String n4thBomPortTrstNo = null;
	/* Column Info */
	private String emerRspnGidChrNo = null;
	/* Column Info */
	private String imdgClssCd = null;
	/* Column Info */
	private String limitedQty = null;
	/* Column Info */
	private String imdgPckGrpCd = null;
	/* Column Info */
	private String imdgLmtQtyMeasUtCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String n1stBomPortTrstNo = null;
	/* Column Info */
	private String pkgAuthNo = null;
	/* Column Info */
	private String imdgLmtQty = null;
	/* Column Info */
	private String n3rdBomPortTrstNo = null;
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
	private String imdgCtrlTemp = null;
	/* Column Info */
	private String flshPntTempCtnt = null;
	/* Column Info */
	private String hcdgPckRstrDesc = null;
	/* Column Info */
	private String imdgTecNm = null;
	/* Column Info */
	private String cfrRptQty = null;
	/* Column Info */
	private String cfrPsnInhZnCd = null;
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
	private String n3rdImdgTnkInstrProviCd = null;
	/* Column Info */
	private String imdgSbstPptDesc = null;
	/* Column Info */
	private String n1stImdgTnkInstrProviCd = null;
	/* Column Info */
	private String n2ndImdgIbcInstrCd = null;
	/* Column Info */
	private String imdgFdStufStwgCd = null;
	/* Column Info */
	private String n3rdImdgIbcProviCd = null;
	/* Column Info */
	private String imdgExptQtyDesc = null;
	/* Column Info */
	private String imdgLmtQtyDesc = null;
	/* Column Info */
	private String cfrToxcCd = null;
	/* Column Info */
	private String imdgEmerNo = null;
	/* Column Info */
	private String n2ndImdgTnkInstrProviCd = null;
	/* Column Info */
	private String n2ndBomPortTrstNo = null;
	/* Column Info */
	private String imdgEmerTemp = null;
	/* Column Info */
	private String n1stImdgUnTnkInstrCd = null;
	/* Column Info */
	private String hcdgTnkRstrDesc = null;
	/* Column Info */
	private String imdgMrnPolutCd = null;
	/* Column Info */
	private String cfrXtdClssCd = null;
	/* Column Info */
	private String hcdgDpndQtyFlg = null;
	/* Column Info */
	private String prpShpNm = null;
	/* CFR flag */
	private String cfrFlg = null;
	/* CFR flag */
	private String imdgSegrGrpNos = null;
	/* Column Info */
	private String imdgAmdtNo = null;
	/* Column Info */
	private String prpShpNmVarRmk = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ScgImdgUnNoVO() {}

	public ScgImdgUnNoVO(String ibflag, String pagerows, String imdgUnNo, String imdgUnNoSeq, String prpShpNm, String imdgClssCd, String imdgCompGrpCd, String imdgSubsRskLblRmk, String imdgMrnPolutCd, String imdgPckGrpCd, String imdgLmtQty, String imdgLmtQtyMeasUtCd, String imdgExptQtyCd, String imdgEmerNo, String imdgStwgCateCd, String flshPntTempCtnt, String emerRspnGidNo, String emerRspnGidChrNo, String psaNo, String n1stBomPortTrstNo, String n2ndBomPortTrstNo, String n3rdBomPortTrstNo, String n4thBomPortTrstNo, String pkgAuthNo, String lkPortAuthNo, String imdgSbstPptDesc, String cfrRptQty, String cfrPsnInhZnCd, String cfrToxcCd, String cfrDgWetCd, String cfrRstrPortNm, String cfrRstrOprNm, String cfrXtdClssCd, String hcdgFlg, String hcdgDpndQtyFlg, String hcdgRmk, String n1stImdgPckInstrCd, String n2ndImdgPckInstrCd, String n3rdImdgPckInstrCd, String n1stImdgPckProviCd, String n2ndImdgPckProviCd, String n3rdImdgPckProviCd, String n4thImdgPckProviCd, String n5thImdgPckProviCd, String n1stImdgIbcInstrCd, String n2ndImdgIbcInstrCd, String n3rdImdgIbcInstrCd, String n4thImdgIbcInstrCd, String n5thImdgIbcInstrCd, String n1stImdgIbcProviCd, String n2ndImdgIbcProviCd, String n3rdImdgIbcProviCd, String n4thImdgIbcProviCd, String n5thImdgIbcProviCd, String n1stImdgUnTnkInstrCd, String n2ndImdgUnTnkInstrCd, String n1stImdgTnkInstrProviCd, String n2ndImdgTnkInstrProviCd, String n3rdImdgTnkInstrProviCd, String n4thImdgTnkInstrProviCd, String n5thImdgTnkInstrProviCd, String hcdgPckRstrDesc, String hcdgIntmdBcRstrDesc, String hcdgTnkRstrDesc, String segrDesc, String clrLivQtrStwgFlg, String imdgFdStufStwgCd, String imdgHtSrcStwgCd, String segrAsForImdgClssFlg, String segrAsForImdgClssCd, String awayFmImdgClssFlg, String sprtFmImdgClssFlg, String awayFmImdgSegrGrpFlg, String sprtFmImdgSegrGrpFlg, String imdgTblNo, String imdgUnNoHldFlg, String creUsrId, String creDt, String updUsrId, String updDt, String imdgLmtQtyDesc, String imdgExptQtyDesc, String imdgSpclProviNo, String imdgTecNm, String imdgCtrlTemp, String imdgEmerTemp, String limitedQty, String srl1, String srl2, String srl3, String srl4, String crrCd, String imdgSegrGrpNos, String imdgAmdtNo, String prpShpNmVarRmk) {
		this.n2ndImdgPckProviCd = n2ndImdgPckProviCd;
		this.cfrRstrOprNm = cfrRstrOprNm;
		this.awayFmImdgSegrGrpFlg = awayFmImdgSegrGrpFlg;
		this.imdgUnNoSeq = imdgUnNoSeq;
		this.srl3 = srl3;
		this.n2ndImdgUnTnkInstrCd = n2ndImdgUnTnkInstrCd;
		this.psaNo = psaNo;
		this.imdgSubsRskLblRmk = imdgSubsRskLblRmk;
		this.hcdgRmk = hcdgRmk;
		this.srl4 = srl4;
		this.n2ndImdgPckInstrCd = n2ndImdgPckInstrCd;
		this.srl1 = srl1;
		this.n1stImdgIbcProviCd = n1stImdgIbcProviCd;
		this.srl2 = srl2;
		this.imdgSpclProviNo = imdgSpclProviNo;
		this.crrCd = crrCd;
		this.pagerows = pagerows;
		this.n4thImdgPckProviCd = n4thImdgPckProviCd;
		this.imdgCompGrpCd = imdgCompGrpCd;
		this.segrDesc = segrDesc;
		this.cfrDgWetCd = cfrDgWetCd;
		this.n4thImdgIbcInstrCd = n4thImdgIbcInstrCd;
		this.n3rdImdgPckInstrCd = n3rdImdgPckInstrCd;
		this.sprtFmImdgSegrGrpFlg = sprtFmImdgSegrGrpFlg;
		this.n1stImdgPckInstrCd = n1stImdgPckInstrCd;
		this.n5thImdgIbcInstrCd = n5thImdgIbcInstrCd;
		this.n4thImdgTnkInstrProviCd = n4thImdgTnkInstrProviCd;
		this.n4thImdgIbcProviCd = n4thImdgIbcProviCd;
		this.n5thImdgPckProviCd = n5thImdgPckProviCd;
		this.updUsrId = updUsrId;
		this.imdgUnNo = imdgUnNo;
		this.hcdgFlg = hcdgFlg;
		this.imdgUnNoHldFlg = imdgUnNoHldFlg;
		this.n3rdImdgPckProviCd = n3rdImdgPckProviCd;
		this.sprtFmImdgClssFlg = sprtFmImdgClssFlg;
		this.awayFmImdgClssFlg = awayFmImdgClssFlg;
		this.hcdgIntmdBcRstrDesc = hcdgIntmdBcRstrDesc;
		this.n3rdImdgIbcInstrCd = n3rdImdgIbcInstrCd;
		this.segrAsForImdgClssCd = segrAsForImdgClssCd;
		this.n5thImdgTnkInstrProviCd = n5thImdgTnkInstrProviCd;
		this.imdgTblNo = imdgTblNo;
		this.creUsrId = creUsrId;
		this.cfrRstrPortNm = cfrRstrPortNm;
		this.emerRspnGidNo = emerRspnGidNo;
		this.n4thBomPortTrstNo = n4thBomPortTrstNo;
		this.emerRspnGidChrNo = emerRspnGidChrNo;
		this.imdgClssCd = imdgClssCd;
		this.limitedQty = limitedQty;
		this.imdgPckGrpCd = imdgPckGrpCd;
		this.imdgLmtQtyMeasUtCd = imdgLmtQtyMeasUtCd;
		this.creDt = creDt;
		this.n1stBomPortTrstNo = n1stBomPortTrstNo;
		this.pkgAuthNo = pkgAuthNo;
		this.imdgLmtQty = imdgLmtQty;
		this.n3rdBomPortTrstNo = n3rdBomPortTrstNo;
		this.n5thImdgIbcProviCd = n5thImdgIbcProviCd;
		this.segrAsForImdgClssFlg = segrAsForImdgClssFlg;
		this.ibflag = ibflag;
		this.n2ndImdgIbcProviCd = n2ndImdgIbcProviCd;
		this.imdgExptQtyCd = imdgExptQtyCd;
		this.lkPortAuthNo = lkPortAuthNo;
		this.n1stImdgPckProviCd = n1stImdgPckProviCd;
		this.imdgCtrlTemp = imdgCtrlTemp;
		this.flshPntTempCtnt = flshPntTempCtnt;
		this.hcdgPckRstrDesc = hcdgPckRstrDesc;
		this.imdgTecNm = imdgTecNm;
		this.cfrRptQty = cfrRptQty;
		this.cfrPsnInhZnCd = cfrPsnInhZnCd;
		this.imdgHtSrcStwgCd = imdgHtSrcStwgCd;
		this.clrLivQtrStwgFlg = clrLivQtrStwgFlg;
		this.updDt = updDt;
		this.n1stImdgIbcInstrCd = n1stImdgIbcInstrCd;
		this.imdgStwgCateCd = imdgStwgCateCd;
		this.n3rdImdgTnkInstrProviCd = n3rdImdgTnkInstrProviCd;
		this.imdgSbstPptDesc = imdgSbstPptDesc;
		this.n1stImdgTnkInstrProviCd = n1stImdgTnkInstrProviCd;
		this.n2ndImdgIbcInstrCd = n2ndImdgIbcInstrCd;
		this.imdgFdStufStwgCd = imdgFdStufStwgCd;
		this.n3rdImdgIbcProviCd = n3rdImdgIbcProviCd;
		this.imdgExptQtyDesc = imdgExptQtyDesc;
		this.imdgLmtQtyDesc = imdgLmtQtyDesc;
		this.cfrToxcCd = cfrToxcCd;
		this.imdgEmerNo = imdgEmerNo;
		this.n2ndImdgTnkInstrProviCd = n2ndImdgTnkInstrProviCd;
		this.n2ndBomPortTrstNo = n2ndBomPortTrstNo;
		this.imdgEmerTemp = imdgEmerTemp;
		this.n1stImdgUnTnkInstrCd = n1stImdgUnTnkInstrCd;
		this.hcdgTnkRstrDesc = hcdgTnkRstrDesc;
		this.imdgMrnPolutCd = imdgMrnPolutCd;
		this.cfrXtdClssCd = cfrXtdClssCd;
		this.hcdgDpndQtyFlg = hcdgDpndQtyFlg;
		this.prpShpNm = prpShpNm;
		this.imdgSegrGrpNos = imdgSegrGrpNos;
		this.imdgAmdtNo = imdgAmdtNo;
		this.prpShpNmVarRmk = prpShpNmVarRmk;
	}

	public ScgImdgUnNoVO(String ibflag, String pagerows, String imdgUnNo, String imdgUnNoSeq, String prpShpNm, String imdgClssCd, String imdgCompGrpCd, String imdgSubsRskLblRmk, String imdgMrnPolutCd, String imdgPckGrpCd, String imdgLmtQty, String imdgLmtQtyMeasUtCd, String imdgExptQtyCd, String imdgEmerNo, String imdgStwgCateCd, String flshPntTempCtnt, String emerRspnGidNo, String emerRspnGidChrNo, String psaNo, String n1stBomPortTrstNo, String n2ndBomPortTrstNo, String n3rdBomPortTrstNo, String n4thBomPortTrstNo, String pkgAuthNo, String lkPortAuthNo, String imdgSbstPptDesc, String cfrRptQty, String cfrPsnInhZnCd, String cfrToxcCd, String cfrDgWetCd, String cfrRstrPortNm, String cfrRstrOprNm, String cfrXtdClssCd, String hcdgFlg, String hcdgDpndQtyFlg, String hcdgRmk, String n1stImdgPckInstrCd, String n2ndImdgPckInstrCd, String n3rdImdgPckInstrCd, String n1stImdgPckProviCd, String n2ndImdgPckProviCd, String n3rdImdgPckProviCd, String n4thImdgPckProviCd, String n5thImdgPckProviCd, String n1stImdgIbcInstrCd, String n2ndImdgIbcInstrCd, String n3rdImdgIbcInstrCd, String n4thImdgIbcInstrCd, String n5thImdgIbcInstrCd, String n1stImdgIbcProviCd, String n2ndImdgIbcProviCd, String n3rdImdgIbcProviCd, String n4thImdgIbcProviCd, String n5thImdgIbcProviCd, String n1stImdgUnTnkInstrCd, String n2ndImdgUnTnkInstrCd, String n1stImdgTnkInstrProviCd, String n2ndImdgTnkInstrProviCd, String n3rdImdgTnkInstrProviCd, String n4thImdgTnkInstrProviCd, String n5thImdgTnkInstrProviCd, String hcdgPckRstrDesc, String hcdgIntmdBcRstrDesc, String hcdgTnkRstrDesc, String segrDesc, String clrLivQtrStwgFlg, String imdgFdStufStwgCd, String imdgHtSrcStwgCd, String segrAsForImdgClssFlg, String segrAsForImdgClssCd, String awayFmImdgClssFlg, String sprtFmImdgClssFlg, String awayFmImdgSegrGrpFlg, String sprtFmImdgSegrGrpFlg, String imdgTblNo, String imdgUnNoHldFlg, String creUsrId, String creDt, String updUsrId, String updDt, String imdgLmtQtyDesc, String imdgExptQtyDesc, String imdgSpclProviNo, String imdgTecNm, String imdgCtrlTemp, String imdgEmerTemp, String limitedQty, String srl1, String srl2, String srl3, String srl4, String crrCd, String cfrFlg, String imdgSegrGrpNos, String imdgAmdtNo, String prpShpNmVarRmk) {
		this.n2ndImdgPckProviCd = n2ndImdgPckProviCd;
		this.cfrRstrOprNm = cfrRstrOprNm;
		this.awayFmImdgSegrGrpFlg = awayFmImdgSegrGrpFlg;
		this.imdgUnNoSeq = imdgUnNoSeq;
		this.srl3 = srl3;
		this.n2ndImdgUnTnkInstrCd = n2ndImdgUnTnkInstrCd;
		this.psaNo = psaNo;
		this.imdgSubsRskLblRmk = imdgSubsRskLblRmk;
		this.hcdgRmk = hcdgRmk;
		this.srl4 = srl4;
		this.n2ndImdgPckInstrCd = n2ndImdgPckInstrCd;
		this.srl1 = srl1;
		this.n1stImdgIbcProviCd = n1stImdgIbcProviCd;
		this.srl2 = srl2;
		this.imdgSpclProviNo = imdgSpclProviNo;
		this.crrCd = crrCd;
		this.pagerows = pagerows;
		this.n4thImdgPckProviCd = n4thImdgPckProviCd;
		this.imdgCompGrpCd = imdgCompGrpCd;
		this.segrDesc = segrDesc;
		this.cfrDgWetCd = cfrDgWetCd;
		this.n4thImdgIbcInstrCd = n4thImdgIbcInstrCd;
		this.n3rdImdgPckInstrCd = n3rdImdgPckInstrCd;
		this.sprtFmImdgSegrGrpFlg = sprtFmImdgSegrGrpFlg;
		this.n1stImdgPckInstrCd = n1stImdgPckInstrCd;
		this.n5thImdgIbcInstrCd = n5thImdgIbcInstrCd;
		this.n4thImdgTnkInstrProviCd = n4thImdgTnkInstrProviCd;
		this.n4thImdgIbcProviCd = n4thImdgIbcProviCd;
		this.n5thImdgPckProviCd = n5thImdgPckProviCd;
		this.updUsrId = updUsrId;
		this.imdgUnNo = imdgUnNo;
		this.hcdgFlg = hcdgFlg;
		this.imdgUnNoHldFlg = imdgUnNoHldFlg;
		this.n3rdImdgPckProviCd = n3rdImdgPckProviCd;
		this.sprtFmImdgClssFlg = sprtFmImdgClssFlg;
		this.awayFmImdgClssFlg = awayFmImdgClssFlg;
		this.hcdgIntmdBcRstrDesc = hcdgIntmdBcRstrDesc;
		this.n3rdImdgIbcInstrCd = n3rdImdgIbcInstrCd;
		this.segrAsForImdgClssCd = segrAsForImdgClssCd;
		this.n5thImdgTnkInstrProviCd = n5thImdgTnkInstrProviCd;
		this.imdgTblNo = imdgTblNo;
		this.creUsrId = creUsrId;
		this.cfrRstrPortNm = cfrRstrPortNm;
		this.emerRspnGidNo = emerRspnGidNo;
		this.n4thBomPortTrstNo = n4thBomPortTrstNo;
		this.emerRspnGidChrNo = emerRspnGidChrNo;
		this.imdgClssCd = imdgClssCd;
		this.limitedQty = limitedQty;
		this.imdgPckGrpCd = imdgPckGrpCd;
		this.imdgLmtQtyMeasUtCd = imdgLmtQtyMeasUtCd;
		this.creDt = creDt;
		this.n1stBomPortTrstNo = n1stBomPortTrstNo;
		this.pkgAuthNo = pkgAuthNo;
		this.imdgLmtQty = imdgLmtQty;
		this.n3rdBomPortTrstNo = n3rdBomPortTrstNo;
		this.n5thImdgIbcProviCd = n5thImdgIbcProviCd;
		this.segrAsForImdgClssFlg = segrAsForImdgClssFlg;
		this.ibflag = ibflag;
		this.n2ndImdgIbcProviCd = n2ndImdgIbcProviCd;
		this.imdgExptQtyCd = imdgExptQtyCd;
		this.lkPortAuthNo = lkPortAuthNo;
		this.n1stImdgPckProviCd = n1stImdgPckProviCd;
		this.imdgCtrlTemp = imdgCtrlTemp;
		this.flshPntTempCtnt = flshPntTempCtnt;
		this.hcdgPckRstrDesc = hcdgPckRstrDesc;
		this.imdgTecNm = imdgTecNm;
		this.cfrRptQty = cfrRptQty;
		this.cfrPsnInhZnCd = cfrPsnInhZnCd;
		this.imdgHtSrcStwgCd = imdgHtSrcStwgCd;
		this.clrLivQtrStwgFlg = clrLivQtrStwgFlg;
		this.updDt = updDt;
		this.n1stImdgIbcInstrCd = n1stImdgIbcInstrCd;
		this.imdgStwgCateCd = imdgStwgCateCd;
		this.n3rdImdgTnkInstrProviCd = n3rdImdgTnkInstrProviCd;
		this.imdgSbstPptDesc = imdgSbstPptDesc;
		this.n1stImdgTnkInstrProviCd = n1stImdgTnkInstrProviCd;
		this.n2ndImdgIbcInstrCd = n2ndImdgIbcInstrCd;
		this.imdgFdStufStwgCd = imdgFdStufStwgCd;
		this.n3rdImdgIbcProviCd = n3rdImdgIbcProviCd;
		this.imdgExptQtyDesc = imdgExptQtyDesc;
		this.imdgLmtQtyDesc = imdgLmtQtyDesc;
		this.cfrToxcCd = cfrToxcCd;
		this.imdgEmerNo = imdgEmerNo;
		this.n2ndImdgTnkInstrProviCd = n2ndImdgTnkInstrProviCd;
		this.n2ndBomPortTrstNo = n2ndBomPortTrstNo;
		this.imdgEmerTemp = imdgEmerTemp;
		this.n1stImdgUnTnkInstrCd = n1stImdgUnTnkInstrCd;
		this.hcdgTnkRstrDesc = hcdgTnkRstrDesc;
		this.imdgMrnPolutCd = imdgMrnPolutCd;
		this.cfrXtdClssCd = cfrXtdClssCd;
		this.hcdgDpndQtyFlg = hcdgDpndQtyFlg;
		this.prpShpNm = prpShpNm;
		this.cfrFlg= cfrFlg; 
		this.imdgSegrGrpNos = imdgSegrGrpNos;
		this.imdgAmdtNo = imdgAmdtNo;
		this.prpShpNmVarRmk = prpShpNmVarRmk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("n2nd_imdg_pck_provi_cd", getN2ndImdgPckProviCd());
		this.hashColumns.put("cfr_rstr_opr_nm", getCfrRstrOprNm());
		this.hashColumns.put("away_fm_imdg_segr_grp_flg", getAwayFmImdgSegrGrpFlg());
		this.hashColumns.put("imdg_un_no_seq", getImdgUnNoSeq());
		this.hashColumns.put("srl3", getSrl3());
		this.hashColumns.put("n2nd_imdg_un_tnk_instr_cd", getN2ndImdgUnTnkInstrCd());
		this.hashColumns.put("psa_no", getPsaNo());
		this.hashColumns.put("imdg_subs_rsk_lbl_rmk", getImdgSubsRskLblRmk());
		this.hashColumns.put("hcdg_rmk", getHcdgRmk());
		this.hashColumns.put("srl4", getSrl4());
		this.hashColumns.put("n2nd_imdg_pck_instr_cd", getN2ndImdgPckInstrCd());
		this.hashColumns.put("srl1", getSrl1());
		this.hashColumns.put("n1st_imdg_ibc_provi_cd", getN1stImdgIbcProviCd());
		this.hashColumns.put("srl2", getSrl2());
		this.hashColumns.put("imdg_spcl_provi_no", getImdgSpclProviNo());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("n4th_imdg_pck_provi_cd", getN4thImdgPckProviCd());
		this.hashColumns.put("imdg_comp_grp_cd", getImdgCompGrpCd());
		this.hashColumns.put("segr_desc", getSegrDesc());
		this.hashColumns.put("cfr_dg_wet_cd", getCfrDgWetCd());
		this.hashColumns.put("n4th_imdg_ibc_instr_cd", getN4thImdgIbcInstrCd());
		this.hashColumns.put("n3rd_imdg_pck_instr_cd", getN3rdImdgPckInstrCd());
		this.hashColumns.put("sprt_fm_imdg_segr_grp_flg", getSprtFmImdgSegrGrpFlg());
		this.hashColumns.put("n1st_imdg_pck_instr_cd", getN1stImdgPckInstrCd());
		this.hashColumns.put("n5th_imdg_ibc_instr_cd", getN5thImdgIbcInstrCd());
		this.hashColumns.put("n4th_imdg_tnk_instr_provi_cd", getN4thImdgTnkInstrProviCd());
		this.hashColumns.put("n4th_imdg_ibc_provi_cd", getN4thImdgIbcProviCd());
		this.hashColumns.put("n5th_imdg_pck_provi_cd", getN5thImdgPckProviCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("hcdg_flg", getHcdgFlg());
		this.hashColumns.put("imdg_un_no_hld_flg", getImdgUnNoHldFlg());
		this.hashColumns.put("n3rd_imdg_pck_provi_cd", getN3rdImdgPckProviCd());
		this.hashColumns.put("sprt_fm_imdg_clss_flg", getSprtFmImdgClssFlg());
		this.hashColumns.put("away_fm_imdg_clss_flg", getAwayFmImdgClssFlg());
		this.hashColumns.put("hcdg_intmd_bc_rstr_desc", getHcdgIntmdBcRstrDesc());
		this.hashColumns.put("n3rd_imdg_ibc_instr_cd", getN3rdImdgIbcInstrCd());
		this.hashColumns.put("segr_as_for_imdg_clss_cd", getSegrAsForImdgClssCd());
		this.hashColumns.put("n5th_imdg_tnk_instr_provi_cd", getN5thImdgTnkInstrProviCd());
		this.hashColumns.put("imdg_tbl_no", getImdgTblNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cfr_rstr_port_nm", getCfrRstrPortNm());
		this.hashColumns.put("emer_rspn_gid_no", getEmerRspnGidNo());
		this.hashColumns.put("n4th_bom_port_trst_no", getN4thBomPortTrstNo());
		this.hashColumns.put("emer_rspn_gid_chr_no", getEmerRspnGidChrNo());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		this.hashColumns.put("limited_qty", getLimitedQty());
		this.hashColumns.put("imdg_pck_grp_cd", getImdgPckGrpCd());
		this.hashColumns.put("imdg_lmt_qty_meas_ut_cd", getImdgLmtQtyMeasUtCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("n1st_bom_port_trst_no", getN1stBomPortTrstNo());
		this.hashColumns.put("pkg_auth_no", getPkgAuthNo());
		this.hashColumns.put("imdg_lmt_qty", getImdgLmtQty());
		this.hashColumns.put("n3rd_bom_port_trst_no", getN3rdBomPortTrstNo());
		this.hashColumns.put("n5th_imdg_ibc_provi_cd", getN5thImdgIbcProviCd());
		this.hashColumns.put("segr_as_for_imdg_clss_flg", getSegrAsForImdgClssFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("n2nd_imdg_ibc_provi_cd", getN2ndImdgIbcProviCd());
		this.hashColumns.put("imdg_expt_qty_cd", getImdgExptQtyCd());
		this.hashColumns.put("lk_port_auth_no", getLkPortAuthNo());
		this.hashColumns.put("n1st_imdg_pck_provi_cd", getN1stImdgPckProviCd());
		this.hashColumns.put("imdg_ctrl_temp", getImdgCtrlTemp());
		this.hashColumns.put("flsh_pnt_temp_ctnt", getFlshPntTempCtnt());
		this.hashColumns.put("hcdg_pck_rstr_desc", getHcdgPckRstrDesc());
		this.hashColumns.put("imdg_tec_nm", getImdgTecNm());
		this.hashColumns.put("cfr_rpt_qty", getCfrRptQty());
		this.hashColumns.put("cfr_psn_inh_zn_cd", getCfrPsnInhZnCd());
		this.hashColumns.put("imdg_ht_src_stwg_cd", getImdgHtSrcStwgCd());
		this.hashColumns.put("clr_liv_qtr_stwg_flg", getClrLivQtrStwgFlg());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("n1st_imdg_ibc_instr_cd", getN1stImdgIbcInstrCd());
		this.hashColumns.put("imdg_stwg_cate_cd", getImdgStwgCateCd());
		this.hashColumns.put("n3rd_imdg_tnk_instr_provi_cd", getN3rdImdgTnkInstrProviCd());
		this.hashColumns.put("imdg_sbst_ppt_desc", getImdgSbstPptDesc());
		this.hashColumns.put("n1st_imdg_tnk_instr_provi_cd", getN1stImdgTnkInstrProviCd());
		this.hashColumns.put("n2nd_imdg_ibc_instr_cd", getN2ndImdgIbcInstrCd());
		this.hashColumns.put("imdg_fd_stuf_stwg_cd", getImdgFdStufStwgCd());
		this.hashColumns.put("n3rd_imdg_ibc_provi_cd", getN3rdImdgIbcProviCd());
		this.hashColumns.put("imdg_expt_qty_desc", getImdgExptQtyDesc());
		this.hashColumns.put("imdg_lmt_qty_desc", getImdgLmtQtyDesc());
		this.hashColumns.put("cfr_toxc_cd", getCfrToxcCd());
		this.hashColumns.put("imdg_emer_no", getImdgEmerNo());
		this.hashColumns.put("n2nd_imdg_tnk_instr_provi_cd", getN2ndImdgTnkInstrProviCd());
		this.hashColumns.put("n2nd_bom_port_trst_no", getN2ndBomPortTrstNo());
		this.hashColumns.put("imdg_emer_temp", getImdgEmerTemp());
		this.hashColumns.put("n1st_imdg_un_tnk_instr_cd", getN1stImdgUnTnkInstrCd());
		this.hashColumns.put("hcdg_tnk_rstr_desc", getHcdgTnkRstrDesc());
		this.hashColumns.put("imdg_mrn_polut_cd", getImdgMrnPolutCd());
		this.hashColumns.put("cfr_xtd_clss_cd", getCfrXtdClssCd());
		this.hashColumns.put("hcdg_dpnd_qty_flg", getHcdgDpndQtyFlg());
		this.hashColumns.put("prp_shp_nm", getPrpShpNm());
		this.hashColumns.put("cfr_flg", getCfrFlg());
		this.hashColumns.put("imdg_segr_grp_nos", getImdgSegrGrpNos());
		this.hashColumns.put("imdg_amdt_no", getImdgAmdtNo());
		this.hashColumns.put("prp_shp_nm_var_rmk", getPrpShpNmVarRmk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("n2nd_imdg_pck_provi_cd", "n2ndImdgPckProviCd");
		this.hashFields.put("cfr_rstr_opr_nm", "cfrRstrOprNm");
		this.hashFields.put("away_fm_imdg_segr_grp_flg", "awayFmImdgSegrGrpFlg");
		this.hashFields.put("imdg_un_no_seq", "imdgUnNoSeq");
		this.hashFields.put("srl3", "srl3");
		this.hashFields.put("n2nd_imdg_un_tnk_instr_cd", "n2ndImdgUnTnkInstrCd");
		this.hashFields.put("psa_no", "psaNo");
		this.hashFields.put("imdg_subs_rsk_lbl_rmk", "imdgSubsRskLblRmk");
		this.hashFields.put("hcdg_rmk", "hcdgRmk");
		this.hashFields.put("srl4", "srl4");
		this.hashFields.put("n2nd_imdg_pck_instr_cd", "n2ndImdgPckInstrCd");
		this.hashFields.put("srl1", "srl1");
		this.hashFields.put("n1st_imdg_ibc_provi_cd", "n1stImdgIbcProviCd");
		this.hashFields.put("srl2", "srl2");
		this.hashFields.put("imdg_spcl_provi_no", "imdgSpclProviNo");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("n4th_imdg_pck_provi_cd", "n4thImdgPckProviCd");
		this.hashFields.put("imdg_comp_grp_cd", "imdgCompGrpCd");
		this.hashFields.put("segr_desc", "segrDesc");
		this.hashFields.put("cfr_dg_wet_cd", "cfrDgWetCd");
		this.hashFields.put("n4th_imdg_ibc_instr_cd", "n4thImdgIbcInstrCd");
		this.hashFields.put("n3rd_imdg_pck_instr_cd", "n3rdImdgPckInstrCd");
		this.hashFields.put("sprt_fm_imdg_segr_grp_flg", "sprtFmImdgSegrGrpFlg");
		this.hashFields.put("n1st_imdg_pck_instr_cd", "n1stImdgPckInstrCd");
		this.hashFields.put("n5th_imdg_ibc_instr_cd", "n5thImdgIbcInstrCd");
		this.hashFields.put("n4th_imdg_tnk_instr_provi_cd", "n4thImdgTnkInstrProviCd");
		this.hashFields.put("n4th_imdg_ibc_provi_cd", "n4thImdgIbcProviCd");
		this.hashFields.put("n5th_imdg_pck_provi_cd", "n5thImdgPckProviCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("hcdg_flg", "hcdgFlg");
		this.hashFields.put("imdg_un_no_hld_flg", "imdgUnNoHldFlg");
		this.hashFields.put("n3rd_imdg_pck_provi_cd", "n3rdImdgPckProviCd");
		this.hashFields.put("sprt_fm_imdg_clss_flg", "sprtFmImdgClssFlg");
		this.hashFields.put("away_fm_imdg_clss_flg", "awayFmImdgClssFlg");
		this.hashFields.put("hcdg_intmd_bc_rstr_desc", "hcdgIntmdBcRstrDesc");
		this.hashFields.put("n3rd_imdg_ibc_instr_cd", "n3rdImdgIbcInstrCd");
		this.hashFields.put("segr_as_for_imdg_clss_cd", "segrAsForImdgClssCd");
		this.hashFields.put("n5th_imdg_tnk_instr_provi_cd", "n5thImdgTnkInstrProviCd");
		this.hashFields.put("imdg_tbl_no", "imdgTblNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cfr_rstr_port_nm", "cfrRstrPortNm");
		this.hashFields.put("emer_rspn_gid_no", "emerRspnGidNo");
		this.hashFields.put("n4th_bom_port_trst_no", "n4thBomPortTrstNo");
		this.hashFields.put("emer_rspn_gid_chr_no", "emerRspnGidChrNo");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("limited_qty", "limitedQty");
		this.hashFields.put("imdg_pck_grp_cd", "imdgPckGrpCd");
		this.hashFields.put("imdg_lmt_qty_meas_ut_cd", "imdgLmtQtyMeasUtCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("n1st_bom_port_trst_no", "n1stBomPortTrstNo");
		this.hashFields.put("pkg_auth_no", "pkgAuthNo");
		this.hashFields.put("imdg_lmt_qty", "imdgLmtQty");
		this.hashFields.put("n3rd_bom_port_trst_no", "n3rdBomPortTrstNo");
		this.hashFields.put("n5th_imdg_ibc_provi_cd", "n5thImdgIbcProviCd");
		this.hashFields.put("segr_as_for_imdg_clss_flg", "segrAsForImdgClssFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("n2nd_imdg_ibc_provi_cd", "n2ndImdgIbcProviCd");
		this.hashFields.put("imdg_expt_qty_cd", "imdgExptQtyCd");
		this.hashFields.put("lk_port_auth_no", "lkPortAuthNo");
		this.hashFields.put("n1st_imdg_pck_provi_cd", "n1stImdgPckProviCd");
		this.hashFields.put("imdg_ctrl_temp", "imdgCtrlTemp");
		this.hashFields.put("flsh_pnt_temp_ctnt", "flshPntTempCtnt");
		this.hashFields.put("hcdg_pck_rstr_desc", "hcdgPckRstrDesc");
		this.hashFields.put("imdg_tec_nm", "imdgTecNm");
		this.hashFields.put("cfr_rpt_qty", "cfrRptQty");
		this.hashFields.put("cfr_psn_inh_zn_cd", "cfrPsnInhZnCd");
		this.hashFields.put("imdg_ht_src_stwg_cd", "imdgHtSrcStwgCd");
		this.hashFields.put("clr_liv_qtr_stwg_flg", "clrLivQtrStwgFlg");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("n1st_imdg_ibc_instr_cd", "n1stImdgIbcInstrCd");
		this.hashFields.put("imdg_stwg_cate_cd", "imdgStwgCateCd");
		this.hashFields.put("n3rd_imdg_tnk_instr_provi_cd", "n3rdImdgTnkInstrProviCd");
		this.hashFields.put("imdg_sbst_ppt_desc", "imdgSbstPptDesc");
		this.hashFields.put("n1st_imdg_tnk_instr_provi_cd", "n1stImdgTnkInstrProviCd");
		this.hashFields.put("n2nd_imdg_ibc_instr_cd", "n2ndImdgIbcInstrCd");
		this.hashFields.put("imdg_fd_stuf_stwg_cd", "imdgFdStufStwgCd");
		this.hashFields.put("n3rd_imdg_ibc_provi_cd", "n3rdImdgIbcProviCd");
		this.hashFields.put("imdg_expt_qty_desc", "imdgExptQtyDesc");
		this.hashFields.put("imdg_lmt_qty_desc", "imdgLmtQtyDesc");
		this.hashFields.put("cfr_toxc_cd", "cfrToxcCd");
		this.hashFields.put("imdg_emer_no", "imdgEmerNo");
		this.hashFields.put("n2nd_imdg_tnk_instr_provi_cd", "n2ndImdgTnkInstrProviCd");
		this.hashFields.put("n2nd_bom_port_trst_no", "n2ndBomPortTrstNo");
		this.hashFields.put("imdg_emer_temp", "imdgEmerTemp");
		this.hashFields.put("n1st_imdg_un_tnk_instr_cd", "n1stImdgUnTnkInstrCd");
		this.hashFields.put("hcdg_tnk_rstr_desc", "hcdgTnkRstrDesc");
		this.hashFields.put("imdg_mrn_polut_cd", "imdgMrnPolutCd");
		this.hashFields.put("cfr_xtd_clss_cd", "cfrXtdClssCd");
		this.hashFields.put("hcdg_dpnd_qty_flg", "hcdgDpndQtyFlg");
		this.hashFields.put("prp_shp_nm", "prpShpNm");
		this.hashFields.put("cfr_flg", "cfrFlg");
		this.hashFields.put("imdg_segr_grp_nos", "imdgSegrGrpNos");
		this.hashFields.put("imdg_amdt_no", "imdgAmdtNo");
		this.hashFields.put("prp_shp_nm_var_rmk", "prpShpNmVarRmk");
		return this.hashFields;
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
	 * @return awayFmImdgSegrGrpFlg
	 */
	public String getAwayFmImdgSegrGrpFlg() {
		return this.awayFmImdgSegrGrpFlg;
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
	 * @return srl3
	 */
	public String getSrl3() {
		return this.srl3;
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
	 * @return psaNo
	 */
	public String getPsaNo() {
		return this.psaNo;
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
	 * @return hcdgRmk
	 */
	public String getHcdgRmk() {
		return this.hcdgRmk;
	}
	
	/**
	 * Column Info
	 * @return srl4
	 */
	public String getSrl4() {
		return this.srl4;
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
	 * @return srl1
	 */
	public String getSrl1() {
		return this.srl1;
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
	 * @return srl2
	 */
	public String getSrl2() {
		return this.srl2;
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
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
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
	 * @return n4thImdgPckProviCd
	 */
	public String getN4thImdgPckProviCd() {
		return this.n4thImdgPckProviCd;
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
	 * @return n4thImdgIbcProviCd
	 */
	public String getN4thImdgIbcProviCd() {
		return this.n4thImdgIbcProviCd;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @return hcdgFlg
	 */
	public String getHcdgFlg() {
		return this.hcdgFlg;
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
	 * @return hcdgIntmdBcRstrDesc
	 */
	public String getHcdgIntmdBcRstrDesc() {
		return this.hcdgIntmdBcRstrDesc;
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
	 * @return imdgTblNo
	 */
	public String getImdgTblNo() {
		return this.imdgTblNo;
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
	 * @return n4thBomPortTrstNo
	 */
	public String getN4thBomPortTrstNo() {
		return this.n4thBomPortTrstNo;
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
	 * @return imdgClssCd
	 */
	public String getImdgClssCd() {
		return this.imdgClssCd;
	}
	
	/**
	 * Column Info
	 * @return limitedQty
	 */
	public String getLimitedQty() {
		return this.limitedQty;
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
	 * @return imdgLmtQtyMeasUtCd
	 */
	public String getImdgLmtQtyMeasUtCd() {
		return this.imdgLmtQtyMeasUtCd;
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
	 * @return n1stBomPortTrstNo
	 */
	public String getN1stBomPortTrstNo() {
		return this.n1stBomPortTrstNo;
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
	 * @return imdgCtrlTemp
	 */
	public String getImdgCtrlTemp() {
		return this.imdgCtrlTemp;
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
	 * @return hcdgPckRstrDesc
	 */
	public String getHcdgPckRstrDesc() {
		return this.hcdgPckRstrDesc;
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
	 * @return cfrRptQty
	 */
	public String getCfrRptQty() {
		return this.cfrRptQty;
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
	 * @return n3rdImdgTnkInstrProviCd
	 */
	public String getN3rdImdgTnkInstrProviCd() {
		return this.n3rdImdgTnkInstrProviCd;
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
	 * @return n3rdImdgIbcProviCd
	 */
	public String getN3rdImdgIbcProviCd() {
		return this.n3rdImdgIbcProviCd;
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
	 * @return imdgLmtQtyDesc
	 */
	public String getImdgLmtQtyDesc() {
		return this.imdgLmtQtyDesc;
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
	 * @return imdgEmerNo
	 */
	public String getImdgEmerNo() {
		return this.imdgEmerNo;
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
	 * @return n1stImdgUnTnkInstrCd
	 */
	public String getN1stImdgUnTnkInstrCd() {
		return this.n1stImdgUnTnkInstrCd;
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
	 * @return prpShpNm
	 */
	public String getPrpShpNm() {
		return this.prpShpNm;
	}
	
	/**
	 * Column Info
	 * @return cfrFlg
	 */
	public String getCfrFlg() {
		return this.cfrFlg;
	}
	
	/**
	 * Column Info
	 * @return imdgSegrGrpNos
	 */
	public String getImdgSegrGrpNos() {
		return this.imdgSegrGrpNos;
	}
	
	/**
	 * Column Info
	 * @return imdgAmdtNo
	 */
	public String getImdgAmdtNo() {
		return this.imdgAmdtNo;
	}
	
	/**
	 * Column Info
	 * @return prpShpNmVarRmk
	 */
	public String getPrpShpNmVarRmk() {
		return this.prpShpNmVarRmk;
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
	 * @param awayFmImdgSegrGrpFlg
	 */
	public void setAwayFmImdgSegrGrpFlg(String awayFmImdgSegrGrpFlg) {
		this.awayFmImdgSegrGrpFlg = awayFmImdgSegrGrpFlg;
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
	 * @param srl3
	 */
	public void setSrl3(String srl3) {
		this.srl3 = srl3;
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
	 * @param psaNo
	 */
	public void setPsaNo(String psaNo) {
		this.psaNo = psaNo;
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
	 * @param hcdgRmk
	 */
	public void setHcdgRmk(String hcdgRmk) {
		this.hcdgRmk = hcdgRmk;
	}
	
	/**
	 * Column Info
	 * @param srl4
	 */
	public void setSrl4(String srl4) {
		this.srl4 = srl4;
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
	 * @param srl1
	 */
	public void setSrl1(String srl1) {
		this.srl1 = srl1;
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
	 * @param srl2
	 */
	public void setSrl2(String srl2) {
		this.srl2 = srl2;
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
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
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
	 * @param n4thImdgPckProviCd
	 */
	public void setN4thImdgPckProviCd(String n4thImdgPckProviCd) {
		this.n4thImdgPckProviCd = n4thImdgPckProviCd;
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
	 * @param n4thImdgIbcProviCd
	 */
	public void setN4thImdgIbcProviCd(String n4thImdgIbcProviCd) {
		this.n4thImdgIbcProviCd = n4thImdgIbcProviCd;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
	 * @param hcdgFlg
	 */
	public void setHcdgFlg(String hcdgFlg) {
		this.hcdgFlg = hcdgFlg;
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
	 * @param hcdgIntmdBcRstrDesc
	 */
	public void setHcdgIntmdBcRstrDesc(String hcdgIntmdBcRstrDesc) {
		this.hcdgIntmdBcRstrDesc = hcdgIntmdBcRstrDesc;
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
	 * @param imdgTblNo
	 */
	public void setImdgTblNo(String imdgTblNo) {
		this.imdgTblNo = imdgTblNo;
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
	 * @param n4thBomPortTrstNo
	 */
	public void setN4thBomPortTrstNo(String n4thBomPortTrstNo) {
		this.n4thBomPortTrstNo = n4thBomPortTrstNo;
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
	 * @param imdgClssCd
	 */
	public void setImdgClssCd(String imdgClssCd) {
		this.imdgClssCd = imdgClssCd;
	}
	
	/**
	 * Column Info
	 * @param limitedQty
	 */
	public void setLimitedQty(String limitedQty) {
		this.limitedQty = limitedQty;
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
	 * @param imdgLmtQtyMeasUtCd
	 */
	public void setImdgLmtQtyMeasUtCd(String imdgLmtQtyMeasUtCd) {
		this.imdgLmtQtyMeasUtCd = imdgLmtQtyMeasUtCd;
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
	 * @param n1stBomPortTrstNo
	 */
	public void setN1stBomPortTrstNo(String n1stBomPortTrstNo) {
		this.n1stBomPortTrstNo = n1stBomPortTrstNo;
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
	 * @param imdgCtrlTemp
	 */
	public void setImdgCtrlTemp(String imdgCtrlTemp) {
		this.imdgCtrlTemp = imdgCtrlTemp;
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
	 * @param hcdgPckRstrDesc
	 */
	public void setHcdgPckRstrDesc(String hcdgPckRstrDesc) {
		this.hcdgPckRstrDesc = hcdgPckRstrDesc;
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
	 * @param cfrRptQty
	 */
	public void setCfrRptQty(String cfrRptQty) {
		this.cfrRptQty = cfrRptQty;
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
	 * @param n3rdImdgTnkInstrProviCd
	 */
	public void setN3rdImdgTnkInstrProviCd(String n3rdImdgTnkInstrProviCd) {
		this.n3rdImdgTnkInstrProviCd = n3rdImdgTnkInstrProviCd;
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
	 * @param n3rdImdgIbcProviCd
	 */
	public void setN3rdImdgIbcProviCd(String n3rdImdgIbcProviCd) {
		this.n3rdImdgIbcProviCd = n3rdImdgIbcProviCd;
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
	 * @param imdgLmtQtyDesc
	 */
	public void setImdgLmtQtyDesc(String imdgLmtQtyDesc) {
		this.imdgLmtQtyDesc = imdgLmtQtyDesc;
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
	 * @param imdgEmerNo
	 */
	public void setImdgEmerNo(String imdgEmerNo) {
		this.imdgEmerNo = imdgEmerNo;
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
	 * @param n1stImdgUnTnkInstrCd
	 */
	public void setN1stImdgUnTnkInstrCd(String n1stImdgUnTnkInstrCd) {
		this.n1stImdgUnTnkInstrCd = n1stImdgUnTnkInstrCd;
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
	 * @param prpShpNm
	 */
	public void setPrpShpNm(String prpShpNm) {
		this.prpShpNm = prpShpNm;
	}
	
	/**
	 * Column Info
	 * @return cfrFlg
	 */
	public void setCfrFlg(String cfrFlg) {
		this.cfrFlg = cfrFlg;
	}
	
	/**
	 * Column Info
	 * @param imdgSegrGrpNos
	 */
	public void setImdgSegrGrpNos(String imdgSegrGrpNos) {
		this.imdgSegrGrpNos = imdgSegrGrpNos;
	}
	
	/**
	 * Column Info
	 * @param imdgAmdtNo
	 */
	public void setImdgAmdtNo(String imdgAmdtNo) {
		this.imdgAmdtNo = imdgAmdtNo;
	}
	
	/**
	 * Column Info
	 * @param prpShpNmVarRmk
	 */
	public void setPrpShpNmVarRmk(String prpShpNmVarRmk) {
		this.prpShpNmVarRmk = prpShpNmVarRmk;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setN2ndImdgPckProviCd(JSPUtil.getParameter(request, "n2nd_imdg_pck_provi_cd", ""));
		setCfrRstrOprNm(JSPUtil.getParameter(request, "cfr_rstr_opr_nm", ""));
		setAwayFmImdgSegrGrpFlg(JSPUtil.getParameter(request, "away_fm_imdg_segr_grp_flg", ""));
		setImdgUnNoSeq(JSPUtil.getParameter(request, "imdg_un_no_seq", ""));
		setSrl3(JSPUtil.getParameter(request, "srl3", ""));
		setN2ndImdgUnTnkInstrCd(JSPUtil.getParameter(request, "n2nd_imdg_un_tnk_instr_cd", ""));
		setPsaNo(JSPUtil.getParameter(request, "psa_no", ""));
		setImdgSubsRskLblRmk(JSPUtil.getParameter(request, "imdg_subs_rsk_lbl_rmk", ""));
		setHcdgRmk(JSPUtil.getParameter(request, "hcdg_rmk", ""));
		setSrl4(JSPUtil.getParameter(request, "srl4", ""));
		setN2ndImdgPckInstrCd(JSPUtil.getParameter(request, "n2nd_imdg_pck_instr_cd", ""));
		setSrl1(JSPUtil.getParameter(request, "srl1", ""));
		setN1stImdgIbcProviCd(JSPUtil.getParameter(request, "n1st_imdg_ibc_provi_cd", ""));
		setSrl2(JSPUtil.getParameter(request, "srl2", ""));
		setImdgSpclProviNo(JSPUtil.getParameter(request, "imdg_spcl_provi_no", ""));
		setCrrCd(JSPUtil.getParameter(request, "crr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setN4thImdgPckProviCd(JSPUtil.getParameter(request, "n4th_imdg_pck_provi_cd", ""));
		setImdgCompGrpCd(JSPUtil.getParameter(request, "imdg_comp_grp_cd", ""));
		setSegrDesc(JSPUtil.getParameter(request, "segr_desc", ""));
		setCfrDgWetCd(JSPUtil.getParameter(request, "cfr_dg_wet_cd", ""));
		setN4thImdgIbcInstrCd(JSPUtil.getParameter(request, "n4th_imdg_ibc_instr_cd", ""));
		setN3rdImdgPckInstrCd(JSPUtil.getParameter(request, "n3rd_imdg_pck_instr_cd", ""));
		setSprtFmImdgSegrGrpFlg(JSPUtil.getParameter(request, "sprt_fm_imdg_segr_grp_flg", ""));
		setN1stImdgPckInstrCd(JSPUtil.getParameter(request, "n1st_imdg_pck_instr_cd", ""));
		setN5thImdgIbcInstrCd(JSPUtil.getParameter(request, "n5th_imdg_ibc_instr_cd", ""));
		setN4thImdgTnkInstrProviCd(JSPUtil.getParameter(request, "n4th_imdg_tnk_instr_provi_cd", ""));
		setN4thImdgIbcProviCd(JSPUtil.getParameter(request, "n4th_imdg_ibc_provi_cd", ""));
		setN5thImdgPckProviCd(JSPUtil.getParameter(request, "n5th_imdg_pck_provi_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setImdgUnNo(JSPUtil.getParameter(request, "imdg_un_no", ""));
		setHcdgFlg(JSPUtil.getParameter(request, "hcdg_flg", ""));
		setImdgUnNoHldFlg(JSPUtil.getParameter(request, "imdg_un_no_hld_flg", ""));
		setN3rdImdgPckProviCd(JSPUtil.getParameter(request, "n3rd_imdg_pck_provi_cd", ""));
		setSprtFmImdgClssFlg(JSPUtil.getParameter(request, "sprt_fm_imdg_clss_flg", ""));
		setAwayFmImdgClssFlg(JSPUtil.getParameter(request, "away_fm_imdg_clss_flg", ""));
		setHcdgIntmdBcRstrDesc(JSPUtil.getParameter(request, "hcdg_intmd_bc_rstr_desc", ""));
		setN3rdImdgIbcInstrCd(JSPUtil.getParameter(request, "n3rd_imdg_ibc_instr_cd", ""));
		setSegrAsForImdgClssCd(JSPUtil.getParameter(request, "segr_as_for_imdg_clss_cd", ""));
		setN5thImdgTnkInstrProviCd(JSPUtil.getParameter(request, "n5th_imdg_tnk_instr_provi_cd", ""));
		setImdgTblNo(JSPUtil.getParameter(request, "imdg_tbl_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setCfrRstrPortNm(JSPUtil.getParameter(request, "cfr_rstr_port_nm", ""));
		setEmerRspnGidNo(JSPUtil.getParameter(request, "emer_rspn_gid_no", ""));
		setN4thBomPortTrstNo(JSPUtil.getParameter(request, "n4th_bom_port_trst_no", ""));
		setEmerRspnGidChrNo(JSPUtil.getParameter(request, "emer_rspn_gid_chr_no", ""));
		setImdgClssCd(JSPUtil.getParameter(request, "imdg_clss_cd", ""));
		setLimitedQty(JSPUtil.getParameter(request, "limited_qty", ""));
		setImdgPckGrpCd(JSPUtil.getParameter(request, "imdg_pck_grp_cd", ""));
		setImdgLmtQtyMeasUtCd(JSPUtil.getParameter(request, "imdg_lmt_qty_meas_ut_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setN1stBomPortTrstNo(JSPUtil.getParameter(request, "n1st_bom_port_trst_no", ""));
		setPkgAuthNo(JSPUtil.getParameter(request, "pkg_auth_no", ""));
		setImdgLmtQty(JSPUtil.getParameter(request, "imdg_lmt_qty", ""));
		setN3rdBomPortTrstNo(JSPUtil.getParameter(request, "n3rd_bom_port_trst_no", ""));
		setN5thImdgIbcProviCd(JSPUtil.getParameter(request, "n5th_imdg_ibc_provi_cd", ""));
		setSegrAsForImdgClssFlg(JSPUtil.getParameter(request, "segr_as_for_imdg_clss_flg", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setN2ndImdgIbcProviCd(JSPUtil.getParameter(request, "n2nd_imdg_ibc_provi_cd", ""));
		setImdgExptQtyCd(JSPUtil.getParameter(request, "imdg_expt_qty_cd", ""));
		setLkPortAuthNo(JSPUtil.getParameter(request, "lk_port_auth_no", ""));
		setN1stImdgPckProviCd(JSPUtil.getParameter(request, "n1st_imdg_pck_provi_cd", ""));
		setImdgCtrlTemp(JSPUtil.getParameter(request, "imdg_ctrl_temp", ""));
		setFlshPntTempCtnt(JSPUtil.getParameter(request, "flsh_pnt_temp_ctnt", ""));
		setHcdgPckRstrDesc(JSPUtil.getParameter(request, "hcdg_pck_rstr_desc", ""));
		setImdgTecNm(JSPUtil.getParameter(request, "imdg_tec_nm", ""));
		setCfrRptQty(JSPUtil.getParameter(request, "cfr_rpt_qty", ""));
		setCfrPsnInhZnCd(JSPUtil.getParameter(request, "cfr_psn_inh_zn_cd", ""));
		setImdgHtSrcStwgCd(JSPUtil.getParameter(request, "imdg_ht_src_stwg_cd", ""));
		setClrLivQtrStwgFlg(JSPUtil.getParameter(request, "clr_liv_qtr_stwg_flg", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setN1stImdgIbcInstrCd(JSPUtil.getParameter(request, "n1st_imdg_ibc_instr_cd", ""));
		setImdgStwgCateCd(JSPUtil.getParameter(request, "imdg_stwg_cate_cd", ""));
		setN3rdImdgTnkInstrProviCd(JSPUtil.getParameter(request, "n3rd_imdg_tnk_instr_provi_cd", ""));
		setImdgSbstPptDesc(JSPUtil.getParameter(request, "imdg_sbst_ppt_desc", ""));
		setN1stImdgTnkInstrProviCd(JSPUtil.getParameter(request, "n1st_imdg_tnk_instr_provi_cd", ""));
		setN2ndImdgIbcInstrCd(JSPUtil.getParameter(request, "n2nd_imdg_ibc_instr_cd", ""));
		setImdgFdStufStwgCd(JSPUtil.getParameter(request, "imdg_fd_stuf_stwg_cd", ""));
		setN3rdImdgIbcProviCd(JSPUtil.getParameter(request, "n3rd_imdg_ibc_provi_cd", ""));
		setImdgExptQtyDesc(JSPUtil.getParameter(request, "imdg_expt_qty_desc", ""));
		setImdgLmtQtyDesc(JSPUtil.getParameter(request, "imdg_lmt_qty_desc", ""));
		setCfrToxcCd(JSPUtil.getParameter(request, "cfr_toxc_cd", ""));
		setImdgEmerNo(JSPUtil.getParameter(request, "imdg_emer_no", ""));
		setN2ndImdgTnkInstrProviCd(JSPUtil.getParameter(request, "n2nd_imdg_tnk_instr_provi_cd", ""));
		setN2ndBomPortTrstNo(JSPUtil.getParameter(request, "n2nd_bom_port_trst_no", ""));
		setImdgEmerTemp(JSPUtil.getParameter(request, "imdg_emer_temp", ""));
		setN1stImdgUnTnkInstrCd(JSPUtil.getParameter(request, "n1st_imdg_un_tnk_instr_cd", ""));
		setHcdgTnkRstrDesc(JSPUtil.getParameter(request, "hcdg_tnk_rstr_desc", ""));
		setImdgMrnPolutCd(JSPUtil.getParameter(request, "imdg_mrn_polut_cd", ""));
		setCfrXtdClssCd(JSPUtil.getParameter(request, "cfr_xtd_clss_cd", ""));
		setHcdgDpndQtyFlg(JSPUtil.getParameter(request, "hcdg_dpnd_qty_flg", ""));
		setPrpShpNm(JSPUtil.getParameter(request, "prp_shp_nm", ""));
		setCfrFlg(JSPUtil.getParameter(request, "cfr_flg", ""));
		setImdgSegrGrpNos(JSPUtil.getParameter(request, "imdg_segr_grp_nos", ""));
		setImdgAmdtNo(JSPUtil.getParameter(request, "imdg_amdt_no", ""));
		setPrpShpNmVarRmk(JSPUtil.getParameter(request, "prp_shp_nm_var_rmk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScgImdgUnNoVO[]
	 */
	public ScgImdgUnNoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ScgImdgUnNoVO[]
	 */
	public ScgImdgUnNoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ScgImdgUnNoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] n2ndImdgPckProviCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_imdg_pck_provi_cd", length));
			String[] cfrRstrOprNm = (JSPUtil.getParameter(request, prefix	+ "cfr_rstr_opr_nm", length));
			String[] awayFmImdgSegrGrpFlg = (JSPUtil.getParameter(request, prefix	+ "away_fm_imdg_segr_grp_flg", length));
			String[] imdgUnNoSeq = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no_seq", length));
			String[] srl3 = (JSPUtil.getParameter(request, prefix	+ "srl3", length));
			String[] n2ndImdgUnTnkInstrCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_imdg_un_tnk_instr_cd", length));
			String[] psaNo = (JSPUtil.getParameter(request, prefix	+ "psa_no", length));
			String[] imdgSubsRskLblRmk = (JSPUtil.getParameter(request, prefix	+ "imdg_subs_rsk_lbl_rmk", length));
			String[] hcdgRmk = (JSPUtil.getParameter(request, prefix	+ "hcdg_rmk", length));
			String[] srl4 = (JSPUtil.getParameter(request, prefix	+ "srl4", length));
			String[] n2ndImdgPckInstrCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_imdg_pck_instr_cd", length));
			String[] srl1 = (JSPUtil.getParameter(request, prefix	+ "srl1", length));
			String[] n1stImdgIbcProviCd = (JSPUtil.getParameter(request, prefix	+ "n1st_imdg_ibc_provi_cd", length));
			String[] srl2 = (JSPUtil.getParameter(request, prefix	+ "srl2", length));
			String[] imdgSpclProviNo = (JSPUtil.getParameter(request, prefix	+ "imdg_spcl_provi_no", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] n4thImdgPckProviCd = (JSPUtil.getParameter(request, prefix	+ "n4th_imdg_pck_provi_cd", length));
			String[] imdgCompGrpCd = (JSPUtil.getParameter(request, prefix	+ "imdg_comp_grp_cd", length));
			String[] segrDesc = (JSPUtil.getParameter(request, prefix	+ "segr_desc", length));
			String[] cfrDgWetCd = (JSPUtil.getParameter(request, prefix	+ "cfr_dg_wet_cd", length));
			String[] n4thImdgIbcInstrCd = (JSPUtil.getParameter(request, prefix	+ "n4th_imdg_ibc_instr_cd", length));
			String[] n3rdImdgPckInstrCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_imdg_pck_instr_cd", length));
			String[] sprtFmImdgSegrGrpFlg = (JSPUtil.getParameter(request, prefix	+ "sprt_fm_imdg_segr_grp_flg", length));
			String[] n1stImdgPckInstrCd = (JSPUtil.getParameter(request, prefix	+ "n1st_imdg_pck_instr_cd", length));
			String[] n5thImdgIbcInstrCd = (JSPUtil.getParameter(request, prefix	+ "n5th_imdg_ibc_instr_cd", length));
			String[] n4thImdgTnkInstrProviCd = (JSPUtil.getParameter(request, prefix	+ "n4th_imdg_tnk_instr_provi_cd", length));
			String[] n4thImdgIbcProviCd = (JSPUtil.getParameter(request, prefix	+ "n4th_imdg_ibc_provi_cd", length));
			String[] n5thImdgPckProviCd = (JSPUtil.getParameter(request, prefix	+ "n5th_imdg_pck_provi_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			String[] hcdgFlg = (JSPUtil.getParameter(request, prefix	+ "hcdg_flg", length));
			String[] imdgUnNoHldFlg = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no_hld_flg", length));
			String[] n3rdImdgPckProviCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_imdg_pck_provi_cd", length));
			String[] sprtFmImdgClssFlg = (JSPUtil.getParameter(request, prefix	+ "sprt_fm_imdg_clss_flg", length));
			String[] awayFmImdgClssFlg = (JSPUtil.getParameter(request, prefix	+ "away_fm_imdg_clss_flg", length));
			String[] hcdgIntmdBcRstrDesc = (JSPUtil.getParameter(request, prefix	+ "hcdg_intmd_bc_rstr_desc", length));
			String[] n3rdImdgIbcInstrCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_imdg_ibc_instr_cd", length));
			String[] segrAsForImdgClssCd = (JSPUtil.getParameter(request, prefix	+ "segr_as_for_imdg_clss_cd", length));
			String[] n5thImdgTnkInstrProviCd = (JSPUtil.getParameter(request, prefix	+ "n5th_imdg_tnk_instr_provi_cd", length));
			String[] imdgTblNo = (JSPUtil.getParameter(request, prefix	+ "imdg_tbl_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cfrRstrPortNm = (JSPUtil.getParameter(request, prefix	+ "cfr_rstr_port_nm", length));
			String[] emerRspnGidNo = (JSPUtil.getParameter(request, prefix	+ "emer_rspn_gid_no", length));
			String[] n4thBomPortTrstNo = (JSPUtil.getParameter(request, prefix	+ "n4th_bom_port_trst_no", length));
			String[] emerRspnGidChrNo = (JSPUtil.getParameter(request, prefix	+ "emer_rspn_gid_chr_no", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			String[] limitedQty = (JSPUtil.getParameter(request, prefix	+ "limited_qty", length));
			String[] imdgPckGrpCd = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_grp_cd", length));
			String[] imdgLmtQtyMeasUtCd = (JSPUtil.getParameter(request, prefix	+ "imdg_lmt_qty_meas_ut_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] n1stBomPortTrstNo = (JSPUtil.getParameter(request, prefix	+ "n1st_bom_port_trst_no", length));
			String[] pkgAuthNo = (JSPUtil.getParameter(request, prefix	+ "pkg_auth_no", length));
			String[] imdgLmtQty = (JSPUtil.getParameter(request, prefix	+ "imdg_lmt_qty", length));
			String[] n3rdBomPortTrstNo = (JSPUtil.getParameter(request, prefix	+ "n3rd_bom_port_trst_no", length));
			String[] n5thImdgIbcProviCd = (JSPUtil.getParameter(request, prefix	+ "n5th_imdg_ibc_provi_cd", length));
			String[] segrAsForImdgClssFlg = (JSPUtil.getParameter(request, prefix	+ "segr_as_for_imdg_clss_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] n2ndImdgIbcProviCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_imdg_ibc_provi_cd", length));
			String[] imdgExptQtyCd = (JSPUtil.getParameter(request, prefix	+ "imdg_expt_qty_cd", length));
			String[] lkPortAuthNo = (JSPUtil.getParameter(request, prefix	+ "lk_port_auth_no", length));
			String[] n1stImdgPckProviCd = (JSPUtil.getParameter(request, prefix	+ "n1st_imdg_pck_provi_cd", length));
			String[] imdgCtrlTemp = (JSPUtil.getParameter(request, prefix	+ "imdg_ctrl_temp", length));
			String[] flshPntTempCtnt = (JSPUtil.getParameter(request, prefix	+ "flsh_pnt_temp_ctnt", length));
			String[] hcdgPckRstrDesc = (JSPUtil.getParameter(request, prefix	+ "hcdg_pck_rstr_desc", length));
			String[] imdgTecNm = (JSPUtil.getParameter(request, prefix	+ "imdg_tec_nm", length));
			String[] cfrRptQty = (JSPUtil.getParameter(request, prefix	+ "cfr_rpt_qty", length));
			String[] cfrPsnInhZnCd = (JSPUtil.getParameter(request, prefix	+ "cfr_psn_inh_zn_cd", length));
			String[] imdgHtSrcStwgCd = (JSPUtil.getParameter(request, prefix	+ "imdg_ht_src_stwg_cd", length));
			String[] clrLivQtrStwgFlg = (JSPUtil.getParameter(request, prefix	+ "clr_liv_qtr_stwg_flg", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] n1stImdgIbcInstrCd = (JSPUtil.getParameter(request, prefix	+ "n1st_imdg_ibc_instr_cd", length));
			String[] imdgStwgCateCd = (JSPUtil.getParameter(request, prefix	+ "imdg_stwg_cate_cd", length));
			String[] n3rdImdgTnkInstrProviCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_imdg_tnk_instr_provi_cd", length));
			String[] imdgSbstPptDesc = (JSPUtil.getParameter(request, prefix	+ "imdg_sbst_ppt_desc", length));
			String[] n1stImdgTnkInstrProviCd = (JSPUtil.getParameter(request, prefix	+ "n1st_imdg_tnk_instr_provi_cd", length));
			String[] n2ndImdgIbcInstrCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_imdg_ibc_instr_cd", length));
			String[] imdgFdStufStwgCd = (JSPUtil.getParameter(request, prefix	+ "imdg_fd_stuf_stwg_cd", length));
			String[] n3rdImdgIbcProviCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_imdg_ibc_provi_cd", length));
			String[] imdgExptQtyDesc = (JSPUtil.getParameter(request, prefix	+ "imdg_expt_qty_desc", length));
			String[] imdgLmtQtyDesc = (JSPUtil.getParameter(request, prefix	+ "imdg_lmt_qty_desc", length));
			String[] cfrToxcCd = (JSPUtil.getParameter(request, prefix	+ "cfr_toxc_cd", length));
			String[] imdgEmerNo = (JSPUtil.getParameter(request, prefix	+ "imdg_emer_no", length));
			String[] n2ndImdgTnkInstrProviCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_imdg_tnk_instr_provi_cd", length));
			String[] n2ndBomPortTrstNo = (JSPUtil.getParameter(request, prefix	+ "n2nd_bom_port_trst_no", length));
			String[] imdgEmerTemp = (JSPUtil.getParameter(request, prefix	+ "imdg_emer_temp", length));
			String[] n1stImdgUnTnkInstrCd = (JSPUtil.getParameter(request, prefix	+ "n1st_imdg_un_tnk_instr_cd", length));
			String[] hcdgTnkRstrDesc = (JSPUtil.getParameter(request, prefix	+ "hcdg_tnk_rstr_desc", length));
			String[] imdgMrnPolutCd = (JSPUtil.getParameter(request, prefix	+ "imdg_mrn_polut_cd", length));
			String[] cfrXtdClssCd = (JSPUtil.getParameter(request, prefix	+ "cfr_xtd_clss_cd", length));
			String[] hcdgDpndQtyFlg = (JSPUtil.getParameter(request, prefix	+ "hcdg_dpnd_qty_flg", length));
			String[] prpShpNm = (JSPUtil.getParameter(request, prefix	+ "prp_shp_nm", length));
			String[] cfrFlg = (JSPUtil.getParameter(request, prefix	+ "cfr_flg".trim(), length));
			String[] imdgSegrGrpNos = (JSPUtil.getParameter(request, prefix	+ "imdg_segr_grp_nos", length));
			String[] imdgAmdtNo = (JSPUtil.getParameter(request, prefix	+ "imdg_amdt_no", length));
			String[] prpShpNmVarRmk = (JSPUtil.getParameter(request, prefix	+ "prp_shp_nm_var_rmk", length));
			
			for (int i = 0; i < length; i++) {
				model = new ScgImdgUnNoVO();
				if (n2ndImdgPckProviCd[i] != null)
					model.setN2ndImdgPckProviCd(n2ndImdgPckProviCd[i]);
				if (cfrRstrOprNm[i] != null)
					model.setCfrRstrOprNm(cfrRstrOprNm[i]);
				if (awayFmImdgSegrGrpFlg[i] != null)
					model.setAwayFmImdgSegrGrpFlg(awayFmImdgSegrGrpFlg[i]);
				if (imdgUnNoSeq[i] != null)
					model.setImdgUnNoSeq(imdgUnNoSeq[i]);
				if (srl3[i] != null)
					model.setSrl3(srl3[i]);
				if (n2ndImdgUnTnkInstrCd[i] != null)
					model.setN2ndImdgUnTnkInstrCd(n2ndImdgUnTnkInstrCd[i]);
				if (psaNo[i] != null)
					model.setPsaNo(psaNo[i]);
				if (imdgSubsRskLblRmk[i] != null)
					model.setImdgSubsRskLblRmk(imdgSubsRskLblRmk[i]);
				if (hcdgRmk[i] != null)
					model.setHcdgRmk(hcdgRmk[i]);
				if (srl4[i] != null)
					model.setSrl4(srl4[i]);
				if (n2ndImdgPckInstrCd[i] != null)
					model.setN2ndImdgPckInstrCd(n2ndImdgPckInstrCd[i]);
				if (srl1[i] != null)
					model.setSrl1(srl1[i]);
				if (n1stImdgIbcProviCd[i] != null)
					model.setN1stImdgIbcProviCd(n1stImdgIbcProviCd[i]);
				if (srl2[i] != null)
					model.setSrl2(srl2[i]);
				if (imdgSpclProviNo[i] != null)
					model.setImdgSpclProviNo(imdgSpclProviNo[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (n4thImdgPckProviCd[i] != null)
					model.setN4thImdgPckProviCd(n4thImdgPckProviCd[i]);
				if (imdgCompGrpCd[i] != null)
					model.setImdgCompGrpCd(imdgCompGrpCd[i]);
				if (segrDesc[i] != null)
					model.setSegrDesc(segrDesc[i]);
				if (cfrDgWetCd[i] != null)
					model.setCfrDgWetCd(cfrDgWetCd[i]);
				if (n4thImdgIbcInstrCd[i] != null)
					model.setN4thImdgIbcInstrCd(n4thImdgIbcInstrCd[i]);
				if (n3rdImdgPckInstrCd[i] != null)
					model.setN3rdImdgPckInstrCd(n3rdImdgPckInstrCd[i]);
				if (sprtFmImdgSegrGrpFlg[i] != null)
					model.setSprtFmImdgSegrGrpFlg(sprtFmImdgSegrGrpFlg[i]);
				if (n1stImdgPckInstrCd[i] != null)
					model.setN1stImdgPckInstrCd(n1stImdgPckInstrCd[i]);
				if (n5thImdgIbcInstrCd[i] != null)
					model.setN5thImdgIbcInstrCd(n5thImdgIbcInstrCd[i]);
				if (n4thImdgTnkInstrProviCd[i] != null)
					model.setN4thImdgTnkInstrProviCd(n4thImdgTnkInstrProviCd[i]);
				if (n4thImdgIbcProviCd[i] != null)
					model.setN4thImdgIbcProviCd(n4thImdgIbcProviCd[i]);
				if (n5thImdgPckProviCd[i] != null)
					model.setN5thImdgPckProviCd(n5thImdgPckProviCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (hcdgFlg[i] != null)
					model.setHcdgFlg(hcdgFlg[i]);
				if (imdgUnNoHldFlg[i] != null)
					model.setImdgUnNoHldFlg(imdgUnNoHldFlg[i]);
				if (n3rdImdgPckProviCd[i] != null)
					model.setN3rdImdgPckProviCd(n3rdImdgPckProviCd[i]);
				if (sprtFmImdgClssFlg[i] != null)
					model.setSprtFmImdgClssFlg(sprtFmImdgClssFlg[i]);
				if (awayFmImdgClssFlg[i] != null)
					model.setAwayFmImdgClssFlg(awayFmImdgClssFlg[i]);
				if (hcdgIntmdBcRstrDesc[i] != null)
					model.setHcdgIntmdBcRstrDesc(hcdgIntmdBcRstrDesc[i]);
				if (n3rdImdgIbcInstrCd[i] != null)
					model.setN3rdImdgIbcInstrCd(n3rdImdgIbcInstrCd[i]);
				if (segrAsForImdgClssCd[i] != null)
					model.setSegrAsForImdgClssCd(segrAsForImdgClssCd[i]);
				if (n5thImdgTnkInstrProviCd[i] != null)
					model.setN5thImdgTnkInstrProviCd(n5thImdgTnkInstrProviCd[i]);
				if (imdgTblNo[i] != null)
					model.setImdgTblNo(imdgTblNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cfrRstrPortNm[i] != null)
					model.setCfrRstrPortNm(cfrRstrPortNm[i]);
				if (emerRspnGidNo[i] != null)
					model.setEmerRspnGidNo(emerRspnGidNo[i]);
				if (n4thBomPortTrstNo[i] != null)
					model.setN4thBomPortTrstNo(n4thBomPortTrstNo[i]);
				if (emerRspnGidChrNo[i] != null)
					model.setEmerRspnGidChrNo(emerRspnGidChrNo[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				if (limitedQty[i] != null)
					model.setLimitedQty(limitedQty[i]);
				if (imdgPckGrpCd[i] != null)
					model.setImdgPckGrpCd(imdgPckGrpCd[i]);
				if (imdgLmtQtyMeasUtCd[i] != null)
					model.setImdgLmtQtyMeasUtCd(imdgLmtQtyMeasUtCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (n1stBomPortTrstNo[i] != null)
					model.setN1stBomPortTrstNo(n1stBomPortTrstNo[i]);
				if (pkgAuthNo[i] != null)
					model.setPkgAuthNo(pkgAuthNo[i]);
				if (imdgLmtQty[i] != null)
					model.setImdgLmtQty(imdgLmtQty[i]);
				if (n3rdBomPortTrstNo[i] != null)
					model.setN3rdBomPortTrstNo(n3rdBomPortTrstNo[i]);
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
				if (imdgCtrlTemp[i] != null)
					model.setImdgCtrlTemp(imdgCtrlTemp[i]);
				if (flshPntTempCtnt[i] != null)
					model.setFlshPntTempCtnt(flshPntTempCtnt[i]);
				if (hcdgPckRstrDesc[i] != null)
					model.setHcdgPckRstrDesc(hcdgPckRstrDesc[i]);
				if (imdgTecNm[i] != null)
					model.setImdgTecNm(imdgTecNm[i]);
				if (cfrRptQty[i] != null)
					model.setCfrRptQty(cfrRptQty[i]);
				if (cfrPsnInhZnCd[i] != null)
					model.setCfrPsnInhZnCd(cfrPsnInhZnCd[i]);
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
				if (n3rdImdgTnkInstrProviCd[i] != null)
					model.setN3rdImdgTnkInstrProviCd(n3rdImdgTnkInstrProviCd[i]);
				if (imdgSbstPptDesc[i] != null)
					model.setImdgSbstPptDesc(imdgSbstPptDesc[i]);
				if (n1stImdgTnkInstrProviCd[i] != null)
					model.setN1stImdgTnkInstrProviCd(n1stImdgTnkInstrProviCd[i]);
				if (n2ndImdgIbcInstrCd[i] != null)
					model.setN2ndImdgIbcInstrCd(n2ndImdgIbcInstrCd[i]);
				if (imdgFdStufStwgCd[i] != null)
					model.setImdgFdStufStwgCd(imdgFdStufStwgCd[i]);
				if (n3rdImdgIbcProviCd[i] != null)
					model.setN3rdImdgIbcProviCd(n3rdImdgIbcProviCd[i]);
				if (imdgExptQtyDesc[i] != null)
					model.setImdgExptQtyDesc(imdgExptQtyDesc[i]);
				if (imdgLmtQtyDesc[i] != null)
					model.setImdgLmtQtyDesc(imdgLmtQtyDesc[i]);
				if (cfrToxcCd[i] != null)
					model.setCfrToxcCd(cfrToxcCd[i]);
				if (imdgEmerNo[i] != null)
					model.setImdgEmerNo(imdgEmerNo[i]);
				if (n2ndImdgTnkInstrProviCd[i] != null)
					model.setN2ndImdgTnkInstrProviCd(n2ndImdgTnkInstrProviCd[i]);
				if (n2ndBomPortTrstNo[i] != null)
					model.setN2ndBomPortTrstNo(n2ndBomPortTrstNo[i]);
				if (imdgEmerTemp[i] != null)
					model.setImdgEmerTemp(imdgEmerTemp[i]);
				if (n1stImdgUnTnkInstrCd[i] != null)
					model.setN1stImdgUnTnkInstrCd(n1stImdgUnTnkInstrCd[i]);
				if (hcdgTnkRstrDesc[i] != null)
					model.setHcdgTnkRstrDesc(hcdgTnkRstrDesc[i]);
				if (imdgMrnPolutCd[i] != null)
					model.setImdgMrnPolutCd(imdgMrnPolutCd[i]);
				if (cfrXtdClssCd[i] != null)
					model.setCfrXtdClssCd(cfrXtdClssCd[i]);
				if (hcdgDpndQtyFlg[i] != null)
					model.setHcdgDpndQtyFlg(hcdgDpndQtyFlg[i]);
				if (prpShpNm[i] != null)
					model.setPrpShpNm(prpShpNm[i]);
				if (cfrFlg[i] != null)
					model.setCfrFlg(cfrFlg[i]);
				if (imdgSegrGrpNos[i] != null)
					model.setImdgSegrGrpNos(imdgSegrGrpNos[i]);
				if (imdgAmdtNo[i] != null)
					model.setImdgAmdtNo(imdgAmdtNo[i]);
				if (prpShpNmVarRmk[i] != null)
					model.setPrpShpNmVarRmk(prpShpNmVarRmk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getScgImdgUnNoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ScgImdgUnNoVO[]
	 */
	public ScgImdgUnNoVO[] getScgImdgUnNoVOs(){
		ScgImdgUnNoVO[] vos = (ScgImdgUnNoVO[])models.toArray(new ScgImdgUnNoVO[models.size()]);
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
		this.n2ndImdgPckProviCd = this.n2ndImdgPckProviCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfrRstrOprNm = this.cfrRstrOprNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awayFmImdgSegrGrpFlg = this.awayFmImdgSegrGrpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNoSeq = this.imdgUnNoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srl3 = this.srl3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndImdgUnTnkInstrCd = this.n2ndImdgUnTnkInstrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psaNo = this.psaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSubsRskLblRmk = this.imdgSubsRskLblRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcdgRmk = this.hcdgRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srl4 = this.srl4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndImdgPckInstrCd = this.n2ndImdgPckInstrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srl1 = this.srl1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stImdgIbcProviCd = this.n1stImdgIbcProviCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srl2 = this.srl2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSpclProviNo = this.imdgSpclProviNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thImdgPckProviCd = this.n4thImdgPckProviCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgCompGrpCd = this.imdgCompGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.segrDesc = this.segrDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfrDgWetCd = this.cfrDgWetCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thImdgIbcInstrCd = this.n4thImdgIbcInstrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdImdgPckInstrCd = this.n3rdImdgPckInstrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprtFmImdgSegrGrpFlg = this.sprtFmImdgSegrGrpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stImdgPckInstrCd = this.n1stImdgPckInstrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n5thImdgIbcInstrCd = this.n5thImdgIbcInstrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thImdgTnkInstrProviCd = this.n4thImdgTnkInstrProviCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thImdgIbcProviCd = this.n4thImdgIbcProviCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n5thImdgPckProviCd = this.n5thImdgPckProviCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcdgFlg = this.hcdgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNoHldFlg = this.imdgUnNoHldFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdImdgPckProviCd = this.n3rdImdgPckProviCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprtFmImdgClssFlg = this.sprtFmImdgClssFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awayFmImdgClssFlg = this.awayFmImdgClssFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcdgIntmdBcRstrDesc = this.hcdgIntmdBcRstrDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdImdgIbcInstrCd = this.n3rdImdgIbcInstrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.segrAsForImdgClssCd = this.segrAsForImdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n5thImdgTnkInstrProviCd = this.n5thImdgTnkInstrProviCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgTblNo = this.imdgTblNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfrRstrPortNm = this.cfrRstrPortNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emerRspnGidNo = this.emerRspnGidNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thBomPortTrstNo = this.n4thBomPortTrstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emerRspnGidChrNo = this.emerRspnGidChrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.limitedQty = this.limitedQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckGrpCd = this.imdgPckGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgLmtQtyMeasUtCd = this.imdgLmtQtyMeasUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stBomPortTrstNo = this.n1stBomPortTrstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkgAuthNo = this.pkgAuthNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgLmtQty = this.imdgLmtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdBomPortTrstNo = this.n3rdBomPortTrstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n5thImdgIbcProviCd = this.n5thImdgIbcProviCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.segrAsForImdgClssFlg = this.segrAsForImdgClssFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndImdgIbcProviCd = this.n2ndImdgIbcProviCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgExptQtyCd = this.imdgExptQtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lkPortAuthNo = this.lkPortAuthNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stImdgPckProviCd = this.n1stImdgPckProviCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgCtrlTemp = this.imdgCtrlTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flshPntTempCtnt = this.flshPntTempCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcdgPckRstrDesc = this.hcdgPckRstrDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgTecNm = this.imdgTecNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfrRptQty = this.cfrRptQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfrPsnInhZnCd = this.cfrPsnInhZnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgHtSrcStwgCd = this.imdgHtSrcStwgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clrLivQtrStwgFlg = this.clrLivQtrStwgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stImdgIbcInstrCd = this.n1stImdgIbcInstrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgStwgCateCd = this.imdgStwgCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdImdgTnkInstrProviCd = this.n3rdImdgTnkInstrProviCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSbstPptDesc = this.imdgSbstPptDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stImdgTnkInstrProviCd = this.n1stImdgTnkInstrProviCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndImdgIbcInstrCd = this.n2ndImdgIbcInstrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgFdStufStwgCd = this.imdgFdStufStwgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdImdgIbcProviCd = this.n3rdImdgIbcProviCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgExptQtyDesc = this.imdgExptQtyDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgLmtQtyDesc = this.imdgLmtQtyDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfrToxcCd = this.cfrToxcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgEmerNo = this.imdgEmerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndImdgTnkInstrProviCd = this.n2ndImdgTnkInstrProviCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndBomPortTrstNo = this.n2ndBomPortTrstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgEmerTemp = this.imdgEmerTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stImdgUnTnkInstrCd = this.n1stImdgUnTnkInstrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcdgTnkRstrDesc = this.hcdgTnkRstrDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgMrnPolutCd = this.imdgMrnPolutCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfrXtdClssCd = this.cfrXtdClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcdgDpndQtyFlg = this.hcdgDpndQtyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prpShpNm = this.prpShpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfrFlg = this.cfrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSegrGrpNos = this.imdgSegrGrpNos .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgAmdtNo = this.imdgAmdtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prpShpNmVarRmk = this.prpShpNmVarRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
