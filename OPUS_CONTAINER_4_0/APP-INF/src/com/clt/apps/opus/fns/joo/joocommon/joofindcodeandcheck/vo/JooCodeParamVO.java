/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JooCodeParamVO.java
*@FileTitle : JooCodeParamVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.29
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.04.29 장강철 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 장강철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class JooCodeParamVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<JooCodeParamVO> models = new ArrayList<JooCodeParamVO>();

    /* Column Info */
    private String joCrrAuthCd = null;

    /* Column Info */
    private String ofcCd = null;

    /* Column Info */
    private String acctYrmon = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String superCd1 = null;

    /* Column Info */
    private String authDelcheckYn = null;

    /* Column Info */
    private String superCd2 = null;

    /* Column Info */
    private String name = null;

    /* Column Info */
    private String joCrrCd = null;

    /* Column Info */
    private String code = null;

    /* Column Info */
    private String sortKey = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String stlCmbSeq = null;

    /* Column Info */
    private String authOfcCd = null;

    /* Column Info */
    private String reDivrCd = null;

    /* Column Info */
    private String joStlItmCd = null;

    /* Column Info */
    private String superCds1 = null;

    /* Column Info */
    private String superCds2 = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public JooCodeParamVO() {
    }

    public JooCodeParamVO(String ibflag, String pagerows, String code, String name, String superCd1, String superCd2, String sortKey, String ofcCd, String joCrrAuthCd, String acctYrmon, String joCrrCd, String authDelcheckYn, String stlCmbSeq, String authOfcCd, String reDivrCd, String joStlItmCd, String superCds1, String superCds2) {
        this.joCrrAuthCd = joCrrAuthCd;
        this.ofcCd = ofcCd;
        this.acctYrmon = acctYrmon;
        this.ibflag = ibflag;
        this.superCd1 = superCd1;
        this.authDelcheckYn = authDelcheckYn;
        this.superCd2 = superCd2;
        this.name = name;
        this.joCrrCd = joCrrCd;
        this.code = code;
        this.sortKey = sortKey;
        this.pagerows = pagerows;
        this.stlCmbSeq = stlCmbSeq;
        this.authOfcCd = authOfcCd;
        this.reDivrCd = reDivrCd;
        this.joStlItmCd = joStlItmCd;
        this.superCds1 = superCds1;
        this.superCds2 = superCds2;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("jo_crr_auth_cd", getJoCrrAuthCd());
        this.hashColumns.put("ofc_cd", getOfcCd());
        this.hashColumns.put("acct_yrmon", getAcctYrmon());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("super_cd1", getSuperCd1());
        this.hashColumns.put("auth_delcheck_yn", getAuthDelcheckYn());
        this.hashColumns.put("super_cd2", getSuperCd2());
        this.hashColumns.put("name", getName());
        this.hashColumns.put("jo_crr_cd", getJoCrrCd());
        this.hashColumns.put("code", getCode());
        this.hashColumns.put("sort_key", getSortKey());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("stl_cmb_seq", getStlCmbSeq());
        this.hashColumns.put("auth_ofc_cd", getAuthOfcCd());
        this.hashColumns.put("re_divr_cd", getReDivrCd());
        this.hashColumns.put("jo_stl_itm_cd", getJoStlItmCd());
        this.hashColumns.put("super_cds1", getSuperCds1());
        this.hashColumns.put("super_cds2", getSuperCds2());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("jo_crr_auth_cd", "joCrrAuthCd");
        this.hashFields.put("ofc_cd", "ofcCd");
        this.hashFields.put("acct_yrmon", "acctYrmon");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("super_cd1", "superCd1");
        this.hashFields.put("auth_delcheck_yn", "authDelcheckYn");
        this.hashFields.put("super_cd2", "superCd2");
        this.hashFields.put("name", "name");
        this.hashFields.put("jo_crr_cd", "joCrrCd");
        this.hashFields.put("code", "code");
        this.hashFields.put("sort_key", "sortKey");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("stl_cmb_seq", "stlCmbSeq");
        this.hashFields.put("auth_ofc_cd", "authOfcCd");
        this.hashFields.put("re_divr_cd", "reDivrCd");
        this.hashFields.put("jo_stl_itm_cd", "joStlItmCd");
        this.hashFields.put("super_cds1", "superCds1");
        this.hashFields.put("super_cds2", "superCds2");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return joCrrAuthCd
	 */
    public String getJoCrrAuthCd() {
        return this.joCrrAuthCd;
    }

    /**
	 * Column Info
	 * @return ofcCd
	 */
    public String getOfcCd() {
        return this.ofcCd;
    }

    /**
	 * Column Info
	 * @return acctYrmon
	 */
    public String getAcctYrmon() {
        return this.acctYrmon;
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
	 * @return superCd1
	 */
    public String getSuperCd1() {
        return this.superCd1;
    }

    /**
	 * Column Info
	 * @return authDelcheckYn
	 */
    public String getAuthDelcheckYn() {
        return this.authDelcheckYn;
    }

    /**
	 * Column Info
	 * @return superCd2
	 */
    public String getSuperCd2() {
        return this.superCd2;
    }

    /**
	 * Column Info
	 * @return name
	 */
    public String getName() {
        return this.name;
    }

    /**
	 * Column Info
	 * @return joCrrCd
	 */
    public String getJoCrrCd() {
        return this.joCrrCd;
    }

    /**
	 * Column Info
	 * @return code
	 */
    public String getCode() {
        return this.code;
    }

    /**
	 * Column Info
	 * @return sortKey
	 */
    public String getSortKey() {
        return this.sortKey;
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
	 * @param joCrrAuthCd
	 */
    public void setJoCrrAuthCd(String joCrrAuthCd) {
        this.joCrrAuthCd = joCrrAuthCd;
    }

    /**
	 * Column Info
	 * @param ofcCd
	 */
    public void setOfcCd(String ofcCd) {
        this.ofcCd = ofcCd;
    }

    /**
	 * Column Info
	 * @param acctYrmon
	 */
    public void setAcctYrmon(String acctYrmon) {
        this.acctYrmon = acctYrmon;
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
	 * @param superCd1
	 */
    public void setSuperCd1(String superCd1) {
        this.superCd1 = superCd1;
    }

    /**
	 * Column Info
	 * @param authDelcheckYn
	 */
    public void setAuthDelcheckYn(String authDelcheckYn) {
        this.authDelcheckYn = authDelcheckYn;
    }

    /**
	 * Column Info
	 * @param superCd2
	 */
    public void setSuperCd2(String superCd2) {
        this.superCd2 = superCd2;
    }

    /**
	 * Column Info
	 * @param name
	 */
    public void setName(String name) {
        this.name = name;
    }

    /**
	 * Column Info
	 * @param joCrrCd
	 */
    public void setJoCrrCd(String joCrrCd) {
        this.joCrrCd = joCrrCd;
    }

    /**
	 * Column Info
	 * @param code
	 */
    public void setCode(String code) {
        this.code = code;
    }

    /**
	 * Column Info
	 * @param sortKey
	 */
    public void setSortKey(String sortKey) {
        this.sortKey = sortKey;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    public void setStlCmbSeq(String stlCmbSeq) {
        this.stlCmbSeq = stlCmbSeq;
    }

    public String getStlCmbSeq() {
        return this.stlCmbSeq;
    }

    public void setAuthOfcCd(String authOfcCd) {
        this.authOfcCd = authOfcCd;
    }

    public String getAuthOfcCd() {
        return this.authOfcCd;
    }

    public void setReDivrCd(String reDivrCd) {
        this.reDivrCd = reDivrCd;
    }

    public String getReDivrCd() {
        return this.reDivrCd;
    }

    public void setJoStlItmCd(String joStlItmCd) {
        this.joStlItmCd = joStlItmCd;
    }

    public String getJoStlItmCd() {
        return this.joStlItmCd;
    }

    public void setSuperCds1(String superCds1) {
        this.superCds1 = superCds1;
    }

    public String getSuperCds1() {
        return this.superCds1;
    }

    public void setSuperCds2(String superCds2) {
        this.superCds2 = superCds2;
    }

    public String getSuperCds2() {
        return this.superCds2;
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
        setJoCrrAuthCd(JSPUtil.getParameter(request, prefix + "jo_crr_auth_cd", ""));
        setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
        setAcctYrmon(JSPUtil.getParameter(request, prefix + "acct_yrmon", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setSuperCd1(JSPUtil.getParameter(request, prefix + "super_cd1", ""));
        setAuthDelcheckYn(JSPUtil.getParameter(request, prefix + "auth_delcheck_yn", ""));
        setSuperCd2(JSPUtil.getParameter(request, prefix + "super_cd2", ""));
        setName(JSPUtil.getParameter(request, prefix + "name", ""));
        setJoCrrCd(JSPUtil.getParameter(request, prefix + "jo_crr_cd", ""));
        setCode(JSPUtil.getParameter(request, prefix + "code", ""));
        setSortKey(JSPUtil.getParameter(request, prefix + "sort_key", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setStlCmbSeq(JSPUtil.getParameter(request, prefix + "stl_cmb_seq", ""));
        setAuthOfcCd(JSPUtil.getParameter(request, prefix + "auth_ofc_cd", ""));
        setReDivrCd(JSPUtil.getParameter(request, prefix + "re_divr_cd", ""));
        setJoStlItmCd(JSPUtil.getParameter(request, prefix + "jo_stl_itm_cd", ""));
        setSuperCds1(JSPUtil.getParameter(request, prefix + "super_cds1", ""));
        setSuperCds2(JSPUtil.getParameter(request, prefix + "super_cds2", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return JooCodeParamVO[]
	 */
    public JooCodeParamVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return JooCodeParamVO[]
	 */
    public JooCodeParamVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        JooCodeParamVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] joCrrAuthCd = (JSPUtil.getParameter(request, prefix + "jo_crr_auth_cd", length));
            String[] ofcCd = (JSPUtil.getParameter(request, prefix + "ofc_cd", length));
            String[] acctYrmon = (JSPUtil.getParameter(request, prefix + "acct_yrmon", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] superCd1 = (JSPUtil.getParameter(request, prefix + "super_cd1", length));
            String[] authDelcheckYn = (JSPUtil.getParameter(request, prefix + "auth_delcheck_yn", length));
            String[] superCd2 = (JSPUtil.getParameter(request, prefix + "super_cd2", length));
            String[] name = (JSPUtil.getParameter(request, prefix + "name", length));
            String[] joCrrCd = (JSPUtil.getParameter(request, prefix + "jo_crr_cd", length));
            String[] code = (JSPUtil.getParameter(request, prefix + "code", length));
            String[] sortKey = (JSPUtil.getParameter(request, prefix + "sort_key", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] stlCmbSeq = (JSPUtil.getParameter(request, prefix + "stl_cmb_seq", length));
            String[] authOfcCd = (JSPUtil.getParameter(request, prefix + "auth_ofc_cd", length));
            String[] reDivrCd = (JSPUtil.getParameter(request, prefix + "re_divr_cd", length));
            String[] joStlItmCd = (JSPUtil.getParameter(request, prefix + "jo_stl_itm_cd", length));
            String[] superCds1 = (JSPUtil.getParameter(request, prefix + "super_cds1", length));
	    	String[] superCds2 = (JSPUtil.getParameter(request, prefix + "super_cds2", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new JooCodeParamVO();
                if (joCrrAuthCd[i] != null)
                    model.setJoCrrAuthCd(joCrrAuthCd[i]);
                if (ofcCd[i] != null)
                    model.setOfcCd(ofcCd[i]);
                if (acctYrmon[i] != null)
                    model.setAcctYrmon(acctYrmon[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (superCd1[i] != null)
                    model.setSuperCd1(superCd1[i]);
                if (authDelcheckYn[i] != null)
                    model.setAuthDelcheckYn(authDelcheckYn[i]);
                if (superCd2[i] != null)
                    model.setSuperCd2(superCd2[i]);
                if (name[i] != null)
                    model.setName(name[i]);
                if (joCrrCd[i] != null)
                    model.setJoCrrCd(joCrrCd[i]);
                if (code[i] != null)
                    model.setCode(code[i]);
                if (sortKey[i] != null)
                    model.setSortKey(sortKey[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (stlCmbSeq[i] != null)
                    model.setStlCmbSeq(stlCmbSeq[i]);
                if (authOfcCd[i] != null)
                    model.setAuthOfcCd(authOfcCd[i]);
                if (reDivrCd[i] != null)
                    model.setReDivrCd(reDivrCd[i]);
                if (joStlItmCd[i] != null)
                    model.setJoStlItmCd(joStlItmCd[i]);
                if (superCds1[i] != null) 
		    		model.setSuperCds1(superCds1[i]);
				if (superCds2[i] != null) 
		    		model.setSuperCds2(superCds2[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getJooCodeParamVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return JooCodeParamVO[]
	 */
    public JooCodeParamVO[] getJooCodeParamVOs() {
        JooCodeParamVO[] vos = (JooCodeParamVO[]) models.toArray(new JooCodeParamVO[models.size()]);
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
        this.joCrrAuthCd = this.joCrrAuthCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcCd = this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acctYrmon = this.acctYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.superCd1 = this.superCd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.authDelcheckYn = this.authDelcheckYn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.superCd2 = this.superCd2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.name = this.name.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.joCrrCd = this.joCrrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.code = this.code.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sortKey = this.sortKey.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stlCmbSeq = this.stlCmbSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.authOfcCd = this.authOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.reDivrCd = this.reDivrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.joStlItmCd = this.joStlItmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.superCds1 = this.superCds1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.superCds2 = this.superCds2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
