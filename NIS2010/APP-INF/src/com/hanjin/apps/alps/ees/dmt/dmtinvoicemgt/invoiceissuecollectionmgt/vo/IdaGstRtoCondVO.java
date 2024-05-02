/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : IdaGstRtoCondVO.java
*@FileTitle : IdaGstRtoCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.27
*@LastModifier : 
*@LastVersion : 1.0
* 2017.07.27 
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
public class IdaGstRtoCondVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<IdaGstRtoCondVO> models = new ArrayList<IdaGstRtoCondVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String ofcCd = null;

    /* Column Info */
    private String custVndrDivCd = null;

    /* Column Info */
    private String custCntCd = null;

    /* Column Info */
    private String custSeq = null;

    /* Column Info */
    private String vndrSeq = null;

    /* Column Info */
    private String portCd = null;

    /* Column Info */
    private String idaTaxDivCd = null;

    /* Column Info */
    private String condIdaSacCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public IdaGstRtoCondVO() {
    }

    public IdaGstRtoCondVO(String ibflag, String pagerows, String ofcCd, String custVndrDivCd, String custCntCd, String custSeq, String vndrSeq, String portCd, String idaTaxDivCd, String condIdaSacCd) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.ofcCd = ofcCd;
        this.custVndrDivCd = custVndrDivCd;
        this.custCntCd = custCntCd;
        this.custSeq = custSeq;
        this.vndrSeq = vndrSeq;
        this.portCd = portCd;
        this.idaTaxDivCd = idaTaxDivCd;
        this.condIdaSacCd = condIdaSacCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("ofc_cd", getOfcCd());
        this.hashColumns.put("cust_vndr_div_cd", getCustVndrDivCd());
        this.hashColumns.put("cust_cnt_cd", getCustCntCd());
        this.hashColumns.put("cust_seq", getCustSeq());
        this.hashColumns.put("vndr_seq", getVndrSeq());
        this.hashColumns.put("port_cd", getPortCd());
        this.hashColumns.put("ida_tax_div_cd", getIdaTaxDivCd());
        this.hashColumns.put("cond_ida_sac_cd", getCondIdaSacCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("ofc_cd", "ofcCd");
        this.hashFields.put("cust_vndr_div_cd", "custVndrDivCd");
        this.hashFields.put("cust_cnt_cd", "custCntCd");
        this.hashFields.put("cust_seq", "custSeq");
        this.hashFields.put("vndr_seq", "vndrSeq");
        this.hashFields.put("port_cd", "portCd");
        this.hashFields.put("ida_tax_div_cd", "idaTaxDivCd");
        this.hashFields.put("cond_ida_sac_cd", "condIdaSacCd");
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
	 * @param String custVndrDivCd
	 */
    public void setCustVndrDivCd(String custVndrDivCd) {
        this.custVndrDivCd = custVndrDivCd;
    }

    /**
	 * 
	 * @return String custVndrDivCd
	 */
    public String getCustVndrDivCd() {
        return this.custVndrDivCd;
    }

    /**
	 *
	 * @param String custCntCd
	 */
    public void setCustCntCd(String custCntCd) {
        this.custCntCd = custCntCd;
    }

    /**
	 * 
	 * @return String custCntCd
	 */
    public String getCustCntCd() {
        return this.custCntCd;
    }

    /**
	 *
	 * @param String custSeq
	 */
    public void setCustSeq(String custSeq) {
        this.custSeq = custSeq;
    }

    /**
	 * 
	 * @return String custSeq
	 */
    public String getCustSeq() {
        return this.custSeq;
    }

    /**
	 *
	 * @param String vndrSeq
	 */
    public void setVndrSeq(String vndrSeq) {
        this.vndrSeq = vndrSeq;
    }

    /**
	 * 
	 * @return String vndrSeq
	 */
    public String getVndrSeq() {
        return this.vndrSeq;
    }

    /**
	 *
	 * @param String portCd
	 */
    public void setPortCd(String portCd) {
        this.portCd = portCd;
    }

    /**
	 * 
	 * @return String portCd
	 */
    public String getPortCd() {
        return this.portCd;
    }

    public void setIdaTaxDivCd(String idaTaxDivCd) {
        this.idaTaxDivCd = idaTaxDivCd;
    }

    public String getIdaTaxDivCd() {
        return this.idaTaxDivCd;
    }

    public void setCondIdaSacCd(String condIdaSacCd) {
        this.condIdaSacCd = condIdaSacCd;
    }

    public String getCondIdaSacCd() {
        return this.condIdaSacCd;
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
        setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
        setCustVndrDivCd(JSPUtil.getParameter(request, prefix + "cust_vndr_div_cd", ""));
        setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
        setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
        setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
        setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
        setIdaTaxDivCd(JSPUtil.getParameter(request, prefix + "ida_tax_div_cd", ""));
        setCondIdaSacCd(JSPUtil.getParameter(request, prefix + "cond_ida_sac_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IdaGstRtoCondVO[]
	 */
    public IdaGstRtoCondVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IdaGstRtoCondVO[]
	 */
    public IdaGstRtoCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        IdaGstRtoCondVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] ofcCd = (JSPUtil.getParameter(request, prefix + "ofc_cd", length));
            String[] custVndrDivCd = (JSPUtil.getParameter(request, prefix + "cust_vndr_div_cd", length));
            String[] custCntCd = (JSPUtil.getParameter(request, prefix + "cust_cnt_cd", length));
            String[] custSeq = (JSPUtil.getParameter(request, prefix + "cust_seq", length));
            String[] vndrSeq = (JSPUtil.getParameter(request, prefix + "vndr_seq", length));
            String[] portCd = (JSPUtil.getParameter(request, prefix + "port_cd", length));
            String[] idaTaxDivCd = (JSPUtil.getParameter(request, prefix + "ida_tax_div_cd", length));
            String[] condIdaSacCd = (JSPUtil.getParameter(request, prefix + "cond_ida_sac_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new IdaGstRtoCondVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (ofcCd[i] != null)
                    model.setOfcCd(ofcCd[i]);
                if (custVndrDivCd[i] != null)
                    model.setCustVndrDivCd(custVndrDivCd[i]);
                if (custCntCd[i] != null)
                    model.setCustCntCd(custCntCd[i]);
                if (custSeq[i] != null)
                    model.setCustSeq(custSeq[i]);
                if (vndrSeq[i] != null)
                    model.setVndrSeq(vndrSeq[i]);
                if (portCd[i] != null)
                    model.setPortCd(portCd[i]);
                if (idaTaxDivCd[i] != null)
                    model.setIdaTaxDivCd(idaTaxDivCd[i]);
                if (condIdaSacCd[i] != null) 
		    		model.setCondIdaSacCd(condIdaSacCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getIdaGstRtoCondVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return IdaGstRtoCondVO[]
	 */
    public IdaGstRtoCondVO[] getIdaGstRtoCondVOs() {
        IdaGstRtoCondVO[] vos = (IdaGstRtoCondVO[]) models.toArray(new IdaGstRtoCondVO[models.size()]);
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
        this.ofcCd = this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custVndrDivCd = this.custVndrDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCntCd = this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custSeq = this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrSeq = this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.portCd = this.portCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaTaxDivCd = this.idaTaxDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.condIdaSacCd = this.condIdaSacCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
