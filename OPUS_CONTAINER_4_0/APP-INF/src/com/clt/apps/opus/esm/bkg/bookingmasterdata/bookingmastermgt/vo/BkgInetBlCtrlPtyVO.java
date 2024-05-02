/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BkgInetBlCtrlPtyVO.java
*@FileTitle : BkgInetBlCtrlPtyVO
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
public class BkgInetBlCtrlPtyVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<BkgInetBlCtrlPtyVO> models = new ArrayList<BkgInetBlCtrlPtyVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String ctrlPtySeq = null;

    /* Column Info */
    private String custNm = null;

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
    private String updUsrId = null;

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String oldCustCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public BkgInetBlCtrlPtyVO() {
    }

    public BkgInetBlCtrlPtyVO(String ibflag, String pagerows, String ctrlPtySeq, String custSeq, String custCntCd, String custCd, String rowIdx, String custNm, String updUsrId, String updDt, String oldCustCd) {
        this.ibflag = ibflag;
        this.ctrlPtySeq = ctrlPtySeq;
        this.custNm = custNm;
        this.custCd = custCd;
        this.rowIdx = rowIdx;
        this.custSeq = custSeq;
        this.custCntCd = custCntCd;
        this.pagerows = pagerows;
        this.updUsrId = updUsrId;
        this.updDt = updDt;
        this.oldCustCd = oldCustCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("ctrl_pty_seq", getCtrlPtySeq());
        this.hashColumns.put("cust_nm", getCustNm());
        this.hashColumns.put("cust_cd", getCustCd());
        this.hashColumns.put("row_idx", getRowIdx());
        this.hashColumns.put("cust_seq", getCustSeq());
        this.hashColumns.put("cust_cnt_cd", getCustCntCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("old_cust_cd", getOldCustCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("ctrl_pty_seq", "ctrlPtySeq");
        this.hashFields.put("cust_nm", "custNm");
        this.hashFields.put("cust_cd", "custCd");
        this.hashFields.put("row_idx", "rowIdx");
        this.hashFields.put("cust_seq", "custSeq");
        this.hashFields.put("cust_cnt_cd", "custCntCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("upd_dt", "updDt");
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
	 * @return ctrlPtySeq
	 */
    public String getCtrlPtySeq() {
        return this.ctrlPtySeq;
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
	 * @param ctrlPtySeq
	 */
    public void setCtrlPtySeq(String ctrlPtySeq) {
        this.ctrlPtySeq = ctrlPtySeq;
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
        setCtrlPtySeq(JSPUtil.getParameter(request, prefix + "ctrl_pty_seq", ""));
        setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
        setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
        setRowIdx(JSPUtil.getParameter(request, prefix + "row_idx", ""));
        setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
        setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setOldCustCd(JSPUtil.getParameter(request, prefix + "old_cust_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgInetBlCtrlPtyVO[]
	 */
    public BkgInetBlCtrlPtyVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgInetBlCtrlPtyVO[]
	 */
    public BkgInetBlCtrlPtyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        BkgInetBlCtrlPtyVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] ctrlPtySeq = (JSPUtil.getParameter(request, prefix + "ctrl_pty_seq", length));
            String[] custNm = (JSPUtil.getParameter(request, prefix + "cust_nm", length));
            String[] custCd = (JSPUtil.getParameter(request, prefix + "cust_cd", length));
            String[] rowIdx = (JSPUtil.getParameter(request, prefix + "row_idx", length));
            String[] custSeq = (JSPUtil.getParameter(request, prefix + "cust_seq", length));
            String[] custCntCd = (JSPUtil.getParameter(request, prefix + "cust_cnt_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] oldCustCd = (JSPUtil.getParameter(request, prefix + "old_cust_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new BkgInetBlCtrlPtyVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (ctrlPtySeq[i] != null)
                    model.setCtrlPtySeq(ctrlPtySeq[i]);
                if (custNm[i] != null)
                    model.setCustNm(custNm[i]);
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
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (oldCustCd[i] != null) 
		    		model.setOldCustCd(oldCustCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getBkgInetBlCtrlPtyVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return BkgInetBlCtrlPtyVO[]
	 */
    public BkgInetBlCtrlPtyVO[] getBkgInetBlCtrlPtyVOs() {
        BkgInetBlCtrlPtyVO[] vos = (BkgInetBlCtrlPtyVO[]) models.toArray(new BkgInetBlCtrlPtyVO[models.size()]);
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
        this.custNm = this.custNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCd = this.custCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rowIdx = this.rowIdx.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custSeq = this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCntCd = this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oldCustCd = this.oldCustCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
