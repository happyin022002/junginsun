/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ConstraintMasterDBDAOSearchScNoValidForFixedRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.10
*@LastModifier : Arie
*@LastVersion : 1.0
* 2015.07.10 Arie
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Arie
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConstraintMasterDBDAOSearchScNoValidForFixedRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_SPC_0052: 두번째 Sheet내 Control(Fixed) 선택한 후 SC NO 입력시 
	  * 입력한 SC No가 PRI에서 Filed되고 Fixed 되었는지 유효성을 체크합니다.
	  * ConstraintMasterDBDAOSearchScNoValidForFixedRSQL.Query- 패키지 이동으로 신규 생성
	  * </pre>
	  */
	public ConstraintMasterDBDAOSearchScNoValidForFixedRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration").append("\n"); 
		query.append("FileName : ConstraintMasterDBDAOSearchScNoValidForFixedRSQL").append("\n"); 
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
		query.append("SELECT COUNT(A2.SC_NO) AS scNoCnt " ).append("\n"); 
		query.append("FROM PRI_SP_MN              A1" ).append("\n"); 
		query.append("    ,PRI_SP_HDR             A2" ).append("\n"); 
		query.append("    ,PRI_SP_SCP_RT_CMDT_HDR A3 " ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A1.PROP_STS_CD        = 'F'" ).append("\n"); 
		query.append("AND A1.PROP_NO            = A2.PROP_NO" ).append("\n"); 
		query.append("AND A1.PROP_NO            = A3.PROP_NO" ).append("\n"); 
		query.append("AND A1.AMDT_SEQ           = A3.AMDT_SEQ" ).append("\n"); 
		query.append("AND NVL(A3.FX_RT_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("AND A2.SC_NO              = @[sc_no]" ).append("\n"); 

	}
}