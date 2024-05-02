/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : IndiaCustomsReportDBDAOSearchReexportInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.18
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.18 
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

public class IndiaCustomsReportDBDAOSearchReexportInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ReexportInfo 생성을 위해 사용
	  * </pre>
	  */
	public IndiaCustomsReportDBDAOSearchReexportInfoRSQL(){
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
		query.append("FileName : IndiaCustomsReportDBDAOSearchReexportInfoRSQL").append("\n"); 
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
		query.append("SELECT SEQ, CNTR_NO, ISO_CD, IMP_VSL, VSL_VOY, IGM_NO, IGM_DT, EXP_VSL, SKD_VOY_NO, PC_NO, PC_DT, VPS_ETD_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("    SELECT RANK() OVER(PARTITION BY BC.BKG_NO, BC.CNTR_NO  ORDER BY BC.BKG_NO, CM.CNTR_NO, CM.CNMV_ID_NO DESC) SEQ," ).append("\n"); 
		query.append("           BC.BKG_NO, BC.CNMV_CYC_NO, BV.POL_CD," ).append("\n"); 
		query.append("           BC.CNTR_NO, " ).append("\n"); 
		query.append("           (SELECT CNTR_TPSZ_ISO_CD " ).append("\n"); 
		query.append("            FROM MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append("            WHERE BC.CNTR_TPSZ_CD = CNTR_TPSZ_CD) ISO_CD,        " ).append("\n"); 
		query.append("           (SELECT VSL_ENG_NM FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("            WHERE VSL_CD = CM.CRNT_VSL_CD) IMP_VSL," ).append("\n"); 
		query.append("            CM.CRNT_SKD_VOY_NO VSL_VOY," ).append("\n"); 
		query.append("            BIV.IDA_DECL_VSL_NO IGM_NO," ).append("\n"); 
		query.append("            TO_CHAR(BIV.VSL_DECL_DT, 'YYYY-MM-DD') IGM_DT," ).append("\n"); 
		query.append("           (SELECT VSL_ENG_NM FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("            WHERE VSL_CD = BV.VSL_CD) EXP_VSL," ).append("\n"); 
		query.append("           BV.SKD_VOY_NO," ).append("\n"); 
		query.append("           '' PC_NO," ).append("\n"); 
		query.append("           '' PC_DT," ).append("\n"); 
		query.append("           TO_CHAR(VPS.VPS_ETD_DT, 'YYYY-MM-DD') VPS_ETD_DT             " ).append("\n"); 
		query.append("    FROM VSK_VSL_PORT_SKD VPS, BKG_VVD BV, BKG_CONTAINER BC, CTM_MOVEMENT CM, BKG_CSTMS_IDA_VSL BIV " ).append("\n"); 
		query.append("    WHERE 1=1 " ).append("\n"); 
		query.append("    --1. 기간 조건(M)" ).append("\n"); 
		query.append("    AND VPS_ETD_DT BETWEEN TO_DATE(@[from_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("    --2. VVD 조건(O)" ).append("\n"); 
		query.append("    AND VPS.VSL_CD 		= SUBSTR(@[export_vvd], 1, 4)" ).append("\n"); 
		query.append("    AND	VPS.SKD_VOY_NO 	= SUBSTR(@[export_vvd], 5, 4)" ).append("\n"); 
		query.append("    AND	VPS.SKD_DIR_CD 	= SUBSTR(@[export_vvd], 9, 1)" ).append("\n"); 
		query.append("    --3. POL 조건(M)" ).append("\n"); 
		query.append("    AND BV.POL_CD LIKE @[pol]||'%'" ).append("\n"); 
		query.append("    AND VPS.VSL_CD 		= BV.VSL_CD" ).append("\n"); 
		query.append("    AND	VPS.SKD_VOY_NO 	= BV.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND	VPS.SKD_DIR_CD 	= BV.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND VPS.VPS_PORT_CD = BV.POL_CD" ).append("\n"); 
		query.append("    AND BV.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("    AND BC.CNTR_NO = CM.CNTR_NO" ).append("\n"); 
		query.append("    AND BC.CNMV_YR = CM.CNMV_YR" ).append("\n"); 
		query.append("    AND BC.CNMV_CYC_NO >= CM.CNMV_CYC_NO" ).append("\n"); 
		query.append("    AND CM.MVMT_STS_CD = 'VD'     " ).append("\n"); 
		query.append("    AND CM.ORG_YD_CD LIKE 'IN%'" ).append("\n"); 
		query.append("    AND BIV.VSL_CD = CM.CRNT_VSL_CD" ).append("\n"); 
		query.append("    AND BIV.SKD_VOY_NO = CM.CRNT_SKD_VOY_NO" ).append("\n"); 
		query.append("    AND BIV.SKD_DIR_CD = CM.CRNT_SKD_DIR_CD" ).append("\n"); 
		query.append("    AND BIV.POD_CD = SUBSTR(CM.ORG_YD_CD, 1, 5)" ).append("\n"); 
		query.append("    AND EXISTS (SELECT 'A' FROM CTM_MOVEMENT CTM" ).append("\n"); 
		query.append("                WHERE  CTM.CNTR_NO = CM.CNTR_NO" ).append("\n"); 
		query.append("                AND    CTM.CNMV_CYC_NO = CM.CNMV_CYC_NO" ).append("\n"); 
		query.append("                AND    CTM.MVMT_STS_CD = 'VL'" ).append("\n"); 
		query.append("                AND    CTM.ORG_YD_CD NOT LIKE 'IN%')" ).append("\n"); 
		query.append("    )        " ).append("\n"); 
		query.append(" WHERE SEQ = 1" ).append("\n"); 

	}
}