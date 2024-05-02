/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGRICalculationProposalDBDAOPriSpScpTrspAddChgGriArbOKCLListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.08.26 김대호
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

public class SCGRICalculationProposalDBDAOPriSpScpTrspAddChgGriArbOKCLListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI_SP_SCP_TRSP_ADD_CHG테이블에 GRI ARB OK/Cancle 조건리스트
	  * </pre>
	  */
	public SCGRICalculationProposalDBDAOPriSpScpTrspAddChgGriArbOKCLListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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

		tmp = java.sql.Types.NUMERIC + ",N";
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
		query.append("FileName : SCGRICalculationProposalDBDAOPriSpScpTrspAddChgGriArbOKCLListVORSQL").append("\n"); 
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
		query.append("PROP_NO             -- param" ).append("\n"); 
		query.append(",AMDT_SEQ            -- param" ).append("\n"); 
		query.append(",SVC_SCP_CD          -- param" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD      -- param" ).append("\n"); 
		query.append(",GRI_GRP_SEQ         -- key" ).append("\n"); 
		query.append(",FLT_PCT_TP_CD       -- application option" ).append("\n"); 
		query.append(",GRI_APPL_DIV_CD     -- Application" ).append("\n"); 
		query.append(",ROUT_PNT_LOC_DEF_CD -- Point" ).append("\n"); 
		query.append(",PRC_TRSP_MOD_CD     -- Trans Mode" ).append("\n"); 
		query.append(",RCV_DE_TERM_CD      -- Term" ).append("\n"); 
		query.append(",BSE_PORT_DEF_CD     -- Base Port" ).append("\n"); 
		query.append(",VIA_PORT_DEF_CD     -- VIA" ).append("\n"); 
		query.append(",ROUT_PNT_LOC_DEF_CD AS POINT_O     -- Point" ).append("\n"); 
		query.append(",PRC_TRSP_MOD_CD     AS TRANSMODE_O -- Trans Mode" ).append("\n"); 
		query.append(",RCV_DE_TERM_CD      AS TERM_O      -- Term" ).append("\n"); 
		query.append(",BSE_PORT_DEF_CD     AS BASEPORT_O  -- Base Port" ).append("\n"); 
		query.append(",VIA_PORT_DEF_CD     AS VIA_O       -- VIA" ).append("\n"); 
		query.append(",'' AS ADD_CHG_TP_CD" ).append("\n"); 
		query.append(",'' AS GRI_APPL_FLG" ).append("\n"); 
		query.append(",'' AS ADD_CHG_SEQ" ).append("\n"); 
		query.append(",'' AS N1ST_CMNC_DT" ).append("\n"); 
		query.append(",'' AS RAT_UT_CD" ).append("\n"); 
		query.append(",'' AS PRC_CGO_TP_CD" ).append("\n"); 
		query.append(",'' AS CURR_CD" ).append("\n"); 
		query.append(",'' AS GRI_RT_AMT" ).append("\n"); 
		query.append(",'' AS GRI_RT_RTO" ).append("\n"); 
		query.append(",'' AS UPD_USR_ID" ).append("\n"); 
		query.append(",'' AS GRI_APPL_TP_CD" ).append("\n"); 
		query.append(",'' AS GRI_APPL_AMT" ).append("\n"); 
		query.append(",'' AS PROP_FRT_RT_AMT" ).append("\n"); 
		query.append(",'' AS PRC_PROG_STS_CD" ).append("\n"); 
		query.append(",'' AS SRC_INFO_CD" ).append("\n"); 
		query.append(",'' AS UPD_USR_ID" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_ARB_GRI_GRP" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND	AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND	SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND	ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 

	}
}