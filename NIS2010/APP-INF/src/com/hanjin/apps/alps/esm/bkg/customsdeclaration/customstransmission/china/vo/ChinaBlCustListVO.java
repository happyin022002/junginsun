/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChinaBlCustListVO.java
*@FileTitle : ChinaBlCustListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.10  
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class ChinaBlCustListVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<ChinaBlCustListVO> models = new ArrayList<ChinaBlCustListVO>();

    /* Column Info */
    private String ntfyCntCd = null;

    /* Column Info */
    private String cneeAddr = null;

    /* Column Info */
    private String custNm = null;

    /* Column Info */
    private String ntfySeq = null;

    /* Column Info */
    private String shprCntCd = null;

    /* Column Info */
    private String custAddr = null;

    /* Column Info */
    private String custSeq = null;

    /* Column Info */
    private String ntfyNm = null;

    /* Column Info */
    private String blNo = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String cneeCntCd = null;

    /* Column Info */
    private String cneeNm = null;

    /* Column Info */
    private String cneeSeq = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String shprAddr = null;

    /* Column Info */
    private String cntCd = null;

    /* Column Info */
    private String shprSeq = null;

    /* Column Info */
    private String shprNm = null;

    /* Column Info */
    private String bkgCustTpCd = null;

    /* Column Info */
    private String ntfyAddr = null;

    /* Column Info */
    private String shprRgstNo = null;

    /* Column Info */
    private String cneeRgstNo = null;

    /* Column Info */
    private String ntfyRgstNo = null;

    /* Column Info */
    private String shprCnt = null;

    /* Column Info */
    private String shprPhn = null;

    /* Column Info */
    private String shprFax = null;

    /* Column Info */
    private String shprEml = null;

    /* Column Info */
    private String shprStPo = null;

    /* Column Info */
    private String cneeCnt = null;

    /* Column Info */
    private String cneePhn = null;

    /* Column Info */
    private String cneeFax = null;

    /* Column Info */
    private String cneeEml = null;

    /* Column Info */
    private String cneeStPo = null;

    /* Column Info */
    private String ntfyCnt = null;

    /* Column Info */
    private String ntfyPhn = null;

    /* Column Info */
    private String ntfyFax = null;

    /* Column Info */
    private String ntfyEml = null;

    /* Column Info */
    private String ntfyStPo = null;

    /* Column Info */
    private String shprCoChnTpCd = null;

    /* Column Info */
    private String cneeCoChnTpCd = null;

    /* Column Info */
    private String ntfyCoChnTpCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public ChinaBlCustListVO() {
    }

    public ChinaBlCustListVO(String ibflag, String pagerows, String blNo, String bkgCustTpCd, String cntCd, String custSeq, String custNm, String custAddr, String shprCntCd, String shprSeq, String shprNm, String shprAddr, String cneeCntCd, String cneeSeq, String cneeNm, String cneeAddr, String ntfyCntCd, String ntfySeq, String ntfyNm, String ntfyAddr, String shprRgstNo, String cneeRgstNo, String ntfyRgstNo, String shprCnt, String shprPhn, String shprFax, String shprEml, String shprStPo, String cneeCnt, String cneePhn, String cneeFax, String cneeEml, String cneeStPo, String ntfyCnt, String ntfyPhn, String ntfyFax, String ntfyEml, String ntfyStPo, String shprCoChnTpCd, String cneeCoChnTpCd, String ntfyCoChnTpCd) {
        this.ntfyCntCd = ntfyCntCd;
        this.cneeAddr = cneeAddr;
        this.custNm = custNm;
        this.ntfySeq = ntfySeq;
        this.shprCntCd = shprCntCd;
        this.custAddr = custAddr;
        this.custSeq = custSeq;
        this.ntfyNm = ntfyNm;
        this.blNo = blNo;
        this.pagerows = pagerows;
        this.cneeCntCd = cneeCntCd;
        this.cneeNm = cneeNm;
        this.cneeSeq = cneeSeq;
        this.ibflag = ibflag;
        this.shprAddr = shprAddr;
        this.cntCd = cntCd;
        this.shprSeq = shprSeq;
        this.shprNm = shprNm;
        this.bkgCustTpCd = bkgCustTpCd;
        this.ntfyAddr = ntfyAddr;
        this.shprRgstNo = shprRgstNo;
        this.cneeRgstNo = cneeRgstNo;
        this.ntfyRgstNo = ntfyRgstNo;
        this.shprCnt = shprCnt;
        this.shprPhn = shprPhn;
        this.shprFax = shprFax;
        this.shprEml = shprEml;
        this.shprStPo = shprStPo;
        this.cneeCnt = cneeCnt;
        this.cneePhn = cneePhn;
        this.cneeFax = cneeFax;
        this.cneeEml = cneeEml;
        this.cneeStPo = cneeStPo;
        this.ntfyCnt = ntfyCnt;
        this.ntfyPhn = ntfyPhn;
        this.ntfyFax = ntfyFax;
        this.ntfyEml = ntfyEml;
        this.ntfyStPo = ntfyStPo;
        this.shprCoChnTpCd = shprCoChnTpCd;
        this.cneeCoChnTpCd = cneeCoChnTpCd;
        this.ntfyCoChnTpCd = ntfyCoChnTpCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ntfy_cnt_cd", getNtfyCntCd());
        this.hashColumns.put("cnee_addr", getCneeAddr());
        this.hashColumns.put("cust_nm", getCustNm());
        this.hashColumns.put("ntfy_seq", getNtfySeq());
        this.hashColumns.put("shpr_cnt_cd", getShprCntCd());
        this.hashColumns.put("cust_addr", getCustAddr());
        this.hashColumns.put("cust_seq", getCustSeq());
        this.hashColumns.put("ntfy_nm", getNtfyNm());
        this.hashColumns.put("bl_no", getBlNo());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("cnee_cnt_cd", getCneeCntCd());
        this.hashColumns.put("cnee_nm", getCneeNm());
        this.hashColumns.put("cnee_seq", getCneeSeq());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("shpr_addr", getShprAddr());
        this.hashColumns.put("cnt_cd", getCntCd());
        this.hashColumns.put("shpr_seq", getShprSeq());
        this.hashColumns.put("shpr_nm", getShprNm());
        this.hashColumns.put("bkg_cust_tp_cd", getBkgCustTpCd());
        this.hashColumns.put("ntfy_addr", getNtfyAddr());
        this.hashColumns.put("shpr_rgst_no", getShprRgstNo());
        this.hashColumns.put("cnee_rgst_no", getCneeRgstNo());
        this.hashColumns.put("ntfy_rgst_no", getNtfyRgstNo());
        this.hashColumns.put("shpr_cnt", getShprCnt());
        this.hashColumns.put("shpr_phn", getShprPhn());
        this.hashColumns.put("shpr_fax", getShprFax());
        this.hashColumns.put("shpr_eml", getShprEml());
        this.hashColumns.put("shpr_st_po", getShprStPo());
        this.hashColumns.put("cnee_cnt", getCneeCnt());
        this.hashColumns.put("cnee_phn", getCneePhn());
        this.hashColumns.put("cnee_fax", getCneeFax());
        this.hashColumns.put("cnee_eml", getCneeEml());
        this.hashColumns.put("cnee_st_po", getCneeStPo());
        this.hashColumns.put("ntfy_cnt", getNtfyCnt());
        this.hashColumns.put("ntfy_phn", getNtfyPhn());
        this.hashColumns.put("ntfy_fax", getNtfyFax());
        this.hashColumns.put("ntfy_eml", getNtfyEml());
        this.hashColumns.put("ntfy_st_po", getNtfyStPo());
        this.hashColumns.put("shpr_co_chn_tp_cd", getShprCoChnTpCd());
        this.hashColumns.put("cnee_co_chn_tp_cd", getCneeCoChnTpCd());
        this.hashColumns.put("ntfy_co_chn_tp_cd", getNtfyCoChnTpCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ntfy_cnt_cd", "ntfyCntCd");
        this.hashFields.put("cnee_addr", "cneeAddr");
        this.hashFields.put("cust_nm", "custNm");
        this.hashFields.put("ntfy_seq", "ntfySeq");
        this.hashFields.put("shpr_cnt_cd", "shprCntCd");
        this.hashFields.put("cust_addr", "custAddr");
        this.hashFields.put("cust_seq", "custSeq");
        this.hashFields.put("ntfy_nm", "ntfyNm");
        this.hashFields.put("bl_no", "blNo");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("cnee_cnt_cd", "cneeCntCd");
        this.hashFields.put("cnee_nm", "cneeNm");
        this.hashFields.put("cnee_seq", "cneeSeq");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("shpr_addr", "shprAddr");
        this.hashFields.put("cnt_cd", "cntCd");
        this.hashFields.put("shpr_seq", "shprSeq");
        this.hashFields.put("shpr_nm", "shprNm");
        this.hashFields.put("bkg_cust_tp_cd", "bkgCustTpCd");
        this.hashFields.put("ntfy_addr", "ntfyAddr");
        this.hashFields.put("shpr_rgst_no", "shprRgstNo");
        this.hashFields.put("cnee_rgst_no", "cneeRgstNo");
        this.hashFields.put("ntfy_rgst_no", "ntfyRgstNo");
        this.hashFields.put("shpr_cnt", "shprCnt");
        this.hashFields.put("shpr_phn", "shprPhn");
        this.hashFields.put("shpr_fax", "shprFax");
        this.hashFields.put("shpr_eml", "shprEml");
        this.hashFields.put("shpr_st_po", "shprStPo");
        this.hashFields.put("cnee_cnt", "cneeCnt");
        this.hashFields.put("cnee_phn", "cneePhn");
        this.hashFields.put("cnee_fax", "cneeFax");
        this.hashFields.put("cnee_eml", "cneeEml");
        this.hashFields.put("cnee_st_po", "cneeStPo");
        this.hashFields.put("ntfy_cnt", "ntfyCnt");
        this.hashFields.put("ntfy_phn", "ntfyPhn");
        this.hashFields.put("ntfy_fax", "ntfyFax");
        this.hashFields.put("ntfy_eml", "ntfyEml");
        this.hashFields.put("ntfy_st_po", "ntfyStPo");
        this.hashFields.put("shpr_co_chn_tp_cd", "shprCoChnTpCd");
        this.hashFields.put("cnee_co_chn_tp_cd", "cneeCoChnTpCd");
        this.hashFields.put("ntfy_co_chn_tp_cd", "ntfyCoChnTpCd");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return ntfyCntCd
	 */
    public String getNtfyCntCd() {
        return this.ntfyCntCd;
    }

    /**
	 * Column Info
	 * @return cneeAddr
	 */
    public String getCneeAddr() {
        return this.cneeAddr;
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
	 * @return ntfySeq
	 */
    public String getNtfySeq() {
        return this.ntfySeq;
    }

    /**
	 * Column Info
	 * @return shprCntCd
	 */
    public String getShprCntCd() {
        return this.shprCntCd;
    }

    /**
	 * Column Info
	 * @return custAddr
	 */
    public String getCustAddr() {
        return this.custAddr;
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
	 * @return ntfyNm
	 */
    public String getNtfyNm() {
        return this.ntfyNm;
    }

    /**
	 * Column Info
	 * @return blNo
	 */
    public String getBlNo() {
        return this.blNo;
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
	 * @return cneeCntCd
	 */
    public String getCneeCntCd() {
        return this.cneeCntCd;
    }

    /**
	 * Column Info
	 * @return cneeNm
	 */
    public String getCneeNm() {
        return this.cneeNm;
    }

    /**
	 * Column Info
	 * @return cneeSeq
	 */
    public String getCneeSeq() {
        return this.cneeSeq;
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
	 * @return shprAddr
	 */
    public String getShprAddr() {
        return this.shprAddr;
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
	 * @return shprSeq
	 */
    public String getShprSeq() {
        return this.shprSeq;
    }

    /**
	 * Column Info
	 * @return shprNm
	 */
    public String getShprNm() {
        return this.shprNm;
    }

    /**
	 * Column Info
	 * @return bkgCustTpCd
	 */
    public String getBkgCustTpCd() {
        return this.bkgCustTpCd;
    }

    /**
	 * Column Info
	 * @return ntfyAddr
	 */
    public String getNtfyAddr() {
        return this.ntfyAddr;
    }

    /**
	 * Column Info
	 * @param ntfyCntCd
	 */
    public void setNtfyCntCd(String ntfyCntCd) {
        this.ntfyCntCd = ntfyCntCd;
    }

    /**
	 * Column Info
	 * @param cneeAddr
	 */
    public void setCneeAddr(String cneeAddr) {
        this.cneeAddr = cneeAddr;
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
	 * @param ntfySeq
	 */
    public void setNtfySeq(String ntfySeq) {
        this.ntfySeq = ntfySeq;
    }

    /**
	 * Column Info
	 * @param shprCntCd
	 */
    public void setShprCntCd(String shprCntCd) {
        this.shprCntCd = shprCntCd;
    }

    /**
	 * Column Info
	 * @param custAddr
	 */
    public void setCustAddr(String custAddr) {
        this.custAddr = custAddr;
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
	 * @param ntfyNm
	 */
    public void setNtfyNm(String ntfyNm) {
        this.ntfyNm = ntfyNm;
    }

    /**
	 * Column Info
	 * @param blNo
	 */
    public void setBlNo(String blNo) {
        this.blNo = blNo;
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
	 * @param cneeCntCd
	 */
    public void setCneeCntCd(String cneeCntCd) {
        this.cneeCntCd = cneeCntCd;
    }

    /**
	 * Column Info
	 * @param cneeNm
	 */
    public void setCneeNm(String cneeNm) {
        this.cneeNm = cneeNm;
    }

    /**
	 * Column Info
	 * @param cneeSeq
	 */
    public void setCneeSeq(String cneeSeq) {
        this.cneeSeq = cneeSeq;
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
	 * @param shprAddr
	 */
    public void setShprAddr(String shprAddr) {
        this.shprAddr = shprAddr;
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
	 * @param shprSeq
	 */
    public void setShprSeq(String shprSeq) {
        this.shprSeq = shprSeq;
    }

    /**
	 * Column Info
	 * @param shprNm
	 */
    public void setShprNm(String shprNm) {
        this.shprNm = shprNm;
    }

    /**
	 * Column Info
	 * @param bkgCustTpCd
	 */
    public void setBkgCustTpCd(String bkgCustTpCd) {
        this.bkgCustTpCd = bkgCustTpCd;
    }

    /**
	 * Column Info
	 * @param ntfyAddr
	 */
    public void setNtfyAddr(String ntfyAddr) {
        this.ntfyAddr = ntfyAddr;
    }

    public void setShprRgstNo(String shprRgstNo) {
        this.shprRgstNo = shprRgstNo;
    }

    public String getShprRgstNo() {
        return this.shprRgstNo;
    }

    public void setCneeRgstNo(String cneeRgstNo) {
        this.cneeRgstNo = cneeRgstNo;
    }

    public String getCneeRgstNo() {
        return this.cneeRgstNo;
    }

    public void setNtfyRgstNo(String ntfyRgstNo) {
        this.ntfyRgstNo = ntfyRgstNo;
    }

    public String getNtfyRgstNo() {
        return this.ntfyRgstNo;
    }

    public void setShprCnt(String shprCnt) {
        this.shprCnt = shprCnt;
    }

    public String getShprCnt() {
        return this.shprCnt;
    }

    public void setShprPhn(String shprPhn) {
        this.shprPhn = shprPhn;
    }

    public String getShprPhn() {
        return this.shprPhn;
    }

    public void setShprFax(String shprFax) {
        this.shprFax = shprFax;
    }

    public String getShprFax() {
        return this.shprFax;
    }

    public void setShprEml(String shprEml) {
        this.shprEml = shprEml;
    }

    public String getShprEml() {
        return this.shprEml;
    }

    public void setShprStPo(String shprStPo) {
        this.shprStPo = shprStPo;
    }

    public String getShprStPo() {
        return this.shprStPo;
    }

    public void setCneeCnt(String cneeCnt) {
        this.cneeCnt = cneeCnt;
    }

    public String getCneeCnt() {
        return this.cneeCnt;
    }

    public void setCneePhn(String cneePhn) {
        this.cneePhn = cneePhn;
    }

    public String getCneePhn() {
        return this.cneePhn;
    }

    public void setCneeFax(String cneeFax) {
        this.cneeFax = cneeFax;
    }

    public String getCneeFax() {
        return this.cneeFax;
    }

    public void setCneeEml(String cneeEml) {
        this.cneeEml = cneeEml;
    }

    public String getCneeEml() {
        return this.cneeEml;
    }

    public void setCneeStPo(String cneeStPo) {
        this.cneeStPo = cneeStPo;
    }

    public String getCneeStPo() {
        return this.cneeStPo;
    }

    public void setNtfyCnt(String ntfyCnt) {
        this.ntfyCnt = ntfyCnt;
    }

    public String getNtfyCnt() {
        return this.ntfyCnt;
    }

    public void setNtfyPhn(String ntfyPhn) {
        this.ntfyPhn = ntfyPhn;
    }

    public String getNtfyPhn() {
        return this.ntfyPhn;
    }

    public void setNtfyFax(String ntfyFax) {
        this.ntfyFax = ntfyFax;
    }

    public String getNtfyFax() {
        return this.ntfyFax;
    }

    public void setNtfyEml(String ntfyEml) {
        this.ntfyEml = ntfyEml;
    }

    public String getNtfyEml() {
        return this.ntfyEml;
    }

    public void setNtfyStPo(String ntfyStPo) {
        this.ntfyStPo = ntfyStPo;
    }

    public String getNtfyStPo() {
        return this.ntfyStPo;
    }

    public void setShprCoChnTpCd(String shprCoChnTpCd) {
        this.shprCoChnTpCd = shprCoChnTpCd;
    }

    public String getShprCoChnTpCd() {
        return this.shprCoChnTpCd;
    }

    public void setCneeCoChnTpCd(String cneeCoChnTpCd) {
        this.cneeCoChnTpCd = cneeCoChnTpCd;
    }

    public String getCneeCoChnTpCd() {
        return this.cneeCoChnTpCd;
    }

    public void setNtfyCoChnTpCd(String ntfyCoChnTpCd) {
        this.ntfyCoChnTpCd = ntfyCoChnTpCd;
    }

    public String getNtfyCoChnTpCd() {
        return this.ntfyCoChnTpCd;
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
        setNtfyCntCd(JSPUtil.getParameter(request, prefix + "ntfy_cnt_cd", ""));
        setCneeAddr(JSPUtil.getParameter(request, prefix + "cnee_addr", ""));
        setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
        setNtfySeq(JSPUtil.getParameter(request, prefix + "ntfy_seq", ""));
        setShprCntCd(JSPUtil.getParameter(request, prefix + "shpr_cnt_cd", ""));
        setCustAddr(JSPUtil.getParameter(request, prefix + "cust_addr", ""));
        setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
        setNtfyNm(JSPUtil.getParameter(request, prefix + "ntfy_nm", ""));
        setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setCneeCntCd(JSPUtil.getParameter(request, prefix + "cnee_cnt_cd", ""));
        setCneeNm(JSPUtil.getParameter(request, prefix + "cnee_nm", ""));
        setCneeSeq(JSPUtil.getParameter(request, prefix + "cnee_seq", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setShprAddr(JSPUtil.getParameter(request, prefix + "shpr_addr", ""));
        setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
        setShprSeq(JSPUtil.getParameter(request, prefix + "shpr_seq", ""));
        setShprNm(JSPUtil.getParameter(request, prefix + "shpr_nm", ""));
        setBkgCustTpCd(JSPUtil.getParameter(request, prefix + "bkg_cust_tp_cd", ""));
        setNtfyAddr(JSPUtil.getParameter(request, prefix + "ntfy_addr", ""));
        setShprRgstNo(JSPUtil.getParameter(request, prefix + "shpr_rgst_no", ""));
        setCneeRgstNo(JSPUtil.getParameter(request, prefix + "cnee_rgst_no", ""));
        setNtfyRgstNo(JSPUtil.getParameter(request, prefix + "ntfy_rgst_no", ""));
        setShprCnt(JSPUtil.getParameter(request, prefix + "shpr_cnt", ""));
        setShprPhn(JSPUtil.getParameter(request, prefix + "shpr_phn", ""));
        setShprFax(JSPUtil.getParameter(request, prefix + "shpr_fax", ""));
        setShprEml(JSPUtil.getParameter(request, prefix + "shpr_eml", ""));
        setShprStPo(JSPUtil.getParameter(request, prefix + "shpr_st_po", ""));
        setCneeCnt(JSPUtil.getParameter(request, prefix + "cnee_cnt", ""));
        setCneePhn(JSPUtil.getParameter(request, prefix + "cnee_phn", ""));
        setCneeFax(JSPUtil.getParameter(request, prefix + "cnee_fax", ""));
        setCneeEml(JSPUtil.getParameter(request, prefix + "cnee_eml", ""));
        setCneeStPo(JSPUtil.getParameter(request, prefix + "cnee_st_po", ""));
        setNtfyCnt(JSPUtil.getParameter(request, prefix + "ntfy_cnt", ""));
        setNtfyPhn(JSPUtil.getParameter(request, prefix + "ntfy_phn", ""));
        setNtfyFax(JSPUtil.getParameter(request, prefix + "ntfy_fax", ""));
        setNtfyEml(JSPUtil.getParameter(request, prefix + "ntfy_eml", ""));
        setNtfyStPo(JSPUtil.getParameter(request, prefix + "ntfy_st_po", ""));
        setShprCoChnTpCd(JSPUtil.getParameter(request, prefix + "shpr_co_chn_tp_cd", ""));
        setCneeCoChnTpCd(JSPUtil.getParameter(request, prefix + "cnee_co_chn_tp_cd", ""));
        setNtfyCoChnTpCd(JSPUtil.getParameter(request, prefix + "ntfy_co_chn_tp_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChinaBlCustListVO[]
	 */
    public ChinaBlCustListVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ChinaBlCustListVO[]
	 */
    public ChinaBlCustListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        ChinaBlCustListVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ntfyCntCd = (JSPUtil.getParameter(request, prefix + "ntfy_cnt_cd", length));
            String[] cneeAddr = (JSPUtil.getParameter(request, prefix + "cnee_addr", length));
            String[] custNm = (JSPUtil.getParameter(request, prefix + "cust_nm", length));
            String[] ntfySeq = (JSPUtil.getParameter(request, prefix + "ntfy_seq", length));
            String[] shprCntCd = (JSPUtil.getParameter(request, prefix + "shpr_cnt_cd", length));
            String[] custAddr = (JSPUtil.getParameter(request, prefix + "cust_addr", length));
            String[] custSeq = (JSPUtil.getParameter(request, prefix + "cust_seq", length));
            String[] ntfyNm = (JSPUtil.getParameter(request, prefix + "ntfy_nm", length));
            String[] blNo = (JSPUtil.getParameter(request, prefix + "bl_no", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] cneeCntCd = (JSPUtil.getParameter(request, prefix + "cnee_cnt_cd", length));
            String[] cneeNm = (JSPUtil.getParameter(request, prefix + "cnee_nm", length));
            String[] cneeSeq = (JSPUtil.getParameter(request, prefix + "cnee_seq", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] shprAddr = (JSPUtil.getParameter(request, prefix + "shpr_addr", length));
            String[] cntCd = (JSPUtil.getParameter(request, prefix + "cnt_cd", length));
            String[] shprSeq = (JSPUtil.getParameter(request, prefix + "shpr_seq", length));
            String[] shprNm = (JSPUtil.getParameter(request, prefix + "shpr_nm", length));
            String[] bkgCustTpCd = (JSPUtil.getParameter(request, prefix + "bkg_cust_tp_cd", length));
            String[] ntfyAddr = (JSPUtil.getParameter(request, prefix + "ntfy_addr", length));
            String[] shprRgstNo = (JSPUtil.getParameter(request, prefix + "shpr_rgst_no", length));
            String[] cneeRgstNo = (JSPUtil.getParameter(request, prefix + "cnee_rgst_no", length));
            String[] ntfyRgstNo = (JSPUtil.getParameter(request, prefix + "ntfy_rgst_no", length));
            String[] shprCnt = (JSPUtil.getParameter(request, prefix + "shpr_cnt", length));
            String[] shprPhn = (JSPUtil.getParameter(request, prefix + "shpr_phn", length));
            String[] shprFax = (JSPUtil.getParameter(request, prefix + "shpr_fax", length));
            String[] shprEml = (JSPUtil.getParameter(request, prefix + "shpr_eml", length));
            String[] shprStPo = (JSPUtil.getParameter(request, prefix + "shpr_st_po", length));
            String[] cneeCnt = (JSPUtil.getParameter(request, prefix + "cnee_cnt", length));
            String[] cneePhn = (JSPUtil.getParameter(request, prefix + "cnee_phn", length));
            String[] cneeFax = (JSPUtil.getParameter(request, prefix + "cnee_fax", length));
            String[] cneeEml = (JSPUtil.getParameter(request, prefix + "cnee_eml", length));
            String[] cneeStPo = (JSPUtil.getParameter(request, prefix + "cnee_st_po", length));
            String[] ntfyCnt = (JSPUtil.getParameter(request, prefix + "ntfy_cnt", length));
            String[] ntfyPhn = (JSPUtil.getParameter(request, prefix + "ntfy_phn", length));
            String[] ntfyFax = (JSPUtil.getParameter(request, prefix + "ntfy_fax", length));
            String[] ntfyEml = (JSPUtil.getParameter(request, prefix + "ntfy_eml", length));
            String[] ntfyStPo = (JSPUtil.getParameter(request, prefix + "ntfy_st_po", length));
            String[] shprCoChnTpCd = (JSPUtil.getParameter(request, prefix + "shpr_co_chn_tp_cd", length));
	    	String[] cneeCoChnTpCd = (JSPUtil.getParameter(request, prefix + "cnee_co_chn_tp_cd", length));
	    	String[] ntfyCoChnTpCd = (JSPUtil.getParameter(request, prefix + "ntfy_co_chn_tp_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new ChinaBlCustListVO();
                if (ntfyCntCd[i] != null)
                    model.setNtfyCntCd(ntfyCntCd[i]);
                if (cneeAddr[i] != null)
                    model.setCneeAddr(cneeAddr[i]);
                if (custNm[i] != null)
                    model.setCustNm(custNm[i]);
                if (ntfySeq[i] != null)
                    model.setNtfySeq(ntfySeq[i]);
                if (shprCntCd[i] != null)
                    model.setShprCntCd(shprCntCd[i]);
                if (custAddr[i] != null)
                    model.setCustAddr(custAddr[i]);
                if (custSeq[i] != null)
                    model.setCustSeq(custSeq[i]);
                if (ntfyNm[i] != null)
                    model.setNtfyNm(ntfyNm[i]);
                if (blNo[i] != null)
                    model.setBlNo(blNo[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (cneeCntCd[i] != null)
                    model.setCneeCntCd(cneeCntCd[i]);
                if (cneeNm[i] != null)
                    model.setCneeNm(cneeNm[i]);
                if (cneeSeq[i] != null)
                    model.setCneeSeq(cneeSeq[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (shprAddr[i] != null)
                    model.setShprAddr(shprAddr[i]);
                if (cntCd[i] != null)
                    model.setCntCd(cntCd[i]);
                if (shprSeq[i] != null)
                    model.setShprSeq(shprSeq[i]);
                if (shprNm[i] != null)
                    model.setShprNm(shprNm[i]);
                if (bkgCustTpCd[i] != null)
                    model.setBkgCustTpCd(bkgCustTpCd[i]);
                if (ntfyAddr[i] != null)
                    model.setNtfyAddr(ntfyAddr[i]);
                if (shprRgstNo[i] != null)
                    model.setShprRgstNo(shprRgstNo[i]);
                if (cneeRgstNo[i] != null)
                    model.setCneeRgstNo(cneeRgstNo[i]);
                if (ntfyRgstNo[i] != null)
                    model.setNtfyRgstNo(ntfyRgstNo[i]);
                if (shprCnt[i] != null)
                    model.setShprCnt(shprCnt[i]);
                if (shprPhn[i] != null)
                    model.setShprPhn(shprPhn[i]);
                if (shprFax[i] != null)
                    model.setShprFax(shprFax[i]);
                if (shprEml[i] != null)
                    model.setShprEml(shprEml[i]);
                if (shprStPo[i] != null)
                    model.setShprStPo(shprStPo[i]);
                if (cneeCnt[i] != null)
                    model.setCneeCnt(cneeCnt[i]);
                if (cneePhn[i] != null)
                    model.setCneePhn(cneePhn[i]);
                if (cneeFax[i] != null)
                    model.setCneeFax(cneeFax[i]);
                if (cneeEml[i] != null)
                    model.setCneeEml(cneeEml[i]);
                if (cneeStPo[i] != null)
                    model.setCneeStPo(cneeStPo[i]);
                if (ntfyCnt[i] != null)
                    model.setNtfyCnt(ntfyCnt[i]);
                if (ntfyPhn[i] != null)
                    model.setNtfyPhn(ntfyPhn[i]);
                if (ntfyFax[i] != null)
                    model.setNtfyFax(ntfyFax[i]);
                if (ntfyEml[i] != null)
                    model.setNtfyEml(ntfyEml[i]);
                if (ntfyStPo[i] != null)
                    model.setNtfyStPo(ntfyStPo[i]);
                if (shprCoChnTpCd[i] != null) 
		    		model.setShprCoChnTpCd(shprCoChnTpCd[i]);
				if (cneeCoChnTpCd[i] != null) 
		    		model.setCneeCoChnTpCd(cneeCoChnTpCd[i]);
				if (ntfyCoChnTpCd[i] != null) 
		    		model.setNtfyCoChnTpCd(ntfyCoChnTpCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getChinaBlCustListVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return ChinaBlCustListVO[]
	 */
    public ChinaBlCustListVO[] getChinaBlCustListVOs() {
        ChinaBlCustListVO[] vos = (ChinaBlCustListVO[]) models.toArray(new ChinaBlCustListVO[models.size()]);
        return vos;
    }

    /**
	 * VO Class의 내용을 String으로 변환
	 */
    public String toString() {
        StringBuffer ret = new StringBuffer();
        Field[] field = this.getClass().getDeclaredFields();
        String space = "";
        try {
            for (int i = 0; i < field.length; i++) {
                String[] arr = null;
                arr = getField(field, i);
                if (arr != null) {
                    for (int j = 0; j < arr.length; j++) {
                        ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
                    }
                } else {
                    ret.append(field[i].getName() + " =  null \n");
                }
            }
        } catch (Exception ex) {
            return null;
        }
        return ret.toString();
    }

    /**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
    private String[] getField(Field[] field, int i) {
        String[] arr = null;
        try {
            arr = (String[]) field[i].get(this);
        } catch (Exception ex) {
            arr = null;
        }
        return arr;
    }

    /**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
    public void unDataFormat() {
        this.ntfyCntCd = this.ntfyCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cneeAddr = this.cneeAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custNm = this.custNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ntfySeq = this.ntfySeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shprCntCd = this.shprCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custAddr = this.custAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custSeq = this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ntfyNm = this.ntfyNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blNo = this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cneeCntCd = this.cneeCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cneeNm = this.cneeNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cneeSeq = this.cneeSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shprAddr = this.shprAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntCd = this.cntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shprSeq = this.shprSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shprNm = this.shprNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgCustTpCd = this.bkgCustTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ntfyAddr = this.ntfyAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shprRgstNo = this.shprRgstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cneeRgstNo = this.cneeRgstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ntfyRgstNo = this.ntfyRgstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shprCnt = this.shprCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shprPhn = this.shprPhn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shprFax = this.shprFax.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shprEml = this.shprEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shprStPo = this.shprStPo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cneeCnt = this.cneeCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cneePhn = this.cneePhn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cneeFax = this.cneeFax.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cneeEml = this.cneeEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cneeStPo = this.cneeStPo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ntfyCnt = this.ntfyCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ntfyPhn = this.ntfyPhn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ntfyFax = this.ntfyFax.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ntfyEml = this.ntfyEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ntfyStPo = this.ntfyStPo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shprCoChnTpCd = this.shprCoChnTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cneeCoChnTpCd = this.cneeCoChnTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ntfyCoChnTpCd = this.ntfyCoChnTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
