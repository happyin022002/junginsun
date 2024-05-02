/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DaoNameDAOSqlNameRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.05.27 경종윤
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kyoung Jong Yun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DaoNameDAOSqlNameRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 00
	  * </pre>
	  */
	public DaoNameDAOSqlNameRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
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
		query.append(",'' VVD_CD" ).append("\n"); 
		query.append(",'' BL_NO" ).append("\n"); 
		query.append(", '' POL_CD" ).append("\n"); 
		query.append(", '' POD_CD" ).append("\n"); 
		query.append(", '' CNTR_NO" ).append("\n"); 
		query.append(", '' EDI_SEND_ID" ).append("\n"); 
		query.append(", '' COMP_ID" ).append("\n"); 
		query.append(", '' HIDDEN_RATE_TYPE" ).append("\n"); 
		query.append(", '' BKG_CGO_TP" ).append("\n"); 
		query.append(", '' BKG_SPE_RF" ).append("\n"); 
		query.append(", '' BKG_SPE_DG" ).append("\n"); 
		query.append(", '' BKG_SPE_AK" ).append("\n"); 
		query.append(", '' BKG_SPE_BB" ).append("\n"); 
		query.append(", '' CMDT_DESC" ).append("\n"); 
		query.append(", '' CMDT_CD" ).append("\n"); 
		query.append(", '' BKG_SPE_RD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.integration").append("\n"); 
		query.append("FileName : DaoNameDAOSqlNameRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}