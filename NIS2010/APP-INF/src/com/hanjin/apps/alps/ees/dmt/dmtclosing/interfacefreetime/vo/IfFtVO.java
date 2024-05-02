/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : IF_CHG_FT_VO.java
*@FileTitle : IF_CHG_FT_VO
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.26
*@LastModifier : 
*@LastVersion : 1.0
* 2017.06.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.interfacefreetime.vo;

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
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class IfFtVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<IfFtVO> models = new ArrayList<IfFtVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String bkgNo = null;

    /* Column Info */
    private String cntrNo = null;

    /* Column Info */
    private String ftDys = null;

    /* Column Info */
    private String ftCmncDt = null;

    /* Column Info */
    private String ftEndDt = null;

    /* Column Info */
    private String ftFxCmncDt = null;

    /* Column Info */
    private String fmMvmtYdCd = null;

    /* Column Info */
    private String fmMvmtDt = null;

    /* Column Info */
    private String sysAreaGrpId = null;

    /* Column Info */
    private String dmdtTrfCd = null;

    /* Column Info */
    private String trfSeq = null;

    /* Column Info */
    private String dmdtDeTermCd = null;

    /* Column Info */
    private String trfGrpSeq = null;

    /* Column Info */
    private String ftRmk = null;

    /* Column Info */
    private String dmdtChgLocDivCd = null;

    /* Column Info */
    private String fmMvmtStsCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public IfFtVO() {
    }

    public IfFtVO(String ibflag, String pagerows, String bkgNo, String cntrNo, String ftDys, String ftCmncDt, String ftEndDt, String ftFxCmncDt, String fmMvmtYdCd, String fmMvmtDt, String sysAreaGrpId, String dmdtTrfCd, String trfSeq, String dmdtDeTermCd, String trfGrpSeq, String ftRmk, String dmdtChgLocDivCd, String fmMvmtStsCd) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.bkgNo = bkgNo;
        this.cntrNo = cntrNo;
        this.ftDys = ftDys;
        this.ftCmncDt = ftCmncDt;
        this.ftEndDt = ftEndDt;
        this.ftFxCmncDt = ftFxCmncDt;
        this.fmMvmtYdCd = fmMvmtYdCd;
        this.fmMvmtDt = fmMvmtDt;
        this.sysAreaGrpId = sysAreaGrpId;
        this.dmdtTrfCd = dmdtTrfCd;
        this.trfSeq = trfSeq;
        this.dmdtDeTermCd = dmdtDeTermCd;
        this.trfGrpSeq = trfGrpSeq;
        this.ftRmk = ftRmk;
        this.dmdtChgLocDivCd = dmdtChgLocDivCd;
        this.fmMvmtStsCd = fmMvmtStsCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("cntr_no", getCntrNo());
        this.hashColumns.put("ft_dys", getFtDys());
        this.hashColumns.put("ft_cmnc_dt", getFtCmncDt());
        this.hashColumns.put("ft_end_dt", getFtEndDt());
        this.hashColumns.put("ft_fx_cmnc_dt", getFtFxCmncDt());
        this.hashColumns.put("fm_mvmt_yd_cd", getFmMvmtYdCd());
        this.hashColumns.put("fm_mvmt_dt", getFmMvmtDt());
        this.hashColumns.put("sys_area_grp_id", getSysAreaGrpId());
        this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
        this.hashColumns.put("trf_seq", getTrfSeq());
        this.hashColumns.put("dmdt_de_term_cd", getDmdtDeTermCd());
        this.hashColumns.put("trf_grp_seq", getTrfGrpSeq());
        this.hashColumns.put("ft_rmk", getFtRmk());
        this.hashColumns.put("ft_rmk", getFtRmk());
        this.hashColumns.put("dmdt_chg_loc_div_cd", getDmdtChgLocDivCd());
        this.hashColumns.put("fm_mvmt_sts_cd", getFmMvmtStsCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("cntr_no", "cntrNo");
        this.hashFields.put("ft_dys", "ftDys");
        this.hashFields.put("ft_cmnc_dt", "ftCmncDt");
        this.hashFields.put("ft_end_dt", "ftEndDt");
        this.hashFields.put("ft_fx_cmnc_dt", "ftFxCmncDt");
        this.hashFields.put("fm_mvmt_yd_cd", "fmMvmtYdCd");
        this.hashFields.put("fm_mvmt_dt", "fmMvmtDt");
        this.hashFields.put("sys_area_grp_id", "sysAreaGrpId");
        this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
        this.hashFields.put("trf_seq", "trfSeq");
        this.hashFields.put("dmdt_de_term_cd", "dmdtDeTermCd");
        this.hashFields.put("trf_grp_seq", "trfGrpSeq");
        this.hashFields.put("ft_rmk", "ftRmk");
        this.hashFields.put("ft_rmk", "ftRmk");
        this.hashFields.put("dmdt_chg_loc_div_cd", "dmdtChgLocDivCd");
        this.hashFields.put("fm_mvmt_sts_cd", "fmMvmtStsCd");
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
	 * @param String bkgNo
	 */
    public void setBkgNo(String bkgNo) {
        this.bkgNo = bkgNo;
    }

    /**
	 * 
	 * @return String bkgNo
	 */
    public String getBkgNo() {
        return this.bkgNo;
    }

    /**
	 *
	 * @param String cntrNo
	 */
    public void setCntrNo(String cntrNo) {
        this.cntrNo = cntrNo;
    }

    /**
	 * 
	 * @return String cntrNo
	 */
    public String getCntrNo() {
        return this.cntrNo;
    }

    public void setFtDys(String ftDys) {
        this.ftDys = ftDys;
    }

    public String getFtDys() {
        return this.ftDys;
    }

    public void setFtCmncDt(String ftCmncDt) {
        this.ftCmncDt = ftCmncDt;
    }

    public String getFtCmncDt() {
        return this.ftCmncDt;
    }

    public void setFtEndDt(String ftEndDt) {
        this.ftEndDt = ftEndDt;
    }

    public String getFtEndDt() {
        return this.ftEndDt;
    }

    public void setFtFxCmncDt(String ftFxCmncDt) {
        this.ftFxCmncDt = ftFxCmncDt;
    }

    public String getFtFxCmncDt() {
        return this.ftFxCmncDt;
    }

    public void setFmMvmtYdCd(String fmMvmtYdCd) {
        this.fmMvmtYdCd = fmMvmtYdCd;
    }

    public String getFmMvmtYdCd() {
        return this.fmMvmtYdCd;
    }

    public void setFmMvmtDt(String fmMvmtDt) {
        this.fmMvmtDt = fmMvmtDt;
    }

    public String getFmMvmtDt() {
        return this.fmMvmtDt;
    }

    public void setSysAreaGrpId(String sysAreaGrpId) {
        this.sysAreaGrpId = sysAreaGrpId;
    }

    public String getSysAreaGrpId() {
        return this.sysAreaGrpId;
    }

    public void setDmdtTrfCd(String dmdtTrfCd) {
        this.dmdtTrfCd = dmdtTrfCd;
    }

    public String getDmdtTrfCd() {
        return this.dmdtTrfCd;
    }

    public void setTrfSeq(String trfSeq) {
        this.trfSeq = trfSeq;
    }

    public String getTrfSeq() {
        return this.trfSeq;
    }

    public void setDmdtDeTermCd(String dmdtDeTermCd) {
        this.dmdtDeTermCd = dmdtDeTermCd;
    }

    public String getDmdtDeTermCd() {
        return this.dmdtDeTermCd;
    }

    public void setTrfGrpSeq(String trfGrpSeq) {
        this.trfGrpSeq = trfGrpSeq;
    }

    public String getTrfGrpSeq() {
        return this.trfGrpSeq;
    }

    public void setFtRmk(String ftRmk) {
        this.ftRmk = ftRmk;
    }

    public String getFtRmk() {
        return this.ftRmk;
    }

    public void setDmdtChgLocDivCd(String dmdtChgLocDivCd) {
        this.dmdtChgLocDivCd = dmdtChgLocDivCd;
    }

    public String getDmdtChgLocDivCd() {
        return this.dmdtChgLocDivCd;
    }

    public void setFmMvmtStsCd(String fmMvmtStsCd) {
        this.fmMvmtStsCd = fmMvmtStsCd;
    }

    public String getFmMvmtStsCd() {
        return this.fmMvmtStsCd;
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
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
        setFtDys(JSPUtil.getParameter(request, prefix + "ft_dys", ""));
        setFtCmncDt(JSPUtil.getParameter(request, prefix + "ft_cmnc_dt", ""));
        setFtEndDt(JSPUtil.getParameter(request, prefix + "ft_end_dt", ""));
        setFtFxCmncDt(JSPUtil.getParameter(request, prefix + "ft_fx_cmnc_dt", ""));
        setFmMvmtYdCd(JSPUtil.getParameter(request, prefix + "fm_mvmt_yd_cd", ""));
        setFmMvmtDt(JSPUtil.getParameter(request, prefix + "fm_mvmt_dt", ""));
        setSysAreaGrpId(JSPUtil.getParameter(request, prefix + "sys_area_grp_id", ""));
        setDmdtTrfCd(JSPUtil.getParameter(request, prefix + "dmdt_trf_cd", ""));
        setTrfSeq(JSPUtil.getParameter(request, prefix + "trf_seq", ""));
        setDmdtDeTermCd(JSPUtil.getParameter(request, prefix + "dmdt_de_term_cd", ""));
        setTrfGrpSeq(JSPUtil.getParameter(request, prefix + "trf_grp_seq", ""));
        setFtRmk(JSPUtil.getParameter(request, prefix + "ft_rmk", ""));
        setDmdtChgLocDivCd(JSPUtil.getParameter(request, prefix + "dmdt_chg_loc_div_cd", ""));
        setFmMvmtStsCd(JSPUtil.getParameter(request, prefix + "fm_mvmt_sts_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IF_CHG_FT_VO[]
	 */
    public IfFtVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IF_CHG_FT_VO[]
	 */
    public IfFtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        IfFtVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] cntrNo = (JSPUtil.getParameter(request, prefix + "cntr_no", length));
            String[] ftDys = (JSPUtil.getParameter(request, prefix + "ft_dys", length));
            String[] ftCmncDt = (JSPUtil.getParameter(request, prefix + "ft_cmnc_dt", length));
            String[] ftEndDt = (JSPUtil.getParameter(request, prefix + "ft_end_dt", length));
            String[] ftFxCmncDt = (JSPUtil.getParameter(request, prefix + "ft_fx_cmnc_dt", length));
            String[] fmMvmtYdCd = (JSPUtil.getParameter(request, prefix + "fm_mvmt_yd_cd", length));
            String[] fmMvmtDt = (JSPUtil.getParameter(request, prefix + "fm_mvmt_dt", length));
            String[] sysAreaGrpId = (JSPUtil.getParameter(request, prefix + "sys_area_grp_id", length));
            String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix + "dmdt_trf_cd", length));
            String[] trfSeq = (JSPUtil.getParameter(request, prefix + "trf_seq", length));
            String[] dmdtDeTermCd = (JSPUtil.getParameter(request, prefix + "dmdt_de_term_cd", length));
            String[] trfGrpSeq = (JSPUtil.getParameter(request, prefix + "trf_grp_seq", length));
            String[] ftRmk = (JSPUtil.getParameter(request, prefix + "ft_rmk", length));
            String[] dmdtChgLocDivCd = (JSPUtil.getParameter(request, prefix + "dmdt_chg_loc_div_cd", length));
            String[] fmMvmtStsCd = (JSPUtil.getParameter(request, prefix + "fm_mvmt_sts_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new IfFtVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (cntrNo[i] != null)
                    model.setCntrNo(cntrNo[i]);
                if (ftDys[i] != null)
                    model.setFtDys(ftDys[i]);
                if (ftCmncDt[i] != null)
                    model.setFtCmncDt(ftCmncDt[i]);
                if (ftEndDt[i] != null)
                    model.setFtEndDt(ftEndDt[i]);
                if (ftFxCmncDt[i] != null)
                    model.setFtFxCmncDt(ftFxCmncDt[i]);
                if (fmMvmtYdCd[i] != null)
                    model.setFmMvmtYdCd(fmMvmtYdCd[i]);
                if (fmMvmtDt[i] != null)
                    model.setFmMvmtDt(fmMvmtDt[i]);
                if (sysAreaGrpId[i] != null)
                    model.setSysAreaGrpId(sysAreaGrpId[i]);
                if (dmdtTrfCd[i] != null)
                    model.setDmdtTrfCd(dmdtTrfCd[i]);
                if (trfSeq[i] != null)
                    model.setTrfSeq(trfSeq[i]);
                if (dmdtDeTermCd[i] != null)
                    model.setDmdtDeTermCd(dmdtDeTermCd[i]);
                if (trfGrpSeq[i] != null)
                    model.setTrfGrpSeq(trfGrpSeq[i]);
                if (ftRmk[i] != null)
                    model.setFtRmk(ftRmk[i]);
                if (ftRmk[i] != null)
                    model.setFtRmk(ftRmk[i]);
                if (dmdtChgLocDivCd[i] != null)
                    model.setDmdtChgLocDivCd(dmdtChgLocDivCd[i]);
                if (fmMvmtStsCd[i] != null) 
		    		model.setFmMvmtStsCd(fmMvmtStsCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getIF_FT_VOs();
    }

    /**
	 * VO 배열을 반환
	 * @return IF_FT_VO[]
	 */
    public IfFtVO[] getIF_FT_VOs() {
        IfFtVO[] vos = (IfFtVO[]) models.toArray(new IfFtVO[models.size()]);
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
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrNo = this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ftDys = this.ftDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ftCmncDt = this.ftCmncDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ftEndDt = this.ftEndDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ftFxCmncDt = this.ftFxCmncDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fmMvmtYdCd = this.fmMvmtYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fmMvmtDt = this.fmMvmtDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sysAreaGrpId = this.sysAreaGrpId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtTrfCd = this.dmdtTrfCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trfSeq = this.trfSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtDeTermCd = this.dmdtDeTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trfGrpSeq = this.trfGrpSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ftRmk = this.ftRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtChgLocDivCd = this.dmdtChgLocDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fmMvmtStsCd = this.fmMvmtStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
