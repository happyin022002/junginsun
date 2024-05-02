/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PRICommonDBDAOCheckRfaNobyBAOfcRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.12
*@LastModifier : 
*@LastVersion : 1.0
* 2011.12.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAOCheckRfaNobyBAOfcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2011.12.05 이석준 [CHM-201114806-01] Login Office가 XXXBA일경우 RFA No or Proposal No가 해당 BA것 일경우만 S/C Viewing이 가능하거나
	  * 조회 가능토록 수정 - searchCheckRfaCtrtRqstOfc Method 추가
	  * </pre>
	  */
	public PRICommonDBDAOCheckRfaNobyBAOfcRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("etc2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAOCheckRfaNobyBAOfcRSQL").append("\n"); 
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
		query.append("select distinct nvl2(a.prop_ofc_cd,'Y','X') as baInd" ).append("\n"); 
		query.append("from pri_rp_mn a,PRI_RP_HDR  b" ).append("\n"); 
		query.append("where a.prop_no(+) = b.prop_no" ).append("\n"); 
		query.append("#if(${etc3} =='P') -- Proposal No" ).append("\n"); 
		query.append("  and B.prop_no = @[etc1]" ).append("\n"); 
		query.append("#else -- RFA No" ).append("\n"); 
		query.append("  and b.rfa_no  = @[etc1]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("and a.PROP_OFC_CD(+) = @[etc2] " ).append("\n"); 

	}
}