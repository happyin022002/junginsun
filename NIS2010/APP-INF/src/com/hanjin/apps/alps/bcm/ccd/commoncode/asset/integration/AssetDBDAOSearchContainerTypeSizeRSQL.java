/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : AssetDBDAOSearchContainerTypeSizeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.05.18
*@LastModifier : 
*@LastVersion : 1.0
* 2018.05.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.asset.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AssetDBDAOSearchContainerTypeSizeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2011.02.25 조인영 Container Type Size 정보를 조회한다.
	  * </pre>
	  */
	public AssetDBDAOSearchContainerTypeSizeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.ccd.commoncode.asset.integration").append("\n"); 
		query.append("FileName : AssetDBDAOSearchContainerTypeSizeRSQL").append("\n"); 
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
		query.append("SELECT CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       ,CNTR_SZ_CD" ).append("\n"); 
		query.append("       ,CNTR_TP_CD" ).append("\n"); 
		query.append("       ,CNTR_TPSZ_LODG_WGT" ).append("\n"); 
		query.append("       ,CNTR_TPSZ_LODG_CAPA" ).append("\n"); 
		query.append("       ,CNTR_TPSZ_TARE_WGT" ).append("\n"); 
		query.append("       ,CNTR_TPSZ_DESC" ).append("\n"); 
		query.append("       ,CNTR_TPSZ_RMK" ).append("\n"); 
		query.append("       ,CNTR_TPSZ_PSA_CD" ).append("\n"); 
		query.append("       ,CNTR_TPSZ_ISO_CD" ).append("\n"); 
		query.append("       ,MODI_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       ,CRE_USR_ID" ).append("\n"); 
		query.append("       ,TO_CHAR(CRE_DT,'YYYY-MM-DD HH24:MI') CRE_DT" ).append("\n"); 
		query.append("       ,UPD_USR_ID" ).append("\n"); 
		query.append("       ,TO_CHAR(UPD_DT,'YYYY-MM-DD HH24:MI') UPD_DT" ).append("\n"); 
		query.append("       ,DELT_FLG" ).append("\n"); 
		query.append("       ,EAI_EVNT_DT" ).append("\n"); 
		query.append("       ,CNTR_TPSZ_GRP_CD" ).append("\n"); 
		query.append("       ,RPT_DP_SEQ" ).append("\n"); 
		query.append("       ,ACIAC_DIV_CD" ).append("\n"); 
		query.append("       ,EAI_IF_ID" ).append("\n"); 
		query.append("FROM MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append("WHERE  CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 

	}
}