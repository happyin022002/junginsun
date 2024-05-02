/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InlandRouteManageUsaDBDAOHistoryAddCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.07
*@LastModifier : 김귀진
*@LastVersion : 1.0
* 2009.08.07 김귀진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kIm kwi-jin
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
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.integration ").append("\n"); 
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
		query.append("INSERT INTO PRD_INLND_ROUT_MST_HIS" ).append("\n"); 
		query.append("(ROUT_ORG_NOD_CD, ROUT_DEST_NOD_CD, ROUT_SEQ, HIS_CRE_DT, PRIO_SEQ," ).append("\n"); 
		query.append("INLND_ROUT_INV_BIL_PATT_CD, ROUT_PLN_CD, WRS_FULL_CMDT_CD," ).append("\n"); 
		query.append("WRS_MTY_CMDT_CD, MCNTR_ROUT_FLG, INLND_ROUT_BKG_FLG, INLND_ROUT_RMK," ).append("\n"); 
		query.append("CRE_OFC_CD, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT, PCTL_IO_BND_CD," ).append("\n"); 
		query.append("INLND_ROUT_TMP_FLG, DELT_FLG, INLND_ROUT_INCL_STTL_FLG, INLND_ROUT_N2ND_RMK," ).append("\n"); 
		query.append("HUB_LOC_CD, D2_CAPA_FLG, D4_CAPA_FLG, D5_CAPA_FLG, D7_CAPA_FLG, O2_CAPA_FLG," ).append("\n"); 
		query.append("O4_CAPA_FLG, A2_CAPA_FLG, A4_CAPA_FLG, R5_CAPA_FLG, HUB_NOD_CD)" ).append("\n"); 
		query.append("SELECT ROUT_ORG_NOD_CD, ROUT_DEST_NOD_CD, ROUT_SEQ, SYSDATE, PRIO_SEQ," ).append("\n"); 
		query.append("INLND_ROUT_INV_BIL_PATT_CD, ROUT_PLN_CD, WRS_FULL_CMDT_CD," ).append("\n"); 
		query.append("WRS_MTY_CMDT_CD, MCNTR_ROUT_FLG, INLND_ROUT_BKG_FLG, INLND_ROUT_RMK," ).append("\n"); 
		query.append("CRE_OFC_CD, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT, PCTL_IO_BND_CD," ).append("\n"); 
		query.append("INLND_ROUT_TMP_FLG, DELT_FLG, INLND_ROUT_INCL_STTL_FLG, INLND_ROUT_N2ND_RMK," ).append("\n"); 
		query.append("HUB_LOC_CD, D2_CAPA_FLG, D4_CAPA_FLG, D5_CAPA_FLG, D7_CAPA_FLG, O2_CAPA_FLG," ).append("\n"); 
		query.append("O4_CAPA_FLG, A2_CAPA_FLG, A4_CAPA_FLG, R5_CAPA_FLG, HUB_NOD_CD" ).append("\n"); 
		query.append("FROM PRD_INLND_ROUT_MST" ).append("\n"); 
		query.append("WHERE ROUT_ORG_NOD_CD = @[rout_org_nod_cd]" ).append("\n"); 
		query.append("AND ROUT_DEST_NOD_CD =@[rout_dest_nod_cd]" ).append("\n"); 
		query.append("AND ROUT_SEQ = @[rout_seq]" ).append("\n"); 

	}
}