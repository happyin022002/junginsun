/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ReeferSparePartMgtDBDAOsearchVesselInventoryHeaderListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReeferSparePartMgtDBDAOsearchVesselInventoryHeaderListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public ReeferSparePartMgtDBDAOsearchVesselInventoryHeaderListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spr_prt_invt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.integration").append("\n"); 
		query.append("FileName : ReeferSparePartMgtDBDAOsearchVesselInventoryHeaderListDataRSQL").append("\n"); 
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
		query.append("SELECT SPR_PRT_VER_SEQ, SPR_PRT_VNDR_SEQ, SPR_UT_MDL_NM, VNDR_NM, SPR_PRT_DP_SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT SPR_PRT_VER_SEQ, SPR_PRT_VNDR_SEQ, SPR_UT_MDL_NM" ).append("\n"); 
		query.append("		, CASE WHEN SPR_UT_MDL_NM = 'GE' THEN 'General'" ).append("\n"); 
		query.append("            ELSE ( SELECT NVL(VNDR_ABBR_NM,VNDR_LGL_ENG_NM) AS VNDR_NM" ).append("\n"); 
		query.append("                    FROM MDM_VENDOR V" ).append("\n"); 
		query.append("                    WHERE V.VNDR_SEQ = C.SPR_PRT_VNDR_SEQ" ).append("\n"); 
		query.append("                    AND V.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                   ) " ).append("\n"); 
		query.append("          END AS VNDR_NM" ).append("\n"); 
		query.append("		, MAX(C.SPR_PRT_DP_SEQ) AS SPR_PRT_DP_SEQ" ).append("\n"); 
		query.append("    FROM MNR_VSL_SPR_PRT_CD C" ).append("\n"); 
		query.append("    WHERE C.SPR_PRT_DELT_FLG = 'N'" ).append("\n"); 
		query.append("    AND C.SPR_PRT_VER_SEQ = (" ).append("\n"); 
		query.append("#if (${spr_prt_invt_no} == '') " ).append("\n"); 
		query.append("                                SELECT MAX(SPR_PRT_VER_SEQ) AS SPR_PRT_VER_SEQ" ).append("\n"); 
		query.append("                                FROM MNR_VSL_SPR_PRT_CD" ).append("\n"); 
		query.append("                                WHERE SPR_PRT_DELT_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${spr_prt_invt_no} != '')" ).append("\n"); 
		query.append("								SELECT MAX( SPR_PRT_VER_SEQ ) AS SPR_PRT_VER_SEQ" ).append("\n"); 
		query.append("                                FROM MNR_VSL_SPR_PRT_INVT IT" ).append("\n"); 
		query.append("                                WHERE SPR_PRT_INVT_NO = @[spr_prt_invt_no]" ).append("\n"); 
		query.append("                                AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("    GROUP BY C.SPR_PRT_VER_SEQ, C.SPR_PRT_VNDR_SEQ, C.SPR_UT_MDL_NM" ).append("\n"); 
		query.append("    ) SAM" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    ORDER BY SPR_PRT_VER_SEQ, SPR_PRT_DP_SEQ, VNDR_NM" ).append("\n"); 

	}
}