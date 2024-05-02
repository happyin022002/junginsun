/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RailBillingReqCreateDBDAOsearchBkgSplitMsgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.03
*@LastModifier : 박연진
*@LastVersion : 1.0
* 2009.12.03 박연진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Yeon-Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailBillingReqCreateDBDAOsearchBkgSplitMsgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SPLIT 된 BKG LIST 추적 쿼리
	  * "BKG_BL번호 담일화 적용 가이드 라인"에 따름 
	  * </pre>
	  */
	public RailBillingReqCreateDBDAOsearchBkgSplitMsgRSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.integration").append("\n"); 
		query.append("FileName : RailBillingReqCreateDBDAOsearchBkgSplitMsgRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT BKG_NO" ).append("\n"); 
		query.append("FROM BKG_BOOKING" ).append("\n"); 
		query.append("WHERE BKG_NO != @[bkg_no] --SPLIT_FLG = 'N' -- mater bkg는 제외해주기위함." ).append("\n"); 
		query.append("START WITH (BKG_NO) IN (" ).append("\n"); 
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append("FROM BKG_BOOKING" ).append("\n"); 
		query.append("WHERE SPLIT_FLG = 'Y'" ).append("\n"); 
		query.append("AND BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("CONNECT BY prior BKG_NO = FM_BKG_NO" ).append("\n"); 
		query.append("ORDER BY BKG_NO" ).append("\n"); 

	}
}