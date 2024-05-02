/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BangladeshCustomsReportDBDAOsearchCustomerNmRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier :
*@LastVersion : 1.0
* 2009.10.13
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.bangladesh.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BangladeshCustomsReportDBDAOsearchCustomerNmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * customer name을 가져오는 쿼리
	  * </pre>
	  */
	public BangladeshCustomsReportDBDAOsearchCustomerNmRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_grid_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.bangladesh.integration").append("\n");
		query.append("FileName : BangladeshCustomsReportDBDAOsearchCustomerNmRSQL").append("\n");
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
		query.append("SELECT CUST_CNT_CD||TRIM(TO_CHAR(CUST_SEQ,'000000')) CUST_CD," ).append("\n");
		query.append("CUST_LGL_ENG_NM CUST_NM," ).append("\n");
		query.append("( SELECT COUNT(*)" ).append("\n");
		query.append("FROM BKG_CSTMS_BD_FRT_FWRD_LIC" ).append("\n");
		query.append("WHERE CNT_CD = SUBSTR(@[cust_grid_cd],1,2)" ).append("\n");
		query.append("AND CUST_SEQ = TO_NUMBER(SUBSTR(@[cust_grid_cd],3))) CUST_CNT" ).append("\n");
		query.append("FROM MDM_CUSTOMER" ).append("\n");
		query.append("WHERE CUST_CNT_CD = SUBSTR(@[cust_grid_cd],1,2)" ).append("\n");
		query.append("AND CUST_SEQ = TO_NUMBER(SUBSTR(@[cust_grid_cd],3))" ).append("\n");

	}
}