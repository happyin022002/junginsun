/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AssetDBDAOSearchContainerTypeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.24
*@LastModifier : 조인영
*@LastVersion : 1.0
* 2011.02.24 조인영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.asset.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Cho In Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AssetDBDAOSearchContainerTypeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2011.02.24 조인영 Container Type 정보를 조회한다.
	  * </pre>
	  */
	public AssetDBDAOSearchContainerTypeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.asset.integration ").append("\n"); 
		query.append("FileName : AssetDBDAOSearchContainerTypeRSQL").append("\n"); 
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
		query.append("SELECT CNTR_TP_CD" ).append("\n"); 
		query.append("       ,CNTR_TP_DESC" ).append("\n"); 
		query.append("       ,MODI_CNTR_TP_CD" ).append("\n"); 
		query.append("       ,CRE_USR_ID" ).append("\n"); 
		query.append("       ,CRE_DT" ).append("\n"); 
		query.append("       ,UPD_USR_ID" ).append("\n"); 
		query.append("       ,UPD_DT" ).append("\n"); 
		query.append("       ,DELT_FLG" ).append("\n"); 
		query.append("       ,EAI_EVNT_DT" ).append("\n"); 
		query.append("       ,EAI_IF_ID" ).append("\n"); 
		query.append("FROM MDM_CNTR_TP" ).append("\n"); 
		query.append("WHERE CNTR_TP_CD = @[cntr_tp_cd]" ).append("\n"); 

	}
}