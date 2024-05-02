/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LeaseInfoManageDBDAODeleteSTOnHireInfoDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.05
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.11.05 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.leaseinfomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Haeng-ji,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LeaseInfoManageDBDAODeleteSTOnHireInfoDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UI ID - EES_EQR_0017
	  * Title - S/T On Hire
	  * EQR_SCNR_SHRT_TERM_ONH_COND 테이블 데이터 삭제
	  * </pre>
	  */
	public LeaseInfoManageDBDAODeleteSTOnHireInfoDSQL(){
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
		params.put("scnr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.scenariomanage.leaseinfomanage.integration").append("\n"); 
		query.append("FileName : LeaseInfoManageDBDAODeleteSTOnHireInfoDSQL").append("\n"); 
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
		query.append("DELETE FROM EQR_SCNR_SHRT_TERM_ONH_COND" ).append("\n"); 
		query.append("WHERE	SCNR_ID		= @[scnr_id]" ).append("\n"); 
		query.append("AND	ECC_CD		= @[ecc_cd]" ).append("\n"); 
		query.append("AND	CNTR_TPSZ_CD= @[cntr_tpsz_cd]" ).append("\n"); 

	}
}