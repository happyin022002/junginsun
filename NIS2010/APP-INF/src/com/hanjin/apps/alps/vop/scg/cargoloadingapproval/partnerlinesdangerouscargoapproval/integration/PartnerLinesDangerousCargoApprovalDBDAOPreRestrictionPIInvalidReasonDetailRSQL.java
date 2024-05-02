/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionPIInvalidReasonDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.14
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2013.06.14 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ISD1
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionPIInvalidReasonDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PreRestrictionPIInvalidReasonDetail
	  * </pre>
	  */
	public PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionPIInvalidReasonDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionPIInvalidReasonDetailRSQL").append("\n"); 
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
		query.append("WITH VLD_CHK_TBL AS (" ).append("\n"); 
		query.append("#if ($vld_chk.size() > 0)" ).append("\n"); 
		query.append("	#foreach($key IN ${vld_chk})" ).append("\n"); 
		query.append("		#if($velocityCount < $vld_chk.size()) " ).append("\n"); 
		query.append("     SELECT DECODE(INSTR('$key','|',1,1),0, '$key' , SUBSTR('$key',1, INSTR('$key','|',1,1)-1)) AS VLD_CHK," ).append("\n"); 
		query.append("            DECODE(INSTR('$key','|',1,1),0, '' , SUBSTR('$key',INSTR('$key','|',1,1)+1,INSTR('$key','|',1,2)- INSTR('$key','|',1,1)-1 )) AS STR1, " ).append("\n"); 
		query.append("            DECODE(INSTR('$key','|',1,1),0, '' , DECODE( INSTR('$key','|',1,2),0, '' , SUBSTR('$key',INSTR('$key','|',1,2)+1,INSTR('$key','|',1,3)- INSTR('$key','|',1,2)-1 ))) AS STR2" ).append("\n"); 
		query.append("       FROM DUAL" ).append("\n"); 
		query.append("      UNION ALL" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("     SELECT DECODE(INSTR('$key','|',1,1),0, '$key' , SUBSTR('$key',1, INSTR('$key','|',1,1)-1)) AS VLD_CHK," ).append("\n"); 
		query.append("            DECODE(INSTR('$key','|',1,1),0, '' , SUBSTR('$key',INSTR('$key','|',1,1)+1,INSTR('$key','|',1,2)- INSTR('$key','|',1,1)-1 )) AS STR1, " ).append("\n"); 
		query.append("            DECODE(INSTR('$key','|',1,1),0, '' , DECODE( INSTR('$key','|',1,2),0, '' , SUBSTR('$key',INSTR('$key','|',1,2)+1,INSTR('$key','|',1,3)- INSTR('$key','|',1,2)-1 ))) AS STR2" ).append("\n"); 
		query.append("       FROM DUAL" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",INVLD_MSG_TBL AS (" ).append("\n"); 
		query.append("SELECT 'PSI' VLD_CHK" ).append("\n"); 
		query.append("      ,ERR_MSG MSG" ).append("\n"); 
		query.append("  FROM COM_ERR_MSG" ).append("\n"); 
		query.append(" WHERE ERR_MSG_CD = 'SCG60048'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'WSI' VLD_CHK" ).append("\n"); 
		query.append("      ,ERR_MSG MSG" ).append("\n"); 
		query.append("  FROM COM_ERR_MSG" ).append("\n"); 
		query.append(" WHERE ERR_MSG_CD = 'SCG60049'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'PMI' VLD_CHK" ).append("\n"); 
		query.append("      ,ERR_MSG MSG" ).append("\n"); 
		query.append("  FROM COM_ERR_MSG" ).append("\n"); 
		query.append(" WHERE ERR_MSG_CD = 'SCG60050'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'PII' VLD_CHK" ).append("\n"); 
		query.append("      ,ERR_MSG MSG" ).append("\n"); 
		query.append("  FROM COM_ERR_MSG" ).append("\n"); 
		query.append(" WHERE ERR_MSG_CD = 'SCG60051'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'WII' VLD_CHK" ).append("\n"); 
		query.append("      ,ERR_MSG MSG" ).append("\n"); 
		query.append("  FROM COM_ERR_MSG" ).append("\n"); 
		query.append(" WHERE ERR_MSG_CD = 'SCG60052'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'POI' VLD_CHK" ).append("\n"); 
		query.append("      ,ERR_MSG MSG" ).append("\n"); 
		query.append("  FROM COM_ERR_MSG" ).append("\n"); 
		query.append(" WHERE ERR_MSG_CD = 'SCG60053'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'WOI' VLD_CHK" ).append("\n"); 
		query.append("      ,ERR_MSG MSG" ).append("\n"); 
		query.append("  FROM COM_ERR_MSG" ).append("\n"); 
		query.append(" WHERE ERR_MSG_CD = 'SCG60054'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'PGI' VLD_CHK" ).append("\n"); 
		query.append("      ,ERR_MSG MSG" ).append("\n"); 
		query.append("  FROM COM_ERR_MSG" ).append("\n"); 
		query.append(" WHERE ERR_MSG_CD = 'SCG60055'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'WGI' VLD_CHK" ).append("\n"); 
		query.append("      ,ERR_MSG MSG" ).append("\n"); 
		query.append("  FROM COM_ERR_MSG" ).append("\n"); 
		query.append(" WHERE ERR_MSG_CD = 'SCG60056'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'CHD' VLD_CHK" ).append("\n"); 
		query.append("      ,ERR_MSG MSG" ).append("\n"); 
		query.append("  FROM COM_ERR_MSG" ).append("\n"); 
		query.append(" WHERE ERR_MSG_CD = 'SCG60057'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'CSP' VLD_CHK" ).append("\n"); 
		query.append("      ,ERR_MSG MSG" ).append("\n"); 
		query.append("  FROM COM_ERR_MSG" ).append("\n"); 
		query.append(" WHERE ERR_MSG_CD = 'SCG60058'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'CHP' VLD_CHK" ).append("\n"); 
		query.append("      ,ERR_MSG MSG" ).append("\n"); 
		query.append("  FROM COM_ERR_MSG" ).append("\n"); 
		query.append(" WHERE ERR_MSG_CD = 'SCG60059'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'COP' VLD_CHK" ).append("\n"); 
		query.append("      ,ERR_MSG MSG" ).append("\n"); 
		query.append("  FROM COM_ERR_MSG" ).append("\n"); 
		query.append(" WHERE ERR_MSG_CD = 'SCG60060'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT ROWNUM SEQ" ).append("\n"); 
		query.append("      ,REPLACE( REPLACE(M.MSG, '$1',C.STR1), '$2',C.STR2) AS  INVLD_DESC" ).append("\n"); 
		query.append("  FROM VLD_CHK_TBL C" ).append("\n"); 
		query.append("      ,INVLD_MSG_TBL M" ).append("\n"); 
		query.append(" WHERE C.VLD_CHK = M.VLD_CHK" ).append("\n"); 

	}
}