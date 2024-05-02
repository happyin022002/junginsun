/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : TESeBillingAckManageDBDAOCheckAckEDILogB4SendRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2013.02.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.edi.ebilling.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESeBillingAckManageDBDAOCheckAckEDILogB4SendRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ACK 대상 전송 전 DB에서의 전송 대기 가능 상태 여부 조회
	  * </pre>
	  */
	public TESeBillingAckManageDBDAOCheckAckEDILogB4SendRSQL(){
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
		params.put("snd_log_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.edi.ebilling.integration ").append("\n"); 
		query.append("FileName : TESeBillingAckManageDBDAOCheckAckEDILogB4SendRSQL").append("\n"); 
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
		query.append("SELECT NVL((" ).append("\n"); 
		query.append("SELECT L.ACK_SND_STS_CD" ).append("\n"); 
		query.append("FROM TES_EDI_ACK_SND_LOG L" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND L.EDI_SND_DT = @[edi_snd_dt]" ).append("\n"); 
		query.append("AND L.SND_LOG_SEQ = @[snd_log_seq]" ).append("\n"); 
		query.append("),'E') ACK_SND_STS_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}