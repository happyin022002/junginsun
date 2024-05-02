/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOsearchApPayInvDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOsearchApPayInvDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchApPayInvDtl
	  * [2015.07.21]Virtual Add Calling 처리. VSK_VSL_PORT_SKD.NVL(VT_ADD_CALL_FLG, 'N') = 'N'
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOsearchApPayInvDtlRSQL(){
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
		params.put("iss_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOsearchApPayInvDtlRSQL").append("\n"); 
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
		query.append("       (SELECT X.INV_RGST_NO FROM PSO_CHARGE X WHERE X.ISS_CTY_CD = T1.ISS_CTY_CD AND X.SO_SEQ = T1.SO_SEQ) AS INV_RGST_NO" ).append("\n"); 
		query.append("     , SO_DTL_SEQ INV_RGST_SEQ" ).append("\n"); 
		query.append("     , '06' AS SO_ETT_TP_CD" ).append("\n"); 
		query.append("     , LGS_COST_CD" ).append("\n"); 
		query.append("     , (SELECT DECODE(LENGTH(T1.LGS_COST_CD), 4, 110911, X.ACCT_CD) FROM TES_LGS_COST X WHERE X.LGS_COST_CD = T1.LGS_COST_CD) AS ACCT_CD" ).append("\n"); 
		query.append("     , VSL_CD" ).append("\n"); 
		query.append("     , SKD_VOY_NO" ).append("\n"); 
		query.append("     , SKD_DIR_CD" ).append("\n"); 
		query.append("     , REV_DIR_CD" ).append("\n"); 
		query.append("     , NVL((SELECT X.VSL_SLAN_CD FROM VSK_VSL_SKD X WHERE X.VSL_CD = T1.VSL_CD AND X.SKD_VOY_NO = T1.SKD_VOY_NO AND X.SKD_DIR_CD = T1.SKD_DIR_CD)," ).append("\n"); 
		query.append("           (SELECT SLAN_CD FROM AR_MST_REV_VVD V WHERE V.VSL_CD = T1.VSL_CD AND V.SKD_VOY_NO = T1.SKD_VOY_NO AND V.SKD_DIR_CD = T1.SKD_DIR_CD AND ROWNUM = 1))AS SLAN_CD" ).append("\n"); 
		query.append("     , SUBSTR((SELECT X.YD_CD FROM PSO_CHARGE X WHERE X.ISS_CTY_CD = T1.ISS_CTY_CD AND X.SO_SEQ = T1.SO_SEQ), 1, 5) AS PORT_CD" ).append("\n"); 
		query.append("     , (SELECT X.YD_CD FROM PSO_CHARGE X WHERE X.ISS_CTY_CD = T1.ISS_CTY_CD AND X.SO_SEQ = T1.SO_SEQ) AS YD_CD" ).append("\n"); 
		query.append("     , LOCL_AMT AS INV_AMT" ).append("\n"); 
		query.append("     , ISS_CTY_CD AS SO_OFC_CTY_CD" ).append("\n"); 
		query.append("     , SO_SEQ" ).append("\n"); 
		query.append("     , 'N' AS DELT_FLG" ).append("\n"); 
		query.append("     , 'USERID' AS CRE_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("     , 'USERID' AS UPD_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("     , SUBSTR(T1.DIFF_RMK,1,200) AS INV_DESC" ).append("\n"); 
		query.append("     , (SELECT X.YD_CD FROM PSO_CHARGE X WHERE X.ISS_CTY_CD = T1.ISS_CTY_CD AND X.SO_SEQ = T1.SO_SEQ) AS ACT_PLC" ).append("\n"); 
		query.append("     , NVL((SELECT TO_CHAR(MIN(X.VPS_ETD_DT), 'YYYYMMDD')" ).append("\n"); 
		query.append("              FROM VSK_VSL_PORT_SKD X" ).append("\n"); 
		query.append("                 , PSO_CHARGE M1" ).append("\n"); 
		query.append("             WHERE M1.ISS_CTY_CD = T1.ISS_CTY_CD" ).append("\n"); 
		query.append("               AND M1.SO_SEQ = T1.SO_SEQ" ).append("\n"); 
		query.append("               AND X.VSL_CD = T1.VSL_CD" ).append("\n"); 
		query.append("               AND X.SKD_VOY_NO = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("               AND X.SKD_DIR_CD = T1.SKD_DIR_CD" ).append("\n"); 
		query.append("               AND X.YD_CD = M1.YD_CD" ).append("\n"); 
		query.append("               AND X.CLPT_IND_SEQ = T1.CLPT_IND_SEQ )," ).append("\n"); 
		query.append("           (SELECT TO_CHAR(X.ISS_DT,'YYYYMMDD')  " ).append("\n"); 
		query.append("              FROM PSO_CHARGE X " ).append("\n"); 
		query.append("             WHERE X.ISS_CTY_CD = T1.ISS_CTY_CD " ).append("\n"); 
		query.append("               AND X.SO_SEQ = T1.SO_SEQ )) AS ACT_DT" ).append("\n"); 
		query.append("  FROM PSO_CHG_DTL T1" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if(${inv_no}!='')" ).append("\n"); 
		query.append("	AND (T1.ISS_CTY_CD, T1.SO_SEQ) = (SELECT ISS_CTY_CD, SO_SEQ FROM PSO_CHARGE WHERE INV_NO = @[inv_no] AND VNDR_SEQ = @[vndr_seq] )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   	AND T1.ISS_CTY_CD = @[iss_cty_cd]" ).append("\n"); 
		query.append("   	AND T1.SO_SEQ = @[so_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}