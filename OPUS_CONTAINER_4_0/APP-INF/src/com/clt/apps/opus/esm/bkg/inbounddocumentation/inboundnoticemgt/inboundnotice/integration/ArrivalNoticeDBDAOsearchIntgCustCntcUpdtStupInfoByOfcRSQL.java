/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ArrivalNoticeDBDAOsearchIntgCustCntcUpdtStupInfoByOfcRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.03
*@LastModifier : 
*@LastVersion : 1.0
* 2010.08.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ArrivalNoticeDBDAOsearchIntgCustCntcUpdtStupInfoByOfcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Integrated Customer Data Update Setup
	  * </pre>
	  */
	public ArrivalNoticeDBDAOsearchIntgCustCntcUpdtStupInfoByOfcRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : ArrivalNoticeDBDAOsearchIntgCustCntcUpdtStupInfoByOfcRSQL").append("\n"); 
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
		query.append("SELECT OFC_CD," ).append("\n"); 
		query.append("       AUTO_UPD_FLG," ).append("\n"); 
		query.append("       UPD_USR_ID," ).append("\n"); 
		query.append("       TO_CHAR(UPD_LOCL_DT,'YYYY-MM-DD HH24:MI') AS UPD_LOCL_DT" ).append("\n"); 
		query.append("  FROM BKG_IB_CUST_CNTC_STUP" ).append("\n"); 
		query.append(" WHERE OFC_CD       = @[ofc_cd]" ).append("\n"); 

	}
}