/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AgentCanalTransitFeeBCDBDAOsearchMsaBalRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.29
*@LastModifier : Park Yeon-Jin
*@LastVersion : 1.0
* 2012.08.29 Park Yeon-Jin
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Yeon-Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgentCanalTransitFeeBCDBDAOsearchMsaBalRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchMsaBal
	  * </pre>
	  */
	public AgentCanalTransitFeeBCDBDAOsearchMsaBalRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.integration").append("\n"); 
		query.append("FileName : AgentCanalTransitFeeBCDBDAOsearchMsaBalRSQL").append("\n"); 
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
		query.append("SELECT  A.MSA_SEQ" ).append("\n"); 
		query.append(",A.PSO_MSA_AMT_TP_CD" ).append("\n"); 
		query.append(",A.ITEM" ).append("\n"); 
		query.append(",(CASE WHEN B.TTL_AMT<0 THEN ABS(B.TTL_AMT) ELSE 0 END) AMOUNT_DEBIT" ).append("\n"); 
		query.append(",(CASE WHEN B.TTL_AMT>=0 THEN ABS(B.TTL_AMT) ELSE 0 END) AMOUNT_CREDIT" ).append("\n"); 
		query.append(",B.DIFF_RMK" ).append("\n"); 
		query.append(",@[rev_yrmon] REV_YRMON" ).append("\n"); 
		query.append(",@[vndr_seq] VNDR_SEQ" ).append("\n"); 
		query.append(",B.PSO_MSA_STS_CD" ).append("\n"); 
		query.append(",B.EXIST" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("--ITEM" ).append("\n"); 
		query.append("SELECT  LEVEL MSA_SEQ" ).append("\n"); 
		query.append(",DECODE(LEVEL,1,'A',2,'B',3,'C',4,'O') PSO_MSA_AMT_TP_CD" ).append("\n"); 
		query.append(",DECODE(LEVEL,1,'BEGINNING BALANCE'," ).append("\n"); 
		query.append("2,'REMITTANCE FROM HANJIN'," ).append("\n"); 
		query.append("3,'DISBURSEMENT'," ).append("\n"); 
		query.append("4,'OTHERS'" ).append("\n"); 
		query.append(") ITEM" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("CONNECT BY LEVEL <= 4" ).append("\n"); 
		query.append(") A," ).append("\n"); 
		query.append("( --존재할경우" ).append("\n"); 
		query.append("SELECT  T2.PSO_MSA_AMT_TP_CD" ).append("\n"); 
		query.append(",DECODE(T2.PSO_MSA_AMT_TP_CD,'B',(-1)*ABS(T2.TTL_AMT),'C',ABS(T2.TTL_AMT),T2.TTL_AMT) TTL_AMT  --Remittance는 무조건 -, Disbursement는 무조건 +" ).append("\n"); 
		query.append(",T2.DIFF_RMK" ).append("\n"); 
		query.append(",T1.PSO_MSA_STS_CD" ).append("\n"); 
		query.append(",'Y' EXIST" ).append("\n"); 
		query.append("FROM PSO_MSA T1, PSO_MSA_DTL T2" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND T1.REV_YRMON = T2.REV_YRMON" ).append("\n"); 
		query.append("AND T1.VNDR_SEQ = T2.VNDR_SEQ" ).append("\n"); 
		query.append("AND T1.REV_YRMON = @[rev_yrmon]" ).append("\n"); 
		query.append("AND T1.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("AND T1.PSO_MSA_STS_CD <> 'R'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("--존재하지않을경우" ).append("\n"); 
		query.append("SELECT  PSO_MSA_AMT_TP_CD" ).append("\n"); 
		query.append(",TTL_AMT" ).append("\n"); 
		query.append(",'' DIFF_RMK" ).append("\n"); 
		query.append(",'' PSO_MSA_STS_CD" ).append("\n"); 
		query.append(",'N' EXIST" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT 'A' PSO_MSA_AMT_TP_CD" ).append("\n"); 
		query.append(",(SUM(DECODE(PSO_MSA_AMT_TP_CD,'B',TTL_AMT,'0'))" ).append("\n"); 
		query.append("-SUM(DECODE(PSO_MSA_AMT_TP_CD,'C',TTL_AMT,'0'))" ).append("\n"); 
		query.append("+SUM(DECODE(PSO_MSA_AMT_TP_CD,'A',TTL_AMT,'0'))" ).append("\n"); 
		query.append("+SUM(DECODE(PSO_MSA_AMT_TP_CD,'O',TTL_AMT,'0'))" ).append("\n"); 
		query.append(") TTL_AMT" ).append("\n"); 
		query.append("FROM PSO_MSA_DTL" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND REV_YRMON = TO_CHAR(TO_DATE(@[rev_yrmon],'YYYYMM')-1,'YYYYMM')" ).append("\n"); 
		query.append("AND VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'B' PSO_MSA_AMT_TP_CD" ).append("\n"); 
		query.append(",ABS(NVL(SUM(B.RQST_AMT),0))*(-1) TTL_AMT  --Remittance는 무조건 -" ).append("\n"); 
		query.append("FROM PSO_CNL_TZ_FEE A, PSO_CNL_TZ_FEE_DTL B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.REV_YRMON = @[rev_yrmon]" ).append("\n"); 
		query.append("AND A.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("AND A.CNL_TZ_BZTP_CD = 'E'" ).append("\n"); 
		query.append("AND A.CNL_TZ_PROC_STS_CD IN ('A','P')" ).append("\n"); 
		query.append("AND A.PSO_BZTP_CD = 5" ).append("\n"); 
		query.append("AND A.PSO_BZTP_CD = B.PSO_BZTP_CD" ).append("\n"); 
		query.append("AND A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("AND A.YD_CD = B.YD_CD" ).append("\n"); 
		query.append("AND A.CALL_SEQ = B.CALL_SEQ" ).append("\n"); 
		query.append("AND A.BUD_SCNR_NO 		= '999912'" ).append("\n"); 
		query.append("AND A.BUD_SCNR_NO 		= B.BUD_SCNR_NO" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'C' PSO_MSA_AMT_TP_CD" ).append("\n"); 
		query.append(",ABS(NVL(SUM(B.RQST_AMT),0)) TTL_AMT  --Disbursement는 무조건 +" ).append("\n"); 
		query.append("FROM PSO_CNL_TZ_FEE A, PSO_CNL_TZ_FEE_DTL B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.REV_YRMON = @[rev_yrmon]" ).append("\n"); 
		query.append("AND A.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("AND A.CNL_TZ_BZTP_CD = 'I'" ).append("\n"); 
		query.append("AND A.CNL_TZ_PROC_STS_CD = 'A'" ).append("\n"); 
		query.append("AND A.PSO_BZTP_CD = 5" ).append("\n"); 
		query.append("AND A.PSO_BZTP_CD = B.PSO_BZTP_CD" ).append("\n"); 
		query.append("AND A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("AND A.YD_CD = B.YD_CD" ).append("\n"); 
		query.append("AND A.CALL_SEQ = B.CALL_SEQ" ).append("\n"); 
		query.append("AND A.BUD_SCNR_NO 		= '999912'" ).append("\n"); 
		query.append("AND A.BUD_SCNR_NO 		= B.BUD_SCNR_NO" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND 0 = (SELECT COUNT(REV_YRMON)" ).append("\n"); 
		query.append("FROM PSO_MSA" ).append("\n"); 
		query.append("WHERE REV_YRMON = @[rev_yrmon]" ).append("\n"); 
		query.append("AND VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("AND PSO_MSA_STS_CD <> 'R'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.PSO_MSA_AMT_TP_CD = B.PSO_MSA_AMT_TP_CD(+)" ).append("\n"); 

	}
}