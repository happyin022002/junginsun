/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OperationNPerformMasterDataMgtDBDAOTargetPortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.28
*@LastModifier : Arie
*@LastVersion : 1.0
* 2016.04.28 Arie
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Arie
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OperationNPerformMasterDataMgtDBDAOTargetPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2016.04.28 Arie Im CHM-201641178 아프리카 대륙 구주지역본부/동서남아지역본부 구분 로직 추가
	  * </pre>
	  */
	public OperationNPerformMasterDataMgtDBDAOTargetPortRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.integration").append("\n"); 
		query.append("FileName : OperationNPerformMasterDataMgtDBDAOTargetPortRSQL").append("\n"); 
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
		query.append("SELECT loc_cd" ).append("\n"); 
		query.append(", conti_cd" ).append("\n"); 
		query.append(",  vop_port_flg" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("		loc_cd" ).append("\n"); 
		query.append("	,	por_rhq as conti_cd" ).append("\n"); 
		query.append("	,	'Y'     as vop_port_flg" ).append("\n"); 
		query.append("	FROM (" ).append("\n"); 
		query.append("--		SELECT LOC_CD, 'HAMRU' POR_RHQ" ).append("\n"); 
		query.append("--		FROM   MDM_LOCATION" ).append("\n"); 
		query.append("--		WHERE  DECODE(CONTI_CD, 'F', 'E', CONTI_CD) = 'E'" ).append("\n"); 
		query.append("--		AND    NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("--		AND    CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("--		AND    VOP_PORT_FLG = 'Y'        " ).append("\n"); 
		query.append("--                AND    LOC_CD NOT IN ('EGAIS','ZADUR','RUVVO')" ).append("\n"); 
		query.append("--		UNION ALL" ).append("\n"); 
		query.append("--		SELECT LOC_CD, 'NYCRA' POR_RHQ" ).append("\n"); 
		query.append("--		FROM   MDM_LOCATION" ).append("\n"); 
		query.append("--		WHERE  CONTI_CD  = 'M'" ).append("\n"); 
		query.append("--		AND    NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("--		AND    CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("--		AND    VOP_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("--		UNION ALL" ).append("\n"); 
		query.append("--		SELECT LOC_CD, DECODE(SCONTI_CD, 'AF', DECODE(CNT_CD,'KR','SELIB','JP','TYOIB','SHARC'), 'SINRS') POR_RHQ" ).append("\n"); 
		query.append("--		FROM   MDM_LOCATION" ).append("\n"); 
		query.append("--         	WHERE (CONTI_CD  = 'A' OR LOC_CD = 'EGAIS' OR LOC_CD = 'ZADUR')" ).append("\n"); 
		query.append("--		AND    NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("--		AND    CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("--		AND    VOP_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("--		UNION ALL" ).append("\n"); 
		query.append("--		SELECT LOC_CD, 'VVOIA' POR_RHQ" ).append("\n"); 
		query.append("--        FROM   MDM_LOCATION" ).append("\n"); 
		query.append("--        WHERE  CONTI_CD           = 'E'" ).append("\n"); 
		query.append("--        AND    NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("--        AND    CALL_PORT_FLG      = 'Y'" ).append("\n"); 
		query.append("--        AND    LOC_CD             = 'RUVVO'" ).append("\n"); 
		query.append("--        AND    VOP_PORT_FLG       = 'Y'" ).append("\n"); 
		query.append("        SELECT L.LOC_CD, O.OFC_N3RD_LVL_CD POR_RHQ FROM MDM_LOCATION L, MAS_OFC_LVL O WHERE L.EQ_CTRL_OFC_CD = O.OFC_CD AND L.CALL_PORT_FLG = 'Y' AND L.DELT_FLG = 'N' AND O.OFC_APLY_TO_YRMON ='999912' AND O.OFC_LVL < 9 " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${conti_cd} != '') " ).append("\n"); 
		query.append("and	conti_cd like @[conti_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY loc_cd" ).append("\n"); 

	}
}