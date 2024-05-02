/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TESInvoiceCommonDBDAOGetN3ptyBilCSCDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.05
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2010.02.05 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.common.tesinvoicecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOng hO lEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESInvoiceCommonDBDAOGetN3ptyBilCSCDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * (TPB 입력시) COST CODE의 N3PTY_BIL_CS_CD를 가져온다.
	  * </pre>
	  */
	public TESInvoiceCommonDBDAOGetN3ptyBilCSCDRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.common.tesinvoicecommon.integration").append("\n"); 
		query.append("FileName : TESInvoiceCommonDBDAOGetN3ptyBilCSCDRSQL").append("\n"); 
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
		query.append("SELECT  CASE WHEN CNT IS NOT NULL AND CNT >= 1" ).append("\n"); 
		query.append("THEN N3PTY_BIL_CS_CD" ).append("\n"); 
		query.append("END N3PTY_BIL_CS_CD" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  COUNT(N3PTY_BIL_CS_CD) CNT" ).append("\n"); 
		query.append(", N3PTY_BIL_CS_CD" ).append("\n"); 
		query.append("FROM    TES_TML_N3RD_PTY_COST A" ).append("\n"); 
		query.append(", TPB_N3RD_PTY_BIL_TP B" ).append("\n"); 
		query.append("WHERE   1   = 1" ).append("\n"); 
		query.append("AND     A.N3PTY_BIL_CS_CD   = B.N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append("AND     A.LGS_COST_CD       = @[lgs_cost_cd]" ).append("\n"); 
		query.append("AND     B.ACT_FLG           = 'Y'" ).append("\n"); 
		query.append("AND     B.N3PTY_BIL_TP_CD   != 'JO'" ).append("\n"); 
		query.append("GROUP BY N3PTY_BIL_CS_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}