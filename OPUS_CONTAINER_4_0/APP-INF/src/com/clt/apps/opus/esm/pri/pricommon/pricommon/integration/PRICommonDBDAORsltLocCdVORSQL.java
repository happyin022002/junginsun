/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PRICommonDBDAORsltLocCdVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.20
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2015.05.20 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHLOE MIJIN SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAORsltLocCdVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MDM_SVC_SCP_LMT 에 존재하는 LOCATION 코드조회
	  * </pre>
	  */
	public PRICommonDBDAORsltLocCdVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAORsltLocCdVORSQL").append("\n"); 
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
		query.append("#if (${etc1} != 'B')" ).append("\n"); 
		query.append("SELECT B.LOC_CD CD" ).append("\n"); 
		query.append("     , B.LOC_NM NM" ).append("\n"); 
		query.append("     , B.SCONTI_CD ETC1" ).append("\n"); 
		query.append("     , (SELECT SCONTI_NM " ).append("\n"); 
		query.append("          FROM MDM_SUBCONTINENT " ).append("\n"); 
		query.append("         WHERE SCONTI_CD = B.SCONTI_CD " ).append("\n"); 
		query.append("           AND DELT_FLG = 'N') AS ETC2" ).append("\n"); 
		query.append("  FROM MDM_SVC_SCP_LMT A" ).append("\n"); 
		query.append("     , MDM_LOCATION B" ).append("\n"); 
		query.append(" WHERE A.SVC_SCP_CD  = @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND B.LOC_CD      = @[cd]" ).append("\n"); 
		query.append("   AND A.ORG_DEST_CD = @[etc1]" ).append("\n"); 
		query.append("   AND A.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("   AND A.RGN_CD      = B.RGN_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("SELECT CD" ).append("\n"); 
		query.append("	 , NM" ).append("\n"); 
		query.append("	 , ETC1" ).append("\n"); 
		query.append("	 , ETC2" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("	SELECT B.LOC_CD CD" ).append("\n"); 
		query.append("     	 , B.LOC_NM NM" ).append("\n"); 
		query.append("     	 , B.SCONTI_CD ETC1" ).append("\n"); 
		query.append("     	 , (SELECT SCONTI_NM " ).append("\n"); 
		query.append("          	  FROM MDM_SUBCONTINENT " ).append("\n"); 
		query.append("         	 WHERE SCONTI_CD = B.SCONTI_CD " ).append("\n"); 
		query.append("           	   AND DELT_FLG = 'N') AS ETC2" ).append("\n"); 
		query.append("  	  FROM MDM_SVC_SCP_LMT A" ).append("\n"); 
		query.append("     	 , MDM_LOCATION B" ).append("\n"); 
		query.append(" 	 WHERE A.SVC_SCP_CD  = @[svc_scp_cd]" ).append("\n"); 
		query.append("   	   AND B.LOC_CD      = @[cd]" ).append("\n"); 
		query.append("   	   AND A.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("   	   AND A.RGN_CD      = B.RGN_CD ) " ).append("\n"); 
		query.append(" GROUP BY CD, NM, ETC1, ETC2 HAVING COUNT(*)>=1" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}