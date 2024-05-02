/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCRateQuotationDBDAOPriSqRtGlineMappingCostDetailVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.12
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.01.12 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCRateQuotationDBDAOPriSqRtGlineMappingCostDetailVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * pri_sq_rt를 일괄 조정한다.
	  * </pre>
	  */
	public SCRateQuotationDBDAOPriSqRtGlineMappingCostDetailVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("qttn_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.integration").append("\n"); 
		query.append("FileName : SCRateQuotationDBDAOPriSqRtGlineMappingCostDetailVOUSQL").append("\n"); 
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
		query.append("MERGE INTO PRI_SQ_RT A " ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("        SELECT  QTTN_NO, QTTN_VER_NO" ).append("\n"); 
		query.append("               ,GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ, RT_SEQ, CMPB_AMT       " ).append("\n"); 
		query.append("          FROM  (" ).append("\n"); 
		query.append("                SELECT  MN.QTTN_NO, MN.QTTN_VER_NO" ).append("\n"); 
		query.append("                       ,RATE.GEN_SPCL_RT_TP_CD, RATE.CMDT_HDR_SEQ, RATE.ROUT_SEQ, RATE.RT_SEQ, MAPG.MAPG_SCRE, MAPG.CURR_CD, MAPG.CMPB_AMT" ).append("\n"); 
		query.append("                       ,ROW_NUMBER() OVER (PARTITION BY MN.QTTN_NO, MN.QTTN_VER_NO" ).append("\n"); 
		query.append("                       						,RATE.GEN_SPCL_RT_TP_CD, RATE.CMDT_HDR_SEQ, RATE.ROUT_SEQ, RATE.RT_SEQ " ).append("\n"); 
		query.append("                       				ORDER BY MAPG.MAPG_SCRE DESC, MAPG.CURR_CD, MAPG.CMPB_AMT DESC) AS ROW_NUMBER" ).append("\n"); 
		query.append("                  FROM  PRI_SQ_MN            MN" ).append("\n"); 
		query.append("		               ,PRI_CMPB_GLINE_MN GLINE_MN" ).append("\n"); 
		query.append("                       ,(SELECT MAX(GLINE_MN.EFF_DT) AS EFF_DT" ).append("\n"); 
		query.append("                          FROM  PRI_SQ_MN     MN" ).append("\n"); 
		query.append("                               ,PRI_CMPB_GLINE_MN GLINE_MN" ).append("\n"); 
		query.append("                         WHERE  MN.QTTN_NO      = @[qttn_no]      " ).append("\n"); 
		query.append("                           AND  MN.QTTN_VER_NO  = @[qttn_ver_no] " ).append("\n"); 
		query.append("                           AND  MN.SVC_SCP_CD   = GLINE_MN.SVC_SCP_CD" ).append("\n"); 
		query.append("                           AND  GLINE_MN.EFF_DT <= MN.EFF_DT" ).append("\n"); 
		query.append("                           AND  GLINE_MN.EXP_DT >= MN.EFF_DT" ).append("\n"); 
		query.append("                           AND  GLINE_MN.CFM_FLG = 'Y' ) MAX_DT" ).append("\n"); 
		query.append("                       ,PRI_SQ_RT        RATE" ).append("\n"); 
		query.append("                       ,PRI_SQ_RT_USD_ROUT_CS  ROUT" ).append("\n"); 
		query.append("                       ,PRI_PRS_USD_ROUT_CS_INFO   ROUT_INFO " ).append("\n"); 
		query.append("                       ,PRI_CMPB_GLINE_MAPG  MAPG" ).append("\n"); 
		query.append("                       ,(SELECT DISTINCT A.QTTN_NO, A.QTTN_VER_NO, A.GEN_SPCL_RT_TP_CD, A.CMDT_HDR_SEQ, A.CMDT_SEQ, " ).append("\n"); 
		query.append("                       		  DECODE(A.PRC_CMDT_TP_CD, 'G', C.PRC_CMDT_DEF_CD, A.PRC_CMDT_DEF_CD )AS CMDT_CD" ).append("\n"); 
		query.append("                         FROM PRI_SQ_RT_CMDT A" ).append("\n"); 
		query.append("                		        LEFT OUTER JOIN  PRI_SQ_GRP_CMDT B" ).append("\n"); 
		query.append("                        		    ON (  A.QTTN_NO     = B.QTTN_NO" ).append("\n"); 
		query.append("                		              AND A.QTTN_VER_NO    = B.QTTN_VER_NO" ).append("\n"); 
		query.append("                		              AND A.PRC_CMDT_DEF_CD = B.PRC_GRP_CMDT_CD" ).append("\n"); 
		query.append("                        		       )" ).append("\n"); 
		query.append("                		        LEFT OUTER JOIN PRI_SQ_GRP_CMDT_DTL C" ).append("\n"); 
		query.append("                        		    ON (  B.QTTN_NO     = C.QTTN_NO" ).append("\n"); 
		query.append("                              		  AND B.QTTN_VER_NO    = C.QTTN_VER_NO" ).append("\n"); 
		query.append("                		              AND B.GRP_CMDT_SEQ = C.GRP_CMDT_SEQ" ).append("\n"); 
		query.append("                		              )" ).append("\n"); 
		query.append("                        WHERE A.QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("                          AND A.QTTN_VER_NO =  @[qttn_ver_no] " ).append("\n"); 
		query.append("                          AND A.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("                       ) CMDT                               " ).append("\n"); 
		query.append("                 WHERE  MN.QTTN_NO      = @[qttn_no]" ).append("\n"); 
		query.append("                   AND  MN.QTTN_VER_NO     =  @[qttn_ver_no] " ).append("\n"); 
		query.append("                   AND  MN.QTTN_NO      = ROUT.QTTN_NO" ).append("\n"); 
		query.append("                   AND  MN.QTTN_VER_NO     = ROUT.QTTN_VER_NO" ).append("\n"); 
		query.append("                   AND  ROUT.USD_ROUT_CS_SEL_FLG = 'Y'" ).append("\n"); 
		query.append("                   AND  MN.SVC_SCP_CD   = GLINE_MN.SVC_SCP_CD" ).append("\n"); 
		query.append("                   AND  GLINE_MN.EFF_DT = MAX_DT.EFF_DT" ).append("\n"); 
		query.append("                   AND  MN.SVC_SCP_CD   = MAPG.SVC_SCP_CD " ).append("\n"); 
		query.append("                   AND  GLINE_MN.GLINE_SEQ  = MAPG.GLINE_SEQ  " ).append("\n"); 
		query.append("                   AND  DECODE(MN.PRC_CUST_TP_CD, 'A', 'B', 'I', 'B', 'O', 'B', MN.PRC_CUST_TP_CD)" ).append("\n"); 
		query.append("                   							= DECODE(MAPG.PRS_CUST_TP_CD, 'M', MN.PRC_CUST_TP_CD, MAPG.PRS_CUST_TP_CD)" ).append("\n"); 
		query.append("                   AND  MN.CUST_CNT_CD    = DECODE(MAPG.CUST_CNT_CD, NULL, MN.CUST_CNT_CD, MAPG.CUST_CNT_CD)" ).append("\n"); 
		query.append("                   AND  MN.CUST_SEQ       = DECODE(MAPG.CUST_SEQ, NULL, MN.CUST_SEQ, MAPG.CUST_SEQ)" ).append("\n"); 
		query.append("                   AND  MN.QTTN_NO      = RATE.QTTN_NO" ).append("\n"); 
		query.append("                   AND  MN.QTTN_VER_NO     = RATE.QTTN_VER_NO" ).append("\n"); 
		query.append("                   AND  RATE.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("                   AND  RATE.CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("                   AND  RATE.ROUT_SEQ = @[rout_seq]" ).append("\n"); 
		query.append("                   AND  RATE.RT_SEQ = @[rt_seq]" ).append("\n"); 
		query.append("                   AND  RATE.GEN_SPCL_RT_TP_CD = ROUT.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                   AND  RATE.CMDT_HDR_SEQ   = ROUT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                   AND  RATE.ROUT_SEQ       = ROUT.ROUT_SEQ" ).append("\n"); 
		query.append("                   AND  RATE.RT_SEQ         = ROUT.RT_SEQ" ).append("\n"); 
		query.append("                   AND  RATE.VSL_SLAN_CD  = MAPG.VSL_SLAN_CD" ).append("\n"); 
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
		query.append("                   AND  MAPG.MQC_RNG_FM_QTY <= MN.ESTM_MQC_QTY" ).append("\n"); 
		query.append("                   AND  MAPG.MQC_RNG_TO_QTY >= MN.ESTM_MQC_QTY" ).append("\n"); 
		query.append("                   AND  RATE.RAT_UT_CD      = DECODE(MAPG.RAT_UT_CD, NULL, RATE.RAT_UT_CD, MAPG.RAT_UT_CD)" ).append("\n"); 
		query.append("                   AND  RATE.PRC_CGO_TP_CD  = DECODE(MAPG.PRC_CGO_TP_CD, NULL, RATE.PRC_CGO_TP_CD, MAPG.PRC_CGO_TP_CD)          " ).append("\n"); 
		query.append("                   AND  MN.QTTN_NO      = CMDT.QTTN_NO" ).append("\n"); 
		query.append("                   AND  MN.QTTN_VER_NO     = CMDT.QTTN_VER_NO" ).append("\n"); 
		query.append("                   AND  RATE.GEN_SPCL_RT_TP_CD = CMDT.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                   AND  RATE.CMDT_HDR_SEQ   = CMDT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                   AND  CMDT.CMDT_CD        = DECODE(MAPG.PRC_CMDT_DEF_CD, NULL, CMDT.CMDT_CD, MAPG.PRC_CMDT_DEF_CD )" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("         WHERE ROW_NUMBER = 1" ).append("\n"); 
		query.append("    ) B" ).append("\n"); 
		query.append("ON (" ).append("\n"); 
		query.append("   A.QTTN_NO = B.QTTN_NO" ).append("\n"); 
		query.append("   AND  A.QTTN_VER_NO = B.QTTN_VER_NO" ).append("\n"); 
		query.append("   AND  A.GEN_SPCL_RT_TP_CD = B.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("   AND  A.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("   AND  A.ROUT_SEQ = B.ROUT_SEQ" ).append("\n"); 
		query.append("   AND  A.RT_SEQ = B.RT_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET A.PRS_GID_CMPB_AMT = B.CMPB_AMT" ).append("\n"); 

	}
}