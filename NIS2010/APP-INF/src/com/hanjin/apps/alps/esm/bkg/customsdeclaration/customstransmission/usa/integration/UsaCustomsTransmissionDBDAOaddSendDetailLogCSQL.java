/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOaddSendDetailLogCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.10.23 김도완
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do-Wan, Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOaddSendDetailLogCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, 1023, 로그 저장용.
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOaddSendDetailLogCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_proc_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOaddSendDetailLogCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_ADV_STWG_SND_DTL" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SND_PROC_ID, STWG_SND_ID, SND_DT, DTL_SEQ," ).append("\n"); 
		query.append("POL_CD, MSG_DESC, CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT, UPD_USR_ID, UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("@[snd_proc_id], @[seq], TO_DATE(@[snd_dt],'yyyymmddhh24miss'), @[dtl_seq]," ).append("\n"); 
		query.append("@[pol], @[msg], @[usr_id]," ).append("\n"); 
		query.append("sysdate, @[usr_id], sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}