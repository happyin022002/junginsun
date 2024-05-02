/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMSetupDBDAOGetDupDataFromAcmOfcInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.31
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.05.31 김봉균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM BONG-GYOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMSetupDBDAOGetDupDataFromAcmOfcInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public ACMSetupDBDAOGetDupDataFromAcmOfcInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_tmp_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.integration").append("\n"); 
		query.append("FileName : ACMSetupDBDAOGetDupDataFromAcmOfcInfoRSQL").append("\n"); 
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
		query.append("SELECT ERR_OFC_INFO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT 'C'||OFC_GRP_ID AS ERR_OFC_INFO" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT AGN_INFO_SEQ, OFC_GRP_ID" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("            SELECT" ).append("\n"); 
		query.append("             AGN_INFO_SEQ" ).append("\n"); 
		query.append("            ,AGN_FM_DT" ).append("\n"); 
		query.append("            ,AGN_TO_DT" ).append("\n"); 
		query.append("            ,AGN_CD" ).append("\n"); 
		query.append("            ,OFC_GRP_ID" ).append("\n"); 
		query.append("            ,LEAD(AGN_FM_DT,1)    OVER (PARTITION BY OFC_GRP_ID ORDER BY OFC_GRP_ID, AGN_FM_DT, AGN_TO_DT  ) NXT_AGN_FM_DT" ).append("\n"); 
		query.append("            ,LEAD(AGN_TO_DT,1)    OVER (PARTITION BY OFC_GRP_ID ORDER BY OFC_GRP_ID, AGN_FM_DT, AGN_TO_DT  ) NXT_AGN_TO_DT" ).append("\n"); 
		query.append("            ,LEAD(OFC_GRP_ID,1)   OVER (PARTITION BY OFC_GRP_ID ORDER BY OFC_GRP_ID, AGN_FM_DT, AGN_TO_DT  ) NXT_OFC_GRP_ID" ).append("\n"); 
		query.append("            FROM ACM_OFC_INFO_TMP" ).append("\n"); 
		query.append("            WHERE OFC_TMP_NO = @[ofc_tmp_no]" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("        WHERE NXT_OFC_GRP_ID IS NOT NULL" ).append("\n"); 
		query.append("        AND ( AGN_TO_DT < AGN_FM_DT OR AGN_TO_DT >= NXT_AGN_FM_DT )" ).append("\n"); 
		query.append("        ORDER BY AGN_INFO_SEQ" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    UNION  " ).append("\n"); 
		query.append("    SELECT 'B'||AGN_CD AS ERR_OFC_INFO" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT AGN_INFO_SEQ, AGN_CD" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("            SELECT" ).append("\n"); 
		query.append("             AGN_INFO_SEQ" ).append("\n"); 
		query.append("            ,AGN_FM_DT_CD" ).append("\n"); 
		query.append("            ,AGN_TO_DT_CD" ).append("\n"); 
		query.append("            ,AGN_CD" ).append("\n"); 
		query.append("            ,OFC_GRP_ID" ).append("\n"); 
		query.append("            ,LEAD(AGN_FM_DT_CD,1) OVER (PARTITION BY AGN_CD ORDER BY AGN_CD, AGN_FM_DT, AGN_TO_DT  ) NXT_AGN_FM_DT_CD" ).append("\n"); 
		query.append("            ,LEAD(AGN_TO_DT_CD,1) OVER (PARTITION BY AGN_CD ORDER BY AGN_CD, AGN_FM_DT, AGN_TO_DT  ) NXT_AGN_TO_DT_CD" ).append("\n"); 
		query.append("            ,LEAD(AGN_CD,1)       OVER (PARTITION BY AGN_CD ORDER BY AGN_CD, AGN_FM_DT, AGN_TO_DT  ) NXT_AGN_CD" ).append("\n"); 
		query.append("            FROM ACM_OFC_INFO_TMP" ).append("\n"); 
		query.append("            WHERE OFC_TMP_NO = @[ofc_tmp_no]" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("        WHERE NXT_AGN_CD IS NOT NULL" ).append("\n"); 
		query.append("        AND AGN_TO_DT_CD <> NXT_AGN_FM_DT_CD" ).append("\n"); 
		query.append("        ORDER BY AGN_INFO_SEQ" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    UNION  " ).append("\n"); 
		query.append("    SELECT 'A'||AGN_CD AS ERR_OFC_INFO" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT AGN_INFO_SEQ, AGN_CD" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("            SELECT" ).append("\n"); 
		query.append("             AGN_INFO_SEQ" ).append("\n"); 
		query.append("            ,AGN_CD" ).append("\n"); 
		query.append("            ,OFC_GRP_ID" ).append("\n"); 
		query.append("            ,LEAD(OFC_GRP_ID,1)   OVER (PARTITION BY AGN_CD ORDER BY AGN_CD, OFC_GRP_ID  ) NXT_OFC_GRP_ID" ).append("\n"); 
		query.append("            FROM ACM_OFC_INFO_TMP" ).append("\n"); 
		query.append("            WHERE OFC_TMP_NO = @[ofc_tmp_no]" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("        WHERE NXT_OFC_GRP_ID IS NOT NULL" ).append("\n"); 
		query.append("        AND OFC_GRP_ID <> NXT_OFC_GRP_ID" ).append("\n"); 
		query.append("        ORDER BY AGN_INFO_SEQ" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("	ORDER BY ERR_OFC_INFO" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("where rownum = 1" ).append("\n"); 

	}
}