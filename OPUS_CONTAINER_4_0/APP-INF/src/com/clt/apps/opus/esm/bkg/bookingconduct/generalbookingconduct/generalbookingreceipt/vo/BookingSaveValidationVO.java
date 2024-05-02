/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingSaveValidationVO.java
*@FileTitle : BookingSaveValidationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.23
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.02.23 류대영 
* 1.0 Creation
* --------------------------------------------------------
* HISTORY
* 2010.11.04 김영철 [] Booking Creation / Update / Cancel시, Vessel Operation 모듈의 Final CBF 생성 여부를 체크해서 경고 메시지
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo;

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
public class BookingSaveValidationVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<BookingSaveValidationVO> models = new ArrayList<BookingSaveValidationVO>();

    /* Column Info */
    private String caRsnCd = null;

    /* Column Info */
    private String qtyModifyFlag = null;

    /* Column Info */
    private String closeBkgFlag = null;

    /* Column Info */
    private String caNewCreationFlag = null;

    /* Column Info */
    private String blMoveTpNm = null;

    /* Column Info */
    private String trunkVvd = null;

    /* Column Info */
    private String spclCgoFlg = null;

    /* Column Info */
    private String contactModifyFlag = null;

    /* Column Info */
    private String saveMsg = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String closeBkgMsg = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String caRemark = null;

    /* Column Info */
    private String routeModifyFlag = null;

    /* Column Info */
    private String modifyFlag = null;

    /* Column Info */
    private String customerModifyFlag = null;

    /* Column Info */
    private String troCfrmFlg = null;

    /* Column Info */
    private String changeFirstVvd = null;

    /* Column Info */
    private String trnkLaneCd = null;

    /* Column Info */
    private String isRated = null;

    /* Column Info */
    private String changeVvd = null;

    /* Column Info */
    private String precheckingFlag = null;

    /* Column Info */
    private String cbfBkgFlag = null;

    /* Column Info */
    private String changeLoc = null;

    /* Column Info */
    private String spclCgoApproval = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public BookingSaveValidationVO() {
    }

    public BookingSaveValidationVO(String ibflag, String pagerows, String blMoveTpNm, String troCfrmFlg, String spclCgoFlg, String trnkLaneCd, String changeFirstVvd, String changeVvd, String isRated, String caNewCreationFlag, String caRsnCd, String caRemark, String trunkVvd, String routeModifyFlag, String customerModifyFlag, String contactModifyFlag, String qtyModifyFlag, String modifyFlag, String closeBkgFlag, String closeBkgMsg, String saveMsg, String precheckingFlag, String cbfBkgFlag, String changeLoc, String spclCgoApproval) {
        this.caRsnCd = caRsnCd;
        this.qtyModifyFlag = qtyModifyFlag;
        this.closeBkgFlag = closeBkgFlag;
        this.caNewCreationFlag = caNewCreationFlag;
        this.blMoveTpNm = blMoveTpNm;
        this.trunkVvd = trunkVvd;
        this.spclCgoFlg = spclCgoFlg;
        this.contactModifyFlag = contactModifyFlag;
        this.saveMsg = saveMsg;
        this.pagerows = pagerows;
        this.closeBkgMsg = closeBkgMsg;
        this.ibflag = ibflag;
        this.caRemark = caRemark;
        this.routeModifyFlag = routeModifyFlag;
        this.modifyFlag = modifyFlag;
        this.customerModifyFlag = customerModifyFlag;
        this.troCfrmFlg = troCfrmFlg;
        this.changeFirstVvd = changeFirstVvd;
        this.trnkLaneCd = trnkLaneCd;
        this.isRated = isRated;
        this.changeVvd = changeVvd;
        this.precheckingFlag = precheckingFlag;
        this.cbfBkgFlag = cbfBkgFlag;
        this.changeLoc = changeLoc;
        this.spclCgoApproval = spclCgoApproval;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ca_rsn_cd", getCaRsnCd());
        this.hashColumns.put("qty_modify_flag", getQtyModifyFlag());
        this.hashColumns.put("close_bkg_flag", getCloseBkgFlag());
        this.hashColumns.put("ca_new_creation_flag", getCaNewCreationFlag());
        this.hashColumns.put("bl_move_tp_nm", getBlMoveTpNm());
        this.hashColumns.put("trunk_vvd", getTrunkVvd());
        this.hashColumns.put("spcl_cgo_flg", getSpclCgoFlg());
        this.hashColumns.put("contact_modify_flag", getContactModifyFlag());
        this.hashColumns.put("save_msg", getSaveMsg());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("close_bkg_msg", getCloseBkgMsg());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("ca_remark", getCaRemark());
        this.hashColumns.put("route_modify_flag", getRouteModifyFlag());
        this.hashColumns.put("modify_flag", getModifyFlag());
        this.hashColumns.put("customer_modify_flag", getCustomerModifyFlag());
        this.hashColumns.put("tro_cfrm_flg", getTroCfrmFlg());
        this.hashColumns.put("change_first_vvd", getChangeFirstVvd());
        this.hashColumns.put("trnk_lane_cd", getTrnkLaneCd());
        this.hashColumns.put("is_rated", getIsRated());
        this.hashColumns.put("change_vvd", getChangeVvd());
        this.hashColumns.put("prechecking_flag", getPrecheckingFlag());
        this.hashColumns.put("cbf_bkg_flag", getCbfBkgFlag());
        this.hashColumns.put("change_loc", getChangeLoc());
        this.hashColumns.put("spcl_cgo_approval", getSpclCgoApproval());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ca_rsn_cd", "caRsnCd");
        this.hashFields.put("qty_modify_flag", "qtyModifyFlag");
        this.hashFields.put("close_bkg_flag", "closeBkgFlag");
        this.hashFields.put("ca_new_creation_flag", "caNewCreationFlag");
        this.hashFields.put("bl_move_tp_nm", "blMoveTpNm");
        this.hashFields.put("trunk_vvd", "trunkVvd");
        this.hashFields.put("spcl_cgo_flg", "spclCgoFlg");
        this.hashFields.put("contact_modify_flag", "contactModifyFlag");
        this.hashFields.put("save_msg", "saveMsg");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("close_bkg_msg", "closeBkgMsg");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("ca_remark", "caRemark");
        this.hashFields.put("route_modify_flag", "routeModifyFlag");
        this.hashFields.put("modify_flag", "modifyFlag");
        this.hashFields.put("customer_modify_flag", "customerModifyFlag");
        this.hashFields.put("tro_cfrm_flg", "troCfrmFlg");
        this.hashFields.put("change_first_vvd", "changeFirstVvd");
        this.hashFields.put("trnk_lane_cd", "trnkLaneCd");
        this.hashFields.put("is_rated", "isRated");
        this.hashFields.put("change_vvd", "changeVvd");
        this.hashFields.put("prechecking_flag", "precheckingFlag");
        this.hashFields.put("cbf_bkg_flag", "cbfBkgFlag");
        this.hashFields.put("change_loc", "changeLoc");
        this.hashFields.put("spcl_cgo_approval", "spclCgoApproval");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return caRsnCd
	 */
    public String getCaRsnCd() {
        return this.caRsnCd;
    }

    /**
	 * Column Info
	 * @return qtyModifyFlag
	 */
    public String getQtyModifyFlag() {
        return this.qtyModifyFlag;
    }

    /**
	 * Column Info
	 * @return closeBkgFlag
	 */
    public String getCloseBkgFlag() {
        return this.closeBkgFlag;
    }

    /**
	 * Column Info
	 * @return caNewCreationFlag
	 */
    public String getCaNewCreationFlag() {
        return this.caNewCreationFlag;
    }

    /**
	 * Column Info
	 * @return blMoveTpNm
	 */
    public String getBlMoveTpNm() {
        return this.blMoveTpNm;
    }

    /**
	 * Column Info
	 * @return trunkVvd
	 */
    public String getTrunkVvd() {
        return this.trunkVvd;
    }

    /**
	 * Column Info
	 * @return spclCgoFlg
	 */
    public String getSpclCgoFlg() {
        return this.spclCgoFlg;
    }

    /**
	 * Column Info
	 * @return contactModifyFlag
	 */
    public String getContactModifyFlag() {
        return this.contactModifyFlag;
    }

    /**
	 * Column Info
	 * @return saveMsg
	 */
    public String getSaveMsg() {
        return this.saveMsg;
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
	 * @return closeBkgMsg
	 */
    public String getCloseBkgMsg() {
        return this.closeBkgMsg;
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
	 * @return caRemark
	 */
    public String getCaRemark() {
        return this.caRemark;
    }

    /**
	 * Column Info
	 * @return routeModifyFlag
	 */
    public String getRouteModifyFlag() {
        return this.routeModifyFlag;
    }

    /**
	 * Column Info
	 * @return modifyFlag
	 */
    public String getModifyFlag() {
        return this.modifyFlag;
    }

    /**
	 * Column Info
	 * @return customerModifyFlag
	 */
    public String getCustomerModifyFlag() {
        return this.customerModifyFlag;
    }

    /**
	 * Column Info
	 * @return troCfrmFlg
	 */
    public String getTroCfrmFlg() {
        return this.troCfrmFlg;
    }

    /**
	 * Column Info
	 * @return changeFirstVvd
	 */
    public String getChangeFirstVvd() {
        return this.changeFirstVvd;
    }

    /**
	 * Column Info
	 * @return trnkLaneCd
	 */
    public String getTrnkLaneCd() {
        return this.trnkLaneCd;
    }

    /**
	 * Column Info
	 * @return isRated
	 */
    public String getIsRated() {
        return this.isRated;
    }

    /**
	 * Column Info
	 * @return changeVvd
	 */
    public String getChangeVvd() {
        return this.changeVvd;
    }

    /**
	 * Column Info
	 * @return precheckingFlag
	 */
    public String getPrecheckingFlag() {
        return this.precheckingFlag;
    }

    /**
	 * Column Info
	 * @return changeLoc
	 */
    public String getChangeLoc() {
        return this.changeLoc;
    }

    /**
	 * Column Info
	 * @param caRsnCd
	 */
    public void setCaRsnCd(String caRsnCd) {
        this.caRsnCd = caRsnCd;
    }

    /**
	 * Column Info
	 * @param qtyModifyFlag
	 */
    public void setQtyModifyFlag(String qtyModifyFlag) {
        this.qtyModifyFlag = qtyModifyFlag;
    }

    /**
	 * Column Info
	 * @param closeBkgFlag
	 */
    public void setCloseBkgFlag(String closeBkgFlag) {
        this.closeBkgFlag = closeBkgFlag;
    }

    /**
	 * Column Info
	 * @param caNewCreationFlag
	 */
    public void setCaNewCreationFlag(String caNewCreationFlag) {
        this.caNewCreationFlag = caNewCreationFlag;
    }

    /**
	 * Column Info
	 * @param blMoveTpNm
	 */
    public void setBlMoveTpNm(String blMoveTpNm) {
        this.blMoveTpNm = blMoveTpNm;
    }

    /**
	 * Column Info
	 * @param trunkVvd
	 */
    public void setTrunkVvd(String trunkVvd) {
        this.trunkVvd = trunkVvd;
    }

    /**
	 * Column Info
	 * @param spclCgoFlg
	 */
    public void setSpclCgoFlg(String spclCgoFlg) {
        this.spclCgoFlg = spclCgoFlg;
    }

    /**
	 * Column Info
	 * @param contactModifyFlag
	 */
    public void setContactModifyFlag(String contactModifyFlag) {
        this.contactModifyFlag = contactModifyFlag;
    }

    /**
	 * Column Info
	 * @param saveMsg
	 */
    public void setSaveMsg(String saveMsg) {
        this.saveMsg = saveMsg;
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
	 * @param closeBkgMsg
	 */
    public void setCloseBkgMsg(String closeBkgMsg) {
        this.closeBkgMsg = closeBkgMsg;
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
	 * @param caRemark
	 */
    public void setCaRemark(String caRemark) {
        this.caRemark = caRemark;
    }

    /**
	 * Column Info
	 * @param routeModifyFlag
	 */
    public void setRouteModifyFlag(String routeModifyFlag) {
        this.routeModifyFlag = routeModifyFlag;
    }

    /**
	 * Column Info
	 * @param modifyFlag
	 */
    public void setModifyFlag(String modifyFlag) {
        this.modifyFlag = modifyFlag;
    }

    /**
	 * Column Info
	 * @param customerModifyFlag
	 */
    public void setCustomerModifyFlag(String customerModifyFlag) {
        this.customerModifyFlag = customerModifyFlag;
    }

    /**
	 * Column Info
	 * @param troCfrmFlg
	 */
    public void setTroCfrmFlg(String troCfrmFlg) {
        this.troCfrmFlg = troCfrmFlg;
    }

    /**
	 * Column Info
	 * @param changeFirstVvd
	 */
    public void setChangeFirstVvd(String changeFirstVvd) {
        this.changeFirstVvd = changeFirstVvd;
    }

    /**
	 * Column Info
	 * @param trnkLaneCd
	 */
    public void setTrnkLaneCd(String trnkLaneCd) {
        this.trnkLaneCd = trnkLaneCd;
    }

    /**
	 * Column Info
	 * @param isRated
	 */
    public void setIsRated(String isRated) {
        this.isRated = isRated;
    }

    /**
	 * Column Info
	 * @param changeVvd
	 */
    public void setChangeVvd(String changeVvd) {
        this.changeVvd = changeVvd;
    }

    /**
	 * Column Info
	 * @param precheckingFlag
	 */
    public void setPrecheckingFlag(String precheckingFlag) {
        this.precheckingFlag = precheckingFlag;
    }

    public String getCbfBkgFlag() {
        return cbfBkgFlag;
    }

    public void setCbfBkgFlag(String cbfBkgFlag) {
        this.cbfBkgFlag = cbfBkgFlag;
    }

    /**
	 * Column Info
	 * @param changeLoc
	 */
    public void setChangeLoc(String changeLoc) {
        this.changeLoc = changeLoc;
    }

    public void setSpclCgoApproval(String spclCgoApproval) {
        this.spclCgoApproval = spclCgoApproval;
    }

    public String getSpclCgoApproval() {
        return this.spclCgoApproval;
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
        setCaRsnCd(JSPUtil.getParameter(request, prefix + "ca_rsn_cd", ""));
        setQtyModifyFlag(JSPUtil.getParameter(request, prefix + "qty_modify_flag", ""));
        setCloseBkgFlag(JSPUtil.getParameter(request, prefix + "close_bkg_flag", ""));
        setCaNewCreationFlag(JSPUtil.getParameter(request, prefix + "ca_new_creation_flag", ""));
        setBlMoveTpNm(JSPUtil.getParameter(request, prefix + "bl_move_tp_nm", ""));
        setTrunkVvd(JSPUtil.getParameter(request, prefix + "trunk_vvd", ""));
        setSpclCgoFlg(JSPUtil.getParameter(request, prefix + "spcl_cgo_flg", ""));
        setContactModifyFlag(JSPUtil.getParameter(request, prefix + "contact_modify_flag", ""));
        setSaveMsg(JSPUtil.getParameter(request, prefix + "save_msg", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setCloseBkgMsg(JSPUtil.getParameter(request, prefix + "close_bkg_msg", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setCaRemark(JSPUtil.getParameter(request, prefix + "ca_remark", ""));
        setRouteModifyFlag(JSPUtil.getParameter(request, prefix + "route_modify_flag", ""));
        setModifyFlag(JSPUtil.getParameter(request, prefix + "modify_flag", ""));
        setCustomerModifyFlag(JSPUtil.getParameter(request, prefix + "customer_modify_flag", ""));
        setTroCfrmFlg(JSPUtil.getParameter(request, prefix + "tro_cfrm_flg", ""));
        setChangeFirstVvd(JSPUtil.getParameter(request, prefix + "change_first_vvd", ""));
        setTrnkLaneCd(JSPUtil.getParameter(request, prefix + "trnk_lane_cd", ""));
        setIsRated(JSPUtil.getParameter(request, prefix + "is_rated", ""));
        setChangeVvd(JSPUtil.getParameter(request, prefix + "change_vvd", ""));
        setPrecheckingFlag(JSPUtil.getParameter(request, prefix + "prechecking_flag", ""));
        setCbfBkgFlag(JSPUtil.getParameter(request, prefix + "cbf_bkg_flag", ""));
        setChangeLoc(JSPUtil.getParameter(request, prefix + "change_loc", ""));
        setSpclCgoApproval(JSPUtil.getParameter(request, prefix + "spcl_cgo_approval", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BookingSaveValidationVO[]
	 */
    public BookingSaveValidationVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BookingSaveValidationVO[]
	 */
    public BookingSaveValidationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        BookingSaveValidationVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] caRsnCd = (JSPUtil.getParameter(request, prefix + "ca_rsn_cd", length));
            String[] qtyModifyFlag = (JSPUtil.getParameter(request, prefix + "qty_modify_flag", length));
            String[] closeBkgFlag = (JSPUtil.getParameter(request, prefix + "close_bkg_flag", length));
            String[] caNewCreationFlag = (JSPUtil.getParameter(request, prefix + "ca_new_creation_flag", length));
            String[] blMoveTpNm = (JSPUtil.getParameter(request, prefix + "bl_move_tp_nm", length));
            String[] trunkVvd = (JSPUtil.getParameter(request, prefix + "trunk_vvd", length));
            String[] spclCgoFlg = (JSPUtil.getParameter(request, prefix + "spcl_cgo_flg", length));
            String[] contactModifyFlag = (JSPUtil.getParameter(request, prefix + "contact_modify_flag", length));
            String[] saveMsg = (JSPUtil.getParameter(request, prefix + "save_msg", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] closeBkgMsg = (JSPUtil.getParameter(request, prefix + "close_bkg_msg", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] caRemark = (JSPUtil.getParameter(request, prefix + "ca_remark", length));
            String[] routeModifyFlag = (JSPUtil.getParameter(request, prefix + "route_modify_flag", length));
            String[] modifyFlag = (JSPUtil.getParameter(request, prefix + "modify_flag", length));
            String[] customerModifyFlag = (JSPUtil.getParameter(request, prefix + "customer_modify_flag", length));
            String[] troCfrmFlg = (JSPUtil.getParameter(request, prefix + "tro_cfrm_flg", length));
            String[] changeFirstVvd = (JSPUtil.getParameter(request, prefix + "change_first_vvd", length));
            String[] trnkLaneCd = (JSPUtil.getParameter(request, prefix + "trnk_lane_cd", length));
            String[] isRated = (JSPUtil.getParameter(request, prefix + "is_rated", length));
            String[] changeVvd = (JSPUtil.getParameter(request, prefix + "change_vvd", length));
            String[] precheckingFlag = (JSPUtil.getParameter(request, prefix + "prechecking_flag", length));
            String[] cbfBkgFlag = (JSPUtil.getParameter(request, prefix + "cbf_bkg_flag", length));
            String[] changeLoc = (JSPUtil.getParameter(request, prefix + "change_loc", length));
            String[] spclCgoApproval = (JSPUtil.getParameter(request, prefix + "spcl_cgo_approval", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new BookingSaveValidationVO();
                if (caRsnCd[i] != null)
                    model.setCaRsnCd(caRsnCd[i]);
                if (qtyModifyFlag[i] != null)
                    model.setQtyModifyFlag(qtyModifyFlag[i]);
                if (closeBkgFlag[i] != null)
                    model.setCloseBkgFlag(closeBkgFlag[i]);
                if (caNewCreationFlag[i] != null)
                    model.setCaNewCreationFlag(caNewCreationFlag[i]);
                if (blMoveTpNm[i] != null)
                    model.setBlMoveTpNm(blMoveTpNm[i]);
                if (trunkVvd[i] != null)
                    model.setTrunkVvd(trunkVvd[i]);
                if (spclCgoFlg[i] != null)
                    model.setSpclCgoFlg(spclCgoFlg[i]);
                if (contactModifyFlag[i] != null)
                    model.setContactModifyFlag(contactModifyFlag[i]);
                if (saveMsg[i] != null)
                    model.setSaveMsg(saveMsg[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (closeBkgMsg[i] != null)
                    model.setCloseBkgMsg(closeBkgMsg[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (caRemark[i] != null)
                    model.setCaRemark(caRemark[i]);
                if (routeModifyFlag[i] != null)
                    model.setRouteModifyFlag(routeModifyFlag[i]);
                if (modifyFlag[i] != null)
                    model.setModifyFlag(modifyFlag[i]);
                if (customerModifyFlag[i] != null)
                    model.setCustomerModifyFlag(customerModifyFlag[i]);
                if (troCfrmFlg[i] != null)
                    model.setTroCfrmFlg(troCfrmFlg[i]);
                if (changeFirstVvd[i] != null)
                    model.setChangeFirstVvd(changeFirstVvd[i]);
                if (trnkLaneCd[i] != null)
                    model.setTrnkLaneCd(trnkLaneCd[i]);
                if (isRated[i] != null)
                    model.setIsRated(isRated[i]);
                if (changeVvd[i] != null)
                    model.setChangeVvd(changeVvd[i]);
                if (precheckingFlag[i] != null)
                    model.setPrecheckingFlag(precheckingFlag[i]);
                if (cbfBkgFlag[i] != null)
                    model.setCbfBkgFlag(cbfBkgFlag[i]);
                if (changeLoc[i] != null)
                    model.setChangeLoc(changeLoc[i]);
                if (spclCgoApproval[i] != null) 
		    		model.setSpclCgoApproval(spclCgoApproval[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getBookingSaveValidationVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return BookingSaveValidationVO[]
	 */
    public BookingSaveValidationVO[] getBookingSaveValidationVOs() {
        BookingSaveValidationVO[] vos = (BookingSaveValidationVO[]) models.toArray(new BookingSaveValidationVO[models.size()]);
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
        this.caRsnCd = this.caRsnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.qtyModifyFlag = this.qtyModifyFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.closeBkgFlag = this.closeBkgFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.caNewCreationFlag = this.caNewCreationFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blMoveTpNm = this.blMoveTpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trunkVvd = this.trunkVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoFlg = this.spclCgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.contactModifyFlag = this.contactModifyFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.saveMsg = this.saveMsg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.closeBkgMsg = this.closeBkgMsg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.caRemark = this.caRemark.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.routeModifyFlag = this.routeModifyFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.modifyFlag = this.modifyFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.customerModifyFlag = this.customerModifyFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.troCfrmFlg = this.troCfrmFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.changeFirstVvd = this.changeFirstVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trnkLaneCd = this.trnkLaneCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.isRated = this.isRated.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.changeVvd = this.changeVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.precheckingFlag = this.precheckingFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cbfBkgFlag = this.cbfBkgFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.changeLoc = this.changeLoc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoApproval = this.spclCgoApproval.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
