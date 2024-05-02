/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MonthlyTargetVVDDBDAOSearchMonthlyTargetVVD0040Tab01RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.06
*@LastModifier : 주선영
*@LastVersion : 1.0
* 2010.05.06 주선영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.basicdatamanage.monthlytargetvvd.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ju Sun Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyTargetVVDDBDAOSearchMonthlyTargetVVD0040Tab01RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public MonthlyTargetVVDDBDAOSearchMonthlyTargetVVD0040Tab01RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("quarter",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.basicdatamanage.monthlytargetvvd.integration").append("\n"); 
		query.append("FileName : MonthlyTargetVVDDBDAOSearchMonthlyTargetVVD0040Tab01RSQL").append("\n"); 
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
		query.append("WITH BASE AS (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("        COUNT(1) CNT" ).append("\n"); 
		query.append("    FROM SAQ_MON_TGT_VVD M" ).append("\n"); 
		query.append("    WHERE" ).append("\n"); 
		query.append("            M.BSE_YR = @[year]" ).append("\n"); 
		query.append("        AND M.BSE_QTR_CD = @[quarter]" ).append("\n"); 
		query.append("#if (${trade} != '') " ).append("\n"); 
		query.append("        AND M.TRD_CD = @[trade] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bound} != '') " ).append("\n"); 
		query.append("	   AND M.DIR_CD = @[bound] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    DECODE(M.BSE_YR||M.BSE_QTR_CD, @[year]||@[quarter], 'R', 'I') IBFLAG," ).append("\n"); 
		query.append("    @[year] BSE_YR, @[quarter] BSE_QTR_CD, " ).append("\n"); 
		query.append("    M.TRD_CD, M.RLANE_CD, M.DIR_CD, " ).append("\n"); 
		query.append("    M.VSL_CD, M.SKD_VOY_NO, M.SKD_DIR_CD, " ).append("\n"); 
		query.append("    M.SPRT_GRP_CD, M.BSA_GRP_CD, " ).append("\n"); 
		query.append("    M.BSE_MON, M.BSE_WK, " ).append("\n"); 
		query.append("    M.SUB_TRD_CD, M.IOC_CD, M.VVD_SEQ, " ).append("\n"); 
		query.append("    M.FNL_BSA_CAPA," ).append("\n"); 
		query.append("    TO_CHAR(M.FNL_BSA_CAPA,'FM099999999990') AS STR_FNL_BSA_CAPA," ).append("\n"); 
		query.append("    TO_CHAR(M.LST_LODG_PORT_ETD_DT, 'YYYY/MM/DD HH24:MI:SS') LST_LODG_PORT_ETD_DT, " ).append("\n"); 
		query.append("    M.UPD_RMK, " ).append("\n"); 
		query.append("    M.LST_LODG_PORT_CD, " ).append("\n"); 
		query.append("    M.DELT_FLG, " ).append("\n"); 
		query.append("    M.TGT_VVD_STS_CD " ).append("\n"); 
		query.append("FROM SAQ_MON_TGT_VVD M" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("        M.BSE_YR = @[year]" ).append("\n"); 
		query.append("    AND (M.BSE_QTR_CD = @[quarter] OR ((SELECT CNT FROM BASE) = 0 AND M.BSE_QTR_CD = @[quarter] AND M.BSE_MON <> M.BSE_QTR_CD))" ).append("\n"); 
		query.append("#if (${trade} != '') " ).append("\n"); 
		query.append("        AND M.TRD_CD = @[trade] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bound} != '') " ).append("\n"); 
		query.append("	   AND M.DIR_CD = @[bound] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY M.TRD_CD,M.DIR_CD,M.SUB_TRD_CD, M.RLANE_CD, M.BSE_MON, M.BSE_WK, M.LST_LODG_PORT_ETD_DT" ).append("\n"); 

	}
}