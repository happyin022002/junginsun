/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CostAssignDBDAOUpdateCoaRgstBkgUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.11
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2011.01.11 이윤정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.costassign.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoonjung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostAssignDBDAOUpdateCoaRgstBkgUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG cancel 시 CoaRgstBkg 테이블 Cancel Status Update
	  * 2010.08.19 이윤정 [CHM-201005008-01] BKG cancel 시 CoaRgstBkg 테이블 Cancel Status Update
	  * 2011.01.14 이윤정 [CHM-201108215-01] BKG cancel 시 업데이트 로직 중 UPD_DT 항목 추가 
	  * </pre>
	  */
	public CostAssignDBDAOUpdateCoaRgstBkgUSQL(){
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
		query.append("FileName : CostAssignDBDAOUpdateCoaRgstBkgUSQL").append("\n"); 
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
		query.append("UPDATE COA_RGST_BKG" ).append("\n"); 
		query.append("SET BKG_STS_CD = 'X'" ).append("\n"); 
		query.append(",UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE BKG_NO IN (@[bkg_no])" ).append("\n"); 

	}
}