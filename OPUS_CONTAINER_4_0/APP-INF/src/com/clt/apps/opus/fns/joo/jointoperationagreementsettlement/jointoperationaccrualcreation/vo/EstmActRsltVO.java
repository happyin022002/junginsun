/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EstmActRsltVO.java
*@FileTitle : EstmActRsltVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.15
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.12.15 박희동 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo;

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
 * @author 박희동
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class EstmActRsltVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<EstmActRsltVO> models = new ArrayList<EstmActRsltVO>();

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String bsaQty = null;

    /* Column Info */
    private String estmVvdHdrId = null;

    /* Column Info */
    private String trdCd = null;

    /* Column Info */
    private String rlaneCd = null;

    /* Column Info */
    private String cntrBlkDivCd = null;

    /* Column Info */
    private String actAmt = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String revDirCd = null;

    /* Column Info */
    private String locCd = null;

    /* Column Info */
    private String ibflag = null;

    /* Column Info */
    private String acctCd = null;

    /* Column Info */
    private String joStlJbNm = null;

    /* Column Info */
    private String estmActSeq = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String custCntCd = null;

    /* Column Info */
    private String revYrmon = null;

    /* Column Info */
    private String exeYrmon = null;

    /* Column Info */
    private String vndrCustSeq = null;

    /* Column Info */
    private String skdVoyNo = null;

    /* Column Info */
    private String joCrrCd = null;

    /* Column Info */
    private String estmAmt = null;

    /* Column Info */
    private String acclAmtCorrFlg = null;

    /* Column Info */
    private String custSeq = null;

    /* Column Info */
    private String skdDirCd = null;

    /* Column Info */
    private String estmVvdTpCd = null;

    /* Column Info */
    private String vvd = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String diffAmt = null;

    /* Column Info */
    private String joCntrDivCtnt = null;

    /* Column Info */
    private String bsaSltPrc = null;

    /* Column Info */
    private String reDivrCd = null;

    /* Column Info */
    private String joIocDivCd = null;

    /* Column Info */
    private String acclAmt = null;

    /* Column Info */
    private String joStlJbCd = null;

    /* Column Info */
    private String sysSrcId = null;

    /* Column Info */
    private String actDt = null;

    /* Column Info */
    private String stDt = null;

    /* Column Info */
    private String endDt = null;

    /* Column Info */
    private String sailDys = null;

    /* Column Info */
    private String estmYrmon = null;

    /* Column Info */
    private String estmDys = null;

    /* Column Info */
    private String nowEstmAmt = null;

    /* Column Info */
    private String nowActAmt = null;

    /* Column Info */
    private String orgEstmAmt = null;

    /* Column Info */
    private String orgActAmt = null;

    /* Column Info */
    private String joStlItmCd = null;

    /* Column Info */
    private String grpNo = null;

    /* Column Info */
    private String minEstmYrmon = null;

    /* Column Info */
    private String maxEstmYrmon = null;

    /* Column Info */
    private String chkEditFlg = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public EstmActRsltVO() {
    }

    public EstmActRsltVO(String ibflag, String pagerows, String exeYrmon, String revYrmon, String joCrrCd, String trdCd, String vndrCustSeq, String custCntCd, String custSeq, String reDivrCd, String vvd, String vslCd, String skdVoyNo, String skdDirCd, String revDirCd, String rlaneCd, String joStlJbCd, String joStlJbNm, String bsaQty, String bsaSltPrc, String acctCd, String estmAmt, String actAmt, String acclAmt, String diffAmt, String estmVvdTpCd, String joIocDivCd, String estmVvdHdrId, String cntrBlkDivCd, String sysSrcId, String locCd, String joCntrDivCtnt, String acclAmtCorrFlg, String creUsrId, String updUsrId, String estmActSeq, String actDt, String stDt, String endDt, String sailDys, String estmYrmon, String estmDys, String nowEstmAmt, String nowActAmt, String orgEstmAmt, String orgActAmt, String joStlItmCd, String grpNo, String minEstmYrmon, String maxEstmYrmon, String chkEditFlg) {
        this.vslCd = vslCd;
        this.bsaQty = bsaQty;
        this.estmVvdHdrId = estmVvdHdrId;
        this.trdCd = trdCd;
        this.rlaneCd = rlaneCd;
        this.cntrBlkDivCd = cntrBlkDivCd;
        this.actAmt = actAmt;
        this.pagerows = pagerows;
        this.revDirCd = revDirCd;
        this.locCd = locCd;
        this.ibflag = ibflag;
        this.acctCd = acctCd;
        this.joStlJbNm = joStlJbNm;
        this.estmActSeq = estmActSeq;
        this.updUsrId = updUsrId;
        this.custCntCd = custCntCd;
        this.revYrmon = revYrmon;
        this.exeYrmon = exeYrmon;
        this.vndrCustSeq = vndrCustSeq;
        this.skdVoyNo = skdVoyNo;
        this.joCrrCd = joCrrCd;
        this.estmAmt = estmAmt;
        this.acclAmtCorrFlg = acclAmtCorrFlg;
        this.custSeq = custSeq;
        this.skdDirCd = skdDirCd;
        this.estmVvdTpCd = estmVvdTpCd;
        this.vvd = vvd;
        this.creUsrId = creUsrId;
        this.diffAmt = diffAmt;
        this.joCntrDivCtnt = joCntrDivCtnt;
        this.bsaSltPrc = bsaSltPrc;
        this.reDivrCd = reDivrCd;
        this.joIocDivCd = joIocDivCd;
        this.acclAmt = acclAmt;
        this.joStlJbCd = joStlJbCd;
        this.sysSrcId = sysSrcId;
        this.actDt = actDt;
        this.stDt = stDt;
        this.endDt = endDt;
        this.sailDys = sailDys;
        this.estmYrmon = estmYrmon;
        this.estmDys = estmDys;
        this.nowEstmAmt = nowEstmAmt;
        this.nowActAmt = nowActAmt;
        this.orgEstmAmt = orgEstmAmt;
        this.orgActAmt = orgActAmt;
        this.joStlItmCd = joStlItmCd;
        this.grpNo = grpNo;
        this.minEstmYrmon = minEstmYrmon;
        this.maxEstmYrmon = maxEstmYrmon;
        this.chkEditFlg = chkEditFlg;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("bsa_qty", getBsaQty());
        this.hashColumns.put("estm_vvd_hdr_id", getEstmVvdHdrId());
        this.hashColumns.put("trd_cd", getTrdCd());
        this.hashColumns.put("rlane_cd", getRlaneCd());
        this.hashColumns.put("cntr_blk_div_cd", getCntrBlkDivCd());
        this.hashColumns.put("act_amt", getActAmt());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("rev_dir_cd", getRevDirCd());
        this.hashColumns.put("loc_cd", getLocCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("acct_cd", getAcctCd());
        this.hashColumns.put("jo_stl_jb_nm", getJoStlJbNm());
        this.hashColumns.put("estm_act_seq", getEstmActSeq());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("cust_cnt_cd", getCustCntCd());
        this.hashColumns.put("rev_yrmon", getRevYrmon());
        this.hashColumns.put("exe_yrmon", getExeYrmon());
        this.hashColumns.put("vndr_cust_seq", getVndrCustSeq());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("jo_crr_cd", getJoCrrCd());
        this.hashColumns.put("estm_amt", getEstmAmt());
        this.hashColumns.put("accl_amt_corr_flg", getAcclAmtCorrFlg());
        this.hashColumns.put("cust_seq", getCustSeq());
        this.hashColumns.put("skd_dir_cd", getSkdDirCd());
        this.hashColumns.put("estm_vvd_tp_cd", getEstmVvdTpCd());
        this.hashColumns.put("vvd", getVvd());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("diff_amt", getDiffAmt());
        this.hashColumns.put("jo_cntr_div_ctnt", getJoCntrDivCtnt());
        this.hashColumns.put("bsa_slt_prc", getBsaSltPrc());
        this.hashColumns.put("re_divr_cd", getReDivrCd());
        this.hashColumns.put("jo_ioc_div_cd", getJoIocDivCd());
        this.hashColumns.put("accl_amt", getAcclAmt());
        this.hashColumns.put("jo_stl_jb_cd", getJoStlJbCd());
        this.hashColumns.put("sys_src_id", getSysSrcId());
        this.hashColumns.put("act_dt", getActDt());
        this.hashColumns.put("st_dt", getStDt());
        this.hashColumns.put("end_dt", getEndDt());
        this.hashColumns.put("sail_dys", getSailDys());
        this.hashColumns.put("estm_yrmon", getEstmYrmon());
        this.hashColumns.put("estm_dys", getEstmDys());
        this.hashColumns.put("now_estm_amt", getNowEstmAmt());
        this.hashColumns.put("now_act_amt", getNowActAmt());
        this.hashColumns.put("org_estm_amt", getOrgEstmAmt());
        this.hashColumns.put("org_act_amt", getOrgActAmt());
        this.hashColumns.put("jo_stl_itm_cd", getJoStlItmCd());
        this.hashColumns.put("grp_no", getGrpNo());
        this.hashColumns.put("min_estm_yrmon", getMinEstmYrmon());
        this.hashColumns.put("max_estm_yrmon", getMaxEstmYrmon());
        this.hashColumns.put("chk_edit_flg", getChkEditFlg());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("bsa_qty", "bsaQty");
        this.hashFields.put("estm_vvd_hdr_id", "estmVvdHdrId");
        this.hashFields.put("trd_cd", "trdCd");
        this.hashFields.put("rlane_cd", "rlaneCd");
        this.hashFields.put("cntr_blk_div_cd", "cntrBlkDivCd");
        this.hashFields.put("act_amt", "actAmt");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("rev_dir_cd", "revDirCd");
        this.hashFields.put("loc_cd", "locCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("acct_cd", "acctCd");
        this.hashFields.put("jo_stl_jb_nm", "joStlJbNm");
        this.hashFields.put("estm_act_seq", "estmActSeq");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("cust_cnt_cd", "custCntCd");
        this.hashFields.put("rev_yrmon", "revYrmon");
        this.hashFields.put("exe_yrmon", "exeYrmon");
        this.hashFields.put("vndr_cust_seq", "vndrCustSeq");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("jo_crr_cd", "joCrrCd");
        this.hashFields.put("estm_amt", "estmAmt");
        this.hashFields.put("accl_amt_corr_flg", "acclAmtCorrFlg");
        this.hashFields.put("cust_seq", "custSeq");
        this.hashFields.put("skd_dir_cd", "skdDirCd");
        this.hashFields.put("estm_vvd_tp_cd", "estmVvdTpCd");
        this.hashFields.put("vvd", "vvd");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("diff_amt", "diffAmt");
        this.hashFields.put("jo_cntr_div_ctnt", "joCntrDivCtnt");
        this.hashFields.put("bsa_slt_prc", "bsaSltPrc");
        this.hashFields.put("re_divr_cd", "reDivrCd");
        this.hashFields.put("jo_ioc_div_cd", "joIocDivCd");
        this.hashFields.put("accl_amt", "acclAmt");
        this.hashFields.put("jo_stl_jb_cd", "joStlJbCd");
        this.hashFields.put("sys_src_id", "sysSrcId");
        this.hashFields.put("act_dt", "actDt");
        this.hashFields.put("st_dt", "stDt");
        this.hashFields.put("end_dt", "endDt");
        this.hashFields.put("sail_dys", "sailDys");
        this.hashFields.put("estm_yrmon", "estmYrmon");
        this.hashFields.put("estm_dys", "estmDys");
        this.hashFields.put("now_estm_amt", "nowEstmAmt");
        this.hashFields.put("now_act_amt", "nowActAmt");
        this.hashFields.put("org_estm_amt", "orgEstmAmt");
        this.hashFields.put("org_act_amt", "orgActAmt");
        this.hashFields.put("jo_stl_itm_cd", "joStlItmCd");
        this.hashFields.put("grp_no", "grpNo");
        this.hashFields.put("min_estm_yrmon", "minEstmYrmon");
        this.hashFields.put("max_estm_yrmon", "maxEstmYrmon");
        this.hashFields.put("chk_edit_flg", "chkEditFlg");
        return this.hashFields;
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
	 * @return bsaQty
	 */
    public String getBsaQty() {
        return this.bsaQty;
    }

    /**
	 * Column Info
	 * @return estmVvdHdrId
	 */
    public String getEstmVvdHdrId() {
        return this.estmVvdHdrId;
    }

    /**
	 * Column Info
	 * @return trdCd
	 */
    public String getTrdCd() {
        return this.trdCd;
    }

    /**
	 * Column Info
	 * @return rlaneCd
	 */
    public String getRlaneCd() {
        return this.rlaneCd;
    }

    /**
	 * Column Info
	 * @return cntrBlkDivCd
	 */
    public String getCntrBlkDivCd() {
        return this.cntrBlkDivCd;
    }

    /**
	 * Column Info
	 * @return actAmt
	 */
    public String getActAmt() {
        return this.actAmt;
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
	 * @return revDirCd
	 */
    public String getRevDirCd() {
        return this.revDirCd;
    }

    /**
	 * Column Info
	 * @return locCd
	 */
    public String getLocCd() {
        return this.locCd;
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
	 * @return acctCd
	 */
    public String getAcctCd() {
        return this.acctCd;
    }

    /**
	 * Column Info
	 * @return joStlJbNm
	 */
    public String getJoStlJbNm() {
        return this.joStlJbNm;
    }

    /**
	 * Column Info
	 * @return estmActSeq
	 */
    public String getEstmActSeq() {
        return this.estmActSeq;
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
	 * @return custCntCd
	 */
    public String getCustCntCd() {
        return this.custCntCd;
    }

    /**
	 * Column Info
	 * @return revYrmon
	 */
    public String getRevYrmon() {
        return this.revYrmon;
    }

    /**
	 * Column Info
	 * @return exeYrmon
	 */
    public String getExeYrmon() {
        return this.exeYrmon;
    }

    /**
	 * Column Info
	 * @return vndrCustSeq
	 */
    public String getVndrCustSeq() {
        return this.vndrCustSeq;
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
	 * @return joCrrCd
	 */
    public String getJoCrrCd() {
        return this.joCrrCd;
    }

    /**
	 * Column Info
	 * @return estmAmt
	 */
    public String getEstmAmt() {
        return this.estmAmt;
    }

    /**
	 * Column Info
	 * @return acclAmtCorrFlg
	 */
    public String getAcclAmtCorrFlg() {
        return this.acclAmtCorrFlg;
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
	 * @return skdDirCd
	 */
    public String getSkdDirCd() {
        return this.skdDirCd;
    }

    /**
	 * Column Info
	 * @return estmVvdTpCd
	 */
    public String getEstmVvdTpCd() {
        return this.estmVvdTpCd;
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
	 * @return creUsrId
	 */
    public String getCreUsrId() {
        return this.creUsrId;
    }

    /**
	 * Column Info
	 * @return diffAmt
	 */
    public String getDiffAmt() {
        return this.diffAmt;
    }

    /**
	 * Column Info
	 * @return joCntrDivCtnt
	 */
    public String getJoCntrDivCtnt() {
        return this.joCntrDivCtnt;
    }

    /**
	 * Column Info
	 * @return bsaSltPrc
	 */
    public String getBsaSltPrc() {
        return this.bsaSltPrc;
    }

    /**
	 * Column Info
	 * @return reDivrCd
	 */
    public String getReDivrCd() {
        return this.reDivrCd;
    }

    /**
	 * Column Info
	 * @return joIocDivCd
	 */
    public String getJoIocDivCd() {
        return this.joIocDivCd;
    }

    /**
	 * Column Info
	 * @return acclAmt
	 */
    public String getAcclAmt() {
        return this.acclAmt;
    }

    /**
	 * Column Info
	 * @return joStlJbCd
	 */
    public String getJoStlJbCd() {
        return this.joStlJbCd;
    }

    /**
	 * Column Info
	 * @return sysSrcId
	 */
    public String getSysSrcId() {
        return this.sysSrcId;
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
	 * @param bsaQty
	 */
    public void setBsaQty(String bsaQty) {
        this.bsaQty = bsaQty;
    }

    /**
	 * Column Info
	 * @param estmVvdHdrId
	 */
    public void setEstmVvdHdrId(String estmVvdHdrId) {
        this.estmVvdHdrId = estmVvdHdrId;
    }

    /**
	 * Column Info
	 * @param trdCd
	 */
    public void setTrdCd(String trdCd) {
        this.trdCd = trdCd;
    }

    /**
	 * Column Info
	 * @param rlaneCd
	 */
    public void setRlaneCd(String rlaneCd) {
        this.rlaneCd = rlaneCd;
    }

    /**
	 * Column Info
	 * @param cntrBlkDivCd
	 */
    public void setCntrBlkDivCd(String cntrBlkDivCd) {
        this.cntrBlkDivCd = cntrBlkDivCd;
    }

    /**
	 * Column Info
	 * @param actAmt
	 */
    public void setActAmt(String actAmt) {
        this.actAmt = actAmt;
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
	 * @param revDirCd
	 */
    public void setRevDirCd(String revDirCd) {
        this.revDirCd = revDirCd;
    }

    /**
	 * Column Info
	 * @param locCd
	 */
    public void setLocCd(String locCd) {
        this.locCd = locCd;
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
	 * @param acctCd
	 */
    public void setAcctCd(String acctCd) {
        this.acctCd = acctCd;
    }

    /**
	 * Column Info
	 * @param joStlJbNm
	 */
    public void setJoStlJbNm(String joStlJbNm) {
        this.joStlJbNm = joStlJbNm;
    }

    /**
	 * Column Info
	 * @param estmActSeq
	 */
    public void setEstmActSeq(String estmActSeq) {
        this.estmActSeq = estmActSeq;
    }

    /**
	 * Column Info
	 * @param updUsrId
	 */
    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
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
	 * @param revYrmon
	 */
    public void setRevYrmon(String revYrmon) {
        this.revYrmon = revYrmon;
    }

    /**
	 * Column Info
	 * @param exeYrmon
	 */
    public void setExeYrmon(String exeYrmon) {
        this.exeYrmon = exeYrmon;
    }

    /**
	 * Column Info
	 * @param vndrCustSeq
	 */
    public void setVndrCustSeq(String vndrCustSeq) {
        this.vndrCustSeq = vndrCustSeq;
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
	 * @param joCrrCd
	 */
    public void setJoCrrCd(String joCrrCd) {
        this.joCrrCd = joCrrCd;
    }

    /**
	 * Column Info
	 * @param estmAmt
	 */
    public void setEstmAmt(String estmAmt) {
        this.estmAmt = estmAmt;
    }

    /**
	 * Column Info
	 * @param acclAmtCorrFlg
	 */
    public void setAcclAmtCorrFlg(String acclAmtCorrFlg) {
        this.acclAmtCorrFlg = acclAmtCorrFlg;
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
	 * @param skdDirCd
	 */
    public void setSkdDirCd(String skdDirCd) {
        this.skdDirCd = skdDirCd;
    }

    /**
	 * Column Info
	 * @param estmVvdTpCd
	 */
    public void setEstmVvdTpCd(String estmVvdTpCd) {
        this.estmVvdTpCd = estmVvdTpCd;
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
	 * @param creUsrId
	 */
    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
    }

    /**
	 * Column Info
	 * @param diffAmt
	 */
    public void setDiffAmt(String diffAmt) {
        this.diffAmt = diffAmt;
    }

    /**
	 * Column Info
	 * @param joCntrDivCtnt
	 */
    public void setJoCntrDivCtnt(String joCntrDivCtnt) {
        this.joCntrDivCtnt = joCntrDivCtnt;
    }

    /**
	 * Column Info
	 * @param bsaSltPrc
	 */
    public void setBsaSltPrc(String bsaSltPrc) {
        this.bsaSltPrc = bsaSltPrc;
    }

    /**
	 * Column Info
	 * @param reDivrCd
	 */
    public void setReDivrCd(String reDivrCd) {
        this.reDivrCd = reDivrCd;
    }

    /**
	 * Column Info
	 * @param joIocDivCd
	 */
    public void setJoIocDivCd(String joIocDivCd) {
        this.joIocDivCd = joIocDivCd;
    }

    /**
	 * Column Info
	 * @param acclAmt
	 */
    public void setAcclAmt(String acclAmt) {
        this.acclAmt = acclAmt;
    }

    /**
	 * Column Info
	 * @param joStlJbCd
	 */
    public void setJoStlJbCd(String joStlJbCd) {
        this.joStlJbCd = joStlJbCd;
    }

    /**
	 * Column Info
	 * @param sysSrcId
	 */
    public void setSysSrcId(String sysSrcId) {
        this.sysSrcId = sysSrcId;
    }

    public void setActDt(String actDt) {
        this.actDt = actDt;
    }

    public String getActDt() {
        return this.actDt;
    }

    public void setStDt(String stDt) {
        this.stDt = stDt;
    }

    public String getStDt() {
        return this.stDt;
    }

    public void setEndDt(String endDt) {
        this.endDt = endDt;
    }

    public String getEndDt() {
        return this.endDt;
    }

    public void setSailDys(String sailDys) {
        this.sailDys = sailDys;
    }

    public String getSailDys() {
        return this.sailDys;
    }

    public void setEstmYrmon(String estmYrmon) {
        this.estmYrmon = estmYrmon;
    }

    public String getEstmYrmon() {
        return this.estmYrmon;
    }

    public void setEstmDys(String estmDys) {
        this.estmDys = estmDys;
    }

    public String getEstmDys() {
        return this.estmDys;
    }

    public void setNowEstmAmt(String nowEstmAmt) {
        this.nowEstmAmt = nowEstmAmt;
    }

    public String getNowEstmAmt() {
        return this.nowEstmAmt;
    }

    public void setNowActAmt(String nowActAmt) {
        this.nowActAmt = nowActAmt;
    }

    public String getNowActAmt() {
        return this.nowActAmt;
    }

    public void setOrgEstmAmt(String orgEstmAmt) {
        this.orgEstmAmt = orgEstmAmt;
    }

    public String getOrgEstmAmt() {
        return this.orgEstmAmt;
    }

    public void setOrgActAmt(String orgActAmt) {
        this.orgActAmt = orgActAmt;
    }

    public String getOrgActAmt() {
        return this.orgActAmt;
    }

    public void setJoStlItmCd(String joStlItmCd) {
        this.joStlItmCd = joStlItmCd;
    }

    public String getJoStlItmCd() {
        return this.joStlItmCd;
    }

    public void setGrpNo(String grpNo) {
        this.grpNo = grpNo;
    }

    public String getGrpNo() {
        return this.grpNo;
    }

    public void setMinEstmYrmon(String minEstmYrmon) {
        this.minEstmYrmon = minEstmYrmon;
    }

    public String getMinEstmYrmon() {
        return this.minEstmYrmon;
    }

    public void setMaxEstmYrmon(String maxEstmYrmon) {
        this.maxEstmYrmon = maxEstmYrmon;
    }

    public String getMaxEstmYrmon() {
        return this.maxEstmYrmon;
    }

    public void setChkEditFlg(String chkEditFlg) {
        this.chkEditFlg = chkEditFlg;
    }

    public String getChkEditFlg() {
        return this.chkEditFlg;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
        setBsaQty(JSPUtil.getParameter(request, "bsa_qty", ""));
        setEstmVvdHdrId(JSPUtil.getParameter(request, "estm_vvd_hdr_id", ""));
        setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
        setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
        setCntrBlkDivCd(JSPUtil.getParameter(request, "cntr_blk_div_cd", ""));
        setActAmt(JSPUtil.getParameter(request, "act_amt", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setRevDirCd(JSPUtil.getParameter(request, "rev_dir_cd", ""));
        setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
        setJoStlJbNm(JSPUtil.getParameter(request, "jo_stl_jb_nm", ""));
        setEstmActSeq(JSPUtil.getParameter(request, "estm_act_seq", ""));
        setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
        setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
        setRevYrmon(JSPUtil.getParameter(request, "rev_yrmon", ""));
        setExeYrmon(JSPUtil.getParameter(request, "exe_yrmon", ""));
        setVndrCustSeq(JSPUtil.getParameter(request, "vndr_cust_seq", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
        setJoCrrCd(JSPUtil.getParameter(request, "jo_crr_cd", ""));
        setEstmAmt(JSPUtil.getParameter(request, "estm_amt", ""));
        setAcclAmtCorrFlg(JSPUtil.getParameter(request, "accl_amt_corr_flg", ""));
        setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
        setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
        setEstmVvdTpCd(JSPUtil.getParameter(request, "estm_vvd_tp_cd", ""));
        setVvd(JSPUtil.getParameter(request, "vvd", ""));
        setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
        setDiffAmt(JSPUtil.getParameter(request, "diff_amt", ""));
        setJoCntrDivCtnt(JSPUtil.getParameter(request, "jo_cntr_div_ctnt", ""));
        setBsaSltPrc(JSPUtil.getParameter(request, "bsa_slt_prc", ""));
        setReDivrCd(JSPUtil.getParameter(request, "re_divr_cd", ""));
        setJoIocDivCd(JSPUtil.getParameter(request, "jo_ioc_div_cd", ""));
        setAcclAmt(JSPUtil.getParameter(request, "accl_amt", ""));
        setJoStlJbCd(JSPUtil.getParameter(request, "jo_stl_jb_cd", ""));
        setSysSrcId(JSPUtil.getParameter(request, "sys_src_id", ""));
        setActDt(JSPUtil.getParameter(request, "act_dt", ""));
        setStDt(JSPUtil.getParameter(request, "st_dt", ""));
        setEndDt(JSPUtil.getParameter(request, "end_dt", ""));
        setSailDys(JSPUtil.getParameter(request, "sail_dys", ""));
        setEstmYrmon(JSPUtil.getParameter(request, "estm_yrmon", ""));
        setEstmDys(JSPUtil.getParameter(request, "estm_dys", ""));
        setNowEstmAmt(JSPUtil.getParameter(request, "now_estm_amt", ""));
        setNowActAmt(JSPUtil.getParameter(request, "now_act_amt", ""));
        setOrgEstmAmt(JSPUtil.getParameter(request, "org_estm_amt", ""));
        setOrgActAmt(JSPUtil.getParameter(request, "org_act_amt", ""));
        setJoStlItmCd(JSPUtil.getParameter(request, "jo_stl_itm_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EstmActRsltVO[]
	 */
    public EstmActRsltVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EstmActRsltVO[]
	 */
    public EstmActRsltVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        EstmActRsltVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] bsaQty = (JSPUtil.getParameter(request, prefix + "bsa_qty", length));
            String[] estmVvdHdrId = (JSPUtil.getParameter(request, prefix + "estm_vvd_hdr_id", length));
            String[] trdCd = (JSPUtil.getParameter(request, prefix + "trd_cd", length));
            String[] rlaneCd = (JSPUtil.getParameter(request, prefix + "rlane_cd", length));
            String[] cntrBlkDivCd = (JSPUtil.getParameter(request, prefix + "cntr_blk_div_cd", length));
            String[] actAmt = (JSPUtil.getParameter(request, prefix + "act_amt", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] revDirCd = (JSPUtil.getParameter(request, prefix + "rev_dir_cd", length));
            String[] locCd = (JSPUtil.getParameter(request, prefix + "loc_cd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] acctCd = (JSPUtil.getParameter(request, prefix + "acct_cd", length));
            String[] joStlJbNm = (JSPUtil.getParameter(request, prefix + "jo_stl_jb_nm", length));
            String[] estmActSeq = (JSPUtil.getParameter(request, prefix + "estm_act_seq", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] custCntCd = (JSPUtil.getParameter(request, prefix + "cust_cnt_cd", length));
            String[] revYrmon = (JSPUtil.getParameter(request, prefix + "rev_yrmon", length));
            String[] exeYrmon = (JSPUtil.getParameter(request, prefix + "exe_yrmon", length));
            String[] vndrCustSeq = (JSPUtil.getParameter(request, prefix + "vndr_cust_seq", length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
            String[] joCrrCd = (JSPUtil.getParameter(request, prefix + "jo_crr_cd", length));
            String[] estmAmt = (JSPUtil.getParameter(request, prefix + "estm_amt", length));
            String[] acclAmtCorrFlg = (JSPUtil.getParameter(request, prefix + "accl_amt_corr_flg", length));
            String[] custSeq = (JSPUtil.getParameter(request, prefix + "cust_seq", length));
            String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
            String[] estmVvdTpCd = (JSPUtil.getParameter(request, prefix + "estm_vvd_tp_cd", length));
            String[] vvd = (JSPUtil.getParameter(request, prefix + "vvd", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] diffAmt = (JSPUtil.getParameter(request, prefix + "diff_amt", length));
            String[] joCntrDivCtnt = (JSPUtil.getParameter(request, prefix + "jo_cntr_div_ctnt", length));
            String[] bsaSltPrc = (JSPUtil.getParameter(request, prefix + "bsa_slt_prc", length));
            String[] reDivrCd = (JSPUtil.getParameter(request, prefix + "re_divr_cd", length));
            String[] joIocDivCd = (JSPUtil.getParameter(request, prefix + "jo_ioc_div_cd", length));
            String[] acclAmt = (JSPUtil.getParameter(request, prefix + "accl_amt", length));
            String[] joStlJbCd = (JSPUtil.getParameter(request, prefix + "jo_stl_jb_cd", length));
            String[] sysSrcId = (JSPUtil.getParameter(request, prefix + "sys_src_id", length));
            String[] actDt = (JSPUtil.getParameter(request, prefix + "act_dt", length));
            String[] stDt = (JSPUtil.getParameter(request, prefix + "st_dt", length));
            String[] endDt = (JSPUtil.getParameter(request, prefix + "end_dt", length));
            String[] sailDys = (JSPUtil.getParameter(request, prefix + "sail_dys", length));
            String[] estmYrmon = (JSPUtil.getParameter(request, prefix + "estm_yrmon", length));
            String[] estmDys = (JSPUtil.getParameter(request, prefix + "estm_dys", length));
            String[] nowEstmAmt = (JSPUtil.getParameter(request, prefix + "now_estm_amt", length));
            String[] nowActAmt = (JSPUtil.getParameter(request, prefix + "now_act_amt", length));
            String[] orgEstmAmt = (JSPUtil.getParameter(request, prefix + "org_estm_amt", length));
            String[] orgActAmt = (JSPUtil.getParameter(request, prefix + "org_act_amt", length));
            String[] joStlItmCd = (JSPUtil.getParameter(request, prefix + "jo_stl_itm_cd", length));
            String[] grpNo = (JSPUtil.getParameter(request, prefix + "grp_no", length));
            String[] minEstmYrmon = (JSPUtil.getParameter(request, prefix + "min_estm_yrmon", length));
            String[] maxEstmYrmon = (JSPUtil.getParameter(request, prefix + "max_estm_yrmon", length));
            String[] chkEditFlg = (JSPUtil.getParameter(request, prefix + "chk_edit_flg", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new EstmActRsltVO();
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (bsaQty[i] != null)
                    model.setBsaQty(bsaQty[i]);
                if (estmVvdHdrId[i] != null)
                    model.setEstmVvdHdrId(estmVvdHdrId[i]);
                if (trdCd[i] != null)
                    model.setTrdCd(trdCd[i]);
                if (rlaneCd[i] != null)
                    model.setRlaneCd(rlaneCd[i]);
                if (cntrBlkDivCd[i] != null)
                    model.setCntrBlkDivCd(cntrBlkDivCd[i]);
                if (actAmt[i] != null)
                    model.setActAmt(actAmt[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (revDirCd[i] != null)
                    model.setRevDirCd(revDirCd[i]);
                if (locCd[i] != null)
                    model.setLocCd(locCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (acctCd[i] != null)
                    model.setAcctCd(acctCd[i]);
                if (joStlJbNm[i] != null)
                    model.setJoStlJbNm(joStlJbNm[i]);
                if (estmActSeq[i] != null)
                    model.setEstmActSeq(estmActSeq[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (custCntCd[i] != null)
                    model.setCustCntCd(custCntCd[i]);
                if (revYrmon[i] != null)
                    model.setRevYrmon(revYrmon[i]);
                if (exeYrmon[i] != null)
                    model.setExeYrmon(exeYrmon[i]);
                if (vndrCustSeq[i] != null)
                    model.setVndrCustSeq(vndrCustSeq[i]);
                if (skdVoyNo[i] != null)
                    model.setSkdVoyNo(skdVoyNo[i]);
                if (joCrrCd[i] != null)
                    model.setJoCrrCd(joCrrCd[i]);
                if (estmAmt[i] != null)
                    model.setEstmAmt(estmAmt[i]);
                if (acclAmtCorrFlg[i] != null)
                    model.setAcclAmtCorrFlg(acclAmtCorrFlg[i]);
                if (custSeq[i] != null)
                    model.setCustSeq(custSeq[i]);
                if (skdDirCd[i] != null)
                    model.setSkdDirCd(skdDirCd[i]);
                if (estmVvdTpCd[i] != null)
                    model.setEstmVvdTpCd(estmVvdTpCd[i]);
                if (vvd[i] != null)
                    model.setVvd(vvd[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (diffAmt[i] != null)
                    model.setDiffAmt(diffAmt[i]);
                if (joCntrDivCtnt[i] != null)
                    model.setJoCntrDivCtnt(joCntrDivCtnt[i]);
                if (bsaSltPrc[i] != null)
                    model.setBsaSltPrc(bsaSltPrc[i]);
                if (reDivrCd[i] != null)
                    model.setReDivrCd(reDivrCd[i]);
                if (joIocDivCd[i] != null)
                    model.setJoIocDivCd(joIocDivCd[i]);
                if (acclAmt[i] != null)
                    model.setAcclAmt(acclAmt[i]);
                if (joStlJbCd[i] != null)
                    model.setJoStlJbCd(joStlJbCd[i]);
                if (sysSrcId[i] != null)
                    model.setSysSrcId(sysSrcId[i]);
                if (actDt[i] != null)
                    model.setActDt(actDt[i]);
                if (stDt[i] != null)
                    model.setStDt(stDt[i]);
                if (endDt[i] != null)
                    model.setEndDt(endDt[i]);
                if (sailDys[i] != null)
                    model.setSailDys(sailDys[i]);
                if (estmYrmon[i] != null)
                    model.setEstmYrmon(estmYrmon[i]);
                if (estmDys[i] != null)
                    model.setEstmDys(estmDys[i]);
                if (nowEstmAmt[i] != null)
                    model.setNowEstmAmt(nowEstmAmt[i]);
                if (nowActAmt[i] != null)
                    model.setNowActAmt(nowActAmt[i]);
                if (orgEstmAmt[i] != null)
                    model.setOrgEstmAmt(orgEstmAmt[i]);
                if (orgActAmt[i] != null)
                    model.setOrgActAmt(orgActAmt[i]);
                if (joStlItmCd[i] != null)
                    model.setJoStlItmCd(joStlItmCd[i]);
                if (grpNo[i] != null)
                    model.setGrpNo(grpNo[i]);
                if (minEstmYrmon[i] != null)
                    model.setMinEstmYrmon(minEstmYrmon[i]);
                if (maxEstmYrmon[i] != null)
                    model.setMaxEstmYrmon(maxEstmYrmon[i]);
                if (chkEditFlg[i] != null) 
		    		model.setChkEditFlg(chkEditFlg[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getEstmActRsltVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return EstmActRsltVO[]
	 */
    public EstmActRsltVO[] getEstmActRsltVOs() {
        EstmActRsltVO[] vos = (EstmActRsltVO[]) models.toArray(new EstmActRsltVO[models.size()]);
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
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bsaQty = this.bsaQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.estmVvdHdrId = this.estmVvdHdrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trdCd = this.trdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rlaneCd = this.rlaneCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrBlkDivCd = this.cntrBlkDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.actAmt = this.actAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.revDirCd = this.revDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.locCd = this.locCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acctCd = this.acctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.joStlJbNm = this.joStlJbNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.estmActSeq = this.estmActSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCntCd = this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.revYrmon = this.revYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.exeYrmon = this.exeYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrCustSeq = this.vndrCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.joCrrCd = this.joCrrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.estmAmt = this.estmAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acclAmtCorrFlg = this.acclAmtCorrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custSeq = this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.estmVvdTpCd = this.estmVvdTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvd = this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.diffAmt = this.diffAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.joCntrDivCtnt = this.joCntrDivCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bsaSltPrc = this.bsaSltPrc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.reDivrCd = this.reDivrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.joIocDivCd = this.joIocDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acclAmt = this.acclAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.joStlJbCd = this.joStlJbCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sysSrcId = this.sysSrcId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.actDt = this.actDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stDt = this.stDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.endDt = this.endDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sailDys = this.sailDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.estmYrmon = this.estmYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.estmDys = this.estmDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nowEstmAmt = this.nowEstmAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nowActAmt = this.nowActAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orgEstmAmt = this.orgEstmAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orgActAmt = this.orgActAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.joStlItmCd = this.joStlItmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.grpNo = this.grpNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.minEstmYrmon = this.minEstmYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.maxEstmYrmon = this.maxEstmYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chkEditFlg = this.chkEditFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
