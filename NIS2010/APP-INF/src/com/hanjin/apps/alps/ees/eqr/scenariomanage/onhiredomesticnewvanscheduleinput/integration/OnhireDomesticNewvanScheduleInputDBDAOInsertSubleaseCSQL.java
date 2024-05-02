/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OnhireDomesticNewvanScheduleInputDBDAOInsertSubleaseCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.08.10 정은호
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

public class OnhireDomesticNewvanScheduleInputDBDAOInsertSubleaseCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * eqr_slse_perf테이블의 데이터 입력
	  * </pre>
	  */
	public OnhireDomesticNewvanScheduleInputDBDAOInsertSubleaseCSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("User_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.integration").append("\n"); 
		query.append("FileName : OnhireDomesticNewvanScheduleInputDBDAOInsertSubleaseCSQL").append("\n"); 
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
		query.append("INSERT INTO EQR_SCNR_SLSE (" ).append("\n"); 
		query.append("scnr_id" ).append("\n"); 
		query.append(", pln_yrwk" ).append("\n"); 
		query.append(", fm_ecc_cd" ).append("\n"); 
		query.append(", to_ecc_cd" ).append("\n"); 
		query.append(", cntr_tpsz_cd" ).append("\n"); 
		query.append(", cntr_vol_qty" ).append("\n"); 
		query.append(", cre_usr_id" ).append("\n"); 
		query.append(", cre_dt" ).append("\n"); 
		query.append(", upd_usr_id" ).append("\n"); 
		query.append(", upd_dt" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[scnr_id]" ).append("\n"); 
		query.append(", @[yrWk]" ).append("\n"); 
		query.append(", fm_ecc_cd" ).append("\n"); 
		query.append(", to_ecc_cd" ).append("\n"); 
		query.append(", cntr_tpsz_cd" ).append("\n"); 
		query.append(", ROUND(@[rsCount] * slse_rto / 100)" ).append("\n"); 
		query.append(", @[User_id]" ).append("\n"); 
		query.append(", sysdate" ).append("\n"); 
		query.append(", @[User_id]" ).append("\n"); 
		query.append(", sysdate" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_SLSE_PERF" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("FM_ECC_CD IN (" ).append("\n"); 
		query.append("SELECT ecc_cd FROM eqr_ecc_mst WHERE rcc_cd = @[rcc_cd] AND DELT_FLG = 'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}