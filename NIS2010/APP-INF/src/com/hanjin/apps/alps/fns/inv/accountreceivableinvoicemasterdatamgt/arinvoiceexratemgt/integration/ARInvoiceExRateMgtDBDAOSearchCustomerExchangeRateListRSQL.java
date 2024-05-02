/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ARInvoiceExRateMgtDBDAOSearchCustomerExchangeRateListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceExRateMgtDBDAOSearchCustomerExchangeRateListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 화주별 개별 환율 
	  * FNS_INV_0007
	  * </pre>
	  */
	public ARInvoiceExRateMgtDBDAOSearchCustomerExchangeRateListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration").append("\n"); 
		query.append("FileName : ARInvoiceExRateMgtDBDAOSearchCustomerExchangeRateListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("DISTINCT" ).append("\n"); 
		query.append("	A.CUST_CNT_CD CUST_CNT_CD" ).append("\n"); 
		query.append(", 	LPAD(A.CUST_SEQ, 6, 0) CUST_SEQ   " ).append("\n"); 
		query.append(",	A.IO_BND_CD IO_BND_CD" ).append("\n"); 
		query.append(",	A.FM_DT FM_DT" ).append("\n"); 
		query.append(",	A.TO_DT TO_DT" ).append("\n"); 
		query.append(",	B.CURR_NM CURR_NM" ).append("\n"); 
		query.append(",	A.CHG_CURR_CD CHG_CURR_CD" ).append("\n"); 
		query.append(",	A.LOCL_CURR_CD LOCL_CURR_CD" ).append("\n"); 
		query.append(",	A.XCH_RT_TP_CD XCH_RT_TP_CD" ).append("\n"); 
		query.append(",	A.AR_OFC_CD AR_OFC_CD" ).append("\n"); 
		query.append(",	A.INV_XCH_RT INV_XCH_RT" ).append("\n"); 
		query.append(",	D.XCH_RT_RVS_FLG XCH_RT_RVS_FLG" ).append("\n"); 
		query.append(",	A.IVS_XCH_RT IVS_XCH_RT" ).append("\n"); 
		query.append(",	A.CRE_USR_ID CRE_USR_ID" ).append("\n"); 
		query.append(",	TO_CHAR(A.CRE_DT, 'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append(",	A.UPD_USR_ID UPD_USR_ID" ).append("\n"); 
		query.append(",	TO_CHAR(A.UPD_DT, 'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append("FROM INV_CUST_AND_DLY_XCH_RT a, MDM_CURRENCY B, MDM_ORGANIZATION C , INV_AR_STUP_OFC D" ).append("\n"); 
		query.append("WHERE	A.CHG_CURR_CD = B.CURR_CD	" ).append("\n"); 
		query.append("and A.AR_OFC_CD = C.OFC_CD" ).append("\n"); 
		query.append("and A.AR_OFC_CD = D.AR_OFC_CD" ).append("\n"); 
		query.append("AND A.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("AND	A.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("and A.XCH_RT_TP_CD = 'I'" ).append("\n"); 
		query.append("#if ((${io_bnd_cd} != 'ALL') &&(${io_bnd_cd} != ''))" ).append("\n"); 
		query.append("AND	A.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND REPLACE(@[fm_dt],'-','') BETWEEN SUBSTR(A.FM_DT,1,6) AND SUBSTR(A.TO_DT,1,6) -- DXBSC 때문에 변경 정영한 20100303" ).append("\n"); 
		query.append("#if (${locl_curr_cd} != '')" ).append("\n"); 
		query.append("AND	A.LOCL_CURR_CD = @[locl_curr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("order by A.FM_DT,A.TO_DT,A.IO_BND_CD,A.CHG_CURR_CD" ).append("\n"); 

	}
}