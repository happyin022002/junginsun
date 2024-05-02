/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : COPHistoryDBDAOSearchCOPHistoryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 홍성필
*@LastVersion : 1.0
* 2017.01.19 홍성필
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copreport.cophsitory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hong Seong Pil
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class COPHistoryDBDAOSearchCOPHistoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * cop history
	  * </pre>
	  */
	public COPHistoryDBDAOSearchCOPHistoryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("page_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pagerows",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.copreport.cophsitory.integration").append("\n"); 
		query.append("FileName : COPHistoryDBDAOSearchCOPHistoryRSQL").append("\n"); 
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
		query.append("SELECT ROWNUM as seq" ).append("\n"); 
		query.append("      ,cop_no" ).append("\n"); 
		query.append("      ,cntr_no" ).append("\n"); 
		query.append("      ,bkg_no" ).append("\n"); 
		query.append("      ,event" ).append("\n"); 
		query.append("      ,cntr_tpsz_cd" ).append("\n"); 
		query.append("      ,mst_lcl_cd" ).append("\n"); 
		query.append("	  ,mst_cop_no" ).append("\n"); 
		query.append("      ,bkg_sts_cd" ).append("\n"); 
		query.append("      ,cop_sts_cd" ).append("\n"); 
		query.append("      ,cop_sub_sts_cd" ).append("\n"); 
		query.append("      ,r_term" ).append("\n"); 
		query.append("      ,ob_route" ).append("\n"); 
		query.append("      ,ocn_route" ).append("\n"); 
		query.append("      ,ib_route" ).append("\n"); 
		query.append("      ,d_term" ).append("\n"); 
		query.append("      ,cre_dt" ).append("\n"); 
		query.append("      ,cre_usr_id" ).append("\n"); 
		query.append("      ,cre_ofd_cd" ).append("\n"); 
		query.append("      ,umch_sts_cd" ).append("\n"); 
		query.append("      ,ob_bkg_tro_no" ).append("\n"); 
		query.append("      ,ib_bkg_tro_no" ).append("\n"); 
		query.append("      ,page" ).append("\n"); 
		query.append("      ,totcnt" ).append("\n"); 
		query.append("  FROM(" ).append("\n"); 
		query.append("		SELECT  t1.*,                                                                                                  " ).append("\n"); 
		query.append("		     CEIL(rownum/@[pagerows]) page , COUNT(1) OVER() TOTCNT                                                                                 " ).append("\n"); 
		query.append("		FROM (" ).append("\n"); 
		query.append("				SELECT   																					" ).append("\n"); 
		query.append("				       h.cop_no																						" ).append("\n"); 
		query.append("				       , DECODE(h.cntr_no	, 'SMCU0000000', '', h.cntr_no) AS cntr_no																				" ).append("\n"); 
		query.append("				       , h.bkg_no" ).append("\n"); 
		query.append("				       , (CASE WHEN BKG_EVNT_TP_CD = 'BR' THEN 'BKG Replan'											" ).append("\n"); 
		query.append("				               WHEN BKG_EVNT_TP_CD = 'CC' THEN 'COP Create'											" ).append("\n"); 
		query.append("				               WHEN BKG_EVNT_TP_CD = 'TC' THEN 'Terminal Change'										" ).append("\n"); 
		query.append("				               WHEN BKG_EVNT_TP_CD = 'CN' THEN 'COP Cancel'											" ).append("\n"); 
		query.append("				               WHEN BKG_EVNT_TP_CD = 'CA' THEN 'CNTR Attach'											" ).append("\n"); 
		query.append("				               WHEN BKG_EVNT_TP_CD = 'CD' THEN 'CNTR Detach'											" ).append("\n"); 
		query.append("				               WHEN BKG_EVNT_TP_CD = 'CO' THEN 'CNTR Orphaned'											" ).append("\n"); 
		query.append("				               WHEN BKG_EVNT_TP_CD = 'OI' THEN 'TRO/O Insert'											" ).append("\n"); 
		query.append("				               WHEN BKG_EVNT_TP_CD = 'OU' THEN 'TRO/O Update'											" ).append("\n"); 
		query.append("				               WHEN BKG_EVNT_TP_CD = 'OD' THEN 'TRO/O Delete'											" ).append("\n"); 
		query.append("				               WHEN BKG_EVNT_TP_CD = 'OR' THEN 'TRO/O Error'											" ).append("\n"); 
		query.append("				               WHEN BKG_EVNT_TP_CD = 'II' THEN 'TRO/I Insert'											" ).append("\n"); 
		query.append("				               WHEN BKG_EVNT_TP_CD = 'IU' THEN 'TRO/I Update'											" ).append("\n"); 
		query.append("				               WHEN BKG_EVNT_TP_CD = 'ID' THEN 'TRO/I Delete'											" ).append("\n"); 
		query.append("				               WHEN BKG_EVNT_TP_CD = 'IF' THEN 'TRO/I Frustrate'										" ).append("\n"); 
		query.append("				               WHEN BKG_EVNT_TP_CD = 'MC' THEN 'Manual Change'											" ).append("\n"); 
		query.append("				               WHEN BKG_EVNT_TP_CD = 'SO' THEN 'SO Auto Change(O/B)'		 							" ).append("\n"); 
		query.append("				               WHEN BKG_EVNT_TP_CD = 'ST' THEN 'SO Auto Change(Ocean)' 								" ).append("\n"); 
		query.append("				               WHEN BKG_EVNT_TP_CD = 'SI' THEN 'SO Auto Change(I/B)' 									" ).append("\n"); 
		query.append("				               WHEN BKG_EVNT_TP_CD = 'SP' THEN 'SO Validation Pass'									" ).append("\n"); 
		query.append("				               WHEN BKG_EVNT_TP_CD = 'TC' THEN 'Terminal Change'										" ).append("\n"); 
		query.append("				               WHEN BKG_EVNT_TP_CD = 'SC' THEN 'COP Status Change'										" ).append("\n"); 
		query.append("				               WHEN BKG_EVNT_TP_CD = 'ZC' THEN 'COP TP/SZ Change'										" ).append("\n"); 
		query.append("				               WHEN BKG_EVNT_TP_CD = 'MS' THEN 'COP MVMT Start'										" ).append("\n"); 
		query.append("				               WHEN BKG_EVNT_TP_CD = 'MF' THEN 'COP MVMT Finish'										" ).append("\n"); 
		query.append("				               WHEN BKG_EVNT_TP_CD = 'MH' THEN 'COP CNTR Finish'									" ).append("\n"); 
		query.append("				               WHEN BKG_EVNT_TP_CD = 'MR' THEN 'Manual Replan'" ).append("\n"); 
		query.append("							   WHEN BKG_EVNT_TP_CD = 'LC' THEN 'Master'" ).append("\n"); 
		query.append("							   WHEN BKG_EVNT_TP_CD = 'RC' THEN 'Slave'" ).append("\n"); 
		query.append("							   WHEN BKG_EVNT_TP_CD = 'UM' THEN 'Unmatch SO'											    	" ).append("\n"); 
		query.append("				          END) event																					" ).append("\n"); 
		query.append("				       , h.cntr_tpsz_cd" ).append("\n"); 
		query.append("				       , DECODE(h.mst_cop_no, null, '', hdr.cop_no, 'Y', 'X') MST_LCL_CD--DECODE(MST_LCL_CD,'X','X','Y') MST_LCL_CD" ).append("\n"); 
		query.append("					   , h.mst_cop_no as mst_cop_no													" ).append("\n"); 
		query.append("				       , bkg_sts_cd																					" ).append("\n"); 
		query.append("				       , DECODE(h.COP_STS_CD,'C','Create','T','In-Transit','X','Cancel','M','Manual Close','F','Closed') COP_STS_CD	" ).append("\n"); 
		query.append("				       , DECODE(cop_sub_sts_cd,'R','Y','N') cop_sub_sts_cd	" ).append("\n"); 
		query.append("				       , (SELECT BKG_RCV_TERM_CD FROM PRD_PROD_CTL_MST WHERE PCTL_NO = H.PCTL_NO) R_TERM		" ).append("\n"); 
		query.append("				       , SCE_COP_GET_ROUTE_FNC(h.pctl_no,'O','P') ob_route										" ).append("\n"); 
		query.append("				       , SCE_COP_GET_ROUTE_FNC(h.pctl_no,'T','P') ocn_route										" ).append("\n"); 
		query.append("				       , SCE_COP_GET_ROUTE_FNC(h.pctl_no,'I','P') ib_route										" ).append("\n"); 
		query.append("				       , (SELECT BKG_DE_TERM_CD FROM PRD_PROD_CTL_MST WHERE PCTL_NO = H.PCTL_NO) D_TERM			" ).append("\n"); 
		query.append("				       , TO_CHAR(h.cre_dt, 'YYYY/MM/DD HH24:MI:SS') cre_dt																						" ).append("\n"); 
		query.append("				       , h.cre_usr_id																					" ).append("\n"); 
		query.append("				       , '' as cre_ofd_cd																					" ).append("\n"); 
		query.append("				       , h.umch_sts_cd																				" ).append("\n"); 
		query.append("				       , '' AS ob_bkg_tro_no																		" ).append("\n"); 
		query.append("				       , '' AS ib_bkg_tro_no																			" ).append("\n"); 
		query.append("				    FROM sce_cop_hdr hdr" ).append("\n"); 
		query.append("				        ,sce_cop_his h																			" ).append("\n"); 
		query.append("				   WHERE hdr.cop_no = h.cop_no" ).append("\n"); 
		query.append("				#if (${bkg_no} != '')" ).append("\n"); 
		query.append("				     AND hdr.bkg_no  = @[bkg_no]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#if (${cop_no} != '')" ).append("\n"); 
		query.append("				     AND h.cop_no  = @[cop_no]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#if (${cntr_no} != '')" ).append("\n"); 
		query.append("				     AND h.cntr_no  = @[cntr_no]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("				#if (${bl_no} != '')" ).append("\n"); 
		query.append("				     AND hdr.bkg_no = (SELECT bkg_no FROM bkg_booking WHERE bl_no = @[bl_no])   " ).append("\n"); 
		query.append("				#end 												" ).append("\n"); 
		query.append("				     AND h.cre_usr_id <> 'GenS/O'																" ).append("\n"); 
		query.append("				   ORDER BY cre_dt, cop_no, bkg_no, cntr_no" ).append("\n"); 
		query.append("		      )t1" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("WHERE page =  @[page_no]" ).append("\n"); 

	}
}