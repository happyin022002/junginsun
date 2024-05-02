/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BrcsCustomsTransmissionDBDAOBrVslCondVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.02
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.12.02 김보배
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.brazil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BrcsCustomsTransmissionDBDAOBrVslCondVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BrVslCondVO 생성을 위해 사용
	  * </pre>
	  */
	public BrcsCustomsTransmissionDBDAOBrVslCondVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.brazil.integration").append("\n"); 
		query.append("FileName : BrcsCustomsTransmissionDBDAOBrVslCondVORSQL").append("\n"); 
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
		query.append("	 '' COMP_ID												" ).append("\n"); 
		query.append("	,'' BKG_CGO_TP										" ).append("\n"); 
		query.append("	,'' BKG_SPE_BB										" ).append("\n"); 
		query.append("	,'' BL_NO													" ).append("\n"); 
		query.append("	,'' BKG_SPE_DG										" ).append("\n"); 
		query.append("	,'' POD_CD												" ).append("\n"); 
		query.append("	,'' BKG_NO												" ).append("\n"); 
		query.append("	,'' POL_CD												" ).append("\n"); 
		query.append("	,'' VVD_CD												" ).append("\n"); 
		query.append("	,'' BKG_SPE_RD										" ).append("\n"); 
		query.append("	,'' CMDT_CD												" ).append("\n"); 
		query.append("	,'' CMDT_DESC											" ).append("\n"); 
		query.append("	,'' CNTR_NO												" ).append("\n"); 
		query.append("	,'' BKG_SPE_RF										" ).append("\n"); 
		query.append("	,'' BKG_SPE_AK										" ).append("\n"); 
		query.append("	,'' HIDDEN_RATE_TYPE							" ).append("\n"); 
		query.append("	,'' HIDE_CHECK										" ).append("\n"); 
		query.append("	,'' EDI_SEND_ID" ).append("\n"); 
		query.append("	,'' CNT_GUBUN" ).append("\n"); 
		query.append("    ,'' SEARCH_POD_CD" ).append("\n"); 
		query.append("    ,'' CNTR_MF_SEQ" ).append("\n"); 
		query.append("    ,'' MODE_TYPE" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}