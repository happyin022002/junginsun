/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchFullCntrRlseOrderListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.10
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOsearchFullCntrRlseOrderListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchFullCntrRlseOrderList
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchFullCntrRlseOrderListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_option",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_do_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchFullCntrRlseOrderListRSQL").append("\n"); 
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
		query.append("SELECT MST.BL_NO                               " ).append("\n"); 
		query.append("       ,MST.BKG_NO   " ).append("\n"); 
		query.append("       ,MST.BKG_CGO_TP_CD                           " ).append("\n"); 
		query.append("       ,MST.VVD " ).append("\n"); 
		query.append("       ,MST.POL_CD" ).append("\n"); 
		query.append("       ,MST.POD_CD " ).append("\n"); 
		query.append("       ,MST.CNTR_NO " ).append("\n"); 
		query.append("       ,MST.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       ,MST.DE_TERM_CD " ).append("\n"); 
		query.append("       ,DECODE(MST.SVR_ID,MST.USR_SVR_ID,MST.CRNT_YD_CD,'')  AS YD_CD       -- 'Y' 이면 Uncheck       " ).append("\n"); 
		query.append("       ,MST.SVR_ID" ).append("\n"); 
		query.append("       ,DECODE(MST.SVR_ID,MST.USR_SVR_ID,'0','1')                            AS ERR       -- 'Y' 이면 Uncheck    " ).append("\n"); 
		query.append("       ,REPLACE(NVL(FORD.CUST_NM, MST.CUST_NM), CHR(10), ' ')                AS CUST_NM" ).append("\n"); 
		query.append("       ,DECODE( NVL(FORD.CGOR_MZD_CD,'N') ,'E','Y'" ).append("\n"); 
		query.append("                                          ,'F','Y'" ).append("\n"); 
		query.append("                                          ,'M','Y'" ).append("\n"); 
		query.append("                                          ,'N')                              AS SENT_FLG  -- Sent " ).append("\n"); 
		query.append("       ,MST.FAX_NO         " ).append("\n"); 
		query.append("       ,MST.YD_NM         " ).append("\n"); 
		query.append("       ,MST.YD_EML         " ).append("\n"); 
		query.append("       ,MST.PHN_NO         " ).append("\n"); 
		query.append("       ,MST.VSL_NM         " ).append("\n"); 
		query.append("       ,MST.LOC_NM " ).append("\n"); 
		query.append("       ,MST.POD_NM        " ).append("\n"); 
		query.append("       ,MST.DO_NO_YN         " ).append("\n"); 
		query.append("       ,MST.CXL_FLG         " ).append("\n"); 
		query.append("       ,MST.DO_NO         " ).append("\n"); 
		query.append("       ,MST.DIFF_RMK         " ).append("\n"); 
		query.append("       ,MST.DO_ISS_DT" ).append("\n"); 
		query.append("--       ,ROUND(dbms_random.value(100000,999999),0) AS PIN_NO" ).append("\n"); 
		query.append("       , NVL(EUPIN.PIN_NO, REPLACE(REPLACE(REPLACE(REPLACE(DBMS_RANDOM.STRING('X', 7),'B', 'A'),'I','J'), 'O', 'P'), 'S','T')) AS PIN_NO" ).append("\n"); 
		query.append("       , NVL(EUPIN.SND_FLG, 'N') AS SND_FLG" ).append("\n"); 
		query.append("       , NVL(EUPIN.RLSE_ORD_SEQ, 0) AS RLSE_ORD_SEQ" ).append("\n"); 
		query.append("       ,( SELECT RSV.MSG_ACPT_REF_NO " ).append("\n"); 
		query.append(" 			FROM BKG_CSTMS_EUR_DG_RCV RSV" ).append("\n"); 
		query.append(" 		   WHERE RSV.EUR_EDI_MSG_TP_ID='CTA'" ).append("\n"); 
		query.append("             AND RSV.BL_NO LIKE SUBSTR(MST.BL_NO,1,10)||'%' " ).append("\n"); 
		query.append("             AND RSV.CNTR_NO = MST.CNTR_NO " ).append("\n"); 
		query.append("             AND RSV.MSG_ACPT_REF_NO IS NOT NULL" ).append("\n"); 
		query.append(" 		     AND ROWNUM = 1" ).append("\n"); 
		query.append("        ) AS MSG_ACPT_REF_NO" ).append("\n"); 
		query.append("        ,FORD.CNTR_SLT_NO" ).append("\n"); 
		query.append("        ,FORD.CSTMS_VOY_NO" ).append("\n"); 
		query.append("       ,MST.CGO_PKUP_DT" ).append("\n"); 
		query.append("       ,MST.BKG_TRSP_MOD_CD" ).append("\n"); 
		query.append("       ,NVL(FORD.MTY_RTN_YD_CD,MST.MTY_RTN_YD_CD) AS MTY_RTN_YD_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("     SELECT BKG.BL_NO                                          AS BL_NO" ).append("\n"); 
		query.append("         , BKG.BKG_NO                                          AS BKG_NO" ).append("\n"); 
		query.append("         , BKG.BKG_CGO_TP_CD                                   AS BKG_CGO_TP_CD" ).append("\n"); 
		query.append("         , BVVD.VSL_CD||BVVD.SKD_VOY_NO||BVVD.SKD_DIR_CD       AS VVD" ).append("\n"); 
		query.append("         , BKG.POL_CD                                          AS POL_CD" ).append("\n"); 
		query.append("         , BVVD.POD_CD                                         AS POD_CD" ).append("\n"); 
		query.append("         , BCNTR.CNTR_NO                                       AS CNTR_NO" ).append("\n"); 
		query.append("         , BCNTR.CNTR_TPSZ_CD                                  AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("         , BKG.DE_TERM_CD                                      AS DE_TERM_CD" ).append("\n"); 
		query.append("         , CNTR.CRNT_YD_CD                                     AS CRNT_YD_CD   -- 화면상에 YD_CD" ).append("\n"); 
		query.append("         , CNTR.SYS_AREA_GRP_ID                                AS SVR_ID" ).append("\n"); 
		query.append("         , BCUST.CUST_NM                                       AS CUST_NM" ).append("\n"); 
		query.append("         , (SELECT /*+ INDEX_DESC (ORD XPKBKG_FULL_CGO_RLSE_ORD) */ ORD.RLSE_ORD_SEQ " ).append("\n"); 
		query.append("            FROM BKG_FULL_CGO_RLSE_ORD ORD " ).append("\n"); 
		query.append("            WHERE ORD.BKG_NO = BCNTR.BKG_NO " ).append("\n"); 
		query.append("            AND   ORD.CNTR_NO = BCNTR.CNTR_NO" ).append("\n"); 
		query.append("            AND   ROWNUM = 1)                                  AS MAX_RLSE_SEQ  " ).append("\n"); 
		query.append("         , YD.FAX_NO                                           AS FAX_NO" ).append("\n"); 
		query.append("         , YD.YD_NM                                            AS YD_NM" ).append("\n"); 
		query.append("         , YD.YD_EML                                           AS YD_EML" ).append("\n"); 
		query.append("         , YD.PHN_NO                                           AS PHN_NO" ).append("\n"); 
		query.append("         , VSL.VSL_ENG_NM                                      AS VSL_NM" ).append("\n"); 
		query.append("         , LOC.LOC_NM                                          AS LOC_NM" ).append("\n"); 
		query.append("         , POD.LOC_NM                                          AS POD_NM" ).append("\n"); 
		query.append("         , DECODE( NVL(DDTL.RLSE_STS_CD,'N'),'N','N','Y')      AS DO_NO_YN" ).append("\n"); 
		query.append("         , 'N'                                                 AS CXL_FLG" ).append("\n"); 
		query.append("         , TO_CHAR(SYSDATE,'YYYY-MM-DD')                       AS CGO_PKUP_DT" ).append("\n"); 
		query.append("         , 'T'                                                 AS BKG_TRSP_MOD_CD" ).append("\n"); 
		query.append("         , NVL(BDO.DO_NO || BDO.DO_NO_SPLIT,'')                AS DO_NO" ).append("\n"); 
		query.append("         , BDO.DO_PRN_RMK                                      AS DIFF_RMK" ).append("\n"); 
		query.append("         , TO_CHAR(DDTL.EVNT_DT,'YYYY-MM-DD HH24:MI')       AS DO_ISS_DT" ).append("\n"); 
		query.append("         , (SELECT SYS_AREA_GRP_ID " ).append("\n"); 
		query.append("            FROM COM_SYS_AREA_GRP_ID " ).append("\n"); 
		query.append("            WHERE  CNT_CD= (SELECT SUBSTR(LOC.LOC_CD,1,2) CNT" ).append("\n"); 
		query.append(" 								FROM MDM_LOCATION     LOC" ).append("\n"); 
		query.append("      						        ,(SELECT  GLOBALDATE_PKG.GET_LOCCD_FNC(@[usr_ofc_cd]) LOC_CD FROM DUAL) SUBQ " ).append("\n"); 
		query.append("  								WHERE LOC.LOC_CD(+)   = SUBQ.LOC_CD" ).append("\n"); 
		query.append("   								  AND ROWNUM=1" ).append("\n"); 
		query.append("          					 )   " ).append("\n"); 
		query.append("               AND CO_IND_CD='H' " ).append("\n"); 
		query.append("               AND SVR_USD_FLG='Y' )                           AS USR_SVR_ID" ).append("\n"); 
		query.append("        , (SELECT /*+ INDEX_ASC(D XPKSCE_COP_DTL)*/ D.NOD_CD" ).append("\n"); 
		query.append("            FROM SCE_COP_HDR H," ).append("\n"); 
		query.append("                 SCE_COP_DTL D," ).append("\n"); 
		query.append("                 SCE_ACT_ACT_MAPG MPG" ).append("\n"); 
		query.append("           WHERE H.COP_NO = D.COP_NO" ).append("\n"); 
		query.append("             AND H.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("             AND H.CNTR_NO = BCNTR.CNTR_NO" ).append("\n"); 
		query.append("             AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("             AND D.ACT_CD = MPG.ACT_CD" ).append("\n"); 
		query.append("             AND MPG.ACT_STS_MAPG_CD = 'MT'" ).append("\n"); 
		query.append("             AND D.ACT_CD ='MITYAD'" ).append("\n"); 
		query.append("             AND ROWNUM=1)                                   AS MTY_RTN_YD_CD" ).append("\n"); 
		query.append("      FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append("         , BKG_VVD BVVD" ).append("\n"); 
		query.append("         , BKG_CONTAINER BCNTR" ).append("\n"); 
		query.append("         , MST_CONTAINER CNTR" ).append("\n"); 
		query.append("         , BKG_CUSTOMER BCUST" ).append("\n"); 
		query.append("         , MDM_YARD YD" ).append("\n"); 
		query.append("         , MDM_VSL_CNTR VSL" ).append("\n"); 
		query.append("         , MDM_LOCATION LOC" ).append("\n"); 
		query.append("         , MDM_LOCATION POD" ).append("\n"); 
		query.append("         , BKG_EDI_YD EY" ).append("\n"); 
		query.append("         , BKG_DO_CNTR DCNTR" ).append("\n"); 
		query.append("         , BKG_DO_DTL  DDTL" ).append("\n"); 
		query.append("         , BKG_DO BDO" ).append("\n"); 
		query.append("     WHERE @[in_option] = 'BL'" ).append("\n"); 
		query.append("       AND BKG.BL_NO            = @[in_bl_no]" ).append("\n"); 
		query.append("       AND BCNTR.BKG_NO         = BKG.BKG_NO" ).append("\n"); 
		query.append("#if ( ${in_cntr_no} != '' )" ).append("\n"); 
		query.append("       AND BCNTR.CNTR_NO LIKE @[in_cntr_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       AND BVVD.BKG_NO          = BKG.BKG_NO" ).append("\n"); 
		query.append("    --   AND BVVD.POD_CD          = BKG.POD_CD" ).append("\n"); 
		query.append("       AND BVVD.VSL_PRE_PST_CD  = 'T'       " ).append("\n"); 
		query.append("       AND BCUST.BKG_NO         = BKG.BKG_NO " ).append("\n"); 
		query.append("       AND BCUST.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("       AND VSL.VSL_CD           = BVVD.VSL_CD" ).append("\n"); 
		query.append("       AND LOC.LOC_CD           = BVVD.POL_CD" ).append("\n"); 
		query.append("       AND POD.LOC_CD           = BVVD.POD_CD  " ).append("\n"); 
		query.append("       AND DCNTR.BKG_NO(+)      = BCNTR.BKG_NO         " ).append("\n"); 
		query.append("       AND DCNTR.CNTR_NO(+)     = BCNTR.CNTR_NO      " ).append("\n"); 
		query.append("       AND BDO.BKG_NO(+)        = DCNTR.BKG_NO" ).append("\n"); 
		query.append("       AND BDO.RLSE_SEQ(+)      = DCNTR.RLSE_SEQ" ).append("\n"); 
		query.append("       AND DDTL.BKG_NO(+)       = BDO.BKG_NO " ).append("\n"); 
		query.append("       AND DDTL.RLSE_SEQ(+)     = BDO.RLSE_SEQ        " ).append("\n"); 
		query.append("       AND DDTL.RLSE_STS_CD(+)  = 'R'   " ).append("\n"); 
		query.append("       AND CNTR.CNTR_NO         = BCNTR.CNTR_NO    " ).append("\n"); 
		query.append("       AND YD.YD_CD(+)          = CNTR.CRNT_YD_CD        " ).append("\n"); 
		query.append("       AND EY.YD_CD(+)          = YD.YD_CD        " ).append("\n"); 
		query.append("       AND EY.FULL_RLSE_EDI_CD(+) = '1'" ).append("\n"); 
		query.append("   UNION ALL" ).append("\n"); 
		query.append("   SELECT BKG.BL_NO                                            AS BL_NO" ).append("\n"); 
		query.append("         , BKG.BKG_NO                                          AS BKG_NO" ).append("\n"); 
		query.append("         , BKG.BKG_CGO_TP_CD                                   AS BKG_CGO_TP_CD" ).append("\n"); 
		query.append("         , BVVD.VSL_CD||BVVD.SKD_VOY_NO||BVVD.SKD_DIR_CD       AS VVD" ).append("\n"); 
		query.append("         , BKG.POL_CD                                          AS POL_CD" ).append("\n"); 
		query.append("         , BVVD.POD_CD                                         AS POD_CD" ).append("\n"); 
		query.append("         , BCNTR.CNTR_NO                                       AS CNTR_NO" ).append("\n"); 
		query.append("         , BCNTR.CNTR_TPSZ_CD                                  AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("         , BKG.DE_TERM_CD                                      AS DE_TERM_CD" ).append("\n"); 
		query.append("         , CNTR.CRNT_YD_CD                                     AS CRNT_YD_CD   -- 화면상에 YD_CD" ).append("\n"); 
		query.append("         , CNTR.SYS_AREA_GRP_ID                                AS SVR_ID" ).append("\n"); 
		query.append("         , BCUST.CUST_NM                                       AS CUST_NM" ).append("\n"); 
		query.append("         ,(SELECT /*+ INDEX_DESC (ORD XPKBKG_FULL_CGO_RLSE_ORD) */ ORD.RLSE_ORD_SEQ " ).append("\n"); 
		query.append("           FROM BKG_FULL_CGO_RLSE_ORD ORD " ).append("\n"); 
		query.append("           WHERE ORD.BKG_NO = BCNTR.BKG_NO " ).append("\n"); 
		query.append("           AND   ORD.CNTR_NO = BCNTR.CNTR_NO" ).append("\n"); 
		query.append("           AND   ROWNUM = 1)                                   AS  MAX_RLSE_SEQ  " ).append("\n"); 
		query.append("         , YD.FAX_NO                                           AS FAX_NO" ).append("\n"); 
		query.append("         , YD.YD_NM                                            AS YD_NM" ).append("\n"); 
		query.append("         , YD.YD_EML                                           AS YD_EML" ).append("\n"); 
		query.append("         , YD.PHN_NO                                           AS PHN_NO" ).append("\n"); 
		query.append("         , VSL.VSL_ENG_NM                                      AS VSL_NM" ).append("\n"); 
		query.append("         , LOC.LOC_NM                                          AS LOC_NM" ).append("\n"); 
		query.append("         , POD.LOC_NM                                          AS POD_NM" ).append("\n"); 
		query.append("         , DECODE( NVL(DDTL.RLSE_STS_CD,'N'),'N','N','Y')      AS DO_NO_YN" ).append("\n"); 
		query.append("         , 'N'                                                 AS CXL_FLG" ).append("\n"); 
		query.append("         , TO_CHAR(SYSDATE,'YYYY-MM-DD')                       AS CGO_PKUP_DT" ).append("\n"); 
		query.append("         , 'T'                                                 AS BKG_TRSP_MOD_CD" ).append("\n"); 
		query.append("         , NVL(BDO.DO_NO || BDO.DO_NO_SPLIT,'')                AS DO_NO" ).append("\n"); 
		query.append("         , BDO.DO_PRN_RMK                                      AS DIFF_RMK" ).append("\n"); 
		query.append("         , TO_CHAR(DDTL.EVNT_DT,'YYYY-MM-DD HH24:MI')          AS DO_ISS_DT" ).append("\n"); 
		query.append("         ,(SELECT SYS_AREA_GRP_ID " ).append("\n"); 
		query.append("            FROM COM_SYS_AREA_GRP_ID " ).append("\n"); 
		query.append("            WHERE  CNT_CD = (SELECT SUBSTR(LOC.LOC_CD,1,2) CNT" ).append("\n"); 
		query.append(" 								FROM MDM_LOCATION     LOC" ).append("\n"); 
		query.append("      						        ,(SELECT  GLOBALDATE_PKG.GET_LOCCD_FNC(@[usr_ofc_cd]) LOC_CD FROM DUAL) SUBQ " ).append("\n"); 
		query.append("  								WHERE LOC.LOC_CD(+)   = SUBQ.LOC_CD" ).append("\n"); 
		query.append("   								  AND ROWNUM=1" ).append("\n"); 
		query.append("          					 ) " ).append("\n"); 
		query.append("               AND CO_IND_CD='H' " ).append("\n"); 
		query.append("               AND SVR_USD_FLG='Y' )                           AS  USR_SVR_ID" ).append("\n"); 
		query.append("         , (SELECT /*+ INDEX_ASC(D XPKSCE_COP_DTL)*/ D.NOD_CD" ).append("\n"); 
		query.append("            FROM SCE_COP_HDR H," ).append("\n"); 
		query.append("                 SCE_COP_DTL D," ).append("\n"); 
		query.append("                 SCE_ACT_ACT_MAPG MPG" ).append("\n"); 
		query.append("           WHERE H.COP_NO = D.COP_NO" ).append("\n"); 
		query.append("             AND H.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("             AND H.CNTR_NO = BCNTR.CNTR_NO" ).append("\n"); 
		query.append("             AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("             AND D.ACT_CD = MPG.ACT_CD" ).append("\n"); 
		query.append("             AND MPG.ACT_STS_MAPG_CD = 'MT'" ).append("\n"); 
		query.append("             AND D.ACT_CD ='MITYAD'" ).append("\n"); 
		query.append("             AND ROWNUM=1)                                   AS MTY_RTN_YD_CD" ).append("\n"); 
		query.append("      FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append("         , BKG_VVD BVVD" ).append("\n"); 
		query.append("         , BKG_CONTAINER BCNTR" ).append("\n"); 
		query.append("         , MST_CONTAINER CNTR" ).append("\n"); 
		query.append("         , BKG_CUSTOMER BCUST" ).append("\n"); 
		query.append("         , MDM_YARD YD" ).append("\n"); 
		query.append("         , MDM_VSL_CNTR VSL" ).append("\n"); 
		query.append("         , MDM_LOCATION LOC" ).append("\n"); 
		query.append("         , MDM_LOCATION POD" ).append("\n"); 
		query.append("         , BKG_EDI_YD EY" ).append("\n"); 
		query.append("         , BKG_DO_CNTR DCNTR" ).append("\n"); 
		query.append("         , BKG_DO_DTL  DDTL" ).append("\n"); 
		query.append("         , BKG_DO BDO" ).append("\n"); 
		query.append("     WHERE 'VVD'               =  @[in_option]" ).append("\n"); 
		query.append("       AND BVVD.VSL_CD         = SUBSTR(@[in_vvd], 1, 4)" ).append("\n"); 
		query.append("       AND BVVD.SKD_VOY_NO     = SUBSTR(@[in_vvd], 5, 4)" ).append("\n"); 
		query.append("       AND BVVD.SKD_DIR_CD     = SUBSTR(@[in_vvd], 9, 1)     " ).append("\n"); 
		query.append("       AND BVVD.VSL_PRE_PST_CD = 'T'       " ).append("\n"); 
		query.append("       AND BVVD.POD_CD         = @[in_pod] " ).append("\n"); 
		query.append("       AND BCNTR.BKG_NO        = BVVD.BKG_NO " ).append("\n"); 
		query.append("#if ( ${in_cntr_no} != '' )" ).append("\n"); 
		query.append("       AND BCNTR.CNTR_NO LIKE  @[in_cntr_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       AND BKG.BKG_NO           = BVVD.BKG_NO " ).append("\n"); 
		query.append("       AND BKG.BKG_STS_CD       IN ('W', 'F')" ).append("\n"); 
		query.append("       AND BCUST.BKG_NO         = BVVD.BKG_NO " ).append("\n"); 
		query.append("       AND BCUST.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("       AND DCNTR.BKG_NO(+)      = BCNTR.BKG_NO " ).append("\n"); 
		query.append("       AND DCNTR.CNTR_NO(+)     = BCNTR.CNTR_NO   " ).append("\n"); 
		query.append("       AND BDO.BKG_NO(+)        = DCNTR.BKG_NO" ).append("\n"); 
		query.append("       AND BDO.RLSE_SEQ(+)      = DCNTR.RLSE_SEQ" ).append("\n"); 
		query.append("       AND DDTL.BKG_NO(+)       = DCNTR.BKG_NO " ).append("\n"); 
		query.append("       AND DDTL.RLSE_SEQ(+)     = DCNTR.RLSE_SEQ " ).append("\n"); 
		query.append("       AND DDTL.RLSE_STS_CD(+)  = 'R'      " ).append("\n"); 
		query.append("       AND VSL.VSL_CD           = BVVD.VSL_CD " ).append("\n"); 
		query.append("       AND LOC.LOC_CD           = BVVD.POL_CD " ).append("\n"); 
		query.append("       AND POD.LOC_CD           = BVVD.POD_CD" ).append("\n"); 
		query.append("       AND CNTR.CNTR_NO         = BCNTR.CNTR_NO " ).append("\n"); 
		query.append("       AND YD.YD_CD(+)          = CNTR.CRNT_YD_CD     " ).append("\n"); 
		query.append("       AND EY.YD_CD(+)          = YD.YD_CD " ).append("\n"); 
		query.append("       AND EY.FULL_RLSE_EDI_CD(+) = '1'" ).append("\n"); 
		query.append(") MST, BKG_FULL_CGO_RLSE_ORD FORD" ).append("\n"); 
		query.append("     , (SELECT A.BKG_NO, A.CNTR_NO, A.RLSE_ORD_SEQ, A.RLSE_ORD_SUB_SEQ, A.PIN_NO, A.SND_FLG" ).append("\n"); 
		query.append("          FROM BKG_EU_PIN_NO A," ).append("\n"); 
		query.append("                (SELECT BKG_NO, CNTR_NO, MAX(RLSE_ORD_SEQ) RLSE_ORD_SEQ, MAX(RLSE_ORD_SUB_SEQ) RLSE_ORD_SUB_SEQ" ).append("\n"); 
		query.append("                  FROM BKG_EU_PIN_NO" ).append("\n"); 
		query.append("                 WHERE BKG_NO = (SELECT BKG_NO " ).append("\n"); 
		query.append("                                   FROM BKG_BOOKING " ).append("\n"); 
		query.append("                                  WHERE BL_NO = @[in_bl_no]" ).append("\n"); 
		query.append("                                    AND ROWNUM = 1)" ).append("\n"); 
		query.append("#if ( ${in_cntr_no} != '' )" ).append("\n"); 
		query.append("                   AND CNTR_NO LIKE @[in_cntr_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                 GROUP BY BKG_NO, CNTR_NO" ).append("\n"); 
		query.append("                 UNION ALL" ).append("\n"); 
		query.append("                 SELECT A.BKG_NO, A.CNTR_NO, MAX(A.RLSE_ORD_SEQ) RLSE_ORD_SEQ, MAX(A.RLSE_ORD_SUB_SEQ) RLSE_ORD_SUB_SEQ" ).append("\n"); 
		query.append("                   FROM BKG_EU_PIN_NO A, BKG_VVD BVVD" ).append("\n"); 
		query.append("                  WHERE 'VVD'               =  @[in_option]" ).append("\n"); 
		query.append("                    AND BVVD.VSL_CD         = SUBSTR(@[in_vvd], 1, 4)" ).append("\n"); 
		query.append("                    AND BVVD.SKD_VOY_NO     = SUBSTR(@[in_vvd], 5, 4)" ).append("\n"); 
		query.append("                    AND BVVD.SKD_DIR_CD     = SUBSTR(@[in_vvd], 9, 1)     " ).append("\n"); 
		query.append("                    AND BVVD.VSL_PRE_PST_CD = 'T'       " ).append("\n"); 
		query.append("                    AND BVVD.POD_CD         = @[in_pod] " ).append("\n"); 
		query.append("                    AND A.BKG_NO        = BVVD.BKG_NO " ).append("\n"); 
		query.append("#if ( ${in_cntr_no} != '' )" ).append("\n"); 
		query.append("                    AND A.CNTR_NO LIKE  @[in_cntr_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                  GROUP BY A.BKG_NO, A.CNTR_NO  " ).append("\n"); 
		query.append("       ) B" ).append("\n"); 
		query.append("         WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("           AND A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("           AND A.RLSE_ORD_SEQ = B.RLSE_ORD_SEQ" ).append("\n"); 
		query.append("           AND A.RLSE_ORD_SUB_SEQ = B.RLSE_ORD_SUB_SEQ) EUPIN" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if ( ${in_do_no} != '')" ).append("\n"); 
		query.append("  AND DO_NO_YN = @[in_do_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND FORD.BKG_NO(+)            = MST.BKG_NO" ).append("\n"); 
		query.append("AND FORD.CNTR_NO(+)           = MST.CNTR_NO" ).append("\n"); 
		query.append("AND FORD.RLSE_ORD_SEQ(+)      = MST.MAX_RLSE_SEQ" ).append("\n"); 
		query.append("AND EUPIN.BKG_NO (+)          = MST.BKG_NO" ).append("\n"); 
		query.append("AND EUPIN.CNTR_NO(+)          = MST.CNTR_NO" ).append("\n"); 
		query.append("--AND EUPIN.RLSE_ORD_SEQ(+)     = MST.MAX_RLSE_SEQ" ).append("\n"); 
		query.append("ORDER BY MST.BL_NO" ).append("\n"); 

	}
}