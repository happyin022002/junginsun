/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChargeByBookingCustomerCntrVO.java
*@FileTitle : ChargeByBookingCustomerCntrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.06
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2010.01.06 최성환 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo;

import java.lang.reflect.Field;
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
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최성환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class ChargeByBookingCustomerCntrVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<ChargeByBookingCustomerCntrVO> models = new ArrayList<ChargeByBookingCustomerCntrVO>();

    /* Column Info */
    private String xcldSatFlg = null;

    /* Column Info */
    private String xcldSunFlg = null;

    /* Column Info */
    private String bzcTrfCurrCd = null;

    /* Column Info */
    private String cntrRtAmt = null;

    /* Column Info */
    private String currCd = null;

    /* Column Info */
    private String msgDesc = null;

    /* Column Info */
    private String ftDysCalc = null;

    /* Column Info */
    private String bilAmt = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String podCd = null;

    /* Column Info */
    private String fxFtOvrDys = null;

    /* Column Info */
    private String msgCd = null;

    /* Column Info */
    private String bkgNo = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String ftDys = null;

    /* Column Info */
    private String cntrNo = null;

    /* Column Info */
    private String expDelDt = null;

    /* Column Info */
    private String ftEndDt = null;

    /* Column Info */
    private String xcldHolFlg = null;

    /* Column Info */
    private String dmdtTrfCd = null;

    /* Column Info */
    private String cntrTpszCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public ChargeByBookingCustomerCntrVO() {
    }

    public ChargeByBookingCustomerCntrVO(String ibflag, String pagerows, String cntrNo, String fxFtOvrDys, String bzcTrfCurrCd, String bilAmt, String ftDys, String xcldSatFlg, String xcldSunFlg, String xcldHolFlg, String currCd, String cntrRtAmt, String ftDysCalc, String ftEndDt, String bkgNo, String dmdtTrfCd, String podCd, String expDelDt, String msgCd, String msgDesc, String cntrTpszCd) {
        this.xcldSatFlg = xcldSatFlg;
        this.xcldSunFlg = xcldSunFlg;
        this.bzcTrfCurrCd = bzcTrfCurrCd;
        this.cntrRtAmt = cntrRtAmt;
        this.currCd = currCd;
        this.msgDesc = msgDesc;
        this.ftDysCalc = ftDysCalc;
        this.bilAmt = bilAmt;
        this.pagerows = pagerows;
        this.podCd = podCd;
        this.fxFtOvrDys = fxFtOvrDys;
        this.msgCd = msgCd;
        this.bkgNo = bkgNo;
        this.ibflag = ibflag;
        this.ftDys = ftDys;
        this.cntrNo = cntrNo;
        this.expDelDt = expDelDt;
        this.ftEndDt = ftEndDt;
        this.xcldHolFlg = xcldHolFlg;
        this.dmdtTrfCd = dmdtTrfCd;
        this.cntrTpszCd = cntrTpszCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("xcld_sat_flg", getXcldSatFlg());
        this.hashColumns.put("xcld_sun_flg", getXcldSunFlg());
        this.hashColumns.put("bzc_trf_curr_cd", getBzcTrfCurrCd());
        this.hashColumns.put("cntr_rt_amt", getCntrRtAmt());
        this.hashColumns.put("curr_cd", getCurrCd());
        this.hashColumns.put("msg_desc", getMsgDesc());
        this.hashColumns.put("ft_dys_calc", getFtDysCalc());
        this.hashColumns.put("bil_amt", getBilAmt());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("fx_ft_ovr_dys", getFxFtOvrDys());
        this.hashColumns.put("msg_cd", getMsgCd());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("ft_dys", getFtDys());
        this.hashColumns.put("cntr_no", getCntrNo());
        this.hashColumns.put("exp_del_dt", getExpDelDt());
        this.hashColumns.put("ft_end_dt", getFtEndDt());
        this.hashColumns.put("xcld_hol_flg", getXcldHolFlg());
        this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
        this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("xcld_sat_flg", "xcldSatFlg");
        this.hashFields.put("xcld_sun_flg", "xcldSunFlg");
        this.hashFields.put("bzc_trf_curr_cd", "bzcTrfCurrCd");
        this.hashFields.put("cntr_rt_amt", "cntrRtAmt");
        this.hashFields.put("curr_cd", "currCd");
        this.hashFields.put("msg_desc", "msgDesc");
        this.hashFields.put("ft_dys_calc", "ftDysCalc");
        this.hashFields.put("bil_amt", "bilAmt");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("fx_ft_ovr_dys", "fxFtOvrDys");
        this.hashFields.put("msg_cd", "msgCd");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("ft_dys", "ftDys");
        this.hashFields.put("cntr_no", "cntrNo");
        this.hashFields.put("exp_del_dt", "expDelDt");
        this.hashFields.put("ft_end_dt", "ftEndDt");
        this.hashFields.put("xcld_hol_flg", "xcldHolFlg");
        this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
        this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return xcldSatFlg
	 */
    public String getXcldSatFlg() {
        return this.xcldSatFlg;
    }

    /**
	 * Column Info
	 * @return xcldSunFlg
	 */
    public String getXcldSunFlg() {
        return this.xcldSunFlg;
    }

    /**
	 * Column Info
	 * @return bzcTrfCurrCd
	 */
    public String getBzcTrfCurrCd() {
        return this.bzcTrfCurrCd;
    }

    /**
	 * Column Info
	 * @return cntrRtAmt
	 */
    public String getCntrRtAmt() {
        return this.cntrRtAmt;
    }

    /**
	 * Column Info
	 * @return currCd
	 */
    public String getCurrCd() {
        return this.currCd;
    }

    /**
	 * Column Info
	 * @return msgDesc
	 */
    public String getMsgDesc() {
        return this.msgDesc;
    }

    /**
	 * Column Info
	 * @return ftDysCalc
	 */
    public String getFtDysCalc() {
        return this.ftDysCalc;
    }

    /**
	 * Column Info
	 * @return bilAmt
	 */
    public String getBilAmt() {
        return this.bilAmt;
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
	 * @return podCd
	 */
    public String getPodCd() {
        return this.podCd;
    }

    /**
	 * Column Info
	 * @return fxFtOvrDys
	 */
    public String getFxFtOvrDys() {
        return this.fxFtOvrDys;
    }

    /**
	 * Column Info
	 * @return msgCd
	 */
    public String getMsgCd() {
        return this.msgCd;
    }

    /**
	 * Column Info
	 * @return bkgNo
	 */
    public String getBkgNo() {
        return this.bkgNo;
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
	 * @return ftDys
	 */
    public String getFtDys() {
        return this.ftDys;
    }

    /**
	 * Column Info
	 * @return cntrNo
	 */
    public String getCntrNo() {
        return this.cntrNo;
    }

    /**
	 * Column Info
	 * @return expDelDt
	 */
    public String getExpDelDt() {
        return this.expDelDt;
    }

    /**
	 * Column Info
	 * @return ftEndDt
	 */
    public String getFtEndDt() {
        return this.ftEndDt;
    }

    /**
	 * Column Info
	 * @return xcldHolFlg
	 */
    public String getXcldHolFlg() {
        return this.xcldHolFlg;
    }

    /**
	 * Column Info
	 * @return dmdtTrfCd
	 */
    public String getDmdtTrfCd() {
        return this.dmdtTrfCd;
    }

    /**
	 * Column Info
	 * @param xcldSatFlg
	 */
    public void setXcldSatFlg(String xcldSatFlg) {
        this.xcldSatFlg = xcldSatFlg;
    }

    /**
	 * Column Info
	 * @param xcldSunFlg
	 */
    public void setXcldSunFlg(String xcldSunFlg) {
        this.xcldSunFlg = xcldSunFlg;
    }

    /**
	 * Column Info
	 * @param bzcTrfCurrCd
	 */
    public void setBzcTrfCurrCd(String bzcTrfCurrCd) {
        this.bzcTrfCurrCd = bzcTrfCurrCd;
    }

    /**
	 * Column Info
	 * @param cntrRtAmt
	 */
    public void setCntrRtAmt(String cntrRtAmt) {
        this.cntrRtAmt = cntrRtAmt;
    }

    /**
	 * Column Info
	 * @param currCd
	 */
    public void setCurrCd(String currCd) {
        this.currCd = currCd;
    }

    /**
	 * Column Info
	 * @param msgDesc
	 */
    public void setMsgDesc(String msgDesc) {
        this.msgDesc = msgDesc;
    }

    /**
	 * Column Info
	 * @param ftDysCalc
	 */
    public void setFtDysCalc(String ftDysCalc) {
        this.ftDysCalc = ftDysCalc;
    }

    /**
	 * Column Info
	 * @param bilAmt
	 */
    public void setBilAmt(String bilAmt) {
        this.bilAmt = bilAmt;
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
	 * @param podCd
	 */
    public void setPodCd(String podCd) {
        this.podCd = podCd;
    }

    /**
	 * Column Info
	 * @param fxFtOvrDys
	 */
    public void setFxFtOvrDys(String fxFtOvrDys) {
        this.fxFtOvrDys = fxFtOvrDys;
    }

    /**
	 * Column Info
	 * @param msgCd
	 */
    public void setMsgCd(String msgCd) {
        this.msgCd = msgCd;
    }

    /**
	 * Column Info
	 * @param bkgNo
	 */
    public void setBkgNo(String bkgNo) {
        this.bkgNo = bkgNo;
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
	 * @param ftDys
	 */
    public void setFtDys(String ftDys) {
        this.ftDys = ftDys;
    }

    /**
	 * Column Info
	 * @param cntrNo
	 */
    public void setCntrNo(String cntrNo) {
        this.cntrNo = cntrNo;
    }

    /**
	 * Column Info
	 * @param expDelDt
	 */
    public void setExpDelDt(String expDelDt) {
        this.expDelDt = expDelDt;
    }

    /**
	 * Column Info
	 * @param ftEndDt
	 */
    public void setFtEndDt(String ftEndDt) {
        this.ftEndDt = ftEndDt;
    }

    /**
	 * Column Info
	 * @param xcldHolFlg
	 */
    public void setXcldHolFlg(String xcldHolFlg) {
        this.xcldHolFlg = xcldHolFlg;
    }

    /**
	 * Column Info
	 * @param dmdtTrfCd
	 */
    public void setDmdtTrfCd(String dmdtTrfCd) {
        this.dmdtTrfCd = dmdtTrfCd;
    }

    public void setCntrTpszCd(String cntrTpszCd) {
        this.cntrTpszCd = cntrTpszCd;
    }

    public String getCntrTpszCd() {
        return this.cntrTpszCd;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setXcldSatFlg(JSPUtil.getParameter(request, "xcld_sat_flg", ""));
        setXcldSunFlg(JSPUtil.getParameter(request, "xcld_sun_flg", ""));
        setBzcTrfCurrCd(JSPUtil.getParameter(request, "bzc_trf_curr_cd", ""));
        setCntrRtAmt(JSPUtil.getParameter(request, "cntr_rt_amt", ""));
        setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
        setMsgDesc(JSPUtil.getParameter(request, "msg_desc", ""));
        setFtDysCalc(JSPUtil.getParameter(request, "ft_dys_calc", ""));
        setBilAmt(JSPUtil.getParameter(request, "bil_amt", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
        setFxFtOvrDys(JSPUtil.getParameter(request, "fx_ft_ovr_dys", ""));
        setMsgCd(JSPUtil.getParameter(request, "msg_cd", ""));
        setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setFtDys(JSPUtil.getParameter(request, "ft_dys", ""));
        setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
        setExpDelDt(JSPUtil.getParameter(request, "exp_del_dt", ""));
        setFtEndDt(JSPUtil.getParameter(request, "ft_end_dt", ""));
        setXcldHolFlg(JSPUtil.getParameter(request, "xcld_hol_flg", ""));
        setDmdtTrfCd(JSPUtil.getParameter(request, "dmdt_trf_cd", ""));
        setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChargeByBookingCustomerCntrVO[]
	 */
    public ChargeByBookingCustomerCntrVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ChargeByBookingCustomerCntrVO[]
	 */
    public ChargeByBookingCustomerCntrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        ChargeByBookingCustomerCntrVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] xcldSatFlg = (JSPUtil.getParameter(request, prefix + "xcld_sat_flg", length));
            String[] xcldSunFlg = (JSPUtil.getParameter(request, prefix + "xcld_sun_flg", length));
            String[] bzcTrfCurrCd = (JSPUtil.getParameter(request, prefix + "bzc_trf_curr_cd", length));
            String[] cntrRtAmt = (JSPUtil.getParameter(request, prefix + "cntr_rt_amt", length));
            String[] currCd = (JSPUtil.getParameter(request, prefix + "curr_cd", length));
            String[] msgDesc = (JSPUtil.getParameter(request, prefix + "msg_desc", length));
            String[] ftDysCalc = (JSPUtil.getParameter(request, prefix + "ft_dys_calc", length));
            String[] bilAmt = (JSPUtil.getParameter(request, prefix + "bil_amt", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
            String[] fxFtOvrDys = (JSPUtil.getParameter(request, prefix + "fx_ft_ovr_dys", length));
            String[] msgCd = (JSPUtil.getParameter(request, prefix + "msg_cd", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] ftDys = (JSPUtil.getParameter(request, prefix + "ft_dys", length));
            String[] cntrNo = (JSPUtil.getParameter(request, prefix + "cntr_no", length));
            String[] expDelDt = (JSPUtil.getParameter(request, prefix + "exp_del_dt", length));
            String[] ftEndDt = (JSPUtil.getParameter(request, prefix + "ft_end_dt", length));
            String[] xcldHolFlg = (JSPUtil.getParameter(request, prefix + "xcld_hol_flg", length));
            String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix + "dmdt_trf_cd", length));
            String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", length));
            for (int i = 0; i < length; i++) {
                model = new ChargeByBookingCustomerCntrVO();
                if (xcldSatFlg[i] != null)
                    model.setXcldSatFlg(xcldSatFlg[i]);
                if (xcldSunFlg[i] != null)
                    model.setXcldSunFlg(xcldSunFlg[i]);
                if (bzcTrfCurrCd[i] != null)
                    model.setBzcTrfCurrCd(bzcTrfCurrCd[i]);
                if (cntrRtAmt[i] != null)
                    model.setCntrRtAmt(cntrRtAmt[i]);
                if (currCd[i] != null)
                    model.setCurrCd(currCd[i]);
                if (msgDesc[i] != null)
                    model.setMsgDesc(msgDesc[i]);
                if (ftDysCalc[i] != null)
                    model.setFtDysCalc(ftDysCalc[i]);
                if (bilAmt[i] != null)
                    model.setBilAmt(bilAmt[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (fxFtOvrDys[i] != null)
                    model.setFxFtOvrDys(fxFtOvrDys[i]);
                if (msgCd[i] != null)
                    model.setMsgCd(msgCd[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (ftDys[i] != null)
                    model.setFtDys(ftDys[i]);
                if (cntrNo[i] != null)
                    model.setCntrNo(cntrNo[i]);
                if (expDelDt[i] != null)
                    model.setExpDelDt(expDelDt[i]);
                if (ftEndDt[i] != null)
                    model.setFtEndDt(ftEndDt[i]);
                if (xcldHolFlg[i] != null)
                    model.setXcldHolFlg(xcldHolFlg[i]);
                if (dmdtTrfCd[i] != null)
                    model.setDmdtTrfCd(dmdtTrfCd[i]);
                if (cntrTpszCd[i] != null)
                    model.setCntrTpszCd(cntrTpszCd[i]);                
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getChargeByBookingCustomerCntrVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return ChargeByBookingCustomerCntrVO[]
	 */
    public ChargeByBookingCustomerCntrVO[] getChargeByBookingCustomerCntrVOs() {
        ChargeByBookingCustomerCntrVO[] vos = (ChargeByBookingCustomerCntrVO[]) models.toArray(new ChargeByBookingCustomerCntrVO[models.size()]);
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
        this.xcldSatFlg = this.xcldSatFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xcldSunFlg = this.xcldSunFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bzcTrfCurrCd = this.bzcTrfCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrRtAmt = this.cntrRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.currCd = this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.msgDesc = this.msgDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ftDysCalc = this.ftDysCalc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bilAmt = this.bilAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fxFtOvrDys = this.fxFtOvrDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.msgCd = this.msgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ftDys = this.ftDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrNo = this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.expDelDt = this.expDelDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ftEndDt = this.ftEndDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xcldHolFlg = this.xcldHolFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtTrfCd = this.dmdtTrfCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrTpszCd = this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
