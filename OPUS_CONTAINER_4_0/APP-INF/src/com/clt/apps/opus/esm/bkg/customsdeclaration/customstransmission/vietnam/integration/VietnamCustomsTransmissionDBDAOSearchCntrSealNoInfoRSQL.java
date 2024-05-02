/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VietnamCustomsTransmissionDBDAOSearchCntrSealNoInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.02
*@LastModifier : 
*@LastVersion : 1.0
* 2014.01.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vietnam.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VietnamCustomsTransmissionDBDAOSearchCntrSealNoInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCntrSealNoInfo
	  * </pre>
	  */
	public VietnamCustomsTransmissionDBDAOSearchCntrSealNoInfoRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vietnam.integration").append("\n"); 
		query.append("FileName : VietnamCustomsTransmissionDBDAOSearchCntrSealNoInfoRSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("SELECT    TRIM(SUBSTR(CNTR_SEAL_NO,1,20)) SEALNBR" ).append("\n"); 
		query.append("FROM      BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("WHERE     BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND       CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND       CNTR_SEAL_SEQ > 0" ).append("\n"); 

	}
}