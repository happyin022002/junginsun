/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CustAddrIfVO.java
*@FileTitle : CustAddrIfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo;

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
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class CustAddrIfVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<CustAddrIfVO> models = new ArrayList<CustAddrIfVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String custAddrIfSeq = null;

    /* Column Info */
    private String custCntCd = null;

    /* Column Info */
    private String custSeq = null;

    /* Column Info */
    private String addrTpCd = null;

    /* Column Info */
    private String addrSeq = null;

    /* Column Info */
    private String prmryChkFlg = null;

    /* Column Info */
    private String bzetNm = null;

    /* Column Info */
    private String bzetAddr = null;

    /* Column Info */
    private String ctyNm = null;

    /* Column Info */
    private String steCd = null;

    /* Column Info */
    private String zipCd = null;

    /* Column Info */
    private String cntcEml = null;

    /* Column Info */
    private String cntcPsonNm = null;

    /* Column Info */
    private String bzetRmk = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String deltFlg = null;

    /* Column Info */
    private String loclAddr1 = null;

    /* Column Info */
    private String loclAddr2 = null;

    /* Column Info */
    private String loclAddr3 = null;

    /* Column Info */
    private String loclAddr4 = null;

    /* Column Info */
    private String cntCd = null;

    /* Column Info */
    private String r3InsfId = null;

    /* Column Info */
    private String r3InsfPrsId = null;

    /* Column Info */
    private String r3InsfDttm = null;

    /* Column Info */
    private String r3InsfCnqeVal = null;

    /* Column Info */
    private String r3InsfDvCd = null;

    /* Column Info */
    private String r3InsfCnqeCont = null;

    /* Column Info */
    private String ecomInsfId = null;

    /* Column Info */
    private String ecomInsfPrsId = null;

    /* Column Info */
    private String ecomInsfDttm = null;

    /* Column Info */
    private String ecomInsfCnqeVal = null;

    /* Column Info */
    private String ecomInsfDvCd = null;

    /* Column Info */
    private String ecomInsfCnqeCont = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public CustAddrIfVO() {
    }

    public CustAddrIfVO(String ibflag, String pagerows, String custAddrIfSeq, String custCntCd, String custSeq, String addrTpCd, String addrSeq, String prmryChkFlg, String bzetNm, String bzetAddr, String ctyNm, String steCd, String zipCd, String cntcEml, String cntcPsonNm, String bzetRmk, String creUsrId, String creDt, String updUsrId, String updDt, String deltFlg, String loclAddr1, String loclAddr2, String loclAddr3, String loclAddr4, String cntCd, String r3InsfId, String r3InsfPrsId, String r3InsfDttm, String r3InsfCnqeVal, String r3InsfDvCd, String r3InsfCnqeCont, String ecomInsfId, String ecomInsfPrsId, String ecomInsfDttm, String ecomInsfCnqeVal, String ecomInsfDvCd, String ecomInsfCnqeCont) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.custAddrIfSeq = custAddrIfSeq;
        this.custCntCd = custCntCd;
        this.custSeq = custSeq;
        this.addrTpCd = addrTpCd;
        this.addrSeq = addrSeq;
        this.prmryChkFlg = prmryChkFlg;
        this.bzetNm = bzetNm;
        this.bzetAddr = bzetAddr;
        this.ctyNm = ctyNm;
        this.steCd = steCd;
        this.zipCd = zipCd;
        this.cntcEml = cntcEml;
        this.cntcPsonNm = cntcPsonNm;
        this.bzetRmk = bzetRmk;
        this.creUsrId = creUsrId;
        this.creDt = creDt;
        this.updUsrId = updUsrId;
        this.updDt = updDt;
        this.deltFlg = deltFlg;
        this.loclAddr1 = loclAddr1;
        this.loclAddr2 = loclAddr2;
        this.loclAddr3 = loclAddr3;
        this.loclAddr4 = loclAddr4;
        this.cntCd = cntCd;
        this.r3InsfId = r3InsfId;
        this.r3InsfPrsId = r3InsfPrsId;
        this.r3InsfDttm = r3InsfDttm;
        this.r3InsfCnqeVal = r3InsfCnqeVal;
        this.r3InsfDvCd = r3InsfDvCd;
        this.r3InsfCnqeCont = r3InsfCnqeCont;
        this.ecomInsfId = ecomInsfId;
        this.ecomInsfPrsId = ecomInsfPrsId;
        this.ecomInsfDttm = ecomInsfDttm;
        this.ecomInsfCnqeVal = ecomInsfCnqeVal;
        this.ecomInsfDvCd = ecomInsfDvCd;
        this.ecomInsfCnqeCont = ecomInsfCnqeCont;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("cust_addr_if_seq", getCustAddrIfSeq());
        this.hashColumns.put("cust_cnt_cd", getCustCntCd());
        this.hashColumns.put("cust_seq", getCustSeq());
        this.hashColumns.put("addr_tp_cd", getAddrTpCd());
        this.hashColumns.put("addr_seq", getAddrSeq());
        this.hashColumns.put("prmry_chk_flg", getPrmryChkFlg());
        this.hashColumns.put("bzet_nm", getBzetNm());
        this.hashColumns.put("bzet_addr", getBzetAddr());
        this.hashColumns.put("cty_nm", getCtyNm());
        this.hashColumns.put("ste_cd", getSteCd());
        this.hashColumns.put("zip_cd", getZipCd());
        this.hashColumns.put("cntc_eml", getCntcEml());
        this.hashColumns.put("cntc_pson_nm", getCntcPsonNm());
        this.hashColumns.put("bzet_rmk", getBzetRmk());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("delt_flg", getDeltFlg());
        this.hashColumns.put("locl_addr1", getLoclAddr1());
        this.hashColumns.put("locl_addr2", getLoclAddr2());
        this.hashColumns.put("locl_addr3", getLoclAddr3());
        this.hashColumns.put("locl_addr4", getLoclAddr4());
        this.hashColumns.put("cnt_cd", getCntCd());
        this.hashColumns.put("r3_insf_id", getR3InsfId());
        this.hashColumns.put("r3_insf_prs_id", getR3InsfPrsId());
        this.hashColumns.put("r3_insf_dttm", getR3InsfDttm());
        this.hashColumns.put("r3_insf_cnqe_val", getR3InsfCnqeVal());
        this.hashColumns.put("r3_insf_dv_cd", getR3InsfDvCd());
        this.hashColumns.put("r3_insf_cnqe_cont", getR3InsfCnqeCont());
        this.hashColumns.put("ecom_insf_id", getEcomInsfId());
        this.hashColumns.put("ecom_insf_prs_id", getEcomInsfPrsId());
        this.hashColumns.put("ecom_insf_dttm", getEcomInsfDttm());
        this.hashColumns.put("ecom_insf_cnqe_val", getEcomInsfCnqeVal());
        this.hashColumns.put("ecom_insf_dv_cd", getEcomInsfDvCd());
        this.hashColumns.put("ecom_insf_cnqe_cont", getEcomInsfCnqeCont());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("cust_addr_if_seq", "custAddrIfSeq");
        this.hashFields.put("cust_cnt_cd", "custCntCd");
        this.hashFields.put("cust_seq", "custSeq");
        this.hashFields.put("addr_tp_cd", "addrTpCd");
        this.hashFields.put("addr_seq", "addrSeq");
        this.hashFields.put("prmry_chk_flg", "prmryChkFlg");
        this.hashFields.put("bzet_nm", "bzetNm");
        this.hashFields.put("bzet_addr", "bzetAddr");
        this.hashFields.put("cty_nm", "ctyNm");
        this.hashFields.put("ste_cd", "steCd");
        this.hashFields.put("zip_cd", "zipCd");
        this.hashFields.put("cntc_eml", "cntcEml");
        this.hashFields.put("cntc_pson_nm", "cntcPsonNm");
        this.hashFields.put("bzet_rmk", "bzetRmk");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("delt_flg", "deltFlg");
        this.hashFields.put("locl_addr1", "loclAddr1");
        this.hashFields.put("locl_addr2", "loclAddr2");
        this.hashFields.put("locl_addr3", "loclAddr3");
        this.hashFields.put("locl_addr4", "loclAddr4");
        this.hashFields.put("cnt_cd", "cntCd");
        this.hashFields.put("r3_insf_id", "r3InsfId");
        this.hashFields.put("r3_insf_prs_id", "r3InsfPrsId");
        this.hashFields.put("r3_insf_dttm", "r3InsfDttm");
        this.hashFields.put("r3_insf_cnqe_val", "r3InsfCnqeVal");
        this.hashFields.put("r3_insf_dv_cd", "r3InsfDvCd");
        this.hashFields.put("r3_insf_cnqe_cont", "r3InsfCnqeCont");
        this.hashFields.put("ecom_insf_id", "ecomInsfId");
        this.hashFields.put("ecom_insf_prs_id", "ecomInsfPrsId");
        this.hashFields.put("ecom_insf_dttm", "ecomInsfDttm");
        this.hashFields.put("ecom_insf_cnqe_val", "ecomInsfCnqeVal");
        this.hashFields.put("ecom_insf_dv_cd", "ecomInsfDvCd");
        this.hashFields.put("ecom_insf_cnqe_cont", "ecomInsfCnqeCont");
        return this.hashFields;
    }

    /**
	 *
	 * @param String ibflag
	 */
    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
    }

    /**
	 * 
	 * @return String ibflag
	 */
    public String getIbflag() {
        return this.ibflag;
    }

    /**
	 *
	 * @param String pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    /**
	 * 
	 * @return String pagerows
	 */
    public String getPagerows() {
        return this.pagerows;
    }

    /**
	 *
	 * @param String custAddrIfSeq
	 */
    public void setCustAddrIfSeq(String custAddrIfSeq) {
        this.custAddrIfSeq = custAddrIfSeq;
    }

    /**
	 * 
	 * @return String custAddrIfSeq
	 */
    public String getCustAddrIfSeq() {
        return this.custAddrIfSeq;
    }

    /**
	 *
	 * @param String custCntCd
	 */
    public void setCustCntCd(String custCntCd) {
        this.custCntCd = custCntCd;
    }

    /**
	 * 
	 * @return String custCntCd
	 */
    public String getCustCntCd() {
        return this.custCntCd;
    }

    /**
	 *
	 * @param String custSeq
	 */
    public void setCustSeq(String custSeq) {
        this.custSeq = custSeq;
    }

    /**
	 * 
	 * @return String custSeq
	 */
    public String getCustSeq() {
        return this.custSeq;
    }

    /**
	 *
	 * @param String addrTpCd
	 */
    public void setAddrTpCd(String addrTpCd) {
        this.addrTpCd = addrTpCd;
    }

    /**
	 * 
	 * @return String addrTpCd
	 */
    public String getAddrTpCd() {
        return this.addrTpCd;
    }

    /**
	 *
	 * @param String addrSeq
	 */
    public void setAddrSeq(String addrSeq) {
        this.addrSeq = addrSeq;
    }

    /**
	 * 
	 * @return String addrSeq
	 */
    public String getAddrSeq() {
        return this.addrSeq;
    }

    /**
	 *
	 * @param String prmryChkFlg
	 */
    public void setPrmryChkFlg(String prmryChkFlg) {
        this.prmryChkFlg = prmryChkFlg;
    }

    /**
	 * 
	 * @return String prmryChkFlg
	 */
    public String getPrmryChkFlg() {
        return this.prmryChkFlg;
    }

    /**
	 *
	 * @param String bzetNm
	 */
    public void setBzetNm(String bzetNm) {
        this.bzetNm = bzetNm;
    }

    /**
	 * 
	 * @return String bzetNm
	 */
    public String getBzetNm() {
        return this.bzetNm;
    }

    /**
	 *
	 * @param String bzetAddr
	 */
    public void setBzetAddr(String bzetAddr) {
        this.bzetAddr = bzetAddr;
    }

    /**
	 * 
	 * @return String bzetAddr
	 */
    public String getBzetAddr() {
        return this.bzetAddr;
    }

    /**
	 *
	 * @param String ctyNm
	 */
    public void setCtyNm(String ctyNm) {
        this.ctyNm = ctyNm;
    }

    /**
	 * 
	 * @return String ctyNm
	 */
    public String getCtyNm() {
        return this.ctyNm;
    }

    /**
	 *
	 * @param String steCd
	 */
    public void setSteCd(String steCd) {
        this.steCd = steCd;
    }

    /**
	 * 
	 * @return String steCd
	 */
    public String getSteCd() {
        return this.steCd;
    }

    /**
	 *
	 * @param String zipCd
	 */
    public void setZipCd(String zipCd) {
        this.zipCd = zipCd;
    }

    /**
	 * 
	 * @return String zipCd
	 */
    public String getZipCd() {
        return this.zipCd;
    }

    /**
	 *
	 * @param String cntcEml
	 */
    public void setCntcEml(String cntcEml) {
        this.cntcEml = cntcEml;
    }

    /**
	 * 
	 * @return String cntcEml
	 */
    public String getCntcEml() {
        return this.cntcEml;
    }

    /**
	 *
	 * @param String cntcPsonNm
	 */
    public void setCntcPsonNm(String cntcPsonNm) {
        this.cntcPsonNm = cntcPsonNm;
    }

    /**
	 * 
	 * @return String cntcPsonNm
	 */
    public String getCntcPsonNm() {
        return this.cntcPsonNm;
    }

    /**
	 *
	 * @param String bzetRmk
	 */
    public void setBzetRmk(String bzetRmk) {
        this.bzetRmk = bzetRmk;
    }

    /**
	 * 
	 * @return String bzetRmk
	 */
    public String getBzetRmk() {
        return this.bzetRmk;
    }

    /**
	 *
	 * @param String creUsrId
	 */
    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
    }

    /**
	 * 
	 * @return String creUsrId
	 */
    public String getCreUsrId() {
        return this.creUsrId;
    }

    /**
	 *
	 * @param String creDt
	 */
    public void setCreDt(String creDt) {
        this.creDt = creDt;
    }

    /**
	 * 
	 * @return String creDt
	 */
    public String getCreDt() {
        return this.creDt;
    }

    /**
	 *
	 * @param String updUsrId
	 */
    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
    }

    /**
	 * 
	 * @return String updUsrId
	 */
    public String getUpdUsrId() {
        return this.updUsrId;
    }

    /**
	 *
	 * @param String updDt
	 */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    /**
	 * 
	 * @return String updDt
	 */
    public String getUpdDt() {
        return this.updDt;
    }

    /**
	 *
	 * @param String deltFlg
	 */
    public void setDeltFlg(String deltFlg) {
        this.deltFlg = deltFlg;
    }

    /**
	 * 
	 * @return String deltFlg
	 */
    public String getDeltFlg() {
        return this.deltFlg;
    }

    /**
	 *
	 * @param String loclAddr1
	 */
    public void setLoclAddr1(String loclAddr1) {
        this.loclAddr1 = loclAddr1;
    }

    /**
	 * 
	 * @return String loclAddr1
	 */
    public String getLoclAddr1() {
        return this.loclAddr1;
    }

    /**
	 *
	 * @param String loclAddr2
	 */
    public void setLoclAddr2(String loclAddr2) {
        this.loclAddr2 = loclAddr2;
    }

    /**
	 * 
	 * @return String loclAddr2
	 */
    public String getLoclAddr2() {
        return this.loclAddr2;
    }

    /**
	 *
	 * @param String loclAddr3
	 */
    public void setLoclAddr3(String loclAddr3) {
        this.loclAddr3 = loclAddr3;
    }

    /**
	 * 
	 * @return String loclAddr3
	 */
    public String getLoclAddr3() {
        return this.loclAddr3;
    }

    /**
	 *
	 * @param String loclAddr4
	 */
    public void setLoclAddr4(String loclAddr4) {
        this.loclAddr4 = loclAddr4;
    }

    /**
	 * 
	 * @return String loclAddr4
	 */
    public String getLoclAddr4() {
        return this.loclAddr4;
    }

    /**
	 *
	 * @param String cntCd
	 */
    public void setCntCd(String cntCd) {
        this.cntCd = cntCd;
    }

    /**
	 * 
	 * @return String cntCd
	 */
    public String getCntCd() {
        return this.cntCd;
    }

    /**
	 *
	 * @param String r3InsfId
	 */
    public void setR3InsfId(String r3InsfId) {
        this.r3InsfId = r3InsfId;
    }

    /**
	 * 
	 * @return String r3InsfId
	 */
    public String getR3InsfId() {
        return this.r3InsfId;
    }

    /**
	 *
	 * @param String r3InsfPrsId
	 */
    public void setR3InsfPrsId(String r3InsfPrsId) {
        this.r3InsfPrsId = r3InsfPrsId;
    }

    /**
	 * 
	 * @return String r3InsfPrsId
	 */
    public String getR3InsfPrsId() {
        return this.r3InsfPrsId;
    }

    /**
	 *
	 * @param String r3InsfDttm
	 */
    public void setR3InsfDttm(String r3InsfDttm) {
        this.r3InsfDttm = r3InsfDttm;
    }

    /**
	 * 
	 * @return String r3InsfDttm
	 */
    public String getR3InsfDttm() {
        return this.r3InsfDttm;
    }

    /**
	 *
	 * @param String r3InsfCnqeVal
	 */
    public void setR3InsfCnqeVal(String r3InsfCnqeVal) {
        this.r3InsfCnqeVal = r3InsfCnqeVal;
    }

    /**
	 * 
	 * @return String r3InsfCnqeVal
	 */
    public String getR3InsfCnqeVal() {
        return this.r3InsfCnqeVal;
    }

    /**
	 *
	 * @param String r3InsfDvCd
	 */
    public void setR3InsfDvCd(String r3InsfDvCd) {
        this.r3InsfDvCd = r3InsfDvCd;
    }

    /**
	 * 
	 * @return String r3InsfDvCd
	 */
    public String getR3InsfDvCd() {
        return this.r3InsfDvCd;
    }

    /**
	 *
	 * @param String r3InsfCnqeCont
	 */
    public void setR3InsfCnqeCont(String r3InsfCnqeCont) {
        this.r3InsfCnqeCont = r3InsfCnqeCont;
    }

    /**
	 * 
	 * @return String r3InsfCnqeCont
	 */
    public String getR3InsfCnqeCont() {
        return this.r3InsfCnqeCont;
    }

    public void setEcomInsfId(String ecomInsfId) {
        this.ecomInsfId = ecomInsfId;
    }

    public String getEcomInsfId() {
        return this.ecomInsfId;
    }

    public void setEcomInsfPrsId(String ecomInsfPrsId) {
        this.ecomInsfPrsId = ecomInsfPrsId;
    }

    public String getEcomInsfPrsId() {
        return this.ecomInsfPrsId;
    }

    public void setEcomInsfDttm(String ecomInsfDttm) {
        this.ecomInsfDttm = ecomInsfDttm;
    }

    public String getEcomInsfDttm() {
        return this.ecomInsfDttm;
    }

    public void setEcomInsfCnqeVal(String ecomInsfCnqeVal) {
        this.ecomInsfCnqeVal = ecomInsfCnqeVal;
    }

    public String getEcomInsfCnqeVal() {
        return this.ecomInsfCnqeVal;
    }

    public void setEcomInsfDvCd(String ecomInsfDvCd) {
        this.ecomInsfDvCd = ecomInsfDvCd;
    }

    public String getEcomInsfDvCd() {
        return this.ecomInsfDvCd;
    }

    public void setEcomInsfCnqeCont(String ecomInsfCnqeCont) {
        this.ecomInsfCnqeCont = ecomInsfCnqeCont;
    }

    public String getEcomInsfCnqeCont() {
        return this.ecomInsfCnqeCont;
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
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setCustAddrIfSeq(JSPUtil.getParameter(request, prefix + "cust_addr_if_seq", ""));
        setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
        setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
        setAddrTpCd(JSPUtil.getParameter(request, prefix + "addr_tp_cd", ""));
        setAddrSeq(JSPUtil.getParameter(request, prefix + "addr_seq", ""));
        setPrmryChkFlg(JSPUtil.getParameter(request, prefix + "prmry_chk_flg", ""));
        setBzetNm(JSPUtil.getParameter(request, prefix + "bzet_nm", ""));
        setBzetAddr(JSPUtil.getParameter(request, prefix + "bzet_addr", ""));
        setCtyNm(JSPUtil.getParameter(request, prefix + "cty_nm", ""));
        setSteCd(JSPUtil.getParameter(request, prefix + "ste_cd", ""));
        setZipCd(JSPUtil.getParameter(request, prefix + "zip_cd", ""));
        setCntcEml(JSPUtil.getParameter(request, prefix + "cntc_eml", ""));
        setCntcPsonNm(JSPUtil.getParameter(request, prefix + "cntc_pson_nm", ""));
        setBzetRmk(JSPUtil.getParameter(request, prefix + "bzet_rmk", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
        setLoclAddr1(JSPUtil.getParameter(request, prefix + "locl_addr1", ""));
        setLoclAddr2(JSPUtil.getParameter(request, prefix + "locl_addr2", ""));
        setLoclAddr3(JSPUtil.getParameter(request, prefix + "locl_addr3", ""));
        setLoclAddr4(JSPUtil.getParameter(request, prefix + "locl_addr4", ""));
        setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
        setR3InsfId(JSPUtil.getParameter(request, prefix + "r3_insf_id", ""));
        setR3InsfPrsId(JSPUtil.getParameter(request, prefix + "r3_insf_prs_id", ""));
        setR3InsfDttm(JSPUtil.getParameter(request, prefix + "r3_insf_dttm", ""));
        setR3InsfCnqeVal(JSPUtil.getParameter(request, prefix + "r3_insf_cnqe_val", ""));
        setR3InsfDvCd(JSPUtil.getParameter(request, prefix + "r3_insf_dv_cd", ""));
        setR3InsfCnqeCont(JSPUtil.getParameter(request, prefix + "r3_insf_cnqe_cont", ""));
        setEcomInsfId(JSPUtil.getParameter(request, prefix + "ecom_insf_id", ""));
        setEcomInsfPrsId(JSPUtil.getParameter(request, prefix + "ecom_insf_prs_id", ""));
        setEcomInsfDttm(JSPUtil.getParameter(request, prefix + "ecom_insf_dttm", ""));
        setEcomInsfCnqeVal(JSPUtil.getParameter(request, prefix + "ecom_insf_cnqe_val", ""));
        setEcomInsfDvCd(JSPUtil.getParameter(request, prefix + "ecom_insf_dv_cd", ""));
        setEcomInsfCnqeCont(JSPUtil.getParameter(request, prefix + "ecom_insf_cnqe_cont", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustAddrIfVO[]
	 */
    public CustAddrIfVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustAddrIfVO[]
	 */
    public CustAddrIfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        CustAddrIfVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] custAddrIfSeq = (JSPUtil.getParameter(request, prefix + "cust_addr_if_seq", length));
            String[] custCntCd = (JSPUtil.getParameter(request, prefix + "cust_cnt_cd", length));
            String[] custSeq = (JSPUtil.getParameter(request, prefix + "cust_seq", length));
            String[] addrTpCd = (JSPUtil.getParameter(request, prefix + "addr_tp_cd", length));
            String[] addrSeq = (JSPUtil.getParameter(request, prefix + "addr_seq", length));
            String[] prmryChkFlg = (JSPUtil.getParameter(request, prefix + "prmry_chk_flg", length));
            String[] bzetNm = (JSPUtil.getParameter(request, prefix + "bzet_nm", length));
            String[] bzetAddr = (JSPUtil.getParameter(request, prefix + "bzet_addr", length));
            String[] ctyNm = (JSPUtil.getParameter(request, prefix + "cty_nm", length));
            String[] steCd = (JSPUtil.getParameter(request, prefix + "ste_cd", length));
            String[] zipCd = (JSPUtil.getParameter(request, prefix + "zip_cd", length));
            String[] cntcEml = (JSPUtil.getParameter(request, prefix + "cntc_eml", length));
            String[] cntcPsonNm = (JSPUtil.getParameter(request, prefix + "cntc_pson_nm", length));
            String[] bzetRmk = (JSPUtil.getParameter(request, prefix + "bzet_rmk", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] deltFlg = (JSPUtil.getParameter(request, prefix + "delt_flg", length));
            String[] loclAddr1 = (JSPUtil.getParameter(request, prefix + "locl_addr1", length));
            String[] loclAddr2 = (JSPUtil.getParameter(request, prefix + "locl_addr2", length));
            String[] loclAddr3 = (JSPUtil.getParameter(request, prefix + "locl_addr3", length));
            String[] loclAddr4 = (JSPUtil.getParameter(request, prefix + "locl_addr4", length));
            String[] cntCd = (JSPUtil.getParameter(request, prefix + "cnt_cd", length));
            String[] r3InsfId = (JSPUtil.getParameter(request, prefix + "r3_insf_id", length));
            String[] r3InsfPrsId = (JSPUtil.getParameter(request, prefix + "r3_insf_prs_id", length));
            String[] r3InsfDttm = (JSPUtil.getParameter(request, prefix + "r3_insf_dttm", length));
            String[] r3InsfCnqeVal = (JSPUtil.getParameter(request, prefix + "r3_insf_cnqe_val", length));
            String[] r3InsfDvCd = (JSPUtil.getParameter(request, prefix + "r3_insf_dv_cd", length));
            String[] r3InsfCnqeCont = (JSPUtil.getParameter(request, prefix + "r3_insf_cnqe_cont", length));
            String[] ecomInsfId = (JSPUtil.getParameter(request, prefix + "ecom_insf_id", length));
	    	String[] ecomInsfPrsId = (JSPUtil.getParameter(request, prefix + "ecom_insf_prs_id", length));
	    	String[] ecomInsfDttm = (JSPUtil.getParameter(request, prefix + "ecom_insf_dttm", length));
	    	String[] ecomInsfCnqeVal = (JSPUtil.getParameter(request, prefix + "ecom_insf_cnqe_val", length));
	    	String[] ecomInsfDvCd = (JSPUtil.getParameter(request, prefix + "ecom_insf_dv_cd", length));
	    	String[] ecomInsfCnqeCont = (JSPUtil.getParameter(request, prefix + "ecom_insf_cnqe_cont", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new CustAddrIfVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (custAddrIfSeq[i] != null)
                    model.setCustAddrIfSeq(custAddrIfSeq[i]);
                if (custCntCd[i] != null)
                    model.setCustCntCd(custCntCd[i]);
                if (custSeq[i] != null)
                    model.setCustSeq(custSeq[i]);
                if (addrTpCd[i] != null)
                    model.setAddrTpCd(addrTpCd[i]);
                if (addrSeq[i] != null)
                    model.setAddrSeq(addrSeq[i]);
                if (prmryChkFlg[i] != null)
                    model.setPrmryChkFlg(prmryChkFlg[i]);
                if (bzetNm[i] != null)
                    model.setBzetNm(bzetNm[i]);
                if (bzetAddr[i] != null)
                    model.setBzetAddr(bzetAddr[i]);
                if (ctyNm[i] != null)
                    model.setCtyNm(ctyNm[i]);
                if (steCd[i] != null)
                    model.setSteCd(steCd[i]);
                if (zipCd[i] != null)
                    model.setZipCd(zipCd[i]);
                if (cntcEml[i] != null)
                    model.setCntcEml(cntcEml[i]);
                if (cntcPsonNm[i] != null)
                    model.setCntcPsonNm(cntcPsonNm[i]);
                if (bzetRmk[i] != null)
                    model.setBzetRmk(bzetRmk[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (deltFlg[i] != null)
                    model.setDeltFlg(deltFlg[i]);
                if (loclAddr1[i] != null)
                    model.setLoclAddr1(loclAddr1[i]);
                if (loclAddr2[i] != null)
                    model.setLoclAddr2(loclAddr2[i]);
                if (loclAddr3[i] != null)
                    model.setLoclAddr3(loclAddr3[i]);
                if (loclAddr4[i] != null)
                    model.setLoclAddr4(loclAddr4[i]);
                if (cntCd[i] != null)
                    model.setCntCd(cntCd[i]);
                if (r3InsfId[i] != null)
                    model.setR3InsfId(r3InsfId[i]);
                if (r3InsfPrsId[i] != null)
                    model.setR3InsfPrsId(r3InsfPrsId[i]);
                if (r3InsfDttm[i] != null)
                    model.setR3InsfDttm(r3InsfDttm[i]);
                if (r3InsfCnqeVal[i] != null)
                    model.setR3InsfCnqeVal(r3InsfCnqeVal[i]);
                if (r3InsfDvCd[i] != null)
                    model.setR3InsfDvCd(r3InsfDvCd[i]);
                if (r3InsfCnqeCont[i] != null)
                    model.setR3InsfCnqeCont(r3InsfCnqeCont[i]);
                if (ecomInsfId[i] != null) 
		    		model.setEcomInsfId(ecomInsfId[i]);
				if (ecomInsfPrsId[i] != null) 
		    		model.setEcomInsfPrsId(ecomInsfPrsId[i]);
				if (ecomInsfDttm[i] != null) 
		    		model.setEcomInsfDttm(ecomInsfDttm[i]);
				if (ecomInsfCnqeVal[i] != null) 
		    		model.setEcomInsfCnqeVal(ecomInsfCnqeVal[i]);
				if (ecomInsfDvCd[i] != null) 
		    		model.setEcomInsfDvCd(ecomInsfDvCd[i]);
				if (ecomInsfCnqeCont[i] != null) 
		    		model.setEcomInsfCnqeCont(ecomInsfCnqeCont[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getCustAddrIfVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return CustAddrIfVO[]
	 */
    public CustAddrIfVO[] getCustAddrIfVOs() {
        CustAddrIfVO[] vos = (CustAddrIfVO[]) models.toArray(new CustAddrIfVO[models.size()]);
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
        this.custAddrIfSeq = this.custAddrIfSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCntCd = this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custSeq = this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.addrTpCd = this.addrTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.addrSeq = this.addrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prmryChkFlg = this.prmryChkFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bzetNm = this.bzetNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bzetAddr = this.bzetAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctyNm = this.ctyNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.steCd = this.steCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.zipCd = this.zipCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntcEml = this.cntcEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntcPsonNm = this.cntcPsonNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bzetRmk = this.bzetRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deltFlg = this.deltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.loclAddr1 = this.loclAddr1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.loclAddr2 = this.loclAddr2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.loclAddr3 = this.loclAddr3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.loclAddr4 = this.loclAddr4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntCd = this.cntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.r3InsfId = this.r3InsfId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.r3InsfPrsId = this.r3InsfPrsId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.r3InsfDttm = this.r3InsfDttm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.r3InsfCnqeVal = this.r3InsfCnqeVal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.r3InsfDvCd = this.r3InsfDvCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.r3InsfCnqeCont = this.r3InsfCnqeCont.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ecomInsfId = this.ecomInsfId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ecomInsfPrsId = this.ecomInsfPrsId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ecomInsfDttm = this.ecomInsfDttm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ecomInsfCnqeVal = this.ecomInsfCnqeVal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ecomInsfDvCd = this.ecomInsfDvCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ecomInsfCnqeCont = this.ecomInsfCnqeCont.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
