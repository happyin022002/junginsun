/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CostListVO.java
*@FileTitle : CostListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.12
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2010.03.12 정명훈 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.psocommon.psocodefinder.vo;

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
 * @author 정명훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class CostListVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<CostListVO> models = new ArrayList<CostListVO>();

    /* Column Info */
    private String acctNm = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String costCd = null;

    /* Column Info */
    private String costNm = null;

    /* Column Info */
    private String acctCd = null;

    /* Column Info */
    private String acctEngNm = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String lgsCostSubjCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public CostListVO() {
    }

    public CostListVO(String ibflag, String pagerows, String acctCd, String acctNm, String costCd, String costNm, String acctEngNm, String lgsCostSubjCd) {
        this.acctNm = acctNm;
        this.ibflag = ibflag;
        this.costCd = costCd;
        this.costNm = costNm;
        this.acctCd = acctCd;
        this.acctEngNm = acctEngNm;
        this.pagerows = pagerows;
        this.lgsCostSubjCd = lgsCostSubjCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("acct_nm", getAcctNm());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("cost_cd", getCostCd());
        this.hashColumns.put("cost_nm", getCostNm());
        this.hashColumns.put("acct_cd", getAcctCd());
        this.hashColumns.put("acct_eng_nm", getAcctEngNm());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("lgs_cost_subj_cd", getLgsCostSubjCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("acct_nm", "acctNm");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("cost_cd", "costCd");
        this.hashFields.put("cost_nm", "costNm");
        this.hashFields.put("acct_cd", "acctCd");
        this.hashFields.put("acct_eng_nm", "acctEngNm");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("lgs_cost_subj_cd", "lgsCostSubjCd");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return acctNm
	 */
    public String getAcctNm() {
        return this.acctNm;
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
	 * @return costCd
	 */
    public String getCostCd() {
        return this.costCd;
    }

    /**
	 * Column Info
	 * @return costNm
	 */
    public String getCostNm() {
        return this.costNm;
    }

    /**
	 * Column Info
	 * @return acctCd
	 */
    public String getAcctCd() {
        return this.acctCd;
    }

    /**
	 * Column Info
	 * @return acctEngNm
	 */
    public String getAcctEngNm() {
        return this.acctEngNm;
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
	 * @param acctNm
	 */
    public void setAcctNm(String acctNm) {
        this.acctNm = acctNm;
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
	 * @param costCd
	 */
    public void setCostCd(String costCd) {
        this.costCd = costCd;
    }

    /**
	 * Column Info
	 * @param costNm
	 */
    public void setCostNm(String costNm) {
        this.costNm = costNm;
    }

    /**
	 * Column Info
	 * @param acctCd
	 */
    public void setAcctCd(String acctCd) {
        this.acctCd = acctCd;
    }

    /**
	 * Column Info
	 * @param acctEngNm
	 */
    public void setAcctEngNm(String acctEngNm) {
        this.acctEngNm = acctEngNm;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    public void setLgsCostSubjCd(String lgsCostSubjCd) {
        this.lgsCostSubjCd = lgsCostSubjCd;
    }

    public String getLgsCostSubjCd() {
        return this.lgsCostSubjCd;
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
        setAcctNm(JSPUtil.getParameter(request, prefix + "acct_nm", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setCostCd(JSPUtil.getParameter(request, prefix + "cost_cd", ""));
        setCostNm(JSPUtil.getParameter(request, prefix + "cost_nm", ""));
        setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
        setAcctEngNm(JSPUtil.getParameter(request, prefix + "acct_eng_nm", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setLgsCostSubjCd(JSPUtil.getParameter(request, prefix + "lgs_cost_subj_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CostListVO[]
	 */
    public CostListVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CostListVO[]
	 */
    public CostListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        CostListVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] acctNm = (JSPUtil.getParameter(request, prefix + "acct_nm", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] costCd = (JSPUtil.getParameter(request, prefix + "cost_cd", length));
            String[] costNm = (JSPUtil.getParameter(request, prefix + "cost_nm", length));
            String[] acctCd = (JSPUtil.getParameter(request, prefix + "acct_cd", length));
            String[] acctEngNm = (JSPUtil.getParameter(request, prefix + "acct_eng_nm", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] lgsCostSubjCd = (JSPUtil.getParameter(request, prefix + "lgs_cost_subj_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new CostListVO();
                if (acctNm[i] != null)
                    model.setAcctNm(acctNm[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (costCd[i] != null)
                    model.setCostCd(costCd[i]);
                if (costNm[i] != null)
                    model.setCostNm(costNm[i]);
                if (acctCd[i] != null)
                    model.setAcctCd(acctCd[i]);
                if (acctEngNm[i] != null)
                    model.setAcctEngNm(acctEngNm[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (lgsCostSubjCd[i] != null) 
		    		model.setLgsCostSubjCd(lgsCostSubjCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getCostListVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return CostListVO[]
	 */
    public CostListVO[] getCostListVOs() {
        CostListVO[] vos = (CostListVO[]) models.toArray(new CostListVO[models.size()]);
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
        this.acctNm = this.acctNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.costCd = this.costCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.costNm = this.costNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acctCd = this.acctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acctEngNm = this.acctEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lgsCostSubjCd = this.lgsCostSubjCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
