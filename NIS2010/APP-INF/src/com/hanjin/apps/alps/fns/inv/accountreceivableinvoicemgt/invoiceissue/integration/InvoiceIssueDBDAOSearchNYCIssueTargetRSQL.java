/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : InvoiceIssueDBDAOSearchNYCIssueTargetRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.15
*@LastModifier : Do Soon Choi
*@LastVersion : 1.0
* 2014.10.15 Do Soon Choi
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do Soon Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOSearchNYCIssueTargetRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchNYCIssueTarget
	  * </pre>
	  */
	public InvoiceIssueDBDAOSearchNYCIssueTargetRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bnd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOSearchNYCIssueTargetRSQL").append("\n"); 
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
		query.append("SELECT A.BKG_NO, BL_SRC_NO, " ).append("\n"); 
		query.append("		TO_CHAR(TO_DATE(SAIL_ARR_DT,'YYYYMMDD'),'MM/DD/YYYY') AS SAIL_ARR_DT, " ).append("\n"); 
		query.append("		TO_CHAR(TO_DATE(DUE_DT ,'YYYYMMDD'),'MM/DD/YYYY') AS DUE_DT," ).append("\n"); 
		query.append("      NVL(NVL(OB_EML,IB_EML), CTT.CNTC_PSON_EML) CUST_EML," ).append("\n"); 
		query.append("      NVL(NVL(OB_FAX_NO,IB_FAX_NO),CTT.CNTC_PSON_FAX_NO) CUST_FAX_NO," ).append("\n"); 
		query.append("		A.ACT_CUST_CNT_CD||'-'||LPAD(A.ACT_CUST_SEQ,6,0) AS CUST_CODE," ).append("\n"); 
		query.append("	C.CUST_LGL_ENG_NM AS CUST_NM," ).append("\n"); 
		query.append("	B.CR_AMT," ).append("\n"); 
		query.append("    (SELECT TO_CHAR(ROUND(SUM(CHG_AMT*INV_XCH_RT), 2),'FM999,999,990.00') FROM INV_AR_MN M, INV_AR_CHG CH" ).append("\n"); 
		query.append("        WHERE M.AR_IF_NO = CH.AR_IF_NO AND M.BL_SRC_NO = A.BL_SRC_NO AND M.AR_OFC_CD = A.AR_OFC_CD" ).append("\n"); 
		query.append("         AND NVL(M.INV_DELT_DIV_CD, 'N') <> 'Y') TTL_AMT" ).append("\n"); 
		query.append("FROM INV_AR_MN A," ).append("\n"); 
		query.append("     MDM_CR_CUST B," ).append("\n"); 
		query.append("     MDM_CUSTOMER C," ).append("\n"); 
		query.append("	 BKG_CNTC_PSON CTT" ).append("\n"); 
		query.append("WHERE A.ACT_CUST_SEQ = B.CUST_SEQ(+)" ).append("\n"); 
		query.append("  AND A.ACT_CUST_CNT_CD = B.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("   AND  A.ACT_CUST_SEQ = C.CUST_SEQ(+)" ).append("\n"); 
		query.append("  AND A.ACT_CUST_CNT_CD = C.CUST_CNT_CD(+)" ).append("\n"); 
		query.append(" AND A.BKG_NO = CTT.BKG_NO(+)" ).append("\n"); 
		query.append("   AND 'SI' = CTT.BKG_CNTC_PSON_TP_CD(+)" ).append("\n"); 
		query.append(" AND AR_IF_NO IN (" ).append("\n"); 
		query.append("SELECT SUBSTR(MAX(DECODE(REV_TP_CD,'M','A','B')||AR_IF_NO),2,11) AR_IF_NO" ).append("\n"); 
		query.append(" FROM INV_AR_MN A" ).append("\n"); 
		query.append("    , MDM_CUSTOMER F  " ).append("\n"); 
		query.append("WHERE A.AR_OFC_CD = @[ar_ofc_cd2]" ).append("\n"); 
		query.append("#if (${bl_nos} != '') " ).append("\n"); 
		query.append("   AND A.BL_SRC_NO IN (${bl_nos})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${from_dt} != '' && ${to_dt} != '') " ).append("\n"); 
		query.append("	#if (${dt_option} == 'G') " ).append("\n"); 
		query.append("		AND A.BL_INV_CFM_DT BETWEEN REPLACE(@[from_dt],'-','') AND REPLACE(@[to_dt],'-','')" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("	  	AND A.SAIL_ARR_DT BETWEEN REPLACE(@[from_dt],'-','') AND REPLACE(@[to_dt],'-','')" ).append("\n"); 
		query.append("	#end  " ).append("\n"); 
		query.append("#end                                                           " ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '') " ).append("\n"); 
		query.append("   AND A.ACT_CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_seq} != '') " ).append("\n"); 
		query.append("   AND A.ACT_CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${if_user_id} != '') " ).append("\n"); 
		query.append("   AND A.UPD_USR_ID = @[if_user_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd} != '') " ).append("\n"); 
		query.append("   AND A.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4) " ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${port} != '') " ).append("\n"); 
		query.append("  AND DECODE(A.IO_BND_CD, 'I', A.POD_CD, A.POL_CD) = @[port]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${scp} != '') " ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = @[scp]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bnd} != 'A' && ${bnd} != '')     " ).append("\n"); 
		query.append("   AND A.IO_BND_CD = @[bnd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" AND NVL(A.INV_DELT_DIV_CD, 'N') <> 'Y' " ).append("\n"); 
		query.append("  AND NOT EXISTS ( SELECT 'X'" ).append("\n"); 
		query.append("                   FROM INV_AR_MN" ).append("\n"); 
		query.append("                  WHERE BL_SRC_NO = A.BL_SRC_NO" ).append("\n"); 
		query.append("                    AND AR_OFC_CD = A.AR_OFC_CD" ).append("\n"); 
		query.append("					AND NVL(INV_DELT_DIV_CD, 'N') <> 'Y' " ).append("\n"); 
		query.append("                    AND BL_INV_CFM_DT IS NULL )" ).append("\n"); 
		query.append("  AND NOT EXISTS ( SELECT 'X'" ).append("\n"); 
		query.append("                       FROM INV_AR_MN" ).append("\n"); 
		query.append("                      WHERE BL_SRC_NO = A.BL_SRC_NO" ).append("\n"); 
		query.append("                        AND AR_OFC_CD = A.AR_OFC_CD" ).append("\n"); 
		query.append("                        AND USD_XCH_RT = 0" ).append("\n"); 
		query.append("                        AND NVL(INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("  AND (A.ACT_CUST_CNT_CD,A.ACT_CUST_SEQ) NOT IN (SELECT (DECODE(A.REV_TP_CD||A.REV_SRC_CD,'MTH','XX','MTP','XX', S2.REP_CUST_CNT_CD)),S2.REP_CUST_SEQ" ).append("\n"); 
		query.append("                                                  FROM INV_AR_STUP_OFC S1" ).append("\n"); 
		query.append("                                                      ,MDM_ORGANIZATION S2" ).append("\n"); 
		query.append("                                                 WHERE S1.AR_OFC_CD = @[ar_ofc_cd2]" ).append("\n"); 
		query.append("                                                   AND S1.OTS_SMRY_CD <> 'BL'" ).append("\n"); 
		query.append("                                                   AND S1.AR_OFC_CD = S2.AR_OFC_CD" ).append("\n"); 
		query.append("                                                   AND S2.REP_CUST_CNT_CD IS NOT NULL" ).append("\n"); 
		query.append("                                                   AND S2.REP_CUST_SEQ IS NOT NULL" ).append("\n"); 
		query.append("                                                   AND S2.DELT_FLG = 'N')" ).append("\n"); 
		query.append("  AND A.ACT_CUST_CNT_CD = F.CUST_CNT_CD" ).append("\n"); 
		query.append("  AND A.ACT_CUST_SEQ    = F.CUST_SEQ" ).append("\n"); 
		query.append("  AND NVL(F.CNTR_DIV_FLG, 'N') = 'Y'" ).append("\n"); 
		query.append("  AND F.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("  AND  EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                 FROM INV_AR_MN MN, INV_AR_CHG CHG" ).append("\n"); 
		query.append("                WHERE MN.BL_SRC_NO = A.BL_SRC_NO" ).append("\n"); 
		query.append("                  AND MN.AR_OFC_CD = A.AR_OFC_CD" ).append("\n"); 
		query.append("                  AND MN.ACT_CUST_CNT_CD = A.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("                  AND MN.ACT_CUST_SEQ    = A.ACT_CUST_SEQ" ).append("\n"); 
		query.append("                  AND MN.VSL_CD          = A.VSL_CD" ).append("\n"); 
		query.append("                  AND MN.SKD_VOY_NO      = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                  AND MN.SKD_DIR_CD      = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                  AND MN.IO_BND_CD       = A.IO_BND_CD" ).append("\n"); 
		query.append("                  AND MN.USD_XCH_RT      = A.USD_XCH_RT" ).append("\n"); 
		query.append("                  AND DECODE(MN.IO_BND_CD, 'I', MN.POD_CD, MN.POL_CD) = DECODE(A.IO_BND_CD, 'I', A.POD_CD, A.POL_CD)" ).append("\n"); 
		query.append("                  AND MN.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("                  AND MN.AR_IF_NO   = CHG.AR_IF_NO" ).append("\n"); 
		query.append("                  AND NVL(DECODE(MN.INV_SPLIT_CD, 'C','*', MN.INV_SPLIT_CD),'*') = NVL(DECODE(A.INV_SPLIT_CD, 'C','*', A.INV_SPLIT_CD),'*')" ).append("\n"); 
		query.append("                GROUP BY MN.BL_SRC_NO, MN.ACT_CUST_CNT_CD,MN.ACT_CUST_SEQ," ).append("\n"); 
		query.append("                         MN.VSL_CD ,MN.SKD_VOY_NO,  MN.SKD_DIR_CD," ).append("\n"); 
		query.append("                         MN.IO_BND_CD,MN.USD_XCH_RT, DECODE(MN.IO_BND_CD, 'I', MN.POD_CD, MN.POL_CD)," ).append("\n"); 
		query.append("                         MN.SVC_SCP_CD," ).append("\n"); 
		query.append("                         CHG.CURR_CD, CHG.CHG_CD," ).append("\n"); 
		query.append("                         NVL(DECODE(MN.INV_SPLIT_CD, 'C','*', MN.INV_SPLIT_CD),'*')," ).append("\n"); 
		query.append("						 NVL(MN.RVS_CHG_FLG,'N')" ).append("\n"); 
		query.append("               HAVING SUM(CHG.CHG_AMT) <> 0)  " ).append("\n"); 
		query.append("GROUP BY BL_SRC_NO )" ).append("\n"); 
		query.append("ORDER BY A.ACT_CUST_CNT_CD||'-'||A.ACT_CUST_SEQ" ).append("\n"); 

	}
}