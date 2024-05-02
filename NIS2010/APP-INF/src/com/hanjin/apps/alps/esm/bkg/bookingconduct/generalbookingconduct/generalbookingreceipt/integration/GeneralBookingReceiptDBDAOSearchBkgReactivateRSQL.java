/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchBkgReactivateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOSearchBkgReactivateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Bkg Reactivate 화면 조회
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchBkgReactivateRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sts",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("t_vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOSearchBkgReactivateRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append("      ,T_VVD" ).append("\n"); 
		query.append("      ,T_LANE" ).append("\n"); 
		query.append("      ,BKG_STS_CD" ).append("\n"); 
		query.append("      ,POL_CD" ).append("\n"); 
		query.append("      ,POD_CD" ).append("\n"); 
		query.append("      ,POL_ETD_DT" ).append("\n"); 
		query.append("      ,CXL_DT" ).append("\n"); 
		query.append("      ,CXL_BY" ).append("\n"); 
		query.append("      ,CXL_OFC" ).append("\n"); 
		query.append("      ,CXL_RSN" ).append("\n"); 
		query.append("      ,RACT_DT" ).append("\n"); 
		query.append("      ,RACT_BY" ).append("\n"); 
		query.append("      ,RACT_OFC" ).append("\n"); 
		query.append("FROM(      " ).append("\n"); 
		query.append("     SELECT BKG_NO" ).append("\n"); 
		query.append("           ,T_VVD" ).append("\n"); 
		query.append("           , SLAN_CD T_LANE" ).append("\n"); 
		query.append("           , BKG_STS_CD" ).append("\n"); 
		query.append("           , POL_CD" ).append("\n"); 
		query.append("           , POD_CD" ).append("\n"); 
		query.append("           , TO_CHAR(POL_ETD_DT,'YYYY-MM-DD HH24:MI:SS') POL_ETD_DT" ).append("\n"); 
		query.append("           , TO_CHAR(CXL_DT,'YYYY-MM-DD HH24:MI:SS') CXL_DT" ).append("\n"); 
		query.append("           , CXL_BY" ).append("\n"); 
		query.append("           , NVL((SELECT OFC_CD FROM COM_USER U WHERE CXL_BY =U.USR_ID),'') CXL_OFC" ).append("\n"); 
		query.append("           , CASE WHEN EXISTS (SELECT 1 FROM BKG_HIS_DTL WHERE BKG_NO = A.BKG_NO AND UPD_DT = CXL_DT AND CRNT_CTNT LIKE 'Combined to target bkg no%') THEN 'Combine'" ).append("\n"); 
		query.append("                  WHEN 'BATCH' = (SELECT UPD_USR_ID FROM BKG_HIS_DTL WHERE UPD_DT = CXL_DT AND BKG_NO = A.BKG_NO) THEN 'NO RATE STS' " ).append("\n"); 
		query.append("                  WHEN EXISTS (SELECT 1 FROM BKG_HIS_DTL WHERE BKG_NO = A.BKG_NO AND (CRNT_CTNT = 'Booking Canceled.' OR CRNT_CTNT LIKE 'Combined to target bkg no%') AND ROWNUM = 1) THEN 'By User'" ).append("\n"); 
		query.append("                  ELSE '' END AS CXL_RSN" ).append("\n"); 
		query.append("           , TO_CHAR(RACT_DT,'YYYY-MM-DD HH24:MI:SS') RACT_DT" ).append("\n"); 
		query.append("           , RACT_BY" ).append("\n"); 
		query.append("           , NVL((SELECT OFC_CD FROM COM_USER U WHERE RACT_BY =U.USR_ID),'') RACT_OFC     " ).append("\n"); 
		query.append("     FROM(" ).append("\n"); 
		query.append("          SELECT BK.BKG_NO" ).append("\n"); 
		query.append("               , BK.VSL_CD||BK.SKD_VOY_NO||BK.SKD_DIR_CD T_VVD" ).append("\n"); 
		query.append("               , BK.SLAN_CD" ).append("\n"); 
		query.append("               , BK.BKG_STS_CD" ).append("\n"); 
		query.append("               , BK.POL_CD" ).append("\n"); 
		query.append("               , BK.POD_CD" ).append("\n"); 
		query.append("               , (SELECT VPS_ETD_DT " ).append("\n"); 
		query.append("                    FROM VSK_VSL_PORT_SKD SKD " ).append("\n"); 
		query.append("                    WHERE VVD.VSL_CD = SKD.VSL_CD " ).append("\n"); 
		query.append("                    AND VVD.SKD_VOY_NO = SKD.SKD_VOY_NO " ).append("\n"); 
		query.append("                    AND VVD.SKD_DIR_CD = SKD.SKD_DIR_CD " ).append("\n"); 
		query.append("                    AND VVD.POL_CD = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("				    AND VVD.POL_CLPT_IND_SEQ = SKD.CLPT_IND_SEQ) POL_ETD_DT" ).append("\n"); 
		query.append("               , NVL((SELECT MAX(UPD_DT) FROM BKG_HIS_DTL HIS WHERE (CRNT_CTNT = 'Booking Canceled.' OR CRNT_CTNT LIKE 'Combined to target bkg no%') AND HIS.BKG_NO = BK.BKG_NO),'') CXL_DT" ).append("\n"); 
		query.append("               , NVL((SELECT UPD_USR_ID FROM BKG_HIS_DTL HIS WHERE (CRNT_CTNT = 'Booking Canceled.' OR CRNT_CTNT LIKE 'Combined to target bkg no%') AND HIS.BKG_NO = BK.BKG_NO AND UPD_DT = (SELECT MAX(UPD_DT) FROM BKG_HIS_DTL WHERE BKG_NO = BK.BKG_NO AND (CRNT_CTNT = 'Booking Canceled.' or CRNT_CTNT LIKE 'Combined to target bkg no%') )),'') CXL_BY         " ).append("\n"); 
		query.append("               , NVL((SELECT MAX(UPD_DT) FROM BKG_HIS_DTL HIS WHERE CRNT_CTNT = 'Reactivate.' AND HIS.BKG_NO = BK.BKG_NO GROUP BY CRNT_CTNT),'') RACT_DT" ).append("\n"); 
		query.append("               , NVL((SELECT UPD_USR_ID FROM BKG_HIS_DTL HIS WHERE CRNT_CTNT = 'Reactivate.' AND HIS.BKG_NO = BK.BKG_NO AND UPD_DT = (SELECT MAX(UPD_DT) FROM BKG_HIS_DTL WHERE BKG_NO = BK.BKG_NO AND CRNT_CTNT = 'Reactivate.' GROUP BY CRNT_CTNT )),'') RACT_BY " ).append("\n"); 
		query.append("          FROM BKG_BOOKING BK, BKG_VVD VVD" ).append("\n"); 
		query.append("          WHERE 1=1" ).append("\n"); 
		query.append("          AND BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("          AND VVD.VSL_PRE_PST_CD IN('S','T')" ).append("\n"); 
		query.append("          AND BK.POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("     #if(${bkg_no}!='')" ).append("\n"); 
		query.append("          AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     #if(${t_vvd}!='')" ).append("\n"); 
		query.append("           AND BK.VSL_CD = substr(@[t_vvd], 1, 4)" ).append("\n"); 
		query.append("          AND BK.SKD_VOY_NO = substr(@[t_vvd], 5, 4)" ).append("\n"); 
		query.append("          AND BK.SKD_DIR_CD = substr(@[t_vvd], 9, 1)" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     #if(${pol_cd}!='')" ).append("\n"); 
		query.append("           AND BK.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     #if(${pod_cd}!='')" ).append("\n"); 
		query.append("           AND BK.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     #if(${sts}!='ALL')" ).append("\n"); 
		query.append("           AND BK.BKG_STS_CD = @[sts]" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("          ) A" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if(${cxl_rsn}=='U')" ).append("\n"); 
		query.append("     AND CXL_RSN = 'By User'" ).append("\n"); 
		query.append("	 AND BKG_STS_CD = 'X'" ).append("\n"); 
		query.append("#elseif(${cxl_rsn}=='N')" ).append("\n"); 
		query.append("     AND CXL_RSN = 'NO RATE STS'" ).append("\n"); 
		query.append("	 AND BKG_STS_CD = 'X'" ).append("\n"); 
		query.append("#elseif(${cxl_rsn}=='C')     " ).append("\n"); 
		query.append("     AND CXL_RSN = 'Combine'" ).append("\n"); 
		query.append("	 AND BKG_STS_CD = 'X'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}