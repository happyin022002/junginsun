/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOsearchcCurrentMvmtDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOsearchcCurrentMvmtDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 현재 movement 정보를 가지고 온다.
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOsearchcCurrentMvmtDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOsearchcCurrentMvmtDataRSQL").append("\n"); 
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
		query.append("WITH DT_CTM AS" ).append("\n"); 
		query.append("(SELECT /*+ INDEX_DESC( A XFN1CTM_MOVEMENT ) */" ).append("\n"); 
		query.append(" NVL(MAX(TO_CHAR(DECODE(TRUNC(CNMV_EVNT_DT),TO_DATE(REPLACE(@[cnmv_evnt_dt],'-'),'YYYYMMDD'),CNMV_EVNT_DT+0.0007,TO_DATE(REPLACE(@[cnmv_evnt_dt],'-'),'YYYYMMDD')),'YYYYMMDD HH24:MI')),TO_CHAR(TO_DATE(REPLACE(@[cnmv_evnt_dt],'-'),'YYYYMMDD'),'YYYYMMDD HH24:MI')) DT" ).append("\n"); 
		query.append(",@[cntr_no] CNTR_NO" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT A" ).append("\n"); 
		query.append("WHERE CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND   ROWNUM = 1)," ).append("\n"); 
		query.append("CRR_CTM AS" ).append("\n"); 
		query.append("(SELECT /*+ INDEX_DESC( A XFN1CTM_MOVEMENT ) */" ).append("\n"); 
		query.append("      CNTR_NO " ).append("\n"); 
		query.append("     ,MVMT_STS_CD" ).append("\n"); 
		query.append("     ,BKG_CGO_TP_CD" ).append("\n"); 
		query.append("     ,BKG_NO" ).append("\n"); 
		query.append("     ,BL_NO" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT A" ).append("\n"); 
		query.append("WHERE CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND   ROWNUM = 1)" ).append("\n"); 
		query.append("SELECT A.DT" ).append("\n"); 
		query.append("      ,B.*" ).append("\n"); 
		query.append(" FROM DT_CTM A, CRR_CTM B" ).append("\n"); 
		query.append(" WHERE A.CNTR_NO = B.CNTR_NO" ).append("\n"); 

	}
}