/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SalesRPTDBDAOSearchSetForm059List2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.10.14 김기대
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki Dae
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
		query.append("Path : com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.integration").append("\n"); 
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
		query.append("LPAD(MST.SLCT_ITM_FOM_SEQ, 3, '0')    AS SLCT_ITM_FOM_SEQ" ).append("\n"); 
		query.append(", MST.SLCT_ITM_FOM_DESC                 AS SLCT_ITM_FOM_DESC" ).append("\n"); 
		query.append(", DTL.COA_RPT_ITM_CD                    AS RPT_ITM_CD" ).append("\n"); 
		query.append(", DTL.RPT_ITM_COL_NM                    AS RPT_ITM_COL_NM" ).append("\n"); 
		query.append(", DTL.RPT_ITM_DESC                      AS RPT_ITM_DESC" ).append("\n"); 
		query.append("FROM COA_RPT_ITM_INFO_MST MST" ).append("\n"); 
		query.append(", COA_RPT_ITM_INFO_DTL DTL" ).append("\n"); 
		query.append("WHERE MST.CRE_USR_ID         = DTL.CRE_USR_ID(+)" ).append("\n"); 
		query.append("AND MST.SLCT_ITM_FOM_SEQ   = DTL.SLCT_ITM_FOM_SEQ(+)" ).append("\n"); 
		query.append("AND MST.CRE_USR_ID         = @[cre_usr_id]" ).append("\n"); 
		query.append("AND MST.SLCT_ITM_FOM_SEQ   = @[slct_itm_fom_seq]" ).append("\n"); 

	}
}