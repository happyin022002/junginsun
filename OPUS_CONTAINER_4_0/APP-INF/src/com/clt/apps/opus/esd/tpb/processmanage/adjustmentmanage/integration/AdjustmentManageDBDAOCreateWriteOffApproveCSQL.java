/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AdjustmentManageDBDAOCreateWriteOffApproveCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.25
*@LastModifier : 변종건
*@LastVersion : 1.0
* 2011.02.25 변종건
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Geon Byeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AdjustmentManageDBDAOCreateWriteOffApproveCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Write-off 승인 및 거절 처리
	  * </pre>
	  */
	public AdjustmentManageDBDAOCreateWriteOffApproveCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ra_rmk1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_stl_fwrd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_chk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_stl_clt_ofc_cng_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_file_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.integration").append("\n"); 
		query.append("FileName : AdjustmentManageDBDAOCreateWriteOffApproveCSQL").append("\n"); 
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
		query.append("CALL TPB_ADJ_PKG.CRE_ADJ_APP_PRC(" ).append("\n"); 
		query.append("	@[s_chk]," ).append("\n"); 
		query.append("  	@[n3pty_no]," ).append("\n"); 
		query.append("  	@[s_stl_clt_ofc_cng_amt]," ).append("\n"); 
		query.append("  	@[s_stl_fwrd_ofc_cd]," ).append("\n"); 
		query.append("  	''," ).append("\n"); 
		query.append("	@[s_ra_rmk1]," ).append("\n"); 
		query.append("	@[s_user_ofc_cd]," ).append("\n"); 
		query.append("	@[s_user_id]," ).append("\n"); 
		query.append("  	@[s_file_no]," ).append("\n"); 
		query.append("  	@[s_ra_rmk1]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}