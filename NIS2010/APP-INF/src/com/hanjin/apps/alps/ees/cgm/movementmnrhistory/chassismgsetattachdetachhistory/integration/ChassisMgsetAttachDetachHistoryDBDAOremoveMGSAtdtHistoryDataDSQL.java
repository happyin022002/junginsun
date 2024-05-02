/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMgsetAttachDetachHistoryDBDAOremoveMGSAtdtHistoryDataDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.28
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2010.04.28 조재성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChaeShung Cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetAttachDetachHistoryDBDAOremoveMGSAtdtHistoryDataDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChassisMgsetAttachDetachHistoryDBDAOremoveMGSAtdtHistoryDataDSQL
	  * </pre>
	  */
	public ChassisMgsetAttachDetachHistoryDBDAOremoveMGSAtdtHistoryDataDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atch_dt_hd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atch_dt_day",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.integration").append("\n"); 
		query.append("FileName : ChassisMgsetAttachDetachHistoryDBDAOremoveMGSAtdtHistoryDataDSQL").append("\n"); 
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
		query.append("DELETE CGM_EQ_ATCH_DTCH_HIS" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("AND ATCH_DT  = TO_DATE(@[atch_dt_day]||@[atch_dt_hd]||'00'  ,'YYYYMMDDHH24MISS')" ).append("\n"); 

	}
}