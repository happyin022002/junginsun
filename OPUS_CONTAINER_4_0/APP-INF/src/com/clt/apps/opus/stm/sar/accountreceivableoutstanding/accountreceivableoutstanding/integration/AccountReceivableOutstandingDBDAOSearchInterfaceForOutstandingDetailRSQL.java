/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableOutstandingDBDAOSearchInterfaceForOutstandingDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.04
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.04 
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

public class AccountReceivableOutstandingDBDAOSearchInterfaceForOutstandingDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search interface for Outstanding Detail
	  * </pre>
	  */
	public AccountReceivableOutstandingDBDAOSearchInterfaceForOutstandingDetailRSQL(){
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
		query.append("FileName : AccountReceivableOutstandingDBDAOSearchInterfaceForOutstandingDetailRSQL").append("\n"); 
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
		query.append("	, A.BL_CURR_CD" ).append("\n"); 
		query.append("	, A.OTS_AMT INV_AMT" ).append("\n"); 
		query.append("	, A.CHG_TP_CD" ).append("\n"); 
		query.append("	, A.CRE_USR_ID" ).append("\n"); 
		query.append("	, A.UPD_USR_ID" ).append("\n"); 
		query.append("	, A.OFC_CURR_CD" ).append("\n"); 
		query.append("FROM SAR_OTS_IF A," ).append("\n"); 
		query.append("	 SCO_OFC_INFO B" ).append("\n"); 
		query.append("WHERE A.AR_OFC_CD = B.OFC_CD(+)" ).append("\n"); 
		query.append("AND A.OTS_IF_SEQ = @[ots_if_seq]" ).append("\n"); 

	}
}