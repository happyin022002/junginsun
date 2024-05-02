/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CndCstmsManifestAmendmentCondVO.java
*@FileTitle : CndCstmsManifestAmendmentCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.20
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.04.20 김민정 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsManifestAmendmentCondVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class CndCstmsManifestAmendmentCondVO extends CstmsManifestAmendmentCondVO {

    private static final long serialVersionUID = 1L;

    private Collection<CndCstmsManifestAmendmentCondVO> models = new ArrayList<CndCstmsManifestAmendmentCondVO>();

    /* Column Info */
    private String sndDtFlg = null;

    /* Column Info */
    private String bkgOfcCd = null;

    /* Column Info */
    private String docUsrId = null;

    /* Column Info */
    private String aiType = null;

    /* Column Info */
    private String sSndDt = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String podCd = null;

    /* Column Info */
    private String obSrepCd = null;

    /* Column Info */
    private String bkgNo = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String polCd = null;

    /* Column Info */
    private String vvdCd = null;

    /* Column Info */
    private String mblNo = null;

    /* Column Info */
    private String fullMtyCd = null;

    /* Column Info */
    private String eSndDt = null;

    /* Column Info */
    private String aiGubun = null;

    /* Column Info */
    private String statusGubun = null;

    /* Column Info */
    private String stsDiv = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public CndCstmsManifestAmendmentCondVO() {
    }

    public CndCstmsManifestAmendmentCondVO(String ibflag, String pagerows, String aiType, String vvdCd, String polCd, String podCd, String sndDtFlg, String sSndDt, String eSndDt, String fullMtyCd, String bkgOfcCd, String docUsrId, String obSrepCd, String bkgNo, String mblNo, String aiGubun, String statusGubun, String stsDiv) {
        this.sndDtFlg = sndDtFlg;
        this.bkgOfcCd = bkgOfcCd;
        this.docUsrId = docUsrId;
        this.aiType = aiType;
        this.sSndDt = sSndDt;
        this.pagerows = pagerows;
        this.podCd = podCd;
        this.obSrepCd = obSrepCd;
        this.bkgNo = bkgNo;
        this.ibflag = ibflag;
        this.polCd = polCd;
        this.vvdCd = vvdCd;
        this.mblNo = mblNo;
        this.fullMtyCd = fullMtyCd;
        this.eSndDt = eSndDt;
        this.aiGubun = aiGubun;
        this.statusGubun = statusGubun;
        this.stsDiv = stsDiv;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("snd_dt_flg", getSndDtFlg());
        this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
        this.hashColumns.put("doc_usr_id", getDocUsrId());
        this.hashColumns.put("ai_type", getAiType());
        this.hashColumns.put("s_snd_dt", getSSndDt());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("ob_srep_cd", getObSrepCd());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("vvd_cd", getVvdCd());
        this.hashColumns.put("mbl_no", getMblNo());
        this.hashColumns.put("full_mty_cd", getFullMtyCd());
        this.hashColumns.put("e_snd_dt", getESndDt());
        this.hashColumns.put("ai_gubun", getAiGubun());
        this.hashColumns.put("status_gubun", getStatusGubun());
        this.hashColumns.put("sts_div", getStsDiv());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("snd_dt_flg", "sndDtFlg");
        this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
        this.hashFields.put("doc_usr_id", "docUsrId");
        this.hashFields.put("ai_type", "aiType");
        this.hashFields.put("s_snd_dt", "sSndDt");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("ob_srep_cd", "obSrepCd");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("vvd_cd", "vvdCd");
        this.hashFields.put("mbl_no", "mblNo");
        this.hashFields.put("full_mty_cd", "fullMtyCd");
        this.hashFields.put("e_snd_dt", "eSndDt");
        this.hashFields.put("ai_gubun", "aiGubun");
        this.hashFields.put("status_gubun", "statusGubun");
        this.hashFields.put("sts_div", "stsDiv");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return sndDtFlg
	 */
    public String getSndDtFlg() {
        return this.sndDtFlg;
    }

    /**
	 * Column Info
	 * @return bkgOfcCd
	 */
    public String getBkgOfcCd() {
        return this.bkgOfcCd;
    }

    /**
	 * Column Info
	 * @return docUsrId
	 */
    public String getDocUsrId() {
        return this.docUsrId;
    }

    /**
	 * Column Info
	 * @return aiType
	 */
    public String getAiType() {
        return this.aiType;
    }

    /**
	 * Column Info
	 * @return sSndDt
	 */
    public String getSSndDt() {
        return this.sSndDt;
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
	 * @return podCd
	 */
    public String getPodCd() {
        return this.podCd;
    }

    /**
	 * Column Info
	 * @return obSrepCd
	 */
    public String getObSrepCd() {
        return this.obSrepCd;
    }

    /**
	 * Column Info
	 * @return bkgNo
	 */
    public String getBkgNo() {
        return this.bkgNo;
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
	 * @return polCd
	 */
    public String getPolCd() {
        return this.polCd;
    }

    /**
	 * Column Info
	 * @return vvdCd
	 */
    public String getVvdCd() {
        return this.vvdCd;
    }

    /**
	 * Column Info
	 * @return mblNo
	 */
    public String getMblNo() {
        return this.mblNo;
    }

    /**
	 * Column Info
	 * @return fullMtyCd
	 */
    public String getFullMtyCd() {
        return this.fullMtyCd;
    }

    /**
	 * Column Info
	 * @return eSndDt
	 */
    public String getESndDt() {
        return this.eSndDt;
    }

    /**
	 * Column Info
	 * @return aiGubun
	 */
    public String getAiGubun() {
        return this.aiGubun;
    }

    /**
	 * Column Info
	 * @return statusGubun
	 */
    public String getStatusGubun() {
        return this.statusGubun;
    }

    /**
	 * Column Info
	 * @param sndDtFlg
	 */
    public void setSndDtFlg(String sndDtFlg) {
        this.sndDtFlg = sndDtFlg;
    }

    /**
	 * Column Info
	 * @param bkgOfcCd
	 */
    public void setBkgOfcCd(String bkgOfcCd) {
        this.bkgOfcCd = bkgOfcCd;
    }

    /**
	 * Column Info
	 * @param docUsrId
	 */
    public void setDocUsrId(String docUsrId) {
        this.docUsrId = docUsrId;
    }

    /**
	 * Column Info
	 * @param aiType
	 */
    public void setAiType(String aiType) {
        this.aiType = aiType;
    }

    /**
	 * Column Info
	 * @param sSndDt
	 */
    public void setSSndDt(String sSndDt) {
        this.sSndDt = sSndDt;
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
	 * @param podCd
	 */
    public void setPodCd(String podCd) {
        this.podCd = podCd;
    }

    /**
	 * Column Info
	 * @param obSrepCd
	 */
    public void setObSrepCd(String obSrepCd) {
        this.obSrepCd = obSrepCd;
    }

    /**
	 * Column Info
	 * @param bkgNo
	 */
    public void setBkgNo(String bkgNo) {
        this.bkgNo = bkgNo;
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
	 * @param polCd
	 */
    public void setPolCd(String polCd) {
        this.polCd = polCd;
    }

    /**
	 * Column Info
	 * @param vvdCd
	 */
    public void setVvdCd(String vvdCd) {
        this.vvdCd = vvdCd;
    }

    /**
	 * Column Info
	 * @param mblNo
	 */
    public void setMblNo(String mblNo) {
        this.mblNo = mblNo;
    }

    /**
	 * Column Info
	 * @param fullMtyCd
	 */
    public void setFullMtyCd(String fullMtyCd) {
        this.fullMtyCd = fullMtyCd;
    }

    /**
	 * Column Info
	 * @param eSndDt
	 */
    public void setESndDt(String eSndDt) {
        this.eSndDt = eSndDt;
    }

    /**
	 * Column Info
	 * @param aiGubun
	 */
    public void setAiGubun(String aiGubun) {
        this.aiGubun = aiGubun;
    }

    /**
	 * Column Info
	 * @param statusGubun
	 */
    public void setStatusGubun(String statusGubun) {
        this.statusGubun = statusGubun;
    }

    public void setStsDiv(String stsDiv) {
        this.stsDiv = stsDiv;
    }

    public String getStsDiv() {
        return this.stsDiv;
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
        setSndDtFlg(JSPUtil.getParameter(request, prefix + "snd_dt_flg", ""));
        setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
        setDocUsrId(JSPUtil.getParameter(request, prefix + "doc_usr_id", ""));
        setAiType(JSPUtil.getParameter(request, prefix + "ai_type", ""));
        setSSndDt(JSPUtil.getParameter(request, prefix + "s_snd_dt", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
        setObSrepCd(JSPUtil.getParameter(request, prefix + "ob_srep_cd", ""));
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
        setMblNo(JSPUtil.getParameter(request, prefix + "mbl_no", ""));
        setFullMtyCd(JSPUtil.getParameter(request, prefix + "full_mty_cd", ""));
        setESndDt(JSPUtil.getParameter(request, prefix + "e_snd_dt", ""));
        setAiGubun(JSPUtil.getParameter(request, prefix + "ai_gubun", ""));
        setStatusGubun(JSPUtil.getParameter(request, prefix + "status_gubun", ""));
        setStsDiv(JSPUtil.getParameter(request, prefix + "sts_div", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CndCstmsManifestAmendmentCondVO[]
	 */
    public CndCstmsManifestAmendmentCondVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CndCstmsManifestAmendmentCondVO[]
	 */
    public CndCstmsManifestAmendmentCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        CndCstmsManifestAmendmentCondVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] sndDtFlg = (JSPUtil.getParameter(request, prefix + "snd_dt_flg", length));
            String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", length));
            String[] docUsrId = (JSPUtil.getParameter(request, prefix + "doc_usr_id", length));
            String[] aiType = (JSPUtil.getParameter(request, prefix + "ai_type", length));
            String[] sSndDt = (JSPUtil.getParameter(request, prefix + "s_snd_dt", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
            String[] obSrepCd = (JSPUtil.getParameter(request, prefix + "ob_srep_cd", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] vvdCd = (JSPUtil.getParameter(request, prefix + "vvd_cd", length));
            String[] mblNo = (JSPUtil.getParameter(request, prefix + "mbl_no", length));
            String[] fullMtyCd = (JSPUtil.getParameter(request, prefix + "full_mty_cd", length));
            String[] eSndDt = (JSPUtil.getParameter(request, prefix + "e_snd_dt", length));
            String[] aiGubun = (JSPUtil.getParameter(request, prefix + "ai_gubun", length));
            String[] statusGubun = (JSPUtil.getParameter(request, prefix + "status_gubun", length));
            String[] stsDiv = (JSPUtil.getParameter(request, prefix + "sts_div", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new CndCstmsManifestAmendmentCondVO();
                if (sndDtFlg[i] != null)
                    model.setSndDtFlg(sndDtFlg[i]);
                if (bkgOfcCd[i] != null)
                    model.setBkgOfcCd(bkgOfcCd[i]);
                if (docUsrId[i] != null)
                    model.setDocUsrId(docUsrId[i]);
                if (aiType[i] != null)
                    model.setAiType(aiType[i]);
                if (sSndDt[i] != null)
                    model.setSSndDt(sSndDt[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (obSrepCd[i] != null)
                    model.setObSrepCd(obSrepCd[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (vvdCd[i] != null)
                    model.setVvdCd(vvdCd[i]);
                if (mblNo[i] != null)
                    model.setMblNo(mblNo[i]);
                if (fullMtyCd[i] != null)
                    model.setFullMtyCd(fullMtyCd[i]);
                if (eSndDt[i] != null)
                    model.setESndDt(eSndDt[i]);
                if (aiGubun[i] != null)
                    model.setAiGubun(aiGubun[i]);
                if (statusGubun[i] != null)
                    model.setStatusGubun(statusGubun[i]);
                if (stsDiv[i] != null) 
		    		model.setStsDiv(stsDiv[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getCndCstmsManifestAmendmentCondVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return CndCstmsManifestAmendmentCondVO[]
	 */
    public CndCstmsManifestAmendmentCondVO[] getCndCstmsManifestAmendmentCondVOs() {
        CndCstmsManifestAmendmentCondVO[] vos = (CndCstmsManifestAmendmentCondVO[]) models.toArray(new CndCstmsManifestAmendmentCondVO[models.size()]);
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
        this.sndDtFlg = this.sndDtFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgOfcCd = this.bkgOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.docUsrId = this.docUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aiType = this.aiType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sSndDt = this.sSndDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.obSrepCd = this.obSrepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvdCd = this.vvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mblNo = this.mblNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fullMtyCd = this.fullMtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eSndDt = this.eSndDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aiGubun = this.aiGubun.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.statusGubun = this.statusGubun.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stsDiv = this.stsDiv.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
