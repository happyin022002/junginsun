/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustomizedReportSetupDBDAOUpdateCustmRptFormUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.06
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.05.06 김인수
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

public class CustomizedReportSetupDBDAOUpdateCustmRptFormUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customized Report Form Setup 정보 수정
	  * </pre>
	  */
	public CustomizedReportSetupDBDAOUpdateCustmRptFormUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("save_list",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : CustomizedReportSetupDBDAOUpdateCustmRptFormUSQL").append("\n"); 
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
		query.append("UPDATE SCE_PG_STUP_MST" ).append("\n"); 
		query.append("SET   RPT_INFO_CTNT = @[save_list]" ).append("\n"); 
		query.append(",UPD_USR_ID = @[user_id]" ).append("\n"); 
		query.append(",UPD_DT     = SYSDATE" ).append("\n"); 
		query.append("WHERE EXE_USR_ID = @[user_id]" ).append("\n"); 
		query.append("AND   MOFC_ID    = @[user_ofc_cd]" ).append("\n"); 
		query.append("AND   PGM_NO	  = @[pgm_no]" ).append("\n"); 

	}
}