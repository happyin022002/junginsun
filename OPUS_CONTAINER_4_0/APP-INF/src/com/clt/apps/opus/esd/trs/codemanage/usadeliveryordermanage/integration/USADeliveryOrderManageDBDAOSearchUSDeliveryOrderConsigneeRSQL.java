/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : USADeliveryOrderManageDBDAOSearchUSDeliveryOrderConsigneeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.20
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.usadeliveryordermanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USADeliveryOrderManageDBDAOSearchUSDeliveryOrderConsigneeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchUSDeliveryOrderConsignee
	  * </pre>
	  */
	public USADeliveryOrderManageDBDAOSearchUSDeliveryOrderConsigneeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.codemanage.usadeliveryordermanage.integration").append("\n"); 
		query.append("FileName : USADeliveryOrderManageDBDAOSearchUSDeliveryOrderConsigneeRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT B.CUST_CNT_CD ," ).append("\n"); 
		query.append("  B.CUST_SEQ ," ).append("\n"); 
		query.append("  B.CUST_NM ," ).append("\n"); 
		query.append("  SUBSTR( (CASE WHEN I.N1ST_NOD_CD IS NOT NULL" ).append("\n"); 
		query.append("          AND I.N2ND_NOD_CD IS NOT NULL" ).append("\n"); 
		query.append("          AND I.N3RD_NOD_CD IS NOT NULL" ).append("\n"); 
		query.append("          AND I.N4TH_NOD_CD IS NULL THEN N2ND_NOD_CD WHEN I.N1ST_NOD_CD IS NOT NULL" ).append("\n"); 
		query.append("          AND I.N2ND_NOD_CD IS NOT NULL" ).append("\n"); 
		query.append("          AND I.N3RD_NOD_CD IS NOT NULL" ).append("\n"); 
		query.append("          AND I.N4TH_NOD_CD IS NOT NULL THEN N3RD_NOD_CD ELSE '' END), 1, 5) DOR_LOC_CD ," ).append("\n"); 
		query.append("  SUBSTR( (CASE WHEN I.N1ST_NOD_CD IS NOT NULL" ).append("\n"); 
		query.append("          AND I.N2ND_NOD_CD IS NOT NULL" ).append("\n"); 
		query.append("          AND I.N3RD_NOD_CD IS NOT NULL" ).append("\n"); 
		query.append("          AND I.N4TH_NOD_CD IS NULL THEN N2ND_NOD_CD WHEN I.N1ST_NOD_CD IS NOT NULL" ).append("\n"); 
		query.append("          AND I.N2ND_NOD_CD IS NOT NULL" ).append("\n"); 
		query.append("          AND I.N3RD_NOD_CD IS NOT NULL" ).append("\n"); 
		query.append("          AND I.N4TH_NOD_CD IS NOT NULL THEN N3RD_NOD_CD ELSE '' END), 6) ZONE_CD" ).append("\n"); 
		query.append("FROM BKG_BOOKING A," ).append("\n"); 
		query.append("  BKG_CUSTOMER B," ).append("\n"); 
		query.append("  SCE_COP_HDR H," ).append("\n"); 
		query.append("  SCE_PLN_SO_LIST I" ).append("\n"); 
		query.append("WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("  AND B.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("  AND A.BKG_NO = H.BKG_NO" ).append("\n"); 
		query.append("  AND H.COP_NO = I.COP_NO" ).append("\n"); 
		query.append("  AND I.PCTL_IO_BND_CD = 'I'" ).append("\n"); 
		query.append("  AND I.PCTL_COST_MOD_CD = 'Z'" ).append("\n"); 
		query.append("  AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("  AND A.BL_NO IS NOT NULL " ).append("\n"); 
		query.append("  #if(!($blNoArr.size() > 0)&& !($bkgNoArr.size() > 0))" ).append("\n"); 
		query.append("    AND 1 = 2	" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #if($blNoArr.size() > 0) " ).append("\n"); 
		query.append("    AND A.BL_NO IN (" ).append("\n"); 
		query.append("	  #foreach( ${key} in ${blNoArr}) " ).append("\n"); 
		query.append("		#if($velocityCount == 1)" ).append("\n"); 
		query.append(" 			'${key}'" ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append(" 			, '${key}'" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	  #end " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("  #end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #if($bkgNoArr.size() > 0)" ).append("\n"); 
		query.append("  	AND A.BKG_NO IN (" ).append("\n"); 
		query.append("	  #foreach( ${key} in ${bkgNoArr}) " ).append("\n"); 
		query.append("		#if($velocityCount == 1)" ).append("\n"); 
		query.append(" 			'${key}'	" ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append(" 			, '${key}'	" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	  #end " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("  #end" ).append("\n"); 

	}
}