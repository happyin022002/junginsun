/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ReceiveEdiFromParnterLinesMgtDBDAOCreateScgPrnrAproRqstCgoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveEdiFromParnterLinesMgtDBDAOCreateScgPrnrAproRqstCgoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Partner사 승인요청 Cargo Detail
	  * </pre>
	  */
	public ReceiveEdiFromParnterLinesMgtDBDAOCreateScgPrnrAproRqstCgoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prnr_cgo_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_trsm_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prnr_spcl_cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.integration").append("\n"); 
		query.append("FileName : ReceiveEdiFromParnterLinesMgtDBDAOCreateScgPrnrAproRqstCgoCSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("INSERT INTO  SCG_PRNR_APRO_RQST_CGO" ).append("\n"); 
		query.append("    (  CRR_CD" ).append("\n"); 
		query.append("    ,  BKG_REF_NO" ).append("\n"); 
		query.append("    ,  SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("	,  PRNR_CGO_RQST_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,  SPCL_CNTR_SEQ" ).append("\n"); 
		query.append("    ,  SPCL_CGO_SEQ" ).append("\n"); 
		query.append("    ,  CGO_OPR_CD" ).append("\n"); 
		query.append("    ,  SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("    ,  CNTR_REF_NO" ).append("\n"); 
		query.append("    ,  CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    ,  IMDG_UN_NO" ).append("\n"); 
		query.append("    ,  IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("    ,  IMDG_CLSS_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,  N1ST_IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("    ,  N2ND_IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("    ,  N3RD_IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("    ,  N4TH_IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("    ,  N5TH_IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("    ,  N6TH_IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("    ,  N7TH_IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("    ,  N8TH_IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,  IMDG_CO_GRP_CD" ).append("\n"); 
		query.append("    ,  IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append("    ,  IMDG_LMT_QTY_FLG" ).append("\n"); 
		query.append("    ,  IMDG_EXPT_QTY_FLG" ).append("\n"); 
		query.append("    ,  MRN_POLUT_FLG" ).append("\n"); 
		query.append("    ,  FLSH_PNT_CDO_TEMP" ).append("\n"); 
		query.append("    ,  PRP_SHP_NM" ).append("\n"); 
		query.append("    ,  HZD_DESC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    --,  DCGO_STS_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ----,  MEAS_QTY" ).append("\n"); 
		query.append("    ,  MEAS_TP_CD" ).append("\n"); 
		query.append("    ----,  PCK_QTY" ).append("\n"); 
		query.append("    ,  PCK_TP_CD" ).append("\n"); 
		query.append("    ----,  CLOD_FLG" ).append("\n"); 
		query.append("    ,  SPCL_STWG_RQST_DESC" ).append("\n"); 
		query.append("    ,  CGO_LCL_FLG" ).append("\n"); 
		query.append("    ,  EMER_RSPN_GID_NO" ).append("\n"); 
		query.append("    ,  EMER_RSPN_GID_CHR_NO" ).append("\n"); 
		query.append("    ,  EMER_CNTC_PHN_NO" ).append("\n"); 
		query.append("    ,  EMER_CNTC_PSON_NM" ).append("\n"); 
		query.append("    ,  EMER_TEMP_CTNT" ).append("\n"); 
		query.append("    ,  CTRL_TEMP_CTNT" ).append("\n"); 
		query.append("    ,  EMS_NO" ).append("\n"); 
		query.append("    ,  CMDT_DESC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,  NET_WGT" ).append("\n"); 
		query.append("    ,  GRS_WGT" ).append("\n"); 
		query.append("    ,  WGT_UT_CD" ).append("\n"); 
		query.append("    ,  PSA_NO" ).append("\n"); 
		query.append("    ,  CERTI_NO" ).append("\n"); 
		query.append("    ,  IN_N1ST_IMDG_PCK_QTY" ).append("\n"); 
		query.append("    ,  IN_N1ST_IMDG_PCK_CD" ).append("\n"); 
		query.append("    ,  IN_N2ND_IMDG_PCK_QTY" ).append("\n"); 
		query.append("    ,  IN_N2ND_IMDG_PCK_CD" ).append("\n"); 
		query.append("    ,  INTMD_N1ST_IMDG_PCK_QTY" ).append("\n"); 
		query.append("    ,  INTMD_N1ST_IMDG_PCK_CD" ).append("\n"); 
		query.append("    ,  INTMD_N2ND_IMDG_PCK_QTY" ).append("\n"); 
		query.append("    ,  INTMD_N2ND_IMDG_PCK_CD" ).append("\n"); 
		query.append("    ,  OUT_N1ST_IMDG_PCK_QTY" ).append("\n"); 
		query.append("    ,  OUT_N1ST_IMDG_PCK_CD" ).append("\n"); 
		query.append("    ,  OUT_N2ND_IMDG_PCK_QTY" ).append("\n"); 
		query.append("    ,  OUT_N2ND_IMDG_PCK_CD" ).append("\n"); 
		query.append("    ,  MAX_IN_PCK_QTY" ).append("\n"); 
		query.append("    ,  MAX_IN_PCK_TP_CD" ).append("\n"); 
		query.append("    ,  CNEE_DTL_DESC" ).append("\n"); 
		query.append("    ,  NET_EXPLO_WGT" ).append("\n"); 
		query.append("    ,  RADA_SKD_NO" ).append("\n"); 
		query.append("    ,  RADA_AMT" ).append("\n"); 
		query.append("    ,  RADA_UT_CD" ).append("\n"); 
		query.append("    ,  DIFF_RMK" ).append("\n"); 
		query.append("    ,  CGO_RQST_DT" ).append("\n"); 
		query.append("    ,  AUTH_DT" ).append("\n"); 
		query.append("    ,  AUTH_OFC_CD" ).append("\n"); 
		query.append("    ,  AUTH_USR_ID" ).append("\n"); 
		query.append("    ,  AUTH_STS_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    -- ::2015-09-24:by TOP:: --,  APRO_REF_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,  CRE_USR_ID" ).append("\n"); 
		query.append("    ,  CRE_DT" ).append("\n"); 
		query.append("    ,  UPD_USR_ID" ).append("\n"); 
		query.append("    ,  UPD_DT" ).append("\n"); 
		query.append("    ,  RADA_TRSP_NO" ).append("\n"); 
		query.append("    ,  CFR_FLG" ).append("\n"); 
		query.append("    ,  CGO_UPD_STS_CD" ).append("\n"); 
		query.append("    ,  MVMT_SPCL_TP_CD" ).append("\n"); 
		query.append("    ,  ORG_PRP_SHP_NM" ).append("\n"); 
		query.append("    ,  ESP_NO" ).append("\n"); 
		query.append("    ,  IMDG_PPR_NO" ).append("\n"); 
		query.append("    ,  MFAG_NO" ).append("\n"); 
		query.append("    ,  IMDG_TEC_NM" ).append("\n"); 
		query.append("    ,  OUT_N1ST_IMDG_PCK_DESC" ).append("\n"); 
		query.append("    ,  INTMD_N1ST_IMDG_PCK_DESC" ).append("\n"); 
		query.append("    ,  IN_N1ST_IMDG_PCK_DESC" ).append("\n"); 
		query.append("    ,  CFR_NO" ).append("\n"); 
		query.append("    ,  RSD_FLG" ).append("\n"); 
		query.append("    ,  CNTR_DMY_REF_NO" ).append("\n"); 
		query.append("    ,  REF_NO" ).append("\n"); 
		query.append("    ,  SPCL_CGO_AUTH_RJCT_CD" ).append("\n"); 
		query.append("    ,  SPCL_CGO_AUTH_RMK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    --,  IMDG_SEGR_GRP_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,  DCGO_REF_NO" ).append("\n"); 
		query.append("    ,  SPCL_RQST_FLG" ).append("\n"); 
		query.append("    ,  EDW_UPD_DT" ).append("\n"); 
		query.append("    ,  IMDG_AMDT_NO" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    ,  DCGO_SEQ  " ).append("\n"); 
		query.append("	,  EDI_PRP_SHP_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,  EDI_CGO_UNMAP_DTL_CD" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("	--::2015-10-22::--" ).append("\n"); 
		query.append("	,  DCGO_STS_CD" ).append("\n"); 
		query.append("	,  IMDG_SEGR_GRP_NO" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT       " ).append("\n"); 
		query.append("       X.EDI_RCVR_ID        					/* CRR_CD            			*/                    " ).append("\n"); 
		query.append("    ,  X.BKG_REF_NO                         	/* BKG_REF_NO                   */   " ).append("\n"); 
		query.append("    ,  @[spcl_cgo_rqst_seq]						/* SPCL_CGO_RQST_SEQ            */   " ).append("\n"); 
		query.append("	,  @[prnr_cgo_rqst_seq]			 			/* PRNR_CGO_RQST_SEQ 			*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,  Y.CNTR_SEQ               				/* SPCL_CNTR_SEQ                */   " ).append("\n"); 
		query.append("    ,  Y.CGO_SEQ           						/* SPCL_CGO_SEQ                 */   " ).append("\n"); 
		query.append("    ,  X.CGO_OPR_CD                     		/* CGO_OPR_CD                   */   " ).append("\n"); 
		query.append("    ,  X.SPCL_CGO_CATE_CD                 		/* SPCL_CGO_CATE_CD             */   " ).append("\n"); 
		query.append("    ,  Y.CNTR_REF_NO               				/* CNTR_REF_NO                  */   " ).append("\n"); 
		query.append("    ,  Y.CNTR_TPSZ_CD_CTNT                		/* CNTR_TPSZ_CD                 */   " ).append("\n"); 
		query.append("    ,  Y.IMDG_UN_NO_CTNT                        /* IMDG_UN_NO                   */   " ).append("\n"); 
		query.append("    ,  Y.IMDG_UN_NO_SEQ                         /* IMDG_UN_NO_SEQ               */   " ).append("\n"); 
		query.append("    ,  Y.IMDG_CLSS_CD_CTNT                		/* IMDG_CLSS_CD                 */   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	-- ::2015-07-25:by TOP:: --" ).append("\n"); 
		query.append("    ,  (SELECT CL.IMDG_CLSS_CD FROM SCG_IMDG_CLSS_CD CL WHERE CL.IMDG_CLSS_CD = Y.N1ST_IMDG_SUBS_RSK_LBL_CD)	/* N1ST_IMDG_SUBS_RSK_LBL_CD    */" ).append("\n"); 
		query.append("    ,  (SELECT CL.IMDG_CLSS_CD FROM SCG_IMDG_CLSS_CD CL WHERE CL.IMDG_CLSS_CD = Y.N2ND_IMDG_SUBS_RSK_LBL_CD)	/* N2ND_IMDG_SUBS_RSK_LBL_CD    */" ).append("\n"); 
		query.append("    ,  (SELECT CL.IMDG_CLSS_CD FROM SCG_IMDG_CLSS_CD CL WHERE CL.IMDG_CLSS_CD = Y.N3RD_IMDG_SUBS_RSK_LBL_CD)	/* N3RD_IMDG_SUBS_RSK_LBL_CD    */" ).append("\n"); 
		query.append("    ,  (SELECT CL.IMDG_CLSS_CD FROM SCG_IMDG_CLSS_CD CL WHERE CL.IMDG_CLSS_CD = Y.N4TH_IMDG_SUBS_RSK_LBL_CD)	/* N4TH_IMDG_SUBS_RSK_LBL_CD    */" ).append("\n"); 
		query.append("    ,  (SELECT CL.IMDG_CLSS_CD FROM SCG_IMDG_CLSS_CD CL WHERE CL.IMDG_CLSS_CD = Y.N5TH_IMDG_SUBS_RSK_LBL_CD)	/* N5TH_IMDG_SUBS_RSK_LBL_CD    */" ).append("\n"); 
		query.append("    ,  (SELECT CL.IMDG_CLSS_CD FROM SCG_IMDG_CLSS_CD CL WHERE CL.IMDG_CLSS_CD = Y.N6TH_IMDG_SUBS_RSK_LBL_CD)	/* N6TH_IMDG_SUBS_RSK_LBL_CD    */" ).append("\n"); 
		query.append("    ,  (SELECT CL.IMDG_CLSS_CD FROM SCG_IMDG_CLSS_CD CL WHERE CL.IMDG_CLSS_CD = Y.N7TH_IMDG_SUBS_RSK_LBL_CD)	/* N7TH_IMDG_SUBS_RSK_LBL_CD    */" ).append("\n"); 
		query.append("    ,  (SELECT CL.IMDG_CLSS_CD FROM SCG_IMDG_CLSS_CD CL WHERE CL.IMDG_CLSS_CD = Y.N8TH_IMDG_SUBS_RSK_LBL_CD)	/* N8TH_IMDG_SUBS_RSK_LBL_CD    */" ).append("\n"); 
		query.append("                                                                        " ).append("\n"); 
		query.append("    ,  Y.IMDG_COMP_GRP_CD          				/* IMDG_CO_GRP_CD               */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,  DECODE(LTRIM(RTRIM(Y.IMDG_PCK_GRP_CD_CTNT)),'I','1','II','2','III','3',LTRIM(RTRIM(Y.IMDG_PCK_GRP_CD_CTNT)))	/* IMDG_PCK_GRP_CD              */" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("    ,  Y.IMDG_LMT_QTY_FLG_CTNT    				/* IMDG_LMT_QTY_FLG             */   " ).append("\n"); 
		query.append("    ,  Y.IMDG_EXPT_QTY_FLG_CTNT        			/* IMDG_EXPT_QTY_FLG            */   " ).append("\n"); 
		query.append("    ,  Y.IMDG_MRN_POLUT_FLG        				/* MRN_POLUT_FLG                */   " ).append("\n"); 
		query.append("    ,  Y.FLSH_PNT_TEMP_CTNT       				/* FLSH_PNT_CDO_TEMP            */   " ).append("\n"); 
		query.append("    ,  Y.PRP_SHP_NM           					/* PRP_SHP_NM                   */   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ----,  Y.HZD_DESC                        		/* HZD_DESC                     */   " ).append("\n"); 
		query.append("    ,  Y.IMDG_TEC_NM                       		/*IMDG_TEC_NM                   */   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	-- ::2015-07-25:by TOP:: --" ).append("\n"); 
		query.append("    --,  ''                      					/* DCGO_STS_CD                  */    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ----,  ''                     					/* MEAS_QTY                     */   " ).append("\n"); 
		query.append("    ,  ''               						/* MEAS_TP_CD                   */   " ).append("\n"); 
		query.append("    ----,  ''                     					/* PCK_QTY                      */   " ).append("\n"); 
		query.append("    ,  ''    									/* PCK_TP_CD                    */   " ).append("\n"); 
		query.append("    ----,  ''                  						/* CLOD_FLG                     */   " ).append("\n"); 
		query.append("    ,  ''                         				/* SPCL_STWG_RQST_DESC          */   " ).append("\n"); 
		query.append("    ,  ''                         				/* CGO_LCL_FLG                  */   " ).append("\n"); 
		query.append("    ,  ''             							/* EMER_RSPN_GID_NO             */   " ).append("\n"); 
		query.append("    ,  ''              							/* EMER_RSPN_GID_CHR_NO         */   " ).append("\n"); 
		query.append("    ,  Y.EMER_CNTC_PHN_NO            			/* EMER_CNTC_PHN_NO             */   " ).append("\n"); 
		query.append("    ,  Y.EMER_CNTC_PSON_NM                      /* EMER_CNTC_PSON_NM            */   " ).append("\n"); 
		query.append("    ,  ''                         				/* EMER_TEMP_CTNT               */   " ).append("\n"); 
		query.append("    ,  Y.CTRL_TEMP_CTNT            				/* CTRL_TEMP_CTNT               */   " ).append("\n"); 
		query.append("    ,  Y.EMS_NO              					/* EMS_NO                       */   " ).append("\n"); 
		query.append("    ,  ''          								/* CMDT_DESC                    */   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,  Y.NET_WGT_CTNT                    		/* NET_WGT                      */   " ).append("\n"); 
		query.append("    ,  Y.GRS_WGT_CTNT                        	/* GRS_WGT                      */   " ).append("\n"); 
		query.append("    ,  Y.GRS_WGT_UT_CD_CTNT                		/* WGT_UT_CD                    */   " ).append("\n"); 
		query.append("    ,  Y.PSA_NO               					/* PSA_NO                       */   " ).append("\n"); 
		query.append("    ,  ''                          				/* CERTI_NO                     */   " ).append("\n"); 
		query.append("    ,  NVL(Y.IN_N1ST_IMDG_PCK_QTY_CTNT,0)             	/* IN_N1ST_IMDG_PCK_QTY         */   " ).append("\n"); 
		query.append("    ,  Y.IN_N1ST_IMDG_PCK_CD_CTNT               /* IN_N1ST_IMDG_PCK_CD          */   " ).append("\n"); 
		query.append("    ,  0                  						/* IN_N2ND_IMDG_PCK_QTY         */   " ).append("\n"); 
		query.append("    ,  ''                						/* IN_N2ND_IMDG_PCK_CD          */   " ).append("\n"); 
		query.append("    ,  NVL(Y.INTMD_N1ST_IMDG_PCK_QTY_CTNT,0)           /* INTMD_N1ST_IMDG_PCK_QTY      */   " ).append("\n"); 
		query.append("    ,  Y.INTMD_N1ST_IMDG_PCK_CD_CTNT            /* INTMD_N1ST_IMDG_PCK_CD       */   " ).append("\n"); 
		query.append("    ,  0                          				/* INTMD_N2ND_IMDG_PCK_QTY      */   " ).append("\n"); 
		query.append("    ,  ''                      					/* INTMD_N2ND_IMDG_PCK_CD       */   " ).append("\n"); 
		query.append("    ,  NVL(Y.OUT_N1ST_IMDG_PCK_QTY_CTNT,0)             /* OUT_N1ST_IMDG_PCK_QTY        */   " ).append("\n"); 
		query.append("    ,  Y.OUT_N1ST_IMDG_PCK_CD_CTNT              /* OUT_N1ST_IMDG_PCK_CD         */   " ).append("\n"); 
		query.append("    ,  0                      					/* OUT_N2ND_IMDG_PCK_QTY        */   " ).append("\n"); 
		query.append("    ,  ''                        				/* OUT_N2ND_IMDG_PCK_CD         */   " ).append("\n"); 
		query.append("    ,  0                    					/* MAX_IN_PCK_QTY               */   " ).append("\n"); 
		query.append("    ,  ''                     					/* MAX_IN_PCK_TP_CD             */   " ).append("\n"); 
		query.append("    ,  ''                                       /*   CNEE_DTL_DESC              */   " ).append("\n"); 
		query.append("    ,  Y.NET_EXPLO_WGT_CTNT                     /*   NET_EXPLO_WGT              */   " ).append("\n"); 
		query.append("    ,  ''                      					/*   RADA_SKD_NO                */   " ).append("\n"); 
		query.append("    ,  0                                       	/*   RADA_AMT                   */   " ).append("\n"); 
		query.append("    ,  ''                                       /*   RADA_UT_CD                 */   " ).append("\n"); 
		query.append("    ,  Y.DIFF_RMK                               /*   DIFF_RMK                   */   " ).append("\n"); 
		query.append("    ,  SYSDATE                                  /*   CGO_RQST_DT                */   " ).append("\n"); 
		query.append("    ,  ''                                       /*   AUTH_DT                    */   " ).append("\n"); 
		query.append("    ,  ''                                       /*   AUTH_OFC_CD                */   " ).append("\n"); 
		query.append("    ,  ''                                       /*   AUTH_USR_ID                */   " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("	,  @[auth_sts_cd]							/*   AUTH_STS_CD >> 'R':REQUEST */   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    -- ::2015-09-24:by TOP:: --,  [apro_ref_no]                           /*   APRO_REF_NO                */   " ).append("\n"); 
		query.append("    ,  'EDI_AUTO_REQUEST'                       /*   CRE_USR_ID                 */   " ).append("\n"); 
		query.append("    ,  SYSDATE                                  /*   CRE_DT                     */   " ).append("\n"); 
		query.append("    ,  'EDI_AUTO_REQUEST'                       /*   UPD_USR_ID                 */   " ).append("\n"); 
		query.append("    ,  SYSDATE                                  /*   UPD_DT                     */   " ).append("\n"); 
		query.append("    ,  ''                                       /*   RADA_TRSP_NO               */   " ).append("\n"); 
		query.append("    ,  Y.CFR_FLG                                /*   CFR_FLG                    */   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	-- ::2015-07-25:by TOP:: --" ).append("\n"); 
		query.append("    ,  Y.CGO_UPD_STS_CD                         /*   CGO_UPD_STS_CD             */   " ).append("\n"); 
		query.append("    ,  ''                                       /*   MVMT_SPCL_TP_CD            */   " ).append("\n"); 
		query.append("    ,  Y.PRP_SHP_NM                             /*   ORG_PRP_SHP_NM             */   " ).append("\n"); 
		query.append("    ,  Y.ESP_NO                                 /*   ESP_NO                     */   " ).append("\n"); 
		query.append("    ,  Y.IMDG_PPR_NO                            /*   IMDG_PPR_NO                */   " ).append("\n"); 
		query.append("    ,  Y.MFAG_NO                                /*   MFAG_NO                    */   " ).append("\n"); 
		query.append("    ,  Y.IMDG_TEC_NM                            /*   IMDG_TEC_NM                */   " ).append("\n"); 
		query.append("    ,  Y.OUT_N1ST_IMDG_PCK_DESC                 /*   OUT_N1ST_IMDG_PCK_DESC     */   " ).append("\n"); 
		query.append("    ,  Y.INTMD_N1ST_IMDG_PCK_DESC               /*   INTMD_N1ST_IMDG_PCK_DESC   */   " ).append("\n"); 
		query.append("    ,  Y.IN_N1ST_IMDG_PCK_DESC                  /*   IN_N1ST_IMDG_PCK_DESC      */   " ).append("\n"); 
		query.append("    ,  Y.CFR_NO                                 /*   CFR_NO                     */   " ).append("\n"); 
		query.append("    ,  Y.RSD_FLG_CTNT                           /*   RSD_FLG                    */   " ).append("\n"); 
		query.append("    ,  Y.CNTR_DMY_REF_NO                        /*   CNTR_DMY_REF_NO            */   " ).append("\n"); 
		query.append("    ,  ''                                       /*   REF_NO                     */   " ).append("\n"); 
		query.append("    ,  ''                                       /*   SPCL_CGO_AUTH_RJCT_CD      */   " ).append("\n"); 
		query.append("    ,  ''                                       /*   SPCL_CGO_AUTH_RMK          */ " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	--::2015-10-22::-- " ).append("\n"); 
		query.append("    --,  Y.IMDG_ADD_SEGR_GRP_NO                   /*   IMDG_SEGR_GRP_NO           */" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("    ,  Y.DCGO_REF_NO                            /*   DCGO_REF_NO                */   " ).append("\n"); 
		query.append("    ,  ''                                       /*   SPCL_RQST_FLG              */   " ).append("\n"); 
		query.append("    ,  ''                                       /*   EDW_UPD_DT                 */   " ).append("\n"); 
		query.append("    ,  Y.IMDG_AMDT_NO                           /*   IMDG_AMDT_NO               */   " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    ,	CASE	WHEN @[edi_trsm_sts_cd] = 'N' THEN	Y.DCGO_SEQ" ).append("\n"); 
		query.append("				ELSE NULL" ).append("\n"); 
		query.append("		END            							/*     DCGO_SEQ  				*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,	Y.PRP_SHP_NM           					/* PRP_SHP_NM                   */ " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,	Y.EDI_CGO_UNMAP_DTL_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	--::2015-10-22::--" ).append("\n"); 
		query.append("	,	Y.DCGO_DTL_STS_CD" ).append("\n"); 
		query.append("	,	Y.IMDG_ADD_SEGR_GRP_NO" ).append("\n"); 
		query.append("FROM    SCG_PRNR_SPCL_CGO_TRSM_HDR     			X" ).append("\n"); 
		query.append("     ,  SCG_PRNR_SPCL_CGO_TRSM_DTL     			Y" ).append("\n"); 
		query.append("WHERE   X.TRSM_BND_CD                  			= Y.TRSM_BND_CD" ).append("\n"); 
		query.append("AND     X.TRSM_DT                      			= Y.TRSM_DT" ).append("\n"); 
		query.append("AND     X.SPCL_CGO_CATE_CD             			= Y.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("AND     X.PRNR_SPCL_CGO_SEQ            			= Y.PRNR_SPCL_CGO_SEQ                                                           " ).append("\n"); 
		query.append("AND		X.TRSM_BND_CD							= 'I'" ).append("\n"); 
		query.append("AND     X.SPCL_CGO_CATE_CD             			= 'DG'" ).append("\n"); 
		query.append("AND     X.TRSM_MZD_CD                  			= 'EDI'" ).append("\n"); 
		query.append("AND		X.TRSM_DT								= TO_DATE(@[trsm_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("AND		X.PRNR_SPCL_CGO_SEQ						= @[prnr_spcl_cgo_seq]" ).append("\n"); 

	}
}