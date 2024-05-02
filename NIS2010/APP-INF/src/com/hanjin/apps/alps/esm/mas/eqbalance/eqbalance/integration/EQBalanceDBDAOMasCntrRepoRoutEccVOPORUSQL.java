/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EQBalanceDBDAOMasCntrRepoRoutEccVOPORUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.31
*@LastModifier : 전윤주
*@LastVersion : 1.0
* 2010.05.31 전윤주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.eqbalance.eqbalance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeon Yun Joo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQBalanceDBDAOMasCntrRepoRoutEccVOPORUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * From(DEL) ECC 수정
	  * </pre>
	  */
	public EQBalanceDBDAOMasCntrRepoRoutEccVOPORUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ecc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_repo_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.eqbalance.eqbalance.integration").append("\n"); 
		query.append("FileName : EQBalanceDBDAOMasCntrRepoRoutEccVOPORUSQL").append("\n"); 
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
		query.append("MERGE INTO MAS_CNTR_REPO_ROUT_ECC B1" ).append("\n"); 
		query.append("   USING (SELECT @[cost_yrmon] COST_YRMON" ).append("\n"); 
		query.append("                ,@[rcc_cd] RCC_CD" ).append("\n"); 
		query.append("                ,@[ecc_cd] ECC_CD" ).append("\n"); 
		query.append("                ,DECODE(SUBSTR(@[cntr_tpsz_cd], 1, 1), 'D', 'D', REPLACE(@[cntr_tpsz_cd], 'RD', 'R')) CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                ,DECODE(SUBSTR(@[cntr_tpsz_cd], 1, 1), 'R', 'Y', 'N') SPCL_CGO_RF_FLG" ).append("\n"); 
		query.append("                ,DECODE(@[por_repo_flg], 1, 'Y', 'N') POR_REPO_FLG" ).append("\n"); 
		query.append("                ,@[cre_usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("                ,SYSDATE CRE_DT" ).append("\n"); 
		query.append("                ,@[upd_usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("                ,SYSDATE UPD_DT				" ).append("\n"); 
		query.append("            FROM DUAL) B2" ).append("\n"); 
		query.append("   ON (    B1.COST_YRMON = B2.COST_YRMON" ).append("\n"); 
		query.append("       AND B1.RCC_CD = B2.RCC_CD" ).append("\n"); 
		query.append("       AND B1.ECC_CD = B2.ECC_CD" ).append("\n"); 
		query.append("       AND B1.CNTR_TPSZ_CD = B2.CNTR_TPSZ_CD )" ).append("\n"); 
		query.append("   WHEN MATCHED THEN" ).append("\n"); 
		query.append("      UPDATE" ).append("\n"); 
		query.append("         SET B1.POR_REPO_FLG = B2.POR_REPO_FLG, B1.UPD_USR_ID = B2.UPD_USR_ID, B1.UPD_DT = B2.UPD_DT" ).append("\n"); 
		query.append("   WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("      INSERT(B1.COST_YRMON, B1.RCC_CD, B1.ECC_CD, B1.CNTR_TPSZ_CD, B1.SPCL_CGO_RF_FLG, B1.POR_REPO_FLG, B1.CRE_USR_ID, B1.CRE_DT, B1.UPD_USR_ID, B1.UPD_DT)" ).append("\n"); 
		query.append("      VALUES(B2.COST_YRMON, B2.RCC_CD, B2.ECC_CD, B2.CNTR_TPSZ_CD, B2.SPCL_CGO_RF_FLG, B2.POR_REPO_FLG, B2.CRE_USR_ID, B2.CRE_DT, B2.UPD_USR_ID, B2.UPD_DT)" ).append("\n"); 

	}
}