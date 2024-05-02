/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EurCustomsTransmissionDBDAOsearchCommodityDescByBkgNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.10.14 경종윤
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

public class EurCustomsTransmissionDBDAOsearchCommodityDescByBkgNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Commodity 정보 조회
	  * </pre>
	  */
	public EurCustomsTransmissionDBDAOsearchCommodityDescByBkgNoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.integration").append("\n"); 
		query.append("FileName : EurCustomsTransmissionDBDAOsearchCommodityDescByBkgNoRSQL").append("\n"); 
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
		query.append("SELECT Translate(NVL(M.CMDT_NM,' '),chr(13)||chr(10), ' ') CMDT_NM" ).append("\n"); 
		query.append(", Translate(NVL(R.REP_CMDT_NM,' '),chr(13)||chr(10), ' ') REP_CMDT_NM" ).append("\n"); 
		query.append("FROM BKG_BOOKING B" ).append("\n"); 
		query.append(", MDM_COMMODITY M" ).append("\n"); 
		query.append(", MDM_REP_CMDT R" ).append("\n"); 
		query.append("WHERE B.CMDT_CD = M.CMDT_CD" ).append("\n"); 
		query.append("and R.REP_CMDT_CD = M.REP_CMDT_CD" ).append("\n"); 
		query.append("AND B.BKG_NO	= @[bkg_no]" ).append("\n"); 

	}
}