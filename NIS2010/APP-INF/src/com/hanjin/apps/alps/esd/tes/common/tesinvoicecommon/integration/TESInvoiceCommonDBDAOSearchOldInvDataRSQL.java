/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : TESInvoiceCommonDBDAOSearchOldInvDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.03.27
*@LastModifier : 
*@LastVersion : 1.0
* 2017.03.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.common.tesinvoicecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESInvoiceCommonDBDAOSearchOldInvDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchOldInvData
	  * </pre>
	  */
	public TESInvoiceCommonDBDAOSearchOldInvDataRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.tes.common.tesinvoicecommon.integration").append("\n"); 
		query.append("FileName : TESInvoiceCommonDBDAOSearchOldInvDataRSQL").append("\n"); 
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
		query.append("SELECT /*+ FIRST_ROWS */H.INV_OFC_CD," ).append("\n"); 
		query.append("        H.INV_NO," ).append("\n"); 
		query.append("        H.CURR_CD," ).append("\n"); 
		query.append("        H.TTL_INV_AMT," ).append("\n"); 
		query.append("        TO_CHAR(H.RCV_DT, 'YYYY.MM.DD') RCV_DT," ).append("\n"); 
		query.append("        TO_CHAR(H.CRE_DT, 'YYYY.MM.DD') CRE_DT," ).append("\n"); 
		query.append("        H.CRE_USR_ID," ).append("\n"); 
		query.append("        (SELECT USR_NM FROM COM_USER WHERE USR_ID = H.CRE_USR_ID)  CRE_USR_NM," ).append("\n"); 
		query.append("        DECODE(H.TML_INV_STS_CD, 'R', 'RC', 'C', 'CF') TML_INV_STS_CD  " ).append("\n"); 
		query.append("FROM TES_TML_SO_HDR H" ).append("\n"); 
		query.append("WHERE (H.DELT_FLG = 'N' OR DELT_FLG IS NULL)" ).append("\n"); 
		query.append("--2017년 1월 1일 이후 Creation Data로 제한을 둠" ).append("\n"); 
		query.append("  AND TO_CHAR(H.CRE_DT,'YYYYMMDD') >= '20170101' " ).append("\n"); 
		query.append("  AND H.CRE_DT < SYSDATE-60" ).append("\n"); 
		query.append("  AND H.INV_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("  AND H.TML_INV_STS_CD IN ('R', 'C')" ).append("\n"); 

	}
}