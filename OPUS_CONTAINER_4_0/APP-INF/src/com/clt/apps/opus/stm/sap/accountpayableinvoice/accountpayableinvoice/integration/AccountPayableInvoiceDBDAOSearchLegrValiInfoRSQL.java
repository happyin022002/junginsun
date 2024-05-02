/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchLegrValiInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.04
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableInvoiceDBDAOSearchLegrValiInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchLegrValiInfo
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchLegrValiInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("value0",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("value5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("value6",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("value3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("value4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("value1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("value2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOSearchLegrValiInfoRSQL").append("\n"); 
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
		query.append("        SLCC.CD_CMB_SEQ        AS VALUE0 " ).append("\n"); 
		query.append("      , SLCC.SGM_CTNT1         AS VALUE1     -- COMPANY_CODE" ).append("\n"); 
		query.append("      , SLCC.SGM_CTNT2         AS VALUE2     --REGION_CODE" ).append("\n"); 
		query.append("      , SLCC.SGM_CTNT3         AS VALUE3     --CENTER_CODE" ).append("\n"); 
		query.append("      , SLCC.SGM_CTNT4         AS VALUE4     --ACCOUNT_CODE" ).append("\n"); 
		query.append("      , SLCC.SGM_CTNT5         AS VALUE5     --INTERCOMPANY_CODE" ).append("\n"); 
		query.append("      , SLCC.SGM_CTNT6         AS VALUE6     --VVD_CODE" ).append("\n"); 
		query.append("FROM SCO_LEGR_CD_CMB SLCC" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND ENBL_FLG = 'Y'" ).append("\n"); 
		query.append("#if (${value0} != '') " ).append("\n"); 
		query.append("AND CD_CMG_SEQ = @[value0]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${value1} != '') " ).append("\n"); 
		query.append("AND SGM_CTNT1   = @[value1]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${value2} != '') " ).append("\n"); 
		query.append("AND SGM_CTNT2   = @[value2]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${value3} != '') " ).append("\n"); 
		query.append("AND SGM_CTNT3   = @[value3]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${value4} != '') " ).append("\n"); 
		query.append("AND SGM_CTNT4   = @[value4]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${value5} != '') " ).append("\n"); 
		query.append("AND SGM_CTNT5   = @[value5]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${value6} != '') " ).append("\n"); 
		query.append("AND SGM_CTNT6   = @[value6]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}