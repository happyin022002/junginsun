/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CntrConversionConditionVO.java
*@FileTitle : CntrConversionConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo;

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
public class CntrConversionConditionVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<CntrConversionConditionVO> models = new ArrayList<CntrConversionConditionVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String pptCd = null;

    /* Column Info */
    private String slanCd = null;

    /* Column Info */
    private String dftTpszGroup = null;

    /* Column Info */
    private String pptCd2 = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public CntrConversionConditionVO() {
    }

    public CntrConversionConditionVO(String ibflag, String pagerows, String pptCd, String slanCd, String dftTpszGroup, String pptCd2) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.pptCd = pptCd;
        this.slanCd = slanCd;
        this.dftTpszGroup = dftTpszGroup;
        this.pptCd2 = pptCd2;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("ppt_cd", getPptCd());
        this.hashColumns.put("slan_cd", getSlanCd());
        this.hashColumns.put("dft_tpsz_group", getDftTpszGroup());
        this.hashColumns.put("ppt_cd2", getPptCd2());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("ppt_cd", "pptCd");
        this.hashFields.put("slan_cd", "slanCd");
        this.hashFields.put("dft_tpsz_group", "dftTpszGroup");
        this.hashFields.put("ppt_cd2", "pptCd2");
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
	 * @param String pptCd
	 */
    public void setPptCd(String pptCd) {
        this.pptCd = pptCd;
    }

    /**
	 * 
	 * @return String pptCd
	 */
    public String getPptCd() {
        return this.pptCd;
    }

    /**
	 *
	 * @param String slanCd
	 */
    public void setSlanCd(String slanCd) {
        this.slanCd = slanCd;
    }

    /**
	 * 
	 * @return String slanCd
	 */
    public String getSlanCd() {
        return this.slanCd;
    }

    public void setDftTpszGroup(String dftTpszGroup) {
        this.dftTpszGroup = dftTpszGroup;
    }

    public String getDftTpszGroup() {
        return this.dftTpszGroup;
    }

    public void setPptCd2(String pptCd2) {
        this.pptCd2 = pptCd2;
    }

    public String getPptCd2() {
        return this.pptCd2;
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
        setPptCd(JSPUtil.getParameter(request, prefix + "ppt_cd", ""));
        setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
        setDftTpszGroup(JSPUtil.getParameter(request, prefix + "dft_tpsz_group", ""));
        setPptCd2(JSPUtil.getParameter(request, prefix + "ppt_cd2", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CntrConversionConditionVO[]
	 */
    public CntrConversionConditionVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CntrConversionConditionVO[]
	 */
    public CntrConversionConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        CntrConversionConditionVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] pptCd = (JSPUtil.getParameter(request, prefix + "ppt_cd", length));
            String[] slanCd = (JSPUtil.getParameter(request, prefix + "slan_cd", length));
            String[] dftTpszGroup = (JSPUtil.getParameter(request, prefix + "dft_tpsz_group", length));
            String[] pptCd2 = (JSPUtil.getParameter(request, prefix + "ppt_cd2", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new CntrConversionConditionVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (pptCd[i] != null)
                    model.setPptCd(pptCd[i]);
                if (slanCd[i] != null)
                    model.setSlanCd(slanCd[i]);
                if (dftTpszGroup[i] != null)
                    model.setDftTpszGroup(dftTpszGroup[i]);
                if (pptCd2[i] != null) 
		    		model.setPptCd2(pptCd2[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getCntrConversionConditionVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return CntrConversionConditionVO[]
	 */
    public CntrConversionConditionVO[] getCntrConversionConditionVOs() {
        CntrConversionConditionVO[] vos = (CntrConversionConditionVO[]) models.toArray(new CntrConversionConditionVO[models.size()]);
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
        this.pptCd = this.pptCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd = this.slanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dftTpszGroup = this.dftTpszGroup.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pptCd2 = this.pptCd2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
