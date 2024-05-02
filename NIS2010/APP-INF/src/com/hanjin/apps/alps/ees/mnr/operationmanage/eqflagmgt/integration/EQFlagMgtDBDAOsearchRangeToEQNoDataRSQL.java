/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EQFlagMgtDBDAOsearchRangeToEQNoDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.11
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.11.05 박명신
* 1.0 Creation
* --------------------------------------------------------
* History
* 2012.05.11 신혜정 [CHM-201217835] [Save] 처리시 EQ Range 범위의 EQ no(Cntr no) select 방식 변경
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author park myoung sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQFlagMgtDBDAOsearchRangeToEQNoDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchRangeToEQNoData
	  * </pre>
	  */
	public EQFlagMgtDBDAOsearchRangeToEQNoDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_prefix",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_to_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("retire_flag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flag_user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sts_flag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flag_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flag_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_fr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.integration").append("\n"); 
		query.append("FileName : EQFlagMgtDBDAOsearchRangeToEQNoDataRSQL").append("\n"); 
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
		query.append("SELECT  CNTR_NO AS EQ_NO," ).append("\n"); 
		query.append("    	'U' AS EQ_KIND_CD," ).append("\n"); 
		query.append("     	@[flag_ofc_cd] AS FLAG_OFC_CD," ).append("\n"); 
		query.append("     	@[flag_user_id] AS FLAG_USER_ID," ).append("\n"); 
		query.append("     	@[flag_type] AS FLAG_TYPE," ).append("\n"); 
		query.append("     	@[retire_flag] AS RETIRE_FLAG," ).append("\n"); 
		query.append("     	@[sts_flag] AS STS_FLAG, " ).append("\n"); 
		query.append("     TO_CHAR(SYSDATE, 'YYYY-MM-DD') AS FLAG_DT" ).append("\n"); 
		query.append("FROM MST_CONTAINER" ).append("\n"); 
		query.append("WHERE CNTR_NO BETWEEN @[eq_prefix]||@[eq_fr_no] AND @[eq_prefix]||@[eq_to_no]||'9'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 	EQ_NO AS EQ_NO," ).append("\n"); 
		query.append("       	EQ_KND_CD AS EQ_KIND_CD," ).append("\n"); 
		query.append("       	@[flag_ofc_cd] AS FLAG_OFC_CD," ).append("\n"); 
		query.append("       	@[flag_user_id] AS FLAG_USER_ID," ).append("\n"); 
		query.append("       	@[flag_type] AS FLAG_TYPE," ).append("\n"); 
		query.append("       	@[retire_flag] AS RETIRE_FLAG," ).append("\n"); 
		query.append("       	@[sts_flag] AS STS_FLAG, " ).append("\n"); 
		query.append("       	TO_CHAR(SYSDATE, 'YYYY-MM-DD') AS FLAG_DT" ).append("\n"); 
		query.append("FROM CGM_EQUIPMENT" ).append("\n"); 
		query.append("WHERE EQ_NO BETWEEN @[eq_prefix]||@[eq_fr_no] AND @[eq_prefix]||@[eq_to_no]||'9'" ).append("\n"); 

	}
}