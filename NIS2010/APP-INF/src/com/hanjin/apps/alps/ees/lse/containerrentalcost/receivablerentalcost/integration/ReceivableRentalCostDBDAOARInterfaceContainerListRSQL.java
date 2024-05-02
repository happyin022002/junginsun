/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ReceivableRentalCostDBDAOARInterfaceContainerListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.04
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.01.04 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Jun-Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceivableRentalCostDBDAOARInterfaceContainerListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice 자료의 AR Interface Container 정보를 조회합니다.
	  * </pre>
	  */
	public ReceivableRentalCostDBDAOARInterfaceContainerListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.integration").append("\n"); 
		query.append("FileName : ReceivableRentalCostDBDAOARInterfaceContainerListRSQL").append("\n"); 
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
		query.append("SELECT  ROWNUM AS CNTR_SEQ," ).append("\n"); 
		query.append("CNTR_NO," ).append("\n"); 
		query.append("CNTR_TPSZ_CD," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("SYSDATE AS CRE_DT," ).append("\n"); 
		query.append("CRE_USR_ID AS UPD_USR_ID," ).append("\n"); 
		query.append("SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("FROM   (SELECT  DISTINCT B.CNTR_NO, B.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("@[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("FROM    LSE_RCV_RNTL_CHG A," ).append("\n"); 
		query.append("LSE_RCV_RNTL_CHG_DTL B" ).append("\n"); 
		query.append("WHERE   A.COST_YRMON = B.COST_YRMON" ).append("\n"); 
		query.append("AND     A.AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND     A.AGMT_SEQ = B.AGMT_SEQ" ).append("\n"); 
		query.append("AND     A.RCV_RNTL_SEQ = B.RCV_RNTL_SEQ" ).append("\n"); 
		query.append("AND     A.COST_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("AND		A.INV_NO IS NULL" ).append("\n"); 
		query.append("#if (${rcv_rntl_seq} != \"\")" ).append("\n"); 
		query.append("AND     A.RCV_RNTL_SEQ IN (" ).append("\n"); 
		query.append("#foreach($key IN ${rcv_rntl_no_seq})" ).append("\n"); 
		query.append("#if($velocityCount < $rcv_rntl_no_seq.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}