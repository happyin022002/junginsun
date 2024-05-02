/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PRISimulationDBDAORsltSCContractInfoListRSQL.java
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

public class PRISimulationDBDAORsltSCContractInfoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GET SC CONTRACT INFO
	  * </pre>
	  */
	public PRISimulationDBDAORsltSCContractInfoListRSQL(){
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
		params.put("scust_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("scust",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : PRISimulationDBDAORsltSCContractInfoListRSQL").append("\n"); 
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
		query.append("        'S/C'                           AS CNTR_TP" ).append("\n"); 
		query.append("      , SH.SC_NO                        AS CNTR_NO" ).append("\n"); 
		query.append("      , CP.CTRT_PTY_NM                  AS CUST_NM" ).append("\n"); 
		query.append("      , NVL(" ).append("\n"); 
		query.append("       (SELECT LISTAGG(MC.CUST_LGL_ENG_NM, ' / ') WITHIN GROUP (ORDER BY AC.ACT_CUST_SEQ) AS ACT_CUST_NM" ).append("\n"); 
		query.append("        FROM   PRI_SP_SCP_RT_ACT_CUST  AC  ," ).append("\n"); 
		query.append("               MDM_CUSTOMER            MC" ).append("\n"); 
		query.append("        WHERE  MC.CUST_CNT_CD       = AC.CUST_CNT_CD" ).append("\n"); 
		query.append("        AND    MC.CUST_SEQ          = AC.CUST_SEQ" ).append("\n"); 
		query.append("        AND    MC.CNTR_DIV_FLG      = 'Y'" ).append("\n"); 
		query.append("        AND    AC.PROP_NO           = CH.PROP_NO" ).append("\n"); 
		query.append("        AND    AC.AMDT_SEQ          = CH.AMDT_SEQ" ).append("\n"); 
		query.append("        AND    AC.SVC_SCP_CD        = CH.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND    AC.GEN_SPCL_RT_TP_CD = CH.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("        AND    AC.CMDT_HDR_SEQ      = CH.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        AND    AC.SRC_INFO_CD       <> 'AD'" ).append("\n"); 
		query.append("        ), 'N/A')   AS ACT_CUST_NM" ).append("\n"); 
		query.append("      , SS.PROP_SCP_SREP_CD            AS SREP_CD " ).append("\n"); 
		query.append("      ,(SELECT LISTAGG(DECODE(RC.PRC_CMDT_TP_CD, 'C', MC.CMDT_NM, 'G', GC.PRC_GRP_CMDT_DESC), ' / ') WITHIN GROUP (ORDER BY RC.CMDT_SEQ)" ).append("\n"); 
		query.append("        FROM   PRI_SP_SCP_RT_CMDT  RC ," ).append("\n"); 
		query.append("               MDM_COMMODITY       MC ," ).append("\n"); 
		query.append("               PRI_SP_SCP_GRP_CMDT GC" ).append("\n"); 
		query.append("       WHERE   MC.CMDT_CD        (+) = RC.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("       AND     GC.PROP_NO        (+) = RC.PROP_NO" ).append("\n"); 
		query.append("       AND     GC.AMDT_SEQ       (+) = RC.AMDT_SEQ" ).append("\n"); 
		query.append("       AND     GC.SVC_SCP_CD     (+) = RC.SVC_SCP_CD" ).append("\n"); 
		query.append("       AND     GC.PRC_GRP_CMDT_CD(+) = RC.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("       AND     RC.SRC_INFO_CD        <> 'AD'" ).append("\n"); 
		query.append("       AND     RC.PROP_NO            = CH.PROP_NO" ).append("\n"); 
		query.append("       AND     RC.AMDT_SEQ           = CH.AMDT_SEQ" ).append("\n"); 
		query.append("       AND     RC.SVC_SCP_CD         = CH.SVC_SCP_CD" ).append("\n"); 
		query.append("       AND     RC.GEN_SPCL_RT_TP_CD  = CH.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("       AND     RC.CMDT_HDR_SEQ       = CH.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("     ) AS CMDT_NM" ).append("\n"); 
		query.append("     ,(SELECT LISTAGG(OP.ROUT_PNT_LOC_DEF_CD || NVL2(CD.INTG_CD_VAL_DP_DESC, '(' ||CD.INTG_CD_VAL_DP_DESC|| ')', ''), ';') WITHIN GROUP (ORDER BY OP.ROUT_SEQ, OP.ROUT_PNT_SEQ)" ).append("\n"); 
		query.append("       FROM   PRI_SP_SCP_RT_ROUT_PNT  OP, COM_INTG_CD_DTL CD" ).append("\n"); 
		query.append("       WHERE  OP.PROP_NO           = CR.PROP_NO" ).append("\n"); 
		query.append("       AND    OP.AMDT_SEQ          = CR.AMDT_SEQ" ).append("\n"); 
		query.append("       AND    OP.SVC_SCP_CD        = CR.SVC_SCP_CD" ).append("\n"); 
		query.append("       AND    OP.GEN_SPCL_RT_TP_CD = CR.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("       AND    OP.CMDT_HDR_SEQ      = CR.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("       AND    OP.ROUT_SEQ          = CR.ROUT_SEQ" ).append("\n"); 
		query.append("       AND    OP.ORG_DEST_TP_CD    = 'O'" ).append("\n"); 
		query.append("       AND    OP.SRC_INFO_CD       <> 'AD'" ).append("\n"); 
		query.append("       AND    CD.INTG_CD_ID        = 'CD02138' " ).append("\n"); 
		query.append("       AND    CD.INTG_CD_VAL_CTNT  = OP.RCV_DE_TERM_CD" ).append("\n"); 
		query.append("     ) AS ORG_CD " ).append("\n"); 
		query.append("     ,(SELECT LISTAGG(OV.ROUT_VIA_PORT_DEF_CD, ';') WITHIN GROUP (ORDER BY OV.ROUT_SEQ, OV.ROUT_VIA_SEQ)" ).append("\n"); 
		query.append("       FROM   PRI_SP_SCP_RT_ROUT_VIA  OV" ).append("\n"); 
		query.append("       WHERE  OV.PROP_NO           = CR.PROP_NO" ).append("\n"); 
		query.append("       AND    OV.AMDT_SEQ          = CR.AMDT_SEQ" ).append("\n"); 
		query.append("       AND    OV.SVC_SCP_CD        = CR.SVC_SCP_CD" ).append("\n"); 
		query.append("       AND    OV.GEN_SPCL_RT_TP_CD = CR.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("       AND    OV.CMDT_HDR_SEQ      = CR.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("       AND    OV.ROUT_SEQ          = CR.ROUT_SEQ" ).append("\n"); 
		query.append("       AND    OV.ORG_DEST_TP_CD    = 'O'" ).append("\n"); 
		query.append("       AND    OV.SRC_INFO_CD       <> 'AD'" ).append("\n"); 
		query.append("     ) AS ORG_VIA_CD " ).append("\n"); 
		query.append("     ,(SELECT LISTAGG(DV.ROUT_VIA_PORT_DEF_CD, ';') WITHIN GROUP (ORDER BY DV.ROUT_SEQ, DV.ROUT_VIA_SEQ)" ).append("\n"); 
		query.append("       FROM   PRI_SP_SCP_RT_ROUT_VIA  DV" ).append("\n"); 
		query.append("       WHERE  DV.PROP_NO           = CR.PROP_NO" ).append("\n"); 
		query.append("       AND    DV.AMDT_SEQ          = CR.AMDT_SEQ" ).append("\n"); 
		query.append("       AND    DV.SVC_SCP_CD        = CR.SVC_SCP_CD" ).append("\n"); 
		query.append("       AND    DV.GEN_SPCL_RT_TP_CD = CR.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("       AND    DV.CMDT_HDR_SEQ      = CR.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("       AND    DV.ROUT_SEQ          = CR.ROUT_SEQ" ).append("\n"); 
		query.append("       AND    DV.ORG_DEST_TP_CD    = 'D'" ).append("\n"); 
		query.append("       AND    DV.SRC_INFO_CD       <> 'AD'" ).append("\n"); 
		query.append("     ) AS DEST_VIA_CD " ).append("\n"); 
		query.append("     ,(SELECT LISTAGG(DP.ROUT_PNT_LOC_DEF_CD || NVL2(CD.INTG_CD_VAL_DP_DESC, '(' ||CD.INTG_CD_VAL_DP_DESC|| ')', ''), ';') WITHIN GROUP (ORDER BY DP.ROUT_SEQ, DP.ROUT_PNT_SEQ)" ).append("\n"); 
		query.append("       FROM   PRI_SP_SCP_RT_ROUT_PNT  DP, COM_INTG_CD_DTL CD" ).append("\n"); 
		query.append("       WHERE  DP.PROP_NO           = CR.PROP_NO" ).append("\n"); 
		query.append("       AND    DP.AMDT_SEQ          = CR.AMDT_SEQ" ).append("\n"); 
		query.append("       AND    DP.SVC_SCP_CD        = CR.SVC_SCP_CD" ).append("\n"); 
		query.append("       AND    DP.GEN_SPCL_RT_TP_CD = CR.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("       AND    DP.CMDT_HDR_SEQ      = CR.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("       AND    DP.ROUT_SEQ          = CR.ROUT_SEQ" ).append("\n"); 
		query.append("       AND    DP.ORG_DEST_TP_CD    = 'D'" ).append("\n"); 
		query.append("       AND    DP.SRC_INFO_CD       <> 'AD'" ).append("\n"); 
		query.append("       AND    CD.INTG_CD_ID        = 'CD02138' " ).append("\n"); 
		query.append("       AND    CD.INTG_CD_VAL_CTNT  = DP.RCV_DE_TERM_CD" ).append("\n"); 
		query.append("     ) AS DEST_CD " ).append("\n"); 
		query.append("     ,(SELECT LISTAGG(INTG_CD_VAL_CTNT, ';') WITHIN GROUP (ORDER BY CD.INTG_CD_VAL_DP_SEQ)  /* CGO_TP_CD의 UNIQUE한 집합의 문자열 결합을 만들기 위해 공통코드 테이블을 사용함 */" ).append("\n"); 
		query.append("       FROM   COM_INTG_CD_DTL CD" ).append("\n"); 
		query.append("       WHERE  CD.INTG_CD_ID  = 'CD01701'" ).append("\n"); 
		query.append("       AND    EXISTS" ).append("\n"); 
		query.append("              (SELECT 'X'" ).append("\n"); 
		query.append("               FROM   PRI_SP_SCP_RT           RT" ).append("\n"); 
		query.append("               WHERE  1=1" ).append("\n"); 
		query.append("               AND     RT.PROP_NO            = CR.PROP_NO" ).append("\n"); 
		query.append("               AND     RT.AMDT_SEQ           = CR.AMDT_SEQ" ).append("\n"); 
		query.append("               AND     RT.SVC_SCP_CD         = CR.SVC_SCP_CD" ).append("\n"); 
		query.append("               AND     RT.GEN_SPCL_RT_TP_CD  = CR.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("               AND     RT.CMDT_HDR_SEQ       = CR.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("               AND     RT.ROUT_SEQ           = CR.ROUT_SEQ" ).append("\n"); 
		query.append("               AND     RT.SRC_INFO_CD        <> 'AD'" ).append("\n"); 
		query.append("               AND     RT.PRC_CGO_TP_CD      = CD.INTG_CD_VAL_CTNT)" ).append("\n"); 
		query.append("      ) AS PRC_CGO_TP_CD  " ).append("\n"); 
		query.append("    FROM    PRI_SP_HDR              SH  ," ).append("\n"); 
		query.append("            PRI_SP_MN               SM  ," ).append("\n"); 
		query.append("            PRI_SP_CTRT_PTY         CP  ," ).append("\n"); 
		query.append("            PRI_SP_SCP_MN           SS  ," ).append("\n"); 
		query.append("            PRI_SP_SCP_MQC          SQ  ," ).append("\n"); 
		query.append("            PRI_SP_SCP_RT_CMDT_HDR  CH  ," ).append("\n"); 
		query.append("            PRI_SP_SCP_RT_CMDT_ROUT CR  " ).append("\n"); 
		query.append("    WHERE   SM.PROP_NO            = SH.PROP_NO" ).append("\n"); 
		query.append("    AND     SM.PROP_STS_CD        = 'F'" ).append("\n"); 
		query.append("    AND     CP.PROP_NO            = SM.PROP_NO" ).append("\n"); 
		query.append("    AND     CP.AMDT_SEQ           = SM.AMDT_SEQ" ).append("\n"); 
		query.append("    AND     CP.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("    AND     SS.PROP_NO            = SM.PROP_NO" ).append("\n"); 
		query.append("    AND     SS.AMDT_SEQ           = SM.AMDT_SEQ" ).append("\n"); 
		query.append("    AND     SQ.PROP_NO            = SS.PROP_NO" ).append("\n"); 
		query.append("    AND     SQ.AMDT_SEQ           = SS.AMDT_SEQ" ).append("\n"); 
		query.append("    AND     SQ.SVC_SCP_CD         = SS.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND     CH.PROP_NO            = SS.PROP_NO" ).append("\n"); 
		query.append("    AND     CH.AMDT_SEQ           = SS.AMDT_SEQ" ).append("\n"); 
		query.append("    AND     CH.SVC_SCP_CD         = SS.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND     CR.PROP_NO            = CH.PROP_NO" ).append("\n"); 
		query.append("    AND     CR.AMDT_SEQ           = CH.AMDT_SEQ" ).append("\n"); 
		query.append("    AND     CR.SVC_SCP_CD         = CH.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND     CR.GEN_SPCL_RT_TP_CD  = CH.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("    AND     CR.CMDT_HDR_SEQ       = CH.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    #if (${scontract_no} != '')" ).append("\n"); 
		query.append("    AND SH.SC_NO LIKE @[scontract_no]||'%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${sprop_scp_srep_cd} != '')" ).append("\n"); 
		query.append("    AND SS.PROP_SCP_SREP_CD = @[sprop_scp_srep_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${sprc_ctrt_cust_tp_cd} != '')" ).append("\n"); 
		query.append("    AND     EXISTS" ).append("\n"); 
		query.append("           (SELECT 'X'" ).append("\n"); 
		query.append("            FROM   PRI_SP_CTRT_CUST_TP     CT" ).append("\n"); 
		query.append("            WHERE  1=1" ).append("\n"); 
		query.append("            AND    CT.PROP_NO            = CP.PROP_NO" ).append("\n"); 
		query.append("            AND    CT.AMDT_SEQ           = CP.AMDT_SEQ" ).append("\n"); 
		query.append("            AND    CT.PRC_CTRT_PTY_TP_CD = CP.PRC_CTRT_PTY_TP_CD" ).append("\n"); 
		query.append("            AND    CT.PRC_CTRT_CUST_TP_CD  = @[sprc_ctrt_cust_tp_cd]" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${sprop_scp_ofc_cd} != '')" ).append("\n"); 
		query.append("    AND SS.PROP_SCP_OFC_CD   = @[sprop_scp_ofc_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${srout_pnt_loc_def_cd_ori} != '')" ).append("\n"); 
		query.append("    AND     EXISTS" ).append("\n"); 
		query.append("           (SELECT 'X'" ).append("\n"); 
		query.append("            FROM   PRI_SP_SCP_RT_ROUT_PNT  OP" ).append("\n"); 
		query.append("            WHERE  1=1" ).append("\n"); 
		query.append("            AND     OP.PROP_NO            = CR.PROP_NO" ).append("\n"); 
		query.append("            AND     OP.AMDT_SEQ           = CR.AMDT_SEQ" ).append("\n"); 
		query.append("            AND     OP.SVC_SCP_CD         = CR.SVC_SCP_CD" ).append("\n"); 
		query.append("            AND     OP.CMDT_HDR_SEQ       = CR.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("            AND     OP.GEN_SPCL_RT_TP_CD  = CR.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("            AND     OP.ROUT_SEQ           = CR.ROUT_SEQ" ).append("\n"); 
		query.append("            AND     OP.ORG_DEST_TP_CD     = 'O'" ).append("\n"); 
		query.append("            AND     OP.SRC_INFO_CD        <> 'AD'" ).append("\n"); 
		query.append("            AND    (OP.ROUT_PNT_LOC_DEF_CD LIKE @[srout_pnt_loc_def_cd_ori]||'%'" ).append("\n"); 
		query.append("                    OR EXISTS " ).append("\n"); 
		query.append("                       (SELECT	    'X'" ).append("\n"); 
		query.append("                        FROM		PRI_SP_SCP_GRP_LOC		GL	," ).append("\n"); 
		query.append("                                    PRI_SP_SCP_GRP_LOC_DTL	GD" ).append("\n"); 
		query.append("                        WHERE		GD.PROP_NO			= GL.PROP_NO" ).append("\n"); 
		query.append("                        AND			GD.AMDT_SEQ			= GL.AMDT_SEQ" ).append("\n"); 
		query.append("                        AND			GD.SVC_SCP_CD		= GL.SVC_SCP_CD" ).append("\n"); 
		query.append("                        AND			GD.GRP_LOC_SEQ		= GL.GRP_LOC_SEQ" ).append("\n"); 
		query.append("                        AND			GL.PROP_NO			= OP.PROP_NO" ).append("\n"); 
		query.append("                        AND			GL.AMDT_SEQ			= OP.AMDT_SEQ" ).append("\n"); 
		query.append("                        AND			GL.SVC_SCP_CD		= OP.SVC_SCP_CD" ).append("\n"); 
		query.append("                        AND			GD.SRC_INFO_CD		<> 'AD'" ).append("\n"); 
		query.append("                        AND         GL.PRC_GRP_LOC_CD   = OP.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                        AND         OP.ROUT_PNT_LOC_TP_CD = 'G' " ).append("\n"); 
		query.append("                        AND			GD.LOC_CD           LIKE @[srout_pnt_loc_def_cd_ori]||'%' -- Origin" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${srout_pnt_loc_def_cd_dest} != '')" ).append("\n"); 
		query.append("    AND     EXISTS" ).append("\n"); 
		query.append("           (SELECT 'X'" ).append("\n"); 
		query.append("            FROM   PRI_SP_SCP_RT_ROUT_PNT  DP" ).append("\n"); 
		query.append("            WHERE  1=1" ).append("\n"); 
		query.append("            AND     DP.PROP_NO            = CR.PROP_NO" ).append("\n"); 
		query.append("            AND     DP.AMDT_SEQ           = CR.AMDT_SEQ" ).append("\n"); 
		query.append("            AND     DP.SVC_SCP_CD         = CR.SVC_SCP_CD" ).append("\n"); 
		query.append("            AND     DP.GEN_SPCL_RT_TP_CD  = DP.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("            AND     DP.CMDT_HDR_SEQ       = CR.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("            AND     DP.ROUT_SEQ           = CR.ROUT_SEQ" ).append("\n"); 
		query.append("            AND     DP.ORG_DEST_TP_CD     = 'D'" ).append("\n"); 
		query.append("            AND     DP.SRC_INFO_CD        <> 'AD'" ).append("\n"); 
		query.append("            AND    (DP.ROUT_PNT_LOC_DEF_CD LIKE @[srout_pnt_loc_def_cd_dest]||'%'" ).append("\n"); 
		query.append("                    OR EXISTS " ).append("\n"); 
		query.append("                       (SELECT	    'X'" ).append("\n"); 
		query.append("                        FROM		PRI_SP_SCP_GRP_LOC		GL	," ).append("\n"); 
		query.append("                                    PRI_SP_SCP_GRP_LOC_DTL	GD" ).append("\n"); 
		query.append("                        WHERE		GD.PROP_NO			= GL.PROP_NO" ).append("\n"); 
		query.append("                        AND			GD.AMDT_SEQ			= GL.AMDT_SEQ" ).append("\n"); 
		query.append("                        AND			GD.SVC_SCP_CD		= GL.SVC_SCP_CD" ).append("\n"); 
		query.append("                        AND			GD.GRP_LOC_SEQ		= GL.GRP_LOC_SEQ" ).append("\n"); 
		query.append("                        AND			GL.PROP_NO			= DP.PROP_NO" ).append("\n"); 
		query.append("                        AND			GL.AMDT_SEQ			= DP.AMDT_SEQ" ).append("\n"); 
		query.append("                        AND			GL.SVC_SCP_CD		= DP.SVC_SCP_CD" ).append("\n"); 
		query.append("                        AND			GD.SRC_INFO_CD		<> 'AD'" ).append("\n"); 
		query.append("                        AND         GL.PRC_GRP_LOC_CD   = DP.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                        AND         DP.ROUT_PNT_LOC_TP_CD = 'G' " ).append("\n"); 
		query.append("                        AND			GD.LOC_CD           LIKE @[srout_pnt_loc_def_cd_dest]||'%'" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${srout_via_port_def_cd_ori} != '')" ).append("\n"); 
		query.append("    AND     EXISTS" ).append("\n"); 
		query.append("           (SELECT 'X'" ).append("\n"); 
		query.append("            FROM   PRI_SP_SCP_RT_ROUT_VIA  OV" ).append("\n"); 
		query.append("            WHERE  1=1" ).append("\n"); 
		query.append("            AND     OV.PROP_NO           = CR.PROP_NO" ).append("\n"); 
		query.append("            AND     OV.AMDT_SEQ          = CR.AMDT_SEQ" ).append("\n"); 
		query.append("            AND     OV.SVC_SCP_CD        = CR.SVC_SCP_CD" ).append("\n"); 
		query.append("            AND     OV.GEN_SPCL_RT_TP_CD = CR.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("            AND     OV.CMDT_HDR_SEQ      = CR.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("            AND     OV.ROUT_SEQ          = CR.ROUT_SEQ" ).append("\n"); 
		query.append("            AND     OV.ORG_DEST_TP_CD    = 'O'" ).append("\n"); 
		query.append("            AND     OV.SRC_INFO_CD       <> 'AD'" ).append("\n"); 
		query.append("            AND    (OV.ROUT_VIA_PORT_DEF_CD LIKE @[srout_via_port_def_cd_ori]||'%'" ).append("\n"); 
		query.append("                    OR EXISTS " ).append("\n"); 
		query.append("                       (SELECT	    'X'" ).append("\n"); 
		query.append("                        FROM		PRI_SP_SCP_GRP_LOC		GL	," ).append("\n"); 
		query.append("                                    PRI_SP_SCP_GRP_LOC_DTL	GD" ).append("\n"); 
		query.append("                        WHERE		GD.PROP_NO			= GL.PROP_NO" ).append("\n"); 
		query.append("                        AND			GD.AMDT_SEQ			= GL.AMDT_SEQ" ).append("\n"); 
		query.append("                        AND			GD.SVC_SCP_CD		= GL.SVC_SCP_CD" ).append("\n"); 
		query.append("                        AND			GD.GRP_LOC_SEQ		= GL.GRP_LOC_SEQ" ).append("\n"); 
		query.append("                        AND			GL.PROP_NO			= OV.PROP_NO" ).append("\n"); 
		query.append("                        AND			GL.AMDT_SEQ			= OV.AMDT_SEQ" ).append("\n"); 
		query.append("                        AND			GL.SVC_SCP_CD		= OV.SVC_SCP_CD" ).append("\n"); 
		query.append("                        AND			GD.SRC_INFO_CD		<> 'AD'" ).append("\n"); 
		query.append("                        AND         GL.PRC_GRP_LOC_CD   = OV.ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("                        AND         OV.ROUT_VIA_PORT_TP_CD = 'G' " ).append("\n"); 
		query.append("                        AND			GD.LOC_CD           LIKE @[srout_via_port_def_cd_ori]||'%'" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${srout_via_port_def_cd_dest} != '')" ).append("\n"); 
		query.append("    AND     EXISTS" ).append("\n"); 
		query.append("           (SELECT 'X'" ).append("\n"); 
		query.append("            FROM   PRI_SP_SCP_RT_ROUT_VIA  DV" ).append("\n"); 
		query.append("            WHERE  1=1" ).append("\n"); 
		query.append("            AND     DV.PROP_NO           = CR.PROP_NO" ).append("\n"); 
		query.append("            AND     DV.AMDT_SEQ          = CR.AMDT_SEQ" ).append("\n"); 
		query.append("            AND     DV.SVC_SCP_CD        = CR.SVC_SCP_CD" ).append("\n"); 
		query.append("            AND     DV.GEN_SPCL_RT_TP_CD = CR.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("            AND     DV.CMDT_HDR_SEQ      = CR.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("            AND     DV.ROUT_SEQ          = CR.ROUT_SEQ" ).append("\n"); 
		query.append("            AND     DV.ORG_DEST_TP_CD    = 'D'" ).append("\n"); 
		query.append("            AND     DV.SRC_INFO_CD       <> 'AD'" ).append("\n"); 
		query.append("            AND    (DV.ROUT_VIA_PORT_DEF_CD LIKE @[srout_via_port_def_cd_dest]||'%'" ).append("\n"); 
		query.append("                    OR EXISTS " ).append("\n"); 
		query.append("                       (SELECT	    'X'" ).append("\n"); 
		query.append("                        FROM		PRI_SP_SCP_GRP_LOC		GL	," ).append("\n"); 
		query.append("                                    PRI_SP_SCP_GRP_LOC_DTL	GD" ).append("\n"); 
		query.append("                        WHERE		GD.PROP_NO			= GL.PROP_NO" ).append("\n"); 
		query.append("                        AND			GD.AMDT_SEQ			= GL.AMDT_SEQ" ).append("\n"); 
		query.append("                        AND			GD.SVC_SCP_CD		= GL.SVC_SCP_CD" ).append("\n"); 
		query.append("                        AND			GD.GRP_LOC_SEQ		= GL.GRP_LOC_SEQ" ).append("\n"); 
		query.append("                        AND			GL.PROP_NO			= DV.PROP_NO" ).append("\n"); 
		query.append("                        AND			GL.AMDT_SEQ			= DV.AMDT_SEQ" ).append("\n"); 
		query.append("                        AND			GL.SVC_SCP_CD		= DV.SVC_SCP_CD" ).append("\n"); 
		query.append("                        AND			GD.SRC_INFO_CD		<> 'AD'" ).append("\n"); 
		query.append("                        AND         GL.PRC_GRP_LOC_CD   = DV.ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("                        AND         DV.ROUT_VIA_PORT_TP_CD = 'G' " ).append("\n"); 
		query.append("                        AND			GD.LOC_CD           LIKE @[srout_via_port_def_cd_dest]||'%'" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${sprc_cgo_tp_cd} != '')" ).append("\n"); 
		query.append("    AND     EXISTS" ).append("\n"); 
		query.append("           (SELECT 'X'" ).append("\n"); 
		query.append("            FROM   PRI_SP_SCP_RT           RT" ).append("\n"); 
		query.append("            WHERE  1=1" ).append("\n"); 
		query.append("            AND     RT.PROP_NO            = CR.PROP_NO" ).append("\n"); 
		query.append("            AND     RT.AMDT_SEQ           = CR.AMDT_SEQ" ).append("\n"); 
		query.append("            AND     RT.SVC_SCP_CD         = CR.SVC_SCP_CD" ).append("\n"); 
		query.append("            AND     RT.GEN_SPCL_RT_TP_CD  = CR.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("            AND     RT.CMDT_HDR_SEQ       = CR.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("            AND     RT.ROUT_SEQ           = CR.ROUT_SEQ" ).append("\n"); 
		query.append("            AND     RT.SRC_INFO_CD        <> 'AD'" ).append("\n"); 
		query.append("            AND     RT.PRC_CGO_TP_CD      = @[sprc_cgo_tp_cd]" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${scust} != '' && ${scust_seq} != '')" ).append("\n"); 
		query.append("    AND     EXISTS" ).append("\n"); 
		query.append("           (SELECT 'X'" ).append("\n"); 
		query.append("            FROM   PRI_SP_SCP_RT_ACT_CUST  AC " ).append("\n"); 
		query.append("            WHERE  1=1" ).append("\n"); 
		query.append("            AND     AC.PROP_NO           = CR.PROP_NO" ).append("\n"); 
		query.append("            AND     AC.AMDT_SEQ          = CR.AMDT_SEQ" ).append("\n"); 
		query.append("            AND     AC.SVC_SCP_CD        = CR.SVC_SCP_CD" ).append("\n"); 
		query.append("            AND     AC.GEN_SPCL_RT_TP_CD = CR.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("            AND     AC.CMDT_HDR_SEQ      = CR.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("            AND     AC.SRC_INFO_CD       <> 'AD'" ).append("\n"); 
		query.append("            AND     AC.CUST_CNT_CD       = @[scust]" ).append("\n"); 
		query.append("            AND     AC.CUST_SEQ          = @[scust_seq]" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    AND     TO_DATE ( @[seff_dt],'YYYY-MM-DD' ) BETWEEN SS.EFF_DT AND SS.EXP_DT " ).append("\n"); 
		query.append("    AND     SM.AMDT_SEQ = (SELECT MAX ( M.AMDT_SEQ ) " ).append("\n"); 
		query.append("                             FROM PRI_SP_MN M " ).append("\n"); 
		query.append("                            WHERE M.PROP_NO = SH.PROP_NO " ).append("\n"); 
		query.append("                              AND TO_DATE ( @[seff_dt],'YYYY-MM-DD' ) BETWEEN M.EFF_DT AND M.EXP_DT AND M.PROP_STS_CD = 'F')  " ).append("\n"); 
		query.append("    AND     SS.SVC_SCP_CD = @[ssvc_scp_cd]" ).append("\n"); 
		query.append("    #if (${sctrt_cust} != '' && ${sctrt_cust_seq} != '')" ).append("\n"); 
		query.append("    AND      CP.CUST_CNT_CD          = @[sctrt_cust]" ).append("\n"); 
		query.append("    AND      CP.CUST_SEQ             = @[sctrt_cust_seq]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append(" ORDER BY SC_NO, CTRT_PTY_NM, ACT_CUST_NM, PROP_SCP_SREP_CD, CMDT_NM" ).append("\n"); 

	}
}