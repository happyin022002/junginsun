/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InlandRouteManageUsaDBDAOHistoryAddCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandRouteManageUsaDBDAOHistoryAddCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * HISTORY ADD
	  * </pre>
	  */
	public InlandRouteManageUsaDBDAOHistoryAddCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_org_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_dest_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.integration").append("\n"); 
		query.append("FileName : InlandRouteManageUsaDBDAOHistoryAddCSQL").append("\n"); 
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
		query.append("INSERT INTO PRD_INLND_ROUT_MST_HIS (" ).append("\n"); 
		query.append("   ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("  ,ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("  ,ROUT_SEQ" ).append("\n"); 
		query.append("  ,HIS_CRE_DT" ).append("\n"); 
		query.append("  ,PRIO_SEQ" ).append("\n"); 
		query.append("  ,INLND_ROUT_INV_BIL_PATT_CD" ).append("\n"); 
		query.append("  ,ROUT_PLN_CD" ).append("\n"); 
		query.append("  ,WRS_FULL_CMDT_CD" ).append("\n"); 
		query.append("  ,WRS_MTY_CMDT_CD" ).append("\n"); 
		query.append("  ,MCNTR_ROUT_FLG" ).append("\n"); 
		query.append("  ,INLND_ROUT_BKG_FLG" ).append("\n"); 
		query.append("  ,INLND_ROUT_RMK" ).append("\n"); 
		query.append("  ,CRE_OFC_CD" ).append("\n"); 
		query.append("  ,CRE_USR_ID" ).append("\n"); 
		query.append("  ,CRE_DT" ).append("\n"); 
		query.append("  ,UPD_USR_ID" ).append("\n"); 
		query.append("  ,UPD_DT" ).append("\n"); 
		query.append("  ,PCTL_IO_BND_CD" ).append("\n"); 
		query.append("  ,INLND_ROUT_TMP_FLG" ).append("\n"); 
		query.append("  ,DELT_FLG" ).append("\n"); 
		query.append("  ,INLND_ROUT_INCL_STTL_FLG" ).append("\n"); 
		query.append("  ,INLND_ROUT_N2ND_RMK" ).append("\n"); 
		query.append("  ,HUB_LOC_CD" ).append("\n"); 
		query.append("  ,D2_CAPA_FLG" ).append("\n"); 
		query.append("  ,D4_CAPA_FLG" ).append("\n"); 
		query.append("  ,D5_CAPA_FLG" ).append("\n"); 
		query.append("  ,D7_CAPA_FLG" ).append("\n"); 
		query.append("  ,O2_CAPA_FLG" ).append("\n"); 
		query.append("  ,O4_CAPA_FLG" ).append("\n"); 
		query.append("  ,A2_CAPA_FLG" ).append("\n"); 
		query.append("  ,A4_CAPA_FLG" ).append("\n"); 
		query.append("  ,R5_CAPA_FLG" ).append("\n"); 
		query.append("  ,HUB_NOD_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("  SELECT ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("        ,ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("        ,ROUT_SEQ" ).append("\n"); 
		query.append("        ,SYSDATE" ).append("\n"); 
		query.append("        ,PRIO_SEQ" ).append("\n"); 
		query.append("        ,INLND_ROUT_INV_BIL_PATT_CD" ).append("\n"); 
		query.append("        ,ROUT_PLN_CD" ).append("\n"); 
		query.append("        ,WRS_FULL_CMDT_CD" ).append("\n"); 
		query.append("        ,WRS_MTY_CMDT_CD" ).append("\n"); 
		query.append("        ,MCNTR_ROUT_FLG" ).append("\n"); 
		query.append("        ,INLND_ROUT_BKG_FLG" ).append("\n"); 
		query.append("        ,INLND_ROUT_RMK" ).append("\n"); 
		query.append("        ,CRE_OFC_CD" ).append("\n"); 
		query.append("        ,CRE_USR_ID" ).append("\n"); 
		query.append("        ,CRE_DT" ).append("\n"); 
		query.append("        ,UPD_USR_ID" ).append("\n"); 
		query.append("        ,UPD_DT" ).append("\n"); 
		query.append("        ,PCTL_IO_BND_CD" ).append("\n"); 
		query.append("        ,INLND_ROUT_TMP_FLG" ).append("\n"); 
		query.append("        ,DELT_FLG" ).append("\n"); 
		query.append("        ,INLND_ROUT_INCL_STTL_FLG" ).append("\n"); 
		query.append("        ,INLND_ROUT_N2ND_RMK" ).append("\n"); 
		query.append("        ,HUB_LOC_CD" ).append("\n"); 
		query.append("        ,D2_CAPA_FLG" ).append("\n"); 
		query.append("        ,D4_CAPA_FLG" ).append("\n"); 
		query.append("        ,D5_CAPA_FLG" ).append("\n"); 
		query.append("        ,D7_CAPA_FLG" ).append("\n"); 
		query.append("        ,O2_CAPA_FLG" ).append("\n"); 
		query.append("        ,O4_CAPA_FLG" ).append("\n"); 
		query.append("        ,A2_CAPA_FLG" ).append("\n"); 
		query.append("        ,A4_CAPA_FLG" ).append("\n"); 
		query.append("        ,R5_CAPA_FLG" ).append("\n"); 
		query.append("        ,HUB_NOD_CD" ).append("\n"); 
		query.append("    FROM PRD_INLND_ROUT_MST" ).append("\n"); 
		query.append("   WHERE ROUT_ORG_NOD_CD = @[rout_org_nod_cd]" ).append("\n"); 
		query.append("     AND ROUT_DEST_NOD_CD = @[rout_dest_nod_cd]" ).append("\n"); 
		query.append("     AND ROUT_SEQ = @[rout_seq]" ).append("\n"); 

	}
}