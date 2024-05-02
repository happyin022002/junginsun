/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : Jp24ManifestListDownloadDBDAOSearchBkgContainerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.25
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2013.11.25 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang-Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Jp24ManifestListDownloadDBDAOSearchBkgContainerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public Jp24ManifestListDownloadDBDAOSearchBkgContainerRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration").append("\n"); 
		query.append("FileName : Jp24ManifestListDownloadDBDAOSearchBkgContainerRSQL").append("\n"); 
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
		query.append("SELECT A.BL_NO," ).append("\n"); 
		query.append("       '  ' BL_SPLIT_NO," ).append("\n"); 
		query.append("       B.CNTR_NO," ).append("\n"); 
		query.append("       B.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       (SELECT NVL(MIN(CNTR_SEAL_NO), '999')" ).append("\n"); 
		query.append("          FROM BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("         WHERE BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("           AND CNTR_NO = B.CNTR_NO) AS CNTR_SEAL_NO," ).append("\n"); 
		query.append("       B.CNTR_PRT_FLG AS PRT_FLG," ).append("\n"); 
		query.append("       B.RCV_TERM_CD," ).append("\n"); 
		query.append("       B.DE_TERM_CD," ).append("\n"); 
		query.append("       DECODE(D.LSTM_CD, 'SH', '1', '2') AS JP_CNTR_OWNR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_BOOKING A," ).append("\n"); 
		query.append("       BKG_CONTAINER B," ).append("\n"); 
		query.append("       MST_CONTAINER D" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("   AND B.CNTR_NO = D.CNTR_NO" ).append("\n"); 

	}
}