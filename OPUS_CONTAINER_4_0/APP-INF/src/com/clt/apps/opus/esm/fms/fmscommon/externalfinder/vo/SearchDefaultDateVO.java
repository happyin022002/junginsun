/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchDefaultDate.java
*@FileTitle : SearchDefaultDate
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo;

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
public class SearchDefaultDateVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<SearchDefaultDateVO> models = new ArrayList<SearchDefaultDateVO>();

    private String ibflag = null;

    private String pagerows = null;

    private String csrType = null;

    private String slpOfcCd = null;

    private String rqstDt = null;

    private String effDt = null;

    private String vvdCxlFlg = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public SearchDefaultDateVO() {
    }

    public SearchDefaultDateVO(String ibflag, String pagerows, String csrType, String slpOfcCd, String rqstDt, String effDt, String vvdCxlFlg) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.csrType = csrType;
        this.slpOfcCd = slpOfcCd;
        this.rqstDt = rqstDt;
        this.effDt = effDt;
        this.vvdCxlFlg = vvdCxlFlg;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("csr_type", getCsrType());
        this.hashColumns.put("slp_ofc_cd", getSlpOfcCd());
        this.hashColumns.put("rqst_dt", getRqstDt());
        this.hashColumns.put("eff_dt", getEffDt());
        this.hashColumns.put("vvd_cxl_flg", getVvdCxlFlg());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("csr_type", "csrType");
        this.hashFields.put("slp_ofc_cd", "slpOfcCd");
        this.hashFields.put("rqst_dt", "rqstDt");
        this.hashFields.put("eff_dt", "effDt");
        this.hashFields.put("vvd_cxl_flg", "vvdCxlFlg");
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
	 * @param String csrType
	 */
    public void setCsrType(String csrType) {
        this.csrType = csrType;
    }

    /**
	 * 
	 * @return String csrType
	 */
    public String getCsrType() {
        return this.csrType;
    }

    /**
	 *
	 * @param String slpOfcCd
	 */
    public void setSlpOfcCd(String slpOfcCd) {
        this.slpOfcCd = slpOfcCd;
    }

    /**
	 * 
	 * @return String slpOfcCd
	 */
    public String getSlpOfcCd() {
        return this.slpOfcCd;
    }

    /**
	 *
	 * @param String rqstDt
	 */
    public void setRqstDt(String rqstDt) {
        this.rqstDt = rqstDt;
    }

    /**
	 * 
	 * @return String rqstDt
	 */
    public String getRqstDt() {
        return this.rqstDt;
    }

    /**
	 *
	 * @param String effDt
	 */
    public void setEffDt(String effDt) {
        this.effDt = effDt;
    }

    /**
	 * 
	 * @return String effDt
	 */
    public String getEffDt() {
        return this.effDt;
    }

    public void setVvdCxlFlg(String vvdCxlFlg) {
        this.vvdCxlFlg = vvdCxlFlg;
    }

    public String getVvdCxlFlg() {
        return this.vvdCxlFlg;
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
        setCsrType(JSPUtil.getParameter(request, prefix + "csr_type", ""));
        setSlpOfcCd(JSPUtil.getParameter(request, prefix + "slp_ofc_cd", ""));
        setRqstDt(JSPUtil.getParameter(request, prefix + "rqst_dt", ""));
        setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
        setVvdCxlFlg(JSPUtil.getParameter(request, prefix + "vvd_cxl_flg", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchDefaultDate[]
	 */
    public SearchDefaultDateVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchDefaultDate[]
	 */
    public SearchDefaultDateVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        SearchDefaultDateVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] csrType = (JSPUtil.getParameter(request, prefix + "csr_type", length));
            String[] slpOfcCd = (JSPUtil.getParameter(request, prefix + "slp_ofc_cd", length));
            String[] rqstDt = (JSPUtil.getParameter(request, prefix + "rqst_dt", length));
            String[] effDt = (JSPUtil.getParameter(request, prefix + "eff_dt", length));
            String[] vvdCxlFlg = (JSPUtil.getParameter(request, prefix + "vvd_cxl_flg", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new SearchDefaultDateVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (csrType[i] != null)
                    model.setCsrType(csrType[i]);
                if (slpOfcCd[i] != null)
                    model.setSlpOfcCd(slpOfcCd[i]);
                if (rqstDt[i] != null)
                    model.setRqstDt(rqstDt[i]);
                if (effDt[i] != null)
                    model.setEffDt(effDt[i]);
                if (vvdCxlFlg[i] != null) 
		    		model.setVvdCxlFlg(vvdCxlFlg[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getSearchDefaultDates();
    }

    /**
	 * VO 배열을 반환
	 * @return SearchDefaultDate[]
	 */
    public SearchDefaultDateVO[] getSearchDefaultDates() {
        SearchDefaultDateVO[] vos = (SearchDefaultDateVO[]) models.toArray(new SearchDefaultDateVO[models.size()]);
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
        this.csrType = this.csrType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slpOfcCd = this.slpOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstDt = this.rqstDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.effDt = this.effDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvdCxlFlg = this.vvdCxlFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
