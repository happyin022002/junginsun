/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OwnDangerousCargoApprovalDBDAOSearchScgRequestApvlTimeInputVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.28
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2010.04.28 김현욱
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Hyun Uk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnDangerousCargoApprovalDBDAOSearchScgRequestApvlTimeInputVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 일정기간 동안 Request 된 Special Cargo 승인요청에 대한 처리 시간을 조회한다.
	  * </pre>
	  */
	public OwnDangerousCargoApprovalDBDAOSearchScgRequestApvlTimeInputVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : OwnDangerousCargoApprovalDBDAOSearchScgRequestApvlTimeInputVORSQL").append("\n"); 
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
		query.append("SELECT '' TERM" ).append("\n"); 
		query.append(", '' FROM_RQST_DT" ).append("\n"); 
		query.append(", '' TO_RQST_DT" ).append("\n"); 
		query.append(", '' RGN_SHP_OPR_CD" ).append("\n"); 
		query.append(", '' CRR_CD" ).append("\n"); 
		query.append(", '' SLAN_CD" ).append("\n"); 
		query.append(", '' VSL_CD" ).append("\n"); 
		query.append(", '' SKD_VOY_NO" ).append("\n"); 
		query.append(", '' SKD_DIR_CD" ).append("\n"); 
		query.append(", '' SCG_FLG" ).append("\n"); 
		query.append(", '' OPTION_PENDING" ).append("\n"); 
		query.append(", '' PROC_HOUR" ).append("\n"); 
		query.append(", '' OPTION_POST_VVD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}