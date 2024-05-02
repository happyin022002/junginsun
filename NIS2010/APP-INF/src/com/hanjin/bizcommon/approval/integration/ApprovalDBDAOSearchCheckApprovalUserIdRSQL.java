/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ApprovalDBDAOSearchCheckApprovalUserIdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.12
*@LastModifier : DONG- IL, SHIN
*@LastVersion : 1.0
* 2014.08.12 DONG- IL, SHIN
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.approval.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ApprovalDBDAOSearchCheckApprovalUserIdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * LOGIN USER의 USER ID조회(EP ID가 존재할 경우 EP ID 우선 조회)
	  * COM_ENS_0T1의  DEL 버튼 클릭시 자기 자신의 결재라인 못 지우도록 하기 위함.
	  * </pre>
	  */
	public ApprovalDBDAOSearchCheckApprovalUserIdRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.approval.integration ").append("\n"); 
		query.append("FileName : ApprovalDBDAOSearchCheckApprovalUserIdRSQL").append("\n"); 
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
		query.append("	SELECT NVL(A.EP_ID,A.USR_ID) EP_ID" ).append("\n"); 
		query.append("	  FROM COM_USER A" ).append("\n"); 
		query.append("	 WHERE 1=1" ).append("\n"); 
		query.append("	   AND (A.USR_ID = @[usr_id] OR A.EP_ID = @[usr_id])" ).append("\n"); 
		query.append("	   AND NVL(A.USE_FLG,'N') = 'Y'" ).append("\n"); 

	}
}