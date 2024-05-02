/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChargeCollectionReportDBDAOSearchTmnlContainerExceptionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCollectionReportDBDAOSearchTmnlContainerExceptionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCollectionReportDBDAOSearchTmnlContainerExceptionRSQL
	  * </pre>
	  */
	public ChargeCollectionReportDBDAOSearchTmnlContainerExceptionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.integration").append("\n"); 
		query.append("FileName : ChargeCollectionReportDBDAOSearchTmnlContainerExceptionRSQL").append("\n"); 
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
		query.append("SELECT BL_NO" ).append("\n"); 
		query.append("     , VVD" ).append("\n"); 
		query.append("     , CNTR_NO" ).append("\n"); 
		query.append("     , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , OC_EVNT_DT" ).append("\n"); 
		query.append("     , VD_EVNT_DT" ).append("\n"); 
		query.append("     , CNMV_STS_CD" ).append("\n"); 
		query.append("     , POL_CD" ).append("\n"); 
		query.append("     , POD_CD" ).append("\n"); 
		query.append("     , CNEE_NM" ).append("\n"); 
		query.append("     , NOTY_NM" ).append("\n"); 
		query.append("     , SC_NO" ).append("\n"); 
		query.append("     , RFA_NO" ).append("\n"); 
		query.append("     , DMDT_TRF_CD" ).append("\n"); 
		query.append("     , SUBSTR(CTRT_INFO,1,INSTR(CTRT_INFO,'-',1)-1) AS INFO_CD" ).append("\n"); 
		query.append("     , SUBSTR(CTRT_INFO,INSTR(CTRT_INFO,'-',1)+1,INSTR(CTRT_INFO,'-',1,2)-INSTR(CTRT_INFO,'-',1)-1) AS PROP_NO" ).append("\n"); 
		query.append("     , SUBSTR(CTRT_INFO,INSTR(CTRT_INFO,'-',1,2)+1,INSTR(CTRT_INFO,'-',1,3)-INSTR(CTRT_INFO,'-',1,2)-1) AS VER_SEQ" ).append("\n"); 
		query.append("     , SUBSTR(CTRT_INFO,INSTR(CTRT_INFO,'-',1,3)+1,INSTR(CTRT_INFO,'-',1,4)-INSTR(CTRT_INFO,'-',1,3)-1) AS GRP_SEQ" ).append("\n"); 
		query.append("     , SUBSTR(CTRT_INFO,INSTR(CTRT_INFO,'-',1,4)+1,INSTR(CTRT_INFO,'-',1,5)-INSTR(CTRT_INFO,'-',1,4)-1) AS EXCL_SAT" ).append("\n"); 
		query.append("     , SUBSTR(CTRT_INFO,INSTR(CTRT_INFO,'-',1,5)+1,INSTR(CTRT_INFO,'-',1,6)-INSTR(CTRT_INFO,'-',1,5)-1) AS EXCL_SUN" ).append("\n"); 
		query.append("     , SUBSTR(CTRT_INFO,INSTR(CTRT_INFO,'-',1,6)+1,INSTR(CTRT_INFO,'-',1,7)-INSTR(CTRT_INFO,'-',1,6)-1) AS EXCL_HOLI" ).append("\n"); 
		query.append("     , SUBSTR(CTRT_INFO,INSTR(CTRT_INFO,'-',1,7)+1,INSTR(CTRT_INFO,'-',1,8)-INSTR(CTRT_INFO,'-',1,7)-1) AS ADD_DYS" ).append("\n"); 
		query.append("     , SUBSTR(CTRT_INFO,INSTR(CTRT_INFO,'-',1,8)+1,INSTR(CTRT_INFO,'-',1,9)-INSTR(CTRT_INFO,'-',1,8)-1) AS TTL_DYS" ).append("\n"); 
		query.append("     , SUBSTR(CTRT_INFO,INSTR(CTRT_INFO,'-',1,9)+1,INSTR(CTRT_INFO,'-',1,10)-INSTR(CTRT_INFO,'-',1,9)-1) AS RQST_OFC_CD" ).append("\n"); 
		query.append("     , SUBSTR(CTRT_INFO,INSTR(CTRT_INFO,'-',1,10)+1,INSTR(CTRT_INFO,'-',1,11)-INSTR(CTRT_INFO,'-',1,10)-1) AS APVL_OFC_CD" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("    SELECT DISTINCT BL_NO, " ).append("\n"); 
		query.append("           VVD," ).append("\n"); 
		query.append("           CNTR_NO," ).append("\n"); 
		query.append("           CNTR_TPSZ_CD," ).append("\n"); 
		query.append("           OC_EVNT_DT," ).append("\n"); 
		query.append("           VD_EVNT_DT," ).append("\n"); 
		query.append("           CNMV_STS_CD," ).append("\n"); 
		query.append("           POL_CD," ).append("\n"); 
		query.append("           POD_CD," ).append("\n"); 
		query.append("           CNEE_NM," ).append("\n"); 
		query.append("           NOTY_NM," ).append("\n"); 
		query.append("           SC_NO," ).append("\n"); 
		query.append("           RFA_NO," ).append("\n"); 
		query.append("           DECODE(DMDT_CALC_TP_CD,'C','CTIC',DECODE(DUL_EXPT_FLG,'N','DMIF','CTIC')) DMDT_TRF_CD," ).append("\n"); 
		query.append("           CASE WHEN RFA_NO IS NOT NULL AND SUBSTR(RFA_NO,1,3) != 'DUM'" ).append("\n"); 
		query.append("           THEN NVL((" ).append("\n"); 
		query.append("                        SELECT DISTINCT " ).append("\n"); 
		query.append("                           'RFA_DMT'||'-'||A.RFA_EXPT_APRO_NO||'-'||B.RFA_EXPT_VER_SEQ||'-'||B.RFA_RQST_DTL_SEQ||'-'||B.XCLD_SAT_FLG||'-'||B.XCLD_SUN_FLG||'-'||B.XCLD_HOL_FLG" ).append("\n"); 
		query.append("                                    ||'-'||NVL(B.ADD_DYS,0)||'-'||NVL(B.TTL_DYS,0)||'-'|| A.RQST_OFC_CD ||'-'|| A.APRO_OFC_CD ||'-'||' '" ).append("\n"); 
		query.append("                        FROM DMT_CHG_BKG_CNTR T1, DMT_CHG_CALC T2, DMT_RFA_EXPT_TRF_DTL B, DMT_RFA_EXPT_TRF A" ).append("\n"); 
		query.append("                        WHERE 1=1" ).append("\n"); 
		query.append("                        AND T1.BKG_NO = AA.BKG_NO" ).append("\n"); 
		query.append("                        AND T1.CNTR_NO = AA.CNTR_NO" ).append("\n"); 
		query.append("                        AND T1.SYS_AREA_GRP_ID = T2.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                        AND T1.CNTR_NO = T2.CNTR_NO" ).append("\n"); 
		query.append("                        AND T1.CNTR_CYC_NO = T2.CNTR_CYC_NO" ).append("\n"); 
		query.append("                        AND T2.DMDT_TRF_CD = DECODE(DMDT_CALC_TP_CD,'C','CTIC',DECODE(DUL_EXPT_FLG,'N','DMIF','CTIC'))" ).append("\n"); 
		query.append("                        AND T2.CHG_SEQ = 1" ).append("\n"); 
		query.append("                        AND B.RFA_EXPT_DAR_NO = T2.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("                        AND B.RFA_EXPT_MAPG_SEQ = T2.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("                        AND B.RFA_EXPT_VER_SEQ = T2.RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("                        AND B.RFA_RQST_DTL_SEQ = T2.RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append("                        AND A.RFA_EXPT_DAR_NO = B.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("                        AND A.RFA_EXPT_MAPG_SEQ = B.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("                        AND A.RFA_EXPT_VER_SEQ = B.RFA_EXPT_VER_SEQ )" ).append("\n"); 
		query.append("                  , (CASE WHEN ( SELECT COUNT(*) " ).append("\n"); 
		query.append("                            FROM DMT_CHG_BKG_CNTR T1, " ).append("\n"); 
		query.append("                                DMT_CHG_CALC T2" ).append("\n"); 
		query.append("                            WHERE 1=1" ).append("\n"); 
		query.append("                              AND T1.BKG_NO = AA.BKG_NO" ).append("\n"); 
		query.append("                              AND T1.CNTR_NO = AA.CNTR_NO" ).append("\n"); 
		query.append("                              AND T1.SYS_AREA_GRP_ID = T2.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                              AND T1.CNTR_NO = T2.CNTR_NO" ).append("\n"); 
		query.append("                              AND T1.CNTR_CYC_NO = T2.CNTR_CYC_NO" ).append("\n"); 
		query.append("                              AND T2.DMDT_TRF_CD = DECODE(DMDT_CALC_TP_CD,'C','CTIC',DECODE(DUL_EXPT_FLG,'N','DMIF','CTIC'))" ).append("\n"); 
		query.append("                              AND T2.CHG_SEQ = 1 ) != 0 THEN 'NULL'" ).append("\n"); 
		query.append("                    ELSE DMT_RFA_EXCEPTION_FNC(AA.BKG_NO,AA.CNTR_NO, @[tml_yd_cd], DECODE(DMDT_CALC_TP_CD,'C','CTIC',DECODE(DUL_EXPT_FLG,'N','DMIF','CTIC')), AA.CNMV_CYC_NO) " ).append("\n"); 
		query.append("                    END" ).append("\n"); 
		query.append("                    )  " ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("           WHEN SC_NO IS NOT NULL AND SUBSTR(SC_NO,1,3) != 'DUM'" ).append("\n"); 
		query.append("		   THEN" ).append("\n"); 
		query.append("           NVL((" ).append("\n"); 
		query.append("                SELECT 'SC_DMT'||'-'||T3.PROP_NO||'-'||T3.SC_EXPT_VER_SEQ||'-'||T3.SC_EXPT_GRP_SEQ||'-'||T3.XCLD_SAT_FLG||'-'||T3.XCLD_SUN_FLG||'-'||T3.XCLD_HOL_FLG" ).append("\n"); 
		query.append("                           ||'-'||DECODE(T3.FT_ADD_FLG,'Y',T3.FT_ADD_DYS,0)||'-'||DECODE(T3.FT_ADD_FLG,'N',T3.FT_ADD_DYS,0)||'-'||" ).append("\n"); 
		query.append("                           ( SELECT /*+ INDEX_ASC(A DMT_SC_EXPT_VER_PROG) */ PROG_OFC_CD" ).append("\n"); 
		query.append("                                FROM DMT_SC_EXPT_VER_PROG A" ).append("\n"); 
		query.append("                                WHERE PROP_NO = T3.PROP_NO" ).append("\n"); 
		query.append("                                  AND SC_EXPT_VER_SEQ = T3.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("                                  AND DMDT_EXPT_VER_STS_CD = 'R'" ).append("\n"); 
		query.append("                                  AND ROWNUM = 1 ) ||'-'||" ).append("\n"); 
		query.append("                           ( SELECT /*+ INDEX_DESC(A DMT_SC_EXPT_VER_PROG) */ PROG_OFC_CD" ).append("\n"); 
		query.append("                                FROM DMT_SC_EXPT_VER_PROG A" ).append("\n"); 
		query.append("                                WHERE PROP_NO = T3.PROP_NO" ).append("\n"); 
		query.append("                                  AND SC_EXPT_VER_SEQ = T3.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("                                  AND DMDT_EXPT_VER_STS_CD = 'L'" ).append("\n"); 
		query.append("                                  AND ROWNUM = 1 ) ||'-'||' '" ).append("\n"); 
		query.append("                FROM DMT_CHG_BKG_CNTR T1, DMT_CHG_CALC T2, DMT_SC_EXPT_GRP T3" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                AND T1.BKG_NO = AA.BKG_NO" ).append("\n"); 
		query.append("                AND T1.CNTR_NO = AA.CNTR_NO" ).append("\n"); 
		query.append("                AND T1.SYS_AREA_GRP_ID = T2.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                AND T1.CNTR_NO = T2.CNTR_NO" ).append("\n"); 
		query.append("                AND T1.CNTR_CYC_NO = T2.CNTR_CYC_NO" ).append("\n"); 
		query.append("                AND T2.DMDT_TRF_CD = DECODE(DMDT_CALC_TP_CD,'C','CTIC',DECODE(DUL_EXPT_FLG,'N','DMIF','CTIC'))" ).append("\n"); 
		query.append("                AND T2.DMDT_CHG_LOC_DIV_CD = 'POD'" ).append("\n"); 
		query.append("                AND T2.CHG_SEQ = 1" ).append("\n"); 
		query.append("                AND T3.PROP_NO = AA.PROP_NO" ).append("\n"); 
		query.append("                AND T3.SC_EXPT_VER_SEQ = T2.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("                AND T3.SC_EXPT_GRP_SEQ = T2.SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("                AND T3.DMDT_TRF_CD = T2.DMDT_TRF_CD" ).append("\n"); 
		query.append("            ), CASE WHEN ( SELECT COUNT(*) " ).append("\n"); 
		query.append("                            FROM DMT_CHG_BKG_CNTR T1, " ).append("\n"); 
		query.append("                                DMT_CHG_CALC T2" ).append("\n"); 
		query.append("                            WHERE 1=1" ).append("\n"); 
		query.append("                              AND T1.BKG_NO = AA.BKG_NO" ).append("\n"); 
		query.append("                              AND T1.CNTR_NO = AA.CNTR_NO" ).append("\n"); 
		query.append("                              AND T1.SYS_AREA_GRP_ID = T2.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                              AND T1.CNTR_NO = T2.CNTR_NO" ).append("\n"); 
		query.append("                              AND T1.CNTR_CYC_NO = T2.CNTR_CYC_NO" ).append("\n"); 
		query.append("                              AND T2.DMDT_TRF_CD = DECODE(DMDT_CALC_TP_CD,'C','CTIC',DECODE(DUL_EXPT_FLG,'N','DMIF','CTIC'))" ).append("\n"); 
		query.append("                              AND T2.DMDT_CHG_LOC_DIV_CD = 'POD'" ).append("\n"); 
		query.append("                              AND T2.CHG_SEQ = 1 ) != 0 THEN 'NULL'" ).append("\n"); 
		query.append("                    ELSE DMT_SC_EXCEPTION_FNC(AA.BKG_NO,AA.CNTR_NO, @[tml_yd_cd], DECODE(DMDT_CALC_TP_CD,'C','CTIC',DECODE(DUL_EXPT_FLG,'N','DMIF','CTIC')), AA.CNMV_CYC_NO) " ).append("\n"); 
		query.append("                    END" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("            ELSE 'ERROR' END CTRT_INFO" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT DISTINCT BB.BKG_NO," ).append("\n"); 
		query.append("           BB.BL_NO, " ).append("\n"); 
		query.append("           BV.VSL_CD||BV.SKD_VOY_NO||BV.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("           BC.CNTR_NO," ).append("\n"); 
		query.append("           BC.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("           BC.CNMV_CYC_NO," ).append("\n"); 
		query.append("           ( SELECT /*+ INDEX_DESC(A XAK11CTM_MOVEMENT) */ " ).append("\n"); 
		query.append("                    TO_CHAR(CNMV_EVNT_DT,'YYYY-MM-DD')" ).append("\n"); 
		query.append("               FROM CTM_MOVEMENT A" ).append("\n"); 
		query.append("              WHERE CNTR_NO = BC.CNTR_NO" ).append("\n"); 
		query.append("                AND CNMV_CYC_NO <= BC.CNMV_CYC_NO" ).append("\n"); 
		query.append("                AND MVMT_STS_CD = 'OC'" ).append("\n"); 
		query.append("                AND ROWNUM = 1 ) OC_EVNT_DT," ).append("\n"); 
		query.append("           ( SELECT /*+ INDEX_DESC(A XAK13CTM_MOVEMENT) */ " ).append("\n"); 
		query.append("                    TO_CHAR(CNMV_EVNT_DT,'YYYY-MM-DD')" ).append("\n"); 
		query.append("               FROM CTM_MOVEMENT A" ).append("\n"); 
		query.append("              WHERE CNTR_NO = BC.CNTR_NO" ).append("\n"); 
		query.append("                AND BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("                AND CNMV_CYC_NO <= BC.CNMV_CYC_NO" ).append("\n"); 
		query.append("                AND MVMT_STS_CD = 'VD'" ).append("\n"); 
		query.append("                AND ROWNUM = 1 ) VD_EVNT_DT," ).append("\n"); 
		query.append("           ( SELECT CNMV_STS_CD" ).append("\n"); 
		query.append("               FROM MST_CONTAINER A" ).append("\n"); 
		query.append("              WHERE CNTR_NO = BC.CNTR_NO " ).append("\n"); 
		query.append("                AND ROWNUM = 1 ) CNMV_STS_CD," ).append("\n"); 
		query.append("           BB.POL_CD," ).append("\n"); 
		query.append("           BB.POD_CD," ).append("\n"); 
		query.append("           ( SELECT CUST_NM FROM BKG_CUSTOMER WHERE BKG_NO = BB.BKG_NO AND BKG_CUST_TP_CD = 'C' ) CNEE_NM," ).append("\n"); 
		query.append("           ( SELECT CUST_NM FROM BKG_CUSTOMER WHERE BKG_NO = BB.BKG_NO AND BKG_CUST_TP_CD = 'N' ) NOTY_NM," ).append("\n"); 
		query.append("           BB.SC_NO," ).append("\n"); 
		query.append("           BB.RFA_NO," ).append("\n"); 
		query.append("           PS.PROP_NO," ).append("\n"); 
		query.append("		   NVL((" ).append("\n"); 
		query.append("		   		SELECT DMDT_CALC_TP_CD FROM DMT_CALC_TP" ).append("\n"); 
		query.append("				WHERE loc_cd = SUBSTR(@[tml_yd_cd],1,5)" ).append("\n"); 
		query.append("			  	AND IO_BND_CD = 'I'" ).append("\n"); 
		query.append("			  	AND SYSDATE BETWEEN EFF_DT AND NVL(EXP_DT,TO_DATE('99991231','YYYYMMDD'))" ).append("\n"); 
		query.append("				AND ROWNUM = 1 )," ).append("\n"); 
		query.append("			   (" ).append("\n"); 
		query.append("				SELECT DMDT_CALC_TP_CD FROM DMT_CALC_TP" ).append("\n"); 
		query.append("				WHERE CNT_CD = SUBSTR(@[tml_yd_cd],1,2)" ).append("\n"); 
		query.append("  				AND loc_cd = ' '" ).append("\n"); 
		query.append("  				AND IO_BND_CD = 'I'" ).append("\n"); 
		query.append("  				AND SYSDATE BETWEEN EFF_DT AND NVL(EXP_DT,TO_DATE('99991231','YYYYMMDD'))" ).append("\n"); 
		query.append("				AND ROWNUM = 1 )" ).append("\n"); 
		query.append("			) DMDT_CALC_TP_CD," ).append("\n"); 
		query.append("           NVL(DMT_COMBINED_EXCEPTION_FNC(BB.BKG_NO,BC.CNTR_NO, @[tml_yd_cd], 'CTIC', BC.CNMV_CYC_NO),'N') DUL_EXPT_FLG" ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("        SELECT * FROM BKG_VVD V" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("           AND V.VSL_CD = SUBSTR(@[tml_vvd],1,4)" ).append("\n"); 
		query.append("           AND V.SKD_VOY_NO = SUBSTR(@[tml_vvd],5,4)" ).append("\n"); 
		query.append("           AND V.SKD_DIR_CD = SUBSTR(@[tml_vvd],9,1)" ).append("\n"); 
		query.append("           AND V.POD_YD_CD = @[tml_yd_cd]" ).append("\n"); 
		query.append("           AND V.POD_CLPT_IND_SEQ = 1 ) BV" ).append("\n"); 
		query.append("          , BKG_BOOKING BB" ).append("\n"); 
		query.append("          , BKG_CONTAINER BC          " ).append("\n"); 
		query.append("          , PRI_SP_HDR PS" ).append("\n"); 
		query.append("        WHERE BV.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("          AND BV.POD_CD = BB.POD_CD" ).append("\n"); 
		query.append("          AND BB.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("    	  AND BB.BKG_STS_CD = 'F'" ).append("\n"); 
		query.append("    	  AND BB.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("          AND BB.SC_NO = PS.SC_NO(+)" ).append("\n"); 
		query.append("          ) AA" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY VVD, BL_NO, CNTR_NO" ).append("\n"); 

	}
}