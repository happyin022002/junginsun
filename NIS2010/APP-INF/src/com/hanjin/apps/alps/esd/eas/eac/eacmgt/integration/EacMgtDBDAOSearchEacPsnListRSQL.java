/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EacMgtDBDAOSearchEacPsnListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.07
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2015.08.07 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CJH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EacMgtDBDAOSearchEacPsnListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Personnel Config Inquiry 를 조회한다
	  * </pre>
	  */
	public EacMgtDBDAOSearchEacPsnListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_rhq_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration").append("\n"); 
		query.append("FileName : EacMgtDBDAOSearchEacPsnListRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN B.OFC_CD = 'SELADG' THEN B.OFC_CD" ).append("\n"); 
		query.append("            ELSE TRS_COMMON_PKG.TRS_GET_RHQ_OFC_CD(B.OFC_CD)" ).append("\n"); 
		query.append("       END AS RHQ_OFC_CD" ).append("\n"); 
		query.append("     , B.OFC_CD" ).append("\n"); 
		query.append("     , A.KPI_OFC_CD" ).append("\n"); 
		query.append("     , A.EAC_USR_ID" ).append("\n"); 
		query.append("     , A.EAC_USR_NM" ).append("\n"); 
		query.append("     , A.EAC_USR_NM ||'('|| A.EAC_USR_ID||')' AS EAC_USR_CODE" ).append("\n"); 
		query.append("     , A.EXPN_AUD_SCP_DESC " ).append("\n"); 
		query.append("     , A.PHN_NO            " ).append("\n"); 
		query.append("     , A.FAX_NO            " ).append("\n"); 
		query.append("     , A.USR_EML           " ).append("\n"); 
		query.append("     , A.DELT_FLG          " ).append("\n"); 
		query.append("     , A.NTC_CC_RCV_EML    " ).append("\n"); 
		query.append("     , A.EML_SUBJ_CTNT     " ).append("\n"); 
		query.append("     , A.EML_CTNT" ).append("\n"); 
		query.append("     , A.UPD_USR_ID        " ).append("\n"); 
		query.append("     , TO_CHAR(A.UPD_DT,'YYYY-MM-DD') AS CRE_DT" ).append("\n"); 
		query.append("FROM   EAS_EXPN_AUD_CS_PSON_CFG A" ).append("\n"); 
		query.append("     , COM_USER B" ).append("\n"); 
		query.append("WHERE  A.EAC_USR_ID = B.USR_ID" ).append("\n"); 
		query.append("#if (${s_rhq_ofc_cd} != '') " ).append("\n"); 
		query.append("   #if(${s_rhq_ofc_cd} == 'SELADG')" ).append("\n"); 
		query.append("      AND B.OFC_CD = @[s_rhq_ofc_cd]" ).append("\n"); 
		query.append("   #else" ).append("\n"); 
		query.append("      AND TRS_COMMON_PKG.TRS_GET_RHQ_OFC_CD(B.OFC_CD) = @[s_rhq_ofc_cd] -- RHQ" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_ofc_cd} != '') " ).append("\n"); 
		query.append("AND    B.OFC_CD = @[s_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}