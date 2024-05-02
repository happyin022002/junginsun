/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOSearchEDIMovementListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOSearchEDIMovementListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EES_CTM_0404 - 조회쿼리   
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOSearchEDIMovementListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_yard1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_yard2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_row_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_edi_rslt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("check_digit",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_edi_msg_tp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_cntrno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_value",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_date2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_date1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_bl",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_edi_msg_area_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("start_row_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOSearchEDIMovementListVORSQL").append("\n"); 
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
		query.append("SELECT BKG_NO," ).append("\n"); 
		query.append("       BL_NO," ).append("\n"); 
		query.append("       CALL_SGN_LLOYD," ).append("\n"); 
		query.append("       CALL_SGN_NO," ).append("\n"); 
		query.append("       LLOYD_NO," ).append("\n"); 
		query.append("       CHSS_NO," ).append("\n"); 
		query.append("       CNTR_FULL_STS_CD," ).append("\n"); 
		query.append("       CNTR_NO," ).append("\n"); 
		query.append("       CNTR_SEAL_NO," ).append("\n"); 
		query.append("       CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       CRE_LOCL_DT," ).append("\n"); 
		query.append("       VVD_CD," ).append("\n"); 
		query.append("       CRNT_VSL_CD," ).append("\n"); 
		query.append("       CRNT_SKD_VOY_NO," ).append("\n"); 
		query.append("       CRNT_SKD_DIR_CD," ).append("\n"); 
		query.append("       DEST_YD_CD," ).append("\n"); 
		query.append("       POL_CD," ).append("\n"); 
		query.append("       POD_CD," ).append("\n"); 
		query.append("       EDI_BKG_NO," ).append("\n"); 
		query.append("       EDI_GATE_IO_CD," ).append("\n"); 
		query.append("       EDI_MVMT_STS_CD," ).append("\n"); 
		query.append("       EVNT_DT," ).append("\n"); 
		query.append("       EVNT_YD_CD," ).append("\n"); 
		query.append("       MVMT_EDI_MSG_AREA_CD," ).append("\n"); 
		query.append("       MVMT_EDI_MSG_SEQ," ).append("\n"); 
		query.append("       MVMT_EDI_MSG_TP_ID," ).append("\n"); 
		query.append("       MVMT_EDI_MSG_YRMONDY," ).append("\n"); 
		query.append("       MVMT_EDI_TP_CD," ).append("\n"); 
		query.append("       MVMT_EDI_RMK," ).append("\n"); 
		query.append("       CNMV_RMK," ).append("\n"); 
		query.append("       MVMT_EDI_RSLT_CD," ).append("\n"); 
		query.append("       MVMT_EDI_SGHT_CD," ).append("\n"); 
		query.append("       MVMT_TRSP_MOD_CD," ).append("\n"); 
		query.append("       RTY_KNT," ).append("\n"); 
		query.append("       VNDR_SEQ," ).append("\n"); 
		query.append("       MGST_NO," ).append("\n"); 
		query.append("       WBL_NO," ).append("\n"); 
		query.append("       PKUP_NO," ).append("\n"); 
		query.append("       LCC_CD," ).append("\n"); 
		query.append("       VGM," ).append("\n"); 
		query.append("       VGM_MZD_TP_CD," ).append("\n"); 
		query.append("       DECODE(VGM_WGT_UT_CD, 'KGM', 'KGS', VGM_WGT_UT_CD) AS VGM_WGT_UT_CD," ).append("\n"); 
		query.append("       VGM_WGT_QTY," ).append("\n"); 
		query.append("       TO_CHAR(VGM_VRFY_DT, 'YYYYMMDDHH24MI') AS VGM_VRFY_DT," ).append("\n"); 
		query.append("       VGM_SIG_CTNT," ).append("\n"); 
		query.append("       VGM_REF_NO," ).append("\n"); 
		query.append("       VGM_WGT_PTY_CTNT," ).append("\n"); 
		query.append("       VGM_VRFY_ORD_CTNT" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("       SELECT ROW_NUMBER() OVER (ORDER BY EVNT_DT) AS ROWNO," ).append("\n"); 
		query.append("              BKG_NO," ).append("\n"); 
		query.append("              BL_NO," ).append("\n"); 
		query.append("              CALL_SGN_LLOYD," ).append("\n"); 
		query.append("              CALL_SGN_NO," ).append("\n"); 
		query.append("              LLOYD_NO," ).append("\n"); 
		query.append("              CHSS_NO," ).append("\n"); 
		query.append("              CNTR_FULL_STS_CD," ).append("\n"); 
		query.append("              CNTR_NO," ).append("\n"); 
		query.append("              CNTR_SEAL_NO," ).append("\n"); 
		query.append("              CNTR_TPSZ_CD," ).append("\n"); 
		query.append("              CRE_LOCL_DT," ).append("\n"); 
		query.append("              VVD_CD," ).append("\n"); 
		query.append("              CRNT_VSL_CD," ).append("\n"); 
		query.append("              CRNT_SKD_VOY_NO," ).append("\n"); 
		query.append("              CRNT_SKD_DIR_CD," ).append("\n"); 
		query.append("              DEST_YD_CD," ).append("\n"); 
		query.append("              POL_CD," ).append("\n"); 
		query.append("              POD_CD," ).append("\n"); 
		query.append("              EDI_BKG_NO," ).append("\n"); 
		query.append("              EDI_GATE_IO_CD," ).append("\n"); 
		query.append("              EDI_MVMT_STS_CD," ).append("\n"); 
		query.append("              EVNT_DT," ).append("\n"); 
		query.append("              EVNT_YD_CD," ).append("\n"); 
		query.append("              MVMT_EDI_MSG_AREA_CD," ).append("\n"); 
		query.append("              MVMT_EDI_MSG_SEQ," ).append("\n"); 
		query.append("              MVMT_EDI_MSG_TP_ID," ).append("\n"); 
		query.append("              MVMT_EDI_MSG_YRMONDY," ).append("\n"); 
		query.append("              MVMT_EDI_TP_CD," ).append("\n"); 
		query.append("              MVMT_EDI_RMK," ).append("\n"); 
		query.append("              CNMV_RMK," ).append("\n"); 
		query.append("              MVMT_EDI_SGHT_CD," ).append("\n"); 
		query.append("              MVMT_TRSP_MOD_CD," ).append("\n"); 
		query.append("              MVMT_EDI_RSLT_CD," ).append("\n"); 
		query.append("              RTY_KNT," ).append("\n"); 
		query.append("              VNDR_SEQ," ).append("\n"); 
		query.append("              MGST_NO," ).append("\n"); 
		query.append("              WBL_NO," ).append("\n"); 
		query.append("              PKUP_NO," ).append("\n"); 
		query.append("              LCC_CD," ).append("\n"); 
		query.append("              VGM," ).append("\n"); 
		query.append("              VGM_MZD_TP_CD," ).append("\n"); 
		query.append("              VGM_WGT_UT_CD," ).append("\n"); 
		query.append("              VGM_WGT_QTY," ).append("\n"); 
		query.append("              VGM_VRFY_DT," ).append("\n"); 
		query.append("              VGM_SIG_CTNT," ).append("\n"); 
		query.append("              VGM_REF_NO," ).append("\n"); 
		query.append("              VGM_WGT_PTY_CTNT," ).append("\n"); 
		query.append("              VGM_VRFY_ORD_CTNT" ).append("\n"); 
		query.append("         FROM (" ).append("\n"); 
		query.append("              #if (${mvmt_edi_msg_tp_id} == 'SPP')" ).append("\n"); 
		query.append("                 SELECT D.BKG_NO," ).append("\n"); 
		query.append("                        D.BL_NO," ).append("\n"); 
		query.append("                        NVL(D.CALL_SGN_NO, D.LLOYD_NO) AS CALL_SGN_LLOYD," ).append("\n"); 
		query.append("                        D.CALL_SGN_NO AS CALL_SGN_NO," ).append("\n"); 
		query.append("                        D.LLOYD_NO AS LLOYD_NO," ).append("\n"); 
		query.append("                        D.CHSS_NO," ).append("\n"); 
		query.append("                        '' AS CNTR_FULL_STS_CD," ).append("\n"); 
		query.append("                        D.CNTR_NO," ).append("\n"); 
		query.append("                        D.CNTR_SEAL_NO," ).append("\n"); 
		query.append("                        D.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                        TO_CHAR(D.CRE_LOCL_DT, 'YYYYMMDDHH24MI') AS CRE_LOCL_DT," ).append("\n"); 
		query.append("                        D.CRNT_VSL_CD||D.CRNT_SKD_VOY_NO||D.CRNT_SKD_DIR_CD AS VVD_CD," ).append("\n"); 
		query.append("                        D.CRNT_VSL_CD," ).append("\n"); 
		query.append("                        D.CRNT_SKD_VOY_NO," ).append("\n"); 
		query.append("                        D.CRNT_SKD_DIR_CD," ).append("\n"); 
		query.append("                        D.DEST_YD_CD," ).append("\n"); 
		query.append("                        '' AS POL_CD," ).append("\n"); 
		query.append("                        '' AS POD_CD," ).append("\n"); 
		query.append("                        '' AS EDI_GATE_IO_CD," ).append("\n"); 
		query.append("                        '' AS EDI_BKG_NO," ).append("\n"); 
		query.append("                        D.MVMT_STS_CD AS EDI_MVMT_STS_CD," ).append("\n"); 
		query.append("                        TO_CHAR(D.CNMV_EVNT_DT, 'YYYYMMDDHH24MI') AS EVNT_DT," ).append("\n"); 
		query.append("                        D.ORG_YD_CD AS EVNT_YD_CD," ).append("\n"); 
		query.append("                        '' AS MVMT_EDI_MSG_AREA_CD," ).append("\n"); 
		query.append("                        0 AS MVMT_EDI_MSG_SEQ," ).append("\n"); 
		query.append("                        '' AS MVMT_EDI_MSG_TP_ID," ).append("\n"); 
		query.append("                        '' AS MVMT_EDI_MSG_YRMONDY," ).append("\n"); 
		query.append("                        '' AS MVMT_EDI_TP_CD," ).append("\n"); 
		query.append("                        '' AS MVMT_EDI_RMK," ).append("\n"); 
		query.append("                        '' AS CNMV_RMK," ).append("\n"); 
		query.append("                        '' AS MVMT_EDI_SGHT_CD," ).append("\n"); 
		query.append("                        D.MVMT_TRSP_MOD_CD," ).append("\n"); 
		query.append("                        'Y' AS MVMT_EDI_RSLT_CD," ).append("\n"); 
		query.append("                        0 AS RTY_KNT," ).append("\n"); 
		query.append("                        D.VNDR_SEQ," ).append("\n"); 
		query.append("                        D.MGST_NO," ).append("\n"); 
		query.append("                        D.WBL_NO," ).append("\n"); 
		query.append("                        D.PKUP_NO," ).append("\n"); 
		query.append("                        A.LCC_CD," ).append("\n"); 
		query.append("                        D.VGM_WGT_QTY || ' ' || DECODE(D.VGM_WGT_UT_CD, 'KGM', 'KGS', D.VGM_WGT_UT_CD) AS VGM," ).append("\n"); 
		query.append("                        D.VGM_MZD_TP_CD," ).append("\n"); 
		query.append("                        D.VGM_WGT_UT_CD," ).append("\n"); 
		query.append("                        D.VGM_WGT_QTY," ).append("\n"); 
		query.append("                        D.VGM_VRFY_DT," ).append("\n"); 
		query.append("                        D.VGM_SIG_CTNT," ).append("\n"); 
		query.append("                        D.VGM_REF_NO," ).append("\n"); 
		query.append("                        D.VGM_WGT_PTY_CTNT," ).append("\n"); 
		query.append("                        D.VGM_VRFY_ORD_CTNT" ).append("\n"); 
		query.append("                   FROM MDM_EQ_ORZ_CHT A, MDM_LOCATION B, CTM_MOVEMENT D" ).append("\n"); 
		query.append("                  WHERE 1 = 1" ).append("\n"); 
		query.append("                 #if (${event_receive} == 'RECEIVE')" ).append("\n"); 
		query.append("                    AND D.UPD_LOCL_DT BETWEEN TO_DATE (@[p_date1], 'YYYY-MM-DD') AND TO_DATE (@[p_date2], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("                 #else" ).append("\n"); 
		query.append("                    AND D.CNMV_EVNT_DT BETWEEN TO_DATE (@[p_date1], 'YYYY-MM-DD') AND TO_DATE (@[p_date2], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("                 #if (${mvmt_edi_msg_area_cd} != '')" ).append("\n"); 
		query.append("                    AND D.SYS_AREA_GRP_ID = @[mvmt_edi_msg_area_cd]" ).append("\n"); 
		query.append("                 #else" ).append("\n"); 
		query.append("                    AND D.SYS_AREA_GRP_ID IN ('KOR', 'CHN', 'SWA', 'EUR', 'USA')" ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("                 #if (${bkg_bl} != '')" ).append("\n"); 
		query.append("                    AND (D.BKG_NO LIKE @[bkg_bl]||'%' OR D.BL_NO LIKE @[bkg_bl]||'%')" ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("                 #if (${check_digit} != '')" ).append("\n"); 
		query.append("                    AND D.CNTR_NO = @[p_cntrno]||@[check_digit]" ).append("\n"); 
		query.append("                 #elseif (${p_cntrno} != '')" ).append("\n"); 
		query.append("                    AND D.CNTR_NO LIKE @[p_cntrno]||'%'" ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("                #if (${cntr_no} != '')" ).append("\n"); 
		query.append("	                AND D.CNTR_NO IN (" ).append("\n"); 
		query.append("	               #foreach( $cntr_cd in ${cntr_no_list} )" ).append("\n"); 
		query.append("		             #if($velocityCount < $cntr_no_list.size()) '$cntr_cd', #else '$cntr_cd' #end" ).append("\n"); 
		query.append("	               #end" ).append("\n"); 
		query.append("	               	)" ).append("\n"); 
		query.append("	             #end" ).append("\n"); 
		query.append("                 #if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("                    AND D.CNTR_TPSZ_CD IN (${cntr_tpsz_cd})" ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("                 #if (${p_yard2} != '')" ).append("\n"); 
		query.append("                    AND D.ORG_YD_CD = @[p_yard1]||@[p_yard2]" ).append("\n"); 
		query.append("                 #elseif (${p_yard1} != '')" ).append("\n"); 
		query.append("                    AND D.ORG_YD_CD LIKE @[p_yard1]||'%'" ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("                 #if (${lcc_cd} != '')" ).append("\n"); 
		query.append("                    AND A.LCC_CD = @[lcc_cd]" ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("                 #if (${rcc_cd} != '')" ).append("\n"); 
		query.append("                    AND A.RCC_CD = @[rcc_cd]" ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("                 #if (${vvd_value} != '')" ).append("\n"); 
		query.append("                    #if (${vvd_combo} == 'VVD_CD')" ).append("\n"); 
		query.append("                       AND D.CRNT_VSL_CD||D.CRNT_SKD_VOY_NO||D.CRNT_SKD_DIR_CD LIKE @[vvd_value]||'%'" ).append("\n"); 
		query.append("                    #elseif (${vvd_combo} == 'CALL_SGN_NO')" ).append("\n"); 
		query.append("                       AND D.CALL_SGN_NO  LIKE @[vvd_value]||'%'" ).append("\n"); 
		query.append("                    #elseif (${vvd_combo} == 'LLOYD_NO')" ).append("\n"); 
		query.append("                       AND D.LLOYD_NO  LIKE @[vvd_value]||'%'" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("                 AND D.MVMT_INP_TP_CD = 'SPP'" ).append("\n"); 
		query.append("                 #if (${edi_mvmt_sts_cd} != '')" ).append("\n"); 
		query.append("                    AND D.MVMT_STS_CD IN (${edi_mvmt_sts_cd})" ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("                 AND A.SCC_CD = B.SCC_CD" ).append("\n"); 
		query.append("                 AND B.LOC_CD = SUBSTR(D.ORG_YD_CD, 0, 5)" ).append("\n"); 
		query.append("              #else" ).append("\n"); 
		query.append("                 SELECT /*+ USE_NL(D B A) */" ).append("\n"); 
		query.append("                        D.BKG_NO," ).append("\n"); 
		query.append("                        D.EDI_BL_NO AS BL_NO," ).append("\n"); 
		query.append("                        NVL(D.CALL_SGN_NO, D.LLOYD_NO) AS CALL_SGN_LLOYD," ).append("\n"); 
		query.append("                        D.CALL_SGN_NO AS CALL_SGN_NO," ).append("\n"); 
		query.append("                        D.LLOYD_NO AS LLOYD_NO," ).append("\n"); 
		query.append("                        D.CHSS_NO," ).append("\n"); 
		query.append("                        D.CNTR_FULL_STS_CD," ).append("\n"); 
		query.append("                        D.CNTR_NO," ).append("\n"); 
		query.append("                        D.CNTR_SEAL_NO," ).append("\n"); 
		query.append("                        D.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                        TO_CHAR(D.CRE_LOCL_DT, 'YYYYMMDDHH24MI') AS CRE_LOCL_DT," ).append("\n"); 
		query.append("                        D.CRNT_VSL_CD||D.CRNT_SKD_VOY_NO||D.CRNT_SKD_DIR_CD AS VVD_CD," ).append("\n"); 
		query.append("                        D.CRNT_VSL_CD," ).append("\n"); 
		query.append("                        D.CRNT_SKD_VOY_NO," ).append("\n"); 
		query.append("                        D.CRNT_SKD_DIR_CD," ).append("\n"); 
		query.append("                        D.DEST_YD_CD," ).append("\n"); 
		query.append("                        D.BKG_POL_CD AS POL_CD," ).append("\n"); 
		query.append("                        D.BKG_POD_CD AS POD_CD," ).append("\n"); 
		query.append("                        D.EDI_BKG_NO," ).append("\n"); 
		query.append("                        D.EDI_GATE_IO_CD," ).append("\n"); 
		query.append("                        D.EDI_MVMT_STS_CD," ).append("\n"); 
		query.append("                        TO_CHAR(D.EVNT_DT, 'YYYYMMDDHH24MI') AS EVNT_DT," ).append("\n"); 
		query.append("                        D.EVNT_YD_CD," ).append("\n"); 
		query.append("                        D.MVMT_EDI_MSG_AREA_CD," ).append("\n"); 
		query.append("                        D.MVMT_EDI_MSG_SEQ," ).append("\n"); 
		query.append("                        D.MVMT_EDI_MSG_TP_ID," ).append("\n"); 
		query.append("                        D.MVMT_EDI_MSG_YRMONDY," ).append("\n"); 
		query.append("                        D.MVMT_EDI_TP_CD," ).append("\n"); 
		query.append("                        D.MVMT_EDI_RMK," ).append("\n"); 
		query.append("                        D.CNMV_RMK," ).append("\n"); 
		query.append("                        D.MVMT_EDI_SGHT_CD," ).append("\n"); 
		query.append("                        D.MVMT_TRSP_MOD_CD," ).append("\n"); 
		query.append("                        D.MVMT_EDI_RSLT_CD," ).append("\n"); 
		query.append("                        D.RTY_KNT," ).append("\n"); 
		query.append("                        D.VNDR_SEQ," ).append("\n"); 
		query.append("                        D.MGST_NO," ).append("\n"); 
		query.append("                        D.WBL_NO," ).append("\n"); 
		query.append("                        D.PKUP_NO," ).append("\n"); 
		query.append("                        A.LCC_CD," ).append("\n"); 
		query.append("                        D.VGM_WGT_QTY || ' ' || DECODE(D.VGM_WGT_UT_CD, 'KGM', 'KGS', D.VGM_WGT_UT_CD) AS VGM," ).append("\n"); 
		query.append("                        D.VGM_MZD_TP_CD," ).append("\n"); 
		query.append("                        D.VGM_WGT_UT_CD," ).append("\n"); 
		query.append("                        D.VGM_WGT_QTY," ).append("\n"); 
		query.append("                        D.VGM_VRFY_DT," ).append("\n"); 
		query.append("                        D.VGM_SIG_CTNT," ).append("\n"); 
		query.append("                        D.VGM_REF_NO," ).append("\n"); 
		query.append("                        D.VGM_WGT_PTY_CTNT," ).append("\n"); 
		query.append("                        D.VGM_VRFY_ORD_CTNT" ).append("\n"); 
		query.append("                   FROM CTM_MVMT_EDI_MSG D, MDM_LOCATION B, MDM_EQ_ORZ_CHT A" ).append("\n"); 
		query.append("                  WHERE 1 = 1" ).append("\n"); 
		query.append("                 #if (${event_receive} == 'RECEIVE')" ).append("\n"); 
		query.append("                    #if (${p_date3} != '')" ).append("\n"); 
		query.append("                       AND D.IDX_CRE_LOCL_DT IN (${p_date3})" ).append("\n"); 
		query.append("                    #else" ).append("\n"); 
		query.append("                       AND D.IDX_CRE_LOCL_DT BETWEEN REPLACE (@[p_date1], '-', '') AND REPLACE (@[p_date2], '-', '')" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                 #else" ).append("\n"); 
		query.append("                    #if (${p_date3} != '')" ).append("\n"); 
		query.append("                       AND D.IDX_EVNT_DT IN (${p_date3})" ).append("\n"); 
		query.append("                    #else" ).append("\n"); 
		query.append("                       AND D.IDX_EVNT_DT BETWEEN REPLACE (@[p_date1], '-', '') AND REPLACE (@[p_date2], '-', '')" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("                 #if (${bkg_bl} != '' || ${p_cntrno} != ''|| ${cntr_no} != '')" ).append("\n"); 
		query.append("                    #if (${p_cntrno} == 'SMCU')" ).append("\n"); 
		query.append("                       #if (${mvmt_edi_msg_area_cd} != '')" ).append("\n"); 
		query.append("                          AND D.MVMT_EDI_MSG_AREA_CD = @[mvmt_edi_msg_area_cd]" ).append("\n"); 
		query.append("                       #else" ).append("\n"); 
		query.append("                          AND D.MVMT_EDI_MSG_AREA_CD IN ('KOR', 'CHN', 'SWA', 'EUR', 'USA')" ).append("\n"); 
		query.append("                       #end" ).append("\n"); 
		query.append("                    #else" ).append("\n"); 
		query.append("                       #if (${mvmt_edi_msg_area_cd} != '')" ).append("\n"); 
		query.append("                          AND TRIM (D.MVMT_EDI_MSG_AREA_CD) = @[mvmt_edi_msg_area_cd]" ).append("\n"); 
		query.append("                       #else" ).append("\n"); 
		query.append("                          AND TRIM (D.MVMT_EDI_MSG_AREA_CD) IN ('KOR', 'CHN', 'SWA', 'EUR', 'USA')" ).append("\n"); 
		query.append("                       #end" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    #if (${bkg_bl} != '')" ).append("\n"); 
		query.append("                       AND (D.BKG_NO LIKE @[bkg_bl]||'%' OR D.EDI_BL_NO LIKE @[bkg_bl]||'%')" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                 #if (${check_digit} != '')" ).append("\n"); 
		query.append("                    AND D.CNTR_NO = @[p_cntrno]||@[check_digit]" ).append("\n"); 
		query.append("                 #elseif (${p_cntrno} != '')" ).append("\n"); 
		query.append("                    AND D.CNTR_NO LIKE @[p_cntrno]||'%'" ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("              	 #if (${cntr_no} != '')" ).append("\n"); 
		query.append("	                AND D.CNTR_NO IN (" ).append("\n"); 
		query.append("	               	#foreach( $cntr_cd in ${cntr_no_list} )" ).append("\n"); 
		query.append("		              #if($velocityCount < $cntr_no_list.size()) '$cntr_cd', #else '$cntr_cd' #end" ).append("\n"); 
		query.append("	               	#end" ).append("\n"); 
		query.append("	                 	)" ).append("\n"); 
		query.append("	             #end" ).append("\n"); 
		query.append("                 #else" ).append("\n"); 
		query.append("                    #if (${mvmt_edi_msg_area_cd} != '')" ).append("\n"); 
		query.append("                       AND D.MVMT_EDI_MSG_AREA_CD = @[mvmt_edi_msg_area_cd]" ).append("\n"); 
		query.append("                    #else" ).append("\n"); 
		query.append("                       AND D.MVMT_EDI_MSG_AREA_CD IN ('KOR', 'CHN', 'SWA', 'EUR', 'USA')" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("                 #if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("                    AND D.CNTR_TPSZ_CD IN (${cntr_tpsz_cd})" ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("                 #if (${p_yard2} != '')" ).append("\n"); 
		query.append("                    ##/* AND D.EVNT_YD_CD = @[p_yard1]||@[p_yard2] */" ).append("\n"); 
		query.append("                    AND D.EVNT_YD_CD LIKE @[p_yard1]||@[p_yard2]" ).append("\n"); 
		query.append("                 #elseif (${p_yard1} != '')" ).append("\n"); 
		query.append("                    AND D.EVNT_YD_CD LIKE @[p_yard1]||'%'" ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("                 #if (${tml_nm} != '')" ).append("\n"); 
		query.append("                    AND UPPER(D.TML_NM) LIKE '%'||@[tml_nm] ||'%'" ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("                 #if (${lcc_cd} != '')" ).append("\n"); 
		query.append("                    AND A.LCC_CD = @[lcc_cd]" ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("                 #if (${rcc_cd} != '')" ).append("\n"); 
		query.append("                    AND A.RCC_CD = @[rcc_cd]" ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("                 #if (${vvd_value} != '')" ).append("\n"); 
		query.append("                    #if (${vvd_combo} == 'VVD_CD')" ).append("\n"); 
		query.append("                       AND D.CRNT_VSL_CD||D.CRNT_SKD_VOY_NO||D.CRNT_SKD_DIR_CD LIKE @[vvd_value]||'%'" ).append("\n"); 
		query.append("                    #elseif (${vvd_combo} == 'CALL_SGN_NO')" ).append("\n"); 
		query.append("                       AND D.CALL_SGN_NO  LIKE @[vvd_value]||'%'" ).append("\n"); 
		query.append("                    #elseif (${vvd_combo} == 'LLOYD_NO')" ).append("\n"); 
		query.append("                       AND D.LLOYD_NO  LIKE @[vvd_value]||'%'" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("                 #if (${cntr_full_sts_cd} == 'F')" ).append("\n"); 
		query.append("                    AND TRIM (D.CNTR_FULL_STS_CD) IN ('F', 'L', 'AH')" ).append("\n"); 
		query.append("                 #elseif (${cntr_full_sts_cd} == 'M')" ).append("\n"); 
		query.append("                    AND TRIM (D.CNTR_FULL_STS_CD) IN ('E', 'M', 'AB', 'AJ')" ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("                 #if (${mvmt_edi_msg_tp_id} != '')" ).append("\n"); 
		query.append("                    #if (${mvmt_edi_msg_tp_id} != 'ALL')" ).append("\n"); 
		query.append("                       AND D.MVMT_EDI_MSG_TP_ID = @[mvmt_edi_msg_tp_id]" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("                 #if (${mvmt_edi_rslt_cd} != '')" ).append("\n"); 
		query.append("                    #if (${mvmt_edi_rslt_cd} == 'ALL')" ).append("\n"); 
		query.append("                       AND D.MVMT_EDI_RSLT_CD IN ('Y', 'N')" ).append("\n"); 
		query.append("                    #elseif (${mvmt_edi_rslt_cd} == 'X')" ).append("\n"); 
		query.append("                       AND D.MVMT_EDI_RSLT_CD IN ('X', 'I')" ).append("\n"); 
		query.append("                    #else" ).append("\n"); 
		query.append("                       AND D.MVMT_EDI_RSLT_CD = @[mvmt_edi_rslt_cd]" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("                 #if (${edi_mvmt_sts_cd} != '')" ).append("\n"); 
		query.append("                    AND D.EDI_MVMT_STS_CD IN (${edi_mvmt_sts_cd})" ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("                 #if (${rty_knt} != '')" ).append("\n"); 
		query.append("                    #if (${rty_knt} == '0')" ).append("\n"); 
		query.append("                       AND D.RTY_KNT = 0" ).append("\n"); 
		query.append("                    #else" ).append("\n"); 
		query.append("                       AND D.RTY_KNT > 0" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("                 #if (${edi_gate_io_cd} != '')" ).append("\n"); 
		query.append("                    AND TRIM (D.EDI_GATE_IO_CD) IN (${edi_gate_io_cd})" ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("                 AND A.SCC_CD(+) = B.SCC_CD" ).append("\n"); 
		query.append("                 AND B.LOC_CD(+) = SUBSTR(D.EVNT_YD_CD, 0, 5)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				##/* Error List 조회조건 추가작업 */" ).append("\n"); 
		query.append("				#if (${err_msg_list} != '')" ).append("\n"); 
		query.append("				AND (" ).append("\n"); 
		query.append("					#foreach($err_msg in ${err_msg_list} )" ).append("\n"); 
		query.append("						#if($velocityCount < $err_msg_list.size()) " ).append("\n"); 
		query.append("							D.MVMT_EDI_RMK LIKE '$err_msg%' OR" ).append("\n"); 
		query.append("						#else " ).append("\n"); 
		query.append("							D.MVMT_EDI_RMK LIKE '$err_msg%'" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#if (${start_row_no} != '' && ${start_row_no} != '')" ).append("\n"); 
		query.append(" WHERE ROWNO BETWEEN @[start_row_no] AND @[end_row_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}