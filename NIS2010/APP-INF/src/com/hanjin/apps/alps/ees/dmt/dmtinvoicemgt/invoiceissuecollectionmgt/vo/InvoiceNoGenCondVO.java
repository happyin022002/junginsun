/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : InvoiceNoGenCondVO.java
*@FileTitle : InvoiceNoGenCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.18 
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
public class InvoiceNoGenCondVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<InvoiceNoGenCondVO> models = new ArrayList<InvoiceNoGenCondVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String dmdtTrfCd = null;

    /* Column Info */
    private String usrId = null;

    /* Column Info */
    private String ofcCd = null;

    /* Column Info */
    private String dmdtInvTpCd = null;


    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public InvoiceNoGenCondVO() {
    }

    public InvoiceNoGenCondVO(String ibflag, String pagerows, String dmdtTrfCd, String usrId, String ofcCd, String dmdtInvTpCd) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.dmdtTrfCd = dmdtTrfCd;
        this.usrId = usrId;
        this.ofcCd = ofcCd;
        this.dmdtInvTpCd = dmdtInvTpCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
        this.hashColumns.put("usr_id", getUsrId());
        this.hashColumns.put("ofc_cd", getOfcCd());
        this.hashColumns.put("dmdt_inv_tp_cd", getDmdtInvTpCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
        this.hashFields.put("usr_id", "usrId");
        this.hashFields.put("ofc_cd", "ofcCd");
        this.hashFields.put("dmdt_inv_tp_cd", "dmdtInvTpCd");
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
	 * @param String dmdtTrfCd
	 */
    public void setDmdtTrfCd(String dmdtTrfCd) {
        this.dmdtTrfCd = dmdtTrfCd;
    }

    /**
	 * 
	 * @return String dmdtTrfCd
	 */
    public String getDmdtTrfCd() {
        return this.dmdtTrfCd;
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

    public void setDmdtInvTpCd(String dmdtInvTpCd) {
        this.dmdtInvTpCd = dmdtInvTpCd;
    }

    public String getDmdtInvTpCd() {
        return this.dmdtInvTpCd;
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
        setDmdtTrfCd(JSPUtil.getParameter(request, prefix + "dmdt_trf_cd", ""));
        setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
        setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
        setDmdtInvTpCd(JSPUtil.getParameter(request, prefix + "dmdt_inv_tp_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvoiceNoGenCondVO[]
	 */
    public InvoiceNoGenCondVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvoiceNoGenCondVO[]
	 */
    public InvoiceNoGenCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        InvoiceNoGenCondVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix + "dmdt_trf_cd", length));
            String[] usrId = (JSPUtil.getParameter(request, prefix + "usr_id", length));
            String[] ofcCd = (JSPUtil.getParameter(request, prefix + "ofc_cd", length));
            String[] dmdtInvTpCd = (JSPUtil.getParameter(request, prefix + "dmdt_inv_tp_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new InvoiceNoGenCondVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (dmdtTrfCd[i] != null)
                    model.setDmdtTrfCd(dmdtTrfCd[i]);
                if (usrId[i] != null)
                    model.setUsrId(usrId[i]);
                if (ofcCd[i] != null)
                    model.setOfcCd(ofcCd[i]);
                if (dmdtInvTpCd[i] != null)
                    model.setDmdtInvTpCd(dmdtInvTpCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getInvoiceNoGenCondVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return InvoiceNoGenCondVO[]
	 */
    public InvoiceNoGenCondVO[] getInvoiceNoGenCondVOs() {
        InvoiceNoGenCondVO[] vos = (InvoiceNoGenCondVO[]) models.toArray(new InvoiceNoGenCondVO[models.size()]);
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
        this.dmdtTrfCd = this.dmdtTrfCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usrId = this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcCd = this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtInvTpCd = this.dmdtInvTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
