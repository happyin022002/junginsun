/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CgmEdiSendDBDAOUsCaPodBookingExportListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.09
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CgmEdiSendDBDAOUsCaPodBookingExportListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 오늘시점에서 어제 하루동안 생성된 bkg (export)  POL이 미주 및 캐나다 발
	  * </pre>
	  */
	public CgmEdiSendDBDAOUsCaPodBookingExportListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmedisend.integration").append("\n"); 
		query.append("FileName : CgmEdiSendDBDAOUsCaPodBookingExportListRSQL").append("\n"); 
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
		query.append("SELECT A.BKG_NO" ).append("\n"); 
		query.append("      ,'XP' IE_IND" ).append("\n"); 
		query.append("      ,'N' FINAL_IND" ).append("\n"); 
		query.append("FROM BKG_BOOKING   A" ).append("\n"); 
		query.append("    ,MDM_LOCATION  C" ).append("\n"); 
		query.append("WHERE A.BKG_CRE_DT BETWEEN TO_DATE(TO_CHAR(SYSDATE-1, 'YYYYMMDD'),'YYYYMMDD')+0.0 AND TO_DATE(TO_CHAR(SYSDATE-1, 'YYYYMMDD'),'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("AND   A.POL_CD = C.LOC_CD  " ).append("\n"); 
		query.append("AND   C.CNT_CD IN ('US', 'CA') -- 미주 POL" ).append("\n"); 
		query.append("AND   A.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("UNiON ALL" ).append("\n"); 
		query.append("SELECT A.BKG_NO" ).append("\n"); 
		query.append("      ,'XP' IE_IND" ).append("\n"); 
		query.append("      ,'Y' FINAL_IND" ).append("\n"); 
		query.append("FROM BKG_BOOKING A" ).append("\n"); 
		query.append("WHERE A.BKG_NO IN" ).append("\n"); 
		query.append("                   (" ).append("\n"); 
		query.append("                       SELECT DISTINCT A.BKG_NO" ).append("\n"); 
		query.append("                       FROM BKG_VVD A" ).append("\n"); 
		query.append("                           ,(   -- 내일 ETA SKD 검색(US, CA 도착)" ).append("\n"); 
		query.append("                                SELECT A.VSL_CD" ).append("\n"); 
		query.append("                                      ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("                                      ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("                                      ,A.VPS_PORT_CD" ).append("\n"); 
		query.append("                                      ,A.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                FROM VSK_ACT_PORT_SKD A" ).append("\n"); 
		query.append("                                    ,MDM_LOCATION C" ).append("\n"); 
		query.append("                                WHERE A.VPS_PORT_CD = C.LOC_CD      " ).append("\n"); 
		query.append("                                AND   A.ACT_DEP_DT BETWEEN TO_DATE(TO_CHAR(SYSDATE-1, 'YYYYMMDD'),'YYYYMMDD')+0.0 AND TO_DATE(TO_CHAR(SYSDATE-1, 'YYYYMMDD'),'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("                                AND   C.CNT_CD IN ('US', 'CA')" ).append("\n"); 
		query.append("                                AND   C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                           ) B" ).append("\n"); 
		query.append("                       WHERE A.VSL_CD           = B.VSL_CD" ).append("\n"); 
		query.append("                       AND   A.SKD_VOY_NO       = B.SKD_VOY_NO" ).append("\n"); 
		query.append("                       AND   A.SKD_DIR_CD       = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                       AND   A.POL_CLPT_IND_SEQ = B.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                       AND   A.POL_CD           = B.VPS_PORT_CD" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("AND A.BKG_STS_CD <> 'X'" ).append("\n"); 

	}
}