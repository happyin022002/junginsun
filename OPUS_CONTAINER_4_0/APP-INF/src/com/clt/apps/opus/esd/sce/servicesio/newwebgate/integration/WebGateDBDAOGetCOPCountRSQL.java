/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WebGateDBDAOGetCOPCountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 윤권영
*@LastVersion : 1.0
* 2009.10.14 윤권영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.servicesio.newwebgate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yun Kwon Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WebGateDBDAOGetCOPCountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COP Count를 체크한다.
	  * </pre>
	  */
	public WebGateDBDAOGetCOPCountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.servicesio.newwebgate.integration").append("\n"); 
		query.append("FileName : WebGateDBDAOGetCOPCountRSQL").append("\n"); 
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
		query.append("SELECT COUNT(A.COP_NO) AS COP_NUM" ).append("\n"); 
		query.append("FROM SCE_COP_HDR A," ).append("\n"); 
		query.append("SCE_COP_DTL B" ).append("\n"); 
		query.append("WHERE A.COP_NO = B.COP_NO" ).append("\n"); 
		query.append("AND A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND B.ACT_CD = @[act_cd]" ).append("\n"); 
		query.append("#if(${iMode} == 0)" ).append("\n"); 
		query.append("#if(\"MIB\" == ${mov_tp})" ).append("\n"); 
		query.append("AND A.COP_STS_CD = 'T'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A.COP_STS_CD IN ('C','T')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#elseif(${iMode} == 1)" ).append("\n"); 
		query.append("#if(\"IB\" == ${direction})" ).append("\n"); 
		query.append("AND A.COP_STS_CD = 'T'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A.COP_STS_CD IN ('C','T')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}