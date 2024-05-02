/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : AvgAgnCommissionVO.java
*@FileTitle : AvgAgnCommissionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.11
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.avgagncommission.vo;

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
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class AvgAgencyCommissionVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<AvgAgencyCommissionVO> models = new ArrayList<AvgAgencyCommissionVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String commYrmon = null;

    /* Column Info */
    private String ofcCd = null;

    /* Column Info */
    private String cntCd = null;

    /* Column Info */
    private String ioBndCd = null;

    /* Column Info */
    private String acTpCd = null;

    /* Column Info */
    private String cntrTpszCd = null;

    /* Column Info */
    private String commStndCostCd = null;

    /* Column Info */
    private String trdCd = null;

    /* Column Info */
    private String subTrdCd = null;

    /* Column Info */
    private String bkgQty = null;

    /* Column Info */
    private String commTtlAmt = null;

    /* Column Info */
    private String commUtAmt = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String acTpNm = null;

    /* Column Info */
    private String commStndCostNm = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public AvgAgencyCommissionVO() {
    }

    public AvgAgencyCommissionVO(String ibflag, String pagerows, String commYrmon, String ofcCd, String cntCd, String ioBndCd, String acTpCd, String cntrTpszCd, String commStndCostCd, String trdCd, String subTrdCd, String bkgQty, String commTtlAmt, String commUtAmt, String creUsrId, String creDt, String updUsrId, String updDt, String acTpNm, String commStndCostNm) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.commYrmon = commYrmon;
        this.ofcCd = ofcCd;
        this.cntCd = cntCd;
        this.ioBndCd = ioBndCd;
        this.acTpCd = acTpCd;
        this.cntrTpszCd = cntrTpszCd;
        this.commStndCostCd = commStndCostCd;
        this.trdCd = trdCd;
        this.subTrdCd = subTrdCd;
        this.bkgQty = bkgQty;
        this.commTtlAmt = commTtlAmt;
        this.commUtAmt = commUtAmt;
        this.creUsrId = creUsrId;
        this.creDt = creDt;
        this.updUsrId = updUsrId;
        this.updDt = updDt;
        this.acTpNm = acTpNm;
        this.commStndCostNm = commStndCostNm;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("comm_yrmon", getCommYrmon());
        this.hashColumns.put("ofc_cd", getOfcCd());
        this.hashColumns.put("cnt_cd", getCntCd());
        this.hashColumns.put("io_bnd_cd", getIoBndCd());
        this.hashColumns.put("ac_tp_cd", getAcTpCd());
        this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
        this.hashColumns.put("comm_stnd_cost_cd", getCommStndCostCd());
        this.hashColumns.put("trd_cd", getTrdCd());
        this.hashColumns.put("sub_trd_cd", getSubTrdCd());
        this.hashColumns.put("bkg_qty", getBkgQty());
        this.hashColumns.put("comm_ttl_amt", getCommTtlAmt());
        this.hashColumns.put("comm_ut_amt", getCommUtAmt());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("ac_tp_nm", getAcTpNm());
        this.hashColumns.put("comm_stnd_cost_nm", getCommStndCostNm());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("comm_yrmon", "commYrmon");
        this.hashFields.put("ofc_cd", "ofcCd");
        this.hashFields.put("cnt_cd", "cntCd");
        this.hashFields.put("io_bnd_cd", "ioBndCd");
        this.hashFields.put("ac_tp_cd", "acTpCd");
        this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
        this.hashFields.put("comm_stnd_cost_cd", "commStndCostCd");
        this.hashFields.put("trd_cd", "trdCd");
        this.hashFields.put("sub_trd_cd", "subTrdCd");
        this.hashFields.put("bkg_qty", "bkgQty");
        this.hashFields.put("comm_ttl_amt", "commTtlAmt");
        this.hashFields.put("comm_ut_amt", "commUtAmt");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("ac_tp_nm", "acTpNm");
        this.hashFields.put("comm_stnd_cost_nm", "commStndCostNm");
        return this.hashFields;
    }

    /**
	 *
	 * @param String ibflag
	 */
    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
    }

    /**
	 * 
	 * @return String ibflag
	 */
    public String getIbflag() {
        return this.ibflag;
    }

    /**
	 *
	 * @param String pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    /**
	 * 
	 * @return String pagerows
	 */
    public String getPagerows() {
        return this.pagerows;
    }

    /**
	 *
	 * @param String commYrmon
	 */
    public void setCommYrmon(String commYrmon) {
        this.commYrmon = commYrmon;
    }

    /**
	 * 
	 * @return String commYrmon
	 */
    public String getCommYrmon() {
        return this.commYrmon;
    }

    /**
	 *
	 * @param String ofcCd
	 */
    public void setOfcCd(String ofcCd) {
        this.ofcCd = ofcCd;
    }

    /**
	 * 
	 * @return String ofcCd
	 */
    public String getOfcCd() {
        return this.ofcCd;
    }

    /**
	 *
	 * @param String cntCd
	 */
    public void setCntCd(String cntCd) {
        this.cntCd = cntCd;
    }

    /**
	 * 
	 * @return String cntCd
	 */
    public String getCntCd() {
        return this.cntCd;
    }

    /**
	 *
	 * @param String ioBndCd
	 */
    public void setIoBndCd(String ioBndCd) {
        this.ioBndCd = ioBndCd;
    }

    /**
	 * 
	 * @return String ioBndCd
	 */
    public String getIoBndCd() {
        return this.ioBndCd;
    }

    /**
	 *
	 * @param String acTpCd
	 */
    public void setAcTpCd(String acTpCd) {
        this.acTpCd = acTpCd;
    }

    /**
	 * 
	 * @return String acTpCd
	 */
    public String getAcTpCd() {
        return this.acTpCd;
    }

    /**
	 *
	 * @param String cntrTpszCd
	 */
    public void setCntrTpszCd(String cntrTpszCd) {
        this.cntrTpszCd = cntrTpszCd;
    }

    /**
	 * 
	 * @return String cntrTpszCd
	 */
    public String getCntrTpszCd() {
        return this.cntrTpszCd;
    }

    /**
	 *
	 * @param String commStndCostCd
	 */
    public void setCommStndCostCd(String commStndCostCd) {
        this.commStndCostCd = commStndCostCd;
    }

    /**
	 * 
	 * @return String commStndCostCd
	 */
    public String getCommStndCostCd() {
        return this.commStndCostCd;
    }

    /**
	 *
	 * @param String trdCd
	 */
    public void setTrdCd(String trdCd) {
        this.trdCd = trdCd;
    }

    /**
	 * 
	 * @return String trdCd
	 */
    public String getTrdCd() {
        return this.trdCd;
    }

    /**
	 *
	 * @param String subTrdCd
	 */
    public void setSubTrdCd(String subTrdCd) {
        this.subTrdCd = subTrdCd;
    }

    /**
	 * 
	 * @return String subTrdCd
	 */
    public String getSubTrdCd() {
        return this.subTrdCd;
    }

    /**
	 *
	 * @param String bkgQty
	 */
    public void setBkgQty(String bkgQty) {
        this.bkgQty = bkgQty;
    }

    /**
	 * 
	 * @return String bkgQty
	 */
    public String getBkgQty() {
        return this.bkgQty;
    }

    /**
	 *
	 * @param String commTtlAmt
	 */
    public void setCommTtlAmt(String commTtlAmt) {
        this.commTtlAmt = commTtlAmt;
    }

    /**
	 * 
	 * @return String commTtlAmt
	 */
    public String getCommTtlAmt() {
        return this.commTtlAmt;
    }

    /**
	 *
	 * @param String commUtAmt
	 */
    public void setCommUtAmt(String commUtAmt) {
        this.commUtAmt = commUtAmt;
    }

    /**
	 * 
	 * @return String commUtAmt
	 */
    public String getCommUtAmt() {
        return this.commUtAmt;
    }

    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
    }

    public String getCreUsrId() {
        return this.creUsrId;
    }

    public void setCreDt(String creDt) {
        this.creDt = creDt;
    }

    public String getCreDt() {
        return this.creDt;
    }

    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
    }

    public String getUpdUsrId() {
        return this.updUsrId;
    }

    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    public String getUpdDt() {
        return this.updDt;
    }

    public void setAcTpNm(String acTpNm) {
        this.acTpNm = acTpNm;
    }

    public String getAcTpNm() {
        return this.acTpNm;
    }

    public void setCommStndCostNm(String commStndCostNm) {
        this.commStndCostNm = commStndCostNm;
    }

    public String getCommStndCostNm() {
        return this.commStndCostNm;
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
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setCommYrmon(JSPUtil.getParameter(request, prefix + "comm_yrmon", ""));
        setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
        setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
        setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
        setAcTpCd(JSPUtil.getParameter(request, prefix + "ac_tp_cd", ""));
        setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
        setCommStndCostCd(JSPUtil.getParameter(request, prefix + "comm_stnd_cost_cd", ""));
        setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
        setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
        setBkgQty(JSPUtil.getParameter(request, prefix + "bkg_qty", ""));
        setCommTtlAmt(JSPUtil.getParameter(request, prefix + "comm_ttl_amt", ""));
        setCommUtAmt(JSPUtil.getParameter(request, prefix + "comm_ut_amt", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setAcTpNm(JSPUtil.getParameter(request, prefix + "ac_tp_nm", ""));
        setCommStndCostNm(JSPUtil.getParameter(request, prefix + "comm_stnd_cost_nm", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AvgAgnCommissionVO[]
	 */
    public AvgAgencyCommissionVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AvgAgnCommissionVO[]
	 */
    public AvgAgencyCommissionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        AvgAgencyCommissionVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] commYrmon = (JSPUtil.getParameter(request, prefix + "comm_yrmon", length));
            String[] ofcCd = (JSPUtil.getParameter(request, prefix + "ofc_cd", length));
            String[] cntCd = (JSPUtil.getParameter(request, prefix + "cnt_cd", length));
            String[] ioBndCd = (JSPUtil.getParameter(request, prefix + "io_bnd_cd", length));
            String[] acTpCd = (JSPUtil.getParameter(request, prefix + "ac_tp_cd", length));
            String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", length));
            String[] commStndCostCd = (JSPUtil.getParameter(request, prefix + "comm_stnd_cost_cd", length));
            String[] trdCd = (JSPUtil.getParameter(request, prefix + "trd_cd", length));
            String[] subTrdCd = (JSPUtil.getParameter(request, prefix + "sub_trd_cd", length));
            String[] bkgQty = (JSPUtil.getParameter(request, prefix + "bkg_qty", length));
            String[] commTtlAmt = (JSPUtil.getParameter(request, prefix + "comm_ttl_amt", length));
            String[] commUtAmt = (JSPUtil.getParameter(request, prefix + "comm_ut_amt", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] acTpNm = (JSPUtil.getParameter(request, prefix + "ac_tp_nm", length));
	    	String[] commStndCostNm = (JSPUtil.getParameter(request, prefix + "comm_stnd_cost_nm", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new AvgAgencyCommissionVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (commYrmon[i] != null)
                    model.setCommYrmon(commYrmon[i]);
                if (ofcCd[i] != null)
                    model.setOfcCd(ofcCd[i]);
                if (cntCd[i] != null)
                    model.setCntCd(cntCd[i]);
                if (ioBndCd[i] != null)
                    model.setIoBndCd(ioBndCd[i]);
                if (acTpCd[i] != null)
                    model.setAcTpCd(acTpCd[i]);
                if (cntrTpszCd[i] != null)
                    model.setCntrTpszCd(cntrTpszCd[i]);
                if (commStndCostCd[i] != null)
                    model.setCommStndCostCd(commStndCostCd[i]);
                if (trdCd[i] != null)
                    model.setTrdCd(trdCd[i]);
                if (subTrdCd[i] != null)
                    model.setSubTrdCd(subTrdCd[i]);
                if (bkgQty[i] != null)
                    model.setBkgQty(bkgQty[i]);
                if (commTtlAmt[i] != null)
                    model.setCommTtlAmt(commTtlAmt[i]);
                if (commUtAmt[i] != null)
                    model.setCommUtAmt(commUtAmt[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (acTpNm[i] != null) 
		    		model.setAcTpNm(acTpNm[i]);
				if (commStndCostNm[i] != null) 
		    		model.setCommStndCostNm(commStndCostNm[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getAvgAgnCommissionVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return AvgAgnCommissionVO[]
	 */
    public AvgAgencyCommissionVO[] getAvgAgnCommissionVOs() {
        AvgAgencyCommissionVO[] vos = (AvgAgencyCommissionVO[]) models.toArray(new AvgAgencyCommissionVO[models.size()]);
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
        this.commYrmon = this.commYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcCd = this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntCd = this.cntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ioBndCd = this.ioBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acTpCd = this.acTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrTpszCd = this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.commStndCostCd = this.commStndCostCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trdCd = this.trdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.subTrdCd = this.subTrdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgQty = this.bkgQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.commTtlAmt = this.commTtlAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.commUtAmt = this.commUtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acTpNm = this.acTpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.commStndCostNm = this.commStndCostNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
