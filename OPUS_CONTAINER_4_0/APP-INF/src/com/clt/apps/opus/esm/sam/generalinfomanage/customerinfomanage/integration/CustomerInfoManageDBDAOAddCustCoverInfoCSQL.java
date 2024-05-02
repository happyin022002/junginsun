/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CustomerInfoManageDBDAOAddCustCoverInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.05
*@LastModifier : 박찬민
*@LastVersion : 1.0
* 2011.08.05 박찬민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author PARK CHAN MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerInfoManageDBDAOAddCustCoverInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddCustCoverInfo
	  * </pre>
	  */
	public CustomerInfoManageDBDAOAddCustCoverInfoCSQL(){
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
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration").append("\n"); 
		query.append("FileName : CustomerInfoManageDBDAOAddCustCoverInfoCSQL").append("\n"); 
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
		query.append("INSERT INTO SAM_CUST_SLS_REP_INFO" ).append("\n"); 
		query.append("        (CUST_CNT_CD," ).append("\n"); 
		query.append("         CUST_SEQ," ).append("\n"); 
		query.append("         SREP_PRMRY_FLG," ).append("\n"); 
		query.append("         CRE_USR_ID," ).append("\n"); 
		query.append("         CRE_DT," ).append("\n"); 
		query.append("         UPD_USR_ID," ).append("\n"); 
		query.append("         UPD_DT," ).append("\n"); 
		query.append("         SREP_CD," ).append("\n"); 
		query.append("		 DELT_FLG," ).append("\n"); 
		query.append("		 DP_SEQ," ).append("\n"); 
		query.append("		 SREP_CUST_CLSS_CD" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("VALUES ( @[cust_cnt_cd]," ).append("\n"); 
		query.append("         TO_NUMBER(@[cust_seq])," ).append("\n"); 
		query.append("         @[srep_prmry_flg]," ).append("\n"); 
		query.append("         @[user_id]," ).append("\n"); 
		query.append("         SYSDATE," ).append("\n"); 
		query.append("         @[user_id]," ).append("\n"); 
		query.append("         SYSDATE," ).append("\n"); 
		query.append("         @[srep_cd]," ).append("\n"); 
		query.append("		 'N'," ).append("\n"); 
		query.append("		 '0'," ).append("\n"); 
		query.append("		 'S'" ).append("\n"); 
		query.append("         )" ).append("\n"); 

	}
}