/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BkgCtrlPtyVO.java
*@FileTitle : BkgCtrlPtyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.31
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.31  
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
public class BkgCtrlPtyVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<BkgCtrlPtyVO> models = new ArrayList<BkgCtrlPtyVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String ctrlPtySeq = null;

    /* Column Info */
    private String ctrlPtyDesc = null;

    /* Column Info */
    private String ctrlPtyNm = null;

    /* Column Info */
    private String rowIdx = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String custCntCd = null;

    /* Column Info */
    private String custSeq = null;

    /* Column Info */
    private String blGrpNm = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public BkgCtrlPtyVO() {
    }

    public BkgCtrlPtyVO(String ibflag, String pagerows, String ctrlPtySeq, String ctrlPtyNm, String ctrlPtyDesc, String rowIdx, String updUsrId, String updDt, String custCntCd, String custSeq, String blGrpNm) {
        this.ibflag = ibflag;
        this.ctrlPtySeq = ctrlPtySeq;
        this.ctrlPtyDesc = ctrlPtyDesc;
        this.ctrlPtyNm = ctrlPtyNm;
        this.rowIdx = rowIdx;
        this.pagerows = pagerows;
        this.updUsrId = updUsrId;
        this.updDt = updDt;
        this.custCntCd = custCntCd;
        this.custSeq = custSeq;
        this.blGrpNm = blGrpNm;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("ctrl_pty_seq", getCtrlPtySeq());
        this.hashColumns.put("ctrl_pty_desc", getCtrlPtyDesc());
        this.hashColumns.put("ctrl_pty_nm", getCtrlPtyNm());
        this.hashColumns.put("row_idx", getRowIdx());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("cust_cnt_cd", getCustCntCd());
        this.hashColumns.put("cust_seq", getCustSeq());
        this.hashColumns.put("bl_grp_nm", getBlGrpNm());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("ctrl_pty_seq", "ctrlPtySeq");
        this.hashFields.put("ctrl_pty_desc", "ctrlPtyDesc");
        this.hashFields.put("ctrl_pty_nm", "ctrlPtyNm");
        this.hashFields.put("row_idx", "rowIdx");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("cust_cnt_cd", "custCntCd");
        this.hashFields.put("cust_seq", "custSeq");
        this.hashFields.put("bl_grp_nm", "blGrpNm");
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
	 * @return ctrlPtySeq
	 */
    public String getCtrlPtySeq() {
        return this.ctrlPtySeq;
    }

    /**
	 * Column Info
	 * @return ctrlPtyDesc
	 */
    public String getCtrlPtyDesc() {
        return this.ctrlPtyDesc;
    }

    /**
	 * Column Info
	 * @return ctrlPtyNm
	 */
    public String getCtrlPtyNm() {
        return this.ctrlPtyNm;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
    }

    /**
	 * Column Info
	 * @param ctrlPtySeq
	 */
    public void setCtrlPtySeq(String ctrlPtySeq) {
        this.ctrlPtySeq = ctrlPtySeq;
    }

    /**
	 * Column Info
	 * @param ctrlPtyDesc
	 */
    public void setCtrlPtyDesc(String ctrlPtyDesc) {
        this.ctrlPtyDesc = ctrlPtyDesc;
    }

    /**
	 * Column Info
	 * @param ctrlPtyNm
	 */
    public void setCtrlPtyNm(String ctrlPtyNm) {
        this.ctrlPtyNm = ctrlPtyNm;
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

    public void setBlGrpNm(String blGrpNm) {
        this.blGrpNm = blGrpNm;
    }

    public String getBlGrpNm() {
        return this.blGrpNm;
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
        setCtrlPtySeq(JSPUtil.getParameter(request, prefix + "ctrl_pty_seq", ""));
        setCtrlPtyDesc(JSPUtil.getParameter(request, prefix + "ctrl_pty_desc", ""));
        setCtrlPtyNm(JSPUtil.getParameter(request, prefix + "ctrl_pty_nm", ""));
        setRowIdx(JSPUtil.getParameter(request, prefix + "row_idx", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
        setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
        setBlGrpNm(JSPUtil.getParameter(request, prefix + "bl_grp_nm", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCtrlPtyVO[]
	 */
    public BkgCtrlPtyVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgCtrlPtyVO[]
	 */
    public BkgCtrlPtyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        BkgCtrlPtyVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] ctrlPtySeq = (JSPUtil.getParameter(request, prefix + "ctrl_pty_seq", length));
            String[] ctrlPtyDesc = (JSPUtil.getParameter(request, prefix + "ctrl_pty_desc", length));
            String[] ctrlPtyNm = (JSPUtil.getParameter(request, prefix + "ctrl_pty_nm", length));
            String[] rowIdx = (JSPUtil.getParameter(request, prefix + "row_idx", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] custCntCd = (JSPUtil.getParameter(request, prefix + "cust_cnt_cd", length));
            String[] custSeq = (JSPUtil.getParameter(request, prefix + "cust_seq", length));
            String[] blGrpNm = (JSPUtil.getParameter(request, prefix + "bl_grp_nm", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new BkgCtrlPtyVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (ctrlPtySeq[i] != null)
                    model.setCtrlPtySeq(ctrlPtySeq[i]);
                if (ctrlPtyDesc[i] != null)
                    model.setCtrlPtyDesc(ctrlPtyDesc[i]);
                if (ctrlPtyNm[i] != null)
                    model.setCtrlPtyNm(ctrlPtyNm[i]);
                if (rowIdx[i] != null)
                    model.setRowIdx(rowIdx[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (custCntCd[i] != null)
                    model.setCustCntCd(custCntCd[i]);
                if (custSeq[i] != null)
                    model.setCustSeq(custSeq[i]);
                if (blGrpNm[i] != null) 
		    		model.setBlGrpNm(blGrpNm[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getBkgCtrlPtyVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return BkgCtrlPtyVO[]
	 */
    public BkgCtrlPtyVO[] getBkgCtrlPtyVOs() {
        BkgCtrlPtyVO[] vos = (BkgCtrlPtyVO[]) models.toArray(new BkgCtrlPtyVO[models.size()]);
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
        this.ctrlPtySeq = this.ctrlPtySeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctrlPtyDesc = this.ctrlPtyDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctrlPtyNm = this.ctrlPtyNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rowIdx = this.rowIdx.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCntCd = this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custSeq = this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blGrpNm = this.blGrpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
