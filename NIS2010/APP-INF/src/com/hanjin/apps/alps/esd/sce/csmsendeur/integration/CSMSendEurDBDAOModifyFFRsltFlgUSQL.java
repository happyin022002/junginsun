/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CSMSendEurDBDAOModifyFFRsltFlgUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.csmsendeur.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSMSendEurDBDAOModifyFFRsltFlgUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyFFRsltFlg
	  * </pre>
	  */
	public CSMSendEurDBDAOModifyFFRsltFlgUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("Path : com.hanjin.apps.alps.esd.sce.csmsendeur.integration").append("\n"); 
		query.append("FileName : CSMSendEurDBDAOModifyFFRsltFlgUSQL").append("\n"); 
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
		query.append("UPDATE SCE_CSM_FLT_FILE_EUR SET RSLT_FLG = @[edi_snd_rslt_flg] WHERE EDI_SND_YRMONDY = @[edi_snd_yrmondy] AND EDI_SND_SEQ = @[edi_snd_seq]" ).append("\n"); 

	}
}