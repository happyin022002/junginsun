/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : JoMasterConditionVO.java
*@FileTitle : JoMasterConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.16
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.vo;

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
public class MstConditionVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<MstConditionVO> models = new ArrayList<MstConditionVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String joCrrCd = null;

    /* Column Info */
    private String rlaneCd = null;

    /* Column Info */
    private String trdCd = null;

    /* Column Info */
    private String vndrSeq = null;

    /* Column Info */
    private String reDivrCd = null;

    /* Column Info */
    private String custCntCd = null;

    /* Column Info */
    private String custSeq = null;

    /* Column Info */
    private String authOfcCd = null;

    /* Column Info */
    private String deltFlg = null;

    /* Column Info */
    private String custCd = null;

    /* Column Info */
    private String ofcCd = null;

    /* Column Info */
    private String loclCurrCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public MstConditionVO() {
    }

    public MstConditionVO(String ibflag, String pagerows, String joCrrCd, String rlaneCd, String trdCd, String vndrSeq, String reDivrCd, String custCntCd, String custSeq, String authOfcCd, String deltFlg, String custCd, String ofcCd, String loclCurrCd) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.joCrrCd = joCrrCd;
        this.rlaneCd = rlaneCd;
        this.trdCd = trdCd;
        this.vndrSeq = vndrSeq;
        this.reDivrCd = reDivrCd;
        this.custCntCd = custCntCd;
        this.custSeq = custSeq;
        this.authOfcCd = authOfcCd;
        this.deltFlg = deltFlg;
        this.custCd = custCd;
        this.ofcCd = ofcCd;
        this.loclCurrCd = loclCurrCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("jo_crr_cd", getJoCrrCd());
        this.hashColumns.put("rlane_cd", getRlaneCd());
        this.hashColumns.put("trd_cd", getTrdCd());
        this.hashColumns.put("vndr_seq", getVndrSeq());
        this.hashColumns.put("re_divr_cd", getReDivrCd());
        this.hashColumns.put("cust_cnt_cd", getCustCntCd());
        this.hashColumns.put("cust_seq", getCustSeq());
        this.hashColumns.put("auth_ofc_cd", getAuthOfcCd());
        this.hashColumns.put("delt_flg", getDeltFlg());
        this.hashColumns.put("cust_cd", getCustCd());
        this.hashColumns.put("ofc_cd", getOfcCd());
        this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("jo_crr_cd", "joCrrCd");
        this.hashFields.put("rlane_cd", "rlaneCd");
        this.hashFields.put("trd_cd", "trdCd");
        this.hashFields.put("vndr_seq", "vndrSeq");
        this.hashFields.put("re_divr_cd", "reDivrCd");
        this.hashFields.put("cust_cnt_cd", "custCntCd");
        this.hashFields.put("cust_seq", "custSeq");
        this.hashFields.put("auth_ofc_cd", "authOfcCd");
        this.hashFields.put("delt_flg", "deltFlg");
        this.hashFields.put("cust_cd", "custCd");
        this.hashFields.put("ofc_cd", "ofcCd");
        this.hashFields.put("locl_curr_cd", "loclCurrCd");
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
	 * @param String vndrSeq
	 */
    public void setVndrSeq(String vndrSeq) {
        this.vndrSeq = vndrSeq;
    }

    /**
	 * 
	 * @return String vndrSeq
	 */
    public String getVndrSeq() {
        return this.vndrSeq;
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
	 * @param String custCntCd
	 */
    public void setCustCntCd(String custCntCd) {
        this.custCntCd = custCntCd;
    }

    /**
	 * 
	 * @return String custCntCd
	 */
    public String getCustCntCd() {
        return this.custCntCd;
    }

    /**
	 *
	 * @param String custSeq
	 */
    public void setCustSeq(String custSeq) {
        this.custSeq = custSeq;
    }

    /**
	 * 
	 * @return String custSeq
	 */
    public String getCustSeq() {
        return this.custSeq;
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

    public void setDeltFlg(String deltFlg) {
        this.deltFlg = deltFlg;
    }

    public String getDeltFlg() {
        return this.deltFlg;
    }

    public void setCustCd(String custCd) {
        this.custCd = custCd;
    }

    public String getCustCd() {
        return this.custCd;
    }

    public void setOfcCd(String ofcCd) {
        this.ofcCd = ofcCd;
    }

    public String getOfcCd() {
        return this.ofcCd;
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
        fromRequest(request, "");
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request, String prefix) {
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setJoCrrCd(JSPUtil.getParameter(request, prefix + "jo_crr_cd", ""));
        setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
        setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
        setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
        setReDivrCd(JSPUtil.getParameter(request, prefix + "re_divr_cd", ""));
        setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
        setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
        setAuthOfcCd(JSPUtil.getParameter(request, prefix + "auth_ofc_cd", ""));
        setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
        setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
        setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
        setLoclCurrCd(JSPUtil.getParameter(request, prefix + "locl_curr_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return JoMasterConditionVO[]
	 */
    public MstConditionVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return JoMasterConditionVO[]
	 */
    public MstConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        MstConditionVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] joCrrCd = (JSPUtil.getParameter(request, prefix + "jo_crr_cd", length));
            String[] rlaneCd = (JSPUtil.getParameter(request, prefix + "rlane_cd", length));
            String[] trdCd = (JSPUtil.getParameter(request, prefix + "trd_cd", length));
            String[] vndrSeq = (JSPUtil.getParameter(request, prefix + "vndr_seq", length));
            String[] reDivrCd = (JSPUtil.getParameter(request, prefix + "re_divr_cd", length));
            String[] custCntCd = (JSPUtil.getParameter(request, prefix + "cust_cnt_cd", length));
            String[] custSeq = (JSPUtil.getParameter(request, prefix + "cust_seq", length));
            String[] authOfcCd = (JSPUtil.getParameter(request, prefix + "auth_ofc_cd", length));
            String[] deltFlg = (JSPUtil.getParameter(request, prefix + "delt_flg", length));
            String[] custCd = (JSPUtil.getParameter(request, prefix + "cust_cd", length));
            String[] ofcCd = (JSPUtil.getParameter(request, prefix + "ofc_cd", length));
            String[] loclCurrCd = (JSPUtil.getParameter(request, prefix + "locl_curr_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new MstConditionVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (joCrrCd[i] != null)
                    model.setJoCrrCd(joCrrCd[i]);
                if (rlaneCd[i] != null)
                    model.setRlaneCd(rlaneCd[i]);
                if (trdCd[i] != null)
                    model.setTrdCd(trdCd[i]);
                if (vndrSeq[i] != null)
                    model.setVndrSeq(vndrSeq[i]);
                if (reDivrCd[i] != null)
                    model.setReDivrCd(reDivrCd[i]);
                if (custCntCd[i] != null)
                    model.setCustCntCd(custCntCd[i]);
                if (custSeq[i] != null)
                    model.setCustSeq(custSeq[i]);
                if (authOfcCd[i] != null)
                    model.setAuthOfcCd(authOfcCd[i]);
                if (deltFlg[i] != null)
                    model.setDeltFlg(deltFlg[i]);
                if (custCd[i] != null)
                    model.setCustCd(custCd[i]);
                if (ofcCd[i] != null)
                    model.setOfcCd(ofcCd[i]);
                if (loclCurrCd[i] != null) 
		    		model.setLoclCurrCd(loclCurrCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getJoMasterConditionVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return JoMasterConditionVO[]
	 */
    public MstConditionVO[] getJoMasterConditionVOs() {
        MstConditionVO[] vos = (MstConditionVO[]) models.toArray(new MstConditionVO[models.size()]);
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
        this.joCrrCd = this.joCrrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rlaneCd = this.rlaneCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trdCd = this.trdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrSeq = this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.reDivrCd = this.reDivrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCntCd = this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custSeq = this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.authOfcCd = this.authOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deltFlg = this.deltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCd = this.custCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcCd = this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.loclCurrCd = this.loclCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
