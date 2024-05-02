/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : SearchScgAprovalAuthCdVO.java
 *@FileTitle : SearchScgAprovalAuthCdVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.02.02
 *@LastModifier : dongsoo
 *@LastVersion : 1.0
 * 2015.02.02 dongsoo 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo;

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
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author dongsoo
 * @since J2EE 1.6
 * @see	..
 */
public class SearchScgAprovalAuthCdVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<SearchScgAprovalAuthCdVO> models = new ArrayList<SearchScgAprovalAuthCdVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /*	Column Info	*/
    private String cgoSeq = null;

    /*	Column Info	*/
    private String bkgNo = null;

    /*	Column Info	*/
    private String spclCgoAuthCd = null;

    /*	Column Info	*/
    private String updFlg = null;

    /*	Column Info	*/
    private String vslPrePstCd = null;

    /*	Column Info	*/
    private String spclCgoAproRqstSeq = null;

    /*	Column Info	*/
    private String vslSeq = null;

    /* Column Info */
    private String ifRmk = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    /**	Constructor	*/
    public SearchScgAprovalAuthCdVO() {
    }

    public SearchScgAprovalAuthCdVO(String ibflag, String pagerows, String cgoSeq, String bkgNo, String spclCgoAuthCd, String updFlg, String vslPrePstCd, String spclCgoAproRqstSeq, String vslSeq, String ifRmk) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.cgoSeq = cgoSeq;
        this.bkgNo = bkgNo;
        this.spclCgoAuthCd = spclCgoAuthCd;
        this.updFlg = updFlg;
        this.vslPrePstCd = vslPrePstCd;
        this.spclCgoAproRqstSeq = spclCgoAproRqstSeq;
        this.vslSeq = vslSeq;
        this.ifRmk = ifRmk;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("cgo_seq", getCgoSeq());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("spcl_cgo_auth_cd", getSpclCgoAuthCd());
        this.hashColumns.put("upd_flg", getUpdFlg());
        this.hashColumns.put("vsl_pre_pst_cd", getVslPrePstCd());
        this.hashColumns.put("spcl_cgo_apro_rqst_seq", getSpclCgoAproRqstSeq());
        this.hashColumns.put("vsl_seq", getVslSeq());
        this.hashColumns.put("if_rmk", getIfRmk());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("cgo_seq", "cgoSeq");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("spcl_cgo_auth_cd", "spclCgoAuthCd");
        this.hashFields.put("upd_flg", "updFlg");
        this.hashFields.put("vsl_pre_pst_cd", "vslPrePstCd");
        this.hashFields.put("spcl_cgo_apro_rqst_seq", "spclCgoAproRqstSeq");
        this.hashFields.put("vsl_seq", "vslSeq");
        this.hashFields.put("if_rmk", "ifRmk");
        return this.hashFields;
    }

    //	Getters	and	Setters
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
	 * @return cgoSeq
	 */
    public String getCgoSeq() {
        return this.cgoSeq;
    }

    /**
	 * Column Info
	 * @return bkgNo
	 */
    public String getBkgNo() {
        return this.bkgNo;
    }

    /**
	 * Column Info
	 * @return spclCgoAuthCd
	 */
    public String getSpclCgoAuthCd() {
        return this.spclCgoAuthCd;
    }

    /**
	 * Column Info
	 * @return updFlg
	 */
    public String getUpdFlg() {
        return this.updFlg;
    }

    /**
	 * Column Info
	 * @return vslPrePstCd
	 */
    public String getVslPrePstCd() {
        return this.vslPrePstCd;
    }

    /**
	 * Column Info
	 * @return spclCgoAproRqstSeq
	 */
    public String getSpclCgoAproRqstSeq() {
        return this.spclCgoAproRqstSeq;
    }

    /**
	 * Column Info
	 * @return vslSeq
	 */
    public String getVslSeq() {
        return this.vslSeq;
    }

    /**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param  ibflag
 	 */
    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
    }

    /**
	 * Page Number
	 * @param  pagerows
 	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    /**
	 * Column Info
	 * @param  cgoSeq
 	 */
    public void setCgoSeq(String cgoSeq) {
        this.cgoSeq = cgoSeq;
    }

    /**
	 * Column Info
	 * @param  bkgNo
 	 */
    public void setBkgNo(String bkgNo) {
        this.bkgNo = bkgNo;
    }

    /**
	 * Column Info
	 * @param  spclCgoAuthCd
 	 */
    public void setSpclCgoAuthCd(String spclCgoAuthCd) {
        this.spclCgoAuthCd = spclCgoAuthCd;
    }

    /**
	 * Column Info
	 * @param  updFlg
 	 */
    public void setUpdFlg(String updFlg) {
        this.updFlg = updFlg;
    }

    /**
	 * Column Info
	 * @param  vslPrePstCd
 	 */
    public void setVslPrePstCd(String vslPrePstCd) {
        this.vslPrePstCd = vslPrePstCd;
    }

    /**
	 * Column Info
	 * @param  spclCgoAproRqstSeq
 	 */
    public void setSpclCgoAproRqstSeq(String spclCgoAproRqstSeq) {
        this.spclCgoAproRqstSeq = spclCgoAproRqstSeq;
    }

    /**
	 * Column Info
	 * @param  vslSeq
 	 */
    public void setVslSeq(String vslSeq) {
        this.vslSeq = vslSeq;
    }

    public void setIfRmk(String ifRmk) {
        this.ifRmk = ifRmk;
    }

    public String getIfRmk() {
        return this.ifRmk;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        fromRequest(request, "");
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request, String prefix) {
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setCgoSeq(JSPUtil.getParameter(request, prefix + "cgo_seq", ""));
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setSpclCgoAuthCd(JSPUtil.getParameter(request, prefix + "spcl_cgo_auth_cd", ""));
        setUpdFlg(JSPUtil.getParameter(request, prefix + "upd_flg", ""));
        setVslPrePstCd(JSPUtil.getParameter(request, prefix + "vsl_pre_pst_cd", ""));
        setSpclCgoAproRqstSeq(JSPUtil.getParameter(request, prefix + "spcl_cgo_apro_rqst_seq", ""));
        setVslSeq(JSPUtil.getParameter(request, prefix + "vsl_seq", ""));
        setIfRmk(JSPUtil.getParameter(request, prefix + "if_rmk", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchScgAprovalAuthCdVO[]
	 */
    public SearchScgAprovalAuthCdVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return SearchScgAprovalAuthCdVO[]
	 */
    public SearchScgAprovalAuthCdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        SearchScgAprovalAuthCdVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] cgoSeq = (JSPUtil.getParameter(request, prefix + "cgo_seq", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] spclCgoAuthCd = (JSPUtil.getParameter(request, prefix + "spcl_cgo_auth_cd", length));
            String[] updFlg = (JSPUtil.getParameter(request, prefix + "upd_flg", length));
            String[] vslPrePstCd = (JSPUtil.getParameter(request, prefix + "vsl_pre_pst_cd", length));
            String[] spclCgoAproRqstSeq = (JSPUtil.getParameter(request, prefix + "spcl_cgo_apro_rqst_seq", length));
            String[] vslSeq = (JSPUtil.getParameter(request, prefix + "vsl_seq", length));
            String[] ifRmk = (JSPUtil.getParameter(request, prefix + "if_rmk", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new SearchScgAprovalAuthCdVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (cgoSeq[i] != null)
                    model.setCgoSeq(cgoSeq[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (spclCgoAuthCd[i] != null)
                    model.setSpclCgoAuthCd(spclCgoAuthCd[i]);
                if (updFlg[i] != null)
                    model.setUpdFlg(updFlg[i]);
                if (vslPrePstCd[i] != null)
                    model.setVslPrePstCd(vslPrePstCd[i]);
                if (spclCgoAproRqstSeq[i] != null)
                    model.setSpclCgoAproRqstSeq(spclCgoAproRqstSeq[i]);
                if (vslSeq[i] != null)
                    model.setVslSeq(vslSeq[i]);
                if (ifRmk[i] != null) 
		    		model.setIfRmk(ifRmk[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getSearchScgAprovalAuthCdVOs();
    }

    /**
	 *  VO 배열을 반환
	 * @return SearchScgAprovalAuthCdVO[]
	 */
    public SearchScgAprovalAuthCdVO[] getSearchScgAprovalAuthCdVOs() {
        SearchScgAprovalAuthCdVO[] vos = (SearchScgAprovalAuthCdVO[]) models.toArray(new SearchScgAprovalAuthCdVO[models.size()]);
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
        this.cgoSeq = this.cgoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoAuthCd = this.spclCgoAuthCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updFlg = this.updFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslPrePstCd = this.vslPrePstCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoAproRqstSeq = this.spclCgoAproRqstSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslSeq = this.vslSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ifRmk = this.ifRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
