/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : IndiaCustomsTransmissionDBDAOsearchBlListByVvdPolPodRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.india.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IndiaCustomsTransmissionDBDAOsearchBlListByVvdPolPodRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 전송 대상 B/L을 가져옴
	  * </pre>
	  */
	public IndiaCustomsTransmissionDBDAOsearchBlListByVvdPolPodRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.india.integration").append("\n"); 
		query.append("FileName : IndiaCustomsTransmissionDBDAOsearchBlListByVvdPolPodRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("        SUBSTR(CALL_SGN_NO, 1, 7) CALL_SGN_NO" ).append("\n"); 
		query.append("        ,BCIV.SKD_VOY_NO SKD_VOY_NO" ).append("\n"); 
		query.append("        ,BCIV.IDA_DECL_VSL_NO " ).append("\n"); 
		query.append("        ,VSL_DECL_DT        " ).append("\n"); 
		query.append("        ,BCIB.IDA_LINE_NO    " ).append("\n"); 
		query.append("        ,'0' TMP0" ).append("\n"); 
		query.append("        ,DECODE(BCIB.BL_NO, BCIB.NVOCC_REF_NO, 'SMLM'||BCIB.BL_NO, BCIB.NVOCC_REF_NO) NEW_BL_NO" ).append("\n"); 
		query.append("        ,TO_CHAR(BBD.BL_OBRD_DT, 'DDMMYYYY') BL_OBRD_DT" ).append("\n"); 
		query.append("        ,BCIB.POL_CD" ).append("\n"); 
		query.append("        ,SUBSTR(BCIB.IDA_DEST_CD, 1, 6) IDA_DEST_CD" ).append("\n"); 
		query.append("        ,'' TMP1" ).append("\n"); 
		query.append("        ,'' TMP2" ).append("\n"); 
		query.append("        ,REPLACE( REPLACE( REPLACE(DECODE(BCIB.BL_NO, BCIB.NVOCC_REF_NO, DECODE(NVL(BB.CUST_TO_ORD_FLG,'N'), 'Y', SUBSTR(BC1.CUST_NM, 1, 35), SUBSTR(BC.CUST_NM, 1, 35)), C_BHC.CUST_NM ), CHR(13)||CHR(10), ''), CHR(13), ''), CHR(10), '') C_CUST_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ,REPLACE( REPLACE(REPLACE(DECODE(BCIB.BL_NO, BCIB.NVOCC_REF_NO, DECODE(NVL(BB.CUST_TO_ORD_FLG,'N'), 'Y', REPLACE(SUBSTR(BC1.CUST_ADDR, 1, 35), CHR(13)||CHR(10), '')|| CHR(29)|| REPLACE(SUBSTR(BC1.CUST_ADDR, 36, 35), CHR(13)||CHR(10), '')|| CHR(29)|| REPLACE(SUBSTR(BC1.CUST_ADDR, 71, 35), CHR(13)||CHR(10), '')," ).append("\n"); 
		query.append("                  REPLACE(SUBSTR(BC.CUST_ADDR, 1, 35), CHR(13)||CHR(10), '')|| CHR(29)|| REPLACE(SUBSTR(BC.CUST_ADDR, 36, 35), CHR(13)||CHR(10), '')|| CHR(29)|| REPLACE(SUBSTR(BC.CUST_ADDR, 71, 35), CHR(13)||CHR(10), ''))," ).append("\n"); 
		query.append("                  REPLACE(SUBSTR(C_BHC.CUST_ADDR, 1, 35), CHR(13)||CHR(10), '')|| CHR(29)|| REPLACE(SUBSTR(C_BHC.CUST_ADDR, 36, 35), CHR(13)||CHR(10), '')|| CHR(29)|| REPLACE(SUBSTR(C_BHC.CUST_ADDR, 71, 35), CHR(13)||CHR(10), '')), CHR(13)|| CHR(10), ''), CHR(13), ''), CHR(10), '') C_CUST_ADDR" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        ,REPLACE( REPLACE( REPLACE(DECODE(BCIB.BL_NO, BCIB.NVOCC_REF_NO, DECODE(NVL(BB.CUST_TO_ORD_FLG,'N'), 'N', SUBSTR(BC1.CUST_NM, 1, 35), ''), N_BHC.CUST_NM ), CHR(13)||CHR(10), ''), CHR(13), ''), CHR(10), '') N_CUST_NM" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ,REPLACE(  REPLACE(  REPLACE(DECODE(BCIB.BL_NO, BCIB.NVOCC_REF_NO, DECODE(NVL(BB.CUST_TO_ORD_FLG,'N'), 'N', REPLACE(SUBSTR(BC1.CUST_ADDR, 1, 35), CHR(13)||CHR(10), '')|| CHR(29)|| REPLACE(SUBSTR(BC1.CUST_ADDR, 36, 35), CHR(13)||CHR(10), '')|| CHR(29)|| REPLACE(SUBSTR(BC1.CUST_ADDR, 71, 35), CHR(13)||CHR(10), '')," ).append("\n"); 
		query.append("                  ''||CHR(29)||''||CHR(29)||'')," ).append("\n"); 
		query.append("                  REPLACE(SUBSTR(N_BHC.CUST_ADDR, 1, 35), CHR(13)||CHR(10), '')|| CHR(29)|| REPLACE(SUBSTR(N_BHC.CUST_ADDR, 36, 35), CHR(13)||CHR(10), '')|| CHR(29)|| REPLACE(SUBSTR(N_BHC.CUST_ADDR, 71, 35), CHR(13)||CHR(10), '')), CHR(13)||CHR(10), ''), CHR(13), ''), CHR(10), '') N_CUST_ADDR" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ,DECODE(BB.BKG_CGO_TP_CD, 'F', 'C', 'R', 'C', 'B', 'P') BKG_CGO_TP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ,DECODE(BCIB.IDA_CSTMS_ITM_TP_CD, 'O', 'OT', 'G', 'GC', 'U', 'UB', '') IDA_CSTMS_ITM_TP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ,BCIB.BL_DECL_TP_CD BL_DECL_TP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ,DECODE(BCIB.POD_CD,'INMAA',DECODE(BCIB.BL_DECL_TP_CD,'LC',BCIV.IDA_CFS_ID,'TI',BCIB.POD_CD, BCIV.IDA_CFS_ID)," ).append("\n"); 
		query.append("                   'INNAH',DECODE(BCIB.BL_DECL_TP_CD,'LC',BCIV.IDA_CFS_ID,'TI','',BCIV.IDA_CFS_ID),BCIV.IDA_CFS_ID) POD_CD_GUBUN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ,DECODE(BCIB.BL_NO, BCIB.NVOCC_REF_NO, TO_CHAR(BBD.PCK_QTY), TO_CHAR(BH.PCK_QTY) ) PCK_QTY" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        ,DECODE(BCIB.BL_NO, BCIB.NVOCC_REF_NO, DECODE(BBD.PCK_TP_CD,  'BG', 'BGS'," ).append("\n"); 
		query.append("                                                                    'BL', 'BLS'," ).append("\n"); 
		query.append("                                                                    'BA', 'BRL'," ).append("\n"); 
		query.append("                                                                    'BR', 'BAR'," ).append("\n"); 
		query.append("                                                                    'BK', 'BLO'," ).append("\n"); 
		query.append("                                                                    'BX', 'BOX'," ).append("\n"); 
		query.append("                                                                    'BE', 'BDL'," ).append("\n"); 
		query.append("                                                                    'CI', 'PKG'," ).append("\n"); 
		query.append("                                                                    'CT', 'CTN'," ).append("\n"); 
		query.append("                                                                    'CS', 'CAS'," ).append("\n"); 
		query.append("                                                                    'CL', 'CLS'," ).append("\n"); 
		query.append("                                                                    'CN', 'CON'," ).append("\n"); 
		query.append("                                                                    'CR', 'CRT'," ).append("\n"); 
		query.append("                                                                    'DR', 'DRM'," ).append("\n"); 
		query.append("                                                                    'LV', 'LFT'," ).append("\n"); 
		query.append("                                                                    'LT', 'PKG'," ).append("\n"); 
		query.append("                                                                    'NO', 'PKG'," ).append("\n"); 
		query.append("                                                                    'PS', 'PCS'," ).append("\n"); 
		query.append("                                                                    'RL', 'REL'," ).append("\n"); 
		query.append("                                                                    'RO', 'RLS'," ).append("\n"); 
		query.append("                                                                    'SA', 'SAK'," ).append("\n"); 
		query.append("                                                                    'ST', 'PKG'," ).append("\n"); 
		query.append("                                                                    'SK', 'PKG'," ).append("\n"); 
		query.append("                                                                    'TR', 'TRK'," ).append("\n"); 
		query.append("                                                                    'CY', 'CYL'," ).append("\n"); 
		query.append("                                                                    'PK', 'PKG'," ).append("\n"); 
		query.append("                                                                    'PE', 'PLT'," ).append("\n"); 
		query.append("                                                                    'LG', 'LOG'," ).append("\n"); 
		query.append("                                                                    'SK', 'SKD'," ).append("\n"); 
		query.append("                                                                    'WC', 'CSK'," ).append("\n"); 
		query.append("                                                                    'LS', 'CON'," ).append("\n"); 
		query.append("                                                                    'UN', 'UNT', '')," ).append("\n"); 
		query.append("                                            DECODE(BH.PCK_TP_CD,  'BG', 'BGS'," ).append("\n"); 
		query.append("                                                                  'BL', 'BLS'," ).append("\n"); 
		query.append("                                                                  'BA', 'BRL'," ).append("\n"); 
		query.append("                                                                  'BR', 'BAR'," ).append("\n"); 
		query.append("                                                                  'BK', 'BLO'," ).append("\n"); 
		query.append("                                                                  'BX', 'BOX'," ).append("\n"); 
		query.append("                                                                  'BE', 'BDL'," ).append("\n"); 
		query.append("                                                                  'CI', 'PKG'," ).append("\n"); 
		query.append("                                                                  'CT', 'CTN'," ).append("\n"); 
		query.append("                                                                  'CS', 'CAS'," ).append("\n"); 
		query.append("                                                                  'CL', 'CLS'," ).append("\n"); 
		query.append("                                                                  'CN', 'CON'," ).append("\n"); 
		query.append("                                                                  'CR', 'CRT'," ).append("\n"); 
		query.append("                                                                  'DR', 'DRM'," ).append("\n"); 
		query.append("                                                                  'LV', 'LFT'," ).append("\n"); 
		query.append("                                                                  'LT', 'PKG'," ).append("\n"); 
		query.append("                                                                  'NO', 'PKG'," ).append("\n"); 
		query.append("                                                                  'PS', 'PCS'," ).append("\n"); 
		query.append("                                                                  'RL', 'REL'," ).append("\n"); 
		query.append("                                                                  'RO', 'RLS'," ).append("\n"); 
		query.append("                                                                  'SA', 'SAK'," ).append("\n"); 
		query.append("                                                                  'ST', 'PKG'," ).append("\n"); 
		query.append("                                                                  'SK', 'PKG'," ).append("\n"); 
		query.append("                                                                  'TR', 'TRK'," ).append("\n"); 
		query.append("                                                                  'CY',    'CYL'," ).append("\n"); 
		query.append("                                                                  'PK',    'PKG'," ).append("\n"); 
		query.append("                                                                  'PE',    'PLT'," ).append("\n"); 
		query.append("                                                                  'LG',    'LOG'," ).append("\n"); 
		query.append("                                                                  'SK',    'SKD'," ).append("\n"); 
		query.append("                                                                  'WC',    'CSK'," ).append("\n"); 
		query.append("                                                                  'LS', 'CON'," ).append("\n"); 
		query.append("                                                                  'UN', 'UNT', '')" ).append("\n"); 
		query.append("                ) PCK_TP_CD" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                ,TRIM(DECODE(BCIB.BL_NO, BCIB.NVOCC_REF_NO, TO_CHAR(ROUND(BBD.ACT_WGT , 2), '99999999.000'), TO_CHAR(ROUND(BH.HBL_WGT, 2), '99999999.000'))) WGT" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("                ,DECODE(BCIB.BL_NO, BCIB.NVOCC_REF_NO, BBD.WGT_UT_CD, BH.WGT_UT_CD) WGT_UT_CD" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                ,'' TMP3" ).append("\n"); 
		query.append("                ,'' TMP4" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                ,REPLACE(SUBSTR(BBMD.MK_DESC, 1, 300), CHR(13)||CHR(10), '') MK_DESC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                ,REPLACE(REPLACE(DECODE(BCIB.BL_NO, BCIB.NVOCC_REF_NO, SUBSTR(BBD.CSTMS_DESC, 1, 250), SUBSTR(BBMD.CMDT_DESC, 1, 250)), CHR(13)||CHR(10), ''), CHR(13), '') CMDT_DESC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                ,NVL(DG.IMDG_UN_NO, 'ZZZZZ') IMDG_UN_NO" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("                ,NVL(DG.IMDG_CLSS_CD, 'ZZZ') IMDG_CLSS_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                ,DECODE(BCIB.POD_CD,'INMAA',BCIV.IBD_NO,'INNAH',DECODE(BCIB.BL_DECL_TP_CD,'TI',BCIV.IBD_NO,''),BCIV.IBD_NO) IBD_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                ,DECODE(BCIB.POD_CD,'INMAA','','INNAH',DECODE(BCIB.BL_DECL_TP_CD, 'TI',NVL(BCIB.TRNS_OPR_ID,BCIV.TRNS_OPR_ID),'TC',NVL(BCIB.TRNS_OPR_ID,BCIV.TRNS_OPR_ID),''),NVL(BCIB.TRNS_OPR_ID,BCIV.TRNS_OPR_ID)) CRR_AGN_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                ,DECODE(BCIB.BL_DECL_TP_CD, 'TI', BCIB.IDA_TRSP_CD, '') IDA_TRSP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                ,NVL(BCIV.IDA_MRN_LINE_OPR_ID, '') IDA_MRN_LINE_OPR_CD" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("                ,DECODE(BCIB.POD_CD,'INMAA',DECODE(BCIB.BL_DECL_TP_CD,'LC',BCIB.BD_AREA_CD,'')," ).append("\n"); 
		query.append("                                     'INNAH', '') BD_AREA_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("FROM    BKG_CSTMS_IDA_VSL BCIV        " ).append("\n"); 
		query.append("        ,BKG_CSTMS_IDA_BL BCIB       " ).append("\n"); 
		query.append("        ,BKG_BL_MK_DESC BBMD         " ).append("\n"); 
		query.append("        ,BKG_BL_DOC BBD             " ).append("\n"); 
		query.append("        ,MDM_CUSTOMER MC            " ).append("\n"); 
		query.append("        ,BKG_CUSTOMER BC            " ).append("\n"); 
		query.append("        ,MDM_CUSTOMER MC1           " ).append("\n"); 
		query.append("        ,BKG_CUSTOMER BC1           " ).append("\n"); 
		query.append("        ,(" ).append("\n"); 
		query.append("            SELECT   DG.IMDG_UN_NO            " ).append("\n"); 
		query.append("                     ,DG.IMDG_CLSS_CD         " ).append("\n"); 
		query.append("                     ,DG.BKG_NO" ).append("\n"); 
		query.append("            FROM     BKG_DG_CGO DG           " ).append("\n"); 
		query.append("                     ,BKG_BOOKING BB         " ).append("\n"); 
		query.append("                     ,BKG_CSTMS_IDA_BL BCIB  " ).append("\n"); 
		query.append("            WHERE    BCIB.VSL_CD            =    SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("            AND     BCIB.SKD_VOY_NO    	 =   SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("            AND     BCIB.SKD_DIR_CD     =   SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("            AND    	BCIB.POD_CD            =    @[pod_cd]" ).append("\n"); 
		query.append("            AND    	BCIB.POL_CD            LIKE    NVL(@[pol_cd], '') || '%'" ).append("\n"); 
		query.append("            AND    	BCIB.BL_NO            =    BB.BL_NO" ).append("\n"); 
		query.append("            AND    	DG.DCGO_SEQ            =    (    SELECT    DISTINCT MIN(A.DCGO_SEQ) " ).append("\n"); 
		query.append("                                            FROM    BKG_DG_CGO A" ).append("\n"); 
		query.append("                                            WHERE    A.BKG_NO     =    BB.BKG_NO" ).append("\n"); 
		query.append("                                            AND     BB.POD_CD    =  @[pod_cd]" ).append("\n"); 
		query.append("                                            AND     BB.POL_CD    LIKE    NVL(@[pol_cd], '') || '%' )" ).append("\n"); 
		query.append("            AND    BB.BKG_NO     =    DG.BKG_NO" ).append("\n"); 
		query.append("        )  DG" ).append("\n"); 
		query.append("        ,BKG_BOOKING   BB             --BOOKING             BK" ).append("\n"); 
		query.append("        ,BKG_HBL       BH             -- HOUSE BL 추가" ).append("\n"); 
		query.append("        ,(       " ).append("\n"); 
		query.append("           SELECT " ).append("\n"); 
		query.append("                B.BKG_NO" ).append("\n"); 
		query.append("                ,B.HBL_SEQ" ).append("\n"); 
		query.append("                ,B.CUST_NM" ).append("\n"); 
		query.append("                ,B.CUST_ADDR" ).append("\n"); 
		query.append("            FROM BKG_HBL A" ).append("\n"); 
		query.append("                 ,BKG_HBL_CUST B" ).append("\n"); 
		query.append("            WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("            AND   A.HBL_SEQ = B.HBL_SEQ" ).append("\n"); 
		query.append("            AND   B.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("            AND   (B.BKG_NO, B.HBL_SEQ, B.BKG_CUST_TP_CD) IN (" ).append("\n"); 
		query.append("                                                                SELECT 	B.BKG_NO, MAX(B.HBL_SEQ), B.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("                                                                FROM 	BKG_CSTMS_IDA_BL BCIB," ).append("\n"); 
		query.append("                                                            			BKG_BOOKING BKG," ).append("\n"); 
		query.append("                                                            			BKG_HBL A," ).append("\n"); 
		query.append("                                                            			BKG_HBL_CUST B" ).append("\n"); 
		query.append("                                                    			WHERE   BCIB.BL_NO      = BKG.BL_NO" ).append("\n"); 
		query.append("                                                    			AND     BKG.BKG_NO      = A.BKG_NO" ).append("\n"); 
		query.append("                                                    			AND     A.BKG_NO        = B.BKG_NO" ).append("\n"); 
		query.append("                                                    			AND     A.HBL_SEQ       = B.HBL_SEQ" ).append("\n"); 
		query.append("                                                    			AND     BCIB.VSL_CD     = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                                    			AND     BCIB.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                                    			AND     BCIB.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                                                    			AND     BCIB.POD_CD     = @[pod_cd]" ).append("\n"); 
		query.append("                                                    			AND     BCIB.POL_CD     LIKE NVL(@[pol_cd], '') || '%'" ).append("\n"); 
		query.append("                                                                GROUP BY 	B.BKG_NO, B.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("                                                                HAVING 		B.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("                                                              )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ) C_BHC" ).append("\n"); 
		query.append("        ,(       " ).append("\n"); 
		query.append("           SELECT " ).append("\n"); 
		query.append("                B.BKG_NO" ).append("\n"); 
		query.append("                ,B.HBL_SEQ" ).append("\n"); 
		query.append("                ,B.CUST_NM" ).append("\n"); 
		query.append("                ,B.CUST_ADDR" ).append("\n"); 
		query.append("            FROM BKG_HBL A" ).append("\n"); 
		query.append("                 ,BKG_HBL_CUST B" ).append("\n"); 
		query.append("            WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("            AND   A.HBL_SEQ = B.HBL_SEQ" ).append("\n"); 
		query.append("            AND   B.BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("            AND   (B.BKG_NO, B.HBL_SEQ, B.BKG_CUST_TP_CD) IN (" ).append("\n"); 
		query.append("                                                                SELECT 	B.BKG_NO, MAX(B.HBL_SEQ), B.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("                                                                FROM 	BKG_CSTMS_IDA_BL BCIB," ).append("\n"); 
		query.append("                                                            			BKG_BOOKING BKG," ).append("\n"); 
		query.append("                                                            			BKG_HBL A," ).append("\n"); 
		query.append("                                                            			BKG_HBL_CUST B" ).append("\n"); 
		query.append("                                                    			WHERE   BCIB.BL_NO      = BKG.BL_NO" ).append("\n"); 
		query.append("                                                    			AND     BKG.BKG_NO      = A.BKG_NO" ).append("\n"); 
		query.append("                                                    			AND     A.BKG_NO        = B.BKG_NO" ).append("\n"); 
		query.append("                                                    			AND     A.HBL_SEQ       = B.HBL_SEQ" ).append("\n"); 
		query.append("                                                    			AND     BCIB.VSL_CD     = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                                    			AND     BCIB.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                                    			AND     BCIB.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                                                    			AND     BCIB.POD_CD     = @[pod_cd]" ).append("\n"); 
		query.append("                                                    			AND     BCIB.POL_CD     LIKE NVL(@[pol_cd], '') || '%'" ).append("\n"); 
		query.append("                                                                GROUP BY 	B.BKG_NO, B.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("                                                                HAVING 		B.BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("                                                              )" ).append("\n"); 
		query.append("        ) N_BHC" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("WHERE    1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND BCIV.VSL_CD                   = BCIB.VSL_CD" ).append("\n"); 
		query.append("AND BCIV.SKD_VOY_NO               = BCIB.SKD_VOY_NO" ).append("\n"); 
		query.append("AND BCIV.SKD_DIR_CD               = BCIB.SKD_DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND    BCIV.POD_CD                   = BCIB.POD_CD" ).append("\n"); 
		query.append("AND    BCIB.BL_NO                   = BB.BL_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND    BB.BKG_NO                      = BC.BKG_NO" ).append("\n"); 
		query.append("AND    BC.BKG_CUST_TP_CD            = 'C'" ).append("\n"); 
		query.append("AND    MC.CUST_CNT_CD(+)           = BC.CUST_CNT_CD" ).append("\n"); 
		query.append("AND    MC.CUST_SEQ(+)              = BC.CUST_SEQ" ).append("\n"); 
		query.append("AND    BB.BKG_STS_CD                <> 'X'" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("#if (${empty_check} != 'on') " ).append("\n"); 
		query.append("AND     BB.BKG_CGO_TP_CD        <> 'P'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("AND    BB.BKG_NO            =    BC1.BKG_NO" ).append("\n"); 
		query.append("AND    BC1.BKG_CUST_TP_CD    =    'N'" ).append("\n"); 
		query.append("AND    MC1.CUST_CNT_CD(+)    =    BC1.CUST_CNT_CD" ).append("\n"); 
		query.append("AND    MC1.CUST_SEQ(+)        =    BC1.CUST_SEQ  " ).append("\n"); 
		query.append("AND    BB.BKG_NO            =    DG.BKG_NO(+)" ).append("\n"); 
		query.append("AND    BB.BKG_NO            =    BBMD.BKG_NO(+)" ).append("\n"); 
		query.append("AND    BBMD.BKG_NO            =    BBD.BKG_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND BB.BKG_NO           =   BH.BKG_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND BH.BKG_NO           =   C_BHC.BKG_NO(+)" ).append("\n"); 
		query.append("AND BH.HBL_SEQ          =   C_BHC.HBL_SEQ(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND BH.BKG_NO           =   N_BHC.BKG_NO(+)" ).append("\n"); 
		query.append("AND BH.HBL_SEQ          =   N_BHC.HBL_SEQ(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND    (    ( BCIB.BL_NO    =   BCIB.NVOCC_REF_NO )" ).append("\n"); 
		query.append("      OR ( BCIB.BL_NO    <>  BCIB.NVOCC_REF_NO AND BCIB.NVOCC_REF_NO = TRIM(BH.HBL_NO)    )" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND BCIB.VSL_CD          = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("AND BCIB.SKD_VOY_NO      = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("AND BCIB.SKD_DIR_CD      = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND    BCIB.POD_CD            =    @[pod_cd]" ).append("\n"); 
		query.append("AND    BCIB.POL_CD            LIKE    NVL(@[pol_cd], '') || '%'" ).append("\n"); 
		query.append("ORDER BY TO_NUMBER(BCIB.IDA_LINE_NO)" ).append("\n"); 

	}
}