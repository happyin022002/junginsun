/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchCllCdlCheckForUSRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.15
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.15 
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

public class CLLCDLManifestDBDAOsearchCllCdlCheckForUSRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CllCdlCheckUsaVO
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchCllCdlCheckForUSRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchCllCdlCheckForUSRSQL").append("\n"); 
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
		query.append("SELECT 	KIND," ).append("\n"); 
		query.append("BKG_NO," ).append("\n"); 
		query.append("POL," ).append("\n"); 
		query.append("POD," ).append("\n"); 
		query.append("BKG_QTY1," ).append("\n"); 
		query.append("DECODE(BKG_QTY2, 0, '', BKG_QTY2) AS BKG_QTY2," ).append("\n"); 
		query.append("FPOD," ).append("\n"); 
		query.append("SHPR_NM," ).append("\n"); 
		query.append("CNTR_NO," ).append("\n"); 
		query.append("CMDT_NM," ).append("\n"); 
		query.append("SPECIAL," ).append("\n"); 
		query.append("RNUM," ).append("\n"); 
		query.append("' ' AS MATCH" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT  'A' AS KIND," ).append("\n"); 
		query.append("BKG.BKG_NO," ).append("\n"); 
		query.append("'' AS POL," ).append("\n"); 
		query.append("'' AS POD," ).append("\n"); 
		query.append("DECODE( SUBSTR(QTY.CNTR_TPSZ_CD,2,1), '2','20','7','45','40') AS BKG_QTY1," ).append("\n"); 
		query.append("#if (${tmnl_type} == 'COSCO')" ).append("\n"); 
		query.append("0 AS BKG_QTY2,						/* COSCO */" ).append("\n"); 
		query.append("SUBSTR(BKG.POD_CD,3,3) AS FPOD, 	/* COSCO */" ).append("\n"); 
		query.append("#elseif (${tmnl_type} == 'GPA')" ).append("\n"); 
		query.append("0 AS BKG_QTY2,						/* GPA */" ).append("\n"); 
		query.append("SUBSTR(VVD.POD_CD,3,3) AS FPOD, 	/* GPA */" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("QTY.OP_CNTR_QTY AS BKG_QTY2, 		/* General, TTI */" ).append("\n"); 
		query.append("VVD.POD_CD AS FPOD, 				/* General, TTI */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("REPLACE(REPLACE(REPLACE(CUST.CUST_NM, CHR(10), ''), CHR(13), ''), CHR(9), '') AS SHPR_NM," ).append("\n"); 
		query.append("CNTR.CNTR_NO," ).append("\n"); 
		query.append("SUBSTR(REP.CMDT_NM, 1, 30) AS CMDT_NM," ).append("\n"); 
		query.append("#if (${tmnl_type} != 'GPA')" ).append("\n"); 
		query.append("REPLACE(DECODE(SIGN(FDO_TEMP),0,'+',1,'+')||TO_CHAR(RF.FDO_TEMP,'000.00')||DECODE(RF.FDO_TEMP,NULL,'','F'),' ','') AS SPECIAL, 	/* General, TTI, COSCO */" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'' AS SPECIAL, 	/* GPA */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ROW_NUMBER() OVER(ORDER BY VVD.POD_CD, BKG.BKG_NO, CNTR.CNTR_NO) AS RNUM" ).append("\n"); 
		query.append("FROM    BKG_BOOKING BKG," ).append("\n"); 
		query.append("BKG_QUANTITY QTY," ).append("\n"); 
		query.append("BKG_CUSTOMER CUST," ).append("\n"); 
		query.append("BKG_VVD VVD," ).append("\n"); 
		query.append("BKG_CONTAINER CNTR," ).append("\n"); 
		query.append("MDM_COMMODITY REP," ).append("\n"); 
		query.append("BKG_RF_CGO RF" ).append("\n"); 
		query.append("WHERE  BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("AND  NVL(BKG.BKG_STS_CD,'N') <> 'X'" ).append("\n"); 
		query.append("AND  BKG.BKG_NO = QTY.BKG_NO" ).append("\n"); 
		query.append("AND  BKG.BKG_NO = CUST.BKG_NO" ).append("\n"); 
		query.append("AND  BKG.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("AND  QTY.CNTR_TPSZ_CD = CNTR.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND  BKG.CMDT_CD = REP.CMDT_CD(+)" ).append("\n"); 
		query.append("AND  CUST.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("AND  VVD.VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append("AND  CNTR.BKG_NO = RF.BKG_NO(+)" ).append("\n"); 
		query.append("AND  CNTR.CNTR_NO = RF.CNTR_NO(+)" ).append("\n"); 
		query.append("AND  VVD.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND  VVD.SKD_VOY_NO =  SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND  VVD.SKD_DIR_CD =  SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("AND  VVD.POL_CD =  @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("AND  VVD.POD_CD =  @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${inc_mty} == 'N')" ).append("\n"); 
		query.append("AND  (NVL(bkg.bkg_cgo_tp_cd,'Q') <>'P')  --Including Empty Unchecked인 경우" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  ' ' AS KIND," ).append("\n"); 
		query.append("'' AS BKG_NO," ).append("\n"); 
		query.append("'' AS POL," ).append("\n"); 
		query.append("'' AS POD," ).append("\n"); 
		query.append("'' AS BKG_QTY1," ).append("\n"); 
		query.append("0  AS BKG_QTY2," ).append("\n"); 
		query.append("'' AS FPOD," ).append("\n"); 
		query.append("'' AS SHPR_NM," ).append("\n"); 
		query.append("'' AS CNTR_NO," ).append("\n"); 
		query.append("'' AS CMDT_NM," ).append("\n"); 
		query.append("'' AS SPECIAL," ).append("\n"); 
		query.append("ROW_NUMBER() OVER(ORDER BY VVD.POD_CD, BKG.BKG_NO, CNTR.CNTR_NO) AS RNUM" ).append("\n"); 
		query.append("FROM    BKG_BOOKING BKG," ).append("\n"); 
		query.append("BKG_QUANTITY QTY," ).append("\n"); 
		query.append("BKG_CUSTOMER CUST," ).append("\n"); 
		query.append("BKG_VVD VVD," ).append("\n"); 
		query.append("BKG_CONTAINER CNTR," ).append("\n"); 
		query.append("MDM_COMMODITY REP," ).append("\n"); 
		query.append("BKG_RF_CGO RF" ).append("\n"); 
		query.append("WHERE  BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("AND  NVL(BKG.BKG_STS_CD,'N') <> 'X'" ).append("\n"); 
		query.append("AND  BKG.BKG_NO = QTY.BKG_NO" ).append("\n"); 
		query.append("AND  BKG.BKG_NO = CUST.BKG_NO" ).append("\n"); 
		query.append("AND  BKG.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("AND  QTY.CNTR_TPSZ_CD = CNTR.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND  BKG.CMDT_CD = REP.CMDT_CD(+)" ).append("\n"); 
		query.append("AND  CUST.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("AND  VVD.VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append("AND  CNTR.BKG_NO = RF.BKG_NO(+)" ).append("\n"); 
		query.append("AND  CNTR.CNTR_NO = RF.CNTR_NO(+)" ).append("\n"); 
		query.append("AND  VVD.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND  VVD.SKD_VOY_NO =  SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND  VVD.SKD_DIR_CD =  SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("AND  VVD.POL_CD =  @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("AND  VVD.POD_CD =  @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${inc_mty} == 'N')" ).append("\n"); 
		query.append("AND  (NVL(bkg.bkg_cgo_tp_cd,'Q') <>'P')  --Including Empty Unchecked인 경우" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY RNUM, KIND DESC" ).append("\n"); 

	}
}