/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchEBkgSiUploadStsListByPendingRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.11
*@LastModifier : 최문환
*@LastVersion : 1.0
* 2013.06.11 최문환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Moonhwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchEBkgSiUploadStsListByPendingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * e-BKG & S/I Upload Status Report - ESM_BKG_0226
	  * Report Type이 Pending Report
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchEBkgSiUploadStsListByPendingRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("duration_month",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gso",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doc_tp_s",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("duration_year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("duration_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("duration_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("duration_to_week",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sal_ofc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("duration_from_week",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doc_tp_b",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("region_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchEBkgSiUploadStsListByPendingRSQL").append("\n"); 
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
		query.append("SELECT REGION_CD" ).append("\n"); 
		query.append(",	   GSO" ).append("\n"); 
		query.append(",	   BKG_OFC" ).append("\n"); 
		query.append(",      MON" ).append("\n"); 
		query.append(",      B_TTL" ).append("\n"); 
		query.append(",      B_X" ).append("\n"); 
		query.append(",      B_F" ).append("\n"); 
		query.append(",      B_R" ).append("\n"); 
		query.append(",      B_D" ).append("\n"); 
		query.append(",      B_P" ).append("\n"); 
		query.append(",	 TO_CHAR(100 - TRUNC(B_P/DECODE(B_TTL,0,1,B_TTL),4)*100) B_PF" ).append("\n"); 
		query.append(",      S_TTL" ).append("\n"); 
		query.append(",      S_X" ).append("\n"); 
		query.append(",      S_F" ).append("\n"); 
		query.append(",      S_R" ).append("\n"); 
		query.append(",      S_D" ).append("\n"); 
		query.append(",      S_P" ).append("\n"); 
		query.append(",      TO_CHAR(100 - TRUNC(S_P/DECODE(S_TTL,0,1,S_TTL),4)*100) S_PF" ).append("\n"); 
		query.append(",	''	SORT" ).append("\n"); 
		query.append(",	''  DOC_TP_CD" ).append("\n"); 
		query.append(",	''	DOC_TP_B" ).append("\n"); 
		query.append(",	''	DOC_TP_S" ).append("\n"); 
		query.append(",	''	BKG_UPLD_STS_CD" ).append("\n"); 
		query.append(",	''	XTER_RQST_NO" ).append("\n"); 
		query.append(",	''	POR_CD" ).append("\n"); 
		query.append(",	''	POL_CD" ).append("\n"); 
		query.append(",	''	POD_CD" ).append("\n"); 
		query.append(",	''	DEL_CD" ).append("\n"); 
		query.append(",	''	DELAY" ).append("\n"); 
		query.append(",	''	BKG_NO" ).append("\n"); 
		query.append(",	''	LS_FROM_DT" ).append("\n"); 
		query.append(",	''	LS_TO_DT" ).append("\n"); 
		query.append(",	''	SERVER_ID" ).append("\n"); 
		query.append(",	''	SAL_OFC" ).append("\n"); 
		query.append(",	''  DURATION" ).append("\n"); 
		query.append(",	''  FR_DT" ).append("\n"); 
		query.append(",	''  TO_DT" ).append("\n"); 
		query.append(",	''  REPORT_TYPE" ).append("\n"); 
		query.append(", 	'' DURATION_YEAR" ).append("\n"); 
		query.append(", 	'' DURATION_MONTH" ).append("\n"); 
		query.append(", 	'' DURATION_FROM_WEEK" ).append("\n"); 
		query.append(", 	'' DURATION_TO_WEEK" ).append("\n"); 
		query.append(", 	'' DURATION_FROM_DT" ).append("\n"); 
		query.append(", 	'' DURATION_TO_DT" ).append("\n"); 
		query.append(",	'' TOTAL_CNT" ).append("\n"); 
		query.append(",	'' ROW_NUM	" ).append("\n"); 
		query.append(",	'' I_PAGE_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("	 -----------------------------------------------------------------------------" ).append("\n"); 
		query.append("      SELECT  A_IB.REGION_CD" ).append("\n"); 
		query.append("	  ,		  A_IB.GSO GSO" ).append("\n"); 
		query.append("      ,       A_IB.BKG_OFC" ).append("\n"); 
		query.append("      ,       TO_CHAR(A_IB.UPLD_DT,'YYYY-MM') MON" ).append("\n"); 
		query.append("      ,       SUM(DECODE(AIBKG.DOC_TP_CD,'B',1,0)) B_TTL" ).append("\n"); 
		query.append("      ,       SUM(DECODE(AIBKG.DOC_TP_CD,'B',DECODE(A_IB.BKG_STS_CD,'X',1,0),0)) B_X" ).append("\n"); 
		query.append("      ,       SUM(DECODE(AIBKG.DOC_TP_CD,'B',DECODE(A_IB.BKG_UPLD_STS_CD,'F',1,0),0)) B_F" ).append("\n"); 
		query.append("      ,       SUM(DECODE(AIBKG.DOC_TP_CD,'B',DECODE(A_IB.BKG_UPLD_STS_CD,'R',1,0),0)) B_R" ).append("\n"); 
		query.append("      ,       SUM(DECODE(AIBKG.DOC_TP_CD,'B',DECODE(A_IB.BKG_UPLD_STS_CD,'D',1,0),0)) B_D" ).append("\n"); 
		query.append("      ,       SUM(DECODE(AIBKG.DOC_TP_CD,'B',DECODE(A_IB.BKG_UPLD_STS_CD,'N',1,0),0)) B_P" ).append("\n"); 
		query.append("      ,       SUM(DECODE(AIBKG.DOC_TP_CD,'S',1,0)) S_TTL" ).append("\n"); 
		query.append("      ,       SUM(DECODE(AIBKG.DOC_TP_CD,'S',DECODE(A_IB.BKG_STS_CD,'X',1,0),0)) S_X" ).append("\n"); 
		query.append("      ,       SUM(DECODE(AIBKG.DOC_TP_CD,'S',DECODE(A_IB.BKG_UPLD_STS_CD,'F',1,0),0)) S_F" ).append("\n"); 
		query.append("      ,       SUM(DECODE(AIBKG.DOC_TP_CD,'S',DECODE(A_IB.BKG_UPLD_STS_CD,'R',1,0),0)) S_R" ).append("\n"); 
		query.append("      ,       SUM(DECODE(AIBKG.DOC_TP_CD,'S',DECODE(A_IB.BKG_UPLD_STS_CD,'D',1,0),0)) S_D" ).append("\n"); 
		query.append("      ,       SUM(DECODE(AIBKG.DOC_TP_CD,'S',DECODE(A_IB.BKG_UPLD_STS_CD,'N',1,0),0)) S_P" ).append("\n"); 
		query.append("      FROM    BKG_XTER_RQST_MST AIBKG " ).append("\n"); 
		query.append("	 ,       (" ).append("\n"); 
		query.append("			-----------------------------------------------------------------------------" ).append("\n"); 
		query.append("				SELECT IBKG.XTER_RQST_NO" ).append("\n"); 
		query.append("			 ,	      IB_NO.REGION_CD" ).append("\n"); 
		query.append("             ,        IBKG.BKG_NO" ).append("\n"); 
		query.append("             ,        MAX(IBKG.UPLD_DT)  UPLD_DT" ).append("\n"); 
		query.append("             ,        IB_NO.BKG_OFC " ).append("\n"); 
		query.append("             ,        IB_NO.GSO" ).append("\n"); 
		query.append("             ,        IB_NO.DOC_TP_CD" ).append("\n"); 
		query.append("             ,        IB_NO.BKG_STS_CD" ).append("\n"); 
		query.append("             ,        DECODE(MAX(DECODE(NVL(IBKG.BKG_UPLD_STS_CD,'A'),'F','D','R','C','D','B','A')),'A','N','B','D','C','R','D','F') BKG_UPLD_STS_CD " ).append("\n"); 
		query.append("             ,        IB_NO.POR_CD" ).append("\n"); 
		query.append("             ,        IB_NO.POL_CD" ).append("\n"); 
		query.append("             ,        IB_NO.POD_CD" ).append("\n"); 
		query.append("             ,        IB_NO.DEL_CD" ).append("\n"); 
		query.append("               FROM    BKG_XTER_RQST_MST IBKG, " ).append("\n"); 
		query.append("                       ( " ).append("\n"); 
		query.append("                       -----------------------------------------------------------------------------" ).append("\n"); 
		query.append("                       SELECT	/*+ALL_ROWS */ OFC.REGION REGION_CD" ).append("\n"); 
		query.append("					   ,	  A.XTER_RQST_NO" ).append("\n"); 
		query.append("                       ,      A.BKG_OFC_CD BKG_OFC " ).append("\n"); 
		query.append("					   ,	  OFC.GSO GSO	" ).append("\n"); 
		query.append("                       ,      A.BKG_NO" ).append("\n"); 
		query.append("                       ,      A.DOC_TP_CD" ).append("\n"); 
		query.append("                       ,      A.BKG_STS_CD" ).append("\n"); 
		query.append("                       ,      A.POR_CD" ).append("\n"); 
		query.append("                       ,      A.POL_CD" ).append("\n"); 
		query.append("                       ,      A.POD_CD" ).append("\n"); 
		query.append("                       ,      A.DEL_CD" ).append("\n"); 
		query.append("                       FROM	(" ).append("\n"); 
		query.append("								-----------------------------------------------------------------------------" ).append("\n"); 
		query.append("                              		SELECT	A.XTER_RQST_NO" ).append("\n"); 
		query.append("                                  ,       A.DOC_TP_CD" ).append("\n"); 
		query.append("                                  ,       BKG.BKG_STS_CD" ).append("\n"); 
		query.append("                                  ,       A.XTER_RQST_SEQ" ).append("\n"); 
		query.append("                                  ,       A.BKG_NO" ).append("\n"); 
		query.append("                                  ,       NVL(CUSTS.CUST_CNT_CD,  NVL(A.PRNT_CNT_CD,  B.CNT_CD )) CNT_CDH " ).append("\n"); 
		query.append("                                  ,       NVL(CUSTS.CUST_SEQ, NVL(A.PRNT_CUST_SEQ, B.CUST_SEQ)) CUST_CDH " ).append("\n"); 
		query.append("                                  ,       BKG.BKG_OFC_CD              " ).append("\n"); 
		query.append("                                  ,       A.POR_CD   IB_POR_CD       " ).append("\n"); 
		query.append("                                  ,       A.POL_CD   IB_POL_CD        " ).append("\n"); 
		query.append("                                  ,       A.POD_CD   IB_POD_CD        " ).append("\n"); 
		query.append("                                  ,       A.DEL_CD   IB_DEL_CD        " ).append("\n"); 
		query.append("                                  ,       A.UPLD_DT                  " ).append("\n"); 
		query.append("                                  ,       DECODE(NVL(BKG.POR_CD,' '),' ',A.POR_CD,BKG.POR_CD) POR_CD " ).append("\n"); 
		query.append("                                  ,       DECODE(NVL(BKG.POL_CD,' '),' ',A.POL_CD,BKG.POL_CD) POL_CD " ).append("\n"); 
		query.append("                                  ,       DECODE(NVL(BKG.POD_CD,' '),' ',A.POD_CD,BKG.POD_CD) POD_CD " ).append("\n"); 
		query.append("                                  ,       DECODE(NVL(BKG.DEL_CD,' '),' ',A.DEL_CD,BKG.DEL_CD) DEL_CD " ).append("\n"); 
		query.append("                                  FROM		BKG_XTER_RQST_MST A " ).append("\n"); 
		query.append("                                  ,       BKG_XTER_CUST B  " ).append("\n"); 
		query.append("                                  ,       BKG_BOOKING BKG  " ).append("\n"); 
		query.append("                                  ,       BKG_CUSTOMER CUSTS " ).append("\n"); 
		query.append("                                  WHERE		B.XTER_RQST_NO(+) = A.XTER_RQST_NO " ).append("\n"); 
		query.append("                                  AND		  B.XTER_RQST_SEQ = A.XTER_RQST_SEQ " ).append("\n"); 
		query.append("								  AND    		B.XTER_SNDR_ID(+) = A.XTER_SNDR_ID " ).append("\n"); 
		query.append("								  AND		  A.BKG_NO = BKG.BKG_NO(+) " ).append("\n"); 
		query.append("								   AND		  A.BKG_NO = CUSTS.BKG_NO(+)        " ).append("\n"); 
		query.append("                                  AND		  A.XTER_BKG_RQST_STS_CD != 'T' " ).append("\n"); 
		query.append("                                  AND		  B.XTER_CUST_TP_CD      = 'S' " ).append("\n"); 
		query.append("                                  AND		  CUSTS.BKG_CUST_TP_CD  = 'S'  " ).append("\n"); 
		query.append("                                  AND		  NVL(A.XTER_BL_TP_CD,' ') != 'H'  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                  AND     A.DOC_TP_CD IN ('B','S')  " ).append("\n"); 
		query.append("								/**e-SVC Type**/" ).append("\n"); 
		query.append("								#if (${doc_tp_b} != '' && ${doc_tp_s} == '') " ).append("\n"); 
		query.append("								  AND     A.DOC_TP_CD = @[doc_tp_b]" ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("								#if (${doc_tp_s} != '' && ${doc_tp_b} == '') " ).append("\n"); 
		query.append("								  AND     A.DOC_TP_CD = @[doc_tp_s]" ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("                                  " ).append("\n"); 
		query.append("                                  AND     A.DOC_TP_CD  NOT IN ('F')         " ).append("\n"); 
		query.append("                                  AND     A.XTER_BKG_RQST_STS_CD IN ('C','U','X')  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${duration} == 'M') " ).append("\n"); 
		query.append("	#if (${duration_month} != '') " ).append("\n"); 
		query.append("									AND    A.RQST_DT >= BKG_GET_CONV_DT_FNC('FR_MON',@[duration_year],@[duration_month])" ).append("\n"); 
		query.append("									AND    A.RQST_DT <= BKG_GET_CONV_DT_FNC('TO_MON',@[duration_year],@[duration_month]) + 0.99999" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${duration} == 'W') " ).append("\n"); 
		query.append("	#if (${duration_from_week} != '') " ).append("\n"); 
		query.append("								AND    A.RQST_DT>= BKG_GET_CONV_DT_FNC('FR_WEEK',@[duration_year],@[duration_from_week])" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${duration_to_week} != '')         " ).append("\n"); 
		query.append("       							 AND    A.RQST_DT <= BKG_GET_CONV_DT_FNC('TO_WEEK',@[duration_year],@[duration_to_week]) + 0.99999" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${duration} == 'D') " ).append("\n"); 
		query.append("	#if (${duration_from_dt} != '') " ).append("\n"); 
		query.append("								  AND    A.RQST_DT   >= TO_DATE(@[duration_from_dt], 'YYYY-MM-DD') " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${duration_to_dt} != '') " ).append("\n"); 
		query.append("								  AND    A.RQST_DT <= TO_DATE(@[duration_to_dt], 'YYYY-MM-DD') + 0.99999 " ).append("\n"); 
		query.append("	#end  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                  " ).append("\n"); 
		query.append("								#if (${bkg_ofc} != '') " ).append("\n"); 
		query.append("								  AND     BKG.BKG_OFC_CD = @[bkg_ofc]" ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("								#if (${sal_ofc} != '') " ).append("\n"); 
		query.append("                                  AND     BKG.OB_SLS_OFC_CD = @[sal_ofc]-- SALES OFFICE         " ).append("\n"); 
		query.append("							    #end" ).append("\n"); 
		query.append("								#if (${por_cd} != '') " ).append("\n"); 
		query.append("								  AND     A.POR_CD = @[por_cd]" ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("								#if (${pol_cd} != '') " ).append("\n"); 
		query.append("                              	  AND     A.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("								#if (${pod_cd} != '') " ).append("\n"); 
		query.append("                              	  AND     A.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("								#if (${del_cd} != '') " ).append("\n"); 
		query.append("                              	  AND     A.DEL_CD = @[del_cd]" ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("								-----------------------------------------------------------------------------" ).append("\n"); 
		query.append("								  ) A" ).append("\n"); 
		query.append("                       ,          (SELECT MC.* " ).append("\n"); 
		query.append("                                  FROM    MDM_CUSTOMER MC   " ).append("\n"); 
		query.append("                                  WHERE   MC.NMD_CUST_FLG != 'Y' " ).append("\n"); 
		query.append("                                  ) CUSTH" ).append("\n"); 
		query.append("                      ,           BKG_OFC_LVL_V OFC" ).append("\n"); 
		query.append("                      WHERE	      A.CNT_CDH	=	CUSTH.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("                      AND	        A.CUST_CDH	=	CUSTH.CUST_SEQ(+)" ).append("\n"); 
		query.append("					  AND         A.BKG_OFC_CD = OFC.OFC_CD --MDM_LOCATION" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				#if (${region_cd} != '') " ).append("\n"); 
		query.append("					  AND         OFC.REGION = @[region_cd]  --REGION  " ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("				#if (${gso} != '') " ).append("\n"); 
		query.append("					  AND		OFC.GSO	=	@[gso]" ).append("\n"); 
		query.append("				#end	  " ).append("\n"); 
		query.append("                      GROUP BY    A.XTER_RQST_NO,OFC.REGION,A.BKG_OFC_CD" ).append("\n"); 
		query.append("                                  ,A.BKG_NO" ).append("\n"); 
		query.append("								  ,OFC.GSO" ).append("\n"); 
		query.append("                                  ,A.DOC_TP_CD, A.BKG_STS_CD,A.POR_CD, A.POL_CD, A.POD_CD, A.DEL_CD " ).append("\n"); 
		query.append("						) IB_NO" ).append("\n"); 
		query.append("                       -----------------------------------------------------------------------------" ).append("\n"); 
		query.append("            WHERE     IBKG.XTER_RQST_NO = IB_NO.XTER_RQST_NO" ).append("\n"); 
		query.append("            AND       IBKG.BKG_NO       = IB_NO.BKG_NO" ).append("\n"); 
		query.append("            AND       IBKG.DOC_TP_CD    = IB_NO.DOC_TP_CD  " ).append("\n"); 
		query.append("            AND       XTER_BKG_RQST_STS_CD IN ('C','U','X')" ).append("\n"); 
		query.append("			AND       IBKG.UPLD_DT IS NOT NULL" ).append("\n"); 
		query.append("            AND       IBKG.BKG_UPLD_STS_CD <> 'D'" ).append("\n"); 
		query.append("            GROUP BY  IBKG.XTER_RQST_NO, IB_NO.REGION_CD,IBKG.BKG_NO,  IB_NO.BKG_OFC, IB_NO.GSO" ).append("\n"); 
		query.append("                     ,IB_NO.DOC_TP_CD, IB_NO.BKG_STS_CD," ).append("\n"); 
		query.append("                      IB_NO.POR_CD, IB_NO.POL_CD, IB_NO.POD_CD, IB_NO.DEL_CD" ).append("\n"); 
		query.append("            ) A_IB" ).append("\n"); 
		query.append("  		 	-----------------------------------------------------------------------------" ).append("\n"); 
		query.append("WHERE     AIBKG.XTER_RQST_NO = A_IB.XTER_RQST_NO" ).append("\n"); 
		query.append("AND       AIBKG.BKG_NO = A_IB.BKG_NO" ).append("\n"); 
		query.append("AND       AIBKG.DOC_TP_CD = A_IB.DOC_TP_CD" ).append("\n"); 
		query.append("GROUP BY  A_IB.REGION_CD" ).append("\n"); 
		query.append(",		  A_IB.GSO" ).append("\n"); 
		query.append(",         A_IB.BKG_OFC" ).append("\n"); 
		query.append(",         TO_CHAR(A_IB.UPLD_DT,'YYYY-MM')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY REGION_CD,GSO, BKG_OFC, MON" ).append("\n"); 

	}
}