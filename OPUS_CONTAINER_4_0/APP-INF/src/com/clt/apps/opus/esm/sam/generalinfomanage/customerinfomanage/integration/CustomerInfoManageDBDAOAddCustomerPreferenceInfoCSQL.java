/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CustomerInfoManageDBDAOAddCustomerPreferenceInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.13
*@LastModifier : 박찬민
*@LastVersion : 1.0
* 2011.06.13 박찬민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Chan Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerInfoManageDBDAOAddCustomerPreferenceInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddCustomerPreferenceInfo
	  * </pre>
	  */
	public CustomerInfoManageDBDAOAddCustomerPreferenceInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prf_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prf_fm_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prf_to_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prf_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prf_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration").append("\n"); 
		query.append("FileName : CustomerInfoManageDBDAOAddCustomerPreferenceInfoCSQL").append("\n"); 
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
		query.append("INSERT INTO SAM_CUST_PRF_INFO" ).append("\n"); 
		query.append("(CUST_CNT_CD," ).append("\n"); 
		query.append("CUST_SEQ," ).append("\n"); 
		query.append("CUST_PRF_SEQ," ).append("\n"); 
		query.append("PRF_CATE_CD," ).append("\n"); 
		query.append("PRF_MOD_CD," ).append("\n"); 
		query.append("PRF_FM_LOC_CD," ).append("\n"); 
		query.append("PRF_TO_LOC_CD," ).append("\n"); 
		query.append("PRF_VNDR_SEQ," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES  (" ).append("\n"); 
		query.append("@[cust_cnt_cd]," ).append("\n"); 
		query.append("TO_NUMBER(@[cust_seq])," ).append("\n"); 
		query.append("NVL((SELECT MAX(CUST_PRF_SEQ)+1" ).append("\n"); 
		query.append("FROM SAM_CUST_PRF_INFO" ).append("\n"); 
		query.append("WHERE CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("AND CUST_SEQ = TO_NUMBER(@[cust_seq])" ).append("\n"); 
		query.append("GROUP BY CUST_CNT_CD,CUST_SEQ ),1)," ).append("\n"); 
		query.append("@[prf_cate_cd]," ).append("\n"); 
		query.append("@[prf_mod_cd]," ).append("\n"); 
		query.append("@[prf_fm_loc_cd]," ).append("\n"); 
		query.append("@[prf_to_loc_cd]," ).append("\n"); 
		query.append("@[prf_vndr_seq]," ).append("\n"); 
		query.append("@[user_id]," ).append("\n"); 
		query.append("@[user_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}