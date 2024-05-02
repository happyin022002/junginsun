/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CSMSendEurDBDAOModifySendResultUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.csmsendeur.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSMSendEurDBDAOModifySendResultUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifySendResult
	  * </pre>
	  */
	public CSMSendEurDBDAOModifySendResultUSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.sce.csmsendeur.integration").append("\n"); 
		query.append("FileName : CSMSendEurDBDAOModifySendResultUSQL").append("\n"); 
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
		query.append("UPDATE SCE_CSM_SND_RSLT_EUR " ).append("\n"); 
		query.append("		SET EDI_SND_RSLT_FLG = @[edi_snd_rslt_flg], " ).append("\n"); 
		query.append("		  ERR_MSG =  " ).append("\n"); 
		query.append("		#if ( ${is_append_err_msg}=='T')" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("			     ERR_MSG ||  " ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("		        @[err_msg], " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		 EDI_ACT_SND_DT = SYSDATE,  " ).append("\n"); 
		query.append("		  UPD_DT = SYSDATE " ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		WHERE EDI_SND_YRMONDY = @[edi_snd_yrmondy]" ).append("\n"); 
		query.append("		  AND EDI_SND_SEQ = @[edi_snd_seq]" ).append("\n"); 

	}
}