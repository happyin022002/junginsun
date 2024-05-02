/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AdjustmentManageDBDAOUpdateReviewStepEndUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.29
*@LastModifier : 
*@LastVersion : 1.0
* 2010.09.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AdjustmentManageDBDAOUpdateReviewStepEndUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Review Step Update
	  * </pre>
	  */
	public AdjustmentManageDBDAOUpdateReviewStepEndUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_sts_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_n2nd_rvw_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_n2nd_rvw_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.integration").append("\n"); 
		query.append("FileName : AdjustmentManageDBDAOUpdateReviewStepEndUSQL").append("\n"); 
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
		query.append("UPDATE TPB_ADJ_N2ND_RVW_HIS" ).append("\n"); 
		query.append("SET N2ND_RVW_AVAL_FLG = 'N'" ).append("\n"); 
		query.append("WHERE N3PTY_NO = @[n3pty_no]" ).append("\n"); 
		query.append("AND ADJ_STS_SEQ = @[adj_sts_seq]" ).append("\n"); 
		query.append("AND ADJ_N2ND_RVW_SEQ = @[adj_n2nd_rvw_seq]" ).append("\n"); 
		query.append("AND ADJ_N2ND_RVW_STS_CD = @[adj_n2nd_rvw_sts_cd]" ).append("\n"); 
		query.append("AND NVL(N2ND_RVW_AVAL_FLG,'X') = 'Y'" ).append("\n"); 

	}
}