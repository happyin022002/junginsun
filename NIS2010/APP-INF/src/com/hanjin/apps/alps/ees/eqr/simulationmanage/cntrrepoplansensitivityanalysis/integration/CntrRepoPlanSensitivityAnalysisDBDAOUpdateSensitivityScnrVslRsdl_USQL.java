/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoPlanSensitivityAnalysisDBDAOUpdateSensitivityScnrVslRsdl_USQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.09.21 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.simulationmanage.cntrrepoplansensitivityanalysis.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoPlanSensitivityAnalysisDBDAOUpdateSensitivityScnrVslRsdl_USQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_SCNR_VSL_RSDL_CAPA 테이블에 대한  QTY 수정
	  * </pre>
	  */
	public CntrRepoPlanSensitivityAnalysisDBDAOUpdateSensitivityScnrVslRsdl_USQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_lane_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcast_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.simulationmanage.cntrrepoplansensitivityanalysis.integration").append("\n"); 
		query.append("FileName : CntrRepoPlanSensitivityAnalysisDBDAOUpdateSensitivityScnrVslRsdl_USQL").append("\n"); 
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
		query.append("UPDATE EQR_SCNR_VSL_RSDL_CAPA" ).append("\n"); 
		query.append("SET  TTL_RSDL_SPC = ${ttl_rsdl_spc}" ).append("\n"); 
		query.append(",UPD_USR_ID   = @[user_id]" ).append("\n"); 
		query.append(",UPD_DT       = sysdate" ).append("\n"); 
		query.append("WHERE  FCAST_YRWK = @[fcast_yrwk]" ).append("\n"); 
		query.append("AND ECC_CD                             = @[ecc_cd]" ).append("\n"); 
		query.append("AND VSL_CD || SKD_VOY_NO || SKD_DIR_CD = @[vvd]" ).append("\n"); 
		query.append("AND SCNR_ID                            = @[scnr_id]" ).append("\n"); 
		query.append("AND VLS_LANE_CD                        = @[vsl_lane_cd]" ).append("\n"); 
		query.append("AND CO_CD ='H'" ).append("\n"); 

	}
}