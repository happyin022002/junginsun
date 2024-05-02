/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UnmatchBLDBDAOSearchAuditRtAplyDtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.04
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2010.10.04 김태경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UnmatchBLDBDAOSearchAuditRtAplyDtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchAuditRtAplyDt
	  * </pre>
	  */
	public UnmatchBLDBDAOSearchAuditRtAplyDtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ca_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
		query.append("FileName : UnmatchBLDBDAOSearchAuditRtAplyDtRSQL").append("\n"); 
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
		query.append("SELECT  TO_CHAR(BKG_REV_APLY_DT_PKG.BKG_GET_REV_APLY_DT_FNC(@[bkg_no], @[ca_flg]), 'YYYYMMDD') RT_APLY_DT" ).append("\n"); 
		query.append("FROM    DUAL" ).append("\n"); 

	}
}