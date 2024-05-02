/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CLLCDLManifestDBDAOSearchPartialCntrDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOSearchPartialCntrDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Retrieve the summarized data for save the partial container as one row
	  * </pre>
	  */
	public CLLCDLManifestDBDAOSearchPartialCntrDataRSQL(){
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOSearchPartialCntrDataRSQL").append("\n"); 
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
		query.append("WITH BKG_LIST AS (" ).append("\n"); 
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT BKG_NO, COUNT(BKG_NO) OVER (ORDER BY 1) CNT" ).append("\n"); 
		query.append("    FROM BKG_BOOKING B" ).append("\n"); 
		query.append("    WHERE EXISTS (SELECT 'X' FROM BKG_CONTAINER C WHERE C.BKG_NO = B.BKG_NO AND C.CNTR_NO = @[cntr_no])" ).append("\n"); 
		query.append("    AND B.BKG_STS_CD<>'X'" ).append("\n"); 
		query.append("    AND (B.VSL_CD, B.SKD_VOY_NO, B.SKD_DIR_CD) IN (SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD FROM BKG_BOOKING T WHERE T.BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE CNT>1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("	(SELECT	SUM(NVL(OP_CNTR_QTY,0)) " ).append("\n"); 
		query.append("	FROM	BKG_QUANTITY" ).append("\n"); 
		query.append("	WHERE	BKG_NO IN (SELECT BKG_NO FROM BKG_LIST)" ).append("\n"); 
		query.append("	AND	SUBSTR(CNTR_TPSZ_CD,2,1) = '2'" ).append("\n"); 
		query.append("	AND	CNTR_TPSZ_CD != 'Q2'" ).append("\n"); 
		query.append("	AND	CNTR_TPSZ_CD != 'Q4') PRT_IN_TEU," ).append("\n"); 
		query.append("	(SELECT	SUM(NVL(OP_CNTR_QTY,0)) " ).append("\n"); 
		query.append("	FROM	BKG_QUANTITY" ).append("\n"); 
		query.append("	WHERE	BKG_NO IN (SELECT BKG_NO FROM BKG_LIST)" ).append("\n"); 
		query.append("	AND	SUBSTR(CNTR_TPSZ_CD,2,1) != '2'" ).append("\n"); 
		query.append("	AND	CNTR_TPSZ_CD != 'Q2'" ).append("\n"); 
		query.append("	AND	CNTR_TPSZ_CD != 'Q4') PRT_IN_FEU," ).append("\n"); 
		query.append("#if (${in_cntr_match} == 'Y') " ).append("\n"); 
		query.append("	(SELECT	SUM(DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,2)/DECODE(SUBSTR(@[cntr_tpsz_cd],2,1),'2',1,2))--전체 대비 내 비중을 위한 분모값" ).append("\n"); 
		query.append("	FROM	BKG_CONTAINER" ).append("\n"); 
		query.append("	WHERE	BKG_NO IN (SELECT BKG_NO FROM BKG_LIST)" ).append("\n"); 
		query.append("	AND	CNTR_TPSZ_CD != 'Q2'" ).append("\n"); 
		query.append("	AND	CNTR_TPSZ_CD != 'Q4') PRT_IN_QTY," ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	(SELECT	SUM(DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,2)*NVL(OP_CNTR_QTY,0)/DECODE(SUBSTR(@[cntr_tpsz_cd],2,1),'2',1,2))--전체 대비 내 비중을 위한 분모값" ).append("\n"); 
		query.append("	FROM	BKG_QUANTITY" ).append("\n"); 
		query.append("	WHERE	BKG_NO IN (SELECT BKG_NO FROM BKG_LIST)" ).append("\n"); 
		query.append("	AND	CNTR_TPSZ_CD != 'Q2'" ).append("\n"); 
		query.append("	AND	CNTR_TPSZ_CD != 'Q4') PRT_IN_QTY," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	(SELECT	SUM(NVL(PCK_QTY,0))" ).append("\n"); 
		query.append("	FROM	BKG_CONTAINER" ).append("\n"); 
		query.append("	WHERE	BKG_NO IN (SELECT BKG_NO FROM BKG_LIST)" ).append("\n"); 
		query.append("	AND CNTR_NO = @[cntr_no]) PRT_PCK_QTY," ).append("\n"); 
		query.append("	(SELECT	MAX(PCK_TP_CD)" ).append("\n"); 
		query.append("	FROM	BKG_CONTAINER" ).append("\n"); 
		query.append("	WHERE	BKG_NO IN (SELECT BKG_NO FROM BKG_LIST)" ).append("\n"); 
		query.append("	AND CNTR_NO = @[cntr_no]) PRT_PCK_TP_CD," ).append("\n"); 
		query.append("	(SELECT	SUM(NVL(CNTR_WGT,0))" ).append("\n"); 
		query.append("	FROM	BKG_CONTAINER" ).append("\n"); 
		query.append("	WHERE	BKG_NO IN (SELECT BKG_NO FROM BKG_LIST)" ).append("\n"); 
		query.append("	AND CNTR_NO = @[cntr_no]) PRT_CNTR_WGT," ).append("\n"); 
		query.append("	(SELECT	MAX(WGT_UT_CD)" ).append("\n"); 
		query.append("	FROM	BKG_CONTAINER" ).append("\n"); 
		query.append("	WHERE	BKG_NO IN (SELECT BKG_NO FROM BKG_LIST)" ).append("\n"); 
		query.append("	AND CNTR_NO = @[cntr_no]) PRT_CNTR_WGT_UT_CD," ).append("\n"); 
		query.append("    (SELECT	MAX(NVL(DECODE(VGM_WGT_UT_CD,'KGS',VGM_WGT,'LBS',VGM_WGT * 0.453592),0))" ).append("\n"); 
		query.append("	FROM	BKG_CONTAINER" ).append("\n"); 
		query.append("	WHERE	BKG_NO IN (SELECT BKG_NO FROM BKG_LIST)" ).append("\n"); 
		query.append("	AND CNTR_NO = @[cntr_no]) PRT_VGM_WGT," ).append("\n"); 
		query.append("	(SELECT	MAX(DECODE(VGM_WGT_UT_CD,NULL,NULL,'KGS'))" ).append("\n"); 
		query.append("	FROM	BKG_CONTAINER" ).append("\n"); 
		query.append("	WHERE	BKG_NO IN (SELECT BKG_NO FROM BKG_LIST)" ).append("\n"); 
		query.append("	AND CNTR_NO = @[cntr_no]) PRT_VGM_WGT_UT_CD," ).append("\n"); 
		query.append("	(SELECT	SUM(NVL(ACT_WGT,0))" ).append("\n"); 
		query.append("	FROM	BKG_BL_DOC" ).append("\n"); 
		query.append("	WHERE	BKG_NO IN (SELECT BKG_NO FROM BKG_LIST)) PRT_DOC_ACT_WGT," ).append("\n"); 
		query.append("	(SELECT	MAX(WGT_UT_CD)" ).append("\n"); 
		query.append("	FROM	BKG_BL_DOC" ).append("\n"); 
		query.append("	WHERE	BKG_NO IN (SELECT BKG_NO FROM BKG_LIST)) PRT_DOC_WGT_UT_CD," ).append("\n"); 
		query.append("	(SELECT	SUM(NVL(MEAS_QTY,0))" ).append("\n"); 
		query.append("	FROM	BKG_CONTAINER" ).append("\n"); 
		query.append("	WHERE	BKG_NO IN (SELECT BKG_NO FROM BKG_LIST)" ).append("\n"); 
		query.append("	AND CNTR_NO = @[cntr_no]) PRT_MEAS_QTY," ).append("\n"); 
		query.append("	(SELECT	MAX(MEAS_UT_CD)" ).append("\n"); 
		query.append("	FROM	BKG_CONTAINER" ).append("\n"); 
		query.append("	WHERE	BKG_NO IN (SELECT BKG_NO FROM BKG_LIST)" ).append("\n"); 
		query.append("	AND CNTR_NO = @[cntr_no]) PRT_MEAS_QTY_UT_CD," ).append("\n"); 
		query.append("	(SELECT	SUM(NVL(MEAS_QTY,0))" ).append("\n"); 
		query.append("	FROM	BKG_BL_DOC" ).append("\n"); 
		query.append("	WHERE	BKG_NO IN (SELECT BKG_NO FROM BKG_LIST)" ).append("\n"); 
		query.append("	) PRT_DOC_MEAS_QTY," ).append("\n"); 
		query.append("	(SELECT	MAX(MEAS_UT_CD)" ).append("\n"); 
		query.append("	FROM	BKG_BL_DOC" ).append("\n"); 
		query.append("	WHERE	BKG_NO IN (SELECT BKG_NO FROM BKG_LIST)" ).append("\n"); 
		query.append("	) PRT_DOC_MEAS_UT_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}