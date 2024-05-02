/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScgReportDBDAOsearchScgDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.18
*@LastModifier : 
*@LastVersion : 1.0
* 2013.12.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.scgreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScgReportDBDAOsearchScgDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Surcharge Report에서 선택한 세부사항을 조회한다.
	  * </pre>
	  */
	public ScgReportDBDAOsearchScgDtlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("month",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.report.scgreport.integration").append("\n"); 
		query.append("FileName : ScgReportDBDAOsearchScgDtlRSQL").append("\n"); 
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
		query.append("SELECT MONTH" ).append("\n"); 
		query.append("      ,TRSP_SO_OFC_CTY_CD||TRSP_SO_SEQ SO_NO" ).append("\n"); 
		query.append("      ,TRSP_WO_OFC_CTY_CD||TRSP_WO_SEQ WO_NO" ).append("\n"); 
		query.append("      ,INV_NO" ).append("\n"); 
		query.append("      ,BKG_NO" ).append("\n"); 
		query.append("      ,EQ_NO" ).append("\n"); 
		query.append("      ,EQ_TPSZ_CD" ).append("\n"); 
		query.append("      ,CURR_CD" ).append("\n"); 
		query.append("#if(${scg_type} == 'WO')" ).append("\n"); 
		query.append("      ,MAX(DECODE(NUM, 1, LGS_COST_FULL_NM)) SCG1" ).append("\n"); 
		query.append("      ,SUM(DECODE(NUM, 1, SCG_AMT)) AMT1" ).append("\n"); 
		query.append("      ,MAX(DECODE(NUM, 2, LGS_COST_FULL_NM)) SCG2" ).append("\n"); 
		query.append("      ,SUM(DECODE(NUM, 2, SCG_AMT)) AMT2" ).append("\n"); 
		query.append("      ,MAX(DECODE(NUM, 3, LGS_COST_FULL_NM)) SCG3" ).append("\n"); 
		query.append("      ,SUM(DECODE(NUM, 3, SCG_AMT)) AMT3" ).append("\n"); 
		query.append("      ,MAX(DECODE(NUM, 4, 'Y','N')) MORE_THAN_3" ).append("\n"); 
		query.append("      ,TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("      ,FM_NOD_CD" ).append("\n"); 
		query.append("      ,VIA_NOD_CD" ).append("\n"); 
		query.append("      ,TO_NOD_CD" ).append("\n"); 
		query.append("      ,DOR_NOD_CD" ).append("\n"); 
		query.append("      ,MAX(OTR_RMK) RMK" ).append("\n"); 
		query.append("#elseif(${scg_type} == 'INV')" ).append("\n"); 
		query.append("      ,MAX(DECODE(NUM, 1, LGS_COST_FULL_NM)) SCG1" ).append("\n"); 
		query.append("      ,SUM(DECODE(NUM, 1, INV_SCG_AMT)) AMT1" ).append("\n"); 
		query.append("      ,MAX(DECODE(NUM, 2, LGS_COST_FULL_NM)) SCG2" ).append("\n"); 
		query.append("      ,SUM(DECODE(NUM, 2, INV_SCG_AMT)) AMT2" ).append("\n"); 
		query.append("      ,MAX(DECODE(NUM, 3, LGS_COST_FULL_NM)) SCG3" ).append("\n"); 
		query.append("      ,SUM(DECODE(NUM, 3, INV_SCG_AMT)) AMT3" ).append("\n"); 
		query.append("      ,MAX(DECODE(NUM, 4, 'Y','N')) MORE_THAN_3" ).append("\n"); 
		query.append("      ,TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("      ,FM_NOD_CD" ).append("\n"); 
		query.append("      ,VIA_NOD_CD" ).append("\n"); 
		query.append("      ,TO_NOD_CD" ).append("\n"); 
		query.append("      ,DOR_NOD_CD" ).append("\n"); 
		query.append("      ,MAX(INV_OTR_RMK) RMK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ,INV_RMK" ).append("\n"); 
		query.append("      ,CRE_OFC_CD" ).append("\n"); 
		query.append("      ,VNDR_SEQ" ).append("\n"); 
		query.append("      ,VNDR_NM" ).append("\n"); 
		query.append("      ,CTRT_NO" ).append("\n"); 
		query.append("      ,REPLACE(SHIPPER, chr(34), '') AS SHIPPER" ).append("\n"); 
		query.append("      ,REPLACE(CONSIGNEE, chr(34), '') AS CONSIGNEE" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("RANK () OVER (PARTITION BY A.TRSP_SO_OFC_CTY_CD,A.TRSP_SO_SEQ ORDER BY A.TRSP_SO_OFC_CTY_CD,A.TRSP_SO_SEQ,A.LGS_COST_CD) NUM" ).append("\n"); 
		query.append(",A.TRSP_SO_OFC_CTY_CD,A.TRSP_SO_SEQ,C.TRSP_WO_OFC_CTY_CD,C.TRSP_WO_SEQ,C.INV_NO,C.BKG_NO,C.CURR_CD" ).append("\n"); 
		query.append(",A.LGS_COST_CD, B.LGS_COST_FULL_NM, A.SCG_AMT,A.INV_SCG_AMT,A.OTR_RMK,A.INV_OTR_RMK" ).append("\n"); 
		query.append(",C.TRSP_CRR_MOD_CD,C.FM_NOD_CD,C.VIA_NOD_CD,C.TO_NOD_CD,C.DOR_NOD_CD" ).append("\n"); 
		query.append("#if(${sel_date} == 'inv')" ).append("\n"); 
		query.append(",TO_CHAR(D.INV_CFM_DT,'YYYYMM') MONTH" ).append("\n"); 
		query.append("#elseif(${sel_date} == 'wo')" ).append("\n"); 
		query.append(",TO_CHAR(E.LOCL_CRE_DT,'YYYYMM') MONTH" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",C.EQ_NO,C.EQ_TPSZ_CD,C.INV_RMK,C.CRE_OFC_CD,C.VNDR_SEQ,(SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR WHERE VNDR_SEQ = C.VNDR_SEQ) VNDR_NM" ).append("\n"); 
		query.append(",(SELECT NVL(SC_NO,RFA_NO) FROM BKG_BOOKING WHERE BKG_NO = C.BKG_NO) CTRT_NO" ).append("\n"); 
		query.append("                ,(SELECT REPLACE (CUST_NM, CHR (13) || CHR (10),' ')" ).append("\n"); 
		query.append("                    FROM BKG_CUSTOMER CUST" ).append("\n"); 
		query.append("                   WHERE CUST.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("                     AND CUST.BKG_CUST_TP_CD = 'S' ) AS SHIPPER" ).append("\n"); 
		query.append("                ,(SELECT REPLACE (CUST_NM, CHR (13) || CHR (10),' ')" ).append("\n"); 
		query.append("                    FROM BKG_CUSTOMER CUST" ).append("\n"); 
		query.append("                   WHERE CUST.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("                     AND CUST.BKG_CUST_TP_CD = 'C' ) AS CONSIGNEE" ).append("\n"); 
		query.append(" FROM TRS_TRSP_SCG_DTL A, TES_LGS_COST B, TRS_TRSP_SVC_ORD C, TRS_TRSP_INV_WRK D" ).append("\n"); 
		query.append("#if(${sel_date} == 'wo')" ).append("\n"); 
		query.append("     ,TRS_TRSP_WRK_ORD E" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE A.LGS_COST_CD = B.LGS_COST_CD" ).append("\n"); 
		query.append("  AND A.TRSP_SO_OFC_CTY_CD = C.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("  AND A.TRSP_SO_SEQ = C.TRSP_SO_SEQ" ).append("\n"); 
		query.append("  AND C.INV_NO = D.INV_NO" ).append("\n"); 
		query.append("  AND C.INV_VNDR_SEQ = D.INV_VNDR_SEQ" ).append("\n"); 
		query.append("#if(${sel_date} == 'wo')" ).append("\n"); 
		query.append("   AND C.TRSP_WO_OFC_CTY_CD = E.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("   AND C.TRSP_WO_SEQ = E.TRSP_WO_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  AND C.INV_NO IS NOT NULL" ).append("\n"); 
		query.append("  AND C.TRSP_INV_ACT_STS_CD IS NOT NULL" ).append("\n"); 
		query.append("  AND C.DELT_FLG = 'N' " ).append("\n"); 
		query.append("  AND D.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if(${scg_type} == 'WO')" ).append("\n"); 
		query.append("  AND A.SCG_AMT != 0" ).append("\n"); 
		query.append("#elseif(${scg_type} == 'INV')" ).append("\n"); 
		query.append("  AND A.INV_SCG_AMT != 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  AND A.LGS_COST_CD NOT IN ('SCOTAX','SMOTAX' ,'SCFURD' ,'SCFURT' ,'SCFUTD' ,'SCFUWD' ,'SCFUWR' ,'SCFUWT' ,'SMFURD' ,'SMFURT' ,'SMFUTD' ,'SMFUWD' ,'SMFUWR' ,'SMFUWT', 'SCHLOP', 'SCHLCF')" ).append("\n"); 
		query.append("#if (${sel_op_tp} == 'SINGLE')" ).append("\n"); 
		query.append("  AND C.CRE_OFC_CD = @[wo_ofc_cd]" ).append("\n"); 
		query.append("#if(${sel_date} == 'inv')" ).append("\n"); 
		query.append("  AND D.INV_CFM_DT BETWEEN TO_DATE(REPLACE(@[month],'-','')||'01', 'YYYYMMDD') AND LAST_DAY(TO_DATE(REPLACE(@[month],'-',''),'YYYYMM'))+0.99999999" ).append("\n"); 
		query.append("#elseif(${sel_date} == 'wo')" ).append("\n"); 
		query.append("  AND E.LOCL_CRE_DT BETWEEN TO_DATE(REPLACE(@[month],'-','')||'01', 'YYYYMMDD') AND LAST_DAY(TO_DATE(REPLACE(@[month],'-',''),'YYYYMM'))+0.99999999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  AND D.CRE_OFC_CD = @[inv_ofc_cd]" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("#if (${sel_op_tp} != 'SINGLE')" ).append("\n"); 
		query.append("  AND(" ).append("\n"); 
		query.append("     #foreach( $multi_conditions in ${conditions}) " ).append("\n"); 
		query.append("         #if($velocityCount != 1) " ).append("\n"); 
		query.append("  OR" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("      $multi_conditions" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append(" )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("T" ).append("\n"); 
		query.append("GROUP BY MONTH" ).append("\n"); 
		query.append("        ,TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("        ,TRSP_SO_SEQ" ).append("\n"); 
		query.append("        ,TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("        ,TRSP_WO_SEQ" ).append("\n"); 
		query.append("        ,INV_NO" ).append("\n"); 
		query.append("        ,BKG_NO" ).append("\n"); 
		query.append("        ,EQ_NO" ).append("\n"); 
		query.append("        ,EQ_TPSZ_CD" ).append("\n"); 
		query.append("        ,CURR_CD" ).append("\n"); 
		query.append("        ,TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("        ,FM_NOD_CD" ).append("\n"); 
		query.append("        ,VIA_NOD_CD" ).append("\n"); 
		query.append("        ,TO_NOD_CD" ).append("\n"); 
		query.append("        ,DOR_NOD_CD" ).append("\n"); 
		query.append("        ,INV_RMK" ).append("\n"); 
		query.append("        ,CRE_OFC_CD" ).append("\n"); 
		query.append("        ,VNDR_SEQ" ).append("\n"); 
		query.append("        ,VNDR_NM" ).append("\n"); 
		query.append("        ,CTRT_NO" ).append("\n"); 
		query.append("        ,SHIPPER" ).append("\n"); 
		query.append("        ,CONSIGNEE" ).append("\n"); 

	}
}