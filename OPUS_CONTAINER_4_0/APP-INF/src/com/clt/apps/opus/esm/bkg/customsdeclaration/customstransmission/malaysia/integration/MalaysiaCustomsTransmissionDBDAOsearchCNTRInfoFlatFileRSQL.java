/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : MalaysiaCustomsTransmissionDBDAOsearchCNTRInfoFlatFileRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.malaysia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MalaysiaCustomsTransmissionDBDAOsearchCNTRInfoFlatFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public MalaysiaCustomsTransmissionDBDAOsearchCNTRInfoFlatFileRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.malaysia.integration").append("\n"); 
		query.append("FileName : MalaysiaCustomsTransmissionDBDAOsearchCNTRInfoFlatFileRSQL").append("\n"); 
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
		query.append("SELECT CASE " ).append("\n"); 
		query.append("          WHEN PS.TS_TP_CD = 'T'" ).append("\n"); 
		query.append("             THEN 'T' " ).append("\n"); 
		query.append("          WHEN BK.BKG_CGO_TP_CD = 'P'" ).append("\n"); 
		query.append("             THEN 'E'" ).append("\n"); 
		query.append("          WHEN BK.DE_TERM_CD <> 'S'" ).append("\n"); 
		query.append("             THEN 'F'" ).append("\n"); 
		query.append("          ELSE 'L'" ).append("\n"); 
		query.append("       END AS TS_TP_CD," ).append("\n"); 
		query.append("       CASE" ).append("\n"); 
		query.append("          WHEN BK.BKG_CGO_TP_CD = 'P'" ).append("\n"); 
		query.append("             THEN 'E'" ).append("\n"); 
		query.append("          WHEN BK.DE_TERM_CD <> 'S'" ).append("\n"); 
		query.append("             THEN 'F'" ).append("\n"); 
		query.append("          ELSE 'L'" ).append("\n"); 
		query.append("       END AS TP_CD_2ND," ).append("\n"); 
		query.append("       TO_CHAR(PS.SND_DT, 'YYMMDDHH24MISS') AS SND_DT," ).append("\n"); 
		query.append("       NVL(PS.CNTR_NO, '') AS CNTR_NO," ).append("\n"); 
		query.append("       NVL(PS.CNTR_TPSZ_CD, '') AS CNTR_TPSZ," ).append("\n"); 
		query.append("       NVL(PS.BKG_NO, '') AS BKG_NO," ).append("\n"); 
		query.append("       NVL(PS.FULL_MTY_CD, '') AS FULL_MTY_CD," ).append("\n"); 
		query.append("       NVL(PS.CNTR_WGT, '') AS CNTR_WGT," ).append("\n"); 
		query.append("       NVL(PS.VGM_WGT, '') AS VGM_WGT," ).append("\n"); 
		query.append("       NVL(PS.CNTR_OPR_CD, '') AS CNTR_OPR_CD," ).append("\n"); 
		query.append("       NVL(PS.IB_SLT_OPR_CD, '') AS IB_SLT_OPR_CD," ).append("\n"); 
		query.append("       -- DECODE(NVL(PC.RC_TEMP, '0'), 0, '', DECODE( SIGN(PC.RC_TEMP), -1, TO_CHAR(-1 * ( -1 * TO_NUMBER(NVL(PC.RC_TEMP, '0'))), '099.99'), '+'||TRIM(TO_CHAR(-1 * ( -1 * TO_NUMBER(NVL(PC.RC_TEMP, '0'))), '099.99')))||'C') AS RC_TEMP," ).append("\n"); 
		query.append("       CASE" ).append("\n"); 
		query.append("          WHEN PS.RC_FLG = 'N' THEN ''" ).append("\n"); 
		query.append("          ELSE CASE" ).append("\n"); 
		query.append("                  WHEN PC.RC_TEMP = '0' THEN '+000.00C'" ).append("\n"); 
		query.append("                  WHEN SIGN(PC.RC_TEMP) = -1 THEN TO_CHAR(-1 * (-1 * TO_NUMBER(NVL(PC.RC_TEMP, '0'))), '099.99')||'C'" ).append("\n"); 
		query.append("                  ELSE '+'||TRIM(TO_CHAR(-1 * (-1 * TO_NUMBER(NVL(PC.RC_TEMP, '0'))), '099.99'))||'C'" ).append("\n"); 
		query.append("               END" ).append("\n"); 
		query.append("       END AS RC_TEMP," ).append("\n"); 
		query.append("       NVL(PS.DCGO_FLG, '') AS DCGO_FLG," ).append("\n"); 
		query.append("       DECODE(NVL(PC.OVR_DIM_HGT, 0), 0, '', TRIM(TO_CHAR(TO_NUMBER(NVL(PC.OVR_DIM_HGT, '0')), '099.9'))||'C') AS OVR_DIM_HGT," ).append("\n"); 
		query.append("       DECODE(NVL(PC.OVR_FNT_DIM_LEN, 0), 0, '', TRIM(TO_CHAR(TO_NUMBER(NVL(PC.OVR_FNT_DIM_LEN, '0')), '099.9'))||'C') AS OVR_FNT_DIM_LEN," ).append("\n"); 
		query.append("       DECODE(NVL(PC.OVR_BAK_DIM_LEN, 0), 0, '', TRIM(TO_CHAR(TO_NUMBER(NVL(PC.OVR_BAK_DIM_LEN, '0')), '099.9'))||'C') AS OVR_BAK_DIM_LEN," ).append("\n"); 
		query.append("       DECODE(NVL(PC.OVR_LF_DIM_WDT, 0), 0, '', TRIM(TO_CHAR(TO_NUMBER(NVL(PC.OVR_LF_DIM_WDT, '0')), '099.9'))||'C') AS OVR_LF_DIM_WDT," ).append("\n"); 
		query.append("       DECODE(NVL(PC.OVR_RT_DIM_WDT, 0), 0, '', TRIM(TO_CHAR(TO_NUMBER(NVL(PC.OVR_RT_DIM_WDT, '0')), '099.9'))||'C') AS OVR_RT_DIM_WDT," ).append("\n"); 
		query.append("       DECODE(NVL(PC.DIM_HGT, 0), 0, '', TRIM(TO_CHAR(TO_NUMBER(NVL(PC.DIM_HGT, '0')), '099.9'))||'C') AS DIM_HGT," ).append("\n"); 
		query.append("       DECODE(NVL(PC.DIM_WDT, 0), 0, '', TRIM(TO_CHAR(TO_NUMBER(NVL(PC.DIM_WDT, '0')), '099.9'))||'C') AS DIM_WDT," ).append("\n"); 
		query.append("       DECODE(NVL(PC.DIM_LEN, 0), 0, '', TRIM(TO_CHAR(TO_NUMBER(NVL(PC.DIM_LEN, '0')), '099.9'))||'C') AS DIM_LEN," ).append("\n"); 
		query.append("       NVL(PC.CGO_DESC, '') AS CGO_DESC," ).append("\n"); 
		query.append("       NVL((SELECT CMDT_HS_CD" ).append("\n"); 
		query.append("              FROM BKG_CNTR_MF_DESC MF" ).append("\n"); 
		query.append("             WHERE MF.BKG_NO = PS.BKG_NO" ).append("\n"); 
		query.append("               AND MF.CNTR_NO = PS.CNTR_NO" ).append("\n"); 
		query.append("               AND CMDT_HS_CD IS NOT NULL" ).append("\n"); 
		query.append("               AND ROWNUM = 1), '') AS CMDT_HS_CD," ).append("\n"); 
		query.append("       NVL(PC.CFS_TP_CD, '') AS CFS_TP_CD," ).append("\n"); 
		query.append("       NVL(PC.DPT_SVC_TP_CD, '') AS DPT_SVC_TP_CD," ).append("\n"); 
		query.append("       NVL(PC.RF_CNTR_PRE_TRD_INSP_TP_CD, '') AS RF_CNTR_PRE_TRD_INSP_TP_CD," ).append("\n"); 
		query.append("       NVL(PS.PSA_STWG_TP_ID, '') AS STWG_TP_CD," ).append("\n"); 
		query.append("       NVL(PS.OB_SLT_OPR_CD, '') AS OB_SLT_OPR_CD," ).append("\n"); 
		query.append("       NVL(PS.PSA_BAT_NO, '') AS PSA_BAT_NO," ).append("\n"); 
		query.append("       NVL(N3RD_POD_CD, (SELECT NVL(MDM.UN_LOC_CD, MDM.LOC_CD)" ).append("\n"); 
		query.append("                           FROM MDM_LOCATION MDM" ).append("\n"); 
		query.append("                          WHERE PS.N1ST_POD_CD = MDM.LOC_CD(+)" ).append("\n"); 
		query.append("                            AND ROWNUM = 1)) AS N1ST_POD_CD," ).append("\n"); 
		query.append("       (SELECT NVL(MDM.UN_LOC_CD, MDM.LOC_CD)" ).append("\n"); 
		query.append("          FROM MDM_LOCATION MDM" ).append("\n"); 
		query.append("         WHERE PS.N2ND_POD_CD = MDM.LOC_CD(+)" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS N2ND_POD_CD," ).append("\n"); 
		query.append("--       NVL(PS.N2ND_POD_CD, '') AS N2ND_POD_CD," ).append("\n"); 
		query.append("       (SELECT NVL(MDM.UN_LOC_CD, MDM.LOC_CD)" ).append("\n"); 
		query.append("          FROM MDM_LOCATION MDM" ).append("\n"); 
		query.append("         WHERE PS.POD_CD = MDM.LOC_CD(+)" ).append("\n"); 
		query.append("           AND ROWNUM = 1 ) AS POD_CD," ).append("\n"); 
		query.append("       (SELECT NVL(MDM.UN_LOC_CD, MDM.LOC_CD)" ).append("\n"); 
		query.append("          FROM MDM_LOCATION MDM" ).append("\n"); 
		query.append("         WHERE PS.POL_CD = MDM.LOC_CD(+)" ).append("\n"); 
		query.append("           AND ROWNUM = 1 ) AS POL_CD," ).append("\n"); 
		query.append("       (SELECT NVL(MDM.UN_LOC_CD, MDM.LOC_CD)" ).append("\n"); 
		query.append("          FROM BKG_BOOKING BV," ).append("\n"); 
		query.append("               MDM_LOCATION MDM" ).append("\n"); 
		query.append("         WHERE BV.BKG_NO = PS.BKG_NO" ).append("\n"); 
		query.append("           AND BV.POR_CD = MDM.LOC_CD(+)" ).append("\n"); 
		query.append("           AND ROWNUM = 1 ) AS POR_CD," ).append("\n"); 
		query.append("       (SELECT NVL(MDM.UN_LOC_CD, MDM.LOC_CD)" ).append("\n"); 
		query.append("          FROM BKG_BOOKING BV," ).append("\n"); 
		query.append("               MDM_LOCATION MDM" ).append("\n"); 
		query.append("         WHERE BV.BKG_NO = PS.BKG_NO" ).append("\n"); 
		query.append("           AND BV.DEL_CD = MDM.LOC_CD(+)" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS DEL_CD," ).append("\n"); 
		query.append("       NVL(PC.DCHG_OVR_SZ_FLG, '') AS DCHG_OVR_SZ_FLG," ).append("\n"); 
		query.append("       NVL(PC.DIR_DE_FLG, '') AS DIR_DE_FLG," ).append("\n"); 
		query.append("       NVL(BK.BLCK_STWG_CD, '') AS BLCK_STWG_CD," ).append("\n"); 
		query.append("       REPLACE(NVL(PS.CNTR_SEAL_NO, ''), '/', '') AS CNTR_SEAL_NO," ).append("\n"); 
		query.append("       (SELECT NVL(DG.IMDG_CLSS_CD, '')" ).append("\n"); 
		query.append("          FROM BKG_DG_CGO DG" ).append("\n"); 
		query.append("         WHERE PS.BKG_NO = DG.BKG_NO" ).append("\n"); 
		query.append("           AND PS.CNTR_NO = DG.CNTR_NO" ).append("\n"); 
		query.append("           AND DG.IMDG_CLSS_CD IS NOT NULL" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS CNTR_CLASS," ).append("\n"); 
		query.append("       UPPER(PV.PSA_VSL_NM) AS PSA_VSL_NM," ).append("\n"); 
		query.append("       NVL(PV.PSA_VOY_DIR_CD, '') AS PSA_VOY_DIR_CD," ).append("\n"); 
		query.append("       NVL2(PC.CBM_PER_HR_QTY, PC.CBM_PER_HR_QTY||'CMH', '') AS CBM_PER_HR_QTY," ).append("\n"); 
		query.append("       (SELECT SOC_FLG" ).append("\n"); 
		query.append("          FROM BKG_CONTAINER" ).append("\n"); 
		query.append("         WHERE BKG_NO = PS.BKG_NO" ).append("\n"); 
		query.append("           AND CNTR_NO = PS.CNTR_NO) AS SOC_IND," ).append("\n"); 
		query.append("       BKG_SPCLCHAR_CONV_FNC(CNEE.CUST_NM, 'Y') AS CNEE_NM," ).append("\n"); 
		query.append("       BKG_SPCLCHAR_CONV_FNC(NTFY.CUST_NM, 'Y') AS NTFY_NM," ).append("\n"); 
		query.append("       (SELECT SLAN_CD" ).append("\n"); 
		query.append("          FROM BKG_VVD" ).append("\n"); 
		query.append("         WHERE BKG_NO = PS.BKG_NO" ).append("\n"); 
		query.append("           AND POL_CD LIKE 'MY%'" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS SLAN_CD," ).append("\n"); 
		query.append("       PS.PSA_CRE_TP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_MY_VVD PV," ).append("\n"); 
		query.append("       BKG_CSTMS_MY_IMP_STS PS," ).append("\n"); 
		query.append("       BKG_CSTMS_MY_IMP_STS_SPCL PC," ).append("\n"); 
		query.append("       BKG_CUSTOMER CNEE," ).append("\n"); 
		query.append("       BKG_CUSTOMER NTFY," ).append("\n"); 
		query.append("       BKG_BOOKING BK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE PS.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("   AND PS.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND PS.SKD_DIR_CD =  @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND PS.LODG_VSL_CD = PV.VSL_CD(+)" ).append("\n"); 
		query.append("   AND PS.LODG_SKD_VOY_NO = PV.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND PS.LODG_VSL_DIR_CD = PV.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND PS.VSL_CD = PC.VSL_CD (+)" ).append("\n"); 
		query.append("   AND PS.SKD_VOY_NO = PC.SKD_VOY_NO (+)" ).append("\n"); 
		query.append("   AND PS.SKD_DIR_CD = PC.SKD_DIR_CD (+)" ).append("\n"); 
		query.append("   AND PS.CNTR_NO = PC.CNTR_NO (+)" ).append("\n"); 
		query.append("   AND PS.BKG_NO = CNEE.BKG_NO(+)" ).append("\n"); 
		query.append("   AND CNEE.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("   AND PS.BKG_NO = NTFY.BKG_NO(+)" ).append("\n"); 
		query.append("   AND NTFY.BKG_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append("   AND PS.BKG_NO = BK.BKG_NO(+)" ).append("\n"); 

	}
}