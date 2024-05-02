/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ReceiveQueueArRoutRnkDBDAOAddArRoutRnkCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.22
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2010.04.22 박성진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.common.tableSync.jms.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveQueueArRoutRnkDBDAOAddArRoutRnkCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ar_rout_rnk 테이블에 저장
	  * </pre>
	  */
	public ReceiveQueueArRoutRnkDBDAOAddArRoutRnkCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rnk_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("zn_ioc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ioc_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eai_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.common.tableSync.jms.integration").append("\n"); 
		query.append("FileName : ReceiveQueueArRoutRnkDBDAOAddArRoutRnkCSQL").append("\n"); 
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
		query.append("INSERT INTO	ar_rout_rnk(" ).append("\n"); 
		query.append("rlane_cd," ).append("\n"); 
		query.append("rnk_seq," ).append("\n"); 
		query.append("rlane_desc," ).append("\n"); 
		query.append("zn_ioc_cd," ).append("\n"); 
		query.append("ioc_desc," ).append("\n"); 
		query.append("slan_cd," ).append("\n"); 
		query.append("delt_flg," ).append("\n"); 
		query.append("cre_usr_id," ).append("\n"); 
		query.append("cre_dt," ).append("\n"); 
		query.append("upd_dt," ).append("\n"); 
		query.append("eai_evnt_dt" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES(" ).append("\n"); 
		query.append("@[rlane_cd]," ).append("\n"); 
		query.append("@[rnk_seq]," ).append("\n"); 
		query.append("@[rlane_desc]," ).append("\n"); 
		query.append("@[zn_ioc_cd]," ).append("\n"); 
		query.append("@[ioc_desc]," ).append("\n"); 
		query.append("@[slan_cd]," ).append("\n"); 
		query.append("@[delt_flg]," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("to_date(@[cre_dt],'yyyymmddhh24miss')," ).append("\n"); 
		query.append("sysdate," ).append("\n"); 
		query.append("to_date(@[eai_evnt_dt],'yyyymmddhh24miss')" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}