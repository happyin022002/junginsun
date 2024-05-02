/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ExternalRqstListInputVO.java
 *@FileTitle : ExternalRqstListInputVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.06.09
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.06.09  
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

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
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class ExternalRqstListInputVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<ExternalRqstListInputVO> models = new ArrayList<ExternalRqstListInputVO>();

    /*	Column Info	*/
    private String bkgCustTpCd = null;

    /*	Column Info	*/
    private String bkgNo = null;

    /*	Column Info	*/
    private String bkgNoSplit = null;

    /*	Column Info	*/
    private String bkgUpldStsCd = null;

    /*	Column Info	*/
    private String cnCnt = null;

    /*	Column Info	*/
    private String cnNm = null;

    /*	Column Info	*/
    private String cnSeq = null;

    /*	Column Info	*/
    private String cntcEml = null;

    /*	Column Info	*/
    private String custCntCd = null;

    /*	Column Info	*/
    private String custNm = null;

    /*	Column Info	*/
    private String custSeq = null;

    /*	Column Info	*/
    private String delCd = null;

    /*	Column Info	*/
    private String delivery = null;

    /*	Column Info	*/
    private String docTpCd = null;

    /*	Column Info	*/
    private String excelFlg = null;

    /*	Column Info	*/
    private String ffCnt = null;

    /*	Column Info	*/
    private String ffNm = null;

    /*	Column Info	*/
    private String ffSeq = null;

    /*	Column Info	*/
    private String hndlOfcCd = null;

    /*	Column Info	*/
    private String ibflag = null;

    /*	Column Info	*/
    private String ofcCd = null;

    /*	Column Info	*/
    private String origin = null;

    /*	Column Info	*/
    private String pageNo = null;

    /*	Column Info	*/
    private String pagerows = null;

    /*	Column Info	*/
    private String podCd = null;

    /*	Column Info	*/
    private String polCd = null;

    /*	Column Info	*/
    private String poNo = null;

    /*	Column Info	*/
    private String porCd = null;

    /*	Column Info	*/
    private String rqstFromDt = null;

    /*	Column Info	*/
    private String rqstToDt = null;

    /*	Column Info	*/
    private String setQryWhere = null;

    /*	Column Info	*/
    private String setSlctFlg = null;

    /*	Column Info	*/
    private String shCnt = null;

    /*	Column Info	*/
    private String shNm = null;

    /*	Column Info	*/
    private String shSeq = null;

    /*	Column Info	*/
    private String xterBkgRqstStsCd = null;

    /*	Column Info	*/
    private String xterRqstNo = null;

    /*	Column Info	*/
    private String xterRqstSeq = null;

    /*	Column Info	*/
    private String xterRqstViaCd = null;

    /*	Column Info	*/
    private String xterSndrId = null;

    /*	Column Info	*/
    private String chnAgnCd = null;

    /*	Column Info	*/
    private String vvd = null;

    /*	Column Info	*/
    private String lane = null;

    /*	Column Info	*/
    private String splitBkgYn = null;

    /*	Column Info	*/
    private String blFntOfcYn = null;

    /*	Column Info	*/
    private String sysUpldFlg = null;

    /*	Column Info	*/
    private String siAudFlg = null;

    /*	Column Info	*/
    private String vgmFlg = null;

    /* Column Info */
    private String nonRtStsCd = null;

    /* Column Info */
    private String inttraRtv = null;

    /* hashColumnInpo */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /* hashFildInpo	*/
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    /**	Constructor	*/
    public ExternalRqstListInputVO() {
    }

    public ExternalRqstListInputVO(String bkgCustTpCd, String bkgNo, String bkgNoSplit, String bkgUpldStsCd, String cnCnt, String cnNm, String cnSeq, String cntcEml, String custCntCd, String custNm, String custSeq, String delCd, String delivery, String docTpCd, String excelFlg, String ffCnt, String ffNm, String ffSeq, String hndlOfcCd, String ibflag, String ofcCd, String origin, String pageNo, String pagerows, String podCd, String polCd, String poNo, String porCd, String rqstFromDt, String rqstToDt, String setQryWhere, String setSlctFlg, String shCnt, String shNm, String shSeq, String xterBkgRqstStsCd, String xterRqstNo, String xterRqstSeq, String xterRqstViaCd, String xterSndrId, String chnAgnCd, String vvd, String lane, String splitBkgYn, String blFntOfcYn, String sysUpldFlg, String siAudFlg, String vgmFlg, String nonRtStsCd, String inttraRtv) {
        this.bkgCustTpCd = bkgCustTpCd;
        this.bkgNo = bkgNo;
        this.bkgNoSplit = bkgNoSplit;
        this.bkgUpldStsCd = bkgUpldStsCd;
        this.cnCnt = cnCnt;
        this.cnNm = cnNm;
        this.cnSeq = cnSeq;
        this.cntcEml = cntcEml;
        this.custCntCd = custCntCd;
        this.custNm = custNm;
        this.custSeq = custSeq;
        this.delCd = delCd;
        this.delivery = delivery;
        this.docTpCd = docTpCd;
        this.excelFlg = excelFlg;
        this.ffCnt = ffCnt;
        this.ffNm = ffNm;
        this.ffSeq = ffSeq;
        this.hndlOfcCd = hndlOfcCd;
        this.ibflag = ibflag;
        this.ofcCd = ofcCd;
        this.origin = origin;
        this.pageNo = pageNo;
        this.pagerows = pagerows;
        this.podCd = podCd;
        this.polCd = polCd;
        this.poNo = poNo;
        this.porCd = porCd;
        this.rqstFromDt = rqstFromDt;
        this.rqstToDt = rqstToDt;
        this.setQryWhere = setQryWhere;
        this.setSlctFlg = setSlctFlg;
        this.shCnt = shCnt;
        this.shNm = shNm;
        this.shSeq = shSeq;
        this.xterBkgRqstStsCd = xterBkgRqstStsCd;
        this.xterRqstNo = xterRqstNo;
        this.xterRqstSeq = xterRqstSeq;
        this.xterRqstViaCd = xterRqstViaCd;
        this.xterSndrId = xterSndrId;
        this.chnAgnCd = chnAgnCd;
        this.vvd = vvd;
        this.lane = lane;
        this.splitBkgYn = splitBkgYn;
        this.blFntOfcYn = blFntOfcYn;
        this.sysUpldFlg = sysUpldFlg;
        this.siAudFlg = siAudFlg;
        this.vgmFlg = vgmFlg;
        this.nonRtStsCd = nonRtStsCd;
        this.inttraRtv = inttraRtv;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("bkg_cust_tp_cd", getBkgCustTpCd());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("bkg_no_split", getBkgNoSplit());
        this.hashColumns.put("bkg_upld_sts_cd", getBkgUpldStsCd());
        this.hashColumns.put("cn_cnt", getCnCnt());
        this.hashColumns.put("cn_nm", getCnNm());
        this.hashColumns.put("cn_seq", getCnSeq());
        this.hashColumns.put("cntc_eml", getCntcEml());
        this.hashColumns.put("cust_cnt_cd", getCustCntCd());
        this.hashColumns.put("cust_nm", getCustNm());
        this.hashColumns.put("cust_seq", getCustSeq());
        this.hashColumns.put("del_cd", getDelCd());
        this.hashColumns.put("delivery", getDelivery());
        this.hashColumns.put("doc_tp_cd", getDocTpCd());
        this.hashColumns.put("excel_flg", getExcelFlg());
        this.hashColumns.put("ff_cnt", getFfCnt());
        this.hashColumns.put("ff_nm", getFfNm());
        this.hashColumns.put("ff_seq", getFfSeq());
        this.hashColumns.put("hndl_ofc_cd", getHndlOfcCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("ofc_cd", getOfcCd());
        this.hashColumns.put("origin", getOrigin());
        this.hashColumns.put("page_no", getPageNo());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("po_no", getPoNo());
        this.hashColumns.put("por_cd", getPorCd());
        this.hashColumns.put("rqst_from_dt", getRqstFromDt());
        this.hashColumns.put("rqst_to_dt", getRqstToDt());
        this.hashColumns.put("set_qry_where", getSetQryWhere());
        this.hashColumns.put("set_slct_flg", getSetSlctFlg());
        this.hashColumns.put("sh_cnt", getShCnt());
        this.hashColumns.put("sh_nm", getShNm());
        this.hashColumns.put("sh_seq", getShSeq());
        this.hashColumns.put("xter_bkg_rqst_sts_cd", getXterBkgRqstStsCd());
        this.hashColumns.put("xter_rqst_no", getXterRqstNo());
        this.hashColumns.put("xter_rqst_seq", getXterRqstSeq());
        this.hashColumns.put("xter_rqst_via_cd", getXterRqstViaCd());
        this.hashColumns.put("xter_sndr_id", getXterSndrId());
        this.hashColumns.put("chn_agn_cd", getChnAgnCd());
        this.hashColumns.put("vvd", getVvd());
        this.hashColumns.put("lane", getLane());
        this.hashColumns.put("split_bkg_yn", getSplitBkgYn());
        this.hashColumns.put("bl_fnt_ofc_yn", getBlFntOfcYn());
        this.hashColumns.put("sys_upld_flg", getSysUpldFlg());
        this.hashColumns.put("si_aud_flg", getSiAudFlg());
        this.hashColumns.put("vgm_flg", getVgmFlg());
        this.hashColumns.put("non_rt_sts_cd", getNonRtStsCd());
        this.hashColumns.put("inttra_rtv", getInttraRtv());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("bkg_cust_tp_cd", "bkgCustTpCd");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("bkg_no_split", "bkgNoSplit");
        this.hashFields.put("bkg_upld_sts_cd", "bkgUpldStsCd");
        this.hashFields.put("cn_cnt", "cnCnt");
        this.hashFields.put("cn_nm", "cnNm");
        this.hashFields.put("cn_seq", "cnSeq");
        this.hashFields.put("cntc_eml", "cntcEml");
        this.hashFields.put("cust_cnt_cd", "custCntCd");
        this.hashFields.put("cust_nm", "custNm");
        this.hashFields.put("cust_seq", "custSeq");
        this.hashFields.put("del_cd", "delCd");
        this.hashFields.put("delivery", "delivery");
        this.hashFields.put("doc_tp_cd", "docTpCd");
        this.hashFields.put("excel_flg", "excelFlg");
        this.hashFields.put("ff_cnt", "ffCnt");
        this.hashFields.put("ff_nm", "ffNm");
        this.hashFields.put("ff_seq", "ffSeq");
        this.hashFields.put("hndl_ofc_cd", "hndlOfcCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("ofc_cd", "ofcCd");
        this.hashFields.put("origin", "origin");
        this.hashFields.put("page_no", "pageNo");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("po_no", "poNo");
        this.hashFields.put("por_cd", "porCd");
        this.hashFields.put("rqst_from_dt", "rqstFromDt");
        this.hashFields.put("rqst_to_dt", "rqstToDt");
        this.hashFields.put("set_qry_where", "setQryWhere");
        this.hashFields.put("set_slct_flg", "setSlctFlg");
        this.hashFields.put("sh_cnt", "shCnt");
        this.hashFields.put("sh_nm", "shNm");
        this.hashFields.put("sh_seq", "shSeq");
        this.hashFields.put("xter_bkg_rqst_sts_cd", "xterBkgRqstStsCd");
        this.hashFields.put("xter_rqst_no", "xterRqstNo");
        this.hashFields.put("xter_rqst_seq", "xterRqstSeq");
        this.hashFields.put("xter_rqst_via_cd", "xterRqstViaCd");
        this.hashFields.put("xter_sndr_id", "xterSndrId");
        this.hashFields.put("chn_agn_cd", "chnAgnCd");
        this.hashFields.put("vvd", "vvd");
        this.hashFields.put("lane", "lane");
        this.hashFields.put("split_bkg_yn", "splitBkgYn");
        this.hashFields.put("bl_fnt_ofc_yn", "blFntOfcYn");
        this.hashFields.put("sys_upld_flg", "sysUpldFlg");
        this.hashFields.put("si_aud_flg", "siAudFlg");
        this.hashFields.put("vgm_flg", "vgmFlg");
        this.hashFields.put("non_rt_sts_cd", "nonRtStsCd");
        this.hashFields.put("inttra_rtv", "inttraRtv");
        return this.hashFields;
    }

    //	Getters	and	Setters
    /**
	* Column Info
	* @param  bkgCustTpCd
	*/
    public void setBkgCustTpCd(String bkgCustTpCd) {
        this.bkgCustTpCd = bkgCustTpCd;
    }

    /**
	 * Column Info
	 * @return	bkgCustTpCd
	 */
    public String getBkgCustTpCd() {
        return this.bkgCustTpCd;
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
	* @param  bkgNoSplit
	*/
    public void setBkgNoSplit(String bkgNoSplit) {
        this.bkgNoSplit = bkgNoSplit;
    }

    /**
	 * Column Info
	 * @return	bkgNoSplit
	 */
    public String getBkgNoSplit() {
        return this.bkgNoSplit;
    }

    /**
	* Column Info
	* @param  bkgUpldStsCd
	*/
    public void setBkgUpldStsCd(String bkgUpldStsCd) {
        this.bkgUpldStsCd = bkgUpldStsCd;
    }

    /**
	 * Column Info
	 * @return	bkgUpldStsCd
	 */
    public String getBkgUpldStsCd() {
        return this.bkgUpldStsCd;
    }

    /**
	* Column Info
	* @param  cnCnt
	*/
    public void setCnCnt(String cnCnt) {
        this.cnCnt = cnCnt;
    }

    /**
	 * Column Info
	 * @return	cnCnt
	 */
    public String getCnCnt() {
        return this.cnCnt;
    }

    /**
	* Column Info
	* @param  cnNm
	*/
    public void setCnNm(String cnNm) {
        this.cnNm = cnNm;
    }

    /**
	 * Column Info
	 * @return	cnNm
	 */
    public String getCnNm() {
        return this.cnNm;
    }

    /**
	* Column Info
	* @param  cnSeq
	*/
    public void setCnSeq(String cnSeq) {
        this.cnSeq = cnSeq;
    }

    /**
	 * Column Info
	 * @return	cnSeq
	 */
    public String getCnSeq() {
        return this.cnSeq;
    }

    /**
	* Column Info
	* @param  cntcEml
	*/
    public void setCntcEml(String cntcEml) {
        this.cntcEml = cntcEml;
    }

    /**
	 * Column Info
	 * @return	cntcEml
	 */
    public String getCntcEml() {
        return this.cntcEml;
    }

    /**
	* Column Info
	* @param  custCntCd
	*/
    public void setCustCntCd(String custCntCd) {
        this.custCntCd = custCntCd;
    }

    /**
	 * Column Info
	 * @return	custCntCd
	 */
    public String getCustCntCd() {
        return this.custCntCd;
    }

    /**
	* Column Info
	* @param  custNm
	*/
    public void setCustNm(String custNm) {
        this.custNm = custNm;
    }

    /**
	 * Column Info
	 * @return	custNm
	 */
    public String getCustNm() {
        return this.custNm;
    }

    /**
	* Column Info
	* @param  custSeq
	*/
    public void setCustSeq(String custSeq) {
        this.custSeq = custSeq;
    }

    /**
	 * Column Info
	 * @return	custSeq
	 */
    public String getCustSeq() {
        return this.custSeq;
    }

    /**
	* Column Info
	* @param  delCd
	*/
    public void setDelCd(String delCd) {
        this.delCd = delCd;
    }

    /**
	 * Column Info
	 * @return	delCd
	 */
    public String getDelCd() {
        return this.delCd;
    }

    /**
	* Column Info
	* @param  delivery
	*/
    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    /**
	 * Column Info
	 * @return	delivery
	 */
    public String getDelivery() {
        return this.delivery;
    }

    /**
	* Column Info
	* @param  docTpCd
	*/
    public void setDocTpCd(String docTpCd) {
        this.docTpCd = docTpCd;
    }

    /**
	 * Column Info
	 * @return	docTpCd
	 */
    public String getDocTpCd() {
        return this.docTpCd;
    }

    /**
	* Column Info
	* @param  excelFlg
	*/
    public void setExcelFlg(String excelFlg) {
        this.excelFlg = excelFlg;
    }

    /**
	 * Column Info
	 * @return	excelFlg
	 */
    public String getExcelFlg() {
        return this.excelFlg;
    }

    /**
	* Column Info
	* @param  ffCnt
	*/
    public void setFfCnt(String ffCnt) {
        this.ffCnt = ffCnt;
    }

    /**
	 * Column Info
	 * @return	ffCnt
	 */
    public String getFfCnt() {
        return this.ffCnt;
    }

    /**
	* Column Info
	* @param  ffNm
	*/
    public void setFfNm(String ffNm) {
        this.ffNm = ffNm;
    }

    /**
	 * Column Info
	 * @return	ffNm
	 */
    public String getFfNm() {
        return this.ffNm;
    }

    /**
	* Column Info
	* @param  ffSeq
	*/
    public void setFfSeq(String ffSeq) {
        this.ffSeq = ffSeq;
    }

    /**
	 * Column Info
	 * @return	ffSeq
	 */
    public String getFfSeq() {
        return this.ffSeq;
    }

    /**
	* Column Info
	* @param  hndlOfcCd
	*/
    public void setHndlOfcCd(String hndlOfcCd) {
        this.hndlOfcCd = hndlOfcCd;
    }

    /**
	 * Column Info
	 * @return	hndlOfcCd
	 */
    public String getHndlOfcCd() {
        return this.hndlOfcCd;
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
	* @param  ofcCd
	*/
    public void setOfcCd(String ofcCd) {
        this.ofcCd = ofcCd;
    }

    /**
	 * Column Info
	 * @return	ofcCd
	 */
    public String getOfcCd() {
        return this.ofcCd;
    }

    /**
	* Column Info
	* @param  origin
	*/
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
	 * Column Info
	 * @return	origin
	 */
    public String getOrigin() {
        return this.origin;
    }

    /**
	* Column Info
	* @param  pageNo
	*/
    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    /**
	 * Column Info
	 * @return	pageNo
	 */
    public String getPageNo() {
        return this.pageNo;
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
	* @param  podCd
	*/
    public void setPodCd(String podCd) {
        this.podCd = podCd;
    }

    /**
	 * Column Info
	 * @return	podCd
	 */
    public String getPodCd() {
        return this.podCd;
    }

    /**
	* Column Info
	* @param  polCd
	*/
    public void setPolCd(String polCd) {
        this.polCd = polCd;
    }

    /**
	 * Column Info
	 * @return	polCd
	 */
    public String getPolCd() {
        return this.polCd;
    }

    /**
	* Column Info
	* @param  poNo
	*/
    public void setPoNo(String poNo) {
        this.poNo = poNo;
    }

    /**
	 * Column Info
	 * @return	poNo
	 */
    public String getPoNo() {
        return this.poNo;
    }

    /**
	* Column Info
	* @param  porCd
	*/
    public void setPorCd(String porCd) {
        this.porCd = porCd;
    }

    /**
	 * Column Info
	 * @return	porCd
	 */
    public String getPorCd() {
        return this.porCd;
    }

    /**
	* Column Info
	* @param  rqstFromDt
	*/
    public void setRqstFromDt(String rqstFromDt) {
        this.rqstFromDt = rqstFromDt;
    }

    /**
	 * Column Info
	 * @return	rqstFromDt
	 */
    public String getRqstFromDt() {
        return this.rqstFromDt;
    }

    /**
	* Column Info
	* @param  rqstToDt
	*/
    public void setRqstToDt(String rqstToDt) {
        this.rqstToDt = rqstToDt;
    }

    /**
	 * Column Info
	 * @return	rqstToDt
	 */
    public String getRqstToDt() {
        return this.rqstToDt;
    }

    /**
	* Column Info
	* @param  setQryWhere
	*/
    public void setSetQryWhere(String setQryWhere) {
        this.setQryWhere = setQryWhere;
    }

    /**
	 * Column Info
	 * @return	setQryWhere
	 */
    public String getSetQryWhere() {
        return this.setQryWhere;
    }

    /**
	* Column Info
	* @param  setSlctFlg
	*/
    public void setSetSlctFlg(String setSlctFlg) {
        this.setSlctFlg = setSlctFlg;
    }

    /**
	 * Column Info
	 * @return	setSlctFlg
	 */
    public String getSetSlctFlg() {
        return this.setSlctFlg;
    }

    /**
	* Column Info
	* @param  shCnt
	*/
    public void setShCnt(String shCnt) {
        this.shCnt = shCnt;
    }

    /**
	 * Column Info
	 * @return	shCnt
	 */
    public String getShCnt() {
        return this.shCnt;
    }

    /**
	* Column Info
	* @param  shNm
	*/
    public void setShNm(String shNm) {
        this.shNm = shNm;
    }

    /**
	 * Column Info
	 * @return	shNm
	 */
    public String getShNm() {
        return this.shNm;
    }

    /**
	* Column Info
	* @param  shSeq
	*/
    public void setShSeq(String shSeq) {
        this.shSeq = shSeq;
    }

    /**
	 * Column Info
	 * @return	shSeq
	 */
    public String getShSeq() {
        return this.shSeq;
    }

    /**
	* Column Info
	* @param  xterBkgRqstStsCd
	*/
    public void setXterBkgRqstStsCd(String xterBkgRqstStsCd) {
        this.xterBkgRqstStsCd = xterBkgRqstStsCd;
    }

    /**
	 * Column Info
	 * @return	xterBkgRqstStsCd
	 */
    public String getXterBkgRqstStsCd() {
        return this.xterBkgRqstStsCd;
    }

    /**
	* Column Info
	* @param  xterRqstNo
	*/
    public void setXterRqstNo(String xterRqstNo) {
        this.xterRqstNo = xterRqstNo;
    }

    /**
	 * Column Info
	 * @return	xterRqstNo
	 */
    public String getXterRqstNo() {
        return this.xterRqstNo;
    }

    /**
	* Column Info
	* @param  xterRqstSeq
	*/
    public void setXterRqstSeq(String xterRqstSeq) {
        this.xterRqstSeq = xterRqstSeq;
    }

    /**
	 * Column Info
	 * @return	xterRqstSeq
	 */
    public String getXterRqstSeq() {
        return this.xterRqstSeq;
    }

    /**
	* Column Info
	* @param  xterRqstViaCd
	*/
    public void setXterRqstViaCd(String xterRqstViaCd) {
        this.xterRqstViaCd = xterRqstViaCd;
    }

    /**
	 * Column Info
	 * @return	xterRqstViaCd
	 */
    public String getXterRqstViaCd() {
        return this.xterRqstViaCd;
    }

    /**
	* Column Info
	* @param  xterSndrId
	*/
    public void setXterSndrId(String xterSndrId) {
        this.xterSndrId = xterSndrId;
    }

    /**
	 * Column Info
	 * @return	xterSndrId
	 */
    public String getXterSndrId() {
        return this.xterSndrId;
    }

    /**
	* Column Info
	* @param  chnAgnCd
	*/
    public void setChnAgnCd(String chnAgnCd) {
        this.chnAgnCd = chnAgnCd;
    }

    /**
	 * Column Info
	 * @return	chnAgnCd
	 */
    public String getChnAgnCd() {
        return this.chnAgnCd;
    }

    /**
	* Column Info
	* @param  vvd
	*/
    public void setVvd(String vvd) {
        this.vvd = vvd;
    }

    /**
	 * Column Info
	 * @return	vvd
	 */
    public String getVvd() {
        return this.vvd;
    }

    /**
	* Column Info
	* @param  lane
	*/
    public void setLane(String lane) {
        this.lane = lane;
    }

    /**
	 * Column Info
	 * @return	lane
	 */
    public String getLane() {
        return this.lane;
    }

    /**
	* Column Info
	* @param  splitBkgYn
	*/
    public void setSplitBkgYn(String splitBkgYn) {
        this.splitBkgYn = splitBkgYn;
    }

    /**
	 * Column Info
	 * @return	splitBkgYn
	 */
    public String getSplitBkgYn() {
        return this.splitBkgYn;
    }

    /**
	* Column Info
	* @param  blFntOfcYn
	*/
    public void setBlFntOfcYn(String blFntOfcYn) {
        this.blFntOfcYn = blFntOfcYn;
    }

    /**
	 * Column Info
	 * @return	blFntOfcYn
	 */
    public String getBlFntOfcYn() {
        return this.blFntOfcYn;
    }

    /**
	* Column Info
	* @param  sysUpldFlg
	*/
    public void setSysUpldFlg(String sysUpldFlg) {
        this.sysUpldFlg = sysUpldFlg;
    }

    /**
	 * Column Info
	 * @return	sysUpldFlg
	 */
    public String getSysUpldFlg() {
        return this.sysUpldFlg;
    }

    /**
	* Column Info
	* @param  siAudFlg
	*/
    public void setSiAudFlg(String siAudFlg) {
        this.siAudFlg = siAudFlg;
    }

    /**
	 * Column Info
	 * @return	siAudFlg
	 */
    public String getSiAudFlg() {
        return this.siAudFlg;
    }

    /**
	* Column Info
	* @param  vgmFlg
	*/
    public void setVgmFlg(String vgmFlg) {
        this.vgmFlg = vgmFlg;
    }

    /**
	 * Column Info
	 * @return	vgmFlg
	 */
    public String getVgmFlg() {
        return this.vgmFlg;
    }

    public void setNonRtStsCd(String nonRtStsCd) {
        this.nonRtStsCd = nonRtStsCd;
    }

    public String getNonRtStsCd() {
        return this.nonRtStsCd;
    }

    public void setInttraRtv(String inttraRtv) {
        this.inttraRtv = inttraRtv;
    }

    public String getInttraRtv() {
        return this.inttraRtv;
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
        setBkgCustTpCd(JSPUtil.getParameter(request, prefix + "bkg_cust_tp_cd", ""));
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setBkgNoSplit(JSPUtil.getParameter(request, prefix + "bkg_no_split", ""));
        setBkgUpldStsCd(JSPUtil.getParameter(request, prefix + "bkg_upld_sts_cd", ""));
        setCnCnt(JSPUtil.getParameter(request, prefix + "cn_cnt", ""));
        setCnNm(JSPUtil.getParameter(request, prefix + "cn_nm", ""));
        setCnSeq(JSPUtil.getParameter(request, prefix + "cn_seq", ""));
        setCntcEml(JSPUtil.getParameter(request, prefix + "cntc_eml", ""));
        setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
        setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
        setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
        setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
        setDelivery(JSPUtil.getParameter(request, prefix + "delivery", ""));
        setDocTpCd(JSPUtil.getParameter(request, prefix + "doc_tp_cd", ""));
        setExcelFlg(JSPUtil.getParameter(request, prefix + "excel_flg", ""));
        setFfCnt(JSPUtil.getParameter(request, prefix + "ff_cnt", ""));
        setFfNm(JSPUtil.getParameter(request, prefix + "ff_nm", ""));
        setFfSeq(JSPUtil.getParameter(request, prefix + "ff_seq", ""));
        setHndlOfcCd(JSPUtil.getParameter(request, prefix + "hndl_ofc_cd", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
        setOrigin(JSPUtil.getParameter(request, prefix + "origin", ""));
        setPageNo(JSPUtil.getParameter(request, prefix + "page_no", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setPoNo(JSPUtil.getParameter(request, prefix + "po_no", ""));
        setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
        setRqstFromDt(JSPUtil.getParameter(request, prefix + "rqst_from_dt", ""));
        setRqstToDt(JSPUtil.getParameter(request, prefix + "rqst_to_dt", ""));
        setSetQryWhere(JSPUtil.getParameter(request, prefix + "set_qry_where", ""));
        setSetSlctFlg(JSPUtil.getParameter(request, prefix + "set_slct_flg", ""));
        setShCnt(JSPUtil.getParameter(request, prefix + "sh_cnt", ""));
        setShNm(JSPUtil.getParameter(request, prefix + "sh_nm", ""));
        setShSeq(JSPUtil.getParameter(request, prefix + "sh_seq", ""));
        setXterBkgRqstStsCd(JSPUtil.getParameter(request, prefix + "xter_bkg_rqst_sts_cd", ""));
        setXterRqstNo(JSPUtil.getParameter(request, prefix + "xter_rqst_no", ""));
        setXterRqstSeq(JSPUtil.getParameter(request, prefix + "xter_rqst_seq", ""));
        setXterRqstViaCd(JSPUtil.getParameter(request, prefix + "xter_rqst_via_cd", ""));
        setXterSndrId(JSPUtil.getParameter(request, prefix + "xter_sndr_id", ""));
        setChnAgnCd(JSPUtil.getParameter(request, prefix + "chn_agn_cd", ""));
        setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
        setLane(JSPUtil.getParameter(request, prefix + "lane", ""));
        setSplitBkgYn(JSPUtil.getParameter(request, prefix + "split_bkg_yn", ""));
        setBlFntOfcYn(JSPUtil.getParameter(request, prefix + "bl_fnt_ofc_yn", ""));
        setSysUpldFlg(JSPUtil.getParameter(request, prefix + "sys_upld_flg", ""));
        setSiAudFlg(JSPUtil.getParameter(request, prefix + "si_aud_flg", ""));
        setVgmFlg(JSPUtil.getParameter(request, prefix + "vgm_flg", ""));
        setNonRtStsCd(JSPUtil.getParameter(request, prefix + "non_rt_sts_cd", ""));
        setInttraRtv(JSPUtil.getParameter(request, prefix + "inttra_rtv", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ExternalRqstListInputVO[]
	 */
    public ExternalRqstListInputVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ExternalRqstListInputVO[]
	 */
    public ExternalRqstListInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        ExternalRqstListInputVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] bkgCustTpCd = (JSPUtil.getParameter(request, prefix + "bkg_cust_tp_cd".trim(), length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no".trim(), length));
            String[] bkgNoSplit = (JSPUtil.getParameter(request, prefix + "bkg_no_split".trim(), length));
            String[] bkgUpldStsCd = (JSPUtil.getParameter(request, prefix + "bkg_upld_sts_cd".trim(), length));
            String[] cnCnt = (JSPUtil.getParameter(request, prefix + "cn_cnt".trim(), length));
            String[] cnNm = (JSPUtil.getParameter(request, prefix + "cn_nm".trim(), length));
            String[] cnSeq = (JSPUtil.getParameter(request, prefix + "cn_seq".trim(), length));
            String[] cntcEml = (JSPUtil.getParameter(request, prefix + "cntc_eml".trim(), length));
            String[] custCntCd = (JSPUtil.getParameter(request, prefix + "cust_cnt_cd".trim(), length));
            String[] custNm = (JSPUtil.getParameter(request, prefix + "cust_nm".trim(), length));
            String[] custSeq = (JSPUtil.getParameter(request, prefix + "cust_seq".trim(), length));
            String[] delCd = (JSPUtil.getParameter(request, prefix + "del_cd".trim(), length));
            String[] delivery = (JSPUtil.getParameter(request, prefix + "delivery".trim(), length));
            String[] docTpCd = (JSPUtil.getParameter(request, prefix + "doc_tp_cd".trim(), length));
            String[] excelFlg = (JSPUtil.getParameter(request, prefix + "excel_flg".trim(), length));
            String[] ffCnt = (JSPUtil.getParameter(request, prefix + "ff_cnt".trim(), length));
            String[] ffNm = (JSPUtil.getParameter(request, prefix + "ff_nm".trim(), length));
            String[] ffSeq = (JSPUtil.getParameter(request, prefix + "ff_seq".trim(), length));
            String[] hndlOfcCd = (JSPUtil.getParameter(request, prefix + "hndl_ofc_cd".trim(), length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag".trim(), length));
            String[] ofcCd = (JSPUtil.getParameter(request, prefix + "ofc_cd".trim(), length));
            String[] origin = (JSPUtil.getParameter(request, prefix + "origin".trim(), length));
            String[] pageNo = (JSPUtil.getParameter(request, prefix + "page_no".trim(), length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows".trim(), length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd".trim(), length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd".trim(), length));
            String[] poNo = (JSPUtil.getParameter(request, prefix + "po_no".trim(), length));
            String[] porCd = (JSPUtil.getParameter(request, prefix + "por_cd".trim(), length));
            String[] rqstFromDt = (JSPUtil.getParameter(request, prefix + "rqst_from_dt".trim(), length));
            String[] rqstToDt = (JSPUtil.getParameter(request, prefix + "rqst_to_dt".trim(), length));
            String[] setQryWhere = (JSPUtil.getParameter(request, prefix + "set_qry_where".trim(), length));
            String[] setSlctFlg = (JSPUtil.getParameter(request, prefix + "set_slct_flg".trim(), length));
            String[] shCnt = (JSPUtil.getParameter(request, prefix + "sh_cnt".trim(), length));
            String[] shNm = (JSPUtil.getParameter(request, prefix + "sh_nm".trim(), length));
            String[] shSeq = (JSPUtil.getParameter(request, prefix + "sh_seq".trim(), length));
            String[] xterBkgRqstStsCd = (JSPUtil.getParameter(request, prefix + "xter_bkg_rqst_sts_cd".trim(), length));
            String[] xterRqstNo = (JSPUtil.getParameter(request, prefix + "xter_rqst_no".trim(), length));
            String[] xterRqstSeq = (JSPUtil.getParameter(request, prefix + "xter_rqst_seq".trim(), length));
            String[] xterRqstViaCd = (JSPUtil.getParameter(request, prefix + "xter_rqst_via_cd".trim(), length));
            String[] xterSndrId = (JSPUtil.getParameter(request, prefix + "xter_sndr_id".trim(), length));
            String[] chnAgnCd = (JSPUtil.getParameter(request, prefix + "chn_agn_cd".trim(), length));
            String[] vvd = (JSPUtil.getParameter(request, prefix + "vvd".trim(), length));
            String[] lane = (JSPUtil.getParameter(request, prefix + "lane".trim(), length));
            String[] splitBkgYn = (JSPUtil.getParameter(request, prefix + "split_bkg_yn".trim(), length));
            String[] blFntOfcYn = (JSPUtil.getParameter(request, prefix + "bl_fnt_ofc_yn".trim(), length));
            String[] sysUpldFlg = (JSPUtil.getParameter(request, prefix + "sys_upld_flg".trim(), length));
            String[] siAudFlg = (JSPUtil.getParameter(request, prefix + "si_aud_flg".trim(), length));
            String[] vgmFlg = (JSPUtil.getParameter(request, prefix + "vgm_flg".trim(), length));
            String[] nonRtStsCd = (JSPUtil.getParameter(request, prefix + "non_rt_sts_cd", length));
            String[] inttraRtv = (JSPUtil.getParameter(request, prefix + "inttra_rtv", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new ExternalRqstListInputVO();
                if (bkgCustTpCd[i] != null)
                    model.setBkgCustTpCd(bkgCustTpCd[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (bkgNoSplit[i] != null)
                    model.setBkgNoSplit(bkgNoSplit[i]);
                if (bkgUpldStsCd[i] != null)
                    model.setBkgUpldStsCd(bkgUpldStsCd[i]);
                if (cnCnt[i] != null)
                    model.setCnCnt(cnCnt[i]);
                if (cnNm[i] != null)
                    model.setCnNm(cnNm[i]);
                if (cnSeq[i] != null)
                    model.setCnSeq(cnSeq[i]);
                if (cntcEml[i] != null)
                    model.setCntcEml(cntcEml[i]);
                if (custCntCd[i] != null)
                    model.setCustCntCd(custCntCd[i]);
                if (custNm[i] != null)
                    model.setCustNm(custNm[i]);
                if (custSeq[i] != null)
                    model.setCustSeq(custSeq[i]);
                if (delCd[i] != null)
                    model.setDelCd(delCd[i]);
                if (delivery[i] != null)
                    model.setDelivery(delivery[i]);
                if (docTpCd[i] != null)
                    model.setDocTpCd(docTpCd[i]);
                if (excelFlg[i] != null)
                    model.setExcelFlg(excelFlg[i]);
                if (ffCnt[i] != null)
                    model.setFfCnt(ffCnt[i]);
                if (ffNm[i] != null)
                    model.setFfNm(ffNm[i]);
                if (ffSeq[i] != null)
                    model.setFfSeq(ffSeq[i]);
                if (hndlOfcCd[i] != null)
                    model.setHndlOfcCd(hndlOfcCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (ofcCd[i] != null)
                    model.setOfcCd(ofcCd[i]);
                if (origin[i] != null)
                    model.setOrigin(origin[i]);
                if (pageNo[i] != null)
                    model.setPageNo(pageNo[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (poNo[i] != null)
                    model.setPoNo(poNo[i]);
                if (porCd[i] != null)
                    model.setPorCd(porCd[i]);
                if (rqstFromDt[i] != null)
                    model.setRqstFromDt(rqstFromDt[i]);
                if (rqstToDt[i] != null)
                    model.setRqstToDt(rqstToDt[i]);
                if (setQryWhere[i] != null)
                    model.setSetQryWhere(setQryWhere[i]);
                if (setSlctFlg[i] != null)
                    model.setSetSlctFlg(setSlctFlg[i]);
                if (shCnt[i] != null)
                    model.setShCnt(shCnt[i]);
                if (shNm[i] != null)
                    model.setShNm(shNm[i]);
                if (shSeq[i] != null)
                    model.setShSeq(shSeq[i]);
                if (xterBkgRqstStsCd[i] != null)
                    model.setXterBkgRqstStsCd(xterBkgRqstStsCd[i]);
                if (xterRqstNo[i] != null)
                    model.setXterRqstNo(xterRqstNo[i]);
                if (xterRqstSeq[i] != null)
                    model.setXterRqstSeq(xterRqstSeq[i]);
                if (xterRqstViaCd[i] != null)
                    model.setXterRqstViaCd(xterRqstViaCd[i]);
                if (xterSndrId[i] != null)
                    model.setXterSndrId(xterSndrId[i]);
                if (chnAgnCd[i] != null)
                    model.setChnAgnCd(chnAgnCd[i]);
                if (vvd[i] != null)
                    model.setVvd(vvd[i]);
                if (lane[i] != null)
                    model.setLane(lane[i]);
                if (splitBkgYn[i] != null)
                    model.setSplitBkgYn(splitBkgYn[i]);
                if (blFntOfcYn[i] != null)
                    model.setBlFntOfcYn(blFntOfcYn[i]);
                if (sysUpldFlg[i] != null)
                    model.setSysUpldFlg(sysUpldFlg[i]);
                if (siAudFlg[i] != null)
                    model.setSiAudFlg(siAudFlg[i]);
                if (vgmFlg[i] != null)
                    model.setVgmFlg(vgmFlg[i]);
                if (nonRtStsCd[i] != null)
                    model.setNonRtStsCd(nonRtStsCd[i]);
                if (inttraRtv[i] != null) 
		    		model.setInttraRtv(inttraRtv[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getExternalRqstListInputVOs();
    }

    /**
	 *  VO 배열을 반환
	 * @return ExternalRqstListInputVO[]
	 */
    public ExternalRqstListInputVO[] getExternalRqstListInputVOs() {
        ExternalRqstListInputVO[] vos = (ExternalRqstListInputVO[]) models.toArray(new ExternalRqstListInputVO[models.size()]);
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
        this.bkgCustTpCd = this.bkgCustTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNoSplit = this.bkgNoSplit.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgUpldStsCd = this.bkgUpldStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cnCnt = this.cnCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cnNm = this.cnNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cnSeq = this.cnSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntcEml = this.cntcEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCntCd = this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custNm = this.custNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custSeq = this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delCd = this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delivery = this.delivery.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.docTpCd = this.docTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.excelFlg = this.excelFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ffCnt = this.ffCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ffNm = this.ffNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ffSeq = this.ffSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hndlOfcCd = this.hndlOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcCd = this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.origin = this.origin.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pageNo = this.pageNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.poNo = this.poNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.porCd = this.porCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstFromDt = this.rqstFromDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstToDt = this.rqstToDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.setQryWhere = this.setQryWhere.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.setSlctFlg = this.setSlctFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shCnt = this.shCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shNm = this.shNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shSeq = this.shSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterBkgRqstStsCd = this.xterBkgRqstStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterRqstNo = this.xterRqstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterRqstSeq = this.xterRqstSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterRqstViaCd = this.xterRqstViaCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterSndrId = this.xterSndrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chnAgnCd = this.chnAgnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvd = this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lane = this.lane.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.splitBkgYn = this.splitBkgYn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blFntOfcYn = this.blFntOfcYn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sysUpldFlg = this.sysUpldFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.siAudFlg = this.siAudFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vgmFlg = this.vgmFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nonRtStsCd = this.nonRtStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inttraRtv = this.inttraRtv.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
