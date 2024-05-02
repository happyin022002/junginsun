/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ARInvoiceInquiryDBDAOInvoiceDetailListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.10.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.10.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceInquiryDBDAOInvoiceDetailListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ARInvoiceInquiryDBDAOInvoiceDetailListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("office",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("scope",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_src_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("from_date",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("date_option",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("issue_flag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration").append("\n"); 
		query.append("FileName : ARInvoiceInquiryDBDAOInvoiceDetailListVORSQL").append("\n"); 
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
		query.append("SELECT  IO_BND_CD" ).append("\n"); 
		query.append("        , GOOD_DATE" ).append("\n"); 
		query.append("        , BL_SRC_NO" ).append("\n"); 
		query.append("        , AR_IF_NO" ).append("\n"); 
		query.append("		, INV_NO" ).append("\n"); 
		query.append("		, AUTO_INV_ISS_FLG" ).append("\n"); 
		query.append("        , REV_TP_CD" ).append("\n"); 
		query.append("        , CHG_CD" ).append("\n"); 
		query.append("        , CURR_CD" ).append("\n"); 
		query.append("        , INV_XCH_RT" ).append("\n"); 
		query.append("        , DP_PRCS_KNT" ).append("\n"); 
		query.append("        , LOCL_CURR_CD" ).append("\n"); 
		query.append("        , VVD" ).append("\n"); 
		query.append("        , ACT_CUST_SEQ" ).append("\n"); 
		query.append("        , CUST_NM" ).append("\n"); 
		query.append("        , AR_OFC_CD" ).append("\n"); 
		query.append("		, CRE_USR_ID" ).append("\n"); 
		query.append("		, USR_NM" ).append("\n"); 
		query.append("		, INV_RMK" ).append("\n"); 
		query.append("		, CHG_RMK" ).append("\n"); 
		query.append("		, TVA_FLG" ).append("\n"); 
		query.append("        #if (${office} == 'CMBSC')" ).append("\n"); 
		query.append("        , DECODE(IO_BND_CD,'I/B',DECODE(CUST_RGST_NO,'','FRT INV',DECODE(SPND_VAT_RGST_NO,'','VAT INV','SVAT INV')),'FRT INV') INV_TYPE" ).append("\n"); 
		query.append("        , CUST_RGST_NO" ).append("\n"); 
		query.append("        , SPND_VAT_RGST_NO" ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("        #if (${office} == 'BOMSC')		--2017.08.01 인도 GST 세법 변경 관련 보완" ).append("\n"); 
		query.append("		, PRO_INV_NO" ).append("\n"); 
		query.append("        , IDA_GST_RGST_NO" ).append("\n"); 
		query.append("        , IDA_STE_CD" ).append("\n"); 
		query.append("		, IDA_STE_NM" ).append("\n"); 
		query.append("		, IDA_PAN_NO" ).append("\n"); 
		query.append("		, IDA_SPCL_ECN_ZN_UT_FLG" ).append("\n"); 
		query.append("		, IDA_SAC_CD" ).append("\n"); 
		query.append("		, SUM(IDA_CGST_AMT) IDA_CGST_AMT" ).append("\n"); 
		query.append("		, SUM(IDA_SGST_AMT) IDA_SGST_AMT" ).append("\n"); 
		query.append("		, SUM(IDA_UGST_AMT) IDA_UGST_AMT" ).append("\n"); 
		query.append("		, SUM(IDA_IGST_AMT) IDA_IGST_AMT" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        , SUM(CHG_AMT)                          AS CHG_AMT" ).append("\n"); 
		query.append("        , SUM(ROUND(INV_LOCL_AMT, DP_PRCS_KNT)) AS INV_LOCL_AMT" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("         SELECT " ).append("\n"); 
		query.append("         #if (${date_option} == 'S')" ).append("\n"); 
		query.append("               /*+LEADING(D)*/" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("                 DECODE(A.IO_BND_CD, 'I', 'I/B', 'O', 'O/B') AS IO_BND_CD" ).append("\n"); 
		query.append("               , DECODE(@[date_option], 'I', A.BL_INV_IF_DT, 'G', A.BL_INV_CFM_DT, 'E', A.GL_EFF_DT, 'A', A.SAIL_ARR_DT" ).append("\n"); 
		query.append("               #if (${date_option} == 'S')" ).append("\n"); 
		query.append("                                      , 'S', D.ISS_DT" ).append("\n"); 
		query.append("               #end " ).append("\n"); 
		query.append("               #if (${date_option} == 'R')" ).append("\n"); 
		query.append("                                      , 'R', TO_CHAR(C.VPS_ETD_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("               #end " ).append("\n"); 
		query.append("                 )                                                 AS GOOD_DATE" ).append("\n"); 
		query.append("               , A.BL_SRC_NO" ).append("\n"); 
		query.append("			   , DECODE(A.INV_CLR_FLG,'Y','SYS CLEAR',A.INV_NO ) INV_NO  " ).append("\n"); 
		query.append("			   , CASE WHEN (SELECT MAX(NVL(AUTO_INV_ISS_FLG,'N')) FROM INV_AR_ISS WHERE INV_NO = A.INV_NO AND ISS_DT = A.ISS_DT) ='Y' THEN 'A'  ELSE 'M'  END  AUTO_INV_ISS_FLG                                                " ).append("\n"); 
		query.append("               , A.AR_IF_NO" ).append("\n"); 
		query.append("               , A.REV_TP_CD||REV_SRC_CD                           AS REV_TP_CD" ).append("\n"); 
		query.append("               , B.CHG_CD" ).append("\n"); 
		query.append("               , B.CURR_CD" ).append("\n"); 
		query.append("               , B.INV_XCH_RT" ).append("\n"); 
		query.append("               , B.CHG_AMT" ).append("\n"); 
		query.append("               , B.CHG_AMT * B.INV_XCH_RT                          AS INV_LOCL_AMT" ).append("\n"); 
		query.append("               , (" ).append("\n"); 
		query.append("               SELECT  DP_PRCS_KNT" ).append("\n"); 
		query.append("               FROM    MDM_CURRENCY S" ).append("\n"); 
		query.append("               WHERE   1=1" ).append("\n"); 
		query.append("               AND     S.CURR_CD = A.LOCL_CURR_CD" ).append("\n"); 
		query.append("               AND     ROWNUM    = 1" ).append("\n"); 
		query.append("               )                                                    AS DP_PRCS_KNT" ).append("\n"); 
		query.append("               , A.LOCL_CURR_CD" ).append("\n"); 
		query.append("               , A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD  AS VVD" ).append("\n"); 
		query.append("               , A.ACT_CUST_CNT_CD || LPAD(A.ACT_CUST_SEQ, 6, '0')  AS ACT_CUST_SEQ" ).append("\n"); 
		query.append("               , M.CUST_LGL_ENG_NM 	" ).append("\n"); 
		query.append("								AS CUST_NM" ).append("\n"); 
		query.append("               , A.AR_OFC_CD   " ).append("\n"); 
		query.append("			   , A.CRE_USR_ID" ).append("\n"); 
		query.append("			   , (SELECT USR_NM FROM COM_USER WHERE USR_ID = A.CRE_USR_ID) USR_NM" ).append("\n"); 
		query.append("			   , A.INV_RMK" ).append("\n"); 
		query.append("			   , B.CHG_RMK" ).append("\n"); 
		query.append("               ,DECODE(B.TVA_FLG,'Y','Taxable','Non-Taxable') TVA_FLG  " ).append("\n"); 
		query.append("               #if (${office} == 'CMBSC')" ).append("\n"); 
		query.append("               ,(SELECT CUST_RGST_NO FROM MDM_CUSTOMER WHERE CUST_CNT_CD = A.ACT_CUST_CNT_CD AND CUST_SEQ = A.ACT_CUST_SEQ) CUST_RGST_NO" ).append("\n"); 
		query.append("               ,(SELECT SPND_VAT_RGST_NO FROM INV_AR_SPND_VAT_RGST_NO WHERE A.ACT_CUST_CNT_CD = CUST_CNT_CD AND A.ACT_CUST_SEQ = CUST_SEQ) SPND_VAT_RGST_NO" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("			   #if (${office} == 'BOMSC')		--2017.08.01 인도 GST 세법 변경 관련 보완" ).append("\n"); 
		query.append("			   , (SELECT MAX(INV_NO)" ).append("\n"); 
		query.append("   				  FROM INV_AR_ISS_DTL" ).append("\n"); 
		query.append("   				  WHERE AR_IF_NO = A.AR_IF_NO" ).append("\n"); 
		query.append("   				  AND LENGTH(INV_NO) = 15" ).append("\n"); 
		query.append("   				  AND SUBSTR(INV_NO, 1, 1) = 'P') PRO_INV_NO" ).append("\n"); 
		query.append("			   , A.IDA_GST_RGST_NO" ).append("\n"); 
		query.append("			   , A.IDA_STE_CD" ).append("\n"); 
		query.append("			   , (SELECT STE_NM FROM MDM_STATE WHERE IDA_STE_CD = A.IDA_STE_CD AND NVL(DELT_FLG, 'N')='N') IDA_STE_NM" ).append("\n"); 
		query.append("			   , A.IDA_PAN_NO" ).append("\n"); 
		query.append("			   , A.IDA_SPCL_ECN_ZN_UT_FLG" ).append("\n"); 
		query.append("			   , B.IDA_SAC_CD" ).append("\n"); 
		query.append("			   , B.IDA_CGST_AMT" ).append("\n"); 
		query.append("			   , B.IDA_SGST_AMT" ).append("\n"); 
		query.append("			   , B.IDA_UGST_AMT" ).append("\n"); 
		query.append("			   , B.IDA_IGST_AMT" ).append("\n"); 
		query.append("			   #end" ).append("\n"); 
		query.append("               #if (${office} == 'ALL')" ).append("\n"); 
		query.append("               , (" ).append("\n"); 
		query.append("               -- LOGIN OFC? ?? RHQ OFC? ?? ??? ?? ISS OFC? RHQ OFC? ?? ?? ?? ???? ??.(Y)" ).append("\n"); 
		query.append("               SELECT  'Y'" ).append("\n"); 
		query.append("               FROM    MDM_ORGANIZATION M1," ).append("\n"); 
		query.append("                       MDM_ORGANIZATION M2" ).append("\n"); 
		query.append("               WHERE   M1.OFC_CD           = @[user_ofc_cd]" ).append("\n"); 
		query.append("               AND     M1.AR_HD_QTR_OFC_CD = M2.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("               AND     M2.AR_OFC_CD        = A.AR_OFC_CD" ).append("\n"); 
		query.append("               AND     ROWNUM              = 1" ).append("\n"); 
		query.append("               )                                                    AS CHK1" ).append("\n"); 
		query.append("               #else" ).append("\n"); 
		query.append("              , DECODE(A.AR_OFC_CD, @[office], 'Y')                AS CHK1" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("        #if (${date_option} == 'S')" ).append("\n"); 
		query.append("           #if (${office} == 'ALL')" ).append("\n"); 
		query.append("               , (" ).append("\n"); 
		query.append("                -- LOGIN OFC? ?? RHQ OFC? ?? ??? ?? ISS OFC? RHQ OFC? ?? ?? ?? ???? ??.(Y)" ).append("\n"); 
		query.append("                SELECT 'Y'" ).append("\n"); 
		query.append("                FROM    MDM_ORGANIZATION M1," ).append("\n"); 
		query.append("                        MDM_ORGANIZATION M2" ).append("\n"); 
		query.append("                WHERE   M1.OFC_CD           = @[user_ofc_cd]" ).append("\n"); 
		query.append("                AND     M2.AR_HD_QTR_OFC_CD = M2.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                AND     M2.OFC_CD           = D.ISS_OFC_CD" ).append("\n"); 
		query.append("                AND     ROWNUM              = 1" ).append("\n"); 
		query.append("               )                                                    AS CHK2" ).append("\n"); 
		query.append("           #else" ).append("\n"); 
		query.append("               ,(" ).append("\n"); 
		query.append("               -- ?? ??? AR OFC? ?? OFC? ?? ??? ?? ISS OFC? ?? ?? ???? ??.(Y)" ).append("\n"); 
		query.append("               SELECT 'Y'" ).append("\n"); 
		query.append("               FROM    MDM_ORGANIZATION S" ).append("\n"); 
		query.append("               WHERE   S.AR_OFC_CD         = @[office]" ).append("\n"); 
		query.append("               AND     S.OFC_CD            = D.ISS_OFC_CD" ).append("\n"); 
		query.append("               AND     ROWNUM              = 1" ).append("\n"); 
		query.append("               )                                                    AS CHK2" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("       FROM    INV_AR_MN        A" ).append("\n"); 
		query.append("             , INV_AR_CHG       B" ).append("\n"); 
		query.append("             , MDM_CUSTOMER		M" ).append("\n"); 
		query.append("        #if (${date_option} == 'S')" ).append("\n"); 
		query.append("             , INV_AR_ISS_DTL   C" ).append("\n"); 
		query.append("             , INV_AR_ISS       D" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${date_option} == 'R')" ).append("\n"); 
		query.append("             , VSK_VSL_PORT_SKD  C" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("       WHERE   A.AR_IF_NO       = B.AR_IF_NO" ).append("\n"); 
		query.append("       AND     A.ACT_CUST_CNT_CD = M.CUST_CNT_CD" ).append("\n"); 
		query.append("       AND     A.ACT_CUST_SEQ 	= M.CUST_SEQ" ).append("\n"); 
		query.append("       #if (${date_option} == 'S')" ).append("\n"); 
		query.append("       AND     B.AR_IF_NO       = C.AR_IF_NO" ).append("\n"); 
		query.append("       AND     B.CHG_SEQ        = C.CHG_SEQ" ).append("\n"); 
		query.append("       AND     C.INV_NO         = D.INV_NO" ).append("\n"); 
		query.append("	   AND     A.INV_NO 		= D.INV_NO" ).append("\n"); 
		query.append("       AND     D.ISS_DT        >= REPLACE(@[from_date]  ,'-','')" ).append("\n"); 
		query.append("       AND     D.ISS_DT        <= REPLACE(@[to_date]    ,'-','')" ).append("\n"); 
		query.append("       AND     D.INV_SEQ        = 1" ).append("\n"); 
		query.append("       AND     D.ISS_OFC_CD   IN (SELECT OFC_CD FROM MDM_ORGANIZATION WHERE AR_OFC_CD = @[office])" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${date_option} == 'R')" ).append("\n"); 
		query.append("       AND     A.VSL_CD         = C.VSL_CD" ).append("\n"); 
		query.append("       AND     A.SKD_VOY_NO     = C.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND     A.SKD_DIR_CD     = C.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND     A.POL_CD         = C.VPS_PORT_CD" ).append("\n"); 
		query.append("       AND     C.VPS_ETD_DT  BETWEEN TO_DATE(REPLACE(@[from_date],'-',''),'YYYYMMDD') AND TO_DATE(REPLACE(@[to_date],'-',''),'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${office} != 'ALL')" ).append("\n"); 
		query.append("       AND     A.AR_OFC_CD      = @[office]" ).append("\n"); 
		query.append("	   #else" ).append("\n"); 
		query.append("       AND A.AR_OFC_CD IN (" ).append("\n"); 
		query.append("                           SELECT DISTINCT M2.AR_OFC_CD" ).append("\n"); 
		query.append("                             FROM MDM_ORGANIZATION M1," ).append("\n"); 
		query.append("                                  MDM_ORGANIZATION M2," ).append("\n"); 
		query.append("                                  COM_SYS_AREA_GRP_ID C1" ).append("\n"); 
		query.append("                            WHERE M1.AR_HD_QTR_OFC_CD = M2.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                              AND SUBSTR(M2.LOC_CD,1,2) = C1.CNT_CD " ).append("\n"); 
		query.append("                              AND M1.OFC_CD = @[user_ofc_cd]" ).append("\n"); 
		query.append("                              AND M2.AR_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("                              AND C1.SYS_AREA_GRP_ID = (SELECT DECODE(SYS_AREA_GRP_ID, 'CHN', 'CHN', C1.SYS_AREA_GRP_ID) " ).append("\n"); 
		query.append("                                                        FROM   COM_SYS_AREA_GRP_ID " ).append("\n"); 
		query.append("                                                        WHERE  CO_IND_CD = 'H'" ).append("\n"); 
		query.append("                                                        AND    CNT_CD = (SELECT SUBSTR(LOC_CD, 1, 2) " ).append("\n"); 
		query.append("                                                                         FROM   MDM_ORGANIZATION " ).append("\n"); 
		query.append("                                                                         WHERE  OFC_CD = @[user_ofc_cd]))" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${date_option} == 'I')" ).append("\n"); 
		query.append("       AND     A.BL_INV_IF_DT   >= REPLACE(@[from_date] ,'-','')" ).append("\n"); 
		query.append("       AND     A.BL_INV_IF_DT   <= REPLACE(@[to_date]   ,'-','')" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${date_option} == 'G')" ).append("\n"); 
		query.append("       AND     A.BL_INV_CFM_DT  >= REPLACE(@[from_date] ,'-','')" ).append("\n"); 
		query.append("       AND     A.BL_INV_CFM_DT  <= REPLACE(@[to_date]   ,'-','')" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${date_option} == 'E')" ).append("\n"); 
		query.append("       AND     A.GL_EFF_DT      >= REPLACE(@[from_date] ,'-','')" ).append("\n"); 
		query.append("       AND     A.GL_EFF_DT      <= REPLACE(@[to_date]   ,'-','')" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${date_option} == 'A')						" ).append("\n"); 
		query.append("       AND     A.SAIL_ARR_DT      >= REPLACE(@[from_date] ,'-','')						" ).append("\n"); 
		query.append("       AND     A.SAIL_ARR_DT      <= REPLACE(@[to_date]   ,'-','')						" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       AND     NVL(A.INV_DELT_DIV_CD,'N') <>'Y'" ).append("\n"); 
		query.append("       #if (${issue_flag} != '')" ).append("\n"); 
		query.append("       AND     A.INV_ISS_FLG     = @[issue_flag]" ).append("\n"); 
		query.append("       AND     B.INV_ISS_FLG     = @[issue_flag]" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${issue_flag} == 'N')" ).append("\n"); 
		query.append("       AND     A.INV_CLR_FLG     = 'N'" ).append("\n"); 
		query.append("       AND     B.INV_CLR_FLG     = 'N'" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${vvd} != '')" ).append("\n"); 
		query.append("       AND     A.VSL_CD          = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("       AND     A.SKD_VOY_NO      = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("       AND     A.SKD_DIR_CD      = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${port} != '')" ).append("\n"); 
		query.append("       AND      @[port]          = DECODE(A.IO_BND_CD, 'O', A.POL_CD, 'I', A.POD_CD)" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${scope} != '')" ).append("\n"); 
		query.append("       AND     A.SVC_SCP_CD      = @[scope]" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${bound} != '')" ).append("\n"); 
		query.append("       AND     A.IO_BND_CD       = @[bound]" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${chg_cd} != '' && ${chg_cd} != 'ALL')" ).append("\n"); 
		query.append("       AND     B.CHG_CD          = @[chg_cd]" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${act_cust_cnt_cd} != '')" ).append("\n"); 
		query.append("       AND     A.ACT_CUST_CNT_CD = @[act_cust_cnt_cd]" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${act_cust_seq} != '')" ).append("\n"); 
		query.append("       AND     A.ACT_CUST_SEQ    = @[act_cust_seq]" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${rev_tp_cd} != '')" ).append("\n"); 
		query.append("       AND     A.REV_TP_CD       = @[rev_tp_cd]" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${rev_src_cd} != '')" ).append("\n"); 
		query.append("       AND     A.REV_SRC_CD      IN (@[rev_src_cd])" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${lcl_chg} == 'Y')" ).append("\n"); 
		query.append("       AND          B.REV_COA_ACCT_CD = '954117'" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("WHERE    1=1" ).append("\n"); 
		query.append("AND      CHK1 = 'Y'" ).append("\n"); 
		query.append("#if (${date_option} == 'S')" ).append("\n"); 
		query.append("AND      CHK2 = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY IO_BND_CD" ).append("\n"); 
		query.append("       , GOOD_DATE" ).append("\n"); 
		query.append("       , BL_SRC_NO" ).append("\n"); 
		query.append("       , AR_IF_NO" ).append("\n"); 
		query.append("	   , INV_NO" ).append("\n"); 
		query.append("	   , AUTO_INV_ISS_FLG" ).append("\n"); 
		query.append("       , REV_TP_CD" ).append("\n"); 
		query.append("       , CHG_CD" ).append("\n"); 
		query.append("       , CURR_CD" ).append("\n"); 
		query.append("       , INV_XCH_RT" ).append("\n"); 
		query.append("       , VVD" ).append("\n"); 
		query.append("       , ACT_CUST_SEQ" ).append("\n"); 
		query.append("       , CUST_NM" ).append("\n"); 
		query.append("       , LOCL_CURR_CD" ).append("\n"); 
		query.append("       , DP_PRCS_KNT" ).append("\n"); 
		query.append("       , AR_OFC_CD" ).append("\n"); 
		query.append("	   , CRE_USR_ID" ).append("\n"); 
		query.append("	   , USR_NM" ).append("\n"); 
		query.append("	   , INV_RMK" ).append("\n"); 
		query.append("	   , CHG_RMK" ).append("\n"); 
		query.append("	   , TVA_FLG" ).append("\n"); 
		query.append("       #if (${office} == 'CMBSC')" ).append("\n"); 
		query.append("       , CUST_RGST_NO" ).append("\n"); 
		query.append("       , SPND_VAT_RGST_NO" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("	   #if (${office} == 'BOMSC')		--2017.08.01 인도 GST 세법 변경 관련 보완" ).append("\n"); 
		query.append("	   , PRO_INV_NO" ).append("\n"); 
		query.append("       , IDA_GST_RGST_NO" ).append("\n"); 
		query.append("       , IDA_STE_CD" ).append("\n"); 
		query.append("	   , IDA_STE_NM" ).append("\n"); 
		query.append("	   , IDA_PAN_NO" ).append("\n"); 
		query.append("	   , IDA_SPCL_ECN_ZN_UT_FLG" ).append("\n"); 
		query.append("	   , IDA_SAC_CD" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("ORDER BY AR_OFC_CD, GOOD_DATE, BL_SRC_NO" ).append("\n"); 

	}
}