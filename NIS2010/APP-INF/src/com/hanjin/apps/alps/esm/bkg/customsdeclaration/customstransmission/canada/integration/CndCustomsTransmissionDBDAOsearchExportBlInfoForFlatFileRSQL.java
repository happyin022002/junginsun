/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CndCustomsTransmissionDBDAOsearchExportBlInfoForFlatFileRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndCustomsTransmissionDBDAOsearchExportBlInfoForFlatFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Flat 생성
	  * </pre>
	  */
	public CndCustomsTransmissionDBDAOsearchExportBlInfoForFlatFileRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("t_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.integration").append("\n"); 
		query.append("FileName : CndCustomsTransmissionDBDAOsearchExportBlInfoForFlatFileRSQL").append("\n"); 
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
		query.append("SELECT  BL.BKG_NO " ).append("\n"); 
		query.append("      , BL.BL_NO BLNBR " ).append("\n"); 
		query.append("      , NVL(BL.MF_NO, '') MF_NO" ).append("\n"); 
		query.append("      , TO_CHAR(SYSDATE,'YMM')||LTRIM(TO_CHAR(BKG_CSTM_EDI_SEQ.NEXTVAL,'000009'),' ') AS BLSEQ" ).append("\n"); 
		query.append("      , '25'			AS BLTRANS --수출 25" ).append("\n"); 
		query.append("      , '00' AS STATUS" ).append("\n"); 
		query.append("      , '918P'	AS BLREPNO" ).append("\n"); 
		query.append("      , DECODE(BL.CSTMS_MF_TP_CD, 'S10', BL.BKG_NO, BL.BL_NO) AS BLNBR" ).append("\n"); 
		query.append("      , DECODE(BL.CSTMS_MF_TP_CD, 'S10', '918P' || BL.BL_NO, '') AS BLREFNO" ).append("\n"); 
		query.append("      , CVSL.CVY_REF_NO			AS VCREPNO" ).append("\n"); 
		query.append("      , DECODE(BL.CSTMS_FILE_TP_CD, '1', 'Y', '2', 'Y', 'N') AS SMTRIND" ).append("\n"); 
		query.append("      , MVSL.VSL_ENG_NM 		AS VSLNAME" ).append("\n"); 
		query.append("      , BL.VSL_CD || BL.SKD_VOY_NO || BL.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("      , '' 						AS TERMINAL" ).append("\n"); 
		query.append("      , BL.CSTMS_POL_CD			AS BLPOL" ).append("\n"); 
		query.append("      , TO_CHAR(SKD.VPS_ETD_DT, 'YYYYMMDD')		AS POLETD" ).append("\n"); 
		query.append("      , BL.CSTMS_POD_CD			AS BLPOD" ).append("\n"); 
		query.append("      , TO_CHAR(NEW_TIME(GLOBALDATE_PKG.TIME_CONV_FNC(BL.CSTMS_POL_CD, SKD.VPS_ETB_DT + 1/24, 'GMT'), 'GMT', 'EDT') , 'YYYYMMDDHH24MI') AS POLETL" ).append("\n"); 
		query.append("      , DECODE(BL.CUST_TO_ORD_FLG, 'Y', '1', '0') AS TO_ORDER" ).append("\n"); 
		query.append("      , SUBSTR(BKG_SPCLCHAR_CONV_FNC(CS.CUST_NM ,'M'),1,175) AS SHPRNAME" ).append("\n"); 
		query.append("      , SUBSTR(BKG_SPCLCHAR_CONV_FNC(CS.CUST_ADDR ,'M'),1,105) AS SHPRADDR" ).append("\n"); 
		query.append("      , TRIM(CS.CUST_CTY_NM)	AS SHPRCITY" ).append("\n"); 
		query.append("      , TRIM(DECODE(CS.CSTMS_DECL_CNT_CD,'US',NVL(CS.CUST_STE_CD,' '),'CA',NVL(CS.CUST_STE_CD,' '),'AU',NVL(CS.CUST_STE_CD,' '),' '))	AS SHPRSTAT" ).append("\n"); 
		query.append("      , TRIM(CS.CSTMS_DECL_CNT_CD)	AS SHPRCTRY" ).append("\n"); 
		query.append("      , TRIM(CS.CUST_ZIP_ID)	AS SHPRZIP" ).append("\n"); 
		query.append("      , SUBSTR(BKG_SPCLCHAR_CONV_FNC(CC.CUST_NM ,'M'),1,175)	AS CNEENAME" ).append("\n"); 
		query.append("      , SUBSTR(BKG_SPCLCHAR_CONV_FNC(CC.CUST_ADDR ,'M'),1,105) AS CNEEADDR" ).append("\n"); 
		query.append("      , TRIM(CC.CUST_CTY_NM)    AS CNEECITY" ).append("\n"); 
		query.append("      , TRIM(DECODE(CC.CSTMS_DECL_CNT_CD,'US',NVL(CC.CUST_STE_CD,' '),'CA',NVL(CC.CUST_STE_CD,' '),'AU',NVL(CC.CUST_STE_CD,' '),' ')) AS CNEESTAT" ).append("\n"); 
		query.append("      , TRIM(CC.CSTMS_DECL_CNT_CD)    AS CNEECTRY" ).append("\n"); 
		query.append("      , TRIM(CC.CUST_ZIP_ID)    AS CNEEZIP" ).append("\n"); 
		query.append("      , CASE WHEN BL.CSTMS_MF_TP_CD = 'A6A' OR BL.CSTMS_MF_TP_CD = 'S10' " ).append("\n"); 
		query.append("             THEN SUBSTR(BKG_SPCLCHAR_CONV_FNC(CN.CUST_NM ,'M'),1,175)" ).append("\n"); 
		query.append("        END AS NTFYNAME" ).append("\n"); 
		query.append("      , CASE WHEN BL.CSTMS_MF_TP_CD = 'A6A' OR BL.CSTMS_MF_TP_CD = 'S10' " ).append("\n"); 
		query.append("             THEN SUBSTR(BKG_SPCLCHAR_CONV_FNC(CN.CUST_ADDR ,'M'),1,105)" ).append("\n"); 
		query.append("        END AS NTFYADDR" ).append("\n"); 
		query.append("      , CASE WHEN BL.CSTMS_MF_TP_CD = 'A6A' OR BL.CSTMS_MF_TP_CD = 'S10' " ).append("\n"); 
		query.append("             THEN TRIM(CN.CUST_CTY_NM)" ).append("\n"); 
		query.append("        END AS NTFYCITY" ).append("\n"); 
		query.append("      , CASE WHEN BL.CSTMS_MF_TP_CD = 'A6A' OR BL.CSTMS_MF_TP_CD = 'S10' " ).append("\n"); 
		query.append("             THEN TRIM(DECODE(CN.CSTMS_DECL_CNT_CD,'US',NVL(CN.CUST_STE_CD,' '),'CA',NVL(CN.CUST_STE_CD,' '),'AU',NVL(CN.CUST_STE_CD,' '),' '))" ).append("\n"); 
		query.append("        END AS NTFYSTAT" ).append("\n"); 
		query.append("      , CASE WHEN BL.CSTMS_MF_TP_CD = 'A6A' OR BL.CSTMS_MF_TP_CD = 'S10' " ).append("\n"); 
		query.append("             THEN TRIM(CN.CSTMS_DECL_CNT_CD)" ).append("\n"); 
		query.append("        END AS NTFYCTRY" ).append("\n"); 
		query.append("      , CASE WHEN BL.CSTMS_MF_TP_CD = 'A6A' OR BL.CSTMS_MF_TP_CD = 'S10' " ).append("\n"); 
		query.append("             THEN TRIM(CN.CUST_ZIP_ID)" ).append("\n"); 
		query.append("        END AS NTFYZIP" ).append("\n"); 
		query.append("      , TRIM(BL.IN_TZ_YD_CD) AS DELLYARDCD" ).append("\n"); 
		query.append("      , SUBSTR(BKG_SPCLCHAR_CONV_FNC( SUBSTR(  BL.IN_TZ_YD_NM   , 1, INSTR(BL.IN_TZ_YD_NM||CHR(13) ,  CHR(13) ,1,1 ) ) ,'M'),1,175) AS DELLNAME" ).append("\n"); 
		query.append("      , SUBSTR(BKG_SPCLCHAR_CONV_FNC( SUBSTR(  BL.IN_TZ_YD_NM   , INSTR(BL.IN_TZ_YD_NM||CHR(13) ,  CHR(13)    ,1,1 ) ) ,'M'),1,175) AS DELLNAME2" ).append("\n"); 
		query.append("      , SUBSTR(BKG_SPCLCHAR_CONV_FNC(BL.IN_TZ_YD_ADDR,'M'),1,105) AS DELLADDR" ).append("\n"); 
		query.append("      , TRIM(BL.IN_TZ_YD_CTY_NM) AS DELLCITY" ).append("\n"); 
		query.append("      , TRIM(BL.IN_TZ_YD_STE_CD) AS DELLSTAT" ).append("\n"); 
		query.append("      , TRIM(BL.IN_TZ_YD_CNT_CD) AS DELLCTRY" ).append("\n"); 
		query.append("      , TRIM(BL.IN_TZ_YD_ZIP_ID) AS DELLZIP" ).append("\n"); 
		query.append("      , SUBSTR(REPLACE(REPLACE(NVL(MPOR.LOC_NM,'.'),CHR(42),CHR(32)),CHR(13)||CHR(10),' '),1,175) AS PORNAME" ).append("\n"); 
		query.append("      , SUBSTR(REPLACE(REPLACE(NVL(MPOL.LOC_NM,'.'),CHR(42),CHR(32)),CHR(13)||CHR(10),' '),1,175) AS POLNAME" ).append("\n"); 
		query.append("      , BL.POR_CD				AS PORCODE" ).append("\n"); 
		query.append("      , SUBSTR(REPLACE(REPLACE(NVL(MDEL.LOC_NM,'.'),CHR(42),CHR(32)),CHR(13)||CHR(10),' '),1,175) AS DELNAME" ).append("\n"); 
		query.append("      , (" ).append("\n"); 
		query.append("           SELECT  SUBSTR( MAX( NVL( POD_YD_NO, '  ') ||GDS_DESC) , 3)" ).append("\n"); 
		query.append("           FROM    BKG_CSTMS_CND_GDS_LOC GL" ).append("\n"); 
		query.append("           WHERE   1 = 1" ).append("\n"); 
		query.append("           AND     GL.POD_CD = BL.CSTMS_POD_CD" ).append("\n"); 
		query.append("           AND     GL.DEL_CD = BL.DEL_CD" ).append("\n"); 
		query.append("           AND     NVL(POD_YD_NO, 'NL' ) IN ('NL',SUBSTR(BL.POD_NOD_CD, 6) )" ).append("\n"); 
		query.append("        ) AS IBD_LOC_GDS_DESC" ).append("\n"); 
		query.append("      , BL.DEL_CD				AS DELCODE" ).append("\n"); 
		query.append("      --, BL.USR_CMT_CTNT 		AS COMMENT1" ).append("\n"); 
		query.append("      , BL.CSTMS_MF_TP_CD       AS CSTMS_MF_TP_CD" ).append("\n"); 
		query.append("      , BL.VSL_CD" ).append("\n"); 
		query.append("      , BL.SKD_VOY_NO" ).append("\n"); 
		query.append("      , BL.SKD_DIR_CD" ).append("\n"); 
		query.append("      , BL.HUB_LOC_CD" ).append("\n"); 
		query.append("	  , FPOA.LOC_CD FPOA" ).append("\n"); 
		query.append("      , (  SELECT M.CSTMS_CD" ).append("\n"); 
		query.append("           FROM MDM_LOCATION M" ).append("\n"); 
		query.append("           WHERE M.LOC_CD = BL.CSTMS_PORT_CD" ).append("\n"); 
		query.append("        ) CUSTOFCO" ).append("\n"); 
		query.append("      , CASE WHEN BL.CSTMS_POD_CD LIKE 'US%' -- FROB 건, DEPARTING CANADA PORT. US 기항전 가장 마지막 CA PORT" ).append("\n"); 
		query.append("                  THEN (  SELECT  SUBSTR(MAX(TO_CHAR(V2.VPS_ETA_DT, 'YYYYMMDDHH24MISS')|| TRIM(M.CSTMS_CD)), 15)" ).append("\n"); 
		query.append("                          FROM    VSK_VSL_PORT_SKD V2" ).append("\n"); 
		query.append("                                , BKG_VVD V" ).append("\n"); 
		query.append("                                , MDM_LOCATION M" ).append("\n"); 
		query.append("                          WHERE V.BKG_NO= BL.BKG_NO" ).append("\n"); 
		query.append("                          AND V2.VSL_CD      = V.VSL_CD" ).append("\n"); 
		query.append("                          AND V2.SKD_VOY_NO  = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                          AND V2.SKD_DIR_CD  = V.SKD_DIR_CD" ).append("\n"); 
		query.append("                          AND NVL(V2.SKD_CNG_STS_CD, 'N') <> 'S'" ).append("\n"); 
		query.append("                          AND V2.VPS_PORT_CD LIKE 'CA%'" ).append("\n"); 
		query.append("                          AND V2.VPS_PORT_CD = M.LOC_CD" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("                -- 나머지 CA Dest, CAtoUS Intransit 건. POD,DEL간의 관계인 Locations of goods setup화면에 GDS_DESC 값 사용" ).append("\n"); 
		query.append("        -- CA local looks up MDM customs id." ).append("\n"); 
		query.append("             WHEN BL.HUB_LOC_CD LIKE 'CA%'  THEN MHUB.CSTMS_CD" ).append("\n"); 
		query.append("        -- CAtoUS intransit looks up Goods Locations table." ).append("\n"); 
		query.append("                  ELSE ( " ).append("\n"); 
		query.append("                          SELECT  SUBSTR( MAX( NVL( POD_YD_NO, '  ') ||CSTMS_CD) , 3)" ).append("\n"); 
		query.append("                          FROM    BKG_CSTMS_CND_GDS_LOC GL" ).append("\n"); 
		query.append("                          WHERE   1 = 1" ).append("\n"); 
		query.append("                          AND     GL.POD_CD = BL.CSTMS_POD_CD" ).append("\n"); 
		query.append("                          AND     GL.DEL_CD = BL.DEL_CD" ).append("\n"); 
		query.append("                          AND     NVL(GL.POD_YD_NO, 'NL' ) IN ('NL',SUBSTR(BL.POD_NOD_CD, 6) )" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("        END CUSTOFCD  -- tobe" ).append("\n"); 
		query.append("      ,TRIM(MHUB.CSTMS_CD) OLD_OFCD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT  VVD.VSL_CD || VVD.SKD_VOY_NO || VVD.SKD_DIR_CD AS VVD_CD" ).append("\n"); 
		query.append("               ,VVD.VSL_CD" ).append("\n"); 
		query.append("               ,VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("               ,VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("               ,VVD.CSTMS_POL_CD" ).append("\n"); 
		query.append("               ,VVD.CSTMS_POD_CD" ).append("\n"); 
		query.append("               ,VVD.POR_CD" ).append("\n"); 
		query.append("               ,VVD.DEL_CD" ).append("\n"); 
		query.append("               ,VVD.BKG_NO" ).append("\n"); 
		query.append("               ,VVD.BL_NO" ).append("\n"); 
		query.append("               ,VVD.MF_NO" ).append("\n"); 
		query.append("               ,TO_CHAR(SKD.VPS_ETD_DT,'YYYY-MM-DD HH24:MI:SS') AS ETD_DT" ).append("\n"); 
		query.append("               ,TO_CHAR(ACT_SKD.ACT_DEP_DT, 'YYYY-MM-DD HH24:MI:SS') ACT_DEP_DT       " ).append("\n"); 
		query.append("               ,DECODE(SUBSTR(VVD.CSTMS_POD_CD, 1,2), 'CA', 'N', 'Y') AS FROB_FLG" ).append("\n"); 
		query.append("               --,TO_CHAR(Z2.VPS_ETB_DT + 1/24,'YYYY-MM-DD HH24:MI:SS') AS ETL_DT" ).append("\n"); 
		query.append("               ,CASE WHEN VVD.BKG_CGO_TP_CD = 'P' THEN 'E10'" ).append("\n"); 
		query.append("                     WHEN VVD.MF_NO > ' ' THEN 'S10'" ).append("\n"); 
		query.append("                     ELSE 'A6A' END CSTMS_MF_TP_CD" ).append("\n"); 
		query.append("               ,CSTMS_FILE_TP_CD" ).append("\n"); 
		query.append("               ,EMP_FLG" ).append("\n"); 
		query.append("              , (" ).append("\n"); 
		query.append("                   SELECT  SUBSTR( MAX( NVL( POD_YD_NO, '  ') ||HUB_LOC_CD) , 3)" ).append("\n"); 
		query.append("                   FROM    BKG_CSTMS_CND_GDS_LOC GL" ).append("\n"); 
		query.append("                   WHERE   1 = 1" ).append("\n"); 
		query.append("                   AND     GL.POD_CD = VVD.CSTMS_POL_CD" ).append("\n"); 
		query.append("                   --AND     GL.DEL_CD = VVD.DEL_CD" ).append("\n"); 
		query.append("                   AND     NVL(GL.POD_YD_NO, 'NL' ) IN ('NL',SUBSTR(VVD.POL_NOD_CD, 6) )" ).append("\n"); 
		query.append("                   AND     ROWNUM = 1 " ).append("\n"); 
		query.append("                ) AS HUB_LOC_CD" ).append("\n"); 
		query.append("              , CASE WHEN SUBSTR(VVD.CSTMS_POL_CD, 1, 2) = 'CA' THEN VVD.CSTMS_POL_CD" ).append("\n"); 
		query.append("                     ELSE (  SELECT  SUBSTR(MIN(TO_CHAR(V2.VPS_ETA_DT, 'YYYYMMDDHH24MISS')||V2.VPS_PORT_CD), 15)" ).append("\n"); 
		query.append("                             FROM    VSK_VSL_PORT_SKD V1" ).append("\n"); 
		query.append("                                   , VSK_VSL_PORT_SKD V2" ).append("\n"); 
		query.append("                             WHERE   V1.VSL_CD      = VVD.VSL_CD" ).append("\n"); 
		query.append("                             AND     V1.SKD_VOY_NO  = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                             AND     V1.SKD_DIR_CD  = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                             AND     V1.VPS_PORT_CD = VVD.CSTMS_POL_CD" ).append("\n"); 
		query.append("                             AND     V2.VSL_CD      = V1.VSL_CD" ).append("\n"); 
		query.append("                             AND     V2.SKD_VOY_NO  = V1.SKD_VOY_NO" ).append("\n"); 
		query.append("                             AND     V2.SKD_DIR_CD  = V1.SKD_DIR_CD" ).append("\n"); 
		query.append("                             AND     V2.CLPT_SEQ    > V1.CLPT_SEQ" ).append("\n"); 
		query.append("                             AND     NVL(V2.SKD_CNG_STS_CD, 'N') <> 'S'" ).append("\n"); 
		query.append("                             AND     V2.VPS_PORT_CD LIKE 'CA%')" ).append("\n"); 
		query.append("                END AS CSTMS_PORT_CD       " ).append("\n"); 
		query.append("              , POD_NOD_CD" ).append("\n"); 
		query.append("              , CUST_TO_ORD_FLG    " ).append("\n"); 
		query.append("              , '' AS IN_TZ_YD_CD" ).append("\n"); 
		query.append("              , '' AS IN_TZ_YD_NM" ).append("\n"); 
		query.append("              , '' AS IN_TZ_YD_ADDR" ).append("\n"); 
		query.append("              , '' AS IN_TZ_YD_CTY_NM" ).append("\n"); 
		query.append("              , '' AS IN_TZ_YD_STE_CD" ).append("\n"); 
		query.append("              , '' AS IN_TZ_YD_CNT_CD" ).append("\n"); 
		query.append("              , '' AS IN_TZ_YD_ZIP_ID " ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("                SELECT  BKG.BKG_NO" ).append("\n"); 
		query.append("                       ,BKG.BL_NO" ).append("\n"); 
		query.append("                       ,'' AS MF_NO" ).append("\n"); 
		query.append("                       ,BKG.CND_CSTMS_FILE_CD AS CSTMS_FILE_TP_CD" ).append("\n"); 
		query.append("                       ,BKG.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("                       ,DECODE(BKG.BKG_CGO_TP_CD,'P','Y','N') AS EMP_FLG" ).append("\n"); 
		query.append("                       ,VVD.VSL_CD" ).append("\n"); 
		query.append("                       ,VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                       ,VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                       ,VVD.POL_CD AS CSTMS_POL_CD" ).append("\n"); 
		query.append("                       ,VVD.POD_CD AS CSTMS_POD_CD" ).append("\n"); 
		query.append("                       ,BKG.POR_CD" ).append("\n"); 
		query.append("                       ,BKG.DEL_CD               " ).append("\n"); 
		query.append("                       ,(SELECT MAX(CORR_NO) FROM BKG_CORRECTION WHERE BKG_NO = BKG.BKG_NO) AS CA_NO" ).append("\n"); 
		query.append("                       ,BKG.BKG_STS_CD" ).append("\n"); 
		query.append("                       ,'M' BL_TYPE" ).append("\n"); 
		query.append("                       ,BKG.POD_CD AS BKG_POD_CD" ).append("\n"); 
		query.append("                       ,BKG.DEL_CD AS BKG_DEL_CD" ).append("\n"); 
		query.append("                       ,BKG.POD_NOD_CD" ).append("\n"); 
		query.append("                       ,BKG.POL_NOD_CD        " ).append("\n"); 
		query.append("                      , BKG.CUST_TO_ORD_FLG                         " ).append("\n"); 
		query.append("                  FROM  BKG_VVD VVD" ).append("\n"); 
		query.append("                       ,BKG_BOOKING BKG" ).append("\n"); 
		query.append("                       ,BKG_BL_DOC DOC" ).append("\n"); 
		query.append("                 WHERE  VVD.BKG_NO = @[bl_no]" ).append("\n"); 
		query.append("                   AND  VVD.VSL_CD       = SUBSTR(@[t_vvd_cd],1, 4)" ).append("\n"); 
		query.append("                   AND  VVD.SKD_VOY_NO   = SUBSTR(@[t_vvd_cd],5, 4)" ).append("\n"); 
		query.append("                   AND  VVD.SKD_DIR_CD   = SUBSTR(@[t_vvd_cd],9, 1)" ).append("\n"); 
		query.append("                   AND  VVD.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                   AND  BKG.BKG_NO = DOC.BKG_NO(+)" ).append("\n"); 
		query.append("                   AND  BKG.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("                   AND  BKG.BL_NO IS NOT NULL" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                SELECT  BKG.BKG_NO" ).append("\n"); 
		query.append("                       ,H.CNTR_MF_NO AS BL_NO" ).append("\n"); 
		query.append("                       ,BKG.BL_NO AS MF_NO" ).append("\n"); 
		query.append("                       ,'0' AS CSTMS_FILE_TP_CD" ).append("\n"); 
		query.append("                       ,BKG.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("                       ,'N' AS EMP_FLG" ).append("\n"); 
		query.append("                       ,VVD.VSL_CD" ).append("\n"); 
		query.append("                       ,VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                       ,VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                       ,VVD.POL_CD AS CSTMS_POL_CD" ).append("\n"); 
		query.append("                       ,VVD.POD_CD AS CSTMS_POD_CD" ).append("\n"); 
		query.append("                       ,BKG.POR_CD" ).append("\n"); 
		query.append("                       ,BKG.DEL_CD               " ).append("\n"); 
		query.append("                       ,'' AS CA_NO" ).append("\n"); 
		query.append("                       ,BKG.BKG_STS_CD" ).append("\n"); 
		query.append("                       ,'H' BL_TYPE" ).append("\n"); 
		query.append("                       ,BKG.POD_CD AS BKG_POD_CD" ).append("\n"); 
		query.append("                       ,BKG.DEL_CD AS BKG_DEL_CD" ).append("\n"); 
		query.append("                       ,BKG.POD_NOD_CD           " ).append("\n"); 
		query.append("                       ,BKG.POL_NOD_CD        " ).append("\n"); 
		query.append("                      , BKG.CUST_TO_ORD_FLG                                                  " ).append("\n"); 
		query.append("                  FROM  BKG_VVD VVD" ).append("\n"); 
		query.append("                       ,BKG_BOOKING BKG" ).append("\n"); 
		query.append("                       ,BKG_BL_DOC DOC" ).append("\n"); 
		query.append("                       ,BKG_HBL H" ).append("\n"); 
		query.append("                 WHERE  VVD.BKG_NO = @[bl_no]" ).append("\n"); 
		query.append("                   AND  VVD.VSL_CD       = SUBSTR(@[t_vvd_cd],1, 4)" ).append("\n"); 
		query.append("                   AND  VVD.SKD_VOY_NO   = SUBSTR(@[t_vvd_cd],5, 4)" ).append("\n"); 
		query.append("                   AND  VVD.SKD_DIR_CD   = SUBSTR(@[t_vvd_cd],9, 1)" ).append("\n"); 
		query.append("                   AND  VVD.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                   AND  BKG.BKG_NO = DOC.BKG_NO(+)" ).append("\n"); 
		query.append("                   AND  BKG.BKG_NO = H.BKG_NO" ).append("\n"); 
		query.append("                   AND  BKG.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("                   AND  H.CNTR_MF_NO IS NOT NULL" ).append("\n"); 
		query.append("                   AND  BKG.CND_CSTMS_FILE_CD = '1'" ).append("\n"); 
		query.append("        ) VVD" ).append("\n"); 
		query.append("          ,VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("          ,VSK_ACT_PORT_SKD ACT_SKD" ).append("\n"); 
		query.append("        WHERE   VVD.VSL_CD = SKD.VSL_CD(+)" ).append("\n"); 
		query.append("           AND  VVD.SKD_VOY_NO = SKD.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("           AND  VVD.SKD_DIR_CD = SKD.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("           AND  VVD.CSTMS_POL_CD = SKD.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("           AND  SKD.CLPT_IND_SEQ(+)	= '1'" ).append("\n"); 
		query.append("           AND  NVL(SKD.SKD_CNG_STS_CD(+),'X') != 'S'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           AND  VVD.VSL_CD = ACT_SKD.VSL_CD(+)" ).append("\n"); 
		query.append("           AND  VVD.SKD_VOY_NO = ACT_SKD.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("           AND  VVD.SKD_DIR_CD = ACT_SKD.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("           AND  VVD.CSTMS_POL_CD = ACT_SKD.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("           AND  ACT_SKD.CLPT_IND_SEQ(+)	= '1'" ).append("\n"); 
		query.append("    ) BL" ).append("\n"); 
		query.append("      , BKG_CSTMS_CND_VSL 	CVSL" ).append("\n"); 
		query.append("      , MDM_VSL_CNTR 		MVSL" ).append("\n"); 
		query.append("      , VSK_VSL_PORT_SKD	SKD" ).append("\n"); 
		query.append("      , BKG_CUSTOMER        CS" ).append("\n"); 
		query.append("      , BKG_CUSTOMER        CC" ).append("\n"); 
		query.append("      , BKG_CUSTOMER        CN" ).append("\n"); 
		query.append("      , MDM_LOCATION		MPOR" ).append("\n"); 
		query.append("      , MDM_LOCATION		MPOL" ).append("\n"); 
		query.append("      , MDM_LOCATION		MPOD" ).append("\n"); 
		query.append("      , MDM_LOCATION		MDEL" ).append("\n"); 
		query.append("      , MDM_LOCATION		MHUB" ).append("\n"); 
		query.append("	  , MDM_LOCATION		FPOA" ).append("\n"); 
		query.append("WHERE   BL.VSL_CD		= CVSL.VSL_CD(+)" ).append("\n"); 
		query.append("AND     BL.SKD_VOY_NO 	= CVSL.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND     BL.SKD_DIR_CD 	= CVSL.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND     BL.VSL_CD 		= MVSL.VSL_CD(+)" ).append("\n"); 
		query.append("AND     BL.VSL_CD		= SKD.VSL_CD(+)" ).append("\n"); 
		query.append("AND     BL.SKD_VOY_NO 	= SKD.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND     BL.SKD_DIR_CD 	= SKD.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND     BL.CSTMS_POL_CD = SKD.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("AND     SKD.CLPT_IND_SEQ(+) = '1'" ).append("\n"); 
		query.append("AND     BL.BKG_NO		= CS.BKG_NO(+)" ).append("\n"); 
		query.append("AND     CS.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("AND     BL.BKG_NO		= CC.BKG_NO(+)" ).append("\n"); 
		query.append("AND     CC.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("AND     BL.BKG_NO		= CN.BKG_NO(+)" ).append("\n"); 
		query.append("AND     CN.BKG_CUST_TP_CD(+) = 'N'      " ).append("\n"); 
		query.append("AND     BL.POR_CD		= MPOR.LOC_CD(+)" ).append("\n"); 
		query.append("AND     BL.CSTMS_POL_CD	= MPOL.LOC_CD(+)" ).append("\n"); 
		query.append("AND     BL.CSTMS_POD_CD		= MPOD.LOC_CD(+)" ).append("\n"); 
		query.append("AND     BL.DEL_CD		= MDEL.LOC_CD(+)" ).append("\n"); 
		query.append("AND     BL.HUB_LOC_CD	= MHUB.LOC_CD(+)" ).append("\n"); 
		query.append("AND     FPOA.LOC_CD = (  SELECT  SUBSTR(MIN(TO_CHAR(V1.VPS_ETA_DT, 'YYYYMMDDHH24MISS')||V1.VPS_PORT_CD),15)" ).append("\n"); 
		query.append(" 						 FROM    VSK_VSL_PORT_SKD V1" ).append("\n"); 
		query.append("						 WHERE   V1.VSL_CD = BL.VSL_CD" ).append("\n"); 
		query.append("						 AND     V1.SKD_VOY_NO = BL.SKD_VOY_NO" ).append("\n"); 
		query.append("						 AND     V1.SKD_DIR_CD = BL.SKD_DIR_CD" ).append("\n"); 
		query.append("						 AND     NVL(V1.SKD_CNG_STS_CD, 'N') <> 'S'" ).append("\n"); 
		query.append("						 AND     V1.VPS_PORT_CD LIKE 'CA%'" ).append("\n"); 
		query.append("					  )" ).append("\n"); 

	}
}