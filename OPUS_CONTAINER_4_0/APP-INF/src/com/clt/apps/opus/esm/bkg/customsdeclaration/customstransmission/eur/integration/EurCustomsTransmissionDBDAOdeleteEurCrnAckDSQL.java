/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EurCustomsTransmissionDBDAOdeleteEurCrnAckDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.17
*@LastModifier : 
*@LastVersion : 1.0
* 2011.10.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EurCustomsTransmissionDBDAOdeleteEurCrnAckDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 스페인 로컬 시스템에서 생성하여 사용 하는 CRN 값을 ALPS로 수신 받은 값을 삭제한다.
	  * </pre>
	  */
	public EurCustomsTransmissionDBDAOdeleteEurCrnAckDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_snd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.integration").append("\n"); 
		query.append("FileName : EurCustomsTransmissionDBDAOdeleteEurCrnAckDSQL").append("\n"); 
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
		query.append("DELETE BKG_CSTMS_EUR_CRN_RCV" ).append("\n"); 
		query.append("WHERE CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("AND MSG_SND_OFC_CD = @[msg_snd_ofc_cd]" ).append("\n"); 
		query.append("AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("AND MSG_FUNC_ID = 'F'" ).append("\n"); 

	}
}