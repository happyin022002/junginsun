/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VesselEtaInfoCndVO.java
*@FileTitle : VesselEtaInfoCndVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.26
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.26  
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo;

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
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class VesselEtaInfoCndVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<VesselEtaInfoCndVO> models = new ArrayList<VesselEtaInfoCndVO>();

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String currdate = null;

    /* Column Info */
    private String vpsEtdDt = null;

    /* Column Info */
    private String caEtaDt = null;

    /* Column Info */
    private String callSgnNo = null;

    /* Column Info */
    private String skdVoyNo = null;

    /* Column Info */
    private String cvyRefNo = null;

    /* Column Info */
    private String westCvyRefNo = null;

    /* Column Info */
    private String caPortCd = null;

    /* Column Info */
    private String vpsEtaDt = null;

    /* Column Info */
    private String crrCd = null;

    /* Column Info */
    private String skdDirCd = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String vpsPortCd = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String lloydNo = null;

    /* Column Info */
    private String vslEngNm = null;

    /* Column Info */
    private String crrCode = null;

    /* Column Info */
    private String conVvd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public VesselEtaInfoCndVO() {
    }

    public VesselEtaInfoCndVO(String ibflag, String pagerows, String vslCd, String currdate, String vpsEtdDt, String callSgnNo, String skdVoyNo, String vpsEtaDt, String caEtaDt, String skdDirCd, String vpsPortCd, String caPortCd, String lloydNo, String vslEngNm, String cvyRefNo, String crrCd, String westCvyRefNo, String crrCode, String conVvd) {
        this.vslCd = vslCd;
        this.currdate = currdate;
        this.vpsEtdDt = vpsEtdDt;
        this.caEtaDt = caEtaDt;
        this.callSgnNo = callSgnNo;
        this.skdVoyNo = skdVoyNo;
        this.cvyRefNo = cvyRefNo;
        this.caPortCd = caPortCd;
        this.vpsEtaDt = vpsEtaDt;
        this.crrCd = crrCd;
        this.skdDirCd = skdDirCd;
        this.pagerows = pagerows;
        this.vpsPortCd = vpsPortCd;
        this.ibflag = ibflag;
        this.lloydNo = lloydNo;
        this.vslEngNm = vslEngNm;
        this.westCvyRefNo = westCvyRefNo;
        this.crrCode = crrCode;
        this.conVvd = conVvd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("currdate", getCurrdate());
        this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
        this.hashColumns.put("ca_eta_dt", getCaEtaDt());
        this.hashColumns.put("call_sgn_no", getCallSgnNo());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("cvy_ref_no", getCvyRefNo());
        this.hashColumns.put("ca_port_cd", getCaPortCd());
        this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
        this.hashColumns.put("crr_cd", getCrrCd());
        this.hashColumns.put("skd_dir_cd", getSkdDirCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("vps_port_cd", getVpsPortCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("lloyd_no", getLloydNo());
        this.hashColumns.put("vsl_eng_nm", getVslEngNm());
        this.hashColumns.put("west_cvy_ref_no", getWestCvyRefNo());
        this.hashColumns.put("crr_code", getCrrCode());
        this.hashColumns.put("con_vvd", getConVvd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("currdate", "currdate");
        this.hashFields.put("vps_etd_dt", "vpsEtdDt");
        this.hashFields.put("ca_eta_dt", "caEtaDt");
        this.hashFields.put("call_sgn_no", "callSgnNo");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("cvy_ref_no", "cvyRefNo");
        this.hashFields.put("ca_port_cd", "caPortCd");
        this.hashFields.put("vps_eta_dt", "vpsEtaDt");
        this.hashFields.put("crr_cd", "crrCd");
        this.hashFields.put("skd_dir_cd", "skdDirCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("vps_port_cd", "vpsPortCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("lloyd_no", "lloydNo");
        this.hashFields.put("vsl_eng_nm", "vslEngNm");
        this.hashFields.put("west_cvy_ref_no", "westCvyRefNo");
        this.hashFields.put("crr_code", "crrCode");
        this.hashFields.put("con_vvd", "conVvd");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return vslCd
	 */
    public String getVslCd() {
        return this.vslCd;
    }

    /**
	 * Column Info
	 * @return currdate
	 */
    public String getCurrdate() {
        return this.currdate;
    }

    /**
	 * Column Info
	 * @return westCvyRefNo
	 */
    public String getWestCvyRefNo() {
        return this.westCvyRefNo;
    }

    /**
	 * Column Info
	 * @return vpsEtdDt
	 */
    public String getVpsEtdDt() {
        return this.vpsEtdDt;
    }

    /**
	 * Column Info
	 * @return caEtaDt
	 */
    public String getCaEtaDt() {
        return this.caEtaDt;
    }

    /**
	 * Column Info
	 * @return callSgnNo
	 */
    public String getCallSgnNo() {
        return this.callSgnNo;
    }

    /**
	 * Column Info
	 * @return skdVoyNo
	 */
    public String getSkdVoyNo() {
        return this.skdVoyNo;
    }

    /**
	 * Column Info
	 * @return cvyRefNo
	 */
    public String getCvyRefNo() {
        return this.cvyRefNo;
    }

    /**
	 * Column Info
	 * @return caPortCd
	 */
    public String getCaPortCd() {
        return this.caPortCd;
    }

    /**
	 * Column Info
	 * @return vpsEtaDt
	 */
    public String getVpsEtaDt() {
        return this.vpsEtaDt;
    }

    /**
	 * Column Info
	 * @return crrCd
	 */
    public String getCrrCd() {
        return this.crrCd;
    }

    /**
	 * Column Info
	 * @return skdDirCd
	 */
    public String getSkdDirCd() {
        return this.skdDirCd;
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
	 * @return vpsPortCd
	 */
    public String getVpsPortCd() {
        return this.vpsPortCd;
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
	 * @return lloydNo
	 */
    public String getLloydNo() {
        return this.lloydNo;
    }

    /**
	 * Column Info
	 * @return vslEngNm
	 */
    public String getVslEngNm() {
        return this.vslEngNm;
    }

    /**
	 * Column Info
	 * @param vslCd
	 */
    public void setVslCd(String vslCd) {
        this.vslCd = vslCd;
    }

    /**
	 * Column Info
	 * @param currdate
	 */
    public void setCurrdate(String currdate) {
        this.currdate = currdate;
    }

    /**
	 * Column Info
	 * @param vpsEtdDt
	 */
    public void setVpsEtdDt(String vpsEtdDt) {
        this.vpsEtdDt = vpsEtdDt;
    }

    /**
	 * Column Info
	 * @param caEtaDt
	 */
    public void setCaEtaDt(String caEtaDt) {
        this.caEtaDt = caEtaDt;
    }

    /**
	 * Column Info
	 * @param callSgnNo
	 */
    public void setCallSgnNo(String callSgnNo) {
        this.callSgnNo = callSgnNo;
    }

    /**
	 * Column Info
	 * @param skdVoyNo
	 */
    public void setSkdVoyNo(String skdVoyNo) {
        this.skdVoyNo = skdVoyNo;
    }

    /**
	 * Column Info
	 * @param cvyRefNo
	 */
    public void setCvyRefNo(String cvyRefNo) {
        this.cvyRefNo = cvyRefNo;
    }

    /**
	 * Column Info
	 * @param caPortCd
	 */
    public void setCaPortCd(String caPortCd) {
        this.caPortCd = caPortCd;
    }

    /**
	 * Column Info
	 * @param vpsEtaDt
	 */
    public void setVpsEtaDt(String vpsEtaDt) {
        this.vpsEtaDt = vpsEtaDt;
    }

    /**
	 * Column Info
	 * @param crrCd
	 */
    public void setCrrCd(String crrCd) {
        this.crrCd = crrCd;
    }

    /**
	 * Column Info
	 * @param skdDirCd
	 */
    public void setSkdDirCd(String skdDirCd) {
        this.skdDirCd = skdDirCd;
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
	 * @param vpsPortCd
	 */
    public void setVpsPortCd(String vpsPortCd) {
        this.vpsPortCd = vpsPortCd;
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
	 * @param lloydNo
	 */
    public void setLloydNo(String lloydNo) {
        this.lloydNo = lloydNo;
    }

    /**
	 * Column Info
	 * @param vslEngNm
	 */
    public void setVslEngNm(String vslEngNm) {
        this.vslEngNm = vslEngNm;
    }

    /**
	 * Column Info
	 * @param westCvyRefNo
	 */
    public void setWestCvyRefNo(String westCvyRefNo) {
        this.westCvyRefNo = westCvyRefNo;
    }

    public void setCrrCode(String crrCode) {
        this.crrCode = crrCode;
    }

    public String getCrrCode() {
        return this.crrCode;
    }

    public void setConVvd(String conVvd) {
        this.conVvd = conVvd;
    }

    public String getConVvd() {
        return this.conVvd;
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
        setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
        setCurrdate(JSPUtil.getParameter(request, prefix + "currdate", ""));
        setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
        setCaEtaDt(JSPUtil.getParameter(request, prefix + "ca_eta_dt", ""));
        setCallSgnNo(JSPUtil.getParameter(request, prefix + "call_sgn_no", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
        setCvyRefNo(JSPUtil.getParameter(request, prefix + "cvy_ref_no", ""));
        setCaPortCd(JSPUtil.getParameter(request, prefix + "ca_port_cd", ""));
        setVpsEtaDt(JSPUtil.getParameter(request, prefix + "vps_eta_dt", ""));
        setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
        setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setLloydNo(JSPUtil.getParameter(request, prefix + "lloyd_no", ""));
        setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
        setWestCvyRefNo(JSPUtil.getParameter(request, prefix + "west_cvy_ref_no", ""));
        setCrrCode(JSPUtil.getParameter(request, prefix + "crr_code", ""));
        setConVvd(JSPUtil.getParameter(request, prefix + "con_vvd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VesselEtaInfoCndVO[]
	 */
    public VesselEtaInfoCndVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VesselEtaInfoCndVO[]
	 */
    public VesselEtaInfoCndVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        VesselEtaInfoCndVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] currdate = (JSPUtil.getParameter(request, prefix + "currdate", length));
            String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix + "vps_etd_dt", length));
            String[] caEtaDt = (JSPUtil.getParameter(request, prefix + "ca_eta_dt", length));
            String[] callSgnNo = (JSPUtil.getParameter(request, prefix + "call_sgn_no", length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
            String[] cvyRefNo = (JSPUtil.getParameter(request, prefix + "cvy_ref_no", length));
            String[] caPortCd = (JSPUtil.getParameter(request, prefix + "ca_port_cd", length));
            String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix + "vps_eta_dt", length));
            String[] crrCd = (JSPUtil.getParameter(request, prefix + "crr_cd", length));
            String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] vpsPortCd = (JSPUtil.getParameter(request, prefix + "vps_port_cd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] lloydNo = (JSPUtil.getParameter(request, prefix + "lloyd_no", length));
            String[] vslEngNm = (JSPUtil.getParameter(request, prefix + "vsl_eng_nm", length));
            String[] westCvyRefNo = (JSPUtil.getParameter(request, prefix + "west_cvy_ref_no", length));
            String[] crrCode = (JSPUtil.getParameter(request, prefix + "crr_code", length));
	    	String[] conVvd = (JSPUtil.getParameter(request, prefix + "con_vvd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new VesselEtaInfoCndVO();
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (currdate[i] != null)
                    model.setCurrdate(currdate[i]);
                if (vpsEtdDt[i] != null)
                    model.setVpsEtdDt(vpsEtdDt[i]);
                if (caEtaDt[i] != null)
                    model.setCaEtaDt(caEtaDt[i]);
                if (callSgnNo[i] != null)
                    model.setCallSgnNo(callSgnNo[i]);
                if (skdVoyNo[i] != null)
                    model.setSkdVoyNo(skdVoyNo[i]);
                if (cvyRefNo[i] != null)
                    model.setCvyRefNo(cvyRefNo[i]);
                if (caPortCd[i] != null)
                    model.setCaPortCd(caPortCd[i]);
                if (vpsEtaDt[i] != null)
                    model.setVpsEtaDt(vpsEtaDt[i]);
                if (crrCd[i] != null)
                    model.setCrrCd(crrCd[i]);
                if (skdDirCd[i] != null)
                    model.setSkdDirCd(skdDirCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (vpsPortCd[i] != null)
                    model.setVpsPortCd(vpsPortCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (lloydNo[i] != null)
                    model.setLloydNo(lloydNo[i]);
                if (vslEngNm[i] != null)
                    model.setVslEngNm(vslEngNm[i]);
                if (westCvyRefNo[i] != null)
                    model.setWestCvyRefNo(westCvyRefNo[i]);
                if (crrCode[i] != null) 
		    		model.setCrrCode(crrCode[i]);
				if (conVvd[i] != null) 
		    		model.setConVvd(conVvd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getVesselEtaInfoCndVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return VesselEtaInfoCndVO[]
	 */
    public VesselEtaInfoCndVO[] getVesselEtaInfoCndVOs() {
        VesselEtaInfoCndVO[] vos = (VesselEtaInfoCndVO[]) models.toArray(new VesselEtaInfoCndVO[models.size()]);
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
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.currdate = this.currdate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsEtdDt = this.vpsEtdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.caEtaDt = this.caEtaDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.callSgnNo = this.callSgnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cvyRefNo = this.cvyRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.caPortCd = this.caPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsEtaDt = this.vpsEtaDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.crrCd = this.crrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsPortCd = this.vpsPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lloydNo = this.lloydNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslEngNm = this.vslEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.westCvyRefNo = this.westCvyRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.crrCode = this.crrCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.conVvd = this.conVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
