/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOvalidateScCtrtPtyTpRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.16
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2013.09.16 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DYRYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOvalidateScCtrtPtyTpRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/C의 Contract Party Type을 validation한다
	  * A, O일 경우 Contract Main Customer는 사용할 수 없도록 한다
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOvalidateScCtrtPtyTpRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOvalidateScCtrtPtyTpRSQL").append("\n"); 
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
		query.append("WITH CUST AS" ).append("\n"); 
		query.append("#if (${ca_flg} != 'Y') " ).append("\n"); 
		query.append("      (SELECT CUST.BKG_CUST_TP_CD, CUST.CUST_CNT_CD, CUST.CUST_SEQ, CUST.CUST_NM" ).append("\n"); 
		query.append("         FROM BKG_CUSTOMER CUST" ).append("\n"); 
		query.append("		WHERE CUST.BKG_NO 		  = @[bkg_no]" ).append("\n"); 
		query.append("		  AND CUST.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("       UNION " ).append("\n"); 
		query.append("       SELECT CUST.BKG_CUST_TP_CD, CUST.CUST_CNT_CD, CUST.CUST_SEQ, CUST.CUST_NM" ).append("\n"); 
		query.append("         FROM BKG_CUSTOMER CUST" ).append("\n"); 
		query.append("		WHERE CUST.BKG_NO 		  = @[bkg_no]" ).append("\n"); 
		query.append("		  AND CUST.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("	   UNION " ).append("\n"); 
		query.append("       SELECT CUST.BKG_CUST_TP_CD, CUST.CUST_CNT_CD, CUST.CUST_SEQ, CUST.CUST_NM" ).append("\n"); 
		query.append("         FROM BKG_CUSTOMER CUST, BKG_BOOKING BK" ).append("\n"); 
		query.append("        WHERE BK.BKG_NO           = @[bkg_no]   " ).append("\n"); 
		query.append("          AND BK.BKG_NO           = CUST.BKG_NO" ).append("\n"); 
		query.append("          AND BK.CUST_TO_ORD_FLG  = 'Y'" ).append("\n"); 
		query.append("          AND CUST.BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      (SELECT CUST.BKG_CUST_TP_CD, CUST.CUST_CNT_CD, CUST.CUST_SEQ, CUST.CUST_NM" ).append("\n"); 
		query.append("         FROM BKG_CUST_HIS CUST" ).append("\n"); 
		query.append("		WHERE CUST.BKG_NO 		  = @[bkg_no]" ).append("\n"); 
		query.append("		  AND CUST.CORR_NO 		  = 'TMP0000001'" ).append("\n"); 
		query.append("		  AND CUST.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("       UNION " ).append("\n"); 
		query.append("       SELECT CUST.BKG_CUST_TP_CD, CUST.CUST_CNT_CD, CUST.CUST_SEQ, CUST.CUST_NM" ).append("\n"); 
		query.append("         FROM BKG_CUST_HIS CUST" ).append("\n"); 
		query.append("		WHERE CUST.BKG_NO 		  = @[bkg_no]" ).append("\n"); 
		query.append("		  AND CUST.CORR_NO 		  = 'TMP0000001'" ).append("\n"); 
		query.append("		  AND CUST.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("	   UNION " ).append("\n"); 
		query.append("       SELECT CUST.BKG_CUST_TP_CD, CUST.CUST_CNT_CD, CUST.CUST_SEQ, CUST.CUST_NM" ).append("\n"); 
		query.append("         FROM BKG_CUST_HIS CUST, BKG_BKG_HIS BK" ).append("\n"); 
		query.append("        WHERE BK.BKG_NO           = @[bkg_no]   " ).append("\n"); 
		query.append("          AND BK.BKG_NO           = CUST.BKG_NO" ).append("\n"); 
		query.append("		  AND CUST.CORR_NO 		  = 'TMP0000001'" ).append("\n"); 
		query.append("		  AND BK.CORR_NO 		  = 'TMP0000001'" ).append("\n"); 
		query.append("          AND BK.CUST_TO_ORD_FLG  = 'Y'" ).append("\n"); 
		query.append("          AND CUST.BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("SELECT COUNT(1) CNT" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("    (SELECT APPL_DT" ).append("\n"); 
		query.append("         FROM (" ).append("\n"); 
		query.append("            SELECT 1 RANK, RT_APLY_DT APPL_DT " ).append("\n"); 
		query.append("              FROM BKG_RT_HIS R" ).append("\n"); 
		query.append("             WHERE BKG_NO = @[bkg_no]  " ).append("\n"); 
		query.append("			   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("               AND RT_APLY_DT IS NOT NULL" ).append("\n"); 
		query.append("			UNION ALL" ).append("\n"); 
		query.append("			SELECT 2 RANK, RT_APLY_DT APPL_DT --RATE APPLICABLE" ).append("\n"); 
		query.append("              FROM BKG_RATE R" ).append("\n"); 
		query.append("             WHERE BKG_NO = @[bkg_no]  " ).append("\n"); 
		query.append("               AND RT_APLY_DT IS NOT NULL" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT 3 RANK, SKD.VPS_ETD_DT APPL_DT --ONBOARD DATE" ).append("\n"); 
		query.append("              FROM BKG_VVD_HIS VVD, VSK_VSL_PORT_SKD SKD, BKG_BKG_HIS BK" ).append("\n"); 
		query.append("             WHERE BK.BKG_NO          = @[bkg_no]  " ).append("\n"); 
		query.append("			   AND BK.CORR_NO 		  = 'TMP0000001'" ).append("\n"); 
		query.append("			   AND VVD.CORR_NO 		  = 'TMP0000001'" ).append("\n"); 
		query.append("               AND BK.BKG_NO          = VVD.BKG_NO" ).append("\n"); 
		query.append("               AND VVD.VSL_PRE_PST_CD IN ('S', 'T')" ).append("\n"); 
		query.append("               AND VVD.POL_CD         = BK.POL_CD" ).append("\n"); 
		query.append("               AND VVD.VSL_CD         = SKD.VSL_CD" ).append("\n"); 
		query.append("               AND VVD.SKD_VOY_NO     = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("               AND VVD.SKD_DIR_CD     = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("               AND VVD.POL_CD         = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("               AND VVD.POL_CLPT_IND_SEQ = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT 4 RANK, SKD.VPS_ETD_DT APPL_DT --ONBOARD DATE" ).append("\n"); 
		query.append("              FROM BKG_VVD VVD, VSK_VSL_PORT_SKD SKD, BKG_BOOKING BK" ).append("\n"); 
		query.append("             WHERE BK.BKG_NO          = @[bkg_no]  " ).append("\n"); 
		query.append("               AND BK.BKG_NO          = VVD.BKG_NO" ).append("\n"); 
		query.append("               AND VVD.VSL_PRE_PST_CD IN ('S', 'T')" ).append("\n"); 
		query.append("               AND VVD.POL_CD         = BK.POL_CD" ).append("\n"); 
		query.append("               AND VVD.VSL_CD         = SKD.VSL_CD" ).append("\n"); 
		query.append("               AND VVD.SKD_VOY_NO     = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("               AND VVD.SKD_DIR_CD     = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("               AND VVD.POL_CD         = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("               AND VVD.POL_CLPT_IND_SEQ = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("            UNION ALL " ).append("\n"); 
		query.append("            SELECT 5 RANK, SYSDATE APPL_DT" ).append("\n"); 
		query.append("              FROM DUAL)   " ).append("\n"); 
		query.append("        WHERE ROWNUM = 1) APPL" ).append("\n"); 
		query.append("    , (SELECT DISTINCT LOC_SCOPE.SVC_SCP_CD" ).append("\n"); 
		query.append("		 FROM (SELECT ORG.SVC_SCP_CD SVC_SCP_CD, COUNT(1) CNT" ).append("\n"); 
		query.append("        		 FROM MDM_SVC_SCP_LMT ORG" ).append("\n"); 
		query.append("		            , MDM_SVC_SCP_LMT DEST" ).append("\n"); 
		query.append("					, BKG_BOOKING BK" ).append("\n"); 
		query.append("			    WHERE BK.BKG_NO				= @[bkg_no]  " ).append("\n"); 
		query.append("				  AND ORG.RGN_CD 			= (SELECT RGN_CD FROM MDM_LOCATION WHERE LOC_CD = BK.POR_CD)" ).append("\n"); 
		query.append("			      AND ORG.ORG_DEST_CD 		= 'O'" ).append("\n"); 
		query.append("			      AND ORG.SVC_SCP_IND_FLG 	= 'Y'" ).append("\n"); 
		query.append("			      AND ORG.DELT_FLG			= 'N'" ).append("\n"); 
		query.append("			      AND DEST.RGN_CD 			= (SELECT RGN_CD FROM MDM_LOCATION WHERE LOC_CD = BK.DEL_CD)" ).append("\n"); 
		query.append("			      AND DEST.ORG_DEST_CD 		= 'D'" ).append("\n"); 
		query.append("			      AND DEST.SVC_SCP_IND_FLG 	= 'Y'" ).append("\n"); 
		query.append("			      AND DEST.DELT_FLG 		= 'N'" ).append("\n"); 
		query.append("        		  AND ORG.SVC_SCP_CD = DEST.SVC_SCP_CD" ).append("\n"); 
		query.append("		        GROUP BY ORG.SVC_SCP_CD) LOC_SCOPE," ).append("\n"); 
		query.append("			  (SELECT ORG.SVC_SCP_CD SVC_SCP_CD, 1 CNT" ).append("\n"); 
		query.append("			     FROM MDM_SVC_SCP_LANE LANE " ).append("\n"); 
		query.append("			        , MDM_SVC_SCP_LMT ORG" ).append("\n"); 
		query.append("			        , MDM_SVC_SCP_LMT DEST" ).append("\n"); 
		query.append("			        , VSK_VSL_SKD SKD" ).append("\n"); 
		query.append("					, BKG_BOOKING BK" ).append("\n"); 
		query.append("			    WHERE BK.BKG_NO				= @[bkg_no]  " ).append("\n"); 
		query.append("				  AND ORG.RGN_CD 			= (SELECT RGN_CD FROM MDM_LOCATION WHERE LOC_CD = BK.POR_CD)" ).append("\n"); 
		query.append("			      AND ORG.ORG_DEST_CD 		= 'O'" ).append("\n"); 
		query.append("			      AND ORG.SVC_SCP_IND_FLG 	= 'Y'" ).append("\n"); 
		query.append("			      AND ORG.DELT_FLG			= 'N'" ).append("\n"); 
		query.append("			      AND DEST.RGN_CD 			= (SELECT RGN_CD FROM MDM_LOCATION WHERE LOC_CD = BK.DEL_CD)" ).append("\n"); 
		query.append("			      AND DEST.ORG_DEST_CD 		= 'D'" ).append("\n"); 
		query.append("			      AND DEST.SVC_SCP_IND_FLG 	= 'Y'" ).append("\n"); 
		query.append("			      AND DEST.DELT_FLG 		= 'N'" ).append("\n"); 
		query.append("			      AND ORG.SVC_SCP_CD   		= DEST.SVC_SCP_CD" ).append("\n"); 
		query.append("			      AND LANE.VSL_SLAN_CD 		= SKD.VSL_SLAN_CD" ).append("\n"); 
		query.append("			      AND SKD.VSL_CD    		= BK.VSL_CD" ).append("\n"); 
		query.append("			      AND SKD.SKD_VOY_NO 		= BK.SKD_VOY_NO" ).append("\n"); 
		query.append("			      AND SKD.SKD_DIR_CD 		= BK.SKD_DIR_CD" ).append("\n"); 
		query.append("			    GROUP BY ORG.SVC_SCP_CD" ).append("\n"); 
		query.append("			    UNION " ).append("\n"); 
		query.append("			    SELECT '   ' SVC_SCP_CD , 1 CNT FROM DUAL) VSL_SCOPE" ).append("\n"); 
		query.append("		WHERE ((LOC_SCOPE.CNT = 1 AND LOC_SCOPE.CNT = VSL_SCOPE.CNT)" ).append("\n"); 
		query.append("		       OR " ).append("\n"); 
		query.append("		       (LOC_SCOPE.CNT > 1 AND LOC_SCOPE.SVC_SCP_CD = VSL_SCOPE.SVC_SCP_CD)" ).append("\n"); 
		query.append("		      )" ).append("\n"); 
		query.append("         ) SCOPE" ).append("\n"); 
		query.append("    , (SELECT CTRT.CUST_CNT_CD  CTRT_CUST_CNT" ).append("\n"); 
		query.append("            , CTRT.CUST_SEQ     CTRT_CUST_SEQ" ).append("\n"); 
		query.append("            , CTRT.PROP_NO      CTRT_PROP_NO" ).append("\n"); 
		query.append("            , CTRT.AMDT_SEQ     CTRT_AMDT_SEQ" ).append("\n"); 
		query.append("         FROM PRI_SP_CTRT_PTY CTRT, CUST" ).append("\n"); 
		query.append("        WHERE CTRT.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("          AND CUST.CUST_CNT_CD = CTRT.CUST_CNT_CD" ).append("\n"); 
		query.append("          AND CUST.CUST_sEQ    = CTRT.CUST_SEQ" ).append("\n"); 
		query.append("	   MINUS" ).append("\n"); 
		query.append("       SELECT AFIL.CUST_CNT_CD  CTRT_CUST_CNT" ).append("\n"); 
		query.append("            , AFIL.CUST_SEQ     CTRT_CUST_SEQ" ).append("\n"); 
		query.append("            , AFIL.PROP_NO      CTRT_PROP_NO" ).append("\n"); 
		query.append("            , AFIL.AMDT_SEQ     CTRT_AMDT_SEQ" ).append("\n"); 
		query.append("         FROM PRI_SP_AFIL AFIL, CUST" ).append("\n"); 
		query.append("        WHERE CUST.CUST_CNT_CD = AFIL.CUST_CNT_CD" ).append("\n"); 
		query.append("          AND CUST.CUST_sEQ    = AFIL.CUST_SEQ) CTRT" ).append("\n"); 
		query.append("    , PRI_SP_MN MAIN, PRI_SP_SCP_MN SP_SCP, PRI_SP_CTRT_CUST_TP CUST_TP, CUST" ).append("\n"); 
		query.append("  WHERE CUST.CUST_CNT_CD    = CTRT_CUST_CNT " ).append("\n"); 
		query.append("    AND CUST.CUST_SEQ       = CTRT_CUST_SEQ" ).append("\n"); 
		query.append("    AND MAIN.PROP_NO        = CTRT_PROP_NO" ).append("\n"); 
		query.append("    AND MAIN.AMDT_SEQ       = CTRT_AMDT_SEQ" ).append("\n"); 
		query.append("    AND MAIN.PROP_NO        = SP_SCP.PROP_NO" ).append("\n"); 
		query.append("    AND MAIN.AMDT_SEQ       = SP_SCP.AMDT_SEQ" ).append("\n"); 
		query.append("    AND SP_SCP.SVC_SCP_CD   = SCOPE.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND MAIN.EFF_DT - 0.0001 < APPL.APPL_DT" ).append("\n"); 
		query.append("    AND MAIN.EXP_DT + 0.9999 > APPL.APPL_DT" ).append("\n"); 
		query.append("    AND ((MAIN.AMDT_SEQ = 0 AND MAIN.PROP_STS_CD = 'F') " ).append("\n"); 
		query.append("        OR (MAIN.AMDT_SEQ > 0))" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    AND MAIN.PROP_NO  = CUST_TP.PROP_NO(+)" ).append("\n"); 
		query.append("    AND MAIN.AMDT_SEQ = CUST_TP.AMDT_SEQ(+)" ).append("\n"); 
		query.append("    AND 'C'           = CUST_TP.PRC_CTRT_PTY_TP_CD(+)" ).append("\n"); 
		query.append("    AND CUST_TP.PRC_CTRT_CUST_TP_CD IN ('A')" ).append("\n"); 

	}
}