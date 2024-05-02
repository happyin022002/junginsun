/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PRISimulationDBDAORsltTAAContractInfoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.31
*@LastModifier : 김경미
*@LastVersion : 1.0
* 2016.08.31 김경미
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.prisimulation.prisimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KYEONGMI KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRISimulationDBDAORsltTAAContractInfoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GET TAA CONTRACT INFO
	  * </pre>
	  */
	public PRISimulationDBDAORsltTAAContractInfoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scontract_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sprop_scp_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srout_via_port_def_cd_dest",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sprc_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sprc_ctrt_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sctrt_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srout_pnt_loc_def_cd_ori",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sctrt_cust",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srout_pnt_loc_def_cd_dest",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srout_via_port_def_cd_ori",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sprop_scp_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ssvc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.prisimulation.prisimulation.integration").append("\n"); 
		query.append("FileName : PRISimulationDBDAORsltTAAContractInfoListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("       'TAA'                       AS CNTR_TP" ).append("\n"); 
		query.append("      , TD.TAA_NO                   AS CNTR_NO" ).append("\n"); 
		query.append("      , MC.CUST_LGL_ENG_NM          AS CUST_NM" ).append("\n"); 
		query.append("      , 'N/A'                       AS ACT_CUST_NM" ).append("\n"); 
		query.append("      , TA.RESPB_SREP_CD            AS SREP_CD " ).append("\n"); 
		query.append("      ,(SELECT MC.CMDT_NM" ).append("\n"); 
		query.append("        FROM MDM_COMMODITY MC" ).append("\n"); 
		query.append("        WHERE MC.CMDT_CD = TM.CMDT_CD) AS CMDT_NM" ).append("\n"); 
		query.append("     ,(SELECT LISTAGG(OP.ROUT_PNT_LOC_CD || NVL2(CD.INTG_CD_VAL_DP_DESC, '(' ||CD.INTG_CD_VAL_DP_DESC|| ')', ''), ';') WITHIN GROUP (ORDER BY OP.TRI_PROP_NO)" ).append("\n"); 
		query.append("       FROM   PRI_TRI_RT_ROUT_PNT  OP, COM_INTG_CD_DTL CD" ).append("\n"); 
		query.append("       WHERE  OP.TRI_PROP_NO       = TL.TRI_PROP_NO" ).append("\n"); 
		query.append("         AND  OP.ORG_DEST_TP_CD    = 'O'" ).append("\n"); 
		query.append("         AND  CD.INTG_CD_ID        = 'CD02138' " ).append("\n"); 
		query.append("         AND  CD.INTG_CD_VAL_CTNT  = OP.RCV_DE_TERM_CD" ).append("\n"); 
		query.append("     ) AS ORG_CD " ).append("\n"); 
		query.append("     ,(SELECT LISTAGG(OV.ROUT_VIA_PORT_CD, ';') WITHIN GROUP (ORDER BY OV.TRI_PROP_NO)" ).append("\n"); 
		query.append("       FROM   PRI_TRI_RT_ROUT_VIA  OV" ).append("\n"); 
		query.append("       WHERE  OV.TRI_PROP_NO           = TL.TRI_PROP_NO" ).append("\n"); 
		query.append("       AND    OV.ORG_DEST_TP_CD    = 'O'" ).append("\n"); 
		query.append("     ) AS ORG_VIA_CD " ).append("\n"); 
		query.append("     ,(SELECT LISTAGG(DV.ROUT_VIA_PORT_CD, ';') WITHIN GROUP (ORDER BY DV.TRI_PROP_NO)" ).append("\n"); 
		query.append("       FROM   PRI_TRI_RT_ROUT_VIA  DV" ).append("\n"); 
		query.append("       WHERE  DV.TRI_PROP_NO           = TL.TRI_PROP_NO" ).append("\n"); 
		query.append("       AND    DV.ORG_DEST_TP_CD    = 'D'" ).append("\n"); 
		query.append("     ) AS DEST_VIA_CD " ).append("\n"); 
		query.append("     ,(SELECT LISTAGG(DP.ROUT_PNT_LOC_CD || NVL2(CD.INTG_CD_VAL_DP_DESC, '(' ||CD.INTG_CD_VAL_DP_DESC|| ')', ''), ';') WITHIN GROUP (ORDER BY DP.TRI_PROP_NO)" ).append("\n"); 
		query.append("       FROM   PRI_TRI_RT_ROUT_PNT  DP, COM_INTG_CD_DTL CD" ).append("\n"); 
		query.append("       WHERE  DP.TRI_PROP_NO           = TL.TRI_PROP_NO" ).append("\n"); 
		query.append("       AND    DP.ORG_DEST_TP_CD    = 'D'" ).append("\n"); 
		query.append("       AND    CD.INTG_CD_ID        = 'CD02138' " ).append("\n"); 
		query.append("       AND    CD.INTG_CD_VAL_CTNT  = DP.RCV_DE_TERM_CD" ).append("\n"); 
		query.append("     ) AS DEST_CD " ).append("\n"); 
		query.append("     ,(SELECT LISTAGG(INTG_CD_VAL_CTNT, ';') WITHIN GROUP (ORDER BY CD.INTG_CD_VAL_DP_SEQ)" ).append("\n"); 
		query.append("       FROM   COM_INTG_CD_DTL CD" ).append("\n"); 
		query.append("       WHERE  CD.INTG_CD_ID  = 'CD01701'" ).append("\n"); 
		query.append("       AND    EXISTS" ).append("\n"); 
		query.append("              (SELECT 'X'" ).append("\n"); 
		query.append("               FROM   PRI_TRI_RT           RT" ).append("\n"); 
		query.append("               WHERE  1=1" ).append("\n"); 
		query.append("               AND     RT.TRI_PROP_NO        = TR.TRI_PROP_NO" ).append("\n"); 
		query.append("               AND     RT.AMDT_SEQ           = TR.AMDT_SEQ" ).append("\n"); 
		query.append("               AND     RT.PRC_CGO_TP_CD      = CD.INTG_CD_VAL_CTNT)" ).append("\n"); 
		query.append("      ) AS PRC_CGO_TP_CD" ).append("\n"); 
		query.append("    FROM  PRI_TAA_HDR TD" ).append("\n"); 
		query.append("        , PRI_TAA_MN TA" ).append("\n"); 
		query.append("        , PRI_TAA_TRI_LIST TL" ).append("\n"); 
		query.append("        , PRI_TRI_MN TM" ).append("\n"); 
		query.append("        , PRI_TRI_RT TR" ).append("\n"); 
		query.append("        , MDM_CUSTOMER MC" ).append("\n"); 
		query.append("        , MDM_SLS_REP MR " ).append("\n"); 
		query.append("    WHERE   1=1" ).append("\n"); 
		query.append("    AND TA.TAA_PROP_NO = TD.TAA_PROP_NO" ).append("\n"); 
		query.append("    AND TL.TAA_PROP_NO = TA.TAA_PROP_NO" ).append("\n"); 
		query.append("    AND TL.AMDT_SEQ    = TA.AMDT_SEQ" ).append("\n"); 
		query.append("    AND TM.TRI_PROP_NO = TL.TRI_PROP_NO" ).append("\n"); 
		query.append("    AND TR.TRI_PROP_NO = TM.TRI_PROP_NO" ).append("\n"); 
		query.append("    AND MC.CUST_CNT_CD = TA.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("    AND MC.CUST_SEQ    = TA.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("    AND MR.SREP_CD     = TA.RESPB_SREP_CD" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    AND TO_DATE ( @[seff_dt],'YYYY-MM-DD' ) BETWEEN TA.EFF_DT AND TA.EXP_DT " ).append("\n"); 
		query.append("    AND TR.AMDT_SEQ = (SELECT MAX ( TT.AMDT_SEQ ) " ).append("\n"); 
		query.append("                             FROM PRI_TRI_RT TT" ).append("\n"); 
		query.append("                            WHERE TT.TRI_PROP_NO = TR.TRI_PROP_NO" ).append("\n"); 
		query.append("                              AND TT.PROP_STS_CD = 'F'" ).append("\n"); 
		query.append("                              AND TA.CFM_FLG = 'Y'" ).append("\n"); 
		query.append("                              AND TO_DATE ( @[seff_dt],'YYYY-MM-DD' ) BETWEEN TT.EFF_DT AND TT.EXP_DT)" ).append("\n"); 
		query.append("    AND     TA.SVC_SCP_CD = @[ssvc_scp_cd]" ).append("\n"); 
		query.append("    #if (${sctrt_cust} != '' && ${sctrt_cust_seq} != '')" ).append("\n"); 
		query.append("    AND     TA.CTRT_CUST_CNT_CD          = @[sctrt_cust]" ).append("\n"); 
		query.append("    AND     TA.CTRT_CUST_SEQ             = @[sctrt_cust_seq]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${scontract_no} != '')" ).append("\n"); 
		query.append("    AND TD.TAA_NO                LIKE @[scontract_no]||'%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${sprop_scp_srep_cd} != '')" ).append("\n"); 
		query.append("    AND TA.RESPB_SREP_CD            = @[sprop_scp_srep_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${sprc_ctrt_cust_tp_cd} != '')" ).append("\n"); 
		query.append("    AND TA.PRC_CTRT_CUST_TP_CD      = @[sprc_ctrt_cust_tp_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${sprop_scp_ofc_cd} != '')" ).append("\n"); 
		query.append("    AND TA.RESPB_SLS_OFC_CD         = @[sprop_scp_ofc_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${srout_pnt_loc_def_cd_ori} != '')" ).append("\n"); 
		query.append("    AND     EXISTS" ).append("\n"); 
		query.append("           (SELECT 'X'" ).append("\n"); 
		query.append("            FROM   PRI_TRI_RT_ROUT_PNT  ORIG" ).append("\n"); 
		query.append("            WHERE  1=1" ).append("\n"); 
		query.append("            AND     ORIG.TRI_PROP_NO        = TL.TRI_PROP_NO" ).append("\n"); 
		query.append("            AND     ORIG.ORG_DEST_TP_CD     = 'O'" ).append("\n"); 
		query.append("            AND     ORIG.ROUT_PNT_LOC_CD    LIKE @[srout_pnt_loc_def_cd_ori]||'%'" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${srout_pnt_loc_def_cd_dest} != '')" ).append("\n"); 
		query.append("    AND     EXISTS" ).append("\n"); 
		query.append("           (SELECT 'X'" ).append("\n"); 
		query.append("            FROM   PRI_TRI_RT_ROUT_PNT  DEST" ).append("\n"); 
		query.append("            WHERE  1=1" ).append("\n"); 
		query.append("            AND     DEST.TRI_PROP_NO        = TL.TRI_PROP_NO" ).append("\n"); 
		query.append("            AND     DEST.ORG_DEST_TP_CD     = 'D'" ).append("\n"); 
		query.append("            AND     DEST.ROUT_PNT_LOC_CD    LIKE @[srout_pnt_loc_def_cd_dest]||'%'" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${srout_via_port_def_cd_ori} != '')" ).append("\n"); 
		query.append("    AND     EXISTS" ).append("\n"); 
		query.append("           (SELECT 'X'" ).append("\n"); 
		query.append("            FROM   PRI_TRI_RT_ROUT_VIA  OVIA" ).append("\n"); 
		query.append("            WHERE  1=1" ).append("\n"); 
		query.append("            AND     OVIA.TRI_PROP_NO        = TL.TRI_PROP_NO" ).append("\n"); 
		query.append("            AND     OVIA.ORG_DEST_TP_CD     = 'O'" ).append("\n"); 
		query.append("            AND     OVIA.ROUT_VIA_PORT_CD    LIKE @[srout_via_port_def_cd_ori]||'%'" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${srout_via_port_def_cd_dest} != '')" ).append("\n"); 
		query.append("    AND     EXISTS" ).append("\n"); 
		query.append("           (SELECT 'X'" ).append("\n"); 
		query.append("            FROM   PRI_TRI_RT_ROUT_VIA  DVIA" ).append("\n"); 
		query.append("            WHERE  1=1" ).append("\n"); 
		query.append("            AND     DVIA.TRI_PROP_NO        = TL.TRI_PROP_NO" ).append("\n"); 
		query.append("            AND     DVIA.ORG_DEST_TP_CD     = 'D'" ).append("\n"); 
		query.append("            AND     DVIA.ROUT_VIA_PORT_CD    LIKE @[srout_via_port_def_cd_dest]||'%'" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${sprc_cgo_tp_cd} != '')" ).append("\n"); 
		query.append("    AND     EXISTS" ).append("\n"); 
		query.append("           (SELECT 'X'" ).append("\n"); 
		query.append("            FROM   PRI_TRI_RT           RT" ).append("\n"); 
		query.append("            WHERE  1=1" ).append("\n"); 
		query.append("            AND     RT.TRI_PROP_NO        = TR.TRI_PROP_NO" ).append("\n"); 
		query.append("            AND     RT.AMDT_SEQ           = TR.AMDT_SEQ" ).append("\n"); 
		query.append("            AND     RT.PRC_CGO_TP_CD      = @[sprc_cgo_tp_cd]" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${scust} != '' && ${scust_seq} != '')" ).append("\n"); 
		query.append("    AND    1 = -1" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append(" ORDER BY TAA_NO, CUST_NM, SREP_CD, CMDT_NM" ).append("\n"); 

	}
}