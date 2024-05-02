/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PsoAdvanceAuditDBDAOupdateBatchStatusUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.25
*@LastModifier : Arie
*@LastVersion : 1.0
* 2016.03.25 Arie
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.psoadvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Arie
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PsoAdvanceAuditDBDAOupdateBatchStatusUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * * 2016.03.25 CHM-201640191 Split02-Auto Audit - Invoice Batch 개발 요청
	  * </pre>
	  */
	public PsoAdvanceAuditDBDAOupdateBatchStatusUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.psoadvanceaudit.integration").append("\n"); 
		query.append("FileName : PsoAdvanceAuditDBDAOupdateBatchStatusUSQL").append("\n"); 
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
		query.append("UPDATE EAS_AUTO_AUD_BAT" ).append("\n"); 
		query.append("   SET BAT_PROG_STS_CD = 'B'" ).append("\n"); 
		query.append("      ,UPD_USR_ID = 'BATCH'" ).append("\n"); 
		query.append("      ,UPD_DT     = SYSDATE" ).append("\n"); 
		query.append(" WHERE ISS_CTY_CD        = @[iss_cty_cd]" ).append("\n"); 
		query.append("   AND SO_SEQ            = @[so_seq]" ).append("\n"); 
		query.append("   AND SO_DTL_SEQ        = @[so_dtl_seq]" ).append("\n"); 
		query.append("--------------------------------------------" ).append("\n"); 
		query.append("   AND SUB_SYS_CD      = 'PSO'" ).append("\n"); 
		query.append("   AND BAT_PROG_STS_CD = 'P'" ).append("\n"); 

	}
}