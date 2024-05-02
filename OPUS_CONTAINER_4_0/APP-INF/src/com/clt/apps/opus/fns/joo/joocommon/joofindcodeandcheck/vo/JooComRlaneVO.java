/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JooComRlaneVO.java
*@FileTitle : JooComRlaneVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.16 
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class JooComRlaneVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<JooComRlaneVO> models = new ArrayList<JooComRlaneVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String rlaneCd = null;

    /* Column Info */
    private String joCrrCd = null;

    /* Column Info */
    private String trdCd = null;

    /* Column Info */
    private String joStlOptCd = null;

    /* Column Info */
    private String joCrrAuthCd = null;

    /* Column Info */
    private String loclCurrCd = null;

    /* Column Info */
    private String joStlTgtTpCd = null;

    /* Column Info */
    private String reDivrCd = null;

    /* Column Info */
    private String joStlItmCd = null;

    /* Column Info */
    private String authOfcCd = null;

    /* Column Info */
    private String grpKey = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public JooComRlaneVO() {
    }

    public JooComRlaneVO(String ibflag, String pagerows, String rlaneCd, String joCrrCd, String trdCd, String joStlOptCd, String joCrrAuthCd, String loclCurrCd, String joStlTgtTpCd, String reDivrCd, String joStlItmCd, String authOfcCd, String grpKey) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.rlaneCd = rlaneCd;
        this.joCrrCd = joCrrCd;
        this.trdCd = trdCd;
        this.joStlOptCd = joStlOptCd;
        this.joCrrAuthCd = joCrrAuthCd;
        this.loclCurrCd = loclCurrCd;
        this.joStlTgtTpCd = joStlTgtTpCd;
        this.reDivrCd = reDivrCd;
        this.joStlItmCd = joStlItmCd;
        this.authOfcCd = authOfcCd;
        this.grpKey = grpKey;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("rlane_cd", getRlaneCd());
        this.hashColumns.put("jo_crr_cd", getJoCrrCd());
        this.hashColumns.put("trd_cd", getTrdCd());
        this.hashColumns.put("jo_stl_opt_cd", getJoStlOptCd());
        this.hashColumns.put("jo_crr_auth_cd", getJoCrrAuthCd());
        this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
        this.hashColumns.put("jo_stl_tgt_tp_cd", getJoStlTgtTpCd());
        this.hashColumns.put("re_divr_cd", getReDivrCd());
        this.hashColumns.put("jo_stl_itm_cd", getJoStlItmCd());
        this.hashColumns.put("auth_ofc_cd", getAuthOfcCd());
        this.hashColumns.put("grp_key", getGrpKey());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("rlane_cd", "rlaneCd");
        this.hashFields.put("jo_crr_cd", "joCrrCd");
        this.hashFields.put("trd_cd", "trdCd");
        this.hashFields.put("jo_stl_opt_cd", "joStlOptCd");
        this.hashFields.put("jo_crr_auth_cd", "joCrrAuthCd");
        this.hashFields.put("locl_curr_cd", "loclCurrCd");
        this.hashFields.put("jo_stl_tgt_tp_cd", "joStlTgtTpCd");
        this.hashFields.put("re_divr_cd", "reDivrCd");
        this.hashFields.put("jo_stl_itm_cd", "joStlItmCd");
        this.hashFields.put("auth_ofc_cd", "authOfcCd");
        this.hashFields.put("grp_key", "grpKey");
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
	 * @param String rlaneCd
	 */
    public void setRlaneCd(String rlaneCd) {
        this.rlaneCd = rlaneCd;
    }

    /**
	 * 
	 * @return String rlaneCd
	 */
    public String getRlaneCd() {
        return this.rlaneCd;
    }

    /**
	 *
	 * @param String joCrrCd
	 */
    public void setJoCrrCd(String joCrrCd) {
        this.joCrrCd = joCrrCd;
    }

    /**
	 * 
	 * @return String joCrrCd
	 */
    public String getJoCrrCd() {
        return this.joCrrCd;
    }

    /**
	 *
	 * @param String trdCd
	 */
    public void setTrdCd(String trdCd) {
        this.trdCd = trdCd;
    }

    /**
	 * 
	 * @return String trdCd
	 */
    public String getTrdCd() {
        return this.trdCd;
    }

    /**
	 *
	 * @param String joStlOptCd
	 */
    public void setJoStlOptCd(String joStlOptCd) {
        this.joStlOptCd = joStlOptCd;
    }

    /**
	 * 
	 * @return String joStlOptCd
	 */
    public String getJoStlOptCd() {
        return this.joStlOptCd;
    }

    /**
	 *
	 * @param String joCrrAuthCd
	 */
    public void setJoCrrAuthCd(String joCrrAuthCd) {
        this.joCrrAuthCd = joCrrAuthCd;
    }

    /**
	 * 
	 * @return String joCrrAuthCd
	 */
    public String getJoCrrAuthCd() {
        return this.joCrrAuthCd;
    }

    /**
	 *
	 * @param String loclCurrCd
	 */
    public void setLoclCurrCd(String loclCurrCd) {
        this.loclCurrCd = loclCurrCd;
    }

    /**
	 * 
	 * @return String loclCurrCd
	 */
    public String getLoclCurrCd() {
        return this.loclCurrCd;
    }

    /**
	 *
	 * @param String joStlTgtTpCd
	 */
    public void setJoStlTgtTpCd(String joStlTgtTpCd) {
        this.joStlTgtTpCd = joStlTgtTpCd;
    }

    /**
	 * 
	 * @return String joStlTgtTpCd
	 */
    public String getJoStlTgtTpCd() {
        return this.joStlTgtTpCd;
    }

    /**
	 *
	 * @param String reDivrCd
	 */
    public void setReDivrCd(String reDivrCd) {
        this.reDivrCd = reDivrCd;
    }

    /**
	 * 
	 * @return String reDivrCd
	 */
    public String getReDivrCd() {
        return this.reDivrCd;
    }

    /**
	 *
	 * @param String joStlItmCd
	 */
    public void setJoStlItmCd(String joStlItmCd) {
        this.joStlItmCd = joStlItmCd;
    }

    /**
	 * 
	 * @return String joStlItmCd
	 */
    public String getJoStlItmCd() {
        return this.joStlItmCd;
    }

    /**
	 *
	 * @param String authOfcCd
	 */
    public void setAuthOfcCd(String authOfcCd) {
        this.authOfcCd = authOfcCd;
    }

    /**
	 * 
	 * @return String authOfcCd
	 */
    public String getAuthOfcCd() {
        return this.authOfcCd;
    }

    public void setGrpKey(String grpKey) {
        this.grpKey = grpKey;
    }

    public String getGrpKey() {
        return this.grpKey;
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
        setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
        setJoCrrCd(JSPUtil.getParameter(request, prefix + "jo_crr_cd", ""));
        setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
        setJoStlOptCd(JSPUtil.getParameter(request, prefix + "jo_stl_opt_cd", ""));
        setJoCrrAuthCd(JSPUtil.getParameter(request, prefix + "jo_crr_auth_cd", ""));
        setLoclCurrCd(JSPUtil.getParameter(request, prefix + "locl_curr_cd", ""));
        setJoStlTgtTpCd(JSPUtil.getParameter(request, prefix + "jo_stl_tgt_tp_cd", ""));
        setReDivrCd(JSPUtil.getParameter(request, prefix + "re_divr_cd", ""));
        setJoStlItmCd(JSPUtil.getParameter(request, prefix + "jo_stl_itm_cd", ""));
        setAuthOfcCd(JSPUtil.getParameter(request, prefix + "auth_ofc_cd", ""));
        setGrpKey(JSPUtil.getParameter(request, prefix + "grp_key", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return JooComRlaneVO[]
	 */
    public JooComRlaneVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return JooComRlaneVO[]
	 */
    public JooComRlaneVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        JooComRlaneVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] rlaneCd = (JSPUtil.getParameter(request, prefix + "rlane_cd", length));
            String[] joCrrCd = (JSPUtil.getParameter(request, prefix + "jo_crr_cd", length));
            String[] trdCd = (JSPUtil.getParameter(request, prefix + "trd_cd", length));
            String[] joStlOptCd = (JSPUtil.getParameter(request, prefix + "jo_stl_opt_cd", length));
            String[] joCrrAuthCd = (JSPUtil.getParameter(request, prefix + "jo_crr_auth_cd", length));
            String[] loclCurrCd = (JSPUtil.getParameter(request, prefix + "locl_curr_cd", length));
            String[] joStlTgtTpCd = (JSPUtil.getParameter(request, prefix + "jo_stl_tgt_tp_cd", length));
            String[] reDivrCd = (JSPUtil.getParameter(request, prefix + "re_divr_cd", length));
            String[] joStlItmCd = (JSPUtil.getParameter(request, prefix + "jo_stl_itm_cd", length));
            String[] authOfcCd = (JSPUtil.getParameter(request, prefix + "auth_ofc_cd", length));
            String[] grpKey = (JSPUtil.getParameter(request, prefix + "grp_key", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new JooComRlaneVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (rlaneCd[i] != null)
                    model.setRlaneCd(rlaneCd[i]);
                if (joCrrCd[i] != null)
                    model.setJoCrrCd(joCrrCd[i]);
                if (trdCd[i] != null)
                    model.setTrdCd(trdCd[i]);
                if (joStlOptCd[i] != null)
                    model.setJoStlOptCd(joStlOptCd[i]);
                if (joCrrAuthCd[i] != null)
                    model.setJoCrrAuthCd(joCrrAuthCd[i]);
                if (loclCurrCd[i] != null)
                    model.setLoclCurrCd(loclCurrCd[i]);
                if (joStlTgtTpCd[i] != null)
                    model.setJoStlTgtTpCd(joStlTgtTpCd[i]);
                if (reDivrCd[i] != null)
                    model.setReDivrCd(reDivrCd[i]);
                if (joStlItmCd[i] != null)
                    model.setJoStlItmCd(joStlItmCd[i]);
                if (authOfcCd[i] != null)
                    model.setAuthOfcCd(authOfcCd[i]);
                if (grpKey[i] != null) 
		    		model.setGrpKey(grpKey[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getJooComRlaneVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return JooComRlaneVO[]
	 */
    public JooComRlaneVO[] getJooComRlaneVOs() {
        JooComRlaneVO[] vos = (JooComRlaneVO[]) models.toArray(new JooComRlaneVO[models.size()]);
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
        this.rlaneCd = this.rlaneCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.joCrrCd = this.joCrrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trdCd = this.trdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.joStlOptCd = this.joStlOptCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.joCrrAuthCd = this.joCrrAuthCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.loclCurrCd = this.loclCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.joStlTgtTpCd = this.joStlTgtTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.reDivrCd = this.reDivrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.joStlItmCd = this.joStlItmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.authOfcCd = this.authOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.grpKey = this.grpKey.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
