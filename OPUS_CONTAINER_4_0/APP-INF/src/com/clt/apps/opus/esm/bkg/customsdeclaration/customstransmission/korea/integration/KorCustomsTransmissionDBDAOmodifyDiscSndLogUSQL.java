/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : KorCustomsTransmissionDBDAOmodifyDiscSndLogUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.04
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorCustomsTransmissionDBDAOmodifyDiscSndLogUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TEU, FEU CNTR Type Size Count를 Update한다.
	  * </pre>
	  */
	public KorCustomsTransmissionDBDAOmodifyDiscSndLogUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("teu_cnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("feu_cnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.integration").append("\n"); 
		query.append("FileName : KorCustomsTransmissionDBDAOmodifyDiscSndLogUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CSTMS_KR_SND_LOG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   SET TTL_TEU_KNT = @[teu_cnt]," ).append("\n"); 
		query.append("       TTL_FEU_KNT = @[feu_cnt]," ).append("\n"); 
		query.append("       EDI_SND_MSG_CTNT = @[edi_snd_msg_ctnt]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE MSG_LOG_TP_ID = '5ID'" ).append("\n"); 
		query.append("   AND SND_DT = DECODE(@[snd_dt], NULL , SYSDATE, TO_DATE(@[snd_dt], 'YYYYMMDD HH24:MI:SS'))" ).append("\n"); 
		query.append("   AND OFC_CD = @[ofc_cd]" ).append("\n"); 

	}
}