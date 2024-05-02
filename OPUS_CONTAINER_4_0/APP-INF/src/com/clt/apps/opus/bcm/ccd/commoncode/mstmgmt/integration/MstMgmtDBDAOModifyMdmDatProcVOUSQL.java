/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MstMgmtDBDAOModifyMdmDatProcVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.05
*@LastModifier : 윤태승
*@LastVersion : 1.0
* 2012.07.05 윤태승
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.mstmgmt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author YunTaeSeung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MstMgmtDBDAOModifyMdmDatProcVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MdmDatProc 정보 수정
	  * </pre>
	  */
	public MstMgmtDBDAOModifyMdmDatProcVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("proc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("apro_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.mstmgmt.integration").append("\n"); 
		query.append("FileName : MstMgmtDBDAOModifyMdmDatProcVOUSQL").append("\n"); 
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
		query.append("UPDATE MDM_DAT_PROC" ).append("\n"); 
		query.append("   SET APRO_USR_ID = @[apro_usr_id] ," ).append("\n"); 
		query.append("       PROC_TP_CD = @[proc_tp_cd] ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${proc_tp_cd} == 'A')" ).append("\n"); 
		query.append("	   APRO_RMK = @[rmk] ," ).append("\n"); 
		query.append("#elseif (${proc_tp_cd} == 'R')" ).append("\n"); 
		query.append("	   RJCT_RMK = @[rmk] ," ).append("\n"); 
		query.append("#elseif (${proc_tp_cd} == 'O')" ).append("\n"); 
		query.append("	   RQST_UPD_DT = NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[rqst_ofc_cd]), SYSDATE) ," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	   " ).append("\n"); 
		query.append("       PROC_UPD_DT = NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[rqst_ofc_cd]), SYSDATE) ," ).append("\n"); 
		query.append("       UPD_USR_ID = @[upd_usr_id] ," ).append("\n"); 
		query.append("       UPD_DT = SYSDATE" ).append("\n"); 
		query.append(" WHERE RQST_NO = @[rqst_no]" ).append("\n"); 

	}
}