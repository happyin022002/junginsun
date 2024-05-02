/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CntrPlanGuidelineEmailDBDAORemoveGuidelineEmailListDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.07
*@LastModifier : 
*@LastVersion : 1.0
* 2014.01.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanguidelineemail.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrPlanGuidelineEmailDBDAORemoveGuidelineEmailListDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_CTRL_GLINE_EML_RCPT 에서 guideline email 수신자 정보를 삭제.
	  * </pre>
	  */
	public CntrPlanGuidelineEmailDBDAORemoveGuidelineEmailListDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_rcpt_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanguidelineemail.integration ").append("\n"); 
		query.append("FileName : CntrPlanGuidelineEmailDBDAORemoveGuidelineEmailListDSQL").append("\n"); 
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
		query.append("DELETE FROM EQR_CTRL_GLINE_EML_RCPT" ).append("\n"); 
		query.append("WHERE GLINE_RCPT_USR_ID = @[gline_rcpt_usr_id]" ).append("\n"); 

	}
}