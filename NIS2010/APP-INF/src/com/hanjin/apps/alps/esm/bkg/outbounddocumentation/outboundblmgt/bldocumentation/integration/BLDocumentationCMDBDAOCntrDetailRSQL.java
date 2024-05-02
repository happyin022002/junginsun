/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BLDocumentationCMDBDAOCntrDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.03
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOCntrDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLDocumentationCMDBDAOCntrDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOCntrDetailRSQL").append("\n"); 
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
		query.append("#if (${like_flg} == 'N')" ).append("\n"); 
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append(",      CNTR_NO" ).append("\n"); 
		query.append(",      CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",      CNMV_STS_CD" ).append("\n"); 
		query.append(",      '' SEAL1_NO" ).append("\n"); 
		query.append(",      'M' SEAL1_KND_CD" ).append("\n"); 
		query.append(",      'SH' SEAL1_PTY_TP_CD" ).append("\n"); 
		query.append(",      '' SEAL2_NO" ).append("\n"); 
		query.append(",      'M' SEAL2_KND_CD" ).append("\n"); 
		query.append(",      'SH' SEAL2_PTY_TP_CD" ).append("\n"); 
		query.append(",      '' CNTR_CFM_FLG" ).append("\n"); 
		query.append(",      'N' CNTR_PRT_FLG" ).append("\n"); 
		query.append(",      '1' CNTR_VOL_QTY" ).append("\n"); 
		query.append(",      CRNT_YD_CD ORG_YD_CD" ).append("\n"); 
		query.append(",      TO_CHAR(CNMV_DT, 'YYYYMMDDHH24MI') CNMV_EVNT_DT" ).append("\n"); 
		query.append(",      '' CGO_RCV_DT" ).append("\n"); 
		query.append(",      '' HNGR_FLG" ).append("\n"); 
		query.append(",      '' DCGO_FLG" ).append("\n"); 
		query.append(",      '' BB_CGO_FLG" ).append("\n"); 
		query.append(",      '' AWK_CGO_FLG" ).append("\n"); 
		query.append(",      '' RC_FLG" ).append("\n"); 
		query.append(",      '' RD_CGO_FLG" ).append("\n"); 
		query.append(",      DECODE(LSTM_CD, 'SH', 'Y', 'N') SOC_FLG" ).append("\n"); 
		query.append(",      '' PO_NO" ).append("\n"); 
		query.append(",      '' DIFF_RMK" ).append("\n"); 
		query.append(",      '' CRE_USR_ID" ).append("\n"); 
		query.append(",      '' UPD_USR_ID" ).append("\n"); 
		query.append("FROM   MST_CONTAINER A" ).append("\n"); 
		query.append("WHERE  CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND    ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append(",      CNTR_NO" ).append("\n"); 
		query.append(",      CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",      CNMV_STS_CD" ).append("\n"); 
		query.append(",      '' SEAL1_NO" ).append("\n"); 
		query.append(",      'M' SEAL1_KND_CD" ).append("\n"); 
		query.append(",      'SH' SEAL1_PTY_TP_CD" ).append("\n"); 
		query.append(",      '' SEAL2_NO" ).append("\n"); 
		query.append(",      'M' SEAL2_KND_CD" ).append("\n"); 
		query.append(",      'SH' SEAL2_PTY_TP_CD" ).append("\n"); 
		query.append(",      '' CNTR_CFM_FLG" ).append("\n"); 
		query.append(",      'N' CNTR_PRT_FLG" ).append("\n"); 
		query.append(",      '1' CNTR_VOL_QTY" ).append("\n"); 
		query.append(",      CRNT_YD_CD ORG_YD_CD" ).append("\n"); 
		query.append(",      TO_CHAR(CNMV_DT, 'YYYYMMDDHH24MI') CNMV_EVNT_DT" ).append("\n"); 
		query.append(",      '' CGO_RCV_DT" ).append("\n"); 
		query.append(",      '' HNGR_FLG" ).append("\n"); 
		query.append(",      '' DCGO_FLG" ).append("\n"); 
		query.append(",      '' BB_CGO_FLG" ).append("\n"); 
		query.append(",      '' AWK_CGO_FLG" ).append("\n"); 
		query.append(",      '' RC_FLG" ).append("\n"); 
		query.append(",      '' RD_CGO_FLG" ).append("\n"); 
		query.append(",      DECODE(LSTM_CD, 'SH', 'Y', 'N') SOC_FLG" ).append("\n"); 
		query.append(",      '' PO_NO" ).append("\n"); 
		query.append(",      '' DIFF_RMK" ).append("\n"); 
		query.append(",      '' CRE_USR_ID" ).append("\n"); 
		query.append(",      '' UPD_USR_ID" ).append("\n"); 
		query.append("FROM   MST_CONTAINER A" ).append("\n"); 
		query.append("WHERE  CNTR_NO like @[cntr_no]||'%'" ).append("\n"); 
		query.append("AND    ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}