/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChassisGensetSOManageDBDAOSearchVendorRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.chassisgensetsomanage.chassisgensetsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisGensetSOManageDBDAOSearchVendorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vendor List Retrieve
	  * </pre>
	  */
	public ChassisGensetSOManageDBDAOSearchVendorRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("OFC_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("SPOT_BID_CNDDT_TERM_SEQ",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("VNDR_SEQ",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.chassisgensetsomanage.chassisgensetsomanage.integration").append("\n"); 
		query.append("FileName : ChassisGensetSOManageDBDAOSearchVendorRSQL").append("\n"); 
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
		query.append("SELECT X.VNDR_SEQ AS VNDR_NO" ).append("\n"); 
		query.append("      ,X.VNDR_LGL_ENG_NM AS VNDR_NM_ENG" ).append("\n"); 
		query.append("      ,NVL(Y.CURR_CD, X.PAY_CURR_CD) AS VNDR_CNT_CURR_CD" ).append("\n"); 
		query.append("      ,NVL(Z.HZD_MTRL_FLG,'N') HZD_MTRL_FLG" ).append("\n"); 
		query.append("      ,NVL(Z.OVWT_TRI_AXL_FLG,'N') OVWT_TRI_AXL_FLG" ).append("\n"); 
		query.append("      ,(SELECT VNDR_EML FROM MDM_VNDR_CNTC_PNT WHERE 1=1 AND PRMRY_CHK_FLG = 'Y' AND DELT_FLG = 'N' AND VNDR_SEQ = X.VNDR_SEQ AND CNTC_DIV_CD = 'EMAIL' AND ROWNUM = 1) AS VNDR_EML" ).append("\n"); 
		query.append("      ,NVL((SELECT MAX(MAX(SP_EXIST_FLG) KEEP(DENSE_RANK LAST ORDER BY SP_USR_IF_SEQ)) FROM TRS_SVC_PROV_PTAL_USR_IF WHERE SP_VNDR_SEQ = X.VNDR_SEQ GROUP BY SP_USR_ID), 'N') AS SP_PTAL_EXIST_FLG" ).append("\n"); 
		query.append("      ,DECODE((SELECT COUNT(1) FROM TRS_SPOT_BID_CNDDT_VNDR WHERE 1=1 AND SPOT_BID_CNDDT_TERM_SEQ = @[SPOT_BID_CNDDT_TERM_SEQ] AND VNDR_SEQ = X.VNDR_SEQ AND DELT_FLG = 'N'), 0, 'N', 'Y') AS CNDDT_VNDR_FLG" ).append("\n"); 
		query.append("  FROM MDM_VENDOR X" ).append("\n"); 
		query.append("      ,(SELECT /*+ INDEX_DESC(C XPKTRS_AGMT_EQ_RT) */" ).append("\n"); 
		query.append("              A.VNDR_SEQ" ).append("\n"); 
		query.append("             ,C.CURR_CD" ).append("\n"); 
		query.append("         FROM TRS_AGMT_APLY_VNDR A" ).append("\n"); 
		query.append("             ,TRS_AGMT_EQ_RT C" ).append("\n"); 
		query.append("        WHERE A.TRSP_AGMT_OFC_CTY_CD = C.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("          AND A.TRSP_AGMT_SEQ = C.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("          AND A.VNDR_SEQ = @[VNDR_SEQ]" ).append("\n"); 
		query.append("          AND ROWNUM = 1" ).append("\n"); 
		query.append("      ) Y" ).append("\n"); 
		query.append("      ,TRS_SPCL_CGO_AVAL_SVC_PROV Z" ).append("\n"); 
		query.append(" WHERE X.VNDR_SEQ = Y.VNDR_SEQ(+)" ).append("\n"); 
		query.append("   AND X.VNDR_SEQ = @[VNDR_SEQ]" ).append("\n"); 
		query.append("   AND X.delt_flg = 'N'" ).append("\n"); 
		query.append("   AND X.VNDR_SEQ = Z.VNDR_SEQ(+)" ).append("\n"); 
		query.append("   AND @[OFC_CD]  = Z.SO_CRE_OFC_CD(+)" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}