/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : AverageRPBDBDAOSearchRouteRPBListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.24
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.averagerpb.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AverageRPBDBDAOSearchRouteRPBListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchRouteRPBList
	  * </pre>
	  */
	public AverageRPBDBDAOSearchRouteRPBListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bkg_por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bkg_del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rpb_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ioc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.stdunitcost.averagerpb.integration").append("\n"); 
		query.append("FileName : AverageRPBDBDAOSearchRouteRPBListRSQL").append("\n"); 
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
		query.append("SELECT RPB_YRMON" ).append("\n"); 
		query.append("     , RLANE_CD" ).append("\n"); 
		query.append("     , IOC_CD" ).append("\n"); 
		query.append("     , BKG_POR_CD" ).append("\n"); 
		query.append("     , BKG_DEL_CD" ).append("\n"); 
		query.append("     , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , BKG_AVG_RPB_REV" ).append("\n"); 
		query.append("     , BKG_OFT_AVG_RPB_REV" ).append("\n"); 
		query.append("     , BKG_MISC_AVG_RPB_REV" ).append("\n"); 
		query.append("     , SCR_CHG_AVG_RPB_REV" ).append("\n"); 
		query.append("FROM COA_MON_ROUT_RPB" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND RPB_YRMON = REPLACE(@[f_rpb_yrmon],'-','')" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '') " ).append("\n"); 
		query.append("  AND RLANE_CD = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("#if (${f_ioc_cd} != '') " ).append("\n"); 
		query.append("  AND IOC_CD = @[f_ioc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_bkg_por_cd} != '')   " ).append("\n"); 
		query.append("  AND BKG_POR_CD = @[f_bkg_por_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_bkg_del_cd} != '') " ).append("\n"); 
		query.append("  AND BKG_DEL_CD = @[f_bkg_del_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_cntr_tpsz_cd} != '') " ).append("\n"); 
		query.append("  AND CNTR_TPSZ_CD = @[f_cntr_tpsz_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY RPB_YRMON" ).append("\n"); 
		query.append("     , RLANE_CD" ).append("\n"); 
		query.append("     , IOC_CD" ).append("\n"); 
		query.append("     , BKG_POR_CD" ).append("\n"); 
		query.append("     , BKG_DEL_CD" ).append("\n"); 

	}
}