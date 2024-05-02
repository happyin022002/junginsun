/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOSearchCheckGLMonthRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.27
*@LastModifier : DONG- IL, SHIN
*@LastVersion : 1.0
* 2014.06.27 DONG- IL, SHIN
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSRIssueTransferSlipManageDBDAOSearchCheckGLMonthRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * G/L MONTH와 ASA MONTH일치여부 체크
	  * </pre>
	  */
	public CSRIssueTransferSlipManageDBDAOSearchCheckGLMonthRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("AR_OFC_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INV_ISS_DT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INV_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ASA_NO",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.integration").append("\n"); 
		query.append("FileName : CSRIssueTransferSlipManageDBDAOSearchCheckGLMonthRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN TO_CHAR(TO_DATE(TRS_GET_GL_DT_FNC( '', @[AR_OFC_CD], @[INV_ISS_DT], '15'),'YYYYMMDD'),'YYYYMMDD') BETWEEN ASA_PRD_FM_DT AND ASA_PRD_TO_DT THEN 'Y'" ).append("\n"); 
		query.append("             ELSE 'N'" ).append("\n"); 
		query.append("         END GL_CHK_FLG" ).append("\n"); 
		query.append("       ,@[INV_NO] INV_NO" ).append("\n"); 
		query.append("   FROM AR_AGN_STMT_AGMT" ).append("\n"); 
		query.append("  WHERE EXPN_EFF_DT IS NULL" ).append("\n"); 
		query.append("    AND AC_EFF_DT IS NULL" ).append("\n"); 
		query.append("    AND ASA_CLZ_DT	IS NULL" ).append("\n"); 
		query.append("    AND ASA_APRO_DT IS NULL" ).append("\n"); 
		query.append("    AND NVL(DELT_FLG, 'N')	= 'N'" ).append("\n"); 
		query.append("    AND ASA_NO = @[ASA_NO]" ).append("\n"); 
		query.append("    AND ASA_OFC_CD IN ( SELECT AR_OFC_CD" ).append("\n"); 
		query.append("                          FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                         WHERE (SUBSTR(LOC_CD, 1, 2)	= 'CN'  AND OFC_CD = 'BOMBA' )" ).append("\n"); 
		query.append("                            OR  AR_OFC_CD = (SELECT AR_OFC_CD FROM   MDM_ORGANIZATION WHERE  OFC_CD = @[AR_OFC_CD])" ).append("\n"); 
		query.append("                      )" ).append("\n"); 

	}
}