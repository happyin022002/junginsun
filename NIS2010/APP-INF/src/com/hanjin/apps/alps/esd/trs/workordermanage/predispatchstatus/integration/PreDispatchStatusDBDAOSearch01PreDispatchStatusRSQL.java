/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PreDispatchStatusDBDAOSearch01PreDispatchStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.26
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2014.06.26 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.predispatchstatus.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CJH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PreDispatchStatusDBDAOSearch01PreDispatchStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search01PreDispatchStatus SELECT
	  * </pre>
	  */
	public PreDispatchStatusDBDAOSearch01PreDispatchStatusRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.predispatchstatus.integration").append("\n"); 
		query.append("FileName : PreDispatchStatusDBDAOSearch01PreDispatchStatusRSQL").append("\n"); 
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
		query.append("       TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("      ,TRSP_SO_SEQ" ).append("\n"); 
		query.append("      ,TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("      ,TRSP_WO_SEQ" ).append("\n"); 
		query.append("      ,TRSP_WO_NO" ).append("\n"); 
		query.append("      ,VNDR_SEQ" ).append("\n"); 
		query.append("      ,EQ_NO" ).append("\n"); 
		query.append("      ,EQ_TPSZ_CD" ).append("\n"); 
		query.append("      ,BKG_NO" ).append("\n"); 
		query.append("      ,BL_NO BL_NO" ).append("\n"); 
		query.append("      ,SEP_LOPIC" ).append("\n"); 
		query.append("      ,FRT_FLAG" ).append("\n"); 
		query.append("      ,FRT_DATE" ).append("\n"); 
		query.append("      ,ORG_FLAG" ).append("\n"); 
		query.append("      ,ORG_DATE" ).append("\n"); 
		query.append("      ,BIL_FLAG" ).append("\n"); 
		query.append("      ,BIL_DATE" ).append("\n"); 
		query.append("      ,CASE WHEN FRT_FLAG='Y' AND ORG_FLAG='Y' AND BIL_FLAG IN('Y','W')" ).append("\n"); 
		query.append("            THEN SUBSTR(PKUP_INFO, 1, INSTR(PKUP_INFO, '^', 1, 1) - 1) ELSE ''" ).append("\n"); 
		query.append("       END PICKUP_NO" ).append("\n"); 
		query.append("      ,SUBSTR(PKUP_INFO, INSTR(PKUP_INFO, '^', 1, 1) + 1,  INSTR(PKUP_INFO, '^', 1, 2) -  INSTR(PKUP_INFO, '^', 1, 1)  - 1) AS PU_YARD" ).append("\n"); 
		query.append("      ,SUBSTR(PKUP_INFO, INSTR(PKUP_INFO, '^', 1, 2) + 1,  INSTR(PKUP_INFO, '^', 1, 3) -  INSTR(PKUP_INFO, '^', 1, 2)  - 1) AS AVAILABLE_DT" ).append("\n"); 
		query.append("      ,SUBSTR(PKUP_INFO, INSTR(PKUP_INFO, '^', 1, 3) + 1,  INSTR(PKUP_INFO, '^', 1, 4) -  INSTR(PKUP_INFO, '^', 1, 3)  - 1) AS LAST_FREE_DT" ).append("\n"); 
		query.append("      ,SUBSTR(PKUP_INFO, INSTR(PKUP_INFO, '^', 1, 4) + 1,  INSTR(PKUP_INFO, '^', 1, 5) -  INSTR(PKUP_INFO, '^', 1, 4)  - 1) AS PU_NO_CRE_DT" ).append("\n"); 
		query.append("      ,VNDR_ABBR_NM" ).append("\n"); 
		query.append("      ,WO_ISS_DT" ).append("\n"); 
		query.append("      ,TRSP_DIS_REF_NO" ).append("\n"); 
		query.append("      ,DLY_DIS_SNT_DT" ).append("\n"); 
		query.append("      ,TRSP_CNTR_AVAL_SNT_DT" ).append("\n"); 
		query.append("      ,CRE_OFC_CD" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT /*+ INDEX(LOC XAK2MDM_LOCATION)*/" ).append("\n"); 
		query.append("              A.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("             ,A.TRSP_SO_SEQ" ).append("\n"); 
		query.append("             ,A.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("             ,A.TRSP_WO_SEQ" ).append("\n"); 
		query.append("             ,(A.TRSP_WO_OFC_CTY_CD||A.TRSP_WO_SEQ) TRSP_WO_NO" ).append("\n"); 
		query.append("             ,A.VNDR_SEQ" ).append("\n"); 
		query.append("             ,A.EQ_NO" ).append("\n"); 
		query.append("             ,A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("             ,A.BKG_NO" ).append("\n"); 
		query.append("             ,A.BL_NO BL_NO" ).append("\n"); 
		query.append("             ,DECODE(A.POD_CD, A.DEL_CD, 'LOC', 'PIC') SEP_LOPIC" ).append("\n"); 
		query.append("             ,B.FRT_CLT_FLG FRT_FLAG" ).append("\n"); 
		query.append("             ,TO_CHAR(B.FRT_CLT_LST_DT, 'YYYY-MM-DD HH24:MI:SS') FRT_DATE" ).append("\n"); 
		query.append("             ,B.OBL_RDEM_FLG ORG_FLAG" ).append("\n"); 
		query.append("             ,TO_CHAR(B.OBL_RDEM_LST_DT, 'YYYY-MM-DD HH24:MI:SS') ORG_DATE" ).append("\n"); 
		query.append("             ,DECODE(B.CSTMS_CLR_CD, 'Y', 'Y', ' ') BIL_FLAG" ).append("\n"); 
		query.append("             ,TO_CHAR(B.CSTMS_CLR_LST_DT, 'YYYY-MM-DD HH24:MI:SS') BIL_DATE" ).append("\n"); 
		query.append("             ,D.VNDR_ABBR_NM" ).append("\n"); 
		query.append("             ,TO_CHAR(E.CRE_DT , 'YYYY-MM-DD HH24:MI:SS') WO_ISS_DT" ).append("\n"); 
		query.append("             ,E.CRE_OFC_CD" ).append("\n"); 
		query.append("             ,CASE WHEN TRS_GET_FOC_INFO_FNC(A.BL_NO, A.TRSP_SO_OFC_CTY_CD, A.TRSP_SO_SEQ, NULL) = 'YYY'" ).append("\n"); 
		query.append("                   THEN (SELECT  PU.PKUP_NO" ).append("\n"); 
		query.append("                               ||'^'||PU.PKUP_YD_CD" ).append("\n"); 
		query.append("                               ||'^'||TO_CHAR(PU.PKUP_AVAL_DT, 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("                               ||'^'||TO_CHAR(PU.LST_FREE_DT , 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("                               ||'^'||TO_CHAR(PU.PKUP_CRE_DT , 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("                               ||'^'" ).append("\n"); 
		query.append("                           FROM BKG_PKUP_NTC_PKUP_NO PU" ).append("\n"); 
		query.append("                               ,MDM_LOCATION LOC" ).append("\n"); 
		query.append("                          WHERE LOC.LOC_CD   = PU.DEL_CD" ).append("\n"); 
		query.append("                            AND PU.BKG_NO    = A.BKG_NO" ).append("\n"); 
		query.append("                            AND PU.CNTR_NO   = A.EQ_NO" ).append("\n"); 
		query.append("                            AND PU.PKUP_YD_CD = A.FM_NOD_CD" ).append("\n"); 
		query.append("                            AND A.CONTI_CD   = 'M'" ).append("\n"); 
		query.append("                            AND LOC.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                            AND PU.UPD_DT = (SELECT MAX(Y.UPD_DT)" ).append("\n"); 
		query.append("                                               FROM BKG_PKUP_NTC_PKUP_NO Y" ).append("\n"); 
		query.append("                                              WHERE Y.BKG_NO  = PU.BKG_NO" ).append("\n"); 
		query.append("                                                AND Y.CNTR_NO = PU.CNTR_NO" ).append("\n"); 
		query.append("                                                AND Y.PKUP_YD_CD = PU.PKUP_YD_CD" ).append("\n"); 
		query.append("                                            )" ).append("\n"); 
		query.append("                            AND ROWNUM = 1" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                   ELSE ''" ).append("\n"); 
		query.append("              END AS PKUP_INFO" ).append("\n"); 
		query.append("             ,F.TRSP_DIS_REF_NO" ).append("\n"); 
		query.append("             ,TO_CHAR(F.DLY_DIS_SNT_DT, 'YYYY-MM-DD HH24:MI:SS') DLY_DIS_SNT_DT" ).append("\n"); 
		query.append("             ,DECODE(G.CNTR_AVAL_NTC_UPD_FLG ,'Y', TO_CHAR(G.CRE_DT, 'YYYY-MM-DD HH24:MI:SS')) TRSP_CNTR_AVAL_SNT_DT" ).append("\n"); 
		query.append("        FROM  TRS_TRSP_SVC_ORD A" ).append("\n"); 
		query.append("             ,BKG_CGO_RLSE B" ).append("\n"); 
		query.append("             ,MDM_VENDOR D" ).append("\n"); 
		query.append("             ,TRS_TRSP_WRK_ORD E" ).append("\n"); 
		query.append("             ,MDM_LOCATION LOC" ).append("\n"); 
		query.append("             ,TRS_TRSP_DIS_MST F" ).append("\n"); 
		query.append("             ,TRS_TRSP_DIS_HIS G" ).append("\n"); 
		query.append("        WHERE A.TRSP_CRR_MOD_CD    = 'TD'" ).append("\n"); 
		query.append("        AND   A.TRSP_SO_STS_CD     = 'I'" ).append("\n"); 
		query.append("        AND   A.DELT_FLG           = 'N'" ).append("\n"); 
		query.append("        AND   A.BL_NO              = B.BL_NO(+)" ).append("\n"); 
		query.append("        AND   A.VNDR_SEQ           = D.VNDR_SEQ" ).append("\n"); 
		query.append("        AND   A.TRSP_WO_OFC_CTY_CD = E.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("        AND   A.TRSP_WO_SEQ        = E.TRSP_WO_SEQ" ).append("\n"); 
		query.append("        AND   LOC.LOC_CD   = SUBSTR(A.FM_NOD_CD, 1, 5)" ).append("\n"); 
		query.append("        AND   LOC.CONTI_CD = 'M'" ).append("\n"); 
		query.append("        AND   LOC.DELT_FLG = 'N'" ).append("\n"); 
		query.append("        AND   A.TRSP_SO_OFC_CTY_CD = F.TRSP_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("        AND   A.TRSP_SO_SEQ        = F.TRSP_SO_SEQ(+)" ).append("\n"); 
		query.append("        AND   A.TRSP_WO_OFC_CTY_CD = F.TRSP_WO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("        AND   A.TRSP_WO_SEQ        = F.TRSP_WO_SEQ(+)" ).append("\n"); 
		query.append("        AND   F.TRSP_SO_OFC_CTY_CD = G.TRSP_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("        AND   F.TRSP_SO_SEQ        = G.TRSP_SO_SEQ(+)" ).append("\n"); 
		query.append("        AND   F.TRSP_WO_OFC_CTY_CD = G.TRSP_WO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("        AND   F.TRSP_WO_SEQ        = G.TRSP_WO_SEQ(+)" ).append("\n"); 
		query.append("        AND   F.TRSP_DIS_REF_NO    = G.TRSP_DIS_REF_NO(+)" ).append("\n"); 
		query.append("        AND   A.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("        AND   A.TRSP_SO_SEQ        = @[trsp_so_seq]" ).append("\n"); 
		query.append("        AND   A.TRSP_WO_SEQ        = @[trsp_wo_seq]" ).append("\n"); 
		query.append("        AND   A.TRSP_WO_OFC_CTY_CD = @[trsp_wo_ofc_cty_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}