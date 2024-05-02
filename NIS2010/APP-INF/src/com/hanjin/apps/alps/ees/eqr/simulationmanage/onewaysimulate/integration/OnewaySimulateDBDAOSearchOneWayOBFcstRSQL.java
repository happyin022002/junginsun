/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OnewaySimulateDBDAOSearchOneWayOBFcstRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.09.15 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.simulationmanage.onewaysimulate.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnewaySimulateDBDAOSearchOneWayOBFcstRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_ONE_WY_OFFR 테이블에 데이터 입력할때 사용할 기초데이터를 EQR_OB_FCAST 에서 조회
	  * </pre>
	  */
	public OnewaySimulateDBDAOSearchOneWayOBFcstRSQL(){
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
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_ecc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcast_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.simulationmanage.onewaysimulate.integration ").append("\n"); 
		query.append("FileName : OnewaySimulateDBDAOSearchOneWayOBFcstRSQL").append("\n"); 
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
		query.append("SELECT FCAST_YRWK," ).append("\n"); 
		query.append("FM_ECC_CD ," ).append("\n"); 
		query.append("TO_ECC_CD ," ).append("\n"); 
		query.append("CNTR_TPSZ_CD ," ).append("\n"); 
		query.append("ROUND(CNTR_VOL_QTY / ${daycount} * ${vol} ) CNTR_QTY," ).append("\n"); 
		query.append("FCAST_DEL_YRWK ," ).append("\n"); 
		query.append("FCAST_DT" ).append("\n"); 
		query.append("FROM  EQR_OB_FCAST" ).append("\n"); 
		query.append("WHERE SCNR_ID = @[scnr_id]" ).append("\n"); 
		query.append("AND FCAST_YRWK = @[fcast_yrwk]" ).append("\n"); 
		query.append("AND FM_ECC_CD = @[fm_ecc_cd]" ).append("\n"); 
		query.append("AND TO_ECC_CD = @[to_ecc_cd]" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 

	}
}