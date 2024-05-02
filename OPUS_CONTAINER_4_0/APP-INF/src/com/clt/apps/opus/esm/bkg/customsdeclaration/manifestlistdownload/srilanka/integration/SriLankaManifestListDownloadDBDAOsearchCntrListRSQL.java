/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SriLankaManifestListDownloadDBDAOsearchCntrListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.10
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SriLankaManifestListDownloadDBDAOsearchCntrListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 스리랑카세관 신고용 Container List 정보를 조회한다.
	  * </pre>
	  */
	public SriLankaManifestListDownloadDBDAOsearchCntrListRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.integration").append("\n"); 
		query.append("FileName : SriLankaManifestListDownloadDBDAOsearchCntrListRSQL").append("\n"); 
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
		query.append("SELECT  '' seq,cntr_no, CNTR_TPSZ_CD, CNTR_SEAL_NO," ).append("\n"); 
		query.append("PCK_QTY,  PCK_TP_CD," ).append("\n"); 
		query.append(" CNTR_WGT,  WGT_UT_CD," ).append("\n"); 
		query.append("MEAS_QTY,  MEAS_UT_CD ,BL_NO," ).append("\n"); 
		query.append("COUNT(DISTINCT cntr_no) OVER() BL_TOTAL" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT NVL(A.CNTR_NO,' ') cntr_no, " ).append("\n"); 
		query.append("NVL(A.CNTR_TPSZ_CD,' ') CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("NVL(MIN(B.CNTR_SEAL_NO),' ') CNTR_SEAL_NO," ).append("\n"); 
		query.append("NVL(A.PCK_QTY,0) PCK_QTY, NVL(A.PCK_TP_CD,' ') PCK_TP_CD," ).append("\n"); 
		query.append("NVL(A.CNTR_WGT,0) CNTR_WGT, NVL(A.WGT_UT_CD,' ') WGT_UT_CD," ).append("\n"); 
		query.append("NVL(A.MEAS_QTY,0) MEAS_QTY, NVL(A.MEAS_UT_CD,' ') MEAS_UT_CD ,C.BL_NO BL_NO" ).append("\n"); 
		query.append("FROM   BKG_CONTAINER A, BKG_CNTR_SEAL_NO B,BKG_BOOKING C" ).append("\n"); 
		query.append("WHERE  A.BKG_NO       = @[bkg_no]  -- searchBlList ( ) 에서 조회된 bkg no" ).append("\n"); 
		query.append("AND    A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("AND    A.CNTR_NO = B.CNTR_NO(+)" ).append("\n"); 
		query.append("AND    A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("GROUP BY  NVL(A.CNTR_NO,' '), NVL(A.CNTR_TPSZ_CD,' ') ," ).append("\n"); 
		query.append("NVL(A.PCK_QTY,0) , NVL(A.PCK_TP_CD,' ') ," ).append("\n"); 
		query.append("NVL(A.CNTR_WGT,0) , NVL(A.WGT_UT_CD,' ') ," ).append("\n"); 
		query.append("NVL(A.MEAS_QTY,0) , NVL(A.MEAS_UT_CD,' ')  ,C.BL_NO " ).append("\n"); 
		query.append("ORDER BY bl_no,NVL(A.CNTR_NO,' ') )" ).append("\n"); 

	}
}