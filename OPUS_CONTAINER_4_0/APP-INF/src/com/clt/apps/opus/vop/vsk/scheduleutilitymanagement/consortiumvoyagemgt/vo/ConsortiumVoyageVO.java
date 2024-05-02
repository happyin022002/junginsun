/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ConsortiumVoyageVO.java
 *@FileTitle : ConsortiumVoyageVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.12.30
 *@LastModifier : dongsoo
 *@LastVersion : 1.0
 * 2014.12.30 dongsoo 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleutilitymanagement.consortiumvoyagemgt.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author dongsoo
 * @since J2EE 1.6
 * @see	..
 */
public class ConsortiumVoyageVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<ConsortiumVoyageVO> models = new ArrayList<ConsortiumVoyageVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /*	Column Info	*/
    private String vslSlanCd = null;

    /*	Column Info	*/
    private String vslCd = null;

    /*	Column Info	*/
    private String skdVoyNo = null;

    /*	Column Info	*/
    private String skdDirCd = null;

    /*	Column Info	*/
    private String vpsPortCd = null;

    /*	Column Info	*/
    private String pfEtaDt = null;

    /*	Column Info	*/
    private String pfEtbDt = null;

    /*	Column Info	*/
    private String pfEtdDt = null;

    /*	Column Info	*/
    private String initEtaDt = null;

    /*	Column Info	*/
    private String initEtbDt = null;

    /*	Column Info	*/
    private String initEtdDt = null;

    /*	Column Info	*/
    private String vpsEtaDt = null;

    /*	Column Info	*/
    private String vpsEtbDt = null;

    /*	Column Info	*/
    private String vpsEtdDt = null;

    /*	Column Info	*/
    private String ibCssmVoyNo = null;

    /*	Column Info	*/
    private String obCssmVoyNo = null;

    /*	Column Info	*/
    private String updUsrId = null;

    /*	Column Info	*/
    private String updDt = null;

    /*	Column Info	*/
    private String fmDt = null;

    /*	Column Info	*/
    private String toDt = null;

    /*	Column Info	*/
    private String cvCbm1 = null;

    /*	Column Info	*/
    private String cvCbm2 = null;

    /*	Column Info	*/
    private String chkVirtualPort = null;

    /*	Column Info	*/
    private String turnPortIndCd = null;

    /*	Column Info	*/
    private String skdDirCdOrd = null;

    private String clptSeq = null;

    private String turnPortFlg = null;

    private String turnSkdVoyNo = null;

    private String cssmVoyInitCreFlg = null;

    /* Column Info */
    private String realTurnPortIndCd = null;

    /* Column Info */
    private String clptIndSeq = null;

    /* Column Info */
    private String vtAddCallFlg = null;

    /* Column Info */
    private String voyage = null;

    /* Column Info */
    private String chkVoyage = null;

    /* Column Info */
    private String voyAllSetFlg = null;

    /* Column Info */
    private String turnSkdDirCd = null;

    /* Column Info */
    private String realClptSeq = null;

    /* Column Info */
    private String firstTurnPortClptSeq = null;

    /* Column Info */
    private String virPortClptSeq = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    /**	Constructor	*/
    public ConsortiumVoyageVO() {
    }

    public ConsortiumVoyageVO(String ibflag, String pagerows, String vslSlanCd, String vslCd, String skdVoyNo, String skdDirCd, String vpsPortCd, String pfEtaDt, String pfEtbDt, String pfEtdDt, String initEtaDt, String initEtbDt, String initEtdDt, String vpsEtaDt, String vpsEtbDt, String vpsEtdDt, String ibCssmVoyNo, String obCssmVoyNo, String updUsrId, String updDt, String fmDt, String toDt, String cvCbm1, String cvCbm2, String chkVirtualPort, String turnPortIndCd, String skdDirCdOrd, String clptSeq, String turnPortFlg, String turnSkdVoyNo, String cssmVoyInitCreFlg, String realTurnPortIndCd, String clptIndSeq, String vtAddCallFlg, String voyage, String chkVoyage, String voyAllSetFlg, String turnSkdDirCd, String realClptSeq, String firstTurnPortClptSeq, String virPortClptSeq) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.vslSlanCd = vslSlanCd;
        this.vslCd = vslCd;
        this.skdVoyNo = skdVoyNo;
        this.skdDirCd = skdDirCd;
        this.vpsPortCd = vpsPortCd;
        this.pfEtaDt = pfEtaDt;
        this.pfEtbDt = pfEtbDt;
        this.pfEtdDt = pfEtdDt;
        this.initEtaDt = initEtaDt;
        this.initEtbDt = initEtbDt;
        this.initEtdDt = initEtdDt;
        this.vpsEtaDt = vpsEtaDt;
        this.vpsEtbDt = vpsEtbDt;
        this.vpsEtdDt = vpsEtdDt;
        this.ibCssmVoyNo = ibCssmVoyNo;
        this.obCssmVoyNo = obCssmVoyNo;
        this.updUsrId = updUsrId;
        this.updDt = updDt;
        this.fmDt = fmDt;
        this.toDt = toDt;
        this.cvCbm1 = cvCbm1;
        this.cvCbm2 = cvCbm2;
        this.chkVirtualPort = chkVirtualPort;
        this.turnPortIndCd = turnPortIndCd;
        this.skdDirCdOrd = skdDirCdOrd;
        this.clptSeq = clptSeq;
        this.turnPortFlg = turnPortFlg;
        this.turnSkdVoyNo = turnSkdVoyNo;
        this.cssmVoyInitCreFlg = cssmVoyInitCreFlg;
        this.realTurnPortIndCd = realTurnPortIndCd;
        this.clptIndSeq = clptIndSeq;
        this.vtAddCallFlg = vtAddCallFlg;
        this.voyage = voyage;
        this.chkVoyage = chkVoyage;
        this.voyAllSetFlg = voyAllSetFlg;
        this.turnSkdDirCd = turnSkdDirCd;
        this.realClptSeq = realClptSeq;
        this.firstTurnPortClptSeq = firstTurnPortClptSeq;
        this.virPortClptSeq = virPortClptSeq;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("skd_dir_cd", getSkdDirCd());
        this.hashColumns.put("vps_port_cd", getVpsPortCd());
        this.hashColumns.put("pf_eta_dt", getPfEtaDt());
        this.hashColumns.put("pf_etb_dt", getPfEtbDt());
        this.hashColumns.put("pf_etd_dt", getPfEtdDt());
        this.hashColumns.put("init_eta_dt", getInitEtaDt());
        this.hashColumns.put("init_etb_dt", getInitEtbDt());
        this.hashColumns.put("init_etd_dt", getInitEtdDt());
        this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
        this.hashColumns.put("vps_etb_dt", getVpsEtbDt());
        this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
        this.hashColumns.put("ib_cssm_voy_no", getIbCssmVoyNo());
        this.hashColumns.put("ob_cssm_voy_no", getObCssmVoyNo());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("fm_dt", getFmDt());
        this.hashColumns.put("to_dt", getToDt());
        this.hashColumns.put("cv_cbm1", getCvCbm1());
        this.hashColumns.put("cv_cbm2", getCvCbm2());
        this.hashColumns.put("chk_virtual_port", getChkVirtualPort());
        this.hashColumns.put("turn_port_ind_cd", getTurnPortIndCd());
        this.hashColumns.put("skd_dir_cd_ord", getSkdDirCdOrd());
        this.hashColumns.put("clpt_seq", getClptSeq());
        this.hashColumns.put("turn_port_flg", getTurnPortFlg());
        this.hashColumns.put("turn_skd_voy_no", getTurnSkdVoyNo());
        this.hashColumns.put("cssm_voy_init_cre_flg", getCssmVoyInitCreFlg());
        this.hashColumns.put("real_turn_port_ind_cd", getRealTurnPortIndCd());
        this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
        this.hashColumns.put("vt_add_call_flg", getVtAddCallFlg());
        this.hashColumns.put("voyage", getVoyage());
        this.hashColumns.put("chk_voyage", getChkVoyage());
        this.hashColumns.put("voy_all_set_flg", getVoyAllSetFlg());
        this.hashColumns.put("turn_skd_dir_cd", getTurnSkdDirCd());
        this.hashColumns.put("real_clpt_seq", getRealClptSeq());
        this.hashColumns.put("first_turn_port_clpt_seq", getFirstTurnPortClptSeq());
        this.hashColumns.put("vir_port_clpt_seq", getVirPortClptSeq());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("vsl_slan_cd", "vslSlanCd");
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("skd_dir_cd", "skdDirCd");
        this.hashFields.put("vps_port_cd", "vpsPortCd");
        this.hashFields.put("pf_eta_dt", "pfEtaDt");
        this.hashFields.put("pf_etb_dt", "pfEtbDt");
        this.hashFields.put("pf_etd_dt", "pfEtdDt");
        this.hashFields.put("init_eta_dt", "initEtaDt");
        this.hashFields.put("init_etb_dt", "initEtbDt");
        this.hashFields.put("init_etd_dt", "initEtdDt");
        this.hashFields.put("vps_eta_dt", "vpsEtaDt");
        this.hashFields.put("vps_etb_dt", "vpsEtbDt");
        this.hashFields.put("vps_etd_dt", "vpsEtdDt");
        this.hashFields.put("ib_cssm_voy_no", "ibCssmVoyNo");
        this.hashFields.put("ob_cssm_voy_no", "obCssmVoyNo");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("fm_dt", "fmDt");
        this.hashFields.put("to_dt", "toDt");
        this.hashFields.put("cv_cbm1", "cvCbm1");
        this.hashFields.put("cv_cbm2", "cvCbm2");
        this.hashFields.put("chk_virtual_port", "chkVirtualPort");
        this.hashFields.put("turn_port_ind_cd", "turnPortIndCd");
        this.hashFields.put("skd_dir_cd_ord", "skdDirCdOrd");
        this.hashFields.put("clpt_seq", "clptSeq");
        this.hashFields.put("turn_port_flg", "turnPortFlg");
        this.hashFields.put("turn_skd_voy_no", "turnSkdVoyNo");
        this.hashFields.put("cssm_voy_init_cre_flg", "cssmVoyInitCreFlg");
        this.hashFields.put("real_turn_port_ind_cd", "realTurnPortIndCd");
        this.hashFields.put("clpt_ind_seq", "clptIndSeq");
        this.hashFields.put("vt_add_call_flg", "vtAddCallFlg");
        this.hashFields.put("voyage", "voyage");
        this.hashFields.put("chk_voyage", "chkVoyage");
        this.hashFields.put("voy_all_set_flg", "voyAllSetFlg");
        this.hashFields.put("turn_skd_dir_cd", "turnSkdDirCd");
        this.hashFields.put("real_clpt_seq", "realClptSeq");
        this.hashFields.put("first_turn_port_clpt_seq", "firstTurnPortClptSeq");
        this.hashFields.put("vir_port_clpt_seq", "virPortClptSeq");
        return this.hashFields;
    }

    //	Getters	and	Setters
    /**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
    public String getIbflag() {
        return this.ibflag;
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
	 * @return vslSlanCd
	 */
    public String getVslSlanCd() {
        return this.vslSlanCd;
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
	 * @return skdVoyNo
	 */
    public String getSkdVoyNo() {
        return this.skdVoyNo;
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
	 * @return vpsPortCd
	 */
    public String getVpsPortCd() {
        return this.vpsPortCd;
    }

    /**
	 * Column Info
	 * @return pfEtaDt
	 */
    public String getPfEtaDt() {
        return this.pfEtaDt;
    }

    /**
	 * Column Info
	 * @return pfEtbDt
	 */
    public String getPfEtbDt() {
        return this.pfEtbDt;
    }

    /**
	 * Column Info
	 * @return pfEtdDt
	 */
    public String getPfEtdDt() {
        return this.pfEtdDt;
    }

    /**
	 * Column Info
	 * @return initEtaDt
	 */
    public String getInitEtaDt() {
        return this.initEtaDt;
    }

    /**
	 * Column Info
	 * @return initEtbDt
	 */
    public String getInitEtbDt() {
        return this.initEtbDt;
    }

    /**
	 * Column Info
	 * @return initEtdDt
	 */
    public String getInitEtdDt() {
        return this.initEtdDt;
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
	 * @return vpsEtbDt
	 */
    public String getVpsEtbDt() {
        return this.vpsEtbDt;
    }

    /**
	 * Column Info
	 * @return vpsEtdDt
	 */
    public String getVpsEtdDt() {
        return this.vpsEtdDt;
    }

    /**
	 * Column Info
	 * @return ibCssmVoyNo
	 */
    public String getIbCssmVoyNo() {
        return this.ibCssmVoyNo;
    }

    /**
	 * Column Info
	 * @return obCssmVoyNo
	 */
    public String getObCssmVoyNo() {
        return this.obCssmVoyNo;
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
	 * @return updDt
	 */
    public String getUpdDt() {
        return this.updDt;
    }

    /**
	 * Column Info
	 * @return fmDt
	 */
    public String getFmDt() {
        return this.fmDt;
    }

    /**
	 * Column Info
	 * @return toDt
	 */
    public String getToDt() {
        return this.toDt;
    }

    /**
	 * Column Info
	 * @return cvCbm1
	 */
    public String getCvCbm1() {
        return this.cvCbm1;
    }

    /**
	 * Column Info
	 * @return cvCbm2
	 */
    public String getCvCbm2() {
        return this.cvCbm2;
    }

    /**
	 * Column Info
	 * @return chkVirtualPort
	 */
    public String getChkVirtualPort() {
        return this.chkVirtualPort;
    }

    /**
	 * Column Info
	 * @return turnPortIndCd
	 */
    public String getTurnPortIndCd() {
        return this.turnPortIndCd;
    }

    /**
	 * Column Info
	 * @return skdDirCdOrd
	 */
    public String getSkdDirCdOrd() {
        return this.skdDirCdOrd;
    }

    /**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param  ibflag
 	 */
    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
    }

    /**
	 * Page Number
	 * @param  pagerows
 	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    /**
	 * Column Info
	 * @param  vslSlanCd
 	 */
    public void setVslSlanCd(String vslSlanCd) {
        this.vslSlanCd = vslSlanCd;
    }

    /**
	 * Column Info
	 * @param  vslCd
 	 */
    public void setVslCd(String vslCd) {
        this.vslCd = vslCd;
    }

    /**
	 * Column Info
	 * @param  skdVoyNo
 	 */
    public void setSkdVoyNo(String skdVoyNo) {
        this.skdVoyNo = skdVoyNo;
    }

    /**
	 * Column Info
	 * @param  skdDirCd
 	 */
    public void setSkdDirCd(String skdDirCd) {
        this.skdDirCd = skdDirCd;
    }

    /**
	 * Column Info
	 * @param  vpsPortCd
 	 */
    public void setVpsPortCd(String vpsPortCd) {
        this.vpsPortCd = vpsPortCd;
    }

    /**
	 * Column Info
	 * @param  pfEtaDt
 	 */
    public void setPfEtaDt(String pfEtaDt) {
        this.pfEtaDt = pfEtaDt;
    }

    /**
	 * Column Info
	 * @param  pfEtbDt
 	 */
    public void setPfEtbDt(String pfEtbDt) {
        this.pfEtbDt = pfEtbDt;
    }

    /**
	 * Column Info
	 * @param  pfEtdDt
 	 */
    public void setPfEtdDt(String pfEtdDt) {
        this.pfEtdDt = pfEtdDt;
    }

    /**
	 * Column Info
	 * @param  initEtaDt
 	 */
    public void setInitEtaDt(String initEtaDt) {
        this.initEtaDt = initEtaDt;
    }

    /**
	 * Column Info
	 * @param  initEtbDt
 	 */
    public void setInitEtbDt(String initEtbDt) {
        this.initEtbDt = initEtbDt;
    }

    /**
	 * Column Info
	 * @param  initEtdDt
 	 */
    public void setInitEtdDt(String initEtdDt) {
        this.initEtdDt = initEtdDt;
    }

    /**
	 * Column Info
	 * @param  vpsEtaDt
 	 */
    public void setVpsEtaDt(String vpsEtaDt) {
        this.vpsEtaDt = vpsEtaDt;
    }

    /**
	 * Column Info
	 * @param  vpsEtbDt
 	 */
    public void setVpsEtbDt(String vpsEtbDt) {
        this.vpsEtbDt = vpsEtbDt;
    }

    /**
	 * Column Info
	 * @param  vpsEtdDt
 	 */
    public void setVpsEtdDt(String vpsEtdDt) {
        this.vpsEtdDt = vpsEtdDt;
    }

    /**
	 * Column Info
	 * @param  ibCssmVoyNo
 	 */
    public void setIbCssmVoyNo(String ibCssmVoyNo) {
        this.ibCssmVoyNo = ibCssmVoyNo;
    }

    /**
	 * Column Info
	 * @param  obCssmVoyNo
 	 */
    public void setObCssmVoyNo(String obCssmVoyNo) {
        this.obCssmVoyNo = obCssmVoyNo;
    }

    /**
	 * Column Info
	 * @param  updUsrId
 	 */
    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
    }

    /**
	 * Column Info
	 * @param  updDt
 	 */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    /**
	 * Column Info
	 * @param  fmDt
 	 */
    public void setFmDt(String fmDt) {
        this.fmDt = fmDt;
    }

    /**
	 * Column Info
	 * @param  toDt
 	 */
    public void setToDt(String toDt) {
        this.toDt = toDt;
    }

    /**
	 * Column Info
	 * @param  cvCbm1
 	 */
    public void setCvCbm1(String cvCbm1) {
        this.cvCbm1 = cvCbm1;
    }

    /**
	 * Column Info
	 * @param  cvCbm2
 	 */
    public void setCvCbm2(String cvCbm2) {
        this.cvCbm2 = cvCbm2;
    }

    /**
	 * Column Info
	 * @param  chkVirtualPort
 	 */
    public void setChkVirtualPort(String chkVirtualPort) {
        this.chkVirtualPort = chkVirtualPort;
    }

    /**
	 * Column Info
	 * @param  turnPortIndCd
 	 */
    public void setTurnPortIndCd(String turnPortIndCd) {
        this.turnPortIndCd = turnPortIndCd;
    }

    /**
	 * Column Info
	 * @param  skdDirCdOrd
 	 */
    public void setSkdDirCdOrd(String skdDirCdOrd) {
        this.skdDirCdOrd = skdDirCdOrd;
    }

    /**
	 * Column Info

 	 */
    public String getClptSeq() {
        return clptSeq;
    }

    public void setClptSeq(String clptSeq) {
        this.clptSeq = clptSeq;
    }

    public String getTurnPortFlg() {
        return turnPortFlg;
    }

    public void setTurnPortFlg(String turnPortFlg) {
        this.turnPortFlg = turnPortFlg;
    }

    public String getTurnSkdVoyNo() {
        return turnSkdVoyNo;
    }

    public void setTurnSkdVoyNo(String turnSkdVoyNo) {
        this.turnSkdVoyNo = turnSkdVoyNo;
    }

    public String getCssmVoyInitCreFlg() {
        return cssmVoyInitCreFlg;
    }

    public void setCssmVoyInitCreFlg(String cssmVoyInitCreFlg) {
        this.cssmVoyInitCreFlg = cssmVoyInitCreFlg;
    }

    public void setRealTurnPortIndCd(String realTurnPortIndCd) {
        this.realTurnPortIndCd = realTurnPortIndCd;
    }

    public String getRealTurnPortIndCd() {
        return this.realTurnPortIndCd;
    }

    public void setClptIndSeq(String clptIndSeq) {
        this.clptIndSeq = clptIndSeq;
    }

    public String getClptIndSeq() {
        return this.clptIndSeq;
    }

    public void setVtAddCallFlg(String vtAddCallFlg) {
        this.vtAddCallFlg = vtAddCallFlg;
    }

    public String getVtAddCallFlg() {
        return this.vtAddCallFlg;
    }

    public void setVoyage(String voyage) {
        this.voyage = voyage;
    }

    public String getVoyage() {
        return this.voyage;
    }

    public void setChkVoyage(String chkVoyage) {
        this.chkVoyage = chkVoyage;
    }

    public String getChkVoyage() {
        return this.chkVoyage;
    }

    public void setVoyAllSetFlg(String voyAllSetFlg) {
        this.voyAllSetFlg = voyAllSetFlg;
    }

    public String getVoyAllSetFlg() {
        return this.voyAllSetFlg;
    }

    public void setTurnSkdDirCd(String turnSkdDirCd) {
        this.turnSkdDirCd = turnSkdDirCd;
    }

    public String getTurnSkdDirCd() {
        return this.turnSkdDirCd;
    }

    public void setRealClptSeq(String realClptSeq) {
        this.realClptSeq = realClptSeq;
    }

    public String getRealClptSeq() {
        return this.realClptSeq;
    }

    public void setFirstTurnPortClptSeq(String firstTurnPortClptSeq) {
        this.firstTurnPortClptSeq = firstTurnPortClptSeq;
    }

    public String getFirstTurnPortClptSeq() {
        return this.firstTurnPortClptSeq;
    }

    public void setVirPortClptSeq(String virPortClptSeq) {
        this.virPortClptSeq = virPortClptSeq;
    }

    public String getVirPortClptSeq() {
        return this.virPortClptSeq;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        fromRequest(request, "");
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request, String prefix) {
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
        setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
        setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
        setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
        setPfEtaDt(JSPUtil.getParameter(request, prefix + "pf_eta_dt", ""));
        setPfEtbDt(JSPUtil.getParameter(request, prefix + "pf_etb_dt", ""));
        setPfEtdDt(JSPUtil.getParameter(request, prefix + "pf_etd_dt", ""));
        setInitEtaDt(JSPUtil.getParameter(request, prefix + "init_eta_dt", ""));
        setInitEtbDt(JSPUtil.getParameter(request, prefix + "init_etb_dt", ""));
        setInitEtdDt(JSPUtil.getParameter(request, prefix + "init_etd_dt", ""));
        setVpsEtaDt(JSPUtil.getParameter(request, prefix + "vps_eta_dt", ""));
        setVpsEtbDt(JSPUtil.getParameter(request, prefix + "vps_etb_dt", ""));
        setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
        setIbCssmVoyNo(JSPUtil.getParameter(request, prefix + "ib_cssm_voy_no", ""));
        setObCssmVoyNo(JSPUtil.getParameter(request, prefix + "ob_cssm_voy_no", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setFmDt(JSPUtil.getParameter(request, prefix + "fm_dt", ""));
        setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
        setCvCbm1(JSPUtil.getParameter(request, prefix + "cv_cbm1", ""));
        setCvCbm2(JSPUtil.getParameter(request, prefix + "cv_cbm2", ""));
        setChkVirtualPort(JSPUtil.getParameter(request, prefix + "chk_virtual_port", ""));
        setTurnPortIndCd(JSPUtil.getParameter(request, prefix + "turn_port_ind_cd", ""));
        setSkdDirCdOrd(JSPUtil.getParameter(request, prefix + "skd_dir_cd_ord", ""));
        setClptSeq(JSPUtil.getParameter(request, prefix + "clpt_seq", ""));
        setTurnPortFlg(JSPUtil.getParameter(request, prefix + "turn_port_flg", ""));
        setTurnSkdVoyNo(JSPUtil.getParameter(request, prefix + "turn_skd_voy_no", ""));
        setCssmVoyInitCreFlg(JSPUtil.getParameter(request, prefix + "cssm_voy_init_cre_flg", ""));
        setRealTurnPortIndCd(JSPUtil.getParameter(request, prefix + "real_turn_port_ind_cd", ""));
        setClptIndSeq(JSPUtil.getParameter(request, prefix + "clpt_ind_seq", ""));
        setVtAddCallFlg(JSPUtil.getParameter(request, prefix + "vt_add_call_flg", ""));
        setVoyage(JSPUtil.getParameter(request, prefix + "voyage", ""));
        setChkVoyage(JSPUtil.getParameter(request, prefix + "chk_voyage", ""));
        setVoyAllSetFlg(JSPUtil.getParameter(request, prefix + "voy_all_set_flg", ""));
        setTurnSkdDirCd(JSPUtil.getParameter(request, prefix + "turn_skd_dir_cd", ""));
        setRealClptSeq(JSPUtil.getParameter(request, prefix + "real_clpt_seq", ""));
        setFirstTurnPortClptSeq(JSPUtil.getParameter(request, prefix + "first_turn_port_clpt_seq", ""));
        setVirPortClptSeq(JSPUtil.getParameter(request, prefix + "vir_port_clpt_seq", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ConsortiumVoyageVO[]
	 */
    public ConsortiumVoyageVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ConsortiumVoyageVO[]
	 */
    public ConsortiumVoyageVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        ConsortiumVoyageVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] vslSlanCd = (JSPUtil.getParameter(request, prefix + "vsl_slan_cd", length));
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
            String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
            String[] vpsPortCd = (JSPUtil.getParameter(request, prefix + "vps_port_cd", length));
            String[] pfEtaDt = (JSPUtil.getParameter(request, prefix + "pf_eta_dt", length));
            String[] pfEtbDt = (JSPUtil.getParameter(request, prefix + "pf_etb_dt", length));
            String[] pfEtdDt = (JSPUtil.getParameter(request, prefix + "pf_etd_dt", length));
            String[] initEtaDt = (JSPUtil.getParameter(request, prefix + "init_eta_dt", length));
            String[] initEtbDt = (JSPUtil.getParameter(request, prefix + "init_etb_dt", length));
            String[] initEtdDt = (JSPUtil.getParameter(request, prefix + "init_etd_dt", length));
            String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix + "vps_eta_dt", length));
            String[] vpsEtbDt = (JSPUtil.getParameter(request, prefix + "vps_etb_dt", length));
            String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix + "vps_etd_dt", length));
            String[] ibCssmVoyNo = (JSPUtil.getParameter(request, prefix + "ib_cssm_voy_no", length));
            String[] obCssmVoyNo = (JSPUtil.getParameter(request, prefix + "ob_cssm_voy_no", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] fmDt = (JSPUtil.getParameter(request, prefix + "fm_dt", length));
            String[] toDt = (JSPUtil.getParameter(request, prefix + "to_dt", length));
            String[] cvCbm1 = (JSPUtil.getParameter(request, prefix + "cv_cbm1", length));
            String[] cvCbm2 = (JSPUtil.getParameter(request, prefix + "cv_cbm2", length));
            String[] chkVirtualPort = (JSPUtil.getParameter(request, prefix + "chk_virtual_port", length));
            String[] turnPortIndCd = (JSPUtil.getParameter(request, prefix + "turn_port_ind_cd", length));
            String[] skdDirCdOrd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd_ord", length));
            String[] clptSeq = (JSPUtil.getParameter(request, prefix + "clpt_seq", length));
            String[] turnPortFlg = (JSPUtil.getParameter(request, prefix + "turn_port_flg", length));
            String[] turnSkdVoyNo = (JSPUtil.getParameter(request, prefix + "turn_skd_voy_no", length));
            String[] cssmVoyInitCreFlg = (JSPUtil.getParameter(request, prefix + "cssm_voy_init_cre_flg", length));
            String[] realTurnPortIndCd = (JSPUtil.getParameter(request, prefix + "real_turn_port_ind_cd", length));
            String[] clptIndSeq = (JSPUtil.getParameter(request, prefix + "clpt_ind_seq", length));
            String[] vtAddCallFlg = (JSPUtil.getParameter(request, prefix + "vt_add_call_flg", length));
            String[] voyage = (JSPUtil.getParameter(request, prefix + "voyage", length));
            String[] chkVoyage = (JSPUtil.getParameter(request, prefix + "chk_voyage", length));
            String[] voyAllSetFlg = (JSPUtil.getParameter(request, prefix + "voy_all_set_flg", length));
            String[] turnSkdDirCd = (JSPUtil.getParameter(request, prefix + "turn_skd_dir_cd", length));
            String[] realClptSeq = (JSPUtil.getParameter(request, prefix + "real_clpt_seq", length));
            String[] firstTurnPortClptSeq = (JSPUtil.getParameter(request, prefix + "first_turn_port_clpt_seq", length));
            String[] virPortClptSeq = (JSPUtil.getParameter(request, prefix + "vir_port_clpt_seq", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new ConsortiumVoyageVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (vslSlanCd[i] != null)
                    model.setVslSlanCd(vslSlanCd[i]);
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (skdVoyNo[i] != null)
                    model.setSkdVoyNo(skdVoyNo[i]);
                if (skdDirCd[i] != null)
                    model.setSkdDirCd(skdDirCd[i]);
                if (vpsPortCd[i] != null)
                    model.setVpsPortCd(vpsPortCd[i]);
                if (pfEtaDt[i] != null)
                    model.setPfEtaDt(pfEtaDt[i]);
                if (pfEtbDt[i] != null)
                    model.setPfEtbDt(pfEtbDt[i]);
                if (pfEtdDt[i] != null)
                    model.setPfEtdDt(pfEtdDt[i]);
                if (initEtaDt[i] != null)
                    model.setInitEtaDt(initEtaDt[i]);
                if (initEtbDt[i] != null)
                    model.setInitEtbDt(initEtbDt[i]);
                if (initEtdDt[i] != null)
                    model.setInitEtdDt(initEtdDt[i]);
                if (vpsEtaDt[i] != null)
                    model.setVpsEtaDt(vpsEtaDt[i]);
                if (vpsEtbDt[i] != null)
                    model.setVpsEtbDt(vpsEtbDt[i]);
                if (vpsEtdDt[i] != null)
                    model.setVpsEtdDt(vpsEtdDt[i]);
                if (ibCssmVoyNo[i] != null)
                    model.setIbCssmVoyNo(ibCssmVoyNo[i]);
                if (obCssmVoyNo[i] != null)
                    model.setObCssmVoyNo(obCssmVoyNo[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (fmDt[i] != null)
                    model.setFmDt(fmDt[i]);
                if (toDt[i] != null)
                    model.setToDt(toDt[i]);
                if (cvCbm1[i] != null)
                    model.setCvCbm1(cvCbm1[i]);
                if (cvCbm2[i] != null)
                    model.setCvCbm2(cvCbm2[i]);
                if (chkVirtualPort[i] != null)
                    model.setChkVirtualPort(chkVirtualPort[i]);
                if (turnPortIndCd[i] != null)
                    model.setTurnPortIndCd(turnPortIndCd[i]);
                if (skdDirCdOrd[i] != null)
                    model.setSkdDirCdOrd(skdDirCdOrd[i]);
                if (clptSeq[i] != null)
                    model.setClptSeq(clptSeq[i]);
                if (turnPortFlg[i] != null)
                    model.setTurnPortFlg(turnPortFlg[i]);
                if (turnSkdVoyNo[i] != null)
                    model.setTurnSkdVoyNo(turnSkdVoyNo[i]);
                if (cssmVoyInitCreFlg[i] != null)
                    model.setCssmVoyInitCreFlg(cssmVoyInitCreFlg[i]);
                if (realTurnPortIndCd[i] != null)
                    model.setRealTurnPortIndCd(realTurnPortIndCd[i]);
                if (clptIndSeq[i] != null)
                    model.setClptIndSeq(clptIndSeq[i]);
                if (vtAddCallFlg[i] != null)
                    model.setVtAddCallFlg(vtAddCallFlg[i]);
                if (voyage[i] != null)
                    model.setVoyage(voyage[i]);
                if (chkVoyage[i] != null)
                    model.setChkVoyage(chkVoyage[i]);
                if (voyAllSetFlg[i] != null)
                    model.setVoyAllSetFlg(voyAllSetFlg[i]);
                if (turnSkdDirCd[i] != null)
                    model.setTurnSkdDirCd(turnSkdDirCd[i]);
                if (realClptSeq[i] != null)
                    model.setRealClptSeq(realClptSeq[i]);
                if (firstTurnPortClptSeq[i] != null)
                    model.setFirstTurnPortClptSeq(firstTurnPortClptSeq[i]);
                if (virPortClptSeq[i] != null) 
		    		model.setVirPortClptSeq(virPortClptSeq[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getConsortiumVoyageVOs();
    }

    /**
	 *  VO 배열을 반환
	 * @return ConsortiumVoyageVO[]
	 */
    public ConsortiumVoyageVO[] getConsortiumVoyageVOs() {
        ConsortiumVoyageVO[] vos = (ConsortiumVoyageVO[]) models.toArray(new ConsortiumVoyageVO[models.size()]);
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
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslSlanCd = this.vslSlanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsPortCd = this.vpsPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pfEtaDt = this.pfEtaDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pfEtbDt = this.pfEtbDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pfEtdDt = this.pfEtdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.initEtaDt = this.initEtaDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.initEtbDt = this.initEtbDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.initEtdDt = this.initEtdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsEtaDt = this.vpsEtaDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsEtbDt = this.vpsEtbDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsEtdDt = this.vpsEtdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibCssmVoyNo = this.ibCssmVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.obCssmVoyNo = this.obCssmVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fmDt = this.fmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.toDt = this.toDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cvCbm1 = this.cvCbm1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cvCbm2 = this.cvCbm2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chkVirtualPort = this.chkVirtualPort.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.turnPortIndCd = this.turnPortIndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCdOrd = this.skdDirCdOrd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.clptSeq = this.clptSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.turnPortFlg = this.turnPortFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.turnSkdVoyNo = this.turnSkdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cssmVoyInitCreFlg = this.cssmVoyInitCreFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.realTurnPortIndCd = this.realTurnPortIndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.clptIndSeq = this.clptIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vtAddCallFlg = this.vtAddCallFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.voyage = this.voyage.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chkVoyage = this.chkVoyage.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.voyAllSetFlg = this.voyAllSetFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.turnSkdDirCd = this.turnSkdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.realClptSeq = this.realClptSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.firstTurnPortClptSeq = this.firstTurnPortClptSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.virPortClptSeq = this.virPortClptSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
