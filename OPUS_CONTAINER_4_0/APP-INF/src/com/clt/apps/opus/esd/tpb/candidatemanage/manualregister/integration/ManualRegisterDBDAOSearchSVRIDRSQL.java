/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ManualRegisterDBDAOSearchSVRIDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 변종건
*@LastVersion : 1.0
* 2010.02.22 변종건
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.candidatemanage.manualregister.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Geon Byeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManualRegisterDBDAOSearchSVRIDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchSVRID
	  * </pre>
	  */
	public ManualRegisterDBDAOSearchSVRIDRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_if_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.candidatemanage.manualregister.integration").append("\n"); 
		query.append("FileName : ManualRegisterDBDAOSearchSVRIDRSQL").append("\n"); 
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
		query.append("SELECT SVR.SYS_AREA_GRP_ID SVR_ID" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION ORG," ).append("\n"); 
		query.append("MDM_LOCATION LOC," ).append("\n"); 
		query.append("COM_SYS_AREA_GRP_ID SVR" ).append("\n"); 
		query.append("WHERE ORG.LOC_CD = LOC.LOC_CD" ).append("\n"); 
		query.append("AND LOC.CNT_CD = SVR.CNT_CD" ).append("\n"); 
		query.append("AND ORG.OFC_CD = @[s_if_ofc_cd]" ).append("\n"); 
		query.append("AND NVL(ORG.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("AND NVL(LOC.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("AND SVR.SVR_USD_FLG = 'Y'" ).append("\n"); 
		query.append("AND SVR.CO_IND_CD = 'H'" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}