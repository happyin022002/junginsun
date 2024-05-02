/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SearchUSGuaranteeHdrVO.java
 *@FileTitle : SearchUSGuaranteeHdrVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.11.20
 *@LastModifier : yOng hO lEE
 *@LastVersion : 1.0
 * 2009.11.20 yOng hO lEE 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.guaranteemanage.guaranteemanage.vo;

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
 * @author yOng hO lEE
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class SearchUSGuaranteeHdrVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<SearchUSGuaranteeHdrVO> models = new ArrayList<SearchUSGuaranteeHdrVO>();

    /* Column Info */
    private String currCd = null;

    /* Column Info */
    private String gnteCustCd = null;

    /* Column Info */
    private String deltFlg = null;

    /* Column Info */
    private String bkgStsCd = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String ttlAmt = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String gnteCustCdName = null;

    /* Column Info */
    private String deptNo = null;

    /* Column Info */
    private String ofcCd = null;

    /* Column Info */
    private String creUsrId = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String gnteNo = null;

    /* Column Info */
    private String vndrSeqName = null;

    /* Column Info */
    private String vndrSeq = null;

    /* Column Info */
    private String gnteRmk = null;

    /* Column Info */
    private String gnteTpCd = null;

    /* Column Info */
    private String picPhnNo = null;

    /* Column Info */
    private String picFaxNo = null;

    /* Column Info */
    private String ydCd = null;

    /* Column Info */
    private String ydNm = null;

    /* Column Info */
    private String dmyFlg = null;

    /* 테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /* 테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public SearchUSGuaranteeHdrVO() {
    }

    public SearchUSGuaranteeHdrVO(String ibflag, String pagerows, String gnteNo, String ofcCd, String gnteTpCd, String currCd, String vndrSeq, String vndrSeqName, String gnteCustCd, String gnteCustCdName, String bkgStsCd, String ttlAmt, String picPhnNo, String picFaxNo, String deptNo, String gnteRmk, String deltFlg, String creUsrId, String creDt, String ydNm, String ydCd, String dmyFlg) {
        this.currCd = currCd;
        this.gnteCustCd = gnteCustCd;
        this.deltFlg = deltFlg;
        this.bkgStsCd = bkgStsCd;
        this.creDt = creDt;
        this.ttlAmt = ttlAmt;
        this.pagerows = pagerows;
        this.gnteCustCdName = gnteCustCdName;
        this.deptNo = deptNo;
        this.ofcCd = ofcCd;
        this.creUsrId = creUsrId;
        this.ibflag = ibflag;
        this.gnteNo = gnteNo;
        this.vndrSeqName = vndrSeqName;
        this.vndrSeq = vndrSeq;
        this.gnteRmk = gnteRmk;
        this.gnteTpCd = gnteTpCd;
        this.picPhnNo = picPhnNo;
        this.picFaxNo = picFaxNo;
        this.ydNm = ydNm;
        this.ydCd = ydCd;
        this.dmyFlg = dmyFlg;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * 
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("curr_cd", getCurrCd());
        this.hashColumns.put("gnte_cust_cd", getGnteCustCd());
        this.hashColumns.put("delt_flg", getDeltFlg());
        this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("ttl_amt", getTtlAmt());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("gnte_cust_cd_name", getGnteCustCdName());
        this.hashColumns.put("dept_no", getDeptNo());
        this.hashColumns.put("ofc_cd", getOfcCd());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("gnte_no", getGnteNo());
        this.hashColumns.put("vndr_seq_name", getVndrSeqName());
        this.hashColumns.put("vndr_seq", getVndrSeq());
        this.hashColumns.put("gnte_rmk", getGnteRmk());
        this.hashColumns.put("gnte_tp_cd", getGnteTpCd());
        this.hashColumns.put("pic_phn_no", getPicPhnNo());
        this.hashColumns.put("pic_fax_no", getPicFaxNo());
        this.hashColumns.put("yd_cd", getYdCd());
        this.hashColumns.put("yd_nm", getYdNm());
        this.hashColumns.put("dmy_flg", getDmyFlg());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * 
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("curr_cd", "currCd");
        this.hashFields.put("gnte_cust_cd", "gnteCustCd");
        this.hashFields.put("delt_flg", "deltFlg");
        this.hashFields.put("bkg_sts_cd", "bkgStsCd");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("ttl_amt", "ttlAmt");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("gnte_cust_cd_name", "gnteCustCdName");
        this.hashFields.put("dept_no", "deptNo");
        this.hashFields.put("ofc_cd", "ofcCd");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("gnte_no", "gnteNo");
        this.hashFields.put("vndr_seq_name", "vndrSeqName");
        this.hashFields.put("vndr_seq", "vndrSeq");
        this.hashFields.put("gnte_rmk", "gnteRmk");
        this.hashFields.put("gnte_tp_cd", "gnteTpCd");
        this.hashFields.put("pic_phn_no", "picPhnNo");
        this.hashFields.put("pic_fax_no", "picFaxNo");
        this.hashFields.put("yd_cd", "ydCd");
        this.hashFields.put("yd_nm", "ydNm");
        this.hashFields.put("dmy_flg", "dmyFlg");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * 
	 * @return currCd
	 */
    public String getCurrCd() {
        return this.currCd;
    }

    /**
	 * Column Info
	 * 
	 * @return gnteCustCd
	 */
    public String getGnteCustCd() {
        return this.gnteCustCd;
    }

    /**
	 * Column Info
	 * 
	 * @return deltFlg
	 */
    public String getDeltFlg() {
        return this.deltFlg;
    }

    /**
	 * Column Info
	 * 
	 * @return bkgStsCd
	 */
    public String getBkgStsCd() {
        return this.bkgStsCd;
    }

    /**
	 * Column Info
	 * 
	 * @return creDt
	 */
    public String getCreDt() {
        return this.creDt;
    }

    /**
	 * Column Info
	 * 
	 * @return ttlAmt
	 */
    public String getTtlAmt() {
        return this.ttlAmt;
    }

    /**
	 * Page Number
	 * 
	 * @return pagerows
	 */
    public String getPagerows() {
        return this.pagerows;
    }

    /**
	 * Column Info
	 * 
	 * @return gnteCustCdName
	 */
    public String getGnteCustCdName() {
        return this.gnteCustCdName;
    }

    /**
	 * Column Info
	 * 
	 * @return deptNo
	 */
    public String getDeptNo() {
        return this.deptNo;
    }

    /**
	 * Column Info
	 * 
	 * @return ofcCd
	 */
    public String getOfcCd() {
        return this.ofcCd;
    }

    /**
	 * Column Info
	 * 
	 * @return creUsrId
	 */
    public String getCreUsrId() {
        return this.creUsrId;
    }

    /**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * 
	 * @return ibflag
	 */
    public String getIbflag() {
        return this.ibflag;
    }

    /**
	 * Column Info
	 * 
	 * @return gnteNo
	 */
    public String getGnteNo() {
        return this.gnteNo;
    }

    /**
	 * Column Info
	 * 
	 * @return vndrSeqName
	 */
    public String getVndrSeqName() {
        return this.vndrSeqName;
    }

    /**
	 * Column Info
	 * 
	 * @return vndrSeq
	 */
    public String getVndrSeq() {
        return this.vndrSeq;
    }

    /**
	 * Column Info
	 * 
	 * @return gnteRmk
	 */
    public String getGnteRmk() {
        return this.gnteRmk;
    }

    /**
	 * Column Info
	 * 
	 * @return gnteTpCd
	 */
    public String getGnteTpCd() {
        return this.gnteTpCd;
    }

    /**
	 * Column Info
	 * 
	 * @return picPhnNo
	 */
    public String getPicPhnNo() {
        return this.picPhnNo;
    }

    /**
	 * Column Info
	 * 
	 * @return picFaxNo
	 */
    public String getPicFaxNo() {
        return this.picFaxNo;
    }

    /**
	 * Column Info
	 * 
	 * @return ydCd
	 */
    public String getYdCd() {
        return this.ydCd;
    }

    /**
	 * Column Info
	 * 
	 * @return ydNm
	 */
    public String getYdNm() {
        return this.ydNm;
    }

    /**
	 * Column Info
	 * 
	 * @param currCd
	 */
    public void setCurrCd(String currCd) {
        this.currCd = currCd;
    }

    /**
	 * Column Info
	 * 
	 * @param gnteCustCd
	 */
    public void setGnteCustCd(String gnteCustCd) {
        this.gnteCustCd = gnteCustCd;
    }

    /**
	 * Column Info
	 * 
	 * @param deltFlg
	 */
    public void setDeltFlg(String deltFlg) {
        this.deltFlg = deltFlg;
    }

    /**
	 * Column Info
	 * 
	 * @param bkgStsCd
	 */
    public void setBkgStsCd(String bkgStsCd) {
        this.bkgStsCd = bkgStsCd;
    }

    /**
	 * Column Info
	 * 
	 * @param creDt
	 */
    public void setCreDt(String creDt) {
        this.creDt = creDt;
    }

    /**
	 * Column Info
	 * 
	 * @param ttlAmt
	 */
    public void setTtlAmt(String ttlAmt) {
        this.ttlAmt = ttlAmt;
    }

    /**
	 * Page Number
	 * 
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    /**
	 * Column Info
	 * 
	 * @param gnteCustCdName
	 */
    public void setGnteCustCdName(String gnteCustCdName) {
        this.gnteCustCdName = gnteCustCdName;
    }

    /**
	 * Column Info
	 * 
	 * @param deptNo
	 */
    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    /**
	 * Column Info
	 * 
	 * @param ofcCd
	 */
    public void setOfcCd(String ofcCd) {
        this.ofcCd = ofcCd;
    }

    /**
	 * Column Info
	 * 
	 * @param creUsrId
	 */
    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
    }

    /**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * 
	 * @param ibflag
	 */
    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
    }

    /**
	 * Column Info
	 * 
	 * @param gnteNo
	 */
    public void setGnteNo(String gnteNo) {
        this.gnteNo = gnteNo;
    }

    /**
	 * Column Info
	 * 
	 * @param vndrSeqName
	 */
    public void setVndrSeqName(String vndrSeqName) {
        this.vndrSeqName = vndrSeqName;
    }

    /**
	 * Column Info
	 * 
	 * @param vndrSeq
	 */
    public void setVndrSeq(String vndrSeq) {
        this.vndrSeq = vndrSeq;
    }

    /**
	 * Column Info
	 * 
	 * @param gnteRmk
	 */
    public void setGnteRmk(String gnteRmk) {
        this.gnteRmk = gnteRmk;
    }

    /**
	 * Column Info
	 * 
	 * @param gnteTpCd
	 */
    public void setGnteTpCd(String gnteTpCd) {
        this.gnteTpCd = gnteTpCd;
    }

    /**
	 * Column Info
	 * 
	 * @param picPhnNo
	 */
    public void setPicPhnNo(String picPhnNo) {
        this.picPhnNo = picPhnNo;
    }

    /**
	 * Column Info
	 * 
	 * @param picFaxNo
	 */
    public void setPicFaxNo(String picFaxNo) {
        this.picFaxNo = picFaxNo;
    }

    /**
	 * Column Info
	 * 
	 * @param ydCd
	 */
    public void setYdCd(String ydCd) {
        this.ydCd = ydCd;
    }

    /**
	 * Column Info
	 * 
	 * @param ydNm
	 */
    public void setYdNm(String ydNm) {
        this.ydNm = ydNm;
    }

    public void setDmyFlg(String dmyFlg) {
        this.dmyFlg = dmyFlg;
    }

    public String getDmyFlg() {
        return this.dmyFlg;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * 
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
        setGnteCustCd(JSPUtil.getParameter(request, "gnte_cust_cd", ""));
        setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
        setBkgStsCd(JSPUtil.getParameter(request, "bkg_sts_cd", ""));
        setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
        setTtlAmt(JSPUtil.getParameter(request, "ttl_amt", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setGnteCustCdName(JSPUtil.getParameter(request, "gnte_cust_cd_name", ""));
        setDeptNo(JSPUtil.getParameter(request, "dept_no", ""));
        setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
        setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setGnteNo(JSPUtil.getParameter(request, "gnte_no", ""));
        setVndrSeqName(JSPUtil.getParameter(request, "vndr_seq_name", ""));
        setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
        setGnteRmk(JSPUtil.getParameter(request, "gnte_rmk", ""));
        setGnteTpCd(JSPUtil.getParameter(request, "gnte_tp_cd", ""));
        setPicPhnNo(JSPUtil.getParameter(request, "pic_phn_no", ""));
        setPicFaxNo(JSPUtil.getParameter(request, "pic_fax_no", ""));
        setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
        setYdNm(JSPUtil.getParameter(request, "yd_nm", ""));
        setDmyFlg(JSPUtil.getParameter(request, "dmy_flg", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * 
	 * @param request
	 * @return SearchUSGuaranteeHdrVO[]
	 */
    public SearchUSGuaranteeHdrVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * 
	 * @param request
	 * @param prefix
	 * @return SearchUSGuaranteeHdrVO[]
	 */
    public SearchUSGuaranteeHdrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        SearchUSGuaranteeHdrVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] currCd = (JSPUtil.getParameter(request, prefix + "curr_cd", length));
            String[] gnteCustCd = (JSPUtil.getParameter(request, prefix + "gnte_cust_cd", length));
            String[] deltFlg = (JSPUtil.getParameter(request, prefix + "delt_flg", length));
            String[] bkgStsCd = (JSPUtil.getParameter(request, prefix + "bkg_sts_cd", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] ttlAmt = (JSPUtil.getParameter(request, prefix + "ttl_amt", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] gnteCustCdName = (JSPUtil.getParameter(request, prefix + "gnte_cust_cd_name", length));
            String[] deptNo = (JSPUtil.getParameter(request, prefix + "dept_no", length));
            String[] ofcCd = (JSPUtil.getParameter(request, prefix + "ofc_cd", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] gnteNo = (JSPUtil.getParameter(request, prefix + "gnte_no", length));
            String[] vndrSeqName = (JSPUtil.getParameter(request, prefix + "vndr_seq_name", length));
            String[] vndrSeq = (JSPUtil.getParameter(request, prefix + "vndr_seq", length));
            String[] gnteRmk = (JSPUtil.getParameter(request, prefix + "gnte_rmk", length));
            String[] gnteTpCd = (JSPUtil.getParameter(request, prefix + "gnte_tp_cd", length));
            String[] picPhnNo = (JSPUtil.getParameter(request, prefix + "pic_phn_no", length));
            String[] picFaxNo = (JSPUtil.getParameter(request, prefix + "pic_fax_no", length));
            String[] ydCd = (JSPUtil.getParameter(request, prefix + "yd_cd", length));
            String[] ydNm = (JSPUtil.getParameter(request, prefix + "yd_nm", length));
            String[] dmyFlg = (JSPUtil.getParameter(request, prefix + "dmy_flg", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new SearchUSGuaranteeHdrVO();
                if (currCd[i] != null)
                    model.setCurrCd(currCd[i]);
                if (gnteCustCd[i] != null)
                    model.setGnteCustCd(gnteCustCd[i]);
                if (deltFlg[i] != null)
                    model.setDeltFlg(deltFlg[i]);
                if (bkgStsCd[i] != null)
                    model.setBkgStsCd(bkgStsCd[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (ttlAmt[i] != null)
                    model.setTtlAmt(ttlAmt[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (gnteCustCdName[i] != null)
                    model.setGnteCustCdName(gnteCustCdName[i]);
                if (deptNo[i] != null)
                    model.setDeptNo(deptNo[i]);
                if (ofcCd[i] != null)
                    model.setOfcCd(ofcCd[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (gnteNo[i] != null)
                    model.setGnteNo(gnteNo[i]);
                if (vndrSeqName[i] != null)
                    model.setVndrSeqName(vndrSeqName[i]);
                if (vndrSeq[i] != null)
                    model.setVndrSeq(vndrSeq[i]);
                if (gnteRmk[i] != null)
                    model.setGnteRmk(gnteRmk[i]);
                if (gnteTpCd[i] != null)
                    model.setGnteTpCd(gnteTpCd[i]);
                if (picPhnNo[i] != null)
                    model.setPicPhnNo(picPhnNo[i]);
                if (picFaxNo[i] != null)
                    model.setPicFaxNo(picFaxNo[i]);
                if (ydCd[i] != null)
                    model.setYdCd(ydCd[i]);
                if (ydNm[i] != null)
                    model.setYdNm(ydNm[i]);
                if (dmyFlg[i] != null) 
		    		model.setDmyFlg(dmyFlg[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getSearchUSGuaranteeHdrVOs();
    }

    /**
	 * VO 배열을 반환
	 * 
	 * @return SearchUSGuaranteeHdrVO[]
	 */
    public SearchUSGuaranteeHdrVO[] getSearchUSGuaranteeHdrVOs() {
        SearchUSGuaranteeHdrVO[] vos = (SearchUSGuaranteeHdrVO[]) models.toArray(new SearchUSGuaranteeHdrVO[models.size()]);
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
        this.currCd = this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.gnteCustCd = this.gnteCustCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deltFlg = this.deltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgStsCd = this.bkgStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ttlAmt = this.ttlAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.gnteCustCdName = this.gnteCustCdName.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deptNo = this.deptNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcCd = this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.gnteNo = this.gnteNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrSeqName = this.vndrSeqName.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrSeq = this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.gnteRmk = this.gnteRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.gnteTpCd = this.gnteTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.picPhnNo = this.picPhnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.picFaxNo = this.picFaxNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydCd = this.ydCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydNm = this.ydNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmyFlg = this.dmyFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
