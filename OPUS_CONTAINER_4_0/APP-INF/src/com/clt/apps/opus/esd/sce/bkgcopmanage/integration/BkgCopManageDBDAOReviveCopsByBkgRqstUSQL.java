/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BkgCopManageDBDAOReviveCopsByBkgRqstUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.12
*@LastModifier : Yoo
*@LastVersion : 1.0
* 2014.03.12 Yoo
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOReviveCopsByBkgRqstUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * booking 모듈의 호출에 따라 COP status 를 'X' 에서 복원 한다. 본 query 수행 후 container confirm 로직을 수행해서 cop 를 정리한다.
	  * </pre>
	  */
	public BkgCopManageDBDAOReviveCopsByBkgRqstUSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOReviveCopsByBkgRqstUSQL").append("\n"); 
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
		query.append("UPDATE SCE_COP_HDR A" ).append("\n"); 
		query.append("SET COP_STS_CD = CASE WHEN CNTR_NO != 'COMU0000000'" ).append("\n"); 
		query.append("  AND EXISTS (" ).append("\n"); 
		query.append("    SELECT '1'" ).append("\n"); 
		query.append("    FROM SCE_COP_DTL" ).append("\n"); 
		query.append("    WHERE COP_NO = A.COP_NO" ).append("\n"); 
		query.append("      AND ACT_DT IS NOT NULL) THEN 'T' ELSE 'C' END" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND (CNTR_NO = 'COMU0000000' OR EXISTS (SELECT '1' FROM BKG_CONTAINER WHERE BKG_NO = A.BKG_NO) )" ).append("\n"); 

	}
}