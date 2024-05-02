/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ContainerMovementFinderDBDAOModifymanageBKGListUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.31
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.31 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementFinderDBDAOModifymanageBKGListUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Update
	  * </pre>
	  */
	public ContainerMovementFinderDBDAOModifymanageBKGListUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementFinderDBDAOModifymanageBKGListUSQL").append("\n"); 
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
		query.append("UPDATE CTM_BOOKING" ).append("\n"); 
		query.append("SET VSL_CD = (SELECT VSL_CD" ).append("\n"); 
		query.append("				FROM CTM_BKG_VVD" ).append("\n"); 
		query.append("				WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("				AND VSL_PRE_PST_CD = 'T')," ).append("\n"); 
		query.append("    SKD_VOY_NO = (SELECT SKD_VOY_NO" ).append("\n"); 
		query.append("				FROM CTM_BKG_VVD" ).append("\n"); 
		query.append("				WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("				AND VSL_PRE_PST_CD = 'T')," ).append("\n"); 
		query.append("    SKD_DIR_CD = (SELECT SKD_DIR_CD" ).append("\n"); 
		query.append("				FROM CTM_BKG_VVD" ).append("\n"); 
		query.append("				WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("				AND VSL_PRE_PST_CD = 'T')," ).append("\n"); 
		query.append("	SLAN_CD = (SELECT SLAN_CD" ).append("\n"); 
		query.append("				FROM CTM_BKG_VVD" ).append("\n"); 
		query.append("				WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("				AND VSL_PRE_PST_CD = 'T')," ).append("\n"); 
		query.append("    POL_CD = (SELECT POL_CD FROM (SELECT POL_CD" ).append("\n"); 
		query.append("				FROM CTM_BKG_VVD" ).append("\n"); 
		query.append("				WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("				AND ROWNUM=1" ).append("\n"); 
		query.append("				ORDER BY VSL_PRE_PST_CD, VSL_SEQ))," ).append("\n"); 
		query.append("    POD_CD = (SELECT POD_CD FROM (SELECT POD_CD" ).append("\n"); 
		query.append("				FROM CTM_BKG_VVD" ).append("\n"); 
		query.append("				WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("				AND ROWNUM=1" ).append("\n"); 
		query.append("				ORDER BY VSL_PRE_PST_CD DESC, VSL_SEQ DESC))," ).append("\n"); 
		query.append("    UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("    UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}