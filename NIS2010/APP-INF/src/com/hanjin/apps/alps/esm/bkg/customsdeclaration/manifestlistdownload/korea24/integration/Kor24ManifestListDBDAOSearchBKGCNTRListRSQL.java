/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : Kor24ManifestListDBDAOSearchBKGCNTRListRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.26
*@LastModifier :
*@LastVersion : 1.0
* 2013.08.26
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Kor24ManifestListDBDAOSearchBKGCNTRListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * 한국세관 CNTR에 Insert하기위해 조회함
	  * </pre>
	  */
	public Kor24ManifestListDBDAOSearchBKGCNTRListRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration").append("\n");
		query.append("FileName : Kor24ManifestListDBDAOSearchBKGCNTRListRSQL").append("\n");
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
		query.append("SELECT B_CNTR_NO" ).append("\n");
		query.append("     , B_CNTRTS_CD" ).append("\n");
		query.append("     , MAX(B_CNTR_SEAL_NO1) B_CNTR_SEAL_NO1" ).append("\n");
		query.append("     , MAX(B_CNTR_SEAL_NO2) B_CNTR_SEAL_NO2" ).append("\n");
		query.append("     , B_CNTR_PKG_QTY" ).append("\n");
		query.append("     , B_CNTR_PKG_CD" ).append("\n");
		query.append("     , B_CNTR_WGT_QTY" ).append("\n");
		query.append("     , B_CNTR_WGT_TP" ).append("\n");
		query.append("     , B_CNTR_MEA_QTY" ).append("\n");
		query.append("     , B_CNTR_MEA_TP" ).append("\n");
		query.append("	 , B_BB_CGO_FLG" ).append("\n");
		query.append("FROM (SELECT NVL(CNTR.CNTR_NO,' ') B_CNTR_NO " ).append("\n");
		query.append("        , NVL(CNTR.CNTR_TPSZ_CD,' ') B_CNTRTS_CD " ).append("\n");
		query.append("        , NVL(DECODE(SEAL.CNTR_SEAL_SEQ,1,SEAL.CNTR_SEAL_NO),' ') B_CNTR_SEAL_NO1" ).append("\n");
		query.append("        , NVL(DECODE(SEAL.CNTR_SEAL_SEQ,2,SEAL.CNTR_SEAL_NO),' ') B_CNTR_SEAL_NO2" ).append("\n");
		query.append("        , NVL(CNTR.PCK_QTY,0) B_CNTR_PKG_QTY " ).append("\n");
		query.append("        , NVL(CNTR.PCK_TP_CD,' ') B_CNTR_PKG_CD " ).append("\n");
		query.append("        , TRUNC(DECODE(NVL(CNTR.WGT_UT_CD,'  '),'LBS',ROUND(NVL(CNTR.CNTR_WGT,0)*0.4536,3),NVL(CNTR.CNTR_WGT,0)),2) B_CNTR_WGT_QTY " ).append("\n");
		query.append("        , DECODE(NVL(CNTR.WGT_UT_CD,''),'LBS','KGS',NVL(CNTR.WGT_UT_CD,'')) B_CNTR_WGT_TP " ).append("\n");
		query.append("        , NVL(CNTR.MEAS_QTY,0) B_CNTR_MEA_QTY " ).append("\n");
		query.append("        , NVL(CNTR.MEAS_UT_CD,'') B_CNTR_MEA_TP" ).append("\n");
		query.append("		, NVL(CNTR.BB_CGO_FLG, 'N') B_BB_CGO_FLG " ).append("\n");
		query.append("        FROM BKG_CONTAINER CNTR, BKG_CNTR_SEAL_NO SEAL " ).append("\n");
		query.append("        WHERE CNTR.BKG_NO  = @[bkg_no]" ).append("\n");
		query.append("        AND CNTR.BKG_NO  = SEAL.BKG_NO(+) " ).append("\n");
		query.append("        AND CNTR.CNTR_NO = SEAL.CNTR_NO(+) " ).append("\n");
		query.append("        ORDER BY NVL(CNTR.CNTR_NO,' ') " ).append("\n");
		query.append("       )" ).append("\n");
		query.append("GROUP BY B_CNTR_NO,B_CNTRTS_CD,B_CNTR_PKG_QTY,B_CNTR_PKG_CD,B_CNTR_WGT_QTY,B_CNTR_WGT_TP,B_CNTR_MEA_QTY,B_CNTR_MEA_TP,B_BB_CGO_FLG" ).append("\n");
		query.append("ORDER BY B_CNTR_NO" ).append("\n");

	}
}