/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CmbConditionVO.java
*@FileTitle : CmbConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.13
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.01.13 박희동 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo;

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
 * @author 박희동
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class CmbConditionVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<CmbConditionVO> models = new ArrayList<CmbConditionVO>();

    /* Column Info */
    private String ofcCd = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String acctYrmon = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String reDivrCd = null;

    /* Column Info */
    private String trdCd = null;

    /* Column Info */
    private String joCrrCd = null;

    /* Column Info */
    private String rlaneCd = null;

    /* Column Info */
    private String stlCmbSeq = null;

    /* Column Info */
    private String updUsrId = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String loclCurrCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public CmbConditionVO() {
    }

    public CmbConditionVO(String ibflag, String pagerows, String acctYrmon, String joCrrCd, String trdCd, String rlaneCd, String reDivrCd, String updUsrId, String creUsrId, String stlCmbSeq, String ofcCd, String loclCurrCd) {
        this.ofcCd = ofcCd;
        this.creUsrId = creUsrId;
        this.acctYrmon = acctYrmon;
        this.ibflag = ibflag;
        this.reDivrCd = reDivrCd;
        this.trdCd = trdCd;
        this.joCrrCd = joCrrCd;
        this.rlaneCd = rlaneCd;
        this.stlCmbSeq = stlCmbSeq;
        this.updUsrId = updUsrId;
        this.pagerows = pagerows;
        this.loclCurrCd = loclCurrCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ofc_cd", getOfcCd());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("acct_yrmon", getAcctYrmon());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("re_divr_cd", getReDivrCd());
        this.hashColumns.put("trd_cd", getTrdCd());
        this.hashColumns.put("jo_crr_cd", getJoCrrCd());
        this.hashColumns.put("rlane_cd", getRlaneCd());
        this.hashColumns.put("stl_cmb_seq", getStlCmbSeq());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ofc_cd", "ofcCd");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("acct_yrmon", "acctYrmon");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("re_divr_cd", "reDivrCd");
        this.hashFields.put("trd_cd", "trdCd");
        this.hashFields.put("jo_crr_cd", "joCrrCd");
        this.hashFields.put("rlane_cd", "rlaneCd");
        this.hashFields.put("stl_cmb_seq", "stlCmbSeq");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("locl_curr_cd", "loclCurrCd");
        return this.hashFields;
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
	 * @return creUsrId
	 */
    public String getCreUsrId() {
        return this.creUsrId;
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
	 * @return reDivrCd
	 */
    public String getReDivrCd() {
        return this.reDivrCd;
    }

    /**
	 * Column Info
	 * @return trdCd
	 */
    public String getTrdCd() {
        return this.trdCd;
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
	 * @return rlaneCd
	 */
    public String getRlaneCd() {
        return this.rlaneCd;
    }

    /**
	 * Column Info
	 * @return stlCmbSeq
	 */
    public String getStlCmbSeq() {
        return this.stlCmbSeq;
    }

    /**
	 * Column Info
	 * @return updUsrId
	 */
    public String getUpdUsrId() {
        return this.updUsrId;
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
	 * @param ofcCd
	 */
    public void setOfcCd(String ofcCd) {
        this.ofcCd = ofcCd;
    }

    /**
	 * Column Info
	 * @param creUsrId
	 */
    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
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
	 * @param reDivrCd
	 */
    public void setReDivrCd(String reDivrCd) {
        this.reDivrCd = reDivrCd;
    }

    /**
	 * Column Info
	 * @param trdCd
	 */
    public void setTrdCd(String trdCd) {
        this.trdCd = trdCd;
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
	 * @param rlaneCd
	 */
    public void setRlaneCd(String rlaneCd) {
        this.rlaneCd = rlaneCd;
    }

    /**
	 * Column Info
	 * @param stlCmbSeq
	 */
    public void setStlCmbSeq(String stlCmbSeq) {
        this.stlCmbSeq = stlCmbSeq;
    }

    /**
	 * Column Info
	 * @param updUsrId
	 */
    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    public void setLoclCurrCd(String loclCurrCd) {
        this.loclCurrCd = loclCurrCd;
    }

    public String getLoclCurrCd() {
        return this.loclCurrCd;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
        setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
        setAcctYrmon(JSPUtil.getParameter(request, "acct_yrmon", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setReDivrCd(JSPUtil.getParameter(request, "re_divr_cd", ""));
        setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
        setJoCrrCd(JSPUtil.getParameter(request, "jo_crr_cd", ""));
        setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
        setStlCmbSeq(JSPUtil.getParameter(request, "stl_cmb_seq", ""));
        setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setLoclCurrCd(JSPUtil.getParameter(request, "locl_curr_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CmbConditionVO[]
	 */
    public CmbConditionVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CmbConditionVO[]
	 */
    public CmbConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        CmbConditionVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ofcCd = (JSPUtil.getParameter(request, prefix + "ofc_cd", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] acctYrmon = (JSPUtil.getParameter(request, prefix + "acct_yrmon", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] reDivrCd = (JSPUtil.getParameter(request, prefix + "re_divr_cd", length));
            String[] trdCd = (JSPUtil.getParameter(request, prefix + "trd_cd", length));
            String[] joCrrCd = (JSPUtil.getParameter(request, prefix + "jo_crr_cd", length));
            String[] rlaneCd = (JSPUtil.getParameter(request, prefix + "rlane_cd", length));
            String[] stlCmbSeq = (JSPUtil.getParameter(request, prefix + "stl_cmb_seq", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] loclCurrCd = (JSPUtil.getParameter(request, prefix + "locl_curr_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new CmbConditionVO();
                if (ofcCd[i] != null)
                    model.setOfcCd(ofcCd[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (acctYrmon[i] != null)
                    model.setAcctYrmon(acctYrmon[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (reDivrCd[i] != null)
                    model.setReDivrCd(reDivrCd[i]);
                if (trdCd[i] != null)
                    model.setTrdCd(trdCd[i]);
                if (joCrrCd[i] != null)
                    model.setJoCrrCd(joCrrCd[i]);
                if (rlaneCd[i] != null)
                    model.setRlaneCd(rlaneCd[i]);
                if (stlCmbSeq[i] != null)
                    model.setStlCmbSeq(stlCmbSeq[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (loclCurrCd[i] != null) 
		    		model.setLoclCurrCd(loclCurrCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getCmbConditionVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return CmbConditionVO[]
	 */
    public CmbConditionVO[] getCmbConditionVOs() {
        CmbConditionVO[] vos = (CmbConditionVO[]) models.toArray(new CmbConditionVO[models.size()]);
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
        this.ofcCd = this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acctYrmon = this.acctYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.reDivrCd = this.reDivrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trdCd = this.trdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.joCrrCd = this.joCrrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rlaneCd = this.rlaneCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stlCmbSeq = this.stlCmbSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.loclCurrCd = this.loclCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
