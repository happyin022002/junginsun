/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ValidationVO.java
*@FileTitle : ValidationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.14
*@LastModifier : 김귀진
*@LastVersion : 1.0
* 2009.08.14 김귀진 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.common.prdcommon.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김귀진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class ValidationVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<ValidationVO> models = new ArrayList<ValidationVO>();

    /* Column Info */
    private String comData2 = null;

    /* Column Info */
    private String comData1 = null;

    /* Column Info */
    private String countryCode = null;

    /* Column Info */
    private String nodeName = null;

    /* Column Info */
    private String code = null;

    /* Column Info */
    private String kind = null;

    /* Column Info */
    private String pagerows = null;

    /* Column Info */
    private String locationCode = null;

    /* Column Info */
    private String ibflag = null;

    /* Column Info */
    private String vslSlanNm = null;

    /* Column Info */
    private String chk = null;

    /* Column Info */
    private String yardCode = null;

    /* Column Info */
    private String laneCode = null;

    /* Column Info */
    private String vendorSeq = null;

    /* Column Info */
    private String checkData = null;

    /* Column Info */
    private String nodeCode = null;

    /* Column Info */
    private String skipFlagFunItemControl = null;

    /* Column Info */
    private String isInThePast = null;

    /* Column Info */
    private String fullCgoCutOffTm = null;

    /* Column Info */
    private String loginUsrOfcCd = null;

    /* Column Info */
    private String fullCgoCutOffYdCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public ValidationVO() {
    }

    public ValidationVO(String ibflag, String pagerows, String comData2, String comData1, String countryCode, String nodeName, String code, String kind, String locationCode, String chk, String yardCode, String laneCode, String vendorSeq, String checkData, String nodeCode, String vslSlanNm, String skipFlagFunItemControl, String isInThePast, String fullCgoCutOffTm, String loginUsrOfcCd, String fullCgoCutOffYdCd) {
        this.comData2 = comData2;
        this.comData1 = comData1;
        this.countryCode = countryCode;
        this.nodeName = nodeName;
        this.code = code;
        this.kind = kind;
        this.pagerows = pagerows;
        this.locationCode = locationCode;
        this.ibflag = ibflag;
        this.vslSlanNm = vslSlanNm;
        this.chk = chk;
        this.yardCode = yardCode;
        this.laneCode = laneCode;
        this.vendorSeq = vendorSeq;
        this.checkData = checkData;
        this.nodeCode = nodeCode;
        this.skipFlagFunItemControl = skipFlagFunItemControl;
        this.isInThePast = isInThePast;
        this.fullCgoCutOffTm = fullCgoCutOffTm;
        this.loginUsrOfcCd = loginUsrOfcCd;
        this.fullCgoCutOffYdCd = fullCgoCutOffYdCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("com_data2", getComData2());
        this.hashColumns.put("com_data1", getComData1());
        this.hashColumns.put("country_code", getCountryCode());
        this.hashColumns.put("node_name", getNodeName());
        this.hashColumns.put("code", getCode());
        this.hashColumns.put("kind", getKind());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("location_code", getLocationCode());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("vsl_slan_nm", getVslSlanNm());
        this.hashColumns.put("chk", getChk());
        this.hashColumns.put("yard_code", getYardCode());
        this.hashColumns.put("lane_code", getLaneCode());
        this.hashColumns.put("vendor_seq", getVendorSeq());
        this.hashColumns.put("check_data", getCheckData());
        this.hashColumns.put("node_code", getNodeCode());
        this.hashColumns.put("skip_flag_fun_itemControl", getSkipFlagFunItemControl());
        this.hashColumns.put("is_in_the_past", getIsInThePast());
        this.hashColumns.put("full_cgo_cut_off_tm", getFullCgoCutOffTm());
        this.hashColumns.put("login_usr_ofc_cd", getLoginUsrOfcCd());
        this.hashColumns.put("full_cgo_cut_off_yd_cd", getFullCgoCutOffYdCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("com_data2", "comData2");
        this.hashFields.put("com_data1", "comData1");
        this.hashFields.put("country_code", "countryCode");
        this.hashFields.put("node_name", "nodeName");
        this.hashFields.put("code", "code");
        this.hashFields.put("kind", "kind");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("location_code", "locationCode");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("vsl_slan_nm", "vslSlanNm");
        this.hashFields.put("chk", "chk");
        this.hashFields.put("yard_code", "yardCode");
        this.hashFields.put("lane_code", "laneCode");
        this.hashFields.put("vendor_seq", "vendorSeq");
        this.hashFields.put("check_data", "checkData");
        this.hashFields.put("node_code", "nodeCode");
        this.hashFields.put("skip_flag_fun_itemControl", "skipFlagFunItemControl");
        this.hashFields.put("is_in_the_past", "isInThePast");
        this.hashFields.put("full_cgo_cut_off_tm", "fullCgoCutOffTm");
        this.hashFields.put("login_usr_ofc_cd", "loginUsrOfcCd");
        this.hashFields.put("full_cgo_cut_off_yd_cd", "fullCgoCutOffYdCd");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return comData2
	 */
    public String getComData2() {
        return this.comData2;
    }

    /**
	 * Column Info
	 * @return comData1
	 */
    public String getComData1() {
        return this.comData1;
    }

    /**
	 * Column Info
	 * @return countryCode
	 */
    public String getCountryCode() {
        return this.countryCode;
    }

    /**
	 * Column Info
	 * @return nodeName
	 */
    public String getNodeName() {
        return this.nodeName;
    }

    /**
	 * Column Info
	 * @return code
	 */
    public String getCode() {
        return this.code;
    }

    /**
	 * Column Info
	 * @return kind
	 */
    public String getKind() {
        return this.kind;
    }

    /**
	 * Column Info
	 * @return pagerows
	 */
    public String getPagerows() {
        return this.pagerows;
    }

    /**
	 * Column Info
	 * @return locationCode
	 */
    public String getLocationCode() {
        return this.locationCode;
    }

    /**
	 * Column Info
	 * @return ibflag
	 */
    public String getIbflag() {
        return this.ibflag;
    }

    /**
	 * Column Info
	 * @return vslSlanNm
	 */
    public String getVslSlanNm() {
        return this.vslSlanNm;
    }

    /**
	 * Column Info
	 * @return chk
	 */
    public String getChk() {
        return this.chk;
    }

    /**
	 * Column Info
	 * @return yardCode
	 */
    public String getYardCode() {
        return this.yardCode;
    }

    /**
	 * Column Info
	 * @return laneCode
	 */
    public String getLaneCode() {
        return this.laneCode;
    }

    /**
	 * Column Info
	 * @return vendorSeq
	 */
    public String getVendorSeq() {
        return this.vendorSeq;
    }

    /**
	 * Column Info
	 * @return checkData
	 */
    public String getCheckData() {
        return this.checkData;
    }

    /**
	 * Column Info
	 * @return nodeCode
	 */
    public String getNodeCode() {
        return this.nodeCode;
    }

    public String getSkipFlagFunItemControl() {
        return skipFlagFunItemControl;
    }

    public void setSkipFlagFunItemControl(String skipFlagFunItemControl) {
        this.skipFlagFunItemControl = skipFlagFunItemControl;
    }

    /**
	 * Column Info
	 * @param comData2
	 */
    public void setComData2(String comData2) {
        this.comData2 = comData2;
    }

    /**
	 * Column Info
	 * @param comData1
	 */
    public void setComData1(String comData1) {
        this.comData1 = comData1;
    }

    /**
	 * Column Info
	 * @param countryCode
	 */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
	 * Column Info
	 * @param nodeName
	 */
    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    /**
	 * Column Info
	 * @param code
	 */
    public void setCode(String code) {
        this.code = code;
    }

    /**
	 * Column Info
	 * @param kind
	 */
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
	 * Column Info
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    /**
	 * Column Info
	 * @param locationCode
	 */
    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    /**
	 * Column Info
	 * @param ibflag
	 */
    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
    }

    /**
	 * Column Info
	 * @param vslSlanNm
	 */
    public void setVslSlanNm(String vslSlanNm) {
        this.vslSlanNm = vslSlanNm;
    }

    /**
	 * Column Info
	 * @param chk
	 */
    public void setChk(String chk) {
        this.chk = chk;
    }

    /**
	 * Column Info
	 * @param yardCode
	 */
    public void setYardCode(String yardCode) {
        this.yardCode = yardCode;
    }

    /**
	 * Column Info
	 * @param laneCode
	 */
    public void setLaneCode(String laneCode) {
        this.laneCode = laneCode;
    }

    /**
	 * Column Info
	 * @param vendorSeq
	 */
    public void setVendorSeq(String vendorSeq) {
        this.vendorSeq = vendorSeq;
    }

    /**
	 * Column Info
	 * @param checkData
	 */
    public void setCheckData(String checkData) {
        this.checkData = checkData;
    }

    /**
	 * Column Info
	 * @param nodeCode
	 */
    public void setNodeCode(String nodeCode) {
        this.nodeCode = nodeCode;
    }

    public void setIsInThePast(String isInThePast) {
        this.isInThePast = isInThePast;
    }

    public String getIsInThePast() {
        return this.isInThePast;
    }

    public void setFullCgoCutOffTm(String fullCgoCutOffTm) {
        this.fullCgoCutOffTm = fullCgoCutOffTm;
    }

    public String getFullCgoCutOffTm() {
        return this.fullCgoCutOffTm;
    }

    public void setLoginUsrOfcCd(String loginUsrOfcCd) {
        this.loginUsrOfcCd = loginUsrOfcCd;
    }

    public String getLoginUsrOfcCd() {
        return this.loginUsrOfcCd;
    }

    public void setFullCgoCutOffYdCd(String fullCgoCutOffYdCd) {
        this.fullCgoCutOffYdCd = fullCgoCutOffYdCd;
    }

    public String getFullCgoCutOffYdCd() {
        return this.fullCgoCutOffYdCd;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setComData2(JSPUtil.getParameter(request, "com_data2", ""));
        setComData1(JSPUtil.getParameter(request, "com_data1", ""));
        setCountryCode(JSPUtil.getParameter(request, "country_code", ""));
        setNodeName(JSPUtil.getParameter(request, "node_name", ""));
        setCode(JSPUtil.getParameter(request, "code", ""));
        setKind(JSPUtil.getParameter(request, "kind", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setLocationCode(JSPUtil.getParameter(request, "location_code", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setVslSlanNm(JSPUtil.getParameter(request, "vsl_slan_nm", ""));
        setChk(JSPUtil.getParameter(request, "chk", ""));
        setYardCode(JSPUtil.getParameter(request, "yard_code", ""));
        setLaneCode(JSPUtil.getParameter(request, "lane_code", ""));
        setVendorSeq(JSPUtil.getParameter(request, "vendor_seq", ""));
        setCheckData(JSPUtil.getParameter(request, "check_data", ""));
        setNodeCode(JSPUtil.getParameter(request, "node_code", ""));
        setSkipFlagFunItemControl(JSPUtil.getParameter(request, "skip_flag_fun_itemControl", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ValidationVO[]
	 */
    public ValidationVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ValidationVO[]
	 */
    public ValidationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        ValidationVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] comData2 = (JSPUtil.getParameter(request, prefix + "com_data2", length));
            String[] comData1 = (JSPUtil.getParameter(request, prefix + "com_data1", length));
            String[] countryCode = (JSPUtil.getParameter(request, prefix + "country_code", length));
            String[] nodeName = (JSPUtil.getParameter(request, prefix + "node_name", length));
            String[] code = (JSPUtil.getParameter(request, prefix + "code", length));
            String[] kind = (JSPUtil.getParameter(request, prefix + "kind", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] locationCode = (JSPUtil.getParameter(request, prefix + "location_code", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] vslSlanNm = (JSPUtil.getParameter(request, prefix + "vsl_slan_nm", length));
            String[] chk = (JSPUtil.getParameter(request, prefix + "chk", length));
            String[] yardCode = (JSPUtil.getParameter(request, prefix + "yard_code", length));
            String[] laneCode = (JSPUtil.getParameter(request, prefix + "lane_code", length));
            String[] vendorSeq = (JSPUtil.getParameter(request, prefix + "vendor_seq", length));
            String[] checkData = (JSPUtil.getParameter(request, prefix + "check_data", length));
            String[] nodeCode = (JSPUtil.getParameter(request, prefix + "node_code", length));
            String[] skipFlagFunItemControl = (JSPUtil.getParameter(request, prefix + "skip_flag_fun_itemControl", length));
            String[] isInThePast = (JSPUtil.getParameter(request, prefix + "is_in_the_past", length));
            String[] fullCgoCutOffTm = (JSPUtil.getParameter(request, prefix + "full_cgo_cut_off_tm", length));
            String[] loginUsrOfcCd = (JSPUtil.getParameter(request, prefix + "login_usr_ofc_cd", length));
            String[] fullCgoCutOffYdCd = (JSPUtil.getParameter(request, prefix + "full_cgo_cut_off_yd_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new ValidationVO();
                if (comData2[i] != null)
                    model.setComData2(comData2[i]);
                if (comData1[i] != null)
                    model.setComData1(comData1[i]);
                if (countryCode[i] != null)
                    model.setCountryCode(countryCode[i]);
                if (nodeName[i] != null)
                    model.setNodeName(nodeName[i]);
                if (code[i] != null)
                    model.setCode(code[i]);
                if (kind[i] != null)
                    model.setKind(kind[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (locationCode[i] != null)
                    model.setLocationCode(locationCode[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (vslSlanNm[i] != null)
                    model.setVslSlanNm(vslSlanNm[i]);
                if (chk[i] != null)
                    model.setChk(chk[i]);
                if (yardCode[i] != null)
                    model.setYardCode(yardCode[i]);
                if (laneCode[i] != null)
                    model.setLaneCode(laneCode[i]);
                if (vendorSeq[i] != null)
                    model.setVendorSeq(vendorSeq[i]);
                if (checkData[i] != null)
                    model.setCheckData(checkData[i]);
                if (nodeCode[i] != null)
                    model.setNodeCode(nodeCode[i]);
                if (skipFlagFunItemControl[i] != null)
                    model.setSkipFlagFunItemControl(skipFlagFunItemControl[i]);
                if (isInThePast[i] != null)
                    model.setIsInThePast(isInThePast[i]);
                if (fullCgoCutOffTm[i] != null)
                    model.setFullCgoCutOffTm(fullCgoCutOffTm[i]);
                if (loginUsrOfcCd[i] != null)
                    model.setLoginUsrOfcCd(loginUsrOfcCd[i]);
                if (fullCgoCutOffYdCd[i] != null) 
		    		model.setFullCgoCutOffYdCd(fullCgoCutOffYdCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getValidationVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return ValidationVO[]
	 */
    public ValidationVO[] getValidationVOs() {
        ValidationVO[] vos = (ValidationVO[]) models.toArray(new ValidationVO[models.size()]);
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
        this.comData2 = this.comData2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.comData1 = this.comData1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.countryCode = this.countryCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nodeName = this.nodeName.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.code = this.code.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.kind = this.kind.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.locationCode = this.locationCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslSlanNm = this.vslSlanNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chk = this.chk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.yardCode = this.yardCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.laneCode = this.laneCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vendorSeq = this.vendorSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.checkData = this.checkData.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nodeCode = this.nodeCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skipFlagFunItemControl = this.skipFlagFunItemControl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.isInThePast = this.isInThePast.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fullCgoCutOffTm = this.fullCgoCutOffTm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.loginUsrOfcCd = this.loginUsrOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fullCgoCutOffYdCd = this.fullCgoCutOffYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
