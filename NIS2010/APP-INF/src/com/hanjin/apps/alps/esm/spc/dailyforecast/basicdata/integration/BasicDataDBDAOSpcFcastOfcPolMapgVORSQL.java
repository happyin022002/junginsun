/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BasicDataDBDAOSpcFcastOfcPolMapgVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.03
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2010.02.03 최윤성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast.basicdata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BasicDataDBDAOSpcFcastOfcPolMapgVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public BasicDataDBDAOSpcFcastOfcPolMapgVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subtrade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ocnipc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("week",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.dailyforecast.basicdata.integration").append("\n"); 
		query.append("FileName : BasicDataDBDAOSpcFcastOfcPolMapgVORSQL").append("\n"); 
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
		query.append("  SELECT REP_TRD_CD    ," ).append("\n"); 
		query.append("         REP_SUB_TRD_CD," ).append("\n"); 
		query.append("         RLANE_CD      ," ).append("\n"); 
		query.append("         DIR_CD        ," ).append("\n"); 
		query.append("         DECODE(IOC_TS_CD, 'O', 'OCN', 'I', 'IPC', 'T', 'T/S') AS IOC_TS_CD," ).append("\n"); 
		query.append("         SUBSTR(BSE_YRWK, 1, 4) AS BSE_YR," ).append("\n"); 
		query.append("         SUBSTR(BSE_YRWK, 5, 2) AS BSE_WK," ).append("\n"); 
		query.append("         SLS_AQ_CD ," ).append("\n"); 
		query.append("         SLS_OFC_CD," ).append("\n"); 
		query.append("         MAX(DECODE(SEQ,  1, POL_YD_CD)) AS POL_CD1 ," ).append("\n"); 
		query.append("         MAX(DECODE(SEQ,  2, POL_YD_CD)) AS POL_CD2 ," ).append("\n"); 
		query.append("         MAX(DECODE(SEQ,  3, POL_YD_CD)) AS POL_CD3 ," ).append("\n"); 
		query.append("         MAX(DECODE(SEQ,  4, POL_YD_CD)) AS POL_CD4 ," ).append("\n"); 
		query.append("         MAX(DECODE(SEQ,  5, POL_YD_CD)) AS POL_CD5 ," ).append("\n"); 
		query.append("         MAX(DECODE(SEQ,  6, POL_YD_CD)) AS POL_CD6 ," ).append("\n"); 
		query.append("         MAX(DECODE(SEQ,  7, POL_YD_CD)) AS POL_CD7 ," ).append("\n"); 
		query.append("         MAX(DECODE(SEQ,  8, POL_YD_CD)) AS POL_CD8 ," ).append("\n"); 
		query.append("         MAX(DECODE(SEQ,  9, POL_YD_CD)) AS POL_CD9 ," ).append("\n"); 
		query.append("         MAX(DECODE(SEQ, 10, POL_YD_CD)) AS POL_CD10" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("            SELECT REP_TRD_CD    ," ).append("\n"); 
		query.append("                   REP_SUB_TRD_CD," ).append("\n"); 
		query.append("                   RLANE_CD      ," ).append("\n"); 
		query.append("                   DIR_CD        ," ).append("\n"); 
		query.append("                   IOC_TS_CD     ," ).append("\n"); 
		query.append("                   BSE_YRWK      ," ).append("\n"); 
		query.append("                   SLS_OFC_CD    ," ).append("\n"); 
		query.append("                   SLS_AQ_CD     ," ).append("\n"); 
		query.append("                   POL_CD AS POL_YD_CD," ).append("\n"); 
		query.append("                   ROW_NUMBER() OVER ( PARTITION BY REP_TRD_CD, REP_SUB_TRD_CD, RLANE_CD, DIR_CD, IOC_TS_CD, BSE_YRWK, SLS_OFC_CD " ).append("\n"); 
		query.append("                                           ORDER BY REP_TRD_CD, REP_SUB_TRD_CD, RLANE_CD, DIR_CD, IOC_TS_CD, BSE_YRWK, SLS_OFC_CD, CD_DP_SEQ, SLS_AQ_CD) AS SEQ" ).append("\n"); 
		query.append("              FROM SPC_FCAST_OFC_POL_MAPG M" ).append("\n"); 
		query.append("             WHERE BSE_YRWK IN ( SELECT /*+ INDEX_DESC(SF XPKSPC_FCAST_OFC_POL_MAPG) */" ).append("\n"); 
		query.append("                                        SF.BSE_YRWK" ).append("\n"); 
		query.append("                                   FROM SPC_FCAST_OFC_POL_MAPG SF" ).append("\n"); 
		query.append("                                  WHERE SF.REP_TRD_CD     = M.REP_TRD_CD" ).append("\n"); 
		query.append("                                    AND SF.REP_SUB_TRD_CD = M.REP_SUB_TRD_CD" ).append("\n"); 
		query.append("                                    AND SF.RLANE_CD       = M.RLANE_CD" ).append("\n"); 
		query.append("                                    AND SF.DIR_CD         = M.DIR_CD" ).append("\n"); 
		query.append("                                    AND SF.IOC_TS_CD      = M.IOC_TS_CD" ).append("\n"); 
		query.append("                                    AND SF.SLS_OFC_CD     = M.SLS_OFC_CD" ).append("\n"); 
		query.append("                                    AND SF.BSE_YRWK      <= @[year]||@[week]" ).append("\n"); 
		query.append("                                    AND ROWNUM = 1" ).append("\n"); 
		query.append("                                 UNION ALL" ).append("\n"); 
		query.append("                                 SELECT SF.BSE_YRWK BSE_YRWK" ).append("\n"); 
		query.append("                                   FROM SPC_FCAST_OFC_POL_MAPG SF" ).append("\n"); 
		query.append("                                  WHERE SF.REP_TRD_CD     = M.REP_TRD_CD" ).append("\n"); 
		query.append("                                    AND SF.REP_SUB_TRD_CD = M.REP_SUB_TRD_CD" ).append("\n"); 
		query.append("                                    AND SF.RLANE_CD       = M.RLANE_CD" ).append("\n"); 
		query.append("                                    AND SF.DIR_CD         = M.DIR_CD" ).append("\n"); 
		query.append("                                    AND SF.IOC_TS_CD      = M.IOC_TS_CD" ).append("\n"); 
		query.append("                                    AND SF.SLS_OFC_CD     = M.SLS_OFC_CD" ).append("\n"); 
		query.append("                                    AND SF.BSE_YRWK       > @[year]||@[week]  )" ).append("\n"); 
		query.append("               AND SLS_RHQ_CD = @[rhq]" ).append("\n"); 
		query.append("               AND REP_TRD_CD = @[trade]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${subtrade} != '') " ).append("\n"); 
		query.append("               AND REP_SUB_TRD_CD  = @[subtrade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${lane} != '') " ).append("\n"); 
		query.append("               AND RLANE_CD = @[lane]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bound} != '') " ).append("\n"); 
		query.append("               AND DIR_CD = @[bound]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ocnipc} != '')" ).append("\n"); 
		query.append("               AND IOC_TS_CD = SUBSTR(@[ocnipc], 1, 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("GROUP BY REP_TRD_CD    ," ).append("\n"); 
		query.append("         REP_SUB_TRD_CD," ).append("\n"); 
		query.append("         RLANE_CD      ," ).append("\n"); 
		query.append("         DIR_CD        ," ).append("\n"); 
		query.append("         IOC_TS_CD     ," ).append("\n"); 
		query.append("         BSE_YRWK      ," ).append("\n"); 
		query.append("         SLS_OFC_CD    ," ).append("\n"); 
		query.append("         SLS_AQ_CD" ).append("\n"); 
		query.append("ORDER BY REP_TRD_CD    ," ).append("\n"); 
		query.append("         REP_SUB_TRD_CD," ).append("\n"); 
		query.append("         RLANE_CD      ," ).append("\n"); 
		query.append("         DIR_CD        ," ).append("\n"); 
		query.append("         IOC_TS_CD     ," ).append("\n"); 
		query.append("         BSE_YRWK      ," ).append("\n"); 
		query.append("         SLS_AQ_CD     ," ).append("\n"); 
		query.append("         SLS_OFC_CD" ).append("\n"); 

	}
}