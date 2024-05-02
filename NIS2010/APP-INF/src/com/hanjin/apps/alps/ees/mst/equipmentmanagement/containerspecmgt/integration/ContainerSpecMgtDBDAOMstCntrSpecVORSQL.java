/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ContainerSpecMgtDBDAOMstCntrSpecVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
	  * [CHM-201111999] 나상보 [MST] ALPS-CNTR Master-Master->Specification Inquiry 보완
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
		params.put("from_spec_yr",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.integration").append("\n"); 
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
		query.append("#if(${own_cntr_flg} == 'Y')" ).append("\n"); 
		query.append("SELECT SPEC.CNTR_SPEC_NO" ).append("\n"); 
		query.append("     , MST_COMMON_PKG.MST_AGMT_NO_CONV_FNC(LOT.AGMT_CTY_CD, LOT.AGMT_SEQ) AS AGMT_NO" ).append("\n"); 
		query.append("     , (SELECT LSTM_CD" ).append("\n"); 
		query.append("        FROM   LSE_AGREEMENT L" ).append("\n"); 
		query.append("        WHERE  LOT.AGMT_CTY_CD = L.AGMT_CTY_CD" ).append("\n"); 
		query.append("        AND    LOT.AGMT_SEQ    = L.AGMT_SEQ" ).append("\n"); 
		query.append("       ) AS LSTM_CD" ).append("\n"); 
		query.append("     , LOT.FCTRY_SPEC_NO" ).append("\n"); 
		query.append("     , DECODE(LOT.LOT_PLN_YR,NULL,NULL,LOT.LOT_PLN_YR||'-'||LOT.LOT_LOC_CD||'-'||LOT.CNTR_TPSZ_CD||'-'||LTRIM(TO_CHAR(LOT.LOT_SEQ,'000'))) LOT_NO" ).append("\n"); 
		query.append("     , SPEC.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , MDM.VNDR_SEQ" ).append("\n"); 
		query.append("     , MDM.VNDR_ABBR_NM" ).append("\n"); 
		query.append("     , SPEC.CNTR_MTRL_CD" ).append("\n"); 
		query.append("     , DECODE(LOT.LOT_PLN_YR,NULL,NULL,LOT.LOT_CNTR_PFX_CD||TO_CHAR(LOT.FM_SER_NO,'000000')||' -'||TO_CHAR(LOT.TO_SER_NO,'000000')) SER_RANGE" ).append("\n"); 
		query.append("     , TO_NUMBER(LTRIM(TO_CHAR(LOT.TO_SER_NO,'000000'))) -" ).append("\n"); 
		query.append("       TO_NUMBER(LTRIM(TO_CHAR(LOT.FM_SER_NO,'000000'))) + 1 AS TTL_LOT_QTY" ).append("\n"); 
		query.append("     , (SELECT /*+ INDEX(A XPKMST_CONTAINER) */ COUNT(1) - SUM(" ).append("\n"); 
		query.append("                DECODE(A.CNTR_STS_CD,'SLD',1,0) +" ).append("\n"); 
		query.append("                DECODE(A.CNTR_STS_CD,'TLL',1,0) +" ).append("\n"); 
		query.append("                DECODE(A.CNTR_STS_CD,'DON',1,0) +" ).append("\n"); 
		query.append("                DECODE(A.CNTR_STS_CD,'SCR',1,0) )" ).append("\n"); 
		query.append("        FROM    MST_CONTAINER A" ).append("\n"); 
		query.append("        WHERE   1=1" ).append("\n"); 
		query.append("        AND     A.CNTR_NO BETWEEN LOT.LOT_CNTR_PFX_CD||LTRIM(TO_CHAR(LOT.FM_SER_NO,'000000')) || '0'" ).append("\n"); 
		query.append("                          AND     LOT.LOT_CNTR_PFX_CD||LTRIM(TO_CHAR(LOT.TO_SER_NO,'000000')) || '9'" ).append("\n"); 
		query.append("        AND     A.OWNR_CO_CD   = 'H'" ).append("\n"); 
		query.append("        AND     A.LSTM_CD IN ('OW','LP','OL')" ).append("\n"); 
		query.append("     ) AS TTL_ACT_QTY" ).append("\n"); 
		query.append("     , (SELECT S.INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("        FROM   COM_INTG_CD_DTL S" ).append("\n"); 
		query.append("        WHERE  S.INTG_CD_VAL_CTNT = LOT.RF_TP_CD" ).append("\n"); 
		query.append("        AND    S.INTG_CD_ID       = 'CD01085'" ).append("\n"); 
		query.append("     ) AS RF_TP_CD" ).append("\n"); 
		query.append("     , NVL2(CNTR_HNGR_RCK_CD, 'Y', 'N') AS CNTR_HNGR_RCK_FLG" ).append("\n"); 
		query.append("     , PLST_FLR_FLG" ).append("\n"); 
		query.append("     ,(SELECT NVL(VNDR_ABBR_NM, VNDR_LGL_ENG_NM) FROM MDM_VENDOR WHERE VNDR_SEQ = LOT.RF_MKR_SEQ) AS RF_MKR_SEQ" ).append("\n"); 
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
		query.append("FROM  MST_CNTR_SPEC SPEC,  MST_CNTR_LOT LOT, MDM_VENDOR MDM" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND   LOT.CNTR_SPEC_NO(+) = SPEC.CNTR_SPEC_NO" ).append("\n"); 
		query.append("AND   SPEC.VNDR_SEQ       = MDM.VNDR_SEQ  (+)" ).append("\n"); 
		query.append("AND   SPEC.OWN_CNTR_FLG = 'Y'" ).append("\n"); 
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
		query.append("#end" ).append("\n"); 
		query.append("#if(${own_cntr_flg} == 'N')" ).append("\n"); 
		query.append("SELECT  SPEC.CNTR_SPEC_NO" ).append("\n"); 
		query.append("      , MST_COMMON_PKG.MST_AGMT_NO_CONV_FNC(LSE.AGMT_CTY_CD, LSE.AGMT_SEQ) AS AGMT_NO" ).append("\n"); 
		query.append("      , LSE2.LSTM_CD" ).append("\n"); 
		query.append("      , SPEC.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      , MDM.VNDR_SEQ" ).append("\n"); 
		query.append("      , MDM.VNDR_ABBR_NM" ).append("\n"); 
		query.append("      , SPEC.CNTR_MTRL_CD" ).append("\n"); 
		query.append("      , '' RF_MKR_SEQ" ).append("\n"); 
		query.append("      , '' RF_MDL_NM" ).append("\n"); 
		query.append("      , '' RF_RFR_NO" ).append("\n"); 
		query.append("      , '' MIN_TEMP" ).append("\n"); 
		query.append("      , '' MAX_TEMP" ).append("\n"); 
		query.append("      , SPEC.LOD_CAPA" ).append("\n"); 
		query.append("      , SPEC.CNTR_GRS_WGT" ).append("\n"); 
		query.append("      , SPEC.TARE_WGT" ).append("\n"); 
		query.append("      , SPEC.XTER_LEN" ).append("\n"); 
		query.append("      , SPEC.XTER_WDT" ).append("\n"); 
		query.append("      , SPEC.XTER_HGT" ).append("\n"); 
		query.append("      , SPEC.INTER_LEN" ).append("\n"); 
		query.append("      , SPEC.INTER_WDT" ).append("\n"); 
		query.append("      , SPEC.INTER_HGT" ).append("\n"); 
		query.append("      , SPEC.OPN_DOR_WDT" ).append("\n"); 
		query.append("      , SPEC.OPN_DOR_HGT" ).append("\n"); 
		query.append("      , SPEC.RC_LDB_CAPA" ).append("\n"); 
		query.append("      , SPEC.RC_LDB_HGT" ).append("\n"); 
		query.append("      , SPEC.TNK_CAPA" ).append("\n"); 
		query.append("FROM  MST_CNTR_SPEC SPEC" ).append("\n"); 
		query.append("    , LSE_AGMT_RT   LSE" ).append("\n"); 
		query.append("    , MDM_VENDOR    MDM" ).append("\n"); 
		query.append("    , LSE_AGREEMENT LSE2" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND   SPEC.CNTR_SPEC_NO = LSE.CNTR_SPEC_NO       (+)" ).append("\n"); 
		query.append("AND   'KRSEL'           = LSE.LOC_CD             (+)" ).append("\n"); 
		query.append("AND   SPEC.CNTR_TPSZ_CD = LSE.CNTR_TPSZ_CD       (+)" ).append("\n"); 
		query.append("AND   'GENV'            = LSE.CNTR_RNTL_CHG_TP_CD(+)" ).append("\n"); 
		query.append("AND   LSE.AGMT_CTY_CD   = LSE2.AGMT_CTY_CD       (+)" ).append("\n"); 
		query.append("AND   LSE.AGMT_SEQ      = LSE2.AGMT_SEQ          (+)" ).append("\n"); 
		query.append("AND   SPEC.VNDR_SEQ     = MDM.VNDR_SEQ           (+)" ).append("\n"); 
		query.append("AND   SPEC.OWN_CNTR_FLG = 'N'" ).append("\n"); 
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
		query.append("AND   LSE.AGMT_CTY_CD   = SUBSTR(@[agmt_no],1,3)" ).append("\n"); 
		query.append("AND   LSE.AGMT_SEQ      = TO_NUMBER(SUBSTR(@[agmt_no],4))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY SPEC.CNTR_SPEC_NO DESC" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}