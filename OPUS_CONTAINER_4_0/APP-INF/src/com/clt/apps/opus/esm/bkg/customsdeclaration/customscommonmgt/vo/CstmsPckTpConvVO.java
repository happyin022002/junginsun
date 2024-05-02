/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CstmsPckTpConvVO.java
*@FileTitle : CstmsPckTpConvVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.08
*@LastModifier : 
*@LastVersion : 1.0
* 2012.05.08  
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.vo;

import java.lang.reflect.Field;
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class CstmsPckTpConvVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<CstmsPckTpConvVO> models = new ArrayList<CstmsPckTpConvVO>();

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String chkPckTpCd = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String frmPckTpCd = null;

    /* Column Info */
    private String chkCntCd = null;

    /* Column Info */
    private String chkCstmsPckTpCd = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String pckCdDesc = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String cstmsPckTpCd = null;

    /* Column Info */
    private String cntCd = null;

    /* Column Info */
    private String userId = null;

    /* Column Info */
    private String frmCstmsPckTpCd = null;

    /* Column Info */
    private String frmCntCd = null;

    /* Column Info */
    private String pckTpCd = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String rcvrId = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public CstmsPckTpConvVO() {
    }

    public CstmsPckTpConvVO(String ibflag, String pagerows, String cntCd, String pckTpCd, String cstmsPckTpCd, String pckCdDesc, String creUsrId, String creDt, String updUsrId, String updDt, String userId, String frmCntCd, String frmPckTpCd, String frmCstmsPckTpCd, String chkCntCd, String chkPckTpCd, String chkCstmsPckTpCd, String rcvrId) {
        this.updDt = updDt;
        this.chkPckTpCd = chkPckTpCd;
        this.creDt = creDt;
        this.frmPckTpCd = frmPckTpCd;
        this.chkCntCd = chkCntCd;
        this.chkCstmsPckTpCd = chkCstmsPckTpCd;
        this.pagerows = pagerows;
        this.pckCdDesc = pckCdDesc;
        this.ibflag = ibflag;
        this.creUsrId = creUsrId;
        this.cstmsPckTpCd = cstmsPckTpCd;
        this.cntCd = cntCd;
        this.userId = userId;
        this.frmCstmsPckTpCd = frmCstmsPckTpCd;
        this.frmCntCd = frmCntCd;
        this.pckTpCd = pckTpCd;
        this.updUsrId = updUsrId;
        this.rcvrId = rcvrId;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("chk_pck_tp_cd", getChkPckTpCd());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("frm_pck_tp_cd", getFrmPckTpCd());
        this.hashColumns.put("chk_cnt_cd", getChkCntCd());
        this.hashColumns.put("chk_cstms_pck_tp_cd", getChkCstmsPckTpCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("pck_cd_desc", getPckCdDesc());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("cstms_pck_tp_cd", getCstmsPckTpCd());
        this.hashColumns.put("cnt_cd", getCntCd());
        this.hashColumns.put("user_id", getUserId());
        this.hashColumns.put("frm_cstms_pck_tp_cd", getFrmCstmsPckTpCd());
        this.hashColumns.put("frm_cnt_cd", getFrmCntCd());
        this.hashColumns.put("pck_tp_cd", getPckTpCd());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("rcvr_id", getRcvrId());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("chk_pck_tp_cd", "chkPckTpCd");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("frm_pck_tp_cd", "frmPckTpCd");
        this.hashFields.put("chk_cnt_cd", "chkCntCd");
        this.hashFields.put("chk_cstms_pck_tp_cd", "chkCstmsPckTpCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("pck_cd_desc", "pckCdDesc");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("cstms_pck_tp_cd", "cstmsPckTpCd");
        this.hashFields.put("cnt_cd", "cntCd");
        this.hashFields.put("user_id", "userId");
        this.hashFields.put("frm_cstms_pck_tp_cd", "frmCstmsPckTpCd");
        this.hashFields.put("frm_cnt_cd", "frmCntCd");
        this.hashFields.put("pck_tp_cd", "pckTpCd");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("rcvr_id", "rcvrId");
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
	 * @return chkPckTpCd
	 */
    public String getChkPckTpCd() {
        return this.chkPckTpCd;
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
	 * @return frmPckTpCd
	 */
    public String getFrmPckTpCd() {
        return this.frmPckTpCd;
    }

    /**
	 * Column Info
	 * @return chkCntCd
	 */
    public String getChkCntCd() {
        return this.chkCntCd;
    }

    /**
	 * Column Info
	 * @return chkCstmsPckTpCd
	 */
    public String getChkCstmsPckTpCd() {
        return this.chkCstmsPckTpCd;
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
	 * @return pckCdDesc
	 */
    public String getPckCdDesc() {
        return this.pckCdDesc;
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
	 * @return creUsrId
	 */
    public String getCreUsrId() {
        return this.creUsrId;
    }

    /**
	 * Column Info
	 * @return cstmsPckTpCd
	 */
    public String getCstmsPckTpCd() {
        return this.cstmsPckTpCd;
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
	 * @return userId
	 */
    public String getUserId() {
        return this.userId;
    }

    /**
	 * Column Info
	 * @return frmCstmsPckTpCd
	 */
    public String getFrmCstmsPckTpCd() {
        return this.frmCstmsPckTpCd;
    }

    /**
	 * Column Info
	 * @return frmCntCd
	 */
    public String getFrmCntCd() {
        return this.frmCntCd;
    }

    /**
	 * Column Info
	 * @return pckTpCd
	 */
    public String getPckTpCd() {
        return this.pckTpCd;
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
	 * @param updDt
	 */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    /**
	 * Column Info
	 * @param chkPckTpCd
	 */
    public void setChkPckTpCd(String chkPckTpCd) {
        this.chkPckTpCd = chkPckTpCd;
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
	 * @param frmPckTpCd
	 */
    public void setFrmPckTpCd(String frmPckTpCd) {
        this.frmPckTpCd = frmPckTpCd;
    }

    /**
	 * Column Info
	 * @param chkCntCd
	 */
    public void setChkCntCd(String chkCntCd) {
        this.chkCntCd = chkCntCd;
    }

    /**
	 * Column Info
	 * @param chkCstmsPckTpCd
	 */
    public void setChkCstmsPckTpCd(String chkCstmsPckTpCd) {
        this.chkCstmsPckTpCd = chkCstmsPckTpCd;
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
	 * @param pckCdDesc
	 */
    public void setPckCdDesc(String pckCdDesc) {
        this.pckCdDesc = pckCdDesc;
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
	 * @param creUsrId
	 */
    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
    }

    /**
	 * Column Info
	 * @param cstmsPckTpCd
	 */
    public void setCstmsPckTpCd(String cstmsPckTpCd) {
        this.cstmsPckTpCd = cstmsPckTpCd;
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
	 * @param userId
	 */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
	 * Column Info
	 * @param frmCstmsPckTpCd
	 */
    public void setFrmCstmsPckTpCd(String frmCstmsPckTpCd) {
        this.frmCstmsPckTpCd = frmCstmsPckTpCd;
    }

    /**
	 * Column Info
	 * @param frmCntCd
	 */
    public void setFrmCntCd(String frmCntCd) {
        this.frmCntCd = frmCntCd;
    }

    /**
	 * Column Info
	 * @param pckTpCd
	 */
    public void setPckTpCd(String pckTpCd) {
        this.pckTpCd = pckTpCd;
    }

    /**
	 * Column Info
	 * @param updUsrId
	 */
    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
    }

    public void setRcvrId(String rcvrId) {
        this.rcvrId = rcvrId;
    }

    public String getRcvrId() {
        return this.rcvrId;
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
        setChkPckTpCd(JSPUtil.getParameter(request, prefix + "chk_pck_tp_cd", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setFrmPckTpCd(JSPUtil.getParameter(request, prefix + "frm_pck_tp_cd", ""));
        setChkCntCd(JSPUtil.getParameter(request, prefix + "chk_cnt_cd", ""));
        setChkCstmsPckTpCd(JSPUtil.getParameter(request, prefix + "chk_cstms_pck_tp_cd", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setPckCdDesc(JSPUtil.getParameter(request, prefix + "pck_cd_desc", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setCstmsPckTpCd(JSPUtil.getParameter(request, prefix + "cstms_pck_tp_cd", ""));
        setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
        setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
        setFrmCstmsPckTpCd(JSPUtil.getParameter(request, prefix + "frm_cstms_pck_tp_cd", ""));
        setFrmCntCd(JSPUtil.getParameter(request, prefix + "frm_cnt_cd", ""));
        setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setRcvrId(JSPUtil.getParameter(request, prefix + "rcvr_id", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CstmsPckTpConvVO[]
	 */
    public CstmsPckTpConvVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CstmsPckTpConvVO[]
	 */
    public CstmsPckTpConvVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        CstmsPckTpConvVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] chkPckTpCd = (JSPUtil.getParameter(request, prefix + "chk_pck_tp_cd", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] frmPckTpCd = (JSPUtil.getParameter(request, prefix + "frm_pck_tp_cd", length));
            String[] chkCntCd = (JSPUtil.getParameter(request, prefix + "chk_cnt_cd", length));
            String[] chkCstmsPckTpCd = (JSPUtil.getParameter(request, prefix + "chk_cstms_pck_tp_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] pckCdDesc = (JSPUtil.getParameter(request, prefix + "pck_cd_desc", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] cstmsPckTpCd = (JSPUtil.getParameter(request, prefix + "cstms_pck_tp_cd", length));
            String[] cntCd = (JSPUtil.getParameter(request, prefix + "cnt_cd", length));
            String[] userId = (JSPUtil.getParameter(request, prefix + "user_id", length));
            String[] frmCstmsPckTpCd = (JSPUtil.getParameter(request, prefix + "frm_cstms_pck_tp_cd", length));
            String[] frmCntCd = (JSPUtil.getParameter(request, prefix + "frm_cnt_cd", length));
            String[] pckTpCd = (JSPUtil.getParameter(request, prefix + "pck_tp_cd", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] rcvrId = (JSPUtil.getParameter(request, prefix + "rcvr_id", length));
            for (int i = 0; i < length; i++) {
                model = new CstmsPckTpConvVO();
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (chkPckTpCd[i] != null)
                    model.setChkPckTpCd(chkPckTpCd[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (frmPckTpCd[i] != null)
                    model.setFrmPckTpCd(frmPckTpCd[i]);
                if (chkCntCd[i] != null)
                    model.setChkCntCd(chkCntCd[i]);
                if (chkCstmsPckTpCd[i] != null)
                    model.setChkCstmsPckTpCd(chkCstmsPckTpCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (pckCdDesc[i] != null)
                    model.setPckCdDesc(pckCdDesc[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (cstmsPckTpCd[i] != null)
                    model.setCstmsPckTpCd(cstmsPckTpCd[i]);
                if (cntCd[i] != null)
                    model.setCntCd(cntCd[i]);
                if (userId[i] != null)
                    model.setUserId(userId[i]);
                if (frmCstmsPckTpCd[i] != null)
                    model.setFrmCstmsPckTpCd(frmCstmsPckTpCd[i]);
                if (frmCntCd[i] != null)
                    model.setFrmCntCd(frmCntCd[i]);
                if (pckTpCd[i] != null)
                    model.setPckTpCd(pckTpCd[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (rcvrId[i] != null)
                    model.setRcvrId(rcvrId[i]);
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getCstmsPckTpConvVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return CstmsPckTpConvVO[]
	 */
    public CstmsPckTpConvVO[] getCstmsPckTpConvVOs() {
        CstmsPckTpConvVO[] vos = (CstmsPckTpConvVO[]) models.toArray(new CstmsPckTpConvVO[models.size()]);
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
        this.chkPckTpCd = this.chkPckTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.frmPckTpCd = this.frmPckTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chkCntCd = this.chkCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chkCstmsPckTpCd = this.chkCstmsPckTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pckCdDesc = this.pckCdDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cstmsPckTpCd = this.cstmsPckTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntCd = this.cntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.userId = this.userId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.frmCstmsPckTpCd = this.frmCstmsPckTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.frmCntCd = this.frmCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pckTpCd = this.pckTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcvrId = this.rcvrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
