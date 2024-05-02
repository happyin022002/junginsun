/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgListForWorkWithBkgVO.java
*@FileTitle : BkgListForWorkWithBkgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.21
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.03.21 류대영 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo;

import java.lang.reflect.Field;
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
 * @author 류대영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class BkgListForWorkWithBkgVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<BkgListForWorkWithBkgVO> models = new ArrayList<BkgListForWorkWithBkgVO>();

    /* Column Info */
    private String preLoc = null;

    /* Column Info */
    private String por = null;

    /* Column Info */
    private String bkgVia = null;

    /* Column Info */
    private String rf = null;

    /* Column Info */
    private String srepCd = null;

    /* Column Info */
    private String rd = null;

    /* Column Info */
    private String scRfa = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String preYd = null;

    /* Column Info */
    private String cmdt = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String dg = null;

    /* Column Info */
    private String siVia = null;

    /* Column Info */
    private String srepNm = null;

    /* Column Info */
    private String pol = null;

    /* Column Info */
    private String bdr = null;

    /* Column Info */
    private String del = null;

    /* Column Info */
    private String delNodCd = null;

    /* Column Info */
    private String st = null;

    /* Column Info */
    private String bb = null;

    /* Column Info */
    private String pod = null;

    /* Column Info */
    private String bkgOfcCd = null;

    /* Column Info */
    private String custRefNo = null;

    /* Column Info */
    private String d = null;

    /* Column Info */
    private String porNodCd = null;

    /* Column Info */
    private String cnNt = null;

    /* Column Info */
    private String salesOfc = null;

    /* Column Info */
    private String shipper = null;

    /* Column Info */
    private String hg = null;

    /* Column Info */
    private String tvvd = null;

    /* Column Info */
    private String polNodCd = null;

    /* Column Info */
    private String cmdtNm = null;

    /* Column Info */
    private String si = null;

    /* Column Info */
    private String repCmdt = null;

    /* Column Info */
    private String bkgNo = null;

    /* Column Info */
    private String podNodCd = null;

    /* Column Info */
    private String pstYd = null;

    /* Column Info */
    private String r = null;

    /* Column Info */
    private String seq = null;

    /* Column Info */
    private String pstLoc = null;

    /* Column Info */
    private String awk = null;

    /* Column Info */
    private String shipperCode = null;

    /* Column Info */
    private String broker = null;

    /* Column Info */
    private String forwarder = null;

    /* Column Info */
    private String cntrVol = null;

    /* Column Info */
    private String broKenRoute = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public BkgListForWorkWithBkgVO() {
    }

    public BkgListForWorkWithBkgVO(String ibflag, String pagerows, String seq, String bkgNo, String shipper, String shipperCode, String tvvd, String cntrVol, String por, String porNodCd, String pol, String polNodCd, String preLoc, String preYd, String pstLoc, String pstYd, String pod, String podNodCd, String del, String delNodCd, String st, String r, String d, String bdr, String dg, String rf, String awk, String bb, String rd, String hg, String si, String bkgVia, String siVia, String forwarder, String cnNt, String custRefNo, String srepCd, String srepNm, String repCmdt, String cmdt, String cmdtNm, String salesOfc, String scRfa, String broker, String bkgOfcCd, String broKenRoute) {
        this.preLoc = preLoc;
        this.por = por;
        this.bkgVia = bkgVia;
        this.rf = rf;
        this.srepCd = srepCd;
        this.rd = rd;
        this.scRfa = scRfa;
        this.pagerows = pagerows;
        this.preYd = preYd;
        this.cmdt = cmdt;
        this.ibflag = ibflag;
        this.dg = dg;
        this.siVia = siVia;
        this.srepNm = srepNm;
        this.pol = pol;
        this.bdr = bdr;
        this.del = del;
        this.delNodCd = delNodCd;
        this.st = st;
        this.bb = bb;
        this.pod = pod;
        this.bkgOfcCd = bkgOfcCd;
        this.custRefNo = custRefNo;
        this.d = d;
        this.porNodCd = porNodCd;
        this.cnNt = cnNt;
        this.salesOfc = salesOfc;
        this.shipper = shipper;
        this.hg = hg;
        this.tvvd = tvvd;
        this.polNodCd = polNodCd;
        this.cmdtNm = cmdtNm;
        this.si = si;
        this.repCmdt = repCmdt;
        this.bkgNo = bkgNo;
        this.podNodCd = podNodCd;
        this.pstYd = pstYd;
        this.r = r;
        this.seq = seq;
        this.pstLoc = pstLoc;
        this.awk = awk;
        this.shipperCode = shipperCode;
        this.broker = broker;
        this.forwarder = forwarder;
        this.cntrVol = cntrVol;
        this.broKenRoute = broKenRoute;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("pre_loc", getPreLoc());
        this.hashColumns.put("por", getPor());
        this.hashColumns.put("bkg_via", getBkgVia());
        this.hashColumns.put("rf", getRf());
        this.hashColumns.put("srep_cd", getSrepCd());
        this.hashColumns.put("rd", getRd());
        this.hashColumns.put("sc_rfa", getScRfa());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("pre_yd", getPreYd());
        this.hashColumns.put("cmdt", getCmdt());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("dg", getDg());
        this.hashColumns.put("si_via", getSiVia());
        this.hashColumns.put("srep_nm", getSrepNm());
        this.hashColumns.put("pol", getPol());
        this.hashColumns.put("bdr", getBdr());
        this.hashColumns.put("del", getDel());
        this.hashColumns.put("del_nod_cd", getDelNodCd());
        this.hashColumns.put("st", getSt());
        this.hashColumns.put("bb", getBb());
        this.hashColumns.put("pod", getPod());
        this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
        this.hashColumns.put("cust_ref_no", getCustRefNo());
        this.hashColumns.put("d", getD());
        this.hashColumns.put("por_nod_cd", getPorNodCd());
        this.hashColumns.put("cn_nt", getCnNt());
        this.hashColumns.put("sales_ofc", getSalesOfc());
        this.hashColumns.put("shipper", getShipper());
        this.hashColumns.put("hg", getHg());
        this.hashColumns.put("tvvd", getTvvd());
        this.hashColumns.put("pol_nod_cd", getPolNodCd());
        this.hashColumns.put("cmdt_nm", getCmdtNm());
        this.hashColumns.put("si", getSi());
        this.hashColumns.put("rep_cmdt", getRepCmdt());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("pod_nod_cd", getPodNodCd());
        this.hashColumns.put("pst_yd", getPstYd());
        this.hashColumns.put("r", getR());
        this.hashColumns.put("seq", getSeq());
        this.hashColumns.put("pst_loc", getPstLoc());
        this.hashColumns.put("awk", getAwk());
        this.hashColumns.put("shipper_code", getShipperCode());
        this.hashColumns.put("broker", getBroker());
        this.hashColumns.put("forwarder", getForwarder());
        this.hashColumns.put("cntr_vol", getCntrVol());
        this.hashColumns.put("bro_ken_route", getBroKenRoute());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("pre_loc", "preLoc");
        this.hashFields.put("por", "por");
        this.hashFields.put("bkg_via", "bkgVia");
        this.hashFields.put("rf", "rf");
        this.hashFields.put("srep_cd", "srepCd");
        this.hashFields.put("rd", "rd");
        this.hashFields.put("sc_rfa", "scRfa");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("pre_yd", "preYd");
        this.hashFields.put("cmdt", "cmdt");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("dg", "dg");
        this.hashFields.put("si_via", "siVia");
        this.hashFields.put("srep_nm", "srepNm");
        this.hashFields.put("pol", "pol");
        this.hashFields.put("bdr", "bdr");
        this.hashFields.put("del", "del");
        this.hashFields.put("del_nod_cd", "delNodCd");
        this.hashFields.put("st", "st");
        this.hashFields.put("bb", "bb");
        this.hashFields.put("pod", "pod");
        this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
        this.hashFields.put("cust_ref_no", "custRefNo");
        this.hashFields.put("d", "d");
        this.hashFields.put("por_nod_cd", "porNodCd");
        this.hashFields.put("cn_nt", "cnNt");
        this.hashFields.put("sales_ofc", "salesOfc");
        this.hashFields.put("shipper", "shipper");
        this.hashFields.put("hg", "hg");
        this.hashFields.put("tvvd", "tvvd");
        this.hashFields.put("pol_nod_cd", "polNodCd");
        this.hashFields.put("cmdt_nm", "cmdtNm");
        this.hashFields.put("si", "si");
        this.hashFields.put("rep_cmdt", "repCmdt");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("pod_nod_cd", "podNodCd");
        this.hashFields.put("pst_yd", "pstYd");
        this.hashFields.put("r", "r");
        this.hashFields.put("seq", "seq");
        this.hashFields.put("pst_loc", "pstLoc");
        this.hashFields.put("awk", "awk");
        this.hashFields.put("shipper_code", "shipperCode");
        this.hashFields.put("broker", "broker");
        this.hashFields.put("forwarder", "forwarder");
        this.hashFields.put("cntr_vol", "cntrVol");
        this.hashFields.put("bro_ken_route", "broKenRoute");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return preLoc
	 */
    public String getPreLoc() {
        return this.preLoc;
    }

    /**
	 * Column Info
	 * @return por
	 */
    public String getPor() {
        return this.por;
    }

    /**
	 * Column Info
	 * @return bkgVia
	 */
    public String getBkgVia() {
        return this.bkgVia;
    }

    /**
	 * Column Info
	 * @return rf
	 */
    public String getRf() {
        return this.rf;
    }

    /**
	 * Column Info
	 * @return srepCd
	 */
    public String getSrepCd() {
        return this.srepCd;
    }

    /**
	 * Column Info
	 * @return rd
	 */
    public String getRd() {
        return this.rd;
    }

    /**
	 * Column Info
	 * @return scRfa
	 */
    public String getScRfa() {
        return this.scRfa;
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
	 * @return preYd
	 */
    public String getPreYd() {
        return this.preYd;
    }

    /**
	 * Column Info
	 * @return cmdt
	 */
    public String getCmdt() {
        return this.cmdt;
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
	 * @return dg
	 */
    public String getDg() {
        return this.dg;
    }

    /**
	 * Column Info
	 * @return siVia
	 */
    public String getSiVia() {
        return this.siVia;
    }

    /**
	 * Column Info
	 * @return srepNm
	 */
    public String getSrepNm() {
        return this.srepNm;
    }

    /**
	 * Column Info
	 * @return pol
	 */
    public String getPol() {
        return this.pol;
    }

    /**
	 * Column Info
	 * @return bdr
	 */
    public String getBdr() {
        return this.bdr;
    }

    /**
	 * Column Info
	 * @return del
	 */
    public String getDel() {
        return this.del;
    }

    /**
	 * Column Info
	 * @return delNodCd
	 */
    public String getDelNodCd() {
        return this.delNodCd;
    }

    /**
	 * Column Info
	 * @return st
	 */
    public String getSt() {
        return this.st;
    }

    /**
	 * Column Info
	 * @return bb
	 */
    public String getBb() {
        return this.bb;
    }

    /**
	 * Column Info
	 * @return pod
	 */
    public String getPod() {
        return this.pod;
    }

    /**
	 * Column Info
	 * @return bkgOfcCd
	 */
    public String getBkgOfcCd() {
        return this.bkgOfcCd;
    }

    /**
	 * Column Info
	 * @return custRefNo
	 */
    public String getCustRefNo() {
        return this.custRefNo;
    }

    /**
	 * Column Info
	 * @return d
	 */
    public String getD() {
        return this.d;
    }

    /**
	 * Column Info
	 * @return porNodCd
	 */
    public String getPorNodCd() {
        return this.porNodCd;
    }

    /**
	 * Column Info
	 * @return cnNt
	 */
    public String getCnNt() {
        return this.cnNt;
    }

    /**
	 * Column Info
	 * @return salesOfc
	 */
    public String getSalesOfc() {
        return this.salesOfc;
    }

    /**
	 * Column Info
	 * @return shipper
	 */
    public String getShipper() {
        return this.shipper;
    }

    /**
	 * Column Info
	 * @return hg
	 */
    public String getHg() {
        return this.hg;
    }

    /**
	 * Column Info
	 * @return tvvd
	 */
    public String getTvvd() {
        return this.tvvd;
    }

    /**
	 * Column Info
	 * @return polNodCd
	 */
    public String getPolNodCd() {
        return this.polNodCd;
    }

    /**
	 * Column Info
	 * @return cmdtNm
	 */
    public String getCmdtNm() {
        return this.cmdtNm;
    }

    /**
	 * Column Info
	 * @return si
	 */
    public String getSi() {
        return this.si;
    }

    /**
	 * Column Info
	 * @return repCmdt
	 */
    public String getRepCmdt() {
        return this.repCmdt;
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
	 * @return podNodCd
	 */
    public String getPodNodCd() {
        return this.podNodCd;
    }

    /**
	 * Column Info
	 * @return pstYd
	 */
    public String getPstYd() {
        return this.pstYd;
    }

    /**
	 * Column Info
	 * @return r
	 */
    public String getR() {
        return this.r;
    }

    /**
	 * Column Info
	 * @return seq
	 */
    public String getSeq() {
        return this.seq;
    }

    /**
	 * Column Info
	 * @return pstLoc
	 */
    public String getPstLoc() {
        return this.pstLoc;
    }

    /**
	 * Column Info
	 * @return awk
	 */
    public String getAwk() {
        return this.awk;
    }

    /**
	 * Column Info
	 * @return shipperCode
	 */
    public String getShipperCode() {
        return this.shipperCode;
    }

    /**
	 * Column Info
	 * @return broker
	 */
    public String getBroker() {
        return this.broker;
    }

    /**
	 * Column Info
	 * @return forwarder
	 */
    public String getForwarder() {
        return this.forwarder;
    }

    /**
	 * Column Info
	 * @return cntrVol
	 */
    public String getCntrVol() {
        return this.cntrVol;
    }

    /**
	 * Column Info
	 * @param preLoc
	 */
    public void setPreLoc(String preLoc) {
        this.preLoc = preLoc;
    }

    /**
	 * Column Info
	 * @param por
	 */
    public void setPor(String por) {
        this.por = por;
    }

    /**
	 * Column Info
	 * @param bkgVia
	 */
    public void setBkgVia(String bkgVia) {
        this.bkgVia = bkgVia;
    }

    /**
	 * Column Info
	 * @param rf
	 */
    public void setRf(String rf) {
        this.rf = rf;
    }

    /**
	 * Column Info
	 * @param srepCd
	 */
    public void setSrepCd(String srepCd) {
        this.srepCd = srepCd;
    }

    /**
	 * Column Info
	 * @param rd
	 */
    public void setRd(String rd) {
        this.rd = rd;
    }

    /**
	 * Column Info
	 * @param scRfa
	 */
    public void setScRfa(String scRfa) {
        this.scRfa = scRfa;
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
	 * @param preYd
	 */
    public void setPreYd(String preYd) {
        this.preYd = preYd;
    }

    /**
	 * Column Info
	 * @param cmdt
	 */
    public void setCmdt(String cmdt) {
        this.cmdt = cmdt;
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
	 * @param dg
	 */
    public void setDg(String dg) {
        this.dg = dg;
    }

    /**
	 * Column Info
	 * @param siVia
	 */
    public void setSiVia(String siVia) {
        this.siVia = siVia;
    }

    /**
	 * Column Info
	 * @param srepNm
	 */
    public void setSrepNm(String srepNm) {
        this.srepNm = srepNm;
    }

    /**
	 * Column Info
	 * @param pol
	 */
    public void setPol(String pol) {
        this.pol = pol;
    }

    /**
	 * Column Info
	 * @param bdr
	 */
    public void setBdr(String bdr) {
        this.bdr = bdr;
    }

    /**
	 * Column Info
	 * @param del
	 */
    public void setDel(String del) {
        this.del = del;
    }

    /**
	 * Column Info
	 * @param delNodCd
	 */
    public void setDelNodCd(String delNodCd) {
        this.delNodCd = delNodCd;
    }

    /**
	 * Column Info
	 * @param st
	 */
    public void setSt(String st) {
        this.st = st;
    }

    /**
	 * Column Info
	 * @param bb
	 */
    public void setBb(String bb) {
        this.bb = bb;
    }

    /**
	 * Column Info
	 * @param pod
	 */
    public void setPod(String pod) {
        this.pod = pod;
    }

    /**
	 * Column Info
	 * @param bkgOfcCd
	 */
    public void setBkgOfcCd(String bkgOfcCd) {
        this.bkgOfcCd = bkgOfcCd;
    }

    /**
	 * Column Info
	 * @param custRefNo
	 */
    public void setCustRefNo(String custRefNo) {
        this.custRefNo = custRefNo;
    }

    /**
	 * Column Info
	 * @param d
	 */
    public void setD(String d) {
        this.d = d;
    }

    /**
	 * Column Info
	 * @param porNodCd
	 */
    public void setPorNodCd(String porNodCd) {
        this.porNodCd = porNodCd;
    }

    /**
	 * Column Info
	 * @param cnNt
	 */
    public void setCnNt(String cnNt) {
        this.cnNt = cnNt;
    }

    /**
	 * Column Info
	 * @param salesOfc
	 */
    public void setSalesOfc(String salesOfc) {
        this.salesOfc = salesOfc;
    }

    /**
	 * Column Info
	 * @param shipper
	 */
    public void setShipper(String shipper) {
        this.shipper = shipper;
    }

    /**
	 * Column Info
	 * @param hg
	 */
    public void setHg(String hg) {
        this.hg = hg;
    }

    /**
	 * Column Info
	 * @param tvvd
	 */
    public void setTvvd(String tvvd) {
        this.tvvd = tvvd;
    }

    /**
	 * Column Info
	 * @param polNodCd
	 */
    public void setPolNodCd(String polNodCd) {
        this.polNodCd = polNodCd;
    }

    /**
	 * Column Info
	 * @param cmdtNm
	 */
    public void setCmdtNm(String cmdtNm) {
        this.cmdtNm = cmdtNm;
    }

    /**
	 * Column Info
	 * @param si
	 */
    public void setSi(String si) {
        this.si = si;
    }

    /**
	 * Column Info
	 * @param repCmdt
	 */
    public void setRepCmdt(String repCmdt) {
        this.repCmdt = repCmdt;
    }

    /**
	 * Column Info
	 * @param bkgNo
	 */
    public void setBkgNo(String bkgNo) {
        this.bkgNo = bkgNo;
    }

    /**
	 * Column Info
	 * @param podNodCd
	 */
    public void setPodNodCd(String podNodCd) {
        this.podNodCd = podNodCd;
    }

    /**
	 * Column Info
	 * @param pstYd
	 */
    public void setPstYd(String pstYd) {
        this.pstYd = pstYd;
    }

    /**
	 * Column Info
	 * @param r
	 */
    public void setR(String r) {
        this.r = r;
    }

    /**
	 * Column Info
	 * @param seq
	 */
    public void setSeq(String seq) {
        this.seq = seq;
    }

    /**
	 * Column Info
	 * @param pstLoc
	 */
    public void setPstLoc(String pstLoc) {
        this.pstLoc = pstLoc;
    }

    /**
	 * Column Info
	 * @param awk
	 */
    public void setAwk(String awk) {
        this.awk = awk;
    }

    /**
	 * Column Info
	 * @param shipperCode
	 */
    public void setShipperCode(String shipperCode) {
        this.shipperCode = shipperCode;
    }

    /**
	 * Column Info
	 * @param broker
	 */
    public void setBroker(String broker) {
        this.broker = broker;
    }

    /**
	 * Column Info
	 * @param forwarder
	 */
    public void setForwarder(String forwarder) {
        this.forwarder = forwarder;
    }

    /**
	 * Column Info
	 * @param cntrVol
	 */
    public void setCntrVol(String cntrVol) {
        this.cntrVol = cntrVol;
    }

    public void setBroKenRoute(String broKenRoute) {
        this.broKenRoute = broKenRoute;
    }

    public String getBroKenRoute() {
        return this.broKenRoute;
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
        setPreLoc(JSPUtil.getParameter(request, prefix + "pre_loc", ""));
        setPor(JSPUtil.getParameter(request, prefix + "por", ""));
        setBkgVia(JSPUtil.getParameter(request, prefix + "bkg_via", ""));
        setRf(JSPUtil.getParameter(request, prefix + "rf", ""));
        setSrepCd(JSPUtil.getParameter(request, prefix + "srep_cd", ""));
        setRd(JSPUtil.getParameter(request, prefix + "rd", ""));
        setScRfa(JSPUtil.getParameter(request, prefix + "sc_rfa", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setPreYd(JSPUtil.getParameter(request, prefix + "pre_yd", ""));
        setCmdt(JSPUtil.getParameter(request, prefix + "cmdt", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setDg(JSPUtil.getParameter(request, prefix + "dg", ""));
        setSiVia(JSPUtil.getParameter(request, prefix + "si_via", ""));
        setSrepNm(JSPUtil.getParameter(request, prefix + "srep_nm", ""));
        setPol(JSPUtil.getParameter(request, prefix + "pol", ""));
        setBdr(JSPUtil.getParameter(request, prefix + "bdr", ""));
        setDel(JSPUtil.getParameter(request, prefix + "del", ""));
        setDelNodCd(JSPUtil.getParameter(request, prefix + "del_nod_cd", ""));
        setSt(JSPUtil.getParameter(request, prefix + "st", ""));
        setBb(JSPUtil.getParameter(request, prefix + "bb", ""));
        setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
        setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
        setCustRefNo(JSPUtil.getParameter(request, prefix + "cust_ref_no", ""));
        setD(JSPUtil.getParameter(request, prefix + "d", ""));
        setPorNodCd(JSPUtil.getParameter(request, prefix + "por_nod_cd", ""));
        setCnNt(JSPUtil.getParameter(request, prefix + "cn_nt", ""));
        setSalesOfc(JSPUtil.getParameter(request, prefix + "sales_ofc", ""));
        setShipper(JSPUtil.getParameter(request, prefix + "shipper", ""));
        setHg(JSPUtil.getParameter(request, prefix + "hg", ""));
        setTvvd(JSPUtil.getParameter(request, prefix + "tvvd", ""));
        setPolNodCd(JSPUtil.getParameter(request, prefix + "pol_nod_cd", ""));
        setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
        setSi(JSPUtil.getParameter(request, prefix + "si", ""));
        setRepCmdt(JSPUtil.getParameter(request, prefix + "rep_cmdt", ""));
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setPodNodCd(JSPUtil.getParameter(request, prefix + "pod_nod_cd", ""));
        setPstYd(JSPUtil.getParameter(request, prefix + "pst_yd", ""));
        setR(JSPUtil.getParameter(request, prefix + "r", ""));
        setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
        setPstLoc(JSPUtil.getParameter(request, prefix + "pst_loc", ""));
        setAwk(JSPUtil.getParameter(request, prefix + "awk", ""));
        setShipperCode(JSPUtil.getParameter(request, prefix + "shipper_code", ""));
        setBroker(JSPUtil.getParameter(request, prefix + "broker", ""));
        setForwarder(JSPUtil.getParameter(request, prefix + "forwarder", ""));
        setCntrVol(JSPUtil.getParameter(request, prefix + "cntr_vol", ""));
        setBroKenRoute(JSPUtil.getParameter(request, prefix + "bro_ken_route", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgListForWorkWithBkgVO[]
	 */
    public BkgListForWorkWithBkgVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgListForWorkWithBkgVO[]
	 */
    public BkgListForWorkWithBkgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        BkgListForWorkWithBkgVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] preLoc = (JSPUtil.getParameter(request, prefix + "pre_loc", length));
            String[] por = (JSPUtil.getParameter(request, prefix + "por", length));
            String[] bkgVia = (JSPUtil.getParameter(request, prefix + "bkg_via", length));
            String[] rf = (JSPUtil.getParameter(request, prefix + "rf", length));
            String[] srepCd = (JSPUtil.getParameter(request, prefix + "srep_cd", length));
            String[] rd = (JSPUtil.getParameter(request, prefix + "rd", length));
            String[] scRfa = (JSPUtil.getParameter(request, prefix + "sc_rfa", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] preYd = (JSPUtil.getParameter(request, prefix + "pre_yd", length));
            String[] cmdt = (JSPUtil.getParameter(request, prefix + "cmdt", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] dg = (JSPUtil.getParameter(request, prefix + "dg", length));
            String[] siVia = (JSPUtil.getParameter(request, prefix + "si_via", length));
            String[] srepNm = (JSPUtil.getParameter(request, prefix + "srep_nm", length));
            String[] pol = (JSPUtil.getParameter(request, prefix + "pol", length));
            String[] bdr = (JSPUtil.getParameter(request, prefix + "bdr", length));
            String[] del = (JSPUtil.getParameter(request, prefix + "del", length));
            String[] delNodCd = (JSPUtil.getParameter(request, prefix + "del_nod_cd", length));
            String[] st = (JSPUtil.getParameter(request, prefix + "st", length));
            String[] bb = (JSPUtil.getParameter(request, prefix + "bb", length));
            String[] pod = (JSPUtil.getParameter(request, prefix + "pod", length));
            String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", length));
            String[] custRefNo = (JSPUtil.getParameter(request, prefix + "cust_ref_no", length));
            String[] d = (JSPUtil.getParameter(request, prefix + "d", length));
            String[] porNodCd = (JSPUtil.getParameter(request, prefix + "por_nod_cd", length));
            String[] cnNt = (JSPUtil.getParameter(request, prefix + "cn_nt", length));
            String[] salesOfc = (JSPUtil.getParameter(request, prefix + "sales_ofc", length));
            String[] shipper = (JSPUtil.getParameter(request, prefix + "shipper", length));
            String[] hg = (JSPUtil.getParameter(request, prefix + "hg", length));
            String[] tvvd = (JSPUtil.getParameter(request, prefix + "tvvd", length));
            String[] polNodCd = (JSPUtil.getParameter(request, prefix + "pol_nod_cd", length));
            String[] cmdtNm = (JSPUtil.getParameter(request, prefix + "cmdt_nm", length));
            String[] si = (JSPUtil.getParameter(request, prefix + "si", length));
            String[] repCmdt = (JSPUtil.getParameter(request, prefix + "rep_cmdt", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] podNodCd = (JSPUtil.getParameter(request, prefix + "pod_nod_cd", length));
            String[] pstYd = (JSPUtil.getParameter(request, prefix + "pst_yd", length));
            String[] r = (JSPUtil.getParameter(request, prefix + "r", length));
            String[] seq = (JSPUtil.getParameter(request, prefix + "seq", length));
            String[] pstLoc = (JSPUtil.getParameter(request, prefix + "pst_loc", length));
            String[] awk = (JSPUtil.getParameter(request, prefix + "awk", length));
            String[] shipperCode = (JSPUtil.getParameter(request, prefix + "shipper_code", length));
            String[] broker = (JSPUtil.getParameter(request, prefix + "broker", length));
            String[] forwarder = (JSPUtil.getParameter(request, prefix + "forwarder", length));
            String[] cntrVol = (JSPUtil.getParameter(request, prefix + "cntr_vol", length));
            String[] broKenRoute = (JSPUtil.getParameter(request, prefix + "bro_ken_route", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new BkgListForWorkWithBkgVO();
                if (preLoc[i] != null)
                    model.setPreLoc(preLoc[i]);
                if (por[i] != null)
                    model.setPor(por[i]);
                if (bkgVia[i] != null)
                    model.setBkgVia(bkgVia[i]);
                if (rf[i] != null)
                    model.setRf(rf[i]);
                if (srepCd[i] != null)
                    model.setSrepCd(srepCd[i]);
                if (rd[i] != null)
                    model.setRd(rd[i]);
                if (scRfa[i] != null)
                    model.setScRfa(scRfa[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (preYd[i] != null)
                    model.setPreYd(preYd[i]);
                if (cmdt[i] != null)
                    model.setCmdt(cmdt[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (dg[i] != null)
                    model.setDg(dg[i]);
                if (siVia[i] != null)
                    model.setSiVia(siVia[i]);
                if (srepNm[i] != null)
                    model.setSrepNm(srepNm[i]);
                if (pol[i] != null)
                    model.setPol(pol[i]);
                if (bdr[i] != null)
                    model.setBdr(bdr[i]);
                if (del[i] != null)
                    model.setDel(del[i]);
                if (delNodCd[i] != null)
                    model.setDelNodCd(delNodCd[i]);
                if (st[i] != null)
                    model.setSt(st[i]);
                if (bb[i] != null)
                    model.setBb(bb[i]);
                if (pod[i] != null)
                    model.setPod(pod[i]);
                if (bkgOfcCd[i] != null)
                    model.setBkgOfcCd(bkgOfcCd[i]);
                if (custRefNo[i] != null)
                    model.setCustRefNo(custRefNo[i]);
                if (d[i] != null)
                    model.setD(d[i]);
                if (porNodCd[i] != null)
                    model.setPorNodCd(porNodCd[i]);
                if (cnNt[i] != null)
                    model.setCnNt(cnNt[i]);
                if (salesOfc[i] != null)
                    model.setSalesOfc(salesOfc[i]);
                if (shipper[i] != null)
                    model.setShipper(shipper[i]);
                if (hg[i] != null)
                    model.setHg(hg[i]);
                if (tvvd[i] != null)
                    model.setTvvd(tvvd[i]);
                if (polNodCd[i] != null)
                    model.setPolNodCd(polNodCd[i]);
                if (cmdtNm[i] != null)
                    model.setCmdtNm(cmdtNm[i]);
                if (si[i] != null)
                    model.setSi(si[i]);
                if (repCmdt[i] != null)
                    model.setRepCmdt(repCmdt[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (podNodCd[i] != null)
                    model.setPodNodCd(podNodCd[i]);
                if (pstYd[i] != null)
                    model.setPstYd(pstYd[i]);
                if (r[i] != null)
                    model.setR(r[i]);
                if (seq[i] != null)
                    model.setSeq(seq[i]);
                if (pstLoc[i] != null)
                    model.setPstLoc(pstLoc[i]);
                if (awk[i] != null)
                    model.setAwk(awk[i]);
                if (shipperCode[i] != null)
                    model.setShipperCode(shipperCode[i]);
                if (broker[i] != null)
                    model.setBroker(broker[i]);
                if (forwarder[i] != null)
                    model.setForwarder(forwarder[i]);
                if (cntrVol[i] != null)
                    model.setCntrVol(cntrVol[i]);
                if (broKenRoute[i] != null) 
		    		model.setBroKenRoute(broKenRoute[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getBkgListForWorkWithBkgVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return BkgListForWorkWithBkgVO[]
	 */
    public BkgListForWorkWithBkgVO[] getBkgListForWorkWithBkgVOs() {
        BkgListForWorkWithBkgVO[] vos = (BkgListForWorkWithBkgVO[]) models.toArray(new BkgListForWorkWithBkgVO[models.size()]);
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
        this.preLoc = this.preLoc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.por = this.por.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgVia = this.bkgVia.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rf = this.rf.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.srepCd = this.srepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rd = this.rd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.scRfa = this.scRfa.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.preYd = this.preYd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdt = this.cmdt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dg = this.dg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.siVia = this.siVia.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.srepNm = this.srepNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pol = this.pol.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bdr = this.bdr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.del = this.del.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delNodCd = this.delNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.st = this.st.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bb = this.bb.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pod = this.pod.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgOfcCd = this.bkgOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custRefNo = this.custRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.d = this.d.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.porNodCd = this.porNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cnNt = this.cnNt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.salesOfc = this.salesOfc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shipper = this.shipper.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hg = this.hg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tvvd = this.tvvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polNodCd = this.polNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtNm = this.cmdtNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.si = this.si.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.repCmdt = this.repCmdt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podNodCd = this.podNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pstYd = this.pstYd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.r = this.r.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.seq = this.seq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pstLoc = this.pstLoc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.awk = this.awk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shipperCode = this.shipperCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.broker = this.broker.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.forwarder = this.forwarder.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrVol = this.cntrVol.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.broKenRoute = this.broKenRoute.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
