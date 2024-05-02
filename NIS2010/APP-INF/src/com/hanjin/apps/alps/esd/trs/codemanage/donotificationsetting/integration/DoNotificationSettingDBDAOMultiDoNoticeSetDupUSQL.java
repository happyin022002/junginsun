/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DoNotificationSettingDBDAOMultiDoNoticeSetDupUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.donotificationsetting.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DoNotificationSettingDBDAOMultiDoNoticeSetDupUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * D/O Notification Setting Duplication update
	  * </pre>
	  */
	public DoNotificationSettingDBDAOMultiDoNoticeSetDupUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_nod_yd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.codemanage.donotificationsetting.integration ").append("\n"); 
		query.append("FileName : DoNotificationSettingDBDAOMultiDoNoticeSetDupUSQL").append("\n"); 
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
		query.append("UPDATE TRS_DO_NTFC_SET A SET DELT_FLG = 'N' " ).append("\n"); 
		query.append(" WHERE A.SC_NO = @[sc_no]" ).append("\n"); 
		query.append("   AND A.BKG_CTRT_DIV_CD = @[ctrt_tp_cd]" ).append("\n"); 
		query.append("   AND A.CTRT_CUST_CNT_CD = SUBSTR(@[ctrt_cust_cd],1,2)" ).append("\n"); 
		query.append("   AND A.CTRT_CUST_SEQ  = SUBSTR(@[ctrt_cust_cd],3)" ).append("\n"); 
		query.append("   AND A.DEST_NOD_CD = @[dest_nod_cd]||@[dest_nod_yd]" ).append("\n"); 

	}
}