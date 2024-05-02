/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TCharterStandardPrimeCostDAOFmsStndHirBseCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.08
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterStandardPrimeCostDAOFmsStndHirBseCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Hire Creation Insert
	  * </pre>
	  */
	public TCharterStandardPrimeCostDAOFmsStndHirBseCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hb_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.integration").append("\n"); 
		query.append("FileName : TCharterStandardPrimeCostDAOFmsStndHirBseCSQL").append("\n"); 
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
		query.append("INSERT INTO FMS_STND_HIR_BSE (" ).append("\n"); 
		query.append("	   FLET_CTRT_NO, " ).append("\n"); 
		query.append("	   HB_YRMON, " ).append("\n"); 
		query.append("	   VSL_CD, " ).append("\n"); 
		query.append("	   VSL_DZND_CAPA, " ).append("\n"); 
		query.append("	   BSE_14TON_VSL_CAPA, " ).append("\n"); 
		query.append("	   HIR_RT_N1ST_AMT, " ).append("\n"); 
		query.append("	   HIR_RT_N2ND_AMT, " ).append("\n"); 
		query.append("	   VSL_DZND_TTL_QTY, " ).append("\n"); 
		query.append("	   BSE_14TON_VSL_TTL_QTY, " ).append("\n"); 
		query.append("	   HIR_RT_TTL_AMT, " ).append("\n"); 
		query.append("	   CRE_USR_ID, " ).append("\n"); 
		query.append("	   UPD_USR_ID)" ).append("\n"); 
		query.append("SELECT AAAAA.FLET_CTRT_NO," ).append("\n"); 
		query.append("	   @[hb_yrmon] HB_YRMON," ).append("\n"); 
		query.append("	   DECODE(EEEEE.VSL_CD,NULL,AAAAA.VSL_CD,EEEEE.VSL_CD) VSL_CD," ).append("\n"); 
		query.append("	   NVL(AAAAA.VSL_DZND_CAPA,0) VSL_DZND_CAPA," ).append("\n"); 
		query.append("	   NVL(AAAAA.BSE_14TON_VSL_CAPA,0) BSE_14TON_VSL_CAPA," ).append("\n"); 
		query.append("	   NVL(BBBBB.HIR_RT_N1ST_AMT,0) HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("	   ROUND(NVL(BBBBB.HIR_RT_N2ND_AMT,0) / NVL(CCCCC.USD_LOCL_XCH_RT,0), 2) HIR_RT_N2ND_AMT," ).append("\n"); 
		query.append("	   NVL(DDDDD.VSL_DZDN_TTL_QTY,0) VSL_DZDN_TTL_QTY," ).append("\n"); 
		query.append("	   NVL(DDDDD.BSE_14TON_VSL_TTL_QTY,0) BSE_14TON_VSL_TTL_QTY," ).append("\n"); 
		query.append("	   NVL(DDDDD.HIR_RT_TTL_AMT,0) HIR_RT_TTL_AMT," ).append("\n"); 
		query.append("	   @[cre_usr_id]," ).append("\n"); 
		query.append("	   @[upd_usr_id]" ).append("\n"); 
		query.append("  FROM FMS_CONTRACT AAAAA," ).append("\n"); 
		query.append("       (SELECT AAA.FLET_CTRT_NO," ).append("\n"); 
		query.append("               AAA.EFF_DT," ).append("\n"); 
		query.append("        	   AAA.EXP_DT," ).append("\n"); 
		query.append("        	   AAA.HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("        	   AAA.HIR_CURR_N1ST_CD," ).append("\n"); 
		query.append("        	   AAA.HIR_RT_N2ND_AMT," ).append("\n"); 
		query.append("        	   AAA.HIR_CURR_N2ND_CD" ).append("\n"); 
		query.append("          FROM (SELECT AA.FLET_CTRT_NO," ).append("\n"); 
		query.append("                       AA.EFF_DT," ).append("\n"); 
		query.append("        	           AA.EXP_DT," ).append("\n"); 
		query.append("        	           AA.HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("        	           AA.HIR_CURR_N1ST_CD," ).append("\n"); 
		query.append("        	           AA.HIR_RT_N2ND_AMT," ).append("\n"); 
		query.append("        	           AA.HIR_CURR_N2ND_CD," ).append("\n"); 
		query.append("        	           RANK() OVER (PARTITION BY BB.VSL_CD ORDER BY BB.VSL_CD, AA.EFF_DT) RNK" ).append("\n"); 
		query.append("                  FROM FMS_HIRE AA, FMS_CONTRACT BB" ).append("\n"); 
		query.append("                 WHERE AA.FLET_CTRT_NO = BB.FLET_CTRT_NO" ).append("\n"); 
		query.append("				   AND NVL(BB.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("                   AND @[hb_yrmon] BETWEEN TO_CHAR(AA.EFF_DT,'yyyymm') AND TO_CHAR(AA.EXP_DT,'yyyymm')" ).append("\n"); 
		query.append("                   AND ((BB.FLET_CTRT_TP_CD = 'TI' AND BB.FLET_CTRT_FACT_CD = 'ACT') OR BB.FLET_CTRT_TP_CD = 'OW')" ).append("\n"); 
		query.append("                   AND 'N' = NVL((SELECT 'Y'" ).append("\n"); 
		query.append("                                    FROM FMS_HIRE A, FMS_CONTRACT B" ).append("\n"); 
		query.append("                                   WHERE A.FLET_CTRT_NO = B.FLET_CTRT_NO" ).append("\n"); 
		query.append("                                     AND @[hb_yrmon] || '01' BETWEEN TO_CHAR(A.EFF_DT,'yyyymmdd') AND TO_CHAR(A.EXP_DT,'yyyymmdd')" ).append("\n"); 
		query.append("        							 AND A.FLET_CTRT_NO = AA.FLET_CTRT_NO" ).append("\n"); 
		query.append("                                     AND ROWNUM = 1), 'N')) AAA" ).append("\n"); 
		query.append("         WHERE AAA.RNK = 1" ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        SELECT AAA.FLET_CTRT_NO," ).append("\n"); 
		query.append("               AAA.EFF_DT," ).append("\n"); 
		query.append("        	   AAA.EXP_DT," ).append("\n"); 
		query.append("        	   AAA.HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("        	   AAA.HIR_CURR_N1ST_CD," ).append("\n"); 
		query.append("        	   AAA.HIR_RT_N2ND_AMT," ).append("\n"); 
		query.append("        	   AAA.HIR_CURR_N2ND_CD" ).append("\n"); 
		query.append("          FROM (SELECT AA.FLET_CTRT_NO," ).append("\n"); 
		query.append("                       AA.EFF_DT," ).append("\n"); 
		query.append("        	           AA.EXP_DT," ).append("\n"); 
		query.append("        	           AA.HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("        	           AA.HIR_CURR_N1ST_CD," ).append("\n"); 
		query.append("        	           AA.HIR_RT_N2ND_AMT," ).append("\n"); 
		query.append("        	           AA.HIR_CURR_N2ND_CD," ).append("\n"); 
		query.append("        	           RANK() OVER (PARTITION BY BB.VSL_CD ORDER BY BB.VSL_CD, AA.EFF_DT) RNK" ).append("\n"); 
		query.append("                  FROM FMS_HIRE AA, FMS_CONTRACT BB" ).append("\n"); 
		query.append("                 WHERE AA.FLET_CTRT_NO = BB.FLET_CTRT_NO" ).append("\n"); 
		query.append("				   AND NVL(BB.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("                   AND @[hb_yrmon] || '01' BETWEEN TO_CHAR(AA.EFF_DT,'yyyymmdd') AND TO_CHAR(AA.EXP_DT,'yyyymmdd')" ).append("\n"); 
		query.append("                   AND ((BB.FLET_CTRT_TP_CD = 'TI' AND BB.FLET_CTRT_FACT_CD = 'ACT') OR BB.FLET_CTRT_TP_CD = 'OW')" ).append("\n"); 
		query.append("                   AND 'N' = NVL((SELECT 'Y'" ).append("\n"); 
		query.append("                                    FROM FMS_HIRE A, FMS_CONTRACT B" ).append("\n"); 
		query.append("                                   WHERE A.FLET_CTRT_NO = B.FLET_CTRT_NO" ).append("\n"); 
		query.append("                                     AND @[hb_yrmon] BETWEEN TO_CHAR(A.EFF_DT,'yyyymm') AND TO_CHAR(A.EXP_DT,'yyyymm')" ).append("\n"); 
		query.append("        							 AND B.FLET_CTRT_TP_CD IN ('T1','OW')" ).append("\n"); 
		query.append("        							 AND A.FLET_CTRT_NO = AA.FLET_CTRT_NO" ).append("\n"); 
		query.append("        							 AND B.VSL_CD = BB.VSL_CD" ).append("\n"); 
		query.append("        						   GROUP BY B.VSL_CD" ).append("\n"); 
		query.append("        						   HAVING COUNT(DISTINCT B.FLET_CTRT_TP_CD) > 1), 'N')) AAA" ).append("\n"); 
		query.append("         WHERE AAA.RNK = 1) BBBBB," ).append("\n"); 
		query.append("       GL_MON_XCH_RT CCCCC," ).append("\n"); 
		query.append("       (SELECT SUM(AAAA.VSL_DZND_CAPA) VSL_DZDN_TTL_QTY," ).append("\n"); 
		query.append("               SUM(AAAA.BSE_14TON_VSL_CAPA) BSE_14TON_VSL_TTL_QTY," ).append("\n"); 
		query.append("               SUM(BBBB.HIR_RT_N1ST_AMT + ROUND(NVL(BBBB.HIR_RT_N2ND_AMT,0) / CCCC.USD_LOCL_XCH_RT, 2)) HIR_RT_TTL_AMT," ).append("\n"); 
		query.append("               DDDD.RNG_FM_QTY," ).append("\n"); 
		query.append("               DDDD.RNG_TO_QTY   " ).append("\n"); 
		query.append("          FROM FMS_CONTRACT AAAA," ).append("\n"); 
		query.append("               (SELECT AAA.FLET_CTRT_NO," ).append("\n"); 
		query.append("                       AAA.EFF_DT," ).append("\n"); 
		query.append("                	   AAA.EXP_DT," ).append("\n"); 
		query.append("                	   AAA.HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("                	   AAA.HIR_CURR_N1ST_CD," ).append("\n"); 
		query.append("                	   AAA.HIR_RT_N2ND_AMT," ).append("\n"); 
		query.append("                	   AAA.HIR_CURR_N2ND_CD" ).append("\n"); 
		query.append("                  FROM (SELECT AA.FLET_CTRT_NO," ).append("\n"); 
		query.append("                               AA.EFF_DT," ).append("\n"); 
		query.append("                	           AA.EXP_DT," ).append("\n"); 
		query.append("                	           AA.HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("                	           AA.HIR_CURR_N1ST_CD," ).append("\n"); 
		query.append("                	           AA.HIR_RT_N2ND_AMT," ).append("\n"); 
		query.append("                	           AA.HIR_CURR_N2ND_CD," ).append("\n"); 
		query.append("                	           RANK() OVER (PARTITION BY BB.VSL_CD ORDER BY BB.VSL_CD, AA.EFF_DT) RNK" ).append("\n"); 
		query.append("                          FROM FMS_HIRE AA, FMS_CONTRACT BB" ).append("\n"); 
		query.append("                         WHERE AA.FLET_CTRT_NO = BB.FLET_CTRT_NO" ).append("\n"); 
		query.append("						   AND NVL(BB.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("                           AND @[hb_yrmon] BETWEEN TO_CHAR(AA.EFF_DT,'yyyymm') AND TO_CHAR(AA.EXP_DT,'yyyymm')" ).append("\n"); 
		query.append("                           AND ((BB.FLET_CTRT_TP_CD = 'TI' AND BB.FLET_CTRT_FACT_CD = 'ACT') OR BB.FLET_CTRT_TP_CD = 'OW')" ).append("\n"); 
		query.append("                           AND 'N' = NVL((SELECT 'Y'" ).append("\n"); 
		query.append("                                            FROM FMS_HIRE A, FMS_CONTRACT B" ).append("\n"); 
		query.append("                                           WHERE A.FLET_CTRT_NO = B.FLET_CTRT_NO" ).append("\n"); 
		query.append("                                             AND @[hb_yrmon] || '01' BETWEEN TO_CHAR(A.EFF_DT,'yyyymmdd') AND TO_CHAR(A.EXP_DT,'yyyymmdd')" ).append("\n"); 
		query.append("                							 AND A.FLET_CTRT_NO = AA.FLET_CTRT_NO" ).append("\n"); 
		query.append("                                             AND ROWNUM = 1), 'N')) AAA" ).append("\n"); 
		query.append("                 WHERE AAA.RNK = 1" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT AAA.FLET_CTRT_NO," ).append("\n"); 
		query.append("                       AAA.EFF_DT," ).append("\n"); 
		query.append("                	   AAA.EXP_DT," ).append("\n"); 
		query.append("                	   AAA.HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("                	   AAA.HIR_CURR_N1ST_CD," ).append("\n"); 
		query.append("                	   AAA.HIR_RT_N2ND_AMT," ).append("\n"); 
		query.append("                	   AAA.HIR_CURR_N2ND_CD" ).append("\n"); 
		query.append("                  FROM (SELECT AA.FLET_CTRT_NO," ).append("\n"); 
		query.append("                               AA.EFF_DT," ).append("\n"); 
		query.append("                	           AA.EXP_DT," ).append("\n"); 
		query.append("                	           AA.HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("                	           AA.HIR_CURR_N1ST_CD," ).append("\n"); 
		query.append("                	           AA.HIR_RT_N2ND_AMT," ).append("\n"); 
		query.append("                	           AA.HIR_CURR_N2ND_CD," ).append("\n"); 
		query.append("                	           RANK() OVER (PARTITION BY BB.VSL_CD ORDER BY BB.VSL_CD, AA.EFF_DT) RNK" ).append("\n"); 
		query.append("                          FROM FMS_HIRE AA, FMS_CONTRACT BB" ).append("\n"); 
		query.append("                         WHERE AA.FLET_CTRT_NO = BB.FLET_CTRT_NO" ).append("\n"); 
		query.append("						   AND NVL(BB.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("                           AND @[hb_yrmon] || '01' BETWEEN TO_CHAR(AA.EFF_DT,'yyyymmdd') AND TO_CHAR(AA.EXP_DT,'yyyymmdd')" ).append("\n"); 
		query.append("                           AND ((BB.FLET_CTRT_TP_CD = 'TI' AND BB.FLET_CTRT_FACT_CD = 'ACT') OR BB.FLET_CTRT_TP_CD = 'OW')" ).append("\n"); 
		query.append("                           AND 'N' = NVL((SELECT 'Y'" ).append("\n"); 
		query.append("                                            FROM FMS_HIRE A, FMS_CONTRACT B" ).append("\n"); 
		query.append("                                           WHERE A.FLET_CTRT_NO = B.FLET_CTRT_NO" ).append("\n"); 
		query.append("                                             AND @[hb_yrmon] BETWEEN TO_CHAR(A.EFF_DT,'yyyymm') AND TO_CHAR(A.EXP_DT,'yyyymm')" ).append("\n"); 
		query.append("                							 AND B.FLET_CTRT_TP_CD IN ('T1','OW')" ).append("\n"); 
		query.append("                							 AND A.FLET_CTRT_NO = AA.FLET_CTRT_NO" ).append("\n"); 
		query.append("                							 AND B.VSL_CD = BB.VSL_CD" ).append("\n"); 
		query.append("                						   GROUP BY B.VSL_CD" ).append("\n"); 
		query.append("                						   HAVING COUNT(DISTINCT B.FLET_CTRT_TP_CD) > 1), 'N')) AAA" ).append("\n"); 
		query.append("                 WHERE AAA.RNK = 1) BBBB," ).append("\n"); 
		query.append("        	   GL_MON_XCH_RT CCCC," ).append("\n"); 
		query.append("        	   FMS_TEU_RNG DDDD" ).append("\n"); 
		query.append("         WHERE AAAA.FLET_CTRT_NO = BBBB.FLET_CTRT_NO" ).append("\n"); 
		query.append("           AND AAAA.FLET_CTRT_TP_CD IN ('TI','OW')" ).append("\n"); 
		query.append("           AND @[hb_yrmon] BETWEEN TO_CHAR(BBBB.EFF_DT,'yyyymm') AND TO_CHAR(BBBB.EXP_DT,'yyyymm')" ).append("\n"); 
		query.append("           AND CCCC.ACCT_XCH_RT_YRMON = @[hb_yrmon]" ).append("\n"); 
		query.append("           AND SUBSTR(CCCC.ACCT_XCH_RT_YRMON,5,2) <> '13'" ).append("\n"); 
		query.append("           AND CCCC.CURR_CD = NVL(BBBB.HIR_CURR_N2ND_CD,'USD')" ).append("\n"); 
		query.append("           AND CCCC.ACCT_XCH_RT_LVL = '3'" ).append("\n"); 
		query.append("           AND AAAA.VSL_DZND_CAPA BETWEEN DDDD.RNG_FM_QTY AND DDDD.RNG_TO_QTY" ).append("\n"); 
		query.append("           AND DDDD.RNG_YR = SUBSTR(@[hb_yrmon],1,4)" ).append("\n"); 
		query.append("           AND NVL(DDDD.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("         GROUP BY DDDD.RNG_FM_QTY, DDDD.RNG_TO_QTY) DDDDD," ).append("\n"); 
		query.append("	   FMS_ID_VSL EEEEE" ).append("\n"); 
		query.append(" WHERE AAAAA.FLET_CTRT_NO = BBBBB.FLET_CTRT_NO" ).append("\n"); 
		query.append("   AND NVL(AAAAA.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("   AND AAAAA.FLET_CTRT_TP_CD IN ('TI','OW')" ).append("\n"); 
		query.append("   AND @[hb_yrmon] BETWEEN TO_CHAR(BBBBB.EFF_DT,'yyyymm') AND TO_CHAR(BBBBB.EXP_DT,'yyyymm')" ).append("\n"); 
		query.append("   AND CCCCC.ACCT_XCH_RT_YRMON = @[hb_yrmon]" ).append("\n"); 
		query.append("   AND SUBSTR(CCCCC.ACCT_XCH_RT_YRMON,5,2) <> '13'" ).append("\n"); 
		query.append("   AND CCCCC.CURR_CD = NVL(BBBBB.HIR_CURR_N2ND_CD,'USD')" ).append("\n"); 
		query.append("   AND CCCCC.ACCT_XCH_RT_LVL = '3'" ).append("\n"); 
		query.append("   AND AAAAA.VSL_DZND_CAPA BETWEEN DDDDD.RNG_FM_QTY AND DDDDD.RNG_TO_QTY" ).append("\n"); 
		query.append("   AND AAAAA.FLET_CTRT_NO = EEEEE.FLET_CTRT_NO(+)" ).append("\n"); 
		query.append("   AND EEEEE.USE_FLG(+) = 'Y'" ).append("\n"); 

	}
}