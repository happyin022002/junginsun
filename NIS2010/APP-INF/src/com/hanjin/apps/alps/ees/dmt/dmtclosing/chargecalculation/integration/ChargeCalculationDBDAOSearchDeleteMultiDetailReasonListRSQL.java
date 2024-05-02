/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChargeCalculationDBDAOSearchDeleteMultiDetailReasonListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOSearchDeleteMultiDetailReasonListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationDBDAOSearchDeleteMultiDetailReasonListRSQL
	  * </pre>
	  */
	public ChargeCalculationDBDAOSearchDeleteMultiDetailReasonListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spec_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOSearchDeleteMultiDetailReasonListRSQL").append("\n"); 
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
		query.append("select  ATTR_CTNT1              as SPEC_RSN_CD" ).append("\n"); 
		query.append("       ,ATTR_CTNT2              as SPEC_RSN_FIELD_LEVEL" ).append("\n"); 
		query.append("       ,ATTR_CTNT3              as SPEC_RSN_FIELD_NAME" ).append("\n"); 
		query.append("       ,ATTR_CTNT4              as SPEC_RSN_FIELD_TYPE" ).append("\n"); 
		query.append("       ,ATTR_CTNT5              as SPEC_RSN_FIELD_SIZE" ).append("\n"); 
		query.append("       ,ATTR_CTNT6              as SPEC_RSN_FIELD_FORMAT" ).append("\n"); 
		query.append("       ,ATTR_CTNT7              as SPEC_RSN_FIELD_ITEM" ).append("\n"); 
		query.append("       ,ATTR_CTNT8              as SPEC_RSN_FIELD_COND" ).append("\n"); 
		query.append("       ,ATTR_CTNT9              as SPEC_RSN_FIELD_POPUP" ).append("\n"); 
		query.append("       ,ATTR_CTNT10             as SPEC_RSN_FIELD_VALUE" ).append("\n"); 
		query.append("  from  DMT_HRD_CDG_CTNT " ).append("\n"); 
		query.append(" where  HRD_CDG_ID   = 'CHG_DELT_SPEC_RSN_CD'" ).append("\n"); 
		query.append("   and  ATTR_CTNT1   = @[spec_rsn_cd]" ).append("\n"); 
		query.append("order by ATTR_CTNT2" ).append("\n"); 

	}
}