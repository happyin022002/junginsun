/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AGNCommApprovalDBDAOModifyAcmCommBkgInfoRevVVDUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommApprovalDBDAOModifyAcmCommBkgInfoRevVVDUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * REV VVD 를 수정한다.
	  * </pre>
	  */
	public AGNCommApprovalDBDAOModifyAcmCommBkgInfoRevVVDUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.integration").append("\n"); 
		query.append("FileName : AGNCommApprovalDBDAOModifyAcmCommBkgInfoRevVVDUSQL").append("\n"); 
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
		query.append("UPDATE /*+ bypass_ujvc */" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("  SELECT I.RLANE_CD ACM_RLANE_CD," ).append("\n"); 
		query.append("    I.REV_VVD_CD ACM_REV_VVD_CD," ).append("\n"); 
		query.append("    C.RLANE_CD COA_RLANE_CD," ).append("\n"); 
		query.append("    C.VSL_CD || C.SKD_VOY_NO || C.FINC_DIR_CD COA_REV_VVD_CD" ).append("\n"); 
		query.append("  FROM ACM_AGN_BKG_INFO I," ).append("\n"); 
		query.append("    MAS_RGST_BKG C" ).append("\n"); 
		query.append("  WHERE I.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("    AND I.REV_VVD_CD <> C.VSL_CD || C.SKD_VOY_NO || C.FINC_DIR_CD" ).append("\n"); 
		query.append("    AND I.BKG_NO IN (SELECT BKG_NO" ).append("\n"); 
		query.append("                     FROM ACM_AGN_COMM" ).append("\n"); 
		query.append("                     WHERE AC_STS_CD = 'AS'" ).append("\n"); 
		query.append("                       AND AUD_NO IN (${aud_no})" ).append("\n"); 
		query.append("                     GROUP BY BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                     UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                     SELECT OTR_COMM_NO AS BKG_NO" ).append("\n"); 
		query.append("                     FROM ACM_AGN_OTR_COMM" ).append("\n"); 
		query.append("                     WHERE AC_STS_CD = 'AS'" ).append("\n"); 
		query.append("                       AND AUD_NO IN (${aud_no})" ).append("\n"); 
		query.append("                     GROUP BY OTR_COMM_NO" ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SET ACM_RLANE_CD = COA_RLANE_CD," ).append("\n"); 
		query.append("  ACM_REV_VVD_CD = COA_REV_VVD_CD" ).append("\n"); 

	}
}