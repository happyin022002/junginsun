/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : RFARateProposalDBDAOPriRpScpRtAmdBasicVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.31
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.08.31 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG Min Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateProposalDBDAOPriRpScpRtAmdBasicVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Master RFA에서 가져온 Rate 데이터를 Basic Rate에 넣는다.
	  * Basic이 가지고 있는 Route만 수행한다.
	  * </pre>
	  */
	public RFARateProposalDBDAOPriRpScpRtAmdBasicVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mst_rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration").append("\n"); 
		query.append("FileName : RFARateProposalDBDAOPriRpScpRtAmdBasicVOCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_RP_SCP_RT(" ).append("\n"); 
		query.append("    PROP_NO," ).append("\n"); 
		query.append("    AMDT_SEQ," ).append("\n"); 
		query.append("    SVC_SCP_CD," ).append("\n"); 
		query.append("    CMDT_HDR_SEQ," ).append("\n"); 
		query.append("    ROUT_SEQ," ).append("\n"); 
		query.append("    RT_SEQ," ).append("\n"); 
		query.append("    RAT_UT_CD," ).append("\n"); 
		query.append("    PRC_CGO_TP_CD," ).append("\n"); 
		query.append("    CURR_CD," ).append("\n"); 
		query.append("    PROP_FRT_RT_AMT," ).append("\n"); 
		query.append("    COFFR_FRT_RT_AMT," ).append("\n"); 
		query.append("    FNL_FRT_RT_AMT," ).append("\n"); 
		query.append("    BZC_OFRT_RT_AMT," ).append("\n"); 
		query.append("    ORG_ARB_AMT," ).append("\n"); 
		query.append("    RAIL_HUB_LOC_CD," ).append("\n"); 
		query.append("    DEST_ARB_AMT," ).append("\n"); 
		query.append("    DOR_TRKA_AMT," ).append("\n"); 
		query.append("    PRS_SCG_AMT," ).append("\n"); 
		query.append("    PRS_RESPB_CM_UC_AMT," ).append("\n"); 
		query.append("    PRS_PFIT_CM_UC_AMT," ).append("\n"); 
		query.append("    PRS_RESPB_OPFIT_UC_AMT," ).append("\n"); 
		query.append("    PRS_RESPB_CMPB_AMT," ).append("\n"); 
		query.append("    PRS_PFIT_CMPB_AMT," ).append("\n"); 
		query.append("    PRS_RESPB_OPB_AMT," ).append("\n"); 
		query.append("    PRS_GID_CMPB_AMT," ).append("\n"); 
		query.append("    PRS_UPD_DT," ).append("\n"); 
		query.append("    VSL_SLAN_CD," ).append("\n"); 
		query.append("    GRI_APPL_TP_CD," ).append("\n"); 
		query.append("    GRI_APPL_AMT," ).append("\n"); 
		query.append("    PRC_PROG_STS_CD," ).append("\n"); 
		query.append("    SRC_INFO_CD," ).append("\n"); 
		query.append("    ACPT_USR_ID," ).append("\n"); 
		query.append("    ACPT_OFC_CD," ).append("\n"); 
		query.append("    ACPT_DT," ).append("\n"); 
		query.append("    CRE_USR_ID," ).append("\n"); 
		query.append("    CRE_DT," ).append("\n"); 
		query.append("    UPD_USR_ID," ).append("\n"); 
		query.append("    UPD_DT," ).append("\n"); 
		query.append("    N1ST_CMNC_AMDT_SEQ," ).append("\n"); 
		query.append("    FIC_PROP_RT_AMT," ).append("\n"); 
		query.append("    FIC_COFFR_RT_AMT," ).append("\n"); 
		query.append("    FIC_FNL_RT_AMT," ).append("\n"); 
		query.append("    FIC_GLINE_RT_AMT," ).append("\n"); 
		query.append("    FIC_GLINE_UPD_DT," ).append("\n"); 
		query.append("    OPTM_TRSP_MOD_FLG," ).append("\n"); 
		query.append("    FIC_RT_USE_STS_CD," ).append("\n"); 
		query.append("    FIC_DEST_RT_USE_STS_CD," ).append("\n"); 
		query.append("    FIC_DEST_PROP_RT_AMT," ).append("\n"); 
		query.append("    FIC_DEST_COFFR_RT_AMT, " ).append("\n"); 
		query.append("    FIC_DEST_FNL_RT_AMT, " ).append("\n"); 
		query.append("    FIC_DEST_GLINE_RT_AMT, " ).append("\n"); 
		query.append("    FIC_DEST_GLINE_UPD_DT, " ).append("\n"); 
		query.append("    DEST_OPTM_TRSP_MOD_FLG," ).append("\n"); 
		query.append("    FIC_ORG_RT_USE_STS_CD, " ).append("\n"); 
		query.append("    FIC_ORG_PROP_RT_AMT, " ).append("\n"); 
		query.append("    FIC_ORG_COFFR_RT_AMT," ).append("\n"); 
		query.append("    FIC_ORG_FNL_RT_AMT,  " ).append("\n"); 
		query.append("    FIC_ORG_GLINE_RT_AMT," ).append("\n"); 
		query.append("    FIC_ORG_GLINE_UPD_DT," ).append("\n"); 
		query.append("    ORG_OPTM_TRSP_MOD_FLG," ).append("\n"); 
		query.append("    MST_RFA_ROUT_ID" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WITH MASTER_RFA_INFO AS (" ).append("\n"); 
		query.append("    SELECT MN.PROP_NO, MAX(MN.AMDT_SEQ) AS AMDT_SEQ, SVC_SCP_CD" ).append("\n"); 
		query.append("       FROM PRI_RP_MN MN, PRI_RP_SCP_RT_CMDT_ROUT ROUT" ).append("\n"); 
		query.append("      WHERE MN.PROP_NO = (SELECT PROP_NO FROM PRI_RP_HDR WHERE RFA_NO = @[mst_rfa_no]) -- Mst RFA No" ).append("\n"); 
		query.append("        AND MN.PROP_NO = ROUT.PROP_NO" ).append("\n"); 
		query.append("        AND MN.AMDT_SEQ = ROUT.AMDT_SEQ" ).append("\n"); 
		query.append("        AND PROP_STS_CD = 'A'" ).append("\n"); 
		query.append("      GROUP BY MN.PROP_NO, SVC_SCP_CD" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("BASIC_RFA_INFO AS (" ).append("\n"); 
		query.append("	SELECT PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, MST_ROUT_ID" ).append("\n"); 
		query.append("	  FROM PRI_RP_SCP_RT_CMDT_ROUT" ).append("\n"); 
		query.append("	 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("	   AND AMDT_SEQ =  @[amdt_seq]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    B.PROP_NO                 ," ).append("\n"); 
		query.append("    B.AMDT_SEQ+1              ," ).append("\n"); 
		query.append("    B.SVC_SCP_CD              ," ).append("\n"); 
		query.append("    B.CMDT_HDR_SEQ            ," ).append("\n"); 
		query.append("    B.ROUT_SEQ                ," ).append("\n"); 
		query.append("    B.RT_SEQ                  ," ).append("\n"); 
		query.append("    B.RAT_UT_CD               ," ).append("\n"); 
		query.append("    B.PRC_CGO_TP_CD           ," ).append("\n"); 
		query.append("    M.CURR_CD                 ," ).append("\n"); 
		query.append("    M.PROP_FRT_RT_AMT         ," ).append("\n"); 
		query.append("    M.COFFR_FRT_RT_AMT        ," ).append("\n"); 
		query.append("    M.FNL_FRT_RT_AMT          ," ).append("\n"); 
		query.append("    M.BZC_OFRT_RT_AMT         ," ).append("\n"); 
		query.append("    M.ORG_ARB_AMT             ," ).append("\n"); 
		query.append("    M.RAIL_HUB_LOC_CD         ," ).append("\n"); 
		query.append("    M.DEST_ARB_AMT            ," ).append("\n"); 
		query.append("    M.DOR_TRKA_AMT            ," ).append("\n"); 
		query.append("    M.PRS_SCG_AMT             ," ).append("\n"); 
		query.append("    M.PRS_RESPB_CM_UC_AMT     ," ).append("\n"); 
		query.append("    M.PRS_PFIT_CM_UC_AMT      ," ).append("\n"); 
		query.append("    M.PRS_RESPB_OPFIT_UC_AMT  ," ).append("\n"); 
		query.append("    M.PRS_RESPB_CMPB_AMT      ," ).append("\n"); 
		query.append("    M.PRS_PFIT_CMPB_AMT       ," ).append("\n"); 
		query.append("    M.PRS_RESPB_OPB_AMT       ," ).append("\n"); 
		query.append("    M.PRS_GID_CMPB_AMT        ," ).append("\n"); 
		query.append("    M.PRS_UPD_DT              ," ).append("\n"); 
		query.append("    M.VSL_SLAN_CD             ," ).append("\n"); 
		query.append("    'N'                     ," ).append("\n"); 
		query.append("    0                       ," ).append("\n"); 
		query.append("    DECODE(M.SRC_INFO_CD, 'AM', 'I', 'AD', 'I', M.PRC_PROG_STS_CD)," ).append("\n"); 
		query.append("    M.SRC_INFO_CD             ," ).append("\n"); 
		query.append("    B.ACPT_USR_ID             ," ).append("\n"); 
		query.append("    B.ACPT_OFC_CD             ," ).append("\n"); 
		query.append("    B.ACPT_DT                 ," ).append("\n"); 
		query.append("    @[cre_usr_id]           ," ).append("\n"); 
		query.append("    SYSDATE                 ," ).append("\n"); 
		query.append("    @[upd_usr_id]           ," ).append("\n"); 
		query.append("    SYSDATE                 ," ).append("\n"); 
		query.append("    CASE WHEN M.SRC_INFO_CD IN ('AM', 'AD') AND M.N1ST_CMNC_AMDT_SEQ > TO_NUMBER(SUBSTR(B.MST_RFA_ROUT_ID, INSTR(B.MST_RFA_ROUT_ID,'_')+1,3))   THEN B.AMDT_SEQ+1 " ).append("\n"); 
		query.append("         ELSE B.AMDT_SEQ " ).append("\n"); 
		query.append("    END AS N1ST_CMNC_AMDT_SEQ ," ).append("\n"); 
		query.append("    M.FIC_PROP_RT_AMT         ," ).append("\n"); 
		query.append("    M.FIC_COFFR_RT_AMT        ," ).append("\n"); 
		query.append("    M.FIC_FNL_RT_AMT          ," ).append("\n"); 
		query.append("    M.FIC_GLINE_RT_AMT        ," ).append("\n"); 
		query.append("    M.FIC_GLINE_UPD_DT        ," ).append("\n"); 
		query.append("    M.OPTM_TRSP_MOD_FLG       ," ).append("\n"); 
		query.append("    M.FIC_RT_USE_STS_CD       ," ).append("\n"); 
		query.append("    M.FIC_DEST_RT_USE_STS_CD  ," ).append("\n"); 
		query.append("    M.FIC_DEST_PROP_RT_AMT    ," ).append("\n"); 
		query.append("    M.FIC_DEST_COFFR_RT_AMT   , " ).append("\n"); 
		query.append("    M.FIC_DEST_FNL_RT_AMT     , " ).append("\n"); 
		query.append("    M.FIC_DEST_GLINE_RT_AMT   , " ).append("\n"); 
		query.append("    M.FIC_DEST_GLINE_UPD_DT   , " ).append("\n"); 
		query.append("    M.DEST_OPTM_TRSP_MOD_FLG  ," ).append("\n"); 
		query.append("    M.FIC_ORG_RT_USE_STS_CD   , " ).append("\n"); 
		query.append("    M.FIC_ORG_PROP_RT_AMT     , " ).append("\n"); 
		query.append("    M.FIC_ORG_COFFR_RT_AMT    ," ).append("\n"); 
		query.append("    M.FIC_ORG_FNL_RT_AMT      ,  " ).append("\n"); 
		query.append("    M.FIC_ORG_GLINE_RT_AMT    ," ).append("\n"); 
		query.append("    M.FIC_ORG_GLINE_UPD_DT    ," ).append("\n"); 
		query.append("    M.ORG_OPTM_TRSP_MOD_FLG   ," ).append("\n"); 
		query.append("    @[mst_rfa_no] ||'_'|| LPAD(M.AMDT_SEQ, 3, '0') ||'_'|| LPAD(BSC_INFO.MST_ROUT_ID, 3, '0')" ).append("\n"); 
		query.append("  FROM MASTER_RFA_INFO MST_INFO," ).append("\n"); 
		query.append("       PRI_RP_SCP_RT M,-- Master" ).append("\n"); 
		query.append("       BASIC_RFA_INFO BSC_INFO," ).append("\n"); 
		query.append("       PRI_RP_SCP_RT B -- Basic" ).append("\n"); 
		query.append(" WHERE " ).append("\n"); 
		query.append("   -- Master" ).append("\n"); 
		query.append("       M.PROP_NO = MST_INFO.PROP_NO" ).append("\n"); 
		query.append("   AND M.AMDT_SEQ = MST_INFO.AMDT_SEQ" ).append("\n"); 
		query.append("   AND M.SVC_SCP_CD = MST_INFO.SVC_SCP_CD" ).append("\n"); 
		query.append("   -- Basic" ).append("\n"); 
		query.append("   AND B.PROP_NO = BSC_INFO.PROP_NO" ).append("\n"); 
		query.append("   AND B.AMDT_SEQ = BSC_INFO.AMDT_SEQ" ).append("\n"); 
		query.append("   AND B.SVC_SCP_CD = BSC_INFO.SVC_SCP_CD" ).append("\n"); 
		query.append("   AND B.CMDT_HDR_SEQ = BSC_INFO.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("   AND B.ROUT_SEQ = BSC_INFO.ROUT_SEQ" ).append("\n"); 
		query.append("   -- Join" ).append("\n"); 
		query.append("   AND B.SVC_SCP_CD = M.SVC_SCP_CD" ).append("\n"); 
		query.append("   AND B.CMDT_HDR_SEQ = M.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("   AND BSC_INFO.MST_ROUT_ID = M.ROUT_SEQ" ).append("\n"); 
		query.append("   AND B.RT_SEQ = M.RT_SEQ" ).append("\n"); 

	}
}