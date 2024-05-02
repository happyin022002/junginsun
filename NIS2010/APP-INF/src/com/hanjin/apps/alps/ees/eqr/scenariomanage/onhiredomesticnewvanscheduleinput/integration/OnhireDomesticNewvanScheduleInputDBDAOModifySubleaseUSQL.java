/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OnhireDomesticNewvanScheduleInputDBDAOModifySubleaseUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.08.11 정은호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChungEunHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnhireDomesticNewvanScheduleInputDBDAOModifySubleaseUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * eqr_scnr_slse 데이터 수정
	  * </pre>
	  */
	public OnhireDomesticNewvanScheduleInputDBDAOModifySubleaseUSQL(){
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

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rsCount",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yrWk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.integration").append("\n"); 
		query.append("FileName : OnhireDomesticNewvanScheduleInputDBDAOModifySubleaseUSQL").append("\n"); 
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
		query.append("UPDATE EQR_SCNR_SLSE SET" ).append("\n"); 
		query.append("CNTR_VOL_QTY = CNTR_VOL_QTY" ).append("\n"); 
		query.append("+ (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("( @[rsCount] - SUM(cntr_vol_qty)) QTY" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_SCNR_SLSE A" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.pln_yrwk = @[yrWk]" ).append("\n"); 
		query.append("AND scnr_id = @[scnr_id]" ).append("\n"); 
		query.append("AND fm_ecc_cd in ( SELECT ECC_CD FROM EQR_ECC_MST WHERE RCC_CD = @[rcc_cd]  )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("SCNR_ID = @[scnr_id]" ).append("\n"); 
		query.append("AND PLN_YRWK = @[yrWk]" ).append("\n"); 
		query.append("AND FM_ECC_CD = (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("fm_ecc_cd" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("eqr_slse_perf A" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("slse_rto = (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("MAX(slse_rto)slse_rto" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_SLSE_PERF" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("FM_ECC_CD IN ( SELECT ecc_cd FROM eqr_ecc_mst WHERE rcc_cd = @[rcc_cd]  )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND TO_ECC_CD = (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("to_ecc_cd" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_SLSE_PERF A" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("SLSE_RTO = (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("MAX(slse_rto)slse_rto" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_SLSE_PERF" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("FM_ECC_CD IN ( SELECT ecc_cd FROM eqr_ecc_mst WHERE rcc_cd = @[rcc_cd] )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD = (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CNTR_TPSZ_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_SLSE_PERF A" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("SLSE_RTO = (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("MAX(slse_rto)slse_rto" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_SLSE_PERF" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("FM_ECC_CD IN (SELECT ecc_cd FROM eqr_ecc_mst WHERE rcc_cd = @[rcc_cd]  )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND FM_ECC_CD IN (SELECT ecc_cd FROM eqr_ecc_mst WHERE rcc_cd = @[rcc_cd] )" ).append("\n"); 

	}
}