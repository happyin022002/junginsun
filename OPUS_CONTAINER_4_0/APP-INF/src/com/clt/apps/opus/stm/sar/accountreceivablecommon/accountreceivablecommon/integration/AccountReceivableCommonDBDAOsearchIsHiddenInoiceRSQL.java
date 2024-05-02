/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableCommonDBDAOsearchIsHiddenInoiceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableCommonDBDAOsearchIsHiddenInoiceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchIsHiddenInoice
	  * </pre>
	  */
	public AccountReceivableCommonDBDAOsearchIsHiddenInoiceRSQL(){
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
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration").append("\n"); 
		query.append("FileName : AccountReceivableCommonDBDAOsearchIsHiddenInoiceRSQL").append("\n"); 
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
		query.append("WITH OFC_INFO" ).append("\n"); 
		query.append("AS (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("      @[ofc_cd] AS OFC_CD," ).append("\n"); 
		query.append("      AR_OFC_CD" ).append("\n"); 
		query.append("      FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("      WHERE OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("      AND ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    OFC_INFO.OFC_CD," ).append("\n"); 
		query.append("    OFC_INFO.AR_OFC_CD," ).append("\n"); 
		query.append("    MO.AR_HD_QTR_OFC_CD, " ).append("\n"); 
		query.append("    DECODE(OFC_INFO.OFC_CD,MO.AR_HD_QTR_OFC_CD,'Y','N') AS HQ_FLG," ).append("\n"); 
		query.append("    SO.OTS_CATE_CD," ).append("\n"); 
		query.append("    DECODE(SO.OTS_CATE_CD,'INV','N',DECODE(OFC_INFO.OFC_CD,MO.AR_HD_QTR_OFC_CD,'N','Y')) INV_HDN_YN" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("MDM_ORGANIZATION MO," ).append("\n"); 
		query.append("SCO_OFC_INFO SO," ).append("\n"); 
		query.append("OFC_INFO" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("OFC_INFO.AR_OFC_CD = MO.OFC_CD(+)" ).append("\n"); 
		query.append("AND OFC_INFO.AR_OFC_CD = SO.OFC_CD(+)" ).append("\n"); 

	}
}