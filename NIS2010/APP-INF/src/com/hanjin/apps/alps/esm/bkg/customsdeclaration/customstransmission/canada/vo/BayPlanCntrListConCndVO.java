/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BayPlanCntrListConCndVO.java
*@FileTitle : BayPlanCntrListConCndVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.10
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.10  
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo;

import java.lang.reflect.Field;
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
public class BayPlanCntrListConCndVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<BayPlanCntrListConCndVO> models = new ArrayList<BayPlanCntrListConCndVO>();

    /* Column Info */
    private String vvd = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String cntrNo = null;

    /* Column Info */
    private String pol = null;

    /* Column Info */
    private String pod = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String vpsPortCd = null;

    /* Column Info */
    private String lpolClptIndSeq = null;

    /* Column Info */
    private String hiddenVvd = null;

    /* Column Info */
    private String clptIndSeq = null;

    /* Column Info */
    private String cvyRefNo = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public BayPlanCntrListConCndVO() {
    }

    public BayPlanCntrListConCndVO(String ibflag, String pagerows, String vvd, String cntrNo, String pol, String pod, String vpsPortCd, String lpolClptIndSeq, String hiddenVvd, String clptIndSeq, String cvyRefNo) {
        this.vvd = vvd;
        this.ibflag = ibflag;
        this.cntrNo = cntrNo;
        this.pol = pol;
        this.pod = pod;
        this.pagerows = pagerows;
        this.vpsPortCd = vpsPortCd;
        this.lpolClptIndSeq = lpolClptIndSeq;
        this.hiddenVvd = hiddenVvd;
        this.clptIndSeq = clptIndSeq;
        this.cvyRefNo = cvyRefNo;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("vvd", getVvd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("cntr_no", getCntrNo());
        this.hashColumns.put("pol", getPol());
        this.hashColumns.put("pod", getPod());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("vps_port_cd", getVpsPortCd());
        this.hashColumns.put("lpol_clpt_ind_seq", getLpolClptIndSeq());
        this.hashColumns.put("hidden_vvd", getHiddenVvd());
        this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
        this.hashColumns.put("cvy_ref_no", getCvyRefNo());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("vvd", "vvd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("cntr_no", "cntrNo");
        this.hashFields.put("pol", "pol");
        this.hashFields.put("pod", "pod");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("vps_port_cd", "vpsPortCd");
        this.hashFields.put("lpol_clpt_ind_seq", "lpolClptIndSeq");
        this.hashFields.put("hidden_vvd", "hiddenVvd");
        this.hashFields.put("clpt_ind_seq", "clptIndSeq");
        this.hashFields.put("cvy_ref_no", "cvyRefNo");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return vvd
	 */
    public String getVvd() {
        return this.vvd;
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
	 * @return cntrNo
	 */
    public String getCntrNo() {
        return this.cntrNo;
    }

    /**
	 * Column Info
	 * @return pol
	 */
    public String getPol() {
        return this.pol;
    }

    /**
	 * Column Info
	 * @return pod
	 */
    public String getPod() {
        return this.pod;
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
	 * @param vvd
	 */
    public void setVvd(String vvd) {
        this.vvd = vvd;
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
	 * @param cntrNo
	 */
    public void setCntrNo(String cntrNo) {
        this.cntrNo = cntrNo;
    }

    /**
	 * Column Info
	 * @param pol
	 */
    public void setPol(String pol) {
        this.pol = pol;
    }

    /**
	 * Column Info
	 * @param pod
	 */
    public void setPod(String pod) {
        this.pod = pod;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    public void setVpsPortCd(String vpsPortCd) {
        this.vpsPortCd = vpsPortCd;
    }

    public String getVpsPortCd() {
        return this.vpsPortCd;
    }

    public void setLpolClptIndSeq(String lpolClptIndSeq) {
        this.lpolClptIndSeq = lpolClptIndSeq;
    }

    public String getLpolClptIndSeq() {
        return this.lpolClptIndSeq;
    }

    public void setHiddenVvd(String hiddenVvd) {
        this.hiddenVvd = hiddenVvd;
    }

    public String getHiddenVvd() {
        return this.hiddenVvd;
    }

    public void setClptIndSeq(String clptIndSeq) {
        this.clptIndSeq = clptIndSeq;
    }

    public String getClptIndSeq() {
        return this.clptIndSeq;
    }

    public void setCvyRefNo(String cvyRefNo) {
        this.cvyRefNo = cvyRefNo;
    }

    public String getCvyRefNo() {
        return this.cvyRefNo;
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
        setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
        setPol(JSPUtil.getParameter(request, prefix + "pol", ""));
        setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
        setLpolClptIndSeq(JSPUtil.getParameter(request, prefix + "lpol_clpt_ind_seq", ""));
        setHiddenVvd(JSPUtil.getParameter(request, prefix + "hidden_vvd", ""));
        setClptIndSeq(JSPUtil.getParameter(request, prefix + "clpt_ind_seq", ""));
        setCvyRefNo(JSPUtil.getParameter(request, prefix + "cvy_ref_no", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BayPlanCntrListConCndVO[]
	 */
    public BayPlanCntrListConCndVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BayPlanCntrListConCndVO[]
	 */
    public BayPlanCntrListConCndVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        BayPlanCntrListConCndVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] vvd = (JSPUtil.getParameter(request, prefix + "vvd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] cntrNo = (JSPUtil.getParameter(request, prefix + "cntr_no", length));
            String[] pol = (JSPUtil.getParameter(request, prefix + "pol", length));
            String[] pod = (JSPUtil.getParameter(request, prefix + "pod", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] vpsPortCd = (JSPUtil.getParameter(request, prefix + "vps_port_cd", length));
            String[] lpolClptIndSeq = (JSPUtil.getParameter(request, prefix + "lpol_clpt_ind_seq", length));
            String[] hiddenVvd = (JSPUtil.getParameter(request, prefix + "hidden_vvd", length));
            String[] clptIndSeq = (JSPUtil.getParameter(request, prefix + "clpt_ind_seq", length));
	    	String[] cvyRefNo = (JSPUtil.getParameter(request, prefix + "cvy_ref_no", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new BayPlanCntrListConCndVO();
                if (vvd[i] != null)
                    model.setVvd(vvd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (cntrNo[i] != null)
                    model.setCntrNo(cntrNo[i]);
                if (pol[i] != null)
                    model.setPol(pol[i]);
                if (pod[i] != null)
                    model.setPod(pod[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (vpsPortCd[i] != null)
                    model.setVpsPortCd(vpsPortCd[i]);
                if (lpolClptIndSeq[i] != null)
                    model.setLpolClptIndSeq(lpolClptIndSeq[i]);
                if (hiddenVvd[i] != null)
                    model.setHiddenVvd(hiddenVvd[i]);
                if (clptIndSeq[i] != null) 
		    		model.setClptIndSeq(clptIndSeq[i]);
				if (cvyRefNo[i] != null) 
		    		model.setCvyRefNo(cvyRefNo[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getBayPlanCntrListConCndVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return BayPlanCntrListConCndVO[]
	 */
    public BayPlanCntrListConCndVO[] getBayPlanCntrListConCndVOs() {
        BayPlanCntrListConCndVO[] vos = (BayPlanCntrListConCndVO[]) models.toArray(new BayPlanCntrListConCndVO[models.size()]);
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
        this.vvd = this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrNo = this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pol = this.pol.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pod = this.pod.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsPortCd = this.vpsPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lpolClptIndSeq = this.lpolClptIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hiddenVvd = this.hiddenVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.clptIndSeq = this.clptIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cvyRefNo = this.cvyRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
