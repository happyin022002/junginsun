/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchChnAgentRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.25
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.03.25 류대영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Daeyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOSearchChnAgentRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * booking no의 5,6 번째 자리의 2자리 문자가 bkg_chn_agn 테이블에 chn_agn_cd로 있는지 확인한다.
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchChnAgentRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOSearchChnAgentRSQL").append("\n"); 
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
		query.append("select count(1) CNT" ).append("\n"); 
		query.append("from bkg_chn_agn" ).append("\n"); 
		query.append("where chn_agn_cd = substr(@[bkg_no], 5, 2)" ).append("\n"); 
		query.append("and rownum = 1" ).append("\n"); 

	}
}