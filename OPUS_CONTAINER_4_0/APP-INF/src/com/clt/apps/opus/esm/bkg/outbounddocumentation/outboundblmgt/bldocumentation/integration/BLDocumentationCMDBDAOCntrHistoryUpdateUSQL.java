/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLDocumentationCMDBDAOCntrHistoryUpdateUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOCntrHistoryUpdateUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ContainerMovementMgtDBDAO의 History Update
	  * </pre>
	  */
	public BLDocumentationCMDBDAOCntrHistoryUpdateUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_id_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOCntrHistoryUpdateUSQL").append("\n"); 
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
		query.append("#if (${del_flg} == '1')" ).append("\n"); 
		query.append("UPDATE BKG_CONTAINER" ).append("\n"); 
		query.append("        SET   CNMV_YR       = @[cnmv_yr]" ).append("\n"); 
		query.append("             ,CNMV_ID_NO    = @[cnmv_id_no]" ).append("\n"); 
		query.append("             ,ORG_YD_CD     = @[org_yd_cd]" ).append("\n"); 
		query.append("             ,DEST_YD_CD    = @[dest_yd_cd]" ).append("\n"); 
		query.append("             ,CNMV_STS_CD   = @[mvmt_sts_cd]" ).append("\n"); 
		query.append("             ,CNMV_EVNT_DT  = TO_DATE(@[cnmv_evnt_dt], 'yyyy-mm-dd hh24:mi')" ).append("\n"); 
		query.append("             ,DIFF_RMK      = NVL(@[cnmv_rmk],DIFF_RMK)" ).append("\n"); 
		query.append("#if (${mvmt_sts_cd} == 'OP')              " ).append("\n"); 
		query.append("             ,CGO_RCV_DT    = NULL" ).append("\n"); 
		query.append("             ,CGO_RCV_YD_CD = NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  WHERE       CNTR_NO       = @[cntr_no]" ).append("\n"); 
		query.append("        AND   CNMV_CYC_NO   = @[cnmv_cyc_no]" ).append("\n"); 
		query.append("#elseif (${del_flg} == '2')" ).append("\n"); 
		query.append("UPDATE BKG_CONTAINER" ).append("\n"); 
		query.append("        SET   CGO_RCV_DT    = TO_DATE(@[cnmv_evnt_dt], 'yyyy-mm-dd hh24:mi')" ).append("\n"); 
		query.append("             ,CGO_RCV_YD_CD = @[org_yd_cd]" ).append("\n"); 
		query.append("  WHERE       CNTR_NO       = @[cntr_no]" ).append("\n"); 
		query.append("        AND   CNMV_CYC_NO   = @[cnmv_cyc_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("UPDATE BKG_CONTAINER" ).append("\n"); 
		query.append("       SET   CNMV_CYC_NO = 9999," ).append("\n"); 
		query.append("          CNMV_STS_CD = 'MT'," ).append("\n"); 
		query.append("          CNMV_EVNT_DT  = TO_DATE(@[cnmv_evnt_dt], 'yyyy-mm-dd hh24:mi')," ).append("\n"); 
		query.append("          DIFF_RMK      = 'MT repo VL deleted'" ).append("\n"); 
		query.append("WHERE  CNTR_NO       = @[cntr_no]" ).append("\n"); 
		query.append("  AND  (CNMV_CYC_NO  = @[cnmv_cyc_no]   OR    CNMV_CYC_NO  = 9999)" ).append("\n"); 
		query.append("  AND  BKG_NO        = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}