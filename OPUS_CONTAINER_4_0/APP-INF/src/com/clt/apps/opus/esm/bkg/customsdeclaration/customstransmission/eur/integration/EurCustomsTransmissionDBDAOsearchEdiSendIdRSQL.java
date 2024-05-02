/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EurCustomsTransmissionDBDAOsearchEdiSendIdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.10.12 경종윤
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kyoung Jong Yun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EurCustomsTransmissionDBDAOsearchEdiSendIdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDI SEND ID를 조회한다.
	  * </pre>
	  */
	public EurCustomsTransmissionDBDAOsearchEdiSendIdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.integration").append("\n"); 
		query.append("FileName : EurCustomsTransmissionDBDAOsearchEdiSendIdRSQL").append("\n"); 
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
		query.append("SELECT NVL(MCHN_TRD_PRNR_ID, 'DSEN_MAN') MCHN_TRD_PRNR_ID" ).append("\n"); 
		query.append("FROM BKG_EDI_GRP" ).append("\n"); 
		query.append("WHERE CUST_TRD_PRNR_ID = @[ofc_cd] --> ofc_cd" ).append("\n"); 
		query.append("AND ESVC_GRP_DELT_FLG = 'Y'" ).append("\n"); 

	}
}