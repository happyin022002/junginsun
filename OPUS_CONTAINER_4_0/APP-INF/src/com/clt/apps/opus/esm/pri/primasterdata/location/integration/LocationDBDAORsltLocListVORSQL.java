/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : LocationDBDAORsltLocListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.09
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2015.07.09 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.location.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHLOE MIJIN SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LocationDBDAORsltLocListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public LocationDBDAORsltLocListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("org_dest_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.primasterdata.location.integration").append("\n"); 
		query.append("FileName : LocationDBDAORsltLocListVORSQL").append("\n"); 
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
		query.append("#if (${org_dest_cd} == 'O' || ${org_dest_cd} == 'D')" ).append("\n"); 
		query.append("SELECT B.LOC_CD" ).append("\n"); 
		query.append("     , B.LOC_NM" ).append("\n"); 
		query.append("	 , A.RGN_CD" ).append("\n"); 
		query.append("     , B.SCONTI_CD" ).append("\n"); 
		query.append("     , (SELECT SCONTI_NM " ).append("\n"); 
		query.append("          FROM MDM_SUBCONTINENT " ).append("\n"); 
		query.append("         WHERE SCONTI_CD = B.SCONTI_CD " ).append("\n"); 
		query.append("           AND DELT_FLG = 'N') AS SCONTI_NM" ).append("\n"); 
		query.append("     , B.STE_CD" ).append("\n"); 
		query.append("     , B.CNT_CD" ).append("\n"); 
		query.append("     , B.UN_LOC_CD" ).append("\n"); 
		query.append("  FROM MDM_SVC_SCP_LMT A" ).append("\n"); 
		query.append("     , MDM_LOCATION B" ).append("\n"); 
		query.append(" WHERE A.SVC_SCP_CD  = @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND A.ORG_DEST_CD = @[org_dest_cd]" ).append("\n"); 
		query.append("   #if (${loc_cd} != '') " ).append("\n"); 
		query.append("   AND B.LOC_CD LIKE  UPPER(@[loc_cd] || '%')" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${loc_nm} != '') " ).append("\n"); 
		query.append("   AND UPPER(B.LOC_NM) LIKE UPPER('%' || @[loc_nm] || '%')" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   AND A.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("   AND A.RGN_CD      = B.RGN_CD" ).append("\n"); 
		query.append(" ORDER BY B.LOC_CD ASC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${org_dest_cd} == 'B') " ).append("\n"); 
		query.append("SELECT LOC_CD" ).append("\n"); 
		query.append("	 , LOC_NM" ).append("\n"); 
		query.append("	 , RGN_CD" ).append("\n"); 
		query.append("	 , SCONTI_CD" ).append("\n"); 
		query.append("	 , SCONTI_NM" ).append("\n"); 
		query.append("     , STE_CD" ).append("\n"); 
		query.append("     , CNT_CD" ).append("\n"); 
		query.append("     , UN_LOC_CD" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("	SELECT B.LOC_CD" ).append("\n"); 
		query.append("     	 , B.LOC_NM" ).append("\n"); 
		query.append("		 , A.RGN_CD" ).append("\n"); 
		query.append("     	 , B.SCONTI_CD" ).append("\n"); 
		query.append("     	 , (SELECT SCONTI_NM " ).append("\n"); 
		query.append("          	  FROM MDM_SUBCONTINENT " ).append("\n"); 
		query.append("         	 WHERE SCONTI_CD = B.SCONTI_CD " ).append("\n"); 
		query.append("           	   AND DELT_FLG = 'N') AS SCONTI_NM" ).append("\n"); 
		query.append("         , B.STE_CD" ).append("\n"); 
		query.append("         , B.CNT_CD" ).append("\n"); 
		query.append("         , B.UN_LOC_CD" ).append("\n"); 
		query.append("  	  FROM MDM_SVC_SCP_LMT A" ).append("\n"); 
		query.append("     	 , MDM_LOCATION B" ).append("\n"); 
		query.append(" 	 WHERE A.SVC_SCP_CD  = @[svc_scp_cd]" ).append("\n"); 
		query.append("   	   #if (${loc_cd} != '') " ).append("\n"); 
		query.append("       AND B.LOC_CD LIKE  UPPER(@[loc_cd] || '%')" ).append("\n"); 
		query.append("   	   #end" ).append("\n"); 
		query.append("   	   #if (${loc_nm} != '') " ).append("\n"); 
		query.append("   	   AND UPPER(B.LOC_NM) LIKE UPPER('%' || @[loc_nm] || '%')" ).append("\n"); 
		query.append("   	   #end" ).append("\n"); 
		query.append("   	   AND A.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("   	   AND A.RGN_CD      = B.RGN_CD ) " ).append("\n"); 
		query.append(" ORDER BY LOC_CD ASC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	SELECT A.LOC_CD" ).append("\n"); 
		query.append("	 	 , A.LOC_NM" ).append("\n"); 
		query.append("	 	 , A.RGN_CD" ).append("\n"); 
		query.append("	 	 , A.SCONTI_CD" ).append("\n"); 
		query.append("	 	 , (SELECT SCONTI_NM " ).append("\n"); 
		query.append("		  	  FROM MDM_SUBCONTINENT " ).append("\n"); 
		query.append("		 	 WHERE SCONTI_CD = A.SCONTI_CD " ).append("\n"); 
		query.append("		   	   AND ROWNUM = 1) AS SCONTI_NM" ).append("\n"); 
		query.append("		 , A.ZIP_CD" ).append("\n"); 
		query.append("         , A.STE_CD" ).append("\n"); 
		query.append("         , A.CNT_CD" ).append("\n"); 
		query.append("         , A.UN_LOC_CD" ).append("\n"); 
		query.append("	  FROM MDM_LOCATION A" ).append("\n"); 
		query.append("	 WHERE A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("	   #if (${loc_cd} != '') " ).append("\n"); 
		query.append("	   AND A.LOC_CD LIKE  UPPER(@[loc_cd] || '%')" ).append("\n"); 
		query.append("	   #end" ).append("\n"); 
		query.append("	   #if (${loc_nm} != '') " ).append("\n"); 
		query.append("	   AND UPPER(A.LOC_NM) LIKE UPPER('%' || @[loc_nm] || '%')" ).append("\n"); 
		query.append("	   #end" ).append("\n"); 
		query.append("	 ORDER BY A.LOC_CD ASC" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}