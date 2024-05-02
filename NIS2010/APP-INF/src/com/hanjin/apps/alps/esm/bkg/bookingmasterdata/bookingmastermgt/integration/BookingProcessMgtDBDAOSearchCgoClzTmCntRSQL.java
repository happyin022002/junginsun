/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BookingProcessMgtDBDAOSearchCgoClzTmCntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.20
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2013.03.20 조원주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingProcessMgtDBDAOSearchCgoClzTmCntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * cargo closing time setup Check
	  * </pre>
	  */
	public BookingProcessMgtDBDAOSearchCgoClzTmCntRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingProcessMgtDBDAOSearchCgoClzTmCntRSQL").append("\n"); 
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
		query.append("SELECT   " ).append("\n"); 
		query.append("        (   SELECT  COUNT(*) " ).append("\n"); 
		query.append("            FROM    MDM_LOCATION" ).append("\n"); 
		query.append("            WHERE   LOC_CD      = @[pol_cd]" ).append("\n"); 
		query.append("            AND     DELT_FLG    = 'N'           ) POL_CNT," ).append("\n"); 
		query.append("        (   SELECT  COUNT(*)" ).append("\n"); 
		query.append("            FROM    MDM_VSL_SVC_LANE_DIR" ).append("\n"); 
		query.append("            WHERE   VSL_SLAN_CD = @[lane_cd]" ).append("\n"); 
		query.append("            AND     DELT_FLG    = 'N'           ) LANE_CNT," ).append("\n"); 
		query.append("        (   SELECT  COUNT(*)" ).append("\n"); 
		query.append("            FROM    MDM_VSL_SVC_LANE_DIR" ).append("\n"); 
		query.append("            WHERE   VSL_SLAN_DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("            AND     DELT_FLG    = 'N'           ) DIR_CNT" ).append("\n"); 
		query.append("FROM    DUAL" ).append("\n"); 

	}
}