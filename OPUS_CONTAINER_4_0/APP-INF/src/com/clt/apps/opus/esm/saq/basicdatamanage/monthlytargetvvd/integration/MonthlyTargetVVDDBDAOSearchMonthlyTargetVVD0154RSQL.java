/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MonthlyTargetVVDDBDAOSearchMonthlyTargetVVD0154RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.03
*@LastModifier : 주선영
*@LastVersion : 1.0
* 2010.03.03 주선영
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

public class MonthlyTargetVVDDBDAOSearchMonthlyTargetVVD0154RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MonthlyTargetVVD 조회
	  * </pre>
	  */
	public MonthlyTargetVVDDBDAOSearchMonthlyTargetVVD0154RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.basicdatamanage.monthlytargetvvd.integration").append("\n"); 
		query.append("FileName : MonthlyTargetVVDDBDAOSearchMonthlyTargetVVD0154RSQL").append("\n"); 
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
		query.append("SELECT                                                                                                 " ).append("\n"); 
		query.append("    DECODE(M.BSE_YR||M.BSE_QTR_CD, @[year]||@[bse_qtr_cd], 'R', 'I') IBFLAG,                              " ).append("\n"); 
		query.append("    @[year] BSE_YR, " ).append("\n"); 
		query.append("    @[bse_qtr_cd] BSE_QTR_CD,                                                                            " ).append("\n"); 
		query.append("    M.TRD_CD, " ).append("\n"); 
		query.append("    M.RLANE_CD, " ).append("\n"); 
		query.append("    M.DIR_CD,                                                                    " ).append("\n"); 
		query.append("    M.VSL_CD, " ).append("\n"); 
		query.append("    M.SKD_VOY_NO, " ).append("\n"); 
		query.append("    M.SKD_DIR_CD,                                                              " ).append("\n"); 
		query.append("    M.SPRT_GRP_CD, " ).append("\n"); 
		query.append("    M.BSA_GRP_CD,                                                                       " ).append("\n"); 
		query.append("    M.BSE_MON, " ).append("\n"); 
		query.append("    M.BSE_WK,                                                                               " ).append("\n"); 
		query.append("    M.SUB_TRD_CD, " ).append("\n"); 
		query.append("    M.IOC_CD, " ).append("\n"); 
		query.append("    M.VVD_SEQ,                                                                 " ).append("\n"); 
		query.append("    M.FNL_BSA_CAPA,                                                                                    " ).append("\n"); 
		query.append("    TO_CHAR(M.LST_LODG_PORT_ETD_DT, 'YYYY/MM/DD HH24:MI:SS') LST_LODG_PORT_ETD_DT,                     " ).append("\n"); 
		query.append("    M.UPD_RMK,                                                                                         " ).append("\n"); 
		query.append("    M.LST_LODG_PORT_CD,                                                                                " ).append("\n"); 
		query.append("    M.DELT_FLG                                                                                         " ).append("\n"); 
		query.append("FROM SAQ_MON_TGT_VVD M                                                                                 " ).append("\n"); 
		query.append("WHERE M.BSE_YR = @[year]                                                                                   " ).append("\n"); 
		query.append("    AND  M.BSE_QTR_CD= @[bse_qtr_cd]                                                                               " ).append("\n"); 
		query.append("    AND ( @[trade] IS NULL OR M.TRD_CD = @[trade] )                                                                  " ).append("\n"); 
		query.append("    AND ( @[bound] IS NULL OR M.DIR_CD = @[bound])                                                                   " ).append("\n"); 
		query.append("    AND ( @[lane] IS NULL OR M.RLANE_CD = @[lane])                                                                 " ).append("\n"); 
		query.append("    AND M.DELT_FLG = 'N'                                                                               " ).append("\n"); 
		query.append("ORDER BY M.TRD_CD,M.DIR_CD," ).append("\n"); 
		query.append("         M.SUB_TRD_CD, " ).append("\n"); 
		query.append("         M.RLANE_CD, " ).append("\n"); 
		query.append("         M.LST_LODG_PORT_ETD_DT," ).append("\n"); 
		query.append("         M.BSE_YR," ).append("\n"); 
		query.append("         M.BSE_MON," ).append("\n"); 
		query.append("         M.BSE_WK" ).append("\n"); 

	}
}