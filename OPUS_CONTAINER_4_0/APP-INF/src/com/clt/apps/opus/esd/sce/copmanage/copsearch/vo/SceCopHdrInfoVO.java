/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SCE_COP_HDR.java
*@FileTitle : COPManage
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-13
*@LastModifier : Se-Hoon PARK
*@LastVersion : 1.0
* 2006-09-13 Se-Hoon PARK
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.copmanage.copsearch.vo;

import java.util.Collection;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - 모든 업무에서 공통으로 사용하는 PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author Se-Hoon PARK
 * @see COPMMANAGE 참조
 * @since J2EE 1.4
 */
public class SceCopHdrInfoVO{

	private String            ibflag            = "";
    private String            pageRows         = "";
    private String            copNo            = "";
    private String            bkgNo            = "";
    private String            bkgNoSplit      = "";
    private String            cntrNo           = "";
    private String            cnmvYr           = "";
    private String            cnmvSeq          = "";
    private String            copStsCd        = "";
    private String            pctlNo           = "";
    private String            cntrTpszCd      = "";
    private String            porNodCd        = "";
    private String            polCd            = "";
    private String            n1stTsPortCd   = "";
    private String            n2ndTsPortCd   = "";
    private String            n3rdTsPortCd   = "";
    private String            podCd            = "";
    private String            delNodCd        = "";
    private String            ttlTztmHrs      = "";
    private String            prodRev          = "";
    private String            ttlExpnAmt      = "";
    private String            cmAmt            = "";
    private String            trnkAvalTeuSpc = "";
    private String            obItchgCtnt     = "";
    private String            ibItchgCtnt     = "";
    private String            creOfcCd        = "";
    private String            creUsrId        = "";
    private String            creDt            = "";
    private String            updUsrId        = "";
    private String            updDt            = "";
    private String            boundName        = "";
    private String  		  iscompled			= "";
    private String            isnodchg			= "";
    private String            nodcd             = "";
    private String            isfrmchg			= "";
    private String            frmcd             = "";
    private String            copSubStsCd    = "";
    private String            maxGrpSeq       = "";
    private String            maxDtlSeq       = "";


    public SceCopHdrInfoVO(){}

