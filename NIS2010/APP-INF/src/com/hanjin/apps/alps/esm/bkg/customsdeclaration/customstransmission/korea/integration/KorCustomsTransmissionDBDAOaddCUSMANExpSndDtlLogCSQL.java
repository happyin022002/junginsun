/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KorCustomsTransmissionDBDAOaddCUSMANExpSndDtlLogCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.11
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.01.11 박상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorCustomsTransmissionDBDAOaddCUSMANExpSndDtlLogCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Export License No 전송 LOG 관리를 위한 작업(DETAIL) => CUSMAN flat file에 같이 붙여서 전송됨
	  * </pre>
	  */
	public KorCustomsTransmissionDBDAOaddCUSMANExpSndDtlLogCSQL(){
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
		params.put("flt_file_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("edi_snd_msg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.integration").append("\n"); 
		query.append("FileName : KorCustomsTransmissionDBDAOaddCUSMANExpSndDtlLogCSQL").append("\n"); 
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
		query.append("INTO BKG_CSTMS_KR_SND_LOG_DTL" ).append("\n"); 
		query.append("( MSG_LOG_TP_ID" ).append("\n"); 
		query.append(", SND_DT" ).append("\n"); 
		query.append(", OFC_CD" ).append("\n"); 
		query.append(", FLT_FILE_REF_NO" ).append("\n"); 
		query.append(", MF_SND_SEQ" ).append("\n"); 
		query.append(", LOG_DTL_SEQ" ).append("\n"); 
		query.append(", EDI_SND_MSG" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT DECODE(@[io_bnd_cd], 'I', '5IB', '5CD')" ).append("\n"); 
		query.append(", TO_DATE(@[snd_dt], 'YYYYMMDD hh24:mi:ss')" ).append("\n"); 
		query.append(", @[ofc_cd]" ).append("\n"); 
		query.append(", @[flt_file_ref_no]" ).append("\n"); 
		query.append(", 1" ).append("\n"); 
		query.append(", TO_NUMBER(NVL(MAX(LOG_DTL_SEQ), 0) + 1)" ).append("\n"); 
		query.append(", @[edi_snd_msg]" ).append("\n"); 
		query.append(", @[user_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[user_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append("FROM BKG_CSTMS_KR_SND_LOG_DTL" ).append("\n"); 
		query.append("WHERE MSG_LOG_TP_ID  =   DECODE(@[io_bnd_cd], 'I', '5IB', '5CD')" ).append("\n"); 
		query.append("AND SND_DT         =   TO_DATE(@[snd_dt], 'YYYYMMDD hh24:mi:ss')" ).append("\n"); 
		query.append("AND OFC_CD         =   @[ofc_cd]" ).append("\n"); 

	}
}