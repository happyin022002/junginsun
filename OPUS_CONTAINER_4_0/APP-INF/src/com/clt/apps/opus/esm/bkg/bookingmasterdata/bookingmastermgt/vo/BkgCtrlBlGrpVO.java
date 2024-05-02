/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BkgCtrlBlGrpVO.java
*@FileTitle : BkgCtrlBlGrpVO
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
public class BkgCtrlBlGrpVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<BkgCtrlBlGrpVO> models = new ArrayList<BkgCtrlBlGrpVO>();

    /* Column Info */
    private String blGrpDesc = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String blGrpSeq = null;

    /* Column Info */
    private String blGrpNm = null;

    /* Column Info */
    private String rowIdx = null;

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
    private String custCntCd = null;

    /* Column Info */
    private String custSeq = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public BkgCtrlBlGrpVO() {
    }

    public BkgCtrlBlGrpVO(String ibflag, String pagerows, String blGrpSeq, String blGrpNm, String blGrpDesc, String rowIdx, String creUsrId, String creDt, String updUsrId, String updDt, String custCntCd, String custSeq) {
        this.blGrpDesc = blGrpDesc;
        this.ibflag = ibflag;
        this.blGrpSeq = blGrpSeq;
        this.blGrpNm = blGrpNm;
        this.rowIdx = rowIdx;
        this.pagerows = pagerows;
        this.creUsrId = creUsrId;
        this.creDt = creDt;
        this.updUsrId = updUsrId;
        this.updDt = updDt;
        this.custCntCd = custCntCd;
        this.custSeq = custSeq;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("bl_grp_desc", getBlGrpDesc());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("bl_grp_seq", getBlGrpSeq());
        this.hashColumns.put("bl_grp_nm", getBlGrpNm());
        this.hashColumns.put("row_idx", getRowIdx());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("cust_cnt_cd", getCustCntCd());
        this.hashColumns.put("cust_seq", getCustSeq());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("bl_grp_desc", "blGrpDesc");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("bl_grp_seq", "blGrpSeq");
        this.hashFields.put("bl_grp_nm", "blGrpNm");
        this.hashFields.put("row_idx", "rowIdx");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("cust_cnt_cd", "custCntCd");
        this.hashFields.put("cust_seq", "custSeq");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return blGrpDesc
	 */
    public String getBlGrpDesc() {
        return this.blGrpDesc;
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
	 * @return blGrpSeq
	 */
    public String getBlGrpSeq() {
        return this.blGrpSeq;
    }

    /**
	 * Column Info
	 * @return blGrpNm
	 */
    public String getBlGrpNm() {
        return this.blGrpNm;
    }

    /**
	 * Column Info
	 * @return rowIdx
	 */
    public String getRowIdx() {
        return this.rowIdx;
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
	 * @param blGrpDesc
	 */
    public void setBlGrpDesc(String blGrpDesc) {
        this.blGrpDesc = blGrpDesc;
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
	 * @param blGrpSeq
	 */
    public void setBlGrpSeq(String blGrpSeq) {
        this.blGrpSeq = blGrpSeq;
    }

    /**
	 * Column Info
	 * @param blGrpNm
	 */
    public void setBlGrpNm(String blGrpNm) {
        this.blGrpNm = blGrpNm;
    }

    /**
	 * Column Info
	 * @param rowIdx
	 */
    public void setRowIdx(String rowIdx) {
        this.rowIdx = rowIdx;
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

    public void setCustCntCd(String custCntCd) {
        this.custCntCd = custCntCd;
    }

    public String getCustCntCd() {
        return this.custCntCd;
    }

    public void setCustSeq(String custSeq) {
        this.custSeq = custSeq;
    }

    public String getCustSeq() {
        return this.custSeq;
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
        setBlGrpDesc(JSPUtil.getParameter(request, prefix + "bl_grp_desc", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setBlGrpSeq(JSPUtil.getParameter(request, prefix + "bl_grp_seq", ""));
        setBlGrpNm(JSPUtil.getParameter(request, prefix + "bl_grp_nm", ""));
        setRowIdx(JSPUtil.getParameter(request, prefix + "row_idx", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
        setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCtrlBlGrpVO[]
	 */
    public BkgCtrlBlGrpVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgCtrlBlGrpVO[]
	 */
    public BkgCtrlBlGrpVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        BkgCtrlBlGrpVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] blGrpDesc = (JSPUtil.getParameter(request, prefix + "bl_grp_desc", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] blGrpSeq = (JSPUtil.getParameter(request, prefix + "bl_grp_seq", length));
            String[] blGrpNm = (JSPUtil.getParameter(request, prefix + "bl_grp_nm", length));
            String[] rowIdx = (JSPUtil.getParameter(request, prefix + "row_idx", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] custCntCd = (JSPUtil.getParameter(request, prefix + "cust_cnt_cd", length));
	    	String[] custSeq = (JSPUtil.getParameter(request, prefix + "cust_seq", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new BkgCtrlBlGrpVO();
                if (blGrpDesc[i] != null)
                    model.setBlGrpDesc(blGrpDesc[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (blGrpSeq[i] != null)
                    model.setBlGrpSeq(blGrpSeq[i]);
                if (blGrpNm[i] != null)
                    model.setBlGrpNm(blGrpNm[i]);
                if (rowIdx[i] != null)
                    model.setRowIdx(rowIdx[i]);
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
                if (custCntCd[i] != null) 
		    		model.setCustCntCd(custCntCd[i]);
				if (custSeq[i] != null) 
		    		model.setCustSeq(custSeq[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getBkgCtrlBlGrpVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return BkgCtrlBlGrpVO[]
	 */
    public BkgCtrlBlGrpVO[] getBkgCtrlBlGrpVOs() {
        BkgCtrlBlGrpVO[] vos = (BkgCtrlBlGrpVO[]) models.toArray(new BkgCtrlBlGrpVO[models.size()]);
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
        this.blGrpDesc = this.blGrpDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blGrpSeq = this.blGrpSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blGrpNm = this.blGrpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rowIdx = this.rowIdx.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCntCd = this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custSeq = this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
