/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ApprovalDBDAOSearchCheckApprovedStepRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.28
*@LastModifier : DONG- IL, SHIN
*@LastVersion : 1.0
* 2014.07.28 DONG- IL, SHIN
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

public class ApprovalDBDAOSearchCheckApprovedStepRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Edit Approval Step화면에서 Del버튼 클릭시 결재 유무 체크
	  * </pre>
	  */
	public ApprovalDBDAOSearchCheckApprovedStepRSQL(){
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
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.approval.integration").append("\n"); 
		query.append("FileName : ApprovalDBDAOSearchCheckApprovedStepRSQL").append("\n"); 
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
		query.append("SELECT DECODE(A.APSTS_CD,'','Y','N') AS APRO_FLG" ).append("\n"); 
		query.append("  FROM COM_APRO_RQST_ROUT A" ).append("\n"); 
		query.append(" WHERE A.APRO_RQST_NO = ( SELECT APRO_RQST_NO" ).append("\n"); 
		query.append("                            FROM COM_APRO_CSR_DTL" ).append("\n"); 
		query.append("                           WHERE CSR_NO = @[csr_no])" ).append("\n"); 
		query.append("   AND A.APRO_RQST_SEQ = @[apro_rqst_seq]" ).append("\n"); 

	}
}