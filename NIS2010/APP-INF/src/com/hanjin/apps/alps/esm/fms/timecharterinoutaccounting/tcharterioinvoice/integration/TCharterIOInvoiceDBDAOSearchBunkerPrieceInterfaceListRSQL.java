/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOInvoiceDBDAOSearchBunkerPrieceInterfaceListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.07
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.08.07 정윤태
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JUNGYOONTAE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOInvoiceDBDAOSearchBunkerPrieceInterfaceListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOInvoiceDBDAOSearchBunkerPrieceInterfaceListRSQL
	  * </pre>
	  */
	public TCharterIOInvoiceDBDAOSearchBunkerPrieceInterfaceListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDBDAOSearchBunkerPrieceInterfaceListRSQL").append("\n"); 
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
		query.append("SELECT EVNT_DT," ).append("\n"); 
		query.append("PORT_CD," ).append("\n"); 
		query.append("TO_CHAR(FOIL_ACT_PRC,'FM999,999,999,999,999,999.00') FOIL_ACT_PRC," ).append("\n"); 
		query.append("TO_CHAR(DOIL_ACT_PRC,'FM999,999,999,999,999,999.00') DOIL_ACT_PRC" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT TO_CHAR(EVNT_DT,'YYYYMMDD') EVNT_DT," ).append("\n"); 
		query.append("PORT_CD," ).append("\n"); 
		query.append("DECODE(FOIL_DOIL_DIV_CD,'F',ACT_PRC,0) FOIL_ACT_PRC," ).append("\n"); 
		query.append("DECODE(FOIL_DOIL_DIV_CD,'D',ACT_PRC,0) DOIL_ACT_PRC" ).append("\n"); 
		query.append("FROM VSK_BNK_PRC" ).append("\n"); 
		query.append("WHERE PORT_CD = @[loc_cd]" ).append("\n"); 
		query.append("AND EVNT_DT BETWEEN TO_DATE (@[from_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("AND TO_DATE (@[to_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append(") ORDER BY EVNT_DT" ).append("\n"); 

	}
}