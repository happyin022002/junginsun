/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CommonDBDAOSearchSimBatchManagementListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.25
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchSimBatchManagementListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Simulation Batch List 정보를 조회한다.
	  * </pre>
	  */
	public CommonDBDAOSearchSimBatchManagementListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_headernm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchSimBatchManagementListRSQL").append("\n"); 
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
		query.append("SELECT BAT_DESC, BKG_NO, BAT_FLG, DECODE(CRE_DT, UPD_DT, NULL, TO_CHAR(UPD_DT,'YYYY-MM-DD HH24:MI:SS')) COMPLETE_DATE" ).append("\n"); 
		query.append(" 	 FROM COA_CALC_BAT" ).append("\n"); 
		query.append(" 	 WHERE 1=1" ).append("\n"); 
		query.append(" 	 AND CALL_FM_SRC_ID = 'EQ REPO'" ).append("\n"); 
		query.append(" 	 AND BAT_DESC = @[f_headernm]" ).append("\n"); 

	}
}