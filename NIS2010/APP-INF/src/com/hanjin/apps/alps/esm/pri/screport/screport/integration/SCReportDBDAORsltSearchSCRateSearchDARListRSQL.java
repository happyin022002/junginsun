/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCReportDBDAORsltSearchSCRateSearchDARListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.09.14 김대호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author day-hoh Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCReportDBDAORsltSearchSCRateSearchDARListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * US Rpute Cost Inquiry List
	  * </pre>
	  */
	public SCReportDBDAORsltSearchSCRateSearchDARListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_hdr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_spcl_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rt_seq",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.screport.screport.integration").append("\n"); 
		query.append("FileName : SCReportDBDAORsltSearchSCRateSearchDARListRSQL").append("\n"); 
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
		query.append("WITH" ).append("\n"); 
		query.append("AR AS   (" ).append("\n"); 
		query.append("SELECT  @[prop_no] PROP_NO                     ," ).append("\n"); 
		query.append("TO_NUMBER(@[amdt_seq])                       AMDT_SEQ                    ," ).append("\n"); 
		query.append("@[svc_scp_cd]               SVC_SCP_CD              ," ).append("\n"); 
		query.append("@[gen_spcl_rt_tp_cd]                GEN_SPCL_RT_TP_CD   ," ).append("\n"); 
		query.append("TO_NUMBER(@[cmdt_hdr_seq])                      CMDT_HDR_SEQ            ," ).append("\n"); 
		query.append("TO_NUMBER(@[rout_seq])                      ROUT_SEQ                    ," ).append("\n"); 
		query.append("TO_NUMBER(@[rt_seq])                      RT_SEQ" ).append("\n"); 
		query.append("FROM        DUAL" ).append("\n"); 
		query.append(")   ," ).append("\n"); 
		query.append("GC AS (" ).append("\n"); 
		query.append("SELECT  G.PRC_GRP_CMDT_CD           ," ).append("\n"); 
		query.append("D.PRC_CMDT_TP_CD            ," ).append("\n"); 
		query.append("D.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("FROM        AR  ," ).append("\n"); 
		query.append("PRI_SP_SCP_GRP_CMDT         G   ," ).append("\n"); 
		query.append("PRI_SP_SCP_GRP_CMDT_DTL D" ).append("\n"); 
		query.append("WHERE       D.PROP_NO                   = G.PROP_NO" ).append("\n"); 
		query.append("AND         D.AMDT_SEQ              = G.AMDT_SEQ" ).append("\n"); 
		query.append("AND         D.SVC_SCP_CD            = G.SVC_SCP_CD" ).append("\n"); 
		query.append("AND         D.GRP_CMDT_SEQ      = G.GRP_CMDT_SEQ" ).append("\n"); 
		query.append("AND         G.PROP_NO                   = AR.PROP_NO" ).append("\n"); 
		query.append("AND         G.AMDT_SEQ              = AR.AMDT_SEQ" ).append("\n"); 
		query.append("AND         G.SVC_SCP_CD            = AR.SVC_SCP_CD" ).append("\n"); 
		query.append(")   ," ).append("\n"); 
		query.append("GL AS (" ).append("\n"); 
		query.append("SELECT  G.PRC_GRP_LOC_CD    ," ).append("\n"); 
		query.append("D.LOC_CD" ).append("\n"); 
		query.append("FROM        AR  ," ).append("\n"); 
		query.append("PRI_SP_SCP_GRP_LOC          G   ," ).append("\n"); 
		query.append("PRI_SP_SCP_GRP_LOC_DTL  D" ).append("\n"); 
		query.append("WHERE       D.PROP_NO                   = G.PROP_NO" ).append("\n"); 
		query.append("AND         D.AMDT_SEQ              = G.AMDT_SEQ" ).append("\n"); 
		query.append("AND         D.SVC_SCP_CD            = G.SVC_SCP_CD" ).append("\n"); 
		query.append("AND         D.GRP_LOC_SEQ           = G.GRP_LOC_SEQ" ).append("\n"); 
		query.append("AND         G.PROP_NO                   = AR.PROP_NO" ).append("\n"); 
		query.append("AND         G.AMDT_SEQ              = AR.AMDT_SEQ" ).append("\n"); 
		query.append("AND         G.SVC_SCP_CD            = AR.SVC_SCP_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  DE.FM_LOC_CD                ," ).append("\n"); 
		query.append("DE.HUB_LOC_CD               ," ).append("\n"); 
		query.append("DA.PRC_TRSP_MOD_CD  ," ).append("\n"); 
		query.append("DA.RCV_DE_TERM_CD       ," ).append("\n"); 
		query.append("DA.RAT_UT_CD                ," ).append("\n"); 
		query.append("DA.CURR_CD                  ," ).append("\n"); 
		query.append("DA.FNL_FRT_RT_AMT ," ).append("\n"); 
		query.append("'' AS PROP_NO           , -- param" ).append("\n"); 
		query.append("'' AS AMDT_SEQ          , -- param" ).append("\n"); 
		query.append("'' AS SVC_SCP_CD        , -- param" ).append("\n"); 
		query.append("'' AS GEN_SPCL_RT_TP_CD , -- param" ).append("\n"); 
		query.append("'' AS CMDT_HDR_SEQ      , -- param" ).append("\n"); 
		query.append("'' AS ROUT_SEQ          , -- param" ).append("\n"); 
		query.append("'' AS RT_SEQ              -- param" ).append("\n"); 
		query.append("FROM        AR                                  ," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  DISTINCT" ).append("\n"); 
		query.append("RT.FM_LOC_CD        ," ).append("\n"); 
		query.append("SUBSTR(IR.HUB_NOD_CD, 1, 5)     HUB_LOC_CD  ," ).append("\n"); 
		query.append("RT.RAT_UT_CD        ," ).append("\n"); 
		query.append("( SELECT A.CNTR_SZ_CD FROM PRI_RAT_UT A WHERE A.RAT_UT_CD = RT.RAT_UT_CD ) CNTR_SZ_CD   ," ).append("\n"); 
		query.append("RT.PRC_CGO_TP_CD" ).append("\n"); 
		query.append("FROM        (" ).append("\n"); 
		query.append("SELECT  DECODE(DV.ROUT_VIA_PORT_TP_CD, 'L', DV.ROUT_VIA_PORT_DEF_CD, D1.LOC_CD) FM_LOC_CD   ," ).append("\n"); 
		query.append("DECODE(DP.ROUT_PNT_LOC_TP_CD, 'L', DP.ROUT_PNT_LOC_DEF_CD, D2.LOC_CD)       TO_LOC_CD   ," ).append("\n"); 
		query.append("RT.RAT_UT_CD    ," ).append("\n"); 
		query.append("RT.PRC_CGO_TP_CD" ).append("\n"); 
		query.append("FROM        AR                                                  ," ).append("\n"); 
		query.append("PRI_SP_SCP_RT_CMDT_ROUT CR  ," ).append("\n"); 
		query.append("PRI_SP_SCP_RT_ROUT_VIA  DV  ," ).append("\n"); 
		query.append("PRI_SP_SCP_RT_ROUT_PNT  DP  ," ).append("\n"); 
		query.append("PRI_SP_SCP_GRP_LOC          G1  ," ).append("\n"); 
		query.append("PRI_SP_SCP_GRP_LOC_DTL  D1  ," ).append("\n"); 
		query.append("PRI_SP_SCP_GRP_LOC          G2  ," ).append("\n"); 
		query.append("PRI_SP_SCP_GRP_LOC_DTL  D2  ," ).append("\n"); 
		query.append("PRI_SP_SCP_RT                       RT" ).append("\n"); 
		query.append("WHERE       DV.PROP_NO                      =   CR.PROP_NO" ).append("\n"); 
		query.append("AND         DV.AMDT_SEQ                     = CR.AMDT_SEQ" ).append("\n"); 
		query.append("AND         DV.SVC_SCP_CD                   = CR.SVC_SCP_CD" ).append("\n"); 
		query.append("AND         DV.GEN_SPCL_RT_TP_CD    = CR.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("AND         DV.CMDT_HDR_SEQ             = CR.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND         DV.ROUT_SEQ                     = CR.ROUT_SEQ" ).append("\n"); 
		query.append("AND         DV.ORG_DEST_TP_CD           = 'D'" ).append("\n"); 
		query.append("AND         DP.PROP_NO                      =   CR.PROP_NO" ).append("\n"); 
		query.append("AND         DP.AMDT_SEQ                     = CR.AMDT_SEQ" ).append("\n"); 
		query.append("AND         DP.SVC_SCP_CD                   = CR.SVC_SCP_CD" ).append("\n"); 
		query.append("AND         DP.GEN_SPCL_RT_TP_CD    = CR.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("AND         DP.CMDT_HDR_SEQ             = CR.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND         DP.ROUT_SEQ                     = CR.ROUT_SEQ" ).append("\n"); 
		query.append("AND         DP.ORG_DEST_TP_CD           = 'D'" ).append("\n"); 
		query.append("AND         G1.PROP_NO(+)                   = DV.PROP_NO" ).append("\n"); 
		query.append("AND         G1.AMDT_SEQ(+)              = DV.AMDT_SEQ" ).append("\n"); 
		query.append("AND         G1.SVC_SCP_CD(+)            = DV.SVC_SCP_CD" ).append("\n"); 
		query.append("AND         G1.PRC_GRP_LOC_CD(+)    = DV.ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("AND         D1.PROP_NO(+)                   = G1.PROP_NO" ).append("\n"); 
		query.append("AND         D1.AMDT_SEQ(+)              = G1.AMDT_SEQ" ).append("\n"); 
		query.append("AND         D1.SVC_SCP_CD(+)            = G1.SVC_SCP_CD" ).append("\n"); 
		query.append("AND         D1.GRP_LOC_SEQ(+)           = G1.GRP_LOC_SEQ" ).append("\n"); 
		query.append("AND         G2.PROP_NO(+)                   = DP.PROP_NO" ).append("\n"); 
		query.append("AND         G2.AMDT_SEQ(+)              = DP.AMDT_SEQ" ).append("\n"); 
		query.append("AND         G2.SVC_SCP_CD(+)            = DP.SVC_SCP_CD" ).append("\n"); 
		query.append("AND         G2.PRC_GRP_LOC_CD(+)    = DP.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("AND         D2.PROP_NO(+)                   = G2.PROP_NO" ).append("\n"); 
		query.append("AND         D2.AMDT_SEQ(+)              = G2.AMDT_SEQ" ).append("\n"); 
		query.append("AND         D2.SVC_SCP_CD(+)            = G2.SVC_SCP_CD" ).append("\n"); 
		query.append("AND         D2.GRP_LOC_SEQ(+)           = G2.GRP_LOC_SEQ" ).append("\n"); 
		query.append("AND         RT.PROP_NO                      =   CR.PROP_NO" ).append("\n"); 
		query.append("AND         RT.AMDT_SEQ                     = CR.AMDT_SEQ" ).append("\n"); 
		query.append("AND         RT.SVC_SCP_CD                   = CR.SVC_SCP_CD" ).append("\n"); 
		query.append("AND         RT.GEN_SPCL_RT_TP_CD    = CR.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("AND         RT.CMDT_HDR_SEQ             = CR.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND         RT.ROUT_SEQ                     = CR.ROUT_SEQ" ).append("\n"); 
		query.append("/* 조회 조건 */" ).append("\n"); 
		query.append("AND         CR.PROP_NO                      = AR.PROP_NO" ).append("\n"); 
		query.append("AND         CR.AMDT_SEQ                     = AR.AMDT_SEQ" ).append("\n"); 
		query.append("AND         CR.SVC_SCP_CD                   = AR.SVC_SCP_CD" ).append("\n"); 
		query.append("AND         CR.GEN_SPCL_RT_TP_CD    = AR.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("AND         CR.CMDT_HDR_SEQ             = AR.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND         CR.ROUT_SEQ                     = AR.ROUT_SEQ" ).append("\n"); 
		query.append("AND         RT.RT_SEQ                           = AR.RT_SEQ" ).append("\n"); 
		query.append(") RT    ," ).append("\n"); 
		query.append("PRD_INLND_ROUT_MST          IR" ).append("\n"); 
		query.append("WHERE       IR.ROUT_ORG_NOD_CD  LIKE RT.FM_LOC_CD||'%'" ).append("\n"); 
		query.append("AND         IR.ROUT_DEST_NOD_CD LIKE RT.TO_LOC_CD||'%'" ).append("\n"); 
		query.append("AND         IR.PRIO_SEQ                     = '1'" ).append("\n"); 
		query.append("AND         IR.PCTL_IO_BND_CD           = 'I'" ).append("\n"); 
		query.append("AND         NVL(IR.DELT_FLG, 'N')   = 'N'" ).append("\n"); 
		query.append(")   DE  ," ).append("\n"); 
		query.append("PRI_SP_SCP_TRSP_ADD_CHG DA" ).append("\n"); 
		query.append("WHERE       DA.PROP_NO                      =   AR.PROP_NO" ).append("\n"); 
		query.append("AND         DA.AMDT_SEQ                     = AR.AMDT_SEQ" ).append("\n"); 
		query.append("AND         DA.SVC_SCP_CD                   = AR.SVC_SCP_CD" ).append("\n"); 
		query.append("AND         DA.ADD_CHG_TP_CD            = 'A'" ).append("\n"); 
		query.append("AND         DA.ORG_DEST_TP_CD           = 'D'" ).append("\n"); 
		query.append("/* DEST ARB COMMODITY */" ).append("\n"); 
		query.append("AND         (" ).append("\n"); 
		query.append("DA.PRC_CMDT_DEF_CD  IS NULL" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("EXISTS  (" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  DA.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("FROM        DUAL" ).append("\n"); 
		query.append("WHERE       DA.PRC_CMDT_TP_CD   = 'C'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  GC.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("FROM        GC" ).append("\n"); 
		query.append("WHERE       GC.PRC_GRP_CMDT_CD  = DA.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("AND         GC.PRC_CMDT_TP_CD       = 'C'" ).append("\n"); 
		query.append("AND         DA.PRC_CMDT_TP_CD       = 'G'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("INTERSECT" ).append("\n"); 
		query.append("SELECT  DECODE(RC.PRC_CMDT_TP_CD, 'C', RC.PRC_CMDT_DEF_CD, 'G', GC.PRC_CMDT_DEF_CD)" ).append("\n"); 
		query.append("FROM        PRI_SP_SCP_RT_CMDT  RC  ," ).append("\n"); 
		query.append("GC" ).append("\n"); 
		query.append("WHERE       RC.PROP_NO                      =   AR.PROP_NO" ).append("\n"); 
		query.append("AND         RC.AMDT_SEQ                     = AR.AMDT_SEQ" ).append("\n"); 
		query.append("AND         RC.SVC_SCP_CD                   = AR.SVC_SCP_CD" ).append("\n"); 
		query.append("AND         RC.GEN_SPCL_RT_TP_CD    = AR.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("AND         RC.CMDT_HDR_SEQ             = AR.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND         GC.PRC_GRP_CMDT_CD(+)   = RC.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("AND         GC.PRC_CMDT_TP_CD           = 'C'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("/* ROUTE ( FM LOC ) */" ).append("\n"); 
		query.append("AND         (" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("DA.BSE_PORT_TP_CD = 'L'" ).append("\n"); 
		query.append("AND DE.FM_LOC_CD            = DA.BSE_PORT_DEF_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("DA.BSE_PORT_TP_CD = 'G'" ).append("\n"); 
		query.append("AND EXISTS  (" ).append("\n"); 
		query.append("SELECT  'X'" ).append("\n"); 
		query.append("FROM        GL" ).append("\n"); 
		query.append("WHERE       GL.PRC_GRP_LOC_CD   = DA.BSE_PORT_DEF_CD" ).append("\n"); 
		query.append("AND         GL.LOC_CD                   = DE.FM_LOC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("/* ROUTE ( HUB LOC ) */" ).append("\n"); 
		query.append("AND         (" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("DA.ROUT_PNT_LOC_TP_CD = 'L'" ).append("\n"); 
		query.append("AND DE.HUB_LOC_CD                   = DA.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("DA.ROUT_PNT_LOC_TP_CD = 'G'" ).append("\n"); 
		query.append("AND EXISTS  (" ).append("\n"); 
		query.append("SELECT  'X'" ).append("\n"); 
		query.append("FROM        GL" ).append("\n"); 
		query.append("WHERE       GL.PRC_GRP_LOC_CD   = DA.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("AND         GL.LOC_CD                   = DE.HUB_LOC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("/* DEST ARB RATING UNIT */" ).append("\n"); 
		query.append("AND         (" ).append("\n"); 
		query.append("DA.RAT_UT_CD    = DE.RAT_UT_CD" ).append("\n"); 
		query.append("OR  DA.RAT_UT_CD    = 'BX'" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("DA.RAT_UT_CD    IN ( '20', '40', 'HC', '45', '53' )" ).append("\n"); 
		query.append("AND ( SELECT A.CNTR_SZ_CD FROM PRI_RAT_UT A WHERE A.RAT_UT_CD = DA.RAT_UT_CD )  = DE.CNTR_SZ_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("/* DEST ARB CARGO TYPE */" ).append("\n"); 
		query.append("AND         DA.PRC_CGO_TP_CD    = DE.PRC_CGO_TP_CD" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("DE.FM_LOC_CD                ," ).append("\n"); 
		query.append("DE.HUB_LOC_CD               ," ).append("\n"); 
		query.append("DA.PRC_TRSP_MOD_CD  ," ).append("\n"); 
		query.append("DA.RCV_DE_TERM_CD       ," ).append("\n"); 
		query.append("DA.RAT_UT_CD" ).append("\n"); 

	}
}