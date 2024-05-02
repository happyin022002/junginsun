/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BLDocumentationBLDBDAOSearchMtyCntrStsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.03
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.05.03 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Daeyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationBLDBDAOSearchMtyCntrStsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Cntr의 상태를 확인
	  * </pre>
	  */
	public BLDocumentationBLDBDAOSearchMtyCntrStsRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOSearchMtyCntrStsRSQL").append("\n"); 
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
		query.append("SELECT cnmv_cyc_no," ).append("\n"); 
		query.append("cnmv_sts_cd," ).append("\n"); 
		query.append("cnmv_yr," ).append("\n"); 
		query.append("cnmv_id_no," ).append("\n"); 
		query.append("SYS_AREA_GRP_ID svr_id," ).append("\n"); 
		query.append("ACIAC_DIV_CD," ).append("\n"); 
		query.append("cntr_tpsz_cd," ).append("\n"); 
		query.append("bkg_no," ).append("\n"); 
		query.append("pre_sts_flg," ).append("\n"); 
		query.append("loc_cd," ).append("\n"); 
		query.append("imdt_ext_flg," ).append("\n"); 
		query.append("(SELECT MCNTR_BDL_NO FROM bkg_container WHERE bkg_no = @[bkg_no] AND cntr_no = @[cntr_no]) mcntr_bdl_no," ).append("\n"); 
		query.append("CASE WHEN NVL(LTRIM(LSTM_CD), ' ') = 'SH' THEN 'Y' ELSE 'N' END MTY_SOC_CNTR" ).append("\n"); 
		query.append("FROM mst_container" ).append("\n"); 
		query.append("WHERE cntr_no = @[cntr_no]" ).append("\n"); 

	}
}