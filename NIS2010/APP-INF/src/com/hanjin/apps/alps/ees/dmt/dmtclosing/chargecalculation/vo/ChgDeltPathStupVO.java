/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChgDeltPathStupVO.java
*@FileTitle : ChgDeltPathStupVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.27
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author  
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class ChgDeltPathStupVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<ChgDeltPathStupVO> models = new ArrayList<ChgDeltPathStupVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String chgDeltPathStupSeq = null;

    /* Column Info */
    private String chgDeltPathStupHisSeq = null;

    /* Column Info */
    private String effDt = null;

    /* Column Info */
    private String expDt = null;

    /* Column Info */
    private String chgDeltRhqCd = null;

    /* Column Info */
    private String chgDeltOfcCd = null;

    /* Column Info */
    private String dmdtBrncFlg = null;

    /* Column Info */
    private String dmdtRhqFlg = null;

    /* Column Info */
    private String dmdtHoFlg = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String creOfcCd = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String updOfcCd = null;

    /* Column Info */
    private String dmdtBrncOfcOpMgrFlg = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public ChgDeltPathStupVO() {
    }

    public ChgDeltPathStupVO(String ibflag, String pagerows, String chgDeltPathStupSeq, String chgDeltPathStupHisSeq, String effDt, String expDt, String chgDeltRhqCd, String chgDeltOfcCd, String dmdtBrncFlg, String dmdtRhqFlg, String dmdtHoFlg, String creUsrId, String creDt, String creOfcCd, String updUsrId, String updDt, String updOfcCd, String dmdtBrncOfcOpMgrFlg) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.chgDeltPathStupSeq = chgDeltPathStupSeq;
        this.chgDeltPathStupHisSeq = chgDeltPathStupHisSeq;
        this.effDt = effDt;
        this.expDt = expDt;
        this.chgDeltRhqCd = chgDeltRhqCd;
        this.chgDeltOfcCd = chgDeltOfcCd;
        this.dmdtBrncFlg = dmdtBrncFlg;
        this.dmdtRhqFlg = dmdtRhqFlg;
        this.dmdtHoFlg = dmdtHoFlg;
        this.creUsrId = creUsrId;
        this.creDt = creDt;
        this.creOfcCd = creOfcCd;
        this.updUsrId = updUsrId;
        this.updDt = updDt;
        this.updOfcCd = updOfcCd;
        this.dmdtBrncOfcOpMgrFlg = dmdtBrncOfcOpMgrFlg;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("chg_delt_path_stup_seq", getChgDeltPathStupSeq());
        this.hashColumns.put("chg_delt_path_stup_his_seq", getChgDeltPathStupHisSeq());
        this.hashColumns.put("eff_dt", getEffDt());
        this.hashColumns.put("exp_dt", getExpDt());
        this.hashColumns.put("chg_delt_rhq_cd", getChgDeltRhqCd());
        this.hashColumns.put("chg_delt_ofc_cd", getChgDeltOfcCd());
        this.hashColumns.put("dmdt_brnc_flg", getDmdtBrncFlg());
        this.hashColumns.put("dmdt_rhq_flg", getDmdtRhqFlg());
        this.hashColumns.put("dmdt_ho_flg", getDmdtHoFlg());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
        this.hashColumns.put("dmdt_brnc_ofc_op_mgr_flg", getDmdtBrncOfcOpMgrFlg());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("chg_delt_path_stup_seq", "chgDeltPathStupSeq");
        this.hashFields.put("chg_delt_path_stup_his_seq", "chgDeltPathStupHisSeq");
        this.hashFields.put("eff_dt", "effDt");
        this.hashFields.put("exp_dt", "expDt");
        this.hashFields.put("chg_delt_rhq_cd", "chgDeltRhqCd");
        this.hashFields.put("chg_delt_ofc_cd", "chgDeltOfcCd");
        this.hashFields.put("dmdt_brnc_flg", "dmdtBrncFlg");
        this.hashFields.put("dmdt_rhq_flg", "dmdtRhqFlg");
        this.hashFields.put("dmdt_ho_flg", "dmdtHoFlg");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("cre_ofc_cd", "creOfcCd");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("upd_ofc_cd", "updOfcCd");
        this.hashFields.put("dmdt_brnc_ofc_op_mgr_flg", "dmdtBrncOfcOpMgrFlg");
        return this.hashFields;
    }

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
	 * @return chgDeltPathStupSeq
	 */
    public String getChgDeltPathStupSeq() {
        return this.chgDeltPathStupSeq;
    }

    /**
	 * Column Info
	 * @return chgDeltPathStupHisSeq
	 */
    public String getChgDeltPathStupHisSeq() {
        return this.chgDeltPathStupHisSeq;
    }

    /**
	 * Column Info
	 * @return effDt
	 */
    public String getEffDt() {
        return this.effDt;
    }

    /**
	 * Column Info
	 * @return expDt
	 */
    public String getExpDt() {
        return this.expDt;
    }

    /**
	 * Column Info
	 * @return chgDeltRhqCd
	 */
    public String getChgDeltRhqCd() {
        return this.chgDeltRhqCd;
    }

    /**
	 * Column Info
	 * @return chgDeltOfcCd
	 */
    public String getChgDeltOfcCd() {
        return this.chgDeltOfcCd;
    }

    /**
	 * Column Info
	 * @return dmdtBrncFlg
	 */
    public String getDmdtBrncFlg() {
        return this.dmdtBrncFlg;
    }

    /**
	 * Column Info
	 * @return dmdtRhqFlg
	 */
    public String getDmdtRhqFlg() {
        return this.dmdtRhqFlg;
    }

    /**
	 * Column Info
	 * @return dmdtHoFlg
	 */
    public String getDmdtHoFlg() {
        return this.dmdtHoFlg;
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
	 * @return creDt
	 */
    public String getCreDt() {
        return this.creDt;
    }

    /**
	 * Column Info
	 * @return creOfcCd
	 */
    public String getCreOfcCd() {
        return this.creOfcCd;
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
	 * @return updDt
	 */
    public String getUpdDt() {
        return this.updDt;
    }

    /**
	 * Column Info
	 * @return updOfcCd
	 */
    public String getUpdOfcCd() {
        return this.updOfcCd;
    }

    /**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
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
	 * @param chgDeltPathStupSeq
	 */
    public void setChgDeltPathStupSeq(String chgDeltPathStupSeq) {
        this.chgDeltPathStupSeq = chgDeltPathStupSeq;
    }

    /**
	 * Column Info
	 * @param chgDeltPathStupHisSeq
	 */
    public void setChgDeltPathStupHisSeq(String chgDeltPathStupHisSeq) {
        this.chgDeltPathStupHisSeq = chgDeltPathStupHisSeq;
    }

    /**
	 * Column Info
	 * @param effDt
	 */
    public void setEffDt(String effDt) {
        this.effDt = effDt;
    }

    /**
	 * Column Info
	 * @param expDt
	 */
    public void setExpDt(String expDt) {
        this.expDt = expDt;
    }

    /**
	 * Column Info
	 * @param chgDeltRhqCd
	 */
    public void setChgDeltRhqCd(String chgDeltRhqCd) {
        this.chgDeltRhqCd = chgDeltRhqCd;
    }

    /**
	 * Column Info
	 * @param chgDeltOfcCd
	 */
    public void setChgDeltOfcCd(String chgDeltOfcCd) {
        this.chgDeltOfcCd = chgDeltOfcCd;
    }

    /**
	 * Column Info
	 * @param dmdtBrncFlg
	 */
    public void setDmdtBrncFlg(String dmdtBrncFlg) {
        this.dmdtBrncFlg = dmdtBrncFlg;
    }

    /**
	 * Column Info
	 * @param dmdtRhqFlg
	 */
    public void setDmdtRhqFlg(String dmdtRhqFlg) {
        this.dmdtRhqFlg = dmdtRhqFlg;
    }

    /**
	 * Column Info
	 * @param dmdtHoFlg
	 */
    public void setDmdtHoFlg(String dmdtHoFlg) {
        this.dmdtHoFlg = dmdtHoFlg;
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
	 * @param creDt
	 */
    public void setCreDt(String creDt) {
        this.creDt = creDt;
    }

    /**
	 * Column Info
	 * @param creOfcCd
	 */
    public void setCreOfcCd(String creOfcCd) {
        this.creOfcCd = creOfcCd;
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
	 * @param updDt
	 */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    /**
	 * Column Info
	 * @param updOfcCd
	 */
    public void setUpdOfcCd(String updOfcCd) {
        this.updOfcCd = updOfcCd;
    }

    public void setDmdtBrncOfcOpMgrFlg(String dmdtBrncOfcOpMgrFlg) {
        this.dmdtBrncOfcOpMgrFlg = dmdtBrncOfcOpMgrFlg;
    }

    public String getDmdtBrncOfcOpMgrFlg() {
        return this.dmdtBrncOfcOpMgrFlg;
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
        setChgDeltPathStupSeq(JSPUtil.getParameter(request, prefix + "chg_delt_path_stup_seq", ""));
        setChgDeltPathStupHisSeq(JSPUtil.getParameter(request, prefix + "chg_delt_path_stup_his_seq", ""));
        setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
        setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
        setChgDeltRhqCd(JSPUtil.getParameter(request, prefix + "chg_delt_rhq_cd", ""));
        setChgDeltOfcCd(JSPUtil.getParameter(request, prefix + "chg_delt_ofc_cd", ""));
        setDmdtBrncFlg(JSPUtil.getParameter(request, prefix + "dmdt_brnc_flg", ""));
        setDmdtRhqFlg(JSPUtil.getParameter(request, prefix + "dmdt_rhq_flg", ""));
        setDmdtHoFlg(JSPUtil.getParameter(request, prefix + "dmdt_ho_flg", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setUpdOfcCd(JSPUtil.getParameter(request, prefix + "upd_ofc_cd", ""));
        setDmdtBrncOfcOpMgrFlg(JSPUtil.getParameter(request, prefix + "dmdt_brnc_ofc_op_mgr_flg", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChgDeltPathStupVO[]
	 */
    public ChgDeltPathStupVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ChgDeltPathStupVO[]
	 */
    public ChgDeltPathStupVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        ChgDeltPathStupVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] chgDeltPathStupSeq = (JSPUtil.getParameter(request, prefix + "chg_delt_path_stup_seq", length));
            String[] chgDeltPathStupHisSeq = (JSPUtil.getParameter(request, prefix + "chg_delt_path_stup_his_seq", length));
            String[] effDt = (JSPUtil.getParameter(request, prefix + "eff_dt", length));
            String[] expDt = (JSPUtil.getParameter(request, prefix + "exp_dt", length));
            String[] chgDeltRhqCd = (JSPUtil.getParameter(request, prefix + "chg_delt_rhq_cd", length));
            String[] chgDeltOfcCd = (JSPUtil.getParameter(request, prefix + "chg_delt_ofc_cd", length));
            String[] dmdtBrncFlg = (JSPUtil.getParameter(request, prefix + "dmdt_brnc_flg", length));
            String[] dmdtRhqFlg = (JSPUtil.getParameter(request, prefix + "dmdt_rhq_flg", length));
            String[] dmdtHoFlg = (JSPUtil.getParameter(request, prefix + "dmdt_ho_flg", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] creOfcCd = (JSPUtil.getParameter(request, prefix + "cre_ofc_cd", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] updOfcCd = (JSPUtil.getParameter(request, prefix + "upd_ofc_cd", length));
            String[] dmdtBrncOfcOpMgrFlg = (JSPUtil.getParameter(request, prefix + "dmdt_brnc_ofc_op_mgr_flg", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new ChgDeltPathStupVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (chgDeltPathStupSeq[i] != null)
                    model.setChgDeltPathStupSeq(chgDeltPathStupSeq[i]);
                if (chgDeltPathStupHisSeq[i] != null)
                    model.setChgDeltPathStupHisSeq(chgDeltPathStupHisSeq[i]);
                if (effDt[i] != null)
                    model.setEffDt(effDt[i]);
                if (expDt[i] != null)
                    model.setExpDt(expDt[i]);
                if (chgDeltRhqCd[i] != null)
                    model.setChgDeltRhqCd(chgDeltRhqCd[i]);
                if (chgDeltOfcCd[i] != null)
                    model.setChgDeltOfcCd(chgDeltOfcCd[i]);
                if (dmdtBrncFlg[i] != null)
                    model.setDmdtBrncFlg(dmdtBrncFlg[i]);
                if (dmdtRhqFlg[i] != null)
                    model.setDmdtRhqFlg(dmdtRhqFlg[i]);
                if (dmdtHoFlg[i] != null)
                    model.setDmdtHoFlg(dmdtHoFlg[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (creOfcCd[i] != null)
                    model.setCreOfcCd(creOfcCd[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (updOfcCd[i] != null)
                    model.setUpdOfcCd(updOfcCd[i]);
                if (dmdtBrncOfcOpMgrFlg[i] != null) 
		    		model.setDmdtBrncOfcOpMgrFlg(dmdtBrncOfcOpMgrFlg[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getChgDeltPathStupVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return ChgDeltPathStupVO[]
	 */
    public ChgDeltPathStupVO[] getChgDeltPathStupVOs() {
        ChgDeltPathStupVO[] vos = (ChgDeltPathStupVO[]) models.toArray(new ChgDeltPathStupVO[models.size()]);
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
        this.chgDeltPathStupSeq = this.chgDeltPathStupSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chgDeltPathStupHisSeq = this.chgDeltPathStupHisSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.effDt = this.effDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.expDt = this.expDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chgDeltRhqCd = this.chgDeltRhqCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chgDeltOfcCd = this.chgDeltOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtBrncFlg = this.dmdtBrncFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtRhqFlg = this.dmdtRhqFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtHoFlg = this.dmdtHoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creOfcCd = this.creOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updOfcCd = this.updOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtBrncOfcOpMgrFlg = this.dmdtBrncOfcOpMgrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
