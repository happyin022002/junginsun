/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ApprovalDBDAOModifyConfirmRqstRestOfRoutUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.23
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.approval.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ApprovalDBDAOModifyConfirmRqstRestOfRoutUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 후결처리 이후 모든 결재자(Route) 완료 처리
	  * </pre>
	  */
	public ApprovalDBDAOModifyConfirmRqstRestOfRoutUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.approval.integration ").append("\n"); 
		query.append("FileName : ApprovalDBDAOModifyConfirmRqstRestOfRoutUSQL").append("\n"); 
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
		query.append("--후결처리 이후 모든 결재자(Route) 완료 처리" ).append("\n"); 
		query.append("UPDATE COM_APRO_RQST_ROUT A 	" ).append("\n"); 
		query.append("   SET APRO_DT  = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC((SELECT RQST_OFC_CD FROM COM_APRO_RQST_HDR WHERE APRO_RQST_NO=A.APRO_RQST_NO AND ROWNUM=1))" ).append("\n"); 
		query.append("     , APSTS_CD = 'C'" ).append("\n"); 
		query.append("     , APRO_RMK = 'Urgent Payment'  		   " ).append("\n"); 
		query.append(" WHERE APRO_RQST_NO  = @[apro_rqst_no]" ).append("\n"); 
		query.append("   AND APRO_RQST_SEQ > @[apro_rqst_seq]" ).append("\n"); 

	}
}