/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PanamaCustomsTransmissionDBDAOaddBkgCstmsPnmRcvErrCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.19
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.01.19 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM MINJUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PanamaCustomsTransmissionDBDAOaddBkgCstmsPnmRcvErrCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addBkgCstmsPnmRcvErr
	  * </pre>
	  */
	public PanamaCustomsTransmissionDBDAOaddBkgCstmsPnmRcvErrCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_err_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_log_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_err_msg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_log_err_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.integration").append("\n"); 
		query.append("FileName : PanamaCustomsTransmissionDBDAOaddBkgCstmsPnmRcvErrCSQL").append("\n"); 
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
		query.append("INSERT" ).append("\n"); 
		query.append("  INTO BKG_CSTMS_PNM_RCV_ERR" ).append("\n"); 
		query.append("      (RCV_DT" ).append("\n"); 
		query.append("      ,RCV_LOG_SEQ" ).append("\n"); 
		query.append("      ,VST_NO" ).append("\n"); 
		query.append("      ,RCV_LOG_ERR_SEQ" ).append("\n"); 
		query.append("      ,CSTMS_ERR_ID" ).append("\n"); 
		query.append("      ,CSTMS_ERR_MSG" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,CRE_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,UPD_DT" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("VALUES (TO_DATE(@[rcv_dt], 'yyyymmddhh24miss')" ).append("\n"); 
		query.append("      ,@[rcv_log_seq]" ).append("\n"); 
		query.append("      ,@[vst_no]" ).append("\n"); 
		query.append("      ,@[rcv_log_err_seq]" ).append("\n"); 
		query.append("      ,@[cstms_err_id]" ).append("\n"); 
		query.append("      ,@[cstms_err_msg]" ).append("\n"); 
		query.append("      ,'RCV'" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("      ,'RCV'" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("      )" ).append("\n"); 

	}
}