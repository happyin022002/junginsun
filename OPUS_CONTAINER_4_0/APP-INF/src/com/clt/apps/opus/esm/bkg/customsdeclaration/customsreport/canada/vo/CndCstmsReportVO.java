/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CndCstmsReportVO.java
*@FileTitle : CndCstmsReportVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.26
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.11.26 김민정 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.canada.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.CstmsReportVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CndCstmsReportVO extends CstmsReportVO {

	private static final long serialVersionUID = 1L;
	private List<String> blNoList = null;

	/**
	 * Column Info
	 * @return blNoList
	 */
	public List<String> getBlNoList() {
		return this.blNoList;
	}
	
	/**
	 * Column Info
	 * @param blNoList
	 */
	public void setBlNoList(List<String> blNoList) {
		this.blNoList = blNoList;
	}

	private List<String> showPuFlgList = null;

	/**
	 * Column Info
	 * @return showPuFlgList
	 */
	public List<String> getShowPuFlgList() {
		return this.showPuFlgList;
	}
	
	/**
	 * Column Info
	 * @param showPuFlgList
	 */
	public void setShowPuFlgList(List<String> showPuFlgList) {
		this.showPuFlgList = showPuFlgList;
	}
	
	
	private Collection<CndCstmsReportVO> models = new ArrayList<CndCstmsReportVO>();
	
	/* Column Info */
	private String faxNo1 = null;
	/* Column Info */
	private String pMibNo = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String emlSndDt = null;
	/* Column Info */
	private String faxNo5 = null;
	/* Column Info */
	private String faxNo4 = null;
	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String faxNo3 = null;
	/* Column Info */
	private String faxNo2 = null;
	/* Column Info */
	private String faxSndFlg3 = null;
	/* Column Info */
	private String faxSndFlg4 = null;
	/* Column Info */
	private String faxSndFlg1 = null;
	/* Column Info */
	private String faxSndFlg2 = null;
	/* Column Info */
	private String faxSndUsrId = null;
	/* Column Info */
	private String itChk = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String emlProcStsCd = null;
	/* Column Info */
	private String emlSndUsrNm = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String trspModId = null;
	/* Column Info */
	private String faxOfcCd = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String bkgCustTpCd = null;
	/* Column Info */
	private String attachFlg = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String emlSndUsrId = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String chkFlg = null;
	/* Column Info */
	private String attachMaxCnt = null;
	/* Column Info */
	private String chk = null;
	/* Column Info */
	private String faxSndFlg5 = null;
	/* Column Info */
	private String faxProcStsCd = null;
	/* Column Info */
	private String faxFlg3 = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String faxFlg2 = null;
	/* Column Info */
	private String faxFlg1 = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String emlSndFlg5 = null;
	/* Column Info */
	private String emlSndFlg4 = null;
	/* Column Info */
	private String emlSndFlg1 = null;
	/* Column Info */
	private String avcNoteTpId = null;
	/* Column Info */
	private String emlSndFlg3 = null;
	/* Column Info */
	private String emlSndFlg2 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String emlFlg2 = null;
	/* Column Info */
	private String emlFlg1 = null;
	/* Column Info */
	private String emlFlg4 = null;
	/* Column Info */
	private String emlFlg3 = null;
	/* Column Info */
	private String emlFlg5 = null;
	/* Column Info */
	private String itNoCntrCnt = null;
	/* Column Info */
	private String faxFlg4 = null;
	/* Column Info */
	private String faxFlg5 = null;
	/* Column Info */
	private String faxSndUsrNm = null;
	/* Column Info */
	private String custCntcTpCd1 = null;
	/* Column Info */
	private String ntcEml1 = null;
	/* Column Info */
	private String ntcEml2 = null;
	/* Column Info */
	private String ntcEml3 = null;
	/* Column Info */
	private String ntcEml4 = null;
	/* Column Info */
	private String ntcEml5 = null;
	/* Column Info */
	private String custCntcTpCd3 = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String custCntcTpCd2 = null;
	/* Column Info */
	private String custCntcTpCd5 = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String custCntcTpCd4 = null;
	/* Column Info */
	private String blCntrCnt = null;
	/* Column Info */
	private String ibdLocGdsDesc = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String faxSndDt = null;
	/* Column Info */
	private String hubLocCd = null;
	/* Column Info */
	private String showPuFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CndCstmsReportVO() {}

	public CndCstmsReportVO(String ibflag, String pagerows, String cntCd, String blNo, String bkgNo, String porCd, String polCd, String podCd, String delCd, String hubLocCd, String trspModId, String ibdLocGdsDesc, String avcNoteTpId, String faxOfcCd, String vslCd, String skdVoyNo, String skdDirCd, String itChk, String pMibNo, String blCntrCnt, String itNoCntrCnt, String custSeq, String custNm, String faxNo1, String faxNo2, String faxNo3, String faxNo4, String faxNo5, String faxSndFlg1, String faxSndFlg2, String faxSndFlg3, String faxSndFlg4, String faxSndFlg5, String faxSndDt, String ntcEml1, String ntcEml2, String ntcEml3, String ntcEml4, String ntcEml5, String emlSndFlg1, String emlSndFlg2, String emlSndFlg3, String emlSndFlg4, String emlSndFlg5, String emlSndDt, String faxSndUsrId, String emlSndUsrId, String faxSndUsrNm, String emlSndUsrNm, String faxProcStsCd, String emlProcStsCd, String chkFlg, String etaDt, String faxFlg1, String faxFlg2, String faxFlg3, String faxFlg4, String faxFlg5, String emlFlg1, String emlFlg2, String emlFlg3, String emlFlg4, String emlFlg5, String custCntcTpCd1, String custCntcTpCd2, String custCntcTpCd3, String custCntcTpCd4, String custCntcTpCd5, String cntrNo, String chk, String attachMaxCnt, String attachFlg, String bkgCustTpCd, String showPuFlg) {
		this.faxNo1 = faxNo1;
		this.pMibNo = pMibNo;
		this.vslCd = vslCd;
		this.emlSndDt = emlSndDt;
		this.faxNo5 = faxNo5;
		this.faxNo4 = faxNo4;
		this.etaDt = etaDt;
		this.faxNo3 = faxNo3;
		this.faxNo2 = faxNo2;
		this.faxSndFlg3 = faxSndFlg3;
		this.faxSndFlg4 = faxSndFlg4;
		this.faxSndFlg1 = faxSndFlg1;
		this.faxSndFlg2 = faxSndFlg2;
		this.faxSndUsrId = faxSndUsrId;
		this.itChk = itChk;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.emlProcStsCd = emlProcStsCd;
		this.emlSndUsrNm = emlSndUsrNm;
		this.polCd = polCd;
		this.trspModId = trspModId;
		this.faxOfcCd = faxOfcCd;
		this.cntCd = cntCd;
		this.bkgCustTpCd = bkgCustTpCd;
		this.attachFlg = attachFlg;
		this.delCd = delCd;
		this.skdVoyNo = skdVoyNo;
		this.emlSndUsrId = emlSndUsrId;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.chkFlg = chkFlg;
		this.attachMaxCnt = attachMaxCnt;
		this.chk = chk;
		this.faxSndFlg5 = faxSndFlg5;
		this.faxProcStsCd = faxProcStsCd;
		this.faxFlg3 = faxFlg3;
		this.porCd = porCd;
		this.faxFlg2 = faxFlg2;
		this.faxFlg1 = faxFlg1;
		this.custNm = custNm;
		this.emlSndFlg5 = emlSndFlg5;
		this.emlSndFlg4 = emlSndFlg4;
		this.emlSndFlg1 = emlSndFlg1;
		this.avcNoteTpId = avcNoteTpId;
		this.emlSndFlg3 = emlSndFlg3;
		this.emlSndFlg2 = emlSndFlg2;
		this.ibflag = ibflag;
		this.emlFlg2 = emlFlg2;
		this.emlFlg1 = emlFlg1;
		this.emlFlg4 = emlFlg4;
		this.emlFlg3 = emlFlg3;
		this.emlFlg5 = emlFlg5;
		this.itNoCntrCnt = itNoCntrCnt;
		this.faxFlg4 = faxFlg4;
		this.faxFlg5 = faxFlg5;
		this.faxSndUsrNm = faxSndUsrNm;
		this.custCntcTpCd1 = custCntcTpCd1;
		this.ntcEml1 = ntcEml1;
		this.ntcEml2 = ntcEml2;
		this.ntcEml3 = ntcEml3;
		this.ntcEml4 = ntcEml4;
		this.ntcEml5 = ntcEml5;
		this.custCntcTpCd3 = custCntcTpCd3;
		this.custSeq = custSeq;
		this.custCntcTpCd2 = custCntcTpCd2;
		this.custCntcTpCd5 = custCntcTpCd5;
		this.skdDirCd = skdDirCd;
		this.custCntcTpCd4 = custCntcTpCd4;
		this.blCntrCnt = blCntrCnt;
		this.ibdLocGdsDesc = ibdLocGdsDesc;
		this.cntrNo = cntrNo;
		this.faxSndDt = faxSndDt;
		this.hubLocCd = hubLocCd;
		this.showPuFlg = showPuFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("fax_no1", getFaxNo1());
		this.hashColumns.put("p_mib_no", getPMibNo());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("eml_snd_dt", getEmlSndDt());
		this.hashColumns.put("fax_no5", getFaxNo5());
		this.hashColumns.put("fax_no4", getFaxNo4());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("fax_no3", getFaxNo3());
		this.hashColumns.put("fax_no2", getFaxNo2());
		this.hashColumns.put("fax_snd_flg3", getFaxSndFlg3());
		this.hashColumns.put("fax_snd_flg4", getFaxSndFlg4());
		this.hashColumns.put("fax_snd_flg1", getFaxSndFlg1());
		this.hashColumns.put("fax_snd_flg2", getFaxSndFlg2());
		this.hashColumns.put("fax_snd_usr_id", getFaxSndUsrId());
		this.hashColumns.put("it_chk", getItChk());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eml_proc_sts_cd", getEmlProcStsCd());
		this.hashColumns.put("eml_snd_usr_nm", getEmlSndUsrNm());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("trsp_mod_id", getTrspModId());
		this.hashColumns.put("fax_ofc_cd", getFaxOfcCd());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("bkg_cust_tp_cd", getBkgCustTpCd());
		this.hashColumns.put("attach_flg", getAttachFlg());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("eml_snd_usr_id", getEmlSndUsrId());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("chk_flg", getChkFlg());
		this.hashColumns.put("attach_max_cnt", getAttachMaxCnt());
		this.hashColumns.put("chk", getChk());
		this.hashColumns.put("fax_snd_flg5", getFaxSndFlg5());
		this.hashColumns.put("fax_proc_sts_cd", getFaxProcStsCd());
		this.hashColumns.put("fax_flg3", getFaxFlg3());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("fax_flg2", getFaxFlg2());
		this.hashColumns.put("fax_flg1", getFaxFlg1());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("eml_snd_flg5", getEmlSndFlg5());
		this.hashColumns.put("eml_snd_flg4", getEmlSndFlg4());
		this.hashColumns.put("eml_snd_flg1", getEmlSndFlg1());
		this.hashColumns.put("avc_note_tp_id", getAvcNoteTpId());
		this.hashColumns.put("eml_snd_flg3", getEmlSndFlg3());
		this.hashColumns.put("eml_snd_flg2", getEmlSndFlg2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eml_flg2", getEmlFlg2());
		this.hashColumns.put("eml_flg1", getEmlFlg1());
		this.hashColumns.put("eml_flg4", getEmlFlg4());
		this.hashColumns.put("eml_flg3", getEmlFlg3());
		this.hashColumns.put("eml_flg5", getEmlFlg5());
		this.hashColumns.put("it_no_cntr_cnt", getItNoCntrCnt());
		this.hashColumns.put("fax_flg4", getFaxFlg4());
		this.hashColumns.put("fax_flg5", getFaxFlg5());
		this.hashColumns.put("fax_snd_usr_nm", getFaxSndUsrNm());
		this.hashColumns.put("cust_cntc_tp_cd1", getCustCntcTpCd1());
		this.hashColumns.put("ntc_eml1", getNtcEml1());
		this.hashColumns.put("ntc_eml2", getNtcEml2());
		this.hashColumns.put("ntc_eml3", getNtcEml3());
		this.hashColumns.put("ntc_eml4", getNtcEml4());
		this.hashColumns.put("ntc_eml5", getNtcEml5());
		this.hashColumns.put("cust_cntc_tp_cd3", getCustCntcTpCd3());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cust_cntc_tp_cd2", getCustCntcTpCd2());
		this.hashColumns.put("cust_cntc_tp_cd5", getCustCntcTpCd5());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("cust_cntc_tp_cd4", getCustCntcTpCd4());
		this.hashColumns.put("bl_cntr_cnt", getBlCntrCnt());
		this.hashColumns.put("ibd_loc_gds_desc", getIbdLocGdsDesc());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("fax_snd_dt", getFaxSndDt());
		this.hashColumns.put("hub_loc_cd", getHubLocCd());
		this.hashColumns.put("show_pu_flg", getShowPuFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("fax_no1", "faxNo1");
		this.hashFields.put("p_mib_no", "pMibNo");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("eml_snd_dt", "emlSndDt");
		this.hashFields.put("fax_no5", "faxNo5");
		this.hashFields.put("fax_no4", "faxNo4");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("fax_no3", "faxNo3");
		this.hashFields.put("fax_no2", "faxNo2");
		this.hashFields.put("fax_snd_flg3", "faxSndFlg3");
		this.hashFields.put("fax_snd_flg4", "faxSndFlg4");
		this.hashFields.put("fax_snd_flg1", "faxSndFlg1");
		this.hashFields.put("fax_snd_flg2", "faxSndFlg2");
		this.hashFields.put("fax_snd_usr_id", "faxSndUsrId");
		this.hashFields.put("it_chk", "itChk");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eml_proc_sts_cd", "emlProcStsCd");
		this.hashFields.put("eml_snd_usr_nm", "emlSndUsrNm");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("trsp_mod_id", "trspModId");
		this.hashFields.put("fax_ofc_cd", "faxOfcCd");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("bkg_cust_tp_cd", "bkgCustTpCd");
		this.hashFields.put("attach_flg", "attachFlg");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("eml_snd_usr_id", "emlSndUsrId");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("chk_flg", "chkFlg");
		this.hashFields.put("attach_max_cnt", "attachMaxCnt");
		this.hashFields.put("chk", "chk");
		this.hashFields.put("fax_snd_flg5", "faxSndFlg5");
		this.hashFields.put("fax_proc_sts_cd", "faxProcStsCd");
		this.hashFields.put("fax_flg3", "faxFlg3");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("fax_flg2", "faxFlg2");
		this.hashFields.put("fax_flg1", "faxFlg1");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("eml_snd_flg5", "emlSndFlg5");
		this.hashFields.put("eml_snd_flg4", "emlSndFlg4");
		this.hashFields.put("eml_snd_flg1", "emlSndFlg1");
		this.hashFields.put("avc_note_tp_id", "avcNoteTpId");
		this.hashFields.put("eml_snd_flg3", "emlSndFlg3");
		this.hashFields.put("eml_snd_flg2", "emlSndFlg2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eml_flg2", "emlFlg2");
		this.hashFields.put("eml_flg1", "emlFlg1");
		this.hashFields.put("eml_flg4", "emlFlg4");
		this.hashFields.put("eml_flg3", "emlFlg3");
		this.hashFields.put("eml_flg5", "emlFlg5");
		this.hashFields.put("it_no_cntr_cnt", "itNoCntrCnt");
		this.hashFields.put("fax_flg4", "faxFlg4");
		this.hashFields.put("fax_flg5", "faxFlg5");
		this.hashFields.put("fax_snd_usr_nm", "faxSndUsrNm");
		this.hashFields.put("cust_cntc_tp_cd1", "custCntcTpCd1");
		this.hashFields.put("ntc_eml1", "ntcEml1");
		this.hashFields.put("ntc_eml2", "ntcEml2");
		this.hashFields.put("ntc_eml3", "ntcEml3");
		this.hashFields.put("ntc_eml4", "ntcEml4");
		this.hashFields.put("ntc_eml5", "ntcEml5");
		this.hashFields.put("cust_cntc_tp_cd3", "custCntcTpCd3");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cust_cntc_tp_cd2", "custCntcTpCd2");
		this.hashFields.put("cust_cntc_tp_cd5", "custCntcTpCd5");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("cust_cntc_tp_cd4", "custCntcTpCd4");
		this.hashFields.put("bl_cntr_cnt", "blCntrCnt");
		this.hashFields.put("ibd_loc_gds_desc", "ibdLocGdsDesc");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("fax_snd_dt", "faxSndDt");
		this.hashFields.put("hub_loc_cd", "hubLocCd");
		this.hashFields.put("show_pu_flg", "showPuFlg");
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
	 * @return faxNo1
	 */
	public String getFaxNo1() {
		return this.faxNo1;
	}
	
	/**
	 * Column Info
	 * @return pMibNo
	 */
	public String getPMibNo() {
		return this.pMibNo;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
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
	 * @return faxNo5
	 */
	public String getFaxNo5() {
		return this.faxNo5;
	}
	
	/**
	 * Column Info
	 * @return faxNo4
	 */
	public String getFaxNo4() {
		return this.faxNo4;
	}
	
	/**
	 * Column Info
	 * @return etaDt
	 */
	public String getEtaDt() {
		return this.etaDt;
	}
	
	/**
	 * Column Info
	 * @return faxNo3
	 */
	public String getFaxNo3() {
		return this.faxNo3;
	}
	
	/**
	 * Column Info
	 * @return faxNo2
	 */
	public String getFaxNo2() {
		return this.faxNo2;
	}
	
	/**
	 * Column Info
	 * @return faxSndFlg3
	 */
	public String getFaxSndFlg3() {
		return this.faxSndFlg3;
	}
	
	/**
	 * Column Info
	 * @return faxSndFlg4
	 */
	public String getFaxSndFlg4() {
		return this.faxSndFlg4;
	}
	
	/**
	 * Column Info
	 * @return faxSndFlg1
	 */
	public String getFaxSndFlg1() {
		return this.faxSndFlg1;
	}
	
	/**
	 * Column Info
	 * @return faxSndFlg2
	 */
	public String getFaxSndFlg2() {
		return this.faxSndFlg2;
	}
	
	/**
	 * Column Info
	 * @return faxSndUsrId
	 */
	public String getFaxSndUsrId() {
		return this.faxSndUsrId;
	}
	
	/**
	 * Column Info
	 * @return itChk
	 */
	public String getItChk() {
		return this.itChk;
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
	 * @return emlProcStsCd
	 */
	public String getEmlProcStsCd() {
		return this.emlProcStsCd;
	}
	
	/**
	 * Column Info
	 * @return emlSndUsrNm
	 */
	public String getEmlSndUsrNm() {
		return this.emlSndUsrNm;
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
	 * @return trspModId
	 */
	public String getTrspModId() {
		return this.trspModId;
	}
	
	/**
	 * Column Info
	 * @return faxOfcCd
	 */
	public String getFaxOfcCd() {
		return this.faxOfcCd;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
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
	 * @return attachFlg
	 */
	public String getAttachFlg() {
		return this.attachFlg;
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return emlSndUsrId
	 */
	public String getEmlSndUsrId() {
		return this.emlSndUsrId;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return chkFlg
	 */
	public String getChkFlg() {
		return this.chkFlg;
	}
	
	/**
	 * Column Info
	 * @return attachMaxCnt
	 */
	public String getAttachMaxCnt() {
		return this.attachMaxCnt;
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
	 * @return faxSndFlg5
	 */
	public String getFaxSndFlg5() {
		return this.faxSndFlg5;
	}
	
	/**
	 * Column Info
	 * @return faxProcStsCd
	 */
	public String getFaxProcStsCd() {
		return this.faxProcStsCd;
	}
	
	/**
	 * Column Info
	 * @return faxFlg3
	 */
	public String getFaxFlg3() {
		return this.faxFlg3;
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
	 * @return faxFlg2
	 */
	public String getFaxFlg2() {
		return this.faxFlg2;
	}
	
	/**
	 * Column Info
	 * @return faxFlg1
	 */
	public String getFaxFlg1() {
		return this.faxFlg1;
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
	 * @return emlSndFlg5
	 */
	public String getEmlSndFlg5() {
		return this.emlSndFlg5;
	}
	
	/**
	 * Column Info
	 * @return emlSndFlg4
	 */
	public String getEmlSndFlg4() {
		return this.emlSndFlg4;
	}
	
	/**
	 * Column Info
	 * @return emlSndFlg1
	 */
	public String getEmlSndFlg1() {
		return this.emlSndFlg1;
	}
	
	/**
	 * Column Info
	 * @return avcNoteTpId
	 */
	public String getAvcNoteTpId() {
		return this.avcNoteTpId;
	}
	
	/**
	 * Column Info
	 * @return emlSndFlg3
	 */
	public String getEmlSndFlg3() {
		return this.emlSndFlg3;
	}
	
	/**
	 * Column Info
	 * @return emlSndFlg2
	 */
	public String getEmlSndFlg2() {
		return this.emlSndFlg2;
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
	 * @return emlFlg2
	 */
	public String getEmlFlg2() {
		return this.emlFlg2;
	}
	
	/**
	 * Column Info
	 * @return emlFlg1
	 */
	public String getEmlFlg1() {
		return this.emlFlg1;
	}
	
	/**
	 * Column Info
	 * @return emlFlg4
	 */
	public String getEmlFlg4() {
		return this.emlFlg4;
	}
	
	/**
	 * Column Info
	 * @return emlFlg3
	 */
	public String getEmlFlg3() {
		return this.emlFlg3;
	}
	
	/**
	 * Column Info
	 * @return emlFlg5
	 */
	public String getEmlFlg5() {
		return this.emlFlg5;
	}
	
	/**
	 * Column Info
	 * @return itNoCntrCnt
	 */
	public String getItNoCntrCnt() {
		return this.itNoCntrCnt;
	}
	
	/**
	 * Column Info
	 * @return faxFlg4
	 */
	public String getFaxFlg4() {
		return this.faxFlg4;
	}
	
	/**
	 * Column Info
	 * @return faxFlg5
	 */
	public String getFaxFlg5() {
		return this.faxFlg5;
	}
	
	/**
	 * Column Info
	 * @return faxSndUsrNm
	 */
	public String getFaxSndUsrNm() {
		return this.faxSndUsrNm;
	}
	
	/**
	 * Column Info
	 * @return custCntcTpCd1
	 */
	public String getCustCntcTpCd1() {
		return this.custCntcTpCd1;
	}
	
	/**
	 * Column Info
	 * @return ntcEml1
	 */
	public String getNtcEml1() {
		return this.ntcEml1;
	}
	
	/**
	 * Column Info
	 * @return ntcEml2
	 */
	public String getNtcEml2() {
		return this.ntcEml2;
	}
	
	/**
	 * Column Info
	 * @return ntcEml3
	 */
	public String getNtcEml3() {
		return this.ntcEml3;
	}
	
	/**
	 * Column Info
	 * @return ntcEml4
	 */
	public String getNtcEml4() {
		return this.ntcEml4;
	}
	
	/**
	 * Column Info
	 * @return ntcEml5
	 */
	public String getNtcEml5() {
		return this.ntcEml5;
	}
	
	/**
	 * Column Info
	 * @return custCntcTpCd3
	 */
	public String getCustCntcTpCd3() {
		return this.custCntcTpCd3;
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
	 * @return custCntcTpCd2
	 */
	public String getCustCntcTpCd2() {
		return this.custCntcTpCd2;
	}
	
	/**
	 * Column Info
	 * @return custCntcTpCd5
	 */
	public String getCustCntcTpCd5() {
		return this.custCntcTpCd5;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return custCntcTpCd4
	 */
	public String getCustCntcTpCd4() {
		return this.custCntcTpCd4;
	}
	
	/**
	 * Column Info
	 * @return blCntrCnt
	 */
	public String getBlCntrCnt() {
		return this.blCntrCnt;
	}
	
	/**
	 * Column Info
	 * @return ibdLocGdsDesc
	 */
	public String getIbdLocGdsDesc() {
		return this.ibdLocGdsDesc;
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
	 * @return hubLocCd
	 */
	public String getHubLocCd() {
		return this.hubLocCd;
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
	 * @param faxNo1
	 */
	public void setFaxNo1(String faxNo1) {
		this.faxNo1 = faxNo1;
	}
	
	/**
	 * Column Info
	 * @param pMibNo
	 */
	public void setPMibNo(String pMibNo) {
		this.pMibNo = pMibNo;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
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
	 * @param faxNo5
	 */
	public void setFaxNo5(String faxNo5) {
		this.faxNo5 = faxNo5;
	}
	
	/**
	 * Column Info
	 * @param faxNo4
	 */
	public void setFaxNo4(String faxNo4) {
		this.faxNo4 = faxNo4;
	}
	
	/**
	 * Column Info
	 * @param etaDt
	 */
	public void setEtaDt(String etaDt) {
		this.etaDt = etaDt;
	}
	
	/**
	 * Column Info
	 * @param faxNo3
	 */
	public void setFaxNo3(String faxNo3) {
		this.faxNo3 = faxNo3;
	}
	
	/**
	 * Column Info
	 * @param faxNo2
	 */
	public void setFaxNo2(String faxNo2) {
		this.faxNo2 = faxNo2;
	}
	
	/**
	 * Column Info
	 * @param faxSndFlg3
	 */
	public void setFaxSndFlg3(String faxSndFlg3) {
		this.faxSndFlg3 = faxSndFlg3;
	}
	
	/**
	 * Column Info
	 * @param faxSndFlg4
	 */
	public void setFaxSndFlg4(String faxSndFlg4) {
		this.faxSndFlg4 = faxSndFlg4;
	}
	
	/**
	 * Column Info
	 * @param faxSndFlg1
	 */
	public void setFaxSndFlg1(String faxSndFlg1) {
		this.faxSndFlg1 = faxSndFlg1;
	}
	
	/**
	 * Column Info
	 * @param faxSndFlg2
	 */
	public void setFaxSndFlg2(String faxSndFlg2) {
		this.faxSndFlg2 = faxSndFlg2;
	}
	
	/**
	 * Column Info
	 * @param faxSndUsrId
	 */
	public void setFaxSndUsrId(String faxSndUsrId) {
		this.faxSndUsrId = faxSndUsrId;
	}
	
	/**
	 * Column Info
	 * @param itChk
	 */
	public void setItChk(String itChk) {
		this.itChk = itChk;
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
	 * @param emlProcStsCd
	 */
	public void setEmlProcStsCd(String emlProcStsCd) {
		this.emlProcStsCd = emlProcStsCd;
	}
	
	/**
	 * Column Info
	 * @param emlSndUsrNm
	 */
	public void setEmlSndUsrNm(String emlSndUsrNm) {
		this.emlSndUsrNm = emlSndUsrNm;
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
	 * @param trspModId
	 */
	public void setTrspModId(String trspModId) {
		this.trspModId = trspModId;
	}
	
	/**
	 * Column Info
	 * @param faxOfcCd
	 */
	public void setFaxOfcCd(String faxOfcCd) {
		this.faxOfcCd = faxOfcCd;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
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
	 * @param attachFlg
	 */
	public void setAttachFlg(String attachFlg) {
		this.attachFlg = attachFlg;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param emlSndUsrId
	 */
	public void setEmlSndUsrId(String emlSndUsrId) {
		this.emlSndUsrId = emlSndUsrId;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param chkFlg
	 */
	public void setChkFlg(String chkFlg) {
		this.chkFlg = chkFlg;
	}
	
	/**
	 * Column Info
	 * @param attachMaxCnt
	 */
	public void setAttachMaxCnt(String attachMaxCnt) {
		this.attachMaxCnt = attachMaxCnt;
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
	 * @param faxSndFlg5
	 */
	public void setFaxSndFlg5(String faxSndFlg5) {
		this.faxSndFlg5 = faxSndFlg5;
	}
	
	/**
	 * Column Info
	 * @param faxProcStsCd
	 */
	public void setFaxProcStsCd(String faxProcStsCd) {
		this.faxProcStsCd = faxProcStsCd;
	}
	
	/**
	 * Column Info
	 * @param faxFlg3
	 */
	public void setFaxFlg3(String faxFlg3) {
		this.faxFlg3 = faxFlg3;
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
	 * @param faxFlg2
	 */
	public void setFaxFlg2(String faxFlg2) {
		this.faxFlg2 = faxFlg2;
	}
	
	/**
	 * Column Info
	 * @param faxFlg1
	 */
	public void setFaxFlg1(String faxFlg1) {
		this.faxFlg1 = faxFlg1;
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
	 * @param emlSndFlg5
	 */
	public void setEmlSndFlg5(String emlSndFlg5) {
		this.emlSndFlg5 = emlSndFlg5;
	}
	
	/**
	 * Column Info
	 * @param emlSndFlg4
	 */
	public void setEmlSndFlg4(String emlSndFlg4) {
		this.emlSndFlg4 = emlSndFlg4;
	}
	
	/**
	 * Column Info
	 * @param emlSndFlg1
	 */
	public void setEmlSndFlg1(String emlSndFlg1) {
		this.emlSndFlg1 = emlSndFlg1;
	}
	
	/**
	 * Column Info
	 * @param avcNoteTpId
	 */
	public void setAvcNoteTpId(String avcNoteTpId) {
		this.avcNoteTpId = avcNoteTpId;
	}
	
	/**
	 * Column Info
	 * @param emlSndFlg3
	 */
	public void setEmlSndFlg3(String emlSndFlg3) {
		this.emlSndFlg3 = emlSndFlg3;
	}
	
	/**
	 * Column Info
	 * @param emlSndFlg2
	 */
	public void setEmlSndFlg2(String emlSndFlg2) {
		this.emlSndFlg2 = emlSndFlg2;
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
	 * @param emlFlg2
	 */
	public void setEmlFlg2(String emlFlg2) {
		this.emlFlg2 = emlFlg2;
	}
	
	/**
	 * Column Info
	 * @param emlFlg1
	 */
	public void setEmlFlg1(String emlFlg1) {
		this.emlFlg1 = emlFlg1;
	}
	
	/**
	 * Column Info
	 * @param emlFlg4
	 */
	public void setEmlFlg4(String emlFlg4) {
		this.emlFlg4 = emlFlg4;
	}
	
	/**
	 * Column Info
	 * @param emlFlg3
	 */
	public void setEmlFlg3(String emlFlg3) {
		this.emlFlg3 = emlFlg3;
	}
	
	/**
	 * Column Info
	 * @param emlFlg5
	 */
	public void setEmlFlg5(String emlFlg5) {
		this.emlFlg5 = emlFlg5;
	}
	
	/**
	 * Column Info
	 * @param itNoCntrCnt
	 */
	public void setItNoCntrCnt(String itNoCntrCnt) {
		this.itNoCntrCnt = itNoCntrCnt;
	}
	
	/**
	 * Column Info
	 * @param faxFlg4
	 */
	public void setFaxFlg4(String faxFlg4) {
		this.faxFlg4 = faxFlg4;
	}
	
	/**
	 * Column Info
	 * @param faxFlg5
	 */
	public void setFaxFlg5(String faxFlg5) {
		this.faxFlg5 = faxFlg5;
	}
	
	/**
	 * Column Info
	 * @param faxSndUsrNm
	 */
	public void setFaxSndUsrNm(String faxSndUsrNm) {
		this.faxSndUsrNm = faxSndUsrNm;
	}
	
	/**
	 * Column Info
	 * @param custCntcTpCd1
	 */
	public void setCustCntcTpCd1(String custCntcTpCd1) {
		this.custCntcTpCd1 = custCntcTpCd1;
	}
	
	/**
	 * Column Info
	 * @param ntcEml1
	 */
	public void setNtcEml1(String ntcEml1) {
		this.ntcEml1 = ntcEml1;
	}
	
	/**
	 * Column Info
	 * @param ntcEml2
	 */
	public void setNtcEml2(String ntcEml2) {
		this.ntcEml2 = ntcEml2;
	}
	
	/**
	 * Column Info
	 * @param ntcEml3
	 */
	public void setNtcEml3(String ntcEml3) {
		this.ntcEml3 = ntcEml3;
	}
	
	/**
	 * Column Info
	 * @param ntcEml4
	 */
	public void setNtcEml4(String ntcEml4) {
		this.ntcEml4 = ntcEml4;
	}
	
	/**
	 * Column Info
	 * @param ntcEml5
	 */
	public void setNtcEml5(String ntcEml5) {
		this.ntcEml5 = ntcEml5;
	}
	
	/**
	 * Column Info
	 * @param custCntcTpCd3
	 */
	public void setCustCntcTpCd3(String custCntcTpCd3) {
		this.custCntcTpCd3 = custCntcTpCd3;
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
	 * @param custCntcTpCd2
	 */
	public void setCustCntcTpCd2(String custCntcTpCd2) {
		this.custCntcTpCd2 = custCntcTpCd2;
	}
	
	/**
	 * Column Info
	 * @param custCntcTpCd5
	 */
	public void setCustCntcTpCd5(String custCntcTpCd5) {
		this.custCntcTpCd5 = custCntcTpCd5;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param custCntcTpCd4
	 */
	public void setCustCntcTpCd4(String custCntcTpCd4) {
		this.custCntcTpCd4 = custCntcTpCd4;
	}
	
	/**
	 * Column Info
	 * @param blCntrCnt
	 */
	public void setBlCntrCnt(String blCntrCnt) {
		this.blCntrCnt = blCntrCnt;
	}
	
	/**
	 * Column Info
	 * @param ibdLocGdsDesc
	 */
	public void setIbdLocGdsDesc(String ibdLocGdsDesc) {
		this.ibdLocGdsDesc = ibdLocGdsDesc;
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
	 * @param hubLocCd
	 */
	public void setHubLocCd(String hubLocCd) {
		this.hubLocCd = hubLocCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFaxNo1(JSPUtil.getParameter(request, "fax_no1", ""));
		setPMibNo(JSPUtil.getParameter(request, "p_mib_no", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setEmlSndDt(JSPUtil.getParameter(request, "eml_snd_dt", ""));
		setFaxNo5(JSPUtil.getParameter(request, "fax_no5", ""));
		setFaxNo4(JSPUtil.getParameter(request, "fax_no4", ""));
		setEtaDt(JSPUtil.getParameter(request, "eta_dt", ""));
		setFaxNo3(JSPUtil.getParameter(request, "fax_no3", ""));
		setFaxNo2(JSPUtil.getParameter(request, "fax_no2", ""));
		setFaxSndFlg3(JSPUtil.getParameter(request, "fax_snd_flg3", ""));
		setFaxSndFlg4(JSPUtil.getParameter(request, "fax_snd_flg4", ""));
		setFaxSndFlg1(JSPUtil.getParameter(request, "fax_snd_flg1", ""));
		setFaxSndFlg2(JSPUtil.getParameter(request, "fax_snd_flg2", ""));
		setFaxSndUsrId(JSPUtil.getParameter(request, "fax_snd_usr_id", ""));
		setItChk(JSPUtil.getParameter(request, "it_chk", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setEmlProcStsCd(JSPUtil.getParameter(request, "eml_proc_sts_cd", ""));
		setEmlSndUsrNm(JSPUtil.getParameter(request, "eml_snd_usr_nm", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setTrspModId(JSPUtil.getParameter(request, "trsp_mod_id", ""));
		setFaxOfcCd(JSPUtil.getParameter(request, "fax_ofc_cd", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setBkgCustTpCd(JSPUtil.getParameter(request, "bkg_cust_tp_cd", ""));
		setAttachFlg(JSPUtil.getParameter(request, "attach_flg", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setEmlSndUsrId(JSPUtil.getParameter(request, "eml_snd_usr_id", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setChkFlg(JSPUtil.getParameter(request, "chk_flg", ""));
		setAttachMaxCnt(JSPUtil.getParameter(request, "attach_max_cnt", ""));
		setChk(JSPUtil.getParameter(request, "chk", ""));
		setFaxSndFlg5(JSPUtil.getParameter(request, "fax_snd_flg5", ""));
		setFaxProcStsCd(JSPUtil.getParameter(request, "fax_proc_sts_cd", ""));
		setFaxFlg3(JSPUtil.getParameter(request, "fax_flg3", ""));
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setFaxFlg2(JSPUtil.getParameter(request, "fax_flg2", ""));
		setFaxFlg1(JSPUtil.getParameter(request, "fax_flg1", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setEmlSndFlg5(JSPUtil.getParameter(request, "eml_snd_flg5", ""));
		setEmlSndFlg4(JSPUtil.getParameter(request, "eml_snd_flg4", ""));
		setEmlSndFlg1(JSPUtil.getParameter(request, "eml_snd_flg1", ""));
		setAvcNoteTpId(JSPUtil.getParameter(request, "avc_note_tp_id", ""));
		setEmlSndFlg3(JSPUtil.getParameter(request, "eml_snd_flg3", ""));
		setEmlSndFlg2(JSPUtil.getParameter(request, "eml_snd_flg2", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEmlFlg2(JSPUtil.getParameter(request, "eml_flg2", ""));
		setEmlFlg1(JSPUtil.getParameter(request, "eml_flg1", ""));
		setEmlFlg4(JSPUtil.getParameter(request, "eml_flg4", ""));
		setEmlFlg3(JSPUtil.getParameter(request, "eml_flg3", ""));
		setEmlFlg5(JSPUtil.getParameter(request, "eml_flg5", ""));
		setItNoCntrCnt(JSPUtil.getParameter(request, "it_no_cntr_cnt", ""));
		setFaxFlg4(JSPUtil.getParameter(request, "fax_flg4", ""));
		setFaxFlg5(JSPUtil.getParameter(request, "fax_flg5", ""));
		setFaxSndUsrNm(JSPUtil.getParameter(request, "fax_snd_usr_nm", ""));
		setCustCntcTpCd1(JSPUtil.getParameter(request, "cust_cntc_tp_cd1", ""));
		setNtcEml1(JSPUtil.getParameter(request, "ntc_eml1", ""));
		setNtcEml2(JSPUtil.getParameter(request, "ntc_eml2", ""));
		setNtcEml3(JSPUtil.getParameter(request, "ntc_eml3", ""));
		setNtcEml4(JSPUtil.getParameter(request, "ntc_eml4", ""));
		setNtcEml5(JSPUtil.getParameter(request, "ntc_eml5", ""));
		setCustCntcTpCd3(JSPUtil.getParameter(request, "cust_cntc_tp_cd3", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setCustCntcTpCd2(JSPUtil.getParameter(request, "cust_cntc_tp_cd2", ""));
		setCustCntcTpCd5(JSPUtil.getParameter(request, "cust_cntc_tp_cd5", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setCustCntcTpCd4(JSPUtil.getParameter(request, "cust_cntc_tp_cd4", ""));
		setBlCntrCnt(JSPUtil.getParameter(request, "bl_cntr_cnt", ""));
		setIbdLocGdsDesc(JSPUtil.getParameter(request, "ibd_loc_gds_desc", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setFaxSndDt(JSPUtil.getParameter(request, "fax_snd_dt", ""));
		setHubLocCd(JSPUtil.getParameter(request, "hub_loc_cd", ""));
		setShowPuFlg(JSPUtil.getParameter(request, "show_pu_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CndCstmsReportVO[]
	 */
	public CndCstmsReportVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CndCstmsReportVO[]
	 */
	public CndCstmsReportVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CndCstmsReportVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] faxNo1 = (JSPUtil.getParameter(request, prefix	+ "fax_no1", length));
			String[] pMibNo = (JSPUtil.getParameter(request, prefix	+ "p_mib_no", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] emlSndDt = (JSPUtil.getParameter(request, prefix	+ "eml_snd_dt", length));
			String[] faxNo5 = (JSPUtil.getParameter(request, prefix	+ "fax_no5", length));
			String[] faxNo4 = (JSPUtil.getParameter(request, prefix	+ "fax_no4", length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] faxNo3 = (JSPUtil.getParameter(request, prefix	+ "fax_no3", length));
			String[] faxNo2 = (JSPUtil.getParameter(request, prefix	+ "fax_no2", length));
			String[] faxSndFlg3 = (JSPUtil.getParameter(request, prefix	+ "fax_snd_flg3", length));
			String[] faxSndFlg4 = (JSPUtil.getParameter(request, prefix	+ "fax_snd_flg4", length));
			String[] faxSndFlg1 = (JSPUtil.getParameter(request, prefix	+ "fax_snd_flg1", length));
			String[] faxSndFlg2 = (JSPUtil.getParameter(request, prefix	+ "fax_snd_flg2", length));
			String[] faxSndUsrId = (JSPUtil.getParameter(request, prefix	+ "fax_snd_usr_id", length));
			String[] itChk = (JSPUtil.getParameter(request, prefix	+ "it_chk", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] emlProcStsCd = (JSPUtil.getParameter(request, prefix	+ "eml_proc_sts_cd", length));
			String[] emlSndUsrNm = (JSPUtil.getParameter(request, prefix	+ "eml_snd_usr_nm", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] trspModId = (JSPUtil.getParameter(request, prefix	+ "trsp_mod_id", length));
			String[] faxOfcCd = (JSPUtil.getParameter(request, prefix	+ "fax_ofc_cd", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] bkgCustTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cust_tp_cd", length));
			String[] attachFlg = (JSPUtil.getParameter(request, prefix	+ "attach_flg", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] emlSndUsrId = (JSPUtil.getParameter(request, prefix	+ "eml_snd_usr_id", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] chkFlg = (JSPUtil.getParameter(request, prefix	+ "chk_flg", length));
			String[] attachMaxCnt = (JSPUtil.getParameter(request, prefix	+ "attach_max_cnt", length));
			String[] chk = (JSPUtil.getParameter(request, prefix	+ "chk", length));
			String[] faxSndFlg5 = (JSPUtil.getParameter(request, prefix	+ "fax_snd_flg5", length));
			String[] faxProcStsCd = (JSPUtil.getParameter(request, prefix	+ "fax_proc_sts_cd", length));
			String[] faxFlg3 = (JSPUtil.getParameter(request, prefix	+ "fax_flg3", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] faxFlg2 = (JSPUtil.getParameter(request, prefix	+ "fax_flg2", length));
			String[] faxFlg1 = (JSPUtil.getParameter(request, prefix	+ "fax_flg1", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] emlSndFlg5 = (JSPUtil.getParameter(request, prefix	+ "eml_snd_flg5", length));
			String[] emlSndFlg4 = (JSPUtil.getParameter(request, prefix	+ "eml_snd_flg4", length));
			String[] emlSndFlg1 = (JSPUtil.getParameter(request, prefix	+ "eml_snd_flg1", length));
			String[] avcNoteTpId = (JSPUtil.getParameter(request, prefix	+ "avc_note_tp_id", length));
			String[] emlSndFlg3 = (JSPUtil.getParameter(request, prefix	+ "eml_snd_flg3", length));
			String[] emlSndFlg2 = (JSPUtil.getParameter(request, prefix	+ "eml_snd_flg2", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] emlFlg2 = (JSPUtil.getParameter(request, prefix	+ "eml_flg2", length));
			String[] emlFlg1 = (JSPUtil.getParameter(request, prefix	+ "eml_flg1", length));
			String[] emlFlg4 = (JSPUtil.getParameter(request, prefix	+ "eml_flg4", length));
			String[] emlFlg3 = (JSPUtil.getParameter(request, prefix	+ "eml_flg3", length));
			String[] emlFlg5 = (JSPUtil.getParameter(request, prefix	+ "eml_flg5", length));
			String[] itNoCntrCnt = (JSPUtil.getParameter(request, prefix	+ "it_no_cntr_cnt", length));
			String[] faxFlg4 = (JSPUtil.getParameter(request, prefix	+ "fax_flg4", length));
			String[] faxFlg5 = (JSPUtil.getParameter(request, prefix	+ "fax_flg5", length));
			String[] faxSndUsrNm = (JSPUtil.getParameter(request, prefix	+ "fax_snd_usr_nm", length));
			String[] custCntcTpCd1 = (JSPUtil.getParameter(request, prefix	+ "cust_cntc_tp_cd1", length));
			String[] ntcEml1 = (JSPUtil.getParameter(request, prefix	+ "ntc_eml1", length));
			String[] ntcEml2 = (JSPUtil.getParameter(request, prefix	+ "ntc_eml2", length));
			String[] ntcEml3 = (JSPUtil.getParameter(request, prefix	+ "ntc_eml3", length));
			String[] ntcEml4 = (JSPUtil.getParameter(request, prefix	+ "ntc_eml4", length));
			String[] ntcEml5 = (JSPUtil.getParameter(request, prefix	+ "ntc_eml5", length));
			String[] custCntcTpCd3 = (JSPUtil.getParameter(request, prefix	+ "cust_cntc_tp_cd3", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] custCntcTpCd2 = (JSPUtil.getParameter(request, prefix	+ "cust_cntc_tp_cd2", length));
			String[] custCntcTpCd5 = (JSPUtil.getParameter(request, prefix	+ "cust_cntc_tp_cd5", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] custCntcTpCd4 = (JSPUtil.getParameter(request, prefix	+ "cust_cntc_tp_cd4", length));
			String[] blCntrCnt = (JSPUtil.getParameter(request, prefix	+ "bl_cntr_cnt", length));
			String[] ibdLocGdsDesc = (JSPUtil.getParameter(request, prefix	+ "ibd_loc_gds_desc", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] faxSndDt = (JSPUtil.getParameter(request, prefix	+ "fax_snd_dt", length));
			String[] hubLocCd = (JSPUtil.getParameter(request, prefix	+ "hub_loc_cd", length));
			String[] showPuFlg = (JSPUtil.getParameter(request, prefix	+ "show_pu_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new CndCstmsReportVO();
				if (faxNo1[i] != null)
					model.setFaxNo1(faxNo1[i]);
				if (pMibNo[i] != null)
					model.setPMibNo(pMibNo[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (emlSndDt[i] != null)
					model.setEmlSndDt(emlSndDt[i]);
				if (faxNo5[i] != null)
					model.setFaxNo5(faxNo5[i]);
				if (faxNo4[i] != null)
					model.setFaxNo4(faxNo4[i]);
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (faxNo3[i] != null)
					model.setFaxNo3(faxNo3[i]);
				if (faxNo2[i] != null)
					model.setFaxNo2(faxNo2[i]);
				if (faxSndFlg3[i] != null)
					model.setFaxSndFlg3(faxSndFlg3[i]);
				if (faxSndFlg4[i] != null)
					model.setFaxSndFlg4(faxSndFlg4[i]);
				if (faxSndFlg1[i] != null)
					model.setFaxSndFlg1(faxSndFlg1[i]);
				if (faxSndFlg2[i] != null)
					model.setFaxSndFlg2(faxSndFlg2[i]);
				if (faxSndUsrId[i] != null)
					model.setFaxSndUsrId(faxSndUsrId[i]);
				if (itChk[i] != null)
					model.setItChk(itChk[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (emlProcStsCd[i] != null)
					model.setEmlProcStsCd(emlProcStsCd[i]);
				if (emlSndUsrNm[i] != null)
					model.setEmlSndUsrNm(emlSndUsrNm[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (trspModId[i] != null)
					model.setTrspModId(trspModId[i]);
				if (faxOfcCd[i] != null)
					model.setFaxOfcCd(faxOfcCd[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (bkgCustTpCd[i] != null)
					model.setBkgCustTpCd(bkgCustTpCd[i]);
				if (attachFlg[i] != null)
					model.setAttachFlg(attachFlg[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (emlSndUsrId[i] != null)
					model.setEmlSndUsrId(emlSndUsrId[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (chkFlg[i] != null)
					model.setChkFlg(chkFlg[i]);
				if (attachMaxCnt[i] != null)
					model.setAttachMaxCnt(attachMaxCnt[i]);
				if (chk[i] != null)
					model.setChk(chk[i]);
				if (faxSndFlg5[i] != null)
					model.setFaxSndFlg5(faxSndFlg5[i]);
				if (faxProcStsCd[i] != null)
					model.setFaxProcStsCd(faxProcStsCd[i]);
				if (faxFlg3[i] != null)
					model.setFaxFlg3(faxFlg3[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (faxFlg2[i] != null)
					model.setFaxFlg2(faxFlg2[i]);
				if (faxFlg1[i] != null)
					model.setFaxFlg1(faxFlg1[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (emlSndFlg5[i] != null)
					model.setEmlSndFlg5(emlSndFlg5[i]);
				if (emlSndFlg4[i] != null)
					model.setEmlSndFlg4(emlSndFlg4[i]);
				if (emlSndFlg1[i] != null)
					model.setEmlSndFlg1(emlSndFlg1[i]);
				if (avcNoteTpId[i] != null)
					model.setAvcNoteTpId(avcNoteTpId[i]);
				if (emlSndFlg3[i] != null)
					model.setEmlSndFlg3(emlSndFlg3[i]);
				if (emlSndFlg2[i] != null)
					model.setEmlSndFlg2(emlSndFlg2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (emlFlg2[i] != null)
					model.setEmlFlg2(emlFlg2[i]);
				if (emlFlg1[i] != null)
					model.setEmlFlg1(emlFlg1[i]);
				if (emlFlg4[i] != null)
					model.setEmlFlg4(emlFlg4[i]);
				if (emlFlg3[i] != null)
					model.setEmlFlg3(emlFlg3[i]);
				if (emlFlg5[i] != null)
					model.setEmlFlg5(emlFlg5[i]);
				if (itNoCntrCnt[i] != null)
					model.setItNoCntrCnt(itNoCntrCnt[i]);
				if (faxFlg4[i] != null)
					model.setFaxFlg4(faxFlg4[i]);
				if (faxFlg5[i] != null)
					model.setFaxFlg5(faxFlg5[i]);
				if (faxSndUsrNm[i] != null)
					model.setFaxSndUsrNm(faxSndUsrNm[i]);
				if (custCntcTpCd1[i] != null)
					model.setCustCntcTpCd1(custCntcTpCd1[i]);
				if (ntcEml1[i] != null)
					model.setNtcEml1(ntcEml1[i]);
				if (ntcEml2[i] != null)
					model.setNtcEml2(ntcEml2[i]);
				if (ntcEml3[i] != null)
					model.setNtcEml3(ntcEml3[i]);
				if (ntcEml4[i] != null)
					model.setNtcEml4(ntcEml4[i]);
				if (ntcEml5[i] != null)
					model.setNtcEml5(ntcEml5[i]);
				if (custCntcTpCd3[i] != null)
					model.setCustCntcTpCd3(custCntcTpCd3[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (custCntcTpCd2[i] != null)
					model.setCustCntcTpCd2(custCntcTpCd2[i]);
				if (custCntcTpCd5[i] != null)
					model.setCustCntcTpCd5(custCntcTpCd5[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (custCntcTpCd4[i] != null)
					model.setCustCntcTpCd4(custCntcTpCd4[i]);
				if (blCntrCnt[i] != null)
					model.setBlCntrCnt(blCntrCnt[i]);
				if (ibdLocGdsDesc[i] != null)
					model.setIbdLocGdsDesc(ibdLocGdsDesc[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (faxSndDt[i] != null)
					model.setFaxSndDt(faxSndDt[i]);
				if (hubLocCd[i] != null)
					model.setHubLocCd(hubLocCd[i]);
				if (showPuFlg[i] != null)
					model.setShowPuFlg(showPuFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCndCstmsReportVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CndCstmsReportVO[]
	 */
	public CndCstmsReportVO[] getCndCstmsReportVOs(){
		CndCstmsReportVO[] vos = (CndCstmsReportVO[])models.toArray(new CndCstmsReportVO[models.size()]);
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
		this.faxNo1 = this.faxNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pMibNo = this.pMibNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndDt = this.emlSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo5 = this.faxNo5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo4 = this.faxNo4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo3 = this.faxNo3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo2 = this.faxNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndFlg3 = this.faxSndFlg3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndFlg4 = this.faxSndFlg4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndFlg1 = this.faxSndFlg1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndFlg2 = this.faxSndFlg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndUsrId = this.faxSndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itChk = this.itChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlProcStsCd = this.emlProcStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndUsrNm = this.emlSndUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspModId = this.trspModId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxOfcCd = this.faxOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustTpCd = this.bkgCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attachFlg = this.attachFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndUsrId = this.emlSndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkFlg = this.chkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attachMaxCnt = this.attachMaxCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk = this.chk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndFlg5 = this.faxSndFlg5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxProcStsCd = this.faxProcStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxFlg3 = this.faxFlg3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxFlg2 = this.faxFlg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxFlg1 = this.faxFlg1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndFlg5 = this.emlSndFlg5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndFlg4 = this.emlSndFlg4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndFlg1 = this.emlSndFlg1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avcNoteTpId = this.avcNoteTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndFlg3 = this.emlSndFlg3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndFlg2 = this.emlSndFlg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlFlg2 = this.emlFlg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlFlg1 = this.emlFlg1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlFlg4 = this.emlFlg4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlFlg3 = this.emlFlg3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlFlg5 = this.emlFlg5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itNoCntrCnt = this.itNoCntrCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxFlg4 = this.faxFlg4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxFlg5 = this.faxFlg5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndUsrNm = this.faxSndUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntcTpCd1 = this.custCntcTpCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcEml1 = this.ntcEml1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcEml2 = this.ntcEml2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcEml3 = this.ntcEml3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcEml4 = this.ntcEml4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcEml5 = this.ntcEml5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntcTpCd3 = this.custCntcTpCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntcTpCd2 = this.custCntcTpCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntcTpCd5 = this.custCntcTpCd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntcTpCd4 = this.custCntcTpCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCntrCnt = this.blCntrCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdLocGdsDesc = this.ibdLocGdsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndDt = this.faxSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hubLocCd = this.hubLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.showPuFlg = this.showPuFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
