/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CustomerInfoManageDBDAOAddCustHisListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.09
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2012.03.09 서미진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chloe Mijin SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerInfoManageDBDAOAddCustHisListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddCustHisList
	  * </pre>
	  */
	public CustomerInfoManageDBDAOAddCustHisListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("a_new_val_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("a_cng_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("a_old_val_desc",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration").append("\n"); 
		query.append("FileName : CustomerInfoManageDBDAOAddCustHisListCSQL").append("\n"); 
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
		query.append("INSERT INTO SAM_CUST_HIS" ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("                CUST_CNT_CD," ).append("\n"); 
		query.append("                CUST_SEQ," ).append("\n"); 
		query.append("                CUST_HIS_SEQ," ).append("\n"); 
		query.append("                CNG_ITM_CD," ).append("\n"); 
		query.append("                OLD_VAL_DESC," ).append("\n"); 
		query.append("                NEW_VAL_DESC," ).append("\n"); 
		query.append("                UPD_USR_ID," ).append("\n"); 
		query.append("                UPD_DT," ).append("\n"); 
		query.append("                CRE_USR_ID," ).append("\n"); 
		query.append("                CRE_DT" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("     VALUES" ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("                SUBSTR(@[cust_cd],1,2)," ).append("\n"); 
		query.append("                TO_NUMBER(SUBSTR(@[cust_cd],3,6)),                " ).append("\n"); 
		query.append("                NVL((SELECT " ).append("\n"); 
		query.append("                            MAX(CUST_HIS_SEQ)+1" ).append("\n"); 
		query.append("                       FROM" ).append("\n"); 
		query.append("                            SAM_CUST_HIS" ).append("\n"); 
		query.append("                      WHERE CUST_CNT_CD = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("                        AND CUST_SEQ = TO_NUMBER(SUBSTR(@[cust_cd],3,6))" ).append("\n"); 
		query.append("                     GROUP BY CUST_CNT_CD,CUST_SEQ ),1" ).append("\n"); 
		query.append("                ),             " ).append("\n"); 
		query.append("                @[a_cng_itm_cd],     " ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("				#if(${a_cng_itm_cd} == '4')                   " ).append("\n"); 
		query.append("                DECODE(@[a_old_val_desc],'B','BCO','N','Non-BCO',@[a_old_val_desc])," ).append("\n"); 
		query.append("                DECODE(@[a_new_val_desc],'B','BCO','N','Non-BCO',@[a_new_val_desc])," ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("				#if(${a_cng_itm_cd} != '4')                   " ).append("\n"); 
		query.append("                DECODE(@[a_old_val_desc],'A','ACTIVE','I','INACTIVE','C','COMPANY','P','PRIVATE',@[a_old_val_desc])," ).append("\n"); 
		query.append("                DECODE(@[a_new_val_desc],'A','ACTIVE','I','INACTIVE','C','COMPANY','P','PRIVATE',@[a_new_val_desc])," ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                @[user_id]," ).append("\n"); 
		query.append("                SYSDATE," ).append("\n"); 
		query.append("                @[user_id]," ).append("\n"); 
		query.append("                SYSDATE                                      " ).append("\n"); 
		query.append("            )" ).append("\n"); 

	}
}