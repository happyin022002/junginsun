/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DMTCollectionOfficeMgtDBDAODeleteYardExceptionCostDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.03
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2012.12.03 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ISD1
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCollectionOfficeMgtDBDAODeleteYardExceptionCostDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Yard Exception code 삭제
	  * </pre>
	  */
	public DMTCollectionOfficeMgtDBDAODeleteYardExceptionCostDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_expt_cost_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.integration").append("\n"); 
		query.append("FileName : DMTCollectionOfficeMgtDBDAODeleteYardExceptionCostDSQL").append("\n"); 
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
		query.append("DELETE DMT_YD_EXPT_COST" ).append("\n"); 
		query.append("WHERE YD_CD = @[yd_cd]           " ).append("\n"); 
		query.append("AND   YD_EXPT_COST_SEQ = @[yd_expt_cost_seq]" ).append("\n"); 
		query.append("AND   CFM_FLG <> 'Y'" ).append("\n"); 

	}
}