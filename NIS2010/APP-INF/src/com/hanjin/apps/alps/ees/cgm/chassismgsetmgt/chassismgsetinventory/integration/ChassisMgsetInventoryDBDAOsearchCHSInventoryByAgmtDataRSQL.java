/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMgsetInventoryDBDAOsearchCHSInventoryByAgmtDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.18
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2010.03.18 조재성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChaeShung Cho
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
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("#if (${location} == 'SCC')" ).append("\n"); 
		query.append("A.CRNT_YD_CD AS CRNT_LOC_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("A.CRNT_LOC_CD AS CRNT_LOC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", A.AGMT_OFC_CTY_CD || LPAD(A.AGMT_SEQ, 6, '0') AS AGMT_NO" ).append("\n"); 
		query.append(", C.VNDR_ABBR_NM||' ('||B.VNDR_SEQ||')' AS VNDR_SEQ" ).append("\n"); 
		query.append(", COUNT(*) AS EQ_TPSZ_CD_TOTAL" ).append("\n"); 
		query.append(", NVL(SUM(CASE WHEN A.EQ_TPSZ_CD = 'SF2' THEN 1 END),0) AS EQ_TPSZ_CD_SF2" ).append("\n"); 
		query.append(", NVL(SUM(CASE WHEN A.EQ_TPSZ_CD = 'SL2' THEN 1 END),0) AS EQ_TPSZ_CD_SL2" ).append("\n"); 
		query.append(", NVL(SUM(CASE WHEN A.EQ_TPSZ_CD = 'TA2' THEN 1 END),0) AS EQ_TPSZ_CD_TA2" ).append("\n"); 
		query.append(", NVL(SUM(CASE WHEN A.EQ_TPSZ_CD = 'SF4' THEN 1 END),0) AS EQ_TPSZ_CD_SF4" ).append("\n"); 
		query.append(", NVL(SUM(CASE WHEN A.EQ_TPSZ_CD = 'GN4' THEN 1 END),0) AS EQ_TPSZ_CD_GN4" ).append("\n"); 
		query.append(", NVL(SUM(CASE WHEN A.EQ_TPSZ_CD = 'CB4' THEN 1 END),0) AS EQ_TPSZ_CD_CB4" ).append("\n"); 
		query.append(", NVL(SUM(CASE WHEN A.EQ_TPSZ_CD = 'EG5' THEN 1 END),0) AS EQ_TPSZ_CD_EG5" ).append("\n"); 
		query.append(", NVL(SUM(CASE WHEN A.EQ_TPSZ_CD = 'GN5' THEN 1 END),0) AS EQ_TPSZ_CD_GN5" ).append("\n"); 
		query.append(", NVL(SUM(CASE WHEN A.EQ_TPSZ_CD = 'EG8' THEN 1 END),0) AS EQ_TPSZ_CD_EG8" ).append("\n"); 
		query.append(", NVL(SUM(CASE WHEN A.EQ_TPSZ_CD = 'ZT4' THEN 1 END),0) AS EQ_TPSZ_CD_ZT4" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM CGM_EQUIPMENT A, CGM_AGREEMENT B, MDM_VENDOR C" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.VNDR_SEQ = C.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND A.AGMT_OFC_CTY_CD = B.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("AND A.AGMT_SEQ = B.AGMT_SEQ" ).append("\n"); 
		query.append("AND A.AGMT_VER_NO =  B.AGMT_VER_NO" ).append("\n"); 
		query.append("AND A.EQ_KND_CD = 'Z'" ).append("\n"); 
		query.append("AND A.ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append("AND (A.AGMT_OFC_CTY_CD  || A.AGMT_SEQ ) = (B.AGMT_OFC_CTY_CD  || B.AGMT_SEQ )" ).append("\n"); 
		query.append("AND A.CRNT_LOC_CD IN" ).append("\n"); 
		query.append("( 	SELECT AA.LOC_CD" ).append("\n"); 
		query.append("FROM MDM_LOCATION AA, MDM_EQ_ORZ_CHT BB" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("AA.SCC_CD = BB.SCC_CD" ).append("\n"); 
		query.append("AND  AA.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND  BB.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if ( ${location} == 'RCC' )" ).append("\n"); 
		query.append("AND  BB.RCC_CD = (@[crnt_loc_cd])" ).append("\n"); 
		query.append("#elseif ( ${location} == 'LCC' )" ).append("\n"); 
		query.append("AND  BB.LCC_CD = (@[crnt_loc_cd])" ).append("\n"); 
		query.append("#elseif ( ${location} == 'SCC' )" ).append("\n"); 
		query.append("AND  BB.SCC_CD = (@[crnt_loc_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${crnt_yd_cd} != '')" ).append("\n"); 
		query.append("AND A.CRNT_YD_CD IN ($crnt_yd_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${include_np} != 'Y')" ).append("\n"); 
		query.append("AND A.AGMT_LSTM_CD <>'NP'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agmt_no} != '')" ).append("\n"); 
		query.append("AND (B.AGMT_OFC_CTY_CD,B.AGMT_SEQ ) IN ($agmt_no)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("AND B.VNDR_SEQ IN ($vndr_seq)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${location} == 'SCC')" ).append("\n"); 
		query.append("GROUP BY A.CRNT_YD_CD, (A.AGMT_OFC_CTY_CD || LPAD(A.AGMT_SEQ, 6, '0')) , C.VNDR_ABBR_NM||' ('||B.VNDR_SEQ||')'" ).append("\n"); 
		query.append("ORDER BY A.CRNT_YD_CD , (A.AGMT_OFC_CTY_CD || LPAD(A.AGMT_SEQ, 6, '0')) , C.VNDR_ABBR_NM||' ('||B.VNDR_SEQ||')'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("GROUP BY A.CRNT_LOC_CD, (A.AGMT_OFC_CTY_CD || LPAD(A.AGMT_SEQ, 6, '0')) , C.VNDR_ABBR_NM||' ('||B.VNDR_SEQ||')'" ).append("\n"); 
		query.append("ORDER BY A.CRNT_LOC_CD , (A.AGMT_OFC_CTY_CD || LPAD(A.AGMT_SEQ, 6, '0')) , C.VNDR_ABBR_NM||' ('||B.VNDR_SEQ||')'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}