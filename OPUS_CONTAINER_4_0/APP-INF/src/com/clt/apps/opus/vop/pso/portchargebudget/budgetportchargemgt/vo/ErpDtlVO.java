/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ErpDtlVO.java
*@FileTitle : ErpDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.08.03 김진일 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김진일
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class ErpDtlVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<ErpDtlVO> models = new ArrayList<ErpDtlVO>();

    /* Column Info */
    private String port = null;

    /* Column Info */
    private String sdt = null;

    /* Column Info */
    private String revYrmon = null;

    /* Column Info */
    private String exeYrmon = null;

    /* Column Info */
    private String estmAmt = null;

    /* Column Info */
    private String actAmt = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String creUsrId = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String acctCd = null;

    /* Column Info */
    private String edt = null;

    /* Column Info */
    private String estmSeqNo = null;

    /* Column Info */
    private String acclAmt = null;

    /* Column Info */
    private String revVvd = null;

    /* Column Info */
    private String matchFlag = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String sysSrcId = null;

    /* Column Info */
    private String revLane = null;

    /* Column Info */
    private String costCd = null;

    /* Column Info */
    private String costNm = null;

    /* Column Info */
    private String loclCurrCd = null;

    /* Column Info */
    private String actDt = null;

    /* Column Info */
    private String contiCd = null;

    /* Column Info */
    private String contiCds = null;

    /* Column Info */
    private String acctCds = null;

    /* Column Info */
    private String clptIndSeq = null;

    /* Column Info */
    private String clptSeq = null;

    /* Column Info */
    private String updFlg = null;

    /* Column Info */
    private String updDt = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public ErpDtlVO() {
    }

    public ErpDtlVO(String ibflag, String pagerows, String exeYrmon, String sysSrcId, String revYrmon, String acctCd, String estmSeqNo, String revLane, String port, String revVvd, String estmAmt, String actAmt, String acclAmt, String creUsrId, String updUsrId, String sdt, String edt, String matchFlag, String costCd, String costNm, String loclCurrCd, String actDt, String contiCd, String contiCds, String acctCds, String clptIndSeq, String clptSeq, String updFlg, String updDt) {
        this.port = port;
        this.sdt = sdt;
        this.revYrmon = revYrmon;
        this.exeYrmon = exeYrmon;
        this.estmAmt = estmAmt;
        this.actAmt = actAmt;
        this.pagerows = pagerows;
        this.creUsrId = creUsrId;
        this.ibflag = ibflag;
        this.acctCd = acctCd;
        this.edt = edt;
        this.estmSeqNo = estmSeqNo;
        this.acclAmt = acclAmt;
        this.revVvd = revVvd;
        this.matchFlag = matchFlag;
        this.updUsrId = updUsrId;
        this.sysSrcId = sysSrcId;
        this.revLane = revLane;
        this.costCd = costCd;
        this.costNm = costNm;
        this.loclCurrCd = loclCurrCd;
        this.actDt = actDt;
        this.contiCd = contiCd;
        this.contiCds = contiCds;
        this.acctCds = acctCds;
        this.clptIndSeq = clptIndSeq;
        this.clptSeq = clptSeq;
        this.updFlg = updFlg;
        this.updDt = updDt;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("port", getPort());
        this.hashColumns.put("sdt", getSdt());
        this.hashColumns.put("rev_yrmon", getRevYrmon());
        this.hashColumns.put("exe_yrmon", getExeYrmon());
        this.hashColumns.put("estm_amt", getEstmAmt());
        this.hashColumns.put("act_amt", getActAmt());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("acct_cd", getAcctCd());
        this.hashColumns.put("edt", getEdt());
        this.hashColumns.put("estm_seq_no", getEstmSeqNo());
        this.hashColumns.put("accl_amt", getAcclAmt());
        this.hashColumns.put("rev_vvd", getRevVvd());
        this.hashColumns.put("match_flag", getMatchFlag());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("sys_src_id", getSysSrcId());
        this.hashColumns.put("rev_lane", getRevLane());
        this.hashColumns.put("cost_cd", getCostCd());
        this.hashColumns.put("cost_nm", getCostNm());
        this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
        this.hashColumns.put("act_dt", getActDt());
        this.hashColumns.put("conti_cd", getContiCd());
        this.hashColumns.put("conti_cds", getContiCds());
        this.hashColumns.put("acct_cds", getAcctCds());
        this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
        this.hashColumns.put("clpt_seq", getClptSeq());
        this.hashColumns.put("upd_flg", getUpdFlg());
        this.hashColumns.put("upd_dt", getUpdDt());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("port", "port");
        this.hashFields.put("sdt", "sdt");
        this.hashFields.put("rev_yrmon", "revYrmon");
        this.hashFields.put("exe_yrmon", "exeYrmon");
        this.hashFields.put("estm_amt", "estmAmt");
        this.hashFields.put("act_amt", "actAmt");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("acct_cd", "acctCd");
        this.hashFields.put("edt", "edt");
        this.hashFields.put("estm_seq_no", "estmSeqNo");
        this.hashFields.put("accl_amt", "acclAmt");
        this.hashFields.put("rev_vvd", "revVvd");
        this.hashFields.put("match_flag", "matchFlag");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("sys_src_id", "sysSrcId");
        this.hashFields.put("rev_lane", "revLane");
        this.hashFields.put("cost_cd", "costCd");
        this.hashFields.put("cost_nm", "costNm");
        this.hashFields.put("locl_curr_cd", "loclCurrCd");
        this.hashFields.put("act_dt", "actDt");
        this.hashFields.put("conti_cd", "contiCd");
        this.hashFields.put("conti_cds", "contiCds");
        this.hashFields.put("acct_cds", "acctCds");
        this.hashFields.put("clpt_ind_seq", "clptIndSeq");
        this.hashFields.put("clpt_seq", "clptSeq");
        this.hashFields.put("upd_flg", "updFlg");
        this.hashFields.put("upd_dt", "updDt");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return port
	 */
    public String getPort() {
        return this.port;
    }

    /**
	 * Column Info
	 * @return sdt
	 */
    public String getSdt() {
        return this.sdt;
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
	 * @return estmAmt
	 */
    public String getEstmAmt() {
        return this.estmAmt;
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
	 * @return creUsrId
	 */
    public String getCreUsrId() {
        return this.creUsrId;
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
	 * @return acctCd
	 */
    public String getAcctCd() {
        return this.acctCd;
    }

    /**
	 * Column Info
	 * @return edt
	 */
    public String getEdt() {
        return this.edt;
    }

    /**
	 * Column Info
	 * @return estmSeqNo
	 */
    public String getEstmSeqNo() {
        return this.estmSeqNo;
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
	 * @return revVvd
	 */
    public String getRevVvd() {
        return this.revVvd;
    }

    /**
	 * Column Info
	 * @return matchFlag
	 */
    public String getMatchFlag() {
        return this.matchFlag;
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
	 * @return sysSrcId
	 */
    public String getSysSrcId() {
        return this.sysSrcId;
    }

    /**
	 * Column Info
	 * @return revLane
	 */
    public String getRevLane() {
        return this.revLane;
    }

    /**
	 * Column Info
	 * @param port
	 */
    public void setPort(String port) {
        this.port = port;
    }

    /**
	 * Column Info
	 * @param sdt
	 */
    public void setSdt(String sdt) {
        this.sdt = sdt;
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
	 * @param estmAmt
	 */
    public void setEstmAmt(String estmAmt) {
        this.estmAmt = estmAmt;
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
	 * @param creUsrId
	 */
    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
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
	 * @param acctCd
	 */
    public void setAcctCd(String acctCd) {
        this.acctCd = acctCd;
    }

    /**
	 * Column Info
	 * @param edt
	 */
    public void setEdt(String edt) {
        this.edt = edt;
    }

    /**
	 * Column Info
	 * @param estmSeqNo
	 */
    public void setEstmSeqNo(String estmSeqNo) {
        this.estmSeqNo = estmSeqNo;
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
	 * @param revVvd
	 */
    public void setRevVvd(String revVvd) {
        this.revVvd = revVvd;
    }

    /**
	 * Column Info
	 * @param matchFlag
	 */
    public void setMatchFlag(String matchFlag) {
        this.matchFlag = matchFlag;
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
	 * @param sysSrcId
	 */
    public void setSysSrcId(String sysSrcId) {
        this.sysSrcId = sysSrcId;
    }

    /**
	 * Column Info
	 * @param revLane
	 */
    public void setRevLane(String revLane) {
        this.revLane = revLane;
    }

    public void setCostCd(String costCd) {
        this.costCd = costCd;
    }

    public String getCostCd() {
        return this.costCd;
    }

    public void setCostNm(String costNm) {
        this.costNm = costNm;
    }

    public String getCostNm() {
        return this.costNm;
    }

    public void setLoclCurrCd(String loclCurrCd) {
        this.loclCurrCd = loclCurrCd;
    }

    public String getLoclCurrCd() {
        return this.loclCurrCd;
    }

    public void setActDt(String actDt) {
        this.actDt = actDt;
    }

    public String getActDt() {
        return this.actDt;
    }

    public void setContiCd(String contiCd) {
        this.contiCd = contiCd;
    }

    public String getContiCd() {
        return this.contiCd;
    }

    public void setContiCds(String contiCds) {
        this.contiCds = contiCds;
    }

    public String getContiCds() {
        return this.contiCds;
    }

    public void setAcctCds(String acctCds) {
        this.acctCds = acctCds;
    }

    public String getAcctCds() {
        return this.acctCds;
    }

    public void setClptIndSeq(String clptIndSeq) {
        this.clptIndSeq = clptIndSeq;
    }

    public String getClptIndSeq() {
        return this.clptIndSeq;
    }

    public void setClptSeq(String clptSeq) {
        this.clptSeq = clptSeq;
    }

    public String getClptSeq() {
        return this.clptSeq;
    }

    public void setUpdFlg(String updFlg) {
        this.updFlg = updFlg;
    }

    public String getUpdFlg() {
        return this.updFlg;
    }

    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    public String getUpdDt() {
        return this.updDt;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setPort(JSPUtil.getParameter(request, "port", ""));
        setSdt(JSPUtil.getParameter(request, "sdt", ""));
        setRevYrmon(JSPUtil.getParameter(request, "rev_yrmon", ""));
        setExeYrmon(JSPUtil.getParameter(request, "exe_yrmon", ""));
        setEstmAmt(JSPUtil.getParameter(request, "estm_amt", ""));
        setActAmt(JSPUtil.getParameter(request, "act_amt", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
        setEdt(JSPUtil.getParameter(request, "edt", ""));
        setEstmSeqNo(JSPUtil.getParameter(request, "estm_seq_no", ""));
        setAcclAmt(JSPUtil.getParameter(request, "accl_amt", ""));
        setRevVvd(JSPUtil.getParameter(request, "rev_vvd", ""));
        setMatchFlag(JSPUtil.getParameter(request, "match_flag", ""));
        setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
        setSysSrcId(JSPUtil.getParameter(request, "sys_src_id", ""));
        setRevLane(JSPUtil.getParameter(request, "rev_lane", ""));
        setCostCd(JSPUtil.getParameter(request, "cost_cd", ""));
        setCostNm(JSPUtil.getParameter(request, "cost_nm", ""));
        setLoclCurrCd(JSPUtil.getParameter(request, "locl_curr_cd", ""));
        setActDt(JSPUtil.getParameter(request, "act_dt", ""));
        setContiCd(JSPUtil.getParameter(request, "conti_cd", ""));
        setContiCds(JSPUtil.getParameter(request, "conti_cds", ""));
        setAcctCds(JSPUtil.getParameter(request, "acct_cds", ""));
        setClptIndSeq(JSPUtil.getParameter(request, "clpt_ind_seq", ""));
        setClptSeq(JSPUtil.getParameter(request, "clpt_seq", ""));
        setUpdFlg(JSPUtil.getParameter(request, "upd_flg", ""));
        setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ErpDtlVO[]
	 */
    public ErpDtlVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ErpDtlVO[]
	 */
    public ErpDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        ErpDtlVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] port = (JSPUtil.getParameter(request, prefix + "port", length));
            String[] sdt = (JSPUtil.getParameter(request, prefix + "sdt", length));
            String[] revYrmon = (JSPUtil.getParameter(request, prefix + "rev_yrmon", length));
            String[] exeYrmon = (JSPUtil.getParameter(request, prefix + "exe_yrmon", length));
            String[] estmAmt = (JSPUtil.getParameter(request, prefix + "estm_amt", length));
            String[] actAmt = (JSPUtil.getParameter(request, prefix + "act_amt", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] acctCd = (JSPUtil.getParameter(request, prefix + "acct_cd", length));
            String[] edt = (JSPUtil.getParameter(request, prefix + "edt", length));
            String[] estmSeqNo = (JSPUtil.getParameter(request, prefix + "estm_seq_no", length));
            String[] acclAmt = (JSPUtil.getParameter(request, prefix + "accl_amt", length));
            String[] revVvd = (JSPUtil.getParameter(request, prefix + "rev_vvd", length));
            String[] matchFlag = (JSPUtil.getParameter(request, prefix + "match_flag", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] sysSrcId = (JSPUtil.getParameter(request, prefix + "sys_src_id", length));
            String[] revLane = (JSPUtil.getParameter(request, prefix + "rev_lane", length));
            String[] costCd = (JSPUtil.getParameter(request, prefix + "cost_cd", length));
            String[] costNm = (JSPUtil.getParameter(request, prefix + "cost_nm", length));
            String[] loclCurrCd = (JSPUtil.getParameter(request, prefix + "locl_curr_cd", length));
            String[] actDt = (JSPUtil.getParameter(request, prefix + "act_dt", length));
            String[] contiCd = (JSPUtil.getParameter(request, prefix + "conti_cd", length));
            String[] contiCds = (JSPUtil.getParameter(request, prefix + "conti_cds", length));
            String[] acctCds = (JSPUtil.getParameter(request, prefix + "acct_cds", length));
            String[] clptIndSeq = (JSPUtil.getParameter(request, prefix + "clpt_ind_seq", length));
            String[] clptSeq = (JSPUtil.getParameter(request, prefix + "clpt_seq", length));
            String[] updFlg = (JSPUtil.getParameter(request, prefix + "upd_flg", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new ErpDtlVO();
                if (port[i] != null)
                    model.setPort(port[i]);
                if (sdt[i] != null)
                    model.setSdt(sdt[i]);
                if (revYrmon[i] != null)
                    model.setRevYrmon(revYrmon[i]);
                if (exeYrmon[i] != null)
                    model.setExeYrmon(exeYrmon[i]);
                if (estmAmt[i] != null)
                    model.setEstmAmt(estmAmt[i]);
                if (actAmt[i] != null)
                    model.setActAmt(actAmt[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (acctCd[i] != null)
                    model.setAcctCd(acctCd[i]);
                if (edt[i] != null)
                    model.setEdt(edt[i]);
                if (estmSeqNo[i] != null)
                    model.setEstmSeqNo(estmSeqNo[i]);
                if (acclAmt[i] != null)
                    model.setAcclAmt(acclAmt[i]);
                if (revVvd[i] != null)
                    model.setRevVvd(revVvd[i]);
                if (matchFlag[i] != null)
                    model.setMatchFlag(matchFlag[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (sysSrcId[i] != null)
                    model.setSysSrcId(sysSrcId[i]);
                if (revLane[i] != null)
                    model.setRevLane(revLane[i]);
                if (costCd[i] != null)
                    model.setCostCd(costCd[i]);
                if (costNm[i] != null)
                    model.setCostNm(costNm[i]);
                if (loclCurrCd[i] != null)
                    model.setLoclCurrCd(loclCurrCd[i]);
                if (actDt[i] != null)
                    model.setActDt(actDt[i]);
                if (contiCd[i] != null)
                    model.setContiCd(contiCd[i]);
                if (contiCds[i] != null)
                    model.setContiCds(contiCds[i]);
                if (acctCds[i] != null)
                    model.setAcctCds(acctCds[i]);
                if (clptIndSeq[i] != null)
                    model.setClptIndSeq(clptIndSeq[i]);
                if (clptSeq[i] != null)
                    model.setClptSeq(clptSeq[i]);
                if (updFlg[i] != null)
                    model.setUpdFlg(updFlg[i]);
                if (updDt[i] != null) 
		    		model.setUpdDt(updDt[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getErpDtlVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return ErpDtlVO[]
	 */
    public ErpDtlVO[] getErpDtlVOs() {
        ErpDtlVO[] vos = (ErpDtlVO[]) models.toArray(new ErpDtlVO[models.size()]);
        return vos;
    }

    /**
	 * VO Class의 내용을 String으로 변환
	 */
    public String toString() {
        StringBuffer ret = new StringBuffer();
        Field[] field = this.getClass().getDeclaredFields();
        String space = "";
        try {
            for (int i = 0; i < field.length; i++) {
                String[] arr = null;
                arr = getField(field, i);
                if (arr != null) {
                    for (int j = 0; j < arr.length; j++) {
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
        try {
            arr = (String[]) field[i].get(this);
        } catch (Exception ex) {
            arr = null;
        }
        return arr;
    }

    /**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
    public void unDataFormat() {
        this.port = this.port.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sdt = this.sdt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.revYrmon = this.revYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.exeYrmon = this.exeYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.estmAmt = this.estmAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.actAmt = this.actAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acctCd = this.acctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.edt = this.edt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.estmSeqNo = this.estmSeqNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acclAmt = this.acclAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.revVvd = this.revVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.matchFlag = this.matchFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sysSrcId = this.sysSrcId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.revLane = this.revLane.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.costCd = this.costCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.costNm = this.costNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.loclCurrCd = this.loclCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.actDt = this.actDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.contiCd = this.contiCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.contiCds = this.contiCds.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acctCds = this.acctCds.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.clptIndSeq = this.clptIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.clptSeq = this.clptSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updFlg = this.updFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
