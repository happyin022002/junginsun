/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTCommDBDAODeductionTotalInfoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2010.02.22 이호진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTCommDBDAODeductionTotalInfoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_AGT_0012  화면의 DeductionTotalInfo 조회
	  * </pre>
	  */
	public AGTCommDBDAODeductionTotalInfoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration").append("\n"); 
		query.append("FileName : AGTCommDBDAODeductionTotalInfoVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("RATE_TYPE," ).append("\n"); 
		query.append("OFFICE_CD," ).append("\n"); 
		query.append("CUST_PAYER" ).append("\n"); 
		query.append("FROM (SELECT" ).append("\n"); 
		query.append("1 AS SEQ," ).append("\n"); 
		query.append("'PPD at' AS RATE_TYPE," ).append("\n"); 
		query.append("NVL(CLT_OFC_CD,' ') AS OFFICE_CD," ).append("\n"); 
		query.append("NVL(PPD_PAYR_CNT_CD,' ')||REPLACE(TO_CHAR(PPD_PAYR_CUST_SEQ,'FM000000'),'000000',' ') AS	CUST_PAYER" ).append("\n"); 
		query.append("FROM BKG_RATE" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("2 AS SEQ," ).append("\n"); 
		query.append("'CCT at'," ).append("\n"); 
		query.append("NVL(CLT_OFC_CD,' ')	AS OFFICE_CD," ).append("\n"); 
		query.append("NVL(CLT_PAYR_CNT_CD,' ')||REPLACE(TO_CHAR(CLT_PAYR_CUST_SEQ,'FM000000'),'000000',' ') AS	CUST_PAYER" ).append("\n"); 
		query.append("FROM BKG_RATE" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DISTINCT 3 AS SEQ," ).append("\n"); 
		query.append("'3rd	Party at'," ).append("\n"); 
		query.append("B.AR_OFC_CD AS OFFICE_CD," ).append("\n"); 
		query.append("NVL(N3PTY_CUST_CNT_CD,' ')||REPLACE(TO_CHAR(N3PTY_CUST_SEQ,'FM000000'),'000000',' ')	AS CUST_PAYER" ).append("\n"); 
		query.append("FROM BKG_CHG_RT A, AGT_AGN_COMM B" ).append("\n"); 
		query.append("WHERE A.BKG_NO		= @[bkg_no]" ).append("\n"); 
		query.append("AND A.BKG_NO =	B.BKG_NO" ).append("\n"); 
		query.append("AND A.PRN_HDN_FLG =	'N'" ).append("\n"); 
		query.append("AND A.CURR_CD = B.CURR_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE RTRIM(CUST_PAYER) IS	NOT	NULL" ).append("\n"); 

	}
}