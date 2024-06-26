/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableOutstandingDBDAOmodifyOTSSettleFlagUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.06 
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

public class AccountReceivableOutstandingDBDAOmodifyOTSSettleFlagUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OTS Settle Flag 와 Exrate Flag 를 Update 한다.
	  * </pre>
	  */
	public AccountReceivableOutstandingDBDAOmodifyOTSSettleFlagUSQL(){
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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration").append("\n"); 
		query.append("FileName : AccountReceivableOutstandingDBDAOmodifyOTSSettleFlagUSQL").append("\n"); 
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
		query.append("UPDATE SAR_OTS_HDR SET" ).append("\n"); 
		query.append("    STL_FLG = NVL((SELECT 'N'" ).append("\n"); 
		query.append("       	   		   FROM SAR_OTS_DTL" ).append("\n"); 
		query.append("       	   		   WHERE RHQ_CD = @[rhq_cd]" ).append("\n"); 
		query.append("       	   		   AND OTS_OFC_CD = @[ots_ofc_cd]" ).append("\n"); 
		query.append("       	   		   AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("       	   		   AND INV_NO = @[inv_no]" ).append("\n"); 
		query.append("		   		   AND NVL(BAL_AMT, 0) <> 0" ).append("\n"); 
		query.append("		   		   AND ROWNUM = 1), 'Y')" ).append("\n"); 
		query.append("    , OTS_RT_FLG = NVL((SELECT 'N' " ).append("\n"); 
		query.append("       	   				FROM SAR_OTS_DTL" ).append("\n"); 
		query.append("           				WHERE RHQ_CD = @[rhq_cd]" ).append("\n"); 
		query.append("           				AND OTS_OFC_CD = @[ots_ofc_cd]" ).append("\n"); 
		query.append("           				AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("           				AND INV_NO = @[inv_no]" ).append("\n"); 
		query.append("						AND NVL(INV_AMT, 0) <> 0" ).append("\n"); 
		query.append("	       				AND (NVL(LOCL_XCH_RT, 0) = 0 OR NVL(USD_XCH_RT, 0) = 0)" ).append("\n"); 
		query.append("           				AND ROWNUM = 1), 'Y')" ).append("\n"); 
		query.append("	, UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("    , UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE RHQ_CD = @[rhq_cd]" ).append("\n"); 
		query.append("AND OTS_OFC_CD = @[ots_ofc_cd]" ).append("\n"); 
		query.append("AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("AND INV_NO = @[inv_no]" ).append("\n"); 

	}
}