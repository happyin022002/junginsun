/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScheduleNotificationManagementDBDAOSelectVslSkdCngNotificationTransmitTargetListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.05
*@LastModifier : 
*@LastVersion : 1.0
* 2013.12.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.schedulenotificationmanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScheduleNotificationManagementDBDAOSelectVslSkdCngNotificationTransmitTargetListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 개인별Notice설정정보를 기반으로 Notice 발송대상추출
	  * </pre>
	  */
	public ScheduleNotificationManagementDBDAOSelectVslSkdCngNotificationTransmitTargetListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.schedulenotificationmanagement.integration").append("\n"); 
		query.append("FileName : ScheduleNotificationManagementDBDAOSelectVslSkdCngNotificationTransmitTargetListRSQL").append("\n"); 
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
		query.append("SELECT           XX.VSL_CD                     		/* PK.VSL_CD            */           " ).append("\n"); 
		query.append("              ,  XX.SKD_VOY_NO                      /* PK.SKD_VOY_NO            */" ).append("\n"); 
		query.append("              ,  XX.SKD_DIR_CD                      /* PK.SKD_DIR_CD            */" ).append("\n"); 
		query.append("              ,  XX.VPS_PORT_CD                     /* PK.VPS_PORT_CD           */" ).append("\n"); 
		query.append("              ,  XX.CLPT_IND_SEQ                    /* PK.CLPT_IND_SEQ          */" ).append("\n"); 
		query.append("              ,  XX.USR_ID                          /* PK.USR_ID                */" ).append("\n"); 
		query.append("              ,  VSK_NTFC_TRSM_HIS_SEQ.NEXTVAL      /* PK.NTFC_TRSM_HIS_SEQ     */" ).append("\n"); 
		query.append("              --------------------------------------------------------------------" ).append("\n"); 
		query.append("              ,  XX.VVD_HIS_SEQ                  	/* VVD_HIS_SEQ            */" ).append("\n"); 
		query.append("              ,  XX.HIS_DTL_SEQ                     /* HIS_DTL_SEQ              */" ).append("\n"); 
		query.append("              ,  XX.VSL_SLAN_CD                     /* VSL_SLAN_CD              */" ).append("\n"); 
		query.append("              ,  NULL                AS TRSM_MZD_CD /* TRSM_MZD_CD              */" ).append("\n"); 
		query.append("              ,  XX.NTFC_TRSM_TP_CD" ).append("\n"); 
		query.append("              ,  TO_CHAR(XX.PF_ETA_DT  	,'YYYY-MM-DD HH24:MI')		AS PF_ETA_DT  " ).append("\n"); 
		query.append("              ,  TO_CHAR(XX.PF_ETB_DT  	,'YYYY-MM-DD HH24:MI')    	AS PF_ETB_DT  " ).append("\n"); 
		query.append("              ,  TO_CHAR(XX.PF_ETD_DT   ,'YYYY-MM-DD HH24:MI')    	AS PF_ETD_DT   " ).append("\n"); 
		query.append("              ,  TO_CHAR(XX.VPS_ETA_DT  ,'YYYY-MM-DD HH24:MI')    	AS VPS_ETA_DT  " ).append("\n"); 
		query.append("              ,  TO_CHAR(XX.VPS_ETB_DT  ,'YYYY-MM-DD HH24:MI')    	AS VPS_ETB_DT  " ).append("\n"); 
		query.append("              ,  TO_CHAR(XX.VPS_ETD_DT  ,'YYYY-MM-DD HH24:MI')    	AS VPS_ETD_DT  " ).append("\n"); 
		query.append("              ,  XX.PORT_SKP_TP_CD" ).append("\n"); 
		query.append("              ,  XX.BFR_YD_CD" ).append("\n"); 
		query.append("              ,  XX.CRNT_YD_CD" ).append("\n"); 
		query.append("              ,  XX.PAIR_RVS_PORT_CD" ).append("\n"); 
		query.append("              ,  XX.PAIR_RVS_CLPT_IND_SEQ" ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              ,  NVL2(XX.ETA_DELAY_HRS,TO_CHAR(ROUND(XX.ETA_DELAY_HRS*24,3),'FM999990.0'),NULL)  AS ETA_DELAY_HRS" ).append("\n"); 
		query.append("              ,  NVL2(XX.ETB_DELAY_HRS,TO_CHAR(ROUND(XX.ETB_DELAY_HRS*24,3),'FM999990.0'),NULL)  AS ETB_DELAY_HRS" ).append("\n"); 
		query.append("              ,  NVL2(XX.ETD_DELAY_HRS,TO_CHAR(ROUND(XX.ETD_DELAY_HRS*24,3),'FM999990.0'),NULL)  AS ETD_DELAY_HRS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              ,  ABS(ETA_DLAY_FM_HRS)*(-1)	AS ETA_DLAY_FM_HRS" ).append("\n"); 
		query.append("              ,  ABS(ETA_DLAY_TO_HRS)		AS ETA_DLAY_TO_HRS" ).append("\n"); 
		query.append("              ,  ABS(ETB_DLAY_FM_HRS)*(-1)	AS ETB_DLAY_FM_HRS" ).append("\n"); 
		query.append("              ,  ABS(ETB_DLAY_TO_HRS)		AS ETB_DLAY_TO_HRS" ).append("\n"); 
		query.append("              ,  ABS(ETD_DLAY_FM_HRS)*(-1)	AS ETD_DLAY_FM_HRS" ).append("\n"); 
		query.append("              ,  ABS(ETD_DLAY_TO_HRS)		AS ETD_DLAY_TO_HRS " ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("FROM             (" ).append("\n"); 
		query.append("                 --==============================================================================" ).append("\n"); 
		query.append("                  SELECT           D.VSL_CD               				/* PK.VSL_CD        	*/           " ).append("\n"); 
		query.append("                                ,  D.SKD_VOY_NO                       	/* PK.SKD_VOY_NO        */" ).append("\n"); 
		query.append("                                ,  D.SKD_DIR_CD                       	/* PK.SKD_DIR_CD        */" ).append("\n"); 
		query.append("                                ,  D.VPS_PORT_CD                      	/* PK.VPS_PORT_CD       */" ).append("\n"); 
		query.append("                                ,  D.CLPT_IND_SEQ                     	/* PK.CLPT_IND_SEQ      */" ).append("\n"); 
		query.append("                                ,  X.USR_ID                           	/* PK.USR_ID            */" ).append("\n"); 
		query.append("                                --------------------------------------------------------------------" ).append("\n"); 
		query.append("                                ,  D.VVD_HIS_SEQ            			/* VVD_HIS_SEQ      	*/" ).append("\n"); 
		query.append("                                ,  D.HIS_DTL_SEQ                      	/* HIS_DTL_SEQ          */" ).append("\n"); 
		query.append("                                ,  D.VSL_SLAN_CD                      	/* VSL_SLAN_CD          */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                   /* ET : ETA/ETB/ETD 지연" ).append("\n"); 
		query.append("                                      PS : PORT SKIP " ).append("\n"); 
		query.append("                                      PR : PORT REVERSE" ).append("\n"); 
		query.append("                                      SR : BOTH SKIP + REVERSE  */     " ).append("\n"); 
		query.append("                                ,  CASE WHEN X.SKP_CLPT_TGT_FLG = 'Y' AND D.VSKD_TML_CNG_TP_CD = 'S' AND X.RVS_CLPT_TGT_FLG = 'Y' AND D.VSKD_TML_CNG_TP_CD = 'P' THEN 'SR'" ).append("\n"); 
		query.append("                                        WHEN X.SKP_CLPT_TGT_FLG = 'Y' AND D.VSKD_TML_CNG_TP_CD = 'S' THEN 'PS'" ).append("\n"); 
		query.append("										WHEN X.SKP_CLPT_TGT_FLG = 'Y' AND D.VSKD_TML_CNG_TP_CD = 'X' THEN 'PX'" ).append("\n"); 
		query.append("                                        WHEN X.RVS_CLPT_TGT_FLG = 'Y' AND D.VSKD_TML_CNG_TP_CD = 'P' THEN 'PR'  /* 미사용 */" ).append("\n"); 
		query.append("                                        ELSE 'XX'" ).append("\n"); 
		query.append("                                   END  NTFC_TRSM_TP_CD" ).append("\n"); 
		query.append("                                ,  D.PF_ETA_DT" ).append("\n"); 
		query.append("                                ,  D.PF_ETB_DT" ).append("\n"); 
		query.append("                                ,  D.PF_ETD_DT" ).append("\n"); 
		query.append("                                ,  D.VPS_ETA_DT" ).append("\n"); 
		query.append("                                ,  D.VPS_ETB_DT" ).append("\n"); 
		query.append("                                ,  D.VPS_ETD_DT" ).append("\n"); 
		query.append("                                ,  D.PORT_SKP_TP_CD" ).append("\n"); 
		query.append("                                ,  D.BFR_YD_CD" ).append("\n"); 
		query.append("                                ,  D.CRNT_YD_CD" ).append("\n"); 
		query.append("                                ,  D.PAIR_RVS_PORT_CD" ).append("\n"); 
		query.append("                                ,  D.PAIR_RVS_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                " ).append("\n"); 
		query.append("                                ,  NULL      AS ETA_DELAY_HRS" ).append("\n"); 
		query.append("                                ,  NULL      AS ETB_DELAY_HRS" ).append("\n"); 
		query.append("                                ,  NULL      AS ETD_DELAY_HRS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                ,  NULL		 AS ETA_DLAY_FM_HRS" ).append("\n"); 
		query.append("                                ,  NULL		 AS ETA_DLAY_TO_HRS" ).append("\n"); 
		query.append("                                ,  NULL		 AS ETB_DLAY_FM_HRS" ).append("\n"); 
		query.append("                                ,  NULL		 AS ETB_DLAY_TO_HRS" ).append("\n"); 
		query.append("                                ,  NULL		 AS ETD_DLAY_FM_HRS" ).append("\n"); 
		query.append("                                ,  NULL		 AS ETD_DLAY_TO_HRS  " ).append("\n"); 
		query.append("                                " ).append("\n"); 
		query.append("                  FROM             VSK_VSL_SKD_NTFC_STUP   X" ).append("\n"); 
		query.append("                                ,  VSK_VSL_SKD_CNG_HIS_DTL D" ).append("\n"); 
		query.append("                  WHERE            1 = 1" ).append("\n"); 
		query.append("                  AND              X.APLY_FLG              = 'Y'" ).append("\n"); 
		query.append("                  AND              X.VSL_SLAN_CD           = D.VSL_SLAN_CD" ).append("\n"); 
		query.append("                  AND              X.VPS_PORT_CD           = D.VPS_PORT_CD" ).append("\n"); 
		query.append("                  AND              X.SKD_DIR_CD            = D.SKD_DIR_CD" ).append("\n"); 
		query.append("				  --AND			   D.PF_ETA_DT			   IS NOT NULL" ).append("\n"); 
		query.append("				  --AND			   D.PF_ETB_DT			   IS NOT NULL" ).append("\n"); 
		query.append("				  --AND			   D.PF_ETD_DT			   IS NOT NULL" ).append("\n"); 
		query.append("				  AND		       D.VPS_ETA_DT			   BETWEEN SYSDATE AND SYSDATE + 31	/* 현재일자이후 31일까지만 대상으로 함 */" ).append("\n"); 
		query.append("                  AND              X.SKP_CLPT_TGT_FLG      = 'Y'" ).append("\n"); 
		query.append("                  AND              D.VSKD_TML_CNG_TP_CD    IN ('S','X') " ).append("\n"); 
		query.append("				  AND			   (D.VSL_CD,D.SKD_VOY_NO,D.SKD_DIR_CD,D.VVD_HIS_SEQ)" ).append("\n"); 
		query.append("									IN" ).append("\n"); 
		query.append("									(" ).append("\n"); 
		query.append("									---------------------------------------------------------------" ).append("\n"); 
		query.append("									#foreach(${key} IN ${velParam}) " ).append("\n"); 
		query.append("										#if($velocityCount < $velParam.size())" ).append("\n"); 
		query.append("											('${key.vslCd}','${key.skdVoyNo}','${key.skdDirCd}','${key.vvdHisSeq}')," ).append("\n"); 
		query.append("										#else" ).append("\n"); 
		query.append("											('${key.vslCd}','${key.skdVoyNo}','${key.skdDirCd}','${key.vvdHisSeq}')" ).append("\n"); 
		query.append("										#end" ).append("\n"); 
		query.append("									#end" ).append("\n"); 
		query.append("									---------------------------------------------------------------" ).append("\n"); 
		query.append("									)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                  UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                  SELECT           D.VSL_CD             			/* PK.VSL_CD        		*/           " ).append("\n"); 
		query.append("                                ,  D.SKD_VOY_NO                     /* PK.SKD_VOY_NO            */" ).append("\n"); 
		query.append("                                ,  D.SKD_DIR_CD                     /* PK.SKD_DIR_CD            */" ).append("\n"); 
		query.append("                                ,  D.VPS_PORT_CD                    /* PK.VPS_PORT_CD           */" ).append("\n"); 
		query.append("                                ,  D.CLPT_IND_SEQ                   /* PK.CLPT_IND_SEQ          */" ).append("\n"); 
		query.append("                                ,  X.USR_ID                         /* PK.USR_ID                */" ).append("\n"); 
		query.append("                                --------------------------------------------------------------------" ).append("\n"); 
		query.append("                                ,  D.VVD_HIS_SEQ          			/* VVD_HIS_SEQ        		*/" ).append("\n"); 
		query.append("                                ,  D.HIS_DTL_SEQ                    /* HIS_DTL_SEQ              */" ).append("\n"); 
		query.append("                                ,  D.VSL_SLAN_CD                    /* VSL_SLAN_CD              */" ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("                                   /*       ET : ETA/ETB/ETD 지연" ).append("\n"); 
		query.append("                                      PS : PORT SKIP " ).append("\n"); 
		query.append("                                      PR : PORT REVERSE" ).append("\n"); 
		query.append("                                      SR : BOTH SKIP + REVERSE  */  " ).append("\n"); 
		query.append("                                ,  'ET'                             /* NTFC_TRSM_TP_CD          */" ).append("\n"); 
		query.append("                                ,  D.PF_ETA_DT" ).append("\n"); 
		query.append("                                ,  D.PF_ETB_DT" ).append("\n"); 
		query.append("                                ,  D.PF_ETD_DT" ).append("\n"); 
		query.append("                                ,  D.VPS_ETA_DT" ).append("\n"); 
		query.append("                                ,  D.VPS_ETB_DT" ).append("\n"); 
		query.append("                                ,  D.VPS_ETD_DT" ).append("\n"); 
		query.append("                                ,  D.PORT_SKP_TP_CD" ).append("\n"); 
		query.append("                                ,  D.BFR_YD_CD" ).append("\n"); 
		query.append("                                ,  D.CRNT_YD_CD" ).append("\n"); 
		query.append("                                ,  D.PAIR_RVS_PORT_CD" ).append("\n"); 
		query.append("                                ,  D.PAIR_RVS_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                " ).append("\n"); 
		query.append("                                ,  CASE WHEN D.PF_ETA_DT IS NOT NULL THEN D.VPS_ETA_DT - D.PF_ETA_DT" ).append("\n"); 
		query.append("                                        ELSE NULL" ).append("\n"); 
		query.append("                                   END  AS ETA_DELAY_HRS" ).append("\n"); 
		query.append("                                ,  CASE WHEN D.PF_ETB_DT IS NOT NULL THEN D.VPS_ETB_DT - D.PF_ETB_DT" ).append("\n"); 
		query.append("                                        ELSE NULL" ).append("\n"); 
		query.append("                                   END  AS ETB_DELAY_HRS" ).append("\n"); 
		query.append("                                ,  CASE WHEN D.PF_ETD_DT IS NOT NULL THEN D.VPS_ETD_DT - D.PF_ETD_DT" ).append("\n"); 
		query.append("                                        ELSE NULL" ).append("\n"); 
		query.append("                                   END  AS ETD_DELAY_HRS   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                ,  X.ETA_DLAY_FM_HRS" ).append("\n"); 
		query.append("                                ,  X.ETA_DLAY_TO_HRS" ).append("\n"); 
		query.append("                                ,  X.ETB_DLAY_FM_HRS" ).append("\n"); 
		query.append("                                ,  X.ETB_DLAY_TO_HRS" ).append("\n"); 
		query.append("                                ,  X.ETD_DLAY_FM_HRS" ).append("\n"); 
		query.append("                                ,  X.ETD_DLAY_TO_HRS                                 " ).append("\n"); 
		query.append("                                " ).append("\n"); 
		query.append("                  FROM             VSK_VSL_SKD_NTFC_STUP   X" ).append("\n"); 
		query.append("                                ,  VSK_VSL_SKD_CNG_HIS_DTL D" ).append("\n"); 
		query.append("                  WHERE            1 = 1" ).append("\n"); 
		query.append("                  AND              X.APLY_FLG              = 'Y'" ).append("\n"); 
		query.append("                  AND              X.VSL_SLAN_CD           = D.VSL_SLAN_CD" ).append("\n"); 
		query.append("                  AND              X.VPS_PORT_CD           = D.VPS_PORT_CD" ).append("\n"); 
		query.append("                  AND              X.SKD_DIR_CD            = D.SKD_DIR_CD" ).append("\n"); 
		query.append("				  AND			   D.PF_ETA_DT			   IS NOT NULL" ).append("\n"); 
		query.append("				  AND			   D.PF_ETB_DT			   IS NOT NULL" ).append("\n"); 
		query.append("				  AND			   D.PF_ETD_DT			   IS NOT NULL" ).append("\n"); 
		query.append("				  AND		       D.VPS_ETA_DT			   BETWEEN SYSDATE AND SYSDATE + 31 /* 현재일자이후 31일까지만 대상으로 함 */" ).append("\n"); 
		query.append("                  AND              (" ).append("\n"); 
		query.append("                                    (D.PF_ETA_DT-D.VPS_ETA_DT)*24 NOT BETWEEN ABS(NVL(X.ETA_DLAY_TO_HRS,365*24))*(-1) AND ABS(NVL(X.ETA_DLAY_FM_HRS,365*24))" ).append("\n"); 
		query.append("                                     OR" ).append("\n"); 
		query.append("    								(D.PF_ETB_DT-D.VPS_ETB_DT)*24 NOT BETWEEN ABS(NVL(X.ETB_DLAY_TO_HRS,365*24))*(-1) AND ABS(NVL(X.ETB_DLAY_FM_HRS,365*24))" ).append("\n"); 
		query.append("                                     OR" ).append("\n"); 
		query.append("    								(D.PF_ETD_DT-D.VPS_ETD_DT)*24 NOT BETWEEN ABS(NVL(X.ETD_DLAY_TO_HRS,365*24))*(-1) AND ABS(NVL(X.ETD_DLAY_FM_HRS,365*24))" ).append("\n"); 
		query.append("                                    )                                                                           " ).append("\n"); 
		query.append("					AND			   (D.VSL_CD,D.SKD_VOY_NO,D.SKD_DIR_CD,D.VVD_HIS_SEQ)" ).append("\n"); 
		query.append("									IN" ).append("\n"); 
		query.append("									(" ).append("\n"); 
		query.append("									---------------------------------------------------------------" ).append("\n"); 
		query.append("									#foreach(${key} IN ${velParam}) " ).append("\n"); 
		query.append("										#if($velocityCount < $velParam.size())" ).append("\n"); 
		query.append("											('${key.vslCd}','${key.skdVoyNo}','${key.skdDirCd}','${key.vvdHisSeq}')," ).append("\n"); 
		query.append("										#else" ).append("\n"); 
		query.append("											('${key.vslCd}','${key.skdVoyNo}','${key.skdDirCd}','${key.vvdHisSeq}')" ).append("\n"); 
		query.append("										#end" ).append("\n"); 
		query.append("									#end" ).append("\n"); 
		query.append("									---------------------------------------------------------------" ).append("\n"); 
		query.append("									)" ).append("\n"); 
		query.append("                 --==============================================================================" ).append("\n"); 
		query.append("                 ) XX" ).append("\n"); 

	}
}