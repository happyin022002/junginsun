/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DisposalMgtDBDAOaddContractDisposalBuyerDTLDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.12
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.11.12 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author park myoung sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DisposalMgtDBDAOaddContractDisposalBuyerDTLDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addContractDisposalBuyerDTLData
	  * </pre>
	  */
	public DisposalMgtDBDAOaddContractDisposalBuyerDTLDataCSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.integration").append("\n"); 
		query.append("FileName : DisposalMgtDBDAOaddContractDisposalBuyerDTLDataCSQL").append("\n"); 
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
		query.append("INSERT INTO MNR_DISP_BUYR_DTL_PART(" ).append("\n"); 
		query.append("DISP_NO" ).append("\n"); 
		query.append(",DISP_DTL_SEQ" ).append("\n"); 
		query.append(",MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append(",MNR_PRNR_SEQ" ).append("\n"); 
		query.append(",EQ_TPSZ_CD" ).append("\n"); 
		query.append(",DISP_QTY" ).append("\n"); 
		query.append(",DISP_CFM_QTY" ).append("\n"); 
		query.append(",PART_UT_AMT" ).append("\n"); 
		query.append(",MNR_DISP_CFM_STS_CD" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("B.DISP_NO" ).append("\n"); 
		query.append(",B.DISP_DTL_SEQ" ).append("\n"); 
		query.append(",A.MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append(",A.MNR_PRNR_SEQ" ).append("\n"); 
		query.append(",B.EQ_TPSZ_CD" ).append("\n"); 
		query.append(",B.DISP_QTY" ).append("\n"); 
		query.append(",DECODE(B.DISP_UT_TP_CD,'E',1,B.DISP_QTY) AS DISP_CFM_QTY" ).append("\n"); 
		query.append(",B.DISP_UT_PRC AS PART_UT_AMT" ).append("\n"); 
		query.append(",'C' AS MNR_DISP_CFM_STS_CD" ).append("\n"); 
		query.append(",B.CRE_USR_ID AS CRE_USR_ID" ).append("\n"); 
		query.append(",SYSDATE AS CRE_DT" ).append("\n"); 
		query.append(",B.UPD_USR_ID AS UPD_USR_ID" ).append("\n"); 
		query.append(",SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("FROM MNR_DISP_BUYR_PART A,MNR_DISP_DTL B" ).append("\n"); 
		query.append("WHERE A.DISP_NO = @[disp_no]" ).append("\n"); 
		query.append("AND A.DISP_NO(+) = B.DISP_NO" ).append("\n"); 

	}
}