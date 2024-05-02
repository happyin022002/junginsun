/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ChinaCustomsTransmissionDBDAOsearchInboundTSCustRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.12
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2013.11.12 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang-Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaCustomsTransmissionDBDAOsearchInboundTSCustRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public ChinaCustomsTransmissionDBDAOsearchInboundTSCustRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.integration").append("\n"); 
		query.append("FileName : ChinaCustomsTransmissionDBDAOsearchInboundTSCustRSQL").append("\n"); 
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
		query.append("SELECT SHPR.CUST_NM AS SHPR_NM," ).append("\n"); 
		query.append("       SHPR.CUST_ADDR AS SHPR_ADDR," ).append("\n"); 
		query.append("       CNEE.CUST_NM AS CNEE_NM," ).append("\n"); 
		query.append("       CNEE.CUST_ADDR AS CNEE_ADDR," ).append("\n"); 
		query.append("       NTFY.CUST_NM AS NTFY_NM," ).append("\n"); 
		query.append("       NTFY.CUST_ADDR AS NTFY_ADDR" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_BL_DOC BL," ).append("\n"); 
		query.append("       BKG_CUSTOMER SHPR," ).append("\n"); 
		query.append("       BKG_CUSTOMER CNEE," ).append("\n"); 
		query.append("       BKG_CUSTOMER NTFY" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE BL.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND BL.BKG_NO = SHPR.BKG_NO" ).append("\n"); 
		query.append("   AND SHPR.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("   AND BL.BKG_NO = CNEE.BKG_NO" ).append("\n"); 
		query.append("   AND CNEE.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("   AND BL.BKG_NO = NTFY.BKG_NO" ).append("\n"); 
		query.append("   AND NTFY.BKG_CUST_TP_CD = 'N'" ).append("\n"); 

	}
}