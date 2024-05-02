/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CustomerEdiDBDAOSearchPerCsInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.19
*@LastModifier : 
*@LastVersion : 1.0
* 2013.03.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerEdiDBDAOSearchPerCsInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchPerCsInfo
	  * </pre>
	  */
	public CustomerEdiDBDAOSearchPerCsInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cs_grp_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.integration").append("\n"); 
		query.append("FileName : CustomerEdiDBDAOSearchPerCsInfoRSQL").append("\n"); 
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
		query.append("SELECT CS_GRP_ID" ).append("\n"); 
		query.append(", TP_ID" ).append("\n"); 
		query.append(", CS_DESC" ).append("\n"); 
		query.append(", SUBSTR(MAX (SYS_CONNECT_BY_PATH (CUST_CD, ',')), 2) CUST_CD" ).append("\n"); 
		query.append(", SUBSTR(MAX (SYS_CONNECT_BY_PATH (STND_CD, ',')), 2) EDI_STS" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A.CS_GRP_ID, A.TP_ID, A.CS_DESC, A.STND_CD, A.CUST_CD , ROWNUM RNUM" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT  /*+ ORDERED USE_NL( GRP CGO STS) */" ).append("\n"); 
		query.append("DISTINCT GRP.EDI_GRP_CD CS_GRP_ID" ).append("\n"); 
		query.append(", GRP.CUST_TRD_PRNR_ID TP_ID" ).append("\n"); 
		query.append(", GRP.EDI_GRP_DESC CS_DESC" ).append("\n"); 
		query.append(", CGO.EDI_STND_STS_CD  STND_CD" ).append("\n"); 
		query.append(", STS.EDI_STS_SEQ" ).append("\n"); 
		query.append(", 1 CUST_CD" ).append("\n"); 
		query.append("FROM EDI_GROUP GRP, EDI_GRP_CGO CGO, EDI_CGO_STND_STS STS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("1=1" ).append("\n"); 
		query.append("#if(${cs_grp_id} != '')" ).append("\n"); 
		query.append("AND GRP.EDI_GRP_CD = @[cs_grp_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND GRP.EDI_GRP_CD = CGO.EDI_GRP_CD" ).append("\n"); 
		query.append("AND GRP.CO_DIV_CD = CGO.CO_DIV_CD" ).append("\n"); 
		query.append("AND STS.EDI_STND_STS_CD = CGO.EDI_STND_STS_CD" ).append("\n"); 
		query.append("ORDER BY    STS.EDI_STS_SEQ" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("START WITH RNUM = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR RNUM = RNUM - 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY CS_GRP_ID" ).append("\n"); 
		query.append(", TP_ID" ).append("\n"); 
		query.append(", CS_DESC" ).append("\n"); 

	}
}