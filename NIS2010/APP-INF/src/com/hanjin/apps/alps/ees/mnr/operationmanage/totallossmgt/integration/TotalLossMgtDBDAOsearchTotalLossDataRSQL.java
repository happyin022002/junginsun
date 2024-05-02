/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TotalLossMgtDBDAOsearchTotalLossDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TotalLossMgtDBDAOsearchTotalLossDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchTotalLossData
	  * </pre>
	  */
	public TotalLossMgtDBDAOsearchTotalLossDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_ttl_lss_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.integration").append("\n"); 
		query.append("FileName : TotalLossMgtDBDAOsearchTotalLossDataRSQL").append("\n"); 
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
		query.append("SELECT A.TTL_LSS_NO" ).append("\n"); 
		query.append("      ,A.RQST_OFC_CD" ).append("\n"); 
		query.append("      ,A.APRO_OFC_CD" ).append("\n"); 
		query.append("      ,A.RESPB_OFC_CD" ).append("\n"); 
		query.append("	  ,(SELECT OFC_ENG_NM" ).append("\n"); 
		query.append("        FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("        WHERE OFC_CD = A.RESPB_OFC_CD" ).append("\n"); 
		query.append("       ) AS RESPB_OFC_NM" ).append("\n"); 
		query.append("	  ,TO_CHAR(A.TTL_LSS_DT, 'yyyy-mm-dd') TTL_LSS_DT" ).append("\n"); 
		query.append("	  --,TO_CHAR(sysdate, 'yyyy-mm-dd') TTL_LSS_DT -- Total Loss Date를 Sysdate로 변경 - 이율규 2015.06.11" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ,TO_CHAR(A.RQST_DT, 'yyyy-mm-dd') RQST_DT" ).append("\n"); 
		query.append("      ,A.TTL_LSS_STS_CD" ).append("\n"); 
		query.append("      ,A.MNR_STS_REF_NO" ).append("\n"); 
		query.append("      ,TO_CHAR(A.TTL_LSS_CFM_DT, 'yyyy-mm-dd') TTL_LSS_CFM_DT" ).append("\n"); 
		query.append("      ,A.TTL_LSS_CFM_ID" ).append("\n"); 
		query.append("      ,A.TTL_LSS_RSN_CD" ).append("\n"); 
		query.append("      ,A.TTL_LSS_DTL_RSN_CD" ).append("\n"); 
		query.append("      ,A.TTL_LSS_RMK" ).append("\n"); 
		query.append("      ,A.FILE_SEQ" ).append("\n"); 
		query.append("      ,A.CRE_USR_ID" ).append("\n"); 
		query.append("      ,TO_CHAR(A.CRE_DT, 'yyyy-mm-dd') CRE_DT" ).append("\n"); 
		query.append("      ,A.UPD_USR_ID" ).append("\n"); 
		query.append("      ,TO_CHAR(A.UPD_DT, 'yyyy-mm-dd') UPD_DT" ).append("\n"); 
		query.append("	  ,A.ACC_FLG" ).append("\n"); 
		query.append("      ,TO_CHAR(A.ACC_DT, 'yyyy-mm-dd') ACC_DT" ).append("\n"); 
		query.append("	  ,A.ACC_VSL_CD" ).append("\n"); 
		query.append("	  ,A.ACC_SKD_VOY_NO" ).append("\n"); 
		query.append("	  ,A.ACC_SKD_DIR_CD" ).append("\n"); 
		query.append("	  ,A.ACC_PORT_CD" ).append("\n"); 
		query.append("  FROM MNR_TTL_LSS_RQST_HDR A" ).append("\n"); 
		query.append(" WHERE A.TTL_LSS_NO = @[search_ttl_lss_no]" ).append("\n"); 
		query.append("#if (${work_type} != 'collection')" ).append("\n"); 
		query.append("	AND A.TTL_LSS_STS_CD IN ('HJ','HS','HR', 'AA')" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}