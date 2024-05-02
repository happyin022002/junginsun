/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ReeferSparePartMgtDBDAOsearchVesselSparePartCodeListDataRSQL.java
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

public class ReeferSparePartMgtDBDAOsearchVesselSparePartCodeListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public ReeferSparePartMgtDBDAOsearchVesselSparePartCodeListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spr_prt_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.integration").append("\n"); 
		query.append("FileName : ReeferSparePartMgtDBDAOsearchVesselSparePartCodeListDataRSQL").append("\n"); 
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
		query.append("WITH MV AS (" ).append("\n"); 
		query.append("    SELECT MAX(SPR_PRT_VER_SEQ) AS SPR_PRT_VER_SEQ" ).append("\n"); 
		query.append("    FROM MNR_VSL_SPR_PRT_CD" ).append("\n"); 
		query.append("    WHERE SPR_PRT_DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${spr_prt_ver_seq} != '') " ).append("\n"); 
		query.append("AND SPR_PRT_VER_SEQ = @[spr_prt_ver_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("     SPC.SPR_PRT_SEQ" ).append("\n"); 
		query.append("   , SPC.SPR_PRT_VER_SEQ" ).append("\n"); 
		query.append("   , SPC.SPR_PRT_VNDR_SEQ" ).append("\n"); 
		query.append("   , SPC.SPR_UT_MDL_NM" ).append("\n"); 
		query.append("   , SPC.SPR_PRT_TP_CD" ).append("\n"); 
		query.append("   , SPC.SPR_PRT_LST_AMT" ).append("\n"); 
		query.append("   , SPC.SPR_PRT_CRNT_AMT" ).append("\n"); 
		query.append("   , SPC.SPR_PRT_RMK" ).append("\n"); 
		query.append("   , SPC.SPR_PRT_DP_SEQ" ).append("\n"); 
		query.append("   , SPC.SPR_PRT_DELT_FLG" ).append("\n"); 
		query.append("   , SPC.CRE_USR_ID" ).append("\n"); 
		query.append("   , TO_CHAR(SPC.CRE_DT,'YYYY-MM-DD') AS CRE_DT" ).append("\n"); 
		query.append("   , SPC.UPD_USR_ID" ).append("\n"); 
		query.append("   , TO_CHAR(SPC.UPD_DT,'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append("FROM MNR_VSL_SPR_PRT_CD SPC, MV" ).append("\n"); 
		query.append("WHERE SPC.SPR_PRT_DELT_FLG = 'N'" ).append("\n"); 
		query.append("	AND SPC.SPR_PRT_VER_SEQ = MV.SPR_PRT_VER_SEQ" ).append("\n"); 
		query.append("ORDER BY SPC.SPR_PRT_DP_SEQ, SPC.SPR_PRT_VNDR_SEQ, SPC.SPR_UT_MDL_NM" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}