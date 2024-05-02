/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AgentCanalTransitFeeBCDBDAOsearchCanalTzBkgVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.25
*@LastModifier : 윤권영
*@LastVersion : 1.0
* 2016.07.25 윤권영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yun Kwon-Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgentCanalTransitFeeBCDBDAOsearchCanalTzBkgVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCanalTzBkgVvd
	  * </pre>
	  */
	public AgentCanalTransitFeeBCDBDAOsearchCanalTzBkgVvdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_page",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("str_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pagerows",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.integration").append("\n"); 
		query.append("FileName : AgentCanalTransitFeeBCDBDAOsearchCanalTzBkgVvdRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  T1.PSO_BZTP_CD" ).append("\n"); 
		query.append("       ,T1.VSL_CD" ).append("\n"); 
		query.append("       ,(SELECT VSL_ENG_NM FROM MDM_VSL_CNTR X WHERE X.VSL_CD = T1.VSL_CD) VSL_NM" ).append("\n"); 
		query.append("       ,T1.SKD_VOY_NO" ).append("\n"); 
		query.append("       ,T1.SKD_DIR_CD" ).append("\n"); 
		query.append("       ,(T1.VSL_CD||T1.SKD_VOY_NO||T1.SKD_DIR_CD) VVD" ).append("\n"); 
		query.append("       ,T5.VSL_SLAN_CD" ).append("\n"); 
		query.append("       ,TO_CHAR(T4.VPS_ETA_DT,'YYYY-MM-DD HH24:MI') VPS_ETA_DT" ).append("\n"); 
		query.append("       ,TO_CHAR(T4.VPS_ETB_DT,'YYYY-MM-DD HH24:MI') VPS_ETB_DT" ).append("\n"); 
		query.append("       ,TO_CHAR(T4.VPS_ETD_DT,'YYYY-MM-DD HH24:MI') VPS_ETD_DT" ).append("\n"); 
		query.append("       ,DECODE(T1.CNL_TZ_BKG_STS_CD,'B',1,0) B_STS_CD" ).append("\n"); 
		query.append("       ,DECODE(T1.CNL_TZ_BKG_STS_CD,'C',1,0) C_STS_CD" ).append("\n"); 
		query.append("       ,DECODE(T1.CNL_TZ_BKG_STS_CD,'A',1,0) A_STS_CD" ).append("\n"); 
		query.append("       ,@[vndr_seq] VNDR_SEQ" ).append("\n"); 
		query.append("       ,@[str_dt] STR_DT" ).append("\n"); 
		query.append("       ,@[end_dt] END_DT" ).append("\n"); 
		query.append("       ,@[i_page] I_PAGE  --현재 페이지 번호" ).append("\n"); 
		query.append("       ,ROWNUM RN" ).append("\n"); 
		query.append("  FROM PSO_TGT_VVD T1," ).append("\n"); 
		query.append("       VSK_VSL_SKD T3," ).append("\n"); 
		query.append("       VSK_VSL_PORT_SKD T4," ).append("\n"); 
		query.append("       VSK_CNL_VNDR T5" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND T1.PSO_BZTP_CD      = 6" ).append("\n"); 
		query.append("   AND T1.VSL_CD           = T3.VSL_CD" ).append("\n"); 
		query.append("   AND T1.SKD_VOY_NO       = T3.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND T1.SKD_DIR_CD       = T3.SKD_DIR_CD  " ).append("\n"); 
		query.append("   AND T1.BUD_SCNR_NO 	   = '999912'" ).append("\n"); 
		query.append("   AND T3.VSL_CD           = T4.VSL_CD" ).append("\n"); 
		query.append("   AND T3.SKD_VOY_NO       = T4.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND T3.SKD_DIR_CD       = T4.SKD_DIR_CD  " ).append("\n"); 
		query.append("   AND T3.VSL_SLAN_CD      = T5.VSL_SLAN_CD" ).append("\n"); 
		query.append("   AND T5.CNL_AGN_VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("   AND T4.VPS_ETB_DT >= (TO_DATE(REPLACE(@[str_dt],'-',''),'YYYYMMDD')) AND T4.VPS_ETB_DT < TO_DATE(REPLACE(@[end_dt],'-',''),'YYYYMMDD')+1" ).append("\n"); 
		query.append("   AND T4.VPS_PORT_CD = 'PAPAC'" ).append("\n"); 
		query.append(" ORDER BY T4.VPS_ETB_DT ASC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       ) X" ).append("\n"); 
		query.append(" WHERE RN BETWEEN (@[pagerows]*(@[i_page]-1)+1) AND (@[pagerows]*@[i_page])  --pagerows:명시적이지 않은 숨은 매개변수:페이지당레코드수" ).append("\n"); 

	}
}