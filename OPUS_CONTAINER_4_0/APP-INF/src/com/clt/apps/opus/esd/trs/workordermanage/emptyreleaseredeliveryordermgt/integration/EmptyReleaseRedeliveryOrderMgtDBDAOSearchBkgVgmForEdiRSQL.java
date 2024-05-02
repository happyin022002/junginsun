/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EmptyReleaseRedeliveryOrderMgtDBDAOSearchBkgVgmForEdiRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.10
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2016.06.10 박찬우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chanwoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyReleaseRedeliveryOrderMgtDBDAOSearchBkgVgmForEdiRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG VGM 데이터를 가져오는 SQL
	  * </pre>
	  */
	public EmptyReleaseRedeliveryOrderMgtDBDAOSearchBkgVgmForEdiRSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.integration").append("\n"); 
		query.append("FileName : EmptyReleaseRedeliveryOrderMgtDBDAOSearchBkgVgmForEdiRSQL").append("\n"); 
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
		query.append("SELECT MEAS," ).append("\n"); 
		query.append("       MEAS_UT," ).append("\n"); 
		query.append("       DOC_TP," ).append("\n"); 
		query.append("       CUST_CNTC_TP," ).append("\n"); 
		query.append("       CUST_EML" ).append("\n"); 
		query.append("  FROM (SELECT CNTR.VGM_WGT AS MEAS," ).append("\n"); 
		query.append("               SUBSTR(CNTR.WGT_UT_CD, 1, 1) AS MEAS_UT," ).append("\n"); 
		query.append("               'SM1' AS DOC_TP," ).append("\n"); 
		query.append("               DECODE(ESIG_CO_NM, NULL, NULL, 'RP') CUST_CNTC_TP," ).append("\n"); 
		query.append("               CUST_EML," ).append("\n"); 
		query.append("               ROW_NUMBER () OVER (PARTITION BY VGM.BKG_NO, VGM.CNTR_NO ORDER BY VGM.VGM_SEQ DESC) RNUM" ).append("\n"); 
		query.append("          FROM BKG_CONTAINER CNTR," ).append("\n"); 
		query.append("               BKG_XTER_VGM VGM" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND CNTR.BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("           AND CNTR.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("           AND CNTR.BKG_NO  = VGM.BKG_NO(+)" ).append("\n"); 
		query.append("           AND CNTR.CNTR_NO = VGM.CNTR_NO(+)" ).append("\n"); 
		query.append("           AND VGM.IF_FLG   ='Y'" ).append("\n"); 
		query.append("           AND VGM.UPLD_FLG ='Y' )" ).append("\n"); 
		query.append(" WHERE RNUM = 1" ).append("\n"); 

	}
}