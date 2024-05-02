/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DryWetClaimDBDAOSearchDryWetClaimNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.19
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.10.19 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon, Seyeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DryWetClaimDBDAOSearchDryWetClaimNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Dry Wet Claim No 조회
	  * </pre>
	  */
	public DryWetClaimDBDAOSearchDryWetClaimNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dw_clm_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.integration ").append("\n"); 
		query.append("FileName : DryWetClaimDBDAOSearchDryWetClaimNoRSQL").append("\n"); 
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
		query.append("SELECT @[dw_clm_tp_cd]||TO_CHAR(SYSDATE, 'YYYYMM')||LPAD(TO_NUMBER(NVL(MAX(SUBSTR(DW_CLM_NO,10)),0))+1,2,'0') DW_CLM_NO" ).append("\n"); 
		query.append("FROM   CNI_DW_CLM" ).append("\n"); 
		query.append("WHERE  DW_CLM_NO LIKE @[dw_clm_tp_cd]||TO_CHAR(SYSDATE, 'YYYYMM')||'%'" ).append("\n"); 
		query.append("AND    DW_CLM_TP_CD = @[dw_clm_tp_cd]" ).append("\n"); 

	}
}