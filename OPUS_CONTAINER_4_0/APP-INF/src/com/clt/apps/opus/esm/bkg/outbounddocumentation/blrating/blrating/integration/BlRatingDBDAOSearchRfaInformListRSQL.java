/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BlRatingDBDAOSearchRfaInformListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.30
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2009.09.30 김태경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOSearchRfaInformListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SC 정보를 조회한다.
	  * </pre>
	  */
	public BlRatingDBDAOSearchRfaInformListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOSearchRfaInformListRSQL").append("\n"); 
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
		query.append("/* 강제로 SearchScOftAutoratingListVO 만듬 */" ).append("\n"); 
		query.append("#if(${rate_type} =='SC')" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'' RT_MTCH_PATT_CD," ).append("\n"); 
		query.append("'' CMDT_NM," ).append("\n"); 
		query.append("'' POR_CD," ).append("\n"); 
		query.append("'' POL_CD," ).append("\n"); 
		query.append("'' POD_CD," ).append("\n"); 
		query.append("'' DEL_CD," ).append("\n"); 
		query.append("'' DIR_CALL_FLG," ).append("\n"); 
		query.append("'' RCV_DE_TERM_CD," ).append("\n"); 
		query.append("'' RAT_UT_CD," ).append("\n"); 
		query.append("'' PRC_CGO_TP_CD," ).append("\n"); 
		query.append("'' CURR_CD," ).append("\n"); 
		query.append("'' ORG_TRSP_MOD_CD," ).append("\n"); 
		query.append("'' DEST_TRSP_MOD_CD," ).append("\n"); 
		query.append("'' RT_FNL_FRT_RT_AMT," ).append("\n"); 
		query.append("'' TRNS_MOD_CD," ).append("\n"); 
		query.append("'' BQ_CTRT_CNTR_QTY," ).append("\n"); 
		query.append("'' NOTE_CTNT," ).append("\n"); 
		query.append("'' DTL," ).append("\n"); 
		query.append("'' NOTE" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'G3' PT" ).append("\n"); 
		query.append(",'RFA02(SEE TERM 3. GRO)' COMMODITY_DESCRIPTION" ).append("\n"); 
		query.append(",'RFASP' POR" ).append("\n"); 
		query.append(",'N/A' POL" ).append("\n"); 
		query.append(",'RFALGB' POD" ).append("\n"); 
		query.append(",'RFALGB' DEL" ).append("\n"); 
		query.append(",'Y' D_CALL" ).append("\n"); 
		query.append(",'N/Y' RD" ).append("\n"); 
		query.append(",'R5' PER" ).append("\n"); 
		query.append(",'FR' CGO_TP" ).append("\n"); 
		query.append(",'KR' CUR" ).append("\n"); 
		query.append(",'154' AMOUNT" ).append("\n"); 
		query.append(",'R/F' TRANS_MODE" ).append("\n"); 
		query.append(",'2' Q_TY" ).append("\n"); 
		query.append(",'DTL' DTL" ).append("\n"); 
		query.append(",'NT' NT_V" ).append("\n"); 
		query.append(",'' NT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'G4' PT" ).append("\n"); 
		query.append(",'BBBP02( TEST 3. TEST)' COMMODITY_DESCRIPTION" ).append("\n"); 
		query.append(",'ODSBSP' POR" ).append("\n"); 
		query.append(",'A/S' POL" ).append("\n"); 
		query.append(",'DDGB' POD" ).append("\n"); 
		query.append(",'FS' DEL" ).append("\n"); 
		query.append(",'Y' D_CALL" ).append("\n"); 
		query.append(",'N/N' RD" ).append("\n"); 
		query.append(",'D5' PER" ).append("\n"); 
		query.append(",'DR' CGO_TP" ).append("\n"); 
		query.append(",'USD' CUR" ).append("\n"); 
		query.append(",'1654' AMOUNT" ).append("\n"); 
		query.append(",'X/X' TRANS_MODE" ).append("\n"); 
		query.append(",'2' Q_TY" ).append("\n"); 
		query.append(",'DTL' DTL" ).append("\n"); 
		query.append(",'NT' NT_V" ).append("\n"); 
		query.append(",'TTTTTTTTTTTTTTTTTTTTTTTT' NT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}