/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerSpecMgtDBDAOMstCntrSpecVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.01
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2016.07.01 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerSpecMgtDBDAOMstCntrSpecVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ContainerSpecMgtDBDAOMstCntrSpecVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_spec_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("own_cntr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_spec_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.integration").append("\n"); 
		query.append("FileName : ContainerSpecMgtDBDAOMstCntrSpecVORSQL").append("\n"); 
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
		query.append("#if(${own_cntr_flg} == 'O' || ${own_cntr_flg} == 'A')" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("	CNTR_SPEC_NO " ).append("\n"); 
		query.append("     , CNTR_SPEC_TYPE_CD" ).append("\n"); 
		query.append("     , AGMT_NO" ).append("\n"); 
		query.append("     , LSTM_CD" ).append("\n"); 
		query.append("     , FCTRY_SPEC_NO" ).append("\n"); 
		query.append("     , LOT_NO" ).append("\n"); 
		query.append("     , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , VNDR_SEQ" ).append("\n"); 
		query.append("     , HID_VNDR_SEQ" ).append("\n"); 
		query.append("     , VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("     , VNDR_ABBR_NM" ).append("\n"); 
		query.append("     , YR_BUILD" ).append("\n"); 
		query.append("     , CNTR_MTRL_CD" ).append("\n"); 
		query.append("     , CNTR_MTRL_NM" ).append("\n"); 
		query.append("     , SER_RANGE" ).append("\n"); 
		query.append("     , TTL_LOT_QTY" ).append("\n"); 
		query.append("     , TTL_ACT_QTY" ).append("\n"); 
		query.append("     , RF_TP_CD" ).append("\n"); 
		query.append("     , CNTR_HNGR_RCK_FLG" ).append("\n"); 
		query.append("     , PLST_FLR_FLG" ).append("\n"); 
		query.append("     , RF_MKR_SEQ" ).append("\n"); 
		query.append("     , RF_MDL_NM" ).append("\n"); 
		query.append("     , RF_RFR_NO" ).append("\n"); 
		query.append("     , MAX_TEMP" ).append("\n"); 
		query.append("     , LOD_CAPA" ).append("\n"); 
		query.append("     , CNTR_GRS_WGT" ).append("\n"); 
		query.append("     , TARE_WGT" ).append("\n"); 
		query.append("     , XTER_LEN" ).append("\n"); 
		query.append("     , XTER_WDT" ).append("\n"); 
		query.append("     , XTER_HGT" ).append("\n"); 
		query.append("     , INTER_LEN" ).append("\n"); 
		query.append("     , INTER_WDT" ).append("\n"); 
		query.append("     , INTER_HGT" ).append("\n"); 
		query.append("     , OPN_DOR_WDT" ).append("\n"); 
		query.append("     , OPN_DOR_HGT" ).append("\n"); 
		query.append("     , RC_LDB_CAPA" ).append("\n"); 
		query.append("     , RC_LDB_HGT" ).append("\n"); 
		query.append("     , TNK_CAPA" ).append("\n"); 
		query.append("	 , FRACK_CLPS_CTNT" ).append("\n"); 
		query.append("     , FRACK_BED_TIK_CTNT" ).append("\n"); 
		query.append("     , OPNTP_ROOF_OPN_CTNT" ).append("\n"); 
		query.append("     , OPNTP_INTR_HGT_CTNT" ).append("\n"); 
		query.append("     , OPNTP_REAR_HDR_OPN_CTNT" ).append("\n"); 
		query.append("	 , RF_HUMID_CTRL_VAL_CD" ).append("\n"); 
		query.append("     , RF_CMPR_CTNT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT SPEC.CNTR_SPEC_NO " ).append("\n"); 
		query.append("     , 'Own' AS CNTR_SPEC_TYPE_CD" ).append("\n"); 
		query.append("     , MST_COMMON_PKG.MST_AGMT_NO_CONV_FNC(LOT.AGMT_CTY_CD, LOT.AGMT_SEQ) AS AGMT_NO" ).append("\n"); 
		query.append("     , (SELECT LSTM_CD" ).append("\n"); 
		query.append("        FROM   LSE_AGREEMENT L" ).append("\n"); 
		query.append("        WHERE  LOT.AGMT_CTY_CD = L.AGMT_CTY_CD" ).append("\n"); 
		query.append("        AND    LOT.AGMT_SEQ    = L.AGMT_SEQ" ).append("\n"); 
		query.append("        AND    ROWNUM          = 1 " ).append("\n"); 
		query.append("       ) AS LSTM_CD" ).append("\n"); 
		query.append("     , LOT.FCTRY_SPEC_NO" ).append("\n"); 
		query.append("     , DECODE(LOT.LOT_PLN_YR,NULL,NULL,LOT.LOT_PLN_YR||'-'||LOT.LOT_LOC_CD||'-'||LOT.CNTR_TPSZ_CD||'-'||LTRIM(TO_CHAR(LOT.LOT_SEQ,'000'))) LOT_NO" ).append("\n"); 
		query.append("     , SPEC.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , (SELECT L.VNDR_SEQ" ).append("\n"); 
		query.append("        FROM   LSE_AGREEMENT L " ).append("\n"); 
		query.append("        WHERE  LOT.AGMT_CTY_CD = L.AGMT_CTY_CD " ).append("\n"); 
		query.append("        AND    LOT.AGMT_SEQ    = L.AGMT_SEQ" ).append("\n"); 
		query.append("        AND    ROWNUM          = 1" ).append("\n"); 
		query.append("       ) AS VNDR_SEQ" ).append("\n"); 
		query.append("     ,  MDM.VNDR_SEQ AS HID_VNDR_SEQ" ).append("\n"); 
		query.append("     , (SELECT MV.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("        FROM   LSE_AGREEMENT L, MDM_VENDOR MV" ).append("\n"); 
		query.append("        WHERE  LOT.AGMT_CTY_CD = L.AGMT_CTY_CD " ).append("\n"); 
		query.append("        AND    LOT.AGMT_SEQ      = L.AGMT_SEQ " ).append("\n"); 
		query.append("        AND    L.VNDR_SEQ        = MV.VNDR_SEQ" ).append("\n"); 
		query.append("        AND    ROWNUM            = 1  " ).append("\n"); 
		query.append("       ) AS VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("     , MDM.VNDR_ABBR_NM AS VNDR_ABBR_NM" ).append("\n"); 
		query.append("	 , SUBSTR(SPEC.CNTR_SPEC_NO, 1, 4) AS YR_BUILD" ).append("\n"); 
		query.append("     , (SELECT INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL CID" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND INTG_CD_ID           = 'CD01862' " ).append("\n"); 
		query.append("           AND CID.INTG_CD_VAL_CTNT = SPEC.CNTR_MTRL_CD" ).append("\n"); 
		query.append("           AND ROWNUM               = 1) AS CNTR_MTRL_CD" ).append("\n"); 
		query.append("	 , (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL CID" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND INTG_CD_ID           ='CD01862' " ).append("\n"); 
		query.append("           AND CID.INTG_CD_VAL_CTNT = SPEC.CNTR_MTRL_CD" ).append("\n"); 
		query.append("           AND ROWNUM               = 1) AS CNTR_MTRL_NM" ).append("\n"); 
		query.append("     , DECODE(LOT.LOT_PLN_YR,NULL,NULL,LOT.LOT_CNTR_PFX_CD||TO_CHAR(LOT.FM_SER_NO,'000000')||' -'||TO_CHAR(LOT.TO_SER_NO,'000000')) SER_RANGE" ).append("\n"); 
		query.append("     , TO_NUMBER(LTRIM(TO_CHAR(LOT.TO_SER_NO,'000000'))) -" ).append("\n"); 
		query.append("       TO_NUMBER(LTRIM(TO_CHAR(LOT.FM_SER_NO,'000000'))) + 1 AS TTL_LOT_QTY" ).append("\n"); 
		query.append("     , (SELECT COUNT(*)" ).append("\n"); 
		query.append("        FROM    MST_CONTAINER MC" ).append("\n"); 
		query.append("        WHERE   1=1" ).append("\n"); 
		query.append("          AND LOT.LOT_PLN_YR    = MC.LOT_PLN_YR" ).append("\n"); 
		query.append("          AND LOT.LOT_LOC_CD    = MC.LOT_LOC_CD" ).append("\n"); 
		query.append("          AND LOT.CNTR_TPSZ_CD  = MC.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("          AND LOT.LOT_SEQ       = MC.LOT_SEQ" ).append("\n"); 
		query.append("          AND MC.ACIAC_DIV_CD   = 'A'" ).append("\n"); 
		query.append("          AND MC.LSTM_CD        IN ('OW','LP','OL')" ).append("\n"); 
		query.append("     ) AS TTL_ACT_QTY" ).append("\n"); 
		query.append("     , (SELECT S.INTG_CD_VAL_DP_DESC ||' (' ||S.INTG_CD_VAL_DESC || ')' " ).append("\n"); 
		query.append("        FROM   COM_INTG_CD_DTL S" ).append("\n"); 
		query.append("        WHERE  S.INTG_CD_VAL_CTNT = LOT.RF_TP_CD" ).append("\n"); 
		query.append("        AND    S.INTG_CD_ID       = 'CD01085'" ).append("\n"); 
		query.append("        AND    ROWNUM             = 1" ).append("\n"); 
		query.append("     ) AS RF_TP_CD" ).append("\n"); 
		query.append("     , NVL2(CNTR_HNGR_RCK_CD, 'Y', 'N') AS CNTR_HNGR_RCK_FLG" ).append("\n"); 
		query.append("     , PLST_FLR_FLG" ).append("\n"); 
		query.append("     ,(SELECT NVL(MV.VNDR_ABBR_NM, MV.VNDR_LGL_ENG_NM) FROM MDM_VENDOR MV WHERE MV.VNDR_SEQ = LOT.RF_MKR_SEQ AND ROWNUM = 1) AS RF_MKR_SEQ" ).append("\n"); 
		query.append("     , LOT.RF_MDL_NM" ).append("\n"); 
		query.append("     , LOT.RF_RFR_NO" ).append("\n"); 
		query.append("     , LOT.MIN_TEMP || DECODE(LOT.MIN_TEMP, NULL, '',' ~ ') || LOT.MAX_TEMP AS MAX_TEMP" ).append("\n"); 
		query.append("     , SPEC.LOD_CAPA" ).append("\n"); 
		query.append("     , SPEC.CNTR_GRS_WGT" ).append("\n"); 
		query.append("     , SPEC.TARE_WGT" ).append("\n"); 
		query.append("     , SPEC.XTER_LEN" ).append("\n"); 
		query.append("     , SPEC.XTER_WDT" ).append("\n"); 
		query.append("     , SPEC.XTER_HGT" ).append("\n"); 
		query.append("     , SPEC.INTER_LEN" ).append("\n"); 
		query.append("     , SPEC.INTER_WDT" ).append("\n"); 
		query.append("     , SPEC.INTER_HGT" ).append("\n"); 
		query.append("     , SPEC.OPN_DOR_WDT" ).append("\n"); 
		query.append("     , SPEC.OPN_DOR_HGT" ).append("\n"); 
		query.append("     , SPEC.RC_LDB_CAPA" ).append("\n"); 
		query.append("     , SPEC.RC_LDB_HGT" ).append("\n"); 
		query.append("     , SPEC.TNK_CAPA" ).append("\n"); 
		query.append("	 , SPEC.FRACK_CLPS_CTNT" ).append("\n"); 
		query.append("     , SPEC.FRACK_BED_TIK_CTNT" ).append("\n"); 
		query.append("     , SPEC.OPNTP_ROOF_OPN_CTNT" ).append("\n"); 
		query.append("     , SPEC.OPNTP_INTR_HGT_CTNT" ).append("\n"); 
		query.append("     , SPEC.OPNTP_REAR_HDR_OPN_CTNT" ).append("\n"); 
		query.append("	, (SELECT INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("               FROM COM_INTG_CD_DTL " ).append("\n"); 
		query.append("               WHERE INTG_CD_ID     = 'CD30023' " ).append("\n"); 
		query.append("               AND INTG_CD_VAL_CTNT = LOT.RF_HUMID_CTRL_VAL_CD" ).append("\n"); 
		query.append("               AND ROWNUM           = 1) AS RF_HUMID_CTRL_VAL_CD" ).append("\n"); 
		query.append("     , LOT.RF_CMPR_CTNT" ).append("\n"); 
		query.append("FROM  MST_CNTR_SPEC SPEC,  MST_CNTR_LOT LOT, MDM_VENDOR MDM" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND   LOT.CNTR_SPEC_NO(+) = SPEC.CNTR_SPEC_NO" ).append("\n"); 
		query.append("AND   SPEC.VNDR_SEQ       = MDM.VNDR_SEQ  (+)" ).append("\n"); 
		query.append("AND   NOT EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                         FROM   LSE_AGREEMENT L" ).append("\n"); 
		query.append("                         WHERE  LOT.AGMT_CTY_CD = L.AGMT_CTY_CD" ).append("\n"); 
		query.append("                         AND    LOT.AGMT_SEQ    = L.AGMT_SEQ" ).append("\n"); 
		query.append("                          AND    L.LSTM_CD NOT IN ( 'OW', 'LP', 'OL' )" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("AND   SPEC.OWN_CNTR_FLG = 'Y' " ).append("\n"); 
		query.append("#if(${own_cntr_flg} == 'A')" ).append("\n"); 
		query.append("	AND   SPEC.CNTR_SPEC_TP_CD   = 'O'  " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	AND   SPEC.CNTR_SPEC_TP_CD   = @[own_cntr_flg]  " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("AND	  LOT.OWN_CNTR_FLG  (+)= 'Y'" ).append("\n"); 
		query.append("#if(${from_spec_yr} != '')" ).append("\n"); 
		query.append("AND   SPEC.SPEC_YR >= @[from_spec_yr]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${to_spec_yr} != '')" ).append("\n"); 
		query.append("AND   SPEC.SPEC_YR <= @[to_spec_yr]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cntr_tpsz_cd} != '' && ${cntr_tpsz_cd} != 'ALL')" ).append("\n"); 
		query.append("AND   SPEC.CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${agmt_no} != '')" ).append("\n"); 
		query.append("AND   LOT.AGMT_CTY_CD = SUBSTR(@[agmt_no],1,3)" ).append("\n"); 
		query.append("AND   LOT.AGMT_SEQ = TO_NUMBER(SUBSTR(@[agmt_no],4))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY SPEC.CNTR_SPEC_NO DESC" ).append("\n"); 
		query.append(") WHERE 1=1" ).append("\n"); 
		query.append("#if(${zero_active_qty} == 'E')" ).append("\n"); 
		query.append("AND	TTL_ACT_QTY > 0" ).append("\n"); 
		query.append("#elseif(${zero_active_qty} == 'O')" ).append("\n"); 
		query.append("AND	TTL_ACT_QTY = 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${lstm_cd} != '')" ).append("\n"); 
		query.append("AND   LSTM_CD     = @[lstm_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${own_cntr_flg} == 'A')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${own_cntr_flg} == 'L' || ${own_cntr_flg} == 'A')" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("	CNTR_SPEC_NO " ).append("\n"); 
		query.append("	 , CNTR_SPEC_TYPE_CD" ).append("\n"); 
		query.append("     , AGMT_NO" ).append("\n"); 
		query.append("     , LSTM_CD" ).append("\n"); 
		query.append("     , '' FCTRY_SPEC_NO" ).append("\n"); 
		query.append("     , LOT_NO" ).append("\n"); 
		query.append("     , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , VNDR_SEQ" ).append("\n"); 
		query.append("     , HID_VNDR_SEQ" ).append("\n"); 
		query.append("     , VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("     , VNDR_ABBR_NM" ).append("\n"); 
		query.append("     , YR_BUILD" ).append("\n"); 
		query.append("     , CNTR_MTRL_CD" ).append("\n"); 
		query.append("     , CNTR_MTRL_NM" ).append("\n"); 
		query.append("     , SER_RANGE" ).append("\n"); 
		query.append("     , TTL_LOT_QTY" ).append("\n"); 
		query.append("     , TTL_ACT_QTY" ).append("\n"); 
		query.append("     , RF_TP_CD" ).append("\n"); 
		query.append("     , '' CNTR_HNGR_RCK_FLG" ).append("\n"); 
		query.append("     , '' PLST_FLR_FLG" ).append("\n"); 
		query.append("     , RF_MKR_SEQ" ).append("\n"); 
		query.append("     , RF_MDL_NM" ).append("\n"); 
		query.append("     , RF_RFR_NO" ).append("\n"); 
		query.append("     , MAX_TEMP" ).append("\n"); 
		query.append("     , LOD_CAPA" ).append("\n"); 
		query.append("     , CNTR_GRS_WGT" ).append("\n"); 
		query.append("     , TARE_WGT" ).append("\n"); 
		query.append("     , XTER_LEN" ).append("\n"); 
		query.append("     , XTER_WDT" ).append("\n"); 
		query.append("     , XTER_HGT" ).append("\n"); 
		query.append("     , INTER_LEN" ).append("\n"); 
		query.append("     , INTER_WDT" ).append("\n"); 
		query.append("     , INTER_HGT" ).append("\n"); 
		query.append("     , OPN_DOR_WDT" ).append("\n"); 
		query.append("     , OPN_DOR_HGT" ).append("\n"); 
		query.append("     , RC_LDB_CAPA" ).append("\n"); 
		query.append("     , RC_LDB_HGT" ).append("\n"); 
		query.append("     , TNK_CAPA" ).append("\n"); 
		query.append("	 , '' FRACK_CLPS_CTNT" ).append("\n"); 
		query.append("     , FRACK_BED_TIK_CTNT" ).append("\n"); 
		query.append("     , OPNTP_ROOF_OPN_CTNT" ).append("\n"); 
		query.append("     , OPNTP_INTR_HGT_CTNT" ).append("\n"); 
		query.append("     , OPNTP_REAR_HDR_OPN_CTNT" ).append("\n"); 
		query.append("	 , RF_HUMID_CTRL_VAL_CD" ).append("\n"); 
		query.append("     , RF_CMPR_CTNT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  SPEC.CNTR_SPEC_NO" ).append("\n"); 
		query.append("	  , 'Lease' AS CNTR_SPEC_TYPE_CD" ).append("\n"); 
		query.append("      , MST_COMMON_PKG.MST_AGMT_NO_CONV_FNC(MC.AGMT_CTY_CD, MC.AGMT_SEQ) AS AGMT_NO" ).append("\n"); 
		query.append("      , SPEC.CNTR_SPEC_NO" ).append("\n"); 
		query.append("        ||NVL(TRIM(MC.AGMT_CTY_CD||TRIM(TO_CHAR(MC.AGMT_SEQ, '000000'))), 'X')" ).append("\n"); 
		query.append("        ||NVL(TRIM(MC.LOT_PLN_YR||'-'||MC.LOT_LOC_CD||'-'||MC.CNTR_TPSZ_CD||'-'||LTRIM(TO_CHAR(MC.LOT_SEQ,'000'))), 'X')" ).append("\n"); 
		query.append("        ||NVL(TRIM(TO_CHAR(MC.MFTR_VNDR_SEQ, '000000')), 'X') AS LOT_NO" ).append("\n"); 
		query.append("      , MAX(MC.LSTM_CD) LSTM_CD" ).append("\n"); 
		query.append("      , MAX(MDM.VNDR_SEQ) VNDR_SEQ" ).append("\n"); 
		query.append("	  , MC.MFTR_VNDR_SEQ AS HID_VNDR_SEQ" ).append("\n"); 
		query.append("	  , MAX(MDM.VNDR_LGL_ENG_NM) VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("      , (SELECT NVL(SUB.VNDR_ABBR_NM, SUB.VNDR_LGL_ENG_NM)" ).append("\n"); 
		query.append("               FROM MDM_VENDOR SUB" ).append("\n"); 
		query.append("              WHERE MC.MFTR_VNDR_SEQ = SUB.VNDR_SEQ" ).append("\n"); 
		query.append("                AND ROWNUM           = 1) AS VNDR_ABBR_NM" ).append("\n"); 
		query.append("	  , SUBSTR(SPEC.CNTR_SPEC_NO, 1, 4) AS YR_BUILD" ).append("\n"); 
		query.append("      , MAX(TO_NUMBER(LTRIM(TO_CHAR(LOT.TO_SER_NO,'000000'))) -" ).append("\n"); 
		query.append("            TO_NUMBER(LTRIM(TO_CHAR(LOT.FM_SER_NO,'000000'))) + DECODE(LOT.LOT_PLN_YR, NULL, 0, 1)) AS TTL_LOT_QTY" ).append("\n"); 
		query.append("      , SUM(DECODE(MC.ACIAC_DIV_CD, 'A', 1, 0)) AS TTL_ACT_QTY" ).append("\n"); 
		query.append("      , MAX(SPEC.CNTR_TPSZ_CD) CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      , MAX((SELECT INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("           FROM COM_INTG_CD_DTL CID" ).append("\n"); 
		query.append("          WHERE 1=1" ).append("\n"); 
		query.append("            AND INTG_CD_ID ='CD01862' " ).append("\n"); 
		query.append("            AND CID.INTG_CD_VAL_CTNT = SPEC.CNTR_MTRL_CD" ).append("\n"); 
		query.append("            AND ROWNUM               = 1)) AS CNTR_MTRL_CD" ).append("\n"); 
		query.append("	  , MAX((SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("           FROM COM_INTG_CD_DTL CID" ).append("\n"); 
		query.append("          WHERE 1=1" ).append("\n"); 
		query.append("            AND INTG_CD_ID ='CD01862' " ).append("\n"); 
		query.append("            AND CID.INTG_CD_VAL_CTNT = SPEC.CNTR_MTRL_CD" ).append("\n"); 
		query.append("            AND ROWNUM               = 1)) AS CNTR_MTRL_NM" ).append("\n"); 
		query.append("      , MAX(DECODE(LOT.LOT_PLN_YR,NULL,NULL,LOT.LOT_CNTR_PFX_CD||TO_CHAR(LOT.FM_SER_NO,'000000')||' -'||TO_CHAR(LOT.TO_SER_NO,'000000'))) SER_RANGE" ).append("\n"); 
		query.append("      , MAX((SELECT NVL(MV.VNDR_ABBR_NM, MV.VNDR_LGL_ENG_NM) FROM MDM_VENDOR MV WHERE MV.VNDR_SEQ = MC.RF_MKR_SEQ AND ROWNUM = 1)) AS RF_MKR_SEQ" ).append("\n"); 
		query.append("      , MAX(MC.RF_MDL_NM) RF_MDL_NM" ).append("\n"); 
		query.append("      , MAX(MC.RF_RFR_NO) RF_RFR_NO" ).append("\n"); 
		query.append("      , MAX(MC.MIN_TEMP || DECODE(MC.MIN_TEMP, NULL, '',' ~ ') || MC.MAX_TEMP) AS MAX_TEMP" ).append("\n"); 
		query.append("      , MAX(SPEC.LOD_CAPA) LOD_CAPA" ).append("\n"); 
		query.append("      , MAX(SPEC.CNTR_GRS_WGT) CNTR_GRS_WGT" ).append("\n"); 
		query.append("      , MAX(SPEC.TARE_WGT) TARE_WGT" ).append("\n"); 
		query.append("      , MAX(SPEC.XTER_LEN) XTER_LEN" ).append("\n"); 
		query.append("      , MAX(SPEC.XTER_WDT) XTER_WDT" ).append("\n"); 
		query.append("      , MAX(SPEC.XTER_HGT) XTER_HGT" ).append("\n"); 
		query.append("      , MAX(SPEC.INTER_LEN) INTER_LEN" ).append("\n"); 
		query.append("      , MAX(SPEC.INTER_WDT) INTER_WDT" ).append("\n"); 
		query.append("      , MAX(SPEC.INTER_HGT) INTER_HGT" ).append("\n"); 
		query.append("      , MAX(SPEC.OPN_DOR_WDT) OPN_DOR_WDT" ).append("\n"); 
		query.append("      , MAX(SPEC.OPN_DOR_HGT) OPN_DOR_HGT" ).append("\n"); 
		query.append("      , MAX(SPEC.RC_LDB_CAPA) RC_LDB_CAPA" ).append("\n"); 
		query.append("      , MAX(SPEC.RC_LDB_HGT) RC_LDB_HGT" ).append("\n"); 
		query.append("      , MAX(SPEC.TNK_CAPA) TNK_CAPA" ).append("\n"); 
		query.append("      , MAX(SPEC.FRACK_CLPS_CTNT) FRACK_CLPS_CTNT" ).append("\n"); 
		query.append("	  , MAX(SPEC.FRACK_BED_TIK_CTNT) FRACK_BED_TIK_CTNT" ).append("\n"); 
		query.append("      , MAX(SPEC.OPNTP_ROOF_OPN_CTNT) OPNTP_ROOF_OPN_CTNT" ).append("\n"); 
		query.append("      , MAX(SPEC.OPNTP_INTR_HGT_CTNT) OPNTP_INTR_HGT_CTNT" ).append("\n"); 
		query.append("      , MAX(SPEC.OPNTP_REAR_HDR_OPN_CTNT) AS OPNTP_REAR_HDR_OPN_CTNT" ).append("\n"); 
		query.append("      , MAX((SELECT INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("               FROM COM_INTG_CD_DTL " ).append("\n"); 
		query.append("               WHERE INTG_CD_ID     = 'CD30023' " ).append("\n"); 
		query.append("               AND INTG_CD_VAL_CTNT = MC.RF_HUMID_CTRL_VAL_CD" ).append("\n"); 
		query.append("               AND ROWNUM           = 1)) AS RF_HUMID_CTRL_VAL_CD" ).append("\n"); 
		query.append("	  , MAX((SELECT S.INTG_CD_VAL_DP_DESC ||' (' ||S.INTG_CD_VAL_DESC || ')' " ).append("\n"); 
		query.append("                   FROM COM_INTG_CD_DTL S" ).append("\n"); 
		query.append("                  WHERE S.INTG_CD_VAL_CTNT = MC.RF_TP_CD" ).append("\n"); 
		query.append("                    AND S.INTG_CD_ID       = 'CD01085'" ).append("\n"); 
		query.append("                    AND ROWNUM             = 1)) AS RF_TP_CD" ).append("\n"); 
		query.append("      , MAX(MC.RF_CMPR_CTNT) AS RF_CMPR_CTNT" ).append("\n"); 
		query.append("FROM  MST_CNTR_SPEC SPEC" ).append("\n"); 
		query.append("        , MST_CONTAINER MC" ).append("\n"); 
		query.append("        , MST_CNTR_LOT LOT" ).append("\n"); 
		query.append("        , MDM_VENDOR    MDM" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND   SPEC.CNTR_SPEC_NO = MC.CNTR_SPEC_NO(+)" ).append("\n"); 
		query.append("AND   MC.LOT_PLN_YR     = LOT.LOT_PLN_YR(+)" ).append("\n"); 
		query.append("AND   MC.LOT_LOC_CD     = LOT.LOT_LOC_CD(+)" ).append("\n"); 
		query.append("AND   MC.CNTR_TPSZ_CD   = LOT.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("AND   MC.LOT_SEQ        = LOT.LOT_SEQ(+)" ).append("\n"); 
		query.append("AND   SPEC.VNDR_SEQ     = MDM.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND   MC.LSTM_CD(+)     NOT IN ( 'OW', 'LP', 'OL', 'SH', 'MI', 'SI', 'OF')" ).append("\n"); 
		query.append("AND   SPEC.OWN_CNTR_FLG = 'N'" ).append("\n"); 
		query.append("#if(${own_cntr_flg} == 'A')" ).append("\n"); 
		query.append("	AND   SPEC.CNTR_SPEC_TP_CD   = 'L'  " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	AND   SPEC.CNTR_SPEC_TP_CD   = @[own_cntr_flg]  " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if(${lstm_cd} != '')" ).append("\n"); 
		query.append("AND   MC.LSTM_CD(+)     = @[lstm_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${from_spec_yr} != '')" ).append("\n"); 
		query.append("AND   SPEC.SPEC_YR     >= @[from_spec_yr]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${to_spec_yr} != '')" ).append("\n"); 
		query.append("AND   SPEC.SPEC_YR    <= @[to_spec_yr]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cntr_tpsz_cd} != '' && ${cntr_tpsz_cd} != 'ALL')" ).append("\n"); 
		query.append("AND   SPEC.CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${agmt_no} != '')" ).append("\n"); 
		query.append("AND   MC.AGMT_CTY_CD   = SUBSTR(@[agmt_no],1,3)" ).append("\n"); 
		query.append("AND   MC.AGMT_SEQ      = TO_NUMBER(SUBSTR(@[agmt_no],4))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${vndr_seq} != '')" ).append("\n"); 
		query.append("AND SPEC.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY SPEC.CNTR_SPEC_NO, MC.AGMT_CTY_CD, MC.AGMT_SEQ, MC.MFTR_VNDR_SEQ, SPEC.CNTR_SPEC_TP_CD" ).append("\n"); 
		query.append("       , SPEC.CNTR_SPEC_NO" ).append("\n"); 
		query.append("        ||NVL(TRIM(MC.AGMT_CTY_CD||TRIM(TO_CHAR(MC.AGMT_SEQ, '000000'))), 'X')" ).append("\n"); 
		query.append("        ||NVL(TRIM(MC.LOT_PLN_YR||'-'||MC.LOT_LOC_CD||'-'||MC.CNTR_TPSZ_CD||'-'||LTRIM(TO_CHAR(MC.LOT_SEQ,'000'))), 'X')" ).append("\n"); 
		query.append("        ||NVL(TRIM(TO_CHAR(MC.MFTR_VNDR_SEQ, '000000')), 'X')" ).append("\n"); 
		query.append("ORDER BY SPEC.CNTR_SPEC_NO DESC" ).append("\n"); 
		query.append(") WHERE 1=1" ).append("\n"); 
		query.append("#if(${zero_active_qty} == 'E')" ).append("\n"); 
		query.append("AND	 TTL_ACT_QTY > 0" ).append("\n"); 
		query.append("#elseif(${zero_active_qty} == 'O')" ).append("\n"); 
		query.append("AND	 TTL_ACT_QTY = 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${own_cntr_flg} == 'A')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${own_cntr_flg} == 'S' || ${own_cntr_flg} == 'A')" ).append("\n"); 
		query.append("SELECT  " ).append("\n"); 
		query.append("	CNTR_SPEC_NO " ).append("\n"); 
		query.append("	 , CNTR_SPEC_TYPE_CD" ).append("\n"); 
		query.append("     , AGMT_NO" ).append("\n"); 
		query.append("     , LSTM_CD" ).append("\n"); 
		query.append("     , '' FCTRY_SPEC_NO" ).append("\n"); 
		query.append("     , LOT_NO" ).append("\n"); 
		query.append("     , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , VNDR_SEQ" ).append("\n"); 
		query.append("     , HID_VNDR_SEQ" ).append("\n"); 
		query.append("     , VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("     , VNDR_ABBR_NM" ).append("\n"); 
		query.append("     , YR_BUILD" ).append("\n"); 
		query.append("     , CNTR_MTRL_CD" ).append("\n"); 
		query.append("     , CNTR_MTRL_NM" ).append("\n"); 
		query.append("     , SER_RANGE" ).append("\n"); 
		query.append("     , TTL_LOT_QTY" ).append("\n"); 
		query.append("     , TTL_ACT_QTY" ).append("\n"); 
		query.append("     , RF_TP_CD" ).append("\n"); 
		query.append("     , '' CNTR_HNGR_RCK_FLG" ).append("\n"); 
		query.append("     , '' PLST_FLR_FLG" ).append("\n"); 
		query.append("     , RF_MKR_SEQ" ).append("\n"); 
		query.append("     , RF_MDL_NM" ).append("\n"); 
		query.append("     , RF_RFR_NO" ).append("\n"); 
		query.append("     , MAX_TEMP" ).append("\n"); 
		query.append("     , LOD_CAPA" ).append("\n"); 
		query.append("     , CNTR_GRS_WGT" ).append("\n"); 
		query.append("     , TARE_WGT" ).append("\n"); 
		query.append("     , XTER_LEN" ).append("\n"); 
		query.append("     , XTER_WDT" ).append("\n"); 
		query.append("     , XTER_HGT" ).append("\n"); 
		query.append("     , INTER_LEN" ).append("\n"); 
		query.append("     , INTER_WDT" ).append("\n"); 
		query.append("     , INTER_HGT" ).append("\n"); 
		query.append("     , OPN_DOR_WDT" ).append("\n"); 
		query.append("     , OPN_DOR_HGT" ).append("\n"); 
		query.append("     , RC_LDB_CAPA" ).append("\n"); 
		query.append("     , RC_LDB_HGT" ).append("\n"); 
		query.append("     , TNK_CAPA" ).append("\n"); 
		query.append("	 , FRACK_CLPS_CTNT" ).append("\n"); 
		query.append("     , FRACK_BED_TIK_CTNT" ).append("\n"); 
		query.append("     , OPNTP_ROOF_OPN_CTNT" ).append("\n"); 
		query.append("     , OPNTP_INTR_HGT_CTNT" ).append("\n"); 
		query.append("     , OPNTP_REAR_HDR_OPN_CTNT" ).append("\n"); 
		query.append("	 , RF_HUMID_CTRL_VAL_CD" ).append("\n"); 
		query.append("     , RF_CMPR_CTNT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  SPEC.CNTR_SPEC_NO" ).append("\n"); 
		query.append("	  , 'Standard' AS CNTR_SPEC_TYPE_CD" ).append("\n"); 
		query.append("      , MST_COMMON_PKG.MST_AGMT_NO_CONV_FNC(MC.AGMT_CTY_CD, MC.AGMT_SEQ) AS AGMT_NO" ).append("\n"); 
		query.append("      , SPEC.CNTR_SPEC_NO" ).append("\n"); 
		query.append("        ||NVL(TRIM(MC.AGMT_CTY_CD||TRIM(TO_CHAR(MC.AGMT_SEQ, '000000'))), 'X')" ).append("\n"); 
		query.append("        ||DECODE(MC.LSTM_CD, 'SI', 'X', 'MI', 'X', 'SH', 'X', 'OF', 'X', NVL(TRIM(MC.LOT_PLN_YR||'-'||MC.LOT_LOC_CD||'-'||MC.CNTR_TPSZ_CD||'-'||LTRIM(TO_CHAR(MC.LOT_SEQ,'000'))), 'X'))" ).append("\n"); 
		query.append("        ||NVL(TRIM(TO_CHAR(MC.MFTR_VNDR_SEQ, '000000')), 'X') AS LOT_NO" ).append("\n"); 
		query.append("      , MAX(MC.LSTM_CD) LSTM_CD" ).append("\n"); 
		query.append("      , MAX(MDM.VNDR_SEQ) VNDR_SEQ" ).append("\n"); 
		query.append("	  , MC.MFTR_VNDR_SEQ AS HID_VNDR_SEQ" ).append("\n"); 
		query.append("	  , MAX(MDM.VNDR_LGL_ENG_NM) VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("      , (SELECT NVL(SUB.VNDR_ABBR_NM, SUB.VNDR_LGL_ENG_NM)" ).append("\n"); 
		query.append("               FROM MDM_VENDOR SUB" ).append("\n"); 
		query.append("              WHERE MC.MFTR_VNDR_SEQ = SUB.VNDR_SEQ" ).append("\n"); 
		query.append("                AND ROWNUM           = 1) AS VNDR_ABBR_NM" ).append("\n"); 
		query.append("	  , SUBSTR(SPEC.CNTR_SPEC_NO, 1, 4) AS YR_BUILD" ).append("\n"); 
		query.append("      , NULL AS TTL_LOT_QTY" ).append("\n"); 
		query.append("      , SUM(DECODE(MC.ACIAC_DIV_CD, 'A', 1, 0)) AS TTL_ACT_QTY" ).append("\n"); 
		query.append("      , MAX(SPEC.CNTR_TPSZ_CD) CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      , MAX((SELECT INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("           FROM COM_INTG_CD_DTL CID" ).append("\n"); 
		query.append("          WHERE 1=1" ).append("\n"); 
		query.append("            AND INTG_CD_ID ='CD01862' " ).append("\n"); 
		query.append("            AND CID.INTG_CD_VAL_CTNT = SPEC.CNTR_MTRL_CD" ).append("\n"); 
		query.append("            AND ROWNUM               = 1)) AS CNTR_MTRL_CD" ).append("\n"); 
		query.append("	  , MAX((SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("           FROM COM_INTG_CD_DTL CID" ).append("\n"); 
		query.append("          WHERE 1=1" ).append("\n"); 
		query.append("            AND INTG_CD_ID ='CD01862' " ).append("\n"); 
		query.append("            AND CID.INTG_CD_VAL_CTNT = SPEC.CNTR_MTRL_CD" ).append("\n"); 
		query.append("            AND ROWNUM               = 1)) AS CNTR_MTRL_NM" ).append("\n"); 
		query.append("      , '' SER_RANGE" ).append("\n"); 
		query.append("      , MAX((SELECT NVL(MV.VNDR_ABBR_NM, MV.VNDR_LGL_ENG_NM) FROM MDM_VENDOR MV WHERE MV.VNDR_SEQ = MC.RF_MKR_SEQ AND ROWNUM = 1)) AS RF_MKR_SEQ" ).append("\n"); 
		query.append("      , MAX(MC.RF_MDL_NM) RF_MDL_NM" ).append("\n"); 
		query.append("      , MAX(MC.RF_RFR_NO) RF_RFR_NO" ).append("\n"); 
		query.append("      , MAX(MC.MIN_TEMP || DECODE(MC.MIN_TEMP, NULL, '',' ~ ') || MC.MAX_TEMP) AS MAX_TEMP" ).append("\n"); 
		query.append("      , MAX(SPEC.LOD_CAPA) LOD_CAPA" ).append("\n"); 
		query.append("      , MAX(SPEC.CNTR_GRS_WGT) CNTR_GRS_WGT" ).append("\n"); 
		query.append("      , MAX(SPEC.TARE_WGT) TARE_WGT" ).append("\n"); 
		query.append("      , MAX(SPEC.XTER_LEN) XTER_LEN" ).append("\n"); 
		query.append("      , MAX(SPEC.XTER_WDT) XTER_WDT" ).append("\n"); 
		query.append("      , MAX(SPEC.XTER_HGT) XTER_HGT" ).append("\n"); 
		query.append("      , MAX(SPEC.INTER_LEN) INTER_LEN" ).append("\n"); 
		query.append("      , MAX(SPEC.INTER_WDT) INTER_WDT" ).append("\n"); 
		query.append("      , MAX(SPEC.INTER_HGT) INTER_HGT" ).append("\n"); 
		query.append("      , MAX(SPEC.OPN_DOR_WDT) OPN_DOR_WDT" ).append("\n"); 
		query.append("      , MAX(SPEC.OPN_DOR_HGT) OPN_DOR_HGT" ).append("\n"); 
		query.append("      , MAX(SPEC.RC_LDB_CAPA) RC_LDB_CAPA" ).append("\n"); 
		query.append("      , MAX(SPEC.RC_LDB_HGT) RC_LDB_HGT" ).append("\n"); 
		query.append("      , MAX(SPEC.TNK_CAPA) TNK_CAPA" ).append("\n"); 
		query.append("      , MAX(SPEC.FRACK_CLPS_CTNT) FRACK_CLPS_CTNT" ).append("\n"); 
		query.append("	  , MAX(SPEC.FRACK_BED_TIK_CTNT) FRACK_BED_TIK_CTNT" ).append("\n"); 
		query.append("      , MAX(SPEC.OPNTP_ROOF_OPN_CTNT) OPNTP_ROOF_OPN_CTNT" ).append("\n"); 
		query.append("      , MAX(SPEC.OPNTP_INTR_HGT_CTNT) OPNTP_INTR_HGT_CTNT" ).append("\n"); 
		query.append("      , MAX(SPEC.OPNTP_REAR_HDR_OPN_CTNT) AS OPNTP_REAR_HDR_OPN_CTNT" ).append("\n"); 
		query.append("      , MAX((SELECT INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("               FROM COM_INTG_CD_DTL " ).append("\n"); 
		query.append("               WHERE INTG_CD_ID     = 'CD30023' " ).append("\n"); 
		query.append("               AND INTG_CD_VAL_CTNT = MC.RF_HUMID_CTRL_VAL_CD" ).append("\n"); 
		query.append("               AND ROWNUM           = 1)) AS RF_HUMID_CTRL_VAL_CD" ).append("\n"); 
		query.append("	  , MAX((SELECT S.INTG_CD_VAL_DP_DESC ||' (' ||S.INTG_CD_VAL_DESC || ')' " ).append("\n"); 
		query.append("                   FROM COM_INTG_CD_DTL S" ).append("\n"); 
		query.append("                  WHERE S.INTG_CD_VAL_CTNT = MC.RF_TP_CD" ).append("\n"); 
		query.append("                    AND S.INTG_CD_ID       = 'CD01085'" ).append("\n"); 
		query.append("                    AND ROWNUM             = 1)) AS RF_TP_CD" ).append("\n"); 
		query.append("      , MAX(MC.RF_CMPR_CTNT) AS RF_CMPR_CTNT" ).append("\n"); 
		query.append("FROM  MST_CNTR_SPEC SPEC" ).append("\n"); 
		query.append("        , MST_CONTAINER MC" ).append("\n"); 
		query.append("        , MST_CNTR_LOT LOT" ).append("\n"); 
		query.append("        , MDM_VENDOR    MDM" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND   SPEC.CNTR_SPEC_NO = MC.CNTR_SPEC_NO(+)" ).append("\n"); 
		query.append("AND   MC.LOT_PLN_YR     = LOT.LOT_PLN_YR(+)" ).append("\n"); 
		query.append("AND   MC.LOT_LOC_CD     = LOT.LOT_LOC_CD(+)" ).append("\n"); 
		query.append("AND   MC.CNTR_TPSZ_CD   = LOT.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("AND   MC.LOT_SEQ        = LOT.LOT_SEQ(+)" ).append("\n"); 
		query.append("AND   MC.VNDR_SEQ       = MDM.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND   MC.LSTM_CD(+)   IN ( 'SH', 'OF', 'MI', 'SI', 'ST')" ).append("\n"); 
		query.append("AND   SPEC.OWN_CNTR_FLG = 'N'" ).append("\n"); 
		query.append("#if(${own_cntr_flg} == 'A')" ).append("\n"); 
		query.append("    AND   SPEC.CNTR_SPEC_TP_CD  IN( 'S', DECODE(MC.LSTM_CD, 'SH', 'L', 'OF', 'L', 'SI', 'L', 'SI', 'L', 'X')) " ).append("\n"); 
		query.append("	AND   (SPEC.CNTR_SPEC_TP_CD =  'S'  OR MC.LSTM_CD   IN ( 'SH', 'OF', 'MI', 'SI'))" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    AND   SPEC.CNTR_SPEC_TP_CD  IN( @[own_cntr_flg], DECODE(MC.LSTM_CD, 'SH', 'L', 'OF', 'L', 'SI', 'L', 'SI', 'L', 'X')) " ).append("\n"); 
		query.append("	AND   (SPEC.CNTR_SPEC_TP_CD =  @[own_cntr_flg]  OR MC.LSTM_CD   IN ( 'SH', 'OF', 'MI', 'SI')) " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${lstm_cd} != '')" ).append("\n"); 
		query.append("AND   MC.LSTM_CD(+)     = @[lstm_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${from_spec_yr} != '')" ).append("\n"); 
		query.append("AND   SPEC.SPEC_YR     >= @[from_spec_yr]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${to_spec_yr} != '')" ).append("\n"); 
		query.append("AND   SPEC.SPEC_YR    <= @[to_spec_yr]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cntr_tpsz_cd} != '' && ${cntr_tpsz_cd} != 'ALL')" ).append("\n"); 
		query.append("AND   SPEC.CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${agmt_no} != '')" ).append("\n"); 
		query.append("AND   MC.AGMT_CTY_CD   = SUBSTR(@[agmt_no],1,3)" ).append("\n"); 
		query.append("AND   MC.AGMT_SEQ      = TO_NUMBER(SUBSTR(@[agmt_no],4))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${vndr_seq} != '')" ).append("\n"); 
		query.append("AND SPEC.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY SPEC.CNTR_SPEC_NO, MC.AGMT_CTY_CD, MC.AGMT_SEQ, MC.MFTR_VNDR_SEQ,SPEC.CNTR_SPEC_TP_CD" ).append("\n"); 
		query.append("       , SPEC.CNTR_SPEC_NO" ).append("\n"); 
		query.append("        ||NVL(TRIM(MC.AGMT_CTY_CD||TRIM(TO_CHAR(MC.AGMT_SEQ, '000000'))), 'X')" ).append("\n"); 
		query.append("        ||DECODE(MC.LSTM_CD, 'SI', 'X', 'MI', 'X', 'SH', 'X', 'OF', 'X', NVL(TRIM(MC.LOT_PLN_YR||'-'||MC.LOT_LOC_CD||'-'||MC.CNTR_TPSZ_CD||'-'||LTRIM(TO_CHAR(MC.LOT_SEQ,'000'))), 'X'))" ).append("\n"); 
		query.append("        ||NVL(TRIM(TO_CHAR(MC.MFTR_VNDR_SEQ, '000000')), 'X')" ).append("\n"); 
		query.append("ORDER BY SPEC.CNTR_SPEC_NO DESC" ).append("\n"); 
		query.append(") WHERE 1=1" ).append("\n"); 
		query.append("#if(${zero_active_qty} == 'E')" ).append("\n"); 
		query.append("AND	 TTL_ACT_QTY > 0" ).append("\n"); 
		query.append("#elseif(${zero_active_qty} == 'O')" ).append("\n"); 
		query.append("AND	 TTL_ACT_QTY = 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}