/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : VvdVO.java
 *@FileTitle : VvdVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.11.11
 *@LastModifier : dongsoo
 *@LastVersion : 1.0
 * 2014.11.11 dongsoo 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo;

import java.lang.reflect.Field;
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
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author dongsoo
 * @since J2EE 1.6
 * @see	..
 */
public class VvdVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<VvdVO> models = new ArrayList<VvdVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /*	Column Info	*/
    private String vslCd = null;

    /*	Column Info	*/
    private String skdDirCd = null;

    /*	Column Info	*/
    private String skdVoyNo = null;

    /*	Column Info	*/
    private String statusflag = null;

    /*	Column Info	*/
    private String turnPortIndCd = null;

    /*	Column Info	*/
    private String turnSkdDirCd = null;

    /*	Column Info	*/
    private String vslSlanCd = null;

    /*	Column Info	*/
    private String creUsrId = null;

    /*	Column Info	*/
    private String updUsrId = null;

    /*	Column Info	*/
    private String incDelVsl = null;

    /*	Column Info	*/
    private String turnSkdVoyNo = null;

    /*	Column Info	*/
    private String ibCssmVoyNo = null;

    /*	Column Info	*/
    private String obCssmVoyNo = null;

    /*	Column Info	*/
    private String pfSkdTpCd = null;

    /* Column Info */
    private String actCrrCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    /**	Constructor	*/
    public VvdVO() {
    }

    public VvdVO(String ibflag, String pagerows, String vslCd, String skdDirCd, String skdVoyNo, String statusflag, String turnPortIndCd, String turnSkdDirCd, String vslSlanCd, String creUsrId, String updUsrId, String incDelVsl, String turnSkdVoyNo, String ibCssmVoyNo, String obCssmVoyNo, String actCrrCd) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.vslCd = vslCd;
        this.skdDirCd = skdDirCd;
        this.skdVoyNo = skdVoyNo;
        this.statusflag = statusflag;
        this.turnPortIndCd = turnPortIndCd;
        this.turnSkdDirCd = turnSkdDirCd;
        this.vslSlanCd = vslSlanCd;
        this.creUsrId = creUsrId;
        this.updUsrId = updUsrId;
        this.incDelVsl = incDelVsl;
        this.turnSkdVoyNo = turnSkdVoyNo;
        this.ibCssmVoyNo = ibCssmVoyNo;
        this.obCssmVoyNo = obCssmVoyNo;
        this.actCrrCd = actCrrCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("skd_dir_cd", getSkdDirCd());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("statusflag", getStatusflag());
        this.hashColumns.put("turn_port_ind_cd", getTurnPortIndCd());
        this.hashColumns.put("turn_skd_dir_cd", getTurnSkdDirCd());
        this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("inc_del_vsl", getIncDelVsl());
        this.hashColumns.put("turn_skd_voy_no", getTurnSkdVoyNo());
        this.hashColumns.put("ib_cssm_voy_no", getIbCssmVoyNo());
        this.hashColumns.put("ob_cssm_voy_no", getObCssmVoyNo());
        this.hashColumns.put("pf_skd_tp_cd", getPfSkdTpCd());
        this.hashColumns.put("act_crr_cd", getActCrrCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("skd_dir_cd", "skdDirCd");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("statusflag", "statusflag");
        this.hashFields.put("turn_port_ind_cd", "turnPortIndCd");
        this.hashFields.put("turn_skd_dir_cd", "turnSkdDirCd");
        this.hashFields.put("vsl_slan_cd", "vslSlanCd");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("inc_del_vsl", "incDelVsl");
        this.hashFields.put("turn_skd_voy_no", "turnSkdVoyNo");
        this.hashFields.put("ib_cssm_voy_no", "ibCssmVoyNo");
        this.hashFields.put("ob_cssm_voy_no", "obCssmVoyNo");
        this.hashFields.put("pf_skd_tp_cd", "pfSkdTpCd");
        this.hashFields.put("act_crr_cd", "actCrrCd");
        return this.hashFields;
    }

    //	Getters	and	Setters
    /**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
    public String getIbflag() {
        return this.ibflag;
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
	 * @return vslCd
	 */
    public String getVslCd() {
        return this.vslCd;
    }

    /**
	 * Column Info
	 * @return skdDirCd
	 */
    public String getSkdDirCd() {
        return this.skdDirCd;
    }

    /**
	 * Column Info
	 * @return skdVoyNo
	 */
    public String getSkdVoyNo() {
        return this.skdVoyNo;
    }

    /**
	 * Column Info
	 * @return statusflag
	 */
    public String getStatusflag() {
        return this.statusflag;
    }

    /**
	 * Column Info
	 * @return turnPortIndCd
	 */
    public String getTurnPortIndCd() {
        return this.turnPortIndCd;
    }

    /**
	 * Column Info
	 * @return turnSkdDirCd
	 */
    public String getTurnSkdDirCd() {
        return this.turnSkdDirCd;
    }

    /**
	 * Column Info
	 * @return vslSlanCd
	 */
    public String getVslSlanCd() {
        return this.vslSlanCd;
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
	 * @return updUsrId
	 */
    public String getUpdUsrId() {
        return this.updUsrId;
    }

    /**
	 * Column Info
	 * @return incDelVsl
	 */
    public String getIncDelVsl() {
        return this.incDelVsl;
    }

    /**
	 * Column Info
	 * @return turnSkdVoyNo
	 */
    public String getTurnSkdVoyNo() {
        return this.turnSkdVoyNo;
    }

    /**
	 * Column Info
	 * @return ibCssmVoyNo
	 */
    public String getIbCssmVoyNo() {
        return this.ibCssmVoyNo;
    }

    /**
	 * Column Info
	 * @return obCssmVoyNo
	 */
    public String getObCssmVoyNo() {
        return this.obCssmVoyNo;
    }

    /**
	 * Column Info
	 * @return pfSkdTpCd
	 */
    public String getPfSkdTpCd() {
        return this.pfSkdTpCd;
    }

    /**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param  pfSkdTpCd
 	 */
    public void setPfSkdTpCd(String pfSkdTpCd) {
        this.pfSkdTpCd = pfSkdTpCd;
    }

    /**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param  ibflag
 	 */
    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
    }

    /**
	 * Page Number
	 * @param  pagerows
 	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    /**
	 * Column Info
	 * @param  vslCd
 	 */
    public void setVslCd(String vslCd) {
        this.vslCd = vslCd;
    }

    /**
	 * Column Info
	 * @param  skdDirCd
 	 */
    public void setSkdDirCd(String skdDirCd) {
        this.skdDirCd = skdDirCd;
    }

    /**
	 * Column Info
	 * @param  skdVoyNo
 	 */
    public void setSkdVoyNo(String skdVoyNo) {
        this.skdVoyNo = skdVoyNo;
    }

    /**
	 * Column Info
	 * @param  statusflag
 	 */
    public void setStatusflag(String statusflag) {
        this.statusflag = statusflag;
    }

    /**
	 * Column Info
	 * @param  turnPortIndCd
 	 */
    public void setTurnPortIndCd(String turnPortIndCd) {
        this.turnPortIndCd = turnPortIndCd;
    }

    /**
	 * Column Info
	 * @param  turnSkdDirCd
 	 */
    public void setTurnSkdDirCd(String turnSkdDirCd) {
        this.turnSkdDirCd = turnSkdDirCd;
    }

    /**
	 * Column Info
	 * @param  vslSlanCd
 	 */
    public void setVslSlanCd(String vslSlanCd) {
        this.vslSlanCd = vslSlanCd;
    }

    /**
	 * Column Info
	 * @param  creUsrId
 	 */
    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
    }

    /**
	 * Column Info
	 * @param  updUsrId
 	 */
    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
    }

    /**
	 * Column Info
	 * @param  incDelVsl
 	 */
    public void setIncDelVsl(String incDelVsl) {
        this.incDelVsl = incDelVsl;
    }

    /**
	 * Column Info
	 * @param  turnSkdVoyNo
 	 */
    public void setTurnSkdVoyNo(String turnSkdVoyNo) {
        this.turnSkdVoyNo = turnSkdVoyNo;
    }

    /**
	 * Column Info
	 * @param  ibCssmVoyNo
 	 */
    public void setIbCssmVoyNo(String ibCssmVoyNo) {
        this.ibCssmVoyNo = ibCssmVoyNo;
    }

    /**
	 * Column Info
	 * @param  obCssmVoyNo
 	 */
    public void setObCssmVoyNo(String obCssmVoyNo) {
        this.obCssmVoyNo = obCssmVoyNo;
    }

    public void setActCrrCd(String actCrrCd) {
        this.actCrrCd = actCrrCd;
    }

    public String getActCrrCd() {
        return this.actCrrCd;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        fromRequest(request, "");
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request, String prefix) {
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
        setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
        setStatusflag(JSPUtil.getParameter(request, prefix + "statusflag", ""));
        setTurnPortIndCd(JSPUtil.getParameter(request, prefix + "turn_port_ind_cd", ""));
        setTurnSkdDirCd(JSPUtil.getParameter(request, prefix + "turn_skd_dir_cd", ""));
        setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setIncDelVsl(JSPUtil.getParameter(request, prefix + "inc_del_vsl", ""));
        setTurnSkdVoyNo(JSPUtil.getParameter(request, prefix + "turn_skd_voy_no", ""));
        setIbCssmVoyNo(JSPUtil.getParameter(request, prefix + "ib_cssm_voy_no", ""));
        setObCssmVoyNo(JSPUtil.getParameter(request, prefix + "ob_cssm_voy_no", ""));
        setPfSkdTpCd(JSPUtil.getParameter(request, prefix + "pf_skd_tp_cd", ""));
        setActCrrCd(JSPUtil.getParameter(request, prefix + "act_crr_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VvdVO[]
	 */
    public VvdVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return VvdVO[]
	 */
    public VvdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        VvdVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
            String[] statusflag = (JSPUtil.getParameter(request, prefix + "statusflag", length));
            String[] turnPortIndCd = (JSPUtil.getParameter(request, prefix + "turn_port_ind_cd", length));
            String[] turnSkdDirCd = (JSPUtil.getParameter(request, prefix + "turn_skd_dir_cd", length));
            String[] vslSlanCd = (JSPUtil.getParameter(request, prefix + "vsl_slan_cd", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] incDelVsl = (JSPUtil.getParameter(request, prefix + "inc_del_vsl", length));
            String[] turnSkdVoyNo = (JSPUtil.getParameter(request, prefix + "turn_skd_voy_no", length));
            String[] ibCssmVoyNo = (JSPUtil.getParameter(request, prefix + "ib_cssm_voy_no", length));
            String[] obCssmVoyNo = (JSPUtil.getParameter(request, prefix + "ob_cssm_voy_no", length));
            String[] pfSkdTpCd = (JSPUtil.getParameter(request, prefix + "pf_skd_tp_cd", length));
            String[] actCrrCd = (JSPUtil.getParameter(request, prefix + "act_crr_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new VvdVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (skdDirCd[i] != null)
                    model.setSkdDirCd(skdDirCd[i]);
                if (skdVoyNo[i] != null)
                    model.setSkdVoyNo(skdVoyNo[i]);
                if (statusflag[i] != null)
                    model.setStatusflag(statusflag[i]);
                if (turnPortIndCd[i] != null)
                    model.setTurnPortIndCd(turnPortIndCd[i]);
                if (turnSkdDirCd[i] != null)
                    model.setTurnSkdDirCd(turnSkdDirCd[i]);
                if (vslSlanCd[i] != null)
                    model.setVslSlanCd(vslSlanCd[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (incDelVsl[i] != null)
                    model.setIncDelVsl(incDelVsl[i]);
                if (turnSkdVoyNo[i] != null)
                    model.setTurnSkdVoyNo(turnSkdVoyNo[i]);
                if (ibCssmVoyNo[i] != null)
                    model.setIbCssmVoyNo(ibCssmVoyNo[i]);
                if (obCssmVoyNo[i] != null)
                    model.setObCssmVoyNo(obCssmVoyNo[i]);
                if (pfSkdTpCd[i] != null)
                    model.setPfSkdTpCd(pfSkdTpCd[i]);
                if (actCrrCd[i] != null) 
		    		model.setActCrrCd(actCrrCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getVvdVOs();
    }

    /**
	 *  VO 배열을 반환
	 * @return VvdVO[]
	 */
    public VvdVO[] getVvdVOs() {
        VvdVO[] vos = (VvdVO[]) models.toArray(new VvdVO[models.size()]);
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
        this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.statusflag = this.statusflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.turnPortIndCd = this.turnPortIndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.turnSkdDirCd = this.turnSkdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslSlanCd = this.vslSlanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.incDelVsl = this.incDelVsl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.turnSkdVoyNo = this.turnSkdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibCssmVoyNo = this.ibCssmVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.obCssmVoyNo = this.obCssmVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.actCrrCd = this.actCrrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
