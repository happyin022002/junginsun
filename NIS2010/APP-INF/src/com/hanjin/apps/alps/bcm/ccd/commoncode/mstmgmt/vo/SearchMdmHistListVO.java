/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : SearchMdmHistListVO.java
 *@FileTitle : SearchMdmHistListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2018.02.22
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2018.02.22  
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.vo;

import java.lang.reflect.Field;
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
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class SearchMdmHistListVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<SearchMdmHistListVO> models = new ArrayList<SearchMdmHistListVO>();

    /*	Column Info	*/
    private String office = null;

    /*	Column Info	*/
    private String gmtDt = null;

    /*	Column Info	*/
    private String corrNo = null;

    /*	Column Info	*/
    private String creDt = null;

    /*	Column Info	*/
    private String crntCtnt = null;

    /*	Column Info	*/
    private String preCtntOrg = null;

    /*	Column Info	*/
    private String crntCtntOrg = null;

    /*	Column Info	*/
    private String pagerows = null;

    /*	Column Info	*/
    private String ibflag = null;

    /*	Column Info	*/
    private String creUsrId = null;

    /*	Column Info	*/
    private String hisCateNm = null;

    /*	Column Info	*/
    private String hisDtlSeq = null;

    /*	Column Info	*/
    private String hisSeq = null;

    /*	Column Info	*/
    private String itemHdr = null;

    /*	Column Info	*/
    private String preCtnt = null;

    /* Column Info */
    private String tblNm = null;

    /* Column Info */
    private String mstKey = null;

    /* Column Info */
    private String colNm = null;

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String tblDpNm = null;

    /* Column Info */
    private String colDpNm = null;

    /* Column Info */
    private String usrNm = null;

    /* hashColumnInpo */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /* hashFildInpo	*/
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    /**	Constructor	*/
    public SearchMdmHistListVO() {
    }

    public SearchMdmHistListVO(String office, String gmtDt, String corrNo, String creDt, String crntCtnt, String preCtntOrg, String crntCtntOrg, String pagerows, String ibflag, String creUsrId, String hisCateNm, String hisDtlSeq, String hisSeq, String itemHdr, String preCtnt, String tblNm, String mstKey, String colNm, String updDt, String tblDpNm, String colDpNm, String usrNm) {
        this.office = office;
        this.gmtDt = gmtDt;
        this.corrNo = corrNo;
        this.creDt = creDt;
        this.crntCtnt = crntCtnt;
        this.preCtntOrg = preCtntOrg;
        this.crntCtntOrg = crntCtntOrg;
        this.pagerows = pagerows;
        this.ibflag = ibflag;
        this.creUsrId = creUsrId;
        this.hisCateNm = hisCateNm;
        this.hisDtlSeq = hisDtlSeq;
        this.hisSeq = hisSeq;
        this.itemHdr = itemHdr;
        this.preCtnt = preCtnt;
        this.tblNm = tblNm;
        this.mstKey = mstKey;
        this.colNm = colNm;
        this.updDt = updDt;
        this.tblDpNm = tblDpNm;
        this.colDpNm = colDpNm;
        this.usrNm = usrNm;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("office", getOffice());
        this.hashColumns.put("gmt_dt", getGmtDt());
        this.hashColumns.put("corr_no", getCorrNo());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("crnt_ctnt", getCrntCtnt());
        this.hashColumns.put("pre_ctnt_org", getPreCtntOrg());
        this.hashColumns.put("crnt_ctnt_org", getCrntCtntOrg());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("his_cate_nm", getHisCateNm());
        this.hashColumns.put("his_dtl_seq", getHisDtlSeq());
        this.hashColumns.put("his_seq", getHisSeq());
        this.hashColumns.put("item_hdr", getItemHdr());
        this.hashColumns.put("pre_ctnt", getPreCtnt());
        this.hashColumns.put("tbl_nm", getTblNm());
        this.hashColumns.put("mst_key", getMstKey());
        this.hashColumns.put("col_nm", getColNm());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("tbl_dp_nm", getTblDpNm());
        this.hashColumns.put("col_dp_nm", getColDpNm());
        this.hashColumns.put("usr_nm", getUsrNm());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("office", "office");
        this.hashFields.put("gmt_dt", "gmtDt");
        this.hashFields.put("corr_no", "corrNo");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("crnt_ctnt", "crntCtnt");
        this.hashFields.put("pre_ctnt_org", "preCtntOrg");
        this.hashFields.put("crnt_ctnt_org", "crntCtntOrg");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("his_cate_nm", "hisCateNm");
        this.hashFields.put("his_dtl_seq", "hisDtlSeq");
        this.hashFields.put("his_seq", "hisSeq");
        this.hashFields.put("item_hdr", "itemHdr");
        this.hashFields.put("pre_ctnt", "preCtnt");
        this.hashFields.put("tbl_nm", "tblNm");
        this.hashFields.put("mst_key", "mstKey");
        this.hashFields.put("col_nm", "colNm");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("tbl_dp_nm", "tblDpNm");
        this.hashFields.put("col_dp_nm", "colDpNm");
        this.hashFields.put("usr_nm", "usrNm");
        return this.hashFields;
    }

    //	Getters	and	Setters
    /**
	* Column Info
	* @param  office
	*/
    public void setOffice(String office) {
        this.office = office;
    }

    /**
	 * Column Info
	 * @return	office
	 */
    public String getOffice() {
        return this.office;
    }

    /**
	* Column Info
	* @param  gmtDt
	*/
    public void setGmtDt(String gmtDt) {
        this.gmtDt = gmtDt;
    }

    /**
	 * Column Info
	 * @return	gmtDt
	 */
    public String getGmtDt() {
        return this.gmtDt;
    }

    /**
	* Column Info
	* @param  corrNo
	*/
    public void setCorrNo(String corrNo) {
        this.corrNo = corrNo;
    }

    /**
	 * Column Info
	 * @return	corrNo
	 */
    public String getCorrNo() {
        return this.corrNo;
    }

    /**
	* Column Info
	* @param  creDt
	*/
    public void setCreDt(String creDt) {
        this.creDt = creDt;
    }

    /**
	 * Column Info
	 * @return	creDt
	 */
    public String getCreDt() {
        return this.creDt;
    }

    /**
	* Column Info
	* @param  crntCtnt
	*/
    public void setCrntCtnt(String crntCtnt) {
        this.crntCtnt = crntCtnt;
    }

    /**
	 * Column Info
	 * @return	crntCtnt
	 */
    public String getCrntCtnt() {
        return this.crntCtnt;
    }

    /**
	* Column Info
	* @param  preCtntOrg
	*/
    public void setPreCtntOrg(String preCtntOrg) {
        this.preCtntOrg = preCtntOrg;
    }

    /**
	 * Column Info
	 * @return	preCtntOrg
	 */
    public String getPreCtntOrg() {
        return this.preCtntOrg;
    }

    /**
	* Column Info
	* @param  crntCtntOrg
	*/
    public void setCrntCtntOrg(String crntCtntOrg) {
        this.crntCtntOrg = crntCtntOrg;
    }

    /**
	 * Column Info
	 * @return	crntCtntOrg
	 */
    public String getCrntCtntOrg() {
        return this.crntCtntOrg;
    }

    /**
	* Column Info
	* @param  pagerows
	*/
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    /**
	 * Column Info
	 * @return	pagerows
	 */
    public String getPagerows() {
        return this.pagerows;
    }

    /**
	* Column Info
	* @param  ibflag
	*/
    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
    }

    /**
	 * Column Info
	 * @return	ibflag
	 */
    public String getIbflag() {
        return this.ibflag;
    }

    /**
	* Column Info
	* @param  creUsrId
	*/
    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
    }

    /**
	 * Column Info
	 * @return	creUsrId
	 */
    public String getCreUsrId() {
        return this.creUsrId;
    }

    /**
	* Column Info
	* @param  hisCateNm
	*/
    public void setHisCateNm(String hisCateNm) {
        this.hisCateNm = hisCateNm;
    }

    /**
	 * Column Info
	 * @return	hisCateNm
	 */
    public String getHisCateNm() {
        return this.hisCateNm;
    }

    /**
	* Column Info
	* @param  hisDtlSeq
	*/
    public void setHisDtlSeq(String hisDtlSeq) {
        this.hisDtlSeq = hisDtlSeq;
    }

    /**
	 * Column Info
	 * @return	hisDtlSeq
	 */
    public String getHisDtlSeq() {
        return this.hisDtlSeq;
    }

    /**
	* Column Info
	* @param  hisSeq
	*/
    public void setHisSeq(String hisSeq) {
        this.hisSeq = hisSeq;
    }

    /**
	 * Column Info
	 * @return	hisSeq
	 */
    public String getHisSeq() {
        return this.hisSeq;
    }

    /**
	* Column Info
	* @param  itemHdr
	*/
    public void setItemHdr(String itemHdr) {
        this.itemHdr = itemHdr;
    }

    /**
	 * Column Info
	 * @return	itemHdr
	 */
    public String getItemHdr() {
        return this.itemHdr;
    }

    /**
	* Column Info
	* @param  preCtnt
	*/
    public void setPreCtnt(String preCtnt) {
        this.preCtnt = preCtnt;
    }

    /**
	 * Column Info
	 * @return	preCtnt
	 */
    public String getPreCtnt() {
        return this.preCtnt;
    }

    public void setTblNm(String tblNm) {
        this.tblNm = tblNm;
    }

    public String getTblNm() {
        return this.tblNm;
    }

    public void setMstKey(String mstKey) {
        this.mstKey = mstKey;
    }

    public String getMstKey() {
        return this.mstKey;
    }

    public void setColNm(String colNm) {
        this.colNm = colNm;
    }

    public String getColNm() {
        return this.colNm;
    }

    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    public String getUpdDt() {
        return this.updDt;
    }

    public void setTblDpNm(String tblDpNm) {
        this.tblDpNm = tblDpNm;
    }

    public String getTblDpNm() {
        return this.tblDpNm;
    }

    public void setColDpNm(String colDpNm) {
        this.colDpNm = colDpNm;
    }

    public String getColDpNm() {
        return this.colDpNm;
    }

    public void setUsrNm(String usrNm) {
        this.usrNm = usrNm;
    }

    public String getUsrNm() {
        return this.usrNm;
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
        setOffice(JSPUtil.getParameter(request, prefix + "office", ""));
        setGmtDt(JSPUtil.getParameter(request, prefix + "gmt_dt", ""));
        setCorrNo(JSPUtil.getParameter(request, prefix + "corr_no", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setCrntCtnt(JSPUtil.getParameter(request, prefix + "crnt_ctnt", ""));
        setPreCtntOrg(JSPUtil.getParameter(request, prefix + "pre_ctnt_org", ""));
        setCrntCtntOrg(JSPUtil.getParameter(request, prefix + "crnt_ctnt_org", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setHisCateNm(JSPUtil.getParameter(request, prefix + "his_cate_nm", ""));
        setHisDtlSeq(JSPUtil.getParameter(request, prefix + "his_dtl_seq", ""));
        setHisSeq(JSPUtil.getParameter(request, prefix + "his_seq", ""));
        setItemHdr(JSPUtil.getParameter(request, prefix + "item_hdr", ""));
        setPreCtnt(JSPUtil.getParameter(request, prefix + "pre_ctnt", ""));
        setTblNm(JSPUtil.getParameter(request, prefix + "tbl_nm", ""));
        setMstKey(JSPUtil.getParameter(request, prefix + "mst_key", ""));
        setColNm(JSPUtil.getParameter(request, prefix + "col_nm", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setTblDpNm(JSPUtil.getParameter(request, prefix + "tbl_dp_nm", ""));
        setColDpNm(JSPUtil.getParameter(request, prefix + "col_dp_nm", ""));
        setUsrNm(JSPUtil.getParameter(request, prefix + "usr_nm", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMdmHistListVO[]
	 */
    public SearchMdmHistListVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return SearchMdmHistListVO[]
	 */
    public SearchMdmHistListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        SearchMdmHistListVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] office = (JSPUtil.getParameter(request, prefix + "office".trim(), length));
            String[] gmtDt = (JSPUtil.getParameter(request, prefix + "gmt_dt".trim(), length));
            String[] corrNo = (JSPUtil.getParameter(request, prefix + "corr_no".trim(), length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt".trim(), length));
            String[] crntCtnt = (JSPUtil.getParameter(request, prefix + "crnt_ctnt".trim(), length));
            String[] preCtntOrg = (JSPUtil.getParameter(request, prefix + "pre_ctnt_org".trim(), length));
            String[] crntCtntOrg = (JSPUtil.getParameter(request, prefix + "crnt_ctnt_org".trim(), length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows".trim(), length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag".trim(), length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id".trim(), length));
            String[] hisCateNm = (JSPUtil.getParameter(request, prefix + "his_cate_nm".trim(), length));
            String[] hisDtlSeq = (JSPUtil.getParameter(request, prefix + "his_dtl_seq".trim(), length));
            String[] hisSeq = (JSPUtil.getParameter(request, prefix + "his_seq".trim(), length));
            String[] itemHdr = (JSPUtil.getParameter(request, prefix + "item_hdr".trim(), length));
            String[] preCtnt = (JSPUtil.getParameter(request, prefix + "pre_ctnt".trim(), length));
            String[] tblNm = (JSPUtil.getParameter(request, prefix + "tbl_nm".trim(), length));
            String[] mstKey = (JSPUtil.getParameter(request, prefix + "mst_key".trim(), length));
            String[] colNm = (JSPUtil.getParameter(request, prefix + "col_nm", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] tblDpNm = (JSPUtil.getParameter(request, prefix + "tbl_dp_nm", length));
            String[] colDpNm = (JSPUtil.getParameter(request, prefix + "col_dp_nm", length));
            String[] usrNm = (JSPUtil.getParameter(request, prefix + "usr_nm", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new SearchMdmHistListVO();
                if (office[i] != null)
                    model.setOffice(office[i]);
                if (gmtDt[i] != null)
                    model.setGmtDt(gmtDt[i]);
                if (corrNo[i] != null)
                    model.setCorrNo(corrNo[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (crntCtnt[i] != null)
                    model.setCrntCtnt(crntCtnt[i]);
                if (preCtntOrg[i] != null)
                    model.setPreCtntOrg(preCtntOrg[i]);
                if (crntCtntOrg[i] != null)
                    model.setCrntCtntOrg(crntCtntOrg[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (hisCateNm[i] != null)
                    model.setHisCateNm(hisCateNm[i]);
                if (hisDtlSeq[i] != null)
                    model.setHisDtlSeq(hisDtlSeq[i]);
                if (hisSeq[i] != null)
                    model.setHisSeq(hisSeq[i]);
                if (itemHdr[i] != null)
                    model.setItemHdr(itemHdr[i]);
                if (preCtnt[i] != null)
                    model.setPreCtnt(preCtnt[i]);
                if (tblNm[i] != null)
                    model.setTblNm(tblNm[i]);
                if (mstKey[i] != null)
                    model.setMstKey(mstKey[i]);
                if (colNm[i] != null)
                    model.setColNm(colNm[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (tblDpNm[i] != null)
                    model.setTblDpNm(tblDpNm[i]);
                if (colDpNm[i] != null)
                    model.setColDpNm(colDpNm[i]);
                if (usrNm[i] != null) 
		    		model.setUsrNm(usrNm[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getSearchMdmHistListVOs();
    }

    /**
	 *  VO 배열을 반환
	 * @return SearchMdmHistListVO[]
	 */
    public SearchMdmHistListVO[] getSearchMdmHistListVOs() {
        SearchMdmHistListVO[] vos = (SearchMdmHistListVO[]) models.toArray(new SearchMdmHistListVO[models.size()]);
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
        this.office = this.office.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.gmtDt = this.gmtDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.corrNo = this.corrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.crntCtnt = this.crntCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.preCtntOrg = this.preCtntOrg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.crntCtntOrg = this.crntCtntOrg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hisCateNm = this.hisCateNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hisDtlSeq = this.hisDtlSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hisSeq = this.hisSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.itemHdr = this.itemHdr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.preCtnt = this.preCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tblNm = this.tblNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mstKey = this.mstKey.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.colNm = this.colNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tblDpNm = this.tblDpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.colDpNm = this.colDpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usrNm = this.usrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
