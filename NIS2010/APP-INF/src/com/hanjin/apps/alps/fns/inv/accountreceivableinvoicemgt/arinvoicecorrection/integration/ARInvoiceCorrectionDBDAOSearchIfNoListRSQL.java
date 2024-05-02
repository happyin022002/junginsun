/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ARInvoiceCorrectionDBDAOSearchIfNoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.23
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2010.02.23 박정진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JungJin, Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCorrectionDBDAOSearchIfNoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ARInvoiceCorrectionDBDAOSearchIfNoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration").append("\n"); 
		query.append("FileName : ARInvoiceCorrectionDBDAOSearchIfNoListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT MN.AR_IF_NO," ).append("\n"); 
		query.append("	   MN.IO_BND_CD BND," ).append("\n"); 
		query.append("	   MN.SAIL_ARR_DT SA_DT," ).append("\n"); 
		query.append("	   MN.AR_OFC_CD OFC_CD," ).append("\n"); 
		query.append("	   MN.GL_EFF_DT," ).append("\n"); 
		query.append("       MN.BKG_NO," ).append("\n"); 
		query.append("       MN.SAIL_DT," ).append("\n"); 
		query.append("       DTL.INV_NO" ).append("\n"); 
		query.append("  FROM INV_AR_ISS_DTL DTL," ).append("\n"); 
		query.append("       INV_AR_CHG     CHG," ).append("\n"); 
		query.append("       INV_AR_MN      MN" ).append("\n"); 
		query.append(" WHERE DTL.AR_IF_NO = CHG.AR_IF_NO" ).append("\n"); 
		query.append("   AND DTL.CHG_SEQ      = CHG.CHG_SEQ" ).append("\n"); 
		query.append("   AND CHG.AR_IF_NO     = MN.AR_IF_NO" ).append("\n"); 
		query.append("   AND MN.AR_OFC_CD       = @[ar_ofc_cd]" ).append("\n"); 
		query.append("   AND DTL.INV_NO         = @[inv_no]" ).append("\n"); 
		query.append("   AND MN.REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("   AND NVL(MN.INV_DELT_DIV_CD,'N') <> 'Y'" ).append("\n"); 
		query.append("   -- AND NVL(MN.INV_SPLIT_CD,'N') NOT IN ('M','X') 2010-01-18 이상희 과장" ).append("\n"); 
		query.append(" ORDER BY MN.AR_IF_NO DESC" ).append("\n"); 

	}
}