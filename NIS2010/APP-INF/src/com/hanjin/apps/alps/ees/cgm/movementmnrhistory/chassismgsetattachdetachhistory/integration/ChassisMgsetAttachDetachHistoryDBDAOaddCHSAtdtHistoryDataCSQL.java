/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ChassisMgsetAttachDetachHistoryDBDAOaddCHSAtdtHistoryDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.12
*@LastModifier : 
*@LastVersion : 1.0
* 2013.03.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetAttachDetachHistoryDBDAOaddCHSAtdtHistoryDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2013.03.12 조경완 [CHM-201323142-01] CPS 적용에 따라, Pool Chassis에 대한 Attach/Detach 기능 개발 요청
	  * </pre>
	  */
	public ChassisMgsetAttachDetachHistoryDBDAOaddCHSAtdtHistoryDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("Path : com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.integration").append("\n"); 
		query.append("FileName : ChassisMgsetAttachDetachHistoryDBDAOaddCHSAtdtHistoryDataCSQL").append("\n"); 
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
		query.append(",CNTR_NO" ).append("\n"); 
		query.append(",DTCH_DT" ).append("\n"); 
		query.append(",ATCH_YD_CD" ).append("\n"); 
		query.append(",DTCH_YD_CD" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[eq_no]" ).append("\n"); 
		query.append(",TO_DATE(@[atch_dt] ,'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(",(SELECT DECODE(MAX(ATCH_DTCH_SEQ)+1,NULL,1,MAX(ATCH_DTCH_SEQ)+1) FROM CGM_EQ_ATCH_DTCH_HIS" ).append("\n"); 
		query.append("WHERE EQ_NO= @[eq_no] AND ATCH_DT = TO_DATE(@[atch_dt] ,'YYYY-MM-DD HH24:MI:SS')  )" ).append("\n"); 
		query.append(",'Z'" ).append("\n"); 
		query.append(",@[cntr_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",NVL((CASE WHEN CNTR_EVNT_DT < CHSS_EVNT_DT THEN CNTR_EVNT_DT" ).append("\n"); 
		query.append("WHEN CNTR_EVNT_DT > CHSS_EVNT_DT THEN CHSS_EVNT_DT" ).append("\n"); 
		query.append("END ), TO_DATE('8888-12-31' ,'YYYY-MM-DD HH24:MI:SS'))" ).append("\n"); 
		query.append(",@[atch_yd_cd]" ).append("\n"); 
		query.append(",CASE WHEN CNTR_EVNT_DT < CHSS_EVNT_DT THEN CNTR_EVNT_YD" ).append("\n"); 
		query.append("WHEN CNTR_EVNT_DT > CHSS_EVNT_DT THEN CHSS_EVNT_YD" ).append("\n"); 
		query.append("END DTCH_YD" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",sysdate" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(",sysdate" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("NVL( (  SELECT /*+ INDEX(M XAK2CTM_MOVEMENT) */ CNMV_EVNT_DT" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT  M" ).append("\n"); 
		query.append("WHERE M.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND M.CNMV_EVNT_DT > TO_DATE(@[atch_dt] ,'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("AND ROWNUM=1 ) , to_date('88881231','YYYYMMDD') )  CNTR_EVNT_DT," ).append("\n"); 
		query.append("(SELECT /*+ INDEX(M XAK2CTM_MOVEMENT) */  ORG_YD_CD" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT  M" ).append("\n"); 
		query.append("WHERE M.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND M.CNMV_EVNT_DT > TO_DATE(@[atch_dt] ,'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("AND ROWNUM=1 ) CNTR_EVNT_YD," ).append("\n"); 
		query.append("NVL( (   SELECT /*+ INDEX(M XAK17CTM_MOVEMENT) */  CNMV_EVNT_DT" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT  M" ).append("\n"); 
		query.append("WHERE M.CHSS_NO = @[eq_no]" ).append("\n"); 
		query.append("AND M.CNMV_EVNT_DT > TO_DATE(@[atch_dt] ,'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("AND ROWNUM=1 ) , to_date('88881231','YYYYMMDD') ) CHSS_EVNT_DT," ).append("\n"); 
		query.append("(SELECT /*+ INDEX(M XAK17CTM_MOVEMENT) */  ORG_YD_CD" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT  M" ).append("\n"); 
		query.append("WHERE M.CHSS_NO = @[eq_no]" ).append("\n"); 
		query.append("AND M.CNMV_EVNT_DT > TO_DATE(@[atch_dt] ,'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("AND ROWNUM=1 ) CHSS_EVNT_YD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}