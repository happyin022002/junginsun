/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CustVipReportOutVO.java
*@FileTitle : CustVipReportOutVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.27  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo;

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

public class CustVipReportOutVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustVipReportOutVO> models = new ArrayList<CustVipReportOutVO>();
	
	/* Column Info */
	private String delAta = null;
	/* Column Info */
	private String vgmWgtUtCd = null;
	/* Column Info */
	private String preVvdNm = null;
	/* Column Info */
	private String actCustCode = null;
	/* Column Info */
	private String ntfyCode = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String dchgTsPortDt = null;
	/* Column Info */
	private String oblIssDt = null;
	/* Column Info */
	private String uvdMaxActDt2 = null;
	/* Column Info */
	private String uvdMaxActDt = null;
	/* Column Info */
	private String dblSndDtFax = null;
	/* Column Info */
	private String cgoRcvDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String deptNo = null;
	/* Column Info */
	private String delCnty = null;
	/* Column Info */
	private String rowsPerPage = null;
	/* Column Info */
	private String chgAmt = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String cntrWgtUtCd = null;
	/* Column Info */
	private String cntrMeasUtCd = null;
	/* Column Info */
	private String anSendDt = null;
	/* Column Info */
	private String frdCustNm = null;
	/* Column Info */
	private String itNo = null;
	/* Column Info */
	private String totalCnt = null;
	/* Column Info */
	private String shipId = null;
	/* Column Info */
	private String cntrPckTpCd = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String cntrPrtFlg = null;
	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String rlnMaxActDt = null;
	/* Column Info */
	private String destSvcModCd = null;
	/* Column Info */
	private String finalDestNm = null;
	/* Column Info */
	private String prtNo = null;
	/* Column Info */
	private String mtReturnDt = null;
	/* Column Info */
	private String dspoCd = null;
	/* Column Info */
	private String stsNm = null;
	/* Column Info */
	private String caItno = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String dblSndDtEdi = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String tPodEta = null;
	/* Column Info */
	private String bkgRctSndDtFax = null;
	/* Column Info */
	private String cnrrRefNo = null;
	/* Column Info */
	private String pol1EtaDt = null;
	/* Column Info */
	private String pkupNo = null;
	/* Column Info */
	private String tPodEtd = null;
	/* Column Info */
	private String laneCd = null;
	/* Column Info */
	private String podFtEndDt = null;
	/* Column Info */
	private String fPolEta = null;
	/* Column Info */
	private String bkgRctSndDtEdi = null;
	/* Column Info */
	private String fPolEtd = null;
	/* Column Info */
	private String evntDtTm = null;
	/* Column Info */
	private String cctCharge = null;
	/* Column Info */
	private String trunkVessel = null;
	/* Column Info */
	private String initPolEtdDt = null;
	/* Column Info */
	private String pkupNodCd = null;
	/* Column Info */
	private String scacCd = null;
	/* Column Info */
	private String itemPoNo = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String overdue = null;
	/* Column Info */
	private String postVvdNm = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String measUtCd = null;
	/* Column Info */
	private String dueDate = null;
	/* Column Info */
	private String gCustCnee = null;
	/* Column Info */
	private String ntfyAddr = null;
	/* Column Info */
	private String postVvd = null;
	/* Column Info */
	private String rmk = null;
	/* Column Info */
	private String tPolEta = null;
	/* Column Info */
	private String podNm = null;
	/* Column Info */
	private String vgmMzdTpCd = null;
	/* Column Info */
	private String delNm = null;
	/* Column Info */
	private String tPolEtd = null;
	/* Column Info */
	private String loadId = null;
	/* Column Info */
	private String pctQty = null;
	/* Column Info */
	private String oanMaxActDt = null;
	/* Column Info */
	private String blPoNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String customsRlsDt = null;
	/* Column Info */
	private String podAtaticDt = null;
	/* Column Info */
	private String vgmVrfySigCtnt = null;
	/* Column Info */
	private String custSiRefNo = null;
	/* Column Info */
	private String delEtaDt = null;
	/* Column Info */
	private String cctOfc = null;
	/* Column Info */
	private String polNm = null;
	/* Column Info */
	private String freeDt = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String evntPlc = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String porCnty = null;
	/* Column Info */
	private String currPage = null;
	/* Column Info */
	private String frtCltFlg = null;
	/* Column Info */
	private String preVvd = null;
	/* Column Info */
	private String rnum = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String actCustName = null;
	/* Column Info */
	private String wblSndDtFax = null;
	/* Column Info */
	private String delDt = null;
	/* Column Info */
	private String cndCstmsFileCd = null;
	/* Column Info */
	private String delState = null;
	/* Column Info */
	private String ibdTrspIssDt = null;
	/* Column Info */
	private String oanMaxActDt2 = null;
	/* Column Info */
	private String custRefNo = null;
	/* Column Info */
	private String pod1EtaDt = null;
	/* Column Info */
	private String preRlyPortCd = null;
	/* Column Info */
	private String preVslNm = null;
	/* Column Info */
	private String ataT = null;
	/* Column Info */
	private String fPodEtd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String oblRdemFlg = null;
	/* Column Info */
	private String fPodEta = null;
	/* Column Info */
	private String urnMaxActDt = null;
	/* Column Info */
	private String spcCgo = null;
	/* Column Info */
	private String porNm = null;
	/* Column Info */
	private String ppdOfc = null;
	/* Column Info */
	private String ntfyName = null;
	/* Column Info */
	private String pod1EtdDt = null;
	/* Column Info */
	private String blIssOfc = null;
	/* Column Info */
	private String blObrdDt = null;
	/* Column Info */
	private String custBkgRefNo = null;
	/* Column Info */
	private String cntrVolQty = null;
	/* Column Info */
	private String initPolEtaDt = null;
	/* Column Info */
	private String pstRlyPortCd = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String shprName = null;
	/* Column Info */
	private String delFtEndDt = null;
	/* Column Info */
	private String frdCustCd = null;
	/* Column Info */
	private String firmsCode = null;
	/* Column Info */
	private String atdT = null;
	/* Column Info */
	private String ata = null;
	/* Column Info */
	private String bdrFlg = null;
	/* Column Info */
	private String trunkVvd = null;
	/* Column Info */
	private String vgmWgt = null;
	/* Column Info */
	private String dysLstMvmt = null;
	/* Column Info */
	private String mkDesc = null;
	/* Column Info */
	private String gCustShpr = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String polEtd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String porGateInDt = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String exportRefNo = null;
	/* Column Info */
	private String cstmsDesc = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String dMaxActDt = null;
	/* Column Info */
	private String atd = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String initPodEtaDt = null;
	/* Column Info */
	private String pol1EtdDt = null;
	/* Column Info */
	private String cntrPoNo = null;
	/* Column Info */
	private String webPrt = null;
	/* Column Info */
	private String cstmsClrCd = null;
	/* Column Info */
	private String cgoStsCd = null;
	/* Column Info */
	private String cntrOcDate = null;
	/* Column Info */
	private String eqCtrlOfc = null;
	/* Column Info */
	private String usaCstmsFileCd = null;
	/* Column Info */
	private String actWgt = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String repCmdt = null;
	/* Column Info */
	private String cneeCode = null;
	/* Column Info */
	private String cntrSize = null;
	/* Column Info */
	private String cneeName = null;
	/* Column Info */
	private String avalDt = null;
	/* Column Info */
	private String scac = null;
	/* Column Info */
	private String shprCode = null;
	/* Column Info */
	private String custInvNo = null;
	/* Column Info */
	private String ppdCharge = null;
	/* Column Info */
	private String postVslNm = null;
	/* Column Info */
	private String cntrSealNo = null;
	/* Column Info */
	private String podEtb = null;
	/* Column Info */
	private String totMeas = null;
	/* Column Info */
	private String hubLocCd = null;
	/* Column Info */
	private String podEta = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CustVipReportOutVO() {}

	public CustVipReportOutVO(String ibflag, String pagerows, String delAta, String ntfyCode, String oblIssDt, String cgoRcvDt, String rowsPerPage, String delCnty, String cntrWgtUtCd, String cntrTpszCd, String chgAmt, String cntrMeasUtCd, String anSendDt, String itNo, String totalCnt, String cntrPckTpCd, String bkgOfcCd, String cntrPrtFlg, String cntrWgt, String mtReturnDt, String dspoCd, String caItno, String podCd, String bkgNo, String tPodEta, String cnrrRefNo, String tPodEtd, String pkupNo, String laneCd, String fPolEta, String fPolEtd, String cctCharge, String trunkVessel, String pkupNodCd, String scacCd, String overdue, String cmdtCd, String measUtCd, String pckTpCd, String dueDate, String gCustCnee, String tPolEta, String rmk, String podNm, String tPolEtd, String delNm, String pctQty, String blPoNo, String cntrNo, String customsRlsDt, String podAtaticDt, String delEtaDt, String cctOfc, String polNm, String freeDt, String blNo, String polCd, String porCnty, String currPage, String frtCltFlg, String rnum, String scNo, String rfaNo, String wgtUtCd, String delDt, String cndCstmsFileCd, String delState, String ibdTrspIssDt, String custRefNo, String preRlyPortCd, String ataT, String fPodEtd, String delCd, String oblRdemFlg, String fPodEta, String spcCgo, String porNm, String ppdOfc, String ntfyName, String blIssOfc, String blObrdDt, String pstRlyPortCd, String porCd, String shprName, String firmsCode, String atdT, String ata, String bdrFlg, String trunkVvd, String gCustShpr, String polEtd, String porGateInDt, String vslEngNm, String exportRefNo, String cstmsDesc, String measQty, String pckQty, String rcvTermCd, String atd, String cntrPoNo, String cstmsClrCd, String cntrOcDate, String dchgTsPortDt, String cgoStsCd, String eqCtrlOfc, String actWgt, String usaCstmsFileCd, String deTermCd, String repCmdt, String cntrSize, String cneeCode, String cneeName, String frdCustCd, String frdCustNm, String shprCode, String scac, String avalDt, String ppdCharge, String cntrSealNo, String totMeas, String hubLocCd, String podEta, String prtNo, String shipId, String bkgRctSndDtFax, String dblSndDtFax, String wblSndDtFax, String dblSndDtEdi, String bkgRctSndDtEdi, String actCustCode, String actCustName, String podEtb, String uvdMaxActDt, String rlnMaxActDt, String urnMaxActDt, String oanMaxActDt, String dMaxActDt, String webPrt, String cntrVolQty, String svcScpCd, String finalDestNm, String uvdMaxActDt2, String oanMaxActDt2, String evntDtTm, String stsNm, String evntPlc, String dysLstMvmt, String itemPoNo, String preVvd, String preVslNm, String postVvd, String postVslNm, String pol1EtaDt, String pol1EtdDt, String pod1EtaDt, String pod1EtdDt, String deptNo, String preVvdNm, String postVvdNm, String custInvNo, String custBkgRefNo, String custSiRefNo, String ntfyAddr, String destSvcModCd, String podFtEndDt, String delFtEndDt, String mkDesc, String initPolEtaDt, String initPolEtdDt, String initPodEtaDt, String loadId, String vgmWgt, String vgmWgtUtCd, String vgmVrfySigCtnt, String vgmMzdTpCd) {
		this.delAta = delAta;
		this.vgmWgtUtCd = vgmWgtUtCd;
		this.preVvdNm = preVvdNm;
		this.actCustCode = actCustCode;
		this.ntfyCode = ntfyCode;
		this.svcScpCd = svcScpCd;
		this.dchgTsPortDt = dchgTsPortDt;
		this.oblIssDt = oblIssDt;
		this.uvdMaxActDt2 = uvdMaxActDt2;
		this.uvdMaxActDt = uvdMaxActDt;
		this.dblSndDtFax = dblSndDtFax;
		this.cgoRcvDt = cgoRcvDt;
		this.pagerows = pagerows;
		this.deptNo = deptNo;
		this.delCnty = delCnty;
		this.rowsPerPage = rowsPerPage;
		this.chgAmt = chgAmt;
		this.cntrTpszCd = cntrTpszCd;
		this.cntrWgtUtCd = cntrWgtUtCd;
		this.cntrMeasUtCd = cntrMeasUtCd;
		this.anSendDt = anSendDt;
		this.frdCustNm = frdCustNm;
		this.itNo = itNo;
		this.totalCnt = totalCnt;
		this.shipId = shipId;
		this.cntrPckTpCd = cntrPckTpCd;
		this.bkgOfcCd = bkgOfcCd;
		this.cntrPrtFlg = cntrPrtFlg;
		this.cntrWgt = cntrWgt;
		this.rlnMaxActDt = rlnMaxActDt;
		this.destSvcModCd = destSvcModCd;
		this.finalDestNm = finalDestNm;
		this.prtNo = prtNo;
		this.mtReturnDt = mtReturnDt;
		this.dspoCd = dspoCd;
		this.stsNm = stsNm;
		this.caItno = caItno;
		this.podCd = podCd;
		this.dblSndDtEdi = dblSndDtEdi;
		this.bkgNo = bkgNo;
		this.tPodEta = tPodEta;
		this.bkgRctSndDtFax = bkgRctSndDtFax;
		this.cnrrRefNo = cnrrRefNo;
		this.pol1EtaDt = pol1EtaDt;
		this.pkupNo = pkupNo;
		this.tPodEtd = tPodEtd;
		this.laneCd = laneCd;
		this.podFtEndDt = podFtEndDt;
		this.fPolEta = fPolEta;
		this.bkgRctSndDtEdi = bkgRctSndDtEdi;
		this.fPolEtd = fPolEtd;
		this.evntDtTm = evntDtTm;
		this.cctCharge = cctCharge;
		this.trunkVessel = trunkVessel;
		this.initPolEtdDt = initPolEtdDt;
		this.pkupNodCd = pkupNodCd;
		this.scacCd = scacCd;
		this.itemPoNo = itemPoNo;
		this.cmdtCd = cmdtCd;
		this.overdue = overdue;
		this.postVvdNm = postVvdNm;
		this.pckTpCd = pckTpCd;
		this.measUtCd = measUtCd;
		this.dueDate = dueDate;
		this.gCustCnee = gCustCnee;
		this.ntfyAddr = ntfyAddr;
		this.postVvd = postVvd;
		this.rmk = rmk;
		this.tPolEta = tPolEta;
		this.podNm = podNm;
		this.vgmMzdTpCd = vgmMzdTpCd;
		this.delNm = delNm;
		this.tPolEtd = tPolEtd;
		this.loadId = loadId;
		this.pctQty = pctQty;
		this.oanMaxActDt = oanMaxActDt;
		this.blPoNo = blPoNo;
		this.cntrNo = cntrNo;
		this.customsRlsDt = customsRlsDt;
		this.podAtaticDt = podAtaticDt;
		this.vgmVrfySigCtnt = vgmVrfySigCtnt;
		this.custSiRefNo = custSiRefNo;
		this.delEtaDt = delEtaDt;
		this.cctOfc = cctOfc;
		this.polNm = polNm;
		this.freeDt = freeDt;
		this.blNo = blNo;
		this.evntPlc = evntPlc;
		this.polCd = polCd;
		this.porCnty = porCnty;
		this.currPage = currPage;
		this.frtCltFlg = frtCltFlg;
		this.preVvd = preVvd;
		this.rnum = rnum;
		this.scNo = scNo;
		this.wgtUtCd = wgtUtCd;
		this.actCustName = actCustName;
		this.wblSndDtFax = wblSndDtFax;
		this.delDt = delDt;
		this.cndCstmsFileCd = cndCstmsFileCd;
		this.delState = delState;
		this.ibdTrspIssDt = ibdTrspIssDt;
		this.oanMaxActDt2 = oanMaxActDt2;
		this.custRefNo = custRefNo;
		this.pod1EtaDt = pod1EtaDt;
		this.preRlyPortCd = preRlyPortCd;
		this.preVslNm = preVslNm;
		this.ataT = ataT;
		this.fPodEtd = fPodEtd;
		this.delCd = delCd;
		this.oblRdemFlg = oblRdemFlg;
		this.fPodEta = fPodEta;
		this.urnMaxActDt = urnMaxActDt;
		this.spcCgo = spcCgo;
		this.porNm = porNm;
		this.ppdOfc = ppdOfc;
		this.ntfyName = ntfyName;
		this.pod1EtdDt = pod1EtdDt;
		this.blIssOfc = blIssOfc;
		this.blObrdDt = blObrdDt;
		this.custBkgRefNo = custBkgRefNo;
		this.cntrVolQty = cntrVolQty;
		this.initPolEtaDt = initPolEtaDt;
		this.pstRlyPortCd = pstRlyPortCd;
		this.porCd = porCd;
		this.shprName = shprName;
		this.delFtEndDt = delFtEndDt;
		this.frdCustCd = frdCustCd;
		this.firmsCode = firmsCode;
		this.atdT = atdT;
		this.ata = ata;
		this.bdrFlg = bdrFlg;
		this.trunkVvd = trunkVvd;
		this.vgmWgt = vgmWgt;
		this.dysLstMvmt = dysLstMvmt;
		this.mkDesc = mkDesc;
		this.gCustShpr = gCustShpr;
		this.rfaNo = rfaNo;
		this.polEtd = polEtd;
		this.ibflag = ibflag;
		this.porGateInDt = porGateInDt;
		this.vslEngNm = vslEngNm;
		this.exportRefNo = exportRefNo;
		this.cstmsDesc = cstmsDesc;
		this.measQty = measQty;
		this.pckQty = pckQty;
		this.dMaxActDt = dMaxActDt;
		this.atd = atd;
		this.rcvTermCd = rcvTermCd;
		this.initPodEtaDt = initPodEtaDt;
		this.pol1EtdDt = pol1EtdDt;
		this.cntrPoNo = cntrPoNo;
		this.webPrt = webPrt;
		this.cstmsClrCd = cstmsClrCd;
		this.cgoStsCd = cgoStsCd;
		this.cntrOcDate = cntrOcDate;
		this.eqCtrlOfc = eqCtrlOfc;
		this.usaCstmsFileCd = usaCstmsFileCd;
		this.actWgt = actWgt;
		this.deTermCd = deTermCd;
		this.repCmdt = repCmdt;
		this.cneeCode = cneeCode;
		this.cntrSize = cntrSize;
		this.cneeName = cneeName;
		this.avalDt = avalDt;
		this.scac = scac;
		this.shprCode = shprCode;
		this.custInvNo = custInvNo;
		this.ppdCharge = ppdCharge;
		this.postVslNm = postVslNm;
		this.cntrSealNo = cntrSealNo;
		this.podEtb = podEtb;
		this.totMeas = totMeas;
		this.hubLocCd = hubLocCd;
		this.podEta = podEta;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("del_ata", getDelAta());
		this.hashColumns.put("vgm_wgt_ut_cd", getVgmWgtUtCd());
		this.hashColumns.put("pre_vvd_nm", getPreVvdNm());
		this.hashColumns.put("act_cust_code", getActCustCode());
		this.hashColumns.put("ntfy_code", getNtfyCode());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("dchg_ts_port_dt", getDchgTsPortDt());
		this.hashColumns.put("obl_iss_dt", getOblIssDt());
		this.hashColumns.put("uvd_max_act_dt2", getUvdMaxActDt2());
		this.hashColumns.put("uvd_max_act_dt", getUvdMaxActDt());
		this.hashColumns.put("dbl_snd_dt_fax", getDblSndDtFax());
		this.hashColumns.put("cgo_rcv_dt", getCgoRcvDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dept_no", getDeptNo());
		this.hashColumns.put("del_cnty", getDelCnty());
		this.hashColumns.put("rows_per_page", getRowsPerPage());
		this.hashColumns.put("chg_amt", getChgAmt());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cntr_wgt_ut_cd", getCntrWgtUtCd());
		this.hashColumns.put("cntr_meas_ut_cd", getCntrMeasUtCd());
		this.hashColumns.put("an_send_dt", getAnSendDt());
		this.hashColumns.put("frd_cust_nm", getFrdCustNm());
		this.hashColumns.put("it_no", getItNo());
		this.hashColumns.put("total_cnt", getTotalCnt());
		this.hashColumns.put("ship_id", getShipId());
		this.hashColumns.put("cntr_pck_tp_cd", getCntrPckTpCd());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("cntr_prt_flg", getCntrPrtFlg());
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("rln_max_act_dt", getRlnMaxActDt());
		this.hashColumns.put("dest_svc_mod_cd", getDestSvcModCd());
		this.hashColumns.put("final_dest_nm", getFinalDestNm());
		this.hashColumns.put("prt_no", getPrtNo());
		this.hashColumns.put("mt_return_dt", getMtReturnDt());
		this.hashColumns.put("dspo_cd", getDspoCd());
		this.hashColumns.put("sts_nm", getStsNm());
		this.hashColumns.put("ca_itno", getCaItno());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("dbl_snd_dt_edi", getDblSndDtEdi());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("t_pod_eta", getTPodEta());
		this.hashColumns.put("bkg_rct_snd_dt_fax", getBkgRctSndDtFax());
		this.hashColumns.put("cnrr_ref_no", getCnrrRefNo());
		this.hashColumns.put("pol1_eta_dt", getPol1EtaDt());
		this.hashColumns.put("pkup_no", getPkupNo());
		this.hashColumns.put("t_pod_etd", getTPodEtd());
		this.hashColumns.put("lane_cd", getLaneCd());
		this.hashColumns.put("pod_ft_end_dt", getPodFtEndDt());
		this.hashColumns.put("f_pol_eta", getFPolEta());
		this.hashColumns.put("bkg_rct_snd_dt_edi", getBkgRctSndDtEdi());
		this.hashColumns.put("f_pol_etd", getFPolEtd());
		this.hashColumns.put("evnt_dt_tm", getEvntDtTm());
		this.hashColumns.put("cct_charge", getCctCharge());
		this.hashColumns.put("trunk_vessel", getTrunkVessel());
		this.hashColumns.put("init_pol_etd_dt", getInitPolEtdDt());
		this.hashColumns.put("pkup_nod_cd", getPkupNodCd());
		this.hashColumns.put("scac_cd", getScacCd());
		this.hashColumns.put("item_po_no", getItemPoNo());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("overdue", getOverdue());
		this.hashColumns.put("post_vvd_nm", getPostVvdNm());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		this.hashColumns.put("due_date", getDueDate());
		this.hashColumns.put("g_cust_cnee", getGCustCnee());
		this.hashColumns.put("ntfy_addr", getNtfyAddr());
		this.hashColumns.put("post_vvd", getPostVvd());
		this.hashColumns.put("rmk", getRmk());
		this.hashColumns.put("t_pol_eta", getTPolEta());
		this.hashColumns.put("pod_nm", getPodNm());
		this.hashColumns.put("vgm_mzd_tp_cd", getVgmMzdTpCd());
		this.hashColumns.put("del_nm", getDelNm());
		this.hashColumns.put("t_pol_etd", getTPolEtd());
		this.hashColumns.put("load_id", getLoadId());
		this.hashColumns.put("pct_qty", getPctQty());
		this.hashColumns.put("oan_max_act_dt", getOanMaxActDt());
		this.hashColumns.put("bl_po_no", getBlPoNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("customs_rls_dt", getCustomsRlsDt());
		this.hashColumns.put("pod_atatic_dt", getPodAtaticDt());
		this.hashColumns.put("vgm_vrfy_sig_ctnt", getVgmVrfySigCtnt());
		this.hashColumns.put("cust_si_ref_no", getCustSiRefNo());
		this.hashColumns.put("del_eta_dt", getDelEtaDt());
		this.hashColumns.put("cct_ofc", getCctOfc());
		this.hashColumns.put("pol_nm", getPolNm());
		this.hashColumns.put("free_dt", getFreeDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("evnt_plc", getEvntPlc());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("por_cnty", getPorCnty());
		this.hashColumns.put("curr_page", getCurrPage());
		this.hashColumns.put("frt_clt_flg", getFrtCltFlg());
		this.hashColumns.put("pre_vvd", getPreVvd());
		this.hashColumns.put("rnum", getRnum());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("act_cust_name", getActCustName());
		this.hashColumns.put("wbl_snd_dt_fax", getWblSndDtFax());
		this.hashColumns.put("del_dt", getDelDt());
		this.hashColumns.put("cnd_cstms_file_cd", getCndCstmsFileCd());
		this.hashColumns.put("del_state", getDelState());
		this.hashColumns.put("ibd_trsp_iss_dt", getIbdTrspIssDt());
		this.hashColumns.put("oan_max_act_dt2", getOanMaxActDt2());
		this.hashColumns.put("cust_ref_no", getCustRefNo());
		this.hashColumns.put("pod1_eta_dt", getPod1EtaDt());
		this.hashColumns.put("pre_rly_port_cd", getPreRlyPortCd());
		this.hashColumns.put("pre_vsl_nm", getPreVslNm());
		this.hashColumns.put("ata_t", getAtaT());
		this.hashColumns.put("f_pod_etd", getFPodEtd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("obl_rdem_flg", getOblRdemFlg());
		this.hashColumns.put("f_pod_eta", getFPodEta());
		this.hashColumns.put("urn_max_act_dt", getUrnMaxActDt());
		this.hashColumns.put("spc_cgo", getSpcCgo());
		this.hashColumns.put("por_nm", getPorNm());
		this.hashColumns.put("ppd_ofc", getPpdOfc());
		this.hashColumns.put("ntfy_name", getNtfyName());
		this.hashColumns.put("pod1_etd_dt", getPod1EtdDt());
		this.hashColumns.put("bl_iss_ofc", getBlIssOfc());
		this.hashColumns.put("bl_obrd_dt", getBlObrdDt());
		this.hashColumns.put("cust_bkg_ref_no", getCustBkgRefNo());
		this.hashColumns.put("cntr_vol_qty", getCntrVolQty());
		this.hashColumns.put("init_pol_eta_dt", getInitPolEtaDt());
		this.hashColumns.put("pst_rly_port_cd", getPstRlyPortCd());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("shpr_name", getShprName());
		this.hashColumns.put("del_ft_end_dt", getDelFtEndDt());
		this.hashColumns.put("frd_cust_cd", getFrdCustCd());
		this.hashColumns.put("firms_code", getFirmsCode());
		this.hashColumns.put("atd_t", getAtdT());
		this.hashColumns.put("ata", getAta());
		this.hashColumns.put("bdr_flg", getBdrFlg());
		this.hashColumns.put("trunk_vvd", getTrunkVvd());
		this.hashColumns.put("vgm_wgt", getVgmWgt());
		this.hashColumns.put("dys_lst_mvmt", getDysLstMvmt());
		this.hashColumns.put("mk_desc", getMkDesc());
		this.hashColumns.put("g_cust_shpr", getGCustShpr());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("pol_etd", getPolEtd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("por_gate_in_dt", getPorGateInDt());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("export_ref_no", getExportRefNo());
		this.hashColumns.put("cstms_desc", getCstmsDesc());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("d_max_act_dt", getDMaxActDt());
		this.hashColumns.put("atd", getAtd());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("init_pod_eta_dt", getInitPodEtaDt());
		this.hashColumns.put("pol1_etd_dt", getPol1EtdDt());
		this.hashColumns.put("cntr_po_no", getCntrPoNo());
		this.hashColumns.put("web_prt", getWebPrt());
		this.hashColumns.put("cstms_clr_cd", getCstmsClrCd());
		this.hashColumns.put("cgo_sts_cd", getCgoStsCd());
		this.hashColumns.put("cntr_oc_date", getCntrOcDate());
		this.hashColumns.put("eq_ctrl_ofc", getEqCtrlOfc());
		this.hashColumns.put("usa_cstms_file_cd", getUsaCstmsFileCd());
		this.hashColumns.put("act_wgt", getActWgt());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("rep_cmdt", getRepCmdt());
		this.hashColumns.put("cnee_code", getCneeCode());
		this.hashColumns.put("cntr_size", getCntrSize());
		this.hashColumns.put("cnee_name", getCneeName());
		this.hashColumns.put("aval_dt", getAvalDt());
		this.hashColumns.put("scac", getScac());
		this.hashColumns.put("shpr_code", getShprCode());
		this.hashColumns.put("cust_inv_no", getCustInvNo());
		this.hashColumns.put("ppd_charge", getPpdCharge());
		this.hashColumns.put("post_vsl_nm", getPostVslNm());
		this.hashColumns.put("cntr_seal_no", getCntrSealNo());
		this.hashColumns.put("pod_etb", getPodEtb());
		this.hashColumns.put("tot_meas", getTotMeas());
		this.hashColumns.put("hub_loc_cd", getHubLocCd());
		this.hashColumns.put("pod_eta", getPodEta());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("del_ata", "delAta");
		this.hashFields.put("vgm_wgt_ut_cd", "vgmWgtUtCd");
		this.hashFields.put("pre_vvd_nm", "preVvdNm");
		this.hashFields.put("act_cust_code", "actCustCode");
		this.hashFields.put("ntfy_code", "ntfyCode");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("dchg_ts_port_dt", "dchgTsPortDt");
		this.hashFields.put("obl_iss_dt", "oblIssDt");
		this.hashFields.put("uvd_max_act_dt2", "uvdMaxActDt2");
		this.hashFields.put("uvd_max_act_dt", "uvdMaxActDt");
		this.hashFields.put("dbl_snd_dt_fax", "dblSndDtFax");
		this.hashFields.put("cgo_rcv_dt", "cgoRcvDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dept_no", "deptNo");
		this.hashFields.put("del_cnty", "delCnty");
		this.hashFields.put("rows_per_page", "rowsPerPage");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cntr_wgt_ut_cd", "cntrWgtUtCd");
		this.hashFields.put("cntr_meas_ut_cd", "cntrMeasUtCd");
		this.hashFields.put("an_send_dt", "anSendDt");
		this.hashFields.put("frd_cust_nm", "frdCustNm");
		this.hashFields.put("it_no", "itNo");
		this.hashFields.put("total_cnt", "totalCnt");
		this.hashFields.put("ship_id", "shipId");
		this.hashFields.put("cntr_pck_tp_cd", "cntrPckTpCd");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("cntr_prt_flg", "cntrPrtFlg");
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("rln_max_act_dt", "rlnMaxActDt");
		this.hashFields.put("dest_svc_mod_cd", "destSvcModCd");
		this.hashFields.put("final_dest_nm", "finalDestNm");
		this.hashFields.put("prt_no", "prtNo");
		this.hashFields.put("mt_return_dt", "mtReturnDt");
		this.hashFields.put("dspo_cd", "dspoCd");
		this.hashFields.put("sts_nm", "stsNm");
		this.hashFields.put("ca_itno", "caItno");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("dbl_snd_dt_edi", "dblSndDtEdi");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("t_pod_eta", "tPodEta");
		this.hashFields.put("bkg_rct_snd_dt_fax", "bkgRctSndDtFax");
		this.hashFields.put("cnrr_ref_no", "cnrrRefNo");
		this.hashFields.put("pol1_eta_dt", "pol1EtaDt");
		this.hashFields.put("pkup_no", "pkupNo");
		this.hashFields.put("t_pod_etd", "tPodEtd");
		this.hashFields.put("lane_cd", "laneCd");
		this.hashFields.put("pod_ft_end_dt", "podFtEndDt");
		this.hashFields.put("f_pol_eta", "fPolEta");
		this.hashFields.put("bkg_rct_snd_dt_edi", "bkgRctSndDtEdi");
		this.hashFields.put("f_pol_etd", "fPolEtd");
		this.hashFields.put("evnt_dt_tm", "evntDtTm");
		this.hashFields.put("cct_charge", "cctCharge");
		this.hashFields.put("trunk_vessel", "trunkVessel");
		this.hashFields.put("init_pol_etd_dt", "initPolEtdDt");
		this.hashFields.put("pkup_nod_cd", "pkupNodCd");
		this.hashFields.put("scac_cd", "scacCd");
		this.hashFields.put("item_po_no", "itemPoNo");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("overdue", "overdue");
		this.hashFields.put("post_vvd_nm", "postVvdNm");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("due_date", "dueDate");
		this.hashFields.put("g_cust_cnee", "gCustCnee");
		this.hashFields.put("ntfy_addr", "ntfyAddr");
		this.hashFields.put("post_vvd", "postVvd");
		this.hashFields.put("rmk", "rmk");
		this.hashFields.put("t_pol_eta", "tPolEta");
		this.hashFields.put("pod_nm", "podNm");
		this.hashFields.put("vgm_mzd_tp_cd", "vgmMzdTpCd");
		this.hashFields.put("del_nm", "delNm");
		this.hashFields.put("t_pol_etd", "tPolEtd");
		this.hashFields.put("load_id", "loadId");
		this.hashFields.put("pct_qty", "pctQty");
		this.hashFields.put("oan_max_act_dt", "oanMaxActDt");
		this.hashFields.put("bl_po_no", "blPoNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("customs_rls_dt", "customsRlsDt");
		this.hashFields.put("pod_atatic_dt", "podAtaticDt");
		this.hashFields.put("vgm_vrfy_sig_ctnt", "vgmVrfySigCtnt");
		this.hashFields.put("cust_si_ref_no", "custSiRefNo");
		this.hashFields.put("del_eta_dt", "delEtaDt");
		this.hashFields.put("cct_ofc", "cctOfc");
		this.hashFields.put("pol_nm", "polNm");
		this.hashFields.put("free_dt", "freeDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("evnt_plc", "evntPlc");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("por_cnty", "porCnty");
		this.hashFields.put("curr_page", "currPage");
		this.hashFields.put("frt_clt_flg", "frtCltFlg");
		this.hashFields.put("pre_vvd", "preVvd");
		this.hashFields.put("rnum", "rnum");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("act_cust_name", "actCustName");
		this.hashFields.put("wbl_snd_dt_fax", "wblSndDtFax");
		this.hashFields.put("del_dt", "delDt");
		this.hashFields.put("cnd_cstms_file_cd", "cndCstmsFileCd");
		this.hashFields.put("del_state", "delState");
		this.hashFields.put("ibd_trsp_iss_dt", "ibdTrspIssDt");
		this.hashFields.put("oan_max_act_dt2", "oanMaxActDt2");
		this.hashFields.put("cust_ref_no", "custRefNo");
		this.hashFields.put("pod1_eta_dt", "pod1EtaDt");
		this.hashFields.put("pre_rly_port_cd", "preRlyPortCd");
		this.hashFields.put("pre_vsl_nm", "preVslNm");
		this.hashFields.put("ata_t", "ataT");
		this.hashFields.put("f_pod_etd", "fPodEtd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("obl_rdem_flg", "oblRdemFlg");
		this.hashFields.put("f_pod_eta", "fPodEta");
		this.hashFields.put("urn_max_act_dt", "urnMaxActDt");
		this.hashFields.put("spc_cgo", "spcCgo");
		this.hashFields.put("por_nm", "porNm");
		this.hashFields.put("ppd_ofc", "ppdOfc");
		this.hashFields.put("ntfy_name", "ntfyName");
		this.hashFields.put("pod1_etd_dt", "pod1EtdDt");
		this.hashFields.put("bl_iss_ofc", "blIssOfc");
		this.hashFields.put("bl_obrd_dt", "blObrdDt");
		this.hashFields.put("cust_bkg_ref_no", "custBkgRefNo");
		this.hashFields.put("cntr_vol_qty", "cntrVolQty");
		this.hashFields.put("init_pol_eta_dt", "initPolEtaDt");
		this.hashFields.put("pst_rly_port_cd", "pstRlyPortCd");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("shpr_name", "shprName");
		this.hashFields.put("del_ft_end_dt", "delFtEndDt");
		this.hashFields.put("frd_cust_cd", "frdCustCd");
		this.hashFields.put("firms_code", "firmsCode");
		this.hashFields.put("atd_t", "atdT");
		this.hashFields.put("ata", "ata");
		this.hashFields.put("bdr_flg", "bdrFlg");
		this.hashFields.put("trunk_vvd", "trunkVvd");
		this.hashFields.put("vgm_wgt", "vgmWgt");
		this.hashFields.put("dys_lst_mvmt", "dysLstMvmt");
		this.hashFields.put("mk_desc", "mkDesc");
		this.hashFields.put("g_cust_shpr", "gCustShpr");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("pol_etd", "polEtd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("por_gate_in_dt", "porGateInDt");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("export_ref_no", "exportRefNo");
		this.hashFields.put("cstms_desc", "cstmsDesc");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("d_max_act_dt", "dMaxActDt");
		this.hashFields.put("atd", "atd");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("init_pod_eta_dt", "initPodEtaDt");
		this.hashFields.put("pol1_etd_dt", "pol1EtdDt");
		this.hashFields.put("cntr_po_no", "cntrPoNo");
		this.hashFields.put("web_prt", "webPrt");
		this.hashFields.put("cstms_clr_cd", "cstmsClrCd");
		this.hashFields.put("cgo_sts_cd", "cgoStsCd");
		this.hashFields.put("cntr_oc_date", "cntrOcDate");
		this.hashFields.put("eq_ctrl_ofc", "eqCtrlOfc");
		this.hashFields.put("usa_cstms_file_cd", "usaCstmsFileCd");
		this.hashFields.put("act_wgt", "actWgt");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("rep_cmdt", "repCmdt");
		this.hashFields.put("cnee_code", "cneeCode");
		this.hashFields.put("cntr_size", "cntrSize");
		this.hashFields.put("cnee_name", "cneeName");
		this.hashFields.put("aval_dt", "avalDt");
		this.hashFields.put("scac", "scac");
		this.hashFields.put("shpr_code", "shprCode");
		this.hashFields.put("cust_inv_no", "custInvNo");
		this.hashFields.put("ppd_charge", "ppdCharge");
		this.hashFields.put("post_vsl_nm", "postVslNm");
		this.hashFields.put("cntr_seal_no", "cntrSealNo");
		this.hashFields.put("pod_etb", "podEtb");
		this.hashFields.put("tot_meas", "totMeas");
		this.hashFields.put("hub_loc_cd", "hubLocCd");
		this.hashFields.put("pod_eta", "podEta");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return delAta
	 */
	public String getDelAta() {
		return this.delAta;
	}
	
	/**
	 * Column Info
	 * @return vgmWgtUtCd
	 */
	public String getVgmWgtUtCd() {
		return this.vgmWgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return preVvdNm
	 */
	public String getPreVvdNm() {
		return this.preVvdNm;
	}
	
	/**
	 * Column Info
	 * @return actCustCode
	 */
	public String getActCustCode() {
		return this.actCustCode;
	}
	
	/**
	 * Column Info
	 * @return ntfyCode
	 */
	public String getNtfyCode() {
		return this.ntfyCode;
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
	 * @return dchgTsPortDt
	 */
	public String getDchgTsPortDt() {
		return this.dchgTsPortDt;
	}
	
	/**
	 * Column Info
	 * @return oblIssDt
	 */
	public String getOblIssDt() {
		return this.oblIssDt;
	}
	
	/**
	 * Column Info
	 * @return uvdMaxActDt2
	 */
	public String getUvdMaxActDt2() {
		return this.uvdMaxActDt2;
	}
	
	/**
	 * Column Info
	 * @return uvdMaxActDt
	 */
	public String getUvdMaxActDt() {
		return this.uvdMaxActDt;
	}
	
	/**
	 * Column Info
	 * @return dblSndDtFax
	 */
	public String getDblSndDtFax() {
		return this.dblSndDtFax;
	}
	
	/**
	 * Column Info
	 * @return cgoRcvDt
	 */
	public String getCgoRcvDt() {
		return this.cgoRcvDt;
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
	 * @return deptNo
	 */
	public String getDeptNo() {
		return this.deptNo;
	}
	
	/**
	 * Column Info
	 * @return delCnty
	 */
	public String getDelCnty() {
		return this.delCnty;
	}
	
	/**
	 * Column Info
	 * @return rowsPerPage
	 */
	public String getRowsPerPage() {
		return this.rowsPerPage;
	}
	
	/**
	 * Column Info
	 * @return chgAmt
	 */
	public String getChgAmt() {
		return this.chgAmt;
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
	 * @return cntrWgtUtCd
	 */
	public String getCntrWgtUtCd() {
		return this.cntrWgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return cntrMeasUtCd
	 */
	public String getCntrMeasUtCd() {
		return this.cntrMeasUtCd;
	}
	
	/**
	 * Column Info
	 * @return anSendDt
	 */
	public String getAnSendDt() {
		return this.anSendDt;
	}
	
	/**
	 * Column Info
	 * @return frdCustNm
	 */
	public String getFrdCustNm() {
		return this.frdCustNm;
	}
	
	/**
	 * Column Info
	 * @return itNo
	 */
	public String getItNo() {
		return this.itNo;
	}
	
	/**
	 * Column Info
	 * @return totalCnt
	 */
	public String getTotalCnt() {
		return this.totalCnt;
	}
	
	/**
	 * Column Info
	 * @return shipId
	 */
	public String getShipId() {
		return this.shipId;
	}
	
	/**
	 * Column Info
	 * @return cntrPckTpCd
	 */
	public String getCntrPckTpCd() {
		return this.cntrPckTpCd;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return cntrPrtFlg
	 */
	public String getCntrPrtFlg() {
		return this.cntrPrtFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrWgt
	 */
	public String getCntrWgt() {
		return this.cntrWgt;
	}
	
	/**
	 * Column Info
	 * @return rlnMaxActDt
	 */
	public String getRlnMaxActDt() {
		return this.rlnMaxActDt;
	}
	
	/**
	 * Column Info
	 * @return destSvcModCd
	 */
	public String getDestSvcModCd() {
		return this.destSvcModCd;
	}
	
	/**
	 * Column Info
	 * @return finalDestNm
	 */
	public String getFinalDestNm() {
		return this.finalDestNm;
	}
	
	/**
	 * Column Info
	 * @return prtNo
	 */
	public String getPrtNo() {
		return this.prtNo;
	}
	
	/**
	 * Column Info
	 * @return mtReturnDt
	 */
	public String getMtReturnDt() {
		return this.mtReturnDt;
	}
	
	/**
	 * Column Info
	 * @return dspoCd
	 */
	public String getDspoCd() {
		return this.dspoCd;
	}
	
	/**
	 * Column Info
	 * @return stsNm
	 */
	public String getStsNm() {
		return this.stsNm;
	}
	
	/**
	 * Column Info
	 * @return caItno
	 */
	public String getCaItno() {
		return this.caItno;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return dblSndDtEdi
	 */
	public String getDblSndDtEdi() {
		return this.dblSndDtEdi;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return tPodEta
	 */
	public String getTPodEta() {
		return this.tPodEta;
	}
	
	/**
	 * Column Info
	 * @return bkgRctSndDtFax
	 */
	public String getBkgRctSndDtFax() {
		return this.bkgRctSndDtFax;
	}
	
	/**
	 * Column Info
	 * @return cnrrRefNo
	 */
	public String getCnrrRefNo() {
		return this.cnrrRefNo;
	}
	
	/**
	 * Column Info
	 * @return pol1EtaDt
	 */
	public String getPol1EtaDt() {
		return this.pol1EtaDt;
	}
	
	/**
	 * Column Info
	 * @return pkupNo
	 */
	public String getPkupNo() {
		return this.pkupNo;
	}
	
	/**
	 * Column Info
	 * @return tPodEtd
	 */
	public String getTPodEtd() {
		return this.tPodEtd;
	}
	
	/**
	 * Column Info
	 * @return laneCd
	 */
	public String getLaneCd() {
		return this.laneCd;
	}
	
	/**
	 * Column Info
	 * @return podFtEndDt
	 */
	public String getPodFtEndDt() {
		return this.podFtEndDt;
	}
	
	/**
	 * Column Info
	 * @return fPolEta
	 */
	public String getFPolEta() {
		return this.fPolEta;
	}
	
	/**
	 * Column Info
	 * @return bkgRctSndDtEdi
	 */
	public String getBkgRctSndDtEdi() {
		return this.bkgRctSndDtEdi;
	}
	
	/**
	 * Column Info
	 * @return fPolEtd
	 */
	public String getFPolEtd() {
		return this.fPolEtd;
	}
	
	/**
	 * Column Info
	 * @return evntDtTm
	 */
	public String getEvntDtTm() {
		return this.evntDtTm;
	}
	
	/**
	 * Column Info
	 * @return cctCharge
	 */
	public String getCctCharge() {
		return this.cctCharge;
	}
	
	/**
	 * Column Info
	 * @return trunkVessel
	 */
	public String getTrunkVessel() {
		return this.trunkVessel;
	}
	
	/**
	 * Column Info
	 * @return initPolEtdDt
	 */
	public String getInitPolEtdDt() {
		return this.initPolEtdDt;
	}
	
	/**
	 * Column Info
	 * @return pkupNodCd
	 */
	public String getPkupNodCd() {
		return this.pkupNodCd;
	}
	
	/**
	 * Column Info
	 * @return scacCd
	 */
	public String getScacCd() {
		return this.scacCd;
	}
	
	/**
	 * Column Info
	 * @return itemPoNo
	 */
	public String getItemPoNo() {
		return this.itemPoNo;
	}
	
	/**
	 * Column Info
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}
	
	/**
	 * Column Info
	 * @return overdue
	 */
	public String getOverdue() {
		return this.overdue;
	}
	
	/**
	 * Column Info
	 * @return postVvdNm
	 */
	public String getPostVvdNm() {
		return this.postVvdNm;
	}
	
	/**
	 * Column Info
	 * @return pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
	}
	
	/**
	 * Column Info
	 * @return measUtCd
	 */
	public String getMeasUtCd() {
		return this.measUtCd;
	}
	
	/**
	 * Column Info
	 * @return dueDate
	 */
	public String getDueDate() {
		return this.dueDate;
	}
	
	/**
	 * Column Info
	 * @return gCustCnee
	 */
	public String getGCustCnee() {
		return this.gCustCnee;
	}
	
	/**
	 * Column Info
	 * @return ntfyAddr
	 */
	public String getNtfyAddr() {
		return this.ntfyAddr;
	}
	
	/**
	 * Column Info
	 * @return postVvd
	 */
	public String getPostVvd() {
		return this.postVvd;
	}
	
	/**
	 * Column Info
	 * @return rmk
	 */
	public String getRmk() {
		return this.rmk;
	}
	
	/**
	 * Column Info
	 * @return tPolEta
	 */
	public String getTPolEta() {
		return this.tPolEta;
	}
	
	/**
	 * Column Info
	 * @return podNm
	 */
	public String getPodNm() {
		return this.podNm;
	}
	
	/**
	 * Column Info
	 * @return vgmMzdTpCd
	 */
	public String getVgmMzdTpCd() {
		return this.vgmMzdTpCd;
	}
	
	/**
	 * Column Info
	 * @return delNm
	 */
	public String getDelNm() {
		return this.delNm;
	}
	
	/**
	 * Column Info
	 * @return tPolEtd
	 */
	public String getTPolEtd() {
		return this.tPolEtd;
	}
	
	/**
	 * Column Info
	 * @return loadId
	 */
	public String getLoadId() {
		return this.loadId;
	}
	
	/**
	 * Column Info
	 * @return pctQty
	 */
	public String getPctQty() {
		return this.pctQty;
	}
	
	/**
	 * Column Info
	 * @return oanMaxActDt
	 */
	public String getOanMaxActDt() {
		return this.oanMaxActDt;
	}
	
	/**
	 * Column Info
	 * @return blPoNo
	 */
	public String getBlPoNo() {
		return this.blPoNo;
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
	 * @return customsRlsDt
	 */
	public String getCustomsRlsDt() {
		return this.customsRlsDt;
	}
	
	/**
	 * Column Info
	 * @return podAtaticDt
	 */
	public String getPodAtaticDt() {
		return this.podAtaticDt;
	}
	
	/**
	 * Column Info
	 * @return vgmVrfySigCtnt
	 */
	public String getVgmVrfySigCtnt() {
		return this.vgmVrfySigCtnt;
	}
	
	/**
	 * Column Info
	 * @return custSiRefNo
	 */
	public String getCustSiRefNo() {
		return this.custSiRefNo;
	}
	
	/**
	 * Column Info
	 * @return delEtaDt
	 */
	public String getDelEtaDt() {
		return this.delEtaDt;
	}
	
	/**
	 * Column Info
	 * @return cctOfc
	 */
	public String getCctOfc() {
		return this.cctOfc;
	}
	
	/**
	 * Column Info
	 * @return polNm
	 */
	public String getPolNm() {
		return this.polNm;
	}
	
	/**
	 * Column Info
	 * @return freeDt
	 */
	public String getFreeDt() {
		return this.freeDt;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return evntPlc
	 */
	public String getEvntPlc() {
		return this.evntPlc;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return porCnty
	 */
	public String getPorCnty() {
		return this.porCnty;
	}
	
	/**
	 * Column Info
	 * @return currPage
	 */
	public String getCurrPage() {
		return this.currPage;
	}
	
	/**
	 * Column Info
	 * @return frtCltFlg
	 */
	public String getFrtCltFlg() {
		return this.frtCltFlg;
	}
	
	/**
	 * Column Info
	 * @return preVvd
	 */
	public String getPreVvd() {
		return this.preVvd;
	}
	
	/**
	 * Column Info
	 * @return rnum
	 */
	public String getRnum() {
		return this.rnum;
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
	 * @return wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return actCustName
	 */
	public String getActCustName() {
		return this.actCustName;
	}
	
	/**
	 * Column Info
	 * @return wblSndDtFax
	 */
	public String getWblSndDtFax() {
		return this.wblSndDtFax;
	}
	
	/**
	 * Column Info
	 * @return delDt
	 */
	public String getDelDt() {
		return this.delDt;
	}
	
	/**
	 * Column Info
	 * @return cndCstmsFileCd
	 */
	public String getCndCstmsFileCd() {
		return this.cndCstmsFileCd;
	}
	
	/**
	 * Column Info
	 * @return delState
	 */
	public String getDelState() {
		return this.delState;
	}
	
	/**
	 * Column Info
	 * @return ibdTrspIssDt
	 */
	public String getIbdTrspIssDt() {
		return this.ibdTrspIssDt;
	}
	
	/**
	 * Column Info
	 * @return oanMaxActDt2
	 */
	public String getOanMaxActDt2() {
		return this.oanMaxActDt2;
	}
	
	/**
	 * Column Info
	 * @return custRefNo
	 */
	public String getCustRefNo() {
		return this.custRefNo;
	}
	
	/**
	 * Column Info
	 * @return pod1EtaDt
	 */
	public String getPod1EtaDt() {
		return this.pod1EtaDt;
	}
	
	/**
	 * Column Info
	 * @return preRlyPortCd
	 */
	public String getPreRlyPortCd() {
		return this.preRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @return preVslNm
	 */
	public String getPreVslNm() {
		return this.preVslNm;
	}
	
	/**
	 * Column Info
	 * @return ataT
	 */
	public String getAtaT() {
		return this.ataT;
	}
	
	/**
	 * Column Info
	 * @return fPodEtd
	 */
	public String getFPodEtd() {
		return this.fPodEtd;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return oblRdemFlg
	 */
	public String getOblRdemFlg() {
		return this.oblRdemFlg;
	}
	
	/**
	 * Column Info
	 * @return fPodEta
	 */
	public String getFPodEta() {
		return this.fPodEta;
	}
	
	/**
	 * Column Info
	 * @return urnMaxActDt
	 */
	public String getUrnMaxActDt() {
		return this.urnMaxActDt;
	}
	
	/**
	 * Column Info
	 * @return spcCgo
	 */
	public String getSpcCgo() {
		return this.spcCgo;
	}
	
	/**
	 * Column Info
	 * @return porNm
	 */
	public String getPorNm() {
		return this.porNm;
	}
	
	/**
	 * Column Info
	 * @return ppdOfc
	 */
	public String getPpdOfc() {
		return this.ppdOfc;
	}
	
	/**
	 * Column Info
	 * @return ntfyName
	 */
	public String getNtfyName() {
		return this.ntfyName;
	}
	
	/**
	 * Column Info
	 * @return pod1EtdDt
	 */
	public String getPod1EtdDt() {
		return this.pod1EtdDt;
	}
	
	/**
	 * Column Info
	 * @return blIssOfc
	 */
	public String getBlIssOfc() {
		return this.blIssOfc;
	}
	
	/**
	 * Column Info
	 * @return blObrdDt
	 */
	public String getBlObrdDt() {
		return this.blObrdDt;
	}
	
	/**
	 * Column Info
	 * @return custBkgRefNo
	 */
	public String getCustBkgRefNo() {
		return this.custBkgRefNo;
	}
	
	/**
	 * Column Info
	 * @return cntrVolQty
	 */
	public String getCntrVolQty() {
		return this.cntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return initPolEtaDt
	 */
	public String getInitPolEtaDt() {
		return this.initPolEtaDt;
	}
	
	/**
	 * Column Info
	 * @return pstRlyPortCd
	 */
	public String getPstRlyPortCd() {
		return this.pstRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return shprName
	 */
	public String getShprName() {
		return this.shprName;
	}
	
	/**
	 * Column Info
	 * @return delFtEndDt
	 */
	public String getDelFtEndDt() {
		return this.delFtEndDt;
	}
	
	/**
	 * Column Info
	 * @return frdCustCd
	 */
	public String getFrdCustCd() {
		return this.frdCustCd;
	}
	
	/**
	 * Column Info
	 * @return firmsCode
	 */
	public String getFirmsCode() {
		return this.firmsCode;
	}
	
	/**
	 * Column Info
	 * @return atdT
	 */
	public String getAtdT() {
		return this.atdT;
	}
	
	/**
	 * Column Info
	 * @return ata
	 */
	public String getAta() {
		return this.ata;
	}
	
	/**
	 * Column Info
	 * @return bdrFlg
	 */
	public String getBdrFlg() {
		return this.bdrFlg;
	}
	
	/**
	 * Column Info
	 * @return trunkVvd
	 */
	public String getTrunkVvd() {
		return this.trunkVvd;
	}
	
	/**
	 * Column Info
	 * @return vgmWgt
	 */
	public String getVgmWgt() {
		return this.vgmWgt;
	}
	
	/**
	 * Column Info
	 * @return dysLstMvmt
	 */
	public String getDysLstMvmt() {
		return this.dysLstMvmt;
	}
	
	/**
	 * Column Info
	 * @return mkDesc
	 */
	public String getMkDesc() {
		return this.mkDesc;
	}
	
	/**
	 * Column Info
	 * @return gCustShpr
	 */
	public String getGCustShpr() {
		return this.gCustShpr;
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
	 * @return polEtd
	 */
	public String getPolEtd() {
		return this.polEtd;
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
	 * @return porGateInDt
	 */
	public String getPorGateInDt() {
		return this.porGateInDt;
	}
	
	/**
	 * Column Info
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	
	/**
	 * Column Info
	 * @return exportRefNo
	 */
	public String getExportRefNo() {
		return this.exportRefNo;
	}
	
	/**
	 * Column Info
	 * @return cstmsDesc
	 */
	public String getCstmsDesc() {
		return this.cstmsDesc;
	}
	
	/**
	 * Column Info
	 * @return measQty
	 */
	public String getMeasQty() {
		return this.measQty;
	}
	
	/**
	 * Column Info
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
	}
	
	/**
	 * Column Info
	 * @return dMaxActDt
	 */
	public String getDMaxActDt() {
		return this.dMaxActDt;
	}
	
	/**
	 * Column Info
	 * @return atd
	 */
	public String getAtd() {
		return this.atd;
	}
	
	/**
	 * Column Info
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return initPodEtaDt
	 */
	public String getInitPodEtaDt() {
		return this.initPodEtaDt;
	}
	
	/**
	 * Column Info
	 * @return pol1EtdDt
	 */
	public String getPol1EtdDt() {
		return this.pol1EtdDt;
	}
	
	/**
	 * Column Info
	 * @return cntrPoNo
	 */
	public String getCntrPoNo() {
		return this.cntrPoNo;
	}
	
	/**
	 * Column Info
	 * @return webPrt
	 */
	public String getWebPrt() {
		return this.webPrt;
	}
	
	/**
	 * Column Info
	 * @return cstmsClrCd
	 */
	public String getCstmsClrCd() {
		return this.cstmsClrCd;
	}
	
	/**
	 * Column Info
	 * @return cgoStsCd
	 */
	public String getCgoStsCd() {
		return this.cgoStsCd;
	}
	
	/**
	 * Column Info
	 * @return cntrOcDate
	 */
	public String getCntrOcDate() {
		return this.cntrOcDate;
	}
	
	/**
	 * Column Info
	 * @return eqCtrlOfc
	 */
	public String getEqCtrlOfc() {
		return this.eqCtrlOfc;
	}
	
	/**
	 * Column Info
	 * @return usaCstmsFileCd
	 */
	public String getUsaCstmsFileCd() {
		return this.usaCstmsFileCd;
	}
	
	/**
	 * Column Info
	 * @return actWgt
	 */
	public String getActWgt() {
		return this.actWgt;
	}
	
	/**
	 * Column Info
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
	}
	
	/**
	 * Column Info
	 * @return repCmdt
	 */
	public String getRepCmdt() {
		return this.repCmdt;
	}
	
	/**
	 * Column Info
	 * @return cneeCode
	 */
	public String getCneeCode() {
		return this.cneeCode;
	}
	
	/**
	 * Column Info
	 * @return cntrSize
	 */
	public String getCntrSize() {
		return this.cntrSize;
	}
	
	/**
	 * Column Info
	 * @return cneeName
	 */
	public String getCneeName() {
		return this.cneeName;
	}
	
	/**
	 * Column Info
	 * @return avalDt
	 */
	public String getAvalDt() {
		return this.avalDt;
	}
	
	/**
	 * Column Info
	 * @return scac
	 */
	public String getScac() {
		return this.scac;
	}
	
	/**
	 * Column Info
	 * @return shprCode
	 */
	public String getShprCode() {
		return this.shprCode;
	}
	
	/**
	 * Column Info
	 * @return custInvNo
	 */
	public String getCustInvNo() {
		return this.custInvNo;
	}
	
	/**
	 * Column Info
	 * @return ppdCharge
	 */
	public String getPpdCharge() {
		return this.ppdCharge;
	}
	
	/**
	 * Column Info
	 * @return postVslNm
	 */
	public String getPostVslNm() {
		return this.postVslNm;
	}
	
	/**
	 * Column Info
	 * @return cntrSealNo
	 */
	public String getCntrSealNo() {
		return this.cntrSealNo;
	}
	
	/**
	 * Column Info
	 * @return podEtb
	 */
	public String getPodEtb() {
		return this.podEtb;
	}
	
	/**
	 * Column Info
	 * @return totMeas
	 */
	public String getTotMeas() {
		return this.totMeas;
	}
	
	/**
	 * Column Info
	 * @return hubLocCd
	 */
	public String getHubLocCd() {
		return this.hubLocCd;
	}
	
	/**
	 * Column Info
	 * @return podEta
	 */
	public String getPodEta() {
		return this.podEta;
	}
	

	/**
	 * Column Info
	 * @param delAta
	 */
	public void setDelAta(String delAta) {
		this.delAta = delAta;
	}
	
	/**
	 * Column Info
	 * @param vgmWgtUtCd
	 */
	public void setVgmWgtUtCd(String vgmWgtUtCd) {
		this.vgmWgtUtCd = vgmWgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param preVvdNm
	 */
	public void setPreVvdNm(String preVvdNm) {
		this.preVvdNm = preVvdNm;
	}
	
	/**
	 * Column Info
	 * @param actCustCode
	 */
	public void setActCustCode(String actCustCode) {
		this.actCustCode = actCustCode;
	}
	
	/**
	 * Column Info
	 * @param ntfyCode
	 */
	public void setNtfyCode(String ntfyCode) {
		this.ntfyCode = ntfyCode;
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
	 * @param dchgTsPortDt
	 */
	public void setDchgTsPortDt(String dchgTsPortDt) {
		this.dchgTsPortDt = dchgTsPortDt;
	}
	
	/**
	 * Column Info
	 * @param oblIssDt
	 */
	public void setOblIssDt(String oblIssDt) {
		this.oblIssDt = oblIssDt;
	}
	
	/**
	 * Column Info
	 * @param uvdMaxActDt2
	 */
	public void setUvdMaxActDt2(String uvdMaxActDt2) {
		this.uvdMaxActDt2 = uvdMaxActDt2;
	}
	
	/**
	 * Column Info
	 * @param uvdMaxActDt
	 */
	public void setUvdMaxActDt(String uvdMaxActDt) {
		this.uvdMaxActDt = uvdMaxActDt;
	}
	
	/**
	 * Column Info
	 * @param dblSndDtFax
	 */
	public void setDblSndDtFax(String dblSndDtFax) {
		this.dblSndDtFax = dblSndDtFax;
	}
	
	/**
	 * Column Info
	 * @param cgoRcvDt
	 */
	public void setCgoRcvDt(String cgoRcvDt) {
		this.cgoRcvDt = cgoRcvDt;
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
	 * @param deptNo
	 */
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}
	
	/**
	 * Column Info
	 * @param delCnty
	 */
	public void setDelCnty(String delCnty) {
		this.delCnty = delCnty;
	}
	
	/**
	 * Column Info
	 * @param rowsPerPage
	 */
	public void setRowsPerPage(String rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}
	
	/**
	 * Column Info
	 * @param chgAmt
	 */
	public void setChgAmt(String chgAmt) {
		this.chgAmt = chgAmt;
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
	 * @param cntrWgtUtCd
	 */
	public void setCntrWgtUtCd(String cntrWgtUtCd) {
		this.cntrWgtUtCd = cntrWgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param cntrMeasUtCd
	 */
	public void setCntrMeasUtCd(String cntrMeasUtCd) {
		this.cntrMeasUtCd = cntrMeasUtCd;
	}
	
	/**
	 * Column Info
	 * @param anSendDt
	 */
	public void setAnSendDt(String anSendDt) {
		this.anSendDt = anSendDt;
	}
	
	/**
	 * Column Info
	 * @param frdCustNm
	 */
	public void setFrdCustNm(String frdCustNm) {
		this.frdCustNm = frdCustNm;
	}
	
	/**
	 * Column Info
	 * @param itNo
	 */
	public void setItNo(String itNo) {
		this.itNo = itNo;
	}
	
	/**
	 * Column Info
	 * @param totalCnt
	 */
	public void setTotalCnt(String totalCnt) {
		this.totalCnt = totalCnt;
	}
	
	/**
	 * Column Info
	 * @param shipId
	 */
	public void setShipId(String shipId) {
		this.shipId = shipId;
	}
	
	/**
	 * Column Info
	 * @param cntrPckTpCd
	 */
	public void setCntrPckTpCd(String cntrPckTpCd) {
		this.cntrPckTpCd = cntrPckTpCd;
	}
	
	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param cntrPrtFlg
	 */
	public void setCntrPrtFlg(String cntrPrtFlg) {
		this.cntrPrtFlg = cntrPrtFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrWgt
	 */
	public void setCntrWgt(String cntrWgt) {
		this.cntrWgt = cntrWgt;
	}
	
	/**
	 * Column Info
	 * @param rlnMaxActDt
	 */
	public void setRlnMaxActDt(String rlnMaxActDt) {
		this.rlnMaxActDt = rlnMaxActDt;
	}
	
	/**
	 * Column Info
	 * @param destSvcModCd
	 */
	public void setDestSvcModCd(String destSvcModCd) {
		this.destSvcModCd = destSvcModCd;
	}
	
	/**
	 * Column Info
	 * @param finalDestNm
	 */
	public void setFinalDestNm(String finalDestNm) {
		this.finalDestNm = finalDestNm;
	}
	
	/**
	 * Column Info
	 * @param prtNo
	 */
	public void setPrtNo(String prtNo) {
		this.prtNo = prtNo;
	}
	
	/**
	 * Column Info
	 * @param mtReturnDt
	 */
	public void setMtReturnDt(String mtReturnDt) {
		this.mtReturnDt = mtReturnDt;
	}
	
	/**
	 * Column Info
	 * @param dspoCd
	 */
	public void setDspoCd(String dspoCd) {
		this.dspoCd = dspoCd;
	}
	
	/**
	 * Column Info
	 * @param stsNm
	 */
	public void setStsNm(String stsNm) {
		this.stsNm = stsNm;
	}
	
	/**
	 * Column Info
	 * @param caItno
	 */
	public void setCaItno(String caItno) {
		this.caItno = caItno;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param dblSndDtEdi
	 */
	public void setDblSndDtEdi(String dblSndDtEdi) {
		this.dblSndDtEdi = dblSndDtEdi;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param tPodEta
	 */
	public void setTPodEta(String tPodEta) {
		this.tPodEta = tPodEta;
	}
	
	/**
	 * Column Info
	 * @param bkgRctSndDtFax
	 */
	public void setBkgRctSndDtFax(String bkgRctSndDtFax) {
		this.bkgRctSndDtFax = bkgRctSndDtFax;
	}
	
	/**
	 * Column Info
	 * @param cnrrRefNo
	 */
	public void setCnrrRefNo(String cnrrRefNo) {
		this.cnrrRefNo = cnrrRefNo;
	}
	
	/**
	 * Column Info
	 * @param pol1EtaDt
	 */
	public void setPol1EtaDt(String pol1EtaDt) {
		this.pol1EtaDt = pol1EtaDt;
	}
	
	/**
	 * Column Info
	 * @param pkupNo
	 */
	public void setPkupNo(String pkupNo) {
		this.pkupNo = pkupNo;
	}
	
	/**
	 * Column Info
	 * @param tPodEtd
	 */
	public void setTPodEtd(String tPodEtd) {
		this.tPodEtd = tPodEtd;
	}
	
	/**
	 * Column Info
	 * @param laneCd
	 */
	public void setLaneCd(String laneCd) {
		this.laneCd = laneCd;
	}
	
	/**
	 * Column Info
	 * @param podFtEndDt
	 */
	public void setPodFtEndDt(String podFtEndDt) {
		this.podFtEndDt = podFtEndDt;
	}
	
	/**
	 * Column Info
	 * @param fPolEta
	 */
	public void setFPolEta(String fPolEta) {
		this.fPolEta = fPolEta;
	}
	
	/**
	 * Column Info
	 * @param bkgRctSndDtEdi
	 */
	public void setBkgRctSndDtEdi(String bkgRctSndDtEdi) {
		this.bkgRctSndDtEdi = bkgRctSndDtEdi;
	}
	
	/**
	 * Column Info
	 * @param fPolEtd
	 */
	public void setFPolEtd(String fPolEtd) {
		this.fPolEtd = fPolEtd;
	}
	
	/**
	 * Column Info
	 * @param evntDtTm
	 */
	public void setEvntDtTm(String evntDtTm) {
		this.evntDtTm = evntDtTm;
	}
	
	/**
	 * Column Info
	 * @param cctCharge
	 */
	public void setCctCharge(String cctCharge) {
		this.cctCharge = cctCharge;
	}
	
	/**
	 * Column Info
	 * @param trunkVessel
	 */
	public void setTrunkVessel(String trunkVessel) {
		this.trunkVessel = trunkVessel;
	}
	
	/**
	 * Column Info
	 * @param initPolEtdDt
	 */
	public void setInitPolEtdDt(String initPolEtdDt) {
		this.initPolEtdDt = initPolEtdDt;
	}
	
	/**
	 * Column Info
	 * @param pkupNodCd
	 */
	public void setPkupNodCd(String pkupNodCd) {
		this.pkupNodCd = pkupNodCd;
	}
	
	/**
	 * Column Info
	 * @param scacCd
	 */
	public void setScacCd(String scacCd) {
		this.scacCd = scacCd;
	}
	
	/**
	 * Column Info
	 * @param itemPoNo
	 */
	public void setItemPoNo(String itemPoNo) {
		this.itemPoNo = itemPoNo;
	}
	
	/**
	 * Column Info
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}
	
	/**
	 * Column Info
	 * @param overdue
	 */
	public void setOverdue(String overdue) {
		this.overdue = overdue;
	}
	
	/**
	 * Column Info
	 * @param postVvdNm
	 */
	public void setPostVvdNm(String postVvdNm) {
		this.postVvdNm = postVvdNm;
	}
	
	/**
	 * Column Info
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}
	
	/**
	 * Column Info
	 * @param measUtCd
	 */
	public void setMeasUtCd(String measUtCd) {
		this.measUtCd = measUtCd;
	}
	
	/**
	 * Column Info
	 * @param dueDate
	 */
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	
	/**
	 * Column Info
	 * @param gCustCnee
	 */
	public void setGCustCnee(String gCustCnee) {
		this.gCustCnee = gCustCnee;
	}
	
	/**
	 * Column Info
	 * @param ntfyAddr
	 */
	public void setNtfyAddr(String ntfyAddr) {
		this.ntfyAddr = ntfyAddr;
	}
	
	/**
	 * Column Info
	 * @param postVvd
	 */
	public void setPostVvd(String postVvd) {
		this.postVvd = postVvd;
	}
	
	/**
	 * Column Info
	 * @param rmk
	 */
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
	
	/**
	 * Column Info
	 * @param tPolEta
	 */
	public void setTPolEta(String tPolEta) {
		this.tPolEta = tPolEta;
	}
	
	/**
	 * Column Info
	 * @param podNm
	 */
	public void setPodNm(String podNm) {
		this.podNm = podNm;
	}
	
	/**
	 * Column Info
	 * @param vgmMzdTpCd
	 */
	public void setVgmMzdTpCd(String vgmMzdTpCd) {
		this.vgmMzdTpCd = vgmMzdTpCd;
	}
	
	/**
	 * Column Info
	 * @param delNm
	 */
	public void setDelNm(String delNm) {
		this.delNm = delNm;
	}
	
	/**
	 * Column Info
	 * @param tPolEtd
	 */
	public void setTPolEtd(String tPolEtd) {
		this.tPolEtd = tPolEtd;
	}
	
	/**
	 * Column Info
	 * @param loadId
	 */
	public void setLoadId(String loadId) {
		this.loadId = loadId;
	}
	
	/**
	 * Column Info
	 * @param pctQty
	 */
	public void setPctQty(String pctQty) {
		this.pctQty = pctQty;
	}
	
	/**
	 * Column Info
	 * @param oanMaxActDt
	 */
	public void setOanMaxActDt(String oanMaxActDt) {
		this.oanMaxActDt = oanMaxActDt;
	}
	
	/**
	 * Column Info
	 * @param blPoNo
	 */
	public void setBlPoNo(String blPoNo) {
		this.blPoNo = blPoNo;
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
	 * @param customsRlsDt
	 */
	public void setCustomsRlsDt(String customsRlsDt) {
		this.customsRlsDt = customsRlsDt;
	}
	
	/**
	 * Column Info
	 * @param podAtaticDt
	 */
	public void setPodAtaticDt(String podAtaticDt) {
		this.podAtaticDt = podAtaticDt;
	}
	
	/**
	 * Column Info
	 * @param vgmVrfySigCtnt
	 */
	public void setVgmVrfySigCtnt(String vgmVrfySigCtnt) {
		this.vgmVrfySigCtnt = vgmVrfySigCtnt;
	}
	
	/**
	 * Column Info
	 * @param custSiRefNo
	 */
	public void setCustSiRefNo(String custSiRefNo) {
		this.custSiRefNo = custSiRefNo;
	}
	
	/**
	 * Column Info
	 * @param delEtaDt
	 */
	public void setDelEtaDt(String delEtaDt) {
		this.delEtaDt = delEtaDt;
	}
	
	/**
	 * Column Info
	 * @param cctOfc
	 */
	public void setCctOfc(String cctOfc) {
		this.cctOfc = cctOfc;
	}
	
	/**
	 * Column Info
	 * @param polNm
	 */
	public void setPolNm(String polNm) {
		this.polNm = polNm;
	}
	
	/**
	 * Column Info
	 * @param freeDt
	 */
	public void setFreeDt(String freeDt) {
		this.freeDt = freeDt;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param evntPlc
	 */
	public void setEvntPlc(String evntPlc) {
		this.evntPlc = evntPlc;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param porCnty
	 */
	public void setPorCnty(String porCnty) {
		this.porCnty = porCnty;
	}
	
	/**
	 * Column Info
	 * @param currPage
	 */
	public void setCurrPage(String currPage) {
		this.currPage = currPage;
	}
	
	/**
	 * Column Info
	 * @param frtCltFlg
	 */
	public void setFrtCltFlg(String frtCltFlg) {
		this.frtCltFlg = frtCltFlg;
	}
	
	/**
	 * Column Info
	 * @param preVvd
	 */
	public void setPreVvd(String preVvd) {
		this.preVvd = preVvd;
	}
	
	/**
	 * Column Info
	 * @param rnum
	 */
	public void setRnum(String rnum) {
		this.rnum = rnum;
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
	 * @param wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param actCustName
	 */
	public void setActCustName(String actCustName) {
		this.actCustName = actCustName;
	}
	
	/**
	 * Column Info
	 * @param wblSndDtFax
	 */
	public void setWblSndDtFax(String wblSndDtFax) {
		this.wblSndDtFax = wblSndDtFax;
	}
	
	/**
	 * Column Info
	 * @param delDt
	 */
	public void setDelDt(String delDt) {
		this.delDt = delDt;
	}
	
	/**
	 * Column Info
	 * @param cndCstmsFileCd
	 */
	public void setCndCstmsFileCd(String cndCstmsFileCd) {
		this.cndCstmsFileCd = cndCstmsFileCd;
	}
	
	/**
	 * Column Info
	 * @param delState
	 */
	public void setDelState(String delState) {
		this.delState = delState;
	}
	
	/**
	 * Column Info
	 * @param ibdTrspIssDt
	 */
	public void setIbdTrspIssDt(String ibdTrspIssDt) {
		this.ibdTrspIssDt = ibdTrspIssDt;
	}
	
	/**
	 * Column Info
	 * @param oanMaxActDt2
	 */
	public void setOanMaxActDt2(String oanMaxActDt2) {
		this.oanMaxActDt2 = oanMaxActDt2;
	}
	
	/**
	 * Column Info
	 * @param custRefNo
	 */
	public void setCustRefNo(String custRefNo) {
		this.custRefNo = custRefNo;
	}
	
	/**
	 * Column Info
	 * @param pod1EtaDt
	 */
	public void setPod1EtaDt(String pod1EtaDt) {
		this.pod1EtaDt = pod1EtaDt;
	}
	
	/**
	 * Column Info
	 * @param preRlyPortCd
	 */
	public void setPreRlyPortCd(String preRlyPortCd) {
		this.preRlyPortCd = preRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @param preVslNm
	 */
	public void setPreVslNm(String preVslNm) {
		this.preVslNm = preVslNm;
	}
	
	/**
	 * Column Info
	 * @param ataT
	 */
	public void setAtaT(String ataT) {
		this.ataT = ataT;
	}
	
	/**
	 * Column Info
	 * @param fPodEtd
	 */
	public void setFPodEtd(String fPodEtd) {
		this.fPodEtd = fPodEtd;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param oblRdemFlg
	 */
	public void setOblRdemFlg(String oblRdemFlg) {
		this.oblRdemFlg = oblRdemFlg;
	}
	
	/**
	 * Column Info
	 * @param fPodEta
	 */
	public void setFPodEta(String fPodEta) {
		this.fPodEta = fPodEta;
	}
	
	/**
	 * Column Info
	 * @param urnMaxActDt
	 */
	public void setUrnMaxActDt(String urnMaxActDt) {
		this.urnMaxActDt = urnMaxActDt;
	}
	
	/**
	 * Column Info
	 * @param spcCgo
	 */
	public void setSpcCgo(String spcCgo) {
		this.spcCgo = spcCgo;
	}
	
	/**
	 * Column Info
	 * @param porNm
	 */
	public void setPorNm(String porNm) {
		this.porNm = porNm;
	}
	
	/**
	 * Column Info
	 * @param ppdOfc
	 */
	public void setPpdOfc(String ppdOfc) {
		this.ppdOfc = ppdOfc;
	}
	
	/**
	 * Column Info
	 * @param ntfyName
	 */
	public void setNtfyName(String ntfyName) {
		this.ntfyName = ntfyName;
	}
	
	/**
	 * Column Info
	 * @param pod1EtdDt
	 */
	public void setPod1EtdDt(String pod1EtdDt) {
		this.pod1EtdDt = pod1EtdDt;
	}
	
	/**
	 * Column Info
	 * @param blIssOfc
	 */
	public void setBlIssOfc(String blIssOfc) {
		this.blIssOfc = blIssOfc;
	}
	
	/**
	 * Column Info
	 * @param blObrdDt
	 */
	public void setBlObrdDt(String blObrdDt) {
		this.blObrdDt = blObrdDt;
	}
	
	/**
	 * Column Info
	 * @param custBkgRefNo
	 */
	public void setCustBkgRefNo(String custBkgRefNo) {
		this.custBkgRefNo = custBkgRefNo;
	}
	
	/**
	 * Column Info
	 * @param cntrVolQty
	 */
	public void setCntrVolQty(String cntrVolQty) {
		this.cntrVolQty = cntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param initPolEtaDt
	 */
	public void setInitPolEtaDt(String initPolEtaDt) {
		this.initPolEtaDt = initPolEtaDt;
	}
	
	/**
	 * Column Info
	 * @param pstRlyPortCd
	 */
	public void setPstRlyPortCd(String pstRlyPortCd) {
		this.pstRlyPortCd = pstRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param shprName
	 */
	public void setShprName(String shprName) {
		this.shprName = shprName;
	}
	
	/**
	 * Column Info
	 * @param delFtEndDt
	 */
	public void setDelFtEndDt(String delFtEndDt) {
		this.delFtEndDt = delFtEndDt;
	}
	
	/**
	 * Column Info
	 * @param frdCustCd
	 */
	public void setFrdCustCd(String frdCustCd) {
		this.frdCustCd = frdCustCd;
	}
	
	/**
	 * Column Info
	 * @param firmsCode
	 */
	public void setFirmsCode(String firmsCode) {
		this.firmsCode = firmsCode;
	}
	
	/**
	 * Column Info
	 * @param atdT
	 */
	public void setAtdT(String atdT) {
		this.atdT = atdT;
	}
	
	/**
	 * Column Info
	 * @param ata
	 */
	public void setAta(String ata) {
		this.ata = ata;
	}
	
	/**
	 * Column Info
	 * @param bdrFlg
	 */
	public void setBdrFlg(String bdrFlg) {
		this.bdrFlg = bdrFlg;
	}
	
	/**
	 * Column Info
	 * @param trunkVvd
	 */
	public void setTrunkVvd(String trunkVvd) {
		this.trunkVvd = trunkVvd;
	}
	
	/**
	 * Column Info
	 * @param vgmWgt
	 */
	public void setVgmWgt(String vgmWgt) {
		this.vgmWgt = vgmWgt;
	}
	
	/**
	 * Column Info
	 * @param dysLstMvmt
	 */
	public void setDysLstMvmt(String dysLstMvmt) {
		this.dysLstMvmt = dysLstMvmt;
	}
	
	/**
	 * Column Info
	 * @param mkDesc
	 */
	public void setMkDesc(String mkDesc) {
		this.mkDesc = mkDesc;
	}
	
	/**
	 * Column Info
	 * @param gCustShpr
	 */
	public void setGCustShpr(String gCustShpr) {
		this.gCustShpr = gCustShpr;
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
	 * @param polEtd
	 */
	public void setPolEtd(String polEtd) {
		this.polEtd = polEtd;
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
	 * @param porGateInDt
	 */
	public void setPorGateInDt(String porGateInDt) {
		this.porGateInDt = porGateInDt;
	}
	
	/**
	 * Column Info
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}
	
	/**
	 * Column Info
	 * @param exportRefNo
	 */
	public void setExportRefNo(String exportRefNo) {
		this.exportRefNo = exportRefNo;
	}
	
	/**
	 * Column Info
	 * @param cstmsDesc
	 */
	public void setCstmsDesc(String cstmsDesc) {
		this.cstmsDesc = cstmsDesc;
	}
	
	/**
	 * Column Info
	 * @param measQty
	 */
	public void setMeasQty(String measQty) {
		this.measQty = measQty;
	}
	
	/**
	 * Column Info
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
	}
	
	/**
	 * Column Info
	 * @param dMaxActDt
	 */
	public void setDMaxActDt(String dMaxActDt) {
		this.dMaxActDt = dMaxActDt;
	}
	
	/**
	 * Column Info
	 * @param atd
	 */
	public void setAtd(String atd) {
		this.atd = atd;
	}
	
	/**
	 * Column Info
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param initPodEtaDt
	 */
	public void setInitPodEtaDt(String initPodEtaDt) {
		this.initPodEtaDt = initPodEtaDt;
	}
	
	/**
	 * Column Info
	 * @param pol1EtdDt
	 */
	public void setPol1EtdDt(String pol1EtdDt) {
		this.pol1EtdDt = pol1EtdDt;
	}
	
	/**
	 * Column Info
	 * @param cntrPoNo
	 */
	public void setCntrPoNo(String cntrPoNo) {
		this.cntrPoNo = cntrPoNo;
	}
	
	/**
	 * Column Info
	 * @param webPrt
	 */
	public void setWebPrt(String webPrt) {
		this.webPrt = webPrt;
	}
	
	/**
	 * Column Info
	 * @param cstmsClrCd
	 */
	public void setCstmsClrCd(String cstmsClrCd) {
		this.cstmsClrCd = cstmsClrCd;
	}
	
	/**
	 * Column Info
	 * @param cgoStsCd
	 */
	public void setCgoStsCd(String cgoStsCd) {
		this.cgoStsCd = cgoStsCd;
	}
	
	/**
	 * Column Info
	 * @param cntrOcDate
	 */
	public void setCntrOcDate(String cntrOcDate) {
		this.cntrOcDate = cntrOcDate;
	}
	
	/**
	 * Column Info
	 * @param eqCtrlOfc
	 */
	public void setEqCtrlOfc(String eqCtrlOfc) {
		this.eqCtrlOfc = eqCtrlOfc;
	}
	
	/**
	 * Column Info
	 * @param usaCstmsFileCd
	 */
	public void setUsaCstmsFileCd(String usaCstmsFileCd) {
		this.usaCstmsFileCd = usaCstmsFileCd;
	}
	
	/**
	 * Column Info
	 * @param actWgt
	 */
	public void setActWgt(String actWgt) {
		this.actWgt = actWgt;
	}
	
	/**
	 * Column Info
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
	}
	
	/**
	 * Column Info
	 * @param repCmdt
	 */
	public void setRepCmdt(String repCmdt) {
		this.repCmdt = repCmdt;
	}
	
	/**
	 * Column Info
	 * @param cneeCode
	 */
	public void setCneeCode(String cneeCode) {
		this.cneeCode = cneeCode;
	}
	
	/**
	 * Column Info
	 * @param cntrSize
	 */
	public void setCntrSize(String cntrSize) {
		this.cntrSize = cntrSize;
	}
	
	/**
	 * Column Info
	 * @param cneeName
	 */
	public void setCneeName(String cneeName) {
		this.cneeName = cneeName;
	}
	
	/**
	 * Column Info
	 * @param avalDt
	 */
	public void setAvalDt(String avalDt) {
		this.avalDt = avalDt;
	}
	
	/**
	 * Column Info
	 * @param scac
	 */
	public void setScac(String scac) {
		this.scac = scac;
	}
	
	/**
	 * Column Info
	 * @param shprCode
	 */
	public void setShprCode(String shprCode) {
		this.shprCode = shprCode;
	}
	
	/**
	 * Column Info
	 * @param custInvNo
	 */
	public void setCustInvNo(String custInvNo) {
		this.custInvNo = custInvNo;
	}
	
	/**
	 * Column Info
	 * @param ppdCharge
	 */
	public void setPpdCharge(String ppdCharge) {
		this.ppdCharge = ppdCharge;
	}
	
	/**
	 * Column Info
	 * @param postVslNm
	 */
	public void setPostVslNm(String postVslNm) {
		this.postVslNm = postVslNm;
	}
	
	/**
	 * Column Info
	 * @param cntrSealNo
	 */
	public void setCntrSealNo(String cntrSealNo) {
		this.cntrSealNo = cntrSealNo;
	}
	
	/**
	 * Column Info
	 * @param podEtb
	 */
	public void setPodEtb(String podEtb) {
		this.podEtb = podEtb;
	}
	
	/**
	 * Column Info
	 * @param totMeas
	 */
	public void setTotMeas(String totMeas) {
		this.totMeas = totMeas;
	}
	
	/**
	 * Column Info
	 * @param hubLocCd
	 */
	public void setHubLocCd(String hubLocCd) {
		this.hubLocCd = hubLocCd;
	}
	
	/**
	 * Column Info
	 * @param podEta
	 */
	public void setPodEta(String podEta) {
		this.podEta = podEta;
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
		setDelAta(JSPUtil.getParameter(request, prefix + "del_ata", ""));
		setVgmWgtUtCd(JSPUtil.getParameter(request, prefix + "vgm_wgt_ut_cd", ""));
		setPreVvdNm(JSPUtil.getParameter(request, prefix + "pre_vvd_nm", ""));
		setActCustCode(JSPUtil.getParameter(request, prefix + "act_cust_code", ""));
		setNtfyCode(JSPUtil.getParameter(request, prefix + "ntfy_code", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setDchgTsPortDt(JSPUtil.getParameter(request, prefix + "dchg_ts_port_dt", ""));
		setOblIssDt(JSPUtil.getParameter(request, prefix + "obl_iss_dt", ""));
		setUvdMaxActDt2(JSPUtil.getParameter(request, prefix + "uvd_max_act_dt2", ""));
		setUvdMaxActDt(JSPUtil.getParameter(request, prefix + "uvd_max_act_dt", ""));
		setDblSndDtFax(JSPUtil.getParameter(request, prefix + "dbl_snd_dt_fax", ""));
		setCgoRcvDt(JSPUtil.getParameter(request, prefix + "cgo_rcv_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDeptNo(JSPUtil.getParameter(request, prefix + "dept_no", ""));
		setDelCnty(JSPUtil.getParameter(request, prefix + "del_cnty", ""));
		setRowsPerPage(JSPUtil.getParameter(request, prefix + "rows_per_page", ""));
		setChgAmt(JSPUtil.getParameter(request, prefix + "chg_amt", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setCntrWgtUtCd(JSPUtil.getParameter(request, prefix + "cntr_wgt_ut_cd", ""));
		setCntrMeasUtCd(JSPUtil.getParameter(request, prefix + "cntr_meas_ut_cd", ""));
		setAnSendDt(JSPUtil.getParameter(request, prefix + "an_send_dt", ""));
		setFrdCustNm(JSPUtil.getParameter(request, prefix + "frd_cust_nm", ""));
		setItNo(JSPUtil.getParameter(request, prefix + "it_no", ""));
		setTotalCnt(JSPUtil.getParameter(request, prefix + "total_cnt", ""));
		setShipId(JSPUtil.getParameter(request, prefix + "ship_id", ""));
		setCntrPckTpCd(JSPUtil.getParameter(request, prefix + "cntr_pck_tp_cd", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setCntrPrtFlg(JSPUtil.getParameter(request, prefix + "cntr_prt_flg", ""));
		setCntrWgt(JSPUtil.getParameter(request, prefix + "cntr_wgt", ""));
		setRlnMaxActDt(JSPUtil.getParameter(request, prefix + "rln_max_act_dt", ""));
		setDestSvcModCd(JSPUtil.getParameter(request, prefix + "dest_svc_mod_cd", ""));
		setFinalDestNm(JSPUtil.getParameter(request, prefix + "final_dest_nm", ""));
		setPrtNo(JSPUtil.getParameter(request, prefix + "prt_no", ""));
		setMtReturnDt(JSPUtil.getParameter(request, prefix + "mt_return_dt", ""));
		setDspoCd(JSPUtil.getParameter(request, prefix + "dspo_cd", ""));
		setStsNm(JSPUtil.getParameter(request, prefix + "sts_nm", ""));
		setCaItno(JSPUtil.getParameter(request, prefix + "ca_itno", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setDblSndDtEdi(JSPUtil.getParameter(request, prefix + "dbl_snd_dt_edi", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setTPodEta(JSPUtil.getParameter(request, prefix + "t_pod_eta", ""));
		setBkgRctSndDtFax(JSPUtil.getParameter(request, prefix + "bkg_rct_snd_dt_fax", ""));
		setCnrrRefNo(JSPUtil.getParameter(request, prefix + "cnrr_ref_no", ""));
		setPol1EtaDt(JSPUtil.getParameter(request, prefix + "pol1_eta_dt", ""));
		setPkupNo(JSPUtil.getParameter(request, prefix + "pkup_no", ""));
		setTPodEtd(JSPUtil.getParameter(request, prefix + "t_pod_etd", ""));
		setLaneCd(JSPUtil.getParameter(request, prefix + "lane_cd", ""));
		setPodFtEndDt(JSPUtil.getParameter(request, prefix + "pod_ft_end_dt", ""));
		setFPolEta(JSPUtil.getParameter(request, prefix + "f_pol_eta", ""));
		setBkgRctSndDtEdi(JSPUtil.getParameter(request, prefix + "bkg_rct_snd_dt_edi", ""));
		setFPolEtd(JSPUtil.getParameter(request, prefix + "f_pol_etd", ""));
		setEvntDtTm(JSPUtil.getParameter(request, prefix + "evnt_dt_tm", ""));
		setCctCharge(JSPUtil.getParameter(request, prefix + "cct_charge", ""));
		setTrunkVessel(JSPUtil.getParameter(request, prefix + "trunk_vessel", ""));
		setInitPolEtdDt(JSPUtil.getParameter(request, prefix + "init_pol_etd_dt", ""));
		setPkupNodCd(JSPUtil.getParameter(request, prefix + "pkup_nod_cd", ""));
		setScacCd(JSPUtil.getParameter(request, prefix + "scac_cd", ""));
		setItemPoNo(JSPUtil.getParameter(request, prefix + "item_po_no", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setOverdue(JSPUtil.getParameter(request, prefix + "overdue", ""));
		setPostVvdNm(JSPUtil.getParameter(request, prefix + "post_vvd_nm", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setMeasUtCd(JSPUtil.getParameter(request, prefix + "meas_ut_cd", ""));
		setDueDate(JSPUtil.getParameter(request, prefix + "due_date", ""));
		setGCustCnee(JSPUtil.getParameter(request, prefix + "g_cust_cnee", ""));
		setNtfyAddr(JSPUtil.getParameter(request, prefix + "ntfy_addr", ""));
		setPostVvd(JSPUtil.getParameter(request, prefix + "post_vvd", ""));
		setRmk(JSPUtil.getParameter(request, prefix + "rmk", ""));
		setTPolEta(JSPUtil.getParameter(request, prefix + "t_pol_eta", ""));
		setPodNm(JSPUtil.getParameter(request, prefix + "pod_nm", ""));
		setVgmMzdTpCd(JSPUtil.getParameter(request, prefix + "vgm_mzd_tp_cd", ""));
		setDelNm(JSPUtil.getParameter(request, prefix + "del_nm", ""));
		setTPolEtd(JSPUtil.getParameter(request, prefix + "t_pol_etd", ""));
		setLoadId(JSPUtil.getParameter(request, prefix + "load_id", ""));
		setPctQty(JSPUtil.getParameter(request, prefix + "pct_qty", ""));
		setOanMaxActDt(JSPUtil.getParameter(request, prefix + "oan_max_act_dt", ""));
		setBlPoNo(JSPUtil.getParameter(request, prefix + "bl_po_no", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCustomsRlsDt(JSPUtil.getParameter(request, prefix + "customs_rls_dt", ""));
		setPodAtaticDt(JSPUtil.getParameter(request, prefix + "pod_atatic_dt", ""));
		setVgmVrfySigCtnt(JSPUtil.getParameter(request, prefix + "vgm_vrfy_sig_ctnt", ""));
		setCustSiRefNo(JSPUtil.getParameter(request, prefix + "cust_si_ref_no", ""));
		setDelEtaDt(JSPUtil.getParameter(request, prefix + "del_eta_dt", ""));
		setCctOfc(JSPUtil.getParameter(request, prefix + "cct_ofc", ""));
		setPolNm(JSPUtil.getParameter(request, prefix + "pol_nm", ""));
		setFreeDt(JSPUtil.getParameter(request, prefix + "free_dt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setEvntPlc(JSPUtil.getParameter(request, prefix + "evnt_plc", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setPorCnty(JSPUtil.getParameter(request, prefix + "por_cnty", ""));
		setCurrPage(JSPUtil.getParameter(request, prefix + "curr_page", ""));
		setFrtCltFlg(JSPUtil.getParameter(request, prefix + "frt_clt_flg", ""));
		setPreVvd(JSPUtil.getParameter(request, prefix + "pre_vvd", ""));
		setRnum(JSPUtil.getParameter(request, prefix + "rnum", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setActCustName(JSPUtil.getParameter(request, prefix + "act_cust_name", ""));
		setWblSndDtFax(JSPUtil.getParameter(request, prefix + "wbl_snd_dt_fax", ""));
		setDelDt(JSPUtil.getParameter(request, prefix + "del_dt", ""));
		setCndCstmsFileCd(JSPUtil.getParameter(request, prefix + "cnd_cstms_file_cd", ""));
		setDelState(JSPUtil.getParameter(request, prefix + "del_state", ""));
		setIbdTrspIssDt(JSPUtil.getParameter(request, prefix + "ibd_trsp_iss_dt", ""));
		setOanMaxActDt2(JSPUtil.getParameter(request, prefix + "oan_max_act_dt2", ""));
		setCustRefNo(JSPUtil.getParameter(request, prefix + "cust_ref_no", ""));
		setPod1EtaDt(JSPUtil.getParameter(request, prefix + "pod1_eta_dt", ""));
		setPreRlyPortCd(JSPUtil.getParameter(request, prefix + "pre_rly_port_cd", ""));
		setPreVslNm(JSPUtil.getParameter(request, prefix + "pre_vsl_nm", ""));
		setAtaT(JSPUtil.getParameter(request, prefix + "ata_t", ""));
		setFPodEtd(JSPUtil.getParameter(request, prefix + "f_pod_etd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setOblRdemFlg(JSPUtil.getParameter(request, prefix + "obl_rdem_flg", ""));
		setFPodEta(JSPUtil.getParameter(request, prefix + "f_pod_eta", ""));
		setUrnMaxActDt(JSPUtil.getParameter(request, prefix + "urn_max_act_dt", ""));
		setSpcCgo(JSPUtil.getParameter(request, prefix + "spc_cgo", ""));
		setPorNm(JSPUtil.getParameter(request, prefix + "por_nm", ""));
		setPpdOfc(JSPUtil.getParameter(request, prefix + "ppd_ofc", ""));
		setNtfyName(JSPUtil.getParameter(request, prefix + "ntfy_name", ""));
		setPod1EtdDt(JSPUtil.getParameter(request, prefix + "pod1_etd_dt", ""));
		setBlIssOfc(JSPUtil.getParameter(request, prefix + "bl_iss_ofc", ""));
		setBlObrdDt(JSPUtil.getParameter(request, prefix + "bl_obrd_dt", ""));
		setCustBkgRefNo(JSPUtil.getParameter(request, prefix + "cust_bkg_ref_no", ""));
		setCntrVolQty(JSPUtil.getParameter(request, prefix + "cntr_vol_qty", ""));
		setInitPolEtaDt(JSPUtil.getParameter(request, prefix + "init_pol_eta_dt", ""));
		setPstRlyPortCd(JSPUtil.getParameter(request, prefix + "pst_rly_port_cd", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setShprName(JSPUtil.getParameter(request, prefix + "shpr_name", ""));
		setDelFtEndDt(JSPUtil.getParameter(request, prefix + "del_ft_end_dt", ""));
		setFrdCustCd(JSPUtil.getParameter(request, prefix + "frd_cust_cd", ""));
		setFirmsCode(JSPUtil.getParameter(request, prefix + "firms_code", ""));
		setAtdT(JSPUtil.getParameter(request, prefix + "atd_t", ""));
		setAta(JSPUtil.getParameter(request, prefix + "ata", ""));
		setBdrFlg(JSPUtil.getParameter(request, prefix + "bdr_flg", ""));
		setTrunkVvd(JSPUtil.getParameter(request, prefix + "trunk_vvd", ""));
		setVgmWgt(JSPUtil.getParameter(request, prefix + "vgm_wgt", ""));
		setDysLstMvmt(JSPUtil.getParameter(request, prefix + "dys_lst_mvmt", ""));
		setMkDesc(JSPUtil.getParameter(request, prefix + "mk_desc", ""));
		setGCustShpr(JSPUtil.getParameter(request, prefix + "g_cust_shpr", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setPolEtd(JSPUtil.getParameter(request, prefix + "pol_etd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPorGateInDt(JSPUtil.getParameter(request, prefix + "por_gate_in_dt", ""));
		setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
		setExportRefNo(JSPUtil.getParameter(request, prefix + "export_ref_no", ""));
		setCstmsDesc(JSPUtil.getParameter(request, prefix + "cstms_desc", ""));
		setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setDMaxActDt(JSPUtil.getParameter(request, prefix + "d_max_act_dt", ""));
		setAtd(JSPUtil.getParameter(request, prefix + "atd", ""));
		setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
		setInitPodEtaDt(JSPUtil.getParameter(request, prefix + "init_pod_eta_dt", ""));
		setPol1EtdDt(JSPUtil.getParameter(request, prefix + "pol1_etd_dt", ""));
		setCntrPoNo(JSPUtil.getParameter(request, prefix + "cntr_po_no", ""));
		setWebPrt(JSPUtil.getParameter(request, prefix + "web_prt", ""));
		setCstmsClrCd(JSPUtil.getParameter(request, prefix + "cstms_clr_cd", ""));
		setCgoStsCd(JSPUtil.getParameter(request, prefix + "cgo_sts_cd", ""));
		setCntrOcDate(JSPUtil.getParameter(request, prefix + "cntr_oc_date", ""));
		setEqCtrlOfc(JSPUtil.getParameter(request, prefix + "eq_ctrl_ofc", ""));
		setUsaCstmsFileCd(JSPUtil.getParameter(request, prefix + "usa_cstms_file_cd", ""));
		setActWgt(JSPUtil.getParameter(request, prefix + "act_wgt", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setRepCmdt(JSPUtil.getParameter(request, prefix + "rep_cmdt", ""));
		setCneeCode(JSPUtil.getParameter(request, prefix + "cnee_code", ""));
		setCntrSize(JSPUtil.getParameter(request, prefix + "cntr_size", ""));
		setCneeName(JSPUtil.getParameter(request, prefix + "cnee_name", ""));
		setAvalDt(JSPUtil.getParameter(request, prefix + "aval_dt", ""));
		setScac(JSPUtil.getParameter(request, prefix + "scac", ""));
		setShprCode(JSPUtil.getParameter(request, prefix + "shpr_code", ""));
		setCustInvNo(JSPUtil.getParameter(request, prefix + "cust_inv_no", ""));
		setPpdCharge(JSPUtil.getParameter(request, prefix + "ppd_charge", ""));
		setPostVslNm(JSPUtil.getParameter(request, prefix + "post_vsl_nm", ""));
		setCntrSealNo(JSPUtil.getParameter(request, prefix + "cntr_seal_no", ""));
		setPodEtb(JSPUtil.getParameter(request, prefix + "pod_etb", ""));
		setTotMeas(JSPUtil.getParameter(request, prefix + "tot_meas", ""));
		setHubLocCd(JSPUtil.getParameter(request, prefix + "hub_loc_cd", ""));
		setPodEta(JSPUtil.getParameter(request, prefix + "pod_eta", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustVipReportOutVO[]
	 */
	public CustVipReportOutVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustVipReportOutVO[]
	 */
	public CustVipReportOutVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustVipReportOutVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] delAta = (JSPUtil.getParameter(request, prefix	+ "del_ata", length));
			String[] vgmWgtUtCd = (JSPUtil.getParameter(request, prefix	+ "vgm_wgt_ut_cd", length));
			String[] preVvdNm = (JSPUtil.getParameter(request, prefix	+ "pre_vvd_nm", length));
			String[] actCustCode = (JSPUtil.getParameter(request, prefix	+ "act_cust_code", length));
			String[] ntfyCode = (JSPUtil.getParameter(request, prefix	+ "ntfy_code", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] dchgTsPortDt = (JSPUtil.getParameter(request, prefix	+ "dchg_ts_port_dt", length));
			String[] oblIssDt = (JSPUtil.getParameter(request, prefix	+ "obl_iss_dt", length));
			String[] uvdMaxActDt2 = (JSPUtil.getParameter(request, prefix	+ "uvd_max_act_dt2", length));
			String[] uvdMaxActDt = (JSPUtil.getParameter(request, prefix	+ "uvd_max_act_dt", length));
			String[] dblSndDtFax = (JSPUtil.getParameter(request, prefix	+ "dbl_snd_dt_fax", length));
			String[] cgoRcvDt = (JSPUtil.getParameter(request, prefix	+ "cgo_rcv_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] deptNo = (JSPUtil.getParameter(request, prefix	+ "dept_no", length));
			String[] delCnty = (JSPUtil.getParameter(request, prefix	+ "del_cnty", length));
			String[] rowsPerPage = (JSPUtil.getParameter(request, prefix	+ "rows_per_page", length));
			String[] chgAmt = (JSPUtil.getParameter(request, prefix	+ "chg_amt", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] cntrWgtUtCd = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt_ut_cd", length));
			String[] cntrMeasUtCd = (JSPUtil.getParameter(request, prefix	+ "cntr_meas_ut_cd", length));
			String[] anSendDt = (JSPUtil.getParameter(request, prefix	+ "an_send_dt", length));
			String[] frdCustNm = (JSPUtil.getParameter(request, prefix	+ "frd_cust_nm", length));
			String[] itNo = (JSPUtil.getParameter(request, prefix	+ "it_no", length));
			String[] totalCnt = (JSPUtil.getParameter(request, prefix	+ "total_cnt", length));
			String[] shipId = (JSPUtil.getParameter(request, prefix	+ "ship_id", length));
			String[] cntrPckTpCd = (JSPUtil.getParameter(request, prefix	+ "cntr_pck_tp_cd", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] cntrPrtFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_prt_flg", length));
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] rlnMaxActDt = (JSPUtil.getParameter(request, prefix	+ "rln_max_act_dt", length));
			String[] destSvcModCd = (JSPUtil.getParameter(request, prefix	+ "dest_svc_mod_cd", length));
			String[] finalDestNm = (JSPUtil.getParameter(request, prefix	+ "final_dest_nm", length));
			String[] prtNo = (JSPUtil.getParameter(request, prefix	+ "prt_no", length));
			String[] mtReturnDt = (JSPUtil.getParameter(request, prefix	+ "mt_return_dt", length));
			String[] dspoCd = (JSPUtil.getParameter(request, prefix	+ "dspo_cd", length));
			String[] stsNm = (JSPUtil.getParameter(request, prefix	+ "sts_nm", length));
			String[] caItno = (JSPUtil.getParameter(request, prefix	+ "ca_itno", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] dblSndDtEdi = (JSPUtil.getParameter(request, prefix	+ "dbl_snd_dt_edi", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] tPodEta = (JSPUtil.getParameter(request, prefix	+ "t_pod_eta", length));
			String[] bkgRctSndDtFax = (JSPUtil.getParameter(request, prefix	+ "bkg_rct_snd_dt_fax", length));
			String[] cnrrRefNo = (JSPUtil.getParameter(request, prefix	+ "cnrr_ref_no", length));
			String[] pol1EtaDt = (JSPUtil.getParameter(request, prefix	+ "pol1_eta_dt", length));
			String[] pkupNo = (JSPUtil.getParameter(request, prefix	+ "pkup_no", length));
			String[] tPodEtd = (JSPUtil.getParameter(request, prefix	+ "t_pod_etd", length));
			String[] laneCd = (JSPUtil.getParameter(request, prefix	+ "lane_cd", length));
			String[] podFtEndDt = (JSPUtil.getParameter(request, prefix	+ "pod_ft_end_dt", length));
			String[] fPolEta = (JSPUtil.getParameter(request, prefix	+ "f_pol_eta", length));
			String[] bkgRctSndDtEdi = (JSPUtil.getParameter(request, prefix	+ "bkg_rct_snd_dt_edi", length));
			String[] fPolEtd = (JSPUtil.getParameter(request, prefix	+ "f_pol_etd", length));
			String[] evntDtTm = (JSPUtil.getParameter(request, prefix	+ "evnt_dt_tm", length));
			String[] cctCharge = (JSPUtil.getParameter(request, prefix	+ "cct_charge", length));
			String[] trunkVessel = (JSPUtil.getParameter(request, prefix	+ "trunk_vessel", length));
			String[] initPolEtdDt = (JSPUtil.getParameter(request, prefix	+ "init_pol_etd_dt", length));
			String[] pkupNodCd = (JSPUtil.getParameter(request, prefix	+ "pkup_nod_cd", length));
			String[] scacCd = (JSPUtil.getParameter(request, prefix	+ "scac_cd", length));
			String[] itemPoNo = (JSPUtil.getParameter(request, prefix	+ "item_po_no", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] overdue = (JSPUtil.getParameter(request, prefix	+ "overdue", length));
			String[] postVvdNm = (JSPUtil.getParameter(request, prefix	+ "post_vvd_nm", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			String[] dueDate = (JSPUtil.getParameter(request, prefix	+ "due_date", length));
			String[] gCustCnee = (JSPUtil.getParameter(request, prefix	+ "g_cust_cnee", length));
			String[] ntfyAddr = (JSPUtil.getParameter(request, prefix	+ "ntfy_addr", length));
			String[] postVvd = (JSPUtil.getParameter(request, prefix	+ "post_vvd", length));
			String[] rmk = (JSPUtil.getParameter(request, prefix	+ "rmk", length));
			String[] tPolEta = (JSPUtil.getParameter(request, prefix	+ "t_pol_eta", length));
			String[] podNm = (JSPUtil.getParameter(request, prefix	+ "pod_nm", length));
			String[] vgmMzdTpCd = (JSPUtil.getParameter(request, prefix	+ "vgm_mzd_tp_cd", length));
			String[] delNm = (JSPUtil.getParameter(request, prefix	+ "del_nm", length));
			String[] tPolEtd = (JSPUtil.getParameter(request, prefix	+ "t_pol_etd", length));
			String[] loadId = (JSPUtil.getParameter(request, prefix	+ "load_id", length));
			String[] pctQty = (JSPUtil.getParameter(request, prefix	+ "pct_qty", length));
			String[] oanMaxActDt = (JSPUtil.getParameter(request, prefix	+ "oan_max_act_dt", length));
			String[] blPoNo = (JSPUtil.getParameter(request, prefix	+ "bl_po_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] customsRlsDt = (JSPUtil.getParameter(request, prefix	+ "customs_rls_dt", length));
			String[] podAtaticDt = (JSPUtil.getParameter(request, prefix	+ "pod_atatic_dt", length));
			String[] vgmVrfySigCtnt = (JSPUtil.getParameter(request, prefix	+ "vgm_vrfy_sig_ctnt", length));
			String[] custSiRefNo = (JSPUtil.getParameter(request, prefix	+ "cust_si_ref_no", length));
			String[] delEtaDt = (JSPUtil.getParameter(request, prefix	+ "del_eta_dt", length));
			String[] cctOfc = (JSPUtil.getParameter(request, prefix	+ "cct_ofc", length));
			String[] polNm = (JSPUtil.getParameter(request, prefix	+ "pol_nm", length));
			String[] freeDt = (JSPUtil.getParameter(request, prefix	+ "free_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] evntPlc = (JSPUtil.getParameter(request, prefix	+ "evnt_plc", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] porCnty = (JSPUtil.getParameter(request, prefix	+ "por_cnty", length));
			String[] currPage = (JSPUtil.getParameter(request, prefix	+ "curr_page", length));
			String[] frtCltFlg = (JSPUtil.getParameter(request, prefix	+ "frt_clt_flg", length));
			String[] preVvd = (JSPUtil.getParameter(request, prefix	+ "pre_vvd", length));
			String[] rnum = (JSPUtil.getParameter(request, prefix	+ "rnum", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] actCustName = (JSPUtil.getParameter(request, prefix	+ "act_cust_name", length));
			String[] wblSndDtFax = (JSPUtil.getParameter(request, prefix	+ "wbl_snd_dt_fax", length));
			String[] delDt = (JSPUtil.getParameter(request, prefix	+ "del_dt", length));
			String[] cndCstmsFileCd = (JSPUtil.getParameter(request, prefix	+ "cnd_cstms_file_cd", length));
			String[] delState = (JSPUtil.getParameter(request, prefix	+ "del_state", length));
			String[] ibdTrspIssDt = (JSPUtil.getParameter(request, prefix	+ "ibd_trsp_iss_dt", length));
			String[] oanMaxActDt2 = (JSPUtil.getParameter(request, prefix	+ "oan_max_act_dt2", length));
			String[] custRefNo = (JSPUtil.getParameter(request, prefix	+ "cust_ref_no", length));
			String[] pod1EtaDt = (JSPUtil.getParameter(request, prefix	+ "pod1_eta_dt", length));
			String[] preRlyPortCd = (JSPUtil.getParameter(request, prefix	+ "pre_rly_port_cd", length));
			String[] preVslNm = (JSPUtil.getParameter(request, prefix	+ "pre_vsl_nm", length));
			String[] ataT = (JSPUtil.getParameter(request, prefix	+ "ata_t", length));
			String[] fPodEtd = (JSPUtil.getParameter(request, prefix	+ "f_pod_etd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] oblRdemFlg = (JSPUtil.getParameter(request, prefix	+ "obl_rdem_flg", length));
			String[] fPodEta = (JSPUtil.getParameter(request, prefix	+ "f_pod_eta", length));
			String[] urnMaxActDt = (JSPUtil.getParameter(request, prefix	+ "urn_max_act_dt", length));
			String[] spcCgo = (JSPUtil.getParameter(request, prefix	+ "spc_cgo", length));
			String[] porNm = (JSPUtil.getParameter(request, prefix	+ "por_nm", length));
			String[] ppdOfc = (JSPUtil.getParameter(request, prefix	+ "ppd_ofc", length));
			String[] ntfyName = (JSPUtil.getParameter(request, prefix	+ "ntfy_name", length));
			String[] pod1EtdDt = (JSPUtil.getParameter(request, prefix	+ "pod1_etd_dt", length));
			String[] blIssOfc = (JSPUtil.getParameter(request, prefix	+ "bl_iss_ofc", length));
			String[] blObrdDt = (JSPUtil.getParameter(request, prefix	+ "bl_obrd_dt", length));
			String[] custBkgRefNo = (JSPUtil.getParameter(request, prefix	+ "cust_bkg_ref_no", length));
			String[] cntrVolQty = (JSPUtil.getParameter(request, prefix	+ "cntr_vol_qty", length));
			String[] initPolEtaDt = (JSPUtil.getParameter(request, prefix	+ "init_pol_eta_dt", length));
			String[] pstRlyPortCd = (JSPUtil.getParameter(request, prefix	+ "pst_rly_port_cd", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] shprName = (JSPUtil.getParameter(request, prefix	+ "shpr_name", length));
			String[] delFtEndDt = (JSPUtil.getParameter(request, prefix	+ "del_ft_end_dt", length));
			String[] frdCustCd = (JSPUtil.getParameter(request, prefix	+ "frd_cust_cd", length));
			String[] firmsCode = (JSPUtil.getParameter(request, prefix	+ "firms_code", length));
			String[] atdT = (JSPUtil.getParameter(request, prefix	+ "atd_t", length));
			String[] ata = (JSPUtil.getParameter(request, prefix	+ "ata", length));
			String[] bdrFlg = (JSPUtil.getParameter(request, prefix	+ "bdr_flg", length));
			String[] trunkVvd = (JSPUtil.getParameter(request, prefix	+ "trunk_vvd", length));
			String[] vgmWgt = (JSPUtil.getParameter(request, prefix	+ "vgm_wgt", length));
			String[] dysLstMvmt = (JSPUtil.getParameter(request, prefix	+ "dys_lst_mvmt", length));
			String[] mkDesc = (JSPUtil.getParameter(request, prefix	+ "mk_desc", length));
			String[] gCustShpr = (JSPUtil.getParameter(request, prefix	+ "g_cust_shpr", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] polEtd = (JSPUtil.getParameter(request, prefix	+ "pol_etd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] porGateInDt = (JSPUtil.getParameter(request, prefix	+ "por_gate_in_dt", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] exportRefNo = (JSPUtil.getParameter(request, prefix	+ "export_ref_no", length));
			String[] cstmsDesc = (JSPUtil.getParameter(request, prefix	+ "cstms_desc", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] dMaxActDt = (JSPUtil.getParameter(request, prefix	+ "d_max_act_dt", length));
			String[] atd = (JSPUtil.getParameter(request, prefix	+ "atd", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] initPodEtaDt = (JSPUtil.getParameter(request, prefix	+ "init_pod_eta_dt", length));
			String[] pol1EtdDt = (JSPUtil.getParameter(request, prefix	+ "pol1_etd_dt", length));
			String[] cntrPoNo = (JSPUtil.getParameter(request, prefix	+ "cntr_po_no", length));
			String[] webPrt = (JSPUtil.getParameter(request, prefix	+ "web_prt", length));
			String[] cstmsClrCd = (JSPUtil.getParameter(request, prefix	+ "cstms_clr_cd", length));
			String[] cgoStsCd = (JSPUtil.getParameter(request, prefix	+ "cgo_sts_cd", length));
			String[] cntrOcDate = (JSPUtil.getParameter(request, prefix	+ "cntr_oc_date", length));
			String[] eqCtrlOfc = (JSPUtil.getParameter(request, prefix	+ "eq_ctrl_ofc", length));
			String[] usaCstmsFileCd = (JSPUtil.getParameter(request, prefix	+ "usa_cstms_file_cd", length));
			String[] actWgt = (JSPUtil.getParameter(request, prefix	+ "act_wgt", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] repCmdt = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt", length));
			String[] cneeCode = (JSPUtil.getParameter(request, prefix	+ "cnee_code", length));
			String[] cntrSize = (JSPUtil.getParameter(request, prefix	+ "cntr_size", length));
			String[] cneeName = (JSPUtil.getParameter(request, prefix	+ "cnee_name", length));
			String[] avalDt = (JSPUtil.getParameter(request, prefix	+ "aval_dt", length));
			String[] scac = (JSPUtil.getParameter(request, prefix	+ "scac", length));
			String[] shprCode = (JSPUtil.getParameter(request, prefix	+ "shpr_code", length));
			String[] custInvNo = (JSPUtil.getParameter(request, prefix	+ "cust_inv_no", length));
			String[] ppdCharge = (JSPUtil.getParameter(request, prefix	+ "ppd_charge", length));
			String[] postVslNm = (JSPUtil.getParameter(request, prefix	+ "post_vsl_nm", length));
			String[] cntrSealNo = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no", length));
			String[] podEtb = (JSPUtil.getParameter(request, prefix	+ "pod_etb", length));
			String[] totMeas = (JSPUtil.getParameter(request, prefix	+ "tot_meas", length));
			String[] hubLocCd = (JSPUtil.getParameter(request, prefix	+ "hub_loc_cd", length));
			String[] podEta = (JSPUtil.getParameter(request, prefix	+ "pod_eta", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustVipReportOutVO();
				if (delAta[i] != null)
					model.setDelAta(delAta[i]);
				if (vgmWgtUtCd[i] != null)
					model.setVgmWgtUtCd(vgmWgtUtCd[i]);
				if (preVvdNm[i] != null)
					model.setPreVvdNm(preVvdNm[i]);
				if (actCustCode[i] != null)
					model.setActCustCode(actCustCode[i]);
				if (ntfyCode[i] != null)
					model.setNtfyCode(ntfyCode[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (dchgTsPortDt[i] != null)
					model.setDchgTsPortDt(dchgTsPortDt[i]);
				if (oblIssDt[i] != null)
					model.setOblIssDt(oblIssDt[i]);
				if (uvdMaxActDt2[i] != null)
					model.setUvdMaxActDt2(uvdMaxActDt2[i]);
				if (uvdMaxActDt[i] != null)
					model.setUvdMaxActDt(uvdMaxActDt[i]);
				if (dblSndDtFax[i] != null)
					model.setDblSndDtFax(dblSndDtFax[i]);
				if (cgoRcvDt[i] != null)
					model.setCgoRcvDt(cgoRcvDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (deptNo[i] != null)
					model.setDeptNo(deptNo[i]);
				if (delCnty[i] != null)
					model.setDelCnty(delCnty[i]);
				if (rowsPerPage[i] != null)
					model.setRowsPerPage(rowsPerPage[i]);
				if (chgAmt[i] != null)
					model.setChgAmt(chgAmt[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (cntrWgtUtCd[i] != null)
					model.setCntrWgtUtCd(cntrWgtUtCd[i]);
				if (cntrMeasUtCd[i] != null)
					model.setCntrMeasUtCd(cntrMeasUtCd[i]);
				if (anSendDt[i] != null)
					model.setAnSendDt(anSendDt[i]);
				if (frdCustNm[i] != null)
					model.setFrdCustNm(frdCustNm[i]);
				if (itNo[i] != null)
					model.setItNo(itNo[i]);
				if (totalCnt[i] != null)
					model.setTotalCnt(totalCnt[i]);
				if (shipId[i] != null)
					model.setShipId(shipId[i]);
				if (cntrPckTpCd[i] != null)
					model.setCntrPckTpCd(cntrPckTpCd[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (cntrPrtFlg[i] != null)
					model.setCntrPrtFlg(cntrPrtFlg[i]);
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (rlnMaxActDt[i] != null)
					model.setRlnMaxActDt(rlnMaxActDt[i]);
				if (destSvcModCd[i] != null)
					model.setDestSvcModCd(destSvcModCd[i]);
				if (finalDestNm[i] != null)
					model.setFinalDestNm(finalDestNm[i]);
				if (prtNo[i] != null)
					model.setPrtNo(prtNo[i]);
				if (mtReturnDt[i] != null)
					model.setMtReturnDt(mtReturnDt[i]);
				if (dspoCd[i] != null)
					model.setDspoCd(dspoCd[i]);
				if (stsNm[i] != null)
					model.setStsNm(stsNm[i]);
				if (caItno[i] != null)
					model.setCaItno(caItno[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (dblSndDtEdi[i] != null)
					model.setDblSndDtEdi(dblSndDtEdi[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (tPodEta[i] != null)
					model.setTPodEta(tPodEta[i]);
				if (bkgRctSndDtFax[i] != null)
					model.setBkgRctSndDtFax(bkgRctSndDtFax[i]);
				if (cnrrRefNo[i] != null)
					model.setCnrrRefNo(cnrrRefNo[i]);
				if (pol1EtaDt[i] != null)
					model.setPol1EtaDt(pol1EtaDt[i]);
				if (pkupNo[i] != null)
					model.setPkupNo(pkupNo[i]);
				if (tPodEtd[i] != null)
					model.setTPodEtd(tPodEtd[i]);
				if (laneCd[i] != null)
					model.setLaneCd(laneCd[i]);
				if (podFtEndDt[i] != null)
					model.setPodFtEndDt(podFtEndDt[i]);
				if (fPolEta[i] != null)
					model.setFPolEta(fPolEta[i]);
				if (bkgRctSndDtEdi[i] != null)
					model.setBkgRctSndDtEdi(bkgRctSndDtEdi[i]);
				if (fPolEtd[i] != null)
					model.setFPolEtd(fPolEtd[i]);
				if (evntDtTm[i] != null)
					model.setEvntDtTm(evntDtTm[i]);
				if (cctCharge[i] != null)
					model.setCctCharge(cctCharge[i]);
				if (trunkVessel[i] != null)
					model.setTrunkVessel(trunkVessel[i]);
				if (initPolEtdDt[i] != null)
					model.setInitPolEtdDt(initPolEtdDt[i]);
				if (pkupNodCd[i] != null)
					model.setPkupNodCd(pkupNodCd[i]);
				if (scacCd[i] != null)
					model.setScacCd(scacCd[i]);
				if (itemPoNo[i] != null)
					model.setItemPoNo(itemPoNo[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (overdue[i] != null)
					model.setOverdue(overdue[i]);
				if (postVvdNm[i] != null)
					model.setPostVvdNm(postVvdNm[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (measUtCd[i] != null)
					model.setMeasUtCd(measUtCd[i]);
				if (dueDate[i] != null)
					model.setDueDate(dueDate[i]);
				if (gCustCnee[i] != null)
					model.setGCustCnee(gCustCnee[i]);
				if (ntfyAddr[i] != null)
					model.setNtfyAddr(ntfyAddr[i]);
				if (postVvd[i] != null)
					model.setPostVvd(postVvd[i]);
				if (rmk[i] != null)
					model.setRmk(rmk[i]);
				if (tPolEta[i] != null)
					model.setTPolEta(tPolEta[i]);
				if (podNm[i] != null)
					model.setPodNm(podNm[i]);
				if (vgmMzdTpCd[i] != null)
					model.setVgmMzdTpCd(vgmMzdTpCd[i]);
				if (delNm[i] != null)
					model.setDelNm(delNm[i]);
				if (tPolEtd[i] != null)
					model.setTPolEtd(tPolEtd[i]);
				if (loadId[i] != null)
					model.setLoadId(loadId[i]);
				if (pctQty[i] != null)
					model.setPctQty(pctQty[i]);
				if (oanMaxActDt[i] != null)
					model.setOanMaxActDt(oanMaxActDt[i]);
				if (blPoNo[i] != null)
					model.setBlPoNo(blPoNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (customsRlsDt[i] != null)
					model.setCustomsRlsDt(customsRlsDt[i]);
				if (podAtaticDt[i] != null)
					model.setPodAtaticDt(podAtaticDt[i]);
				if (vgmVrfySigCtnt[i] != null)
					model.setVgmVrfySigCtnt(vgmVrfySigCtnt[i]);
				if (custSiRefNo[i] != null)
					model.setCustSiRefNo(custSiRefNo[i]);
				if (delEtaDt[i] != null)
					model.setDelEtaDt(delEtaDt[i]);
				if (cctOfc[i] != null)
					model.setCctOfc(cctOfc[i]);
				if (polNm[i] != null)
					model.setPolNm(polNm[i]);
				if (freeDt[i] != null)
					model.setFreeDt(freeDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (evntPlc[i] != null)
					model.setEvntPlc(evntPlc[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (porCnty[i] != null)
					model.setPorCnty(porCnty[i]);
				if (currPage[i] != null)
					model.setCurrPage(currPage[i]);
				if (frtCltFlg[i] != null)
					model.setFrtCltFlg(frtCltFlg[i]);
				if (preVvd[i] != null)
					model.setPreVvd(preVvd[i]);
				if (rnum[i] != null)
					model.setRnum(rnum[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (actCustName[i] != null)
					model.setActCustName(actCustName[i]);
				if (wblSndDtFax[i] != null)
					model.setWblSndDtFax(wblSndDtFax[i]);
				if (delDt[i] != null)
					model.setDelDt(delDt[i]);
				if (cndCstmsFileCd[i] != null)
					model.setCndCstmsFileCd(cndCstmsFileCd[i]);
				if (delState[i] != null)
					model.setDelState(delState[i]);
				if (ibdTrspIssDt[i] != null)
					model.setIbdTrspIssDt(ibdTrspIssDt[i]);
				if (oanMaxActDt2[i] != null)
					model.setOanMaxActDt2(oanMaxActDt2[i]);
				if (custRefNo[i] != null)
					model.setCustRefNo(custRefNo[i]);
				if (pod1EtaDt[i] != null)
					model.setPod1EtaDt(pod1EtaDt[i]);
				if (preRlyPortCd[i] != null)
					model.setPreRlyPortCd(preRlyPortCd[i]);
				if (preVslNm[i] != null)
					model.setPreVslNm(preVslNm[i]);
				if (ataT[i] != null)
					model.setAtaT(ataT[i]);
				if (fPodEtd[i] != null)
					model.setFPodEtd(fPodEtd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (oblRdemFlg[i] != null)
					model.setOblRdemFlg(oblRdemFlg[i]);
				if (fPodEta[i] != null)
					model.setFPodEta(fPodEta[i]);
				if (urnMaxActDt[i] != null)
					model.setUrnMaxActDt(urnMaxActDt[i]);
				if (spcCgo[i] != null)
					model.setSpcCgo(spcCgo[i]);
				if (porNm[i] != null)
					model.setPorNm(porNm[i]);
				if (ppdOfc[i] != null)
					model.setPpdOfc(ppdOfc[i]);
				if (ntfyName[i] != null)
					model.setNtfyName(ntfyName[i]);
				if (pod1EtdDt[i] != null)
					model.setPod1EtdDt(pod1EtdDt[i]);
				if (blIssOfc[i] != null)
					model.setBlIssOfc(blIssOfc[i]);
				if (blObrdDt[i] != null)
					model.setBlObrdDt(blObrdDt[i]);
				if (custBkgRefNo[i] != null)
					model.setCustBkgRefNo(custBkgRefNo[i]);
				if (cntrVolQty[i] != null)
					model.setCntrVolQty(cntrVolQty[i]);
				if (initPolEtaDt[i] != null)
					model.setInitPolEtaDt(initPolEtaDt[i]);
				if (pstRlyPortCd[i] != null)
					model.setPstRlyPortCd(pstRlyPortCd[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (shprName[i] != null)
					model.setShprName(shprName[i]);
				if (delFtEndDt[i] != null)
					model.setDelFtEndDt(delFtEndDt[i]);
				if (frdCustCd[i] != null)
					model.setFrdCustCd(frdCustCd[i]);
				if (firmsCode[i] != null)
					model.setFirmsCode(firmsCode[i]);
				if (atdT[i] != null)
					model.setAtdT(atdT[i]);
				if (ata[i] != null)
					model.setAta(ata[i]);
				if (bdrFlg[i] != null)
					model.setBdrFlg(bdrFlg[i]);
				if (trunkVvd[i] != null)
					model.setTrunkVvd(trunkVvd[i]);
				if (vgmWgt[i] != null)
					model.setVgmWgt(vgmWgt[i]);
				if (dysLstMvmt[i] != null)
					model.setDysLstMvmt(dysLstMvmt[i]);
				if (mkDesc[i] != null)
					model.setMkDesc(mkDesc[i]);
				if (gCustShpr[i] != null)
					model.setGCustShpr(gCustShpr[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (polEtd[i] != null)
					model.setPolEtd(polEtd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (porGateInDt[i] != null)
					model.setPorGateInDt(porGateInDt[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (exportRefNo[i] != null)
					model.setExportRefNo(exportRefNo[i]);
				if (cstmsDesc[i] != null)
					model.setCstmsDesc(cstmsDesc[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (dMaxActDt[i] != null)
					model.setDMaxActDt(dMaxActDt[i]);
				if (atd[i] != null)
					model.setAtd(atd[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (initPodEtaDt[i] != null)
					model.setInitPodEtaDt(initPodEtaDt[i]);
				if (pol1EtdDt[i] != null)
					model.setPol1EtdDt(pol1EtdDt[i]);
				if (cntrPoNo[i] != null)
					model.setCntrPoNo(cntrPoNo[i]);
				if (webPrt[i] != null)
					model.setWebPrt(webPrt[i]);
				if (cstmsClrCd[i] != null)
					model.setCstmsClrCd(cstmsClrCd[i]);
				if (cgoStsCd[i] != null)
					model.setCgoStsCd(cgoStsCd[i]);
				if (cntrOcDate[i] != null)
					model.setCntrOcDate(cntrOcDate[i]);
				if (eqCtrlOfc[i] != null)
					model.setEqCtrlOfc(eqCtrlOfc[i]);
				if (usaCstmsFileCd[i] != null)
					model.setUsaCstmsFileCd(usaCstmsFileCd[i]);
				if (actWgt[i] != null)
					model.setActWgt(actWgt[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (repCmdt[i] != null)
					model.setRepCmdt(repCmdt[i]);
				if (cneeCode[i] != null)
					model.setCneeCode(cneeCode[i]);
				if (cntrSize[i] != null)
					model.setCntrSize(cntrSize[i]);
				if (cneeName[i] != null)
					model.setCneeName(cneeName[i]);
				if (avalDt[i] != null)
					model.setAvalDt(avalDt[i]);
				if (scac[i] != null)
					model.setScac(scac[i]);
				if (shprCode[i] != null)
					model.setShprCode(shprCode[i]);
				if (custInvNo[i] != null)
					model.setCustInvNo(custInvNo[i]);
				if (ppdCharge[i] != null)
					model.setPpdCharge(ppdCharge[i]);
				if (postVslNm[i] != null)
					model.setPostVslNm(postVslNm[i]);
				if (cntrSealNo[i] != null)
					model.setCntrSealNo(cntrSealNo[i]);
				if (podEtb[i] != null)
					model.setPodEtb(podEtb[i]);
				if (totMeas[i] != null)
					model.setTotMeas(totMeas[i]);
				if (hubLocCd[i] != null)
					model.setHubLocCd(hubLocCd[i]);
				if (podEta[i] != null)
					model.setPodEta(podEta[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustVipReportOutVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustVipReportOutVO[]
	 */
	public CustVipReportOutVO[] getCustVipReportOutVOs(){
		CustVipReportOutVO[] vos = (CustVipReportOutVO[])models.toArray(new CustVipReportOutVO[models.size()]);
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
		this.delAta = this.delAta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgtUtCd = this.vgmWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preVvdNm = this.preVvdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCode = this.actCustCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyCode = this.ntfyCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dchgTsPortDt = this.dchgTsPortDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssDt = this.oblIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uvdMaxActDt2 = this.uvdMaxActDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uvdMaxActDt = this.uvdMaxActDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dblSndDtFax = this.dblSndDtFax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoRcvDt = this.cgoRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deptNo = this.deptNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCnty = this.delCnty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowsPerPage = this.rowsPerPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt = this.chgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgtUtCd = this.cntrWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMeasUtCd = this.cntrMeasUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anSendDt = this.anSendDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frdCustNm = this.frdCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itNo = this.itNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalCnt = this.totalCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipId = this.shipId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPckTpCd = this.cntrPckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPrtFlg = this.cntrPrtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlnMaxActDt = this.rlnMaxActDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destSvcModCd = this.destSvcModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.finalDestNm = this.finalDestNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prtNo = this.prtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtReturnDt = this.mtReturnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dspoCd = this.dspoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsNm = this.stsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caItno = this.caItno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dblSndDtEdi = this.dblSndDtEdi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tPodEta = this.tPodEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRctSndDtFax = this.bkgRctSndDtFax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnrrRefNo = this.cnrrRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol1EtaDt = this.pol1EtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupNo = this.pkupNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tPodEtd = this.tPodEtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneCd = this.laneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podFtEndDt = this.podFtEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fPolEta = this.fPolEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRctSndDtEdi = this.bkgRctSndDtEdi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fPolEtd = this.fPolEtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDtTm = this.evntDtTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctCharge = this.cctCharge .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkVessel = this.trunkVessel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initPolEtdDt = this.initPolEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupNodCd = this.pkupNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scacCd = this.scacCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itemPoNo = this.itemPoNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overdue = this.overdue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.postVvdNm = this.postVvdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDate = this.dueDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gCustCnee = this.gCustCnee .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyAddr = this.ntfyAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.postVvd = this.postVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rmk = this.rmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tPolEta = this.tPolEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podNm = this.podNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmMzdTpCd = this.vgmMzdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delNm = this.delNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tPolEtd = this.tPolEtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loadId = this.loadId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctQty = this.pctQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oanMaxActDt = this.oanMaxActDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blPoNo = this.blPoNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customsRlsDt = this.customsRlsDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podAtaticDt = this.podAtaticDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmVrfySigCtnt = this.vgmVrfySigCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSiRefNo = this.custSiRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delEtaDt = this.delEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctOfc = this.cctOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polNm = this.polNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.freeDt = this.freeDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntPlc = this.evntPlc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCnty = this.porCnty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currPage = this.currPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtCltFlg = this.frtCltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preVvd = this.preVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rnum = this.rnum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustName = this.actCustName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wblSndDtFax = this.wblSndDtFax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delDt = this.delDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cndCstmsFileCd = this.cndCstmsFileCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delState = this.delState .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdTrspIssDt = this.ibdTrspIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oanMaxActDt2 = this.oanMaxActDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRefNo = this.custRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod1EtaDt = this.pod1EtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preRlyPortCd = this.preRlyPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preVslNm = this.preVslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ataT = this.ataT .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fPodEtd = this.fPodEtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRdemFlg = this.oblRdemFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fPodEta = this.fPodEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.urnMaxActDt = this.urnMaxActDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spcCgo = this.spcCgo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porNm = this.porNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdOfc = this.ppdOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyName = this.ntfyName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod1EtdDt = this.pod1EtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blIssOfc = this.blIssOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blObrdDt = this.blObrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custBkgRefNo = this.custBkgRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVolQty = this.cntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initPolEtaDt = this.initPolEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pstRlyPortCd = this.pstRlyPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprName = this.shprName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delFtEndDt = this.delFtEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frdCustCd = this.frdCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.firmsCode = this.firmsCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atdT = this.atdT .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ata = this.ata .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrFlg = this.bdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkVvd = this.trunkVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgt = this.vgmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dysLstMvmt = this.dysLstMvmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mkDesc = this.mkDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gCustShpr = this.gCustShpr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polEtd = this.polEtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porGateInDt = this.porGateInDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exportRefNo = this.exportRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDesc = this.cstmsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dMaxActDt = this.dMaxActDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atd = this.atd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initPodEtaDt = this.initPodEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol1EtdDt = this.pol1EtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPoNo = this.cntrPoNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.webPrt = this.webPrt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsClrCd = this.cstmsClrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoStsCd = this.cgoStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrOcDate = this.cntrOcDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCtrlOfc = this.eqCtrlOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaCstmsFileCd = this.usaCstmsFileCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWgt = this.actWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdt = this.repCmdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeCode = this.cneeCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSize = this.cntrSize .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeName = this.cneeName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avalDt = this.avalDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scac = this.scac .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCode = this.shprCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custInvNo = this.custInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdCharge = this.ppdCharge .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.postVslNm = this.postVslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo = this.cntrSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podEtb = this.podEtb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totMeas = this.totMeas .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hubLocCd = this.hubLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podEta = this.podEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
