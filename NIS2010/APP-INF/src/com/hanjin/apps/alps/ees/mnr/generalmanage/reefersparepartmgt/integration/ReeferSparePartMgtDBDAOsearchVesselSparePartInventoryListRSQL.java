/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ReeferSparePartMgtDBDAOsearchVesselSparePartInventoryListRSQL.java
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

public class ReeferSparePartMgtDBDAOsearchVesselSparePartInventoryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ReeferSparePartMgtDBDAOsearchVesselSparePartInventoryListRSQL
	  * </pre>
	  */
	public ReeferSparePartMgtDBDAOsearchVesselSparePartInventoryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spr_prt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spr_prt_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.integration").append("\n"); 
		query.append("FileName : ReeferSparePartMgtDBDAOsearchVesselSparePartInventoryListRSQL").append("\n"); 
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
		query.append("    SPR_PRT_INVT_NO, " ).append("\n"); 
		query.append("    MAX(SPR_PRT_INVT_VER_SEQ) AS SPR_PRT_INVT_VER_SEQ," ).append("\n"); 
		query.append("	TO_CHAR(MAX(CRE_DT),'YYYY-MM-DD') AS CRE_DT" ).append("\n"); 
		query.append("FROM MNR_VSL_SPR_PRT_INVT" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${from_dt} != '' && ${to_dt} != '') " ).append("\n"); 
		query.append("AND (TO_CHAR(CRE_DT,'YYYYMMDD') BETWEEN REPLACE(@[from_dt],'-','') AND REPLACE(@[to_dt],'-',''))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lane_cd} != '') " ).append("\n"); 
		query.append("AND LANE_CD = @[lane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_cd} != '') " ).append("\n"); 
		query.append("AND VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${spr_prt_tp_cd} != '') " ).append("\n"); 
		query.append("AND SPR_PRT_TP_CD = @[spr_prt_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${spr_prt_vndr_seq} != '') " ).append("\n"); 
		query.append("AND SPR_PRT_VNDR_SEQ = @[spr_prt_vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY SPR_PRT_INVT_NO" ).append("\n"); 
		query.append("ORDER BY SPR_PRT_INVT_NO" ).append("\n"); 

	}
}