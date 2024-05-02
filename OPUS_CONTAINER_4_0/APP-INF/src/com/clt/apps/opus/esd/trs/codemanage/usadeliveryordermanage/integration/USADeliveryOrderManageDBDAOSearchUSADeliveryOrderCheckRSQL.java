/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : USADeliveryOrderManageDBDAOSearchUSADeliveryOrderCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.27
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.27 
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

public class USADeliveryOrderManageDBDAOSearchUSADeliveryOrderCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchUSADeliveryOrderCheck
	  * </pre>
	  */
	public USADeliveryOrderManageDBDAOSearchUSADeliveryOrderCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.codemanage.usadeliveryordermanage.integration").append("\n"); 
		query.append("FileName : USADeliveryOrderManageDBDAOSearchUSADeliveryOrderCheckRSQL").append("\n"); 
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
		query.append("SELECT TRSP_SO_SEQ" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD A" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("  AND NVL(TRSP_FRST_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("  AND TRSP_COST_DTL_MOD_CD = 'DR'" ).append("\n"); 
		query.append("  AND TRSP_BND_CD = 'I'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #if($blNoArr.size() > 0) " ).append("\n"); 
		query.append("  	AND (" ).append("\n"); 
		query.append("        	A.BKG_NO IN (" ).append("\n"); 
		query.append("            	SELECT BKG_NO" ).append("\n"); 
		query.append("            	FROM BKG_BOOKING X" ).append("\n"); 
		query.append("            	WHERE  X.BL_NO IN ( " ).append("\n"); 
		query.append("		  				#foreach( ${key} in ${blNoArr}) " ).append("\n"); 
		query.append("		    				#if($velocityCount == 1)" ).append("\n"); 
		query.append(" 			  					'${key}'" ).append("\n"); 
		query.append("		    				#else " ).append("\n"); 
		query.append(" 			  					, '${key}'" ).append("\n"); 
		query.append("							#end " ).append("\n"); 
		query.append("						#end " ).append("\n"); 
		query.append("           		) " ).append("\n"); 
		query.append("         	) " ).append("\n"); 
		query.append("      	)" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #if($bkgNoArr.size() > 0) " ).append("\n"); 
		query.append("	AND A.BKG_NO IN ( " ).append("\n"); 
		query.append("		#foreach( ${key} in ${bkgNoArr}) " ).append("\n"); 
		query.append("			#if($velocityCount == 1)" ).append("\n"); 
		query.append("				'${key}'	" ).append("\n"); 
		query.append("			#else " ).append("\n"); 
		query.append("				, '${key}'" ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("  		#end " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #if(!($blNoArr.size() > 0) && !($bkgNoArr.size()>0)) " ).append("\n"); 
		query.append("	AND 1 = 2	" ).append("\n"); 
		query.append("  #end" ).append("\n"); 

	}
}