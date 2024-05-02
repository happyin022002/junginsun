/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : WeeklyCMDBDAOSearchOwnTMLPfmcListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.15
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2011.07.15 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Min CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WeeklyCMDBDAOSearchOwnTMLPfmcListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_COA_0118 화면 조회 결과 쿼리.
	  * 2010.08.25 이윤정 [CHM-201005513] 현재 입력건의 경우 ESM_COA_0118 화면상 "Curr."를 Local AMT가 아닌 Unit Cost에 대한 Curr.로 사용 변경
	  * </pre>
	  */
	public WeeklyCMDBDAOSearchOwnTMLPfmcListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_tml_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.integration").append("\n"); 
		query.append("FileName : WeeklyCMDBDAOSearchOwnTMLPfmcListVORSQL").append("\n"); 
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
		query.append("SELECT A.COST_YRMON " ).append("\n"); 
		query.append("  	  ,A.TML_CD " ).append("\n"); 
		query.append("  	  ,A.TML_TRF_ITM_CD " ).append("\n"); 
		query.append("  	  ,C.TML_TRF_ITM_DESC " ).append("\n"); 
		query.append("  	  ,A.TML_TRF_DTL_CD " ).append("\n"); 
		query.append("  	  ,C.TML_TRF_DTL_DESC " ).append("\n"); 
		query.append("  	  ,A.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("  	  ,A.COA_COST_SRC_CD " ).append("\n"); 
		query.append("  	  ,B.COA_COST_SRC_CD_NM " ).append("\n"); 
		query.append("  	  ,A.TML_UT_CD " ).append("\n"); 
		query.append("  	  ,A.LOCL_CURR_CD " ).append("\n"); 
		query.append("  	 -- ,A.MN_ITM_CHK_FLG " ).append("\n"); 
		query.append("  	 -- ,A.MN_TRF_DTL_CD " ).append("\n"); 
		query.append("  	 -- ,A.TML_QTY " ).append("\n"); 
		query.append("  	 -- ,A.LOCL_TML_AMT " ).append("\n"); 
		query.append("  	 -- ,A.TML_USD_AMT " ).append("\n"); 
		query.append("  	  ,A.TML_UC_AMT " ).append("\n"); 
		query.append("	 -- ,A.CRE_USR_ID " ).append("\n"); 
		query.append("	 -- ,A.CRE_DT " ).append("\n"); 
		query.append("	 -- ,A.UPD_USR_ID " ).append("\n"); 
		query.append("	 -- ,A.UPD_DT " ).append("\n"); 
		query.append("	  ,A.UC_SLAN_CD" ).append("\n"); 
		query.append(" FROM COA_INTER_OWN_TML_COST A, COA_COST_SRC_ACCT B, COA_TML_TRF_GRP C" ).append("\n"); 
		query.append("WHERE A.COA_COST_SRC_CD = B.COA_COST_SRC_CD " ).append("\n"); 
		query.append("  AND A.TML_CD = C.TML_CD  " ).append("\n"); 
		query.append("  AND A.TML_TRF_ITM_CD = C.TML_TRF_ITM_CD  " ).append("\n"); 
		query.append("  AND A.TML_TRF_DTL_CD = C.TML_TRF_DTL_CD  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #if (${f_cost_yrmon} != '') " ).append("\n"); 
		query.append("  AND A.COST_YRMON = @[f_cost_yrmon]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  #if (${f_tml_cd} != '') " ).append("\n"); 
		query.append("  AND A.TML_CD = @[f_tml_cd]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  #if (${f_cntr_tpsz_cd} != '') " ).append("\n"); 
		query.append("  AND A.CNTR_TPSZ_CD = @[f_cntr_tpsz_cd]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("ORDER BY COST_YRMON, TML_CD, TML_TRF_ITM_CD, TML_TRF_DTL_CD, CNTR_TPSZ_CD" ).append("\n"); 

	}
}