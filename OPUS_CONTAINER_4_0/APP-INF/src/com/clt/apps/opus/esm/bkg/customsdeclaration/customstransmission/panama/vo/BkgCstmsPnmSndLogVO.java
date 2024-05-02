/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BkgCstmsPnmSndLogVO.java
*@FileTitle : BkgCstmsPnmSndLogVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.vo;

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
public class BkgCstmsPnmSndLogVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<BkgCstmsPnmSndLogVO> models = new ArrayList<BkgCstmsPnmSndLogVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String sndDt = null;

    /* Column Info */
    private String sndLogSeq = null;

    /* Column Info */
    private String vstNo = null;

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String skdVoyNo = null;

    /* Column Info */
    private String skdDirCd = null;

    /* Column Info */
    private String polCd = null;

    /* Column Info */
    private String podCd = null;

    /* Column Info */
    private String ediSndMsgCtnt = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String crrBatNo = null;

    /* Column Info */
    private String vvdCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public BkgCstmsPnmSndLogVO() {
    }

    public BkgCstmsPnmSndLogVO(String ibflag, String pagerows, String sndDt, String sndLogSeq, String vstNo, String vslCd, String skdVoyNo, String skdDirCd, String polCd, String podCd, String ediSndMsgCtnt, String creUsrId, String creDt, String updUsrId, String updDt, String crrBatNo, String vvdCd) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.sndDt = sndDt;
        this.sndLogSeq = sndLogSeq;
        this.vstNo = vstNo;
        this.vslCd = vslCd;
        this.skdVoyNo = skdVoyNo;
        this.skdDirCd = skdDirCd;
        this.polCd = polCd;
        this.podCd = podCd;
        this.ediSndMsgCtnt = ediSndMsgCtnt;
        this.creUsrId = creUsrId;
        this.creDt = creDt;
        this.updUsrId = updUsrId;
        this.updDt = updDt;
        this.crrBatNo = crrBatNo;
        this.vvdCd = vvdCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("snd_dt", getSndDt());
        this.hashColumns.put("snd_log_seq", getSndLogSeq());
        this.hashColumns.put("vst_no", getVstNo());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("skd_dir_cd", getSkdDirCd());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("edi_snd_msg_ctnt", getEdiSndMsgCtnt());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("crr_bat_no", getCrrBatNo());
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
        this.hashFields.put("snd_dt", "sndDt");
        this.hashFields.put("snd_log_seq", "sndLogSeq");
        this.hashFields.put("vst_no", "vstNo");
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("skd_dir_cd", "skdDirCd");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("edi_snd_msg_ctnt", "ediSndMsgCtnt");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("crr_bat_no", "crrBatNo");
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
	 * @param String sndLogSeq
	 */
    public void setSndLogSeq(String sndLogSeq) {
        this.sndLogSeq = sndLogSeq;
    }

    /**
	 * 
	 * @return String sndLogSeq
	 */
    public String getSndLogSeq() {
        return this.sndLogSeq;
    }

    /**
	 *
	 * @param String vstNo
	 */
    public void setVstNo(String vstNo) {
        this.vstNo = vstNo;
    }

    /**
	 * 
	 * @return String vstNo
	 */
    public String getVstNo() {
        return this.vstNo;
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
	 * @param String polCd
	 */
    public void setPolCd(String polCd) {
        this.polCd = polCd;
    }

    /**
	 * 
	 * @return String polCd
	 */
    public String getPolCd() {
        return this.polCd;
    }

    /**
	 *
	 * @param String podCd
	 */
    public void setPodCd(String podCd) {
        this.podCd = podCd;
    }

    /**
	 * 
	 * @return String podCd
	 */
    public String getPodCd() {
        return this.podCd;
    }

    /**
	 *
	 * @param String ediSndMsgCtnt
	 */
    public void setEdiSndMsgCtnt(String ediSndMsgCtnt) {
        this.ediSndMsgCtnt = ediSndMsgCtnt;
    }

    /**
	 * 
	 * @return String ediSndMsgCtnt
	 */
    public String getEdiSndMsgCtnt() {
        return this.ediSndMsgCtnt;
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

    public void setCrrBatNo(String crrBatNo) {
        this.crrBatNo = crrBatNo;
    }

    public String getCrrBatNo() {
        return this.crrBatNo;
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
        setSndDt(JSPUtil.getParameter(request, prefix + "snd_dt", ""));
        setSndLogSeq(JSPUtil.getParameter(request, prefix + "snd_log_seq", ""));
        setVstNo(JSPUtil.getParameter(request, prefix + "vst_no", ""));
        setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
        setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
        setEdiSndMsgCtnt(JSPUtil.getParameter(request, prefix + "edi_snd_msg_ctnt", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setCrrBatNo(JSPUtil.getParameter(request, prefix + "crr_bat_no", ""));
        setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCstmsPnmSndLogVO[]
	 */
    public BkgCstmsPnmSndLogVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgCstmsPnmSndLogVO[]
	 */
    public BkgCstmsPnmSndLogVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        BkgCstmsPnmSndLogVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] sndDt = (JSPUtil.getParameter(request, prefix + "snd_dt", length));
            String[] sndLogSeq = (JSPUtil.getParameter(request, prefix + "snd_log_seq", length));
            String[] vstNo = (JSPUtil.getParameter(request, prefix + "vst_no", length));
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
            String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
            String[] ediSndMsgCtnt = (JSPUtil.getParameter(request, prefix + "edi_snd_msg_ctnt", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] crrBatNo = (JSPUtil.getParameter(request, prefix + "crr_bat_no", length));
            String[] vvdCd = (JSPUtil.getParameter(request, prefix + "vvd_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new BkgCstmsPnmSndLogVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (sndDt[i] != null)
                    model.setSndDt(sndDt[i]);
                if (sndLogSeq[i] != null)
                    model.setSndLogSeq(sndLogSeq[i]);
                if (vstNo[i] != null)
                    model.setVstNo(vstNo[i]);
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (skdVoyNo[i] != null)
                    model.setSkdVoyNo(skdVoyNo[i]);
                if (skdDirCd[i] != null)
                    model.setSkdDirCd(skdDirCd[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (ediSndMsgCtnt[i] != null)
                    model.setEdiSndMsgCtnt(ediSndMsgCtnt[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (crrBatNo[i] != null)
                    model.setCrrBatNo(crrBatNo[i]);
                if (vvdCd[i] != null) 
		    		model.setVvdCd(vvdCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getBkgCstmsPnmSndLogVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return BkgCstmsPnmSndLogVO[]
	 */
    public BkgCstmsPnmSndLogVO[] getBkgCstmsPnmSndLogVOs() {
        BkgCstmsPnmSndLogVO[] vos = (BkgCstmsPnmSndLogVO[]) models.toArray(new BkgCstmsPnmSndLogVO[models.size()]);
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
        this.sndDt = this.sndDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sndLogSeq = this.sndLogSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vstNo = this.vstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediSndMsgCtnt = this.ediSndMsgCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.crrBatNo = this.crrBatNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvdCd = this.vvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
