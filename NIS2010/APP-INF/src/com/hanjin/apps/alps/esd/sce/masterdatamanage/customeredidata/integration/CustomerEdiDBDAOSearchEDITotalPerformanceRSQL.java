/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CustomerEdiDBDAOSearchEDITotalPerformanceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.25
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerEdiDBDAOSearchEDITotalPerformanceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEDITotalPerformance
	  * </pre>
	  */
	public CustomerEdiDBDAOSearchEDITotalPerformanceRSQL(){
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
		query.append("FileName : CustomerEdiDBDAOSearchEDITotalPerformanceRSQL").append("\n"); 
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
		query.append("/* Main 조회조건 : CUSTOMER별 BKG_NO를 화면 조회조건이랑 엮어 필요한 BKG_NO만 골라낸다. */" ).append("\n"); 
		query.append("WITH IE AS ( /* EDI_GRP_CUST를 WITH절로 변경, 3회 조회됨 */" ).append("\n"); 
		query.append("    SELECT *" ).append("\n"); 
		query.append("    FROM EDI_GRP_CUST" ).append("\n"); 
		query.append("    WHERE 1=1 " ).append("\n"); 
		query.append("#if(${cs_grp_id} != '')" ).append("\n"); 
		query.append("    AND EDI_GRP_CD = @[cs_grp_id] --$EDI_GRP_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("), M AS (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("    B.BKG_NO" ).append("\n"); 
		query.append("    , H.CNTR_NO" ).append("\n"); 
		query.append("    , B.BL_NO" ).append("\n"); 
		query.append("    , B.POR_NOD_CD" ).append("\n"); 
		query.append("    , B.POL_NOD_CD" ).append("\n"); 
		query.append("    , B.POD_NOD_CD" ).append("\n"); 
		query.append("    , B.DEL_NOD_CD" ).append("\n"); 
		query.append("    , B.SC_NO" ).append("\n"); 
		query.append("    , B.RFA_NO" ).append("\n"); 
		query.append("    , C.EDI_STND_STS_CD" ).append("\n"); 
		query.append("    , C.CUST_EDI_STS_CD" ).append("\n"); 
		query.append("    , C.EDI_GRP_CD" ).append("\n"); 
		query.append("    FROM " ).append("\n"); 
		query.append("      BKG_BOOKING B" ).append("\n"); 
		query.append("    , BKG_CONTAINER N" ).append("\n"); 
		query.append("    , SCE_COP_HDR H" ).append("\n"); 
		query.append("    , EDI_GRP_CGO C" ).append("\n"); 
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
		query.append("                       AND IB.BKG_NO            = BB.BKG_NO" ).append("\n"); 
		query.append("#if(${fm_dt} !='' &&  ${to_dt} !='')" ).append("\n"); 
		query.append("                       AND BB.BKG_CRE_DT BETWEEN TO_DATE(@[fm_dt], 'YYYYMMDD')-200 AND TO_DATE(@[to_dt], 'YYYYMMDD' )+0.9999 -- $EDI_EVNT_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                       UNION  " ).append("\n"); 
		query.append("                       SELECT  IB.BKG_NO" ).append("\n"); 
		query.append("                       FROM    BKG_BOOKING IB, IE  " ).append("\n"); 
		query.append("                       WHERE   1=1" ).append("\n"); 
		query.append("                       AND IE.SC_NO             = IB.SC_NO" ).append("\n"); 
		query.append("                       AND IE.CGO_TRC_SVC_FLG   = 'Y'" ).append("\n"); 
		query.append("                       AND IE.IB_SVC_FLG        = 'N'" ).append("\n"); 
		query.append("                       AND IE.BKG_CTRT_DIV_CD   = '1'" ).append("\n"); 
		query.append("#if(${fm_dt} !='' &&  ${to_dt} !='')" ).append("\n"); 
		query.append("                       AND IB.BKG_CRE_DT BETWEEN TO_DATE(@[fm_dt], 'YYYYMMDD')-200 AND TO_DATE(@[to_dt], 'YYYYMMDD' )+0.9999 -- $EDI_EVNT_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                       UNION" ).append("\n"); 
		query.append("                       SELECT  IB.BKG_NO" ).append("\n"); 
		query.append("                       FROM    BKG_BOOKING IB, IE  " ).append("\n"); 
		query.append("                       WHERE   1=1" ).append("\n"); 
		query.append("                       AND IE.CGO_TRC_SVC_FLG   = 'Y'" ).append("\n"); 
		query.append("                       AND IE.IB_SVC_FLG        = 'N'" ).append("\n"); 
		query.append("                       AND IE.SC_NO             = IB.RFA_NO" ).append("\n"); 
		query.append("                       AND IE.BKG_CTRT_DIV_CD   = '2'" ).append("\n"); 
		query.append("#if(${fm_dt} !='' &&  ${to_dt} !='')" ).append("\n"); 
		query.append("                       AND IB.BKG_CRE_DT BETWEEN TO_DATE(@[fm_dt], 'YYYYMMDD')-200 AND TO_DATE(@[to_dt], 'YYYYMMDD' )+0.9999 -- $EDI_EVNT_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("    AND B.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("    AND B.BKG_NO = N.BKG_NO" ).append("\n"); 
		query.append("    AND N.BKG_NO = H.BKG_NO" ).append("\n"); 
		query.append("    AND N.CNTR_NO = H.CNTR_NO" ).append("\n"); 
		query.append("#if(${bkg_no} != '')" ).append("\n"); 
		query.append("    AND B.BKG_NO IN (" ).append("\n"); 
		query.append("     #foreach($ele in ${bkg_no})" ).append("\n"); 
		query.append("       #if($velocityCount == 1)" ).append("\n"); 
		query.append("           '$ele'" ).append("\n"); 
		query.append("       #else" ).append("\n"); 
		query.append("           ,'$ele'" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    )  -- $BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cntr_no} != '')" ).append("\n"); 
		query.append("  AND N.CNTR_NO IN (#foreach($ele in ${cntr_no})" ).append("\n"); 
		query.append("                              #if($velocityCount == 1) " ).append("\n"); 
		query.append("                                   '$ele'" ).append("\n"); 
		query.append("                              #else" ).append("\n"); 
		query.append("                                   ,'$ele'" ).append("\n"); 
		query.append("                              #end " ).append("\n"); 
		query.append("                            #end " ).append("\n"); 
		query.append("                            ,'') --$CNTR_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${bl_no} != '')" ).append("\n"); 
		query.append("  AND B.BL_NO  IN ( #foreach($ele in ${bl_no})" ).append("\n"); 
		query.append("                         #if($velocityCount == 1) " ).append("\n"); 
		query.append("                              '$ele'" ).append("\n"); 
		query.append("                         #else" ).append("\n"); 
		query.append("                               ,'$ele'" ).append("\n"); 
		query.append("                         #end " ).append("\n"); 
		query.append("                      #end   )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${por} != '') " ).append("\n"); 
		query.append("  AND B.POR_NOD_CD LIKE '${por}%' --$POR_NOD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${pol} != '')" ).append("\n"); 
		query.append("  AND B.POL_NOD_CD LIKE '${pol}%' --$POL_NOD_CD" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if(${pod} != '')" ).append("\n"); 
		query.append("  AND B.POD_NOD_CD LIKE '${pod}%' --$POD_NOD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${del} != '')" ).append("\n"); 
		query.append("  AND B.DEL_NOD_CD LIKE '${del}%' --$DEL_NOD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cop_status} == 'A') " ).append("\n"); 
		query.append("  AND H.COP_STS_CD IN ('C','T','F')" ).append("\n"); 
		query.append("#elseif(${cop_status} =='C') " ).append("\n"); 
		query.append("  AND H.COP_STS_CD = 'F'" ).append("\n"); 
		query.append("#elseif(${cop_status} == 'I') " ).append("\n"); 
		query.append("  AND H.COP_STS_CD = 'T'	" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if(${vvd} !='')" ).append("\n"); 
		query.append("  AND EXISTS (SELECT 'X' FROM BKG_VVD V WHERE B.BKG_NO = V.BKG_NO AND (VSL_CD,SKD_VOY_NO,SKD_DIR_CD) IN (" ).append("\n"); 
		query.append("                  #foreach($ele in ${vvd})" ).append("\n"); 
		query.append("                       #if($velocityCount == 1) " ).append("\n"); 
		query.append("                                  (SUBSTR('$ele',1,4),SUBSTR('$ele',5,4),SUBSTR('$ele',9,1))" ).append("\n"); 
		query.append("                       #else" ).append("\n"); 
		query.append("                                   ,(SUBSTR('$ele',1,4),SUBSTR('$ele',5,4),SUBSTR('$ele',9,1))" ).append("\n"); 
		query.append("                       #end " ).append("\n"); 
		query.append("                  #end ) ) -- $VSL_CD, $SKD_VOY_NO, $SKD_DIR_CD" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if((${vvd} == '') && (${bkg_no} == '') && (${bl_no} == '') && (${cntr_no} == ''))" ).append("\n"); 
		query.append(" AND EXISTS (SELECT 'X' FROM BKG_VVD V, VSK_VSL_PORT_SKD P WHERE B.BKG_NO = V.BKG_NO AND (V.VSL_CD,V.SKD_VOY_NO, V.SKD_DIR_CD) IN ((P.VSL_CD,P.SKD_VOY_NO,P.SKD_DIR_CD))" ).append("\n"); 
		query.append("                        AND NVL(SKD_CNG_STS_CD, ' ') <> 'S' AND CLPT_IND_SEQ = '1' " ).append("\n"); 
		query.append("                     -- ETD" ).append("\n"); 
		query.append("                    #if(${poletddate1_hidden} !='' &&  ${poletddate2_hidden} !='')" ).append("\n"); 
		query.append("                        AND VPS_ETD_DT BETWEEN TO_DATE(@[poletddate1_hidden], 'YYYYMMDD' ) AND TO_DATE(@[poletddate2_hidden], 'YYYYMMDD' ) + 0.9999 -- $VPS_ETD_DT" ).append("\n"); 
		query.append("                        #if(${pol} != '')" ).append("\n"); 
		query.append("                        AND VPS_PORT_CD LIKE  '${pol}%' --SUBSTR($POL_NOD_CD,1,5)" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        AND NVL(TURN_PORT_IND_CD, ' ') NOT IN ('V', 'D', 'F')" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                     -- ETA " ).append("\n"); 
		query.append("                    #if(${podetadate1_hidden} !='' &&  ${podetadate2_hidden} !='')  " ).append("\n"); 
		query.append("                        AND VPS_ETA_DT BETWEEN TO_DATE(@[podetadate1_hidden], 'YYYYMMDD' ) AND TO_DATE(@[podetadate2_hidden], 'YYYYMMDD' ) + 0.9999 -- VPS_ETA_DT" ).append("\n"); 
		query.append("                        #if(${pod} != '') " ).append("\n"); 
		query.append("                        AND VPS_PORT_CD LIKE '${pod}%' --SUBSTR($POD_NOD_CD,1,5)" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        AND NVL(TURN_PORT_IND_CD, ' ') IN ('N', 'V', 'D', 'F')" ).append("\n"); 
		query.append("                    #end " ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" #if(${fm_dt} !='' &&  ${to_dt} !='')" ).append("\n"); 
		query.append(" AND EXISTS (SELECT 'X' FROM SCE_EDI_HIS E, SCE_EDI_HIS_DTL F WHERE H.BKG_NO = E.BKG_NO AND H.CNTR_NO = E.CNTR_NO AND E.EDI_RCV_DT = F.EDI_RCV_DT(+) AND E.EDI_RCV_SEQ = F.EDI_RCV_SEQ(+)" ).append("\n"); 
		query.append("              AND E.EDI_EVNT_DT BETWEEN TO_DATE(@[fm_dt], 'YYYYMMDD' ) AND TO_DATE(@[to_dt], 'YYYYMMDD' ) + 0.9999 " ).append("\n"); 
		query.append("#if(${edi_sts} !='')" ).append("\n"); 
		query.append("              AND (E.EDI_STND_STS_CD IN ( " ).append("\n"); 
		query.append("#foreach($ele in ${edi_sts})" ).append("\n"); 
		query.append("       #if($velocityCount == 1)" ).append("\n"); 
		query.append("           '$ele'" ).append("\n"); 
		query.append("       #else" ).append("\n"); 
		query.append("           ,'$ele'" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")  -- $EDI_STND_STS_CD" ).append("\n"); 
		query.append("OR F.EDI_STND_STS_CD IN (" ).append("\n"); 
		query.append("#foreach($ele in ${edi_sts})" ).append("\n"); 
		query.append("       #if($velocityCount == 1)" ).append("\n"); 
		query.append("           '$ele'" ).append("\n"); 
		query.append("       #else" ).append("\n"); 
		query.append("           ,'$ele'" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("))" ).append("\n"); 
		query.append("#end             " ).append("\n"); 
		query.append("             ) -- $EDI_EVNT_DT" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if(${trs_mode_} == 'Y') " ).append("\n"); 
		query.append("   AND DECODE(H.COP_RAIL_CHK_CD,'','XX',H.COP_RAIL_CHK_CD) IN ('OI', 'XI') -- $TRANS MODE" ).append("\n"); 
		query.append("#elseif(${trs_mode_} == 'N') " ).append("\n"); 
		query.append("   AND DECODE(H.COP_RAIL_CHK_CD,'','XX',H.COP_RAIL_CHK_CD) NOT IN ('OI', 'XI')  -- $TRANS MODE" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("/* $EDI_STND_STS_CD 필수 조건 START */" ).append("\n"); 
		query.append("#if(${edi_sts} !='')" ).append("\n"); 
		query.append("   AND C.EDI_STND_STS_CD IN ( " ).append("\n"); 
		query.append("#foreach($ele in ${edi_sts})" ).append("\n"); 
		query.append("       #if($velocityCount == 1)" ).append("\n"); 
		query.append("           '$ele'" ).append("\n"); 
		query.append("       #else" ).append("\n"); 
		query.append("           ,'$ele'" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")  -- $EDI_STND_STS_CD" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("   #if(${cs_grp_id} != '') " ).append("\n"); 
		query.append("   AND C.EDI_GRP_CD      = @[cs_grp_id] -- $EDI_GRP_CD" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   AND C.EDI_SND_FLG     = 'Y'" ).append("\n"); 
		query.append("/* $EDI_STND_STS_CD 필수 조건 END*/" ).append("\n"); 
		query.append(")  -- WITH END" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Main report */" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("  S.BKG_NO" ).append("\n"); 
		query.append(", S.BL_NO" ).append("\n"); 
		query.append(", S.CNTR_NO" ).append("\n"); 
		query.append(", (SELECT CNTR_TPSZ_CD FROM MST_CONTAINER MC WHERE MC.CNTR_NO = S.CNTR_NO AND ROWNUM=1) CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", (SELECT NVL(CS.CUST_CNT_CD,'  ')||NVL(LPAD(CS.CUST_SEQ,6,'0'),'      ') FROM BKG_CUSTOMER CS WHERE CS.BKG_CUST_TP_CD = 'S' AND S.BKG_NO = CS.BKG_NO AND ROWNUM=1) SHPR_CD" ).append("\n"); 
		query.append(", (SELECT REPLACE(CS.CUST_NM, CHR(13)||CHR(10), '') FROM BKG_CUSTOMER CS WHERE CS.BKG_CUST_TP_CD = 'S' AND S.BKG_NO = CS.BKG_NO AND ROWNUM=1) SHPR_NM" ).append("\n"); 
		query.append(", (SELECT NVL(CF.CUST_CNT_CD,'  ')||NVL(LPAD(CF.CUST_SEQ,6,'0'),'      ') FROM BKG_CUSTOMER CF WHERE CF.BKG_CUST_TP_CD = 'F' AND S.BKG_NO = CF.BKG_NO AND ROWNUM=1) FWRD_CD" ).append("\n"); 
		query.append(", (SELECT REPLACE(CF.CUST_NM, CHR(13)||CHR(10), '') FROM BKG_CUSTOMER CF WHERE CF.BKG_CUST_TP_CD = 'F' AND S.BKG_NO = CF.BKG_NO AND ROWNUM=1) FWRD_NM" ).append("\n"); 
		query.append(", (SELECT NVL(CC.CUST_CNT_CD,'  ')||NVL(LPAD(CC.CUST_SEQ,6,'0'),'      ') FROM BKG_CUSTOMER CC WHERE CC.BKG_CUST_TP_CD = 'C' AND S.BKG_NO = CC.BKG_NO AND ROWNUM=1) CNEE_CD" ).append("\n"); 
		query.append(", (SELECT REPLACE(CC.CUST_NM, CHR(13)||CHR(10), '') FROM BKG_CUSTOMER CC WHERE CC.BKG_CUST_TP_CD = 'C' AND S.BKG_NO = CC.BKG_NO AND ROWNUM=1) CNEE_NM" ).append("\n"); 
		query.append(", (SELECT NVL(CN.CUST_CNT_CD,'  ')||NVL(LPAD(CN.CUST_SEQ,6,'0'),'      ') FROM BKG_CUSTOMER CN WHERE CN.BKG_CUST_TP_CD = 'N' AND S.BKG_NO = CN.BKG_NO AND ROWNUM=1) NTFY_CD" ).append("\n"); 
		query.append(", (SELECT REPLACE(CN.CUST_NM, CHR(13)||CHR(10), '') FROM BKG_CUSTOMER CN WHERE CN.BKG_CUST_TP_CD = 'N' AND S.BKG_NO = CN.BKG_NO AND ROWNUM=1) NTFY_NM" ).append("\n"); 
		query.append(", (SELECT NVL(CA.CUST_CNT_CD,'  ')||NVL(LPAD(CA.CUST_SEQ,6,'0'),'      ') FROM BKG_CUSTOMER CA WHERE CA.BKG_CUST_TP_CD = 'A' AND S.BKG_NO = CA.BKG_NO AND ROWNUM=1) ANFY_CD" ).append("\n"); 
		query.append(", (SELECT REPLACE(CA.CUST_NM, CHR(13)||CHR(10), '') FROM BKG_CUSTOMER CA WHERE CA.BKG_CUST_TP_CD = 'A' AND S.BKG_NO = CA.BKG_NO AND ROWNUM=1) ANFY_NM" ).append("\n"); 
		query.append(", (SELECT SLAN_CD FROM BKG_VVD V WHERE S.BKG_NO = V.BKG_NO AND VSL_PRE_PST_CD='T') T_LANE" ).append("\n"); 
		query.append(", (SELECT VSL_CD||SKD_VOY_NO||SKD_DIR_CD FROM BKG_VVD V WHERE S.BKG_NO = V.BKG_NO AND VSL_PRE_PST_CD='T') T_VVD" ).append("\n"); 
		query.append(", (SELECT /*+ INDEX_DESC(V XPKBKG_VVD) */ SLAN_CD FROM BKG_VVD V WHERE S.BKG_NO = V.BKG_NO AND VSL_PRE_PST_CD='S' AND ROWNUM=1) PRE_LANE" ).append("\n"); 
		query.append(", (SELECT /*+ INDEX_DESC(V XPKBKG_VVD) */ VSL_CD||SKD_VOY_NO||SKD_DIR_CD FROM BKG_VVD V WHERE S.BKG_NO = V.BKG_NO AND VSL_PRE_PST_CD='S' AND ROWNUM=1) PRE_VVD" ).append("\n"); 
		query.append(", (SELECT /*+ INDEX_ASC (V XPKBKG_VVD) */ SLAN_CD FROM BKG_VVD V WHERE S.BKG_NO = V.BKG_NO AND VSL_PRE_PST_CD='U' AND ROWNUM=1) PST_LANE" ).append("\n"); 
		query.append(", (SELECT /*+ INDEX_ASC (V XPKBKG_VVD) */ VSL_CD||SKD_VOY_NO||SKD_DIR_CD FROM BKG_VVD V WHERE S.BKG_NO = V.BKG_NO AND VSL_PRE_PST_CD='U' AND ROWNUM=1) PST_VVD" ).append("\n"); 
		query.append(", S.POR_NOD_CD" ).append("\n"); 
		query.append(", S.POL_NOD_CD" ).append("\n"); 
		query.append(", S.POD_NOD_CD" ).append("\n"); 
		query.append(", S.DEL_NOD_CD" ).append("\n"); 
		query.append(", S.SC_NO" ).append("\n"); 
		query.append(", S.RFA_NO" ).append("\n"); 
		query.append("#if(${edi_sts} !='' && ${cust_cd} !='')" ).append("\n"); 
		query.append("  #set($uline = '_V_')" ).append("\n"); 
		query.append("  #set($tmps = '')" ).append("\n"); 
		query.append("  #set($fVelocityCount = 1)" ).append("\n"); 
		query.append("  #foreach($ele1 in ${edi_sts})" ).append("\n"); 
		query.append("      #set($sVelocityCount = 1)    " ).append("\n"); 
		query.append("         #foreach($ele2 in ${cust_cd})  " ).append("\n"); 
		query.append("            #if(#$fVelocityCount == #$sVelocityCount)  " ).append("\n"); 
		query.append("               #set($tmps=$ele2)" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #set( $sVelocityCount = $sVelocityCount + 1 )   " ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("    , S.$ele1$uline$tmps" ).append("\n"); 
		query.append("  #set($fVelocityCount = $fVelocityCount+1)" ).append("\n"); 
		query.append("  #set($ediStsCount = $ediStsCount + 1)" ).append("\n"); 
		query.append("  #end  /*foreach*/" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", PFMC" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("      S.BKG_NO" ).append("\n"); 
		query.append("    , S.BL_NO" ).append("\n"); 
		query.append("    , S.CNTR_NO" ).append("\n"); 
		query.append("    , S.POR_NOD_CD" ).append("\n"); 
		query.append("    , S.POL_NOD_CD" ).append("\n"); 
		query.append("    , S.POD_NOD_CD" ).append("\n"); 
		query.append("    , S.DEL_NOD_CD" ).append("\n"); 
		query.append("    , S.SC_NO" ).append("\n"); 
		query.append("    , S.RFA_NO" ).append("\n"); 
		query.append("#if(${edi_sts} !='' && ${cust_cd} !='')" ).append("\n"); 
		query.append("  #set($uline = '_V_')" ).append("\n"); 
		query.append("  #set($tmps = '')" ).append("\n"); 
		query.append("  #set($fVelocityCount = 1)" ).append("\n"); 
		query.append("  #foreach($ele1 in ${edi_sts})" ).append("\n"); 
		query.append("      , MAX(CASE WHEN EDI_STS_CD = '$ele1'  " ).append("\n"); 
		query.append("                  #set($sVelocityCount = 1)    " ).append("\n"); 
		query.append("                  #foreach($ele2 in ${cust_cd})  " ).append("\n"); 
		query.append("                      #if(#$fVelocityCount == #$sVelocityCount)  " ).append("\n"); 
		query.append("                        AND EDI_SUB_STS_CD = '$ele2'" ).append("\n"); 
		query.append("                      #set($tmps=$ele2)" ).append("\n"); 
		query.append("                      #end" ).append("\n"); 
		query.append("                   #set( $sVelocityCount = $sVelocityCount + 1 )   " ).append("\n"); 
		query.append("    	           #end " ).append("\n"); 
		query.append("           THEN GAP_DT" ).append("\n"); 
		query.append("           END)   $ele1$uline$tmps" ).append("\n"); 
		query.append("  #set($fVelocityCount = $fVelocityCount+1)" ).append("\n"); 
		query.append("  #set($ediStsCount = $ediStsCount + 1)" ).append("\n"); 
		query.append("  #end  /*foreach*/" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    , TRUNC(SUM(GAP)/COUNT(EDI_STS_CD)*24)||':'||LPAD(TRUNC(MOD(SUM(GAP)/COUNT(EDI_STS_CD)*24,1)*60),2,'0')||':'||LPAD(TRUNC(MOD(SUM(GAP)/COUNT(EDI_STS_CD)*24*60,1)*60),2,'0') PFMC" ).append("\n"); 
		query.append("   FROM (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("          M.BKG_NO" ).append("\n"); 
		query.append("        , M.BL_NO" ).append("\n"); 
		query.append("        , M.CNTR_NO" ).append("\n"); 
		query.append("        , M.POR_NOD_CD" ).append("\n"); 
		query.append("        , M.POL_NOD_CD" ).append("\n"); 
		query.append("        , M.POD_NOD_CD" ).append("\n"); 
		query.append("        , M.DEL_NOD_CD" ).append("\n"); 
		query.append("        , M.SC_NO" ).append("\n"); 
		query.append("        , M.RFA_NO" ).append("\n"); 
		query.append("        , R.EDI_STS_CD" ).append("\n"); 
		query.append("        , R.EDI_SUB_STS_CD" ).append("\n"); 
		query.append("        , TRUNC(ABS(R.GMT_DT-R.ACT_DT)*24)||':'||LPAD(TRUNC(MOD(ABS(R.GMT_DT-R.ACT_DT)*24,1)*60),2,'0')||':'||LPAD(TRUNC(MOD(ABS(R.GMT_DT-R.ACT_DT)*24*60,1)*60),2,'0') GAP_DT" ).append("\n"); 
		query.append("        , ABS(R.GMT_DT-R.ACT_DT) GAP" ).append("\n"); 
		query.append("        FROM " ).append("\n"); 
		query.append("        M, SCE_EDI_SND_RSLT R" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND M.BKG_NO = R.BKG_NO(+)" ).append("\n"); 
		query.append("        AND M.CNTR_NO = R.CNTR_NO(+)" ).append("\n"); 
		query.append("        AND M.EDI_STND_STS_CD = R.EDI_STS_CD(+)" ).append("\n"); 
		query.append("        AND M.CUST_EDI_STS_CD = R.EDI_SUB_STS_CD(+)" ).append("\n"); 
		query.append("        AND R.EDI_GRP_CD(+) = M.EDI_GRP_CD" ).append("\n"); 
		query.append("        AND R.EDI_SND_KNT(+) = 1" ).append("\n"); 
		query.append("    ) S" ).append("\n"); 
		query.append("    GROUP BY" ).append("\n"); 
		query.append("      S.BKG_NO" ).append("\n"); 
		query.append("    , S.BL_NO" ).append("\n"); 
		query.append("    , S.CNTR_NO" ).append("\n"); 
		query.append("    , S.POR_NOD_CD" ).append("\n"); 
		query.append("    , S.POL_NOD_CD" ).append("\n"); 
		query.append("    , S.POD_NOD_CD" ).append("\n"); 
		query.append("    , S.DEL_NOD_CD" ).append("\n"); 
		query.append("    , S.SC_NO" ).append("\n"); 
		query.append("    , S.RFA_NO" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("/* Average time */" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("      '' BKG_NO" ).append("\n"); 
		query.append("    , '' BL_NO" ).append("\n"); 
		query.append("    , '' CNTR_NO" ).append("\n"); 
		query.append("    , '' POR_NOD_CD" ).append("\n"); 
		query.append("    , '' POL_NOD_CD" ).append("\n"); 
		query.append("    , '' POD_NOD_CD" ).append("\n"); 
		query.append("    , '' DEL_NOD_CD" ).append("\n"); 
		query.append("    , '' SC_NO" ).append("\n"); 
		query.append("    , 'Average time' RFA_NO" ).append("\n"); 
		query.append("#if(${edi_sts} !='' && ${cust_cd} !='')" ).append("\n"); 
		query.append("  #set($uline = '_V_')" ).append("\n"); 
		query.append("  #set($tmps = '')" ).append("\n"); 
		query.append("  #set($fVelocityCount = 1)" ).append("\n"); 
		query.append("  #foreach($ele1 in ${edi_sts})" ).append("\n"); 
		query.append("      , MAX(CASE WHEN EDI_STS_CD = '$ele1'  " ).append("\n"); 
		query.append("                  #set($sVelocityCount = 1)    " ).append("\n"); 
		query.append("                  #foreach($ele2 in ${cust_cd})  " ).append("\n"); 
		query.append("                      #if(#$fVelocityCount == #$sVelocityCount)  " ).append("\n"); 
		query.append("                        AND EDI_SUB_STS_CD = '$ele2'" ).append("\n"); 
		query.append("                      #set($tmps=$ele2)" ).append("\n"); 
		query.append("                      #end" ).append("\n"); 
		query.append("                   #set( $sVelocityCount = $sVelocityCount + 1 )   " ).append("\n"); 
		query.append("    	           #end " ).append("\n"); 
		query.append("           THEN GAP_DT" ).append("\n"); 
		query.append("           END)   $ele1$uline$tmps" ).append("\n"); 
		query.append("  #set($fVelocityCount = $fVelocityCount+1)" ).append("\n"); 
		query.append("  #set($ediStsCount = $ediStsCount + 1)" ).append("\n"); 
		query.append("  #end  /*foreach*/" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    , TRUNC(SUM(GAP)/COUNT(EDI_STS_CD)*24)||':'||LPAD(TRUNC(MOD(SUM(GAP)/COUNT(EDI_STS_CD)*24,1)*60),2,'0')||':'||LPAD(TRUNC(MOD(SUM(GAP)/COUNT(EDI_STS_CD)*24*60,1)*60),2,'0') PFMC" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("          SUM(ABS(GMT_DT-ACT_DT))/COUNT(R.BKG_NO) GAP" ).append("\n"); 
		query.append("        , TRUNC(SUM(ABS(GMT_DT-ACT_DT))/COUNT(R.BKG_NO)*24)||':'||LPAD(TRUNC(MOD(SUM(ABS(GMT_DT-ACT_DT))/COUNT(R.BKG_NO)*24,1)*60),2,'0')||':'||LPAD(TRUNC(MOD(SUM(ABS(GMT_DT-ACT_DT))/COUNT(R.BKG_NO)*24*60,1)*60),2,'0') GAP_DT" ).append("\n"); 
		query.append("        , COUNT(EDI_STS_CD) STS_CNT" ).append("\n"); 
		query.append("        , R.EDI_STS_CD" ).append("\n"); 
		query.append("        , R.EDI_SUB_STS_CD" ).append("\n"); 
		query.append("        FROM " ).append("\n"); 
		query.append("        M, SCE_EDI_SND_RSLT R" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND M.BKG_NO = R.BKG_NO(+)" ).append("\n"); 
		query.append("        AND M.CNTR_NO = R.CNTR_NO(+)" ).append("\n"); 
		query.append("        AND M.EDI_STND_STS_CD = R.EDI_STS_CD(+)" ).append("\n"); 
		query.append("        AND M.CUST_EDI_STS_CD = R.EDI_SUB_STS_CD(+)" ).append("\n"); 
		query.append("        AND R.EDI_GRP_CD(+) = M.EDI_GRP_CD" ).append("\n"); 
		query.append("        AND R.EDI_SND_KNT(+) = 1" ).append("\n"); 
		query.append("       GROUP BY R.EDI_STS_CD, R.EDI_SUB_STS_CD" ).append("\n"); 
		query.append("    ) T" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("/* Missing & total */" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("      '' BKG_NO" ).append("\n"); 
		query.append("    , '' BL_NO" ).append("\n"); 
		query.append("    , '' CNTR_NO" ).append("\n"); 
		query.append("    , '' POR_NOD_CD" ).append("\n"); 
		query.append("    , '' POL_NOD_CD" ).append("\n"); 
		query.append("    , '' POD_NOD_CD" ).append("\n"); 
		query.append("    , '' DEL_NOD_CD" ).append("\n"); 
		query.append("    , '' SC_NO" ).append("\n"); 
		query.append("    , 'Sent' RFA_NO" ).append("\n"); 
		query.append("#if(${edi_sts} !='' && ${cust_cd} !='') " ).append("\n"); 
		query.append("  #set($uline = '_V_')" ).append("\n"); 
		query.append("  #set($tmps = '')" ).append("\n"); 
		query.append("  #set($fVelocityCount = 1)" ).append("\n"); 
		query.append("  #foreach($ele1 in ${edi_sts})" ).append("\n"); 
		query.append("      , MAX(CASE WHEN EDI_STS_CD = '$ele1'  " ).append("\n"); 
		query.append("                  #set($sVelocityCount = 1)    " ).append("\n"); 
		query.append("                  #foreach($ele2 in ${cust_cd})  " ).append("\n"); 
		query.append("                      #if(#$fVelocityCount == #$sVelocityCount)  " ).append("\n"); 
		query.append("                        AND EDI_SUB_STS_CD = '$ele2'" ).append("\n"); 
		query.append("                      #set($tmps=$ele2)" ).append("\n"); 
		query.append("                      #end" ).append("\n"); 
		query.append("                   #set( $sVelocityCount = $sVelocityCount + 1 )   " ).append("\n"); 
		query.append("    	           #end " ).append("\n"); 
		query.append("           THEN C_CNT" ).append("\n"); 
		query.append("           END)   $ele1$uline$tmps" ).append("\n"); 
		query.append("  #set($fVelocityCount = $fVelocityCount+1)" ).append("\n"); 
		query.append("  #set($ediStsCount = $ediStsCount + 1)" ).append("\n"); 
		query.append("  #end  /*foreach*/" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    , TO_CHAR(ROUND(AVG(B_CNT),1),'990.9')||'/'||AVG(N_CNT) PFMC" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("          COUNT(R.BKG_NO)||'/'||COUNT(M.CNTR_NO) C_CNT" ).append("\n"); 
		query.append("        , M.EDI_STND_STS_CD EDI_STS_CD" ).append("\n"); 
		query.append("        , M.CUST_EDI_STS_CD EDI_SUB_STS_CD" ).append("\n"); 
		query.append("        , COUNT(R.BKG_NO) B_CNT" ).append("\n"); 
		query.append("        , COUNT(M.CNTR_NO) N_CNT" ).append("\n"); 
		query.append("        FROM " ).append("\n"); 
		query.append("        M, SCE_EDI_SND_RSLT R" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND M.BKG_NO = R.BKG_NO(+)" ).append("\n"); 
		query.append("        AND M.CNTR_NO = R.CNTR_NO(+)" ).append("\n"); 
		query.append("        AND M.EDI_STND_STS_CD = R.EDI_STS_CD(+)" ).append("\n"); 
		query.append("        AND M.CUST_EDI_STS_CD = R.EDI_SUB_STS_CD(+)" ).append("\n"); 
		query.append("        AND R.EDI_GRP_CD(+) = M.EDI_GRP_CD" ).append("\n"); 
		query.append("        AND R.EDI_SND_KNT(+) = 1" ).append("\n"); 
		query.append("       GROUP BY M.EDI_STND_STS_CD, M.CUST_EDI_STS_CD" ).append("\n"); 
		query.append("    ) U    " ).append("\n"); 
		query.append(") S" ).append("\n"); 

	}
}