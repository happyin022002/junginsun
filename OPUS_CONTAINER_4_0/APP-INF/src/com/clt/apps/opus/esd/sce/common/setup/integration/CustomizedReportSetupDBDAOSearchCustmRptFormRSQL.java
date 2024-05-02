/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustomizedReportSetupDBDAOSearchCustmRptFormRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.03
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.05.03 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.common.setup.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomizedReportSetupDBDAOSearchCustmRptFormRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customized Report Setup 정보 조회
	  * </pre>
	  */
	public CustomizedReportSetupDBDAOSearchCustmRptFormRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pgm_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.common.setup.integration ").append("\n"); 
		query.append("FileName : CustomizedReportSetupDBDAOSearchCustmRptFormRSQL").append("\n"); 
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
		query.append("SELECT RPT_INFO_CTNT ALL_COL   -- report setup info" ).append("\n"); 
		query.append("FROM  SCE_PG_STUP_MST" ).append("\n"); 
		query.append("WHERE EXE_USR_ID = @[user_id]	-- user id" ).append("\n"); 
		query.append("AND   MOFC_ID    = @[user_ofc_cd]	-- user office" ).append("\n"); 
		query.append("AND   PGM_NO = @[pgm_no]	-- program no." ).append("\n"); 
		query.append("AND   RPT_INFO_CTNT IS NOT NULL" ).append("\n"); 

	}
}