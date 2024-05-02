/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CndCustomsTransmissionDBDAOsearchCndCstmsRcvLogDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.07.17 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndCustomsTransmissionDBDAOsearchCndCstmsRcvLogDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCndCstmsRcvLogDtl
	  * </pre>
	  */
	public CndCustomsTransmissionDBDAOsearchCndCstmsRcvLogDtlRSQL(){
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
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rcv_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.integration").append("\n"); 
		query.append("FileName : CndCustomsTransmissionDBDAOsearchCndCstmsRcvLogDtlRSQL").append("\n"); 
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
		query.append("SELECT  MSG_DESC" ).append("\n"); 
		query.append("FROM  BKG_CSTMS_ADV_RCV_LOG_DTL" ).append("\n"); 
		query.append("WHERE  CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("AND  IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND  RCV_DT = TO_DATE(@[rcv_dt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("AND  RCV_SEQ = @[rcv_seq]" ).append("\n"); 
		query.append("ORDER BY RCV_MSG_DTL_SEQ" ).append("\n"); 

	}
}