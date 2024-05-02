/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableCommonDBDAOsearchAgentOfficeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableCommonDBDAOsearchAgentOfficeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 대리점리스트 조회
	  * </pre>
	  */
	public AccountReceivableCommonDBDAOsearchAgentOfficeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration").append("\n"); 
		query.append("FileName : AccountReceivableCommonDBDAOsearchAgentOfficeRSQL").append("\n"); 
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
		query.append("SELECT AGTMO.OFC_CD AGT_OFC_CD" ).append("\n"); 
		query.append("FROM   MDM_ORGANIZATION AGTMO," ).append("\n"); 
		query.append("       SCO_OFC_INFO  SOI" ).append("\n"); 
		query.append("WHERE  AGTMO.OFC_CD = SOI.OFC_CD" ).append("\n"); 
		query.append("AND    SOI.OFC_BRNC_AGN_TP_CD  = 'AGT'" ).append("\n"); 
		query.append("#if (${ofc_entr_lvl_cd} == 'BA' || ${ofc_entr_lvl_cd} == '') " ).append("\n"); 
		query.append("    AND AGTMO.OFC_CD = @[ots_ofc_cd]" ).append("\n"); 
		query.append("#elseif (${ofc_entr_lvl_cd} == 'HO' || ${ofc_entr_lvl_cd} == 'HQ')" ).append("\n"); 
		query.append("    AND EXISTS ( SELECT 'X' " ).append("\n"); 
		query.append("                 FROM   MDM_ORGANIZATION MO " ).append("\n"); 
		query.append("                 WHERE  MO.OFC_CD = @[ots_ofc_cd]" ).append("\n"); 
		query.append("                 AND    MO.AR_HD_QTR_OFC_CD = AGTMO.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("#elseif (${ofc_entr_lvl_cd} == 'ALL')    " ).append("\n"); 
		query.append("    AND 1=1" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    AND 1=2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY AGT_OFC_CD ASC" ).append("\n"); 

	}
}