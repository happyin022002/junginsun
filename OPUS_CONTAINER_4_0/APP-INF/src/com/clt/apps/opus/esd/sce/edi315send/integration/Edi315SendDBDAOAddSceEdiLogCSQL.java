/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315SendDBDAOAddSceEdiLogCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.16
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.03.16 이윤정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoonjung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOAddSceEdiLogCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddSceEdiLog
	  * </pre>
	  */
	public Edi315SendDBDAOAddSceEdiLogCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_rcv_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("edi_snd_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOAddSceEdiLogCSQL").append("\n"); 
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
		query.append("insert into sce_edi_log" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("CNTR_NO" ).append("\n"); 
		query.append(",BKG_NO" ).append("\n"); 
		query.append(",EDI_LOG_SEQ" ).append("\n"); 
		query.append(",EDI_RCV_TP_CD" ).append("\n"); 
		query.append(",EDI_SND_RMK" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("values" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("@[cntr_no]					--CNTR_NO" ).append("\n"); 
		query.append(",@[bkg_no]					--BKG_NO" ).append("\n"); 
		query.append(",sce_edi_log_seq1.nextval	--EDI_LOG_SEQ" ).append("\n"); 
		query.append(",@[edi_rcv_tp_cd]			--EDI_RCV_TP_CD" ).append("\n"); 
		query.append(",@[edi_snd_rmk]				--EDI_SND_RMK" ).append("\n"); 
		query.append(",nvl(@[cre_usr_id],'-')		--CRE_USR_ID" ).append("\n"); 
		query.append(",sysdate					--CRE_DT" ).append("\n"); 
		query.append(",to_char(sysdate,'yyyymmdd')--UPD_USR_ID" ).append("\n"); 
		query.append(",sysdate					--UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}