/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LeaseReportDBDAOsearchNewContainerReceivingDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.28
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2010.01.28 진준성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jin Jun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LeaseReportDBDAOsearchNewContainerReceivingDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 신조장비여부를 확인하기위한 컨테이너 리스트 조회
	  * </pre>
	  */
	public LeaseReportDBDAOsearchNewContainerReceivingDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("period_eddt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sn_num_range2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sn_num_range1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sn_eng_range1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("report_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("period_stdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sn_eng_range2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.integration").append("\n"); 
		query.append("FileName : LeaseReportDBDAOsearchNewContainerReceivingDetailRSQL").append("\n"); 
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
		query.append("select /*+ INDEX( A XFN1MST_CONTAINER) */" ).append("\n"); 
		query.append("    A.CNTR_NO CNTRNO," ).append("\n"); 
		query.append("    A.HJS_CRE_FLG ACT," ).append("\n"); 
		query.append("    A.CNTR_TPSZ_CD TYSZ," ).append("\n"); 
		query.append("    TO_CHAR(A.ONH_DT,'yyyy-mm-dd') RCIVE_DT ," ).append("\n"); 
		query.append("    A.ONH_YD_CD YARD" ).append("\n"); 
		query.append("from MST_CONTAINER A " ).append("\n"); 
		query.append("where A.LSTM_CD IN ('LP', 'OW', 'OL')" ).append("\n"); 
		query.append("AND SUBSTR(A.CNTR_NO, 0 , 10 ) BETWEEN @[sn_eng_range1] || LTRIM(TO_CHAR(@[sn_num_range1],'000000'))  AND @[sn_eng_range2] || LTRIM(TO_CHAR(@[sn_num_range2],'000000'))" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${period_eddt} != '' )" ).append("\n"); 
		query.append("AND A.ONH_DT BETWEEN to_date(@[period_stdt] ,'yyyymmdd') AND to_date(@[period_eddt],'yyyymmdd')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${report_type} != '' )" ).append("\n"); 
		query.append("AND A.HJS_CRE_FLG = @[report_type]  -- 'N' = Received, 'Y' = Not Receiving" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd_str} != '' )" ).append("\n"); 
		query.append("AND   A.CNTR_TPSZ_CD IN( #foreach($key IN ${cntr_tpsz_cd})" ).append("\n"); 
		query.append("                             #if($velocityCount < $cntr_tpsz_cd.size())" ).append("\n"); 
		query.append("                                 '$key'," ).append("\n"); 
		query.append("                             #else" ).append("\n"); 
		query.append("                                 '$key'" ).append("\n"); 
		query.append("                             #end" ).append("\n"); 
		query.append("                         #end )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.CNTR_NO" ).append("\n"); 

	}
}