    /**
     * Constructor
     * 
     * @param ibflag
     * @param pageRows
     * @param copNo
     * @param bkgNo
     * @param bkgNoSplit
     * @param cntrNo
     * @param cnmvYr
     * @param cnmvSeq
     * @param copStsCd
     * @param pctlNo
     * @param cntrTpszCd
     * @param porNodCd
     * @param polCd
     * @param n1stTsPortCd
     * @param n2ndTsPortCd
     * @param n3rdTsPortCd
     * @param podCd
     * @param delNodCd
     * @param ttlTztmHrs
     * @param prodRev
     * @param ttlExpnAmt
     * @param cmAmt
     * @param trnkAvalTeuSpc
     * @param obItchgCtnt
     * @param ibItchgCtnt
     * @param creOfcCd
     * @param creUsrId
     * @param creDt
     * @param updUsrId
     * @param updDt
     * @param copSubStsCd
     * @param maxGrpSeq
     * @param maxDtlSeq
     */
    public SceCopHdrInfoVO(
            String            ibflag           ,
            String            pageRows        ,
            String            copNo           ,
            String            bkgNo           ,
            String            bkgNoSplit     ,
            String            cntrNo          ,
            String            cnmvYr          ,
            String            cnmvSeq         ,
            String            copStsCd       ,
            String            pctlNo          ,
            String            cntrTpszCd     ,
            String            porNodCd       ,
            String            polCd           ,
            String            n1stTsPortCd  ,
            String            n2ndTsPortCd  ,
            String            n3rdTsPortCd  ,
            String            podCd           ,
            String            delNodCd       ,
            String            ttlTztmHrs     ,
            String            prodRev         ,
            String            ttlExpnAmt     ,
            String            cmAmt           ,
            String            trnkAvalTeuSpc,
            String            obItchgCtnt    ,
            String            ibItchgCtnt    ,
            String            creOfcCd       ,
            String            creUsrId       ,
            String            creDt           ,
            String            updUsrId       ,
            String            updDt           ,
            String            copSubStsCd   ,
            String            maxGrpSeq      ,
            String            maxDtlSeq      ){
        this.ibflag            = ibflag           ;
        this.pageRows         = pageRows        ;
        this.copNo            = copNo           ;
        this.bkgNo            = bkgNo           ;
        this.bkgNoSplit      = bkgNoSplit     ;
        this.cntrNo           = cntrNo          ;
        this.cnmvYr           = cnmvYr          ;
        this.cnmvSeq          = cnmvSeq         ;
        this.copStsCd        = copStsCd       ;
        this.pctlNo           = pctlNo          ;
        this.cntrTpszCd      = cntrTpszCd     ;
        this.porNodCd        = porNodCd       ;
        this.polCd            = polCd           ;
        this.n1stTsPortCd   = n1stTsPortCd  ;
        this.n2ndTsPortCd   = n2ndTsPortCd  ;
        this.n3rdTsPortCd   = n3rdTsPortCd  ;
        this.podCd            = podCd           ;
        this.delNodCd        = delNodCd       ;
        this.ttlTztmHrs      = ttlTztmHrs     ;
        this.prodRev          = prodRev         ;
        this.ttlExpnAmt      = ttlExpnAmt     ;
        this.cmAmt            = cmAmt           ;
        this.trnkAvalTeuSpc = trnkAvalTeuSpc;
        this.obItchgCtnt     = obItchgCtnt    ;
        this.ibItchgCtnt     = ibItchgCtnt    ;
        this.creOfcCd        = creOfcCd       ;
        this.creUsrId        = creUsrId       ;
        this.creDt            = creDt           ;
        this.updUsrId        = updUsrId       ;
        this.updDt            = updDt           ;
        this.copSubStsCd    = copSubStsCd   ;
        this.maxGrpSeq       = maxGrpSeq      ;
        this.maxDtlSeq       = maxDtlSeq      ;
    }

    // getter method is proceeding ..
    public String            getIbflag           (){    return ibflag               ;    }
    public String            getPage_rows        (){    return pageRows            ;    }
    public String            getCop_no           (){    return copNo               ;    }
    public String            getBkg_no           (){    return bkgNo               ;    }
    public String            getBkg_no_split     (){    return bkgNoSplit         ;    }
    public String            getCntr_no          (){    return cntrNo              ;    }
    public String            getCnmv_yr          (){    return cnmvYr              ;    }
    public String            getCnmv_seq         (){    return cnmvSeq             ;    }
    public String            getCop_sts_cd       (){    return copStsCd           ;    }
    public String            getPctl_no          (){    return pctlNo              ;    }
    public String            getCntr_tpsz_cd     (){    return cntrTpszCd         ;    }
    public String            getPor_nod_cd       (){    return porNodCd           ;    }
    public String            getPol_cd           (){    return polCd               ;    }
    public String            getN1st_ts_port_cd  (){    return n1stTsPortCd      ;    }
    public String            getN2nd_ts_port_cd  (){    return n2ndTsPortCd      ;    }
    public String            getN3rd_ts_port_cd  (){    return n3rdTsPortCd      ;    }
    public String            getPod_cd           (){    return podCd               ;    }
    public String            getDel_nod_cd       (){    return delNodCd           ;    }
    public String            getTtl_tztm_hrs     (){    return ttlTztmHrs         ;    }
    public String            getProd_rev         (){    return prodRev             ;    }
    public String            getTtl_expn_amt     (){    return ttlExpnAmt         ;    }
    public String            getCm_amt           (){    return cmAmt               ;    }
    public String            getTrnk_aval_teu_spc(){    return trnkAvalTeuSpc    ;    }
    public String            getOb_itchg_ctnt    (){    return obItchgCtnt        ;    }
    public String            getIb_itchg_ctnt    (){    return ibItchgCtnt        ;    }
    public String            getCre_ofc_cd       (){    return creOfcCd           ;    }
    public String            getCre_usr_id       (){    return creUsrId           ;    }
    public String            getCre_dt           (){    return creDt               ;    }
    public String            getUpd_usr_id       (){    return updUsrId           ;    }
    public String            getUpd_dt           (){    return updDt               ;    }
    public String            getBound_name       (){    return boundName           ;    }
    public String            getIscompled        (){    return iscompled            ;    }
    public String            getNodcd            (){    return nodcd                ;    }
    public String            getIsnodchg         (){    return isnodchg             ;    }
    public String            getFrmcd            (){    return frmcd                ;    }
    public String            getIsfrmchg         (){    return isfrmchg             ;    }
    public String            getCop_sub_sts_cd   (){	return copSubStsCd      	; 	 }
    public String            getMax_grp_seq      (){	return maxGrpSeq          ;    }
    public String            getMax_dtl_seq      (){	return maxDtlSeq          ;    }

