/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IndiaCustomsTransmissionDBDAOIndiaMaxSeqModiVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.07.01 경종윤
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.india.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kyoung Jong Yun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IndiaCustomsTransmissionDBDAOIndiaMaxSeqModiVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * IndiaMaxSeqModiVO 생성을 위해
	  * </pre>
	  */
	public IndiaCustomsTransmissionDBDAOIndiaMaxSeqModiVORSQL(){
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
		query.append("''	IDA_SHPR_CD" ).append("\n"); 
		query.append(",''	LOCL_AGN_CD" ).append("\n"); 
		query.append(",''	GEN_DT" ).append("\n"); 
		query.append(",''	GEN_SEQ" ).append("\n"); 
		query.append(",''	CRE_USR_ID" ).append("\n"); 
		query.append(",''	CRE_DT" ).append("\n"); 
		query.append(",''	UPD_USR_ID" ).append("\n"); 
		query.append(",''	UPD_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.india.integration ").append("\n"); 
		query.append("FileName : IndiaCustomsTransmissionDBDAOIndiaMaxSeqModiVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}