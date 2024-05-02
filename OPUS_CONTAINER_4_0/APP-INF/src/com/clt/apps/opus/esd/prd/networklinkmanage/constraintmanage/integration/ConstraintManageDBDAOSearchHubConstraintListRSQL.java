/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ConstraintManageDBDAOSearchHubConstraintListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.08
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConstraintManageDBDAOSearchHubConstraintListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ConstraintManageDBDAOSearchHubConstraintList
	  * </pre>
	  */
	public ConstraintManageDBDAOSearchHubConstraintListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hport_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hnod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hhub_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.integration").append("\n"); 
		query.append("FileName : ConstraintManageDBDAOSearchHubConstraintListRSQL").append("\n"); 
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
		query.append("SELECT H.PORT_CD" ).append("\n"); 
		query.append("      ,H.HUB_LOC_CD" ).append("\n"); 
		query.append("      ,H.NOD_CD" ).append("\n"); 
		query.append("      ,H.IO_BND_CD" ).append("\n"); 
		query.append("      ,H.CNST_LANE_CD" ).append("\n"); 
		query.append("      ,H.SPCL_CGO_CNTR_TP_CD" ).append("\n"); 
		query.append("      ,H.SVC_USE_FLG" ).append("\n"); 
		query.append("      ,H.HUB_LOC_CNST_RMK" ).append("\n"); 
		query.append("      ,U.OFC_CD AS CRE_OFC_CD" ).append("\n"); 
		query.append("      ,H.CRE_USR_ID" ).append("\n"); 
		query.append("      ,TO_CHAR(H.CRE_DT, 'YYYY-MM-DD') AS CRE_DT" ).append("\n"); 
		query.append("      ,H.UPD_USR_ID" ).append("\n"); 
		query.append("      ,TO_CHAR(H.UPD_DT, 'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append("      ,H.DIR_CD" ).append("\n"); 
		query.append("      ,H.CNTR_TP_CD" ).append("\n"); 
		query.append("      ,H.CNTR_SZ_CD" ).append("\n"); 
		query.append("  FROM PRD_HUB_LOC_CNST_MGMT H" ).append("\n"); 
		query.append("      ,COM_USER              U" ).append("\n"); 
		query.append(" WHERE NVL2(@[hport_cd], H.PORT_CD, 'XX') = NVL(@[hport_cd], 'XX')" ).append("\n"); 
		query.append("   AND NVL2(@[hhub_loc_cd], H.HUB_LOC_CD, 'XX') = NVL(@[hhub_loc_cd], 'XX')" ).append("\n"); 
		query.append("   AND NVL2(@[hnod_cd], H.NOD_CD, 'XX') = NVL(@[hnod_cd], 'XX')" ).append("\n"); 
		query.append("   AND H.CRE_USR_ID = U.USR_ID(+)" ).append("\n"); 

	}
}