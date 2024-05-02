/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOSearchSlipApprovalOfficeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOConsultationDBDAOSearchSlipApprovalOfficeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Slip Approval 승인 시에 Office 및 User 테이블에서 필요 항목 조회한다
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOSearchSlipApprovalOfficeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration").append("\n"); 
		query.append("FileName : TCharterIOConsultationDBDAOSearchSlipApprovalOfficeRSQL").append("\n"); 
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
		query.append("SELECT A.FINC_RGN_CD" ).append("\n"); 
		query.append("     , A.AP_CTR_CD" ).append("\n"); 
		query.append("     , A.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("     , A.AR_OFC_CD" ).append("\n"); 
		query.append("     , A.AR_CURR_CD" ).append("\n"); 
		query.append("     , B.USR_NM" ).append("\n"); 
		query.append("     , A.OFC_CD" ).append("\n"); 
		query.append("     , B.USR_EML" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT A.FINC_RGN_CD" ).append("\n"); 
		query.append("         , A.AP_CTR_CD" ).append("\n"); 
		query.append("         , A.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("         , A.AR_OFC_CD" ).append("\n"); 
		query.append("         , A.AP_OFC_CD AS OFC_CD" ).append("\n"); 
		query.append("         , A.AR_CURR_CD" ).append("\n"); 
		query.append("      FROM MDM_ORGANIZATION A " ).append("\n"); 
		query.append("     WHERE OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("    SELECT U.USR_NM" ).append("\n"); 
		query.append("         , U.USR_EML " ).append("\n"); 
		query.append("      FROM COM_USER U" ).append("\n"); 
		query.append("     WHERE USR_ID = @[usr_id]" ).append("\n"); 
		query.append(") B" ).append("\n"); 

	}
}