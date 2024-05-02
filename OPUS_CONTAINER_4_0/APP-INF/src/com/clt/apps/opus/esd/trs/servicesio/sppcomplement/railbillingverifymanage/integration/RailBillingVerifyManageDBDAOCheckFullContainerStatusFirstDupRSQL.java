/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RailBillingVerifyManageDBDAOCheckFullContainerStatusFirstDupRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.30
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2016.11.30 박찬우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.sppcomplement.railbillingverifymanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chanwoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailBillingVerifyManageDBDAOCheckFullContainerStatusFirstDupRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SEN, HJL, HJS RAIL BILLING 중복 CHECK
	  * </pre>
	  */
	public RailBillingVerifyManageDBDAOCheckFullContainerStatusFirstDupRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eqNo",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.servicesio.sppcomplement.railbillingverifymanage.integration").append("\n"); 
		query.append("FileName : RailBillingVerifyManageDBDAOCheckFullContainerStatusFirstDupRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    EQ_NO," ).append("\n"); 
		query.append("    MAX(VERIFY_RESULT) VERIFY_RESULT," ).append("\n"); 
		query.append("    MAX(VERIFY_YN) VERIFY_YN," ).append("\n"); 
		query.append("    MAX(CXL_RQST) CXL_RQST" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT EQ_NO," ).append("\n"); 
		query.append("        SUBSTR( TO_CHAR(LOCL_CRE_DT, 'YYYYMMDD')|| 'NYK - CNTR_NO: ' ||EQ_NO" ).append("\n"); 
		query.append("        ||' S/O created( '||TO_CHAR(LOCL_CRE_DT, 'YYYYMMDD') " ).append("\n"); 
		query.append("        ||DECODE(TRSP_BND_CD, 'O', ' : Full )', ' : Mty )'" ).append("\n"); 
		query.append("        ||' ROUTE : ' ||FM_NOD_CD||'-->'||TO_NOD_CD), 9, 100) VERIFY_RESULT," ).append("\n"); 
		query.append("        CASE WHEN SO.TRSP_BND_CD = 'O' THEN 'Y' " ).append("\n"); 
		query.append("             WHEN SO.TRSP_BND_CD IS NULL THEN " ).append("\n"); 
		query.append("                    DECODE(SIGN(TRUNC(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC('CHIBB') - LOCL_CRE_DT )-3), -1, 'Y', 0, 'Y', 'N')" ).append("\n"); 
		query.append("        END VERIFY_YN," ).append("\n"); 
		query.append("        DECODE(SIGN(TRUNC(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC('CHIBB') - SO.CXL_RQST_DT )-1 ), -1, 'Y', 0, 'Y', 'N') CXL_RQST" ).append("\n"); 
		query.append("    FROM " ).append("\n"); 
		query.append("        TRS_TRSP_RAIL_BIL_ORD SO" ).append("\n"); 
		query.append("    WHERE ( TRSP_BND_CD = 'O'" ).append("\n"); 
		query.append("                OR TRSP_BND_CD IS NULL )" ).append("\n"); 
		query.append("    AND   ( NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                OR SO.CXL_RQST_DT IS NOT NULL )" ).append("\n"); 
		query.append("    AND   EQ_NO = @[eqNo]" ).append("\n"); 
		query.append("    AND   LOCL_CRE_DT BETWEEN (GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC('CHIBB') - 15) AND GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC('CHIBB')" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("        EQ_NO," ).append("\n"); 
		query.append("        SUBSTR( TO_CHAR(LOCL_CRE_DT, 'YYYYMMDD')|| 'NYK - CNTR_NO: ' ||EQ_NO" ).append("\n"); 
		query.append("        ||' S/O created( '||TO_CHAR(LOCL_CRE_DT, 'YYYYMMDD') " ).append("\n"); 
		query.append("        ||DECODE(TRSP_BND_CD, 'O', ' : Full )', ' : Mty )'" ).append("\n"); 
		query.append("        ||' ROUTE : ' ||FM_NOD_CD||'-->'||TO_NOD_CD), 9, 100) VERIFY_RESULT," ).append("\n"); 
		query.append("        'Y' VERIFY_YN," ).append("\n"); 
		query.append("        ''" ).append("\n"); 
		query.append("    FROM " ).append("\n"); 
		query.append("        TRS_TRSP_RAIL_BIL_ORD SO" ).append("\n"); 
		query.append("    WHERE SO.TRSP_BND_CD = 'I'" ).append("\n"); 
		query.append("    AND   NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("    AND   EQ_NO = @[eqNo]" ).append("\n"); 
		query.append("    AND   LOCL_CRE_DT BETWEEN (GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC('CHIBB') - 5) AND GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC('CHIBB')  " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("GROUP BY EQ_NO" ).append("\n"); 

	}
}