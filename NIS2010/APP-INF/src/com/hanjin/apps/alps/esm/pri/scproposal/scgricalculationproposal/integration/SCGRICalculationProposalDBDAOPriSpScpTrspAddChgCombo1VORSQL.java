/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGRICalculationProposalDBDAOPriSpScpTrspAddChgCombo1VORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.09.17 김대호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author day-hoh Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGRICalculationProposalDBDAOPriSpScpTrspAddChgCombo1VORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GRI Calculation - Arbitrary 상단 그리드콤보데이터조회
	  * </pre>
	  */
	public SCGRICalculationProposalDBDAOPriSpScpTrspAddChgCombo1VORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("add_chg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.integration").append("\n"); 
		query.append("FileName : SCGRICalculationProposalDBDAOPriSpScpTrspAddChgCombo1VORSQL").append("\n"); 
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
		query.append("SELECT ROWNUM AS RNUM" ).append("\n"); 
		query.append(",@[prop_no]        AS PROP_NO" ).append("\n"); 
		query.append(",@[amdt_seq]       AS AMDT_SEQ" ).append("\n"); 
		query.append(",@[svc_scp_cd]     AS SVC_SCP_CD" ).append("\n"); 
		query.append(",@[add_chg_tp_cd]  AS ADD_CHG_TP_CD" ).append("\n"); 
		query.append(",@[org_dest_tp_cd] AS ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",T.ROUT_PNT_LOC_DEF_CD                                                                         -- Point" ).append("\n"); 
		query.append(",(SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = T.ROUT_PNT_LOC_DEF_CD) AS ROUT_PNT_LOC_DEF_NM -- Point nm" ).append("\n"); 
		query.append(",T.PRC_TRSP_MOD_CD                                                                             -- Trans Mode Cd" ).append("\n"); 
		query.append(",(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD01720'" ).append("\n"); 
		query.append("AND INTG_CD_VAL_CTNT = T.PRC_TRSP_MOD_CD)                          AS PRC_TRSP_MOD_NM     -- Trans Mode Nm" ).append("\n"); 
		query.append(",T.RCV_DE_TERM_CD                                                                              -- Term Cd" ).append("\n"); 
		query.append("#if (${org_dest_tp_cd} == 'O')" ).append("\n"); 
		query.append(",(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD02138'" ).append("\n"); 
		query.append("AND INTG_CD_VAL_CTNT = T.RCV_DE_TERM_CD)                           AS RCV_DE_TERM_NM      -- Term Nm" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD02139'" ).append("\n"); 
		query.append("AND INTG_CD_VAL_CTNT = T.RCV_DE_TERM_CD)                           AS RCV_DE_TERM_NM      -- Term Nm" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",T.BSE_PORT_DEF_CD                                                                             -- Base Port" ).append("\n"); 
		query.append("--,(SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = T.BSE_PORT_DEF_CD)     AS BSE_PORT_DEF_NM     -- Base Port nm" ).append("\n"); 
		query.append(",CASE WHEN LENGTH(T.BSE_PORT_DEF_CD) = 4 THEN" ).append("\n"); 
		query.append("(SELECT PRC_GRP_LOC_DESC" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_GRP_LOC" ).append("\n"); 
		query.append("WHERE PROP_NO = T.PROP_NO" ).append("\n"); 
		query.append("AND AMDT_SEQ = T.AMDT_SEQ" ).append("\n"); 
		query.append("AND SVC_SCP_CD = T.SVC_SCP_CD" ).append("\n"); 
		query.append("AND PRC_GRP_LOC_CD = T.BSE_PORT_DEF_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ELSE (SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = T.BSE_PORT_DEF_CD)" ).append("\n"); 
		query.append("END  BSE_PORT_DEF_NM     -- Base Port nm" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",T.VIA_PORT_DEF_CD                                                                             -- VIA" ).append("\n"); 
		query.append(",(SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = T.VIA_PORT_DEF_CD)     AS VIA_PORT_DEF_NM     -- VIA nm" ).append("\n"); 
		query.append(",T.CURR_CD                                                                                     -- Currency" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",ROUT_PNT_LOC_DEF_CD -- Point" ).append("\n"); 
		query.append(",PRC_TRSP_MOD_CD     -- Trans Mode" ).append("\n"); 
		query.append(",RCV_DE_TERM_CD      -- Term" ).append("\n"); 
		query.append(",BSE_PORT_DEF_CD     -- Base Port" ).append("\n"); 
		query.append(",VIA_PORT_DEF_CD     -- VIA" ).append("\n"); 
		query.append(",CURR_CD             -- Currency" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_TRSP_ADD_CHG" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND ADD_CHG_TP_CD = @[add_chg_tp_cd]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("ORDER BY ROUT_PNT_LOC_DEF_CD, PRC_TRSP_MOD_CD, RCV_DE_TERM_CD, BSE_PORT_DEF_CD, VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(") T" ).append("\n"); 

	}
}