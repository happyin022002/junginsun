/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AgentCanalTransitFeeBCDBDAOsearchMsaDisbRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 안준상
*@LastVersion : 1.0
* 2009.08.25 안준상
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jsahn
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgentCanalTransitFeeBCDBDAOsearchMsaDisbRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchMsaDisb
	  * </pre>
	  */
	public AgentCanalTransitFeeBCDBDAOsearchMsaDisbRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.integration").append("\n"); 
		query.append("FileName : AgentCanalTransitFeeBCDBDAOsearchMsaDisbRSQL").append("\n"); 
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
		query.append("SELECT  VSL_CD" ).append("\n"); 
		query.append(",VSL_NM" ).append("\n"); 
		query.append(",SKD_VOY_NO" ).append("\n"); 
		query.append(",SKD_DIR_CD" ).append("\n"); 
		query.append(",VSL_NM||'/'||SKD_VOY_NO||'/'||SKD_DIR_CD VVD" ).append("\n"); 
		query.append(",AMOUNT" ).append("\n"); 
		query.append(",REV_YRMON" ).append("\n"); 
		query.append(",VNDR_SEQ" ).append("\n"); 
		query.append(",YD_CD" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT TO_CHAR(VPS_ETA_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD B" ).append("\n"); 
		query.append("WHERE B.VSL_CD       = A.VSL_CD" ).append("\n"); 
		query.append("AND B.SKD_VOY_NO   = A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND B.SKD_DIR_CD   = A.SKD_DIR_CD" ).append("\n"); 
		query.append("AND B.VPS_PORT_CD  = SUBSTR(A.YD_CD, 1, 5)" ).append("\n"); 
		query.append("--AND B.YD_CD        = A.YD_CD  /* AFTER MOIDFY */" ).append("\n"); 
		query.append(") AS TRNS_DT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT  A.VSL_CD" ).append("\n"); 
		query.append(",(SELECT VSL_ENG_NM" ).append("\n"); 
		query.append("FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("WHERE VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append(") AS VSL_NM" ).append("\n"); 
		query.append(",A.SKD_VOY_NO" ).append("\n"); 
		query.append(",A.SKD_DIR_CD" ).append("\n"); 
		query.append(",(A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD) VVD" ).append("\n"); 
		query.append(",SUM(B.RQST_AMT) AMOUNT" ).append("\n"); 
		query.append(",@[rev_yrmon] REV_YRMON  --'200905'" ).append("\n"); 
		query.append(",@[vndr_seq] VNDR_SEQ  --'2132'" ).append("\n"); 
		query.append(",MAX(A.YD_CD) YD_CD" ).append("\n"); 
		query.append("FROM PSO_CNL_TZ_FEE A, PSO_CNL_TZ_FEE_DTL B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.REV_YRMON = @[rev_yrmon] --'200905'" ).append("\n"); 
		query.append("AND A.VNDR_SEQ = @[vndr_seq]  --'2132'" ).append("\n"); 
		query.append("AND A.PSO_BZTP_CD = 5" ).append("\n"); 
		query.append("AND A.CNL_TZ_BZTP_CD = 'I'" ).append("\n"); 
		query.append("AND A.CNL_TZ_PROC_STS_CD = 'A'" ).append("\n"); 
		query.append("AND A.PSO_BZTP_CD = B.PSO_BZTP_CD" ).append("\n"); 
		query.append("AND A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("AND A.YD_CD = B.YD_CD" ).append("\n"); 
		query.append("AND A.CALL_SEQ = B.CALL_SEQ" ).append("\n"); 
		query.append("GROUP BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("ORDER BY TRNS_DT" ).append("\n"); 

	}
}