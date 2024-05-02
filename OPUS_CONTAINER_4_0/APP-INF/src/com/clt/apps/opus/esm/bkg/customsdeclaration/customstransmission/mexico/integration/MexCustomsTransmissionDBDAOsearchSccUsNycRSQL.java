/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MexCustomsTransmissionDBDAOsearchSccUsNycRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.09.18 김도완
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.mexico.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do-Wan, Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MexCustomsTransmissionDBDAOsearchSccUsNycRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, 0370, outVo : MxUsaNycVO
	  * </pre>
	  */
	public MexCustomsTransmissionDBDAOsearchSccUsNycRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.mex.integration ").append("\n"); 
		query.append("FileName : MexCustomsTransmissionDBDAOsearchSccUsNycRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) exist_scc_usnyc" ).append("\n"); 
		query.append("FROM BKG_BOOKING B" ).append("\n"); 
		query.append(",BKG_BL_DOC D" ).append("\n"); 
		query.append(",MDM_LOCATION L" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND B.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("AND D.BDR_FLG = 'Y'" ).append("\n"); 
		query.append("AND B.POD_CD <> 'USNYC'" ).append("\n"); 
		query.append("AND B.DEL_CD = L.LOC_CD" ).append("\n"); 
		query.append("AND L.SCC_CD = 'USNYC'" ).append("\n"); 

	}
}