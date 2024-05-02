/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMovementHistoryDBDAOremoveCgmChssMvmtHisDataDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.09.24 최민회
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI MIN HOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMovementHistoryDBDAOremoveCgmChssMvmtHisDataDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * *Chassis movement 를 UPDATE 수행
	  *  CGM CHASSIS MOVEMENT 엔티티
	  * </pre>
	  */
	public ChassisMovementHistoryDBDAOremoveCgmChssMvmtHisDataDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_id_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.integration").append("\n"); 
		query.append("FileName : ChassisMovementHistoryDBDAOremoveCgmChssMvmtHisDataDSQL").append("\n"); 
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
		query.append("DELETE FROM CGM_CHSS_MVMT_HIS" ).append("\n"); 
		query.append("WHERE CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND CNMV_YR = @[cnmv_yr]" ).append("\n"); 
		query.append("AND CNMV_ID_NO = @[cnmv_id_no]" ).append("\n"); 

	}
}