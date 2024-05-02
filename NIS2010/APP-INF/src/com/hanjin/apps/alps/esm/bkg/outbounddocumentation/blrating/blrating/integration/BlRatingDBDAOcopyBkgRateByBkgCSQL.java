/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BlRatingDBDAOcopyBkgRateByBkgCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.12
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOcopyBkgRateByBkgCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * insert
	  * </pre>
	  */
	public BlRatingDBDAOcopyBkgRateByBkgCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("targetBkg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOcopyBkgRateByBkgCSQL").append("\n"); 
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
		query.append("insert into bkg_rate(BKG_NO " ).append("\n"); 
		query.append(",RT_BL_TP_CD " ).append("\n"); 
		query.append(",FRT_TERM_CD " ).append("\n"); 
		query.append(",BKG_CTRT_TP_CD " ).append("\n"); 
		query.append(",PPD_RCV_OFC_CD " ).append("\n"); 
		query.append(",PPD_PAYR_CNT_CD " ).append("\n"); 
		query.append(",PPD_PAYR_CUST_SEQ " ).append("\n"); 
		query.append(",CLT_OFC_CD " ).append("\n"); 
		query.append(",CLT_PAYR_CNT_CD " ).append("\n"); 
		query.append(",CLT_PAYR_CUST_SEQ  " ).append("\n"); 
		query.append(",REV_DIV_CD " ).append("\n"); 
		query.append(",BKG_RT_WHF_EXPT_CD " ).append("\n"); 
		query.append(",WHF_SHPR_RGST_NO  " ).append("\n"); 
		query.append(",RT_APLY_DT " ).append("\n"); 
		query.append(",CGO_RCV_DT " ).append("\n"); 
		query.append(",DIFF_RMK " ).append("\n"); 
		query.append(",AUD_STS_CD  " ).append("\n"); 
		query.append(",CRE_USR_ID " ).append("\n"); 
		query.append(",CRE_DT " ).append("\n"); 
		query.append(",UPD_USR_ID " ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("select @[targetBkg] BKG_NO " ).append("\n"); 
		query.append(",RT_BL_TP_CD " ).append("\n"); 
		query.append(",FRT_TERM_CD " ).append("\n"); 
		query.append(",BKG_CTRT_TP_CD " ).append("\n"); 
		query.append(",PPD_RCV_OFC_CD " ).append("\n"); 
		query.append(",PPD_PAYR_CNT_CD " ).append("\n"); 
		query.append(",PPD_PAYR_CUST_SEQ " ).append("\n"); 
		query.append(",CLT_OFC_CD " ).append("\n"); 
		query.append(",CLT_PAYR_CNT_CD " ).append("\n"); 
		query.append(",CLT_PAYR_CUST_SEQ " ).append("\n"); 
		query.append(",REV_DIV_CD " ).append("\n"); 
		query.append(",BKG_RT_WHF_EXPT_CD " ).append("\n"); 
		query.append(",WHF_SHPR_RGST_NO  " ).append("\n"); 
		query.append(",RT_APLY_DT " ).append("\n"); 
		query.append(",CGO_RCV_DT " ).append("\n"); 
		query.append(",DIFF_RMK " ).append("\n"); 
		query.append(",AUD_STS_CD  " ).append("\n"); 
		query.append(",@[usr_id] CRE_USR_ID " ).append("\n"); 
		query.append(",sysdate CRE_DT " ).append("\n"); 
		query.append(",@[usr_id] UPD_USR_ID " ).append("\n"); 
		query.append(",sysdate UPD_DT" ).append("\n"); 
		query.append("from bkg_rate" ).append("\n"); 
		query.append("where bkg_no = @[bkg_no]" ).append("\n"); 

	}
}