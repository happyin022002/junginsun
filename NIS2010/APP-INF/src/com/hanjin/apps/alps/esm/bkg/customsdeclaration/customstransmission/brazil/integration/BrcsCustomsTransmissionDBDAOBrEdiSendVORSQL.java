/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BrcsCustomsTransmissionDBDAOBrEdiSendVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.brazil.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BrcsCustomsTransmissionDBDAOBrEdiSendVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BrEdiSendVO 생성을 위해 사용
	  * </pre>
	  */
	public BrcsCustomsTransmissionDBDAOBrEdiSendVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.brazil.integration ").append("\n"); 
		query.append("FileName : BrcsCustomsTransmissionDBDAOBrEdiSendVORSQL").append("\n"); 
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
		query.append("'' BKG_NO" ).append("\n"); 
		query.append(",'' HIS_SEQ" ).append("\n"); 
		query.append(",'' NTC_KND_CD" ).append("\n"); 
		query.append(",'' EDI_ID" ).append("\n"); 
		query.append(",'' BKG_NTC_SND_RSLT_CD" ).append("\n"); 
		query.append(",'' SND_USR_ID" ).append("\n"); 
		query.append(",'' SND_DT" ).append("\n"); 
		query.append(",'' CRE_USR_ID" ).append("\n"); 
		query.append(",'' CRE_DT" ).append("\n"); 
		query.append(",'' UPD_USR_ID" ).append("\n"); 
		query.append(",'' UPD_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}