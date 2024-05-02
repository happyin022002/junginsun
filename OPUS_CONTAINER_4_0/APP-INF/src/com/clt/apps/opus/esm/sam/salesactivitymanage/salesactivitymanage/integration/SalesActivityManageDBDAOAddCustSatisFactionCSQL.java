/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SalesActivityManageDBDAOAddCustSatisFactionCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.15
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2011.06.15 김보배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SalesActivityManageDBDAOAddCustSatisFactionCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Sales Activity Report 화면의 3번째 탭 ( Cust.SatisFaction ) 생성 후 저장용 쿼리
	  * </pre>
	  */
	public SalesActivityManageDBDAOAddCustSatisFactionCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_satsfc_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rsn",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sls_act_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.integration").append("\n"); 
		query.append("FileName : SalesActivityManageDBDAOAddCustSatisFactionCSQL").append("\n"); 
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
		query.append("INSERT INTO SAM_CUST_SATSFC (" ).append("\n"); 
		query.append("                              CUST_CNT_CD" ).append("\n"); 
		query.append("                            , CUST_SEQ" ).append("\n"); 
		query.append("                            , SREP_CD" ).append("\n"); 
		query.append("                            , SLS_ACT_SEQ" ).append("\n"); 
		query.append("                            , CUST_SATSFC_ITM_CD" ).append("\n"); 
		query.append("                            , CUST_SATSFC_GRD_CD" ).append("\n"); 
		query.append("                            , CUST_SATSFC_RSN" ).append("\n"); 
		query.append("                            , CRE_USR_ID" ).append("\n"); 
		query.append("                            , CRE_DT" ).append("\n"); 
		query.append("                            , UPD_USR_ID" ).append("\n"); 
		query.append("                            , UPD_DT    " ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("VALUES ( @[cust_cnt_cd]" ).append("\n"); 
		query.append("       , @[cust_seq]" ).append("\n"); 
		query.append("       , @[srep_cd]" ).append("\n"); 
		query.append("       , @[sls_act_seq]" ).append("\n"); 
		query.append("       , @[cust_satsfc_itm_cd]" ).append("\n"); 
		query.append("       , @[grd]" ).append("\n"); 
		query.append("       , @[rsn]" ).append("\n"); 
		query.append("       , @[cre_usr_id]" ).append("\n"); 
		query.append("       , sysdate" ).append("\n"); 
		query.append("       , @[cre_usr_id]" ).append("\n"); 
		query.append("       , sysdate" ).append("\n"); 
		query.append("       )" ).append("\n"); 

	}
}