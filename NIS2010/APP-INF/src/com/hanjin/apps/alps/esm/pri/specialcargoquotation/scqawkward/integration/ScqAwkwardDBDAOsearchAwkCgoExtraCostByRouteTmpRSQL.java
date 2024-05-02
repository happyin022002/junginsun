/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScqAwkwardDBDAOsearchAwkCgoExtraCostByRouteTmpRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.29
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.04.29 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dong-sun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScqAwkwardDBDAOsearchAwkCgoExtraCostByRouteTmpRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI_SCQ_AWK_ROUT_TMP
	  * PRI_SCQ_AWK_ROUT_SMRY_TMP
	  * PRI_SCQ_AWK_YD_SMRY_TMP
	  * </pre>
	  */
	public ScqAwkwardDBDAOsearchAwkCgoExtraCostByRouteTmpRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scq_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scq_ver_no_tmp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scq_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.integration").append("\n"); 
		query.append("FileName : ScqAwkwardDBDAOsearchAwkCgoExtraCostByRouteTmpRSQL").append("\n"); 
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
		query.append("SELECT SCQ_RQST_NO" ).append("\n"); 
		query.append("     , @[scq_ver_no] AS SCQ_VER_NO" ).append("\n"); 
		query.append("     , SCQ_VER_NO AS SCQ_VER_NO_TMP" ).append("\n"); 
		query.append("     , ROUT_SEQ" ).append("\n"); 
		query.append("     , ROUT_TP_CD" ).append("\n"); 
		query.append("     , ROUT_TP_SEQ" ).append("\n"); 
		query.append("     , LANE_CD" ).append("\n"); 
		query.append("     , IB_YD_CD" ).append("\n"); 
		query.append("     , OB_YD_CD" ).append("\n"); 
		query.append("     , SUM(DECODE(COST_TP_CD,'N',COST_AMT,'')) N_COST --NORMAL" ).append("\n"); 
		query.append("     , SUM(DECODE(COST_TP_CD,'W',COST_AMT,'')) W_COST --WIRE" ).append("\n"); 
		query.append("     , SUM(DECODE(COST_TP_CD,'G',COST_AMT,'')) G_COST --S GEAR" ).append("\n"); 
		query.append("     , DECODE(SUM(DECODE(COST_TP_CD,'A',COST_AMT,'')),'',SUM(DECODE(COST_TP_CD,'T',COST_AMT,'')),'') T_COST --T/S PORT LOADING UNLOADING" ).append("\n"); 
		query.append("     , SUM(DECODE(COST_TP_CD,'S',COST_AMT,'')) S_COST --SHUTTLE" ).append("\n"); 
		query.append("     , SUM(DECODE(COST_TP_CD,'A',COST_AMT,'')) A_COST --ADD ON" ).append("\n"); 
		query.append("     , SUM(CASE WHEN COST_TP_CD = 'N' AND COST_AMT = 0 THEN 1 ELSE 0 END ) N_COST_ZERO_EXIST" ).append("\n"); 
		query.append("     , SUM(CASE WHEN COST_TP_CD = 'W' AND COST_AMT = 0 THEN 1 ELSE 0 END ) W_COST_ZERO_EXIST" ).append("\n"); 
		query.append("     , SUM(CASE WHEN COST_TP_CD = 'G' AND COST_AMT = 0 THEN 1 ELSE 0 END ) G_COST_ZERO_EXIST" ).append("\n"); 
		query.append("     , SUM(CASE WHEN COST_TP_CD = 'T' AND COST_AMT = 0 THEN 1 ELSE 0 END ) T_COST_ZERO_EXIST" ).append("\n"); 
		query.append("     , SUM(CASE WHEN COST_TP_CD = 'S' AND COST_AMT = 0 THEN 1 ELSE 0 END ) S_COST_ZERO_EXIST" ).append("\n"); 
		query.append("     , SUM(CASE WHEN COST_TP_CD = 'A' AND COST_AMT = 0 THEN 1 ELSE 0 END ) A_COST_ZERO_EXIST" ).append("\n"); 
		query.append("  FROM (SELECT AWK.SCQ_RQST_NO                  " ).append("\n"); 
		query.append("             , AWK.SCQ_VER_NO                   " ).append("\n"); 
		query.append("             , AWK.ROUT_SEQ" ).append("\n"); 
		query.append("             , AWK.ROUT_TP_CD" ).append("\n"); 
		query.append("             , AWK.ROUT_TP_SEQ" ).append("\n"); 
		query.append("             , AWK.LANE_CD" ).append("\n"); 
		query.append("             , AWK.IB_YD_CD" ).append("\n"); 
		query.append("             , AWK.OB_YD_CD" ).append("\n"); 
		query.append("             , RT.ROUT_COST_SEQ COST_SEQ" ).append("\n"); 
		query.append("             , RT.COST_AMT " ).append("\n"); 
		query.append("             , RT.COST_TP_CD" ).append("\n"); 
		query.append("          FROM PRI_SCQ_AWK_ROUT_TMP AWK" ).append("\n"); 
		query.append("             , PRI_SCQ_AWK_ROUT_SMRY_TMP RT" ).append("\n"); 
		query.append("         WHERE AWK.SCQ_RQST_NO = @[scq_rqst_no]     " ).append("\n"); 
		query.append("           AND AWK.SCQ_VER_NO = @[scq_ver_no_tmp] " ).append("\n"); 
		query.append("           AND AWK.SCQ_RQST_NO = RT.SCQ_RQST_NO(+)" ).append("\n"); 
		query.append("           AND AWK.SCQ_VER_NO = RT.SCQ_VER_NO(+) " ).append("\n"); 
		query.append("           AND AWK.ROUT_SEQ = RT.ROUT_SEQ(+)" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        SELECT AWK.SCQ_RQST_NO                  " ).append("\n"); 
		query.append("             , AWK.SCQ_VER_NO                   " ).append("\n"); 
		query.append("             , AWK.ROUT_SEQ" ).append("\n"); 
		query.append("             , AWK.ROUT_TP_CD" ).append("\n"); 
		query.append("             , AWK.ROUT_TP_SEQ" ).append("\n"); 
		query.append("             , AWK.LANE_CD" ).append("\n"); 
		query.append("             , AWK.IB_YD_CD" ).append("\n"); 
		query.append("             , AWK.OB_YD_CD" ).append("\n"); 
		query.append("             , YD.YD_COST_SEQ COST_SEQ  " ).append("\n"); 
		query.append("             , YD.COST_AMT " ).append("\n"); 
		query.append("             , YD.COST_TP_CD" ).append("\n"); 
		query.append("          FROM PRI_SCQ_AWK_ROUT_TMP AWK" ).append("\n"); 
		query.append("             , PRI_SCQ_AWK_YD_SMRY_TMP YD" ).append("\n"); 
		query.append("         WHERE AWK.SCQ_RQST_NO = @[scq_rqst_no]     " ).append("\n"); 
		query.append("           AND AWK.SCQ_VER_NO = @[scq_ver_no_tmp] " ).append("\n"); 
		query.append("           AND AWK.SCQ_RQST_NO = YD.SCQ_RQST_NO(+)     " ).append("\n"); 
		query.append("           AND AWK.SCQ_VER_NO = YD.SCQ_VER_NO(+)     " ).append("\n"); 
		query.append("           AND AWK.ROUT_SEQ = YD.ROUT_SEQ(+)            " ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("GROUP BY SCQ_RQST_NO, SCQ_VER_NO, ROUT_SEQ, ROUT_TP_CD, ROUT_TP_SEQ, LANE_CD, IB_YD_CD,OB_YD_CD" ).append("\n"); 
		query.append("ORDER BY SCQ_RQST_NO, SCQ_VER_NO, ROUT_SEQ, ROUT_TP_CD, ROUT_TP_SEQ, LANE_CD, IB_YD_CD,OB_YD_CD" ).append("\n"); 

	}
}