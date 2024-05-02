/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountPayableCommonDBDAOSearchPopSupplierListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.12 
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

public class AccountPayableCommonDBDAOSearchPopSupplierListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * STM_SAP_0002- Supplier Pop List
	  * </pre>
	  */
	public AccountPayableCommonDBDAOSearchPopSupplierListRSQL(){
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
		query.append("FileName : AccountPayableCommonDBDAOSearchPopSupplierListRSQL").append("\n"); 
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
		query.append("  MV.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append(" ,MV.VNDR_SEQ" ).append("\n"); 
		query.append(" ,MV.INV_CURR_CD" ).append("\n"); 
		query.append(" ,NVL( MV.PAY_CURR_CD, MV.INV_CURR_CD ) AS PAY_CURR_CD" ).append("\n"); 
		query.append(" ,MV.GEN_PAY_TERM_CD" ).append("\n"); 
		query.append(" ,MV.VNDR_CNT_CD" ).append("\n"); 
		query.append(" ,MV.RGST_NO" ).append("\n"); 
		query.append(" ,MV.TAX_ID" ).append("\n"); 
		query.append(" ,MV.PAY_MZD_CD" ).append("\n"); 
		query.append(" ,SV.LU_CD AS SAP_PAY_MZD_CD" ).append("\n"); 
		query.append(" ,NVL(MV.BANK_ACCT_FLG, 'N') AS BANK_ACCT_FLG" ).append("\n"); 
		query.append("FROM MDM_VENDOR MV " ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("    SELECT  SLD.lU_CD" ).append("\n"); 
		query.append("          , SLD.LU_DESC" ).append("\n"); 
		query.append("          , SLD.ATTR_CTNT2 AS PAY_MZD_CD" ).append("\n"); 
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
		query.append("  AND MV.VNDR_SEQ LIKE @[vndr_seq]||'%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_lgl_eng_nm} != '')" ).append("\n"); 
		query.append("  AND UPPER(MV.VNDR_LGL_ENG_NM) LIKE '%'||UPPER(@[vndr_lgl_eng_nm])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${delt_flg} != '')" ).append("\n"); 
		query.append("  AND NVL(MV.DELT_FLG,'Y') = @[delt_flg]" ).append("\n"); 
		query.append("  --AND MV.PAY_MZD_CD <> 'X'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY MV.VNDR_SEQ" ).append("\n"); 

	}
}