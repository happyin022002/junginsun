/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralCodeSearchMgtDBDAOsearchRhqOfcCdDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeSearchMgtDBDAOsearchRhqOfcCdDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchRhqOfcCdData
	  * </pre>
	  */
	public GeneralCodeSearchMgtDBDAOsearchRhqOfcCdDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeSearchMgtDBDAOsearchRhqOfcCdDataRSQL").append("\n"); 
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
		query.append("SELECT B.OFC_CD AS CD_ID, B.OFC_ENG_NM AS CD_DESC" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT DISTINCT AR_HD_QTR_OFC_CD AS HQ_OFC" ).append("\n"); 
		query.append("          FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("		#if(${searchcon} == 'TRUESELHOFALSE')" ).append("\n"); 
		query.append("		  WHERE AR_HD_QTR_OFC_CD <> 'SELHO'" ).append("\n"); 
		query.append("		 UNION ALL" ).append("\n"); 
		query.append("        SELECT MNR_CD_ID AS HQ_OFC" ).append("\n"); 
		query.append("          FROM MNR_GEN_CD" ).append("\n"); 
		query.append("         WHERE PRNT_CD_ID = 'HOOFC'" ).append("\n"); 
		query.append("           AND ROWNUM = 1   " ).append("\n"); 
		query.append("	    #elseif (${searchcon} == 'ALLFALSE') " ).append("\n"); 
		query.append("		  WHERE AR_HD_QTR_OFC_CD <> 'SELHO'" ).append("\n"); 
		query.append("        #elseif (${searchcon} == 'TRUE')" ).append("\n"); 
		query.append("        UNION ALL " ).append("\n"); 
		query.append("        SELECT MNR_CD_ID AS HQ_OFC" ).append("\n"); 
		query.append("          FROM MNR_GEN_CD" ).append("\n"); 
		query.append("         WHERE PRNT_CD_ID = 'HOOFC'" ).append("\n"); 
		query.append("           AND ROWNUM = 1" ).append("\n"); 
		query.append("        #elseif (${searchcon} == 'ASIA')" ).append("\n"); 
		query.append("          WHERE AR_HD_QTR_OFC_CD IN ('SHARC','SINRS','SELIB','TYOIB')" ).append("\n"); 
		query.append("        #end      " ).append("\n"); 
		query.append("       ) A , MDM_ORGANIZATION B" ).append("\n"); 
		query.append(" WHERE B.OFC_CD = A.HQ_OFC" ).append("\n"); 
		query.append("   AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if(${rhqplus} == 'onsiteinspection')" ).append("\n"); 
		query.append("   AND B.OFC_CD NOT IN ('SELIB','SELHO', 'VVOIA')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT B.OFC_CD||'(SELSC)' AS CD_ID," ).append("\n"); 
		query.append("       B.OFC_ENG_NM||'(KOREA BRANCH OFFICE)' AS CD_DESC" ).append("\n"); 
		query.append("  FROM MDM_ORGANIZATION B" ).append("\n"); 
		query.append(" WHERE B.OFC_CD = 'SELIB'" ).append("\n"); 
		query.append("   AND B.DELT_FLG != 'Y'" ).append("\n"); 
		query.append(" ORDER BY CD_ID " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(" ORDER BY B.OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}