/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BkgCtrlBlGrpCustVO.java
*@FileTitle : BkgCtrlBlGrpCustVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.03
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.03  
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo;

import java.lang.reflect.Field;
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
public class BkgCtrlBlGrpCustVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<BkgCtrlBlGrpCustVO> models = new ArrayList<BkgCtrlBlGrpCustVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String custNm = null;

    /* Column Info */
    private String blGrpSeq = null;

    /* Column Info */
    private String custCd = null;

    /* Column Info */
    private String rowIdx = null;

    /* Column Info */
    private String custSeq = null;

    /* Column Info */
    private String custCntCd = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String oldBlGrpSeq = null;

    /* Column Info */
    private String oldCustCntCd = null;

    /* Column Info */
    private String oldCustCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public BkgCtrlBlGrpCustVO() {
    }

    public BkgCtrlBlGrpCustVO(String ibflag, String pagerows, String custNm, String blGrpSeq, String custCd, String custSeq, String custCntCd, String rowIdx, String creUsrId, String creDt, String updUsrId, String updDt, String oldBlGrpSeq, String oldCustCntCd, String oldCustCd) {
        this.ibflag = ibflag;
        this.custNm = custNm;
        this.blGrpSeq = blGrpSeq;
        this.custCd = custCd;
        this.rowIdx = rowIdx;
        this.custSeq = custSeq;
        this.custCntCd = custCntCd;
        this.pagerows = pagerows;
        this.creUsrId = creUsrId;
        this.creDt = creDt;
        this.updUsrId = updUsrId;
        this.updDt = updDt;
        this.oldBlGrpSeq = oldBlGrpSeq;
        this.oldCustCntCd = oldCustCntCd;
        this.oldCustCd = oldCustCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("cust_nm", getCustNm());
        this.hashColumns.put("bl_grp_seq", getBlGrpSeq());
        this.hashColumns.put("cust_cd", getCustCd());
        this.hashColumns.put("row_idx", getRowIdx());
        this.hashColumns.put("cust_seq", getCustSeq());
        this.hashColumns.put("cust_cnt_cd", getCustCntCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("old_bl_grp_seq", getOldBlGrpSeq());
        this.hashColumns.put("old_cust_cnt_cd", getOldCustCntCd());
        this.hashColumns.put("old_cust_cd", getOldCustCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("cust_nm", "custNm");
        this.hashFields.put("bl_grp_seq", "blGrpSeq");
        this.hashFields.put("cust_cd", "custCd");
        this.hashFields.put("row_idx", "rowIdx");
        this.hashFields.put("cust_seq", "custSeq");
        this.hashFields.put("cust_cnt_cd", "custCntCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("old_bl_grp_seq", "oldBlGrpSeq");
        this.hashFields.put("old_cust_cnt_cd", "oldCustCntCd");
        this.hashFields.put("old_cust_cd", "oldCustCd");
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
	 * Column Info
	 * @return custNm
	 */
    public String getCustNm() {
        return this.custNm;
    }

    /**
	 * Column Info
	 * @return blGrpSeq
	 */
    public String getBlGrpSeq() {
        return this.blGrpSeq;
    }

    /**
	 * Column Info
	 * @return custCd
	 */
    public String getCustCd() {
        return this.custCd;
    }

    /**
	 * Column Info
	 * @return rowIdx
	 */
    public String getRowIdx() {
        return this.rowIdx;
    }

    /**
	 * Column Info
	 * @return custSeq
	 */
    public String getCustSeq() {
        return this.custSeq;
    }

    /**
	 * Column Info
	 * @return custCntCd
	 */
    public String getCustCntCd() {
        return this.custCntCd;
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
	 * @param ibflag
	 */
    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
    }

    /**
	 * Column Info
	 * @param custNm
	 */
    public void setCustNm(String custNm) {
        this.custNm = custNm;
    }

    /**
	 * Column Info
	 * @param blGrpSeq
	 */
    public void setBlGrpSeq(String blGrpSeq) {
        this.blGrpSeq = blGrpSeq;
    }

    /**
	 * Column Info
	 * @param custCd
	 */
    public void setCustCd(String custCd) {
        this.custCd = custCd;
    }

    /**
	 * Column Info
	 * @param rowIdx
	 */
    public void setRowIdx(String rowIdx) {
        this.rowIdx = rowIdx;
    }

    /**
	 * Column Info
	 * @param custSeq
	 */
    public void setCustSeq(String custSeq) {
        this.custSeq = custSeq;
    }

    /**
	 * Column Info
	 * @param custCntCd
	 */
    public void setCustCntCd(String custCntCd) {
        this.custCntCd = custCntCd;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
    }

    public String getCreUsrId() {
        return this.creUsrId;
    }

    public void setCreDt(String creDt) {
        this.creDt = creDt;
    }

    public String getCreDt() {
        return this.creDt;
    }

    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
    }

    public String getUpdUsrId() {
        return this.updUsrId;
    }

    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    public String getUpdDt() {
        return this.updDt;
    }

    public void setOldBlGrpSeq(String oldBlGrpSeq) {
        this.oldBlGrpSeq = oldBlGrpSeq;
    }

    public String getOldBlGrpSeq() {
        return this.oldBlGrpSeq;
    }

    public void setOldCustCntCd(String oldCustCntCd) {
        this.oldCustCntCd = oldCustCntCd;
    }

    public String getOldCustCntCd() {
        return this.oldCustCntCd;
    }

    public void setOldCustCd(String oldCustCd) {
        this.oldCustCd = oldCustCd;
    }

    public String getOldCustCd() {
        return this.oldCustCd;
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
        setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
        setBlGrpSeq(JSPUtil.getParameter(request, prefix + "bl_grp_seq", ""));
        setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
        setRowIdx(JSPUtil.getParameter(request, prefix + "row_idx", ""));
        setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
        setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setOldBlGrpSeq(JSPUtil.getParameter(request, prefix + "old_bl_grp_seq", ""));
        setOldCustCntCd(JSPUtil.getParameter(request, prefix + "old_cust_cnt_cd", ""));
        setOldCustCd(JSPUtil.getParameter(request, prefix + "old_cust_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCtrlBlGrpCustVO[]
	 */
    public BkgCtrlBlGrpCustVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgCtrlBlGrpCustVO[]
	 */
    public BkgCtrlBlGrpCustVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        BkgCtrlBlGrpCustVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] custNm = (JSPUtil.getParameter(request, prefix + "cust_nm", length));
            String[] blGrpSeq = (JSPUtil.getParameter(request, prefix + "bl_grp_seq", length));
            String[] custCd = (JSPUtil.getParameter(request, prefix + "cust_cd", length));
            String[] rowIdx = (JSPUtil.getParameter(request, prefix + "row_idx", length));
            String[] custSeq = (JSPUtil.getParameter(request, prefix + "cust_seq", length));
            String[] custCntCd = (JSPUtil.getParameter(request, prefix + "cust_cnt_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] oldBlGrpSeq = (JSPUtil.getParameter(request, prefix + "old_bl_grp_seq", length));
            String[] oldCustCntCd = (JSPUtil.getParameter(request, prefix + "old_cust_cnt_cd", length));
            String[] oldCustCd = (JSPUtil.getParameter(request, prefix + "old_cust_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new BkgCtrlBlGrpCustVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (custNm[i] != null)
                    model.setCustNm(custNm[i]);
                if (blGrpSeq[i] != null)
                    model.setBlGrpSeq(blGrpSeq[i]);
                if (custCd[i] != null)
                    model.setCustCd(custCd[i]);
                if (rowIdx[i] != null)
                    model.setRowIdx(rowIdx[i]);
                if (custSeq[i] != null)
                    model.setCustSeq(custSeq[i]);
                if (custCntCd[i] != null)
                    model.setCustCntCd(custCntCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (oldBlGrpSeq[i] != null)
                    model.setOldBlGrpSeq(oldBlGrpSeq[i]);
                if (oldCustCntCd[i] != null)
                    model.setOldCustCntCd(oldCustCntCd[i]);
                if (oldCustCd[i] != null) 
		    		model.setOldCustCd(oldCustCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getBkgCtrlBlGrpCustVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return BkgCtrlBlGrpCustVO[]
	 */
    public BkgCtrlBlGrpCustVO[] getBkgCtrlBlGrpCustVOs() {
        BkgCtrlBlGrpCustVO[] vos = (BkgCtrlBlGrpCustVO[]) models.toArray(new BkgCtrlBlGrpCustVO[models.size()]);
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
        this.custNm = this.custNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blGrpSeq = this.blGrpSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCd = this.custCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rowIdx = this.rowIdx.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custSeq = this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCntCd = this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oldBlGrpSeq = this.oldBlGrpSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oldCustCntCd = this.oldCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oldCustCd = this.oldCustCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
