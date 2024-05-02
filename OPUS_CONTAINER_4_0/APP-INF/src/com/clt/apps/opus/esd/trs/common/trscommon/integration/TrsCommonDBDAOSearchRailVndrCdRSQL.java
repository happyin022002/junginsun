/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TrsCommonDBDAOSearchRailVndrCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.20
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2011.10.20 황효근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.common.trscommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author HwangHyoKeun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TrsCommonDBDAOSearchRailVndrCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rail Vendor Code List를 조회한다
	  * </pre>
	  */
	public TrsCommonDBDAOSearchRailVndrCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_vndr_svc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.common.trscommon.integration").append("\n"); 
		query.append("FileName : TrsCommonDBDAOSearchRailVndrCdRSQL").append("\n"); 
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
		query.append("SELECT VNDR_SEQ, VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM MDM_VENDOR" ).append("\n"); 
		query.append("WHERE VNDR_SEQ IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT VNDR_SEQ" ).append("\n"); 
		query.append("FROM MDM_CNTR_VNDR_CLSS" ).append("\n"); 
		query.append("WHERE CNTR_VNDR_SVC_CD = @[cntr_vndr_svc_cd]" ).append("\n"); 
		query.append("AND VNDR_COST_CD = @[vndr_cost_cd]" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND VNDR_CNT_CD IN (" ).append("\n"); 
		query.append("#foreach( $vndr_cnt_cd in ${vndr_cnt_cd_list} )" ).append("\n"); 
		query.append("#if($velocityCount < $vndr_cnt_cd_list.size()) '$vndr_cnt_cd', #else '$vndr_cnt_cd' #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 

	}
}