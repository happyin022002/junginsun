/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ARInvoiceInquiryDBDAOSearchInvoiceSGNBBVatListByDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.21
*@LastModifier : 
*@LastVersion : 1.0
* 2012.03.21 
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

public class ARInvoiceInquiryDBDAOSearchInvoiceSGNBBVatListByDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ARInvoiceInquiryDBDAOSearchInvoiceSGNBBVatListByDateRSQL(){
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
		params.put("iss_to_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("iss_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration").append("\n"); 
		query.append("FileName : ARInvoiceInquiryDBDAOSearchInvoiceSGNBBVatListByDateRSQL").append("\n"); 
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
		query.append("SELECT  A.INV_TYPE" ).append("\n"); 
		query.append("        ,A.ISS_DT" ).append("\n"); 
		query.append("        ,A.INV_NO" ).append("\n"); 
		query.append("        ,A.ACT_INV_NO" ).append("\n"); 
		query.append("        ,A.ACT_CUST_CD" ).append("\n"); 
		query.append("        ,NVL(G.LOCL_NM, E.CUST_LGL_ENG_NM) CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("        ,E.CUST_RGST_NO" ).append("\n"); 
		query.append("        ,rtrim(XMLAGG(XMLELEMENT(A, BL_SRC_NO, ',') ORDER BY A.INV_NO,A.BL_SRC_NO).EXTRACT( '//text()'), ',') BL_SRC_NO  " ).append("\n"); 
		query.append("        ,ROUND(SUM(A.NET_AMT),0) NET_AMT" ).append("\n"); 
		query.append("        ,ROUND(SUM(A.VAT_AMT),0) VAT_AMT" ).append("\n"); 
		query.append("        ,ROUND((SUM(A.NET_AMT) + SUM(A.VAT_AMT)),0) GROSS_AMT" ).append("\n"); 
		query.append("        ,ROUND(ROUND((SUM(A.NET_AMT) + SUM(A.VAT_AMT)),0) / A.INV_XCH_RT2, 2) USD_AMT  -- 2012.03.20 USD AMOUNT = GROSS AMOUNT * DAILY 환율" ).append("\n"); 
		query.append("        ,A.INV_XCH_RT2 INV_XCH_RT" ).append("\n"); 
		query.append("        ,A.IO_BND_CD" ).append("\n"); 
		query.append("        ,A.UPD_USR_ID             " ).append("\n"); 
		query.append("FROM    (        " ).append("\n"); 
		query.append("        SELECT  DECODE(SUBSTR(C.INV_NO,1,1),'T','THC','H','DHF','F','FRT','D','DMR','R','ADV','M','MRI','S','SLF','C','CLN', 'E', 'REF', 'X', 'ETC') INV_TYPE" ).append("\n"); 
		query.append("                ,C.ISS_DT" ).append("\n"); 
		query.append("                ,C.INV_NO" ).append("\n"); 
		query.append("                ,C.ACT_INV_NO" ).append("\n"); 
		query.append("                ,(SELECT K1.ACT_CUST_CNT_CD||'-'||LPAD(K1.ACT_CUST_SEQ,6,'0')" ).append("\n"); 
		query.append("                    FROM INV_AR_MN K1 " ).append("\n"); 
		query.append("                    WHERE K1.AR_IF_NO = (SELECT MAX(K2.AR_IF_NO) FROM INV_AR_ISS_DTL K2" ).append("\n"); 
		query.append("                                         WHERE K2.INV_NO = C.INV_NO)" ).append("\n"); 
		query.append("                 ) ACT_CUST_CD" ).append("\n"); 
		query.append("                ,C.BL_SRC_NO                " ).append("\n"); 
		query.append("                 ,NVL((CASE  WHEN SUBSTR(C.INV_NO, 1,1) ='D' THEN SUM(DECODE(C.CHG_CD, 'TVA',0, 'IVA',0, C.CHG_AMT) * DECODE(C.CURR_CD, 'USD', C.INV_XCH_RT2, C.INV_XCH_RT))" ).append("\n"); 
		query.append("                             WHEN SUBSTR(C.INV_NO, 1,1) ='M' THEN SUM(DECODE(C.CHG_CD, 'TVA',0, 'IVA',0, C.CHG_AMT) * DECODE(C.CURR_CD, 'USD', C.INV_XCH_RT2, C.INV_XCH_RT))" ).append("\n"); 
		query.append("                             WHEN SUBSTR(C.INV_NO, 1,1) ='T' THEN SUM(DECODE(C.CHG_CD, 'VTT',0, C.CHG_AMT) * DECODE(C.CURR_CD, 'USD', C.INV_XCH_RT2, C.INV_XCH_RT))" ).append("\n"); 
		query.append("                             WHEN SUBSTR(C.INV_NO, 1,1) ='S' THEN SUM(DECODE(C.CHG_CD, 'VST',0, C.CHG_AMT) * DECODE(C.CURR_CD, 'USD', C.INV_XCH_RT2, C.INV_XCH_RT))" ).append("\n"); 
		query.append("                             WHEN SUBSTR(C.INV_NO, 1,1) ='C' THEN SUM(DECODE(C.CHG_CD, 'VCT',0, C.CHG_AMT) * DECODE(C.CURR_CD, 'USD', C.INV_XCH_RT2, C.INV_XCH_RT))" ).append("\n"); 
		query.append("                             WHEN SUBSTR(C.INV_NO, 1,1) ='R' THEN SUM(C.CHG_AMT * DECODE(C.CURR_CD, 'USD', C.INV_XCH_RT2, C.INV_XCH_RT)) *0.975" ).append("\n"); 
		query.append("                             WHEN SUBSTR(C.INV_NO, 1,1) ='H' THEN SUM(DECODE(C.CHG_CD, 'VDT',0, C.CHG_AMT) * DECODE(C.CURR_CD, 'USD', C.INV_XCH_RT2, C.INV_XCH_RT))" ).append("\n"); 
		query.append("                             WHEN SUBSTR(C.INV_NO, 1,1) ='F' THEN SUM(C.CHG_AMT * DECODE(C.CURR_CD, 'USD', C.INV_XCH_RT2, C.INV_XCH_RT))     -- 2012.03.09" ).append("\n"); 
		query.append("                             WHEN SUBSTR(C.INV_NO, 1,1) ='E' THEN SUM(DECODE(C.CHG_CD, 'VRT', 0, C.CHG_AMT) * C.INV_XCH_RT2)     -- 2012.03.09" ).append("\n"); 
		query.append("                             WHEN SUBSTR(C.INV_NO, 1,1) ='X' THEN SUM(DECODE(C.CHG_CD, 'TVA',0, 'VET',0, C.CHG_AMT) * DECODE(C.CURR_CD, 'USD', C.INV_XCH_RT2, C.INV_XCH_RT))     -- 2012.03.09" ).append("\n"); 
		query.append("                             ELSE SUM(C.CHG_AMT * DECODE(C.CURR_CD, 'USD',1, C.INV_XCH_RT/C.INV_XCH_RT2))" ).append("\n"); 
		query.append("                        END  ),0)  NET_AMT" ).append("\n"); 
		query.append("                ,NVL((CASE  WHEN SUBSTR(C.INV_NO, 1,1) ='F' THEN 0" ).append("\n"); 
		query.append("                        WHEN SUBSTR(C.INV_NO, 1,1) ='R' THEN SUM(C.CHG_AMT * DECODE(C.CURR_CD, 'USD', C.INV_XCH_RT2, C.INV_XCH_RT)) * 0.025" ).append("\n"); 
		query.append("                        WHEN SUBSTR(C.INV_NO, 1,1) ='D' THEN (SUM(DECODE(C.CHG_CD, 'TVA',0, 'IVA',0, C.CHG_AMT) * DECODE(C.CURR_CD, 'USD', C.INV_XCH_RT2, C.INV_XCH_RT))/ 0.95*0.05) -- (SUM(C.CHG_AMT* DECODE(C.CURR_CD, 'USD', C.INV_XCH_RT2, C.INV_XCH_RT)))" ).append("\n"); 
		query.append("                        WHEN SUBSTR(C.INV_NO, 1,1) ='M' THEN SUM(DECODE(C.CHG_CD,'TVA',C.CHG_AMT,'IVA',C.CHG_AMT, 0) * DECODE(C.CURR_CD, 'USD', C.INV_XCH_RT2, C.INV_XCH_RT))" ).append("\n"); 
		query.append("                        WHEN SUBSTR(C.INV_NO, 1,1) ='H' THEN SUM(DECODE(C.CHG_CD, 'VDT',0, C.CHG_AMT) * DECODE(C.CURR_CD, 'USD', C.INV_XCH_RT2, C.INV_XCH_RT)) / 0.95 * 0.05     -- 2012.03.09" ).append("\n"); 
		query.append("                        WHEN SUBSTR(C.INV_NO, 1,1) ='T' THEN CASE WHEN C.ISS_DT < '20100101' THEN SUM(DECODE(C.CHG_CD,'VTT',0, C.CHG_AMT))* DECODE(C.CURR_CD, 'USD', C.INV_XCH_RT2, C.INV_XCH_RT) / 0.975*0.025" ).append("\n"); 
		query.append("                                                                  ELSE SUM(DECODE(C.CHG_CD,'VTT',0,C.CHG_AMT)* DECODE(C.CURR_CD, 'USD', C.INV_XCH_RT2, C.INV_XCH_RT)) / 0.95*0.05 " ).append("\n"); 
		query.append("                                                                  END " ).append("\n"); 
		query.append("                        WHEN SUBSTR(C.INV_NO, 1,1) ='S' THEN SUM(DECODE(C.CHG_CD, 'VST',0, C.CHG_AMT) * DECODE(C.CURR_CD, 'USD', C.INV_XCH_RT2, C.INV_XCH_RT)) / 0.95 * 0.05     -- 2012.03.09" ).append("\n"); 
		query.append("                        WHEN SUBSTR(C.INV_NO, 1,1) ='C' THEN SUM(DECODE(C.CHG_CD, 'VCT',0, C.CHG_AMT) * DECODE(C.CURR_CD, 'USD', C.INV_XCH_RT2, C.INV_XCH_RT)) / 0.95 * 0.05     -- 2012.03.09" ).append("\n"); 
		query.append("                        WHEN SUBSTR(C.INV_NO, 1,1) ='E' THEN SUM(DECODE(C.CHG_CD, 'VRT', 0, C.CHG_AMT) * C.INV_XCH_RT2) / 0.95 * 0.05     -- 2012.03.09" ).append("\n"); 
		query.append("                        WHEN SUBSTR(C.INV_NO, 1,1) ='X' THEN SUM(DECODE(C.CHG_CD, 'TVA',0, 'VET',0, C.CHG_AMT) * DECODE(C.CURR_CD, 'USD', C.INV_XCH_RT2, C.INV_XCH_RT)) / 0.95 * 0.05    -- 2012.03.09" ).append("\n"); 
		query.append("                        ELSE ROUND(sum(C.CHG_AMT), 0)" ).append("\n"); 
		query.append("                        END),0) VAT_AMT" ).append("\n"); 
		query.append("                ,C.INV_XCH_RT" ).append("\n"); 
		query.append("				,C.INV_XCH_RT2" ).append("\n"); 
		query.append("                ,DECODE(C.IO_BND_CD,'O','O/B','I/B') IO_BND_CD" ).append("\n"); 
		query.append("                ,C.UPD_USR_ID" ).append("\n"); 
		query.append("            FROM (    " ).append("\n"); 
		query.append("                        SELECT  A.INV_NO" ).append("\n"); 
		query.append("                                ,A.ISS_DT" ).append("\n"); 
		query.append("                                ,A.ACT_INV_NO" ).append("\n"); 
		query.append("                                ,D.BL_SRC_NO" ).append("\n"); 
		query.append("                                ,C.CHG_CD" ).append("\n"); 
		query.append("                                ,(CASE WHEN (SUBSTR(A.INV_NO, 1,1)= 'H' OR SUBSTR(A.INV_NO, 1,1)= 'C') AND (C.CURR_CD <> 'VND' AND C.CURR_CD <> 'USD') THEN C.CHG_AMT/G.USD_LOCL_XCH_RT*H.USD_LOCL_XCH_RT " ).append("\n"); 
		query.append("                                            WHEN (SUBSTR(A.INV_NO, 1,1)= 'F' OR SUBSTR(A.INV_NO, 1,1)= 'T' OR SUBSTR(A.INV_NO, 1,1)= 'D' OR SUBSTR(A.INV_NO, 1,1)= 'R' OR SUBSTR(A.INV_NO, 1,1)= 'M' OR SUBSTR(A.INV_NO, 1,1)= 'S') AND (C.CURR_CD <> 'VND' AND C.CURR_CD <> 'USD') THEN C.CHG_AMT/G.USD_LOCL_XCH_RT                    " ).append("\n"); 
		query.append("                                            ELSE C.CHG_AMT END) CHG_AMT" ).append("\n"); 
		query.append("                                ,C.CURR_CD" ).append("\n"); 
		query.append("                                ,F.INV_XCH_RT INV_XCH_RT2" ).append("\n"); 
		query.append("                                ,C.INV_XCH_RT" ).append("\n"); 
		query.append("                                ,D.IO_BND_CD" ).append("\n"); 
		query.append("                                ,A.UPD_USR_ID" ).append("\n"); 
		query.append("                                ,G.USD_LOCL_XCH_RT -- USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                ,H.USD_LOCL_XCH_RT -- VND_LOCL_XCH_RT" ).append("\n"); 
		query.append("                        FROM    INV_AR_ISS A" ).append("\n"); 
		query.append("                                ,INV_AR_ISS_DTL B" ).append("\n"); 
		query.append("                                ,INV_AR_CHG C" ).append("\n"); 
		query.append("                                ,INV_AR_MN D" ).append("\n"); 
		query.append("                                ,INV_CUST_AND_DLY_XCH_RT F" ).append("\n"); 
		query.append("                                ,GL_MON_XCH_RT G" ).append("\n"); 
		query.append("                                ,GL_MON_XCH_RT H" ).append("\n"); 
		query.append("                        WHERE   A.INV_NO = B.INV_NO" ).append("\n"); 
		query.append("                        AND     A.INV_SEQ = 1" ).append("\n"); 
		query.append("                        AND     B.AR_IF_NO = C.AR_IF_NO" ).append("\n"); 
		query.append("                        AND     B.CHG_SEQ = C.CHG_SEQ" ).append("\n"); 
		query.append("                        AND     C.AR_IF_NO = D.AR_IF_NO" ).append("\n"); 
		query.append("                        AND     F.IO_BND_CD = D.IO_BND_CD" ).append("\n"); 
		query.append("                        AND     F.LOCL_CURR_CD = D.LOCL_CURR_CD" ).append("\n"); 
		query.append("                        AND     F.CUST_CNT_CD = 'XX'" ).append("\n"); 
		query.append("                        AND     F.CUST_SEQ = '0'" ).append("\n"); 
		query.append("                        AND     F.CHG_CURR_CD = 'USD'" ).append("\n"); 
		query.append("                        AND     G.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("                        AND     G.CURR_CD = C.CURR_CD" ).append("\n"); 
		query.append("                        AND     G.ACCT_XCH_RT_YRMON = SUBSTR(D.SAIL_DT,0,6)" ).append("\n"); 
		query.append("                        AND     H.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("                        AND     H.CURR_CD = 'VND'" ).append("\n"); 
		query.append("                        AND     H.ACCT_XCH_RT_YRMON = SUBSTR(D.SAIL_DT,0,6)" ).append("\n"); 
		query.append("                        AND     A.ISS_DT BETWEEN F.FM_DT AND F.TO_DT" ).append("\n"); 
		query.append("		         		AND     F.AR_OFC_CD = D.AR_OFC_CD" ).append("\n"); 
		query.append("		         		AND     D.INV_DELT_DIV_CD <>'Y'" ).append("\n"); 
		query.append("		         		AND     A.ISS_DT BETWEEN REPLACE(@[iss_fm_dt], '-', '') AND REPLACE(@[iss_to_dt], '-', '')" ).append("\n"); 
		query.append("		         		AND     A.ISS_OFC_CD IN (SELECT OFC_CD" ).append("\n"); 
		query.append("		                                           FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("		                                          WHERE AR_OFC_CD = @[office])" ).append("\n"); 
		query.append("		         		AND 	D.AR_OFC_CD = @[office]" ).append("\n"); 
		query.append("						#if (${act_cust_cnt_cd} != '')" ).append("\n"); 
		query.append("			  			AND 	D.ACT_CUST_CNT_CD = @[act_cust_cnt_cd]" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						#if (${act_cust_seq} != '')" ).append("\n"); 
		query.append("			  			AND 	D.ACT_CUST_SEQ = @[act_cust_seq]" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("			  			AND 	D.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						#if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("			  			AND 	D.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						#if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("			  			AND 	D.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						#if (${bound} != '')  " ).append("\n"); 
		query.append("			  			AND 	D.IO_BND_CD = @[bound]" ).append("\n"); 
		query.append("						#if ((${bound} == 'I') && (${port} != ''))" ).append("\n"); 
		query.append("			  			AND 	D.POD_CD = @[port]" ).append("\n"); 
		query.append("						#elseif ((${bound} == 'O') && (${port} != ''))" ).append("\n"); 
		query.append("			  			AND 	D.POL_CD = @[port]" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						#else" ).append("\n"); 
		query.append("						#if (${port} != '')" ).append("\n"); 
		query.append("			  			AND 	((D.IO_BND_CD = 'I' AND D.POD_CD = @[port]) OR (D.IO_BND_CD = 'O' AND D.POL_CD = @[port]))" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						#if (${categories} != '')" ).append("\n"); 
		query.append("							#if (${categories} == 'HJS')" ).append("\n"); 
		query.append("							AND C.CHG_CD NOT IN ('SLF','CLN')" ).append("\n"); 
		query.append("							#else" ).append("\n"); 
		query.append("							AND C.CHG_CD IN ('SLF','CLN')" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("            ) C                     " ).append("\n"); 
		query.append("        GROUP BY DECODE(SUBSTR(C.INV_NO,1,1),'T','THC','H','DHF','F','FRT','D','DMR','R','ADV','M','MRI','S','SLF','C','CLN')" ).append("\n"); 
		query.append("                ,C.ISS_DT" ).append("\n"); 
		query.append("                ,C.INV_NO" ).append("\n"); 
		query.append("                ,C.ACT_INV_NO" ).append("\n"); 
		query.append("                ,C.BL_SRC_NO" ).append("\n"); 
		query.append("                ,C.INV_XCH_RT2" ).append("\n"); 
		query.append("                ,C.IO_BND_CD" ).append("\n"); 
		query.append("                ,C.UPD_USR_ID " ).append("\n"); 
		query.append("                ,C.CURR_CD " ).append("\n"); 
		query.append("                ,C.INV_XCH_RT " ).append("\n"); 
		query.append(") A,  MDM_CUSTOMER E, MDM_CR_CUST G" ).append("\n"); 
		query.append("    WHERE   SUBSTR(A.ACT_CUST_CD,0,2) = E.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("    AND     TO_NUMBER(SUBSTR(A.ACT_CUST_CD,4,7)) = E.CUST_SEQ(+)" ).append("\n"); 
		query.append("    AND     SUBSTR(A.ACT_CUST_CD,0,2) = G.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("    AND     TO_NUMBER(SUBSTR(A.ACT_CUST_CD,4,7)) = G.CUST_SEQ(+)" ).append("\n"); 
		query.append("    GROUP BY A.INV_TYPE" ).append("\n"); 
		query.append("        ,A.ISS_DT" ).append("\n"); 
		query.append("        ,A.INV_NO" ).append("\n"); 
		query.append("        ,A.ACT_INV_NO" ).append("\n"); 
		query.append("        ,A.ACT_CUST_CD" ).append("\n"); 
		query.append("        ,NVL(G.LOCL_NM, E.CUST_LGL_ENG_NM)" ).append("\n"); 
		query.append("        ,E.CUST_RGST_NO" ).append("\n"); 
		query.append("        ,A.INV_XCH_RT2" ).append("\n"); 
		query.append("        ,A.IO_BND_CD" ).append("\n"); 
		query.append("        ,A.UPD_USR_ID  " ).append("\n"); 
		query.append("    ORDER BY INV_TYPE, ISS_DT, INV_NO" ).append("\n"); 

	}
}