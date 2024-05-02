/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingARCreationDBDAOInvIssDueDtUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.30
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2010.03.30 한동훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author donghoon han
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOInvIssDueDtUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvIssDueDt
	  * </pre>
	  */
	public BookingARCreationDBDAOInvIssDueDtUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wrk_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOInvIssDueDtUSQL").append("\n"); 
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
		query.append("MERGE INTO INV_AR_MN X" ).append("\n"); 
		query.append("USING (SELECT BL_SRC_NO,AR_IF_NO,REV_TP_CD" ).append("\n"); 
		query.append("       ,MAX(CASE WHEN REV_TP_CD <> 'M' THEN DUE_DT END) OVER (PARTITION BY BL_SRC_NO) NEW_DUE_DT" ).append("\n"); 
		query.append("        FROM (SELECT BL_SRC_NO,AR_IF_NO,REV_TP_CD,DUE_DT" ).append("\n"); 
		query.append("                    ,MAX(CASE WHEN REV_TP_CD = 'M' THEN 'Y'  " ).append("\n"); 
		query.append("                              ELSE 'N' " ).append("\n"); 
		query.append("                         END) OVER (PARTITION BY BL_SRC_NO) AA" ).append("\n"); 
		query.append("                    ,MAX(CASE WHEN REV_TP_CD <> 'M' THEN 'Y'  " ).append("\n"); 
		query.append("                              ELSE 'N' " ).append("\n"); 
		query.append("                         END) OVER (PARTITION BY BL_SRC_NO) BB  " ).append("\n"); 
		query.append("                FROM INV_AR_MN A				" ).append("\n"); 
		query.append("               WHERE AR_IF_NO IN (SELECT AR_IF_NO" ).append("\n"); 
		query.append("                                    FROM INV_AR_ISS_FTR A" ).append("\n"); 
		query.append("                                   WHERE INV_ISS_WRK_NO = @[wrk_no]" ).append("\n"); 
		query.append("                                     AND BL_SRC_NO IN (SELECT BL_SRC_NO" ).append("\n"); 
		query.append("                                                         FROM (SELECT BL_SRC_NO,AR_IF_NO " ).append("\n"); 
		query.append("                                                                     ,COUNT(*) OVER (PARTITION BY BL_SRC_NO) CNT " ).append("\n"); 
		query.append("                                                                 FROM (SELECT DISTINCT BL_SRC_NO,AR_IF_NO " ).append("\n"); 
		query.append("                                                                         FROM INV_AR_ISS_FTR   " ).append("\n"); 
		query.append("                                                                        WHERE INV_ISS_WRK_NO =  @[wrk_no]  ) " ).append("\n"); 
		query.append("                                                               )" ).append("\n"); 
		query.append("                                                         WHERE CNT > 1  " ).append("\n"); 
		query.append("                                                        )" ).append("\n"); 
		query.append("                                   )" ).append("\n"); 
		query.append("				#if (${rev_type} != '')" ).append("\n"); 
		query.append("					#if (${rev_type} == 'M')     " ).append("\n"); 
		query.append("   					AND A.REV_TP_CD = 'M'" ).append("\n"); 
		query.append("					#elseif (${rev_type} == 'F')     " ).append("\n"); 
		query.append("   					AND A.REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("       WHERE AA||BB = 'YY') Y   " ).append("\n"); 
		query.append("    ON (    X.AR_IF_NO = Y.AR_IF_NO " ).append("\n"); 
		query.append("         AND X.REV_TP_CD ='M')      " ).append("\n"); 
		query.append("  WHEN MATCHED THEN UPDATE SET X.DUE_DT = Y.NEW_DUE_DT" ).append("\n"); 

	}
}