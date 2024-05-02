/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchEdiPHILSInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.09
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOSearchEdiPHILSInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEdiPHILSInfo
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchEdiPHILSInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOSearchEdiPHILSInfoRSQL").append("\n"); 
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
		query.append("SELECT  BL_SRC_NO," ).append("\n"); 
		query.append("        SND_SEQ," ).append("\n"); 
		query.append("        FLT_FILE_REF_NO," ).append("\n"); 
		query.append("        EDI_SND_DT," ).append("\n"); 
		query.append("        FRT_USD_RT_AMT," ).append("\n"); 
		query.append("        OTR_USD_CONV_AMT," ).append("\n"); 
		query.append("        TTL_USD_AMT," ).append("\n"); 
		query.append("        VSL_CD||SKD_VOY_NO||SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("        SAIL_ARR_DT," ).append("\n"); 
		query.append("        PHILS_LOC_CD_CTNT," ).append("\n"); 
		query.append("        CUST_REF_NO_CTNT," ).append("\n"); 
		query.append("        POR_CD," ).append("\n"); 
		query.append("        POL_CD," ).append("\n"); 
		query.append("        POD_CD," ).append("\n"); 
		query.append("        DEL_CD," ).append("\n"); 
		query.append("        INV_CUST_CNT_CD," ).append("\n"); 
		query.append("		INV_CUST_SEQ" ).append("\n"); 
		query.append("FROM    INV_EDI_PHILS" ).append("\n"); 
		query.append("WHERE (BL_SRC_NO, SND_SEQ) IN (SELECT BL_SRC_NO, MAX(SND_SEQ)" ).append("\n"); 
		query.append("                               FROM INV_EDI_PHILS" ).append("\n"); 
		query.append("                               WHERE BL_SRC_NO = @[bl_src_no] " ).append("\n"); 
		query.append("                               GROUP BY BL_SRC_NO)" ).append("\n"); 

	}
}