/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UserAuthListModiVO.java
*@FileTitle : UserAuthListModiVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.08
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.09.08 김민정 
* 1.0 Creation
* -------------------------------------------------------
* History
* 2011.10.12 윤태승 [CHM-201113684-01][ESB_BKG] US AMS 의 MI 중복전송 기능 요청 - IDhjsedlee
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.AuthSetupListVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class UserAuthListModiVO extends AuthSetupListVO {

    private static final long serialVersionUID = 1L;

    private Collection<UserAuthListModiVO> models = new ArrayList<UserAuthListModiVO>();

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String blMib = null;

    /* Column Info */
    private String cofcCd = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String blPtt = null;

    /* Column Info */
    private String blVvd = null;

    /* Column Info */
    private String blFpo = null;

    /* Column Info */
    private String blPod = null;

    /* Column Info */
    private String blHub = null;

    /* Column Info */
    private String blCstms = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String miHub = null;

    /* Column Info */
    private String miCstms = null;

    /* Column Info */
    private String miMulti = null;

    /* Column Info */
    private String ofcCd = null;

    /* Column Info */
    private String creUsrId = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String usrNm = null;

    /* Column Info */
    private String usrId = null;

    /* Column Info */
    private String cntCd = null;

    /* Column Info */
    private String blDel = null;

    /* Column Info */
    private String blFtz = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String blDiv = null;

    /* Column Info */
    private String ofMit = null;

    /* Column Info */
    private String ofHis = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public UserAuthListModiVO() {
    }

    public UserAuthListModiVO(String ibflag, String pagerows, String cntCd, String blVvd, String blPod, String blDel, String blHub, String blCstms, String blFpo, String blMib, String blPtt, String blFtz, String miHub, String miCstms, String miMulti, String usrId, String creUsrId, String creDt, String updUsrId, String updDt, String usrNm, String ofcCd, String cofcCd, String blDiv, String ofMit, String ofHis) {
        this.updDt = updDt;
        this.blMib = blMib;
        this.cofcCd = cofcCd;
        this.creDt = creDt;
        this.blPtt = blPtt;
        this.blVvd = blVvd;
        this.blFpo = blFpo;
        this.blPod = blPod;
        this.blHub = blHub;
        this.blCstms = blCstms;
        this.pagerows = pagerows;
        this.miHub = miHub;
        this.miCstms = miCstms;
        this.miMulti = miMulti;
        this.ofcCd = ofcCd;
        this.creUsrId = creUsrId;
        this.ibflag = ibflag;
        this.usrNm = usrNm;
        this.usrId = usrId;
        this.cntCd = cntCd;
        this.blDel = blDel;
        this.blFtz = blFtz;
        this.updUsrId = updUsrId;
        this.blDiv = blDiv;
        this.ofMit = ofMit;
        this.ofHis = ofHis;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("bl_mib", getBlMib());
        this.hashColumns.put("cofc_cd", getCofcCd());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("bl_ptt", getBlPtt());
        this.hashColumns.put("bl_vvd", getBlVvd());
        this.hashColumns.put("bl_fpo", getBlFpo());
        this.hashColumns.put("bl_pod", getBlPod());
        this.hashColumns.put("bl_hub", getBlHub());
        this.hashColumns.put("bl_cstms", getBlCstms());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("mi_hub", getMiHub());
        this.hashColumns.put("mi_cstms", getMiCstms());
        this.hashColumns.put("mi_multi", getMiMulti());
        this.hashColumns.put("ofc_cd", getOfcCd());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("usr_nm", getUsrNm());
        this.hashColumns.put("usr_id", getUsrId());
        this.hashColumns.put("cnt_cd", getCntCd());
        this.hashColumns.put("bl_del", getBlDel());
        this.hashColumns.put("bl_ftz", getBlFtz());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("bl_div", getBlDiv());
        this.hashColumns.put("of_mit", getOfMit());
        this.hashColumns.put("of_his", getOfHis());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("bl_mib", "blMib");
        this.hashFields.put("cofc_cd", "cofcCd");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("bl_ptt", "blPtt");
        this.hashFields.put("bl_vvd", "blVvd");
        this.hashFields.put("bl_fpo", "blFpo");
        this.hashFields.put("bl_pod", "blPod");
        this.hashFields.put("bl_hub", "blHub");
        this.hashFields.put("bl_cstms", "blCstms");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("mi_hub", "miHub");
        this.hashFields.put("mi_cstms", "miCstms");
        this.hashFields.put("mi_multi", "miMulti");
        this.hashFields.put("ofc_cd", "ofcCd");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("usr_nm", "usrNm");
        this.hashFields.put("usr_id", "usrId");
        this.hashFields.put("cnt_cd", "cntCd");
        this.hashFields.put("bl_del", "blDel");
        this.hashFields.put("bl_ftz", "blFtz");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("bl_div", "blDiv");
        this.hashFields.put("of_mit", "ofMit");
        this.hashFields.put("of_his", "ofHis");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return updDt
	 */
    public String getUpdDt() {
        return this.updDt;
    }

    /**
	 * Column Info
	 * @return blMib
	 */
    public String getBlMib() {
        return this.blMib;
    }

    /**
	 * Column Info
	 * @return cofcCd
	 */
    public String getCofcCd() {
        return this.cofcCd;
    }

    /**
	 * Column Info
	 * @return creDt
	 */
    public String getCreDt() {
        return this.creDt;
    }

    /**
	 * Column Info
	 * @return blPtt
	 */
    public String getBlPtt() {
        return this.blPtt;
    }

    /**
	 * Column Info
	 * @return blVvd
	 */
    public String getBlVvd() {
        return this.blVvd;
    }

    /**
	 * Column Info
	 * @return blFpo
	 */
    public String getBlFpo() {
        return this.blFpo;
    }

    /**
	 * Column Info
	 * @return blPod
	 */
    public String getBlPod() {
        return this.blPod;
    }

    /**
	 * Column Info
	 * @return blHub
	 */
    public String getBlHub() {
        return this.blHub;
    }

    /**
	 * Column Info
	 * @return blCstms
	 */
    public String getBlCstms() {
        return this.blCstms;
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
	 * @return miHub
	 */
    public String getMiHub() {
        return this.miHub;
    }

    /**
	 * Column Info
	 * @return miCstms
	 */
    public String getMiCstms() {
        return this.miCstms;
    }

    /**
	 * Column Info
	 * @return miMulti
	 */
    public String getMiMulti() {
        return this.miMulti;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
    public String getIbflag() {
        return this.ibflag;
    }

    /**
	 * Column Info
	 * @return usrNm
	 */
    public String getUsrNm() {
        return this.usrNm;
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
	 * @return cntCd
	 */
    public String getCntCd() {
        return this.cntCd;
    }

    /**
	 * Column Info
	 * @return blDel
	 */
    public String getBlDel() {
        return this.blDel;
    }

    /**
	 * Column Info
	 * @return blFtz
	 */
    public String getBlFtz() {
        return this.blFtz;
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
	 * @return blDiv
	 */
    public String getBlDiv() {
        return this.blDiv;
    }

    /**
	 * Column Info
	 * @param updDt
	 */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    /**
	 * Column Info
	 * @param blMib
	 */
    public void setBlMib(String blMib) {
        this.blMib = blMib;
    }

    /**
	 * Column Info
	 * @param cofcCd
	 */
    public void setCofcCd(String cofcCd) {
        this.cofcCd = cofcCd;
    }

    /**
	 * Column Info
	 * @param creDt
	 */
    public void setCreDt(String creDt) {
        this.creDt = creDt;
    }

    /**
	 * Column Info
	 * @param blPtt
	 */
    public void setBlPtt(String blPtt) {
        this.blPtt = blPtt;
    }

    /**
	 * Column Info
	 * @param blVvd
	 */
    public void setBlVvd(String blVvd) {
        this.blVvd = blVvd;
    }

    /**
	 * Column Info
	 * @param blFpo
	 */
    public void setBlFpo(String blFpo) {
        this.blFpo = blFpo;
    }

    /**
	 * Column Info
	 * @param blPod
	 */
    public void setBlPod(String blPod) {
        this.blPod = blPod;
    }

    /**
	 * Column Info
	 * @param blHub
	 */
    public void setBlHub(String blHub) {
        this.blHub = blHub;
    }

    /**
	 * Column Info
	 * @param blCstms
	 */
    public void setBlCstms(String blCstms) {
        this.blCstms = blCstms;
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
	 * @param miHub
	 */
    public void setMiHub(String miHub) {
        this.miHub = miHub;
    }

    /**
	 * Column Info
	 * @param miCstms
	 */
    public void setMiCstms(String miCstms) {
        this.miCstms = miCstms;
    }

    /**
	 * Column Info
	 * @param miMulti
	 */
    public void setMiMulti(String miMulti) {
        this.miMulti = miMulti;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
    }

    /**
	 * Column Info
	 * @param usrNm
	 */
    public void setUsrNm(String usrNm) {
        this.usrNm = usrNm;
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
	 * @param cntCd
	 */
    public void setCntCd(String cntCd) {
        this.cntCd = cntCd;
    }

    /**
	 * Column Info
	 * @param blDel
	 */
    public void setBlDel(String blDel) {
        this.blDel = blDel;
    }

    /**
	 * Column Info
	 * @param blFtz
	 */
    public void setBlFtz(String blFtz) {
        this.blFtz = blFtz;
    }

    /**
	 * Column Info
	 * @param updUsrId
	 */
    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
    }

    /**
	 * Column Info
	 * @param blDiv
	 */
    public void setBlDiv(String blDiv) {
        this.blDiv = blDiv;
    }

    public void setOfMit(String ofMit) {
        this.ofMit = ofMit;
    }

    public String getOfMit() {
        return this.ofMit;
    }

    public void setOfHis(String ofHis) {
        this.ofHis = ofHis;
    }

    public String getOfHis() {
        return this.ofHis;
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
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setBlMib(JSPUtil.getParameter(request, prefix + "bl_mib", ""));
        setCofcCd(JSPUtil.getParameter(request, prefix + "cofc_cd", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setBlPtt(JSPUtil.getParameter(request, prefix + "bl_ptt", ""));
        setBlVvd(JSPUtil.getParameter(request, prefix + "bl_vvd", ""));
        setBlFpo(JSPUtil.getParameter(request, prefix + "bl_fpo", ""));
        setBlPod(JSPUtil.getParameter(request, prefix + "bl_pod", ""));
        setBlHub(JSPUtil.getParameter(request, prefix + "bl_hub", ""));
        setBlCstms(JSPUtil.getParameter(request, prefix + "bl_cstms", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setMiHub(JSPUtil.getParameter(request, prefix + "mi_hub", ""));
        setMiCstms(JSPUtil.getParameter(request, prefix + "mi_cstms", ""));
        setMiMulti(JSPUtil.getParameter(request, prefix + "mi_multi", ""));
        setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setUsrNm(JSPUtil.getParameter(request, prefix + "usr_nm", ""));
        setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
        setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
        setBlDel(JSPUtil.getParameter(request, prefix + "bl_del", ""));
        setBlFtz(JSPUtil.getParameter(request, prefix + "bl_ftz", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setBlDiv(JSPUtil.getParameter(request, prefix + "bl_div", ""));
        setOfMit(JSPUtil.getParameter(request, prefix + "of_mit", ""));
        setOfHis(JSPUtil.getParameter(request, prefix + "of_his", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UserAuthListModiVO[]
	 */
    public UserAuthListModiVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UserAuthListModiVO[]
	 */
    public UserAuthListModiVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        UserAuthListModiVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] blMib = (JSPUtil.getParameter(request, prefix + "bl_mib", length));
            String[] cofcCd = (JSPUtil.getParameter(request, prefix + "cofc_cd", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] blPtt = (JSPUtil.getParameter(request, prefix + "bl_ptt", length));
            String[] blVvd = (JSPUtil.getParameter(request, prefix + "bl_vvd", length));
            String[] blFpo = (JSPUtil.getParameter(request, prefix + "bl_fpo", length));
            String[] blPod = (JSPUtil.getParameter(request, prefix + "bl_pod", length));
            String[] blHub = (JSPUtil.getParameter(request, prefix + "bl_hub", length));
            String[] blCstms = (JSPUtil.getParameter(request, prefix + "bl_cstms", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] miHub = (JSPUtil.getParameter(request, prefix + "mi_hub", length));
            String[] miCstms = (JSPUtil.getParameter(request, prefix + "mi_cstms", length));
            String[] miMulti = (JSPUtil.getParameter(request, prefix + "mi_multi", length));
            String[] ofcCd = (JSPUtil.getParameter(request, prefix + "ofc_cd", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] usrNm = (JSPUtil.getParameter(request, prefix + "usr_nm", length));
            String[] usrId = (JSPUtil.getParameter(request, prefix + "usr_id", length));
            String[] cntCd = (JSPUtil.getParameter(request, prefix + "cnt_cd", length));
            String[] blDel = (JSPUtil.getParameter(request, prefix + "bl_del", length));
            String[] blFtz = (JSPUtil.getParameter(request, prefix + "bl_ftz", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] blDiv = (JSPUtil.getParameter(request, prefix + "bl_div", length));
            String[] ofMit = (JSPUtil.getParameter(request, prefix + "of_mit", length));
            String[] ofHis = (JSPUtil.getParameter(request, prefix + "of_his", length));
            for (int i = 0; i < length; i++) {
                model = new UserAuthListModiVO();
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (blMib[i] != null)
                    model.setBlMib(blMib[i]);
                if (cofcCd[i] != null)
                    model.setCofcCd(cofcCd[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (blPtt[i] != null)
                    model.setBlPtt(blPtt[i]);
                if (blVvd[i] != null)
                    model.setBlVvd(blVvd[i]);
                if (blFpo[i] != null)
                    model.setBlFpo(blFpo[i]);
                if (blPod[i] != null)
                    model.setBlPod(blPod[i]);
                if (blHub[i] != null)
                    model.setBlHub(blHub[i]);
                if (blCstms[i] != null)
                    model.setBlCstms(blCstms[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (miHub[i] != null)
                    model.setMiHub(miHub[i]);
                if (miCstms[i] != null)
                    model.setMiCstms(miCstms[i]);
                if (miMulti[i] != null)
                    model.setMiMulti(miMulti[i]);
                if (ofcCd[i] != null)
                    model.setOfcCd(ofcCd[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (usrNm[i] != null)
                    model.setUsrNm(usrNm[i]);
                if (usrId[i] != null)
                    model.setUsrId(usrId[i]);
                if (cntCd[i] != null)
                    model.setCntCd(cntCd[i]);
                if (blDel[i] != null)
                    model.setBlDel(blDel[i]);
                if (blFtz[i] != null)
                    model.setBlFtz(blFtz[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (blDiv[i] != null)
                    model.setBlDiv(blDiv[i]);
                if (ofMit[i] != null)
                    model.setOfMit(ofMit[i]);
                if (ofHis[i] != null)
                    model.setOfHis(ofHis[i]);
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getUserAuthListModiVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return UserAuthListModiVO[]
	 */
    public UserAuthListModiVO[] getUserAuthListModiVOs() {
        UserAuthListModiVO[] vos = (UserAuthListModiVO[]) models.toArray(new UserAuthListModiVO[models.size()]);
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
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blMib = this.blMib.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cofcCd = this.cofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blPtt = this.blPtt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blVvd = this.blVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blFpo = this.blFpo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blPod = this.blPod.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blHub = this.blHub.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blCstms = this.blCstms.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.miHub = this.miHub.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.miCstms = this.miCstms.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.miMulti = this.miMulti.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcCd = this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usrNm = this.usrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usrId = this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntCd = this.cntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blDel = this.blDel.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blFtz = this.blFtz.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blDiv = this.blDiv.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofMit = this.ofMit.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofHis = this.ofHis.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
