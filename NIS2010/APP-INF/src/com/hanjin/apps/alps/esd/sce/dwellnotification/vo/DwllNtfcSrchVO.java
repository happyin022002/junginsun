/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DwllNtfcSrchVO.java
*@FileTitle : DwllNtfcSrchVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.07
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2011.07.07 채창호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.dwellnotification.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 채창호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DwllNtfcSrchVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DwllNtfcSrchVO> models = new ArrayList<DwllNtfcSrchVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String scpfxcd = null;
	/* Column Info */
	private String ctrtexpdt = null;
	/* Column Info */
	private String scno = null;
	/* Column Info */
	private String mtchflg = null;
	/* Column Info */
	private String ctrteffdt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ctrtptynm = null;
	/* Column Info */
	private String propmqcqty = null;
	/* Column Info */
	private String unitnm = null;
	/* Column Info */
	private String propofccd = null;
	/* Column Info */
	private String emaillistcnt = null;
	/* Column Info */
	private String effdt = null;
	/* Column Info */
	private String expdt = null;
	/* Column Info */
	private List scpfxcdlist = null;
	/* Column Info */
	private String row = null;
	/* Column Info */
	private String fcmd = null;
	/* Column Info */
	private String propstsnm = null;
	/* Column Info */
	private String[] resultStrArray = null;
	/* Column Info */
	private String usrid = null;
	
	private String mstexistflg = null;
	/* Column Info */
	private String subscEml = null;
	/* Column Info */
	private String ntfcSeq = null;
	/* Column Info */
	private String subscRmk = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String creUsrNm = null;
	/* Column Info */
	private String deltDt = null;
	/* Column Info */
	private String deltUsrId = null;
	/* Column Info */
	private String deltUsrNm = null;
	/* Column Info */
	private String idelFlg = null;
	
	/* Column Info */
	private String tmlDwllFlg = null;
	/* Column Info */
	private String enrDwllFlg = null;
	/* Column Info */
	private String destDwllFlg = null;
	/* Column Info */
	private String vslDlayFlg = null;
	/* Column Info */
	private String exptSetUsrId = null;
	/* Column Info */
	private String exptSetDt = null;
	/* Column Info */
	private String exptSetUsrName = null;
	/* Column Info */
	private String schTp = null;
	/* Column Info */
	private String chk = null;
	/* Column Info */
	private String dwllExptRmk = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String emlAddr = null;
	/* Column Info */
	private String ofcCd = null;
	
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String emlFmCrmFlg = null;
	/* Column Info */
	private String emlBkgOrgFlg = null;
	/* Column Info */
	private String emlBkgDestFlg = null;
	/* Column Info */
	private String emlBkgOtrFlg = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String sndOptCdAw = null;
	/* Column Info */
	private String sndOptCdOt = null;
	/* Column Info */
	private String fExptFlg = null;
	/* Column Info */
	private String otSndHist = null;
	
	/* Column Info */
	private String bkgTmlDwllFlg = null;
	/* Column Info */
	private String bkgEnrDwllFlg = null;
	/* Column Info */
	private String bkgDestDwllFlg = null;
	/* Column Info */
	private String bkgVslDlayFlg = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DwllNtfcSrchVO() {}

	public DwllNtfcSrchVO(String ibflag, String pagerows, String scpfxcd, String scno, String ctrtexpdt, String ctrteffdt, String mtchflg,
			              String ctrtptynm ,String propmqcqty,String unitnm ,String propofccd, String emaillistcnt,String effdt , String expdt ,String row , String fcmd ,String propstsnm , String usrid ,String mstexistflg ,
			              String subscEml, String ntfcSeq ,String subscRmk , String creDt , String creUsrId ,String creUsrNm , String deltDt ,String deltUsrId , String deltUsrNm , String idelFlg ,
			              String tmlDwllFlg, String enrDwllFlg ,String destDwllFlg, String vslDlayFlg , String exptSetUsrId ,String exptSetDt , String exptSetUsrName , String schTp , String chk, String dwllExptRmk ,String custCd,
			              String emlAddr, String ofcCd, String custCntCd, String custSeq, String emlFmCrmFlg, String emlBkgOrgFlg, String emlBkgDestFlg, String emlBkgOtrFlg, String creOfcCd, String sndOptCdAw, String sndOptCdOt, String fExptFlg, String otSndHist,
			              String bkgTmlDwllFlg, String bkgEnrDwllFlg ,String bkgDestDwllFlg, String bkgVslDlayFlg) {
		this.ibflag = ibflag;
		this.scpfxcd = scpfxcd;
		this.ctrtexpdt = ctrtexpdt;
		this.scno = scno;
		this.mtchflg = mtchflg;
		this.ctrteffdt = ctrteffdt;
		this.pagerows = pagerows;
		this.ctrtptynm = ctrtptynm;
		this.propmqcqty = propmqcqty;
		this.unitnm = unitnm;
		this.propofccd = propofccd;
		this.emaillistcnt = emaillistcnt;
		this.effdt = effdt;
		this.expdt = expdt;
		this.row = row;
		this.fcmd = fcmd;
		this.propstsnm = propstsnm;
		this.usrid  = usrid;
		this.mstexistflg = mstexistflg;
		this.subscEml=subscEml;
		this.ntfcSeq = ntfcSeq;
		this.subscRmk  = subscRmk; 
		this.creDt = creDt;
		this.creUsrId = creUsrId;
		this.creUsrNm = creUsrNm;
		this.deltDt = deltDt;
		this.deltUsrId = deltUsrId;
		this.deltUsrNm = deltUsrNm;
		this.idelFlg = idelFlg;
		this.tmlDwllFlg = tmlDwllFlg;
		this.enrDwllFlg = enrDwllFlg;
		this.destDwllFlg = destDwllFlg;
		this.vslDlayFlg = vslDlayFlg;
		this.exptSetUsrId = exptSetUsrId;
		this.exptSetDt = exptSetDt;
		this.exptSetUsrName = exptSetUsrName;
		this.schTp = schTp;
		this.chk   = chk;
		this.dwllExptRmk = dwllExptRmk;
		this.custCd = custCd;
		this.emlAddr = emlAddr;
		this.ofcCd = ofcCd;
		
		this.custCntCd = custCntCd;
		this.custSeq = custSeq;
		this.emlFmCrmFlg = emlFmCrmFlg;
		this.emlBkgOrgFlg = emlBkgOrgFlg;
		this.emlBkgDestFlg = emlBkgDestFlg;
		this.emlBkgOtrFlg = emlBkgOtrFlg;
		this.creOfcCd = creOfcCd;
		this.sndOptCdAw = sndOptCdAw;
		this.sndOptCdOt = sndOptCdOt;
		this.fExptFlg = fExptFlg;
		this.otSndHist = otSndHist;		

		this.bkgTmlDwllFlg = bkgTmlDwllFlg;
		this.bkgEnrDwllFlg = bkgEnrDwllFlg;
		this.bkgDestDwllFlg = bkgDestDwllFlg;
		this.bkgVslDlayFlg = bkgVslDlayFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sc_pfx_cd", getScpfxcd());
		this.hashColumns.put("ctrt_exp_dt", getCtrtexpdt());
		this.hashColumns.put("sc_no", getScno());
		this.hashColumns.put("mtch_flg", getMtchflg());
		this.hashColumns.put("ctrt_eff_dt", getCtrteffdt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ctrt_pty_nm", getCtrtptynm());
		this.hashColumns.put("prop_mqc_qty", getPropmqcqty());
		this.hashColumns.put("unit_nm", getUnitnm());
		this.hashColumns.put("prop_ofc_cd", getPropofccd());
		this.hashColumns.put("email_list_cnt", getEmaillistcnt());
		this.hashColumns.put("eff_dt", getEffdt());
		this.hashColumns.put("exp_dt", getExpdt());
		this.hashColumns.put("row", getRow());
		this.hashColumns.put("f_cmd" ,getFcmd());
		this.hashColumns.put("prop_sts_nm", getPropstsnm());
		this.hashColumns.put("usr_id", getUsrid());
		this.hashColumns.put("mst_exist_flg", getMstexistflg());
		this.hashColumns.put("subsc_eml", getSubscEml());
		this.hashColumns.put("ntfc_seq", getNtfcSeq());
		this.hashColumns.put("subsc_rmk", getSubscRmk());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_usr_nm", getCreUsrNm());
		this.hashColumns.put("delt_dt", getDeltDt());
		this.hashColumns.put("delt_usr_id", getDeltUsrId());
		this.hashColumns.put("delt_usr_nm", getDeltUsrNm());
		this.hashColumns.put("i_del_flg", getIdelFlg());
		
		this.hashColumns.put("tml_dwll_flg", getTmlDwllFlg());
		this.hashColumns.put("enr_dwll_flg", getEnrDwllFlg());
		this.hashColumns.put("dest_dwll_flg", getDestDwllFlg());
		this.hashColumns.put("vsl_dlay_flg", getVslDlayFlg());
		this.hashColumns.put("expt_set_usr_id", getExptSetUsrId());
		this.hashColumns.put("expt_set_dt", getExptSetDt());
		this.hashColumns.put("expt_set_usr_name", getExptSetUsrName());
		this.hashColumns.put("sch_tp", getSchTp());
		this.hashColumns.put("chk", getChk());
		this.hashColumns.put("dwll_expt_rmk", getDwllExptRmk());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("eml_addr", getEmlAddr());
		this.hashColumns.put("ofc_cd", getOfcCd());
		
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("eml_fm_crm_flg", getEmlFmCrmFlg());
		this.hashColumns.put("eml_bkg_org_flg", getEmlBkgOrgFlg());
		this.hashColumns.put("eml_bkg_dest_flg", getEmlBkgDestFlg());
		this.hashColumns.put("eml_bkg_otr_flg", getEmlBkgOtrFlg());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("snd_opt_cd_aw", getSndOptCdAw());
		this.hashColumns.put("snd_opt_cd_ot", getSndOptCdOt());
		this.hashColumns.put("f_expt_flg", getFExptFlg());
		this.hashColumns.put("ot_snd_hist", getOtSndHist());

		this.hashColumns.put("bkg_tml_dwll_flg", getBkgTmlDwllFlg());
		this.hashColumns.put("bkg_enr_dwll_flg", getBkgEnrDwllFlg());
		this.hashColumns.put("bkg_dest_dwll_flg", getBkgDestDwllFlg());
		this.hashColumns.put("bkg_vsl_dlay_flg", getBkgVslDlayFlg());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sc_pfx_cd", "scpfxcd");
		this.hashFields.put("ctrt_exp_dt", "ctrtexpdt");
		this.hashFields.put("sc_no", "scno");
		this.hashFields.put("mtch_flg", "mtchflg");
		this.hashFields.put("ctrt_eff_dt", "ctrteffdt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ctrt_pty_nm", "ctrtptynm");
		this.hashFields.put("prop_mqc_qty", "propmqcqty");
		this.hashFields.put("unit_nm", "unitnm");
		this.hashFields.put("prop_ofc_cd", "propofccd");
		this.hashFields.put("email_list_cnt", "emaillistcnt");
		this.hashFields.put("eff_dt", "effdt");
		this.hashFields.put("exp_dt", "expdt");
		this.hashFields.put("row", "row");
		this.hashFields.put("f_cmd", "fcmd");
		this.hashFields.put("prop_sts_nm", "propstsnm");
		this.hashFields.put("usr_id", "usrid");
		this.hashFields.put("mst_exist_flg", "mstexistflg");
		this.hashFields.put("subsc_eml", "subscEml");
		this.hashFields.put("ntfc_seq", "ntfcSeq");
		
		this.hashFields.put("subsc_rmk", "subscRmk");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_usr_nm", "creUsrNm");
		this.hashFields.put("delt_dt", "deltDt");
		this.hashFields.put("delt_usr_id", "deltUsrId");
		this.hashFields.put("delt_usr_nm", "deltUsrNm");
		this.hashFields.put("i_del_flg", "idelFlg");
		
		this.hashFields.put("tml_dwll_flg", "tmlDwllFlg");
		this.hashFields.put("enr_dwll_flg", "enrDwllFlg");
		this.hashFields.put("dest_dwll_flg", "destDwllFlg");
		this.hashFields.put("vsl_dlay_flg", "vslDlayFlg");
		this.hashFields.put("expt_set_usr_id", "exptSetUsrId");
		this.hashFields.put("expt_set_dt", "exptSetDt");
		this.hashFields.put("expt_set_usr_name", "exptSetUsrName");
		this.hashFields.put("sch_tp", "schTp");
		this.hashFields.put("chk", "chk");
		this.hashFields.put("dwll_expt_rmk", "dwllExptRmk");
		this.hashFields.put("cust_cd", "custCd");
		
		this.hashFields.put("eml_addr", "emlAddr");
		this.hashFields.put("ofc_cd", "ofcCd");
		
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("eml_fm_crm_flg", "emlFmCrmFlg");
		this.hashFields.put("eml_bkg_org_flg", "emlBkgOrgFlg");
		this.hashFields.put("eml_bkg_dest_flg", "emlBkgDestFlg");
		this.hashFields.put("eml_bkg_otr_flg", "emlBkgOtrFlg");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("snd_opt_cd_aw", "sndOptCdAw");
		this.hashFields.put("snd_opt_cd_ot", "sndOptCdOt");
		this.hashFields.put("f_expt_flg", "fExptFlg");
		this.hashFields.put("ot_snd_hist", "otSndHist");

		this.hashFields.put("bkg_tml_dwll_flg", "bkgTmlDwllFlg");
		this.hashFields.put("bkg_enr_dwll_flg", "bkgEnrDwllFlg");
		this.hashFields.put("bkg_dest_dwll_flg", "bkgDestDwllFlg");
		this.hashFields.put("bkg_vsl_dlay_flg", "bkgVslDlayFlg");
		return this.hashFields;
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
	 * @return scpfxcd
	 */
	public String getScpfxcd() {
		return this.scpfxcd;
	}
	
	/**
	 * Column Info
	 * @return ctrtexpdt
	 */
	public String getCtrtexpdt() {
		return this.ctrtexpdt;
	}
	
	/**
	 * Column Info
	 * @return scno
	 */
	public String getScno() {
		return this.scno;
	}
	
	/**
	 * Column Info
	 * @return mtchflg
	 */
	public String getMtchflg() {
		return this.mtchflg;
	}
	
	/**
	 * Column Info
	 * @return ctrteffdt
	 */
	public String getCtrteffdt() {
		return this.ctrteffdt;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @param scpfxcd
	 */
	public void setScpfxcd(String scpfxcd) {
		this.scpfxcd = scpfxcd;
	}
	
	/**
	 * Column Info
	 * @param ctrtexpdt
	 */
	public void setCtrtexpdt(String ctrtexpdt) {
		this.ctrtexpdt = ctrtexpdt;
	}
	
	/**
	 * Column Info
	 * @param scno
	 */
	public void setScno(String scno) {
		this.scno = scno;
	}
	
	/**
	 * Column Info
	 * @param mtchflg
	 */
	public void setMtchflg(String mtchflg) {
		this.mtchflg = mtchflg;
	}
	
	/**
	 * Column Info
	 * @param ctrteffdt
	 */
	public void setCtrteffdt(String ctrteffdt) {
		this.ctrteffdt = ctrteffdt;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	
/**
	 * @return the ctrtptynm
	 */
	public String getCtrtptynm() {
		return ctrtptynm;
	}

	/**
	 * @param ctrtptynm the ctrtptynm to set
	 */
	public void setCtrtptynm(String ctrtptynm) {
		this.ctrtptynm = ctrtptynm;
	}

	/**
	 * @return the propmqcqty
	 */
	public String getPropmqcqty() {
		return propmqcqty;
	}

	/**
	 * @param propmqcqty the propmqcqty to set
	 */
	public void setPropmqcqty(String propmqcqty) {
		this.propmqcqty = propmqcqty;
	}

	/**
	 * @return the ubitnm
	 */
	public String getUnitnm() {
		return unitnm;
	}

	/**
	 * @param ubitnm the ubitnm to set
	 */
	public void setUnitnm(String ubitnm) {
		this.unitnm = ubitnm;
	}

	/**
	 * @return the propofccd
	 */
	public String getPropofccd() {
		return propofccd;
	}

	/**
	 * @param propofccd the propofccd to set
	 */
	public void setPropofccd(String propofccd) {
		this.propofccd = propofccd;
	}

	
	
/**
	 * @return the emaillistcnt
	 */
	public String getEmaillistcnt() {
		return emaillistcnt;
	}

	/**
	 * @param emaillistcnt the emaillistcnt to set
	 */
	public void setEmaillistcnt(String emaillistcnt) {
		this.emaillistcnt = emaillistcnt;
	}

	/**
	 * @return the effdt
	 */
	public String getEffdt() {
		return effdt;
	}

	/**
	 * @param effdt the effdt to set
	 */
	public void setEffdt(String effdt) {
		this.effdt = effdt;
	}

	/**
	 * @return the expdt
	 */
	public String getExpdt() {
		return expdt;
	}

	/**
	 * @param expdt the expdt to set
	 */
	public void setExpdt(String expdt) {
		this.expdt = expdt;
	}

	
/**
	 * @return the scpfxcdlist
	 */
	public List getScpfxcdlist() {
		return scpfxcdlist;
	}

	/**
	 * @param scpfxcdlist the scpfxcdlist to set
	 */
	public void setScpfxcdlist(List scpfxcdlist) {
		this.scpfxcdlist = scpfxcdlist;
	}

/**
	 * @return the row
	 */
	public String getRow() {
		return row;
	}

	/**
	 * @param row the row to set
	 */
	public void setRow(String row) {
		this.row = row;
	}

	/**
	 * @return the fcmd
	 */
	public String getFcmd() {
		return fcmd;
	}

	/**
	 * @param fcmd the fcmd to set
	 */
	public void setFcmd(String fcmd) {
		this.fcmd = fcmd;
	}

    /**
	 * @return the resultStrArray
	 */
	public String[] getResultStrArray() {
		return resultStrArray;
	}

	/**
	 * @param resultStrArray the resultStrArray to set
	 */
	public void setResultStrArray(String[] resultStrArray) {
		this.resultStrArray = resultStrArray;
	}

/**
	 * @return the propstsnm
	 */
	public String getPropstsnm() {
		return propstsnm;
	}

	/**
	 * @param propstsnm the propstsnm to set
	 */
	public void setPropstsnm(String propstsnm) {
		this.propstsnm = propstsnm;
	}

/**
	 * @return the usrid
	 */
	public String getUsrid() {
		return usrid;
	}

	/**
	 * @param usrid the usrid to set
	 */
	public void setUsrid(String usrid) {
		this.usrid = usrid;
	}

/**
	 * @return the mstexistflg
	 */
	public String getMstexistflg() {
		return mstexistflg;
	}

	/**
	 * @param mstexistflg the mstexistflg to set
	 */
	public void setMstexistflg(String mstexistflg) {
		this.mstexistflg = mstexistflg;
	}

/**
	 * @return the subscEml
	 */
	public String getSubscEml() {
		return subscEml;
	}

	/**
	 * @param subscEml the subscEml to set
	 */
	public void setSubscEml(String subscEml) {
		this.subscEml = subscEml;
	}

	/**
	 * @return the ntfcSeq
	 */
	public String getNtfcSeq() {
		return ntfcSeq;
	}

	/**
	 * @param ntfcSeq the ntfcSeq to set
	 */
	public void setNtfcSeq(String ntfcSeq) {
		this.ntfcSeq = ntfcSeq;
	}

	/**
	 * @return the subscRmk
	 */
	public String getSubscRmk() {
		return subscRmk;
	}

	/**
	 * @param subscRmk the subscRmk to set
	 */
	public void setSubscRmk(String subscRmk) {
		this.subscRmk = subscRmk;
	}

	/**
	 * @return the creDt
	 */
	public String getCreDt() {
		return creDt;
	}

	/**
	 * @param creDt the creDt to set
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}

	/**
	 * @return the creUsrId
	 */
	public String getCreUsrId() {
		return creUsrId;
	}

	/**
	 * @param creUsrId the creUsrId to set
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	/**
	 * @return the creUsrNm
	 */
	public String getCreUsrNm() {
		return creUsrNm;
	}

	/**
	 * @param creUsrNm the creUsrNm to set
	 */
	public void setCreUsrNm(String creUsrNm) {
		this.creUsrNm = creUsrNm;
	}

	/**
	 * @return the deltDt
	 */
	public String getDeltDt() {
		return deltDt;
	}

	/**
	 * @param deltDt the deltDt to set
	 */
	public void setDeltDt(String deltDt) {
		this.deltDt = deltDt;
	}

	/**
	 * @return the deltUsrId
	 */
	public String getDeltUsrId() {
		return deltUsrId;
	}

	/**
	 * @param deltUsrId the deltUsrId to set
	 */
	public void setDeltUsrId(String deltUsrId) {
		this.deltUsrId = deltUsrId;
	}

	/**
	 * @return the deltUsrNm
	 */
	public String getDeltUsrNm() {
		return deltUsrNm;
	}

	/**
	 * @param deltUsrNm the deltUsrNm to set
	 */
	public void setDeltUsrNm(String deltUsrNm) {
		this.deltUsrNm = deltUsrNm;
	}

/**
	 * @return the idelFlg
	 */
	public String getIdelFlg() {
		return idelFlg;
	}

	/**
	 * @param idelFlg the idelFlg to set
	 */
	public void setIdelFlg(String idelFlg) {
		this.idelFlg = idelFlg;
	}

/**
	 * @return the tmlDwllFlg
	 */
	public String getTmlDwllFlg() {
		return tmlDwllFlg;
	}

	/**
	 * @param tmlDwllFlg the tmlDwllFlg to set
	 */
	public void setTmlDwllFlg(String tmlDwllFlg) {
		this.tmlDwllFlg = tmlDwllFlg;
	}

	/**
	 * @return the enrDwllFlg
	 */
	public String getEnrDwllFlg() {
		return enrDwllFlg;
	}

	/**
	 * @param enrDwllFlg the enrDwllFlg to set
	 */
	public void setEnrDwllFlg(String enrDwllFlg) {
		this.enrDwllFlg = enrDwllFlg;
	}

	/**
	 * @return the destDwllFlg
	 */
	public String getDestDwllFlg() {
		return destDwllFlg;
	}

	/**
	 * @param destDwllFlg the destDwllFlg to set
	 */
	public void setDestDwllFlg(String destDwllFlg) {
		this.destDwllFlg = destDwllFlg;
	}

	/**
	 * @return the vslDlayFlg
	 */
	public String getVslDlayFlg() {
		return vslDlayFlg;
	}

	/**
	 * @param vslDlayFlg the vslDlayFlg to set
	 */
	public void setVslDlayFlg(String vslDlayFlg) {
		this.vslDlayFlg = vslDlayFlg;
	}

	/**
	 * @return the exptSetUsrId
	 */
	public String getExptSetUsrId() {
		return exptSetUsrId;
	}

	/**
	 * @param exptSetUsrId the exptSetUsrId to set
	 */
	public void setExptSetUsrId(String exptSetUsrId) {
		this.exptSetUsrId = exptSetUsrId;
	}

	/**
	 * @return the exptSetDt
	 */
	public String getExptSetDt() {
		return exptSetDt;
	}

	/**
	 * @param exptSetDt the exptSetDt to set
	 */
	public void setExptSetDt(String exptSetDt) {
		this.exptSetDt = exptSetDt;
	}

	/**
	 * @return the exptSetUsrName
	 */
	public String getExptSetUsrName() {
		return exptSetUsrName;
	}

	/**
	 * @param exptSetUsrName the exptSetUsrName to set
	 */
	public void setExptSetUsrName(String exptSetUsrName) {
		this.exptSetUsrName = exptSetUsrName;
	}

	/**
	 * @return the schTp
	 */
	public String getSchTp() {
		return schTp;
	}

	/**
	 * @param schTp the schTp to set
	 */
	public void setSchTp(String schTp) {
		this.schTp = schTp;
	}

	
	/**
	 * @return the chk
	 */
	public String getChk() {
		return chk;
	}

	/**
	 * @return the dwllExptRmk
	 */
	public String getDwllExptRmk() {
		return dwllExptRmk;
	}

	/**
	 * @param chk the chk to set
	 */
	public void setChk(String chk) {
		this.chk = chk;
	}

	/**
	 * @param dwllExptRmk the dwllExptRmk to set
	 */
	public void setDwllExptRmk(String dwllExptRmk) {
		this.dwllExptRmk = dwllExptRmk;
	}

	/**
	 * @return the custCd
	 */
	public String getCustCd() {
		return custCd;
	}

	/**
	 * @param custCd the custCd to set
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * @return the emlAddr
	 */
	public String getEmlAddr() {
		return emlAddr;
	}

	/**
	 * @param emlAddr the emlAddr to set
	 */
	public void setEmlAddr(String emlAddr) {
		this.emlAddr = emlAddr;
	}

	/**
	 * @return the ofcCd
	 */
	public String getOfcCd() {
		return ofcCd;
	}

	/**
	 * @param ofcCd the ofcCd to set
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * @return the custCntCd
	 */
	public String getCustCntCd() {
		return custCntCd;
	}

	/**
	 * @param custCntCd the custCntCd to set
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * @return the custSeq
	 */
	public String getCustSeq() {
		return custSeq;
	}

	/**
	 * @param custSeq the custSeq to set
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * @return the emlFmCrmFlg
	 */
	public String getEmlFmCrmFlg() {
		return emlFmCrmFlg;
	}

	/**
	 * @param emlFmCrmFlg the emlFmCrmFlg to set
	 */
	public void setEmlFmCrmFlg(String emlFmCrmFlg) {
		this.emlFmCrmFlg = emlFmCrmFlg;
	}
	
	/**
	 * @return the emlBkgOrgFlg
	 */
	public String getEmlBkgOrgFlg() {
		return emlBkgOrgFlg;
	}

	/**
	 * @param emlBkgOrgFlg the emlBkgOrgFlg to set
	 */
	public void setEmlBkgOrgFlg(String emlBkgOrgFlg) {
		this.emlBkgOrgFlg = emlBkgOrgFlg;
	}
	
	/**
	 * @return the emlBkgDestFlg
	 */
	public String getEmlBkgDestFlg() {
		return emlBkgDestFlg;
	}

	/**
	 * @param emlBkgDestFlg the emlBkgDestFlg to set
	 */
	public void setEmlBkgDestFlg(String emlBkgDestFlg) {
		this.emlBkgDestFlg = emlBkgDestFlg;
	}
	
	/**
	 * @return the emlBkgOtrFlg
	 */
	public String getEmlBkgOtrFlg() {
		return emlBkgOtrFlg;
	}

	/**
	 * @param emlBkgOtrFlg the emlBkgOtrFlg to set
	 */
	public void setEmlBkgOtrFlg(String emlBkgOtrFlg) {
		this.emlBkgOtrFlg = emlBkgOtrFlg;
	}
	
	/**
	 * @return the creOfcCd
	 */
	public String getCreOfcCd() {
		return creOfcCd;
	}

	/**
	 * @param creOfcCd the creOfcCd to set
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}

	/**
	 * @return the sndOptCdAw
	 */
	public String getSndOptCdAw() {
		return sndOptCdAw;
	}

	/**
	 * @param sndOptCdAw the sndOptCdAw to set
	 */
	public void setSndOptCdAw(String sndOptCdAw) {
		this.sndOptCdAw = sndOptCdAw;
	}
	
	/**
	 * @return the sndOptCdOt
	 */
	public String getSndOptCdOt() {
		return sndOptCdOt;
	}

	/**
	 * @param sndOptCdOt the sndOptCdOt to set
	 */
	public void setSndOptCdOt(String sndOptCdOt) {
		this.sndOptCdOt = sndOptCdOt;
	}
	
	/**
	 * @return the fExptFlg
	 */
	public String getFExptFlg() {
		return fExptFlg;
	}

	/**
	 * @param fExptFlg the fExptFlg to set
	 */
	public void setFExptFlg(String fExptFlg) {
		this.fExptFlg = fExptFlg;
	}
	
	/**
	 * @return the otSndHist
	 */
	public String getOtSndHist() {
		return otSndHist;
	}

	/**
	 * @param otSndHist the otSndHist to set
	 */
	public void setOtSndHist(String otSndHist) {
		this.otSndHist = otSndHist;
	}
	
	/**
	 * @return the bkgTmlDwllFlg
	 */
	public String getBkgTmlDwllFlg() {
		return bkgTmlDwllFlg;
	}
	
	/**
	 * @param bkgTmlDwllFlg the bkgTmlDwllFlg to set
	 */
	public void setBkgTmlDwllFlg(String bkgTmlDwllFlg) {
		this.bkgTmlDwllFlg = bkgTmlDwllFlg;
	}

	/**
	 * @return the bkgEnrDwllFlg
	 */
	public String getBkgEnrDwllFlg() {
		return bkgEnrDwllFlg;
	}
	
	/**
	 * @param bkgEnrDwllFlg the bkgEnrDwllFlg to set
	 */
	public void setBkgEnrDwllFlg(String bkgEnrDwllFlg) {
		this.bkgEnrDwllFlg = bkgEnrDwllFlg;
	}

	/**
	 * @return the bkgDestDwllFlg
	 */
	public String getBkgDestDwllFlg() {
		return bkgDestDwllFlg;
	}
	
	/**
	 * @param bkgDestDwllFlg the bkgDestDwllFlg to set
	 */
	public void setBkgDestDwllFlg(String bkgDestDwllFlg) {
		this.bkgDestDwllFlg = bkgDestDwllFlg;
	}

	/**
	 * @return the bkgVslDlayFlg
	 */
	public String getBkgVslDlayFlg() {
		return bkgVslDlayFlg;
	}
	
	/**
	 * @param bkgVslDlayFlg the bkgVslDlayFlg to set
	 */
	public void setBkgVslDlayFlg(String bkgVslDlayFlg) {
		this.bkgVslDlayFlg = bkgVslDlayFlg;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setScpfxcd(JSPUtil.getParameter(request, prefix + "sc_pfx_cd", ""));
		setCtrtexpdt(JSPUtil.getParameter(request, prefix + "ctrt_exp_dt", ""));
		setScno(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setMtchflg(JSPUtil.getParameter(request, prefix + "mtch_flg", ""));
		setCtrteffdt(JSPUtil.getParameter(request, prefix + "ctrt_eff_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		
		setCtrtptynm(JSPUtil.getParameter(request, prefix + "ctrt_pty_nm", ""));
		setPropmqcqty(JSPUtil.getParameter(request, prefix + "prop_mqc_qty", ""));
		setUnitnm(JSPUtil.getParameter(request, prefix + "unit_nm", ""));
		setPropofccd(JSPUtil.getParameter(request, prefix + "prop_ofc_cd", ""));
		
		setEmaillistcnt(JSPUtil.getParameter(request, prefix + "email_list_cnt", ""));
		setEffdt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setExpdt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setRow(JSPUtil.getParameter(request, prefix + "row", ""));
		setFcmd(JSPUtil.getParameter(request, prefix + "f_cmd", ""));
		setPropstsnm(JSPUtil.getParameter(request, prefix + "prop_sts_nm", ""));
		setUsrid(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setMstexistflg(JSPUtil.getParameter(request, prefix + "mst_exist_flg", ""));
		
		setSubscEml(JSPUtil.getParameter(request, prefix + "subsc_eml", ""));
		setNtfcSeq(JSPUtil.getParameter(request, prefix + "ntfc_seq", ""));
		setSubscRmk(JSPUtil.getParameter(request, prefix + "subsc_rmk", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCreUsrNm(JSPUtil.getParameter(request, prefix + "cre_usr_nm", ""));
		setDeltDt(JSPUtil.getParameter(request, prefix + "delt_dt", ""));
		setDeltUsrId(JSPUtil.getParameter(request, prefix + "delt_usr_id", ""));
		setDeltUsrNm(JSPUtil.getParameter(request, prefix + "delt_usr_nm", ""));
		setIdelFlg(JSPUtil.getParameter(request, prefix + "i_del_flg", ""));
		
		
		setTmlDwllFlg(JSPUtil.getParameter(request, prefix + "tml_dwll_flg", ""));
		setEnrDwllFlg(JSPUtil.getParameter(request, prefix + "enr_dwll_flg", ""));
		setDestDwllFlg(JSPUtil.getParameter(request, prefix + "dest_dwll_flg", ""));
		setVslDlayFlg(JSPUtil.getParameter(request, prefix + "vsl_dlay_flg", ""));
		setExptSetUsrId(JSPUtil.getParameter(request, prefix + "expt_set_usr_id", ""));
		setExptSetDt(JSPUtil.getParameter(request, prefix + "expt_set_dt", ""));
		setExptSetUsrName(JSPUtil.getParameter(request, prefix + "expt_set_usr_name", ""));
		setSchTp(JSPUtil.getParameter(request, prefix + "sch_tp", ""));
		setChk(JSPUtil.getParameter(request, prefix + "chk", ""));
		setDwllExptRmk(JSPUtil.getParameter(request, prefix + "dwll_expt_rmk", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		
		setEmlAddr(JSPUtil.getParameter(request, prefix + "eml_addr", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setEmlFmCrmFlg(JSPUtil.getParameter(request, prefix + "eml_fm_crm_flg", ""));
		setEmlBkgOrgFlg(JSPUtil.getParameter(request, prefix + "eml_bkg_org_flg", ""));
		setEmlBkgDestFlg(JSPUtil.getParameter(request, prefix + "eml_bkg_dest_flg", ""));
		setEmlBkgOtrFlg(JSPUtil.getParameter(request, prefix + "eml_bkg_otr_flg", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setSndOptCdAw(JSPUtil.getParameter(request, prefix + "snd_opt_cd_aw", ""));
		setSndOptCdOt(JSPUtil.getParameter(request, prefix + "snd_opt_cd_ot", ""));
		setFExptFlg(JSPUtil.getParameter(request, prefix + "f_expt_flg", ""));
		setOtSndHist(JSPUtil.getParameter(request, prefix + "ot_snd_hist", ""));

		setBkgTmlDwllFlg(JSPUtil.getParameter(request, prefix + "bkg_tml_dwll_flg", ""));
		setBkgEnrDwllFlg(JSPUtil.getParameter(request, prefix + "bkg_enr_dwll_flg", ""));
		setBkgDestDwllFlg(JSPUtil.getParameter(request, prefix + "bkg_dest_dwll_flg", ""));
		setBkgVslDlayFlg(JSPUtil.getParameter(request, prefix + "bkg_vsl_dlay_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DwllNtfcSrchVO[]
	 */
	public DwllNtfcSrchVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DwllNtfcSrchVO[]
	 */
	public DwllNtfcSrchVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DwllNtfcSrchVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] scpfxcd = (JSPUtil.getParameter(request, prefix	+ "sc_pfx_cd", length));
			String[] ctrtexpdt = (JSPUtil.getParameter(request, prefix	+ "ctrt_exp_dt", length));
			String[] scno = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] mtchflg = (JSPUtil.getParameter(request, prefix	+ "mtchflg", length));
			String[] ctrteffdt = (JSPUtil.getParameter(request, prefix	+ "ctrt_eff_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			String[] ctrtptynm = (JSPUtil.getParameter(request, prefix	+ "ctrt_pty_nm", length));
			String[] propmqcqty = (JSPUtil.getParameter(request, prefix	+ "prop_mqc_qty", length));
			String[] unitnm = (JSPUtil.getParameter(request, prefix	+ "unit_nm", length));
			String[] propofccd = (JSPUtil.getParameter(request, prefix	+ "prop_ofc_cd", length));
			String[] emaillistcnt = (JSPUtil.getParameter(request, prefix	+ "email_list_cnt", length));
			String[] effdt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] expdt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] row = (JSPUtil.getParameter(request, prefix	+ "row1", length));
			String[] fcmd = (JSPUtil.getParameter(request, prefix	+ "f_cmd", length));
			String[] propstsnm = (JSPUtil.getParameter(request, prefix	+ "prop_sts_nm", length));
			String[] usrid = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] mstexistflg = (JSPUtil.getParameter(request, prefix	+ "mst_exist_flg", length));
			
			String[] subscEml = (JSPUtil.getParameter(request, prefix	+ "subsc_eml", length));
			String[] ntfcSeq = (JSPUtil.getParameter(request, prefix	+ "ntfc_seq", length));
			String[] subscRmk = (JSPUtil.getParameter(request, prefix	+ "subsc_rmk", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creUsrNm = (JSPUtil.getParameter(request, prefix	+ "cre_usr_nm", length));
			String[] deltDt = (JSPUtil.getParameter(request, prefix	+ "delt_dt", length));
			String[] deltUsrId = (JSPUtil.getParameter(request, prefix	+ "delt_usr_id", length));
			String[] deltUsrNm = (JSPUtil.getParameter(request, prefix	+ "delt_usr_nm", length));
			String[] idelFlg = (JSPUtil.getParameter(request, prefix	+ "i_del_flg", length));
			
			String[] tmlDwllFlg = (JSPUtil.getParameter(request, prefix + "tml_dwll_flg", length));
			String[] enrDwllFlg=(JSPUtil.getParameter(request, prefix + "enr_dwll_flg", length));
			String[] destDwllFlg =(JSPUtil.getParameter(request, prefix + "dest_dwll_flg", length));
			String[] vslDlayFlg = (JSPUtil.getParameter(request, prefix + "vsl_dlay_flg", length));
			String[] exptSetUsrId =(JSPUtil.getParameter(request, prefix + "expt_set_usr_id", length));
			String[] exptSetDt = (JSPUtil.getParameter(request, prefix + "expt_set_dt", length));
			String[] exptSetUsrName = (JSPUtil.getParameter(request, prefix + "expt_set_usr_name", length));
			String[] schTp = (JSPUtil.getParameter(request, prefix + "sch_tp", length));
			String[] chk = (JSPUtil.getParameter(request, prefix + "chk", length));
			String[] dwllExptRmk = (JSPUtil.getParameter(request, prefix + "dwll_expt_rmk", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix + "cust_cd", length));
			
			String[] emlAddr = (JSPUtil.getParameter(request, prefix + "eml_addr", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix + "ofc_cd", length));
			
			String[] custCntCd = (JSPUtil.getParameter(request, prefix + "cust_cnt_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix + "cust_seq", length));
			String[] emlFmCrmFlg = (JSPUtil.getParameter(request, prefix + "eml_fm_crm_flg", length));
			String[] emlBkgOrgFlg = (JSPUtil.getParameter(request, prefix + "eml_bkg_org_flg", length));
			String[] emlBkgDestFlg = (JSPUtil.getParameter(request, prefix + "eml_bkg_dest_flg", length));
			String[] emlBkgOtrFlg = (JSPUtil.getParameter(request, prefix + "eml_bkg_otr_flg", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix + "cre_ofc_cd", length));
			String[] sndOptCdAw = (JSPUtil.getParameter(request, prefix + "snd_opt_cd_aw", length));
			String[] sndOptCdOt = (JSPUtil.getParameter(request, prefix + "snd_opt_cd_ot", length));
			String[] fExptFlg = (JSPUtil.getParameter(request, prefix + "f_expt_flg", length));
			String[] otSndHist = (JSPUtil.getParameter(request, prefix + "ot_snd_hist", length));

			String[] bkgTmlDwllFlg = (JSPUtil.getParameter(request, prefix + "bkg_tml_dwll_flg", length));
			String[] bkgEnrDwllFlg=(JSPUtil.getParameter(request, prefix + "bkg_enr_dwll_flg", length));
			String[] bkgDestDwllFlg =(JSPUtil.getParameter(request, prefix + "bkg_dest_dwll_flg", length));
			String[] bkgVslDlayFlg = (JSPUtil.getParameter(request, prefix + "bkg_vsl_dlay_flg", length));

			for (int i = 0; i < length; i++) {
				model = new DwllNtfcSrchVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (scpfxcd[i] != null)
					model.setScpfxcd(scpfxcd[i]);
				if (ctrtexpdt[i] != null)
					model.setCtrtexpdt(ctrtexpdt[i]);
				if (scno[i] != null)
					model.setScno(scno[i]);
				if (mtchflg[i] != null)
					model.setMtchflg(mtchflg[i]);
				if (ctrteffdt[i] != null)
					model.setCtrteffdt(ctrteffdt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				
				if (ctrtptynm[i] != null)
					model.setCtrtptynm(ctrtptynm[i]);
				if (propmqcqty[i] != null)
					model.setPropmqcqty(propmqcqty[i]);
				if (unitnm[i] != null)
					model.setUnitnm(unitnm[i]);
				if (propofccd[i] != null)
					model.setPropofccd(propofccd[i]);
				
				if (emaillistcnt[i] != null)
					model.setEmaillistcnt(emaillistcnt[i]);
				if (effdt[i] != null)
					model.setEffdt(effdt[i]);
				if (expdt[i] != null)
					model.setExpdt(expdt[i]);
				if (row[i] != null)
					model.setRow(row[i]);
				if (fcmd[i] != null)
					model.setFcmd(fcmd[i]);
				if (propstsnm[i] != null)
					model.setPropstsnm(propstsnm[i]);
				if (usrid[i] != null)
					model.setUsrid(usrid[i]);
				if (mstexistflg[i] != null)
					model.setMstexistflg(mstexistflg[i]);
				
				
				if (subscEml[i] != null)
					model.setSubscEml(subscEml[i]);
				if (ntfcSeq[i] != null)
					model.setNtfcSeq(ntfcSeq[i]);
				if (subscRmk[i] != null)
					model.setSubscRmk(subscRmk[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (creUsrNm[i] != null)
					model.setCreUsrNm(creUsrNm[i]);
				if (deltDt[i] != null)
					model.setDeltDt(deltDt[i]);
				if (deltUsrId[i] != null)
					model.setDeltUsrId(deltUsrId[i]);
				if (deltUsrNm[i] != null)
					model.setDeltUsrNm(deltUsrNm[i]);
				if (idelFlg[i] != null)
					model.setIdelFlg(idelFlg[i]);
				
				
				if (tmlDwllFlg[i] != null)
					model.setTmlDwllFlg(tmlDwllFlg[i]);
				if (enrDwllFlg[i] != null)
					model.setEnrDwllFlg(enrDwllFlg[i]);
				if (destDwllFlg[i] != null)
					model.setDestDwllFlg(destDwllFlg[i]);
				if (vslDlayFlg[i] != null)
					model.setVslDlayFlg(vslDlayFlg[i]);
				if (exptSetUsrId[i] != null)
					model.setExptSetUsrId(exptSetUsrId[i]);
				if (exptSetDt[i] != null)
					model.setExptSetDt(exptSetDt[i]);
				if (exptSetUsrName[i] != null)
					model.setExptSetUsrName(exptSetUsrName[i]);
				if (schTp[i] != null)
					model.setSchTp(schTp[i]);
				if (chk[i] != null)
					model.setChk(chk[i]);
				if (dwllExptRmk[i] != null)
					model.setDwllExptRmk(dwllExptRmk[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				
				if (emlAddr[i] != null)
					model.setEmlAddr(emlAddr[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (emlFmCrmFlg[i] != null)
					model.setEmlFmCrmFlg(emlFmCrmFlg[i]);
				if (emlBkgOrgFlg[i] != null)
					model.setEmlBkgOrgFlg(emlBkgOrgFlg[i]);
				if (emlBkgDestFlg[i] != null)
					model.setEmlBkgDestFlg(emlBkgDestFlg[i]);
				if (emlBkgOtrFlg[i] != null)
					model.setEmlBkgOtrFlg(emlBkgOtrFlg[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (sndOptCdAw[i] != null)
					model.setSndOptCdAw(sndOptCdAw[i]);
				if (sndOptCdOt[i] != null)
					model.setSndOptCdOt(sndOptCdOt[i]);
				if (fExptFlg[i] != null)
					model.setFExptFlg(fExptFlg[i]);
				if (otSndHist[i] != null)
					model.setOtSndHist(otSndHist[i]);

				if (bkgTmlDwllFlg[i] != null)
					model.setBkgTmlDwllFlg(bkgTmlDwllFlg[i]);
				if (bkgEnrDwllFlg[i] != null)
					model.setBkgEnrDwllFlg(bkgEnrDwllFlg[i]);
				if (bkgDestDwllFlg[i] != null)
					model.setBkgDestDwllFlg(bkgDestDwllFlg[i]);
				if (bkgVslDlayFlg[i] != null)
					model.setBkgVslDlayFlg(bkgVslDlayFlg[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDwllNtfcSrchVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DwllNtfcSrchVO[]
	 */
	public DwllNtfcSrchVO[] getDwllNtfcSrchVOs(){
		DwllNtfcSrchVO[] vos = (DwllNtfcSrchVO[])models.toArray(new DwllNtfcSrchVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scpfxcd = this.scpfxcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtexpdt = this.ctrtexpdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scno = this.scno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtchflg = this.mtchflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrteffdt = this.ctrteffdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtptynm = this.ctrtptynm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propmqcqty = this.propmqcqty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unitnm = this.unitnm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propofccd = this.propofccd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.emaillistcnt = this.emaillistcnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effdt = this.effdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expdt = this.expdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.row = this.row .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcmd = this.fcmd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propstsnm = this.propstsnm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrid = this.usrid.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstexistflg = this.mstexistflg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		

		this.subscEml = this.subscEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfcSeq = this.ntfcSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subscRmk = this.subscRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrNm = this.creUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltDt = this.deltDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltUsrId = this.deltUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltUsrNm = this.deltUsrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.tmlDwllFlg = this.tmlDwllFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.enrDwllFlg = this.enrDwllFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destDwllFlg = this.destDwllFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDlayFlg = this.vslDlayFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptSetUsrId = this.exptSetUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptSetDt = this.exptSetDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptSetUsrName = this.exptSetUsrName.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schTp = this.schTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk = this.chk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwllExptRmk = this.dwllExptRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.emlAddr = this.emlAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.custCntCd = this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlFmCrmFlg = this.emlFmCrmFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlBkgOrgFlg = this.emlBkgOrgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlBkgDestFlg = this.emlBkgDestFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlBkgOtrFlg = this.emlBkgOtrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndOptCdAw = this.sndOptCdAw.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndOptCdOt = this.sndOptCdOt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fExptFlg = this.fExptFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otSndHist = this.otSndHist.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.bkgTmlDwllFlg = this.bkgTmlDwllFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgEnrDwllFlg = this.bkgEnrDwllFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDestDwllFlg = this.bkgDestDwllFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgVslDlayFlg = this.bkgVslDlayFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
