/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : IndiaInvoiceNo.java
*@FileTitle : IndiaInvoiceNo
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.05
*@LastModifier : 
*@LastVersion : 1.0
* 2017.09.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo;

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
public class IndiaInvoiceNo extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<IndiaInvoiceNo> models = new ArrayList<IndiaInvoiceNo>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String ofcCtyCd = null;

    /* Column Info */
    private String fscYr = null;

    /* Column Info */
    private String usrId = null;

    /* Column Info */
    private String mdlId = null;

    /* Column Info */
    private String serNoDivCd = null;

    /* Column Info */
    private String serNoDivSeq = null;

    /* Column Info */
    private String serNoSeq = null;

    /* Column Info */
    private String dmdtInvNo = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public IndiaInvoiceNo() {
    }

    public IndiaInvoiceNo(String ibflag, String pagerows, String invNoSeq, String ofcCtyCd, String fscYr, String usrId, String mdlId, String serNoDivCd, String serNoDivSeq, String serNoSeq, String dmdtInvNo) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.ofcCtyCd = ofcCtyCd;
        this.fscYr = fscYr;
        this.usrId = usrId;
        this.mdlId = mdlId;
        this.serNoDivCd = serNoDivCd;
        this.serNoDivSeq = serNoDivSeq;
        this.serNoSeq = serNoSeq;
        this.dmdtInvNo = dmdtInvNo;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("ofc_cty_cd", getOfcCtyCd());
        this.hashColumns.put("fsc_yr", getFscYr());
        this.hashColumns.put("usr_id", getUsrId());
        this.hashColumns.put("mdl_id", getMdlId());
        this.hashColumns.put("ser_no_div_cd", getSerNoDivCd());
        this.hashColumns.put("ser_no_div_seq", getSerNoDivSeq());
        this.hashColumns.put("ser_no_seq", getSerNoSeq());
        this.hashColumns.put("dmdt_inv_no", getDmdtInvNo());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("ofc_cty_cd", "ofcCtyCd");
        this.hashFields.put("fsc_yr", "fscYr");
        this.hashFields.put("usr_id", "usrId");
        this.hashFields.put("mdl_id", "mdlId");
        this.hashFields.put("ser_no_div_cd", "serNoDivCd");
        this.hashFields.put("ser_no_div_seq", "serNoDivSeq");
        this.hashFields.put("ser_no_seq", "serNoSeq");
        this.hashFields.put("dmdt_inv_no", "dmdtInvNo");
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
	 * @param String ofcCtyCd
	 */
    public void setOfcCtyCd(String ofcCtyCd) {
        this.ofcCtyCd = ofcCtyCd;
    }

    /**
	 * 
	 * @return String ofcCtyCd
	 */
    public String getOfcCtyCd() {
        return this.ofcCtyCd;
    }

    /**
	 *
	 * @param String fscYr
	 */
    public void setFscYr(String fscYr) {
        this.fscYr = fscYr;
    }

    /**
	 * 
	 * @return String fscYr
	 */
    public String getFscYr() {
        return this.fscYr;
    }

    /**
	 *
	 * @param String usrId
	 */
    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

    /**
	 * 
	 * @return String usrId
	 */
    public String getUsrId() {
        return this.usrId;
    }

    public void setMdlId(String mdlId) {
        this.mdlId = mdlId;
    }

    public String getMdlId() {
        return this.mdlId;
    }

    public void setSerNoDivCd(String serNoDivCd) {
        this.serNoDivCd = serNoDivCd;
    }

    public String getSerNoDivCd() {
        return this.serNoDivCd;
    }

    public void setSerNoDivSeq(String serNoDivSeq) {
        this.serNoDivSeq = serNoDivSeq;
    }

    public String getSerNoDivSeq() {
        return this.serNoDivSeq;
    }

    public void setSerNoSeq(String serNoSeq) {
        this.serNoSeq = serNoSeq;
    }

    public String getSerNoSeq() {
        return this.serNoSeq;
    }

    public void setDmdtInvNo(String dmdtInvNo) {
        this.dmdtInvNo = dmdtInvNo;
    }

    public String getDmdtInvNo() {
        return this.dmdtInvNo;
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
        setOfcCtyCd(JSPUtil.getParameter(request, prefix + "ofc_cty_cd", ""));
        setFscYr(JSPUtil.getParameter(request, prefix + "fsc_yr", ""));
        setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
        setMdlId(JSPUtil.getParameter(request, prefix + "mdl_id", ""));
        setSerNoDivCd(JSPUtil.getParameter(request, prefix + "ser_no_div_cd", ""));
        setSerNoDivSeq(JSPUtil.getParameter(request, prefix + "ser_no_div_seq", ""));
        setSerNoSeq(JSPUtil.getParameter(request, prefix + "ser_no_seq", ""));
        setDmdtInvNo(JSPUtil.getParameter(request, prefix + "dmdt_inv_no", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IndiaInvoiceNo[]
	 */
    public IndiaInvoiceNo[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IndiaInvoiceNo[]
	 */
    public IndiaInvoiceNo[] fromRequestGrid(HttpServletRequest request, String prefix) {
        IndiaInvoiceNo model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] invNoSeq = (JSPUtil.getParameter(request, prefix + "inv_no_seq", length));
            String[] ofcCtyCd = (JSPUtil.getParameter(request, prefix + "ofc_cty_cd", length));
            String[] fscYr = (JSPUtil.getParameter(request, prefix + "fsc_yr", length));
            String[] usrId = (JSPUtil.getParameter(request, prefix + "usr_id", length));
            String[] mdlId = (JSPUtil.getParameter(request, prefix + "mdl_id", length));
            String[] serNoDivCd = (JSPUtil.getParameter(request, prefix + "ser_no_div_cd", length));
            String[] serNoDivSeq = (JSPUtil.getParameter(request, prefix + "ser_no_div_seq", length));
            String[] serNoSeq = (JSPUtil.getParameter(request, prefix + "ser_no_seq", length));
            String[] dmdtInvNo = (JSPUtil.getParameter(request, prefix + "dmdt_inv_no", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new IndiaInvoiceNo();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (ofcCtyCd[i] != null)
                    model.setOfcCtyCd(ofcCtyCd[i]);
                if (fscYr[i] != null)
                    model.setFscYr(fscYr[i]);
                if (usrId[i] != null)
                    model.setUsrId(usrId[i]);
                if (mdlId[i] != null)
                    model.setMdlId(mdlId[i]);
                if (serNoDivCd[i] != null)
                    model.setSerNoDivCd(serNoDivCd[i]);
                if (serNoDivSeq[i] != null)
                    model.setSerNoDivSeq(serNoDivSeq[i]);
                if (serNoSeq[i] != null)
                    model.setSerNoSeq(serNoSeq[i]);
                if (dmdtInvNo[i] != null) 
		    		model.setDmdtInvNo(dmdtInvNo[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getIndiaInvoiceNos();
    }

    /**
	 * VO 배열을 반환
	 * @return IndiaInvoiceNo[]
	 */
    public IndiaInvoiceNo[] getIndiaInvoiceNos() {
        IndiaInvoiceNo[] vos = (IndiaInvoiceNo[]) models.toArray(new IndiaInvoiceNo[models.size()]);
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
        this.ofcCtyCd = this.ofcCtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fscYr = this.fscYr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usrId = this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mdlId = this.mdlId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.serNoDivCd = this.serNoDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.serNoDivSeq = this.serNoDivSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.serNoSeq = this.serNoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtInvNo = this.dmdtInvNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
