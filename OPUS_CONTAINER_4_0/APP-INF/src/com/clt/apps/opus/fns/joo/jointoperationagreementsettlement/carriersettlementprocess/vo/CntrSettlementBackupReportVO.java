/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CntrSettlementBackupReportVO.java
*@FileTitle : CntrSettlementBackupReportVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.05
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo;

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
public class CntrSettlementBackupReportVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<CntrSettlementBackupReportVO> models = new ArrayList<CntrSettlementBackupReportVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String slanCd = null;

    /* Column Info */
    private String vvd = null;

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String voyNo = null;

    /* Column Info */
    private String actDepAtdDt = null;

    /* Column Info */
    private String dirCd = null;

    /* Column Info */
    private String loadCall = null;

    /* Column Info */
    private String dischCall = null;

    /* Column Info */
    private String pol = null;

    /* Column Info */
    private String pod = null;

    /* Column Info */
    private String oprCd = null;

    /* Column Info */
    private String id = null;

    /* Column Info */
    private String bay = null;

    /* Column Info */
    private String roww = null;

    /* Column Info */
    private String tier = null;

    /* Column Info */
    private String oriPosition = null;

    /* Column Info */
    private String sztp = null;

    /* Column Info */
    private String weight = null;

    /* Column Info */
    private String fe = null;

    /* Column Info */
    private String teus = null;

    /* Column Info */
    private String warning = null;

    /* Column Info */
    private String imo = null;

    /* Column Info */
    private String imdg = null;

    /* Column Info */
    private String imdg2 = null;

    /* Column Info */
    private String imdg3 = null;

    /* Column Info */
    private String imdg4 = null;

    /* Column Info */
    private String temp = null;

    /* Column Info */
    private String ovs = null;

    /* Column Info */
    private String ovp = null;

    /* Column Info */
    private String ovh = null;

    /* Column Info */
    private String cod = null;

    /* Column Info */
    private int iPage = 1;

    /* Column Info */
    private String dischAtd = null;

    /* Column Info */
    private String status = null;

    /* Column Info */
    private String dischAtdDt = null;

    /* Column Info */
    private String num = null;

    /* Column Info */
    private String codTxt = null;

    /* Column Info */
    private String imdgTxt = null;

    /* Column Info */
    private String tempTxt = null;

    /* Column Info */
    private String oogTxt = null;

    /* Column Info */
    private String crrCd = null;

    /* Column Info */
    private String gubun = null;

    /* Column Info */
    private String excelFlg = null;

    /* Column Info */
    private String preVslCd = null;

    /* Column Info */
    private String preVoyNo = null;

    /* Column Info */
    private String preDirCd = null;

    /* Column Info */
    private String lstPort = null;

    /* Column Info */
    private String searchType = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public CntrSettlementBackupReportVO() {
    }

    public CntrSettlementBackupReportVO(String ibflag, String pagerows, String slanCd, String vvd, String vslCd, String voyNo, String actDepAtdDt, String dirCd, String loadCall, String dischCall, String pol, String pod, String oprCd, String id, String bay, String roww, String tier, String oriPosition, String sztp, String weight, String fe, String teus, String warning, String imo, String imdg, String imdg2, String imdg3, String imdg4, String temp, String ovs, String ovp, String ovh, String cod, String dischAtd, String status, String dischAtdDt, String num, String codTxt, String imdgTxt, String tempTxt, String oogTxt, String crrCd, String gubun, String excelFlg, String preVslCd, String preVoyNo, String preDirCd, String lstPort, String searchType) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.slanCd = slanCd;
        this.vvd = vvd;
        this.vslCd = vslCd;
        this.voyNo = voyNo;
        this.actDepAtdDt = actDepAtdDt;
        this.dirCd = dirCd;
        this.loadCall = loadCall;
        this.dischCall = dischCall;
        this.pol = pol;
        this.pod = pod;
        this.oprCd = oprCd;
        this.id = id;
        this.bay = bay;
        this.roww = roww;
        this.tier = tier;
        this.oriPosition = oriPosition;
        this.sztp = sztp;
        this.weight = weight;
        this.fe = fe;
        this.teus = teus;
        this.warning = warning;
        this.imo = imo;
        this.imdg = imdg;
        this.imdg2 = imdg2;
        this.imdg3 = imdg3;
        this.imdg4 = imdg4;
        this.temp = temp;
        this.ovs = ovs;
        this.ovp = ovp;
        this.ovh = ovh;
        this.cod = cod;
        this.dischAtd = dischAtd;
        this.status = status;
        this.dischAtdDt = dischAtdDt;
        this.num = num;
        this.codTxt = codTxt;
        this.imdgTxt = imdgTxt;
        this.tempTxt = tempTxt;
        this.oogTxt = oogTxt;
        this.crrCd = crrCd;
        this.gubun = gubun;
        this.excelFlg = excelFlg;
        this.preVslCd = preVslCd;
        this.preVoyNo = preVoyNo;
        this.preDirCd = preDirCd;
        this.lstPort = lstPort;
        this.searchType = searchType;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("slan_cd", getSlanCd());
        this.hashColumns.put("vvd", getVvd());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("voy_no", getVoyNo());
        this.hashColumns.put("act_dep_atd_dt", getActDepAtdDt());
        this.hashColumns.put("dir_cd", getDirCd());
        this.hashColumns.put("load_call", getLoadCall());
        this.hashColumns.put("disch_call", getDischCall());
        this.hashColumns.put("pol", getPol());
        this.hashColumns.put("pod", getPod());
        this.hashColumns.put("opr_cd", getOprCd());
        this.hashColumns.put("id", getId());
        this.hashColumns.put("bay", getBay());
        this.hashColumns.put("roww", getRoww());
        this.hashColumns.put("tier", getTier());
        this.hashColumns.put("ori_position", getOriPosition());
        this.hashColumns.put("sztp", getSztp());
        this.hashColumns.put("weight", getWeight());
        this.hashColumns.put("fe", getFe());
        this.hashColumns.put("teus", getTeus());
        this.hashColumns.put("warning", getWarning());
        this.hashColumns.put("imo", getImo());
        this.hashColumns.put("imdg", getImdg());
        this.hashColumns.put("imdg2", getImdg2());
        this.hashColumns.put("imdg3", getImdg3());
        this.hashColumns.put("imdg4", getImdg4());
        this.hashColumns.put("temp", getTemp());
        this.hashColumns.put("ovs", getOvs());
        this.hashColumns.put("ovp", getOvp());
        this.hashColumns.put("ovh", getOvh());
        this.hashColumns.put("cod", getCod());
        this.hashColumns.put("disch_atd", getDischAtd());
        this.hashColumns.put("status", getStatus());
        this.hashColumns.put("disch_atd_dt", getDischAtdDt());
        this.hashColumns.put("num", getNum());
        this.hashColumns.put("cod_txt", getCodTxt());
        this.hashColumns.put("imdg_txt", getImdgTxt());
        this.hashColumns.put("temp_txt", getTempTxt());
        this.hashColumns.put("oog_txt", getOogTxt());
        this.hashColumns.put("crr_cd", getCrrCd());
        this.hashColumns.put("gubun", getGubun());
        this.hashColumns.put("excel_flg", getExcelFlg());
        this.hashColumns.put("pre_vsl_cd", getPreVslCd());
        this.hashColumns.put("pre_voy_no", getPreVoyNo());
        this.hashColumns.put("pre_dir_cd", getPreDirCd());
        this.hashColumns.put("lst_port", getLstPort());
        this.hashColumns.put("search_type", getSearchType());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("slan_cd", "slanCd");
        this.hashFields.put("vvd", "vvd");
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("voy_no", "voyNo");
        this.hashFields.put("act_dep_atd_dt", "actDepAtdDt");
        this.hashFields.put("dir_cd", "dirCd");
        this.hashFields.put("load_call", "loadCall");
        this.hashFields.put("disch_call", "dischCall");
        this.hashFields.put("pol", "pol");
        this.hashFields.put("pod", "pod");
        this.hashFields.put("opr_cd", "oprCd");
        this.hashFields.put("id", "id");
        this.hashFields.put("bay", "bay");
        this.hashFields.put("roww", "roww");
        this.hashFields.put("tier", "tier");
        this.hashFields.put("ori_position", "oriPosition");
        this.hashFields.put("sztp", "sztp");
        this.hashFields.put("weight", "weight");
        this.hashFields.put("fe", "fe");
        this.hashFields.put("teus", "teus");
        this.hashFields.put("warning", "warning");
        this.hashFields.put("imo", "imo");
        this.hashFields.put("imdg", "imdg");
        this.hashFields.put("imdg2", "imdg2");
        this.hashFields.put("imdg3", "imdg3");
        this.hashFields.put("imdg4", "imdg4");
        this.hashFields.put("temp", "temp");
        this.hashFields.put("ovs", "ovs");
        this.hashFields.put("ovp", "ovp");
        this.hashFields.put("ovh", "ovh");
        this.hashFields.put("cod", "cod");
        this.hashFields.put("disch_atd", "dischAtd");
        this.hashFields.put("status", "status");
        this.hashFields.put("disch_atd_dt", "dischAtdDt");
        this.hashFields.put("num", "num");
        this.hashFields.put("cod_txt", "codTxt");
        this.hashFields.put("imdg_txt", "imdgTxt");
        this.hashFields.put("temp_txt", "tempTxt");
        this.hashFields.put("oog_txt", "oogTxt");
        this.hashFields.put("crr_cd", "crrCd");
        this.hashFields.put("gubun", "gubun");
        this.hashFields.put("excel_flg", "excelFlg");
        this.hashFields.put("pre_vsl_cd", "preVslCd");
        this.hashFields.put("pre_voy_no", "preVoyNo");
        this.hashFields.put("pre_dir_cd", "preDirCd");
        this.hashFields.put("lst_port", "lstPort");
        this.hashFields.put("search_type", "searchType");
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
	 * @param String slanCd
	 */
    public void setSlanCd(String slanCd) {
        this.slanCd = slanCd;
    }

    /**
	 * 
	 * @return String slanCd
	 */
    public String getSlanCd() {
        return this.slanCd;
    }

    /**
	 *
	 * @param String vvd
	 */
    public void setVvd(String vvd) {
        this.vvd = vvd;
    }

    /**
	 * 
	 * @return String vvd
	 */
    public String getVvd() {
        return this.vvd;
    }

    /**
	 *
	 * @param String vslCd
	 */
    public void setVslCd(String vslCd) {
        this.vslCd = vslCd;
    }

    /**
	 * 
	 * @return String vslCd
	 */
    public String getVslCd() {
        return this.vslCd;
    }

    /**
	 *
	 * @param String voyNo
	 */
    public void setVoyNo(String voyNo) {
        this.voyNo = voyNo;
    }

    /**
	 * 
	 * @return String voyNo
	 */
    public String getVoyNo() {
        return this.voyNo;
    }

    /**
	 *
	 * @param String actDepAtdDt
	 */
    public void setActDepAtdDt(String actDepAtdDt) {
        this.actDepAtdDt = actDepAtdDt;
    }

    /**
	 * 
	 * @return String actDepAtdDt
	 */
    public String getActDepAtdDt() {
        return this.actDepAtdDt;
    }

    /**
	 *
	 * @param String dirCd
	 */
    public void setDirCd(String dirCd) {
        this.dirCd = dirCd;
    }

    /**
	 * 
	 * @return String dirCd
	 */
    public String getDirCd() {
        return this.dirCd;
    }

    /**
	 *
	 * @param String loadCall
	 */
    public void setLoadCall(String loadCall) {
        this.loadCall = loadCall;
    }

    /**
	 * 
	 * @return String loadCall
	 */
    public String getLoadCall() {
        return this.loadCall;
    }

    /**
	 *
	 * @param String dischCall
	 */
    public void setDischCall(String dischCall) {
        this.dischCall = dischCall;
    }

    /**
	 * 
	 * @return String dischCall
	 */
    public String getDischCall() {
        return this.dischCall;
    }

    /**
	 *
	 * @param String pol
	 */
    public void setPol(String pol) {
        this.pol = pol;
    }

    /**
	 * 
	 * @return String pol
	 */
    public String getPol() {
        return this.pol;
    }

    /**
	 *
	 * @param String pod
	 */
    public void setPod(String pod) {
        this.pod = pod;
    }

    /**
	 * 
	 * @return String pod
	 */
    public String getPod() {
        return this.pod;
    }

    /**
	 *
	 * @param String oprCd
	 */
    public void setOprCd(String oprCd) {
        this.oprCd = oprCd;
    }

    /**
	 * 
	 * @return String oprCd
	 */
    public String getOprCd() {
        return this.oprCd;
    }

    /**
	 *
	 * @param String id
	 */
    public void setId(String id) {
        this.id = id;
    }

    /**
	 * 
	 * @return String id
	 */
    public String getId() {
        return this.id;
    }

    /**
	 *
	 * @param String bay
	 */
    public void setBay(String bay) {
        this.bay = bay;
    }

    /**
	 * 
	 * @return String bay
	 */
    public String getBay() {
        return this.bay;
    }

    /**
	 *
	 * @param String roww
	 */
    public void setRoww(String roww) {
        this.roww = roww;
    }

    /**
	 * 
	 * @return String roww
	 */
    public String getRoww() {
        return this.roww;
    }

    /**
	 *
	 * @param String tier
	 */
    public void setTier(String tier) {
        this.tier = tier;
    }

    /**
	 * 
	 * @return String tier
	 */
    public String getTier() {
        return this.tier;
    }

    /**
	 *
	 * @param String oriPosition
	 */
    public void setOriPosition(String oriPosition) {
        this.oriPosition = oriPosition;
    }

    /**
	 * 
	 * @return String oriPosition
	 */
    public String getOriPosition() {
        return this.oriPosition;
    }

    /**
	 *
	 * @param String sztp
	 */
    public void setSztp(String sztp) {
        this.sztp = sztp;
    }

    /**
	 * 
	 * @return String sztp
	 */
    public String getSztp() {
        return this.sztp;
    }

    /**
	 *
	 * @param String weight
	 */
    public void setWeight(String weight) {
        this.weight = weight;
    }

    /**
	 * 
	 * @return String weight
	 */
    public String getWeight() {
        return this.weight;
    }

    /**
	 *
	 * @param String fe
	 */
    public void setFe(String fe) {
        this.fe = fe;
    }

    /**
	 * 
	 * @return String fe
	 */
    public String getFe() {
        return this.fe;
    }

    /**
	 *
	 * @param String teus
	 */
    public void setTeus(String teus) {
        this.teus = teus;
    }

    /**
	 * 
	 * @return String teus
	 */
    public String getTeus() {
        return this.teus;
    }

    /**
	 *
	 * @param String warning
	 */
    public void setWarning(String warning) {
        this.warning = warning;
    }

    /**
	 * 
	 * @return String warning
	 */
    public String getWarning() {
        return this.warning;
    }

    /**
	 *
	 * @param String imo
	 */
    public void setImo(String imo) {
        this.imo = imo;
    }

    /**
	 * 
	 * @return String imo
	 */
    public String getImo() {
        return this.imo;
    }

    /**
	 *
	 * @param String imdg
	 */
    public void setImdg(String imdg) {
        this.imdg = imdg;
    }

    /**
	 * 
	 * @return String imdg
	 */
    public String getImdg() {
        return this.imdg;
    }

    /**
	 *
	 * @param String imdg2
	 */
    public void setImdg2(String imdg2) {
        this.imdg2 = imdg2;
    }

    /**
	 * 
	 * @return String imdg2
	 */
    public String getImdg2() {
        return this.imdg2;
    }

    /**
	 *
	 * @param String imdg3
	 */
    public void setImdg3(String imdg3) {
        this.imdg3 = imdg3;
    }

    /**
	 * 
	 * @return String imdg3
	 */
    public String getImdg3() {
        return this.imdg3;
    }

    /**
	 *
	 * @param String imdg4
	 */
    public void setImdg4(String imdg4) {
        this.imdg4 = imdg4;
    }

    /**
	 * 
	 * @return String imdg4
	 */
    public String getImdg4() {
        return this.imdg4;
    }

    /**
	 *
	 * @param String temp
	 */
    public void setTemp(String temp) {
        this.temp = temp;
    }

    /**
	 * 
	 * @return String temp
	 */
    public String getTemp() {
        return this.temp;
    }

    /**
	 *
	 * @param String ovs
	 */
    public void setOvs(String ovs) {
        this.ovs = ovs;
    }

    /**
	 * 
	 * @return String ovs
	 */
    public String getOvs() {
        return this.ovs;
    }

    /**
	 *
	 * @param String ovp
	 */
    public void setOvp(String ovp) {
        this.ovp = ovp;
    }

    /**
	 * 
	 * @return String ovp
	 */
    public String getOvp() {
        return this.ovp;
    }

    /**
	 *
	 * @param String ovh
	 */
    public void setOvh(String ovh) {
        this.ovh = ovh;
    }

    /**
	 * 
	 * @return String ovh
	 */
    public String getOvh() {
        return this.ovh;
    }

    /**
	 *
	 * @param String cod
	 */
    public void setCod(String cod) {
        this.cod = cod;
    }

    /**
	 * 
	 * @return String cod
	 */
    public String getCod() {
        return this.cod;
    }

    public void setIPage(int ipage) {
        this.iPage = ipage;
    }

    public int getIPage() {
        return this.iPage;
    }

    public void setDischAtd(String dischAtd) {
        this.dischAtd = dischAtd;
    }

    public String getDischAtd() {
        return this.dischAtd;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public void setDischAtdDt(String dischAtdDt) {
        this.dischAtdDt = dischAtdDt;
    }

    public String getDischAtdDt() {
        return this.dischAtdDt;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getNum() {
        return this.num;
    }

    public void setCodTxt(String codTxt) {
        this.codTxt = codTxt;
    }

    public String getCodTxt() {
        return this.codTxt;
    }

    public void setImdgTxt(String imdgTxt) {
        this.imdgTxt = imdgTxt;
    }

    public String getImdgTxt() {
        return this.imdgTxt;
    }

    public void setTempTxt(String tempTxt) {
        this.tempTxt = tempTxt;
    }

    public String getTempTxt() {
        return this.tempTxt;
    }

    public void setOogTxt(String oogTxt) {
        this.oogTxt = oogTxt;
    }

    public String getOogTxt() {
        return this.oogTxt;
    }

    public void setCrrCd(String crrCd) {
        this.crrCd = crrCd;
    }

    public String getCrrCd() {
        return this.crrCd;
    }

    public void setGubun(String gubun) {
        this.gubun = gubun;
    }

    public String getGubun() {
        return this.gubun;
    }

    public void setExcelFlg(String excelFlg) {
        this.excelFlg = excelFlg;
    }

    public String getExcelFlg() {
        return this.excelFlg;
    }

    public void setPreVslCd(String preVslCd) {
        this.preVslCd = preVslCd;
    }

    public String getPreVslCd() {
        return this.preVslCd;
    }

    public void setPreVoyNo(String preVoyNo) {
        this.preVoyNo = preVoyNo;
    }

    public String getPreVoyNo() {
        return this.preVoyNo;
    }

    public void setPreDirCd(String preDirCd) {
        this.preDirCd = preDirCd;
    }

    public String getPreDirCd() {
        return this.preDirCd;
    }

    public void setLstPort(String lstPort) {
        this.lstPort = lstPort;
    }

    public String getLstPort() {
        return this.lstPort;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getSearchType() {
        return this.searchType;
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
        setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
        setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
        setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
        setVoyNo(JSPUtil.getParameter(request, prefix + "voy_no", ""));
        setActDepAtdDt(JSPUtil.getParameter(request, prefix + "act_dep_atd_dt", ""));
        setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
        setLoadCall(JSPUtil.getParameter(request, prefix + "load_call", ""));
        setDischCall(JSPUtil.getParameter(request, prefix + "disch_call", ""));
        setPol(JSPUtil.getParameter(request, prefix + "pol", ""));
        setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
        setOprCd(JSPUtil.getParameter(request, prefix + "opr_cd", ""));
        setId(JSPUtil.getParameter(request, prefix + "id", ""));
        setBay(JSPUtil.getParameter(request, prefix + "bay", ""));
        setRoww(JSPUtil.getParameter(request, prefix + "roww", ""));
        setTier(JSPUtil.getParameter(request, prefix + "tier", ""));
        setOriPosition(JSPUtil.getParameter(request, prefix + "ori_position", ""));
        setSztp(JSPUtil.getParameter(request, prefix + "sztp", ""));
        setWeight(JSPUtil.getParameter(request, prefix + "weight", ""));
        setFe(JSPUtil.getParameter(request, prefix + "fe", ""));
        setTeus(JSPUtil.getParameter(request, prefix + "teus", ""));
        setWarning(JSPUtil.getParameter(request, prefix + "warning", ""));
        setImo(JSPUtil.getParameter(request, prefix + "imo", ""));
        setImdg(JSPUtil.getParameter(request, prefix + "imdg", ""));
        setImdg2(JSPUtil.getParameter(request, prefix + "imdg2", ""));
        setImdg3(JSPUtil.getParameter(request, prefix + "imdg3", ""));
        setImdg4(JSPUtil.getParameter(request, prefix + "imdg4", ""));
        setTemp(JSPUtil.getParameter(request, prefix + "temp", ""));
        setOvs(JSPUtil.getParameter(request, prefix + "ovs", ""));
        setOvp(JSPUtil.getParameter(request, prefix + "ovp", ""));
        setOvh(JSPUtil.getParameter(request, prefix + "ovh", ""));
        setCod(JSPUtil.getParameter(request, prefix + "cod", ""));
        setIPage(JSPUtil.getParameterAsInt(request, prefix + "iPage", 1));
        setDischAtd(JSPUtil.getParameter(request, prefix + "disch_atd", ""));
        setStatus(JSPUtil.getParameter(request, prefix + "status", ""));
        setDischAtdDt(JSPUtil.getParameter(request, prefix + "disch_atd_dt", ""));
        setNum(JSPUtil.getParameter(request, prefix + "num", ""));
        setCodTxt(JSPUtil.getParameter(request, prefix + "cod_txt", ""));
        setImdgTxt(JSPUtil.getParameter(request, prefix + "imdg_txt", ""));
        setTempTxt(JSPUtil.getParameter(request, prefix + "temp_txt", ""));
        setOogTxt(JSPUtil.getParameter(request, prefix + "oog_txt", ""));
        setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
        setGubun(JSPUtil.getParameter(request, prefix + "gubun", ""));
        setExcelFlg(JSPUtil.getParameter(request, prefix + "excel_flg", ""));
        setPreVslCd(JSPUtil.getParameter(request, prefix + "pre_vsl_cd", ""));
        setPreVoyNo(JSPUtil.getParameter(request, prefix + "pre_voy_no", ""));
        setPreDirCd(JSPUtil.getParameter(request, prefix + "pre_dir_cd", ""));
        setLstPort(JSPUtil.getParameter(request, prefix + "lst_port", ""));
        setSearchType(JSPUtil.getParameter(request, prefix + "search_type", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CntrSettlementBackupReportVO[]
	 */
    public CntrSettlementBackupReportVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CntrSettlementBackupReportVO[]
	 */
    public CntrSettlementBackupReportVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        CntrSettlementBackupReportVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] slanCd = (JSPUtil.getParameter(request, prefix + "slan_cd", length));
            String[] vvd = (JSPUtil.getParameter(request, prefix + "vvd", length));
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] voyNo = (JSPUtil.getParameter(request, prefix + "voy_no", length));
            String[] actDepAtdDt = (JSPUtil.getParameter(request, prefix + "act_dep_atd_dt", length));
            String[] dirCd = (JSPUtil.getParameter(request, prefix + "dir_cd", length));
            String[] loadCall = (JSPUtil.getParameter(request, prefix + "load_call", length));
            String[] dischCall = (JSPUtil.getParameter(request, prefix + "disch_call", length));
            String[] pol = (JSPUtil.getParameter(request, prefix + "pol", length));
            String[] pod = (JSPUtil.getParameter(request, prefix + "pod", length));
            String[] oprCd = (JSPUtil.getParameter(request, prefix + "opr_cd", length));
            String[] id = (JSPUtil.getParameter(request, prefix + "id", length));
            String[] bay = (JSPUtil.getParameter(request, prefix + "bay", length));
            String[] roww = (JSPUtil.getParameter(request, prefix + "roww", length));
            String[] tier = (JSPUtil.getParameter(request, prefix + "tier", length));
            String[] oriPosition = (JSPUtil.getParameter(request, prefix + "ori_position", length));
            String[] sztp = (JSPUtil.getParameter(request, prefix + "sztp", length));
            String[] weight = (JSPUtil.getParameter(request, prefix + "weight", length));
            String[] fe = (JSPUtil.getParameter(request, prefix + "fe", length));
            String[] teus = (JSPUtil.getParameter(request, prefix + "teus", length));
            String[] warning = (JSPUtil.getParameter(request, prefix + "warning", length));
            String[] imo = (JSPUtil.getParameter(request, prefix + "imo", length));
            String[] imdg = (JSPUtil.getParameter(request, prefix + "imdg", length));
            String[] imdg2 = (JSPUtil.getParameter(request, prefix + "imdg2", length));
            String[] imdg3 = (JSPUtil.getParameter(request, prefix + "imdg3", length));
            String[] imdg4 = (JSPUtil.getParameter(request, prefix + "imdg4", length));
            String[] temp = (JSPUtil.getParameter(request, prefix + "temp", length));
            String[] ovs = (JSPUtil.getParameter(request, prefix + "ovs", length));
            String[] ovp = (JSPUtil.getParameter(request, prefix + "ovp", length));
            String[] ovh = (JSPUtil.getParameter(request, prefix + "ovh", length));
            String[] cod = (JSPUtil.getParameter(request, prefix + "cod", length));
            String[] dischAtd = (JSPUtil.getParameter(request, prefix + "disch_atd", length));
            String[] status = (JSPUtil.getParameter(request, prefix + "status", length));
            String[] dischAtdDt = (JSPUtil.getParameter(request, prefix + "disch_atd_dt", length));
            String[] num = (JSPUtil.getParameter(request, prefix + "num", length));
            String[] codTxt = (JSPUtil.getParameter(request, prefix + "cod_txt", length));
            String[] imdgTxt = (JSPUtil.getParameter(request, prefix + "imdg_txt", length));
            String[] tempTxt = (JSPUtil.getParameter(request, prefix + "temp_txt", length));
            String[] oogTxt = (JSPUtil.getParameter(request, prefix + "oog_txt", length));
            String[] crrCd = (JSPUtil.getParameter(request, prefix + "crr_cd", length));
            String[] gubun = (JSPUtil.getParameter(request, prefix + "gubun", length));
            String[] excelFlg = (JSPUtil.getParameter(request, prefix + "excel_flg", length));
            String[] preVslCd = (JSPUtil.getParameter(request, prefix + "pre_vsl_cd", length));
            String[] preVoyNo = (JSPUtil.getParameter(request, prefix + "pre_voy_no", length));
            String[] preDirCd = (JSPUtil.getParameter(request, prefix + "pre_dir_cd", length));
            String[] lstPort = (JSPUtil.getParameter(request, prefix + "lst_port", length));
            String[] searchType = (JSPUtil.getParameter(request, prefix + "search_type", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new CntrSettlementBackupReportVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (slanCd[i] != null)
                    model.setSlanCd(slanCd[i]);
                if (vvd[i] != null)
                    model.setVvd(vvd[i]);
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (voyNo[i] != null)
                    model.setVoyNo(voyNo[i]);
                if (actDepAtdDt[i] != null)
                    model.setActDepAtdDt(actDepAtdDt[i]);
                if (dirCd[i] != null)
                    model.setDirCd(dirCd[i]);
                if (loadCall[i] != null)
                    model.setLoadCall(loadCall[i]);
                if (dischCall[i] != null)
                    model.setDischCall(dischCall[i]);
                if (pol[i] != null)
                    model.setPol(pol[i]);
                if (pod[i] != null)
                    model.setPod(pod[i]);
                if (oprCd[i] != null)
                    model.setOprCd(oprCd[i]);
                if (id[i] != null)
                    model.setId(id[i]);
                if (bay[i] != null)
                    model.setBay(bay[i]);
                if (roww[i] != null)
                    model.setRoww(roww[i]);
                if (tier[i] != null)
                    model.setTier(tier[i]);
                if (oriPosition[i] != null)
                    model.setOriPosition(oriPosition[i]);
                if (sztp[i] != null)
                    model.setSztp(sztp[i]);
                if (weight[i] != null)
                    model.setWeight(weight[i]);
                if (fe[i] != null)
                    model.setFe(fe[i]);
                if (teus[i] != null)
                    model.setTeus(teus[i]);
                if (warning[i] != null)
                    model.setWarning(warning[i]);
                if (imo[i] != null)
                    model.setImo(imo[i]);
                if (imdg[i] != null)
                    model.setImdg(imdg[i]);
                if (imdg2[i] != null)
                    model.setImdg2(imdg2[i]);
                if (imdg3[i] != null)
                    model.setImdg3(imdg3[i]);
                if (imdg4[i] != null)
                    model.setImdg4(imdg4[i]);
                if (temp[i] != null)
                    model.setTemp(temp[i]);
                if (ovs[i] != null)
                    model.setOvs(ovs[i]);
                if (ovp[i] != null)
                    model.setOvp(ovp[i]);
                if (ovh[i] != null)
                    model.setOvh(ovh[i]);
                if (cod[i] != null)
                    model.setCod(cod[i]);
                if (dischAtd[i] != null)
                    model.setDischAtd(dischAtd[i]);
                if (status[i] != null)
                    model.setStatus(status[i]);
                if (dischAtdDt[i] != null)
                    model.setDischAtdDt(dischAtdDt[i]);
                if (num[i] != null)
                    model.setNum(num[i]);
                if (codTxt[i] != null)
                    model.setCodTxt(codTxt[i]);
                if (imdgTxt[i] != null)
                    model.setImdgTxt(imdgTxt[i]);
                if (tempTxt[i] != null)
                    model.setTempTxt(tempTxt[i]);
                if (oogTxt[i] != null)
                    model.setOogTxt(oogTxt[i]);
                if (crrCd[i] != null)
                    model.setCrrCd(crrCd[i]);
                if (gubun[i] != null)
                    model.setGubun(gubun[i]);
                if (excelFlg[i] != null)
                    model.setExcelFlg(excelFlg[i]);
                if (preVslCd[i] != null)
                    model.setPreVslCd(preVslCd[i]);
                if (preVoyNo[i] != null)
                    model.setPreVoyNo(preVoyNo[i]);
                if (preDirCd[i] != null)
                    model.setPreDirCd(preDirCd[i]);
                if (lstPort[i] != null)
                    model.setLstPort(lstPort[i]);
                if (searchType[i] != null) 
		    		model.setSearchType(searchType[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getCntrSettlementBackupReportVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return CntrSettlementBackupReportVO[]
	 */
    public CntrSettlementBackupReportVO[] getCntrSettlementBackupReportVOs() {
        CntrSettlementBackupReportVO[] vos = (CntrSettlementBackupReportVO[]) models.toArray(new CntrSettlementBackupReportVO[models.size()]);
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
        this.slanCd = this.slanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvd = this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.voyNo = this.voyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.actDepAtdDt = this.actDepAtdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dirCd = this.dirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.loadCall = this.loadCall.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dischCall = this.dischCall.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pol = this.pol.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pod = this.pod.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oprCd = this.oprCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.id = this.id.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bay = this.bay.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.roww = this.roww.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tier = this.tier.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oriPosition = this.oriPosition.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sztp = this.sztp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.weight = this.weight.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fe = this.fe.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.teus = this.teus.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.warning = this.warning.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imo = this.imo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdg = this.imdg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdg2 = this.imdg2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdg3 = this.imdg3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdg4 = this.imdg4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.temp = this.temp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ovs = this.ovs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ovp = this.ovp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ovh = this.ovh.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cod = this.cod.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dischAtd = this.dischAtd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.status = this.status.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dischAtdDt = this.dischAtdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.num = this.num.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.codTxt = this.codTxt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgTxt = this.imdgTxt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tempTxt = this.tempTxt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oogTxt = this.oogTxt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.crrCd = this.crrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.gubun = this.gubun.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.excelFlg = this.excelFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.preVslCd = this.preVslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.preVoyNo = this.preVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.preDirCd = this.preDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lstPort = this.lstPort.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.searchType = this.searchType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
