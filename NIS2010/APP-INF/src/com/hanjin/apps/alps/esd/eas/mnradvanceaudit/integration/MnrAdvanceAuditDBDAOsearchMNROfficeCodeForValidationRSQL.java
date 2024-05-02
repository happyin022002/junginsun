/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MnrAdvanceAuditDBDAOsearchMNROfficeCodeForValidationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.mnradvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MnrAdvanceAuditDBDAOsearchMNROfficeCodeForValidationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 사용자가 입력한 OFFICE CODE가 실제 존재하는지 여부를 파악하는 쿼리
	  * </pre>
	  */
	public MnrAdvanceAuditDBDAOsearchMNROfficeCodeForValidationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.mnradvanceaudit.integration").append("\n"); 
		query.append("FileName : MnrAdvanceAuditDBDAOsearchMNROfficeCodeForValidationRSQL").append("\n"); 
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
		query.append("SELECT A.OFC_CD," ).append("\n"); 
		query.append("       EAS_0363," ).append("\n"); 
		query.append("       EAS_0362," ).append("\n"); 
		query.append("	   DECODE(MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(A.OFC_CD),A.OFC_CD,'Y','N') RHQ_OFC_CD" ).append("\n"); 
		query.append("  FROM MDM_ORGANIZATION A," ).append("\n"); 
		query.append("  (SELECT DISTINCT AUD_OFC_CD OFC_CD," ).append("\n"); 
		query.append("       'Y' EAS_0363" ).append("\n"); 
		query.append("  FROM EAS_MNR_PRE_AUD_RTO_CFG) B," ).append("\n"); 
		query.append("  (SELECT DISTINCT AUD_OFC_CD OFC_CD," ).append("\n"); 
		query.append("       'Y' EAS_0362" ).append("\n"); 
		query.append("  FROM EAS_MNR_PRE_AUD_VRFY_CFG) C" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND A.OFC_CD = @[i_ofc_cd]" ).append("\n"); 
		query.append("   AND A.OFC_CD = B.OFC_CD (+)" ).append("\n"); 
		query.append("   AND A.OFC_CD = C.OFC_CD (+)" ).append("\n"); 

	}
}