    // setter method is proceeding ..
    public void setIbflag           ( String            ibflag            ){    this.ibflag            = ibflag               ;    }
    public void setPage_rows        ( String            pageRows         ){    this.pageRows         = pageRows            ;    }
    public void setCop_no           ( String            copNo            ){    this.copNo            = copNo               ;    }
    public void setBkg_no           ( String            bkgNo            ){    this.bkgNo            = bkgNo               ;    }
    public void setBkg_no_split     ( String            bkgNoSplit      ){    this.bkgNoSplit      = bkgNoSplit         ;    }
    public void setCntr_no          ( String            cntrNo           ){    this.cntrNo           = cntrNo              ;    }
    public void setCnmv_yr          ( String            cnmvYr           ){    this.cnmvYr           = cnmvYr              ;    }
    public void setCnmv_seq         ( String            cnmvSeq          ){    this.cnmvSeq          = cnmvSeq             ;    }
    public void setCop_sts_cd       ( String            copStsCd        ){    this.copStsCd        = copStsCd           ;    }
    public void setPctl_no          ( String            pctlNo           ){    this.pctlNo           = pctlNo              ;    }
    public void setCntr_tpsz_cd     ( String            cntrTpszCd      ){    this.cntrTpszCd      = cntrTpszCd         ;    }
    public void setPor_nod_cd       ( String            porNodCd        ){    this.porNodCd        = porNodCd           ;    }
    public void setPol_cd           ( String            polCd            ){    this.polCd            = polCd               ;    }
    public void setN1st_ts_port_cd  ( String            n1stTsPortCd   ){    this.n1stTsPortCd   = n1stTsPortCd      ;    }
    public void setN2nd_ts_port_cd  ( String            n2ndTsPortCd   ){    this.n2ndTsPortCd   = n2ndTsPortCd      ;    }
    public void setN3rd_ts_port_cd  ( String            n3rdTsPortCd   ){    this.n3rdTsPortCd   = n3rdTsPortCd      ;    }
    public void setPod_cd           ( String            podCd            ){    this.podCd            = podCd               ;    }
    public void setDel_nod_cd       ( String            delNodCd        ){    this.delNodCd        = delNodCd           ;    }
    public void setTtl_tztm_hrs     ( String            ttlTztmHrs      ){    this.ttlTztmHrs      = ttlTztmHrs         ;    }
    public void setProd_rev         ( String            prodRev          ){    this.prodRev          = prodRev             ;    }
    public void setTtl_expn_amt     ( String            ttlExpnAmt      ){    this.ttlExpnAmt      = ttlExpnAmt         ;    }
    public void setCm_amt           ( String            cmAmt            ){    this.cmAmt            = cmAmt               ;    }
    public void setTrnk_aval_teu_spc( String            trnkAvalTeuSpc ){    this.trnkAvalTeuSpc = trnkAvalTeuSpc    ;    }
    public void setOb_itchg_ctnt    ( String            obItchgCtnt     ){    this.obItchgCtnt     = obItchgCtnt        ;    }
    public void setIb_itchg_ctnt    ( String            ibItchgCtnt     ){    this.ibItchgCtnt     = ibItchgCtnt        ;    }
    public void setCre_ofc_cd       ( String            creOfcCd        ){    this.creOfcCd        = creOfcCd           ;    }
    public void setCre_usr_id       ( String            creUsrId        ){    this.creUsrId        = creUsrId           ;    }
    public void setCre_dt           ( String            creDt            ){    this.creDt            = creDt               ;    }
    public void setUpd_usr_id       ( String            updUsrId        ){    this.updUsrId        = updUsrId           ;    }
    public void setUpd_dt           ( String            updDt            ){    this.updDt            = updDt               ;    }
    public void setBound_name       ( String            boundName        ){    this.boundName        = boundName           ;    }
    public void setIscompled        ( String 			iscompled         ){    this.iscompled         = iscompled            ;    }
    public void setNodcd            ( String            nodcd             ){    this.nodcd             = nodcd                ;    }
    public void setIsnodchg         ( String 			isnodchg          ){    this.isnodchg          = isnodchg             ;    }
    public void setFrmcd            ( String            frmcd             ){    this.frmcd             = frmcd                ;    }
    public void setIsfrmchg         ( String 			isfrmchg          ){    this.isfrmchg          = isfrmchg             ;    }
    public void setCop_sub_sts_cd   ( String            copSubStsCd    	){	this.copSubStsCd    = copSubStsCd       ;    }
    public void setMax_grp_seq      ( String            maxGrpSeq       ){	this.maxGrpSeq       = maxGrpSeq          ;    }
    public void setMax_dtl_seq      ( String            maxDtlSeq       ){	this.maxDtlSeq       = maxDtlSeq          ;    }

