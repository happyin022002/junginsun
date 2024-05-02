/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustomizedReportSetupDBDAOInsertCustmRptFormCSQL.java
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

public class CustomizedReportSetupDBDAOInsertCustmRptFormCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customized Report Form Setup 정보 등록
	  * </pre>
	  */
	public CustomizedReportSetupDBDAOInsertCustmRptFormCSQL(){
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
		query.append("FileName : CustomizedReportSetupDBDAOInsertCustmRptFormCSQL").append("\n"); 
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
		query.append("INSERT INTO SCE_PG_STUP_MST (EXE_USR_ID" ).append("\n"); 
		query.append(",MOFC_ID" ).append("\n"); 
		query.append(",PGM_NO" ).append("\n"); 
		query.append(",RPT_INFO_CTNT" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT )" ).append("\n"); 
		query.append("VALUES (@[user_id]" ).append("\n"); 
		query.append(",@[user_ofc_cd]" ).append("\n"); 
		query.append(",@[pgm_no]" ).append("\n"); 
		query.append(",@[save_list]" ).append("\n"); 
		query.append(",@[user_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[user_id]" ).append("\n"); 
		query.append(",SYSDATE )" ).append("\n"); 

	}
}