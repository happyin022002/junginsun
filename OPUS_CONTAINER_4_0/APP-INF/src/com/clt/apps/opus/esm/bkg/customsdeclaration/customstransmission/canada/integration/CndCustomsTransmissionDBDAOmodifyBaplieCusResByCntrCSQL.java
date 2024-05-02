/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CndCustomsTransmissionDBDAOmodifyBaplieCusResByCntrCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.28
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.10.28 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndCustomsTransmissionDBDAOmodifyBaplieCusResByCntrCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 수정
	  * </pre>
	  */
	public CndCustomsTransmissionDBDAOmodifyBaplieCusResByCntrCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("err_result",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("err_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("err_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_bat_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.integration").append("\n"); 
		query.append("FileName : CndCustomsTransmissionDBDAOmodifyBaplieCusResByCntrCSQL").append("\n"); 
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
		query.append("UPDATE BKG_CSTMS_ADV_STWG_CNTR" ).append("\n"); 
		query.append("SET " ).append("\n"); 
		query.append("     RSPN_MSG_RCV_DT = TO_DATE(@[rcv_dt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("    ,RSPN_ERR_RSLT_CD = @[err_result]" ).append("\n"); 
		query.append("    ,RSPN_ERR_CD = @[err_code]" ).append("\n"); 
		query.append("    ,RSPN_ERR_DESC = @[err_desc]" ).append("\n"); 
		query.append("    ,UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("    AND STWG_SND_ID =@[crr_bat_no]" ).append("\n"); 

	}
}