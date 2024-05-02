/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MonthlyQuotaCreationDBDAOUpdateCancelUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.02
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaCreationDBDAOUpdateCancelUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 버전의 Confirm 을 취소 한다.
	  * </pre>
	  */
	public MonthlyQuotaCreationDBDAOUpdateCancelUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ioc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mqta_mdl_ver_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaCreationDBDAOUpdateCancelUSQL").append("\n"); 
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
		query.append("UPDATE SAQ_MON_FCAST_TRNS " ).append("\n"); 
		query.append("       SET FCAST_TRNS_STS_CD = '0' " ).append("\n"); 
		query.append("     , UPD_USR_ID = @[user_id] " ).append("\n"); 
		query.append("     , UPD_DT = SYSDATE " ).append("\n"); 
		query.append(" WHERE 1=1 " ).append("\n"); 
		query.append("       AND MQTA_MDL_VER_NO = @[mqta_mdl_ver_no]" ).append("\n"); 
		query.append("      #if(${bound} != '' && ${bound} != 'ALL')" ).append("\n"); 
		query.append("	   AND DIR_CD = @[bound] " ).append("\n"); 
		query.append("      #end " ).append("\n"); 
		query.append("      #if(${trade} != '' && ${trade} != 'ALL')      " ).append("\n"); 
		query.append("       AND TRD_CD = @[trade]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      #if(${search_lane} != '' && ${search_lane} != 'ALL')                                                                                                                         " ).append("\n"); 
		query.append("       AND RLANE_CD   = @[search_lane]   " ).append("\n"); 
		query.append("      #end " ).append("\n"); 
		query.append("      #if(${ioc} != '' && ${ioc} != 'ALL')                                                                                                                              " ).append("\n"); 
		query.append("       AND IOC_CD     = @[ioc]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 

	}
}