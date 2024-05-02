/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CostAssignDBDAOUpdateCoaBkgExpnDtlWkUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.costassign.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostAssignDBDAOUpdateCoaBkgExpnDtlWkUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG cancel 시 CoaBkgExpnDtlWk 테이블 Cancel Status Update
	  * 2010.08.19 이윤정 [CHM-201005008-01] BKG cancel 시 CoaBkgExpnDtlWk 테이블 Cancel Status Update
	  * 2011.01.14 이윤정 [CHM-201108215-01] BKG cancel 시 업데이트 로직 중 UPD_DT 항목 추가
	  * @SJH.20140814 : COA_BKG_EXPN_DTL_WK -> COA_BKG_EXPN_DTL
	  * </pre>
	  */
	public CostAssignDBDAOUpdateCoaBkgExpnDtlWkUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.costassign.integration").append("\n"); 
		query.append("FileName : CostAssignDBDAOUpdateCoaBkgExpnDtlWkUSQL").append("\n"); 
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
		query.append("UPDATE COA_BKG_EXPN_DTL" ).append("\n"); 
		query.append("       SET BKG_STS_CD = 'X'" ).append("\n"); 
		query.append("		  ,UPD_DT = SYSDATE" ).append("\n"); 
		query.append("    WHERE BKG_NO IN (@[bkg_no])" ).append("\n"); 

	}
}