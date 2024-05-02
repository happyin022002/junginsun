/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RestuffingContainerRegistrationDBDAOGetCNTRMovSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.12
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2010.05.12 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RestuffingContainerRegistrationDBDAOGetCNTRMovSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Comtainer Movement Seq Table 정보 가져오는 쿼리 일반!
	  * 모든 Container Movement SEQ는 하나로 처리한다
	  * </pre>
	  */
	public RestuffingContainerRegistrationDBDAOGetCNTRMovSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_type",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.integration").append("\n"); 
		query.append("FileName : RestuffingContainerRegistrationDBDAOGetCNTRMovSeqRSQL").append("\n"); 
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
		query.append("SELECT CNMV_LVL_NO, FCNTR_FLG" ).append("\n"); 
		query.append("FROM CTM_MVMT_SEQ" ).append("\n"); 
		query.append("WHERE BKG_CGO_TP_CD = @[cgo_type] AND MVMT_STS_CD = @[mvmt_sts_cd]" ).append("\n"); 

	}
}