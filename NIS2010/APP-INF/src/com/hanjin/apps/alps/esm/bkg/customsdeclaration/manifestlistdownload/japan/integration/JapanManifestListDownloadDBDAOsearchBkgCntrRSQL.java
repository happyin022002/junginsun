/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : JapanManifestListDownloadDBDAOsearchBkgCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanManifestListDownloadDBDAOsearchBkgCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBkgCntr
	  * </pre>
	  */
	public JapanManifestListDownloadDBDAOsearchBkgCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration").append("\n"); 
		query.append("FileName : JapanManifestListDownloadDBDAOsearchBkgCntrRSQL").append("\n"); 
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
		query.append("	A.BL_NO, " ).append("\n"); 
		query.append("	'  ' BL_SPLIT_NO," ).append("\n"); 
		query.append("	B.CNTR_NO, " ).append("\n"); 
		query.append("	B.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("	(  SELECT NVL(MAX(DECODE(ROWNUM, 1, CNTR_SEAL_NO, '')),'999') " ).append("\n"); 
		query.append("	   FROM (" ).append("\n"); 
		query.append("          SELECT *" ).append("\n"); 
		query.append("          FROM BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("          ORDER BY CNTR_SEAL_SEQ ASC" ).append("\n"); 
		query.append("         ) X" ).append("\n"); 
		query.append("	   WHERE X.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("	   AND  X.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("      ) CNTR_SEAL_NO," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	(  SELECT NVL(MAX(DECODE(ROWNUM, 2, CNTR_SEAL_NO, '')),' ') " ).append("\n"); 
		query.append("	   FROM (" ).append("\n"); 
		query.append("          SELECT *" ).append("\n"); 
		query.append("          FROM BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("          ORDER BY CNTR_SEAL_SEQ ASC" ).append("\n"); 
		query.append("         ) X" ).append("\n"); 
		query.append("	   WHERE X.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("	   AND  X.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("      ) CNTR_SEAL_NO2," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	(  SELECT NVL(MAX(DECODE(ROWNUM, 3, CNTR_SEAL_NO, '')),' ') " ).append("\n"); 
		query.append("	   FROM (" ).append("\n"); 
		query.append("          SELECT *" ).append("\n"); 
		query.append("          FROM BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("          ORDER BY CNTR_SEAL_SEQ ASC" ).append("\n"); 
		query.append("         ) X" ).append("\n"); 
		query.append("	   WHERE X.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("	   AND  X.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("      ) CNTR_SEAL_NO3," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	(  SELECT NVL(MAX(DECODE(ROWNUM, 4, CNTR_SEAL_NO, '')),' ') " ).append("\n"); 
		query.append("	   FROM (" ).append("\n"); 
		query.append("          SELECT *" ).append("\n"); 
		query.append("          FROM BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("          ORDER BY CNTR_SEAL_SEQ ASC" ).append("\n"); 
		query.append("         ) X" ).append("\n"); 
		query.append("	   WHERE X.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("	   AND  X.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("      ) CNTR_SEAL_NO4," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	(  SELECT NVL(MAX(DECODE(ROWNUM, 5, CNTR_SEAL_NO, '')),' ') " ).append("\n"); 
		query.append("	   FROM (" ).append("\n"); 
		query.append("          SELECT *" ).append("\n"); 
		query.append("          FROM BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("          ORDER BY CNTR_SEAL_SEQ ASC" ).append("\n"); 
		query.append("         ) X" ).append("\n"); 
		query.append("	   WHERE X.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("	   AND  X.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("      ) CNTR_SEAL_NO5," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	(  SELECT NVL(MAX(DECODE(ROWNUM, 6, CNTR_SEAL_NO, '')),' ') " ).append("\n"); 
		query.append("	   FROM (" ).append("\n"); 
		query.append("          SELECT *" ).append("\n"); 
		query.append("          FROM BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("          ORDER BY CNTR_SEAL_SEQ ASC" ).append("\n"); 
		query.append("         ) X" ).append("\n"); 
		query.append("	   WHERE X.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("	   AND  X.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("      ) CNTR_SEAL_NO6," ).append("\n"); 
		query.append("	B.CNTR_PRT_FLG," ).append("\n"); 
		query.append("	B.RCV_TERM_CD,    " ).append("\n"); 
		query.append("	B.DE_TERM_CD," ).append("\n"); 
		query.append("	@[bkg_cgo_tp_cd] BKG_CGO_TP_CD," ).append("\n"); 
		query.append("	DECODE(D.LSTM_CD,'SH','1','2') LSTM_CD" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("	BKG_BOOKING A, " ).append("\n"); 
		query.append("	BKG_CONTAINER B, " ).append("\n"); 
		query.append("	MST_CONTAINER D" ).append("\n"); 
		query.append("WHERE  A.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("AND  A.BKG_NO       = B.BKG_NO" ).append("\n"); 
		query.append("AND	 B.CNTR_NO = D.CNTR_NO" ).append("\n"); 

	}
}