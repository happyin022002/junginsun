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
public class IfFtCondVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<IfFtCondVO> models = new ArrayList<IfFtCondVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String bkgNo = null;

    /* Column Info */
    private String cntrNo = null;

    /* Column Info */
    private String fmMvmtDt = null;

    /* Column Info */
    private String fmMvmtYdCd = null;

    /* Column Info */
    private String fmMvmtStsCd = null;

    /* Column Info */
    private String dmdtChgLocDivCd = null;

    /* Column Info */
    private String inlndFlg = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public IfFtCondVO() {
    }

    public IfFtCondVO(String ibflag, String pagerows, String bkgNo, String cntrNo, String fmMvmtDt, String fmMvmtYdCd, String fmMvmtStsCd, String dmdtChgLocDivCd, String inlndFlg) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.bkgNo = bkgNo;
        this.cntrNo = cntrNo;
        this.fmMvmtDt = fmMvmtDt;
        this.fmMvmtYdCd = fmMvmtYdCd;
        this.fmMvmtStsCd = fmMvmtStsCd;
        this.dmdtChgLocDivCd = dmdtChgLocDivCd;
        this.inlndFlg = inlndFlg;
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
        this.hashColumns.put("fm_mvmt_dt", getFmMvmtDt());
        this.hashColumns.put("fm_mvmt_yd_cd", getFmMvmtYdCd());
        this.hashColumns.put("fm_mvmt_sts_cd", getFmMvmtStsCd());
        this.hashColumns.put("dmdt_chg_loc_div_cd", getDmdtChgLocDivCd());
        this.hashColumns.put("inlnd_flg", getInlndFlg());
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
        this.hashFields.put("fm_mvmt_dt", "fmMvmtDt");
        this.hashFields.put("fm_mvmt_yd_cd", "fmMvmtYdCd");
        this.hashFields.put("fm_mvmt_sts_cd", "fmMvmtStsCd");
        this.hashFields.put("dmdt_chg_loc_div_cd", "dmdtChgLocDivCd");
        this.hashFields.put("inlnd_flg", "inlndFlg");
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

    public void setFmMvmtDt(String fmMvmtDt) {
        this.fmMvmtDt = fmMvmtDt;
    }

    public String getFmMvmtDt() {
        return this.fmMvmtDt;
    }

    public void setFmMvmtYdCd(String fmMvmtYdCd) {
        this.fmMvmtYdCd = fmMvmtYdCd;
    }

    public String getFmMvmtYdCd() {
        return this.fmMvmtYdCd;
    }

    public void setFmMvmtStsCd(String fmMvmtStsCd) {
        this.fmMvmtStsCd = fmMvmtStsCd;
    }

    public String getFmMvmtStsCd() {
        return this.fmMvmtStsCd;
    }

    public void setDmdtChgLocDivCd(String dmdtChgLocDivCd) {
        this.dmdtChgLocDivCd = dmdtChgLocDivCd;
    }

    public String getDmdtChgLocDivCd() {
        return this.dmdtChgLocDivCd;
    }

    public void setInlndFlg(String inlndFlg) {
        this.inlndFlg = inlndFlg;
    }

    public String getInlndFlg() {
        return this.inlndFlg;
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
        setFmMvmtDt(JSPUtil.getParameter(request, prefix + "fm_mvmt_dt", ""));
        setFmMvmtYdCd(JSPUtil.getParameter(request, prefix + "fm_mvmt_yd_cd", ""));
        setFmMvmtStsCd(JSPUtil.getParameter(request, prefix + "fm_mvmt_sts_cd", ""));
        setDmdtChgLocDivCd(JSPUtil.getParameter(request, prefix + "dmdt_chg_loc_div_cd", ""));
        setInlndFlg(JSPUtil.getParameter(request, prefix + "inlnd_flg", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IF_CHG_FT_VO[]
	 */
    public IfFtCondVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IF_CHG_FT_VO[]
	 */
    public IfFtCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        IfFtCondVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] cntrNo = (JSPUtil.getParameter(request, prefix + "cntr_no", length));
            String[] fmMvmtDt = (JSPUtil.getParameter(request, prefix + "fm_mvmt_dt", length));
            String[] fmMvmtYdCd = (JSPUtil.getParameter(request, prefix + "fm_mvmt_yd_cd", length));
            String[] fmMvmtStsCd = (JSPUtil.getParameter(request, prefix + "fm_mvmt_sts_cd", length));
            String[] dmdtChgLocDivCd = (JSPUtil.getParameter(request, prefix + "dmdt_chg_loc_div_cd", length));
            String[] inlndFlg = (JSPUtil.getParameter(request, prefix + "inlnd_flg", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new IfFtCondVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (cntrNo[i] != null)
                    model.setCntrNo(cntrNo[i]);
                if (fmMvmtDt[i] != null)
                    model.setFmMvmtDt(fmMvmtDt[i]);
                if (fmMvmtYdCd[i] != null)
                    model.setFmMvmtYdCd(fmMvmtYdCd[i]);
                if (fmMvmtStsCd[i] != null)
                    model.setFmMvmtStsCd(fmMvmtStsCd[i]);
                if (dmdtChgLocDivCd[i] != null)
                    model.setDmdtChgLocDivCd(dmdtChgLocDivCd[i]);
                if (inlndFlg[i] != null) 
		    		model.setInlndFlg(inlndFlg[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getIF_CHG_FT_VOs();
    }

    /**
	 * VO 배열을 반환
	 * @return IF_CHG_FT_VO[]
	 */
    public IfFtCondVO[] getIF_CHG_FT_VOs() {
        IfFtCondVO[] vos = (IfFtCondVO[]) models.toArray(new IfFtCondVO[models.size()]);
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
        this.fmMvmtDt = this.fmMvmtDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fmMvmtYdCd = this.fmMvmtYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fmMvmtStsCd = this.fmMvmtStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtChgLocDivCd = this.dmdtChgLocDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inlndFlg = this.inlndFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
