/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchContracNoVO.java
*@FileTitle : SearchContracNoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.16
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.16 
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
public class SearchContractNoVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<SearchContractNoVO> models = new ArrayList<SearchContractNoVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String vslEngNm = null;

    /* Column Info */
    private String typeFlag = null;

    /* Column Info */
    private String ctrtFlag = null;

    /* Column Info */
    private String fletCtrtTpCd = null;

    /* Column Info */
    private String fletCtrtNo = null;

    /* Column Info */
    private String orderPriority = null;

    /* Column Info */
    private String condFlag = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public SearchContractNoVO() {
    }

    public SearchContractNoVO(String ibflag, String pagerows, String vslCd, String vslEngNm, String typeFlag, String ctrtFlag, String fletCtrtTpCd, String fletCtrtNo, String orderPriority, String condFlag) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.vslCd = vslCd;
        this.vslEngNm = vslEngNm;
        this.typeFlag = typeFlag;
        this.ctrtFlag = ctrtFlag;
        this.fletCtrtTpCd = fletCtrtTpCd;
        this.fletCtrtNo = fletCtrtNo;
        this.orderPriority = orderPriority;
        this.condFlag = condFlag;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("vsl_eng_nm", getVslEngNm());
        this.hashColumns.put("type_flag", getTypeFlag());
        this.hashColumns.put("ctrt_flag", getCtrtFlag());
        this.hashColumns.put("flet_ctrt_tp_cd", getFletCtrtTpCd());
        this.hashColumns.put("flet_ctrt_no", getFletCtrtNo());
        this.hashColumns.put("order_priority", getOrderPriority());
        this.hashColumns.put("cond_flag", getCondFlag());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("vsl_eng_nm", "vslEngNm");
        this.hashFields.put("type_flag", "typeFlag");
        this.hashFields.put("ctrt_flag", "ctrtFlag");
        this.hashFields.put("flet_ctrt_tp_cd", "fletCtrtTpCd");
        this.hashFields.put("flet_ctrt_no", "fletCtrtNo");
        this.hashFields.put("order_priority", "orderPriority");
        this.hashFields.put("cond_flag", "condFlag");
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
	 * @param String vslCd
	 */
    public void setVslCd(String vslCd) {
        this.vslCd = vslCd;
    }

    /**
	 * 
	 * @return String vslCd
	 */
    public String getVslCd() {
        return this.vslCd;
    }

    /**
	 *
	 * @param String vslEngNm
	 */
    public void setVslEngNm(String vslEngNm) {
        this.vslEngNm = vslEngNm;
    }

    /**
	 * 
	 * @return String vslEngNm
	 */
    public String getVslEngNm() {
        return this.vslEngNm;
    }

    /**
	 *
	 * @param String typeFlag
	 */
    public void setTypeFlag(String typeFlag) {
        this.typeFlag = typeFlag;
    }

    /**
	 * 
	 * @return String typeFlag
	 */
    public String getTypeFlag() {
        return this.typeFlag;
    }

    /**
	 *
	 * @param String ctrtFlag
	 */
    public void setCtrtFlag(String ctrtFlag) {
        this.ctrtFlag = ctrtFlag;
    }

    /**
	 * 
	 * @return String ctrtFlag
	 */
    public String getCtrtFlag() {
        return this.ctrtFlag;
    }

    /**
	 *
	 * @param String fletCtrtTpCd
	 */
    public void setFletCtrtTpCd(String fletCtrtTpCd) {
        this.fletCtrtTpCd = fletCtrtTpCd;
    }

    /**
	 * 
	 * @return String fletCtrtTpCd
	 */
    public String getFletCtrtTpCd() {
        return this.fletCtrtTpCd;
    }

    /**
	 *
	 * @param String fletCtrtNo
	 */
    public void setFletCtrtNo(String fletCtrtNo) {
        this.fletCtrtNo = fletCtrtNo;
    }

    /**
	 * 
	 * @return String fletCtrtNo
	 */
    public String getFletCtrtNo() {
        return this.fletCtrtNo;
    }

    public void setOrderPriority(String orderPriority) {
        this.orderPriority = orderPriority;
    }

    public String getOrderPriority() {
        return this.orderPriority;
    }

    public void setCondFlag(String condFlag) {
        this.condFlag = condFlag;
    }

    public String getCondFlag() {
        return this.condFlag;
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
        setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
        setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
        setTypeFlag(JSPUtil.getParameter(request, prefix + "type_flag", ""));
        setCtrtFlag(JSPUtil.getParameter(request, prefix + "ctrt_flag", ""));
        setFletCtrtTpCd(JSPUtil.getParameter(request, prefix + "flet_ctrt_tp_cd", ""));
        setFletCtrtNo(JSPUtil.getParameter(request, prefix + "flet_ctrt_no", ""));
        setOrderPriority(JSPUtil.getParameter(request, prefix + "order_priority", ""));
        setCondFlag(JSPUtil.getParameter(request, prefix + "cond_flag", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchContracNoVO[]
	 */
    public SearchContractNoVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchContracNoVO[]
	 */
    public SearchContractNoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        SearchContractNoVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] vslEngNm = (JSPUtil.getParameter(request, prefix + "vsl_eng_nm", length));
            String[] typeFlag = (JSPUtil.getParameter(request, prefix + "type_flag", length));
            String[] ctrtFlag = (JSPUtil.getParameter(request, prefix + "ctrt_flag", length));
            String[] fletCtrtTpCd = (JSPUtil.getParameter(request, prefix + "flet_ctrt_tp_cd", length));
            String[] fletCtrtNo = (JSPUtil.getParameter(request, prefix + "flet_ctrt_no", length));
            String[] orderPriority = (JSPUtil.getParameter(request, prefix + "order_priority", length));
            String[] condFlag = (JSPUtil.getParameter(request, prefix + "cond_flag", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new SearchContractNoVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (vslEngNm[i] != null)
                    model.setVslEngNm(vslEngNm[i]);
                if (typeFlag[i] != null)
                    model.setTypeFlag(typeFlag[i]);
                if (ctrtFlag[i] != null)
                    model.setCtrtFlag(ctrtFlag[i]);
                if (fletCtrtTpCd[i] != null)
                    model.setFletCtrtTpCd(fletCtrtTpCd[i]);
                if (fletCtrtNo[i] != null)
                    model.setFletCtrtNo(fletCtrtNo[i]);
                if (orderPriority[i] != null)
                    model.setOrderPriority(orderPriority[i]);
                if (condFlag[i] != null) 
		    		model.setCondFlag(condFlag[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getSearchContracNoVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return SearchContracNoVO[]
	 */
    public SearchContractNoVO[] getSearchContracNoVOs() {
        SearchContractNoVO[] vos = (SearchContractNoVO[]) models.toArray(new SearchContractNoVO[models.size()]);
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
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslEngNm = this.vslEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.typeFlag = this.typeFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctrtFlag = this.ctrtFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fletCtrtTpCd = this.fletCtrtTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fletCtrtNo = this.fletCtrtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orderPriority = this.orderPriority.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.condFlag = this.condFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
