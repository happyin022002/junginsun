/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOBasicRegisterDBDAOFmsRevenuePortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOBasicRegisterDBDAOFmsRevenuePortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Revenue Port Management Select
	  * </pre>
	  */
	public TCharterIOBasicRegisterDBDAOFmsRevenuePortRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.integration").append("\n"); 
		query.append("FileName : TCharterIOBasicRegisterDBDAOFmsRevenuePortRSQL").append("\n"); 
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
		query.append("SELECT A.RLANE_CD" ).append("\n"); 
		query.append("     , A.SKD_DIR_CD" ).append("\n"); 
		query.append("     , A.REV_DIR_CD" ).append("\n"); 
		query.append("     , A.SLAN_CD" ).append("\n"); 
		query.append("     , A.FLET_IOC_CD" ).append("\n"); 
		query.append("     , A.ST_PORT_CD" ).append("\n"); 
		query.append("     , A.FNL_PORT_CD" ).append("\n"); 
		query.append("     , A.CRE_USR_ID" ).append("\n"); 
		query.append("     , A.CRE_DT" ).append("\n"); 
		query.append("     , A.UPD_USR_ID" ).append("\n"); 
		query.append("     , A.UPD_DT" ).append("\n"); 
		query.append("     , (SELECT CASE" ).append("\n"); 
		query.append("                 WHEN COUNT(RLANE_DIR_CD) > 0 THEN 'Y'" ).append("\n"); 
		query.append("                 ELSE ''" ).append("\n"); 
		query.append("               END AS USED_YN" ).append("\n"); 
		query.append("          FROM AR_FINC_DIR_CONV" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("           AND RLANE_CD = A.RLANE_CD) AS USED_YN" ).append("\n"); 
		query.append("  FROM FMS_BSE_PORT A" ).append("\n"); 
		query.append("     , MDM_VSL_SVC_LANE_DIR M" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.SLAN_CD = M.VSL_SLAN_CD" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD = VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("#if (${slan_cd} != '')                                                                               " ).append("\n"); 
		query.append("   AND A.SLAN_CD = @[slan_cd]                                                                   " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rlane_cd} != '')                                                                               " ).append("\n"); 
		query.append("   AND A.RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY A.SLAN_CD" ).append("\n"); 
		query.append("     , M.VSL_SLAN_DIR_SEQ" ).append("\n"); 
		query.append("     , A.SKD_DIR_CD" ).append("\n"); 
		query.append("     , A.REV_DIR_CD" ).append("\n"); 
		query.append("     , A.RLANE_CD" ).append("\n"); 

	}
}