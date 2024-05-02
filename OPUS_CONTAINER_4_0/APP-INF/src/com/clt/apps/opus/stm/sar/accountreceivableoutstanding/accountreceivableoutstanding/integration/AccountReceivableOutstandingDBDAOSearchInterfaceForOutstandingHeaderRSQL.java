/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableOutstandingDBDAOSearchInterfaceForOutstandingHeaderRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.14 
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

public class AccountReceivableOutstandingDBDAOSearchInterfaceForOutstandingHeaderRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search interface info for Outstanding Header
	  * </pre>
	  */
	public AccountReceivableOutstandingDBDAOSearchInterfaceForOutstandingHeaderRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_if_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration").append("\n"); 
		query.append("FileName : AccountReceivableOutstandingDBDAOSearchInterfaceForOutstandingHeaderRSQL").append("\n"); 
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
		query.append("SELECT A.RHQ_CD" ).append("\n"); 
		query.append("	, DECODE(NVL(B.OTS_CD, 'ARO'), 'COU', B.REP_OTS_OFC_CD, A.AR_OFC_CD) OTS_OFC_CD" ).append("\n"); 
		query.append("    , A.BL_NO" ).append("\n"); 
		query.append("	, DECODE(B.OTS_CATE_CD, 'INV', NVL(A.INV_NO, '**********'), '**********') INV_NO" ).append("\n"); 
		query.append("    , A.OFC_CURR_CD" ).append("\n"); 
		query.append("    , A.OTS_SRC_CD" ).append("\n"); 
		query.append("    , A.BIL_TO_CUST_CNT_CD" ).append("\n"); 
		query.append("    , A.BIL_TO_CUST_SEQ" ).append("\n"); 
		query.append("    , A.BKG_NO" ).append("\n"); 
		query.append("    , A.BKG_NO_SPLIT" ).append("\n"); 
		query.append("    , A.VSL_CD" ).append("\n"); 
		query.append("    , A.SKD_VOY_NO" ).append("\n"); 
		query.append("    , A.DIR_CD" ).append("\n"); 
		query.append("    , A.TRNK_VVD_CD" ).append("\n"); 
		query.append("    , A.SVC_SCP_CD" ).append("\n"); 
		query.append("    , A.LANE_CD" ).append("\n"); 
		query.append("    , A.SAIL_ARR_DT" ).append("\n"); 
		query.append("    , A.BKG_IO_BND_CD" ).append("\n"); 
		query.append("    , A.POR_CD" ).append("\n"); 
		query.append("    , A.POL_CD" ).append("\n"); 
		query.append("    , A.POD_CD" ).append("\n"); 
		query.append("    , A.DEL_CD" ).append("\n"); 
		query.append("    , A.CUST_SREP_CD" ).append("\n"); 
		query.append("    , A.DUE_DT" ).append("\n"); 
		query.append("    , A.STL_FLG" ).append("\n"); 
		query.append("    , A.BKG_REF_NO" ).append("\n"); 
		query.append("    , A.AP_AR_OFFST_NO" ).append("\n"); 
		query.append("    , A.CR_MK_FLG" ).append("\n"); 
		query.append("    , A.XCH_RT_TP_CD" ).append("\n"); 
		query.append("    , A.LST_INV_NO" ).append("\n"); 
		query.append("    , A.OTS_GRP_TP_CD" ).append("\n"); 
		query.append("    , A.OTS_TP_CD" ).append("\n"); 
		query.append("    , A.OTS_RMK" ).append("\n"); 
		query.append("    , A.IF_DT" ).append("\n"); 
		query.append("    , A.INV_DT" ).append("\n"); 
		query.append("    , A.CLT_OFC_CD" ).append("\n"); 
		query.append("    , A.OTS_RT_FLG" ).append("\n"); 
		query.append("    , A.SC_NO" ).append("\n"); 
		query.append("	, A.REV_TP_SRC_CD" ).append("\n"); 
		query.append("	, A.SHP_TO_CUST_CNT_CD" ).append("\n"); 
		query.append("    , A.SHP_TO_CUST_SEQ" ).append("\n"); 
		query.append("	, A.XCH_RT_N3RD_TP_CD" ).append("\n"); 
		query.append("	, A.GL_DT XCH_RT_DT" ).append("\n"); 
		query.append("	, A.IF_NO MAX_AR_IF_NO " ).append("\n"); 
		query.append("	, A.CRE_USR_ID" ).append("\n"); 
		query.append("	, A.UPD_USR_ID" ).append("\n"); 
		query.append("	, A.SAIL_ARR_DT SAIL_DT" ).append("\n"); 
		query.append("	, '' INV_CURR_CD" ).append("\n"); 
		query.append("	, '' INV_LOCL_XCH_RT" ).append("\n"); 
		query.append("	, '' INV_USD_XCH_RT" ).append("\n"); 
		query.append("FROM SAR_OTS_IF A," ).append("\n"); 
		query.append("	 SCO_OFC_INFO B" ).append("\n"); 
		query.append("WHERE A.AR_OFC_CD = B.OFC_CD(+)" ).append("\n"); 
		query.append("AND A.OTS_IF_SEQ = @[ots_if_seq]" ).append("\n"); 

	}
}