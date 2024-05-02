/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VskVipsIfMstVO.java
*@FileTitle : VskVipsIfMstVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.vo;

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
public class VskVipsIfMstVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<VskVipsIfMstVO> models = new ArrayList<VskVipsIfMstVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String skdVoyNo = null;

    /* Column Info */
    private String skdDirCd = null;

    /* Column Info */
    private String vipsIfSeq = null;

    /* Column Info */
    private String vslSlanCd = null;

    /* Column Info */
    private String vipsModiVslSlanCd = null;

    /* Column Info */
    private String vipsModiVslCd = null;

    /* Column Info */
    private String vipsModiSkdDirCd = null;

    /* Column Info */
    private String insfId = null;

    /* Column Info */
    private String insfPrsId = null;

    /* Column Info */
    private String insfDttm = null;

    /* Column Info */
    private String insfCnqeVal = null;

    /* Column Info */
    private String insfDvCd = null;

    /* Column Info */
    private String vipsRunUtNo = null;

    /* Column Info */
    private String vipsIfTgtFlg = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    //private String exclVipsIfSeq = null;
    /* Column Info */
    //private String inclVipsIfSeq = null;
    /* Column Info */
    //private String oldVipsIfSeq = null;
    /* Column Info */
    private String vipsIfRmk = null;

    /* Column Info */
    private String pfSvcTpCd = null;

    /* Column Info */
    private String vvdDelCd = null;

    /* Column Info */
    private String latestIfRsltCd = null;

    /* Column Info */
    private String latestInsfDvCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public VskVipsIfMstVO() {
    }

    public VskVipsIfMstVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, String skdDirCd, String vipsIfSeq, String vslSlanCd, String vipsModiVslSlanCd, String vipsModiVslCd, String vipsModiSkdDirCd, String insfId, String insfPrsId, String insfDttm, String insfCnqeVal, String insfDvCd, String vipsRunUtNo, String vipsIfTgtFlg, String creUsrId, String creDt, String updUsrId, String updDt, String exclVipsIfSeq, String inclVipsIfSeq, String oldVipsIfSeq, String vipsIfRmk, String pfSvcTpCd, String vvdDelCd, String vvdExistKnt, String latestIfRsltCd, String latestInsfDvCd) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.vslCd = vslCd;
        this.skdVoyNo = skdVoyNo;
        this.skdDirCd = skdDirCd;
        this.vipsIfSeq = vipsIfSeq;
        this.vslSlanCd = vslSlanCd;
        this.vipsModiVslSlanCd = vipsModiVslSlanCd;
        this.vipsModiVslCd = vipsModiVslCd;
        this.vipsModiSkdDirCd = vipsModiSkdDirCd;
        this.insfId = insfId;
        this.insfPrsId = insfPrsId;
        this.insfDttm = insfDttm;
        this.insfCnqeVal = insfCnqeVal;
        this.insfDvCd = insfDvCd;
        this.vipsRunUtNo = vipsRunUtNo;
        this.vipsIfTgtFlg = vipsIfTgtFlg;
        this.creUsrId = creUsrId;
        this.creDt = creDt;
        this.updUsrId = updUsrId;
        this.updDt = updDt;
        //        this.oldVipsIfSeq = oldVipsIfSeq;
        this.vipsIfRmk = vipsIfRmk;
        this.pfSvcTpCd = pfSvcTpCd;
        this.vvdDelCd = vvdDelCd;
        this.latestIfRsltCd = latestIfRsltCd;
        this.latestInsfDvCd = latestInsfDvCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("skd_dir_cd", getSkdDirCd());
        this.hashColumns.put("vips_if_seq", getVipsIfSeq());
        this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
        this.hashColumns.put("vips_modi_vsl_slan_cd", getVipsModiVslSlanCd());
        this.hashColumns.put("vips_modi_vsl_cd", getVipsModiVslCd());
        this.hashColumns.put("vips_modi_skd_dir_cd", getVipsModiSkdDirCd());
        this.hashColumns.put("insf_id", getInsfId());
        this.hashColumns.put("insf_prs_id", getInsfPrsId());
        this.hashColumns.put("insf_dttm", getInsfDttm());
        this.hashColumns.put("insf_cnqe_val", getInsfCnqeVal());
        this.hashColumns.put("insf_dv_cd", getInsfDvCd());
        this.hashColumns.put("vips_run_ut_no", getVipsRunUtNo());
        this.hashColumns.put("vips_if_tgt_flg", getVipsIfTgtFlg());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("upd_dt", getUpdDt());
        //        this.hashColumns.put("old_vips_if_seq", getOldVipsIfSeq());
        this.hashColumns.put("vips_if_rmk", getVipsIfRmk());
        this.hashColumns.put("pf_svc_tp_cd", getPfSvcTpCd());
        this.hashColumns.put("vvd_del_cd", getVvdDelCd());
        this.hashColumns.put("latest_if_rslt_cd", getLatestIfRsltCd());
        this.hashColumns.put("latest_insf_dv_cd", getLatestInsfDvCd());
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
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("skd_dir_cd", "skdDirCd");
        this.hashFields.put("vips_if_seq", "vipsIfSeq");
        this.hashFields.put("vsl_slan_cd", "vslSlanCd");
        this.hashFields.put("vips_modi_vsl_slan_cd", "vipsModiVslSlanCd");
        this.hashFields.put("vips_modi_vsl_cd", "vipsModiVslCd");
        this.hashFields.put("vips_modi_skd_dir_cd", "vipsModiSkdDirCd");
        this.hashFields.put("insf_id", "insfId");
        this.hashFields.put("insf_prs_id", "insfPrsId");
        this.hashFields.put("insf_dttm", "insfDttm");
        this.hashFields.put("insf_cnqe_val", "insfCnqeVal");
        this.hashFields.put("insf_dv_cd", "insfDvCd");
        this.hashFields.put("vips_run_ut_no", "vipsRunUtNo");
        this.hashFields.put("vips_if_tgt_flg", "vipsIfTgtFlg");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("excl_vips_if_seq", "exclVipsIfSeq");
        this.hashFields.put("incl_vips_if_seq", "inclVipsIfSeq");
        this.hashFields.put("old_vips_if_seq", "oldVipsIfSeq");
        this.hashFields.put("vips_if_rmk", "vipsIfRmk");
        this.hashFields.put("pf_svc_tp_cd", "pfSvcTpCd");
        this.hashFields.put("vvd_del_cd", "vvdDelCd");
        this.hashFields.put("vvd_exist_knt", "vvdExistKnt");
        this.hashFields.put("latest_if_rslt_cd", "latestIfRsltCd");
        this.hashFields.put("latest_insf_dv_cd", "latestInsfDvCd");
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
	 * @param String skdVoyNo
	 */
    public void setSkdVoyNo(String skdVoyNo) {
        this.skdVoyNo = skdVoyNo;
    }

    /**
	 * 
	 * @return String skdVoyNo
	 */
    public String getSkdVoyNo() {
        return this.skdVoyNo;
    }

    /**
	 *
	 * @param String skdDirCd
	 */
    public void setSkdDirCd(String skdDirCd) {
        this.skdDirCd = skdDirCd;
    }

    /**
	 * 
	 * @return String skdDirCd
	 */
    public String getSkdDirCd() {
        return this.skdDirCd;
    }

    /**
	 *
	 * @param String vipsIfSeq
	 */
    public void setVipsIfSeq(String vipsIfSeq) {
        this.vipsIfSeq = vipsIfSeq;
    }

    /**
	 * 
	 * @return String vipsIfSeq
	 */
    public String getVipsIfSeq() {
        return this.vipsIfSeq;
    }

    /**
	 *
	 * @param String vslSlanCd
	 */
    public void setVslSlanCd(String vslSlanCd) {
        this.vslSlanCd = vslSlanCd;
    }

    /**
	 * 
	 * @return String vslSlanCd
	 */
    public String getVslSlanCd() {
        return this.vslSlanCd;
    }

    /**
	 *
	 * @param String vipsModiVslSlanCd
	 */
    public void setVipsModiVslSlanCd(String vipsModiVslSlanCd) {
        this.vipsModiVslSlanCd = vipsModiVslSlanCd;
    }

    /**
	 * 
	 * @return String vipsModiVslSlanCd
	 */
    public String getVipsModiVslSlanCd() {
        return this.vipsModiVslSlanCd;
    }

    /**
	 *
	 * @param String vipsModiVslCd
	 */
    public void setVipsModiVslCd(String vipsModiVslCd) {
        this.vipsModiVslCd = vipsModiVslCd;
    }

    /**
	 * 
	 * @return String vipsModiVslCd
	 */
    public String getVipsModiVslCd() {
        return this.vipsModiVslCd;
    }

    /**
	 *
	 * @param String vipsModiSkdDirCd
	 */
    public void setVipsModiSkdDirCd(String vipsModiSkdDirCd) {
        this.vipsModiSkdDirCd = vipsModiSkdDirCd;
    }

    /**
	 * 
	 * @return String vipsModiSkdDirCd
	 */
    public String getVipsModiSkdDirCd() {
        return this.vipsModiSkdDirCd;
    }

    /**
	 *
	 * @param String insfId
	 */
    public void setInsfId(String insfId) {
        this.insfId = insfId;
    }

    /**
	 * 
	 * @return String insfId
	 */
    public String getInsfId() {
        return this.insfId;
    }

    /**
	 *
	 * @param String insfPrsId
	 */
    public void setInsfPrsId(String insfPrsId) {
        this.insfPrsId = insfPrsId;
    }

    /**
	 * 
	 * @return String insfPrsId
	 */
    public String getInsfPrsId() {
        return this.insfPrsId;
    }

    /**
	 *
	 * @param String insfDttm
	 */
    public void setInsfDttm(String insfDttm) {
        this.insfDttm = insfDttm;
    }

    /**
	 * 
	 * @return String insfDttm
	 */
    public String getInsfDttm() {
        return this.insfDttm;
    }

    /**
	 *
	 * @param String insfCnqeVal
	 */
    public void setInsfCnqeVal(String insfCnqeVal) {
        this.insfCnqeVal = insfCnqeVal;
    }

    /**
	 * 
	 * @return String insfCnqeVal
	 */
    public String getInsfCnqeVal() {
        return this.insfCnqeVal;
    }

    /**
	 *
	 * @param String insfDvCd
	 */
    public void setInsfDvCd(String insfDvCd) {
        this.insfDvCd = insfDvCd;
    }

    /**
	 * 
	 * @return String insfDvCd
	 */
    public String getInsfDvCd() {
        return this.insfDvCd;
    }

    /**
	 *
	 * @param String vipsRunUtNo
	 */
    public void setVipsRunUtNo(String vipsRunUtNo) {
        this.vipsRunUtNo = vipsRunUtNo;
    }

    /**
	 * 
	 * @return String vipsRunUtNo
	 */
    public String getVipsRunUtNo() {
        return this.vipsRunUtNo;
    }

    /**
	 *
	 * @param String vipsIfTgtFlg
	 */
    public void setVipsIfTgtFlg(String vipsIfTgtFlg) {
        this.vipsIfTgtFlg = vipsIfTgtFlg;
    }

    /**
	 * 
	 * @return String vipsIfTgtFlg
	 */
    public String getVipsIfTgtFlg() {
        return this.vipsIfTgtFlg;
    }

    /**
	 *
	 * @param String creUsrId
	 */
    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
    }

    /**
	 * 
	 * @return String creUsrId
	 */
    public String getCreUsrId() {
        return this.creUsrId;
    }

    /**
	 *
	 * @param String creDt
	 */
    public void setCreDt(String creDt) {
        this.creDt = creDt;
    }

    /**
	 * 
	 * @return String creDt
	 */
    public String getCreDt() {
        return this.creDt;
    }

    /**
	 *
	 * @param String updUsrId
	 */
    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
    }

    /**
	 * 
	 * @return String updUsrId
	 */
    public String getUpdUsrId() {
        return this.updUsrId;
    }

    /**
	 *
	 * @param String updDt
	 */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    /**
	 * 
	 * @return String updDt
	 */
    public String getUpdDt() {
        return this.updDt;
    }

    //    public void setExclVipsIfSeq(String exclVipsIfSeq) {
    //        this.exclVipsIfSeq = exclVipsIfSeq;
    //    }
    //
    //    public String getExclVipsIfSeq() {
    //        return this.exclVipsIfSeq;
    //    }
    //
    //    public void setInclVipsIfSeq(String inclVipsIfSeq) {
    //        this.inclVipsIfSeq = inclVipsIfSeq;
    //    }
    //
    //    public String getInclVipsIfSeq() {
    //        return this.inclVipsIfSeq;
    //    }
    //    public void setOldVipsIfSeq(String oldVipsIfSeq) {
    //        this.oldVipsIfSeq = oldVipsIfSeq;
    //    }
    //
    //    public String getOldVipsIfSeq() {
    //        return this.oldVipsIfSeq;
    //    }
    public void setVipsIfRmk(String vipsIfRmk) {
        this.vipsIfRmk = vipsIfRmk;
    }

    public String getVipsIfRmk() {
        return this.vipsIfRmk;
    }

    public void setPfSvcTpCd(String pfSvcTpCd) {
        this.pfSvcTpCd = pfSvcTpCd;
    }

    public String getPfSvcTpCd() {
        return this.pfSvcTpCd;
    }

    public void setVvdDelCd(String vvdDelCd) {
        this.vvdDelCd = vvdDelCd;
    }

    public String getVvdDelCd() {
        return this.vvdDelCd;
    }

    public void setLatestIfRsltCd(String latestIfRsltCd) {
        this.latestIfRsltCd = latestIfRsltCd;
    }

    public String getLatestIfRsltCd() {
        return this.latestIfRsltCd;
    }

    public void setLastestInsfDvCd(String latestInsfDvCd) {
        this.latestInsfDvCd = latestInsfDvCd;
    }

    public String getLatestInsfDvCd() {
        return this.latestInsfDvCd;
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
        setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
        setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
        setVipsIfSeq(JSPUtil.getParameter(request, prefix + "vips_if_seq", ""));
        setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
        setVipsModiVslSlanCd(JSPUtil.getParameter(request, prefix + "vips_modi_vsl_slan_cd", ""));
        setVipsModiVslCd(JSPUtil.getParameter(request, prefix + "vips_modi_vsl_cd", ""));
        setVipsModiSkdDirCd(JSPUtil.getParameter(request, prefix + "vips_modi_skd_dir_cd", ""));
        setInsfId(JSPUtil.getParameter(request, prefix + "insf_id", ""));
        setInsfPrsId(JSPUtil.getParameter(request, prefix + "insf_prs_id", ""));
        setInsfDttm(JSPUtil.getParameter(request, prefix + "insf_dttm", ""));
        setInsfCnqeVal(JSPUtil.getParameter(request, prefix + "insf_cnqe_val", ""));
        setInsfDvCd(JSPUtil.getParameter(request, prefix + "insf_dv_cd", ""));
        setVipsRunUtNo(JSPUtil.getParameter(request, prefix + "vips_run_ut_no", ""));
        setVipsIfTgtFlg(JSPUtil.getParameter(request, prefix + "vips_if_tgt_flg", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        //        setOldVipsIfSeq(JSPUtil.getParameter(request, prefix + "old_vips_if_seq", ""));
        setVipsIfRmk(JSPUtil.getParameter(request, prefix + "vips_if_rmk", ""));
        setPfSvcTpCd(JSPUtil.getParameter(request, prefix + "pf_svc_tp_cd", ""));
        setVvdDelCd(JSPUtil.getParameter(request, prefix + "vvd_del_cd", ""));
        setLatestIfRsltCd(JSPUtil.getParameter(request, prefix + "latest_if_rslt_cd", ""));
        setLastestInsfDvCd(JSPUtil.getParameter(request, prefix + "latest_insf_dv_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VskVipsIfMstVO[]
	 */
    public VskVipsIfMstVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VskVipsIfMstVO[]
	 */
    public VskVipsIfMstVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        VskVipsIfMstVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
            String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
            String[] vipsIfSeq = (JSPUtil.getParameter(request, prefix + "vips_if_seq", length));
            String[] vslSlanCd = (JSPUtil.getParameter(request, prefix + "vsl_slan_cd", length));
            String[] vipsModiVslSlanCd = (JSPUtil.getParameter(request, prefix + "vips_modi_vsl_slan_cd", length));
            String[] vipsModiVslCd = (JSPUtil.getParameter(request, prefix + "vips_modi_vsl_cd", length));
            String[] vipsModiSkdDirCd = (JSPUtil.getParameter(request, prefix + "vips_modi_skd_dir_cd", length));
            String[] insfId = (JSPUtil.getParameter(request, prefix + "insf_id", length));
            String[] insfPrsId = (JSPUtil.getParameter(request, prefix + "insf_prs_id", length));
            String[] insfDttm = (JSPUtil.getParameter(request, prefix + "insf_dttm", length));
            String[] insfCnqeVal = (JSPUtil.getParameter(request, prefix + "insf_cnqe_val", length));
            String[] insfDvCd = (JSPUtil.getParameter(request, prefix + "insf_dv_cd", length));
            String[] vipsRunUtNo = (JSPUtil.getParameter(request, prefix + "vips_run_ut_no", length));
            String[] vipsIfTgtFlg = (JSPUtil.getParameter(request, prefix + "vips_if_tgt_flg", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] exclVipsIfSeq = (JSPUtil.getParameter(request, prefix + "excl_vips_if_seq", length));
            String[] inclVipsIfSeq = (JSPUtil.getParameter(request, prefix + "incl_vips_if_seq", length));
            String[] oldVipsIfSeq = (JSPUtil.getParameter(request, prefix + "old_vips_if_seq", length));
            String[] vipsIfRmk = (JSPUtil.getParameter(request, prefix + "vips_if_rmk", length));
            String[] pfSvcTpCd = (JSPUtil.getParameter(request, prefix + "pf_svc_tp_cd", length));
            String[] vvdDelCd = (JSPUtil.getParameter(request, prefix + "vvd_del_cd", length));
            String[] vvdExistKnt = (JSPUtil.getParameter(request, prefix + "vvd_exist_knt", length));
            String[] latestIfRsltCd = (JSPUtil.getParameter(request, prefix + "latest_if_rslt_cd", length));
            String[] latestInsfDvCd = (JSPUtil.getParameter(request, prefix + "latest_insf_dv_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new VskVipsIfMstVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (skdVoyNo[i] != null)
                    model.setSkdVoyNo(skdVoyNo[i]);
                if (skdDirCd[i] != null)
                    model.setSkdDirCd(skdDirCd[i]);
                if (vipsIfSeq[i] != null)
                    model.setVipsIfSeq(vipsIfSeq[i]);
                if (vslSlanCd[i] != null)
                    model.setVslSlanCd(vslSlanCd[i]);
                if (vipsModiVslSlanCd[i] != null)
                    model.setVipsModiVslSlanCd(vipsModiVslSlanCd[i]);
                if (vipsModiVslCd[i] != null)
                    model.setVipsModiVslCd(vipsModiVslCd[i]);
                if (vipsModiSkdDirCd[i] != null)
                    model.setVipsModiSkdDirCd(vipsModiSkdDirCd[i]);
                if (insfId[i] != null)
                    model.setInsfId(insfId[i]);
                if (insfPrsId[i] != null)
                    model.setInsfPrsId(insfPrsId[i]);
                if (insfDttm[i] != null)
                    model.setInsfDttm(insfDttm[i]);
                if (insfCnqeVal[i] != null)
                    model.setInsfCnqeVal(insfCnqeVal[i]);
                if (insfDvCd[i] != null)
                    model.setInsfDvCd(insfDvCd[i]);
                if (vipsRunUtNo[i] != null)
                    model.setVipsRunUtNo(vipsRunUtNo[i]);
                if (vipsIfTgtFlg[i] != null)
                    model.setVipsIfTgtFlg(vipsIfTgtFlg[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                //                    model.setOldVipsIfSeq(oldVipsIfSeq[i]);
                if (vipsIfRmk[i] != null)
                    model.setVipsIfRmk(vipsIfRmk[i]);
                if (pfSvcTpCd[i] != null)
                    model.setPfSvcTpCd(pfSvcTpCd[i]);
                if (vvdDelCd[i] != null)
                    model.setVvdDelCd(vvdDelCd[i]);
                if (latestIfRsltCd[i] != null)
                    model.setLatestIfRsltCd(latestIfRsltCd[i]);
                if (latestInsfDvCd[i] != null) 
		    		model.setLastestInsfDvCd(latestInsfDvCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getVskVipsIfMstVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return VskVipsIfMstVO[]
	 */
    public VskVipsIfMstVO[] getVskVipsIfMstVOs() {
        VskVipsIfMstVO[] vos = (VskVipsIfMstVO[]) models.toArray(new VskVipsIfMstVO[models.size()]);
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
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vipsIfSeq = this.vipsIfSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslSlanCd = this.vslSlanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vipsModiVslSlanCd = this.vipsModiVslSlanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vipsModiVslCd = this.vipsModiVslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vipsModiSkdDirCd = this.vipsModiSkdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.insfId = this.insfId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.insfPrsId = this.insfPrsId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.insfDttm = this.insfDttm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.insfCnqeVal = this.insfCnqeVal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.insfDvCd = this.insfDvCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vipsRunUtNo = this.vipsRunUtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vipsIfTgtFlg = this.vipsIfTgtFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        //        this.oldVipsIfSeq = this.oldVipsIfSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vipsIfRmk = this.vipsIfRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pfSvcTpCd = this.pfSvcTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvdDelCd = this.vvdDelCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.latestIfRsltCd = this.latestIfRsltCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.latestInsfDvCd = this.latestInsfDvCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
