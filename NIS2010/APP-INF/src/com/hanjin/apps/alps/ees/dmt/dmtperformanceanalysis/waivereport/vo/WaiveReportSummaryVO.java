/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WaiveReportSummaryVO.java
*@FileTitle : WaiveReportSummaryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.10
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.11.10 문중철 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.waivereport.vo;

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
 * @author 문중철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class WaiveReportSummaryVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;
    
    private Collection<WaiveReportSummaryVO> models = new ArrayList<WaiveReportSummaryVO>();
    
    /* Column Info */
    private String office = null;
    /* Column Info */
    private String localcur = null;
    /* Column Info */
    private String cuscode = null;
    /* Column Info */
    private String cntr1 = null;
    /* Column Info */
    private String incurred = null;
    /* Column Info */
    private String cntr2 = null;
    /* Column Info */
    private String cntr3 = null;
    /* Column Info */
    private String cntr4 = null;
    /* Column Info */
    private String cntr5 = null;
    /* Column Info */
    private String scno = null;
    /* Page Number */
    private String pagerows = null;
    /* Column Info */
    private String amt1 = null;
    /* Column Info */
    private String amt3 = null;
    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;
    /* Column Info */
    private String amt2 = null;
    /* Column Info */
    private String amt5 = null;
    /* Column Info */
    private String amt4 = null;
    /* Column Info */
    private String cusname = null;
    /* Column Info */
    private String tariff = null;
    /* Column Info */
    private String cur = null;
    /* Column Info */
    private String rfano = null;

    /*  테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*  테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();
    
    public WaiveReportSummaryVO() {}

    public WaiveReportSummaryVO(String ibflag, String pagerows, String office, String tariff, String scno, String rfano, String cuscode, String cusname, String cur, String localcur, String cntr1, String amt1, String cntr2, String amt2, String cntr3, String amt3, String cntr4, String amt4, String cntr5, String amt5, String incurred) {
        this.office = office;
        this.localcur = localcur;
        this.cuscode = cuscode;
        this.cntr1 = cntr1;
        this.incurred = incurred;
        this.cntr2 = cntr2;
        this.cntr3 = cntr3;
        this.cntr4 = cntr4;
        this.cntr5 = cntr5;
        this.scno = scno;
        this.pagerows = pagerows;
        this.amt1 = amt1;
        this.amt3 = amt3;
        this.ibflag = ibflag;
        this.amt2 = amt2;
        this.amt5 = amt5;
        this.amt4 = amt4;
        this.cusname = cusname;
        this.tariff = tariff;
        this.cur = cur;
        this.rfano = rfano;
    }
    
    /**
     * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
     * @return HashMap
     */
    public HashMap<String, String> getColumnValues(){
        this.hashColumns.put("office", getOffice());
        this.hashColumns.put("localcur", getLocalcur());
        this.hashColumns.put("cuscode", getCuscode());
        this.hashColumns.put("cntr1", getCntr1());
        this.hashColumns.put("incurred", getIncurred());
        this.hashColumns.put("cntr2", getCntr2());
        this.hashColumns.put("cntr3", getCntr3());
        this.hashColumns.put("cntr4", getCntr4());
        this.hashColumns.put("cntr5", getCntr5());
        this.hashColumns.put("scno", getScno());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("amt1", getAmt1());
        this.hashColumns.put("amt3", getAmt3());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("amt2", getAmt2());
        this.hashColumns.put("amt5", getAmt5());
        this.hashColumns.put("amt4", getAmt4());
        this.hashColumns.put("cusname", getCusname());
        this.hashColumns.put("tariff", getTariff());
        this.hashColumns.put("cur", getCur());
        this.hashColumns.put("rfano", getRfano());
        return this.hashColumns;
    }
    
    /**
     * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
     * @return
     */
    public HashMap<String, String> getFieldNames(){
        this.hashFields.put("office", "office");
        this.hashFields.put("localcur", "localcur");
        this.hashFields.put("cuscode", "cuscode");
        this.hashFields.put("cntr1", "cntr1");
        this.hashFields.put("incurred", "incurred");
        this.hashFields.put("cntr2", "cntr2");
        this.hashFields.put("cntr3", "cntr3");
        this.hashFields.put("cntr4", "cntr4");
        this.hashFields.put("cntr5", "cntr5");
        this.hashFields.put("scno", "scno");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("amt1", "amt1");
        this.hashFields.put("amt3", "amt3");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("amt2", "amt2");
        this.hashFields.put("amt5", "amt5");
        this.hashFields.put("amt4", "amt4");
        this.hashFields.put("cusname", "cusname");
        this.hashFields.put("tariff", "tariff");
        this.hashFields.put("cur", "cur");
        this.hashFields.put("rfano", "rfano");
        return this.hashFields;
    }
    
    /**
     * Column Info
     * @return office
     */
    public String getOffice() {
        return this.office;
    }
    
    /**
     * Column Info
     * @return localcur
     */
    public String getLocalcur() {
        return this.localcur;
    }
    
    /**
     * Column Info
     * @return cuscode
     */
    public String getCuscode() {
        return this.cuscode;
    }
    
    /**
     * Column Info
     * @return cntr1
     */
    public String getCntr1() {
        return this.cntr1;
    }
    
    /**
     * Column Info
     * @return incurred
     */
    public String getIncurred() {
        return this.incurred;
    }
    
    /**
     * Column Info
     * @return cntr2
     */
    public String getCntr2() {
        return this.cntr2;
    }
    
    /**
     * Column Info
     * @return cntr3
     */
    public String getCntr3() {
        return this.cntr3;
    }
    
    /**
     * Column Info
     * @return cntr4
     */
    public String getCntr4() {
        return this.cntr4;
    }
    
    /**
     * Column Info
     * @return cntr5
     */
    public String getCntr5() {
        return this.cntr5;
    }
    
    /**
     * Column Info
     * @return scno
     */
    public String getScno() {
        return this.scno;
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
     * @return amt1
     */
    public String getAmt1() {
        return this.amt1;
    }
    
    /**
     * Column Info
     * @return amt3
     */
    public String getAmt3() {
        return this.amt3;
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
     * @return amt2
     */
    public String getAmt2() {
        return this.amt2;
    }
    
    /**
     * Column Info
     * @return amt5
     */
    public String getAmt5() {
        return this.amt5;
    }
    
    /**
     * Column Info
     * @return amt4
     */
    public String getAmt4() {
        return this.amt4;
    }
    
    /**
     * Column Info
     * @return cusname
     */
    public String getCusname() {
        return this.cusname;
    }
    
    /**
     * Column Info
     * @return tariff
     */
    public String getTariff() {
        return this.tariff;
    }
    
    /**
     * Column Info
     * @return cur
     */
    public String getCur() {
        return this.cur;
    }
    
    /**
     * Column Info
     * @return rfano
     */
    public String getRfano() {
        return this.rfano;
    }
    

    /**
     * Column Info
     * @param office
     */
    public void setOffice(String office) {
        this.office = office;
    }
    
    /**
     * Column Info
     * @param localcur
     */
    public void setLocalcur(String localcur) {
        this.localcur = localcur;
    }
    
    /**
     * Column Info
     * @param cuscode
     */
    public void setCuscode(String cuscode) {
        this.cuscode = cuscode;
    }
    
    /**
     * Column Info
     * @param cntr1
     */
    public void setCntr1(String cntr1) {
        this.cntr1 = cntr1;
    }
    
    /**
     * Column Info
     * @param incurred
     */
    public void setIncurred(String incurred) {
        this.incurred = incurred;
    }
    
    /**
     * Column Info
     * @param cntr2
     */
    public void setCntr2(String cntr2) {
        this.cntr2 = cntr2;
    }
    
    /**
     * Column Info
     * @param cntr3
     */
    public void setCntr3(String cntr3) {
        this.cntr3 = cntr3;
    }
    
    /**
     * Column Info
     * @param cntr4
     */
    public void setCntr4(String cntr4) {
        this.cntr4 = cntr4;
    }
    
    /**
     * Column Info
     * @param cntr5
     */
    public void setCntr5(String cntr5) {
        this.cntr5 = cntr5;
    }
    
    /**
     * Column Info
     * @param scno
     */
    public void setScno(String scno) {
        this.scno = scno;
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
     * @param amt1
     */
    public void setAmt1(String amt1) {
        this.amt1 = amt1;
    }
    
    /**
     * Column Info
     * @param amt3
     */
    public void setAmt3(String amt3) {
        this.amt3 = amt3;
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
     * @param amt2
     */
    public void setAmt2(String amt2) {
        this.amt2 = amt2;
    }
    
    /**
     * Column Info
     * @param amt5
     */
    public void setAmt5(String amt5) {
        this.amt5 = amt5;
    }
    
    /**
     * Column Info
     * @param amt4
     */
    public void setAmt4(String amt4) {
        this.amt4 = amt4;
    }
    
    /**
     * Column Info
     * @param cusname
     */
    public void setCusname(String cusname) {
        this.cusname = cusname;
    }
    
    /**
     * Column Info
     * @param tariff
     */
    public void setTariff(String tariff) {
        this.tariff = tariff;
    }
    
    /**
     * Column Info
     * @param cur
     */
    public void setCur(String cur) {
        this.cur = cur;
    }
    
    /**
     * Column Info
     * @param rfano
     */
    public void setRfano(String rfano) {
        this.rfano = rfano;
    }
    
    /**
     * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
     * @param request
     */
    public void fromRequest(HttpServletRequest request) {
        setOffice(JSPUtil.getParameter(request, "office", ""));
        setLocalcur(JSPUtil.getParameter(request, "localcur", ""));
        setCuscode(JSPUtil.getParameter(request, "cuscode", ""));
        setCntr1(JSPUtil.getParameter(request, "cntr1", ""));
        setIncurred(JSPUtil.getParameter(request, "incurred", ""));
        setCntr2(JSPUtil.getParameter(request, "cntr2", ""));
        setCntr3(JSPUtil.getParameter(request, "cntr3", ""));
        setCntr4(JSPUtil.getParameter(request, "cntr4", ""));
        setCntr5(JSPUtil.getParameter(request, "cntr5", ""));
        setScno(JSPUtil.getParameter(request, "scno", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setAmt1(JSPUtil.getParameter(request, "amt1", ""));
        setAmt3(JSPUtil.getParameter(request, "amt3", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setAmt2(JSPUtil.getParameter(request, "amt2", ""));
        setAmt5(JSPUtil.getParameter(request, "amt5", ""));
        setAmt4(JSPUtil.getParameter(request, "amt4", ""));
        setCusname(JSPUtil.getParameter(request, "cusname", ""));
        setTariff(JSPUtil.getParameter(request, "tariff", ""));
        setCur(JSPUtil.getParameter(request, "cur", ""));
        setRfano(JSPUtil.getParameter(request, "rfano", ""));
    }

    /**
     * Request 의 데이터를 VO 배열로 변환하여 반환.
     * @param request
     * @return WaiveReportSummaryVO[]
     */
    public WaiveReportSummaryVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
     * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
     * @param request
     * @param prefix
     * @return WaiveReportSummaryVO[]
     */
    public WaiveReportSummaryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        WaiveReportSummaryVO model = null;
        
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if(tmp == null)
            return null;

        int length = request.getParameterValues(prefix + "ibflag").length;
  
        try {
            String[] office = (JSPUtil.getParameter(request, prefix + "office", length));
            String[] localcur = (JSPUtil.getParameter(request, prefix   + "localcur", length));
            String[] cuscode = (JSPUtil.getParameter(request, prefix    + "cuscode", length));
            String[] cntr1 = (JSPUtil.getParameter(request, prefix  + "cntr1", length));
            String[] incurred = (JSPUtil.getParameter(request, prefix   + "incurred", length));
            String[] cntr2 = (JSPUtil.getParameter(request, prefix  + "cntr2", length));
            String[] cntr3 = (JSPUtil.getParameter(request, prefix  + "cntr3", length));
            String[] cntr4 = (JSPUtil.getParameter(request, prefix  + "cntr4", length));
            String[] cntr5 = (JSPUtil.getParameter(request, prefix  + "cntr5", length));
            String[] scno = (JSPUtil.getParameter(request, prefix   + "scno", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix   + "pagerows", length));
            String[] amt1 = (JSPUtil.getParameter(request, prefix   + "amt1", length));
            String[] amt3 = (JSPUtil.getParameter(request, prefix   + "amt3", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] amt2 = (JSPUtil.getParameter(request, prefix   + "amt2", length));
            String[] amt5 = (JSPUtil.getParameter(request, prefix   + "amt5", length));
            String[] amt4 = (JSPUtil.getParameter(request, prefix   + "amt4", length));
            String[] cusname = (JSPUtil.getParameter(request, prefix    + "cusname", length));
            String[] tariff = (JSPUtil.getParameter(request, prefix + "tariff", length));
            String[] cur = (JSPUtil.getParameter(request, prefix    + "cur", length));
            String[] rfano = (JSPUtil.getParameter(request, prefix  + "rfano", length));
            
            for (int i = 0; i < length; i++) {
                model = new WaiveReportSummaryVO();
                if (office[i] != null)
                    model.setOffice(office[i]);
                if (localcur[i] != null)
                    model.setLocalcur(localcur[i]);
                if (cuscode[i] != null)
                    model.setCuscode(cuscode[i]);
                if (cntr1[i] != null)
                    model.setCntr1(cntr1[i]);
                if (incurred[i] != null)
                    model.setIncurred(incurred[i]);
                if (cntr2[i] != null)
                    model.setCntr2(cntr2[i]);
                if (cntr3[i] != null)
                    model.setCntr3(cntr3[i]);
                if (cntr4[i] != null)
                    model.setCntr4(cntr4[i]);
                if (cntr5[i] != null)
                    model.setCntr5(cntr5[i]);
                if (scno[i] != null)
                    model.setScno(scno[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (amt1[i] != null)
                    model.setAmt1(amt1[i]);
                if (amt3[i] != null)
                    model.setAmt3(amt3[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (amt2[i] != null)
                    model.setAmt2(amt2[i]);
                if (amt5[i] != null)
                    model.setAmt5(amt5[i]);
                if (amt4[i] != null)
                    model.setAmt4(amt4[i]);
                if (cusname[i] != null)
                    model.setCusname(cusname[i]);
                if (tariff[i] != null)
                    model.setTariff(tariff[i]);
                if (cur[i] != null)
                    model.setCur(cur[i]);
                if (rfano[i] != null)
                    model.setRfano(rfano[i]);
                models.add(model);
            }

        } catch (Exception e) {
            return null;
        }
        return getWaiveReportSummaryVOs();
    }

    /**
     * VO 배열을 반환
     * @return WaiveReportSummaryVO[]
     */
    public WaiveReportSummaryVO[] getWaiveReportSummaryVOs(){
        WaiveReportSummaryVO[] vos = (WaiveReportSummaryVO[])models.toArray(new WaiveReportSummaryVO[models.size()]);
        return vos;
    }
    
    /**
     * VO Class의 내용을 String으로 변환
     */
    public String toString() {
           return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
       }

    /**
    * 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
    */
    public void unDataFormat(){
        this.office = this.office .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.localcur = this.localcur .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cuscode = this.cuscode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntr1 = this.cntr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.incurred = this.incurred .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntr2 = this.cntr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntr3 = this.cntr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntr4 = this.cntr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntr5 = this.cntr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.scno = this.scno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.amt1 = this.amt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.amt3 = this.amt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.amt2 = this.amt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.amt5 = this.amt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.amt4 = this.amt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cusname = this.cusname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tariff = this.tariff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cur = this.cur .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rfano = this.rfano .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
