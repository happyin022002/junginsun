/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : USAActualCustomerCodeManageDBDAOActualCustomerCodeManageListMasterCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2009.07.29 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.usaactualcustomercodemanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JH CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USAActualCustomerCodeManageDBDAOActualCustomerCodeManageListMasterCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Actual Customer Code 등록
	  * </pre>
	  */
	public USAActualCustomerCodeManageDBDAOActualCustomerCodeManageListMasterCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trsp_act_cust_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.codemanage.usaactualcustomercodemanage.integration ").append("\n"); 
		query.append("FileName : USAActualCustomerCodeManageDBDAOActualCustomerCodeManageListMasterCSQL").append("\n"); 
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
		query.append("MERGE INTO    TRS_TRSP_USA_ACT_CUST" ).append("\n"); 
		query.append("USING DUAL" ).append("\n"); 
		query.append("ON            (TRSP_ACT_CUST_NO         = @[trsp_act_cust_no] )" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT ( TRSP_ACT_CUST_NO" ).append("\n"); 
		query.append(", ACT_CUST_CNT_CD" ).append("\n"); 
		query.append(", ACT_CUST_SEQ" ).append("\n"); 
		query.append(", ACT_CUST_BND_CD" ).append("\n"); 
		query.append(", DOR_NOD_CD" ).append("\n"); 
		query.append(", ACT_CUST_NM" ).append("\n"); 
		query.append(", DELT_FLG" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES ( @[trsp_act_cust_no]										/* TRSP_ACT_CUST_NO */" ).append("\n"); 
		query.append(", SUBSTR(@[act_cust_cnt_cd],1,2)                        	/* ACT_CUST_CNT_CD */" ).append("\n"); 
		query.append(", TO_number(SUBSTR(@[act_cust_cnt_cd],3,6))             	/* ACT_CUST_SEQ    */" ).append("\n"); 
		query.append(", @[act_cust_bnd_cd]                                    	/* ACT_CUST_BND_CD */" ).append("\n"); 
		query.append(", @[dor_nod_cd]                                    	/* DOR_NOD_CD    */" ).append("\n"); 
		query.append(", @[act_cust_nm]                                    	/* ACT_CUST_NM   */" ).append("\n"); 
		query.append(", @[delt_flg]	                                  	/* DELT_FLG      */" ).append("\n"); 
		query.append(", @[cre_usr_id]                                    	/* CRE_USR_ID    */" ).append("\n"); 
		query.append(", SYSDATE									/* CRE_DT        */" ).append("\n"); 
		query.append(", @[upd_usr_id]                                    	/* UPD_USR_ID    */" ).append("\n"); 
		query.append(", SYSDATE									/* UPD_DT        */" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET  ACT_CUST_NM         = @[act_cust_nm]" ).append("\n"); 
		query.append(", ACT_CUST_CNT_CD	 = SUBSTR(@[act_cust_cnt_cd],1,2)          	/* ACT_CUST_CNT_CD */" ).append("\n"); 
		query.append(", ACT_CUST_SEQ		 = TO_number(SUBSTR(@[act_cust_cnt_cd],3,6))	/* ACT_CUST_SEQ    */" ).append("\n"); 
		query.append(", DELT_FLG		     = NVL(@[delt_flg],'N')" ).append("\n"); 
		query.append(", DELT_USR_ID         = DECODE(@[delt_flg], 'Y', @[upd_usr_id],'')" ).append("\n"); 
		query.append(", DELT_DT             = DECODE(@[delt_flg], 'Y', SYSDATE,'')" ).append("\n"); 
		query.append(", UPD_USR_ID          = @[upd_usr_id]" ).append("\n"); 
		query.append(", UPD_DT              = SYSDATE" ).append("\n"); 

	}
}