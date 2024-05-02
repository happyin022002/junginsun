/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AGNCommRequestDBDAOSearchVIPDeductAmountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.26
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.26 
* 1.0 Creation
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

public class AGNCommRequestDBDAOSearchVIPDeductAmountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VIP Agreement별 공제 금액 조회.
	  * </pre>
	  */
	public AGNCommRequestDBDAOSearchVIPDeductAmountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_grp_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration").append("\n"); 
		query.append("FileName : AGNCommRequestDBDAOSearchVIPDeductAmountRSQL").append("\n"); 
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
		query.append("SELECT SUM(VIP_BKG_RT) AS VIP_BKG_RT" ).append("\n"); 
		query.append("FROM ACM_VIP_AGMT AGMT," ).append("\n"); 
		query.append("  ACM_VIP_AGMT_CNTR CNTR," ).append("\n"); 
		query.append("  BKG_CONTAINER BKG" ).append("\n"); 
		query.append("WHERE AGMT.CUST_GRP_ID = @[cust_grp_id]" ).append("\n"); 
		query.append("  AND AGMT.AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("  AND AGMT.CUST_GRP_ID = CNTR.CUST_GRP_ID" ).append("\n"); 
		query.append("  AND AGMT.AGMT_SEQ = CNTR.AGMT_SEQ" ).append("\n"); 
		query.append("  AND BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("  AND BKG.CNTR_TPSZ_CD = CNTR.CNTR_TPSZ_CD" ).append("\n"); 

	}
}