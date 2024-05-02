/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : AGNCommRequestDBDAOGetPpdCrntSpclAmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.22
*@LastModifier : 
*@LastVersion : 1.0
* 2013.10.22 
* 1.0 Creation
* 
* 2013.10.24 박다은 [CHM-201326610] Audit 화면 조회 오류, 로직 변경 요청 (LIMBA / GYEBA)
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommRequestDBDAOGetPpdCrntSpclAmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetPpdCrntSpclAmt
	  * 기 지급된 금액이 있는지 확인 하여 기 지급금 조회
	  * </pre>
	  */
	public AGNCommRequestDBDAOGetPpdCrntSpclAmtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("max_spcl_cmpn_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration").append("\n"); 
		query.append("FileName : AGNCommRequestDBDAOGetPpdCrntSpclAmtRSQL").append("\n"); 
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
		query.append("SELECT NVL(MAX(CRNT_AMT),0) AS PPD_CRNT_SPCL_AMT" ).append("\n"); 
		query.append("FROM   ACM_SPCL_CMPN" ).append("\n"); 
		query.append("WHERE  BKG_NO        = @[bkg_no]" ).append("\n"); 
		query.append("AND    SPCL_CMPN_SEQ = TO_NUMBER(@[max_spcl_cmpn_seq]) - 1" ).append("\n"); 

	}
}