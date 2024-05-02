/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PortLimitManagmentDBDAOSearchPortLimitsBkgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortLimitManagmentDBDAOSearchPortLimitsBkgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 관리 Port별 Port Limits BKG 정보를 조회한다.
	  * </pre>
	  */
	public PortLimitManagmentDBDAOSearchPortLimitsBkgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("plmt_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("plmt_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("plmt_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_lmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.integration").append("\n"); 
		query.append("FileName : PortLimitManagmentDBDAOSearchPortLimitsBkgRSQL").append("\n"); 
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
		query.append("SELECT		XX.LMT_WGT_TP_CD" ).append("\n"); 
		query.append("		,	XX.CGO_OPR_CD" ).append("\n"); 
		query.append("		,  	XX.BKG_NO" ).append("\n"); 
		query.append("		,  	XX.VSL_CD" ).append("\n"); 
		query.append("		,  	XX.SKD_VOY_NO" ).append("\n"); 
		query.append("		,  	XX.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                " ).append("\n"); 
		query.append("		, 	XX.PLMT_PORT_CD" ).append("\n"); 
		query.append("        ,   XX.PLMT_CLPT_IND_SEQ   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		,  	XX.POL_CD" ).append("\n"); 
		query.append("		,  	XX.POD_CD" ).append("\n"); 
		query.append("		,  	SUBSTR(PS.YD_CD,'6','7') 				AS POL_YD_CD" ).append("\n"); 
		query.append("		,  	XX.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("		,  	SUBSTR(PSS.YD_CD, '6','7') 				AS POD_YD_CD" ).append("\n"); 
		query.append("		,  	XX.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("		,  	XX.IMDG_CLSS_CD||IMDG_COMP_GRP_CD		AS IMDG_CLSS_CD" ).append("\n"); 
		query.append("		,  	XX.DG_CNTR_SEQ" ).append("\n"); 
		query.append("		,  	XX.CNTR_CGO_SEQ" ).append("\n"); 
		query.append("		,  	XX.IMDG_UN_NO" ).append("\n"); 
		query.append("		,  	XX.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("		,  	XX.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		,  	ROUND(XX.GRS_WGT, 2) 					AS GRS_WGT" ).append("\n"); 
		query.append("		,  	ROUND(XX.NET_WGT, 2) 					AS NET_WGT" ).append("\n"); 
		query.append("		,  	ROUND(XX.NET_EXPLO_WGT, 2) 				AS NET_EXPLO_WGT" ).append("\n"); 
		query.append("		,  	XX.DCGO_REF_NO" ).append("\n"); 
		query.append("		,  	TO_CHAR(XX.AUTH_DT, 'YYYY-MM-DD') 		AS AUTH_DT" ).append("\n"); 
		query.append("		,  	1 										AS CNTR_QTY" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("FROM        (" ).append("\n"); 
		query.append("            --===========================================================================" ).append("\n"); 
		query.append("            SELECT      PLMT.LMT_WGT_TP_CD, DCGO.*" ).append("\n"); 
		query.append("            FROM        (" ).append("\n"); 
		query.append("                        ------------- <<PORT LIMIT REGULATION>> -------------------------------------" ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("                        SELECT      A.PIER_TP_CD" ).append("\n"); 
		query.append("                             ,  A.PORT_CD" ).append("\n"); 
		query.append("                             ,  A.PORT_LMT_SEQ" ).append("\n"); 
		query.append("                             ,  A.FLSH_PNT_TEMP" ).append("\n"); 
		query.append("                             ,  A.LMT_WGT_TP_CD" ).append("\n"); 
		query.append("                             ,  A.IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append("                             ,  E.IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("                             ,  A.CNTR_TP_CD" ).append("\n"); 
		query.append("                             ,  B.IMDG_CLSS_CD" ).append("\n"); 
		query.append("                             ,  C.IMDG_COMP_GRP_CD " ).append("\n"); 
		query.append("                             ,  D.IMDG_UN_NO" ).append("\n"); 
		query.append("                             ,  DECODE(A.ARR_MAX_QTY  , 0, NULL, A.ARR_MAX_QTY  )  	AS ARR_MAX_QTY" ).append("\n"); 
		query.append("                             ,  DECODE(A.DCHG_MAX_QTY , 0, NULL, A.DCHG_MAX_QTY )   AS DCHG_MAX_QTY" ).append("\n"); 
		query.append("                             ,  DECODE(A.LOD_MAX_QTY  , 0, NULL, A.LOD_MAX_QTY  )   AS LOD_MAX_QTY" ).append("\n"); 
		query.append("                             ,  DECODE(A.DEP_MAX_QTY  , 0, NULL, A.DEP_MAX_QTY  )   AS DEP_MAX_QTY" ).append("\n"); 
		query.append("                             ,  A.PPT_EXPLO_FLG" ).append("\n"); 
		query.append("                             ,  A.PPT_PROHI_FLG" ).append("\n"); 
		query.append("                             ,  A.PORT_LMT_REP_DESC" ).append("\n"); 
		query.append("                             ,  A.ARR_DEP_PROHI_FLG" ).append("\n"); 
		query.append("                             ,  A.LDIS_APLY_TGT_FLG" ).append("\n"); 
		query.append("                        FROM    SCG_IMDG_PORT_LMT_MST          	A" ).append("\n"); 
		query.append("                             ,  SCG_IMDG_PORT_LMT_CLSS_CD      	B" ).append("\n"); 
		query.append("                             ,  SCG_IMDG_PORT_LMT_COMP_GRP     	C" ).append("\n"); 
		query.append("                             ,  SCG_IMDG_PORT_LMT_UN_NO        	D" ).append("\n"); 
		query.append("                             ,  SCG_IMDG_PORT_LMT_SUBS_RSK     	E" ).append("\n"); 
		query.append("                        WHERE   1 = 1" ).append("\n"); 
		query.append("                        AND    	A.PORT_CD             			= @[plmt_port_cd]" ).append("\n"); 
		query.append("                        AND    	A.PORT_LMT_SEQ        			= @[port_lmt_seq]" ).append("\n"); 
		query.append("                        AND    	A.PORT_CD                      = B.PORT_CD    		(+)" ).append("\n"); 
		query.append("                        AND     A.PORT_LMT_SEQ                 = B.PORT_LMT_SEQ  	(+)" ).append("\n"); 
		query.append("                        AND     B.PORT_CD                      = C.PORT_CD    		(+)" ).append("\n"); 
		query.append("                        AND     B.PORT_LMT_SEQ                 = C.PORT_LMT_SEQ  	(+)" ).append("\n"); 
		query.append("                        AND     B.IMDG_CLSS_CD                 = C.IMDG_CLSS_CD   	(+) 	/* 2016-04-21 */" ).append("\n"); 
		query.append("                        AND     A.PORT_CD                      = D.PORT_CD    		(+)" ).append("\n"); 
		query.append("                        AND     A.PORT_LMT_SEQ                 = D.PORT_LMT_SEQ  	(+)" ).append("\n"); 
		query.append("                        AND     A.PORT_CD                      = E.PORT_CD    		(+)" ).append("\n"); 
		query.append("                        AND     A.PORT_LMT_SEQ                 = E.PORT_LMT_SEQ  	(+)             " ).append("\n"); 
		query.append("                        ------------- <<PORT LIMIT REGULATION>> -------------------------------------" ).append("\n"); 
		query.append("                        )		PLMT" ).append("\n"); 
		query.append("                   ,    (" ).append("\n"); 
		query.append("                        ------------- <<DG CARGO INFORMATION>> --------------------------------------" ).append("\n"); 
		query.append("                        -- <<Own Booking SPCL CGO Info>> --------------------------------------------" ).append("\n"); 
		query.append("                        SELECT  COM_ConstantMgr_PKG.COM_getCompanyCode_FNC() 		AS CGO_OPR_CD" ).append("\n"); 
		query.append("                          	,  	BKG_NO" ).append("\n"); 
		query.append("                            ,   VSL_CD" ).append("\n"); 
		query.append("                            ,   SKD_VOY_NO" ).append("\n"); 
		query.append("                            ,   SKD_DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                            ,   PLMT_PORT_CD" ).append("\n"); 
		query.append("                            ,   PLMT_CLPT_IND_SEQ   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                            ,   POL_CD" ).append("\n"); 
		query.append("                            ,   POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                            ,   POD_CD" ).append("\n"); 
		query.append("                            ,   POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                            ,   DG_CNTR_SEQ" ).append("\n"); 
		query.append("                            ,   CNTR_CGO_SEQ" ).append("\n"); 
		query.append("                            ,   IMDG_CLSS_CD" ).append("\n"); 
		query.append("                            ,	IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append("                            ,   IMDG_UN_NO" ).append("\n"); 
		query.append("                            ,   IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("                            ,   CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                            ,   GRS_WGT" ).append("\n"); 
		query.append("                            ,   NET_WGT" ).append("\n"); 
		query.append("                            ,   NET_EXPLO_WGT" ).append("\n"); 
		query.append("                            ,   DCGO_REF_NO" ).append("\n"); 
		query.append("                            ,   AUTH_DT" ).append("\n"); 
		query.append("                            , 	IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append("                            , 	FLSH_PNT_CDO_TEMP" ).append("\n"); 
		query.append("                            , 	IMDG_SUBS_RSK_LBL_CD1" ).append("\n"); 
		query.append("                            , 	IMDG_SUBS_RSK_LBL_CD2" ).append("\n"); 
		query.append("                            , 	IMDG_SUBS_RSK_LBL_CD3" ).append("\n"); 
		query.append("                            , 	IMDG_SUBS_RSK_LBL_CD4                 " ).append("\n"); 
		query.append("                        FROM  	(" ).append("\n"); 
		query.append("                              	SELECT  A.BKG_NO" ).append("\n"); 
		query.append("                                	,  	A.VSL_CD" ).append("\n"); 
		query.append("                                	,  	A.SKD_VOY_NO" ).append("\n"); 
		query.append("                                	,  	A.SKD_DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                    ,   A.PLMT_PORT_CD" ).append("\n"); 
		query.append("                                    ,   A.PLMT_CLPT_IND_SEQ   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                	,  	A.POL_CD" ).append("\n"); 
		query.append("                                	,  	A.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                	,  	A.POD_CD" ).append("\n"); 
		query.append("                                	,  	A.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                	,  	A.DG_CNTR_SEQ" ).append("\n"); 
		query.append("                                	,  	A.CNTR_CGO_SEQ" ).append("\n"); 
		query.append("                                	,  	A.IMDG_CLSS_CD" ).append("\n"); 
		query.append("                                	,  	A.IMDG_UN_NO" ).append("\n"); 
		query.append("                                	,  	A.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("                                	,  	A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                	,  	A.GRS_WGT" ).append("\n"); 
		query.append("                                	,  	A.NET_WGT" ).append("\n"); 
		query.append("                                	,  	A.NET_EXPLO_WGT" ).append("\n"); 
		query.append("                                	,  	A.DCGO_REF_NO" ).append("\n"); 
		query.append("                               		,  	G.AUTH_DT" ).append("\n"); 
		query.append("                              		, 	A.IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append("                              		, 	A.FLSH_PNT_CDO_TEMP" ).append("\n"); 
		query.append("                              		, 	A.IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append("                              		, 	A.IMDG_SUBS_RSK_LBL_CD1" ).append("\n"); 
		query.append("                              		, 	A.IMDG_SUBS_RSK_LBL_CD2" ).append("\n"); 
		query.append("                              		, 	A.IMDG_SUBS_RSK_LBL_CD3" ).append("\n"); 
		query.append("                              		, 	A.IMDG_SUBS_RSK_LBL_CD4                    " ).append("\n"); 
		query.append("                                	,  	ROW_NUMBER() OVER (PARTITION BY NVL(G.BKG_NO,A.BKG_NO), NVL(G.SPCL_CGO_APRO_RQST_SEQ,A.SPCL_CGO_APRO_RQST_SEQ), NVL(G.VSL_PRE_PST_CD,A.VSL_PRE_PST_CD), NVL(G.VSL_SEQ,A.VSL_SEQ), NVL(G.DCGO_SEQ,A.DCGO_SEQ) ORDER BY G.DCGO_SEQ ASC) CORR_AUTH_SEQ" ).append("\n"); 
		query.append("                                FROM	(" ).append("\n"); 
		query.append("										SELECT    	SAR.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("			                                   	,  	SDC.BKG_NO" ).append("\n"); 
		query.append("			                                   	,  	SVAR.VSL_CD" ).append("\n"); 
		query.append("			                                   	,  	SVAR.SKD_VOY_NO" ).append("\n"); 
		query.append("			                                   	,  	SVAR.SKD_DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                                ,   @[plmt_port_cd] AS PLMT_PORT_CD" ).append("\n"); 
		query.append("                                                ,   VVPS.CLPT_IND_SEQ AS PLMT_CLPT_IND_SEQ   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			                                   	,  	SVAR.POL_CD" ).append("\n"); 
		query.append("			                                   	,  	SVAR.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("			                                   	,  	SVAR.POD_CD" ).append("\n"); 
		query.append("			                                   	,  	SVAR.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("			                                   	,  	SDC.DG_CNTR_SEQ           " ).append("\n"); 
		query.append("			                                   	,  	SDC.CNTR_CGO_SEQ          " ).append("\n"); 
		query.append("			                                   	,  	SDC.IMDG_CLSS_CD" ).append("\n"); 
		query.append("			                                   	,  	SDC.IMDG_UN_NO" ).append("\n"); 
		query.append("			                                   	,  	SDC.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("			                                   	,  	SDC.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("			                                   	,  	DECODE(SDC.WGT_UT_CD, 'LBS', TRS_COMMON_PKG.GET_CONV_WGT_TO_KG_FNC('LBS',SDC.GRS_WGT), SDC.GRS_WGT) 			AS GRS_WGT" ).append("\n"); 
		query.append("			                                   	,  	DECODE(SDC.WGT_UT_CD, 'LBS', TRS_COMMON_PKG.GET_CONV_WGT_TO_KG_FNC('LBS',SDC.NET_WGT), SDC.NET_WGT) 			AS NET_WGT" ).append("\n"); 
		query.append("			                                   	,  	DECODE(SDC.WGT_UT_CD, 'LBS', TRS_COMMON_PKG.GET_CONV_WGT_TO_KG_FNC('LBS',SDC.NET_EXPLO_WGT), SDC.NET_EXPLO_WGT) AS NET_EXPLO_WGT" ).append("\n"); 
		query.append("			                                   	,  	SDC.DCGO_REF_NO" ).append("\n"); 
		query.append("			                              		,  	SAR.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("			                              		,  	SVAR.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("			                              		,  	SVAR.VSL_SEQ" ).append("\n"); 
		query.append("			                              		,  	SDC.DCGO_SEQ" ).append("\n"); 
		query.append("			                              		, 	SDC.IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append("			                              		, 	SDC.FLSH_PNT_CDO_TEMP" ).append("\n"); 
		query.append("			                              		, 	SDC.IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append("			                              		, 	SDC.IMDG_SUBS_RSK_LBL_CD1" ).append("\n"); 
		query.append("			                              		, 	SDC.IMDG_SUBS_RSK_LBL_CD2" ).append("\n"); 
		query.append("			                              		, 	SDC.IMDG_SUBS_RSK_LBL_CD3" ).append("\n"); 
		query.append("			                              		, 	SDC.IMDG_SUBS_RSK_LBL_CD4" ).append("\n"); 
		query.append("			                            FROM   		BKG_DG_CGO        				SDC" ).append("\n"); 
		query.append("			                               		,  	SCG_APRO_RQST     				SAR" ).append("\n"); 
		query.append("			                               		,  	SCG_VVD_APRO_RQST 				SVAR" ).append("\n"); 
		query.append("                                                ,   VSK_VSL_PORT_SKD                VVPS" ).append("\n"); 
		query.append("												,   BKG_VVD							BVD" ).append("\n"); 
		query.append("			                            WHERE   	1 = 1" ).append("\n"); 
		query.append("			                            AND     	SAR.BKG_NO                      = SVAR.BKG_NO" ).append("\n"); 
		query.append("			                            --AND     	SAR.SPCL_CGO_CATE_CD            = 'DG'" ).append("\n"); 
		query.append("			                            AND     	SAR.SPCL_CGO_APRO_RQST_SEQ      = SVAR.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("										-- BDR 이후 POST VVD만 Request오는 경우 고려, LST_RQST_DAT_FLG='Y' 조건 대신 적용" ).append("\n"); 
		query.append("                                        AND SVAR.SPCL_CGO_APRO_RQST_SEQ 			= (SELECT MAX(RV.SPCL_CGO_APRO_RQST_SEQ) " ).append("\n"); 
		query.append("                                                                            			FROM SCG_VVD_APRO_RQST RV," ).append("\n"); 
		query.append("                                                                                             SCG_APRO_RQST RV2" ).append("\n"); 
		query.append("                                                                                     	WHERE RV.VSL_CD = BVD.VSL_CD" ).append("\n"); 
		query.append("                                                                                     	AND   RV.SKD_VOY_NO = BVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                                     	AND   RV.SKD_DIR_CD = BVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                                                     	AND   RV.BKG_NO = BVD.BKG_NO                                                                                                      " ).append("\n"); 
		query.append("                                                                                        AND   RV2.BKG_No = RV.BKG_NO" ).append("\n"); 
		query.append("                                                                                        AND RV.SPCL_CGO_APRO_RQST_SEQ = RV2.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("                                                                                        AND   RV2.SPCL_CGO_CATE_CD = 'DG'" ).append("\n"); 
		query.append("                                                                                       )" ).append("\n"); 
		query.append("			                            --AND     	SAR.LST_RQST_DAT_FLG            = 'Y'" ).append("\n"); 
		query.append("			                            AND     	SAR.BKG_NO                      = SDC.BKG_NO" ).append("\n"); 
		query.append("										AND         SAR.BKG_NO						= BVD.BKG_NO" ).append("\n"); 
		query.append("			                            AND     	SDC.SPCL_CGO_APRO_CD            NOT IN ('C','D','N')" ).append("\n"); 
		query.append("			                            AND   		EXISTS               			(" ).append("\n"); 
		query.append("			                                                        				SELECT	''" ).append("\n"); 
		query.append("			                                                          				FROM 	BKG_BOOKING 	C" ).append("\n"); 
		query.append("			                                                         				WHERE 	SDC.BKG_NO 		= C.BKG_NO" ).append("\n"); 
		query.append("			                                                           				AND 	C.BKG_STS_CD 	<> 'X'" ).append("\n"); 
		query.append("			                                                        				)" ).append("\n"); 
		query.append("			                            AND 		SAR.BKG_NO						IN ( #foreach(${key} in ${bkg_nos}) #if($velocityCount != 1) , #end '$key' #end )" ).append("\n"); 
		query.append("			                            AND 		SVAR.VSL_CD     				= @[vsl_cd]                                                                                                                                                                                                                                   " ).append("\n"); 
		query.append("		               				    AND	       	(" ).append("\n"); 
		query.append("													   (SVAR.SKD_VOY_NO = SUBSTR(@[plmt_vvd],1,4) AND SVAR.SKD_DIR_CD = SUBSTR(@[plmt_vvd],5,1))" ).append("\n"); 
		query.append("								 					OR (SVAR.SKD_VOY_NO = SUBSTR(@[plmt_vvd],7,4) AND SVAR.SKD_DIR_CD = SUBSTR(@[plmt_vvd],11,1))" ).append("\n"); 
		query.append("													)				                                                                                                                                                                                                                                 " ).append("\n"); 
		query.append("                                        AND         SVAR.VSL_CD                     = VVPS.VSL_CD" ).append("\n"); 
		query.append("                                        AND         SVAR.SKD_VOY_NO                 = VVPS.SKD_VOY_NO" ).append("\n"); 
		query.append("                                        AND         SVAR.SKD_DIR_CD                 = VVPS.SKD_DIR_CD " ).append("\n"); 
		query.append("                                        AND         SVAR.VSL_CD                     = BVD.VSL_CD" ).append("\n"); 
		query.append("                                        AND         SVAR.SKD_VOY_NO                 = BVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                                        AND         SVAR.SKD_DIR_CD                 = BVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                                        AND 		SVAR.BKG_NO                		= BVD.BKG_NO" ).append("\n"); 
		query.append("                                        AND 		SVAR.VSL_PRE_PST_CD        		= BVD.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("                                        AND 		SVAR.VSL_SEQ               		= BVD.VSL_SEQ										        " ).append("\n"); 
		query.append("                                        --AND         VVPS.TURN_PORT_IND_CD      IN ('Y','N')" ).append("\n"); 
		query.append("										--2016-08-18" ).append("\n"); 
		query.append("                                        --AND         NVL(SVAR.POL_CLPT_IND_SEQ,1)  = VVPS.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                        AND         VVPS.VPS_PORT_CD  =  @[plmt_port_cd]" ).append("\n"); 
		query.append("                       					AND 		VVPS.CLPT_IND_SEQ = @[plmt_clpt_ind_seq]" ).append("\n"); 
		query.append("																			--IN( SELECT SUB.CLPT_IND_SEQ " ).append("\n"); 
		query.append("																			--FROM VSK_VSL_PORT_SKD SUB" ).append("\n"); 
		query.append("                                                    						--WHERE SUB.VSL_CD = SVAR.VSL_CD" ).append("\n"); 
		query.append("                                                    						--AND   SUB.SKD_VOY_NO = SVAR.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                    						--AND   SUB.SKD_DIR_CD = SVAR.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                    						--AND   SUB.VPS_PORT_CD = [plmt_port_cd]  " ).append("\n"); 
		query.append("                                                    						--AND   SUB.TURN_PORT_IND_CD IN ('Y','N')" ).append("\n"); 
		query.append("                                                 							--)  " ).append("\n"); 
		query.append("                                        AND         NVL(VVPS.SKD_CNG_STS_CD,'*') <> 'S'" ).append("\n"); 
		query.append("										#if (${from_eta_dt} != '' && ${to_eta_dt} != '')" ).append("\n"); 
		query.append("										AND         VVPS.VPS_ETA_DT BETWEEN TO_DATE(@[from_eta_dt],'YYYY-MM-DD') AND TO_DATE(@[to_eta_dt],'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("										#end" ).append("\n"); 
		query.append("										--2016-08-18" ).append("\n"); 
		query.append("			                        	) 											A                   " ).append("\n"); 
		query.append("			                      	,	SCG_AUTHORIZATION 							G" ).append("\n"); 
		query.append("			                        " ).append("\n"); 
		query.append("			                    WHERE   A.BKG_NO                             		= G.BKG_NO           		(+)" ).append("\n"); 
		query.append("			                    AND     A.SPCL_CGO_CATE_CD                   		= G.SPCL_CGO_CATE_CD 		(+)" ).append("\n"); 
		query.append("			                    AND   	A.SPCL_CGO_APRO_RQST_SEQ       				= G.SPCL_CGO_APRO_RQST_SEQ	(+)" ).append("\n"); 
		query.append("			                    AND   	A.VSL_PRE_PST_CD                   			= G.VSL_PRE_PST_CD       	(+)" ).append("\n"); 
		query.append("			                    AND   	A.VSL_SEQ                           		= G.VSL_SEQ         		(+)" ).append("\n"); 
		query.append("			                    AND   	A.DCGO_SEQ                     				= G.DCGO_SEQ         		(+)" ).append("\n"); 
		query.append("			                                    " ).append("\n"); 
		query.append("			                    #if (${auth_flg} == 'A')" ).append("\n"); 
		query.append("			                    AND  	NVL(G.SPCL_CGO_AUTH_CD,'R')     			IN ('Y','R','P')" ).append("\n"); 
		query.append("			                    #elseif(${auth_flg} == 'Y')" ).append("\n"); 
		query.append("								AND  	NVL(G.SPCL_CGO_AUTH_CD,'R')     			= 'Y'" ).append("\n"); 
		query.append("			                    #elseif(${auth_flg} == 'R')" ).append("\n"); 
		query.append("								AND  	NVL(G.SPCL_CGO_AUTH_CD,'R')     			= 'R'" ).append("\n"); 
		query.append("			                    #elseif(${auth_flg} == 'P')" ).append("\n"); 
		query.append("								AND  	NVL(G.SPCL_CGO_AUTH_CD,'R')     			= 'P'" ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("			                                                                      " ).append("\n"); 
		query.append("			                    ) A" ).append("\n"); 
		query.append("			            WHERE 	CORR_AUTH_SEQ                						= 1" ).append("\n"); 
		query.append("                        -- <<Own Booking SPCL CGO Info>> --------------------------------------------" ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("                        UNION ALL" ).append("\n"); 
		query.append("                                    " ).append("\n"); 
		query.append("                        -- <<Partner Lines SPCL CGO Info>> ------------------------------------------" ).append("\n"); 
		query.append("                  		SELECT  SPAC.CGO_OPR_CD" ).append("\n"); 
		query.append("	                    	,  	SPAR.BKG_REF_NO" ).append("\n"); 
		query.append("	                        ,  	SPAR.VSL_CD" ).append("\n"); 
		query.append("	                        ,  	SPAR.SKD_VOY_NO" ).append("\n"); 
		query.append("	                        ,  	SPAR.SKD_DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                            ,   @[plmt_port_cd] AS PLMT_PORT_CD" ).append("\n"); 
		query.append("                            ,   VVPS.CLPT_IND_SEQ AS PLMT_CLPT_IND_SEQ  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	                        ,  	SPAR.POL_CD" ).append("\n"); 
		query.append("		                    ,  	NVL(SPAR.POL_CLPT_IND_SEQ,1)    AS POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("		                    ,  	SPAR.POD_CD" ).append("\n"); 
		query.append("		                    ,  	NVL(SPAR.POD_CLPT_IND_SEQ,1)    AS POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("		                    ,  	SPAC.SPCL_CNTR_SEQ" ).append("\n"); 
		query.append("		                    ,  	SPAC.SPCL_CGO_SEQ" ).append("\n"); 
		query.append("		                    ,  	SPAC.IMDG_CLSS_CD" ).append("\n"); 
		query.append("		                    , 	SPAC.IMDG_CO_GRP_CD" ).append("\n"); 
		query.append("		                    ,  	SPAC.IMDG_UN_NO" ).append("\n"); 
		query.append("		                    ,  	SPAC.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("		                    ,  	SPAC.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		                    ,  	DECODE(SPAC.WGT_UT_CD, 'LBS', TRS_COMMON_PKG.GET_CONV_WGT_TO_KG_FNC('LBS',SPAC.GRS_WGT), SPAC.GRS_WGT) 				AS GRS_WGT" ).append("\n"); 
		query.append("		                    ,  	DECODE(SPAC.WGT_UT_CD, 'LBS', TRS_COMMON_PKG.GET_CONV_WGT_TO_KG_FNC('LBS',SPAC.NET_WGT), SPAC.NET_WGT) 				AS NET_WGT" ).append("\n"); 
		query.append("		                    ,  	DECODE(SPAC.WGT_UT_CD, 'LBS', TRS_COMMON_PKG.GET_CONV_WGT_TO_KG_FNC('LBS',SPAC.NET_EXPLO_WGT), SPAC.NET_EXPLO_WGT) 	AS NET_EXPLO_WGT" ).append("\n"); 
		query.append("		                    ,  	SPAC.DCGO_REF_NO" ).append("\n"); 
		query.append("		                    ,  	SPAC.AUTH_DT" ).append("\n"); 
		query.append("                            , 	SPAC.IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append("                            , 	SPAC.FLSH_PNT_CDO_TEMP" ).append("\n"); 
		query.append("                            , 	SPAC.N1ST_IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("                            , 	SPAC.N2ND_IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("                            , 	SPAC.N3RD_IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("                            , 	SPAC.N4TH_IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("		                FROM    SCG_PRNR_APRO_RQST      							SPAR" ).append("\n"); 
		query.append("		                     ,  SCG_PRNR_APRO_RQST_CGO  							SPAC" ).append("\n"); 
		query.append("                             ,   VSK_VSL_PORT_SKD                VVPS" ).append("\n"); 
		query.append("		                WHERE   1 = 1" ).append("\n"); 
		query.append("		                AND     SPAR.CRR_CD            								= SPAC.CRR_CD" ).append("\n"); 
		query.append("		                AND     SPAR.BKG_REF_NO        								= SPAC.BKG_REF_NO" ).append("\n"); 
		query.append("		                AND     SPAR.PRNR_CGO_RQST_SEQ 								= SPAC.PRNR_CGO_RQST_SEQ" ).append("\n"); 
		query.append("		                AND     SPAR.SPCL_CGO_RQST_SEQ 								= SPAC.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("		                AND     SPAR.DG_FLG            								= 'Y'" ).append("\n"); 
		query.append("		                AND     SPAR.LST_RQST_DAT_FLG  								= 'Y'" ).append("\n"); 
		query.append("						AND		SPAR.BKG_REF_NO										IN ( #foreach(${key} in ${bkg_nos}) #if($velocityCount != 1) , #end '$key' #end )" ).append("\n"); 
		query.append("		                AND     SPAR.VSL_CD 										= @[vsl_cd]   " ).append("\n"); 
		query.append("		                AND	   (" ).append("\n"); 
		query.append("									(SPAR.SKD_VOY_NO = SUBSTR(@[plmt_vvd],1,4) AND SPAR.SKD_DIR_CD = SUBSTR(@[plmt_vvd],5,1))" ).append("\n"); 
		query.append("								 OR (SPAR.SKD_VOY_NO = SUBSTR(@[plmt_vvd],7,4) AND SPAR.SKD_DIR_CD = SUBSTR(@[plmt_vvd],11,1))" ).append("\n"); 
		query.append("								)				" ).append("\n"); 
		query.append("			            AND     SPAR.VSL_CD                     = VVPS.VSL_CD" ).append("\n"); 
		query.append("                        AND     SPAR.SKD_VOY_NO                 = VVPS.SKD_VOY_NO" ).append("\n"); 
		query.append("                        AND     SPAR.SKD_DIR_CD                 = VVPS.SKD_DIR_CD" ).append("\n"); 
		query.append("                        --AND     VVPS.TURN_PORT_IND_CD      IN ('Y','N')" ).append("\n"); 
		query.append("                        --AND     NVL(SPAR.POL_CLPT_IND_SEQ,1)  = VVPS.CLPT_IND_SEQ" ).append("\n"); 
		query.append("						--2016-08-18" ).append("\n"); 
		query.append("                        AND     VVPS.VPS_PORT_CD  =  @[plmt_port_cd]" ).append("\n"); 
		query.append("                        AND 	VVPS.CLPT_IND_SEQ  = @[plmt_clpt_ind_seq]" ).append("\n"); 
		query.append("														-- IN( SELECT SUB.CLPT_IND_SEQ " ).append("\n"); 
		query.append("														--FROM VSK_VSL_PORT_SKD SUB" ).append("\n"); 
		query.append("                                                    	--WHERE SUB.VSL_CD = SPAR.VSL_CD" ).append("\n"); 
		query.append("                                                    	--AND   SUB.SKD_VOY_NO = SPAR.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                    	--AND   SUB.SKD_DIR_CD = SPAR.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                    	--AND   SUB.VPS_PORT_CD = [plmt_port_cd]  " ).append("\n"); 
		query.append("                                                    	--AND   SUB.TURN_PORT_IND_CD IN ('Y','N')" ).append("\n"); 
		query.append("                                                 		--)   " ).append("\n"); 
		query.append("                        AND     NVL(VVPS.SKD_CNG_STS_CD,'*') <> 'S'" ).append("\n"); 
		query.append("						#if (${from_eta_dt} != '' && ${to_eta_dt} != '')" ).append("\n"); 
		query.append("						AND		VVPS.VPS_ETA_DT BETWEEN TO_DATE(@[from_eta_dt],'YYYY-MM-DD') AND TO_DATE(@[to_eta_dt],'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						--2016-08-18" ).append("\n"); 
		query.append("                        #if (${auth_flg} == 'A')" ).append("\n"); 
		query.append("                        AND  	NVL(SPAC.AUTH_STS_CD,'N/A')							IN ('Y','R','P')	" ).append("\n"); 
		query.append("                        #elseif(${auth_flg} == 'Y')" ).append("\n"); 
		query.append("						AND  	NVL(SPAC.AUTH_STS_CD,'N/A')							= 'Y'" ).append("\n"); 
		query.append("                        #elseif(${auth_flg} == 'R')" ).append("\n"); 
		query.append("						AND  	NVL(SPAC.AUTH_STS_CD,'N/A')							= 'R'" ).append("\n"); 
		query.append("                        #elseif(${auth_flg} == 'P')" ).append("\n"); 
		query.append("						AND  	NVL(SPAC.AUTH_STS_CD,'N/A')							= 'P'" ).append("\n"); 
		query.append("						#end                       " ).append("\n"); 
		query.append("                        -- <<Partner Lines SPCL CGO Info>> ------------------------------------------" ).append("\n"); 
		query.append("                        ------------- <<DG CARGO INFORMATION>> --------------------------------------" ).append("\n"); 
		query.append("                        ) DCGO" ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("            WHERE       1 = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      		AND		CASE	WHEN PLMT.IMDG_COMP_GRP_CD IS NOT NULL THEN PLMT.IMDG_CLSS_CD||PLMT.IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append("                 			ELSE " ).append("\n"); 
		query.append("                                CASE WHEN PLMT.IMDG_CLSS_CD IS NOT NULL THEN PLMT.IMDG_CLSS_CD" ).append("\n"); 
		query.append("                                     ELSE PLMT.IMDG_UN_NO" ).append("\n"); 
		query.append("                                END" ).append("\n"); 
		query.append("            		END			=	CASE	WHEN PLMT.IMDG_COMP_GRP_CD IS NOT NULL THEN DCGO.IMDG_CLSS_CD||DCGO.IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append("                                			ELSE " ).append("\n"); 
		query.append("                                            	CASE WHEN PLMT.IMDG_CLSS_CD IS NOT NULL THEN DCGO.IMDG_CLSS_CD" ).append("\n"); 
		query.append("                                                	 ELSE DCGO.IMDG_UN_NO" ).append("\n"); 
		query.append("                                                END" ).append("\n"); 
		query.append("                                    END" ).append("\n"); 
		query.append("            AND    		(PLMT.IMDG_UN_NO       			IS NULL OR PLMT.IMDG_UN_NO         		=  DCGO.IMDG_UN_NO      			)" ).append("\n"); 
		query.append("            AND    		(PLMT.CNTR_TP_CD       			IS NULL OR PLMT.CNTR_TP_CD         		=  SUBSTR(DCGO.CNTR_TPSZ_CD,1,1)    )" ).append("\n"); 
		query.append("            AND    		(PLMT.IMDG_SUBS_RSK_LBL_CD   	IS NULL OR PLMT.IMDG_SUBS_RSK_LBL_CD   IN (DCGO.IMDG_SUBS_RSK_LBL_CD1, DCGO.IMDG_SUBS_RSK_LBL_CD2, DCGO.IMDG_SUBS_RSK_LBL_CD3, DCGO.IMDG_SUBS_RSK_LBL_CD4))" ).append("\n"); 
		query.append("            AND    		(PLMT.FLSH_PNT_TEMP     		IS NULL OR PLMT.FLSH_PNT_TEMP       	>= DCGO.FLSH_PNT_CDO_TEMP  			)" ).append("\n"); 
		query.append("            AND    		(PLMT.IMDG_PCK_GRP_CD     		IS NULL OR PLMT.IMDG_PCK_GRP_CD 		=  DCGO.IMDG_PCK_GRP_CD				)" ).append("\n"); 
		query.append("            --===========================================================================" ).append("\n"); 
		query.append("            ) XX" ).append("\n"); 
		query.append("      ,     VSK_VSL_PORT_SKD    						PS" ).append("\n"); 
		query.append("      ,     VSK_VSL_PORT_SKD    						PSS" ).append("\n"); 
		query.append("WHERE       1 = 1" ).append("\n"); 
		query.append("AND         PS.VSL_CD           						= XX.VSL_CD" ).append("\n"); 
		query.append("AND         PS.SKD_VOY_NO       						= XX.SKD_VOY_NO" ).append("\n"); 
		query.append("AND         PS.SKD_DIR_CD       						= XX.SKD_DIR_CD" ).append("\n"); 
		query.append("AND         PS.VPS_PORT_CD      						= XX.POL_CD" ).append("\n"); 
		query.append("AND         PS.CLPT_IND_SEQ     						= XX.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND         PSS.VSL_CD           						= XX.VSL_CD" ).append("\n"); 
		query.append("AND         PSS.SKD_VOY_NO       						= XX.SKD_VOY_NO" ).append("\n"); 
		query.append("AND         PSS.SKD_DIR_CD       						= XX.SKD_DIR_CD" ).append("\n"); 
		query.append("AND         PSS.VPS_PORT_CD      						= XX.POD_CD" ).append("\n"); 
		query.append("AND         PSS.CLPT_IND_SEQ     						= XX.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND			NVL(PS.SKD_CNG_STS_CD	,'*')				<> 'S'" ).append("\n"); 
		query.append("AND			NVL(PSS.SKD_CNG_STS_CD	,'*')				<> 'S'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY    PS.CLPT_SEQ         ASC" ).append("\n"); 
		query.append("      	,	XX.CGO_OPR_CD		ASC" ).append("\n"); 
		query.append("		,	PSS.CLPT_SEQ        ASC" ).append("\n"); 
		query.append("		,	XX.BKG_NO			ASC" ).append("\n"); 
		query.append("		,	XX.DG_CNTR_SEQ		ASC" ).append("\n"); 
		query.append("		,	XX.CNTR_CGO_SEQ		ASC " ).append("\n"); 

	}
}