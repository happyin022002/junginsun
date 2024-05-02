/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ConditionEstmIfVO.java
*@FileTitle : ConditionEstmIfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.28
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo;

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
public class ConditionEstmIfVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<ConditionEstmIfVO> models = new ArrayList<ConditionEstmIfVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String frDuration = null;

    /* Column Info */
    private String toDuration = null;

    /* Column Info */
    private String fletCtrtTpCd = null;

    /* Column Info */
    private String exeYrmon = null;

    /* Column Info */
    private String estType = null;

    /* Column Info */
    private String acctCd = null;

    /* Column Info */
    private String acctCds = null;

    /* Column Info */
    private String vvdCd = null;

    /* Column Info */
    private String reDivrCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public ConditionEstmIfVO() {
    }

    public ConditionEstmIfVO(String ibflag, String pagerows, String frDuration, String toDuration, String fletCtrtTpCd, String exeYrmon, String estType, String acctCd, String acctCds, String vvdCd, String reDivrCd) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.frDuration = frDuration;
        this.toDuration = toDuration;
        this.fletCtrtTpCd = fletCtrtTpCd;
        this.exeYrmon = exeYrmon;
        this.estType = estType;
        this.acctCd = acctCd;
        this.acctCds = acctCds;
        this.vvdCd = vvdCd;
        this.reDivrCd = reDivrCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("fr_duration", getFrDuration());
        this.hashColumns.put("to_duration", getToDuration());
        this.hashColumns.put("flet_ctrt_tp_cd", getFletCtrtTpCd());
        this.hashColumns.put("exe_yrmon", getExeYrmon());
        this.hashColumns.put("est_type", getEstType());
        this.hashColumns.put("acct_cd", getAcctCd());
        this.hashColumns.put("acct_cds", getAcctCds());
        this.hashColumns.put("vvd_cd", getVvdCd());
        this.hashColumns.put("re_divr_cd", getReDivrCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("fr_duration", "frDuration");
        this.hashFields.put("to_duration", "toDuration");
        this.hashFields.put("flet_ctrt_tp_cd", "fletCtrtTpCd");
        this.hashFields.put("exe_yrmon", "exeYrmon");
        this.hashFields.put("est_type", "estType");
        this.hashFields.put("acct_cd", "acctCd");
        this.hashFields.put("acct_cds", "acctCds");
        this.hashFields.put("vvd_cd", "vvdCd");
        this.hashFields.put("re_divr_cd", "reDivrCd");
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
	 * @param String frDuration
	 */
    public void setFrDuration(String frDuration) {
        this.frDuration = frDuration;
    }

    /**
	 * 
	 * @return String frDuration
	 */
    public String getFrDuration() {
        return this.frDuration;
    }

    /**
	 *
	 * @param String toDuration
	 */
    public void setToDuration(String toDuration) {
        this.toDuration = toDuration;
    }

    /**
	 * 
	 * @return String toDuration
	 */
    public String getToDuration() {
        return this.toDuration;
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
	 * @param String exeYrmon
	 */
    public void setExeYrmon(String exeYrmon) {
        this.exeYrmon = exeYrmon;
    }

    /**
	 * 
	 * @return String exeYrmon
	 */
    public String getExeYrmon() {
        return this.exeYrmon;
    }

    /**
	 *
	 * @param String estType
	 */
    public void setEstType(String estType) {
        this.estType = estType;
    }

    /**
	 * 
	 * @return String estType
	 */
    public String getEstType() {
        return this.estType;
    }

    public void setAcctCd(String acctCd) {
        this.acctCd = acctCd;
    }

    public String getAcctCd() {
        return this.acctCd;
    }

    public void setAcctCds(String acctCds) {
        this.acctCds = acctCds;
    }

    public String getAcctCds() {
        return this.acctCds;
    }

    public void setVvdCd(String vvdCd) {
        this.vvdCd = vvdCd;
    }

    public String getVvdCd() {
        return this.vvdCd;
    }

    public void setReDivrCd(String reDivrCd) {
        this.reDivrCd = reDivrCd;
    }

    public String getReDivrCd() {
        return this.reDivrCd;
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
        setFrDuration(JSPUtil.getParameter(request, prefix + "fr_duration", ""));
        setToDuration(JSPUtil.getParameter(request, prefix + "to_duration", ""));
        setFletCtrtTpCd(JSPUtil.getParameter(request, prefix + "flet_ctrt_tp_cd", ""));
        setExeYrmon(JSPUtil.getParameter(request, prefix + "exe_yrmon", ""));
        setEstType(JSPUtil.getParameter(request, prefix + "est_type", ""));
        setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
        setAcctCds(JSPUtil.getParameter(request, prefix + "acct_cds", ""));
        setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
        setReDivrCd(JSPUtil.getParameter(request, prefix + "re_divr_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ConditionEstmIfVO[]
	 */
    public ConditionEstmIfVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ConditionEstmIfVO[]
	 */
    public ConditionEstmIfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        ConditionEstmIfVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] frDuration = (JSPUtil.getParameter(request, prefix + "fr_duration", length));
            String[] toDuration = (JSPUtil.getParameter(request, prefix + "to_duration", length));
            String[] fletCtrtTpCd = (JSPUtil.getParameter(request, prefix + "flet_ctrt_tp_cd", length));
            String[] exeYrmon = (JSPUtil.getParameter(request, prefix + "exe_yrmon", length));
            String[] estType = (JSPUtil.getParameter(request, prefix + "est_type", length));
            String[] acctCd = (JSPUtil.getParameter(request, prefix + "acct_cd", length));
            String[] acctCds = (JSPUtil.getParameter(request, prefix + "acct_cds", length));
            String[] vvdCd = (JSPUtil.getParameter(request, prefix + "vvd_cd", length));
            String[] reDivrCd = (JSPUtil.getParameter(request, prefix + "re_divr_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new ConditionEstmIfVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (frDuration[i] != null)
                    model.setFrDuration(frDuration[i]);
                if (toDuration[i] != null)
                    model.setToDuration(toDuration[i]);
                if (fletCtrtTpCd[i] != null)
                    model.setFletCtrtTpCd(fletCtrtTpCd[i]);
                if (exeYrmon[i] != null)
                    model.setExeYrmon(exeYrmon[i]);
                if (estType[i] != null)
                    model.setEstType(estType[i]);
                if (acctCd[i] != null)
                    model.setAcctCd(acctCd[i]);
                if (acctCds[i] != null)
                    model.setAcctCds(acctCds[i]);
                if (vvdCd[i] != null)
                    model.setVvdCd(vvdCd[i]);
                if (reDivrCd[i] != null) 
		    		model.setReDivrCd(reDivrCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getConditionEstmIfVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return ConditionEstmIfVO[]
	 */
    public ConditionEstmIfVO[] getConditionEstmIfVOs() {
        ConditionEstmIfVO[] vos = (ConditionEstmIfVO[]) models.toArray(new ConditionEstmIfVO[models.size()]);
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
        this.frDuration = this.frDuration.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.toDuration = this.toDuration.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fletCtrtTpCd = this.fletCtrtTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.exeYrmon = this.exeYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.estType = this.estType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acctCd = this.acctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acctCds = this.acctCds.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvdCd = this.vvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.reDivrCd = this.reDivrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
