/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOmodifybkgRouteFromPrdUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.16
*@LastModifier : Maeda Atsushi
*@LastVersion : 1.0
* 2016.03.16 Maeda Atsushi
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maeda Atsushi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOmodifybkgRouteFromPrdUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * prd의 정보로 bkg의 route를 update한다.
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOmodifybkgRouteFromPrdUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOmodifybkgRouteFromPrdUSQL").append("\n"); 
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
		query.append("#if (${pctl_no} == 'Over T/S')" ).append("\n"); 
		query.append("UPDATE BKG_BKG_HIS BK" ).append("\n"); 
		query.append("   SET PCTL_NO = 'Z'||SUBSTR(BK.PCTL_NO, 2, 20)" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND BK.CORR_NO  = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append(" MERGE INTO BKG_BKG_HIS BK" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(" MERGE INTO BKG_BOOKING BK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" USING (SELECT @[bkg_no] BKG_NO" ).append("\n"); 
		query.append("				, MST.PCTL_NO" ).append("\n"); 
		query.append("				, TRUNK.VSL_SLAN_CD" ).append("\n"); 
		query.append("                , MST.TRNK_VSL_CD" ).append("\n"); 
		query.append("                , MST.TRNK_SKD_VOY_NO" ).append("\n"); 
		query.append("                , MST.TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append("                , MST.MTY_PKUP_YD_CD" ).append("\n"); 
		query.append("                , MST.MCNTR_DOR_ARR_DUE_DT" ).append("\n"); 
		query.append("                , MST.FULL_RTN_YD_CD" ).append("\n"); 
		query.append("                , MST.POR_CD" ).append("\n"); 
		query.append("                , MST.POR_NOD_CD" ).append("\n"); 
		query.append("                , MST.POL_CD" ).append("\n"); 
		query.append("                , MST.POL_NOD_CD" ).append("\n"); 
		query.append("                , MST.POD_CD" ).append("\n"); 
		query.append("                , MST.POD_NOD_CD" ).append("\n"); 
		query.append("                , MST.DEL_CD" ).append("\n"); 
		query.append("                , MST.DEL_NOD_CD" ).append("\n"); 
		query.append("                , MST.FULL_PKUP_YD_CD" ).append("\n"); 
		query.append("                , MST.MTY_RTN_YD_CD" ).append("\n"); 
		query.append("                , MST.N1ST_VSL_LODG_DUE_DT" ).append("\n"); 
		query.append("                , MST.BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("                , MST.BKG_DE_TERM_CD" ).append("\n"); 
		query.append("				, DECODE(MST.POL_NOD_CD, TRUNK.ORG_NOD_CD,  '', SUBSTR(TRUNK.ORG_NOD_CD,  1, 5)) PRE_RLY_PORT_CD" ).append("\n"); 
		query.append("				, DECODE(MST.POD_NOD_CD, TRUNK.DEST_NOD_CD, '', SUBSTR(TRUNK.DEST_NOD_CD, 1, 5)) PST_RLY_PORT_CD" ).append("\n"); 
		query.append("				, OLD_ROUTE.POR_CD OLD_POR_CD" ).append("\n"); 
		query.append("				, OLD_ROUTE.POL_CD OLD_POL_CD" ).append("\n"); 
		query.append("				, DECODE(OLD_ROUTE.POR_CD||OLD_ROUTE.POL_CD, MST.POR_CD||MST.POL_CD, 'N', 'Y') POR_POL_CHANGE" ).append("\n"); 
		query.append("				, (SELECT TRSP_MOD_CD " ).append("\n"); 
		query.append("					 FROM PRD_INLND_ROUT_MST " ).append("\n"); 
		query.append("					WHERE (ROUT_ORG_NOD_CD, ROUT_DEST_NOD_CD, ROUT_SEQ) =" ).append("\n"); 
		query.append("					      (SELECT DTL.ROUT_ORG_NOD_CD, DTL.ROUT_DEST_NOD_CD, ROUT_SEQ " ).append("\n"); 
		query.append("					         FROM PRD_PROD_CTL_ROUT_DTL DTL" ).append("\n"); 
		query.append("					        WHERE DTL.PCTL_NO        = MST.PCTL_NO   " ).append("\n"); 
		query.append("					          AND DTL.PCTL_IO_BND_CD = 'O'" ).append("\n"); 
		query.append("						      AND DTL.ROUT_SEQ       <> 0" ).append("\n"); 
		query.append("							  AND ROWNUM = 1) " ).append("\n"); 
		query.append("       			  ) OB_TRSP_MOD_CD" ).append("\n"); 
		query.append("				, (SELECT TRSP_MOD_CD " ).append("\n"); 
		query.append("					 FROM PRD_INLND_ROUT_MST " ).append("\n"); 
		query.append("					WHERE (ROUT_ORG_NOD_CD, ROUT_DEST_NOD_CD, ROUT_SEQ) =" ).append("\n"); 
		query.append("					      (SELECT DTL.ROUT_ORG_NOD_CD, DTL.ROUT_DEST_NOD_CD, ROUT_SEQ " ).append("\n"); 
		query.append("					         FROM PRD_PROD_CTL_ROUT_DTL DTL" ).append("\n"); 
		query.append("					        WHERE DTL.PCTL_NO        = MST.PCTL_NO   " ).append("\n"); 
		query.append("					          AND DTL.PCTL_IO_BND_CD = 'I'" ).append("\n"); 
		query.append("						      AND DTL.ROUT_SEQ       <> 0" ).append("\n"); 
		query.append("							  AND ROWNUM = 1) " ).append("\n"); 
		query.append("       			  ) IB_TRSP_MOD_CD" ).append("\n"); 
		query.append("				, (SELECT MIN(DTL.ARR_ST_DT) " ).append("\n"); 
		query.append("				     FROM PRD_PROD_CTL_ROUT_DTL DTL" ).append("\n"); 
		query.append("					WHERE MST.PCTL_NO     = DTL.PCTL_NO" ).append("\n"); 
		query.append(" 					  AND PCTL_IO_BND_CD  = 'T'" ).append("\n"); 
		query.append("				      AND DTL.TRSP_MOD_CD IN ('VD', 'WD')) POL_ETD" ).append("\n"); 
		query.append("				, (SELECT MAX(DTL.DEP_FSH_DT) " ).append("\n"); 
		query.append("				     FROM PRD_PROD_CTL_ROUT_DTL DTL" ).append("\n"); 
		query.append("					WHERE MST.PCTL_NO     = DTL.PCTL_NO" ).append("\n"); 
		query.append(" 					  AND PCTL_IO_BND_CD  = 'T'" ).append("\n"); 
		query.append("				      AND DTL.TRSP_MOD_CD IN ('VD', 'WD')) POD_ETA " ).append("\n"); 
		query.append("				, (SELECT ARR_ST_DT" ).append("\n"); 
		query.append("					 FROM PRD_PROD_CTL_ROUT_DTL DTL" ).append("\n"); 
		query.append("					WHERE MST.PCTL_NO     = DTL.PCTL_NO" ).append("\n"); 
		query.append("					  AND PCTL_IO_BND_CD = 'O'" ).append("\n"); 
		query.append("					  AND MTY_YD_FLG     = 'Y'" ).append("\n"); 
		query.append("					  AND (PCTL_NO, ORG_NOD_CD) IN (SELECT PCTL_NO, MTY_PKUP_YD_CD" ).append("\n"); 
		query.append("											          FROM PRD_PROD_CTL_MST MST" ).append("\n"); 
		query.append(" 												     WHERE MST.PCTL_NO = DTL.PCTL_NO)" ).append("\n"); 
		query.append("					  AND ROWNUM = 1) MTY_PKUP_DT" ).append("\n"); 
		query.append("				, (SELECT N1ST_VVD.VSL_CD||N1ST_VVD.SKD_VOY_NO||N1ST_VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("					 FROM PRD_PROD_CTL_ROUT_DTL N1ST_VVD" ).append("\n"); 
		query.append("					WHERE MST.PCTL_NO       = N1ST_VVD.PCTL_NO" ).append("\n"); 
		query.append(" 					  AND N1ST_VVD.PCTL_SEQ = (SELECT MIN(PCTL_SEQ)" ).append("\n"); 
		query.append("												 FROM PRD_PROD_CTL_ROUT_DTL DTL" ).append("\n"); 
		query.append("												WHERE N1ST_VVD.PCTL_NO = DTL.PCTL_NO" ).append("\n"); 
		query.append("												  AND DTL.VSL_CD IS NOT NULL" ).append("\n"); 
		query.append("												  AND DTL.TRSP_MOD_CD IN ('VD', 'WD'))) PRD_FIRST_VVD" ).append("\n"); 
		query.append("				, (SELECT FIRST_VVD" ).append("\n"); 
		query.append("					 FROM (SELECT VVD.VSL_PRE_PST_CD, VVD.VSL_SEQ, VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD FIRST_VVD" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("    						 FROM BKG_VVD_HIS VVD, BKG_BKG_HIS BK" ).append("\n"); 
		query.append("    						WHERE BK.BKG_NO   = @[bkg_no]" ).append("\n"); 
		query.append("							  AND BK.CORR_NO  = 'TMP0000001'" ).append("\n"); 
		query.append("							  AND VVD.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    						 FROM BKG_VVD VVD, BKG_BOOKING BK" ).append("\n"); 
		query.append("    						WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    						  AND BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("    						  AND BK.POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("    						  AND VVD.VSL_PRE_PST_CD IN ('S', 'T')" ).append("\n"); 
		query.append("							ORDER BY VVD.VSL_PRE_PST_CD, VSL_SEQ)" ).append("\n"); 
		query.append("					WHERE ROWNUM = 1) BKG_FIRST_VVD" ).append("\n"); 
		query.append("          FROM PRD_PROD_CTL_MST MST" ).append("\n"); 
		query.append("				, PRD_PROD_CTL_MST OLD_ROUTE" ).append("\n"); 
		query.append("      		    , PRD_PROD_CTL_ROUT_DTL TRUNK" ).append("\n"); 
		query.append("		 WHERE MST.PCTL_NO       = TRUNK.PCTL_NO" ).append("\n"); 
		query.append("		   AND TRUNK.TRSP_MOD_CD IN ('VD', 'WD')" ).append("\n"); 
		query.append("		   AND TRUNK.VSL_CD      = MST.TRNK_VSL_CD" ).append("\n"); 
		query.append("		   AND TRUNK.SKD_VOY_NO  = MST.TRNK_SKD_VOY_NO " ).append("\n"); 
		query.append("		   AND TRUNK.SKD_DIR_CD  = MST.TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append("		   AND TRUNK.TZ_DWLL_TM_HRS = (SELECT MAX(TZ_DWLL_TM_HRS) " ).append("\n"); 
		query.append("                                 		 FROM PRD_PROD_CTL_ROUT_DTL MAX_DWLL" ).append("\n"); 
		query.append("		                                WHERE MAX_DWLL.PCTL_NO  = @[pctl_no]" ).append("\n"); 
		query.append("        		                          AND TRUNK.TRSP_MOD_CD IN ('VD', 'WD')" ).append("\n"); 
		query.append("                		                  AND TRUNK.VSL_CD      = MAX_DWLL.VSL_CD" ).append("\n"); 
		query.append("                        		          AND TRUNK.SKD_VOY_NO  = MAX_DWLL.SKD_VOY_NO " ).append("\n"); 
		query.append("                                		  AND TRUNK.SKD_DIR_CD  = MAX_DWLL.SKD_DIR_CD)" ).append("\n"); 
		query.append("		   AND MST.PCTL_NO = NVL(@[pctl_no]," ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("        							(SELECT PCTL_NO FROM BKG_BKG_HIS WHERE BKG_NO  = @[bkg_no] AND CORR_NO = 'TMP0000001')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		     					    (SELECT PCTL_NO FROM BKG_BOOKING WHERE BKG_NO  = @[bkg_no])" ).append("\n"); 
		query.append("#end				" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("		   " ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("		   AND OLD_ROUTE.PCTL_NO = (SELECT PCTL_NO FROM BKG_BKG_HIS WHERE BKG_NO  = @[bkg_no] AND CORR_NO = 'TMP0000001')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		   AND OLD_ROUTE.PCTL_NO = (SELECT PCTL_NO FROM BKG_BOOKING WHERE BKG_NO  = @[bkg_no])" ).append("\n"); 
		query.append("#end				" ).append("\n"); 
		query.append("		) PRD" ).append("\n"); 
		query.append("    ON (BK.BKG_NO = PRD.BKG_NO)" ).append("\n"); 
		query.append("  WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET " ).append("\n"); 
		query.append("#if(${cu_mode} == 'C')" ).append("\n"); 
		query.append("       BK.SLAN_CD			= CASE WHEN BK.VSL_CD = 'COXX' OR BK.VSL_CD = 'COYY' OR BK.VSL_CD = 'COZZ' THEN 'SYS' ELSE PRD.VSL_SLAN_CD END" ).append("\n"); 
		query.append("     , BK.VSL_CD            = PRD.TRNK_VSL_CD" ).append("\n"); 
		query.append("     , BK.SKD_VOY_NO        = PRD.TRNK_SKD_VOY_NO" ).append("\n"); 
		query.append("     , BK.SKD_DIR_CD        = PRD.TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append("	 , BK.MTY_PKUP_YD_CD    = NVL(PRD.MTY_PKUP_YD_CD, BK.MTY_PKUP_YD_CD)" ).append("\n"); 
		query.append("     , BK.FULL_RTN_YD_CD    = NVL(PRD.FULL_RTN_YD_CD, BK.FULL_RTN_YD_CD)" ).append("\n"); 
		query.append("     , BK.MTY_PKUP_DT       = NVL(PRD.MTY_PKUP_DT,    BK.MTY_PKUP_DT)" ).append("\n"); 
		query.append("     , BK.POR_CD            = PRD.POR_CD" ).append("\n"); 
		query.append("     , BK.POR_NOD_CD        = PRD.POR_NOD_CD" ).append("\n"); 
		query.append("     , BK.POL_CD            = PRD.POL_CD" ).append("\n"); 
		query.append("     , BK.POL_NOD_CD        = PRD.POL_NOD_CD" ).append("\n"); 
		query.append("     , BK.POD_CD            = PRD.POD_CD" ).append("\n"); 
		query.append("     , BK.POD_NOD_CD        = PRD.POD_NOD_CD" ).append("\n"); 
		query.append("     , BK.DEL_CD            = PRD.DEL_CD" ).append("\n"); 
		query.append("     , BK.DEL_NOD_CD        = PRD.DEL_NOD_CD" ).append("\n"); 
		query.append("     , BK.FULL_PKUP_YD_CD   = NVL(PRD.FULL_PKUP_YD_CD, 		BK.FULL_PKUP_YD_CD)" ).append("\n"); 
		query.append("     , BK.MTY_RTN_YD_CD     = NVL(PRD.MTY_RTN_YD_CD,   		BK.MTY_RTN_YD_CD)" ).append("\n"); 
		query.append("     , BK.LODG_DUE_DT       = NVL(PRD.N1ST_VSL_LODG_DUE_DT, BK.LODG_DUE_DT)" ).append("\n"); 
		query.append("     , BK.MTY_DOR_ARR_DT    = NVL(PRD.MCNTR_DOR_ARR_DUE_DT, BK.MTY_DOR_ARR_DT)" ).append("\n"); 
		query.append("  	 , BK.PRE_RLY_PORT_CD	= PRD.PRE_RLY_PORT_CD" ).append("\n"); 
		query.append("	 , BK.PST_RLY_PORT_CD	= PRD.PST_RLY_PORT_CD" ).append("\n"); 
		query.append(" 	 , BK.ORG_TRNS_MOD_CD   = CASE WHEN OB_TRSP_MOD_CD = 'WD' THEN DECODE(PRD.POR_CD, PRD.POL_CD, 'F', 'B')" ).append("\n"); 
		query.append("								   WHEN OB_TRSP_MOD_CD = 'RD' THEN 'R'" ).append("\n"); 
		query.append("								   WHEN OB_TRSP_MOD_CD = 'TD' THEN 'T'" ).append("\n"); 
		query.append("								   WHEN OB_TRSP_MOD_CD = 'TR' THEN 'A'" ).append("\n"); 
		query.append("								   WHEN OB_TRSP_MOD_CD = 'TW' THEN DECODE(PRD.POR_CD, PRD.POL_CD, 'E', 'U') END " ).append("\n"); 
		query.append("	 , BK.DEST_TRNS_MOD_CD  = CASE WHEN IB_TRSP_MOD_CD = 'WD' THEN DECODE(PRD.POD_CD, PRD.DEL_CD, 'F', 'B')" ).append("\n"); 
		query.append("								   WHEN IB_TRSP_MOD_CD = 'RD' THEN 'R'" ).append("\n"); 
		query.append("								   WHEN IB_TRSP_MOD_CD = 'TD' THEN 'T'" ).append("\n"); 
		query.append("								   WHEN IB_TRSP_MOD_CD = 'TR' THEN 'A'" ).append("\n"); 
		query.append("								   WHEN IB_TRSP_MOD_CD = 'TW' THEN DECODE(PRD.POD_CD, PRD.DEL_CD, 'E', 'U') END " ).append("\n"); 
		query.append("     , BK.SHP_BAK_FLG       = 'N'" ).append("\n"); 
		query.append("     , BK.PORT_CLZ_DT 		= (SELECT NVL((SELECT MAX(HOL.HOL_DT) + 1" ).append("\n"); 
		query.append("								             FROM DMT_HOLIDAY HOL" ).append("\n"); 
		query.append("								            WHERE (HOL_YR,CNT_CD,RGN_CD,STE_CD,LOC_CD,HOL_DESC)" ).append("\n"); 
		query.append("						                          IN (SELECT HOL_YR,CNT_CD,RGN_CD,STE_CD,LOC_CD,HOL_DESC" ).append("\n"); 
		query.append("						                                FROM DMT_HOLIDAY" ).append("\n"); 
		query.append("						                               WHERE SUBSTR(PRD.POL_NOD_CD, 1, 2) = CNT_CD(+)" ).append("\n"); 
		query.append("	                    						         AND SUBSTR(PRD.POL_NOD_CD, 1, 5) = CASE WHEN TRIM(HOL.LOC_CD) IS NULL THEN SUBSTR(PRD.POL_NOD_CD, 1, 5)" ).append("\n"); 
		query.append("	                                            						                  		 else HOL.LOC_CD end " ).append("\n"); 
		query.append("						                                 AND HOL_YR                      = TO_CHAR(PCT, 'yyyy')" ).append("\n"); 
		query.append("                    							         AND TO_CHAR(HOL_DT, 'yyyymmdd') = TO_CHAR(PCT, 'yyyymmdd'))" ).append("\n"); 
		query.append("										), TO_DATE(TO_CHAR(PCT, 'YYYYMMDD'), 'YYYYMMDD')) PCT" ).append("\n"); 
		query.append("								 FROM (SELECT CASE WHEN TRIM(TO_CHAR(POL_ETD + 2, 'DAY', 'NLS_DATE_LANGUAGE=ENGLISH')) = 'SUNDAY'   THEN POL_ETD + 4" ).append("\n"); 
		query.append("							                       WHEN TRIM(TO_CHAR(POL_ETD + 2, 'DAY', 'NLS_DATE_LANGUAGE=ENGLISH')) = 'SATURDAY' THEN POL_ETD + 3 " ).append("\n"); 
		query.append("								                   ELSE POL_ETD + 2 END PCT" ).append("\n"); 
		query.append("								         FROM (SELECT MIN(DTL.ARR_ST_DT) POL_ETD" ).append("\n"); 
		query.append("											     FROM PRD_PROD_CTL_ROUT_DTL DTL" ).append("\n"); 
		query.append("												WHERE DTL.PCTL_NO 		= @[pctl_no]" ).append("\n"); 
		query.append("											      and DTL.TRSP_MOD_CD 	in ('VD', 'WD')" ).append("\n"); 
		query.append("							 					  and PCTL_IO_BND_CD 	= 'T')))" ).append("\n"); 
		query.append("	 , BK.POL_ETD_DT		= PRD.POL_ETD" ).append("\n"); 
		query.append("	 , BK.POD_ETA_DT		= PRD.POD_ETA" ).append("\n"); 
		query.append("	 , BK.PCTL_NO			= PRD.PCTL_NO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       BK.SLAN_CD			= CASE WHEN BK.VSL_CD = 'COXX' OR BK.VSL_CD = 'COYY' OR BK.VSL_CD = 'COZZ' THEN 'SYS' ELSE DECODE(BK.PCTL_NO, PRD.PCTL_NO, BK.SLAN_CD, PRD.VSL_SLAN_CD) END" ).append("\n"); 
		query.append("     , BK.VSL_CD            = DECODE(BK.PCTL_NO, PRD.PCTL_NO, BK.VSL_CD,        PRD.TRNK_VSL_CD)" ).append("\n"); 
		query.append("     , BK.SKD_VOY_NO        = DECODE(BK.PCTL_NO, PRD.PCTL_NO, BK.SKD_VOY_NO,    PRD.TRNK_SKD_VOY_NO)" ).append("\n"); 
		query.append("     , BK.SKD_DIR_CD        = DECODE(BK.PCTL_NO, PRD.PCTL_NO, BK.SKD_DIR_CD, PRD.TRNK_SKD_DIR_CD)" ).append("\n"); 
		query.append("#if(${update_mt_pkup} == 'Y')" ).append("\n"); 
		query.append("	 , BK.MTY_PKUP_YD_CD    = NVL(PRD.MTY_PKUP_YD_CD, BK.MTY_PKUP_YD_CD)" ).append("\n"); 
		query.append("     , BK.MTY_PKUP_DT       = NVL(PRD.MTY_PKUP_DT, BK.MTY_PKUP_DT)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	 , BK.MTY_PKUP_YD_CD    = CASE WHEN BK.PCTL_NO = PRD.PCTL_NO    THEN BK.MTY_PKUP_YD_CD" ).append("\n"); 
		query.append("								   WHEN PRD.POR_CD = PRD.OLD_POR_CD THEN BK.MTY_PKUP_YD_CD" ).append("\n"); 
		query.append("								   ELSE NVL(PRD.MTY_PKUP_YD_CD, BK.MTY_PKUP_YD_CD) END" ).append("\n"); 
		query.append("     , BK.MTY_PKUP_DT       = CASE WHEN BK.PCTL_NO = PRD.PCTL_NO    THEN BK.MTY_PKUP_DT" ).append("\n"); 
		query.append("								   WHEN PRD.POR_CD = PRD.OLD_POR_CD THEN BK.MTY_PKUP_DT" ).append("\n"); 
		query.append("								   ELSE NVL(PRD.MTY_PKUP_DT, BK.MTY_PKUP_DT) END" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if(${update_full_rtn_yd_cd} == 'Y')" ).append("\n"); 
		query.append("     , BK.FULL_RTN_YD_CD    = PRD.FULL_RTN_YD_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("     , BK.FULL_RTN_YD_CD    = CASE WHEN BK.PCTL_NO = PRD.PCTL_NO THEN BK.FULL_RTN_YD_CD" ).append("\n"); 
		query.append("								   WHEN PRD.POR_CD = PRD.OLD_POR_CD AND PRD.PRD_FIRST_VVD = PRD.BKG_FIRST_VVD THEN BK.FULL_RTN_YD_CD " ).append("\n"); 
		query.append("								   ELSE PRD.FULL_RTN_YD_CD END" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("     , BK.POR_CD            = DECODE(BK.PCTL_NO, PRD.PCTL_NO, BK.POR_CD,     PRD.por_Cd)" ).append("\n"); 
		query.append("     , BK.POR_NOD_CD        = DECODE(BK.PCTL_NO, PRD.PCTL_NO, BK.POR_NOD_CD, PRD.por_nod_cd)" ).append("\n"); 
		query.append("     , BK.POL_CD            = DECODE(BK.PCTL_NO, PRD.PCTL_NO, BK.POL_CD,     PRD.pol_cd)" ).append("\n"); 
		query.append("     , BK.POL_NOD_CD        = DECODE(BK.PCTL_NO, PRD.PCTL_NO, BK.POL_NOD_CD, PRD.pol_nod_cd)" ).append("\n"); 
		query.append("     , BK.POD_CD            = DECODE(BK.PCTL_NO, PRD.PCTL_NO, BK.POD_CD,     PRD.pod_cd)" ).append("\n"); 
		query.append("     , BK.POD_NOD_CD        = DECODE(BK.PCTL_NO, PRD.PCTL_NO, BK.POD_NOD_CD, PRD.pod_nod_cd)" ).append("\n"); 
		query.append("     , BK.DEL_CD            = DECODE(BK.PCTL_NO, PRD.PCTL_NO, BK.DEL_CD, 	 PRD.del_cd)" ).append("\n"); 
		query.append("     , BK.DEL_NOD_CD        = DECODE(BK.PCTL_NO, PRD.PCTL_NO, BK.DEL_NOD_CD, PRD.del_nod_cd)" ).append("\n"); 
		query.append("     , BK.FULL_PKUP_YD_CD   = DECODE(BK.PCTL_NO, PRD.PCTL_NO, BK.FULL_PKUP_YD_CD, nvl(PRD.full_pkup_yd_cd, 		bk.full_pkup_yd_cd))" ).append("\n"); 
		query.append("     , BK.MTY_RTN_YD_CD     = DECODE(BK.PCTL_NO, PRD.PCTL_NO, BK.MTY_RTN_YD_CD,   nvl(PRD.mty_rtn_yd_cd,   		bk.mty_rtn_yd_cd))" ).append("\n"); 
		query.append("     , BK.LODG_DUE_DT       = DECODE(BK.PCTL_NO, PRD.PCTL_NO, BK.LODG_DUE_DT,     nvl(PRD.n1st_vsl_lodg_due_dt, bk.lodg_due_dt))" ).append("\n"); 
		query.append("     , BK.MTY_DOR_ARR_DT    = DECODE(BK.PCTL_NO, PRD.PCTL_NO, BK.MTY_DOR_ARR_DT,  nvl(PRD.mcntr_dor_arr_due_dt, bk.mty_dor_arr_dt))" ).append("\n"); 
		query.append("  	 , BK.PRE_RLY_PORT_CD	= DECODE(BK.PCTL_NO, PRD.PCTL_NO, BK.PRE_RLY_PORT_CD, PRD.PRE_RLY_PORT_CD)" ).append("\n"); 
		query.append("	 , BK.PST_RLY_PORT_CD	= DECODE(BK.PCTL_NO, PRD.PCTL_NO, BK.PST_RLY_PORT_CD, PRD.PST_RLY_PORT_CD)" ).append("\n"); 
		query.append(" 	 , BK.ORG_TRNS_MOD_CD   = CASE WHEN BK.PCTL_NO = PRD.PCTL_NO THEN BK.ORG_TRNS_MOD_CD" ).append("\n"); 
		query.append("								   WHEN OB_TRSP_MOD_CD = 'WD' THEN DECODE(PRD.POR_CD, PRD.POL_CD, 'F', 'B')" ).append("\n"); 
		query.append("								   WHEN OB_TRSP_MOD_CD = 'RD' THEN 'R'" ).append("\n"); 
		query.append("								   WHEN OB_TRSP_MOD_CD = 'TD' THEN 'T'" ).append("\n"); 
		query.append("								   WHEN OB_TRSP_MOD_CD = 'TR' THEN 'A'" ).append("\n"); 
		query.append("								   WHEN OB_TRSP_MOD_CD = 'TW' THEN DECODE(PRD.POR_CD, PRD.POL_CD, 'E', 'U') END " ).append("\n"); 
		query.append("	 , BK.DEST_TRNS_MOD_CD  = CASE WHEN BK.PCTL_NO = PRD.PCTL_NO THEN BK.DEST_TRNS_MOD_CD" ).append("\n"); 
		query.append("								   WHEN IB_TRSP_MOD_CD = 'WD' THEN DECODE(PRD.POD_CD, PRD.DEL_CD, 'F', 'B')" ).append("\n"); 
		query.append("								   WHEN IB_TRSP_MOD_CD = 'RD' THEN 'R'" ).append("\n"); 
		query.append("								   WHEN IB_TRSP_MOD_CD = 'TD' THEN 'T'" ).append("\n"); 
		query.append("								   WHEN IB_TRSP_MOD_CD = 'TR' THEN 'A'" ).append("\n"); 
		query.append("								   WHEN IB_TRSP_MOD_CD = 'TW' THEN DECODE(PRD.POD_CD, PRD.DEL_CD, 'E', 'U') END " ).append("\n"); 
		query.append("     , BK.SHP_BAK_FLG       = DECODE(BK.PCTL_NO, PRD.PCTL_NO, BK.SHP_BAK_FLG, " ).append("\n"); 
		query.append("									CASE WHEN SUBSTR(PRD.POL_CD, 1, 2) = SUBSTR(PRD.POD_CD, 1, 2) " ).append("\n"); 
		query.append("											AND PRD.PRE_RLY_PORT_CD IS NOT NULL " ).append("\n"); 
		query.append("											AND PRD.PST_RLY_PORT_CD IS NOT NULL THEN 'Y' " ).append("\n"); 
		query.append("										 ELSE 'N' END)" ).append("\n"); 
		query.append("     , BK.PORT_CLZ_DT 		= DECODE(BK.PCTL_NO, PRD.PCTL_NO, BK.PORT_CLZ_DT," ).append("\n"); 
		query.append("								(SELECT NVL((SELECT MAX(HOL.HOL_DT) + 1" ).append("\n"); 
		query.append("								             FROM DMT_HOLIDAY HOL" ).append("\n"); 
		query.append("								            WHERE (HOL_YR,CNT_CD,RGN_CD,STE_CD,LOC_CD,HOL_DESC)" ).append("\n"); 
		query.append("						                          IN (SELECT HOL_YR,CNT_CD,RGN_CD,STE_CD,LOC_CD,HOL_DESC" ).append("\n"); 
		query.append("						                                FROM DMT_HOLIDAY" ).append("\n"); 
		query.append("						                               WHERE SUBSTR(PRD.POL_NOD_CD, 1, 2) = CNT_CD(+)" ).append("\n"); 
		query.append("	                    						         AND SUBSTR(PRD.POL_NOD_CD, 1, 5) = CASE WHEN TRIM(HOL.LOC_CD) IS NULL THEN SUBSTR(PRD.POL_NOD_CD, 1, 5)" ).append("\n"); 
		query.append("	                                            						                  		 else HOL.LOC_CD end " ).append("\n"); 
		query.append("						                                 AND HOL_YR                      = TO_CHAR(PCT, 'yyyy')" ).append("\n"); 
		query.append("                    							         AND TO_CHAR(HOL_DT, 'yyyymmdd') = TO_CHAR(PCT, 'yyyymmdd'))" ).append("\n"); 
		query.append("										), TO_DATE(TO_CHAR(PCT, 'YYYYMMDD'), 'YYYYMMDD')) PCT" ).append("\n"); 
		query.append("								 FROM (SELECT CASE WHEN TRIM(TO_CHAR(POL_ETD + 2, 'DAY', 'NLS_DATE_LANGUAGE=ENGLISH')) = 'SUNDAY'   THEN POL_ETD + 4" ).append("\n"); 
		query.append("							                       WHEN TRIM(TO_CHAR(POL_ETD + 2, 'DAY', 'NLS_DATE_LANGUAGE=ENGLISH')) = 'SATURDAY' THEN POL_ETD + 3 " ).append("\n"); 
		query.append("								                   ELSE POL_ETD + 2 END PCT" ).append("\n"); 
		query.append("								         FROM (SELECT MIN(DTL.ARR_ST_DT) POL_ETD" ).append("\n"); 
		query.append("											     FROM PRD_PROD_CTL_ROUT_DTL DTL" ).append("\n"); 
		query.append("												WHERE DTL.PCTL_NO 		= @[pctl_no]" ).append("\n"); 
		query.append("											      and DTL.TRSP_MOD_CD 	in ('VD', 'WD')" ).append("\n"); 
		query.append("							 					  and PCTL_IO_BND_CD 	= 'T'))))" ).append("\n"); 
		query.append("	 , BK.POL_ETD_DT		= DECODE(BK.PCTL_NO, PRD.PCTL_NO, BK.POL_ETD_DT, PRD.POL_ETD)" ).append("\n"); 
		query.append("	 , BK.POD_ETA_DT		= DECODE(BK.PCTL_NO, PRD.PCTL_NO, BK.POD_ETA_DT, PRD.POD_ETA)" ).append("\n"); 
		query.append("	 , BK.PCTL_NO			= DECODE(BK.PCTL_NO, PRD.PCTL_NO, BK.PCTL_NO,    PRD.PCTL_NO)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append(" where CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}