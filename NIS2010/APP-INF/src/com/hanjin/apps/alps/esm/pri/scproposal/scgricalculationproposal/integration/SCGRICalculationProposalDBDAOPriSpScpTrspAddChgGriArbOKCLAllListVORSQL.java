/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGRICalculationProposalDBDAOPriSpScpTrspAddChgGriArbOKCLAllListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.11.17 김대호
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

public class SCGRICalculationProposalDBDAOPriSpScpTrspAddChgGriArbOKCLAllListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI_SP_SCP_TRSP_ADD_CHG테이블에 GRI ARB OK/Cancle 조건리스트
	  * </pre>
	  */
	public SCGRICalculationProposalDBDAOPriSpScpTrspAddChgGriArbOKCLAllListVORSQL(){
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
		query.append("FileName : SCGRICalculationProposalDBDAOPriSpScpTrspAddChgGriArbOKCLAllListVORSQL").append("\n"); 
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
		query.append("A.PROP_NO             -- param" ).append("\n"); 
		query.append(",A.AMDT_SEQ            -- param" ).append("\n"); 
		query.append(",A.SVC_SCP_CD          -- param" ).append("\n"); 
		query.append(",A.ORG_DEST_TP_CD      -- param" ).append("\n"); 
		query.append(",A.GRI_GRP_SEQ         -- key" ).append("\n"); 
		query.append(",A.GRI_APPL_DIV_CD     -- Application" ).append("\n"); 
		query.append(",A.ROUT_PNT_LOC_DEF_CD -- Point" ).append("\n"); 
		query.append(",A.PRC_TRSP_MOD_CD     -- Trans Mode" ).append("\n"); 
		query.append(",A.RCV_DE_TERM_CD      -- Term" ).append("\n"); 
		query.append(",A.BSE_PORT_DEF_CD     -- Base Port" ).append("\n"); 
		query.append(",A.FLT_PCT_TP_CD       -- Applying Option" ).append("\n"); 
		query.append(",A.VIA_PORT_DEF_CD     -- VIA" ).append("\n"); 
		query.append(",B.GRI_ADJ_SEQ         -- key" ).append("\n"); 
		query.append(",B.RAT_UT_CD           -- Per" ).append("\n"); 
		query.append(",B.PRC_CGO_TP_CD       -- Cargo Type" ).append("\n"); 
		query.append(",B.CURR_CD             -- Currency" ).append("\n"); 
		query.append(",B.GRI_RT_AMT          -- AMT" ).append("\n"); 
		query.append(",B.GRI_RT_RTO          -- Percentage" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_ARB_GRI_GRP A" ).append("\n"); 
		query.append(",PRI_SP_SCP_ARB_GRI_RT  B" ).append("\n"); 
		query.append("WHERE A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND A.ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("AND A.PROP_NO = B.PROP_NO (+)" ).append("\n"); 
		query.append("AND A.AMDT_SEQ = B.AMDT_SEQ (+)" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = B.SVC_SCP_CD (+)" ).append("\n"); 
		query.append("AND A.ORG_DEST_TP_CD = B.ORG_DEST_TP_CD (+)" ).append("\n"); 
		query.append("AND A.GRI_GRP_SEQ = B.GRI_GRP_SEQ (+)" ).append("\n"); 

	}
}