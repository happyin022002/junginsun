/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchDblEdiCmdtHdrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.19 
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

public class BLIssuanceDBDAOsearchDblEdiCmdtHdrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BLIssuanceDBDAOsearchDblEdiCmdtInfo
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchDblEdiCmdtHdrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_des",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("meas_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hamo_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_hs_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_mf_gds_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("net_cntr_mf_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ncm_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_mf_mk_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("net_wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_mf_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("meas_qty",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOsearchDblEdiCmdtHdrRSQL").append("\n"); 
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
		query.append("SELECT '{CMDT_INFO' || CHR(10)" ).append("\n"); 
		query.append("       || 'CMDT_SEQ:' || NVL(@[cmdt_seq],'1') || CHR(10) " ).append("\n"); 
		query.append("       || 'CMDT_PKG_QTY:' || PCK_QTY || CHR(10) " ).append("\n"); 
		query.append("       || 'CMDT_PKG_CD:' || PCK_TP_CD || CHR(10) " ).append("\n"); 
		query.append("       || 'CMDT_PKG_CD_DESC:' ||PCK_DES|| CHR(10) " ).append("\n"); 
		query.append("       || 'CMDT_WGT_QTY:' ||CNTR_MF_WGT||CHR(10) " ).append("\n"); 
		query.append("       || 'CMDT_WGT_UNIT:' ||WGT_UT_CD||CHR(10) " ).append("\n"); 
		query.append("       || 'CMDT_NET_WGT_QTY:' ||NET_CNTR_MF_WGT|| CHR(10) " ).append("\n"); 
		query.append("       || 'CMDT_NET_WGT_UNIT:' ||NET_WGT_UT_CD||CHR(10) " ).append("\n"); 
		query.append("       || 'CMDT_MEA_QTY:' ||MEAS_QTY|| CHR(10) " ).append("\n"); 
		query.append("       || 'CMDT_MEA_UNIT:' ||MEAS_UT_CD||CHR(10) " ).append("\n"); 
		query.append("       || 'CMDT_HTS_CD:' ||HAMO_TRF_CD|| CHR(10) " ).append("\n"); 
		query.append("       || 'CMDT_HS_CD:' ||CMDT_HS_CD||CHR(10) " ).append("\n"); 
		query.append("       || 'CMDT_NCM_CD:' ||NCM_NO|| CHR(10) " ).append("\n"); 
		query.append("       || TO_CLOB('CMDT_DESC:' ||CNTR_MF_GDS_DESC) ||CHR(10) " ).append("\n"); 
		query.append("       || TO_CLOB('CMDT_MARKNO:' ||CNTR_MF_MK_DESC) || CHR(10) " ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    PCK_QTY," ).append("\n"); 
		query.append("    PCK_TP_CD," ).append("\n"); 
		query.append("    PCK_DES," ).append("\n"); 
		query.append("    CNTR_MF_WGT," ).append("\n"); 
		query.append("    WGT_UT_CD," ).append("\n"); 
		query.append("    NET_CNTR_MF_WGT," ).append("\n"); 
		query.append("    NET_WGT_UT_CD," ).append("\n"); 
		query.append("    MEAS_QTY," ).append("\n"); 
		query.append("    MEAS_UT_CD," ).append("\n"); 
		query.append("    HAMO_TRF_CD," ).append("\n"); 
		query.append("    CMDT_HS_CD," ).append("\n"); 
		query.append("    NCM_NO," ).append("\n"); 
		query.append("    CNTR_MF_GDS_DESC," ).append("\n"); 
		query.append("    CNTR_MF_MK_DESC" ).append("\n"); 
		query.append("FROM (    " ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("        SUM(PCK_QTY) AS PCK_QTY," ).append("\n"); 
		query.append("        PCK_TP_CD," ).append("\n"); 
		query.append("        (SELECT PCK_NM FROM MDM_PCK_TP WHERE PCK_CD = CM.PCK_TP_CD) PCK_DES," ).append("\n"); 
		query.append("        SUM(CNTR_MF_WGT) AS CNTR_MF_WGT," ).append("\n"); 
		query.append("        WGT_UT_CD WGT_UT_CD," ).append("\n"); 
		query.append("        SUM(CNTR_MF_WGT) NET_CNTR_MF_WGT," ).append("\n"); 
		query.append("        WGT_UT_CD NET_WGT_UT_CD," ).append("\n"); 
		query.append("        SUM(MEAS_QTY) AS MEAS_QTY," ).append("\n"); 
		query.append("        MEAS_UT_CD," ).append("\n"); 
		query.append("        HAMO_TRF_CD," ).append("\n"); 
		query.append("        CMDT_HS_CD," ).append("\n"); 
		query.append("        NCM_NO," ).append("\n"); 
		query.append("        REPLACE(CNTR_MF_GDS_DESC,CHR(10),' ') CNTR_MF_GDS_DESC," ).append("\n"); 
		query.append("        REPLACE(CNTR_MF_MK_DESC,CHR(10), ' ') CNTR_MF_MK_DESC" ).append("\n"); 
		query.append("        FROM BKG_CNTR_MF_DESC CM" ).append("\n"); 
		query.append("        WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("        GROUP BY PCK_TP_CD, " ).append("\n"); 
		query.append("                 WGT_UT_CD," ).append("\n"); 
		query.append("                 MEAS_UT_CD," ).append("\n"); 
		query.append("                 HAMO_TRF_CD," ).append("\n"); 
		query.append("                 CMDT_HS_CD," ).append("\n"); 
		query.append("                 NCM_NO," ).append("\n"); 
		query.append("                 CNTR_MF_GDS_DESC," ).append("\n"); 
		query.append("                 CNTR_MF_MK_DESC" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND NVL(PCK_QTY, 0) = NVL(@[pck_qty], 0)" ).append("\n"); 
		query.append("AND NVL(PCK_TP_CD, ' ') = NVL(@[pck_tp_cd], ' ')" ).append("\n"); 
		query.append("AND NVL(PCK_DES, ' ') = NVL(@[pck_des], ' ')" ).append("\n"); 
		query.append("AND NVL(CNTR_MF_WGT, 0) = NVL(@[cntr_mf_wgt], 0)" ).append("\n"); 
		query.append("AND NVL(WGT_UT_CD, ' ') = NVL(@[wgt_ut_cd], ' ')" ).append("\n"); 
		query.append("AND NVL(NET_CNTR_MF_WGT, 0) = NVL(@[net_cntr_mf_wgt], 0)" ).append("\n"); 
		query.append("AND NVL(NET_WGT_UT_CD, ' ') = NVL(@[net_wgt_ut_cd], ' ')" ).append("\n"); 
		query.append("AND NVL(MEAS_QTY, 0) = NVL(@[meas_qty], 0)" ).append("\n"); 
		query.append("AND NVL(MEAS_UT_CD, ' ') = NVL(@[meas_ut_cd], ' ')" ).append("\n"); 
		query.append("AND NVL(HAMO_TRF_CD, ' ') = NVL(@[hamo_trf_cd], ' ')" ).append("\n"); 
		query.append("AND NVL(CMDT_HS_CD, ' ') = NVL(@[cmdt_hs_cd], ' ')" ).append("\n"); 
		query.append("AND NVL(NCM_NO, ' ') = NVL(@[ncm_no], ' ')" ).append("\n"); 
		query.append("AND NVL(CNTR_MF_GDS_DESC, ' ') = NVL(@[cntr_mf_gds_desc], ' ')" ).append("\n"); 
		query.append("AND NVL(CNTR_MF_MK_DESC, ' ') = NVL(@[cntr_mf_mk_desc], ' ')" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}