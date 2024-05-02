/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharteriOBunkerDBDAOModifyApSlipApprovalCancelBunkerUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharteriOBunkerDBDAOModifyApSlipApprovalCancelBunkerUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharteriOBunkerDBDAOModifyApSlipApprovalCancelBunkerUSQL
	  * </pre>
	  */
	public TCharteriOBunkerDBDAOModifyApSlipApprovalCancelBunkerUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.integration ").append("\n"); 
		query.append("FileName : TCharteriOBunkerDBDAOModifyApSlipApprovalCancelBunkerUSQL").append("\n"); 
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
		query.append("UPDATE FMS_BUNKER SET" ).append("\n"); 
		query.append("SLP_TP_CD = NULL" ).append("\n"); 
		query.append(",	SLP_FUNC_CD = NULL" ).append("\n"); 
		query.append(",	SLP_OFC_CD = NULL" ).append("\n"); 
		query.append(",	SLP_ISS_DT = NULL" ).append("\n"); 
		query.append(",	SLP_SER_NO = NULL" ).append("\n"); 
		query.append(",	APRO_FLG = 'N'" ).append("\n"); 
		query.append(",	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE	SLP_TP_CD 	= SUBSTR(@[csr_no],1,2)" ).append("\n"); 
		query.append("AND		SLP_FUNC_CD = SUBSTR(@[csr_no],3,1)" ).append("\n"); 
		query.append("AND		SLP_OFC_CD 	= SUBSTR(@[csr_no],4,6)" ).append("\n"); 
		query.append("AND		SLP_ISS_DT 	= SUBSTR(@[csr_no],10,6)" ).append("\n"); 
		query.append("AND		SLP_SER_NO 	= SUBSTR(@[csr_no],16,5)" ).append("\n"); 

	}
}