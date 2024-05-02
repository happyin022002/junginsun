/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchOBLStsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.18
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOSearchOBLStsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회된 시점에 조회된 Original B/L 회수 여부와 발행통수 및  Detail정보를 조회한다.
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchOBLStsRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchOBLStsRSQL").append("\n"); 
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
		query.append("      TO_CHAR(BISS.OBL_ISS_DT,'YYYY-MM-DD HH24:MI')              AS OBL_ISS_DT  " ).append("\n"); 
		query.append("     , BISS.OBL_ISS_OFC_CD                                       AS OBL_ISS_OFC_CD" ).append("\n"); 
		query.append("     , BISS.OBL_ISS_USR_ID                                       AS OBL_ISS_USR_ID" ).append("\n"); 
		query.append("     , NVL(BISS.OBL_ISS_TP_CD, 'B')                              AS OBL_ISS_TP_CD           " ).append("\n"); 
		query.append("     , BISS.OBL_ISS_KNT                                          AS OBL_ISS_KNT" ).append("\n"); 
		query.append("     , BISS.OBL_RDEM_OFC_CD                                      AS OBL_RDEM_OFC_CD" ).append("\n"); 
		query.append("     , BISS.OBL_RDEM_USR_ID                                      AS OBL_RDEM_USR_ID" ).append("\n"); 
		query.append("     , BISS.OBL_RDEM_UPD_USR_ID                                  AS OBL_RDEM_UPD_USR_ID" ).append("\n"); 
		query.append("     , TO_CHAR(BISS.OBL_RDEM_DT,'YYYY-MM-DD HH24:MI')            AS OBL_RDEM_DT         " ).append("\n"); 
		query.append("     , BISS.OBL_RDEM_KNT                                         AS OBL_RDEM_KNT" ).append("\n"); 
		query.append("     , BISS.OTR_DOC_CGOR_FLG                                     AS OTR_DOC_CGOR_FLG" ).append("\n"); 
		query.append("     , BISS.BL_OTR_DOC_RCV_CD                                    AS BL_OTR_DOC_RCV_CD" ).append("\n"); 
		query.append("     , BISS.OTR_DOC_RCV_OFC_CD                                   AS OTR_DOC_RCV_OFC_CD" ).append("\n"); 
		query.append("     , BISS.OTR_DOC_RCV_USR_ID                                   AS OTR_DOC_RCV_USR_ID" ).append("\n"); 
		query.append("     , TO_CHAR(BISS.OTR_DOC_RCV_DT,'YYYY-MM-DD HH24:MI')         AS OTR_DOC_RCV_DT         " ).append("\n"); 
		query.append("     , BISS.IBD_DOC_RCV_FLG                                      AS IBD_DOC_RCV_FLG" ).append("\n"); 
		query.append("     , BISS.IBD_DOC_RCV_OFC_CD                                   AS IBD_DOC_RCV_OFC_CD" ).append("\n"); 
		query.append("     , BISS.IBD_DOC_RCV_USR_ID                                   AS IBD_DOC_RCV_USR_ID" ).append("\n"); 
		query.append("     , TO_CHAR(BISS.IBD_DOC_RCV_DT, 'YYYY-MM-DD HH24:MI')        AS IBD_DOC_RCV_DT           " ).append("\n"); 
		query.append("     , BISS.OBL_TTL_KNT                                          AS OBL_TTL_KNT" ).append("\n"); 
		query.append("     , BISS.BL_CPY_KNT                                           AS OBL_CPY_KNT                 " ).append("\n"); 
		query.append("     , DECODE(BISS.OBL_SRND_FLG,'Y','S', NVL(BKGM.BL_TP_CD,'B')) AS BL_TP_CD" ).append("\n"); 
		query.append("     , SUBSTR(BKGM.DEL_CD, 1,2)      AS DEL_CNT_CD  " ).append("\n"); 
		query.append("     , DECODE ( BKGM.BL_TP_CD" ).append("\n"); 
		query.append("                ,'W','Y'" ).append("\n"); 
		query.append("                ,DECODE( BISS.OBL_SRND_FLG" ).append("\n"); 
		query.append("                         ,'Y','Y'" ).append("\n"); 
		query.append("                         , DECODE(BISS.OBL_RDEM_FLG,'Y','Y','N')" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("              )          AS OBL_RDEM_FLG" ).append("\n"); 
		query.append("    , BKGM.BKG_NO AS BKG_NO" ).append("\n"); 
		query.append("FROM BKG_BOOKING BKGM" ).append("\n"); 
		query.append("     LEFT OUTER JOIN BKG_BL_ISS BISS" ).append("\n"); 
		query.append("        ON ( BISS.BKG_NO = BKGM.BKG_NO )   " ).append("\n"); 
		query.append("WHERE BKGM.BKG_NO =@[bkg_no]" ).append("\n"); 

	}
}