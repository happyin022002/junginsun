/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGExternalFinderDBDAOSearchTargetLaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.16
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.09.16 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.scgcommon.scgexternalfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGExternalFinderDBDAOSearchTargetLaneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public SCGExternalFinderDBDAOSearchTargetLaneRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.scgcommon.scgexternalfinder.integration").append("\n"); 
		query.append("FileName : SCGExternalFinderDBDAOSearchTargetLaneRSQL").append("\n"); 
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
		query.append("SELECT  DISTINCT H.VSL_SLAN_CD" ).append("\n"); 
		query.append(",(SELECT A2.VSL_SLAN_NM  FROM MDM_VSL_SVC_LANE A2 WHERE A2.VSL_SLAN_CD= H.VSL_SLAN_CD AND ROWNUM=1)VSL_SLAN_NM" ).append("\n"); 
		query.append("FROM   VSK_PF_SKD H, VSK_PF_CALL_PORT F, VSK_PF_CALL_PORT T" ).append("\n"); 
		query.append("WHERE  ( H.SLAN_STND_FLG = 'Y' OR H.MML_USD_FLG = 'Y' )" ).append("\n"); 
		query.append("AND    H.VSL_SLAN_CD   = F.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND    H.PF_SVC_TP_CD  = F.PF_SVC_TP_CD" ).append("\n"); 
		query.append("AND    F.VSL_SLAN_CD   = T.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND    F.PF_SVC_TP_CD  = T.PF_SVC_TP_CD" ).append("\n"); 
		query.append("AND    F.SKD_DIR_CD    = T.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    F.PORT_ROTN_SEQ < T.PORT_ROTN_SEQ" ).append("\n"); 
		query.append("AND    F.PORT_CD       = @[pol]          --:pol_cd" ).append("\n"); 
		query.append("AND    T.PORT_CD       = @[pod]          --:pod_cd" ).append("\n"); 
		query.append("ORDER BY H.VSL_SLAN_CD" ).append("\n"); 

	}
}