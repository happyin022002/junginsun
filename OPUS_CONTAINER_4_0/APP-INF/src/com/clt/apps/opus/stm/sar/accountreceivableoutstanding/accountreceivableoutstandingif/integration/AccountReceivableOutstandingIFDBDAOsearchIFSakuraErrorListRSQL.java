/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableOutstandingIFDBDAOsearchIFSakuraErrorListRSQL.java
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

public class AccountReceivableOutstandingIFDBDAOsearchIFSakuraErrorListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchIFSakuraErrorList
	  * </pre>
	  */
	public AccountReceivableOutstandingIFDBDAOsearchIFSakuraErrorListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("check_status",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstandingif.integration").append("\n"); 
		query.append("FileName : AccountReceivableOutstandingIFDBDAOsearchIFSakuraErrorListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT SODT.OTS_DTRB_SEQ AS OTS_DTRB_SEQ   " ).append("\n"); 
		query.append("    FROM SAR_OTS_HDR SOH" ).append("\n"); 
		query.append("     , SAR_OTS_DTL SOD" ).append("\n"); 
		query.append("     , SAR_OTS_CHG SOC" ).append("\n"); 
		query.append("     , SAR_OTS_HIS SOHI" ).append("\n"); 
		query.append("     , SAR_OTS_DTRB SODT" ).append("\n"); 
		query.append(" WHERE SOH.RHQ_CD = SOD.RHQ_CD" ).append("\n"); 
		query.append("   AND SOH.OTS_OFC_CD = SOD.OTS_OFC_CD" ).append("\n"); 
		query.append("   AND SOH.BL_NO = SOD.BL_NO" ).append("\n"); 
		query.append("   AND SOH.INV_NO = SOD.INV_NO" ).append("\n"); 
		query.append("   AND SOD.RHQ_CD = SOC.RHQ_CD" ).append("\n"); 
		query.append("   AND SOD.OTS_OFC_CD = SOC.OTS_OFC_CD" ).append("\n"); 
		query.append("   AND SOD.BL_NO = SOC.BL_NO" ).append("\n"); 
		query.append("   AND SOD.INV_NO = SOC.INV_NO" ).append("\n"); 
		query.append("   AND SOC.RHQ_CD = SOHI.RHQ_CD" ).append("\n"); 
		query.append("   AND SOC.OTS_OFC_CD = SOHI.OTS_OFC_CD" ).append("\n"); 
		query.append("   AND SOC.BL_NO = SOHI.BL_NO" ).append("\n"); 
		query.append("   AND SOC.INV_NO = SOHI.INV_NO" ).append("\n"); 
		query.append("   AND SOHI.OTS_HIS_SEQ = SODT.OTS_HIS_SEQ" ).append("\n"); 
		query.append("   AND SOC.OTS_HIS_SEQ = SODT.OTS_HIS_SEQ" ).append("\n"); 
		query.append("   #if (${check_if_no} != '' )" ).append("\n"); 
		query.append("   AND SOHI.IF_NO IN (" ).append("\n"); 
		query.append("		#foreach( $key IN ${check_if_nos}) " ).append("\n"); 
		query.append(" 			#if($velocityCount < $check_if_nos.size())" ).append("\n"); 
		query.append("    			'$key'," ).append("\n"); 
		query.append(" 			#else" ).append("\n"); 
		query.append("  				'$key'" ).append("\n"); 
		query.append(" 			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("   ) " ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   AND SODT.AR_IF_STS_CD = @[check_status]" ).append("\n"); 

	}
}