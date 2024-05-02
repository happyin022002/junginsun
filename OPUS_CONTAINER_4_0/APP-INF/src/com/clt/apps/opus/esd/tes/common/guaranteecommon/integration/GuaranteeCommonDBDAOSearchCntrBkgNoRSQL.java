/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GuaranteeCommonDBDAOSearchCntrBkgNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.03
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.12.03 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.common.guaranteecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOng hO lEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GuaranteeCommonDBDAOSearchCntrBkgNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container No.로 BKG No. 조회
	  * </pre>
	  */
	public GuaranteeCommonDBDAOSearchCntrBkgNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.common.guaranteecommon.integration").append("\n"); 
		query.append("FileName : GuaranteeCommonDBDAOSearchCntrBkgNoRSQL").append("\n"); 
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
		query.append("(SELECT" ).append("\n"); 
		query.append("LTRIM(MAX(SYS_CONNECT_BY_PATH(BKG_NO,'|')),'|')" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  ROWNUM ROW_ID, Z.BKG_NO" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  B.BKG_NO" ).append("\n"); 
		query.append("FROM	BKG_BOOKING B, BKG_CONTAINER C" ).append("\n"); 
		query.append("WHERE	B.BKG_NO   = C.BKG_NO" ).append("\n"); 
		query.append("AND		C.CNTR_NO  = @[cntr_no]" ).append("\n"); 
		query.append("AND		B.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append(") Z" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("CONNECT BY PRIOR ROW_ID = ROW_ID - 1" ).append("\n"); 
		query.append("START WITH ROW_ID = 1" ).append("\n"); 
		query.append(") BKG_NO_LIST" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}