/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Edi315PrefixBkgVvdVO.java
*@FileTitle : Edi315PrefixBkgVvdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.30
*@LastModifier : 전병석
*@LastVersion : 1.0
* 2009.09.30 전병석 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send.vo;

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
 * @author 전병석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class Edi315PrefixBkgVvdVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<Edi315PrefixBkgVvdVO> models = new ArrayList<Edi315PrefixBkgVvdVO>();

    /* Column Info */
    private String polatd1 = null;

    /* Column Info */
    private String podatd1 = null;

    /* Column Info */
    private String blpol1 = null;

    /* Column Info */
    private String podatd1Gmt = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String vslFullname1 = null;

    /* Column Info */
    private String podetd1 = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String poleta1 = null;

    /* Column Info */
    private String polFullname1 = null;

    /* Column Info */
    private String polatd1Gmt = null;

    /* Column Info */
    private String polata1Gmt = null;

    /* Column Info */
    private String blpod1 = null;

    /* Column Info */
    private String podata1 = null;

    /* Column Info */
    private String bvvd1 = null;

    /* Column Info */
    private String vslLloydcode1 = null;

    /* Column Info */
    private String poletd1 = null;

    /* Column Info */
    private String poletd1Gmt = null;

    /* Column Info */
    private String podeta1 = null;

    /* Column Info */
    private String podeta1Gmt = null;

    /* Column Info */
    private String vslCallsign1 = null;

    /* Column Info */
    private String podetd1Gmt = null;

    /* Column Info */
    private String polata1 = null;

    /* Column Info */
    private String podata1Gmt = null;

    /* Column Info */
    private String poleta1Gmt = null;

    /* Column Info */
    private String podFullname1 = null;

    /* Column Info */
    private String vslConsortVoyNo = null;

    /* Column Info */
    private String vslCntCd = null;

    /* Column Info */
    private String polAmsqual1 = null;

    /* Column Info */
    private String polAmsport1 = null;

    /* Column Info */
    private String podAmsqual1 = null;

    /* Column Info */
    private String podAmsport1 = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public Edi315PrefixBkgVvdVO() {
    }

    public Edi315PrefixBkgVvdVO(String ibflag, String pagerows, String bvvd1, String vslCallsign1, String vslLloydcode1, String vslFullname1, String blpol1, String polFullname1, String blpod1, String podFullname1, String poleta1, String poleta1Gmt, String polata1, String polata1Gmt, String poletd1, String poletd1Gmt, String polatd1, String polatd1Gmt, String podeta1, String podeta1Gmt, String podata1, String podata1Gmt, String podetd1, String podetd1Gmt, String podatd1, String podatd1Gmt, String vslConsortVoyNo, String vslCntCd, String polAmsqual1, String polAmsport1, String podAmsqual1, String podAmsport1) {
        this.polatd1 = polatd1;
        this.podatd1 = podatd1;
        this.blpol1 = blpol1;
        this.podatd1Gmt = podatd1Gmt;
        this.pagerows = pagerows;
        this.vslFullname1 = vslFullname1;
        this.podetd1 = podetd1;
        this.ibflag = ibflag;
        this.poleta1 = poleta1;
        this.polFullname1 = polFullname1;
        this.polatd1Gmt = polatd1Gmt;
        this.polata1Gmt = polata1Gmt;
        this.blpod1 = blpod1;
        this.podata1 = podata1;
        this.bvvd1 = bvvd1;
        this.vslLloydcode1 = vslLloydcode1;
        this.poletd1 = poletd1;
        this.poletd1Gmt = poletd1Gmt;
        this.podeta1 = podeta1;
        this.podeta1Gmt = podeta1Gmt;
        this.vslCallsign1 = vslCallsign1;
        this.podetd1Gmt = podetd1Gmt;
        this.polata1 = polata1;
        this.podata1Gmt = podata1Gmt;
        this.poleta1Gmt = poleta1Gmt;
        this.podFullname1 = podFullname1;
        this.vslConsortVoyNo = vslConsortVoyNo;
        this.vslCntCd = vslCntCd;
        this.polAmsqual1 = polAmsqual1;
        this.polAmsport1 = polAmsport1;
        this.podAmsqual1 = podAmsqual1;
        this.podAmsport1 = podAmsport1;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("polatd1", getPolatd1());
        this.hashColumns.put("podatd1", getPodatd1());
        this.hashColumns.put("blpol1", getBlpol1());
        this.hashColumns.put("podatd1_gmt", getPodatd1Gmt());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("vsl_fullname1", getVslFullname1());
        this.hashColumns.put("podetd1", getPodetd1());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("poleta1", getPoleta1());
        this.hashColumns.put("pol_fullname1", getPolFullname1());
        this.hashColumns.put("polatd1_gmt", getPolatd1Gmt());
        this.hashColumns.put("polata1_gmt", getPolata1Gmt());
        this.hashColumns.put("blpod1", getBlpod1());
        this.hashColumns.put("podata1", getPodata1());
        this.hashColumns.put("bvvd1", getBvvd1());
        this.hashColumns.put("vsl_lloydcode1", getVslLloydcode1());
        this.hashColumns.put("poletd1", getPoletd1());
        this.hashColumns.put("poletd1_gmt", getPoletd1Gmt());
        this.hashColumns.put("podeta1", getPodeta1());
        this.hashColumns.put("podeta1_gmt", getPodeta1Gmt());
        this.hashColumns.put("vsl_callsign1", getVslCallsign1());
        this.hashColumns.put("podetd1_gmt", getPodetd1Gmt());
        this.hashColumns.put("polata1", getPolata1());
        this.hashColumns.put("podata1_gmt", getPodata1Gmt());
        this.hashColumns.put("poleta1_gmt", getPoleta1Gmt());
        this.hashColumns.put("pod_fullname1", getPodFullname1());
        this.hashColumns.put("vsl_consort_voy_no", getVslConsortVoyNo());
        this.hashColumns.put("vsl_cnt_cd", getVslCntCd());
        this.hashColumns.put("pol_amsqual1", getPolAmsqual1());
        this.hashColumns.put("pol_amsport1", getPolAmsport1());
        this.hashColumns.put("pod_amsqual1", getPodAmsqual1());
        this.hashColumns.put("pod_amsport1", getPodAmsport1());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("polatd1", "polatd1");
        this.hashFields.put("podatd1", "podatd1");
        this.hashFields.put("blpol1", "blpol1");
        this.hashFields.put("podatd1_gmt", "podatd1Gmt");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("vsl_fullname1", "vslFullname1");
        this.hashFields.put("podetd1", "podetd1");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("poleta1", "poleta1");
        this.hashFields.put("pol_fullname1", "polFullname1");
        this.hashFields.put("polatd1_gmt", "polatd1Gmt");
        this.hashFields.put("polata1_gmt", "polata1Gmt");
        this.hashFields.put("blpod1", "blpod1");
        this.hashFields.put("podata1", "podata1");
        this.hashFields.put("bvvd1", "bvvd1");
        this.hashFields.put("vsl_lloydcode1", "vslLloydcode1");
        this.hashFields.put("poletd1", "poletd1");
        this.hashFields.put("poletd1_gmt", "poletd1Gmt");
        this.hashFields.put("podeta1", "podeta1");
        this.hashFields.put("podeta1_gmt", "podeta1Gmt");
        this.hashFields.put("vsl_callsign1", "vslCallsign1");
        this.hashFields.put("podetd1_gmt", "podetd1Gmt");
        this.hashFields.put("polata1", "polata1");
        this.hashFields.put("podata1_gmt", "podata1Gmt");
        this.hashFields.put("poleta1_gmt", "poleta1Gmt");
        this.hashFields.put("pod_fullname1", "podFullname1");
        this.hashFields.put("vsl_consort_voy_no", "vslConsortVoyNo");
        this.hashFields.put("vsl_cnt_cd", "vslCntCd");
        this.hashFields.put("pol_amsqual1", "polAmsqual1");
        this.hashFields.put("pol_amsport1", "polAmsport1");
        this.hashFields.put("pod_amsqual1", "podAmsqual1");
        this.hashFields.put("pod_amsport1", "podAmsport1");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return polatd1
	 */
    public String getPolatd1() {
        return this.polatd1;
    }

    /**
	 * Column Info
	 * @return podatd1
	 */
    public String getPodatd1() {
        return this.podatd1;
    }

    /**
	 * Column Info
	 * @return blpol1
	 */
    public String getBlpol1() {
        return this.blpol1;
    }

    /**
	 * Column Info
	 * @return podatd1Gmt
	 */
    public String getPodatd1Gmt() {
        return this.podatd1Gmt;
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
	 * @return vslFullname1
	 */
    public String getVslFullname1() {
        return this.vslFullname1;
    }

    /**
	 * Column Info
	 * @return podetd1
	 */
    public String getPodetd1() {
        return this.podetd1;
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
	 * @return poleta1
	 */
    public String getPoleta1() {
        return this.poleta1;
    }

    /**
	 * Column Info
	 * @return polFullname1
	 */
    public String getPolFullname1() {
        return this.polFullname1;
    }

    /**
	 * Column Info
	 * @return polatd1Gmt
	 */
    public String getPolatd1Gmt() {
        return this.polatd1Gmt;
    }

    /**
	 * Column Info
	 * @return polata1Gmt
	 */
    public String getPolata1Gmt() {
        return this.polata1Gmt;
    }

    /**
	 * Column Info
	 * @return blpod1
	 */
    public String getBlpod1() {
        return this.blpod1;
    }

    /**
	 * Column Info
	 * @return podata1
	 */
    public String getPodata1() {
        return this.podata1;
    }

    /**
	 * Column Info
	 * @return bvvd1
	 */
    public String getBvvd1() {
        return this.bvvd1;
    }

    /**
	 * Column Info
	 * @return vslLloydcode1
	 */
    public String getVslLloydcode1() {
        return this.vslLloydcode1;
    }

    /**
	 * Column Info
	 * @return poletd1
	 */
    public String getPoletd1() {
        return this.poletd1;
    }

    /**
	 * Column Info
	 * @return poletd1Gmt
	 */
    public String getPoletd1Gmt() {
        return this.poletd1Gmt;
    }

    /**
	 * Column Info
	 * @return podeta1
	 */
    public String getPodeta1() {
        return this.podeta1;
    }

    /**
	 * Column Info
	 * @return podeta1Gmt
	 */
    public String getPodeta1Gmt() {
        return this.podeta1Gmt;
    }

    /**
	 * Column Info
	 * @return vslCallsign1
	 */
    public String getVslCallsign1() {
        return this.vslCallsign1;
    }

    /**
	 * Column Info
	 * @return podetd1Gmt
	 */
    public String getPodetd1Gmt() {
        return this.podetd1Gmt;
    }

    /**
	 * Column Info
	 * @return polata1
	 */
    public String getPolata1() {
        return this.polata1;
    }

    /**
	 * Column Info
	 * @return podata1Gmt
	 */
    public String getPodata1Gmt() {
        return this.podata1Gmt;
    }

    /**
	 * Column Info
	 * @return poleta1Gmt
	 */
    public String getPoleta1Gmt() {
        return this.poleta1Gmt;
    }

    /**
	 * Column Info
	 * @return podFullname1
	 */
    public String getPodFullname1() {
        return this.podFullname1;
    }

    /**
	 * Column Info
	 * @param polatd1
	 */
    public void setPolatd1(String polatd1) {
        this.polatd1 = polatd1;
    }

    /**
	 * Column Info
	 * @param podatd1
	 */
    public void setPodatd1(String podatd1) {
        this.podatd1 = podatd1;
    }

    /**
	 * Column Info
	 * @param blpol1
	 */
    public void setBlpol1(String blpol1) {
        this.blpol1 = blpol1;
    }

    /**
	 * Column Info
	 * @param podatd1Gmt
	 */
    public void setPodatd1Gmt(String podatd1Gmt) {
        this.podatd1Gmt = podatd1Gmt;
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
	 * @param vslFullname1
	 */
    public void setVslFullname1(String vslFullname1) {
        this.vslFullname1 = vslFullname1;
    }

    /**
	 * Column Info
	 * @param podetd1
	 */
    public void setPodetd1(String podetd1) {
        this.podetd1 = podetd1;
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
	 * @param poleta1
	 */
    public void setPoleta1(String poleta1) {
        this.poleta1 = poleta1;
    }

    /**
	 * Column Info
	 * @param polFullname1
	 */
    public void setPolFullname1(String polFullname1) {
        this.polFullname1 = polFullname1;
    }

    /**
	 * Column Info
	 * @param polatd1Gmt
	 */
    public void setPolatd1Gmt(String polatd1Gmt) {
        this.polatd1Gmt = polatd1Gmt;
    }

    /**
	 * Column Info
	 * @param polata1Gmt
	 */
    public void setPolata1Gmt(String polata1Gmt) {
        this.polata1Gmt = polata1Gmt;
    }

    /**
	 * Column Info
	 * @param blpod1
	 */
    public void setBlpod1(String blpod1) {
        this.blpod1 = blpod1;
    }

    /**
	 * Column Info
	 * @param podata1
	 */
    public void setPodata1(String podata1) {
        this.podata1 = podata1;
    }

    /**
	 * Column Info
	 * @param bvvd1
	 */
    public void setBvvd1(String bvvd1) {
        this.bvvd1 = bvvd1;
    }

    /**
	 * Column Info
	 * @param vslLloydcode1
	 */
    public void setVslLloydcode1(String vslLloydcode1) {
        this.vslLloydcode1 = vslLloydcode1;
    }

    /**
	 * Column Info
	 * @param poletd1
	 */
    public void setPoletd1(String poletd1) {
        this.poletd1 = poletd1;
    }

    /**
	 * Column Info
	 * @param poletd1Gmt
	 */
    public void setPoletd1Gmt(String poletd1Gmt) {
        this.poletd1Gmt = poletd1Gmt;
    }

    /**
	 * Column Info
	 * @param podeta1
	 */
    public void setPodeta1(String podeta1) {
        this.podeta1 = podeta1;
    }

    /**
	 * Column Info
	 * @param podeta1Gmt
	 */
    public void setPodeta1Gmt(String podeta1Gmt) {
        this.podeta1Gmt = podeta1Gmt;
    }

    /**
	 * Column Info
	 * @param vslCallsign1
	 */
    public void setVslCallsign1(String vslCallsign1) {
        this.vslCallsign1 = vslCallsign1;
    }

    /**
	 * Column Info
	 * @param podetd1Gmt
	 */
    public void setPodetd1Gmt(String podetd1Gmt) {
        this.podetd1Gmt = podetd1Gmt;
    }

    /**
	 * Column Info
	 * @param polata1
	 */
    public void setPolata1(String polata1) {
        this.polata1 = polata1;
    }

    /**
	 * Column Info
	 * @param podata1Gmt
	 */
    public void setPodata1Gmt(String podata1Gmt) {
        this.podata1Gmt = podata1Gmt;
    }

    /**
	 * Column Info
	 * @param poleta1Gmt
	 */
    public void setPoleta1Gmt(String poleta1Gmt) {
        this.poleta1Gmt = poleta1Gmt;
    }

    /**
	 * Column Info
	 * @param podFullname1
	 */
    public void setPodFullname1(String podFullname1) {
        this.podFullname1 = podFullname1;
    }

    public void setVslConsortVoyNo(String vslConsortVoyNo) {
        this.vslConsortVoyNo = vslConsortVoyNo;
    }

    public String getVslConsortVoyNo() {
        return this.vslConsortVoyNo;
    }

    public void setVslCntCd(String vslCntCd) {
        this.vslCntCd = vslCntCd;
    }

    public String getVslCntCd() {
        return this.vslCntCd;
    }

    public void setPolAmsqual1(String polAmsqual1) {
        this.polAmsqual1 = polAmsqual1;
    }

    public String getPolAmsqual1() {
        return this.polAmsqual1;
    }

    public void setPolAmsport1(String polAmsport1) {
        this.polAmsport1 = polAmsport1;
    }

    public String getPolAmsport1() {
        return this.polAmsport1;
    }

    public void setPodAmsqual1(String podAmsqual1) {
        this.podAmsqual1 = podAmsqual1;
    }

    public String getPodAmsqual1() {
        return this.podAmsqual1;
    }

    public void setPodAmsport1(String podAmsport1) {
        this.podAmsport1 = podAmsport1;
    }

    public String getPodAmsport1() {
        return this.podAmsport1;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setPolatd1(JSPUtil.getParameter(request, "polatd1", ""));
        setPodatd1(JSPUtil.getParameter(request, "podatd1", ""));
        setBlpol1(JSPUtil.getParameter(request, "blpol1", ""));
        setPodatd1Gmt(JSPUtil.getParameter(request, "podatd1_gmt", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setVslFullname1(JSPUtil.getParameter(request, "vsl_fullname1", ""));
        setPodetd1(JSPUtil.getParameter(request, "podetd1", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setPoleta1(JSPUtil.getParameter(request, "poleta1", ""));
        setPolFullname1(JSPUtil.getParameter(request, "pol_fullname1", ""));
        setPolatd1Gmt(JSPUtil.getParameter(request, "polatd1_gmt", ""));
        setPolata1Gmt(JSPUtil.getParameter(request, "polata1_gmt", ""));
        setBlpod1(JSPUtil.getParameter(request, "blpod1", ""));
        setPodata1(JSPUtil.getParameter(request, "podata1", ""));
        setBvvd1(JSPUtil.getParameter(request, "bvvd1", ""));
        setVslLloydcode1(JSPUtil.getParameter(request, "vsl_lloydcode1", ""));
        setPoletd1(JSPUtil.getParameter(request, "poletd1", ""));
        setPoletd1Gmt(JSPUtil.getParameter(request, "poletd1_gmt", ""));
        setPodeta1(JSPUtil.getParameter(request, "podeta1", ""));
        setPodeta1Gmt(JSPUtil.getParameter(request, "podeta1_gmt", ""));
        setVslCallsign1(JSPUtil.getParameter(request, "vsl_callsign1", ""));
        setPodetd1Gmt(JSPUtil.getParameter(request, "podetd1_gmt", ""));
        setPolata1(JSPUtil.getParameter(request, "polata1", ""));
        setPodata1Gmt(JSPUtil.getParameter(request, "podata1_gmt", ""));
        setPoleta1Gmt(JSPUtil.getParameter(request, "poleta1_gmt", ""));
        setPodFullname1(JSPUtil.getParameter(request, "pod_fullname1", ""));
        setVslConsortVoyNo(JSPUtil.getParameter(request, "vsl_consort_voy_no", ""));
        setVslCntCd(JSPUtil.getParameter(request, "vsl_cnt_cd", ""));
        setPolAmsqual1(JSPUtil.getParameter(request, "pol_amsqual1", ""));
        setPolAmsport1(JSPUtil.getParameter(request, "pol_amsport1", ""));
        setPodAmsqual1(JSPUtil.getParameter(request, "pod_amsqual1", ""));
        setPodAmsport1(JSPUtil.getParameter(request, "pod_amsport1", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Edi315PrefixBkgVvdVO[]
	 */
    public Edi315PrefixBkgVvdVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return Edi315PrefixBkgVvdVO[]
	 */
    public Edi315PrefixBkgVvdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        Edi315PrefixBkgVvdVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] polatd1 = (JSPUtil.getParameter(request, prefix + "polatd1", length));
            String[] podatd1 = (JSPUtil.getParameter(request, prefix + "podatd1", length));
            String[] blpol1 = (JSPUtil.getParameter(request, prefix + "blpol1", length));
            String[] podatd1Gmt = (JSPUtil.getParameter(request, prefix + "podatd1_gmt", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] vslFullname1 = (JSPUtil.getParameter(request, prefix + "vsl_fullname1", length));
            String[] podetd1 = (JSPUtil.getParameter(request, prefix + "podetd1", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] poleta1 = (JSPUtil.getParameter(request, prefix + "poleta1", length));
            String[] polFullname1 = (JSPUtil.getParameter(request, prefix + "pol_fullname1", length));
            String[] polatd1Gmt = (JSPUtil.getParameter(request, prefix + "polatd1_gmt", length));
            String[] polata1Gmt = (JSPUtil.getParameter(request, prefix + "polata1_gmt", length));
            String[] blpod1 = (JSPUtil.getParameter(request, prefix + "blpod1", length));
            String[] podata1 = (JSPUtil.getParameter(request, prefix + "podata1", length));
            String[] bvvd1 = (JSPUtil.getParameter(request, prefix + "bvvd1", length));
            String[] vslLloydcode1 = (JSPUtil.getParameter(request, prefix + "vsl_lloydcode1", length));
            String[] poletd1 = (JSPUtil.getParameter(request, prefix + "poletd1", length));
            String[] poletd1Gmt = (JSPUtil.getParameter(request, prefix + "poletd1_gmt", length));
            String[] podeta1 = (JSPUtil.getParameter(request, prefix + "podeta1", length));
            String[] podeta1Gmt = (JSPUtil.getParameter(request, prefix + "podeta1_gmt", length));
            String[] vslCallsign1 = (JSPUtil.getParameter(request, prefix + "vsl_callsign1", length));
            String[] podetd1Gmt = (JSPUtil.getParameter(request, prefix + "podetd1_gmt", length));
            String[] polata1 = (JSPUtil.getParameter(request, prefix + "polata1", length));
            String[] podata1Gmt = (JSPUtil.getParameter(request, prefix + "podata1_gmt", length));
            String[] poleta1Gmt = (JSPUtil.getParameter(request, prefix + "poleta1_gmt", length));
            String[] podFullname1 = (JSPUtil.getParameter(request, prefix + "pod_fullname1", length));
            String[] vslConsortVoyNo = (JSPUtil.getParameter(request, prefix + "vsl_consort_voy_no", length));
	    	String[] vslCntCd = (JSPUtil.getParameter(request, prefix + "vsl_cnt_cd", length));
	    	String[] polAmsqual1 = (JSPUtil.getParameter(request, prefix + "pol_amsqual1", length));
	    	String[] polAmsport1 = (JSPUtil.getParameter(request, prefix + "pol_amsport1", length));
	    	String[] podAmsqual1 = (JSPUtil.getParameter(request, prefix + "pod_amsqual1", length));
	    	String[] podAmsport1 = (JSPUtil.getParameter(request, prefix + "pod_amsport1", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new Edi315PrefixBkgVvdVO();
                if (polatd1[i] != null)
                    model.setPolatd1(polatd1[i]);
                if (podatd1[i] != null)
                    model.setPodatd1(podatd1[i]);
                if (blpol1[i] != null)
                    model.setBlpol1(blpol1[i]);
                if (podatd1Gmt[i] != null)
                    model.setPodatd1Gmt(podatd1Gmt[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (vslFullname1[i] != null)
                    model.setVslFullname1(vslFullname1[i]);
                if (podetd1[i] != null)
                    model.setPodetd1(podetd1[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (poleta1[i] != null)
                    model.setPoleta1(poleta1[i]);
                if (polFullname1[i] != null)
                    model.setPolFullname1(polFullname1[i]);
                if (polatd1Gmt[i] != null)
                    model.setPolatd1Gmt(polatd1Gmt[i]);
                if (polata1Gmt[i] != null)
                    model.setPolata1Gmt(polata1Gmt[i]);
                if (blpod1[i] != null)
                    model.setBlpod1(blpod1[i]);
                if (podata1[i] != null)
                    model.setPodata1(podata1[i]);
                if (bvvd1[i] != null)
                    model.setBvvd1(bvvd1[i]);
                if (vslLloydcode1[i] != null)
                    model.setVslLloydcode1(vslLloydcode1[i]);
                if (poletd1[i] != null)
                    model.setPoletd1(poletd1[i]);
                if (poletd1Gmt[i] != null)
                    model.setPoletd1Gmt(poletd1Gmt[i]);
                if (podeta1[i] != null)
                    model.setPodeta1(podeta1[i]);
                if (podeta1Gmt[i] != null)
                    model.setPodeta1Gmt(podeta1Gmt[i]);
                if (vslCallsign1[i] != null)
                    model.setVslCallsign1(vslCallsign1[i]);
                if (podetd1Gmt[i] != null)
                    model.setPodetd1Gmt(podetd1Gmt[i]);
                if (polata1[i] != null)
                    model.setPolata1(polata1[i]);
                if (podata1Gmt[i] != null)
                    model.setPodata1Gmt(podata1Gmt[i]);
                if (poleta1Gmt[i] != null)
                    model.setPoleta1Gmt(poleta1Gmt[i]);
                if (podFullname1[i] != null)
                    model.setPodFullname1(podFullname1[i]);
                if (vslConsortVoyNo[i] != null) 
		    		model.setVslConsortVoyNo(vslConsortVoyNo[i]);
				if (vslCntCd[i] != null) 
		    		model.setVslCntCd(vslCntCd[i]);
				if (polAmsqual1[i] != null) 
		    		model.setPolAmsqual1(polAmsqual1[i]);
				if (polAmsport1[i] != null) 
		    		model.setPolAmsport1(polAmsport1[i]);
				if (podAmsqual1[i] != null) 
		    		model.setPodAmsqual1(podAmsqual1[i]);
				if (podAmsport1[i] != null) 
		    		model.setPodAmsport1(podAmsport1[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getEdi315PrefixBkgVvdVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return Edi315PrefixBkgVvdVO[]
	 */
    public Edi315PrefixBkgVvdVO[] getEdi315PrefixBkgVvdVOs() {
        Edi315PrefixBkgVvdVO[] vos = (Edi315PrefixBkgVvdVO[]) models.toArray(new Edi315PrefixBkgVvdVO[models.size()]);
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
        this.polatd1 = this.polatd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podatd1 = this.podatd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blpol1 = this.blpol1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podatd1Gmt = this.podatd1Gmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslFullname1 = this.vslFullname1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podetd1 = this.podetd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.poleta1 = this.poleta1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polFullname1 = this.polFullname1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polatd1Gmt = this.polatd1Gmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polata1Gmt = this.polata1Gmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blpod1 = this.blpod1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podata1 = this.podata1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bvvd1 = this.bvvd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslLloydcode1 = this.vslLloydcode1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.poletd1 = this.poletd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.poletd1Gmt = this.poletd1Gmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podeta1 = this.podeta1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podeta1Gmt = this.podeta1Gmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCallsign1 = this.vslCallsign1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podetd1Gmt = this.podetd1Gmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polata1 = this.polata1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podata1Gmt = this.podata1Gmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.poleta1Gmt = this.poleta1Gmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podFullname1 = this.podFullname1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslConsortVoyNo = this.vslConsortVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCntCd = this.vslCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polAmsqual1 = this.polAmsqual1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polAmsport1 = this.polAmsport1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podAmsqual1 = this.podAmsqual1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podAmsport1 = this.podAmsport1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
