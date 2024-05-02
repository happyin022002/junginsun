/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCRateProposalDBDAOPriSpScpRtScgAmtCostDetailVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.04
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.02.04 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCRateProposalDBDAOPriSpScpRtScgAmtCostDetailVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public SCRateProposalDBDAOPriSpScpRtScgAmtCostDetailVOCSQL(){
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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.integration").append("\n"); 
		query.append("FileName : SCRateProposalDBDAOPriSpScpRtScgAmtCostDetailVOCSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("MERGE INTO PRI_SP_SCP_RT_SCG A" ).append("\n"); 
		query.append("USING ( " ).append("\n"); 
		query.append("		SELECT  PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ, RT_SEQ, " ).append("\n"); 
		query.append("		        BKG_RAT_UT_CD, PRC_CGO_TP_CD, CHG_CD, CURR_CD, ADJ_SCG_AMT, ADJ_SCG_USD_AMT" ).append("\n"); 
		query.append("		  FROM  ( " ).append("\n"); 
		query.append("		        SELECT MN.PROP_NO, MN.AMDT_SEQ, MN.SVC_SCP_CD, MN.GEN_SPCL_RT_TP_CD, MN.CMDT_HDR_SEQ, MN.ROUT_SEQ, MN.RT_SEQ, " ).append("\n"); 
		query.append("		               NVL(SCG_ADJ.BKG_RAT_UT_CD, MN.RAT_UT_CD) AS BKG_RAT_UT_CD, NVL(SCG_ADJ.PRC_CGO_TP_CD, MN.PRC_CGO_TP_CD) PRC_CGO_TP_CD, SCG_ADJ.CHG_CD, SCG_ADJ.CURR_CD,                 SCG_ADJ.ADJ_SCG_AMT, SCG_ADJ.ADJ_SCG_USD_AMT," ).append("\n"); 
		query.append("		               ROW_NUMBER() OVER( PARTITION BY MN.CMDT_HDR_SEQ, MN.ROUT_SEQ, MN.RT_SEQ, SCG_ADJ.CHG_CD, SCG_ADJ.CURR_CD ORDER BY SCG_ADJ.MAPG_SCRE DESC ) NUM  " ).append("\n"); 
		query.append("		          FROM (" ).append("\n"); 
		query.append("		                SELECT ROWNUM," ).append("\n"); 
		query.append("		                       MN.PROP_NO, MN.AMDT_SEQ, MN.SVC_SCP_CD, MN.GEN_SPCL_RT_TP_CD, MN.CMDT_HDR_SEQ, MN.ROUT_SEQ, RT.RT_SEQ, " ).append("\n"); 
		query.append("		                       RT.RAT_UT_CD, RT.PRC_CGO_TP_CD," ).append("\n"); 
		query.append("		                       PRC_CMDT_DEF_CD," ).append("\n"); 
		query.append("		                       ORG.ROUT_PNT_LOC_DEF_CD AS ORG_ROUT_PNT_LOC_DEF_CD, " ).append("\n"); 
		query.append("		                       DST.ROUT_PNT_LOC_DEF_CD AS DST_ROUT_PNT_LOC_DEF_CD, " ).append("\n"); 
		query.append("		                       OVIA.ROUT_VIA_PORT_DEF_CD AS OVIA_ROUT_VIA_PORT_DEF_CD, " ).append("\n"); 
		query.append("		                       DVIA.ROUT_VIA_PORT_DEF_CD AS DVIA_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("		                  FROM PRI_SP_SCP_RT_CMDT_ROUT MN," ).append("\n"); 
		query.append("		                       PRI_SP_SCP_RT_ROUT_PNT ORG," ).append("\n"); 
		query.append("		                       PRI_SP_SCP_RT_ROUT_PNT DST," ).append("\n"); 
		query.append("		                       (SELECT PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ROUT_VIA_PORT_DEF_CD " ).append("\n"); 
		query.append("		                          FROM PRI_SP_SCP_RT_ROUT_VIA " ).append("\n"); 
		query.append("		                        WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND SVC_SCP_CD = @[svc_scp_cd] AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]  AND ORG_DEST_TP_CD = 'O') OVIA," ).append("\n"); 
		query.append("		                       (SELECT PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ROUT_VIA_PORT_DEF_CD " ).append("\n"); 
		query.append("		                          FROM PRI_SP_SCP_RT_ROUT_VIA " ).append("\n"); 
		query.append("		                        WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND SVC_SCP_CD = @[svc_scp_cd] AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]  AND ORG_DEST_TP_CD = 'D' ) DVIA," ).append("\n"); 
		query.append("		                       PRI_SP_SCP_RT_CMDT CMDT," ).append("\n"); 
		query.append("		                       PRI_SP_SCP_RT RT" ).append("\n"); 
		query.append("			 WHERE MN.PROP_NO      = @[prop_no]" ).append("\n"); 
		query.append("			   AND MN.AMDT_SEQ     = @[amdt_seq]" ).append("\n"); 
		query.append("			   AND MN.SVC_SCP_CD   = @[svc_scp_cd]" ).append("\n"); 
		query.append("			   AND MN.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("	#if (${UPDATE_LEVEL} == '1') " ).append("\n"); 
		query.append("	-- 모든 route에 대해 수행함" ).append("\n"); 
		query.append("	#elseif (${UPDATE_LEVEL} == '2') " ).append("\n"); 
		query.append("			   AND MN.CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("			   AND MN.ROUT_SEQ = @[rout_seq]" ).append("\n"); 
		query.append("			   AND RT.RT_SEQ = @[rt_seq]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		                   AND MN.PROP_NO      = ORG.PROP_NO   " ).append("\n"); 
		query.append("		                   AND MN.AMDT_SEQ     = ORG.AMDT_SEQ  " ).append("\n"); 
		query.append("		                   AND MN.SVC_SCP_CD   = ORG.SVC_SCP_CD" ).append("\n"); 
		query.append("		                   AND MN.GEN_SPCL_RT_TP_CD = ORG.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("		                   AND MN.CMDT_HDR_SEQ = ORG.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		                   AND MN.ROUT_SEQ     = ORG.ROUT_SEQ    " ).append("\n"); 
		query.append("		                   AND ORG.ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("		                   AND MN.PROP_NO      = DST.PROP_NO   " ).append("\n"); 
		query.append("		                   AND MN.AMDT_SEQ     = DST.AMDT_SEQ  " ).append("\n"); 
		query.append("		                   AND MN.SVC_SCP_CD   = DST.SVC_SCP_CD" ).append("\n"); 
		query.append("		                   AND MN.GEN_SPCL_RT_TP_CD = DST.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("		                   AND MN.CMDT_HDR_SEQ = DST.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		                   AND MN.ROUT_SEQ     = DST.ROUT_SEQ    " ).append("\n"); 
		query.append("		                   AND DST.ORG_DEST_TP_CD = 'D'   " ).append("\n"); 
		query.append("		                   AND MN.PROP_NO      = OVIA.PROP_NO(+)   " ).append("\n"); 
		query.append("		                   AND MN.AMDT_SEQ     = OVIA.AMDT_SEQ(+)  " ).append("\n"); 
		query.append("		                   AND MN.SVC_SCP_CD   = OVIA.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("		                   AND MN.GEN_SPCL_RT_TP_CD = OVIA.GEN_SPCL_RT_TP_CD(+)" ).append("\n"); 
		query.append("		                   AND MN.CMDT_HDR_SEQ = OVIA.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("		                   AND MN.ROUT_SEQ     = OVIA.ROUT_SEQ(+)  " ).append("\n"); 
		query.append("		                   AND MN.PROP_NO      = DVIA.PROP_NO(+)   " ).append("\n"); 
		query.append("		                   AND MN.AMDT_SEQ     = DVIA.AMDT_SEQ(+)  " ).append("\n"); 
		query.append("		                   AND MN.SVC_SCP_CD   = DVIA.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("		                   AND MN.GEN_SPCL_RT_TP_CD = DVIA.GEN_SPCL_RT_TP_CD(+)" ).append("\n"); 
		query.append("		                   AND MN.CMDT_HDR_SEQ = DVIA.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("		                   AND MN.ROUT_SEQ     = DVIA.ROUT_SEQ(+)           " ).append("\n"); 
		query.append("		                   AND MN.PROP_NO      = CMDT.PROP_NO(+)   " ).append("\n"); 
		query.append("		                   AND MN.AMDT_SEQ     = CMDT.AMDT_SEQ(+)  " ).append("\n"); 
		query.append("		                   AND MN.SVC_SCP_CD   = CMDT.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("		                   AND MN.GEN_SPCL_RT_TP_CD = CMDT.GEN_SPCL_RT_TP_CD(+)" ).append("\n"); 
		query.append("		                   AND MN.CMDT_HDR_SEQ = CMDT.CMDT_HDR_SEQ(+) " ).append("\n"); 
		query.append("		                   AND MN.PROP_NO      = RT.PROP_NO(+)   " ).append("\n"); 
		query.append("		                   AND MN.AMDT_SEQ     = RT.AMDT_SEQ(+)  " ).append("\n"); 
		query.append("		                   AND MN.SVC_SCP_CD   = RT.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("		                   AND MN.GEN_SPCL_RT_TP_CD = RT.GEN_SPCL_RT_TP_CD(+)" ).append("\n"); 
		query.append("		                   AND MN.CMDT_HDR_SEQ = RT.CMDT_HDR_SEQ(+) " ).append("\n"); 
		query.append("		                   AND MN.ROUT_SEQ     = RT.ROUT_SEQ(+)" ).append("\n"); 
		query.append("		                   AND RT.PRC_PROG_STS_CD IN ( 'I', 'R' )" ).append("\n"); 
		query.append("		                   AND RT.SRC_INFO_CD <> 'AD'                   " ).append("\n"); 
		query.append("		                ) MN," ).append("\n"); 
		query.append("		               PRI_SP_SCP_SCG_ADJ SCG_ADJ," ).append("\n"); 
		query.append("		               PRI_RAT_UT SCG_UT," ).append("\n"); 
		query.append("		               PRI_RAT_UT RT_UT" ).append("\n"); 
		query.append("		         WHERE 1=1" ).append("\n"); 
		query.append("		           AND MN.PROP_NO      = SCG_ADJ.PROP_NO" ).append("\n"); 
		query.append("		           AND MN.AMDT_SEQ     = SCG_ADJ.AMDT_SEQ" ).append("\n"); 
		query.append("		           AND MN.SVC_SCP_CD   = SCG_ADJ.SVC_SCP_CD" ).append("\n"); 
		query.append("		           AND MN.GEN_SPCL_RT_TP_CD      = SCG_ADJ.GEN_SPCL_RT_TP_CD(+)" ).append("\n"); 
		query.append("		           AND MN.PRC_CMDT_DEF_CD      = NVL(SCG_ADJ.PRC_CMDT_DEF_CD, MN.PRC_CMDT_DEF_CD )" ).append("\n"); 
		query.append("		           AND MN.ORG_ROUT_PNT_LOC_DEF_CD   = NVL(SCG_ADJ.ORG_LOC_DEF_CD, MN.ORG_ROUT_PNT_LOC_DEF_CD)" ).append("\n"); 
		query.append("		           AND NVL(MN.OVIA_ROUT_VIA_PORT_DEF_CD, 'X') = NVL(SCG_ADJ.ORG_VIA_LOC_DEF_CD, NVL(MN.OVIA_ROUT_VIA_PORT_DEF_CD, 'X') )" ).append("\n"); 
		query.append("		           AND NVL(MN.DVIA_ROUT_VIA_PORT_DEF_CD, 'X') = NVL(SCG_ADJ.DEST_VIA_LOC_DEF_CD, NVL(MN.DVIA_ROUT_VIA_PORT_DEF_CD, 'X') )" ).append("\n"); 
		query.append("		           AND MN.DST_ROUT_PNT_LOC_DEF_CD   = NVL(SCG_ADJ.DEST_LOC_DEF_CD, MN.DST_ROUT_PNT_LOC_DEF_CD ) " ).append("\n"); 
		query.append("		           " ).append("\n"); 
		query.append("		           AND MN.PRC_CGO_TP_CD = NVL(SCG_ADJ.PRC_CGO_TP_CD, MN.PRC_CGO_TP_CD )" ).append("\n"); 
		query.append("		           AND SCG_UT.RAT_UT_CD = NVL(SCG_ADJ.BKG_RAT_UT_CD, SCG_UT.RAT_UT_CD)" ).append("\n"); 
		query.append("		           AND SCG_UT.DELT_FLG = 'N'" ).append("\n"); 
		query.append("		           AND MN.RAT_UT_CD = RT_UT.RAT_UT_CD" ).append("\n"); 
		query.append("		           AND MN.RAT_UT_CD = DECODE(SCG_UT.CNTR_SZ_CD, NULL, MN.RAT_UT_CD, " ).append("\n"); 
		query.append("		                                           DECODE(SCG_ADJ.BKG_RAT_UT_CD, '20', DECODE(RT_UT.CNTR_SZ_CD, '2', RT_UT.RAT_UT_CD, 'X')," ).append("\n"); 
		query.append("		                                                                         '40', DECODE(RT_UT.CNTR_SZ_CD, '4', RT_UT.RAT_UT_CD, 'X')," ).append("\n"); 
		query.append("		                                                                         '45', DECODE(RT_UT.CNTR_SZ_CD, '7', RT_UT.RAT_UT_CD, 'X'), SCG_ADJ.BKG_RAT_UT_CD ))         " ).append("\n"); 
		query.append("		        ) MN" ).append("\n"); 
		query.append("		 WHERE  NUM = 1            					              " ).append("\n"); 
		query.append("		   AND  EXISTS ( SELECT 'O' FROM PRI_SP_SCP_RT_SCG SCG" ).append("\n"); 
		query.append("       					  WHERE MN.PROP_NO = SCG.PROP_NO" ).append("\n"); 
		query.append("				            AND MN.AMDT_SEQ = SCG.AMDT_SEQ" ).append("\n"); 
		query.append("				            AND MN.SVC_SCP_CD = SCG.SVC_SCP_CD" ).append("\n"); 
		query.append("				            AND MN.GEN_SPCL_RT_TP_CD = SCG.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("				            AND MN.CMDT_HDR_SEQ = SCG.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("				            AND MN.ROUT_SEQ = SCG.ROUT_SEQ" ).append("\n"); 
		query.append("				            AND MN.RT_SEQ = SCG.RT_SEQ" ).append("\n"); 
		query.append("				            AND MN.CHG_CD = SCG.CHG_CD" ).append("\n"); 
		query.append("				            AND SCG.ADJ_FLG = 'N' )          					              " ).append("\n"); 
		query.append("    ) B" ).append("\n"); 
		query.append("ON ( " ).append("\n"); 
		query.append("    A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("AND A.AMDT_SEQ = B.AMDT_SEQ" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("AND A.GEN_SPCL_RT_TP_CD = B.GEN_SPCL_RT_TP_CD " ).append("\n"); 
		query.append("AND A.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND A.ROUT_SEQ = B.ROUT_SEQ" ).append("\n"); 
		query.append("AND A.RT_SEQ = B.RT_SEQ" ).append("\n"); 
		query.append("AND A.CHG_CD = B.CHG_CD    ) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET " ).append("\n"); 
		query.append("    A.CURR_CD = B.CURR_CD," ).append("\n"); 
		query.append("    A.ADJ_SCG_AMT = B.ADJ_SCG_AMT," ).append("\n"); 
		query.append("    A.ADJ_SCG_USD_AMT = B.ADJ_SCG_USD_AMT," ).append("\n"); 
		query.append("    A.TRF_ADJ_TP_CD = 'B'," ).append("\n"); 
		query.append("    A.UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("    A.UPD_DT = SYSDATE  " ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT ( A.PROP_NO, A.AMDT_SEQ, A.SVC_SCP_CD, A.GEN_SPCL_RT_TP_CD, A.CMDT_HDR_SEQ, A.ROUT_SEQ, A.RT_SEQ, " ).append("\n"); 
		query.append("        A.CHG_CD, A.BKG_RAT_UT_CD, A.CURR_CD, A.ADJ_SCG_AMT, A.ADJ_SCG_USD_AMT, " ).append("\n"); 
		query.append("        A.TRF_ADJ_TP_CD, A.CRE_USR_ID, A.CRE_DT, A.UPD_USR_ID, A.UPD_DT)" ).append("\n"); 
		query.append("VALUES ( B.PROP_NO, B.AMDT_SEQ, B.SVC_SCP_CD, B.GEN_SPCL_RT_TP_CD, B.CMDT_HDR_SEQ, B.ROUT_SEQ, B.RT_SEQ,     	" ).append("\n"); 
		query.append("        B.CHG_CD, B.BKG_RAT_UT_CD, B.CURR_CD, B.ADJ_SCG_AMT, B.ADJ_SCG_USD_AMT, " ).append("\n"); 
		query.append("        'B', @[upd_usr_id], SYSDATE, @[upd_usr_id], SYSDATE )" ).append("\n"); 

	}
}