/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CustomerEdiDBDAOSearchDetailMvmReportRSQL.java
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

public class CustomerEdiDBDAOSearchDetailMvmReportRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchDetailMvmReport
	  * </pre>
	  */
	public CustomerEdiDBDAOSearchDetailMvmReportRSQL(){
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
		query.append("FileName : CustomerEdiDBDAOSearchDetailMvmReportRSQL").append("\n"); 
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
		query.append("                                                 #if($velocityCount == 1) " ).append("\n"); 
		query.append("                                                   '$ele'" ).append("\n"); 
		query.append("                                                 #else" ).append("\n"); 
		query.append("                                                  ,'$ele'" ).append("\n"); 
		query.append("                                                 #end " ).append("\n"); 
		query.append("                                              #end)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if(${cntr_no_} != '')" ).append("\n"); 
		query.append("    AND H.CNTR_NO IN (#foreach($ele in ${cntr_no_})" ).append("\n"); 
		query.append("                                   #if($velocityCount == 1) " ).append("\n"); 
		query.append("                                        '$ele'" ).append("\n"); 
		query.append("                                   #else" ).append("\n"); 
		query.append("                                        ,'$ele'" ).append("\n"); 
		query.append("                                   #end " ).append("\n"); 
		query.append("                                 #end " ).append("\n"); 
		query.append("                                 ,''  )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if(${por} != '')" ).append("\n"); 
		query.append("    AND B.POR_NOD_CD LIKE '${por}%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#if((${poletddate1_hidden} =='') && (${poletddate2_hidden} =='') && (${podetadate1_hidden} =='') && (${podetadate2_hidden} ==''))" ).append("\n"); 
		query.append("    #if(${pol} != '')" ).append("\n"); 
		query.append("    AND B.POL_NOD_CD LIKE '${pol}%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if(${pod} != '')" ).append("\n"); 
		query.append("    AND B.POD_NOD_CD LIKE '${pod}%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    #if(${del} != '') " ).append("\n"); 
		query.append("    AND B.DEL_NOD_CD LIKE '${del}%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if(${cop_status} == 'C')" ).append("\n"); 
		query.append("    AND H.COP_STS_CD  = 'F'			            " ).append("\n"); 
		query.append("    #elseif(${cop_status} == 'I')" ).append("\n"); 
		query.append("    AND H.COP_STS_CD  = 'T'			            " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if(${bl_no_}   != '')" ).append("\n"); 
		query.append("    AND (B.BL_NO) IN (" ).append("\n"); 
		query.append("                       #foreach($ele in ${bl_no_})" ).append("\n"); 
		query.append("                          #if($velocityCount == 1) " ).append("\n"); 
		query.append("                              '$ele'" ).append("\n"); 
		query.append("                          #else" ).append("\n"); 
		query.append("                              ,'$ele'" ).append("\n"); 
		query.append("                          #end " ).append("\n"); 
		query.append("                       #end " ).append("\n"); 
		query.append("                     )      " ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${vvd} != '')" ).append("\n"); 
		query.append("    AND EXISTS (SELECT 'X' FROM BKG_VVD V WHERE B.BKG_NO = V.BKG_NO " ).append("\n"); 
		query.append("                                        AND VSL_CD || SKD_VOY_NO || SKD_DIR_CD IN ( #foreach($ele in ${vvd})" ).append("\n"); 
		query.append("                                                                                     #if($velocityCount == 1) " ).append("\n"); 
		query.append("                                                                                       '$ele'" ).append("\n"); 
		query.append("                                                                                     #else" ).append("\n"); 
		query.append("                                                                                      ,'$ele'" ).append("\n"); 
		query.append("                                                                                     #end " ).append("\n"); 
		query.append("                                                                                   #end ) )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if((${vvd} == '') && (${bkg_no_} == '') && (${bl_no_} == '') &&  (${cntr_no_} == ''))" ).append("\n"); 
		query.append("   #if((${poletddate1_hidden} !='') || (${poletddate2_hidden} !='') ||(${podetadate1_hidden} !='') || (${podetadate2_hidden} !=''))" ).append("\n"); 
		query.append(" AND EXISTS (SELECT 'X' FROM (SELECT V.*" ).append("\n"); 
		query.append("                                FROM BKG_VVD V" ).append("\n"); 
		query.append("                                   , VSK_VSL_PORT_SKD P " ).append("\n"); 
		query.append("                               WHERE 1 = 1 " ).append("\n"); 
		query.append("                                 AND (V.VSL_CD,V.SKD_VOY_NO, V.SKD_DIR_CD) IN ((P.VSL_CD,P.SKD_VOY_NO,P.SKD_DIR_CD))" ).append("\n"); 
		query.append("                                 AND NVL(SKD_CNG_STS_CD, ' ') <> 'S' AND CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("                     -- ETD" ).append("\n"); 
		query.append("               #if((${poletddate1_hidden} !='') || (${poletddate2_hidden} !=''))" ).append("\n"); 
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
		query.append("						AND P.VPS_PORT_CD = V.POL_CD --// [2014-02-19] 추가" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("                     -- ETA   " ).append("\n"); 
		query.append("               #if((${podetadate1_hidden} !='') || (${podetadate2_hidden} !=''))      " ).append("\n"); 
		query.append("                        AND VPS_ETA_DT BETWEEN TO_DATE(@[podetadate1_hidden], 'YYYYMMDD' ) AND TO_DATE(@[podetadate2_hidden], 'YYYYMMDD' ) + 0.9999" ).append("\n"); 
		query.append("                        #if(${pod} != '')" ).append("\n"); 
		query.append("                        AND VPS_PORT_CD LIKE '${pod}%'" ).append("\n"); 
		query.append("                        AND V.POD_CD LIKE '${pod}%'" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        AND NVL(TURN_PORT_IND_CD, ' ') IN ('N', 'V', 'D', 'F')" ).append("\n"); 
		query.append("						AND V.VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append("						AND P.VPS_PORT_CD = V.POD_CD --// [2014-02-19] 추가" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("			) TG" ).append("\n"); 
		query.append("		WHERE 1 = 1" ).append("\n"); 
		query.append("          AND B.BKG_NO = TG.BKG_NO" ).append("\n"); 
		query.append("          #if(${etd_eta} == 'F_ETD')" ).append("\n"); 
		query.append("          AND (TG.BKG_NO, TG.VSL_PRE_PST_CD, TG.VSL_CD, TG.SKD_VOY_NO, TG.SKD_DIR_CD, 1) IN (SELECT VD.BKG_NO" ).append("\n"); 
		query.append("                                                         										  , VD.VSL_PRE_PST_CD                                                         " ).append("\n"); 
		query.append("                                                         										  , VD.VSL_CD" ).append("\n"); 
		query.append("                                                         										  , VD.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                         										  , VD.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                         										  , ROW_NUMBER() OVER ( PARTITION BY VD.BKG_NO ORDER BY VD.VSL_PRE_PST_CD, VD.VSL_SEQ ) ROW_NO" ).append("\n"); 
		query.append("											                                                   FROM BKG_VVD VD" ).append("\n"); 
		query.append("                                                  											  WHERE VD.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                                                 											 )" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("  #if((${fm_dt} !='') || (${to_dt} !=''))" ).append("\n"); 
		query.append(" AND EXISTS (SELECT 'X' FROM SCE_EDI_HIS E, SCE_EDI_HIS_DTL F WHERE B.BKG_NO = E.BKG_NO AND H.CNTR_NO = E.CNTR_NO AND E.EDI_RCV_DT = F.EDI_RCV_DT(+) AND E.EDI_RCV_SEQ = F.EDI_RCV_SEQ(+)" ).append("\n"); 
		query.append("                        AND E.EDI_EVNT_DT BETWEEN TO_DATE(@[fm_dt], 'YYYYMMDD' ) AND TO_DATE(@[to_dt], 'YYYYMMDD' ) + 0.9999" ).append("\n"); 
		query.append("                        #if(${edi_sts} != '') " ).append("\n"); 
		query.append("                        AND (E.EDI_STND_STS_CD IN (#foreach($ele in ${edi_sts})" ).append("\n"); 
		query.append("                                                 #if($velocityCount == 1) " ).append("\n"); 
		query.append("                                                   '$ele'" ).append("\n"); 
		query.append("                                                 #else" ).append("\n"); 
		query.append("                                                  ,'$ele'" ).append("\n"); 
		query.append("                                                 #end" ).append("\n"); 
		query.append("                                              #end ) " ).append("\n"); 
		query.append("                            OR F.EDI_STND_STS_CD IN (#foreach($ele in ${edi_sts})" ).append("\n"); 
		query.append("                                                 #if($velocityCount == 1) " ).append("\n"); 
		query.append("                                                   '$ele'" ).append("\n"); 
		query.append("                                                 #else" ).append("\n"); 
		query.append("                                                  ,'$ele'" ).append("\n"); 
		query.append("                                                 #end" ).append("\n"); 
		query.append("                                              #end))" ).append("\n"); 
		query.append("                            " ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${trs_mode_} != 'A')" ).append("\n"); 
		query.append("      #if(${trs_mode_} == 'Y')" ).append("\n"); 
		query.append("            AND DECODE(H.COP_RAIL_CHK_CD,'','XX',H.COP_RAIL_CHK_CD) IN ('OI', 'XI') -- TRANS MODE" ).append("\n"); 
		query.append("      #else" ).append("\n"); 
		query.append("            AND DECODE(H.COP_RAIL_CHK_CD,'','XX',H.COP_RAIL_CHK_CD) NOT IN ('OI', 'XI') -- TRANS MODE" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if(${edi_sts} != '')                             " ).append("\n"); 
		query.append("   AND S.EDI_STND_STS_CD IN (#foreach($ele in ${edi_sts})" ).append("\n"); 
		query.append("                                                 #if($velocityCount == 1) " ).append("\n"); 
		query.append("                                                   '$ele'" ).append("\n"); 
		query.append("                                                 #else" ).append("\n"); 
		query.append("                                                  ,'$ele'" ).append("\n"); 
		query.append("                                                 #end" ).append("\n"); 
		query.append("                                              #end )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   )  -- WITH END" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("SELECT T.VVD," ).append("\n"); 
		query.append("  T.BKG_NO," ).append("\n"); 
		query.append("  T.BL_NO," ).append("\n"); 
		query.append("  T.CNTR_NO," ).append("\n"); 
		query.append("  T.POR_CD," ).append("\n"); 
		query.append("  T.POL_CD," ).append("\n"); 
		query.append("  T.POD_CD," ).append("\n"); 
		query.append("  T.DEL_CD," ).append("\n"); 
		query.append("  '' FLAG ," ).append("\n"); 
		query.append("  T.A_EDI_STS_CD  edi_sts_cd," ).append("\n"); 
		query.append("  T.CUST_EDI_STS_CD edi_sub_sts_cd," ).append("\n"); 
		query.append("  T.EDI_SND_KNT," ).append("\n"); 
		query.append("  T.ACT_DT1," ).append("\n"); 
		query.append("  T.ACT_DT2," ).append("\n"); 
		query.append("  T.NOD_CD," ).append("\n"); 
		query.append("  T.CRE_DT1," ).append("\n"); 
		query.append("  T.CRE_DT2 ," ).append("\n"); 
		query.append("  T.GMT_DT1," ).append("\n"); 
		query.append("  T.GMT_DT2," ).append("\n"); 
		query.append("  T.RBTN ," ).append("\n"); 
		query.append("  T.COP_NO ," ).append("\n"); 
		query.append("  '' FLAG," ).append("\n"); 
		query.append("  T.TS_PORT," ).append("\n"); 
		query.append("  T.RAIL ," ).append("\n"); 
		query.append("  T.FLT_FILE_REF_NO ," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT RTRIM(XMLAGG(XMLELEMENT(X, NOD_CD||',')).EXTRACT('//text()').GETSTRINGVAL(), ',') AS DTL_NOD_CD" ).append("\n"); 
		query.append("    FROM SCE_COP_DTL DTL" ).append("\n"); 
		query.append("    WHERE COP_NO = T.COP_NO" ).append("\n"); 
		query.append("      AND T.A_EDI_STS_CD = DTL.STND_EDI_STS_CD) DTL_NOD_CD," ).append("\n"); 
		query.append("  T.ERR_MSG," ).append("\n"); 
		query.append("  T.EDI_CTRL_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT L.VVD," ).append("\n"); 
		query.append("      L.BKG_NO," ).append("\n"); 
		query.append("      L.BL_NO," ).append("\n"); 
		query.append("      L.CNTR_NO," ).append("\n"); 
		query.append("      L.POR_CD," ).append("\n"); 
		query.append("      L.POL_CD," ).append("\n"); 
		query.append("      L.POD_CD," ).append("\n"); 
		query.append("      L.DEL_CD," ).append("\n"); 
		query.append("      '' ," ).append("\n"); 
		query.append("      L.A_EDI_STS_CD," ).append("\n"); 
		query.append("      L.CUST_EDI_STS_CD," ).append("\n"); 
		query.append("      L.EDI_SND_KNT," ).append("\n"); 
		query.append("      L.ACT_DT1," ).append("\n"); 
		query.append("      L.ACT_DT2," ).append("\n"); 
		query.append("      L.NOD_CD," ).append("\n"); 
		query.append("      L.CRE_DT1," ).append("\n"); 
		query.append("      L.CRE_DT2 ," ).append("\n"); 
		query.append("      L.GMT_DT1," ).append("\n"); 
		query.append("      L.GMT_DT2 ," ).append("\n"); 
		query.append("      DECODE(L.EDI_SND_KNT, NULL, '9', CASE WHEN L.MAX_EDI_SND_KNT= L.EDI_SND_KNT THEN '0' ELSE '9' END) RBTN," ).append("\n"); 
		query.append("      L.COP_NO ," ).append("\n"); 
		query.append("      '' ," ).append("\n"); 
		query.append("      L.TS_PORT," ).append("\n"); 
		query.append("      L.RAIL ," ).append("\n"); 
		query.append("      ROWNUM NO ," ).append("\n"); 
		query.append("      L.FLT_FILE_REF_NO," ).append("\n"); 
		query.append("      L.ERR_MSG," ).append("\n"); 
		query.append("      L.EDI_CTRL_NO" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT DISTINCT DTL.VVD," ).append("\n"); 
		query.append("          DTL.BKG_NO," ).append("\n"); 
		query.append("          DTL.CNTR_NO," ).append("\n"); 
		query.append("          DTL.POR_CD," ).append("\n"); 
		query.append("          DTL.POL_CD," ).append("\n"); 
		query.append("          DTL.POD_CD," ).append("\n"); 
		query.append("          DTL.DEL_CD," ).append("\n"); 
		query.append("          '' ," ).append("\n"); 
		query.append("          DTL.A_EDI_STS_CD," ).append("\n"); 
		query.append("          DTL.CUST_EDI_STS_CD," ).append("\n"); 
		query.append("          DTL.EDI_SND_KNT," ).append("\n"); 
		query.append("          DTL.ACT_DT1," ).append("\n"); 
		query.append("          DTL.ACT_DT2," ).append("\n"); 
		query.append("          NOD_CD," ).append("\n"); 
		query.append("          DTL.CRE_DT1," ).append("\n"); 
		query.append("          DTL.CRE_DT2," ).append("\n"); 
		query.append("          '0' ," ).append("\n"); 
		query.append("          DTL.COP_NO," ).append("\n"); 
		query.append("          DTL.BL_NO," ).append("\n"); 
		query.append("          STS.EDI_STS_SEQ SORT_SEQ," ).append("\n"); 
		query.append("          DTL.ACT_DT1||DTL.ACT_DT2 SORT_DT," ).append("\n"); 
		query.append("          MAX_EDI_SND_KNT ," ).append("\n"); 
		query.append("          DTL.GMT_DT1," ).append("\n"); 
		query.append("          DTL.GMT_DT2 ," ).append("\n"); 
		query.append("          DTL.TS_PORT," ).append("\n"); 
		query.append("          DTL.RAIL ," ).append("\n"); 
		query.append("          DTL.FLT_FILE_REF_NO," ).append("\n"); 
		query.append("          DTL.ERR_MSG," ).append("\n"); 
		query.append("          DTL.EDI_CTRL_NO" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("            SELECT H.VVD," ).append("\n"); 
		query.append("              H.BKG_NO," ).append("\n"); 
		query.append("              H.CNTR_NO," ).append("\n"); 
		query.append("              H.POR_CD," ).append("\n"); 
		query.append("              H.POL_CD," ).append("\n"); 
		query.append("              H.POD_CD," ).append("\n"); 
		query.append("              H.DEL_CD," ).append("\n"); 
		query.append("              '' FLG," ).append("\n"); 
		query.append("              H.A_EDI_STS_CD," ).append("\n"); 
		query.append("              R.EDI_SND_KNT ," ).append("\n"); 
		query.append("		      R.MAX_EDI_SND_KNT ," ).append("\n"); 
		query.append("              TO_CHAR(NVL(R.ACT_DT, H.EDI_EVNT_DT), 'YYYYMMDD') ACT_DT1," ).append("\n"); 
		query.append("              TO_CHAR(NVL(R.ACT_DT, H.EDI_EVNT_DT), 'HH24MISS') ACT_DT2," ).append("\n"); 
		query.append("              NVL(R.NOD_CD, H.EVNT_YD_CD) NOD_CD," ).append("\n"); 
		query.append("              TO_CHAR(R.UPD_DT, 'YYYYMMDD') CRE_DT1," ).append("\n"); 
		query.append("              TO_CHAR(R.UPD_DT, 'HH24MISS') CRE_DT2," ).append("\n"); 
		query.append("              H.COP_NO ," ).append("\n"); 
		query.append("              H.BL_NO," ).append("\n"); 
		query.append("              R.ACT_DT," ).append("\n"); 
		query.append("              H.CUST_EDI_STS_CD ," ).append("\n"); 
		query.append("              H.TS_PORT," ).append("\n"); 
		query.append("              H.RAIL ," ).append("\n"); 
		query.append("              R.FLT_FILE_REF_NO ," ).append("\n"); 
		query.append("              TO_CHAR(R.GMT_DT, 'YYYYMMDD') GMT_DT1," ).append("\n"); 
		query.append("              TO_CHAR(R.GMT_DT, 'HH24MISS') GMT_DT2," ).append("\n"); 
		query.append("              NVL(DECODE(R.EDI_SND_RMK, 'SUCCESS(SENT)', 'S', 'SAVED', 'B', 'RESERVED', 'F' ), H.ERR_MSG) ERR_MSG," ).append("\n"); 
		query.append("              R.EDI_CTRL_NO" ).append("\n"); 
		query.append("            FROM (SELECT X.EDI_GRP_CD," ).append("\n"); 
		query.append("                       X.BKG_NO," ).append("\n"); 
		query.append("                       X.CNTR_NO," ).append("\n"); 
		query.append("                       X.EDI_STS_CD," ).append("\n"); 
		query.append("                       X.EDI_SUB_STS_CD," ).append("\n"); 
		query.append("                       X.MAX_EDI_SND_KNT," ).append("\n"); 
		query.append("                       X.EDI_SND_KNT," ).append("\n"); 
		query.append("                       X.ACT_DT," ).append("\n"); 
		query.append("                       X.NOD_CD," ).append("\n"); 
		query.append("                       X.GMT_DT," ).append("\n"); 
		query.append("                       X.UPD_DT," ).append("\n"); 
		query.append("                       X.FLT_FILE_REF_NO," ).append("\n"); 
		query.append("                       X.EDI_SND_RMK," ).append("\n"); 
		query.append("                       X.EDI_CTRL_NO" ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("            	   		 SELECT	/*+ USE_NL(A R) */ R.EDI_GRP_CD," ).append("\n"); 
		query.append("                		   		R.BKG_NO," ).append("\n"); 
		query.append("			                  	R.CNTR_NO," ).append("\n"); 
		query.append("                  				R.EDI_STS_CD," ).append("\n"); 
		query.append("                  				R.EDI_SUB_STS_CD," ).append("\n"); 
		query.append("                  				R.EDI_SND_KNT," ).append("\n"); 
		query.append("                  				MAX(R.EDI_SND_KNT) OVER ( PARTITION BY R.EDI_GRP_CD, R.BKG_NO, R.CNTR_NO, R.EDI_STS_CD, R.EDI_SUB_STS_CD) MAX_EDI_SND_KNT," ).append("\n"); 
		query.append("                  				R.ACT_DT," ).append("\n"); 
		query.append("                  				R.NOD_CD," ).append("\n"); 
		query.append("                  				R.GMT_DT," ).append("\n"); 
		query.append("                  				R.UPD_DT," ).append("\n"); 
		query.append("                  				R.FLT_FILE_REF_NO," ).append("\n"); 
		query.append("                  				R.EDI_SND_RMK," ).append("\n"); 
		query.append("                                R.EDI_CTRL_NO" ).append("\n"); 
		query.append("                		  FROM SCE_EDI_SND_RSLT R, A" ).append("\n"); 
		query.append("                		 WHERE 1 = 1" ).append("\n"); 
		query.append("                           AND A.BKG_NO = R.BKG_NO" ).append("\n"); 
		query.append("                           AND A.CNTR_NO = R.CNTR_NO" ).append("\n"); 
		query.append("                           AND A.A_EDI_STS_CD = R.EDI_STS_CD" ).append("\n"); 
		query.append("                           AND A.CUST_EDI_STS_CD = R.EDI_SUB_STS_CD" ).append("\n"); 
		query.append("                  		#if(${cs_grp_id} != '')" ).append("\n"); 
		query.append("                  		   AND R.EDI_GRP_CD = @[cs_grp_id]" ).append("\n"); 
		query.append("                  		#end" ).append("\n"); 
		query.append("                   		#if(${edi_sts} != '') " ).append("\n"); 
		query.append("                  		   AND R.EDI_STS_CD IN (#foreach($ele in ${edi_sts})" ).append("\n"); 
		query.append("                                                 #if($velocityCount == 1) " ).append("\n"); 
		query.append("                                                   '$ele'" ).append("\n"); 
		query.append("                                                 #else" ).append("\n"); 
		query.append("                                                  ,'$ele'" ).append("\n"); 
		query.append("                                                 #end" ).append("\n"); 
		query.append("                                              #end) " ).append("\n"); 
		query.append("                   		#end" ).append("\n"); 
		query.append("						 ) X" ).append("\n"); 
		query.append("                   WHERE X.MAX_EDI_SND_KNT = X.EDI_SND_KNT" ).append("\n"); 
		query.append("                  ) R," ).append("\n"); 
		query.append("                 (SELECT EDI_RCV_DT," ).append("\n"); 
		query.append("                         EDI_RCV_SEQ," ).append("\n"); 
		query.append("                         BKG_NO," ).append("\n"); 
		query.append("                         CNTR_NO," ).append("\n"); 
		query.append("                         EDI_STND_STS_CD," ).append("\n"); 
		query.append("                         CUST_EDI_STS_CD," ).append("\n"); 
		query.append("                         EDI_EVNT_DT," ).append("\n"); 
		query.append("                         EVNT_YD_CD," ).append("\n"); 
		query.append("                         VVD," ).append("\n"); 
		query.append("                         POR_CD," ).append("\n"); 
		query.append("                         POL_CD," ).append("\n"); 
		query.append("                         POD_CD," ).append("\n"); 
		query.append("                         DEL_CD," ).append("\n"); 
		query.append("                         '' FLG," ).append("\n"); 
		query.append("                         A_EDI_STS_CD," ).append("\n"); 
		query.append("                         COP_NO ," ).append("\n"); 
		query.append("                         BL_NO," ).append("\n"); 
		query.append("                         TS_PORT," ).append("\n"); 
		query.append("                         RAIL," ).append("\n"); 
		query.append("                         EDI_GRP_CD," ).append("\n"); 
		query.append("                         DECODE(ERR_MSG, 'SUCCESS(SENT)', 'S'," ).append("\n"); 
		query.append("                                'DUP RETURN!!!!', 'A'," ).append("\n"); 
		query.append("                                'SAVED', 'B',                                " ).append("\n"); 
		query.append("                                'CGO 테이블 DEL 국가 코드 불일치 Return', 'C'," ).append("\n"); 
		query.append("                                'Not Yet VE(VDT,VDL 발송 이후에 VE발송)', 'D'," ).append("\n"); 
		query.append("                                'CGO 테이블 DEL Conti 코드 미 포함으로 Return', 'E'," ).append("\n"); 
		query.append("                                'RESERVED', 'F'," ).append("\n"); 
		query.append("                                'SCE_EDI_MNG_AMS_STS 조건 불 일치', 'G'," ).append("\n"); 
		query.append("                                'DUP RETURN(VE)!!!!(VE 발송 시엔 YYYYMMDD 가 달라야 발송)', 'H'," ).append("\n"); 
		query.append("                                'AD Send Only Door Term at DEL and ID MVMT', 'I'," ).append("\n"); 
		query.append("                                'VDL,VDT 발송 History 없음(SCE_COP_DTL.edi_act_snd_dt)', 'J'," ).append("\n"); 
		query.append("                                'NT 전송시 COP 최종 ARN(최종 FIRRAD) location과 동일한 경우만 발생', 'K'," ).append("\n"); 
		query.append("                                'AG Send Only Door Term', 'L'," ).append("\n"); 
		query.append("                                'CGO 테이블 POR Conti 코드 미 포함으로 Return', 'M'," ).append("\n"); 
		query.append("                                'CGO 테이블 POR 국가 코드 미 포함으로 Return', 'N'," ).append("\n"); 
		query.append("                                'Already Finished COP', 'O'," ).append("\n"); 
		query.append("                                'NoDataCust!!', 'P', 'X') ERR_MSG" ).append("\n"); 
		query.append("                  FROM  (SELECT  X.EDI_RCV_DT," ).append("\n"); 
		query.append("                                 X.EDI_RCV_SEQ," ).append("\n"); 
		query.append("                                 A.BKG_NO," ).append("\n"); 
		query.append("                                 A.CNTR_NO," ).append("\n"); 
		query.append("                                 A.A_EDI_STS_CD EDI_STND_STS_CD," ).append("\n"); 
		query.append("                                 A.CUST_EDI_STS_CD CUST_EDI_STS_CD," ).append("\n"); 
		query.append("                                 (SELECT EDI_EVNT_DT FROM SCE_EDI_HIS WHERE EDI_RCV_DT = X.EDI_RCV_DT AND EDI_RCV_SEQ = X.EDI_RCV_SEQ) EDI_EVNT_DT," ).append("\n"); 
		query.append("                                 (SELECT EVNT_YD_CD FROM SCE_EDI_HIS WHERE EDI_RCV_DT = X.EDI_RCV_DT AND EDI_RCV_SEQ = X.EDI_RCV_SEQ) EVNT_YD_CD," ).append("\n"); 
		query.append("                                 A.VVD," ).append("\n"); 
		query.append("                                 A.POR_CD," ).append("\n"); 
		query.append("                                 A.POL_CD," ).append("\n"); 
		query.append("                                 A.POD_CD," ).append("\n"); 
		query.append("                                 A.DEL_CD," ).append("\n"); 
		query.append("                                 '' FLG," ).append("\n"); 
		query.append("                                 A.A_EDI_STS_CD," ).append("\n"); 
		query.append("                                 A.COP_NO ," ).append("\n"); 
		query.append("                                 A.BL_NO," ).append("\n"); 
		query.append("                                 A.TS_PORT," ).append("\n"); 
		query.append("                                 A.RAIL," ).append("\n"); 
		query.append("                                 A.EDI_GRP_CD," ).append("\n"); 
		query.append("                                 (SELECT NVL(F.EDI_SND_RSLT_RMK, 'NoDataCust!!')" ).append("\n"); 
		query.append("                                    FROM SCE_EDI_HIS E, SCE_EDI_HIS_DTL F " ).append("\n"); 
		query.append("                                   WHERE E.EDI_RCV_DT = X.EDI_RCV_DT " ).append("\n"); 
		query.append("                                     AND E.EDI_RCV_SEQ = X.EDI_RCV_SEQ" ).append("\n"); 
		query.append("                                     AND E.EDI_RCV_DT = F.EDI_RCV_DT(+)" ).append("\n"); 
		query.append("                                     AND E.EDI_RCV_SEQ = F.EDI_RCV_SEQ(+)" ).append("\n"); 
		query.append("                                     AND F.EDI_RCV_DTL_SEQ(+) = X.EDI_RCV_DTL_SEQ" ).append("\n"); 
		query.append("                                 ) ERR_MSG" ).append("\n"); 
		query.append("                            FROM (SELECT MAX(E.EDI_RCV_DT) EDI_RCV_DT," ).append("\n"); 
		query.append("                                         MAX(E.EDI_RCV_SEQ) EDI_RCV_SEQ," ).append("\n"); 
		query.append("                                         MAX(EDI_RCV_DTL_SEQ) EDI_RCV_DTL_SEQ," ).append("\n"); 
		query.append("                                         E.BKG_NO," ).append("\n"); 
		query.append("                                         E.CNTR_NO," ).append("\n"); 
		query.append("                                         NVL(F.EDI_STND_STS_CD, E.EDI_STND_STS_CD) EDI_STND_STS_CD," ).append("\n"); 
		query.append("                                         NVL(F.CUST_EDI_STS_CD,'') CUST_EDI_STS_CD" ).append("\n"); 
		query.append("                                    FROM SCE_EDI_HIS E, " ).append("\n"); 
		query.append("                                         SCE_EDI_HIS_DTL F," ).append("\n"); 
		query.append("                                         A" ).append("\n"); 
		query.append("                                   WHERE A.BKG_NO = E.BKG_NO" ).append("\n"); 
		query.append("                                     AND A.CNTR_NO = E.CNTR_NO" ).append("\n"); 
		query.append("                                     AND E.EDI_RCV_DT = F.EDI_RCV_DT(+) " ).append("\n"); 
		query.append("                                     AND E.EDI_RCV_SEQ = F.EDI_RCV_SEQ(+)" ).append("\n"); 
		query.append("                                     #if(${cs_grp_id} != '')" ).append("\n"); 
		query.append("                                     AND F.EDI_GRP_CD(+) = @[cs_grp_id]" ).append("\n"); 
		query.append("                                     #end" ).append("\n"); 
		query.append("                                     #if(${edi_sts} != '') " ).append("\n"); 
		query.append("                                     AND (E.EDI_STND_STS_CD IN (#foreach($ele in ${edi_sts})" ).append("\n"); 
		query.append("                                                 #if($velocityCount == 1) " ).append("\n"); 
		query.append("                                                   '$ele'" ).append("\n"); 
		query.append("                                                 #else" ).append("\n"); 
		query.append("                                                  ,'$ele'" ).append("\n"); 
		query.append("                                                 #end" ).append("\n"); 
		query.append("                                              #end )" ).append("\n"); 
		query.append("                                      OR F.EDI_STND_STS_CD IN (#foreach($ele in ${edi_sts})" ).append("\n"); 
		query.append("                                                 #if($velocityCount == 1) " ).append("\n"); 
		query.append("                                                   '$ele'" ).append("\n"); 
		query.append("                                                 #else" ).append("\n"); 
		query.append("                                                  ,'$ele'" ).append("\n"); 
		query.append("                                                 #end" ).append("\n"); 
		query.append("                                              #end ))" ).append("\n"); 
		query.append("                                     #end " ).append("\n"); 
		query.append("                                   GROUP BY E.BKG_NO," ).append("\n"); 
		query.append("                                         E.CNTR_NO," ).append("\n"); 
		query.append("                                         F.EDI_STND_STS_CD," ).append("\n"); 
		query.append("                                         E.EDI_STND_STS_CD," ).append("\n"); 
		query.append("                                         F.CUST_EDI_STS_CD" ).append("\n"); 
		query.append("                                  ) X, A" ).append("\n"); 
		query.append("                            WHERE A.BKG_NO = X.BKG_NO(+)" ).append("\n"); 
		query.append("                              AND A.CNTR_NO = X.CNTR_NO(+)" ).append("\n"); 
		query.append("                              AND A.A_EDI_STS_CD = X.EDI_STND_STS_CD(+)" ).append("\n"); 
		query.append("                              --AND A.CUST_EDI_STS_CD = NVL(X.CUST_EDI_STS_CD,A.CUST_EDI_STS_CD)" ).append("\n"); 
		query.append("                              AND A.CUST_EDI_STS_CD = X.CUST_EDI_STS_CD(+) " ).append("\n"); 
		query.append("                           )                    " ).append("\n"); 
		query.append("                   ) H               " ).append("\n"); 
		query.append("            WHERE R.EDI_GRP_CD(+) = H.EDI_GRP_CD" ).append("\n"); 
		query.append("              AND R.BKG_NO(+) = H.BKG_NO" ).append("\n"); 
		query.append("              AND R.CNTR_NO(+) = H.CNTR_NO" ).append("\n"); 
		query.append("              AND R.EDI_STS_CD(+) = H.A_EDI_STS_CD" ).append("\n"); 
		query.append("              AND R.EDI_SUB_STS_CD(+) = H.CUST_EDI_STS_CD" ).append("\n"); 
		query.append("            GROUP BY H.VVD, H.BKG_NO, H.CNTR_NO, H.POR_CD, H.POL_CD, H.POD_CD, H.DEL_CD, H.A_EDI_STS_CD, H.CUST_EDI_STS_CD , R.EDI_SND_KNT, R.MAX_EDI_SND_KNT, R.ACT_DT, H.EDI_EVNT_DT, H.EVNT_YD_CD, R.NOD_CD , R.UPD_DT, H.COP_NO, H.BL_NO , R.GMT_DT, R.EDI_SND_RMK, H.TS_PORT, H.RAIL, R.FLT_FILE_REF_NO, H.ERR_MSG, R.EDI_CTRL_NO ) DTL," ).append("\n"); 
		query.append("          EDI_CGO_STND_STS STS" ).append("\n"); 
		query.append("        WHERE STS.EDI_STND_STS_CD = DTL.A_EDI_STS_CD" ).append("\n"); 
		query.append("              #if(${missing_type} != 'ALL' && ${missing_type} != '')" ).append("\n"); 
		query.append("					#if(${missing_type2} == 'Z')" ).append("\n"); 
		query.append("						AND DTL.ERR_MSG <> 'S'" ).append("\n"); 
		query.append("					#else" ).append("\n"); 
		query.append("		                AND DTL.ERR_MSG IN (#foreach($ele in ${missing_type})" ).append("\n"); 
		query.append("                                                 #if($velocityCount == 1) " ).append("\n"); 
		query.append("                                                   '$ele'" ).append("\n"); 
		query.append("                                                 #else" ).append("\n"); 
		query.append("                                                  ,'$ele'" ).append("\n"); 
		query.append("                                                 #end" ).append("\n"); 
		query.append("                                              #end)" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("        ORDER BY VVD, BKG_NO, CNTR_NO, SORT_SEQ, MAX_EDI_SND_KNT, DTL.EDI_SND_KNT ) L ) T" ).append("\n"); 
		query.append("   --     WHERE T.NO BETWEEN ${v_startpart} AND ${v_endpart}" ).append("\n"); 

	}
}