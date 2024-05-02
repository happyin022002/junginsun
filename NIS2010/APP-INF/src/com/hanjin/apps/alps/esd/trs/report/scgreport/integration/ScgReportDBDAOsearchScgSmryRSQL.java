/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ScgReportDBDAOsearchScgSmryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.07 
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

public class ScgReportDBDAOsearchScgSmryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Surcharge Report 를 조회한다.
	  * </pre>
	  */
	public ScgReportDBDAOsearchScgSmryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("input_office",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_date",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.report.scgreport.integration").append("\n"); 
		query.append("FileName : ScgReportDBDAOsearchScgSmryRSQL").append("\n"); 
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
		query.append("SELECT B.CRE_OFC_CD WO_OFC_CD" ).append("\n"); 
		query.append("      ,C.CRE_OFC_CD INV_OFC_CD" ).append("\n"); 
		query.append("#if(${sel_date} == 'inv')" ).append("\n"); 
		query.append("      ,TO_CHAR(C.INV_CFM_DT,'YYYYMM') MONTH" ).append("\n"); 
		query.append("#elseif(${sel_date} == 'wo')" ).append("\n"); 
		query.append("      ,TO_CHAR(E.LOCL_CRE_DT,'YYYYMM') MONTH" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ,COUNT(DISTINCT B.TRSP_SO_OFC_CTY_CD||B.TRSP_SO_SEQ) BOX_COUNT" ).append("\n"); 
		query.append("      ,'USD' CURR" ).append("\n"); 
		query.append("#if(${scg_type} == 'WO')" ).append("\n"); 
		query.append("      ,SUM(DECODE(B.CURR_CD, 'USD', A.SCG_AMT, ROUND(A.SCG_AMT/D.USD_LOCL_XCH_RT, 2))) TOT_AMT" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'ALAL', DECODE(B.CURR_CD, 'USD', A.SCG_AMT, ROUND(A.SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) ADD_LABOR" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'LWAL', DECODE(B.CURR_CD, 'USD', A.SCG_AMT, ROUND(A.SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) BARGE_LOW" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'CDAL', DECODE(B.CURR_CD, 'USD', A.SCG_AMT, ROUND(A.SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) CHASSIS" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'DPAL', DECODE(B.CURR_CD, 'USD', A.SCG_AMT, ROUND(A.SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) DROP_PULL" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'DRAL', DECODE(B.CURR_CD, 'USD', A.SCG_AMT, ROUND(A.SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) DRY_RUN" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'FRAL', DECODE(B.CURR_CD, 'USD', A.SCG_AMT, ROUND(A.SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) FERRY_COST" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'FIAL', DECODE(B.CURR_CD, 'USD', A.SCG_AMT, ROUND(A.SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) FINE" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'FGAL', DECODE(B.CURR_CD, 'USD', A.SCG_AMT, ROUND(A.SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) FUMIGATION" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'GNAL', DECODE(B.CURR_CD, 'USD', A.SCG_AMT, ROUND(A.SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) GEN_SET" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'HZAL', DECODE(B.CURR_CD, 'USD', A.SCG_AMT, ROUND(A.SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) HAZMAT" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'INAL', DECODE(B.CURR_CD, 'USD', A.SCG_AMT, ROUND(A.SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) INSPECTION" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'LFAL', DECODE(B.CURR_CD, 'USD', A.SCG_AMT, ROUND(A.SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) LIFTING" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'MDAL', DECODE(B.CURR_CD, 'USD', A.SCG_AMT, ROUND(A.SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) MULTIPLE" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'OSAL', DECODE(B.CURR_CD, 'USD', A.SCG_AMT, ROUND(A.SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) OVER_SIZE" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'OWAL', DECODE(B.CURR_CD, 'USD', A.SCG_AMT, ROUND(A.SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) OVER_WEIGHT" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'PPAL', DECODE(B.CURR_CD, 'USD', A.SCG_AMT, ROUND(A.SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) PRE_PULL" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'RCAL', DECODE(B.CURR_CD, 'USD', A.SCG_AMT, ROUND(A.SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) REDIRECTION" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'SSAL', DECODE(B.CURR_CD, 'USD', A.SCG_AMT, ROUND(A.SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) SCALE_STOP" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'SRAL', DECODE(B.CURR_CD, 'USD', A.SCG_AMT, ROUND(A.SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) STORAGE" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'STAL', DECODE(B.CURR_CD, 'USD', A.SCG_AMT, ROUND(A.SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) STREET_TURN" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'SNAL', DECODE(B.CURR_CD, 'USD', A.SCG_AMT, ROUND(A.SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) SUNDAY" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'SFAL', DECODE(B.CURR_CD, 'USD', A.SCG_AMT, ROUND(A.SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) SWING_FLIP" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'TDAL', DECODE(B.CURR_CD, 'USD', A.SCG_AMT, ROUND(A.SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) T_DOC" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'TLAL', DECODE(B.CURR_CD, 'USD', A.SCG_AMT, ROUND(A.SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) TOLL" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'WTAL', DECODE(B.CURR_CD, 'USD', A.SCG_AMT, ROUND(A.SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) WAITING_CHARGE" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'OTAL', DECODE(B.CURR_CD, 'USD', A.SCG_AMT, ROUND(A.SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) OTHER" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'ENAL', DECODE(B.CURR_CD, 'USD', A.SCG_AMT, ROUND(A.SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) ENSF" ).append("\n"); 
		query.append("#elseif(${scg_type} == 'INV')" ).append("\n"); 
		query.append("      ,SUM(DECODE(B.CURR_CD, 'USD', A.INV_SCG_AMT, ROUND(A.INV_SCG_AMT/D.USD_LOCL_XCH_RT, 2))) TOT_AMT" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'ALAL', DECODE(B.CURR_CD, 'USD', A.INV_SCG_AMT, ROUND(A.INV_SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) ADD_LABOR" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'LWAL', DECODE(B.CURR_CD, 'USD', A.INV_SCG_AMT, ROUND(A.INV_SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) BARGE_LOW" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'CDAL', DECODE(B.CURR_CD, 'USD', A.INV_SCG_AMT, ROUND(A.INV_SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) CHASSIS" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'DPAL', DECODE(B.CURR_CD, 'USD', A.INV_SCG_AMT, ROUND(A.INV_SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) DROP_PULL" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'DRAL', DECODE(B.CURR_CD, 'USD', A.INV_SCG_AMT, ROUND(A.INV_SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) DRY_RUN" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'FRAL', DECODE(B.CURR_CD, 'USD', A.INV_SCG_AMT, ROUND(A.INV_SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) FERRY_COST" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'FIAL', DECODE(B.CURR_CD, 'USD', A.INV_SCG_AMT, ROUND(A.INV_SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) FINE" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'FGAL', DECODE(B.CURR_CD, 'USD', A.INV_SCG_AMT, ROUND(A.INV_SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) FUMIGATION" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'GNAL', DECODE(B.CURR_CD, 'USD', A.INV_SCG_AMT, ROUND(A.INV_SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) GEN_SET" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'HZAL', DECODE(B.CURR_CD, 'USD', A.INV_SCG_AMT, ROUND(A.INV_SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) HAZMAT" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'INAL', DECODE(B.CURR_CD, 'USD', A.INV_SCG_AMT, ROUND(A.INV_SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) INSPECTION" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'LFAL', DECODE(B.CURR_CD, 'USD', A.INV_SCG_AMT, ROUND(A.INV_SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) LIFTING" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'MDAL', DECODE(B.CURR_CD, 'USD', A.INV_SCG_AMT, ROUND(A.INV_SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) MULTIPLE" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'OSAL', DECODE(B.CURR_CD, 'USD', A.INV_SCG_AMT, ROUND(A.INV_SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) OVER_SIZE" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'OWAL', DECODE(B.CURR_CD, 'USD', A.INV_SCG_AMT, ROUND(A.INV_SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) OVER_WEIGHT" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'PPAL', DECODE(B.CURR_CD, 'USD', A.INV_SCG_AMT, ROUND(A.INV_SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) PRE_PULL" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'RCAL', DECODE(B.CURR_CD, 'USD', A.INV_SCG_AMT, ROUND(A.INV_SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) REDIRECTION" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'SSAL', DECODE(B.CURR_CD, 'USD', A.INV_SCG_AMT, ROUND(A.INV_SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) SCALE_STOP" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'SRAL', DECODE(B.CURR_CD, 'USD', A.INV_SCG_AMT, ROUND(A.INV_SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) STORAGE" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'STAL', DECODE(B.CURR_CD, 'USD', A.INV_SCG_AMT, ROUND(A.INV_SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) STREET_TURN" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'SNAL', DECODE(B.CURR_CD, 'USD', A.INV_SCG_AMT, ROUND(A.INV_SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) SUNDAY" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'SFAL', DECODE(B.CURR_CD, 'USD', A.INV_SCG_AMT, ROUND(A.INV_SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) SWING_FLIP" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'TDAL', DECODE(B.CURR_CD, 'USD', A.INV_SCG_AMT, ROUND(A.INV_SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) T_DOC" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'TLAL', DECODE(B.CURR_CD, 'USD', A.INV_SCG_AMT, ROUND(A.INV_SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) TOLL" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'WTAL', DECODE(B.CURR_CD, 'USD', A.INV_SCG_AMT, ROUND(A.INV_SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) WAITING_CHARGE" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'OTAL', DECODE(B.CURR_CD, 'USD', A.INV_SCG_AMT, ROUND(A.INV_SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) OTHER" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(A.LGS_COST_CD,3,6),'ENAL', DECODE(B.CURR_CD, 'USD', A.INV_SCG_AMT, ROUND(A.INV_SCG_AMT/D.USD_LOCL_XCH_RT, 2)))) ENSF" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  FROM TRS_TRSP_SCG_DTL A, TRS_TRSP_SVC_ORD B, TRS_TRSP_INV_WRK C, GL_MON_XCH_RT D" ).append("\n"); 
		query.append("#if(${sel_date} == 'wo')" ).append("\n"); 
		query.append("      ,TRS_TRSP_WRK_ORD E" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" WHERE A.TRSP_SO_OFC_CTY_CD = B.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("   AND A.TRSP_SO_SEQ = B.TRSP_SO_SEQ" ).append("\n"); 
		query.append("   AND B.INV_NO = C.INV_NO" ).append("\n"); 
		query.append("   AND B.INV_VNDR_SEQ = C.INV_VNDR_SEQ" ).append("\n"); 
		query.append("#if(${sel_date} == 'wo')" ).append("\n"); 
		query.append("   AND B.TRSP_WO_OFC_CTY_CD = E.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("   AND B.TRSP_WO_SEQ = E.TRSP_WO_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND B.INV_NO IS NOT NULL" ).append("\n"); 
		query.append("   AND B.TRSP_INV_ACT_STS_CD IS NOT NULL" ).append("\n"); 
		query.append("#if(${scg_type} == 'WO')" ).append("\n"); 
		query.append("   AND A.SCG_AMT != 0" ).append("\n"); 
		query.append("   AND B.CRE_OFC_CD IN (SELECT COLUMN_VALUE FROM TABLE(BKG_SPLIT_FNC(@[input_office], ',')))" ).append("\n"); 
		query.append("#elseif(${scg_type} == 'INV')" ).append("\n"); 
		query.append("   AND A.INV_SCG_AMT != 0" ).append("\n"); 
		query.append("   AND C.CRE_OFC_CD IN (SELECT COLUMN_VALUE FROM TABLE(BKG_SPLIT_FNC(@[input_office], ',')))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND A.LGS_COST_CD NOT IN ('SCOTAX','SMOTAX' ,'SCFURD' ,'SCFURT' ,'SCFUTD' ,'SCFUWD' ,'SCFUWR' ,'SCFUWT' ,'SMFURD' ,'SMFURT' ,'SMFUTD' ,'SMFUWD' ,'SMFUWR' ,'SMFUWT', 'SCHLOP', 'SCHLCF')" ).append("\n"); 
		query.append("   AND B.DELT_FLG= 'N'" ).append("\n"); 
		query.append("   AND C.DELT_FLG= 'N'" ).append("\n"); 
		query.append("#if(${sel_date} == 'inv')" ).append("\n"); 
		query.append("   AND C.INV_CFM_DT BETWEEN TO_DATE(REPLACE(@[from_date],'-',''), 'YYYYMMDD') AND TO_DATE(REPLACE(@[to_date],'-',''),'YYYYMMDD')+ 0.99999 /* 0.99999 는 23시 59분 59초를 의미 */ " ).append("\n"); 
		query.append("#elseif(${sel_date} == 'wo')" ).append("\n"); 
		query.append("   AND E.LOCL_CRE_DT BETWEEN TO_DATE(REPLACE(@[from_date],'-',''), 'YYYYMMDD') AND TO_DATE(REPLACE(@[to_date],'-',''),'YYYYMMDD')+ 0.99999 /* 0.99999 는 23시 59분 59초를 의미 */ " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sel_date} == 'inv')" ).append("\n"); 
		query.append("   AND D.ACCT_XCH_RT_YRMON = TO_CHAR(C.INV_CFM_DT, 'YYYYMM')" ).append("\n"); 
		query.append("#elseif(${sel_date} == 'wo')" ).append("\n"); 
		query.append("   AND D.ACCT_XCH_RT_YRMON = TO_CHAR(E.LOCL_CRE_DT, 'YYYYMM')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND D.CURR_CD = B.CURR_CD" ).append("\n"); 
		query.append("   AND D.ACCT_XCH_RT_LVL = 1" ).append("\n"); 
		query.append("#if(${sel_date} == 'inv')" ).append("\n"); 
		query.append(" GROUP BY B.CRE_OFC_CD,C.CRE_OFC_CD, TO_CHAR(C.INV_CFM_DT,'YYYYMM')" ).append("\n"); 
		query.append("#elseif(${sel_date} == 'wo')" ).append("\n"); 
		query.append(" GROUP BY B.CRE_OFC_CD,C.CRE_OFC_CD, TO_CHAR(E.LOCL_CRE_DT,'YYYYMM')" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}