/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AgreementCorrectionDBDAOSearchCorrSumAgmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.18
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.02.18 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementCorrectionDBDAOSearchCorrSumAgmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AGMT Correction Summary 조회
	  * </pre>
	  */
	public AgreementCorrectionDBDAOSearchCorrSumAgmtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_trsp_agmt_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_cmdt_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_vndr_prmry_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_trsp_cost_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_agmt_trsp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_rail_svc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_agmtno",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementCorrectionDBDAOSearchCorrSumAgmtRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("    SELECT  TRSP_AGMT_RT_TP_CD" ).append("\n"); 
		query.append("           ,AGMT_NO" ).append("\n"); 
		query.append("           ,VNDR_SEQ" ).append("\n"); 
		query.append("           ,VNDR_NM" ).append("\n"); 
		query.append("           ,TRSP_COST_MOD_CD" ).append("\n"); 
		query.append("           ,AGMT_TRSP_TP_CD" ).append("\n"); 
		query.append("           ,DECODE(TRSP_BND_CD, '0', NULL, TRSP_BND_CD) AS TRSP_BND_CD" ).append("\n"); 
		query.append("           ,DECODE(CGO_TP_CD, '0', NULL, CGO_TP_CD) AS CGO_TP_CD" ).append("\n"); 
		query.append("           ,DECODE(SPCL_CGO_CNTR_TP_CD, '00', NULL, SPCL_CGO_CNTR_TP_CD) AS SPCL_CGO_CNTR_TP_CD" ).append("\n"); 
		query.append("           ,SCG_EXIST_FLG" ).append("\n"); 
		query.append("           ,DECODE(CUST_CD, 'XX0', NULL, CUST_CD) CUST_CD" ).append("\n"); 
		query.append("           ,DECODE(CMDT_GRP_CD, 'XXXX', NULL, CMDT_GRP_CD) CMDT_GRP_CD" ).append("\n"); 
		query.append("           ,DECODE(RAIL_SVC_TP_CD, '00', NULL, RAIL_SVC_TP_CD) RAIL_SVC_TP_CD" ).append("\n"); 
		query.append("           ,AGMT_REF_NO" ).append("\n"); 
		query.append("           ,CTRT_OFC_CD" ).append("\n"); 
		query.append("           ,UPD_DT" ).append("\n"); 
		query.append("           ,UPD_USR_ID" ).append("\n"); 
		query.append("           ,CRE_OFC_CD" ).append("\n"); 
		query.append("           ,TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("           ,TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("           ,TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("           ,(SELECT COUNT(*)" ).append("\n"); 
		query.append("               FROM TRS_AGMT_EQ_RT X" ).append("\n"); 
		query.append("              WHERE X.TRSP_AGMT_OFC_CTY_CD   = M.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                AND X.TRSP_AGMT_SEQ          = M.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("                AND X.TRSP_AGMT_RT_TP_SER_NO = M.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("              #if (${fm_effective_agmt} != 'A')" ).append("\n"); 
		query.append("                AND TO_CHAR(M.DT,'YYYYMMDD') BETWEEN TO_CHAR(X.EFF_FM_DT,'YYYYMMDD') AND TO_CHAR(X.EFF_TO_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("            ) AS RATE_TOT_CNT" ).append("\n"); 
		query.append("           ,INTER_RMK" ).append("\n"); 
		query.append("           ,(SELECT MAX(Y.EQ_KND_CD) " ).append("\n"); 
		query.append("               FROM TRS_AGMT_EQ_RT Y " ).append("\n"); 
		query.append("              WHERE Y.TRSP_AGMT_OFC_CTY_CD = M.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                AND Y.TRSP_AGMT_SEQ = M.TRSP_AGMT_SEQ " ).append("\n"); 
		query.append("                AND Y.TRSP_AGMT_RT_TP_SER_NO = M.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("                AND TO_CHAR(M.DT,'YYYYMMDD') BETWEEN TO_CHAR(Y.EFF_FM_DT,'YYYYMMDD') AND TO_CHAR(Y.EFF_TO_DT,'YYYYMMDD')) AS EQ_KND_CD" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("        SELECT C.TRSP_AGMT_RT_TP_CD" ).append("\n"); 
		query.append("              ,A.TRSP_AGMT_OFC_CTY_CD || A.TRSP_AGMT_SEQ AS AGMT_NO" ).append("\n"); 
		query.append("              ,B.VNDR_SEQ" ).append("\n"); 
		query.append("              ,(SELECT MDM.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("                  FROM MDM_VENDOR MDM" ).append("\n"); 
		query.append("                 WHERE MDM.VNDR_SEQ = B.VNDR_SEQ" ).append("\n"); 
		query.append("               ) VNDR_NM" ).append("\n"); 
		query.append("              ,C.TRSP_COST_MOD_CD" ).append("\n"); 
		query.append("              ,C.AGMT_TRSP_TP_CD" ).append("\n"); 
		query.append("              ,C.TRSP_BND_CD" ).append("\n"); 
		query.append("              ,C.CGO_TP_CD" ).append("\n"); 
		query.append("              ,C.SPCL_CGO_CNTR_TP_CD" ).append("\n"); 
		query.append("              ,(SELECT 'Y'" ).append("\n"); 
		query.append("                  FROM TRS_AGMT_SCG_NOD X," ).append("\n"); 
		query.append("                       TRS_AGMT_SCG_RT R" ).append("\n"); 
		query.append("                 WHERE X.TRSP_AGMT_OFC_CTY_CD   = R.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                   AND X.TRSP_AGMT_SEQ          = R.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("                   AND X.TRSP_AGMT_RT_TP_SER_NO = R.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("                   AND R.TRSP_AGMT_OFC_CTY_CD   = C.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                   AND R.TRSP_AGMT_SEQ          = C.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("                   AND R.TRSP_AGMT_RT_TP_SER_NO = C.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("                #if (${fm_effective_agmt} != 'A')" ).append("\n"); 
		query.append("                   AND (SELECT TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(A.CTRT_OFC_CD),'YYYYMMDD') FROM DUAL) BETWEEN TO_CHAR(R.EFF_FM_DT,'YYYYMMDD') AND TO_CHAR(R.EFF_TO_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${fm_trsp_scg_cd} == 'F')" ).append("\n"); 
		query.append("                   AND X.TRSP_SCG_CD IN ('SCFAAL', 'SCFCAL')" ).append("\n"); 
		query.append("                #elseif (${fm_trsp_scg_cd} == 'O')" ).append("\n"); 
		query.append("                   AND X.TRSP_SCG_CD NOT IN ('SCFAAL', 'SCFCAL')" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                   AND ROWNUM = 1" ).append("\n"); 
		query.append("                ) AS SCG_EXIST_FLG" ).append("\n"); 
		query.append("              ,C.CUST_CNT_CD || C.CUST_SEQ CUST_CD" ).append("\n"); 
		query.append("              ,C.CMDT_GRP_CD" ).append("\n"); 
		query.append("              ,C.RAIL_SVC_TP_CD" ).append("\n"); 
		query.append("              ,A.AGMT_REF_NO" ).append("\n"); 
		query.append("              ,A.CTRT_OFC_CD" ).append("\n"); 
		query.append("              ,TO_CHAR(C.UPD_DT, 'YYYY-MM-DD HH24:MI:SS') UPD_DT" ).append("\n"); 
		query.append("              ,C.UPD_USR_ID" ).append("\n"); 
		query.append("              ,NVL(C.UPD_OFC_CD, C.CRE_OFC_CD) CRE_OFC_CD" ).append("\n"); 
		query.append("              ,C.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("              ,C.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("              ,C.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("              ,(SELECT GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(A.CTRT_OFC_CD) FROM DUAL) DT" ).append("\n"); 
		query.append("              ,A.INTER_RMK" ).append("\n"); 
		query.append("          FROM TRS_AGMT_HDR A" ).append("\n"); 
		query.append("              ,TRS_AGMT_APLY_VNDR B" ).append("\n"); 
		query.append("              ,TRS_AGMT_RT_TP C" ).append("\n"); 
		query.append("         WHERE A.TRSP_AGMT_OFC_CTY_CD = C.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND A.TRSP_AGMT_SEQ        = C.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("           AND A.TRSP_AGMT_OFC_CTY_CD = B.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND A.TRSP_AGMT_SEQ        = B.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("           AND B.AGMT_VNDR_PRMRY_FLG  = 'Y'" ).append("\n"); 
		query.append("        #if (${fm_agmtno} != '' )" ).append("\n"); 
		query.append("           AND A.TRSP_AGMT_OFC_CTY_CD = SUBSTR(@[fm_agmtno],1,3)" ).append("\n"); 
		query.append("           AND A.TRSP_AGMT_SEQ        = SUBSTR(@[fm_agmtno],4)" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${fm_vndr_prmry_seq} != '')" ).append("\n"); 
		query.append("           AND (A.TRSP_AGMT_OFC_CTY_CD, A.TRSP_AGMT_SEQ) IN (" ).append("\n"); 
		query.append("                SELECT TRSP_AGMT_OFC_CTY_CD, TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("                  FROM TRS_AGMT_APLY_VNDR" ).append("\n"); 
		query.append("                 WHERE VNDR_SEQ = @[fm_vndr_prmry_seq]" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if ($arr_ctrt_office.size() > 0)" ).append("\n"); 
		query.append("           AND A.CTRT_OFC_CD in (" ).append("\n"); 
		query.append("           #foreach( ${key} in ${arr_ctrt_office})" ).append("\n"); 
		query.append("             #if($velocityCount < $arr_ctrt_office.size())" ).append("\n"); 
		query.append("               '$key'," ).append("\n"); 
		query.append("             #else " ).append("\n"); 
		query.append("               '$key'" ).append("\n"); 
		query.append("             #end " ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${fm_trsp_agmt_rt_tp_cd} != 'A')" ).append("\n"); 
		query.append("           AND C.TRSP_AGMT_RT_TP_CD = @[fm_trsp_agmt_rt_tp_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${fm_cust_cd} != '')" ).append("\n"); 
		query.append("           AND C.CUST_CNT_CD = SUBSTR(@[fm_cust_cd],1,2)" ).append("\n"); 
		query.append("           AND C.CUST_SEQ    = SUBSTR(@[fm_cust_cd],3)" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${fm_trsp_cost_mod_cd} != 'A')" ).append("\n"); 
		query.append("           AND C.TRSP_COST_MOD_CD = @[fm_trsp_cost_mod_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${fm_agmt_trsp_tp_cd} != '')" ).append("\n"); 
		query.append("           AND C.AGMT_TRSP_TP_CD = @[fm_agmt_trsp_tp_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${fm_cgo_tp_cd} != '')" ).append("\n"); 
		query.append("           AND C.CGO_TP_CD = @[fm_cgo_tp_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${fm_rail_svc_tp_cd} != '')" ).append("\n"); 
		query.append("           AND C.RAIL_SVC_TP_CD = @[fm_rail_svc_tp_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${fm_cmdt_grp_cd} != '')" ).append("\n"); 
		query.append("           AND C.CMDT_GRP_CD = @[fm_cmdt_grp_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    ) M" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND RATE_TOT_CNT > 0" ).append("\n"); 
		query.append("#if (${fm_trsp_scg_cd} != 'A')" ).append("\n"); 
		query.append("  AND SCG_EXIST_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY CGO_TP_CD" ).append("\n"); 

	}
}