/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PickUpNoticeDBDAOsearchPkupNoMnlUpldListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PickUpNoticeDBDAOsearchPkupNoMnlUpldListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Pickup No를 수동으로 업로드 하 기 위해 조회
	  * </pre>
	  */
	public PickUpNoticeDBDAOsearchPkupNoMnlUpldListRSQL(){
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
		params.put("dt_e",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("page_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dt_s",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pagerows",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : PickUpNoticeDBDAOsearchPkupNoMnlUpldListRSQL").append("\n"); 
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
		query.append("-- PkupNoMnlUpldVO 생성" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("        A.CHK_YN" ).append("\n"); 
		query.append("       ,A.BKG_NO " ).append("\n"); 
		query.append("       ,A.BL_NO" ).append("\n"); 
		query.append("       ,A.CNTR_PRT_FLG" ).append("\n"); 
		query.append("       ,A.CNTR_NO" ).append("\n"); 
		query.append("       ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       ,A.EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append("       ,A.FRT_CLT_FLG" ).append("\n"); 
		query.append("       ,A.OBL_RDEM_FLG" ).append("\n"); 
		query.append("       ,A.CSTMS_CLR_CD" ).append("\n"); 
		query.append("       ,A.POD_CD" ).append("\n"); 
		query.append("       ,A.IBD_TRSP_HUB_CD" ).append("\n"); 
		query.append("       ,A.DEL_CD" ).append("\n"); 
		query.append("       ,A.USA_CSTMS_FILE_CD" ).append("\n"); 
		query.append("       ,A.DE_TERM_CD" ).append("\n"); 
		query.append("       ,A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("       ,A.TO_NOD_CD" ).append("\n"); 
		query.append("       ,A.ROUTE_GUIDE" ).append("\n"); 
		query.append("       ,A.RAIL_MOVE" ).append("\n"); 
		query.append("       ,A.TRUCK_MOVE" ).append("\n"); 
		query.append("       ,A.ATA_DT" ).append("\n"); 
		query.append("       ,A.VSL_CD" ).append("\n"); 
		query.append("       ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("       ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("       ,A.VVD" ).append("\n"); 
		query.append("       ,A.RAIL_ARR_DT" ).append("\n"); 
		query.append("       ,A.PKUP_AVAL_DT" ).append("\n"); 
		query.append("       ,A.LST_FREE_DT" ).append("\n"); 
		query.append("       ,A.PKUP_NO" ).append("\n"); 
		query.append("       ,A.PKUP_YD_CD" ).append("\n"); 
		query.append("       ,A.PKUP_CRE_DT" ).append("\n"); 
		query.append("       ,A.PKUP_UPD_DT" ).append("\n"); 
		query.append("       ,A.EQ_CTRL_OFC_CD AS OFC_CD" ).append("\n"); 
		query.append("       ,A.PKUP_CRE_USR_ID" ).append("\n"); 
		query.append("       ,A.PKUP_UPD_USR_ID" ).append("\n"); 
		query.append("       ,A.PKUP_NTC_SND_KNT" ).append("\n"); 
		query.append("       ,NVL((SELECT DISTINCT 'Y' FROM BKG_PKUP_NTC T WHERE T.BKG_NO=A.BKG_NO AND T.CNTR_NO=A.CNTR_NO AND T.PKUP_NTC_SND_STS_CD='Y'),'N') AS PKUP_NTC_SND_YN" ).append("\n"); 
		query.append("       ,A.RAIL_DEP_DT" ).append("\n"); 
		query.append("       ,A.DELT_FLG       " ).append("\n"); 
		query.append("       ,A.RTN_YD_CD" ).append("\n"); 
		query.append("       ,A.ROW_COUNT" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("               '' AS CHK_YN" ).append("\n"); 
		query.append("               ,A.BKG_NO" ).append("\n"); 
		query.append("               ,A.BL_NO" ).append("\n"); 
		query.append("			   ,A.CNTR_PRT_FLG" ).append("\n"); 
		query.append("               ,A.CNTR_NO" ).append("\n"); 
		query.append("               ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("               ,A.EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append("               ,A.FRT_CLT_FLG" ).append("\n"); 
		query.append("               ,A.OBL_RDEM_FLG" ).append("\n"); 
		query.append("               ,A.CSTMS_CLR_CD" ).append("\n"); 
		query.append("               ,A.POD_CD" ).append("\n"); 
		query.append("               ,A.IBD_TRSP_HUB_CD" ).append("\n"); 
		query.append("               ,A.DEL_CD" ).append("\n"); 
		query.append("               ,A.USA_CSTMS_FILE_CD" ).append("\n"); 
		query.append("               ,A.DE_TERM_CD" ).append("\n"); 
		query.append("               ,A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("               ,A.TO_NOD_CD" ).append("\n"); 
		query.append("               ,A.ROUTE_GUIDE" ).append("\n"); 
		query.append("               ,A.RAIL_MOVE" ).append("\n"); 
		query.append("               ,A.TRUCK_MOVE" ).append("\n"); 
		query.append("               ,A.ATA_DT" ).append("\n"); 
		query.append("               ,A.VSL_CD" ).append("\n"); 
		query.append("               ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("               ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("               ,A.VVD" ).append("\n"); 
		query.append("               ,A.RAIL_ARR_DT" ).append("\n"); 
		query.append("               ,F.PKUP_AVAL_DT" ).append("\n"); 
		query.append("               ,F.LST_FREE_DT" ).append("\n"); 
		query.append("               ,F.PKUP_NO" ).append("\n"); 
		query.append("               ,F.PKUP_YD_CD" ).append("\n"); 
		query.append("               ,F.PKUP_CRE_DT" ).append("\n"); 
		query.append("               ,F.PKUP_UPD_DT" ).append("\n"); 
		query.append("               ,A.EQ_CTRL_OFC_CD AS OFC_CD" ).append("\n"); 
		query.append("               ,DECODE(F.PKUP_CRE_USR_ID,'BAT_BKG_019','EDI',F.PKUP_CRE_USR_ID) AS PKUP_CRE_USR_ID" ).append("\n"); 
		query.append("               ,DECODE(F.PKUP_UPD_USR_ID,'BAT_BKG_019','EDI',F.PKUP_UPD_USR_ID) AS PKUP_UPD_USR_ID" ).append("\n"); 
		query.append("               ,NVL(F.PKUP_NTC_SND_KNT, 0) AS PKUP_NTC_SND_KNT" ).append("\n"); 
		query.append("               ,F.RAIL_DEP_DT" ).append("\n"); 
		query.append("               ,NVL(F.DELT_FLG,'N') AS DELT_FLG       " ).append("\n"); 
		query.append("               ,NVL(F.RTN_YD_CD,(SELECT " ).append("\n"); 
		query.append("                                        CASE WHEN MAX(SUBSTR(A.EQ_TPSZ_CD,1,1)) = 'R' THEN SUBSTR(MAX(LPAD(LENGTH(RTN.PKUP_YD_ID||RTN.PKUP_CNTR_TP_ID),2,'0')||RTN.MCNTR_RTN_YD_CD),3)" ).append("\n"); 
		query.append("                                             ELSE SUBSTR(MAX(LPAD(" ).append("\n"); 
		query.append("                                                                  LENGTH(RTN.PKUP_YD_ID)+DECODE(RTN.PKUP_CNTR_TP_ID,'RF',-5,LENGTH(RTN.PKUP_CNTR_TP_ID))," ).append("\n"); 
		query.append("                                                                  2,'0')||RTN.MCNTR_RTN_YD_CD),3)" ).append("\n"); 
		query.append("                                        END" ).append("\n"); 
		query.append("                                   FROM BKG_PKUP_CNTR_RTN_YD RTN" ).append("\n"); 
		query.append("                                  WHERE A.POD_CD = RTN.POD_CD" ).append("\n"); 
		query.append("                                    AND A.DEL_CD = RTN.FNL_DEST_CD" ).append("\n"); 
		query.append("                                    AND A.TO_NOD_CD LIKE RTN.PKUP_YD_ID||'%'" ).append("\n"); 
		query.append("                                    AND RTN.DELT_FLG = 'N'))" ).append("\n"); 
		query.append("                AS RTN_YD_CD" ).append("\n"); 
		query.append("#if(${fileup} == 'Y')" ).append("\n"); 
		query.append("               ,0 ROW_NUM" ).append("\n"); 
		query.append("               ,0 ROW_COUNT" ).append("\n"); 
		query.append("#else          " ).append("\n"); 
		query.append("  #if (${excel_flg} != 'Y')" ).append("\n"); 
		query.append("               ,ROW_NUMBER() OVER (ORDER BY A.BKG_NO, A.CNTR_NO) ROW_NUM" ).append("\n"); 
		query.append("               ,COUNT(1) OVER () ROW_COUNT" ).append("\n"); 
		query.append("  #else          " ).append("\n"); 
		query.append("               ,0 ROW_NUM" ).append("\n"); 
		query.append("               ,0 ROW_COUNT" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           FROM (         " ).append("\n"); 
		query.append("                 SELECT          " ).append("\n"); 
		query.append("                        A.BKG_NO" ).append("\n"); 
		query.append("                       ,A.BL_NO AS BL_NO" ).append("\n"); 
		query.append("                       ,DECODE(NVL(E.CNTR_VOL_QTY,0),1,'N','Y') AS CNTR_PRT_FLG" ).append("\n"); 
		query.append("                       ,A.EQ_NO AS CNTR_NO" ).append("\n"); 
		query.append("                       ,E.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("					   ,DECODE(SUBSTR(D.DEL_CD,1,2),'US','PHXSA',H.EQ_CTRL_OFC_CD) EQ_CTRL_OFC_CD " ).append("\n"); 
		query.append("                       ,G.FRT_CLT_FLG" ).append("\n"); 
		query.append("                       ,G.OBL_RDEM_FLG" ).append("\n"); 
		query.append("                       ,(CASE WHEN SUBSTR(D.DEL_CD,1,2) = 'CA' THEN 'Y' --CA 인 경우 'Y' 로 고정" ).append("\n"); 
		query.append("							  WHEN SUBSTR(D.POD_CD,1,2) = 'CA' THEN                  " ).append("\n"); 
		query.append("                                   (SELECT SUBSTR(MAX(LPAD(CSTMS_SEQ,12,'0')||CSTMS_CLR_CD),-1)" ).append("\n"); 
		query.append("                                      FROM BKG_CSTMS_ADV_CNTR_RSLT CN_RSLT" ).append("\n"); 
		query.append("                                     WHERE CNT_CD  = 'US'" ).append("\n"); 
		query.append("                                       AND BL_NO   = D.BL_NO" ).append("\n"); 
		query.append("                                       AND CN_RSLT.CNTR_NO LIKE SUBSTR(E.CNTR_NO,1,LENGTH(E.CNTR_NO)-1)||'%')" ).append("\n"); 
		query.append("                              ELSE NVL(G.CSTMS_CLR_CD,'N')" ).append("\n"); 
		query.append("                         END) AS CSTMS_CLR_CD" ).append("\n"); 
		query.append("                       ,A.POD_CD" ).append("\n"); 
		query.append("                       ,I.HUB_LOC_CD AS IBD_TRSP_HUB_CD" ).append("\n"); 
		query.append("                       ,A.DEL_CD" ).append("\n"); 
		query.append("                       ,D.USA_CSTMS_FILE_CD" ).append("\n"); 
		query.append("                       ,D.DE_TERM_CD" ).append("\n"); 
		query.append("                       ,A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("                       ,A.TO_NOD_CD" ).append("\n"); 
		query.append("                       ,A.POD_CD || ' - Rail - ' || SUBSTR(A.TO_NOD_CD, 1, 5) || CASE WHEN SUBSTR(A.TO_NOD_CD, 1, 5) <> A.DEL_CD THEN ' - Truck(DR) - ' || A.DEL_CD END AS ROUTE_GUIDE" ).append("\n"); 
		query.append("                       ,A.POD_CD || ' -> ' || SUBSTR(A.TO_NOD_CD, 1, 5) AS RAIL_MOVE" ).append("\n"); 
		query.append("                       ,CASE WHEN SUBSTR(A.TO_NOD_CD, 1, 5) <> A.DEL_CD THEN SUBSTR(A.TO_NOD_CD, 1, 5) || ' -> ' || A.DEL_CD END AS TRUCK_MOVE" ).append("\n"); 
		query.append("                       ,B.VPS_ETA_DT AS ATA_DT" ).append("\n"); 
		query.append("                       ,A.VSL_CD" ).append("\n"); 
		query.append("                       ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("                       ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("                       ,A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("                       ,A.ARR_DT AS RAIL_ARR_DT" ).append("\n"); 
		query.append("                       ,ROW_NUMBER() OVER(PARTITION BY A.BKG_NO, A.EQ_NO ORDER BY A.WO_ISS_DT DESC NULLS LAST) R_ORD" ).append("\n"); 
		query.append("                   FROM TRS_TRSP_RAIL_BIL_ORD A" ).append("\n"); 
		query.append("                       ,VSK_VSL_PORT_SKD      B" ).append("\n"); 
		query.append("                       ,MDM_LOCATION          C" ).append("\n"); 
		query.append("                       ,BKG_BOOKING           D" ).append("\n"); 
		query.append("                       ,BKG_CONTAINER         E" ).append("\n"); 
		query.append("                       ,BKG_CGO_RLSE          G" ).append("\n"); 
		query.append("                       ,MDM_LOCATION          H" ).append("\n"); 
		query.append("                       ,BKG_CSTMS_ADV_BL      I" ).append("\n"); 
		query.append("                  WHERE 1= 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${fileup} == 'Y')" ).append("\n"); 
		query.append("                    AND D.BL_NO           IN (" ).append("\n"); 
		query.append("  #foreach($bl_no IN ${bl_no_list})" ).append("\n"); 
		query.append("    #if($velocityCount < $bl_no_list.size()) " ).append("\n"); 
		query.append("                                              '${bl_no}'," ).append("\n"); 
		query.append("    #else                                    " ).append("\n"); 
		query.append("                                              '${bl_no}'" ).append("\n"); 
		query.append("    #end                                     " ).append("\n"); 
		query.append("  #end                                       " ).append("\n"); 
		query.append("                                             )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${sch_tp_cd} == 'VVD')" ).append("\n"); 
		query.append("                    AND A.VSL_CD          = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                    AND A.SKD_VOY_NO      = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                    AND A.SKD_DIR_CD      = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("    #elseif (${sch_tp_cd} == 'ATA')" ).append("\n"); 
		query.append("                    AND B.VPS_ETB_DT      >= TO_DATE(@[dt_s],'YYYY-MM-DD') " ).append("\n"); 
		query.append("                    AND B.VPS_ETB_DT      < (TO_DATE(@[dt_e],'YYYY-MM-DD')+1)" ).append("\n"); 
		query.append("    #elseif (${sch_tp_cd} == 'BL')" ).append("\n"); 
		query.append("                    AND D.BL_NO           = @[bl_no]" ).append("\n"); 
		query.append("    #elseif (${sch_tp_cd} == 'CN')" ).append("\n"); 
		query.append("                    AND E.CNTR_NO         = @[cntr_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${ofc_cd} != '')" ).append("\n"); 
		query.append("                    AND C.EQ_CTRL_OFC_CD  = @[ofc_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                    AND A.DELT_FLG        = 'N'" ).append("\n"); 
		query.append("                    AND A.TRSP_BND_CD     = 'I'" ).append("\n"); 
		query.append("                    AND B.VSL_CD(+)       = A.VSL_CD" ).append("\n"); 
		query.append("                    AND B.SKD_VOY_NO(+)   = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                    AND B.SKD_DIR_CD(+)   = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                    AND B.VPS_PORT_CD(+)  = A.POD_CD" ).append("\n"); 
		query.append("                    AND B.CLPT_IND_SEQ(+) = '1'   " ).append("\n"); 
		query.append("                    AND C.LOC_CD          = A.POD_CD   " ).append("\n"); 
		query.append("                    AND D.BKG_NO          = A.BKG_NO" ).append("\n"); 
		query.append("                    AND E.BKG_NO          = A.BKG_NO" ).append("\n"); 
		query.append("                    AND E.CNTR_NO         = A.EQ_NO" ).append("\n"); 
		query.append("                    AND G.BL_NO(+)        = D.BL_NO" ).append("\n"); 
		query.append("                    AND H.LOC_CD          = D.DEL_CD" ).append("\n"); 
		query.append("                    AND I.CNT_CD(+)       = 'US'" ).append("\n"); 
		query.append("                    AND I.BL_NO(+)        = D.BL_NO" ).append("\n"); 
		query.append("                ) A" ).append("\n"); 
		query.append("               ,BKG_PKUP_NTC_PKUP_NO  F" ).append("\n"); 
		query.append("          WHERE R_ORD = 1" ).append("\n"); 
		query.append("            AND F.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("            AND F.BKG_NO(+)   = A.BKG_NO" ).append("\n"); 
		query.append("            AND F.CNTR_NO(+)  = A.CNTR_NO" ).append("\n"); 
		query.append("            AND F.OFC_CD(+)   = A.EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append("       ) A" ).append("\n"); 
		query.append("#if (${fileup} == 'Y')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  #if (${excel_flg} != 'Y')" ).append("\n"); 
		query.append(" WHERE ROW_NUM > (TO_NUMBER(@[page_no]) -1) * TO_NUMBER(@[pagerows] )" ).append("\n"); 
		query.append("   AND ROW_NUM <=  TO_NUMBER(@[page_no]) * TO_NUMBER(@[pagerows] )" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}