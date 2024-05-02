/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchDblEdiCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.09
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOsearchDblEdiCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchDblEdiCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_receive_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_receive_id_old",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOsearchDblEdiCntrRSQL").append("\n"); 
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
		query.append("SELECT '{CNTR_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || 'CNTRNBR:' || DECODE(BC.CNTR_TPSZ_CD,'B4','',BC.CNTR_NO) || CHR(10) " ).append("\n"); 
		query.append("       || 'PUNIT:' || DECODE(BC.CNTR_TPSZ_CD,'B4','',BC.PCK_TP_CD) || CHR(10) " ).append("\n"); 
		query.append("       || 'PKG:' || DECODE(BC.CNTR_TPSZ_CD,'B4','',NVL(BC.PCK_QTY, 0)) || CHR(10) " ).append("\n"); 
		query.append("       || 'CNTRWGT:' || DECODE(BC.CNTR_TPSZ_CD,'B4','',BC.CNTR_WGT) || CHR(10) " ).append("\n"); 
		query.append("       || 'CNTR_WGT_UNIT:' || DECODE(BC.CNTR_TPSZ_CD,'B4','',BC.WGT_UT_CD) || CHR(10) " ).append("\n"); 
		query.append("       || 'CNTRTYPE:' || DECODE(BC.CNTR_TPSZ_CD,'B4','',BC.CNTR_TPSZ_CD) || CHR(10) " ).append("\n"); 
		query.append("       || 'SEALNBR:' || SEAL.SEALNBR || CHR(10) " ).append("\n"); 
		query.append("       || 'SEALNBR2:' || CASE" ).append("\n"); 
		query.append("                          WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'SECXML' OR SUBSTR(@[edi_receive_id], 1, 5) = 'FSELC' OR" ).append("\n"); 
		query.append("                               SUBSTR(@[edi_receive_id_old], 1, 5) = 'C1T0W' OR SUBSTR(@[edi_receive_id_old], 1, 5) = 'C1T0S' OR" ).append("\n"); 
		query.append("                               SUBSTR(@[edi_receive_id_old], 1, 5) = 'C1T0M' OR SUBSTR(@[edi_receive_id_old], 1, 5) = '110AL' THEN" ).append("\n"); 
		query.append("                            SEAL.SEALNBR2" ).append("\n"); 
		query.append("                          ELSE" ).append("\n"); 
		query.append("                            ''" ).append("\n"); 
		query.append("                         END || CHR(10)" ).append("\n"); 
		query.append("       || 'SEALNBR3:' || CASE" ).append("\n"); 
		query.append("                          WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'SECXML' OR SUBSTR(@[edi_receive_id], 1, 5) = 'FSELC' OR" ).append("\n"); 
		query.append("                               SUBSTR(@[edi_receive_id_old], 1, 5) = 'C1T0W' OR SUBSTR(@[edi_receive_id_old], 1, 5) = 'C1T0S' OR" ).append("\n"); 
		query.append("                               SUBSTR(@[edi_receive_id_old], 1, 5) = 'C1T0M' OR SUBSTR(@[edi_receive_id_old], 1, 5) = '110AL' THEN" ).append("\n"); 
		query.append("                            SEAL.SEALNBR3" ).append("\n"); 
		query.append("                          ELSE" ).append("\n"); 
		query.append("                            ''" ).append("\n"); 
		query.append("                         END || CHR(10)" ).append("\n"); 
		query.append("       || 'FM_IND:' || CHR(10) " ).append("\n"); 
		query.append("       || 'RF_IND:' || DECODE(BC.RC_FLG, 'Y', '1', '0') || CHR(10) " ).append("\n"); 
		query.append("       || 'DG_IND:' || DECODE(BC.DCGO_FLG, 'Y', '1', '0') || CHR(10) " ).append("\n"); 
		query.append("       || 'AK_IND:' || DECODE(BC.AWK_CGO_FLG, 'Y', '1', '0') || CHR(10) " ).append("\n"); 
		query.append("       || 'BK_IND:' || DECODE(BC.BB_CGO_FLG, 'Y', '1', '0') || CHR(10) " ).append("\n"); 
		query.append("       || 'SOC_IND:' || DECODE(BC.SOC_FLG, 'Y', '1', '0') || CHR(10)" ).append("\n"); 
		query.append("       || 'TEMP:' || RF.CDO_TEMP || CHR(10) " ).append("\n"); 
		query.append("       || 'TUNIT:C' || CHR(10) " ).append("\n"); 
		query.append("       || 'VENT:' || CASE " ).append("\n"); 
		query.append("                         WHEN RF.VENT_RTO = 0 THEN 'C'" ).append("\n"); 
		query.append("                         WHEN RF.VENT_RTO > 0 AND RF.VENT_RTO <= 34 THEN 'Q'" ).append("\n"); 
		query.append("                         WHEN RF.VENT_RTO > 34 AND RF.VENT_RTO <= 64 THEN 'H'" ).append("\n"); 
		query.append("                         WHEN RF.VENT_RTO > 65 AND RF.VENT_RTO <= 99 THEN 'T'" ).append("\n"); 
		query.append("                         WHEN RF.VENT_RTO = 100 THEN 'O'" ).append("\n"); 
		query.append("                     END || CHR(10) " ).append("\n"); 
		query.append("       || 'HUMID:' || RF.HUMID_NO || CHR(10) " ).append("\n"); 
		query.append("       || 'MEASURE:' || BC.MEAS_QTY || CHR(10) " ).append("\n"); 
		query.append("       || 'MEASURE_UNIT:' || BC.MEAS_UT_CD || CHR(10) " ).append("\n"); 
		query.append("       || 'CN_RDTYPE:' || BC.RCV_TERM_CD || BC.DE_TERM_CD || CHR(10) " ).append("\n"); 
		query.append("       || 'CMDT_DESC:' || CHR(10) " ).append("\n"); 
		query.append("       || 'CMDTCD:' || CHR(10) " ).append("\n"); 
		query.append("       || 'RF_REMARK:' || REPLACE(RF.DIFF_RMK, CHR(10), ' ') || CHR(10) " ).append("\n"); 
		query.append("       || 'RFDRY_IND:' || DECODE(BC.RD_CGO_FLG, 'Y', '1', '0') || CHR(10) " ).append("\n"); 
		query.append("       || 'OVF:' || AK.OVR_FWRD_LEN || CHR(10) " ).append("\n"); 
		query.append("       || 'OVR:' || AK.OVR_BKWD_LEN || CHR(10) " ).append("\n"); 
		query.append("       || 'OVH:' || AK.OVR_HGT || CHR(10) " ).append("\n"); 
		query.append("       || 'OVLW:' || AK.OVR_LF_LEN || CHR(10) " ).append("\n"); 
		query.append("       || 'OVRW:' || AK.OVR_RT_LEN || CHR(10) " ).append("\n"); 
		query.append("       || 'OVWGT:' || AK.GRS_WGT || CHR(10) " ).append("\n"); 
		query.append("       || 'OVWGT_UNIT:' || AK.WGT_UT_CD || CHR(10) " ).append("\n"); 
		query.append("       || 'VOID_SLOT:' || AK.OVR_VOID_SLT_QTY || CHR(10) " ).append("\n"); 
		query.append("       || 'STWG_REQ:' || AK.STWG_RQST_DESC || CHR(10) " ).append("\n"); 
		query.append("       || 'PARTIAL:' || DECODE(BC.CNTR_PRT_FLG, 'Y', '1', '0') || CHR(10) " ).append("\n"); 
		query.append("       || 'EXCEPT:' || BC.ADV_SHTG_CD || CHR(10) " ).append("\n"); 
		query.append("       || 'SHIP_UNNO:' || IBC.SHP_REF_NO || CHR(10) " ).append("\n"); 
		query.append("	   || 'CARGO_TP_IND:' || CASE WHEN INSTR(BC.RCV_TERM_CD||BC.DE_TERM_CD,'S') > 0 THEN 'L' ELSE 'F' END || CHR(10) AS BKG_CNTR" ).append("\n"); 
		query.append(",      BC.CNTR_NO" ).append("\n"); 
		query.append("FROM   BKG_CONTAINER BC" ).append("\n"); 
		query.append("      ,BKG_RF_CGO RF" ).append("\n"); 
		query.append("      ,BKG_AWK_CGO AK" ).append("\n"); 
		query.append("	  ,(SELECT B.BKG_NO" ).append("\n"); 
		query.append("    	      ,IBC.SHP_REF_NO " ).append("\n"); 
		query.append("        	  ,IBC.CNTR_NO" ).append("\n"); 
		query.append("          FROM BKG_BOOKING B" ).append("\n"); 
		query.append("              ,BKG_XTER_CNTR IBC" ).append("\n"); 
		query.append("         WHERE B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("           AND B.XTER_SI_REF_NO = IBC.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("           AND IBC.XTER_RQST_NO(+) = @[ib_no]" ).append("\n"); 
		query.append("           AND IBC.XTER_RQST_SEQ(+) = @[ib_seq]" ).append("\n"); 
		query.append("           AND IBC.XTER_SNDR_ID(+) = @[edi_receive_id]" ).append("\n"); 
		query.append("       ) IBC" ).append("\n"); 
		query.append("      ,(SELECT BKG_NO" ).append("\n"); 
		query.append("              ,CNTR_NO" ).append("\n"); 
		query.append("              ,MAX(DECODE(RN, 1, CNTR_SEAL_NO)) AS SEALNBR" ).append("\n"); 
		query.append("              ,MAX(DECODE(RN, 2, CNTR_SEAL_NO)) AS SEALNBR2" ).append("\n"); 
		query.append("              ,MAX(DECODE(RN, 3, CNTR_SEAL_NO)) AS SEALNBR3" ).append("\n"); 
		query.append("          FROM (SELECT BKG_NO" ).append("\n"); 
		query.append("                      ,CNTR_NO" ).append("\n"); 
		query.append("                      ,ROW_NUMBER() OVER (PARTITION BY BKG_NO ,CNTR_NO ORDER BY CNTR_SEAL_SEQ) AS RN" ).append("\n"); 
		query.append("                      ,CNTR_SEAL_NO" ).append("\n"); 
		query.append("                  FROM BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("                 WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("         GROUP BY BKG_NO" ).append("\n"); 
		query.append("              ,CNTR_NO) SEAL" ).append("\n"); 
		query.append(" WHERE BC.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND BC.BKG_NO = IBC.BKG_NO (+)" ).append("\n"); 
		query.append("   AND BC.CNTR_NO = IBC.CNTR_NO (+)" ).append("\n"); 
		query.append("   AND BC.BKG_NO = RF.BKG_NO(+)" ).append("\n"); 
		query.append("   AND BC.CNTR_NO = RF.CNTR_NO(+)" ).append("\n"); 
		query.append("   AND BC.BKG_NO = AK.BKG_NO(+)" ).append("\n"); 
		query.append("   AND BC.CNTR_NO = AK.CNTR_NO(+)" ).append("\n"); 
		query.append("   AND BC.BKG_NO = SEAL.BKG_NO (+)" ).append("\n"); 
		query.append("   AND BC.CNTR_NO = SEAL.CNTR_NO (+)" ).append("\n"); 
		query.append(" ORDER BY BC.CNTR_NO" ).append("\n"); 

	}
}