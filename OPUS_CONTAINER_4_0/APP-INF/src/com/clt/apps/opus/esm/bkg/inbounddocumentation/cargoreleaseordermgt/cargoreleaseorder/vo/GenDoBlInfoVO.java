/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GenDoBlInfoVO.java
*@FileTitle : GenDoBlInfoVO
*Open Issues : General D/O를 처리하기 위한 미니 슈퍼 VO
*              (DoBlInfoVO + DoRefVO + BlIssVO + OtsRcvInfoVO 를 통합한다.)
*Change history :
*@LastModifyDate : 2010.02.08
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.08 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

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
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class GenDoBlInfoVO extends AbstractValueObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8646723684722153105L;

	private Collection<GenDoBlInfoVO> models = new ArrayList<GenDoBlInfoVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String splitFlg = null;
	/* Column Info */
	private String dschLoc = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String measUtCd = null;
	/* Column Info */
	private String oblIssRmk = null;
	/* Column Info */
	private String ccustAddr = null;
	/* Column Info */
	private String cntrPrtFlg = null;
	/* Column Info */
	private String ncustAddr = null;
	/* Column Info */
	private String scustAddr = null;
	/* Column Info */
	private String repCmdtNm = null;
	/* Column Info */
	private String callSgnNo = null;
	/* Column Info */
	private String scustNm = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String blTpCd = null;		// BlIssVO의 blTpCd와 중복
	/* Column Info */
	private String ncustNm = null;
	/* Column Info */
	private String actWgt = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String socFlg = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String arrivalVessel = null;
	/* Column Info */
	private String deTermDesc = null;
	/* Column Info */
	private String ccustNm = null;

	private String lcloblissueflg = null;
	
	/* DoRefVO 관련 항목(2010.02.08) Start */
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String cyOpCd = null;
	/* Column Info */
	private String doSplitFlg = null;
	/* Column Info */
	private String idaImpGenMfNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String infoCgoFlg = null;
	/* Column Info */
	private String idaCstmsAsgnLineNo = null;
	/* Column Info */
	private String doHldFlg = null;
	/* Column Info */
	private String cstmsRefNm = null;
	/* Column Info */
	private String idaCgorOrdYr = null;
	/* Column Info */
	private String cstmsAsgnCtnt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String interRmk = null;
	/* Column Info */
	private String cstmsRefCtnt = null;
	/* Column Info */
	private String cstmsAsgnNm = null;
	/* Column Info */
	private String updUsrId = null;
	/* DoRefVO 관련 항목(2010.02.08) End */
	

	/* BlIssVO 관련 항목(2010.02.08) Start */
	/* Column Info */
	private String oblIssDt = null;
	/* Column Info */
	private String ibdDocRcvOfcCd = null;
	/* Column Info */
	private String oblIssTpCd = null;
	/* Column Info */
	private String otrDocRcvOfcCd = null;
	/* Column Info */
	private String otrDocRcvUsrId = null;
	/* Column Info */
	private String otrDocCgorFlg = null;
	/* Column Info */
	private String oblRdemDt = null;
	/* Column Info */
	private String oblIssUsrId = null;
	/* Column Info */
	private String oblCpyKnt = null;
	/* Column Info */
	private String ibdDocRcvUsrId = null;
	/* Column Info */
	private String ibdDocRcvDt = null;
	/* Column Info */
	private String blOtrDocRcvCd = null;
	/* Column Info */
	private String oblIssOfcCd = null;
	/* Column Info */
	private String delCntCd = null;
	/* Column Info */
	private String oblRdemFlg = null;
	/* Column Info */
	private String oblIssKnt = null;
	/* Column Info */
	private String ibdDocRcvFlg = null;
	/* Column Info */
	private String otrDocRcvDt = null;
	/* Column Info */
	private String oblRdemKnt = null;
	/* Column Info */
	private String oblRdemUsrId = null;
	/* Column Info */
	private String oblTtlKnt = null;
	/* Column Info */
	private String oblRdemUpdUsrId = null;
	/* Column Info */
	private String oblRdemOfcCd = null;
	
	
	/* OtsRcvInfoVO 관련 항목(2010.02.08) */
	/* Column Info */
	private String pptRcvOfcCd = null;
	/* Column Info */
	private String cctOtsCurrCd3 = null;
	/* Column Info */
	private String cctOtsCurrCd4 = null;
	/* Column Info */
	private String cctOtsCurrCd1 = null;
	/* Column Info */
	private String cctOtsCurrCd2 = null;
	/* Column Info */
	private String n3ptyCctRcvDt = null;
	/* Column Info */
	private String cctOtsCurrCd5 = null;
	/* Column Info */
	private String cctRcvOfcCd = null;
	/* Column Info */
	private String n3ptyPptOtsCurrCd3 = null;
	/* Column Info */
	private String n3ptyPptOtsCurrCd4 = null;
	/* Column Info */
	private String n3ptyPptOtsCurrCd1 = null;
	/* Column Info */
	private String n3ptyPptOtsCurrCd2 = null;
	/* Column Info */
	private String cctRcvDt = null;
	/* Column Info */
	private String n3ptyCctRcvOfcCd = null;
	/* Column Info */
	private String n3ptyPptOtsCurrCd5 = null;
	/* Column Info */
	private String totOtsCurrCd1 = null;
	/* Column Info */
	private String totOtsCurrCd2 = null;
	/* Column Info */
	private String totOtsCurrCd3 = null;
	/* Column Info */
	private String totOtsCurrCd4 = null;
	/* Column Info */
	private String totOtsCurrCd5 = null;
	/* Column Info */
	private String n3ptyPptRcvDt = null;
	/* Column Info */
	private String n3ptyPptRcvUsrId = null;
	/* Column Info */
	private String n3ptyCctOtsAmt4 = null;
	/* Column Info */
	private String n3ptyCctOtsAmt5 = null;
	/* Column Info */
	private String pptRcvUsrId = null;
	/* Column Info */
	private String n3ptyCctOtsAmt2 = null;
	/* Column Info */
	private String n3ptyCctOtsAmt3 = null;
	/* Column Info */
	private String n3ptyCctStsCd = null;
	/* Column Info */
	private String n3ptyCctOtsAmt1 = null;
	/* Column Info */
	private String pptStsCd = null;
	/* Column Info */
	private String totOtsStsCd = null;
	/* Column Info */
	private String pptRcvDt = null;
	/* Column Info */
	private String pptOtsCurrCd5 = null;
	/* Column Info */
	private String eaiResult = null;
	/* Column Info */
	private String totOtsAmt1 = null;
	/* Column Info */
	private String totOtsAmt2 = null;
	/* Column Info */
	private String pptOtsCurrCd3 = null;
	/* Column Info */
	private String n3ptyPptOtsAmt5 = null;
	/* Column Info */
	private String pptOtsCurrCd4 = null;
	/* Column Info */
	private String n3ptyPptOtsAmt4 = null;
	/* Column Info */
	private String pptOtsAmt1 = null;
	/* Column Info */
	private String pptOtsCurrCd1 = null;
	/* Column Info */
	private String n3ptyPptOtsAmt3 = null;
	/* Column Info */
	private String pptOtsCurrCd2 = null;
	/* Column Info */
	private String n3ptyPptOtsAmt2 = null;
	/* Column Info */
	private String pptOtsAmt3 = null;
	/* Column Info */
	private String n3ptyPptOtsAmt1 = null;
	/* Column Info */
	private String pptOtsAmt2 = null;
	/* Column Info */
	private String pptOtsAmt5 = null;
	/* Column Info */
	private String pptOtsAmt4 = null;
	/* Column Info */
	private String cctStsCd = null;
	/* Column Info */
	private String n3ptyPptRcvOfcCd = null;
	/* Column Info */
	private String n3ptyCctOtsCurrCd5 = null;
	/* Column Info */
	private String cctOtsAmt5 = null;
	/* Column Info */
	private String n3ptyCctOtsCurrCd2 = null;
	/* Column Info */
	private String totOtsAmt5 = null;
	/* Column Info */
	private String cctOtsAmt4 = null;
	/* Column Info */
	private String n3ptyCctOtsCurrCd1 = null;
	/* Column Info */
	private String totOtsAmt4 = null;
	/* Column Info */
	private String cctOtsAmt3 = null;
	/* Column Info */
	private String n3ptyCctOtsCurrCd4 = null;
	/* Column Info */
	private String totOtsAmt3 = null;
	/* Column Info */
	private String cctOtsAmt2 = null;
	/* Column Info */
	private String n3ptyCctOtsCurrCd3 = null;
	/* Column Info */
	private String cctOtsAmt1 = null;
	/* Column Info */
	private String cctRcvUsrId = null;
	/* Column Info */
	private String n3ptyCctRcvUsrId = null;
	/* Column Info */
	private String n3ptyPptStsCd = null;
	
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public GenDoBlInfoVO() {}

	public GenDoBlInfoVO(String ibflag, String pagerows, String bkgNo, String blNo, String porCd, String polCd, String podCd, String delCd, String deTermCd, String deTermDesc, String arrivalVessel, String vpsEtaDt, String pckQty, String pckTpCd, String actWgt, String wgtUtCd, String measQty, String measUtCd, String socFlg, String splitFlg, String repCmdtNm, String dschLoc, String cntrPrtFlg, String ccustNm, String ccustAddr, String ncustNm, String ncustAddr, String scustNm, String scustAddr, String callSgnNo, String blTpCd, String oblIssRmk, String lcloblissueflg, 
			             String cstmsRefNm, String cstmsRefCtnt, String cstmsAsgnNm, String cstmsAsgnCtnt, String idaImpGenMfNo, String idaCgorOrdYr, String idaCstmsAsgnLineNo, String interRmk, String doHldFlg, String doSplitFlg, String cyOpCd, String infoCgoFlg, String creUsrId, String creDt, String updUsrId, String updDt,
			             String oblIssDt, String oblIssOfcCd, String oblIssUsrId, String oblIssTpCd, String oblIssKnt, String oblRdemOfcCd, String oblRdemUsrId, String oblRdemUpdUsrId, String oblRdemDt, String oblRdemKnt, String otrDocCgorFlg, String blOtrDocRcvCd, String otrDocRcvOfcCd, String otrDocRcvUsrId, String otrDocRcvDt, String ibdDocRcvFlg, String ibdDocRcvOfcCd, String ibdDocRcvUsrId, String ibdDocRcvDt, String oblTtlKnt, String oblCpyKnt, String delCntCd, String oblRdemFlg,
			             String totOtsStsCd, String eaiResult, String totOtsCurrCd1, String totOtsCurrCd2, String totOtsCurrCd3, String totOtsCurrCd4, String totOtsCurrCd5, String totOtsAmt1, String totOtsAmt2, String totOtsAmt3, String totOtsAmt4, String totOtsAmt5, String pptStsCd, String pptRcvOfcCd, String pptRcvUsrId, String pptRcvDt, String cctStsCd, String cctRcvOfcCd, String cctRcvUsrId, String cctRcvDt, String cctOtsCurrCd1, String cctOtsCurrCd2, String cctOtsCurrCd3, String cctOtsCurrCd4, String cctOtsCurrCd5, String cctOtsAmt1, String cctOtsAmt2, String cctOtsAmt3, String cctOtsAmt4, String cctOtsAmt5, String n3ptyPptStsCd, String n3ptyPptRcvOfcCd, String n3ptyPptRcvUsrId, String n3ptyPptRcvDt, String n3ptyCctStsCd, String n3ptyCctRcvOfcCd, String n3ptyCctRcvUsrId, String n3ptyCctRcvDt, String n3ptyCctOtsCurrCd1, String n3ptyCctOtsCurrCd2, String n3ptyCctOtsCurrCd3, String n3ptyCctOtsCurrCd4, String n3ptyCctOtsCurrCd5, String n3ptyCctOtsAmt1, String n3ptyCctOtsAmt2, String n3ptyCctOtsAmt3, String n3ptyCctOtsAmt4, String n3ptyCctOtsAmt5, String n3ptyPptOtsCurrCd1, String n3ptyPptOtsCurrCd2, String n3ptyPptOtsCurrCd3, String n3ptyPptOtsCurrCd4, String n3ptyPptOtsCurrCd5, String n3ptyPptOtsAmt1, String n3ptyPptOtsAmt2, String n3ptyPptOtsAmt3, String n3ptyPptOtsAmt4, String n3ptyPptOtsAmt5, String pptOtsCurrCd1, String pptOtsCurrCd2, String pptOtsCurrCd3, String pptOtsCurrCd4, String pptOtsCurrCd5, String pptOtsAmt1, String pptOtsAmt2, String pptOtsAmt3, String pptOtsAmt4, String pptOtsAmt5) {
		this.porCd = porCd;
		this.splitFlg = splitFlg;
		this.dschLoc = dschLoc;
		this.vpsEtaDt = vpsEtaDt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.wgtUtCd = wgtUtCd;
		this.measQty = measQty;
		this.pckQty = pckQty;
		this.pckTpCd = pckTpCd;
		this.measUtCd = measUtCd;
		this.oblIssRmk = oblIssRmk;
		this.ccustAddr = ccustAddr;
		this.cntrPrtFlg = cntrPrtFlg;
		this.ncustAddr = ncustAddr;
		this.scustAddr = scustAddr;
		this.repCmdtNm = repCmdtNm;
		this.callSgnNo = callSgnNo;
		this.scustNm = scustNm;
		this.delCd = delCd;
		this.blTpCd = blTpCd;
		this.ncustNm = ncustNm;
		this.actWgt = actWgt;
		this.podCd = podCd;
		this.socFlg = socFlg;
		this.deTermCd = deTermCd;
		this.bkgNo = bkgNo;
		this.arrivalVessel = arrivalVessel;
		this.deTermDesc = deTermDesc;
		this.ccustNm = ccustNm;
		this.lcloblissueflg = lcloblissueflg;
		

		this.updDt = updDt;
		this.cyOpCd = cyOpCd;
		this.doSplitFlg = doSplitFlg;
		this.idaImpGenMfNo = idaImpGenMfNo;
		this.creDt = creDt;
		this.infoCgoFlg = infoCgoFlg;
		this.idaCstmsAsgnLineNo = idaCstmsAsgnLineNo;
		this.doHldFlg = doHldFlg;
		this.cstmsRefNm = cstmsRefNm;
		this.idaCgorOrdYr = idaCgorOrdYr;
		this.cstmsAsgnCtnt = cstmsAsgnCtnt;
		this.creUsrId = creUsrId;
		this.interRmk = interRmk;
		this.cstmsRefCtnt = cstmsRefCtnt;
		this.cstmsAsgnNm = cstmsAsgnNm;
		this.updUsrId = updUsrId;
		
		
		this.oblIssDt = oblIssDt;
		this.ibdDocRcvOfcCd = ibdDocRcvOfcCd;
		this.oblIssTpCd = oblIssTpCd;
		this.otrDocRcvOfcCd = otrDocRcvOfcCd;
		this.otrDocRcvUsrId = otrDocRcvUsrId;
		this.otrDocCgorFlg = otrDocCgorFlg;
		this.oblRdemDt = oblRdemDt;
		this.oblIssUsrId = oblIssUsrId;
		this.oblCpyKnt = oblCpyKnt;
		this.ibdDocRcvUsrId = ibdDocRcvUsrId;
		this.ibdDocRcvDt = ibdDocRcvDt;
		this.blOtrDocRcvCd = blOtrDocRcvCd;
		this.oblIssOfcCd = oblIssOfcCd;
		this.delCntCd = delCntCd;
		this.oblRdemFlg = oblRdemFlg;
		this.oblIssKnt = oblIssKnt;
		this.ibdDocRcvFlg = ibdDocRcvFlg;
		this.otrDocRcvDt = otrDocRcvDt;
		this.oblRdemKnt = oblRdemKnt;
		this.oblRdemUsrId = oblRdemUsrId;
		this.oblTtlKnt = oblTtlKnt;
		this.oblRdemUpdUsrId = oblRdemUpdUsrId;
		this.oblRdemOfcCd = oblRdemOfcCd;
		
		
		this.pptRcvOfcCd = pptRcvOfcCd;
		this.cctOtsCurrCd3 = cctOtsCurrCd3;
		this.cctOtsCurrCd4 = cctOtsCurrCd4;
		this.cctOtsCurrCd1 = cctOtsCurrCd1;
		this.cctOtsCurrCd2 = cctOtsCurrCd2;
		this.n3ptyCctRcvDt = n3ptyCctRcvDt;
		this.cctOtsCurrCd5 = cctOtsCurrCd5;
		this.cctRcvOfcCd = cctRcvOfcCd;
		this.n3ptyPptOtsCurrCd3 = n3ptyPptOtsCurrCd3;
		this.n3ptyPptOtsCurrCd4 = n3ptyPptOtsCurrCd4;
		this.n3ptyPptOtsCurrCd1 = n3ptyPptOtsCurrCd1;
		this.n3ptyPptOtsCurrCd2 = n3ptyPptOtsCurrCd2;
		this.cctRcvDt = cctRcvDt;
		this.n3ptyCctRcvOfcCd = n3ptyCctRcvOfcCd;
		this.n3ptyPptOtsCurrCd5 = n3ptyPptOtsCurrCd5;
		this.totOtsCurrCd1 = totOtsCurrCd1;
		this.totOtsCurrCd2 = totOtsCurrCd2;
		this.totOtsCurrCd3 = totOtsCurrCd3;
		this.totOtsCurrCd4 = totOtsCurrCd4;
		this.totOtsCurrCd5 = totOtsCurrCd5;
		this.n3ptyPptRcvDt = n3ptyPptRcvDt;
		this.n3ptyPptRcvUsrId = n3ptyPptRcvUsrId;
		this.n3ptyCctOtsAmt4 = n3ptyCctOtsAmt4;
		this.n3ptyCctOtsAmt5 = n3ptyCctOtsAmt5;
		this.pptRcvUsrId = pptRcvUsrId;
		this.n3ptyCctOtsAmt2 = n3ptyCctOtsAmt2;
		this.n3ptyCctOtsAmt3 = n3ptyCctOtsAmt3;
		this.n3ptyCctStsCd = n3ptyCctStsCd;
		this.n3ptyCctOtsAmt1 = n3ptyCctOtsAmt1;
		this.pptStsCd = pptStsCd;
		this.totOtsStsCd = totOtsStsCd;
		this.pptRcvDt = pptRcvDt;
		this.pptOtsCurrCd5 = pptOtsCurrCd5;
		this.eaiResult = eaiResult;
		this.totOtsAmt1 = totOtsAmt1;
		this.totOtsAmt2 = totOtsAmt2;
		this.pptOtsCurrCd3 = pptOtsCurrCd3;
		this.n3ptyPptOtsAmt5 = n3ptyPptOtsAmt5;
		this.pptOtsCurrCd4 = pptOtsCurrCd4;
		this.n3ptyPptOtsAmt4 = n3ptyPptOtsAmt4;
		this.pptOtsAmt1 = pptOtsAmt1;
		this.pptOtsCurrCd1 = pptOtsCurrCd1;
		this.n3ptyPptOtsAmt3 = n3ptyPptOtsAmt3;
		this.pptOtsCurrCd2 = pptOtsCurrCd2;
		this.n3ptyPptOtsAmt2 = n3ptyPptOtsAmt2;
		this.pptOtsAmt3 = pptOtsAmt3;
		this.n3ptyPptOtsAmt1 = n3ptyPptOtsAmt1;
		this.pptOtsAmt2 = pptOtsAmt2;
		this.pptOtsAmt5 = pptOtsAmt5;
		this.pptOtsAmt4 = pptOtsAmt4;
		this.cctStsCd = cctStsCd;
		this.n3ptyPptRcvOfcCd = n3ptyPptRcvOfcCd;
		this.n3ptyCctOtsCurrCd5 = n3ptyCctOtsCurrCd5;
		this.cctOtsAmt5 = cctOtsAmt5;
		this.n3ptyCctOtsCurrCd2 = n3ptyCctOtsCurrCd2;
		this.totOtsAmt5 = totOtsAmt5;
		this.cctOtsAmt4 = cctOtsAmt4;
		this.n3ptyCctOtsCurrCd1 = n3ptyCctOtsCurrCd1;
		this.totOtsAmt4 = totOtsAmt4;
		this.cctOtsAmt3 = cctOtsAmt3;
		this.n3ptyCctOtsCurrCd4 = n3ptyCctOtsCurrCd4;
		this.totOtsAmt3 = totOtsAmt3;
		this.cctOtsAmt2 = cctOtsAmt2;
		this.n3ptyCctOtsCurrCd3 = n3ptyCctOtsCurrCd3;
		this.cctOtsAmt1 = cctOtsAmt1;
		this.cctRcvUsrId = cctRcvUsrId;
		this.n3ptyCctRcvUsrId = n3ptyCctRcvUsrId;
		this.n3ptyPptStsCd = n3ptyPptStsCd;
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("split_flg", getSplitFlg());
		this.hashColumns.put("dsch_loc", getDschLoc());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		this.hashColumns.put("obl_iss_rmk", getOblIssRmk());
		this.hashColumns.put("ccust_addr", getCcustAddr());
		this.hashColumns.put("cntr_prt_flg", getCntrPrtFlg());
		this.hashColumns.put("ncust_addr", getNcustAddr());
		this.hashColumns.put("scust_addr", getScustAddr());
		this.hashColumns.put("rep_cmdt_nm", getRepCmdtNm());
		this.hashColumns.put("call_sgn_no", getCallSgnNo());
		this.hashColumns.put("scust_nm", getScustNm());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("bl_tp_cd", getBlTpCd());
		this.hashColumns.put("ncust_nm", getNcustNm());
		this.hashColumns.put("act_wgt", getActWgt());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("soc_flg", getSocFlg());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("arrival_vessel", getArrivalVessel());
		this.hashColumns.put("de_term_desc", getDeTermDesc());
		this.hashColumns.put("ccust_nm", getCcustNm());
		this.hashColumns.put("lcloblissueflg", getLcloblissueflg());
		
		
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cy_op_cd", getCyOpCd());
		this.hashColumns.put("do_split_flg", getDoSplitFlg());
		this.hashColumns.put("ida_imp_gen_mf_no", getIdaImpGenMfNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("info_cgo_flg", getInfoCgoFlg());
		this.hashColumns.put("ida_cstms_asgn_line_no", getIdaCstmsAsgnLineNo());
		this.hashColumns.put("do_hld_flg", getDoHldFlg());
		this.hashColumns.put("cstms_ref_nm", getCstmsRefNm());
		this.hashColumns.put("ida_cgor_ord_yr", getIdaCgorOrdYr());
		this.hashColumns.put("cstms_asgn_ctnt", getCstmsAsgnCtnt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("inter_rmk", getInterRmk());
		this.hashColumns.put("cstms_ref_ctnt", getCstmsRefCtnt());
		this.hashColumns.put("cstms_asgn_nm", getCstmsAsgnNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		
		
		this.hashColumns.put("obl_iss_dt", getOblIssDt());
		this.hashColumns.put("ibd_doc_rcv_ofc_cd", getIbdDocRcvOfcCd());
		this.hashColumns.put("obl_iss_tp_cd", getOblIssTpCd());
		this.hashColumns.put("otr_doc_rcv_ofc_cd", getOtrDocRcvOfcCd());
		this.hashColumns.put("otr_doc_rcv_usr_id", getOtrDocRcvUsrId());
		this.hashColumns.put("otr_doc_cgor_flg", getOtrDocCgorFlg());
		this.hashColumns.put("obl_rdem_dt", getOblRdemDt());
		this.hashColumns.put("obl_iss_usr_id", getOblIssUsrId());
		this.hashColumns.put("obl_cpy_knt", getOblCpyKnt());
		this.hashColumns.put("ibd_doc_rcv_usr_id", getIbdDocRcvUsrId());
		this.hashColumns.put("ibd_doc_rcv_dt", getIbdDocRcvDt());
		this.hashColumns.put("bl_otr_doc_rcv_cd", getBlOtrDocRcvCd());
		this.hashColumns.put("obl_iss_ofc_cd", getOblIssOfcCd());
		this.hashColumns.put("del_cnt_cd", getDelCntCd());
		this.hashColumns.put("obl_rdem_flg", getOblRdemFlg());
		this.hashColumns.put("obl_iss_knt", getOblIssKnt());
		this.hashColumns.put("ibd_doc_rcv_flg", getIbdDocRcvFlg());
		this.hashColumns.put("otr_doc_rcv_dt", getOtrDocRcvDt());
		this.hashColumns.put("obl_rdem_knt", getOblRdemKnt());
		this.hashColumns.put("obl_rdem_usr_id", getOblRdemUsrId());
		this.hashColumns.put("obl_ttl_knt", getOblTtlKnt());
		this.hashColumns.put("obl_rdem_upd_usr_id", getOblRdemUpdUsrId());
		this.hashColumns.put("obl_rdem_ofc_cd", getOblRdemOfcCd());
		
		
		this.hashColumns.put("ppt_rcv_ofc_cd", getPptRcvOfcCd());
		this.hashColumns.put("cct_ots_curr_cd3", getCctOtsCurrCd3());
		this.hashColumns.put("cct_ots_curr_cd4", getCctOtsCurrCd4());
		this.hashColumns.put("cct_ots_curr_cd1", getCctOtsCurrCd1());
		this.hashColumns.put("cct_ots_curr_cd2", getCctOtsCurrCd2());
		this.hashColumns.put("n3pty_cct_rcv_dt", getN3ptyCctRcvDt());
		this.hashColumns.put("cct_ots_curr_cd5", getCctOtsCurrCd5());
		this.hashColumns.put("cct_rcv_ofc_cd", getCctRcvOfcCd());
		this.hashColumns.put("n3pty_ppt_ots_curr_cd3", getN3ptyPptOtsCurrCd3());
		this.hashColumns.put("n3pty_ppt_ots_curr_cd4", getN3ptyPptOtsCurrCd4());
		this.hashColumns.put("n3pty_ppt_ots_curr_cd1", getN3ptyPptOtsCurrCd1());
		this.hashColumns.put("n3pty_ppt_ots_curr_cd2", getN3ptyPptOtsCurrCd2());
		this.hashColumns.put("cct_rcv_dt", getCctRcvDt());
		this.hashColumns.put("n3pty_cct_rcv_ofc_cd", getN3ptyCctRcvOfcCd());
		this.hashColumns.put("n3pty_ppt_ots_curr_cd5", getN3ptyPptOtsCurrCd5());
		this.hashColumns.put("tot_ots_curr_cd1", getTotOtsCurrCd1());
		this.hashColumns.put("tot_ots_curr_cd2", getTotOtsCurrCd2());
		this.hashColumns.put("tot_ots_curr_cd3", getTotOtsCurrCd3());
		this.hashColumns.put("tot_ots_curr_cd4", getTotOtsCurrCd4());
		this.hashColumns.put("tot_ots_curr_cd5", getTotOtsCurrCd5());
		this.hashColumns.put("n3pty_ppt_rcv_dt", getN3ptyPptRcvDt());
		this.hashColumns.put("n3pty_ppt_rcv_usr_id", getN3ptyPptRcvUsrId());
		this.hashColumns.put("n3pty_cct_ots_amt4", getN3ptyCctOtsAmt4());
		this.hashColumns.put("n3pty_cct_ots_amt5", getN3ptyCctOtsAmt5());
		this.hashColumns.put("ppt_rcv_usr_id", getPptRcvUsrId());
		this.hashColumns.put("n3pty_cct_ots_amt2", getN3ptyCctOtsAmt2());
		this.hashColumns.put("n3pty_cct_ots_amt3", getN3ptyCctOtsAmt3());
		this.hashColumns.put("n3pty_cct_sts_cd", getN3ptyCctStsCd());
		this.hashColumns.put("n3pty_cct_ots_amt1", getN3ptyCctOtsAmt1());
		this.hashColumns.put("ppt_sts_cd", getPptStsCd());
		this.hashColumns.put("tot_ots_sts_cd", getTotOtsStsCd());
		this.hashColumns.put("ppt_rcv_dt", getPptRcvDt());
		this.hashColumns.put("ppt_ots_curr_cd5", getPptOtsCurrCd5());
		this.hashColumns.put("eai_result", getEaiResult());
		this.hashColumns.put("tot_ots_amt1", getTotOtsAmt1());
		this.hashColumns.put("tot_ots_amt2", getTotOtsAmt2());
		this.hashColumns.put("ppt_ots_curr_cd3", getPptOtsCurrCd3());
		this.hashColumns.put("n3pty_ppt_ots_amt5", getN3ptyPptOtsAmt5());
		this.hashColumns.put("ppt_ots_curr_cd4", getPptOtsCurrCd4());
		this.hashColumns.put("n3pty_ppt_ots_amt4", getN3ptyPptOtsAmt4());
		this.hashColumns.put("ppt_ots_amt1", getPptOtsAmt1());
		this.hashColumns.put("ppt_ots_curr_cd1", getPptOtsCurrCd1());
		this.hashColumns.put("n3pty_ppt_ots_amt3", getN3ptyPptOtsAmt3());
		this.hashColumns.put("ppt_ots_curr_cd2", getPptOtsCurrCd2());
		this.hashColumns.put("n3pty_ppt_ots_amt2", getN3ptyPptOtsAmt2());
		this.hashColumns.put("ppt_ots_amt3", getPptOtsAmt3());
		this.hashColumns.put("n3pty_ppt_ots_amt1", getN3ptyPptOtsAmt1());
		this.hashColumns.put("ppt_ots_amt2", getPptOtsAmt2());
		this.hashColumns.put("ppt_ots_amt5", getPptOtsAmt5());
		this.hashColumns.put("ppt_ots_amt4", getPptOtsAmt4());
		this.hashColumns.put("cct_sts_cd", getCctStsCd());
		this.hashColumns.put("n3pty_ppt_rcv_ofc_cd", getN3ptyPptRcvOfcCd());
		this.hashColumns.put("n3pty_cct_ots_curr_cd5", getN3ptyCctOtsCurrCd5());
		this.hashColumns.put("cct_ots_amt5", getCctOtsAmt5());
		this.hashColumns.put("n3pty_cct_ots_curr_cd2", getN3ptyCctOtsCurrCd2());
		this.hashColumns.put("tot_ots_amt5", getTotOtsAmt5());
		this.hashColumns.put("cct_ots_amt4", getCctOtsAmt4());
		this.hashColumns.put("n3pty_cct_ots_curr_cd1", getN3ptyCctOtsCurrCd1());
		this.hashColumns.put("tot_ots_amt4", getTotOtsAmt4());
		this.hashColumns.put("cct_ots_amt3", getCctOtsAmt3());
		this.hashColumns.put("n3pty_cct_ots_curr_cd4", getN3ptyCctOtsCurrCd4());
		this.hashColumns.put("tot_ots_amt3", getTotOtsAmt3());
		this.hashColumns.put("cct_ots_amt2", getCctOtsAmt2());
		this.hashColumns.put("n3pty_cct_ots_curr_cd3", getN3ptyCctOtsCurrCd3());
		this.hashColumns.put("cct_ots_amt1", getCctOtsAmt1());
		this.hashColumns.put("cct_rcv_usr_id", getCctRcvUsrId());
		this.hashColumns.put("n3pty_cct_rcv_usr_id", getN3ptyCctRcvUsrId());
		this.hashColumns.put("n3pty_ppt_sts_cd", getN3ptyPptStsCd());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("split_flg", "splitFlg");
		this.hashFields.put("dsch_loc", "dschLoc");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("obl_iss_rmk", "oblIssRmk");
		this.hashFields.put("ccust_addr", "ccustAddr");
		this.hashFields.put("cntr_prt_flg", "cntrPrtFlg");
		this.hashFields.put("ncust_addr", "ncustAddr");
		this.hashFields.put("scust_addr", "scustAddr");
		this.hashFields.put("rep_cmdt_nm", "repCmdtNm");
		this.hashFields.put("call_sgn_no", "callSgnNo");
		this.hashFields.put("scust_nm", "scustNm");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("bl_tp_cd", "blTpCd");
		this.hashFields.put("ncust_nm", "ncustNm");
		this.hashFields.put("act_wgt", "actWgt");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("soc_flg", "socFlg");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("arrival_vessel", "arrivalVessel");
		this.hashFields.put("de_term_desc", "deTermDesc");
		this.hashFields.put("ccust_nm", "ccustNm");
		this.hashFields.put("lcloblissueflg", "lcloblissueflg");

		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cy_op_cd", "cyOpCd");
		this.hashFields.put("do_split_flg", "doSplitFlg");
		this.hashFields.put("ida_imp_gen_mf_no", "idaImpGenMfNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("info_cgo_flg", "infoCgoFlg");
		this.hashFields.put("ida_cstms_asgn_line_no", "idaCstmsAsgnLineNo");
		this.hashFields.put("do_hld_flg", "doHldFlg");
		this.hashFields.put("cstms_ref_nm", "cstmsRefNm");
		this.hashFields.put("ida_cgor_ord_yr", "idaCgorOrdYr");
		this.hashFields.put("cstms_asgn_ctnt", "cstmsAsgnCtnt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("inter_rmk", "interRmk");
		this.hashFields.put("cstms_ref_ctnt", "cstmsRefCtnt");
		this.hashFields.put("cstms_asgn_nm", "cstmsAsgnNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		
		
		this.hashFields.put("obl_iss_dt", "oblIssDt");
		this.hashFields.put("ibd_doc_rcv_ofc_cd", "ibdDocRcvOfcCd");
		this.hashFields.put("obl_iss_tp_cd", "oblIssTpCd");
		this.hashFields.put("otr_doc_rcv_ofc_cd", "otrDocRcvOfcCd");
		this.hashFields.put("otr_doc_rcv_usr_id", "otrDocRcvUsrId");
		this.hashFields.put("otr_doc_cgor_flg", "otrDocCgorFlg");
		this.hashFields.put("obl_rdem_dt", "oblRdemDt");
		this.hashFields.put("obl_iss_usr_id", "oblIssUsrId");
		this.hashFields.put("obl_cpy_knt", "oblCpyKnt");
		this.hashFields.put("ibd_doc_rcv_usr_id", "ibdDocRcvUsrId");
		this.hashFields.put("ibd_doc_rcv_dt", "ibdDocRcvDt");
		this.hashFields.put("bl_otr_doc_rcv_cd", "blOtrDocRcvCd");
		this.hashFields.put("obl_iss_ofc_cd", "oblIssOfcCd");
		this.hashFields.put("del_cnt_cd", "delCntCd");
		this.hashFields.put("obl_rdem_flg", "oblRdemFlg");
		this.hashFields.put("obl_iss_knt", "oblIssKnt");
		this.hashFields.put("ibd_doc_rcv_flg", "ibdDocRcvFlg");
		this.hashFields.put("otr_doc_rcv_dt", "otrDocRcvDt");
		this.hashFields.put("obl_rdem_knt", "oblRdemKnt");
		this.hashFields.put("obl_rdem_usr_id", "oblRdemUsrId");
		this.hashFields.put("obl_ttl_knt", "oblTtlKnt");
		this.hashFields.put("obl_rdem_upd_usr_id", "oblRdemUpdUsrId");
		this.hashFields.put("obl_rdem_ofc_cd", "oblRdemOfcCd");
		
		
		this.hashFields.put("ppt_rcv_ofc_cd", "pptRcvOfcCd");
		this.hashFields.put("cct_ots_curr_cd3", "cctOtsCurrCd3");
		this.hashFields.put("cct_ots_curr_cd4", "cctOtsCurrCd4");
		this.hashFields.put("cct_ots_curr_cd1", "cctOtsCurrCd1");
		this.hashFields.put("cct_ots_curr_cd2", "cctOtsCurrCd2");
		this.hashFields.put("n3pty_cct_rcv_dt", "n3ptyCctRcvDt");
		this.hashFields.put("cct_ots_curr_cd5", "cctOtsCurrCd5");
		this.hashFields.put("cct_rcv_ofc_cd", "cctRcvOfcCd");
		this.hashFields.put("n3pty_ppt_ots_curr_cd3", "n3ptyPptOtsCurrCd3");
		this.hashFields.put("n3pty_ppt_ots_curr_cd4", "n3ptyPptOtsCurrCd4");
		this.hashFields.put("n3pty_ppt_ots_curr_cd1", "n3ptyPptOtsCurrCd1");
		this.hashFields.put("n3pty_ppt_ots_curr_cd2", "n3ptyPptOtsCurrCd2");
		this.hashFields.put("cct_rcv_dt", "cctRcvDt");
		this.hashFields.put("n3pty_cct_rcv_ofc_cd", "n3ptyCctRcvOfcCd");
		this.hashFields.put("n3pty_ppt_ots_curr_cd5", "n3ptyPptOtsCurrCd5");
		this.hashFields.put("tot_ots_curr_cd1", "totOtsCurrCd1");
		this.hashFields.put("tot_ots_curr_cd2", "totOtsCurrCd2");
		this.hashFields.put("tot_ots_curr_cd3", "totOtsCurrCd3");
		this.hashFields.put("tot_ots_curr_cd4", "totOtsCurrCd4");
		this.hashFields.put("tot_ots_curr_cd5", "totOtsCurrCd5");
		this.hashFields.put("n3pty_ppt_rcv_dt", "n3ptyPptRcvDt");
		this.hashFields.put("n3pty_ppt_rcv_usr_id", "n3ptyPptRcvUsrId");
		this.hashFields.put("n3pty_cct_ots_amt4", "n3ptyCctOtsAmt4");
		this.hashFields.put("n3pty_cct_ots_amt5", "n3ptyCctOtsAmt5");
		this.hashFields.put("ppt_rcv_usr_id", "pptRcvUsrId");
		this.hashFields.put("n3pty_cct_ots_amt2", "n3ptyCctOtsAmt2");
		this.hashFields.put("n3pty_cct_ots_amt3", "n3ptyCctOtsAmt3");
		this.hashFields.put("n3pty_cct_sts_cd", "n3ptyCctStsCd");
		this.hashFields.put("n3pty_cct_ots_amt1", "n3ptyCctOtsAmt1");
		this.hashFields.put("ppt_sts_cd", "pptStsCd");
		this.hashFields.put("tot_ots_sts_cd", "totOtsStsCd");
		this.hashFields.put("ppt_rcv_dt", "pptRcvDt");
		this.hashFields.put("ppt_ots_curr_cd5", "pptOtsCurrCd5");
		this.hashFields.put("eai_result", "eaiResult");
		this.hashFields.put("tot_ots_amt1", "totOtsAmt1");
		this.hashFields.put("tot_ots_amt2", "totOtsAmt2");
		this.hashFields.put("ppt_ots_curr_cd3", "pptOtsCurrCd3");
		this.hashFields.put("n3pty_ppt_ots_amt5", "n3ptyPptOtsAmt5");
		this.hashFields.put("ppt_ots_curr_cd4", "pptOtsCurrCd4");
		this.hashFields.put("n3pty_ppt_ots_amt4", "n3ptyPptOtsAmt4");
		this.hashFields.put("ppt_ots_amt1", "pptOtsAmt1");
		this.hashFields.put("ppt_ots_curr_cd1", "pptOtsCurrCd1");
		this.hashFields.put("n3pty_ppt_ots_amt3", "n3ptyPptOtsAmt3");
		this.hashFields.put("ppt_ots_curr_cd2", "pptOtsCurrCd2");
		this.hashFields.put("n3pty_ppt_ots_amt2", "n3ptyPptOtsAmt2");
		this.hashFields.put("ppt_ots_amt3", "pptOtsAmt3");
		this.hashFields.put("n3pty_ppt_ots_amt1", "n3ptyPptOtsAmt1");
		this.hashFields.put("ppt_ots_amt2", "pptOtsAmt2");
		this.hashFields.put("ppt_ots_amt5", "pptOtsAmt5");
		this.hashFields.put("ppt_ots_amt4", "pptOtsAmt4");
		this.hashFields.put("cct_sts_cd", "cctStsCd");
		this.hashFields.put("n3pty_ppt_rcv_ofc_cd", "n3ptyPptRcvOfcCd");
		this.hashFields.put("n3pty_cct_ots_curr_cd5", "n3ptyCctOtsCurrCd5");
		this.hashFields.put("cct_ots_amt5", "cctOtsAmt5");
		this.hashFields.put("n3pty_cct_ots_curr_cd2", "n3ptyCctOtsCurrCd2");
		this.hashFields.put("tot_ots_amt5", "totOtsAmt5");
		this.hashFields.put("cct_ots_amt4", "cctOtsAmt4");
		this.hashFields.put("n3pty_cct_ots_curr_cd1", "n3ptyCctOtsCurrCd1");
		this.hashFields.put("tot_ots_amt4", "totOtsAmt4");
		this.hashFields.put("cct_ots_amt3", "cctOtsAmt3");
		this.hashFields.put("n3pty_cct_ots_curr_cd4", "n3ptyCctOtsCurrCd4");
		this.hashFields.put("tot_ots_amt3", "totOtsAmt3");
		this.hashFields.put("cct_ots_amt2", "cctOtsAmt2");
		this.hashFields.put("n3pty_cct_ots_curr_cd3", "n3ptyCctOtsCurrCd3");
		this.hashFields.put("cct_ots_amt1", "cctOtsAmt1");
		this.hashFields.put("cct_rcv_usr_id", "cctRcvUsrId");
		this.hashFields.put("n3pty_cct_rcv_usr_id", "n3ptyCctRcvUsrId");
		this.hashFields.put("n3pty_ppt_sts_cd", "n3ptyPptStsCd");
		
		return this.hashFields;
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
	 * @return splitFlg
	 */
	public String getSplitFlg() {
		return this.splitFlg;
	}
	
	/**
	 * Column Info
	 * @return dschLoc
	 */
	public String getDschLoc() {
		return this.dschLoc;
	}
	
	/**
	 * Column Info
	 * @return vpsEtaDt
	 */
	public String getVpsEtaDt() {
		return this.vpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
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
	 * @return oblIssRmk
	 */
	public String getOblIssRmk() {
		return this.oblIssRmk;
	}
	
	/**
	 * Column Info
	 * @return ccustAddr
	 */
	public String getCcustAddr() {
		return this.ccustAddr;
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
	 * @return ncustAddr
	 */
	public String getNcustAddr() {
		return this.ncustAddr;
	}
	
	/**
	 * Column Info
	 * @return scustAddr
	 */
	public String getScustAddr() {
		return this.scustAddr;
	}
	
	/**
	 * Column Info
	 * @return repCmdtNm
	 */
	public String getRepCmdtNm() {
		return this.repCmdtNm;
	}
	
	/**
	 * Column Info
	 * @return callSgnNo
	 */
	public String getCallSgnNo() {
		return this.callSgnNo;
	}
	
	/**
	 * Column Info
	 * @return scustNm
	 */
	public String getScustNm() {
		return this.scustNm;
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
	 * @return blTpCd
	 */
	public String getBlTpCd() {
		return this.blTpCd;
	}
	
	/**
	 * Column Info
	 * @return ncustNm
	 */
	public String getNcustNm() {
		return this.ncustNm;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return socFlg
	 */
	public String getSocFlg() {
		return this.socFlg;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return arrivalVessel
	 */
	public String getArrivalVessel() {
		return this.arrivalVessel;
	}
	
	/**
	 * Column Info
	 * @return deTermDesc
	 */
	public String getDeTermDesc() {
		return this.deTermDesc;
	}
	
	/**
	 * Column Info
	 * @return ccustNm
	 */
	public String getCcustNm() {
		return this.ccustNm;
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
	 * @param splitFlg
	 */
	public void setSplitFlg(String splitFlg) {
		this.splitFlg = splitFlg;
	}
	
	/**
	 * Column Info
	 * @param dschLoc
	 */
	public void setDschLoc(String dschLoc) {
		this.dschLoc = dschLoc;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaDt
	 */
	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
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
	 * @param oblIssRmk
	 */
	public void setOblIssRmk(String oblIssRmk) {
		this.oblIssRmk = oblIssRmk;
	}
	
	/**
	 * Column Info
	 * @param ccustAddr
	 */
	public void setCcustAddr(String ccustAddr) {
		this.ccustAddr = ccustAddr;
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
	 * @param ncustAddr
	 */
	public void setNcustAddr(String ncustAddr) {
		this.ncustAddr = ncustAddr;
	}
	
	/**
	 * Column Info
	 * @param scustAddr
	 */
	public void setScustAddr(String scustAddr) {
		this.scustAddr = scustAddr;
	}
	
	/**
	 * Column Info
	 * @param repCmdtNm
	 */
	public void setRepCmdtNm(String repCmdtNm) {
		this.repCmdtNm = repCmdtNm;
	}
	
	/**
	 * Column Info
	 * @param callSgnNo
	 */
	public void setCallSgnNo(String callSgnNo) {
		this.callSgnNo = callSgnNo;
	}
	
	/**
	 * Column Info
	 * @param scustNm
	 */
	public void setScustNm(String scustNm) {
		this.scustNm = scustNm;
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
	 * @param blTpCd
	 */
	public void setBlTpCd(String blTpCd) {
		this.blTpCd = blTpCd;
	}
	
	/**
	 * Column Info
	 * @param ncustNm
	 */
	public void setNcustNm(String ncustNm) {
		this.ncustNm = ncustNm;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param socFlg
	 */
	public void setSocFlg(String socFlg) {
		this.socFlg = socFlg;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param arrivalVessel
	 */
	public void setArrivalVessel(String arrivalVessel) {
		this.arrivalVessel = arrivalVessel;
	}
	
	/**
	 * Column Info
	 * @param deTermDesc
	 */
	public void setDeTermDesc(String deTermDesc) {
		this.deTermDesc = deTermDesc;
	}
	
	/**
	 * Column Info
	 * @param ccustNm
	 */
	public void setCcustNm(String ccustNm) {
		this.ccustNm = ccustNm;
	}
	
	/* DoRefVO 관련 항목(2010.02.08) */
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return cyOpCd
	 */
	public String getCyOpCd() {
		return this.cyOpCd;
	}
	
	/**
	 * Column Info
	 * @return doSplitFlg
	 */
	public String getDoSplitFlg() {
		return this.doSplitFlg;
	}
	
	/**
	 * Column Info
	 * @return idaImpGenMfNo
	 */
	public String getIdaImpGenMfNo() {
		return this.idaImpGenMfNo;
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
	 * @return infoCgoFlg
	 */
	public String getInfoCgoFlg() {
		return this.infoCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return idaCstmsAsgnLineNo
	 */
	public String getIdaCstmsAsgnLineNo() {
		return this.idaCstmsAsgnLineNo;
	}
	
	/**
	 * Column Info
	 * @return doHldFlg
	 */
	public String getDoHldFlg() {
		return this.doHldFlg;
	}
	
	/**
	 * Column Info
	 * @return cstmsRefNm
	 */
	public String getCstmsRefNm() {
		return this.cstmsRefNm;
	}
	
	/**
	 * Column Info
	 * @return idaCgorOrdYr
	 */
	public String getIdaCgorOrdYr() {
		return this.idaCgorOrdYr;
	}
	
	/**
	 * Column Info
	 * @return cstmsAsgnCtnt
	 */
	public String getCstmsAsgnCtnt() {
		return this.cstmsAsgnCtnt;
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
	 * @return interRmk
	 */
	public String getInterRmk() {
		return this.interRmk;
	}
	
	/**
	 * Column Info
	 * @return cstmsRefCtnt
	 */
	public String getCstmsRefCtnt() {
		return this.cstmsRefCtnt;
	}
	
	/**
	 * Column Info
	 * @return cstmsAsgnNm
	 */
	public String getCstmsAsgnNm() {
		return this.cstmsAsgnNm;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param cyOpCd
	 */
	public void setCyOpCd(String cyOpCd) {
		this.cyOpCd = cyOpCd;
	}
	
	/**
	 * Column Info
	 * @param doSplitFlg
	 */
	public void setDoSplitFlg(String doSplitFlg) {
		this.doSplitFlg = doSplitFlg;
	}
	
	/**
	 * Column Info
	 * @param idaImpGenMfNo
	 */
	public void setIdaImpGenMfNo(String idaImpGenMfNo) {
		this.idaImpGenMfNo = idaImpGenMfNo;
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
	 * @param infoCgoFlg
	 */
	public void setInfoCgoFlg(String infoCgoFlg) {
		this.infoCgoFlg = infoCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param idaCstmsAsgnLineNo
	 */
	public void setIdaCstmsAsgnLineNo(String idaCstmsAsgnLineNo) {
		this.idaCstmsAsgnLineNo = idaCstmsAsgnLineNo;
	}
	
	/**
	 * Column Info
	 * @param doHldFlg
	 */
	public void setDoHldFlg(String doHldFlg) {
		this.doHldFlg = doHldFlg;
	}
	
	/**
	 * Column Info
	 * @param cstmsRefNm
	 */
	public void setCstmsRefNm(String cstmsRefNm) {
		this.cstmsRefNm = cstmsRefNm;
	}
	
	/**
	 * Column Info
	 * @param idaCgorOrdYr
	 */
	public void setIdaCgorOrdYr(String idaCgorOrdYr) {
		this.idaCgorOrdYr = idaCgorOrdYr;
	}
	
	/**
	 * Column Info
	 * @param cstmsAsgnCtnt
	 */
	public void setCstmsAsgnCtnt(String cstmsAsgnCtnt) {
		this.cstmsAsgnCtnt = cstmsAsgnCtnt;
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
	 * @param interRmk
	 */
	public void setInterRmk(String interRmk) {
		this.interRmk = interRmk;
	}
	
	/**
	 * Column Info
	 * @param cstmsRefCtnt
	 */
	public void setCstmsRefCtnt(String cstmsRefCtnt) {
		this.cstmsRefCtnt = cstmsRefCtnt;
	}
	
	/**
	 * Column Info
	 * @param cstmsAsgnNm
	 */
	public void setCstmsAsgnNm(String cstmsAsgnNm) {
		this.cstmsAsgnNm = cstmsAsgnNm;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	
	/* BlIssVO 관련 항목(2010.02.08) */
	/**
	 * Column Info
	 * @return oblIssDt
	 */
	public String getOblIssDt() {
		return this.oblIssDt;
	}
	
	/**
	 * Column Info
	 * @return ibdDocRcvOfcCd
	 */
	public String getIbdDocRcvOfcCd() {
		return this.ibdDocRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @return oblIssTpCd
	 */
	public String getOblIssTpCd() {
		return this.oblIssTpCd;
	}
	
	/**
	 * Column Info
	 * @return otrDocRcvOfcCd
	 */
	public String getOtrDocRcvOfcCd() {
		return this.otrDocRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @return otrDocRcvUsrId
	 */
	public String getOtrDocRcvUsrId() {
		return this.otrDocRcvUsrId;
	}
	
	/**
	 * Column Info
	 * @return otrDocCgorFlg
	 */
	public String getOtrDocCgorFlg() {
		return this.otrDocCgorFlg;
	}
	
	/**
	 * Column Info
	 * @return oblRdemDt
	 */
	public String getOblRdemDt() {
		return this.oblRdemDt;
	}
	
	/**
	 * Column Info
	 * @return oblIssUsrId
	 */
	public String getOblIssUsrId() {
		return this.oblIssUsrId;
	}
	
	/**
	 * Column Info
	 * @return oblCpyKnt
	 */
	public String getOblCpyKnt() {
		return this.oblCpyKnt;
	}
	
	/**
	 * Column Info
	 * @return ibdDocRcvUsrId
	 */
	public String getIbdDocRcvUsrId() {
		return this.ibdDocRcvUsrId;
	}
	
	/**
	 * Column Info
	 * @return ibdDocRcvDt
	 */
	public String getIbdDocRcvDt() {
		return this.ibdDocRcvDt;
	}
	
	/**
	 * Column Info
	 * @return blOtrDocRcvCd
	 */
	public String getBlOtrDocRcvCd() {
		return this.blOtrDocRcvCd;
	}

	/**
	 * Column Info
	 * @return oblIssOfcCd
	 */
	public String getOblIssOfcCd() {
		return this.oblIssOfcCd;
	}
	
	/**
	 * Column Info
	 * @return delCntCd
	 */
	public String getDelCntCd() {
		return this.delCntCd;
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
	 * @return oblIssKnt
	 */
	public String getOblIssKnt() {
		return this.oblIssKnt;
	}
	
	/**
	 * Column Info
	 * @return ibdDocRcvFlg
	 */
	public String getIbdDocRcvFlg() {
		return this.ibdDocRcvFlg;
	}
	
	/**
	 * Column Info
	 * @return otrDocRcvDt
	 */
	public String getOtrDocRcvDt() {
		return this.otrDocRcvDt;
	}
	
	/**
	 * Column Info
	 * @return oblRdemKnt
	 */
	public String getOblRdemKnt() {
		return this.oblRdemKnt;
	}
	
	/**
	 * Column Info
	 * @return oblRdemUsrId
	 */
	public String getOblRdemUsrId() {
		return this.oblRdemUsrId;
	}
	
	/**
	 * Column Info
	 * @return oblTtlKnt
	 */
	public String getOblTtlKnt() {
		return this.oblTtlKnt;
	}
	
	/**
	 * Column Info
	 * @return oblRdemUpdUsrId
	 */
	public String getOblRdemUpdUsrId() {
		return this.oblRdemUpdUsrId;
	}
	
	/**
	 * Column Info
	 * @return oblRdemOfcCd
	 */
	public String getOblRdemOfcCd() {
		return this.oblRdemOfcCd;
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
	 * @param ibdDocRcvOfcCd
	 */
	public void setIbdDocRcvOfcCd(String ibdDocRcvOfcCd) {
		this.ibdDocRcvOfcCd = ibdDocRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @param oblIssTpCd
	 */
	public void setOblIssTpCd(String oblIssTpCd) {
		this.oblIssTpCd = oblIssTpCd;
	}
	
	/**
	 * Column Info
	 * @param otrDocRcvOfcCd
	 */
	public void setOtrDocRcvOfcCd(String otrDocRcvOfcCd) {
		this.otrDocRcvOfcCd = otrDocRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @param otrDocRcvUsrId
	 */
	public void setOtrDocRcvUsrId(String otrDocRcvUsrId) {
		this.otrDocRcvUsrId = otrDocRcvUsrId;
	}
	
	/**
	 * Column Info
	 * @param otrDocCgorFlg
	 */
	public void setOtrDocCgorFlg(String otrDocCgorFlg) {
		this.otrDocCgorFlg = otrDocCgorFlg;
	}
	
	/**
	 * Column Info
	 * @param oblRdemDt
	 */
	public void setOblRdemDt(String oblRdemDt) {
		this.oblRdemDt = oblRdemDt;
	}
	
	/**
	 * Column Info
	 * @param oblIssUsrId
	 */
	public void setOblIssUsrId(String oblIssUsrId) {
		this.oblIssUsrId = oblIssUsrId;
	}
	
	/**
	 * Column Info
	 * @param oblCpyKnt
	 */
	public void setOblCpyKnt(String oblCpyKnt) {
		this.oblCpyKnt = oblCpyKnt;
	}
	
	/**
	 * Column Info
	 * @param ibdDocRcvUsrId
	 */
	public void setIbdDocRcvUsrId(String ibdDocRcvUsrId) {
		this.ibdDocRcvUsrId = ibdDocRcvUsrId;
	}
	
	/**
	 * Column Info
	 * @param ibdDocRcvDt
	 */
	public void setIbdDocRcvDt(String ibdDocRcvDt) {
		this.ibdDocRcvDt = ibdDocRcvDt;
	}
	
	/**
	 * Column Info
	 * @param blOtrDocRcvCd
	 */
	public void setBlOtrDocRcvCd(String blOtrDocRcvCd) {
		this.blOtrDocRcvCd = blOtrDocRcvCd;
	}
	
	/**
	 * Column Info
	 * @param oblIssOfcCd
	 */
	public void setOblIssOfcCd(String oblIssOfcCd) {
		this.oblIssOfcCd = oblIssOfcCd;
	}
	
	/**
	 * Column Info
	 * @param delCntCd
	 */
	public void setDelCntCd(String delCntCd) {
		this.delCntCd = delCntCd;
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
	 * @param oblIssKnt
	 */
	public void setOblIssKnt(String oblIssKnt) {
		this.oblIssKnt = oblIssKnt;
	}
	
	/**
	 * Column Info
	 * @param ibdDocRcvFlg
	 */
	public void setIbdDocRcvFlg(String ibdDocRcvFlg) {
		this.ibdDocRcvFlg = ibdDocRcvFlg;
	}
	
	/**
	 * Column Info
	 * @param otrDocRcvDt
	 */
	public void setOtrDocRcvDt(String otrDocRcvDt) {
		this.otrDocRcvDt = otrDocRcvDt;
	}
	
	/**
	 * Column Info
	 * @param oblRdemKnt
	 */
	public void setOblRdemKnt(String oblRdemKnt) {
		this.oblRdemKnt = oblRdemKnt;
	}
	
	/**
	 * Column Info
	 * @param oblRdemUsrId
	 */
	public void setOblRdemUsrId(String oblRdemUsrId) {
		this.oblRdemUsrId = oblRdemUsrId;
	}
	
	/**
	 * Column Info
	 * @param oblTtlKnt
	 */
	public void setOblTtlKnt(String oblTtlKnt) {
		this.oblTtlKnt = oblTtlKnt;
	}
	
	/**
	 * Column Info
	 * @param oblRdemUpdUsrId
	 */
	public void setOblRdemUpdUsrId(String oblRdemUpdUsrId) {
		this.oblRdemUpdUsrId = oblRdemUpdUsrId;
	}
	
	/**
	 * Column Info
	 * @param oblRdemOfcCd
	 */
	public void setOblRdemOfcCd(String oblRdemOfcCd) {
		this.oblRdemOfcCd = oblRdemOfcCd;
	}
	
	/* OtsRcvInfoVO 관련 항목(2010.02.08) */
	/**
	 * Column Info
	 * @return pptRcvOfcCd
	 */
	public String getPptRcvOfcCd() {
		return this.pptRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @return cctOtsCurrCd3
	 */
	public String getCctOtsCurrCd3() {
		return this.cctOtsCurrCd3;
	}
	
	/**
	 * Column Info
	 * @return cctOtsCurrCd4
	 */
	public String getCctOtsCurrCd4() {
		return this.cctOtsCurrCd4;
	}
	
	/**
	 * Column Info
	 * @return cctOtsCurrCd1
	 */
	public String getCctOtsCurrCd1() {
		return this.cctOtsCurrCd1;
	}
	
	/**
	 * Column Info
	 * @return cctOtsCurrCd2
	 */
	public String getCctOtsCurrCd2() {
		return this.cctOtsCurrCd2;
	}
	
	/**
	 * Column Info
	 * @return n3ptyCctRcvDt
	 */
	public String getN3ptyCctRcvDt() {
		return this.n3ptyCctRcvDt;
	}
	
	/**
	 * Column Info
	 * @return cctOtsCurrCd5
	 */
	public String getCctOtsCurrCd5() {
		return this.cctOtsCurrCd5;
	}
	
	/**
	 * Column Info
	 * @return cctRcvOfcCd
	 */
	public String getCctRcvOfcCd() {
		return this.cctRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptyPptOtsCurrCd3
	 */
	public String getN3ptyPptOtsCurrCd3() {
		return this.n3ptyPptOtsCurrCd3;
	}
	
	/**
	 * Column Info
	 * @return n3ptyPptOtsCurrCd4
	 */
	public String getN3ptyPptOtsCurrCd4() {
		return this.n3ptyPptOtsCurrCd4;
	}
	
	/**
	 * Column Info
	 * @return n3ptyPptOtsCurrCd1
	 */
	public String getN3ptyPptOtsCurrCd1() {
		return this.n3ptyPptOtsCurrCd1;
	}
	
	/**
	 * Column Info
	 * @return n3ptyPptOtsCurrCd2
	 */
	public String getN3ptyPptOtsCurrCd2() {
		return this.n3ptyPptOtsCurrCd2;
	}
	
	/**
	 * Column Info
	 * @return cctRcvDt
	 */
	public String getCctRcvDt() {
		return this.cctRcvDt;
	}
	
	/**
	 * Column Info
	 * @return n3ptyCctRcvOfcCd
	 */
	public String getN3ptyCctRcvOfcCd() {
		return this.n3ptyCctRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptyPptOtsCurrCd5
	 */
	public String getN3ptyPptOtsCurrCd5() {
		return this.n3ptyPptOtsCurrCd5;
	}
	
	/**
	 * Column Info
	 * @return totOtsCurrCd1
	 */
	public String getTotOtsCurrCd1() {
		return this.totOtsCurrCd1;
	}
	
	/**
	 * Column Info
	 * @return totOtsCurrCd2
	 */
	public String getTotOtsCurrCd2() {
		return this.totOtsCurrCd2;
	}
	
	/**
	 * Column Info
	 * @return totOtsCurrCd3
	 */
	public String getTotOtsCurrCd3() {
		return this.totOtsCurrCd3;
	}
	
	/**
	 * Column Info
	 * @return totOtsCurrCd4
	 */
	public String getTotOtsCurrCd4() {
		return this.totOtsCurrCd4;
	}
	
	/**
	 * Column Info
	 * @return totOtsCurrCd5
	 */
	public String getTotOtsCurrCd5() {
		return this.totOtsCurrCd5;
	}
	
	/**
	 * Column Info
	 * @return n3ptyPptRcvDt
	 */
	public String getN3ptyPptRcvDt() {
		return this.n3ptyPptRcvDt;
	}
	
	/**
	 * Column Info
	 * @return n3ptyPptRcvUsrId
	 */
	public String getN3ptyPptRcvUsrId() {
		return this.n3ptyPptRcvUsrId;
	}
	
	/**
	 * Column Info
	 * @return n3ptyCctOtsAmt4
	 */
	public String getN3ptyCctOtsAmt4() {
		return this.n3ptyCctOtsAmt4;
	}
	
	/**
	 * Column Info
	 * @return n3ptyCctOtsAmt5
	 */
	public String getN3ptyCctOtsAmt5() {
		return this.n3ptyCctOtsAmt5;
	}
	
	/**
	 * Column Info
	 * @return pptRcvUsrId
	 */
	public String getPptRcvUsrId() {
		return this.pptRcvUsrId;
	}
	
	/**
	 * Column Info
	 * @return n3ptyCctOtsAmt2
	 */
	public String getN3ptyCctOtsAmt2() {
		return this.n3ptyCctOtsAmt2;
	}
	
	/**
	 * Column Info
	 * @return n3ptyCctOtsAmt3
	 */
	public String getN3ptyCctOtsAmt3() {
		return this.n3ptyCctOtsAmt3;
	}
	
	/**
	 * Column Info
	 * @return n3ptyCctStsCd
	 */
	public String getN3ptyCctStsCd() {
		return this.n3ptyCctStsCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptyCctOtsAmt1
	 */
	public String getN3ptyCctOtsAmt1() {
		return this.n3ptyCctOtsAmt1;
	}
	
	/**
	 * Column Info
	 * @return pptStsCd
	 */
	public String getPptStsCd() {
		return this.pptStsCd;
	}
	
	/**
	 * Column Info
	 * @return totOtsStsCd
	 */
	public String getTotOtsStsCd() {
		return this.totOtsStsCd;
	}
	
	/**
	 * Column Info
	 * @return pptRcvDt
	 */
	public String getPptRcvDt() {
		return this.pptRcvDt;
	}
	
	/**
	 * Column Info
	 * @return pptOtsCurrCd5
	 */
	public String getPptOtsCurrCd5() {
		return this.pptOtsCurrCd5;
	}
	
	/**
	 * Column Info
	 * @return eaiResult
	 */
	public String getEaiResult() {
		return this.eaiResult;
	}
	
	/**
	 * Column Info
	 * @return totOtsAmt1
	 */
	public String getTotOtsAmt1() {
		return this.totOtsAmt1;
	}
	
	/**
	 * Column Info
	 * @return totOtsAmt2
	 */
	public String getTotOtsAmt2() {
		return this.totOtsAmt2;
	}
	
	/**
	 * Column Info
	 * @return pptOtsCurrCd3
	 */
	public String getPptOtsCurrCd3() {
		return this.pptOtsCurrCd3;
	}
	
	/**
	 * Column Info
	 * @return n3ptyPptOtsAmt5
	 */
	public String getN3ptyPptOtsAmt5() {
		return this.n3ptyPptOtsAmt5;
	}
	
	/**
	 * Column Info
	 * @return pptOtsCurrCd4
	 */
	public String getPptOtsCurrCd4() {
		return this.pptOtsCurrCd4;
	}
	
	/**
	 * Column Info
	 * @return n3ptyPptOtsAmt4
	 */
	public String getN3ptyPptOtsAmt4() {
		return this.n3ptyPptOtsAmt4;
	}
	
	/**
	 * Column Info
	 * @return pptOtsAmt1
	 */
	public String getPptOtsAmt1() {
		return this.pptOtsAmt1;
	}
	
	/**
	 * Column Info
	 * @return pptOtsCurrCd1
	 */
	public String getPptOtsCurrCd1() {
		return this.pptOtsCurrCd1;
	}
	
	/**
	 * Column Info
	 * @return n3ptyPptOtsAmt3
	 */
	public String getN3ptyPptOtsAmt3() {
		return this.n3ptyPptOtsAmt3;
	}
	
	/**
	 * Column Info
	 * @return pptOtsCurrCd2
	 */
	public String getPptOtsCurrCd2() {
		return this.pptOtsCurrCd2;
	}
	
	/**
	 * Column Info
	 * @return n3ptyPptOtsAmt2
	 */
	public String getN3ptyPptOtsAmt2() {
		return this.n3ptyPptOtsAmt2;
	}
	
	/**
	 * Column Info
	 * @return pptOtsAmt3
	 */
	public String getPptOtsAmt3() {
		return this.pptOtsAmt3;
	}
	
	/**
	 * Column Info
	 * @return n3ptyPptOtsAmt1
	 */
	public String getN3ptyPptOtsAmt1() {
		return this.n3ptyPptOtsAmt1;
	}
	
	/**
	 * Column Info
	 * @return pptOtsAmt2
	 */
	public String getPptOtsAmt2() {
		return this.pptOtsAmt2;
	}
	
	/**
	 * Column Info
	 * @return pptOtsAmt5
	 */
	public String getPptOtsAmt5() {
		return this.pptOtsAmt5;
	}
	
	/**
	 * Column Info
	 * @return pptOtsAmt4
	 */
	public String getPptOtsAmt4() {
		return this.pptOtsAmt4;
	}
	
	/**
	 * Column Info
	 * @return cctStsCd
	 */
	public String getCctStsCd() {
		return this.cctStsCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptyPptRcvOfcCd
	 */
	public String getN3ptyPptRcvOfcCd() {
		return this.n3ptyPptRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptyCctOtsCurrCd5
	 */
	public String getN3ptyCctOtsCurrCd5() {
		return this.n3ptyCctOtsCurrCd5;
	}
	
	/**
	 * Column Info
	 * @return cctOtsAmt5
	 */
	public String getCctOtsAmt5() {
		return this.cctOtsAmt5;
	}
	
	/**
	 * Column Info
	 * @return n3ptyCctOtsCurrCd2
	 */
	public String getN3ptyCctOtsCurrCd2() {
		return this.n3ptyCctOtsCurrCd2;
	}
	
	/**
	 * Column Info
	 * @return totOtsAmt5
	 */
	public String getTotOtsAmt5() {
		return this.totOtsAmt5;
	}
	
	/**
	 * Column Info
	 * @return cctOtsAmt4
	 */
	public String getCctOtsAmt4() {
		return this.cctOtsAmt4;
	}
	
	/**
	 * Column Info
	 * @return n3ptyCctOtsCurrCd1
	 */
	public String getN3ptyCctOtsCurrCd1() {
		return this.n3ptyCctOtsCurrCd1;
	}
	
	/**
	 * Column Info
	 * @return totOtsAmt4
	 */
	public String getTotOtsAmt4() {
		return this.totOtsAmt4;
	}
	
	/**
	 * Column Info
	 * @return cctOtsAmt3
	 */
	public String getCctOtsAmt3() {
		return this.cctOtsAmt3;
	}
	
	/**
	 * Column Info
	 * @return n3ptyCctOtsCurrCd4
	 */
	public String getN3ptyCctOtsCurrCd4() {
		return this.n3ptyCctOtsCurrCd4;
	}
	
	/**
	 * Column Info
	 * @return totOtsAmt3
	 */
	public String getTotOtsAmt3() {
		return this.totOtsAmt3;
	}
	
	/**
	 * Column Info
	 * @return cctOtsAmt2
	 */
	public String getCctOtsAmt2() {
		return this.cctOtsAmt2;
	}
	
	/**
	 * Column Info
	 * @return n3ptyCctOtsCurrCd3
	 */
	public String getN3ptyCctOtsCurrCd3() {
		return this.n3ptyCctOtsCurrCd3;
	}
	
	/**
	 * Column Info
	 * @return cctOtsAmt1
	 */
	public String getCctOtsAmt1() {
		return this.cctOtsAmt1;
	}
	
	/**
	 * Column Info
	 * @return cctRcvUsrId
	 */
	public String getCctRcvUsrId() {
		return this.cctRcvUsrId;
	}
	
	/**
	 * Column Info
	 * @return n3ptyCctRcvUsrId
	 */
	public String getN3ptyCctRcvUsrId() {
		return this.n3ptyCctRcvUsrId;
	}
	
	/**
	 * Column Info
	 * @return n3ptyPptStsCd
	 */
	public String getN3ptyPptStsCd() {
		return this.n3ptyPptStsCd;
	}
	

	/**
	 * Column Info
	 * @param pptRcvOfcCd
	 */
	public void setPptRcvOfcCd(String pptRcvOfcCd) {
		this.pptRcvOfcCd = pptRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @param cctOtsCurrCd3
	 */
	public void setCctOtsCurrCd3(String cctOtsCurrCd3) {
		this.cctOtsCurrCd3 = cctOtsCurrCd3;
	}
	
	/**
	 * Column Info
	 * @param cctOtsCurrCd4
	 */
	public void setCctOtsCurrCd4(String cctOtsCurrCd4) {
		this.cctOtsCurrCd4 = cctOtsCurrCd4;
	}
	
	/**
	 * Column Info
	 * @param cctOtsCurrCd1
	 */
	public void setCctOtsCurrCd1(String cctOtsCurrCd1) {
		this.cctOtsCurrCd1 = cctOtsCurrCd1;
	}
	
	/**
	 * Column Info
	 * @param cctOtsCurrCd2
	 */
	public void setCctOtsCurrCd2(String cctOtsCurrCd2) {
		this.cctOtsCurrCd2 = cctOtsCurrCd2;
	}
	
	/**
	 * Column Info
	 * @param n3ptyCctRcvDt
	 */
	public void setN3ptyCctRcvDt(String n3ptyCctRcvDt) {
		this.n3ptyCctRcvDt = n3ptyCctRcvDt;
	}
	
	/**
	 * Column Info
	 * @param cctOtsCurrCd5
	 */
	public void setCctOtsCurrCd5(String cctOtsCurrCd5) {
		this.cctOtsCurrCd5 = cctOtsCurrCd5;
	}
	
	/**
	 * Column Info
	 * @param cctRcvOfcCd
	 */
	public void setCctRcvOfcCd(String cctRcvOfcCd) {
		this.cctRcvOfcCd = cctRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptyPptOtsCurrCd3
	 */
	public void setN3ptyPptOtsCurrCd3(String n3ptyPptOtsCurrCd3) {
		this.n3ptyPptOtsCurrCd3 = n3ptyPptOtsCurrCd3;
	}
	
	/**
	 * Column Info
	 * @param n3ptyPptOtsCurrCd4
	 */
	public void setN3ptyPptOtsCurrCd4(String n3ptyPptOtsCurrCd4) {
		this.n3ptyPptOtsCurrCd4 = n3ptyPptOtsCurrCd4;
	}
	
	/**
	 * Column Info
	 * @param n3ptyPptOtsCurrCd1
	 */
	public void setN3ptyPptOtsCurrCd1(String n3ptyPptOtsCurrCd1) {
		this.n3ptyPptOtsCurrCd1 = n3ptyPptOtsCurrCd1;
	}
	
	/**
	 * Column Info
	 * @param n3ptyPptOtsCurrCd2
	 */
	public void setN3ptyPptOtsCurrCd2(String n3ptyPptOtsCurrCd2) {
		this.n3ptyPptOtsCurrCd2 = n3ptyPptOtsCurrCd2;
	}
	
	/**
	 * Column Info
	 * @param cctRcvDt
	 */
	public void setCctRcvDt(String cctRcvDt) {
		this.cctRcvDt = cctRcvDt;
	}
	
	/**
	 * Column Info
	 * @param n3ptyCctRcvOfcCd
	 */
	public void setN3ptyCctRcvOfcCd(String n3ptyCctRcvOfcCd) {
		this.n3ptyCctRcvOfcCd = n3ptyCctRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptyPptOtsCurrCd5
	 */
	public void setN3ptyPptOtsCurrCd5(String n3ptyPptOtsCurrCd5) {
		this.n3ptyPptOtsCurrCd5 = n3ptyPptOtsCurrCd5;
	}
	
	/**
	 * Column Info
	 * @param totOtsCurrCd1
	 */
	public void setTotOtsCurrCd1(String totOtsCurrCd1) {
		this.totOtsCurrCd1 = totOtsCurrCd1;
	}
	
	/**
	 * Column Info
	 * @param totOtsCurrCd2
	 */
	public void setTotOtsCurrCd2(String totOtsCurrCd2) {
		this.totOtsCurrCd2 = totOtsCurrCd2;
	}
	
	/**
	 * Column Info
	 * @param totOtsCurrCd3
	 */
	public void setTotOtsCurrCd3(String totOtsCurrCd3) {
		this.totOtsCurrCd3 = totOtsCurrCd3;
	}
	
	/**
	 * Column Info
	 * @param totOtsCurrCd4
	 */
	public void setTotOtsCurrCd4(String totOtsCurrCd4) {
		this.totOtsCurrCd4 = totOtsCurrCd4;
	}
	
	/**
	 * Column Info
	 * @param totOtsCurrCd5
	 */
	public void setTotOtsCurrCd5(String totOtsCurrCd5) {
		this.totOtsCurrCd5 = totOtsCurrCd5;
	}
	
	/**
	 * Column Info
	 * @param n3ptyPptRcvDt
	 */
	public void setN3ptyPptRcvDt(String n3ptyPptRcvDt) {
		this.n3ptyPptRcvDt = n3ptyPptRcvDt;
	}
	
	/**
	 * Column Info
	 * @param n3ptyPptRcvUsrId
	 */
	public void setN3ptyPptRcvUsrId(String n3ptyPptRcvUsrId) {
		this.n3ptyPptRcvUsrId = n3ptyPptRcvUsrId;
	}
	
	/**
	 * Column Info
	 * @param n3ptyCctOtsAmt4
	 */
	public void setN3ptyCctOtsAmt4(String n3ptyCctOtsAmt4) {
		this.n3ptyCctOtsAmt4 = n3ptyCctOtsAmt4;
	}
	
	/**
	 * Column Info
	 * @param n3ptyCctOtsAmt5
	 */
	public void setN3ptyCctOtsAmt5(String n3ptyCctOtsAmt5) {
		this.n3ptyCctOtsAmt5 = n3ptyCctOtsAmt5;
	}
	
	/**
	 * Column Info
	 * @param pptRcvUsrId
	 */
	public void setPptRcvUsrId(String pptRcvUsrId) {
		this.pptRcvUsrId = pptRcvUsrId;
	}
	
	/**
	 * Column Info
	 * @param n3ptyCctOtsAmt2
	 */
	public void setN3ptyCctOtsAmt2(String n3ptyCctOtsAmt2) {
		this.n3ptyCctOtsAmt2 = n3ptyCctOtsAmt2;
	}
	
	/**
	 * Column Info
	 * @param n3ptyCctOtsAmt3
	 */
	public void setN3ptyCctOtsAmt3(String n3ptyCctOtsAmt3) {
		this.n3ptyCctOtsAmt3 = n3ptyCctOtsAmt3;
	}
	
	/**
	 * Column Info
	 * @param n3ptyCctStsCd
	 */
	public void setN3ptyCctStsCd(String n3ptyCctStsCd) {
		this.n3ptyCctStsCd = n3ptyCctStsCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptyCctOtsAmt1
	 */
	public void setN3ptyCctOtsAmt1(String n3ptyCctOtsAmt1) {
		this.n3ptyCctOtsAmt1 = n3ptyCctOtsAmt1;
	}
	
	/**
	 * Column Info
	 * @param pptStsCd
	 */
	public void setPptStsCd(String pptStsCd) {
		this.pptStsCd = pptStsCd;
	}
	
	/**
	 * Column Info
	 * @param totOtsStsCd
	 */
	public void setTotOtsStsCd(String totOtsStsCd) {
		this.totOtsStsCd = totOtsStsCd;
	}
	
	/**
	 * Column Info
	 * @param pptRcvDt
	 */
	public void setPptRcvDt(String pptRcvDt) {
		this.pptRcvDt = pptRcvDt;
	}
	
	/**
	 * Column Info
	 * @param pptOtsCurrCd5
	 */
	public void setPptOtsCurrCd5(String pptOtsCurrCd5) {
		this.pptOtsCurrCd5 = pptOtsCurrCd5;
	}
	
	/**
	 * Column Info
	 * @param eaiResult
	 */
	public void setEaiResult(String eaiResult) {
		this.eaiResult = eaiResult;
	}
	
	/**
	 * Column Info
	 * @param totOtsAmt1
	 */
	public void setTotOtsAmt1(String totOtsAmt1) {
		this.totOtsAmt1 = totOtsAmt1;
	}
	
	/**
	 * Column Info
	 * @param totOtsAmt2
	 */
	public void setTotOtsAmt2(String totOtsAmt2) {
		this.totOtsAmt2 = totOtsAmt2;
	}
	
	/**
	 * Column Info
	 * @param pptOtsCurrCd3
	 */
	public void setPptOtsCurrCd3(String pptOtsCurrCd3) {
		this.pptOtsCurrCd3 = pptOtsCurrCd3;
	}
	
	/**
	 * Column Info
	 * @param n3ptyPptOtsAmt5
	 */
	public void setN3ptyPptOtsAmt5(String n3ptyPptOtsAmt5) {
		this.n3ptyPptOtsAmt5 = n3ptyPptOtsAmt5;
	}
	
	/**
	 * Column Info
	 * @param pptOtsCurrCd4
	 */
	public void setPptOtsCurrCd4(String pptOtsCurrCd4) {
		this.pptOtsCurrCd4 = pptOtsCurrCd4;
	}
	
	/**
	 * Column Info
	 * @param n3ptyPptOtsAmt4
	 */
	public void setN3ptyPptOtsAmt4(String n3ptyPptOtsAmt4) {
		this.n3ptyPptOtsAmt4 = n3ptyPptOtsAmt4;
	}
	
	/**
	 * Column Info
	 * @param pptOtsAmt1
	 */
	public void setPptOtsAmt1(String pptOtsAmt1) {
		this.pptOtsAmt1 = pptOtsAmt1;
	}
	
	/**
	 * Column Info
	 * @param pptOtsCurrCd1
	 */
	public void setPptOtsCurrCd1(String pptOtsCurrCd1) {
		this.pptOtsCurrCd1 = pptOtsCurrCd1;
	}
	
	/**
	 * Column Info
	 * @param n3ptyPptOtsAmt3
	 */
	public void setN3ptyPptOtsAmt3(String n3ptyPptOtsAmt3) {
		this.n3ptyPptOtsAmt3 = n3ptyPptOtsAmt3;
	}
	
	/**
	 * Column Info
	 * @param pptOtsCurrCd2
	 */
	public void setPptOtsCurrCd2(String pptOtsCurrCd2) {
		this.pptOtsCurrCd2 = pptOtsCurrCd2;
	}
	
	/**
	 * Column Info
	 * @param n3ptyPptOtsAmt2
	 */
	public void setN3ptyPptOtsAmt2(String n3ptyPptOtsAmt2) {
		this.n3ptyPptOtsAmt2 = n3ptyPptOtsAmt2;
	}
	
	/**
	 * Column Info
	 * @param pptOtsAmt3
	 */
	public void setPptOtsAmt3(String pptOtsAmt3) {
		this.pptOtsAmt3 = pptOtsAmt3;
	}
	
	/**
	 * Column Info
	 * @param n3ptyPptOtsAmt1
	 */
	public void setN3ptyPptOtsAmt1(String n3ptyPptOtsAmt1) {
		this.n3ptyPptOtsAmt1 = n3ptyPptOtsAmt1;
	}
	
	/**
	 * Column Info
	 * @param pptOtsAmt2
	 */
	public void setPptOtsAmt2(String pptOtsAmt2) {
		this.pptOtsAmt2 = pptOtsAmt2;
	}
	
	/**
	 * Column Info
	 * @param pptOtsAmt5
	 */
	public void setPptOtsAmt5(String pptOtsAmt5) {
		this.pptOtsAmt5 = pptOtsAmt5;
	}
	
	/**
	 * Column Info
	 * @param pptOtsAmt4
	 */
	public void setPptOtsAmt4(String pptOtsAmt4) {
		this.pptOtsAmt4 = pptOtsAmt4;
	}
	
	/**
	 * Column Info
	 * @param cctStsCd
	 */
	public void setCctStsCd(String cctStsCd) {
		this.cctStsCd = cctStsCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptyPptRcvOfcCd
	 */
	public void setN3ptyPptRcvOfcCd(String n3ptyPptRcvOfcCd) {
		this.n3ptyPptRcvOfcCd = n3ptyPptRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptyCctOtsCurrCd5
	 */
	public void setN3ptyCctOtsCurrCd5(String n3ptyCctOtsCurrCd5) {
		this.n3ptyCctOtsCurrCd5 = n3ptyCctOtsCurrCd5;
	}
	
	/**
	 * Column Info
	 * @param cctOtsAmt5
	 */
	public void setCctOtsAmt5(String cctOtsAmt5) {
		this.cctOtsAmt5 = cctOtsAmt5;
	}
	
	/**
	 * Column Info
	 * @param n3ptyCctOtsCurrCd2
	 */
	public void setN3ptyCctOtsCurrCd2(String n3ptyCctOtsCurrCd2) {
		this.n3ptyCctOtsCurrCd2 = n3ptyCctOtsCurrCd2;
	}
	
	/**
	 * Column Info
	 * @param totOtsAmt5
	 */
	public void setTotOtsAmt5(String totOtsAmt5) {
		this.totOtsAmt5 = totOtsAmt5;
	}
	
	/**
	 * Column Info
	 * @param cctOtsAmt4
	 */
	public void setCctOtsAmt4(String cctOtsAmt4) {
		this.cctOtsAmt4 = cctOtsAmt4;
	}
	
	/**
	 * Column Info
	 * @param n3ptyCctOtsCurrCd1
	 */
	public void setN3ptyCctOtsCurrCd1(String n3ptyCctOtsCurrCd1) {
		this.n3ptyCctOtsCurrCd1 = n3ptyCctOtsCurrCd1;
	}
	
	/**
	 * Column Info
	 * @param totOtsAmt4
	 */
	public void setTotOtsAmt4(String totOtsAmt4) {
		this.totOtsAmt4 = totOtsAmt4;
	}
	
	/**
	 * Column Info
	 * @param cctOtsAmt3
	 */
	public void setCctOtsAmt3(String cctOtsAmt3) {
		this.cctOtsAmt3 = cctOtsAmt3;
	}
	
	/**
	 * Column Info
	 * @param n3ptyCctOtsCurrCd4
	 */
	public void setN3ptyCctOtsCurrCd4(String n3ptyCctOtsCurrCd4) {
		this.n3ptyCctOtsCurrCd4 = n3ptyCctOtsCurrCd4;
	}
	
	/**
	 * Column Info
	 * @param totOtsAmt3
	 */
	public void setTotOtsAmt3(String totOtsAmt3) {
		this.totOtsAmt3 = totOtsAmt3;
	}
	
	/**
	 * Column Info
	 * @param cctOtsAmt2
	 */
	public void setCctOtsAmt2(String cctOtsAmt2) {
		this.cctOtsAmt2 = cctOtsAmt2;
	}
	
	/**
	 * Column Info
	 * @param n3ptyCctOtsCurrCd3
	 */
	public void setN3ptyCctOtsCurrCd3(String n3ptyCctOtsCurrCd3) {
		this.n3ptyCctOtsCurrCd3 = n3ptyCctOtsCurrCd3;
	}
	
	/**
	 * Column Info
	 * @param cctOtsAmt1
	 */
	public void setCctOtsAmt1(String cctOtsAmt1) {
		this.cctOtsAmt1 = cctOtsAmt1;
	}
	
	/**
	 * Column Info
	 * @param cctRcvUsrId
	 */
	public void setCctRcvUsrId(String cctRcvUsrId) {
		this.cctRcvUsrId = cctRcvUsrId;
	}
	
	/**
	 * Column Info
	 * @param n3ptyCctRcvUsrId
	 */
	public void setN3ptyCctRcvUsrId(String n3ptyCctRcvUsrId) {
		this.n3ptyCctRcvUsrId = n3ptyCctRcvUsrId;
	}
	
	/**
	 * Column Info
	 * @param n3ptyPptStsCd
	 */
	public void setN3ptyPptStsCd(String n3ptyPptStsCd) {
		this.n3ptyPptStsCd = n3ptyPptStsCd;
	}
	
	/**
	 * Column Info
	 * @return lcloblissueflg
	 */
	public String getLcloblissueflg() {
		return this.lcloblissueflg;
	}
	

	/**
	 * Column Info
	 * @param lcloblissueflg
	 */
	public void setLcloblissueflg(String lcloblissueflg) {
		this.lcloblissueflg = lcloblissueflg;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setSplitFlg(JSPUtil.getParameter(request, "split_flg", ""));
		setDschLoc(JSPUtil.getParameter(request, "dsch_loc", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, "vps_eta_dt", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setWgtUtCd(JSPUtil.getParameter(request, "wgt_ut_cd", ""));
		setMeasQty(JSPUtil.getParameter(request, "meas_qty", ""));
		setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
		setPckTpCd(JSPUtil.getParameter(request, "pck_tp_cd", ""));
		setMeasUtCd(JSPUtil.getParameter(request, "meas_ut_cd", ""));
		setOblIssRmk(JSPUtil.getParameter(request, "obl_iss_rmk", ""));
		setCcustAddr(JSPUtil.getParameter(request, "ccust_addr", ""));
		setCntrPrtFlg(JSPUtil.getParameter(request, "cntr_prt_flg", ""));
		setNcustAddr(JSPUtil.getParameter(request, "ncust_addr", ""));
		setScustAddr(JSPUtil.getParameter(request, "scust_addr", ""));
		setRepCmdtNm(JSPUtil.getParameter(request, "rep_cmdt_nm", ""));
		setCallSgnNo(JSPUtil.getParameter(request, "call_sgn_no", ""));
		setScustNm(JSPUtil.getParameter(request, "scust_nm", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setBlTpCd(JSPUtil.getParameter(request, "bl_tp_cd", ""));
		setNcustNm(JSPUtil.getParameter(request, "ncust_nm", ""));
		setActWgt(JSPUtil.getParameter(request, "act_wgt", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setSocFlg(JSPUtil.getParameter(request, "soc_flg", ""));
		setDeTermCd(JSPUtil.getParameter(request, "de_term_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setArrivalVessel(JSPUtil.getParameter(request, "arrival_vessel", ""));
		setDeTermDesc(JSPUtil.getParameter(request, "de_term_desc", ""));
		setCcustNm(JSPUtil.getParameter(request, "ccust_nm", ""));
		setLcloblissueflg(JSPUtil.getParameter(request, "lcloblissueflg", ""));
		
		
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCyOpCd(JSPUtil.getParameter(request, "cy_op_cd", ""));
		setDoSplitFlg(JSPUtil.getParameter(request, "do_split_flg", ""));
		setIdaImpGenMfNo(JSPUtil.getParameter(request, "ida_imp_gen_mf_no", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setInfoCgoFlg(JSPUtil.getParameter(request, "info_cgo_flg", ""));
		setIdaCstmsAsgnLineNo(JSPUtil.getParameter(request, "ida_cstms_asgn_line_no", ""));
		setDoHldFlg(JSPUtil.getParameter(request, "do_hld_flg", ""));
		setCstmsRefNm(JSPUtil.getParameter(request, "cstms_ref_nm", ""));
		setIdaCgorOrdYr(JSPUtil.getParameter(request, "ida_cgor_ord_yr", ""));
		setCstmsAsgnCtnt(JSPUtil.getParameter(request, "cstms_asgn_ctnt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setInterRmk(JSPUtil.getParameter(request, "inter_rmk", ""));
		setCstmsRefCtnt(JSPUtil.getParameter(request, "cstms_ref_ctnt", ""));
		setCstmsAsgnNm(JSPUtil.getParameter(request, "cstms_asgn_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		
		
		setOblIssDt(JSPUtil.getParameter(request, "obl_iss_dt", ""));
		setIbdDocRcvOfcCd(JSPUtil.getParameter(request, "ibd_doc_rcv_ofc_cd", ""));
		setOblIssTpCd(JSPUtil.getParameter(request, "obl_iss_tp_cd", ""));
		setOtrDocRcvOfcCd(JSPUtil.getParameter(request, "otr_doc_rcv_ofc_cd", ""));
		setOtrDocRcvUsrId(JSPUtil.getParameter(request, "otr_doc_rcv_usr_id", ""));
		setOtrDocCgorFlg(JSPUtil.getParameter(request, "otr_doc_cgor_flg", ""));
		setOblRdemDt(JSPUtil.getParameter(request, "obl_rdem_dt", ""));
		setOblIssUsrId(JSPUtil.getParameter(request, "obl_iss_usr_id", ""));
		setOblCpyKnt(JSPUtil.getParameter(request, "obl_cpy_knt", ""));
		setIbdDocRcvUsrId(JSPUtil.getParameter(request, "ibd_doc_rcv_usr_id", ""));
		setIbdDocRcvDt(JSPUtil.getParameter(request, "ibd_doc_rcv_dt", ""));
		setBlOtrDocRcvCd(JSPUtil.getParameter(request, "bl_otr_doc_rcv_cd", ""));
		setOblIssOfcCd(JSPUtil.getParameter(request, "obl_iss_ofc_cd", ""));
		setDelCntCd(JSPUtil.getParameter(request, "del_cnt_cd", ""));
		setOblRdemFlg(JSPUtil.getParameter(request, "obl_rdem_flg", ""));
		setOblIssKnt(JSPUtil.getParameter(request, "obl_iss_knt", ""));
		setIbdDocRcvFlg(JSPUtil.getParameter(request, "ibd_doc_rcv_flg", ""));
		setOtrDocRcvDt(JSPUtil.getParameter(request, "otr_doc_rcv_dt", ""));
		setOblRdemKnt(JSPUtil.getParameter(request, "obl_rdem_knt", ""));
		setOblRdemUsrId(JSPUtil.getParameter(request, "obl_rdem_usr_id", ""));
		setOblTtlKnt(JSPUtil.getParameter(request, "obl_ttl_knt", ""));
		setOblRdemUpdUsrId(JSPUtil.getParameter(request, "obl_rdem_upd_usr_id", ""));
		setOblRdemOfcCd(JSPUtil.getParameter(request, "obl_rdem_ofc_cd", ""));
		
		setPptRcvOfcCd(JSPUtil.getParameter(request, "ppt_rcv_ofc_cd", ""));
		setCctOtsCurrCd3(JSPUtil.getParameter(request, "cct_ots_curr_cd3", ""));
		setCctOtsCurrCd4(JSPUtil.getParameter(request, "cct_ots_curr_cd4", ""));
		setCctOtsCurrCd1(JSPUtil.getParameter(request, "cct_ots_curr_cd1", ""));
		setCctOtsCurrCd2(JSPUtil.getParameter(request, "cct_ots_curr_cd2", ""));
		setN3ptyCctRcvDt(JSPUtil.getParameter(request, "n3pty_cct_rcv_dt", ""));
		setCctOtsCurrCd5(JSPUtil.getParameter(request, "cct_ots_curr_cd5", ""));
		setCctRcvOfcCd(JSPUtil.getParameter(request, "cct_rcv_ofc_cd", ""));
		setN3ptyPptOtsCurrCd3(JSPUtil.getParameter(request, "n3pty_ppt_ots_curr_cd3", ""));
		setN3ptyPptOtsCurrCd4(JSPUtil.getParameter(request, "n3pty_ppt_ots_curr_cd4", ""));
		setN3ptyPptOtsCurrCd1(JSPUtil.getParameter(request, "n3pty_ppt_ots_curr_cd1", ""));
		setN3ptyPptOtsCurrCd2(JSPUtil.getParameter(request, "n3pty_ppt_ots_curr_cd2", ""));
		setCctRcvDt(JSPUtil.getParameter(request, "cct_rcv_dt", ""));
		setN3ptyCctRcvOfcCd(JSPUtil.getParameter(request, "n3pty_cct_rcv_ofc_cd", ""));
		setN3ptyPptOtsCurrCd5(JSPUtil.getParameter(request, "n3pty_ppt_ots_curr_cd5", ""));
		setTotOtsCurrCd1(JSPUtil.getParameter(request, "tot_ots_curr_cd1", ""));
		setTotOtsCurrCd2(JSPUtil.getParameter(request, "tot_ots_curr_cd2", ""));
		setTotOtsCurrCd3(JSPUtil.getParameter(request, "tot_ots_curr_cd3", ""));
		setTotOtsCurrCd4(JSPUtil.getParameter(request, "tot_ots_curr_cd4", ""));
		setTotOtsCurrCd5(JSPUtil.getParameter(request, "tot_ots_curr_cd5", ""));
		setN3ptyPptRcvDt(JSPUtil.getParameter(request, "n3pty_ppt_rcv_dt", ""));
		setN3ptyPptRcvUsrId(JSPUtil.getParameter(request, "n3pty_ppt_rcv_usr_id", ""));
		setN3ptyCctOtsAmt4(JSPUtil.getParameter(request, "n3pty_cct_ots_amt4", ""));
		setN3ptyCctOtsAmt5(JSPUtil.getParameter(request, "n3pty_cct_ots_amt5", ""));
		setPptRcvUsrId(JSPUtil.getParameter(request, "ppt_rcv_usr_id", ""));
		setN3ptyCctOtsAmt2(JSPUtil.getParameter(request, "n3pty_cct_ots_amt2", ""));
		setN3ptyCctOtsAmt3(JSPUtil.getParameter(request, "n3pty_cct_ots_amt3", ""));
		setN3ptyCctStsCd(JSPUtil.getParameter(request, "n3pty_cct_sts_cd", ""));
		setN3ptyCctOtsAmt1(JSPUtil.getParameter(request, "n3pty_cct_ots_amt1", ""));
		setPptStsCd(JSPUtil.getParameter(request, "ppt_sts_cd", ""));
		setTotOtsStsCd(JSPUtil.getParameter(request, "tot_ots_sts_cd", ""));
		setPptRcvDt(JSPUtil.getParameter(request, "ppt_rcv_dt", ""));
		setPptOtsCurrCd5(JSPUtil.getParameter(request, "ppt_ots_curr_cd5", ""));
		setEaiResult(JSPUtil.getParameter(request, "eai_result", ""));
		setTotOtsAmt1(JSPUtil.getParameter(request, "tot_ots_amt1", ""));
		setTotOtsAmt2(JSPUtil.getParameter(request, "tot_ots_amt2", ""));
		setPptOtsCurrCd3(JSPUtil.getParameter(request, "ppt_ots_curr_cd3", ""));
		setN3ptyPptOtsAmt5(JSPUtil.getParameter(request, "n3pty_ppt_ots_amt5", ""));
		setPptOtsCurrCd4(JSPUtil.getParameter(request, "ppt_ots_curr_cd4", ""));
		setN3ptyPptOtsAmt4(JSPUtil.getParameter(request, "n3pty_ppt_ots_amt4", ""));
		setPptOtsAmt1(JSPUtil.getParameter(request, "ppt_ots_amt1", ""));
		setPptOtsCurrCd1(JSPUtil.getParameter(request, "ppt_ots_curr_cd1", ""));
		setN3ptyPptOtsAmt3(JSPUtil.getParameter(request, "n3pty_ppt_ots_amt3", ""));
		setPptOtsCurrCd2(JSPUtil.getParameter(request, "ppt_ots_curr_cd2", ""));
		setN3ptyPptOtsAmt2(JSPUtil.getParameter(request, "n3pty_ppt_ots_amt2", ""));
		setPptOtsAmt3(JSPUtil.getParameter(request, "ppt_ots_amt3", ""));
		setN3ptyPptOtsAmt1(JSPUtil.getParameter(request, "n3pty_ppt_ots_amt1", ""));
		setPptOtsAmt2(JSPUtil.getParameter(request, "ppt_ots_amt2", ""));
		setPptOtsAmt5(JSPUtil.getParameter(request, "ppt_ots_amt5", ""));
		setPptOtsAmt4(JSPUtil.getParameter(request, "ppt_ots_amt4", ""));
		setCctStsCd(JSPUtil.getParameter(request, "cct_sts_cd", ""));
		setN3ptyPptRcvOfcCd(JSPUtil.getParameter(request, "n3pty_ppt_rcv_ofc_cd", ""));
		setN3ptyCctOtsCurrCd5(JSPUtil.getParameter(request, "n3pty_cct_ots_curr_cd5", ""));
		setCctOtsAmt5(JSPUtil.getParameter(request, "cct_ots_amt5", ""));
		setN3ptyCctOtsCurrCd2(JSPUtil.getParameter(request, "n3pty_cct_ots_curr_cd2", ""));
		setTotOtsAmt5(JSPUtil.getParameter(request, "tot_ots_amt5", ""));
		setCctOtsAmt4(JSPUtil.getParameter(request, "cct_ots_amt4", ""));
		setN3ptyCctOtsCurrCd1(JSPUtil.getParameter(request, "n3pty_cct_ots_curr_cd1", ""));
		setTotOtsAmt4(JSPUtil.getParameter(request, "tot_ots_amt4", ""));
		setCctOtsAmt3(JSPUtil.getParameter(request, "cct_ots_amt3", ""));
		setN3ptyCctOtsCurrCd4(JSPUtil.getParameter(request, "n3pty_cct_ots_curr_cd4", ""));
		setTotOtsAmt3(JSPUtil.getParameter(request, "tot_ots_amt3", ""));
		setCctOtsAmt2(JSPUtil.getParameter(request, "cct_ots_amt2", ""));
		setN3ptyCctOtsCurrCd3(JSPUtil.getParameter(request, "n3pty_cct_ots_curr_cd3", ""));
		setCctOtsAmt1(JSPUtil.getParameter(request, "cct_ots_amt1", ""));
		setCctRcvUsrId(JSPUtil.getParameter(request, "cct_rcv_usr_id", ""));
		setN3ptyCctRcvUsrId(JSPUtil.getParameter(request, "n3pty_cct_rcv_usr_id", ""));
		setN3ptyPptStsCd(JSPUtil.getParameter(request, "n3pty_ppt_sts_cd", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GenDoBlInfoVO[]
	 */
	public GenDoBlInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GenDoBlInfoVO[]
	 */
	public GenDoBlInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GenDoBlInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] splitFlg = (JSPUtil.getParameter(request, prefix	+ "split_flg", length));
			String[] dschLoc = (JSPUtil.getParameter(request, prefix	+ "dsch_loc", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			String[] oblIssRmk = (JSPUtil.getParameter(request, prefix	+ "obl_iss_rmk", length));
			String[] ccustAddr = (JSPUtil.getParameter(request, prefix	+ "ccust_addr", length));
			String[] cntrPrtFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_prt_flg", length));
			String[] ncustAddr = (JSPUtil.getParameter(request, prefix	+ "ncust_addr", length));
			String[] scustAddr = (JSPUtil.getParameter(request, prefix	+ "scust_addr", length));
			String[] repCmdtNm = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt_nm", length));
			String[] callSgnNo = (JSPUtil.getParameter(request, prefix	+ "call_sgn_no", length));
			String[] scustNm = (JSPUtil.getParameter(request, prefix	+ "scust_nm", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] blTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_tp_cd", length));
			String[] ncustNm = (JSPUtil.getParameter(request, prefix	+ "ncust_nm", length));
			String[] actWgt = (JSPUtil.getParameter(request, prefix	+ "act_wgt", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] socFlg = (JSPUtil.getParameter(request, prefix	+ "soc_flg", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] arrivalVessel = (JSPUtil.getParameter(request, prefix	+ "arrival_vessel", length));
			String[] deTermDesc = (JSPUtil.getParameter(request, prefix	+ "de_term_desc", length));
			String[] ccustNm = (JSPUtil.getParameter(request, prefix	+ "ccust_nm", length));
			String[] lcloblissueflg = (JSPUtil.getParameter(request, prefix	+ "lcloblissueflg", length));
			
			
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] cyOpCd = (JSPUtil.getParameter(request, prefix	+ "cy_op_cd", length));
			String[] doSplitFlg = (JSPUtil.getParameter(request, prefix	+ "do_split_flg", length));
			String[] idaImpGenMfNo = (JSPUtil.getParameter(request, prefix	+ "ida_imp_gen_mf_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] infoCgoFlg = (JSPUtil.getParameter(request, prefix	+ "info_cgo_flg", length));
			String[] idaCstmsAsgnLineNo = (JSPUtil.getParameter(request, prefix	+ "ida_cstms_asgn_line_no", length));
			String[] doHldFlg = (JSPUtil.getParameter(request, prefix	+ "do_hld_flg", length));
			String[] cstmsRefNm = (JSPUtil.getParameter(request, prefix	+ "cstms_ref_nm", length));
			String[] idaCgorOrdYr = (JSPUtil.getParameter(request, prefix	+ "ida_cgor_ord_yr", length));
			String[] cstmsAsgnCtnt = (JSPUtil.getParameter(request, prefix	+ "cstms_asgn_ctnt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] interRmk = (JSPUtil.getParameter(request, prefix	+ "inter_rmk", length));
			String[] cstmsRefCtnt = (JSPUtil.getParameter(request, prefix	+ "cstms_ref_ctnt", length));
			String[] cstmsAsgnNm = (JSPUtil.getParameter(request, prefix	+ "cstms_asgn_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			
			String[] oblIssDt = (JSPUtil.getParameter(request, prefix	+ "obl_iss_dt", length));
			String[] ibdDocRcvOfcCd = (JSPUtil.getParameter(request, prefix	+ "ibd_doc_rcv_ofc_cd", length));
			String[] oblIssTpCd = (JSPUtil.getParameter(request, prefix	+ "obl_iss_tp_cd", length));
			String[] otrDocRcvOfcCd = (JSPUtil.getParameter(request, prefix	+ "otr_doc_rcv_ofc_cd", length));
			String[] otrDocRcvUsrId = (JSPUtil.getParameter(request, prefix	+ "otr_doc_rcv_usr_id", length));
			String[] otrDocCgorFlg = (JSPUtil.getParameter(request, prefix	+ "otr_doc_cgor_flg", length));
			String[] oblRdemDt = (JSPUtil.getParameter(request, prefix	+ "obl_rdem_dt", length));
			String[] oblIssUsrId = (JSPUtil.getParameter(request, prefix	+ "obl_iss_usr_id", length));
			String[] oblCpyKnt = (JSPUtil.getParameter(request, prefix	+ "obl_cpy_knt", length));
			String[] ibdDocRcvUsrId = (JSPUtil.getParameter(request, prefix	+ "ibd_doc_rcv_usr_id", length));
			String[] ibdDocRcvDt = (JSPUtil.getParameter(request, prefix	+ "ibd_doc_rcv_dt", length));
			String[] blOtrDocRcvCd = (JSPUtil.getParameter(request, prefix	+ "bl_otr_doc_rcv_cd", length));
			String[] oblIssOfcCd = (JSPUtil.getParameter(request, prefix	+ "obl_iss_ofc_cd", length));
			String[] delCntCd = (JSPUtil.getParameter(request, prefix	+ "del_cnt_cd", length));
			String[] oblRdemFlg = (JSPUtil.getParameter(request, prefix	+ "obl_rdem_flg", length));
			String[] oblIssKnt = (JSPUtil.getParameter(request, prefix	+ "obl_iss_knt", length));
			String[] ibdDocRcvFlg = (JSPUtil.getParameter(request, prefix	+ "ibd_doc_rcv_flg", length));
			String[] otrDocRcvDt = (JSPUtil.getParameter(request, prefix	+ "otr_doc_rcv_dt", length));
			String[] oblRdemKnt = (JSPUtil.getParameter(request, prefix	+ "obl_rdem_knt", length));
			String[] oblRdemUsrId = (JSPUtil.getParameter(request, prefix	+ "obl_rdem_usr_id", length));
			String[] oblTtlKnt = (JSPUtil.getParameter(request, prefix	+ "obl_ttl_knt", length));
			String[] oblRdemUpdUsrId = (JSPUtil.getParameter(request, prefix	+ "obl_rdem_upd_usr_id", length));
			String[] oblRdemOfcCd = (JSPUtil.getParameter(request, prefix	+ "obl_rdem_ofc_cd", length));
			
			
			String[] pptRcvOfcCd = (JSPUtil.getParameter(request, prefix	+ "ppt_rcv_ofc_cd", length));
			String[] cctOtsCurrCd3 = (JSPUtil.getParameter(request, prefix	+ "cct_ots_curr_cd3", length));
			String[] cctOtsCurrCd4 = (JSPUtil.getParameter(request, prefix	+ "cct_ots_curr_cd4", length));
			String[] cctOtsCurrCd1 = (JSPUtil.getParameter(request, prefix	+ "cct_ots_curr_cd1", length));
			String[] cctOtsCurrCd2 = (JSPUtil.getParameter(request, prefix	+ "cct_ots_curr_cd2", length));
			String[] n3ptyCctRcvDt = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_rcv_dt", length));
			String[] cctOtsCurrCd5 = (JSPUtil.getParameter(request, prefix	+ "cct_ots_curr_cd5", length));
			String[] cctRcvOfcCd = (JSPUtil.getParameter(request, prefix	+ "cct_rcv_ofc_cd", length));
			String[] n3ptyPptOtsCurrCd3 = (JSPUtil.getParameter(request, prefix	+ "n3pty_ppt_ots_curr_cd3", length));
			String[] n3ptyPptOtsCurrCd4 = (JSPUtil.getParameter(request, prefix	+ "n3pty_ppt_ots_curr_cd4", length));
			String[] n3ptyPptOtsCurrCd1 = (JSPUtil.getParameter(request, prefix	+ "n3pty_ppt_ots_curr_cd1", length));
			String[] n3ptyPptOtsCurrCd2 = (JSPUtil.getParameter(request, prefix	+ "n3pty_ppt_ots_curr_cd2", length));
			String[] cctRcvDt = (JSPUtil.getParameter(request, prefix	+ "cct_rcv_dt", length));
			String[] n3ptyCctRcvOfcCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_rcv_ofc_cd", length));
			String[] n3ptyPptOtsCurrCd5 = (JSPUtil.getParameter(request, prefix	+ "n3pty_ppt_ots_curr_cd5", length));
			String[] totOtsCurrCd1 = (JSPUtil.getParameter(request, prefix	+ "tot_ots_curr_cd1", length));
			String[] totOtsCurrCd2 = (JSPUtil.getParameter(request, prefix	+ "tot_ots_curr_cd2", length));
			String[] totOtsCurrCd3 = (JSPUtil.getParameter(request, prefix	+ "tot_ots_curr_cd3", length));
			String[] totOtsCurrCd4 = (JSPUtil.getParameter(request, prefix	+ "tot_ots_curr_cd4", length));
			String[] totOtsCurrCd5 = (JSPUtil.getParameter(request, prefix	+ "tot_ots_curr_cd5", length));
			String[] n3ptyPptRcvDt = (JSPUtil.getParameter(request, prefix	+ "n3pty_ppt_rcv_dt", length));
			String[] n3ptyPptRcvUsrId = (JSPUtil.getParameter(request, prefix	+ "n3pty_ppt_rcv_usr_id", length));
			String[] n3ptyCctOtsAmt4 = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_ots_amt4", length));
			String[] n3ptyCctOtsAmt5 = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_ots_amt5", length));
			String[] pptRcvUsrId = (JSPUtil.getParameter(request, prefix	+ "ppt_rcv_usr_id", length));
			String[] n3ptyCctOtsAmt2 = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_ots_amt2", length));
			String[] n3ptyCctOtsAmt3 = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_ots_amt3", length));
			String[] n3ptyCctStsCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_sts_cd", length));
			String[] n3ptyCctOtsAmt1 = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_ots_amt1", length));
			String[] pptStsCd = (JSPUtil.getParameter(request, prefix	+ "ppt_sts_cd", length));
			String[] totOtsStsCd = (JSPUtil.getParameter(request, prefix	+ "tot_ots_sts_cd", length));
			String[] pptRcvDt = (JSPUtil.getParameter(request, prefix	+ "ppt_rcv_dt", length));
			String[] pptOtsCurrCd5 = (JSPUtil.getParameter(request, prefix	+ "ppt_ots_curr_cd5", length));
			String[] eaiResult = (JSPUtil.getParameter(request, prefix	+ "eai_result", length));
			String[] totOtsAmt1 = (JSPUtil.getParameter(request, prefix	+ "tot_ots_amt1", length));
			String[] totOtsAmt2 = (JSPUtil.getParameter(request, prefix	+ "tot_ots_amt2", length));
			String[] pptOtsCurrCd3 = (JSPUtil.getParameter(request, prefix	+ "ppt_ots_curr_cd3", length));
			String[] n3ptyPptOtsAmt5 = (JSPUtil.getParameter(request, prefix	+ "n3pty_ppt_ots_amt5", length));
			String[] pptOtsCurrCd4 = (JSPUtil.getParameter(request, prefix	+ "ppt_ots_curr_cd4", length));
			String[] n3ptyPptOtsAmt4 = (JSPUtil.getParameter(request, prefix	+ "n3pty_ppt_ots_amt4", length));
			String[] pptOtsAmt1 = (JSPUtil.getParameter(request, prefix	+ "ppt_ots_amt1", length));
			String[] pptOtsCurrCd1 = (JSPUtil.getParameter(request, prefix	+ "ppt_ots_curr_cd1", length));
			String[] n3ptyPptOtsAmt3 = (JSPUtil.getParameter(request, prefix	+ "n3pty_ppt_ots_amt3", length));
			String[] pptOtsCurrCd2 = (JSPUtil.getParameter(request, prefix	+ "ppt_ots_curr_cd2", length));
			String[] n3ptyPptOtsAmt2 = (JSPUtil.getParameter(request, prefix	+ "n3pty_ppt_ots_amt2", length));
			String[] pptOtsAmt3 = (JSPUtil.getParameter(request, prefix	+ "ppt_ots_amt3", length));
			String[] n3ptyPptOtsAmt1 = (JSPUtil.getParameter(request, prefix	+ "n3pty_ppt_ots_amt1", length));
			String[] pptOtsAmt2 = (JSPUtil.getParameter(request, prefix	+ "ppt_ots_amt2", length));
			String[] pptOtsAmt5 = (JSPUtil.getParameter(request, prefix	+ "ppt_ots_amt5", length));
			String[] pptOtsAmt4 = (JSPUtil.getParameter(request, prefix	+ "ppt_ots_amt4", length));
			String[] cctStsCd = (JSPUtil.getParameter(request, prefix	+ "cct_sts_cd", length));
			String[] n3ptyPptRcvOfcCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_ppt_rcv_ofc_cd", length));
			String[] n3ptyCctOtsCurrCd5 = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_ots_curr_cd5", length));
			String[] cctOtsAmt5 = (JSPUtil.getParameter(request, prefix	+ "cct_ots_amt5", length));
			String[] n3ptyCctOtsCurrCd2 = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_ots_curr_cd2", length));
			String[] totOtsAmt5 = (JSPUtil.getParameter(request, prefix	+ "tot_ots_amt5", length));
			String[] cctOtsAmt4 = (JSPUtil.getParameter(request, prefix	+ "cct_ots_amt4", length));
			String[] n3ptyCctOtsCurrCd1 = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_ots_curr_cd1", length));
			String[] totOtsAmt4 = (JSPUtil.getParameter(request, prefix	+ "tot_ots_amt4", length));
			String[] cctOtsAmt3 = (JSPUtil.getParameter(request, prefix	+ "cct_ots_amt3", length));
			String[] n3ptyCctOtsCurrCd4 = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_ots_curr_cd4", length));
			String[] totOtsAmt3 = (JSPUtil.getParameter(request, prefix	+ "tot_ots_amt3", length));
			String[] cctOtsAmt2 = (JSPUtil.getParameter(request, prefix	+ "cct_ots_amt2", length));
			String[] n3ptyCctOtsCurrCd3 = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_ots_curr_cd3", length));
			String[] cctOtsAmt1 = (JSPUtil.getParameter(request, prefix	+ "cct_ots_amt1", length));
			String[] cctRcvUsrId = (JSPUtil.getParameter(request, prefix	+ "cct_rcv_usr_id", length));
			String[] n3ptyCctRcvUsrId = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_rcv_usr_id", length));
			String[] n3ptyPptStsCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_ppt_sts_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new GenDoBlInfoVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (splitFlg[i] != null)
					model.setSplitFlg(splitFlg[i]);
				if (dschLoc[i] != null)
					model.setDschLoc(dschLoc[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (measUtCd[i] != null)
					model.setMeasUtCd(measUtCd[i]);
				if (oblIssRmk[i] != null)
					model.setOblIssRmk(oblIssRmk[i]);
				if (ccustAddr[i] != null)
					model.setCcustAddr(ccustAddr[i]);
				if (cntrPrtFlg[i] != null)
					model.setCntrPrtFlg(cntrPrtFlg[i]);
				if (ncustAddr[i] != null)
					model.setNcustAddr(ncustAddr[i]);
				if (scustAddr[i] != null)
					model.setScustAddr(scustAddr[i]);
				if (repCmdtNm[i] != null)
					model.setRepCmdtNm(repCmdtNm[i]);
				if (callSgnNo[i] != null)
					model.setCallSgnNo(callSgnNo[i]);
				if (scustNm[i] != null)
					model.setScustNm(scustNm[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (blTpCd[i] != null)
					model.setBlTpCd(blTpCd[i]);
				if (ncustNm[i] != null)
					model.setNcustNm(ncustNm[i]);
				if (actWgt[i] != null)
					model.setActWgt(actWgt[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (socFlg[i] != null)
					model.setSocFlg(socFlg[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (arrivalVessel[i] != null)
					model.setArrivalVessel(arrivalVessel[i]);
				if (deTermDesc[i] != null)
					model.setDeTermDesc(deTermDesc[i]);
				if (ccustNm[i] != null)
					model.setCcustNm(ccustNm[i]);
				if (lcloblissueflg[i] != null)
					model.setLcloblissueflg(lcloblissueflg[i]);
				
				
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (cyOpCd[i] != null)
					model.setCyOpCd(cyOpCd[i]);
				if (doSplitFlg[i] != null)
					model.setDoSplitFlg(doSplitFlg[i]);
				if (idaImpGenMfNo[i] != null)
					model.setIdaImpGenMfNo(idaImpGenMfNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (infoCgoFlg[i] != null)
					model.setInfoCgoFlg(infoCgoFlg[i]);
				if (idaCstmsAsgnLineNo[i] != null)
					model.setIdaCstmsAsgnLineNo(idaCstmsAsgnLineNo[i]);
				if (doHldFlg[i] != null)
					model.setDoHldFlg(doHldFlg[i]);
				if (cstmsRefNm[i] != null)
					model.setCstmsRefNm(cstmsRefNm[i]);
				if (idaCgorOrdYr[i] != null)
					model.setIdaCgorOrdYr(idaCgorOrdYr[i]);
				if (cstmsAsgnCtnt[i] != null)
					model.setCstmsAsgnCtnt(cstmsAsgnCtnt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (interRmk[i] != null)
					model.setInterRmk(interRmk[i]);
				if (cstmsRefCtnt[i] != null)
					model.setCstmsRefCtnt(cstmsRefCtnt[i]);
				if (cstmsAsgnNm[i] != null)
					model.setCstmsAsgnNm(cstmsAsgnNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				
				
				
				if (oblIssDt[i] != null)
					model.setOblIssDt(oblIssDt[i]);
				if (ibdDocRcvOfcCd[i] != null)
					model.setIbdDocRcvOfcCd(ibdDocRcvOfcCd[i]);
				if (oblIssTpCd[i] != null)
					model.setOblIssTpCd(oblIssTpCd[i]);
				if (otrDocRcvOfcCd[i] != null)
					model.setOtrDocRcvOfcCd(otrDocRcvOfcCd[i]);
				if (otrDocRcvUsrId[i] != null)
					model.setOtrDocRcvUsrId(otrDocRcvUsrId[i]);
				if (otrDocCgorFlg[i] != null)
					model.setOtrDocCgorFlg(otrDocCgorFlg[i]);
				if (oblRdemDt[i] != null)
					model.setOblRdemDt(oblRdemDt[i]);
				if (oblIssUsrId[i] != null)
					model.setOblIssUsrId(oblIssUsrId[i]);
				if (oblCpyKnt[i] != null)
					model.setOblCpyKnt(oblCpyKnt[i]);
				if (ibdDocRcvUsrId[i] != null)
					model.setIbdDocRcvUsrId(ibdDocRcvUsrId[i]);
				if (ibdDocRcvDt[i] != null)
					model.setIbdDocRcvDt(ibdDocRcvDt[i]);
				if (blOtrDocRcvCd[i] != null)
					model.setBlOtrDocRcvCd(blOtrDocRcvCd[i]);
				if (oblIssOfcCd[i] != null)
					model.setOblIssOfcCd(oblIssOfcCd[i]);
				if (delCntCd[i] != null)
					model.setDelCntCd(delCntCd[i]);
				if (oblRdemFlg[i] != null)
					model.setOblRdemFlg(oblRdemFlg[i]);
				if (oblIssKnt[i] != null)
					model.setOblIssKnt(oblIssKnt[i]);
				if (ibdDocRcvFlg[i] != null)
					model.setIbdDocRcvFlg(ibdDocRcvFlg[i]);
				if (otrDocRcvDt[i] != null)
					model.setOtrDocRcvDt(otrDocRcvDt[i]);
				if (oblRdemKnt[i] != null)
					model.setOblRdemKnt(oblRdemKnt[i]);
				if (oblRdemUsrId[i] != null)
					model.setOblRdemUsrId(oblRdemUsrId[i]);
				if (oblTtlKnt[i] != null)
					model.setOblTtlKnt(oblTtlKnt[i]);
				if (oblRdemUpdUsrId[i] != null)
					model.setOblRdemUpdUsrId(oblRdemUpdUsrId[i]);
				if (oblRdemOfcCd[i] != null)
					model.setOblRdemOfcCd(oblRdemOfcCd[i]);

				
				if (pptRcvOfcCd[i] != null)
					model.setPptRcvOfcCd(pptRcvOfcCd[i]);
				if (cctOtsCurrCd3[i] != null)
					model.setCctOtsCurrCd3(cctOtsCurrCd3[i]);
				if (cctOtsCurrCd4[i] != null)
					model.setCctOtsCurrCd4(cctOtsCurrCd4[i]);
				if (cctOtsCurrCd1[i] != null)
					model.setCctOtsCurrCd1(cctOtsCurrCd1[i]);
				if (cctOtsCurrCd2[i] != null)
					model.setCctOtsCurrCd2(cctOtsCurrCd2[i]);
				if (n3ptyCctRcvDt[i] != null)
					model.setN3ptyCctRcvDt(n3ptyCctRcvDt[i]);
				if (cctOtsCurrCd5[i] != null)
					model.setCctOtsCurrCd5(cctOtsCurrCd5[i]);
				if (cctRcvOfcCd[i] != null)
					model.setCctRcvOfcCd(cctRcvOfcCd[i]);
				if (n3ptyPptOtsCurrCd3[i] != null)
					model.setN3ptyPptOtsCurrCd3(n3ptyPptOtsCurrCd3[i]);
				if (n3ptyPptOtsCurrCd4[i] != null)
					model.setN3ptyPptOtsCurrCd4(n3ptyPptOtsCurrCd4[i]);
				if (n3ptyPptOtsCurrCd1[i] != null)
					model.setN3ptyPptOtsCurrCd1(n3ptyPptOtsCurrCd1[i]);
				if (n3ptyPptOtsCurrCd2[i] != null)
					model.setN3ptyPptOtsCurrCd2(n3ptyPptOtsCurrCd2[i]);
				if (cctRcvDt[i] != null)
					model.setCctRcvDt(cctRcvDt[i]);
				if (n3ptyCctRcvOfcCd[i] != null)
					model.setN3ptyCctRcvOfcCd(n3ptyCctRcvOfcCd[i]);
				if (n3ptyPptOtsCurrCd5[i] != null)
					model.setN3ptyPptOtsCurrCd5(n3ptyPptOtsCurrCd5[i]);
				if (totOtsCurrCd1[i] != null)
					model.setTotOtsCurrCd1(totOtsCurrCd1[i]);
				if (totOtsCurrCd2[i] != null)
					model.setTotOtsCurrCd2(totOtsCurrCd2[i]);
				if (totOtsCurrCd3[i] != null)
					model.setTotOtsCurrCd3(totOtsCurrCd3[i]);
				if (totOtsCurrCd4[i] != null)
					model.setTotOtsCurrCd4(totOtsCurrCd4[i]);
				if (totOtsCurrCd5[i] != null)
					model.setTotOtsCurrCd5(totOtsCurrCd5[i]);
				if (n3ptyPptRcvDt[i] != null)
					model.setN3ptyPptRcvDt(n3ptyPptRcvDt[i]);
				if (n3ptyPptRcvUsrId[i] != null)
					model.setN3ptyPptRcvUsrId(n3ptyPptRcvUsrId[i]);
				if (n3ptyCctOtsAmt4[i] != null)
					model.setN3ptyCctOtsAmt4(n3ptyCctOtsAmt4[i]);
				if (n3ptyCctOtsAmt5[i] != null)
					model.setN3ptyCctOtsAmt5(n3ptyCctOtsAmt5[i]);
				if (pptRcvUsrId[i] != null)
					model.setPptRcvUsrId(pptRcvUsrId[i]);
				if (n3ptyCctOtsAmt2[i] != null)
					model.setN3ptyCctOtsAmt2(n3ptyCctOtsAmt2[i]);
				if (n3ptyCctOtsAmt3[i] != null)
					model.setN3ptyCctOtsAmt3(n3ptyCctOtsAmt3[i]);
				if (n3ptyCctStsCd[i] != null)
					model.setN3ptyCctStsCd(n3ptyCctStsCd[i]);
				if (n3ptyCctOtsAmt1[i] != null)
					model.setN3ptyCctOtsAmt1(n3ptyCctOtsAmt1[i]);
				if (pptStsCd[i] != null)
					model.setPptStsCd(pptStsCd[i]);
				if (totOtsStsCd[i] != null)
					model.setTotOtsStsCd(totOtsStsCd[i]);
				if (pptRcvDt[i] != null)
					model.setPptRcvDt(pptRcvDt[i]);
				if (pptOtsCurrCd5[i] != null)
					model.setPptOtsCurrCd5(pptOtsCurrCd5[i]);
				if (eaiResult[i] != null)
					model.setEaiResult(eaiResult[i]);
				if (totOtsAmt1[i] != null)
					model.setTotOtsAmt1(totOtsAmt1[i]);
				if (totOtsAmt2[i] != null)
					model.setTotOtsAmt2(totOtsAmt2[i]);
				if (pptOtsCurrCd3[i] != null)
					model.setPptOtsCurrCd3(pptOtsCurrCd3[i]);
				if (n3ptyPptOtsAmt5[i] != null)
					model.setN3ptyPptOtsAmt5(n3ptyPptOtsAmt5[i]);
				if (pptOtsCurrCd4[i] != null)
					model.setPptOtsCurrCd4(pptOtsCurrCd4[i]);
				if (n3ptyPptOtsAmt4[i] != null)
					model.setN3ptyPptOtsAmt4(n3ptyPptOtsAmt4[i]);
				if (pptOtsAmt1[i] != null)
					model.setPptOtsAmt1(pptOtsAmt1[i]);
				if (pptOtsCurrCd1[i] != null)
					model.setPptOtsCurrCd1(pptOtsCurrCd1[i]);
				if (n3ptyPptOtsAmt3[i] != null)
					model.setN3ptyPptOtsAmt3(n3ptyPptOtsAmt3[i]);
				if (pptOtsCurrCd2[i] != null)
					model.setPptOtsCurrCd2(pptOtsCurrCd2[i]);
				if (n3ptyPptOtsAmt2[i] != null)
					model.setN3ptyPptOtsAmt2(n3ptyPptOtsAmt2[i]);
				if (pptOtsAmt3[i] != null)
					model.setPptOtsAmt3(pptOtsAmt3[i]);
				if (n3ptyPptOtsAmt1[i] != null)
					model.setN3ptyPptOtsAmt1(n3ptyPptOtsAmt1[i]);
				if (pptOtsAmt2[i] != null)
					model.setPptOtsAmt2(pptOtsAmt2[i]);
				if (pptOtsAmt5[i] != null)
					model.setPptOtsAmt5(pptOtsAmt5[i]);
				if (pptOtsAmt4[i] != null)
					model.setPptOtsAmt4(pptOtsAmt4[i]);
				if (cctStsCd[i] != null)
					model.setCctStsCd(cctStsCd[i]);
				if (n3ptyPptRcvOfcCd[i] != null)
					model.setN3ptyPptRcvOfcCd(n3ptyPptRcvOfcCd[i]);
				if (n3ptyCctOtsCurrCd5[i] != null)
					model.setN3ptyCctOtsCurrCd5(n3ptyCctOtsCurrCd5[i]);
				if (cctOtsAmt5[i] != null)
					model.setCctOtsAmt5(cctOtsAmt5[i]);
				if (n3ptyCctOtsCurrCd2[i] != null)
					model.setN3ptyCctOtsCurrCd2(n3ptyCctOtsCurrCd2[i]);
				if (totOtsAmt5[i] != null)
					model.setTotOtsAmt5(totOtsAmt5[i]);
				if (cctOtsAmt4[i] != null)
					model.setCctOtsAmt4(cctOtsAmt4[i]);
				if (n3ptyCctOtsCurrCd1[i] != null)
					model.setN3ptyCctOtsCurrCd1(n3ptyCctOtsCurrCd1[i]);
				if (totOtsAmt4[i] != null)
					model.setTotOtsAmt4(totOtsAmt4[i]);
				if (cctOtsAmt3[i] != null)
					model.setCctOtsAmt3(cctOtsAmt3[i]);
				if (n3ptyCctOtsCurrCd4[i] != null)
					model.setN3ptyCctOtsCurrCd4(n3ptyCctOtsCurrCd4[i]);
				if (totOtsAmt3[i] != null)
					model.setTotOtsAmt3(totOtsAmt3[i]);
				if (cctOtsAmt2[i] != null)
					model.setCctOtsAmt2(cctOtsAmt2[i]);
				if (n3ptyCctOtsCurrCd3[i] != null)
					model.setN3ptyCctOtsCurrCd3(n3ptyCctOtsCurrCd3[i]);
				if (cctOtsAmt1[i] != null)
					model.setCctOtsAmt1(cctOtsAmt1[i]);
				if (cctRcvUsrId[i] != null)
					model.setCctRcvUsrId(cctRcvUsrId[i]);
				if (n3ptyCctRcvUsrId[i] != null)
					model.setN3ptyCctRcvUsrId(n3ptyCctRcvUsrId[i]);
				if (n3ptyPptStsCd[i] != null)
					model.setN3ptyPptStsCd(n3ptyPptStsCd[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGenDoBlInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GenDoBlInfoVO[]
	 */
	public GenDoBlInfoVO[] getGenDoBlInfoVOs(){
		GenDoBlInfoVO[] vos = (GenDoBlInfoVO[])models.toArray(new GenDoBlInfoVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splitFlg = this.splitFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dschLoc = this.dschLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssRmk = this.oblIssRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ccustAddr = this.ccustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPrtFlg = this.cntrPrtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ncustAddr = this.ncustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scustAddr = this.scustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtNm = this.repCmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSgnNo = this.callSgnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scustNm = this.scustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTpCd = this.blTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ncustNm = this.ncustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWgt = this.actWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socFlg = this.socFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrivalVessel = this.arrivalVessel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermDesc = this.deTermDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ccustNm = this.ccustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lcloblissueflg = this.lcloblissueflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cyOpCd = this.cyOpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doSplitFlg = this.doSplitFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaImpGenMfNo = this.idaImpGenMfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.infoCgoFlg = this.infoCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaCstmsAsgnLineNo = this.idaCstmsAsgnLineNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doHldFlg = this.doHldFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsRefNm = this.cstmsRefNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaCgorOrdYr = this.idaCgorOrdYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsAsgnCtnt = this.cstmsAsgnCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interRmk = this.interRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsRefCtnt = this.cstmsRefCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsAsgnNm = this.cstmsAsgnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		
		this.oblIssDt = this.oblIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdDocRcvOfcCd = this.ibdDocRcvOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssTpCd = this.oblIssTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otrDocRcvOfcCd = this.otrDocRcvOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otrDocRcvUsrId = this.otrDocRcvUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otrDocCgorFlg = this.otrDocCgorFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRdemDt = this.oblRdemDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssUsrId = this.oblIssUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblCpyKnt = this.oblCpyKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdDocRcvUsrId = this.ibdDocRcvUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdDocRcvDt = this.ibdDocRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blOtrDocRcvCd = this.blOtrDocRcvCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssOfcCd = this.oblIssOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCntCd = this.delCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRdemFlg = this.oblRdemFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssKnt = this.oblIssKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdDocRcvFlg = this.ibdDocRcvFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otrDocRcvDt = this.otrDocRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRdemKnt = this.oblRdemKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRdemUsrId = this.oblRdemUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblTtlKnt = this.oblTtlKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRdemUpdUsrId = this.oblRdemUpdUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRdemOfcCd = this.oblRdemOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		
		this.pptRcvOfcCd = this.pptRcvOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctOtsCurrCd3 = this.cctOtsCurrCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctOtsCurrCd4 = this.cctOtsCurrCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctOtsCurrCd1 = this.cctOtsCurrCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctOtsCurrCd2 = this.cctOtsCurrCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctRcvDt = this.n3ptyCctRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctOtsCurrCd5 = this.cctOtsCurrCd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctRcvOfcCd = this.cctRcvOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyPptOtsCurrCd3 = this.n3ptyPptOtsCurrCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyPptOtsCurrCd4 = this.n3ptyPptOtsCurrCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyPptOtsCurrCd1 = this.n3ptyPptOtsCurrCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyPptOtsCurrCd2 = this.n3ptyPptOtsCurrCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctRcvDt = this.cctRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctRcvOfcCd = this.n3ptyCctRcvOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyPptOtsCurrCd5 = this.n3ptyPptOtsCurrCd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOtsCurrCd1 = this.totOtsCurrCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOtsCurrCd2 = this.totOtsCurrCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOtsCurrCd3 = this.totOtsCurrCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOtsCurrCd4 = this.totOtsCurrCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOtsCurrCd5 = this.totOtsCurrCd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyPptRcvDt = this.n3ptyPptRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyPptRcvUsrId = this.n3ptyPptRcvUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctOtsAmt4 = this.n3ptyCctOtsAmt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctOtsAmt5 = this.n3ptyCctOtsAmt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pptRcvUsrId = this.pptRcvUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctOtsAmt2 = this.n3ptyCctOtsAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctOtsAmt3 = this.n3ptyCctOtsAmt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctStsCd = this.n3ptyCctStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctOtsAmt1 = this.n3ptyCctOtsAmt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pptStsCd = this.pptStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOtsStsCd = this.totOtsStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pptRcvDt = this.pptRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pptOtsCurrCd5 = this.pptOtsCurrCd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiResult = this.eaiResult .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOtsAmt1 = this.totOtsAmt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOtsAmt2 = this.totOtsAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pptOtsCurrCd3 = this.pptOtsCurrCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyPptOtsAmt5 = this.n3ptyPptOtsAmt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pptOtsCurrCd4 = this.pptOtsCurrCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyPptOtsAmt4 = this.n3ptyPptOtsAmt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pptOtsAmt1 = this.pptOtsAmt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pptOtsCurrCd1 = this.pptOtsCurrCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyPptOtsAmt3 = this.n3ptyPptOtsAmt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pptOtsCurrCd2 = this.pptOtsCurrCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyPptOtsAmt2 = this.n3ptyPptOtsAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pptOtsAmt3 = this.pptOtsAmt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyPptOtsAmt1 = this.n3ptyPptOtsAmt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pptOtsAmt2 = this.pptOtsAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pptOtsAmt5 = this.pptOtsAmt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pptOtsAmt4 = this.pptOtsAmt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctStsCd = this.cctStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyPptRcvOfcCd = this.n3ptyPptRcvOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctOtsCurrCd5 = this.n3ptyCctOtsCurrCd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctOtsAmt5 = this.cctOtsAmt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctOtsCurrCd2 = this.n3ptyCctOtsCurrCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOtsAmt5 = this.totOtsAmt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctOtsAmt4 = this.cctOtsAmt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctOtsCurrCd1 = this.n3ptyCctOtsCurrCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOtsAmt4 = this.totOtsAmt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctOtsAmt3 = this.cctOtsAmt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctOtsCurrCd4 = this.n3ptyCctOtsCurrCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOtsAmt3 = this.totOtsAmt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctOtsAmt2 = this.cctOtsAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctOtsCurrCd3 = this.n3ptyCctOtsCurrCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctOtsAmt1 = this.cctOtsAmt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctRcvUsrId = this.cctRcvUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctRcvUsrId = this.n3ptyCctRcvUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyPptStsCd = this.n3ptyPptStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
