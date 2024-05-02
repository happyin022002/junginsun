/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AdjustmentManageDBDAOSearchStatusCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.26
*@LastModifier : 변종건
*@LastVersion : 1.0
* 2010.07.26 변종건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Geon Byeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AdjustmentManageDBDAOSearchStatusCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ROC Request 시 중복 저장 여부 확인
	  * </pre>
	  */
	public AdjustmentManageDBDAOSearchStatusCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.integration ").append("\n"); 
		query.append("FileName : AdjustmentManageDBDAOSearchStatusCheckRSQL").append("\n"); 
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
		query.append("SELECT DECODE(COUNT(1),0,'N','Y') VALIDYN" ).append("\n"); 
		query.append("FROM TPB_OTS_GRP_STS B" ).append("\n"); 
		query.append("WHERE B.N3PTY_NO = @[n3pty_no]" ).append("\n"); 
		query.append("AND B.OTS_STS_LST_FLG = 'Y'" ).append("\n"); 
		query.append("AND B.OTS_STS_CD IN ('O','J','M')" ).append("\n"); 

	}
}