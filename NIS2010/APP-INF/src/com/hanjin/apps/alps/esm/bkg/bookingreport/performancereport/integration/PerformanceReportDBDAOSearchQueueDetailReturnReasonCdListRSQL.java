/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchQueueDetailReturnReasonCdListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.11
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2011.04.11 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki Jong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchQueueDetailReturnReasonCdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAOSearchQueueDetailReturnRSQL
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchQueueDetailReturnReasonCdListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_his_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("reason_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("src_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchQueueDetailReturnReasonCdListRSQL").append("\n"); 
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
		query.append("SELECT COM.INTG_CD_VAL_CTNT CODE" ).append("\n"); 
		query.append("      ,COM.INTG_CD_VAL_DP_DESC NAME" ).append("\n"); 
		query.append("      ,RSN.SR_KND_CD" ).append("\n"); 
		query.append("      ,RSN.SR_NO" ).append("\n"); 
		query.append("      ,RSN.BKG_NO" ).append("\n"); 
		query.append("      ,RSN.SR_HIS_SEQ" ).append("\n"); 
		query.append("      ,RSN.SR_RTN_RSN_CD" ).append("\n"); 
		query.append("      ,RSN.CRE_USR_ID" ).append("\n"); 
		query.append("      ,RSN.CRE_DT" ).append("\n"); 
		query.append("      ,RSN.UPD_USR_ID" ).append("\n"); 
		query.append("      ,RSN.UPD_DT" ).append("\n"); 
		query.append("      ,'' REASON_TYPE" ).append("\n"); 
		query.append("      ,RSN.SR_KND_CD AS SRC_CD" ).append("\n"); 
		query.append("      ,CASE WHEN RSN.SR_RTN_RSN_CD IS NOT NULL THEN '1' ELSE '0' END AS  SEL" ).append("\n"); 
		query.append("FROM   BKG_SR_RTN_RSN  RSN" ).append("\n"); 
		query.append("RIGHT JOIN (SELECT * FROM COM_INTG_CD_DTL COM " ).append("\n"); 
		query.append("WHERE 1=1 " ).append("\n"); 
		query.append("AND   INTG_CD_ID = 'CD02805' " ).append("\n"); 
		query.append("#if (${reason_type} != '') " ).append("\n"); 
		query.append("AND   INTG_CD_VAL_CTNT LIKE @[reason_type] || '%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND   (APLY_ST_DT < TO_CHAR(SYSDATE, 'YYYYMMDD') AND		APLY_END_DT > TO_CHAR(SYSDATE, 'YYYYMMDD')) ) COM" ).append("\n"); 
		query.append("ON  	1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${src_cd} != '') " ).append("\n"); 
		query.append("AND   RSN.SR_KND_CD = @[src_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sr_no} != '') " ).append("\n"); 
		query.append("AND   RSN.SR_NO = @[sr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("AND   RSN.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sr_his_seq} != '') " ).append("\n"); 
		query.append("AND   RSN.SR_HIS_SEQ  = @[sr_his_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND   RSN.SR_HIS_SEQ  = '0'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND   RSN.SR_RTN_RSN_CD = COM.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("ORDER BY COM.INTG_CD_VAL_DP_SEQ" ).append("\n"); 

	}
}