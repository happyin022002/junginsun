/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DisposalMgtDBDAOsearchDispBuyrDtlPartDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.11.17 김완규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author WanGyu Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DisposalMgtDBDAOsearchDispBuyrDtlPartDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Disposal Sold Creation 조회시 Buyer를 조회한다.
	  * </pre>
	  */
	public DisposalMgtDBDAOsearchDispBuyrDtlPartDataRSQL(){
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
		params.put("disp_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration").append("\n"); 
		query.append("FileName : DisposalMgtDBDAOsearchDispBuyrDtlPartDataRSQL").append("\n"); 
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
		query.append("SELECT   A.DISP_NO" ).append("\n"); 
		query.append(",A.DISP_DTL_SEQ" ).append("\n"); 
		query.append(",A.MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append(",A.MNR_PRNR_SEQ" ).append("\n"); 
		query.append(",A.EQ_TPSZ_CD" ).append("\n"); 
		query.append(",1 DISP_QTY" ).append("\n"); 
		query.append(",A.DISP_CFM_QTY" ).append("\n"); 
		query.append(",A.PART_UT_AMT" ).append("\n"); 
		query.append(",A.MNR_DISP_CFM_STS_CD" ).append("\n"); 
		query.append(",TO_CHAR(A.MNR_DISP_CFM_DT, 'yyyy-mm-dd') MNR_DISP_CFM_DT" ).append("\n"); 
		query.append(",A.MNR_DISP_CFM_USR_ID" ).append("\n"); 
		query.append(",A.MNR_DISP_DTL_RMK" ).append("\n"); 
		query.append(",A.CRE_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(A.CRE_DT, 'yyyy-mm-dd') CRE_DT" ).append("\n"); 
		query.append(",A.UPD_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(A.UPD_DT, 'yyyy-mm-dd') UPD_DT" ).append("\n"); 
		query.append("FROM MNR_DISP_BUYR_DTL_PART A" ).append("\n"); 
		query.append("WHERE A.DISP_NO = @[disp_no]" ).append("\n"); 
		query.append("AND   A.DISP_DTL_SEQ = @[disp_dtl_seq]" ).append("\n"); 

	}
}