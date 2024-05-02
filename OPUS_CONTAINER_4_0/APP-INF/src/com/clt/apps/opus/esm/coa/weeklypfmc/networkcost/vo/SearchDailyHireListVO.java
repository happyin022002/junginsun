/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchDailyHireListVO.java
*@FileTitle : SearchDailyHireListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.06
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.06  
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo;

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
 * @author 
 * @since J2EE 1.6 
 * @see AbstractValueObject
 */
public class SearchDailyHireListVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<SearchDailyHireListVO> models = new ArrayList<SearchDailyHireListVO>();

    /* Column Info */
    private String chrgDhirAmt = null;

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String n1stHirRt = null;

    /* Column Info */
    private String n2ndHirRt = null;

    /* Page Number */
    private String pagerows = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String num = null;

    /* Column Info */
    private String flag = null;

    /* Column Info */
    private String costYrmon = null;

    /* Column Info */
    private String n2ndCurrCd = null;

    /* Column Info */
    private String costWk = null;

    /* Column Info */
    private String chrgCtrtSeq = null;

    /* Column Info */
    private String ctrtEffFmDt = null;

    /* Column Info */
    private String ctrtEffToDt = null;

    /* Column Info */
    private String chrgCtrtNo = null;

    /* Column Info */
    private String n1stCurrCd = null;

    /* Column Info */
    private String vslClssCapa = null;

    /* Column Info */
    private String stndLdbCapa = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public SearchDailyHireListVO() {
    }

    public SearchDailyHireListVO(String ibflag, String pagerows, String flag, String costYrmon, String costWk, String vslCd, String chrgCtrtNo, String chrgCtrtSeq, String num, String ctrtEffFmDt, String ctrtEffToDt, String n1stHirRt, String n1stCurrCd, String n2ndHirRt, String n2ndCurrCd, String chrgDhirAmt, String vslClssCapa, String stndLdbCapa) {
        this.chrgDhirAmt = chrgDhirAmt;
        this.vslCd = vslCd;
        this.n1stHirRt = n1stHirRt;
        this.n2ndHirRt = n2ndHirRt;
        this.pagerows = pagerows;
        this.ibflag = ibflag;
        this.num = num;
        this.flag = flag;
        this.costYrmon = costYrmon;
        this.n2ndCurrCd = n2ndCurrCd;
        this.costWk = costWk;
        this.chrgCtrtSeq = chrgCtrtSeq;
        this.ctrtEffFmDt = ctrtEffFmDt;
        this.ctrtEffToDt = ctrtEffToDt;
        this.chrgCtrtNo = chrgCtrtNo;
        this.n1stCurrCd = n1stCurrCd;
        this.vslClssCapa = vslClssCapa;
        this.stndLdbCapa = stndLdbCapa;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("chrg_dhir_amt", getChrgDhirAmt());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("n1st_hir_rt", getN1stHirRt());
        this.hashColumns.put("n2nd_hir_rt", getN2ndHirRt());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("num", getNum());
        this.hashColumns.put("flag", getFlag());
        this.hashColumns.put("cost_yrmon", getCostYrmon());
        this.hashColumns.put("n2nd_curr_cd", getN2ndCurrCd());
        this.hashColumns.put("cost_wk", getCostWk());
        this.hashColumns.put("chrg_ctrt_seq", getChrgCtrtSeq());
        this.hashColumns.put("ctrt_eff_fm_dt", getCtrtEffFmDt());
        this.hashColumns.put("ctrt_eff_to_dt", getCtrtEffToDt());
        this.hashColumns.put("chrg_ctrt_no", getChrgCtrtNo());
        this.hashColumns.put("n1st_curr_cd", getN1stCurrCd());
        this.hashColumns.put("vsl_clss_capa", getVslClssCapa());
        this.hashColumns.put("stnd_ldb_capa", getStndLdbCapa());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("chrg_dhir_amt", "chrgDhirAmt");
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("n1st_hir_rt", "n1stHirRt");
        this.hashFields.put("n2nd_hir_rt", "n2ndHirRt");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("num", "num");
        this.hashFields.put("flag", "flag");
        this.hashFields.put("cost_yrmon", "costYrmon");
        this.hashFields.put("n2nd_curr_cd", "n2ndCurrCd");
        this.hashFields.put("cost_wk", "costWk");
        this.hashFields.put("chrg_ctrt_seq", "chrgCtrtSeq");
        this.hashFields.put("ctrt_eff_fm_dt", "ctrtEffFmDt");
        this.hashFields.put("ctrt_eff_to_dt", "ctrtEffToDt");
        this.hashFields.put("chrg_ctrt_no", "chrgCtrtNo");
        this.hashFields.put("n1st_curr_cd", "n1stCurrCd");
        this.hashFields.put("vsl_clss_capa", "vslClssCapa");
        this.hashFields.put("stnd_ldb_capa", "stndLdbCapa");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return chrgDhirAmt
	 */
    public String getChrgDhirAmt() {
        return this.chrgDhirAmt;
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
	 * @return n1stHirRt
	 */
    public String getN1stHirRt() {
        return this.n1stHirRt;
    }

    /**
	 * Column Info
	 * @return n2ndHirRt
	 */
    public String getN2ndHirRt() {
        return this.n2ndHirRt;
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
	 * @return num
	 */
    public String getNum() {
        return this.num;
    }

    /**
	 * Column Info
	 * @return flag
	 */
    public String getFlag() {
        return this.flag;
    }

    /**
	 * Column Info
	 * @return costYrmon
	 */
    public String getCostYrmon() {
        return this.costYrmon;
    }

    /**
	 * Column Info
	 * @return n2ndCurrCd
	 */
    public String getN2ndCurrCd() {
        return this.n2ndCurrCd;
    }

    /**
	 * Column Info
	 * @return costWk
	 */
    public String getCostWk() {
        return this.costWk;
    }

    /**
	 * Column Info
	 * @return chrgCtrtSeq
	 */
    public String getChrgCtrtSeq() {
        return this.chrgCtrtSeq;
    }

    /**
	 * Column Info
	 * @return ctrtEffFmDt
	 */
    public String getCtrtEffFmDt() {
        return this.ctrtEffFmDt;
    }

    /**
	 * Column Info
	 * @return ctrtEffToDt
	 */
    public String getCtrtEffToDt() {
        return this.ctrtEffToDt;
    }

    /**
	 * Column Info
	 * @return chrgCtrtNo
	 */
    public String getChrgCtrtNo() {
        return this.chrgCtrtNo;
    }

    /**
	 * Column Info
	 * @return n1stCurrCd
	 */
    public String getN1stCurrCd() {
        return this.n1stCurrCd;
    }

    /**
	 * Column Info
	 * @param chrgDhirAmt
	 */
    public void setChrgDhirAmt(String chrgDhirAmt) {
        this.chrgDhirAmt = chrgDhirAmt;
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
	 * @param n1stHirRt
	 */
    public void setN1stHirRt(String n1stHirRt) {
        this.n1stHirRt = n1stHirRt;
    }

    /**
	 * Column Info
	 * @param n2ndHirRt
	 */
    public void setN2ndHirRt(String n2ndHirRt) {
        this.n2ndHirRt = n2ndHirRt;
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
	 * @param num
	 */
    public void setNum(String num) {
        this.num = num;
    }

    /**
	 * Column Info
	 * @param flag
	 */
    public void setFlag(String flag) {
        this.flag = flag;
    }

    /**
	 * Column Info
	 * @param costYrmon
	 */
    public void setCostYrmon(String costYrmon) {
        this.costYrmon = costYrmon;
    }

    /**
	 * Column Info
	 * @param n2ndCurrCd
	 */
    public void setN2ndCurrCd(String n2ndCurrCd) {
        this.n2ndCurrCd = n2ndCurrCd;
    }

    /**
	 * Column Info
	 * @param costWk
	 */
    public void setCostWk(String costWk) {
        this.costWk = costWk;
    }

    /**
	 * Column Info
	 * @param chrgCtrtSeq
	 */
    public void setChrgCtrtSeq(String chrgCtrtSeq) {
        this.chrgCtrtSeq = chrgCtrtSeq;
    }

    /**
	 * Column Info
	 * @param ctrtEffFmDt
	 */
    public void setCtrtEffFmDt(String ctrtEffFmDt) {
        this.ctrtEffFmDt = ctrtEffFmDt;
    }

    /**
	 * Column Info
	 * @param ctrtEffToDt
	 */
    public void setCtrtEffToDt(String ctrtEffToDt) {
        this.ctrtEffToDt = ctrtEffToDt;
    }

    /**
	 * Column Info
	 * @param chrgCtrtNo
	 */
    public void setChrgCtrtNo(String chrgCtrtNo) {
        this.chrgCtrtNo = chrgCtrtNo;
    }

    /**
	 * Column Info
	 * @param n1stCurrCd
	 */
    public void setN1stCurrCd(String n1stCurrCd) {
        this.n1stCurrCd = n1stCurrCd;
    }

    public void setVslClssCapa(String vslClssCapa) {
        this.vslClssCapa = vslClssCapa;
    }

    public String getVslClssCapa() {
        return this.vslClssCapa;
    }

    public void setStndLdbCapa(String stndLdbCapa) {
        this.stndLdbCapa = stndLdbCapa;
    }

    public String getStndLdbCapa() {
        return this.stndLdbCapa;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setChrgDhirAmt(JSPUtil.getParameter(request, "chrg_dhir_amt", ""));
        setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
        setN1stHirRt(JSPUtil.getParameter(request, "n1st_hir_rt", ""));
        setN2ndHirRt(JSPUtil.getParameter(request, "n2nd_hir_rt", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setNum(JSPUtil.getParameter(request, "num", ""));
        setFlag(JSPUtil.getParameter(request, "flag", ""));
        setCostYrmon(JSPUtil.getParameter(request, "cost_yrmon", ""));
        setN2ndCurrCd(JSPUtil.getParameter(request, "n2nd_curr_cd", ""));
        setCostWk(JSPUtil.getParameter(request, "cost_wk", ""));
        setChrgCtrtSeq(JSPUtil.getParameter(request, "chrg_ctrt_seq", ""));
        setCtrtEffFmDt(JSPUtil.getParameter(request, "ctrt_eff_fm_dt", ""));
        setCtrtEffToDt(JSPUtil.getParameter(request, "ctrt_eff_to_dt", ""));
        setChrgCtrtNo(JSPUtil.getParameter(request, "chrg_ctrt_no", ""));
        setN1stCurrCd(JSPUtil.getParameter(request, "n1st_curr_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchDailyHireListVO[]
	 */
    public SearchDailyHireListVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchDailyHireListVO[]
	 */
    public SearchDailyHireListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        SearchDailyHireListVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] chrgDhirAmt = (JSPUtil.getParameter(request, prefix + "chrg_dhir_amt", length));
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] n1stHirRt = (JSPUtil.getParameter(request, prefix + "n1st_hir_rt", length));
            String[] n2ndHirRt = (JSPUtil.getParameter(request, prefix + "n2nd_hir_rt", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] num = (JSPUtil.getParameter(request, prefix + "num", length));
            String[] flag = (JSPUtil.getParameter(request, prefix + "flag", length));
            String[] costYrmon = (JSPUtil.getParameter(request, prefix + "cost_yrmon", length));
            String[] n2ndCurrCd = (JSPUtil.getParameter(request, prefix + "n2nd_curr_cd", length));
            String[] costWk = (JSPUtil.getParameter(request, prefix + "cost_wk", length));
            String[] chrgCtrtSeq = (JSPUtil.getParameter(request, prefix + "chrg_ctrt_seq", length));
            String[] ctrtEffFmDt = (JSPUtil.getParameter(request, prefix + "ctrt_eff_fm_dt", length));
            String[] ctrtEffToDt = (JSPUtil.getParameter(request, prefix + "ctrt_eff_to_dt", length));
            String[] chrgCtrtNo = (JSPUtil.getParameter(request, prefix + "chrg_ctrt_no", length));
            String[] n1stCurrCd = (JSPUtil.getParameter(request, prefix + "n1st_curr_cd", length));
            for (int i = 0; i < length; i++) {
                model = new SearchDailyHireListVO();
                if (chrgDhirAmt[i] != null)
                    model.setChrgDhirAmt(chrgDhirAmt[i]);
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (n1stHirRt[i] != null)
                    model.setN1stHirRt(n1stHirRt[i]);
                if (n2ndHirRt[i] != null)
                    model.setN2ndHirRt(n2ndHirRt[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (num[i] != null)
                    model.setNum(num[i]);
                if (flag[i] != null)
                    model.setFlag(flag[i]);
                if (costYrmon[i] != null)
                    model.setCostYrmon(costYrmon[i]);
                if (n2ndCurrCd[i] != null)
                    model.setN2ndCurrCd(n2ndCurrCd[i]);
                if (costWk[i] != null)
                    model.setCostWk(costWk[i]);
                if (chrgCtrtSeq[i] != null)
                    model.setChrgCtrtSeq(chrgCtrtSeq[i]);
                if (ctrtEffFmDt[i] != null)
                    model.setCtrtEffFmDt(ctrtEffFmDt[i]);
                if (ctrtEffToDt[i] != null)
                    model.setCtrtEffToDt(ctrtEffToDt[i]);
                if (chrgCtrtNo[i] != null)
                    model.setChrgCtrtNo(chrgCtrtNo[i]);
                if (n1stCurrCd[i] != null)
                    model.setN1stCurrCd(n1stCurrCd[i]);
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getSearchDailyHireListVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return SearchDailyHireListVO[]
	 */
    public SearchDailyHireListVO[] getSearchDailyHireListVOs() {
        SearchDailyHireListVO[] vos = (SearchDailyHireListVO[]) models.toArray(new SearchDailyHireListVO[models.size()]);
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
        this.chrgDhirAmt = this.chrgDhirAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n1stHirRt = this.n1stHirRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n2ndHirRt = this.n2ndHirRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.num = this.num.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.flag = this.flag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.costYrmon = this.costYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n2ndCurrCd = this.n2ndCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.costWk = this.costWk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chrgCtrtSeq = this.chrgCtrtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctrtEffFmDt = this.ctrtEffFmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctrtEffToDt = this.ctrtEffToDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chrgCtrtNo = this.chrgCtrtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n1stCurrCd = this.n1stCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslClssCapa = this.vslClssCapa.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stndLdbCapa = this.stndLdbCapa.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
