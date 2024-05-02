/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchKorDoAttorneyValChkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.10
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOsearchKorDoAttorneyValChkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ...
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchKorDoAttorneyValChkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_atty_biz_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_atty_biz_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchKorDoAttorneyValChkRSQL").append("\n"); 
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
		query.append("SELECT DECODE( COUNT(*),0, 'N',    -- 위임장 없음" ).append("\n"); 
		query.append("                           MAX( CASE WHEN  EXP_DT < SYSDATE  " ).append("\n"); 
		query.append("                                      THEN  'E'   -- 만료일 지남" ).append("\n"); 
		query.append("                                     ELSE   'Y'" ).append("\n"); 
		query.append("                                END" ).append("\n"); 
		query.append("                              ) " ).append("\n"); 
		query.append("              )      " ).append("\n"); 
		query.append("FROM BKG_DO_ATTY_DTL" ).append("\n"); 
		query.append("WHERE FM_ATTY_BIZ_NO = @[fm_atty_biz_no]  --위임자  ( 세금계산서 공급받는자)" ).append("\n"); 
		query.append("AND TO_ATTY_BIZ_NO   = @[to_atty_biz_no]  -- 수임자 ( D/O신청자)" ).append("\n"); 

	}
}