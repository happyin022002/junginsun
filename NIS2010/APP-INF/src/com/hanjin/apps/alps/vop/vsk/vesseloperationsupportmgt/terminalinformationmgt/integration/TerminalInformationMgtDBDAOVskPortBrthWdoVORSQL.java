/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TerminalInformationMgtDBDAOVskPortBrthWdoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.18
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2010.03.18 장석현
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Suk Hyun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalInformationMgtDBDAOVskPortBrthWdoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public TerminalInformationMgtDBDAOVskPortBrthWdoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flt_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.integration").append("\n"); 
		query.append("FileName : TerminalInformationMgtDBDAOVskPortBrthWdoVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("A.YD_CD" ).append("\n"); 
		query.append(",	B.YD_NM" ).append("\n"); 
		query.append(",	CASE WHEN C.VSL_SLAN_CD IS NULL THEN A.REF_SLAN_NM ELSE C.VSL_SLAN_CD END AS REF_SLAN_NM" ).append("\n"); 
		query.append(",	A.SKD_DIR_CD" ).append("\n"); 
		query.append(",	A.CRR_CD" ).append("\n"); 
		query.append(",	A.LOC_CD" ).append("\n"); 
		query.append(",	A.ETB_DY_CD" ).append("\n"); 
		query.append(",	A.ETB_TM_HRMNT" ).append("\n"); 
		query.append(",	A.ETD_DY_CD" ).append("\n"); 
		query.append(",	A.ETD_TM_HRMNT" ).append("\n"); 
		query.append(",	A.CRE_USR_ID" ).append("\n"); 
		query.append(",	A.CRE_DT" ).append("\n"); 
		query.append(",	A.UPD_USR_ID" ).append("\n"); 
		query.append(",   to_char(A.UPD_DT, 'YYYY-MM-DD HH24:MI') AS UPD_DT" ).append("\n"); 
		query.append(",   A.BRTH_SEQ" ).append("\n"); 
		query.append("FROM 	VSK_PORT_BRTH_WDO	A," ).append("\n"); 
		query.append("MDM_YARD			B," ).append("\n"); 
		query.append("MDM_VSL_SVC_LANE    C" ).append("\n"); 
		query.append("WHERE	A.YD_CD	=	B.YD_CD" ).append("\n"); 
		query.append("AND     A.REF_SLAN_NM  = C.VSL_SLAN_NM  (+)" ).append("\n"); 
		query.append("AND		A.LOC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#if (${flt_type} != '')" ).append("\n"); 
		query.append("AND	nvl(c.vskd_flet_grp_cd, '-') like @[flt_type]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}