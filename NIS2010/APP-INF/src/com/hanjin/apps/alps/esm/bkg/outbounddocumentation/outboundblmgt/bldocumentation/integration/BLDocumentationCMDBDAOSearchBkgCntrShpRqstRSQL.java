/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BLDocumentationCMDBDAOSearchBkgCntrShpRqstRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.25
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2011.10.25 조원주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOSearchBkgCntrShpRqstRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BkgCntrShpRqst 조회
	  * </pre>
	  */
	public BLDocumentationCMDBDAOSearchBkgCntrShpRqstRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOSearchBkgCntrShpRqstRSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("    SHP.CNTR_NO," ).append("\n"); 
		query.append("    SHP.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("    SHP.CNTR_SEAL_NO," ).append("\n"); 
		query.append("    SUM(SHP.CNTR_VOL_QTY) CNTR_VOL_QTY," ).append("\n"); 
		query.append("    SUM(SHP.PCK_QTY) PCK_QTY," ).append("\n"); 
		query.append("    SHP.PCK_TP_CD," ).append("\n"); 
		query.append("    SUM(SHP.CNTR_WGT) CNTR_WGT," ).append("\n"); 
		query.append("    SUM(SHP.MEAS_QTY) MEAS_QTY" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" FROM BKG_CUST_SHP_RQST SHP" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append(" AND SHP.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append(" GROUP BY CNTR_NO,CNTR_TPSZ_CD,CNTR_SEAL_NO,PCK_TP_CD" ).append("\n"); 
		query.append(" ORDER BY CNTR_NO" ).append("\n"); 

	}
}