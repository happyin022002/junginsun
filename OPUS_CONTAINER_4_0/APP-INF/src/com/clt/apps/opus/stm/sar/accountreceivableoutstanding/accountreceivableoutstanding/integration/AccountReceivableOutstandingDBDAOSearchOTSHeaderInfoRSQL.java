/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableOutstandingDBDAOSearchOTSHeaderInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.02 
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

public class AccountReceivableOutstandingDBDAOSearchOTSHeaderInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search OTS Header Info
	  * </pre>
	  */
	public AccountReceivableOutstandingDBDAOSearchOTSHeaderInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration").append("\n"); 
		query.append("FileName : AccountReceivableOutstandingDBDAOSearchOTSHeaderInfoRSQL").append("\n"); 
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
		query.append("SELECT RHQ_CD" ).append("\n"); 
		query.append("       , OTS_OFC_CD" ).append("\n"); 
		query.append("       , BL_NO" ).append("\n"); 
		query.append("       , INV_NO" ).append("\n"); 
		query.append("       , OFC_CURR_CD" ).append("\n"); 
		query.append("       , OTS_SRC_CD" ).append("\n"); 
		query.append("       , BIL_TO_CUST_CNT_CD" ).append("\n"); 
		query.append("       , BIL_TO_CUST_SEQ" ).append("\n"); 
		query.append("       , BKG_NO" ).append("\n"); 
		query.append("       , VSL_CD" ).append("\n"); 
		query.append("       , SKD_VOY_NO" ).append("\n"); 
		query.append("       , DIR_CD" ).append("\n"); 
		query.append("       , TRNK_VVD_CD" ).append("\n"); 
		query.append("       , SVC_SCP_CD" ).append("\n"); 
		query.append("       , LANE_CD" ).append("\n"); 
		query.append("       , SAIL_ARR_DT" ).append("\n"); 
		query.append("       , BKG_IO_BND_CD" ).append("\n"); 
		query.append("       , POR_CD" ).append("\n"); 
		query.append("       , POL_CD" ).append("\n"); 
		query.append("       , POD_CD" ).append("\n"); 
		query.append("       , DEL_CD" ).append("\n"); 
		query.append("       , CUST_SREP_CD" ).append("\n"); 
		query.append("       , DUE_DT" ).append("\n"); 
		query.append("       , BKG_REF_NO" ).append("\n"); 
		query.append("       , AP_AR_OFFST_NO" ).append("\n"); 
		query.append("       , CR_MK_FLG" ).append("\n"); 
		query.append("       , XCH_RT_TP_CD" ).append("\n"); 
		query.append("       , INV_DT" ).append("\n"); 
		query.append("       , CLT_OFC_CD" ).append("\n"); 
		query.append("       , SC_NO" ).append("\n"); 
		query.append("       , REV_TP_SRC_CD" ).append("\n"); 
		query.append("	   , SHP_TO_CUST_CNT_CD" ).append("\n"); 
		query.append("	   , SHP_TO_CUST_SEQ" ).append("\n"); 
		query.append("       , XCH_RT_N3RD_TP_CD" ).append("\n"); 
		query.append(" 	   , XCH_RT_DT" ).append("\n"); 
		query.append("	   , MAX_AR_IF_NO" ).append("\n"); 
		query.append("	   , SAIL_DT" ).append("\n"); 
		query.append("	   , CRE_USR_ID" ).append("\n"); 
		query.append("	   , (SELECT UPD_USR_ID FROM INV_AR_MN WHERE AR_IF_NO = @[if_no]) UPD_USR_ID" ).append("\n"); 
		query.append("	   , INV_CURR_CD" ).append("\n"); 
		query.append("	   , (SELECT INV_OFC_CD " ).append("\n"); 
		query.append("   		  FROM SAR_OTS_HIS " ).append("\n"); 
		query.append("   		  WHERE IF_NO = MAX_AR_IF_NO||'1' " ).append("\n"); 
		query.append("   		  AND OTS_HIS_TP_CD = 'OTS') AR_OFC_CD" ).append("\n"); 
		query.append("FROM SAR_OTS_HDR" ).append("\n"); 
		query.append("WHERE RHQ_CD = @[rhq_cd]" ).append("\n"); 
		query.append("AND OTS_OFC_CD = @[ots_ofc_cd]" ).append("\n"); 
		query.append("AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("AND INV_NO = @[inv_no]" ).append("\n"); 

	}
}