/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountPayableCommonDBDAOSearchSupplierInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableCommonDBDAOSearchSupplierInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchSupplierInfo
	  * </pre>
	  */
	public AccountPayableCommonDBDAOSearchSupplierInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_lgl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration").append("\n"); 
		query.append("FileName : AccountPayableCommonDBDAOSearchSupplierInfoRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("    MV.VNDR_SEQ            					AS VALUE0" ).append("\n"); 
		query.append("  , MV.VNDR_LGL_ENG_NM     					AS VALUE1" ).append("\n"); 
		query.append("  , MV.INV_CURR_CD							AS VALUE2" ).append("\n"); 
		query.append("  , NVL( MV.PAY_CURR_CD, MV.INV_CURR_CD ) 	AS VALUE3" ).append("\n"); 
		query.append("  , MV.GEN_PAY_TERM_CD     					AS VALUE4" ).append("\n"); 
		query.append("  , MV.VNDR_CNT_CD     						AS VALUE5" ).append("\n"); 
		query.append("  , MV.RGST_NO     							AS VALUE6" ).append("\n"); 
		query.append("  , NVL(MV.BANK_ACCT_FLG, 'N')				AS VALUE7" ).append("\n"); 
		query.append("  , MV.PAY_MZD_CD     						AS VALUE8" ).append("\n"); 
		query.append("  , SV.LU_CD     							AS VALUE9" ).append("\n"); 
		query.append("FROM MDM_VENDOR MV " ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("    SELECT  SLD.lU_CD" ).append("\n"); 
		query.append("          , SLD.LU_DESC" ).append("\n"); 
		query.append("          , NVL(SLD.ATTR_CTNT2, SLD.LU_CD) AS PAY_MZD_CD" ).append("\n"); 
		query.append("    FROM    SCO_LU_HDR SLH" ).append("\n"); 
		query.append("          , SCO_LU_DTL SLD" ).append("\n"); 
		query.append("    WHERE   SLH.LU_TP_CD = SLD.LU_TP_CD" ).append("\n"); 
		query.append("    AND     SLH.LU_TP_CD = 'PAYMENT METHOD'" ).append("\n"); 
		query.append("    AND     NVL(SLD.ENBL_FLG, 'Y') = 'Y'" ).append("\n"); 
		query.append("    AND     NVL(SLD.LU_ST_DT, SYSDATE) >= SYSDATE" ).append("\n"); 
		query.append("    AND     SLH.LU_APPL_CD = 'SAP'" ).append("\n"); 
		query.append(" ) SV" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND MV.PAY_MZD_CD = SV.PAY_MZD_CD(+)" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("  AND MV.VNDR_SEQ = @[vndr_seq] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_lgl_eng_nm} != '')" ).append("\n"); 
		query.append("  AND UPPER(MV.VNDR_LGL_ENG_NM) LIKE '%'||UPPER(@[vndr_lgl_eng_nm])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${delt_flg} != '')" ).append("\n"); 
		query.append("  AND NVL(MV.DELT_FLG,'Y') = @[delt_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY MV.VNDR_SEQ" ).append("\n"); 

	}
}