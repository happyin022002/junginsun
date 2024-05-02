/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ExternalRqstListVO.java
 *@FileTitle : ExternalRqstListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.06.13
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.06.13  
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class ExternalRqstListVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<ExternalRqstListVO> models = new ArrayList<ExternalRqstListVO>();

    /*	Column Info	*/
    private String vslCd = null;

    /*	Column Info	*/
    private String bkgStsCd = null;

    /*	Column Info	*/
    private String xterDelNm = null;

    /*	Column Info	*/
    private String rowCount = null;

    /*	Column Info	*/
    private String cntcEml = null;

    /*	Column Info	*/
    private String rqstAcptDesc = null;

    /*	Column Info	*/
    private String xterPodCd = null;

    /*	Column Info	*/
    private String bkgUpldStsCd = null;

    /*	Column Info	*/
    private String xterBkgRqstStsCd = null;

    /*	Column Info	*/
    private String docTpCd = null;

    /*	Column Info	*/
    private String hndlOfcCd = null;

    /*	Column Info	*/
    private String pagerows = null;

    /*	Column Info	*/
    private String xterPorNm = null;

    /*	Column Info	*/
    private String xterDelCd = null;

    /*	Column Info	*/
    private String xterPolCd = null;

    /*	Column Info	*/
    private String ibflag = null;

    /*	Column Info	*/
    private String vslEngNm = null;

    /*	Column Info	*/
    private String xterPorCd = null;

    /*	Column Info	*/
    private String xterRqstAcptUsrId = null;

    /*	Column Info	*/
    private String shNm = null;

    /*	Column Info	*/
    private String xterRqstViaCd = null;

    /*	Column Info	*/
    private String upldDt = null;

    /*	Column Info	*/
    private String xterSndrId = null;

    /*	Column Info	*/
    private String upldUsrId = null;

    /*	Column Info	*/
    private String rqstDt = null;

    /*	Column Info	*/
    private String rqstGmtDt = null;

    /*	Column Info	*/
    private String xterRqstAcptUsrNm = null;

    /*	Column Info	*/
    private String snaccsSplitNo = null;

    /*	Column Info	*/
    private String origin = null;

    /*	Column Info	*/
    private String skdVoyNo = null;

    /*	Column Info	*/
    private String rqstDepDt = null;

    /*	Column Info	*/
    private String ffNm = null;

    /*	Column Info	*/
    private String xterPolNm = null;

    /*	Column Info	*/
    private String vvd = null;

    /*	Column Info	*/
    private String upldUsrNm = null;

    /*	Column Info	*/
    private String ofcCd = null;

    /*	Column Info	*/
    private String poNo = null;

    /*	Column Info	*/
    private String bkgNo = null;

    /*	Column Info	*/
    private String bkgNoCheck = null;

    /*	Column Info	*/
    private String xterPodNm = null;

    /*	Column Info	*/
    private String xterRqstSeq = null;

    /*	Column Info	*/
    private String dispXterRqstSeq = null;

    /*	Column Info	*/
    private String xterRqstNo = null;

    /*	Column Info	*/
    private String delivery = null;

    /*	Column Info	*/
    private String rowNum = null;

    /*	Column Info	*/
    private String cnNm = null;

    /*	Column Info	*/
    private String xterRjctRsnNm = null;

    /*	Column Info	*/
    private String rjctRsnRmk = null;

    /*	Column Info	*/
    private String xterPndRsnNm = null;

    /*	Column Info	*/
    private String custRefNo = null;

    /*	Column Info	*/
    private String xterRqstRvisSeq = null;

    /*	Column Info	*/
    private String slanCd = null;

    /*	Column Info	*/
    private String blDocInpFlg = null;

    /*	Column Info	*/
    private String blFntOfcFlg = null;

    /*	Column Info	*/
    private String splitStsCd = null;

    /*	Column Info	*/
    private String xptRefNo = null;

    /*	Column Info	*/
    private String faxLogRefNo = null;

    /*	Column Info	*/
    private String atchFilePathCtnt = null;

    /*	Column Info	*/
    private String emlAtchFileNm = null;

    /*	Column Info	*/
    private String convAtchFilePathCtnt = null;

    /*	Column Info	*/
    private String convEmlAtchFileNm = null;

    /*	Column Info	*/
    private String srKndCd = null;

    /*	Column Info	*/
    private String tmpltParRto = null;

    /*	Column Info	*/
    private String pageNo = null;

    /*	Column Info	*/
    private String spclCgoFlg = null;

    /*	Column Info	*/
    private String excelFlg = null;

    /*	Column Info	*/
    private String xterTeu = null;

    /*	Column Info	*/
    private String xterRqstStsOfcCd = null;

    /*	Column Info	*/
    private String xterRqstStsUsrId = null;

    /*	Column Info	*/
    private String xterRqstStsUsrNm = null;

    /*	Column Info	*/
    private String xterRqstStsUpdDt = null;

    /*	Column Info	*/
    private String xterRqstStsCd = null;

    /*	Column Info	*/
    private String obSrepCd = null;

    /*	Column Info	*/
    private String pctlExptFlg = null;

    /*	Column Info	*/
    private String bkgBlckFlg = null;

    /*	Column Info	*/
    private String otherFlag = null;

    /*	Column Info	*/
    private String blNoCtnt = null;

    /*	Column Info	*/
    private String sysUpldFlg = null;

    /*	Column Info	*/
    private String siAudFlg = null;

    /*	Column Info	*/
    private String vgmFlg = null;

    /*	Column Info	*/
    private String itrFlg = null;

    /*	Column Info	*/
    private String gtnFlg = null;

    /*	Column Info	*/
    private String csmFlg = null;

    /*	Column Info	*/
    private String ultiNewAsiaCustFlg = null;

    /*	Column Info	*/
    private String ultiTrnsCustFlg = null;

    /* Column Info */
    private String bagDg = null;

    /* Column Info */
    private String nonRtStsCd = null;

    /* Column Info */
    private String cntrTpszCd = null;

    /* Column Info */
    private String cmdtNm = null;

    /* Column Info */
    private String cmdtCd = null;

    /* Column Info */
    private String xterRmk = null;

    /* Column Info */
    private String ctrtNo = null;

    /* Column Info */
    private String ctrtNm = null;

    /* hashColumnInpo */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /* hashFildInpo	*/
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    /**	Constructor	*/
    public ExternalRqstListVO() {
    }

    public ExternalRqstListVO(String vslCd, String bkgStsCd, String xterDelNm, String rowCount, String cntcEml, String rqstAcptDesc, String xterPodCd, String bkgUpldStsCd, String xterBkgRqstStsCd, String docTpCd, String hndlOfcCd, String pagerows, String xterPorNm, String xterDelCd, String xterPolCd, String ibflag, String vslEngNm, String xterPorCd, String xterRqstAcptUsrId, String shNm, String xterRqstViaCd, String upldDt, String xterSndrId, String upldUsrId, String rqstDt, String rqstGmtDt, String xterRqstAcptUsrNm, String snaccsSplitNo, String origin, String skdVoyNo, String rqstDepDt, String ffNm, String xterPolNm, String vvd, String upldUsrNm, String ofcCd, String poNo, String bkgNo, String bkgNoCheck, String xterPodNm, String xterRqstSeq, String dispXterRqstSeq, String xterRqstNo, String delivery, String rowNum, String cnNm, String xterRjctRsnNm, String rjctRsnRmk, String xterPndRsnNm, String custRefNo, String xterRqstRvisSeq, String slanCd, String blDocInpFlg, String blFntOfcFlg, String splitStsCd, String xptRefNo, String faxLogRefNo, String atchFilePathCtnt, String emlAtchFileNm, String convAtchFilePathCtnt, String convEmlAtchFileNm, String srKndCd, String tmpltParRto, String pageNo, String spclCgoFlg, String excelFlg, String xterTeu, String xterRqstStsOfcCd, String xterRqstStsUsrId, String xterRqstStsUsrNm, String xterRqstStsUpdDt, String xterRqstStsCd, String obSrepCd, String pctlExptFlg, String bkgBlckFlg, String otherFlag, String blNoCtnt, String sysUpldFlg, String siAudFlg, String vgmFlg, String itrFlg, String gtnFlg, String csmFlg, String ultiNewAsiaCustFlg, String ultiTrnsCustFlg, String bagDg, String nonRtStsCd, String cntrTpszCd, String cmdtNm, String cmdtCd, String xterRmk, String ctrtNo, String ctrtNm) {
        this.vslCd = vslCd;
        this.bkgStsCd = bkgStsCd;
        this.xterDelNm = xterDelNm;
        this.rowCount = rowCount;
        this.cntcEml = cntcEml;
        this.rqstAcptDesc = rqstAcptDesc;
        this.xterPodCd = xterPodCd;
        this.bkgUpldStsCd = bkgUpldStsCd;
        this.xterBkgRqstStsCd = xterBkgRqstStsCd;
        this.docTpCd = docTpCd;
        this.hndlOfcCd = hndlOfcCd;
        this.pagerows = pagerows;
        this.xterPorNm = xterPorNm;
        this.xterDelCd = xterDelCd;
        this.xterPolCd = xterPolCd;
        this.ibflag = ibflag;
        this.vslEngNm = vslEngNm;
        this.xterPorCd = xterPorCd;
        this.xterRqstAcptUsrId = xterRqstAcptUsrId;
        this.shNm = shNm;
        this.xterRqstViaCd = xterRqstViaCd;
        this.upldDt = upldDt;
        this.xterSndrId = xterSndrId;
        this.upldUsrId = upldUsrId;
        this.rqstDt = rqstDt;
        this.rqstGmtDt = rqstGmtDt;
        this.xterRqstAcptUsrNm = xterRqstAcptUsrNm;
        this.snaccsSplitNo = snaccsSplitNo;
        this.origin = origin;
        this.skdVoyNo = skdVoyNo;
        this.rqstDepDt = rqstDepDt;
        this.ffNm = ffNm;
        this.xterPolNm = xterPolNm;
        this.vvd = vvd;
        this.upldUsrNm = upldUsrNm;
        this.ofcCd = ofcCd;
        this.poNo = poNo;
        this.bkgNo = bkgNo;
        this.bkgNoCheck = bkgNoCheck;
        this.xterPodNm = xterPodNm;
        this.xterRqstSeq = xterRqstSeq;
        this.dispXterRqstSeq = dispXterRqstSeq;
        this.xterRqstNo = xterRqstNo;
        this.delivery = delivery;
        this.rowNum = rowNum;
        this.cnNm = cnNm;
        this.xterRjctRsnNm = xterRjctRsnNm;
        this.rjctRsnRmk = rjctRsnRmk;
        this.xterPndRsnNm = xterPndRsnNm;
        this.custRefNo = custRefNo;
        this.xterRqstRvisSeq = xterRqstRvisSeq;
        this.slanCd = slanCd;
        this.blDocInpFlg = blDocInpFlg;
        this.blFntOfcFlg = blFntOfcFlg;
        this.splitStsCd = splitStsCd;
        this.xptRefNo = xptRefNo;
        this.faxLogRefNo = faxLogRefNo;
        this.atchFilePathCtnt = atchFilePathCtnt;
        this.emlAtchFileNm = emlAtchFileNm;
        this.convAtchFilePathCtnt = convAtchFilePathCtnt;
        this.convEmlAtchFileNm = convEmlAtchFileNm;
        this.srKndCd = srKndCd;
        this.tmpltParRto = tmpltParRto;
        this.pageNo = pageNo;
        this.spclCgoFlg = spclCgoFlg;
        this.excelFlg = excelFlg;
        this.xterTeu = xterTeu;
        this.xterRqstStsOfcCd = xterRqstStsOfcCd;
        this.xterRqstStsUsrId = xterRqstStsUsrId;
        this.xterRqstStsUsrNm = xterRqstStsUsrNm;
        this.xterRqstStsUpdDt = xterRqstStsUpdDt;
        this.xterRqstStsCd = xterRqstStsCd;
        this.obSrepCd = obSrepCd;
        this.pctlExptFlg = pctlExptFlg;
        this.bkgBlckFlg = bkgBlckFlg;
        this.otherFlag = otherFlag;
        this.blNoCtnt = blNoCtnt;
        this.sysUpldFlg = sysUpldFlg;
        this.siAudFlg = siAudFlg;
        this.vgmFlg = vgmFlg;
        this.itrFlg = itrFlg;
        this.gtnFlg = gtnFlg;
        this.csmFlg = csmFlg;
        this.ultiNewAsiaCustFlg = ultiNewAsiaCustFlg;
        this.ultiTrnsCustFlg = ultiTrnsCustFlg;
        this.bagDg = bagDg;
        this.nonRtStsCd = nonRtStsCd;
        this.cntrTpszCd = cntrTpszCd;
        this.cmdtNm = cmdtNm;
        this.cmdtCd = cmdtCd;
        this.xterRmk = xterRmk;
        this.ctrtNo = ctrtNo;
        this.ctrtNm = ctrtNm;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
        this.hashColumns.put("xter_del_nm", getXterDelNm());
        this.hashColumns.put("row_count", getRowCount());
        this.hashColumns.put("cntc_eml", getCntcEml());
        this.hashColumns.put("rqst_acpt_desc", getRqstAcptDesc());
        this.hashColumns.put("xter_pod_cd", getXterPodCd());
        this.hashColumns.put("bkg_upld_sts_cd", getBkgUpldStsCd());
        this.hashColumns.put("xter_bkg_rqst_sts_cd", getXterBkgRqstStsCd());
        this.hashColumns.put("doc_tp_cd", getDocTpCd());
        this.hashColumns.put("hndl_ofc_cd", getHndlOfcCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("xter_por_nm", getXterPorNm());
        this.hashColumns.put("xter_del_cd", getXterDelCd());
        this.hashColumns.put("xter_pol_cd", getXterPolCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("vsl_eng_nm", getVslEngNm());
        this.hashColumns.put("xter_por_cd", getXterPorCd());
        this.hashColumns.put("xter_rqst_acpt_usr_id", getXterRqstAcptUsrId());
        this.hashColumns.put("sh_nm", getShNm());
        this.hashColumns.put("xter_rqst_via_cd", getXterRqstViaCd());
        this.hashColumns.put("upld_dt", getUpldDt());
        this.hashColumns.put("xter_sndr_id", getXterSndrId());
        this.hashColumns.put("upld_usr_id", getUpldUsrId());
        this.hashColumns.put("rqst_dt", getRqstDt());
        this.hashColumns.put("rqst_gmt_dt", getRqstGmtDt());
        this.hashColumns.put("xter_rqst_acpt_usr_nm", getXterRqstAcptUsrNm());
        this.hashColumns.put("snaccs_split_no", getSnaccsSplitNo());
        this.hashColumns.put("origin", getOrigin());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("rqst_dep_dt", getRqstDepDt());
        this.hashColumns.put("ff_nm", getFfNm());
        this.hashColumns.put("xter_pol_nm", getXterPolNm());
        this.hashColumns.put("vvd", getVvd());
        this.hashColumns.put("upld_usr_nm", getUpldUsrNm());
        this.hashColumns.put("ofc_cd", getOfcCd());
        this.hashColumns.put("po_no", getPoNo());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("bkg_no_check", getBkgNoCheck());
        this.hashColumns.put("xter_pod_nm", getXterPodNm());
        this.hashColumns.put("xter_rqst_seq", getXterRqstSeq());
        this.hashColumns.put("disp_xter_rqst_seq", getDispXterRqstSeq());
        this.hashColumns.put("xter_rqst_no", getXterRqstNo());
        this.hashColumns.put("delivery", getDelivery());
        this.hashColumns.put("row_num", getRowNum());
        this.hashColumns.put("cn_nm", getCnNm());
        this.hashColumns.put("xter_rjct_rsn_nm", getXterRjctRsnNm());
        this.hashColumns.put("rjct_rsn_rmk", getRjctRsnRmk());
        this.hashColumns.put("xter_pnd_rsn_nm", getXterPndRsnNm());
        this.hashColumns.put("cust_ref_no", getCustRefNo());
        this.hashColumns.put("xter_rqst_rvis_seq", getXterRqstRvisSeq());
        this.hashColumns.put("slan_cd", getSlanCd());
        this.hashColumns.put("bl_doc_inp_flg", getBlDocInpFlg());
        this.hashColumns.put("bl_fnt_ofc_flg", getBlFntOfcFlg());
        this.hashColumns.put("split_sts_cd", getSplitStsCd());
        this.hashColumns.put("xpt_ref_no", getXptRefNo());
        this.hashColumns.put("fax_log_ref_no", getFaxLogRefNo());
        this.hashColumns.put("atch_file_path_ctnt", getAtchFilePathCtnt());
        this.hashColumns.put("eml_atch_file_nm", getEmlAtchFileNm());
        this.hashColumns.put("conv_atch_file_path_ctnt", getConvAtchFilePathCtnt());
        this.hashColumns.put("conv_eml_atch_file_nm", getConvEmlAtchFileNm());
        this.hashColumns.put("sr_knd_cd", getSrKndCd());
        this.hashColumns.put("tmplt_par_rto", getTmpltParRto());
        this.hashColumns.put("page_no", getPageNo());
        this.hashColumns.put("spcl_cgo_flg", getSpclCgoFlg());
        this.hashColumns.put("excel_flg", getExcelFlg());
        this.hashColumns.put("xter_teu", getXterTeu());
        this.hashColumns.put("xter_rqst_sts_ofc_cd", getXterRqstStsOfcCd());
        this.hashColumns.put("xter_rqst_sts_usr_id", getXterRqstStsUsrId());
        this.hashColumns.put("xter_rqst_sts_usr_nm", getXterRqstStsUsrNm());
        this.hashColumns.put("xter_rqst_sts_upd_dt", getXterRqstStsUpdDt());
        this.hashColumns.put("xter_rqst_sts_cd", getXterRqstStsCd());
        this.hashColumns.put("ob_srep_cd", getObSrepCd());
        this.hashColumns.put("pctl_expt_flg", getPctlExptFlg());
        this.hashColumns.put("bkg_blck_flg", getBkgBlckFlg());
        this.hashColumns.put("other_flag", getOtherFlag());
        this.hashColumns.put("bl_no_ctnt", getBlNoCtnt());
        this.hashColumns.put("sys_upld_flg", getSysUpldFlg());
        this.hashColumns.put("si_aud_flg", getSiAudFlg());
        this.hashColumns.put("vgm_flg", getVgmFlg());
        this.hashColumns.put("itr_flg", getItrFlg());
        this.hashColumns.put("gtn_flg", getGtnFlg());
        this.hashColumns.put("csm_flg", getCsmFlg());
        this.hashColumns.put("ulti_new_asia_cust_flg", getUltiNewAsiaCustFlg());
        this.hashColumns.put("ulti_trns_cust_flg", getUltiTrnsCustFlg());
        this.hashColumns.put("bag_dg", getBagDg());
        this.hashColumns.put("non_rt_sts_cd", getNonRtStsCd());
        this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
        this.hashColumns.put("cmdt_nm", getCmdtNm());
        this.hashColumns.put("cmdt_cd", getCmdtCd());
        this.hashColumns.put("xter_rmk", getXterRmk());
        this.hashColumns.put("ctrt_no", getCtrtNo());
        this.hashColumns.put("ctrt_nm", getCtrtNm());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("bkg_sts_cd", "bkgStsCd");
        this.hashFields.put("xter_del_nm", "xterDelNm");
        this.hashFields.put("row_count", "rowCount");
        this.hashFields.put("cntc_eml", "cntcEml");
        this.hashFields.put("rqst_acpt_desc", "rqstAcptDesc");
        this.hashFields.put("xter_pod_cd", "xterPodCd");
        this.hashFields.put("bkg_upld_sts_cd", "bkgUpldStsCd");
        this.hashFields.put("xter_bkg_rqst_sts_cd", "xterBkgRqstStsCd");
        this.hashFields.put("doc_tp_cd", "docTpCd");
        this.hashFields.put("hndl_ofc_cd", "hndlOfcCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("xter_por_nm", "xterPorNm");
        this.hashFields.put("xter_del_cd", "xterDelCd");
        this.hashFields.put("xter_pol_cd", "xterPolCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("vsl_eng_nm", "vslEngNm");
        this.hashFields.put("xter_por_cd", "xterPorCd");
        this.hashFields.put("xter_rqst_acpt_usr_id", "xterRqstAcptUsrId");
        this.hashFields.put("sh_nm", "shNm");
        this.hashFields.put("xter_rqst_via_cd", "xterRqstViaCd");
        this.hashFields.put("upld_dt", "upldDt");
        this.hashFields.put("xter_sndr_id", "xterSndrId");
        this.hashFields.put("upld_usr_id", "upldUsrId");
        this.hashFields.put("rqst_dt", "rqstDt");
        this.hashFields.put("rqst_gmt_dt", "rqstGmtDt");
        this.hashFields.put("xter_rqst_acpt_usr_nm", "xterRqstAcptUsrNm");
        this.hashFields.put("snaccs_split_no", "snaccsSplitNo");
        this.hashFields.put("origin", "origin");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("rqst_dep_dt", "rqstDepDt");
        this.hashFields.put("ff_nm", "ffNm");
        this.hashFields.put("xter_pol_nm", "xterPolNm");
        this.hashFields.put("vvd", "vvd");
        this.hashFields.put("upld_usr_nm", "upldUsrNm");
        this.hashFields.put("ofc_cd", "ofcCd");
        this.hashFields.put("po_no", "poNo");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("bkg_no_check", "bkgNoCheck");
        this.hashFields.put("xter_pod_nm", "xterPodNm");
        this.hashFields.put("xter_rqst_seq", "xterRqstSeq");
        this.hashFields.put("disp_xter_rqst_seq", "dispXterRqstSeq");
        this.hashFields.put("xter_rqst_no", "xterRqstNo");
        this.hashFields.put("delivery", "delivery");
        this.hashFields.put("row_num", "rowNum");
        this.hashFields.put("cn_nm", "cnNm");
        this.hashFields.put("xter_rjct_rsn_nm", "xterRjctRsnNm");
        this.hashFields.put("rjct_rsn_rmk", "rjctRsnRmk");
        this.hashFields.put("xter_pnd_rsn_nm", "xterPndRsnNm");
        this.hashFields.put("cust_ref_no", "custRefNo");
        this.hashFields.put("xter_rqst_rvis_seq", "xterRqstRvisSeq");
        this.hashFields.put("slan_cd", "slanCd");
        this.hashFields.put("bl_doc_inp_flg", "blDocInpFlg");
        this.hashFields.put("bl_fnt_ofc_flg", "blFntOfcFlg");
        this.hashFields.put("split_sts_cd", "splitStsCd");
        this.hashFields.put("xpt_ref_no", "xptRefNo");
        this.hashFields.put("fax_log_ref_no", "faxLogRefNo");
        this.hashFields.put("atch_file_path_ctnt", "atchFilePathCtnt");
        this.hashFields.put("eml_atch_file_nm", "emlAtchFileNm");
        this.hashFields.put("conv_atch_file_path_ctnt", "convAtchFilePathCtnt");
        this.hashFields.put("conv_eml_atch_file_nm", "convEmlAtchFileNm");
        this.hashFields.put("sr_knd_cd", "srKndCd");
        this.hashFields.put("tmplt_par_rto", "tmpltParRto");
        this.hashFields.put("page_no", "pageNo");
        this.hashFields.put("spcl_cgo_flg", "spclCgoFlg");
        this.hashFields.put("excel_flg", "excelFlg");
        this.hashFields.put("xter_teu", "xterTeu");
        this.hashFields.put("xter_rqst_sts_ofc_cd", "xterRqstStsOfcCd");
        this.hashFields.put("xter_rqst_sts_usr_id", "xterRqstStsUsrId");
        this.hashFields.put("xter_rqst_sts_usr_nm", "xterRqstStsUsrNm");
        this.hashFields.put("xter_rqst_sts_upd_dt", "xterRqstStsUpdDt");
        this.hashFields.put("xter_rqst_sts_cd", "xterRqstStsCd");
        this.hashFields.put("ob_srep_cd", "obSrepCd");
        this.hashFields.put("pctl_expt_flg", "pctlExptFlg");
        this.hashFields.put("bkg_blck_flg", "bkgBlckFlg");
        this.hashFields.put("other_flag", "otherFlag");
        this.hashFields.put("bl_no_ctnt", "blNoCtnt");
        this.hashFields.put("sys_upld_flg", "sysUpldFlg");
        this.hashFields.put("si_aud_flg", "siAudFlg");
        this.hashFields.put("vgm_flg", "vgmFlg");
        this.hashFields.put("itr_flg", "itrFlg");
        this.hashFields.put("gtn_flg", "gtnFlg");
        this.hashFields.put("csm_flg", "csmFlg");
        this.hashFields.put("ulti_new_asia_cust_flg", "ultiNewAsiaCustFlg");
        this.hashFields.put("ulti_trns_cust_flg", "ultiTrnsCustFlg");
        this.hashFields.put("bag_dg", "bagDg");
        this.hashFields.put("non_rt_sts_cd", "nonRtStsCd");
        this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
        this.hashFields.put("cmdt_nm", "cmdtNm");
        this.hashFields.put("cmdt_cd", "cmdtCd");
        this.hashFields.put("xter_rmk", "xterRmk");
        this.hashFields.put("ctrt_no", "ctrtNo");
        this.hashFields.put("ctrt_nm", "ctrtNm");
        return this.hashFields;
    }

    //	Getters	and	Setters
    /**
	* Column Info
	* @param  vslCd
	*/
    public void setVslCd(String vslCd) {
        this.vslCd = vslCd;
    }

    /**
	 * Column Info
	 * @return	vslCd
	 */
    public String getVslCd() {
        return this.vslCd;
    }

    /**
	* Column Info
	* @param  bkgStsCd
	*/
    public void setBkgStsCd(String bkgStsCd) {
        this.bkgStsCd = bkgStsCd;
    }

    /**
	 * Column Info
	 * @return	bkgStsCd
	 */
    public String getBkgStsCd() {
        return this.bkgStsCd;
    }

    /**
	* Column Info
	* @param  xterDelNm
	*/
    public void setXterDelNm(String xterDelNm) {
        this.xterDelNm = xterDelNm;
    }

    /**
	 * Column Info
	 * @return	xterDelNm
	 */
    public String getXterDelNm() {
        return this.xterDelNm;
    }

    /**
	* Column Info
	* @param  rowCount
	*/
    public void setRowCount(String rowCount) {
        this.rowCount = rowCount;
    }

    /**
	 * Column Info
	 * @return	rowCount
	 */
    public String getRowCount() {
        return this.rowCount;
    }

    /**
	* Column Info
	* @param  cntcEml
	*/
    public void setCntcEml(String cntcEml) {
        this.cntcEml = cntcEml;
    }

    /**
	 * Column Info
	 * @return	cntcEml
	 */
    public String getCntcEml() {
        return this.cntcEml;
    }

    /**
	* Column Info
	* @param  rqstAcptDesc
	*/
    public void setRqstAcptDesc(String rqstAcptDesc) {
        this.rqstAcptDesc = rqstAcptDesc;
    }

    /**
	 * Column Info
	 * @return	rqstAcptDesc
	 */
    public String getRqstAcptDesc() {
        return this.rqstAcptDesc;
    }

    /**
	* Column Info
	* @param  xterPodCd
	*/
    public void setXterPodCd(String xterPodCd) {
        this.xterPodCd = xterPodCd;
    }

    /**
	 * Column Info
	 * @return	xterPodCd
	 */
    public String getXterPodCd() {
        return this.xterPodCd;
    }

    /**
	* Column Info
	* @param  bkgUpldStsCd
	*/
    public void setBkgUpldStsCd(String bkgUpldStsCd) {
        this.bkgUpldStsCd = bkgUpldStsCd;
    }

    /**
	 * Column Info
	 * @return	bkgUpldStsCd
	 */
    public String getBkgUpldStsCd() {
        return this.bkgUpldStsCd;
    }

    /**
	* Column Info
	* @param  xterBkgRqstStsCd
	*/
    public void setXterBkgRqstStsCd(String xterBkgRqstStsCd) {
        this.xterBkgRqstStsCd = xterBkgRqstStsCd;
    }

    /**
	 * Column Info
	 * @return	xterBkgRqstStsCd
	 */
    public String getXterBkgRqstStsCd() {
        return this.xterBkgRqstStsCd;
    }

    /**
	* Column Info
	* @param  docTpCd
	*/
    public void setDocTpCd(String docTpCd) {
        this.docTpCd = docTpCd;
    }

    /**
	 * Column Info
	 * @return	docTpCd
	 */
    public String getDocTpCd() {
        return this.docTpCd;
    }

    /**
	* Column Info
	* @param  hndlOfcCd
	*/
    public void setHndlOfcCd(String hndlOfcCd) {
        this.hndlOfcCd = hndlOfcCd;
    }

    /**
	 * Column Info
	 * @return	hndlOfcCd
	 */
    public String getHndlOfcCd() {
        return this.hndlOfcCd;
    }

    /**
	* Column Info
	* @param  pagerows
	*/
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    /**
	 * Column Info
	 * @return	pagerows
	 */
    public String getPagerows() {
        return this.pagerows;
    }

    /**
	* Column Info
	* @param  xterPorNm
	*/
    public void setXterPorNm(String xterPorNm) {
        this.xterPorNm = xterPorNm;
    }

    /**
	 * Column Info
	 * @return	xterPorNm
	 */
    public String getXterPorNm() {
        return this.xterPorNm;
    }

    /**
	* Column Info
	* @param  xterDelCd
	*/
    public void setXterDelCd(String xterDelCd) {
        this.xterDelCd = xterDelCd;
    }

    /**
	 * Column Info
	 * @return	xterDelCd
	 */
    public String getXterDelCd() {
        return this.xterDelCd;
    }

    /**
	* Column Info
	* @param  xterPolCd
	*/
    public void setXterPolCd(String xterPolCd) {
        this.xterPolCd = xterPolCd;
    }

    /**
	 * Column Info
	 * @return	xterPolCd
	 */
    public String getXterPolCd() {
        return this.xterPolCd;
    }

    /**
	* Column Info
	* @param  ibflag
	*/
    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
    }

    /**
	 * Column Info
	 * @return	ibflag
	 */
    public String getIbflag() {
        return this.ibflag;
    }

    /**
	* Column Info
	* @param  vslEngNm
	*/
    public void setVslEngNm(String vslEngNm) {
        this.vslEngNm = vslEngNm;
    }

    /**
	 * Column Info
	 * @return	vslEngNm
	 */
    public String getVslEngNm() {
        return this.vslEngNm;
    }

    /**
	* Column Info
	* @param  xterPorCd
	*/
    public void setXterPorCd(String xterPorCd) {
        this.xterPorCd = xterPorCd;
    }

    /**
	 * Column Info
	 * @return	xterPorCd
	 */
    public String getXterPorCd() {
        return this.xterPorCd;
    }

    /**
	* Column Info
	* @param  xterRqstAcptUsrId
	*/
    public void setXterRqstAcptUsrId(String xterRqstAcptUsrId) {
        this.xterRqstAcptUsrId = xterRqstAcptUsrId;
    }

    /**
	 * Column Info
	 * @return	xterRqstAcptUsrId
	 */
    public String getXterRqstAcptUsrId() {
        return this.xterRqstAcptUsrId;
    }

    /**
	* Column Info
	* @param  shNm
	*/
    public void setShNm(String shNm) {
        this.shNm = shNm;
    }

    /**
	 * Column Info
	 * @return	shNm
	 */
    public String getShNm() {
        return this.shNm;
    }

    /**
	* Column Info
	* @param  xterRqstViaCd
	*/
    public void setXterRqstViaCd(String xterRqstViaCd) {
        this.xterRqstViaCd = xterRqstViaCd;
    }

    /**
	 * Column Info
	 * @return	xterRqstViaCd
	 */
    public String getXterRqstViaCd() {
        return this.xterRqstViaCd;
    }

    /**
	* Column Info
	* @param  upldDt
	*/
    public void setUpldDt(String upldDt) {
        this.upldDt = upldDt;
    }

    /**
	 * Column Info
	 * @return	upldDt
	 */
    public String getUpldDt() {
        return this.upldDt;
    }

    /**
	* Column Info
	* @param  xterSndrId
	*/
    public void setXterSndrId(String xterSndrId) {
        this.xterSndrId = xterSndrId;
    }

    /**
	 * Column Info
	 * @return	xterSndrId
	 */
    public String getXterSndrId() {
        return this.xterSndrId;
    }

    /**
	* Column Info
	* @param  upldUsrId
	*/
    public void setUpldUsrId(String upldUsrId) {
        this.upldUsrId = upldUsrId;
    }

    /**
	 * Column Info
	 * @return	upldUsrId
	 */
    public String getUpldUsrId() {
        return this.upldUsrId;
    }

    /**
	* Column Info
	* @param  rqstDt
	*/
    public void setRqstDt(String rqstDt) {
        this.rqstDt = rqstDt;
    }

    /**
	 * Column Info
	 * @return	rqstDt
	 */
    public String getRqstDt() {
        return this.rqstDt;
    }

    /**
	* Column Info
	* @param  rqstGmtDt
	*/
    public void setRqstGmtDt(String rqstGmtDt) {
        this.rqstGmtDt = rqstGmtDt;
    }

    /**
	 * Column Info
	 * @return	rqstGmtDt
	 */
    public String getRqstGmtDt() {
        return this.rqstGmtDt;
    }

    /**
	* Column Info
	* @param  xterRqstAcptUsrNm
	*/
    public void setXterRqstAcptUsrNm(String xterRqstAcptUsrNm) {
        this.xterRqstAcptUsrNm = xterRqstAcptUsrNm;
    }

    /**
	 * Column Info
	 * @return	xterRqstAcptUsrNm
	 */
    public String getXterRqstAcptUsrNm() {
        return this.xterRqstAcptUsrNm;
    }

    /**
	* Column Info
	* @param  snaccsSplitNo
	*/
    public void setSnaccsSplitNo(String snaccsSplitNo) {
        this.snaccsSplitNo = snaccsSplitNo;
    }

    /**
	 * Column Info
	 * @return	snaccsSplitNo
	 */
    public String getSnaccsSplitNo() {
        return this.snaccsSplitNo;
    }

    /**
	* Column Info
	* @param  origin
	*/
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
	 * Column Info
	 * @return	origin
	 */
    public String getOrigin() {
        return this.origin;
    }

    /**
	* Column Info
	* @param  skdVoyNo
	*/
    public void setSkdVoyNo(String skdVoyNo) {
        this.skdVoyNo = skdVoyNo;
    }

    /**
	 * Column Info
	 * @return	skdVoyNo
	 */
    public String getSkdVoyNo() {
        return this.skdVoyNo;
    }

    /**
	* Column Info
	* @param  rqstDepDt
	*/
    public void setRqstDepDt(String rqstDepDt) {
        this.rqstDepDt = rqstDepDt;
    }

    /**
	 * Column Info
	 * @return	rqstDepDt
	 */
    public String getRqstDepDt() {
        return this.rqstDepDt;
    }

    /**
	* Column Info
	* @param  ffNm
	*/
    public void setFfNm(String ffNm) {
        this.ffNm = ffNm;
    }

    /**
	 * Column Info
	 * @return	ffNm
	 */
    public String getFfNm() {
        return this.ffNm;
    }

    /**
	* Column Info
	* @param  xterPolNm
	*/
    public void setXterPolNm(String xterPolNm) {
        this.xterPolNm = xterPolNm;
    }

    /**
	 * Column Info
	 * @return	xterPolNm
	 */
    public String getXterPolNm() {
        return this.xterPolNm;
    }

    /**
	* Column Info
	* @param  vvd
	*/
    public void setVvd(String vvd) {
        this.vvd = vvd;
    }

    /**
	 * Column Info
	 * @return	vvd
	 */
    public String getVvd() {
        return this.vvd;
    }

    /**
	* Column Info
	* @param  upldUsrNm
	*/
    public void setUpldUsrNm(String upldUsrNm) {
        this.upldUsrNm = upldUsrNm;
    }

    /**
	 * Column Info
	 * @return	upldUsrNm
	 */
    public String getUpldUsrNm() {
        return this.upldUsrNm;
    }

    /**
	* Column Info
	* @param  ofcCd
	*/
    public void setOfcCd(String ofcCd) {
        this.ofcCd = ofcCd;
    }

    /**
	 * Column Info
	 * @return	ofcCd
	 */
    public String getOfcCd() {
        return this.ofcCd;
    }

    /**
	* Column Info
	* @param  poNo
	*/
    public void setPoNo(String poNo) {
        this.poNo = poNo;
    }

    /**
	 * Column Info
	 * @return	poNo
	 */
    public String getPoNo() {
        return this.poNo;
    }

    /**
	* Column Info
	* @param  bkgNo
	*/
    public void setBkgNo(String bkgNo) {
        this.bkgNo = bkgNo;
    }

    /**
	 * Column Info
	 * @return	bkgNo
	 */
    public String getBkgNo() {
        return this.bkgNo;
    }

    /**
	* Column Info
	* @param  bkgNoCheck
	*/
    public void setBkgNoCheck(String bkgNoCheck) {
        this.bkgNoCheck = bkgNoCheck;
    }

    /**
	 * Column Info
	 * @return	bkgNoCheck
	 */
    public String getBkgNoCheck() {
        return this.bkgNoCheck;
    }

    /**
	* Column Info
	* @param  xterPodNm
	*/
    public void setXterPodNm(String xterPodNm) {
        this.xterPodNm = xterPodNm;
    }

    /**
	 * Column Info
	 * @return	xterPodNm
	 */
    public String getXterPodNm() {
        return this.xterPodNm;
    }

    /**
	* Column Info
	* @param  xterRqstSeq
	*/
    public void setXterRqstSeq(String xterRqstSeq) {
        this.xterRqstSeq = xterRqstSeq;
    }

    /**
	 * Column Info
	 * @return	xterRqstSeq
	 */
    public String getXterRqstSeq() {
        return this.xterRqstSeq;
    }

    /**
	* Column Info
	* @param  dispXterRqstSeq
	*/
    public void setDispXterRqstSeq(String dispXterRqstSeq) {
        this.dispXterRqstSeq = dispXterRqstSeq;
    }

    /**
	 * Column Info
	 * @return	dispXterRqstSeq
	 */
    public String getDispXterRqstSeq() {
        return this.dispXterRqstSeq;
    }

    /**
	* Column Info
	* @param  xterRqstNo
	*/
    public void setXterRqstNo(String xterRqstNo) {
        this.xterRqstNo = xterRqstNo;
    }

    /**
	 * Column Info
	 * @return	xterRqstNo
	 */
    public String getXterRqstNo() {
        return this.xterRqstNo;
    }

    /**
	* Column Info
	* @param  delivery
	*/
    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    /**
	 * Column Info
	 * @return	delivery
	 */
    public String getDelivery() {
        return this.delivery;
    }

    /**
	* Column Info
	* @param  rowNum
	*/
    public void setRowNum(String rowNum) {
        this.rowNum = rowNum;
    }

    /**
	 * Column Info
	 * @return	rowNum
	 */
    public String getRowNum() {
        return this.rowNum;
    }

    /**
	* Column Info
	* @param  cnNm
	*/
    public void setCnNm(String cnNm) {
        this.cnNm = cnNm;
    }

    /**
	 * Column Info
	 * @return	cnNm
	 */
    public String getCnNm() {
        return this.cnNm;
    }

    /**
	* Column Info
	* @param  xterRjctRsnNm
	*/
    public void setXterRjctRsnNm(String xterRjctRsnNm) {
        this.xterRjctRsnNm = xterRjctRsnNm;
    }

    /**
	 * Column Info
	 * @return	xterRjctRsnNm
	 */
    public String getXterRjctRsnNm() {
        return this.xterRjctRsnNm;
    }

    /**
	* Column Info
	* @param  rjctRsnRmk
	*/
    public void setRjctRsnRmk(String rjctRsnRmk) {
        this.rjctRsnRmk = rjctRsnRmk;
    }

    /**
	 * Column Info
	 * @return	rjctRsnRmk
	 */
    public String getRjctRsnRmk() {
        return this.rjctRsnRmk;
    }

    /**
	* Column Info
	* @param  xterPndRsnNm
	*/
    public void setXterPndRsnNm(String xterPndRsnNm) {
        this.xterPndRsnNm = xterPndRsnNm;
    }

    /**
	 * Column Info
	 * @return	xterPndRsnNm
	 */
    public String getXterPndRsnNm() {
        return this.xterPndRsnNm;
    }

    /**
	* Column Info
	* @param  custRefNo
	*/
    public void setCustRefNo(String custRefNo) {
        this.custRefNo = custRefNo;
    }

    /**
	 * Column Info
	 * @return	custRefNo
	 */
    public String getCustRefNo() {
        return this.custRefNo;
    }

    /**
	* Column Info
	* @param  xterRqstRvisSeq
	*/
    public void setXterRqstRvisSeq(String xterRqstRvisSeq) {
        this.xterRqstRvisSeq = xterRqstRvisSeq;
    }

    /**
	 * Column Info
	 * @return	xterRqstRvisSeq
	 */
    public String getXterRqstRvisSeq() {
        return this.xterRqstRvisSeq;
    }

    /**
	* Column Info
	* @param  slanCd
	*/
    public void setSlanCd(String slanCd) {
        this.slanCd = slanCd;
    }

    /**
	 * Column Info
	 * @return	slanCd
	 */
    public String getSlanCd() {
        return this.slanCd;
    }

    /**
	* Column Info
	* @param  blDocInpFlg
	*/
    public void setBlDocInpFlg(String blDocInpFlg) {
        this.blDocInpFlg = blDocInpFlg;
    }

    /**
	 * Column Info
	 * @return	blDocInpFlg
	 */
    public String getBlDocInpFlg() {
        return this.blDocInpFlg;
    }

    /**
	* Column Info
	* @param  blFntOfcFlg
	*/
    public void setBlFntOfcFlg(String blFntOfcFlg) {
        this.blFntOfcFlg = blFntOfcFlg;
    }

    /**
	 * Column Info
	 * @return	blFntOfcFlg
	 */
    public String getBlFntOfcFlg() {
        return this.blFntOfcFlg;
    }

    /**
	* Column Info
	* @param  splitStsCd
	*/
    public void setSplitStsCd(String splitStsCd) {
        this.splitStsCd = splitStsCd;
    }

    /**
	 * Column Info
	 * @return	splitStsCd
	 */
    public String getSplitStsCd() {
        return this.splitStsCd;
    }

    /**
	* Column Info
	* @param  xptRefNo
	*/
    public void setXptRefNo(String xptRefNo) {
        this.xptRefNo = xptRefNo;
    }

    /**
	 * Column Info
	 * @return	xptRefNo
	 */
    public String getXptRefNo() {
        return this.xptRefNo;
    }

    /**
	* Column Info
	* @param  faxLogRefNo
	*/
    public void setFaxLogRefNo(String faxLogRefNo) {
        this.faxLogRefNo = faxLogRefNo;
    }

    /**
	 * Column Info
	 * @return	faxLogRefNo
	 */
    public String getFaxLogRefNo() {
        return this.faxLogRefNo;
    }

    /**
	* Column Info
	* @param  atchFilePathCtnt
	*/
    public void setAtchFilePathCtnt(String atchFilePathCtnt) {
        this.atchFilePathCtnt = atchFilePathCtnt;
    }

    /**
	 * Column Info
	 * @return	atchFilePathCtnt
	 */
    public String getAtchFilePathCtnt() {
        return this.atchFilePathCtnt;
    }

    /**
	* Column Info
	* @param  emlAtchFileNm
	*/
    public void setEmlAtchFileNm(String emlAtchFileNm) {
        this.emlAtchFileNm = emlAtchFileNm;
    }

    /**
	 * Column Info
	 * @return	emlAtchFileNm
	 */
    public String getEmlAtchFileNm() {
        return this.emlAtchFileNm;
    }

    /**
	* Column Info
	* @param  convAtchFilePathCtnt
	*/
    public void setConvAtchFilePathCtnt(String convAtchFilePathCtnt) {
        this.convAtchFilePathCtnt = convAtchFilePathCtnt;
    }

    /**
	 * Column Info
	 * @return	convAtchFilePathCtnt
	 */
    public String getConvAtchFilePathCtnt() {
        return this.convAtchFilePathCtnt;
    }

    /**
	* Column Info
	* @param  convEmlAtchFileNm
	*/
    public void setConvEmlAtchFileNm(String convEmlAtchFileNm) {
        this.convEmlAtchFileNm = convEmlAtchFileNm;
    }

    /**
	 * Column Info
	 * @return	convEmlAtchFileNm
	 */
    public String getConvEmlAtchFileNm() {
        return this.convEmlAtchFileNm;
    }

    /**
	* Column Info
	* @param  srKndCd
	*/
    public void setSrKndCd(String srKndCd) {
        this.srKndCd = srKndCd;
    }

    /**
	 * Column Info
	 * @return	srKndCd
	 */
    public String getSrKndCd() {
        return this.srKndCd;
    }

    /**
	* Column Info
	* @param  tmpltParRto
	*/
    public void setTmpltParRto(String tmpltParRto) {
        this.tmpltParRto = tmpltParRto;
    }

    /**
	 * Column Info
	 * @return	tmpltParRto
	 */
    public String getTmpltParRto() {
        return this.tmpltParRto;
    }

    /**
	* Column Info
	* @param  pageNo
	*/
    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    /**
	 * Column Info
	 * @return	pageNo
	 */
    public String getPageNo() {
        return this.pageNo;
    }

    /**
	* Column Info
	* @param  spclCgoFlg
	*/
    public void setSpclCgoFlg(String spclCgoFlg) {
        this.spclCgoFlg = spclCgoFlg;
    }

    /**
	 * Column Info
	 * @return	spclCgoFlg
	 */
    public String getSpclCgoFlg() {
        return this.spclCgoFlg;
    }

    /**
	* Column Info
	* @param  excelFlg
	*/
    public void setExcelFlg(String excelFlg) {
        this.excelFlg = excelFlg;
    }

    /**
	 * Column Info
	 * @return	excelFlg
	 */
    public String getExcelFlg() {
        return this.excelFlg;
    }

    /**
	* Column Info
	* @param  xterTeu
	*/
    public void setXterTeu(String xterTeu) {
        this.xterTeu = xterTeu;
    }

    /**
	 * Column Info
	 * @return	xterTeu
	 */
    public String getXterTeu() {
        return this.xterTeu;
    }

    /**
	* Column Info
	* @param  xterRqstStsOfcCd
	*/
    public void setXterRqstStsOfcCd(String xterRqstStsOfcCd) {
        this.xterRqstStsOfcCd = xterRqstStsOfcCd;
    }

    /**
	 * Column Info
	 * @return	xterRqstStsOfcCd
	 */
    public String getXterRqstStsOfcCd() {
        return this.xterRqstStsOfcCd;
    }

    /**
	* Column Info
	* @param  xterRqstStsUsrId
	*/
    public void setXterRqstStsUsrId(String xterRqstStsUsrId) {
        this.xterRqstStsUsrId = xterRqstStsUsrId;
    }

    /**
	 * Column Info
	 * @return	xterRqstStsUsrId
	 */
    public String getXterRqstStsUsrId() {
        return this.xterRqstStsUsrId;
    }

    /**
	* Column Info
	* @param  xterRqstStsUsrNm
	*/
    public void setXterRqstStsUsrNm(String xterRqstStsUsrNm) {
        this.xterRqstStsUsrNm = xterRqstStsUsrNm;
    }

    /**
	 * Column Info
	 * @return	xterRqstStsUsrNm
	 */
    public String getXterRqstStsUsrNm() {
        return this.xterRqstStsUsrNm;
    }

    /**
	* Column Info
	* @param  xterRqstStsUpdDt
	*/
    public void setXterRqstStsUpdDt(String xterRqstStsUpdDt) {
        this.xterRqstStsUpdDt = xterRqstStsUpdDt;
    }

    /**
	 * Column Info
	 * @return	xterRqstStsUpdDt
	 */
    public String getXterRqstStsUpdDt() {
        return this.xterRqstStsUpdDt;
    }

    /**
	* Column Info
	* @param  xterRqstStsCd
	*/
    public void setXterRqstStsCd(String xterRqstStsCd) {
        this.xterRqstStsCd = xterRqstStsCd;
    }

    /**
	 * Column Info
	 * @return	xterRqstStsCd
	 */
    public String getXterRqstStsCd() {
        return this.xterRqstStsCd;
    }

    /**
	* Column Info
	* @param  obSrepCd
	*/
    public void setObSrepCd(String obSrepCd) {
        this.obSrepCd = obSrepCd;
    }

    /**
	 * Column Info
	 * @return	obSrepCd
	 */
    public String getObSrepCd() {
        return this.obSrepCd;
    }

    /**
	* Column Info
	* @param  pctlExptFlg
	*/
    public void setPctlExptFlg(String pctlExptFlg) {
        this.pctlExptFlg = pctlExptFlg;
    }

    /**
	 * Column Info
	 * @return	pctlExptFlg
	 */
    public String getPctlExptFlg() {
        return this.pctlExptFlg;
    }

    /**
	* Column Info
	* @param  bkgBlckFlg
	*/
    public void setBkgBlckFlg(String bkgBlckFlg) {
        this.bkgBlckFlg = bkgBlckFlg;
    }

    /**
	 * Column Info
	 * @return	bkgBlckFlg
	 */
    public String getBkgBlckFlg() {
        return this.bkgBlckFlg;
    }

    /**
	* Column Info
	* @param  otherFlag
	*/
    public void setOtherFlag(String otherFlag) {
        this.otherFlag = otherFlag;
    }

    /**
	 * Column Info
	 * @return	otherFlag
	 */
    public String getOtherFlag() {
        return this.otherFlag;
    }

    /**
	* Column Info
	* @param  blNoCtnt
	*/
    public void setBlNoCtnt(String blNoCtnt) {
        this.blNoCtnt = blNoCtnt;
    }

    /**
	 * Column Info
	 * @return	blNoCtnt
	 */
    public String getBlNoCtnt() {
        return this.blNoCtnt;
    }

    /**
	* Column Info
	* @param  sysUpldFlg
	*/
    public void setSysUpldFlg(String sysUpldFlg) {
        this.sysUpldFlg = sysUpldFlg;
    }

    /**
	 * Column Info
	 * @return	sysUpldFlg
	 */
    public String getSysUpldFlg() {
        return this.sysUpldFlg;
    }

    /**
	* Column Info
	* @param  siAudFlg
	*/
    public void setSiAudFlg(String siAudFlg) {
        this.siAudFlg = siAudFlg;
    }

    /**
	 * Column Info
	 * @return	siAudFlg
	 */
    public String getSiAudFlg() {
        return this.siAudFlg;
    }

    /**
	* Column Info
	* @param  vgmFlg
	*/
    public void setVgmFlg(String vgmFlg) {
        this.vgmFlg = vgmFlg;
    }

    /**
	 * Column Info
	 * @return	vgmFlg
	 */
    public String getVgmFlg() {
        return this.vgmFlg;
    }

    /**
	* Column Info
	* @param  itrFlg
	*/
    public void setItrFlg(String itrFlg) {
        this.itrFlg = itrFlg;
    }

    /**
	 * Column Info
	 * @return	itrFlg
	 */
    public String getItrFlg() {
        return this.itrFlg;
    }

    /**
	* Column Info
	* @param  gtnFlg
	*/
    public void setGtnFlg(String gtnFlg) {
        this.gtnFlg = gtnFlg;
    }

    /**
	 * Column Info
	 * @return	gtnFlg
	 */
    public String getGtnFlg() {
        return this.gtnFlg;
    }

    /**
	* Column Info
	* @param  csmFlg
	*/
    public void setCsmFlg(String csmFlg) {
        this.csmFlg = csmFlg;
    }

    /**
	 * Column Info
	 * @return	csmFlg
	 */
    public String getCsmFlg() {
        return this.csmFlg;
    }

    /**
	* Column Info
	* @param  ultiNewAsiaCustFlg
	*/
    public void setUltiNewAsiaCustFlg(String ultiNewAsiaCustFlg) {
        this.ultiNewAsiaCustFlg = ultiNewAsiaCustFlg;
    }

    /**
	 * Column Info
	 * @return	ultiNewAsiaCustFlg
	 */
    public String getUltiNewAsiaCustFlg() {
        return this.ultiNewAsiaCustFlg;
    }

    /**
	* Column Info
	* @param  ultiTrnsCustFlg
	*/
    public void setUltiTrnsCustFlg(String ultiTrnsCustFlg) {
        this.ultiTrnsCustFlg = ultiTrnsCustFlg;
    }

    /**
	 * Column Info
	 * @return	ultiTrnsCustFlg
	 */
    public String getUltiTrnsCustFlg() {
        return this.ultiTrnsCustFlg;
    }

    public void setBagDg(String bagDg) {
        this.bagDg = bagDg;
    }

    public String getBagDg() {
        return this.bagDg;
    }

    public void setNonRtStsCd(String nonRtStsCd) {
        this.nonRtStsCd = nonRtStsCd;
    }

    public String getNonRtStsCd() {
        return this.nonRtStsCd;
    }

    public void setCntrTpszCd(String cntrTpszCd) {
        this.cntrTpszCd = cntrTpszCd;
    }

    public String getCntrTpszCd() {
        return this.cntrTpszCd;
    }

    public void setCmdtNm(String cmdtNm) {
        this.cmdtNm = cmdtNm;
    }

    public String getCmdtNm() {
        return this.cmdtNm;
    }

    public void setCmdtCd(String cmdtCd) {
        this.cmdtCd = cmdtCd;
    }

    public String getCmdtCd() {
        return this.cmdtCd;
    }

    public void setXterRmk(String xterRmk) {
        this.xterRmk = xterRmk;
    }

    public String getXterRmk() {
        return this.xterRmk;
    }

    public void setCtrtNo(String ctrtNo) {
        this.ctrtNo = ctrtNo;
    }

    public String getCtrtNo() {
        return this.ctrtNo;
    }

    public void setCtrtNm(String ctrtNm) {
        this.ctrtNm = ctrtNm;
    }

    public String getCtrtNm() {
        return this.ctrtNm;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        fromRequest(request, "");
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request, String prefix) {
        setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
        setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
        setXterDelNm(JSPUtil.getParameter(request, prefix + "xter_del_nm", ""));
        setRowCount(JSPUtil.getParameter(request, prefix + "row_count", ""));
        setCntcEml(JSPUtil.getParameter(request, prefix + "cntc_eml", ""));
        setRqstAcptDesc(JSPUtil.getParameter(request, prefix + "rqst_acpt_desc", ""));
        setXterPodCd(JSPUtil.getParameter(request, prefix + "xter_pod_cd", ""));
        setBkgUpldStsCd(JSPUtil.getParameter(request, prefix + "bkg_upld_sts_cd", ""));
        setXterBkgRqstStsCd(JSPUtil.getParameter(request, prefix + "xter_bkg_rqst_sts_cd", ""));
        setDocTpCd(JSPUtil.getParameter(request, prefix + "doc_tp_cd", ""));
        setHndlOfcCd(JSPUtil.getParameter(request, prefix + "hndl_ofc_cd", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setXterPorNm(JSPUtil.getParameter(request, prefix + "xter_por_nm", ""));
        setXterDelCd(JSPUtil.getParameter(request, prefix + "xter_del_cd", ""));
        setXterPolCd(JSPUtil.getParameter(request, prefix + "xter_pol_cd", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
        setXterPorCd(JSPUtil.getParameter(request, prefix + "xter_por_cd", ""));
        setXterRqstAcptUsrId(JSPUtil.getParameter(request, prefix + "xter_rqst_acpt_usr_id", ""));
        setShNm(JSPUtil.getParameter(request, prefix + "sh_nm", ""));
        setXterRqstViaCd(JSPUtil.getParameter(request, prefix + "xter_rqst_via_cd", ""));
        setUpldDt(JSPUtil.getParameter(request, prefix + "upld_dt", ""));
        setXterSndrId(JSPUtil.getParameter(request, prefix + "xter_sndr_id", ""));
        setUpldUsrId(JSPUtil.getParameter(request, prefix + "upld_usr_id", ""));
        setRqstDt(JSPUtil.getParameter(request, prefix + "rqst_dt", ""));
        setRqstGmtDt(JSPUtil.getParameter(request, prefix + "rqst_gmt_dt", ""));
        setXterRqstAcptUsrNm(JSPUtil.getParameter(request, prefix + "xter_rqst_acpt_usr_nm", ""));
        setSnaccsSplitNo(JSPUtil.getParameter(request, prefix + "snaccs_split_no", ""));
        setOrigin(JSPUtil.getParameter(request, prefix + "origin", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
        setRqstDepDt(JSPUtil.getParameter(request, prefix + "rqst_dep_dt", ""));
        setFfNm(JSPUtil.getParameter(request, prefix + "ff_nm", ""));
        setXterPolNm(JSPUtil.getParameter(request, prefix + "xter_pol_nm", ""));
        setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
        setUpldUsrNm(JSPUtil.getParameter(request, prefix + "upld_usr_nm", ""));
        setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
        setPoNo(JSPUtil.getParameter(request, prefix + "po_no", ""));
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setBkgNoCheck(JSPUtil.getParameter(request, prefix + "bkg_no_check", ""));
        setXterPodNm(JSPUtil.getParameter(request, prefix + "xter_pod_nm", ""));
        setXterRqstSeq(JSPUtil.getParameter(request, prefix + "xter_rqst_seq", ""));
        setDispXterRqstSeq(JSPUtil.getParameter(request, prefix + "disp_xter_rqst_seq", ""));
        setXterRqstNo(JSPUtil.getParameter(request, prefix + "xter_rqst_no", ""));
        setDelivery(JSPUtil.getParameter(request, prefix + "delivery", ""));
        setRowNum(JSPUtil.getParameter(request, prefix + "row_num", ""));
        setCnNm(JSPUtil.getParameter(request, prefix + "cn_nm", ""));
        setXterRjctRsnNm(JSPUtil.getParameter(request, prefix + "xter_rjct_rsn_nm", ""));
        setRjctRsnRmk(JSPUtil.getParameter(request, prefix + "rjct_rsn_rmk", ""));
        setXterPndRsnNm(JSPUtil.getParameter(request, prefix + "xter_pnd_rsn_nm", ""));
        setCustRefNo(JSPUtil.getParameter(request, prefix + "cust_ref_no", ""));
        setXterRqstRvisSeq(JSPUtil.getParameter(request, prefix + "xter_rqst_rvis_seq", ""));
        setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
        setBlDocInpFlg(JSPUtil.getParameter(request, prefix + "bl_doc_inp_flg", ""));
        setBlFntOfcFlg(JSPUtil.getParameter(request, prefix + "bl_fnt_ofc_flg", ""));
        setSplitStsCd(JSPUtil.getParameter(request, prefix + "split_sts_cd", ""));
        setXptRefNo(JSPUtil.getParameter(request, prefix + "xpt_ref_no", ""));
        setFaxLogRefNo(JSPUtil.getParameter(request, prefix + "fax_log_ref_no", ""));
        setAtchFilePathCtnt(JSPUtil.getParameter(request, prefix + "atch_file_path_ctnt", ""));
        setEmlAtchFileNm(JSPUtil.getParameter(request, prefix + "eml_atch_file_nm", ""));
        setConvAtchFilePathCtnt(JSPUtil.getParameter(request, prefix + "conv_atch_file_path_ctnt", ""));
        setConvEmlAtchFileNm(JSPUtil.getParameter(request, prefix + "conv_eml_atch_file_nm", ""));
        setSrKndCd(JSPUtil.getParameter(request, prefix + "sr_knd_cd", ""));
        setTmpltParRto(JSPUtil.getParameter(request, prefix + "tmplt_par_rto", ""));
        setPageNo(JSPUtil.getParameter(request, prefix + "page_no", ""));
        setSpclCgoFlg(JSPUtil.getParameter(request, prefix + "spcl_cgo_flg", ""));
        setExcelFlg(JSPUtil.getParameter(request, prefix + "excel_flg", ""));
        setXterTeu(JSPUtil.getParameter(request, prefix + "xter_teu", ""));
        setXterRqstStsOfcCd(JSPUtil.getParameter(request, prefix + "xter_rqst_sts_ofc_cd", ""));
        setXterRqstStsUsrId(JSPUtil.getParameter(request, prefix + "xter_rqst_sts_usr_id", ""));
        setXterRqstStsUsrNm(JSPUtil.getParameter(request, prefix + "xter_rqst_sts_usr_nm", ""));
        setXterRqstStsUpdDt(JSPUtil.getParameter(request, prefix + "xter_rqst_sts_upd_dt", ""));
        setXterRqstStsCd(JSPUtil.getParameter(request, prefix + "xter_rqst_sts_cd", ""));
        setObSrepCd(JSPUtil.getParameter(request, prefix + "ob_srep_cd", ""));
        setPctlExptFlg(JSPUtil.getParameter(request, prefix + "pctl_expt_flg", ""));
        setBkgBlckFlg(JSPUtil.getParameter(request, prefix + "bkg_blck_flg", ""));
        setOtherFlag(JSPUtil.getParameter(request, prefix + "other_flag", ""));
        setBlNoCtnt(JSPUtil.getParameter(request, prefix + "bl_no_ctnt", ""));
        setSysUpldFlg(JSPUtil.getParameter(request, prefix + "sys_upld_flg", ""));
        setSiAudFlg(JSPUtil.getParameter(request, prefix + "si_aud_flg", ""));
        setVgmFlg(JSPUtil.getParameter(request, prefix + "vgm_flg", ""));
        setItrFlg(JSPUtil.getParameter(request, prefix + "itr_flg", ""));
        setGtnFlg(JSPUtil.getParameter(request, prefix + "gtn_flg", ""));
        setCsmFlg(JSPUtil.getParameter(request, prefix + "csm_flg", ""));
        setUltiNewAsiaCustFlg(JSPUtil.getParameter(request, prefix + "ulti_new_asia_cust_flg", ""));
        setUltiTrnsCustFlg(JSPUtil.getParameter(request, prefix + "ulti_trns_cust_flg", ""));
        setBagDg(JSPUtil.getParameter(request, prefix + "bag_dg", ""));
        setNonRtStsCd(JSPUtil.getParameter(request, prefix + "non_rt_sts_cd", ""));
        setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
        setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
        setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
        setXterRmk(JSPUtil.getParameter(request, prefix + "xter_rmk", ""));
        setCtrtNo(JSPUtil.getParameter(request, prefix + "ctrt_no", ""));
        setCtrtNm(JSPUtil.getParameter(request, prefix + "ctrt_nm", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ExternalRqstListVO[]
	 */
    public ExternalRqstListVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ExternalRqstListVO[]
	 */
    public ExternalRqstListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        ExternalRqstListVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd".trim(), length));
            String[] bkgStsCd = (JSPUtil.getParameter(request, prefix + "bkg_sts_cd".trim(), length));
            String[] xterDelNm = (JSPUtil.getParameter(request, prefix + "xter_del_nm".trim(), length));
            String[] rowCount = (JSPUtil.getParameter(request, prefix + "row_count".trim(), length));
            String[] cntcEml = (JSPUtil.getParameter(request, prefix + "cntc_eml".trim(), length));
            String[] rqstAcptDesc = (JSPUtil.getParameter(request, prefix + "rqst_acpt_desc".trim(), length));
            String[] xterPodCd = (JSPUtil.getParameter(request, prefix + "xter_pod_cd".trim(), length));
            String[] bkgUpldStsCd = (JSPUtil.getParameter(request, prefix + "bkg_upld_sts_cd".trim(), length));
            String[] xterBkgRqstStsCd = (JSPUtil.getParameter(request, prefix + "xter_bkg_rqst_sts_cd".trim(), length));
            String[] docTpCd = (JSPUtil.getParameter(request, prefix + "doc_tp_cd".trim(), length));
            String[] hndlOfcCd = (JSPUtil.getParameter(request, prefix + "hndl_ofc_cd".trim(), length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows".trim(), length));
            String[] xterPorNm = (JSPUtil.getParameter(request, prefix + "xter_por_nm".trim(), length));
            String[] xterDelCd = (JSPUtil.getParameter(request, prefix + "xter_del_cd".trim(), length));
            String[] xterPolCd = (JSPUtil.getParameter(request, prefix + "xter_pol_cd".trim(), length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag".trim(), length));
            String[] vslEngNm = (JSPUtil.getParameter(request, prefix + "vsl_eng_nm".trim(), length));
            String[] xterPorCd = (JSPUtil.getParameter(request, prefix + "xter_por_cd".trim(), length));
            String[] xterRqstAcptUsrId = (JSPUtil.getParameter(request, prefix + "xter_rqst_acpt_usr_id".trim(), length));
            String[] shNm = (JSPUtil.getParameter(request, prefix + "sh_nm".trim(), length));
            String[] xterRqstViaCd = (JSPUtil.getParameter(request, prefix + "xter_rqst_via_cd".trim(), length));
            String[] upldDt = (JSPUtil.getParameter(request, prefix + "upld_dt".trim(), length));
            String[] xterSndrId = (JSPUtil.getParameter(request, prefix + "xter_sndr_id".trim(), length));
            String[] upldUsrId = (JSPUtil.getParameter(request, prefix + "upld_usr_id".trim(), length));
            String[] rqstDt = (JSPUtil.getParameter(request, prefix + "rqst_dt".trim(), length));
            String[] rqstGmtDt = (JSPUtil.getParameter(request, prefix + "rqst_gmt_dt".trim(), length));
            String[] xterRqstAcptUsrNm = (JSPUtil.getParameter(request, prefix + "xter_rqst_acpt_usr_nm".trim(), length));
            String[] snaccsSplitNo = (JSPUtil.getParameter(request, prefix + "snaccs_split_no".trim(), length));
            String[] origin = (JSPUtil.getParameter(request, prefix + "origin".trim(), length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no".trim(), length));
            String[] rqstDepDt = (JSPUtil.getParameter(request, prefix + "rqst_dep_dt".trim(), length));
            String[] ffNm = (JSPUtil.getParameter(request, prefix + "ff_nm".trim(), length));
            String[] xterPolNm = (JSPUtil.getParameter(request, prefix + "xter_pol_nm".trim(), length));
            String[] vvd = (JSPUtil.getParameter(request, prefix + "vvd".trim(), length));
            String[] upldUsrNm = (JSPUtil.getParameter(request, prefix + "upld_usr_nm".trim(), length));
            String[] ofcCd = (JSPUtil.getParameter(request, prefix + "ofc_cd".trim(), length));
            String[] poNo = (JSPUtil.getParameter(request, prefix + "po_no".trim(), length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no".trim(), length));
            String[] bkgNoCheck = (JSPUtil.getParameter(request, prefix + "bkg_no_check".trim(), length));
            String[] xterPodNm = (JSPUtil.getParameter(request, prefix + "xter_pod_nm".trim(), length));
            String[] xterRqstSeq = (JSPUtil.getParameter(request, prefix + "xter_rqst_seq".trim(), length));
            String[] dispXterRqstSeq = (JSPUtil.getParameter(request, prefix + "disp_xter_rqst_seq".trim(), length));
            String[] xterRqstNo = (JSPUtil.getParameter(request, prefix + "xter_rqst_no".trim(), length));
            String[] delivery = (JSPUtil.getParameter(request, prefix + "delivery".trim(), length));
            String[] rowNum = (JSPUtil.getParameter(request, prefix + "row_num".trim(), length));
            String[] cnNm = (JSPUtil.getParameter(request, prefix + "cn_nm".trim(), length));
            String[] xterRjctRsnNm = (JSPUtil.getParameter(request, prefix + "xter_rjct_rsn_nm".trim(), length));
            String[] rjctRsnRmk = (JSPUtil.getParameter(request, prefix + "rjct_rsn_rmk".trim(), length));
            String[] xterPndRsnNm = (JSPUtil.getParameter(request, prefix + "xter_pnd_rsn_nm".trim(), length));
            String[] custRefNo = (JSPUtil.getParameter(request, prefix + "cust_ref_no".trim(), length));
            String[] xterRqstRvisSeq = (JSPUtil.getParameter(request, prefix + "xter_rqst_rvis_seq".trim(), length));
            String[] slanCd = (JSPUtil.getParameter(request, prefix + "slan_cd".trim(), length));
            String[] blDocInpFlg = (JSPUtil.getParameter(request, prefix + "bl_doc_inp_flg".trim(), length));
            String[] blFntOfcFlg = (JSPUtil.getParameter(request, prefix + "bl_fnt_ofc_flg".trim(), length));
            String[] splitStsCd = (JSPUtil.getParameter(request, prefix + "split_sts_cd".trim(), length));
            String[] xptRefNo = (JSPUtil.getParameter(request, prefix + "xpt_ref_no".trim(), length));
            String[] faxLogRefNo = (JSPUtil.getParameter(request, prefix + "fax_log_ref_no".trim(), length));
            String[] atchFilePathCtnt = (JSPUtil.getParameter(request, prefix + "atch_file_path_ctnt".trim(), length));
            String[] emlAtchFileNm = (JSPUtil.getParameter(request, prefix + "eml_atch_file_nm".trim(), length));
            String[] convAtchFilePathCtnt = (JSPUtil.getParameter(request, prefix + "conv_atch_file_path_ctnt".trim(), length));
            String[] convEmlAtchFileNm = (JSPUtil.getParameter(request, prefix + "conv_eml_atch_file_nm".trim(), length));
            String[] srKndCd = (JSPUtil.getParameter(request, prefix + "sr_knd_cd".trim(), length));
            String[] tmpltParRto = (JSPUtil.getParameter(request, prefix + "tmplt_par_rto".trim(), length));
            String[] pageNo = (JSPUtil.getParameter(request, prefix + "page_no".trim(), length));
            String[] spclCgoFlg = (JSPUtil.getParameter(request, prefix + "spcl_cgo_flg".trim(), length));
            String[] excelFlg = (JSPUtil.getParameter(request, prefix + "excel_flg".trim(), length));
            String[] xterTeu = (JSPUtil.getParameter(request, prefix + "xter_teu".trim(), length));
            String[] xterRqstStsOfcCd = (JSPUtil.getParameter(request, prefix + "xter_rqst_sts_ofc_cd".trim(), length));
            String[] xterRqstStsUsrId = (JSPUtil.getParameter(request, prefix + "xter_rqst_sts_usr_id".trim(), length));
            String[] xterRqstStsUsrNm = (JSPUtil.getParameter(request, prefix + "xter_rqst_sts_usr_nm".trim(), length));
            String[] xterRqstStsUpdDt = (JSPUtil.getParameter(request, prefix + "xter_rqst_sts_upd_dt".trim(), length));
            String[] xterRqstStsCd = (JSPUtil.getParameter(request, prefix + "xter_rqst_sts_cd".trim(), length));
            String[] obSrepCd = (JSPUtil.getParameter(request, prefix + "ob_srep_cd".trim(), length));
            String[] pctlExptFlg = (JSPUtil.getParameter(request, prefix + "pctl_expt_flg".trim(), length));
            String[] bkgBlckFlg = (JSPUtil.getParameter(request, prefix + "bkg_blck_flg".trim(), length));
            String[] otherFlag = (JSPUtil.getParameter(request, prefix + "other_flag".trim(), length));
            String[] blNoCtnt = (JSPUtil.getParameter(request, prefix + "bl_no_ctnt".trim(), length));
            String[] sysUpldFlg = (JSPUtil.getParameter(request, prefix + "sys_upld_flg".trim(), length));
            String[] siAudFlg = (JSPUtil.getParameter(request, prefix + "si_aud_flg".trim(), length));
            String[] vgmFlg = (JSPUtil.getParameter(request, prefix + "vgm_flg".trim(), length));
            String[] itrFlg = (JSPUtil.getParameter(request, prefix + "itr_flg".trim(), length));
            String[] gtnFlg = (JSPUtil.getParameter(request, prefix + "gtn_flg".trim(), length));
            String[] csmFlg = (JSPUtil.getParameter(request, prefix + "csm_flg".trim(), length));
            String[] ultiNewAsiaCustFlg = (JSPUtil.getParameter(request, prefix + "ulti_new_asia_cust_flg".trim(), length));
            String[] ultiTrnsCustFlg = (JSPUtil.getParameter(request, prefix + "ulti_trns_cust_flg".trim(), length));
            String[] bagDg = (JSPUtil.getParameter(request, prefix + "bag_dg", length));
            String[] nonRtStsCd = (JSPUtil.getParameter(request, prefix + "non_rt_sts_cd", length));
            String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", length));
            String[] cmdtNm = (JSPUtil.getParameter(request, prefix + "cmdt_nm", length));
            String[] cmdtCd = (JSPUtil.getParameter(request, prefix + "cmdt_cd", length));
            String[] xterRmk = (JSPUtil.getParameter(request, prefix + "xter_rmk", length));
            String[] ctrtNo = (JSPUtil.getParameter(request, prefix + "ctrt_no", length));
            String[] ctrtNm = (JSPUtil.getParameter(request, prefix + "ctrt_nm", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new ExternalRqstListVO();
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (bkgStsCd[i] != null)
                    model.setBkgStsCd(bkgStsCd[i]);
                if (xterDelNm[i] != null)
                    model.setXterDelNm(xterDelNm[i]);
                if (rowCount[i] != null)
                    model.setRowCount(rowCount[i]);
                if (cntcEml[i] != null)
                    model.setCntcEml(cntcEml[i]);
                if (rqstAcptDesc[i] != null)
                    model.setRqstAcptDesc(rqstAcptDesc[i]);
                if (xterPodCd[i] != null)
                    model.setXterPodCd(xterPodCd[i]);
                if (bkgUpldStsCd[i] != null)
                    model.setBkgUpldStsCd(bkgUpldStsCd[i]);
                if (xterBkgRqstStsCd[i] != null)
                    model.setXterBkgRqstStsCd(xterBkgRqstStsCd[i]);
                if (docTpCd[i] != null)
                    model.setDocTpCd(docTpCd[i]);
                if (hndlOfcCd[i] != null)
                    model.setHndlOfcCd(hndlOfcCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (xterPorNm[i] != null)
                    model.setXterPorNm(xterPorNm[i]);
                if (xterDelCd[i] != null)
                    model.setXterDelCd(xterDelCd[i]);
                if (xterPolCd[i] != null)
                    model.setXterPolCd(xterPolCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (vslEngNm[i] != null)
                    model.setVslEngNm(vslEngNm[i]);
                if (xterPorCd[i] != null)
                    model.setXterPorCd(xterPorCd[i]);
                if (xterRqstAcptUsrId[i] != null)
                    model.setXterRqstAcptUsrId(xterRqstAcptUsrId[i]);
                if (shNm[i] != null)
                    model.setShNm(shNm[i]);
                if (xterRqstViaCd[i] != null)
                    model.setXterRqstViaCd(xterRqstViaCd[i]);
                if (upldDt[i] != null)
                    model.setUpldDt(upldDt[i]);
                if (xterSndrId[i] != null)
                    model.setXterSndrId(xterSndrId[i]);
                if (upldUsrId[i] != null)
                    model.setUpldUsrId(upldUsrId[i]);
                if (rqstDt[i] != null)
                    model.setRqstDt(rqstDt[i]);
                if (rqstGmtDt[i] != null)
                    model.setRqstGmtDt(rqstGmtDt[i]);
                if (xterRqstAcptUsrNm[i] != null)
                    model.setXterRqstAcptUsrNm(xterRqstAcptUsrNm[i]);
                if (snaccsSplitNo[i] != null)
                    model.setSnaccsSplitNo(snaccsSplitNo[i]);
                if (origin[i] != null)
                    model.setOrigin(origin[i]);
                if (skdVoyNo[i] != null)
                    model.setSkdVoyNo(skdVoyNo[i]);
                if (rqstDepDt[i] != null)
                    model.setRqstDepDt(rqstDepDt[i]);
                if (ffNm[i] != null)
                    model.setFfNm(ffNm[i]);
                if (xterPolNm[i] != null)
                    model.setXterPolNm(xterPolNm[i]);
                if (vvd[i] != null)
                    model.setVvd(vvd[i]);
                if (upldUsrNm[i] != null)
                    model.setUpldUsrNm(upldUsrNm[i]);
                if (ofcCd[i] != null)
                    model.setOfcCd(ofcCd[i]);
                if (poNo[i] != null)
                    model.setPoNo(poNo[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (bkgNoCheck[i] != null)
                    model.setBkgNoCheck(bkgNoCheck[i]);
                if (xterPodNm[i] != null)
                    model.setXterPodNm(xterPodNm[i]);
                if (xterRqstSeq[i] != null)
                    model.setXterRqstSeq(xterRqstSeq[i]);
                if (dispXterRqstSeq[i] != null)
                    model.setDispXterRqstSeq(dispXterRqstSeq[i]);
                if (xterRqstNo[i] != null)
                    model.setXterRqstNo(xterRqstNo[i]);
                if (delivery[i] != null)
                    model.setDelivery(delivery[i]);
                if (rowNum[i] != null)
                    model.setRowNum(rowNum[i]);
                if (cnNm[i] != null)
                    model.setCnNm(cnNm[i]);
                if (xterRjctRsnNm[i] != null)
                    model.setXterRjctRsnNm(xterRjctRsnNm[i]);
                if (rjctRsnRmk[i] != null)
                    model.setRjctRsnRmk(rjctRsnRmk[i]);
                if (xterPndRsnNm[i] != null)
                    model.setXterPndRsnNm(xterPndRsnNm[i]);
                if (custRefNo[i] != null)
                    model.setCustRefNo(custRefNo[i]);
                if (xterRqstRvisSeq[i] != null)
                    model.setXterRqstRvisSeq(xterRqstRvisSeq[i]);
                if (slanCd[i] != null)
                    model.setSlanCd(slanCd[i]);
                if (blDocInpFlg[i] != null)
                    model.setBlDocInpFlg(blDocInpFlg[i]);
                if (blFntOfcFlg[i] != null)
                    model.setBlFntOfcFlg(blFntOfcFlg[i]);
                if (splitStsCd[i] != null)
                    model.setSplitStsCd(splitStsCd[i]);
                if (xptRefNo[i] != null)
                    model.setXptRefNo(xptRefNo[i]);
                if (faxLogRefNo[i] != null)
                    model.setFaxLogRefNo(faxLogRefNo[i]);
                if (atchFilePathCtnt[i] != null)
                    model.setAtchFilePathCtnt(atchFilePathCtnt[i]);
                if (emlAtchFileNm[i] != null)
                    model.setEmlAtchFileNm(emlAtchFileNm[i]);
                if (convAtchFilePathCtnt[i] != null)
                    model.setConvAtchFilePathCtnt(convAtchFilePathCtnt[i]);
                if (convEmlAtchFileNm[i] != null)
                    model.setConvEmlAtchFileNm(convEmlAtchFileNm[i]);
                if (srKndCd[i] != null)
                    model.setSrKndCd(srKndCd[i]);
                if (tmpltParRto[i] != null)
                    model.setTmpltParRto(tmpltParRto[i]);
                if (pageNo[i] != null)
                    model.setPageNo(pageNo[i]);
                if (spclCgoFlg[i] != null)
                    model.setSpclCgoFlg(spclCgoFlg[i]);
                if (excelFlg[i] != null)
                    model.setExcelFlg(excelFlg[i]);
                if (xterTeu[i] != null)
                    model.setXterTeu(xterTeu[i]);
                if (xterRqstStsOfcCd[i] != null)
                    model.setXterRqstStsOfcCd(xterRqstStsOfcCd[i]);
                if (xterRqstStsUsrId[i] != null)
                    model.setXterRqstStsUsrId(xterRqstStsUsrId[i]);
                if (xterRqstStsUsrNm[i] != null)
                    model.setXterRqstStsUsrNm(xterRqstStsUsrNm[i]);
                if (xterRqstStsUpdDt[i] != null)
                    model.setXterRqstStsUpdDt(xterRqstStsUpdDt[i]);
                if (xterRqstStsCd[i] != null)
                    model.setXterRqstStsCd(xterRqstStsCd[i]);
                if (obSrepCd[i] != null)
                    model.setObSrepCd(obSrepCd[i]);
                if (pctlExptFlg[i] != null)
                    model.setPctlExptFlg(pctlExptFlg[i]);
                if (bkgBlckFlg[i] != null)
                    model.setBkgBlckFlg(bkgBlckFlg[i]);
                if (otherFlag[i] != null)
                    model.setOtherFlag(otherFlag[i]);
                if (blNoCtnt[i] != null)
                    model.setBlNoCtnt(blNoCtnt[i]);
                if (sysUpldFlg[i] != null)
                    model.setSysUpldFlg(sysUpldFlg[i]);
                if (siAudFlg[i] != null)
                    model.setSiAudFlg(siAudFlg[i]);
                if (vgmFlg[i] != null)
                    model.setVgmFlg(vgmFlg[i]);
                if (itrFlg[i] != null)
                    model.setItrFlg(itrFlg[i]);
                if (gtnFlg[i] != null)
                    model.setGtnFlg(gtnFlg[i]);
                if (csmFlg[i] != null)
                    model.setCsmFlg(csmFlg[i]);
                if (ultiNewAsiaCustFlg[i] != null)
                    model.setUltiNewAsiaCustFlg(ultiNewAsiaCustFlg[i]);
                if (ultiTrnsCustFlg[i] != null)
                    model.setUltiTrnsCustFlg(ultiTrnsCustFlg[i]);
                if (bagDg[i] != null)
                    model.setBagDg(bagDg[i]);
                if (nonRtStsCd[i] != null)
                    model.setNonRtStsCd(nonRtStsCd[i]);
                if (cntrTpszCd[i] != null)
                    model.setCntrTpszCd(cntrTpszCd[i]);
                if (cmdtNm[i] != null)
                    model.setCmdtNm(cmdtNm[i]);
                if (cmdtCd[i] != null)
                    model.setCmdtCd(cmdtCd[i]);
                if (xterRmk[i] != null)
                    model.setXterRmk(xterRmk[i]);
                if (ctrtNo[i] != null)
                    model.setCtrtNo(ctrtNo[i]);
                if (ctrtNm[i] != null) 
		    		model.setCtrtNm(ctrtNm[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getExternalRqstListVOs();
    }

    /**
	 *  VO 배열을 반환
	 * @return ExternalRqstListVO[]
	 */
    public ExternalRqstListVO[] getExternalRqstListVOs() {
        ExternalRqstListVO[] vos = (ExternalRqstListVO[]) models.toArray(new ExternalRqstListVO[models.size()]);
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
        this.bkgStsCd = this.bkgStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterDelNm = this.xterDelNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rowCount = this.rowCount.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntcEml = this.cntcEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstAcptDesc = this.rqstAcptDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterPodCd = this.xterPodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgUpldStsCd = this.bkgUpldStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterBkgRqstStsCd = this.xterBkgRqstStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.docTpCd = this.docTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hndlOfcCd = this.hndlOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterPorNm = this.xterPorNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterDelCd = this.xterDelCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterPolCd = this.xterPolCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslEngNm = this.vslEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterPorCd = this.xterPorCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterRqstAcptUsrId = this.xterRqstAcptUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shNm = this.shNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterRqstViaCd = this.xterRqstViaCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.upldDt = this.upldDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterSndrId = this.xterSndrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.upldUsrId = this.upldUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstDt = this.rqstDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstGmtDt = this.rqstGmtDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterRqstAcptUsrNm = this.xterRqstAcptUsrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.snaccsSplitNo = this.snaccsSplitNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.origin = this.origin.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstDepDt = this.rqstDepDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ffNm = this.ffNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterPolNm = this.xterPolNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvd = this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.upldUsrNm = this.upldUsrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcCd = this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.poNo = this.poNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNoCheck = this.bkgNoCheck.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterPodNm = this.xterPodNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterRqstSeq = this.xterRqstSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dispXterRqstSeq = this.dispXterRqstSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterRqstNo = this.xterRqstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delivery = this.delivery.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rowNum = this.rowNum.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cnNm = this.cnNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterRjctRsnNm = this.xterRjctRsnNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rjctRsnRmk = this.rjctRsnRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterPndRsnNm = this.xterPndRsnNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custRefNo = this.custRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterRqstRvisSeq = this.xterRqstRvisSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd = this.slanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blDocInpFlg = this.blDocInpFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blFntOfcFlg = this.blFntOfcFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.splitStsCd = this.splitStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xptRefNo = this.xptRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.faxLogRefNo = this.faxLogRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.atchFilePathCtnt = this.atchFilePathCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emlAtchFileNm = this.emlAtchFileNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.convAtchFilePathCtnt = this.convAtchFilePathCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.convEmlAtchFileNm = this.convEmlAtchFileNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.srKndCd = this.srKndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tmpltParRto = this.tmpltParRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pageNo = this.pageNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoFlg = this.spclCgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.excelFlg = this.excelFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterTeu = this.xterTeu.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterRqstStsOfcCd = this.xterRqstStsOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterRqstStsUsrId = this.xterRqstStsUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterRqstStsUsrNm = this.xterRqstStsUsrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterRqstStsUpdDt = this.xterRqstStsUpdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterRqstStsCd = this.xterRqstStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.obSrepCd = this.obSrepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pctlExptFlg = this.pctlExptFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgBlckFlg = this.bkgBlckFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.otherFlag = this.otherFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blNoCtnt = this.blNoCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sysUpldFlg = this.sysUpldFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.siAudFlg = this.siAudFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vgmFlg = this.vgmFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.itrFlg = this.itrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.gtnFlg = this.gtnFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.csmFlg = this.csmFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ultiNewAsiaCustFlg = this.ultiNewAsiaCustFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ultiTrnsCustFlg = this.ultiTrnsCustFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bagDg = this.bagDg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nonRtStsCd = this.nonRtStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrTpszCd = this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtNm = this.cmdtNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtCd = this.cmdtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterRmk = this.xterRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctrtNo = this.ctrtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctrtNm = this.ctrtNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
