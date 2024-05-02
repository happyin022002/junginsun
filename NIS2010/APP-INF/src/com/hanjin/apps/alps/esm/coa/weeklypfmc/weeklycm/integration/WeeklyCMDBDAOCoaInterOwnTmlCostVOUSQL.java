/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : WeeklyCMDBDAOCoaInterOwnTmlCostVOUSQL.java
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

public class WeeklyCMDBDAOCoaInterOwnTmlCostVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_COA_118 TML 단가 수정
	  * </pre>
	  */
	public WeeklyCMDBDAOCoaInterOwnTmlCostVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_tml_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uc_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_uc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_trf_dtl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("coa_cost_src_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_trf_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.integration").append("\n"); 
		query.append("FileName : WeeklyCMDBDAOCoaInterOwnTmlCostVOUSQL").append("\n"); 
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
		query.append("MERGE INTO COA_INTER_OWN_TML_COST A" ).append("\n"); 
		query.append("     USING (SELECT @[cost_yrmon] COST_YRMON" ).append("\n"); 
		query.append("                  ,@[tml_cd] TML_CD" ).append("\n"); 
		query.append("                  ,@[tml_trf_itm_cd] TML_TRF_ITM_CD" ).append("\n"); 
		query.append("                  ,@[tml_trf_dtl_cd] TML_TRF_DTL_CD   " ).append("\n"); 
		query.append("                  ,@[cntr_tpsz_cd] CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                  ,@[coa_cost_src_cd] COA_COST_SRC_CD" ).append("\n"); 
		query.append("                  ,@[tml_ut_cd] TML_UT_CD" ).append("\n"); 
		query.append("                  ,@[locl_curr_cd] LOCL_CURR_CD" ).append("\n"); 
		query.append("                  ,TO_NUMBER(@[tml_qty]) TML_QTY" ).append("\n"); 
		query.append("                  ,TO_NUMBER(@[locl_tml_amt]) LOCL_TML_AMT" ).append("\n"); 
		query.append("                  ,TO_NUMBER(@[tml_usd_amt]) TML_USD_AMT" ).append("\n"); 
		query.append("                  ,TO_NUMBER(@[tml_uc_amt]) TML_UC_AMT" ).append("\n"); 
		query.append("                  ,@[cre_usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("                  ,SYSDATE CRE_DT" ).append("\n"); 
		query.append("                  ,@[upd_usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("                  ,SYSDATE UPD_DT" ).append("\n"); 
		query.append("                  ,@[uc_slan_cd] UC_SLAN_CD" ).append("\n"); 
		query.append("              FROM DUAL) B" ).append("\n"); 
		query.append("    ON (A.COST_YRMON = B.COST_YRMON" ).append("\n"); 
		query.append("        AND A.TML_CD = B.TML_CD" ).append("\n"); 
		query.append("        AND A.TML_TRF_ITM_CD = B.TML_TRF_ITM_CD" ).append("\n"); 
		query.append("        AND A.TML_TRF_DTL_CD = B.TML_TRF_DTL_CD" ).append("\n"); 
		query.append("        AND A.CNTR_TPSZ_CD = B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        AND A.UC_SLAN_CD = B.UC_SLAN_CD)" ).append("\n"); 
		query.append("    WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("        INSERT (COST_YRMON, TML_CD, TML_TRF_ITM_CD, TML_TRF_DTL_CD, CNTR_TPSZ_CD, COA_COST_SRC_CD" ).append("\n"); 
		query.append("			   ,TML_UT_CD ,LOCL_CURR_CD, TML_QTY, LOCL_TML_AMT, TML_USD_AMT, TML_UC_AMT, CRE_USR_ID" ).append("\n"); 
		query.append("               ,CRE_DT, UPD_USR_ID, UPD_DT, UC_SLAN_CD)" ).append("\n"); 
		query.append("        VALUES (B.COST_YRMON, B.TML_CD, B.TML_TRF_ITM_CD, B.TML_TRF_DTL_CD, B.CNTR_TPSZ_CD, B.COA_COST_SRC_CD" ).append("\n"); 
		query.append("               ,B.TML_UT_CD, B.LOCL_CURR_CD, B.TML_QTY, B.LOCL_TML_AMT,B.TML_USD_AMT, B.TML_UC_AMT, B.CRE_USR_ID" ).append("\n"); 
		query.append("			   ,B.CRE_DT, B.UPD_USR_ID, B.UPD_DT, B.UC_SLAN_CD)" ).append("\n"); 
		query.append("    WHEN MATCHED THEN" ).append("\n"); 
		query.append("        UPDATE" ).append("\n"); 
		query.append("           SET A.COA_COST_SRC_CD = B.COA_COST_SRC_CD, A.TML_UT_CD = B.TML_UT_CD, A.LOCL_CURR_CD = B.LOCL_CURR_CD" ).append("\n"); 
		query.append("              ,A.TML_QTY = B.TML_QTY ,A.LOCL_TML_AMT = B.LOCL_TML_AMT, A.TML_USD_AMT = B.TML_USD_AMT" ).append("\n"); 
		query.append("			  , A.TML_UC_AMT = B.TML_UC_AMT ,A.UPD_USR_ID = B.UPD_USR_ID, A.UPD_DT = B.UPD_DT" ).append("\n"); 

	}
}