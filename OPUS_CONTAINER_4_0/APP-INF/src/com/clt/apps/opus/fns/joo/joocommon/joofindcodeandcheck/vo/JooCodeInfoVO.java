/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JooCodeInfoVO.java
*@FileTitle : JooCodeInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.13
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.01.13 박희동 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.vo;

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
 * @author 박희동
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class JooCodeInfoVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<JooCodeInfoVO> models = new ArrayList<JooCodeInfoVO>();

    /* Column Info */
    private String authCd = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String superCd1 = null;

    /* Column Info */
    private String superCd2 = null;

    /* Column Info */
    private String name = null;

    /* Column Info */
    private String code = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String sortKey = null;

    /* Column Info */
    private String taxRate = null;

    /* Column Info */
    private String taxIncomeFlag = null;

    /* Column Info */
    private String dpSeq = null;

    /* Column Info */
    private String intgCdId = null;

    /* Column Info */
    private String intgCdValCtnt = null;

    /* Column Info */
    private String intgCdValDpDesc = null;

    /* Column Info */
    private String intgCdValDesc = null;

    /* Column Info */
    private String intgCdValDpSeq = null;

    /* Column Info */
    private String superCds1 = null;

    /* Column Info */
    private String superCds2 = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public JooCodeInfoVO() {
    }

    public JooCodeInfoVO(String ibflag, String pagerows, String code, String name, String superCd1, String superCd2, String authCd, String sortKey, String taxRate, String taxIncomeFlag, String dpSeq, String intgCdId, String intgCdValCtnt, String intgCdValDpDesc, String intgCdValDesc, String intgCdValDpSeq, String superCds1, String superCds2) {
        this.authCd = authCd;
        this.ibflag = ibflag;
        this.superCd1 = superCd1;
        this.superCd2 = superCd2;
        this.name = name;
        this.code = code;
        this.pagerows = pagerows;
        this.sortKey = sortKey;
        this.taxRate = taxRate;
        this.taxIncomeFlag = taxIncomeFlag;
        this.dpSeq = dpSeq;
        this.intgCdId = intgCdId;
        this.intgCdValCtnt = intgCdValCtnt;
        this.intgCdValDpDesc = intgCdValDpDesc;
        this.intgCdValDesc = intgCdValDesc;
        this.intgCdValDpSeq = intgCdValDpSeq;
        this.superCds1 = superCds1;
        this.superCds2 = superCds2;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("auth_cd", getAuthCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("super_cd1", getSuperCd1());
        this.hashColumns.put("super_cd2", getSuperCd2());
        this.hashColumns.put("name", getName());
        this.hashColumns.put("code", getCode());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("sort_key", getSortKey());
        this.hashColumns.put("tax_rate", getTaxRate());
        this.hashColumns.put("tax_income_flag", getTaxIncomeFlag());
        this.hashColumns.put("dp_seq", getDpSeq());
        this.hashColumns.put("intg_cd_id", getIntgCdId());
        this.hashColumns.put("intg_cd_val_ctnt", getIntgCdValCtnt());
        this.hashColumns.put("intg_cd_val_dp_desc", getIntgCdValDpDesc());
        this.hashColumns.put("intg_cd_val_desc", getIntgCdValDesc());
        this.hashColumns.put("intg_cd_val_dp_seq", getIntgCdValDpSeq());
        this.hashColumns.put("super_cds1", getSuperCds1());
        this.hashColumns.put("super_cds2", getSuperCds2());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("auth_cd", "authCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("super_cd1", "superCd1");
        this.hashFields.put("super_cd2", "superCd2");
        this.hashFields.put("name", "name");
        this.hashFields.put("code", "code");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("sort_key", "sortKey");
        this.hashFields.put("tax_rate", "taxRate");
        this.hashFields.put("tax_income_flag", "taxIncomeFlag");
        this.hashFields.put("dp_seq", "dpSeq");
        this.hashFields.put("intg_cd_id", "intgCdId");
        this.hashFields.put("intg_cd_val_ctnt", "intgCdValCtnt");
        this.hashFields.put("intg_cd_val_dp_desc", "intgCdValDpDesc");
        this.hashFields.put("intg_cd_val_desc", "intgCdValDesc");
        this.hashFields.put("intg_cd_val_dp_seq", "intgCdValDpSeq");
        this.hashFields.put("super_cds1", "superCds1");
        this.hashFields.put("super_cds2", "superCds2");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return authCd
	 */
    public String getAuthCd() {
        return this.authCd;
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
	 * @return code
	 */
    public String getCode() {
        return this.code;
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
	 * @param authCd
	 */
    public void setAuthCd(String authCd) {
        this.authCd = authCd;
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
	 * @param code
	 */
    public void setCode(String code) {
        this.code = code;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    public void setSortKey(String sortKey) {
        this.sortKey = sortKey;
    }

    public String getSortKey() {
        return this.sortKey;
    }

    public void setTaxRate(String taxRate) {
        this.taxRate = taxRate;
    }

    public String getTaxRate() {
        return this.taxRate;
    }

    public void setTaxIncomeFlag(String taxIncomeFlag) {
        this.taxIncomeFlag = taxIncomeFlag;
    }

    public String getTaxIncomeFlag() {
        return this.taxIncomeFlag;
    }

    public void setDpSeq(String dpSeq) {
        this.dpSeq = dpSeq;
    }

    public String getDpSeq() {
        return this.dpSeq;
    }

    public void setIntgCdId(String intgCdId) {
        this.intgCdId = intgCdId;
    }

    public String getIntgCdId() {
        return this.intgCdId;
    }

    public void setIntgCdValCtnt(String intgCdValCtnt) {
        this.intgCdValCtnt = intgCdValCtnt;
    }

    public String getIntgCdValCtnt() {
        return this.intgCdValCtnt;
    }

    public void setIntgCdValDpDesc(String intgCdValDpDesc) {
        this.intgCdValDpDesc = intgCdValDpDesc;
    }

    public String getIntgCdValDpDesc() {
        return this.intgCdValDpDesc;
    }

    public void setIntgCdValDesc(String intgCdValDesc) {
        this.intgCdValDesc = intgCdValDesc;
    }

    public String getIntgCdValDesc() {
        return this.intgCdValDesc;
    }

    public void setIntgCdValDpSeq(String intgCdValDpSeq) {
        this.intgCdValDpSeq = intgCdValDpSeq;
    }

    public String getIntgCdValDpSeq() {
        return this.intgCdValDpSeq;
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
        setAuthCd(JSPUtil.getParameter(request, prefix + "auth_cd", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setSuperCd1(JSPUtil.getParameter(request, prefix + "super_cd1", ""));
        setSuperCd2(JSPUtil.getParameter(request, prefix + "super_cd2", ""));
        setName(JSPUtil.getParameter(request, prefix + "name", ""));
        setCode(JSPUtil.getParameter(request, prefix + "code", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setSortKey(JSPUtil.getParameter(request, prefix + "sort_key", ""));
        setTaxRate(JSPUtil.getParameter(request, prefix + "tax_rate", ""));
        setTaxIncomeFlag(JSPUtil.getParameter(request, prefix + "tax_income_flag", ""));
        setDpSeq(JSPUtil.getParameter(request, prefix + "dp_seq", ""));
        setIntgCdId(JSPUtil.getParameter(request, prefix + "intg_cd_id", ""));
        setIntgCdValCtnt(JSPUtil.getParameter(request, prefix + "intg_cd_val_ctnt", ""));
        setIntgCdValDpDesc(JSPUtil.getParameter(request, prefix + "intg_cd_val_dp_desc", ""));
        setIntgCdValDesc(JSPUtil.getParameter(request, prefix + "intg_cd_val_desc", ""));
        setIntgCdValDpSeq(JSPUtil.getParameter(request, prefix + "intg_cd_val_dp_seq", ""));
        setSuperCds1(JSPUtil.getParameter(request, prefix + "super_cds1", ""));
        setSuperCds2(JSPUtil.getParameter(request, prefix + "super_cds2", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return JooCodeInfoVO[]
	 */
    public JooCodeInfoVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return JooCodeInfoVO[]
	 */
    public JooCodeInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        JooCodeInfoVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] authCd = (JSPUtil.getParameter(request, prefix + "auth_cd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] superCd1 = (JSPUtil.getParameter(request, prefix + "super_cd1", length));
            String[] superCd2 = (JSPUtil.getParameter(request, prefix + "super_cd2", length));
            String[] name = (JSPUtil.getParameter(request, prefix + "name", length));
            String[] code = (JSPUtil.getParameter(request, prefix + "code", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] sortKey = (JSPUtil.getParameter(request, prefix + "sort_key", length));
            String[] taxRate = (JSPUtil.getParameter(request, prefix + "tax_rate", length));
            String[] taxIncomeFlag = (JSPUtil.getParameter(request, prefix + "tax_income_flag", length));
            String[] dpSeq = (JSPUtil.getParameter(request, prefix + "dp_seq", length));
            String[] intgCdId = (JSPUtil.getParameter(request, prefix + "intg_cd_id", length));
            String[] intgCdValCtnt = (JSPUtil.getParameter(request, prefix + "intg_cd_val_ctnt", length));
            String[] intgCdValDpDesc = (JSPUtil.getParameter(request, prefix + "intg_cd_val_dp_desc", length));
            String[] intgCdValDesc = (JSPUtil.getParameter(request, prefix + "intg_cd_val_desc", length));
            String[] intgCdValDpSeq = (JSPUtil.getParameter(request, prefix + "intg_cd_val_dp_seq", length));
            String[] superCds1 = (JSPUtil.getParameter(request, prefix + "super_cds1", length));
	    	String[] superCds2 = (JSPUtil.getParameter(request, prefix + "super_cds2", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new JooCodeInfoVO();
                if (authCd[i] != null)
                    model.setAuthCd(authCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (superCd1[i] != null)
                    model.setSuperCd1(superCd1[i]);
                if (superCd2[i] != null)
                    model.setSuperCd2(superCd2[i]);
                if (name[i] != null)
                    model.setName(name[i]);
                if (code[i] != null)
                    model.setCode(code[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (sortKey[i] != null)
                    model.setSortKey(sortKey[i]);
                if (taxRate[i] != null)
                    model.setTaxRate(taxRate[i]);
                if (taxIncomeFlag[i] != null)
                    model.setTaxIncomeFlag(taxIncomeFlag[i]);
                if (dpSeq[i] != null)
                    model.setDpSeq(dpSeq[i]);
                if (intgCdId[i] != null)
                    model.setIntgCdId(intgCdId[i]);
                if (intgCdValCtnt[i] != null)
                    model.setIntgCdValCtnt(intgCdValCtnt[i]);
                if (intgCdValDpDesc[i] != null)
                    model.setIntgCdValDpDesc(intgCdValDpDesc[i]);
                if (intgCdValDesc[i] != null)
                    model.setIntgCdValDesc(intgCdValDesc[i]);
                if (intgCdValDpSeq[i] != null)
                    model.setIntgCdValDpSeq(intgCdValDpSeq[i]);
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
        return getJooCodeInfoVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return JooCodeInfoVO[]
	 */
    public JooCodeInfoVO[] getJooCodeInfoVOs() {
        JooCodeInfoVO[] vos = (JooCodeInfoVO[]) models.toArray(new JooCodeInfoVO[models.size()]);
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
        this.authCd = this.authCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.superCd1 = this.superCd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.superCd2 = this.superCd2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.name = this.name.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.code = this.code.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sortKey = this.sortKey.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.taxRate = this.taxRate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.taxIncomeFlag = this.taxIncomeFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dpSeq = this.dpSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.intgCdId = this.intgCdId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.intgCdValCtnt = this.intgCdValCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.intgCdValDpDesc = this.intgCdValDpDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.intgCdValDesc = this.intgCdValDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.intgCdValDpSeq = this.intgCdValDpSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.superCds1 = this.superCds1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.superCds2 = this.superCds2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
