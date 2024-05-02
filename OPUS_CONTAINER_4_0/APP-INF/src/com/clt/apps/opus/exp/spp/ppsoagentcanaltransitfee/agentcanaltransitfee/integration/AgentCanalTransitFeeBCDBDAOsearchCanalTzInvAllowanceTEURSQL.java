/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AgentCanalTransitFeeBCDBDAOsearchCanalTzInvAllowanceTEURSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.06
*@LastModifier : 안준상
*@LastVersion : 1.0
* 2010.01.06 안준상
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

public class AgentCanalTransitFeeBCDBDAOsearchCanalTzInvAllowanceTEURSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCanalTzInvAllowanceTEU
	  * </pre>
	  */
	public AgentCanalTransitFeeBCDBDAOsearchCanalTzInvAllowanceTEURSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.integration").append("\n"); 
		query.append("FileName : AgentCanalTransitFeeBCDBDAOsearchCanalTzInvAllowanceTEURSQL").append("\n"); 
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
		query.append("SELECT 	A.VSL_CD," ).append("\n"); 
		query.append("A.SKD_VOY_NO," ).append("\n"); 
		query.append("A.SKD_DIR_CD," ).append("\n"); 
		query.append("A.REV_YRMON,  --ADV Payment Rev. Month" ).append("\n"); 
		query.append("trim(to_char(" ).append("\n"); 
		query.append("(SELECT SUM(RQST_AMT) FROM PSO_CNL_TZ_FEE_DTL" ).append("\n"); 
		query.append("WHERE PSO_BZTP_CD = A.PSO_BZTP_CD" ).append("\n"); 
		query.append("AND VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("AND SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("AND YD_CD = A.YD_CD" ).append("\n"); 
		query.append("AND CALL_SEQ = A.CALL_SEQ" ).append("\n"); 
		query.append("),999999999999999.99))" ).append("\n"); 
		query.append("TTL_AMT,  --Invoice TTL Amount" ).append("\n"); 
		query.append("A.SCG_RT_AMT,  --Lmt Scg Amount" ).append("\n"); 
		query.append("A.SUZ_NET_TONG_WGT,  --SCNT" ).append("\n"); 
		query.append("A.LOCL_XCH_RT,  --SDR" ).append("\n"); 
		query.append("A.TR_VOL_VAL,  --Tier" ).append("\n"); 
		query.append("A.CNL_TZ_PROC_STS_CD," ).append("\n"); 
		query.append("B.CNTR_PNM_CAPA" ).append("\n"); 
		query.append("FROM 	(" ).append("\n"); 
		query.append("SELECT  *" ).append("\n"); 
		query.append("FROM    PSO_CNL_TZ_FEE A" ).append("\n"); 
		query.append("WHERE 	1=1" ).append("\n"); 
		query.append("AND     A.PSO_BZTP_CD = 5" ).append("\n"); 
		query.append("AND 	A.VSL_CD = regexp_substr(@[vvd], '[[:alpha:]]+', 1, 1)  --'HJMT'" ).append("\n"); 
		query.append("AND 	A.SKD_VOY_NO = regexp_substr(@[vvd], '[(0-9)]+', 1, 1)  --'0142'" ).append("\n"); 
		query.append("AND 	A.SKD_DIR_CD = regexp_substr(@[vvd], '[[:alpha:]]+', 1, 2)  --'E'" ).append("\n"); 
		query.append("AND     A.YD_CD = @[yd_cd]  --'EGSUZT1'" ).append("\n"); 
		query.append("AND     A.CALL_SEQ = @[call_seq]  --1" ).append("\n"); 
		query.append("AND 	A.VNDR_SEQ = @[vndr_seq]  --100870" ).append("\n"); 
		query.append("AND 	A.CNL_TZ_BZTP_CD = 'I'" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT VSL_CD," ).append("\n"); 
		query.append("CNTR_PNM_CAPA  --Allowance TEU" ).append("\n"); 
		query.append("FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("WHERE VSL_CD = regexp_substr(@[vvd], '[[:alpha:]]+', 1, 1)  --'HJMT'" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND     A.VSL_CD(+) = B.VSL_CD" ).append("\n"); 

	}
}