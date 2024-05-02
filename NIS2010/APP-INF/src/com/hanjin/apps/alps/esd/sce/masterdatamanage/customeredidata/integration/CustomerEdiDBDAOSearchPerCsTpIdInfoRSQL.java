/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustomerEdiDBDAOSearchPerCsTpIdInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.28
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.01.28 이윤정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee YounJung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerEdiDBDAOSearchPerCsTpIdInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchPerCsTpIdInfo
	  * </pre>
	  */
	public CustomerEdiDBDAOSearchPerCsTpIdInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tp_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.integration ").append("\n"); 
		query.append("FileName : CustomerEdiDBDAOSearchPerCsTpIdInfoRSQL").append("\n"); 
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
		query.append("SELECT CS_GRP_ID ," ).append("\n"); 
		query.append("TP_ID ," ).append("\n"); 
		query.append("CS_DESC ," ).append("\n"); 
		query.append("ltrim(max(sys_connect_by_path(STND_CD, ','))) LT_EDI_STS," ).append("\n"); 
		query.append("ltrim(max(sys_connect_by_path(CUST_CD, ','))) LT_CUST_CD," ).append("\n"); 
		query.append("SUBSTR(ltrim(max(sys_connect_by_path(STND_CD, ','))), 2) EDI_STS," ).append("\n"); 
		query.append("SUBSTR(ltrim(max(sys_connect_by_path(CUST_CD, ','))), 2) CUST_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DISTINCT GRP.EDI_GRP_CD CS_GRP_ID ," ).append("\n"); 
		query.append("GRP.CUST_TRD_PRNR_ID TP_ID ," ).append("\n"); 
		query.append("GRP.EDI_GRP_DESC CS_DESC ," ).append("\n"); 
		query.append("CGO.EDI_STND_STS_CD STND_CD ," ).append("\n"); 
		query.append("STS.EDI_STS_SEQ ," ).append("\n"); 
		query.append("CGO.CUST_EDI_STS_CD CUST_CD," ).append("\n"); 
		query.append("ROW_NUMBER() OVER (PARTITION BY GRP.EDI_GRP_CD--, GRP.CUST_TRD_PRNR_ID, GRP.EDI_GRP_DESC" ).append("\n"); 
		query.append("ORDER BY sts.EDI_STS_SEQ) as CURR," ).append("\n"); 
		query.append("ROW_NUMBER() OVER (PARTITION BY GRP.EDI_GRP_CD--, GRP.CUST_TRD_PRNR_ID, GRP.EDI_GRP_DESC" ).append("\n"); 
		query.append("ORDER BY sts.EDI_STS_SEQ) - 1 as PREV" ).append("\n"); 
		query.append("FROM EDI_GROUP GRP," ).append("\n"); 
		query.append("EDI_GRP_CGO CGO," ).append("\n"); 
		query.append("EDI_CGO_STND_STS STS" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if(${tp_id} != '')" ).append("\n"); 
		query.append("AND GRP.CUST_TRD_PRNR_ID = @[tp_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND GRP.EDI_GRP_CD = CGO.EDI_GRP_CD" ).append("\n"); 
		query.append("AND GRP.CO_DIV_CD = CGO.CO_DIV_CD" ).append("\n"); 
		query.append("AND STS.EDI_STND_STS_CD = CGO.EDI_STND_STS_CD" ).append("\n"); 
		query.append("ORDER BY STS.EDI_STS_SEQ ) A" ).append("\n"); 
		query.append("group by CS_GRP_ID, TP_ID, CS_DESC" ).append("\n"); 
		query.append("CONNECT BY PREV = PRIOR CURR   AND CS_GRP_ID = PRIOR CS_GRP_ID" ).append("\n"); 
		query.append("start with curr = 1" ).append("\n"); 
		query.append("order by 1" ).append("\n"); 
		query.append("--The End of SQL" ).append("\n"); 

	}
}