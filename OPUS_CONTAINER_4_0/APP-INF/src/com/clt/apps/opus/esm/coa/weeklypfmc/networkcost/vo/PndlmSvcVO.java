/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PndlmSvcVO.java
*@FileTitle : PndlmSvcVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo;

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
public class PndlmSvcVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<PndlmSvcVO> models = new ArrayList<PndlmSvcVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String slanCd = null;

    /* Column Info */
    private String dirCd = null;

    /* Column Info */
    private String rlaneCd = null;

    /* Column Info */
    private String ydCd = null;

    /* Column Info */
    private String effFmDt = null;

    /* Column Info */
    private String effToDt = null;

    /* Column Info */
    private String vvdCd = null;

    /* Column Info */
    private String pndlmRto = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String errorCode = null;

    /* Column Info */
    private String errorMsg = null;

    /* Column Info */
    private String lastYn = null;

    /* Column Info */
    private String rsCnt = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public PndlmSvcVO() {
    }

    public PndlmSvcVO(String ibflag, String pagerows, String slanCd, String dirCd, String rlaneCd, String ydCd, String effFmDt, String effToDt, String vvdCd, String pndlmRto, String creUsrId, String updUsrId, String errorCode, String errorMsg, String lastYn, String rsCnt) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.slanCd = slanCd;
        this.dirCd = dirCd;
        this.rlaneCd = rlaneCd;
        this.ydCd = ydCd;
        this.effFmDt = effFmDt;
        this.effToDt = effToDt;
        this.vvdCd = vvdCd;
        this.pndlmRto = pndlmRto;
        this.creUsrId = creUsrId;
        this.updUsrId = updUsrId;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.lastYn = lastYn;
        this.rsCnt = rsCnt;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("slan_cd", getSlanCd());
        this.hashColumns.put("dir_cd", getDirCd());
        this.hashColumns.put("rlane_cd", getRlaneCd());
        this.hashColumns.put("yd_cd", getYdCd());
        this.hashColumns.put("eff_fm_dt", getEffFmDt());
        this.hashColumns.put("eff_to_dt", getEffToDt());
        this.hashColumns.put("vvd_cd", getVvdCd());
        this.hashColumns.put("pndlm_rto", getPndlmRto());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("error_code", getErrorCode());
        this.hashColumns.put("error_msg", getErrorMsg());
        this.hashColumns.put("last_yn", getLastYn());
        this.hashColumns.put("rs_cnt", getRsCnt());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("slan_cd", "slanCd");
        this.hashFields.put("dir_cd", "dirCd");
        this.hashFields.put("rlane_cd", "rlaneCd");
        this.hashFields.put("yd_cd", "ydCd");
        this.hashFields.put("eff_fm_dt", "effFmDt");
        this.hashFields.put("eff_to_dt", "effToDt");
        this.hashFields.put("vvd_cd", "vvdCd");
        this.hashFields.put("pndlm_rto", "pndlmRto");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("error_code", "errorCode");
        this.hashFields.put("error_msg", "errorMsg");
        this.hashFields.put("last_yn", "lastYn");
        this.hashFields.put("rs_cnt", "rsCnt");
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
	 * @param String slanCd
	 */
    public void setSlanCd(String slanCd) {
        this.slanCd = slanCd;
    }

    /**
	 * 
	 * @return String slanCd
	 */
    public String getSlanCd() {
        return this.slanCd;
    }

    /**
	 *
	 * @param String dirCd
	 */
    public void setDirCd(String dirCd) {
        this.dirCd = dirCd;
    }

    /**
	 * 
	 * @return String dirCd
	 */
    public String getDirCd() {
        return this.dirCd;
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
	 * @param String ydCd
	 */
    public void setYdCd(String ydCd) {
        this.ydCd = ydCd;
    }

    /**
	 * 
	 * @return String ydCd
	 */
    public String getYdCd() {
        return this.ydCd;
    }

    /**
	 *
	 * @param String effFmDt
	 */
    public void setEffFmDt(String effFmDt) {
        this.effFmDt = effFmDt;
    }

    /**
	 * 
	 * @return String effFmDt
	 */
    public String getEffFmDt() {
        return this.effFmDt;
    }

    /**
	 *
	 * @param String effToDt
	 */
    public void setEffToDt(String effToDt) {
        this.effToDt = effToDt;
    }

    /**
	 * 
	 * @return String effToDt
	 */
    public String getEffToDt() {
        return this.effToDt;
    }

    /**
	 *
	 * @param String vvdCd
	 */
    public void setVvdCd(String vvdCd) {
        this.vvdCd = vvdCd;
    }

    /**
	 * 
	 * @return String vvdCd
	 */
    public String getVvdCd() {
        return this.vvdCd;
    }

    /**
	 *
	 * @param String pndlmRto
	 */
    public void setPndlmRto(String pndlmRto) {
        this.pndlmRto = pndlmRto;
    }

    /**
	 * 
	 * @return String pndlmRto
	 */
    public String getPndlmRto() {
        return this.pndlmRto;
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

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setLastYn(String lastYn) {
        this.lastYn = lastYn;
    }

    public String getLastYn() {
        return this.lastYn;
    }

    public void setRsCnt(String rsCnt) {
        this.rsCnt = rsCnt;
    }

    public String getRsCnt() {
        return this.rsCnt;
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
        setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
        setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
        setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
        setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
        setEffFmDt(JSPUtil.getParameter(request, prefix + "eff_fm_dt", ""));
        setEffToDt(JSPUtil.getParameter(request, prefix + "eff_to_dt", ""));
        setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
        setPndlmRto(JSPUtil.getParameter(request, prefix + "pndlm_rto", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setErrorCode(JSPUtil.getParameter(request, prefix + "error_code", ""));
        setErrorMsg(JSPUtil.getParameter(request, prefix + "error_msg", ""));
        setLastYn(JSPUtil.getParameter(request, prefix + "last_yn", ""));
        setRsCnt(JSPUtil.getParameter(request, prefix + "rs_cnt", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PndlmSvcVO[]
	 */
    public PndlmSvcVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PndlmSvcVO[]
	 */
    public PndlmSvcVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        PndlmSvcVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] slanCd = (JSPUtil.getParameter(request, prefix + "slan_cd", length));
            String[] dirCd = (JSPUtil.getParameter(request, prefix + "dir_cd", length));
            String[] rlaneCd = (JSPUtil.getParameter(request, prefix + "rlane_cd", length));
            String[] ydCd = (JSPUtil.getParameter(request, prefix + "yd_cd", length));
            String[] effFmDt = (JSPUtil.getParameter(request, prefix + "eff_fm_dt", length));
            String[] effToDt = (JSPUtil.getParameter(request, prefix + "eff_to_dt", length));
            String[] vvdCd = (JSPUtil.getParameter(request, prefix + "vvd_cd", length));
            String[] pndlmRto = (JSPUtil.getParameter(request, prefix + "pndlm_rto", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] errorCode = (JSPUtil.getParameter(request, prefix + "error_code", length));
            String[] errorMsg = (JSPUtil.getParameter(request, prefix + "error_msg", length));
            String[] lastYn = (JSPUtil.getParameter(request, prefix + "last_yn", length));
	    	String[] rsCnt = (JSPUtil.getParameter(request, prefix + "rs_cnt", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new PndlmSvcVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (slanCd[i] != null)
                    model.setSlanCd(slanCd[i]);
                if (dirCd[i] != null)
                    model.setDirCd(dirCd[i]);
                if (rlaneCd[i] != null)
                    model.setRlaneCd(rlaneCd[i]);
                if (ydCd[i] != null)
                    model.setYdCd(ydCd[i]);
                if (effFmDt[i] != null)
                    model.setEffFmDt(effFmDt[i]);
                if (effToDt[i] != null)
                    model.setEffToDt(effToDt[i]);
                if (vvdCd[i] != null)
                    model.setVvdCd(vvdCd[i]);
                if (pndlmRto[i] != null)
                    model.setPndlmRto(pndlmRto[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (errorCode[i] != null)
                    model.setErrorCode(errorCode[i]);
                if (errorMsg[i] != null)
                    model.setErrorMsg(errorMsg[i]);
                if (lastYn[i] != null) 
		    		model.setLastYn(lastYn[i]);
				if (rsCnt[i] != null) 
		    		model.setRsCnt(rsCnt[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getPndlmSvcVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return PndlmSvcVO[]
	 */
    public PndlmSvcVO[] getPndlmSvcVOs() {
        PndlmSvcVO[] vos = (PndlmSvcVO[]) models.toArray(new PndlmSvcVO[models.size()]);
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
        this.slanCd = this.slanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dirCd = this.dirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rlaneCd = this.rlaneCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydCd = this.ydCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.effFmDt = this.effFmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.effToDt = this.effToDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvdCd = this.vvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pndlmRto = this.pndlmRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.errorCode = this.errorCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.errorMsg = this.errorMsg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lastYn = this.lastYn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rsCnt = this.rsCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
