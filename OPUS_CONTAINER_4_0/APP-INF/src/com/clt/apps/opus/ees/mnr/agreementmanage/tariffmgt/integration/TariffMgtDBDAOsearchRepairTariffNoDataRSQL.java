/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TariffMgtDBDAOsearchRepairTariffNoDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.10.28 김완규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author WanGyu Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TariffMgtDBDAOsearchRepairTariffNoDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public TariffMgtDBDAOsearchRepairTariffNoDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_trf_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.integration").append("\n"); 
		query.append("FileName : TariffMgtDBDAOsearchRepairTariffNoDataRSQL").append("\n"); 
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
		query.append("SELECT P2.PRE_TRF_NO||" ).append("\n"); 
		query.append("DECODE(LENGTH(POST_TRF_NO)," ).append("\n"); 
		query.append("1,'00'||P2.POST_TRF_NO," ).append("\n"); 
		query.append("2,'0'||P2.POST_TRF_NO," ).append("\n"); 
		query.append("P2.POST_TRF_NO)  TRF_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT P.PRE_TRF_NO" ).append("\n"); 
		query.append(",TO_CHAR(NVL(MAX(TO_NUMBER(SUBSTR(A.TRF_NO,LENGTH(A.TRF_NO)-2))),0)+1) POST_TRF_NO" ).append("\n"); 
		query.append("FROM MNR_RPR_TRF_HDR A," ).append("\n"); 
		query.append("( SELECT @[pre_trf_no]||TO_CHAR(SYSDATE,'YYYYMM')||'-'  PRE_TRF_NO" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(") P" ).append("\n"); 
		query.append("WHERE A.TRF_NO LIKE P.PRE_TRF_NO||'%'" ).append("\n"); 
		query.append(") P2" ).append("\n"); 

	}
}