/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OceanLinkBackEndDBDAORemoveOceanRouteByHQLinkUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OceanLinkBackEndDBDAORemoveOceanRouteByHQLinkUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * HQ Link에 의해 Ocean Route를 Delete update
	  * </pre>
	  */
	public OceanLinkBackEndDBDAORemoveOceanRouteByHQLinkUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("podprot",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dircd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lanecd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("polprot",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.integration").append("\n"); 
		query.append("FileName : OceanLinkBackEndDBDAORemoveOceanRouteByHQLinkUSQL").append("\n"); 
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
		query.append("UPDATE PRD_OCN_ROUT" ).append("\n"); 
		query.append("   SET UPD_IND_CD = 'D'" ).append("\n"); 
		query.append("     , OCN_ROUT_UPD_DT  = SYSDATE" ).append("\n"); 
		query.append("     , UPD_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("     , UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("     , OCN_ROUT_DELT_RMK = SYSDATE||' ID:'||@[upd_usr_id]||'  ,Deleted by HQ Ocean Link, '" ).append("\n"); 
		query.append("       || CASE WHEN     N1ST_POL_CD  = RTRIM(@[polprot])" ).append("\n"); 
		query.append("                    AND N1ST_POD_CD  = RTRIM(@[podprot])" ).append("\n"); 
		query.append("                    AND N1ST_LANE_CD = RTRIM(@[lanecd])" ).append("\n"); 
		query.append("					AND N1ST_SKD_DIR_CD = @[dircd]" ).append("\n"); 
		query.append("                    AND N1ST_LANE_FDR_FLG = 'N'" ).append("\n"); 
		query.append("                  THEN 'N1St lane'" ).append("\n"); 
		query.append("               WHEN     N2ND_POL_CD  = RTRIM(@[polprot])" ).append("\n"); 
		query.append("                    AND N2ND_POD_CD  = RTRIM(@[podprot])" ).append("\n"); 
		query.append("                    AND N2ND_LANE_CD = RTRIM(@[lanecd])" ).append("\n"); 
		query.append("					AND N2ND_SKD_DIR_CD = @[dircd]" ).append("\n"); 
		query.append("                    AND N2ND_LANE_FDR_FLG = 'N'" ).append("\n"); 
		query.append("                  THEN 'N2Nd lane'" ).append("\n"); 
		query.append("               WHEN     N3RD_POL_CD  = RTRIM(@[polprot])" ).append("\n"); 
		query.append("                    AND N3RD_POD_CD  = RTRIM(@[podprot])" ).append("\n"); 
		query.append("                    AND N3RD_LANE_CD = RTRIM(@[lanecd])" ).append("\n"); 
		query.append("					AND N3RD_SKD_DIR_CD = @[dircd]" ).append("\n"); 
		query.append("                    AND N3RD_LANE_FDR_FLG = 'N'" ).append("\n"); 
		query.append("                  THEN 'N3Rd lane'" ).append("\n"); 
		query.append("               ELSE    'N4Th lane'" ).append("\n"); 
		query.append("          END" ).append("\n"); 
		query.append(" WHERE UPD_IND_CD  <> 'D'" ).append("\n"); 
		query.append("   AND (" ).append("\n"); 
		query.append("           (     N1ST_POL_CD  = RTRIM(@[polprot])" ).append("\n"); 
		query.append("             AND N1ST_POD_CD  = RTRIM(@[podprot])" ).append("\n"); 
		query.append("             AND N1ST_LANE_CD = RTRIM(@[lanecd])" ).append("\n"); 
		query.append("			 AND N1ST_SKD_DIR_CD = @[dircd]" ).append("\n"); 
		query.append("             AND N1ST_LANE_FDR_FLG = 'N'" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("           OR" ).append("\n"); 
		query.append("           (     N2ND_POL_CD  = RTRIM(@[polprot])" ).append("\n"); 
		query.append("             AND N2ND_POD_CD  = RTRIM(@[podprot])" ).append("\n"); 
		query.append("             AND N2ND_LANE_CD = RTRIM(@[lanecd])" ).append("\n"); 
		query.append("			 AND N2ND_SKD_DIR_CD = @[dircd]" ).append("\n"); 
		query.append("             AND N2ND_LANE_FDR_FLG = 'N'" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("           OR" ).append("\n"); 
		query.append("           (     N3RD_POL_CD  = RTRIM(@[polprot])" ).append("\n"); 
		query.append("             AND N3RD_POD_CD  = RTRIM(@[podprot])" ).append("\n"); 
		query.append("             AND N3RD_LANE_CD = RTRIM(@[lanecd])" ).append("\n"); 
		query.append("			 AND N3RD_SKD_DIR_CD = @[dircd] 	" ).append("\n"); 
		query.append("             AND N3RD_LANE_FDR_FLG = 'N'" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("           OR" ).append("\n"); 
		query.append("           (     N4TH_POL_CD  = RTRIM(@[polprot])" ).append("\n"); 
		query.append("             AND N4TH_POD_CD  = RTRIM(@[podprot])" ).append("\n"); 
		query.append("             AND N4TH_LANE_CD = RTRIM(@[lanecd])" ).append("\n"); 
		query.append("			 AND N4TH_SKD_DIR_CD = @[dircd] 	 	" ).append("\n"); 
		query.append("             AND N4TH_LANE_FDR_FLG = 'N'" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("       )" ).append("\n"); 

	}
}