/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAOSearchAddBsaCarrieHistoryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.16
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2013.09.16 최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI, Duk-Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationMasterDataMgtDBDAOSearchAddBsaCarrieHistoryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAddBsaCarrieHistoryList
	  * </pre>
	  */
	public JointOperationMasterDataMgtDBDAOSearchAddBsaCarrieHistoryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_port",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration").append("\n"); 
		query.append("FileName : JointOperationMasterDataMgtDBDAOSearchAddBsaCarrieHistoryListRSQL").append("\n"); 
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
		query.append("SELECT  VVD_PORT, JO_CRR_CD, JO_CRR_CD," ).append("\n"); 
		query.append("        MAX(DECODE(RN#, 1, JO_ADD_CRR_CD )) JO_ADD_CRR_CD1," ).append("\n"); 
		query.append("        MAX(DECODE(RN#, 2, JO_ADD_CRR_CD )) JO_ADD_CRR_CD2," ).append("\n"); 
		query.append("        MAX(DECODE(RN#, 3, JO_ADD_CRR_CD )) JO_ADD_CRR_CD3," ).append("\n"); 
		query.append("        MAX(DECODE(RN#, 4, JO_ADD_CRR_CD )) JO_ADD_CRR_CD4," ).append("\n"); 
		query.append("        MAX(DECODE(RN#, 5, JO_ADD_CRR_CD )) JO_ADD_CRR_CD5," ).append("\n"); 
		query.append("        MAX(DECODE(RN#, 6, JO_ADD_CRR_CD )) JO_ADD_CRR_CD6," ).append("\n"); 
		query.append("        MAX(DECODE(RN#, 7, JO_ADD_CRR_CD )) JO_ADD_CRR_CD7," ).append("\n"); 
		query.append("        MAX(DECODE(RN#, 8, JO_ADD_CRR_CD )) JO_ADD_CRR_CD8," ).append("\n"); 
		query.append("        MAX(DECODE(RN#, 9, JO_ADD_CRR_CD )) JO_ADD_CRR_CD9," ).append("\n"); 
		query.append("        MAX(DECODE(RN#, 10, JO_ADD_CRR_CD )) JO_ADD_CRR_CD10," ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        MAX(DECODE(RN#, 1, JO_ADD_CRR_CD )) OLD_JO_ADD_CRR_CD1," ).append("\n"); 
		query.append("        MAX(DECODE(RN#, 2, JO_ADD_CRR_CD )) OLD_JO_ADD_CRR_CD2," ).append("\n"); 
		query.append("        MAX(DECODE(RN#, 3, JO_ADD_CRR_CD )) OLD_JO_ADD_CRR_CD3," ).append("\n"); 
		query.append("        MAX(DECODE(RN#, 4, JO_ADD_CRR_CD )) OLD_JO_ADD_CRR_CD4," ).append("\n"); 
		query.append("        MAX(DECODE(RN#, 5, JO_ADD_CRR_CD )) OLD_JO_ADD_CRR_CD5," ).append("\n"); 
		query.append("        MAX(DECODE(RN#, 6, JO_ADD_CRR_CD )) OLD_JO_ADD_CRR_CD6," ).append("\n"); 
		query.append("        MAX(DECODE(RN#, 7, JO_ADD_CRR_CD )) OLD_JO_ADD_CRR_CD7," ).append("\n"); 
		query.append("        MAX(DECODE(RN#, 8, JO_ADD_CRR_CD )) OLD_JOADD__CRR_CD8," ).append("\n"); 
		query.append("        MAX(DECODE(RN#, 9, JO_ADD_CRR_CD )) OLD_JO_ADD_CRR_CD9," ).append("\n"); 
		query.append("        MAX(DECODE(RN#, 10, JO_ADD_CRR_CD )) OLD_JO_ADD_CRR_CD10," ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("        MAX(DECODE(RN#, 1, BSA )) BSA1,     " ).append("\n"); 
		query.append("        MAX(DECODE(RN#, 2, BSA )) BSA2," ).append("\n"); 
		query.append("        MAX(DECODE(RN#, 3, BSA )) BSA3," ).append("\n"); 
		query.append("        MAX(DECODE(RN#, 4, BSA )) BSA4," ).append("\n"); 
		query.append("        MAX(DECODE(RN#, 5, BSA )) BSA5," ).append("\n"); 
		query.append("        MAX(DECODE(RN#, 6, BSA )) BSA6," ).append("\n"); 
		query.append("        MAX(DECODE(RN#, 7, BSA )) BSA7," ).append("\n"); 
		query.append("        MAX(DECODE(RN#, 8, BSA )) BSA8," ).append("\n"); 
		query.append("        MAX(DECODE(RN#, 9, BSA )) BSA9," ).append("\n"); 
		query.append("        MAX(DECODE(RN#, 10, BSA )) BSA10," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        MAX(DECODE(RN#, 1, 1 )) JO_BSA_ADD_REF_SEQ1," ).append("\n"); 
		query.append("        MAX(DECODE(RN#, 2, 2 )) JO_BSA_ADD_REF_SEQ2," ).append("\n"); 
		query.append("        MAX(DECODE(RN#, 3, 3 )) JO_BSA_ADD_REF_SEQ3," ).append("\n"); 
		query.append("        MAX(DECODE(RN#, 4, 4 )) JO_BSA_ADD_REF_SEQ4," ).append("\n"); 
		query.append("        MAX(DECODE(RN#, 5, 5 )) JO_BSA_ADD_REF_SEQ5," ).append("\n"); 
		query.append("        MAX(DECODE(RN#, 6, 6 )) JO_BSA_ADD_REF_SEQ6," ).append("\n"); 
		query.append("        MAX(DECODE(RN#, 7, 7 )) JO_BSA_ADD_REF_SEQ7," ).append("\n"); 
		query.append("        MAX(DECODE(RN#, 8, 8 )) JO_BSA_ADD_REF_SEQ8," ).append("\n"); 
		query.append("        MAX(DECODE(RN#, 9, 9 )) JO_BSA_ADD_REF_SEQ9," ).append("\n"); 
		query.append("        MAX(DECODE(RN#, 10, 10 )) JO_BSA_ADD_REF_SEQ10" ).append("\n"); 
		query.append("    FROM ( " ).append("\n"); 
		query.append("          SELECT A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.PORT_CD||A.PORT_SEQ||A.JO_CRR_CD VVD_PORT,  A.JO_CRR_CD, A.JO_BSA_TEU_QTY BSA, A.JO_ADD_CRR_CD," ).append("\n"); 
		query.append("              ROW_NUMBER() OVER( PARTITION BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.PORT_CD, A.PORT_SEQ, A.JO_CRR_CD ORDER BY A.CRE_DT, A.JO_ADD_CRR_CD ) RN#" ).append("\n"); 
		query.append("          FROM JOO_ADD_BSA_CRR A" ).append("\n"); 
		query.append("          WHERE 1=1" ).append("\n"); 
		query.append("            AND A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.PORT_CD||A.PORT_SEQ||A.JO_CRR_CD =@[vvd_port]" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("    GROUP BY VVD_PORT, JO_CRR_CD" ).append("\n"); 

	}
}