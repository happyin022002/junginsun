/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WeeklyCMDBDAOCoaMonVvdVO2USQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 박수훈
*@LastVersion : 1.0
* 2009.10.14 박수훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SOO HOON PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WeeklyCMDBDAOCoaMonVvdVO2USQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RBCCO Update
	  * </pre>
	  */
	public WeeklyCMDBDAOCoaMonVvdVO2USQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_fm_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.integration").append("\n"); 
		query.append("FileName : WeeklyCMDBDAOCoaMonVvdVO2USQL").append("\n"); 
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
		query.append("UPDATE COA_MON_VVD VVD" ).append("\n"); 
		query.append("SET VVD.WKY_TGT_FLG      = 'Y'" ).append("\n"); 
		query.append(",VVD.MON_TGT_FLG      = 'Y'" ).append("\n"); 
		query.append(",VVD.DELT_FLG     	= 'N'" ).append("\n"); 
		query.append(",VVD.IOC_RULE_DESC 	= 'RBCCO Update'" ).append("\n"); 
		query.append(",VVD.UPD_USR_ID 	    = @[upd_usr_id]" ).append("\n"); 
		query.append(",VVD.UPD_DT 		    = SYSDATE" ).append("\n"); 
		query.append("WHERE VVD.RLANE_CD 		= 'RBCCO'" ).append("\n"); 
		query.append("AND VVD.COST_YRMON    	= @[f_cost_yr]||@[f_cost_fm_mon]" ).append("\n"); 

	}
}