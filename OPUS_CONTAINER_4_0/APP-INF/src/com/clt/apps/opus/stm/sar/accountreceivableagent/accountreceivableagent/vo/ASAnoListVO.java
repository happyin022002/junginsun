/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ASAnoListVO.java
*@FileTitle : ASAnoListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.17  
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo;

import java.lang.reflect.Field;
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
public class ASAnoListVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<ASAnoListVO> models = new ArrayList<ASAnoListVO>();

    /* Column Info */
    private String bilCrePrdFmDt = null;

    /* Column Info */
    private String asaNo1 = null;

    /* Column Info */
    private String asaNo3 = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String currCd = null;

    /* Column Info */
    private String asaNo2 = null;

    /* Column Info */
    private String bilCrePrdToDt = null;

    /* Column Info */
    private String asaNo = null;

    /* Column Info */
    private String flagCd = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String dpPrcsKnt = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public ASAnoListVO() {
    }

    public ASAnoListVO(String ibflag, String pagerows, String asaNo, String asaNo1, String asaNo2, String asaNo3, String bilCrePrdFmDt, String bilCrePrdToDt, String currCd, String flagCd, String dpPrcsKnt) {
        this.bilCrePrdFmDt = bilCrePrdFmDt;
        this.asaNo1 = asaNo1;
        this.asaNo3 = asaNo3;
        this.ibflag = ibflag;
        this.currCd = currCd;
        this.asaNo2 = asaNo2;
        this.bilCrePrdToDt = bilCrePrdToDt;
        this.asaNo = asaNo;
        this.flagCd = flagCd;
        this.pagerows = pagerows;
        this.dpPrcsKnt = dpPrcsKnt;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("bil_cre_prd_fm_dt", getBilCrePrdFmDt());
        this.hashColumns.put("asa_no1", getAsaNo1());
        this.hashColumns.put("asa_no3", getAsaNo3());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("curr_cd", getCurrCd());
        this.hashColumns.put("asa_no2", getAsaNo2());
        this.hashColumns.put("bil_cre_prd_to_dt", getBilCrePrdToDt());
        this.hashColumns.put("asa_no", getAsaNo());
        this.hashColumns.put("flag_cd", getFlagCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("dp_prcs_knt", getDpPrcsKnt());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("bil_cre_prd_fm_dt", "bilCrePrdFmDt");
        this.hashFields.put("asa_no1", "asaNo1");
        this.hashFields.put("asa_no3", "asaNo3");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("curr_cd", "currCd");
        this.hashFields.put("asa_no2", "asaNo2");
        this.hashFields.put("bil_cre_prd_to_dt", "bilCrePrdToDt");
        this.hashFields.put("asa_no", "asaNo");
        this.hashFields.put("flag_cd", "flagCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("dp_prcs_knt", "dpPrcsKnt");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return bilCrePrdFmDt
	 */
    public String getBilCrePrdFmDt() {
        return this.bilCrePrdFmDt;
    }

    /**
	 * Column Info
	 * @return asaNo1
	 */
    public String getAsaNo1() {
        return this.asaNo1;
    }

    /**
	 * Column Info
	 * @return asaNo3
	 */
    public String getAsaNo3() {
        return this.asaNo3;
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
	 * @return currCd
	 */
    public String getCurrCd() {
        return this.currCd;
    }

    /**
	 * Column Info
	 * @return asaNo2
	 */
    public String getAsaNo2() {
        return this.asaNo2;
    }

    /**
	 * Column Info
	 * @return bilCrePrdToDt
	 */
    public String getBilCrePrdToDt() {
        return this.bilCrePrdToDt;
    }

    /**
	 * Column Info
	 * @return asaNo
	 */
    public String getAsaNo() {
        return this.asaNo;
    }

    /**
	 * Column Info
	 * @return flagCd
	 */
    public String getFlagCd() {
        return this.flagCd;
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
	 * @param bilCrePrdFmDt
	 */
    public void setBilCrePrdFmDt(String bilCrePrdFmDt) {
        this.bilCrePrdFmDt = bilCrePrdFmDt;
    }

    /**
	 * Column Info
	 * @param asaNo1
	 */
    public void setAsaNo1(String asaNo1) {
        this.asaNo1 = asaNo1;
    }

    /**
	 * Column Info
	 * @param asaNo3
	 */
    public void setAsaNo3(String asaNo3) {
        this.asaNo3 = asaNo3;
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
	 * @param currCd
	 */
    public void setCurrCd(String currCd) {
        this.currCd = currCd;
    }

    /**
	 * Column Info
	 * @param asaNo2
	 */
    public void setAsaNo2(String asaNo2) {
        this.asaNo2 = asaNo2;
    }

    /**
	 * Column Info
	 * @param bilCrePrdToDt
	 */
    public void setBilCrePrdToDt(String bilCrePrdToDt) {
        this.bilCrePrdToDt = bilCrePrdToDt;
    }

    /**
	 * Column Info
	 * @param asaNo
	 */
    public void setAsaNo(String asaNo) {
        this.asaNo = asaNo;
    }

    /**
	 * Column Info
	 * @param flagCd
	 */
    public void setFlagCd(String flagCd) {
        this.flagCd = flagCd;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    public void setDpPrcsKnt(String dpPrcsKnt) {
        this.dpPrcsKnt = dpPrcsKnt;
    }

    public String getDpPrcsKnt() {
        return this.dpPrcsKnt;
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
        setBilCrePrdFmDt(JSPUtil.getParameter(request, prefix + "bil_cre_prd_fm_dt", ""));
        setAsaNo1(JSPUtil.getParameter(request, prefix + "asa_no1", ""));
        setAsaNo3(JSPUtil.getParameter(request, prefix + "asa_no3", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
        setAsaNo2(JSPUtil.getParameter(request, prefix + "asa_no2", ""));
        setBilCrePrdToDt(JSPUtil.getParameter(request, prefix + "bil_cre_prd_to_dt", ""));
        setAsaNo(JSPUtil.getParameter(request, prefix + "asa_no", ""));
        setFlagCd(JSPUtil.getParameter(request, prefix + "flag_cd", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setDpPrcsKnt(JSPUtil.getParameter(request, prefix + "dp_prcs_knt", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ASAnoListVO[]
	 */
    public ASAnoListVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ASAnoListVO[]
	 */
    public ASAnoListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        ASAnoListVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] bilCrePrdFmDt = (JSPUtil.getParameter(request, prefix + "bil_cre_prd_fm_dt", length));
            String[] asaNo1 = (JSPUtil.getParameter(request, prefix + "asa_no1", length));
            String[] asaNo3 = (JSPUtil.getParameter(request, prefix + "asa_no3", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] currCd = (JSPUtil.getParameter(request, prefix + "curr_cd", length));
            String[] asaNo2 = (JSPUtil.getParameter(request, prefix + "asa_no2", length));
            String[] bilCrePrdToDt = (JSPUtil.getParameter(request, prefix + "bil_cre_prd_to_dt", length));
            String[] asaNo = (JSPUtil.getParameter(request, prefix + "asa_no", length));
            String[] flagCd = (JSPUtil.getParameter(request, prefix + "flag_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] dpPrcsKnt = (JSPUtil.getParameter(request, prefix + "dp_prcs_knt", length));
            for (int i = 0; i < length; i++) {
                model = new ASAnoListVO();
                if (bilCrePrdFmDt[i] != null)
                    model.setBilCrePrdFmDt(bilCrePrdFmDt[i]);
                if (asaNo1[i] != null)
                    model.setAsaNo1(asaNo1[i]);
                if (asaNo3[i] != null)
                    model.setAsaNo3(asaNo3[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (currCd[i] != null)
                    model.setCurrCd(currCd[i]);
                if (asaNo2[i] != null)
                    model.setAsaNo2(asaNo2[i]);
                if (bilCrePrdToDt[i] != null)
                    model.setBilCrePrdToDt(bilCrePrdToDt[i]);
                if (asaNo[i] != null)
                    model.setAsaNo(asaNo[i]);
                if (flagCd[i] != null)
                    model.setFlagCd(flagCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (dpPrcsKnt[i] != null)
                    model.setDpPrcsKnt(dpPrcsKnt[i]);
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getASAnoListVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return ASAnoListVO[]
	 */
    public ASAnoListVO[] getASAnoListVOs() {
        ASAnoListVO[] vos = (ASAnoListVO[]) models.toArray(new ASAnoListVO[models.size()]);
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
        this.bilCrePrdFmDt = this.bilCrePrdFmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.asaNo1 = this.asaNo1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.asaNo3 = this.asaNo3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.currCd = this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.asaNo2 = this.asaNo2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bilCrePrdToDt = this.bilCrePrdToDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.asaNo = this.asaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.flagCd = this.flagCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dpPrcsKnt = this.dpPrcsKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
