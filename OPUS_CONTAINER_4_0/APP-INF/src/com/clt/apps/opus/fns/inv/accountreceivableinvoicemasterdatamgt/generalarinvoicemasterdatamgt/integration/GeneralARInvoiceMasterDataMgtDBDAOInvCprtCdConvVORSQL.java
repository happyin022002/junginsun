/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GeneralARInvoiceMasterDataMgtDBDAOInvCprtCdConvVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralARInvoiceMasterDataMgtDBDAOInvCprtCdConvVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public GeneralARInvoiceMasterDataMgtDBDAOInvCprtCdConvVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cprt_conv_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.integration").append("\n"); 
		query.append("FileName : GeneralARInvoiceMasterDataMgtDBDAOInvCprtCdConvVORSQL").append("\n"); 
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
		query.append("SELECT 	A.SC_NO" ).append("\n"); 
		query.append("	,	A.RFA_NO" ).append("\n"); 
		query.append("	,	A.CPRT_CONV_TP_CD" ).append("\n"); 
		query.append("	,	A.CO_CD_CTNT" ).append("\n"); 
		query.append("	,	A.CUST_CONV_CD_CTNT" ).append("\n"); 
		query.append("	,	A.CD_RMK" ).append("\n"); 
		query.append("	,	A.CRE_USR_ID" ).append("\n"); 
		query.append("	,	A.CRE_DT" ).append("\n"); 
		query.append("	,	A.UPD_USR_ID" ).append("\n"); 
		query.append("	,	A.UPD_DT" ).append("\n"); 
		query.append("FROM	INV_CPRT_CD_CONV A" ).append("\n"); 
		query.append("WHERE	1=1" ).append("\n"); 
		query.append("#if (${sc_no} != '' || ${sc_no} != 'X')" ).append("\n"); 
		query.append("AND		A.SC_NO = @[sc_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rfa_no} != '' || ${rfa_no} != 'X')" ).append("\n"); 
		query.append("AND		A.RFA_NO = @[rfa_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cprt_conv_tp_cd} != '')" ).append("\n"); 
		query.append("AND		A.CPRT_CONV_TP_CD = @[cprt_conv_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}