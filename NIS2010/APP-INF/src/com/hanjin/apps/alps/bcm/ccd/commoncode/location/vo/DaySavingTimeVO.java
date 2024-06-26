/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DaySavingTimeVO.java
*@FileTitle : DaySavingTimeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.07
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.07  
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class DaySavingTimeVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<DaySavingTimeVO> models = new ArrayList<DaySavingTimeVO>();

    /* Column Info */
    private String dstCntCd = null;

    /* Column Info */
    private String endDstDt = null;

    /* Column Info */
    private String deltFlg = null;

    /* Column Info */
    private String stDstRuleDesc = null;

    /* Column Info */
    private String endDstRuleDesc = null;

    /* Column Info */
    private String endDstHrmnt = null;

    /* Column Info */
    private String dstYr = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String stDstDt = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String stDstHrmnt = null;

    /* Column Info */
    private String dstId = null;

    /* Column Info */
    private String usrId = null;

    /* Column Info */
    private String dstMnts = null;

    /* Column Info */
    private String dstNotAplySteCd = null;

    /* Column Info */
    private String steNm = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public DaySavingTimeVO() {
    }

    public DaySavingTimeVO(String ibflag, String pagerows, String dstId, String dstCntCd, String dstNotAplySteCd, String dstYr, String dstMnts, String stDstRuleDesc, String endDstRuleDesc, String stDstDt, String endDstDt, String stDstHrmnt, String endDstHrmnt, String deltFlg, String usrId, String steNm) {
        this.dstCntCd = dstCntCd;
        this.endDstDt = endDstDt;
        this.deltFlg = deltFlg;
        this.stDstRuleDesc = stDstRuleDesc;
        this.endDstRuleDesc = endDstRuleDesc;
        this.endDstHrmnt = endDstHrmnt;
        this.dstYr = dstYr;
        this.pagerows = pagerows;
        this.stDstDt = stDstDt;
        this.ibflag = ibflag;
        this.stDstHrmnt = stDstHrmnt;
        this.dstId = dstId;
        this.usrId = usrId;
        this.dstMnts = dstMnts;
        this.dstNotAplySteCd = dstNotAplySteCd;
        this.steNm = steNm;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("dst_cnt_cd", getDstCntCd());
        this.hashColumns.put("end_dst_dt", getEndDstDt());
        this.hashColumns.put("delt_flg", getDeltFlg());
        this.hashColumns.put("st_dst_rule_desc", getStDstRuleDesc());
        this.hashColumns.put("end_dst_rule_desc", getEndDstRuleDesc());
        this.hashColumns.put("end_dst_hrmnt", getEndDstHrmnt());
        this.hashColumns.put("dst_yr", getDstYr());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("st_dst_dt", getStDstDt());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("st_dst_hrmnt", getStDstHrmnt());
        this.hashColumns.put("dst_id", getDstId());
        this.hashColumns.put("usr_id", getUsrId());
        this.hashColumns.put("dst_mnts", getDstMnts());
        this.hashColumns.put("dst_not_aply_ste_cd", getDstNotAplySteCd());
        this.hashColumns.put("ste_nm", getSteNm());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("dst_cnt_cd", "dstCntCd");
        this.hashFields.put("end_dst_dt", "endDstDt");
        this.hashFields.put("delt_flg", "deltFlg");
        this.hashFields.put("st_dst_rule_desc", "stDstRuleDesc");
        this.hashFields.put("end_dst_rule_desc", "endDstRuleDesc");
        this.hashFields.put("end_dst_hrmnt", "endDstHrmnt");
        this.hashFields.put("dst_yr", "dstYr");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("st_dst_dt", "stDstDt");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("st_dst_hrmnt", "stDstHrmnt");
        this.hashFields.put("dst_id", "dstId");
        this.hashFields.put("usr_id", "usrId");
        this.hashFields.put("dst_mnts", "dstMnts");
        this.hashFields.put("dst_not_aply_ste_cd", "dstNotAplySteCd");
        this.hashFields.put("ste_nm", "steNm");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return dstCntCd
	 */
    public String getDstCntCd() {
        return this.dstCntCd;
    }

    /**
	 * Column Info
	 * @return endDstDt
	 */
    public String getEndDstDt() {
        return this.endDstDt;
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
	 * @return stDstRuleDesc
	 */
    public String getStDstRuleDesc() {
        return this.stDstRuleDesc;
    }

    /**
	 * Column Info
	 * @return endDstRuleDesc
	 */
    public String getEndDstRuleDesc() {
        return this.endDstRuleDesc;
    }

    /**
	 * Column Info
	 * @return endDstHrmnt
	 */
    public String getEndDstHrmnt() {
        return this.endDstHrmnt;
    }

    /**
	 * Column Info
	 * @return dstYr
	 */
    public String getDstYr() {
        return this.dstYr;
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
	 * @return stDstDt
	 */
    public String getStDstDt() {
        return this.stDstDt;
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
	 * @return stDstHrmnt
	 */
    public String getStDstHrmnt() {
        return this.stDstHrmnt;
    }

    /**
	 * Column Info
	 * @return dstId
	 */
    public String getDstId() {
        return this.dstId;
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
	 * @return dstMnts
	 */
    public String getDstMnts() {
        return this.dstMnts;
    }

    /**
	 * Column Info
	 * @return dstNotAplySteCd
	 */
    public String getDstNotAplySteCd() {
        return this.dstNotAplySteCd;
    }

    /**
	 * Column Info
	 * @param dstCntCd
	 */
    public void setDstCntCd(String dstCntCd) {
        this.dstCntCd = dstCntCd;
    }

    /**
	 * Column Info
	 * @param endDstDt
	 */
    public void setEndDstDt(String endDstDt) {
        this.endDstDt = endDstDt;
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
	 * @param stDstRuleDesc
	 */
    public void setStDstRuleDesc(String stDstRuleDesc) {
        this.stDstRuleDesc = stDstRuleDesc;
    }

    /**
	 * Column Info
	 * @param endDstRuleDesc
	 */
    public void setEndDstRuleDesc(String endDstRuleDesc) {
        this.endDstRuleDesc = endDstRuleDesc;
    }

    /**
	 * Column Info
	 * @param endDstHrmnt
	 */
    public void setEndDstHrmnt(String endDstHrmnt) {
        this.endDstHrmnt = endDstHrmnt;
    }

    /**
	 * Column Info
	 * @param dstYr
	 */
    public void setDstYr(String dstYr) {
        this.dstYr = dstYr;
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
	 * @param stDstDt
	 */
    public void setStDstDt(String stDstDt) {
        this.stDstDt = stDstDt;
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
	 * @param stDstHrmnt
	 */
    public void setStDstHrmnt(String stDstHrmnt) {
        this.stDstHrmnt = stDstHrmnt;
    }

    /**
	 * Column Info
	 * @param dstId
	 */
    public void setDstId(String dstId) {
        this.dstId = dstId;
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
	 * @param dstMnts
	 */
    public void setDstMnts(String dstMnts) {
        this.dstMnts = dstMnts;
    }

    /**
	 * Column Info
	 * @param dstNotAplySteCd
	 */
    public void setDstNotAplySteCd(String dstNotAplySteCd) {
        this.dstNotAplySteCd = dstNotAplySteCd;
    }

    public void setSteNm(String steNm) {
        this.steNm = steNm;
    }

    public String getSteNm() {
        return this.steNm;
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
        setDstCntCd(JSPUtil.getParameter(request, prefix + "dst_cnt_cd", ""));
        setEndDstDt(JSPUtil.getParameter(request, prefix + "end_dst_dt", ""));
        setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
        setStDstRuleDesc(JSPUtil.getParameter(request, prefix + "st_dst_rule_desc", ""));
        setEndDstRuleDesc(JSPUtil.getParameter(request, prefix + "end_dst_rule_desc", ""));
        setEndDstHrmnt(JSPUtil.getParameter(request, prefix + "end_dst_hrmnt", ""));
        setDstYr(JSPUtil.getParameter(request, prefix + "dst_yr", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setStDstDt(JSPUtil.getParameter(request, prefix + "st_dst_dt", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setStDstHrmnt(JSPUtil.getParameter(request, prefix + "st_dst_hrmnt", ""));
        setDstId(JSPUtil.getParameter(request, prefix + "dst_id", ""));
        setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
        setDstMnts(JSPUtil.getParameter(request, prefix + "dst_mnts", ""));
        setDstNotAplySteCd(JSPUtil.getParameter(request, prefix + "dst_not_aply_ste_cd", ""));
        setSteNm(JSPUtil.getParameter(request, prefix + "ste_nm", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DaySavingTimeVO[]
	 */
    public DaySavingTimeVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DaySavingTimeVO[]
	 */
    public DaySavingTimeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        DaySavingTimeVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] dstCntCd = (JSPUtil.getParameter(request, prefix + "dst_cnt_cd", length));
            String[] endDstDt = (JSPUtil.getParameter(request, prefix + "end_dst_dt", length));
            String[] deltFlg = (JSPUtil.getParameter(request, prefix + "delt_flg", length));
            String[] stDstRuleDesc = (JSPUtil.getParameter(request, prefix + "st_dst_rule_desc", length));
            String[] endDstRuleDesc = (JSPUtil.getParameter(request, prefix + "end_dst_rule_desc", length));
            String[] endDstHrmnt = (JSPUtil.getParameter(request, prefix + "end_dst_hrmnt", length));
            String[] dstYr = (JSPUtil.getParameter(request, prefix + "dst_yr", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] stDstDt = (JSPUtil.getParameter(request, prefix + "st_dst_dt", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] stDstHrmnt = (JSPUtil.getParameter(request, prefix + "st_dst_hrmnt", length));
            String[] dstId = (JSPUtil.getParameter(request, prefix + "dst_id", length));
            String[] usrId = (JSPUtil.getParameter(request, prefix + "usr_id", length));
            String[] dstMnts = (JSPUtil.getParameter(request, prefix + "dst_mnts", length));
            String[] dstNotAplySteCd = (JSPUtil.getParameter(request, prefix + "dst_not_aply_ste_cd", length));
            String[] steNm = (JSPUtil.getParameter(request, prefix + "ste_nm", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new DaySavingTimeVO();
                if (dstCntCd[i] != null)
                    model.setDstCntCd(dstCntCd[i]);
                if (endDstDt[i] != null)
                    model.setEndDstDt(endDstDt[i]);
                if (deltFlg[i] != null)
                    model.setDeltFlg(deltFlg[i]);
                if (stDstRuleDesc[i] != null)
                    model.setStDstRuleDesc(stDstRuleDesc[i]);
                if (endDstRuleDesc[i] != null)
                    model.setEndDstRuleDesc(endDstRuleDesc[i]);
                if (endDstHrmnt[i] != null)
                    model.setEndDstHrmnt(endDstHrmnt[i]);
                if (dstYr[i] != null)
                    model.setDstYr(dstYr[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (stDstDt[i] != null)
                    model.setStDstDt(stDstDt[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (stDstHrmnt[i] != null)
                    model.setStDstHrmnt(stDstHrmnt[i]);
                if (dstId[i] != null)
                    model.setDstId(dstId[i]);
                if (usrId[i] != null)
                    model.setUsrId(usrId[i]);
                if (dstMnts[i] != null)
                    model.setDstMnts(dstMnts[i]);
                if (dstNotAplySteCd[i] != null)
                    model.setDstNotAplySteCd(dstNotAplySteCd[i]);
                if (steNm[i] != null) 
		    		model.setSteNm(steNm[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getDaySavingTimeVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return DaySavingTimeVO[]
	 */
    public DaySavingTimeVO[] getDaySavingTimeVOs() {
        DaySavingTimeVO[] vos = (DaySavingTimeVO[]) models.toArray(new DaySavingTimeVO[models.size()]);
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
        this.dstCntCd = this.dstCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.endDstDt = this.endDstDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deltFlg = this.deltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stDstRuleDesc = this.stDstRuleDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.endDstRuleDesc = this.endDstRuleDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.endDstHrmnt = this.endDstHrmnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dstYr = this.dstYr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stDstDt = this.stDstDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stDstHrmnt = this.stDstHrmnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dstId = this.dstId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usrId = this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dstMnts = this.dstMnts.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dstNotAplySteCd = this.dstNotAplySteCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.steNm = this.steNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
