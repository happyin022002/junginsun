/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RatingUnitDBDAOPriRatUtVODSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.11
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2010.01.11 이승준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.ratingunit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seung-Jun,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RatingUnitDBDAOPriRatUtVODSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public RatingUnitDBDAOPriRatUtVODSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rat_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.primasterdata.ratingunit.integration").append("\n"); 
		query.append("FileName : RatingUnitDBDAOPriRatUtVODSQL").append("\n"); 
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
		query.append("UPDATE pri_rat_ut SET" ).append("\n"); 
		query.append("delt_flg = 'Y'" ).append("\n"); 
		query.append(",	upd_usr_id = @[upd_usr_id]" ).append("\n"); 
		query.append(",	upd_dt = SYSDATE" ).append("\n"); 
		query.append("WHERE	rat_ut_cd = @[rat_ut_cd]" ).append("\n"); 

	}
}