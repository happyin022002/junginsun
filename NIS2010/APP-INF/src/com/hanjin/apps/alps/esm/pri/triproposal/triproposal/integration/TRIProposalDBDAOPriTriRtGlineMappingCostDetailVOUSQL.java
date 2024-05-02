/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TRIProposalDBDAOPriTriRtGlineMappingCostDetailVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.12
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.01.12 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.triproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TRIProposalDBDAOPriTriRtGlineMappingCostDetailVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *  
	  * </pre>
	  */
	public TRIProposalDBDAOPriTriRtGlineMappingCostDetailVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tri_prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.triproposal.triproposal.integration").append("\n"); 
		query.append("FileName : TRIProposalDBDAOPriTriRtGlineMappingCostDetailVOUSQL").append("\n"); 
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
		query.append("MERGE INTO PRI_TRI_RT A " ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("        SELECT  TRI_PROP_NO, AMDT_SEQ, CMPB_AMT       " ).append("\n"); 
		query.append("          FROM  (" ).append("\n"); 
		query.append("                SELECT  RT.TRI_PROP_NO, RT.AMDT_SEQ, MAPG.MAPG_SCRE, MAPG.CURR_CD, MAPG.CMPB_AMT" ).append("\n"); 
		query.append("                       ,ROW_NUMBER() OVER (PARTITION BY RT.TRI_PROP_NO, RT.AMDT_SEQ" ).append("\n"); 
		query.append("                       				ORDER BY MAPG.MAPG_SCRE DESC, MAPG.CURR_CD, MAPG.CMPB_AMT DESC) AS ROW_NUMBER" ).append("\n"); 
		query.append("                  FROM  PRI_TRI_MN        MN" ).append("\n"); 
		query.append("                       ,PRI_TRI_RT        RT" ).append("\n"); 
		query.append("                       ,PRI_TRI_RT_USD_ROUT_CS  ROUT" ).append("\n"); 
		query.append("                       ,PRI_PRS_USD_ROUT_CS_INFO   ROUT_INFO " ).append("\n"); 
		query.append("                       ,PRI_CMPB_GLINE_MN	GLINE_MN" ).append("\n"); 
		query.append("		               ,(" ).append("\n"); 
		query.append("				        SELECT  GLINE_MN.SVC_SCP_CD, MAX(GLINE_MN.EFF_DT) AS EFF_DT" ).append("\n"); 
		query.append("                          FROM  PRI_TRI_MN     MN" ).append("\n"); 
		query.append("                               ,PRI_TARIFF     TRF" ).append("\n"); 
		query.append("                               ,PRI_SVC_SCP_TRF SVC_TRF" ).append("\n"); 
		query.append("                               ,PRI_TRI_RT     RT" ).append("\n"); 
		query.append("                               ,PRI_CMPB_GLINE_MN GLINE_MN" ).append("\n"); 
		query.append("                         WHERE  MN.TRI_PROP_NO    = @[tri_prop_no]" ).append("\n"); 
		query.append("                           AND  MN.TRF_PFX_CD     = TRF.TRF_PFX_CD" ).append("\n"); 
		query.append("                           AND  MN.TRF_NO         = TRF.TRF_NO" ).append("\n"); 
		query.append("                           AND  TRF.TRF_PFX_CD    = SVC_TRF.TRF_PFX_CD" ).append("\n"); 
		query.append("                           AND  TRF.TRF_NO        = SVC_TRF.TRF_NO" ).append("\n"); 
		query.append("                           AND  SVC_TRF.SVC_SCP_CD= GLINE_MN.SVC_SCP_CD" ).append("\n"); 
		query.append("                           AND  GLINE_MN.EFF_DT <= RT.EFF_DT" ).append("\n"); 
		query.append("                           AND  GLINE_MN.EXP_DT >= RT.EFF_DT" ).append("\n"); 
		query.append("                           AND  GLINE_MN.CFM_FLG = 'Y'" ).append("\n"); 
		query.append("                        GROUP BY GLINE_MN.SVC_SCP_CD  " ).append("\n"); 
		query.append("		                ) MAX_DT" ).append("\n"); 
		query.append("                       ,PRI_CMPB_GLINE_MAPG  MAPG                              " ).append("\n"); 
		query.append("                 WHERE  MN.TRI_PROP_NO  = @[tri_prop_no]" ).append("\n"); 
		query.append("                   AND  MN.TRI_PROP_NO  = RT.TRI_PROP_NO" ).append("\n"); 
		query.append("                   AND  RT.AMDT_SEQ     = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND  RT.PROP_STS_CD IN ( 'I', 'R' )" ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("				   AND  GLINE_MN.SVC_SCP_CD = MAX_DT.SVC_SCP_CD" ).append("\n"); 
		query.append("                   AND  GLINE_MN.EFF_DT     = MAX_DT.EFF_DT " ).append("\n"); 
		query.append("                   AND  GLINE_MN.GLINE_SEQ  = MAPG.GLINE_SEQ  " ).append("\n"); 
		query.append("                   AND  GLINE_MN.SVC_SCP_CD = MAPG.SVC_SCP_CD " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                   AND  ROUT.USD_ROUT_CS_SEL_FLG = 'Y'" ).append("\n"); 
		query.append("                   AND  RT.VSL_SLAN_CD  = MAPG.VSL_SLAN_CD" ).append("\n"); 
		query.append("                   AND  ROUT.ROUT_CS_NO = ROUT_INFO.ROUT_CS_NO" ).append("\n"); 
		query.append("                   AND  ROUT.ROUT_CS_SRC_DT = ROUT_INFO.ROUT_CS_SRC_DT" ).append("\n"); 
		query.append("                   AND  NVL(MAPG.ORG_LOC_DEF_CD, ROUT_INFO.POR_CD) " ).append("\n"); 
		query.append("                                = DECODE(MAPG.ORG_LOC_TP_CD, 'C', (SELECT CNT_CD FROM MDM_LOCATION WHERE LOC_CD = ROUT_INFO.POR_CD)" ).append("\n"); 
		query.append("                                                           , 'R', (SELECT RGN_CD FROM MDM_LOCATION WHERE LOC_CD = ROUT_INFO.POR_CD)" ).append("\n"); 
		query.append("                                                           , ROUT_INFO.POR_CD )" ).append("\n"); 
		query.append("                   AND  NVL(MAPG.DEST_LOC_DEF_CD, ROUT_INFO.DEL_CD) " ).append("\n"); 
		query.append("                                = DECODE(MAPG.DEST_LOC_TP_CD, 'C', (SELECT CNT_CD FROM MDM_LOCATION WHERE LOC_CD = ROUT_INFO.DEL_CD)" ).append("\n"); 
		query.append("                                                           , 'R', (SELECT RGN_CD FROM MDM_LOCATION WHERE LOC_CD = ROUT_INFO.DEL_CD)" ).append("\n"); 
		query.append("                                                           , ROUT_INFO.DEL_CD )" ).append("\n"); 
		query.append("                   AND  NVL(MAPG.ORG_VIA_PORT_DEF_CD, NVL(ROUT_INFO.POL_CD, 'X')) " ).append("\n"); 
		query.append("                                = DECODE(MAPG.ORG_VIA_PORT_TP_CD, 'C', (SELECT CNT_CD FROM MDM_LOCATION WHERE LOC_CD = ROUT_INFO.POL_CD)" ).append("\n"); 
		query.append("                                                           , 'R', (SELECT RGN_CD FROM MDM_LOCATION WHERE LOC_CD = ROUT_INFO.POL_CD)" ).append("\n"); 
		query.append("                                                           , NVL(ROUT_INFO.POL_CD, 'X') )" ).append("\n"); 
		query.append("                   AND  NVL(MAPG.DEST_VIA_PORT_DEF_CD, NVL(ROUT_INFO.POD_CD, 'X')) " ).append("\n"); 
		query.append("                                = DECODE(MAPG.DEST_VIA_PORT_TP_CD, 'C', (SELECT CNT_CD FROM MDM_LOCATION WHERE LOC_CD = ROUT_INFO.POD_CD)" ).append("\n"); 
		query.append("                                                           , 'R', (SELECT RGN_CD FROM MDM_LOCATION WHERE LOC_CD = ROUT_INFO.POD_CD)" ).append("\n"); 
		query.append("                                                           , NVL(ROUT_INFO.POD_CD, 'X') )" ).append("\n"); 
		query.append("                   AND  ROUT_INFO.BKG_RCV_TERM_CD = DECODE(MAPG.RCV_TERM_CD, NULL, ROUT_INFO.BKG_RCV_TERM_CD, MAPG.RCV_TERM_CD)" ).append("\n"); 
		query.append("                   AND  ROUT_INFO.BKG_DE_TERM_CD  = DECODE(MAPG.DE_TERM_CD, NULL, ROUT_INFO.BKG_DE_TERM_CD, MAPG.DE_TERM_CD )" ).append("\n"); 
		query.append("                   AND  RT.RAT_UT_CD      = DECODE(MAPG.RAT_UT_CD, NULL, RT.RAT_UT_CD, MAPG.RAT_UT_CD)" ).append("\n"); 
		query.append("                   AND  RT.PRC_CGO_TP_CD  = DECODE(MAPG.PRC_CGO_TP_CD, NULL, RT.PRC_CGO_TP_CD, MAPG.PRC_CGO_TP_CD)          " ).append("\n"); 
		query.append("                   AND  MN.CMDT_CD        = DECODE(MAPG.PRC_CMDT_DEF_CD, NULL, MN.CMDT_CD, MAPG.PRC_CMDT_DEF_CD )" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("         WHERE ROW_NUMBER = 1" ).append("\n"); 
		query.append("    ) B" ).append("\n"); 
		query.append("ON (" ).append("\n"); 
		query.append("   A.TRI_PROP_NO = B.TRI_PROP_NO" ).append("\n"); 
		query.append("   AND  A.AMDT_SEQ = B.AMDT_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET A.PRS_GID_CMPB_AMT = B.CMPB_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}