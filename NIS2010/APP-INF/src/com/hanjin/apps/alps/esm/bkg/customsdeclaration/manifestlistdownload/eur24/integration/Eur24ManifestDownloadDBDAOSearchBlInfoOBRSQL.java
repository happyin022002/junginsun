/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : Eur24ManifestDownloadDBDAOSearchBlInfoOBRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24ManifestDownloadDBDAOSearchBlInfoOBRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EAM_BKG_1124에 사용되는 SQL
	  * * History
	  * 2012.03.05 김보배 [CHM-201216338] [BKG] [EXS- ES, PT] BL inquiry Prev. Doc 컬럼 추가
	  * 2012.06.07 김보배 [CHM-201218012] [BKG] [Spain EXS] Previous Doc Ref#관련 Subplace 항목추가 (MEDCUSRPL F/File, EXS F/File, EXS BL inquiry screen)
	  * 2012.06.20 김보배 [CHM-201218404] [BKG] [EXS] "Hold Release" Manual Update 기능
	  * </pre>
	  */
	public Eur24ManifestDownloadDBDAOSearchBlInfoOBRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration").append("\n"); 
		query.append("FileName : Eur24ManifestDownloadDBDAOSearchBlInfoOBRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append(" BKG_GET_TOKEN_FNC(ERR_YNS,1) AS ERR_YN" ).append("\n"); 
		query.append(",BKG_GET_TOKEN_FNC(ERR_YNS,2) AS ENS_EDI_SVC_FLG" ).append("\n"); 
		query.append(",BKG_GET_TOKEN_FNC(ERR_YNS,3) AS EXS_EDI_SVC_FLG" ).append("\n"); 
		query.append(",BKG_GET_TOKEN_FNC(ERR_YNS,4) AS DR_YN" ).append("\n"); 
		query.append(",BKG_GET_TOKEN_FNC(ERR_YNS,5) AS ATA_YN" ).append("\n"); 
		query.append(",BKG_GET_TOKEN_FNC(ERR_YNS,6) AS ARN_YN" ).append("\n"); 
		query.append(",KKK.* " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("/************************** 에러 BL여부 체크 ***********************/" ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("                DECODE( INSTR(SH_NM||SH_AD||SH_CT||SH_CN||SH_ZIP||SH_STR||SH_EORI" ).append("\n"); 
		query.append("                    ||CNEE_NM||CNEE_AD||CNEE_CT||CNEE_CN||CNEE_ZIP||CNEE_STR||CNEE_EORI" ).append("\n"); 
		query.append("                    ||NTFY_NM||NTFY_AD||NTFY_CT||NTFY_CN||NTFY_ZIP||NTFY_STR||NTFY_EORI" ).append("\n"); 
		query.append("                    ||BL_PK||BL_WT||CNTR_PK||CNTR_WT||CM_PK||CM_WT||CM_DS||CNTR_SEAL,'E'),0,'N','Y') " ).append("\n"); 
		query.append("        ||','|| BKG_GET_TOKEN_FNC(PORT_OFC.PORT_OFC_CD_SVC_FLG,2) " ).append("\n"); 
		query.append("		||','|| BKG_GET_TOKEN_FNC(PORT_OFC.PORT_OFC_CD_SVC_FLG,3)" ).append("\n"); 
		query.append("        ||','||  CASE WHEN DR_YN1 = 'Y' OR DR_YN2 = 'Y' THEN 'Y' ELSE 'N' END " ).append("\n"); 
		query.append("        ||','|| ATA_YN " ).append("\n"); 
		query.append("        ||','|| ARN_YN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("       			CASE WHEN BL_PK1 = 0 OR BL_PK1 != CNTR_PK_SUM THEN DECODE(BB_CGO_FLG,'Y','N','E') ELSE 'Y' END AS BL_PK" ).append("\n"); 
		query.append("			   ,CASE WHEN BL_WT1 = 0 OR BL_WT1 != CNTR_WT_SUM THEN DECODE(BB_CGO_FLG,'Y','N','E') ELSE 'Y' END AS BL_WT" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		       ,CASE WHEN CNTR_PK1 = 0 OR CNTR_PK1 != CM_PK_SUM THEN DECODE(BB_CGO_FLG,'Y','N','E') ELSE 'Y' END AS CNTR_PK" ).append("\n"); 
		query.append("		       ,CASE WHEN CNTR_WT1 = 0 OR CNTR_WT1 != CM_WT_SUM THEN DECODE(BB_CGO_FLG,'Y','N','E') ELSE 'Y' END AS CNTR_WT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("               ,NVL((SELECT 'Y'" ).append("\n"); 
		query.append("                       FROM  BKG_CSTMS_EUR_IO_RCV RCV" ).append("\n"); 
		query.append("                      WHERE 1=1" ).append("\n"); 
		query.append("                        AND  ACK_RCV_STS_CD  = 'A'" ).append("\n"); 
		query.append("                        AND  BND_TP_CD = 'O'" ).append("\n"); 
		query.append("                        AND RCV.RCV_TMS = (  SELECT MAX(RCV_TMS)" ).append("\n"); 
		query.append("                        						FROM BKG_CSTMS_EUR_IO_SND A, BKG_CSTMS_EUR_IO_RCV B" ).append("\n"); 
		query.append("                                               WHERE A.EUR_EDI_MSG_TP_ID ='DIV'" ).append("\n"); 
		query.append("                                                 AND A.VSL_CD            = XXX.VSL_CD" ).append("\n"); 
		query.append("                                                 AND A.SKD_VOY_NO        = XXX.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                 AND A.SKD_DIR_CD        = XXX.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                 AND A.CSTMS_PORT_CD     = XXX.EU_1ST_PORT" ).append("\n"); 
		query.append("                                                 AND A.MSG_SND_NO = B.MSG_RCV_NO" ).append("\n"); 
		query.append("                                                 AND A.BND_TP_CD = 'O'" ).append("\n"); 
		query.append("                                                 AND A.BND_TP_CD = B.BND_TP_CD" ).append("\n"); 
		query.append("                                                 AND (ACK_KND_ID != 'S'" ).append("\n"); 
		query.append("                                                      OR ACK_RCV_STS_CD != 'A')" ).append("\n"); 
		query.append("                                              )" ).append("\n"); 
		query.append("                         AND ROWNUM =1" ).append("\n"); 
		query.append("                      ),'N') AS DR_YN1" ).append("\n"); 
		query.append("               ,NVL( ( SELECT 'Y'" ).append("\n"); 
		query.append("                         FROM BKG_CSTMS_EUR_IO_VSL EVSL" ).append("\n"); 
		query.append("                        WHERE EVSL.VSL_CD        = XXX.VSL_CD" ).append("\n"); 
		query.append("                          AND EVSL.SKD_VOY_NO    = XXX.SKD_VOY_NO" ).append("\n"); 
		query.append("                          AND EVSL.SKD_DIR_CD    = XXX.SKD_DIR_CD" ).append("\n"); 
		query.append("                          AND EVSL.CSTMS_PORT_CD = XXX.EU_1ST_PORT" ).append("\n"); 
		query.append("                          AND DVS_RQST_SMT_FLG   = 'Y'" ).append("\n"); 
		query.append("                          AND EVSL.BND_TP_CD = 'O'" ).append("\n"); 
		query.append("                          " ).append("\n"); 
		query.append("                       ),'N') AS DR_YN2" ).append("\n"); 
		query.append("			   ,DECODE( ROWNUM,1,( SELECT CASE WHEN  NVL(MAX(ACT.ACT_ARR_DT),TO_DATE(XXX.VPS_ETA_DT,'YYYY-MM-DD HH24:MI')) <= GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS', SYSDATE, XXX.EU_1ST_PORT) THEN 'Y' " ).append("\n"); 
		query.append("                                ELSE 'N'" ).append("\n"); 
		query.append("                           END  /* 새로운 POFE에서의 Actual ETA 이후에는 전송 안됨, DOWNLOAD 데이타만 적용 */" ).append("\n"); 
		query.append("                      FROM VSK_ACT_PORT_SKD ACT" ).append("\n"); 
		query.append("                     WHERE VSL_CD      = XXX.VSL_CD" ).append("\n"); 
		query.append("                       AND SKD_VOY_NO  = XXX.SKD_VOY_NO" ).append("\n"); 
		query.append("                       AND SKD_DIR_CD  = XXX.SKD_DIR_CD" ).append("\n"); 
		query.append("                       AND VPS_PORT_CD = XXX.EU_1ST_PORT" ).append("\n"); 
		query.append("                       AND ROWNUM = 1" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("				) AS ATA_YN" ).append("\n"); 
		query.append("			,NVL( ( SELECT 'Y'" ).append("\n"); 
		query.append("				      FROM BKG_CSTMS_EUR_IO_RCV RCV" ).append("\n"); 
		query.append("				     WHERE 1=1" ).append("\n"); 
		query.append("				       AND ACK_RCV_STS_CD  = 'A'" ).append("\n"); 
		query.append("                       AND BND_TP_CD = 'O'" ).append("\n"); 
		query.append("				       AND RCV.RCV_TMS = (  SELECT MAX(RCV_TMS)" ).append("\n"); 
		query.append("							  				   FROM BKG_CSTMS_EUR_IO_SND A, BKG_CSTMS_EUR_IO_RCV B" ).append("\n"); 
		query.append("										      WHERE A.EUR_EDI_MSG_TP_ID ='ARN'" ).append("\n"); 
		query.append("				                    			AND A.VSL_CD            = XXX.VSL_CD" ).append("\n"); 
		query.append("							                    AND A.SKD_VOY_NO        = XXX.SKD_VOY_NO" ).append("\n"); 
		query.append("							                    AND A.SKD_DIR_CD        = XXX.SKD_DIR_CD" ).append("\n"); 
		query.append("				        			            AND A.CSTMS_PORT_CD     = XXX.EU_1ST_PORT" ).append("\n"); 
		query.append("				                    			AND A.MSG_SND_NO = B.MSG_RCV_NO" ).append("\n"); 
		query.append("                                                AND A.BND_TP_CD = 'O'" ).append("\n"); 
		query.append("                                                AND A.BND_TP_CD = B.BND_TP_CD" ).append("\n"); 
		query.append("							                    AND (ACK_KND_ID != 'S' OR ACK_RCV_STS_CD != 'A')" ).append("\n"); 
		query.append("							              )" ).append("\n"); 
		query.append("				      AND ROWNUM =1" ).append("\n"); 
		query.append("				),'N') AS ARN_YN" ).append("\n"); 
		query.append("               , XXX.*" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("	   	        DECODE(CM_PK1,0,DECODE(BB_CGO_FLG,'Y','N','E'),'Y') AS CM_PK" ).append("\n"); 
		query.append("			  , DECODE(CM_WT1,0,DECODE(BB_CGO_FLG,'Y','N','E'),'Y') AS CM_WT " ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("              , SUM(CNTR_PK1) OVER(PARTITION BY BL_NO) AS  CNTR_PK_SUM" ).append("\n"); 
		query.append("              , SUM(CNTR_WT1) OVER(PARTITION BY BL_NO) AS  CNTR_WT_SUM" ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              , SUM(CM_PK1) OVER(PARTITION BY BL_NO,CNTR_CNTR_NO) AS  CM_PK_SUM" ).append("\n"); 
		query.append("              , SUM(CM_WT1) OVER(PARTITION BY BL_NO,CNTR_CNTR_NO) AS  CM_WT_SUM" ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              , BKG_GET_TOKEN_FNC(XX.SND,1)  AS MSG_SND_NO" ).append("\n"); 
		query.append("              , XX.*  " ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("                NISADM.BKG_GET_TOKEN_FNC(CM_DATA,1) AS CM_PK1" ).append("\n"); 
		query.append("              , NISADM.BKG_GET_TOKEN_FNC(CM_DATA,2) AS CM_WT1" ).append("\n"); 
		query.append("              , DECODE(NISADM.BKG_GET_TOKEN_FNC(CM_DATA,3),0,'N','Y') AS CM_MS" ).append("\n"); 
		query.append("              , DECODE(NVL(NISADM.BKG_GET_TOKEN_FNC(CM_DATA,4),0),0,'E','Y') AS CM_DS" ).append("\n"); 
		query.append("              , DECODE(NVL(NISADM.BKG_GET_TOKEN_FNC(CM_DATA,5),0),0,'N','Y') AS CM_MK" ).append("\n"); 
		query.append("              , DECODE(NVL(NISADM.BKG_GET_TOKEN_FNC(CM_DATA,6),0),0,'N','Y') AS CM_HTS" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("              ,DECODE(CUST_TO_ORD_FLG,'Y',DECODE(CNEE_NM1,  'E','N',CNEE_NM1),CNEE_NM1)     AS CNEE_NM" ).append("\n"); 
		query.append("              ,DECODE(CUST_TO_ORD_FLG,'Y',DECODE(CNEE_AD1,  'E','N',CNEE_AD1),CNEE_AD1)     AS CNEE_AD" ).append("\n"); 
		query.append("              ,DECODE(CUST_TO_ORD_FLG,'Y',DECODE(CNEE_CT1,  'E','N',CNEE_CT1),CNEE_CT1)     AS CNEE_CT" ).append("\n"); 
		query.append("              ,DECODE(CUST_TO_ORD_FLG,'Y',DECODE(CNEE_CN1,  'E','N',CNEE_CN1),CNEE_CN1)     AS CNEE_CN" ).append("\n"); 
		query.append("              ,DECODE(CUST_TO_ORD_FLG,'Y',DECODE(CNEE_ZIP1, 'E','N',CNEE_ZIP1),CNEE_ZIP1)   AS CNEE_ZIP" ).append("\n"); 
		query.append("              ,DECODE(CUST_TO_ORD_FLG,'Y',DECODE(CNEE_STR1, 'E','N',CNEE_STR1),CNEE_STR1)   AS CNEE_STR" ).append("\n"); 
		query.append("              ,DECODE(CUST_TO_ORD_FLG,'Y',DECODE(CNEE_EORI1,'E','N',CNEE_EORI1),CNEE_EORI1) AS CNEE_EORI" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              ,DECODE(CUST_TO_ORD_FLG,'Y',NTFY_NM1,DECODE(NTFY_NM1,  'E','N',NTFY_NM1))     AS NTFY_NM" ).append("\n"); 
		query.append("              ,DECODE(CUST_TO_ORD_FLG,'Y',NTFY_AD1,DECODE(NTFY_AD1,  'E','N',NTFY_AD1))     AS NTFY_AD" ).append("\n"); 
		query.append("              ,DECODE(CUST_TO_ORD_FLG,'Y',NTFY_CT1,DECODE(NTFY_CT1,  'E','N',NTFY_CT1))     AS NTFY_CT" ).append("\n"); 
		query.append("              ,DECODE(CUST_TO_ORD_FLG,'Y',NTFY_CN1,DECODE(NTFY_CN1,  'E','N',NTFY_CN1))     AS NTFY_CN" ).append("\n"); 
		query.append("              ,DECODE(CUST_TO_ORD_FLG,'Y',NTFY_ZIP1,DECODE(NTFY_ZIP1, 'E','N',NTFY_ZIP1))   AS NTFY_ZIP" ).append("\n"); 
		query.append("              ,DECODE(CUST_TO_ORD_FLG,'Y',NTFY_STR1,DECODE(NTFY_STR1, 'E','N',NTFY_STR1))   AS NTFY_STR" ).append("\n"); 
		query.append("              ,DECODE(CUST_TO_ORD_FLG,'Y',NTFY_EORI1,DECODE(NTFY_EORI1,'E','N',NTFY_EORI1)) AS NTFY_EORI" ).append("\n"); 
		query.append("             , (SELECT EBL.MSG_SND_NO||','||TO_CHAR(SND.SND_DT  ,'YYYY-MM-DD HH24:MI')||','||TO_CHAR(SND.SND_GDT ,'YYYY-MM-DD HH24:MI')||','||SND.SND_USR_OFC_CD||','||EBL.MVMT_REF_NO||','||EBL.BL_NO" ).append("\n"); 
		query.append("               FROM BKG_CSTMS_EUR_IO_SND SND, BKG_CSTMS_EUR_IO_BL EBL" ).append("\n"); 
		query.append("               WHERE EBL.MSG_SND_NO    = SND.MSG_SND_NO(+)" ).append("\n"); 
		query.append("                 AND EBL.VSL_CD        = X.VSL_CD" ).append("\n"); 
		query.append("                 AND EBL.SKD_VOY_NO    = X.SKD_VOY_NO" ).append("\n"); 
		query.append("                 AND EBL.SKD_DIR_CD    = X.SKD_DIR_CD" ).append("\n"); 
		query.append("                 AND EBL.BL_NO         = X.BL_NO" ).append("\n"); 
		query.append("                 AND EBL.CSTMS_PORT_CD = X.EU_1ST_PORT" ).append("\n"); 
		query.append("                 AND EBL.BND_TP_CD = 'O'" ).append("\n"); 
		query.append("                 AND 'O' = SND.BND_TP_CD" ).append("\n"); 
		query.append("              ) AS SND      " ).append("\n"); 
		query.append("              , X.*" ).append("\n"); 
		query.append("          FROM (         " ).append("\n"); 
		query.append("                SELECT  " ).append("\n"); 
		query.append("                    BL.VSL_CD || BL.SKD_VOY_NO || BL.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("                   ,BL.VSL_CD " ).append("\n"); 
		query.append("                   ,BL.SKD_VOY_NO " ).append("\n"); 
		query.append("                   ,BL.SKD_DIR_CD" ).append("\n"); 
		query.append("                   ,BL.BL_NO         " ).append("\n"); 
		query.append("                   , BC.CNTR_NO AS CNTR_CNTR_NO" ).append("\n"); 
		query.append("                   , DECODE(SHPR.CUST_NM,           NULL,'E','Y')	AS SH_NM" ).append("\n"); 
		query.append("                   , DECODE(SHPR.CUST_ADDR,         NULL,'E','Y')	AS SH_AD" ).append("\n"); 
		query.append("                   , CASE WHEN SHPR.EORI_NO IS NULL AND SHPR.CUST_CTY_NM IS NULL" ).append("\n"); 
		query.append("                               THEN 'E'" ).append("\n"); 
		query.append("                          WHEN SHPR.CUST_CTY_NM IS NOT NULL" ).append("\n"); 
		query.append("                               THEN 'Y'" ).append("\n"); 
		query.append("                          ELSE 'N'" ).append("\n"); 
		query.append("                     END SH_CT" ).append("\n"); 
		query.append("                   , CASE WHEN SHPR.EORI_NO IS NULL AND SHPR.CSTMS_DECL_CNT_CD IS NULL" ).append("\n"); 
		query.append("                               THEN 'E'" ).append("\n"); 
		query.append("                          WHEN SHPR.CSTMS_DECL_CNT_CD IS NOT NULL" ).append("\n"); 
		query.append("                               THEN 'Y'" ).append("\n"); 
		query.append("                          ELSE 'N'" ).append("\n"); 
		query.append("                     END SH_CN" ).append("\n"); 
		query.append("                   , CASE WHEN SHPR.EORI_NO IS NULL AND SHPR.CUST_ZIP_ID IS NULL" ).append("\n"); 
		query.append("                               THEN 'E'" ).append("\n"); 
		query.append("                          WHEN SHPR.CUST_ZIP_ID IS NOT NULL" ).append("\n"); 
		query.append("                               THEN 'Y'" ).append("\n"); 
		query.append("                          ELSE 'N'" ).append("\n"); 
		query.append("                     END SH_ZIP" ).append("\n"); 
		query.append("                   , CASE WHEN SHPR.EORI_NO IS NULL AND SHPR.EUR_CSTMS_ST_NM IS NULL" ).append("\n"); 
		query.append("                               THEN 'E'" ).append("\n"); 
		query.append("                          WHEN SHPR.EUR_CSTMS_ST_NM IS NOT NULL" ).append("\n"); 
		query.append("                               THEN 'Y'" ).append("\n"); 
		query.append("                          ELSE 'N'" ).append("\n"); 
		query.append("                     END SH_STR" ).append("\n"); 
		query.append("                   , CASE WHEN SHPR.EORI_NO IS NOT NULL THEN 'Y'" ).append("\n"); 
		query.append("                          WHEN SHPR.EORI_NO IS NULL " ).append("\n"); 
		query.append("                               AND (SHPR.CUST_CTY_NM IS NULL " ).append("\n"); 
		query.append("                                OR SHPR.CSTMS_DECL_CNT_CD IS NULL  " ).append("\n"); 
		query.append("                                OR SHPR.CUST_ZIP_ID IS NULL )" ).append("\n"); 
		query.append("                               THEN 'E'" ).append("\n"); 
		query.append("                          ELSE 'N'" ).append("\n"); 
		query.append("                     END SH_EORI" ).append("\n"); 
		query.append("                              " ).append("\n"); 
		query.append("                   , DECODE(CNEE.CUST_NM,           NULL,'E','Y')	AS CNEE_NM1" ).append("\n"); 
		query.append("                   , DECODE(CNEE.CUST_ADDR,         NULL,'E','Y')	AS CNEE_AD1" ).append("\n"); 
		query.append("                   , CASE WHEN CNEE.EORI_NO IS NULL AND CNEE.CUST_CTY_NM IS NULL" ).append("\n"); 
		query.append("                               THEN 'E'" ).append("\n"); 
		query.append("                          WHEN CNEE.CUST_CTY_NM IS NOT NULL" ).append("\n"); 
		query.append("                               THEN 'Y'" ).append("\n"); 
		query.append("                          ELSE 'N'" ).append("\n"); 
		query.append("                     END CNEE_CT1" ).append("\n"); 
		query.append("                   , CASE WHEN CNEE.EORI_NO IS NULL AND CNEE.CSTMS_DECL_CNT_CD IS NULL" ).append("\n"); 
		query.append("                               THEN 'E'" ).append("\n"); 
		query.append("                          WHEN CNEE.CSTMS_DECL_CNT_CD IS NOT NULL" ).append("\n"); 
		query.append("                               THEN 'Y'" ).append("\n"); 
		query.append("                          ELSE 'N'" ).append("\n"); 
		query.append("                     END CNEE_CN1" ).append("\n"); 
		query.append("                   , CASE WHEN CNEE.EORI_NO IS NULL AND CNEE.CUST_ZIP_ID IS NULL" ).append("\n"); 
		query.append("                               THEN 'E'" ).append("\n"); 
		query.append("                          WHEN CNEE.CUST_ZIP_ID IS NOT NULL" ).append("\n"); 
		query.append("                               THEN 'Y'" ).append("\n"); 
		query.append("                          ELSE 'N'" ).append("\n"); 
		query.append("                     END CNEE_ZIP1" ).append("\n"); 
		query.append("                   , CASE WHEN CNEE.EORI_NO IS NULL AND CNEE.EUR_CSTMS_ST_NM IS NULL" ).append("\n"); 
		query.append("                               THEN 'E'" ).append("\n"); 
		query.append("                          WHEN CNEE.EUR_CSTMS_ST_NM IS NOT NULL" ).append("\n"); 
		query.append("                               THEN 'Y'" ).append("\n"); 
		query.append("                          ELSE 'N'" ).append("\n"); 
		query.append("                     END CNEE_STR1" ).append("\n"); 
		query.append("                   , CASE WHEN CNEE.EORI_NO IS NOT NULL THEN 'Y'" ).append("\n"); 
		query.append("                          WHEN CNEE.EORI_NO IS NULL " ).append("\n"); 
		query.append("                               AND (CNEE.CUST_CTY_NM IS NULL " ).append("\n"); 
		query.append("                                 OR CNEE.CSTMS_DECL_CNT_CD IS NULL  " ).append("\n"); 
		query.append("                                 OR CNEE.CUST_ZIP_ID IS NULL )" ).append("\n"); 
		query.append("                               THEN 'E'" ).append("\n"); 
		query.append("                          ELSE 'N'" ).append("\n"); 
		query.append("                     END CNEE_EORI1       " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                   , DECODE(NTFY.CUST_NM,           NULL,'E','Y')	AS NTFY_NM1" ).append("\n"); 
		query.append("                   , DECODE(NTFY.CUST_ADDR,         NULL,'E','Y')	AS NTFY_AD1" ).append("\n"); 
		query.append("                   , CASE WHEN NTFY.EORI_NO IS NULL AND NTFY.CUST_CTY_NM IS NULL" ).append("\n"); 
		query.append("                               THEN 'E'" ).append("\n"); 
		query.append("                          WHEN NTFY.CUST_CTY_NM IS NOT NULL" ).append("\n"); 
		query.append("                               THEN 'Y'" ).append("\n"); 
		query.append("                          ELSE 'N'" ).append("\n"); 
		query.append("                     END NTFY_CT1" ).append("\n"); 
		query.append("                   , CASE WHEN NTFY.EORI_NO IS NULL AND NTFY.CSTMS_DECL_CNT_CD IS NULL" ).append("\n"); 
		query.append("                               THEN 'E'" ).append("\n"); 
		query.append("                          WHEN NTFY.CSTMS_DECL_CNT_CD IS NOT NULL" ).append("\n"); 
		query.append("                               THEN 'Y'" ).append("\n"); 
		query.append("                          ELSE 'N'" ).append("\n"); 
		query.append("                     END NTFY_CN1" ).append("\n"); 
		query.append("                   , CASE WHEN NTFY.EORI_NO IS NULL AND NTFY.CUST_ZIP_ID IS NULL" ).append("\n"); 
		query.append("                               THEN 'E'" ).append("\n"); 
		query.append("                          WHEN NTFY.CUST_ZIP_ID IS NOT NULL" ).append("\n"); 
		query.append("                               THEN 'Y'" ).append("\n"); 
		query.append("                          ELSE 'N'" ).append("\n"); 
		query.append("                     END NTFY_ZIP1" ).append("\n"); 
		query.append("                   , CASE WHEN NTFY.EORI_NO IS NULL AND NTFY.EUR_CSTMS_ST_NM IS NULL" ).append("\n"); 
		query.append("                               THEN 'E'" ).append("\n"); 
		query.append("                          WHEN NTFY.EUR_CSTMS_ST_NM IS NOT NULL" ).append("\n"); 
		query.append("                               THEN 'Y'" ).append("\n"); 
		query.append("                          ELSE 'N'" ).append("\n"); 
		query.append("                     END NTFY_STR1" ).append("\n"); 
		query.append("                   , CASE WHEN NTFY.EORI_NO IS NOT NULL THEN 'Y'" ).append("\n"); 
		query.append("                          WHEN NTFY.EORI_NO IS NULL " ).append("\n"); 
		query.append("                               AND (NTFY.CUST_CTY_NM IS NULL " ).append("\n"); 
		query.append("                                 OR NTFY.CSTMS_DECL_CNT_CD IS NULL  " ).append("\n"); 
		query.append("                                 OR NTFY.CUST_ZIP_ID IS NULL )" ).append("\n"); 
		query.append("                               THEN 'E'" ).append("\n"); 
		query.append("                          ELSE 'N'" ).append("\n"); 
		query.append("                     END NTFY_EORI1 " ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("                   , NVL(BL.PCK_QTY,0)	AS BL_PK1" ).append("\n"); 
		query.append("                   , NVL(BL.ACT_WGT,0)	AS BL_WT1" ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("                   , NVL((SELECT 'Y'" ).append("\n"); 
		query.append("                          FROM  BKG_CSTMS_EUR_IO_SEAL_NO" ).append("\n"); 
		query.append("                          WHERE VSL_CD        = BL.VSL_CD" ).append("\n"); 
		query.append("                          AND   SKD_VOY_NO    = BL.SKD_VOY_NO" ).append("\n"); 
		query.append("                          AND   SKD_DIR_CD    = BL.SKD_DIR_CD" ).append("\n"); 
		query.append("                          AND   BL_NO         = BL.BL_NO" ).append("\n"); 
		query.append("                          AND   CSTMS_PORT_CD = BL.CSTMS_PORT_CD" ).append("\n"); 
		query.append("                          AND   CNTR_NO       = BC.CNTR_NO" ).append("\n"); 
		query.append("                          AND   BND_TP_CD = 'O'" ).append("\n"); 
		query.append("                          AND   ROWNUM =1), 'E') AS CNTR_SEAL" ).append("\n"); 
		query.append("                          " ).append("\n"); 
		query.append("                   , NVL(BC.PCK_QTY,0)	AS CNTR_PK1" ).append("\n"); 
		query.append("                   , NVL(BC.ACT_WGT,0)	AS CNTR_WT1" ).append("\n"); 
		query.append("                   , DECODE(NVL(BC.MEAS_QTY,0), 0,'N','Y')	AS CNTR_MS" ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("                   , ( SELECT NVL(SUM(PCK_QTY ),0)    ||','|| /* PK */" ).append("\n"); 
		query.append("                              NVL(SUM(CNTR_MF_WGT),0) ||','|| /* WT */" ).append("\n"); 
		query.append("                              NVL(SUM(MEAS_QTY),0)    ||','|| /* MS */" ).append("\n"); 
		query.append("                              COUNT(CNTR_MF_GDS_DESC)||','|| /* DS */" ).append("\n"); 
		query.append("                              COUNT(CNTR_MF_MK_DESC) ||','|| /* MK */" ).append("\n"); 
		query.append("                              COUNT(CMDT_HS_CD)              /* HTS*/" ).append("\n"); 
		query.append("                       FROM BKG_CSTMS_EUR_IO_CNTR_MF CM" ).append("\n"); 
		query.append("                       WHERE VSL_CD        = BL.VSL_CD" ).append("\n"); 
		query.append("                       AND   SKD_VOY_NO    = BL.SKD_VOY_NO" ).append("\n"); 
		query.append("                       AND   SKD_DIR_CD    = BL.SKD_DIR_CD" ).append("\n"); 
		query.append("                       AND   BL_NO         = BL.BL_NO" ).append("\n"); 
		query.append("                       AND   CSTMS_PORT_CD = BL.CSTMS_PORT_CD" ).append("\n"); 
		query.append("                       AND   CNTR_NO       = BC.CNTR_NO" ).append("\n"); 
		query.append("                       AND   BND_TP_CD = 'O'" ).append("\n"); 
		query.append("                      ) AS CM_DATA    " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("                   , BL.CSTMS_PORT_CD AS EU_1ST_PORT   " ).append("\n"); 
		query.append("                   , BL.CSTMS_YD_CD   AS EU_1ST_PORT_YD_CD   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			   ,( SELECT TO_CHAR(VPS_ETA_DT,'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("			      FROM   VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("			      WHERE  VSL_CD       = BL.VSL_CD" ).append("\n"); 
		query.append("			      AND    SKD_VOY_NO   = BL.SKD_VOY_NO" ).append("\n"); 
		query.append("		    	  AND    SKD_DIR_CD   = BL.SKD_DIR_CD" ).append("\n"); 
		query.append("			      AND    VPS_PORT_CD  = BL.CSTMS_PORT_CD" ).append("\n"); 
		query.append("			      AND    CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("			     ) AS VPS_ETA_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                   , BKG.CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("				   , BKG.BB_CGO_FLG" ).append("\n"); 
		query.append("                FROM  BKG_CSTMS_EUR_IO_BL BL" ).append("\n"); 
		query.append("                   ,BKG_BOOKING BKG" ).append("\n"); 
		query.append("                   ,BKG_CSTMS_EUR_IO_CUST SHPR" ).append("\n"); 
		query.append("                   ,BKG_CSTMS_EUR_IO_CUST CNEE" ).append("\n"); 
		query.append("                   ,BKG_CSTMS_EUR_IO_CUST NTFY" ).append("\n"); 
		query.append("                   ,BKG_CSTMS_EUR_IO_CNTR BC " ).append("\n"); 
		query.append("                   ,BKG_CSTMS_EUR_IO_SND SND" ).append("\n"); 
		query.append("                WHERE  1=1" ).append("\n"); 
		query.append("                AND BL.BL_NO        = BKG.BL_NO" ).append("\n"); 
		query.append("                AND BL.BND_TP_CD = 'O'" ).append("\n"); 
		query.append("                AND BL.VSL_CD        = SHPR.VSL_CD(+)" ).append("\n"); 
		query.append("                AND BL.SKD_VOY_NO    = SHPR.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                AND BL.SKD_DIR_CD    = SHPR.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                AND BL.BL_NO         = SHPR.BL_NO(+)" ).append("\n"); 
		query.append("                AND BL.CSTMS_PORT_CD = SHPR.CSTMS_PORT_CD(+)" ).append("\n"); 
		query.append("                AND 'S'              = SHPR.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("                AND 'O'              = SHPR.BND_TP_CD(+)" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                AND BL.VSL_CD        = CNEE.VSL_CD(+)" ).append("\n"); 
		query.append("                AND BL.SKD_VOY_NO    = CNEE.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                AND BL.SKD_DIR_CD    = CNEE.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                AND BL.BL_NO         = CNEE.BL_NO(+)" ).append("\n"); 
		query.append("                AND BL.CSTMS_PORT_CD = CNEE.CSTMS_PORT_CD(+)" ).append("\n"); 
		query.append("                AND 'C'              = CNEE.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("                AND 'O'              = CNEE.BND_TP_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                AND BL.VSL_CD        = NTFY.VSL_CD(+)" ).append("\n"); 
		query.append("                AND BL.SKD_VOY_NO    = NTFY.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                AND BL.SKD_DIR_CD    = NTFY.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                AND BL.BL_NO         = NTFY.BL_NO(+)" ).append("\n"); 
		query.append("                AND BL.CSTMS_PORT_CD = NTFY.CSTMS_PORT_CD(+)" ).append("\n"); 
		query.append("                AND NTFY.BKG_CUST_TP_CD(+) = 'N'        " ).append("\n"); 
		query.append("                AND 'O'              = NTFY.BND_TP_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                AND BL.VSL_CD        = BC.VSL_CD(+)" ).append("\n"); 
		query.append("                AND BL.SKD_VOY_NO    = BC.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                AND BL.SKD_DIR_CD    = BC.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                AND BL.BL_NO         = BC.BL_NO(+)" ).append("\n"); 
		query.append("                AND BL.CSTMS_PORT_CD = BC.CSTMS_PORT_CD(+)" ).append("\n"); 
		query.append("                AND 'O'              = BC.BND_TP_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                AND BL.MSG_SND_NO    = SND.MSG_SND_NO(+)" ).append("\n"); 
		query.append("                AND 'O'              = SND.BND_TP_CD(+)" ).append("\n"); 
		query.append("                AND BL.VSL_CD        = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("                AND BL.SKD_VOY_NO    = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("                AND BL.SKD_DIR_CD    = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("                AND BL.CSTMS_PORT_CD = @[cstms_port_cd]" ).append("\n"); 
		query.append("                AND BL.BL_NO =@[bl_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            ) X" ).append("\n"); 
		query.append("          ) XX" ).append("\n"); 
		query.append("         ) XXX" ).append("\n"); 
		query.append("        ) Y " ).append("\n"); 
		query.append("    ,( SELECT ( SELECT EUR_CSTMS_OFC_ID||','||ENS_EDI_SVC_FLG||','||EXS_EDI_SVC_FLG" ).append("\n"); 
		query.append("        FROM BKG_CSTMS_EUR_CD_STUP" ).append("\n"); 
		query.append("        WHERE PORT_CD = @[cstms_port_cd]" ).append("\n"); 
		query.append("        AND TML_CD IN ('ALL' , @[cstms_yd_cd])" ).append("\n"); 
		query.append("        AND ROWNUM =1" ).append("\n"); 
		query.append("        ) AS PORT_OFC_CD_SVC_FLG" ).append("\n"); 
		query.append("        FROM DUAL" ).append("\n"); 
		query.append("        ) PORT_OFC  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   WHERE ROWNUM=1" ).append("\n"); 
		query.append("  ) AS ERR_YNS" ).append("\n"); 
		query.append("/************************** 에러 BL여부 체크 끝***********************/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  , MVMT_REF_NO1 AS MVMT_REF_NO " ).append("\n"); 
		query.append("  , NVL(KTS_SEND_DT1,KTS_SEND_DT2)AS KTS_SEND_DT " ).append("\n"); 
		query.append(",KK.*" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT BL.BL_NO," ).append("\n"); 
		query.append("  BL.CSTMS_PORT_CD," ).append("\n"); 
		query.append("  '' TYPE_CD," ).append("\n"); 
		query.append("  --SND.MSG_FUNC_ID," ).append("\n"); 
		query.append("  SND.VSL_CD," ).append("\n"); 
		query.append("  SND.SKD_VOY_NO," ).append("\n"); 
		query.append("  SND.SKD_DIR_CD," ).append("\n"); 
		query.append("  TO_CHAR(SND.SND_DT, 'YYYY-MM-DD HH24:MI-SS') SND_DT," ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  NVL(BL.MVMT_REF_NO,( SELECT MVMT_REF_NO" ).append("\n"); 
		query.append("								        FROM BKG_CSTMS_EUR_IO_BL EBL" ).append("\n"); 
		query.append("								       WHERE EBL.MSG_SND_NO    = (SELECT MAX(MSG_SND_NO) " ).append("\n"); 
		query.append("                                    							 	FROM BKG_CSTMS_EUR_IO_SND" ).append("\n"); 
		query.append("								                                   WHERE BL_NO          = BL.BL_NO" ).append("\n"); 
		query.append("                                								     AND CSTMS_PORT_CD  = BL.CSTMS_PORT_CD" ).append("\n"); 
		query.append("                                                                     AND BND_TP_CD = 'O'" ).append("\n"); 
		query.append("                                                    				 AND (VSL_CD != BL.VSL_CD OR SKD_VOY_NO != BL.SKD_VOY_NO OR SKD_DIR_CD != BL.SKD_DIR_CD)" ).append("\n"); 
		query.append("									                               )" ).append("\n"); 
		query.append("                                       AND   EBL.BND_TP_CD = 'O'" ).append("\n"); 
		query.append("								      )" ).append("\n"); 
		query.append("     ) AS MVMT_REF_NO1," ).append("\n"); 
		query.append("  DECODE(BL.MVMT_REF_NO,NULL,'N','Y') AS BL_MRN_YN," ).append("\n"); 
		query.append("  TO_CHAR(SND.CRE_DT,'YYYYMMDDHH24MI') AS KTS_SEND_DT1," ).append("\n"); 
		query.append(" (SELECT MAX(TO_CHAR(CRE_DT,'YYYYMMDDHH24')) " ).append("\n"); 
		query.append("    FROM BKG_CSTMS_EUR_IO_SND  " ).append("\n"); 
		query.append("   WHERE BL_NO          = BL.BL_NO" ).append("\n"); 
		query.append("     AND CSTMS_PORT_CD  = BL.CSTMS_PORT_CD" ).append("\n"); 
		query.append("     AND BND_TP_CD = 'O'" ).append("\n"); 
		query.append("  ) AS  KTS_SEND_DT2," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  BL.VSL_CD||BL.SKD_VOY_NO||BL.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("  VSL.VSL_ENG_NM," ).append("\n"); 
		query.append("  VSL.LLOYD_NO," ).append("\n"); 
		query.append("  BKG.POR_CD," ).append("\n"); 
		query.append("  BL.BKG_POL_CD," ).append("\n"); 
		query.append("  BL.BKG_POD_CD," ).append("\n"); 
		query.append("  BKG.DEL_CD," ).append("\n"); 
		query.append("  BKG.RCV_TERM_CD," ).append("\n"); 
		query.append("  BKG.DE_TERM_CD," ).append("\n"); 
		query.append("  BL.PCK_QTY," ).append("\n"); 
		query.append("  BL.PCK_TP_CD," ).append("\n"); 
		query.append("  BL.ACT_WGT," ).append("\n"); 
		query.append("  BL.WGT_UT_CD," ).append("\n"); 
		query.append("  BL.MEAS_QTY," ).append("\n"); 
		query.append("  BL.MEAS_UT_CD," ).append("\n"); 
		query.append("  BL.CSTMS_DESC," ).append("\n"); 
		query.append("  BL.POL_CD," ).append("\n"); 
		query.append("  BL.POD_CD," ).append("\n"); 
		query.append("  BL.POL_NM," ).append("\n"); 
		query.append("  BL.POD_NM," ).append("\n"); 
		query.append("  BL.DEL_NM," ).append("\n"); 
		query.append("  BL.CMDT_CD," ).append("\n"); 
		query.append("  BL.TRSP_DOC_NO," ).append("\n"); 
		query.append("  BL.CSTMS_DECL_DT," ).append("\n"); 
		query.append("  BL.DECL_LOC_CD," ).append("\n"); 
		query.append("  BL.MSG_SND_NO," ).append("\n"); 
		query.append("  BL.POL_YD_CD," ).append("\n"); 
		query.append("  BL.POD_YD_CD," ).append("\n"); 
		query.append("  Y.RESULT MSG_FUNC_ID," ).append("\n"); 
		query.append("  Y.ACK_CD ACK_CD," ).append("\n"); 
		query.append("  Y.HIS_ACK_CD HIS_ACK_CD," ).append("\n"); 
		query.append("  '' RCV_MVMT_REF_NO," ).append("\n"); 
		query.append("  '' PREV_DOC_NO," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT DECODE(CNT_CD, 'ES', MF_NO||REF_GDS_ITM_NM, 'PT', REF_GDS_ITM_NM, '')||'@@@'||PRE_VSL_DCHG_YD_NM" ).append("\n"); 
		query.append("    FROM BKG_CSTMS_EUR_CRN_RCV" ).append("\n"); 
		query.append("    WHERE BL_NO = BKG.BL_NO" ).append("\n"); 
		query.append("    AND MSG_FUNC_ID = 'F'" ).append("\n"); 
		query.append("  ) AS SEARCH_PREV_DOC_NO," ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  BKG_JOIN_CLOB_FNC(CURSOR(SELECT  DISTINCT DECODE(CNT_CD, 'ES', MF_NO||REF_GDS_ITM_NM, 'PT', REF_GDS_ITM_NM, '')" ).append("\n"); 
		query.append("                            FROM BKG_CSTMS_EUR_CRN_RCV CRN " ).append("\n"); 
		query.append("                            WHERE CRN.BL_NO = BKG.BL_NO" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                   ,'|') AS PREV_DOC_NOS" ).append("\n"); 
		query.append("  , Y.LOCAL_TIME                   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM BKG_CSTMS_EUR_IO_BL BL, BKG_CSTMS_EUR_IO_SND SND, MDM_VSL_CNTR VSL, BKG_BOOKING BKG," ).append("\n"); 
		query.append("(SELECT " ).append("\n"); 
		query.append("CASE " ).append("\n"); 
		query.append("    WHEN ACK_CD = 'A' THEN 'Accepted' ||DECODE(ACK_KND_ID, 'S', '(S)') " ).append("\n"); 
		query.append("    WHEN ACK_CD = 'R' AND RESULT_CD ='351' THEN 'Do Not Load' ||DECODE(ACK_KND_ID, 'S', '(S)') " ).append("\n"); 
		query.append("    WHEN ACK_CD = 'R' THEN 'Rejected' ||DECODE(ACK_KND_ID, 'S', '(S)')" ).append("\n"); 
		query.append("    WHEN ACK_CD = 'D' THEN 'Hold(Doc)' ||DECODE(ACK_KND_ID, 'S', '(S)') " ).append("\n"); 
		query.append("    WHEN ACK_CD = 'P' THEN 'Hold(Phys)' ||DECODE(ACK_KND_ID, 'S', '(S)')" ).append("\n"); 
		query.append("    WHEN ACK_CD = 'L' THEN 'Hold Release' ||DECODE(ACK_KND_ID, 'S', '(S)')  " ).append("\n"); 
		query.append("    WHEN MSG_SND_NO IS NOT NULL AND RCV IS NULL THEN 'Not Received' END " ).append("\n"); 
		query.append("        AS RESULT" ).append("\n"); 
		query.append(", ACK_CD" ).append("\n"); 
		query.append(", HIS_ACK_CD  " ).append("\n"); 
		query.append(", TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC('SELSC', CRE_DT, SND_USR_OFC_CD ), 'YYYY-MM-DD HH24:MI') AS LOCAL_TIME" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT X.RCV," ).append("\n"); 
		query.append("      X.MSG_SND_NO," ).append("\n"); 
		query.append("      COUNT(MSG_SND_NO) OVER() AS SENT_BL_CNT ," ).append("\n"); 
		query.append("      BKG_GET_TOKEN_FNC(RCV, 2) AS EDI_RCV_SEQ ," ).append("\n"); 
		query.append("      BKG_GET_TOKEN_FNC(RCV, 3) AS ACK_CD ," ).append("\n"); 
		query.append("      TO_DATE(BKG_GET_TOKEN_FNC(RCV, 4), 'YYYY-MM-DD HH24:MI') AS CRE_DT ," ).append("\n"); 
		query.append("      BKG_GET_TOKEN_FNC(RCV, 5) AS RESULT_CD ," ).append("\n"); 
		query.append("      BKG_GET_TOKEN_FNC(RCV, 6) AS ACK_KND_ID ," ).append("\n"); 
		query.append("      BKG_GET_TOKEN_FNC(RCV, 7) AS HIS_ACK_CD , " ).append("\n"); 
		query.append("      X.SND_USR_OFC_CD" ).append("\n"); 
		query.append("    FROM ( " ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("          A.MSG_SND_NO ," ).append("\n"); 
		query.append("          SND.SND_USR_OFC_CD ," ).append("\n"); 
		query.append("          (" ).append("\n"); 
		query.append("            SELECT AA.EDI_RCV_DT||','||AA.EDI_RCV_SEQ||','|| AA.ACK_RCV_STS_CD||','|| TO_CHAR(AA.CRE_DT, 'YYYY-MM-DD HH24:MI')||','||AA.EUR_CSTMS_ACK_CD||','||AA.ACK_KND_ID||','||BB.ACK_RCV_STS_CD" ).append("\n"); 
		query.append("              FROM BKG_CSTMS_EUR_IO_RCV AA" ).append("\n"); 
		query.append("                , ( SELECT DISTINCT MSG_RCV_NO, ACK_RCV_STS_CD" ).append("\n"); 
		query.append("                      FROM BKG_CSTMS_EUR_IO_RCV" ).append("\n"); 
		query.append("                     WHERE BND_TP_CD = 'O'" ).append("\n"); 
		query.append("                       AND EDI_RCV_DT > ' '" ).append("\n"); 
		query.append("                       AND EDI_RCV_SEQ > 0" ).append("\n"); 
		query.append("--                       AND MSG_RCV_NO = SND.MSG_SND_NO" ).append("\n"); 
		query.append("                       AND ACK_RCV_STS_CD <> 'L'        " ).append("\n"); 
		query.append("                ) BB" ).append("\n"); 
		query.append("             WHERE AA.RCV_TMS = (" ).append("\n"); 
		query.append("                SELECT MAX(RCV_TMS)" ).append("\n"); 
		query.append("                  FROM BKG_CSTMS_EUR_IO_RCV" ).append("\n"); 
		query.append("                 WHERE MSG_RCV_NO = SND.MSG_SND_NO" ).append("\n"); 
		query.append("                   AND BND_TP_CD = 'O'" ).append("\n"); 
		query.append("                   AND EDI_RCV_DT > ' '" ).append("\n"); 
		query.append("                   AND EDI_RCV_SEQ > 0" ).append("\n"); 
		query.append("                   AND (ACK_KND_ID != 'S' OR ACK_RCV_STS_CD != 'A') )" ).append("\n"); 
		query.append("               AND  AA.BND_TP_CD = 'O'" ).append("\n"); 
		query.append("               AND  AA.EDI_RCV_DT > ' '" ).append("\n"); 
		query.append("               AND  AA.EDI_RCV_SEQ > 0" ).append("\n"); 
		query.append("               AND  AA.MSG_RCV_NO = BB.MSG_RCV_NO) RCV" ).append("\n"); 
		query.append("        FROM BKG_CSTMS_EUR_IO_BL A, BKG_CSTMS_EUR_IO_SND SND" ).append("\n"); 
		query.append("        WHERE A.MSG_SND_NO = SND.MSG_SND_NO(+)" ).append("\n"); 
		query.append("          AND A.BND_TP_CD = 'O'" ).append("\n"); 
		query.append("          AND 'O' = SND.BND_TP_CD(+)" ).append("\n"); 
		query.append("          AND A.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("          AND A.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("          AND A.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("          AND A.CSTMS_PORT_CD = @[cstms_port_cd]" ).append("\n"); 
		query.append("          AND A.BL_NO = @[bl_no] ) X )) Y" ).append("\n"); 
		query.append("WHERE BL.BL_NO = SND.BL_NO(+)" ).append("\n"); 
		query.append("  AND BKG.BL_NO = BL.BL_NO" ).append("\n"); 
		query.append("  AND BL.VSL_CD = VSL.VSL_CD" ).append("\n"); 
		query.append("  AND BL.VSL_CD = SND.VSL_CD(+)" ).append("\n"); 
		query.append("  AND BL.SKD_VOY_NO = SND.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("  AND BL.SKD_DIR_CD = SND.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("  AND BL.MSG_SND_NO = SND.MSG_SND_NO(+)" ).append("\n"); 
		query.append("  AND BL.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("  AND BL.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("  AND BL.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("  AND BL.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("  AND BL.CSTMS_PORT_CD = @[cstms_port_cd]" ).append("\n"); 
		query.append("  AND BL.BND_TP_CD = 'O'" ).append("\n"); 
		query.append("  AND 'O' = SND.BND_TP_CD(+)" ).append("\n"); 
		query.append("  AND BL.ROWID = (" ).append("\n"); 
		query.append("    SELECT ROWID" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT ROWID" ).append("\n"); 
		query.append("        FROM BKG_CSTMS_EUR_IO_BL A" ).append("\n"); 
		query.append("        WHERE A.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("          AND A.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("          AND A.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("          AND A.CSTMS_PORT_CD = @[cstms_port_cd]" ).append("\n"); 
		query.append("          AND A.BL_NO =  @[bl_no]" ).append("\n"); 
		query.append("          AND A.BND_TP_CD = 'O')" ).append("\n"); 
		query.append("    WHERE ROWNUM = 1)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") KK" ).append("\n"); 
		query.append(") KKK" ).append("\n"); 

	}
}