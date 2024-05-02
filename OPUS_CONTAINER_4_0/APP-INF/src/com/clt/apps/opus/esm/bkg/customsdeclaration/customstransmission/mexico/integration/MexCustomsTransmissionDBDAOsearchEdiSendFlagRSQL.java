/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MexCustomsTransmissionDBDAOsearchEdiSendFlagRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.09.25 김도완
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.mexico.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do-Wan, Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MexCustomsTransmissionDBDAOsearchEdiSendFlagRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, 0370, outvo : None
	  * </pre>
	  */
	public MexCustomsTransmissionDBDAOsearchEdiSendFlagRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.mex.integration").append("\n"); 
		query.append("FileName : MexCustomsTransmissionDBDAOsearchEdiSendFlagRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*)" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_NTC_HIS" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("-- 20030930 modified by thhong be_ind = 'IM' -> be_ind = :be_ind_tmp" ).append("\n"); 
		query.append("AND NTC_KND_CD = 'IM'" ).append("\n"); 
		query.append("AND EDI_ID(+) = 'MEXCUS'" ).append("\n"); 

	}
}