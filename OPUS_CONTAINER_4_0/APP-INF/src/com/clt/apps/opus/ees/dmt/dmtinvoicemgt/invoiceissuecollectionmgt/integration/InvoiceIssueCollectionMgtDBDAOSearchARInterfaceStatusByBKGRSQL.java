/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchARInterfaceStatusByBKGRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.11
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2014.11.11 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOSearchARInterfaceStatusByBKGRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchARInterfaceStatusByBKG
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchARInterfaceStatusByBKGRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt_t2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt_t2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchARInterfaceStatusByBKGRSQL").append("\n"); 
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
		query.append("SELECT   M.AR_OFC_CD AS AR_OFC_CD" ).append("\n"); 
		query.append("        ,M.BL_INV_IF_DT AS IF_DT" ).append("\n"); 
		query.append("        ,C.CHG_CD AS CHG_CD" ).append("\n"); 
		query.append("        ,M.IO_BND_CD AS IO_BND_CD" ).append("\n"); 
		query.append("        , M.REV_TP_CD" ).append("\n"); 
		query.append("          || M.REV_SRC_CD AS TYPE" ).append("\n"); 
		query.append("        ,M.BL_SRC_NO AS BL_NO" ).append("\n"); 
		query.append("        ,M.AR_IF_NO AS IF_NO" ).append("\n"); 
		query.append("        , M.VSL_CD" ).append("\n"); 
		query.append("          || M.SKD_VOY_NO" ).append("\n"); 
		query.append("          || M.SKD_DIR_CD AS VVD_CD" ).append("\n"); 
		query.append("        ,CASE" ).append("\n"); 
		query.append("            WHEN M.IO_BND_CD = 'O'" ).append("\n"); 
		query.append("               THEN M.POL_CD" ).append("\n"); 
		query.append("            ELSE M.POD_CD" ).append("\n"); 
		query.append("         END AS PORT_CD" ).append("\n"); 
		query.append("        , (SELECT I.INV_NO" ).append("\n"); 
		query.append("             FROM INV_AR_ISS I" ).append("\n"); 
		query.append("            WHERE I.INV_NO = (SELECT INV_NO" ).append("\n"); 
		query.append("                                FROM INV_AR_ISS_DTL D" ).append("\n"); 
		query.append("                               WHERE M.AR_IF_NO = D.AR_IF_NO" ).append("\n"); 
		query.append("                                 AND ROWNUM = 1)" ).append("\n"); 
		query.append("              AND ROWNUM = 1) AS INV_NO" ).append("\n"); 
		query.append("        , (SELECT I.ISS_DT" ).append("\n"); 
		query.append("             FROM INV_AR_ISS I" ).append("\n"); 
		query.append("            WHERE I.INV_NO = (SELECT INV_NO" ).append("\n"); 
		query.append("                                FROM INV_AR_ISS_DTL D" ).append("\n"); 
		query.append("                               WHERE M.AR_IF_NO = D.AR_IF_NO" ).append("\n"); 
		query.append("                                 AND ROWNUM = 1)" ).append("\n"); 
		query.append("              AND ROWNUM = 1) AS ISS_DT" ).append("\n"); 
		query.append("        ,C.CURR_CD AS CURR_CD" ).append("\n"); 
		query.append("        ,NVL (SUM (C.CHG_AMT), 0) AS CHG_AMT" ).append("\n"); 
		query.append("        , (SELECT DELT_FLG" ).append("\n"); 
		query.append("             FROM MDM_CUSTOMER" ).append("\n"); 
		query.append("            WHERE CUST_CNT_CD = M.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("              AND CUST_SEQ = TO_CHAR (M.ACT_CUST_SEQ, 'FM000000')) AS PAYER_FLG" ).append("\n"); 
		query.append("        , M.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("          || TRIM (TO_CHAR (M.ACT_CUST_SEQ, '000000')) AS PAYER_CD" ).append("\n"); 
		query.append("        ,CASE" ).append("\n"); 
		query.append("            WHEN M.ACT_CUST_CNT_CD IS NOT NULL" ).append("\n"); 
		query.append("               THEN (SELECT MC.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                       FROM MDM_CUSTOMER MC" ).append("\n"); 
		query.append("                      WHERE MC.CUST_CNT_CD = M.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("                        AND MC.CUST_SEQ = M.ACT_CUST_SEQ)" ).append("\n"); 
		query.append("            WHEN M.ACT_CUST_CNT_CD IS NULL" ).append("\n"); 
		query.append("               THEN (SELECT MV.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("                       FROM MDM_VENDOR MV" ).append("\n"); 
		query.append("                      WHERE MV.VNDR_SEQ = M.ACT_CUST_SEQ)" ).append("\n"); 
		query.append("         END AS PAYER_NM" ).append("\n"); 
		query.append("    FROM INV_AR_MN M" ).append("\n"); 
		query.append("        ,INV_AR_CHG C" ).append("\n"); 
		query.append("   WHERE M.AR_IF_NO = C.AR_IF_NO" ).append("\n"); 
		query.append("     AND M.AR_OFC_CD IN (" ).append("\n"); 
		query.append("        #foreach( $ofc_cd in ${ofc_cd_list} )" ).append("\n"); 
		query.append("            #if($velocityCount < $ofc_cd_list.size()) '$ofc_cd', #else '$ofc_cd' #end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     AND TO_DATE(M.BL_INV_IF_DT,'yyyymmdd') BETWEEN TO_DATE (@[fm_dt_t2], 'yyyymmdd')" ).append("\n"); 
		query.append("                            AND TO_DATE (@[to_dt_t2], 'yyyymmdd')" ).append("\n"); 
		query.append("                                + 0.99999" ).append("\n"); 
		query.append("#if (${chg_cd} == '')" ).append("\n"); 
		query.append("     AND C.CHG_CD IN ('DEM','DET')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("     AND C.CHG_CD = @[chg_cd] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${io_bnd_cd} != '') " ).append("\n"); 
		query.append("     AND M.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${type} == '')" ).append("\n"); 
		query.append("     AND (M.REV_TP_CD IN ('B','C') OR (M.REV_TP_CD = 'M' AND M.REV_SRC_CD NOT IN ('DM','DT')))" ).append("\n"); 
		query.append("#elseif (${type} == 'BKG')" ).append("\n"); 
		query.append("     AND M.REV_TP_CD IN ('B','C')" ).append("\n"); 
		query.append("#elseif (${type} == 'MRI') " ).append("\n"); 
		query.append("     AND M.REV_TP_CD = 'M'" ).append("\n"); 
		query.append("     AND M.REV_SRC_CD NOT IN ('DM','DT')" ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("#if (${act_cust_cd} != '')" ).append("\n"); 
		query.append("	#if (${cust_len} == '8')" ).append("\n"); 
		query.append("     AND M.ACT_CUST_CNT_CD = NVL (SUBSTR (@[act_cust_cd]" ).append("\n"); 
		query.append("                                       ,1" ).append("\n"); 
		query.append("                                       ,2" ).append("\n"); 
		query.append("                                       ), M.ACT_CUST_CNT_CD)" ).append("\n"); 
		query.append("     AND M.ACT_CUST_SEQ = NVL (SUBSTR (@[act_cust_cd]" ).append("\n"); 
		query.append("                                    ,3" ).append("\n"); 
		query.append("                                    ,6" ).append("\n"); 
		query.append("                                    ), M.ACT_CUST_SEQ)" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("     AND M.ACT_CUST_SEQ = NVL (SUBSTR (@[act_cust_cd]" ).append("\n"); 
		query.append("                                    ,1" ).append("\n"); 
		query.append("                                    ,6" ).append("\n"); 
		query.append("                                    ), M.ACT_CUST_SEQ)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("GROUP BY M.AR_OFC_CD" ).append("\n"); 
		query.append("        ,M.BL_INV_IF_DT" ).append("\n"); 
		query.append("        ,C.CHG_CD" ).append("\n"); 
		query.append("        ,M.IO_BND_CD" ).append("\n"); 
		query.append("        , M.REV_TP_CD" ).append("\n"); 
		query.append("          || M.REV_SRC_CD" ).append("\n"); 
		query.append("        ,M.BL_SRC_NO" ).append("\n"); 
		query.append("        ,M.AR_IF_NO" ).append("\n"); 
		query.append("        , M.VSL_CD" ).append("\n"); 
		query.append("          || M.SKD_VOY_NO" ).append("\n"); 
		query.append("          || M.SKD_DIR_CD" ).append("\n"); 
		query.append("        ,CASE" ).append("\n"); 
		query.append("            WHEN M.IO_BND_CD = 'O'" ).append("\n"); 
		query.append("               THEN M.POL_CD" ).append("\n"); 
		query.append("            ELSE M.POD_CD" ).append("\n"); 
		query.append("         END" ).append("\n"); 
		query.append("        ,C.CURR_CD" ).append("\n"); 
		query.append("        ,M.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("        ,M.ACT_CUST_SEQ" ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 
		query.append("        ,2" ).append("\n"); 

	}
}