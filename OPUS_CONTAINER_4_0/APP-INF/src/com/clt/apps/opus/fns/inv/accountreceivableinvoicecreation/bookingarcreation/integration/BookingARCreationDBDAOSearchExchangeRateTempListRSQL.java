/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BookingARCreationDBDAOSearchExchangeRateTempListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.02
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOSearchExchangeRateTempListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SELECT INV_XCH_RT_TMP
	  * </pre>
	  */
	public BookingARCreationDBDAOSearchExchangeRateTempListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xch_rt_tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOSearchExchangeRateTempListRSQL").append("\n"); 
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
		query.append("	 XCH_RT_TMP_SEQ" ).append("\n"); 
		query.append("	,VSL_CD" ).append("\n"); 
		query.append("	,SKD_VOY_NO" ).append("\n"); 
		query.append("	,SKD_DIR_CD" ).append("\n"); 
		query.append("	,PORT_CD" ).append("\n"); 
		query.append("	,SVC_SCP_CD" ).append("\n"); 
		query.append("	,IO_BND_CD" ).append("\n"); 
		query.append("	,LOCL_CURR_CD" ).append("\n"); 
		query.append("	,CHG_CURR_CD" ).append("\n"); 
		query.append("	,AR_OFC_CD" ).append("\n"); 
		query.append("	,INV_XCH_RT" ).append("\n"); 
		query.append("	,IVS_XCH_RT" ).append("\n"); 
		query.append("	,XCH_RT_DT" ).append("\n"); 
		query.append("	,CUST_CNT_CD    " ).append("\n"); 
		query.append("	,CUST_SEQ        " ).append("\n"); 
		query.append("	,FM_DT           " ).append("\n"); 
		query.append("	,TO_DT           " ).append("\n"); 
		query.append("	,XCH_RT_TP_CD " ).append("\n"); 
		query.append("    ,'I' AS IBFLAG" ).append("\n"); 
		query.append("	,CRE_USR_ID USR_ID" ).append("\n"); 
		query.append("	,DECODE(XCH_RT_TP_CD, 'V', VSL_CD||SKD_VOY_NO||SKD_DIR_CD||PORT_CD||SVC_SCP_CD||IO_BND_CD||AR_OFC_CD," ).append("\n"); 
		query.append("                          'D', IO_BND_CD||AR_OFC_CD||FM_DT||TO_DT," ).append("\n"); 
		query.append("                          'I', IO_BND_CD||AR_OFC_CD||CUST_CNT_CD||CUST_SEQ||FM_DT||TO_DT) XCH_KEY_CD" ).append("\n"); 
		query.append("FROM INV_XCH_RT_TMP" ).append("\n"); 
		query.append("WHERE 1 = 1 " ).append("\n"); 
		query.append("#if (${xch_rt_tmp_seq} != 'BAT')" ).append("\n"); 
		query.append("	AND XCH_RT_TMP_SEQ = @[xch_rt_tmp_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	AND XCH_RT_TMP_SEQ = (SELECT MIN(XCH_RT_TMP_SEQ)" ).append("\n"); 
		query.append("                          FROM INV_XCH_RT_TMP" ).append("\n"); 
		query.append("						  WHERE CRE_DT < SYSDATE - 0.00347)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY DECODE(XCH_RT_TP_CD, 'V', VSL_CD||SKD_VOY_NO||SKD_DIR_CD||PORT_CD||SVC_SCP_CD||IO_BND_CD||AR_OFC_CD," ).append("\n"); 
		query.append("                              'D', IO_BND_CD||AR_OFC_CD||FM_DT||TO_DT," ).append("\n"); 
		query.append("                              'I', IO_BND_CD||AR_OFC_CD||CUST_CNT_CD||CUST_SEQ||FM_DT||TO_DT)" ).append("\n"); 

	}
}