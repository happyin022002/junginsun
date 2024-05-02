/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AgentCanalTransitFeeBCDBDAOsearchCanalTzFeeInvDtlByVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.18
*@LastModifier : 안준상
*@LastVersion : 1.0
* 2010.02.18 안준상
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

public class AgentCanalTransitFeeBCDBDAOsearchCanalTzFeeInvDtlByVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCanalTzFeeInvDtlByVvd
	  * </pre>
	  */
	public AgentCanalTransitFeeBCDBDAOsearchCanalTzFeeInvDtlByVvdRSQL(){
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
		query.append("FileName : AgentCanalTransitFeeBCDBDAOsearchCanalTzFeeInvDtlByVvdRSQL").append("\n"); 
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
		query.append("SELECT NULL VNDR_SEQ," ).append("\n"); 
		query.append("NULL PSO_BZTP_CD," ).append("\n"); 
		query.append("NULL VSL_CD," ).append("\n"); 
		query.append("NULL SKD_VOY_NO," ).append("\n"); 
		query.append("NULL SKD_DIR_CD," ).append("\n"); 
		query.append("NULL YD_CD," ).append("\n"); 
		query.append("NULL CALL_SEQ," ).append("\n"); 
		query.append("NULL LGS_COST_CD," ).append("\n"); 
		query.append("'RIMITTANCE FM HANJIN' LGS_COST_FULL_NM," ).append("\n"); 
		query.append("SUM (RQST_AMT) CREDITS_AMT," ).append("\n"); 
		query.append("NULL RQST_AMT," ).append("\n"); 
		query.append("NULL DIFF_RMK," ).append("\n"); 
		query.append("'1' SQ," ).append("\n"); 
		query.append("1 ASEQ," ).append("\n"); 
		query.append("1 DSEQ," ).append("\n"); 
		query.append("NULL \"LEVEL\"," ).append("\n"); 
		query.append("NULL LGS_COST_CD_CLSS_LVL" ).append("\n"); 
		query.append("FROM PSO_CNL_TZ_FEE T1," ).append("\n"); 
		query.append("PSO_CNL_TZ_FEE_DTL T2" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND T1.VSL_CD = T2.VSL_CD" ).append("\n"); 
		query.append("AND T1.SKD_VOY_NO = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("AND T1.SKD_DIR_CD = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("AND T1.YD_CD = T2.YD_CD" ).append("\n"); 
		query.append("AND T1.CALL_SEQ = T2.CALL_SEQ" ).append("\n"); 
		query.append("AND T1.PSO_BZTP_CD = '5'" ).append("\n"); 
		query.append("AND T1.VSL_CD = regexp_substr(@[vvd], '[[:alpha:]]+', 1, 1)  --'HJAA'" ).append("\n"); 
		query.append("AND T1.SKD_VOY_NO = regexp_substr(@[vvd], '[(0-9)]+', 1, 1)  --'0002'" ).append("\n"); 
		query.append("AND T1.SKD_DIR_CD = regexp_substr(@[vvd], '[[:alpha:]]+', 1, 2)  --'E'" ).append("\n"); 
		query.append("AND T1.YD_CD = @[yd_cd]  --'EGSUZT1'" ).append("\n"); 
		query.append("AND T1.VNDR_SEQ = @[vndr_seq]  --100870" ).append("\n"); 
		query.append("AND T1.CNL_TZ_BZTP_CD = 'E'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT XX.*" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT 	nvl(B.VNDR_SEQ,@[vndr_seq]) VNDR_SEQ,  --100870" ).append("\n"); 
		query.append("nvl(B.PSO_BZTP_CD,5) PSO_BZTP_CD," ).append("\n"); 
		query.append("nvl(B.VSL_CD,regexp_substr(@[vvd], '[[:alpha:]]+', 1, 1)) VSL_CD,  --'HJMT'" ).append("\n"); 
		query.append("nvl(B.SKD_VOY_NO,regexp_substr(@[vvd], '[(0-9)]+', 1, 1)) SKD_VOY_NO,  --'0142'" ).append("\n"); 
		query.append("nvl(B.SKD_DIR_CD,regexp_substr(@[vvd], '[[:alpha:]]+', 1, 2)) SKD_DIR_CD,  --'E'" ).append("\n"); 
		query.append("nvl(B.YD_CD,@[yd_cd]) YD_CD,  --'EGSUZT1'" ).append("\n"); 
		query.append("nvl(B.CALL_SEQ,@[call_seq]) CALL_SEQ,  --1 ISEQ" ).append("\n"); 
		query.append("A.LGS_COST_CD," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT LGS_COST_FULL_NM" ).append("\n"); 
		query.append("FROM TES_LGS_COST X" ).append("\n"); 
		query.append("WHERE X.LGS_COST_CD = A.LGS_COST_CD" ).append("\n"); 
		query.append(") LGS_COST_FULL_NM," ).append("\n"); 
		query.append("nvl(C.CREDITS_AMT,0) CREDITS_AMT," ).append("\n"); 
		query.append("nvl(B.RQST_AMT,0) RQST_AMT," ).append("\n"); 
		query.append("nvl(B.DIFF_RMK,'') DIFF_RMK," ).append("\n"); 
		query.append("LPAD(' ',(A.\"LEVEL\"-1)*3)||(A.DSEQ+1)||DECODE(A.ASEQ,1,'','-'||(A.ASEQ-1)) SQ," ).append("\n"); 
		query.append("A.ASEQ," ).append("\n"); 
		query.append("(A.DSEQ+1) DSEQ," ).append("\n"); 
		query.append("A.\"LEVEL\"," ).append("\n"); 
		query.append("A.LGS_COST_CD_CLSS_LVL" ).append("\n"); 
		query.append("FROM 	(" ).append("\n"); 
		query.append("SELECT X.*" ).append("\n"); 
		query.append(",(ROW_NUMBER() OVER (PARTITION BY DSEQ ORDER BY LGS_COST_CD)) ASEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DSEQ," ).append("\n"); 
		query.append("LGS_COST_CD," ).append("\n"); 
		query.append("LGS_COST_FULL_NM," ).append("\n"); 
		query.append("Z.\"LEVEL\"," ).append("\n"); 
		query.append("Z.LGS_COST_CD_CLSS_LVL" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("--seq" ).append("\n"); 
		query.append("SELECT ROWNUM DSEQ," ).append("\n"); 
		query.append("A.LGS_COST_CD," ).append("\n"); 
		query.append("A.LGS_COST_FULL_NM," ).append("\n"); 
		query.append("1 AS \"LEVEL\"," ).append("\n"); 
		query.append("'D' LGS_COST_CD_CLSS_LVL" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT LGS_COST_CD," ).append("\n"); 
		query.append("LGS_COST_FULL_NM" ).append("\n"); 
		query.append("FROM TES_LGS_COST" ).append("\n"); 
		query.append("WHERE LGS_COST_SUBJ_CD ='CN'" ).append("\n"); 
		query.append("AND LGS_COST_CD_CLSS_LVL = 'D'" ).append("\n"); 
		query.append("AND DECODE(SUBSTR(@[vvd],0,2),'HJ',LGS_COST_CD,'YYYY') <> 'CNOW'" ).append("\n"); 
		query.append("ORDER BY LGS_COST_FULL_NM" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("--seq" ).append("\n"); 
		query.append("SELECT AA.DSEQ," ).append("\n"); 
		query.append("BB.LGS_COST_CD," ).append("\n"); 
		query.append("BB.LGS_COST_FULL_NM," ).append("\n"); 
		query.append("2 AS \"LEVEL\"," ).append("\n"); 
		query.append("'A' LGS_COST_CD_CLSS_LVL" ).append("\n"); 
		query.append("FROM (SELECT A.*," ).append("\n"); 
		query.append("ROWNUM DSEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT LGS_COST_CD" ).append("\n"); 
		query.append("FROM TES_LGS_COST" ).append("\n"); 
		query.append("WHERE LGS_COST_SUBJ_CD ='CN'" ).append("\n"); 
		query.append("AND LGS_COST_CD_CLSS_LVL = 'D'" ).append("\n"); 
		query.append("AND DECODE(SUBSTR(@[vvd],0,2),'HJ',LGS_COST_CD,'YYYY') <> 'CNOW'" ).append("\n"); 
		query.append("ORDER BY LGS_COST_FULL_NM" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append(") AA," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT LGS_COST_CD," ).append("\n"); 
		query.append("LGS_COST_FULL_NM" ).append("\n"); 
		query.append("FROM TES_LGS_COST" ).append("\n"); 
		query.append("WHERE LGS_COST_SUBJ_CD ='CN'" ).append("\n"); 
		query.append("AND LGS_COST_CD_CLSS_LVL = 'A'" ).append("\n"); 
		query.append("ORDER BY LGS_COST_CD" ).append("\n"); 
		query.append(") BB" ).append("\n"); 
		query.append("WHERE AA.LGS_COST_CD = SUBSTR(BB.LGS_COST_CD,1,4)" ).append("\n"); 
		query.append("ORDER BY DSEQ" ).append("\n"); 
		query.append("--sub seq" ).append("\n"); 
		query.append(") Z" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append(") A," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT 	A.PSO_BZTP_CD," ).append("\n"); 
		query.append("A.VSL_CD," ).append("\n"); 
		query.append("A.SKD_VOY_NO," ).append("\n"); 
		query.append("A.SKD_DIR_CD," ).append("\n"); 
		query.append("A.YD_CD," ).append("\n"); 
		query.append("A.CALL_SEQ,  --ISEQ" ).append("\n"); 
		query.append("A.VNDR_SEQ," ).append("\n"); 
		query.append("B.LGS_COST_CD," ).append("\n"); 
		query.append("B.RQST_AMT," ).append("\n"); 
		query.append("B.DIFF_RMK" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("PSO_CNL_TZ_FEE A," ).append("\n"); 
		query.append("PSO_CNL_TZ_FEE_DTL B" ).append("\n"); 
		query.append("WHERE 	A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("AND 	A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("AND 	A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("AND 	A.YD_CD = B.YD_CD" ).append("\n"); 
		query.append("AND 	A.CALL_SEQ = B.CALL_SEQ" ).append("\n"); 
		query.append("AND     A.PSO_BZTP_CD = 5" ).append("\n"); 
		query.append("AND 	A.VSL_CD = regexp_substr(@[vvd], '[[:alpha:]]+', 1, 1)  --'HJAA'" ).append("\n"); 
		query.append("AND 	A.SKD_VOY_NO = regexp_substr(@[vvd], '[(0-9)]+', 1, 1)  --'0002'" ).append("\n"); 
		query.append("AND 	A.SKD_DIR_CD = regexp_substr(@[vvd], '[[:alpha:]]+', 1, 2)  --'E'" ).append("\n"); 
		query.append("AND     A.YD_CD = @[yd_cd]  --'EGSUZT1'" ).append("\n"); 
		query.append("AND     A.CALL_SEQ = @[call_seq]  --1" ).append("\n"); 
		query.append("AND 	A.VNDR_SEQ = @[vndr_seq]  --100870" ).append("\n"); 
		query.append("AND 	A.CNL_TZ_BZTP_CD = 'I'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 	A.PSO_BZTP_CD," ).append("\n"); 
		query.append("A.VSL_CD," ).append("\n"); 
		query.append("A.SKD_VOY_NO," ).append("\n"); 
		query.append("A.SKD_DIR_CD," ).append("\n"); 
		query.append("A.YD_CD," ).append("\n"); 
		query.append("A.CALL_SEQ,  --ISEQ" ).append("\n"); 
		query.append("A.VNDR_SEQ," ).append("\n"); 
		query.append("SUBSTR(B.LGS_COST_CD,1,4) LGS_COST_CD," ).append("\n"); 
		query.append("SUM(B.RQST_AMT) RQST_AMT," ).append("\n"); 
		query.append("'' DIFF_RMK" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("PSO_CNL_TZ_FEE A," ).append("\n"); 
		query.append("PSO_CNL_TZ_FEE_DTL B" ).append("\n"); 
		query.append("WHERE 	A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("AND 	A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("AND 	A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("AND 	A.YD_CD = B.YD_CD" ).append("\n"); 
		query.append("AND 	A.CALL_SEQ = B.CALL_SEQ" ).append("\n"); 
		query.append("AND     A.PSO_BZTP_CD = 5" ).append("\n"); 
		query.append("AND 	A.VSL_CD = regexp_substr(@[vvd], '[[:alpha:]]+', 1, 1)  --'HJAA'" ).append("\n"); 
		query.append("AND 	A.SKD_VOY_NO = regexp_substr(@[vvd], '[(0-9)]+', 1, 1)  --'0002'" ).append("\n"); 
		query.append("AND 	A.SKD_DIR_CD = regexp_substr(@[vvd], '[[:alpha:]]+', 1, 2)  --'E'" ).append("\n"); 
		query.append("AND     A.YD_CD = @[yd_cd]  --'EGSUZT1'" ).append("\n"); 
		query.append("AND     A.CALL_SEQ = @[call_seq]  --1" ).append("\n"); 
		query.append("AND 	A.VNDR_SEQ = @[vndr_seq]  --100870" ).append("\n"); 
		query.append("AND 	A.CNL_TZ_BZTP_CD = 'I'" ).append("\n"); 
		query.append("GROUP BY A.PSO_BZTP_CD, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.YD_CD, A.CALL_SEQ, A.VNDR_SEQ, SUBSTR(B.LGS_COST_CD,1,4)" ).append("\n"); 
		query.append(") B," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT 	A.CALL_SEQ AS ESEQ,  --ESEQ (only one)" ).append("\n"); 
		query.append("B.LGS_COST_CD," ).append("\n"); 
		query.append("RQST_AMT AS CREDITS_AMT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("PSO_CNL_TZ_FEE A," ).append("\n"); 
		query.append("PSO_CNL_TZ_FEE_DTL B" ).append("\n"); 
		query.append("WHERE 	A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("AND 	A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("AND 	A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("AND 	A.YD_CD = B.YD_CD" ).append("\n"); 
		query.append("AND 	A.CALL_SEQ = B.CALL_SEQ" ).append("\n"); 
		query.append("AND     A.PSO_BZTP_CD = 5" ).append("\n"); 
		query.append("AND 	A.VSL_CD = regexp_substr(@[vvd], '[[:alpha:]]+', 1, 1)  --'HJAA'" ).append("\n"); 
		query.append("AND 	A.SKD_VOY_NO = regexp_substr(@[vvd], '[(0-9)]+', 1, 1)  --'0002'" ).append("\n"); 
		query.append("AND 	A.SKD_DIR_CD = regexp_substr(@[vvd], '[[:alpha:]]+', 1, 2)  --'E'" ).append("\n"); 
		query.append("AND     A.YD_CD = @[yd_cd]  --'EGSUZT1'" ).append("\n"); 
		query.append("AND 	A.VNDR_SEQ = @[vndr_seq]  --100870" ).append("\n"); 
		query.append("AND 	A.CNL_TZ_BZTP_CD = 'E'" ).append("\n"); 
		query.append(") C" ).append("\n"); 
		query.append("WHERE 	A.LGS_COST_CD = B.LGS_COST_CD(+)" ).append("\n"); 
		query.append("AND     A.LGS_COST_CD = C.LGS_COST_CD(+)" ).append("\n"); 
		query.append("ORDER BY  DSEQ, ASEQ" ).append("\n"); 
		query.append(") XX" ).append("\n"); 

	}
}