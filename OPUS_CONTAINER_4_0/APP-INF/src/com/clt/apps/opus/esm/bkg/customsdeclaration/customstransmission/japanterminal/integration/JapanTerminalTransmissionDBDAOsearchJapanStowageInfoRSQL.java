/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : JapanTerminalTransmissionDBDAOsearchJapanStowageInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanTerminalTransmissionDBDAOsearchJapanStowageInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * flat file Stowage 정보를 가져온다.
	  * </pre>
	  */
	public JapanTerminalTransmissionDBDAOsearchJapanStowageInfoRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration").append("\n"); 
		query.append("FileName : JapanTerminalTransmissionDBDAOsearchJapanStowageInfoRSQL").append("\n"); 
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
		query.append("--PKUP_NAME - 공란" ).append("\n"); 
		query.append("--STWG_REQ" ).append("\n"); 
		query.append("--STWG_REMARK" ).append("\n"); 
		query.append("--BLKSTWG" ).append("\n"); 
		query.append("--RD_IND" ).append("\n"); 
		query.append("--MT_IND" ).append("\n"); 
		query.append("--SOC_IND" ).append("\n"); 
		query.append("--RF_RRE" ).append("\n"); 
		query.append("--RF_REMARK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT JB.SNACCS_TML_EDI_STWG_CD AS STWG_REQ," ).append("\n"); 
		query.append("       UPPER(JB.XTER_RMK) AS STWG_REMARK," ).append("\n"); 
		query.append("       --BLCK_STWG_CD AS BLKSTWG," ).append("\n"); 
		query.append("       CASE" ).append("\n"); 
		query.append("          WHEN C.CRR_CD = COM_ConstantMgr_PKG.COM_getCompanyCode_FNC() THEN" ).append("\n"); 
		query.append("             JB.BLCK_STWG_CD" ).append("\n"); 
		query.append("          ELSE (SELECT ATTR_CTNT3 --SJA block Stowage Code" ).append("\n"); 
		query.append("                   FROM BKG_VVD V," ).append("\n"); 
		query.append("                        VSK_VSL_SKD VS," ).append("\n"); 
		query.append("                        BKG_HRD_CDG_CTNT H," ).append("\n"); 
		query.append("                        BKG_BOOKING B" ).append("\n"); 
		query.append("                  WHERE V.BKG_NO = JB.BKG_NO" ).append("\n"); 
		query.append("                    AND VS.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("                    AND VS.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                    AND VS.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("                    AND H.HRD_CDG_ID = 'JP_TML_EDI_SJA_BS_CD'" ).append("\n"); 
		query.append("                    AND H.ATTR_CTNT1 = VS.ACT_CRR_CD" ).append("\n"); 
		query.append("                    AND H.ATTR_CTNT2 = DECODE(VS.ACT_CRR_CD, COM_ConstantMgr_PKG.COM_getCompanyCode_FNC(), 'ALL', VS.VSL_SLAN_CD)" ).append("\n"); 
		query.append("                    AND B.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("                    AND ((SUBSTR(B.BKG_NO, 1, 2) IN ('US', 'CA', 'MX') AND H.ATTR_CTNT4 = B.POD_CD) OR" ).append("\n"); 
		query.append("                         (VS.VSL_SLAN_CD = 'KPS' AND H.ATTR_CTNT2 = VS.VSL_SLAN_CD AND H.ATTR_CTNT4 = 'ALL'))" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("       END AS BLKSTWG," ).append("\n"); 
		query.append("       --JB.DRY_CGO_FLG AS RD_IND," ).append("\n"); 
		query.append("       (SELECT CASE" ).append("\n"); 
		query.append("                  WHEN SUBSTR(CNTR_TPSZ_CD, 1, 1) = 'R' AND (SUBSTR(EQ_SUBST_CNTR_TPSZ_CD, 1, 1) <> 'D' OR OP_CNTR_QTY <> EQ_SUBST_CGO_QTY) THEN" ).append("\n"); 
		query.append("                     '1'" ).append("\n"); 
		query.append("                  WHEN SUBSTR(CNTR_TPSZ_CD, 1, 1) = 'R' AND SUBSTR(EQ_SUBST_CNTR_TPSZ_CD, 1, 1)  = 'D' THEN" ).append("\n"); 
		query.append("                     '0'" ).append("\n"); 
		query.append("                  ELSE" ).append("\n"); 
		query.append("                     ''" ).append("\n"); 
		query.append("                  END" ).append("\n"); 
		query.append("          FROM BKG_QUANTITY" ).append("\n"); 
		query.append("         WHERE BKG_NO = JB.BKG_NO" ).append("\n"); 
		query.append("           AND CNTR_TPSZ_CD = @[cntr_tpsz_cd]) AS RD_IND," ).append("\n"); 
		query.append("       JB.MCNTR_FLG AS MT_IND," ).append("\n"); 
		query.append("       JB.SOC_FLG AS SOC_IND," ).append("\n"); 
		query.append("       JB.RF_CNTR_PRE_CLNG_FLG AS RF_RRE," ).append("\n"); 
		query.append("      (SELECT REPLACE(REPLACE(BKG_SPCLCHAR_CONV_FNC(NVL(RF.DIFF_RMK, ' '), 'J'), CHR(13), ''), CHR(10), '')" ).append("\n"); 
		query.append("         FROM BKG_RF_CGO RF" ).append("\n"); 
		query.append("        WHERE RF.BKG_NO = JB.BKG_NO" ).append("\n"); 
		query.append("          AND UPPER(RF.DIFF_RMK) LIKE '%PRE%'" ).append("\n"); 
		query.append("          AND ROWNUM = 1) AS RF_REMARK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_TML_EDI_JP_BL JB," ).append("\n"); 
		query.append("       MDM_VSL_CNTR C" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE JB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND JB.BKG_SKD_SEQ = 0" ).append("\n"); 
		query.append("   AND C.VSL_CD = JB.VSL_CD" ).append("\n"); 

	}
}