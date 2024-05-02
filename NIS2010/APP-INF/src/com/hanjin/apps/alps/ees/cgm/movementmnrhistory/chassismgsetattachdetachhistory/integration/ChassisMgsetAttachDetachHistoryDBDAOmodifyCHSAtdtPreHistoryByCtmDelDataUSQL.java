/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetAttachDetachHistoryDBDAOmodifyCHSAtdtPreHistoryByCtmDelDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.24
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.11.24 최민회
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI MIN HOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetAttachDetachHistoryDBDAOmodifyCHSAtdtPreHistoryByCtmDelDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ChassisMgsetAttachDetachHistoryDBDAOmodifyCHSAtdtPreHistoryByCtmDelDataUSQL(){
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atch_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.integration").append("\n"); 
		query.append("FileName : ChassisMgsetAttachDetachHistoryDBDAOmodifyCHSAtdtPreHistoryByCtmDelDataUSQL").append("\n"); 
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
		query.append("UPDATE CGM_EQ_ATCH_DTCH_HIS" ).append("\n"); 
		query.append("/*+ INDEX_DESC(A XPKCGM_EQ_ATCH_DTCH_HIS) */" ).append("\n"); 
		query.append("SET (DTCH_YD_CD  ,DTCH_DT)" ).append("\n"); 
		query.append("= (select /*+ INDEX(C XAK2CTM_MOVEMENT)   */" ).append("\n"); 
		query.append("ORG_YD_CD , CNMV_EVNT_DT" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT C" ).append("\n"); 
		query.append("WHERE   C.CNTR_NO =@[cntr_no]" ).append("\n"); 
		query.append("AND C.CNMV_EVNT_DT > TO_DATE( @[atch_dt] ,'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("AND ROWNUM =1)" ).append("\n"); 
		query.append(",UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",DTCH_INP_TP_CD = 'A'" ).append("\n"); 
		query.append(",UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE  CNTR_NO =@[cntr_no]" ).append("\n"); 
		query.append("AND ATCH_DT < TO_DATE( @[atch_dt] ,'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("AND EXISTS ( select /*+ INDEX(C XAK2CTM_MOVEMENT)   */" ).append("\n"); 
		query.append("'X'" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT C" ).append("\n"); 
		query.append("WHERE   C.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND C.CNMV_EVNT_DT > TO_DATE( @[atch_dt] ,'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("AND ROWNUM =1)" ).append("\n"); 
		query.append("AND ROWNUM=1" ).append("\n"); 

	}
}