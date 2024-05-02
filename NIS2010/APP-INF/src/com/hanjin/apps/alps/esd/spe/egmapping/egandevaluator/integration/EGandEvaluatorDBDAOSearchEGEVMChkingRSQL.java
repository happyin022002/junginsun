/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EGandEvaluatorDBDAOSearchEGEVMChkingRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.10
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.10 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.egmapping.egandevaluator.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EGandEvaluatorDBDAOSearchEGEVMChkingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Basic Evaluator ID 를 조회 하여 기 입력된 데이터 인지 확인한다.
	  * </pre>
	  */
	public EGandEvaluatorDBDAOSearchEGEVMChkingRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eg_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.spe.egmapping.egandevaluator.integration ").append("\n"); 
		query.append("FileName : EGandEvaluatorDBDAOSearchEGEVMChkingRSQL").append("\n"); 
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
		query.append("SELECT COUNT(1) CHK FROM SPE_EV_GRP_EVR WHERE EG_ID = @[eg_id]" ).append("\n"); 

	}
}