    /**
	 * Request 의 데이터를 추출하여 해당객체의 멤버변수에 설정
	 * @param request
	 * @return SCE_COP_HDR_INFO
	 */
    public static SceCopHdrInfoVO fromRequest(HttpServletRequest request) {
        SceCopHdrInfoVO model = new SceCopHdrInfoVO();
//        try {
			model.setIbflag               (JSPUtil.getParameter(request, "ibflag                   ".trim(), ""));
	        model.setPage_rows            (JSPUtil.getParameter(request, "page_rows                  ".trim(), ""));
	        model.setCop_no               (JSPUtil.getParameter(request, "cop_no                     ".trim(), ""));
	        model.setBkg_no               (JSPUtil.getParameter(request, "bkg_no                     ".trim(), ""));
	        model.setBkg_no_split         (JSPUtil.getParameter(request, "bkg_no_split              ".trim(), ""));
	        model.setCntr_no              (JSPUtil.getParameter(request, "cntr_no                    ".trim(), ""));
	        model.setCnmv_yr              (JSPUtil.getParameter(request, "cnmv_yr                    ".trim(), ""));
	        model.setCnmv_seq             (JSPUtil.getParameter(request, "cnmv_seq                   ".trim(), ""));
	        model.setCop_sts_cd           (JSPUtil.getParameter(request, "cop_sts_cd                ".trim(), ""));
	        model.setPctl_no              (JSPUtil.getParameter(request, "pctl_no                    ".trim(), ""));
	        model.setCntr_tpsz_cd         (JSPUtil.getParameter(request, "cntr_tpsz_cd              ".trim(), ""));
	        model.setPor_nod_cd           (JSPUtil.getParameter(request, "por_nod_cd                ".trim(), ""));
	        model.setPol_cd               (JSPUtil.getParameter(request, "pol_cd                     ".trim(), ""));
	        model.setN1st_ts_port_cd      (JSPUtil.getParameter(request, "n1st_ts_port_cd          ".trim(), ""));
	        model.setN2nd_ts_port_cd      (JSPUtil.getParameter(request, "n2nd_ts_port_cd          ".trim(), ""));
	        model.setN3rd_ts_port_cd      (JSPUtil.getParameter(request, "n3rd_ts_port_cd          ".trim(), ""));
	        model.setPod_cd               (JSPUtil.getParameter(request, "pod_cd                     ".trim(), ""));
	        model.setDel_nod_cd           (JSPUtil.getParameter(request, "del_nod_cd                ".trim(), ""));
	        model.setTtl_tztm_hrs         (JSPUtil.getParameter(request, "ttl_tztm_hrs              ".trim(), ""));
	        model.setProd_rev             (JSPUtil.getParameter(request, "prod_rev                   ".trim(), ""));
	        model.setTtl_expn_amt         (JSPUtil.getParameter(request, "ttl_expn_amt              ".trim(), ""));
	        model.setCm_amt               (JSPUtil.getParameter(request, "cm_amt                     ".trim(), ""));
	        model.setTrnk_aval_teu_spc    (JSPUtil.getParameter(request, "trnk_aval_teu_spc        ".trim(), ""));
	        model.setOb_itchg_ctnt        (JSPUtil.getParameter(request, "ob_itchg_ctnt             ".trim(), ""));
	        model.setIb_itchg_ctnt        (JSPUtil.getParameter(request, "ib_itchg_ctnt             ".trim(), ""));
	        model.setCre_ofc_cd           (JSPUtil.getParameter(request, "cre_ofc_cd                ".trim(), ""));
	        model.setCre_usr_id           (JSPUtil.getParameter(request, "cre_usr_id                ".trim(), ""));
	        model.setCre_dt               (JSPUtil.getParameter(request, "cre_dt                     ".trim(), ""));
	        model.setUpd_usr_id           (JSPUtil.getParameter(request, "upd_usr_id                ".trim(), ""));
	        model.setUpd_dt               (JSPUtil.getParameter(request, "upd_dt                     ".trim(), ""));
	        model.setBound_name           (JSPUtil.getParameter(request, "bound_name                 ".trim(), ""));
	        model.setIscompled            (JSPUtil.getParameter(request, "iscompled                   ".trim(), ""));
	        model.setNodcd                (JSPUtil.getParameter(request, "nodcd                       ".trim(), ""));
	        model.setIsnodchg             (JSPUtil.getParameter(request, "isnodchg                    ".trim(), ""));
	        model.setFrmcd                (JSPUtil.getParameter(request, "frmcd                       ".trim(), ""));
	        model.setIsfrmchg             (JSPUtil.getParameter(request, "isfrmchg                    ".trim(), ""));
	        model.setCop_sub_sts_cd       (JSPUtil.getParameter(request, "cop_sub_sts_cd      	   ".trim(), ""));
	        model.setMax_grp_seq          (JSPUtil.getParameter(request, "max_grp_seq          	   ".trim(), ""));
	        model.setMax_dtl_seq          (JSPUtil.getParameter(request, "max_dtl_seq          	   ".trim(), ""));

//        } catch (Exception ex) {
            //throw new Exception(ex.getMessage());
//        }
        return model;
    }
    
