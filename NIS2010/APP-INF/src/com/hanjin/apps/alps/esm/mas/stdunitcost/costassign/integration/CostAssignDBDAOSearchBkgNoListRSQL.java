/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CostAssignDBDAOSearchBkgNoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.11
*@LastModifier : 임옥영
*@LastVersion : 1.0
* 2009.11.11 임옥영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author OKYOUNG IM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostAssignDBDAOSearchBkgNoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_BOOKING 테이블에서 BKG_NO 추출   
	  * </pre>
	  */
	public CostAssignDBDAOSearchBkgNoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.integration").append("\n"); 
		query.append("FileName : CostAssignDBDAOSearchBkgNoListRSQL").append("\n"); 
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
		query.append("BKG_NO" ).append("\n"); 
		query.append("FROM BKG_BOOKING" ).append("\n"); 
		query.append("WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("--------------------------------------------------------" ).append("\n"); 
		query.append("--//searchBkgNoList(String bkg_no, String bkg_no_split )" ).append("\n"); 
		query.append("-- ALPS BKG_BOOKING만 기준으로 하도록 변경(기존 SCE_COP_HDR S, MAS_BOOKING_V V)" ).append("\n"); 
		query.append("--SELECT DISTINCT S.BKG_NO" ).append("\n"); 
		query.append("--           FROM SCE_COP_HDR S, MAS_BOOKING_V V" ).append("\n"); 
		query.append("--          WHERE 1 = 1" ).append("\n"); 
		query.append("--            AND S.BKG_NO = ?" ).append("\n"); 
		query.append("--            AND S.BKG_NO = V.KEY_BKG_NO" ).append("\n"); 
		query.append("--      ORDER BY BKG_NO" ).append("\n"); 
		query.append("--------------------------------------------------------" ).append("\n"); 
		query.append("*/" ).append("\n"); 

	}
}