/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CustomerEdiDBDAOSearchEdiSummaryReportRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 홍성필
*@LastVersion : 1.0
* 2017.01.19 홍성필
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hong Seong Pil
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerEdiDBDAOSearchEdiSummaryReportRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEdiSummaryReport
	  * </pre>
	  */
	public CustomerEdiDBDAOSearchEdiSummaryReportRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("podetadate1_hidden",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("poletddate2_hidden",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("podetadate2_hidden",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cs_grp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("poletddate1_hidden",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.integration").append("\n"); 
		query.append("FileName : CustomerEdiDBDAOSearchEdiSummaryReportRSQL").append("\n"); 
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
		query.append("WITH IE AS ( /* EDI_GRP_CUST를 WITH절로 변경, 3회 조회됨 */" ).append("\n"); 
		query.append("    SELECT *" ).append("\n"); 
		query.append("    FROM EDI_GRP_CUST" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("#if(${cs_grp_id} != '')" ).append("\n"); 
		query.append("    AND EDI_GRP_CD = @[cs_grp_id]" ).append("\n"); 
		query.append("#end)" ).append("\n"); 
		query.append(",   A AS (" ).append("\n"); 
		query.append("    SELECT H.TRNK_VSL_CD||H.TRNK_SKD_VOY_NO||H.TRNK_SKD_DIR_CD VVD," ).append("\n"); 
		query.append("           H.BKG_NO," ).append("\n"); 
		query.append("           H.CNTR_NO," ).append("\n"); 
		query.append("           SUBSTR(H.POR_NOD_CD, 1, 5) POR_CD," ).append("\n"); 
		query.append("           SUBSTR(H.POL_NOD_CD, 1, 5) POL_CD," ).append("\n"); 
		query.append("           SUBSTR(H.POD_NOD_CD, 1, 5) POD_CD," ).append("\n"); 
		query.append("           SUBSTR(H.DEL_NOD_CD, 1, 5) DEL_CD," ).append("\n"); 
		query.append("           H.COP_NO," ).append("\n"); 
		query.append("           B.BL_NO BL_NO ," ).append("\n"); 
		query.append("           M.N1ST_TS_PORT_CD TS_PORT," ).append("\n"); 
		query.append("           H.COP_RAIL_CHK_CD RAIL," ).append("\n"); 
		query.append("           S.EDI_STND_STS_CD A_EDI_STS_CD," ).append("\n"); 
		query.append("           S.EDI_GRP_CD EDI_GRP_CD ," ).append("\n"); 
		query.append("           S.CUST_EDI_STS_CD CUST_EDI_STS_CD" ).append("\n"); 
		query.append("    FROM " ).append("\n"); 
		query.append("      BKG_BOOKING B" ).append("\n"); 
		query.append("    , SCE_COP_HDR H" ).append("\n"); 
		query.append("    , PRD_PROD_CTL_MST M" ).append("\n"); 
		query.append("    , EDI_GRP_CGO S" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND (B.BKG_NO) IN ( " ).append("\n"); 
		query.append("                       SELECT  IB.BKG_NO" ).append("\n"); 
		query.append("                       FROM    BKG_CUSTOMER IB, IE, BKG_BOOKING BB" ).append("\n"); 
		query.append("                       WHERE   1=1" ).append("\n"); 
		query.append("                       AND IB.CUST_CNT_CD       = IE.CUST_CNT_CD  " ).append("\n"); 
		query.append("                       AND IB.CUST_SEQ          = IE.CUST_SEQ" ).append("\n"); 
		query.append("                       AND IE.CGO_TRC_SVC_FLG   = 'Y'" ).append("\n"); 
		query.append("                       AND IE.IB_SVC_FLG        = 'N'" ).append("\n"); 
		query.append("                       AND NVL(IE.BKG_CUST_TP_DESC, IB.BKG_CUST_TP_CD) LIKE '%'||IB.BKG_CUST_TP_CD||'%'" ).append("\n"); 
		query.append("					   AND IB.BKG_NO            = BB.BKG_NO" ).append("\n"); 
		query.append("				#if(${fm_dt} !='' &&  ${to_dt} !='')" ).append("\n"); 
		query.append("                       AND BB.BKG_CRE_DT BETWEEN TO_DATE(@[fm_dt], 'YYYYMMDD')-200 AND TO_DATE(@[to_dt], 'YYYYMMDD' )+0.9999 -- $EDI_EVNT_DT" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("                       UNION  " ).append("\n"); 
		query.append("                       SELECT  IB.BKG_NO" ).append("\n"); 
		query.append("                       FROM    BKG_BOOKING IB, IE  " ).append("\n"); 
		query.append("                       WHERE   1=1" ).append("\n"); 
		query.append("                       AND IE.SC_NO             = IB.SC_NO" ).append("\n"); 
		query.append("                       AND IE.CGO_TRC_SVC_FLG   = 'Y'" ).append("\n"); 
		query.append("                       AND IE.IB_SVC_FLG        = 'N'" ).append("\n"); 
		query.append("                       AND IE.BKG_CTRT_DIV_CD   = '1'" ).append("\n"); 
		query.append("				#if(${fm_dt} !='' &&  ${to_dt} !='')" ).append("\n"); 
		query.append("                       AND IB.BKG_CRE_DT BETWEEN TO_DATE(@[fm_dt], 'YYYYMMDD')-200 AND TO_DATE(@[to_dt], 'YYYYMMDD' )+0.9999 -- $EDI_EVNT_DT" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("                       UNION" ).append("\n"); 
		query.append("                       SELECT  IB.BKG_NO" ).append("\n"); 
		query.append("                       FROM    BKG_BOOKING IB, IE  " ).append("\n"); 
		query.append("                       WHERE   1=1" ).append("\n"); 
		query.append("                       AND IE.CGO_TRC_SVC_FLG   = 'Y'" ).append("\n"); 
		query.append("                       AND IE.IB_SVC_FLG        = 'N'" ).append("\n"); 
		query.append("                       AND IE.SC_NO             = IB.RFA_NO" ).append("\n"); 
		query.append("                       AND IE.BKG_CTRT_DIV_CD   = '2'" ).append("\n"); 
		query.append("				#if(${fm_dt} !='' &&  ${to_dt} !='')" ).append("\n"); 
		query.append("                       AND IB.BKG_CRE_DT BETWEEN TO_DATE(@[fm_dt], 'YYYYMMDD')-200 AND TO_DATE(@[to_dt], 'YYYYMMDD' )+0.9999 -- $EDI_EVNT_DT" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("    AND B.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("    AND B.BKG_NO = H.BKG_NO" ).append("\n"); 
		query.append("    AND H.CNTR_NO <> 'SMCU0000000'" ).append("\n"); 
		query.append("    #if(${cs_grp_id} != '')" ).append("\n"); 
		query.append("    AND S.EDI_GRP_CD = @[cs_grp_id]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    AND H.PCTL_NO = M.PCTL_NO" ).append("\n"); 
		query.append("    #if(${bkg_no_} != '' )" ).append("\n"); 
		query.append("    AND B.BKG_NO IN (#foreach($ele in ${bkg_no_})" ).append("\n"); 
		query.append("                        #if($velocityCount == 1) " ).append("\n"); 
		query.append("                           '$ele'" ).append("\n"); 
		query.append("                        #else" ).append("\n"); 
		query.append("                           ,'$ele'" ).append("\n"); 
		query.append("                        #end " ).append("\n"); 
		query.append("                     #end)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if(${cntr_no_} != '')" ).append("\n"); 
		query.append("     AND H.CNTR_NO IN ( #foreach($ele in ${cntr_no_})" ).append("\n"); 
		query.append("                          #if($velocityCount == 1) " ).append("\n"); 
		query.append("                              '$ele'" ).append("\n"); 
		query.append("                          #else" ).append("\n"); 
		query.append("                             ,'$ele'" ).append("\n"); 
		query.append("                          #end" ).append("\n"); 
		query.append("                        #end " ).append("\n"); 
		query.append("                         ,'')" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if(${bl_no_} != '' )" ).append("\n"); 
		query.append("    AND B.BL_NO IN ( #foreach($ele in ${bl_no_})" ).append("\n"); 
		query.append("                              #if($velocityCount == 1) " ).append("\n"); 
		query.append("                                   '$ele'" ).append("\n"); 
		query.append("                              #else" ).append("\n"); 
		query.append("                                   ,'$ele'" ).append("\n"); 
		query.append("                              #end " ).append("\n"); 
		query.append("                            #end ) " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if(${por} != '')" ).append("\n"); 
		query.append("    AND B.POR_NOD_CD LIKE '${por}%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#if((${poletddate1_hidden} =='') && (${poletddate2_hidden} =='') && (${podetadate1_hidden} =='') && (${podetadate2_hidden} ==''))" ).append("\n"); 
		query.append("    #if(${pol} != '') " ).append("\n"); 
		query.append("    AND B.POL_NOD_CD LIKE '${pol}%'" ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append("    #if(${pod} != '')" ).append("\n"); 
		query.append("    AND B.POD_NOD_CD LIKE '${pod}%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    #if(${del} != '')" ).append("\n"); 
		query.append("    AND B.DEL_NOD_CD LIKE '${del}%'" ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append("    #if(${cop_status} == 'C')" ).append("\n"); 
		query.append("    AND H.COP_STS_CD  = 'F'			            " ).append("\n"); 
		query.append("    #elseif(${cop_status} == 'I')" ).append("\n"); 
		query.append("    AND H.COP_STS_CD  = 'T'			            " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if(${vvd} != '') " ).append("\n"); 
		query.append("    AND EXISTS (SELECT 'X' FROM BKG_VVD V WHERE B.BKG_NO = V.BKG_NO " ).append("\n"); 
		query.append("                                        AND VSL_CD|| SKD_VOY_NO || SKD_DIR_CD IN (#foreach($ele in ${vvd})" ).append("\n"); 
		query.append("                                                                                    #if($velocityCount == 1) " ).append("\n"); 
		query.append("                                                                                        '$ele'" ).append("\n"); 
		query.append("                                                                                    #else" ).append("\n"); 
		query.append("                                                                                        ,'$ele'" ).append("\n"); 
		query.append("                                                                                    #end " ).append("\n"); 
		query.append("                                                                                  #end " ).append("\n"); 
		query.append("                                                                                ,'') )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#if((${vvd} == '') && (${bkg_no_} == '') && (${bl_no_} == '') &&  (${cntr_no_} == ''))" ).append("\n"); 
		query.append("  #if((${poletddate1_hidden} !='') || (${poletddate2_hidden} !='') || (${podetadate1_hidden} !='') || (${podetadate2_hidden} !=''))" ).append("\n"); 
		query.append(" AND EXISTS (SELECT 'X' FROM (SELECT V.*" ).append("\n"); 
		query.append("                                FROM BKG_VVD V" ).append("\n"); 
		query.append("                                   , VSK_VSL_PORT_SKD P " ).append("\n"); 
		query.append("                               WHERE 1 = 1 " ).append("\n"); 
		query.append("                                 AND (V.VSL_CD,V.SKD_VOY_NO, V.SKD_DIR_CD) IN ((P.VSL_CD,P.SKD_VOY_NO,P.SKD_DIR_CD))" ).append("\n"); 
		query.append("                                 AND NVL(SKD_CNG_STS_CD, ' ') <> 'S' AND CLPT_IND_SEQ = '1' " ).append("\n"); 
		query.append("                     -- ETD" ).append("\n"); 
		query.append("                     #if((${poletddate1_hidden} !='') || (${poletddate2_hidden} !=''))" ).append("\n"); 
		query.append("                        AND VPS_ETD_DT BETWEEN TO_DATE(@[poletddate1_hidden], 'YYYYMMDD' ) AND TO_DATE(@[poletddate2_hidden], 'YYYYMMDD' ) + 0.9999" ).append("\n"); 
		query.append("                        #if(${pol} != '')" ).append("\n"); 
		query.append("                        AND VPS_PORT_CD LIKE  '${pol}%'" ).append("\n"); 
		query.append("                        AND V.POL_CD LIKE '${pol}%'" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        AND NVL(TURN_PORT_IND_CD, ' ') NOT IN ('V', 'D', 'F')" ).append("\n"); 
		query.append("						#if(${etd_eta} == 'F_ETD')" ).append("\n"); 
		query.append("						AND V.VSL_PRE_PST_CD IN ('S','T')" ).append("\n"); 
		query.append("						#else" ).append("\n"); 
		query.append("						AND V.VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						AND VPS_PORT_CD = V.POL_CD --// [2014-02-19] 추가" ).append("\n"); 
		query.append("                    #end " ).append("\n"); 
		query.append("                     -- ETA " ).append("\n"); 
		query.append("                    #if((${podetadate1_hidden} !='') || (${podetadate2_hidden} !=''))  " ).append("\n"); 
		query.append("                        AND VPS_ETA_DT BETWEEN TO_DATE(@[podetadate1_hidden], 'YYYYMMDD' ) AND TO_DATE(@[podetadate2_hidden], 'YYYYMMDD' ) + 0.9999" ).append("\n"); 
		query.append("                        #if(${pod} != '')" ).append("\n"); 
		query.append("                        AND VPS_PORT_CD LIKE '${pod}%'" ).append("\n"); 
		query.append("                        AND V.POD_CD LIKE '${pod}%'" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        AND NVL(TURN_PORT_IND_CD, ' ') IN ('N', 'V', 'D', 'F')" ).append("\n"); 
		query.append("						AND V.VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append("						AND VPS_PORT_CD = V.POD_CD --// [2014-02-19] 추가" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("				) TG" ).append("\n"); 
		query.append("            WHERE 1 = 1" ).append("\n"); 
		query.append("              AND B.BKG_NO = TG.BKG_NO" ).append("\n"); 
		query.append("              #if(${etd_eta} == 'F_ETD')" ).append("\n"); 
		query.append("              AND (TG.BKG_NO, TG.VSL_PRE_PST_CD, TG.VSL_CD, TG.SKD_VOY_NO, TG.SKD_DIR_CD, 1) IN (SELECT VD.BKG_NO" ).append("\n"); 
		query.append("                                                         										  , VD.VSL_PRE_PST_CD                                                         " ).append("\n"); 
		query.append("                                                         										  , VD.VSL_CD" ).append("\n"); 
		query.append("                                                         										  , VD.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                         										  , VD.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                         										  , ROW_NUMBER() OVER ( PARTITION BY VD.BKG_NO ORDER BY VD.VSL_PRE_PST_CD, VD.VSL_SEQ ) ROW_NO" ).append("\n"); 
		query.append("											                                                   FROM BKG_VVD VD" ).append("\n"); 
		query.append("                                                  											  WHERE VD.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                                                 											 )" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append(" #if((${fm_dt} !='') || (${to_dt} !=''))" ).append("\n"); 
		query.append(" AND EXISTS (SELECT 'X' FROM SCE_EDI_HIS E, SCE_EDI_HIS_DTL F WHERE B.BKG_NO = E.BKG_NO AND H.CNTR_NO = E.CNTR_NO AND E.EDI_RCV_DT = F.EDI_RCV_DT(+) AND E.EDI_RCV_SEQ = F.EDI_RCV_SEQ(+)" ).append("\n"); 
		query.append("                     #if((${fm_dt} !='') || (${to_dt} !=''))" ).append("\n"); 
		query.append("                        AND E.EDI_EVNT_DT BETWEEN TO_DATE(@[fm_dt], 'YYYYMMDD' ) AND TO_DATE(@[to_dt], 'YYYYMMDD' ) + 0.9999" ).append("\n"); 
		query.append("                        #if(${edi_sts} != '')" ).append("\n"); 
		query.append("                        AND (E.EDI_STND_STS_CD IN (#foreach($ele in ${edi_sts})" ).append("\n"); 
		query.append("                                                 #if($velocityCount == 1) " ).append("\n"); 
		query.append("                                                   '$ele'" ).append("\n"); 
		query.append("                                                 #else" ).append("\n"); 
		query.append("                                                  ,'$ele'" ).append("\n"); 
		query.append("                                                 #end " ).append("\n"); 
		query.append("                                              #end  )" ).append("\n"); 
		query.append("                            OR F.EDI_STND_STS_CD IN (#foreach($ele in ${edi_sts})" ).append("\n"); 
		query.append("                                                 #if($velocityCount == 1) " ).append("\n"); 
		query.append("                                                   '$ele'" ).append("\n"); 
		query.append("                                                 #else" ).append("\n"); 
		query.append("                                                  ,'$ele'" ).append("\n"); 
		query.append("                                                 #end " ).append("\n"); 
		query.append("                                              #end  ))" ).append("\n"); 
		query.append("                        #end " ).append("\n"); 
		query.append("                     #end    " ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append(" #end " ).append("\n"); 
		query.append("#if(${trs_mode_} != 'A')" ).append("\n"); 
		query.append("      #if(${trs_mode_} == 'Y')" ).append("\n"); 
		query.append("            AND DECODE(H.COP_RAIL_CHK_CD,'','XX',H.COP_RAIL_CHK_CD) IN ('OI', 'XI') -- TRANS MODE" ).append("\n"); 
		query.append("      #else" ).append("\n"); 
		query.append("            AND DECODE(H.COP_RAIL_CHK_CD,'','XX',H.COP_RAIL_CHK_CD) NOT IN ('OI', 'XI') -- TRANS MODE" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end     " ).append("\n"); 
		query.append("#if(${edi_sts} != '')                        " ).append("\n"); 
		query.append("   AND S.EDI_STND_STS_CD IN (#foreach($ele in ${edi_sts})" ).append("\n"); 
		query.append("                                                 #if($velocityCount == 1) " ).append("\n"); 
		query.append("                                                   '$ele'" ).append("\n"); 
		query.append("                                                 #else" ).append("\n"); 
		query.append("                                                  ,'$ele'" ).append("\n"); 
		query.append("                                                 #end " ).append("\n"); 
		query.append("                                              #end )" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("   )  -- WITH END" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT '' FLAG," ).append("\n"); 
		query.append("  M.VVD," ).append("\n"); 
		query.append("  M.BKG_NO," ).append("\n"); 
		query.append("  M.BL_NO ," ).append("\n"); 
		query.append("  M.CNTR_NO," ).append("\n"); 
		query.append("  M.POR_CD," ).append("\n"); 
		query.append("  M.POL_CD," ).append("\n"); 
		query.append("  M.POD_CD," ).append("\n"); 
		query.append("  M.DEL_CD," ).append("\n"); 
		query.append("  M.COP_NO ," ).append("\n"); 
		query.append("  M.TS_PORT" ).append("\n"); 
		query.append(" #if(${edi_sts} !='')     " ).append("\n"); 
		query.append("  #foreach($ele1 in ${edi_sts})	" ).append("\n"); 
		query.append("	, m.${ele1}_1					" ).append("\n"); 
		query.append("	, m.${ele1}_2	" ).append("\n"); 
		query.append("	, m.${ele1}_3" ).append("\n"); 
		query.append("  #end  	" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("    SELECT '' ," ).append("\n"); 
		query.append("      L.VVD," ).append("\n"); 
		query.append("      L.BKG_NO," ).append("\n"); 
		query.append("      L.BL_NO ," ).append("\n"); 
		query.append("      L.CNTR_NO," ).append("\n"); 
		query.append("      L.POR_CD," ).append("\n"); 
		query.append("      L.POL_CD," ).append("\n"); 
		query.append("      L.POD_CD," ).append("\n"); 
		query.append("      L.DEL_CD," ).append("\n"); 
		query.append("      L.COP_NO ," ).append("\n"); 
		query.append("      L.TS_PORT," ).append("\n"); 
		query.append("      L.RAIL ," ).append("\n"); 
		query.append("      ROWNUM NO " ).append("\n"); 
		query.append("#if(${edi_sts} !='') " ).append("\n"); 
		query.append("  #foreach($ele1 in ${edi_sts})	 " ).append("\n"); 
		query.append("	, l.${ele1}_1					" ).append("\n"); 
		query.append("	, l.${ele1}_2	" ).append("\n"); 
		query.append("	, l.${ele1}_3" ).append("\n"); 
		query.append("  #end  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    FROM(" ).append("\n"); 
		query.append("        SELECT '' ," ).append("\n"); 
		query.append("          VVD," ).append("\n"); 
		query.append("          BKG_NO ," ).append("\n"); 
		query.append("          BL_NO ," ).append("\n"); 
		query.append("          CNTR_NO," ).append("\n"); 
		query.append("          POR_CD," ).append("\n"); 
		query.append("          POL_CD," ).append("\n"); 
		query.append("          POD_CD," ).append("\n"); 
		query.append("          DEL_CD," ).append("\n"); 
		query.append("          COP_NO ," ).append("\n"); 
		query.append("          TS_PORT," ).append("\n"); 
		query.append("          RAIL " ).append("\n"); 
		query.append("#if(${edi_sts} !='')                 " ).append("\n"); 
		query.append("  #foreach($ele1 in ${edi_sts})	                                                        " ).append("\n"); 
		query.append("    ,MAX(CASE WHEN A_EDI_STS_CD = '$ele1'                                                                     " ).append("\n"); 
		query.append("                THEN TO_CHAR(ACT_DT,'YYYYMMDD')                                                                                " ).append("\n"); 
		query.append("                ELSE NULL                                                                                  " ).append("\n"); 
		query.append("                END) ${ele1}_1                                                                                     " ).append("\n"); 
		query.append("    ,MAX(CASE WHEN A_EDI_STS_CD = '$ele1'                                                                     " ).append("\n"); 
		query.append("                THEN TO_CHAR(ACT_DT,'HH24:MI')                                                                                " ).append("\n"); 
		query.append("                ELSE NULL                                                                                  " ).append("\n"); 
		query.append("                END) ${ele1}_2                                                                                    " ).append("\n"); 
		query.append("    ,MAX(CASE WHEN A_EDI_STS_CD = '$ele1'                                                                     " ).append("\n"); 
		query.append("                THEN CUST_EDI_STS_CD                                                                               " ).append("\n"); 
		query.append("                ELSE NULL                                                                                  " ).append("\n"); 
		query.append("                END) ${ele1}_3" ).append("\n"); 
		query.append("  #end  " ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("         FROM (" ).append("\n"); 
		query.append("            SELECT RSLT.VVD," ).append("\n"); 
		query.append("              RSLT.BKG_NO," ).append("\n"); 
		query.append("              RSLT.CNTR_NO," ).append("\n"); 
		query.append("              RSLT.POR_CD," ).append("\n"); 
		query.append("              RSLT.POL_CD," ).append("\n"); 
		query.append("              RSLT.POD_CD," ).append("\n"); 
		query.append("              RSLT.DEL_CD ," ).append("\n"); 
		query.append("              RSLT.A_EDI_STS_CD ," ).append("\n"); 
		query.append("              RSLT.ACT_DT ," ).append("\n"); 
		query.append("              RSLT.COP_NO," ).append("\n"); 
		query.append("              RSLT.BL_NO," ).append("\n"); 
		query.append("              RSLT.EDI_GRP_CD," ).append("\n"); 
		query.append("              RSLT.TS_PORT," ).append("\n"); 
		query.append("              RSLT.RAIL ," ).append("\n"); 
		query.append("              RSLT.EDI_SND_KNT KNT," ).append("\n"); 
		query.append("              RSLT.MAX_EDI_SND_KNT M_KNT," ).append("\n"); 
		query.append("              RSLT.CUST_EDI_STS_CD ," ).append("\n"); 
		query.append("              ROWNUM NO" ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("                SELECT /*+ USE_NL(A D) */ A.VVD," ).append("\n"); 
		query.append("                      A.BKG_NO," ).append("\n"); 
		query.append("                      A.CNTR_NO," ).append("\n"); 
		query.append("                      A.POR_CD," ).append("\n"); 
		query.append("                      A.POL_CD," ).append("\n"); 
		query.append("                      A.POD_CD," ).append("\n"); 
		query.append("                      A.DEL_CD ," ).append("\n"); 
		query.append("                      A.A_EDI_STS_CD ," ).append("\n"); 
		query.append("                      D.ACT_DT ," ).append("\n"); 
		query.append("                      A.COP_NO," ).append("\n"); 
		query.append("                      A.BL_NO," ).append("\n"); 
		query.append("                      A.EDI_GRP_CD," ).append("\n"); 
		query.append("                      A.TS_PORT," ).append("\n"); 
		query.append("                      A.RAIL ," ).append("\n"); 
		query.append("                      D.EDI_SND_KNT," ).append("\n"); 
		query.append("                      A.CUST_EDI_STS_CD ," ).append("\n"); 
		query.append("                  MAX(D.EDI_SND_KNT) OVER ( PARTITION BY D.BKG_NO, D.CNTR_NO, D.EDI_STS_CD) MAX_EDI_SND_KNT" ).append("\n"); 
		query.append("                FROM SCE_EDI_SND_RSLT D, A" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                  #if(${cs_grp_id} != '')" ).append("\n"); 
		query.append("                  AND D.EDI_GRP_CD(+) = @[cs_grp_id]" ).append("\n"); 
		query.append("                  #end" ).append("\n"); 
		query.append("                  AND A.EDI_GRP_CD = D.EDI_GRP_CD(+)" ).append("\n"); 
		query.append("                  AND A.BKG_NO = D.BKG_NO(+)" ).append("\n"); 
		query.append("                  AND A.CNTR_NO = D.CNTR_NO(+)" ).append("\n"); 
		query.append("                  AND A.A_EDI_STS_CD = D.EDI_STS_CD(+)" ).append("\n"); 
		query.append("                  AND A.CUST_EDI_STS_CD = D.EDI_SUB_STS_CD(+)" ).append("\n"); 
		query.append("                  #if(${bkg_no_} != '' )" ).append("\n"); 
		query.append("                  AND (A.BKG_NO) IN (#foreach($ele in ${bkg_no_})" ).append("\n"); 
		query.append("                                      #if($velocityCount == 1) " ).append("\n"); 
		query.append("                                         '$ele'" ).append("\n"); 
		query.append("                                      #else" ).append("\n"); 
		query.append("                                        ,'$ele'" ).append("\n"); 
		query.append("                                      #end " ).append("\n"); 
		query.append("                                    #end  )" ).append("\n"); 
		query.append("                  #end" ).append("\n"); 
		query.append("                  #if(${cntr_no_} != '')" ).append("\n"); 
		query.append("                  AND A.CNTR_NO IN (  #foreach($ele in ${cntr_no_})" ).append("\n"); 
		query.append("                                        #if($velocityCount == 1) " ).append("\n"); 
		query.append("                                            '$ele'" ).append("\n"); 
		query.append("                                        #else" ).append("\n"); 
		query.append("                                            ,'$ele'" ).append("\n"); 
		query.append("                                        #end" ).append("\n"); 
		query.append("                                     #end " ).append("\n"); 
		query.append("                                      ,'' )" ).append("\n"); 
		query.append("                  #end " ).append("\n"); 
		query.append("                  #if(${edi_sts} != '')" ).append("\n"); 
		query.append("                  AND (A.A_EDI_STS_CD IN (#foreach($ele in ${edi_sts})" ).append("\n"); 
		query.append("                                                 #if($velocityCount == 1) " ).append("\n"); 
		query.append("                                                   '$ele'" ).append("\n"); 
		query.append("                                                 #else" ).append("\n"); 
		query.append("                                                  ,'$ele'" ).append("\n"); 
		query.append("                                                 #end " ).append("\n"); 
		query.append("                                              #end  )" ).append("\n"); 
		query.append("                   OR A.A_EDI_STS_CD IS NULL)" ).append("\n"); 
		query.append("                 #end " ).append("\n"); 
		query.append("                ) RSLT" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("        WHERE 1 = 1" ).append("\n"); 
		query.append("          AND KNT = M_KNT" ).append("\n"); 
		query.append("          OR KNT IS NULL" ).append("\n"); 
		query.append("        GROUP BY VVD, BKG_NO, CNTR_NO, POR_CD, POL_CD, POD_CD, DEL_CD , COP_NO, BL_NO, TS_PORT, RAIL" ).append("\n"); 
		query.append("        ORDER BY VVD, BKG_NO, CNTR_NO ) L ) M" ).append("\n"); 
		query.append("--WHERE NO BETWEEN ${v_startpart} AND ${v_endpart}" ).append("\n"); 

	}
}