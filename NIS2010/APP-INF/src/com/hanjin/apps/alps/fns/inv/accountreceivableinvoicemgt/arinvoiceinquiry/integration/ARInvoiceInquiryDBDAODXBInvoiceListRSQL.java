/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ARInvoiceInquiryDBDAODXBInvoiceListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.08
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.06.08 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceInquiryDBDAODXBInvoiceListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * (DXBBB) INV B/L List
	  * </pre>
	  */
	public ARInvoiceInquiryDBDAODXBInvoiceListRSQL(){
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
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration").append("\n"); 
		query.append("FileName : ARInvoiceInquiryDBDAODXBInvoiceListRSQL").append("\n"); 
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
		query.append("SELECT ROW_NO" ).append("\n"); 
		query.append("      ,INV_NO" ).append("\n"); 
		query.append("      ,VVD" ).append("\n"); 
		query.append("      ,CUST_CD" ).append("\n"); 
		query.append("      ,BL_SRC_NO" ).append("\n"); 
		query.append("      ,CHG_CD" ).append("\n"); 
		query.append("      ,IO_BND_CD" ).append("\n"); 
		query.append("      ,PORT_CD" ).append("\n"); 
		query.append("      ,SVC_SCP_CD" ).append("\n"); 
		query.append("      --,INV_SPLIT_CD" ).append("\n"); 
		query.append("      ,USD_XCH_RT" ).append("\n"); 
		query.append("      ,INV_ISS_TP_CD " ).append("\n"); 
		query.append("      --,AR_IF_NO   " ).append("\n"); 
		query.append("      ,CURR_CD" ).append("\n"); 
		query.append("      ,CHG_AMT" ).append("\n"); 
		query.append("	  ,INV_XCH_RT" ).append("\n"); 
		query.append("	  ,LCL_AMT" ).append("\n"); 
		query.append("      ,AR_OFC_CD            " ).append("\n"); 
		query.append("  FROM (SELECT DENSE_RANK() OVER (ORDER BY (A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD)" ).append("\n"); 
		query.append("                                          ,(A.ACT_CUST_CNT_CD||'-'||TO_CHAR(A.ACT_CUST_SEQ,'FM000000'))" ).append("\n"); 
		query.append("                                          ,IO_BND_CD" ).append("\n"); 
		query.append("                                          ,DECODE(A.IO_BND_CD, 'I', A.POD_CD, A.POL_CD)" ).append("\n"); 
		query.append("                                          ,A.SVC_SCP_CD" ).append("\n"); 
		query.append("                                          --,NVL(DECODE(A.INV_SPLIT_CD, 'C','*', A.INV_SPLIT_CD),'*')" ).append("\n"); 
		query.append("										  --,DECODE(A.INV_SPLIT_CD, 'S', TO_CHAR(ROWNUM), A.INV_SPLIT_CD)" ).append("\n"); 
		query.append("                                          --,A.USD_XCH_RT" ).append("\n"); 
		query.append("											) || '1' ROW_NO" ).append("\n"); 
		query.append("              ,DENSE_RANK() OVER (ORDER BY (A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD)" ).append("\n"); 
		query.append("                                          ,(A.ACT_CUST_CNT_CD||'-'||TO_CHAR(A.ACT_CUST_SEQ,'FM000000'))" ).append("\n"); 
		query.append("                                          ,IO_BND_CD" ).append("\n"); 
		query.append("                                          ,DECODE(A.IO_BND_CD, 'I', A.POD_CD, A.POL_CD)" ).append("\n"); 
		query.append("                                          ,A.SVC_SCP_CD" ).append("\n"); 
		query.append("                                          --,NVL(DECODE(A.INV_SPLIT_CD, 'C','*', A.INV_SPLIT_CD),'*')" ).append("\n"); 
		query.append("										  --,DECODE(A.INV_SPLIT_CD, 'S', TO_CHAR(ROWNUM), A.INV_SPLIT_CD)" ).append("\n"); 
		query.append("                                          --,A.USD_XCH_RT" ).append("\n"); 
		query.append("											) INV_NO" ).append("\n"); 
		query.append("              ,(A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD) VVD" ).append("\n"); 
		query.append("              ,(A.ACT_CUST_CNT_CD||'-'||TO_CHAR(A.ACT_CUST_SEQ,'FM000000')) CUST_CD" ).append("\n"); 
		query.append("              --,MAX(A.BL_SRC_NO) BL_SRC_NO" ).append("\n"); 
		query.append("			  ,A.BL_SRC_NO BL_SRC_NO" ).append("\n"); 
		query.append("              ,G.CHG_CD" ).append("\n"); 
		query.append("              ,A.IO_BND_CD" ).append("\n"); 
		query.append("              ,DECODE(A.IO_BND_CD, 'I', A.POD_CD, A.POL_CD) PORT_CD" ).append("\n"); 
		query.append("              ,A.SVC_SCP_CD" ).append("\n"); 
		query.append("              --,NVL(DECODE(A.INV_SPLIT_CD, 'C','*', A.INV_SPLIT_CD),'*') INV_SPLIT_CD" ).append("\n"); 
		query.append("			  --,DECODE(A.INV_SPLIT_CD, 'S', TO_CHAR(ROWNUM), A.INV_SPLIT_CD) INV_SPLIT_CD" ).append("\n"); 
		query.append("              ,A.USD_XCH_RT" ).append("\n"); 
		query.append("              ,I.INV_ISS_TP_CD " ).append("\n"); 
		query.append("              --,A.AR_IF_NO   " ).append("\n"); 
		query.append("              ,G.CURR_CD" ).append("\n"); 
		query.append("              ,TO_CHAR(SUM(G.CHG_AMT)) CHG_AMT" ).append("\n"); 
		query.append("			  ,TO_CHAR(G.INV_XCH_RT) INV_XCH_RT" ).append("\n"); 
		query.append("			  ,SUM(G.INV_XCH_RT*G.CHG_AMT) LCL_AMT" ).append("\n"); 
		query.append("              ,A.AR_OFC_CD              " ).append("\n"); 
		query.append("          FROM INV_AR_MN A" ).append("\n"); 
		query.append("              ,MDM_CUSTOMER F  " ).append("\n"); 
		query.append("              ,INV_AR_CHG G    " ).append("\n"); 
		query.append("              ,INV_AR_STUP_OFC I" ).append("\n"); 
		query.append("         WHERE A.AR_OFC_CD = @[ar_ofc_cd2]" ).append("\n"); 
		query.append("#if (${bl_nos} != '') " ).append("\n"); 
		query.append("		   AND A.BL_SRC_NO IN (${bl_nos})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${from_dt} != '' && ${to_dt} != '') " ).append("\n"); 
		query.append("	#if (${dt_option} == 'G') " ).append("\n"); 
		query.append("		   AND A.BL_INV_CFM_DT BETWEEN REPLACE(@[from_dt],'-','') AND REPLACE(@[to_dt],'-','')" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("	   	   AND A.UPD_DT >= TO_DATE(REPLACE(@[from_dt],'-',''), 'YYYYMMDD') AND A.UPD_DT < TO_DATE(REPLACE(@[to_dt],'-',''), 'YYYYMMDD') + 1" ).append("\n"); 
		query.append("		   AND A.UPD_USR_ID = @[user_id]" ).append("\n"); 
		query.append("	#end  " ).append("\n"); 
		query.append("#end                                                           " ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '') " ).append("\n"); 
		query.append("           AND A.ACT_CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_seq} != '') " ).append("\n"); 
		query.append("           AND A.ACT_CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${if_user_id} != '') " ).append("\n"); 
		query.append("           AND A.UPD_USR_ID = @[if_user_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd} != '') " ).append("\n"); 
		query.append("           AND A.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("           AND A.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4) " ).append("\n"); 
		query.append("           AND A.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${port} != '') " ).append("\n"); 
		query.append("           AND DECODE(A.IO_BND_CD, 'I', A.POD_CD, A.POL_CD) = @[port]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${scp} != '') " ).append("\n"); 
		query.append("           AND A.SVC_SCP_CD = @[scp]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bnd} != 'A' && ${bnd} != '')     " ).append("\n"); 
		query.append("           AND A.IO_BND_CD = @[bnd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rev_type} != '')" ).append("\n"); 
		query.append("	#if (${rev_type} == 'M')     " ).append("\n"); 
		query.append("   	AND A.REV_TP_CD = 'M'" ).append("\n"); 
		query.append("	#elseif (${rev_type} == 'F')     " ).append("\n"); 
		query.append("   	AND A.REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND A.AR_IF_NO = G.AR_IF_NO" ).append("\n"); 
		query.append("#if (${inv_dup_flg} != 'Y') " ).append("\n"); 
		query.append("           AND A.INV_ISS_FLG = 'N'   " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND A.AR_OFC_CD = I.AR_OFC_CD" ).append("\n"); 
		query.append("           AND NVL(A.INV_DELT_DIV_CD, 'N') <> 'Y' " ).append("\n"); 
		query.append("           AND NOT EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                             FROM INV_AR_MN" ).append("\n"); 
		query.append("                            WHERE BL_SRC_NO = A.BL_SRC_NO" ).append("\n"); 
		query.append("                              AND AR_OFC_CD = A.AR_OFC_CD" ).append("\n"); 
		query.append("                              AND BL_INV_CFM_DT IS NULL" ).append("\n"); 
		query.append("							  AND NVL(INV_DELT_DIV_CD, 'N') <> 'Y')" ).append("\n"); 
		query.append("           AND NOT EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                             FROM INV_AR_MN" ).append("\n"); 
		query.append("                            WHERE BL_SRC_NO = A.BL_SRC_NO" ).append("\n"); 
		query.append("                              AND AR_OFC_CD = A.AR_OFC_CD" ).append("\n"); 
		query.append("                              AND USD_XCH_RT = 0" ).append("\n"); 
		query.append("                              AND NVL(INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("#if (${inv_dup_flg} != 'Y')" ).append("\n"); 
		query.append("                              AND INV_ISS_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("           AND A.ACT_CUST_CNT_CD||A.ACT_CUST_SEQ NOT IN (SELECT DECODE(A.REV_TP_CD||A.REV_SRC_CD,'MTH','XX', S2.REP_CUST_CNT_CD||S2.REP_CUST_SEQ)" ).append("\n"); 
		query.append("                                                           FROM INV_AR_STUP_OFC S1" ).append("\n"); 
		query.append("                                                               ,MDM_ORGANIZATION S2" ).append("\n"); 
		query.append("                                                          WHERE S1.AR_OFC_CD = @[ar_ofc_cd2]" ).append("\n"); 
		query.append("                                                            AND S1.OTS_SMRY_CD <> 'BL'" ).append("\n"); 
		query.append("                                                            AND S1.AR_OFC_CD = S2.AR_OFC_CD" ).append("\n"); 
		query.append("                                                            AND S2.REP_CUST_CNT_CD IS NOT NULL" ).append("\n"); 
		query.append("                                                            AND S2.REP_CUST_SEQ IS NOT NULL" ).append("\n"); 
		query.append("                                                            AND S2.DELT_FLG = 'N')" ).append("\n"); 
		query.append("           AND A.ACT_CUST_CNT_CD = F.CUST_CNT_CD" ).append("\n"); 
		query.append("           AND A.ACT_CUST_SEQ    = F.CUST_SEQ" ).append("\n"); 
		query.append("           AND NVL(F.CNTR_DIV_FLG, 'N') = 'Y'" ).append("\n"); 
		query.append("           AND F.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("#if (${ots_smry_cd} == 'BL')" ).append("\n"); 
		query.append("           AND EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                         FROM INV_AR_MN MN, INV_AR_CHG CHG" ).append("\n"); 
		query.append("                        WHERE MN.BL_SRC_NO = A.BL_SRC_NO" ).append("\n"); 
		query.append("                          AND MN.AR_OFC_CD = A.AR_OFC_CD" ).append("\n"); 
		query.append("                          AND MN.ACT_CUST_CNT_CD = A.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("                          AND MN.ACT_CUST_SEQ    = A.ACT_CUST_SEQ" ).append("\n"); 
		query.append("                          AND MN.VSL_CD          = A.VSL_CD" ).append("\n"); 
		query.append("                          AND MN.SKD_VOY_NO      = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                          AND MN.SKD_DIR_CD      = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                          AND MN.IO_BND_CD       = A.IO_BND_CD" ).append("\n"); 
		query.append("                          AND MN.USD_XCH_RT      = A.USD_XCH_RT" ).append("\n"); 
		query.append("                          AND DECODE(MN.IO_BND_CD, 'I', MN.POD_CD, MN.POL_CD) = DECODE(A.IO_BND_CD, 'I', A.POD_CD, A.POL_CD)" ).append("\n"); 
		query.append("                          AND MN.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("                          AND MN.AR_IF_NO   = CHG.AR_IF_NO" ).append("\n"); 
		query.append("                          AND NVL(DECODE(MN.INV_SPLIT_CD, 'C','*', MN.INV_SPLIT_CD),'*') = NVL(DECODE(A.INV_SPLIT_CD, 'C','*', A.INV_SPLIT_CD),'*')						  " ).append("\n"); 
		query.append("                        GROUP BY MN.BL_SRC_NO, MN.ACT_CUST_CNT_CD,MN.ACT_CUST_SEQ," ).append("\n"); 
		query.append("                                 MN.VSL_CD ,MN.SKD_VOY_NO,  MN.SKD_DIR_CD," ).append("\n"); 
		query.append("                                 MN.IO_BND_CD,MN.USD_XCH_RT, DECODE(MN.IO_BND_CD, 'I', MN.POD_CD, MN.POL_CD)," ).append("\n"); 
		query.append("                                 MN.SVC_SCP_CD," ).append("\n"); 
		query.append("                                 CHG.CURR_CD, CHG.CHG_CD," ).append("\n"); 
		query.append("                                 NVL(DECODE(MN.INV_SPLIT_CD, 'C','*', MN.INV_SPLIT_CD),'*')								 " ).append("\n"); 
		query.append("                       HAVING SUM(CHG.CHG_AMT) <> 0 )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         GROUP BY A.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("                 ,A.ACT_CUST_SEQ" ).append("\n"); 
		query.append("                 ,A.VSL_CD" ).append("\n"); 
		query.append("                 ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("                 ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("                 ,A.IO_BND_CD" ).append("\n"); 
		query.append("                 ,DECODE(A.IO_BND_CD, 'I', A.POD_CD, A.POL_CD)" ).append("\n"); 
		query.append("                 ,A.SVC_SCP_CD" ).append("\n"); 
		query.append("                 --,NVL(DECODE(A.INV_SPLIT_CD, 'C','*', A.INV_SPLIT_CD),'*')" ).append("\n"); 
		query.append("				 --,DECODE(A.INV_SPLIT_CD, 'S', TO_CHAR(ROWNUM), A.INV_SPLIT_CD)" ).append("\n"); 
		query.append("                 ,A.USD_XCH_RT" ).append("\n"); 
		query.append("                 ,I.INV_ISS_TP_CD" ).append("\n"); 
		query.append("                 --,A.AR_IF_NO" ).append("\n"); 
		query.append("				 ,A.BL_SRC_NO" ).append("\n"); 
		query.append("                 ,G.CHG_CD" ).append("\n"); 
		query.append("                 ,G.CURR_CD" ).append("\n"); 
		query.append("				 ,G.INV_XCH_RT" ).append("\n"); 
		query.append("                 ,A.AR_OFC_CD" ).append("\n"); 
		query.append("				HAVING SUM(G.INV_XCH_RT*G.CHG_AMT) <> 0" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("        SELECT ROW_NO" ).append("\n"); 
		query.append("              ,INV_NO" ).append("\n"); 
		query.append("              ,'INV TOTAL' VVD" ).append("\n"); 
		query.append("              ,' ' CUST_CD" ).append("\n"); 
		query.append("              ,' ' BL_SRC_NO" ).append("\n"); 
		query.append("              ,' ' CHG_CD" ).append("\n"); 
		query.append("              ,'' IO_BND_CD" ).append("\n"); 
		query.append("              ,'' PORT_CD" ).append("\n"); 
		query.append("              ,'' SVC_SCP_CD" ).append("\n"); 
		query.append("              --,'' INV_SPLIT_CD" ).append("\n"); 
		query.append("              ,0 USD_XCH_RT" ).append("\n"); 
		query.append("              ,'' INV_ISS_TP_CD " ).append("\n"); 
		query.append("              --,'' AR_IF_NO   " ).append("\n"); 
		query.append("              ,'' CURR_CD" ).append("\n"); 
		query.append("              ,'' CHG_AMT" ).append("\n"); 
		query.append("			  ,'' INV_XCH_RT" ).append("\n"); 
		query.append("			  ,SUM(LCL_AMT) LCL_AMT" ).append("\n"); 
		query.append("              ,'' AR_OFC_CD         " ).append("\n"); 
		query.append("          FROM (SELECT DENSE_RANK() OVER (ORDER BY (A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD)" ).append("\n"); 
		query.append("                                                  ,(A.ACT_CUST_CNT_CD||'-'||TO_CHAR(A.ACT_CUST_SEQ,'FM000000'))" ).append("\n"); 
		query.append("                                                  ,IO_BND_CD" ).append("\n"); 
		query.append("                                                  ,DECODE(A.IO_BND_CD, 'I', A.POD_CD, A.POL_CD)" ).append("\n"); 
		query.append("                                                  ,A.SVC_SCP_CD" ).append("\n"); 
		query.append("                                                  --,NVL(DECODE(A.INV_SPLIT_CD, 'C','*', A.INV_SPLIT_CD),'*')" ).append("\n"); 
		query.append("												  --,DECODE(A.INV_SPLIT_CD, 'S', TO_CHAR(ROWNUM), A.INV_SPLIT_CD)" ).append("\n"); 
		query.append("                                                  --,A.USD_XCH_RT" ).append("\n"); 
		query.append("													) || '2' ROW_NO" ).append("\n"); 
		query.append("                      ,DENSE_RANK() OVER (ORDER BY (A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD)" ).append("\n"); 
		query.append("                                                  ,(A.ACT_CUST_CNT_CD||'-'||TO_CHAR(A.ACT_CUST_SEQ,'FM000000'))" ).append("\n"); 
		query.append("                                                  ,IO_BND_CD" ).append("\n"); 
		query.append("                                                  ,DECODE(A.IO_BND_CD, 'I', A.POD_CD, A.POL_CD)" ).append("\n"); 
		query.append("                                                  ,A.SVC_SCP_CD" ).append("\n"); 
		query.append("                                                  --,NVL(DECODE(A.INV_SPLIT_CD, 'C','*', A.INV_SPLIT_CD),'*')" ).append("\n"); 
		query.append("												  --,DECODE(A.INV_SPLIT_CD, 'S', TO_CHAR(ROWNUM), A.INV_SPLIT_CD)" ).append("\n"); 
		query.append("                                                  --,A.USD_XCH_RT" ).append("\n"); 
		query.append("													) INV_NO" ).append("\n"); 
		query.append("                      ,(A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD) VVD" ).append("\n"); 
		query.append("                      ,(A.ACT_CUST_CNT_CD||'-'||TO_CHAR(A.ACT_CUST_SEQ,'FM000000')) CUST_CD" ).append("\n"); 
		query.append("                      ,A.IO_BND_CD" ).append("\n"); 
		query.append("                      ,DECODE(A.IO_BND_CD, 'I', A.POD_CD, A.POL_CD) PORT_CD" ).append("\n"); 
		query.append("                      ,A.SVC_SCP_CD" ).append("\n"); 
		query.append("                      --,NVL(DECODE(A.INV_SPLIT_CD, 'C','*', A.INV_SPLIT_CD),'*') INV_SPLIT_CD" ).append("\n"); 
		query.append("					  --,DECODE(A.INV_SPLIT_CD, 'S', TO_CHAR(ROWNUM), A.INV_SPLIT_CD) INV_SPLIT_CD" ).append("\n"); 
		query.append("                      ,A.USD_XCH_RT" ).append("\n"); 
		query.append("                      ,I.INV_ISS_TP_CD " ).append("\n"); 
		query.append("                      ,A.AR_IF_NO   " ).append("\n"); 
		query.append("                      ,MAX(A.BL_SRC_NO) BL_SRC_NO" ).append("\n"); 
		query.append("                      ,G.CHG_CD" ).append("\n"); 
		query.append("                      ,G.CURR_CD" ).append("\n"); 
		query.append("                      ,SUM(G.CHG_AMT) CHG_AMT" ).append("\n"); 
		query.append("					  ,G.INV_XCH_RT" ).append("\n"); 
		query.append("			  		  ,SUM(G.INV_XCH_RT*G.CHG_AMT) LCL_AMT" ).append("\n"); 
		query.append("                      ,A.AR_OFC_CD              " ).append("\n"); 
		query.append("                  FROM INV_AR_MN A" ).append("\n"); 
		query.append("                      ,MDM_CUSTOMER F  " ).append("\n"); 
		query.append("                      ,INV_AR_CHG G    " ).append("\n"); 
		query.append("                      ,INV_AR_STUP_OFC I" ).append("\n"); 
		query.append("                 WHERE A.AR_OFC_CD = @[ar_ofc_cd2]" ).append("\n"); 
		query.append("#if (${bl_nos} != '') " ).append("\n"); 
		query.append("		           AND A.BL_SRC_NO IN (${bl_nos})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${from_dt} != '' && ${to_dt} != '') " ).append("\n"); 
		query.append("	#if (${dt_option} == 'G') " ).append("\n"); 
		query.append("		           AND A.BL_INV_CFM_DT BETWEEN REPLACE(@[from_dt],'-','') AND REPLACE(@[to_dt],'-','')" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("	               AND A.UPD_DT >= TO_DATE(REPLACE(@[from_dt],'-',''), 'YYYYMMDD') AND A.UPD_DT < TO_DATE(REPLACE(@[to_dt],'-',''), 'YYYYMMDD') + 1" ).append("\n"); 
		query.append("				   AND A.UPD_USR_ID = @[user_id]" ).append("\n"); 
		query.append("	#end  " ).append("\n"); 
		query.append("#end                                                           " ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '') " ).append("\n"); 
		query.append("                   AND A.ACT_CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_seq} != '') " ).append("\n"); 
		query.append("                   AND A.ACT_CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${if_user_id} != '') " ).append("\n"); 
		query.append("                   AND A.UPD_USR_ID = @[if_user_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd} != '') " ).append("\n"); 
		query.append("                   AND A.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                   AND A.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4) " ).append("\n"); 
		query.append("                   AND A.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${port} != '') " ).append("\n"); 
		query.append("                   AND DECODE(A.IO_BND_CD, 'I', A.POD_CD, A.POL_CD) = @[port]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${scp} != '') " ).append("\n"); 
		query.append("                   AND A.SVC_SCP_CD = @[scp]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bnd} != 'A' && ${bnd} != '')     " ).append("\n"); 
		query.append("                   AND A.IO_BND_CD = @[bnd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rev_type} != '')" ).append("\n"); 
		query.append("	#if (${rev_type} == 'M')     " ).append("\n"); 
		query.append("   	AND A.REV_TP_CD = 'M'" ).append("\n"); 
		query.append("	#elseif (${rev_type} != 'M')     " ).append("\n"); 
		query.append("   	AND A.REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                   AND A.AR_IF_NO = G.AR_IF_NO" ).append("\n"); 
		query.append("#if (${inv_dup_flg} != 'Y') " ).append("\n"); 
		query.append("                   AND A.INV_ISS_FLG = 'N'   " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                   AND A.AR_OFC_CD = I.AR_OFC_CD" ).append("\n"); 
		query.append("                   AND NVL(A.INV_DELT_DIV_CD, 'N') <> 'Y' " ).append("\n"); 
		query.append("                   AND NOT EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                                     FROM INV_AR_MN" ).append("\n"); 
		query.append("                                    WHERE BL_SRC_NO = A.BL_SRC_NO" ).append("\n"); 
		query.append("                                      AND AR_OFC_CD = A.AR_OFC_CD" ).append("\n"); 
		query.append("                                      AND BL_INV_CFM_DT IS NULL" ).append("\n"); 
		query.append("                                      AND NVL(INV_DELT_DIV_CD, 'N') <> 'Y')" ).append("\n"); 
		query.append("                   AND NOT EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                                     FROM INV_AR_MN" ).append("\n"); 
		query.append("                                    WHERE BL_SRC_NO = A.BL_SRC_NO" ).append("\n"); 
		query.append("                                      AND AR_OFC_CD = A.AR_OFC_CD" ).append("\n"); 
		query.append("                                      AND USD_XCH_RT = 0" ).append("\n"); 
		query.append("                                      AND NVL(INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("#if (${inv_dup_flg} != 'Y')" ).append("\n"); 
		query.append("                                      AND INV_ISS_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("                   AND A.ACT_CUST_CNT_CD||A.ACT_CUST_SEQ NOT IN (SELECT DECODE(A.REV_TP_CD||A.REV_SRC_CD,'MTH','XX', S2.REP_CUST_CNT_CD||S2.REP_CUST_SEQ)" ).append("\n"); 
		query.append("                                                                   FROM INV_AR_STUP_OFC S1" ).append("\n"); 
		query.append("                                                                       ,MDM_ORGANIZATION S2" ).append("\n"); 
		query.append("                                                                  WHERE S1.AR_OFC_CD = @[ar_ofc_cd2]" ).append("\n"); 
		query.append("                                                                    AND S1.OTS_SMRY_CD <> 'BL'" ).append("\n"); 
		query.append("                                                                    AND S1.AR_OFC_CD = S2.AR_OFC_CD" ).append("\n"); 
		query.append("                                                                    AND S2.REP_CUST_CNT_CD IS NOT NULL" ).append("\n"); 
		query.append("                                                                    AND S2.REP_CUST_SEQ IS NOT NULL" ).append("\n"); 
		query.append("                                                                    AND S2.DELT_FLG = 'N')" ).append("\n"); 
		query.append("                   AND A.ACT_CUST_CNT_CD = F.CUST_CNT_CD" ).append("\n"); 
		query.append("                   AND A.ACT_CUST_SEQ    = F.CUST_SEQ" ).append("\n"); 
		query.append("                   AND NVL(F.CNTR_DIV_FLG, 'N') = 'Y'" ).append("\n"); 
		query.append("                   AND F.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("#if (${ots_smry_cd} == 'BL')" ).append("\n"); 
		query.append("                   AND EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                                 FROM INV_AR_MN MN, INV_AR_CHG CHG" ).append("\n"); 
		query.append("                                WHERE MN.BL_SRC_NO = A.BL_SRC_NO" ).append("\n"); 
		query.append("                                  AND MN.AR_OFC_CD = A.AR_OFC_CD" ).append("\n"); 
		query.append("                                  AND MN.ACT_CUST_CNT_CD = A.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("                                  AND MN.ACT_CUST_SEQ    = A.ACT_CUST_SEQ" ).append("\n"); 
		query.append("                                  AND MN.VSL_CD          = A.VSL_CD" ).append("\n"); 
		query.append("                                  AND MN.SKD_VOY_NO      = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                                  AND MN.SKD_DIR_CD      = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                                  AND MN.IO_BND_CD       = A.IO_BND_CD" ).append("\n"); 
		query.append("                                  AND MN.USD_XCH_RT      = A.USD_XCH_RT" ).append("\n"); 
		query.append("                                  AND DECODE(MN.IO_BND_CD, 'I', MN.POD_CD, MN.POL_CD) = DECODE(A.IO_BND_CD, 'I', A.POD_CD, A.POL_CD)" ).append("\n"); 
		query.append("                                  AND MN.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("                                  AND MN.AR_IF_NO   = CHG.AR_IF_NO" ).append("\n"); 
		query.append("                                  AND NVL(DECODE(MN.INV_SPLIT_CD, 'C','*', MN.INV_SPLIT_CD),'*') = NVL(DECODE(A.INV_SPLIT_CD, 'C','*', A.INV_SPLIT_CD),'*')" ).append("\n"); 
		query.append("                                GROUP BY MN.BL_SRC_NO, MN.ACT_CUST_CNT_CD,MN.ACT_CUST_SEQ," ).append("\n"); 
		query.append("                                         MN.VSL_CD ,MN.SKD_VOY_NO,  MN.SKD_DIR_CD," ).append("\n"); 
		query.append("                                         MN.IO_BND_CD,MN.USD_XCH_RT, DECODE(MN.IO_BND_CD, 'I', MN.POD_CD, MN.POL_CD)," ).append("\n"); 
		query.append("                                         MN.SVC_SCP_CD," ).append("\n"); 
		query.append("                                         CHG.CURR_CD, CHG.CHG_CD," ).append("\n"); 
		query.append("                                         NVL(DECODE(MN.INV_SPLIT_CD, 'C','*', MN.INV_SPLIT_CD),'*')" ).append("\n"); 
		query.append("                               HAVING SUM(CHG.CHG_AMT) <> 0 )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                 GROUP BY A.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("                         ,A.ACT_CUST_SEQ" ).append("\n"); 
		query.append("                         ,A.VSL_CD" ).append("\n"); 
		query.append("                         ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("                         ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("                         ,A.IO_BND_CD" ).append("\n"); 
		query.append("                         ,DECODE(A.IO_BND_CD, 'I', A.POD_CD, A.POL_CD)" ).append("\n"); 
		query.append("                         ,A.SVC_SCP_CD" ).append("\n"); 
		query.append("                         --,NVL(DECODE(A.INV_SPLIT_CD, 'C','*', A.INV_SPLIT_CD),'*')" ).append("\n"); 
		query.append("						 --,DECODE(A.INV_SPLIT_CD, 'S', TO_CHAR(ROWNUM), A.INV_SPLIT_CD)" ).append("\n"); 
		query.append("                         ,A.USD_XCH_RT" ).append("\n"); 
		query.append("                         ,I.INV_ISS_TP_CD" ).append("\n"); 
		query.append("                         ,A.AR_IF_NO" ).append("\n"); 
		query.append("                         ,G.CHG_CD" ).append("\n"); 
		query.append("                         ,G.CURR_CD" ).append("\n"); 
		query.append("						 ,G.INV_XCH_RT" ).append("\n"); 
		query.append("                         ,A.AR_OFC_CD)" ).append("\n"); 
		query.append("          GROUP BY ROW_NO, INV_NO" ).append("\n"); 
		query.append("			HAVING SUM(LCL_AMT) <> 0)" ).append("\n"); 
		query.append(" ORDER BY INV_NO, ROW_NO, VVD, CUST_CD, BL_SRC_NO, CHG_CD" ).append("\n"); 

	}
}