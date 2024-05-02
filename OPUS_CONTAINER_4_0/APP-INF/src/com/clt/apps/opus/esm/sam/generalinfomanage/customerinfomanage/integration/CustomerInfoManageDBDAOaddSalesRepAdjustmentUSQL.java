/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CustomerInfoManageDBDAOaddSalesRepAdjustmentUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.06
*@LastModifier : 
*@LastVersion : 1.0
* 2012.03.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerInfoManageDBDAOaddSalesRepAdjustmentUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customer의 담당 Sales REp 변경 정보를 저장한다.
	  * </pre>
	  */
	public CustomerInfoManageDBDAOaddSalesRepAdjustmentUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srep_prmry_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration").append("\n"); 
		query.append("FileName : CustomerInfoManageDBDAOaddSalesRepAdjustmentUSQL").append("\n"); 
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
		query.append("MERGE INTO SAM_CUST_SLS_REP_INFO A" ).append("\n"); 
		query.append("USING (SELECT SUBSTR(@[cust_cd],1,2) CUST_CNT_CD,to_number(substr(@[cust_cd],3))  CUST_SEQ, @[srep_cd] SREP_CD" ).append("\n"); 
		query.append("         FROM DUAL" ).append("\n"); 
		query.append("      ) B" ).append("\n"); 
		query.append("ON (    A.CUST_CNT_CD = B.CUST_CNT_CD" ).append("\n"); 
		query.append("    AND A.CUST_SEQ    = B.CUST_SEQ" ).append("\n"); 
		query.append("    AND A.SREP_CD     = B.SREP_CD" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET UPD_USR_ID     = @[user_id]," ).append("\n"); 
		query.append("           SREP_PRMRY_FLG = @[srep_prmry_flg]," ).append("\n"); 
		query.append("           UPD_DT         = SYSDATE," ).append("\n"); 
		query.append("           DELT_FLG       = 'N'" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (CUST_CNT_CD,CUST_SEQ,SREP_CD,SREP_PRMRY_FLG,CRE_USR_ID,CRE_DT,UPD_USR_ID,UPD_DT,DELT_FLG,DP_SEQ,SREP_CUST_CLSS_CD)" ).append("\n"); 
		query.append("VALUES (substr(@[cust_cd],1,2),to_number(substr(@[cust_cd],3)),@[srep_cd],@[srep_prmry_flg],@[user_id],sysdate,@[user_id],SYSDATE,'N',0,'')" ).append("\n"); 

	}
}