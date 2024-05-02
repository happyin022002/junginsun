/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CreateEACRegistrationVO.java
*@FileTitle : CreateEACRegistrationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.16
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2009.09.16 최 선 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

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

public class CreateEACRegistrationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CreateEACRegistrationVO> models = new ArrayList<CreateEACRegistrationVO>();
	
	/* Column Info */
	private String sSrcVndrNo = null;
	/* Column Info */
	private String sRegType = null;
	/* Column Info */
	private String sSkdVoyNo = null;
	/* Column Info */
	private String sBkgNoAll = null;
	/* Column Info */
	private String sN3ptyBilTpCd = null;
	/* Column Info */
	private String sVslCd = null;
	/* Column Info */
	private String sCustSeq = null;
	/* Column Info */
	private String sBkgNo = null;
	/* Column Info */
	private String sBlNoTp = null;
	/* Column Info */
	private String sEqTpszCd = null;
	/* Column Info */
	private String sBlNoChk = null;
	/* Column Info */
	private String sTrdPartyVal = null;
	/* Column Info */
	private String fCmd = null;
	/* Column Info */
	private String ipage = null;
	/* Column Info */
	private String sFileNo = null;
	/* Column Info */
	private String pagerows = null;
	/* Column Info */
	private String sVndrCntCd = null;
	/* Column Info */
	private String sBlNo = null;
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String sN3ptyOfcCd = null;
	/* Column Info */
	private String sYdCd = null;
	/* Column Info */
	private String sIfDt = null;
	/* Column Info */
	private String sIfRmk = null;
	/* Column Info */
	private String sEdate = null;
	/* Column Info */
	private String sN3ptySrcNo = null;
	/* Column Info */
	private String sIfAmt = null;
	/* Column Info */
	private String sVndrSeq = null;
	/* Column Info */
	private String sCustCntCd = null;
	/* Column Info */
	private String sBlNoAll = null;
	/* Column Info */
	private String sSdate = null;
	/* Column Info */
	private String sSrcVndrSeq = null;
	/* Column Info */
	private String sVvd = null;
	/* Column Info */
	private String sIfOfcCd = null;
	/* Column Info */
	private String sSkdDirCd = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String sBilTpCd = null;
	/* Column Info */
	private String sEqNo = null;
	/* Column Info */
	private String sN3ptyIfTpCd = null;
	/* Column Info */
	private String sUserId = null;
	/* Column Info */
	private String sSrcVndrCntCd = null;
	/* Column Info */
	private String ifAmt = null;
	/* Column Info */
	private String sN3ptyExpnTpCd = null;
	/* Column Info */
	private String eqTpCd = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String sBkgNoSplit = null;
	/* Column Info */
	private String sEqTpCd = null;
	/* Column Info */
	private String sEqKndCd = null;
	/* Column Info */
	private String sEdnTpCd = null;
	/* Column Info */
	private String sVndrLglEngNm = null;
	/* Column Info */
	private String sTrdPartyNm = null;
	/* Column Info */
	private String sVndrCustDivCd = null;
	/* Column Info */
	private String sCustLglEngNm = null;
	/* Column Info */
	private String sSvrId = null;
	/* Column Info */
	private String sCurrCd = null;
	/* Column Info */
	private String sBkgFincDirCd = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CreateEACRegistrationVO() {}

	public CreateEACRegistrationVO(String ibflag, String pagerows, String eqTpCd, String eqKndCd, String eqNo, String eqTpszCd, String ifAmt, String fCmd, String ipage, String sN3ptyIfTpCd, String sBilTpCd, String sBkgNo, String sBkgNoSplit, String sBlNoChk, String sBlNo, String sBlNoTp, String sVslCd, String sSkdVoyNo, String sSkdDirCd, String sVndrCntCd, String sVndrSeq, String sCustCntCd, String sCustSeq, String sN3ptyOfcCd, String sSrcVndrCntCd, String sSrcVndrSeq, String sSdate, String sEdate, String sUserId, String sEqTpCd, String sEqKndCd, String sEqNo, String sIfAmt, String sRegType, String sEdnTpCd, String sN3ptyExpnTpCd, String sN3ptyBilTpCd, String sIfOfcCd, String sN3ptySrcNo, String sSrcVndrNo, String sBkgNoAll, String sBlNoAll, String sEqTpszCd, String sIfDt, String sVvd, String sYdCd, String sTrdPartyVal, String sIfRmk, String sFileNo, String sVndrLglEngNm, String sTrdPartyNm, String sVndrCustDivCd, String sCustLglEngNm, String sSvrId, String sCurrCd, String sBkgFincDirCd) {
		this.sSrcVndrNo = sSrcVndrNo;
		this.sRegType = sRegType;
		this.sSkdVoyNo = sSkdVoyNo;
		this.sBkgNoAll = sBkgNoAll;
		this.sN3ptyBilTpCd = sN3ptyBilTpCd;
		this.sVslCd = sVslCd;
		this.sCustSeq = sCustSeq;
		this.sBkgNo = sBkgNo;
		this.sBlNoTp = sBlNoTp;
		this.sEqTpszCd = sEqTpszCd;
		this.sBlNoChk = sBlNoChk;
		this.sTrdPartyVal = sTrdPartyVal;
		this.fCmd = fCmd;
		this.ipage = ipage;
		this.sFileNo = sFileNo;
		this.pagerows = pagerows;
		this.sVndrCntCd = sVndrCntCd;
		this.sBlNo = sBlNo;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.sN3ptyOfcCd = sN3ptyOfcCd;
		this.sYdCd = sYdCd;
		this.sIfDt = sIfDt;
		this.sIfRmk = sIfRmk;
		this.sEdate = sEdate;
		this.sN3ptySrcNo = sN3ptySrcNo;
		this.sIfAmt = sIfAmt;
		this.sVndrSeq = sVndrSeq;
		this.sCustCntCd = sCustCntCd;
		this.sBlNoAll = sBlNoAll;
		this.sSdate = sSdate;
		this.sSrcVndrSeq = sSrcVndrSeq;
		this.sVvd = sVvd;
		this.sIfOfcCd = sIfOfcCd;
		this.sSkdDirCd = sSkdDirCd;
		this.eqTpszCd = eqTpszCd;
		this.sBilTpCd = sBilTpCd;
		this.sEqNo = sEqNo;
		this.sN3ptyIfTpCd = sN3ptyIfTpCd;
		this.sUserId = sUserId;
		this.sSrcVndrCntCd = sSrcVndrCntCd;
		this.ifAmt = ifAmt;
		this.sN3ptyExpnTpCd = sN3ptyExpnTpCd;
		this.eqTpCd = eqTpCd;
		this.eqKndCd = eqKndCd;
		this.sBkgNoSplit = sBkgNoSplit;
		this.sEqTpCd = sEqTpCd;
		this.sEqKndCd = sEqKndCd;
		this.sEdnTpCd = sEdnTpCd;
		this.sVndrLglEngNm = sVndrLglEngNm;
		this.sTrdPartyNm = sTrdPartyNm;
		this.sVndrCustDivCd = sVndrCustDivCd;
		this.sCustLglEngNm = sCustLglEngNm;
		this.sSvrId = sSvrId;
		this.sCurrCd = sCurrCd;
		this.sBkgFincDirCd = sBkgFincDirCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("s_src_vndr_no", getSSrcVndrNo());
		this.hashColumns.put("s_reg_type", getSRegType());
		this.hashColumns.put("s_skd_voy_no", getSSkdVoyNo());
		this.hashColumns.put("s_bkg_no_all", getSBkgNoAll());
		this.hashColumns.put("s_n3pty_bil_tp_cd", getSN3ptyBilTpCd());
		this.hashColumns.put("s_vsl_cd", getSVslCd());
		this.hashColumns.put("s_cust_seq", getSCustSeq());
		this.hashColumns.put("s_bkg_no", getSBkgNo());
		this.hashColumns.put("s_bl_no_tp", getSBlNoTp());
		this.hashColumns.put("s_eq_tpsz_cd", getSEqTpszCd());
		this.hashColumns.put("s_bl_no_chk", getSBlNoChk());
		this.hashColumns.put("s_trd_party_val", getSTrdPartyVal());
		this.hashColumns.put("f_cmd", getFCmd());
		this.hashColumns.put("ipage", getIpage());
		this.hashColumns.put("s_file_no", getSFileNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("s_vndr_cnt_cd", getSVndrCntCd());
		this.hashColumns.put("s_bl_no", getSBlNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("s_n3pty_ofc_cd", getSN3ptyOfcCd());
		this.hashColumns.put("s_yd_cd", getSYdCd());
		this.hashColumns.put("s_if_dt", getSIfDt());
		this.hashColumns.put("s_if_rmk", getSIfRmk());
		this.hashColumns.put("s_edate", getSEdate());
		this.hashColumns.put("s_n3pty_src_no", getSN3ptySrcNo());
		this.hashColumns.put("s_if_amt", getSIfAmt());
		this.hashColumns.put("s_vndr_seq", getSVndrSeq());
		this.hashColumns.put("s_cust_cnt_cd", getSCustCntCd());
		this.hashColumns.put("s_bl_no_all", getSBlNoAll());
		this.hashColumns.put("s_sdate", getSSdate());
		this.hashColumns.put("s_src_vndr_seq", getSSrcVndrSeq());
		this.hashColumns.put("s_vvd", getSVvd());
		this.hashColumns.put("s_if_ofc_cd", getSIfOfcCd());
		this.hashColumns.put("s_skd_dir_cd", getSSkdDirCd());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("s_bil_tp_cd", getSBilTpCd());
		this.hashColumns.put("s_eq_no", getSEqNo());
		this.hashColumns.put("s_n3pty_if_tp_cd", getSN3ptyIfTpCd());
		this.hashColumns.put("s_user_id", getSUserId());
		this.hashColumns.put("s_src_vndr_cnt_cd", getSSrcVndrCntCd());
		this.hashColumns.put("if_amt", getIfAmt());
		this.hashColumns.put("s_n3pty_expn_tp_cd", getSN3ptyExpnTpCd());
		this.hashColumns.put("eq_tp_cd", getEqTpCd());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("s_bkg_no_split", getSBkgNoSplit());
		this.hashColumns.put("s_eq_tp_cd", getSEqTpCd());
		this.hashColumns.put("s_eq_knd_cd", getSEqKndCd());
		this.hashColumns.put("s_edn_tp_cd", getSEdnTpCd());
		this.hashColumns.put("s_vndr_lgl_eng_nm", getSVndrLglEngNm());
		this.hashColumns.put("s_trd_party_nm", getSTrdPartyNm());
		this.hashColumns.put("s_vndr_cust_div_cd", getSVndrCustDivCd());
		this.hashColumns.put("s_cust_lgl_eng_nm", getSCustLglEngNm());
		this.hashColumns.put("s_svr_id", getSSvrId());
		this.hashColumns.put("s_curr_cd", getSCurrCd());
		this.hashColumns.put("s_bkg_finc_dir_cd", getSBkgFincDirCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("s_src_vndr_no", "sSrcVndrNo");
		this.hashFields.put("s_reg_type", "sRegType");
		this.hashFields.put("s_skd_voy_no", "sSkdVoyNo");
		this.hashFields.put("s_bkg_no_all", "sBkgNoAll");
		this.hashFields.put("s_n3pty_bil_tp_cd", "sN3ptyBilTpCd");
		this.hashFields.put("s_vsl_cd", "sVslCd");
		this.hashFields.put("s_cust_seq", "sCustSeq");
		this.hashFields.put("s_bkg_no", "sBkgNo");
		this.hashFields.put("s_bl_no_tp", "sBlNoTp");
		this.hashFields.put("s_eq_tpsz_cd", "sEqTpszCd");
		this.hashFields.put("s_bl_no_chk", "sBlNoChk");
		this.hashFields.put("s_trd_party_val", "sTrdPartyVal");
		this.hashFields.put("f_cmd", "fCmd");
		this.hashFields.put("ipage", "ipage");
		this.hashFields.put("s_file_no", "sFileNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("s_vndr_cnt_cd", "sVndrCntCd");
		this.hashFields.put("s_bl_no", "sBlNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("s_n3pty_ofc_cd", "sN3ptyOfcCd");
		this.hashFields.put("s_yd_cd", "sYdCd");
		this.hashFields.put("s_if_dt", "sIfDt");
		this.hashFields.put("s_if_rmk", "sIfRmk");
		this.hashFields.put("s_edate", "sEdate");
		this.hashFields.put("s_n3pty_src_no", "sN3ptySrcNo");
		this.hashFields.put("s_if_amt", "sIfAmt");
		this.hashFields.put("s_vndr_seq", "sVndrSeq");
		this.hashFields.put("s_cust_cnt_cd", "sCustCntCd");
		this.hashFields.put("s_bl_no_all", "sBlNoAll");
		this.hashFields.put("s_sdate", "sSdate");
		this.hashFields.put("s_src_vndr_seq", "sSrcVndrSeq");
		this.hashFields.put("s_vvd", "sVvd");
		this.hashFields.put("s_if_ofc_cd", "sIfOfcCd");
		this.hashFields.put("s_skd_dir_cd", "sSkdDirCd");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("s_bil_tp_cd", "sBilTpCd");
		this.hashFields.put("s_eq_no", "sEqNo");
		this.hashFields.put("s_n3pty_if_tp_cd", "sN3ptyIfTpCd");
		this.hashFields.put("s_user_id", "sUserId");
		this.hashFields.put("s_src_vndr_cnt_cd", "sSrcVndrCntCd");
		this.hashFields.put("if_amt", "ifAmt");
		this.hashFields.put("s_n3pty_expn_tp_cd", "sN3ptyExpnTpCd");
		this.hashFields.put("eq_tp_cd", "eqTpCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("s_bkg_no_split", "sBkgNoSplit");
		this.hashFields.put("s_eq_tp_cd", "sEqTpCd");
		this.hashFields.put("s_eq_knd_cd", "sEqKndCd");
		this.hashFields.put("s_edn_tp_cd", "sEdnTpCd");
		this.hashFields.put("s_vndr_lgl_eng_nm", "sVndrLglEngNm");
		this.hashFields.put("s_trd_party_nm", "sTrdPartyNm");
		this.hashFields.put("s_vndr_cust_div_cd", "sVndrCustDivCd");
		this.hashFields.put("s_cust_lgl_eng_nm", "sCustLglEngNm");
		this.hashFields.put("s_svr_id", "sSvrId");
		this.hashFields.put("s_curr_cd", "sCurrCd");
		this.hashFields.put("s_bkg_finc_dir_cd", "sBkgFincDirCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sSrcVndrNo
	 */
	public String getSSrcVndrNo() {
		return this.sSrcVndrNo;
	}
	
	/**
	 * Column Info
	 * @return sRegType
	 */
	public String getSRegType() {
		return this.sRegType;
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
	 * @return sBkgNoAll
	 */
	public String getSBkgNoAll() {
		return this.sBkgNoAll;
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
	 * @return sVslCd
	 */
	public String getSVslCd() {
		return this.sVslCd;
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
	 * @return sBkgNo
	 */
	public String getSBkgNo() {
		return this.sBkgNo;
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
	 * @return sEqTpszCd
	 */
	public String getSEqTpszCd() {
		return this.sEqTpszCd;
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
	 * @return ipage
	 */
	public String getIpage() {
		return this.ipage;
	}
	
	/**
	 * Column Info
	 * @return sFileNo
	 */
	public String getSFileNo() {
		return this.sFileNo;
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
	 * @return sVndrCntCd
	 */
	public String getSVndrCntCd() {
		return this.sVndrCntCd;
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
	 * @return sYdCd
	 */
	public String getSYdCd() {
		return this.sYdCd;
	}
	
	/**
	 * Column Info
	 * @return sIfDt
	 */
	public String getSIfDt() {
		return this.sIfDt;
	}
	
	/**
	 * Column Info
	 * @return sIfRmk
	 */
	public String getSIfRmk() {
		return this.sIfRmk;
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
	 * @return sN3ptySrcNo
	 */
	public String getSN3ptySrcNo() {
		return this.sN3ptySrcNo;
	}
	
	/**
	 * Column Info
	 * @return sIfAmt
	 */
	public String getSIfAmt() {
		return this.sIfAmt;
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
	 * @return sSdate
	 */
	public String getSSdate() {
		return this.sSdate;
	}
	
	/**
	 * Column Info
	 * @return sSrcVndrSeq
	 */
	public String getSSrcVndrSeq() {
		return this.sSrcVndrSeq;
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
	 * @return sIfOfcCd
	 */
	public String getSIfOfcCd() {
		return this.sIfOfcCd;
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
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @return sBilTpCd
	 */
	public String getSBilTpCd() {
		return this.sBilTpCd;
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
	 * @return sN3ptyIfTpCd
	 */
	public String getSN3ptyIfTpCd() {
		return this.sN3ptyIfTpCd;
	}
	
	/**
	 * Column Info
	 * @return sUserId
	 */
	public String getSUserId() {
		return this.sUserId;
	}
	
	/**
	 * Column Info
	 * @return sSrcVndrCntCd
	 */
	public String getSSrcVndrCntCd() {
		return this.sSrcVndrCntCd;
	}
	
	/**
	 * Column Info
	 * @return ifAmt
	 */
	public String getIfAmt() {
		return this.ifAmt;
	}
	
	/**
	 * Column Info
	 * @return sN3ptyExpnTpCd
	 */
	public String getSN3ptyExpnTpCd() {
		return this.sN3ptyExpnTpCd;
	}
	
	/**
	 * Column Info
	 * @return eqTpCd
	 */
	public String getEqTpCd() {
		return this.eqTpCd;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
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
	 * @return sEqTpCd
	 */
	public String getSEqTpCd() {
		return this.sEqTpCd;
	}
	
	/**
	 * Column Info
	 * @return sEqKndCd
	 */
	public String getSEqKndCd() {
		return this.sEqKndCd;
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
	 * @return sVndrLglEngNm
	 */
	public String getSVndrLglEngNm() {
		return this.sVndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return sTrdPartyNm
	 */
	public String getSTrdPartyNm() {
		return this.sTrdPartyNm;
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
	 * @return sCustLglEngNm
	 */
	public String getSCustLglEngNm() {
		return this.sCustLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return sSvrId
	 */
	public String getSSvrId() {
		return this.sSvrId;
	}
	
	/**
	 * Column Info
	 * @return sCurrCd
	 */
	public String getSCurrCd() {
		return this.sCurrCd;
	}
	
	/**
	 * Column Info
	 * @return sBkgFincDirCd
	 */
	public String getSBkgFincDirCd() {
		return this.sBkgFincDirCd;
	}
	
	/**
	 * Column Info
	 * @param sSrcVndrNo
	 */
	public void setSSrcVndrNo(String sSrcVndrNo) {
		this.sSrcVndrNo = sSrcVndrNo;
	}
	
	/**
	 * Column Info
	 * @param sRegType
	 */
	public void setSRegType(String sRegType) {
		this.sRegType = sRegType;
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
	 * @param sBkgNoAll
	 */
	public void setSBkgNoAll(String sBkgNoAll) {
		this.sBkgNoAll = sBkgNoAll;
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
	 * @param sVslCd
	 */
	public void setSVslCd(String sVslCd) {
		this.sVslCd = sVslCd;
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
	 * @param sBkgNo
	 */
	public void setSBkgNo(String sBkgNo) {
		this.sBkgNo = sBkgNo;
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
	 * @param sEqTpszCd
	 */
	public void setSEqTpszCd(String sEqTpszCd) {
		this.sEqTpszCd = sEqTpszCd;
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
	 * @param ipage
	 */
	public void setIpage(String ipage) {
		this.ipage = ipage;
	}
	
	/**
	 * Column Info
	 * @param sFileNo
	 */
	public void setSFileNo(String sFileNo) {
		this.sFileNo = sFileNo;
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
	 * @param sVndrCntCd
	 */
	public void setSVndrCntCd(String sVndrCntCd) {
		this.sVndrCntCd = sVndrCntCd;
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
	 * @param sYdCd
	 */
	public void setSYdCd(String sYdCd) {
		this.sYdCd = sYdCd;
	}
	
	/**
	 * Column Info
	 * @param sIfDt
	 */
	public void setSIfDt(String sIfDt) {
		this.sIfDt = sIfDt;
	}
	
	/**
	 * Column Info
	 * @param sIfRmk
	 */
	public void setSIfRmk(String sIfRmk) {
		this.sIfRmk = sIfRmk;
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
	 * @param sN3ptySrcNo
	 */
	public void setSN3ptySrcNo(String sN3ptySrcNo) {
		this.sN3ptySrcNo = sN3ptySrcNo;
	}
	
	/**
	 * Column Info
	 * @param sIfAmt
	 */
	public void setSIfAmt(String sIfAmt) {
		this.sIfAmt = sIfAmt;
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
	 * @param sSdate
	 */
	public void setSSdate(String sSdate) {
		this.sSdate = sSdate;
	}
	
	/**
	 * Column Info
	 * @param sSrcVndrSeq
	 */
	public void setSSrcVndrSeq(String sSrcVndrSeq) {
		this.sSrcVndrSeq = sSrcVndrSeq;
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
	 * @param sIfOfcCd
	 */
	public void setSIfOfcCd(String sIfOfcCd) {
		this.sIfOfcCd = sIfOfcCd;
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
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @param sBilTpCd
	 */
	public void setSBilTpCd(String sBilTpCd) {
		this.sBilTpCd = sBilTpCd;
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
	 * @param sN3ptyIfTpCd
	 */
	public void setSN3ptyIfTpCd(String sN3ptyIfTpCd) {
		this.sN3ptyIfTpCd = sN3ptyIfTpCd;
	}
	
	/**
	 * Column Info
	 * @param sUserId
	 */
	public void setSUserId(String sUserId) {
		this.sUserId = sUserId;
	}
	
	/**
	 * Column Info
	 * @param sSrcVndrCntCd
	 */
	public void setSSrcVndrCntCd(String sSrcVndrCntCd) {
		this.sSrcVndrCntCd = sSrcVndrCntCd;
	}
	
	/**
	 * Column Info
	 * @param ifAmt
	 */
	public void setIfAmt(String ifAmt) {
		this.ifAmt = ifAmt;
	}
	
	/**
	 * Column Info
	 * @param sN3ptyExpnTpCd
	 */
	public void setSN3ptyExpnTpCd(String sN3ptyExpnTpCd) {
		this.sN3ptyExpnTpCd = sN3ptyExpnTpCd;
	}
	
	/**
	 * Column Info
	 * @param eqTpCd
	 */
	public void setEqTpCd(String eqTpCd) {
		this.eqTpCd = eqTpCd;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
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
	 * @param sEqTpCd
	 */
	public void setSEqTpCd(String sEqTpCd) {
		this.sEqTpCd = sEqTpCd;
	}
	
	/**
	 * Column Info
	 * @param sEqKndCd
	 */
	public void setSEqKndCd(String sEqKndCd) {
		this.sEqKndCd = sEqKndCd;
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
	 * @param sVndrLglEngNm
	 */
	public void setSVndrLglEngNm(String sVndrLglEngNm) {
		this.sVndrLglEngNm = sVndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param sTrdPartyNm
	 */
	public void setSTrdPartyNm(String sTrdPartyNm) {
		this.sTrdPartyNm = sTrdPartyNm;
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
	 * @param sCustLglEngNm
	 */
	public void setSCustLglEngNm(String sCustLglEngNm) {
		this.sCustLglEngNm = sCustLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param sSvrId
	 */
	public void setSSvrId(String sSvrId) {
		this.sSvrId = sSvrId;
	}
	
	/**
	 * Column Info
	 * @param sCurrCd
	 */
	public void setSCurrCd(String sCurrCd) {
		this.sCurrCd = sCurrCd;
	}
	
	/**
	 * Column Info
	 * @param sBkgFincDirCd
	 */
	public void setSBkgFincDirCd(String sBkgFincDirCd) {
		this.sBkgFincDirCd = sBkgFincDirCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSSrcVndrNo(JSPUtil.getParameter(request, "s_src_vndr_no", ""));
		setSRegType(JSPUtil.getParameter(request, "s_reg_type", ""));
		setSSkdVoyNo(JSPUtil.getParameter(request, "s_skd_voy_no", ""));
		setSBkgNoAll(JSPUtil.getParameter(request, "s_bkg_no_all", ""));
		setSN3ptyBilTpCd(JSPUtil.getParameter(request, "s_n3pty_bil_tp_cd", ""));
		setSVslCd(JSPUtil.getParameter(request, "s_vsl_cd", ""));
		setSCustSeq(JSPUtil.getParameter(request, "s_cust_seq", ""));
		setSBkgNo(JSPUtil.getParameter(request, "s_bkg_no", ""));
		setSBlNoTp(JSPUtil.getParameter(request, "s_bl_no_tp", ""));
		setSEqTpszCd(JSPUtil.getParameter(request, "s_eq_tpsz_cd", ""));
		setSBlNoChk(JSPUtil.getParameter(request, "s_bl_no_chk", ""));
		setSTrdPartyVal(JSPUtil.getParameter(request, "s_trd_party_val", ""));
		setFCmd(JSPUtil.getParameter(request, "f_cmd", ""));
		setIpage(JSPUtil.getParameter(request, "ipage", ""));
		setSFileNo(JSPUtil.getParameter(request, "s_file_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSVndrCntCd(JSPUtil.getParameter(request, "s_vndr_cnt_cd", ""));
		setSBlNo(JSPUtil.getParameter(request, "s_bl_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setSN3ptyOfcCd(JSPUtil.getParameter(request, "s_n3pty_ofc_cd", ""));
		setSYdCd(JSPUtil.getParameter(request, "s_yd_cd", ""));
		setSIfDt(JSPUtil.getParameter(request, "s_if_dt", ""));
		setSIfRmk(JSPUtil.getParameter(request, "s_if_rmk", ""));
		setSEdate(JSPUtil.getParameter(request, "s_edate", ""));
		setSN3ptySrcNo(JSPUtil.getParameter(request, "s_n3pty_src_no", ""));
		setSIfAmt(JSPUtil.getParameter(request, "s_if_amt", ""));
		setSVndrSeq(JSPUtil.getParameter(request, "s_vndr_seq", ""));
		setSCustCntCd(JSPUtil.getParameter(request, "s_cust_cnt_cd", ""));
		setSBlNoAll(JSPUtil.getParameter(request, "s_bl_no_all", ""));
		setSSdate(JSPUtil.getParameter(request, "s_sdate", ""));
		setSSrcVndrSeq(JSPUtil.getParameter(request, "s_src_vndr_seq", ""));
		setSVvd(JSPUtil.getParameter(request, "s_vvd", ""));
		setSIfOfcCd(JSPUtil.getParameter(request, "s_if_ofc_cd", ""));
		setSSkdDirCd(JSPUtil.getParameter(request, "s_skd_dir_cd", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setSBilTpCd(JSPUtil.getParameter(request, "s_bil_tp_cd", ""));
		setSEqNo(JSPUtil.getParameter(request, "s_eq_no", ""));
		setSN3ptyIfTpCd(JSPUtil.getParameter(request, "s_n3pty_if_tp_cd", ""));
		setSUserId(JSPUtil.getParameter(request, "s_user_id", ""));
		setSSrcVndrCntCd(JSPUtil.getParameter(request, "s_src_vndr_cnt_cd", ""));
		setIfAmt(JSPUtil.getParameter(request, "if_amt", ""));
		setSN3ptyExpnTpCd(JSPUtil.getParameter(request, "s_n3pty_expn_tp_cd", ""));
		setEqTpCd(JSPUtil.getParameter(request, "eq_tp_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setSBkgNoSplit(JSPUtil.getParameter(request, "s_bkg_no_split", ""));
		setSEqTpCd(JSPUtil.getParameter(request, "s_eq_tp_cd", ""));
		setSEqKndCd(JSPUtil.getParameter(request, "s_eq_knd_cd", ""));
		setSEdnTpCd(JSPUtil.getParameter(request, "s_edn_tp_cd", ""));
		setSVndrLglEngNm(JSPUtil.getParameter(request, "s_vndr_lgl_eng_nm", ""));
		setSTrdPartyNm(JSPUtil.getParameter(request, "s_trd_party_nm", ""));
		setSVndrCustDivCd(JSPUtil.getParameter(request, "s_vndr_cust_div_cd", ""));
		setSCustLglEngNm(JSPUtil.getParameter(request, "s_cust_lgl_eng_nm", ""));
		setSSvrId(JSPUtil.getParameter(request, "s_svr_id", ""));
		setSCurrCd(JSPUtil.getParameter(request, "s_curr_cd", ""));
		setSBkgFincDirCd(JSPUtil.getParameter(request, "s_bkg_finc_dir_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CreateEACRegistrationVO[]
	 */
	public CreateEACRegistrationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CreateEACRegistrationVO[]
	 */
	public CreateEACRegistrationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CreateEACRegistrationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sSrcVndrNo = (JSPUtil.getParameter(request, prefix	+ "s_src_vndr_no", length));
			String[] sRegType = (JSPUtil.getParameter(request, prefix	+ "s_reg_type", length));
			String[] sSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "s_skd_voy_no", length));
			String[] sBkgNoAll = (JSPUtil.getParameter(request, prefix	+ "s_bkg_no_all", length));
			String[] sN3ptyBilTpCd = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_bil_tp_cd", length));
			String[] sVslCd = (JSPUtil.getParameter(request, prefix	+ "s_vsl_cd", length));
			String[] sCustSeq = (JSPUtil.getParameter(request, prefix	+ "s_cust_seq", length));
			String[] sBkgNo = (JSPUtil.getParameter(request, prefix	+ "s_bkg_no", length));
			String[] sBlNoTp = (JSPUtil.getParameter(request, prefix	+ "s_bl_no_tp", length));
			String[] sEqTpszCd = (JSPUtil.getParameter(request, prefix	+ "s_eq_tpsz_cd", length));
			String[] sBlNoChk = (JSPUtil.getParameter(request, prefix	+ "s_bl_no_chk", length));
			String[] sTrdPartyVal = (JSPUtil.getParameter(request, prefix	+ "s_trd_party_val", length));
			String[] fCmd = (JSPUtil.getParameter(request, prefix	+ "f_cmd", length));
			String[] ipage = (JSPUtil.getParameter(request, prefix	+ "ipage", length));
			String[] sFileNo = (JSPUtil.getParameter(request, prefix	+ "s_file_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] sVndrCntCd = (JSPUtil.getParameter(request, prefix	+ "s_vndr_cnt_cd", length));
			String[] sBlNo = (JSPUtil.getParameter(request, prefix	+ "s_bl_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] sN3ptyOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_ofc_cd", length));
			String[] sYdCd = (JSPUtil.getParameter(request, prefix	+ "s_yd_cd", length));
			String[] sIfDt = (JSPUtil.getParameter(request, prefix	+ "s_if_dt", length));
			String[] sIfRmk = (JSPUtil.getParameter(request, prefix	+ "s_if_rmk", length));
			String[] sEdate = (JSPUtil.getParameter(request, prefix	+ "s_edate", length));
			String[] sN3ptySrcNo = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_src_no", length));
			String[] sIfAmt = (JSPUtil.getParameter(request, prefix	+ "s_if_amt", length));
			String[] sVndrSeq = (JSPUtil.getParameter(request, prefix	+ "s_vndr_seq", length));
			String[] sCustCntCd = (JSPUtil.getParameter(request, prefix	+ "s_cust_cnt_cd", length));
			String[] sBlNoAll = (JSPUtil.getParameter(request, prefix	+ "s_bl_no_all", length));
			String[] sSdate = (JSPUtil.getParameter(request, prefix	+ "s_sdate", length));
			String[] sSrcVndrSeq = (JSPUtil.getParameter(request, prefix	+ "s_src_vndr_seq", length));
			String[] sVvd = (JSPUtil.getParameter(request, prefix	+ "s_vvd", length));
			String[] sIfOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_if_ofc_cd", length));
			String[] sSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "s_skd_dir_cd", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] sBilTpCd = (JSPUtil.getParameter(request, prefix	+ "s_bil_tp_cd", length));
			String[] sEqNo = (JSPUtil.getParameter(request, prefix	+ "s_eq_no", length));
			String[] sN3ptyIfTpCd = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_if_tp_cd", length));
			String[] sUserId = (JSPUtil.getParameter(request, prefix	+ "s_user_id", length));
			String[] sSrcVndrCntCd = (JSPUtil.getParameter(request, prefix	+ "s_src_vndr_cnt_cd", length));
			String[] ifAmt = (JSPUtil.getParameter(request, prefix	+ "if_amt", length));
			String[] sN3ptyExpnTpCd = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_expn_tp_cd", length));
			String[] eqTpCd = (JSPUtil.getParameter(request, prefix	+ "eq_tp_cd", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] sBkgNoSplit = (JSPUtil.getParameter(request, prefix	+ "s_bkg_no_split", length));
			String[] sEqTpCd = (JSPUtil.getParameter(request, prefix	+ "s_eq_tp_cd", length));
			String[] sEqKndCd = (JSPUtil.getParameter(request, prefix	+ "s_eq_knd_cd", length));
			String[] sEdnTpCd = (JSPUtil.getParameter(request, prefix	+ "s_edn_tp_cd", length));
			String[] sVndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "s_vndr_lgl_eng_nm", length));
			String[] sTrdPartyNm = (JSPUtil.getParameter(request, prefix	+ "s_trd_party_nm", length));
			String[] sVndrCustDivCd = (JSPUtil.getParameter(request, prefix	+ "s_vndr_cust_div_cd", length));
			String[] sCustLglEngNm = (JSPUtil.getParameter(request, prefix	+ "s_cust_lgl_eng_nm", length));
			String[] sSvrId = (JSPUtil.getParameter(request, prefix	+ "s_svr_id", length));
			String[] sCurrCd = (JSPUtil.getParameter(request, prefix	+ "s_curr_cd", length));
			String[] sBkgFincDirCd = (JSPUtil.getParameter(request, prefix	+ "s_bkg_finc_dir_cd", length));
	
			for (int i = 0; i < length; i++) {
				model = new CreateEACRegistrationVO();
				if (sSrcVndrNo[i] != null)
					model.setSSrcVndrNo(sSrcVndrNo[i]);
				if (sRegType[i] != null)
					model.setSRegType(sRegType[i]);
				if (sSkdVoyNo[i] != null)
					model.setSSkdVoyNo(sSkdVoyNo[i]);
				if (sBkgNoAll[i] != null)
					model.setSBkgNoAll(sBkgNoAll[i]);
				if (sN3ptyBilTpCd[i] != null)
					model.setSN3ptyBilTpCd(sN3ptyBilTpCd[i]);
				if (sVslCd[i] != null)
					model.setSVslCd(sVslCd[i]);
				if (sCustSeq[i] != null)
					model.setSCustSeq(sCustSeq[i]);
				if (sBkgNo[i] != null)
					model.setSBkgNo(sBkgNo[i]);
				if (sBlNoTp[i] != null)
					model.setSBlNoTp(sBlNoTp[i]);
				if (sEqTpszCd[i] != null)
					model.setSEqTpszCd(sEqTpszCd[i]);
				if (sBlNoChk[i] != null)
					model.setSBlNoChk(sBlNoChk[i]);
				if (sTrdPartyVal[i] != null)
					model.setSTrdPartyVal(sTrdPartyVal[i]);
				if (fCmd[i] != null)
					model.setFCmd(fCmd[i]);
				if (ipage[i] != null)
					model.setIpage(ipage[i]);
				if (sFileNo[i] != null)
					model.setSFileNo(sFileNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (sVndrCntCd[i] != null)
					model.setSVndrCntCd(sVndrCntCd[i]);
				if (sBlNo[i] != null)
					model.setSBlNo(sBlNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (sN3ptyOfcCd[i] != null)
					model.setSN3ptyOfcCd(sN3ptyOfcCd[i]);
				if (sYdCd[i] != null)
					model.setSYdCd(sYdCd[i]);
				if (sIfDt[i] != null)
					model.setSIfDt(sIfDt[i]);
				if (sIfRmk[i] != null)
					model.setSIfRmk(sIfRmk[i]);
				if (sEdate[i] != null)
					model.setSEdate(sEdate[i]);
				if (sN3ptySrcNo[i] != null)
					model.setSN3ptySrcNo(sN3ptySrcNo[i]);
				if (sIfAmt[i] != null)
					model.setSIfAmt(sIfAmt[i]);
				if (sVndrSeq[i] != null)
					model.setSVndrSeq(sVndrSeq[i]);
				if (sCustCntCd[i] != null)
					model.setSCustCntCd(sCustCntCd[i]);
				if (sBlNoAll[i] != null)
					model.setSBlNoAll(sBlNoAll[i]);
				if (sSdate[i] != null)
					model.setSSdate(sSdate[i]);
				if (sSrcVndrSeq[i] != null)
					model.setSSrcVndrSeq(sSrcVndrSeq[i]);
				if (sVvd[i] != null)
					model.setSVvd(sVvd[i]);
				if (sIfOfcCd[i] != null)
					model.setSIfOfcCd(sIfOfcCd[i]);
				if (sSkdDirCd[i] != null)
					model.setSSkdDirCd(sSkdDirCd[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (sBilTpCd[i] != null)
					model.setSBilTpCd(sBilTpCd[i]);
				if (sEqNo[i] != null)
					model.setSEqNo(sEqNo[i]);
				if (sN3ptyIfTpCd[i] != null)
					model.setSN3ptyIfTpCd(sN3ptyIfTpCd[i]);
				if (sUserId[i] != null)
					model.setSUserId(sUserId[i]);
				if (sSrcVndrCntCd[i] != null)
					model.setSSrcVndrCntCd(sSrcVndrCntCd[i]);
				if (ifAmt[i] != null)
					model.setIfAmt(ifAmt[i]);
				if (sN3ptyExpnTpCd[i] != null)
					model.setSN3ptyExpnTpCd(sN3ptyExpnTpCd[i]);
				if (eqTpCd[i] != null)
					model.setEqTpCd(eqTpCd[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (sBkgNoSplit[i] != null)
					model.setSBkgNoSplit(sBkgNoSplit[i]);
				if (sEqTpCd[i] != null)
					model.setSEqTpCd(sEqTpCd[i]);
				if (sEqKndCd[i] != null)
					model.setSEqKndCd(sEqKndCd[i]);
				if (sEdnTpCd[i] != null)
					model.setSEdnTpCd(sEdnTpCd[i]);
				if (sVndrLglEngNm[i] != null)
					model.setSVndrLglEngNm(sVndrLglEngNm[i]);
				if (sTrdPartyNm[i] != null)
					model.setSTrdPartyNm(sTrdPartyNm[i]);
				if (sVndrCustDivCd[i] != null)
					model.setSVndrCustDivCd(sVndrCustDivCd[i]);
				if (sCustLglEngNm[i] != null)
					model.setSCustLglEngNm(sCustLglEngNm[i]);
				if (sSvrId[i] != null)
					model.setSSvrId(sSvrId[i]);
				if (sCurrCd[i] != null)
					model.setSCurrCd(sCurrCd[i]);
				if (sBkgFincDirCd[i] != null)
					model.setSBkgFincDirCd(sBkgFincDirCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCreateEACRegistrationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CreateEACRegistrationVO[]
	 */
	public CreateEACRegistrationVO[] getCreateEACRegistrationVOs(){
		CreateEACRegistrationVO[] vos = (CreateEACRegistrationVO[])models.toArray(new CreateEACRegistrationVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.sSrcVndrNo = this.sSrcVndrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRegType = this.sRegType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSkdVoyNo = this.sSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBkgNoAll = this.sBkgNoAll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyBilTpCd = this.sN3ptyBilTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVslCd = this.sVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustSeq = this.sCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBkgNo = this.sBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBlNoTp = this.sBlNoTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEqTpszCd = this.sEqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBlNoChk = this.sBlNoChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTrdPartyVal = this.sTrdPartyVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCmd = this.fCmd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ipage = this.ipage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sFileNo = this.sFileNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVndrCntCd = this.sVndrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBlNo = this.sBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyOfcCd = this.sN3ptyOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sYdCd = this.sYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIfDt = this.sIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIfRmk = this.sIfRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEdate = this.sEdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptySrcNo = this.sN3ptySrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIfAmt = this.sIfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVndrSeq = this.sVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustCntCd = this.sCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBlNoAll = this.sBlNoAll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSdate = this.sSdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSrcVndrSeq = this.sSrcVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVvd = this.sVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIfOfcCd = this.sIfOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSkdDirCd = this.sSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBilTpCd = this.sBilTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEqNo = this.sEqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyIfTpCd = this.sN3ptyIfTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sUserId = this.sUserId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSrcVndrCntCd = this.sSrcVndrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifAmt = this.ifAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyExpnTpCd = this.sN3ptyExpnTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpCd = this.eqTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBkgNoSplit = this.sBkgNoSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEqTpCd = this.sEqTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEqKndCd = this.sEqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEdnTpCd = this.sEdnTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVndrLglEngNm = this.sVndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTrdPartyNm = this.sTrdPartyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVndrLglEngNm = this.sVndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustLglEngNm = this.sCustLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSvrId = this.sSvrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCurrCd = this.sCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBkgFincDirCd = this.sBkgFincDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
