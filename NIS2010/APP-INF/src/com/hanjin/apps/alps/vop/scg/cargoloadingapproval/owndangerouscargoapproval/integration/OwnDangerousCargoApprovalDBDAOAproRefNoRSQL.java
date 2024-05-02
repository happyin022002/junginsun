/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : OwnDangerousCargoApprovalDBDAOAproRefNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnDangerousCargoApprovalDBDAOAproRefNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AproRefNo를 생성하는 화면
	  * </pre>
	  */
	public OwnDangerousCargoApprovalDBDAOAproRefNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : OwnDangerousCargoApprovalDBDAOAproRefNoRSQL").append("\n"); 
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
		query.append("SELECT  DECODE(COUNT(A.BKG_NO), ( " ).append("\n"); 
		query.append("            SELECT COUNT(BKG_NO) FROM BKG_DG_CGO WHERE BKG_NO = A.BKG_NO ), (" ).append("\n"); 
		query.append("                SELECT  'SML'||'POL'||TO_CHAR(SYSDATE, 'YYMMDD')||" ).append("\n"); 
		query.append("                        DECODE(NVL(LENGTH(MAX(SUBSTR(APRO_REF_NO,13,15))+1),0)," ).append("\n"); 
		query.append("                	        0, '001'," ).append("\n"); 
		query.append("                            1, '00'||TO_CHAR(MAX(SUBSTR(APRO_REF_NO,13,15))+1)," ).append("\n"); 
		query.append("                        	2, '0'||TO_CHAR(MAX(SUBSTR(APRO_REF_NO,13,15))+1)," ).append("\n"); 
		query.append("                            3, TO_CHAR(MAX(SUBSTR(APRO_REF_NO,13,15))+1) " ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                FROM SCG_AUTHORIZATION" ).append("\n"); 
		query.append("                WHERE SUBSTR(APRO_REF_NO,1,12) = 'SML'||'POL'||TO_CHAR(SYSDATE, 'yymmdd')" ).append("\n"); 
		query.append("                ), ''" ).append("\n"); 
		query.append("        ) AS APRO_REF_NO " ).append("\n"); 
		query.append("FROM SCG_AUTHORIZATION A, SCG_VVD_APRO_RQST B" ).append("\n"); 
		query.append("WHERE A.BKG_NO = B.BKG_NO " ).append("\n"); 
		query.append("AND A.SPCL_CGO_APRO_RQST_SEQ = B.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("AND A.VSL_PRE_PST_CD = B.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("AND A.VSL_SEQ = B.VSL_SEQ" ).append("\n"); 
		query.append("AND A.BKG_NO = 'VLCZ1140042'" ).append("\n"); 
		query.append("AND A.SPCL_CGO_APRO_RQST_SEQ = '1'" ).append("\n"); 
		query.append("AND A.SPCL_CGO_AUTH_CD = 'Y'" ).append("\n"); 
		query.append("GROUP BY A.BKG_NO" ).append("\n"); 

	}
}