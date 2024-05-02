/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CarrierVO.java
*@FileTitle : CarrierVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.09.29 박희동 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
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
public class CarrierVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<CarrierVO> models = new ArrayList<CarrierVO>();

    /* Column Info */
    private String deltFlg = null;

    /* Column Info */
    private String vndrLglEngNm = null;

    /* Column Info */
    private String joCrrCd = null;

    /* Column Info */
    private String trdCd = null;

    /* Column Info */
    private String rlaneCd = null;

    /* Column Info */
    private String joStlOptCd = null;

    /* Column Info */
    private String bzetAddr = null;

    /* Column Info */
    private String custSeq = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String custLglEngNm = null;

    /* Column Info */
    private String ofcCd = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String usrId = null;

    /* Column Info */
    private String vndrSeq = null;

    /* Column Info */
    private String reDivrCd = null;

    /* Column Info */
    private String custCntCd = null;

    /* Column Info */
    private String custCd = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String existAuthFlg = null;

    /* Column Info */
    private String existFincMtxFlg = null;

    /* Column Info */
    private String existStlVvdFlg = null;

    /* Column Info */
    private String existStlBssPortFlg = null;

    /* Column Info */
    private String rlaneCds = null;

    /* Column Info */
    private String trdCds = null;

    /* Column Info */
    private String existChildFlg = null;

    /* Column Info */
    private String loclCurrCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public CarrierVO() {
    }

    public CarrierVO(String ibflag, String pagerows, String joCrrCd, String trdCd, String rlaneCd, String custCntCd, String custSeq, String joStlOptCd, String custLglEngNm, String vndrSeq, String vndrLglEngNm, String deltFlg, String usrId, String reDivrCd, String ofcCd, String bzetAddr, String custCd, String creDt, String creUsrId, String updDt, String updUsrId, String existAuthFlg, String existFincMtxFlg, String existStlVvdFlg, String existStlBssPortFlg, String rlaneCds, String trdCds, String existChildFlg, String loclCurrCd) {
        this.deltFlg = deltFlg;
        this.vndrLglEngNm = vndrLglEngNm;
        this.joCrrCd = joCrrCd;
        this.trdCd = trdCd;
        this.rlaneCd = rlaneCd;
        this.joStlOptCd = joStlOptCd;
        this.bzetAddr = bzetAddr;
        this.custSeq = custSeq;
        this.pagerows = pagerows;
        this.custLglEngNm = custLglEngNm;
        this.ofcCd = ofcCd;
        this.ibflag = ibflag;
        this.usrId = usrId;
        this.vndrSeq = vndrSeq;
        this.reDivrCd = reDivrCd;
        this.custCntCd = custCntCd;
        this.custCd = custCd;
        this.creDt = creDt;
        this.creUsrId = creUsrId;
        this.updDt = updDt;
        this.updUsrId = updUsrId;
        this.existAuthFlg = existAuthFlg;
        this.existFincMtxFlg = existFincMtxFlg;
        this.existStlVvdFlg = existStlVvdFlg;
        this.existStlBssPortFlg = existStlBssPortFlg;
        this.rlaneCds = rlaneCds;
        this.trdCds = trdCds;
        this.existChildFlg = existChildFlg;
        this.loclCurrCd = loclCurrCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("delt_flg", getDeltFlg());
        this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
        this.hashColumns.put("jo_crr_cd", getJoCrrCd());
        this.hashColumns.put("trd_cd", getTrdCd());
        this.hashColumns.put("rlane_cd", getRlaneCd());
        this.hashColumns.put("jo_stl_opt_cd", getJoStlOptCd());
        this.hashColumns.put("bzet_addr", getBzetAddr());
        this.hashColumns.put("cust_seq", getCustSeq());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
        this.hashColumns.put("ofc_cd", getOfcCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("usr_id", getUsrId());
        this.hashColumns.put("vndr_seq", getVndrSeq());
        this.hashColumns.put("re_divr_cd", getReDivrCd());
        this.hashColumns.put("cust_cnt_cd", getCustCntCd());
        this.hashColumns.put("cust_cd", getCustCd());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("exist_auth_flg", getExistAuthFlg());
        this.hashColumns.put("exist_finc_mtx_flg", getExistFincMtxFlg());
        this.hashColumns.put("exist_stl_vvd_flg", getExistStlVvdFlg());
        this.hashColumns.put("exist_stl_bss_port_flg", getExistStlBssPortFlg());
        this.hashColumns.put("rlane_cds", getRlaneCds());
        this.hashColumns.put("trd_cds", getTrdCds());
        this.hashColumns.put("exist_child_flg", getExistChildFlg());
        this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("delt_flg", "deltFlg");
        this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
        this.hashFields.put("jo_crr_cd", "joCrrCd");
        this.hashFields.put("trd_cd", "trdCd");
        this.hashFields.put("rlane_cd", "rlaneCd");
        this.hashFields.put("jo_stl_opt_cd", "joStlOptCd");
        this.hashFields.put("bzet_addr", "bzetAddr");
        this.hashFields.put("cust_seq", "custSeq");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
        this.hashFields.put("ofc_cd", "ofcCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("usr_id", "usrId");
        this.hashFields.put("vndr_seq", "vndrSeq");
        this.hashFields.put("re_divr_cd", "reDivrCd");
        this.hashFields.put("cust_cnt_cd", "custCntCd");
        this.hashFields.put("cust_cd", "custCd");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("exist_auth_flg", "existAuthFlg");
        this.hashFields.put("exist_finc_mtx_flg", "existFincMtxFlg");
        this.hashFields.put("exist_stl_vvd_flg", "existStlVvdFlg");
        this.hashFields.put("exist_stl_bss_port_flg", "existStlBssPortFlg");
        this.hashFields.put("rlane_cds", "rlaneCds");
        this.hashFields.put("trd_cds", "trdCds");
        this.hashFields.put("exist_child_flg", "existChildFlg");
        this.hashFields.put("locl_curr_cd", "loclCurrCd");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return deltFlg
	 */
    public String getDeltFlg() {
        return this.deltFlg;
    }

    /**
	 * Column Info
	 * @return vndrLglEngNm
	 */
    public String getVndrLglEngNm() {
        return this.vndrLglEngNm;
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
	 * @return trdCd
	 */
    public String getTrdCd() {
        return this.trdCd;
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
	 * @return joStlOptCd
	 */
    public String getJoStlOptCd() {
        return this.joStlOptCd;
    }

    /**
	 * Column Info
	 * @return bzetAddr
	 */
    public String getBzetAddr() {
        return this.bzetAddr;
    }

    /**
	 * Column Info
	 * @return custSeq
	 */
    public String getCustSeq() {
        return this.custSeq;
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
	 * @return custLglEngNm
	 */
    public String getCustLglEngNm() {
        return this.custLglEngNm;
    }

    /**
	 * Column Info
	 * @return ofcCd
	 */
    public String getOfcCd() {
        return this.ofcCd;
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
	 * @return usrId
	 */
    public String getUsrId() {
        return this.usrId;
    }

    /**
	 * Column Info
	 * @return vndrSeq
	 */
    public String getVndrSeq() {
        return this.vndrSeq;
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
	 * @return custCntCd
	 */
    public String getCustCntCd() {
        return this.custCntCd;
    }

    /**
	 * Column Info
	 * @param deltFlg
	 */
    public void setDeltFlg(String deltFlg) {
        this.deltFlg = deltFlg;
    }

    /**
	 * Column Info
	 * @param vndrLglEngNm
	 */
    public void setVndrLglEngNm(String vndrLglEngNm) {
        this.vndrLglEngNm = vndrLglEngNm;
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
	 * @param trdCd
	 */
    public void setTrdCd(String trdCd) {
        this.trdCd = trdCd;
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
	 * @param joStlOptCd
	 */
    public void setJoStlOptCd(String joStlOptCd) {
        this.joStlOptCd = joStlOptCd;
    }

    /**
	 * Column Info
	 * @param bzetAddr
	 */
    public void setBzetAddr(String bzetAddr) {
        this.bzetAddr = bzetAddr;
    }

    /**
	 * Column Info
	 * @param custSeq
	 */
    public void setCustSeq(String custSeq) {
        this.custSeq = custSeq;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    /**
	 * Column Info
	 * @param custLglEngNm
	 */
    public void setCustLglEngNm(String custLglEngNm) {
        this.custLglEngNm = custLglEngNm;
    }

    /**
	 * Column Info
	 * @param ofcCd
	 */
    public void setOfcCd(String ofcCd) {
        this.ofcCd = ofcCd;
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
	 * @param usrId
	 */
    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

    /**
	 * Column Info
	 * @param vndrSeq
	 */
    public void setVndrSeq(String vndrSeq) {
        this.vndrSeq = vndrSeq;
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
	 * @param custCntCd
	 */
    public void setCustCntCd(String custCntCd) {
        this.custCntCd = custCntCd;
    }

    public void setCustCd(String custCd) {
        this.custCd = custCd;
    }

    public String getCustCd() {
        return this.custCd;
    }

    public void setCreDt(String creDt) {
        this.creDt = creDt;
    }

    public String getCreDt() {
        return this.creDt;
    }

    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
    }

    public String getCreUsrId() {
        return this.creUsrId;
    }

    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    public String getUpdDt() {
        return this.updDt;
    }

    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
    }

    public String getUpdUsrId() {
        return this.updUsrId;
    }

    public void setExistAuthFlg(String existAuthFlg) {
        this.existAuthFlg = existAuthFlg;
    }

    public String getExistAuthFlg() {
        return this.existAuthFlg;
    }

    public void setExistFincMtxFlg(String existFincMtxFlg) {
        this.existFincMtxFlg = existFincMtxFlg;
    }

    public String getExistFincMtxFlg() {
        return this.existFincMtxFlg;
    }

    public void setExistStlVvdFlg(String existStlVvdFlg) {
        this.existStlVvdFlg = existStlVvdFlg;
    }

    public String getExistStlVvdFlg() {
        return this.existStlVvdFlg;
    }

    public void setExistStlBssPortFlg(String existStlBssPortFlg) {
        this.existStlBssPortFlg = existStlBssPortFlg;
    }

    public String getExistStlBssPortFlg() {
        return this.existStlBssPortFlg;
    }

    public void setRlaneCds(String rlaneCds) {
        this.rlaneCds = rlaneCds;
    }

    public String getRlaneCds() {
        return this.rlaneCds;
    }

    public void setTrdCds(String trdCds) {
        this.trdCds = trdCds;
    }

    public String getTrdCds() {
        return this.trdCds;
    }

    public void setExistChildFlg(String existChildFlg) {
        this.existChildFlg = existChildFlg;
    }

    public String getExistChildFlg() {
        return this.existChildFlg;
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
        setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
        setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
        setJoCrrCd(JSPUtil.getParameter(request, prefix + "jo_crr_cd", ""));
        setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
        setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
        setJoStlOptCd(JSPUtil.getParameter(request, prefix + "jo_stl_opt_cd", ""));
        setBzetAddr(JSPUtil.getParameter(request, prefix + "bzet_addr", ""));
        setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
        setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
        setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
        setReDivrCd(JSPUtil.getParameter(request, prefix + "re_divr_cd", ""));
        setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
        setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setExistAuthFlg(JSPUtil.getParameter(request, prefix + "exist_auth_flg", ""));
        setExistFincMtxFlg(JSPUtil.getParameter(request, prefix + "exist_finc_mtx_flg", ""));
        setExistStlVvdFlg(JSPUtil.getParameter(request, prefix + "exist_stl_vvd_flg", ""));
        setExistStlBssPortFlg(JSPUtil.getParameter(request, prefix + "exist_stl_bss_port_flg", ""));
        setRlaneCds(JSPUtil.getParameter(request, prefix + "rlane_cds", ""));
        setTrdCds(JSPUtil.getParameter(request, prefix + "trd_cds", ""));
        setExistChildFlg(JSPUtil.getParameter(request, prefix + "exist_child_flg", ""));
        setLoclCurrCd(JSPUtil.getParameter(request, prefix + "locl_curr_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CarrierVO[]
	 */
    public CarrierVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CarrierVO[]
	 */
    public CarrierVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        CarrierVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] deltFlg = (JSPUtil.getParameter(request, prefix + "delt_flg", length));
            String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", length));
            String[] joCrrCd = (JSPUtil.getParameter(request, prefix + "jo_crr_cd", length));
            String[] trdCd = (JSPUtil.getParameter(request, prefix + "trd_cd", length));
            String[] rlaneCd = (JSPUtil.getParameter(request, prefix + "rlane_cd", length));
            String[] joStlOptCd = (JSPUtil.getParameter(request, prefix + "jo_stl_opt_cd", length));
            String[] bzetAddr = (JSPUtil.getParameter(request, prefix + "bzet_addr", length));
            String[] custSeq = (JSPUtil.getParameter(request, prefix + "cust_seq", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] custLglEngNm = (JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", length));
            String[] ofcCd = (JSPUtil.getParameter(request, prefix + "ofc_cd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] usrId = (JSPUtil.getParameter(request, prefix + "usr_id", length));
            String[] vndrSeq = (JSPUtil.getParameter(request, prefix + "vndr_seq", length));
            String[] reDivrCd = (JSPUtil.getParameter(request, prefix + "re_divr_cd", length));
            String[] custCntCd = (JSPUtil.getParameter(request, prefix + "cust_cnt_cd", length));
            String[] custCd = (JSPUtil.getParameter(request, prefix + "cust_cd", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] existAuthFlg = (JSPUtil.getParameter(request, prefix + "exist_auth_flg", length));
            String[] existFincMtxFlg = (JSPUtil.getParameter(request, prefix + "exist_finc_mtx_flg", length));
            String[] existStlVvdFlg = (JSPUtil.getParameter(request, prefix + "exist_stl_vvd_flg", length));
            String[] existStlBssPortFlg = (JSPUtil.getParameter(request, prefix + "exist_stl_bss_port_flg", length));
            String[] rlaneCds = (JSPUtil.getParameter(request, prefix + "rlane_cds", length));
            String[] trdCds = (JSPUtil.getParameter(request, prefix + "trd_cds", length));
            String[] existChildFlg = (JSPUtil.getParameter(request, prefix + "exist_child_flg", length));
            String[] loclCurrCd = (JSPUtil.getParameter(request, prefix + "locl_curr_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new CarrierVO();
                if (deltFlg[i] != null)
                    model.setDeltFlg(deltFlg[i]);
                if (vndrLglEngNm[i] != null)
                    model.setVndrLglEngNm(vndrLglEngNm[i]);
                if (joCrrCd[i] != null)
                    model.setJoCrrCd(joCrrCd[i]);
                if (trdCd[i] != null)
                    model.setTrdCd(trdCd[i]);
                if (rlaneCd[i] != null)
                    model.setRlaneCd(rlaneCd[i]);
                if (joStlOptCd[i] != null)
                    model.setJoStlOptCd(joStlOptCd[i]);
                if (bzetAddr[i] != null)
                    model.setBzetAddr(bzetAddr[i]);
                if (custSeq[i] != null)
                    model.setCustSeq(custSeq[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (custLglEngNm[i] != null)
                    model.setCustLglEngNm(custLglEngNm[i]);
                if (ofcCd[i] != null)
                    model.setOfcCd(ofcCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (usrId[i] != null)
                    model.setUsrId(usrId[i]);
                if (vndrSeq[i] != null)
                    model.setVndrSeq(vndrSeq[i]);
                if (reDivrCd[i] != null)
                    model.setReDivrCd(reDivrCd[i]);
                if (custCntCd[i] != null)
                    model.setCustCntCd(custCntCd[i]);
                if (custCd[i] != null)
                    model.setCustCd(custCd[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (existAuthFlg[i] != null)
                    model.setExistAuthFlg(existAuthFlg[i]);
                if (existFincMtxFlg[i] != null)
                    model.setExistFincMtxFlg(existFincMtxFlg[i]);
                if (existStlVvdFlg[i] != null)
                    model.setExistStlVvdFlg(existStlVvdFlg[i]);
                if (existStlBssPortFlg[i] != null)
                    model.setExistStlBssPortFlg(existStlBssPortFlg[i]);
                if (rlaneCds[i] != null)
                    model.setRlaneCds(rlaneCds[i]);
                if (trdCds[i] != null)
                    model.setTrdCds(trdCds[i]);
                if (existChildFlg[i] != null)
                    model.setExistChildFlg(existChildFlg[i]);
                if (loclCurrCd[i] != null) 
		    		model.setLoclCurrCd(loclCurrCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getCarrierVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return CarrierVO[]
	 */
    public CarrierVO[] getCarrierVOs() {
        CarrierVO[] vos = (CarrierVO[]) models.toArray(new CarrierVO[models.size()]);
        return vos;
    }

    /**
	 * VO Class의 내용을 String으로 변환
	 */
    public String toString() {
        StringBuffer ret = new StringBuffer();
        Field[] field = this.getClass().getDeclaredFields();
        String space = "";
        try {
            for (int i = 0; i < field.length; i++) {
                String[] arr = null;
                arr = getField(field, i);
                if (arr != null) {
                    for (int j = 0; j < arr.length; j++) {
                        ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
                    }
                } else {
                    ret.append(field[i].getName() + " =  null \n");
                }
            }
        } catch (Exception ex) {
            return null;
        }
        return ret.toString();
    }

    /**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
    private String[] getField(Field[] field, int i) {
        String[] arr = null;
        try {
            arr = (String[]) field[i].get(this);
        } catch (Exception ex) {
            arr = null;
        }
        return arr;
    }

    /**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
    public void unDataFormat() {
        this.deltFlg = this.deltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrLglEngNm = this.vndrLglEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.joCrrCd = this.joCrrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trdCd = this.trdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rlaneCd = this.rlaneCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.joStlOptCd = this.joStlOptCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bzetAddr = this.bzetAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custSeq = this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custLglEngNm = this.custLglEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcCd = this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usrId = this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrSeq = this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.reDivrCd = this.reDivrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCntCd = this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCd = this.custCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.existAuthFlg = this.existAuthFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.existFincMtxFlg = this.existFincMtxFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.existStlVvdFlg = this.existStlVvdFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.existStlBssPortFlg = this.existStlBssPortFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rlaneCds = this.rlaneCds.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trdCds = this.trdCds.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.existChildFlg = this.existChildFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.loclCurrCd = this.loclCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
