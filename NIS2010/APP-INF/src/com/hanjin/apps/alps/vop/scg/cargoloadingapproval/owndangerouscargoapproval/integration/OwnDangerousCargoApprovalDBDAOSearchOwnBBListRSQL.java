/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : OwnDangerousCargoApprovalDBDAOSearchOwnBBListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnDangerousCargoApprovalDBDAOSearchOwnBBListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Break-Bulk 조회
	  * History------------------------------------------------------------------------------------
	  * 2012.04.04 김민아 [CHM-201216940-01] [VOP-SCG] Specail cargo applicaton 상 OPR code 관련 변경 요청
	  * </pre>
	  */
	public OwnDangerousCargoApprovalDBDAOSearchOwnBBListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_shp_opr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rqst_dt_range",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("booking_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : OwnDangerousCargoApprovalDBDAOSearchOwnBBListRSQL").append("\n"); 
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
		query.append("SELECT	ROW_NUMBER( ) OVER ( " ).append("\n"); 
		query.append("			PARTITION BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.BKG_NO" ).append("\n"); 
		query.append("            	ORDER BY A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD, A.BKG_NO, A.BB_CGO_SEQ ASC ) AS NO, " ).append("\n"); 
		query.append("		A.BKG_NO AS BOOKING_NO," ).append("\n"); 
		query.append("       	A.BKG_STS_CD,  " ).append("\n"); 
		query.append("       	A.BB_CGO_SEQ," ).append("\n"); 
		query.append("       	ROUND( GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE,'GMT') - A.RQST_GDT, 1 ) AS RQST_DAY," ).append("\n"); 
		query.append("        DECODE(NVL(G.SPCL_CGO_AUTH_CD,'R'),'R','R'||A.SPCL_CGO_RQST_SEQ, G.SPCL_CGO_AUTH_CD) AS SPCL_CGO_AUTH_CD," ).append("\n"); 
		query.append("       	G.SPCL_CGO_AUTH_RJCT_CD," ).append("\n"); 
		query.append("       	G.APRO_REF_NO," ).append("\n"); 
		query.append("	(	SELECT DECODE(EML_PROC_STS_CD,'1','W', " ).append("\n"); 
		query.append("                                      '3','S', " ).append("\n"); 
		query.append("                                      '4','F', " ).append("\n"); 
		query.append("                                      '') " ).append("\n"); 
		query.append("		FROM   COM_EML_SND_INFO " ).append("\n"); 
		query.append("        WHERE  EML_SND_NO = A.EML_SND_NO) AS EML_SND_NO, " ).append("\n"); 
		query.append("       	A.SLAN_CD," ).append("\n"); 
		query.append("       	A.VSL_CD," ).append("\n"); 
		query.append("       	A.SKD_VOY_NO," ).append("\n"); 
		query.append("       	A.SKD_DIR_CD," ).append("\n"); 
		query.append("        A.CRR_CD, " ).append("\n"); 
		query.append("		NVL(( SELECT DISTINCT CRR_CD" ).append("\n"); 
		query.append("              FROM   (" ).append("\n"); 
		query.append("                       SELECT  DISTINCT NVL(B.VSL_CD,A.VSL_CD) VSL_CD, " ).append("\n"); 
		query.append("                               NVL(B.CRR_CD,A.CRR_CD) CRR_CD, " ).append("\n"); 
		query.append("                               NVL(A.EFF_DT,B.EFF_DT) EFF_DT, " ).append("\n"); 
		query.append("                               NVL(A.EXP_DT,B.EXP_DT) EXP_DT" ).append("\n"); 
		query.append("                       FROM    (" ).append("\n"); 
		query.append("                                  SELECT  DECODE(V.VSL_CD,NULL,C.VSL_CD,V.VSL_CD)               VSL_CD," ).append("\n"); 
		query.append("                                             DECODE(C.FLET_CTRT_TP_CD,'OW','SML','TI','SML','OTH') CRR_CD," ).append("\n"); 
		query.append("                                             C.EFF_DT, " ).append("\n"); 
		query.append("                                             C.EXP_DT" ).append("\n"); 
		query.append("                                  FROM    FMS_CONTRACT C" ).append("\n"); 
		query.append("                                       ,  FMS_ID_VSL V" ).append("\n"); 
		query.append("                                  WHERE   NVL(C.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("                                  AND     C.FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("                                  AND     C.FLET_CTRT_NO = V.FLET_CTRT_NO(+)" ).append("\n"); 
		query.append("                                  AND  V.USE_FLG(+) = 'Y'" ).append("\n"); 
		query.append("                                  AND  C.FLET_CTRT_TP_CD = 'TI'" ).append("\n"); 
		query.append("                                  UNION ALL" ).append("\n"); 
		query.append("                                  SELECT  C.VSL_CD                VSL_CD," ).append("\n"); 
		query.append("                                          DECODE(C.FLET_CTRT_TP_CD,'OW','SML','TI','SML','OTH') CRR_CD," ).append("\n"); 
		query.append("                                          C.EFF_DT, " ).append("\n"); 
		query.append("                                          C.EXP_DT" ).append("\n"); 
		query.append("                                  FROM   FMS_CONTRACT C" ).append("\n"); 
		query.append("                                  WHERE  NVL(C.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("                                  AND     C.FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("                                  AND     C.FLET_CTRT_TP_CD = 'TI'" ).append("\n"); 
		query.append("                               ) A," ).append("\n"); 
		query.append("                               ( " ).append("\n"); 
		query.append("                                 SELECT  DECODE(V.VSL_CD,NULL,C.VSL_CD,V.VSL_CD)               VSL_CD," ).append("\n"); 
		query.append("                                         DECODE(C.FLET_CTRT_TP_CD,'OW','SML','TI','SML','OTH') CRR_CD," ).append("\n"); 
		query.append("                                         C.EFF_DT, " ).append("\n"); 
		query.append("                                         C.EXP_DT" ).append("\n"); 
		query.append("                                 FROM    FMS_CONTRACT C" ).append("\n"); 
		query.append("                                      ,  FMS_ID_VSL V" ).append("\n"); 
		query.append("                                 WHERE   NVL(C.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("                                 AND     C.FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("                                 AND     C.FLET_CTRT_NO = V.FLET_CTRT_NO(+)" ).append("\n"); 
		query.append("                                 AND     V.USE_FLG(+) = 'Y'" ).append("\n"); 
		query.append("                                 AND     C.FLET_CTRT_TP_CD = 'TO'" ).append("\n"); 
		query.append("                                 UNION ALL" ).append("\n"); 
		query.append("                                 SELECT  C.VSL_CD                 VSL_CD," ).append("\n"); 
		query.append("                                         DECODE(C.FLET_CTRT_TP_CD,'OW','SML','TI','SML','OTH') CRR_CD," ).append("\n"); 
		query.append("                                         C.EFF_DT, " ).append("\n"); 
		query.append("                                         C.EXP_DT" ).append("\n"); 
		query.append("                                  FROM    FMS_CONTRACT C" ).append("\n"); 
		query.append("                                  WHERE   NVL(C.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("                                  AND     C.FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("                                  AND     C.FLET_CTRT_TP_CD = 'TO'" ).append("\n"); 
		query.append("                                   ) B   " ).append("\n"); 
		query.append("                       WHERE A.VSL_CD = B.VSL_CD(+)" ).append("\n"); 
		query.append("                       UNION ALL" ).append("\n"); 
		query.append("                       SELECT  DISTINCT NVL(B.VSL_CD,A.VSL_CD) VSL_CD, " ).append("\n"); 
		query.append("                               NVL(B.CRR_CD,A.CRR_CD) CRR_CD, " ).append("\n"); 
		query.append("                               NVL(A.EFF_DT,B.EFF_DT) EFF_DT, " ).append("\n"); 
		query.append("                               NVL(A.EXP_DT,B.EXP_DT) EXP_DT" ).append("\n"); 
		query.append("                       FROM    (" ).append("\n"); 
		query.append("                                 SELECT  DECODE(V.VSL_CD,NULL,C.VSL_CD,V.VSL_CD)               VSL_CD," ).append("\n"); 
		query.append("                                         DECODE(C.FLET_CTRT_TP_CD,'OW','SML','TI','SML','OTH') CRR_CD," ).append("\n"); 
		query.append("                                         C.EFF_DT, " ).append("\n"); 
		query.append("                                         C.EXP_DT" ).append("\n"); 
		query.append("                                 FROM    FMS_CONTRACT C, FMS_ID_VSL V" ).append("\n"); 
		query.append("                                 WHERE   NVL(C.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("                                 AND     C.FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("                                 AND     C.FLET_CTRT_NO = V.FLET_CTRT_NO(+)" ).append("\n"); 
		query.append("                                 AND     V.USE_FLG(+) = 'Y'" ).append("\n"); 
		query.append("                                 AND     C.FLET_CTRT_TP_CD = 'OW'" ).append("\n"); 
		query.append("                                 UNION ALL" ).append("\n"); 
		query.append("                                 SELECT  C.VSL_CD                 VSL_CD," ).append("\n"); 
		query.append("                                         DECODE(C.FLET_CTRT_TP_CD,'OW','SML','TI','SML','OTH') CRR_CD," ).append("\n"); 
		query.append("                                         C.EFF_DT, " ).append("\n"); 
		query.append("                                         C.EXP_DT" ).append("\n"); 
		query.append("                                 FROM    FMS_CONTRACT C" ).append("\n"); 
		query.append("                                 WHERE   NVL(C.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("                                 AND     C.FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("                                 AND     C.FLET_CTRT_TP_CD = 'OW'" ).append("\n"); 
		query.append("                               ) A," ).append("\n"); 
		query.append("                               ( " ).append("\n"); 
		query.append("                                 SELECT  DECODE(V.VSL_CD,NULL,C.VSL_CD,V.VSL_CD)               VSL_CD," ).append("\n"); 
		query.append("                                         DECODE(C.FLET_CTRT_TP_CD,'OW','SML','TI','SML','OTH') CRR_CD," ).append("\n"); 
		query.append("                                         C.EFF_DT, " ).append("\n"); 
		query.append("                                         C.EXP_DT" ).append("\n"); 
		query.append("                                 FROM    FMS_CONTRACT C" ).append("\n"); 
		query.append("                                      ,  FMS_ID_VSL V" ).append("\n"); 
		query.append("                                 WHERE   NVL(C.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("                                 AND     C.FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("                                 AND     C.FLET_CTRT_NO = V.FLET_CTRT_NO(+)" ).append("\n"); 
		query.append("                                 AND     V.USE_FLG(+) = 'Y'" ).append("\n"); 
		query.append("                                 AND     C.FLET_CTRT_TP_CD = 'TO'" ).append("\n"); 
		query.append("                                 UNION ALL" ).append("\n"); 
		query.append("                                 SELECT  C.VSL_CD                 VSL_CD," ).append("\n"); 
		query.append("                                         DECODE(C.FLET_CTRT_TP_CD,'OW','SML','TI','SML','OTH') CRR_CD," ).append("\n"); 
		query.append("                                         C.EFF_DT, " ).append("\n"); 
		query.append("                                         C.EXP_DT" ).append("\n"); 
		query.append("                                 FROM    FMS_CONTRACT C" ).append("\n"); 
		query.append("                                 WHERE   NVL(C.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("                                 AND     C.FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("                                 AND     C.FLET_CTRT_TP_CD = 'TO'" ).append("\n"); 
		query.append("                               ) B   " ).append("\n"); 
		query.append("                       WHERE A.VSL_CD = B.VSL_CD(+)" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("              WHERE VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("              AND     (   TO_CHAR(A.VPS_ETA_DT,'YYYYMMDD') BETWEEN TO_CHAR(EFF_DT,'YYYYMMDD') AND TO_CHAR(EXP_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("                       OR TO_CHAR(A.VPS_ETA_DT,'YYYYMMDD') BETWEEN TO_CHAR(EFF_DT,'YYYYMMDD') AND TO_CHAR(EXP_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("                       OR ( TO_CHAR(EFF_DT,'YYYYMMDD') >= TO_CHAR(A.VPS_ETA_DT,'YYYYMMDD') AND TO_CHAR(EXP_DT,'YYYYMMDD') <= TO_CHAR(A.VPS_ETA_DT,'YYYYMMDD') ) " ).append("\n"); 
		query.append("                      )),A.CRR_CD) AS CRR_CODE, " ).append("\n"); 
		query.append("       	A.POR_CD," ).append("\n"); 
		query.append("       	A.POL_CD," ).append("\n"); 
		query.append("		TO_CHAR(A.VPS_ETA_DT,'YYYY-MM-DD HH24:MI') AS VPS_ETA_DT," ).append("\n"); 
		query.append("       	A.POD_CD," ).append("\n"); 
		query.append("       	A.DEL_CD," ).append("\n"); 
		query.append("	(	SELECT CMDT_NM FROM MDM_COMMODITY WHERE CMDT_CD = A.CMDT_CD) AS CMDT_NM," ).append("\n"); 
		query.append("	    A.DIM_LEN," ).append("\n"); 
		query.append("    	A.DIM_WDT," ).append("\n"); 
		query.append("	    A.DIM_HGT," ).append("\n"); 
		query.append("    	A.GRS_WGT," ).append("\n"); 
		query.append("        NVL(A.WGT_UT_CD,'KGS') AS WGT_UT_CD ," ).append("\n"); 
		query.append("	    A.OVR_VOID_SLT_QTY," ).append("\n"); 
		query.append("    	TO_CHAR(A.RQST_DT, 'YYYY-MM-DD HH24:MI') AS RQST_DT," ).append("\n"); 
		query.append("    	TO_CHAR(A.RQST_GDT, 'YYYY-MM-DD HH24:MI') AS RQST_GDT," ).append("\n"); 
		query.append("	    -- HIDDEN COLUMN --" ).append("\n"); 
		query.append("		A.BKG_NO, " ).append("\n"); 
		query.append("		A.SPCL_CGO_APRO_RQST_SEQ, " ).append("\n"); 
		query.append("		A.SPCL_CGO_RQST_SEQ," ).append("\n"); 
		query.append("		A.VSL_PRE_PST_CD," ).append("\n"); 
		query.append("		A.VSL_SEQ," ).append("\n"); 
		query.append("		A.SPCL_CGO_CATE_CD,		  	" ).append("\n"); 
		query.append("		A.BB_CGO_QTY," ).append("\n"); 
		query.append("		A.LST_RQST_DAT_FLG," ).append("\n"); 
		query.append("		A.BKG_RCV_TERM_CD," ).append("\n"); 
		query.append("		A.BKG_DE_TERM_CD," ).append("\n"); 
		query.append("		A.POL_CLPT_IND_SEQ,	" ).append("\n"); 
		query.append("    	A.POD_CLPT_IND_SEQ," ).append("\n"); 
		query.append("		A.POL_YD_CD," ).append("\n"); 
		query.append("		A.POD_YD_CD," ).append("\n"); 
		query.append("	    @[rgn_shp_opr_cd] ASRGN_SHP_OPR_CD, " ).append("\n"); 
		query.append("    	G.SPCL_CGO_AUTH_NO," ).append("\n"); 
		query.append("	    G.AUTH_OFC_CD," ).append("\n"); 
		query.append("    	G.SPCL_CGO_AUTH_SEQ,    " ).append("\n"); 
		query.append("	    -- HIDDEN COLUMN --" ).append("\n"); 
		query.append("    	-- HIDDEN COLUMN SCG-1017PAGE--" ).append("\n"); 
		query.append("	    '' AS SCG_FLG," ).append("\n"); 
		query.append("    	'' AS RQST_AUTH_CD," ).append("\n"); 
		query.append("		A.RQST_OFC_CD," ).append("\n"); 
		query.append("		A.RQST_USR_ID," ).append("\n"); 
		query.append("	    TO_CHAR(G.AUTH_DT, 'YYYY-MM-DD HH24:MI') AUTH_DT," ).append("\n"); 
		query.append("	    TO_CHAR(G.AUTH_GDT, 'YYYY-MM-DD HH24:MI') AUTH_GDT," ).append("\n"); 
		query.append("    	G.AUTH_USR_ID," ).append("\n"); 
		query.append("	    G.SPCL_CGO_AUTH_RMK" ).append("\n"); 
		query.append("    	-- HIDDEN COLUMN SCG-1015PAGE--" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("	(	SELECT	" ).append("\n"); 
		query.append("			#if (${scg_flg} == 'BB')" ).append("\n"); 
		query.append("				/*+ ORDERED USE_NL(B C V E D F A) */ " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("				A.BKG_NO," ).append("\n"); 
		query.append("	            A.BKG_STS_CD," ).append("\n"); 
		query.append("    	        C.SLAN_CD," ).append("\n"); 
		query.append("        	    A.OVR_VOID_SLT_QTY," ).append("\n"); 
		query.append("            	B.SPCL_CGO_APRO_RQST_SEQ," ).append("\n"); 
		query.append("	            B.SPCL_CGO_RQST_SEQ," ).append("\n"); 
		query.append("    	        B.BB_CGO_QTY," ).append("\n"); 
		query.append("        	    B.LST_RQST_DAT_FLG," ).append("\n"); 
		query.append("            	B.BKG_RCV_TERM_CD," ).append("\n"); 
		query.append("	            B.BKG_DE_TERM_CD,              " ).append("\n"); 
		query.append("    	        B.EML_SND_NO," ).append("\n"); 
		query.append("        	    B.POR_CD," ).append("\n"); 
		query.append("            	B.DEL_CD," ).append("\n"); 
		query.append("	            B.SPCL_CGO_CATE_CD," ).append("\n"); 
		query.append("    	        B.RQST_OFC_CD," ).append("\n"); 
		query.append("        	    B.RQST_DT," ).append("\n"); 
		query.append("        	    B.RQST_GDT," ).append("\n"); 
		query.append("            	B.RQST_USR_ID," ).append("\n"); 
		query.append("				C.VSL_CD," ).append("\n"); 
		query.append("    	        C.SKD_VOY_NO," ).append("\n"); 
		query.append("        	    C.SKD_DIR_CD," ).append("\n"); 
		query.append("            	C.POL_CD," ).append("\n"); 
		query.append("	            C.POD_CD," ).append("\n"); 
		query.append("    	        C.VSL_PRE_PST_CD," ).append("\n"); 
		query.append("        	    C.VSL_SEQ," ).append("\n"); 
		query.append("            	C.POL_CLPT_IND_SEQ," ).append("\n"); 
		query.append("	            C.POD_CLPT_IND_SEQ," ).append("\n"); 
		query.append("				C.POL_YD_CD," ).append("\n"); 
		query.append("				C.POD_YD_CD," ).append("\n"); 
		query.append("	            NVL(VVS.ACT_CRR_CD, D.CRR_CD)   AS CRR_CD," ).append("\n"); 
		query.append("        		F.BB_CGO_SEQ,      " ).append("\n"); 
		query.append("	    		F.DIM_LEN," ).append("\n"); 
		query.append("	    		F.DIM_WDT," ).append("\n"); 
		query.append("		    	F.DIM_HGT," ).append("\n"); 
		query.append("    			F.GRS_WGT," ).append("\n"); 
		query.append("                F.WGT_UT_CD," ).append("\n"); 
		query.append("        		F.CMDT_CD," ).append("\n"); 
		query.append("				V.VPS_ETA_DT" ).append("\n"); 
		query.append("		FROM	SCG_APRO_RQST B, " ).append("\n"); 
		query.append("                SCG_VVD_APRO_RQST C, " ).append("\n"); 
		query.append("                MDM_VSL_CNTR D," ).append("\n"); 
		query.append("			#if (${scg_flg} == 'SCG_BB')" ).append("\n"); 
		query.append("		  		SCG_BB_CGO F," ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("			  	BKG_BB_CGO F," ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("                BKG_BOOKING A," ).append("\n"); 
		query.append("				VSK_VSL_PORT_SKD V," ).append("\n"); 
		query.append("				VSK_VSL_SKD VVS" ).append("\n"); 
		query.append("		WHERE	B.SPCL_CGO_CATE_CD 			= 'BB' " ).append("\n"); 
		query.append("		AND		B.LST_RQST_DAT_FLG 			= 'Y' " ).append("\n"); 
		query.append("        AND		B.BKG_NO 					= C.BKG_NO " ).append("\n"); 
		query.append("		AND 	B.SPCL_CGO_APRO_RQST_SEQ 	= C.SPCL_CGO_APRO_RQST_SEQ " ).append("\n"); 
		query.append("		AND 	C.VSL_CD 					= D.VSL_CD " ).append("\n"); 
		query.append("		AND 	D.DELT_FLG 					= 'N' " ).append("\n"); 
		query.append("		AND 	B.BKG_NO 					= F.BKG_NO " ).append("\n"); 
		query.append("		AND 	F.SPCL_CGO_APRO_CD 			IS NOT NULL " ).append("\n"); 
		query.append("		AND 	V.VSL_CD 					= C.VSL_CD" ).append("\n"); 
		query.append("        AND 	V.SKD_VOY_NO 				= C.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND 	V.SKD_DIR_CD 				= C.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND 	V.VPS_PORT_CD 				= C.POL_CD" ).append("\n"); 
		query.append("		AND 	V.CLPT_IND_SEQ 				= C.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("		AND 	B.BKG_NO 					= A.BKG_NO" ).append("\n"); 
		query.append("        AND 	V.VSL_CD        			= VVS.VSL_CD" ).append("\n"); 
		query.append("        AND 	V.SKD_VOY_NO    			= VVS.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND 	V.SKD_DIR_CD    			= VVS.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND 	V.SLAN_CD    				= VVS.VSL_SLAN_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${scg_flg} == 'BB')" ).append("\n"); 
		query.append("		#if (${rqst_dt_range} != '')" ).append("\n"); 
		query.append("        	AND 	B.RQST_DT 					> SYSTIMESTAMP - @[rqst_dt_range]  --300" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("        	AND 	B.RQST_DT 					> SYSTIMESTAMP - 15   " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${vps_eta_dt} != '')" ).append("\n"); 
		query.append("        	AND 	V.VPS_ETA_DT 				> SYSTIMESTAMP - @[vps_eta_dt]  --300" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("        	AND 	V.VPS_ETA_DT 				> SYSTIMESTAMP - 30   " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		AND 	F.SPCL_CGO_APRO_CD 			NOT IN ('C','D','N')" ).append("\n"); 
		query.append("		AND 	A.BKG_STS_CD 				!= 'X'" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND 	A.BKG_STS_CD 				!= 'X'" ).append("\n"); 
		query.append("    	AND   	B.SPCL_CGO_APRO_RQST_SEQ 	= F.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("		AND 	F.SPCL_CGO_APRO_CD 			NOT IN ('C','D')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if ($slan_cd.size() > 0) " ).append("\n"); 
		query.append("		AND 	C.SLAN_CD IN ( " ).append("\n"); 
		query.append("				#foreach($key IN ${slan_cd}) " ).append("\n"); 
		query.append("					#if($velocityCount < $slan_cd.size()) " ).append("\n"); 
		query.append("						'$key', " ).append("\n"); 
		query.append("					#else " ).append("\n"); 
		query.append("						'$key' " ).append("\n"); 
		query.append("					#end " ).append("\n"); 
		query.append("				#end " ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${vsl_cd} != '') " ).append("\n"); 
		query.append("		AND		C.VSL_CD 			IN ( @[vsl_cd] )" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${imdg_un_no} != '') " ).append("\n"); 
		query.append("		AND 	F.IMDG_UN_NO 		= @[imdg_un_no]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${imdg_un_no_seq} != '') " ).append("\n"); 
		query.append("	 	AND 	F.IMDG_UN_NO_SEQ 	= @[imdg_un_no_seq]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${imdg_clss_cd} != '') " ).append("\n"); 
		query.append("		AND 	F.IMDG_CLSS_CD 		= @[imdg_clss_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${skd_voy_no} != '') " ).append("\n"); 
		query.append("		AND		C.SKD_VOY_NO 		IN ( @[skd_voy_no] )" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${skd_dir_cd} != '') " ).append("\n"); 
		query.append("		AND 	C.SKD_DIR_CD 		IN ( @[skd_dir_cd] )" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#if (${pol_cd} != '') " ).append("\n"); 
		query.append("		AND 	C.POL_CD 			= @[pol_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${pod_cd} != '') " ).append("\n"); 
		query.append("		AND 	C.POD_CD 			= @[pod_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${val_opr_tp_cd} == 'H') " ).append("\n"); 
		query.append("		AND 	NVL(VVS.ACT_CRR_CD, D.CRR_CD)	= 'SML'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#if (${val_opr_tp_cd} == 'O') " ).append("\n"); 
		query.append("		AND		NVL(VVS.ACT_CRR_CD, D.CRR_CD)	!= 'SML'" ).append("\n"); 
		query.append("	#end  	" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#if (${booking_no} != '') " ).append("\n"); 
		query.append("    	AND 	A.BKG_NO 			= @[booking_no]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${shpr_nm} != '') " ).append("\n"); 
		query.append("    	AND 	A.BKG_NO IN (" ).append("\n"); 
		query.append("					SELECT 	SH.BKG_NO" ).append("\n"); 
		query.append("	        		FROM 	BKG_CUSTOMER SH" ).append("\n"); 
		query.append("    	    		WHERE 	SH.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("        			AND 	SH.CUST_NM LIKE '%'||@[shpr_nm]||'%'" ).append("\n"); 
		query.append("	    		)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    --For Approved Details" ).append("\n"); 
		query.append("    #if (${from_eta_dt} != '' && ${to_eta_dt} != '') " ).append("\n"); 
		query.append("        AND V.VPS_ETA_DT BETWEEN TO_DATE(@[from_eta_dt],'YYYYMMDD') AND TO_DATE(@[to_eta_dt],'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("	#elseif (${from_eta_dt} != '') " ).append("\n"); 
		query.append("		AND DECODE(C.VSL_PRE_PST_CD,'U',V.VPS_ETA_DT,B.RQST_DT)	<= GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE,BKG_COM_USER_LOC_FNC(@[usr_id])) + TO_NUMBER(@[from_eta_dt])" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	) A" ).append("\n"); 
		query.append("	, SCG_AUTHORIZATION G" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE A.BKG_NO 						= G.BKG_NO(+)" ).append("\n"); 
		query.append("AND   A.SPCL_CGO_APRO_RQST_SEQ 		= G.SPCL_CGO_APRO_RQST_SEQ(+)" ).append("\n"); 
		query.append("AND   A.VSL_PRE_PST_CD         		= G.VSL_PRE_PST_CD(+)" ).append("\n"); 
		query.append("AND   A.VSL_SEQ                		= G.VSL_SEQ(+)" ).append("\n"); 
		query.append("AND   A.BB_CGO_SEQ            		= G.BB_CGO_SEQ(+)" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("	       @[rgn_shp_opr_cd] = " ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT RGN_SHP_OPR_CD FROM SCG_RGN_SHP_OPR_PORT" ).append("\n"); 
		query.append("            WHERE   A.POL_CD 					= LOC_CD " ).append("\n"); 
		query.append("--            WHERE   'CNSHA' 					= LOC_CD " ).append("\n"); 
		query.append("            AND     DELT_FLG 					= 'N'" ).append("\n"); 
		query.append("            AND		RGN_SHP_OPR_CD 	= @[rgn_shp_opr_cd]" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        OR" ).append("\n"); 
		query.append("          @[rgn_shp_opr_cd] = " ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("--    		SELECT 2, RGN_SHP_OPR_CD, A.POL_CD   FROM    SCG_RGN_SHP_OPR_CD" ).append("\n"); 
		query.append("    		SELECT RGN_SHP_OPR_CD   FROM    SCG_RGN_SHP_OPR_CD" ).append("\n"); 
		query.append("            WHERE   (" ).append("\n"); 
		query.append("            SELECT OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("            FROM DMT_OFC_LVL_V" ).append("\n"); 
		query.append("            WHERE OFC_N8TH_LVL_CD = (SELECT  EQ_CTRL_OFC_CD FROM MDM_LOCATION" ).append("\n"); 
		query.append("            WHERE   NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("            AND     LOC_CD  =   A.POL_CD))" ).append("\n"); 
		query.append("            IN (RGN_SHP_OPR_RHQ_CD1, RGN_SHP_OPR_RHQ_CD2, RGN_SHP_OPR_RHQ_CD3, RGN_SHP_OPR_RHQ_CD4, RGN_SHP_OPR_RHQ_CD5, RGN_SHP_OPR_RHQ_CD6)" ).append("\n"); 
		query.append("            AND RGN_SHP_OPR_CD 	= @[rgn_shp_opr_cd]" ).append("\n"); 
		query.append("			UNION" ).append("\n"); 
		query.append("			SELECT RGN_SHP_OPR_CD   FROM    SCG_RGN_SHP_OPR_CD" ).append("\n"); 
		query.append("            WHERE   (" ).append("\n"); 
		query.append("					SELECT	DECODE(SYS_AREA_GRP_ID, 'SWA', 'SINRS', 'EUR', 'HAMRU', 'USA', 'NYCRA', 'KOR', 'SHARC', 'CHN', 'SHARC')" ).append("\n"); 
		query.append("                    FROM	COM_SYS_AREA_GRP_ID A, MDM_LOCATION B" ).append("\n"); 
		query.append("                    WHERE	A.CO_IND_CD = 'H'" ).append("\n"); 
		query.append("                    	AND A.CNT_CD = SUBSTR(B.LOC_CD, 1, 2)" ).append("\n"); 
		query.append("                    	AND EQ_CTRL_OFC_CD IS NULL" ).append("\n"); 
		query.append("                    AND   NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                    AND NVL(CALL_PORT_FLG, 'N') = 'Y'" ).append("\n"); 
		query.append("                    AND     B.LOC_CD  =   A.POL_CD)" ).append("\n"); 
		query.append("            IN (RGN_SHP_OPR_RHQ_CD1, RGN_SHP_OPR_RHQ_CD2, RGN_SHP_OPR_RHQ_CD3, RGN_SHP_OPR_RHQ_CD4, RGN_SHP_OPR_RHQ_CD5, RGN_SHP_OPR_RHQ_CD6)" ).append("\n"); 
		query.append("            AND RGN_SHP_OPR_CD 	= @[rgn_shp_opr_cd]" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#if (${auth_flg} == 'A') " ).append("\n"); 
		query.append("	AND	NVL(G.SPCL_CGO_AUTH_CD,'R')	IN ('R','P')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${auth_flg} == 'P') " ).append("\n"); 
		query.append("	AND	G.SPCL_CGO_AUTH_CD 			= 'P'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${auth_flg} == 'R') " ).append("\n"); 
		query.append("	AND NVL(G.SPCL_CGO_AUTH_CD,'R') = 'R'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--For Approved Details" ).append("\n"); 
		query.append("#if (${auth_flg} == 'Y') " ).append("\n"); 
		query.append("	AND G.SPCL_CGO_AUTH_CD 			= 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${auth_flg} == 'N') " ).append("\n"); 
		query.append("	AND G.SPCL_CGO_AUTH_CD 			= 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${auth_flg} == 'YN') " ).append("\n"); 
		query.append("	AND G.SPCL_CGO_AUTH_CD 			IN ('Y','N')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--For Approved Details" ).append("\n"); 
		query.append("#if (${apro_ref_no} != '') " ).append("\n"); 
		query.append("	AND G.APRO_REF_NO 				= @[apro_ref_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY TO_CHAR(A.VPS_ETA_DT,'YYYY-MM-DD HH24:MI'), " ).append("\n"); 
		query.append("         A.SLAN_CD, " ).append("\n"); 
		query.append("         A.VSL_CD ," ).append("\n"); 
		query.append("         A.SKD_VOY_NO, " ).append("\n"); 
		query.append("         A.SKD_DIR_CD, " ).append("\n"); 
		query.append("         A.CRR_CD, " ).append("\n"); 
		query.append("         A.POL_CD, " ).append("\n"); 
		query.append("         A.POD_CD, " ).append("\n"); 
		query.append("         A.BKG_NO,  " ).append("\n"); 
		query.append("		 A.BB_CGO_SEQ" ).append("\n"); 

	}
}