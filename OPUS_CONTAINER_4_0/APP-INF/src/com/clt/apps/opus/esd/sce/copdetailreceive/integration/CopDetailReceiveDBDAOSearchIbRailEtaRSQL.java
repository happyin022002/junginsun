/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CopDetailReceiveDBDAOSearchIbRailEtaRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.08
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.copdetailreceive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOSearchIbRailEtaRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchIbRailEta
	  * </pre>
	  */
	public CopDetailReceiveDBDAOSearchIbRailEtaRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOSearchIbRailEtaRSQL").append("\n"); 
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
		query.append("SELECT NVL(TO_NUMBER(SUBSTR(" ).append("\n"); 
		query.append("(SELECT MIN(COP_NO||COP_DTL_SEQ)" ).append("\n"); 
		query.append("FROM   SCE_COP_DTL" ).append("\n"); 
		query.append("WHERE  COP_NO      = @[cop_no]" ).append("\n"); 
		query.append("AND    COP_DTL_SEQ > 6000" ).append("\n"); 
		query.append("AND    ACT_CD      = 'FIRRDO'" ).append("\n"); 
		query.append("AND    ACT_STS_MAPG_CD = 'RL'" ).append("\n"); 
		query.append("AND    ACT_DT  IS NOT NULL" ).append("\n"); 
		query.append("AND    (COP_NO||COP_DTL_SEQ) < (SELECT MIN(COP_NO||COP_DTL_SEQ)" ).append("\n"); 
		query.append("FROM  SCE_COP_DTL" ).append("\n"); 
		query.append("WHERE  COP_NO      = @[cop_no]" ).append("\n"); 
		query.append("AND    COP_DTL_SEQ > 6000" ).append("\n"); 
		query.append("AND    ACT_CD      = 'FIRRAD'" ).append("\n"); 
		query.append("AND    ACT_DT      IS NULL" ).append("\n"); 
		query.append("AND    EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("FROM   SCE_COP_DTL" ).append("\n"); 
		query.append("WHERE  COP_NO      = @[cop_no]" ).append("\n"); 
		query.append("AND    COP_DTL_SEQ > 6000" ).append("\n"); 
		query.append("AND    ACT_DT      IS NOT NULL))) ,15,4)),0) cop_evntp_chk" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}