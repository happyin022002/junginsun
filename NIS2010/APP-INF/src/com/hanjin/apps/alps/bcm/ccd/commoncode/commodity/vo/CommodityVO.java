/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CommodityVO.java
*@FileTitle : CommodityVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.04
*@LastModifier : 조인영
*@LastVersion : 1.0
* 2011.03.04 조인영 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.commodity.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 조인영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class CommodityVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<CommodityVO> models = new ArrayList<CommodityVO>();

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String deltFlg = null;

    /* Column Info */
    private String fmcExpFlg = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String cmdtNm = null;

    /* Page Number */
    private String pagerows = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String cmdtCd = null;

    /* Column Info */
    private String repImdgLvlCd = null;

    /* Column Info */
    private String grpCmdtCd = null;

    /* Column Info */
    private String repCmdtCd = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String rqstNo = null;

    /* Column Info */
    private String modiCmdtCd = null;

    /* Column Info */
    private String euXptFlg = null;

    /* Column Info */
    private String chemFlg = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public CommodityVO() {
    }

    public CommodityVO(String ibflag, String pagerows, String cmdtCd, String cmdtNm, String repImdgLvlCd, String repCmdtCd, String grpCmdtCd, String fmcExpFlg, String creUsrId, String creDt, String updUsrId, String updDt, String deltFlg, String rqstNo, String modiCmdtCd, String euXptFlg, String chemFlg) {
        this.updDt = updDt;
        this.deltFlg = deltFlg;
        this.fmcExpFlg = fmcExpFlg;
        this.creDt = creDt;
        this.cmdtNm = cmdtNm;
        this.pagerows = pagerows;
        this.ibflag = ibflag;
        this.creUsrId = creUsrId;
        this.cmdtCd = cmdtCd;
        this.repImdgLvlCd = repImdgLvlCd;
        this.grpCmdtCd = grpCmdtCd;
        this.repCmdtCd = repCmdtCd;
        this.updUsrId = updUsrId;
        this.rqstNo = rqstNo;
        this.modiCmdtCd = modiCmdtCd;
        this.euXptFlg = euXptFlg;
        this.chemFlg = chemFlg;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("delt_flg", getDeltFlg());
        this.hashColumns.put("fmc_exp_flg", getFmcExpFlg());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("cmdt_nm", getCmdtNm());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("cmdt_cd", getCmdtCd());
        this.hashColumns.put("rep_imdg_lvl_cd", getRepImdgLvlCd());
        this.hashColumns.put("grp_cmdt_cd", getGrpCmdtCd());
        this.hashColumns.put("rep_cmdt_cd", getRepCmdtCd());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("rqst_no", getRqstNo());
        this.hashColumns.put("modi_cmdt_cd", getModiCmdtCd());
        this.hashColumns.put("eu_xpt_flg", getEuXptFlg());
        this.hashColumns.put("chem_flg", getChemFlg());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("delt_flg", "deltFlg");
        this.hashFields.put("fmc_exp_flg", "fmcExpFlg");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("cmdt_nm", "cmdtNm");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("cmdt_cd", "cmdtCd");
        this.hashFields.put("rep_imdg_lvl_cd", "repImdgLvlCd");
        this.hashFields.put("grp_cmdt_cd", "grpCmdtCd");
        this.hashFields.put("rep_cmdt_cd", "repCmdtCd");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("rqst_no", "rqstNo");
        this.hashFields.put("modi_cmdt_cd", "modiCmdtCd");
        this.hashFields.put("eu_xpt_flg", "euXptFlg");
        this.hashFields.put("chem_flg", "chemFlg");
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
	 * @return deltFlg
	 */
    public String getDeltFlg() {
        return this.deltFlg;
    }

    /**
	 * Column Info
	 * @return fmcExpFlg
	 */
    public String getFmcExpFlg() {
        return this.fmcExpFlg;
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
	 * @return cmdtNm
	 */
    public String getCmdtNm() {
        return this.cmdtNm;
    }

    /**
	 * Page Number
	 * @return pagerows
	 */
    public String getPagerows() {
        return this.pagerows;
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
	 * @return cmdtCd
	 */
    public String getCmdtCd() {
        return this.cmdtCd;
    }

    /**
	 * Column Info
	 * @return repImdgLvlCd
	 */
    public String getRepImdgLvlCd() {
        return this.repImdgLvlCd;
    }

    /**
	 * Column Info
	 * @return grpCmdtCd
	 */
    public String getGrpCmdtCd() {
        return this.grpCmdtCd;
    }

    /**
	 * Column Info
	 * @return repCmdtCd
	 */
    public String getRepCmdtCd() {
        return this.repCmdtCd;
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
	 * @return rqstNo
	 */
    public String getRqstNo() {
        return this.rqstNo;
    }

    /**
	 * Column Info
	 * @return modiCmdtCd
	 */
    public String getModiCmdtCd() {
        return this.modiCmdtCd;
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
	 * @param deltFlg
	 */
    public void setDeltFlg(String deltFlg) {
        this.deltFlg = deltFlg;
    }

    /**
	 * Column Info
	 * @param fmcExpFlg
	 */
    public void setFmcExpFlg(String fmcExpFlg) {
        this.fmcExpFlg = fmcExpFlg;
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
	 * @param cmdtNm
	 */
    public void setCmdtNm(String cmdtNm) {
        this.cmdtNm = cmdtNm;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
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
	 * @param cmdtCd
	 */
    public void setCmdtCd(String cmdtCd) {
        this.cmdtCd = cmdtCd;
    }

    /**
	 * Column Info
	 * @param repImdgLvlCd
	 */
    public void setRepImdgLvlCd(String repImdgLvlCd) {
        this.repImdgLvlCd = repImdgLvlCd;
    }

    /**
	 * Column Info
	 * @param grpCmdtCd
	 */
    public void setGrpCmdtCd(String grpCmdtCd) {
        this.grpCmdtCd = grpCmdtCd;
    }

    /**
	 * Column Info
	 * @param repCmdtCd
	 */
    public void setRepCmdtCd(String repCmdtCd) {
        this.repCmdtCd = repCmdtCd;
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
	 * @param rqstNo
	 */
    public void setRqstNo(String rqstNo) {
        this.rqstNo = rqstNo;
    }

    /**
	 * Column Info
	 * @param modiCmdtCd
	 */
    public void setModiCmdtCd(String modiCmdtCd) {
        this.modiCmdtCd = modiCmdtCd;
    }

    public String getEuXptFlg() {
        return euXptFlg;
    }

    public void setEuXptFlg(String euXptFlg) {
        this.euXptFlg = euXptFlg;
    }

    public void setChemFlg(String chemFlg) {
        this.chemFlg = chemFlg;
    }

    public String getChemFlg() {
        return this.chemFlg;
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
        setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
        setFmcExpFlg(JSPUtil.getParameter(request, prefix + "fmc_exp_flg", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
        setRepImdgLvlCd(JSPUtil.getParameter(request, prefix + "rep_imdg_lvl_cd", ""));
        setGrpCmdtCd(JSPUtil.getParameter(request, prefix + "grp_cmdt_cd", ""));
        setRepCmdtCd(JSPUtil.getParameter(request, prefix + "rep_cmdt_cd", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setRqstNo(JSPUtil.getParameter(request, prefix + "rqst_no", ""));
        setModiCmdtCd(JSPUtil.getParameter(request, prefix + "modi_cmdt_cd", ""));
        setEuXptFlg(JSPUtil.getParameter(request, prefix + "eu_xpt_flg", ""));
        setChemFlg(JSPUtil.getParameter(request, prefix + "chem_flg", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CommodityVO[]
	 */
    public CommodityVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CommodityVO[]
	 */
    public CommodityVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        CommodityVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] deltFlg = (JSPUtil.getParameter(request, prefix + "delt_flg", length));
            String[] fmcExpFlg = (JSPUtil.getParameter(request, prefix + "fmc_exp_flg", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] cmdtNm = (JSPUtil.getParameter(request, prefix + "cmdt_nm", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] cmdtCd = (JSPUtil.getParameter(request, prefix + "cmdt_cd", length));
            String[] repImdgLvlCd = (JSPUtil.getParameter(request, prefix + "rep_imdg_lvl_cd", length));
            String[] grpCmdtCd = (JSPUtil.getParameter(request, prefix + "grp_cmdt_cd", length));
            String[] repCmdtCd = (JSPUtil.getParameter(request, prefix + "rep_cmdt_cd", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] rqstNo = (JSPUtil.getParameter(request, prefix + "rqst_no", length));
            String[] modiCmdtCd = (JSPUtil.getParameter(request, prefix + "modi_cmdt_cd", length));
            String[] euXptFlg = (JSPUtil.getParameter(request, prefix + "eu_xpt_flg", length));
            String[] chemFlg = (JSPUtil.getParameter(request, prefix + "chem_flg", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new CommodityVO();
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (deltFlg[i] != null)
                    model.setDeltFlg(deltFlg[i]);
                if (fmcExpFlg[i] != null)
                    model.setFmcExpFlg(fmcExpFlg[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (cmdtNm[i] != null)
                    model.setCmdtNm(cmdtNm[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (cmdtCd[i] != null)
                    model.setCmdtCd(cmdtCd[i]);
                if (repImdgLvlCd[i] != null)
                    model.setRepImdgLvlCd(repImdgLvlCd[i]);
                if (grpCmdtCd[i] != null)
                    model.setGrpCmdtCd(grpCmdtCd[i]);
                if (repCmdtCd[i] != null)
                    model.setRepCmdtCd(repCmdtCd[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (rqstNo[i] != null)
                    model.setRqstNo(rqstNo[i]);
                if (modiCmdtCd[i] != null)
                    model.setModiCmdtCd(modiCmdtCd[i]);
                if (euXptFlg[i] != null)
                    model.setEuXptFlg(euXptFlg[i]);
                if (chemFlg[i] != null)
                    model.setChemFlg(chemFlg[i]);
                /* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getCommodityVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return CommodityVO[]
	 */
    public CommodityVO[] getCommodityVOs() {
        CommodityVO[] vos = (CommodityVO[]) models.toArray(new CommodityVO[models.size()]);
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
        this.deltFlg = this.deltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fmcExpFlg = this.fmcExpFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtNm = this.cmdtNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtCd = this.cmdtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.repImdgLvlCd = this.repImdgLvlCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.grpCmdtCd = this.grpCmdtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.repCmdtCd = this.repCmdtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstNo = this.rqstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.modiCmdtCd = this.modiCmdtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.euXptFlg = this.euXptFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chemFlg = this.chemFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
