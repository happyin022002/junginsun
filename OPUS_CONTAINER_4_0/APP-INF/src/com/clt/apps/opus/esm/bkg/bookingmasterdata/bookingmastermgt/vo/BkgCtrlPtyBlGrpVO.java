/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BkgCtrlPtyBlGrpVO.java
*@FileTitle : BkgCtrlPtyBlGrpVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.31
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.31  
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo;

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
public class BkgCtrlPtyBlGrpVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<BkgCtrlPtyBlGrpVO> models = new ArrayList<BkgCtrlPtyBlGrpVO>();

    /* Column Info */
    private String wblPrfFlg = null;

    /* Column Info */
    private String oblPrfFlg = null;

    /* Column Info */
    private String blGrpSeq = null;

    /* Column Info */
    private String oblPrnFlg = null;

    /* Column Info */
    private String ntfyPrfFlg = null;

    /* Column Info */
    private String wblPrnFlg = null;

    /* Column Info */
    private String blVwRtTpCd = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String nonNegoPrnFlg = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String ctrlPtySeq = null;

    /* Column Info */
    private String ntfyPrnFlg = null;

    /* Column Info */
    private String blVwRtTpCd1 = null;

    /* Column Info */
    private String blGrpNm = null;

    /* Column Info */
    private String rowIdx = null;

    /* Column Info */
    private String blVwRtTpCd4 = null;

    /* Column Info */
    private String blVwRtTpCd2 = null;

    /* Column Info */
    private String blVwRtTpCd3 = null;

    /* Column Info */
    private String ntfyAutoWblFlg = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String ftpSvrNm = null;

    /* Column Info */
    private String ftpSvrUsrNm = null;

    /* Column Info */
    private String ftpSvrPwd = null;

    /* Column Info */
    private String ftpSvrDirNm = null;

    /* Column Info */
    private String rtyKnt = null;

    /* Column Info */
    private String rtyItvalNo = null;

    /* Column Info */
    private String emlCustFlg = null;

    /* Column Info */
    private String emlCustAddr = null;

    /* Column Info */
    private String emlPdfFlg = null;

    /* Column Info */
    private String emlPdfAddr = null;

    /* Column Info */
    private String blTpCd = null;

    /* Column Info */
    private String altnDeFlg = null;

    /* Column Info */
    private String oldBlGrpSeq = null;
    private String xptFileNm = null;
    private String ftpDirCtnt = null;
    private String errNtcFlg = null;
    private String scsNtcFlg = null;
    private String ftpDirCtnt2 = null;
    private String ftpDirCtnt3 = null;
    private String ftpDirCtnt4 = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public BkgCtrlPtyBlGrpVO() {
    }

    public BkgCtrlPtyBlGrpVO(String ibflag, String pagerows, String ctrlPtySeq, String blGrpSeq, String blGrpNm, String blVwRtTpCd1, String blVwRtTpCd2, String blVwRtTpCd3, String blVwRtTpCd4, String blVwRtTpCd, String oblPrfFlg, String wblPrfFlg, String oblPrnFlg, String wblPrnFlg, String nonNegoPrnFlg, String ntfyPrfFlg, String ntfyPrnFlg, String ntfyAutoWblFlg, String rowIdx, String updUsrId, String updDt, String ftpSvrNm, String ftpSvrUsrNm, String ftpSvrPwd, String ftpSvrDirNm, String rtyKnt, String rtyItvalNo, String emlCustFlg, String emlCustAddr, String emlPdfFlg, String emlPdfAddr, String blTpCd, String altnDeFlg, String oldBlGrpSeq, String xptFileNm, String ftpDirCtnt, String errNtcFlg, String scsNtcFlg, String ftpDirCtnt2,String ftpDirCtnt3,String ftpDirCtnt4) {
        this.wblPrfFlg = wblPrfFlg;
        this.oblPrfFlg = oblPrfFlg;
        this.blGrpSeq = blGrpSeq;
        this.oblPrnFlg = oblPrnFlg;
        this.ntfyPrfFlg = ntfyPrfFlg;
        this.wblPrnFlg = wblPrnFlg;
        this.blVwRtTpCd = blVwRtTpCd;
        this.pagerows = pagerows;
        this.nonNegoPrnFlg = nonNegoPrnFlg;
        this.ibflag = ibflag;
        this.ctrlPtySeq = ctrlPtySeq;
        this.ntfyPrnFlg = ntfyPrnFlg;
        this.blVwRtTpCd1 = blVwRtTpCd1;
        this.blGrpNm = blGrpNm;
        this.rowIdx = rowIdx;
        this.blVwRtTpCd4 = blVwRtTpCd4;
        this.blVwRtTpCd2 = blVwRtTpCd2;
        this.blVwRtTpCd3 = blVwRtTpCd3;
        this.ntfyAutoWblFlg = ntfyAutoWblFlg;
        this.updUsrId = updUsrId;
        this.updDt = updDt;
        this.ftpSvrNm = ftpSvrNm;
        this.ftpSvrUsrNm = ftpSvrUsrNm;
        this.ftpSvrPwd = ftpSvrPwd;
        this.ftpSvrDirNm = ftpSvrDirNm;
        this.rtyKnt = rtyKnt;
        this.rtyItvalNo = rtyItvalNo;
        this.emlCustFlg = emlCustFlg;
        this.emlCustAddr = emlCustAddr;
        this.emlPdfFlg = emlPdfFlg;
        this.emlPdfAddr = emlPdfAddr;
        this.blTpCd = blTpCd;
        this.altnDeFlg = altnDeFlg;
        this.oldBlGrpSeq = oldBlGrpSeq;
        this.xptFileNm = xptFileNm;
        this.ftpDirCtnt = ftpDirCtnt;
        this.errNtcFlg = errNtcFlg;
        this.scsNtcFlg = scsNtcFlg;
        this.ftpDirCtnt2 = ftpDirCtnt2;
        this.ftpDirCtnt3 = ftpDirCtnt3;
        this.ftpDirCtnt4 = ftpDirCtnt4;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("wbl_prf_flg", getWblPrfFlg());
        this.hashColumns.put("obl_prf_flg", getOblPrfFlg());
        this.hashColumns.put("bl_grp_seq", getBlGrpSeq());
        this.hashColumns.put("obl_prn_flg", getOblPrnFlg());
        this.hashColumns.put("ntfy_prf_flg", getNtfyPrfFlg());
        this.hashColumns.put("wbl_prn_flg", getWblPrnFlg());
        this.hashColumns.put("bl_vw_rt_tp_cd", getBlVwRtTpCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("non_nego_prn_flg", getNonNegoPrnFlg());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("ctrl_pty_seq", getCtrlPtySeq());
        this.hashColumns.put("ntfy_prn_flg", getNtfyPrnFlg());
        this.hashColumns.put("bl_vw_rt_tp_cd1", getBlVwRtTpCd1());
        this.hashColumns.put("bl_grp_nm", getBlGrpNm());
        this.hashColumns.put("row_idx", getRowIdx());
        this.hashColumns.put("bl_vw_rt_tp_cd4", getBlVwRtTpCd4());
        this.hashColumns.put("bl_vw_rt_tp_cd2", getBlVwRtTpCd2());
        this.hashColumns.put("bl_vw_rt_tp_cd3", getBlVwRtTpCd3());
        this.hashColumns.put("ntfy_auto_wbl_flg", getNtfyAutoWblFlg());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("ftp_svr_nm", getFtpSvrNm());
        this.hashColumns.put("ftp_svr_usr_nm", getFtpSvrUsrNm());
        this.hashColumns.put("ftp_svr_pwd", getFtpSvrPwd());
        this.hashColumns.put("ftp_svr_dir_nm", getFtpSvrDirNm());
        this.hashColumns.put("rty_knt", getRtyKnt());
        this.hashColumns.put("rty_itval_no", getRtyItvalNo());
        this.hashColumns.put("eml_cust_flg", getEmlCustFlg());
        this.hashColumns.put("eml_cust_addr", getEmlCustAddr());
        this.hashColumns.put("eml_pdf_flg", getEmlPdfFlg());
        this.hashColumns.put("eml_pdf_addr", getEmlPdfAddr());
        this.hashColumns.put("bl_tp_cd", getBlTpCd());
        this.hashColumns.put("altn_de_flg", getAltnDeFlg());
        this.hashColumns.put("old_bl_grp_seq", getOldBlGrpSeq());
        this.hashColumns.put("xpt_file_nm", getXptFileNm());
        this.hashColumns.put("ftp_dir_ctnt", getFtpDirCtnt());
        this.hashColumns.put("err_ntc_flg", getErrNtcFlg());
        this.hashColumns.put("scs_ntc_flg", getScsNtcFlg());
        this.hashColumns.put("ftp_dir_ctnt2", getFtpDirCtnt2());
        this.hashColumns.put("ftp_dir_ctnt3", getFtpDirCtnt3());
        this.hashColumns.put("ftp_dir_ctnt4", getFtpDirCtnt4());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("wbl_prf_flg", "wblPrfFlg");
        this.hashFields.put("obl_prf_flg", "oblPrfFlg");
        this.hashFields.put("bl_grp_seq", "blGrpSeq");
        this.hashFields.put("obl_prn_flg", "oblPrnFlg");
        this.hashFields.put("ntfy_prf_flg", "ntfyPrfFlg");
        this.hashFields.put("wbl_prn_flg", "wblPrnFlg");
        this.hashFields.put("bl_vw_rt_tp_cd", "blVwRtTpCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("non_nego_prn_flg", "nonNegoPrnFlg");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("ctrl_pty_seq", "ctrlPtySeq");
        this.hashFields.put("ntfy_prn_flg", "ntfyPrnFlg");
        this.hashFields.put("bl_vw_rt_tp_cd1", "blVwRtTpCd1");
        this.hashFields.put("bl_grp_nm", "blGrpNm");
        this.hashFields.put("row_idx", "rowIdx");
        this.hashFields.put("bl_vw_rt_tp_cd4", "blVwRtTpCd4");
        this.hashFields.put("bl_vw_rt_tp_cd2", "blVwRtTpCd2");
        this.hashFields.put("bl_vw_rt_tp_cd3", "blVwRtTpCd3");
        this.hashFields.put("ntfy_auto_wbl_flg", "ntfyAutoWblFlg");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("ftp_svr_nm", "ftpSvrNm");
        this.hashFields.put("ftp_svr_usr_nm", "ftpSvrUsrNm");
        this.hashFields.put("ftp_svr_pwd", "ftpSvrPwd");
        this.hashFields.put("ftp_svr_dir_nm", "ftpSvrDirNm");
        this.hashFields.put("rty_knt", "rtyKnt");
        this.hashFields.put("rty_itval_no", "rtyItvalNo");
        this.hashFields.put("eml_cust_flg", "emlCustFlg");
        this.hashFields.put("eml_cust_addr", "emlCustAddr");
        this.hashFields.put("eml_pdf_flg", "emlPdfFlg");
        this.hashFields.put("eml_pdf_addr", "emlPdfAddr");
        this.hashFields.put("bl_tp_cd", "blTpCd");
        this.hashFields.put("altn_de_flg", "altnDeFlg");
        this.hashFields.put("old_bl_grp_seq", "oldBlGrpSeq");
        this.hashFields.put("xpt_file_nm", "xptFileNm");
        this.hashFields.put("ftp_dir_ctnt", "ftpDirCtnt");
        this.hashFields.put("err_ntc_flg", "errNtcFlg");
        this.hashFields.put("scs_ntc_flg", "scsNtcFlg");
        this.hashFields.put("ftp_dir_ctnt2", "ftpDirCtnt2");
        this.hashFields.put("ftp_dir_ctnt3", "ftpDirCtnt3");
        this.hashFields.put("ftp_dir_ctnt4", "ftpDirCtnt4");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return wblPrfFlg
	 */
    public String getWblPrfFlg() {
        return this.wblPrfFlg;
    }

    /**
	 * Column Info
	 * @return oblPrfFlg
	 */
    public String getOblPrfFlg() {
        return this.oblPrfFlg;
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
	 * @return oblPrnFlg
	 */
    public String getOblPrnFlg() {
        return this.oblPrnFlg;
    }

    /**
	 * Column Info
	 * @return ntfyPrfFlg
	 */
    public String getNtfyPrfFlg() {
        return this.ntfyPrfFlg;
    }

    /**
	 * Column Info
	 * @return wblPrnFlg
	 */
    public String getWblPrnFlg() {
        return this.wblPrnFlg;
    }

    /**
	 * Column Info
	 * @return blVwRtTpCd
	 */
    public String getBlVwRtTpCd() {
        return this.blVwRtTpCd;
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
	 * @return nonNegoPrnFlg
	 */
    public String getNonNegoPrnFlg() {
        return this.nonNegoPrnFlg;
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
	 * @return ntfyPrnFlg
	 */
    public String getNtfyPrnFlg() {
        return this.ntfyPrnFlg;
    }

    /**
	 * Column Info
	 * @return blVwRtTpCd1
	 */
    public String getBlVwRtTpCd1() {
        return this.blVwRtTpCd1;
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
	 * Column Info
	 * @return blVwRtTpCd4
	 */
    public String getBlVwRtTpCd4() {
        return this.blVwRtTpCd4;
    }

    /**
	 * Column Info
	 * @return blVwRtTpCd2
	 */
    public String getBlVwRtTpCd2() {
        return this.blVwRtTpCd2;
    }

    /**
	 * Column Info
	 * @return blVwRtTpCd3
	 */
    public String getBlVwRtTpCd3() {
        return this.blVwRtTpCd3;
    }

    /**
	 * Column Info
	 * @return ntfyAutoWblFlg
	 */
    public String getNtfyAutoWblFlg() {
        return this.ntfyAutoWblFlg;
    }

    /**
	 * Column Info
	 * @param wblPrfFlg
	 */
    public void setWblPrfFlg(String wblPrfFlg) {
        this.wblPrfFlg = wblPrfFlg;
    }

    /**
	 * Column Info
	 * @param oblPrfFlg
	 */
    public void setOblPrfFlg(String oblPrfFlg) {
        this.oblPrfFlg = oblPrfFlg;
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
	 * @param oblPrnFlg
	 */
    public void setOblPrnFlg(String oblPrnFlg) {
        this.oblPrnFlg = oblPrnFlg;
    }

    /**
	 * Column Info
	 * @param ntfyPrfFlg
	 */
    public void setNtfyPrfFlg(String ntfyPrfFlg) {
        this.ntfyPrfFlg = ntfyPrfFlg;
    }

    /**
	 * Column Info
	 * @param wblPrnFlg
	 */
    public void setWblPrnFlg(String wblPrnFlg) {
        this.wblPrnFlg = wblPrnFlg;
    }

    /**
	 * Column Info
	 * @param blVwRtTpCd
	 */
    public void setBlVwRtTpCd(String blVwRtTpCd) {
        this.blVwRtTpCd = blVwRtTpCd;
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
	 * @param nonNegoPrnFlg
	 */
    public void setNonNegoPrnFlg(String nonNegoPrnFlg) {
        this.nonNegoPrnFlg = nonNegoPrnFlg;
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
	 * @param ntfyPrnFlg
	 */
    public void setNtfyPrnFlg(String ntfyPrnFlg) {
        this.ntfyPrnFlg = ntfyPrnFlg;
    }

    /**
	 * Column Info
	 * @param blVwRtTpCd1
	 */
    public void setBlVwRtTpCd1(String blVwRtTpCd1) {
        this.blVwRtTpCd1 = blVwRtTpCd1;
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
	 * Column Info
	 * @param blVwRtTpCd4
	 */
    public void setBlVwRtTpCd4(String blVwRtTpCd4) {
        this.blVwRtTpCd4 = blVwRtTpCd4;
    }

    /**
	 * Column Info
	 * @param blVwRtTpCd2
	 */
    public void setBlVwRtTpCd2(String blVwRtTpCd2) {
        this.blVwRtTpCd2 = blVwRtTpCd2;
    }

    /**
	 * Column Info
	 * @param blVwRtTpCd3
	 */
    public void setBlVwRtTpCd3(String blVwRtTpCd3) {
        this.blVwRtTpCd3 = blVwRtTpCd3;
    }

    /**
	 * Column Info
	 * @param ntfyAutoWblFlg
	 */
    public void setNtfyAutoWblFlg(String ntfyAutoWblFlg) {
        this.ntfyAutoWblFlg = ntfyAutoWblFlg;
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

    public void setFtpSvrNm(String ftpSvrNm) {
        this.ftpSvrNm = ftpSvrNm;
    }

    public String getFtpSvrNm() {
        return this.ftpSvrNm;
    }

    public void setFtpSvrUsrNm(String ftpSvrUsrNm) {
        this.ftpSvrUsrNm = ftpSvrUsrNm;
    }

    public String getFtpSvrUsrNm() {
        return this.ftpSvrUsrNm;
    }

    public void setFtpSvrPwd(String ftpSvrPwd) {
        this.ftpSvrPwd = ftpSvrPwd;
    }

    public String getFtpSvrPwd() {
        return this.ftpSvrPwd;
    }

    public void setFtpSvrDirNm(String ftpSvrDirNm) {
        this.ftpSvrDirNm = ftpSvrDirNm;
    }

    public String getFtpSvrDirNm() {
        return this.ftpSvrDirNm;
    }

    public void setRtyKnt(String rtyKnt) {
        this.rtyKnt = rtyKnt;
    }

    public String getRtyKnt() {
        return this.rtyKnt;
    }

    public void setRtyItvalNo(String rtyItvalNo) {
        this.rtyItvalNo = rtyItvalNo;
    }

    public String getRtyItvalNo() {
        return this.rtyItvalNo;
    }

    public void setEmlCustFlg(String emlCustFlg) {
        this.emlCustFlg = emlCustFlg;
    }

    public String getEmlCustFlg() {
        return this.emlCustFlg;
    }

    public void setEmlCustAddr(String emlCustAddr) {
        this.emlCustAddr = emlCustAddr;
    }

    public String getEmlCustAddr() {
        return this.emlCustAddr;
    }

    public void setEmlPdfFlg(String emlPdfFlg) {
        this.emlPdfFlg = emlPdfFlg;
    }

    public String getEmlPdfFlg() {
        return this.emlPdfFlg;
    }

    public void setEmlPdfAddr(String emlPdfAddr) {
        this.emlPdfAddr = emlPdfAddr;
    }

    public String getEmlPdfAddr() {
        return this.emlPdfAddr;
    }

    public void setBlTpCd(String blTpCd) {
        this.blTpCd = blTpCd;
    }

    public String getBlTpCd() {
        return this.blTpCd;
    }

    public void setAltnDeFlg(String altnDeFlg) {
        this.altnDeFlg = altnDeFlg;
    }

    public String getAltnDeFlg() {
        return this.altnDeFlg;
    }

    public void setOldBlGrpSeq(String oldBlGrpSeq) {
        this.oldBlGrpSeq = oldBlGrpSeq;
    }

    public String getOldBlGrpSeq() {
        return this.oldBlGrpSeq;
    }
	public final String getXptFileNm() {
		return xptFileNm;
	}

	public final void setXptFileNm(String xptFileNm) {
		this.xptFileNm = xptFileNm;
	}

	public final String getFtpDirCtnt() {
		return ftpDirCtnt;
	}

	public final void setFtpDirCtnt(String ftpDirCtnt) {
		this.ftpDirCtnt = ftpDirCtnt;
	}

	public final String getErrNtcFlg() {
		return errNtcFlg;
	}

	public final void setErrNtcFlg(String errNtcFlg) {
		this.errNtcFlg = errNtcFlg;
	}

	public final String getScsNtcFlg() {
		return scsNtcFlg;
	}

	public final void setScsNtcFlg(String scsNtcFlg) {
		this.scsNtcFlg = scsNtcFlg;
	}
	public String getFtpDirCtnt2() {
		return ftpDirCtnt2;
	}

	public void setFtpDirCtnt2(String ftpDirCtnt2) {
		this.ftpDirCtnt2 = ftpDirCtnt2;
	}

	public String getFtpDirCtnt3() {
		return ftpDirCtnt3;
	}

	public void setFtpDirCtnt3(String ftpDirCtnt3) {
		this.ftpDirCtnt3 = ftpDirCtnt3;
	}

	public String getFtpDirCtnt4() {
		return ftpDirCtnt4;
	}

	public void setFtpDirCtnt4(String ftpDirCtnt4) {
		this.ftpDirCtnt4 = ftpDirCtnt4;
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
        setWblPrfFlg(JSPUtil.getParameter(request, prefix + "wbl_prf_flg", ""));
        setOblPrfFlg(JSPUtil.getParameter(request, prefix + "obl_prf_flg", ""));
        setBlGrpSeq(JSPUtil.getParameter(request, prefix + "bl_grp_seq", ""));
        setOblPrnFlg(JSPUtil.getParameter(request, prefix + "obl_prn_flg", ""));
        setNtfyPrfFlg(JSPUtil.getParameter(request, prefix + "ntfy_prf_flg", ""));
        setWblPrnFlg(JSPUtil.getParameter(request, prefix + "wbl_prn_flg", ""));
        setBlVwRtTpCd(JSPUtil.getParameter(request, prefix + "bl_vw_rt_tp_cd", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setNonNegoPrnFlg(JSPUtil.getParameter(request, prefix + "non_nego_prn_flg", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setCtrlPtySeq(JSPUtil.getParameter(request, prefix + "ctrl_pty_seq", ""));
        setNtfyPrnFlg(JSPUtil.getParameter(request, prefix + "ntfy_prn_flg", ""));
        setBlVwRtTpCd1(JSPUtil.getParameter(request, prefix + "bl_vw_rt_tp_cd1", ""));
        setBlGrpNm(JSPUtil.getParameter(request, prefix + "bl_grp_nm", ""));
        setRowIdx(JSPUtil.getParameter(request, prefix + "row_idx", ""));
        setBlVwRtTpCd4(JSPUtil.getParameter(request, prefix + "bl_vw_rt_tp_cd4", ""));
        setBlVwRtTpCd2(JSPUtil.getParameter(request, prefix + "bl_vw_rt_tp_cd2", ""));
        setBlVwRtTpCd3(JSPUtil.getParameter(request, prefix + "bl_vw_rt_tp_cd3", ""));
        setNtfyAutoWblFlg(JSPUtil.getParameter(request, prefix + "ntfy_auto_wbl_flg", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setFtpSvrNm(JSPUtil.getParameter(request, prefix + "ftp_svr_nm", ""));
        setFtpSvrUsrNm(JSPUtil.getParameter(request, prefix + "ftp_svr_usr_nm", ""));
        setFtpSvrPwd(JSPUtil.getParameter(request, prefix + "ftp_svr_pwd", ""));
        setFtpSvrDirNm(JSPUtil.getParameter(request, prefix + "ftp_svr_dir_nm", ""));
        setRtyKnt(JSPUtil.getParameter(request, prefix + "rty_knt", ""));
        setRtyItvalNo(JSPUtil.getParameter(request, prefix + "rty_itval_no", ""));
        setEmlCustFlg(JSPUtil.getParameter(request, prefix + "eml_cust_flg", ""));
        setEmlCustAddr(JSPUtil.getParameter(request, prefix + "eml_cust_addr", ""));
        setEmlPdfFlg(JSPUtil.getParameter(request, prefix + "eml_pdf_flg", ""));
        setEmlPdfAddr(JSPUtil.getParameter(request, prefix + "eml_pdf_addr", ""));
        setBlTpCd(JSPUtil.getParameter(request, prefix + "bl_tp_cd", ""));
        setAltnDeFlg(JSPUtil.getParameter(request, prefix + "altn_de_flg", ""));
        setOldBlGrpSeq(JSPUtil.getParameter(request, prefix + "old_bl_grp_seq", ""));
        setXptFileNm(JSPUtil.getParameter(request, prefix + "xpt_file_nm", ""));
        setFtpDirCtnt(JSPUtil.getParameter(request, prefix + "ftp_dir_ctnt", ""));
        setErrNtcFlg(JSPUtil.getParameter(request, prefix + "err_ntc_flg", ""));
        setScsNtcFlg(JSPUtil.getParameter(request, prefix + "scs_ntc_flg", ""));
        setFtpDirCtnt2(JSPUtil.getParameter(request, prefix + "ftp_dir_ctnt2", ""));
        setFtpDirCtnt3(JSPUtil.getParameter(request, prefix + "ftp_dir_ctnt3", ""));
        setFtpDirCtnt4(JSPUtil.getParameter(request, prefix + "ftp_dir_ctnt4", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCtrlPtyBlGrpVO[]
	 */
    public BkgCtrlPtyBlGrpVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgCtrlPtyBlGrpVO[]
	 */
    public BkgCtrlPtyBlGrpVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        BkgCtrlPtyBlGrpVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] wblPrfFlg = (JSPUtil.getParameter(request, prefix + "wbl_prf_flg", length));
            String[] oblPrfFlg = (JSPUtil.getParameter(request, prefix + "obl_prf_flg", length));
            String[] blGrpSeq = (JSPUtil.getParameter(request, prefix + "bl_grp_seq", length));
            String[] oblPrnFlg = (JSPUtil.getParameter(request, prefix + "obl_prn_flg", length));
            String[] ntfyPrfFlg = (JSPUtil.getParameter(request, prefix + "ntfy_prf_flg", length));
            String[] wblPrnFlg = (JSPUtil.getParameter(request, prefix + "wbl_prn_flg", length));
            String[] blVwRtTpCd = (JSPUtil.getParameter(request, prefix + "bl_vw_rt_tp_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] nonNegoPrnFlg = (JSPUtil.getParameter(request, prefix + "non_nego_prn_flg", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] ctrlPtySeq = (JSPUtil.getParameter(request, prefix + "ctrl_pty_seq", length));
            String[] ntfyPrnFlg = (JSPUtil.getParameter(request, prefix + "ntfy_prn_flg", length));
            String[] blVwRtTpCd1 = (JSPUtil.getParameter(request, prefix + "bl_vw_rt_tp_cd1", length));
            String[] blGrpNm = (JSPUtil.getParameter(request, prefix + "bl_grp_nm", length));
            String[] rowIdx = (JSPUtil.getParameter(request, prefix + "row_idx", length));
            String[] blVwRtTpCd4 = (JSPUtil.getParameter(request, prefix + "bl_vw_rt_tp_cd4", length));
            String[] blVwRtTpCd2 = (JSPUtil.getParameter(request, prefix + "bl_vw_rt_tp_cd2", length));
            String[] blVwRtTpCd3 = (JSPUtil.getParameter(request, prefix + "bl_vw_rt_tp_cd3", length));
            String[] ntfyAutoWblFlg = (JSPUtil.getParameter(request, prefix + "ntfy_auto_wbl_flg", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] ftpSvrNm = (JSPUtil.getParameter(request, prefix + "ftp_svr_nm", length));
            String[] ftpSvrUsrNm = (JSPUtil.getParameter(request, prefix + "ftp_svr_usr_nm", length));
            String[] ftpSvrPwd = (JSPUtil.getParameter(request, prefix + "ftp_svr_pwd", length));
            String[] ftpSvrDirNm = (JSPUtil.getParameter(request, prefix + "ftp_svr_dir_nm", length));
            String[] rtyKnt = (JSPUtil.getParameter(request, prefix + "rty_knt", length));
            String[] rtyItvalNo = (JSPUtil.getParameter(request, prefix + "rty_itval_no", length));
            String[] emlCustFlg = (JSPUtil.getParameter(request, prefix + "eml_cust_flg", length));
            String[] emlCustAddr = (JSPUtil.getParameter(request, prefix + "eml_cust_addr", length));
            String[] emlPdfFlg = (JSPUtil.getParameter(request, prefix + "eml_pdf_flg", length));
            String[] emlPdfAddr = (JSPUtil.getParameter(request, prefix + "eml_pdf_addr", length));
            String[] blTpCd = (JSPUtil.getParameter(request, prefix + "bl_tp_cd", length));
            String[] altnDeFlg = (JSPUtil.getParameter(request, prefix + "altn_de_flg", length));
            String[] oldBlGrpSeq = (JSPUtil.getParameter(request, prefix + "old_bl_grp_seq", length));
            String[] xptFileNm = (JSPUtil.getParameter(request, prefix + "xpt_file_nm", length));
            String[] ftpDirCtnt = (JSPUtil.getParameter(request, prefix + "ftp_dir_ctnt", length));
            String[] errNtcFlg = (JSPUtil.getParameter(request, prefix + "err_ntc_flg", length));
            String[] scsNtcFlg = (JSPUtil.getParameter(request, prefix + "scs_ntc_flg", length));
            String[] ftpDirCtnt2 = (JSPUtil.getParameter(request, prefix + "ftp_dir_ctnt2", length));
            String[] ftpDirCtnt3 = (JSPUtil.getParameter(request, prefix + "ftp_dir_ctnt3", length));
            String[] ftpDirCtnt4 = (JSPUtil.getParameter(request, prefix + "ftp_dir_ctnt4", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new BkgCtrlPtyBlGrpVO();
                if (wblPrfFlg[i] != null)
                    model.setWblPrfFlg(wblPrfFlg[i]);
                if (oblPrfFlg[i] != null)
                    model.setOblPrfFlg(oblPrfFlg[i]);
                if (blGrpSeq[i] != null)
                    model.setBlGrpSeq(blGrpSeq[i]);
                if (oblPrnFlg[i] != null)
                    model.setOblPrnFlg(oblPrnFlg[i]);
                if (ntfyPrfFlg[i] != null)
                    model.setNtfyPrfFlg(ntfyPrfFlg[i]);
                if (wblPrnFlg[i] != null)
                    model.setWblPrnFlg(wblPrnFlg[i]);
                if (blVwRtTpCd[i] != null)
                    model.setBlVwRtTpCd(blVwRtTpCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (nonNegoPrnFlg[i] != null)
                    model.setNonNegoPrnFlg(nonNegoPrnFlg[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (ctrlPtySeq[i] != null)
                    model.setCtrlPtySeq(ctrlPtySeq[i]);
                if (ntfyPrnFlg[i] != null)
                    model.setNtfyPrnFlg(ntfyPrnFlg[i]);
                if (blVwRtTpCd1[i] != null)
                    model.setBlVwRtTpCd1(blVwRtTpCd1[i]);
                if (blGrpNm[i] != null)
                    model.setBlGrpNm(blGrpNm[i]);
                if (rowIdx[i] != null)
                    model.setRowIdx(rowIdx[i]);
                if (blVwRtTpCd4[i] != null)
                    model.setBlVwRtTpCd4(blVwRtTpCd4[i]);
                if (blVwRtTpCd2[i] != null)
                    model.setBlVwRtTpCd2(blVwRtTpCd2[i]);
                if (blVwRtTpCd3[i] != null)
                    model.setBlVwRtTpCd3(blVwRtTpCd3[i]);
                if (ntfyAutoWblFlg[i] != null)
                    model.setNtfyAutoWblFlg(ntfyAutoWblFlg[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (ftpSvrNm[i] != null)
                    model.setFtpSvrNm(ftpSvrNm[i]);
                if (ftpSvrUsrNm[i] != null)
                    model.setFtpSvrUsrNm(ftpSvrUsrNm[i]);
                if (ftpSvrPwd[i] != null)
                    model.setFtpSvrPwd(ftpSvrPwd[i]);
                if (ftpSvrDirNm[i] != null)
                    model.setFtpSvrDirNm(ftpSvrDirNm[i]);
                if (rtyKnt[i] != null)
                    model.setRtyKnt(rtyKnt[i]);
                if (rtyItvalNo[i] != null)
                    model.setRtyItvalNo(rtyItvalNo[i]);
                if (emlCustFlg[i] != null)
                    model.setEmlCustFlg(emlCustFlg[i]);
                if (emlCustAddr[i] != null)
                    model.setEmlCustAddr(emlCustAddr[i]);
                if (emlPdfFlg[i] != null)
                    model.setEmlPdfFlg(emlPdfFlg[i]);
                if (emlPdfAddr[i] != null)
                    model.setEmlPdfAddr(emlPdfAddr[i]);
                if (blTpCd[i] != null)
                    model.setBlTpCd(blTpCd[i]);
                if (altnDeFlg[i] != null)
                    model.setAltnDeFlg(altnDeFlg[i]);
                if (oldBlGrpSeq[i] != null) 
		    		model.setOldBlGrpSeq(oldBlGrpSeq[i]);
                if (xptFileNm[i] != null) 
		    		model.setXptFileNm(xptFileNm[i]);
                if (ftpDirCtnt[i] != null) 
		    		model.setFtpDirCtnt(ftpDirCtnt[i]);
                if (errNtcFlg[i] != null) 
		    		model.setErrNtcFlg(errNtcFlg[i]);
                if (scsNtcFlg[i] != null) 
		    		model.setScsNtcFlg(scsNtcFlg[i]);
                if (ftpDirCtnt2[i] != null) 
		    		model.setFtpDirCtnt2(ftpDirCtnt2[i]);
                if (ftpDirCtnt3[i] != null) 
		    		model.setFtpDirCtnt3(ftpDirCtnt3[i]);
                if (ftpDirCtnt4[i] != null) 
		    		model.setFtpDirCtnt4(ftpDirCtnt4[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getBkgCtrlPtyBlGrpVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return BkgCtrlPtyBlGrpVO[]
	 */
    public BkgCtrlPtyBlGrpVO[] getBkgCtrlPtyBlGrpVOs() {
        BkgCtrlPtyBlGrpVO[] vos = (BkgCtrlPtyBlGrpVO[]) models.toArray(new BkgCtrlPtyBlGrpVO[models.size()]);
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
        this.wblPrfFlg = this.wblPrfFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oblPrfFlg = this.oblPrfFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blGrpSeq = this.blGrpSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oblPrnFlg = this.oblPrnFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ntfyPrfFlg = this.ntfyPrfFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.wblPrnFlg = this.wblPrnFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blVwRtTpCd = this.blVwRtTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nonNegoPrnFlg = this.nonNegoPrnFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctrlPtySeq = this.ctrlPtySeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ntfyPrnFlg = this.ntfyPrnFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blVwRtTpCd1 = this.blVwRtTpCd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blGrpNm = this.blGrpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rowIdx = this.rowIdx.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blVwRtTpCd4 = this.blVwRtTpCd4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blVwRtTpCd2 = this.blVwRtTpCd2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blVwRtTpCd3 = this.blVwRtTpCd3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ntfyAutoWblFlg = this.ntfyAutoWblFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ftpSvrNm = this.ftpSvrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ftpSvrUsrNm = this.ftpSvrUsrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ftpSvrPwd = this.ftpSvrPwd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ftpSvrDirNm = this.ftpSvrDirNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtyKnt = this.rtyKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtyItvalNo = this.rtyItvalNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emlCustFlg = this.emlCustFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emlCustAddr = this.emlCustAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emlPdfFlg = this.emlPdfFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emlPdfAddr = this.emlPdfAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blTpCd = this.blTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.altnDeFlg = this.altnDeFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oldBlGrpSeq = this.oldBlGrpSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xptFileNm = this.xptFileNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ftpDirCtnt = this.ftpDirCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.errNtcFlg = this.errNtcFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.scsNtcFlg = this.scsNtcFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ftpDirCtnt2 = this.ftpDirCtnt2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ftpDirCtnt3 = this.ftpDirCtnt3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ftpDirCtnt4 = this.ftpDirCtnt4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
