/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InvoiceIssueDBDAOsearch3rdCheckListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOsearch3rdCheckListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search3rdCheckList
	  * </pre>
	  */
	public InvoiceIssueDBDAOsearch3rdCheckListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOsearch3rdCheckListRSQL").append("\n"); 
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
		query.append("WITH SINSC_TEMP AS " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT DISTINCT " ).append("\n"); 
		query.append("  G.INV_XCH_RT,A.BL_SRC_NO, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD " ).append("\n"); 
		query.append(" ,DECODE(A.IO_BND_CD, 'O' , A.POL_CD, A.POD_CD) PORT_CD" ).append("\n"); 
		query.append(" ,A.IO_BND_CD " ).append("\n"); 
		query.append(" ,A.SVC_SCP_CD" ).append("\n"); 
		query.append(" ,A.AR_OFC_CD " ).append("\n"); 
		query.append(" ,A.LOCL_CURR_CD " ).append("\n"); 
		query.append(" ,G.CURR_CD " ).append("\n"); 
		query.append(" ,A.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append(" ,A.ACT_CUST_SEQ" ).append("\n"); 
		query.append(" ,A.XCH_RT_DT " ).append("\n"); 
		query.append(" ,A.XCH_RT_N3RD_TP_CD" ).append("\n"); 
		query.append(" ,A.GL_EFF_DT" ).append("\n"); 
		query.append(" FROM INV_AR_MN A" ).append("\n"); 
		query.append("    , MDM_CUSTOMER F  " ).append("\n"); 
		query.append("    , INV_AR_CHG G    " ).append("\n"); 
		query.append("    , INV_AR_STUP_OFC I" ).append("\n"); 
		query.append("WHERE A.AR_OFC_CD = @[ar_ofc_cd2]" ).append("\n"); 
		query.append("#if (${bl_nos} != '') " ).append("\n"); 
		query.append("   AND A.BL_SRC_NO IN (${bl_nos})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${from_dt} != '' && ${to_dt} != '') " ).append("\n"); 
		query.append("	#if (${dt_option} == 'G') " ).append("\n"); 
		query.append("		AND A.BL_INV_CFM_DT BETWEEN REPLACE(@[from_dt],'-','') AND REPLACE(@[to_dt],'-','')" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("	  	AND A.UPD_DT >= TO_DATE(REPLACE(@[from_dt],'-',''), 'YYYYMMDD') AND A.UPD_DT < TO_DATE(REPLACE(@[to_dt],'-',''), 'YYYYMMDD') + 1" ).append("\n"); 
		query.append("		AND A.UPD_USR_ID = @[user_id]" ).append("\n"); 
		query.append("    #end  " ).append("\n"); 
		query.append("#end                                                           " ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '') " ).append("\n"); 
		query.append("   AND A.ACT_CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_seq} != '') " ).append("\n"); 
		query.append("   AND A.ACT_CUST_SEQ = @[cust_seq]" ).append("\n"); 
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
		query.append("#if (${rev_type} != '')" ).append("\n"); 
		query.append("	#if (${rev_type} == 'M')     " ).append("\n"); 
		query.append("   	AND A.REV_TP_CD = 'M'" ).append("\n"); 
		query.append("	#elseif (${rev_type} == 'F')     " ).append("\n"); 
		query.append("   	AND A.REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  AND A.AR_IF_NO = G.AR_IF_NO" ).append("\n"); 
		query.append("  AND A.INV_ISS_FLG = 'N'   " ).append("\n"); 
		query.append("  AND A.AR_OFC_CD = I.AR_OFC_CD" ).append("\n"); 
		query.append("  AND NVL(A.INV_DELT_DIV_CD, 'N') <> 'Y' " ).append("\n"); 
		query.append(" AND CURR_CD NOT IN('USD','SGD')" ).append("\n"); 
		query.append("  AND NOT EXISTS ( SELECT 'X'" ).append("\n"); 
		query.append("                   FROM INV_AR_MN" ).append("\n"); 
		query.append("                  WHERE BL_SRC_NO = A.BL_SRC_NO" ).append("\n"); 
		query.append("                    AND AR_OFC_CD = A.AR_OFC_CD" ).append("\n"); 
		query.append("					AND NVL(INV_DELT_DIV_CD, 'N') <> 'Y' " ).append("\n"); 
		query.append("                    AND BL_INV_CFM_DT IS NULL )" ).append("\n"); 
		query.append("  AND (A.ACT_CUST_CNT_CD,A.ACT_CUST_SEQ) NOT IN (SELECT (DECODE(A.REV_TP_CD||A.REV_SRC_CD,'MTH','XX','MTP','XX', S2.REP_CUST_CNT_CD)),S2.REP_CUST_SEQ" ).append("\n"); 
		query.append("                                                  FROM INV_AR_STUP_OFC S1" ).append("\n"); 
		query.append("                                                      ,MDM_ORGANIZATION S2" ).append("\n"); 
		query.append("                                                 WHERE S1.AR_OFC_CD = 'SINSC'" ).append("\n"); 
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
		query.append("             HAVING SUM(CHG.CHG_AMT) <> 0 )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  DISTINCT CASE WHEN   COUNT(B.INV_XCH_RT) = 0 THEN A.BL_SRC_NO" ).append("\n"); 
		query.append("				 WHEN   B.INV_XCH_RT = 0  THEN A.BL_SRC_NO " ).append("\n"); 
		query.append("                 WHEN   B.INV_XCH_RT > 0 AND  B.INV_XCH_RT <>  A.INV_XCH_RT THEN  A.BL_SRC_NO" ).append("\n"); 
		query.append("                 ELSE   ''" ).append("\n"); 
		query.append("                 END BL_NOS " ).append("\n"); 
		query.append("FROM SINSC_TEMP A, INV_CUST_AND_DLY_XCH_RT B" ).append("\n"); 
		query.append("WHERE A.ACT_CUST_CNT_CD = B.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND   A.ACT_CUST_SEQ = B.CUST_SEQ(+) " ).append("\n"); 
		query.append("AND   A.IO_BND_CD  = B.IO_BND_CD(+) " ).append("\n"); 
		query.append("AND   A.AR_OFC_CD = B.AR_OFC_CD(+) " ).append("\n"); 
		query.append("AND   A.CURR_CD   = B.CHG_CURR_CD(+)" ).append("\n"); 
		query.append("AND   A.XCH_RT_DT  >= B.FM_DT(+) " ).append("\n"); 
		query.append("AND   A.XCH_RT_DT  <= B.TO_DT(+) " ).append("\n"); 
		query.append("AND   A.XCH_RT_N3RD_TP_CD ='I'" ).append("\n"); 
		query.append("GROUP BY B.INV_XCH_RT, A.BL_SRC_NO,  B.INV_XCH_RT,A.INV_XCH_RT" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  DISTINCT CASE WHEN  A.INV_XCH_RT = 0  THEN CC.BL_SRC_NO " ).append("\n"); 
		query.append("                 WHEN  A.INV_XCH_RT > 0 AND  A.INV_XCH_RT <>  CC.INV_XCH_RT THEN  CC.BL_SRC_NO" ).append("\n"); 
		query.append("                 ELSE ''" ).append("\n"); 
		query.append("                 END BL_NOS" ).append("\n"); 
		query.append("FROM INV_VVD_XCH_RT A " ).append("\n"); 
		query.append("     ,VSK_VSL_PORT_SKD B " ).append("\n"); 
		query.append("     ,SINSC_TEMP CC" ).append("\n"); 
		query.append("WHERE A.VSL_CD = B.VSL_CD(+)" ).append("\n"); 
		query.append("  AND A.SKD_VOY_NO = B.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("  AND A.SKD_DIR_CD = B.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("  AND A.PORT_CD = B.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("  AND B.CLPT_IND_SEQ(+) = 1" ).append("\n"); 
		query.append("  AND A.VSL_CD = CC.VSL_CD " ).append("\n"); 
		query.append("  AND A.SKD_VOY_NO = CC.SKD_VOY_NO" ).append("\n"); 
		query.append("  AND A.SKD_DIR_CD = CC.SKD_DIR_CD" ).append("\n"); 
		query.append("  AND A.PORT_CD  = CC.PORT_CD" ).append("\n"); 
		query.append("  AND A.SVC_SCP_CD = CC.SVC_SCP_CD" ).append("\n"); 
		query.append("  AND A.IO_BND_CD =  CC.IO_BND_CD" ).append("\n"); 
		query.append("  AND A.LOCL_CURR_CD = CC.LOCL_CURR_CD" ).append("\n"); 
		query.append("  AND A.CHG_CURR_CD = CC.CURR_CD" ).append("\n"); 
		query.append("  AND CC.XCH_RT_N3RD_TP_CD ='V'" ).append("\n"); 
		query.append("  AND CC.BL_SRC_NO IS NOT NULL" ).append("\n"); 
		query.append("  UNION ALL" ).append("\n"); 
		query.append("  SELECT DISTINCT CASE WHEN  COUNT(B.USD_LOCL_XCH_RT) = 0 THEN A.BL_SRC_NO" ).append("\n"); 
		query.append("				  WHEN    B.USD_LOCL_XCH_RT = 0  THEN A.BL_SRC_NO " ).append("\n"); 
		query.append("                  WHEN    B.USD_LOCL_XCH_RT > 0 AND  B.USD_LOCL_XCH_RT <>  A.INV_XCH_RT THEN  A.BL_SRC_NO" ).append("\n"); 
		query.append("                  ELSE   ''" ).append("\n"); 
		query.append("                  END BL_NOS " ).append("\n"); 
		query.append("FROM SINSC_TEMP A, GL_MON_XCH_RT B" ).append("\n"); 
		query.append("WHERE SUBSTR(A.GL_EFF_DT,0,6)  = B.ACCT_XCH_RT_YRMON(+)" ).append("\n"); 
		query.append("AND   A.XCH_RT_N3RD_TP_CD ='A'" ).append("\n"); 
		query.append("GROUP BY B.USD_LOCL_XCH_RT, A.BL_SRC_NO,  A.INV_XCH_RT" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}