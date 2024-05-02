/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountPayableCommonDBDAOSearchGLDateAPPeriodCheckByInvNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableCommonDBDAOSearchGLDateAPPeriodCheckByInvNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchGLDateAPPeriodCheckByInvNo
	  * </pre>
	  */
	public AccountPayableCommonDBDAOSearchGLDateAPPeriodCheckByInvNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration ").append("\n"); 
		query.append("FileName : AccountPayableCommonDBDAOSearchGLDateAPPeriodCheckByInvNoRSQL").append("\n"); 
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
		query.append("SELECT  SP.PRD_STS_CD AS CHK_PRD" ).append("\n"); 
		query.append("FROM    SCO_PERIOD SP" ).append("\n"); 
		query.append("WHERE   SP.EFF_YRMON = ( SELECT SUBSTR(REPLACE(H.GL_DT,'-'),0,6) FROM SAP_INV_HDR H WHERE INV_NO = @[inv_no] AND ROWNUM=1 )  " ).append("\n"); 
		query.append("AND     SP.PRD_APPL_CD = 'AP'" ).append("\n"); 

	}
}