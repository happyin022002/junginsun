/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : MalaysiaCustomsTransmissionDBDAOSearchCmInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MalaysiaCustomsTransmissionDBDAOSearchCmInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CM Info 정보 조회
	  * </pre>
	  */
	public MalaysiaCustomsTransmissionDBDAOSearchCmInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.integration").append("\n"); 
		query.append("FileName : MalaysiaCustomsTransmissionDBDAOSearchCmInfoRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append(" CNTR_NO" ).append("\n"); 
		query.append(",CNTR_MF_SEQ CM_SEQ" ).append("\n"); 
		query.append(",PCK_QTY CM_PKG" ).append("\n"); 
		query.append(",PCK_TP_CD CM_PKG_UNIT" ).append("\n"); 
		query.append(",CNTR_MF_WGT CM_WGT" ).append("\n"); 
		query.append(",WGT_UT_CD CM_WGT_UNIT" ).append("\n"); 
		query.append(",MEAS_QTY CM_MEA" ).append("\n"); 
		query.append(",MEAS_UT_CD CM_MEA_UNIT" ).append("\n"); 
		query.append(",HAMO_TRF_CD HS_CODE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM BKG_CNTR_MF_DESC" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("--AND   CNTR_NO = [cntr_no]     --CNTR와 별개로 가기로 했음. SBE/임경하 수석님이 MIG확인 사항임." ).append("\n"); 

	}
}