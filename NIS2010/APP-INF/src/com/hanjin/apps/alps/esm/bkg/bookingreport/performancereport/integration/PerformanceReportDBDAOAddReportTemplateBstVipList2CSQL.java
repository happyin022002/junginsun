/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PerformanceReportDBDAOAddReportTemplateBstVipList2CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.22
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.12.22 김경섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOAddReportTemplateBstVipList2CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Report Template Default Detail Add
	  * </pre>
	  */
	public PerformanceReportDBDAOAddReportTemplateBstVipList2CSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("modified_col_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_rpt_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpt_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOAddReportTemplateBstVipList2CSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_RPT_DFLT_DTL" ).append("\n"); 
		query.append("( TBL_NM        , COL_NM           ,  RPT_ID       , BKG_RPT_KND_CD ,  ORD_SEQ ," ).append("\n"); 
		query.append("CRE_USR_ID    , CRE_DT           , UPD_USR_ID    , UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("BKG_GET_TOKEN_FNC(C_VALUE,1,'>') , BKG_GET_TOKEN_FNC(C_VALUE,2,'>') ,  RPT_ID        , BKG_RPT_KND_CD , ROWNUM ," ).append("\n"); 
		query.append("UPD_USR_ID    , UPD_DT           , UPD_USR_ID    , UPD_DT" ).append("\n"); 
		query.append("FROM ( SELECT COLUMN_VALUE C_VALUE" ).append("\n"); 
		query.append(", @[rpt_id]         RPT_ID" ).append("\n"); 
		query.append(", @[bkg_rpt_knd_cd] BKG_RPT_KND_CD" ).append("\n"); 
		query.append(", @[upd_usr_id]     UPD_USR_ID" ).append("\n"); 
		query.append(", SYSDATE           UPD_DT" ).append("\n"); 
		query.append("FROM table(BKG_SPLIT_FNC(@[modified_col_nm],'|'))" ).append("\n"); 
		query.append("WHERE COLUMN_VALUE IS NOT NULl" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}