/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOsearchTmnl301DgInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOsearchTmnl301DgInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchTmnl301DgInfo
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOsearchTmnl301DgInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOsearchTmnl301DgInfoRSQL").append("\n"); 
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
		query.append("SELECT DG.BKG_NO," ).append("\n"); 
		query.append("	DG.DG_CNTR_SEQ," ).append("\n"); 
		query.append("	MAX('{CNTR_INFO'															|| CHR(10)" ).append("\n"); 
		query.append("	|| 'CNTN:'					|| RPAD(DG.CNTR_NO, 11, ' ')			|| CHR(10)" ).append("\n"); 
		query.append("    || 'CSN:'                   || RPAD((SELECT SLOT_NO||SLOT_NO_SEQ" ).append("\n"); 
		query.append("                                                  FROM (" ).append("\n"); 
		query.append("                                                      SELECT SPC_TP, TB_ROW_ID, SLOT_NO" ).append("\n"); 
		query.append("                                                             , chr(65+trunc(ROWNUM/26)-decode(mod(ROWNUM,26),0,1,0))||chr(64+decode(mod(ROWNUM,26),0,26,mod(ROWNUM,26))) AS SLOT_NO_SEQ" ).append("\n"); 
		query.append("                                                      FROM (" ).append("\n"); 
		query.append("                                                          SELECT 'GC' SPC_TP, SCH.ROWID TB_ROW_ID, SUBSTR(SCH.BKG_NO,-5) SLOT_NO" ).append("\n"); 
		query.append("                                                          FROM SCE_COP_HDR SCH" ).append("\n"); 
		query.append("                                                          WHERE SCH.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                                          UNION ALL" ).append("\n"); 
		query.append("                                                          SELECT 'RF' SPC_TP, RF.ROWID TB_ROW_ID, SUBSTR(RF.BKG_NO,-5) SLOT_NO" ).append("\n"); 
		query.append("                                                          FROM BKG_RF_CGO RF" ).append("\n"); 
		query.append("                                                          WHERE RF.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                                          UNION ALL" ).append("\n"); 
		query.append("                                                          SELECT 'DG' SPC_TP, DG.ROWID, SUBSTR(DG.BKG_NO,-5) SLOT_NO" ).append("\n"); 
		query.append("                                                          FROM BKG_DG_CGO DG" ).append("\n"); 
		query.append("                                                          WHERE DG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                                          UNION ALL" ).append("\n"); 
		query.append("                                                          SELECT 'AWK' SPC_TP, AWK.ROWID, SUBSTR(AWK.BKG_NO,-5) SLOT_NO" ).append("\n"); 
		query.append("                                                          FROM BKG_AWK_CGO AWK" ).append("\n"); 
		query.append("                                                          WHERE AWK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                                          )" ).append("\n"); 
		query.append("                                                  ORDER BY SPC_TP, TB_ROW_ID) SPC" ).append("\n"); 
		query.append("                                                  WHERE SPC_TP = 'DG'" ).append("\n"); 
		query.append("                                                  AND SPC.TB_ROW_ID = DG.ROWID" ).append("\n"); 
		query.append("                                                  AND ROWNUM = 1" ).append("\n"); 
		query.append("                                   ), 11, ' ')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'CNTT:'					|| DG.CNTR_TPSZ_CD								|| CHR(10)" ).append("\n"); 
		query.append("	|| 'MRN:'					|| (SELECT BR.CUST_REF_NO_CTNT FROM BKG_REFERENCE BR WHERE BR.BKG_REF_TP_CD = 'CMRN' AND BR.BKG_NO = BK.BKG_NO AND BR.CNTR_NO = CNTR.CNTR_NO AND ROWNUM = 1)	|| CHR(10)" ).append("\n"); 
		query.append("    || 'UCR:'					|| NVL((SELECT BR.CUST_REF_NO_CTNT FROM BKG_REFERENCE BR WHERE BR.BKG_REF_TP_CD = 'CUCR' AND BR.BKG_NO = BK.BKG_NO AND BR.CNTR_NO = CNTR.CNTR_NO AND ROWNUM = 1)" ).append("\n"); 
		query.append("                         ,(SELECT BR.CUST_REF_NO_CTNT FROM BKG_REFERENCE BR WHERE BR.BKG_REF_TP_CD = 'CUCR' AND BR.BKG_NO = BK.BKG_NO AND ROWNUM = 1))	|| CHR(10)" ).append("\n"); 
		query.append("    || 'HS_CD:'					|| (SELECT BCMD.CMDT_HS_CD FROM BKG_CNTR_MF_DESC BCMD WHERE BCMD.BKG_NO = CNTR.BKG_NO AND BCMD.CNTR_NO = CNTR.CNTR_NO AND ROWNUM = 1) || CHR(10)" ).append("\n"); 
		query.append("	|| 'RIND:'                  || decode(BK.RC_FLG,'Y','1','0')			    || CHR(10)" ).append("\n"); 
		query.append("	|| 'DIND:'                  || decode(BK.DCGO_FLG,'Y','1','0')				|| CHR(10)" ).append("\n"); 
		query.append("	|| 'AIND:'                  || decode(BK.AWK_CGO_FLG,'Y','1','0')			|| CHR(10)" ).append("\n"); 
		query.append("	|| 'BIND:'                  || decode(BK.BB_CGO_FLG,'Y','1','0')			|| CHR(10)" ).append("\n"); 
		query.append("	|| 'WGT_QTY:'               || CASE WHEN NVL(Cntr.CNTR_WGT,0) = 0 THEN ROUND((SELECT BLD.ACT_WGT/NVL((SELECT SUM(BQ.OP_CNTR_QTY) FROM BKG_QUANTITY BQ WHERE BQ.BKG_NO = BLD.BKG_NO),1) FROM BKG_BL_DOC BLD WHERE BLD.BKG_NO = BK.BKG_NO),3)" ).append("\n"); 
		query.append("                                        ELSE Cntr.CNTR_WGT END 					|| CHR(10)" ).append("\n"); 
		query.append("	|| 'WGT_TP:'                || CASE WHEN Cntr.WGT_UT_CD IS NULL THEN (SELECT BLD.WGT_UT_CD FROM BKG_BL_DOC BLD WHERE BLD.BKG_NO = BK.BKG_NO)" ).append("\n"); 
		query.append("                                        ELSE Cntr.WGT_UT_CD END 				|| CHR(10)" ).append("\n"); 
		query.append("    || 'NWGT_QTY:'              || CASE WHEN NVL(DG.NET_WGT,0) = 0 THEN ROUND((SELECT BLD.ACT_WGT/NVL((SELECT SUM(BQ.OP_CNTR_QTY) FROM BKG_QUANTITY BQ WHERE BQ.BKG_NO = BLD.BKG_NO),1) FROM BKG_BL_DOC BLD WHERE BLD.BKG_NO = BK.BKG_NO),3)" ).append("\n"); 
		query.append("                                        ELSE DG.NET_WGT END 					|| CHR(10)" ).append("\n"); 
		query.append("	|| 'NWGT_TP:KGS'             												|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TEMP:'																	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TUN:'																	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TEMP_C:'																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TUN_C:'																	|| CHR(10)" ).append("\n"); 
		query.append("    || 'PRECOOLING:'															|| CHR(10)" ).append("\n"); 
		query.append("	|| 'RF_VOLTAGE:'															|| CHR(10)" ).append("\n"); 
		query.append("	|| 'VENT:'																	|| CHR(10)" ).append("\n"); 
		query.append("    || 'VENT_NUM:'																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'VENT_CMH:'																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'HUMID:'																	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'GENSET:'				|| 'N'											|| CHR(10)" ).append("\n"); 
		query.append("    || 'GENSET_CD:'																|| CHR(10)" ).append("\n"); 
		query.append("    || 'GENSET_DESC:'															|| CHR(10)" ).append("\n"); 
		query.append("	|| 'RF_REMARK:'																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'RFDRY_IND:'				|| decode(BK.RD_CGO_FLG,'Y','1','0')			|| CHR(10)" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("	|| 'RF_DRAIN:'																|| CHR(10)" ).append("\n"); 
		query.append("    || 'AK_UNIT:'				    											|| CHR(10)" ).append("\n"); 
		query.append("	|| 'OVF:'																	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'OVR:'																	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'OVH:'																	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'OVLW:'																	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'OVRW:'																	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'OVWGT:'																	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'VOID_SLOT:'																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'STWG_REQ:'																|| CHR(10)" ).append("\n"); 
		query.append("    || 'MEMO:'																	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TTL_DIM_LEN:'															|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TTL_DIM_WDT:'															|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TTL_DIM_HGT:'															|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRM_TYPE:'																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRM_WEIGHT:'															|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRM_HAULAGE:'															|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRM_HMODE:'																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRM_PICKUP_CY:'															|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRM_RETURN_CY:'															|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRM_INSTRUCTION:'														|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRM_TRAN_DT:'															|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRM_TRAN_OFFICE:'														|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRM_TRAN_NO:'															|| CHR(10)" ).append("\n"); 
		query.append("	|| 'USR_ID:'																|| CHR(10)" ).append("\n"); 
		query.append("    || MAX(CASE WHEN (SELECT COUNT(*) FROM BKG_CNTR_SEAL_NO BCS WHERE CNTR.BKG_NO = BCS.BKG_NO AND CNTR.CNTR_NO = BCS.CNTR_NO) = 0 THEN '{CNTR_SEAL_NO'|| CHR(10) || 'SEAL_NO:'||CHR(10) ||'}CNTR_SEAL_NO'||CHR(10)" ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("                 BKG_JOIN_FNC(CURSOR(SELECT '{CNTR_SEAL_NO'|| CHR(10) || 'SEAL_NO:'||BKG_SPCLCHAR_CONV_FNC(BCS.CNTR_SEAL_NO,'E')|| CHR(10)|| '}CNTR_SEAL_NO' " ).append("\n"); 
		query.append("                                     FROM BKG_CNTR_SEAL_NO BCS " ).append("\n"); 
		query.append("                                     WHERE CNTR.BKG_NO = BCS.BKG_NO AND CNTR.CNTR_NO = BCS.CNTR_NO) , CHR(10))||CHR(10)" ).append("\n"); 
		query.append("       END) " ).append("\n"); 
		query.append("    || MAX(CASE WHEN (SELECT COUNT(*) FROM BKG_CNTR_MF_DESC BCM WHERE BCM.BKG_NO = CNTR.BKG_NO AND BCM.CNTR_NO = CNTR.CNTR_NO) = 0 THEN '{CNTR_CARGO'|| CHR(10) || 'CARGO_DESC:'||CHR(10) ||'}CNTR_CARGO'||CHR(10)" ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("                  BKG_JOIN_FNC(CURSOR(SELECT '{CNTR_CARGO'|| CHR(10) || 'CARGO_DESC:'||BKG_SPCLCHAR_CONV_FNC(BCM.CNTR_MF_GDS_DESC,'E')|| CHR(10)|| '}CNTR_CARGO' " ).append("\n"); 
		query.append("                                      FROM BKG_CNTR_MF_DESC BCM " ).append("\n"); 
		query.append("                                      WHERE BCM.BKG_NO = CNTR.BKG_NO AND BCM.CNTR_NO = CNTR.CNTR_NO) , CHR(10))||CHR(10)" ).append("\n"); 
		query.append("       END)  " ).append("\n"); 
		query.append(" || '{REMARK'	    || CHR(10) " ).append("\n"); 
		query.append("    || 'REMARK_TP:' || CHR(10) " ).append("\n"); 
		query.append("    || 'REMARK:'    || CHR(10) " ).append("\n"); 
		query.append(" || '}REMARK'       || CHR(10) " ).append("\n"); 
		query.append(" ||MAX(CASE WHEN (SELECT COUNT(*) FROM BKG_HRD_CDG_CTNT BHCC WHERE 1=1" ).append("\n"); 
		query.append("                 AND (BK.AWK_CGO_FLG = 'Y' AND BHCC.HRD_CDG_ID = 'VNDR301_INSTRUCT' AND BHCC.ATTR_CTNT1 = DG.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("                 OR (BK.BB_CGO_FLG = 'Y' AND BHCC.HRD_CDG_ID = 'VNDR301_INSTRUCT' AND BHCC.ATTR_CTNT1 = 'BK')" ).append("\n"); 
		query.append("                 OR (BHCC.HRD_CDG_ID = 'VNDR301_INSTRUCT' AND BHCC.ATTR_CTNT1 IN (SELECT BSC.STWG_CD FROM BKG_STWG_CGO BSC WHERE BSC.BKG_NO = BK.BKG_NO))) = 0" ).append("\n"); 
		query.append("            THEN '{INSTRUCT'||CHR(10)||'SPCL_CD:'||CHR(10)||'SPCL_DESC:'||CHR(10)||'}INSTRUCT'" ).append("\n"); 
		query.append("   ELSE " ).append("\n"); 
		query.append("         BKG_JOIN_FNC(CURSOR((SELECT '{INSTRUCT'||CHR(10)||'SPCL_CD:'||BHCC.ATTR_CTNT2||CHR(10)||'SPCL_DESC:'||BHCC.ATTR_CTNT3||CHR(10)||'}INSTRUCT'" ).append("\n"); 
		query.append("         FROM BKG_HRD_CDG_CTNT BHCC " ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("         AND (BK.AWK_CGO_FLG = 'Y' AND BHCC.HRD_CDG_ID = 'VNDR301_INSTRUCT' AND BHCC.ATTR_CTNT1 = DG.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("         OR (BK.BB_CGO_FLG = 'Y' AND BHCC.HRD_CDG_ID = 'VNDR301_INSTRUCT' AND BHCC.ATTR_CTNT1 = 'BK')" ).append("\n"); 
		query.append("         OR (BHCC.HRD_CDG_ID = 'VNDR301_INSTRUCT' AND BHCC.ATTR_CTNT1 IN (SELECT BSC.STWG_CD FROM BKG_STWG_CGO BSC WHERE BSC.BKG_NO = BK.BKG_NO))" ).append("\n"); 
		query.append("         )), CHR(10))" ).append("\n"); 
		query.append("   END)||CHR(10)" ).append("\n"); 
		query.append("	|| '{CNTR_TRO_DTL'															|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRD_ADDR:'																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRD_DOOR_LOC:'															|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRD_DOOR_POSTAL:'														|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRD_DOOR_DT:'															|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRD_PERSON:'															|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRD_TEL:'																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRD_FAX:'																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRD_DEPARTURE:'															|| CHR(10)" ).append("\n"); 
		query.append("	|| '}CNTR_TRO_DTL'															|| CHR(10) DG_INFO" ).append("\n"); 
		query.append("  FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("        , BKG_DG_CGO DG" ).append("\n"); 
		query.append("        , BKG_CONTAINER CNTR" ).append("\n"); 
		query.append(" WHERE BK.BKG_NO        = DG.BKG_NO" ).append("\n"); 
		query.append("   AND DG.BKG_NO        = CNTR.BKG_NO  (+) " ).append("\n"); 
		query.append("   AND DG.CNTR_NO       = CNTR.CNTR_NO (+)" ).append("\n"); 
		query.append("   AND BK.BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("   AND DG.CNTR_TPSZ_CD is not null" ).append("\n"); 
		query.append("   GROUP BY DG.BKG_NO, DG.DG_CNTR_SEQ" ).append("\n"); 
		query.append("   ORDER BY DG.BKG_NO, DG.DG_CNTR_SEQ" ).append("\n"); 

	}
}