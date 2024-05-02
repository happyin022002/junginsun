/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MtyRlseOrdExcelRFVO.java
*@FileTitle : MtyRlseOrdExcelRFVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo;

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
public class MtyRlseOrdExcelRFVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<MtyRlseOrdExcelRFVO> models = new ArrayList<MtyRlseOrdExcelRFVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String bkgNo = null;

    /* Column Info */
    private String cntrSeq = null;

    /* Column Info */
    private String cntrTpsz = null;

    /* Column Info */
    private String cntrNo = null;

    /* Column Info */
    private String cmdtCode = null;

    /* Column Info */
    private String commodity = null;

    /* Column Info */
    private String cdoTemp = null;

    /* Column Info */
    private String tempUnit = null;

    /* Column Info */
    private String ventRto = null;

    /* Column Info */
    private String diffRmk = null;

    /* Column Info */
    private String pckQty = null;

    /* Column Info */
    private String netWgt = null;

    /* Column Info */
    private String grsWgt = null;

    /* Column Info */
    private String ttlDimLen = null;

    /* Column Info */
    private String ttlDimWdt = null;

    /* Column Info */
    private String ttlDimHgt = null;

    /* Column Info */
    private String ovrFwrdLen = null;

    /* Column Info */
    private String ovrBkwdLen = null;

    /* Column Info */
    private String ovrRtLen = null;

    /* Column Info */
    private String ovrLfLen = null;

    /* Column Info */
    private String ovrHgt = null;

    /* Column Info */
    private String awkRmk = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public MtyRlseOrdExcelRFVO() {
    }

    public MtyRlseOrdExcelRFVO(String ibflag, String pagerows, String bkgNo, String cntrSeq, String cntrTpsz, String cntrNo, String cmdtCode, String commodity, String cdoTemp, String tempUnit, String ventRto, String diffRmk, String pckQty, String netWgt, String grsWgt, String ttlDimLen, String ttlDimWdt, String ttlDimHgt, String ovrFwrdLen, String ovrBkwdLen, String ovrRtLen, String ovrLfLen, String ovrHgt, String awkRmk) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.bkgNo = bkgNo;
        this.cntrSeq = cntrSeq;
        this.cntrTpsz = cntrTpsz;
        this.cntrNo = cntrNo;
        this.cmdtCode = cmdtCode;
        this.commodity = commodity;
        this.cdoTemp = cdoTemp;
        this.tempUnit = tempUnit;
        this.ventRto = ventRto;
        this.diffRmk = diffRmk;
        this.pckQty = pckQty;
        this.netWgt = netWgt;
        this.grsWgt = grsWgt;
        this.ttlDimLen = ttlDimLen;
        this.ttlDimWdt = ttlDimWdt;
        this.ttlDimHgt = ttlDimHgt;
        this.ovrFwrdLen = ovrFwrdLen;
        this.ovrBkwdLen = ovrBkwdLen;
        this.ovrRtLen = ovrRtLen;
        this.ovrLfLen = ovrLfLen;
        this.ovrHgt = ovrHgt;
        this.awkRmk = awkRmk;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("cntr_seq", getCntrSeq());
        this.hashColumns.put("cntr_tpsz", getCntrTpsz());
        this.hashColumns.put("cntr_no", getCntrNo());
        this.hashColumns.put("cmdt_code", getCmdtCode());
        this.hashColumns.put("commodity", getCommodity());
        this.hashColumns.put("cdo_temp", getCdoTemp());
        this.hashColumns.put("temp_unit", getTempUnit());
        this.hashColumns.put("vent_rto", getVentRto());
        this.hashColumns.put("diff_rmk", getDiffRmk());
        this.hashColumns.put("pck_qty", getPckQty());
        this.hashColumns.put("net_wgt", getNetWgt());
        this.hashColumns.put("grs_wgt", getGrsWgt());
        this.hashColumns.put("ttl_dim_len", getTtlDimLen());
        this.hashColumns.put("ttl_dim_wdt", getTtlDimWdt());
        this.hashColumns.put("ttl_dim_hgt", getTtlDimHgt());
        this.hashColumns.put("ovr_fwrd_len", getOvrFwrdLen());
        this.hashColumns.put("ovr_bkwd_len", getOvrBkwdLen());
        this.hashColumns.put("ovr_rt_len", getOvrRtLen());
        this.hashColumns.put("ovr_lf_len", getOvrLfLen());
        this.hashColumns.put("ovr_hgt", getOvrHgt());
        this.hashColumns.put("awk_rmk", getAwkRmk());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("cntr_seq", "cntrSeq");
        this.hashFields.put("cntr_tpsz", "cntrTpsz");
        this.hashFields.put("cntr_no", "cntrNo");
        this.hashFields.put("cmdt_code", "cmdtCode");
        this.hashFields.put("commodity", "commodity");
        this.hashFields.put("cdo_temp", "cdoTemp");
        this.hashFields.put("temp_unit", "tempUnit");
        this.hashFields.put("vent_rto", "ventRto");
        this.hashFields.put("diff_rmk", "diffRmk");
        this.hashFields.put("pck_qty", "pckQty");
        this.hashFields.put("net_wgt", "netWgt");
        this.hashFields.put("grs_wgt", "grsWgt");
        this.hashFields.put("ttl_dim_len", "ttlDimLen");
        this.hashFields.put("ttl_dim_wdt", "ttlDimWdt");
        this.hashFields.put("ttl_dim_hgt", "ttlDimHgt");
        this.hashFields.put("ovr_fwrd_len", "ovrFwrdLen");
        this.hashFields.put("ovr_bkwd_len", "ovrBkwdLen");
        this.hashFields.put("ovr_rt_len", "ovrRtLen");
        this.hashFields.put("ovr_lf_len", "ovrLfLen");
        this.hashFields.put("ovr_hgt", "ovrHgt");
        this.hashFields.put("awk_rmk", "awkRmk");
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
	 * @param String bkgNo
	 */
    public void setBkgNo(String bkgNo) {
        this.bkgNo = bkgNo;
    }

    /**
	 * 
	 * @return String bkgNo
	 */
    public String getBkgNo() {
        return this.bkgNo;
    }

    /**
	 *
	 * @param String cntrSeq
	 */
    public void setCntrSeq(String cntrSeq) {
        this.cntrSeq = cntrSeq;
    }

    /**
	 * 
	 * @return String cntrSeq
	 */
    public String getCntrSeq() {
        return this.cntrSeq;
    }

    /**
	 *
	 * @param String cntrTpsz
	 */
    public void setCntrTpsz(String cntrTpsz) {
        this.cntrTpsz = cntrTpsz;
    }

    /**
	 * 
	 * @return String cntrTpsz
	 */
    public String getCntrTpsz() {
        return this.cntrTpsz;
    }

    /**
	 *
	 * @param String cntrNo
	 */
    public void setCntrNo(String cntrNo) {
        this.cntrNo = cntrNo;
    }

    /**
	 * 
	 * @return String cntrNo
	 */
    public String getCntrNo() {
        return this.cntrNo;
    }

    /**
	 *
	 * @param String cmdtCode
	 */
    public void setCmdtCode(String cmdtCode) {
        this.cmdtCode = cmdtCode;
    }

    /**
	 * 
	 * @return String cmdtCode
	 */
    public String getCmdtCode() {
        return this.cmdtCode;
    }

    /**
	 *
	 * @param String commodity
	 */
    public void setCommodity(String commodity) {
        this.commodity = commodity;
    }

    /**
	 * 
	 * @return String commodity
	 */
    public String getCommodity() {
        return this.commodity;
    }

    /**
	 *
	 * @param String cdoTemp
	 */
    public void setCdoTemp(String cdoTemp) {
        this.cdoTemp = cdoTemp;
    }

    /**
	 * 
	 * @return String cdoTemp
	 */
    public String getCdoTemp() {
        return this.cdoTemp;
    }

    /**
	 *
	 * @param String tempUnit
	 */
    public void setTempUnit(String tempUnit) {
        this.tempUnit = tempUnit;
    }

    /**
	 * 
	 * @return String tempUnit
	 */
    public String getTempUnit() {
        return this.tempUnit;
    }

    /**
	 *
	 * @param String ventRto
	 */
    public void setVentRto(String ventRto) {
        this.ventRto = ventRto;
    }

    /**
	 * 
	 * @return String ventRto
	 */
    public String getVentRto() {
        return this.ventRto;
    }

    /**
	 *
	 * @param String diffRmk
	 */
    public void setDiffRmk(String diffRmk) {
        this.diffRmk = diffRmk;
    }

    /**
	 * 
	 * @return String diffRmk
	 */
    public String getDiffRmk() {
        return this.diffRmk;
    }

    /**
	 *
	 * @param String pckQty
	 */
    public void setPckQty(String pckQty) {
        this.pckQty = pckQty;
    }

    /**
	 * 
	 * @return String pckQty
	 */
    public String getPckQty() {
        return this.pckQty;
    }

    /**
	 *
	 * @param String netWgt
	 */
    public void setNetWgt(String netWgt) {
        this.netWgt = netWgt;
    }

    /**
	 * 
	 * @return String netWgt
	 */
    public String getNetWgt() {
        return this.netWgt;
    }

    /**
	 *
	 * @param String grsWgt
	 */
    public void setGrsWgt(String grsWgt) {
        this.grsWgt = grsWgt;
    }

    /**
	 * 
	 * @return String grsWgt
	 */
    public String getGrsWgt() {
        return this.grsWgt;
    }

    /**
	 *
	 * @param String ttlDimLen
	 */
    public void setTtlDimLen(String ttlDimLen) {
        this.ttlDimLen = ttlDimLen;
    }

    /**
	 * 
	 * @return String ttlDimLen
	 */
    public String getTtlDimLen() {
        return this.ttlDimLen;
    }

    /**
	 *
	 * @param String ttlDimWdt
	 */
    public void setTtlDimWdt(String ttlDimWdt) {
        this.ttlDimWdt = ttlDimWdt;
    }

    /**
	 * 
	 * @return String ttlDimWdt
	 */
    public String getTtlDimWdt() {
        return this.ttlDimWdt;
    }

    /**
	 *
	 * @param String ttlDimHgt
	 */
    public void setTtlDimHgt(String ttlDimHgt) {
        this.ttlDimHgt = ttlDimHgt;
    }

    /**
	 * 
	 * @return String ttlDimHgt
	 */
    public String getTtlDimHgt() {
        return this.ttlDimHgt;
    }

    /**
	 *
	 * @param String ovrFwrdLen
	 */
    public void setOvrFwrdLen(String ovrFwrdLen) {
        this.ovrFwrdLen = ovrFwrdLen;
    }

    /**
	 * 
	 * @return String ovrFwrdLen
	 */
    public String getOvrFwrdLen() {
        return this.ovrFwrdLen;
    }

    /**
	 *
	 * @param String ovrBkwdLen
	 */
    public void setOvrBkwdLen(String ovrBkwdLen) {
        this.ovrBkwdLen = ovrBkwdLen;
    }

    /**
	 * 
	 * @return String ovrBkwdLen
	 */
    public String getOvrBkwdLen() {
        return this.ovrBkwdLen;
    }

    /**
	 *
	 * @param String ovrRtLen
	 */
    public void setOvrRtLen(String ovrRtLen) {
        this.ovrRtLen = ovrRtLen;
    }

    /**
	 * 
	 * @return String ovrRtLen
	 */
    public String getOvrRtLen() {
        return this.ovrRtLen;
    }

    /**
	 *
	 * @param String ovrLfLen
	 */
    public void setOvrLfLen(String ovrLfLen) {
        this.ovrLfLen = ovrLfLen;
    }

    /**
	 * 
	 * @return String ovrLfLen
	 */
    public String getOvrLfLen() {
        return this.ovrLfLen;
    }

    /**
	 *
	 * @param String ovrHgt
	 */
    public void setOvrHgt(String ovrHgt) {
        this.ovrHgt = ovrHgt;
    }

    /**
	 * 
	 * @return String ovrHgt
	 */
    public String getOvrHgt() {
        return this.ovrHgt;
    }

    public void setAwkRmk(String awkRmk) {
        this.awkRmk = awkRmk;
    }

    public String getAwkRmk() {
        return this.awkRmk;
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
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setCntrSeq(JSPUtil.getParameter(request, prefix + "cntr_seq", ""));
        setCntrTpsz(JSPUtil.getParameter(request, prefix + "cntr_tpsz", ""));
        setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
        setCmdtCode(JSPUtil.getParameter(request, prefix + "cmdt_code", ""));
        setCommodity(JSPUtil.getParameter(request, prefix + "commodity", ""));
        setCdoTemp(JSPUtil.getParameter(request, prefix + "cdo_temp", ""));
        setTempUnit(JSPUtil.getParameter(request, prefix + "temp_unit", ""));
        setVentRto(JSPUtil.getParameter(request, prefix + "vent_rto", ""));
        setDiffRmk(JSPUtil.getParameter(request, prefix + "diff_rmk", ""));
        setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
        setNetWgt(JSPUtil.getParameter(request, prefix + "net_wgt", ""));
        setGrsWgt(JSPUtil.getParameter(request, prefix + "grs_wgt", ""));
        setTtlDimLen(JSPUtil.getParameter(request, prefix + "ttl_dim_len", ""));
        setTtlDimWdt(JSPUtil.getParameter(request, prefix + "ttl_dim_wdt", ""));
        setTtlDimHgt(JSPUtil.getParameter(request, prefix + "ttl_dim_hgt", ""));
        setOvrFwrdLen(JSPUtil.getParameter(request, prefix + "ovr_fwrd_len", ""));
        setOvrBkwdLen(JSPUtil.getParameter(request, prefix + "ovr_bkwd_len", ""));
        setOvrRtLen(JSPUtil.getParameter(request, prefix + "ovr_rt_len", ""));
        setOvrLfLen(JSPUtil.getParameter(request, prefix + "ovr_lf_len", ""));
        setOvrHgt(JSPUtil.getParameter(request, prefix + "ovr_hgt", ""));
        setAwkRmk(JSPUtil.getParameter(request, prefix + "awk_rmk", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MtyRlseOrdExcelRFVO[]
	 */
    public MtyRlseOrdExcelRFVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MtyRlseOrdExcelRFVO[]
	 */
    public MtyRlseOrdExcelRFVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        MtyRlseOrdExcelRFVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] cntrSeq = (JSPUtil.getParameter(request, prefix + "cntr_seq", length));
            String[] cntrTpsz = (JSPUtil.getParameter(request, prefix + "cntr_tpsz", length));
            String[] cntrNo = (JSPUtil.getParameter(request, prefix + "cntr_no", length));
            String[] cmdtCode = (JSPUtil.getParameter(request, prefix + "cmdt_code", length));
            String[] commodity = (JSPUtil.getParameter(request, prefix + "commodity", length));
            String[] cdoTemp = (JSPUtil.getParameter(request, prefix + "cdo_temp", length));
            String[] tempUnit = (JSPUtil.getParameter(request, prefix + "temp_unit", length));
            String[] ventRto = (JSPUtil.getParameter(request, prefix + "vent_rto", length));
            String[] diffRmk = (JSPUtil.getParameter(request, prefix + "diff_rmk", length));
            String[] pckQty = (JSPUtil.getParameter(request, prefix + "pck_qty", length));
            String[] netWgt = (JSPUtil.getParameter(request, prefix + "net_wgt", length));
            String[] grsWgt = (JSPUtil.getParameter(request, prefix + "grs_wgt", length));
            String[] ttlDimLen = (JSPUtil.getParameter(request, prefix + "ttl_dim_len", length));
            String[] ttlDimWdt = (JSPUtil.getParameter(request, prefix + "ttl_dim_wdt", length));
            String[] ttlDimHgt = (JSPUtil.getParameter(request, prefix + "ttl_dim_hgt", length));
            String[] ovrFwrdLen = (JSPUtil.getParameter(request, prefix + "ovr_fwrd_len", length));
            String[] ovrBkwdLen = (JSPUtil.getParameter(request, prefix + "ovr_bkwd_len", length));
            String[] ovrRtLen = (JSPUtil.getParameter(request, prefix + "ovr_rt_len", length));
            String[] ovrLfLen = (JSPUtil.getParameter(request, prefix + "ovr_lf_len", length));
            String[] ovrHgt = (JSPUtil.getParameter(request, prefix + "ovr_hgt", length));
            String[] awkRmk = (JSPUtil.getParameter(request, prefix + "awk_rmk", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new MtyRlseOrdExcelRFVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (cntrSeq[i] != null)
                    model.setCntrSeq(cntrSeq[i]);
                if (cntrTpsz[i] != null)
                    model.setCntrTpsz(cntrTpsz[i]);
                if (cntrNo[i] != null)
                    model.setCntrNo(cntrNo[i]);
                if (cmdtCode[i] != null)
                    model.setCmdtCode(cmdtCode[i]);
                if (commodity[i] != null)
                    model.setCommodity(commodity[i]);
                if (cdoTemp[i] != null)
                    model.setCdoTemp(cdoTemp[i]);
                if (tempUnit[i] != null)
                    model.setTempUnit(tempUnit[i]);
                if (ventRto[i] != null)
                    model.setVentRto(ventRto[i]);
                if (diffRmk[i] != null)
                    model.setDiffRmk(diffRmk[i]);
                if (pckQty[i] != null)
                    model.setPckQty(pckQty[i]);
                if (netWgt[i] != null)
                    model.setNetWgt(netWgt[i]);
                if (grsWgt[i] != null)
                    model.setGrsWgt(grsWgt[i]);
                if (ttlDimLen[i] != null)
                    model.setTtlDimLen(ttlDimLen[i]);
                if (ttlDimWdt[i] != null)
                    model.setTtlDimWdt(ttlDimWdt[i]);
                if (ttlDimHgt[i] != null)
                    model.setTtlDimHgt(ttlDimHgt[i]);
                if (ovrFwrdLen[i] != null)
                    model.setOvrFwrdLen(ovrFwrdLen[i]);
                if (ovrBkwdLen[i] != null)
                    model.setOvrBkwdLen(ovrBkwdLen[i]);
                if (ovrRtLen[i] != null)
                    model.setOvrRtLen(ovrRtLen[i]);
                if (ovrLfLen[i] != null)
                    model.setOvrLfLen(ovrLfLen[i]);
                if (ovrHgt[i] != null)
                    model.setOvrHgt(ovrHgt[i]);
                if (awkRmk[i] != null) 
		    		model.setAwkRmk(awkRmk[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getMtyRlseOrdExcelRFVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return MtyRlseOrdExcelRFVO[]
	 */
    public MtyRlseOrdExcelRFVO[] getMtyRlseOrdExcelRFVOs() {
        MtyRlseOrdExcelRFVO[] vos = (MtyRlseOrdExcelRFVO[]) models.toArray(new MtyRlseOrdExcelRFVO[models.size()]);
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
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrSeq = this.cntrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrTpsz = this.cntrTpsz.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrNo = this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtCode = this.cmdtCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.commodity = this.commodity.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cdoTemp = this.cdoTemp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tempUnit = this.tempUnit.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ventRto = this.ventRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.diffRmk = this.diffRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pckQty = this.pckQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.netWgt = this.netWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.grsWgt = this.grsWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ttlDimLen = this.ttlDimLen.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ttlDimWdt = this.ttlDimWdt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ttlDimHgt = this.ttlDimHgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ovrFwrdLen = this.ovrFwrdLen.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ovrBkwdLen = this.ovrBkwdLen.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ovrRtLen = this.ovrRtLen.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ovrLfLen = this.ovrLfLen.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ovrHgt = this.ovrHgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.awkRmk = this.awkRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
