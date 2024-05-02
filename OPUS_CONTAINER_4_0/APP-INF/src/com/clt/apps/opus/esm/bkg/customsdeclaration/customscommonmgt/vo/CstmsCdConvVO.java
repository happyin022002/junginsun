/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CstmsCdConvVO.java
*@FileTitle : CstmsCdConvVO
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
public class CstmsCdConvVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<CstmsCdConvVO> models = new ArrayList<CstmsCdConvVO>();

    /* Column Info */
    private String chkCnt = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String frmCstmsCdDesc = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String attrCtnt1 = null;

    /* Column Info */
    private String attrCtnt2 = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String frmCstmsDivId = null;

    /* Column Info */
    private String attrCtnt3 = null;

    /* Column Info */
    private String attrCtnt4 = null;

    /* Column Info */
    private String attrCtnt5 = null;

    /* Column Info */
    private String cntCd = null;

    /* Column Info */
    private String userId = null;

    /* Column Info */
    private String chkCstmsDivId = null;

    /* Column Info */
    private String frmCntCd = null;

    /* Column Info */
    private String cstmsDivIdSeq = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String attrNm4 = null;

    /* Column Info */
    private String attrNm5 = null;

    /* Column Info */
    private String chkCntCd = null;

    /* Column Info */
    private String attrNm1 = null;

    /* Column Info */
    private String attrNm2 = null;

    /* Column Info */
    private String attrNm3 = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String cstmsDivId = null;

    /* Column Info */
    private String cstmsCdDesc = null;

    /* Column Info */
    private String orderByCol = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public CstmsCdConvVO() {
    }

    public CstmsCdConvVO(String ibflag, String pagerows, String cntCd, String cstmsDivId, String cstmsCdDesc, String attrNm1, String attrNm2, String attrNm3, String attrNm4, String attrNm5, String cstmsDivIdSeq, String attrCtnt1, String attrCtnt2, String attrCtnt3, String attrCtnt4, String attrCtnt5, String creUsrId, String creDt, String updUsrId, String updDt, String userId, String frmCntCd, String frmCstmsDivId, String frmCstmsCdDesc, String chkCntCd, String chkCstmsDivId, String chkCnt, String orderByCol) {
        this.chkCnt = chkCnt;
        this.creDt = creDt;
        this.frmCstmsCdDesc = frmCstmsCdDesc;
        this.pagerows = pagerows;
        this.attrCtnt1 = attrCtnt1;
        this.attrCtnt2 = attrCtnt2;
        this.ibflag = ibflag;
        this.frmCstmsDivId = frmCstmsDivId;
        this.attrCtnt3 = attrCtnt3;
        this.attrCtnt4 = attrCtnt4;
        this.attrCtnt5 = attrCtnt5;
        this.cntCd = cntCd;
        this.userId = userId;
        this.chkCstmsDivId = chkCstmsDivId;
        this.frmCntCd = frmCntCd;
        this.cstmsDivIdSeq = cstmsDivIdSeq;
        this.updUsrId = updUsrId;
        this.updDt = updDt;
        this.attrNm4 = attrNm4;
        this.attrNm5 = attrNm5;
        this.chkCntCd = chkCntCd;
        this.attrNm1 = attrNm1;
        this.attrNm2 = attrNm2;
        this.attrNm3 = attrNm3;
        this.creUsrId = creUsrId;
        this.cstmsDivId = cstmsDivId;
        this.cstmsCdDesc = cstmsCdDesc;
        this.orderByCol = orderByCol;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("chk_cnt", getChkCnt());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("frm_cstms_cd_desc", getFrmCstmsCdDesc());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("attr_ctnt1", getAttrCtnt1());
        this.hashColumns.put("attr_ctnt2", getAttrCtnt2());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("frm_cstms_div_id", getFrmCstmsDivId());
        this.hashColumns.put("attr_ctnt3", getAttrCtnt3());
        this.hashColumns.put("attr_ctnt4", getAttrCtnt4());
        this.hashColumns.put("attr_ctnt5", getAttrCtnt5());
        this.hashColumns.put("cnt_cd", getCntCd());
        this.hashColumns.put("user_id", getUserId());
        this.hashColumns.put("chk_cstms_div_id", getChkCstmsDivId());
        this.hashColumns.put("frm_cnt_cd", getFrmCntCd());
        this.hashColumns.put("cstms_div_id_seq", getCstmsDivIdSeq());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("attr_nm4", getAttrNm4());
        this.hashColumns.put("attr_nm5", getAttrNm5());
        this.hashColumns.put("chk_cnt_cd", getChkCntCd());
        this.hashColumns.put("attr_nm1", getAttrNm1());
        this.hashColumns.put("attr_nm2", getAttrNm2());
        this.hashColumns.put("attr_nm3", getAttrNm3());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("cstms_div_id", getCstmsDivId());
        this.hashColumns.put("cstms_cd_desc", getCstmsCdDesc());
        this.hashColumns.put("order_by_col", getOrderByCol());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("chk_cnt", "chkCnt");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("frm_cstms_cd_desc", "frmCstmsCdDesc");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("attr_ctnt1", "attrCtnt1");
        this.hashFields.put("attr_ctnt2", "attrCtnt2");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("frm_cstms_div_id", "frmCstmsDivId");
        this.hashFields.put("attr_ctnt3", "attrCtnt3");
        this.hashFields.put("attr_ctnt4", "attrCtnt4");
        this.hashFields.put("attr_ctnt5", "attrCtnt5");
        this.hashFields.put("cnt_cd", "cntCd");
        this.hashFields.put("user_id", "userId");
        this.hashFields.put("chk_cstms_div_id", "chkCstmsDivId");
        this.hashFields.put("frm_cnt_cd", "frmCntCd");
        this.hashFields.put("cstms_div_id_seq", "cstmsDivIdSeq");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("attr_nm4", "attrNm4");
        this.hashFields.put("attr_nm5", "attrNm5");
        this.hashFields.put("chk_cnt_cd", "chkCntCd");
        this.hashFields.put("attr_nm1", "attrNm1");
        this.hashFields.put("attr_nm2", "attrNm2");
        this.hashFields.put("attr_nm3", "attrNm3");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("cstms_div_id", "cstmsDivId");
        this.hashFields.put("cstms_cd_desc", "cstmsCdDesc");
        this.hashFields.put("order_by_col", "orderByCol");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return chkCnt
	 */
    public String getChkCnt() {
        return this.chkCnt;
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
	 * @return frmCstmsCdDesc
	 */
    public String getFrmCstmsCdDesc() {
        return this.frmCstmsCdDesc;
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
	 * @return attrCtnt1
	 */
    public String getAttrCtnt1() {
        return this.attrCtnt1;
    }

    /**
	 * Column Info
	 * @return attrCtnt2
	 */
    public String getAttrCtnt2() {
        return this.attrCtnt2;
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
	 * @return frmCstmsDivId
	 */
    public String getFrmCstmsDivId() {
        return this.frmCstmsDivId;
    }

    /**
	 * Column Info
	 * @return attrCtnt3
	 */
    public String getAttrCtnt3() {
        return this.attrCtnt3;
    }

    /**
	 * Column Info
	 * @return attrCtnt4
	 */
    public String getAttrCtnt4() {
        return this.attrCtnt4;
    }

    /**
	 * Column Info
	 * @return attrCtnt5
	 */
    public String getAttrCtnt5() {
        return this.attrCtnt5;
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
	 * @return chkCstmsDivId
	 */
    public String getChkCstmsDivId() {
        return this.chkCstmsDivId;
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
	 * @return cstmsDivIdSeq
	 */
    public String getCstmsDivIdSeq() {
        return this.cstmsDivIdSeq;
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
	 * @return attrNm4
	 */
    public String getAttrNm4() {
        return this.attrNm4;
    }

    /**
	 * Column Info
	 * @return attrNm5
	 */
    public String getAttrNm5() {
        return this.attrNm5;
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
	 * @return attrNm1
	 */
    public String getAttrNm1() {
        return this.attrNm1;
    }

    /**
	 * Column Info
	 * @return attrNm2
	 */
    public String getAttrNm2() {
        return this.attrNm2;
    }

    /**
	 * Column Info
	 * @return attrNm3
	 */
    public String getAttrNm3() {
        return this.attrNm3;
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
	 * @return cstmsDivId
	 */
    public String getCstmsDivId() {
        return this.cstmsDivId;
    }

    /**
	 * Column Info
	 * @return cstmsCdDesc
	 */
    public String getCstmsCdDesc() {
        return this.cstmsCdDesc;
    }

    /**
	 * Column Info
	 * @param chkCnt
	 */
    public void setChkCnt(String chkCnt) {
        this.chkCnt = chkCnt;
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
	 * @param frmCstmsCdDesc
	 */
    public void setFrmCstmsCdDesc(String frmCstmsCdDesc) {
        this.frmCstmsCdDesc = frmCstmsCdDesc;
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
	 * @param attrCtnt1
	 */
    public void setAttrCtnt1(String attrCtnt1) {
        this.attrCtnt1 = attrCtnt1;
    }

    /**
	 * Column Info
	 * @param attrCtnt2
	 */
    public void setAttrCtnt2(String attrCtnt2) {
        this.attrCtnt2 = attrCtnt2;
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
	 * @param frmCstmsDivId
	 */
    public void setFrmCstmsDivId(String frmCstmsDivId) {
        this.frmCstmsDivId = frmCstmsDivId;
    }

    /**
	 * Column Info
	 * @param attrCtnt3
	 */
    public void setAttrCtnt3(String attrCtnt3) {
        this.attrCtnt3 = attrCtnt3;
    }

    /**
	 * Column Info
	 * @param attrCtnt4
	 */
    public void setAttrCtnt4(String attrCtnt4) {
        this.attrCtnt4 = attrCtnt4;
    }

    /**
	 * Column Info
	 * @param attrCtnt5
	 */
    public void setAttrCtnt5(String attrCtnt5) {
        this.attrCtnt5 = attrCtnt5;
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
	 * @param chkCstmsDivId
	 */
    public void setChkCstmsDivId(String chkCstmsDivId) {
        this.chkCstmsDivId = chkCstmsDivId;
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
	 * @param cstmsDivIdSeq
	 */
    public void setCstmsDivIdSeq(String cstmsDivIdSeq) {
        this.cstmsDivIdSeq = cstmsDivIdSeq;
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
	 * @param attrNm4
	 */
    public void setAttrNm4(String attrNm4) {
        this.attrNm4 = attrNm4;
    }

    /**
	 * Column Info
	 * @param attrNm5
	 */
    public void setAttrNm5(String attrNm5) {
        this.attrNm5 = attrNm5;
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
	 * @param attrNm1
	 */
    public void setAttrNm1(String attrNm1) {
        this.attrNm1 = attrNm1;
    }

    /**
	 * Column Info
	 * @param attrNm2
	 */
    public void setAttrNm2(String attrNm2) {
        this.attrNm2 = attrNm2;
    }

    /**
	 * Column Info
	 * @param attrNm3
	 */
    public void setAttrNm3(String attrNm3) {
        this.attrNm3 = attrNm3;
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
	 * @param cstmsDivId
	 */
    public void setCstmsDivId(String cstmsDivId) {
        this.cstmsDivId = cstmsDivId;
    }

    /**
	 * Column Info
	 * @param cstmsCdDesc
	 */
    public void setCstmsCdDesc(String cstmsCdDesc) {
        this.cstmsCdDesc = cstmsCdDesc;
    }

    public void setOrderByCol(String orderByCol) {
        this.orderByCol = orderByCol;
    }

    public String getOrderByCol() {
        return this.orderByCol;
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
        setChkCnt(JSPUtil.getParameter(request, prefix + "chk_cnt", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setFrmCstmsCdDesc(JSPUtil.getParameter(request, prefix + "frm_cstms_cd_desc", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setAttrCtnt1(JSPUtil.getParameter(request, prefix + "attr_ctnt1", ""));
        setAttrCtnt2(JSPUtil.getParameter(request, prefix + "attr_ctnt2", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setFrmCstmsDivId(JSPUtil.getParameter(request, prefix + "frm_cstms_div_id", ""));
        setAttrCtnt3(JSPUtil.getParameter(request, prefix + "attr_ctnt3", ""));
        setAttrCtnt4(JSPUtil.getParameter(request, prefix + "attr_ctnt4", ""));
        setAttrCtnt5(JSPUtil.getParameter(request, prefix + "attr_ctnt5", ""));
        setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
        setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
        setChkCstmsDivId(JSPUtil.getParameter(request, prefix + "chk_cstms_div_id", ""));
        setFrmCntCd(JSPUtil.getParameter(request, prefix + "frm_cnt_cd", ""));
        setCstmsDivIdSeq(JSPUtil.getParameter(request, prefix + "cstms_div_id_seq", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setAttrNm4(JSPUtil.getParameter(request, prefix + "attr_nm4", ""));
        setAttrNm5(JSPUtil.getParameter(request, prefix + "attr_nm5", ""));
        setChkCntCd(JSPUtil.getParameter(request, prefix + "chk_cnt_cd", ""));
        setAttrNm1(JSPUtil.getParameter(request, prefix + "attr_nm1", ""));
        setAttrNm2(JSPUtil.getParameter(request, prefix + "attr_nm2", ""));
        setAttrNm3(JSPUtil.getParameter(request, prefix + "attr_nm3", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setCstmsDivId(JSPUtil.getParameter(request, prefix + "cstms_div_id", ""));
        setCstmsCdDesc(JSPUtil.getParameter(request, prefix + "cstms_cd_desc", ""));
        setOrderByCol(JSPUtil.getParameter(request, prefix + "order_by_col", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CstmsCdConvVO[]
	 */
    public CstmsCdConvVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CstmsCdConvVO[]
	 */
    public CstmsCdConvVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        CstmsCdConvVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] chkCnt = (JSPUtil.getParameter(request, prefix + "chk_cnt", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] frmCstmsCdDesc = (JSPUtil.getParameter(request, prefix + "frm_cstms_cd_desc", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] attrCtnt1 = (JSPUtil.getParameter(request, prefix + "attr_ctnt1", length));
            String[] attrCtnt2 = (JSPUtil.getParameter(request, prefix + "attr_ctnt2", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] frmCstmsDivId = (JSPUtil.getParameter(request, prefix + "frm_cstms_div_id", length));
            String[] attrCtnt3 = (JSPUtil.getParameter(request, prefix + "attr_ctnt3", length));
            String[] attrCtnt4 = (JSPUtil.getParameter(request, prefix + "attr_ctnt4", length));
            String[] attrCtnt5 = (JSPUtil.getParameter(request, prefix + "attr_ctnt5", length));
            String[] cntCd = (JSPUtil.getParameter(request, prefix + "cnt_cd", length));
            String[] userId = (JSPUtil.getParameter(request, prefix + "user_id", length));
            String[] chkCstmsDivId = (JSPUtil.getParameter(request, prefix + "chk_cstms_div_id", length));
            String[] frmCntCd = (JSPUtil.getParameter(request, prefix + "frm_cnt_cd", length));
            String[] cstmsDivIdSeq = (JSPUtil.getParameter(request, prefix + "cstms_div_id_seq", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] attrNm4 = (JSPUtil.getParameter(request, prefix + "attr_nm4", length));
            String[] attrNm5 = (JSPUtil.getParameter(request, prefix + "attr_nm5", length));
            String[] chkCntCd = (JSPUtil.getParameter(request, prefix + "chk_cnt_cd", length));
            String[] attrNm1 = (JSPUtil.getParameter(request, prefix + "attr_nm1", length));
            String[] attrNm2 = (JSPUtil.getParameter(request, prefix + "attr_nm2", length));
            String[] attrNm3 = (JSPUtil.getParameter(request, prefix + "attr_nm3", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] cstmsDivId = (JSPUtil.getParameter(request, prefix + "cstms_div_id", length));
            String[] cstmsCdDesc = (JSPUtil.getParameter(request, prefix + "cstms_cd_desc", length));
            for (int i = 0; i < length; i++) {
                model = new CstmsCdConvVO();
                if (chkCnt[i] != null)
                    model.setChkCnt(chkCnt[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (frmCstmsCdDesc[i] != null)
                    model.setFrmCstmsCdDesc(frmCstmsCdDesc[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (attrCtnt1[i] != null)
                    model.setAttrCtnt1(attrCtnt1[i]);
                if (attrCtnt2[i] != null)
                    model.setAttrCtnt2(attrCtnt2[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (frmCstmsDivId[i] != null)
                    model.setFrmCstmsDivId(frmCstmsDivId[i]);
                if (attrCtnt3[i] != null)
                    model.setAttrCtnt3(attrCtnt3[i]);
                if (attrCtnt4[i] != null)
                    model.setAttrCtnt4(attrCtnt4[i]);
                if (attrCtnt5[i] != null)
                    model.setAttrCtnt5(attrCtnt5[i]);
                if (cntCd[i] != null)
                    model.setCntCd(cntCd[i]);
                if (userId[i] != null)
                    model.setUserId(userId[i]);
                if (chkCstmsDivId[i] != null)
                    model.setChkCstmsDivId(chkCstmsDivId[i]);
                if (frmCntCd[i] != null)
                    model.setFrmCntCd(frmCntCd[i]);
                if (cstmsDivIdSeq[i] != null)
                    model.setCstmsDivIdSeq(cstmsDivIdSeq[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (attrNm4[i] != null)
                    model.setAttrNm4(attrNm4[i]);
                if (attrNm5[i] != null)
                    model.setAttrNm5(attrNm5[i]);
                if (chkCntCd[i] != null)
                    model.setChkCntCd(chkCntCd[i]);
                if (attrNm1[i] != null)
                    model.setAttrNm1(attrNm1[i]);
                if (attrNm2[i] != null)
                    model.setAttrNm2(attrNm2[i]);
                if (attrNm3[i] != null)
                    model.setAttrNm3(attrNm3[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (cstmsDivId[i] != null)
                    model.setCstmsDivId(cstmsDivId[i]);
                if (cstmsCdDesc[i] != null)
                    model.setCstmsCdDesc(cstmsCdDesc[i]);
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getCstmsCdConvVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return CstmsCdConvVO[]
	 */
    public CstmsCdConvVO[] getCstmsCdConvVOs() {
        CstmsCdConvVO[] vos = (CstmsCdConvVO[]) models.toArray(new CstmsCdConvVO[models.size()]);
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
        this.chkCnt = this.chkCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.frmCstmsCdDesc = this.frmCstmsCdDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.attrCtnt1 = this.attrCtnt1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.attrCtnt2 = this.attrCtnt2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.frmCstmsDivId = this.frmCstmsDivId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.attrCtnt3 = this.attrCtnt3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.attrCtnt4 = this.attrCtnt4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.attrCtnt5 = this.attrCtnt5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntCd = this.cntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.userId = this.userId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chkCstmsDivId = this.chkCstmsDivId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.frmCntCd = this.frmCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cstmsDivIdSeq = this.cstmsDivIdSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.attrNm4 = this.attrNm4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.attrNm5 = this.attrNm5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chkCntCd = this.chkCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.attrNm1 = this.attrNm1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.attrNm2 = this.attrNm2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.attrNm3 = this.attrNm3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cstmsDivId = this.cstmsDivId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cstmsCdDesc = this.cstmsCdDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orderByCol = this.orderByCol.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
