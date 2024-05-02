/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerMovementFinderDBDAOSearchWoNoByEqrRefInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementFinderDBDAOSearchWoNoByEqrRefInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchWoNoByEqrRefInfo
	  * </pre>
	  */
	public ContainerMovementFinderDBDAOSearchWoNoByEqrRefInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_pln_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.integration").append("\n"); 
		query.append("FileName : ContainerMovementFinderDBDAOSearchWoNoByEqrRefInfoRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT (T.TRSP_WO_OFC_CTY_CD||T.TRSP_WO_SEQ) AS WO_NO" ).append("\n"); 
		query.append("FROM EQR_PLAN_V V," ).append("\n"); 
		query.append("    TRS_TRSP_SVC_ORD T" ).append("\n"); 
		query.append("WHERE V.REF_ID = T.REF_ID(+)" ).append("\n"); 
		query.append("AND V.TP_CD IN ('T.VVD EXE','TRW EXE','ONH EXE','OFH EXE','LCC')" ).append("\n"); 
		query.append("AND T.TRSP_WO_OFC_CTY_CD||T.TRSP_WO_SEQ IS NOT NULL" ).append("\n"); 
		query.append("AND V.REF_ID = @[mty_pln_no]" ).append("\n"); 

	}
}