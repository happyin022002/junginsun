/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoPlanSensitivityAnalysisDBDAOUpdateSensitivitySafetyStock_USQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.09.21 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.simulationmanage.cntrrepoplansensitivityanalysis.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoPlanSensitivityAnalysisDBDAOUpdateSensitivitySafetyStock_USQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_ECC_SFT_STK테이블에 대한  QTY 수정
	  * </pre>
	  */
	public CntrRepoPlanSensitivityAnalysisDBDAOUpdateSensitivitySafetyStock_USQL(){
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
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.simulationmanage.cntrrepoplansensitivityanalysis.integration ").append("\n"); 
		query.append("FileName : CntrRepoPlanSensitivityAnalysisDBDAOUpdateSensitivitySafetyStock_USQL").append("\n"); 
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
		query.append("UPDATE  EQR_ECC_SFT_STK" ).append("\n"); 
		query.append("SET  SFSTK_VOL_QTY =  ${curr_limit}" ).append("\n"); 
		query.append(",UPD_USR_ID    =  @[user_id]" ).append("\n"); 
		query.append(",UPD_DT       = sysdate" ).append("\n"); 
		query.append("WHERE ECC_CD =  @[ecc_cd]" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}