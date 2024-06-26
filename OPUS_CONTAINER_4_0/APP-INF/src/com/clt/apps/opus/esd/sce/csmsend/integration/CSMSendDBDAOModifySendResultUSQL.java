/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CSMSendDBDAOModifySendResultUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.19
*@LastModifier : 김인규
*@LastVersion : 1.0
* 2014.12.19 김인규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.csmsend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author In Gyu Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSMSendDBDAOModifySendResultUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifySendResult
	  * </pre>
	  */
	public CSMSendDBDAOModifySendResultUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("err_msg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_flt_file_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_snd_rslt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_snd_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_snd_yrmondy",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.csmsend.integration").append("\n"); 
		query.append("FileName : CSMSendDBDAOModifySendResultUSQL").append("\n"); 
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
		query.append("UPDATE SCE_CNTR_STS_MSG_SND_RSLT " ).append("\n"); 
		query.append("		SET EDI_SND_RSLT_FLG = @[edi_snd_rslt_flg], " ).append("\n"); 
		query.append("		  ERR_MSG =  " ).append("\n"); 
		query.append("		#if ( ${is_append_err_msg}=='T')" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("			     ERR_MSG ||  " ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("		        @[err_msg], " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		 EDI_ACT_SND_DT = SYSDATE,  " ).append("\n"); 
		query.append("		  UPD_DT = SYSDATE ," ).append("\n"); 
		query.append("		FLT_FILE_REF_NO = @[edi_flt_file_ref_no]" ).append("\n"); 
		query.append("		WHERE EDI_SND_YRMONDY = @[edi_snd_yrmondy]" ).append("\n"); 
		query.append("		  AND EDI_SND_SEQ = @[edi_snd_seq]" ).append("\n"); 

	}
}