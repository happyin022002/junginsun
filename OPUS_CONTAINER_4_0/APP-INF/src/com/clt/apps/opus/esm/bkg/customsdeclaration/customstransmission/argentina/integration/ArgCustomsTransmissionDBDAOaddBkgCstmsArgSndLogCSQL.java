/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ArgCustomsTransmissionDBDAOaddBkgCstmsArgSndLogCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.02
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.01.02 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.argentina.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM MINJUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ArgCustomsTransmissionDBDAOaddBkgCstmsArgSndLogCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addBkgCstmsArgSndLog
	  * </pre>
	  */
	public ArgCustomsTransmissionDBDAOaddBkgCstmsArgSndLogCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_snd_msg_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.argentina.integration").append("\n"); 
		query.append("FileName : ArgCustomsTransmissionDBDAOaddBkgCstmsArgSndLogCSQL").append("\n"); 
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
		query.append("  INTO BKG_CSTMS_ARG_SND_LOG" ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("       BL_NO" ).append("\n"); 
		query.append("      ,IO_BND_CD" ).append("\n"); 
		query.append("      ,SND_DT" ).append("\n"); 
		query.append("      ,EDI_SND_MSG_CTNT" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,CRE_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,UPD_DT" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append(" VALUES" ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("       @[bl_no]" ).append("\n"); 
		query.append("      ,@[io_bnd_cd]" ).append("\n"); 
		query.append("      ,NEW_TIME(SYS_EXTRACT_UTC(CURRENT_TIMESTAMP), 'GMT', 'EST')" ).append("\n"); 
		query.append("      ,@[edi_snd_msg_ctnt]" ).append("\n"); 
		query.append("      ,@[upd_usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("      ,@[upd_usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("      )" ).append("\n"); 

	}
}