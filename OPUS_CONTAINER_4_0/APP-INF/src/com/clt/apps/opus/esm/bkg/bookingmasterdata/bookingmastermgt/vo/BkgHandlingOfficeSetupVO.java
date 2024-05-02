/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BkgHandlingOfficeSetupVO.java
*@FileTitle : BkgHandlingOfficeSetupVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.26
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.26 
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
public class BkgHandlingOfficeSetupVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<BkgHandlingOfficeSetupVO> models = new ArrayList<BkgHandlingOfficeSetupVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String bkgHndlOfcSeq = null;

    /* Column Info */
    private String polCd = null;

    /* Column Info */
    private String cmdtNm = null;

    /* Column Info */
    private String hndlOfcCd = null;

    /* Column Info */
    private String porCd = null;

    /* Column Info */
    private String custCntCd = null;

    /* Column Info */
    private String custSeq = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String custCd = null;

    /* Column Info */
    private String velType = null;

    /* Column Info */
    private String velData = null;

    /* Column Info */
    private String vtCustOfcCd = null;

    /* Column Info */
    private String vtCustCntCd = null;

    /* Column Info */
    private String vtCustOfcNm = null;

    /* Column Info */
    private String insertCheck = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public BkgHandlingOfficeSetupVO() {
    }

    public BkgHandlingOfficeSetupVO(String ibflag, String pagerows, String bkgHndlOfcSeq, String polCd, String cmdtNm, String hndlOfcCd, String porCd, String custCntCd, String custSeq, String creUsrId, String creDt, String updUsrId, String updDt, String custCd, String velType, String velData, String vtCustOfcCd, String vtCustCntCd, String vtCustOfcNm, String insertCheck) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.bkgHndlOfcSeq = bkgHndlOfcSeq;
        this.polCd = polCd;
        this.cmdtNm = cmdtNm;
        this.hndlOfcCd = hndlOfcCd;
        this.porCd = porCd;
        this.custCntCd = custCntCd;
        this.custSeq = custSeq;
        this.creUsrId = creUsrId;
        this.creDt = creDt;
        this.updUsrId = updUsrId;
        this.updDt = updDt;
        this.custCd = custCd;
        this.velType = velType;
        this.velData = velData;
        this.vtCustOfcCd = vtCustOfcCd;
        this.vtCustCntCd = vtCustCntCd;
        this.vtCustOfcNm = vtCustOfcNm;
        this.insertCheck = insertCheck;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("bkg_hndl_ofc_seq", getBkgHndlOfcSeq());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("cmdt_nm", getCmdtNm());
        this.hashColumns.put("hndl_ofc_cd", getHndlOfcCd());
        this.hashColumns.put("por_cd", getPorCd());
        this.hashColumns.put("cust_cnt_cd", getCustCntCd());
        this.hashColumns.put("cust_seq", getCustSeq());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("cust_cd", getCustCd());
        this.hashColumns.put("vel_type", getVelType());
        this.hashColumns.put("vel_data", getVelData());
        this.hashColumns.put("vt_cust_ofc_cd", getVtCustOfcCd());
        this.hashColumns.put("vt_cust_cnt_cd", getVtCustCntCd());
        this.hashColumns.put("vt_cust_ofc_nm", getVtCustOfcNm());
        this.hashColumns.put("insert_check", getInsertCheck());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("bkg_hndl_ofc_seq", "bkgHndlOfcSeq");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("cmdt_nm", "cmdtNm");
        this.hashFields.put("hndl_ofc_cd", "hndlOfcCd");
        this.hashFields.put("por_cd", "porCd");
        this.hashFields.put("cust_cnt_cd", "custCntCd");
        this.hashFields.put("cust_seq", "custSeq");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("cust_cd", "custCd");
        this.hashFields.put("vel_type", "velType");
        this.hashFields.put("vel_data", "velData");
        this.hashFields.put("vt_cust_ofc_cd", "vtCustOfcCd");
        this.hashFields.put("vt_cust_cnt_cd", "vtCustCntCd");
        this.hashFields.put("vt_cust_ofc_nm", "vtCustOfcNm");
        this.hashFields.put("insert_check", "insertCheck");
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
	 * @param String bkgHndlOfcSeq
	 */
    public void setBkgHndlOfcSeq(String bkgHndlOfcSeq) {
        this.bkgHndlOfcSeq = bkgHndlOfcSeq;
    }

    /**
	 * 
	 * @return String bkgHndlOfcSeq
	 */
    public String getBkgHndlOfcSeq() {
        return this.bkgHndlOfcSeq;
    }

    /**
	 *
	 * @param String polCd
	 */
    public void setPolCd(String polCd) {
        this.polCd = polCd;
    }

    /**
	 * 
	 * @return String polCd
	 */
    public String getPolCd() {
        return this.polCd;
    }

    /**
	 *
	 * @param String cmdtNm
	 */
    public void setCmdtNm(String cmdtNm) {
        this.cmdtNm = cmdtNm;
    }

    /**
	 * 
	 * @return String cmdtNm
	 */
    public String getCmdtNm() {
        return this.cmdtNm;
    }

    /**
	 *
	 * @param String hndlOfcCd
	 */
    public void setHndlOfcCd(String hndlOfcCd) {
        this.hndlOfcCd = hndlOfcCd;
    }

    /**
	 * 
	 * @return String hndlOfcCd
	 */
    public String getHndlOfcCd() {
        return this.hndlOfcCd;
    }

    /**
	 *
	 * @param String porCd
	 */
    public void setPorCd(String porCd) {
        this.porCd = porCd;
    }

    /**
	 * 
	 * @return String porCd
	 */
    public String getPorCd() {
        return this.porCd;
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

    public void setCustCd(String custCd) {
        this.custCd = custCd;
    }

    public String getCustCd() {
        return this.custCd;
    }

    public void setVelType(String velType) {
        this.velType = velType;
    }

    public String getVelType() {
        return this.velType;
    }

    public void setVelData(String velData) {
        this.velData = velData;
    }

    public String getVelData() {
        return this.velData;
    }

    public void setVtCustOfcCd(String vtCustOfcCd) {
        this.vtCustOfcCd = vtCustOfcCd;
    }

    public String getVtCustOfcCd() {
        return this.vtCustOfcCd;
    }

    public void setVtCustCntCd(String vtCustCntCd) {
        this.vtCustCntCd = vtCustCntCd;
    }

    public String getVtCustCntCd() {
        return this.vtCustCntCd;
    }

    public void setVtCustOfcNm(String vtCustOfcNm) {
        this.vtCustOfcNm = vtCustOfcNm;
    }

    public String getVtCustOfcNm() {
        return this.vtCustOfcNm;
    }

    public void setInsertCheck(String insertCheck) {
        this.insertCheck = insertCheck;
    }

    public String getInsertCheck() {
        return this.insertCheck;
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
        setBkgHndlOfcSeq(JSPUtil.getParameter(request, prefix + "bkg_hndl_ofc_seq", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
        setHndlOfcCd(JSPUtil.getParameter(request, prefix + "hndl_ofc_cd", ""));
        setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
        setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
        setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
        setVelType(JSPUtil.getParameter(request, prefix + "vel_type", ""));
        setVelData(JSPUtil.getParameter(request, prefix + "vel_data", ""));
        setVtCustOfcCd(JSPUtil.getParameter(request, prefix + "vt_cust_ofc_cd", ""));
        setVtCustCntCd(JSPUtil.getParameter(request, prefix + "vt_cust_cnt_cd", ""));
        setVtCustOfcNm(JSPUtil.getParameter(request, prefix + "vt_cust_ofc_nm", ""));
        setInsertCheck(JSPUtil.getParameter(request, prefix + "insert_check", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgHandlingOfficeSetupVO[]
	 */
    public BkgHandlingOfficeSetupVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgHandlingOfficeSetupVO[]
	 */
    public BkgHandlingOfficeSetupVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        BkgHandlingOfficeSetupVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] bkgHndlOfcSeq = (JSPUtil.getParameter(request, prefix + "bkg_hndl_ofc_seq", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] cmdtNm = (JSPUtil.getParameter(request, prefix + "cmdt_nm", length));
            String[] hndlOfcCd = (JSPUtil.getParameter(request, prefix + "hndl_ofc_cd", length));
            String[] porCd = (JSPUtil.getParameter(request, prefix + "por_cd", length));
            String[] custCntCd = (JSPUtil.getParameter(request, prefix + "cust_cnt_cd", length));
            String[] custSeq = (JSPUtil.getParameter(request, prefix + "cust_seq", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] custCd = (JSPUtil.getParameter(request, prefix + "cust_cd", length));
            String[] velType = (JSPUtil.getParameter(request, prefix + "vel_type", length));
            String[] velData = (JSPUtil.getParameter(request, prefix + "vel_data", length));
            String[] vtCustOfcCd = (JSPUtil.getParameter(request, prefix + "vt_cust_ofc_cd", length));
            String[] vtCustCntCd = (JSPUtil.getParameter(request, prefix + "vt_cust_cnt_cd", length));
            String[] vtCustOfcNm = (JSPUtil.getParameter(request, prefix + "vt_cust_ofc_nm", length));
            String[] insertCheck = (JSPUtil.getParameter(request, prefix + "insert_check", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new BkgHandlingOfficeSetupVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (bkgHndlOfcSeq[i] != null)
                    model.setBkgHndlOfcSeq(bkgHndlOfcSeq[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (cmdtNm[i] != null)
                    model.setCmdtNm(cmdtNm[i]);
                if (hndlOfcCd[i] != null)
                    model.setHndlOfcCd(hndlOfcCd[i]);
                if (porCd[i] != null)
                    model.setPorCd(porCd[i]);
                if (custCntCd[i] != null)
                    model.setCustCntCd(custCntCd[i]);
                if (custSeq[i] != null)
                    model.setCustSeq(custSeq[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (custCd[i] != null)
                    model.setCustCd(custCd[i]);
                if (velType[i] != null)
                    model.setVelType(velType[i]);
                if (velData[i] != null)
                    model.setVelData(velData[i]);
                if (vtCustOfcCd[i] != null)
                    model.setVtCustOfcCd(vtCustOfcCd[i]);
                if (vtCustCntCd[i] != null)
                    model.setVtCustCntCd(vtCustCntCd[i]);
                if (vtCustOfcNm[i] != null)
                    model.setVtCustOfcNm(vtCustOfcNm[i]);
                if (insertCheck[i] != null) 
		    		model.setInsertCheck(insertCheck[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getBkgHandlingOfficeSetupVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return BkgHandlingOfficeSetupVO[]
	 */
    public BkgHandlingOfficeSetupVO[] getBkgHandlingOfficeSetupVOs() {
        BkgHandlingOfficeSetupVO[] vos = (BkgHandlingOfficeSetupVO[]) models.toArray(new BkgHandlingOfficeSetupVO[models.size()]);
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
        this.bkgHndlOfcSeq = this.bkgHndlOfcSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtNm = this.cmdtNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hndlOfcCd = this.hndlOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.porCd = this.porCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCntCd = this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custSeq = this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCd = this.custCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.velType = this.velType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.velData = this.velData.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vtCustOfcCd = this.vtCustOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vtCustCntCd = this.vtCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vtCustOfcNm = this.vtCustOfcNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.insertCheck = this.insertCheck.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
