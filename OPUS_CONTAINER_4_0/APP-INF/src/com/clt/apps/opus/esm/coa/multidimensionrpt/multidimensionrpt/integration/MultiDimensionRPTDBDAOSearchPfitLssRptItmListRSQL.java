/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MultiDimensionRPTDBDAOSearchPfitLssRptItmListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.27
*@LastModifier : 김기식
*@LastVersion : 1.0
* 2009.10.27 김기식
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.multidimensionrpt.multidimensionrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki-Sik
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MultiDimensionRPTDBDAOSearchPfitLssRptItmListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * P&L by Lane 헤더정보
	  * </pre>
	  */
	public MultiDimensionRPTDBDAOSearchPfitLssRptItmListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_pro_vw",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("str_display",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.multidimensionrpt.multidimensionrpt.integration").append("\n"); 
		query.append("FileName : MultiDimensionRPTDBDAOSearchPfitLssRptItmListRSQL").append("\n"); 
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
		query.append("SELECT STND_COST_CD" ).append("\n"); 
		query.append(", RPT_ITM_DESC" ).append("\n"); 
		query.append("FROM COA_PFIT_LSS_RPT_ITM" ).append("\n"); 
		query.append("WHERE RPT_VW_CD = @[f_pro_vw]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* stnd_cost_tp_cd" ).append("\n"); 
		query.append("- C: Contribution Magin" ).append("\n"); 
		query.append("- P: Operating Profit" ).append("\n"); 
		query.append("- S: Sales (영업수익)" ).append("\n"); 
		query.append("- O: Other (기타수익) */" ).append("\n"); 
		query.append("#if(${f_pro_vw} =='P' && ${f_pro_lvl} =='O')  /* Trade Profit + OP */" ).append("\n"); 
		query.append("/* P->O:실적, A:항로, B:TS기여도 */" ).append("\n"); 
		query.append("#if(${str_display} =='A' || ${str_display} =='B')" ).append("\n"); 
		query.append("AND (STND_COST_TP_CD IN ('S','C',@[str_display]) OR STND_COST_CD IN ('OPCOST00','OPCTOTAL','OPB00000'))" ).append("\n"); 
		query.append("#elseif (${str_display} =='O')" ).append("\n"); 
		query.append("AND STND_COST_TP_CD IN ('S','C',@[str_display])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if(${f_pro_lvl} =='C') /* CM */" ).append("\n"); 
		query.append("AND STND_COST_TP_CD IN ('S','C')" ).append("\n"); 
		query.append("#elseif (${f_pro_lvl} =='O') /* OP */" ).append("\n"); 
		query.append("AND STND_COST_TP_CD IN ('S','C','O')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY RPT_DP_SEQ" ).append("\n"); 

	}
}