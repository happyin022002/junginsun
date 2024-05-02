/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetAttachDetachHistoryDBDAOaddMGSAtdtHistoryDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.08
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.09.08 최민회
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI MIN HOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetAttachDetachHistoryDBDAOaddMGSAtdtHistoryDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ChassisMgsetAttachDetachHistoryDBDAOaddMGSAtdtHistoryDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atch_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atch_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.integration").append("\n"); 
		query.append("FileName : ChassisMgsetAttachDetachHistoryDBDAOaddMGSAtdtHistoryDataCSQL").append("\n"); 
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
		query.append("INSERT INTO CGM_EQ_ATCH_DTCH_HIS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("EQ_NO" ).append("\n"); 
		query.append(",ATCH_DT" ).append("\n"); 
		query.append(",ATCH_DTCH_SEQ" ).append("\n"); 
		query.append(",EQ_KND_CD" ).append("\n"); 
		query.append(",CHSS_NO" ).append("\n"); 
		query.append(",CNTR_NO" ).append("\n"); 
		query.append(",DTCH_DT" ).append("\n"); 
		query.append(",ATCH_YD_CD" ).append("\n"); 
		query.append(",ATCH_INP_TP_CD" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("values" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("@[eq_no]" ).append("\n"); 
		query.append(",TO_DATE(@[atch_dt] ,'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(",(SELECT DECODE(MAX(ATCH_DTCH_SEQ)+1,NULL,1,MAX(ATCH_DTCH_SEQ)+1) FROM CGM_EQ_ATCH_DTCH_HIS" ).append("\n"); 
		query.append("WHERE EQ_NO= @[eq_no] AND ATCH_DT = TO_DATE(@[atch_dt] ,'YYYY-MM-DD HH24:MI:SS')  )" ).append("\n"); 
		query.append(",'G'" ).append("\n"); 
		query.append(",@[chss_no]" ).append("\n"); 
		query.append(",@[cntr_no]" ).append("\n"); 
		query.append(",TO_DATE('8888-12-31' ,'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(",@[atch_yd_cd]" ).append("\n"); 
		query.append(",'M'" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",sysdate" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(",sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}