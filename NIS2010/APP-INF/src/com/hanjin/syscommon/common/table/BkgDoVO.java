/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : BkgDoVO.java
 *@FileTitle : BkgDoVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.10.05
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.10.05  
 * 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.common.table;

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
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class BkgDoVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<BkgDoVO> models = new ArrayList<BkgDoVO>();

    /*	Column Info	*/
    private String idaDoVtyDt = null;

    /*	Column Info	*/
    private String creDt = null;

    /*	Column Info	*/
    private String pagerows = null;

    /*	Column Info	*/
    private String ibflag = null;

    /*	Column Info	*/
    private String idaDoDmdtPayTpCd = null;

    /*	Column Info	*/
    private String vnCgoDeCd = null;

    /*	Column Info	*/
    private String rcvrPhnNo = null;

    /*	Column Info	*/
    private String hblNo = null;

    /*	Column Info	*/
    private String doPrnRmk = null;

    /*	Column Info	*/
    private String rcvrBizNo = null;

    /*	Column Info	*/
    private String updUsrId = null;

    /*	Column Info	*/
    private String updDt = null;

    /*	Column Info	*/
    private String custPrnFlg = null;

    /*	Column Info	*/
    private String doNoSplit = null;

    /*	Column Info	*/
    private String rcvrFaxNo = null;

    /*	Column Info	*/
    private String selfTrnsFlg = null;

    /*	Column Info	*/
    private String rcvrCoNm = null;

    /*	Column Info	*/
    private String rlseSeq = null;

    /*	Column Info	*/
    private String picNm = null;

    /*	Column Info	*/
    private String rcvrCneeNm = null;

    /*	Column Info	*/
    private String jpDoSndStsCd = null;

    /*	Column Info	*/
    private String doNo = null;

    /*	Column Info	*/
    private String rcvrEml = null;

    /*	Column Info	*/
    private String bkgNo = null;

    /*	Column Info	*/
    private String creUsrId = null;

    /*	Column Info	*/
    private String cgorRmk = null;

    /*	Column Info	*/
    private String jpDoId = null;

    /*	Column Info	*/
    private String cfsEml = null;

    /*	Column Info	*/
    private String mtyYdEml = null;

    /* Column Info */
    private String lginCntCd = null;

    /* Column Info */
    private String doPinNo = null;

    /* hashColumnInpo */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /* hashFildInpo	*/
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    /**	Constructor	*/
    public BkgDoVO() {
    }

    public BkgDoVO(String idaDoVtyDt, String creDt, String pagerows, String ibflag, String idaDoDmdtPayTpCd, String vnCgoDeCd, String rcvrPhnNo, String hblNo, String doPrnRmk, String rcvrBizNo, String updUsrId, String updDt, String custPrnFlg, String doNoSplit, String rcvrFaxNo, String selfTrnsFlg, String rcvrCoNm, String rlseSeq, String picNm, String rcvrCneeNm, String jpDoSndStsCd, String doNo, String rcvrEml, String bkgNo, String creUsrId, String cgorRmk, String jpDoId, String cfsEml, String mtyYdEml, String lginCntCd, String doPinNo) {
        this.idaDoVtyDt = idaDoVtyDt;
        this.creDt = creDt;
        this.pagerows = pagerows;
        this.ibflag = ibflag;
        this.idaDoDmdtPayTpCd = idaDoDmdtPayTpCd;
        this.vnCgoDeCd = vnCgoDeCd;
        this.rcvrPhnNo = rcvrPhnNo;
        this.hblNo = hblNo;
        this.doPrnRmk = doPrnRmk;
        this.rcvrBizNo = rcvrBizNo;
        this.updUsrId = updUsrId;
        this.updDt = updDt;
        this.custPrnFlg = custPrnFlg;
        this.doNoSplit = doNoSplit;
        this.rcvrFaxNo = rcvrFaxNo;
        this.selfTrnsFlg = selfTrnsFlg;
        this.rcvrCoNm = rcvrCoNm;
        this.rlseSeq = rlseSeq;
        this.picNm = picNm;
        this.rcvrCneeNm = rcvrCneeNm;
        this.jpDoSndStsCd = jpDoSndStsCd;
        this.doNo = doNo;
        this.rcvrEml = rcvrEml;
        this.bkgNo = bkgNo;
        this.creUsrId = creUsrId;
        this.cgorRmk = cgorRmk;
        this.jpDoId = jpDoId;
        this.cfsEml = cfsEml;
        this.mtyYdEml = mtyYdEml;
        this.lginCntCd = lginCntCd;
        this.doPinNo = doPinNo;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ida_do_vty_dt", getIdaDoVtyDt());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("ida_do_dmdt_pay_tp_cd", getIdaDoDmdtPayTpCd());
        this.hashColumns.put("vn_cgo_de_cd", getVnCgoDeCd());
        this.hashColumns.put("rcvr_phn_no", getRcvrPhnNo());
        this.hashColumns.put("hbl_no", getHblNo());
        this.hashColumns.put("do_prn_rmk", getDoPrnRmk());
        this.hashColumns.put("rcvr_biz_no", getRcvrBizNo());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("cust_prn_flg", getCustPrnFlg());
        this.hashColumns.put("do_no_split", getDoNoSplit());
        this.hashColumns.put("rcvr_fax_no", getRcvrFaxNo());
        this.hashColumns.put("self_trns_flg", getSelfTrnsFlg());
        this.hashColumns.put("rcvr_co_nm", getRcvrCoNm());
        this.hashColumns.put("rlse_seq", getRlseSeq());
        this.hashColumns.put("pic_nm", getPicNm());
        this.hashColumns.put("rcvr_cnee_nm", getRcvrCneeNm());
        this.hashColumns.put("jp_do_snd_sts_cd", getJpDoSndStsCd());
        this.hashColumns.put("do_no", getDoNo());
        this.hashColumns.put("rcvr_eml", getRcvrEml());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("cgor_rmk", getCgorRmk());
        this.hashColumns.put("jp_do_id", getJpDoId());
        this.hashColumns.put("cfs_eml", getCfsEml());
        this.hashColumns.put("mty_yd_eml", getMtyYdEml());
        this.hashColumns.put("lgin_cnt_cd", getLginCntCd());
        this.hashColumns.put("do_pin_no", getDoPinNo());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ida_do_vty_dt", "idaDoVtyDt");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("ida_do_dmdt_pay_tp_cd", "idaDoDmdtPayTpCd");
        this.hashFields.put("vn_cgo_de_cd", "vnCgoDeCd");
        this.hashFields.put("rcvr_phn_no", "rcvrPhnNo");
        this.hashFields.put("hbl_no", "hblNo");
        this.hashFields.put("do_prn_rmk", "doPrnRmk");
        this.hashFields.put("rcvr_biz_no", "rcvrBizNo");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("cust_prn_flg", "custPrnFlg");
        this.hashFields.put("do_no_split", "doNoSplit");
        this.hashFields.put("rcvr_fax_no", "rcvrFaxNo");
        this.hashFields.put("self_trns_flg", "selfTrnsFlg");
        this.hashFields.put("rcvr_co_nm", "rcvrCoNm");
        this.hashFields.put("rlse_seq", "rlseSeq");
        this.hashFields.put("pic_nm", "picNm");
        this.hashFields.put("rcvr_cnee_nm", "rcvrCneeNm");
        this.hashFields.put("jp_do_snd_sts_cd", "jpDoSndStsCd");
        this.hashFields.put("do_no", "doNo");
        this.hashFields.put("rcvr_eml", "rcvrEml");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("cgor_rmk", "cgorRmk");
        this.hashFields.put("jp_do_id", "jpDoId");
        this.hashFields.put("cfs_eml", "cfsEml");
        this.hashFields.put("mty_yd_eml", "mtyYdEml");
        this.hashFields.put("lgin_cnt_cd", "lginCntCd");
        this.hashFields.put("do_pin_no", "doPinNo");
        return this.hashFields;
    }

    //	Getters	and	Setters
    /**
	* Column Info
	* @param  idaDoVtyDt
	*/
    public void setIdaDoVtyDt(String idaDoVtyDt) {
        this.idaDoVtyDt = idaDoVtyDt;
    }

    /**
	 * Column Info
	 * @return	idaDoVtyDt
	 */
    public String getIdaDoVtyDt() {
        return this.idaDoVtyDt;
    }

    /**
	* Column Info
	* @param  creDt
	*/
    public void setCreDt(String creDt) {
        this.creDt = creDt;
    }

    /**
	 * Column Info
	 * @return	creDt
	 */
    public String getCreDt() {
        return this.creDt;
    }

    /**
	* Column Info
	* @param  pagerows
	*/
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    /**
	 * Column Info
	 * @return	pagerows
	 */
    public String getPagerows() {
        return this.pagerows;
    }

    /**
	* Column Info
	* @param  ibflag
	*/
    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
    }

    /**
	 * Column Info
	 * @return	ibflag
	 */
    public String getIbflag() {
        return this.ibflag;
    }

    /**
	* Column Info
	* @param  idaDoDmdtPayTpCd
	*/
    public void setIdaDoDmdtPayTpCd(String idaDoDmdtPayTpCd) {
        this.idaDoDmdtPayTpCd = idaDoDmdtPayTpCd;
    }

    /**
	 * Column Info
	 * @return	idaDoDmdtPayTpCd
	 */
    public String getIdaDoDmdtPayTpCd() {
        return this.idaDoDmdtPayTpCd;
    }

    /**
	* Column Info
	* @param  vnCgoDeCd
	*/
    public void setVnCgoDeCd(String vnCgoDeCd) {
        this.vnCgoDeCd = vnCgoDeCd;
    }

    /**
	 * Column Info
	 * @return	vnCgoDeCd
	 */
    public String getVnCgoDeCd() {
        return this.vnCgoDeCd;
    }

    /**
	* Column Info
	* @param  rcvrPhnNo
	*/
    public void setRcvrPhnNo(String rcvrPhnNo) {
        this.rcvrPhnNo = rcvrPhnNo;
    }

    /**
	 * Column Info
	 * @return	rcvrPhnNo
	 */
    public String getRcvrPhnNo() {
        return this.rcvrPhnNo;
    }

    /**
	* Column Info
	* @param  hblNo
	*/
    public void setHblNo(String hblNo) {
        this.hblNo = hblNo;
    }

    /**
	 * Column Info
	 * @return	hblNo
	 */
    public String getHblNo() {
        return this.hblNo;
    }

    /**
	* Column Info
	* @param  doPrnRmk
	*/
    public void setDoPrnRmk(String doPrnRmk) {
        this.doPrnRmk = doPrnRmk;
    }

    /**
	 * Column Info
	 * @return	doPrnRmk
	 */
    public String getDoPrnRmk() {
        return this.doPrnRmk;
    }

    /**
	* Column Info
	* @param  rcvrBizNo
	*/
    public void setRcvrBizNo(String rcvrBizNo) {
        this.rcvrBizNo = rcvrBizNo;
    }

    /**
	 * Column Info
	 * @return	rcvrBizNo
	 */
    public String getRcvrBizNo() {
        return this.rcvrBizNo;
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
	 * @return	updUsrId
	 */
    public String getUpdUsrId() {
        return this.updUsrId;
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
	 * @return	updDt
	 */
    public String getUpdDt() {
        return this.updDt;
    }

    /**
	* Column Info
	* @param  custPrnFlg
	*/
    public void setCustPrnFlg(String custPrnFlg) {
        this.custPrnFlg = custPrnFlg;
    }

    /**
	 * Column Info
	 * @return	custPrnFlg
	 */
    public String getCustPrnFlg() {
        return this.custPrnFlg;
    }

    /**
	* Column Info
	* @param  doNoSplit
	*/
    public void setDoNoSplit(String doNoSplit) {
        this.doNoSplit = doNoSplit;
    }

    /**
	 * Column Info
	 * @return	doNoSplit
	 */
    public String getDoNoSplit() {
        return this.doNoSplit;
    }

    /**
	* Column Info
	* @param  rcvrFaxNo
	*/
    public void setRcvrFaxNo(String rcvrFaxNo) {
        this.rcvrFaxNo = rcvrFaxNo;
    }

    /**
	 * Column Info
	 * @return	rcvrFaxNo
	 */
    public String getRcvrFaxNo() {
        return this.rcvrFaxNo;
    }

    /**
	* Column Info
	* @param  selfTrnsFlg
	*/
    public void setSelfTrnsFlg(String selfTrnsFlg) {
        this.selfTrnsFlg = selfTrnsFlg;
    }

    /**
	 * Column Info
	 * @return	selfTrnsFlg
	 */
    public String getSelfTrnsFlg() {
        return this.selfTrnsFlg;
    }

    /**
	* Column Info
	* @param  rcvrCoNm
	*/
    public void setRcvrCoNm(String rcvrCoNm) {
        this.rcvrCoNm = rcvrCoNm;
    }

    /**
	 * Column Info
	 * @return	rcvrCoNm
	 */
    public String getRcvrCoNm() {
        return this.rcvrCoNm;
    }

    /**
	* Column Info
	* @param  rlseSeq
	*/
    public void setRlseSeq(String rlseSeq) {
        this.rlseSeq = rlseSeq;
    }

    /**
	 * Column Info
	 * @return	rlseSeq
	 */
    public String getRlseSeq() {
        return this.rlseSeq;
    }

    /**
	* Column Info
	* @param  picNm
	*/
    public void setPicNm(String picNm) {
        this.picNm = picNm;
    }

    /**
	 * Column Info
	 * @return	picNm
	 */
    public String getPicNm() {
        return this.picNm;
    }

    /**
	* Column Info
	* @param  rcvrCneeNm
	*/
    public void setRcvrCneeNm(String rcvrCneeNm) {
        this.rcvrCneeNm = rcvrCneeNm;
    }

    /**
	 * Column Info
	 * @return	rcvrCneeNm
	 */
    public String getRcvrCneeNm() {
        return this.rcvrCneeNm;
    }

    /**
	* Column Info
	* @param  jpDoSndStsCd
	*/
    public void setJpDoSndStsCd(String jpDoSndStsCd) {
        this.jpDoSndStsCd = jpDoSndStsCd;
    }

    /**
	 * Column Info
	 * @return	jpDoSndStsCd
	 */
    public String getJpDoSndStsCd() {
        return this.jpDoSndStsCd;
    }

    /**
	* Column Info
	* @param  doNo
	*/
    public void setDoNo(String doNo) {
        this.doNo = doNo;
    }

    /**
	 * Column Info
	 * @return	doNo
	 */
    public String getDoNo() {
        return this.doNo;
    }

    /**
	* Column Info
	* @param  rcvrEml
	*/
    public void setRcvrEml(String rcvrEml) {
        this.rcvrEml = rcvrEml;
    }

    /**
	 * Column Info
	 * @return	rcvrEml
	 */
    public String getRcvrEml() {
        return this.rcvrEml;
    }

    /**
	* Column Info
	* @param  bkgNo
	*/
    public void setBkgNo(String bkgNo) {
        this.bkgNo = bkgNo;
    }

    /**
	 * Column Info
	 * @return	bkgNo
	 */
    public String getBkgNo() {
        return this.bkgNo;
    }

    /**
	* Column Info
	* @param  creUsrId
	*/
    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
    }

    /**
	 * Column Info
	 * @return	creUsrId
	 */
    public String getCreUsrId() {
        return this.creUsrId;
    }

    /**
	* Column Info
	* @param  cgorRmk
	*/
    public void setCgorRmk(String cgorRmk) {
        this.cgorRmk = cgorRmk;
    }

    /**
	 * Column Info
	 * @return	cgorRmk
	 */
    public String getCgorRmk() {
        return this.cgorRmk;
    }

    /**
	* Column Info
	* @param  jpDoId
	*/
    public void setJpDoId(String jpDoId) {
        this.jpDoId = jpDoId;
    }

    /**
	 * Column Info
	 * @return	jpDoId
	 */
    public String getJpDoId() {
        return this.jpDoId;
    }

    /**
	* Column Info
	* @param  cfsEml
	*/
    public void setCfsEml(String cfsEml) {
        this.cfsEml = cfsEml;
    }

    /**
	 * Column Info
	 * @return	cfsEml
	 */
    public String getCfsEml() {
        return this.cfsEml;
    }

    /**
	* Column Info
	* @param  mtyYdEml
	*/
    public void setMtyYdEml(String mtyYdEml) {
        this.mtyYdEml = mtyYdEml;
    }

    /**
	 * Column Info
	 * @return	mtyYdEml
	 */
    public String getMtyYdEml() {
        return this.mtyYdEml;
    }

    public void setLginCntCd(String lginCntCd) {
        this.lginCntCd = lginCntCd;
    }

    public String getLginCntCd() {
        return this.lginCntCd;
    }

    public void setDoPinNo(String doPinNo) {
        this.doPinNo = doPinNo;
    }

    public String getDoPinNo() {
        return this.doPinNo;
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
        setIdaDoVtyDt(JSPUtil.getParameter(request, prefix + "ida_do_vty_dt", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setIdaDoDmdtPayTpCd(JSPUtil.getParameter(request, prefix + "ida_do_dmdt_pay_tp_cd", ""));
        setVnCgoDeCd(JSPUtil.getParameter(request, prefix + "vn_cgo_de_cd", ""));
        setRcvrPhnNo(JSPUtil.getParameter(request, prefix + "rcvr_phn_no", ""));
        setHblNo(JSPUtil.getParameter(request, prefix + "hbl_no", ""));
        setDoPrnRmk(JSPUtil.getParameter(request, prefix + "do_prn_rmk", ""));
        setRcvrBizNo(JSPUtil.getParameter(request, prefix + "rcvr_biz_no", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setCustPrnFlg(JSPUtil.getParameter(request, prefix + "cust_prn_flg", ""));
        setDoNoSplit(JSPUtil.getParameter(request, prefix + "do_no_split", ""));
        setRcvrFaxNo(JSPUtil.getParameter(request, prefix + "rcvr_fax_no", ""));
        setSelfTrnsFlg(JSPUtil.getParameter(request, prefix + "self_trns_flg", ""));
        setRcvrCoNm(JSPUtil.getParameter(request, prefix + "rcvr_co_nm", ""));
        setRlseSeq(JSPUtil.getParameter(request, prefix + "rlse_seq", ""));
        setPicNm(JSPUtil.getParameter(request, prefix + "pic_nm", ""));
        setRcvrCneeNm(JSPUtil.getParameter(request, prefix + "rcvr_cnee_nm", ""));
        setJpDoSndStsCd(JSPUtil.getParameter(request, prefix + "jp_do_snd_sts_cd", ""));
        setDoNo(JSPUtil.getParameter(request, prefix + "do_no", ""));
        setRcvrEml(JSPUtil.getParameter(request, prefix + "rcvr_eml", ""));
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setCgorRmk(JSPUtil.getParameter(request, prefix + "cgor_rmk", ""));
        setJpDoId(JSPUtil.getParameter(request, prefix + "jp_do_id", ""));
        setCfsEml(JSPUtil.getParameter(request, prefix + "cfs_eml", ""));
        setMtyYdEml(JSPUtil.getParameter(request, prefix + "mty_yd_eml", ""));
        setLginCntCd(JSPUtil.getParameter(request, prefix + "lgin_cnt_cd", ""));
        setDoPinNo(JSPUtil.getParameter(request, prefix + "do_pin_no", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgDoVO[]
	 */
    public BkgDoVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return BkgDoVO[]
	 */
    public BkgDoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        BkgDoVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] idaDoVtyDt = (JSPUtil.getParameter(request, prefix + "ida_do_vty_dt".trim(), length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt".trim(), length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows".trim(), length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag".trim(), length));
            String[] idaDoDmdtPayTpCd = (JSPUtil.getParameter(request, prefix + "ida_do_dmdt_pay_tp_cd".trim(), length));
            String[] vnCgoDeCd = (JSPUtil.getParameter(request, prefix + "vn_cgo_de_cd".trim(), length));
            String[] rcvrPhnNo = (JSPUtil.getParameter(request, prefix + "rcvr_phn_no".trim(), length));
            String[] hblNo = (JSPUtil.getParameter(request, prefix + "hbl_no".trim(), length));
            String[] doPrnRmk = (JSPUtil.getParameter(request, prefix + "do_prn_rmk".trim(), length));
            String[] rcvrBizNo = (JSPUtil.getParameter(request, prefix + "rcvr_biz_no".trim(), length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id".trim(), length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt".trim(), length));
            String[] custPrnFlg = (JSPUtil.getParameter(request, prefix + "cust_prn_flg".trim(), length));
            String[] doNoSplit = (JSPUtil.getParameter(request, prefix + "do_no_split".trim(), length));
            String[] rcvrFaxNo = (JSPUtil.getParameter(request, prefix + "rcvr_fax_no".trim(), length));
            String[] selfTrnsFlg = (JSPUtil.getParameter(request, prefix + "self_trns_flg".trim(), length));
            String[] rcvrCoNm = (JSPUtil.getParameter(request, prefix + "rcvr_co_nm".trim(), length));
            String[] rlseSeq = (JSPUtil.getParameter(request, prefix + "rlse_seq".trim(), length));
            String[] picNm = (JSPUtil.getParameter(request, prefix + "pic_nm".trim(), length));
            String[] rcvrCneeNm = (JSPUtil.getParameter(request, prefix + "rcvr_cnee_nm".trim(), length));
            String[] jpDoSndStsCd = (JSPUtil.getParameter(request, prefix + "jp_do_snd_sts_cd".trim(), length));
            String[] doNo = (JSPUtil.getParameter(request, prefix + "do_no".trim(), length));
            String[] rcvrEml = (JSPUtil.getParameter(request, prefix + "rcvr_eml".trim(), length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no".trim(), length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id".trim(), length));
            String[] cgorRmk = (JSPUtil.getParameter(request, prefix + "cgor_rmk".trim(), length));
            String[] jpDoId = (JSPUtil.getParameter(request, prefix + "jp_do_id".trim(), length));
            String[] cfsEml = (JSPUtil.getParameter(request, prefix + "cfs_eml".trim(), length));
            String[] mtyYdEml = (JSPUtil.getParameter(request, prefix + "mty_yd_eml".trim(), length));
            String[] lginCntCd = (JSPUtil.getParameter(request, prefix + "lgin_cnt_cd", length));
            String[] doPinNo = (JSPUtil.getParameter(request, prefix + "do_pin_no", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new BkgDoVO();
                if (idaDoVtyDt[i] != null)
                    model.setIdaDoVtyDt(idaDoVtyDt[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (idaDoDmdtPayTpCd[i] != null)
                    model.setIdaDoDmdtPayTpCd(idaDoDmdtPayTpCd[i]);
                if (vnCgoDeCd[i] != null)
                    model.setVnCgoDeCd(vnCgoDeCd[i]);
                if (rcvrPhnNo[i] != null)
                    model.setRcvrPhnNo(rcvrPhnNo[i]);
                if (hblNo[i] != null)
                    model.setHblNo(hblNo[i]);
                if (doPrnRmk[i] != null)
                    model.setDoPrnRmk(doPrnRmk[i]);
                if (rcvrBizNo[i] != null)
                    model.setRcvrBizNo(rcvrBizNo[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (custPrnFlg[i] != null)
                    model.setCustPrnFlg(custPrnFlg[i]);
                if (doNoSplit[i] != null)
                    model.setDoNoSplit(doNoSplit[i]);
                if (rcvrFaxNo[i] != null)
                    model.setRcvrFaxNo(rcvrFaxNo[i]);
                if (selfTrnsFlg[i] != null)
                    model.setSelfTrnsFlg(selfTrnsFlg[i]);
                if (rcvrCoNm[i] != null)
                    model.setRcvrCoNm(rcvrCoNm[i]);
                if (rlseSeq[i] != null)
                    model.setRlseSeq(rlseSeq[i]);
                if (picNm[i] != null)
                    model.setPicNm(picNm[i]);
                if (rcvrCneeNm[i] != null)
                    model.setRcvrCneeNm(rcvrCneeNm[i]);
                if (jpDoSndStsCd[i] != null)
                    model.setJpDoSndStsCd(jpDoSndStsCd[i]);
                if (doNo[i] != null)
                    model.setDoNo(doNo[i]);
                if (rcvrEml[i] != null)
                    model.setRcvrEml(rcvrEml[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (cgorRmk[i] != null)
                    model.setCgorRmk(cgorRmk[i]);
                if (jpDoId[i] != null)
                    model.setJpDoId(jpDoId[i]);
                if (cfsEml[i] != null)
                    model.setCfsEml(cfsEml[i]);
                if (mtyYdEml[i] != null)
                    model.setMtyYdEml(mtyYdEml[i]);
                if (lginCntCd[i] != null)
                    model.setLginCntCd(lginCntCd[i]);
                if (doPinNo[i] != null) 
		    		model.setDoPinNo(doPinNo[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getBkgDoVOs();
    }

    /**
	 *  VO 배열을 반환
	 * @return BkgDoVO[]
	 */
    public BkgDoVO[] getBkgDoVOs() {
        BkgDoVO[] vos = (BkgDoVO[]) models.toArray(new BkgDoVO[models.size()]);
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
        this.idaDoVtyDt = this.idaDoVtyDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaDoDmdtPayTpCd = this.idaDoDmdtPayTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vnCgoDeCd = this.vnCgoDeCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcvrPhnNo = this.rcvrPhnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hblNo = this.hblNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.doPrnRmk = this.doPrnRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcvrBizNo = this.rcvrBizNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custPrnFlg = this.custPrnFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.doNoSplit = this.doNoSplit.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcvrFaxNo = this.rcvrFaxNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.selfTrnsFlg = this.selfTrnsFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcvrCoNm = this.rcvrCoNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rlseSeq = this.rlseSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.picNm = this.picNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcvrCneeNm = this.rcvrCneeNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.jpDoSndStsCd = this.jpDoSndStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.doNo = this.doNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcvrEml = this.rcvrEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cgorRmk = this.cgorRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.jpDoId = this.jpDoId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cfsEml = this.cfsEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mtyYdEml = this.mtyYdEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lginCntCd = this.lginCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.doPinNo = this.doPinNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
