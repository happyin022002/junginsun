/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MexCustomsTransmissionDBDAOsearchCommodityRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.09.17 김도완
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do-Wan, Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MexCustomsTransmissionDBDAOsearchCommodityRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DWKIM, 0370, OUTVO : MxCommodityVO
	  * </pre>
	  */
	public MexCustomsTransmissionDBDAOsearchCommodityRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mex.integration ").append("\n"); 
		query.append("FileName : MexCustomsTransmissionDBDAOsearchCommodityRSQL").append("\n"); 
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
		query.append("SELECT Translate(NVL(CO.CMDT_NM,' '),chr(13)||chr(10),' ') SGC2" ).append("\n"); 
		query.append(",Translate(NVL(REP.REP_CMDT_NM,' '),chr(13)||chr(10),' ') SGC3" ).append("\n"); 
		query.append("FROM BKG_BOOKING BK, MDM_COMMODITY CO, MDM_REP_CMDT REP" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BK.CMDT_CD = CO.CMDT_CD" ).append("\n"); 
		query.append("AND BK.REP_CMDT_CD = REP.REP_CMDT_CD" ).append("\n"); 

	}
}