/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ApprovalDBDAOApprovalReqHdrUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.29
*@LastModifier : DONG- IL, SHIN
*@LastVersion : 1.0
* 2014.07.29 DONG- IL, SHIN
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.approval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ApprovalDBDAOApprovalReqHdrUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COM_APRO_RQST_HDR 결제정보를 수정한다
	  * </pre>
	  */
	public ApprovalDBDAOApprovalReqHdrUSQL(){
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
		params.put("usr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.approval.integration").append("\n"); 
		query.append("FileName : ApprovalDBDAOApprovalReqHdrUSQL").append("\n"); 
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
		query.append("UPDATE COM_APRO_RQST_HDR    " ).append("\n"); 
		query.append("  SET  RQST_USR_ID  =  @[usr_id]	   " ).append("\n"); 
		query.append("	 , RQST_USR_NM  =  @[usr_nm]	   " ).append("\n"); 
		query.append("	 , RQST_OFC_CD  =  @[ofc_cd]    " ).append("\n"); 
		query.append("	 , UPD_USR_ID   =  @[usr_id]" ).append("\n"); 
		query.append("	 , APSTS_CD      = 'P'" ).append("\n"); 
		query.append("     , CRNT_APRO_SEQ = ( SELECT NVL(MAX(APRO_RQST_SEQ)+1,1)  APRO_RQST_SEQ  " ).append("\n"); 
		query.append("  						   FROM COM_APRO_RQST_ROUT A" ).append("\n"); 
		query.append(" 						  WHERE A.APRO_RQST_NO = @[apro_rqst_no]" ).append("\n"); 
		query.append("  							AND A.APSTS_CD IS NOT NULL )" ).append("\n"); 
		query.append("     , RQST_END_DT   = null" ).append("\n"); 
		query.append("	 , UPD_DT       =  SYSDATE    " ).append("\n"); 
		query.append(" WHERE APRO_RQST_NO =  @[apro_rqst_no]" ).append("\n"); 

	}
}