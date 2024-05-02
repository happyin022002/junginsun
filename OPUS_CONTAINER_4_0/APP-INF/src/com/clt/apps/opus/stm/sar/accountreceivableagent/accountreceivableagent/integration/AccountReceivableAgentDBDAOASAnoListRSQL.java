/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableAgentDBDAOASAnoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableAgentDBDAOASAnoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ASA NO
	  * </pre>
	  */
	public AccountReceivableAgentDBDAOASAnoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.integration").append("\n"); 
		query.append("FileName : AccountReceivableAgentDBDAOASAnoListRSQL").append("\n"); 
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
		query.append("SELECT  ASA_NO" ).append("\n"); 
		query.append("      , SUBSTR(ASA_NO,1,3) ASA_NO1" ).append("\n"); 
		query.append("      , SUBSTR(ASA_NO,4,3) ASA_NO2" ).append("\n"); 
		query.append("      , SUBSTR(ASA_NO,7,4) ASA_NO3" ).append("\n"); 
		query.append("      , TO_CHAR(TO_DATE(ASA_PRD_FM_DT,'YYYYMMDD'),'YYYY-MM-DD')  BIL_CRE_PRD_FM_DT" ).append("\n"); 
		query.append("      , TO_CHAR(TO_DATE(ASA_PRD_TO_DT,'YYYYMMDD'),'YYYY-MM-DD')  BIL_CRE_PRD_TO_DT" ).append("\n"); 
		query.append("      , CURR_CD" ).append("\n"); 
		query.append("	  , NVL((SELECT DP_PRCS_KNT FROM MDM_CURRENCY MC WHERE MC.CURR_CD = SAR_ASA_MST.CURR_CD), 0) AS DP_PRCS_KNT" ).append("\n"); 
		query.append("      , '' FLAG_CD" ).append("\n"); 
		query.append("FROM  SAR_ASA_MST  " ).append("\n"); 
		query.append("WHERE OFC_CD =  @[asa_ofc_cd]" ).append("\n"); 
		query.append("AND UPPER(ASA_NO) like UPPER(@[asa_no]) || '%'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${flag_cd} == 'Y'  )" ).append("\n"); 
		query.append("AND 1=1" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND ASA_STS_CD = 'O' " ).append("\n"); 
		query.append("AND ASA_FSH_DT IS NULL" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${flag_cd} == 'Y'  )" ).append("\n"); 
		query.append("ORDER BY ASA_NO DESC" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("ORDER BY ASA_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}