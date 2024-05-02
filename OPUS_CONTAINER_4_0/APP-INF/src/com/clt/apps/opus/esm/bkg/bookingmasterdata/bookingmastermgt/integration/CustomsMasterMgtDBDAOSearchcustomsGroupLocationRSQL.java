/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CustomsMasterMgtDBDAOSearchcustomsGroupLocationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.25
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomsMasterMgtDBDAOSearchcustomsGroupLocationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *  0354 Canada ACI: Location of Goods Setup - Loc Code 조회			
	  * </pre>
	  */
	public CustomsMasterMgtDBDAOSearchcustomsGroupLocationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_hub_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : CustomsMasterMgtDBDAOSearchcustomsGroupLocationRSQL").append("\n"); 
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
		query.append("SELECT  GDS_LOC_SEQ" ).append("\n"); 
		query.append("	  , POD_CD" ).append("\n"); 
		query.append("      , POD_YD_NO" ).append("\n"); 
		query.append("      , (SELECT YD_NM FROM MDM_YARD WHERE YD_CD = A.POD_CD||POD_YD_NO ) YD_DESC" ).append("\n"); 
		query.append("      , POD_CD POD_CD_CPY" ).append("\n"); 
		query.append("      , DEL_CD" ).append("\n"); 
		query.append("	  , HUB_LOC_CD" ).append("\n"); 
		query.append("	  , TRSP_MOD_ID" ).append("\n"); 
		query.append("	  , GDS_DESC" ).append("\n"); 
		query.append("	  , CSTMS_CD" ).append("\n"); 
		query.append("	  , ( SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = A.POD_CD ) POD_DESC" ).append("\n"); 
		query.append("	  , ( SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = A.DEL_CD ) DEL_DESC" ).append("\n"); 
		query.append("	  , ( SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = A.HUB_LOC_CD ) HUB_DESC" ).append("\n"); 
		query.append("	  , '' UPD_USR_ID" ).append("\n"); 
		query.append("	  , '' P_POD_CD" ).append("\n"); 
		query.append("	  , '' P_DEL_CD" ).append("\n"); 
		query.append("	  , '' P_HUB_LOC_CD" ).append("\n"); 
		query.append("FROM   BKG_CSTMS_CND_GDS_LOC A /* INBOND_LOC_GOODS */" ).append("\n"); 
		query.append("WHERE POD_CD     = @[p_pod_cd]" ).append("\n"); 
		query.append("AND   DEL_CD     LIKE '%'||@[p_del_cd]||'%'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${p_hub_loc_cd} != '') " ).append("\n"); 
		query.append("	AND   HUB_LOC_CD LIKE '%'||@[p_hub_loc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}