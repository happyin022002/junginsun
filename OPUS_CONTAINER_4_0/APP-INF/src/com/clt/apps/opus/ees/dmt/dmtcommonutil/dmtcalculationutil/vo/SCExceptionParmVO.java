/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCExceptionParmVO.java
*@FileTitle : SCExceptionParmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.29
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.12.29 최성환 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo;

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
 * @author 최성환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class SCExceptionParmVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<SCExceptionParmVO> models = new ArrayList<SCExceptionParmVO>();

    /* Column Info */
    private String delRgnCd = null;

    /* Column Info */
    private String yrdCntCd = null;

    /* Column Info */
    private String cmdtTliNo = null;

    /* Column Info */
    private String yrdRgnCd = null;

    /* Column Info */
    private String parCntCd = null;

    /* Column Info */
    private String polSteCd = null;

    /* Page Number */
    private String pagerows = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String cmdtCd = null;

    /* Column Info */
    private String yrdSteCd = null;

    /* Column Info */
    private String polRgnCd = null;

    /* Column Info */
    private String scNo = null;

    /* Column Info */
    private String actCustCntCd = null;

    /* Column Info */
    private String porCntCd = null;

    /* Column Info */
    private String custCntCd = null;

    /* Column Info */
    private String delSteCd = null;

    /* Column Info */
    private String cntrCgoTp = null;

    /* Column Info */
    private String yrdLocCd = null;

    /* Column Info */
    private String parContiCd = null;

    /* Column Info */
    private String bbDeTermCd = null;

    /* Column Info */
    private String delCntCd = null;

    /* Column Info */
    private String delLocCd = null;

    /* Column Info */
    private String parSteCd = null;

    /* Column Info */
    private String actCustSeq = null;

    /* Column Info */
    private String efftDt = null;

    /* Column Info */
    private String bbRcvTermCd = null;

    /* Column Info */
    private String parRgnCd = null;

    /* Column Info */
    private String ioBndCd = null;

    /* Column Info */
    private String porLocCd = null;

    /* Column Info */
    private String polCntCd = null;

    /* Column Info */
    private String polContiCd = null;

    /* Column Info */
    private String cntrTp = null;

    /* Column Info */
    private String dttCode = null;

    /* Column Info */
    private String polLocCd = null;

    /* Column Info */
    private String porSteCd = null;

    /* Column Info */
    private String yrdContiCd = null;

    /* Column Info */
    private String custCd = null;

    /* Column Info */
    private String delContiCd = null;

    /* Column Info */
    private String porRgnCd = null;

    /* Column Info */
    private String cgoTp = null;

    /* Column Info */
    private String parLocCd = null;

    /* Column Info */
    private String repCmdtCd = null;

    /* Column Info */
    private String porContiCd = null;

    /* Column Info */
    private String awkInOut = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public SCExceptionParmVO() {
    }

    public SCExceptionParmVO(String ibflag, String pagerows, String scNo, String dttCode, String ioBndCd, String cntrTp, String cgoTp, String cntrCgoTp, String efftDt, String polContiCd, String polCntCd, String polRgnCd, String polSteCd, String polLocCd, String delContiCd, String delCntCd, String delRgnCd, String delSteCd, String delLocCd, String porContiCd, String porCntCd, String porRgnCd, String porSteCd, String porLocCd, String yrdContiCd, String yrdCntCd, String yrdRgnCd, String yrdSteCd, String yrdLocCd, String cmdtCd, String cmdtTliNo, String repCmdtCd, String custCntCd, String custCd, String actCustCntCd, String actCustSeq, String parContiCd, String parCntCd, String parRgnCd, String parSteCd, String parLocCd, String bbRcvTermCd, String bbDeTermCd, String awkInOut) {
        this.delRgnCd = delRgnCd;
        this.yrdCntCd = yrdCntCd;
        this.cmdtTliNo = cmdtTliNo;
        this.yrdRgnCd = yrdRgnCd;
        this.parCntCd = parCntCd;
        this.polSteCd = polSteCd;
        this.pagerows = pagerows;
        this.ibflag = ibflag;
        this.cmdtCd = cmdtCd;
        this.yrdSteCd = yrdSteCd;
        this.polRgnCd = polRgnCd;
        this.scNo = scNo;
        this.actCustCntCd = actCustCntCd;
        this.porCntCd = porCntCd;
        this.custCntCd = custCntCd;
        this.delSteCd = delSteCd;
        this.cntrCgoTp = cntrCgoTp;
        this.yrdLocCd = yrdLocCd;
        this.parContiCd = parContiCd;
        this.bbDeTermCd = bbDeTermCd;
        this.delCntCd = delCntCd;
        this.delLocCd = delLocCd;
        this.parSteCd = parSteCd;
        this.actCustSeq = actCustSeq;
        this.efftDt = efftDt;
        this.bbRcvTermCd = bbRcvTermCd;
        this.parRgnCd = parRgnCd;
        this.ioBndCd = ioBndCd;
        this.porLocCd = porLocCd;
        this.polCntCd = polCntCd;
        this.polContiCd = polContiCd;
        this.cntrTp = cntrTp;
        this.dttCode = dttCode;
        this.polLocCd = polLocCd;
        this.porSteCd = porSteCd;
        this.yrdContiCd = yrdContiCd;
        this.custCd = custCd;
        this.delContiCd = delContiCd;
        this.porRgnCd = porRgnCd;
        this.cgoTp = cgoTp;
        this.parLocCd = parLocCd;
        this.repCmdtCd = repCmdtCd;
        this.porContiCd = porContiCd;
        this.awkInOut = awkInOut;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("del_rgn_cd", getDelRgnCd());
        this.hashColumns.put("yrd_cnt_cd", getYrdCntCd());
        this.hashColumns.put("cmdt_tli_no", getCmdtTliNo());
        this.hashColumns.put("yrd_rgn_cd", getYrdRgnCd());
        this.hashColumns.put("par_cnt_cd", getParCntCd());
        this.hashColumns.put("pol_ste_cd", getPolSteCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("cmdt_cd", getCmdtCd());
        this.hashColumns.put("yrd_ste_cd", getYrdSteCd());
        this.hashColumns.put("pol_rgn_cd", getPolRgnCd());
        this.hashColumns.put("sc_no", getScNo());
        this.hashColumns.put("act_cust_cnt_cd", getActCustCntCd());
        this.hashColumns.put("por_cnt_cd", getPorCntCd());
        this.hashColumns.put("cust_cnt_cd", getCustCntCd());
        this.hashColumns.put("del_ste_cd", getDelSteCd());
        this.hashColumns.put("cntr_cgo_tp", getCntrCgoTp());
        this.hashColumns.put("yrd_loc_cd", getYrdLocCd());
        this.hashColumns.put("par_conti_cd", getParContiCd());
        this.hashColumns.put("bb_de_term_cd", getBbDeTermCd());
        this.hashColumns.put("del_cnt_cd", getDelCntCd());
        this.hashColumns.put("del_loc_cd", getDelLocCd());
        this.hashColumns.put("par_ste_cd", getParSteCd());
        this.hashColumns.put("act_cust_seq", getActCustSeq());
        this.hashColumns.put("efft_dt", getEfftDt());
        this.hashColumns.put("bb_rcv_term_cd", getBbRcvTermCd());
        this.hashColumns.put("par_rgn_cd", getParRgnCd());
        this.hashColumns.put("io_bnd_cd", getIoBndCd());
        this.hashColumns.put("por_loc_cd", getPorLocCd());
        this.hashColumns.put("pol_cnt_cd", getPolCntCd());
        this.hashColumns.put("pol_conti_cd", getPolContiCd());
        this.hashColumns.put("cntr_tp", getCntrTp());
        this.hashColumns.put("dtt_code", getDttCode());
        this.hashColumns.put("pol_loc_cd", getPolLocCd());
        this.hashColumns.put("por_ste_cd", getPorSteCd());
        this.hashColumns.put("yrd_conti_cd", getYrdContiCd());
        this.hashColumns.put("cust_cd", getCustCd());
        this.hashColumns.put("del_conti_cd", getDelContiCd());
        this.hashColumns.put("por_rgn_cd", getPorRgnCd());
        this.hashColumns.put("cgo_tp", getCgoTp());
        this.hashColumns.put("par_loc_cd", getParLocCd());
        this.hashColumns.put("rep_cmdt_cd", getRepCmdtCd());
        this.hashColumns.put("por_conti_cd", getPorContiCd());
        this.hashColumns.put("awk_in_out", getAwkInOut());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("del_rgn_cd", "delRgnCd");
        this.hashFields.put("yrd_cnt_cd", "yrdCntCd");
        this.hashFields.put("cmdt_tli_no", "cmdtTliNo");
        this.hashFields.put("yrd_rgn_cd", "yrdRgnCd");
        this.hashFields.put("par_cnt_cd", "parCntCd");
        this.hashFields.put("pol_ste_cd", "polSteCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("cmdt_cd", "cmdtCd");
        this.hashFields.put("yrd_ste_cd", "yrdSteCd");
        this.hashFields.put("pol_rgn_cd", "polRgnCd");
        this.hashFields.put("sc_no", "scNo");
        this.hashFields.put("act_cust_cnt_cd", "actCustCntCd");
        this.hashFields.put("por_cnt_cd", "porCntCd");
        this.hashFields.put("cust_cnt_cd", "custCntCd");
        this.hashFields.put("del_ste_cd", "delSteCd");
        this.hashFields.put("cntr_cgo_tp", "cntrCgoTp");
        this.hashFields.put("yrd_loc_cd", "yrdLocCd");
        this.hashFields.put("par_conti_cd", "parContiCd");
        this.hashFields.put("bb_de_term_cd", "bbDeTermCd");
        this.hashFields.put("del_cnt_cd", "delCntCd");
        this.hashFields.put("del_loc_cd", "delLocCd");
        this.hashFields.put("par_ste_cd", "parSteCd");
        this.hashFields.put("act_cust_seq", "actCustSeq");
        this.hashFields.put("efft_dt", "efftDt");
        this.hashFields.put("bb_rcv_term_cd", "bbRcvTermCd");
        this.hashFields.put("par_rgn_cd", "parRgnCd");
        this.hashFields.put("io_bnd_cd", "ioBndCd");
        this.hashFields.put("por_loc_cd", "porLocCd");
        this.hashFields.put("pol_cnt_cd", "polCntCd");
        this.hashFields.put("pol_conti_cd", "polContiCd");
        this.hashFields.put("cntr_tp", "cntrTp");
        this.hashFields.put("dtt_code", "dttCode");
        this.hashFields.put("pol_loc_cd", "polLocCd");
        this.hashFields.put("por_ste_cd", "porSteCd");
        this.hashFields.put("yrd_conti_cd", "yrdContiCd");
        this.hashFields.put("cust_cd", "custCd");
        this.hashFields.put("del_conti_cd", "delContiCd");
        this.hashFields.put("por_rgn_cd", "porRgnCd");
        this.hashFields.put("cgo_tp", "cgoTp");
        this.hashFields.put("par_loc_cd", "parLocCd");
        this.hashFields.put("rep_cmdt_cd", "repCmdtCd");
        this.hashFields.put("por_conti_cd", "porContiCd");
        this.hashFields.put("awk_in_out", "awkInOut");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return delRgnCd
	 */
    public String getDelRgnCd() {
        return this.delRgnCd;
    }

    /**
	 * Column Info
	 * @return yrdCntCd
	 */
    public String getYrdCntCd() {
        return this.yrdCntCd;
    }

    /**
	 * Column Info
	 * @return cmdtTliNo
	 */
    public String getCmdtTliNo() {
        return this.cmdtTliNo;
    }

    /**
	 * Column Info
	 * @return yrdRgnCd
	 */
    public String getYrdRgnCd() {
        return this.yrdRgnCd;
    }

    /**
	 * Column Info
	 * @return parCntCd
	 */
    public String getParCntCd() {
        return this.parCntCd;
    }

    /**
	 * Column Info
	 * @return polSteCd
	 */
    public String getPolSteCd() {
        return this.polSteCd;
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
	 * @return ibflag
	 */
    public String getIbflag() {
        return this.ibflag;
    }

    /**
	 * Column Info
	 * @return cmdtCd
	 */
    public String getCmdtCd() {
        return this.cmdtCd;
    }

    /**
	 * Column Info
	 * @return yrdSteCd
	 */
    public String getYrdSteCd() {
        return this.yrdSteCd;
    }

    /**
	 * Column Info
	 * @return polRgnCd
	 */
    public String getPolRgnCd() {
        return this.polRgnCd;
    }

    /**
	 * Column Info
	 * @return scNo
	 */
    public String getScNo() {
        return this.scNo;
    }

    /**
	 * Column Info
	 * @return actCustCntCd
	 */
    public String getActCustCntCd() {
        return this.actCustCntCd;
    }

    /**
	 * Column Info
	 * @return porCntCd
	 */
    public String getPorCntCd() {
        return this.porCntCd;
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
	 * @return delSteCd
	 */
    public String getDelSteCd() {
        return this.delSteCd;
    }

    /**
	 * Column Info
	 * @return cntrCgoTp
	 */
    public String getCntrCgoTp() {
        return this.cntrCgoTp;
    }

    /**
	 * Column Info
	 * @return yrdLocCd
	 */
    public String getYrdLocCd() {
        return this.yrdLocCd;
    }

    /**
	 * Column Info
	 * @return parContiCd
	 */
    public String getParContiCd() {
        return this.parContiCd;
    }

    /**
	 * Column Info
	 * @return bbDeTermCd
	 */
    public String getBbDeTermCd() {
        return this.bbDeTermCd;
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
	 * @return delLocCd
	 */
    public String getDelLocCd() {
        return this.delLocCd;
    }

    /**
	 * Column Info
	 * @return parSteCd
	 */
    public String getParSteCd() {
        return this.parSteCd;
    }

    /**
	 * Column Info
	 * @return actCustSeq
	 */
    public String getActCustSeq() {
        return this.actCustSeq;
    }

    /**
	 * Column Info
	 * @return efftDt
	 */
    public String getEfftDt() {
        return this.efftDt;
    }

    /**
	 * Column Info
	 * @return bbRcvTermCd
	 */
    public String getBbRcvTermCd() {
        return this.bbRcvTermCd;
    }

    /**
	 * Column Info
	 * @return parRgnCd
	 */
    public String getParRgnCd() {
        return this.parRgnCd;
    }

    /**
	 * Column Info
	 * @return ioBndCd
	 */
    public String getIoBndCd() {
        return this.ioBndCd;
    }

    /**
	 * Column Info
	 * @return porLocCd
	 */
    public String getPorLocCd() {
        return this.porLocCd;
    }

    /**
	 * Column Info
	 * @return polCntCd
	 */
    public String getPolCntCd() {
        return this.polCntCd;
    }

    /**
	 * Column Info
	 * @return polContiCd
	 */
    public String getPolContiCd() {
        return this.polContiCd;
    }

    /**
	 * Column Info
	 * @return cntrTp
	 */
    public String getCntrTp() {
        return this.cntrTp;
    }

    /**
	 * Column Info
	 * @return dttCode
	 */
    public String getDttCode() {
        return this.dttCode;
    }

    /**
	 * Column Info
	 * @return polLocCd
	 */
    public String getPolLocCd() {
        return this.polLocCd;
    }

    /**
	 * Column Info
	 * @return porSteCd
	 */
    public String getPorSteCd() {
        return this.porSteCd;
    }

    /**
	 * Column Info
	 * @return yrdContiCd
	 */
    public String getYrdContiCd() {
        return this.yrdContiCd;
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
	 * @return delContiCd
	 */
    public String getDelContiCd() {
        return this.delContiCd;
    }

    /**
	 * Column Info
	 * @return porRgnCd
	 */
    public String getPorRgnCd() {
        return this.porRgnCd;
    }

    /**
	 * Column Info
	 * @return cgoTp
	 */
    public String getCgoTp() {
        return this.cgoTp;
    }

    /**
	 * Column Info
	 * @return parLocCd
	 */
    public String getParLocCd() {
        return this.parLocCd;
    }

    /**
	 * Column Info
	 * @return repCmdtCd
	 */
    public String getRepCmdtCd() {
        return this.repCmdtCd;
    }

    /**
	 * Column Info
	 * @return porContiCd
	 */
    public String getPorContiCd() {
        return this.porContiCd;
    }

    /**
	 * Column Info
	 * @param delRgnCd
	 */
    public void setDelRgnCd(String delRgnCd) {
        this.delRgnCd = delRgnCd;
    }

    /**
	 * Column Info
	 * @param yrdCntCd
	 */
    public void setYrdCntCd(String yrdCntCd) {
        this.yrdCntCd = yrdCntCd;
    }

    /**
	 * Column Info
	 * @param cmdtTliNo
	 */
    public void setCmdtTliNo(String cmdtTliNo) {
        this.cmdtTliNo = cmdtTliNo;
    }

    /**
	 * Column Info
	 * @param yrdRgnCd
	 */
    public void setYrdRgnCd(String yrdRgnCd) {
        this.yrdRgnCd = yrdRgnCd;
    }

    /**
	 * Column Info
	 * @param parCntCd
	 */
    public void setParCntCd(String parCntCd) {
        this.parCntCd = parCntCd;
    }

    /**
	 * Column Info
	 * @param polSteCd
	 */
    public void setPolSteCd(String polSteCd) {
        this.polSteCd = polSteCd;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
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
	 * @param cmdtCd
	 */
    public void setCmdtCd(String cmdtCd) {
        this.cmdtCd = cmdtCd;
    }

    /**
	 * Column Info
	 * @param yrdSteCd
	 */
    public void setYrdSteCd(String yrdSteCd) {
        this.yrdSteCd = yrdSteCd;
    }

    /**
	 * Column Info
	 * @param polRgnCd
	 */
    public void setPolRgnCd(String polRgnCd) {
        this.polRgnCd = polRgnCd;
    }

    /**
	 * Column Info
	 * @param scNo
	 */
    public void setScNo(String scNo) {
        this.scNo = scNo;
    }

    /**
	 * Column Info
	 * @param actCustCntCd
	 */
    public void setActCustCntCd(String actCustCntCd) {
        this.actCustCntCd = actCustCntCd;
    }

    /**
	 * Column Info
	 * @param porCntCd
	 */
    public void setPorCntCd(String porCntCd) {
        this.porCntCd = porCntCd;
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
	 * @param delSteCd
	 */
    public void setDelSteCd(String delSteCd) {
        this.delSteCd = delSteCd;
    }

    /**
	 * Column Info
	 * @param cntrCgoTp
	 */
    public void setCntrCgoTp(String cntrCgoTp) {
        this.cntrCgoTp = cntrCgoTp;
    }

    /**
	 * Column Info
	 * @param yrdLocCd
	 */
    public void setYrdLocCd(String yrdLocCd) {
        this.yrdLocCd = yrdLocCd;
    }

    /**
	 * Column Info
	 * @param parContiCd
	 */
    public void setParContiCd(String parContiCd) {
        this.parContiCd = parContiCd;
    }

    /**
	 * Column Info
	 * @param bbDeTermCd
	 */
    public void setBbDeTermCd(String bbDeTermCd) {
        this.bbDeTermCd = bbDeTermCd;
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
	 * @param delLocCd
	 */
    public void setDelLocCd(String delLocCd) {
        this.delLocCd = delLocCd;
    }

    /**
	 * Column Info
	 * @param parSteCd
	 */
    public void setParSteCd(String parSteCd) {
        this.parSteCd = parSteCd;
    }

    /**
	 * Column Info
	 * @param actCustSeq
	 */
    public void setActCustSeq(String actCustSeq) {
        this.actCustSeq = actCustSeq;
    }

    /**
	 * Column Info
	 * @param efftDt
	 */
    public void setEfftDt(String efftDt) {
        this.efftDt = efftDt;
    }

    /**
	 * Column Info
	 * @param bbRcvTermCd
	 */
    public void setBbRcvTermCd(String bbRcvTermCd) {
        this.bbRcvTermCd = bbRcvTermCd;
    }

    /**
	 * Column Info
	 * @param parRgnCd
	 */
    public void setParRgnCd(String parRgnCd) {
        this.parRgnCd = parRgnCd;
    }

    /**
	 * Column Info
	 * @param ioBndCd
	 */
    public void setIoBndCd(String ioBndCd) {
        this.ioBndCd = ioBndCd;
    }

    /**
	 * Column Info
	 * @param porLocCd
	 */
    public void setPorLocCd(String porLocCd) {
        this.porLocCd = porLocCd;
    }

    /**
	 * Column Info
	 * @param polCntCd
	 */
    public void setPolCntCd(String polCntCd) {
        this.polCntCd = polCntCd;
    }

    /**
	 * Column Info
	 * @param polContiCd
	 */
    public void setPolContiCd(String polContiCd) {
        this.polContiCd = polContiCd;
    }

    /**
	 * Column Info
	 * @param cntrTp
	 */
    public void setCntrTp(String cntrTp) {
        this.cntrTp = cntrTp;
    }

    /**
	 * Column Info
	 * @param dttCode
	 */
    public void setDttCode(String dttCode) {
        this.dttCode = dttCode;
    }

    /**
	 * Column Info
	 * @param polLocCd
	 */
    public void setPolLocCd(String polLocCd) {
        this.polLocCd = polLocCd;
    }

    /**
	 * Column Info
	 * @param porSteCd
	 */
    public void setPorSteCd(String porSteCd) {
        this.porSteCd = porSteCd;
    }

    /**
	 * Column Info
	 * @param yrdContiCd
	 */
    public void setYrdContiCd(String yrdContiCd) {
        this.yrdContiCd = yrdContiCd;
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
	 * @param delContiCd
	 */
    public void setDelContiCd(String delContiCd) {
        this.delContiCd = delContiCd;
    }

    /**
	 * Column Info
	 * @param porRgnCd
	 */
    public void setPorRgnCd(String porRgnCd) {
        this.porRgnCd = porRgnCd;
    }

    /**
	 * Column Info
	 * @param cgoTp
	 */
    public void setCgoTp(String cgoTp) {
        this.cgoTp = cgoTp;
    }

    /**
	 * Column Info
	 * @param parLocCd
	 */
    public void setParLocCd(String parLocCd) {
        this.parLocCd = parLocCd;
    }

    /**
	 * Column Info
	 * @param repCmdtCd
	 */
    public void setRepCmdtCd(String repCmdtCd) {
        this.repCmdtCd = repCmdtCd;
    }

    /**
	 * Column Info
	 * @param porContiCd
	 */
    public void setPorContiCd(String porContiCd) {
        this.porContiCd = porContiCd;
    }

    public void setAwkInOut(String awkInOut) {
        this.awkInOut = awkInOut;
    }

    public String getAwkInOut() {
        return this.awkInOut;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setDelRgnCd(JSPUtil.getParameter(request, "del_rgn_cd", ""));
        setYrdCntCd(JSPUtil.getParameter(request, "yrd_cnt_cd", ""));
        setCmdtTliNo(JSPUtil.getParameter(request, "cmdt_tli_no", ""));
        setYrdRgnCd(JSPUtil.getParameter(request, "yrd_rgn_cd", ""));
        setParCntCd(JSPUtil.getParameter(request, "par_cnt_cd", ""));
        setPolSteCd(JSPUtil.getParameter(request, "pol_ste_cd", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setCmdtCd(JSPUtil.getParameter(request, "cmdt_cd", ""));
        setYrdSteCd(JSPUtil.getParameter(request, "yrd_ste_cd", ""));
        setPolRgnCd(JSPUtil.getParameter(request, "pol_rgn_cd", ""));
        setScNo(JSPUtil.getParameter(request, "sc_no", ""));
        setActCustCntCd(JSPUtil.getParameter(request, "act_cust_cnt_cd", ""));
        setPorCntCd(JSPUtil.getParameter(request, "por_cnt_cd", ""));
        setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
        setDelSteCd(JSPUtil.getParameter(request, "del_ste_cd", ""));
        setCntrCgoTp(JSPUtil.getParameter(request, "cntr_cgo_tp", ""));
        setYrdLocCd(JSPUtil.getParameter(request, "yrd_loc_cd", ""));
        setParContiCd(JSPUtil.getParameter(request, "par_conti_cd", ""));
        setBbDeTermCd(JSPUtil.getParameter(request, "bb_de_term_cd", ""));
        setDelCntCd(JSPUtil.getParameter(request, "del_cnt_cd", ""));
        setDelLocCd(JSPUtil.getParameter(request, "del_loc_cd", ""));
        setParSteCd(JSPUtil.getParameter(request, "par_ste_cd", ""));
        setActCustSeq(JSPUtil.getParameter(request, "act_cust_seq", ""));
        setEfftDt(JSPUtil.getParameter(request, "efft_dt", ""));
        setBbRcvTermCd(JSPUtil.getParameter(request, "bb_rcv_term_cd", ""));
        setParRgnCd(JSPUtil.getParameter(request, "par_rgn_cd", ""));
        setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
        setPorLocCd(JSPUtil.getParameter(request, "por_loc_cd", ""));
        setPolCntCd(JSPUtil.getParameter(request, "pol_cnt_cd", ""));
        setPolContiCd(JSPUtil.getParameter(request, "pol_conti_cd", ""));
        setCntrTp(JSPUtil.getParameter(request, "cntr_tp", ""));
        setDttCode(JSPUtil.getParameter(request, "dtt_code", ""));
        setPolLocCd(JSPUtil.getParameter(request, "pol_loc_cd", ""));
        setPorSteCd(JSPUtil.getParameter(request, "por_ste_cd", ""));
        setYrdContiCd(JSPUtil.getParameter(request, "yrd_conti_cd", ""));
        setCustCd(JSPUtil.getParameter(request, "cust_cd", ""));
        setDelContiCd(JSPUtil.getParameter(request, "del_conti_cd", ""));
        setPorRgnCd(JSPUtil.getParameter(request, "por_rgn_cd", ""));
        setCgoTp(JSPUtil.getParameter(request, "cgo_tp", ""));
        setParLocCd(JSPUtil.getParameter(request, "par_loc_cd", ""));
        setRepCmdtCd(JSPUtil.getParameter(request, "rep_cmdt_cd", ""));
        setPorContiCd(JSPUtil.getParameter(request, "por_conti_cd", ""));
        setAwkInOut(JSPUtil.getParameter(request, "awk_in_out", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SCExceptionParmVO[]
	 */
    public SCExceptionParmVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SCExceptionParmVO[]
	 */
    public SCExceptionParmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        SCExceptionParmVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] delRgnCd = (JSPUtil.getParameter(request, prefix + "del_rgn_cd", length));
            String[] yrdCntCd = (JSPUtil.getParameter(request, prefix + "yrd_cnt_cd", length));
            String[] cmdtTliNo = (JSPUtil.getParameter(request, prefix + "cmdt_tli_no", length));
            String[] yrdRgnCd = (JSPUtil.getParameter(request, prefix + "yrd_rgn_cd", length));
            String[] parCntCd = (JSPUtil.getParameter(request, prefix + "par_cnt_cd", length));
            String[] polSteCd = (JSPUtil.getParameter(request, prefix + "pol_ste_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] cmdtCd = (JSPUtil.getParameter(request, prefix + "cmdt_cd", length));
            String[] yrdSteCd = (JSPUtil.getParameter(request, prefix + "yrd_ste_cd", length));
            String[] polRgnCd = (JSPUtil.getParameter(request, prefix + "pol_rgn_cd", length));
            String[] scNo = (JSPUtil.getParameter(request, prefix + "sc_no", length));
            String[] actCustCntCd = (JSPUtil.getParameter(request, prefix + "act_cust_cnt_cd", length));
            String[] porCntCd = (JSPUtil.getParameter(request, prefix + "por_cnt_cd", length));
            String[] custCntCd = (JSPUtil.getParameter(request, prefix + "cust_cnt_cd", length));
            String[] delSteCd = (JSPUtil.getParameter(request, prefix + "del_ste_cd", length));
            String[] cntrCgoTp = (JSPUtil.getParameter(request, prefix + "cntr_cgo_tp", length));
            String[] yrdLocCd = (JSPUtil.getParameter(request, prefix + "yrd_loc_cd", length));
            String[] parContiCd = (JSPUtil.getParameter(request, prefix + "par_conti_cd", length));
            String[] bbDeTermCd = (JSPUtil.getParameter(request, prefix + "bb_de_term_cd", length));
            String[] delCntCd = (JSPUtil.getParameter(request, prefix + "del_cnt_cd", length));
            String[] delLocCd = (JSPUtil.getParameter(request, prefix + "del_loc_cd", length));
            String[] parSteCd = (JSPUtil.getParameter(request, prefix + "par_ste_cd", length));
            String[] actCustSeq = (JSPUtil.getParameter(request, prefix + "act_cust_seq", length));
            String[] efftDt = (JSPUtil.getParameter(request, prefix + "efft_dt", length));
            String[] bbRcvTermCd = (JSPUtil.getParameter(request, prefix + "bb_rcv_term_cd", length));
            String[] parRgnCd = (JSPUtil.getParameter(request, prefix + "par_rgn_cd", length));
            String[] ioBndCd = (JSPUtil.getParameter(request, prefix + "io_bnd_cd", length));
            String[] porLocCd = (JSPUtil.getParameter(request, prefix + "por_loc_cd", length));
            String[] polCntCd = (JSPUtil.getParameter(request, prefix + "pol_cnt_cd", length));
            String[] polContiCd = (JSPUtil.getParameter(request, prefix + "pol_conti_cd", length));
            String[] cntrTp = (JSPUtil.getParameter(request, prefix + "cntr_tp", length));
            String[] dttCode = (JSPUtil.getParameter(request, prefix + "dtt_code", length));
            String[] polLocCd = (JSPUtil.getParameter(request, prefix + "pol_loc_cd", length));
            String[] porSteCd = (JSPUtil.getParameter(request, prefix + "por_ste_cd", length));
            String[] yrdContiCd = (JSPUtil.getParameter(request, prefix + "yrd_conti_cd", length));
            String[] custCd = (JSPUtil.getParameter(request, prefix + "cust_cd", length));
            String[] delContiCd = (JSPUtil.getParameter(request, prefix + "del_conti_cd", length));
            String[] porRgnCd = (JSPUtil.getParameter(request, prefix + "por_rgn_cd", length));
            String[] cgoTp = (JSPUtil.getParameter(request, prefix + "cgo_tp", length));
            String[] parLocCd = (JSPUtil.getParameter(request, prefix + "par_loc_cd", length));
            String[] repCmdtCd = (JSPUtil.getParameter(request, prefix + "rep_cmdt_cd", length));
            String[] porContiCd = (JSPUtil.getParameter(request, prefix + "por_conti_cd", length));
            String[] awkInOut = (JSPUtil.getParameter(request, prefix + "awk_in_out", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new SCExceptionParmVO();
                if (delRgnCd[i] != null)
                    model.setDelRgnCd(delRgnCd[i]);
                if (yrdCntCd[i] != null)
                    model.setYrdCntCd(yrdCntCd[i]);
                if (cmdtTliNo[i] != null)
                    model.setCmdtTliNo(cmdtTliNo[i]);
                if (yrdRgnCd[i] != null)
                    model.setYrdRgnCd(yrdRgnCd[i]);
                if (parCntCd[i] != null)
                    model.setParCntCd(parCntCd[i]);
                if (polSteCd[i] != null)
                    model.setPolSteCd(polSteCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (cmdtCd[i] != null)
                    model.setCmdtCd(cmdtCd[i]);
                if (yrdSteCd[i] != null)
                    model.setYrdSteCd(yrdSteCd[i]);
                if (polRgnCd[i] != null)
                    model.setPolRgnCd(polRgnCd[i]);
                if (scNo[i] != null)
                    model.setScNo(scNo[i]);
                if (actCustCntCd[i] != null)
                    model.setActCustCntCd(actCustCntCd[i]);
                if (porCntCd[i] != null)
                    model.setPorCntCd(porCntCd[i]);
                if (custCntCd[i] != null)
                    model.setCustCntCd(custCntCd[i]);
                if (delSteCd[i] != null)
                    model.setDelSteCd(delSteCd[i]);
                if (cntrCgoTp[i] != null)
                    model.setCntrCgoTp(cntrCgoTp[i]);
                if (yrdLocCd[i] != null)
                    model.setYrdLocCd(yrdLocCd[i]);
                if (parContiCd[i] != null)
                    model.setParContiCd(parContiCd[i]);
                if (bbDeTermCd[i] != null)
                    model.setBbDeTermCd(bbDeTermCd[i]);
                if (delCntCd[i] != null)
                    model.setDelCntCd(delCntCd[i]);
                if (delLocCd[i] != null)
                    model.setDelLocCd(delLocCd[i]);
                if (parSteCd[i] != null)
                    model.setParSteCd(parSteCd[i]);
                if (actCustSeq[i] != null)
                    model.setActCustSeq(actCustSeq[i]);
                if (efftDt[i] != null)
                    model.setEfftDt(efftDt[i]);
                if (bbRcvTermCd[i] != null)
                    model.setBbRcvTermCd(bbRcvTermCd[i]);
                if (parRgnCd[i] != null)
                    model.setParRgnCd(parRgnCd[i]);
                if (ioBndCd[i] != null)
                    model.setIoBndCd(ioBndCd[i]);
                if (porLocCd[i] != null)
                    model.setPorLocCd(porLocCd[i]);
                if (polCntCd[i] != null)
                    model.setPolCntCd(polCntCd[i]);
                if (polContiCd[i] != null)
                    model.setPolContiCd(polContiCd[i]);
                if (cntrTp[i] != null)
                    model.setCntrTp(cntrTp[i]);
                if (dttCode[i] != null)
                    model.setDttCode(dttCode[i]);
                if (polLocCd[i] != null)
                    model.setPolLocCd(polLocCd[i]);
                if (porSteCd[i] != null)
                    model.setPorSteCd(porSteCd[i]);
                if (yrdContiCd[i] != null)
                    model.setYrdContiCd(yrdContiCd[i]);
                if (custCd[i] != null)
                    model.setCustCd(custCd[i]);
                if (delContiCd[i] != null)
                    model.setDelContiCd(delContiCd[i]);
                if (porRgnCd[i] != null)
                    model.setPorRgnCd(porRgnCd[i]);
                if (cgoTp[i] != null)
                    model.setCgoTp(cgoTp[i]);
                if (parLocCd[i] != null)
                    model.setParLocCd(parLocCd[i]);
                if (repCmdtCd[i] != null)
                    model.setRepCmdtCd(repCmdtCd[i]);
                if (porContiCd[i] != null)
                    model.setPorContiCd(porContiCd[i]);
                if (awkInOut[i] != null) 
		    		model.setAwkInOut(awkInOut[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getSCExceptionParmVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return SCExceptionParmVO[]
	 */
    public SCExceptionParmVO[] getSCExceptionParmVOs() {
        SCExceptionParmVO[] vos = (SCExceptionParmVO[]) models.toArray(new SCExceptionParmVO[models.size()]);
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
        this.delRgnCd = this.delRgnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.yrdCntCd = this.yrdCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtTliNo = this.cmdtTliNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.yrdRgnCd = this.yrdRgnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.parCntCd = this.parCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polSteCd = this.polSteCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtCd = this.cmdtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.yrdSteCd = this.yrdSteCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polRgnCd = this.polRgnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.scNo = this.scNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.actCustCntCd = this.actCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.porCntCd = this.porCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCntCd = this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delSteCd = this.delSteCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrCgoTp = this.cntrCgoTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.yrdLocCd = this.yrdLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.parContiCd = this.parContiCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bbDeTermCd = this.bbDeTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delCntCd = this.delCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delLocCd = this.delLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.parSteCd = this.parSteCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.actCustSeq = this.actCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.efftDt = this.efftDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bbRcvTermCd = this.bbRcvTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.parRgnCd = this.parRgnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ioBndCd = this.ioBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.porLocCd = this.porLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCntCd = this.polCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polContiCd = this.polContiCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrTp = this.cntrTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dttCode = this.dttCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polLocCd = this.polLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.porSteCd = this.porSteCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.yrdContiCd = this.yrdContiCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCd = this.custCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delContiCd = this.delContiCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.porRgnCd = this.porRgnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cgoTp = this.cgoTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.parLocCd = this.parLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.repCmdtCd = this.repCmdtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.porContiCd = this.porContiCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.awkInOut = this.awkInOut.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
