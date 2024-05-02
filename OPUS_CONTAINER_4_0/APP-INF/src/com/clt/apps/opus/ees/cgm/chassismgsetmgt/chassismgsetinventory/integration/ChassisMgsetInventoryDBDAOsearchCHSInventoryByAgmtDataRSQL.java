/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChassisMgsetInventoryDBDAOsearchCHSInventoryByAgmtDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.19
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2015.01.19 박광석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author PARK KWANG SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInventoryDBDAOsearchCHSInventoryByAgmtDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * chungpa 20090729 1098 start
	  * </pre>
	  */
	public ChassisMgsetInventoryDBDAOsearchCHSInventoryByAgmtDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInventoryDBDAOsearchCHSInventoryByAgmtDataRSQL").append("\n"); 
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
		query.append("#if (${location} == 'SCC')" ).append("\n"); 
		query.append("A.CRNT_YD_CD AS CRNT_LOC_CD " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("A.CRNT_LOC_CD AS CRNT_LOC_CD " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", A.AGMT_OFC_CTY_CD || LPAD(A.AGMT_SEQ, 6, '0') AS AGMT_NO" ).append("\n"); 
		query.append(", C.VNDR_ABBR_NM||' ('||B.VNDR_SEQ||')' AS VNDR_SEQ " ).append("\n"); 
		query.append(", COUNT(*) AS EQ_TPSZ_CD_TOTAL," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN G.DP_SEQ = '1' THEN 1 END),0) AS EQ_TPSZ_CD1," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN G.DP_SEQ = '2' THEN 1 END),0) AS EQ_TPSZ_CD2," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN G.DP_SEQ = '3' THEN 1 END),0) AS EQ_TPSZ_CD3," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN G.DP_SEQ = '4' THEN 1 END),0) AS EQ_TPSZ_CD4," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN G.DP_SEQ = '5' THEN 1 END),0) AS EQ_TPSZ_CD5," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN G.DP_SEQ = '6' THEN 1 END),0) AS EQ_TPSZ_CD6," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN G.DP_SEQ = '7' THEN 1 END),0) AS EQ_TPSZ_CD7," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN G.DP_SEQ = '8' THEN 1 END),0) AS EQ_TPSZ_CD8," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN G.DP_SEQ = '9' THEN 1 END),0) AS EQ_TPSZ_CD9," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN G.DP_SEQ = '10' THEN 1 END),0) AS EQ_TPSZ_CD10," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN G.DP_SEQ = '11' THEN 1 END),0) AS EQ_TPSZ_CD11," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN G.DP_SEQ = '12' THEN 1 END),0) AS EQ_TPSZ_CD12," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN G.DP_SEQ = '13' THEN 1 END),0) AS EQ_TPSZ_CD13," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN G.DP_SEQ = '14' THEN 1 END),0) AS EQ_TPSZ_CD14," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN G.DP_SEQ = '15' THEN 1 END),0) AS EQ_TPSZ_CD15," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN G.DP_SEQ = '16' THEN 1 END),0) AS EQ_TPSZ_CD16," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN G.DP_SEQ = '17' THEN 1 END),0) AS EQ_TPSZ_CD17," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN G.DP_SEQ = '18' THEN 1 END),0) AS EQ_TPSZ_CD18," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN G.DP_SEQ = '19' THEN 1 END),0) AS EQ_TPSZ_CD19," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN G.DP_SEQ = '20' THEN 1 END),0) AS EQ_TPSZ_CD20" ).append("\n"); 
		query.append("FROM CGM_EQUIPMENT A, CGM_AGREEMENT B, MDM_VENDOR C , " ).append("\n"); 
		query.append("(SELECT EQ_TPSZ_CD,ROW_NUMBER() OVER (ORDER BY EQ_TPSZ_REP_CD,EQ_TPSZ_CD) DP_SEQ " ).append("\n"); 
		query.append("  FROM CGM_EQ_TP_SZ WHERE EQ_KND_CD = 'Z' GROUP BY EQ_TPSZ_REP_CD,EQ_TPSZ_CD) G" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("A.VNDR_SEQ = C.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND A.AGMT_OFC_CTY_CD = B.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("AND A.AGMT_SEQ = B.AGMT_SEQ" ).append("\n"); 
		query.append("AND A.AGMT_VER_NO =  B.AGMT_VER_NO" ).append("\n"); 
		query.append("AND A.EQ_TPSZ_CD = G.EQ_TPSZ_CD" ).append("\n"); 
		query.append("AND A.EQ_KND_CD = 'Z'" ).append("\n"); 
		query.append("AND A.ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append("AND (A.AGMT_OFC_CTY_CD  || A.AGMT_SEQ ) = (B.AGMT_OFC_CTY_CD  || B.AGMT_SEQ )" ).append("\n"); 
		query.append("AND A.CRNT_LOC_CD IN " ).append("\n"); 
		query.append("		( 	SELECT AA.LOC_CD " ).append("\n"); 
		query.append("         	FROM MDM_LOCATION AA, MDM_EQ_ORZ_CHT BB" ).append("\n"); 
		query.append("	        WHERE " ).append("\n"); 
		query.append("				AA.SCC_CD = BB.SCC_CD" ).append("\n"); 
		query.append("      			AND  AA.DELT_FLG = 'N'" ).append("\n"); 
		query.append("            	AND  BB.DELT_FLG = 'N'" ).append("\n"); 
		query.append("				#if ( ${location} == 'RCC' )" ).append("\n"); 
		query.append("			   	AND  BB.RCC_CD = (@[crnt_loc_cd])" ).append("\n"); 
		query.append("				#elseif ( ${location} == 'LCC' )" ).append("\n"); 
		query.append("				AND  BB.LCC_CD = (@[crnt_loc_cd])" ).append("\n"); 
		query.append("				#elseif ( ${location} == 'SCC' )" ).append("\n"); 
		query.append("				AND  BB.SCC_CD = (@[crnt_loc_cd])" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${crnt_yd_cd} != '')" ).append("\n"); 
		query.append("	  AND A.CRNT_YD_CD IN ($crnt_yd_cd)" ).append("\n"); 
		query.append("#end     " ).append("\n"); 
		query.append("#if (${include_np} != 'Y')" ).append("\n"); 
		query.append("	  AND A.AGMT_LSTM_CD <>'NP' " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${agmt_no} != '')" ).append("\n"); 
		query.append("	  AND (B.AGMT_OFC_CTY_CD,B.AGMT_SEQ ) IN ($agmt_no) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("	AND B.VNDR_SEQ IN ($vndr_seq) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${location} == 'SCC')" ).append("\n"); 
		query.append("GROUP BY A.CRNT_YD_CD, (A.AGMT_OFC_CTY_CD || LPAD(A.AGMT_SEQ, 6, '0')) , C.VNDR_ABBR_NM||' ('||B.VNDR_SEQ||')'" ).append("\n"); 
		query.append("ORDER BY A.CRNT_YD_CD , (A.AGMT_OFC_CTY_CD || LPAD(A.AGMT_SEQ, 6, '0')) , C.VNDR_ABBR_NM||' ('||B.VNDR_SEQ||')' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("GROUP BY A.CRNT_LOC_CD, (A.AGMT_OFC_CTY_CD || LPAD(A.AGMT_SEQ, 6, '0')) , C.VNDR_ABBR_NM||' ('||B.VNDR_SEQ||')'" ).append("\n"); 
		query.append("ORDER BY A.CRNT_LOC_CD , (A.AGMT_OFC_CTY_CD || LPAD(A.AGMT_SEQ, 6, '0')) , C.VNDR_ABBR_NM||' ('||B.VNDR_SEQ||')'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}