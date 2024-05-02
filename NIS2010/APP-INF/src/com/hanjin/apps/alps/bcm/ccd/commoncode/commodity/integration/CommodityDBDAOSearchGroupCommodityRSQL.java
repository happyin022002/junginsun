/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : CommodityDBDAOSearchGroupCommodityRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.commodity.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommodityDBDAOSearchGroupCommodityRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2011.03.02 조인영 Group Commodity 정보를 조회한다.
	  * </pre>
	  */
	public CommodityDBDAOSearchGroupCommodityRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grp_cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.ccd.commoncode.commodity.integration").append("\n"); 
		query.append("FileName : CommodityDBDAOSearchGroupCommodityRSQL").append("\n"); 
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
		query.append("SELECT GRP_CMDT_CD" ).append("\n"); 
		query.append("      ,MIN_REP_CMDT_CD" ).append("\n"); 
		query.append("      ,MAX_REP_CMDT_CD" ).append("\n"); 
		query.append("      ,GRP_CMDT_ENG_NM" ).append("\n"); 
		query.append("      ,GRP_CMDT_KRN_NM" ).append("\n"); 
		query.append("      ,GRP_CMDT_JPN_NM" ).append("\n"); 
		query.append("      ,GRP_CMDT_CHN_NM" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,CRE_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,UPD_DT" ).append("\n"); 
		query.append("      ,DELT_FLG" ).append("\n"); 
		query.append("FROM   MDM_GRP_CMDT" ).append("\n"); 
		query.append("WHERE  GRP_CMDT_CD = @[grp_cmdt_cd]" ).append("\n"); 

	}
}