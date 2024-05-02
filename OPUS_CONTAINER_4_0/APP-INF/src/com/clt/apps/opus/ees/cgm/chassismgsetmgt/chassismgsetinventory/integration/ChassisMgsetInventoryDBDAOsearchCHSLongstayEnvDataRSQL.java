/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetInventoryDBDAOsearchCHSLongstayEnvDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.09.25 조재성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Shung, Cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInventoryDBDAOsearchCHSLongstayEnvDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * chungpa 20090722 1094 select query recreate
	  * </pre>
	  */
	public ChassisMgsetInventoryDBDAOsearchCHSLongstayEnvDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stay_dys_inp_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInventoryDBDAOsearchCHSLongstayEnvDataRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("t1.N1ST_INQ_FM_DYS" ).append("\n"); 
		query.append(", t1.N1ST_INQ_TO_DYS" ).append("\n"); 
		query.append(", t1.N2ND_INQ_FM_DYS" ).append("\n"); 
		query.append(", t1.N2ND_INQ_TO_DYS" ).append("\n"); 
		query.append(", t1.N3RD_INQ_FM_DYS" ).append("\n"); 
		query.append(", t1.N3RD_INQ_TO_DYS" ).append("\n"); 
		query.append(", t1.N4TH_INQ_FM_DYS" ).append("\n"); 
		query.append(", t1.N4TH_INQ_TO_DYS" ).append("\n"); 
		query.append(", t1.N5TH_INQ_FM_DYS" ).append("\n"); 
		query.append(", t1.N5TH_INQ_TO_DYS" ).append("\n"); 
		query.append("FROM CGM_LONG_STAY_DYS_ENV t1" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("t1.STAY_DYS_INP_USR_ID = @[stay_dys_inp_usr_id]" ).append("\n"); 

	}
}