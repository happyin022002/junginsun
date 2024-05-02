/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchStatusByTPBVO.java
*@FileTitle : SearchStatusByTPBVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.09
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2010.04.09 최 선 
* 1.0 Creation
* 
* History
* 2014.02.18 박다은 [CHM-201428813] Status by TPB - Multi. BKG & EQ No. 기능 추가
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.vo;

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
 * @author 최 선
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class SearchStatusByTPBVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<SearchStatusByTPBVO> models = new ArrayList<SearchStatusByTPBVO>();

    /* Column Info */
    private String sOverdue = null;

    /* Column Info */
    private String sBkgNoAll = null;

    /* Column Info */
    private String sBlNoTp = null;

    /* Column Info */
    private String ifOfcCd = null;

    /* Column Info */
    private String ifDt = null;

    /* Column Info */
    private String sN3ptySrcSubSysCdCheck = null;

    /* Column Info */
    private String sBlNoChk = null;

    /* Column Info */
    private String sUserOfcCd = null;

    /* Column Info */
    private String n3ptyBilTpNm = null;

    /* Column Info */
    private String pagerows = null;

    /* Column Info */
    private String sOtsAmtFrom = null;

    /* Column Info */
    private String soIfSeq = null;

    /* Column Info */
    private String edate = null;

    /* Column Info */
    private String blNoAll = null;

    /* Column Info */
    private String sOfficeLevel = null;

    /* Column Info */
    private String trdPartyName = null;

    /* Column Info */
    private String sVndrCustDivCd = null;

    /* Column Info */
    private String n3ptyStlTpCd = null;

    /* Column Info */
    private String sOtsStsCdDetailClose = null;

    /* Column Info */
    private String n3ptyNoDpSeq = null;

    /* Column Info */
    private String sCreUsrId = null;

    /* Column Info */
    private String otsStsNm = null;

    /* Column Info */
    private String sFmCltCngOfcN3ptyNo = null;

    /* Column Info */
    private String sTrdPartyCode = null;

    /* Column Info */
    private String sIfRhqCd = null;

    /* Column Info */
    private String sCsrNo = null;

    /* Column Info */
    private String sHVndrCustDivCd = null;

    /* Column Info */
    private String sOtsStsCdDetail = null;

    /* Column Info */
    private String otsStsCd = null;

    /* Column Info */
    private String sOtsAmtTo = null;

    /* Column Info */
    private String sVslCd = null;

    /* Column Info */
    private String sBkgNo = null;

    /* Column Info */
    private String cltAmt = null;

    /* Column Info */
    private String vndrCustDivCd = null;

    /* Column Info */
    private String balAmt = null;

    /* Column Info */
    private String overdue = null;

    /* Column Info */
    private String sN3ptyInvNo = null;

    /* Column Info */
    private String n3ptyNo = null;

    /* Column Info */
    private String sEdate = null;

    /* Column Info */
    private String bkgNoAll = null;

    /* Column Info */
    private String sN3ptyNo = null;

    /* Column Info */
    private String sStlToCltCngOfcCd = null;

    /* Column Info */
    private String sVndrSeq = null;

    /* Column Info */
    private String sCfmDtPrev = null;

    /* Column Info */
    private String sIfOfcCd = null;

    /* Column Info */
    private String sOfcCdForRhq = null;

    /* Column Info */
    private String sRhqCdForRhq = null;

    /* Column Info */
    private String sHOtsStsCd = null;

    /* Column Info */
    private String sHN3ptyInvNo = null;

    /* Column Info */
    private String privCd = null;

    /* Column Info */
    private String sN3ptyNoSearch = null;

    /* Column Info */
    private String n3ptySrcNo = null;

    /* Column Info */
    private String sEdnTpCd = null;

    /* Column Info */
    private String sCurrCdTp = null;

    /* Column Info */
    private String sSkdVoyNo = null;

    /* Column Info */
    private String trdPartyCode = null;

    /* Column Info */
    private String sCustSeq = null;

    /* Column Info */
    private String sTrdPartyVal = null;

    /* Column Info */
    private String fCmd = null;

    /* Column Info */
    private String invIssDt = null;

    /* Column Info */
    private String n3ptyInvNo = null;

    /* Column Info */
    private String stlToCltCngOfcCd = null;

    /* Column Info */
    private String sBlNo = null;

    /* Column Info */
    private String n3ptyBilTpCd = null;

    /* Column Info */
    private String sState = null;

    /* Column Info */
    private String cltActYn = null;

    /* Column Info */
    private String csrNo = null;

    /* Column Info */
    private String sN3ptySrcNo = null;

    /* Column Info */
    private String cfmDt = null;

    /* Column Info */
    private String sCustCntCd = null;

    /* Column Info */
    private String sBlNoAll = null;

    /* Column Info */
    private String stlAmt = null;

    /* Column Info */
    private String fmCltCngOfcN3ptyNo = null;

    /* Column Info */
    private String vvd = null;

    /* Column Info */
    private String chk = null;

    /* Column Info */
    private String otsAmt = null;

    /* Column Info */
    private String sDaoN3ptyNo = null;

    /* Column Info */
    private String sdate = null;

    /* Column Info */
    private String n3ptySrcSubSysCd = null;

    /* Column Info */
    private String currCd = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String ipage = null;

    /* Column Info */
    private String sCfmDt = null;

    /* Column Info */
    private String sIfCtrlCd = null;

    /* Column Info */
    private String sVndrCntCd = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String eqNo = null;

    /* Column Info */
    private String sN3ptyOfcCd = null;

    /* Column Info */
    private String stlRqstOfcCd = null;

    /* Column Info */
    private String invAmt = null;

    /* Column Info */
    private String ednTpNm = null;

    /* Column Info */
    private String sCfmDtLast = null;

    /* Column Info */
    private String ifUsrId = null;

    /* Column Info */
    private String sOtsStsCd = null;

    /* Column Info */
    private String sSdate = null;

    /* Column Info */
    private String sVvd = null;

    /* Column Info */
    private String sSkdDirCd = null;

    /* Column Info */
    private String sN3ptySrcSubSysCd = null;

    /* Column Info */
    private String sEqNo = null;

    /* Column Info */
    private String sOtsStsCdDetailOpen = null;

    /* Column Info */
    private String sBkgNoSplit = null;

    /* Column Info */
    private String sN3ptyBilTpCd = null;

    /* Column Info */
    private String ofcCd = null;

    /* Column Info */
    private String ifUsrNm = null;

    /* Column Info */
    private String bkgCntrNo = null;

    /* Column Info */
    private String sIfType = null;

    /* Column Info */
    private String trdPartyType = null;

    /* Column Info */
    private String podCd = null;

    /* Column Info */
    private String porCd = null;

    /* Column Info */
    private String polCd = null;

    /* Column Info */
    private String delCd = null;

    /* Column Info */
    private String contractNo = null;

    /* Column Info */
    private String deTermCd = null;

    /* Column Info */
    private String rcvTermCd = null;

    /* Column Info */
    private String contractOfc = null;

    /* Column Info */
    private String vatAmt = null;

    /* Column Info */
    private String addAmt = null;

    /* Column Info */
    private String ddctAmt = null;

    /* Column Info */
    private String sOtsStsCdDetailNon = null;

    /* Column Info */
    private String otsDtlSeq = null;

    /* Column Info */
    private String n3ptyNonCfmRsnCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public SearchStatusByTPBVO() {
    }

    public SearchStatusByTPBVO(String ibflag, String pagerows, String ifUsrNm, String n3ptyNo, String n3ptyNoDpSeq, String n3ptySrcSubSysCd, String n3ptyInvNo, String invIssDt, String n3ptySrcNo, String bkgNoAll, String blNoAll, String vvd, String eqNo, String n3ptyBilTpCd, String trdPartyCode, String trdPartyName, String cltActYn, String otsStsNm, String overdue, String otsAmt, String invAmt, String cltAmt, String stlAmt, String balAmt, String ifUsrId, String ifOfcCd, String n3ptyStlTpCd, String stlRqstOfcCd, String stlToCltCngOfcCd, String fmCltCngOfcN3ptyNo, String ednTpNm, String csrNo, String otsStsCd, String vndrCustDivCd, String currCd, String cfmDt, String soIfSeq, String creDt, String sUserOfcCd, String sCurrCdTp, String sIfRhqCd, String sIfCtrlCd, String sIfOfcCd, String sN3ptySrcSubSysCd, String sN3ptyInvNo, String sOverdue, String sBkgNoAll, String sBlNoAll, String sVvd, String sN3ptySrcNo, String sN3ptyNoSearch, String sEdnTpCd, String sOtsAmtFrom, String sOtsAmtTo, String sCsrNo, String sEqNo, String sFmCltCngOfcN3ptyNo, String sStlToCltCngOfcCd, String sVndrCustDivCd, String sTrdPartyVal, String sOtsStsCd, String sSdate, String sEdate, String sOtsStsCdDetail, String sCreUsrId, String sN3ptySrcSubSysCdCheck, String chk, String n3ptyBilTpNm, String fCmd, String ipage, String sBkgNo, String sBkgNoSplit, String sBlNoChk, String sBlNo, String sBlNoTp, String sVslCd, String sSkdVoyNo, String sSkdDirCd, String sVndrCntCd, String sVndrSeq, String sCustCntCd, String sCustSeq, String sN3ptyOfcCd, String sdate, String edate, String sN3ptyNo, String sDaoN3ptyNo, String sHOtsStsCd, String sTrdPartyCode, String sHVndrCustDivCd, String sHN3ptyInvNo, String sCfmDt, String sCfmDtPrev, String sCfmDtLast, String sOfficeLevel, String sRhqCdForRhq, String sOfcCdForRhq, String sState, String privCd, String sOtsStsCdDetailOpen, String sOtsStsCdDetailClose, String sN3ptyBilTpCd, String ofcCd, String ifDt, String bkgCntrNo, String sIfType, String trdPartyType, String contractNo, String contractOfc, String porCd, String polCd, String podCd, String delCd, String rcvTermCd, String deTermCd, String vatAmt, String addAmt, String ddctAmt, String sOtsStsCdDetailNon, String otsDtlSeq, String n3ptyNonCfmRsnCd) {
        this.sOverdue = sOverdue;
        this.sBkgNoAll = sBkgNoAll;
        this.sBlNoTp = sBlNoTp;
        this.ifOfcCd = ifOfcCd;
        this.sN3ptySrcSubSysCdCheck = sN3ptySrcSubSysCdCheck;
        this.sBlNoChk = sBlNoChk;
        this.sUserOfcCd = sUserOfcCd;
        this.n3ptyBilTpNm = n3ptyBilTpNm;
        this.pagerows = pagerows;
        this.sOtsAmtFrom = sOtsAmtFrom;
        this.soIfSeq = soIfSeq;
        this.edate = edate;
        this.blNoAll = blNoAll;
        this.sOfficeLevel = sOfficeLevel;
        this.trdPartyName = trdPartyName;
        this.sVndrCustDivCd = sVndrCustDivCd;
        this.n3ptyStlTpCd = n3ptyStlTpCd;
        this.sOtsStsCdDetailClose = sOtsStsCdDetailClose;
        this.n3ptyNoDpSeq = n3ptyNoDpSeq;
        this.sCreUsrId = sCreUsrId;
        this.otsStsNm = otsStsNm;
        this.sFmCltCngOfcN3ptyNo = sFmCltCngOfcN3ptyNo;
        this.sTrdPartyCode = sTrdPartyCode;
        this.sIfRhqCd = sIfRhqCd;
        this.sCsrNo = sCsrNo;
        this.sHVndrCustDivCd = sHVndrCustDivCd;
        this.sOtsStsCdDetail = sOtsStsCdDetail;
        this.otsStsCd = otsStsCd;
        this.sOtsAmtTo = sOtsAmtTo;
        this.sVslCd = sVslCd;
        this.sBkgNo = sBkgNo;
        this.cltAmt = cltAmt;
        this.vndrCustDivCd = vndrCustDivCd;
        this.balAmt = balAmt;
        this.overdue = overdue;
        this.sN3ptyInvNo = sN3ptyInvNo;
        this.n3ptyNo = n3ptyNo;
        this.sEdate = sEdate;
        this.bkgNoAll = bkgNoAll;
        this.sN3ptyNo = sN3ptyNo;
        this.sStlToCltCngOfcCd = sStlToCltCngOfcCd;
        this.sVndrSeq = sVndrSeq;
        this.sCfmDtPrev = sCfmDtPrev;
        this.sIfOfcCd = sIfOfcCd;
        this.sOfcCdForRhq = sOfcCdForRhq;
        this.sRhqCdForRhq = sRhqCdForRhq;
        this.sHOtsStsCd = sHOtsStsCd;
        this.sHN3ptyInvNo = sHN3ptyInvNo;
        this.privCd = privCd;
        this.sN3ptyNoSearch = sN3ptyNoSearch;
        this.n3ptySrcNo = n3ptySrcNo;
        this.sEdnTpCd = sEdnTpCd;
        this.sCurrCdTp = sCurrCdTp;
        this.sSkdVoyNo = sSkdVoyNo;
        this.trdPartyCode = trdPartyCode;
        this.sCustSeq = sCustSeq;
        this.sTrdPartyVal = sTrdPartyVal;
        this.fCmd = fCmd;
        this.invIssDt = invIssDt;
        this.n3ptyInvNo = n3ptyInvNo;
        this.stlToCltCngOfcCd = stlToCltCngOfcCd;
        this.sBlNo = sBlNo;
        this.n3ptyBilTpCd = n3ptyBilTpCd;
        this.sState = sState;
        this.cltActYn = cltActYn;
        this.csrNo = csrNo;
        this.sN3ptySrcNo = sN3ptySrcNo;
        this.cfmDt = cfmDt;
        this.sCustCntCd = sCustCntCd;
        this.sBlNoAll = sBlNoAll;
        this.stlAmt = stlAmt;
        this.fmCltCngOfcN3ptyNo = fmCltCngOfcN3ptyNo;
        this.vvd = vvd;
        this.chk = chk;
        this.otsAmt = otsAmt;
        this.sDaoN3ptyNo = sDaoN3ptyNo;
        this.sdate = sdate;
        this.n3ptySrcSubSysCd = n3ptySrcSubSysCd;
        this.currCd = currCd;
        this.creDt = creDt;
        this.ipage = ipage;
        this.sCfmDt = sCfmDt;
        this.sIfCtrlCd = sIfCtrlCd;
        this.sVndrCntCd = sVndrCntCd;
        this.ibflag = ibflag;
        this.eqNo = eqNo;
        this.sN3ptyOfcCd = sN3ptyOfcCd;
        this.stlRqstOfcCd = stlRqstOfcCd;
        this.invAmt = invAmt;
        this.ednTpNm = ednTpNm;
        this.sCfmDtLast = sCfmDtLast;
        this.ifUsrId = ifUsrId;
        this.ifDt = ifDt;
        this.sOtsStsCd = sOtsStsCd;
        this.sSdate = sSdate;
        this.sVvd = sVvd;
        this.sSkdDirCd = sSkdDirCd;
        this.sN3ptySrcSubSysCd = sN3ptySrcSubSysCd;
        this.sEqNo = sEqNo;
        this.sOtsStsCdDetailOpen = sOtsStsCdDetailOpen;
        this.sBkgNoSplit = sBkgNoSplit;
        this.sN3ptyBilTpCd = sN3ptyBilTpCd;
        this.ofcCd = ofcCd;
        this.ifUsrNm = ifUsrNm;
        this.bkgCntrNo = bkgCntrNo;
        this.sIfType = sIfType;
        this.trdPartyType = trdPartyType;
        this.podCd = podCd;
        this.porCd = porCd;
        this.deTermCd = deTermCd;
        this.polCd = polCd;
        this.delCd = delCd;
        this.contractNo = contractNo;
        this.rcvTermCd = rcvTermCd;
        this.contractOfc = contractOfc;
        this.vatAmt = vatAmt;
        this.addAmt = addAmt;
        this.ddctAmt = ddctAmt;
        this.sOtsStsCdDetailNon = sOtsStsCdDetailNon;
        this.otsDtlSeq = otsDtlSeq;
        this.n3ptyNonCfmRsnCd = n3ptyNonCfmRsnCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("s_overdue", getSOverdue());
        this.hashColumns.put("s_bkg_no_all", getSBkgNoAll());
        this.hashColumns.put("s_bl_no_tp", getSBlNoTp());
        this.hashColumns.put("if_ofc_cd", getIfOfcCd());
        this.hashColumns.put("s_n3pty_src_sub_sys_cd_check", getSN3ptySrcSubSysCdCheck());
        this.hashColumns.put("s_bl_no_chk", getSBlNoChk());
        this.hashColumns.put("s_user_ofc_cd", getSUserOfcCd());
        this.hashColumns.put("n3pty_bil_tp_nm", getN3ptyBilTpNm());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("s_ots_amt_from", getSOtsAmtFrom());
        this.hashColumns.put("so_if_seq", getSoIfSeq());
        this.hashColumns.put("edate", getEdate());
        this.hashColumns.put("bl_no_all", getBlNoAll());
        this.hashColumns.put("s_office_level", getSOfficeLevel());
        this.hashColumns.put("trd_party_name", getTrdPartyName());
        this.hashColumns.put("s_vndr_cust_div_cd", getSVndrCustDivCd());
        this.hashColumns.put("n3pty_stl_tp_cd", getN3ptyStlTpCd());
        this.hashColumns.put("s_ots_sts_cd_detail_close", getSOtsStsCdDetailClose());
        this.hashColumns.put("n3pty_no_dp_seq", getN3ptyNoDpSeq());
        this.hashColumns.put("s_cre_usr_id", getSCreUsrId());
        this.hashColumns.put("ots_sts_nm", getOtsStsNm());
        this.hashColumns.put("s_fm_clt_cng_ofc_n3pty_no", getSFmCltCngOfcN3ptyNo());
        this.hashColumns.put("s_trd_party_code", getSTrdPartyCode());
        this.hashColumns.put("s_if_rhq_cd", getSIfRhqCd());
        this.hashColumns.put("s_csr_no", getSCsrNo());
        this.hashColumns.put("s_h_vndr_cust_div_cd", getSHVndrCustDivCd());
        this.hashColumns.put("s_ots_sts_cd_detail", getSOtsStsCdDetail());
        this.hashColumns.put("ots_sts_cd", getOtsStsCd());
        this.hashColumns.put("s_ots_amt_to", getSOtsAmtTo());
        this.hashColumns.put("s_vsl_cd", getSVslCd());
        this.hashColumns.put("s_bkg_no", getSBkgNo());
        this.hashColumns.put("clt_amt", getCltAmt());
        this.hashColumns.put("vndr_cust_div_cd", getVndrCustDivCd());
        this.hashColumns.put("bal_amt", getBalAmt());
        this.hashColumns.put("overdue", getOverdue());
        this.hashColumns.put("s_n3pty_inv_no", getSN3ptyInvNo());
        this.hashColumns.put("n3pty_no", getN3ptyNo());
        this.hashColumns.put("s_edate", getSEdate());
        this.hashColumns.put("bkg_no_all", getBkgNoAll());
        this.hashColumns.put("s_n3pty_no", getSN3ptyNo());
        this.hashColumns.put("s_stl_to_clt_cng_ofc_cd", getSStlToCltCngOfcCd());
        this.hashColumns.put("s_vndr_seq", getSVndrSeq());
        this.hashColumns.put("s_cfm_dt_prev", getSCfmDtPrev());
        this.hashColumns.put("s_if_ofc_cd", getSIfOfcCd());
        this.hashColumns.put("s_ofc_cd_for_rhq", getSOfcCdForRhq());
        this.hashColumns.put("s_rhq_cd_for_rhq", getSRhqCdForRhq());
        this.hashColumns.put("s_h_ots_sts_cd", getSHOtsStsCd());
        this.hashColumns.put("s_h_n3pty_inv_no", getSHN3ptyInvNo());
        this.hashColumns.put("priv_cd", getPrivCd());
        this.hashColumns.put("s_n3pty_no_search", getSN3ptyNoSearch());
        this.hashColumns.put("n3pty_src_no", getN3ptySrcNo());
        this.hashColumns.put("s_edn_tp_cd", getSEdnTpCd());
        this.hashColumns.put("s_curr_cd_tp", getSCurrCdTp());
        this.hashColumns.put("s_skd_voy_no", getSSkdVoyNo());
        this.hashColumns.put("trd_party_code", getTrdPartyCode());
        this.hashColumns.put("s_cust_seq", getSCustSeq());
        this.hashColumns.put("s_trd_party_val", getSTrdPartyVal());
        this.hashColumns.put("f_cmd", getFCmd());
        this.hashColumns.put("inv_iss_dt", getInvIssDt());
        this.hashColumns.put("n3pty_inv_no", getN3ptyInvNo());
        this.hashColumns.put("stl_to_clt_cng_ofc_cd", getStlToCltCngOfcCd());
        this.hashColumns.put("s_bl_no", getSBlNo());
        this.hashColumns.put("n3pty_bil_tp_cd", getN3ptyBilTpCd());
        this.hashColumns.put("s_state", getSState());
        this.hashColumns.put("clt_act_yn", getCltActYn());
        this.hashColumns.put("csr_no", getCsrNo());
        this.hashColumns.put("s_n3pty_src_no", getSN3ptySrcNo());
        this.hashColumns.put("cfm_dt", getCfmDt());
        this.hashColumns.put("s_cust_cnt_cd", getSCustCntCd());
        this.hashColumns.put("s_bl_no_all", getSBlNoAll());
        this.hashColumns.put("stl_amt", getStlAmt());
        this.hashColumns.put("fm_clt_cng_ofc_n3pty_no", getFmCltCngOfcN3ptyNo());
        this.hashColumns.put("vvd", getVvd());
        this.hashColumns.put("chk", getChk());
        this.hashColumns.put("ots_amt", getOtsAmt());
        this.hashColumns.put("s_dao_n3pty_no", getSDaoN3ptyNo());
        this.hashColumns.put("sdate", getSdate());
        this.hashColumns.put("n3pty_src_sub_sys_cd", getN3ptySrcSubSysCd());
        this.hashColumns.put("curr_cd", getCurrCd());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("ipage", getIpage());
        this.hashColumns.put("s_cfm_dt", getSCfmDt());
        this.hashColumns.put("s_if_ctrl_cd", getSIfCtrlCd());
        this.hashColumns.put("s_vndr_cnt_cd", getSVndrCntCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("eq_no", getEqNo());
        this.hashColumns.put("s_n3pty_ofc_cd", getSN3ptyOfcCd());
        this.hashColumns.put("stl_rqst_ofc_cd", getStlRqstOfcCd());
        this.hashColumns.put("inv_amt", getInvAmt());
        this.hashColumns.put("edn_tp_nm", getEdnTpNm());
        this.hashColumns.put("s_cfm_dt_last", getSCfmDtLast());
        this.hashColumns.put("if_usr_id", getIfUsrId());
        this.hashColumns.put("if_dt", getIfDt());
        this.hashColumns.put("s_ots_sts_cd", getSOtsStsCd());
        this.hashColumns.put("s_sdate", getSSdate());
        this.hashColumns.put("s_vvd", getSVvd());
        this.hashColumns.put("s_skd_dir_cd", getSSkdDirCd());
        this.hashColumns.put("s_n3pty_src_sub_sys_cd", getSN3ptySrcSubSysCd());
        this.hashColumns.put("s_eq_no", getSEqNo());
        this.hashColumns.put("s_ots_sts_cd_detail_open", getSOtsStsCdDetailOpen());
        this.hashColumns.put("s_bkg_no_split", getSBkgNoSplit());
        this.hashColumns.put("s_n3pty_bil_tp_cd", getSN3ptyBilTpCd());
        this.hashColumns.put("ofc_cd", getOfcCd());
        this.hashColumns.put("if_usr_nm", getIfUsrNm());
        this.hashColumns.put("bkg_cntr_no", getBkgCntrNo());
        this.hashColumns.put("s_if_type", getSIfType());
        this.hashColumns.put("trd_party_type", getTrdPartyType());
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("por_cd", getPorCd());
        this.hashColumns.put("de_term_cd", getDeTermCd());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("del_cd", getDelCd());
        this.hashColumns.put("contract_no", getContractNo());
        this.hashColumns.put("rcv_term_cd", getRcvTermCd());
        this.hashColumns.put("contract_ofc", getContractOfc());
        this.hashColumns.put("vat_amt", getVatAmt());
        this.hashColumns.put("add_amt", getAddAmt());
        this.hashColumns.put("ddct_amt", getDdctAmt());
        this.hashColumns.put("s_ots_sts_cd_detail_non", getSOtsStsCdDetailNon());
        this.hashColumns.put("ots_dtl_seq", getOtsDtlSeq());
        this.hashColumns.put("n3pty_non_cfm_rsn_cd", getN3ptyNonCfmRsnCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("s_overdue", "sOverdue");
        this.hashFields.put("s_bkg_no_all", "sBkgNoAll");
        this.hashFields.put("s_bl_no_tp", "sBlNoTp");
        this.hashFields.put("if_ofc_cd", "ifOfcCd");
        this.hashFields.put("s_n3pty_src_sub_sys_cd_check", "sN3ptySrcSubSysCdCheck");
        this.hashFields.put("s_bl_no_chk", "sBlNoChk");
        this.hashFields.put("s_user_ofc_cd", "sUserOfcCd");
        this.hashFields.put("n3pty_bil_tp_nm", "n3ptyBilTpNm");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("s_ots_amt_from", "sOtsAmtFrom");
        this.hashFields.put("so_if_seq", "soIfSeq");
        this.hashFields.put("edate", "edate");
        this.hashFields.put("bl_no_all", "blNoAll");
        this.hashFields.put("s_office_level", "sOfficeLevel");
        this.hashFields.put("trd_party_name", "trdPartyName");
        this.hashFields.put("s_vndr_cust_div_cd", "sVndrCustDivCd");
        this.hashFields.put("n3pty_stl_tp_cd", "n3ptyStlTpCd");
        this.hashFields.put("s_ots_sts_cd_detail_close", "sOtsStsCdDetailClose");
        this.hashFields.put("n3pty_no_dp_seq", "n3ptyNoDpSeq");
        this.hashFields.put("s_cre_usr_id", "sCreUsrId");
        this.hashFields.put("ots_sts_nm", "otsStsNm");
        this.hashFields.put("s_fm_clt_cng_ofc_n3pty_no", "sFmCltCngOfcN3ptyNo");
        this.hashFields.put("s_trd_party_code", "sTrdPartyCode");
        this.hashFields.put("s_if_rhq_cd", "sIfRhqCd");
        this.hashFields.put("s_csr_no", "sCsrNo");
        this.hashFields.put("s_h_vndr_cust_div_cd", "sHVndrCustDivCd");
        this.hashFields.put("s_ots_sts_cd_detail", "sOtsStsCdDetail");
        this.hashFields.put("ots_sts_cd", "otsStsCd");
        this.hashFields.put("s_ots_amt_to", "sOtsAmtTo");
        this.hashFields.put("s_vsl_cd", "sVslCd");
        this.hashFields.put("s_bkg_no", "sBkgNo");
        this.hashFields.put("clt_amt", "cltAmt");
        this.hashFields.put("vndr_cust_div_cd", "vndrCustDivCd");
        this.hashFields.put("bal_amt", "balAmt");
        this.hashFields.put("overdue", "overdue");
        this.hashFields.put("s_n3pty_inv_no", "sN3ptyInvNo");
        this.hashFields.put("n3pty_no", "n3ptyNo");
        this.hashFields.put("s_edate", "sEdate");
        this.hashFields.put("bkg_no_all", "bkgNoAll");
        this.hashFields.put("s_n3pty_no", "sN3ptyNo");
        this.hashFields.put("s_stl_to_clt_cng_ofc_cd", "sStlToCltCngOfcCd");
        this.hashFields.put("s_vndr_seq", "sVndrSeq");
        this.hashFields.put("s_cfm_dt_prev", "sCfmDtPrev");
        this.hashFields.put("s_if_ofc_cd", "sIfOfcCd");
        this.hashFields.put("s_ofc_cd_for_rhq", "sOfcCdForRhq");
        this.hashFields.put("s_rhq_cd_for_rhq", "sRhqCdForRhq");
        this.hashFields.put("s_h_ots_sts_cd", "sHOtsStsCd");
        this.hashFields.put("s_h_n3pty_inv_no", "sHN3ptyInvNo");
        this.hashFields.put("priv_cd", "privCd");
        this.hashFields.put("s_n3pty_no_search", "sN3ptyNoSearch");
        this.hashFields.put("n3pty_src_no", "n3ptySrcNo");
        this.hashFields.put("s_edn_tp_cd", "sEdnTpCd");
        this.hashFields.put("s_curr_cd_tp", "sCurrCdTp");
        this.hashFields.put("s_skd_voy_no", "sSkdVoyNo");
        this.hashFields.put("trd_party_code", "trdPartyCode");
        this.hashFields.put("s_cust_seq", "sCustSeq");
        this.hashFields.put("s_trd_party_val", "sTrdPartyVal");
        this.hashFields.put("f_cmd", "fCmd");
        this.hashFields.put("inv_iss_dt", "invIssDt");
        this.hashFields.put("n3pty_inv_no", "n3ptyInvNo");
        this.hashFields.put("stl_to_clt_cng_ofc_cd", "stlToCltCngOfcCd");
        this.hashFields.put("s_bl_no", "sBlNo");
        this.hashFields.put("n3pty_bil_tp_cd", "n3ptyBilTpCd");
        this.hashFields.put("s_state", "sState");
        this.hashFields.put("clt_act_yn", "cltActYn");
        this.hashFields.put("csr_no", "csrNo");
        this.hashFields.put("s_n3pty_src_no", "sN3ptySrcNo");
        this.hashFields.put("cfm_dt", "cfmDt");
        this.hashFields.put("s_cust_cnt_cd", "sCustCntCd");
        this.hashFields.put("s_bl_no_all", "sBlNoAll");
        this.hashFields.put("stl_amt", "stlAmt");
        this.hashFields.put("fm_clt_cng_ofc_n3pty_no", "fmCltCngOfcN3ptyNo");
        this.hashFields.put("vvd", "vvd");
        this.hashFields.put("chk", "chk");
        this.hashFields.put("ots_amt", "otsAmt");
        this.hashFields.put("s_dao_n3pty_no", "sDaoN3ptyNo");
        this.hashFields.put("sdate", "sdate");
        this.hashFields.put("n3pty_src_sub_sys_cd", "n3ptySrcSubSysCd");
        this.hashFields.put("curr_cd", "currCd");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("ipage", "ipage");
        this.hashFields.put("s_cfm_dt", "sCfmDt");
        this.hashFields.put("s_if_ctrl_cd", "sIfCtrlCd");
        this.hashFields.put("s_vndr_cnt_cd", "sVndrCntCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("eq_no", "eqNo");
        this.hashFields.put("s_n3pty_ofc_cd", "sN3ptyOfcCd");
        this.hashFields.put("stl_rqst_ofc_cd", "stlRqstOfcCd");
        this.hashFields.put("inv_amt", "invAmt");
        this.hashFields.put("edn_tp_nm", "ednTpNm");
        this.hashFields.put("s_cfm_dt_last", "sCfmDtLast");
        this.hashFields.put("if_usr_id", "ifUsrId");
        this.hashFields.put("s_ots_sts_cd", "sOtsStsCd");
        this.hashFields.put("s_sdate", "sSdate");
        this.hashFields.put("s_vvd", "sVvd");
        this.hashFields.put("s_skd_dir_cd", "sSkdDirCd");
        this.hashFields.put("s_n3pty_src_sub_sys_cd", "sN3ptySrcSubSysCd");
        this.hashFields.put("s_eq_no", "sEqNo");
        this.hashFields.put("s_ots_sts_cd_detail_open", "sOtsStsCdDetailOpen");
        this.hashFields.put("s_bkg_no_split", "sBkgNoSplit");
        this.hashFields.put("s_n3pty_bil_tp_cd", "sN3ptyBilTpCd");
        this.hashFields.put("ofc_cd", "ofcCd");
        this.hashFields.put("if_usr_nm", "ifUsrNm");
        this.hashFields.put("if_dt", "ifDt");
        this.hashFields.put("bkg_cntr_no", "bkgCntrNo");
        this.hashFields.put("s_if_type", "sIfType");
        this.hashFields.put("trd_party_type", "trdPartyType");
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("por_cd", "porCd");
        this.hashFields.put("de_term_cd", "deTermCd");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("del_cd", "delCd");
        this.hashFields.put("contract_no", "contractNo");
        this.hashFields.put("rcv_term_cd", "rcvTermCd");
        this.hashFields.put("contract_ofc", "contractOfc");
        this.hashFields.put("vat_amt", "vatAmt");
        this.hashFields.put("add_amt", "addAmt");
        this.hashFields.put("ddct_amt", "ddctAmt");
        this.hashFields.put("s_ots_sts_cd_detail_non", "sOtsStsCdDetailNon");
        this.hashFields.put("ots_dtl_seq", "otsDtlSeq");
        this.hashFields.put("n3pty_non_cfm_rsn_cd", "n3ptyNonCfmRsnCd");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return otsDtlSeq
	 */
    public String getOtsDtlSeq() {
        return this.otsDtlSeq;
    }

    /**
	 * @return the vatAmt
	 */
    public String getVatAmt() {
        return this.vatAmt;
    }

    /**
	 * @return the addAmt
	 */
    public String getAddAmt() {
        return this.addAmt;
    }

    /**
	 * @return the ddctAmt
	 */
    public String getDdctAmt() {
        return this.ddctAmt;
    }

    /**
	 * @return the trdPartyType
	 */
    public String getTrdPartyType() {
        return this.trdPartyType;
    }

    /**
	 * Column Info
	 * @return sOverdue
	 */
    public String getSOverdue() {
        return this.sOverdue;
    }

    /**
	 * Column Info
	 * @return sBkgNoAll
	 */
    public String getSBkgNoAll() {
        return this.sBkgNoAll;
    }

    /**
	 * Column Info
	 * @return sBlNoTp
	 */
    public String getSBlNoTp() {
        return this.sBlNoTp;
    }

    /**
	 * Column Info
	 * @return ifOfcCd
	 */
    public String getIfOfcCd() {
        return this.ifOfcCd;
    }

    /**
	 * Column Info
	 * @return sN3ptySrcSubSysCdCheck
	 */
    public String getSN3ptySrcSubSysCdCheck() {
        return this.sN3ptySrcSubSysCdCheck;
    }

    /**
	 * Column Info
	 * @return sBlNoChk
	 */
    public String getSBlNoChk() {
        return this.sBlNoChk;
    }

    /**
	 * Column Info
	 * @return sUserOfcCd
	 */
    public String getSUserOfcCd() {
        return this.sUserOfcCd;
    }

    /**
	 * Column Info
	 * @return n3ptyBilTpNm
	 */
    public String getN3ptyBilTpNm() {
        return this.n3ptyBilTpNm;
    }

    /**
	 * Column Info
	 * @return pagerows
	 */
    public String getPagerows() {
        return this.pagerows;
    }

    /**
	 * Column Info
	 * @return sOtsAmtFrom
	 */
    public String getSOtsAmtFrom() {
        return this.sOtsAmtFrom;
    }

    /**
	 * Column Info
	 * @return soIfSeq
	 */
    public String getSoIfSeq() {
        return this.soIfSeq;
    }

    /**
	 * Column Info
	 * @return edate
	 */
    public String getEdate() {
        return this.edate;
    }

    /**
	 * Column Info
	 * @return blNoAll
	 */
    public String getBlNoAll() {
        return this.blNoAll;
    }

    /**
	 * Column Info
	 * @return sOfficeLevel
	 */
    public String getSOfficeLevel() {
        return this.sOfficeLevel;
    }

    /**
	 * Column Info
	 * @return trdPartyName
	 */
    public String getTrdPartyName() {
        return this.trdPartyName;
    }

    /**
	 * Column Info
	 * @return sVndrCustDivCd
	 */
    public String getSVndrCustDivCd() {
        return this.sVndrCustDivCd;
    }

    /**
	 * Column Info
	 * @return n3ptyStlTpCd
	 */
    public String getN3ptyStlTpCd() {
        return this.n3ptyStlTpCd;
    }

    /**
	 * Column Info
	 * @return sOtsStsCdDetailClose
	 */
    public String getSOtsStsCdDetailClose() {
        return this.sOtsStsCdDetailClose;
    }

    /**
	 * Column Info
	 * @return n3ptyNoDpSeq
	 */
    public String getN3ptyNoDpSeq() {
        return this.n3ptyNoDpSeq;
    }

    /**
	 * Column Info
	 * @return sCreUsrId
	 */
    public String getSCreUsrId() {
        return this.sCreUsrId;
    }

    /**
	 * Column Info
	 * @return otsStsNm
	 */
    public String getOtsStsNm() {
        return this.otsStsNm;
    }

    /**
	 * Column Info
	 * @return sFmCltCngOfcN3ptyNo
	 */
    public String getSFmCltCngOfcN3ptyNo() {
        return this.sFmCltCngOfcN3ptyNo;
    }

    /**
	 * Column Info
	 * @return sTrdPartyCode
	 */
    public String getSTrdPartyCode() {
        return this.sTrdPartyCode;
    }

    /**
	 * Column Info
	 * @return sIfRhqCd
	 */
    public String getSIfRhqCd() {
        return this.sIfRhqCd;
    }

    /**
	 * Column Info
	 * @return sCsrNo
	 */
    public String getSCsrNo() {
        return this.sCsrNo;
    }

    /**
	 * Column Info
	 * @return sHVndrCustDivCd
	 */
    public String getSHVndrCustDivCd() {
        return this.sHVndrCustDivCd;
    }

    /**
	 * Column Info
	 * @return sOtsStsCdDetail
	 */
    public String getSOtsStsCdDetail() {
        return this.sOtsStsCdDetail;
    }

    /**
	 * Column Info
	 * @return otsStsCd
	 */
    public String getOtsStsCd() {
        return this.otsStsCd;
    }

    /**
	 * Column Info
	 * @return sOtsAmtTo
	 */
    public String getSOtsAmtTo() {
        return this.sOtsAmtTo;
    }

    /**
	 * Column Info
	 * @return sVslCd
	 */
    public String getSVslCd() {
        return this.sVslCd;
    }

    /**
	 * Column Info
	 * @return sBkgNo
	 */
    public String getSBkgNo() {
        return this.sBkgNo;
    }

    /**
	 * Column Info
	 * @return cltAmt
	 */
    public String getCltAmt() {
        return this.cltAmt;
    }

    /**
	 * Column Info
	 * @return vndrCustDivCd
	 */
    public String getVndrCustDivCd() {
        return this.vndrCustDivCd;
    }

    /**
	 * Column Info
	 * @return balAmt
	 */
    public String getBalAmt() {
        return this.balAmt;
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
	 * @return sN3ptyInvNo
	 */
    public String getSN3ptyInvNo() {
        return this.sN3ptyInvNo;
    }

    /**
	 * Column Info
	 * @return n3ptyNo
	 */
    public String getN3ptyNo() {
        return this.n3ptyNo;
    }

    /**
	 * Column Info
	 * @return sEdate
	 */
    public String getSEdate() {
        return this.sEdate;
    }

    /**
	 * Column Info
	 * @return bkgNoAll
	 */
    public String getBkgNoAll() {
        return this.bkgNoAll;
    }

    /**
	 * Column Info
	 * @return sN3ptyNo
	 */
    public String getSN3ptyNo() {
        return this.sN3ptyNo;
    }

    /**
	 * Column Info
	 * @return sStlToCltCngOfcCd
	 */
    public String getSStlToCltCngOfcCd() {
        return this.sStlToCltCngOfcCd;
    }

    /**
	 * Column Info
	 * @return sVndrSeq
	 */
    public String getSVndrSeq() {
        return this.sVndrSeq;
    }

    /**
	 * Column Info
	 * @return sCfmDtPrev
	 */
    public String getSCfmDtPrev() {
        return this.sCfmDtPrev;
    }

    /**
	 * Column Info
	 * @return sIfOfcCd
	 */
    public String getSIfOfcCd() {
        return this.sIfOfcCd;
    }

    /**
	 * Column Info
	 * @return sOfcCdForRhq
	 */
    public String getSOfcCdForRhq() {
        return this.sOfcCdForRhq;
    }

    /**
	 * Column Info
	 * @return sRhqCdForRhq
	 */
    public String getSRhqCdForRhq() {
        return this.sRhqCdForRhq;
    }

    /**
	 * Column Info
	 * @return sHOtsStsCd
	 */
    public String getSHOtsStsCd() {
        return this.sHOtsStsCd;
    }

    /**
	 * Column Info
	 * @return sHN3ptyInvNo
	 */
    public String getSHN3ptyInvNo() {
        return this.sHN3ptyInvNo;
    }

    /**
	 * Column Info
	 * @return privCd
	 */
    public String getPrivCd() {
        return this.privCd;
    }

    /**
	 * Column Info
	 * @return sN3ptyNoSearch
	 */
    public String getSN3ptyNoSearch() {
        return this.sN3ptyNoSearch;
    }

    /**
	 * Column Info
	 * @return n3ptySrcNo
	 */
    public String getN3ptySrcNo() {
        return this.n3ptySrcNo;
    }

    /**
	 * Column Info
	 * @return sEdnTpCd
	 */
    public String getSEdnTpCd() {
        return this.sEdnTpCd;
    }

    /**
	 * Column Info
	 * @return sCurrCdTp
	 */
    public String getSCurrCdTp() {
        return this.sCurrCdTp;
    }

    /**
	 * Column Info
	 * @return sSkdVoyNo
	 */
    public String getSSkdVoyNo() {
        return this.sSkdVoyNo;
    }

    /**
	 * Column Info
	 * @return trdPartyCode
	 */
    public String getTrdPartyCode() {
        return this.trdPartyCode;
    }

    /**
	 * Column Info
	 * @return sCustSeq
	 */
    public String getSCustSeq() {
        return this.sCustSeq;
    }

    /**
	 * Column Info
	 * @return sTrdPartyVal
	 */
    public String getSTrdPartyVal() {
        return this.sTrdPartyVal;
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
	 * @return invIssDt
	 */
    public String getInvIssDt() {
        return this.invIssDt;
    }

    /**
	 * Column Info
	 * @return n3ptyInvNo
	 */
    public String getN3ptyInvNo() {
        return this.n3ptyInvNo;
    }

    /**
	 * Column Info
	 * @return stlToCltCngOfcCd
	 */
    public String getStlToCltCngOfcCd() {
        return this.stlToCltCngOfcCd;
    }

    /**
	 * Column Info
	 * @return sBlNo
	 */
    public String getSBlNo() {
        return this.sBlNo;
    }

    /**
	 * Column Info
	 * @return n3ptyBilTpCd
	 */
    public String getN3ptyBilTpCd() {
        return this.n3ptyBilTpCd;
    }

    /**
	 * Column Info
	 * @return sState
	 */
    public String getSState() {
        return this.sState;
    }

    /**
	 * Column Info
	 * @return cltActYn
	 */
    public String getCltActYn() {
        return this.cltActYn;
    }

    /**
	 * Column Info
	 * @return csrNo
	 */
    public String getCsrNo() {
        return this.csrNo;
    }

    /**
	 * Column Info
	 * @return sN3ptySrcNo
	 */
    public String getSN3ptySrcNo() {
        return this.sN3ptySrcNo;
    }

    /**
	 * Column Info
	 * @return cfmDt
	 */
    public String getCfmDt() {
        return this.cfmDt;
    }

    /**
	 * Column Info
	 * @return sCustCntCd
	 */
    public String getSCustCntCd() {
        return this.sCustCntCd;
    }

    /**
	 * Column Info
	 * @return sBlNoAll
	 */
    public String getSBlNoAll() {
        return this.sBlNoAll;
    }

    /**
	 * Column Info
	 * @return stlAmt
	 */
    public String getStlAmt() {
        return this.stlAmt;
    }

    /**
	 * Column Info
	 * @return fmCltCngOfcN3ptyNo
	 */
    public String getFmCltCngOfcN3ptyNo() {
        return this.fmCltCngOfcN3ptyNo;
    }

    /**
	 * Column Info
	 * @return vvd
	 */
    public String getVvd() {
        return this.vvd;
    }

    /**
	 * Column Info
	 * @return chk
	 */
    public String getChk() {
        return this.chk;
    }

    /**
	 * Column Info
	 * @return otsAmt
	 */
    public String getOtsAmt() {
        return this.otsAmt;
    }

    /**
	 * Column Info
	 * @return sDaoN3ptyNo
	 */
    public String getSDaoN3ptyNo() {
        return this.sDaoN3ptyNo;
    }

    /**
	 * Column Info
	 * @return sdate
	 */
    public String getSdate() {
        return this.sdate;
    }

    /**
	 * Column Info
	 * @return n3ptySrcSubSysCd
	 */
    public String getN3ptySrcSubSysCd() {
        return this.n3ptySrcSubSysCd;
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
	 * @return creDt
	 */
    public String getCreDt() {
        return this.creDt;
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
	 * @return sCfmDt
	 */
    public String getSCfmDt() {
        return this.sCfmDt;
    }

    /**
	 * Column Info
	 * @return sIfCtrlCd
	 */
    public String getSIfCtrlCd() {
        return this.sIfCtrlCd;
    }

    /**
	 * Column Info
	 * @return sVndrCntCd
	 */
    public String getSVndrCntCd() {
        return this.sVndrCntCd;
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
	 * @return eqNo
	 */
    public String getEqNo() {
        return this.eqNo;
    }

    /**
	 * Column Info
	 * @return sN3ptyOfcCd
	 */
    public String getSN3ptyOfcCd() {
        return this.sN3ptyOfcCd;
    }

    /**
	 * Column Info
	 * @return stlRqstOfcCd
	 */
    public String getStlRqstOfcCd() {
        return this.stlRqstOfcCd;
    }

    /**
	 * Column Info
	 * @return invAmt
	 */
    public String getInvAmt() {
        return this.invAmt;
    }

    /**
	 * Column Info
	 * @return ednTpNm
	 */
    public String getEdnTpNm() {
        return this.ednTpNm;
    }

    /**
	 * Column Info
	 * @return sCfmDtLast
	 */
    public String getSCfmDtLast() {
        return this.sCfmDtLast;
    }

    /**
	 * Column Info
	 * @return ifUsrId
	 */
    public String getIfUsrId() {
        return this.ifUsrId;
    }

    /**
	 * Column Info
	 * @return ifDt
	 */
    public String getIfDt() {
        return this.ifDt;
    }

    /**
	 * Column Info
	 * @return sOtsStsCd
	 */
    public String getSOtsStsCd() {
        return this.sOtsStsCd;
    }

    /**
	 * Column Info
	 * @return sSdate
	 */
    public String getSSdate() {
        return this.sSdate;
    }

    /**
	 * Column Info
	 * @return sVvd
	 */
    public String getSVvd() {
        return this.sVvd;
    }

    /**
	 * Column Info
	 * @return sSkdDirCd
	 */
    public String getSSkdDirCd() {
        return this.sSkdDirCd;
    }

    /**
	 * Column Info
	 * @return sN3ptySrcSubSysCd
	 */
    public String getSN3ptySrcSubSysCd() {
        return this.sN3ptySrcSubSysCd;
    }

    /**
	 * Column Info
	 * @return sEqNo
	 */
    public String getSEqNo() {
        return this.sEqNo;
    }

    /**
	 * Column Info
	 * @return sOtsStsCdDetailOpen
	 */
    public String getSOtsStsCdDetailOpen() {
        return this.sOtsStsCdDetailOpen;
    }

    /**
	 * Column Info
	 * @return sOtsStsCdDetailNon
	 */
    public String getSOtsStsCdDetailNon() {
        return this.sOtsStsCdDetailNon;
    }

    /**
	 * Column Info
	 * @return sBkgNoSplit
	 */
    public String getSBkgNoSplit() {
        return this.sBkgNoSplit;
    }

    /**
	 * Column Info
	 * @return sN3ptyBilTpCd
	 */
    public String getSN3ptyBilTpCd() {
        return this.sN3ptyBilTpCd;
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
	 * @return ifUsrNm
	 */
    public String getIfUsrNm() {
        return this.ifUsrNm;
    }

    /**
	 * Column Info
	 * @return bkgCntrNo
	 */
    public String getBkgCntrNo() {
        return this.bkgCntrNo;
    }

    /**
	 * Column Info
	 * @return sIfType
	 */
    public String getSIfType() {
        return this.sIfType;
    }

    /**
	 * @param vatAmt the vatAmt to set
	 */
    public void setVatAmt(String vatAmt) {
        this.vatAmt = vatAmt;
    }

    /**
	 * @param addAmt the addAmt to set
	 */
    public void setAddAmt(String addAmt) {
        this.addAmt = addAmt;
    }

    /**
	 * @param ddctAmt the ddctAmt to set
	 */
    public void setDdctAmt(String ddctAmt) {
        this.ddctAmt = ddctAmt;
    }

    /**
	 * @param trdPartyType the trdPartyType to set
	 */
    public void setTrdPartyType(String trdPartyType) {
        this.trdPartyType = trdPartyType;
    }

    /**
	 * Column Info
	 * @param sIfType
	 */
    public void setSIfType(String sIfType) {
        this.sIfType = sIfType;
    }

    /**
	 * Column Info
	 * @param sOverdue
	 */
    public void setSOverdue(String sOverdue) {
        this.sOverdue = sOverdue;
    }

    /**
	 * Column Info
	 * @param sBkgNoAll
	 */
    public void setSBkgNoAll(String sBkgNoAll) {
        this.sBkgNoAll = sBkgNoAll;
    }

    /**
	 * Column Info
	 * @param sBlNoTp
	 */
    public void setSBlNoTp(String sBlNoTp) {
        this.sBlNoTp = sBlNoTp;
    }

    /**
	 * Column Info
	 * @param ifOfcCd
	 */
    public void setIfOfcCd(String ifOfcCd) {
        this.ifOfcCd = ifOfcCd;
    }

    /**
	 * Column Info
	 * @param sN3ptySrcSubSysCdCheck
	 */
    public void setSN3ptySrcSubSysCdCheck(String sN3ptySrcSubSysCdCheck) {
        this.sN3ptySrcSubSysCdCheck = sN3ptySrcSubSysCdCheck;
    }

    /**
	 * Column Info
	 * @param sBlNoChk
	 */
    public void setSBlNoChk(String sBlNoChk) {
        this.sBlNoChk = sBlNoChk;
    }

    /**
	 * Column Info
	 * @param sUserOfcCd
	 */
    public void setSUserOfcCd(String sUserOfcCd) {
        this.sUserOfcCd = sUserOfcCd;
    }

    /**
	 * Column Info
	 * @param n3ptyBilTpNm
	 */
    public void setN3ptyBilTpNm(String n3ptyBilTpNm) {
        this.n3ptyBilTpNm = n3ptyBilTpNm;
    }

    /**
	 * Column Info
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    /**
	 * Column Info
	 * @param sOtsAmtFrom
	 */
    public void setSOtsAmtFrom(String sOtsAmtFrom) {
        this.sOtsAmtFrom = sOtsAmtFrom;
    }

    /**
	 * Column Info
	 * @param soIfSeq
	 */
    public void setSoIfSeq(String soIfSeq) {
        this.soIfSeq = soIfSeq;
    }

    /**
	 * Column Info
	 * @param edate
	 */
    public void setEdate(String edate) {
        this.edate = edate;
    }

    /**
	 * Column Info
	 * @param blNoAll
	 */
    public void setBlNoAll(String blNoAll) {
        this.blNoAll = blNoAll;
    }

    /**
	 * Column Info
	 * @param sOfficeLevel
	 */
    public void setSOfficeLevel(String sOfficeLevel) {
        this.sOfficeLevel = sOfficeLevel;
    }

    /**
	 * Column Info
	 * @param trdPartyName
	 */
    public void setTrdPartyName(String trdPartyName) {
        this.trdPartyName = trdPartyName;
    }

    /**
	 * Column Info
	 * @param sVndrCustDivCd
	 */
    public void setSVndrCustDivCd(String sVndrCustDivCd) {
        this.sVndrCustDivCd = sVndrCustDivCd;
    }

    /**
	 * Column Info
	 * @param n3ptyStlTpCd
	 */
    public void setN3ptyStlTpCd(String n3ptyStlTpCd) {
        this.n3ptyStlTpCd = n3ptyStlTpCd;
    }

    /**
	 * Column Info
	 * @param sOtsStsCdDetailClose
	 */
    public void setSOtsStsCdDetailClose(String sOtsStsCdDetailClose) {
        this.sOtsStsCdDetailClose = sOtsStsCdDetailClose;
    }

    /**
	 * Column Info
	 * @param n3ptyNoDpSeq
	 */
    public void setN3ptyNoDpSeq(String n3ptyNoDpSeq) {
        this.n3ptyNoDpSeq = n3ptyNoDpSeq;
    }

    /**
	 * Column Info
	 * @param sCreUsrId
	 */
    public void setSCreUsrId(String sCreUsrId) {
        this.sCreUsrId = sCreUsrId;
    }

    /**
	 * Column Info
	 * @param otsStsNm
	 */
    public void setOtsStsNm(String otsStsNm) {
        this.otsStsNm = otsStsNm;
    }

    /**
	 * Column Info
	 * @param sFmCltCngOfcN3ptyNo
	 */
    public void setSFmCltCngOfcN3ptyNo(String sFmCltCngOfcN3ptyNo) {
        this.sFmCltCngOfcN3ptyNo = sFmCltCngOfcN3ptyNo;
    }

    /**
	 * Column Info
	 * @param sTrdPartyCode
	 */
    public void setSTrdPartyCode(String sTrdPartyCode) {
        this.sTrdPartyCode = sTrdPartyCode;
    }

    /**
	 * Column Info
	 * @param sIfRhqCd
	 */
    public void setSIfRhqCd(String sIfRhqCd) {
        this.sIfRhqCd = sIfRhqCd;
    }

    /**
	 * Column Info
	 * @param sCsrNo
	 */
    public void setSCsrNo(String sCsrNo) {
        this.sCsrNo = sCsrNo;
    }

    /**
	 * Column Info
	 * @param sHVndrCustDivCd
	 */
    public void setSHVndrCustDivCd(String sHVndrCustDivCd) {
        this.sHVndrCustDivCd = sHVndrCustDivCd;
    }

    /**
	 * Column Info
	 * @param sOtsStsCdDetail
	 */
    public void setSOtsStsCdDetail(String sOtsStsCdDetail) {
        this.sOtsStsCdDetail = sOtsStsCdDetail;
    }

    /**
	 * Column Info
	 * @param otsStsCd
	 */
    public void setOtsStsCd(String otsStsCd) {
        this.otsStsCd = otsStsCd;
    }

    /**
	 * Column Info
	 * @param sOtsAmtTo
	 */
    public void setSOtsAmtTo(String sOtsAmtTo) {
        this.sOtsAmtTo = sOtsAmtTo;
    }

    /**
	 * Column Info
	 * @param sVslCd
	 */
    public void setSVslCd(String sVslCd) {
        this.sVslCd = sVslCd;
    }

    /**
	 * Column Info
	 * @param sBkgNo
	 */
    public void setSBkgNo(String sBkgNo) {
        this.sBkgNo = sBkgNo;
    }

    /**
	 * Column Info
	 * @param cltAmt
	 */
    public void setCltAmt(String cltAmt) {
        this.cltAmt = cltAmt;
    }

    /**
	 * Column Info
	 * @param vndrCustDivCd
	 */
    public void setVndrCustDivCd(String vndrCustDivCd) {
        this.vndrCustDivCd = vndrCustDivCd;
    }

    /**
	 * Column Info
	 * @param balAmt
	 */
    public void setBalAmt(String balAmt) {
        this.balAmt = balAmt;
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
	 * @param sN3ptyInvNo
	 */
    public void setSN3ptyInvNo(String sN3ptyInvNo) {
        this.sN3ptyInvNo = sN3ptyInvNo;
    }

    /**
	 * Column Info
	 * @param n3ptyNo
	 */
    public void setN3ptyNo(String n3ptyNo) {
        this.n3ptyNo = n3ptyNo;
    }

    /**
	 * Column Info
	 * @param sEdate
	 */
    public void setSEdate(String sEdate) {
        this.sEdate = sEdate;
    }

    /**
	 * Column Info
	 * @param bkgNoAll
	 */
    public void setBkgNoAll(String bkgNoAll) {
        this.bkgNoAll = bkgNoAll;
    }

    /**
	 * Column Info
	 * @param sN3ptyNo
	 */
    public void setSN3ptyNo(String sN3ptyNo) {
        this.sN3ptyNo = sN3ptyNo;
    }

    /**
	 * Column Info
	 * @param sStlToCltCngOfcCd
	 */
    public void setSStlToCltCngOfcCd(String sStlToCltCngOfcCd) {
        this.sStlToCltCngOfcCd = sStlToCltCngOfcCd;
    }

    /**
	 * Column Info
	 * @param sVndrSeq
	 */
    public void setSVndrSeq(String sVndrSeq) {
        this.sVndrSeq = sVndrSeq;
    }

    /**
	 * Column Info
	 * @param sCfmDtPrev
	 */
    public void setSCfmDtPrev(String sCfmDtPrev) {
        this.sCfmDtPrev = sCfmDtPrev;
    }

    /**
	 * Column Info
	 * @param sIfOfcCd
	 */
    public void setSIfOfcCd(String sIfOfcCd) {
        this.sIfOfcCd = sIfOfcCd;
    }

    /**
	 * Column Info
	 * @param sOfcCdForRhq
	 */
    public void setSOfcCdForRhq(String sOfcCdForRhq) {
        this.sOfcCdForRhq = sOfcCdForRhq;
    }

    /**
	 * Column Info
	 * @param sRhqCdForRhq
	 */
    public void setSRhqCdForRhq(String sRhqCdForRhq) {
        this.sRhqCdForRhq = sRhqCdForRhq;
    }

    /**
	 * Column Info
	 * @param sHOtsStsCd
	 */
    public void setSHOtsStsCd(String sHOtsStsCd) {
        this.sHOtsStsCd = sHOtsStsCd;
    }

    /**
	 * Column Info
	 * @param sHN3ptyInvNo
	 */
    public void setSHN3ptyInvNo(String sHN3ptyInvNo) {
        this.sHN3ptyInvNo = sHN3ptyInvNo;
    }

    /**
	 * Column Info
	 * @param privCd
	 */
    public void setPrivCd(String privCd) {
        this.privCd = privCd;
    }

    /**
	 * Column Info
	 * @param sN3ptyNoSearch
	 */
    public void setSN3ptyNoSearch(String sN3ptyNoSearch) {
        this.sN3ptyNoSearch = sN3ptyNoSearch;
    }

    /**
	 * Column Info
	 * @param n3ptySrcNo
	 */
    public void setN3ptySrcNo(String n3ptySrcNo) {
        this.n3ptySrcNo = n3ptySrcNo;
    }

    /**
	 * Column Info
	 * @param sEdnTpCd
	 */
    public void setSEdnTpCd(String sEdnTpCd) {
        this.sEdnTpCd = sEdnTpCd;
    }

    /**
	 * Column Info
	 * @param sCurrCdTp
	 */
    public void setSCurrCdTp(String sCurrCdTp) {
        this.sCurrCdTp = sCurrCdTp;
    }

    /**
	 * Column Info
	 * @param sSkdVoyNo
	 */
    public void setSSkdVoyNo(String sSkdVoyNo) {
        this.sSkdVoyNo = sSkdVoyNo;
    }

    /**
	 * Column Info
	 * @param trdPartyCode
	 */
    public void setTrdPartyCode(String trdPartyCode) {
        this.trdPartyCode = trdPartyCode;
    }

    /**
	 * Column Info
	 * @param sCustSeq
	 */
    public void setSCustSeq(String sCustSeq) {
        this.sCustSeq = sCustSeq;
    }

    /**
	 * Column Info
	 * @param sTrdPartyVal
	 */
    public void setSTrdPartyVal(String sTrdPartyVal) {
        this.sTrdPartyVal = sTrdPartyVal;
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
	 * @param invIssDt
	 */
    public void setInvIssDt(String invIssDt) {
        this.invIssDt = invIssDt;
    }

    /**
	 * Column Info
	 * @param n3ptyInvNo
	 */
    public void setN3ptyInvNo(String n3ptyInvNo) {
        this.n3ptyInvNo = n3ptyInvNo;
    }

    /**
	 * Column Info
	 * @param stlToCltCngOfcCd
	 */
    public void setStlToCltCngOfcCd(String stlToCltCngOfcCd) {
        this.stlToCltCngOfcCd = stlToCltCngOfcCd;
    }

    /**
	 * Column Info
	 * @param sBlNo
	 */
    public void setSBlNo(String sBlNo) {
        this.sBlNo = sBlNo;
    }

    /**
	 * Column Info
	 * @param n3ptyBilTpCd
	 */
    public void setN3ptyBilTpCd(String n3ptyBilTpCd) {
        this.n3ptyBilTpCd = n3ptyBilTpCd;
    }

    /**
	 * Column Info
	 * @param sState
	 */
    public void setSState(String sState) {
        this.sState = sState;
    }

    /**
	 * Column Info
	 * @param cltActYn
	 */
    public void setCltActYn(String cltActYn) {
        this.cltActYn = cltActYn;
    }

    /**
	 * Column Info
	 * @param csrNo
	 */
    public void setCsrNo(String csrNo) {
        this.csrNo = csrNo;
    }

    /**
	 * Column Info
	 * @param sN3ptySrcNo
	 */
    public void setSN3ptySrcNo(String sN3ptySrcNo) {
        this.sN3ptySrcNo = sN3ptySrcNo;
    }

    /**
	 * Column Info
	 * @param cfmDt
	 */
    public void setCfmDt(String cfmDt) {
        this.cfmDt = cfmDt;
    }

    /**
	 * Column Info
	 * @param sCustCntCd
	 */
    public void setSCustCntCd(String sCustCntCd) {
        this.sCustCntCd = sCustCntCd;
    }

    /**
	 * Column Info
	 * @param sBlNoAll
	 */
    public void setSBlNoAll(String sBlNoAll) {
        this.sBlNoAll = sBlNoAll;
    }

    /**
	 * Column Info
	 * @param stlAmt
	 */
    public void setStlAmt(String stlAmt) {
        this.stlAmt = stlAmt;
    }

    /**
	 * Column Info
	 * @param fmCltCngOfcN3ptyNo
	 */
    public void setFmCltCngOfcN3ptyNo(String fmCltCngOfcN3ptyNo) {
        this.fmCltCngOfcN3ptyNo = fmCltCngOfcN3ptyNo;
    }

    /**
	 * Column Info
	 * @param vvd
	 */
    public void setVvd(String vvd) {
        this.vvd = vvd;
    }

    /**
	 * Column Info
	 * @param chk
	 */
    public void setChk(String chk) {
        this.chk = chk;
    }

    /**
	 * Column Info
	 * @param otsAmt
	 */
    public void setOtsAmt(String otsAmt) {
        this.otsAmt = otsAmt;
    }

    /**
	 * Column Info
	 * @param sDaoN3ptyNo
	 */
    public void setSDaoN3ptyNo(String sDaoN3ptyNo) {
        this.sDaoN3ptyNo = sDaoN3ptyNo;
    }

    /**
	 * Column Info
	 * @param sdate
	 */
    public void setSdate(String sdate) {
        this.sdate = sdate;
    }

    /**
	 * Column Info
	 * @param n3ptySrcSubSysCd
	 */
    public void setN3ptySrcSubSysCd(String n3ptySrcSubSysCd) {
        this.n3ptySrcSubSysCd = n3ptySrcSubSysCd;
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
	 * @param creDt
	 */
    public void setCreDt(String creDt) {
        this.creDt = creDt;
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
	 * @param sCfmDt
	 */
    public void setSCfmDt(String sCfmDt) {
        this.sCfmDt = sCfmDt;
    }

    /**
	 * Column Info
	 * @param sIfCtrlCd
	 */
    public void setSIfCtrlCd(String sIfCtrlCd) {
        this.sIfCtrlCd = sIfCtrlCd;
    }

    /**
	 * Column Info
	 * @param sVndrCntCd
	 */
    public void setSVndrCntCd(String sVndrCntCd) {
        this.sVndrCntCd = sVndrCntCd;
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
	 * @param eqNo
	 */
    public void setEqNo(String eqNo) {
        this.eqNo = eqNo;
    }

    /**
	 * Column Info
	 * @param sN3ptyOfcCd
	 */
    public void setSN3ptyOfcCd(String sN3ptyOfcCd) {
        this.sN3ptyOfcCd = sN3ptyOfcCd;
    }

    /**
	 * Column Info
	 * @param stlRqstOfcCd
	 */
    public void setStlRqstOfcCd(String stlRqstOfcCd) {
        this.stlRqstOfcCd = stlRqstOfcCd;
    }

    /**
	 * Column Info
	 * @param invAmt
	 */
    public void setInvAmt(String invAmt) {
        this.invAmt = invAmt;
    }

    /**
	 * Column Info
	 * @param ednTpNm
	 */
    public void setEdnTpNm(String ednTpNm) {
        this.ednTpNm = ednTpNm;
    }

    /**
	 * Column Info
	 * @param sCfmDtLast
	 */
    public void setSCfmDtLast(String sCfmDtLast) {
        this.sCfmDtLast = sCfmDtLast;
    }

    /**
	 * Column Info
	 * @param ifUsrId
	 */
    public void setIfUsrId(String ifUsrId) {
        this.ifUsrId = ifUsrId;
    }

    /**
	 * Column Info
	 * @param ifDt
	 */
    public void setIfDt(String ifDt) {
        this.ifDt = ifDt;
    }

    /**
	 * Column Info
	 * @param sOtsStsCd
	 */
    public void setSOtsStsCd(String sOtsStsCd) {
        this.sOtsStsCd = sOtsStsCd;
    }

    /**
	 * Column Info
	 * @param sSdate
	 */
    public void setSSdate(String sSdate) {
        this.sSdate = sSdate;
    }

    /**
	 * Column Info
	 * @param sVvd
	 */
    public void setSVvd(String sVvd) {
        this.sVvd = sVvd;
    }

    /**
	 * Column Info
	 * @param sSkdDirCd
	 */
    public void setSSkdDirCd(String sSkdDirCd) {
        this.sSkdDirCd = sSkdDirCd;
    }

    /**
	 * Column Info
	 * @param sN3ptySrcSubSysCd
	 */
    public void setSN3ptySrcSubSysCd(String sN3ptySrcSubSysCd) {
        this.sN3ptySrcSubSysCd = sN3ptySrcSubSysCd;
    }

    /**
	 * Column Info
	 * @param sEqNo
	 */
    public void setSEqNo(String sEqNo) {
        this.sEqNo = sEqNo;
    }

    /**
	 * Column Info
	 * @param sOtsStsCdDetailOpen
	 */
    public void setSOtsStsCdDetailOpen(String sOtsStsCdDetailOpen) {
        this.sOtsStsCdDetailOpen = sOtsStsCdDetailOpen;
    }

    /**
	 * Column Info
	 * @param sOtsStsCdDetailNon
	 */
    public void setSOtsStsCdDetailNon(String sOtsStsCdDetailNon) {
        this.sOtsStsCdDetailNon = sOtsStsCdDetailNon;
    }

    /**
	 * Column Info
	 * @param sBkgNoSplit
	 */
    public void setSBkgNoSplit(String sBkgNoSplit) {
        this.sBkgNoSplit = sBkgNoSplit;
    }

    /**
	 * Column Info
	 * @param sN3ptyBilTpCd
	 */
    public void setSN3ptyBilTpCd(String sN3ptyBilTpCd) {
        this.sN3ptyBilTpCd = sN3ptyBilTpCd;
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
	 * @param ifUsrNm
	 */
    public void setIfUsrNm(String ifUsrNm) {
        this.ifUsrNm = ifUsrNm;
    }

    /**
	 * Column Info
	 * @param bkgCntrNo
	 */
    public void setBkgCntrNo(String bkgCntrNo) {
        this.bkgCntrNo = bkgCntrNo;
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
	 * @return porCd
	 */
    public String getPorCd() {
        return this.porCd;
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
	 * @return polCd
	 */
    public String getPolCd() {
        return this.polCd;
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
	 * @return contractNo
	 */
    public String getContractNo() {
        return this.contractNo;
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
	 * @return contractOfc
	 */
    public String getContractOfc() {
        return this.contractOfc;
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
	 * @param porCd
	 */
    public void setPorCd(String porCd) {
        this.porCd = porCd;
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
	 * @param polCd
	 */
    public void setPolCd(String polCd) {
        this.polCd = polCd;
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
	 * @param contractNo
	 */
    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
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
	 * @param contractOfc
	 */
    public void setContractOfc(String contractOfc) {
        this.contractOfc = contractOfc;
    }

    /**
	 * Column Info
	 * @param otsDtlSeq
	 */
    public void setOtsDtlSeq(String otsDtlSeq) {
        this.otsDtlSeq = otsDtlSeq;
    }

    public void setN3ptyNonCfmRsnCd(String n3ptyNonCfmRsnCd) {
        this.n3ptyNonCfmRsnCd = n3ptyNonCfmRsnCd;
    }

    public String getN3ptyNonCfmRsnCd() {
        return this.n3ptyNonCfmRsnCd;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        fromRequest(request, "");
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request, String prefix) {
        setSOverdue(JSPUtil.getParameter(request, prefix + "s_overdue", ""));
        setSBkgNoAll(JSPUtil.getParameter(request, prefix + "s_bkg_no_all", ""));
        setSBlNoTp(JSPUtil.getParameter(request, prefix + "s_bl_no_tp", ""));
        setIfOfcCd(JSPUtil.getParameter(request, prefix + "if_ofc_cd", ""));
        setSN3ptySrcSubSysCdCheck(JSPUtil.getParameter(request, prefix + "s_n3pty_src_sub_sys_cd_check", ""));
        setSBlNoChk(JSPUtil.getParameter(request, prefix + "s_bl_no_chk", ""));
        setSUserOfcCd(JSPUtil.getParameter(request, prefix + "s_user_ofc_cd", ""));
        setN3ptyBilTpNm(JSPUtil.getParameter(request, prefix + "n3pty_bil_tp_nm", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setSOtsAmtFrom(JSPUtil.getParameter(request, prefix + "s_ots_amt_from", ""));
        setSoIfSeq(JSPUtil.getParameter(request, prefix + "so_if_seq", ""));
        setEdate(JSPUtil.getParameter(request, prefix + "edate", ""));
        setBlNoAll(JSPUtil.getParameter(request, prefix + "bl_no_all", ""));
        setSOfficeLevel(JSPUtil.getParameter(request, prefix + "s_office_level", ""));
        setTrdPartyName(JSPUtil.getParameter(request, prefix + "trd_party_name", ""));
        setSVndrCustDivCd(JSPUtil.getParameter(request, prefix + "s_vndr_cust_div_cd", ""));
        setN3ptyStlTpCd(JSPUtil.getParameter(request, prefix + "n3pty_stl_tp_cd", ""));
        setSOtsStsCdDetailClose(JSPUtil.getParameter(request, prefix + "s_ots_sts_cd_detail_close", ""));
        setN3ptyNoDpSeq(JSPUtil.getParameter(request, prefix + "n3pty_no_dp_seq", ""));
        setSCreUsrId(JSPUtil.getParameter(request, prefix + "s_cre_usr_id", ""));
        setOtsStsNm(JSPUtil.getParameter(request, prefix + "ots_sts_nm", ""));
        setSFmCltCngOfcN3ptyNo(JSPUtil.getParameter(request, prefix + "s_fm_clt_cng_ofc_n3pty_no", ""));
        setSTrdPartyCode(JSPUtil.getParameter(request, prefix + "s_trd_party_code", ""));
        setSIfRhqCd(JSPUtil.getParameter(request, prefix + "s_if_rhq_cd", ""));
        setSCsrNo(JSPUtil.getParameter(request, prefix + "s_csr_no", ""));
        setSHVndrCustDivCd(JSPUtil.getParameter(request, prefix + "s_h_vndr_cust_div_cd", ""));
        setSOtsStsCdDetail(JSPUtil.getParameter(request, prefix + "s_ots_sts_cd_detail", ""));
        setOtsStsCd(JSPUtil.getParameter(request, prefix + "ots_sts_cd", ""));
        setSOtsAmtTo(JSPUtil.getParameter(request, prefix + "s_ots_amt_to", ""));
        setSVslCd(JSPUtil.getParameter(request, prefix + "s_vsl_cd", ""));
        setSBkgNo(JSPUtil.getParameter(request, prefix + "s_bkg_no", ""));
        setCltAmt(JSPUtil.getParameter(request, prefix + "clt_amt", ""));
        setVndrCustDivCd(JSPUtil.getParameter(request, prefix + "vndr_cust_div_cd", ""));
        setBalAmt(JSPUtil.getParameter(request, prefix + "bal_amt", ""));
        setOverdue(JSPUtil.getParameter(request, prefix + "overdue", ""));
        setSN3ptyInvNo(JSPUtil.getParameter(request, prefix + "s_n3pty_inv_no", ""));
        setN3ptyNo(JSPUtil.getParameter(request, prefix + "n3pty_no", ""));
        setSEdate(JSPUtil.getParameter(request, prefix + "s_edate", ""));
        setBkgNoAll(JSPUtil.getParameter(request, prefix + "bkg_no_all", ""));
        setSN3ptyNo(JSPUtil.getParameter(request, prefix + "s_n3pty_no", ""));
        setSStlToCltCngOfcCd(JSPUtil.getParameter(request, prefix + "s_stl_to_clt_cng_ofc_cd", ""));
        setSVndrSeq(JSPUtil.getParameter(request, prefix + "s_vndr_seq", ""));
        setSCfmDtPrev(JSPUtil.getParameter(request, prefix + "s_cfm_dt_prev", ""));
        setSIfOfcCd(JSPUtil.getParameter(request, prefix + "s_if_ofc_cd", ""));
        setSOfcCdForRhq(JSPUtil.getParameter(request, prefix + "s_ofc_cd_for_rhq", ""));
        setSRhqCdForRhq(JSPUtil.getParameter(request, prefix + "s_rhq_cd_for_rhq", ""));
        setSHOtsStsCd(JSPUtil.getParameter(request, prefix + "s_h_ots_sts_cd", ""));
        setSHN3ptyInvNo(JSPUtil.getParameter(request, prefix + "s_h_n3pty_inv_no", ""));
        setPrivCd(JSPUtil.getParameter(request, prefix + "priv_cd", ""));
        setSN3ptyNoSearch(JSPUtil.getParameter(request, prefix + "s_n3pty_no_search", ""));
        setN3ptySrcNo(JSPUtil.getParameter(request, prefix + "n3pty_src_no", ""));
        setSEdnTpCd(JSPUtil.getParameter(request, prefix + "s_edn_tp_cd", ""));
        setSCurrCdTp(JSPUtil.getParameter(request, prefix + "s_curr_cd_tp", ""));
        setSSkdVoyNo(JSPUtil.getParameter(request, prefix + "s_skd_voy_no", ""));
        setTrdPartyCode(JSPUtil.getParameter(request, prefix + "trd_party_code", ""));
        setSCustSeq(JSPUtil.getParameter(request, prefix + "s_cust_seq", ""));
        setSTrdPartyVal(JSPUtil.getParameter(request, prefix + "s_trd_party_val", ""));
        setFCmd(JSPUtil.getParameter(request, prefix + "f_cmd", ""));
        setInvIssDt(JSPUtil.getParameter(request, prefix + "inv_iss_dt", ""));
        setN3ptyInvNo(JSPUtil.getParameter(request, prefix + "n3pty_inv_no", ""));
        setStlToCltCngOfcCd(JSPUtil.getParameter(request, prefix + "stl_to_clt_cng_ofc_cd", ""));
        setSBlNo(JSPUtil.getParameter(request, prefix + "s_bl_no", ""));
        setN3ptyBilTpCd(JSPUtil.getParameter(request, prefix + "n3pty_bil_tp_cd", ""));
        setSState(JSPUtil.getParameter(request, prefix + "s_state", ""));
        setCltActYn(JSPUtil.getParameter(request, prefix + "clt_act_yn", ""));
        setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
        setSN3ptySrcNo(JSPUtil.getParameter(request, prefix + "s_n3pty_src_no", ""));
        setCfmDt(JSPUtil.getParameter(request, prefix + "cfm_dt", ""));
        setSCustCntCd(JSPUtil.getParameter(request, prefix + "s_cust_cnt_cd", ""));
        setSBlNoAll(JSPUtil.getParameter(request, prefix + "s_bl_no_all", ""));
        setStlAmt(JSPUtil.getParameter(request, prefix + "stl_amt", ""));
        setFmCltCngOfcN3ptyNo(JSPUtil.getParameter(request, prefix + "fm_clt_cng_ofc_n3pty_no", ""));
        setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
        setChk(JSPUtil.getParameter(request, prefix + "chk", ""));
        setOtsAmt(JSPUtil.getParameter(request, prefix + "ots_amt", ""));
        setSDaoN3ptyNo(JSPUtil.getParameter(request, prefix + "s_dao_n3pty_no", ""));
        setSdate(JSPUtil.getParameter(request, prefix + "sdate", ""));
        setN3ptySrcSubSysCd(JSPUtil.getParameter(request, prefix + "n3pty_src_sub_sys_cd", ""));
        setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setIpage(JSPUtil.getParameter(request, prefix + "ipage", ""));
        setSCfmDt(JSPUtil.getParameter(request, prefix + "s_cfm_dt", ""));
        setSIfCtrlCd(JSPUtil.getParameter(request, prefix + "s_if_ctrl_cd", ""));
        setSVndrCntCd(JSPUtil.getParameter(request, prefix + "s_vndr_cnt_cd", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
        setSN3ptyOfcCd(JSPUtil.getParameter(request, prefix + "s_n3pty_ofc_cd", ""));
        setStlRqstOfcCd(JSPUtil.getParameter(request, prefix + "stl_rqst_ofc_cd", ""));
        setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
        setEdnTpNm(JSPUtil.getParameter(request, prefix + "edn_tp_nm", ""));
        setSCfmDtLast(JSPUtil.getParameter(request, prefix + "s_cfm_dt_last", ""));
        setIfUsrId(JSPUtil.getParameter(request, prefix + "if_usr_id", ""));
        setSOtsStsCd(JSPUtil.getParameter(request, prefix + "s_ots_sts_cd", ""));
        setSSdate(JSPUtil.getParameter(request, prefix + "s_sdate", ""));
        setSVvd(JSPUtil.getParameter(request, prefix + "s_vvd", ""));
        setSSkdDirCd(JSPUtil.getParameter(request, prefix + "s_skd_dir_cd", ""));
        setSN3ptySrcSubSysCd(JSPUtil.getParameter(request, prefix + "s_n3pty_src_sub_sys_cd", ""));
        setSEqNo(JSPUtil.getParameter(request, prefix + "s_eq_no", ""));
        setSOtsStsCdDetailOpen(JSPUtil.getParameter(request, prefix + "s_ots_sts_cd_detail_open", ""));
        setSBkgNoSplit(JSPUtil.getParameter(request, prefix + "s_bkg_no_split", ""));
        setSN3ptyBilTpCd(JSPUtil.getParameter(request, prefix + "s_n3pty_bil_tp_cd", ""));
        setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
        setIfUsrNm(JSPUtil.getParameter(request, prefix + "if_usr_nm", ""));
        setIfDt(JSPUtil.getParameter(request, prefix + "if_dt", ""));
        setBkgCntrNo(JSPUtil.getParameter(request, prefix + "bkg_cntr_no", ""));
        setSIfType(JSPUtil.getParameter(request, prefix + "s_if_type", ""));
        setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
        setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
        setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
        setContractNo(JSPUtil.getParameter(request, prefix + "contract_no", ""));
        setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
        setContractOfc(JSPUtil.getParameter(request, prefix + "contract_ofc", ""));
        setTrdPartyType(JSPUtil.getParameter(request, prefix + "trd_party_type", ""));
        setVatAmt(JSPUtil.getParameter(request, prefix + "vat_amt", ""));
        setAddAmt(JSPUtil.getParameter(request, prefix + "add_amt", ""));
        setDdctAmt(JSPUtil.getParameter(request, prefix + "ddct_amt", ""));
        setSOtsStsCdDetailNon(JSPUtil.getParameter(request, prefix + "s_ots_sts_cd_detail_non", ""));
        setOtsDtlSeq(JSPUtil.getParameter(request, prefix + "ots_dtl_seq", ""));
        setN3ptyNonCfmRsnCd(JSPUtil.getParameter(request, prefix + "n3pty_non_cfm_rsn_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchStatusByTPBVO[]
	 */
    public SearchStatusByTPBVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchStatusByTPBVO[]
	 */
    public SearchStatusByTPBVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        SearchStatusByTPBVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] sOverdue = (JSPUtil.getParameter(request, prefix + "s_overdue", length));
            String[] sBkgNoAll = (JSPUtil.getParameter(request, prefix + "s_bkg_no_all", length));
            String[] sBlNoTp = (JSPUtil.getParameter(request, prefix + "s_bl_no_tp", length));
            String[] ifOfcCd = (JSPUtil.getParameter(request, prefix + "if_ofc_cd", length));
            String[] sN3ptySrcSubSysCdCheck = (JSPUtil.getParameter(request, prefix + "s_n3pty_src_sub_sys_cd_check", length));
            String[] sBlNoChk = (JSPUtil.getParameter(request, prefix + "s_bl_no_chk", length));
            String[] sUserOfcCd = (JSPUtil.getParameter(request, prefix + "s_user_ofc_cd", length));
            String[] n3ptyBilTpNm = (JSPUtil.getParameter(request, prefix + "n3pty_bil_tp_nm", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] sOtsAmtFrom = (JSPUtil.getParameter(request, prefix + "s_ots_amt_from", length));
            String[] soIfSeq = (JSPUtil.getParameter(request, prefix + "so_if_seq", length));
            String[] edate = (JSPUtil.getParameter(request, prefix + "edate", length));
            String[] blNoAll = (JSPUtil.getParameter(request, prefix + "bl_no_all", length));
            String[] sOfficeLevel = (JSPUtil.getParameter(request, prefix + "s_office_level", length));
            String[] trdPartyName = (JSPUtil.getParameter(request, prefix + "trd_party_name", length));
            String[] sVndrCustDivCd = (JSPUtil.getParameter(request, prefix + "s_vndr_cust_div_cd", length));
            String[] n3ptyStlTpCd = (JSPUtil.getParameter(request, prefix + "n3pty_stl_tp_cd", length));
            String[] sOtsStsCdDetailClose = (JSPUtil.getParameter(request, prefix + "s_ots_sts_cd_detail_close", length));
            String[] n3ptyNoDpSeq = (JSPUtil.getParameter(request, prefix + "n3pty_no_dp_seq", length));
            String[] sCreUsrId = (JSPUtil.getParameter(request, prefix + "s_cre_usr_id", length));
            String[] otsStsNm = (JSPUtil.getParameter(request, prefix + "ots_sts_nm", length));
            String[] sFmCltCngOfcN3ptyNo = (JSPUtil.getParameter(request, prefix + "s_fm_clt_cng_ofc_n3pty_no", length));
            String[] sTrdPartyCode = (JSPUtil.getParameter(request, prefix + "s_trd_party_code", length));
            String[] sIfRhqCd = (JSPUtil.getParameter(request, prefix + "s_if_rhq_cd", length));
            String[] sCsrNo = (JSPUtil.getParameter(request, prefix + "s_csr_no", length));
            String[] sHVndrCustDivCd = (JSPUtil.getParameter(request, prefix + "s_h_vndr_cust_div_cd", length));
            String[] sOtsStsCdDetail = (JSPUtil.getParameter(request, prefix + "s_ots_sts_cd_detail", length));
            String[] otsStsCd = (JSPUtil.getParameter(request, prefix + "ots_sts_cd", length));
            String[] sOtsAmtTo = (JSPUtil.getParameter(request, prefix + "s_ots_amt_to", length));
            String[] sVslCd = (JSPUtil.getParameter(request, prefix + "s_vsl_cd", length));
            String[] sBkgNo = (JSPUtil.getParameter(request, prefix + "s_bkg_no", length));
            String[] cltAmt = (JSPUtil.getParameter(request, prefix + "clt_amt", length));
            String[] vndrCustDivCd = (JSPUtil.getParameter(request, prefix + "vndr_cust_div_cd", length));
            String[] balAmt = (JSPUtil.getParameter(request, prefix + "bal_amt", length));
            String[] overdue = (JSPUtil.getParameter(request, prefix + "overdue", length));
            String[] sN3ptyInvNo = (JSPUtil.getParameter(request, prefix + "s_n3pty_inv_no", length));
            String[] n3ptyNo = (JSPUtil.getParameter(request, prefix + "n3pty_no", length));
            String[] sEdate = (JSPUtil.getParameter(request, prefix + "s_edate", length));
            String[] bkgNoAll = (JSPUtil.getParameter(request, prefix + "bkg_no_all", length));
            String[] sN3ptyNo = (JSPUtil.getParameter(request, prefix + "s_n3pty_no", length));
            String[] sStlToCltCngOfcCd = (JSPUtil.getParameter(request, prefix + "s_stl_to_clt_cng_ofc_cd", length));
            String[] sVndrSeq = (JSPUtil.getParameter(request, prefix + "s_vndr_seq", length));
            String[] sCfmDtPrev = (JSPUtil.getParameter(request, prefix + "s_cfm_dt_prev", length));
            String[] sIfOfcCd = (JSPUtil.getParameter(request, prefix + "s_if_ofc_cd", length));
            String[] sOfcCdForRhq = (JSPUtil.getParameter(request, prefix + "s_ofc_cd_for_rhq", length));
            String[] sRhqCdForRhq = (JSPUtil.getParameter(request, prefix + "s_rhq_cd_for_rhq", length));
            String[] sHOtsStsCd = (JSPUtil.getParameter(request, prefix + "s_h_ots_sts_cd", length));
            String[] sHN3ptyInvNo = (JSPUtil.getParameter(request, prefix + "s_h_n3pty_inv_no", length));
            String[] privCd = (JSPUtil.getParameter(request, prefix + "priv_cd", length));
            String[] sN3ptyNoSearch = (JSPUtil.getParameter(request, prefix + "s_n3pty_no_search", length));
            String[] n3ptySrcNo = (JSPUtil.getParameter(request, prefix + "n3pty_src_no", length));
            String[] sEdnTpCd = (JSPUtil.getParameter(request, prefix + "s_edn_tp_cd", length));
            String[] sCurrCdTp = (JSPUtil.getParameter(request, prefix + "s_curr_cd_tp", length));
            String[] sSkdVoyNo = (JSPUtil.getParameter(request, prefix + "s_skd_voy_no", length));
            String[] trdPartyCode = (JSPUtil.getParameter(request, prefix + "trd_party_code", length));
            String[] sCustSeq = (JSPUtil.getParameter(request, prefix + "s_cust_seq", length));
            String[] sTrdPartyVal = (JSPUtil.getParameter(request, prefix + "s_trd_party_val", length));
            String[] fCmd = (JSPUtil.getParameter(request, prefix + "f_cmd", length));
            String[] invIssDt = (JSPUtil.getParameter(request, prefix + "inv_iss_dt", length));
            String[] n3ptyInvNo = (JSPUtil.getParameter(request, prefix + "n3pty_inv_no", length));
            String[] stlToCltCngOfcCd = (JSPUtil.getParameter(request, prefix + "stl_to_clt_cng_ofc_cd", length));
            String[] sBlNo = (JSPUtil.getParameter(request, prefix + "s_bl_no", length));
            String[] n3ptyBilTpCd = (JSPUtil.getParameter(request, prefix + "n3pty_bil_tp_cd", length));
            String[] sState = (JSPUtil.getParameter(request, prefix + "s_state", length));
            String[] cltActYn = (JSPUtil.getParameter(request, prefix + "clt_act_yn", length));
            String[] csrNo = (JSPUtil.getParameter(request, prefix + "csr_no", length));
            String[] sN3ptySrcNo = (JSPUtil.getParameter(request, prefix + "s_n3pty_src_no", length));
            String[] cfmDt = (JSPUtil.getParameter(request, prefix + "cfm_dt", length));
            String[] sCustCntCd = (JSPUtil.getParameter(request, prefix + "s_cust_cnt_cd", length));
            String[] sBlNoAll = (JSPUtil.getParameter(request, prefix + "s_bl_no_all", length));
            String[] stlAmt = (JSPUtil.getParameter(request, prefix + "stl_amt", length));
            String[] fmCltCngOfcN3ptyNo = (JSPUtil.getParameter(request, prefix + "fm_clt_cng_ofc_n3pty_no", length));
            String[] vvd = (JSPUtil.getParameter(request, prefix + "vvd", length));
            String[] chk = (JSPUtil.getParameter(request, prefix + "chk", length));
            String[] otsAmt = (JSPUtil.getParameter(request, prefix + "ots_amt", length));
            String[] sDaoN3ptyNo = (JSPUtil.getParameter(request, prefix + "s_dao_n3pty_no", length));
            String[] sdate = (JSPUtil.getParameter(request, prefix + "sdate", length));
            String[] n3ptySrcSubSysCd = (JSPUtil.getParameter(request, prefix + "n3pty_src_sub_sys_cd", length));
            String[] currCd = (JSPUtil.getParameter(request, prefix + "curr_cd", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] ipage = (JSPUtil.getParameter(request, prefix + "ipage", length));
            String[] sCfmDt = (JSPUtil.getParameter(request, prefix + "s_cfm_dt", length));
            String[] sIfCtrlCd = (JSPUtil.getParameter(request, prefix + "s_if_ctrl_cd", length));
            String[] sVndrCntCd = (JSPUtil.getParameter(request, prefix + "s_vndr_cnt_cd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] eqNo = (JSPUtil.getParameter(request, prefix + "eq_no", length));
            String[] sN3ptyOfcCd = (JSPUtil.getParameter(request, prefix + "s_n3pty_ofc_cd", length));
            String[] stlRqstOfcCd = (JSPUtil.getParameter(request, prefix + "stl_rqst_ofc_cd", length));
            String[] invAmt = (JSPUtil.getParameter(request, prefix + "inv_amt", length));
            String[] ednTpNm = (JSPUtil.getParameter(request, prefix + "edn_tp_nm", length));
            String[] sCfmDtLast = (JSPUtil.getParameter(request, prefix + "s_cfm_dt_last", length));
            String[] ifUsrId = (JSPUtil.getParameter(request, prefix + "if_usr_id", length));
            String[] sOtsStsCd = (JSPUtil.getParameter(request, prefix + "s_ots_sts_cd", length));
            String[] sSdate = (JSPUtil.getParameter(request, prefix + "s_sdate", length));
            String[] sVvd = (JSPUtil.getParameter(request, prefix + "s_vvd", length));
            String[] sSkdDirCd = (JSPUtil.getParameter(request, prefix + "s_skd_dir_cd", length));
            String[] sN3ptySrcSubSysCd = (JSPUtil.getParameter(request, prefix + "s_n3pty_src_sub_sys_cd", length));
            String[] sEqNo = (JSPUtil.getParameter(request, prefix + "s_eq_no", length));
            String[] sOtsStsCdDetailOpen = (JSPUtil.getParameter(request, prefix + "s_ots_sts_cd_detail_open", length));
            String[] sBkgNoSplit = (JSPUtil.getParameter(request, prefix + "s_bkg_no_split", length));
            String[] sN3ptyBilTpCd = (JSPUtil.getParameter(request, prefix + "s_n3pty_bil_tp_cd", length));
            String[] ofcCd = (JSPUtil.getParameter(request, prefix + "ofc_cd", length));
            String[] ifUsrNm = (JSPUtil.getParameter(request, prefix + "if_usr_nm", length));
            String[] ifDt = (JSPUtil.getParameter(request, prefix + "if_dt", length));
            String[] bkgCntrNo = (JSPUtil.getParameter(request, prefix + "bkg_cntr_no", length));
            String[] sIfType = (JSPUtil.getParameter(request, prefix + "s_if_type", length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
            String[] porCd = (JSPUtil.getParameter(request, prefix + "por_cd", length));
            String[] deTermCd = (JSPUtil.getParameter(request, prefix + "de_term_cd", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] delCd = (JSPUtil.getParameter(request, prefix + "del_cd", length));
            String[] contractNo = (JSPUtil.getParameter(request, prefix + "contract_no", length));
            String[] rcvTermCd = (JSPUtil.getParameter(request, prefix + "rcv_term_cd", length));
            String[] contractOfc = (JSPUtil.getParameter(request, prefix + "contract_ofc", length));
            String[] trdPartyType = (JSPUtil.getParameter(request, prefix + "trd_party_type", length));
            String[] vatAmt = (JSPUtil.getParameter(request, prefix + "vat_amt", length));
            String[] addAmt = (JSPUtil.getParameter(request, prefix + "add_amt", length));
            String[] ddctAmt = (JSPUtil.getParameter(request, prefix + "ddct_amt", length));
            String[] sOtsStsCdDetailNon = (JSPUtil.getParameter(request, prefix + "s_ots_sts_cd_detail_non", length));
            String[] otsDtlSeq = (JSPUtil.getParameter(request, prefix + "ots_dtl_seq", length));
            String[] n3ptyNonCfmRsnCd = (JSPUtil.getParameter(request, prefix + "n3pty_non_cfm_rsn_cd", length));
            for (int i = 0; i < length; i++) {
                model = new SearchStatusByTPBVO();
                if (sOverdue[i] != null)
                    model.setSOverdue(sOverdue[i]);
                if (sBkgNoAll[i] != null)
                    model.setSBkgNoAll(sBkgNoAll[i]);
                if (sBlNoTp[i] != null)
                    model.setSBlNoTp(sBlNoTp[i]);
                if (ifOfcCd[i] != null)
                    model.setIfOfcCd(ifOfcCd[i]);
                if (sN3ptySrcSubSysCdCheck[i] != null)
                    model.setSN3ptySrcSubSysCdCheck(sN3ptySrcSubSysCdCheck[i]);
                if (sBlNoChk[i] != null)
                    model.setSBlNoChk(sBlNoChk[i]);
                if (sUserOfcCd[i] != null)
                    model.setSUserOfcCd(sUserOfcCd[i]);
                if (n3ptyBilTpNm[i] != null)
                    model.setN3ptyBilTpNm(n3ptyBilTpNm[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (sOtsAmtFrom[i] != null)
                    model.setSOtsAmtFrom(sOtsAmtFrom[i]);
                if (soIfSeq[i] != null)
                    model.setSoIfSeq(soIfSeq[i]);
                if (edate[i] != null)
                    model.setEdate(edate[i]);
                if (blNoAll[i] != null)
                    model.setBlNoAll(blNoAll[i]);
                if (sOfficeLevel[i] != null)
                    model.setSOfficeLevel(sOfficeLevel[i]);
                if (trdPartyName[i] != null)
                    model.setTrdPartyName(trdPartyName[i]);
                if (sVndrCustDivCd[i] != null)
                    model.setSVndrCustDivCd(sVndrCustDivCd[i]);
                if (n3ptyStlTpCd[i] != null)
                    model.setN3ptyStlTpCd(n3ptyStlTpCd[i]);
                if (sOtsStsCdDetailClose[i] != null)
                    model.setSOtsStsCdDetailClose(sOtsStsCdDetailClose[i]);
                if (n3ptyNoDpSeq[i] != null)
                    model.setN3ptyNoDpSeq(n3ptyNoDpSeq[i]);
                if (sCreUsrId[i] != null)
                    model.setSCreUsrId(sCreUsrId[i]);
                if (otsStsNm[i] != null)
                    model.setOtsStsNm(otsStsNm[i]);
                if (sFmCltCngOfcN3ptyNo[i] != null)
                    model.setSFmCltCngOfcN3ptyNo(sFmCltCngOfcN3ptyNo[i]);
                if (sTrdPartyCode[i] != null)
                    model.setSTrdPartyCode(sTrdPartyCode[i]);
                if (sIfRhqCd[i] != null)
                    model.setSIfRhqCd(sIfRhqCd[i]);
                if (sCsrNo[i] != null)
                    model.setSCsrNo(sCsrNo[i]);
                if (sHVndrCustDivCd[i] != null)
                    model.setSHVndrCustDivCd(sHVndrCustDivCd[i]);
                if (sOtsStsCdDetail[i] != null)
                    model.setSOtsStsCdDetail(sOtsStsCdDetail[i]);
                if (otsStsCd[i] != null)
                    model.setOtsStsCd(otsStsCd[i]);
                if (sOtsAmtTo[i] != null)
                    model.setSOtsAmtTo(sOtsAmtTo[i]);
                if (sVslCd[i] != null)
                    model.setSVslCd(sVslCd[i]);
                if (sBkgNo[i] != null)
                    model.setSBkgNo(sBkgNo[i]);
                if (cltAmt[i] != null)
                    model.setCltAmt(cltAmt[i]);
                if (vndrCustDivCd[i] != null)
                    model.setVndrCustDivCd(vndrCustDivCd[i]);
                if (balAmt[i] != null)
                    model.setBalAmt(balAmt[i]);
                if (overdue[i] != null)
                    model.setOverdue(overdue[i]);
                if (sN3ptyInvNo[i] != null)
                    model.setSN3ptyInvNo(sN3ptyInvNo[i]);
                if (n3ptyNo[i] != null)
                    model.setN3ptyNo(n3ptyNo[i]);
                if (sEdate[i] != null)
                    model.setSEdate(sEdate[i]);
                if (bkgNoAll[i] != null)
                    model.setBkgNoAll(bkgNoAll[i]);
                if (sN3ptyNo[i] != null)
                    model.setSN3ptyNo(sN3ptyNo[i]);
                if (sStlToCltCngOfcCd[i] != null)
                    model.setSStlToCltCngOfcCd(sStlToCltCngOfcCd[i]);
                if (sVndrSeq[i] != null)
                    model.setSVndrSeq(sVndrSeq[i]);
                if (sCfmDtPrev[i] != null)
                    model.setSCfmDtPrev(sCfmDtPrev[i]);
                if (sIfOfcCd[i] != null)
                    model.setSIfOfcCd(sIfOfcCd[i]);
                if (sOfcCdForRhq[i] != null)
                    model.setSOfcCdForRhq(sOfcCdForRhq[i]);
                if (sRhqCdForRhq[i] != null)
                    model.setSRhqCdForRhq(sRhqCdForRhq[i]);
                if (sHOtsStsCd[i] != null)
                    model.setSHOtsStsCd(sHOtsStsCd[i]);
                if (sHN3ptyInvNo[i] != null)
                    model.setSHN3ptyInvNo(sHN3ptyInvNo[i]);
                if (privCd[i] != null)
                    model.setPrivCd(privCd[i]);
                if (sN3ptyNoSearch[i] != null)
                    model.setSN3ptyNoSearch(sN3ptyNoSearch[i]);
                if (n3ptySrcNo[i] != null)
                    model.setN3ptySrcNo(n3ptySrcNo[i]);
                if (sEdnTpCd[i] != null)
                    model.setSEdnTpCd(sEdnTpCd[i]);
                if (sCurrCdTp[i] != null)
                    model.setSCurrCdTp(sCurrCdTp[i]);
                if (sSkdVoyNo[i] != null)
                    model.setSSkdVoyNo(sSkdVoyNo[i]);
                if (trdPartyCode[i] != null)
                    model.setTrdPartyCode(trdPartyCode[i]);
                if (sCustSeq[i] != null)
                    model.setSCustSeq(sCustSeq[i]);
                if (sTrdPartyVal[i] != null)
                    model.setSTrdPartyVal(sTrdPartyVal[i]);
                if (fCmd[i] != null)
                    model.setFCmd(fCmd[i]);
                if (invIssDt[i] != null)
                    model.setInvIssDt(invIssDt[i]);
                if (n3ptyInvNo[i] != null)
                    model.setN3ptyInvNo(n3ptyInvNo[i]);
                if (stlToCltCngOfcCd[i] != null)
                    model.setStlToCltCngOfcCd(stlToCltCngOfcCd[i]);
                if (sBlNo[i] != null)
                    model.setSBlNo(sBlNo[i]);
                if (n3ptyBilTpCd[i] != null)
                    model.setN3ptyBilTpCd(n3ptyBilTpCd[i]);
                if (sState[i] != null)
                    model.setSState(sState[i]);
                if (cltActYn[i] != null)
                    model.setCltActYn(cltActYn[i]);
                if (csrNo[i] != null)
                    model.setCsrNo(csrNo[i]);
                if (sN3ptySrcNo[i] != null)
                    model.setSN3ptySrcNo(sN3ptySrcNo[i]);
                if (cfmDt[i] != null)
                    model.setCfmDt(cfmDt[i]);
                if (sCustCntCd[i] != null)
                    model.setSCustCntCd(sCustCntCd[i]);
                if (sBlNoAll[i] != null)
                    model.setSBlNoAll(sBlNoAll[i]);
                if (stlAmt[i] != null)
                    model.setStlAmt(stlAmt[i]);
                if (fmCltCngOfcN3ptyNo[i] != null)
                    model.setFmCltCngOfcN3ptyNo(fmCltCngOfcN3ptyNo[i]);
                if (vvd[i] != null)
                    model.setVvd(vvd[i]);
                if (chk[i] != null)
                    model.setChk(chk[i]);
                if (otsAmt[i] != null)
                    model.setOtsAmt(otsAmt[i]);
                if (sDaoN3ptyNo[i] != null)
                    model.setSDaoN3ptyNo(sDaoN3ptyNo[i]);
                if (sdate[i] != null)
                    model.setSdate(sdate[i]);
                if (n3ptySrcSubSysCd[i] != null)
                    model.setN3ptySrcSubSysCd(n3ptySrcSubSysCd[i]);
                if (currCd[i] != null)
                    model.setCurrCd(currCd[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (ipage[i] != null)
                    model.setIpage(ipage[i]);
                if (sCfmDt[i] != null)
                    model.setSCfmDt(sCfmDt[i]);
                if (sIfCtrlCd[i] != null)
                    model.setSIfCtrlCd(sIfCtrlCd[i]);
                if (sVndrCntCd[i] != null)
                    model.setSVndrCntCd(sVndrCntCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (eqNo[i] != null)
                    model.setEqNo(eqNo[i]);
                if (sN3ptyOfcCd[i] != null)
                    model.setSN3ptyOfcCd(sN3ptyOfcCd[i]);
                if (stlRqstOfcCd[i] != null)
                    model.setStlRqstOfcCd(stlRqstOfcCd[i]);
                if (invAmt[i] != null)
                    model.setInvAmt(invAmt[i]);
                if (ednTpNm[i] != null)
                    model.setEdnTpNm(ednTpNm[i]);
                if (sCfmDtLast[i] != null)
                    model.setSCfmDtLast(sCfmDtLast[i]);
                if (ifUsrId[i] != null)
                    model.setIfUsrId(ifUsrId[i]);
                if (sOtsStsCd[i] != null)
                    model.setSOtsStsCd(sOtsStsCd[i]);
                if (sSdate[i] != null)
                    model.setSSdate(sSdate[i]);
                if (sVvd[i] != null)
                    model.setSVvd(sVvd[i]);
                if (sSkdDirCd[i] != null)
                    model.setSSkdDirCd(sSkdDirCd[i]);
                if (sN3ptySrcSubSysCd[i] != null)
                    model.setSN3ptySrcSubSysCd(sN3ptySrcSubSysCd[i]);
                if (sEqNo[i] != null)
                    model.setSEqNo(sEqNo[i]);
                if (sOtsStsCdDetailOpen[i] != null)
                    model.setSOtsStsCdDetailOpen(sOtsStsCdDetailOpen[i]);
                if (sBkgNoSplit[i] != null)
                    model.setSBkgNoSplit(sBkgNoSplit[i]);
                if (sN3ptyBilTpCd[i] != null)
                    model.setSN3ptyBilTpCd(sN3ptyBilTpCd[i]);
                if (ofcCd[i] != null)
                    model.setOfcCd(ofcCd[i]);
                if (ifUsrNm[i] != null)
                    model.setIfUsrNm(ifUsrNm[i]);
                if (ifDt[i] != null)
                    model.setIfDt(ifDt[i]);
                if (bkgCntrNo[i] != null)
                    model.setBkgCntrNo(bkgCntrNo[i]);
                if (sIfType[i] != null)
                    model.setSIfType(sIfType[i]);
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (porCd[i] != null)
                    model.setPorCd(porCd[i]);
                if (deTermCd[i] != null)
                    model.setDeTermCd(deTermCd[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (delCd[i] != null)
                    model.setDelCd(delCd[i]);
                if (contractNo[i] != null)
                    model.setContractNo(contractNo[i]);
                if (rcvTermCd[i] != null)
                    model.setRcvTermCd(rcvTermCd[i]);
                if (contractOfc[i] != null)
                    model.setContractOfc(contractOfc[i]);
                if (trdPartyType[i] != null)
                    model.setTrdPartyType(trdPartyType[i]);
                if (vatAmt[i] != null)
                    model.setVatAmt(vatAmt[i]);
                if (addAmt[i] != null)
                    model.setAddAmt(addAmt[i]);
                if (ddctAmt[i] != null)
                    model.setDdctAmt(ddctAmt[i]);
                if (sOtsStsCdDetailNon[i] != null)
                    model.setSOtsStsCdDetailNon(sOtsStsCdDetailNon[i]);
                if (otsDtlSeq[i] != null)
                    model.setOtsDtlSeq(otsDtlSeq[i]);
                if (n3ptyNonCfmRsnCd[i] != null)
                    model.setN3ptyNonCfmRsnCd(n3ptyNonCfmRsnCd[i]);
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getSearchStatusByTPBVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return SearchStatusByTPBVO[]
	 */
    public SearchStatusByTPBVO[] getSearchStatusByTPBVOs() {
        SearchStatusByTPBVO[] vos = (SearchStatusByTPBVO[]) models.toArray(new SearchStatusByTPBVO[models.size()]);
        return vos;
    }

    /**
	 * VO Class의 내용을 String으로 변환
	 */
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    /**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
    public void unDataFormat() {
        this.sOverdue = this.sOverdue.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sBkgNoAll = this.sBkgNoAll.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sBlNoTp = this.sBlNoTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ifOfcCd = this.ifOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sN3ptySrcSubSysCdCheck = this.sN3ptySrcSubSysCdCheck.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sBlNoChk = this.sBlNoChk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sUserOfcCd = this.sUserOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n3ptyBilTpNm = this.n3ptyBilTpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sOtsAmtFrom = this.sOtsAmtFrom.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.soIfSeq = this.soIfSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.edate = this.edate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blNoAll = this.blNoAll.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sOfficeLevel = this.sOfficeLevel.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trdPartyName = this.trdPartyName.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sVndrCustDivCd = this.sVndrCustDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n3ptyStlTpCd = this.n3ptyStlTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sOtsStsCdDetailClose = this.sOtsStsCdDetailClose.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n3ptyNoDpSeq = this.n3ptyNoDpSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sCreUsrId = this.sCreUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.otsStsNm = this.otsStsNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sFmCltCngOfcN3ptyNo = this.sFmCltCngOfcN3ptyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sTrdPartyCode = this.sTrdPartyCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sIfRhqCd = this.sIfRhqCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sCsrNo = this.sCsrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sHVndrCustDivCd = this.sHVndrCustDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sOtsStsCdDetail = this.sOtsStsCdDetail.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.otsStsCd = this.otsStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sOtsAmtTo = this.sOtsAmtTo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sVslCd = this.sVslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sBkgNo = this.sBkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cltAmt = this.cltAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrCustDivCd = this.vndrCustDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.balAmt = this.balAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.overdue = this.overdue.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sN3ptyInvNo = this.sN3ptyInvNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n3ptyNo = this.n3ptyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sEdate = this.sEdate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNoAll = this.bkgNoAll.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sN3ptyNo = this.sN3ptyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sStlToCltCngOfcCd = this.sStlToCltCngOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sVndrSeq = this.sVndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sCfmDtPrev = this.sCfmDtPrev.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sIfOfcCd = this.sIfOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sOfcCdForRhq = this.sOfcCdForRhq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sRhqCdForRhq = this.sRhqCdForRhq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sHOtsStsCd = this.sHOtsStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sHN3ptyInvNo = this.sHN3ptyInvNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.privCd = this.privCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sN3ptyNoSearch = this.sN3ptyNoSearch.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n3ptySrcNo = this.n3ptySrcNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sEdnTpCd = this.sEdnTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sCurrCdTp = this.sCurrCdTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sSkdVoyNo = this.sSkdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trdPartyCode = this.trdPartyCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sCustSeq = this.sCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sTrdPartyVal = this.sTrdPartyVal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fCmd = this.fCmd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invIssDt = this.invIssDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n3ptyInvNo = this.n3ptyInvNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stlToCltCngOfcCd = this.stlToCltCngOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sBlNo = this.sBlNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n3ptyBilTpCd = this.n3ptyBilTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sState = this.sState.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cltActYn = this.cltActYn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.csrNo = this.csrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sN3ptySrcNo = this.sN3ptySrcNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cfmDt = this.cfmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sCustCntCd = this.sCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sBlNoAll = this.sBlNoAll.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stlAmt = this.stlAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fmCltCngOfcN3ptyNo = this.fmCltCngOfcN3ptyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvd = this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chk = this.chk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.otsAmt = this.otsAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sDaoN3ptyNo = this.sDaoN3ptyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sdate = this.sdate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n3ptySrcSubSysCd = this.n3ptySrcSubSysCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.currCd = this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ipage = this.ipage.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sCfmDt = this.sCfmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sIfCtrlCd = this.sIfCtrlCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sVndrCntCd = this.sVndrCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqNo = this.eqNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sN3ptyOfcCd = this.sN3ptyOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stlRqstOfcCd = this.stlRqstOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invAmt = this.invAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ednTpNm = this.ednTpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sCfmDtLast = this.sCfmDtLast.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ifUsrId = this.ifUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sOtsStsCd = this.sOtsStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sSdate = this.sSdate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sVvd = this.sVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sSkdDirCd = this.sSkdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sN3ptySrcSubSysCd = this.sN3ptySrcSubSysCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sEqNo = this.sEqNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sOtsStsCdDetailOpen = this.sOtsStsCdDetailOpen.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sBkgNoSplit = this.sBkgNoSplit.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sN3ptyBilTpCd = this.sN3ptyBilTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcCd = this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ifUsrNm = this.ifUsrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ifDt = this.ifDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgCntrNo = this.bkgCntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sIfType = this.sIfType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.porCd = this.porCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deTermCd = this.deTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delCd = this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.contractNo = this.contractNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcvTermCd = this.rcvTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.contractOfc = this.contractOfc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trdPartyType = this.trdPartyType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vatAmt = this.vatAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.addAmt = this.addAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ddctAmt = this.ddctAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sOtsStsCdDetailNon = this.sOtsStsCdDetailNon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.otsDtlSeq = this.otsDtlSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n3ptyNonCfmRsnCd = this.n3ptyNonCfmRsnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
