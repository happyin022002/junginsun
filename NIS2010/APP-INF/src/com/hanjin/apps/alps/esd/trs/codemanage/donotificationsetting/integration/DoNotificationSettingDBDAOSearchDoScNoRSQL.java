/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DoNotificationSettingDBDAOSearchDoScNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.16
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.donotificationsetting.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DoNotificationSettingDBDAOSearchDoScNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * D/O S/C정보 조회
	  * </pre>
	  */
	public DoNotificationSettingDBDAOSearchDoScNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.codemanage.donotificationsetting.integration").append("\n"); 
		query.append("FileName : DoNotificationSettingDBDAOSearchDoScNoRSQL").append("\n"); 
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
		query.append("SELECT A3.CUST_CNT_CD|| LPAD(A3.CUST_SEQ, 6, 0) CUST_CD" ).append("\n"); 
		query.append("      ,(SELECT X.CUST_LGL_ENG_NM FROM MDM_CUSTOMER X WHERE X.CUST_CNT_CD = A3.CUST_CNT_CD AND X.CUST_SEQ = A3.CUST_SEQ) CUST_NM" ).append("\n"); 
		query.append("      ,TO_CHAR(A4.CTRT_EFF_DT,'YYYYMMDD') EFF_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(A4.CTRT_EXP_DT,'YYYYMMDD') EXP_DT" ).append("\n"); 
		query.append("FROM PRI_SP_HDR A1" ).append("\n"); 
		query.append("    ,PRI_SP_MN A2" ).append("\n"); 
		query.append("    ,PRI_SP_CTRT_PTY A3" ).append("\n"); 
		query.append("    ,PRI_SP_DUR A4" ).append("\n"); 
		query.append("    ,PRI_SP_MQC A5" ).append("\n"); 
		query.append("WHERE A1.SC_NO = @[sc_no]" ).append("\n"); 
		query.append("  AND A1.PROP_NO = A2.PROP_NO" ).append("\n"); 
		query.append("  AND A2.AMDT_SEQ = (SELECT MAX(AMDT_SEQ)" ).append("\n"); 
		query.append("                      FROM PRI_SP_MN" ).append("\n"); 
		query.append("                     WHERE PROP_NO = A1.PROP_NO" ).append("\n"); 
		query.append("                       AND PROP_STS_CD = 'F')" ).append("\n"); 
		query.append("  AND A2.PROP_NO  = A3.PROP_NO" ).append("\n"); 
		query.append("  AND A2.AMDT_SEQ = A3.AMDT_SEQ" ).append("\n"); 
		query.append("  AND A3.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("  AND A2.PROP_NO  = A4.PROP_NO" ).append("\n"); 
		query.append("  AND A2.AMDT_SEQ = A4.AMDT_SEQ" ).append("\n"); 
		query.append("  AND A2.PROP_NO  = A5.PROP_NO" ).append("\n"); 
		query.append("  AND A2.AMDT_SEQ = A5.AMDT_SEQ " ).append("\n"); 

	}
}