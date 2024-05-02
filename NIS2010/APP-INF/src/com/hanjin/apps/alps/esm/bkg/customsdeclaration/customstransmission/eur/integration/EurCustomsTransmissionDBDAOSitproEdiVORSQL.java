/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EurCustomsTransmissionDBDAOSitproEdiVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.27
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.11.27 경종윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kyoung Jong Yun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EurCustomsTransmissionDBDAOSitproEdiVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SitproEdiVO 생성을 위해 사용
	  * </pre>
	  */
	public EurCustomsTransmissionDBDAOSitproEdiVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.integration").append("\n"); 
		query.append("FileName : EurCustomsTransmissionDBDAOSitproEdiVORSQL").append("\n"); 
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
		query.append("''VVD_CD" ).append("\n"); 
		query.append(",''BKG_NO" ).append("\n"); 
		query.append(",''POR_CD" ).append("\n"); 
		query.append(",''POL_CD" ).append("\n"); 
		query.append(",''POD_CD" ).append("\n"); 
		query.append(",''DOC_USR_ID -- BKG STAFF" ).append("\n"); 
		query.append(",''OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",''BND_CD" ).append("\n"); 
		query.append(",''CNTR_NO" ).append("\n"); 
		query.append(",''BKG_CGO_TP" ).append("\n"); 
		query.append(",''BKG_SPE_RF" ).append("\n"); 
		query.append(",''BKG_SPE_DG" ).append("\n"); 
		query.append(",''BKG_SPE_AK" ).append("\n"); 
		query.append(",''BKG_SPE_BB" ).append("\n"); 
		query.append(",''CMDT_DESC" ).append("\n"); 
		query.append(",''CMDT_CD" ).append("\n"); 
		query.append(",''BKG_SPE_RD" ).append("\n"); 
		query.append(",''COMP_ID" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",''MRN_NO" ).append("\n"); 
		query.append(",''BLTS" ).append("\n"); 
		query.append(",''BLTP" ).append("\n"); 
		query.append(",''MSNCFM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",''CMDT_NM" ).append("\n"); 
		query.append(",''REP_CMDT_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}