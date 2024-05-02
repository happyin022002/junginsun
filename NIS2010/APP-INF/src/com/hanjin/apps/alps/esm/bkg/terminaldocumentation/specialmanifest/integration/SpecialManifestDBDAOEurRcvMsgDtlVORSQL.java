/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialManifestDBDAOEurRcvMsgDtlVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.10.23 경종윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kyoung Jong Yun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialManifestDBDAOEurRcvMsgDtlVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EurRcvMsgDtlVO 생성을 위해 사용
	  * </pre>
	  */
	public SpecialManifestDBDAOEurRcvMsgDtlVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.integration ").append("\n"); 
		query.append("FileName : SpecialManifestDBDAOEurRcvMsgDtlVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("'' KEY_VAL" ).append("\n"); 
		query.append(",'' RCV_LOG_SEQ" ).append("\n"); 
		query.append(",''	EUR_EDI_MSG_TP_ID" ).append("\n"); 
		query.append(",''	MSG_RCV_NO" ).append("\n"); 
		query.append(",''	RCV_LOG_SEQ" ).append("\n"); 
		query.append(",'' RCV_LOG_ERR_SEQ" ).append("\n"); 
		query.append(",'' CSTMS_ERR_ID" ).append("\n"); 
		query.append(",'' CSTMS_ERR_MSG" ).append("\n"); 
		query.append(",'' CSTMS_ERR_REF_NO1" ).append("\n"); 
		query.append(",'' CSTMS_ERR_REF_NO2" ).append("\n"); 
		query.append(",'' CRE_USR_ID" ).append("\n"); 
		query.append(",'' CRE_DT" ).append("\n"); 
		query.append(",'' UPD_USR_ID" ).append("\n"); 
		query.append(",'' UPD_DT" ).append("\n"); 
		query.append(",'' MSG_TP_ID" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}