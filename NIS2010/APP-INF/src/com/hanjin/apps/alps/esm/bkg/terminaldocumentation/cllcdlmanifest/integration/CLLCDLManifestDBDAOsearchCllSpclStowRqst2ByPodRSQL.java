/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchCllSpclStowRqst2ByPodRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.27
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchCllSpclStowRqst2ByPodRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCllSpclStowRqst2ByPod
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchCllSpclStowRqst2ByPodRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchCllSpclStowRqst2ByPodRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${in_pgm_no} == 'ESM_BKG_0951') " ).append("\n"); 
		query.append("/**************************** ESM_BKG_0951에서 조회된 경우  *****************************/" ).append("\n"); 
		query.append("SELECT GUBUN_CD3," ).append("\n"); 
		query.append("  '' GUBUN_CD2," ).append("\n"); 
		query.append("  '' GUBUN_CD," ).append("\n"); 
		query.append("  BLCK_STWG_CD," ).append("\n"); 
		query.append("  DECODE(SUM(ODAL_20), 0, '', SUM(ODAL_20)) ODAL_20," ).append("\n"); 
		query.append("  DECODE(SUM(ODAL_40), 0, '', SUM(ODAL_40)) ODAL_40," ).append("\n"); 
		query.append("  DECODE(SUM(ODAL_40H), 0, '', SUM(ODAL_40H)) ODAL_40H," ).append("\n"); 
		query.append("  DECODE(SUM(ODAL_45), 0, '', SUM(ODAL_45)) ODAL_45," ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  DECODE(SUM(ODBC_20), 0, '', SUM(ODBC_20)) ODBC_20," ).append("\n"); 
		query.append("  DECODE(SUM(ODBC_40), 0, '', SUM(ODBC_40)) ODBC_40," ).append("\n"); 
		query.append("  DECODE(SUM(ODBC_40H), 0, '', SUM(ODBC_40H)) ODBC_40H," ).append("\n"); 
		query.append("  DECODE(SUM(ODBC_45), 0, '', SUM(ODBC_45)) ODBC_45," ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  DECODE(SUM(ODET_20), 0, '', SUM(ODET_20)) ODET_20," ).append("\n"); 
		query.append("  DECODE(SUM(ODET_40), 0, '', SUM(ODET_40)) ODET_40," ).append("\n"); 
		query.append("  DECODE(SUM(ODET_40H), 0, '', SUM(ODET_40H)) ODET_40H," ).append("\n"); 
		query.append("  DECODE(SUM(ODET_45), 0, '', SUM(ODET_45)) ODET_45," ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  DECODE(SUM(ODFT_20), 0, '', SUM(ODFT_20)) ODFT_20," ).append("\n"); 
		query.append("  DECODE(SUM(ODFT_40), 0, '', SUM(ODFT_40)) ODFT_40," ).append("\n"); 
		query.append("  DECODE(SUM(ODFT_40H), 0, '', SUM(ODFT_40H)) ODFT_40H," ).append("\n"); 
		query.append("  DECODE(SUM(ODFT_45), 0, '', SUM(ODFT_45)) ODFT_45," ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  DECODE(SUM(ODHD_20), 0, '', SUM(ODHD_20)) ODHD_20," ).append("\n"); 
		query.append("  DECODE(SUM(ODHD_40), 0, '', SUM(ODHD_40)) ODHD_40," ).append("\n"); 
		query.append("  DECODE(SUM(ODHD_45), 0, '', SUM(ODHD_45)) ODHD_45," ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  DECODE(SUM(ODHD_40H), 0, '', SUM(ODHD_40H)) ODHD_40H," ).append("\n"); 
		query.append("  DECODE(SUM(OP_20), 0, '', SUM(OP_20)) OP_20," ).append("\n"); 
		query.append("  DECODE(SUM(OP_40), 0, '', SUM(OP_40)) OP_40," ).append("\n"); 
		query.append("  DECODE(SUM(OP_40H), 0, '', SUM(OP_40H)) OP_40H," ).append("\n"); 
		query.append("  DECODE(SUM(OP_45), 0, '', SUM(OP_45)) OP_45," ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  DECODE(SUM(OT_20), 0, '', SUM(OT_20)) OT_20," ).append("\n"); 
		query.append("  DECODE(SUM(OT_40), 0, '', SUM(OT_40)) OT_40," ).append("\n"); 
		query.append("  DECODE(SUM(OT_40H), 0, '', SUM(OT_40H)) OT_40H," ).append("\n"); 
		query.append("  DECODE(SUM(OT_45), 0, '', SUM(OT_45)) OT_45," ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  DECODE(SUM(OTNO_20), 0, '', SUM(OTNO_20)) OTNO_20," ).append("\n"); 
		query.append("  DECODE(SUM(OTNO_40), 0, '', SUM(OTNO_40)) OTNO_40," ).append("\n"); 
		query.append("  DECODE(SUM(OTNO_40H), 0, '', SUM(OTNO_40H)) OTNO_40H," ).append("\n"); 
		query.append("  DECODE(SUM(OTNO_45), 0, '', SUM(OTNO_45)) OTNO_45," ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  DECODE(SUM(PC_20), 0, '', SUM(PC_20)) PC_20," ).append("\n"); 
		query.append("  DECODE(SUM(PC_40), 0, '', SUM(PC_40)) PC_40," ).append("\n"); 
		query.append("  DECODE(SUM(PC_40H), 0, '', SUM(PC_40H)) PC_40H," ).append("\n"); 
		query.append("  DECODE(SUM(PC_45), 0, '', SUM(PC_45)) PC_45" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT NVL(LO.UN_LOC_CD,BV.POD_CD) GUBUN_CD3," ).append("\n"); 
		query.append("	  BK.BLCK_STWG_CD AS BLCK_STWG_CD," ).append("\n"); 
		query.append("      DECODE(DECODE(BK.STWG_CD,'ODAL',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'ODAL',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)) ODAL_20," ).append("\n"); 
		query.append("	  DECODE(DECODE(BK.STWG_CD,'ODAL',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'ODAL',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0)) ODAL_40," ).append("\n"); 
		query.append("	  DECODE(DECODE(BK.STWG_CD,'ODAL',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0),0,'',DECODE(BK.STWG_CD,'ODAL',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0)) ODAL_40H," ).append("\n"); 
		query.append("      DECODE(DECODE(BK.STWG_CD,'ODAL',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'ODAL',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0)) ODAL_45," ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      DECODE(DECODE(BK.STWG_CD,'ODBC',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'ODBC',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)) ODBC_20," ).append("\n"); 
		query.append("      DECODE(DECODE(BK.STWG_CD,'ODBC',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'ODBC',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0)) ODBC_40," ).append("\n"); 
		query.append("      DECODE(DECODE(BK.STWG_CD,'ODBC',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0),0,'',DECODE(BK.STWG_CD,'ODBC',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  '7', 0, BQ.OP_CNTR_QTY),0)) ODBC_40H," ).append("\n"); 
		query.append("      DECODE(DECODE(BK.STWG_CD,'ODBC',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'ODBC',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0)) ODBC_45," ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      DECODE(DECODE(BK.STWG_CD,'ODET',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'ODET',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)) ODET_20," ).append("\n"); 
		query.append("      DECODE(DECODE(BK.STWG_CD,'ODET',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'ODET',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0)) ODET_40," ).append("\n"); 
		query.append("      DECODE(DECODE(BK.STWG_CD,'ODET',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0),0,'',DECODE(BK.STWG_CD,'ODET',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0)) ODET_40H," ).append("\n"); 
		query.append("      DECODE(DECODE(BK.STWG_CD,'ODET',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'ODET',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0)) ODET_45," ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      DECODE(DECODE(BK.STWG_CD,'ODFT',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'ODFT',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)) ODFT_20," ).append("\n"); 
		query.append("      DECODE(DECODE(BK.STWG_CD,'ODFT',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'ODFT',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0)) ODFT_40," ).append("\n"); 
		query.append("      DECODE(DECODE(BK.STWG_CD,'ODFT',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0),0,'',DECODE(BK.STWG_CD,'ODFT',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0)) ODFT_40H," ).append("\n"); 
		query.append("      DECODE(DECODE(BK.STWG_CD,'ODFT',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'ODFT',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0)) ODFT_45," ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      DECODE(DECODE(BK.STWG_CD,'ODHD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'ODHD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)) ODHD_20," ).append("\n"); 
		query.append("      DECODE(DECODE(BK.STWG_CD,'ODHD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'ODHD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0)) ODHD_40," ).append("\n"); 
		query.append("      DECODE(DECODE(BK.STWG_CD,'ODHD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  '7', 0, BQ.OP_CNTR_QTY),0),0,'',DECODE(BK.STWG_CD,'ODHD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0)) ODHD_40H," ).append("\n"); 
		query.append("      DECODE(DECODE(BK.STWG_CD,'ODHD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'ODHD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0)) ODHD_45," ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      DECODE(DECODE(BK.STWG_CD,'OP',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'OP',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)) OP_20," ).append("\n"); 
		query.append("      DECODE(DECODE(BK.STWG_CD,'OP',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'OP',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0)) OP_40," ).append("\n"); 
		query.append("      DECODE(DECODE(BK.STWG_CD,'OP',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0),0,'',DECODE(BK.STWG_CD,'OP',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0)) OP_40H," ).append("\n"); 
		query.append("      DECODE(DECODE(BK.STWG_CD,'OP',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'OP',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0)) OP_45," ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      DECODE(DECODE(BK.STWG_CD,'OT',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'OT',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)) OT_20," ).append("\n"); 
		query.append("      DECODE(DECODE(BK.STWG_CD,'OT',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'OT',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0)) OT_40," ).append("\n"); 
		query.append("      DECODE(DECODE(BK.STWG_CD,'OT',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  '7', 0, BQ.OP_CNTR_QTY),0),0,'',DECODE(BK.STWG_CD,'OT',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  '7', 0, BQ.OP_CNTR_QTY),0)) OT_40H," ).append("\n"); 
		query.append("      DECODE(DECODE(BK.STWG_CD,'OT',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'OT',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0)) OT_45," ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      DECODE(DECODE(BK.STWG_CD,'OTNO',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'OTNO',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)) OTNO_20," ).append("\n"); 
		query.append("      DECODE(DECODE(BK.STWG_CD,'OTNO',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'OTNO',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0)) OTNO_40," ).append("\n"); 
		query.append("      DECODE(DECODE(BK.STWG_CD,'OTNO',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  '7', 0, BQ.OP_CNTR_QTY),0),0,'',DECODE(BK.STWG_CD,'OTNO',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  '7', 0, BQ.OP_CNTR_QTY),0)) OTNO_40H," ).append("\n"); 
		query.append("      DECODE(DECODE(BK.STWG_CD,'OTNO',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'OTNO',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0)) OTNO_45," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      CASE WHEN BK.PRCT_FLG = 'Y'-- BK.STWG_CD IS NOT NULL AND BK.STWG_CD = 'PC'" ).append("\n"); 
		query.append("                THEN DECODE(DECODE(BK.PRCT_FLG,'Y',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.PRCT_FLG,'Y',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0), 0))" ).append("\n"); 
		query.append("           WHEN BK.STWG_CD IS NULL" ).append("\n"); 
		query.append("                THEN DECODE(DECODE(CM.REP_IMDG_LVL_CD,'P',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(CM.REP_IMDG_LVL_CD,'P',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0))" ).append("\n"); 
		query.append("      END PC_20," ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      CASE WHEN BK.PRCT_FLG = 'Y' -- BK.STWG_CD IS NOT NULL AND BK.STWG_CD = 'PC'" ).append("\n"); 
		query.append("                THEN DECODE(DECODE(BK.PRCT_FLG,'Y',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.PRCT_FLG,'Y',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0))" ).append("\n"); 
		query.append("           WHEN BK.STWG_CD IS NULL" ).append("\n"); 
		query.append("                THEN DECODE(DECODE(CM.REP_IMDG_LVL_CD,'P',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(CM.REP_IMDG_LVL_CD,'P',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0))" ).append("\n"); 
		query.append("      END PC_40," ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      CASE WHEN BK.PRCT_FLG = 'Y' -- BK.STWG_CD IS NOT NULL AND BK.STWG_CD = 'PC'" ).append("\n"); 
		query.append("                THEN DECODE(DECODE(BK.PRCT_FLG,'Y',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  '7', 0, BQ.OP_CNTR_QTY),0),0,'',DECODE(BK.PRCT_FLG,'Y',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  '7', 0, BQ.OP_CNTR_QTY),0))" ).append("\n"); 
		query.append("           WHEN BK.STWG_CD IS NULL" ).append("\n"); 
		query.append("                THEN DECODE(DECODE(CM.REP_IMDG_LVL_CD,'P',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  '7', 0, BQ.OP_CNTR_QTY),0),0,'',DECODE(CM.REP_IMDG_LVL_CD,'P',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  '7', 0, BQ.OP_CNTR_QTY),0))" ).append("\n"); 
		query.append("      END PC_40H," ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("      CASE WHEN BK.PRCT_FLG = 'Y' --BK.STWG_CD IS NOT NULL AND BK.STWG_CD = 'PC'" ).append("\n"); 
		query.append("           THEN DECODE(DECODE(BK.PRCT_FLG,'Y',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.PRCT_FLG,'Y',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0))" ).append("\n"); 
		query.append("      WHEN BK.STWG_CD IS NULL" ).append("\n"); 
		query.append("           THEN DECODE(DECODE(CM.REP_IMDG_LVL_CD,'P',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(CM.REP_IMDG_LVL_CD,'P',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0))" ).append("\n"); 
		query.append("      END PC_45," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      VPS.CLPT_SEQ CLPT_SEQ" ).append("\n"); 
		query.append("    FROM BKG_BOOKING BK, BKG_VVD BV, VSK_VSL_PORT_SKD VPS, MDM_LOCATION LO, BKG_QUANTITY BQ, MDM_COMMODITY CM" ).append("\n"); 
		query.append("    WHERE BK.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("      AND BK.BKG_NO = BQ.BKG_NO" ).append("\n"); 
		query.append("      AND BQ.CNTR_TPSZ_CD NOT IN ('Q2','Q4')" ).append("\n"); 
		query.append("      AND BV.VSL_CD = VPS.VSL_CD" ).append("\n"); 
		query.append("      AND BV.SKD_VOY_NO = VPS.SKD_VOY_NO" ).append("\n"); 
		query.append("      AND BV.SKD_DIR_CD = VPS.SKD_DIR_CD" ).append("\n"); 
		query.append("      AND BV.POD_CD = VPS.VPS_PORT_CD" ).append("\n"); 
		query.append("      AND BK.CMDT_CD = CM.CMDT_CD" ).append("\n"); 
		query.append("      AND VPS.VPS_PORT_CD = LO.LOC_CD" ).append("\n"); 
		query.append("      AND NVL(CM.DELT_FLG,'N')='N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	  AND BV.VSL_CD     = NVL(@[in_vsl_cd], SUBSTR(@[in_vvd_cd], 1, 4))" ).append("\n"); 
		query.append("	  AND BV.SKD_VOY_NO = NVL(@[in_skd_voy_no], SUBSTR(@[in_vvd_cd], 5, 4))" ).append("\n"); 
		query.append("	  AND BV.SKD_DIR_CD = NVL(@[in_skd_dir_cd], SUBSTR(@[in_vvd_cd], 9, 1))" ).append("\n"); 
		query.append("      AND BV.POL_CD     = @[in_pol_cd]" ).append("\n"); 
		query.append("      AND SUBSTR(BV.POL_YD_CD, 6, 2) like @[in_pol_yd_cd]||'%'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      AND BK.BKG_STS_CD IN ( 'F','W')" ).append("\n"); 
		query.append("      AND VPS.CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("      AND NVL(BK.SPLIT_RSN_CD,' ') <> 'M' )" ).append("\n"); 
		query.append("GROUP BY GUBUN_CD3,BLCK_STWG_CD, CLPT_SEQ" ).append("\n"); 
		query.append("ORDER BY CLPT_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("/***************************** 기본 조회 *****************************/" ).append("\n"); 
		query.append("   SELECT GUBUN_CD3," ).append("\n"); 
		query.append("          '' GUBUN_CD2," ).append("\n"); 
		query.append("          '' GUBUN_CD," ).append("\n"); 
		query.append("          BLCK_STWG_CD," ).append("\n"); 
		query.append("          DECODE(SUM(ODAL_20), 0, '', SUM(ODAL_20)) ODAL_20," ).append("\n"); 
		query.append("          DECODE(SUM(ODAL_40), 0, '', SUM(ODAL_40)) ODAL_40," ).append("\n"); 
		query.append("          DECODE(SUM(ODAL_40H), 0, '', SUM(ODAL_40H)) ODAL_40H," ).append("\n"); 
		query.append("          DECODE(SUM(ODAL_45), 0, '', SUM(ODAL_45)) ODAL_45," ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          DECODE(SUM(ODBC_20), 0, '', SUM(ODBC_20)) ODBC_20," ).append("\n"); 
		query.append("          DECODE(SUM(ODBC_40), 0, '', SUM(ODBC_40)) ODBC_40," ).append("\n"); 
		query.append("          DECODE(SUM(ODBC_40H), 0, '', SUM(ODBC_40H)) ODBC_40H," ).append("\n"); 
		query.append("          DECODE(SUM(ODBC_45), 0, '', SUM(ODBC_45)) ODBC_45," ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          DECODE(SUM(ODET_20), 0, '', SUM(ODET_20)) ODET_20," ).append("\n"); 
		query.append("          DECODE(SUM(ODET_40), 0, '', SUM(ODET_40)) ODET_40," ).append("\n"); 
		query.append("          DECODE(SUM(ODET_40H), 0, '', SUM(ODET_40H)) ODET_40H," ).append("\n"); 
		query.append("          DECODE(SUM(ODET_45), 0, '', SUM(ODET_45)) ODET_45," ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          DECODE(SUM(ODFT_20), 0, '', SUM(ODFT_20)) ODFT_20," ).append("\n"); 
		query.append("          DECODE(SUM(ODFT_40), 0, '', SUM(ODFT_40)) ODFT_40," ).append("\n"); 
		query.append("          DECODE(SUM(ODFT_40H), 0, '', SUM(ODFT_40H)) ODFT_40H," ).append("\n"); 
		query.append("          DECODE(SUM(ODFT_45), 0, '', SUM(ODFT_45)) ODFT_45," ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          DECODE(SUM(ODHD_20), 0, '', SUM(ODHD_20)) ODHD_20," ).append("\n"); 
		query.append("          DECODE(SUM(ODHD_40), 0, '', SUM(ODHD_40)) ODHD_40," ).append("\n"); 
		query.append("          DECODE(SUM(ODHD_45), 0, '', SUM(ODHD_45)) ODHD_45," ).append("\n"); 
		query.append("          DECODE(SUM(ODHD_40H), 0, '', SUM(ODHD_40H)) ODHD_40H," ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          DECODE(SUM(OP_20), 0, '', SUM(OP_20)) OP_20," ).append("\n"); 
		query.append("          DECODE(SUM(OP_40), 0, '', SUM(OP_40)) OP_40," ).append("\n"); 
		query.append("          DECODE(SUM(OP_40H), 0, '', SUM(OP_40H)) OP_40H," ).append("\n"); 
		query.append("          DECODE(SUM(OP_45), 0, '', SUM(OP_45)) OP_45," ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          DECODE(SUM(OT_20), 0, '', SUM(OT_20)) OT_20," ).append("\n"); 
		query.append("          DECODE(SUM(OT_40), 0, '', SUM(OT_40)) OT_40," ).append("\n"); 
		query.append("          DECODE(SUM(OT_40H), 0, '', SUM(OT_40H)) OT_40H," ).append("\n"); 
		query.append("          DECODE(SUM(OT_45), 0, '', SUM(OT_45)) OT_45," ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          DECODE(SUM(OTNO_20), 0, '', SUM(OTNO_20)) OTNO_20," ).append("\n"); 
		query.append("          DECODE(SUM(OTNO_40), 0, '', SUM(OTNO_40)) OTNO_40," ).append("\n"); 
		query.append("          DECODE(SUM(OTNO_40H), 0, '', SUM(OTNO_40H)) OTNO_40H," ).append("\n"); 
		query.append("          DECODE(SUM(OTNO_45), 0, '', SUM(OTNO_45)) OTNO_45," ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          DECODE(SUM(PC_20), 0, '', SUM(PC_20)) PC_20," ).append("\n"); 
		query.append("          DECODE(SUM(PC_40), 0, '', SUM(PC_40)) PC_40," ).append("\n"); 
		query.append("          DECODE(SUM(PC_40H), 0, '', SUM(PC_40H)) PC_40H," ).append("\n"); 
		query.append("          DECODE(SUM(PC_45), 0, '', SUM(PC_45)) PC_45" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		FROM (" ).append("\n"); 
		query.append("				SELECT NVL(LO.UN_LOC_CD, BV.POD_CD) GUBUN_CD3," ).append("\n"); 
		query.append("					BK.BLCK_STWG_CD AS BLCK_STWG_CD," ).append("\n"); 
		query.append("   					DECODE(CLL.STWG_CD, 'ODAL', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 1, 0), 0) ODAL_20," ).append("\n"); 
		query.append("                    DECODE(CLL.STWG_CD, 'ODAL', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '4', 1, 0), 0) ODAL_40," ).append("\n"); 
		query.append("                    DECODE(CLL.STWG_CD, 'ODAL', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '4', 0, '7', 0, 1), 0) ODAL_40H," ).append("\n"); 
		query.append("                    DECODE(CLL.STWG_CD, 'ODAL', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', 1, 0), 0) ODAL_45," ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("					DECODE(CLL.STWG_CD, 'ODBC', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 1, 0), 0) ODBC_20," ).append("\n"); 
		query.append("					DECODE(CLL.STWG_CD, 'ODBC', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '4', 1, 0), 0) ODBC_40," ).append("\n"); 
		query.append("					DECODE(CLL.STWG_CD, 'ODBC', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '4', 0, '7', 0, 1), 0) ODBC_40H," ).append("\n"); 
		query.append("                    DECODE(CLL.STWG_CD, 'ODBC', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', 1, 0), 0) ODBC_45," ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("					DECODE(CLL.STWG_CD, 'ODET', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 1, 0), 0) ODET_20," ).append("\n"); 
		query.append("					DECODE(CLL.STWG_CD, 'ODET', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '4', 1, 0), 0) ODET_40," ).append("\n"); 
		query.append("					DECODE(CLL.STWG_CD, 'ODET', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '4', 0,  '7', 0, 1), 0) ODET_40H," ).append("\n"); 
		query.append("                    DECODE(CLL.STWG_CD, 'ODET', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', 1, 0), 0) ODET_45," ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("					DECODE(CLL.STWG_CD, 'ODFT', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 1, 0), 0) ODFT_20," ).append("\n"); 
		query.append("					DECODE(CLL.STWG_CD, 'ODFT', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '4', 1, 0), 0) ODFT_40," ).append("\n"); 
		query.append("					DECODE(CLL.STWG_CD, 'ODFT', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '4', 0, '7', 0, 1), 0) ODFT_40H," ).append("\n"); 
		query.append("                    DECODE(CLL.STWG_CD, 'ODFT', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', 1, 0), 0) ODFT_45," ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("                    DECODE(CLL.STWG_CD, 'ODHD', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 1, 0), 0) ODHD_20," ).append("\n"); 
		query.append("					DECODE(CLL.STWG_CD, 'ODHD', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '4', 1, 0), 0) ODHD_40," ).append("\n"); 
		query.append("					DECODE(CLL.STWG_CD, 'ODHD', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '4', 0, '7', 0, 1), 0) ODHD_40H," ).append("\n"); 
		query.append("                    DECODE(CLL.STWG_CD, 'ODHD', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', 1, 0), 0) ODHD_45," ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("					DECODE(CLL.STWG_CD, 'OP', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 1, 0), 0) OP_20," ).append("\n"); 
		query.append("					DECODE(CLL.STWG_CD, 'OP', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '4', 1, 0), 0) OP_40," ).append("\n"); 
		query.append("					DECODE(CLL.STWG_CD, 'OP', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '4', 0, '7', 0, 1), 0) OP_40H," ).append("\n"); 
		query.append("                    DECODE(CLL.STWG_CD, 'OP', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', 1, 0), 0) OP_45," ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("					DECODE(CLL.STWG_CD, 'OT', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 1, 0), 0) OT_20," ).append("\n"); 
		query.append("					DECODE(CLL.STWG_CD, 'OT', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '4', 1, 0), 0) OT_40," ).append("\n"); 
		query.append("					DECODE(CLL.STWG_CD, 'OT', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '4', 0, '7', 0, 1), 0) OT_40H," ).append("\n"); 
		query.append("                    DECODE(CLL.STWG_CD, 'OT', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', 1, 0), 0) OT_45," ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("					DECODE(CLL.STWG_CD, 'OTNO', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 1, 0), 0) OTNO_20," ).append("\n"); 
		query.append("					DECODE(CLL.STWG_CD, 'OTNO', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '4', 1, 0), 0) OTNO_40," ).append("\n"); 
		query.append("					DECODE(CLL.STWG_CD, 'OTNO', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '4', 0, '7', 0, 1), 0) OTNO_40H," ).append("\n"); 
		query.append("                    DECODE(CLL.STWG_CD, 'OTNO', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', 1, 0), 0) OTNO_45," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					CASE WHEN CLL.STWG_CD IS NOT NULL AND CLL.STWG_CD = 'PC'" ).append("\n"); 
		query.append("                	THEN DECODE(CLL.STWG_CD, 'PC', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 1, 0), 0)" ).append("\n"); 
		query.append("           			WHEN CLL.STWG_CD IS NULL" ).append("\n"); 
		query.append("                	THEN DECODE(CLL.KR_TML_PRCT_ID, 'P', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 1, 0), 0)" ).append("\n"); 
		query.append("      				END PC_20,      " ).append("\n"); 
		query.append("      				CASE WHEN CLL.STWG_CD IS NOT NULL AND CLL.STWG_CD = 'PC'" ).append("\n"); 
		query.append("                	THEN DECODE(CLL.STWG_CD, 'PC', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '4', 1, 0), 0)" ).append("\n"); 
		query.append("           			WHEN CLL.STWG_CD IS NULL" ).append("\n"); 
		query.append("                	THEN DECODE(CLL.KR_TML_PRCT_ID, 'P', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '4', 1, 0), 0)" ).append("\n"); 
		query.append("      				END PC_40,      " ).append("\n"); 
		query.append("      				CASE WHEN CLL.STWG_CD IS NOT NULL AND CLL.STWG_CD = 'PC'" ).append("\n"); 
		query.append("                	THEN DECODE(CLL.STWG_CD, 'PC', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '4', 0, '7', 0, 1), 0)" ).append("\n"); 
		query.append("           			WHEN CLL.STWG_CD IS NULL" ).append("\n"); 
		query.append("                	THEN DECODE(CLL.KR_TML_PRCT_ID, 'P', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '4', 0, '7', 0, 1), 0)" ).append("\n"); 
		query.append("      				END PC_40H," ).append("\n"); 
		query.append("					CASE WHEN CLL.STWG_CD IS NOT NULL AND CLL.STWG_CD = 'PC'" ).append("\n"); 
		query.append("                	THEN DECODE(CLL.STWG_CD, 'PC', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', 1, 0), 0)" ).append("\n"); 
		query.append("           			WHEN CLL.STWG_CD IS NULL" ).append("\n"); 
		query.append("                	THEN DECODE(CLL.KR_TML_PRCT_ID, 'P', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', 1, 0), 0)" ).append("\n"); 
		query.append("      				END PC_45," ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("					--DECODE(CLL.STWG_CD, 'PC', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 1, 0), 0) PC_20," ).append("\n"); 
		query.append("					--DECODE(CLL.STWG_CD, 'PC', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '4', 1, 0), 0) PC_40," ).append("\n"); 
		query.append("					--DECODE(CLL.STWG_CD, 'PC', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '2', 0, '4', 0, '7', 0, 1), 0) PC_40H," ).append("\n"); 
		query.append("                    --DECODE(CLL.STWG_CD, 'PC', DECODE(SUBSTR(CLL.CNTR_TPSZ_CD, 2, 1), '7', 1, 0), 0) PC_45," ).append("\n"); 
		query.append("					VPS.CLPT_SEQ CLPT_SEQ" ).append("\n"); 
		query.append("				FROM BKG_BOOKING BK, BKG_VVD BV, VSK_VSL_PORT_SKD VPS, MDM_LOCATION LO, BKG_CSTMS_TML_KR_CLL CLL" ).append("\n"); 
		query.append("				WHERE BK.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("					AND CLL.CNTR_TPSZ_CD NOT IN ('Q2', 'Q4')" ).append("\n"); 
		query.append("					AND BK.BKG_NO = CLL.BKG_NO" ).append("\n"); 
		query.append("					AND BV.VSL_CD = VPS.VSL_CD" ).append("\n"); 
		query.append("					AND BV.SKD_VOY_NO = VPS.SKD_VOY_NO" ).append("\n"); 
		query.append("					AND BV.SKD_DIR_CD = VPS.SKD_DIR_CD" ).append("\n"); 
		query.append("					AND BV.POD_CD = VPS.VPS_PORT_CD" ).append("\n"); 
		query.append("					AND VPS.VPS_PORT_CD = LO.LOC_CD" ).append("\n"); 
		query.append("					AND BV.VSL_CD = SUBSTR(@[in_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("					AND BV.SKD_VOY_NO = SUBSTR(@[in_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("					AND BV.SKD_DIR_CD = SUBSTR(@[in_vvd_cd], 9, 1)" ).append("\n"); 
		query.append("					AND BV.POL_CD = @[in_pol_cd]" ).append("\n"); 
		query.append("					AND SUBSTR(BV.POL_YD_CD, 6, 2) like @[in_pol_yd_cd]||'%'" ).append("\n"); 
		query.append("					AND BK.BKG_STS_CD IN ('F',  'W')" ).append("\n"); 
		query.append("					AND VPS.CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("					AND NVL(BK.SPLIT_RSN_CD, ' ') <> 'M'" ).append("\n"); 
		query.append("					AND CLL.CNTR_LIST_NO = BV.VSL_CD||SUBSTR(BV.SKD_VOY_NO, 2, 3)||BV.SKD_DIR_CD||SUBSTR(BV.POL_CD, 3, 3) )" ).append("\n"); 
		query.append("		GROUP BY GUBUN_CD3, BLCK_STWG_CD, CLPT_SEQ" ).append("\n"); 
		query.append("		ORDER BY CLPT_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}