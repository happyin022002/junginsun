/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EmptyReleaseRedeliveryOrderMgtDBDAOSearchBkgRfCgoforEdiRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.09
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyReleaseRedeliveryOrderMgtDBDAOSearchBkgRfCgoforEdiRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_RF_CGO 테이블에서 EDI로 전송할 정보를 조회한다
	  * </pre>
	  */
	public EmptyReleaseRedeliveryOrderMgtDBDAOSearchBkgRfCgoforEdiRSQL(){
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
		query.append("Path : com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.integration").append("\n"); 
		query.append("FileName : EmptyReleaseRedeliveryOrderMgtDBDAOSearchBkgRfCgoforEdiRSQL").append("\n"); 
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
		query.append("SELECT FDO_TEMP" ).append("\n"); 
		query.append("      ,CDO_TEMP" ).append("\n"); 
		query.append("      ,VLTG_NO" ).append("\n"); 
		query.append("      ,HUMID_NO" ).append("\n"); 
		query.append("      ,REPLACE ( REPLACE (DIFF_RMK, CHR(13), ' '), CHR(10),' ') AS DIFF_RMK" ).append("\n"); 
		query.append("      ,CNTR_DRN_CD" ).append("\n"); 
		query.append("	  ,PWR_SPL_CBL_FLG" ).append("\n"); 
		query.append("	  ,CNTR_VENT_TP_CD" ).append("\n"); 
		query.append("	  ,VENT_RTO" ).append("\n"); 
		query.append("	  ,CBM_PER_HR_QTY  AS      VENT_CMH" ).append("\n"); 
		query.append("  FROM BKG_RF_CGO" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if (${cntr_no} != '')" ).append("\n"); 
		query.append("   AND CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}