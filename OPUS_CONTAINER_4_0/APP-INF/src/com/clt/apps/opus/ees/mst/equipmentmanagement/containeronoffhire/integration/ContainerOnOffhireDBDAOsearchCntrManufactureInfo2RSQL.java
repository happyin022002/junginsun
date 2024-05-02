/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOsearchCntrManufactureInfo2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.20
*@LastModifier : 
*@LastVersion : 1.0
* 2010.08.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOsearchCntrManufactureInfo2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Ticket ID : CHM-201005431-01
	  * searchCntrManufactureInfo - EXCEL UPLOAD DATA 검증 Query
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOsearchCntrManufactureInfo2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aeflg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eeflg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("beflg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mftr_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mft_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ceflg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("deflg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOsearchCntrManufactureInfo2RSQL").append("\n"); 
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
		query.append("      A1.CNTR_NO" ).append("\n"); 
		query.append("     ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     ,A.LSTM_CD" ).append("\n"); 
		query.append("     ,TO_CHAR(A.ONH_DT, 'YYYY-MM-DD') ONH_DT" ).append("\n"); 
		query.append("     ,A.ONH_YD_CD" ).append("\n"); 
		query.append("     ,A1.MFT_DT" ).append("\n"); 
		query.append("     ,A1.MFTR_VNDR_SEQ" ).append("\n"); 
		query.append("     ,A.VNDR_SEQ" ).append("\n"); 
		query.append("     ,CASE WHEN A1.BEFLAG IS NULL THEN" ).append("\n"); 
		query.append("        (SELECT NVL(B.VNDR_ABBR_NM,VNDR_LGL_ENG_NM) CODE_NM" ).append("\n"); 
		query.append("         FROM MDM_VENDOR B" ).append("\n"); 
		query.append("         WHERE B.VNDR_SEQ = A1.MFTR_VNDR_SEQ" ).append("\n"); 
		query.append("           AND NVL(B.DELT_FLG, 'N') = 'N')" ).append("\n"); 
		query.append("      ELSE'' " ).append("\n"); 
		query.append("      END AS MFTR_VNDR_NM" ).append("\n"); 
		query.append("     ,DECODE(A.LSTM_CD, 'ST', '' ,'LT', '', 'E') AS AEFLG" ).append("\n"); 
		query.append("     ,CASE WHEN A1.BEFLAG IS NULL THEN" ).append("\n"); 
		query.append("        DECODE((SELECT COUNT(1)" ).append("\n"); 
		query.append("                FROM MDM_CNTR_VNDR_CLSS A," ).append("\n"); 
		query.append("                     MDM_VENDOR B" ).append("\n"); 
		query.append("                WHERE A.CNTR_VNDR_SVC_CD ='MFR'" ).append("\n"); 
		query.append("                AND A.VNDR_SEQ = A1.MFTR_VNDR_SEQ" ).append("\n"); 
		query.append("                AND A.VNDR_SEQ = B.VNDR_SEQ" ).append("\n"); 
		query.append("                AND NVL(A.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                AND NVL(B.DELT_FLG, 'N') = 'N'),0,'E','') " ).append("\n"); 
		query.append("     ELSE" ).append("\n"); 
		query.append("    	DECODE(A1.MFTR_VNDR_SEQ,NULL,'','E') -- mftr_vndr_seq가 null인경우는 처리한다.		 " ).append("\n"); 
		query.append("     END AS BEFLG" ).append("\n"); 
		query.append("    ,CASE WHEN A1.MFT_DT='' THEN '' ELSE DECODE(A1.CEFLAG,'E','E','') END AS CEFLG" ).append("\n"); 
		query.append("    ,DECODE(A1.DEFLAG,'E','E','') DEFLG" ).append("\n"); 
		query.append("    ,'' EEFLG" ).append("\n"); 
		query.append("FROM MST_CONTAINER A," ).append("\n"); 
		query.append("    (SELECT  SUBSTR( CNTR_NO,INSTR(CNTR_NO, '|', 1, LEVEL) + 1,INSTR(CNTR_NO, '|', 1, LEVEL + 1) - INSTR(CNTR_NO, '|', 1, LEVEL) - 1) AS CNTR_NO," ).append("\n"); 
		query.append("             SUBSTR( MFTR_VNDR_SEQ,INSTR(MFTR_VNDR_SEQ, '|', 1, LEVEL) + 1 ,INSTR(MFTR_VNDR_SEQ, '|', 1, LEVEL + 1) - INSTR(MFTR_VNDR_SEQ, '|', 1, LEVEL) - 1) AS MFTR_VNDR_SEQ ," ).append("\n"); 
		query.append("             SUBSTR( MFT_DT,INSTR(MFT_DT, '|', 1, LEVEL) + 1,INSTR(MFT_DT, '|', 1, LEVEL + 1) - INSTR(MFT_DT, '|', 1, LEVEL) - 1) AS MFT_DT," ).append("\n"); 
		query.append("             SUBSTR( AEFLAG,INSTR(AEFLAG, '|', 1, LEVEL) + 1,INSTR(AEFLAG, '|', 1, LEVEL + 1) - INSTR(AEFLAG, '|', 1, LEVEL) - 1) AS AEFLAG," ).append("\n"); 
		query.append("             SUBSTR( BEFLAG,INSTR(BEFLAG, '|', 1, LEVEL) + 1,INSTR(BEFLAG, '|', 1, LEVEL + 1) - INSTR(BEFLAG, '|', 1, LEVEL) - 1) AS BEFLAG," ).append("\n"); 
		query.append("             SUBSTR( CEFLAG,INSTR(CEFLAG, '|', 1, LEVEL) + 1,INSTR(CEFLAG, '|', 1, LEVEL + 1) - INSTR(CEFLAG, '|', 1, LEVEL) - 1) AS CEFLAG," ).append("\n"); 
		query.append("             SUBSTR( DEFLAG,INSTR(DEFLAG, '|', 1, LEVEL) + 1,INSTR(DEFLAG, '|', 1, LEVEL + 1) - INSTR(DEFLAG, '|', 1, LEVEL) - 1) AS DEFLAG," ).append("\n"); 
		query.append("             SUBSTR( EEFLAG,INSTR(EEFLAG, '|', 1, LEVEL) + 1,INSTR(EEFLAG, '|', 1, LEVEL + 1) - INSTR(EEFLAG, '|', 1, LEVEL) - 1) AS EEFLAG" ).append("\n"); 
		query.append("    FROM (SELECT  @[cntr_no] AS CNTR_NO," ).append("\n"); 
		query.append("                  @[mftr_vndr_seq] AS MFTR_VNDR_SEQ," ).append("\n"); 
		query.append("                  @[mft_dt] AS MFT_DT," ).append("\n"); 
		query.append("                  @[aeflg] AS AEFLAG," ).append("\n"); 
		query.append("                  @[beflg] AS BEFLAG," ).append("\n"); 
		query.append("                  @[ceflg] AS CEFLAG," ).append("\n"); 
		query.append("                  @[deflg] AS DEFLAG," ).append("\n"); 
		query.append("                  @[eeflg] AS EEFLAG" ).append("\n"); 
		query.append("            FROM dual)" ).append("\n"); 
		query.append("    CONNECT BY LEVEL <= LENGTH(CNTR_NO) - LENGTH(REPLACE(CNTR_NO, '|')) - 1" ).append("\n"); 
		query.append("    )A1" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("  AND A.CNTR_NO(+) = A1.CNTR_NO" ).append("\n"); 

	}
}