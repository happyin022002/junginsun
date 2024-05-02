/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MonthlyQuotaCreationDBDAOUpdateGuidelineCancelNotifyUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.12 
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

public class MonthlyQuotaCreationDBDAOUpdateGuidelineCancelNotifyUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 버전의 Guidline의 Notification을 Cancel 한다
	  * </pre>
	  */
	public MonthlyQuotaCreationDBDAOUpdateGuidelineCancelNotifyUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaCreationDBDAOUpdateGuidelineCancelNotifyUSQL").append("\n"); 
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
		query.append("UPDATE SAQ_MON_INIT_GLINE " ).append("\n"); 
		query.append("       SET GLINE_STS_FLG = 'C' " ).append("\n"); 
		query.append("     , UPD_USR_ID = @[user_id]  " ).append("\n"); 
		query.append("     , UPD_DT = SYSDATE" ).append("\n"); 
		query.append(" WHERE 1=1 " ).append("\n"); 
		query.append("       AND MQTA_MDL_VER_NO = @[mqta_mdl_ver_no]" ).append("\n"); 
		query.append("       AND GLINE_STS_FLG = 'N'" ).append("\n"); 

	}
}