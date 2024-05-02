/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CustomerInfoManageDBDAOMergePrimaryFlgUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.05
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2012.03.05 서미진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chloe Mijin SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerInfoManageDBDAOMergePrimaryFlgUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 이미 해당 Customer의 Sales Rep이었던 History가 있을 경우, Primary Flag를 Update하고
	  * 새로 추가되는 Sales Rep일 경우 Insert 한다.
	  * </pre>
	  */
	public CustomerInfoManageDBDAOMergePrimaryFlgUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration ").append("\n"); 
		query.append("FileName : CustomerInfoManageDBDAOMergePrimaryFlgUSQL").append("\n"); 
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
		query.append("MERGE INTO SAM_CUST_SLS_REP_INFO SAM" ).append("\n"); 
		query.append("    USING ( SELECT @[cust_cnt_cd] CUST_CNT_CD" ).append("\n"); 
		query.append("                 , TO_NUMBER(@[cust_seq]) CUST_SEQ" ).append("\n"); 
		query.append("                 , @[srep_cd] SREP_CD" ).append("\n"); 
		query.append("              FROM DUAL ) OLD               " ).append("\n"); 
		query.append("    ON ( SAM.CUST_CNT_CD = OLD.CUST_CNT_CD " ).append("\n"); 
		query.append("         AND SAM.CUST_SEQ = OLD.CUST_SEQ" ).append("\n"); 
		query.append("         AND SAM.SREP_CD = OLD.SREP_CD )" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("    WHEN MATCHED THEN     " ).append("\n"); 
		query.append("         UPDATE SET SAM.SREP_PRMRY_FLG = 'Y'" ).append("\n"); 
		query.append("                  , SAM.UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("                  , SAM.UPD_DT = SYSDATE" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("    WHEN NOT MATCHED THEN " ).append("\n"); 
		query.append("        INSERT ( CUST_CNT_CD," ).append("\n"); 
		query.append("                 CUST_SEQ," ).append("\n"); 
		query.append("                 SREP_CD," ).append("\n"); 
		query.append("                 SREP_PRMRY_FLG," ).append("\n"); 
		query.append("                 CRE_USR_ID," ).append("\n"); 
		query.append("                 CRE_DT," ).append("\n"); 
		query.append("                 UPD_USR_ID," ).append("\n"); 
		query.append("                 UPD_DT" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("        VALUES ( @[cust_cnt_cd]," ).append("\n"); 
		query.append("                TO_NUMBER(@[cust_seq])," ).append("\n"); 
		query.append("                @[srep_cd]," ).append("\n"); 
		query.append("                'Y'," ).append("\n"); 
		query.append("                @[cre_usr_id]," ).append("\n"); 
		query.append("                SYSDATE," ).append("\n"); 
		query.append("                @[upd_usr_id]," ).append("\n"); 
		query.append("                SYSDATE" ).append("\n"); 
		query.append("                )" ).append("\n"); 

	}
}