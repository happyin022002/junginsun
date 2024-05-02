/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WorkOrderPreviewVO.java
*@FileTitle : WorkOrderPreviewVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.01
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.01  
* 1.0 Creation
* 1.5 2010.11.29 이재위 [CHM-201006281-01] [TRS] VLCBB EDI(IFTMIN) 개발
* 1.5 2010.11.29 이재위 [CHM-201007047-01] [TRS] EDI/RD DANGER CGO 관련 조회 수정건
* 1.6 2011.10.25 이수진  [CHM-201113210] [TRS] Feeder Term 표기 칼럼 추가 요청
=========================================================*/

package com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.vo;

import java.lang.reflect.Field;
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class WorkOrderPreviewVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<WorkOrderPreviewVO> models = new ArrayList<WorkOrderPreviewVO>();
	
	/* Column Info */
	private String cmdtDpUseFlg = null;
	/* Column Info */
	private String woCxlFlg = null;
	/* Column Info */
	private String emailContents = null;
	/* Column Info */
	private String interUseFlg = null;
	/* Column Info */
	private String ediWoIssStsCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String emlNo03 = null;
	/* Column Info */
	private String woN1stFaxNo = null;
	/* Column Info */
	private String trspCostDtlModCd = null;
	/* Column Info */
	private String woN3rdEml = null;
	/* Column Info */
	private String woFmtTpCd = null;
	/* Column Info */
	private String emlNo01 = null;
	/* Column Info */
	private String woN1stEml = null;
	/* Column Info */
	private String emlNo02 = null;
	/* Column Info */
	private String woRmk = null;
	/* Column Info */
	private String ediTrspWoSeq = null;
	/* Column Info */
	private String ediWoIssKnt = null;
	/* Column Info */
	private String faxNo02 = null;
	/* Column Info */
	private String faxNo03 = null;
	/* Column Info */
	private String trspWoSeq = null;
	/* Column Info */
	private String woN2ndEml = null;
	/* Column Info */
	private String faxBatchInd = null;
	/* Column Info */
	private String contiCd = null;
	/* Column Info */
	private String rdCgo = null;
	/* Column Info */
	private String emailTitle = null;
	/* Column Info */
	private String woVndrSeq = null;
	/* Column Info */
	private String woIssStsCd = null;
	/* Column Info */
	private String ediTrspSoSeq = null;
	/* Column Info */
	private String fltFileNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String woEdiUseFlg = null;
	/* Column Info */
	private String scgGrpSeq = null;
	/* Column Info */
	private String faxNo01 = null;
	/* Column Info */
	private String ediEqNo = null;
	/* Column Info */
	private String woDtlUseFlg = null;
	/* Column Info */
	private String trspCrrModCd = null;
	/* Column Info */
	private String faxAppCd = null;
	/* Column Info */
	private String ediTrspSoOfcCtyCd = null;
	/* Column Info */
	private String faxRcvInfo = null;
	/* Column Info */
	private String faxTitle = null;
	/* Column Info */
	private String faxSysCd = null;
	/* Column Info */
	private String woPrnUseFlg = null;
	/* Column Info */
	private String ediLoc = null;
	/* Column Info */
	private String woN2ndFaxNo = null;
	/* Column Info */
	private String ediTrspWoOfcCtyCd = null;
	/* Column Info */
	private String ediRcvrNm = null;
	/* Column Info */
	private String woIssNo = null;
	/* Column Info */
	private String woN3rdFaxNo = null;
	/* Column Info */
	private String trspWoOfcCtyCd = null;
	/* Column Info */
	private String ediVndrSeq = null;
	/* Column Info */
	private String woFaxUseFlg = null;
	/* Column Info */
	private String rtDpUseFlg = null;
	/* Column Info */
	private String faxParam = null;
	/* Column Info */
	private String woCntcPsonNm = null;
	/* Column Info */
	private String preDisUseFlg = null;
	/* Column Info */
	private String woPrvGrpSeq = null;
	/* Column Info */
	private String woEmlUseFlg = null;
	/* Column Info */
	private String soCreOfcCd = null;
	/* Column Info */
	private String ediFltCd = null;
	/* Column Info */
	private String trspBndCd = null;
	/* Column Info */
	private String wtrRcvTermCd = null;
	/* Column Info */
	private String wtrDeTermCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public WorkOrderPreviewVO() {}

	public WorkOrderPreviewVO(String ibflag, String pagerows, String contiCd, String woPrvGrpSeq, String woIssNo, String woFmtTpCd, String woVndrSeq, String woIssStsCd, String trspWoOfcCtyCd, String trspWoSeq, String rdCgo, String woPrnUseFlg, String woEmlUseFlg, String woFaxUseFlg, String woEdiUseFlg, String woDtlUseFlg, String interUseFlg, String rtDpUseFlg, String cmdtDpUseFlg, String preDisUseFlg, String woRmk, String woN1stEml, String woN2ndEml, String woN3rdEml, String woN1stFaxNo, String woN2ndFaxNo, String woN3rdFaxNo, String ediLoc, String ediTrspSoOfcCtyCd, String ediTrspSoSeq, String ediTrspWoOfcCtyCd, String ediTrspWoSeq, String ediWoIssKnt, String ediWoIssStsCd, String ediVndrSeq, String trspCrrModCd, String trspCostDtlModCd, String ediEqNo, String ediRcvrNm, String scgGrpSeq, String faxNo01, String faxNo02, String faxNo03, String faxSysCd, String faxAppCd, String faxBatchInd, String faxTitle, String faxParam, String faxRcvInfo, String emlNo01, String emlNo02, String emlNo03, String emailTitle, String emailContents, String woCxlFlg, String fltFileNo, String woCntcPsonNm, String soCreOfcCd, String ediFltCd, String trspBndCd, String wtrRcvTermCd, String wtrDeTermCd) {
		this.cmdtDpUseFlg = cmdtDpUseFlg;
		this.woCxlFlg = woCxlFlg;
		this.emailContents = emailContents;
		this.interUseFlg = interUseFlg;
		this.ediWoIssStsCd = ediWoIssStsCd;
		this.pagerows = pagerows;
		this.emlNo03 = emlNo03;
		this.woN1stFaxNo = woN1stFaxNo;
		this.trspCostDtlModCd = trspCostDtlModCd;
		this.woN3rdEml = woN3rdEml;
		this.woFmtTpCd = woFmtTpCd;
		this.emlNo01 = emlNo01;
		this.woN1stEml = woN1stEml;
		this.emlNo02 = emlNo02;
		this.woRmk = woRmk;
		this.ediTrspWoSeq = ediTrspWoSeq;
		this.ediWoIssKnt = ediWoIssKnt;
		this.faxNo02 = faxNo02;
		this.faxNo03 = faxNo03;
		this.trspWoSeq = trspWoSeq;
		this.woN2ndEml = woN2ndEml;
		this.faxBatchInd = faxBatchInd;
		this.contiCd = contiCd;
		this.rdCgo = rdCgo;
		this.emailTitle = emailTitle;
		this.woVndrSeq = woVndrSeq;
		this.woIssStsCd = woIssStsCd;
		this.ediTrspSoSeq = ediTrspSoSeq;
		this.fltFileNo = fltFileNo;
		this.ibflag = ibflag;
		this.woEdiUseFlg = woEdiUseFlg;
		this.scgGrpSeq = scgGrpSeq;
		this.faxNo01 = faxNo01;
		this.ediEqNo = ediEqNo;
		this.woDtlUseFlg = woDtlUseFlg;
		this.trspCrrModCd = trspCrrModCd;
		this.faxAppCd = faxAppCd;
		this.ediTrspSoOfcCtyCd = ediTrspSoOfcCtyCd;
		this.faxRcvInfo = faxRcvInfo;
		this.faxTitle = faxTitle;
		this.faxSysCd = faxSysCd;
		this.woPrnUseFlg = woPrnUseFlg;
		this.ediLoc = ediLoc;
		this.woN2ndFaxNo = woN2ndFaxNo;
		this.ediTrspWoOfcCtyCd = ediTrspWoOfcCtyCd;
		this.ediRcvrNm = ediRcvrNm;
		this.woIssNo = woIssNo;
		this.woN3rdFaxNo = woN3rdFaxNo;
		this.trspWoOfcCtyCd = trspWoOfcCtyCd;
		this.ediVndrSeq = ediVndrSeq;
		this.woFaxUseFlg = woFaxUseFlg;
		this.rtDpUseFlg = rtDpUseFlg;
		this.faxParam = faxParam;
		this.woCntcPsonNm = woCntcPsonNm;
		this.preDisUseFlg = preDisUseFlg;
		this.woPrvGrpSeq = woPrvGrpSeq;
		this.woEmlUseFlg = woEmlUseFlg;
		this.soCreOfcCd = soCreOfcCd;
		this.ediFltCd = ediFltCd;
		this.trspBndCd = trspBndCd;
		this.wtrRcvTermCd = wtrRcvTermCd;
		this.wtrDeTermCd = wtrDeTermCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cmdt_dp_use_flg", getCmdtDpUseFlg());
		this.hashColumns.put("wo_cxl_flg", getWoCxlFlg());
		this.hashColumns.put("email_contents", getEmailContents());
		this.hashColumns.put("inter_use_flg", getInterUseFlg());
		this.hashColumns.put("edi_wo_iss_sts_cd", getEdiWoIssStsCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eml_no_03", getEmlNo03());
		this.hashColumns.put("wo_n1st_fax_no", getWoN1stFaxNo());
		this.hashColumns.put("trsp_cost_dtl_mod_cd", getTrspCostDtlModCd());
		this.hashColumns.put("wo_n3rd_eml", getWoN3rdEml());
		this.hashColumns.put("wo_fmt_tp_cd", getWoFmtTpCd());
		this.hashColumns.put("eml_no_01", getEmlNo01());
		this.hashColumns.put("wo_n1st_eml", getWoN1stEml());
		this.hashColumns.put("eml_no_02", getEmlNo02());
		this.hashColumns.put("wo_rmk", getWoRmk());
		this.hashColumns.put("edi_trsp_wo_seq", getEdiTrspWoSeq());
		this.hashColumns.put("edi_wo_iss_knt", getEdiWoIssKnt());
		this.hashColumns.put("fax_no_02", getFaxNo02());
		this.hashColumns.put("fax_no_03", getFaxNo03());
		this.hashColumns.put("trsp_wo_seq", getTrspWoSeq());
		this.hashColumns.put("wo_n2nd_eml", getWoN2ndEml());
		this.hashColumns.put("fax_batch_ind", getFaxBatchInd());
		this.hashColumns.put("conti_cd", getContiCd());
		this.hashColumns.put("rd_cgo", getRdCgo());
		this.hashColumns.put("email_title", getEmailTitle());
		this.hashColumns.put("wo_vndr_seq", getWoVndrSeq());
		this.hashColumns.put("wo_iss_sts_cd", getWoIssStsCd());
		this.hashColumns.put("edi_trsp_so_seq", getEdiTrspSoSeq());
		this.hashColumns.put("flt_file_no", getFltFileNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("wo_edi_use_flg", getWoEdiUseFlg());
		this.hashColumns.put("scg_grp_seq", getScgGrpSeq());
		this.hashColumns.put("fax_no_01", getFaxNo01());
		this.hashColumns.put("edi_eq_no", getEdiEqNo());
		this.hashColumns.put("wo_dtl_use_flg", getWoDtlUseFlg());
		this.hashColumns.put("trsp_crr_mod_cd", getTrspCrrModCd());
		this.hashColumns.put("fax_app_cd", getFaxAppCd());
		this.hashColumns.put("edi_trsp_so_ofc_cty_cd", getEdiTrspSoOfcCtyCd());
		this.hashColumns.put("fax_rcv_info", getFaxRcvInfo());
		this.hashColumns.put("fax_title", getFaxTitle());
		this.hashColumns.put("fax_sys_cd", getFaxSysCd());
		this.hashColumns.put("wo_prn_use_flg", getWoPrnUseFlg());
		this.hashColumns.put("edi_loc", getEdiLoc());
		this.hashColumns.put("wo_n2nd_fax_no", getWoN2ndFaxNo());
		this.hashColumns.put("edi_trsp_wo_ofc_cty_cd", getEdiTrspWoOfcCtyCd());
		this.hashColumns.put("edi_rcvr_nm", getEdiRcvrNm());
		this.hashColumns.put("wo_iss_no", getWoIssNo());
		this.hashColumns.put("wo_n3rd_fax_no", getWoN3rdFaxNo());
		this.hashColumns.put("trsp_wo_ofc_cty_cd", getTrspWoOfcCtyCd());
		this.hashColumns.put("edi_vndr_seq", getEdiVndrSeq());
		this.hashColumns.put("wo_fax_use_flg", getWoFaxUseFlg());
		this.hashColumns.put("rt_dp_use_flg", getRtDpUseFlg());
		this.hashColumns.put("fax_param", getFaxParam());
		this.hashColumns.put("wo_cntc_pson_nm", getWoCntcPsonNm());
		this.hashColumns.put("pre_dis_use_flg", getPreDisUseFlg());
		this.hashColumns.put("wo_prv_grp_seq", getWoPrvGrpSeq());
		this.hashColumns.put("wo_eml_use_flg", getWoEmlUseFlg());
		this.hashColumns.put("so_cre_ofc_cd", getSoCreOfcCd());
		this.hashColumns.put("edi_flt_cd", getEdiFltCd());
		this.hashColumns.put("trsp_bnd_cd", getTrspBndCd());
		this.hashColumns.put("wtr_rcv_term_cd", getWtrRcvTermCd());
		this.hashColumns.put("wtr_de_term_cd", getWtrDeTermCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cmdt_dp_use_flg", "cmdtDpUseFlg");
		this.hashFields.put("wo_cxl_flg", "woCxlFlg");
		this.hashFields.put("email_contents", "emailContents");
		this.hashFields.put("inter_use_flg", "interUseFlg");
		this.hashFields.put("edi_wo_iss_sts_cd", "ediWoIssStsCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eml_no_03", "emlNo03");
		this.hashFields.put("wo_n1st_fax_no", "woN1stFaxNo");
		this.hashFields.put("trsp_cost_dtl_mod_cd", "trspCostDtlModCd");
		this.hashFields.put("wo_n3rd_eml", "woN3rdEml");
		this.hashFields.put("wo_fmt_tp_cd", "woFmtTpCd");
		this.hashFields.put("eml_no_01", "emlNo01");
		this.hashFields.put("wo_n1st_eml", "woN1stEml");
		this.hashFields.put("eml_no_02", "emlNo02");
		this.hashFields.put("wo_rmk", "woRmk");
		this.hashFields.put("edi_trsp_wo_seq", "ediTrspWoSeq");
		this.hashFields.put("edi_wo_iss_knt", "ediWoIssKnt");
		this.hashFields.put("fax_no_02", "faxNo02");
		this.hashFields.put("fax_no_03", "faxNo03");
		this.hashFields.put("trsp_wo_seq", "trspWoSeq");
		this.hashFields.put("wo_n2nd_eml", "woN2ndEml");
		this.hashFields.put("fax_batch_ind", "faxBatchInd");
		this.hashFields.put("conti_cd", "contiCd");
		this.hashFields.put("rd_cgo", "rdCgo");
		this.hashFields.put("email_title", "emailTitle");
		this.hashFields.put("wo_vndr_seq", "woVndrSeq");
		this.hashFields.put("wo_iss_sts_cd", "woIssStsCd");
		this.hashFields.put("edi_trsp_so_seq", "ediTrspSoSeq");
		this.hashFields.put("flt_file_no", "fltFileNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("wo_edi_use_flg", "woEdiUseFlg");
		this.hashFields.put("scg_grp_seq", "scgGrpSeq");
		this.hashFields.put("fax_no_01", "faxNo01");
		this.hashFields.put("edi_eq_no", "ediEqNo");
		this.hashFields.put("wo_dtl_use_flg", "woDtlUseFlg");
		this.hashFields.put("trsp_crr_mod_cd", "trspCrrModCd");
		this.hashFields.put("fax_app_cd", "faxAppCd");
		this.hashFields.put("edi_trsp_so_ofc_cty_cd", "ediTrspSoOfcCtyCd");
		this.hashFields.put("fax_rcv_info", "faxRcvInfo");
		this.hashFields.put("fax_title", "faxTitle");
		this.hashFields.put("fax_sys_cd", "faxSysCd");
		this.hashFields.put("wo_prn_use_flg", "woPrnUseFlg");
		this.hashFields.put("edi_loc", "ediLoc");
		this.hashFields.put("wo_n2nd_fax_no", "woN2ndFaxNo");
		this.hashFields.put("edi_trsp_wo_ofc_cty_cd", "ediTrspWoOfcCtyCd");
		this.hashFields.put("edi_rcvr_nm", "ediRcvrNm");
		this.hashFields.put("wo_iss_no", "woIssNo");
		this.hashFields.put("wo_n3rd_fax_no", "woN3rdFaxNo");
		this.hashFields.put("trsp_wo_ofc_cty_cd", "trspWoOfcCtyCd");
		this.hashFields.put("edi_vndr_seq", "ediVndrSeq");
		this.hashFields.put("wo_fax_use_flg", "woFaxUseFlg");
		this.hashFields.put("rt_dp_use_flg", "rtDpUseFlg");
		this.hashFields.put("fax_param", "faxParam");
		this.hashFields.put("wo_cntc_pson_nm", "woCntcPsonNm");
		this.hashFields.put("pre_dis_use_flg", "preDisUseFlg");
		this.hashFields.put("wo_prv_grp_seq", "woPrvGrpSeq");
		this.hashFields.put("wo_eml_use_flg", "woEmlUseFlg");
		this.hashFields.put("so_cre_ofc_cd", "soCreOfcCd");
		this.hashFields.put("edi_flt_cd", "ediFltCd");
		this.hashFields.put("trsp_bnd_cd", "trspBndCd");
		this.hashFields.put("wtr_rcv_term_cd", "wtrRcvTermCd");
		this.hashFields.put("wtr_de_term_cd", "wtrDeTermCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cmdtDpUseFlg
	 */
	public String getCmdtDpUseFlg() {
		return this.cmdtDpUseFlg;
	}
	
	/**
	 * Column Info
	 * @return woCxlFlg
	 */
	public String getWoCxlFlg() {
		return this.woCxlFlg;
	}
	
	/**
	 * Column Info
	 * @return emailContents
	 */
	public String getEmailContents() {
		return this.emailContents;
	}
	
	/**
	 * Column Info
	 * @return interUseFlg
	 */
	public String getInterUseFlg() {
		return this.interUseFlg;
	}
	
	/**
	 * Column Info
	 * @return ediWoIssStsCd
	 */
	public String getEdiWoIssStsCd() {
		return this.ediWoIssStsCd;
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
	 * @return emlNo03
	 */
	public String getEmlNo03() {
		return this.emlNo03;
	}
	
	/**
	 * Column Info
	 * @return woN1stFaxNo
	 */
	public String getWoN1stFaxNo() {
		return this.woN1stFaxNo;
	}
	
	/**
	 * Column Info
	 * @return trspCostDtlModCd
	 */
	public String getTrspCostDtlModCd() {
		return this.trspCostDtlModCd;
	}
	
	/**
	 * Column Info
	 * @return woN3rdEml
	 */
	public String getWoN3rdEml() {
		return this.woN3rdEml;
	}
	
	/**
	 * Column Info
	 * @return woFmtTpCd
	 */
	public String getWoFmtTpCd() {
		return this.woFmtTpCd;
	}
	
	/**
	 * Column Info
	 * @return emlNo01
	 */
	public String getEmlNo01() {
		return this.emlNo01;
	}
	
	/**
	 * Column Info
	 * @return woN1stEml
	 */
	public String getWoN1stEml() {
		return this.woN1stEml;
	}
	
	/**
	 * Column Info
	 * @return emlNo02
	 */
	public String getEmlNo02() {
		return this.emlNo02;
	}
	
	/**
	 * Column Info
	 * @return woRmk
	 */
	public String getWoRmk() {
		return this.woRmk;
	}
	
	/**
	 * Column Info
	 * @return ediTrspWoSeq
	 */
	public String getEdiTrspWoSeq() {
		return this.ediTrspWoSeq;
	}
	
	/**
	 * Column Info
	 * @return ediWoIssKnt
	 */
	public String getEdiWoIssKnt() {
		return this.ediWoIssKnt;
	}
	
	/**
	 * Column Info
	 * @return faxNo02
	 */
	public String getFaxNo02() {
		return this.faxNo02;
	}
	
	/**
	 * Column Info
	 * @return faxNo03
	 */
	public String getFaxNo03() {
		return this.faxNo03;
	}
	
	/**
	 * Column Info
	 * @return trspWoSeq
	 */
	public String getTrspWoSeq() {
		return this.trspWoSeq;
	}
	
	/**
	 * Column Info
	 * @return woN2ndEml
	 */
	public String getWoN2ndEml() {
		return this.woN2ndEml;
	}
	
	/**
	 * Column Info
	 * @return faxBatchInd
	 */
	public String getFaxBatchInd() {
		return this.faxBatchInd;
	}
	
	/**
	 * Column Info
	 * @return contiCd
	 */
	public String getContiCd() {
		return this.contiCd;
	}
	
	/**
	 * Column Info
	 * @return rdCgo
	 */
	public String getRdCgo() {
		return this.rdCgo;
	}
	
	/**
	 * Column Info
	 * @return emailTitle
	 */
	public String getEmailTitle() {
		return this.emailTitle;
	}
	
	/**
	 * Column Info
	 * @return woVndrSeq
	 */
	public String getWoVndrSeq() {
		return this.woVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return woIssStsCd
	 */
	public String getWoIssStsCd() {
		return this.woIssStsCd;
	}
	
	/**
	 * Column Info
	 * @return ediTrspSoSeq
	 */
	public String getEdiTrspSoSeq() {
		return this.ediTrspSoSeq;
	}
	
	/**
	 * Column Info
	 * @return fltFileNo
	 */
	public String getFltFileNo() {
		return this.fltFileNo;
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
	 * @return woEdiUseFlg
	 */
	public String getWoEdiUseFlg() {
		return this.woEdiUseFlg;
	}
	
	/**
	 * Column Info
	 * @return scgGrpSeq
	 */
	public String getScgGrpSeq() {
		return this.scgGrpSeq;
	}
	
	/**
	 * Column Info
	 * @return faxNo01
	 */
	public String getFaxNo01() {
		return this.faxNo01;
	}
	
	/**
	 * Column Info
	 * @return ediEqNo
	 */
	public String getEdiEqNo() {
		return this.ediEqNo;
	}
	
	/**
	 * Column Info
	 * @return woDtlUseFlg
	 */
	public String getWoDtlUseFlg() {
		return this.woDtlUseFlg;
	}
	
	/**
	 * Column Info
	 * @return trspCrrModCd
	 */
	public String getTrspCrrModCd() {
		return this.trspCrrModCd;
	}
	
	/**
	 * Column Info
	 * @return faxAppCd
	 */
	public String getFaxAppCd() {
		return this.faxAppCd;
	}
	
	/**
	 * Column Info
	 * @return ediTrspSoOfcCtyCd
	 */
	public String getEdiTrspSoOfcCtyCd() {
		return this.ediTrspSoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return faxRcvInfo
	 */
	public String getFaxRcvInfo() {
		return this.faxRcvInfo;
	}
	
	/**
	 * Column Info
	 * @return faxTitle
	 */
	public String getFaxTitle() {
		return this.faxTitle;
	}
	
	/**
	 * Column Info
	 * @return faxSysCd
	 */
	public String getFaxSysCd() {
		return this.faxSysCd;
	}
	
	/**
	 * Column Info
	 * @return woPrnUseFlg
	 */
	public String getWoPrnUseFlg() {
		return this.woPrnUseFlg;
	}
	
	/**
	 * Column Info
	 * @return ediLoc
	 */
	public String getEdiLoc() {
		return this.ediLoc;
	}
	
	/**
	 * Column Info
	 * @return woN2ndFaxNo
	 */
	public String getWoN2ndFaxNo() {
		return this.woN2ndFaxNo;
	}
	
	/**
	 * Column Info
	 * @return ediTrspWoOfcCtyCd
	 */
	public String getEdiTrspWoOfcCtyCd() {
		return this.ediTrspWoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return ediRcvrNm
	 */
	public String getEdiRcvrNm() {
		return this.ediRcvrNm;
	}
	
	/**
	 * Column Info
	 * @return woIssNo
	 */
	public String getWoIssNo() {
		return this.woIssNo;
	}
	
	/**
	 * Column Info
	 * @return woN3rdFaxNo
	 */
	public String getWoN3rdFaxNo() {
		return this.woN3rdFaxNo;
	}
	
	/**
	 * Column Info
	 * @return trspWoOfcCtyCd
	 */
	public String getTrspWoOfcCtyCd() {
		return this.trspWoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return ediVndrSeq
	 */
	public String getEdiVndrSeq() {
		return this.ediVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return woFaxUseFlg
	 */
	public String getWoFaxUseFlg() {
		return this.woFaxUseFlg;
	}
	
	/**
	 * Column Info
	 * @return rtDpUseFlg
	 */
	public String getRtDpUseFlg() {
		return this.rtDpUseFlg;
	}
	
	/**
	 * Column Info
	 * @return faxParam
	 */
	public String getFaxParam() {
		return this.faxParam;
	}
	
	/**
	 * Column Info
	 * @return woCntcPsonNm
	 */
	public String getWoCntcPsonNm() {
		return this.woCntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @return preDisUseFlg
	 */
	public String getPreDisUseFlg() {
		return this.preDisUseFlg;
	}
	
	/**
	 * Column Info
	 * @return woPrvGrpSeq
	 */
	public String getWoPrvGrpSeq() {
		return this.woPrvGrpSeq;
	}
	
	/**
	 * Column Info
	 * @return woEmlUseFlg
	 */
	public String getWoEmlUseFlg() {
		return this.woEmlUseFlg;
	}
	
	/**
	 * Column Info
	 * @return soCreOfcCd
	 */
	public String getSoCreOfcCd() {
		return this.soCreOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ediFltCd
	 */
	public String getEdiFltCd() {
		return this.ediFltCd;
	}
	
	/**
	 * Column Info
	 * @return trspBndCd
	 */
	public String getTrspBndCd() {
		return this.trspBndCd;
	}
	
	/**
	 * Column Info
	 * @return wtrRcvTermCd
	 */
	public String getWtrRcvTermCd() {
		return this.wtrRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return wtrDeTermCd
	 */
	public String getWtrDeTermCd() {
		return this.wtrDeTermCd;
	}
	/**
	 * Column Info
	 * @param cmdtDpUseFlg
	 */
	public void setCmdtDpUseFlg(String cmdtDpUseFlg) {
		this.cmdtDpUseFlg = cmdtDpUseFlg;
	}
	
	/**
	 * Column Info
	 * @param woCxlFlg
	 */
	public void setWoCxlFlg(String woCxlFlg) {
		this.woCxlFlg = woCxlFlg;
	}
	
	/**
	 * Column Info
	 * @param emailContents
	 */
	public void setEmailContents(String emailContents) {
		this.emailContents = emailContents;
	}
	
	/**
	 * Column Info
	 * @param interUseFlg
	 */
	public void setInterUseFlg(String interUseFlg) {
		this.interUseFlg = interUseFlg;
	}
	
	/**
	 * Column Info
	 * @param ediWoIssStsCd
	 */
	public void setEdiWoIssStsCd(String ediWoIssStsCd) {
		this.ediWoIssStsCd = ediWoIssStsCd;
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
	 * @param emlNo03
	 */
	public void setEmlNo03(String emlNo03) {
		this.emlNo03 = emlNo03;
	}
	
	/**
	 * Column Info
	 * @param woN1stFaxNo
	 */
	public void setWoN1stFaxNo(String woN1stFaxNo) {
		this.woN1stFaxNo = woN1stFaxNo;
	}
	
	/**
	 * Column Info
	 * @param trspCostDtlModCd
	 */
	public void setTrspCostDtlModCd(String trspCostDtlModCd) {
		this.trspCostDtlModCd = trspCostDtlModCd;
	}
	
	/**
	 * Column Info
	 * @param woN3rdEml
	 */
	public void setWoN3rdEml(String woN3rdEml) {
		this.woN3rdEml = woN3rdEml;
	}
	
	/**
	 * Column Info
	 * @param woFmtTpCd
	 */
	public void setWoFmtTpCd(String woFmtTpCd) {
		this.woFmtTpCd = woFmtTpCd;
	}
	
	/**
	 * Column Info
	 * @param emlNo01
	 */
	public void setEmlNo01(String emlNo01) {
		this.emlNo01 = emlNo01;
	}
	
	/**
	 * Column Info
	 * @param woN1stEml
	 */
	public void setWoN1stEml(String woN1stEml) {
		this.woN1stEml = woN1stEml;
	}
	
	/**
	 * Column Info
	 * @param emlNo02
	 */
	public void setEmlNo02(String emlNo02) {
		this.emlNo02 = emlNo02;
	}
	
	/**
	 * Column Info
	 * @param woRmk
	 */
	public void setWoRmk(String woRmk) {
		this.woRmk = woRmk;
	}
	
	/**
	 * Column Info
	 * @param ediTrspWoSeq
	 */
	public void setEdiTrspWoSeq(String ediTrspWoSeq) {
		this.ediTrspWoSeq = ediTrspWoSeq;
	}
	
	/**
	 * Column Info
	 * @param ediWoIssKnt
	 */
	public void setEdiWoIssKnt(String ediWoIssKnt) {
		this.ediWoIssKnt = ediWoIssKnt;
	}
	
	/**
	 * Column Info
	 * @param faxNo02
	 */
	public void setFaxNo02(String faxNo02) {
		this.faxNo02 = faxNo02;
	}
	
	/**
	 * Column Info
	 * @param faxNo03
	 */
	public void setFaxNo03(String faxNo03) {
		this.faxNo03 = faxNo03;
	}
	
	/**
	 * Column Info
	 * @param trspWoSeq
	 */
	public void setTrspWoSeq(String trspWoSeq) {
		this.trspWoSeq = trspWoSeq;
	}
	
	/**
	 * Column Info
	 * @param woN2ndEml
	 */
	public void setWoN2ndEml(String woN2ndEml) {
		this.woN2ndEml = woN2ndEml;
	}
	
	/**
	 * Column Info
	 * @param faxBatchInd
	 */
	public void setFaxBatchInd(String faxBatchInd) {
		this.faxBatchInd = faxBatchInd;
	}
	
	/**
	 * Column Info
	 * @param contiCd
	 */
	public void setContiCd(String contiCd) {
		this.contiCd = contiCd;
	}
	
	/**
	 * Column Info
	 * @param rdCgo
	 */
	public void setRdCgo(String rdCgo) {
		this.rdCgo = rdCgo;
	}
	
	/**
	 * Column Info
	 * @param emailTitle
	 */
	public void setEmailTitle(String emailTitle) {
		this.emailTitle = emailTitle;
	}
	
	/**
	 * Column Info
	 * @param woVndrSeq
	 */
	public void setWoVndrSeq(String woVndrSeq) {
		this.woVndrSeq = woVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param woIssStsCd
	 */
	public void setWoIssStsCd(String woIssStsCd) {
		this.woIssStsCd = woIssStsCd;
	}
	
	/**
	 * Column Info
	 * @param ediTrspSoSeq
	 */
	public void setEdiTrspSoSeq(String ediTrspSoSeq) {
		this.ediTrspSoSeq = ediTrspSoSeq;
	}
	
	/**
	 * Column Info
	 * @param fltFileNo
	 */
	public void setFltFileNo(String fltFileNo) {
		this.fltFileNo = fltFileNo;
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
	 * @param woEdiUseFlg
	 */
	public void setWoEdiUseFlg(String woEdiUseFlg) {
		this.woEdiUseFlg = woEdiUseFlg;
	}
	
	/**
	 * Column Info
	 * @param scgGrpSeq
	 */
	public void setScgGrpSeq(String scgGrpSeq) {
		this.scgGrpSeq = scgGrpSeq;
	}
	
	/**
	 * Column Info
	 * @param faxNo01
	 */
	public void setFaxNo01(String faxNo01) {
		this.faxNo01 = faxNo01;
	}
	
	/**
	 * Column Info
	 * @param ediEqNo
	 */
	public void setEdiEqNo(String ediEqNo) {
		this.ediEqNo = ediEqNo;
	}
	
	/**
	 * Column Info
	 * @param woDtlUseFlg
	 */
	public void setWoDtlUseFlg(String woDtlUseFlg) {
		this.woDtlUseFlg = woDtlUseFlg;
	}
	
	/**
	 * Column Info
	 * @param trspCrrModCd
	 */
	public void setTrspCrrModCd(String trspCrrModCd) {
		this.trspCrrModCd = trspCrrModCd;
	}
	
	/**
	 * Column Info
	 * @param faxAppCd
	 */
	public void setFaxAppCd(String faxAppCd) {
		this.faxAppCd = faxAppCd;
	}
	
	/**
	 * Column Info
	 * @param ediTrspSoOfcCtyCd
	 */
	public void setEdiTrspSoOfcCtyCd(String ediTrspSoOfcCtyCd) {
		this.ediTrspSoOfcCtyCd = ediTrspSoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param faxRcvInfo
	 */
	public void setFaxRcvInfo(String faxRcvInfo) {
		this.faxRcvInfo = faxRcvInfo;
	}
	
	/**
	 * Column Info
	 * @param faxTitle
	 */
	public void setFaxTitle(String faxTitle) {
		this.faxTitle = faxTitle;
	}
	
	/**
	 * Column Info
	 * @param faxSysCd
	 */
	public void setFaxSysCd(String faxSysCd) {
		this.faxSysCd = faxSysCd;
	}
	
	/**
	 * Column Info
	 * @param woPrnUseFlg
	 */
	public void setWoPrnUseFlg(String woPrnUseFlg) {
		this.woPrnUseFlg = woPrnUseFlg;
	}
	
	/**
	 * Column Info
	 * @param ediLoc
	 */
	public void setEdiLoc(String ediLoc) {
		this.ediLoc = ediLoc;
	}
	
	/**
	 * Column Info
	 * @param woN2ndFaxNo
	 */
	public void setWoN2ndFaxNo(String woN2ndFaxNo) {
		this.woN2ndFaxNo = woN2ndFaxNo;
	}
	
	/**
	 * Column Info
	 * @param ediTrspWoOfcCtyCd
	 */
	public void setEdiTrspWoOfcCtyCd(String ediTrspWoOfcCtyCd) {
		this.ediTrspWoOfcCtyCd = ediTrspWoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param ediRcvrNm
	 */
	public void setEdiRcvrNm(String ediRcvrNm) {
		this.ediRcvrNm = ediRcvrNm;
	}
	
	/**
	 * Column Info
	 * @param woIssNo
	 */
	public void setWoIssNo(String woIssNo) {
		this.woIssNo = woIssNo;
	}
	
	/**
	 * Column Info
	 * @param woN3rdFaxNo
	 */
	public void setWoN3rdFaxNo(String woN3rdFaxNo) {
		this.woN3rdFaxNo = woN3rdFaxNo;
	}
	
	/**
	 * Column Info
	 * @param trspWoOfcCtyCd
	 */
	public void setTrspWoOfcCtyCd(String trspWoOfcCtyCd) {
		this.trspWoOfcCtyCd = trspWoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param ediVndrSeq
	 */
	public void setEdiVndrSeq(String ediVndrSeq) {
		this.ediVndrSeq = ediVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param woFaxUseFlg
	 */
	public void setWoFaxUseFlg(String woFaxUseFlg) {
		this.woFaxUseFlg = woFaxUseFlg;
	}
	
	/**
	 * Column Info
	 * @param rtDpUseFlg
	 */
	public void setRtDpUseFlg(String rtDpUseFlg) {
		this.rtDpUseFlg = rtDpUseFlg;
	}
	
	/**
	 * Column Info
	 * @param faxParam
	 */
	public void setFaxParam(String faxParam) {
		this.faxParam = faxParam;
	}
	
	/**
	 * Column Info
	 * @param woCntcPsonNm
	 */
	public void setWoCntcPsonNm(String woCntcPsonNm) {
		this.woCntcPsonNm = woCntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @param preDisUseFlg
	 */
	public void setPreDisUseFlg(String preDisUseFlg) {
		this.preDisUseFlg = preDisUseFlg;
	}
	
	/**
	 * Column Info
	 * @param woPrvGrpSeq
	 */
	public void setWoPrvGrpSeq(String woPrvGrpSeq) {
		this.woPrvGrpSeq = woPrvGrpSeq;
	}
	
	/**
	 * Column Info
	 * @param woEmlUseFlg
	 */
	public void setWoEmlUseFlg(String woEmlUseFlg) {
		this.woEmlUseFlg = woEmlUseFlg;
	}
	
	/**
	 * Column Info
	 * @param soCreOfcCd
	 */
	public void setSoCreOfcCd(String soCreOfcCd) {
		this.soCreOfcCd = soCreOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ediFltCd
	 */
	public void setEdiFltCd(String ediFltCd) {
		this.ediFltCd = ediFltCd;
	}
	
	/**
	 * Column Info
	 * @param trspBndCd
	 */
	public void setTrspBndCd(String trspBndCd) {
		this.trspBndCd = trspBndCd;
	}
	
	/**
	 * Column Info
	 * @param wtrRcvTermCd
	 */
	public void setWtrRcvTermCd(String wtrRcvTermCd) {
		this.wtrRcvTermCd = wtrRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param wtrDeTermCd
	 */
	public void setWtrDeTermCd(String wtrDeTermCd) {
		this.wtrDeTermCd = wtrDeTermCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCmdtDpUseFlg(JSPUtil.getParameter(request, "cmdt_dp_use_flg", ""));
		setWoCxlFlg(JSPUtil.getParameter(request, "wo_cxl_flg", ""));
		setEmailContents(JSPUtil.getParameter(request, "email_contents", ""));
		setInterUseFlg(JSPUtil.getParameter(request, "inter_use_flg", ""));
		setEdiWoIssStsCd(JSPUtil.getParameter(request, "edi_wo_iss_sts_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setEmlNo03(JSPUtil.getParameter(request, "eml_no_03", ""));
		setWoN1stFaxNo(JSPUtil.getParameter(request, "wo_n1st_fax_no", ""));
		setTrspCostDtlModCd(JSPUtil.getParameter(request, "trsp_cost_dtl_mod_cd", ""));
		setWoN3rdEml(JSPUtil.getParameter(request, "wo_n3rd_eml", ""));
		setWoFmtTpCd(JSPUtil.getParameter(request, "wo_fmt_tp_cd", ""));
		setEmlNo01(JSPUtil.getParameter(request, "eml_no_01", ""));
		setWoN1stEml(JSPUtil.getParameter(request, "wo_n1st_eml", ""));
		setEmlNo02(JSPUtil.getParameter(request, "eml_no_02", ""));
		setWoRmk(JSPUtil.getParameter(request, "wo_rmk", ""));
		setEdiTrspWoSeq(JSPUtil.getParameter(request, "edi_trsp_wo_seq", ""));
		setEdiWoIssKnt(JSPUtil.getParameter(request, "edi_wo_iss_knt", ""));
		setFaxNo02(JSPUtil.getParameter(request, "fax_no_02", ""));
		setFaxNo03(JSPUtil.getParameter(request, "fax_no_03", ""));
		setTrspWoSeq(JSPUtil.getParameter(request, "trsp_wo_seq", ""));
		setWoN2ndEml(JSPUtil.getParameter(request, "wo_n2nd_eml", ""));
		setFaxBatchInd(JSPUtil.getParameter(request, "fax_batch_ind", ""));
		setContiCd(JSPUtil.getParameter(request, "conti_cd", ""));
		setRdCgo(JSPUtil.getParameter(request, "rd_cgo", ""));
		setEmailTitle(JSPUtil.getParameter(request, "email_title", ""));
		setWoVndrSeq(JSPUtil.getParameter(request, "wo_vndr_seq", ""));
		setWoIssStsCd(JSPUtil.getParameter(request, "wo_iss_sts_cd", ""));
		setEdiTrspSoSeq(JSPUtil.getParameter(request, "edi_trsp_so_seq", ""));
		setFltFileNo(JSPUtil.getParameter(request, "flt_file_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setWoEdiUseFlg(JSPUtil.getParameter(request, "wo_edi_use_flg", ""));
		setScgGrpSeq(JSPUtil.getParameter(request, "scg_grp_seq", ""));
		setFaxNo01(JSPUtil.getParameter(request, "fax_no_01", ""));
		setEdiEqNo(JSPUtil.getParameter(request, "edi_eq_no", ""));
		setWoDtlUseFlg(JSPUtil.getParameter(request, "wo_dtl_use_flg", ""));
		setTrspCrrModCd(JSPUtil.getParameter(request, "trsp_crr_mod_cd", ""));
		setFaxAppCd(JSPUtil.getParameter(request, "fax_app_cd", ""));
		setEdiTrspSoOfcCtyCd(JSPUtil.getParameter(request, "edi_trsp_so_ofc_cty_cd", ""));
		setFaxRcvInfo(JSPUtil.getParameter(request, "fax_rcv_info", ""));
		setFaxTitle(JSPUtil.getParameter(request, "fax_title", ""));
		setFaxSysCd(JSPUtil.getParameter(request, "fax_sys_cd", ""));
		setWoPrnUseFlg(JSPUtil.getParameter(request, "wo_prn_use_flg", ""));
		setEdiLoc(JSPUtil.getParameter(request, "edi_loc", ""));
		setWoN2ndFaxNo(JSPUtil.getParameter(request, "wo_n2nd_fax_no", ""));
		setEdiTrspWoOfcCtyCd(JSPUtil.getParameter(request, "edi_trsp_wo_ofc_cty_cd", ""));
		setEdiRcvrNm(JSPUtil.getParameter(request, "edi_rcvr_nm", ""));
		setWoIssNo(JSPUtil.getParameter(request, "wo_iss_no", ""));
		setWoN3rdFaxNo(JSPUtil.getParameter(request, "wo_n3rd_fax_no", ""));
		setTrspWoOfcCtyCd(JSPUtil.getParameter(request, "trsp_wo_ofc_cty_cd", ""));
		setEdiVndrSeq(JSPUtil.getParameter(request, "edi_vndr_seq", ""));
		setWoFaxUseFlg(JSPUtil.getParameter(request, "wo_fax_use_flg", ""));
		setRtDpUseFlg(JSPUtil.getParameter(request, "rt_dp_use_flg", ""));
		setFaxParam(JSPUtil.getParameter(request, "fax_param", ""));
		setWoCntcPsonNm(JSPUtil.getParameter(request, "wo_cntc_pson_nm", ""));
		setPreDisUseFlg(JSPUtil.getParameter(request, "pre_dis_use_flg", ""));
		setWoPrvGrpSeq(JSPUtil.getParameter(request, "wo_prv_grp_seq", ""));
		setWoEmlUseFlg(JSPUtil.getParameter(request, "wo_eml_use_flg", ""));
		setSoCreOfcCd(JSPUtil.getParameter(request, "so_cre_ofc_cd", ""));
		setEdiFltCd(JSPUtil.getParameter(request, "edi_flt_cd", ""));
		setTrspBndCd(JSPUtil.getParameter(request, "trsp_bnd_cd", ""));
		setWtrRcvTermCd(JSPUtil.getParameter(request, "wtr_rcv_term_cd", ""));
		setWtrDeTermCd(JSPUtil.getParameter(request, "wtr_de_term_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return WorkOrderPreviewVO[]
	 */
	public WorkOrderPreviewVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return WorkOrderPreviewVO[]
	 */
	public WorkOrderPreviewVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		WorkOrderPreviewVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cmdtDpUseFlg = (JSPUtil.getParameter(request, prefix	+ "cmdt_dp_use_flg", length));
			String[] woCxlFlg = (JSPUtil.getParameter(request, prefix	+ "wo_cxl_flg", length));
			String[] emailContents = (JSPUtil.getParameter(request, prefix	+ "email_contents", length));
			String[] interUseFlg = (JSPUtil.getParameter(request, prefix	+ "inter_use_flg", length));
			String[] ediWoIssStsCd = (JSPUtil.getParameter(request, prefix	+ "edi_wo_iss_sts_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] emlNo03 = (JSPUtil.getParameter(request, prefix	+ "eml_no_03", length));
			String[] woN1stFaxNo = (JSPUtil.getParameter(request, prefix	+ "wo_n1st_fax_no", length));
			String[] trspCostDtlModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_cost_dtl_mod_cd", length));
			String[] woN3rdEml = (JSPUtil.getParameter(request, prefix	+ "wo_n3rd_eml", length));
			String[] woFmtTpCd = (JSPUtil.getParameter(request, prefix	+ "wo_fmt_tp_cd", length));
			String[] emlNo01 = (JSPUtil.getParameter(request, prefix	+ "eml_no_01", length));
			String[] woN1stEml = (JSPUtil.getParameter(request, prefix	+ "wo_n1st_eml", length));
			String[] emlNo02 = (JSPUtil.getParameter(request, prefix	+ "eml_no_02", length));
			String[] woRmk = (JSPUtil.getParameter(request, prefix	+ "wo_rmk", length));
			String[] ediTrspWoSeq = (JSPUtil.getParameter(request, prefix	+ "edi_trsp_wo_seq", length));
			String[] ediWoIssKnt = (JSPUtil.getParameter(request, prefix	+ "edi_wo_iss_knt", length));
			String[] faxNo02 = (JSPUtil.getParameter(request, prefix	+ "fax_no_02", length));
			String[] faxNo03 = (JSPUtil.getParameter(request, prefix	+ "fax_no_03", length));
			String[] trspWoSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_wo_seq", length));
			String[] woN2ndEml = (JSPUtil.getParameter(request, prefix	+ "wo_n2nd_eml", length));
			String[] faxBatchInd = (JSPUtil.getParameter(request, prefix	+ "fax_batch_ind", length));
			String[] contiCd = (JSPUtil.getParameter(request, prefix	+ "conti_cd", length));
			String[] rdCgo = (JSPUtil.getParameter(request, prefix	+ "rd_cgo", length));
			String[] emailTitle = (JSPUtil.getParameter(request, prefix	+ "email_title", length));
			String[] woVndrSeq = (JSPUtil.getParameter(request, prefix	+ "wo_vndr_seq", length));
			String[] woIssStsCd = (JSPUtil.getParameter(request, prefix	+ "wo_iss_sts_cd", length));
			String[] ediTrspSoSeq = (JSPUtil.getParameter(request, prefix	+ "edi_trsp_so_seq", length));
			String[] fltFileNo = (JSPUtil.getParameter(request, prefix	+ "flt_file_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] woEdiUseFlg = (JSPUtil.getParameter(request, prefix	+ "wo_edi_use_flg", length));
			String[] scgGrpSeq = (JSPUtil.getParameter(request, prefix	+ "scg_grp_seq", length));
			String[] faxNo01 = (JSPUtil.getParameter(request, prefix	+ "fax_no_01", length));
			String[] ediEqNo = (JSPUtil.getParameter(request, prefix	+ "edi_eq_no", length));
			String[] woDtlUseFlg = (JSPUtil.getParameter(request, prefix	+ "wo_dtl_use_flg", length));
			String[] trspCrrModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_crr_mod_cd", length));
			String[] faxAppCd = (JSPUtil.getParameter(request, prefix	+ "fax_app_cd", length));
			String[] ediTrspSoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "edi_trsp_so_ofc_cty_cd", length));
			String[] faxRcvInfo = (JSPUtil.getParameter(request, prefix	+ "fax_rcv_info", length));
			String[] faxTitle = (JSPUtil.getParameter(request, prefix	+ "fax_title", length));
			String[] faxSysCd = (JSPUtil.getParameter(request, prefix	+ "fax_sys_cd", length));
			String[] woPrnUseFlg = (JSPUtil.getParameter(request, prefix	+ "wo_prn_use_flg", length));
			String[] ediLoc = (JSPUtil.getParameter(request, prefix	+ "edi_loc", length));
			String[] woN2ndFaxNo = (JSPUtil.getParameter(request, prefix	+ "wo_n2nd_fax_no", length));
			String[] ediTrspWoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "edi_trsp_wo_ofc_cty_cd", length));
			String[] ediRcvrNm = (JSPUtil.getParameter(request, prefix	+ "edi_rcvr_nm", length));
			String[] woIssNo = (JSPUtil.getParameter(request, prefix	+ "wo_iss_no", length));
			String[] woN3rdFaxNo = (JSPUtil.getParameter(request, prefix	+ "wo_n3rd_fax_no", length));
			String[] trspWoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_wo_ofc_cty_cd", length));
			String[] ediVndrSeq = (JSPUtil.getParameter(request, prefix	+ "edi_vndr_seq", length));
			String[] woFaxUseFlg = (JSPUtil.getParameter(request, prefix	+ "wo_fax_use_flg", length));
			String[] rtDpUseFlg = (JSPUtil.getParameter(request, prefix	+ "rt_dp_use_flg", length));
			String[] faxParam = (JSPUtil.getParameter(request, prefix	+ "fax_param", length));
			String[] woCntcPsonNm = (JSPUtil.getParameter(request, prefix	+ "wo_cntc_pson_nm", length));
			String[] preDisUseFlg = (JSPUtil.getParameter(request, prefix	+ "pre_dis_use_flg", length));
			String[] woPrvGrpSeq = (JSPUtil.getParameter(request, prefix	+ "wo_prv_grp_seq", length));
			String[] woEmlUseFlg = (JSPUtil.getParameter(request, prefix	+ "wo_eml_use_flg", length));
			String[] soCreOfcCd = (JSPUtil.getParameter(request, prefix	+ "so_cre_ofc_cd", length));
			String[] ediFltCd = (JSPUtil.getParameter(request, prefix	+ "edi_flt_cd", length));
			String[] trspBndCd = (JSPUtil.getParameter(request, prefix	+ "trsp_bnd_cd", length));
			String[] wtrRcvTermCd = (JSPUtil.getParameter(request, prefix	+ "wtr_rcv_term_cd", length));
			String[] wtrDeTermCd = (JSPUtil.getParameter(request, prefix	+ "wtr_de_term_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new WorkOrderPreviewVO();
				if (cmdtDpUseFlg[i] != null)
					model.setCmdtDpUseFlg(cmdtDpUseFlg[i]);
				if (woCxlFlg[i] != null)
					model.setWoCxlFlg(woCxlFlg[i]);
				if (emailContents[i] != null)
					model.setEmailContents(emailContents[i]);
				if (interUseFlg[i] != null)
					model.setInterUseFlg(interUseFlg[i]);
				if (ediWoIssStsCd[i] != null)
					model.setEdiWoIssStsCd(ediWoIssStsCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (emlNo03[i] != null)
					model.setEmlNo03(emlNo03[i]);
				if (woN1stFaxNo[i] != null)
					model.setWoN1stFaxNo(woN1stFaxNo[i]);
				if (trspCostDtlModCd[i] != null)
					model.setTrspCostDtlModCd(trspCostDtlModCd[i]);
				if (woN3rdEml[i] != null)
					model.setWoN3rdEml(woN3rdEml[i]);
				if (woFmtTpCd[i] != null)
					model.setWoFmtTpCd(woFmtTpCd[i]);
				if (emlNo01[i] != null)
					model.setEmlNo01(emlNo01[i]);
				if (woN1stEml[i] != null)
					model.setWoN1stEml(woN1stEml[i]);
				if (emlNo02[i] != null)
					model.setEmlNo02(emlNo02[i]);
				if (woRmk[i] != null)
					model.setWoRmk(woRmk[i]);
				if (ediTrspWoSeq[i] != null)
					model.setEdiTrspWoSeq(ediTrspWoSeq[i]);
				if (ediWoIssKnt[i] != null)
					model.setEdiWoIssKnt(ediWoIssKnt[i]);
				if (faxNo02[i] != null)
					model.setFaxNo02(faxNo02[i]);
				if (faxNo03[i] != null)
					model.setFaxNo03(faxNo03[i]);
				if (trspWoSeq[i] != null)
					model.setTrspWoSeq(trspWoSeq[i]);
				if (woN2ndEml[i] != null)
					model.setWoN2ndEml(woN2ndEml[i]);
				if (faxBatchInd[i] != null)
					model.setFaxBatchInd(faxBatchInd[i]);
				if (contiCd[i] != null)
					model.setContiCd(contiCd[i]);
				if (rdCgo[i] != null)
					model.setRdCgo(rdCgo[i]);
				if (emailTitle[i] != null)
					model.setEmailTitle(emailTitle[i]);
				if (woVndrSeq[i] != null)
					model.setWoVndrSeq(woVndrSeq[i]);
				if (woIssStsCd[i] != null)
					model.setWoIssStsCd(woIssStsCd[i]);
				if (ediTrspSoSeq[i] != null)
					model.setEdiTrspSoSeq(ediTrspSoSeq[i]);
				if (fltFileNo[i] != null)
					model.setFltFileNo(fltFileNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (woEdiUseFlg[i] != null)
					model.setWoEdiUseFlg(woEdiUseFlg[i]);
				if (scgGrpSeq[i] != null)
					model.setScgGrpSeq(scgGrpSeq[i]);
				if (faxNo01[i] != null)
					model.setFaxNo01(faxNo01[i]);
				if (ediEqNo[i] != null)
					model.setEdiEqNo(ediEqNo[i]);
				if (woDtlUseFlg[i] != null)
					model.setWoDtlUseFlg(woDtlUseFlg[i]);
				if (trspCrrModCd[i] != null)
					model.setTrspCrrModCd(trspCrrModCd[i]);
				if (faxAppCd[i] != null)
					model.setFaxAppCd(faxAppCd[i]);
				if (ediTrspSoOfcCtyCd[i] != null)
					model.setEdiTrspSoOfcCtyCd(ediTrspSoOfcCtyCd[i]);
				if (faxRcvInfo[i] != null)
					model.setFaxRcvInfo(faxRcvInfo[i]);
				if (faxTitle[i] != null)
					model.setFaxTitle(faxTitle[i]);
				if (faxSysCd[i] != null)
					model.setFaxSysCd(faxSysCd[i]);
				if (woPrnUseFlg[i] != null)
					model.setWoPrnUseFlg(woPrnUseFlg[i]);
				if (ediLoc[i] != null)
					model.setEdiLoc(ediLoc[i]);
				if (woN2ndFaxNo[i] != null)
					model.setWoN2ndFaxNo(woN2ndFaxNo[i]);
				if (ediTrspWoOfcCtyCd[i] != null)
					model.setEdiTrspWoOfcCtyCd(ediTrspWoOfcCtyCd[i]);
				if (ediRcvrNm[i] != null)
					model.setEdiRcvrNm(ediRcvrNm[i]);
				if (woIssNo[i] != null)
					model.setWoIssNo(woIssNo[i]);
				if (woN3rdFaxNo[i] != null)
					model.setWoN3rdFaxNo(woN3rdFaxNo[i]);
				if (trspWoOfcCtyCd[i] != null)
					model.setTrspWoOfcCtyCd(trspWoOfcCtyCd[i]);
				if (ediVndrSeq[i] != null)
					model.setEdiVndrSeq(ediVndrSeq[i]);
				if (woFaxUseFlg[i] != null)
					model.setWoFaxUseFlg(woFaxUseFlg[i]);
				if (rtDpUseFlg[i] != null)
					model.setRtDpUseFlg(rtDpUseFlg[i]);
				if (faxParam[i] != null)
					model.setFaxParam(faxParam[i]);
				if (woCntcPsonNm[i] != null)
					model.setWoCntcPsonNm(woCntcPsonNm[i]);
				if (preDisUseFlg[i] != null)
					model.setPreDisUseFlg(preDisUseFlg[i]);
				if (woPrvGrpSeq[i] != null)
					model.setWoPrvGrpSeq(woPrvGrpSeq[i]);
				if (woEmlUseFlg[i] != null)
					model.setWoEmlUseFlg(woEmlUseFlg[i]);
				if (soCreOfcCd[i] != null)
					model.setSoCreOfcCd(soCreOfcCd[i]);
				if (ediFltCd[i] != null)
					model.setEdiFltCd(ediFltCd[i]);
				if (trspBndCd[i] != null)
					model.setTrspBndCd(trspBndCd[i]);
				if (wtrRcvTermCd[i] != null)
					model.setWtrRcvTermCd(wtrRcvTermCd[i]);
				if (wtrDeTermCd[i] != null)
					model.setWtrDeTermCd(wtrDeTermCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getWorkOrderPreviewVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return WorkOrderPreviewVO[]
	 */
	public WorkOrderPreviewVO[] getWorkOrderPreviewVOs(){
		WorkOrderPreviewVO[] vos = (WorkOrderPreviewVO[])models.toArray(new WorkOrderPreviewVO[models.size()]);
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
		this.cmdtDpUseFlg = this.cmdtDpUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woCxlFlg = this.woCxlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emailContents = this.emailContents .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interUseFlg = this.interUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediWoIssStsCd = this.ediWoIssStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlNo03 = this.emlNo03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woN1stFaxNo = this.woN1stFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCostDtlModCd = this.trspCostDtlModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woN3rdEml = this.woN3rdEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woFmtTpCd = this.woFmtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlNo01 = this.emlNo01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woN1stEml = this.woN1stEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlNo02 = this.emlNo02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woRmk = this.woRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediTrspWoSeq = this.ediTrspWoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediWoIssKnt = this.ediWoIssKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo02 = this.faxNo02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo03 = this.faxNo03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspWoSeq = this.trspWoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woN2ndEml = this.woN2ndEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxBatchInd = this.faxBatchInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contiCd = this.contiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdCgo = this.rdCgo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emailTitle = this.emailTitle .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woVndrSeq = this.woVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woIssStsCd = this.woIssStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediTrspSoSeq = this.ediTrspSoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fltFileNo = this.fltFileNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woEdiUseFlg = this.woEdiUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgGrpSeq = this.scgGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo01 = this.faxNo01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediEqNo = this.ediEqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woDtlUseFlg = this.woDtlUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCrrModCd = this.trspCrrModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxAppCd = this.faxAppCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediTrspSoOfcCtyCd = this.ediTrspSoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxRcvInfo = this.faxRcvInfo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxTitle = this.faxTitle .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSysCd = this.faxSysCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woPrnUseFlg = this.woPrnUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediLoc = this.ediLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woN2ndFaxNo = this.woN2ndFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediTrspWoOfcCtyCd = this.ediTrspWoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRcvrNm = this.ediRcvrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woIssNo = this.woIssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woN3rdFaxNo = this.woN3rdFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspWoOfcCtyCd = this.trspWoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediVndrSeq = this.ediVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woFaxUseFlg = this.woFaxUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtDpUseFlg = this.rtDpUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxParam = this.faxParam .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woCntcPsonNm = this.woCntcPsonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preDisUseFlg = this.preDisUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woPrvGrpSeq = this.woPrvGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woEmlUseFlg = this.woEmlUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soCreOfcCd = this.soCreOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediFltCd = this.ediFltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspBndCd = this.trspBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wtrRcvTermCd = this.wtrRcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wtrDeTermCd = this.wtrDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
