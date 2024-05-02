/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TrsCommonDBDAOTrsComboCustCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.common.trscommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TrsCommonDBDAOTrsComboCustCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Select
	  * </pre>
	  */
	public TrsCommonDBDAOTrsComboCustCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.common.trscommon.integration").append("\n"); 
		query.append("FileName : TrsCommonDBDAOTrsComboCustCodeRSQL").append("\n"); 
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
		query.append("SELECT   'CD99999' AS INTG_CD_ID" ).append("\n"); 
		query.append(",        CUST_CNT_CD AS INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append(",        CUST_CNT_CD AS INTG_CD_VAL_DESC" ).append("\n"); 
		query.append(",        CUST_CNT_CD AS INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append(",        CUST_SEQ AS INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("FROM     MDM_CUSTOMER" ).append("\n"); 
		query.append("WHERE    DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND      CUST_CNT_CD = SUBSTR(@[cust_code], 1, 2)" ).append("\n"); 
		query.append("AND      CUST_SEQ = SUBSTR(@[cust_code], 3)" ).append("\n"); 

	}
}