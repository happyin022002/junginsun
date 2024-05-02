/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CopDetailReceiveDBDAOCheckRailInterchangeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.28
*@LastModifier : 
*@LastVersion : 1.0
* 2013.05.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copdetailreceive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOCheckRailInterchangeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CopDetailReceiveDBDAOCheckRailInterchangeRSQL
	  * </pre>
	  */
	public CopDetailReceiveDBDAOCheckRailInterchangeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOCheckRailInterchangeRSQL").append("\n"); 
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
		query.append("SELECT NVL( MAX('Y'), 'N') ITCHG_FLG" ).append("\n"); 
		query.append("FROM (SELECT ACT_CD PRE_ACT," ).append("\n"); 
		query.append("NOD_CD PRE_NOD," ).append("\n"); 
		query.append("COP_DTL_SEQ," ).append("\n"); 
		query.append("LEAD ( ACT_CD , 1 ) OVER (ORDER BY COP_DTL_SEQ ASC ) NEXT_ACT," ).append("\n"); 
		query.append("LEAD ( NOD_CD , 1 ) OVER (ORDER BY COP_DTL_SEQ ASC ) NEXT_NOD" ).append("\n"); 
		query.append("FROM SCE_COP_DTL" ).append("\n"); 
		query.append("WHERE COP_NO = @[cop_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE (PRE_ACT, NEXT_ACT) IN (" ).append("\n"); 
		query.append("('FIRRAD', 'FIRRDO')," ).append("\n"); 
		query.append("('FORRAD', 'FORRDO')," ).append("\n"); 
		query.append("('FIRRUD', 'FIRRLO')," ).append("\n"); 
		query.append("('FORRUD', 'FORRLO')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND PRE_NOD = NEXT_NOD" ).append("\n"); 
		query.append("AND PRE_NOD LIKE SUBSTR(@[nod_cd], 1, 5 )||'%'" ).append("\n"); 

	}
}