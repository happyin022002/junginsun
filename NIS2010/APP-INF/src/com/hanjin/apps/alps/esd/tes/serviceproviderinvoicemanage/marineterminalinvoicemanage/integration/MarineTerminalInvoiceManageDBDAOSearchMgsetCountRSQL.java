/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOSearchMgsetCountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.21
*@LastModifier : 이 용 호
*@LastVersion : 1.0
* 2014.11.21 이 용 호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOng hO lEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalInvoiceManageDBDAOSearchMgsetCountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchMgsetCount
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOSearchMgsetCountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAOSearchMgsetCountRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) CNT " ).append("\n"); 
		query.append("FROM TES_TML_SO_DTL TD, TES_MGST_FUEL_CHG TC" ).append("\n"); 
		query.append("WHERE   TD.tml_so_ofc_cty_cd    = TC.tml_so_ofc_cty_cd" ).append("\n"); 
		query.append("AND     TD.tml_so_seq           = TC.tml_so_seq" ).append("\n"); 
		query.append("AND     TD.tml_so_dtl_seq       = TC.tml_so_dtl_seq" ).append("\n"); 
		query.append("AND     TD.lgs_cost_cd          IN ('TMRFGO', 'TMRFGR')" ).append("\n"); 
		query.append("AND     TD.tml_so_ofc_cty_cd	= @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND     TD.tml_so_seq			= @[tml_so_seq]" ).append("\n"); 
		query.append("AND		TD.tml_so_dtl_seq		= @[tml_so_dtl_seq]" ).append("\n"); 

	}
}