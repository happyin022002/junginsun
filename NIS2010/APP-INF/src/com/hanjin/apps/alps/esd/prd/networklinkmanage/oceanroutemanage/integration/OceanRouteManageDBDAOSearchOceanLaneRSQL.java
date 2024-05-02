/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OceanRouteManageDBDAOSearchOceanLaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.19
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2010.10.19 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OceanRouteManageDBDAOSearchOceanLaneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchOceanLane
	  * </pre>
	  */
	public OceanRouteManageDBDAOSearchOceanLaneRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ori_loc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_loc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.integration").append("\n"); 
		query.append("FileName : OceanRouteManageDBDAOSearchOceanLaneRSQL").append("\n"); 
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
		query.append("SELECT FM_PORT_CD POLX, TO_PORT_CD PODX, VSL_SLAN_CD LANEX, SKD_DIR_CD DIRX, 'N' FDR_FLGX," ).append("\n"); 
		query.append("(SELECT DECODE(VSL_SVC_TP_CD, 'O','C', VSL_SVC_TP_CD) FROM MDM_VSL_SVC_LANE WHERE VSL_SLAN_CD = A.VSL_SLAN_CD) SVC_TPX," ).append("\n"); 
		query.append("TZTM_HRS TTX, FM_PORT_ETB_DY_CD POLXETB, TO_PORT_ETB_DY_CD PODXETB" ).append("\n"); 
		query.append("FROM PRD_PF_TZ_TM A" ).append("\n"); 
		query.append("WHERE EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("FROM PRD_SVC_LANE B" ).append("\n"); 
		query.append("WHERE A.VSL_SLAN_CD = B.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND B.UPD_IND_CD <> 'D'" ).append("\n"); 
		query.append("AND ROWNUM = 1)" ).append("\n"); 
		query.append("AND FM_PORT_CD  = @[ori_loc]" ).append("\n"); 
		query.append("AND DECODE(@[dest_loc], NULL, 'ALL', TO_PORT_CD)   = DECODE(@[dest_loc], NULL, 'ALL', @[dest_loc])" ).append("\n"); 
		query.append("AND DECODE(@[lane], NULL, 'ALL', VSL_SLAN_CD) = DECODE(@[lane], NULL, 'ALL', @[lane])" ).append("\n"); 
		query.append("AND DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT LNK_ORG_LOC_CD POLX, LNK_DEST_LOC_CD POLX, VSL_SLAN_CD POLX, SKD_DIR_CD DIRX, 'Y' FDR_FLGX," ).append("\n"); 
		query.append("(SELECT DECODE(VSL_SVC_TP_CD, 'O','C', VSL_SVC_TP_CD) FROM MDM_VSL_SVC_LANE WHERE VSL_SLAN_CD = A.VSL_SLAN_CD) SVC_TPX," ).append("\n"); 
		query.append("TZTM_HRS TTX, ' ' POLXETB, ' ' PODXETB" ).append("\n"); 
		query.append("FROM PRD_FDR_LNK A" ).append("\n"); 
		query.append("WHERE LNK_ORG_LOC_CD = @[ori_loc]" ).append("\n"); 
		query.append("AND DECODE(@[dest_loc], NULL, 'ALL', LNK_DEST_LOC_CD)   = DECODE(@[dest_loc], NULL, 'ALL', @[dest_loc])" ).append("\n"); 
		query.append("AND DECODE(@[lane], NULL, 'ALL', VSL_SLAN_CD) = DECODE(@[lane], NULL, 'ALL', @[lane])" ).append("\n"); 

	}
}