    /**
	 * Request 의 데이터를 추출하여 해당객체의 멤버변수에 설정
	 * @param HttpServletRequest request
	 * @param int length
	 * @return Collection
	 */
    public static Collection<SceCopHdrInfoVO> fromRequest(HttpServletRequest request, int length) {
        SceCopHdrInfoVO model = null;
        Collection<SceCopHdrInfoVO> models = new ArrayList<SceCopHdrInfoVO>();
//       try {
	        String[] ibflag         =  (JSPUtil.getParameter(request, "ibflag                   ".trim(), length));
			String[] pageRows       =  (JSPUtil.getParameter(request, "page_rows                ".trim(), length));
			String[] copNo          =  (JSPUtil.getParameter(request, "cop_no                   ".trim(), length));
			String[] bkgNo          =  (JSPUtil.getParameter(request, "bkg_no                   ".trim(), length));
			String[] bkgNoSplit     =  (JSPUtil.getParameter(request, "bkg_no_split             ".trim(), length));
			String[] cntrNo         =  (JSPUtil.getParameter(request, "cntr_no                  ".trim(), length));
			String[] cnmvYr         =  (JSPUtil.getParameter(request, "cnmv_yr                  ".trim(), length));
			String[] cnmvSeq        =  (JSPUtil.getParameter(request, "cnmv_seq                 ".trim(), length));
			String[] copStsCd       =  (JSPUtil.getParameter(request, "cop_sts_cd               ".trim(), length));
			String[] pctlNo         =  (JSPUtil.getParameter(request, "pctl_no                  ".trim(), length));
			String[] cntrTpszCd     =  (JSPUtil.getParameter(request, "cntr_tpsz_cd             ".trim(), length));
			String[] porNodCd       =  (JSPUtil.getParameter(request, "por_nod_cd               ".trim(), length));
			String[] polCd          =  (JSPUtil.getParameter(request, "pol_cd                   ".trim(), length));
			String[] n1stTsPortCd   =  (JSPUtil.getParameter(request, "n1st_ts_port_cd          ".trim(), length));
			String[] n2ndTsPortCd   =  (JSPUtil.getParameter(request, "n2nd_ts_port_cd          ".trim(), length));
			String[] n3rdTsPortCd   =  (JSPUtil.getParameter(request, "n3rd_ts_port_cd          ".trim(), length));
			String[] podCd          =  (JSPUtil.getParameter(request, "pod_cd                   ".trim(), length));
			String[] delNodCd       =  (JSPUtil.getParameter(request, "del_nod_cd               ".trim(), length));
			String[] ttlTztmHrs     =  (JSPUtil.getParameter(request, "ttl_tztm_hrs             ".trim(), length));
			String[] prodRev        =  (JSPUtil.getParameter(request, "prod_rev                 ".trim(), length));
			String[] ttlExpnAmt     =  (JSPUtil.getParameter(request, "ttl_expn_amt             ".trim(), length));
			String[] cmAmt          =  (JSPUtil.getParameter(request, "cm_amt                   ".trim(), length));
			String[] trnkAvalTeuSpc =  (JSPUtil.getParameter(request, "trnk_aval_teu_spc        ".trim(), length));
			String[] obItchgCtnt    =  (JSPUtil.getParameter(request, "ob_itchg_ctnt            ".trim(), length));
			String[] ibItchgCtnt    =  (JSPUtil.getParameter(request, "ib_itchg_ctnt            ".trim(), length));
			String[] creOfcCd       =  (JSPUtil.getParameter(request, "cre_ofc_cd               ".trim(), length));
			String[] creUsrId       =  (JSPUtil.getParameter(request, "cre_usr_id               ".trim(), length));
			String[] creDt          =  (JSPUtil.getParameter(request, "cre_dt                   ".trim(), length));
			String[] updUsrId       =  (JSPUtil.getParameter(request, "upd_usr_id               ".trim(), length));
			String[] updDt          =  (JSPUtil.getParameter(request, "upd_dt                   ".trim(), length));
			String[] copSubStsCd    =  (JSPUtil.getParameter(request, "cop_sub_sts_cd      	   ".trim(), length));
			String[] maxGrpSeq      =  (JSPUtil.getParameter(request, "max_grp_seq         	   ".trim(), length));
			String[] maxDtlSeq      =  (JSPUtil.getParameter(request, "max_dtl_seq         	   ".trim(), length));

            for (int i = 0; i < length; i++) {
                model = new SceCopHdrInfoVO();
                model.setIbflag                     (ibflag               [i]);
                model.setPage_rows                  (pageRows            [i]);
                model.setCop_no                     (copNo               [i]);
                model.setBkg_no                     (bkgNo               [i]);
                model.setBkg_no_split               (bkgNoSplit         [i]);
                model.setCntr_no                    (cntrNo              [i]);
                model.setCnmv_yr                    (cnmvYr              [i]);
                model.setCnmv_seq                   (cnmvSeq             [i]);
                model.setCop_sts_cd                 (copStsCd           [i]);
                model.setPctl_no                    (pctlNo              [i]);
                model.setCntr_tpsz_cd               (cntrTpszCd         [i]);
                model.setPor_nod_cd                 (porNodCd           [i]);
                model.setPol_cd                     (polCd               [i]);
                model.setN1st_ts_port_cd            (n1stTsPortCd      [i]);
                model.setN2nd_ts_port_cd            (n2ndTsPortCd      [i]);
                model.setN3rd_ts_port_cd            (n3rdTsPortCd      [i]);
                model.setPod_cd                     (podCd               [i]);
                model.setDel_nod_cd                 (delNodCd           [i]);
                model.setTtl_tztm_hrs               (ttlTztmHrs         [i]);
                model.setProd_rev                   (prodRev             [i]);
                model.setTtl_expn_amt               (ttlExpnAmt         [i]);
                model.setCm_amt                     (cmAmt               [i]);
                model.setTrnk_aval_teu_spc          (trnkAvalTeuSpc    [i]);
                model.setOb_itchg_ctnt              (obItchgCtnt        [i]);
                model.setIb_itchg_ctnt              (ibItchgCtnt        [i]);
                model.setCre_ofc_cd                 (creOfcCd           [i]);
                model.setCre_usr_id                 (creUsrId           [i]);
                model.setCre_dt                     (creDt               [i]);
                model.setUpd_usr_id                 (updUsrId           [i]);
                model.setUpd_dt                     (updDt               [i]);
                model.setCop_sub_sts_cd      		(copSubStsCd       [i]);
                model.setMax_grp_seq         		(maxGrpSeq          [i]);
                model.setMax_dtl_seq         		(maxDtlSeq          [i]);
                models.add(model);
            }
//        } catch (Exception ex) {
//        }
        return models;
    }
    
