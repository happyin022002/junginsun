/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PRICommonDBDAOSearchCheckValidAfilRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.13
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2015.04.13 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SongHojin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAOSearchCheckValidAfilRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/C Main Customer 의 Type 이 Shipper's Association 의 경우
	  * 입력된 Actual Customer 가 현재 회차안에서 유효한 Affiliate 인지 체크 한다.
	  * </pre>
	  */
	public PRICommonDBDAOSearchCheckValidAfilRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAOSearchCheckValidAfilRSQL").append("\n"); 
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
		query.append("SELECT	SUM ( 1 ) AS CNT" ).append("\n"); 
		query.append("FROM	PRI_SP_AFIL A" ).append("\n"); 
		query.append("WHERE	A.PROP_NO  = @[prop_no]" ).append("\n"); 
		query.append("AND		A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND		A.CUST_CNT_CD = @[etc1]" ).append("\n"); 
		query.append("AND		A.CUST_SEQ    = @[etc2]" ).append("\n"); 
		query.append("AND		A.SRC_INFO_CD <> 'AD'" ).append("\n"); 

	}
}