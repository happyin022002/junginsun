/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PRICommonDBDAORsltSvcScpLaneCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.06.10 김재연
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JaeYeon Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAORsltSvcScpLaneCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MDM_SVC_SCP_LANE 테이블 조회
	  * </pre>
	  */
	public PRICommonDBDAORsltSvcScpLaneCdRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT" ).append("\n"); 
		query.append("A.VSL_SLAN_CD AS CD" ).append("\n"); 
		query.append(",	B.VSL_SLAN_NM AS NM" ).append("\n"); 
		query.append("FROM MDM_SVC_SCP_LANE A," ).append("\n"); 
		query.append("MDM_VSL_SVC_LANE B" ).append("\n"); 
		query.append("WHERE	A.SVC_SCP_CD = @[cd]" ).append("\n"); 
		query.append("AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND A.VSL_SLAN_CD = B.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY A.VSL_SLAN_CD" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAORsltSvcScpLaneCdRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}