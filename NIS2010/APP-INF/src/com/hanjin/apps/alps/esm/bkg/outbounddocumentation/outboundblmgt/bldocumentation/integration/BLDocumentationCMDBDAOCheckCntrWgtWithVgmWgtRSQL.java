/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLDocumentationCMDBDAOCheckCntrWgtWithVgmWgtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOCheckCntrWgtWithVgmWgtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CNTR의 WGT와 VGM의 WGT 값 비교
	  * </pre>
	  */
	public BLDocumentationCMDBDAOCheckCntrWgtWithVgmWgtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_wgt",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOCheckCntrWgtWithVgmWgtRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN 'R' <> (SELECT BKG_CGO_TP_CD FROM BKG_BOOKING WHERE BKG_NO = CNTR.BKG_NO) " ).append("\n"); 
		query.append("                 AND (" ).append("\n"); 
		query.append("						(NVL(CNTR.CNTR_WGT,0) = 0 OR CNTR.WGT_UT_CD IS NULL) " ).append("\n"); 
		query.append("						OR (NVL(CNTR.CNTR_WGT,0) < NVL(@[vgm_wgt],0))" ).append("\n"); 
		query.append("					 )" ).append("\n"); 
		query.append("                 THEN 'Y'" ).append("\n"); 
		query.append("            WHEN ('R' = (SELECT BKG_CGO_TP_CD FROM BKG_BOOKING WHERE BKG_NO = CNTR.BKG_NO) OR CNTR.CNTR_TPSZ_CD IN ('T2','T4'))" ).append("\n"); 
		query.append("                 AND (" ).append("\n"); 
		query.append("						(NVL(CNTR.CNTR_WGT,0) = 0 OR CNTR.WGT_UT_CD IS NULL) " ).append("\n"); 
		query.append("                 		OR (NVL(CNTR.CNTR_WGT,0) <= NVL(@[vgm_wgt],0))" ).append("\n"); 
		query.append("					 )    " ).append("\n"); 
		query.append("                 THEN 'Y' ELSE 'N' END FLG " ).append("\n"); 
		query.append("FROM BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND CNTR_NO = @[cntr_no]" ).append("\n"); 

	}
}