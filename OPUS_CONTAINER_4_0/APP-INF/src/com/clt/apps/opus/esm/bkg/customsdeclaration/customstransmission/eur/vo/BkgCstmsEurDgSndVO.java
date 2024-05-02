/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BkgCstmsEurDgSndVO.java
*@FileTitle : BkgCstmsEurDgSndVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.28
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo;

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
public class BkgCstmsEurDgSndVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<BkgCstmsEurDgSndVO> models = new ArrayList<BkgCstmsEurDgSndVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String eurEdiMsgTpId = null;

    /* Column Info */
    private String msgSndNo = null;

    /* Column Info */
    private String sndDt = null;

    /* Column Info */
    private String sndGdt = null;

    /* Column Info */
    private String sndUsrId = null;

    /* Column Info */
    private String autoSndTpCd = null;

    /* Column Info */
    private String msgFuncId = null;

    /* Column Info */
    private String eurDgDeclTpCd = null;

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String skdVoyNo = null;

    /* Column Info */
    private String skdDirCd = null;

    /* Column Info */
    private String portCd = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String vvdCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public BkgCstmsEurDgSndVO() {
    }

    public BkgCstmsEurDgSndVO(String ibflag, String pagerows, String eurEdiMsgTpId, String msgSndNo, String sndDt, String sndGdt, String sndUsrId, String autoSndTpCd, String msgFuncId, String eurDgDeclTpCd, String vslCd, String skdVoyNo, String skdDirCd, String portCd, String creUsrId, String creDt, String updUsrId, String updDt, String vvdCd) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.eurEdiMsgTpId = eurEdiMsgTpId;
        this.msgSndNo = msgSndNo;
        this.sndDt = sndDt;
        this.sndGdt = sndGdt;
        this.sndUsrId = sndUsrId;
        this.autoSndTpCd = autoSndTpCd;
        this.msgFuncId = msgFuncId;
        this.eurDgDeclTpCd = eurDgDeclTpCd;
        this.vslCd = vslCd;
        this.skdVoyNo = skdVoyNo;
        this.skdDirCd = skdDirCd;
        this.portCd = portCd;
        this.creUsrId = creUsrId;
        this.creDt = creDt;
        this.updUsrId = updUsrId;
        this.updDt = updDt;
        this.vvdCd = vvdCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("eur_edi_msg_tp_id", getEurEdiMsgTpId());
        this.hashColumns.put("msg_snd_no", getMsgSndNo());
        this.hashColumns.put("snd_dt", getSndDt());
        this.hashColumns.put("snd_gdt", getSndGdt());
        this.hashColumns.put("snd_usr_id", getSndUsrId());
        this.hashColumns.put("auto_snd_tp_cd", getAutoSndTpCd());
        this.hashColumns.put("msg_func_id", getMsgFuncId());
        this.hashColumns.put("eur_dg_decl_tp_cd", getEurDgDeclTpCd());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("skd_dir_cd", getSkdDirCd());
        this.hashColumns.put("port_cd", getPortCd());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("vvd_cd", getVvdCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("eur_edi_msg_tp_id", "eurEdiMsgTpId");
        this.hashFields.put("msg_snd_no", "msgSndNo");
        this.hashFields.put("snd_dt", "sndDt");
        this.hashFields.put("snd_gdt", "sndGdt");
        this.hashFields.put("snd_usr_id", "sndUsrId");
        this.hashFields.put("auto_snd_tp_cd", "autoSndTpCd");
        this.hashFields.put("msg_func_id", "msgFuncId");
        this.hashFields.put("eur_dg_decl_tp_cd", "eurDgDeclTpCd");
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("skd_dir_cd", "skdDirCd");
        this.hashFields.put("port_cd", "portCd");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("vvd_cd", "vvdCd");
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
	 * @param String eurEdiMsgTpId
	 */
    public void setEurEdiMsgTpId(String eurEdiMsgTpId) {
        this.eurEdiMsgTpId = eurEdiMsgTpId;
    }

    /**
	 * 
	 * @return String eurEdiMsgTpId
	 */
    public String getEurEdiMsgTpId() {
        return this.eurEdiMsgTpId;
    }

    /**
	 *
	 * @param String msgSndNo
	 */
    public void setMsgSndNo(String msgSndNo) {
        this.msgSndNo = msgSndNo;
    }

    /**
	 * 
	 * @return String msgSndNo
	 */
    public String getMsgSndNo() {
        return this.msgSndNo;
    }

    /**
	 *
	 * @param String sndDt
	 */
    public void setSndDt(String sndDt) {
        this.sndDt = sndDt;
    }

    /**
	 * 
	 * @return String sndDt
	 */
    public String getSndDt() {
        return this.sndDt;
    }

    /**
	 *
	 * @param String sndGdt
	 */
    public void setSndGdt(String sndGdt) {
        this.sndGdt = sndGdt;
    }

    /**
	 * 
	 * @return String sndGdt
	 */
    public String getSndGdt() {
        return this.sndGdt;
    }

    /**
	 *
	 * @param String sndUsrId
	 */
    public void setSndUsrId(String sndUsrId) {
        this.sndUsrId = sndUsrId;
    }

    /**
	 * 
	 * @return String sndUsrId
	 */
    public String getSndUsrId() {
        return this.sndUsrId;
    }

    /**
	 *
	 * @param String autoSndTpCd
	 */
    public void setAutoSndTpCd(String autoSndTpCd) {
        this.autoSndTpCd = autoSndTpCd;
    }

    /**
	 * 
	 * @return String autoSndTpCd
	 */
    public String getAutoSndTpCd() {
        return this.autoSndTpCd;
    }

    /**
	 *
	 * @param String msgFuncId
	 */
    public void setMsgFuncId(String msgFuncId) {
        this.msgFuncId = msgFuncId;
    }

    /**
	 * 
	 * @return String msgFuncId
	 */
    public String getMsgFuncId() {
        return this.msgFuncId;
    }

    /**
	 *
	 * @param String eurDgDeclTpCd
	 */
    public void setEurDgDeclTpCd(String eurDgDeclTpCd) {
        this.eurDgDeclTpCd = eurDgDeclTpCd;
    }

    /**
	 * 
	 * @return String eurDgDeclTpCd
	 */
    public String getEurDgDeclTpCd() {
        return this.eurDgDeclTpCd;
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
	 * @param String portCd
	 */
    public void setPortCd(String portCd) {
        this.portCd = portCd;
    }

    /**
	 * 
	 * @return String portCd
	 */
    public String getPortCd() {
        return this.portCd;
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

    public void setVvdCd(String vvdCd) {
        this.vvdCd = vvdCd;
    }

    public String getVvdCd() {
        return this.vvdCd;
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
        setEurEdiMsgTpId(JSPUtil.getParameter(request, prefix + "eur_edi_msg_tp_id", ""));
        setMsgSndNo(JSPUtil.getParameter(request, prefix + "msg_snd_no", ""));
        setSndDt(JSPUtil.getParameter(request, prefix + "snd_dt", ""));
        setSndGdt(JSPUtil.getParameter(request, prefix + "snd_gdt", ""));
        setSndUsrId(JSPUtil.getParameter(request, prefix + "snd_usr_id", ""));
        setAutoSndTpCd(JSPUtil.getParameter(request, prefix + "auto_snd_tp_cd", ""));
        setMsgFuncId(JSPUtil.getParameter(request, prefix + "msg_func_id", ""));
        setEurDgDeclTpCd(JSPUtil.getParameter(request, prefix + "eur_dg_decl_tp_cd", ""));
        setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
        setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
        setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCstmsEurDgSndVO[]
	 */
    public BkgCstmsEurDgSndVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgCstmsEurDgSndVO[]
	 */
    public BkgCstmsEurDgSndVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        BkgCstmsEurDgSndVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] eurEdiMsgTpId = (JSPUtil.getParameter(request, prefix + "eur_edi_msg_tp_id", length));
            String[] msgSndNo = (JSPUtil.getParameter(request, prefix + "msg_snd_no", length));
            String[] sndDt = (JSPUtil.getParameter(request, prefix + "snd_dt", length));
            String[] sndGdt = (JSPUtil.getParameter(request, prefix + "snd_gdt", length));
            String[] sndUsrId = (JSPUtil.getParameter(request, prefix + "snd_usr_id", length));
            String[] autoSndTpCd = (JSPUtil.getParameter(request, prefix + "auto_snd_tp_cd", length));
            String[] msgFuncId = (JSPUtil.getParameter(request, prefix + "msg_func_id", length));
            String[] eurDgDeclTpCd = (JSPUtil.getParameter(request, prefix + "eur_dg_decl_tp_cd", length));
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
            String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
            String[] portCd = (JSPUtil.getParameter(request, prefix + "port_cd", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] vvdCd = (JSPUtil.getParameter(request, prefix + "vvd_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new BkgCstmsEurDgSndVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (eurEdiMsgTpId[i] != null)
                    model.setEurEdiMsgTpId(eurEdiMsgTpId[i]);
                if (msgSndNo[i] != null)
                    model.setMsgSndNo(msgSndNo[i]);
                if (sndDt[i] != null)
                    model.setSndDt(sndDt[i]);
                if (sndGdt[i] != null)
                    model.setSndGdt(sndGdt[i]);
                if (sndUsrId[i] != null)
                    model.setSndUsrId(sndUsrId[i]);
                if (autoSndTpCd[i] != null)
                    model.setAutoSndTpCd(autoSndTpCd[i]);
                if (msgFuncId[i] != null)
                    model.setMsgFuncId(msgFuncId[i]);
                if (eurDgDeclTpCd[i] != null)
                    model.setEurDgDeclTpCd(eurDgDeclTpCd[i]);
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (skdVoyNo[i] != null)
                    model.setSkdVoyNo(skdVoyNo[i]);
                if (skdDirCd[i] != null)
                    model.setSkdDirCd(skdDirCd[i]);
                if (portCd[i] != null)
                    model.setPortCd(portCd[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (vvdCd[i] != null) 
		    		model.setVvdCd(vvdCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getBkgCstmsEurDgSndVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return BkgCstmsEurDgSndVO[]
	 */
    public BkgCstmsEurDgSndVO[] getBkgCstmsEurDgSndVOs() {
        BkgCstmsEurDgSndVO[] vos = (BkgCstmsEurDgSndVO[]) models.toArray(new BkgCstmsEurDgSndVO[models.size()]);
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
        this.eurEdiMsgTpId = this.eurEdiMsgTpId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.msgSndNo = this.msgSndNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sndDt = this.sndDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sndGdt = this.sndGdt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sndUsrId = this.sndUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.autoSndTpCd = this.autoSndTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.msgFuncId = this.msgFuncId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eurDgDeclTpCd = this.eurDgDeclTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.portCd = this.portCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvdCd = this.vvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
