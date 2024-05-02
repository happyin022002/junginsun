/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TCharterIOContractDAOSearchIdVslListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.28
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOContractDAOSearchIdVslListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOContractDAOSearchIdVslListRSQL
	  * </pre>
	  */
	public TCharterIOContractDAOSearchIdVslListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.integration").append("\n"); 
		query.append("FileName : TCharterIOContractDAOSearchIdVslListRSQL").append("\n"); 
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
		query.append("SELECT VSL_CD" ).append("\n"); 
		query.append("     , (SELECT VSL_ENG_NM" ).append("\n"); 
		query.append("          FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("         WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("           AND VSL_CD = FI.VSL_CD" ).append("\n"); 
		query.append("           AND ROWNUM = 1) VSL_ENG_NM" ).append("\n"); 
		query.append("     , VSL_CD ORI_VSL_CD" ).append("\n"); 
		query.append("     , (SELECT VSL_ENG_NM" ).append("\n"); 
		query.append("          FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("         WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("           AND VSL_CD = FI.VSL_CD" ).append("\n"); 
		query.append("           AND ROWNUM = 1) ORI_VSL_ENG_NM" ).append("\n"); 
		query.append("     , DECODE(USE_FLG,'Y','1','0') AS USE_FLG" ).append("\n"); 
		query.append("     , DECODE(FLET_RPT_FLG,'Y','1','0') AS FLET_RPT_FLG" ).append("\n"); 
		query.append("  FROM FMS_ID_VSL FI" ).append("\n"); 
		query.append(" WHERE FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append(" ORDER BY CRE_DT" ).append("\n"); 

	}
}