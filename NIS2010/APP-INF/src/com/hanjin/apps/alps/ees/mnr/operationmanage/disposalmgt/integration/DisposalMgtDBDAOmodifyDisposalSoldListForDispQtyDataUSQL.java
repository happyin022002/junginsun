/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DisposalMgtDBDAOmodifyDisposalSoldListForDispQtyDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.10.05 김완규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author WanGyu Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DisposalMgtDBDAOmodifyDisposalSoldListForDispQtyDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Disposal Sold Creation (EES_MNR_0160) 삭제시 header 의 dispQty 수정
	  * </pre>
	  */
	public DisposalMgtDBDAOmodifyDisposalSoldListForDispQtyDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("disp_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cnt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration ").append("\n"); 
		query.append("FileName : DisposalMgtDBDAOmodifyDisposalSoldListForDispQtyDataUSQL").append("\n"); 
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
		query.append("UPDATE MNR_DISP_HDR A" ).append("\n"); 
		query.append("SET A.DISP_QTY = (" ).append("\n"); 
		query.append("SELECT (SELECT DISP_QTY" ).append("\n"); 
		query.append("FROM MNR_DISP_HDR" ).append("\n"); 
		query.append("WHERE DISP_NO = @[disp_no]" ).append("\n"); 
		query.append(") - @[del_cnt]" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE A.DISP_NO = @[disp_no]" ).append("\n"); 

	}
}