/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PkupNtcSendListVO.java
*@FileTitle : PkupNtcSendListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.26
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo;

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

public class PkupNtcSendListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PkupNtcSendListVO> models = new ArrayList<PkupNtcSendListVO>();
	
	/* Column Info */
	private String anEmlNtcSndRslt = null;
	/* Column Info */
	private String sndStsDesc = null;
	/* Column Info */
	private String c1EmlSndUsrId = null;
	/* Column Info */
	private String b2FaxNoChk = null;
	/* Column Info */
	private String b1EmlNtcSndId = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pkupAvalDt = null;
	/* Column Info */
	private String edi322MvmtCd = null;
	/* Column Info */
	private String mnlFlgShow = null;
	/* Column Info */
	private String anEmlSndDt = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String c2FaxNtcSndId = null;
	/* Column Info */
	private String pkupNtcFomCd = null;
	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String b1FaxNo = null;
	/* Column Info */
	private String anFaxSndDt = null;
	/* Column Info */
	private String c1NtcEml = null;
	/* Column Info */
	private String autoSndStopUsrId = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String sndUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String pkupNtcSndStsCd = null;
	/* Column Info */
	private String b1FaxNtcSndRslt = null;
	/* Column Info */
	private String b1FaxSndDt = null;
	/* Column Info */
	private String pkupYdCdFlg = null;
	/* Column Info */
	private String pkupNo = null;
	/* Column Info */
	private String c1FaxNtcSndRslt = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String b2EmlNtcSndRslt = null;
	/* Column Info */
	private String c2FaxNtcSndRslt = null;
	/* Column Info */
	private String b1EmlNtcSndRslt = null;
	/* Column Info */
	private String railLodDt = null;
	/* Column Info */
	private String autoSndStopDt = null;
	/* Column Info */
	private String c2EmlNtcSndId = null;
	/* Column Info */
	private String lstFreeDt = null;
	/* Column Info */
	private String b1FaxSndUsrId = null;
	/* Column Info */
	private String anEmlNtcSndId = null;
	/* Column Info */
	private String ibdTrspHubCd = null;
	/* Column Info */
	private String ntcSeq = null;
	/* Column Info */
	private String autoSndResmDt = null;
	/* Column Info */
	private String b2FaxNo = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String faxSndDt = null;
	/* Column Info */
	private String cstmsClrFlg = null;
	/* Column Info */
	private String c1EmlNtcSndId = null;
	/* Column Info */
	private String anFaxSndUsrId = null;
	/* Column Info */
	private String pkupNoUpldUsrId = null;
	/* Column Info */
	private String emlSndDt = null;
	/* Column Info */
	private String b2EmlSndDt = null;
	/* Column Info */
	private String oblCltFlg = null;
	/* Column Info */
	private String trspSoSeq = null;
	/* Column Info */
	private String b1FaxNtcSndId = null;
	/* Column Info */
	private String c2EmlSndDt = null;
	/* Column Info */
	private String sndDt = null;
	/* Column Info */
	private String b2FaxNtcSndId = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String anNtcEml = null;
	/* Column Info */
	private String pkupYdCd = null;
	/* Column Info */
	private String frtCltFlg = null;
	/* Column Info */
	private String c2NtcEmlChk = null;
	/* Column Info */
	private String b1NtcEmlChk = null;
	/* Column Info */
	private String c2FaxSndUsrId = null;
	/* Column Info */
	private String routGidDesc = null;
	/* Column Info */
	private String bkgCustTpCd = null;
	/* Column Info */
	private String c1EmlNtcSndRslt = null;
	/* Column Info */
	private String pkupNoUpldVia = null;
	/* Column Info */
	private String c1FaxSndUsrId = null;
	/* Column Info */
	private String pkupNtcFomCdShow = null;
	/* Column Info */
	private String c2NtcEml = null;
	/* Column Info */
	private String b1EmlSndUsrId = null;
	/* Column Info */
	private String dorTrkrWoFlg = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String sndProcStsCd = null;
	/* Column Info */
	private String c2FaxSndDt = null;
	/* Column Info */
	private String c2FaxNoChk = null;
	/* Column Info */
	private String b2FaxSndUsrId = null;
	/* Column Info */
	private String anNtcEmlChk = null;
	/* Column Info */
	private String c1FaxNo = null;
	/* Column Info */
	private String pkupNoUpldRailCo = null;
	/* Column Info */
	private String anFaxNoChk = null;
	/* Column Info */
	private String b1NtcEml = null;
	/* Column Info */
	private String b2NtcEml = null;
	/* Column Info */
	private String eqCtrlOfcCd = null;
	/* Column Info */
	private String anEmlSndUsrId = null;
	/* Column Info */
	private String c1FaxNoChk = null;
	/* Column Info */
	private String pkupNtcTpCd = null;
	/* Column Info */
	private String c1FaxNtcSndId = null;
	/* Column Info */
	private String trspSoOfcCtyCd = null;
	/* Column Info */
	private String c1EmlSndDt = null;
	/* Column Info */
	private String pkupNoUpldDt = null;
	/* Column Info */
	private String c2FaxNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String nvoccFileNo = null;
	/* Column Info */
	private String b2EmlSndUsrId = null;
	/* Column Info */
	private String anFaxNtcSndId = null;
	/* Column Info */
	private String b2FaxNtcSndRslt = null;
	/* Column Info */
	private String vvdId = null;
	/* Column Info */
	private String b1EmlSndDt = null;
	/* Column Info */
	private String cstmsClrCd = null;
	/* Column Info */
	private String b2FaxSndDt = null;
	/* Column Info */
	private String b1FaxNoChk = null;
	/* Column Info */
	private String b2NtcEmlChk = null;
	/* Column Info */
	private String sndYn = null;
	/* Column Info */
	private String rtnYdCd = null;
	/* Column Info */
	private String b2EmlNtcSndId = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String autoSndResmUsrId = null;
	/* Column Info */
	private String c1FaxSndDt = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String overWgtFlg = null;
	/* Column Info */
	private String c2EmlSndUsrId = null;
	/* Column Info */
	private String eclzOblCpyFlg = null;
	/* Column Info */
	private String anFaxNo = null;
	/* Column Info */
	private String c1NtcEmlChk = null;
	/* Column Info */
	private String anFaxNtcSndRslt = null;
	/* Column Info */
	private String mnlFlg = null;
	/* Column Info */
	private String c2EmlNtcSndRslt = null;
	/* Column Info */
	private String showPuFlg = null;
	/* Column Info */
	private String copPkupYdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PkupNtcSendListVO() {}

	public PkupNtcSendListVO(String ibflag, String pagerows, String bkgNo, String ntcSeq, String pkupNtcSndStsCd, String mnlFlg, String mnlFlgShow, String pkupNtcTpCd, String pkupNtcFomCd, String pkupNtcFomCdShow, String blNo, String cntrNo, String cntrWgt, String overWgtFlg, String railLodDt, String pkupAvalDt, String lstFreeDt, String pkupNo, String pkupYdCd, String rtnYdCd, String frtCltFlg, String oblCltFlg, String cstmsClrFlg, String cstmsClrCd, String edi322MvmtCd, String pkupNoUpldDt, String pkupNoUpldUsrId, String pkupNoUpldVia, String pkupNoUpldRailCo, String podCd, String ibdTrspHubCd, String delCd, String eqCtrlOfcCd, String pkupYdCdFlg, String nvoccFileNo, String deTermCd, String dorTrkrWoFlg, String routGidDesc, String vvdId, String sndStsDesc, String faxSndDt, String emlSndDt, String sndDt, String sndYn, String sndUsrId, String sndProcStsCd, String autoSndStopDt, String autoSndStopUsrId, String autoSndResmDt, String autoSndResmUsrId, String bkgCustTpCd, String custCntCd, String custSeq, String custCd, String custNm, String c1FaxNoChk, String c1FaxNo, String c1FaxSndDt, String c1FaxSndUsrId, String c1FaxNtcSndId, String c1FaxNtcSndRslt, String c2FaxNoChk, String c2FaxNo, String c2FaxSndDt, String c2FaxSndUsrId, String c2FaxNtcSndId, String c2FaxNtcSndRslt, String b1FaxNoChk, String b1FaxNo, String b1FaxSndDt, String b1FaxSndUsrId, String b1FaxNtcSndId, String b1FaxNtcSndRslt, String b2FaxNoChk, String b2FaxNo, String b2FaxSndDt, String b2FaxSndUsrId, String b2FaxNtcSndId, String b2FaxNtcSndRslt, String anFaxNoChk, String anFaxNo, String anFaxSndDt, String anFaxSndUsrId, String anFaxNtcSndId, String anFaxNtcSndRslt, String c1NtcEmlChk, String c1NtcEml, String c1EmlSndDt, String c1EmlSndUsrId, String c1EmlNtcSndId, String c1EmlNtcSndRslt, String c2NtcEmlChk, String c2NtcEml, String c2EmlSndDt, String c2EmlSndUsrId, String c2EmlNtcSndId, String c2EmlNtcSndRslt, String b1NtcEmlChk, String b1NtcEml, String b1EmlSndDt, String b1EmlSndUsrId, String b1EmlNtcSndId, String b1EmlNtcSndRslt, String b2NtcEmlChk, String b2NtcEml, String b2EmlSndDt, String b2EmlSndUsrId, String b2EmlNtcSndId, String b2EmlNtcSndRslt, String anNtcEmlChk, String anNtcEml, String anEmlSndDt, String anEmlSndUsrId, String anEmlNtcSndId, String anEmlNtcSndRslt, String diffRmk, String trspSoOfcCtyCd, String trspSoSeq, String eclzOblCpyFlg, String showPuFlg, String copPkupYdCd) {
		this.anEmlNtcSndRslt = anEmlNtcSndRslt;
		this.sndStsDesc = sndStsDesc;
		this.c1EmlSndUsrId = c1EmlSndUsrId;
		this.b2FaxNoChk = b2FaxNoChk;
		this.b1EmlNtcSndId = b1EmlNtcSndId;
		this.pagerows = pagerows;
		this.pkupAvalDt = pkupAvalDt;
		this.edi322MvmtCd = edi322MvmtCd;
		this.mnlFlgShow = mnlFlgShow;
		this.anEmlSndDt = anEmlSndDt;
		this.custCntCd = custCntCd;
		this.c2FaxNtcSndId = c2FaxNtcSndId;
		this.pkupNtcFomCd = pkupNtcFomCd;
		this.cntrWgt = cntrWgt;
		this.b1FaxNo = b1FaxNo;
		this.anFaxSndDt = anFaxSndDt;
		this.c1NtcEml = c1NtcEml;
		this.autoSndStopUsrId = autoSndStopUsrId;
		this.podCd = podCd;
		this.sndUsrId = sndUsrId;
		this.bkgNo = bkgNo;
		this.custCd = custCd;
		this.pkupNtcSndStsCd = pkupNtcSndStsCd;
		this.b1FaxNtcSndRslt = b1FaxNtcSndRslt;
		this.b1FaxSndDt = b1FaxSndDt;
		this.pkupYdCdFlg = pkupYdCdFlg;
		this.pkupNo = pkupNo;
		this.c1FaxNtcSndRslt = c1FaxNtcSndRslt;
		this.custNm = custNm;
		this.b2EmlNtcSndRslt = b2EmlNtcSndRslt;
		this.c2FaxNtcSndRslt = c2FaxNtcSndRslt;
		this.b1EmlNtcSndRslt = b1EmlNtcSndRslt;
		this.railLodDt = railLodDt;
		this.autoSndStopDt = autoSndStopDt;
		this.c2EmlNtcSndId = c2EmlNtcSndId;
		this.lstFreeDt = lstFreeDt;
		this.b1FaxSndUsrId = b1FaxSndUsrId;
		this.anEmlNtcSndId = anEmlNtcSndId;
		this.ibdTrspHubCd = ibdTrspHubCd;
		this.ntcSeq = ntcSeq;
		this.autoSndResmDt = autoSndResmDt;
		this.b2FaxNo = b2FaxNo;
		this.diffRmk = diffRmk;
		this.cntrNo = cntrNo;
		this.faxSndDt = faxSndDt;
		this.cstmsClrFlg = cstmsClrFlg;
		this.c1EmlNtcSndId = c1EmlNtcSndId;
		this.anFaxSndUsrId = anFaxSndUsrId;
		this.pkupNoUpldUsrId = pkupNoUpldUsrId;
		this.emlSndDt = emlSndDt;
		this.b2EmlSndDt = b2EmlSndDt;
		this.oblCltFlg = oblCltFlg;
		this.trspSoSeq = trspSoSeq;
		this.b1FaxNtcSndId = b1FaxNtcSndId;
		this.c2EmlSndDt = c2EmlSndDt;
		this.sndDt = sndDt;
		this.b2FaxNtcSndId = b2FaxNtcSndId;
		this.blNo = blNo;
		this.anNtcEml = anNtcEml;
		this.pkupYdCd = pkupYdCd;
		this.frtCltFlg = frtCltFlg;
		this.c2NtcEmlChk = c2NtcEmlChk;
		this.b1NtcEmlChk = b1NtcEmlChk;
		this.c2FaxSndUsrId = c2FaxSndUsrId;
		this.routGidDesc = routGidDesc;
		this.bkgCustTpCd = bkgCustTpCd;
		this.c1EmlNtcSndRslt = c1EmlNtcSndRslt;
		this.pkupNoUpldVia = pkupNoUpldVia;
		this.c1FaxSndUsrId = c1FaxSndUsrId;
		this.pkupNtcFomCdShow = pkupNtcFomCdShow;
		this.c2NtcEml = c2NtcEml;
		this.b1EmlSndUsrId = b1EmlSndUsrId;
		this.dorTrkrWoFlg = dorTrkrWoFlg;
		this.delCd = delCd;
		this.sndProcStsCd = sndProcStsCd;
		this.c2FaxSndDt = c2FaxSndDt;
		this.c2FaxNoChk = c2FaxNoChk;
		this.b2FaxSndUsrId = b2FaxSndUsrId;
		this.anNtcEmlChk = anNtcEmlChk;
		this.c1FaxNo = c1FaxNo;
		this.pkupNoUpldRailCo = pkupNoUpldRailCo;
		this.anFaxNoChk = anFaxNoChk;
		this.b1NtcEml = b1NtcEml;
		this.b2NtcEml = b2NtcEml;
		this.eqCtrlOfcCd = eqCtrlOfcCd;
		this.anEmlSndUsrId = anEmlSndUsrId;
		this.c1FaxNoChk = c1FaxNoChk;
		this.pkupNtcTpCd = pkupNtcTpCd;
		this.c1FaxNtcSndId = c1FaxNtcSndId;
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
		this.c1EmlSndDt = c1EmlSndDt;
		this.pkupNoUpldDt = pkupNoUpldDt;
		this.c2FaxNo = c2FaxNo;
		this.ibflag = ibflag;
		this.nvoccFileNo = nvoccFileNo;
		this.b2EmlSndUsrId = b2EmlSndUsrId;
		this.anFaxNtcSndId = anFaxNtcSndId;
		this.b2FaxNtcSndRslt = b2FaxNtcSndRslt;
		this.vvdId = vvdId;
		this.b1EmlSndDt = b1EmlSndDt;
		this.cstmsClrCd = cstmsClrCd;
		this.b2FaxSndDt = b2FaxSndDt;
		this.b1FaxNoChk = b1FaxNoChk;
		this.b2NtcEmlChk = b2NtcEmlChk;
		this.sndYn = sndYn;
		this.rtnYdCd = rtnYdCd;
		this.b2EmlNtcSndId = b2EmlNtcSndId;
		this.custSeq = custSeq;
		this.autoSndResmUsrId = autoSndResmUsrId;
		this.c1FaxSndDt = c1FaxSndDt;
		this.deTermCd = deTermCd;
		this.overWgtFlg = overWgtFlg;
		this.c2EmlSndUsrId = c2EmlSndUsrId;
		this.eclzOblCpyFlg = eclzOblCpyFlg;
		this.anFaxNo = anFaxNo;
		this.c1NtcEmlChk = c1NtcEmlChk;
		this.anFaxNtcSndRslt = anFaxNtcSndRslt;
		this.mnlFlg = mnlFlg;
		this.c2EmlNtcSndRslt = c2EmlNtcSndRslt;
		this.showPuFlg = showPuFlg;
		this.copPkupYdCd = copPkupYdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("an_eml_ntc_snd_rslt", getAnEmlNtcSndRslt());
		this.hashColumns.put("snd_sts_desc", getSndStsDesc());
		this.hashColumns.put("c1_eml_snd_usr_id", getC1EmlSndUsrId());
		this.hashColumns.put("b2_fax_no_chk", getB2FaxNoChk());
		this.hashColumns.put("b1_eml_ntc_snd_id", getB1EmlNtcSndId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pkup_aval_dt", getPkupAvalDt());
		this.hashColumns.put("edi_322_mvmt_cd", getEdi322MvmtCd());
		this.hashColumns.put("mnl_flg_show", getMnlFlgShow());
		this.hashColumns.put("an_eml_snd_dt", getAnEmlSndDt());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("c2_fax_ntc_snd_id", getC2FaxNtcSndId());
		this.hashColumns.put("pkup_ntc_fom_cd", getPkupNtcFomCd());
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("b1_fax_no", getB1FaxNo());
		this.hashColumns.put("an_fax_snd_dt", getAnFaxSndDt());
		this.hashColumns.put("c1_ntc_eml", getC1NtcEml());
		this.hashColumns.put("auto_snd_stop_usr_id", getAutoSndStopUsrId());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("snd_usr_id", getSndUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("pkup_ntc_snd_sts_cd", getPkupNtcSndStsCd());
		this.hashColumns.put("b1_fax_ntc_snd_rslt", getB1FaxNtcSndRslt());
		this.hashColumns.put("b1_fax_snd_dt", getB1FaxSndDt());
		this.hashColumns.put("pkup_yd_cd_flg", getPkupYdCdFlg());
		this.hashColumns.put("pkup_no", getPkupNo());
		this.hashColumns.put("c1_fax_ntc_snd_rslt", getC1FaxNtcSndRslt());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("b2_eml_ntc_snd_rslt", getB2EmlNtcSndRslt());
		this.hashColumns.put("c2_fax_ntc_snd_rslt", getC2FaxNtcSndRslt());
		this.hashColumns.put("b1_eml_ntc_snd_rslt", getB1EmlNtcSndRslt());
		this.hashColumns.put("rail_lod_dt", getRailLodDt());
		this.hashColumns.put("auto_snd_stop_dt", getAutoSndStopDt());
		this.hashColumns.put("c2_eml_ntc_snd_id", getC2EmlNtcSndId());
		this.hashColumns.put("lst_free_dt", getLstFreeDt());
		this.hashColumns.put("b1_fax_snd_usr_id", getB1FaxSndUsrId());
		this.hashColumns.put("an_eml_ntc_snd_id", getAnEmlNtcSndId());
		this.hashColumns.put("ibd_trsp_hub_cd", getIbdTrspHubCd());
		this.hashColumns.put("ntc_seq", getNtcSeq());
		this.hashColumns.put("auto_snd_resm_dt", getAutoSndResmDt());
		this.hashColumns.put("b2_fax_no", getB2FaxNo());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("fax_snd_dt", getFaxSndDt());
		this.hashColumns.put("cstms_clr_flg", getCstmsClrFlg());
		this.hashColumns.put("c1_eml_ntc_snd_id", getC1EmlNtcSndId());
		this.hashColumns.put("an_fax_snd_usr_id", getAnFaxSndUsrId());
		this.hashColumns.put("pkup_no_upld_usr_id", getPkupNoUpldUsrId());
		this.hashColumns.put("eml_snd_dt", getEmlSndDt());
		this.hashColumns.put("b2_eml_snd_dt", getB2EmlSndDt());
		this.hashColumns.put("obl_clt_flg", getOblCltFlg());
		this.hashColumns.put("trsp_so_seq", getTrspSoSeq());
		this.hashColumns.put("b1_fax_ntc_snd_id", getB1FaxNtcSndId());
		this.hashColumns.put("c2_eml_snd_dt", getC2EmlSndDt());
		this.hashColumns.put("snd_dt", getSndDt());
		this.hashColumns.put("b2_fax_ntc_snd_id", getB2FaxNtcSndId());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("an_ntc_eml", getAnNtcEml());
		this.hashColumns.put("pkup_yd_cd", getPkupYdCd());
		this.hashColumns.put("frt_clt_flg", getFrtCltFlg());
		this.hashColumns.put("c2_ntc_eml_chk", getC2NtcEmlChk());
		this.hashColumns.put("b1_ntc_eml_chk", getB1NtcEmlChk());
		this.hashColumns.put("c2_fax_snd_usr_id", getC2FaxSndUsrId());
		this.hashColumns.put("rout_gid_desc", getRoutGidDesc());
		this.hashColumns.put("bkg_cust_tp_cd", getBkgCustTpCd());
		this.hashColumns.put("c1_eml_ntc_snd_rslt", getC1EmlNtcSndRslt());
		this.hashColumns.put("pkup_no_upld_via", getPkupNoUpldVia());
		this.hashColumns.put("c1_fax_snd_usr_id", getC1FaxSndUsrId());
		this.hashColumns.put("pkup_ntc_fom_cd_show", getPkupNtcFomCdShow());
		this.hashColumns.put("c2_ntc_eml", getC2NtcEml());
		this.hashColumns.put("b1_eml_snd_usr_id", getB1EmlSndUsrId());
		this.hashColumns.put("dor_trkr_wo_flg", getDorTrkrWoFlg());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("snd_proc_sts_cd", getSndProcStsCd());
		this.hashColumns.put("c2_fax_snd_dt", getC2FaxSndDt());
		this.hashColumns.put("c2_fax_no_chk", getC2FaxNoChk());
		this.hashColumns.put("b2_fax_snd_usr_id", getB2FaxSndUsrId());
		this.hashColumns.put("an_ntc_eml_chk", getAnNtcEmlChk());
		this.hashColumns.put("c1_fax_no", getC1FaxNo());
		this.hashColumns.put("pkup_no_upld_rail_co", getPkupNoUpldRailCo());
		this.hashColumns.put("an_fax_no_chk", getAnFaxNoChk());
		this.hashColumns.put("b1_ntc_eml", getB1NtcEml());
		this.hashColumns.put("b2_ntc_eml", getB2NtcEml());
		this.hashColumns.put("eq_ctrl_ofc_cd", getEqCtrlOfcCd());
		this.hashColumns.put("an_eml_snd_usr_id", getAnEmlSndUsrId());
		this.hashColumns.put("c1_fax_no_chk", getC1FaxNoChk());
		this.hashColumns.put("pkup_ntc_tp_cd", getPkupNtcTpCd());
		this.hashColumns.put("c1_fax_ntc_snd_id", getC1FaxNtcSndId());
		this.hashColumns.put("trsp_so_ofc_cty_cd", getTrspSoOfcCtyCd());
		this.hashColumns.put("c1_eml_snd_dt", getC1EmlSndDt());
		this.hashColumns.put("pkup_no_upld_dt", getPkupNoUpldDt());
		this.hashColumns.put("c2_fax_no", getC2FaxNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("nvocc_file_no", getNvoccFileNo());
		this.hashColumns.put("b2_eml_snd_usr_id", getB2EmlSndUsrId());
		this.hashColumns.put("an_fax_ntc_snd_id", getAnFaxNtcSndId());
		this.hashColumns.put("b2_fax_ntc_snd_rslt", getB2FaxNtcSndRslt());
		this.hashColumns.put("vvd_id", getVvdId());
		this.hashColumns.put("b1_eml_snd_dt", getB1EmlSndDt());
		this.hashColumns.put("cstms_clr_cd", getCstmsClrCd());
		this.hashColumns.put("b2_fax_snd_dt", getB2FaxSndDt());
		this.hashColumns.put("b1_fax_no_chk", getB1FaxNoChk());
		this.hashColumns.put("b2_ntc_eml_chk", getB2NtcEmlChk());
		this.hashColumns.put("snd_yn", getSndYn());
		this.hashColumns.put("rtn_yd_cd", getRtnYdCd());
		this.hashColumns.put("b2_eml_ntc_snd_id", getB2EmlNtcSndId());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("auto_snd_resm_usr_id", getAutoSndResmUsrId());
		this.hashColumns.put("c1_fax_snd_dt", getC1FaxSndDt());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("over_wgt_flg", getOverWgtFlg());
		this.hashColumns.put("c2_eml_snd_usr_id", getC2EmlSndUsrId());
		this.hashColumns.put("eclz_obl_cpy_flg", getEclzOblCpyFlg());
		this.hashColumns.put("an_fax_no", getAnFaxNo());
		this.hashColumns.put("c1_ntc_eml_chk", getC1NtcEmlChk());
		this.hashColumns.put("an_fax_ntc_snd_rslt", getAnFaxNtcSndRslt());
		this.hashColumns.put("mnl_flg", getMnlFlg());
		this.hashColumns.put("c2_eml_ntc_snd_rslt", getC2EmlNtcSndRslt());
		this.hashColumns.put("show_pu_flg", getShowPuFlg());
		this.hashColumns.put("cop_pkup_yd_cd", getCopPkupYdCd());
		
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("an_eml_ntc_snd_rslt", "anEmlNtcSndRslt");
		this.hashFields.put("snd_sts_desc", "sndStsDesc");
		this.hashFields.put("c1_eml_snd_usr_id", "c1EmlSndUsrId");
		this.hashFields.put("b2_fax_no_chk", "b2FaxNoChk");
		this.hashFields.put("b1_eml_ntc_snd_id", "b1EmlNtcSndId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pkup_aval_dt", "pkupAvalDt");
		this.hashFields.put("edi_322_mvmt_cd", "edi322MvmtCd");
		this.hashFields.put("mnl_flg_show", "mnlFlgShow");
		this.hashFields.put("an_eml_snd_dt", "anEmlSndDt");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("c2_fax_ntc_snd_id", "c2FaxNtcSndId");
		this.hashFields.put("pkup_ntc_fom_cd", "pkupNtcFomCd");
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("b1_fax_no", "b1FaxNo");
		this.hashFields.put("an_fax_snd_dt", "anFaxSndDt");
		this.hashFields.put("c1_ntc_eml", "c1NtcEml");
		this.hashFields.put("auto_snd_stop_usr_id", "autoSndStopUsrId");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("snd_usr_id", "sndUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("pkup_ntc_snd_sts_cd", "pkupNtcSndStsCd");
		this.hashFields.put("b1_fax_ntc_snd_rslt", "b1FaxNtcSndRslt");
		this.hashFields.put("b1_fax_snd_dt", "b1FaxSndDt");
		this.hashFields.put("pkup_yd_cd_flg", "pkupYdCdFlg");
		this.hashFields.put("pkup_no", "pkupNo");
		this.hashFields.put("c1_fax_ntc_snd_rslt", "c1FaxNtcSndRslt");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("b2_eml_ntc_snd_rslt", "b2EmlNtcSndRslt");
		this.hashFields.put("c2_fax_ntc_snd_rslt", "c2FaxNtcSndRslt");
		this.hashFields.put("b1_eml_ntc_snd_rslt", "b1EmlNtcSndRslt");
		this.hashFields.put("rail_lod_dt", "railLodDt");
		this.hashFields.put("auto_snd_stop_dt", "autoSndStopDt");
		this.hashFields.put("c2_eml_ntc_snd_id", "c2EmlNtcSndId");
		this.hashFields.put("lst_free_dt", "lstFreeDt");
		this.hashFields.put("b1_fax_snd_usr_id", "b1FaxSndUsrId");
		this.hashFields.put("an_eml_ntc_snd_id", "anEmlNtcSndId");
		this.hashFields.put("ibd_trsp_hub_cd", "ibdTrspHubCd");
		this.hashFields.put("ntc_seq", "ntcSeq");
		this.hashFields.put("auto_snd_resm_dt", "autoSndResmDt");
		this.hashFields.put("b2_fax_no", "b2FaxNo");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("fax_snd_dt", "faxSndDt");
		this.hashFields.put("cstms_clr_flg", "cstmsClrFlg");
		this.hashFields.put("c1_eml_ntc_snd_id", "c1EmlNtcSndId");
		this.hashFields.put("an_fax_snd_usr_id", "anFaxSndUsrId");
		this.hashFields.put("pkup_no_upld_usr_id", "pkupNoUpldUsrId");
		this.hashFields.put("eml_snd_dt", "emlSndDt");
		this.hashFields.put("b2_eml_snd_dt", "b2EmlSndDt");
		this.hashFields.put("obl_clt_flg", "oblCltFlg");
		this.hashFields.put("trsp_so_seq", "trspSoSeq");
		this.hashFields.put("b1_fax_ntc_snd_id", "b1FaxNtcSndId");
		this.hashFields.put("c2_eml_snd_dt", "c2EmlSndDt");
		this.hashFields.put("snd_dt", "sndDt");
		this.hashFields.put("b2_fax_ntc_snd_id", "b2FaxNtcSndId");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("an_ntc_eml", "anNtcEml");
		this.hashFields.put("pkup_yd_cd", "pkupYdCd");
		this.hashFields.put("frt_clt_flg", "frtCltFlg");
		this.hashFields.put("c2_ntc_eml_chk", "c2NtcEmlChk");
		this.hashFields.put("b1_ntc_eml_chk", "b1NtcEmlChk");
		this.hashFields.put("c2_fax_snd_usr_id", "c2FaxSndUsrId");
		this.hashFields.put("rout_gid_desc", "routGidDesc");
		this.hashFields.put("bkg_cust_tp_cd", "bkgCustTpCd");
		this.hashFields.put("c1_eml_ntc_snd_rslt", "c1EmlNtcSndRslt");
		this.hashFields.put("pkup_no_upld_via", "pkupNoUpldVia");
		this.hashFields.put("c1_fax_snd_usr_id", "c1FaxSndUsrId");
		this.hashFields.put("pkup_ntc_fom_cd_show", "pkupNtcFomCdShow");
		this.hashFields.put("c2_ntc_eml", "c2NtcEml");
		this.hashFields.put("b1_eml_snd_usr_id", "b1EmlSndUsrId");
		this.hashFields.put("dor_trkr_wo_flg", "dorTrkrWoFlg");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("snd_proc_sts_cd", "sndProcStsCd");
		this.hashFields.put("c2_fax_snd_dt", "c2FaxSndDt");
		this.hashFields.put("c2_fax_no_chk", "c2FaxNoChk");
		this.hashFields.put("b2_fax_snd_usr_id", "b2FaxSndUsrId");
		this.hashFields.put("an_ntc_eml_chk", "anNtcEmlChk");
		this.hashFields.put("c1_fax_no", "c1FaxNo");
		this.hashFields.put("pkup_no_upld_rail_co", "pkupNoUpldRailCo");
		this.hashFields.put("an_fax_no_chk", "anFaxNoChk");
		this.hashFields.put("b1_ntc_eml", "b1NtcEml");
		this.hashFields.put("b2_ntc_eml", "b2NtcEml");
		this.hashFields.put("eq_ctrl_ofc_cd", "eqCtrlOfcCd");
		this.hashFields.put("an_eml_snd_usr_id", "anEmlSndUsrId");
		this.hashFields.put("c1_fax_no_chk", "c1FaxNoChk");
		this.hashFields.put("pkup_ntc_tp_cd", "pkupNtcTpCd");
		this.hashFields.put("c1_fax_ntc_snd_id", "c1FaxNtcSndId");
		this.hashFields.put("trsp_so_ofc_cty_cd", "trspSoOfcCtyCd");
		this.hashFields.put("c1_eml_snd_dt", "c1EmlSndDt");
		this.hashFields.put("pkup_no_upld_dt", "pkupNoUpldDt");
		this.hashFields.put("c2_fax_no", "c2FaxNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("nvocc_file_no", "nvoccFileNo");
		this.hashFields.put("b2_eml_snd_usr_id", "b2EmlSndUsrId");
		this.hashFields.put("an_fax_ntc_snd_id", "anFaxNtcSndId");
		this.hashFields.put("b2_fax_ntc_snd_rslt", "b2FaxNtcSndRslt");
		this.hashFields.put("vvd_id", "vvdId");
		this.hashFields.put("b1_eml_snd_dt", "b1EmlSndDt");
		this.hashFields.put("cstms_clr_cd", "cstmsClrCd");
		this.hashFields.put("b2_fax_snd_dt", "b2FaxSndDt");
		this.hashFields.put("b1_fax_no_chk", "b1FaxNoChk");
		this.hashFields.put("b2_ntc_eml_chk", "b2NtcEmlChk");
		this.hashFields.put("snd_yn", "sndYn");
		this.hashFields.put("rtn_yd_cd", "rtnYdCd");
		this.hashFields.put("b2_eml_ntc_snd_id", "b2EmlNtcSndId");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("auto_snd_resm_usr_id", "autoSndResmUsrId");
		this.hashFields.put("c1_fax_snd_dt", "c1FaxSndDt");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("over_wgt_flg", "overWgtFlg");
		this.hashFields.put("c2_eml_snd_usr_id", "c2EmlSndUsrId");
		this.hashFields.put("eclz_obl_cpy_flg", "eclzOblCpyFlg");
		this.hashFields.put("an_fax_no", "anFaxNo");
		this.hashFields.put("c1_ntc_eml_chk", "c1NtcEmlChk");
		this.hashFields.put("an_fax_ntc_snd_rslt", "anFaxNtcSndRslt");
		this.hashFields.put("mnl_flg", "mnlFlg");
		this.hashFields.put("c2_eml_ntc_snd_rslt", "c2EmlNtcSndRslt");
		this.hashFields.put("show_pu_flg", "showPuFlg");
		this.hashFields.put("cop_pkup_yd_cd", "copPkupYdCd");
		
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return showPuFlg
	 */
	public String getShowPuFlg() {
		return this.showPuFlg;
	}
	
	/**
	 * Column Info
	 * @return anEmlNtcSndRslt
	 */
	public String getAnEmlNtcSndRslt() {
		return this.anEmlNtcSndRslt;
	}
	
	/**
	 * Column Info
	 * @return sndStsDesc
	 */
	public String getSndStsDesc() {
		return this.sndStsDesc;
	}
	
	/**
	 * Column Info
	 * @return c1EmlSndUsrId
	 */
	public String getC1EmlSndUsrId() {
		return this.c1EmlSndUsrId;
	}
	
	/**
	 * Column Info
	 * @return b2FaxNoChk
	 */
	public String getB2FaxNoChk() {
		return this.b2FaxNoChk;
	}
	
	/**
	 * Column Info
	 * @return b1EmlNtcSndId
	 */
	public String getB1EmlNtcSndId() {
		return this.b1EmlNtcSndId;
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
	 * @return pkupAvalDt
	 */
	public String getPkupAvalDt() {
		return this.pkupAvalDt;
	}
	
	/**
	 * Column Info
	 * @return edi322MvmtCd
	 */
	public String getEdi322MvmtCd() {
		return this.edi322MvmtCd;
	}
	
	/**
	 * Column Info
	 * @return mnlFlgShow
	 */
	public String getMnlFlgShow() {
		return this.mnlFlgShow;
	}
	
	/**
	 * Column Info
	 * @return anEmlSndDt
	 */
	public String getAnEmlSndDt() {
		return this.anEmlSndDt;
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
	 * @return c2FaxNtcSndId
	 */
	public String getC2FaxNtcSndId() {
		return this.c2FaxNtcSndId;
	}
	
	/**
	 * Column Info
	 * @return pkupNtcFomCd
	 */
	public String getPkupNtcFomCd() {
		return this.pkupNtcFomCd;
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
	 * @return b1FaxNo
	 */
	public String getB1FaxNo() {
		return this.b1FaxNo;
	}
	
	/**
	 * Column Info
	 * @return anFaxSndDt
	 */
	public String getAnFaxSndDt() {
		return this.anFaxSndDt;
	}
	
	/**
	 * Column Info
	 * @return c1NtcEml
	 */
	public String getC1NtcEml() {
		return this.c1NtcEml;
	}
	
	/**
	 * Column Info
	 * @return autoSndStopUsrId
	 */
	public String getAutoSndStopUsrId() {
		return this.autoSndStopUsrId;
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
	 * @return sndUsrId
	 */
	public String getSndUsrId() {
		return this.sndUsrId;
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
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return pkupNtcSndStsCd
	 */
	public String getPkupNtcSndStsCd() {
		return this.pkupNtcSndStsCd;
	}
	
	/**
	 * Column Info
	 * @return b1FaxNtcSndRslt
	 */
	public String getB1FaxNtcSndRslt() {
		return this.b1FaxNtcSndRslt;
	}
	
	/**
	 * Column Info
	 * @return b1FaxSndDt
	 */
	public String getB1FaxSndDt() {
		return this.b1FaxSndDt;
	}
	
	/**
	 * Column Info
	 * @return pkupYdCdFlg
	 */
	public String getPkupYdCdFlg() {
		return this.pkupYdCdFlg;
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
	 * @return c1FaxNtcSndRslt
	 */
	public String getC1FaxNtcSndRslt() {
		return this.c1FaxNtcSndRslt;
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
	 * @return b2EmlNtcSndRslt
	 */
	public String getB2EmlNtcSndRslt() {
		return this.b2EmlNtcSndRslt;
	}
	
	/**
	 * Column Info
	 * @return c2FaxNtcSndRslt
	 */
	public String getC2FaxNtcSndRslt() {
		return this.c2FaxNtcSndRslt;
	}
	
	/**
	 * Column Info
	 * @return b1EmlNtcSndRslt
	 */
	public String getB1EmlNtcSndRslt() {
		return this.b1EmlNtcSndRslt;
	}
	
	/**
	 * Column Info
	 * @return railLodDt
	 */
	public String getRailLodDt() {
		return this.railLodDt;
	}
	
	/**
	 * Column Info
	 * @return autoSndStopDt
	 */
	public String getAutoSndStopDt() {
		return this.autoSndStopDt;
	}
	
	/**
	 * Column Info
	 * @return c2EmlNtcSndId
	 */
	public String getC2EmlNtcSndId() {
		return this.c2EmlNtcSndId;
	}
	
	/**
	 * Column Info
	 * @return lstFreeDt
	 */
	public String getLstFreeDt() {
		return this.lstFreeDt;
	}
	
	/**
	 * Column Info
	 * @return b1FaxSndUsrId
	 */
	public String getB1FaxSndUsrId() {
		return this.b1FaxSndUsrId;
	}
	
	/**
	 * Column Info
	 * @return anEmlNtcSndId
	 */
	public String getAnEmlNtcSndId() {
		return this.anEmlNtcSndId;
	}
	
	/**
	 * Column Info
	 * @return ibdTrspHubCd
	 */
	public String getIbdTrspHubCd() {
		return this.ibdTrspHubCd;
	}
	
	/**
	 * Column Info
	 * @return ntcSeq
	 */
	public String getNtcSeq() {
		return this.ntcSeq;
	}
	
	/**
	 * Column Info
	 * @return autoSndResmDt
	 */
	public String getAutoSndResmDt() {
		return this.autoSndResmDt;
	}
	
	/**
	 * Column Info
	 * @return b2FaxNo
	 */
	public String getB2FaxNo() {
		return this.b2FaxNo;
	}
	
	/**
	 * Column Info
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
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
	 * @return faxSndDt
	 */
	public String getFaxSndDt() {
		return this.faxSndDt;
	}
	
	/**
	 * Column Info
	 * @return cstmsClrFlg
	 */
	public String getCstmsClrFlg() {
		return this.cstmsClrFlg;
	}
	
	/**
	 * Column Info
	 * @return c1EmlNtcSndId
	 */
	public String getC1EmlNtcSndId() {
		return this.c1EmlNtcSndId;
	}
	
	/**
	 * Column Info
	 * @return anFaxSndUsrId
	 */
	public String getAnFaxSndUsrId() {
		return this.anFaxSndUsrId;
	}
	
	/**
	 * Column Info
	 * @return pkupNoUpldUsrId
	 */
	public String getPkupNoUpldUsrId() {
		return this.pkupNoUpldUsrId;
	}
	
	/**
	 * Column Info
	 * @return emlSndDt
	 */
	public String getEmlSndDt() {
		return this.emlSndDt;
	}
	
	/**
	 * Column Info
	 * @return b2EmlSndDt
	 */
	public String getB2EmlSndDt() {
		return this.b2EmlSndDt;
	}
	
	/**
	 * Column Info
	 * @return oblCltFlg
	 */
	public String getOblCltFlg() {
		return this.oblCltFlg;
	}
	
	/**
	 * Column Info
	 * @return trspSoSeq
	 */
	public String getTrspSoSeq() {
		return this.trspSoSeq;
	}
	
	/**
	 * Column Info
	 * @return b1FaxNtcSndId
	 */
	public String getB1FaxNtcSndId() {
		return this.b1FaxNtcSndId;
	}
	
	/**
	 * Column Info
	 * @return c2EmlSndDt
	 */
	public String getC2EmlSndDt() {
		return this.c2EmlSndDt;
	}
	
	/**
	 * Column Info
	 * @return sndDt
	 */
	public String getSndDt() {
		return this.sndDt;
	}
	
	/**
	 * Column Info
	 * @return b2FaxNtcSndId
	 */
	public String getB2FaxNtcSndId() {
		return this.b2FaxNtcSndId;
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
	 * @return anNtcEml
	 */
	public String getAnNtcEml() {
		return this.anNtcEml;
	}
	
	/**
	 * Column Info
	 * @return pkupYdCd
	 */
	public String getPkupYdCd() {
		return this.pkupYdCd;
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
	 * @return c2NtcEmlChk
	 */
	public String getC2NtcEmlChk() {
		return this.c2NtcEmlChk;
	}
	
	/**
	 * Column Info
	 * @return b1NtcEmlChk
	 */
	public String getB1NtcEmlChk() {
		return this.b1NtcEmlChk;
	}
	
	/**
	 * Column Info
	 * @return c2FaxSndUsrId
	 */
	public String getC2FaxSndUsrId() {
		return this.c2FaxSndUsrId;
	}
	
	/**
	 * Column Info
	 * @return routGidDesc
	 */
	public String getRoutGidDesc() {
		return this.routGidDesc;
	}
	
	/**
	 * Column Info
	 * @return bkgCustTpCd
	 */
	public String getBkgCustTpCd() {
		return this.bkgCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return c1EmlNtcSndRslt
	 */
	public String getC1EmlNtcSndRslt() {
		return this.c1EmlNtcSndRslt;
	}
	
	/**
	 * Column Info
	 * @return pkupNoUpldVia
	 */
	public String getPkupNoUpldVia() {
		return this.pkupNoUpldVia;
	}
	
	/**
	 * Column Info
	 * @return c1FaxSndUsrId
	 */
	public String getC1FaxSndUsrId() {
		return this.c1FaxSndUsrId;
	}
	
	/**
	 * Column Info
	 * @return pkupNtcFomCdShow
	 */
	public String getPkupNtcFomCdShow() {
		return this.pkupNtcFomCdShow;
	}
	
	/**
	 * Column Info
	 * @return c2NtcEml
	 */
	public String getC2NtcEml() {
		return this.c2NtcEml;
	}
	
	/**
	 * Column Info
	 * @return b1EmlSndUsrId
	 */
	public String getB1EmlSndUsrId() {
		return this.b1EmlSndUsrId;
	}
	
	/**
	 * Column Info
	 * @return dorTrkrWoFlg
	 */
	public String getDorTrkrWoFlg() {
		return this.dorTrkrWoFlg;
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
	 * @return sndProcStsCd
	 */
	public String getSndProcStsCd() {
		return this.sndProcStsCd;
	}
	
	/**
	 * Column Info
	 * @return c2FaxSndDt
	 */
	public String getC2FaxSndDt() {
		return this.c2FaxSndDt;
	}
	
	/**
	 * Column Info
	 * @return c2FaxNoChk
	 */
	public String getC2FaxNoChk() {
		return this.c2FaxNoChk;
	}
	
	/**
	 * Column Info
	 * @return b2FaxSndUsrId
	 */
	public String getB2FaxSndUsrId() {
		return this.b2FaxSndUsrId;
	}
	
	/**
	 * Column Info
	 * @return anNtcEmlChk
	 */
	public String getAnNtcEmlChk() {
		return this.anNtcEmlChk;
	}
	
	/**
	 * Column Info
	 * @return c1FaxNo
	 */
	public String getC1FaxNo() {
		return this.c1FaxNo;
	}
	
	/**
	 * Column Info
	 * @return pkupNoUpldRailCo
	 */
	public String getPkupNoUpldRailCo() {
		return this.pkupNoUpldRailCo;
	}
	
	/**
	 * Column Info
	 * @return anFaxNoChk
	 */
	public String getAnFaxNoChk() {
		return this.anFaxNoChk;
	}
	
	/**
	 * Column Info
	 * @return b1NtcEml
	 */
	public String getB1NtcEml() {
		return this.b1NtcEml;
	}
	
	/**
	 * Column Info
	 * @return b2NtcEml
	 */
	public String getB2NtcEml() {
		return this.b2NtcEml;
	}
	
	/**
	 * Column Info
	 * @return eqCtrlOfcCd
	 */
	public String getEqCtrlOfcCd() {
		return this.eqCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return anEmlSndUsrId
	 */
	public String getAnEmlSndUsrId() {
		return this.anEmlSndUsrId;
	}
	
	/**
	 * Column Info
	 * @return c1FaxNoChk
	 */
	public String getC1FaxNoChk() {
		return this.c1FaxNoChk;
	}
	
	/**
	 * Column Info
	 * @return pkupNtcTpCd
	 */
	public String getPkupNtcTpCd() {
		return this.pkupNtcTpCd;
	}
	
	/**
	 * Column Info
	 * @return c1FaxNtcSndId
	 */
	public String getC1FaxNtcSndId() {
		return this.c1FaxNtcSndId;
	}
	
	/**
	 * Column Info
	 * @return trspSoOfcCtyCd
	 */
	public String getTrspSoOfcCtyCd() {
		return this.trspSoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return c1EmlSndDt
	 */
	public String getC1EmlSndDt() {
		return this.c1EmlSndDt;
	}
	
	/**
	 * Column Info
	 * @return pkupNoUpldDt
	 */
	public String getPkupNoUpldDt() {
		return this.pkupNoUpldDt;
	}
	
	/**
	 * Column Info
	 * @return c2FaxNo
	 */
	public String getC2FaxNo() {
		return this.c2FaxNo;
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
	 * @return nvoccFileNo
	 */
	public String getNvoccFileNo() {
		return this.nvoccFileNo;
	}
	
	/**
	 * Column Info
	 * @return b2EmlSndUsrId
	 */
	public String getB2EmlSndUsrId() {
		return this.b2EmlSndUsrId;
	}
	
	/**
	 * Column Info
	 * @return anFaxNtcSndId
	 */
	public String getAnFaxNtcSndId() {
		return this.anFaxNtcSndId;
	}
	
	/**
	 * Column Info
	 * @return b2FaxNtcSndRslt
	 */
	public String getB2FaxNtcSndRslt() {
		return this.b2FaxNtcSndRslt;
	}
	
	/**
	 * Column Info
	 * @return vvdId
	 */
	public String getVvdId() {
		return this.vvdId;
	}
	
	/**
	 * Column Info
	 * @return b1EmlSndDt
	 */
	public String getB1EmlSndDt() {
		return this.b1EmlSndDt;
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
	 * @return b2FaxSndDt
	 */
	public String getB2FaxSndDt() {
		return this.b2FaxSndDt;
	}
	
	/**
	 * Column Info
	 * @return b1FaxNoChk
	 */
	public String getB1FaxNoChk() {
		return this.b1FaxNoChk;
	}
	
	/**
	 * Column Info
	 * @return b2NtcEmlChk
	 */
	public String getB2NtcEmlChk() {
		return this.b2NtcEmlChk;
	}
	
	/**
	 * Column Info
	 * @return sndYn
	 */
	public String getSndYn() {
		return this.sndYn;
	}
	
	/**
	 * Column Info
	 * @return rtnYdCd
	 */
	public String getRtnYdCd() {
		return this.rtnYdCd;
	}
	
	/**
	 * Column Info
	 * @return b2EmlNtcSndId
	 */
	public String getB2EmlNtcSndId() {
		return this.b2EmlNtcSndId;
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
	 * @return autoSndResmUsrId
	 */
	public String getAutoSndResmUsrId() {
		return this.autoSndResmUsrId;
	}
	
	/**
	 * Column Info
	 * @return c1FaxSndDt
	 */
	public String getC1FaxSndDt() {
		return this.c1FaxSndDt;
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
	 * @return overWgtFlg
	 */
	public String getOverWgtFlg() {
		return this.overWgtFlg;
	}
	
	/**
	 * Column Info
	 * @return c2EmlSndUsrId
	 */
	public String getC2EmlSndUsrId() {
		return this.c2EmlSndUsrId;
	}
	
	/**
	 * Column Info
	 * @return eclzOblCpyFlg
	 */
	public String getEclzOblCpyFlg() {
		return this.eclzOblCpyFlg;
	}
	
	/**
	 * Column Info
	 * @return anFaxNo
	 */
	public String getAnFaxNo() {
		return this.anFaxNo;
	}
	
	/**
	 * Column Info
	 * @return c1NtcEmlChk
	 */
	public String getC1NtcEmlChk() {
		return this.c1NtcEmlChk;
	}
	
	/**
	 * Column Info
	 * @return anFaxNtcSndRslt
	 */
	public String getAnFaxNtcSndRslt() {
		return this.anFaxNtcSndRslt;
	}
	
	/**
	 * Column Info
	 * @return mnlFlg
	 */
	public String getMnlFlg() {
		return this.mnlFlg;
	}
	
	/**
	 * Column Info
	 * @return c2EmlNtcSndRslt
	 */
	public String getC2EmlNtcSndRslt() {
		return this.c2EmlNtcSndRslt;
	}
	
	/**
	 * Column Info
	 * @return copPkupYdCd
	 */
	public String getCopPkupYdCd() {
		return this.copPkupYdCd;
	}
	
	/**
	 * Column Info
	 * @param copPkupYdCd
	 */
	public void setCopPkupYdCd(String copPkupYdCd) {
		this.copPkupYdCd = copPkupYdCd;
	}


	/**
	 * Column Info
	 * @param showPuFlg
	 */
	public void setShowPuFlg(String showPuFlg) {
		this.showPuFlg = showPuFlg;
	}

	/**
	 * Column Info
	 * @param anEmlNtcSndRslt
	 */
	public void setAnEmlNtcSndRslt(String anEmlNtcSndRslt) {
		this.anEmlNtcSndRslt = anEmlNtcSndRslt;
	}
	
	/**
	 * Column Info
	 * @param sndStsDesc
	 */
	public void setSndStsDesc(String sndStsDesc) {
		this.sndStsDesc = sndStsDesc;
	}
	
	/**
	 * Column Info
	 * @param c1EmlSndUsrId
	 */
	public void setC1EmlSndUsrId(String c1EmlSndUsrId) {
		this.c1EmlSndUsrId = c1EmlSndUsrId;
	}
	
	/**
	 * Column Info
	 * @param b2FaxNoChk
	 */
	public void setB2FaxNoChk(String b2FaxNoChk) {
		this.b2FaxNoChk = b2FaxNoChk;
	}
	
	/**
	 * Column Info
	 * @param b1EmlNtcSndId
	 */
	public void setB1EmlNtcSndId(String b1EmlNtcSndId) {
		this.b1EmlNtcSndId = b1EmlNtcSndId;
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
	 * @param pkupAvalDt
	 */
	public void setPkupAvalDt(String pkupAvalDt) {
		this.pkupAvalDt = pkupAvalDt;
	}
	
	/**
	 * Column Info
	 * @param edi322MvmtCd
	 */
	public void setEdi322MvmtCd(String edi322MvmtCd) {
		this.edi322MvmtCd = edi322MvmtCd;
	}
	
	/**
	 * Column Info
	 * @param mnlFlgShow
	 */
	public void setMnlFlgShow(String mnlFlgShow) {
		this.mnlFlgShow = mnlFlgShow;
	}
	
	/**
	 * Column Info
	 * @param anEmlSndDt
	 */
	public void setAnEmlSndDt(String anEmlSndDt) {
		this.anEmlSndDt = anEmlSndDt;
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
	 * @param c2FaxNtcSndId
	 */
	public void setC2FaxNtcSndId(String c2FaxNtcSndId) {
		this.c2FaxNtcSndId = c2FaxNtcSndId;
	}
	
	/**
	 * Column Info
	 * @param pkupNtcFomCd
	 */
	public void setPkupNtcFomCd(String pkupNtcFomCd) {
		this.pkupNtcFomCd = pkupNtcFomCd;
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
	 * @param b1FaxNo
	 */
	public void setB1FaxNo(String b1FaxNo) {
		this.b1FaxNo = b1FaxNo;
	}
	
	/**
	 * Column Info
	 * @param anFaxSndDt
	 */
	public void setAnFaxSndDt(String anFaxSndDt) {
		this.anFaxSndDt = anFaxSndDt;
	}
	
	/**
	 * Column Info
	 * @param c1NtcEml
	 */
	public void setC1NtcEml(String c1NtcEml) {
		this.c1NtcEml = c1NtcEml;
	}
	
	/**
	 * Column Info
	 * @param autoSndStopUsrId
	 */
	public void setAutoSndStopUsrId(String autoSndStopUsrId) {
		this.autoSndStopUsrId = autoSndStopUsrId;
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
	 * @param sndUsrId
	 */
	public void setSndUsrId(String sndUsrId) {
		this.sndUsrId = sndUsrId;
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
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param pkupNtcSndStsCd
	 */
	public void setPkupNtcSndStsCd(String pkupNtcSndStsCd) {
		this.pkupNtcSndStsCd = pkupNtcSndStsCd;
	}
	
	/**
	 * Column Info
	 * @param b1FaxNtcSndRslt
	 */
	public void setB1FaxNtcSndRslt(String b1FaxNtcSndRslt) {
		this.b1FaxNtcSndRslt = b1FaxNtcSndRslt;
	}
	
	/**
	 * Column Info
	 * @param b1FaxSndDt
	 */
	public void setB1FaxSndDt(String b1FaxSndDt) {
		this.b1FaxSndDt = b1FaxSndDt;
	}
	
	/**
	 * Column Info
	 * @param pkupYdCdFlg
	 */
	public void setPkupYdCdFlg(String pkupYdCdFlg) {
		this.pkupYdCdFlg = pkupYdCdFlg;
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
	 * @param c1FaxNtcSndRslt
	 */
	public void setC1FaxNtcSndRslt(String c1FaxNtcSndRslt) {
		this.c1FaxNtcSndRslt = c1FaxNtcSndRslt;
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
	 * @param b2EmlNtcSndRslt
	 */
	public void setB2EmlNtcSndRslt(String b2EmlNtcSndRslt) {
		this.b2EmlNtcSndRslt = b2EmlNtcSndRslt;
	}
	
	/**
	 * Column Info
	 * @param c2FaxNtcSndRslt
	 */
	public void setC2FaxNtcSndRslt(String c2FaxNtcSndRslt) {
		this.c2FaxNtcSndRslt = c2FaxNtcSndRslt;
	}
	
	/**
	 * Column Info
	 * @param b1EmlNtcSndRslt
	 */
	public void setB1EmlNtcSndRslt(String b1EmlNtcSndRslt) {
		this.b1EmlNtcSndRslt = b1EmlNtcSndRslt;
	}
	
	/**
	 * Column Info
	 * @param railLodDt
	 */
	public void setRailLodDt(String railLodDt) {
		this.railLodDt = railLodDt;
	}
	
	/**
	 * Column Info
	 * @param autoSndStopDt
	 */
	public void setAutoSndStopDt(String autoSndStopDt) {
		this.autoSndStopDt = autoSndStopDt;
	}
	
	/**
	 * Column Info
	 * @param c2EmlNtcSndId
	 */
	public void setC2EmlNtcSndId(String c2EmlNtcSndId) {
		this.c2EmlNtcSndId = c2EmlNtcSndId;
	}
	
	/**
	 * Column Info
	 * @param lstFreeDt
	 */
	public void setLstFreeDt(String lstFreeDt) {
		this.lstFreeDt = lstFreeDt;
	}
	
	/**
	 * Column Info
	 * @param b1FaxSndUsrId
	 */
	public void setB1FaxSndUsrId(String b1FaxSndUsrId) {
		this.b1FaxSndUsrId = b1FaxSndUsrId;
	}
	
	/**
	 * Column Info
	 * @param anEmlNtcSndId
	 */
	public void setAnEmlNtcSndId(String anEmlNtcSndId) {
		this.anEmlNtcSndId = anEmlNtcSndId;
	}
	
	/**
	 * Column Info
	 * @param ibdTrspHubCd
	 */
	public void setIbdTrspHubCd(String ibdTrspHubCd) {
		this.ibdTrspHubCd = ibdTrspHubCd;
	}
	
	/**
	 * Column Info
	 * @param ntcSeq
	 */
	public void setNtcSeq(String ntcSeq) {
		this.ntcSeq = ntcSeq;
	}
	
	/**
	 * Column Info
	 * @param autoSndResmDt
	 */
	public void setAutoSndResmDt(String autoSndResmDt) {
		this.autoSndResmDt = autoSndResmDt;
	}
	
	/**
	 * Column Info
	 * @param b2FaxNo
	 */
	public void setB2FaxNo(String b2FaxNo) {
		this.b2FaxNo = b2FaxNo;
	}
	
	/**
	 * Column Info
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
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
	 * @param faxSndDt
	 */
	public void setFaxSndDt(String faxSndDt) {
		this.faxSndDt = faxSndDt;
	}
	
	/**
	 * Column Info
	 * @param cstmsClrFlg
	 */
	public void setCstmsClrFlg(String cstmsClrFlg) {
		this.cstmsClrFlg = cstmsClrFlg;
	}
	
	/**
	 * Column Info
	 * @param c1EmlNtcSndId
	 */
	public void setC1EmlNtcSndId(String c1EmlNtcSndId) {
		this.c1EmlNtcSndId = c1EmlNtcSndId;
	}
	
	/**
	 * Column Info
	 * @param anFaxSndUsrId
	 */
	public void setAnFaxSndUsrId(String anFaxSndUsrId) {
		this.anFaxSndUsrId = anFaxSndUsrId;
	}
	
	/**
	 * Column Info
	 * @param pkupNoUpldUsrId
	 */
	public void setPkupNoUpldUsrId(String pkupNoUpldUsrId) {
		this.pkupNoUpldUsrId = pkupNoUpldUsrId;
	}
	
	/**
	 * Column Info
	 * @param emlSndDt
	 */
	public void setEmlSndDt(String emlSndDt) {
		this.emlSndDt = emlSndDt;
	}
	
	/**
	 * Column Info
	 * @param b2EmlSndDt
	 */
	public void setB2EmlSndDt(String b2EmlSndDt) {
		this.b2EmlSndDt = b2EmlSndDt;
	}
	
	/**
	 * Column Info
	 * @param oblCltFlg
	 */
	public void setOblCltFlg(String oblCltFlg) {
		this.oblCltFlg = oblCltFlg;
	}
	
	/**
	 * Column Info
	 * @param trspSoSeq
	 */
	public void setTrspSoSeq(String trspSoSeq) {
		this.trspSoSeq = trspSoSeq;
	}
	
	/**
	 * Column Info
	 * @param b1FaxNtcSndId
	 */
	public void setB1FaxNtcSndId(String b1FaxNtcSndId) {
		this.b1FaxNtcSndId = b1FaxNtcSndId;
	}
	
	/**
	 * Column Info
	 * @param c2EmlSndDt
	 */
	public void setC2EmlSndDt(String c2EmlSndDt) {
		this.c2EmlSndDt = c2EmlSndDt;
	}
	
	/**
	 * Column Info
	 * @param sndDt
	 */
	public void setSndDt(String sndDt) {
		this.sndDt = sndDt;
	}
	
	/**
	 * Column Info
	 * @param b2FaxNtcSndId
	 */
	public void setB2FaxNtcSndId(String b2FaxNtcSndId) {
		this.b2FaxNtcSndId = b2FaxNtcSndId;
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
	 * @param anNtcEml
	 */
	public void setAnNtcEml(String anNtcEml) {
		this.anNtcEml = anNtcEml;
	}
	
	/**
	 * Column Info
	 * @param pkupYdCd
	 */
	public void setPkupYdCd(String pkupYdCd) {
		this.pkupYdCd = pkupYdCd;
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
	 * @param c2NtcEmlChk
	 */
	public void setC2NtcEmlChk(String c2NtcEmlChk) {
		this.c2NtcEmlChk = c2NtcEmlChk;
	}
	
	/**
	 * Column Info
	 * @param b1NtcEmlChk
	 */
	public void setB1NtcEmlChk(String b1NtcEmlChk) {
		this.b1NtcEmlChk = b1NtcEmlChk;
	}
	
	/**
	 * Column Info
	 * @param c2FaxSndUsrId
	 */
	public void setC2FaxSndUsrId(String c2FaxSndUsrId) {
		this.c2FaxSndUsrId = c2FaxSndUsrId;
	}
	
	/**
	 * Column Info
	 * @param routGidDesc
	 */
	public void setRoutGidDesc(String routGidDesc) {
		this.routGidDesc = routGidDesc;
	}
	
	/**
	 * Column Info
	 * @param bkgCustTpCd
	 */
	public void setBkgCustTpCd(String bkgCustTpCd) {
		this.bkgCustTpCd = bkgCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param c1EmlNtcSndRslt
	 */
	public void setC1EmlNtcSndRslt(String c1EmlNtcSndRslt) {
		this.c1EmlNtcSndRslt = c1EmlNtcSndRslt;
	}
	
	/**
	 * Column Info
	 * @param pkupNoUpldVia
	 */
	public void setPkupNoUpldVia(String pkupNoUpldVia) {
		this.pkupNoUpldVia = pkupNoUpldVia;
	}
	
	/**
	 * Column Info
	 * @param c1FaxSndUsrId
	 */
	public void setC1FaxSndUsrId(String c1FaxSndUsrId) {
		this.c1FaxSndUsrId = c1FaxSndUsrId;
	}
	
	/**
	 * Column Info
	 * @param pkupNtcFomCdShow
	 */
	public void setPkupNtcFomCdShow(String pkupNtcFomCdShow) {
		this.pkupNtcFomCdShow = pkupNtcFomCdShow;
	}
	
	/**
	 * Column Info
	 * @param c2NtcEml
	 */
	public void setC2NtcEml(String c2NtcEml) {
		this.c2NtcEml = c2NtcEml;
	}
	
	/**
	 * Column Info
	 * @param b1EmlSndUsrId
	 */
	public void setB1EmlSndUsrId(String b1EmlSndUsrId) {
		this.b1EmlSndUsrId = b1EmlSndUsrId;
	}
	
	/**
	 * Column Info
	 * @param dorTrkrWoFlg
	 */
	public void setDorTrkrWoFlg(String dorTrkrWoFlg) {
		this.dorTrkrWoFlg = dorTrkrWoFlg;
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
	 * @param sndProcStsCd
	 */
	public void setSndProcStsCd(String sndProcStsCd) {
		this.sndProcStsCd = sndProcStsCd;
	}
	
	/**
	 * Column Info
	 * @param c2FaxSndDt
	 */
	public void setC2FaxSndDt(String c2FaxSndDt) {
		this.c2FaxSndDt = c2FaxSndDt;
	}
	
	/**
	 * Column Info
	 * @param c2FaxNoChk
	 */
	public void setC2FaxNoChk(String c2FaxNoChk) {
		this.c2FaxNoChk = c2FaxNoChk;
	}
	
	/**
	 * Column Info
	 * @param b2FaxSndUsrId
	 */
	public void setB2FaxSndUsrId(String b2FaxSndUsrId) {
		this.b2FaxSndUsrId = b2FaxSndUsrId;
	}
	
	/**
	 * Column Info
	 * @param anNtcEmlChk
	 */
	public void setAnNtcEmlChk(String anNtcEmlChk) {
		this.anNtcEmlChk = anNtcEmlChk;
	}
	
	/**
	 * Column Info
	 * @param c1FaxNo
	 */
	public void setC1FaxNo(String c1FaxNo) {
		this.c1FaxNo = c1FaxNo;
	}
	
	/**
	 * Column Info
	 * @param pkupNoUpldRailCo
	 */
	public void setPkupNoUpldRailCo(String pkupNoUpldRailCo) {
		this.pkupNoUpldRailCo = pkupNoUpldRailCo;
	}
	
	/**
	 * Column Info
	 * @param anFaxNoChk
	 */
	public void setAnFaxNoChk(String anFaxNoChk) {
		this.anFaxNoChk = anFaxNoChk;
	}
	
	/**
	 * Column Info
	 * @param b1NtcEml
	 */
	public void setB1NtcEml(String b1NtcEml) {
		this.b1NtcEml = b1NtcEml;
	}
	
	/**
	 * Column Info
	 * @param b2NtcEml
	 */
	public void setB2NtcEml(String b2NtcEml) {
		this.b2NtcEml = b2NtcEml;
	}
	
	/**
	 * Column Info
	 * @param eqCtrlOfcCd
	 */
	public void setEqCtrlOfcCd(String eqCtrlOfcCd) {
		this.eqCtrlOfcCd = eqCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param anEmlSndUsrId
	 */
	public void setAnEmlSndUsrId(String anEmlSndUsrId) {
		this.anEmlSndUsrId = anEmlSndUsrId;
	}
	
	/**
	 * Column Info
	 * @param c1FaxNoChk
	 */
	public void setC1FaxNoChk(String c1FaxNoChk) {
		this.c1FaxNoChk = c1FaxNoChk;
	}
	
	/**
	 * Column Info
	 * @param pkupNtcTpCd
	 */
	public void setPkupNtcTpCd(String pkupNtcTpCd) {
		this.pkupNtcTpCd = pkupNtcTpCd;
	}
	
	/**
	 * Column Info
	 * @param c1FaxNtcSndId
	 */
	public void setC1FaxNtcSndId(String c1FaxNtcSndId) {
		this.c1FaxNtcSndId = c1FaxNtcSndId;
	}
	
	/**
	 * Column Info
	 * @param trspSoOfcCtyCd
	 */
	public void setTrspSoOfcCtyCd(String trspSoOfcCtyCd) {
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param c1EmlSndDt
	 */
	public void setC1EmlSndDt(String c1EmlSndDt) {
		this.c1EmlSndDt = c1EmlSndDt;
	}
	
	/**
	 * Column Info
	 * @param pkupNoUpldDt
	 */
	public void setPkupNoUpldDt(String pkupNoUpldDt) {
		this.pkupNoUpldDt = pkupNoUpldDt;
	}
	
	/**
	 * Column Info
	 * @param c2FaxNo
	 */
	public void setC2FaxNo(String c2FaxNo) {
		this.c2FaxNo = c2FaxNo;
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
	 * @param nvoccFileNo
	 */
	public void setNvoccFileNo(String nvoccFileNo) {
		this.nvoccFileNo = nvoccFileNo;
	}
	
	/**
	 * Column Info
	 * @param b2EmlSndUsrId
	 */
	public void setB2EmlSndUsrId(String b2EmlSndUsrId) {
		this.b2EmlSndUsrId = b2EmlSndUsrId;
	}
	
	/**
	 * Column Info
	 * @param anFaxNtcSndId
	 */
	public void setAnFaxNtcSndId(String anFaxNtcSndId) {
		this.anFaxNtcSndId = anFaxNtcSndId;
	}
	
	/**
	 * Column Info
	 * @param b2FaxNtcSndRslt
	 */
	public void setB2FaxNtcSndRslt(String b2FaxNtcSndRslt) {
		this.b2FaxNtcSndRslt = b2FaxNtcSndRslt;
	}
	
	/**
	 * Column Info
	 * @param vvdId
	 */
	public void setVvdId(String vvdId) {
		this.vvdId = vvdId;
	}
	
	/**
	 * Column Info
	 * @param b1EmlSndDt
	 */
	public void setB1EmlSndDt(String b1EmlSndDt) {
		this.b1EmlSndDt = b1EmlSndDt;
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
	 * @param b2FaxSndDt
	 */
	public void setB2FaxSndDt(String b2FaxSndDt) {
		this.b2FaxSndDt = b2FaxSndDt;
	}
	
	/**
	 * Column Info
	 * @param b1FaxNoChk
	 */
	public void setB1FaxNoChk(String b1FaxNoChk) {
		this.b1FaxNoChk = b1FaxNoChk;
	}
	
	/**
	 * Column Info
	 * @param b2NtcEmlChk
	 */
	public void setB2NtcEmlChk(String b2NtcEmlChk) {
		this.b2NtcEmlChk = b2NtcEmlChk;
	}
	
	/**
	 * Column Info
	 * @param sndYn
	 */
	public void setSndYn(String sndYn) {
		this.sndYn = sndYn;
	}
	
	/**
	 * Column Info
	 * @param rtnYdCd
	 */
	public void setRtnYdCd(String rtnYdCd) {
		this.rtnYdCd = rtnYdCd;
	}
	
	/**
	 * Column Info
	 * @param b2EmlNtcSndId
	 */
	public void setB2EmlNtcSndId(String b2EmlNtcSndId) {
		this.b2EmlNtcSndId = b2EmlNtcSndId;
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
	 * @param autoSndResmUsrId
	 */
	public void setAutoSndResmUsrId(String autoSndResmUsrId) {
		this.autoSndResmUsrId = autoSndResmUsrId;
	}
	
	/**
	 * Column Info
	 * @param c1FaxSndDt
	 */
	public void setC1FaxSndDt(String c1FaxSndDt) {
		this.c1FaxSndDt = c1FaxSndDt;
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
	 * @param overWgtFlg
	 */
	public void setOverWgtFlg(String overWgtFlg) {
		this.overWgtFlg = overWgtFlg;
	}
	
	/**
	 * Column Info
	 * @param c2EmlSndUsrId
	 */
	public void setC2EmlSndUsrId(String c2EmlSndUsrId) {
		this.c2EmlSndUsrId = c2EmlSndUsrId;
	}
	
	/**
	 * Column Info
	 * @param eclzOblCpyFlg
	 */
	public void setEclzOblCpyFlg(String eclzOblCpyFlg) {
		this.eclzOblCpyFlg = eclzOblCpyFlg;
	}
	
	/**
	 * Column Info
	 * @param anFaxNo
	 */
	public void setAnFaxNo(String anFaxNo) {
		this.anFaxNo = anFaxNo;
	}
	
	/**
	 * Column Info
	 * @param c1NtcEmlChk
	 */
	public void setC1NtcEmlChk(String c1NtcEmlChk) {
		this.c1NtcEmlChk = c1NtcEmlChk;
	}
	
	/**
	 * Column Info
	 * @param anFaxNtcSndRslt
	 */
	public void setAnFaxNtcSndRslt(String anFaxNtcSndRslt) {
		this.anFaxNtcSndRslt = anFaxNtcSndRslt;
	}
	
	/**
	 * Column Info
	 * @param mnlFlg
	 */
	public void setMnlFlg(String mnlFlg) {
		this.mnlFlg = mnlFlg;
	}
	
	/**
	 * Column Info
	 * @param c2EmlNtcSndRslt
	 */
	public void setC2EmlNtcSndRslt(String c2EmlNtcSndRslt) {
		this.c2EmlNtcSndRslt = c2EmlNtcSndRslt;
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
		setAnEmlNtcSndRslt(JSPUtil.getParameter(request, prefix + "an_eml_ntc_snd_rslt", ""));
		setSndStsDesc(JSPUtil.getParameter(request, prefix + "snd_sts_desc", ""));
		setC1EmlSndUsrId(JSPUtil.getParameter(request, prefix + "c1_eml_snd_usr_id", ""));
		setB2FaxNoChk(JSPUtil.getParameter(request, prefix + "b2_fax_no_chk", ""));
		setB1EmlNtcSndId(JSPUtil.getParameter(request, prefix + "b1_eml_ntc_snd_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPkupAvalDt(JSPUtil.getParameter(request, prefix + "pkup_aval_dt", ""));
		setEdi322MvmtCd(JSPUtil.getParameter(request, prefix + "edi_322_mvmt_cd", ""));
		setMnlFlgShow(JSPUtil.getParameter(request, prefix + "mnl_flg_show", ""));
		setAnEmlSndDt(JSPUtil.getParameter(request, prefix + "an_eml_snd_dt", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setC2FaxNtcSndId(JSPUtil.getParameter(request, prefix + "c2_fax_ntc_snd_id", ""));
		setPkupNtcFomCd(JSPUtil.getParameter(request, prefix + "pkup_ntc_fom_cd", ""));
		setCntrWgt(JSPUtil.getParameter(request, prefix + "cntr_wgt", ""));
		setB1FaxNo(JSPUtil.getParameter(request, prefix + "b1_fax_no", ""));
		setAnFaxSndDt(JSPUtil.getParameter(request, prefix + "an_fax_snd_dt", ""));
		setC1NtcEml(JSPUtil.getParameter(request, prefix + "c1_ntc_eml", ""));
		setAutoSndStopUsrId(JSPUtil.getParameter(request, prefix + "auto_snd_stop_usr_id", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setSndUsrId(JSPUtil.getParameter(request, prefix + "snd_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setPkupNtcSndStsCd(JSPUtil.getParameter(request, prefix + "pkup_ntc_snd_sts_cd", ""));
		setB1FaxNtcSndRslt(JSPUtil.getParameter(request, prefix + "b1_fax_ntc_snd_rslt", ""));
		setB1FaxSndDt(JSPUtil.getParameter(request, prefix + "b1_fax_snd_dt", ""));
		setPkupYdCdFlg(JSPUtil.getParameter(request, prefix + "pkup_yd_cd_flg", ""));
		setPkupNo(JSPUtil.getParameter(request, prefix + "pkup_no", ""));
		setC1FaxNtcSndRslt(JSPUtil.getParameter(request, prefix + "c1_fax_ntc_snd_rslt", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setB2EmlNtcSndRslt(JSPUtil.getParameter(request, prefix + "b2_eml_ntc_snd_rslt", ""));
		setC2FaxNtcSndRslt(JSPUtil.getParameter(request, prefix + "c2_fax_ntc_snd_rslt", ""));
		setB1EmlNtcSndRslt(JSPUtil.getParameter(request, prefix + "b1_eml_ntc_snd_rslt", ""));
		setRailLodDt(JSPUtil.getParameter(request, prefix + "rail_lod_dt", ""));
		setAutoSndStopDt(JSPUtil.getParameter(request, prefix + "auto_snd_stop_dt", ""));
		setC2EmlNtcSndId(JSPUtil.getParameter(request, prefix + "c2_eml_ntc_snd_id", ""));
		setLstFreeDt(JSPUtil.getParameter(request, prefix + "lst_free_dt", ""));
		setB1FaxSndUsrId(JSPUtil.getParameter(request, prefix + "b1_fax_snd_usr_id", ""));
		setAnEmlNtcSndId(JSPUtil.getParameter(request, prefix + "an_eml_ntc_snd_id", ""));
		setIbdTrspHubCd(JSPUtil.getParameter(request, prefix + "ibd_trsp_hub_cd", ""));
		setNtcSeq(JSPUtil.getParameter(request, prefix + "ntc_seq", ""));
		setAutoSndResmDt(JSPUtil.getParameter(request, prefix + "auto_snd_resm_dt", ""));
		setB2FaxNo(JSPUtil.getParameter(request, prefix + "b2_fax_no", ""));
		setDiffRmk(JSPUtil.getParameter(request, prefix + "diff_rmk", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setFaxSndDt(JSPUtil.getParameter(request, prefix + "fax_snd_dt", ""));
		setCstmsClrFlg(JSPUtil.getParameter(request, prefix + "cstms_clr_flg", ""));
		setC1EmlNtcSndId(JSPUtil.getParameter(request, prefix + "c1_eml_ntc_snd_id", ""));
		setAnFaxSndUsrId(JSPUtil.getParameter(request, prefix + "an_fax_snd_usr_id", ""));
		setPkupNoUpldUsrId(JSPUtil.getParameter(request, prefix + "pkup_no_upld_usr_id", ""));
		setEmlSndDt(JSPUtil.getParameter(request, prefix + "eml_snd_dt", ""));
		setB2EmlSndDt(JSPUtil.getParameter(request, prefix + "b2_eml_snd_dt", ""));
		setOblCltFlg(JSPUtil.getParameter(request, prefix + "obl_clt_flg", ""));
		setTrspSoSeq(JSPUtil.getParameter(request, prefix + "trsp_so_seq", ""));
		setB1FaxNtcSndId(JSPUtil.getParameter(request, prefix + "b1_fax_ntc_snd_id", ""));
		setC2EmlSndDt(JSPUtil.getParameter(request, prefix + "c2_eml_snd_dt", ""));
		setSndDt(JSPUtil.getParameter(request, prefix + "snd_dt", ""));
		setB2FaxNtcSndId(JSPUtil.getParameter(request, prefix + "b2_fax_ntc_snd_id", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setAnNtcEml(JSPUtil.getParameter(request, prefix + "an_ntc_eml", ""));
		setPkupYdCd(JSPUtil.getParameter(request, prefix + "pkup_yd_cd", ""));
		setFrtCltFlg(JSPUtil.getParameter(request, prefix + "frt_clt_flg", ""));
		setC2NtcEmlChk(JSPUtil.getParameter(request, prefix + "c2_ntc_eml_chk", ""));
		setB1NtcEmlChk(JSPUtil.getParameter(request, prefix + "b1_ntc_eml_chk", ""));
		setC2FaxSndUsrId(JSPUtil.getParameter(request, prefix + "c2_fax_snd_usr_id", ""));
		setRoutGidDesc(JSPUtil.getParameter(request, prefix + "rout_gid_desc", ""));
		setBkgCustTpCd(JSPUtil.getParameter(request, prefix + "bkg_cust_tp_cd", ""));
		setC1EmlNtcSndRslt(JSPUtil.getParameter(request, prefix + "c1_eml_ntc_snd_rslt", ""));
		setPkupNoUpldVia(JSPUtil.getParameter(request, prefix + "pkup_no_upld_via", ""));
		setC1FaxSndUsrId(JSPUtil.getParameter(request, prefix + "c1_fax_snd_usr_id", ""));
		setPkupNtcFomCdShow(JSPUtil.getParameter(request, prefix + "pkup_ntc_fom_cd_show", ""));
		setC2NtcEml(JSPUtil.getParameter(request, prefix + "c2_ntc_eml", ""));
		setB1EmlSndUsrId(JSPUtil.getParameter(request, prefix + "b1_eml_snd_usr_id", ""));
		setDorTrkrWoFlg(JSPUtil.getParameter(request, prefix + "dor_trkr_wo_flg", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setSndProcStsCd(JSPUtil.getParameter(request, prefix + "snd_proc_sts_cd", ""));
		setC2FaxSndDt(JSPUtil.getParameter(request, prefix + "c2_fax_snd_dt", ""));
		setC2FaxNoChk(JSPUtil.getParameter(request, prefix + "c2_fax_no_chk", ""));
		setB2FaxSndUsrId(JSPUtil.getParameter(request, prefix + "b2_fax_snd_usr_id", ""));
		setAnNtcEmlChk(JSPUtil.getParameter(request, prefix + "an_ntc_eml_chk", ""));
		setC1FaxNo(JSPUtil.getParameter(request, prefix + "c1_fax_no", ""));
		setPkupNoUpldRailCo(JSPUtil.getParameter(request, prefix + "pkup_no_upld_rail_co", ""));
		setAnFaxNoChk(JSPUtil.getParameter(request, prefix + "an_fax_no_chk", ""));
		setB1NtcEml(JSPUtil.getParameter(request, prefix + "b1_ntc_eml", ""));
		setB2NtcEml(JSPUtil.getParameter(request, prefix + "b2_ntc_eml", ""));
		setEqCtrlOfcCd(JSPUtil.getParameter(request, prefix + "eq_ctrl_ofc_cd", ""));
		setAnEmlSndUsrId(JSPUtil.getParameter(request, prefix + "an_eml_snd_usr_id", ""));
		setC1FaxNoChk(JSPUtil.getParameter(request, prefix + "c1_fax_no_chk", ""));
		setPkupNtcTpCd(JSPUtil.getParameter(request, prefix + "pkup_ntc_tp_cd", ""));
		setC1FaxNtcSndId(JSPUtil.getParameter(request, prefix + "c1_fax_ntc_snd_id", ""));
		setTrspSoOfcCtyCd(JSPUtil.getParameter(request, prefix + "trsp_so_ofc_cty_cd", ""));
		setC1EmlSndDt(JSPUtil.getParameter(request, prefix + "c1_eml_snd_dt", ""));
		setPkupNoUpldDt(JSPUtil.getParameter(request, prefix + "pkup_no_upld_dt", ""));
		setC2FaxNo(JSPUtil.getParameter(request, prefix + "c2_fax_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setNvoccFileNo(JSPUtil.getParameter(request, prefix + "nvocc_file_no", ""));
		setB2EmlSndUsrId(JSPUtil.getParameter(request, prefix + "b2_eml_snd_usr_id", ""));
		setAnFaxNtcSndId(JSPUtil.getParameter(request, prefix + "an_fax_ntc_snd_id", ""));
		setB2FaxNtcSndRslt(JSPUtil.getParameter(request, prefix + "b2_fax_ntc_snd_rslt", ""));
		setVvdId(JSPUtil.getParameter(request, prefix + "vvd_id", ""));
		setB1EmlSndDt(JSPUtil.getParameter(request, prefix + "b1_eml_snd_dt", ""));
		setCstmsClrCd(JSPUtil.getParameter(request, prefix + "cstms_clr_cd", ""));
		setB2FaxSndDt(JSPUtil.getParameter(request, prefix + "b2_fax_snd_dt", ""));
		setB1FaxNoChk(JSPUtil.getParameter(request, prefix + "b1_fax_no_chk", ""));
		setB2NtcEmlChk(JSPUtil.getParameter(request, prefix + "b2_ntc_eml_chk", ""));
		setSndYn(JSPUtil.getParameter(request, prefix + "snd_yn", ""));
		setRtnYdCd(JSPUtil.getParameter(request, prefix + "rtn_yd_cd", ""));
		setB2EmlNtcSndId(JSPUtil.getParameter(request, prefix + "b2_eml_ntc_snd_id", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setAutoSndResmUsrId(JSPUtil.getParameter(request, prefix + "auto_snd_resm_usr_id", ""));
		setC1FaxSndDt(JSPUtil.getParameter(request, prefix + "c1_fax_snd_dt", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setOverWgtFlg(JSPUtil.getParameter(request, prefix + "over_wgt_flg", ""));
		setC2EmlSndUsrId(JSPUtil.getParameter(request, prefix + "c2_eml_snd_usr_id", ""));
		setEclzOblCpyFlg(JSPUtil.getParameter(request, prefix + "eclz_obl_cpy_flg", ""));
		setAnFaxNo(JSPUtil.getParameter(request, prefix + "an_fax_no", ""));
		setC1NtcEmlChk(JSPUtil.getParameter(request, prefix + "c1_ntc_eml_chk", ""));
		setAnFaxNtcSndRslt(JSPUtil.getParameter(request, prefix + "an_fax_ntc_snd_rslt", ""));
		setMnlFlg(JSPUtil.getParameter(request, prefix + "mnl_flg", ""));
		setC2EmlNtcSndRslt(JSPUtil.getParameter(request, prefix + "c2_eml_ntc_snd_rslt", ""));
		setShowPuFlg(JSPUtil.getParameter(request, prefix + "show_pu_flg", ""));
		setCopPkupYdCd(JSPUtil.getParameter(request, prefix + "cop_pkup_yd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PkupNtcSendListVO[]
	 */
	public PkupNtcSendListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PkupNtcSendListVO[]
	 */
	public PkupNtcSendListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PkupNtcSendListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] anEmlNtcSndRslt = (JSPUtil.getParameter(request, prefix	+ "an_eml_ntc_snd_rslt", length));
			String[] sndStsDesc = (JSPUtil.getParameter(request, prefix	+ "snd_sts_desc", length));
			String[] c1EmlSndUsrId = (JSPUtil.getParameter(request, prefix	+ "c1_eml_snd_usr_id", length));
			String[] b2FaxNoChk = (JSPUtil.getParameter(request, prefix	+ "b2_fax_no_chk", length));
			String[] b1EmlNtcSndId = (JSPUtil.getParameter(request, prefix	+ "b1_eml_ntc_snd_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pkupAvalDt = (JSPUtil.getParameter(request, prefix	+ "pkup_aval_dt", length));
			String[] edi322MvmtCd = (JSPUtil.getParameter(request, prefix	+ "edi_322_mvmt_cd", length));
			String[] mnlFlgShow = (JSPUtil.getParameter(request, prefix	+ "mnl_flg_show", length));
			String[] anEmlSndDt = (JSPUtil.getParameter(request, prefix	+ "an_eml_snd_dt", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] c2FaxNtcSndId = (JSPUtil.getParameter(request, prefix	+ "c2_fax_ntc_snd_id", length));
			String[] pkupNtcFomCd = (JSPUtil.getParameter(request, prefix	+ "pkup_ntc_fom_cd", length));
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] b1FaxNo = (JSPUtil.getParameter(request, prefix	+ "b1_fax_no", length));
			String[] anFaxSndDt = (JSPUtil.getParameter(request, prefix	+ "an_fax_snd_dt", length));
			String[] c1NtcEml = (JSPUtil.getParameter(request, prefix	+ "c1_ntc_eml", length));
			String[] autoSndStopUsrId = (JSPUtil.getParameter(request, prefix	+ "auto_snd_stop_usr_id", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] sndUsrId = (JSPUtil.getParameter(request, prefix	+ "snd_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] pkupNtcSndStsCd = (JSPUtil.getParameter(request, prefix	+ "pkup_ntc_snd_sts_cd", length));
			String[] b1FaxNtcSndRslt = (JSPUtil.getParameter(request, prefix	+ "b1_fax_ntc_snd_rslt", length));
			String[] b1FaxSndDt = (JSPUtil.getParameter(request, prefix	+ "b1_fax_snd_dt", length));
			String[] pkupYdCdFlg = (JSPUtil.getParameter(request, prefix	+ "pkup_yd_cd_flg", length));
			String[] pkupNo = (JSPUtil.getParameter(request, prefix	+ "pkup_no", length));
			String[] c1FaxNtcSndRslt = (JSPUtil.getParameter(request, prefix	+ "c1_fax_ntc_snd_rslt", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] b2EmlNtcSndRslt = (JSPUtil.getParameter(request, prefix	+ "b2_eml_ntc_snd_rslt", length));
			String[] c2FaxNtcSndRslt = (JSPUtil.getParameter(request, prefix	+ "c2_fax_ntc_snd_rslt", length));
			String[] b1EmlNtcSndRslt = (JSPUtil.getParameter(request, prefix	+ "b1_eml_ntc_snd_rslt", length));
			String[] railLodDt = (JSPUtil.getParameter(request, prefix	+ "rail_lod_dt", length));
			String[] autoSndStopDt = (JSPUtil.getParameter(request, prefix	+ "auto_snd_stop_dt", length));
			String[] c2EmlNtcSndId = (JSPUtil.getParameter(request, prefix	+ "c2_eml_ntc_snd_id", length));
			String[] lstFreeDt = (JSPUtil.getParameter(request, prefix	+ "lst_free_dt", length));
			String[] b1FaxSndUsrId = (JSPUtil.getParameter(request, prefix	+ "b1_fax_snd_usr_id", length));
			String[] anEmlNtcSndId = (JSPUtil.getParameter(request, prefix	+ "an_eml_ntc_snd_id", length));
			String[] ibdTrspHubCd = (JSPUtil.getParameter(request, prefix	+ "ibd_trsp_hub_cd", length));
			String[] ntcSeq = (JSPUtil.getParameter(request, prefix	+ "ntc_seq", length));
			String[] autoSndResmDt = (JSPUtil.getParameter(request, prefix	+ "auto_snd_resm_dt", length));
			String[] b2FaxNo = (JSPUtil.getParameter(request, prefix	+ "b2_fax_no", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] faxSndDt = (JSPUtil.getParameter(request, prefix	+ "fax_snd_dt", length));
			String[] cstmsClrFlg = (JSPUtil.getParameter(request, prefix	+ "cstms_clr_flg", length));
			String[] c1EmlNtcSndId = (JSPUtil.getParameter(request, prefix	+ "c1_eml_ntc_snd_id", length));
			String[] anFaxSndUsrId = (JSPUtil.getParameter(request, prefix	+ "an_fax_snd_usr_id", length));
			String[] pkupNoUpldUsrId = (JSPUtil.getParameter(request, prefix	+ "pkup_no_upld_usr_id", length));
			String[] emlSndDt = (JSPUtil.getParameter(request, prefix	+ "eml_snd_dt", length));
			String[] b2EmlSndDt = (JSPUtil.getParameter(request, prefix	+ "b2_eml_snd_dt", length));
			String[] oblCltFlg = (JSPUtil.getParameter(request, prefix	+ "obl_clt_flg", length));
			String[] trspSoSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_so_seq", length));
			String[] b1FaxNtcSndId = (JSPUtil.getParameter(request, prefix	+ "b1_fax_ntc_snd_id", length));
			String[] c2EmlSndDt = (JSPUtil.getParameter(request, prefix	+ "c2_eml_snd_dt", length));
			String[] sndDt = (JSPUtil.getParameter(request, prefix	+ "snd_dt", length));
			String[] b2FaxNtcSndId = (JSPUtil.getParameter(request, prefix	+ "b2_fax_ntc_snd_id", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] anNtcEml = (JSPUtil.getParameter(request, prefix	+ "an_ntc_eml", length));
			String[] pkupYdCd = (JSPUtil.getParameter(request, prefix	+ "pkup_yd_cd", length));
			String[] frtCltFlg = (JSPUtil.getParameter(request, prefix	+ "frt_clt_flg", length));
			String[] c2NtcEmlChk = (JSPUtil.getParameter(request, prefix	+ "c2_ntc_eml_chk", length));
			String[] b1NtcEmlChk = (JSPUtil.getParameter(request, prefix	+ "b1_ntc_eml_chk", length));
			String[] c2FaxSndUsrId = (JSPUtil.getParameter(request, prefix	+ "c2_fax_snd_usr_id", length));
			String[] routGidDesc = (JSPUtil.getParameter(request, prefix	+ "rout_gid_desc", length));
			String[] bkgCustTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cust_tp_cd", length));
			String[] c1EmlNtcSndRslt = (JSPUtil.getParameter(request, prefix	+ "c1_eml_ntc_snd_rslt", length));
			String[] pkupNoUpldVia = (JSPUtil.getParameter(request, prefix	+ "pkup_no_upld_via", length));
			String[] c1FaxSndUsrId = (JSPUtil.getParameter(request, prefix	+ "c1_fax_snd_usr_id", length));
			String[] pkupNtcFomCdShow = (JSPUtil.getParameter(request, prefix	+ "pkup_ntc_fom_cd_show", length));
			String[] c2NtcEml = (JSPUtil.getParameter(request, prefix	+ "c2_ntc_eml", length));
			String[] b1EmlSndUsrId = (JSPUtil.getParameter(request, prefix	+ "b1_eml_snd_usr_id", length));
			String[] dorTrkrWoFlg = (JSPUtil.getParameter(request, prefix	+ "dor_trkr_wo_flg", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] sndProcStsCd = (JSPUtil.getParameter(request, prefix	+ "snd_proc_sts_cd", length));
			String[] c2FaxSndDt = (JSPUtil.getParameter(request, prefix	+ "c2_fax_snd_dt", length));
			String[] c2FaxNoChk = (JSPUtil.getParameter(request, prefix	+ "c2_fax_no_chk", length));
			String[] b2FaxSndUsrId = (JSPUtil.getParameter(request, prefix	+ "b2_fax_snd_usr_id", length));
			String[] anNtcEmlChk = (JSPUtil.getParameter(request, prefix	+ "an_ntc_eml_chk", length));
			String[] c1FaxNo = (JSPUtil.getParameter(request, prefix	+ "c1_fax_no", length));
			String[] pkupNoUpldRailCo = (JSPUtil.getParameter(request, prefix	+ "pkup_no_upld_rail_co", length));
			String[] anFaxNoChk = (JSPUtil.getParameter(request, prefix	+ "an_fax_no_chk", length));
			String[] b1NtcEml = (JSPUtil.getParameter(request, prefix	+ "b1_ntc_eml", length));
			String[] b2NtcEml = (JSPUtil.getParameter(request, prefix	+ "b2_ntc_eml", length));
			String[] eqCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "eq_ctrl_ofc_cd", length));
			String[] anEmlSndUsrId = (JSPUtil.getParameter(request, prefix	+ "an_eml_snd_usr_id", length));
			String[] c1FaxNoChk = (JSPUtil.getParameter(request, prefix	+ "c1_fax_no_chk", length));
			String[] pkupNtcTpCd = (JSPUtil.getParameter(request, prefix	+ "pkup_ntc_tp_cd", length));
			String[] c1FaxNtcSndId = (JSPUtil.getParameter(request, prefix	+ "c1_fax_ntc_snd_id", length));
			String[] trspSoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_ofc_cty_cd", length));
			String[] c1EmlSndDt = (JSPUtil.getParameter(request, prefix	+ "c1_eml_snd_dt", length));
			String[] pkupNoUpldDt = (JSPUtil.getParameter(request, prefix	+ "pkup_no_upld_dt", length));
			String[] c2FaxNo = (JSPUtil.getParameter(request, prefix	+ "c2_fax_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] nvoccFileNo = (JSPUtil.getParameter(request, prefix	+ "nvocc_file_no", length));
			String[] b2EmlSndUsrId = (JSPUtil.getParameter(request, prefix	+ "b2_eml_snd_usr_id", length));
			String[] anFaxNtcSndId = (JSPUtil.getParameter(request, prefix	+ "an_fax_ntc_snd_id", length));
			String[] b2FaxNtcSndRslt = (JSPUtil.getParameter(request, prefix	+ "b2_fax_ntc_snd_rslt", length));
			String[] vvdId = (JSPUtil.getParameter(request, prefix	+ "vvd_id", length));
			String[] b1EmlSndDt = (JSPUtil.getParameter(request, prefix	+ "b1_eml_snd_dt", length));
			String[] cstmsClrCd = (JSPUtil.getParameter(request, prefix	+ "cstms_clr_cd", length));
			String[] b2FaxSndDt = (JSPUtil.getParameter(request, prefix	+ "b2_fax_snd_dt", length));
			String[] b1FaxNoChk = (JSPUtil.getParameter(request, prefix	+ "b1_fax_no_chk", length));
			String[] b2NtcEmlChk = (JSPUtil.getParameter(request, prefix	+ "b2_ntc_eml_chk", length));
			String[] sndYn = (JSPUtil.getParameter(request, prefix	+ "snd_yn", length));
			String[] rtnYdCd = (JSPUtil.getParameter(request, prefix	+ "rtn_yd_cd", length));
			String[] b2EmlNtcSndId = (JSPUtil.getParameter(request, prefix	+ "b2_eml_ntc_snd_id", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] autoSndResmUsrId = (JSPUtil.getParameter(request, prefix	+ "auto_snd_resm_usr_id", length));
			String[] c1FaxSndDt = (JSPUtil.getParameter(request, prefix	+ "c1_fax_snd_dt", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] overWgtFlg = (JSPUtil.getParameter(request, prefix	+ "over_wgt_flg", length));
			String[] c2EmlSndUsrId = (JSPUtil.getParameter(request, prefix	+ "c2_eml_snd_usr_id", length));
			String[] eclzOblCpyFlg = (JSPUtil.getParameter(request, prefix	+ "eclz_obl_cpy_flg", length));
			String[] anFaxNo = (JSPUtil.getParameter(request, prefix	+ "an_fax_no", length));
			String[] c1NtcEmlChk = (JSPUtil.getParameter(request, prefix	+ "c1_ntc_eml_chk", length));
			String[] anFaxNtcSndRslt = (JSPUtil.getParameter(request, prefix	+ "an_fax_ntc_snd_rslt", length));
			String[] mnlFlg = (JSPUtil.getParameter(request, prefix	+ "mnl_flg", length));
			String[] c2EmlNtcSndRslt = (JSPUtil.getParameter(request, prefix	+ "c2_eml_ntc_snd_rslt", length));
			String[] showPuFlg = (JSPUtil.getParameter(request, prefix	+ "show_pu_flg", length));
			String[] copPkupYdCd = (JSPUtil.getParameter(request, prefix	+ "cop_pkup_yd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new PkupNtcSendListVO();
				if (anEmlNtcSndRslt[i] != null)
					model.setAnEmlNtcSndRslt(anEmlNtcSndRslt[i]);
				if (sndStsDesc[i] != null)
					model.setSndStsDesc(sndStsDesc[i]);
				if (c1EmlSndUsrId[i] != null)
					model.setC1EmlSndUsrId(c1EmlSndUsrId[i]);
				if (b2FaxNoChk[i] != null)
					model.setB2FaxNoChk(b2FaxNoChk[i]);
				if (b1EmlNtcSndId[i] != null)
					model.setB1EmlNtcSndId(b1EmlNtcSndId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pkupAvalDt[i] != null)
					model.setPkupAvalDt(pkupAvalDt[i]);
				if (edi322MvmtCd[i] != null)
					model.setEdi322MvmtCd(edi322MvmtCd[i]);
				if (mnlFlgShow[i] != null)
					model.setMnlFlgShow(mnlFlgShow[i]);
				if (anEmlSndDt[i] != null)
					model.setAnEmlSndDt(anEmlSndDt[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (c2FaxNtcSndId[i] != null)
					model.setC2FaxNtcSndId(c2FaxNtcSndId[i]);
				if (pkupNtcFomCd[i] != null)
					model.setPkupNtcFomCd(pkupNtcFomCd[i]);
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (b1FaxNo[i] != null)
					model.setB1FaxNo(b1FaxNo[i]);
				if (anFaxSndDt[i] != null)
					model.setAnFaxSndDt(anFaxSndDt[i]);
				if (c1NtcEml[i] != null)
					model.setC1NtcEml(c1NtcEml[i]);
				if (autoSndStopUsrId[i] != null)
					model.setAutoSndStopUsrId(autoSndStopUsrId[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (sndUsrId[i] != null)
					model.setSndUsrId(sndUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (pkupNtcSndStsCd[i] != null)
					model.setPkupNtcSndStsCd(pkupNtcSndStsCd[i]);
				if (b1FaxNtcSndRslt[i] != null)
					model.setB1FaxNtcSndRslt(b1FaxNtcSndRslt[i]);
				if (b1FaxSndDt[i] != null)
					model.setB1FaxSndDt(b1FaxSndDt[i]);
				if (pkupYdCdFlg[i] != null)
					model.setPkupYdCdFlg(pkupYdCdFlg[i]);
				if (pkupNo[i] != null)
					model.setPkupNo(pkupNo[i]);
				if (c1FaxNtcSndRslt[i] != null)
					model.setC1FaxNtcSndRslt(c1FaxNtcSndRslt[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (b2EmlNtcSndRslt[i] != null)
					model.setB2EmlNtcSndRslt(b2EmlNtcSndRslt[i]);
				if (c2FaxNtcSndRslt[i] != null)
					model.setC2FaxNtcSndRslt(c2FaxNtcSndRslt[i]);
				if (b1EmlNtcSndRslt[i] != null)
					model.setB1EmlNtcSndRslt(b1EmlNtcSndRslt[i]);
				if (railLodDt[i] != null)
					model.setRailLodDt(railLodDt[i]);
				if (autoSndStopDt[i] != null)
					model.setAutoSndStopDt(autoSndStopDt[i]);
				if (c2EmlNtcSndId[i] != null)
					model.setC2EmlNtcSndId(c2EmlNtcSndId[i]);
				if (lstFreeDt[i] != null)
					model.setLstFreeDt(lstFreeDt[i]);
				if (b1FaxSndUsrId[i] != null)
					model.setB1FaxSndUsrId(b1FaxSndUsrId[i]);
				if (anEmlNtcSndId[i] != null)
					model.setAnEmlNtcSndId(anEmlNtcSndId[i]);
				if (ibdTrspHubCd[i] != null)
					model.setIbdTrspHubCd(ibdTrspHubCd[i]);
				if (ntcSeq[i] != null)
					model.setNtcSeq(ntcSeq[i]);
				if (autoSndResmDt[i] != null)
					model.setAutoSndResmDt(autoSndResmDt[i]);
				if (b2FaxNo[i] != null)
					model.setB2FaxNo(b2FaxNo[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (faxSndDt[i] != null)
					model.setFaxSndDt(faxSndDt[i]);
				if (cstmsClrFlg[i] != null)
					model.setCstmsClrFlg(cstmsClrFlg[i]);
				if (c1EmlNtcSndId[i] != null)
					model.setC1EmlNtcSndId(c1EmlNtcSndId[i]);
				if (anFaxSndUsrId[i] != null)
					model.setAnFaxSndUsrId(anFaxSndUsrId[i]);
				if (pkupNoUpldUsrId[i] != null)
					model.setPkupNoUpldUsrId(pkupNoUpldUsrId[i]);
				if (emlSndDt[i] != null)
					model.setEmlSndDt(emlSndDt[i]);
				if (b2EmlSndDt[i] != null)
					model.setB2EmlSndDt(b2EmlSndDt[i]);
				if (oblCltFlg[i] != null)
					model.setOblCltFlg(oblCltFlg[i]);
				if (trspSoSeq[i] != null)
					model.setTrspSoSeq(trspSoSeq[i]);
				if (b1FaxNtcSndId[i] != null)
					model.setB1FaxNtcSndId(b1FaxNtcSndId[i]);
				if (c2EmlSndDt[i] != null)
					model.setC2EmlSndDt(c2EmlSndDt[i]);
				if (sndDt[i] != null)
					model.setSndDt(sndDt[i]);
				if (b2FaxNtcSndId[i] != null)
					model.setB2FaxNtcSndId(b2FaxNtcSndId[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (anNtcEml[i] != null)
					model.setAnNtcEml(anNtcEml[i]);
				if (pkupYdCd[i] != null)
					model.setPkupYdCd(pkupYdCd[i]);
				if (frtCltFlg[i] != null)
					model.setFrtCltFlg(frtCltFlg[i]);
				if (c2NtcEmlChk[i] != null)
					model.setC2NtcEmlChk(c2NtcEmlChk[i]);
				if (b1NtcEmlChk[i] != null)
					model.setB1NtcEmlChk(b1NtcEmlChk[i]);
				if (c2FaxSndUsrId[i] != null)
					model.setC2FaxSndUsrId(c2FaxSndUsrId[i]);
				if (routGidDesc[i] != null)
					model.setRoutGidDesc(routGidDesc[i]);
				if (bkgCustTpCd[i] != null)
					model.setBkgCustTpCd(bkgCustTpCd[i]);
				if (c1EmlNtcSndRslt[i] != null)
					model.setC1EmlNtcSndRslt(c1EmlNtcSndRslt[i]);
				if (pkupNoUpldVia[i] != null)
					model.setPkupNoUpldVia(pkupNoUpldVia[i]);
				if (c1FaxSndUsrId[i] != null)
					model.setC1FaxSndUsrId(c1FaxSndUsrId[i]);
				if (pkupNtcFomCdShow[i] != null)
					model.setPkupNtcFomCdShow(pkupNtcFomCdShow[i]);
				if (c2NtcEml[i] != null)
					model.setC2NtcEml(c2NtcEml[i]);
				if (b1EmlSndUsrId[i] != null)
					model.setB1EmlSndUsrId(b1EmlSndUsrId[i]);
				if (dorTrkrWoFlg[i] != null)
					model.setDorTrkrWoFlg(dorTrkrWoFlg[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (sndProcStsCd[i] != null)
					model.setSndProcStsCd(sndProcStsCd[i]);
				if (c2FaxSndDt[i] != null)
					model.setC2FaxSndDt(c2FaxSndDt[i]);
				if (c2FaxNoChk[i] != null)
					model.setC2FaxNoChk(c2FaxNoChk[i]);
				if (b2FaxSndUsrId[i] != null)
					model.setB2FaxSndUsrId(b2FaxSndUsrId[i]);
				if (anNtcEmlChk[i] != null)
					model.setAnNtcEmlChk(anNtcEmlChk[i]);
				if (c1FaxNo[i] != null)
					model.setC1FaxNo(c1FaxNo[i]);
				if (pkupNoUpldRailCo[i] != null)
					model.setPkupNoUpldRailCo(pkupNoUpldRailCo[i]);
				if (anFaxNoChk[i] != null)
					model.setAnFaxNoChk(anFaxNoChk[i]);
				if (b1NtcEml[i] != null)
					model.setB1NtcEml(b1NtcEml[i]);
				if (b2NtcEml[i] != null)
					model.setB2NtcEml(b2NtcEml[i]);
				if (eqCtrlOfcCd[i] != null)
					model.setEqCtrlOfcCd(eqCtrlOfcCd[i]);
				if (anEmlSndUsrId[i] != null)
					model.setAnEmlSndUsrId(anEmlSndUsrId[i]);
				if (c1FaxNoChk[i] != null)
					model.setC1FaxNoChk(c1FaxNoChk[i]);
				if (pkupNtcTpCd[i] != null)
					model.setPkupNtcTpCd(pkupNtcTpCd[i]);
				if (c1FaxNtcSndId[i] != null)
					model.setC1FaxNtcSndId(c1FaxNtcSndId[i]);
				if (trspSoOfcCtyCd[i] != null)
					model.setTrspSoOfcCtyCd(trspSoOfcCtyCd[i]);
				if (c1EmlSndDt[i] != null)
					model.setC1EmlSndDt(c1EmlSndDt[i]);
				if (pkupNoUpldDt[i] != null)
					model.setPkupNoUpldDt(pkupNoUpldDt[i]);
				if (c2FaxNo[i] != null)
					model.setC2FaxNo(c2FaxNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (nvoccFileNo[i] != null)
					model.setNvoccFileNo(nvoccFileNo[i]);
				if (b2EmlSndUsrId[i] != null)
					model.setB2EmlSndUsrId(b2EmlSndUsrId[i]);
				if (anFaxNtcSndId[i] != null)
					model.setAnFaxNtcSndId(anFaxNtcSndId[i]);
				if (b2FaxNtcSndRslt[i] != null)
					model.setB2FaxNtcSndRslt(b2FaxNtcSndRslt[i]);
				if (vvdId[i] != null)
					model.setVvdId(vvdId[i]);
				if (b1EmlSndDt[i] != null)
					model.setB1EmlSndDt(b1EmlSndDt[i]);
				if (cstmsClrCd[i] != null)
					model.setCstmsClrCd(cstmsClrCd[i]);
				if (b2FaxSndDt[i] != null)
					model.setB2FaxSndDt(b2FaxSndDt[i]);
				if (b1FaxNoChk[i] != null)
					model.setB1FaxNoChk(b1FaxNoChk[i]);
				if (b2NtcEmlChk[i] != null)
					model.setB2NtcEmlChk(b2NtcEmlChk[i]);
				if (sndYn[i] != null)
					model.setSndYn(sndYn[i]);
				if (rtnYdCd[i] != null)
					model.setRtnYdCd(rtnYdCd[i]);
				if (b2EmlNtcSndId[i] != null)
					model.setB2EmlNtcSndId(b2EmlNtcSndId[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (autoSndResmUsrId[i] != null)
					model.setAutoSndResmUsrId(autoSndResmUsrId[i]);
				if (c1FaxSndDt[i] != null)
					model.setC1FaxSndDt(c1FaxSndDt[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (overWgtFlg[i] != null)
					model.setOverWgtFlg(overWgtFlg[i]);
				if (c2EmlSndUsrId[i] != null)
					model.setC2EmlSndUsrId(c2EmlSndUsrId[i]);
				if (eclzOblCpyFlg[i] != null)
					model.setEclzOblCpyFlg(eclzOblCpyFlg[i]);
				if (anFaxNo[i] != null)
					model.setAnFaxNo(anFaxNo[i]);
				if (c1NtcEmlChk[i] != null)
					model.setC1NtcEmlChk(c1NtcEmlChk[i]);
				if (anFaxNtcSndRslt[i] != null)
					model.setAnFaxNtcSndRslt(anFaxNtcSndRslt[i]);
				if (mnlFlg[i] != null)
					model.setMnlFlg(mnlFlg[i]);
				if (c2EmlNtcSndRslt[i] != null)
					model.setC2EmlNtcSndRslt(c2EmlNtcSndRslt[i]);
				if (showPuFlg[i] != null)
					model.setShowPuFlg(showPuFlg[i]);
				if (copPkupYdCd[i] != null)
					model.setCopPkupYdCd(copPkupYdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPkupNtcSendListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PkupNtcSendListVO[]
	 */
	public PkupNtcSendListVO[] getPkupNtcSendListVOs(){
		PkupNtcSendListVO[] vos = (PkupNtcSendListVO[])models.toArray(new PkupNtcSendListVO[models.size()]);
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
		this.anEmlNtcSndRslt = this.anEmlNtcSndRslt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndStsDesc = this.sndStsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.c1EmlSndUsrId = this.c1EmlSndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.b2FaxNoChk = this.b2FaxNoChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.b1EmlNtcSndId = this.b1EmlNtcSndId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupAvalDt = this.pkupAvalDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edi322MvmtCd = this.edi322MvmtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlFlgShow = this.mnlFlgShow .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anEmlSndDt = this.anEmlSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.c2FaxNtcSndId = this.c2FaxNtcSndId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupNtcFomCd = this.pkupNtcFomCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.b1FaxNo = this.b1FaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anFaxSndDt = this.anFaxSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.c1NtcEml = this.c1NtcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoSndStopUsrId = this.autoSndStopUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndUsrId = this.sndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupNtcSndStsCd = this.pkupNtcSndStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.b1FaxNtcSndRslt = this.b1FaxNtcSndRslt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.b1FaxSndDt = this.b1FaxSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupYdCdFlg = this.pkupYdCdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupNo = this.pkupNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.c1FaxNtcSndRslt = this.c1FaxNtcSndRslt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.b2EmlNtcSndRslt = this.b2EmlNtcSndRslt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.c2FaxNtcSndRslt = this.c2FaxNtcSndRslt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.b1EmlNtcSndRslt = this.b1EmlNtcSndRslt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railLodDt = this.railLodDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoSndStopDt = this.autoSndStopDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.c2EmlNtcSndId = this.c2EmlNtcSndId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstFreeDt = this.lstFreeDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.b1FaxSndUsrId = this.b1FaxSndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anEmlNtcSndId = this.anEmlNtcSndId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdTrspHubCd = this.ibdTrspHubCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcSeq = this.ntcSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoSndResmDt = this.autoSndResmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.b2FaxNo = this.b2FaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndDt = this.faxSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsClrFlg = this.cstmsClrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.c1EmlNtcSndId = this.c1EmlNtcSndId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anFaxSndUsrId = this.anFaxSndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupNoUpldUsrId = this.pkupNoUpldUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndDt = this.emlSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.b2EmlSndDt = this.b2EmlSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblCltFlg = this.oblCltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoSeq = this.trspSoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.b1FaxNtcSndId = this.b1FaxNtcSndId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.c2EmlSndDt = this.c2EmlSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDt = this.sndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.b2FaxNtcSndId = this.b2FaxNtcSndId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anNtcEml = this.anNtcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupYdCd = this.pkupYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtCltFlg = this.frtCltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.c2NtcEmlChk = this.c2NtcEmlChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.b1NtcEmlChk = this.b1NtcEmlChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.c2FaxSndUsrId = this.c2FaxSndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routGidDesc = this.routGidDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustTpCd = this.bkgCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.c1EmlNtcSndRslt = this.c1EmlNtcSndRslt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupNoUpldVia = this.pkupNoUpldVia .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.c1FaxSndUsrId = this.c1FaxSndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupNtcFomCdShow = this.pkupNtcFomCdShow .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.c2NtcEml = this.c2NtcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.b1EmlSndUsrId = this.b1EmlSndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorTrkrWoFlg = this.dorTrkrWoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndProcStsCd = this.sndProcStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.c2FaxSndDt = this.c2FaxSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.c2FaxNoChk = this.c2FaxNoChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.b2FaxSndUsrId = this.b2FaxSndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anNtcEmlChk = this.anNtcEmlChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.c1FaxNo = this.c1FaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupNoUpldRailCo = this.pkupNoUpldRailCo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anFaxNoChk = this.anFaxNoChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.b1NtcEml = this.b1NtcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.b2NtcEml = this.b2NtcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCtrlOfcCd = this.eqCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anEmlSndUsrId = this.anEmlSndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.c1FaxNoChk = this.c1FaxNoChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupNtcTpCd = this.pkupNtcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.c1FaxNtcSndId = this.c1FaxNtcSndId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoOfcCtyCd = this.trspSoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.c1EmlSndDt = this.c1EmlSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupNoUpldDt = this.pkupNoUpldDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.c2FaxNo = this.c2FaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nvoccFileNo = this.nvoccFileNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.b2EmlSndUsrId = this.b2EmlSndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anFaxNtcSndId = this.anFaxNtcSndId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.b2FaxNtcSndRslt = this.b2FaxNtcSndRslt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdId = this.vvdId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.b1EmlSndDt = this.b1EmlSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsClrCd = this.cstmsClrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.b2FaxSndDt = this.b2FaxSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.b1FaxNoChk = this.b1FaxNoChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.b2NtcEmlChk = this.b2NtcEmlChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndYn = this.sndYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnYdCd = this.rtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.b2EmlNtcSndId = this.b2EmlNtcSndId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoSndResmUsrId = this.autoSndResmUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.c1FaxSndDt = this.c1FaxSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overWgtFlg = this.overWgtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.c2EmlSndUsrId = this.c2EmlSndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eclzOblCpyFlg = this.eclzOblCpyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anFaxNo = this.anFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.c1NtcEmlChk = this.c1NtcEmlChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anFaxNtcSndRslt = this.anFaxNtcSndRslt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlFlg = this.mnlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.c2EmlNtcSndRslt = this.c2EmlNtcSndRslt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.showPuFlg = this.showPuFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copPkupYdCd = this.copPkupYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
