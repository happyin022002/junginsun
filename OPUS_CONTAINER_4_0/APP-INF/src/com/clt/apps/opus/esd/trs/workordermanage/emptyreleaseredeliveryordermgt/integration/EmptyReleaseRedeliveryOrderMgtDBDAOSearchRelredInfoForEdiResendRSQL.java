/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EmptyReleaseRedeliveryOrderMgtDBDAOSearchRelredInfoForEdiResendRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.06
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2016.10.06 박찬우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chanwoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyReleaseRedeliveryOrderMgtDBDAOSearchRelredInfoForEdiResendRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RELRED EDI Resend를 위한 Info 정보 조회
	  * </pre>
	  */
	public EmptyReleaseRedeliveryOrderMgtDBDAOSearchRelredInfoForEdiResendRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.integration").append("\n"); 
		query.append("FileName : EmptyReleaseRedeliveryOrderMgtDBDAOSearchRelredInfoForEdiResendRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append("      ,TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("      ,TRSP_SO_SEQ" ).append("\n"); 
		query.append("      ,TRSP_BND_CD" ).append("\n"); 
		query.append("	  ,TRO_SEQ" ).append("\n"); 
		query.append("      ,VENDOR" ).append("\n"); 
		query.append("      ,TRANS_MODE" ).append("\n"); 
		query.append("      ,PD_DT" ).append("\n"); 
		query.append("      ,SPCL_INST" ).append("\n"); 
		query.append("      ,CNTR_NO" ).append("\n"); 
		query.append("      ,CNTR_TYPE" ).append("\n"); 
		query.append("      ,UCR" ).append("\n"); 
		query.append("      ,CARGOTYPE" ).append("\n"); 
		query.append("      ,SEAL" ).append("\n"); 
		query.append("      ,CNTR_QTY" ).append("\n"); 
		query.append("      ,DIND" ).append("\n"); 
		query.append("      ,RIND" ).append("\n"); 
		query.append("      ,AIND" ).append("\n"); 
		query.append("      ,TEMP_F" ).append("\n"); 
		query.append("      ,TEMP_C" ).append("\n"); 
		query.append("      ,RF_VOLTAGE" ).append("\n"); 
		query.append("      ,VENT" ).append("\n"); 
		query.append("      ,VENT_CMH" ).append("\n"); 
		query.append("      ,VENT_PCT" ).append("\n"); 
		query.append("      ,HUMID" ).append("\n"); 
		query.append("      ,GENSET" ).append("\n"); 
		query.append("      ,RF_REMARK" ).append("\n"); 
		query.append("      ,RFDRY_IND" ).append("\n"); 
		query.append("      ,RF_DRAIN" ).append("\n"); 
		query.append("      ,OVF" ).append("\n"); 
		query.append("      ,OVR" ).append("\n"); 
		query.append("      ,OVH" ).append("\n"); 
		query.append("      ,OVLW" ).append("\n"); 
		query.append("      ,OVRW" ).append("\n"); 
		query.append("      ,OVWGT" ).append("\n"); 
		query.append("      ,VOID_SLOT" ).append("\n"); 
		query.append("      ,STWG_REQ" ).append("\n"); 
		query.append("      ,TTL_DIM_LEN" ).append("\n"); 
		query.append("      ,TTL_DIM_WDT" ).append("\n"); 
		query.append("      ,TTL_DIM_HGT" ).append("\n"); 
		query.append("      ,CMD" ).append("\n"); 
		query.append("      ,CMDD" ).append("\n"); 
		query.append("      ,WGT_UNIT AS GWGTUNIT" ).append("\n"); 
		query.append("      ,TRIM(REGEXP_SUBSTR(T.WGT_STR, '[^|]+', 1, 3)) AS GWGT" ).append("\n"); 
		query.append("      ,WGT_UNIT AS NWGTUNIT" ).append("\n"); 
		query.append("      ,TRIM(REGEXP_SUBSTR(T.WGT_STR, '[^|]+', 1, 1)) AS NWGT" ).append("\n"); 
		query.append("      ,WGT_UNIT AS TWGTUNIT" ).append("\n"); 
		query.append("      ,TRIM(REGEXP_SUBSTR(T.WGT_STR, '[^|]+', 1, 2)) AS TWGT" ).append("\n"); 
		query.append("      ,CNTR_SLT_NO" ).append("\n"); 
		query.append("  FROM (SELECT ORD.BKG_NO" ).append("\n"); 
		query.append("              ,ORD.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("              ,ORD.TRSP_SO_SEQ" ).append("\n"); 
		query.append("			  ,ORD.TRSP_BND_CD" ).append("\n"); 
		query.append("			  ,ORD.TRO_SEQ" ).append("\n"); 
		query.append("              ,VNDR.VNDR_LGL_ENG_NM AS VENDOR" ).append("\n"); 
		query.append("              ,CASE WHEN SUBSTR(ORD.TRSP_CRR_MOD_CD, 1, 1) = 'W'" ).append("\n"); 
		query.append("                    THEN 'F'" ).append("\n"); 
		query.append("                    ELSE SUBSTR(ORD.TRSP_CRR_MOD_CD, 1, 1)" ).append("\n"); 
		query.append("               END AS TRANS_MODE" ).append("\n"); 
		query.append("              ,TO_CHAR(ORD.N1ST_NOD_PLN_DT, 'YYYYMMDDHHMM') AS PD_DT" ).append("\n"); 
		query.append("              ,REPLACE(REPLACE(EUR.SPCL_INSTR_RMK, CHR(13), ' '), CHR(10), ' ') AS SPCL_INST" ).append("\n"); 
		query.append("              ,ORD.EQ_NO AS CNTR_NO" ).append("\n"); 
		query.append("              ,ORD.EQ_TPSZ_CD AS CNTR_TYPE" ).append("\n"); 
		query.append("              ,NVL((SELECT BR.CUST_REF_NO_CTNT FROM BKG_REFERENCE BR WHERE BR.BKG_REF_TP_CD = 'CUCR' AND BR.BKG_NO = ORD.BKG_NO AND BR.CNTR_NO = ORD.EQ_NO AND ROWNUM = 1)" ).append("\n"); 
		query.append("                  ,(SELECT BR.CUST_REF_NO_CTNT FROM BKG_REFERENCE BR WHERE BR.BKG_REF_TP_CD = 'CUCR' AND BR.BKG_NO = ORD.BKG_NO AND ROWNUM = 1)) AS UCR" ).append("\n"); 
		query.append("              ,NVL(ORD.CGO_TP_CD, 'M') AS CARGOTYPE" ).append("\n"); 
		query.append("              ,(SELECT CNTR_SEAL_NO FROM BKG_CNTR_SEAL_NO WHERE BKG_NO = ORD.BKG_NO AND ROWNUM = 1) AS SEAL" ).append("\n"); 
		query.append("              ,COUNT(ORD.EQ_TPSZ_CD) AS CNTR_QTY" ).append("\n"); 
		query.append("              ,CASE" ).append("\n"); 
		query.append("                 WHEN (SELECT COUNT(*) FROM BKG_DG_CGO WHERE BKG_NO = ORD.BKG_NO AND CNTR_NO = ORD.EQ_NO) > 0 THEN 'Y'" ).append("\n"); 
		query.append("                 ELSE 'N'" ).append("\n"); 
		query.append("               END AS DIND" ).append("\n"); 
		query.append("              ,CASE" ).append("\n"); 
		query.append("                 WHEN COUNT(RF.CNTR_NO) > 0 THEN 'Y'" ).append("\n"); 
		query.append("                 ELSE 'N'" ).append("\n"); 
		query.append("               END AS RIND" ).append("\n"); 
		query.append("              ,CASE" ).append("\n"); 
		query.append("                 WHEN COUNT(AWK.CNTR_NO) > 0 THEN 'Y'" ).append("\n"); 
		query.append("                 ELSE 'N'" ).append("\n"); 
		query.append("               END AS AIND" ).append("\n"); 
		query.append("              ,RF.FDO_TEMP AS TEMP_F" ).append("\n"); 
		query.append("              ,RF.CDO_TEMP AS TEMP_C" ).append("\n"); 
		query.append("              ,RF.VLTG_NO AS RF_VOLTAGE" ).append("\n"); 
		query.append("              ,RF.CNTR_VENT_TP_CD AS VENT" ).append("\n"); 
		query.append("              ,RF.CBM_PER_HR_QTY AS VENT_CMH" ).append("\n"); 
		query.append("              ,RF.VENT_RTO AS VENT_PCT" ).append("\n"); 
		query.append("              ,RF.HUMID_NO AS HUMID" ).append("\n"); 
		query.append("              ,RF.PWR_SPL_CBL_FLG AS GENSET" ).append("\n"); 
		query.append("              ,REPLACE(REPLACE(RF.DIFF_RMK, CHR(13), ' '), CHR(10), ' ') AS RF_REMARK" ).append("\n"); 
		query.append("              ,CASE" ).append("\n"); 
		query.append("                 WHEN COUNT(RF.CNTR_NO) > 0 THEN 'Y'" ).append("\n"); 
		query.append("                 ELSE 'N'" ).append("\n"); 
		query.append("               END AS RFDRY_IND" ).append("\n"); 
		query.append("              ,RF.CNTR_DRN_CD AS RF_DRAIN" ).append("\n"); 
		query.append("              ,AWK.OVR_BKWD_LEN AS OVF" ).append("\n"); 
		query.append("              ,AWK.OVR_FWRD_LEN AS OVR" ).append("\n"); 
		query.append("              ,AWK.OVR_HGT AS OVH" ).append("\n"); 
		query.append("              ,AWK.OVR_LF_LEN AS OVLW" ).append("\n"); 
		query.append("              ,AWK.OVR_RT_LEN AS OVRW" ).append("\n"); 
		query.append("              ,AWK.GRS_WGT || AWK.WGT_UT_CD AS OVWGT" ).append("\n"); 
		query.append("              ,AWK.OVR_VOID_SLT_QTY AS VOID_SLOT" ).append("\n"); 
		query.append("              ,AWK.STWG_RQST_DESC AS STWG_REQ" ).append("\n"); 
		query.append("              ,AWK.TTL_DIM_LEN AS TTL_DIM_LEN" ).append("\n"); 
		query.append("              ,AWK.TTL_DIM_WDT AS TTL_DIM_WDT" ).append("\n"); 
		query.append("              ,AWK.TTL_DIM_HGT AS TTL_DIM_HGT" ).append("\n"); 
		query.append("              ,ORD.CMDT_CD AS CMD" ).append("\n"); 
		query.append("              ,M.CMDT_NM CMDD" ).append("\n"); 
		query.append("              ,TRS_GET_COM_SO_RAIL_WGT_FNC('S', ORD.TRSP_SO_OFC_CTY_CD, ORD.TRSP_SO_SEQ, '', ORD.BKG_NO, ORD.EQ_NO, ORD.EQ_TPSZ_CD, NVL(NVL(B.WGT_UT_CD, ORD.WGT_MEAS_UT_CD), 'KGS'), NULL, 'Y') AS WGT_STR" ).append("\n"); 
		query.append("              ,NVL(NVL(B.WGT_UT_CD, ORD.WGT_MEAS_UT_CD), 'KGS') AS WGT_UNIT" ).append("\n"); 
		query.append("              ,ORD.CNTR_SLT_NO" ).append("\n"); 
		query.append("          FROM TRS_TRSP_SVC_ORD         ORD" ).append("\n"); 
		query.append("              ,MDM_VENDOR               VNDR" ).append("\n"); 
		query.append("              ,BKG_EUR_TRO              EUR" ).append("\n"); 
		query.append("              ,BKG_RF_CGO               RF" ).append("\n"); 
		query.append("              ,BKG_AWK_CGO              AWK" ).append("\n"); 
		query.append("              ,MDM_COMMODITY            M" ).append("\n"); 
		query.append("              ,MDM_CNTR_TP_SZ           S" ).append("\n"); 
		query.append("              ,COM_INTG_CD_DTL          C" ).append("\n"); 
		query.append("              ,BKG_CONTAINER            B" ).append("\n"); 
		query.append("         WHERE 1 = 1" ).append("\n"); 
		query.append("           AND ORD.TRSP_WO_OFC_CTY_CD = @[trsp_wo_ofc_cty_cd]" ).append("\n"); 
		query.append("           AND ORD.TRSP_WO_SEQ = @[trsp_wo_seq]" ).append("\n"); 
		query.append("           AND TRSP_SO_OFC_CTY_CD IN (" ).append("\n"); 
		query.append("           #foreach($code IN ${trsp_so_ofc_cty_cd})" ).append("\n"); 
		query.append("               #if($velocityCount == 1)" ).append("\n"); 
		query.append("                   '$code'" ).append("\n"); 
		query.append("               #else" ).append("\n"); 
		query.append("                  ,'$code'" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("           AND TRSP_SO_SEQ IN (" ).append("\n"); 
		query.append("           #foreach($code IN ${trsp_so_seq})" ).append("\n"); 
		query.append("               #if($velocityCount == 1)" ).append("\n"); 
		query.append("                   '$code'" ).append("\n"); 
		query.append("               #else" ).append("\n"); 
		query.append("                  ,'$code'" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("           AND ORD.VNDR_SEQ = VNDR.VNDR_SEQ" ).append("\n"); 
		query.append("           AND ORD.BKG_NO = EUR.BKG_NO(+)" ).append("\n"); 
		query.append("           AND ORD.EQ_NO = EUR.CNTR_NO(+)" ).append("\n"); 
		query.append("           AND ORD.TRSP_BND_CD = EUR.IO_BND_CD(+)" ).append("\n"); 
		query.append("           AND EUR.CXL_FLG(+) = 'N' -- Cancel된 TRO는 제외" ).append("\n"); 
		query.append("           AND ORD.BKG_NO = RF.BKG_NO(+)" ).append("\n"); 
		query.append("           AND ORD.EQ_NO = RF.CNTR_NO(+)" ).append("\n"); 
		query.append("           AND ORD.BKG_NO = AWK.BKG_NO(+)" ).append("\n"); 
		query.append("           AND ORD.EQ_NO = AWK.CNTR_NO(+)" ).append("\n"); 
		query.append("           AND ORD.DELT_FLG = 'N'" ).append("\n"); 
		query.append("           AND ORD.CMDT_CD = M.CMDT_CD(+)" ).append("\n"); 
		query.append("           AND AWK.CNTR_TPSZ_CD = S.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("           AND AWK.WGT_UT_CD = C.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("           AND C.INTG_CD_ID(+) = 'CD00582'" ).append("\n"); 
		query.append("           AND ORD.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("           AND ORD.EQ_NO = B.CNTR_NO(+)" ).append("\n"); 
		query.append("         GROUP BY ORD.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                 ,ORD.TRSP_SO_SEQ" ).append("\n"); 
		query.append("                 ,ORD.TRO_SEQ" ).append("\n"); 
		query.append("				 ,ORD.TRSP_BND_CD" ).append("\n"); 
		query.append("                 ,VNDR.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("                 ,ORD.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("                 ,ORD.N1ST_NOD_PLN_DT" ).append("\n"); 
		query.append("                 ,EUR.SPCL_INSTR_RMK" ).append("\n"); 
		query.append("                 ,ORD.EQ_NO" ).append("\n"); 
		query.append("                 ,ORD.EQ_TPSZ_CD" ).append("\n"); 
		query.append("                 ,ORD.CGO_TP_CD" ).append("\n"); 
		query.append("                 ,ORD.BKG_NO" ).append("\n"); 
		query.append("                 ,RF.FDO_TEMP" ).append("\n"); 
		query.append("                 ,RF.CDO_TEMP" ).append("\n"); 
		query.append("                 ,RF.VLTG_NO" ).append("\n"); 
		query.append("                 ,RF.CNTR_VENT_TP_CD" ).append("\n"); 
		query.append("                 ,RF.CBM_PER_HR_QTY" ).append("\n"); 
		query.append("                 ,RF.VENT_RTO" ).append("\n"); 
		query.append("                 ,RF.HUMID_NO" ).append("\n"); 
		query.append("                 ,RF.PWR_SPL_CBL_FLG" ).append("\n"); 
		query.append("                 ,RF.DIFF_RMK" ).append("\n"); 
		query.append("                 ,RF.CNTR_DRN_CD" ).append("\n"); 
		query.append("                 ,AWK.OVR_BKWD_LEN" ).append("\n"); 
		query.append("                 ,AWK.OVR_FWRD_LEN" ).append("\n"); 
		query.append("                 ,AWK.OVR_HGT" ).append("\n"); 
		query.append("                 ,AWK.OVR_LF_LEN" ).append("\n"); 
		query.append("                 ,AWK.OVR_RT_LEN" ).append("\n"); 
		query.append("                 ,AWK.GRS_WGT" ).append("\n"); 
		query.append("                 ,AWK.WGT_UT_CD" ).append("\n"); 
		query.append("                 ,AWK.OVR_VOID_SLT_QTY" ).append("\n"); 
		query.append("                 ,AWK.STWG_RQST_DESC" ).append("\n"); 
		query.append("                 ,AWK.TTL_DIM_LEN" ).append("\n"); 
		query.append("                 ,AWK.TTL_DIM_WDT" ).append("\n"); 
		query.append("                 ,AWK.TTL_DIM_HGT" ).append("\n"); 
		query.append("                 ,AWK.WGT_UT_CD" ).append("\n"); 
		query.append("                 ,AWK.GRS_WGT" ).append("\n"); 
		query.append("                 ,AWK.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                 ,ORD.CMDT_CD" ).append("\n"); 
		query.append("                 ,M.CMDT_NM" ).append("\n"); 
		query.append("                 ,B.WGT_UT_CD" ).append("\n"); 
		query.append("                 ,ORD.WGT_MEAS_UT_CD" ).append("\n"); 
		query.append("                 ,ORD.CNTR_SLT_NO" ).append("\n"); 
		query.append("       ) T" ).append("\n"); 

	}
}