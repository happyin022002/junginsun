/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AuthorizationAssignmentDBDAOPriAuthorizationVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.08.17 문동규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.authorizationassignment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Moon Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AuthorizationAssignmentDBDAOPriAuthorizationVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public AuthorizationAssignmentDBDAOPriAuthorizationVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_ctrt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.primasterdata.authorizationassignment.integration").append("\n"); 
		query.append("FileName : AuthorizationAssignmentDBDAOPriAuthorizationVORSQL").append("\n"); 
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
		query.append("SELECT @[prc_ctrt_tp_cd] AS PRC_CTRT_TP_CD" ).append("\n"); 
		query.append(", AU.SVC_SCP_CD" ).append("\n"); 
		query.append(", UR.USR_ID" ).append("\n"); 
		query.append(", UR.USR_NM" ).append("\n"); 
		query.append(", UR.OFC_CD" ).append("\n"); 
		query.append(", UR.GRD_ENG_NM" ).append("\n"); 
		query.append(", AU.EFF_DT" ).append("\n"); 
		query.append(", DECODE(SIGN(AU.EXP_DT - SYSDATE),1,TO_CHAR(AU.EFF_DT, 'YYYYMMDD'),'') AS EFF_DT" ).append("\n"); 
		query.append(", TO_CHAR(AU.EXP_DT, 'YYYYMMDD') AS EXP_DT" ).append("\n"); 
		query.append(", CASE WHEN AU.USR_ID IS NULL" ).append("\n"); 
		query.append("THEN 'N'" ).append("\n"); 
		query.append("WHEN (AU.EXP_DT - SYSDATE) > 0" ).append("\n"); 
		query.append("THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END AUTH_FLG" ).append("\n"); 
		query.append(", AU.CRE_USR_ID" ).append("\n"); 
		query.append(", AU.CRE_DT" ).append("\n"); 
		query.append(", AU.UPD_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(AU.UPD_DT, 'YYYYMMDD') AS UPD_DT" ).append("\n"); 
		query.append(", (SELECT USR_NM||' / '||OFC_CD FROM COM_USER WHERE USR_ID = AU.UPD_USR_ID ) AS UPD_USR_NM" ).append("\n"); 
		query.append("FROM COM_USER UR" ).append("\n"); 
		query.append(", PRI_AUTHORIZATION AU" ).append("\n"); 
		query.append("WHERE UR.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND   UR.USE_FLG = 'Y'" ).append("\n"); 
		query.append("#if (${is_inq} == 'Y')" ).append("\n"); 
		query.append("AND   AU.USR_ID = UR.USR_ID -- inquiry" ).append("\n"); 
		query.append("AND   AU.PRC_CTRT_TP_CD = @[prc_ctrt_tp_cd]  -- S:S/C, R:RFA" ).append("\n"); 
		query.append("AND   (AU.EXP_DT - SYSDATE) > 0" ).append("\n"); 
		query.append("#if (${svc_scp_cd} != '')" ).append("\n"); 
		query.append("AND   AU.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND   AU.USR_ID(+) = UR.USR_ID -- creation" ).append("\n"); 
		query.append("AND   AU.PRC_CTRT_TP_CD(+) = @[prc_ctrt_tp_cd]  -- S:S/C, R:RFA" ).append("\n"); 
		query.append("AND   AU.SVC_SCP_CD(+) = @[svc_scp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY UR.USR_ID, AU.SVC_SCP_CD" ).append("\n"); 

	}
}