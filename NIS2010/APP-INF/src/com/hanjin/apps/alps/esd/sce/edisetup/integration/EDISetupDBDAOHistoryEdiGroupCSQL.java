/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EDISetupDBDAOHistoryEdiGroupCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.11
*@LastModifier : 이경원
*@LastVersion : 1.0
* 2011.11.11 이경원
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edisetup.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee KyungWon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EDISetupDBDAOHistoryEdiGroupCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EdiGroup 테이블에 모든 사항을 히스토리로 기록한다 (Insert, Update, Delete)
	  * </pre>
	  */
	public EDISetupDBDAOHistoryEdiGroupCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eai_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_ind",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("group_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("company_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("host_tp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_tp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("group_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edisetup.integration ").append("\n"); 
		query.append("FileName : EDISetupDBDAOHistoryEdiGroupCSQL").append("\n"); 
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
		query.append("insert into edi_grp_his (" ).append("\n"); 
		query.append("EDI_SND_HIS_SEQ" ).append("\n"); 
		query.append(",EDI_GRP_CD" ).append("\n"); 
		query.append(",CO_DIV_CD" ).append("\n"); 
		query.append(",EDI_GRP_DESC" ).append("\n"); 
		query.append(",CUST_TRD_PRNR_ID" ).append("\n"); 
		query.append(",PROV_TRD_PRNR_ID" ).append("\n"); 
		query.append(",DELT_FLG" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",EAI_EVNT_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("values (" ).append("\n"); 
		query.append("EDI_GROUP_HIS_SEQ1.NEXTVAL," ).append("\n"); 
		query.append("@[group_cd]," ).append("\n"); 
		query.append("@[company_cd]," ).append("\n"); 
		query.append("@[group_nm]," ).append("\n"); 
		query.append("@[cust_tp_id]," ).append("\n"); 
		query.append("@[host_tp_id]," ).append("\n"); 
		query.append("@[del_ind]," ).append("\n"); 
		query.append("@[cre_id]," ).append("\n"); 
		query.append("sysdate," ).append("\n"); 
		query.append("to_date(@[eai_date],'yyyy/mm/dd hh24:mi:ss')" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}