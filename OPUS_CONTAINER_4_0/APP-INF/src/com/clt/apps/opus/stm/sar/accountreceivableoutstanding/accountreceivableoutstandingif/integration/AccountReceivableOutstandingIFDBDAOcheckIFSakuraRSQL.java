/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableOutstandingIFDBDAOcheckIFSakuraRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstandingif.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableOutstandingIFDBDAOcheckIFSakuraRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * checkIFSakura
	  * </pre>
	  */
	public AccountReceivableOutstandingIFDBDAOcheckIFSakuraRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("check_if_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstandingif.integration").append("\n"); 
		query.append("FileName : AccountReceivableOutstandingIFDBDAOcheckIFSakuraRSQL").append("\n"); 
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
		query.append("SELECT  DECODE(MO.SO_IF_CD, 'B','BRN', 'O' ,'AGT', 'S' ,'AGT' ) BRN_AGT_DIV" ).append("\n"); 
		query.append("       ,DECODE(SOHI.REV_TP_SRC_CD,'ASA','ASA','INV') INV_ASA_DIV " ).append("\n"); 
		query.append("       ,DECODE(MO.FINC_RGN_CD, 11,'JP','NN') CNT_CD" ).append("\n"); 
		query.append("FROM SAR_OTS_HDR SOH," ).append("\n"); 
		query.append("     SAR_OTS_HIS SOHI," ).append("\n"); 
		query.append("     MDM_ORGANIZATION MO      " ).append("\n"); 
		query.append("WHERE SOHI.IF_NO = @[check_if_no]" ).append("\n"); 
		query.append("AND SOH.RHQ_CD= SOHI.RHQ_CD" ).append("\n"); 
		query.append("AND SOH.OTS_OFC_CD = SOHI.OTS_OFC_CD" ).append("\n"); 
		query.append("AND SOH.BL_NO = SOHI.BL_NO" ).append("\n"); 
		query.append("AND SOH.INV_NO = SOHI.INV_NO" ).append("\n"); 
		query.append("AND MO.OFC_CD = SOH.CLT_OFC_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1 " ).append("\n"); 

	}
}