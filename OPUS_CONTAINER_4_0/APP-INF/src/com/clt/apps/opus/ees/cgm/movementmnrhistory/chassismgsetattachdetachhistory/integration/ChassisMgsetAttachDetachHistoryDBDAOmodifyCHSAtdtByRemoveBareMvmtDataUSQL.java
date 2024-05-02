/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetAttachDetachHistoryDBDAOmodifyCHSAtdtByRemoveBareMvmtDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.24
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.11.24 최민회
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

public class ChassisMgsetAttachDetachHistoryDBDAOmodifyCHSAtdtByRemoveBareMvmtDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ChassisMgsetAttachDetachHistoryDBDAOmodifyCHSAtdtByRemoveBareMvmtDataUSQL(){
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
		params.put("atch_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtch_inp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.integration").append("\n"); 
		query.append("FileName : ChassisMgsetAttachDetachHistoryDBDAOmodifyCHSAtdtByRemoveBareMvmtDataUSQL").append("\n"); 
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
		query.append("UPDATE  CGM_EQ_ATCH_DTCH_HIS A" ).append("\n"); 
		query.append("SET DTCH_DT = NVL( (SELECT /*+ INDEX(B XAK2CTM_MOVEMENT) */" ).append("\n"); 
		query.append("CNMV_EVNT_DT" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT B, CGM_EQ_ATCH_DTCH_HIS C" ).append("\n"); 
		query.append("WHERE C.EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("AND C.DTCH_YD_CD = @[atch_yd_cd]" ).append("\n"); 
		query.append("AND C.DTCH_DT = TO_DATE(@[atch_dt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("AND B.CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("AND B.CNMV_EVNT_DT > C.DTCH_DT" ).append("\n"); 
		query.append("AND ROWNUM=1) , TO_DATE( '88881231' , 'YYYYMMDD') )" ).append("\n"); 
		query.append(", DTCH_YD_CD = (SELECT /*+ INDEX(B XAK2CTM_MOVEMENT) */" ).append("\n"); 
		query.append("org_yd_cd" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT B, CGM_EQ_ATCH_DTCH_HIS C" ).append("\n"); 
		query.append("WHERE C.EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("AND C.DTCH_YD_CD = @[atch_yd_cd]" ).append("\n"); 
		query.append("AND C.DTCH_DT = TO_DATE(@[atch_dt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("AND B.CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("AND B.CNMV_EVNT_DT > C.DTCH_DT" ).append("\n"); 
		query.append("AND ROWNUM=1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",DTCH_INP_TP_CD = @[dtch_inp_tp_cd]" ).append("\n"); 
		query.append(",UPD_USR_ID  = @[upd_usr_id]" ).append("\n"); 
		query.append(",UPD_DT      = sysdate" ).append("\n"); 
		query.append("WHERE A.EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("AND A.DTCH_YD_CD = @[atch_yd_cd]" ).append("\n"); 
		query.append("AND A.DTCH_DT = TO_DATE(@[atch_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 

	}
}