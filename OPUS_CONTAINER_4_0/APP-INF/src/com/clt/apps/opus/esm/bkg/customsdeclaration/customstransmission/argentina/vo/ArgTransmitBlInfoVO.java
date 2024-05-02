/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ArgTransmitBlInfoVO.java
*@FileTitle : ArgTransmitBlInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.02
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.01.02 김민정 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.argentina.vo;

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
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class ArgTransmitBlInfoVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<ArgTransmitBlInfoVO> models = new ArrayList<ArgTransmitBlInfoVO>();

    /* Column Info */
    private String eta = null;

    /* Column Info */
    private String cneBlPtName = null;

    /* Column Info */
    private String nfyBlPtAddress = null;

    /* Column Info */
    private String shpBlPtCity = null;

    /* Column Info */
    private String shpBlPtAddress = null;

    /* Column Info */
    private String etd = null;

    /* Column Info */
    private String foreignNationCd = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String cneBlPtType = null;

    /* Column Info */
    private String cneBlPtPostalCd = null;

    /* Column Info */
    private String terminalCd = null;

    /* Column Info */
    private String exInd = null;

    /* Column Info */
    private String nfyBlPtStreet = null;

    /* Column Info */
    private String vslName = null;

    /* Column Info */
    private String commodityCd = null;

    /* Column Info */
    private String nfyBlPtCntCd = null;

    /* Column Info */
    private String rdTerm = null;

    /* Column Info */
    private String blpod = null;

    /* Column Info */
    private String cneBlPtAddress = null;

    /* Column Info */
    private String blnbr = null;

    /* Column Info */
    private String shpBlPtCntCd = null;

    /* Column Info */
    private String nfyBlPtCity = null;

    /* Column Info */
    private String cneBlPtTaxId = null;

    /* Column Info */
    private String blpkg = null;

    /* Column Info */
    private String shpBlPtName = null;

    /* Column Info */
    private String blpol = null;

    /* Column Info */
    private String vslCode = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String markno = null;

    /* Column Info */
    private String cneBlPtCity = null;

    /* Column Info */
    private String shpBlPtTaxId = null;

    /* Column Info */
    private String vslNationCd = null;

    /* Column Info */
    private String nfyBlPtPostalCd = null;

    /* Column Info */
    private String cneBlPtCntCd = null;

    /* Column Info */
    private String consolidateInd = null;

    /* Column Info */
    private String shpBlPtTaxType = null;

    /* Column Info */
    private String bDesc = null;

    /* Column Info */
    private String blwgt = null;

    /* Column Info */
    private String nfyBlPtTaxId = null;

    /* Column Info */
    private String trInd = null;

    /* Column Info */
    private String nfyBlPtName = null;

    /* Column Info */
    private String shpBlPtPostalCd = null;

    /* Column Info */
    private String blwgtUnit = null;

    /* Column Info */
    private String shpBlPtType = null;

    /* Column Info */
    private String shpBlPtStreet = null;

    /* Column Info */
    private String nfyBlPtType = null;

    /* Column Info */
    private String cneBlPtStreet = null;

    /* Column Info */
    private String cneBlPtTaxType = null;

    /* Column Info */
    private String nfyBlPtTaxType = null;

    /* Column Info */
    private String vspol = null;

    /* Column Info */
    private String vspod = null;
    
    /* Column Info */
    private String shipIdInd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public ArgTransmitBlInfoVO() {
    }

    public ArgTransmitBlInfoVO(String ibflag, String pagerows, String vslCode, String vslName, String vslNationCd, String exInd, String terminalCd, String eta, String etd, String foreignNationCd, String blnbr, String blpol, String blpod, String rdTerm, String consolidateInd, String trInd, String commodityCd, String blpkg, String blwgt, String blwgtUnit, String bDesc, String markno, String shpBlPtType, String shpBlPtName, String shpBlPtAddress, String shpBlPtStreet, String shpBlPtCity, String shpBlPtPostalCd, String shpBlPtCntCd, String shpBlPtTaxType, String shpBlPtTaxId, String cneBlPtType, String cneBlPtName, String cneBlPtAddress, String cneBlPtStreet, String cneBlPtCity, String cneBlPtPostalCd, String cneBlPtCntCd, String cneBlPtTaxType, String cneBlPtTaxId, String nfyBlPtType, String nfyBlPtName, String nfyBlPtAddress, String nfyBlPtStreet, String nfyBlPtCity, String nfyBlPtPostalCd, String nfyBlPtCntCd, String nfyBlPtTaxType, String nfyBlPtTaxId, String vspol, String vspod, String shipIdInd) {
        this.eta = eta;
        this.cneBlPtName = cneBlPtName;
        this.nfyBlPtAddress = nfyBlPtAddress;
        this.shpBlPtCity = shpBlPtCity;
        this.shpBlPtAddress = shpBlPtAddress;
        this.etd = etd;
        this.foreignNationCd = foreignNationCd;
        this.pagerows = pagerows;
        this.cneBlPtType = cneBlPtType;
        this.cneBlPtPostalCd = cneBlPtPostalCd;
        this.terminalCd = terminalCd;
        this.exInd = exInd;
        this.nfyBlPtStreet = nfyBlPtStreet;
        this.vslName = vslName;
        this.commodityCd = commodityCd;
        this.nfyBlPtCntCd = nfyBlPtCntCd;
        this.rdTerm = rdTerm;
        this.blpod = blpod;
        this.cneBlPtAddress = cneBlPtAddress;
        this.blnbr = blnbr;
        this.shpBlPtCntCd = shpBlPtCntCd;
        this.nfyBlPtCity = nfyBlPtCity;
        this.cneBlPtTaxId = cneBlPtTaxId;
        this.blpkg = blpkg;
        this.shpBlPtName = shpBlPtName;
        this.blpol = blpol;
        this.vslCode = vslCode;
        this.ibflag = ibflag;
        this.markno = markno;
        this.cneBlPtCity = cneBlPtCity;
        this.shpBlPtTaxId = shpBlPtTaxId;
        this.vslNationCd = vslNationCd;
        this.nfyBlPtPostalCd = nfyBlPtPostalCd;
        this.cneBlPtCntCd = cneBlPtCntCd;
        this.consolidateInd = consolidateInd;
        this.shpBlPtTaxType = shpBlPtTaxType;
        this.bDesc = bDesc;
        this.blwgt = blwgt;
        this.nfyBlPtTaxId = nfyBlPtTaxId;
        this.trInd = trInd;
        this.nfyBlPtName = nfyBlPtName;
        this.shpBlPtPostalCd = shpBlPtPostalCd;
        this.blwgtUnit = blwgtUnit;
        this.shpBlPtType = shpBlPtType;
        this.shpBlPtStreet = shpBlPtStreet;
        this.nfyBlPtType = nfyBlPtType;
        this.cneBlPtStreet = cneBlPtStreet;
        this.cneBlPtTaxType = cneBlPtTaxType;
        this.nfyBlPtTaxType = nfyBlPtTaxType;
        this.vspol = vspol;
        this.vspod = vspod;
        this.shipIdInd = shipIdInd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("eta", getEta());
        this.hashColumns.put("cne_bl_pt_name", getCneBlPtName());
        this.hashColumns.put("nfy_bl_pt_address", getNfyBlPtAddress());
        this.hashColumns.put("shp_bl_pt_city", getShpBlPtCity());
        this.hashColumns.put("shp_bl_pt_address", getShpBlPtAddress());
        this.hashColumns.put("etd", getEtd());
        this.hashColumns.put("foreign_nation_cd", getForeignNationCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("cne_bl_pt_type", getCneBlPtType());
        this.hashColumns.put("cne_bl_pt_postal_cd", getCneBlPtPostalCd());
        this.hashColumns.put("terminal_cd", getTerminalCd());
        this.hashColumns.put("ex_ind", getExInd());
        this.hashColumns.put("nfy_bl_pt_street", getNfyBlPtStreet());
        this.hashColumns.put("vsl_name", getVslName());
        this.hashColumns.put("commodity_cd", getCommodityCd());
        this.hashColumns.put("nfy_bl_pt_cnt_cd", getNfyBlPtCntCd());
        this.hashColumns.put("rd_term", getRdTerm());
        this.hashColumns.put("blpod", getBlpod());
        this.hashColumns.put("cne_bl_pt_address", getCneBlPtAddress());
        this.hashColumns.put("blnbr", getBlnbr());
        this.hashColumns.put("shp_bl_pt_cnt_cd", getShpBlPtCntCd());
        this.hashColumns.put("nfy_bl_pt_city", getNfyBlPtCity());
        this.hashColumns.put("cne_bl_pt_tax_id", getCneBlPtTaxId());
        this.hashColumns.put("blpkg", getBlpkg());
        this.hashColumns.put("shp_bl_pt_name", getShpBlPtName());
        this.hashColumns.put("blpol", getBlpol());
        this.hashColumns.put("vsl_code", getVslCode());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("markno", getMarkno());
        this.hashColumns.put("cne_bl_pt_city", getCneBlPtCity());
        this.hashColumns.put("shp_bl_pt_tax_id", getShpBlPtTaxId());
        this.hashColumns.put("vsl_nation_cd", getVslNationCd());
        this.hashColumns.put("nfy_bl_pt_postal_cd", getNfyBlPtPostalCd());
        this.hashColumns.put("cne_bl_pt_cnt_cd", getCneBlPtCntCd());
        this.hashColumns.put("consolidate_ind", getConsolidateInd());
        this.hashColumns.put("shp_bl_pt_tax_type", getShpBlPtTaxType());
        this.hashColumns.put("b_desc", getBDesc());
        this.hashColumns.put("blwgt", getBlwgt());
        this.hashColumns.put("nfy_bl_pt_tax_id", getNfyBlPtTaxId());
        this.hashColumns.put("tr_ind", getTrInd());
        this.hashColumns.put("nfy_bl_pt_name", getNfyBlPtName());
        this.hashColumns.put("shp_bl_pt_postal_cd", getShpBlPtPostalCd());
        this.hashColumns.put("blwgt_unit", getBlwgtUnit());
        this.hashColumns.put("shp_bl_pt_type", getShpBlPtType());
        this.hashColumns.put("shp_bl_pt_street", getShpBlPtStreet());
        this.hashColumns.put("nfy_bl_pt_type", getNfyBlPtType());
        this.hashColumns.put("cne_bl_pt_street", getCneBlPtStreet());
        this.hashColumns.put("cne_bl_pt_tax_type", getCneBlPtTaxType());
        this.hashColumns.put("nfy_bl_pt_tax_type", getNfyBlPtTaxType());
        this.hashColumns.put("vspol", getVspol());
        this.hashColumns.put("vspod", getVspod());
        this.hashColumns.put("ship_id_ind", getShipIdInd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("eta", "eta");
        this.hashFields.put("cne_bl_pt_name", "cneBlPtName");
        this.hashFields.put("nfy_bl_pt_address", "nfyBlPtAddress");
        this.hashFields.put("shp_bl_pt_city", "shpBlPtCity");
        this.hashFields.put("shp_bl_pt_address", "shpBlPtAddress");
        this.hashFields.put("etd", "etd");
        this.hashFields.put("foreign_nation_cd", "foreignNationCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("cne_bl_pt_type", "cneBlPtType");
        this.hashFields.put("cne_bl_pt_postal_cd", "cneBlPtPostalCd");
        this.hashFields.put("terminal_cd", "terminalCd");
        this.hashFields.put("ex_ind", "exInd");
        this.hashFields.put("nfy_bl_pt_street", "nfyBlPtStreet");
        this.hashFields.put("vsl_name", "vslName");
        this.hashFields.put("commodity_cd", "commodityCd");
        this.hashFields.put("nfy_bl_pt_cnt_cd", "nfyBlPtCntCd");
        this.hashFields.put("rd_term", "rdTerm");
        this.hashFields.put("blpod", "blpod");
        this.hashFields.put("cne_bl_pt_address", "cneBlPtAddress");
        this.hashFields.put("blnbr", "blnbr");
        this.hashFields.put("shp_bl_pt_cnt_cd", "shpBlPtCntCd");
        this.hashFields.put("nfy_bl_pt_city", "nfyBlPtCity");
        this.hashFields.put("cne_bl_pt_tax_id", "cneBlPtTaxId");
        this.hashFields.put("blpkg", "blpkg");
        this.hashFields.put("shp_bl_pt_name", "shpBlPtName");
        this.hashFields.put("blpol", "blpol");
        this.hashFields.put("vsl_code", "vslCode");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("markno", "markno");
        this.hashFields.put("cne_bl_pt_city", "cneBlPtCity");
        this.hashFields.put("shp_bl_pt_tax_id", "shpBlPtTaxId");
        this.hashFields.put("vsl_nation_cd", "vslNationCd");
        this.hashFields.put("nfy_bl_pt_postal_cd", "nfyBlPtPostalCd");
        this.hashFields.put("cne_bl_pt_cnt_cd", "cneBlPtCntCd");
        this.hashFields.put("consolidate_ind", "consolidateInd");
        this.hashFields.put("shp_bl_pt_tax_type", "shpBlPtTaxType");
        this.hashFields.put("b_desc", "bDesc");
        this.hashFields.put("blwgt", "blwgt");
        this.hashFields.put("nfy_bl_pt_tax_id", "nfyBlPtTaxId");
        this.hashFields.put("tr_ind", "trInd");
        this.hashFields.put("nfy_bl_pt_name", "nfyBlPtName");
        this.hashFields.put("shp_bl_pt_postal_cd", "shpBlPtPostalCd");
        this.hashFields.put("blwgt_unit", "blwgtUnit");
        this.hashFields.put("shp_bl_pt_type", "shpBlPtType");
        this.hashFields.put("shp_bl_pt_street", "shpBlPtStreet");
        this.hashFields.put("nfy_bl_pt_type", "nfyBlPtType");
        this.hashFields.put("cne_bl_pt_street", "cneBlPtStreet");
        this.hashFields.put("cne_bl_pt_tax_type", "cneBlPtTaxType");
        this.hashFields.put("nfy_bl_pt_tax_type", "nfyBlPtTaxType");
        this.hashFields.put("vspol", "vspol");
        this.hashFields.put("vspod", "vspod");
        this.hashFields.put("ship_id_ind", "shipIdInd");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return eta
	 */
    public String getEta() {
        return this.eta;
    }

    /**
	 * Column Info
	 * @return cneBlPtName
	 */
    public String getCneBlPtName() {
        return this.cneBlPtName;
    }

    /**
	 * Column Info
	 * @return nfyBlPtAddress
	 */
    public String getNfyBlPtAddress() {
        return this.nfyBlPtAddress;
    }

    /**
	 * Column Info
	 * @return shpBlPtCity
	 */
    public String getShpBlPtCity() {
        return this.shpBlPtCity;
    }

    /**
	 * Column Info
	 * @return shpBlPtAddress
	 */
    public String getShpBlPtAddress() {
        return this.shpBlPtAddress;
    }

    /**
	 * Column Info
	 * @return etd
	 */
    public String getEtd() {
        return this.etd;
    }

    /**
	 * Column Info
	 * @return foreignNationCd
	 */
    public String getForeignNationCd() {
        return this.foreignNationCd;
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
	 * @return cneBlPtType
	 */
    public String getCneBlPtType() {
        return this.cneBlPtType;
    }

    /**
	 * Column Info
	 * @return cneBlPtPostalCd
	 */
    public String getCneBlPtPostalCd() {
        return this.cneBlPtPostalCd;
    }

    /**
	 * Column Info
	 * @return terminalCd
	 */
    public String getTerminalCd() {
        return this.terminalCd;
    }

    /**
	 * Column Info
	 * @return exInd
	 */
    public String getExInd() {
        return this.exInd;
    }

    /**
	 * Column Info
	 * @return nfyBlPtStreet
	 */
    public String getNfyBlPtStreet() {
        return this.nfyBlPtStreet;
    }

    /**
	 * Column Info
	 * @return vslName
	 */
    public String getVslName() {
        return this.vslName;
    }

    /**
	 * Column Info
	 * @return commodityCd
	 */
    public String getCommodityCd() {
        return this.commodityCd;
    }

    /**
	 * Column Info
	 * @return nfyBlPtCntCd
	 */
    public String getNfyBlPtCntCd() {
        return this.nfyBlPtCntCd;
    }

    /**
	 * Column Info
	 * @return rdTerm
	 */
    public String getRdTerm() {
        return this.rdTerm;
    }

    /**
	 * Column Info
	 * @return blpod
	 */
    public String getBlpod() {
        return this.blpod;
    }

    /**
	 * Column Info
	 * @return cneBlPtAddress
	 */
    public String getCneBlPtAddress() {
        return this.cneBlPtAddress;
    }

    /**
	 * Column Info
	 * @return blnbr
	 */
    public String getBlnbr() {
        return this.blnbr;
    }

    /**
	 * Column Info
	 * @return shpBlPtCntCd
	 */
    public String getShpBlPtCntCd() {
        return this.shpBlPtCntCd;
    }

    /**
	 * Column Info
	 * @return nfyBlPtCity
	 */
    public String getNfyBlPtCity() {
        return this.nfyBlPtCity;
    }

    /**
	 * Column Info
	 * @return cneBlPtTaxId
	 */
    public String getCneBlPtTaxId() {
        return this.cneBlPtTaxId;
    }

    /**
	 * Column Info
	 * @return blpkg
	 */
    public String getBlpkg() {
        return this.blpkg;
    }

    /**
	 * Column Info
	 * @return shpBlPtName
	 */
    public String getShpBlPtName() {
        return this.shpBlPtName;
    }

    /**
	 * Column Info
	 * @return blpol
	 */
    public String getBlpol() {
        return this.blpol;
    }

    /**
	 * Column Info
	 * @return vslCode
	 */
    public String getVslCode() {
        return this.vslCode;
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
	 * @return markno
	 */
    public String getMarkno() {
        return this.markno;
    }

    /**
	 * Column Info
	 * @return cneBlPtCity
	 */
    public String getCneBlPtCity() {
        return this.cneBlPtCity;
    }

    /**
	 * Column Info
	 * @return shpBlPtTaxId
	 */
    public String getShpBlPtTaxId() {
        return this.shpBlPtTaxId;
    }

    /**
	 * Column Info
	 * @return vslNationCd
	 */
    public String getVslNationCd() {
        return this.vslNationCd;
    }

    /**
	 * Column Info
	 * @return nfyBlPtPostalCd
	 */
    public String getNfyBlPtPostalCd() {
        return this.nfyBlPtPostalCd;
    }

    /**
	 * Column Info
	 * @return cneBlPtCntCd
	 */
    public String getCneBlPtCntCd() {
        return this.cneBlPtCntCd;
    }

    /**
	 * Column Info
	 * @return consolidateInd
	 */
    public String getConsolidateInd() {
        return this.consolidateInd;
    }

    /**
	 * Column Info
	 * @return shpBlPtTaxType
	 */
    public String getShpBlPtTaxType() {
        return this.shpBlPtTaxType;
    }

    /**
	 * Column Info
	 * @return bDesc
	 */
    public String getBDesc() {
        return this.bDesc;
    }

    /**
	 * Column Info
	 * @return blwgt
	 */
    public String getBlwgt() {
        return this.blwgt;
    }

    /**
	 * Column Info
	 * @return nfyBlPtTaxId
	 */
    public String getNfyBlPtTaxId() {
        return this.nfyBlPtTaxId;
    }

    /**
	 * Column Info
	 * @return trInd
	 */
    public String getTrInd() {
        return this.trInd;
    }

    /**
	 * Column Info
	 * @return nfyBlPtName
	 */
    public String getNfyBlPtName() {
        return this.nfyBlPtName;
    }

    /**
	 * Column Info
	 * @return shpBlPtPostalCd
	 */
    public String getShpBlPtPostalCd() {
        return this.shpBlPtPostalCd;
    }

    /**
	 * Column Info
	 * @return blwgtUnit
	 */
    public String getBlwgtUnit() {
        return this.blwgtUnit;
    }

    /**
	 * Column Info
	 * @return shpBlPtType
	 */
    public String getShpBlPtType() {
        return this.shpBlPtType;
    }

    /**
	 * Column Info
	 * @return shpBlPtStreet
	 */
    public String getShpBlPtStreet() {
        return this.shpBlPtStreet;
    }

    /**
	 * Column Info
	 * @return nfyBlPtType
	 */
    public String getNfyBlPtType() {
        return this.nfyBlPtType;
    }

    /**
	 * Column Info
	 * @return cneBlPtStreet
	 */
    public String getCneBlPtStreet() {
        return this.cneBlPtStreet;
    }

    /**
	 * Column Info
	 * @return cneBlPtTaxType
	 */
    public String getCneBlPtTaxType() {
        return this.cneBlPtTaxType;
    }

    /**
	 * Column Info
	 * @return nfyBlPtTaxType
	 */
    public String getNfyBlPtTaxType() {
        return this.nfyBlPtTaxType;
    }

    /**
	 * Column Info
	 * @param eta
	 */
    public void setEta(String eta) {
        this.eta = eta;
    }

    /**
	 * Column Info
	 * @param cneBlPtName
	 */
    public void setCneBlPtName(String cneBlPtName) {
        this.cneBlPtName = cneBlPtName;
    }

    /**
	 * Column Info
	 * @param nfyBlPtAddress
	 */
    public void setNfyBlPtAddress(String nfyBlPtAddress) {
        this.nfyBlPtAddress = nfyBlPtAddress;
    }

    /**
	 * Column Info
	 * @param shpBlPtCity
	 */
    public void setShpBlPtCity(String shpBlPtCity) {
        this.shpBlPtCity = shpBlPtCity;
    }

    /**
	 * Column Info
	 * @param shpBlPtAddress
	 */
    public void setShpBlPtAddress(String shpBlPtAddress) {
        this.shpBlPtAddress = shpBlPtAddress;
    }

    /**
	 * Column Info
	 * @param etd
	 */
    public void setEtd(String etd) {
        this.etd = etd;
    }

    /**
	 * Column Info
	 * @param foreignNationCd
	 */
    public void setForeignNationCd(String foreignNationCd) {
        this.foreignNationCd = foreignNationCd;
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
	 * @param cneBlPtType
	 */
    public void setCneBlPtType(String cneBlPtType) {
        this.cneBlPtType = cneBlPtType;
    }

    /**
	 * Column Info
	 * @param cneBlPtPostalCd
	 */
    public void setCneBlPtPostalCd(String cneBlPtPostalCd) {
        this.cneBlPtPostalCd = cneBlPtPostalCd;
    }

    /**
	 * Column Info
	 * @param terminalCd
	 */
    public void setTerminalCd(String terminalCd) {
        this.terminalCd = terminalCd;
    }

    /**
	 * Column Info
	 * @param exInd
	 */
    public void setExInd(String exInd) {
        this.exInd = exInd;
    }

    /**
	 * Column Info
	 * @param nfyBlPtStreet
	 */
    public void setNfyBlPtStreet(String nfyBlPtStreet) {
        this.nfyBlPtStreet = nfyBlPtStreet;
    }

    /**
	 * Column Info
	 * @param vslName
	 */
    public void setVslName(String vslName) {
        this.vslName = vslName;
    }

    /**
	 * Column Info
	 * @param commodityCd
	 */
    public void setCommodityCd(String commodityCd) {
        this.commodityCd = commodityCd;
    }

    /**
	 * Column Info
	 * @param nfyBlPtCntCd
	 */
    public void setNfyBlPtCntCd(String nfyBlPtCntCd) {
        this.nfyBlPtCntCd = nfyBlPtCntCd;
    }

    /**
	 * Column Info
	 * @param rdTerm
	 */
    public void setRdTerm(String rdTerm) {
        this.rdTerm = rdTerm;
    }

    /**
	 * Column Info
	 * @param blpod
	 */
    public void setBlpod(String blpod) {
        this.blpod = blpod;
    }

    /**
	 * Column Info
	 * @param cneBlPtAddress
	 */
    public void setCneBlPtAddress(String cneBlPtAddress) {
        this.cneBlPtAddress = cneBlPtAddress;
    }

    /**
	 * Column Info
	 * @param blnbr
	 */
    public void setBlnbr(String blnbr) {
        this.blnbr = blnbr;
    }

    /**
	 * Column Info
	 * @param shpBlPtCntCd
	 */
    public void setShpBlPtCntCd(String shpBlPtCntCd) {
        this.shpBlPtCntCd = shpBlPtCntCd;
    }

    /**
	 * Column Info
	 * @param nfyBlPtCity
	 */
    public void setNfyBlPtCity(String nfyBlPtCity) {
        this.nfyBlPtCity = nfyBlPtCity;
    }

    /**
	 * Column Info
	 * @param cneBlPtTaxId
	 */
    public void setCneBlPtTaxId(String cneBlPtTaxId) {
        this.cneBlPtTaxId = cneBlPtTaxId;
    }

    /**
	 * Column Info
	 * @param blpkg
	 */
    public void setBlpkg(String blpkg) {
        this.blpkg = blpkg;
    }

    /**
	 * Column Info
	 * @param shpBlPtName
	 */
    public void setShpBlPtName(String shpBlPtName) {
        this.shpBlPtName = shpBlPtName;
    }

    /**
	 * Column Info
	 * @param blpol
	 */
    public void setBlpol(String blpol) {
        this.blpol = blpol;
    }

    /**
	 * Column Info
	 * @param vslCode
	 */
    public void setVslCode(String vslCode) {
        this.vslCode = vslCode;
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
	 * @param markno
	 */
    public void setMarkno(String markno) {
        this.markno = markno;
    }

    /**
	 * Column Info
	 * @param cneBlPtCity
	 */
    public void setCneBlPtCity(String cneBlPtCity) {
        this.cneBlPtCity = cneBlPtCity;
    }

    /**
	 * Column Info
	 * @param shpBlPtTaxId
	 */
    public void setShpBlPtTaxId(String shpBlPtTaxId) {
        this.shpBlPtTaxId = shpBlPtTaxId;
    }

    /**
	 * Column Info
	 * @param vslNationCd
	 */
    public void setVslNationCd(String vslNationCd) {
        this.vslNationCd = vslNationCd;
    }

    /**
	 * Column Info
	 * @param nfyBlPtPostalCd
	 */
    public void setNfyBlPtPostalCd(String nfyBlPtPostalCd) {
        this.nfyBlPtPostalCd = nfyBlPtPostalCd;
    }

    /**
	 * Column Info
	 * @param cneBlPtCntCd
	 */
    public void setCneBlPtCntCd(String cneBlPtCntCd) {
        this.cneBlPtCntCd = cneBlPtCntCd;
    }

    /**
	 * Column Info
	 * @param consolidateInd
	 */
    public void setConsolidateInd(String consolidateInd) {
        this.consolidateInd = consolidateInd;
    }

    /**
	 * Column Info
	 * @param shpBlPtTaxType
	 */
    public void setShpBlPtTaxType(String shpBlPtTaxType) {
        this.shpBlPtTaxType = shpBlPtTaxType;
    }

    /**
	 * Column Info
	 * @param bDesc
	 */
    public void setBDesc(String bDesc) {
        this.bDesc = bDesc;
    }

    /**
	 * Column Info
	 * @param blwgt
	 */
    public void setBlwgt(String blwgt) {
        this.blwgt = blwgt;
    }

    /**
	 * Column Info
	 * @param nfyBlPtTaxId
	 */
    public void setNfyBlPtTaxId(String nfyBlPtTaxId) {
        this.nfyBlPtTaxId = nfyBlPtTaxId;
    }

    /**
	 * Column Info
	 * @param trInd
	 */
    public void setTrInd(String trInd) {
        this.trInd = trInd;
    }

    /**
	 * Column Info
	 * @param nfyBlPtName
	 */
    public void setNfyBlPtName(String nfyBlPtName) {
        this.nfyBlPtName = nfyBlPtName;
    }

    /**
	 * Column Info
	 * @param shpBlPtPostalCd
	 */
    public void setShpBlPtPostalCd(String shpBlPtPostalCd) {
        this.shpBlPtPostalCd = shpBlPtPostalCd;
    }

    /**
	 * Column Info
	 * @param blwgtUnit
	 */
    public void setBlwgtUnit(String blwgtUnit) {
        this.blwgtUnit = blwgtUnit;
    }

    /**
	 * Column Info
	 * @param shpBlPtType
	 */
    public void setShpBlPtType(String shpBlPtType) {
        this.shpBlPtType = shpBlPtType;
    }

    /**
	 * Column Info
	 * @param shpBlPtStreet
	 */
    public void setShpBlPtStreet(String shpBlPtStreet) {
        this.shpBlPtStreet = shpBlPtStreet;
    }

    /**
	 * Column Info
	 * @param nfyBlPtType
	 */
    public void setNfyBlPtType(String nfyBlPtType) {
        this.nfyBlPtType = nfyBlPtType;
    }

    /**
	 * Column Info
	 * @param cneBlPtStreet
	 */
    public void setCneBlPtStreet(String cneBlPtStreet) {
        this.cneBlPtStreet = cneBlPtStreet;
    }

    /**
	 * Column Info
	 * @param cneBlPtTaxType
	 */
    public void setCneBlPtTaxType(String cneBlPtTaxType) {
        this.cneBlPtTaxType = cneBlPtTaxType;
    }

    /**
	 * Column Info
	 * @param nfyBlPtTaxType
	 */
    public void setNfyBlPtTaxType(String nfyBlPtTaxType) {
        this.nfyBlPtTaxType = nfyBlPtTaxType;
    }

    public void setVspol(String vspol) {
        this.vspol = vspol;
    }

    public String getVspol() {
        return this.vspol;
    }

    public void setVspod(String vspod) {
        this.vspod = vspod;
    }

    public String getVspod() {
        return this.vspod;
    }
    
    /**
     * Column Info
     * @param shipIdInd
     */
    public void setShipIdInd(String shipIdInd){
    	this.shipIdInd = shipIdInd;
    }
    
    /**
     * Column Info
     * @return shipIdInd
     */
    public String getShipIdInd(){
    	return this.shipIdInd;
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
        setEta(JSPUtil.getParameter(request, prefix + "eta", ""));
        setCneBlPtName(JSPUtil.getParameter(request, prefix + "cne_bl_pt_name", ""));
        setNfyBlPtAddress(JSPUtil.getParameter(request, prefix + "nfy_bl_pt_address", ""));
        setShpBlPtCity(JSPUtil.getParameter(request, prefix + "shp_bl_pt_city", ""));
        setShpBlPtAddress(JSPUtil.getParameter(request, prefix + "shp_bl_pt_address", ""));
        setEtd(JSPUtil.getParameter(request, prefix + "etd", ""));
        setForeignNationCd(JSPUtil.getParameter(request, prefix + "foreign_nation_cd", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setCneBlPtType(JSPUtil.getParameter(request, prefix + "cne_bl_pt_type", ""));
        setCneBlPtPostalCd(JSPUtil.getParameter(request, prefix + "cne_bl_pt_postal_cd", ""));
        setTerminalCd(JSPUtil.getParameter(request, prefix + "terminal_cd", ""));
        setExInd(JSPUtil.getParameter(request, prefix + "ex_ind", ""));
        setNfyBlPtStreet(JSPUtil.getParameter(request, prefix + "nfy_bl_pt_street", ""));
        setVslName(JSPUtil.getParameter(request, prefix + "vsl_name", ""));
        setCommodityCd(JSPUtil.getParameter(request, prefix + "commodity_cd", ""));
        setNfyBlPtCntCd(JSPUtil.getParameter(request, prefix + "nfy_bl_pt_cnt_cd", ""));
        setRdTerm(JSPUtil.getParameter(request, prefix + "rd_term", ""));
        setBlpod(JSPUtil.getParameter(request, prefix + "blpod", ""));
        setCneBlPtAddress(JSPUtil.getParameter(request, prefix + "cne_bl_pt_address", ""));
        setBlnbr(JSPUtil.getParameter(request, prefix + "blnbr", ""));
        setShpBlPtCntCd(JSPUtil.getParameter(request, prefix + "shp_bl_pt_cnt_cd", ""));
        setNfyBlPtCity(JSPUtil.getParameter(request, prefix + "nfy_bl_pt_city", ""));
        setCneBlPtTaxId(JSPUtil.getParameter(request, prefix + "cne_bl_pt_tax_id", ""));
        setBlpkg(JSPUtil.getParameter(request, prefix + "blpkg", ""));
        setShpBlPtName(JSPUtil.getParameter(request, prefix + "shp_bl_pt_name", ""));
        setBlpol(JSPUtil.getParameter(request, prefix + "blpol", ""));
        setVslCode(JSPUtil.getParameter(request, prefix + "vsl_code", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setMarkno(JSPUtil.getParameter(request, prefix + "markno", ""));
        setCneBlPtCity(JSPUtil.getParameter(request, prefix + "cne_bl_pt_city", ""));
        setShpBlPtTaxId(JSPUtil.getParameter(request, prefix + "shp_bl_pt_tax_id", ""));
        setVslNationCd(JSPUtil.getParameter(request, prefix + "vsl_nation_cd", ""));
        setNfyBlPtPostalCd(JSPUtil.getParameter(request, prefix + "nfy_bl_pt_postal_cd", ""));
        setCneBlPtCntCd(JSPUtil.getParameter(request, prefix + "cne_bl_pt_cnt_cd", ""));
        setConsolidateInd(JSPUtil.getParameter(request, prefix + "consolidate_ind", ""));
        setShpBlPtTaxType(JSPUtil.getParameter(request, prefix + "shp_bl_pt_tax_type", ""));
        setBDesc(JSPUtil.getParameter(request, prefix + "b_desc", ""));
        setBlwgt(JSPUtil.getParameter(request, prefix + "blwgt", ""));
        setNfyBlPtTaxId(JSPUtil.getParameter(request, prefix + "nfy_bl_pt_tax_id", ""));
        setTrInd(JSPUtil.getParameter(request, prefix + "tr_ind", ""));
        setNfyBlPtName(JSPUtil.getParameter(request, prefix + "nfy_bl_pt_name", ""));
        setShpBlPtPostalCd(JSPUtil.getParameter(request, prefix + "shp_bl_pt_postal_cd", ""));
        setBlwgtUnit(JSPUtil.getParameter(request, prefix + "blwgt_unit", ""));
        setShpBlPtType(JSPUtil.getParameter(request, prefix + "shp_bl_pt_type", ""));
        setShpBlPtStreet(JSPUtil.getParameter(request, prefix + "shp_bl_pt_street", ""));
        setNfyBlPtType(JSPUtil.getParameter(request, prefix + "nfy_bl_pt_type", ""));
        setCneBlPtStreet(JSPUtil.getParameter(request, prefix + "cne_bl_pt_street", ""));
        setCneBlPtTaxType(JSPUtil.getParameter(request, prefix + "cne_bl_pt_tax_type", ""));
        setNfyBlPtTaxType(JSPUtil.getParameter(request, prefix + "nfy_bl_pt_tax_type", ""));
        setVspol(JSPUtil.getParameter(request, prefix + "vspol", ""));
        setVspod(JSPUtil.getParameter(request, prefix + "vspod", ""));
        setShipIdInd(JSPUtil.getParameter(request, prefix + "ship_id_ind", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ArgTransmitBlInfoVO[]
	 */
    public ArgTransmitBlInfoVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ArgTransmitBlInfoVO[]
	 */
    public ArgTransmitBlInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        ArgTransmitBlInfoVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] eta = (JSPUtil.getParameter(request, prefix + "eta", length));
            String[] cneBlPtName = (JSPUtil.getParameter(request, prefix + "cne_bl_pt_name", length));
            String[] nfyBlPtAddress = (JSPUtil.getParameter(request, prefix + "nfy_bl_pt_address", length));
            String[] shpBlPtCity = (JSPUtil.getParameter(request, prefix + "shp_bl_pt_city", length));
            String[] shpBlPtAddress = (JSPUtil.getParameter(request, prefix + "shp_bl_pt_address", length));
            String[] etd = (JSPUtil.getParameter(request, prefix + "etd", length));
            String[] foreignNationCd = (JSPUtil.getParameter(request, prefix + "foreign_nation_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] cneBlPtType = (JSPUtil.getParameter(request, prefix + "cne_bl_pt_type", length));
            String[] cneBlPtPostalCd = (JSPUtil.getParameter(request, prefix + "cne_bl_pt_postal_cd", length));
            String[] terminalCd = (JSPUtil.getParameter(request, prefix + "terminal_cd", length));
            String[] exInd = (JSPUtil.getParameter(request, prefix + "ex_ind", length));
            String[] nfyBlPtStreet = (JSPUtil.getParameter(request, prefix + "nfy_bl_pt_street", length));
            String[] vslName = (JSPUtil.getParameter(request, prefix + "vsl_name", length));
            String[] commodityCd = (JSPUtil.getParameter(request, prefix + "commodity_cd", length));
            String[] nfyBlPtCntCd = (JSPUtil.getParameter(request, prefix + "nfy_bl_pt_cnt_cd", length));
            String[] rdTerm = (JSPUtil.getParameter(request, prefix + "rd_term", length));
            String[] blpod = (JSPUtil.getParameter(request, prefix + "blpod", length));
            String[] cneBlPtAddress = (JSPUtil.getParameter(request, prefix + "cne_bl_pt_address", length));
            String[] blnbr = (JSPUtil.getParameter(request, prefix + "blnbr", length));
            String[] shpBlPtCntCd = (JSPUtil.getParameter(request, prefix + "shp_bl_pt_cnt_cd", length));
            String[] nfyBlPtCity = (JSPUtil.getParameter(request, prefix + "nfy_bl_pt_city", length));
            String[] cneBlPtTaxId = (JSPUtil.getParameter(request, prefix + "cne_bl_pt_tax_id", length));
            String[] blpkg = (JSPUtil.getParameter(request, prefix + "blpkg", length));
            String[] shpBlPtName = (JSPUtil.getParameter(request, prefix + "shp_bl_pt_name", length));
            String[] blpol = (JSPUtil.getParameter(request, prefix + "blpol", length));
            String[] vslCode = (JSPUtil.getParameter(request, prefix + "vsl_code", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] markno = (JSPUtil.getParameter(request, prefix + "markno", length));
            String[] cneBlPtCity = (JSPUtil.getParameter(request, prefix + "cne_bl_pt_city", length));
            String[] shpBlPtTaxId = (JSPUtil.getParameter(request, prefix + "shp_bl_pt_tax_id", length));
            String[] vslNationCd = (JSPUtil.getParameter(request, prefix + "vsl_nation_cd", length));
            String[] nfyBlPtPostalCd = (JSPUtil.getParameter(request, prefix + "nfy_bl_pt_postal_cd", length));
            String[] cneBlPtCntCd = (JSPUtil.getParameter(request, prefix + "cne_bl_pt_cnt_cd", length));
            String[] consolidateInd = (JSPUtil.getParameter(request, prefix + "consolidate_ind", length));
            String[] shpBlPtTaxType = (JSPUtil.getParameter(request, prefix + "shp_bl_pt_tax_type", length));
            String[] bDesc = (JSPUtil.getParameter(request, prefix + "b_desc", length));
            String[] blwgt = (JSPUtil.getParameter(request, prefix + "blwgt", length));
            String[] nfyBlPtTaxId = (JSPUtil.getParameter(request, prefix + "nfy_bl_pt_tax_id", length));
            String[] trInd = (JSPUtil.getParameter(request, prefix + "tr_ind", length));
            String[] nfyBlPtName = (JSPUtil.getParameter(request, prefix + "nfy_bl_pt_name", length));
            String[] shpBlPtPostalCd = (JSPUtil.getParameter(request, prefix + "shp_bl_pt_postal_cd", length));
            String[] blwgtUnit = (JSPUtil.getParameter(request, prefix + "blwgt_unit", length));
            String[] shpBlPtType = (JSPUtil.getParameter(request, prefix + "shp_bl_pt_type", length));
            String[] shpBlPtStreet = (JSPUtil.getParameter(request, prefix + "shp_bl_pt_street", length));
            String[] nfyBlPtType = (JSPUtil.getParameter(request, prefix + "nfy_bl_pt_type", length));
            String[] cneBlPtStreet = (JSPUtil.getParameter(request, prefix + "cne_bl_pt_street", length));
            String[] cneBlPtTaxType = (JSPUtil.getParameter(request, prefix + "cne_bl_pt_tax_type", length));
            String[] nfyBlPtTaxType = (JSPUtil.getParameter(request, prefix + "nfy_bl_pt_tax_type", length));
            String[] vspol = (JSPUtil.getParameter(request, prefix + "vspol", length));
            String[] vspod = (JSPUtil.getParameter(request, prefix + "vspod", length));
            String[] shipIdInd = (JSPUtil.getParameter(request, prefix + "ship_id_ind", length));
            
            for (int i = 0; i < length; i++) {
                model = new ArgTransmitBlInfoVO();
                if (eta[i] != null)
                    model.setEta(eta[i]);
                if (cneBlPtName[i] != null)
                    model.setCneBlPtName(cneBlPtName[i]);
                if (nfyBlPtAddress[i] != null)
                    model.setNfyBlPtAddress(nfyBlPtAddress[i]);
                if (shpBlPtCity[i] != null)
                    model.setShpBlPtCity(shpBlPtCity[i]);
                if (shpBlPtAddress[i] != null)
                    model.setShpBlPtAddress(shpBlPtAddress[i]);
                if (etd[i] != null)
                    model.setEtd(etd[i]);
                if (foreignNationCd[i] != null)
                    model.setForeignNationCd(foreignNationCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (cneBlPtType[i] != null)
                    model.setCneBlPtType(cneBlPtType[i]);
                if (cneBlPtPostalCd[i] != null)
                    model.setCneBlPtPostalCd(cneBlPtPostalCd[i]);
                if (terminalCd[i] != null)
                    model.setTerminalCd(terminalCd[i]);
                if (exInd[i] != null)
                    model.setExInd(exInd[i]);
                if (nfyBlPtStreet[i] != null)
                    model.setNfyBlPtStreet(nfyBlPtStreet[i]);
                if (vslName[i] != null)
                    model.setVslName(vslName[i]);
                if (commodityCd[i] != null)
                    model.setCommodityCd(commodityCd[i]);
                if (nfyBlPtCntCd[i] != null)
                    model.setNfyBlPtCntCd(nfyBlPtCntCd[i]);
                if (rdTerm[i] != null)
                    model.setRdTerm(rdTerm[i]);
                if (blpod[i] != null)
                    model.setBlpod(blpod[i]);
                if (cneBlPtAddress[i] != null)
                    model.setCneBlPtAddress(cneBlPtAddress[i]);
                if (blnbr[i] != null)
                    model.setBlnbr(blnbr[i]);
                if (shpBlPtCntCd[i] != null)
                    model.setShpBlPtCntCd(shpBlPtCntCd[i]);
                if (nfyBlPtCity[i] != null)
                    model.setNfyBlPtCity(nfyBlPtCity[i]);
                if (cneBlPtTaxId[i] != null)
                    model.setCneBlPtTaxId(cneBlPtTaxId[i]);
                if (blpkg[i] != null)
                    model.setBlpkg(blpkg[i]);
                if (shpBlPtName[i] != null)
                    model.setShpBlPtName(shpBlPtName[i]);
                if (blpol[i] != null)
                    model.setBlpol(blpol[i]);
                if (vslCode[i] != null)
                    model.setVslCode(vslCode[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (markno[i] != null)
                    model.setMarkno(markno[i]);
                if (cneBlPtCity[i] != null)
                    model.setCneBlPtCity(cneBlPtCity[i]);
                if (shpBlPtTaxId[i] != null)
                    model.setShpBlPtTaxId(shpBlPtTaxId[i]);
                if (vslNationCd[i] != null)
                    model.setVslNationCd(vslNationCd[i]);
                if (nfyBlPtPostalCd[i] != null)
                    model.setNfyBlPtPostalCd(nfyBlPtPostalCd[i]);
                if (cneBlPtCntCd[i] != null)
                    model.setCneBlPtCntCd(cneBlPtCntCd[i]);
                if (consolidateInd[i] != null)
                    model.setConsolidateInd(consolidateInd[i]);
                if (shpBlPtTaxType[i] != null)
                    model.setShpBlPtTaxType(shpBlPtTaxType[i]);
                if (bDesc[i] != null)
                    model.setBDesc(bDesc[i]);
                if (blwgt[i] != null)
                    model.setBlwgt(blwgt[i]);
                if (nfyBlPtTaxId[i] != null)
                    model.setNfyBlPtTaxId(nfyBlPtTaxId[i]);
                if (trInd[i] != null)
                    model.setTrInd(trInd[i]);
                if (nfyBlPtName[i] != null)
                    model.setNfyBlPtName(nfyBlPtName[i]);
                if (shpBlPtPostalCd[i] != null)
                    model.setShpBlPtPostalCd(shpBlPtPostalCd[i]);
                if (blwgtUnit[i] != null)
                    model.setBlwgtUnit(blwgtUnit[i]);
                if (shpBlPtType[i] != null)
                    model.setShpBlPtType(shpBlPtType[i]);
                if (shpBlPtStreet[i] != null)
                    model.setShpBlPtStreet(shpBlPtStreet[i]);
                if (nfyBlPtType[i] != null)
                    model.setNfyBlPtType(nfyBlPtType[i]);
                if (cneBlPtStreet[i] != null)
                    model.setCneBlPtStreet(cneBlPtStreet[i]);
                if (cneBlPtTaxType[i] != null)
                    model.setCneBlPtTaxType(cneBlPtTaxType[i]);
                if (nfyBlPtTaxType[i] != null)
                    model.setNfyBlPtTaxType(nfyBlPtTaxType[i]);
                if (vspol[i] != null)
                    model.setVspol(vspol[i]);
                if (vspod[i] != null)
                    model.setVspod(vspod[i]);
                if (shipIdInd[i] != null)
                    model.setShipIdInd(shipIdInd[i]);
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getArgTransmitBlInfoVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return ArgTransmitBlInfoVO[]
	 */
    public ArgTransmitBlInfoVO[] getArgTransmitBlInfoVOs() {
        ArgTransmitBlInfoVO[] vos = (ArgTransmitBlInfoVO[]) models.toArray(new ArgTransmitBlInfoVO[models.size()]);
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
        this.eta = this.eta.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cneBlPtName = this.cneBlPtName.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nfyBlPtAddress = this.nfyBlPtAddress.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shpBlPtCity = this.shpBlPtCity.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shpBlPtAddress = this.shpBlPtAddress.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.etd = this.etd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.foreignNationCd = this.foreignNationCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cneBlPtType = this.cneBlPtType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cneBlPtPostalCd = this.cneBlPtPostalCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.terminalCd = this.terminalCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.exInd = this.exInd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nfyBlPtStreet = this.nfyBlPtStreet.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslName = this.vslName.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.commodityCd = this.commodityCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nfyBlPtCntCd = this.nfyBlPtCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTerm = this.rdTerm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blpod = this.blpod.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cneBlPtAddress = this.cneBlPtAddress.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blnbr = this.blnbr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shpBlPtCntCd = this.shpBlPtCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nfyBlPtCity = this.nfyBlPtCity.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cneBlPtTaxId = this.cneBlPtTaxId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blpkg = this.blpkg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shpBlPtName = this.shpBlPtName.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blpol = this.blpol.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCode = this.vslCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.markno = this.markno.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cneBlPtCity = this.cneBlPtCity.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shpBlPtTaxId = this.shpBlPtTaxId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslNationCd = this.vslNationCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nfyBlPtPostalCd = this.nfyBlPtPostalCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cneBlPtCntCd = this.cneBlPtCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.consolidateInd = this.consolidateInd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shpBlPtTaxType = this.shpBlPtTaxType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bDesc = this.bDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blwgt = this.blwgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nfyBlPtTaxId = this.nfyBlPtTaxId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trInd = this.trInd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nfyBlPtName = this.nfyBlPtName.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shpBlPtPostalCd = this.shpBlPtPostalCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blwgtUnit = this.blwgtUnit.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shpBlPtType = this.shpBlPtType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shpBlPtStreet = this.shpBlPtStreet.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nfyBlPtType = this.nfyBlPtType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cneBlPtStreet = this.cneBlPtStreet.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cneBlPtTaxType = this.cneBlPtTaxType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nfyBlPtTaxType = this.nfyBlPtTaxType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vspol = this.vspol.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vspod = this.vspod.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shipIdInd = this.shipIdInd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
