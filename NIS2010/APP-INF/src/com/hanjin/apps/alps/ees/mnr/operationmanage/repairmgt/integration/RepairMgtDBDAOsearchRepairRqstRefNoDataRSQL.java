/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RepairMgtDBDAOsearchRepairRqstRefNoDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.20
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.11.20 박명신
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author park myoung sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RepairMgtDBDAOsearchRepairRqstRefNoDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchRepairRqstRefNoData
	  * </pre>
	  */
	public RepairMgtDBDAOsearchRepairRqstRefNoDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.integration ").append("\n"); 
		query.append("FileName : RepairMgtDBDAOsearchRepairRqstRefNoDataRSQL").append("\n"); 
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
		query.append("SELECT @[rqst_ref_no] || '-' || TO_CHAR(SYSDATE, 'YYYYMM') || '-' ||" ).append("\n"); 
		query.append("DECODE(LENGTH(P.RQST_REF_NO),1,'000'||P.RQST_REF_NO," ).append("\n"); 
		query.append("DECODE(LENGTH(P.RQST_REF_NO),2,'00'||P.RQST_REF_NO," ).append("\n"); 
		query.append("DECODE(LENGTH(P.RQST_REF_NO),3,'0'||P.RQST_REF_NO," ).append("\n"); 
		query.append("P.RQST_REF_NO))) AS RQST_REF_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT NVL(MAX(TO_NUMBER(SUBSTRB(RQST_REF_NO,LENGTH(RQST_REF_NO)-3,LENGTH(RQST_REF_NO)))) + 1,1) AS RQST_REF_NO" ).append("\n"); 
		query.append("FROM MNR_RPR_RQST_HDR" ).append("\n"); 
		query.append("WHERE RQST_REF_NO LIKE @[rqst_ref_no] || '-' || TO_CHAR(SYSDATE, 'YYYYMM') || '-' || '%'" ).append("\n"); 
		query.append(") P" ).append("\n"); 

	}
}