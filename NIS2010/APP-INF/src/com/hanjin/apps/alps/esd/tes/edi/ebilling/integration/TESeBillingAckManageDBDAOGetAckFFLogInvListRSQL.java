/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : TESeBillingAckManageDBDAOGetAckFFLogInvListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.14
*@LastModifier : 
*@LastVersion : 1.0
* 2013.02.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.edi.ebilling.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESeBillingAckManageDBDAOGetAckFFLogInvListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * F/F생성용 ACK Invoice대상 목록 조회
	  * </pre>
	  */
	public TESeBillingAckManageDBDAOGetAckFFLogInvListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_snd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ack_act_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_log_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.edi.ebilling.integration").append("\n"); 
		query.append("FileName : TESeBillingAckManageDBDAOGetAckFFLogInvListRSQL").append("\n"); 
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
		query.append("SELECT EH.* --INV_NO, EH.TTL_INV_AMT, EH.CURR_CD" ).append("\n"); 
		query.append("FROM TES_EDI_ACK_SND_LOG L, TES_EDI_ACK_SND_LOG_INV I, TES_EDI_SO_HDR EH" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND L.EDI_SND_DT = I.EDI_SND_DT" ).append("\n"); 
		query.append("AND L.SND_LOG_SEQ = I.SND_LOG_SEQ" ).append("\n"); 
		query.append("AND L.EDI_SND_DT = @[edi_snd_dt]" ).append("\n"); 
		query.append("AND L.SND_LOG_SEQ = @[snd_log_seq]" ).append("\n"); 
		query.append("AND L.ACK_ACT_TP_CD = @[ack_act_tp_cd]" ).append("\n"); 
		query.append("AND L.ACK_SND_STS_CD = 'N'" ).append("\n"); 
		query.append("AND L.CRE_DT >= SYSDATE-100 --// test" ).append("\n"); 
		query.append("AND I.TML_EDI_SO_OFC_CTY_CD = EH.TML_EDI_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND I.TML_EDI_SO_SEQ = EH.TML_EDI_SO_SEQ" ).append("\n"); 
		query.append("AND NVL(EH.DELT_FLG,'N') <> 'Y'" ).append("\n"); 

	}
}