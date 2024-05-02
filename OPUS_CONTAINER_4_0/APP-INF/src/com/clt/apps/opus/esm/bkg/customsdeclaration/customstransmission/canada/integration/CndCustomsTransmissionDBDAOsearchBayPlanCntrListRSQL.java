/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CndCustomsTransmissionDBDAOsearchBayPlanCntrListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.03
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndCustomsTransmissionDBDAOsearchBayPlanCntrListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * transmit. BayPlanCntrDetailVO
	  * </pre>
	  */
	public CndCustomsTransmissionDBDAOsearchBayPlanCntrListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.integration").append("\n"); 
		query.append("FileName : CndCustomsTransmissionDBDAOsearchBayPlanCntrListRSQL").append("\n"); 
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
		query.append("SELECT BPC.ID CNTR_NO, " ).append("\n"); 
		query.append("  BPC.SZTP_ISO CNTRTYPE," ).append("\n"); 
		query.append("  BPC.FE FM_IND," ).append("\n"); 
		query.append("  LPAD(BPC.BAY||BPC.ROWW||BPC.TIER, 7, '0') POS," ).append("\n"); 
		query.append("  DECODE(NVL(BPC.WEIGHT, 0), 0, 0, BPC.WEIGHT * 1000) WGT," ).append("\n"); 
		query.append("  NVL(BPC.POR, '') POR," ).append("\n"); 
		query.append("  NVL(DECODE( VL1.UN_LOC_IND_CD, 'Y', VL1.LOC_CD, VL1.UN_LOC_CD) , BPC.POL ) POL," ).append("\n"); 
		query.append("  NVL(DECODE( VL2.UN_LOC_IND_CD, 'Y', VL2.LOC_CD, VL2.UN_LOC_CD) , BPC.POD_ISO ) POD," ).append("\n"); 
		query.append("  (SELECT B.DEL_CD" ).append("\n"); 
		query.append("    FROM BKG_VVD V, BKG_CONTAINER C,  BKG_BOOKING B" ).append("\n"); 
		query.append("    WHERE V.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("      AND V.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("      AND V.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("      AND V.POL_CD = BPC.POL" ).append("\n"); 
		query.append("      AND V.POD_CD = BPC.POD_ISO" ).append("\n"); 
		query.append("      AND V.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("      AND C.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("      AND V.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("      AND ROWNUM = 1 ) DEL," ).append("\n"); 
		query.append("  BPC.IMDG IMDG," ).append("\n"); 
		query.append("  BPC.UNNO UNNO," ).append("\n"); 
		query.append("  NVL(BPC.CO_LOADED,'') CO_LOADED," ).append("\n"); 
		query.append("--  DECODE(BPC.OPR_CD, 'HJS', 'HJSC', 'KKL', 'KKLU', 'COS', 'COSU', 'YML', 'YMLU', 'SEN', 'SENU', 'UAC', 'UASC', BPC.OPR_CD) SCAC," ).append("\n"); 
		query.append("  DECODE(BPC.OPR_CD, 'NYK', 'NYKS','APL','APLU','HMM','HDMU','HLC','HLCU','KKK','KKLU','MOL','MOLU','OOL','OOLU','YML','YMLU','ZIM','ZIMU', BPC.OPR_CD) SCAC," ).append("\n"); 
		query.append("  CNTR_SIZE," ).append("\n"); 
		query.append("  XTER_LEN, XTER_WDT, XTER_HGT, " ).append("\n"); 
		query.append("  NVL(REPLACE(REPLACE(BPC.TEMP,'F',''),'C',''),'') TEMP," ).append("\n"); 
		query.append("  NVL(CASE WHEN INSTR(TEMP,'C') != 0 THEN 'CEL' WHEN INSTR(TEMP,'F') != 0 THEN 'FAH' END,'') TUNIT," ).append("\n"); 
		query.append("  -- 2016-11-03 CNTR STATUS 값 지정" ).append("\n"); 
		query.append("  --BPC.DELV_CD CNTR_STATUS," ).append("\n"); 
		query.append("  NVL(DECODE(BPC.DELV_CD,'0','',BPC.DELV_CD), " ).append("\n"); 
		query.append("        CASE WHEN BPC.POD LIKE 'CA%' THEN '3'" ).append("\n"); 
		query.append("        WHEN BPC.POD NOT LIKE 'CA%' THEN '4'" ).append("\n"); 
		query.append("        ELSE ''" ).append("\n"); 
		query.append("        END) CNTR_STATUS," ).append("\n"); 
		query.append("  -- 2016-11-03 CNTR STATUS 값 지정" ).append("\n"); 
		query.append("  '' PCK_QTY,'' PCK_TP_CD, '' CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append("FROM BAY_PLAN BPC, MDM_LOCATION VL1, MDM_LOCATION VL2," ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("     SELECT A.CNTR_NO, B.XTER_LEN/100 XTER_LEN, B.XTER_WDT/100 XTER_WDT, B.XTER_HGT/100 XTER_HGT" ).append("\n"); 
		query.append("     FROM MST_CONTAINER A, MST_CNTR_SPEC B" ).append("\n"); 
		query.append("     WHERE A.CNTR_SPEC_NO = B.CNTR_SPEC_NO" ).append("\n"); 
		query.append("     AND A.CNTR_TPSZ_CD =  B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     AND A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("    ) CNTR" ).append("\n"); 
		query.append("WHERE BPC.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("  AND BPC.VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("  AND BPC.DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("  AND BPC.PORT_CD = @[pol]" ).append("\n"); 
		query.append("  AND BPC.ID = @[cntr_no]" ).append("\n"); 
		query.append("  AND BPC.ID = CNTR.CNTR_NO(+)" ).append("\n"); 
		query.append("  AND BPC.POL = VL1.LOC_CD(+)" ).append("\n"); 
		query.append("  AND BPC.POD_ISO = VL2.LOC_CD(+)" ).append("\n"); 
		query.append("  AND BPC.PLAN_TYPE= ( SELECT MIN(PLAN_TYPE) FROM BAY_PLAN BB" ).append("\n"); 
		query.append("                 WHERE BPC.VSL_CD = BB.VSL_CD" ).append("\n"); 
		query.append("                 AND BPC.VOY_NO = BB.VOY_NO" ).append("\n"); 
		query.append("                 AND BPC.DIR_CD = BB.DIR_CD" ).append("\n"); 
		query.append("                 AND BPC.PORT_CD = BB.PORT_CD" ).append("\n"); 
		query.append("                 AND BPC.ID = BB.ID" ).append("\n"); 
		query.append("                 AND BPC.CALL_IND = BB.CALL_IND" ).append("\n"); 
		query.append("                 )" ).append("\n"); 

	}
}