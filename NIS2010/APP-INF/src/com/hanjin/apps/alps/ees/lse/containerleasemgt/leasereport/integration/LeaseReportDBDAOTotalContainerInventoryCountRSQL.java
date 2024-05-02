/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LeaseReportDBDAOTotalContainerInventoryCountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.29
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.07.29 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Jun-Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LeaseReportDBDAOTotalContainerInventoryCountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * HJS의 관리하는 자가 및 임차장비의 상세 전체건수를 조회합니다.
	  * </pre>
	  */
	public LeaseReportDBDAOTotalContainerInventoryCountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.integration").append("\n"); 
		query.append("FileName : LeaseReportDBDAOTotalContainerInventoryCountRSQL").append("\n"); 
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
		query.append("SELECT  COUNT(*) AS TOTAL_CNT" ).append("\n"); 
		query.append("FROM    MST_CONTAINER A," ).append("\n"); 
		query.append("        LSE_AGREEMENT C            " ).append("\n"); 
		query.append("WHERE   A.CNTR_STS_CD NOT IN ('LSO','DIO','DON','SCR','TLL','SLD','SRO')" ).append("\n"); 
		query.append("AND     A.AGMT_CTY_CD = C.AGMT_CTY_CD        " ).append("\n"); 
		query.append("AND     A.AGMT_SEQ = C.AGMT_SEQ        " ).append("\n"); 
		query.append("AND     A.AGMT_SEQ <> 999990" ).append("\n"); 
		query.append("--AND     A.ONH_YD_CD <> 'KRSEL1H'" ).append("\n"); 
		query.append("AND     A.HJS_CRE_FLG = 'N'" ).append("\n"); 
		query.append("#if (${agmt_seq} != '')" ).append("\n"); 
		query.append("AND     A.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("AND     A.AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("AND     C.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("#end						" ).append("\n"); 
		query.append("#if (${loc_tp} == 'RCC')" ).append("\n"); 
		query.append("AND     A.RCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#elseif (${loc_tp} == 'LCC')" ).append("\n"); 
		query.append("AND     A.LCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#elseif (${loc_tp} == 'SCC')" ).append("\n"); 
		query.append("AND     A.SCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#end						  " ).append("\n"); 
		query.append("#if (${cnmv_sts_cd} != '')" ).append("\n"); 
		query.append("AND     A.CNMV_STS_CD IN (" ).append("\n"); 
		query.append("    #foreach($key IN ${cnmv_sts_cd_seq})" ).append("\n"); 
		query.append("        #if($velocityCount < $cnmv_sts_cd_seq.size())" ).append("\n"); 
		query.append("            '$key'," ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            '$key'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${lstm_cd} != '')" ).append("\n"); 
		query.append("AND     C.LSTM_CD IN (" ).append("\n"); 
		query.append("    #foreach($key IN ${lstm_cd_seq})" ).append("\n"); 
		query.append("        #if($velocityCount < $lstm_cd_seq.size())" ).append("\n"); 
		query.append("            '$key'," ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            '$key'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("AND     A.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("    #foreach($key IN ${cntr_tpsz_cd_seq})" ).append("\n"); 
		query.append("        #if($velocityCount < $cntr_tpsz_cd_seq.size())" ).append("\n"); 
		query.append("            '$key'," ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            '$key'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}