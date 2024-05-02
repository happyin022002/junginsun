/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableOutstandingDBDAOSearchOutstandingInterfaceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.30
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableOutstandingDBDAOSearchOutstandingInterfaceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Outstanding Interface
	  * </pre>
	  */
	public AccountReceivableOutstandingDBDAOSearchOutstandingInterfaceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration").append("\n"); 
		query.append("FileName : AccountReceivableOutstandingDBDAOSearchOutstandingInterfaceRSQL").append("\n"); 
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
		query.append("SELECT OTS_IF_SEQ" ).append("\n"); 
		query.append("    , IF_NO" ).append("\n"); 
		query.append("    , RHQ_CD" ).append("\n"); 
		query.append("    , AR_OFC_CD" ).append("\n"); 
		query.append("    , BL_NO" ).append("\n"); 
		query.append("    , INV_NO" ).append("\n"); 
		query.append("    , OFC_CURR_CD" ).append("\n"); 
		query.append("    , OTS_SRC_CD" ).append("\n"); 
		query.append("    , BIL_TO_CUST_CNT_CD" ).append("\n"); 
		query.append("    , BIL_TO_CUST_SEQ" ).append("\n"); 
		query.append("    , SHP_TO_CUST_CNT_CD" ).append("\n"); 
		query.append("    , SHP_TO_CUST_SEQ" ).append("\n"); 
		query.append("    , BKG_NO" ).append("\n"); 
		query.append("    , BKG_NO_SPLIT" ).append("\n"); 
		query.append("    , VSL_CD" ).append("\n"); 
		query.append("    , SKD_VOY_NO" ).append("\n"); 
		query.append("    , DIR_CD" ).append("\n"); 
		query.append("    , TRNK_VVD_CD" ).append("\n"); 
		query.append("    , SVC_SCP_CD" ).append("\n"); 
		query.append("    , LANE_CD" ).append("\n"); 
		query.append("    , SAIL_ARR_DT" ).append("\n"); 
		query.append("    , BKG_IO_BND_CD" ).append("\n"); 
		query.append("    , POR_CD" ).append("\n"); 
		query.append("    , POL_CD" ).append("\n"); 
		query.append("    , POD_CD" ).append("\n"); 
		query.append("    , DEL_CD" ).append("\n"); 
		query.append("    , CUST_SREP_CD" ).append("\n"); 
		query.append("    , DUE_DT" ).append("\n"); 
		query.append("    , STL_FLG" ).append("\n"); 
		query.append("    , BKG_REF_NO" ).append("\n"); 
		query.append("    , AP_AR_OFFST_NO" ).append("\n"); 
		query.append("    , CR_MK_FLG" ).append("\n"); 
		query.append("    , XCH_RT_TP_CD" ).append("\n"); 
		query.append("    , LST_INV_NO" ).append("\n"); 
		query.append("    , OTS_GRP_TP_CD" ).append("\n"); 
		query.append("    , OTS_TP_CD" ).append("\n"); 
		query.append("    , OTS_RMK" ).append("\n"); 
		query.append("    , IF_DT" ).append("\n"); 
		query.append("    , INV_DT" ).append("\n"); 
		query.append("    , CLT_OFC_CD" ).append("\n"); 
		query.append("    , OTS_RT_FLG" ).append("\n"); 
		query.append("    , SC_NO" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append("    , TJ_SRC_NM" ).append("\n"); 
		query.append("    , CHG_TP_CD" ).append("\n"); 
		query.append("    , GL_DT" ).append("\n"); 
		query.append("    , BL_CURR_CD" ).append("\n"); 
		query.append("    , OTS_AMT" ).append("\n"); 
		query.append("    , OTS_IF_FLG" ).append("\n"); 
		query.append("    , REV_TP_SRC_CD" ).append("\n"); 
		query.append("	, XCH_RT_N3RD_TP_CD" ).append("\n"); 
		query.append("FROM SAR_OTS_IF" ).append("\n"); 
		query.append("WHERE IF_NO = @[if_no]" ).append("\n"); 
		query.append("AND NVL(OTS_IF_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("ORDER BY OTS_IF_SEQ" ).append("\n"); 

	}
}