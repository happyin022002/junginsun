/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PerformanceReportDBDAOBlCaDetailListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.24
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.11.24 강동윤
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kang dong yun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOBlCaDetailListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public PerformanceReportDBDAOBlCaDetailListVORSQL(){
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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("corr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOBlCaDetailListVORSQL").append("\n"); 
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
		query.append("SELECT CORR_OFC_CD" ).append("\n"); 
		query.append(",CORR_USR_ID" ).append("\n"); 
		query.append(",(SELECT USR_EML FROM COM_USER WHERE USR_ID = CORR_USR_ID) USR_EML" ).append("\n"); 
		query.append(",TO_CHAR(CORR_DT,'YYYY-MM-DD HH:MI:SS') CORR_DT" ).append("\n"); 
		query.append(",CORR_NO" ).append("\n"); 
		query.append(",BKG_NO" ).append("\n"); 
		query.append(",'' HIS_CATE_NM" ).append("\n"); 
		query.append(",'' PRE_CTNT" ).append("\n"); 
		query.append(",'' CRNT_CTNT" ).append("\n"); 
		query.append(",'' TITLE" ).append("\n"); 
		query.append(",'' CONTENT" ).append("\n"); 
		query.append("FROM BKG_CORRECTION" ).append("\n"); 
		query.append("WHERE CORR_NO <> '0000000001'" ).append("\n"); 
		query.append("AND CORR_CXL_FLG = 'N'" ).append("\n"); 
		query.append("#if (${bkg_no} != '')" ).append("\n"); 
		query.append("AND BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${corr_no} != '')" ).append("\n"); 
		query.append("AND CORR_NO = @[corr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("AND BKG_NO = (SELECT BKG_NO FROM BKG_BOOKING WHERE BL_NO = @[bl_no])" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}