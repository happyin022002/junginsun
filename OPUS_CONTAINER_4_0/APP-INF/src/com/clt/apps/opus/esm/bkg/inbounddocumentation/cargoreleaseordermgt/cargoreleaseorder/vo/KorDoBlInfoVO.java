/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KorDoBlInfoVO.java
*@FileTitle : KorDoBlInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.12
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.12  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

import java.lang.reflect.Field;
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

public class KorDoBlInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorDoBlInfoVO> models = new ArrayList<KorDoBlInfoVO>();
	
	/* Column Info */
	private String pptRcvOfcCd = null;
	/* Column Info */
	private String n3ptyCctRcvDt = null;
	/* Column Info */
	private String oblIssDt = null;
	/* Column Info */
	private String doHldFlg = null;
	/* Column Info */
	private String ibdDocRcvOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String oblRdemDt = null;
	/* Column Info */
	private String oblCpyKnt = null;
	/* Column Info */
	private String ibdDocRcvUsrId = null;
	/* Column Info */
	private String oblIssRmk = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String oblIssOfcCd = null;
	/* Column Info */
	private String cntrPrtFlg = null;
	/* Column Info */
	private String ncustAddr = null;
	/* Column Info */
	private String scustAddr = null;
	/* Column Info */
	private String callSgnNo = null;
	/* Column Info */
	private String doIssue = null;
	/* Column Info */
	private String n3ptyCctRcvOfcCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String cstmsClrLocCd = null;
	/* Column Info */
	private String totOtsCurrCd1 = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String totOtsCurrCd2 = null;
	/* Column Info */
	private String totOtsCurrCd3 = null;
	/* Column Info */
	private String totOtsCurrCd4 = null;
	/* Column Info */
	private String oblRdemUsrId = null;
	/* Column Info */
	private String totOtsCurrCd5 = null;
	/* Column Info */
	private String n3ptyPptRcvDt = null;
	/* Column Info */
	private String n3ptyPptRcvUsrId = null;
	/* Column Info */
	private String oblTtlKnt = null;
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
	private String idaImpGenMfNo = null;
	/* Column Info */
	private String dschLoc = null;
	/* Column Info */
	private String mfRefNo = null;
	/* Column Info */
	private String cstmsRefNm = null;
	/* Column Info */
	private String totOtsStsCd = null;
	/* Column Info */
	private String otrDocRcvUsrId = null;
	/* Column Info */
	private String pptRcvDt = null;
	/* Column Info */
	private String interRmk = null;
	/* Column Info */
	private String otrDocCgorFlg = null;
	/* Column Info */
	private String cstmsClrTpCd = null;
	/* Column Info */
	private String msPtyRgstNo = null;
	/* Column Info */
	private String prPtyRgstNo = null;	
	/* Column Info */
	private String attorneyValChk = null;	
	/* Column Info */
	private String cstmsAsgnNm = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String measUtCd = null;
	/* Column Info */
	private String blOtrDocRcvCd = null;
	/* Column Info */
	private String edoRqstSeq5jn = null;
	/* Column Info */
	private String edoRqstSeq5jm = null;
	/* Column Info */
	private String n3ptyCctOtsCurrCd5 = null;
	/* Column Info */
	private String cctStsCd = null;
	/* Column Info */
	private String doSplitFlg = null;
	/* Column Info */
	private String n3ptyCctOtsCurrCd2 = null;
	/* Column Info */
	private String n3ptyCctOtsCurrCd1 = null;
	/* Column Info */
	private String n3ptyCctOtsCurrCd4 = null;
	/* Column Info */
	private String ibdDocRcvFlg = null;
	/* Column Info */
	private String n3ptyCctOtsCurrCd3 = null;
	/* Column Info */
	private String idaCstmsAsgnLineNo = null;
	/* Column Info */
	private String edoRqstSeq5jk = null;
	/* Column Info */
	private String ncustNm = null;
	/* Column Info */
	private String otrDocRcvDt = null;
	/* Column Info */
	private String oblRdemKnt = null;
	/* Column Info */
	private String n3ptyCctRcvUsrId = null;
	/* Column Info */
	private String cctRcvUsrId = null;
	/* Column Info */
	private String bondedTransportation = null;
	/* Column Info */
	private String oblRdemUpdUsrId = null;
	/* Column Info */
	private String selfTransportation = null;
	/* Column Info */
	private String cstmsDchgLocWhCd = null;
	/* Column Info */
	private String cctOtsCurrCd3 = null;
	/* Column Info */
	private String cctOtsCurrCd4 = null;
	/* Column Info */
	private String cctOtsCurrCd1 = null;
	/* Column Info */
	private String cctOtsCurrCd2 = null;
	/* Column Info */
	private String cctOtsCurrCd5 = null;
	/* Column Info */
	private String bondedEdoAckCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String cctRcvOfcCd = null;
	/* Column Info */
	private String oblIssUsrId = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String cstmsClrWhCd = null;
	/* Column Info */
	private String ccustAddr = null;
	/* Column Info */
	private String repCmdtNm = null;
	/* Column Info */
	private String delCntCd = null;
	/* Column Info */
	private String scustNm = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String oblRdemFlg = null;
	/* Column Info */
	private String cctRcvDt = null;
	/* Column Info */
	private String locNm = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String edoRqstNo = null;
	/* Column Info */
	private String deTermDesc = null;
	/* Column Info */
	private String mfSeqNo = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String splitFlg = null;
	/* Column Info */
	private String cyOpCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String pptStsCd = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Column Info */
	private String oblIssTpCd = null;
	/* Column Info */
	private String otrDocRcvOfcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String totOtsAmt1 = null;
	/* Column Info */
	private String totOtsAmt2 = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String ibdDocRcvDt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String n3ptyPptRcvOfcCd = null;
	/* Column Info */
	private String selfEdoAckCd = null;
	/* Column Info */
	private String cctOtsAmt5 = null;
	/* Column Info */
	private String infoCgoFlg = null;
	/* Column Info */
	private String cctOtsAmt4 = null;
	/* Column Info */
	private String totOtsAmt5 = null;
	/* Column Info */
	private String oblIssKnt = null;
	/* Column Info */
	private String cctOtsAmt3 = null;
	/* Column Info */
	private String totOtsAmt4 = null;
	/* Column Info */
	private String cctOtsAmt2 = null;
	/* Column Info */
	private String totOtsAmt3 = null;
	/* Column Info */
	private String cctOtsAmt1 = null;
	/* Column Info */
	private String actWgt = null;
	/* Column Info */
	private String whNm = null;
	/* Column Info */
	private String blTpCd = null;
	/* Column Info */
	private String idaCgorOrdYr = null;
	/* Column Info */
	private String socFlg = null;
	/* Column Info */
	private String cstmsAsgnCtnt = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String cstmsRefCtnt = null;
	/* Column Info */
	private String doEdoAckCd = null;
	/* Column Info */
	private String arrivalVessel = null;
	/* Column Info */
	private String ccustNm = null;
	/* Column Info */
	private String n3ptyPptStsCd = null;
	/* Column Info */
	private String oblRdemOfcCd = null;
	/* E-D/O Result 에 err 건 이 있는지 여부 */
	private String errFlg = null;

	private String lcloblissueflg = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KorDoBlInfoVO() {}

	public KorDoBlInfoVO(String ibflag, String pagerows, String bkgNo, String blNo, String porCd, String polCd, String podCd, String delCd, String deTermCd, String deTermDesc, String arrivalVessel, String vpsEtaDt, String pckQty, String pckTpCd, String actWgt, String wgtUtCd, String measQty, String measUtCd, String socFlg, String splitFlg, String repCmdtNm, String dschLoc, String cntrPrtFlg, String ccustNm, String ccustAddr, String ncustNm, String ncustAddr, String scustNm, String scustAddr, String callSgnNo, String oblIssRmk, String cstmsRefNm, String cstmsRefCtnt, String cstmsAsgnNm, String cstmsAsgnCtnt, String interRmk, String doHldFlg, String creUsrId, String creDt, String updUsrId, String updDt, String infoCgoFlg, String idaImpGenMfNo, String idaCgorOrdYr, String idaCstmsAsgnLineNo, String doSplitFlg, String cyOpCd, String mfRefNo, String mfSeqNo, String cstmsClrTpCd, String cstmsClrLocCd, String cstmsClrWhCd, String cstmsDchgLocWhCd, String locNm, String whNm, String oblIssDt, String oblIssOfcCd, String oblIssUsrId, String oblIssTpCd, String oblIssKnt, String oblRdemOfcCd, String oblRdemUsrId, String oblRdemUpdUsrId, String oblRdemDt, String oblRdemKnt, String otrDocCgorFlg, String blOtrDocRcvCd, String otrDocRcvOfcCd, String otrDocRcvUsrId, String otrDocRcvDt, String ibdDocRcvFlg, String ibdDocRcvOfcCd, String ibdDocRcvUsrId, String ibdDocRcvDt, String oblTtlKnt, String oblCpyKnt, String blTpCd, String delCntCd, String oblRdemFlg, String edoRqstNo, String edoRqstSeq5jn, String edoRqstSeq5jm, String edoRqstSeq5jk, String doIssue, String doEdoAckCd, String selfTransportation, String selfEdoAckCd, String bondedTransportation, String bondedEdoAckCd, String msPtyRgstNo,String prPtyRgstNo,String attorneyValChk, String totOtsStsCd, String totOtsCurrCd1, String totOtsCurrCd2, String totOtsCurrCd3, String totOtsCurrCd4, String totOtsCurrCd5, String totOtsAmt1, String totOtsAmt2, String totOtsAmt3, String totOtsAmt4, String totOtsAmt5, String pptStsCd, String pptRcvOfcCd, String pptRcvUsrId, String pptRcvDt, String cctStsCd, String cctRcvOfcCd, String cctRcvUsrId, String cctRcvDt, String cctOtsCurrCd1, String cctOtsCurrCd2, String cctOtsCurrCd3, String cctOtsCurrCd4, String cctOtsCurrCd5, String cctOtsAmt1, String cctOtsAmt2, String cctOtsAmt3, String cctOtsAmt4, String cctOtsAmt5, String n3ptyPptStsCd, String n3ptyPptRcvOfcCd, String n3ptyPptRcvUsrId, String n3ptyPptRcvDt, String n3ptyCctStsCd, String n3ptyCctRcvOfcCd, String n3ptyCctRcvUsrId, String n3ptyCctRcvDt, String n3ptyCctOtsCurrCd1, String n3ptyCctOtsCurrCd2, String n3ptyCctOtsCurrCd3, String n3ptyCctOtsCurrCd4, String n3ptyCctOtsCurrCd5, String n3ptyCctOtsAmt1, String n3ptyCctOtsAmt2, String n3ptyCctOtsAmt3, String n3ptyCctOtsAmt4, String n3ptyCctOtsAmt5, String errFlg, String lcloblissueflg) {
		this.pptRcvOfcCd = pptRcvOfcCd;
		this.n3ptyCctRcvDt = n3ptyCctRcvDt;
		this.oblIssDt = oblIssDt;
		this.doHldFlg = doHldFlg;
		this.ibdDocRcvOfcCd = ibdDocRcvOfcCd;
		this.pagerows = pagerows;
		this.oblRdemDt = oblRdemDt;
		this.oblCpyKnt = oblCpyKnt;
		this.ibdDocRcvUsrId = ibdDocRcvUsrId;
		this.oblIssRmk = oblIssRmk;
		this.updUsrId = updUsrId;
		this.oblIssOfcCd = oblIssOfcCd;
		this.cntrPrtFlg = cntrPrtFlg;
		this.ncustAddr = ncustAddr;
		this.scustAddr = scustAddr;
		this.callSgnNo = callSgnNo;
		this.doIssue = doIssue;
		this.n3ptyCctRcvOfcCd = n3ptyCctRcvOfcCd;
		this.podCd = podCd;
		this.cstmsClrLocCd = cstmsClrLocCd;
		this.totOtsCurrCd1 = totOtsCurrCd1;
		this.bkgNo = bkgNo;
		this.totOtsCurrCd2 = totOtsCurrCd2;
		this.totOtsCurrCd3 = totOtsCurrCd3;
		this.totOtsCurrCd4 = totOtsCurrCd4;
		this.oblRdemUsrId = oblRdemUsrId;
		this.totOtsCurrCd5 = totOtsCurrCd5;
		this.n3ptyPptRcvDt = n3ptyPptRcvDt;
		this.n3ptyPptRcvUsrId = n3ptyPptRcvUsrId;
		this.oblTtlKnt = oblTtlKnt;
		this.n3ptyCctOtsAmt4 = n3ptyCctOtsAmt4;
		this.n3ptyCctOtsAmt5 = n3ptyCctOtsAmt5;
		this.pptRcvUsrId = pptRcvUsrId;
		this.n3ptyCctOtsAmt2 = n3ptyCctOtsAmt2;
		this.n3ptyCctOtsAmt3 = n3ptyCctOtsAmt3;
		this.n3ptyCctStsCd = n3ptyCctStsCd;
		this.n3ptyCctOtsAmt1 = n3ptyCctOtsAmt1;
		this.idaImpGenMfNo = idaImpGenMfNo;
		this.dschLoc = dschLoc;
		this.mfRefNo = mfRefNo;
		this.cstmsRefNm = cstmsRefNm;
		this.totOtsStsCd = totOtsStsCd;
		this.otrDocRcvUsrId = otrDocRcvUsrId;
		this.pptRcvDt = pptRcvDt;
		this.interRmk = interRmk;
		this.otrDocCgorFlg = otrDocCgorFlg;
		this.cstmsClrTpCd = cstmsClrTpCd;
		this.msPtyRgstNo = msPtyRgstNo;
		this.prPtyRgstNo = prPtyRgstNo;
		this.attorneyValChk = attorneyValChk;		
		this.cstmsAsgnNm = cstmsAsgnNm;
		this.pckTpCd = pckTpCd;
		this.measUtCd = measUtCd;
		this.blOtrDocRcvCd = blOtrDocRcvCd;
		this.edoRqstSeq5jn = edoRqstSeq5jn;
		this.edoRqstSeq5jm = edoRqstSeq5jm;
		this.n3ptyCctOtsCurrCd5 = n3ptyCctOtsCurrCd5;
		this.cctStsCd = cctStsCd;
		this.doSplitFlg = doSplitFlg;
		this.n3ptyCctOtsCurrCd2 = n3ptyCctOtsCurrCd2;
		this.n3ptyCctOtsCurrCd1 = n3ptyCctOtsCurrCd1;
		this.n3ptyCctOtsCurrCd4 = n3ptyCctOtsCurrCd4;
		this.ibdDocRcvFlg = ibdDocRcvFlg;
		this.n3ptyCctOtsCurrCd3 = n3ptyCctOtsCurrCd3;
		this.idaCstmsAsgnLineNo = idaCstmsAsgnLineNo;
		this.edoRqstSeq5jk = edoRqstSeq5jk;
		this.ncustNm = ncustNm;
		this.otrDocRcvDt = otrDocRcvDt;
		this.oblRdemKnt = oblRdemKnt;
		this.n3ptyCctRcvUsrId = n3ptyCctRcvUsrId;
		this.cctRcvUsrId = cctRcvUsrId;
		this.bondedTransportation = bondedTransportation;
		this.oblRdemUpdUsrId = oblRdemUpdUsrId;
		this.selfTransportation = selfTransportation;
		this.cstmsDchgLocWhCd = cstmsDchgLocWhCd;
		this.cctOtsCurrCd3 = cctOtsCurrCd3;
		this.cctOtsCurrCd4 = cctOtsCurrCd4;
		this.cctOtsCurrCd1 = cctOtsCurrCd1;
		this.cctOtsCurrCd2 = cctOtsCurrCd2;
		this.cctOtsCurrCd5 = cctOtsCurrCd5;
		this.bondedEdoAckCd = bondedEdoAckCd;
		this.blNo = blNo;
		this.polCd = polCd;
		this.cctRcvOfcCd = cctRcvOfcCd;
		this.oblIssUsrId = oblIssUsrId;
		this.wgtUtCd = wgtUtCd;
		this.cstmsClrWhCd = cstmsClrWhCd;
		this.ccustAddr = ccustAddr;
		this.repCmdtNm = repCmdtNm;
		this.delCntCd = delCntCd;
		this.scustNm = scustNm;
		this.delCd = delCd;
		this.oblRdemFlg = oblRdemFlg;
		this.cctRcvDt = cctRcvDt;
		this.locNm = locNm;
		this.creUsrId = creUsrId;
		this.edoRqstNo = edoRqstNo;
		this.deTermDesc = deTermDesc;
		this.mfSeqNo = mfSeqNo;
		this.porCd = porCd;
		this.splitFlg = splitFlg;
		this.cyOpCd = cyOpCd;
		this.creDt = creDt;
		this.pptStsCd = pptStsCd;
		this.vpsEtaDt = vpsEtaDt;
		this.oblIssTpCd = oblIssTpCd;
		this.otrDocRcvOfcCd = otrDocRcvOfcCd;
		this.ibflag = ibflag;
		this.totOtsAmt1 = totOtsAmt1;
		this.totOtsAmt2 = totOtsAmt2;
		this.measQty = measQty;
		this.pckQty = pckQty;
		this.ibdDocRcvDt = ibdDocRcvDt;
		this.updDt = updDt;
		this.n3ptyPptRcvOfcCd = n3ptyPptRcvOfcCd;
		this.selfEdoAckCd = selfEdoAckCd;
		this.cctOtsAmt5 = cctOtsAmt5;
		this.infoCgoFlg = infoCgoFlg;
		this.cctOtsAmt4 = cctOtsAmt4;
		this.totOtsAmt5 = totOtsAmt5;
		this.oblIssKnt = oblIssKnt;
		this.cctOtsAmt3 = cctOtsAmt3;
		this.totOtsAmt4 = totOtsAmt4;
		this.cctOtsAmt2 = cctOtsAmt2;
		this.totOtsAmt3 = totOtsAmt3;
		this.cctOtsAmt1 = cctOtsAmt1;
		this.actWgt = actWgt;
		this.whNm = whNm;
		this.blTpCd = blTpCd;
		this.idaCgorOrdYr = idaCgorOrdYr;
		this.socFlg = socFlg;
		this.cstmsAsgnCtnt = cstmsAsgnCtnt;
		this.deTermCd = deTermCd;
		this.cstmsRefCtnt = cstmsRefCtnt;
		this.doEdoAckCd = doEdoAckCd;
		this.arrivalVessel = arrivalVessel;
		this.ccustNm = ccustNm;
		this.n3ptyPptStsCd = n3ptyPptStsCd;
		this.oblRdemOfcCd = oblRdemOfcCd;
		this.errFlg = errFlg;		
		this.lcloblissueflg = lcloblissueflg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ppt_rcv_ofc_cd", getPptRcvOfcCd());
		this.hashColumns.put("n3pty_cct_rcv_dt", getN3ptyCctRcvDt());
		this.hashColumns.put("obl_iss_dt", getOblIssDt());
		this.hashColumns.put("do_hld_flg", getDoHldFlg());
		this.hashColumns.put("ibd_doc_rcv_ofc_cd", getIbdDocRcvOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("obl_rdem_dt", getOblRdemDt());
		this.hashColumns.put("obl_cpy_knt", getOblCpyKnt());
		this.hashColumns.put("ibd_doc_rcv_usr_id", getIbdDocRcvUsrId());
		this.hashColumns.put("obl_iss_rmk", getOblIssRmk());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("obl_iss_ofc_cd", getOblIssOfcCd());
		this.hashColumns.put("cntr_prt_flg", getCntrPrtFlg());
		this.hashColumns.put("ncust_addr", getNcustAddr());
		this.hashColumns.put("scust_addr", getScustAddr());
		this.hashColumns.put("call_sgn_no", getCallSgnNo());
		this.hashColumns.put("do_issue", getDoIssue());
		this.hashColumns.put("n3pty_cct_rcv_ofc_cd", getN3ptyCctRcvOfcCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cstms_clr_loc_cd", getCstmsClrLocCd());
		this.hashColumns.put("tot_ots_curr_cd1", getTotOtsCurrCd1());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("tot_ots_curr_cd2", getTotOtsCurrCd2());
		this.hashColumns.put("tot_ots_curr_cd3", getTotOtsCurrCd3());
		this.hashColumns.put("tot_ots_curr_cd4", getTotOtsCurrCd4());
		this.hashColumns.put("obl_rdem_usr_id", getOblRdemUsrId());
		this.hashColumns.put("tot_ots_curr_cd5", getTotOtsCurrCd5());
		this.hashColumns.put("n3pty_ppt_rcv_dt", getN3ptyPptRcvDt());
		this.hashColumns.put("n3pty_ppt_rcv_usr_id", getN3ptyPptRcvUsrId());
		this.hashColumns.put("obl_ttl_knt", getOblTtlKnt());
		this.hashColumns.put("n3pty_cct_ots_amt4", getN3ptyCctOtsAmt4());
		this.hashColumns.put("n3pty_cct_ots_amt5", getN3ptyCctOtsAmt5());
		this.hashColumns.put("ppt_rcv_usr_id", getPptRcvUsrId());
		this.hashColumns.put("n3pty_cct_ots_amt2", getN3ptyCctOtsAmt2());
		this.hashColumns.put("n3pty_cct_ots_amt3", getN3ptyCctOtsAmt3());
		this.hashColumns.put("n3pty_cct_sts_cd", getN3ptyCctStsCd());
		this.hashColumns.put("n3pty_cct_ots_amt1", getN3ptyCctOtsAmt1());
		this.hashColumns.put("ida_imp_gen_mf_no", getIdaImpGenMfNo());
		this.hashColumns.put("dsch_loc", getDschLoc());
		this.hashColumns.put("mf_ref_no", getMfRefNo());
		this.hashColumns.put("cstms_ref_nm", getCstmsRefNm());
		this.hashColumns.put("tot_ots_sts_cd", getTotOtsStsCd());
		this.hashColumns.put("otr_doc_rcv_usr_id", getOtrDocRcvUsrId());
		this.hashColumns.put("ppt_rcv_dt", getPptRcvDt());
		this.hashColumns.put("inter_rmk", getInterRmk());
		this.hashColumns.put("otr_doc_cgor_flg", getOtrDocCgorFlg());
		this.hashColumns.put("cstms_clr_tp_cd", getCstmsClrTpCd());
		this.hashColumns.put("ms_pty_rgst_no", getMsPtyRgstNo());
		this.hashColumns.put("pr_pty_rgst_no", getPrPtyRgstNo());
		this.hashColumns.put("attorney_val_chk", getAttorneyValChk());
		this.hashColumns.put("cstms_asgn_nm", getCstmsAsgnNm());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		this.hashColumns.put("bl_otr_doc_rcv_cd", getBlOtrDocRcvCd());
		this.hashColumns.put("edo_rqst_seq_5jn", getEdoRqstSeq5jn());
		this.hashColumns.put("edo_rqst_seq_5jm", getEdoRqstSeq5jm());
		this.hashColumns.put("n3pty_cct_ots_curr_cd5", getN3ptyCctOtsCurrCd5());
		this.hashColumns.put("cct_sts_cd", getCctStsCd());
		this.hashColumns.put("do_split_flg", getDoSplitFlg());
		this.hashColumns.put("n3pty_cct_ots_curr_cd2", getN3ptyCctOtsCurrCd2());
		this.hashColumns.put("n3pty_cct_ots_curr_cd1", getN3ptyCctOtsCurrCd1());
		this.hashColumns.put("n3pty_cct_ots_curr_cd4", getN3ptyCctOtsCurrCd4());
		this.hashColumns.put("ibd_doc_rcv_flg", getIbdDocRcvFlg());
		this.hashColumns.put("n3pty_cct_ots_curr_cd3", getN3ptyCctOtsCurrCd3());
		this.hashColumns.put("ida_cstms_asgn_line_no", getIdaCstmsAsgnLineNo());
		this.hashColumns.put("edo_rqst_seq_5jk", getEdoRqstSeq5jk());
		this.hashColumns.put("ncust_nm", getNcustNm());
		this.hashColumns.put("otr_doc_rcv_dt", getOtrDocRcvDt());
		this.hashColumns.put("obl_rdem_knt", getOblRdemKnt());
		this.hashColumns.put("n3pty_cct_rcv_usr_id", getN3ptyCctRcvUsrId());
		this.hashColumns.put("cct_rcv_usr_id", getCctRcvUsrId());
		this.hashColumns.put("bonded_transportation", getBondedTransportation());
		this.hashColumns.put("obl_rdem_upd_usr_id", getOblRdemUpdUsrId());
		this.hashColumns.put("self_transportation", getSelfTransportation());
		this.hashColumns.put("cstms_dchg_loc_wh_cd", getCstmsDchgLocWhCd());
		this.hashColumns.put("cct_ots_curr_cd3", getCctOtsCurrCd3());
		this.hashColumns.put("cct_ots_curr_cd4", getCctOtsCurrCd4());
		this.hashColumns.put("cct_ots_curr_cd1", getCctOtsCurrCd1());
		this.hashColumns.put("cct_ots_curr_cd2", getCctOtsCurrCd2());
		this.hashColumns.put("cct_ots_curr_cd5", getCctOtsCurrCd5());
		this.hashColumns.put("bonded_edo_ack_cd", getBondedEdoAckCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("cct_rcv_ofc_cd", getCctRcvOfcCd());
		this.hashColumns.put("obl_iss_usr_id", getOblIssUsrId());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("cstms_clr_wh_cd", getCstmsClrWhCd());
		this.hashColumns.put("ccust_addr", getCcustAddr());
		this.hashColumns.put("rep_cmdt_nm", getRepCmdtNm());
		this.hashColumns.put("del_cnt_cd", getDelCntCd());
		this.hashColumns.put("scust_nm", getScustNm());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("obl_rdem_flg", getOblRdemFlg());
		this.hashColumns.put("cct_rcv_dt", getCctRcvDt());
		this.hashColumns.put("loc_nm", getLocNm());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("edo_rqst_no", getEdoRqstNo());
		this.hashColumns.put("de_term_desc", getDeTermDesc());
		this.hashColumns.put("mf_seq_no", getMfSeqNo());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("split_flg", getSplitFlg());
		this.hashColumns.put("cy_op_cd", getCyOpCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("ppt_sts_cd", getPptStsCd());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("obl_iss_tp_cd", getOblIssTpCd());
		this.hashColumns.put("otr_doc_rcv_ofc_cd", getOtrDocRcvOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tot_ots_amt1", getTotOtsAmt1());
		this.hashColumns.put("tot_ots_amt2", getTotOtsAmt2());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("ibd_doc_rcv_dt", getIbdDocRcvDt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("n3pty_ppt_rcv_ofc_cd", getN3ptyPptRcvOfcCd());
		this.hashColumns.put("self_edo_ack_cd", getSelfEdoAckCd());
		this.hashColumns.put("cct_ots_amt5", getCctOtsAmt5());
		this.hashColumns.put("info_cgo_flg", getInfoCgoFlg());
		this.hashColumns.put("cct_ots_amt4", getCctOtsAmt4());
		this.hashColumns.put("tot_ots_amt5", getTotOtsAmt5());
		this.hashColumns.put("obl_iss_knt", getOblIssKnt());
		this.hashColumns.put("cct_ots_amt3", getCctOtsAmt3());
		this.hashColumns.put("tot_ots_amt4", getTotOtsAmt4());
		this.hashColumns.put("cct_ots_amt2", getCctOtsAmt2());
		this.hashColumns.put("tot_ots_amt3", getTotOtsAmt3());
		this.hashColumns.put("cct_ots_amt1", getCctOtsAmt1());
		this.hashColumns.put("act_wgt", getActWgt());
		this.hashColumns.put("wh_nm", getWhNm());
		this.hashColumns.put("bl_tp_cd", getBlTpCd());
		this.hashColumns.put("ida_cgor_ord_yr", getIdaCgorOrdYr());
		this.hashColumns.put("soc_flg", getSocFlg());
		this.hashColumns.put("cstms_asgn_ctnt", getCstmsAsgnCtnt());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("cstms_ref_ctnt", getCstmsRefCtnt());
		this.hashColumns.put("do_edo_ack_cd", getDoEdoAckCd());
		this.hashColumns.put("arrival_vessel", getArrivalVessel());
		this.hashColumns.put("ccust_nm", getCcustNm());
		this.hashColumns.put("n3pty_ppt_sts_cd", getN3ptyPptStsCd());
		this.hashColumns.put("obl_rdem_ofc_cd", getOblRdemOfcCd());
		this.hashColumns.put("err_flg", getErrFlg());
		this.hashColumns.put("lcloblissueflg", getLcloblissueflg()); 
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ppt_rcv_ofc_cd", "pptRcvOfcCd");
		this.hashFields.put("n3pty_cct_rcv_dt", "n3ptyCctRcvDt");
		this.hashFields.put("obl_iss_dt", "oblIssDt");
		this.hashFields.put("do_hld_flg", "doHldFlg");
		this.hashFields.put("ibd_doc_rcv_ofc_cd", "ibdDocRcvOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("obl_rdem_dt", "oblRdemDt");
		this.hashFields.put("obl_cpy_knt", "oblCpyKnt");
		this.hashFields.put("ibd_doc_rcv_usr_id", "ibdDocRcvUsrId");
		this.hashFields.put("obl_iss_rmk", "oblIssRmk");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("obl_iss_ofc_cd", "oblIssOfcCd");
		this.hashFields.put("cntr_prt_flg", "cntrPrtFlg");
		this.hashFields.put("ncust_addr", "ncustAddr");
		this.hashFields.put("scust_addr", "scustAddr");
		this.hashFields.put("call_sgn_no", "callSgnNo");
		this.hashFields.put("do_issue", "doIssue");
		this.hashFields.put("n3pty_cct_rcv_ofc_cd", "n3ptyCctRcvOfcCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cstms_clr_loc_cd", "cstmsClrLocCd");
		this.hashFields.put("tot_ots_curr_cd1", "totOtsCurrCd1");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("tot_ots_curr_cd2", "totOtsCurrCd2");
		this.hashFields.put("tot_ots_curr_cd3", "totOtsCurrCd3");
		this.hashFields.put("tot_ots_curr_cd4", "totOtsCurrCd4");
		this.hashFields.put("obl_rdem_usr_id", "oblRdemUsrId");
		this.hashFields.put("tot_ots_curr_cd5", "totOtsCurrCd5");
		this.hashFields.put("n3pty_ppt_rcv_dt", "n3ptyPptRcvDt");
		this.hashFields.put("n3pty_ppt_rcv_usr_id", "n3ptyPptRcvUsrId");
		this.hashFields.put("obl_ttl_knt", "oblTtlKnt");
		this.hashFields.put("n3pty_cct_ots_amt4", "n3ptyCctOtsAmt4");
		this.hashFields.put("n3pty_cct_ots_amt5", "n3ptyCctOtsAmt5");
		this.hashFields.put("ppt_rcv_usr_id", "pptRcvUsrId");
		this.hashFields.put("n3pty_cct_ots_amt2", "n3ptyCctOtsAmt2");
		this.hashFields.put("n3pty_cct_ots_amt3", "n3ptyCctOtsAmt3");
		this.hashFields.put("n3pty_cct_sts_cd", "n3ptyCctStsCd");
		this.hashFields.put("n3pty_cct_ots_amt1", "n3ptyCctOtsAmt1");
		this.hashFields.put("ida_imp_gen_mf_no", "idaImpGenMfNo");
		this.hashFields.put("dsch_loc", "dschLoc");
		this.hashFields.put("mf_ref_no", "mfRefNo");
		this.hashFields.put("cstms_ref_nm", "cstmsRefNm");
		this.hashFields.put("tot_ots_sts_cd", "totOtsStsCd");
		this.hashFields.put("otr_doc_rcv_usr_id", "otrDocRcvUsrId");
		this.hashFields.put("ppt_rcv_dt", "pptRcvDt");
		this.hashFields.put("inter_rmk", "interRmk");
		this.hashFields.put("otr_doc_cgor_flg", "otrDocCgorFlg");
		this.hashFields.put("cstms_clr_tp_cd", "cstmsClrTpCd");
		this.hashFields.put("ms_pty_rgst_no", "msPtyRgstNo");
		this.hashFields.put("pr_pty_rgst_no", "prPtyRgstNo");
		this.hashFields.put("attorney_val_chk", "attorneyValChk");
		this.hashFields.put("cstms_asgn_nm", "cstmsAsgnNm");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("bl_otr_doc_rcv_cd", "blOtrDocRcvCd");
		this.hashFields.put("edo_rqst_seq_5jn", "edoRqstSeq5jn");
		this.hashFields.put("edo_rqst_seq_5jm", "edoRqstSeq5jm");
		this.hashFields.put("n3pty_cct_ots_curr_cd5", "n3ptyCctOtsCurrCd5");
		this.hashFields.put("cct_sts_cd", "cctStsCd");
		this.hashFields.put("do_split_flg", "doSplitFlg");
		this.hashFields.put("n3pty_cct_ots_curr_cd2", "n3ptyCctOtsCurrCd2");
		this.hashFields.put("n3pty_cct_ots_curr_cd1", "n3ptyCctOtsCurrCd1");
		this.hashFields.put("n3pty_cct_ots_curr_cd4", "n3ptyCctOtsCurrCd4");
		this.hashFields.put("ibd_doc_rcv_flg", "ibdDocRcvFlg");
		this.hashFields.put("n3pty_cct_ots_curr_cd3", "n3ptyCctOtsCurrCd3");
		this.hashFields.put("ida_cstms_asgn_line_no", "idaCstmsAsgnLineNo");
		this.hashFields.put("edo_rqst_seq_5jk", "edoRqstSeq5jk");
		this.hashFields.put("ncust_nm", "ncustNm");
		this.hashFields.put("otr_doc_rcv_dt", "otrDocRcvDt");
		this.hashFields.put("obl_rdem_knt", "oblRdemKnt");
		this.hashFields.put("n3pty_cct_rcv_usr_id", "n3ptyCctRcvUsrId");
		this.hashFields.put("cct_rcv_usr_id", "cctRcvUsrId");
		this.hashFields.put("bonded_transportation", "bondedTransportation");
		this.hashFields.put("obl_rdem_upd_usr_id", "oblRdemUpdUsrId");
		this.hashFields.put("self_transportation", "selfTransportation");
		this.hashFields.put("cstms_dchg_loc_wh_cd", "cstmsDchgLocWhCd");
		this.hashFields.put("cct_ots_curr_cd3", "cctOtsCurrCd3");
		this.hashFields.put("cct_ots_curr_cd4", "cctOtsCurrCd4");
		this.hashFields.put("cct_ots_curr_cd1", "cctOtsCurrCd1");
		this.hashFields.put("cct_ots_curr_cd2", "cctOtsCurrCd2");
		this.hashFields.put("cct_ots_curr_cd5", "cctOtsCurrCd5");
		this.hashFields.put("bonded_edo_ack_cd", "bondedEdoAckCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("cct_rcv_ofc_cd", "cctRcvOfcCd");
		this.hashFields.put("obl_iss_usr_id", "oblIssUsrId");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("cstms_clr_wh_cd", "cstmsClrWhCd");
		this.hashFields.put("ccust_addr", "ccustAddr");
		this.hashFields.put("rep_cmdt_nm", "repCmdtNm");
		this.hashFields.put("del_cnt_cd", "delCntCd");
		this.hashFields.put("scust_nm", "scustNm");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("obl_rdem_flg", "oblRdemFlg");
		this.hashFields.put("cct_rcv_dt", "cctRcvDt");
		this.hashFields.put("loc_nm", "locNm");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("edo_rqst_no", "edoRqstNo");
		this.hashFields.put("de_term_desc", "deTermDesc");
		this.hashFields.put("mf_seq_no", "mfSeqNo");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("split_flg", "splitFlg");
		this.hashFields.put("cy_op_cd", "cyOpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("ppt_sts_cd", "pptStsCd");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("obl_iss_tp_cd", "oblIssTpCd");
		this.hashFields.put("otr_doc_rcv_ofc_cd", "otrDocRcvOfcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tot_ots_amt1", "totOtsAmt1");
		this.hashFields.put("tot_ots_amt2", "totOtsAmt2");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("ibd_doc_rcv_dt", "ibdDocRcvDt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("n3pty_ppt_rcv_ofc_cd", "n3ptyPptRcvOfcCd");
		this.hashFields.put("self_edo_ack_cd", "selfEdoAckCd");
		this.hashFields.put("cct_ots_amt5", "cctOtsAmt5");
		this.hashFields.put("info_cgo_flg", "infoCgoFlg");
		this.hashFields.put("cct_ots_amt4", "cctOtsAmt4");
		this.hashFields.put("tot_ots_amt5", "totOtsAmt5");
		this.hashFields.put("obl_iss_knt", "oblIssKnt");
		this.hashFields.put("cct_ots_amt3", "cctOtsAmt3");
		this.hashFields.put("tot_ots_amt4", "totOtsAmt4");
		this.hashFields.put("cct_ots_amt2", "cctOtsAmt2");
		this.hashFields.put("tot_ots_amt3", "totOtsAmt3");
		this.hashFields.put("cct_ots_amt1", "cctOtsAmt1");
		this.hashFields.put("act_wgt", "actWgt");
		this.hashFields.put("wh_nm", "whNm");
		this.hashFields.put("bl_tp_cd", "blTpCd");
		this.hashFields.put("ida_cgor_ord_yr", "idaCgorOrdYr");
		this.hashFields.put("soc_flg", "socFlg");
		this.hashFields.put("cstms_asgn_ctnt", "cstmsAsgnCtnt");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("cstms_ref_ctnt", "cstmsRefCtnt");
		this.hashFields.put("do_edo_ack_cd", "doEdoAckCd");
		this.hashFields.put("arrival_vessel", "arrivalVessel");
		this.hashFields.put("ccust_nm", "ccustNm");
		this.hashFields.put("n3pty_ppt_sts_cd", "n3ptyPptStsCd");
		this.hashFields.put("obl_rdem_ofc_cd", "oblRdemOfcCd");
		this.hashFields.put("err_flg", "errFlg");
		this.hashFields.put("lcloblissueflg", "lcloblissueflg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return pptRcvOfcCd
	 */
	public String getPptRcvOfcCd() {
		return this.pptRcvOfcCd;
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
	 * @return oblIssDt
	 */
	public String getOblIssDt() {
		return this.oblIssDt;
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
	 * @return ibdDocRcvOfcCd
	 */
	public String getIbdDocRcvOfcCd() {
		return this.ibdDocRcvOfcCd;
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
	 * @return oblRdemDt
	 */
	public String getOblRdemDt() {
		return this.oblRdemDt;
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
	 * @return oblIssRmk
	 */
	public String getOblIssRmk() {
		return this.oblIssRmk;
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
	 * @return oblIssOfcCd
	 */
	public String getOblIssOfcCd() {
		return this.oblIssOfcCd;
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
	 * @return callSgnNo
	 */
	public String getCallSgnNo() {
		return this.callSgnNo;
	}
	
	/**
	 * Column Info
	 * @return doIssue
	 */
	public String getDoIssue() {
		return this.doIssue;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsClrLocCd
	 */
	public String getCstmsClrLocCd() {
		return this.cstmsClrLocCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return oblRdemUsrId
	 */
	public String getOblRdemUsrId() {
		return this.oblRdemUsrId;
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
	 * @return oblTtlKnt
	 */
	public String getOblTtlKnt() {
		return this.oblTtlKnt;
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
	 * @return idaImpGenMfNo
	 */
	public String getIdaImpGenMfNo() {
		return this.idaImpGenMfNo;
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
	 * @return mfRefNo
	 */
	public String getMfRefNo() {
		return this.mfRefNo;
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
	 * @return totOtsStsCd
	 */
	public String getTotOtsStsCd() {
		return this.totOtsStsCd;
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
	 * @return pptRcvDt
	 */
	public String getPptRcvDt() {
		return this.pptRcvDt;
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
	 * @return otrDocCgorFlg
	 */
	public String getOtrDocCgorFlg() {
		return this.otrDocCgorFlg;
	}
	
	/**
	 * Column Info
	 * @return cstmsClrTpCd
	 */
	public String getCstmsClrTpCd() {
		return this.cstmsClrTpCd;
	}
	
	/**
	 * Column Info
	 * @return msPtyRgstNo
	 */
	public String getMsPtyRgstNo() {
		return this.msPtyRgstNo;
	}
	
	/**
	 * Column Info
	 * @return msPtyRgstNo
	 */
	public String getPrPtyRgstNo() {
		return this.prPtyRgstNo;
	}
	
	/**
	 * Column Info
	 * @return msPtyRgstNo
	 */
	public String getAttorneyValChk() {
		return this.attorneyValChk;
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
	 * @return blOtrDocRcvCd
	 */
	public String getBlOtrDocRcvCd() {
		return this.blOtrDocRcvCd;
	}
	
	/**
	 * Column Info
	 * @return edoRqstSeq5jn
	 */
	public String getEdoRqstSeq5jn() {
		return this.edoRqstSeq5jn;
	}
	
	/**
	 * Column Info
	 * @return edoRqstSeq5jm
	 */
	public String getEdoRqstSeq5jm() {
		return this.edoRqstSeq5jm;
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
	 * @return cctStsCd
	 */
	public String getCctStsCd() {
		return this.cctStsCd;
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
	 * @return n3ptyCctOtsCurrCd2
	 */
	public String getN3ptyCctOtsCurrCd2() {
		return this.n3ptyCctOtsCurrCd2;
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
	 * @return n3ptyCctOtsCurrCd4
	 */
	public String getN3ptyCctOtsCurrCd4() {
		return this.n3ptyCctOtsCurrCd4;
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
	 * @return n3ptyCctOtsCurrCd3
	 */
	public String getN3ptyCctOtsCurrCd3() {
		return this.n3ptyCctOtsCurrCd3;
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
	 * @return edoRqstSeq5jk
	 */
	public String getEdoRqstSeq5jk() {
		return this.edoRqstSeq5jk;
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
	 * @return n3ptyCctRcvUsrId
	 */
	public String getN3ptyCctRcvUsrId() {
		return this.n3ptyCctRcvUsrId;
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
	 * @return bondedTransportation
	 */
	public String getBondedTransportation() {
		return this.bondedTransportation;
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
	 * @return selfTransportation
	 */
	public String getSelfTransportation() {
		return this.selfTransportation;
	}
	
	/**
	 * Column Info
	 * @return cstmsDchgLocWhCd
	 */
	public String getCstmsDchgLocWhCd() {
		return this.cstmsDchgLocWhCd;
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
	 * @return cctOtsCurrCd5
	 */
	public String getCctOtsCurrCd5() {
		return this.cctOtsCurrCd5;
	}
	
	/**
	 * Column Info
	 * @return bondedEdoAckCd
	 */
	public String getBondedEdoAckCd() {
		return this.bondedEdoAckCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return oblIssUsrId
	 */
	public String getOblIssUsrId() {
		return this.oblIssUsrId;
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
	 * @return cstmsClrWhCd
	 */
	public String getCstmsClrWhCd() {
		return this.cstmsClrWhCd;
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
	 * @return repCmdtNm
	 */
	public String getRepCmdtNm() {
		return this.repCmdtNm;
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
	 * @return oblRdemFlg
	 */
	public String getOblRdemFlg() {
		return this.oblRdemFlg;
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
	 * @return locNm
	 */
	public String getLocNm() {
		return this.locNm;
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
	 * @return edoRqstNo
	 */
	public String getEdoRqstNo() {
		return this.edoRqstNo;
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
	 * @return mfSeqNo
	 */
	public String getMfSeqNo() {
		return this.mfSeqNo;
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
	 * @return cyOpCd
	 */
	public String getCyOpCd() {
		return this.cyOpCd;
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
	 * @return pptStsCd
	 */
	public String getPptStsCd() {
		return this.pptStsCd;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
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
	 * @return ibdDocRcvDt
	 */
	public String getIbdDocRcvDt() {
		return this.ibdDocRcvDt;
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
	 * @return n3ptyPptRcvOfcCd
	 */
	public String getN3ptyPptRcvOfcCd() {
		return this.n3ptyPptRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @return selfEdoAckCd
	 */
	public String getSelfEdoAckCd() {
		return this.selfEdoAckCd;
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
	 * @return infoCgoFlg
	 */
	public String getInfoCgoFlg() {
		return this.infoCgoFlg;
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
	 * @return totOtsAmt5
	 */
	public String getTotOtsAmt5() {
		return this.totOtsAmt5;
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
	 * @return cctOtsAmt3
	 */
	public String getCctOtsAmt3() {
		return this.cctOtsAmt3;
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
	 * @return cctOtsAmt2
	 */
	public String getCctOtsAmt2() {
		return this.cctOtsAmt2;
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
	 * @return cctOtsAmt1
	 */
	public String getCctOtsAmt1() {
		return this.cctOtsAmt1;
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
	 * @return whNm
	 */
	public String getWhNm() {
		return this.whNm;
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
	 * @return idaCgorOrdYr
	 */
	public String getIdaCgorOrdYr() {
		return this.idaCgorOrdYr;
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
	 * @return cstmsAsgnCtnt
	 */
	public String getCstmsAsgnCtnt() {
		return this.cstmsAsgnCtnt;
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
	 * @return cstmsRefCtnt
	 */
	public String getCstmsRefCtnt() {
		return this.cstmsRefCtnt;
	}
	
	/**
	 * Column Info
	 * @return doEdoAckCd
	 */
	public String getDoEdoAckCd() {
		return this.doEdoAckCd;
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
	 * @return ccustNm
	 */
	public String getCcustNm() {
		return this.ccustNm;
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
	 * @return oblRdemOfcCd
	 */
	public String getOblRdemOfcCd() {
		return this.oblRdemOfcCd;
	}
	
	/**
	 * E-D/O Result 에 err 건 이 있는지 여부
	 * @return edoRqstSeq5jn
	 */
	public String getErrFlg() {
		return this.errFlg;
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
	 * @param n3ptyCctRcvDt
	 */
	public void setN3ptyCctRcvDt(String n3ptyCctRcvDt) {
		this.n3ptyCctRcvDt = n3ptyCctRcvDt;
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
	 * @param doHldFlg
	 */
	public void setDoHldFlg(String doHldFlg) {
		this.doHldFlg = doHldFlg;
	}
	
	/**
	 * Column Info
	 * @param ibdDocRcvOfcCd
	 */
	public void setIbdDocRcvOfcCd(String ibdDocRcvOfcCd) {
		this.ibdDocRcvOfcCd = ibdDocRcvOfcCd;
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
	 * @param oblRdemDt
	 */
	public void setOblRdemDt(String oblRdemDt) {
		this.oblRdemDt = oblRdemDt;
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
	 * @param oblIssRmk
	 */
	public void setOblIssRmk(String oblIssRmk) {
		this.oblIssRmk = oblIssRmk;
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
	 * @param oblIssOfcCd
	 */
	public void setOblIssOfcCd(String oblIssOfcCd) {
		this.oblIssOfcCd = oblIssOfcCd;
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
	 * @param callSgnNo
	 */
	public void setCallSgnNo(String callSgnNo) {
		this.callSgnNo = callSgnNo;
	}
	
	/**
	 * Column Info
	 * @param doIssue
	 */
	public void setDoIssue(String doIssue) {
		this.doIssue = doIssue;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param cstmsClrLocCd
	 */
	public void setCstmsClrLocCd(String cstmsClrLocCd) {
		this.cstmsClrLocCd = cstmsClrLocCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param oblRdemUsrId
	 */
	public void setOblRdemUsrId(String oblRdemUsrId) {
		this.oblRdemUsrId = oblRdemUsrId;
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
	 * @param oblTtlKnt
	 */
	public void setOblTtlKnt(String oblTtlKnt) {
		this.oblTtlKnt = oblTtlKnt;
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
	 * @param idaImpGenMfNo
	 */
	public void setIdaImpGenMfNo(String idaImpGenMfNo) {
		this.idaImpGenMfNo = idaImpGenMfNo;
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
	 * @param mfRefNo
	 */
	public void setMfRefNo(String mfRefNo) {
		this.mfRefNo = mfRefNo;
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
	 * @param totOtsStsCd
	 */
	public void setTotOtsStsCd(String totOtsStsCd) {
		this.totOtsStsCd = totOtsStsCd;
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
	 * @param pptRcvDt
	 */
	public void setPptRcvDt(String pptRcvDt) {
		this.pptRcvDt = pptRcvDt;
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
	 * @param otrDocCgorFlg
	 */
	public void setOtrDocCgorFlg(String otrDocCgorFlg) {
		this.otrDocCgorFlg = otrDocCgorFlg;
	}
	
	/**
	 * Column Info
	 * @param cstmsClrTpCd
	 */
	public void setCstmsClrTpCd(String cstmsClrTpCd) {
		this.cstmsClrTpCd = cstmsClrTpCd;
	}
	
	/**
	 * Column Info
	 * @param msPtyRgstNo
	 */
	public void setMsPtyRgstNo(String msPtyRgstNo) {
		this.msPtyRgstNo = msPtyRgstNo;
	}
	
	/**
	 * Column Info
	 * @param msPtyRgstNo
	 */
	public void setPrPtyRgstNo(String prPtyRgstNo) {
		this.prPtyRgstNo = prPtyRgstNo;
	}
	
	/**
	 * Column Info
	 * @param msPtyRgstNo
	 */
	public void setAttorneyValChk(String attorneyValChk) {
		this.attorneyValChk = attorneyValChk;
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
	 * @param blOtrDocRcvCd
	 */
	public void setBlOtrDocRcvCd(String blOtrDocRcvCd) {
		this.blOtrDocRcvCd = blOtrDocRcvCd;
	}
	
	/**
	 * Column Info
	 * @param edoRqstSeq5jn
	 */
	public void setEdoRqstSeq5jn(String edoRqstSeq5jn) {
		this.edoRqstSeq5jn = edoRqstSeq5jn;
	}
	
	/**
	 * Column Info
	 * @param edoRqstSeq5jm
	 */
	public void setEdoRqstSeq5jm(String edoRqstSeq5jm) {
		this.edoRqstSeq5jm = edoRqstSeq5jm;
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
	 * @param cctStsCd
	 */
	public void setCctStsCd(String cctStsCd) {
		this.cctStsCd = cctStsCd;
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
	 * @param n3ptyCctOtsCurrCd2
	 */
	public void setN3ptyCctOtsCurrCd2(String n3ptyCctOtsCurrCd2) {
		this.n3ptyCctOtsCurrCd2 = n3ptyCctOtsCurrCd2;
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
	 * @param n3ptyCctOtsCurrCd4
	 */
	public void setN3ptyCctOtsCurrCd4(String n3ptyCctOtsCurrCd4) {
		this.n3ptyCctOtsCurrCd4 = n3ptyCctOtsCurrCd4;
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
	 * @param n3ptyCctOtsCurrCd3
	 */
	public void setN3ptyCctOtsCurrCd3(String n3ptyCctOtsCurrCd3) {
		this.n3ptyCctOtsCurrCd3 = n3ptyCctOtsCurrCd3;
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
	 * @param edoRqstSeq5jk
	 */
	public void setEdoRqstSeq5jk(String edoRqstSeq5jk) {
		this.edoRqstSeq5jk = edoRqstSeq5jk;
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
	 * @param n3ptyCctRcvUsrId
	 */
	public void setN3ptyCctRcvUsrId(String n3ptyCctRcvUsrId) {
		this.n3ptyCctRcvUsrId = n3ptyCctRcvUsrId;
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
	 * @param bondedTransportation
	 */
	public void setBondedTransportation(String bondedTransportation) {
		this.bondedTransportation = bondedTransportation;
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
	 * @param selfTransportation
	 */
	public void setSelfTransportation(String selfTransportation) {
		this.selfTransportation = selfTransportation;
	}
	
	/**
	 * Column Info
	 * @param cstmsDchgLocWhCd
	 */
	public void setCstmsDchgLocWhCd(String cstmsDchgLocWhCd) {
		this.cstmsDchgLocWhCd = cstmsDchgLocWhCd;
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
	 * @param cctOtsCurrCd5
	 */
	public void setCctOtsCurrCd5(String cctOtsCurrCd5) {
		this.cctOtsCurrCd5 = cctOtsCurrCd5;
	}
	
	/**
	 * Column Info
	 * @param bondedEdoAckCd
	 */
	public void setBondedEdoAckCd(String bondedEdoAckCd) {
		this.bondedEdoAckCd = bondedEdoAckCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param oblIssUsrId
	 */
	public void setOblIssUsrId(String oblIssUsrId) {
		this.oblIssUsrId = oblIssUsrId;
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
	 * @param cstmsClrWhCd
	 */
	public void setCstmsClrWhCd(String cstmsClrWhCd) {
		this.cstmsClrWhCd = cstmsClrWhCd;
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
	 * @param repCmdtNm
	 */
	public void setRepCmdtNm(String repCmdtNm) {
		this.repCmdtNm = repCmdtNm;
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
	 * @param oblRdemFlg
	 */
	public void setOblRdemFlg(String oblRdemFlg) {
		this.oblRdemFlg = oblRdemFlg;
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
	 * @param locNm
	 */
	public void setLocNm(String locNm) {
		this.locNm = locNm;
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
	 * @param edoRqstNo
	 */
	public void setEdoRqstNo(String edoRqstNo) {
		this.edoRqstNo = edoRqstNo;
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
	 * @param mfSeqNo
	 */
	public void setMfSeqNo(String mfSeqNo) {
		this.mfSeqNo = mfSeqNo;
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
	 * @param cyOpCd
	 */
	public void setCyOpCd(String cyOpCd) {
		this.cyOpCd = cyOpCd;
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
	 * @param pptStsCd
	 */
	public void setPptStsCd(String pptStsCd) {
		this.pptStsCd = pptStsCd;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
	 * @param ibdDocRcvDt
	 */
	public void setIbdDocRcvDt(String ibdDocRcvDt) {
		this.ibdDocRcvDt = ibdDocRcvDt;
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
	 * @param n3ptyPptRcvOfcCd
	 */
	public void setN3ptyPptRcvOfcCd(String n3ptyPptRcvOfcCd) {
		this.n3ptyPptRcvOfcCd = n3ptyPptRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @param selfEdoAckCd
	 */
	public void setSelfEdoAckCd(String selfEdoAckCd) {
		this.selfEdoAckCd = selfEdoAckCd;
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
	 * @param infoCgoFlg
	 */
	public void setInfoCgoFlg(String infoCgoFlg) {
		this.infoCgoFlg = infoCgoFlg;
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
	 * @param totOtsAmt5
	 */
	public void setTotOtsAmt5(String totOtsAmt5) {
		this.totOtsAmt5 = totOtsAmt5;
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
	 * @param cctOtsAmt3
	 */
	public void setCctOtsAmt3(String cctOtsAmt3) {
		this.cctOtsAmt3 = cctOtsAmt3;
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
	 * @param cctOtsAmt2
	 */
	public void setCctOtsAmt2(String cctOtsAmt2) {
		this.cctOtsAmt2 = cctOtsAmt2;
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
	 * @param cctOtsAmt1
	 */
	public void setCctOtsAmt1(String cctOtsAmt1) {
		this.cctOtsAmt1 = cctOtsAmt1;
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
	 * @param whNm
	 */
	public void setWhNm(String whNm) {
		this.whNm = whNm;
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
	 * @param idaCgorOrdYr
	 */
	public void setIdaCgorOrdYr(String idaCgorOrdYr) {
		this.idaCgorOrdYr = idaCgorOrdYr;
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
	 * @param cstmsAsgnCtnt
	 */
	public void setCstmsAsgnCtnt(String cstmsAsgnCtnt) {
		this.cstmsAsgnCtnt = cstmsAsgnCtnt;
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
	 * @param cstmsRefCtnt
	 */
	public void setCstmsRefCtnt(String cstmsRefCtnt) {
		this.cstmsRefCtnt = cstmsRefCtnt;
	}
	
	/**
	 * Column Info
	 * @param doEdoAckCd
	 */
	public void setDoEdoAckCd(String doEdoAckCd) {
		this.doEdoAckCd = doEdoAckCd;
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
	 * @param ccustNm
	 */
	public void setCcustNm(String ccustNm) {
		this.ccustNm = ccustNm;
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
	 * @param oblRdemOfcCd
	 */
	public void setOblRdemOfcCd(String oblRdemOfcCd) {
		this.oblRdemOfcCd = oblRdemOfcCd;
	}
	
	/**
	 * E-D/O Result 에 err 건 이 있는지 여부
	 * @param edoRqstSeq5jn
	 */
	public void setErrFlg(String errFlg) {
		this.errFlg = errFlg;
	}
	
    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
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
	public void fromRequest(HttpServletRequest request, String prefix) {
		setPptRcvOfcCd(JSPUtil.getParameter(request, prefix + "ppt_rcv_ofc_cd", ""));
		setN3ptyCctRcvDt(JSPUtil.getParameter(request, prefix + "n3pty_cct_rcv_dt", ""));
		setOblIssDt(JSPUtil.getParameter(request, prefix + "obl_iss_dt", ""));
		setDoHldFlg(JSPUtil.getParameter(request, prefix + "do_hld_flg", ""));
		setIbdDocRcvOfcCd(JSPUtil.getParameter(request, prefix + "ibd_doc_rcv_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOblRdemDt(JSPUtil.getParameter(request, prefix + "obl_rdem_dt", ""));
		setOblCpyKnt(JSPUtil.getParameter(request, prefix + "obl_cpy_knt", ""));
		setIbdDocRcvUsrId(JSPUtil.getParameter(request, prefix + "ibd_doc_rcv_usr_id", ""));
		setOblIssRmk(JSPUtil.getParameter(request, prefix + "obl_iss_rmk", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setOblIssOfcCd(JSPUtil.getParameter(request, prefix + "obl_iss_ofc_cd", ""));
		setCntrPrtFlg(JSPUtil.getParameter(request, prefix + "cntr_prt_flg", ""));
		setNcustAddr(JSPUtil.getParameter(request, prefix + "ncust_addr", ""));
		setScustAddr(JSPUtil.getParameter(request, prefix + "scust_addr", ""));
		setCallSgnNo(JSPUtil.getParameter(request, prefix + "call_sgn_no", ""));
		setDoIssue(JSPUtil.getParameter(request, prefix + "do_issue", ""));
		setN3ptyCctRcvOfcCd(JSPUtil.getParameter(request, prefix + "n3pty_cct_rcv_ofc_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setCstmsClrLocCd(JSPUtil.getParameter(request, prefix + "cstms_clr_loc_cd", ""));
		setTotOtsCurrCd1(JSPUtil.getParameter(request, prefix + "tot_ots_curr_cd1", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setTotOtsCurrCd2(JSPUtil.getParameter(request, prefix + "tot_ots_curr_cd2", ""));
		setTotOtsCurrCd3(JSPUtil.getParameter(request, prefix + "tot_ots_curr_cd3", ""));
		setTotOtsCurrCd4(JSPUtil.getParameter(request, prefix + "tot_ots_curr_cd4", ""));
		setOblRdemUsrId(JSPUtil.getParameter(request, prefix + "obl_rdem_usr_id", ""));
		setTotOtsCurrCd5(JSPUtil.getParameter(request, prefix + "tot_ots_curr_cd5", ""));
		setN3ptyPptRcvDt(JSPUtil.getParameter(request, prefix + "n3pty_ppt_rcv_dt", ""));
		setN3ptyPptRcvUsrId(JSPUtil.getParameter(request, prefix + "n3pty_ppt_rcv_usr_id", ""));
		setOblTtlKnt(JSPUtil.getParameter(request, prefix + "obl_ttl_knt", ""));
		setN3ptyCctOtsAmt4(JSPUtil.getParameter(request, prefix + "n3pty_cct_ots_amt4", ""));
		setN3ptyCctOtsAmt5(JSPUtil.getParameter(request, prefix + "n3pty_cct_ots_amt5", ""));
		setPptRcvUsrId(JSPUtil.getParameter(request, prefix + "ppt_rcv_usr_id", ""));
		setN3ptyCctOtsAmt2(JSPUtil.getParameter(request, prefix + "n3pty_cct_ots_amt2", ""));
		setN3ptyCctOtsAmt3(JSPUtil.getParameter(request, prefix + "n3pty_cct_ots_amt3", ""));
		setN3ptyCctStsCd(JSPUtil.getParameter(request, prefix + "n3pty_cct_sts_cd", ""));
		setN3ptyCctOtsAmt1(JSPUtil.getParameter(request, prefix + "n3pty_cct_ots_amt1", ""));
		setIdaImpGenMfNo(JSPUtil.getParameter(request, prefix + "ida_imp_gen_mf_no", ""));
		setDschLoc(JSPUtil.getParameter(request, prefix + "dsch_loc", ""));
		setMfRefNo(JSPUtil.getParameter(request, prefix + "mf_ref_no", ""));
		setCstmsRefNm(JSPUtil.getParameter(request, prefix + "cstms_ref_nm", ""));
		setTotOtsStsCd(JSPUtil.getParameter(request, prefix + "tot_ots_sts_cd", ""));
		setOtrDocRcvUsrId(JSPUtil.getParameter(request, prefix + "otr_doc_rcv_usr_id", ""));
		setPptRcvDt(JSPUtil.getParameter(request, prefix + "ppt_rcv_dt", ""));
		setInterRmk(JSPUtil.getParameter(request, prefix + "inter_rmk", ""));
		setOtrDocCgorFlg(JSPUtil.getParameter(request, prefix + "otr_doc_cgor_flg", ""));
		setCstmsClrTpCd(JSPUtil.getParameter(request, prefix + "cstms_clr_tp_cd", ""));
		setMsPtyRgstNo(JSPUtil.getParameter(request, prefix + "ms_pty_rgst_no", ""));
		setPrPtyRgstNo(JSPUtil.getParameter(request, prefix + "pr_pty_rgst_no", ""));
		setAttorneyValChk(JSPUtil.getParameter(request, prefix + "attorney_val_chk", ""));
		setCstmsAsgnNm(JSPUtil.getParameter(request, prefix + "cstms_asgn_nm", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setMeasUtCd(JSPUtil.getParameter(request, prefix + "meas_ut_cd", ""));
		setBlOtrDocRcvCd(JSPUtil.getParameter(request, prefix + "bl_otr_doc_rcv_cd", ""));
		setEdoRqstSeq5jn(JSPUtil.getParameter(request, prefix + "edo_rqst_seq_5jn", ""));
		setEdoRqstSeq5jm(JSPUtil.getParameter(request, prefix + "edo_rqst_seq_5jm", ""));
		setN3ptyCctOtsCurrCd5(JSPUtil.getParameter(request, prefix + "n3pty_cct_ots_curr_cd5", ""));
		setCctStsCd(JSPUtil.getParameter(request, prefix + "cct_sts_cd", ""));
		setDoSplitFlg(JSPUtil.getParameter(request, prefix + "do_split_flg", ""));
		setN3ptyCctOtsCurrCd2(JSPUtil.getParameter(request, prefix + "n3pty_cct_ots_curr_cd2", ""));
		setN3ptyCctOtsCurrCd1(JSPUtil.getParameter(request, prefix + "n3pty_cct_ots_curr_cd1", ""));
		setN3ptyCctOtsCurrCd4(JSPUtil.getParameter(request, prefix + "n3pty_cct_ots_curr_cd4", ""));
		setIbdDocRcvFlg(JSPUtil.getParameter(request, prefix + "ibd_doc_rcv_flg", ""));
		setN3ptyCctOtsCurrCd3(JSPUtil.getParameter(request, prefix + "n3pty_cct_ots_curr_cd3", ""));
		setIdaCstmsAsgnLineNo(JSPUtil.getParameter(request, prefix + "ida_cstms_asgn_line_no", ""));
		setEdoRqstSeq5jk(JSPUtil.getParameter(request, prefix + "edo_rqst_seq_5jk", ""));
		setNcustNm(JSPUtil.getParameter(request, prefix + "ncust_nm", ""));
		setOtrDocRcvDt(JSPUtil.getParameter(request, prefix + "otr_doc_rcv_dt", ""));
		setOblRdemKnt(JSPUtil.getParameter(request, prefix + "obl_rdem_knt", ""));
		setN3ptyCctRcvUsrId(JSPUtil.getParameter(request, prefix + "n3pty_cct_rcv_usr_id", ""));
		setCctRcvUsrId(JSPUtil.getParameter(request, prefix + "cct_rcv_usr_id", ""));
		setBondedTransportation(JSPUtil.getParameter(request, prefix + "bonded_transportation", ""));
		setOblRdemUpdUsrId(JSPUtil.getParameter(request, prefix + "obl_rdem_upd_usr_id", ""));
		setSelfTransportation(JSPUtil.getParameter(request, prefix + "self_transportation", ""));
		setCstmsDchgLocWhCd(JSPUtil.getParameter(request, prefix + "cstms_dchg_loc_wh_cd", ""));
		setCctOtsCurrCd3(JSPUtil.getParameter(request, prefix + "cct_ots_curr_cd3", ""));
		setCctOtsCurrCd4(JSPUtil.getParameter(request, prefix + "cct_ots_curr_cd4", ""));
		setCctOtsCurrCd1(JSPUtil.getParameter(request, prefix + "cct_ots_curr_cd1", ""));
		setCctOtsCurrCd2(JSPUtil.getParameter(request, prefix + "cct_ots_curr_cd2", ""));
		setCctOtsCurrCd5(JSPUtil.getParameter(request, prefix + "cct_ots_curr_cd5", ""));
		setBondedEdoAckCd(JSPUtil.getParameter(request, prefix + "bonded_edo_ack_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setCctRcvOfcCd(JSPUtil.getParameter(request, prefix + "cct_rcv_ofc_cd", ""));
		setOblIssUsrId(JSPUtil.getParameter(request, prefix + "obl_iss_usr_id", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setCstmsClrWhCd(JSPUtil.getParameter(request, prefix + "cstms_clr_wh_cd", ""));
		setCcustAddr(JSPUtil.getParameter(request, prefix + "ccust_addr", ""));
		setRepCmdtNm(JSPUtil.getParameter(request, prefix + "rep_cmdt_nm", ""));
		setDelCntCd(JSPUtil.getParameter(request, prefix + "del_cnt_cd", ""));
		setScustNm(JSPUtil.getParameter(request, prefix + "scust_nm", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setOblRdemFlg(JSPUtil.getParameter(request, prefix + "obl_rdem_flg", ""));
		setCctRcvDt(JSPUtil.getParameter(request, prefix + "cct_rcv_dt", ""));
		setLocNm(JSPUtil.getParameter(request, prefix + "loc_nm", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setEdoRqstNo(JSPUtil.getParameter(request, prefix + "edo_rqst_no", ""));
		setDeTermDesc(JSPUtil.getParameter(request, prefix + "de_term_desc", ""));
		setMfSeqNo(JSPUtil.getParameter(request, prefix + "mf_seq_no", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setSplitFlg(JSPUtil.getParameter(request, prefix + "split_flg", ""));
		setCyOpCd(JSPUtil.getParameter(request, prefix + "cy_op_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPptStsCd(JSPUtil.getParameter(request, prefix + "ppt_sts_cd", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, prefix + "vps_eta_dt", ""));
		setOblIssTpCd(JSPUtil.getParameter(request, prefix + "obl_iss_tp_cd", ""));
		setOtrDocRcvOfcCd(JSPUtil.getParameter(request, prefix + "otr_doc_rcv_ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTotOtsAmt1(JSPUtil.getParameter(request, prefix + "tot_ots_amt1", ""));
		setTotOtsAmt2(JSPUtil.getParameter(request, prefix + "tot_ots_amt2", ""));
		setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setIbdDocRcvDt(JSPUtil.getParameter(request, prefix + "ibd_doc_rcv_dt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setN3ptyPptRcvOfcCd(JSPUtil.getParameter(request, prefix + "n3pty_ppt_rcv_ofc_cd", ""));
		setSelfEdoAckCd(JSPUtil.getParameter(request, prefix + "self_edo_ack_cd", ""));
		setCctOtsAmt5(JSPUtil.getParameter(request, prefix + "cct_ots_amt5", ""));
		setInfoCgoFlg(JSPUtil.getParameter(request, prefix + "info_cgo_flg", ""));
		setCctOtsAmt4(JSPUtil.getParameter(request, prefix + "cct_ots_amt4", ""));
		setTotOtsAmt5(JSPUtil.getParameter(request, prefix + "tot_ots_amt5", ""));
		setOblIssKnt(JSPUtil.getParameter(request, prefix + "obl_iss_knt", ""));
		setCctOtsAmt3(JSPUtil.getParameter(request, prefix + "cct_ots_amt3", ""));
		setTotOtsAmt4(JSPUtil.getParameter(request, prefix + "tot_ots_amt4", ""));
		setCctOtsAmt2(JSPUtil.getParameter(request, prefix + "cct_ots_amt2", ""));
		setTotOtsAmt3(JSPUtil.getParameter(request, prefix + "tot_ots_amt3", ""));
		setCctOtsAmt1(JSPUtil.getParameter(request, prefix + "cct_ots_amt1", ""));
		setActWgt(JSPUtil.getParameter(request, prefix + "act_wgt", ""));
		setWhNm(JSPUtil.getParameter(request, prefix + "wh_nm", ""));
		setBlTpCd(JSPUtil.getParameter(request, prefix + "bl_tp_cd", ""));
		setIdaCgorOrdYr(JSPUtil.getParameter(request, prefix + "ida_cgor_ord_yr", ""));
		setSocFlg(JSPUtil.getParameter(request, prefix + "soc_flg", ""));
		setCstmsAsgnCtnt(JSPUtil.getParameter(request, prefix + "cstms_asgn_ctnt", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setCstmsRefCtnt(JSPUtil.getParameter(request, prefix + "cstms_ref_ctnt", ""));
		setDoEdoAckCd(JSPUtil.getParameter(request, prefix + "do_edo_ack_cd", ""));
		setArrivalVessel(JSPUtil.getParameter(request, prefix + "arrival_vessel", ""));
		setCcustNm(JSPUtil.getParameter(request, prefix + "ccust_nm", ""));
		setN3ptyPptStsCd(JSPUtil.getParameter(request, prefix + "n3pty_ppt_sts_cd", ""));
		setOblRdemOfcCd(JSPUtil.getParameter(request, prefix + "obl_rdem_ofc_cd", ""));
		setSelfTransportation(JSPUtil.getParameter(request, "err_flg", ""));
		setLcloblissueflg(JSPUtil.getParameter(request, "lcloblissueflg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorDoBlInfoVO[]
	 */
	public KorDoBlInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorDoBlInfoVO[]
	 */
	public KorDoBlInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorDoBlInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pptRcvOfcCd = (JSPUtil.getParameter(request, prefix	+ "ppt_rcv_ofc_cd", length));
			String[] n3ptyCctRcvDt = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_rcv_dt", length));
			String[] oblIssDt = (JSPUtil.getParameter(request, prefix	+ "obl_iss_dt", length));
			String[] doHldFlg = (JSPUtil.getParameter(request, prefix	+ "do_hld_flg", length));
			String[] ibdDocRcvOfcCd = (JSPUtil.getParameter(request, prefix	+ "ibd_doc_rcv_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] oblRdemDt = (JSPUtil.getParameter(request, prefix	+ "obl_rdem_dt", length));
			String[] oblCpyKnt = (JSPUtil.getParameter(request, prefix	+ "obl_cpy_knt", length));
			String[] ibdDocRcvUsrId = (JSPUtil.getParameter(request, prefix	+ "ibd_doc_rcv_usr_id", length));
			String[] oblIssRmk = (JSPUtil.getParameter(request, prefix	+ "obl_iss_rmk", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] oblIssOfcCd = (JSPUtil.getParameter(request, prefix	+ "obl_iss_ofc_cd", length));
			String[] cntrPrtFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_prt_flg", length));
			String[] ncustAddr = (JSPUtil.getParameter(request, prefix	+ "ncust_addr", length));
			String[] scustAddr = (JSPUtil.getParameter(request, prefix	+ "scust_addr", length));
			String[] callSgnNo = (JSPUtil.getParameter(request, prefix	+ "call_sgn_no", length));
			String[] doIssue = (JSPUtil.getParameter(request, prefix	+ "do_issue", length));
			String[] n3ptyCctRcvOfcCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_rcv_ofc_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] cstmsClrLocCd = (JSPUtil.getParameter(request, prefix	+ "cstms_clr_loc_cd", length));
			String[] totOtsCurrCd1 = (JSPUtil.getParameter(request, prefix	+ "tot_ots_curr_cd1", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] totOtsCurrCd2 = (JSPUtil.getParameter(request, prefix	+ "tot_ots_curr_cd2", length));
			String[] totOtsCurrCd3 = (JSPUtil.getParameter(request, prefix	+ "tot_ots_curr_cd3", length));
			String[] totOtsCurrCd4 = (JSPUtil.getParameter(request, prefix	+ "tot_ots_curr_cd4", length));
			String[] oblRdemUsrId = (JSPUtil.getParameter(request, prefix	+ "obl_rdem_usr_id", length));
			String[] totOtsCurrCd5 = (JSPUtil.getParameter(request, prefix	+ "tot_ots_curr_cd5", length));
			String[] n3ptyPptRcvDt = (JSPUtil.getParameter(request, prefix	+ "n3pty_ppt_rcv_dt", length));
			String[] n3ptyPptRcvUsrId = (JSPUtil.getParameter(request, prefix	+ "n3pty_ppt_rcv_usr_id", length));
			String[] oblTtlKnt = (JSPUtil.getParameter(request, prefix	+ "obl_ttl_knt", length));
			String[] n3ptyCctOtsAmt4 = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_ots_amt4", length));
			String[] n3ptyCctOtsAmt5 = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_ots_amt5", length));
			String[] pptRcvUsrId = (JSPUtil.getParameter(request, prefix	+ "ppt_rcv_usr_id", length));
			String[] n3ptyCctOtsAmt2 = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_ots_amt2", length));
			String[] n3ptyCctOtsAmt3 = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_ots_amt3", length));
			String[] n3ptyCctStsCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_sts_cd", length));
			String[] n3ptyCctOtsAmt1 = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_ots_amt1", length));
			String[] idaImpGenMfNo = (JSPUtil.getParameter(request, prefix	+ "ida_imp_gen_mf_no", length));
			String[] dschLoc = (JSPUtil.getParameter(request, prefix	+ "dsch_loc", length));
			String[] mfRefNo = (JSPUtil.getParameter(request, prefix	+ "mf_ref_no", length));
			String[] cstmsRefNm = (JSPUtil.getParameter(request, prefix	+ "cstms_ref_nm", length));
			String[] totOtsStsCd = (JSPUtil.getParameter(request, prefix	+ "tot_ots_sts_cd", length));
			String[] otrDocRcvUsrId = (JSPUtil.getParameter(request, prefix	+ "otr_doc_rcv_usr_id", length));
			String[] pptRcvDt = (JSPUtil.getParameter(request, prefix	+ "ppt_rcv_dt", length));
			String[] interRmk = (JSPUtil.getParameter(request, prefix	+ "inter_rmk", length));
			String[] otrDocCgorFlg = (JSPUtil.getParameter(request, prefix	+ "otr_doc_cgor_flg", length));
			String[] cstmsClrTpCd = (JSPUtil.getParameter(request, prefix	+ "cstms_clr_tp_cd", length));
			String[] msPtyRgstNo = (JSPUtil.getParameter(request, prefix	+ "ms_pty_rgst_no", length));			
			String[] prPtyRgstNo = (JSPUtil.getParameter(request, prefix	+ "pr_pty_rgst_no", length));
			String[] attorneyValChk = (JSPUtil.getParameter(request, prefix	+ "attorney_val_chk", length));
			String[] cstmsAsgnNm = (JSPUtil.getParameter(request, prefix	+ "cstms_asgn_nm", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			String[] blOtrDocRcvCd = (JSPUtil.getParameter(request, prefix	+ "bl_otr_doc_rcv_cd", length));
			String[] edoRqstSeq5jn = (JSPUtil.getParameter(request, prefix	+ "edo_rqst_seq_5jn", length));
			String[] edoRqstSeq5jm = (JSPUtil.getParameter(request, prefix	+ "edo_rqst_seq_5jm", length));
			String[] n3ptyCctOtsCurrCd5 = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_ots_curr_cd5", length));
			String[] cctStsCd = (JSPUtil.getParameter(request, prefix	+ "cct_sts_cd", length));
			String[] doSplitFlg = (JSPUtil.getParameter(request, prefix	+ "do_split_flg", length));
			String[] n3ptyCctOtsCurrCd2 = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_ots_curr_cd2", length));
			String[] n3ptyCctOtsCurrCd1 = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_ots_curr_cd1", length));
			String[] n3ptyCctOtsCurrCd4 = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_ots_curr_cd4", length));
			String[] ibdDocRcvFlg = (JSPUtil.getParameter(request, prefix	+ "ibd_doc_rcv_flg", length));
			String[] n3ptyCctOtsCurrCd3 = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_ots_curr_cd3", length));
			String[] idaCstmsAsgnLineNo = (JSPUtil.getParameter(request, prefix	+ "ida_cstms_asgn_line_no", length));
			String[] edoRqstSeq5jk = (JSPUtil.getParameter(request, prefix	+ "edo_rqst_seq_5jk", length));
			String[] ncustNm = (JSPUtil.getParameter(request, prefix	+ "ncust_nm", length));
			String[] otrDocRcvDt = (JSPUtil.getParameter(request, prefix	+ "otr_doc_rcv_dt", length));
			String[] oblRdemKnt = (JSPUtil.getParameter(request, prefix	+ "obl_rdem_knt", length));
			String[] n3ptyCctRcvUsrId = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_rcv_usr_id", length));
			String[] cctRcvUsrId = (JSPUtil.getParameter(request, prefix	+ "cct_rcv_usr_id", length));
			String[] bondedTransportation = (JSPUtil.getParameter(request, prefix	+ "bonded_transportation", length));
			String[] oblRdemUpdUsrId = (JSPUtil.getParameter(request, prefix	+ "obl_rdem_upd_usr_id", length));
			String[] selfTransportation = (JSPUtil.getParameter(request, prefix	+ "self_transportation", length));
			String[] cstmsDchgLocWhCd = (JSPUtil.getParameter(request, prefix	+ "cstms_dchg_loc_wh_cd", length));
			String[] cctOtsCurrCd3 = (JSPUtil.getParameter(request, prefix	+ "cct_ots_curr_cd3", length));
			String[] cctOtsCurrCd4 = (JSPUtil.getParameter(request, prefix	+ "cct_ots_curr_cd4", length));
			String[] cctOtsCurrCd1 = (JSPUtil.getParameter(request, prefix	+ "cct_ots_curr_cd1", length));
			String[] cctOtsCurrCd2 = (JSPUtil.getParameter(request, prefix	+ "cct_ots_curr_cd2", length));
			String[] cctOtsCurrCd5 = (JSPUtil.getParameter(request, prefix	+ "cct_ots_curr_cd5", length));
			String[] bondedEdoAckCd = (JSPUtil.getParameter(request, prefix	+ "bonded_edo_ack_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] cctRcvOfcCd = (JSPUtil.getParameter(request, prefix	+ "cct_rcv_ofc_cd", length));
			String[] oblIssUsrId = (JSPUtil.getParameter(request, prefix	+ "obl_iss_usr_id", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] cstmsClrWhCd = (JSPUtil.getParameter(request, prefix	+ "cstms_clr_wh_cd", length));
			String[] ccustAddr = (JSPUtil.getParameter(request, prefix	+ "ccust_addr", length));
			String[] repCmdtNm = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt_nm", length));
			String[] delCntCd = (JSPUtil.getParameter(request, prefix	+ "del_cnt_cd", length));
			String[] scustNm = (JSPUtil.getParameter(request, prefix	+ "scust_nm", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] oblRdemFlg = (JSPUtil.getParameter(request, prefix	+ "obl_rdem_flg", length));
			String[] cctRcvDt = (JSPUtil.getParameter(request, prefix	+ "cct_rcv_dt", length));
			String[] locNm = (JSPUtil.getParameter(request, prefix	+ "loc_nm", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] edoRqstNo = (JSPUtil.getParameter(request, prefix	+ "edo_rqst_no", length));
			String[] deTermDesc = (JSPUtil.getParameter(request, prefix	+ "de_term_desc", length));
			String[] mfSeqNo = (JSPUtil.getParameter(request, prefix	+ "mf_seq_no", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] splitFlg = (JSPUtil.getParameter(request, prefix	+ "split_flg", length));
			String[] cyOpCd = (JSPUtil.getParameter(request, prefix	+ "cy_op_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pptStsCd = (JSPUtil.getParameter(request, prefix	+ "ppt_sts_cd", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] oblIssTpCd = (JSPUtil.getParameter(request, prefix	+ "obl_iss_tp_cd", length));
			String[] otrDocRcvOfcCd = (JSPUtil.getParameter(request, prefix	+ "otr_doc_rcv_ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] totOtsAmt1 = (JSPUtil.getParameter(request, prefix	+ "tot_ots_amt1", length));
			String[] totOtsAmt2 = (JSPUtil.getParameter(request, prefix	+ "tot_ots_amt2", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] ibdDocRcvDt = (JSPUtil.getParameter(request, prefix	+ "ibd_doc_rcv_dt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] n3ptyPptRcvOfcCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_ppt_rcv_ofc_cd", length));
			String[] selfEdoAckCd = (JSPUtil.getParameter(request, prefix	+ "self_edo_ack_cd", length));
			String[] cctOtsAmt5 = (JSPUtil.getParameter(request, prefix	+ "cct_ots_amt5", length));
			String[] infoCgoFlg = (JSPUtil.getParameter(request, prefix	+ "info_cgo_flg", length));
			String[] cctOtsAmt4 = (JSPUtil.getParameter(request, prefix	+ "cct_ots_amt4", length));
			String[] totOtsAmt5 = (JSPUtil.getParameter(request, prefix	+ "tot_ots_amt5", length));
			String[] oblIssKnt = (JSPUtil.getParameter(request, prefix	+ "obl_iss_knt", length));
			String[] cctOtsAmt3 = (JSPUtil.getParameter(request, prefix	+ "cct_ots_amt3", length));
			String[] totOtsAmt4 = (JSPUtil.getParameter(request, prefix	+ "tot_ots_amt4", length));
			String[] cctOtsAmt2 = (JSPUtil.getParameter(request, prefix	+ "cct_ots_amt2", length));
			String[] totOtsAmt3 = (JSPUtil.getParameter(request, prefix	+ "tot_ots_amt3", length));
			String[] cctOtsAmt1 = (JSPUtil.getParameter(request, prefix	+ "cct_ots_amt1", length));
			String[] actWgt = (JSPUtil.getParameter(request, prefix	+ "act_wgt", length));
			String[] whNm = (JSPUtil.getParameter(request, prefix	+ "wh_nm", length));
			String[] blTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_tp_cd", length));
			String[] idaCgorOrdYr = (JSPUtil.getParameter(request, prefix	+ "ida_cgor_ord_yr", length));
			String[] socFlg = (JSPUtil.getParameter(request, prefix	+ "soc_flg", length));
			String[] cstmsAsgnCtnt = (JSPUtil.getParameter(request, prefix	+ "cstms_asgn_ctnt", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] cstmsRefCtnt = (JSPUtil.getParameter(request, prefix	+ "cstms_ref_ctnt", length));
			String[] doEdoAckCd = (JSPUtil.getParameter(request, prefix	+ "do_edo_ack_cd", length));
			String[] arrivalVessel = (JSPUtil.getParameter(request, prefix	+ "arrival_vessel", length));
			String[] ccustNm = (JSPUtil.getParameter(request, prefix	+ "ccust_nm", length));
			String[] n3ptyPptStsCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_ppt_sts_cd", length));
			String[] oblRdemOfcCd = (JSPUtil.getParameter(request, prefix	+ "obl_rdem_ofc_cd", length));
			String[] errFlg = (JSPUtil.getParameter(request, prefix	+ "err_flg", length));
			String[] lcloblissueflg = (JSPUtil.getParameter(request, prefix	+ "lcloblissueflg", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorDoBlInfoVO();
				if (pptRcvOfcCd[i] != null)
					model.setPptRcvOfcCd(pptRcvOfcCd[i]);
				if (n3ptyCctRcvDt[i] != null)
					model.setN3ptyCctRcvDt(n3ptyCctRcvDt[i]);
				if (oblIssDt[i] != null)
					model.setOblIssDt(oblIssDt[i]);
				if (doHldFlg[i] != null)
					model.setDoHldFlg(doHldFlg[i]);
				if (ibdDocRcvOfcCd[i] != null)
					model.setIbdDocRcvOfcCd(ibdDocRcvOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (oblRdemDt[i] != null)
					model.setOblRdemDt(oblRdemDt[i]);
				if (oblCpyKnt[i] != null)
					model.setOblCpyKnt(oblCpyKnt[i]);
				if (ibdDocRcvUsrId[i] != null)
					model.setIbdDocRcvUsrId(ibdDocRcvUsrId[i]);
				if (oblIssRmk[i] != null)
					model.setOblIssRmk(oblIssRmk[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (oblIssOfcCd[i] != null)
					model.setOblIssOfcCd(oblIssOfcCd[i]);
				if (cntrPrtFlg[i] != null)
					model.setCntrPrtFlg(cntrPrtFlg[i]);
				if (ncustAddr[i] != null)
					model.setNcustAddr(ncustAddr[i]);
				if (scustAddr[i] != null)
					model.setScustAddr(scustAddr[i]);
				if (callSgnNo[i] != null)
					model.setCallSgnNo(callSgnNo[i]);
				if (doIssue[i] != null)
					model.setDoIssue(doIssue[i]);
				if (n3ptyCctRcvOfcCd[i] != null)
					model.setN3ptyCctRcvOfcCd(n3ptyCctRcvOfcCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (cstmsClrLocCd[i] != null)
					model.setCstmsClrLocCd(cstmsClrLocCd[i]);
				if (totOtsCurrCd1[i] != null)
					model.setTotOtsCurrCd1(totOtsCurrCd1[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (totOtsCurrCd2[i] != null)
					model.setTotOtsCurrCd2(totOtsCurrCd2[i]);
				if (totOtsCurrCd3[i] != null)
					model.setTotOtsCurrCd3(totOtsCurrCd3[i]);
				if (totOtsCurrCd4[i] != null)
					model.setTotOtsCurrCd4(totOtsCurrCd4[i]);
				if (oblRdemUsrId[i] != null)
					model.setOblRdemUsrId(oblRdemUsrId[i]);
				if (totOtsCurrCd5[i] != null)
					model.setTotOtsCurrCd5(totOtsCurrCd5[i]);
				if (n3ptyPptRcvDt[i] != null)
					model.setN3ptyPptRcvDt(n3ptyPptRcvDt[i]);
				if (n3ptyPptRcvUsrId[i] != null)
					model.setN3ptyPptRcvUsrId(n3ptyPptRcvUsrId[i]);
				if (oblTtlKnt[i] != null)
					model.setOblTtlKnt(oblTtlKnt[i]);
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
				if (idaImpGenMfNo[i] != null)
					model.setIdaImpGenMfNo(idaImpGenMfNo[i]);
				if (dschLoc[i] != null)
					model.setDschLoc(dschLoc[i]);
				if (mfRefNo[i] != null)
					model.setMfRefNo(mfRefNo[i]);
				if (cstmsRefNm[i] != null)
					model.setCstmsRefNm(cstmsRefNm[i]);
				if (totOtsStsCd[i] != null)
					model.setTotOtsStsCd(totOtsStsCd[i]);
				if (otrDocRcvUsrId[i] != null)
					model.setOtrDocRcvUsrId(otrDocRcvUsrId[i]);
				if (pptRcvDt[i] != null)
					model.setPptRcvDt(pptRcvDt[i]);
				if (interRmk[i] != null)
					model.setInterRmk(interRmk[i]);
				if (otrDocCgorFlg[i] != null)
					model.setOtrDocCgorFlg(otrDocCgorFlg[i]);
				if (cstmsClrTpCd[i] != null)
					model.setCstmsClrTpCd(cstmsClrTpCd[i]);
				if (msPtyRgstNo[i] != null)
					model.setMsPtyRgstNo(msPtyRgstNo[i]);
				if (prPtyRgstNo[i] != null)
					model.setPrPtyRgstNo(prPtyRgstNo[i]);
				if (attorneyValChk[i] != null)
					model.setAttorneyValChk(attorneyValChk[i]);
				if (cstmsAsgnNm[i] != null)
					model.setCstmsAsgnNm(cstmsAsgnNm[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (measUtCd[i] != null)
					model.setMeasUtCd(measUtCd[i]);
				if (blOtrDocRcvCd[i] != null)
					model.setBlOtrDocRcvCd(blOtrDocRcvCd[i]);
				if (edoRqstSeq5jn[i] != null)
					model.setEdoRqstSeq5jn(edoRqstSeq5jn[i]);
				if (edoRqstSeq5jm[i] != null)
					model.setEdoRqstSeq5jm(edoRqstSeq5jm[i]);
				if (n3ptyCctOtsCurrCd5[i] != null)
					model.setN3ptyCctOtsCurrCd5(n3ptyCctOtsCurrCd5[i]);
				if (cctStsCd[i] != null)
					model.setCctStsCd(cctStsCd[i]);
				if (doSplitFlg[i] != null)
					model.setDoSplitFlg(doSplitFlg[i]);
				if (n3ptyCctOtsCurrCd2[i] != null)
					model.setN3ptyCctOtsCurrCd2(n3ptyCctOtsCurrCd2[i]);
				if (n3ptyCctOtsCurrCd1[i] != null)
					model.setN3ptyCctOtsCurrCd1(n3ptyCctOtsCurrCd1[i]);
				if (n3ptyCctOtsCurrCd4[i] != null)
					model.setN3ptyCctOtsCurrCd4(n3ptyCctOtsCurrCd4[i]);
				if (ibdDocRcvFlg[i] != null)
					model.setIbdDocRcvFlg(ibdDocRcvFlg[i]);
				if (n3ptyCctOtsCurrCd3[i] != null)
					model.setN3ptyCctOtsCurrCd3(n3ptyCctOtsCurrCd3[i]);
				if (idaCstmsAsgnLineNo[i] != null)
					model.setIdaCstmsAsgnLineNo(idaCstmsAsgnLineNo[i]);
				if (edoRqstSeq5jk[i] != null)
					model.setEdoRqstSeq5jk(edoRqstSeq5jk[i]);
				if (ncustNm[i] != null)
					model.setNcustNm(ncustNm[i]);
				if (otrDocRcvDt[i] != null)
					model.setOtrDocRcvDt(otrDocRcvDt[i]);
				if (oblRdemKnt[i] != null)
					model.setOblRdemKnt(oblRdemKnt[i]);
				if (n3ptyCctRcvUsrId[i] != null)
					model.setN3ptyCctRcvUsrId(n3ptyCctRcvUsrId[i]);
				if (cctRcvUsrId[i] != null)
					model.setCctRcvUsrId(cctRcvUsrId[i]);
				if (bondedTransportation[i] != null)
					model.setBondedTransportation(bondedTransportation[i]);
				if (oblRdemUpdUsrId[i] != null)
					model.setOblRdemUpdUsrId(oblRdemUpdUsrId[i]);
				if (selfTransportation[i] != null)
					model.setSelfTransportation(selfTransportation[i]);
				if (cstmsDchgLocWhCd[i] != null)
					model.setCstmsDchgLocWhCd(cstmsDchgLocWhCd[i]);
				if (cctOtsCurrCd3[i] != null)
					model.setCctOtsCurrCd3(cctOtsCurrCd3[i]);
				if (cctOtsCurrCd4[i] != null)
					model.setCctOtsCurrCd4(cctOtsCurrCd4[i]);
				if (cctOtsCurrCd1[i] != null)
					model.setCctOtsCurrCd1(cctOtsCurrCd1[i]);
				if (cctOtsCurrCd2[i] != null)
					model.setCctOtsCurrCd2(cctOtsCurrCd2[i]);
				if (cctOtsCurrCd5[i] != null)
					model.setCctOtsCurrCd5(cctOtsCurrCd5[i]);
				if (bondedEdoAckCd[i] != null)
					model.setBondedEdoAckCd(bondedEdoAckCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (cctRcvOfcCd[i] != null)
					model.setCctRcvOfcCd(cctRcvOfcCd[i]);
				if (oblIssUsrId[i] != null)
					model.setOblIssUsrId(oblIssUsrId[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (cstmsClrWhCd[i] != null)
					model.setCstmsClrWhCd(cstmsClrWhCd[i]);
				if (ccustAddr[i] != null)
					model.setCcustAddr(ccustAddr[i]);
				if (repCmdtNm[i] != null)
					model.setRepCmdtNm(repCmdtNm[i]);
				if (delCntCd[i] != null)
					model.setDelCntCd(delCntCd[i]);
				if (scustNm[i] != null)
					model.setScustNm(scustNm[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (oblRdemFlg[i] != null)
					model.setOblRdemFlg(oblRdemFlg[i]);
				if (cctRcvDt[i] != null)
					model.setCctRcvDt(cctRcvDt[i]);
				if (locNm[i] != null)
					model.setLocNm(locNm[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (edoRqstNo[i] != null)
					model.setEdoRqstNo(edoRqstNo[i]);
				if (deTermDesc[i] != null)
					model.setDeTermDesc(deTermDesc[i]);
				if (mfSeqNo[i] != null)
					model.setMfSeqNo(mfSeqNo[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (splitFlg[i] != null)
					model.setSplitFlg(splitFlg[i]);
				if (cyOpCd[i] != null)
					model.setCyOpCd(cyOpCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pptStsCd[i] != null)
					model.setPptStsCd(pptStsCd[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (oblIssTpCd[i] != null)
					model.setOblIssTpCd(oblIssTpCd[i]);
				if (otrDocRcvOfcCd[i] != null)
					model.setOtrDocRcvOfcCd(otrDocRcvOfcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (totOtsAmt1[i] != null)
					model.setTotOtsAmt1(totOtsAmt1[i]);
				if (totOtsAmt2[i] != null)
					model.setTotOtsAmt2(totOtsAmt2[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (ibdDocRcvDt[i] != null)
					model.setIbdDocRcvDt(ibdDocRcvDt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (n3ptyPptRcvOfcCd[i] != null)
					model.setN3ptyPptRcvOfcCd(n3ptyPptRcvOfcCd[i]);
				if (selfEdoAckCd[i] != null)
					model.setSelfEdoAckCd(selfEdoAckCd[i]);
				if (cctOtsAmt5[i] != null)
					model.setCctOtsAmt5(cctOtsAmt5[i]);
				if (infoCgoFlg[i] != null)
					model.setInfoCgoFlg(infoCgoFlg[i]);
				if (cctOtsAmt4[i] != null)
					model.setCctOtsAmt4(cctOtsAmt4[i]);
				if (totOtsAmt5[i] != null)
					model.setTotOtsAmt5(totOtsAmt5[i]);
				if (oblIssKnt[i] != null)
					model.setOblIssKnt(oblIssKnt[i]);
				if (cctOtsAmt3[i] != null)
					model.setCctOtsAmt3(cctOtsAmt3[i]);
				if (totOtsAmt4[i] != null)
					model.setTotOtsAmt4(totOtsAmt4[i]);
				if (cctOtsAmt2[i] != null)
					model.setCctOtsAmt2(cctOtsAmt2[i]);
				if (totOtsAmt3[i] != null)
					model.setTotOtsAmt3(totOtsAmt3[i]);
				if (cctOtsAmt1[i] != null)
					model.setCctOtsAmt1(cctOtsAmt1[i]);
				if (actWgt[i] != null)
					model.setActWgt(actWgt[i]);
				if (whNm[i] != null)
					model.setWhNm(whNm[i]);
				if (blTpCd[i] != null)
					model.setBlTpCd(blTpCd[i]);
				if (idaCgorOrdYr[i] != null)
					model.setIdaCgorOrdYr(idaCgorOrdYr[i]);
				if (socFlg[i] != null)
					model.setSocFlg(socFlg[i]);
				if (cstmsAsgnCtnt[i] != null)
					model.setCstmsAsgnCtnt(cstmsAsgnCtnt[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (cstmsRefCtnt[i] != null)
					model.setCstmsRefCtnt(cstmsRefCtnt[i]);
				if (doEdoAckCd[i] != null)
					model.setDoEdoAckCd(doEdoAckCd[i]);
				if (arrivalVessel[i] != null)
					model.setArrivalVessel(arrivalVessel[i]);
				if (ccustNm[i] != null)
					model.setCcustNm(ccustNm[i]);
				if (n3ptyPptStsCd[i] != null)
					model.setN3ptyPptStsCd(n3ptyPptStsCd[i]);
				if (oblRdemOfcCd[i] != null)
					model.setOblRdemOfcCd(oblRdemOfcCd[i]);
				if (errFlg[i] != null)
					model.setErrFlg(errFlg[i]);
				if (lcloblissueflg[i] != null)
					model.setLcloblissueflg(lcloblissueflg[i]);

				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorDoBlInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorDoBlInfoVO[]
	 */
	public KorDoBlInfoVO[] getKorDoBlInfoVOs(){
		KorDoBlInfoVO[] vos = (KorDoBlInfoVO[])models.toArray(new KorDoBlInfoVO[models.size()]);
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
		this.pptRcvOfcCd = this.pptRcvOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctRcvDt = this.n3ptyCctRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssDt = this.oblIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doHldFlg = this.doHldFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdDocRcvOfcCd = this.ibdDocRcvOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRdemDt = this.oblRdemDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblCpyKnt = this.oblCpyKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdDocRcvUsrId = this.ibdDocRcvUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssRmk = this.oblIssRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssOfcCd = this.oblIssOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPrtFlg = this.cntrPrtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ncustAddr = this.ncustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scustAddr = this.scustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSgnNo = this.callSgnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doIssue = this.doIssue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctRcvOfcCd = this.n3ptyCctRcvOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsClrLocCd = this.cstmsClrLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOtsCurrCd1 = this.totOtsCurrCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOtsCurrCd2 = this.totOtsCurrCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOtsCurrCd3 = this.totOtsCurrCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOtsCurrCd4 = this.totOtsCurrCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRdemUsrId = this.oblRdemUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOtsCurrCd5 = this.totOtsCurrCd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyPptRcvDt = this.n3ptyPptRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyPptRcvUsrId = this.n3ptyPptRcvUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblTtlKnt = this.oblTtlKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctOtsAmt4 = this.n3ptyCctOtsAmt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctOtsAmt5 = this.n3ptyCctOtsAmt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pptRcvUsrId = this.pptRcvUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctOtsAmt2 = this.n3ptyCctOtsAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctOtsAmt3 = this.n3ptyCctOtsAmt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctStsCd = this.n3ptyCctStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctOtsAmt1 = this.n3ptyCctOtsAmt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaImpGenMfNo = this.idaImpGenMfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dschLoc = this.dschLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfRefNo = this.mfRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsRefNm = this.cstmsRefNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOtsStsCd = this.totOtsStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otrDocRcvUsrId = this.otrDocRcvUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pptRcvDt = this.pptRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interRmk = this.interRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otrDocCgorFlg = this.otrDocCgorFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsClrTpCd = this.cstmsClrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msPtyRgstNo = this.msPtyRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prPtyRgstNo = this.prPtyRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attorneyValChk = this.attorneyValChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsAsgnNm = this.cstmsAsgnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blOtrDocRcvCd = this.blOtrDocRcvCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edoRqstSeq5jn = this.edoRqstSeq5jn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edoRqstSeq5jm = this.edoRqstSeq5jm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctOtsCurrCd5 = this.n3ptyCctOtsCurrCd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctStsCd = this.cctStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doSplitFlg = this.doSplitFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctOtsCurrCd2 = this.n3ptyCctOtsCurrCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctOtsCurrCd1 = this.n3ptyCctOtsCurrCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctOtsCurrCd4 = this.n3ptyCctOtsCurrCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdDocRcvFlg = this.ibdDocRcvFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctOtsCurrCd3 = this.n3ptyCctOtsCurrCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaCstmsAsgnLineNo = this.idaCstmsAsgnLineNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edoRqstSeq5jk = this.edoRqstSeq5jk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ncustNm = this.ncustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otrDocRcvDt = this.otrDocRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRdemKnt = this.oblRdemKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctRcvUsrId = this.n3ptyCctRcvUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctRcvUsrId = this.cctRcvUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bondedTransportation = this.bondedTransportation .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRdemUpdUsrId = this.oblRdemUpdUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selfTransportation = this.selfTransportation .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDchgLocWhCd = this.cstmsDchgLocWhCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctOtsCurrCd3 = this.cctOtsCurrCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctOtsCurrCd4 = this.cctOtsCurrCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctOtsCurrCd1 = this.cctOtsCurrCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctOtsCurrCd2 = this.cctOtsCurrCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctOtsCurrCd5 = this.cctOtsCurrCd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bondedEdoAckCd = this.bondedEdoAckCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctRcvOfcCd = this.cctRcvOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssUsrId = this.oblIssUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsClrWhCd = this.cstmsClrWhCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ccustAddr = this.ccustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtNm = this.repCmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCntCd = this.delCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scustNm = this.scustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRdemFlg = this.oblRdemFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctRcvDt = this.cctRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locNm = this.locNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edoRqstNo = this.edoRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermDesc = this.deTermDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfSeqNo = this.mfSeqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splitFlg = this.splitFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cyOpCd = this.cyOpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pptStsCd = this.pptStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssTpCd = this.oblIssTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otrDocRcvOfcCd = this.otrDocRcvOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOtsAmt1 = this.totOtsAmt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOtsAmt2 = this.totOtsAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdDocRcvDt = this.ibdDocRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyPptRcvOfcCd = this.n3ptyPptRcvOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selfEdoAckCd = this.selfEdoAckCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctOtsAmt5 = this.cctOtsAmt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.infoCgoFlg = this.infoCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctOtsAmt4 = this.cctOtsAmt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOtsAmt5 = this.totOtsAmt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssKnt = this.oblIssKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctOtsAmt3 = this.cctOtsAmt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOtsAmt4 = this.totOtsAmt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctOtsAmt2 = this.cctOtsAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOtsAmt3 = this.totOtsAmt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctOtsAmt1 = this.cctOtsAmt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWgt = this.actWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whNm = this.whNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTpCd = this.blTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaCgorOrdYr = this.idaCgorOrdYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socFlg = this.socFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsAsgnCtnt = this.cstmsAsgnCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsRefCtnt = this.cstmsRefCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doEdoAckCd = this.doEdoAckCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrivalVessel = this.arrivalVessel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ccustNm = this.ccustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyPptStsCd = this.n3ptyPptStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRdemOfcCd = this.oblRdemOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errFlg = this.errFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lcloblissueflg = this.lcloblissueflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