    /**
	 * Request 의 데이터를 추출하여 해당객체의 멤버변수에 설정
	 * @param request
	 * @param prefix
	 * @return Collection
	 */
    public static Collection<SceCopHdrInfoVO> fromRequestGrid(HttpServletRequest request, String prefix) {
        SceCopHdrInfoVO model = null;
        Collection<SceCopHdrInfoVO> models = new ArrayList<SceCopHdrInfoVO>();
        int length = request.getParameterValues("ibflag").length;

        String[] ibflag         =  (JSPUtil.getParameter(request, prefix + "ibflag                   ".trim(), length));
		String[] pageRows       =  (JSPUtil.getParameter(request, prefix + "page_rows                ".trim(), length));
		String[] copNo          =  (JSPUtil.getParameter(request, prefix + "cop_no                   ".trim(), length));
		String[] bkgNo          =  (JSPUtil.getParameter(request, prefix + "bkg_no                   ".trim(), length));
		String[] bkgNoSplit     =  (JSPUtil.getParameter(request, prefix + "bkg_no_split             ".trim(), length));
		String[] cntrNo         =  (JSPUtil.getParameter(request, prefix + "cntr_no                  ".trim(), length));
		String[] cnmvYr         =  (JSPUtil.getParameter(request, prefix + "cnmv_yr                  ".trim(), length));
		String[] cnmvSeq        =  (JSPUtil.getParameter(request, prefix + "cnmv_seq                 ".trim(), length));
		String[] copStsCd       =  (JSPUtil.getParameter(request, prefix + "cop_sts_cd               ".trim(), length));
		String[] pctlNo         =  (JSPUtil.getParameter(request, prefix + "pctl_no                  ".trim(), length));
		String[] cntrTpszCd     =  (JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd             ".trim(), length));
		String[] porNodCd       =  (JSPUtil.getParameter(request, prefix + "por_nod_cd               ".trim(), length));
		String[] polCd          =  (JSPUtil.getParameter(request, prefix + "pol_cd                   ".trim(), length));
		String[] n1stTsPortCd   =  (JSPUtil.getParameter(request, prefix + "n1st_ts_port_cd          ".trim(), length));
		String[] n2ndTsPortCd   =  (JSPUtil.getParameter(request, prefix + "n2nd_ts_port_cd          ".trim(), length));
		String[] n3rdTsPortCd   =  (JSPUtil.getParameter(request, prefix + "n3rd_ts_port_cd          ".trim(), length));
		String[] podCd          =  (JSPUtil.getParameter(request, prefix + "pod_cd                   ".trim(), length));
		String[] delNodCd       =  (JSPUtil.getParameter(request, prefix + "del_nod_cd               ".trim(), length));
		String[] ttlTztmHrs     =  (JSPUtil.getParameter(request, prefix + "ttl_tztm_hrs             ".trim(), length));
		String[] prodRev        =  (JSPUtil.getParameter(request, prefix + "prod_rev                 ".trim(), length));
		String[] ttlExpnAmt     =  (JSPUtil.getParameter(request, prefix + "ttl_expn_amt             ".trim(), length));
		String[] cmAmt          =  (JSPUtil.getParameter(request, prefix + "cm_amt                   ".trim(), length));
		String[] trnkAvalTeuSpc =  (JSPUtil.getParameter(request, prefix + "trnk_aval_teu_spc        ".trim(), length));
		String[] obItchgCtnt    =  (JSPUtil.getParameter(request, prefix + "ob_itchg_ctnt            ".trim(), length));
		String[] ibItchgCtnt    =  (JSPUtil.getParameter(request, prefix + "ib_itchg_ctnt            ".trim(), length));
		String[] creOfcCd       =  (JSPUtil.getParameter(request, prefix + "cre_ofc_cd               ".trim(), length));
		String[] creUsrId       =  (JSPUtil.getParameter(request, prefix + "cre_usr_id               ".trim(), length));
		String[] creDt          =  (JSPUtil.getParameter(request, prefix + "cre_dt                   ".trim(), length));
		String[] updUsrId       =  (JSPUtil.getParameter(request, prefix + "upd_usr_id               ".trim(), length));
		String[] updDt          =  (JSPUtil.getParameter(request, prefix + "upd_dt                   ".trim(), length));
		String[] copSubStsCd    =  (JSPUtil.getParameter(request, prefix + "cop_sub_sts_cd			 ".trim(), length));
		String[] maxGrpSeq      =  (JSPUtil.getParameter(request, prefix + "max_grp_seq         	 ".trim(), length));
		String[] maxDtlSeq      =  (JSPUtil.getParameter(request, prefix + "max_dtl_seq          	 ".trim(), length));

        for (int i = 0; i < length; i++) {
            model = new SceCopHdrInfoVO();
            model.setIbflag                     ( ibflag               [i]);
            model.setPage_rows                  ( pageRows            [i]);
            model.setCop_no                     ( copNo               [i]);
            model.setBkg_no                     ( bkgNo               [i]);
            model.setBkg_no_split               ( bkgNoSplit         [i]);
            model.setCntr_no                    ( cntrNo              [i]);
            model.setCnmv_yr                    ( cnmvYr              [i]);
            model.setCnmv_seq                   ( cnmvSeq             [i]);
            model.setCop_sts_cd                 ( copStsCd           [i]);
            model.setPctl_no                    ( pctlNo              [i]);
            model.setCntr_tpsz_cd               ( cntrTpszCd         [i]);
            model.setPor_nod_cd                 ( porNodCd           [i]);
            model.setPol_cd                     ( polCd               [i]);
            model.setN1st_ts_port_cd            ( n1stTsPortCd      [i]);
            model.setN2nd_ts_port_cd            ( n2ndTsPortCd      [i]);
            model.setN3rd_ts_port_cd            ( n3rdTsPortCd      [i]);
            model.setPod_cd                     ( podCd               [i]);
            model.setDel_nod_cd                 ( delNodCd           [i]);
            model.setTtl_tztm_hrs               ( ttlTztmHrs         [i]);
            model.setProd_rev                   ( prodRev             [i]);
            model.setTtl_expn_amt               ( ttlExpnAmt         [i]);
            model.setCm_amt                     ( cmAmt               [i]);
            model.setTrnk_aval_teu_spc          ( trnkAvalTeuSpc    [i]);
            model.setOb_itchg_ctnt              ( obItchgCtnt        [i]);
            model.setIb_itchg_ctnt              ( ibItchgCtnt        [i]);
            model.setCre_ofc_cd                 ( creOfcCd           [i]);
            model.setCre_usr_id                 ( creUsrId           [i]);
            model.setCre_dt                     ( creDt               [i]);
            model.setUpd_usr_id                 ( updUsrId           [i]);
            model.setUpd_dt                     ( updDt               [i]);
            model.setCop_sub_sts_cd      		( copSubStsCd       [i]);
            model.setMax_grp_seq         		( maxGrpSeq          [i]);
            model.setMax_dtl_seq         		( maxDtlSeq          [i]);
            models.add(model);
        }

        return models;
    }
}
