/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : IndiaCustomsReportDBDAOSearchExportVesselInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.07
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.india.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IndiaCustomsReportDBDAOSearchExportVesselInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchExportVesselInfo 생성을 위해 사용
	  * </pre>
	  */
	public IndiaCustomsReportDBDAOSearchExportVesselInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("export_vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.india.integration").append("\n"); 
		query.append("FileName : IndiaCustomsReportDBDAOSearchExportVesselInfoRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("       BC.BKG_NO, BC.CNMV_CYC_NO, BB.POL_NOD_CD, BB.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("       BC.CNTR_NO, " ).append("\n"); 
		query.append("       BC.MEAS_QTY, " ).append("\n"); 
		query.append("       (SELECT CNTR_TPSZ_ISO_CD " ).append("\n"); 
		query.append("        FROM MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append("        WHERE BC.CNTR_TPSZ_CD = CNTR_TPSZ_CD) ISO_CD," ).append("\n"); 
		query.append("       (SELECT DISTINCT IMDG_CLSS_CD " ).append("\n"); 
		query.append("        FROM BKG_DG_CGO BDC" ).append("\n"); 
		query.append("        WHERE BC.BKG_NO = BDC.BKG_NO " ).append("\n"); 
		query.append("        AND BC.CNTR_NO = BDC.CNTR_NO " ).append("\n"); 
		query.append("        AND ROWNUM = 1) IMO, " ).append("\n"); 
		query.append("        NVL(SUBSTR(BB.PRE_RLY_PORT_CD, 3, 5), NVL(SUBSTR(BB.PST_RLY_PORT_CD, 3, 5), SUBSTR(BB.POD_CD, 3, 5))) TS_LOC," ).append("\n"); 
		query.append("       DECODE(BB.BKG_CGO_TP_CD, 'E', 'E', 'P', 'E', DECODE(BB.POR_CD, BB.POL_CD, 'I', 'F')) STS, " ).append("\n"); 
		query.append("       BB.POD_CD FPD," ).append("\n"); 
		query.append("       SUBSTR(BB.POR_CD, 3, 5) ORIGIN," ).append("\n"); 
		query.append("       BB.VSL_CD||BB.SKD_VOY_NO||BB.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("       DECODE(BB.BKG_CGO_TP_CD, 'F', BS.CUST_NM, 'MTY REPO') SHIPPER," ).append("\n"); 
		query.append("       '' DOCS_DT," ).append("\n"); 
		query.append("       (SELECT MAX(TO_CHAR(CNMV_EVNT_DT, 'YYYY-MM-DD HH24:MI:SS')) " ).append("\n"); 
		query.append("        FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("        WHERE  BC.CNTR_NO = CNTR_NO" ).append("\n"); 
		query.append("        AND BC.CNMV_YR = CNMV_YR" ).append("\n"); 
		query.append("        AND BC.CNMV_CYC_NO >= CNMV_CYC_NO" ).append("\n"); 
		query.append("        AND MVMT_STS_CD = DECODE(BB.BKG_CGO_TP_CD, 'F' ,'OC', 'R' ,'OC', 'MT')" ).append("\n"); 
		query.append("        AND BB.POL_NOD_CD = ORG_YD_CD) EVENT_DT," ).append("\n"); 
		query.append("       BB.XTER_RMK               " ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD VPS, BKG_BOOKING BB, BKG_CONTAINER BC, BKG_CUSTOMER BS, BKG_VVD BV" ).append("\n"); 
		query.append("WHERE 1=1 " ).append("\n"); 
		query.append("--1. 기간 조건(M)" ).append("\n"); 
		query.append("AND VPS_ETD_DT BETWEEN TO_DATE(@[from_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("--2. VVD 조건(O)" ).append("\n"); 
		query.append("AND VPS.VSL_CD 		= SUBSTR(@[export_vvd], 1, 4)" ).append("\n"); 
		query.append("AND	VPS.SKD_VOY_NO 	= SUBSTR(@[export_vvd], 5, 4)" ).append("\n"); 
		query.append("AND	VPS.SKD_DIR_CD 	= SUBSTR(@[export_vvd], 9, 1)" ).append("\n"); 
		query.append("--3. POL 조건(M)" ).append("\n"); 
		query.append("AND BB.POL_CD LIKE @[pol]||'%'" ).append("\n"); 
		query.append("--4. 터미널 선택 조건(M)은 select시 사용" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND VPS.VSL_CD 		= BV.VSL_CD" ).append("\n"); 
		query.append("AND	VPS.SKD_VOY_NO 	= BV.SKD_VOY_NO" ).append("\n"); 
		query.append("AND	VPS.SKD_DIR_CD 	= BV.SKD_DIR_CD" ).append("\n"); 
		query.append("AND VPS.VPS_PORT_CD = BV.POL_CD" ).append("\n"); 
		query.append("AND BB.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("AND	BB.BKG_STS_CD	   <>  'X'" ).append("\n"); 
		query.append("AND BB.BKG_NO       = BS.BKG_NO" ).append("\n"); 
		query.append("AND BV.BKG_NO       = BB.BKG_NO" ).append("\n"); 
		query.append("AND BS.BKG_CUST_TP_CD = 'S'" ).append("\n"); 

	}
}