/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SalesRPTDBDAOSearchSetForm059List2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SalesRPTDBDAOSearchSetForm059List2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchSetForm059List2 SELECT
	  * </pre>
	  */
	public SalesRPTDBDAOSearchSetForm059List2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slct_itm_fom_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.integration").append("\n"); 
		query.append("FileName : SalesRPTDBDAOSearchSetForm059List2RSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("      LPAD(MST.SLCT_ITM_FOM_SEQ, 3, '0')    AS SLCT_ITM_FOM_SEQ" ).append("\n"); 
		query.append("    , MST.SLCT_ITM_FOM_DESC                 AS SLCT_ITM_FOM_DESC" ).append("\n"); 
		query.append("    , DTL.MAS_RPT_ITM_CD                    AS RPT_ITM_CD" ).append("\n"); 
		query.append("    , DTL.RPT_ITM_COL_NM                    AS RPT_ITM_COL_NM" ).append("\n"); 
		query.append("    , CASE WHEN INSTR(RPT_ITM_DESC, '$$') != '0' THEN regexp_substr(RPT_ITM_DESC, '[^$$]+', 4)" ).append("\n"); 
		query.append("      ELSE RPT_ITM_DESC END AS RPT_ITM_DESC" ).append("\n"); 
		query.append("    , CASE WHEN INSTR(RPT_ITM_DESC, '$$') != '0' THEN TO_NUMBER(regexp_substr(RPT_ITM_DESC, '[^$$]+', 1))" ).append("\n"); 
		query.append("      ELSE ROWNUM END SEQ" ).append("\n"); 
		query.append("   FROM MAS_RPT_ITM_INFO_MST MST" ).append("\n"); 
		query.append("      , MAS_RPT_ITM_INFO_DTL DTL" ).append("\n"); 
		query.append("   WHERE MST.CRE_USR_ID         = DTL.CRE_USR_ID(+)" ).append("\n"); 
		query.append("     AND MST.SLCT_ITM_FOM_SEQ   = DTL.SLCT_ITM_FOM_SEQ(+)" ).append("\n"); 
		query.append("     AND MST.CRE_USR_ID         = @[cre_usr_id]" ).append("\n"); 
		query.append("     AND MST.SLCT_ITM_FOM_SEQ   = @[slct_itm_fom_seq]" ).append("\n"); 
		query.append("   ORDER BY SEQ" ).append("\n"); 

	}
}