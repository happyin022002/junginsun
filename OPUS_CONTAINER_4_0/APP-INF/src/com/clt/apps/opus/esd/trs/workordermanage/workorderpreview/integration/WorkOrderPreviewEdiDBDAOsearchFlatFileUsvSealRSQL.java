/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderPreviewEdiDBDAOsearchFlatFileUsvSealRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewEdiDBDAOsearchFlatFileUsvSealRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Seal
	  * </pre>
	  */
	public WorkOrderPreviewEdiDBDAOsearchFlatFileUsvSealRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewEdiDBDAOsearchFlatFileUsvSealRSQL").append("\n"); 
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
		query.append("SELECT T1.*" ).append("\n"); 
		query.append("  FROM (SELECT CNTR_SEAL_NO" ).append("\n"); 
		query.append("          FROM (SELECT SUBSTR(SEAL_KND_CD || SEAL_PTY_TP_CD || '-' || CNTR_SEAL_NO, 1, 15) AS CNTR_SEAL_NO" ).append("\n"); 
		query.append("                      ,ROW_NUMBER() OVER(ORDER BY SUBSTR(SEAL_KND_CD || SEAL_PTY_TP_CD || '-' || CNTR_SEAL_NO, 1, 15)) RK" ).append("\n"); 
		query.append("                  FROM BKG_CNTR_SEAL_NO S" ).append("\n"); 
		query.append("                 WHERE S.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                   AND S.CNTR_NO = @[cntr_no])" ).append("\n"); 
		query.append("         WHERE RK <= 3) T1" ).append("\n"); 
		query.append(" RIGHT OUTER JOIN DUAL" ).append("\n"); 
		query.append("    ON 1 = 1" ).append("\n"); 

	}
}