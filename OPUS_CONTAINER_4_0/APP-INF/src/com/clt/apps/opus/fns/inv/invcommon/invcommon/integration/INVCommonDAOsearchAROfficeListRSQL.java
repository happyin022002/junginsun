/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : INVCommonDAOsearchAROfficeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.27
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.invcommon.invcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class INVCommonDAOsearchAROfficeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchAROfficeList
	  * </pre>
	  */
	public INVCommonDAOsearchAROfficeListRSQL(){
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
		query.append("Path : com.clt.apps.opus.fns.inv.invcommon.invcommon.integration").append("\n"); 
		query.append("FileName : INVCommonDAOsearchAROfficeListRSQL").append("\n"); 
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
		query.append("SELECT A.AR_HD_QTR_OFC_CD AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("     , A.AR_OFC_CD AR_OFC_CD" ).append("\n"); 
		query.append("	 , A.SO_IF_CD AR_AGN_STL_CD" ).append("\n"); 
		query.append("	 , B.AR_OFC_CD AR_OFC_CD_LOGIN" ).append("\n"); 
		query.append("	 , A.AR_CURR_CD AR_CURR_CD" ).append("\n"); 
		query.append("	 , NVL(A.AR_CTRL_OFC_CD, 'N') AR_CTRL_OFC_CD" ).append("\n"); 
		query.append("	 , A.LOC_CD LOC_CD" ).append("\n"); 
		query.append("	 , DECODE(C.SYS_AREA_GRP_ID, 'KOR', DECODE(SUBSTR(A.LOC_CD, 1, 2), 'JP', 'JPN', 'KOR'), C.SYS_AREA_GRP_ID) SVR_ID" ).append("\n"); 
		query.append("     , NVL(D.XCH_RT_RVS_FLG,'N') XCH_RT_RVS_FLG" ).append("\n"); 
		query.append("     , E.DP_PRCS_KNT" ).append("\n"); 
		query.append("	 , A.REP_CUST_CNT_CD" ).append("\n"); 
		query.append("	 , A.REP_CUST_SEQ" ).append("\n"); 
		query.append("	 , NVL(D.XCH_RT_USD_TP_CD,'V') XCH_RT_TP_CD" ).append("\n"); 
		query.append("     , D.OTS_SMRY_CD" ).append("\n"); 
		query.append("     , D.INV_DUP_FLG" ).append("\n"); 
		query.append("     , D.INV_MLT_BL_ISS_FLG" ).append("\n"); 
		query.append("     , D.INV_VAT_CHG_CD" ).append("\n"); 
		query.append("     , D.INV_VAT_CHG_RT" ).append("\n"); 
		query.append("     , D.CPY_INV_KNT" ).append("\n"); 
		query.append("	 , NVL(D.XCH_RT_N3RD_TP_CD,'V') XCH_RT_N3RD_TP_CD" ).append("\n"); 
		query.append("     , A.ALTN_CURR_DIV_CD" ).append("\n"); 
		query.append("  FROM MDM_ORGANIZATION A" ).append("\n"); 
		query.append("     , (SELECT AR_HD_QTR_OFC_CD, AR_OFC_CD, LOC_CD" ).append("\n"); 
		query.append("          FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("         WHERE OFC_CD = @[ofc_cd]) B" ).append("\n"); 
		query.append("	 , COM_SYS_AREA_GRP_ID C" ).append("\n"); 
		query.append("     , INV_AR_STUP_OFC D" ).append("\n"); 
		query.append("     , MDM_CURRENCY E" ).append("\n"); 
		query.append(" WHERE A.AR_HD_QTR_OFC_CD = B.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("   AND A.OFC_CD = A.AR_OFC_CD   " ).append("\n"); 
		query.append("   AND A.OFC_CD = D.AR_OFC_CD(+)   " ).append("\n"); 
		query.append("--   AND SUBSTR(A.LOC_CD, 1, 2) = SUBSTR(B.LOC_CD, 1, 2)" ).append("\n"); 
		query.append("   AND SUBSTR(A.LOC_CD, 1, 2) = C.CNT_CD" ).append("\n"); 
		query.append("   AND C.CO_IND_CD = 'H' " ).append("\n"); 
		query.append("   AND A.AR_CURR_CD = E.CURR_CD  " ).append("\n"); 
		query.append(" ORDER BY A.AR_OFC_CD" ).append("\n"); 

	}
}