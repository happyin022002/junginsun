/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OnhireDomesticNewvanShceduleInputDBDAOMergeYearDomesticPlanCSQL.java
*@FileTitle : sample
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 
*@LastVersion : 1.0
* 2009.08.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnhireDomesticNewvanShceduleInputDBDAOMergeYearDomesticPlanCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_SCNR_DMST 테이블의 데이터 수정/입력
	  * </pre>
	  */
	public OnhireDomesticNewvanShceduleInputDBDAOMergeYearDomesticPlanCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scnr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_ecc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pln_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_ecc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_vol_qty",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.integration").append("\n"); 
		query.append("FileName : OnhireDomesticNewvanShceduleInputDBDAOMergeYearDomesticPlanCSQL").append("\n"); 
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
		query.append("MERGE INTO EQR_SCNR_DMST I" ).append("\n"); 
		query.append("USING" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[scnr_id] AS SCNR_ID" ).append("\n"); 
		query.append(",@[pln_yrwk] AS PLN_YRWK" ).append("\n"); 
		query.append(",@[fm_ecc_cd] AS FM_ECC_CD" ).append("\n"); 
		query.append(",@[to_ecc_cd] AS TO_ECC_CD" ).append("\n"); 
		query.append(",@[cntr_tpsz_cd] AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(") M" ).append("\n"); 
		query.append("ON" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("I.SCNR_ID     = M.SCNR_ID" ).append("\n"); 
		query.append("AND I.PLN_YRWK = M.PLN_YRWK" ).append("\n"); 
		query.append("AND I.FM_ECC_CD = M.FM_ECC_CD" ).append("\n"); 
		query.append("AND I.TO_ECC_CD = M.TO_ECC_CD" ).append("\n"); 
		query.append("AND I.CNTR_TPSZ_CD  = M.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET I.CNTR_VOL_QTY   	= @[cntr_vol_qty]," ).append("\n"); 
		query.append("I.UPD_USR_ID      	= @[upd_usr_id]," ).append("\n"); 
		query.append("I.UPD_DT    	  	= SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("I.SCNR_ID" ).append("\n"); 
		query.append(",I.PLN_YRWK" ).append("\n"); 
		query.append(",I.FM_ECC_CD" ).append("\n"); 
		query.append(",I.TO_ECC_CD" ).append("\n"); 
		query.append(",I.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",I.CNTR_VOL_QTY" ).append("\n"); 
		query.append(",I.CRE_USR_ID" ).append("\n"); 
		query.append(",I.CRE_DT" ).append("\n"); 
		query.append(",I.UPD_USR_ID" ).append("\n"); 
		query.append(",I.UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("@[scnr_id]" ).append("\n"); 
		query.append(", @[pln_yrwk]" ).append("\n"); 
		query.append(", @[fm_ecc_cd]" ).append("\n"); 
		query.append(", @[to_ecc_cd]" ).append("\n"); 
		query.append(", @[cntr_tpsz_cd]" ).append("\n"); 
		query.append(", @[cntr_vol_qty]" ).append("\n"); 
		query.append(", @[upd_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[upd_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}